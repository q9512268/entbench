package org.sunflow.core;
public class Texture {
    private java.lang.String filename;
    private boolean isLinear;
    private org.sunflow.image.Bitmap bitmap;
    private int loaded;
    Texture(java.lang.String filename, boolean isLinear) { super();
                                                           this.filename =
                                                             filename;
                                                           this.isLinear =
                                                             isLinear;
                                                           loaded = 0; }
    private synchronized void load() { if (loaded != 0) return;
                                       try { org.sunflow.system.UI.printInfo(
                                                                     org.sunflow.system.UI.Module.
                                                                       TEX,
                                                                     "Reading texture bitmap from: \"%s\" ...",
                                                                     filename);
                                             bitmap = new org.sunflow.image.Bitmap(
                                                        filename,
                                                        isLinear);
                                             if (bitmap.
                                                   getWidth(
                                                     ) ==
                                                   0 ||
                                                   bitmap.
                                                   getHeight(
                                                     ) ==
                                                   0)
                                                 bitmap =
                                                   null;
                                       }
                                       catch (java.io.IOException e) {
                                           org.sunflow.system.UI.
                                             printError(
                                               org.sunflow.system.UI.Module.
                                                 TEX,
                                               "%s",
                                               e.
                                                 getMessage(
                                                   ));
                                       }
                                       loaded = 1;
    }
    public org.sunflow.image.Bitmap getBitmap() {
        if (loaded ==
              0)
            load(
              );
        return bitmap;
    }
    public org.sunflow.image.Color getPixel(float x,
                                            float y) {
        org.sunflow.image.Bitmap bitmap =
          getBitmap(
            );
        if (bitmap ==
              null)
            return org.sunflow.image.Color.
                     BLACK;
        x =
          x -
            (int)
              x;
        y =
          y -
            (int)
              y;
        if (x <
              0)
            x++;
        if (y <
              0)
            y++;
        float dx =
          (float)
            x *
          (bitmap.
             getWidth(
               ) -
             1);
        float dy =
          (float)
            y *
          (bitmap.
             getHeight(
               ) -
             1);
        int ix0 =
          (int)
            dx;
        int iy0 =
          (int)
            dy;
        int ix1 =
          (ix0 +
             1) %
          bitmap.
          getWidth(
            );
        int iy1 =
          (iy0 +
             1) %
          bitmap.
          getHeight(
            );
        float u =
          dx -
          ix0;
        float v =
          dy -
          iy0;
        u =
          u *
            u *
            (3.0F -
               2.0F *
               u);
        v =
          v *
            v *
            (3.0F -
               2.0F *
               v);
        float k00 =
          (1.0F -
             u) *
          (1.0F -
             v);
        org.sunflow.image.Color c00 =
          bitmap.
          getPixel(
            ix0,
            iy0);
        float k01 =
          (1.0F -
             u) *
          v;
        org.sunflow.image.Color c01 =
          bitmap.
          getPixel(
            ix0,
            iy1);
        float k10 =
          u *
          (1.0F -
             v);
        org.sunflow.image.Color c10 =
          bitmap.
          getPixel(
            ix1,
            iy0);
        float k11 =
          u *
          v;
        org.sunflow.image.Color c11 =
          bitmap.
          getPixel(
            ix1,
            iy1);
        org.sunflow.image.Color c =
          org.sunflow.image.Color.
          mul(
            k00,
            c00);
        c.
          madd(
            k01,
            c01);
        c.
          madd(
            k10,
            c10);
        c.
          madd(
            k11,
            c11);
        return c;
    }
    public org.sunflow.math.Vector3 getNormal(float x,
                                              float y,
                                              org.sunflow.math.OrthoNormalBasis basis) {
        float[] rgb =
          getPixel(
            x,
            y).
          getRGB(
            );
        return basis.
          transform(
            new org.sunflow.math.Vector3(
              2 *
                rgb[0] -
                1,
              2 *
                rgb[1] -
                1,
              2 *
                rgb[2] -
                1)).
          normalize(
            );
    }
    public org.sunflow.math.Vector3 getBump(float x,
                                            float y,
                                            org.sunflow.math.OrthoNormalBasis basis,
                                            float scale) {
        org.sunflow.image.Bitmap bitmap =
          getBitmap(
            );
        if (bitmap ==
              null)
            return basis.
              transform(
                new org.sunflow.math.Vector3(
                  0,
                  0,
                  1));
        float dx =
          1.0F /
          (bitmap.
             getWidth(
               ) -
             1);
        float dy =
          1.0F /
          (bitmap.
             getHeight(
               ) -
             1);
        float b0 =
          getPixel(
            x,
            y).
          getLuminance(
            );
        float bx =
          getPixel(
            x +
              dx,
            y).
          getLuminance(
            );
        float by =
          getPixel(
            x,
            y +
              dy).
          getLuminance(
            );
        return basis.
          transform(
            new org.sunflow.math.Vector3(
              scale *
                (bx -
                   b0) /
                dx,
              scale *
                (by -
                   b0) /
                dy,
              1)).
          normalize(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/uHrfufJb2QHCf8HEzXy9BgoAAA=");
}
