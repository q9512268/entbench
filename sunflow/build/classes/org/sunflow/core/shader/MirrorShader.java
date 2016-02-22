package org.sunflow.core.shader;
public class MirrorShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color color;
    public MirrorShader() { super();
                            this.color = org.sunflow.image.Color.WHITE; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        color =
          pl.
            getColor(
              "color",
              color);
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (!state.
              includeSpecular(
                ))
            return org.sunflow.image.Color.
                     BLACK;
        state.
          faceforward(
            );
        float cos =
          state.
          getCosND(
            );
        float dn =
          2 *
          cos;
        org.sunflow.math.Vector3 refDir =
          new org.sunflow.math.Vector3(
          );
        refDir.
          x =
          dn *
            state.
              getNormal(
                ).
              x +
            state.
              getRay(
                ).
              getDirection(
                ).
              x;
        refDir.
          y =
          dn *
            state.
              getNormal(
                ).
              y +
            state.
              getRay(
                ).
              getDirection(
                ).
              y;
        refDir.
          z =
          dn *
            state.
              getNormal(
                ).
              z +
            state.
              getRay(
                ).
              getDirection(
                ).
              z;
        org.sunflow.core.Ray refRay =
          new org.sunflow.core.Ray(
          state.
            getPoint(
              ),
          refDir);
        cos =
          1 -
            cos;
        float cos2 =
          cos *
          cos;
        float cos5 =
          cos2 *
          cos2 *
          cos;
        org.sunflow.image.Color ret =
          org.sunflow.image.Color.
          white(
            );
        ret.
          sub(
            color);
        ret.
          mul(
            cos5);
        ret.
          add(
            color);
        return ret.
          mul(
            state.
              traceReflection(
                refRay,
                0));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        float avg =
          color.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd >=
              avg)
            return;
        state.
          faceforward(
            );
        float cos =
          state.
          getCosND(
            );
        power.
          mul(
            color).
          mul(
            1.0F /
              avg);
        float dn =
          2 *
          cos;
        org.sunflow.math.Vector3 dir =
          new org.sunflow.math.Vector3(
          );
        dir.
          x =
          dn *
            state.
              getNormal(
                ).
              x +
            state.
              getRay(
                ).
              getDirection(
                ).
              x;
        dir.
          y =
          dn *
            state.
              getNormal(
                ).
              y +
            state.
              getRay(
                ).
              getDirection(
                ).
              y;
        dir.
          z =
          dn *
            state.
              getNormal(
                ).
              z +
            state.
              getRay(
                ).
              getDirection(
                ).
              z;
        state.
          traceReflectionPhoton(
            new org.sunflow.core.Ray(
              state.
                getPoint(
                  ),
              dir),
            power);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/Cg/I9v84b2/99O/9ezX8xr2/wBzpwPUxyMAAA==");
}
