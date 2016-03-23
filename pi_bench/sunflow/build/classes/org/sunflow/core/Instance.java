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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HOGfpyJfsld8++q/G7O4FlczAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "l1Q5VON0AFEJAvnN0bQjct6mNQvmlDD0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "skm/BAY/AAA=");
}
