package org.sunflow.core.shader;
public class WireframeShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color lineColor;
    private org.sunflow.image.Color fillColor;
    private float width;
    private float cosWidth;
    public WireframeShader() { super();
                               lineColor = org.sunflow.image.Color.BLACK;
                               fillColor = org.sunflow.image.Color.WHITE;
                               width = (float) (java.lang.Math.PI * 0.5 /
                                                  4096);
                               cosWidth = (float) java.lang.Math.cos(width);
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        lineColor =
          pl.
            getColor(
              "line",
              lineColor);
        fillColor =
          pl.
            getColor(
              "fill",
              fillColor);
        width =
          pl.
            getFloat(
              "width",
              width);
        cosWidth =
          (float)
            java.lang.Math.
            cos(
              width);
        return true;
    }
    public org.sunflow.image.Color getFillColor(org.sunflow.core.ShadingState state) {
        return fillColor;
    }
    public org.sunflow.image.Color getLineColor(org.sunflow.core.ShadingState state) {
        return lineColor;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        org.sunflow.math.Point3[] p =
          new org.sunflow.math.Point3[3];
        if (!state.
              getTrianglePoints(
                p))
            return getFillColor(
                     state);
        org.sunflow.math.Point3 center =
          state.
          getPoint(
            );
        org.sunflow.math.Matrix4 w2c =
          state.
          getWorldToCamera(
            );
        center =
          w2c.
            transformP(
              center);
        for (int i =
               0;
             i <
               3;
             i++)
            p[i] =
              w2c.
                transformP(
                  state.
                    getInstance(
                      ).
                    transformObjectToWorld(
                      p[i]));
        float cn =
          1.0F /
          (float)
            java.lang.Math.
            sqrt(
              center.
                x *
                center.
                  x +
                center.
                  y *
                center.
                  y +
                center.
                  z *
                center.
                  z);
        for (int i =
               0,
               i2 =
                 2;
             i <
               3;
             i2 =
               i,
               i++) {
            float t =
              (center.
                 x -
                 p[i].
                   x) *
              (p[i2].
                 x -
                 p[i].
                   x);
            t +=
              (center.
                 y -
                 p[i].
                   y) *
                (p[i2].
                   y -
                   p[i].
                     y);
            t +=
              (center.
                 z -
                 p[i].
                   z) *
                (p[i2].
                   z -
                   p[i].
                     z);
            t /=
              p[i].
                distanceToSquared(
                  p[i2]);
            float projx =
              (1 -
                 t) *
              p[i].
                x +
              t *
              p[i2].
                x;
            float projy =
              (1 -
                 t) *
              p[i].
                y +
              t *
              p[i2].
                y;
            float projz =
              (1 -
                 t) *
              p[i].
                z +
              t *
              p[i2].
                z;
            float n =
              1.0F /
              (float)
                java.lang.Math.
                sqrt(
                  projx *
                    projx +
                    projy *
                    projy +
                    projz *
                    projz);
            float dot =
              projx *
              center.
                x +
              projy *
              center.
                y +
              projz *
              center.
                z;
            if (dot *
                  n *
                  cn >=
                  cosWidth)
                return getLineColor(
                         state);
        }
        return getFillColor(
                 state);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fsAfsfnwfzGBppXqHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
