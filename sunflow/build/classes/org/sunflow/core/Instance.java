package org.sunflow.core;
public class Instance implements org.sunflow.core.RenderObject {
    private org.sunflow.math.Matrix4 o2w;
    private org.sunflow.math.Matrix4 w2o;
    private org.sunflow.math.BoundingBox bounds;
    private org.sunflow.core.Geometry geometry;
    private org.sunflow.core.Shader[] shaders;
    private org.sunflow.core.Modifier[] modifiers;
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String geometryName =
          pl.
          getString(
            "geometry",
            null);
        if (geometry ==
              null ||
              geometryName !=
              null) {
            if (geometryName ==
                  null) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      GEOM,
                    "geometry parameter missing - unable to create instance");
                return false;
            }
            geometry =
              api.
                lookupGeometry(
                  geometryName);
            if (geometry ==
                  null) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      GEOM,
                    "Geometry \"%s\" was not declared yet - instance is invalid",
                    geometryName);
                return false;
            }
        }
        java.lang.String[] shaderNames =
          pl.
          getStringArray(
            "shaders",
            null);
        if (shaderNames !=
              null) {
            shaders =
              (new org.sunflow.core.Shader[shaderNames.
                                             length]);
            for (int i =
                   0;
                 i <
                   shaders.
                     length;
                 i++) {
                shaders[i] =
                  api.
                    lookupShader(
                      shaderNames[i]);
                if (shaders[i] ==
                      null)
                    org.sunflow.system.UI.
                      printWarning(
                        org.sunflow.system.UI.Module.
                          GEOM,
                        "Shader \"%s\" was not declared yet - ignoring",
                        shaderNames[i]);
            }
        }
        else {
            
        }
        java.lang.String[] modifierNames =
          pl.
          getStringArray(
            "modifiers",
            null);
        if (modifierNames !=
              null) {
            modifiers =
              (new org.sunflow.core.Modifier[modifierNames.
                                               length]);
            for (int i =
                   0;
                 i <
                   modifiers.
                     length;
                 i++) {
                modifiers[i] =
                  api.
                    lookupModifier(
                      modifierNames[i]);
                if (modifiers[i] ==
                      null)
                    org.sunflow.system.UI.
                      printWarning(
                        org.sunflow.system.UI.Module.
                          GEOM,
                        "Modifier \"%s\" was not declared yet - ignoring",
                        modifierNames[i]);
            }
        }
        org.sunflow.math.Matrix4 transform =
          pl.
          getMatrix(
            "transform",
            o2w);
        if (transform !=
              o2w) {
            o2w =
              transform;
            if (o2w !=
                  null) {
                w2o =
                  o2w.
                    inverse(
                      );
                if (w2o ==
                      null) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          GEOM,
                        "Unable to compute transform inverse - determinant is: %g",
                        o2w.
                          determinant(
                            ));
                    return false;
                }
            }
            else
                o2w =
                  (w2o =
                     null);
        }
        return true;
    }
    public void updateBounds() { bounds = geometry.
                                            getWorldBounds(
                                              o2w);
    }
    public boolean hasGeometry(org.sunflow.core.Geometry g) {
        return geometry ==
          g;
    }
    public void removeShader(org.sunflow.core.Shader s) {
        if (shaders !=
              null) {
            for (int i =
                   0;
                 i <
                   shaders.
                     length;
                 i++)
                if (shaders[i] ==
                      s)
                    shaders[i] =
                      null;
        }
    }
    public void removeModifier(org.sunflow.core.Modifier m) {
        if (modifiers !=
              null) {
            for (int i =
                   0;
                 i <
                   modifiers.
                     length;
                 i++)
                if (modifiers[i] ==
                      m)
                    modifiers[i] =
                      null;
        }
    }
    public org.sunflow.math.BoundingBox getBounds() {
        return bounds;
    }
    int getNumPrimitives() { return geometry.getNumPrimitives(
                                               );
    }
    void intersect(org.sunflow.core.Ray r, org.sunflow.core.IntersectionState state) {
        org.sunflow.core.Ray localRay =
          r.
          transform(
            w2o);
        state.
          current =
          this;
        geometry.
          intersect(
            localRay,
            state);
        r.
          setMax(
            localRay.
              getMax(
                ));
    }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        geometry.
          prepareShadingState(
            state);
        if (state.
              getNormal(
                ) !=
              null &&
              state.
              getGeoNormal(
                ) !=
              null)
            state.
              correctShadingNormal(
                );
        if (state.
              getModifier(
                ) !=
              null)
            state.
              getModifier(
                ).
              modify(
                state);
    }
    public org.sunflow.core.Shader getShader(int i) {
        if (shaders ==
              null ||
              i <
              0 ||
              i >=
              shaders.
                length)
            return null;
        return shaders[i];
    }
    public org.sunflow.core.Modifier getModifier(int i) {
        if (modifiers ==
              null ||
              i <
              0 ||
              i >=
              modifiers.
                length)
            return null;
        return modifiers[i];
    }
    public org.sunflow.math.Point3 transformObjectToWorld(org.sunflow.math.Point3 p) {
        return o2w ==
          null
          ? new org.sunflow.math.Point3(
          p)
          : o2w.
          transformP(
            p);
    }
    public org.sunflow.math.Point3 transformWorldToObject(org.sunflow.math.Point3 p) {
        return o2w ==
          null
          ? new org.sunflow.math.Point3(
          p)
          : w2o.
          transformP(
            p);
    }
    public org.sunflow.math.Vector3 transformNormalObjectToWorld(org.sunflow.math.Vector3 n) {
        return o2w ==
          null
          ? new org.sunflow.math.Vector3(
          n)
          : w2o.
          transformTransposeV(
            n);
    }
    public org.sunflow.math.Vector3 transformNormalWorldToObject(org.sunflow.math.Vector3 n) {
        return o2w ==
          null
          ? new org.sunflow.math.Vector3(
          n)
          : o2w.
          transformTransposeV(
            n);
    }
    public org.sunflow.math.Vector3 transformVectorObjectToWorld(org.sunflow.math.Vector3 v) {
        return o2w ==
          null
          ? new org.sunflow.math.Vector3(
          v)
          : o2w.
          transformV(
            v);
    }
    public org.sunflow.math.Vector3 transformVectorWorldToObject(org.sunflow.math.Vector3 v) {
        return o2w ==
          null
          ? new org.sunflow.math.Vector3(
          v)
          : w2o.
          transformV(
            v);
    }
    org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return geometry.
          getBakingPrimitives(
            );
    }
    org.sunflow.core.Geometry getGeometry() {
        return geometry;
    }
    public Instance() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TcOJFPkYfzz0P3Y/M9FRMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C9DsVn3fftf2vdfG+I1tHPzCNsEsuVppH9od05R9SFpp" +
       "Je2uViutlDQXrVbSalev1XsFLoYhhZAMYaihpEM8JUMeTYxJM8m0M5TWbacE" +
       "JpQWJtOmmTSQTjskpUwh09IOpE2PtN/rft+9n/Hc6505ZyWd1//3f53/OTp6" +
       "8TulWwK/VPZca2tYbnhJS8NLK6t+Kdx6WnCJousjxQ+0RddSgoAHzy6rb/7t" +
       "O7//w48u7zpXOi+X7lUcxw2V0HSdgNMC14q1BV268+gpZml2EJbuoldKrEBR" +
       "aFoQbQbhM3TpdceahqUn6QMSIEACBEiAChKg9lEt0Oj1mhPZ3byF4oTBpvS3" +
       "S3t06byn5uSFpcev7MRTfMXe72ZUIAA9XMzvBQCqaJz6pccOse8wnwL88TL0" +
       "/N/7mbt+56bSnXLpTtOZ5OSogIgQDCKXbrc1e675QXux0BZy6W5H0xYTzTcV" +
       "y8wKuuXSPYFpOEoY+dohk/KHkaf5xZhHnLtdzbH5kRq6/iE83dSsxcHdLbql" +
       "GADr/UdYdwjx/DkAeJsJCPN1RdUOmty8Np1FWHr0ZItDjE8OQAXQ9IKthUv3" +
       "cKibHQU8KN2zk52lOAY0CX3TMUDVW9wIjBKWHrpmpzmvPUVdK4Z2OSw9eLLe" +
       "aFcEat1aMCJvEpbecLJa0ROQ0kMnpHRMPt9h3/GRdzt951xB80JTrZz+i6DR" +
       "IycacZqu+ZqjaruGt7+N/oRy/xc+dK5UApXfcKLyrs4/fs/33vn2R17+0q7O" +
       "j12lznC+0tTwsvqZ+R1fe1P36dZNORkXPTcwc+FfgbxQ/9F+yTOpByzv/sMe" +
       "88JLB4Uvc1+UnvtN7dvnSreRpfOqa0U20KO7Vdf2TEvzCc3RfCXUFmTpVs1Z" +
       "dItysnQBXNOmo+2eDnU90EKydLNVPDrvFveARTroImfRBXBtOrp7cO0p4bK4" +
       "Tr1SqXQBpNJPgHRXafcr/sMSDy1dW4MUVXFMx4VGvpvjzwXqLBQo1AJwvQCl" +
       "ngsFkaNbbgIFvgq5vnF4r7q+BpGFEavapVy7vNeo3zTHc1eytwdY/aaThm4B" +
       "G+m71kLzL6vPRx3sey9d/oNzh4q/z4mw9EYwxKX9IS7lQ1w6GKK0t1f0fF8+" +
       "1E6AgP1rYMjAxd3+9ORvUe/60JtvAprjJTcD3uVVoWt72u6R6R8McFktvfzJ" +
       "5H3CeyvnSueudJk5eeDRbXnzUe7oDh3akydN5Wr93vnBP//+5z7xrHtkNFf4" +
       "4H1bPt0yt8U3n2Sk76raAni3o+7f9pjye5e/8OyT50o3AwMHTi1UgBICf/HI" +
       "yTGusMlnDvxbjuUWAFh3fVux8qIDp3RbuPTd5OhJIeE7iuu7AY8vlfazK7Q2" +
       "L73Xy/P7dhqRC+0EisJ//o2J98t/9NW/qBbsPnC1dx6bvCZa+Mwx8847u7Mw" +
       "5LuPdID3NQ3U+0+fHP3dj3/ngz9VKACo8cTVBnwyz7vArIEIAZt/9kub//iN" +
       "P/3MH547UpoQzG/R3DLVdAfyr8FvD6T/l6ccXP5gZ5r3dPf9w2OHDsLLR37L" +
       "EW3AVVjArHINenLq2O7C1E1lbmm5xv7VnU/Bv/ffP3LXTics8ORApd7+yh0c" +
       "PX9jp/TcH/zM/36k6GZPzaeqI/4dVdv5v3uPem77vrLN6Ujf9/WHf+n3lV8G" +
       "nhR4r8DMtMIhlQp+lAoBVgpelIscOlGG5NmjwXFDuNLWjoUUl9WP/uF3Xy98" +
       "9599r6D2ypjkuNwZxXtmp2p59lgKun/gpNX3lWAJ6tVeZn/6LuvlH4IeZdCj" +
       "CibiYOgDL5NeoSX7tW+58Mf/4l/d/66v3VQ6h5dus1xlgSuFwZVuBZquBUvg" +
       "oFLvb75zp83JxQOVTkunwO8U5MHi7lZA4NPX9jV4HlIcmeuDPxha8/f/5/9z" +
       "igmFl7nKTHqivQy9+KmHuj/57aL9kbnnrR9JT3teEH4dtUV+0/5f5958/l+f" +
       "K12QS3ep+7GdoFhRbkQyiGeCg4APxH9XlF8Zm+wm4mcO3dmbTrqaY8OedDRH" +
       "Hh9c57Xz69tO+Jbbcy4/CNLd+77l7pO+Za9UXLyzaPJ4kT+ZZz9+YMoXPN+M" +
       "gV0WPT8dlm5ykaSo9gYQKByfZ2wwF19iFBBupbWdx8rzap61d3JuXFMnnjlN" +
       "8T37FN9zDYqpa1CcX/YOiU2QIlbATxA0eJUEPQrSvfsE3XsNgsY/CkHn527k" +
       "LIIDBr7pFAM7eTkIWDtueoJm7lXS/AhI9+3TfN81aJZ/FJovGhoIc0J/e0D1" +
       "6fCC2K9xguSfepUkPwzSG/ZJfsM1SFZ/FJIvBEsFuK8AuJSnru1SCve9C5pf" +
       "+LUnvvreF574s8IDXjQDYHht37hKFH+szXdf/Ma3v/76h18qIoab50qwM8GT" +
       "y5/Tq5srFi0FybdfyYd7zuLDgRQeOCWFyQ70gZPd2w/hCkbn2fqAh+7VeXgu" +
       "v3xrCPyM6SjWocpammOEy7O988g3bRBexPvrFOjZe76x/tSff3a3Bjnpik9U" +
       "1j70/If/+tJHnj93bOX3xKnF1/E2u9VfQeDrCyrzye3xs0YpWuDf+tyzn/+N" +
       "Zz+4o+qeK9cxGFimf/bf/9+vXPrkN798lZD6JiDF/GblpYcMPrfj2oFAdoFB" +
       "7tjBWs91tDzGOCjbxdume+lwnQ0K01Oi8ktvuzaPmUJrjqah33//f3uI/8nl" +
       "u15FoP3oCR6d7PIfMi9+mXiL+rFzpZsOJ6VTi/ArGz1z5VR0m6+Fke/wV0xI" +
       "D++0r+Bfnj1xRiz0wTPKfi7PfhYoqJrzdyeOM6r/Qlo64ZAWr9IhPQ7S/fuG" +
       "eP81HNIv/igO6dZd2Jm7pPzJ8sph7jtrmGt7Xeagz2ta/McPiPylsyw+z/wd" +
       "pXlWVEry7PnTyp7fPptn7z2tvfn9+3fDFq1fSdT/4IyyX8mzF/LswztKzqj7" +
       "mVNy/ugrynnnNvZAgHMLcgm9VMnvf/3qTLpp3y2eD4pttGPcAk54ZalPHqxh" +
       "BCAKYH9Priz0QGh3HfmE3UbUCUKf/pEJBb7hjqPOaNcxnvn5//LRr/ziE98A" +
       "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" +
       "vmyHsFjRGHlG1pvKMKyUNRWsGzVVI2DG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "zA/kPgAA");
}
