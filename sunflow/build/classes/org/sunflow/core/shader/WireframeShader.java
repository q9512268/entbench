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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NBb9DjaPM1I7QqEO9SZ31zzf/OTMs9LWceXMzVOMtbB58Oe3+aynp9H+DDYn" +
       "hPYRpz7zaf/MJ6M9lmWdtgqdM9e+GOv1tP/BNNq/gM3zjNSA9oPgMw5qepQ/" +
       "+z8rzxPJWnh6bQ16Z658MdbCWMSV53rwqV+exgLnsZlipM6SJQYYNZDUmQ3t" +
       "PigpHdWVuGuXczO3SwbOub4bNDxHLsi7qhfXy/Kzx+or5x+75xK/zcleAddC" +
       "5ZlIq6r3qOPplxuwgMJ1qxUHH1HEXCiUrcW1HqCp6HC5fyboLzLS4KcHI+DL" +
       "S3YJnMdDxrDK4j0v0duMlAARdt8xHNhq4MdnPPKFxJEvE/DkfeIB57nXM3WW" +
       "xXvbg3md/6/EycFp8d+SqHzm2Jb++6/e9pS4bZJVaWICZ6mBElFcfGXz+LKi" +
       "szlzlfd0XJv1XNUKp45pFAK7Hr3I42zrIDAN3PJm31WM1Z69kXnr+JqXfnKg" +
       "/A0oiXeQgMRI0478w3HGSENZtCOSXwpDjcPviLo6Hh9fuyrxl3f47QMRpfPi" +
       "4vRRueqjgxPLrEAoSKp6SRmUaDTDT+13j2uDVB41c+rq8pie1rL/UpmFvinh" +
       "/1C4VWxj1mVH8aaSkbb8I0b+7W01uA41N+DsOE2dr+pJG4b3K7eqKuIUrQx+" +
       "Fo30GYZztjrHrW4YPP7+jE3qv9WoDAAEHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f8dnX/3rT3w7O334X7nsjjRiKAAA");
}
