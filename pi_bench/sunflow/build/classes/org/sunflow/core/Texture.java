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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dxpG6m7LNHhqtWevQ5/zRxxu/h8mWupn3B0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T3w9P3z4f1gf5dsuKAAA");
}
