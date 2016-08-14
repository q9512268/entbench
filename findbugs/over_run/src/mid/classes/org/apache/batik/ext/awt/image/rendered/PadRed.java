package org.apache.batik.ext.awt.image.rendered;
public class PadRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    static final boolean DEBUG = false;
    org.apache.batik.ext.awt.image.PadMode padMode;
    java.awt.RenderingHints hints;
    public PadRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                  java.awt.Rectangle bounds,
                  org.apache.batik.ext.awt.image.PadMode padMode,
                  java.awt.RenderingHints hints) { super(src, bounds, src.
                                                           getColorModel(
                                                             ),
                                                         fixSampleModel(
                                                           src,
                                                           bounds),
                                                         bounds.
                                                           x,
                                                         bounds.
                                                           y,
                                                         null);
                                                   this.padMode = padMode;
                                                   if (DEBUG) { java.lang.System.
                                                                  out.
                                                                  println(
                                                                    "Src: " +
                                                                    src +
                                                                    " Bounds: " +
                                                                    bounds +
                                                                    " Off: " +
                                                                    src.
                                                                      getTileGridXOffset(
                                                                        ) +
                                                                    ", " +
                                                                    src.
                                                                      getTileGridYOffset(
                                                                        ));
                                                   }
                                                   this.
                                                     hints =
                                                     hints;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        if (wrR.
              intersects(
                srcR)) {
            java.awt.Rectangle r =
              wrR.
              intersection(
                srcR);
            java.awt.image.WritableRaster srcWR;
            srcWR =
              wr.
                createWritableChild(
                  r.
                    x,
                  r.
                    y,
                  r.
                    width,
                  r.
                    height,
                  r.
                    x,
                  r.
                    y,
                  null);
            src.
              copyData(
                srcWR);
        }
        if (padMode ==
              org.apache.batik.ext.awt.image.PadMode.
                ZERO_PAD) {
            handleZero(
              wr);
        }
        else
            if (padMode ==
                  org.apache.batik.ext.awt.image.PadMode.
                    REPLICATE) {
                handleReplicate(
                  wr);
            }
            else
                if (padMode ==
                      org.apache.batik.ext.awt.image.PadMode.
                        WRAP) {
                    handleWrap(
                      wr);
                }
        return wr;
    }
    protected static class ZeroRecter {
        java.awt.image.WritableRaster wr;
        int bands;
        static int[] zeros = null;
        public ZeroRecter(java.awt.image.WritableRaster wr) {
            super(
              );
            this.
              wr =
              wr;
            this.
              bands =
              wr.
                getSampleModel(
                  ).
                getNumBands(
                  );
        }
        public void zeroRect(java.awt.Rectangle r) {
            synchronized (this)  {
                if (zeros ==
                      null ||
                      zeros.
                        length <
                      r.
                        width *
                      bands)
                    zeros =
                      (new int[r.
                                 width *
                                 bands]);
            }
            for (int y =
                   0;
                 y <
                   r.
                     height;
                 y++) {
                wr.
                  setPixels(
                    r.
                      x,
                    r.
                      y +
                      y,
                    r.
                      width,
                    1,
                    zeros);
            }
        }
        public static org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter getZeroRecter(java.awt.image.WritableRaster wr) {
            if (org.apache.batik.ext.awt.image.GraphicsUtil.
                  is_INT_PACK_Data(
                    wr.
                      getSampleModel(
                        ),
                    false))
                return new org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter_INT_PACK(
                  wr);
            else
                return new org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter(
                  wr);
        }
        public static void zeroRect(java.awt.image.WritableRaster wr) {
            org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
              getZeroRecter(
                wr);
            zr.
              zeroRect(
                wr.
                  getBounds(
                    ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "eR8b+m+GO03t1R4AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "vG/vAmnhFLdKUaE7hN+7zlPlv+uAwRfujUL9IoU5BPJTf07b6w/97z+7Qwkl" +
           "/txl5740X4Rf++mn8e/7ajn/AATF7GezOzEbpHuHufWfd/746J3X/+sR9KAI" +
           "3ZJPcklesuMivESQP4WnCSbINy/0X8yF9hv/i2dA97bLIHRu2csQdNgrQL0Y" +
           "XdQfvoQ6N053YP0kIPXLqHMFKitYOeW5srxdFN9zYqE9qb8Gnyvg+1fFt2gv" +
           "Gvab+RP4SUbxjrOUwgeb11Fa6rK6R7WiRIqiuyfYvqd3vOci70+A7+aE9809" +
           "eCfvxXtRJyLo2hps8uH9vYsJDAcAZ3KS18EvP/Fl66f/8DP7nO2yK10arH7k" +
           "lX/218cffeXoXKb8/B3J6vk5+2y55O/RkskiOJ+73yrljP4ffO7l//AvX/7w" +
           "nqsnLuZ9BHis+cx//8tfP/7kV371LsnEVZDTX7IF9e3boty9ngNf48QWxj1s" +
           "sbq7LYrNIiwfes6MkoNspTDKu+5tlBKE9zp+9Wef/40PvPr8/yoR6oYRgsDA" +
           "Av0uWf25OV9/7ctf/c1Hn/lsudc/sJbCfYhcfhy682nnwkNMyfAjZ5p4BNqr" +
           "44HpXhH73wja/j9NMCXfD+Ew0dcgpQjVAJ56isoYsqUGgJ5qn2a1f/eLltpg" +
           "z3D8/Db4nqJYnzqCdndHOCqqfw+YXzNcyT51huu26ur7Jwe2KCQ/O1viaD/v" +
           "dKfd79EFeoIHOM9Vi132tG+f7hre8dnDM+jM7mA2gN59b5+blKY/YP2vfOj/" +
           "Ps193+b9byDPffsll7xM8ucmr/3q4LvlHz+Crp4h/x1P1hcnvXgR7x8O1CgO" +
           "XO4C6j+z13+pv73yi+JdpYrvk3uk9+nbFUUErCUXqt5b5j7DfyiDLkGM+C0h" +
           "Zg9/VwBAXKsft4/L/eIDd/edq6XvFMX3F4Vx6j1vNW359ukuxKtBCMxz27Tb" +
           "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" +
           "7ZS0THcq12CRYWqt6m7s24sYrbOZ3mXsJtsfMMkki1JRkoNI3m5kYtOiJ0p/" +
           "7WIU2Mngeq6F8MgktrnHtAY1C+5MDG4rRyyGS3UN3ehmsOxTmjHvrXNYkeqY" +
           "baYIxgscSg5QTNn1um0/dkCILoPmakZWIpzETIdVVFEx1wKqDuGEwNiUgVN5" +
           "M60LAE+6M61viMtgbTZrda1hVCx46TP9rDkc0f1+2yADatWhlWWTXu+2dpyh" +
           "k92CzQI3zhybW+YrHK2Jycb0N0t9h4qiI8abOKeRWPAHndCBfU9VGrVuvT9z" +
           "J4qx2MzkVjVIVhPPGTrefLqyd37d8HDOqDVWHW5ZiRh4vNk2+3Ut4nss3eCX" +
           "y9pgETVrrelGr5tzeLBbTmG1u0WoUV+z+rtc1OnZ2hTxTU61bHIgGACz+Umq" +
           "4Rw6QbIgs/ueDBORsEHzqs23GKPeWTjw3Oz3t8KqIVuLWr4lcsppibA9iJaE" +
           "Zk2ns3rFttKJQ4n5hIJNWxgkkkBOVBZdV5wK2EgaUY1FwMP3e99bPJa/8saO" +
           "Cx4vT0bO3tEw7XbR8SNv4EQgu8cxXgQ95AdeVNw2K+W6h0vA8jzozdClW/9z" +
           "Z8Xn7nyg4uD7mXu9mFEeen/qQ6+8qtCfrh2dHDJxEXT95H2ZA52rZX178bz6" +
           "BfB1T3hwL59XH3Rw52F1qc3sbgdnl679nji79ivu3SVXt9Vy2s/d55DsM0Xx" +
           "qQi6kZ9c19/14CbxDOVgoU9/qzOb84tcUkVxal/2705UsXsDqjg6ONb99FH8" +
           "rZYD/v19JP+PRfH5CHpUV6PDuwqXnPHf/C1EfbJobIHvB09E/eD/T1F/+T6i" +
           "fqEofumckYv/nztI+Z/fiJRZBD180Nep7x2/sbdDQJw9dcdravtXq+TPvnrz" +
           "xltfXfzW/qLk9PWnh8bQDS227fP3jOfq1/1A1fZI89D+1tEvf74YQd/zbbIG" +
           "9HNaLaX6b3sKX4qgZ+9PIYKulb/nZ/1WBD11r1kRdBWU50f/dgS9+W6jwUhQ" +
           "nh/5OxF06/LI8k4R/J4f9xVgpcM4AFL7yvkhvweogyFF9ff9u5xO76+DsysX" +
           "AfLMaZ74Vk5zDlOfv3DDUb7GeHobEe9fZHxJ/tyr5PQHv9H69P6dEtmW8ryg" +
           "cmMMPbh/veXsRuO5e1I7pXV9+MI3H/uFh951itKP7Rk+xNs53t5+9xc4CMeP" +
           "ylcu8n/31n/9nn/x6u+Wh+V/A1walYdfKgAA");
    }
    protected static class ZeroRecter_INT_PACK extends org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter {
        final int base;
        final int scanStride;
        final int[] pixels;
        final int[] zeros;
        final int x0;
        final int y0;
        public ZeroRecter_INT_PACK(java.awt.image.WritableRaster wr) {
            super(
              wr);
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                wr.
                getSampleModel(
                  );
            scanStride =
              sppsm.
                getScanlineStride(
                  );
            java.awt.image.DataBufferInt db =
              (java.awt.image.DataBufferInt)
                wr.
                getDataBuffer(
                  );
            x0 =
              wr.
                getMinY(
                  );
            y0 =
              wr.
                getMinX(
                  );
            base =
              db.
                getOffset(
                  ) +
                sppsm.
                getOffset(
                  x0 -
                    wr.
                    getSampleModelTranslateX(
                      ),
                  y0 -
                    wr.
                    getSampleModelTranslateY(
                      ));
            pixels =
              db.
                getBankData(
                  )[0];
            if (wr.
                  getWidth(
                    ) >
                  10)
                zeros =
                  (new int[wr.
                             getWidth(
                               )]);
            else
                zeros =
                  null;
        }
        public void zeroRect(java.awt.Rectangle r) {
            final int rbase =
              base +
              (r.
                 x -
                 x0) +
              (r.
                 y -
                 y0) *
              scanStride;
            if (r.
                  width >
                  10) {
                for (int y =
                       0;
                     y <
                       r.
                         height;
                     y++) {
                    int sp =
                      rbase +
                      y *
                      scanStride;
                    java.lang.System.
                      arraycopy(
                        zeros,
                        0,
                        pixels,
                        sp,
                        r.
                          width);
                }
            }
            else {
                int sp =
                  rbase;
                int end =
                  sp +
                  r.
                    width;
                int adj =
                  scanStride -
                  r.
                    width;
                for (int y =
                       0;
                     y <
                       r.
                         height;
                     y++) {
                    while (sp <
                             end)
                        pixels[sp++] =
                          0;
                    sp +=
                      adj;
                    end +=
                      scanStride;
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "f16evP4rzN19eHoqAAA=");
    }
    protected void handleZero(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
          org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          getZeroRecter(
            wr);
        java.awt.Rectangle ar =
          new java.awt.Rectangle(
          wrR.
            x,
          wrR.
            y,
          wrR.
            width,
          wrR.
            height);
        java.awt.Rectangle dr =
          new java.awt.Rectangle(
          wrR.
            x,
          wrR.
            y,
          wrR.
            width,
          wrR.
            height);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: " +
                wrR +
                " srcR: " +
                srcR);
        }
        if (ar.
              x <
              srcR.
                x) {
            int w =
              srcR.
                x -
              ar.
                x;
            if (w >
                  ar.
                    width)
                w =
                  ar.
                    width;
            dr.
              width =
              w;
            zr.
              zeroRect(
                dr);
            ar.
              x +=
              w;
            ar.
              width -=
              w;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] s rcR: " +
                srcR);
        }
        if (ar.
              y <
              srcR.
                y) {
            int h =
              srcR.
                y -
              ar.
                y;
            if (h >
                  ar.
                    height)
                h =
                  ar.
                    height;
            dr.
              x =
              ar.
                x;
            dr.
              y =
              ar.
                y;
            dr.
              width =
              ar.
                width;
            dr.
              height =
              h;
            zr.
              zeroRect(
                dr);
            ar.
              y +=
              h;
            ar.
              height -=
              h;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] srcR: " +
                srcR);
        }
        if (ar.
              y +
              ar.
                height >
              srcR.
                y +
              srcR.
                height) {
            int h =
              ar.
                y +
              ar.
                height -
              (srcR.
                 y +
                 srcR.
                   height);
            if (h >
                  ar.
                    height)
                h =
                  ar.
                    height;
            int y0 =
              ar.
                y +
              ar.
                height -
              h;
            dr.
              x =
              ar.
                x;
            dr.
              y =
              y0;
            dr.
              width =
              ar.
                width;
            dr.
              height =
              h;
            zr.
              zeroRect(
                dr);
            ar.
              height -=
              h;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] srcR: " +
                srcR);
        }
        if (ar.
              x +
              ar.
                width >
              srcR.
                x +
              srcR.
                width) {
            int w =
              ar.
                x +
              ar.
                width -
              (srcR.
                 x +
                 srcR.
                   width);
            if (w >
                  ar.
                    width)
                w =
                  ar.
                    width;
            int x0 =
              ar.
                x +
              ar.
                width -
              w;
            dr.
              x =
              x0;
            dr.
              y =
              ar.
                y;
            dr.
              width =
              w;
            dr.
              height =
              ar.
                height;
            zr.
              zeroRect(
                dr);
            ar.
              width -=
              w;
        }
    }
    protected void handleReplicate(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        int x =
          wrR.
            x;
        int y =
          wrR.
            y;
        int width =
          wrR.
            width;
        int height =
          wrR.
            height;
        java.awt.Rectangle r;
        {
            int minX =
              srcR.
                x >
              x
              ? srcR.
                  x
              : x;
            int maxX =
              srcR.
                x +
              srcR.
                width -
              1 <
              x +
              width -
              1
              ? srcR.
                  x +
              srcR.
                width -
              1
              : x +
              width -
              1;
            int minY =
              srcR.
                y >
              y
              ? srcR.
                  y
              : y;
            int maxY =
              srcR.
                y +
              srcR.
                height -
              1 <
              y +
              height -
              1
              ? srcR.
                  y +
              srcR.
                height -
              1
              : y +
              height -
              1;
            int x0 =
              minX;
            int w =
              maxX -
              minX +
              1;
            int y0 =
              minY;
            int h =
              maxY -
              minY +
              1;
            if (w <
                  0) {
                x0 =
                  0;
                w =
                  0;
            }
            if (h <
                  0) {
                y0 =
                  0;
                h =
                  0;
            }
            r =
              new java.awt.Rectangle(
                x0,
                y0,
                w,
                h);
        }
        if (y <
              srcR.
                y) {
            int repW =
              r.
                width;
            int repX =
              r.
                x;
            int wrX =
              r.
                x;
            int wrY =
              y;
            if (x +
                  width -
                  1 <=
                  srcR.
                    x) {
                repW =
                  1;
                repX =
                  srcR.
                    x;
                wrX =
                  x +
                    width -
                    1;
            }
            else
                if (x >=
                      srcR.
                        x +
                      srcR.
                        width) {
                    repW =
                      1;
                    repX =
                      srcR.
                        x +
                        srcR.
                          width -
                        1;
                    wrX =
                      x;
                }
            java.awt.image.WritableRaster wr1 =
              wr.
              createWritableChild(
                wrX,
                wrY,
                repW,
                1,
                repX,
                srcR.
                  y,
                null);
            src.
              copyData(
                wr1);
            wrY++;
            int endY =
              srcR.
                y;
            if (y +
                  height <
                  endY)
                endY =
                  y +
                    height;
            if (wrY <
                  endY) {
                int[] pixels =
                  wr.
                  getPixels(
                    wrX,
                    wrY -
                      1,
                    repW,
                    1,
                    (int[])
                      null);
                while (wrY <
                         srcR.
                           y) {
                    wr.
                      setPixels(
                        wrX,
                        wrY,
                        repW,
                        1,
                        pixels);
                    wrY++;
                }
            }
        }
        if (y +
              height >
              srcR.
                y +
              srcR.
                height) {
            int repW =
              r.
                width;
            int repX =
              r.
                x;
            int repY =
              srcR.
                y +
              srcR.
                height -
              1;
            int wrX =
              r.
                x;
            int wrY =
              srcR.
                y +
              srcR.
                height;
            if (wrY <
                  y)
                wrY =
                  y;
            if (x +
                  width <=
                  srcR.
                    x) {
                repW =
                  1;
                repX =
                  srcR.
                    x;
                wrX =
                  x +
                    width -
                    1;
            }
            else
                if (x >=
                      srcR.
                        x +
                      srcR.
                        width) {
                    repW =
                      1;
                    repX =
                      srcR.
                        x +
                        srcR.
                          width -
                        1;
                    wrX =
                      x;
                }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "wr: " +
                    wr.
                      getBounds(
                        ));
                java.lang.System.
                  out.
                  println(
                    "req: [" +
                    wrX +
                    ", " +
                    wrY +
                    ", " +
                    repW +
                    ", 1]");
            }
            java.awt.image.WritableRaster wr1 =
              wr.
              createWritableChild(
                wrX,
                wrY,
                repW,
                1,
                repX,
                repY,
                null);
            src.
              copyData(
                wr1);
            wrY++;
            int endY =
              y +
              height;
            if (wrY <
                  endY) {
                int[] pixels =
                  wr.
                  getPixels(
                    wrX,
                    wrY -
                      1,
                    repW,
                    1,
                    (int[])
                      null);
                while (wrY <
                         endY) {
                    wr.
                      setPixels(
                        wrX,
                        wrY,
                        repW,
                        1,
                        pixels);
                    wrY++;
                }
            }
        }
        if (x <
              srcR.
                x) {
            int wrX =
              srcR.
                x;
            if (x +
                  width <=
                  srcR.
                    x) {
                wrX =
                  x +
                    width -
                    1;
            }
            int xLoc =
              x;
            int[] pixels =
              wr.
              getPixels(
                wrX,
                y,
                1,
                height,
                (int[])
                  null);
            while (xLoc <
                     wrX) {
                wr.
                  setPixels(
                    xLoc,
                    y,
                    1,
                    height,
                    pixels);
                xLoc++;
            }
        }
        if (x +
              width >
              srcR.
                x +
              srcR.
                width) {
            int wrX =
              srcR.
                x +
              srcR.
                width -
              1;
            if (x >=
                  srcR.
                    x +
                  srcR.
                    width) {
                wrX =
                  x;
            }
            int xLoc =
              wrX +
              1;
            int endX =
              x +
              width -
              1;
            int[] pixels =
              wr.
              getPixels(
                wrX,
                y,
                1,
                height,
                (int[])
                  null);
            while (xLoc <
                     endX) {
                wr.
                  setPixels(
                    xLoc,
                    y,
                    1,
                    height,
                    pixels);
                xLoc++;
            }
        }
    }
    protected void handleWrap(java.awt.image.WritableRaster wr) {
        handleZero(
          wr);
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                               java.awt.Rectangle bounds) {
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int w =
          sm.
          getWidth(
            );
        if (w <
              defSz)
            w =
              defSz;
        if (w >
              bounds.
                width)
            w =
              bounds.
                width;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              bounds.
                height)
            h =
              bounds.
                height;
        return sm.
          createCompatibleSampleModel(
            w,
            h);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cHjf4tMdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hWn58cLuVx7919/9cy//SXkO8w9gu+qcnikAAA==");
}
