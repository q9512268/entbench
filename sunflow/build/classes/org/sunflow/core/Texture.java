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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v5EfQPw/CMlQXDwoAAA=");
}
