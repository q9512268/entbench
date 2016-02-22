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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "trZuzRFH+OepyJfsFd+++i++0NIsYTMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XW0HbsVyy7GS0WybayuLtUcobWiEbMpk");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "A7//tt964U+3pz3/PzqgBWQYPwAA");
}
