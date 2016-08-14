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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "vTM6JV5x+Oi/tfARqHofAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "YbzhGg4DfSeLbnu6DdbNdaThYcRkNX85FjRBbZlOpdKtiuyG1ZfCFmswWkDy" +
           "6mbFhXlHF1oo0q0tCXmRzRWizgWRuyCY7UTM4dWomU/9zWaYgGxJjU2z2uMX" +
           "msYTI6Y+ExFmPnQ3CzZPGt2Q7qI1cdfAUGqXSfBuEqH4op92N5xXD3CqVcst" +
           "TKxthru0R65UEJrVvCIEI8tCc0JtKlIawTO13aP8VNqK2S5tVJ1lt+FMgMjm" +
           "ojklyKVXpUWQx9XmnTbmjs3VehnTraYgbxnKqNbGtX6bJ/VJzWQ61pKadOZr" +
           "Yyl1peoUER0eaSmTqLuurhkYL2b1ZLYM2yztammnI40DeDIm3eGY7PUNleBG" +
           "HCs0DD/lYQfJjE6Xgpk11WGjAT/sIkHud0DOGarIOlnnooPX5AE3jvBuOkUm" +
           "U3diWzHelXR0oETkyGbbYsMIUX3hktUpzsjbDdObwTRFtaZLlq9G3tCvWPTS" +
           "ltSIiJKOntTcNOP9aoYFnksIaNOpiFSPaSNSOt7FKwxMtGySRUrG1zmbHcUo" +
           "kzacmhdvlQyfyWBVQc9lMeGmLXLZzCq0AUcqyvq4q4LV+3cXy/pX3th2w+Pl" +
           "zsrZtxqm3S4qfvQN7Chk99gGjKCHvMCNihNpuRz3cFBY7ie9Gbp0+n9uP/nc" +
           "uRBUbI4/c68PNMqN8Y9/4JVXZfoTtaOTTSougq6ffDdz6Odq+exf3NN+AVzO" +
           "CQ/O5T3tgw7u3NAutZndbePt0tHgE2dHg8XZvOBotlI2+4X7bLJ9sig+HkE3" +
           "8pMj/btu/CSuIR8s9IlvtOdzfpBLqih29sv63Ykqdm9AFUcHx7qfPoq/1ZLg" +
           "N+4j+b8ris9E0KOaEh2+Z7jkjL/6LYj6ZPGyBa73n4j6/v+fov7+fUT9bFH8" +
           "9jkjF/8/fZDyd96IlFkEPXzQ16nvHb+xL0hAnD11x+dq+0+spE+9evPGW19d" +
           "/On+MOX0M6iHJtANNbbt82eR556ve4Gi7pHmof3JpFfePh9B3/lNsgb0c/pY" +
           "SvXv9z18IYKevX8PEXStvJ9v9acR9NS9WkXQVVCep/6zCHrz3agBJSjPU/55" +
           "BN26TFmeO4L7ebovASsd6ABI7R/Ok/wl6B2QFI9/5d1ld3t/ZJxduQiQZ07z" +
           "xDdymnOY+vyFE5Lyc8bT04x4/0HjS9KnXyWpH/pa6xP7704kW8jzopcbE+jB" +
           "/ScwZyciz92zt9O+ruMvfP2xX3roXaco/die4UO8nePt7Xf/yGOw9aLys4z8" +
           "19/6b97zc6/+RbnZ/v8Aq3hWuGcqAAA=");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "mG+q/Ay4iZJGMYXI69zfSV645ickp4LEe56SdUnqrHMUZm3T18N1hbe3Iyy2" +
           "WymuLJqUq5o8GfqZ3E7bIFPQEq5Pi8t+x1USVo58s9npeDnGTnKNR3OiYbdb" +
           "6MLJ5qOgNiLFtoHZww62ZOcuylUnDBMLHVyQOmRv0c4HNqFONhiljVAXTlx3" +
           "vIszbNlhVyDWE2YitOMptluM9chD2eGG4tt0sx5qesuseooF8iOMa9RNtdFt" +
           "Tvo9uQVv3Xkn4UZIGntxFZvN4+kajir1pR622ss16dVgUl8AhXIlRkRpwXsN" +
           "ZtnpVCtNI+J2dtSaSpxV361t1p3O28YoW4xWS6Exd3aBLyfIbu6s2jWa4Kde" +
           "lQ9aw2Vbx5Ekm+HoXM5oZ6o1K+GoZVqqLGdwu0M5+pyZqGu4kY2bznrTn8mz" +
           "XZvuOSvNG2a5l07qXbPGJMM0XKYtJgLTWI7mFSs0WVIeWQu7J3LBoq0nVrMK" +
           "N2WthVmTQEYn1q5nb0MTB4qOp2h7XCPtmcgEnWyKTUWsZwmpEfaVeVTPzbRl" +
           "DVLLkmvCTMnmsT63fNpqOTYDLxjHIkYhIwyXG9gasmbXR6McoNaWFV3Z6evM" +
           "gByj9VoyjivmeFLrYPXRatasAGeZCB47rI/s0UjQGj0u60UshbQZ4JGzijbR" +
           "wEr924sl/M++tq2FR8pdlJNbNpbdKio+/hp2D7K7bNPG0IN+6MXFXQK17Pf0" +
           "ZLfc8nsDdOHexpmNqDMHeVBxovLk3a7WlKcpn3rviy+p7E9WD472EZkYunJ0" +
           "4+mUz36H2T9/hP4seH7iSIafuLgZdjoGd94J+9bsTnujF85yHz05yy1uVUiu" +
           "YWtls9++xz7o7xbFr8fQ1fzoMsYdN3lSz1RPLfQbX29/59xBaQy9/g4XPY5l" +
           "Pnxtd0aAfR6/7YLa/lKV8umXrl997CX+z/eHJMcXnx6koat6YttnDx3PvF/x" +
           "AdaY5VA8uD+C9Mufz8bQt7xK0cDgHb+WWv3pnsPnYuipe3OIocvl79lWn4+h" +
           "x+/WKobuA+VZ6j+PoTfciRpQgvIs5V/G0I2LlKD/8vcs3V/F0LVTOuDc+5ez" +
           "JF8E3AFJ8fo3/rEdO//muz/ZpfMReOJmj349NzsTtM+cOyUpbzoen2gk+7uO" +
           "t5TPvEQx7/5q8yf3N1EUW8rzgstVGnpgfynm5FTkbXfldszrCvHs1x7+hQff" +
           "fgwDD+8FPg3jM7K95c7XPgaOH5cXNfJfe+yX3/nTL/11uXP7fwFQD7uGgioA" +
           "AA==");
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7XCqHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f/um//jy75fnN/8I+022JLopAAA=");
}
