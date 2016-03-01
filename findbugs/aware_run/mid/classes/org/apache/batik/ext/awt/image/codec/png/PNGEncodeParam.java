package org.apache.batik.ext.awt.image.codec.png;
public abstract class PNGEncodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam {
    public static final int INTENT_PERCEPTUAL = 0;
    public static final int INTENT_RELATIVE = 1;
    public static final int INTENT_SATURATION = 2;
    public static final int INTENT_ABSOLUTE = 3;
    public static final int PNG_FILTER_NONE = 0;
    public static final int PNG_FILTER_SUB = 1;
    public static final int PNG_FILTER_UP = 2;
    public static final int PNG_FILTER_AVERAGE = 3;
    public static final int PNG_FILTER_PAETH = 4;
    public static org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam getDefaultEncodeParam(java.awt.image.RenderedImage im) {
        java.awt.image.ColorModel colorModel =
          im.
          getColorModel(
            );
        if (colorModel instanceof java.awt.image.IndexColorModel) {
            return new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette(
              );
        }
        java.awt.image.SampleModel sampleModel =
          im.
          getSampleModel(
            );
        int numBands =
          sampleModel.
          getNumBands(
            );
        if (numBands ==
              1 ||
              numBands ==
              2) {
            return new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray(
              );
        }
        else {
            return new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB(
              );
        }
    }
    public static class Palette extends org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam {
        public Palette() { super(); }
        private boolean backgroundSet = false;
        public void unsetBackground() { backgroundSet =
                                          false;
        }
        public boolean isBackgroundSet() {
            return backgroundSet;
        }
        public void setBitDepth(int bitDepth) {
            if (bitDepth !=
                  1 &&
                  bitDepth !=
                  2 &&
                  bitDepth !=
                  4 &&
                  bitDepth !=
                  8) {
                throw new java.lang.IllegalArgumentException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam2"));
            }
            this.
              bitDepth =
              bitDepth;
            bitDepthSet =
              true;
        }
        private int[] palette = null;
        private boolean paletteSet = false;
        public void setPalette(int[] rgb) {
            if (rgb.
                  length <
                  1 *
                  3 ||
                  rgb.
                    length >
                  256 *
                  3) {
                throw new java.lang.IllegalArgumentException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam0"));
            }
            if (rgb.
                  length %
                  3 !=
                  0) {
                throw new java.lang.IllegalArgumentException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam1"));
            }
            palette =
              (int[])
                rgb.
                clone(
                  );
            paletteSet =
              true;
        }
        public int[] getPalette() { if (!paletteSet) {
                                        throw new java.lang.IllegalStateException(
                                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                            getString(
                                              "PNGEncodeParam3"));
                                    }
                                    return (int[])
                                             palette.
                                             clone(
                                               );
        }
        public void unsetPalette() { palette =
                                       null;
                                     paletteSet =
                                       false;
        }
        public boolean isPaletteSet() { return paletteSet;
        }
        private int backgroundPaletteIndex;
        public void setBackgroundPaletteIndex(int index) {
            backgroundPaletteIndex =
              index;
            backgroundSet =
              true;
        }
        public int getBackgroundPaletteIndex() {
            if (!backgroundSet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam4"));
            }
            return backgroundPaletteIndex;
        }
        private int[] transparency;
        public void setPaletteTransparency(byte[] alpha) {
            transparency =
              (new int[alpha.
                         length]);
            for (int i =
                   0;
                 i <
                   alpha.
                     length;
                 i++) {
                transparency[i] =
                  alpha[i] &
                    255;
            }
            transparencySet =
              true;
        }
        public byte[] getPaletteTransparency() {
            if (!transparencySet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam5"));
            }
            byte[] alpha =
              new byte[transparency.
                         length];
            for (int i =
                   0;
                 i <
                   alpha.
                     length;
                 i++) {
                alpha[i] =
                  (byte)
                    transparency[i];
            }
            return alpha;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Bau6mYG+KgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "x198SR38fOXc/h12Ly6d3x+OO2rnbcW9");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("dfIIRf59LNnrkJx+33oE/sYvW5/Zvt57+V87o+wf5ck/iEuXEjfS4ua1V8o3" +
           "fFO49kz1yAy//HovCY/3dQp2frCq9G5wfXgP+8O3HvaXzij7Sp78MwDbjJrH" +
           "v/fm2ewRxN98CxALy/4guD6xh/iJWwPx4EjgA4XAvzoD51fz5NUYuB0wrhlT" +
           "mr/7NvbrRxj/5VvF+Cy4XtpjfOmWYxQKgdfOwPhHefL7cekiwLj/EnIK4r9/" +
           "CxAfyDMfB9ev7iH+6q331K+dUfaNPPnPAJ1xAp1whO5P3qoBnwTXK3t0r9x6" +
           "dH9+Rtn/zJP/FpfuLujnxtb772+VZ/LPWV/e4/vyLcd3cNsZZXfkmX8B8JkR" +
           "f/Iz4hG+775V+9XB9dU9vq/e8glYkMzBpTNA3pcnF+PS951YQU5/lDyy6MHb" +
           "3gLit+eZ7wXXH+8R//Gtt+j3n1GWfxs/eBCANc4C+4EjsA/dCvN+ew/227fU" +
           "vMXz7Fpv78wbfwLk//qus93vrT4uIoemamggUoy0sRKafmy6Rstdm6HnOpob" +
           "/785o/JGOr3hGZXb5TTWbjhu+SfQg2f3n8MPyq8Xd+5j3DxRCw/Jaz1z/emU" +
           "/FHPk+X1x00K59h1W9TOn70zfBU/o6yRJ2heEu80OUP2ue3u9wfOkPnhPHky" +
           "Lj14xOOTUx//jzHAU29hUjy4Z4CDC3s3vXDrGYA5o6yTJ02A1LgZ0oNnjpCS" +
           "bwbpNi5d2DdZlD0Ql/Dv8dg82K48fN2/9uz+HUX5wkuX7nzopem/2Z1wO/yX" +
           "kbt6pTv1xLaPn9Q8dn/eDzXdLEburt25Tb8YjlFceuaN6hiXbgNpDu1guKs9" +
           "jUtX3kjt/ORQ/nu8rhCXHju7LqhV/B6v9aNx6eGb1QL6gfS49Afj0jtuJA0k" +
           "QXpcUopLl09Lgv6L3+NyKojljuTAHnF3c1wkHycgkt8uC3YZbHeT/+HjM6II" +
           "Hu5/Pfc6tn196sRZteLfww7PlSW7fxB7XvniS2z/x76F/fzuTL5iS1mWt3Jn" +
           "r3Rh9+8BRaP52bR33bS1w7bOt5/9zr2/dNfThxvie3cKH83OY7o9fuMD8C3H" +
           "j4sj69mvPfTLP/R3XvqD4nDM/wUXs0yktzcAAA==");
    }
    public static class Gray extends org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam {
        public Gray() { super(); }
        private boolean backgroundSet = false;
        public void unsetBackground() { backgroundSet =
                                          false;
        }
        public boolean isBackgroundSet() {
            return backgroundSet;
        }
        public void setBitDepth(int bitDepth) {
            if (bitDepth !=
                  1 &&
                  bitDepth !=
                  2 &&
                  bitDepth !=
                  4 &&
                  bitDepth !=
                  8 &&
                  bitDepth !=
                  16) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            this.
              bitDepth =
              bitDepth;
            bitDepthSet =
              true;
        }
        private int backgroundPaletteGray;
        public void setBackgroundGray(int gray) {
            backgroundPaletteGray =
              gray;
            backgroundSet =
              true;
        }
        public int getBackgroundGray() { if (!backgroundSet) {
                                             throw new java.lang.IllegalStateException(
                                               org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGEncodeParam6"));
                                         }
                                         return backgroundPaletteGray;
        }
        private int[] transparency;
        public void setTransparentGray(int transparentGray) {
            transparency =
              (new int[1]);
            transparency[0] =
              transparentGray;
            transparencySet =
              true;
        }
        public int getTransparentGray() {
            if (!transparencySet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam7"));
            }
            int gray =
              transparency[0];
            return gray;
        }
        private int bitShift;
        private boolean bitShiftSet = false;
        public void setBitShift(int bitShift) {
            if (bitShift <
                  0) {
                throw new java.lang.RuntimeException(
                  );
            }
            this.
              bitShift =
              bitShift;
            bitShiftSet =
              true;
        }
        public int getBitShift() { if (!bitShiftSet) {
                                       throw new java.lang.IllegalStateException(
                                         org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                           getString(
                                             "PNGEncodeParam8"));
                                   }
                                   return bitShift;
        }
        public void unsetBitShift() { bitShiftSet =
                                        false;
        }
        public boolean isBitShiftSet() { return bitShiftSet;
        }
        public boolean isBitDepthSet() { return bitDepthSet;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVaC5AUxRnu3Xty3HEP5LiccsDdQYUTdyWiVDwiwsFxh3sP" +
           "OCDJoRyzs727I7Mzw0wvt5wSwKoENFWUJaiY6KUqwTwUwdJY5lESkpgoMWpE" +
           "Y3xFo1ZFDZKSVCI+Es3f3TM7s7M7gxsvyVVdb+90/93/9/9/f/13zx46hcoM" +
           "HbVqghITQmSbho3QIK0PCrqBY12yYBhr4emIeMOr+3aceXrSriAqH0ZTkoLR" +
           "JwoG7pawHDOG0QxJMYigiNjoxzhGJQZ1bGB9q0AkVRlG0ySjN6XJkiiRPjWG" +
           "aYf1gh5B9QIhuhRNE9xrDkDQzAjTJsy0CS91d+iMoGpR1bbZAs05Al2ONto3" +
           "Zc9nEFQXuVrYKoTTRJLDEckgnRkdna+p8raErJIQzpDQ1fLFpiFWRS7OM0Pr" +
           "vbXvfnhjso6ZYaqgKCphEI012FDlrTgWQbX20xUyThlb0FdQSQRNdnQmqD1i" +
           "TRqGScMwqYXX7gXa12AlnepSGRxijVSuiVQhgmbnDqIJupAyhxlkOsMIlcTE" +
           "zoQB7awsWsvdLog3nx/ef+vGuvtKUO0wqpWUIaqOCEoQmGQYDIpTUawbS2Mx" +
           "HBtG9Qo4fAjrkiBLY6a3GwwpoQgkDSFgmYU+TGtYZ3PatgJPAjY9LRJVz8KL" +
           "s6Ayv5XFZSEBWBttrBxhN30OAKskUEyPCxB7pkjpZkmJsTjKlchibL8COoBo" +
           "RQqTpJqdqlQR4AFq4CEiC0oiPATBpySga5kKIaizWPMYlNpaE8TNQgKPENTk" +
           "7jfIm6DXJGYIKkLQNHc3NhJ4qdnlJYd/TvUv3nuN0qMEUQB0jmFRpvpPBqEW" +
           "l9AaHMc6hnXABas7IrcIjQ/tCSIEnae5OvM+D157+vL5Lcce5X3OLdBnIHo1" +
           "FsmIeDA65anzuuZ9voSqUamphkSdn4OcrbJBs6UzowHTNGZHpI0hq/HYml9/" +
           "eedd+GQQVfWiclGV0ymIo3pRTWmSjPWVWMG6QHCsF03CSqyLtfeiCqhHJAXz" +
           "pwPxuIFJLyqV2aNylX0HE8VhCGqiKqhLSly16ppAkqye0RBCDfCPpiMUmIrY" +
           "H/8kKBNOqikcFkRBkRQ1PKirFD91KOMcbEA9Bq2aGo5C/G++YEFoUdhQ0zoE" +
           "ZFjVE2EBoiKJeSNbp8IoCUspCIawCNwkhjUItMH+lSsU+nWQLuIQjUDt/zh3" +
           "htpl6mggAC47z00YMqy1HlWOYX1E3J9etuL04ZHHeDDSBWRalKDFoECIKxBi" +
           "CjB6BQVCTIEQUyAECoRyFWhfqQvbUCDAJj+HasNjBTy9GTgDSLt63tBVqzbt" +
           "aS2BINVGS6mzoOvcvE2syyYXa0cYEQ89tebMk49X3RVEQeCfKGxi9k7SnrOT" +
           "8I1QV0UcAyrz2lMsXg177yIF9UDHDozuWr/jQqaHc3OgA5YBr1FxZpDsFO1u" +
           "Uig0bu3uN989cst21aaHnN3G2iTzJCnrtLpd7QY/InbMEh4YeWh7exCVApUB" +
           "fRMBlhswY4t7jhz26bSYnGKpBMBxVU8JMm2y6LeKJHV11H7CYrCe1c8BF9fS" +
           "5QhrMtBork/2SVsbNVpO5zFLY8aFgu0UXxjS7njuibcuYua2NpVaRzYwhEmn" +
           "g8joYA2MsurtEFyrYwz9/nhgcN/Np3ZvYPEHPdoKTdhOyy4gMHAhmPmrj255" +
           "/pWXDz4TtGOWwE6ejkJSlMmCrKSYpviApHFu6wNEKAMh0KhpX6dAVEpxSYjK" +
           "mC6Sf9bOWfDA23vreBzI8MQKo/lnH8B+/pllaOdjG8+0sGECIt2IbZvZ3Ti7" +
           "T7VHXqrDKqZ6ZHadmHHbI8IdsE8ANxvSGGZ0i5gNEHPaQoY/zMqLXG2X0KLd" +
           "cAZ/7vpyJEwj4o3PvFOz/p2jp5m2uRmX09d9gtbJw4sWczIw/HQ30fQIRhL6" +
           "LTzWf2WdfOxDGHEYRhSBWY0BHbgvkxMZZu+yihd+/svGTU+VoGA3qpJVIdYt" +
           "sEWGJkF0YyMJtJnRllzOvTtK3V3HoKI88NSeMwt7akVKI8y2Yz+a/sPF3xt/" +
           "mQUVj6JzmThN6mfl8SHL1u2l/PaL33z9Z2e+U8H3+nne/OWSa/pgQI5e99p7" +
           "eUZmzFUgD3HJD4cP3d7cddlJJm9TCJVuy+TvN0Cytuzn7kr9I9ha/qsgqhhG" +
           "daKZGa8X5DRdmMOQDRpWugzZc057bmbH05jOLEWe56Yvx7Ru8rL3OajT3rRe" +
           "4+Ir5tcQLOFmcyk3u/kqgFhlJROZy8p5tJhv0UOFpktwgsIufqj1GZSgmihk" +
           "mgldTSuQlhO2cBxxQE9fQ+moQQZ1KQVEt9XMDY80ntnycMXYcivvKyTCe15h" +
           "9D35k543RhiRVtL9c61lAcfOuFRPOFi8jgP4GP4C8P8R/aeK0wc8y2roMlO9" +
           "WdlcT9PouvQJSxeE8PaGVzbf/uY9HII7Bl2d8Z79N3wc2rufsyM/MLTl5exO" +
           "GX5o4HBosZpqN9tvFibR/caR7T/9/vbdXKuG3PR3BZzu7nn2X78NHfjT8QIZ" +
           "VEVUVWUsKFluCGSTnUa3hzis8gV3vL/ja88NwO7ciyrTirQljXtjuRFbYaSj" +
           "DpfZxxE7ik2A1D0EBTrAE3xvpeUiWvTwkLzUk8mW5q6DDtB6iRmySzzWgcDX" +
           "AS1W5Qe8lzScoeyAHxRkTAimCSQbod90FP0YctS/SFCJZB6oHXalX69yQ40W" +
           "CbUNBtpoKrvRA2rKF6qXNEHVRIdogIwC0qptborPrlO29fJ4+PHUt+4/vqni" +
           "eR59hZnAdUp87ZrHvq2+dDIYNDfggayCU6g+9fBvWoJ/EiT9V04pCaymYAiS" +
           "jGAlQZLWkeh/Nxld33O82cdh5fHvtj2xY7ztVZYjVEoGbB3AfwVO8Q6Zdw69" +
           "cvJEzYzDLI8upTRqrsfc64/8242cSwvmoVpapFk1nkcVLEJ5BzP4ri283wRp" +
           "9QICO52kCDIbbTVkqDIzCP2WoMWYmWbQKYJcjn1vImbyRzfXUJesKpjmkVYb" +
           "P8ZJaih7UwSNmQK8NjsvaeljcO0MYNGJMyUv3tRUnX9+o6O1eJzOOrwd6Z7g" +
           "kev+0rz2suSmIg5mM11+dg/5g75Dx1fOFW8KsmsmnnDkXU/lCnXmknaVjkla" +
           "V3JputV2/JjNKB3MdT4p9V6fthtp8XWIApG6kHvcp/s+FlFLHOmrH5UqRVLp" +
           "DBhop0mGOz2o9FZfKvWSJpC5SGQoKcXZqSjuUvRAkYrOhyl2mVPt8lB03FdR" +
           "L2mCJluKQjZHHw26dP2Wj64Z/6VebrCrXTu9LDUZPvcOzKGO44iBKD/O8Lqm" +
           "ZLnPwev2j8cG7lxgbSVfginN22N7nGpW3517zp8Dc880dZjpNqhtAB7v+adn" +
           "L1GfSL7fp+0BWhyGI2RaMTBZlk03CuUVpVtVKWZ758jZIinnyMcWk8se02nT" +
           "XAAz1wQ1t3h7eIn6YP6FT9vDtHgI7CEZy5yHDRaeNvajnxo7i4ULQPGFJoCF" +
           "xWP3EnXhc/BWnI36hI8BfkeL47A2aThIZDnW+Bb5oA3+NxMDPgw6dZsIuosH" +
           "7yV6NvAv+IB/iRa/J3DUda4FmnO7TPDspzYBo5920GydiWNd8SbwEvVB+Gef" +
           "tjdp8SqgTxRCH7fRvzYxAdAJqidNCMni0XuJni0A/uZjgr/T4hSc2SEA1mYP" +
           "JKRABPx1YiKA7gYZE0imeBt4ifpA/Mi7LcCGeB/gJwrCd4TABxNHgNebGK4v" +
           "Hr6X6FlCIFDlY4NqWpRlCTCbSNm+D5RPjO9bQKfbTAS3FQ/eS9QHW6NPWxMt" +
           "6gF3Ihe37fRAw8Q4nV4jHDSVP1g8bi9RH2ytPm3ttJhBUA3PgAp7vGVich3K" +
           "93eb6t9dPHIvUR90IZ+2C2kxD5BDruNKxG3kHROH/D5T/fuKR+4l6oPuUp+2" +
           "xbS42ELOcpx85JcUjzwDSXL2hq6JoEX/4XtiOH405f2Whf/+Qjw8Xls5fXzd" +
           "H/jtivUbieoIqoynZdl5fe+ol2s6jkvM0NX8Mp/dewZWEPTZT6ojQSVQUmiB" +
           "5Vy6h6D2TyJNz9z00yl7BUEt/rIgxT6dUv0ENXlJgX5QOnuvJuicQr2hJ5TO" +
           "nmsJqnP3hPnZp7MfnIKq7H5w5uMVZ5dhGB260OoG7dMGQobfcmWPpVZwomln" +
           "C07HSbYt54KI/ZTKusxJ8x9TjYhHxlf1X3P6kjv5O2RRFsbG6CiTI6iCv85m" +
           "g9ILodmeo1ljlffM+3DKvZPmWGfjeq6wvcrPdaQjS2BVa/SFYLPrBavRnn3P" +
           "+vzBxUcf31N+IogCG1BAIGjqhvzXXRktraOZGyKF3h6sF3T27rez6vVNT773" +
           "QqCBvVVE/F6uxU9iRNx39MXBuKZ9I4gm9UJEKjGcYe/ilm9T1mBxq57zMqI8" +
           "mj08l0TQFLo6BfozK2YZ06A12af0NwgEtea/m8n/XUaVrI5ifRkdnQ5T47pC" +
           "S2uas5VZ9kparGaZIYTkSKRP08yXUmVPM8trGmWtAPs9wFX/Bp3AwzAvKQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "b8fLXJpbMW9ai/hIp05Q9fI7pOrDYPSXD6h6+SZUfertUHXPIVUgmOaPmDOE" +
           "ffotCdv59T0Q2+9A9+v7SH7/mRtPfduBqV2Mig2q/M4+JORh21GvHoZ8UQ8j" +
           "oNFXbad+aElXjq1st8VzhtDW2yYUWNv9x4P1fc+49hP/4bO/9defehO4cga6" +
           "I80zK2A0J2YcJvkG2l99/XOP3fPKH/xEsR4BjGQ/377y0XzUL5wHNy9+8hTU" +
           "R3OofOHz+koUD4olhK4doT0TKm8Hmv7nRxs/8Eq3EtH44WcgKmQVn2RjL8Fm" +
           "8Qbrttlq31LVqKVx0kTQNlNLbK2tddTJTCxiR2SL8cebbVRH63R9sF0j6zSu" +
           "rvl1z28PO9MJo1hSrTdZrYX1ZK0xUtVp88vA8AfToC1hWccvy52W3ONFki61" +
           "I2yBCYN6VB/UjSxKN6KozUtNBG5icBP8LeAyts0qNVP1B925uDJMWuBcfm76" +
           "GEf3EJYMV4RURjcSYYYV3aX1wSgsYSBKzkI+tPBVF5GFpd8fM2ufqgfKutsa" +
           "UQiXMQPJMqyh7Wdbk2I4uTyniOYKwZfi2KGQDW8PazNmaVlj1p5SirQoG2aV" +
           "aHK0mZjjYbuZha1li9vitsBEG4Tkm2WtZA18KhiX53MZj5Aq7qCjYexjstr0" +
           "2h1uloih1PMFYcz0W22QD3njpeYppaARKu2Qoblt0OLKi34nsDrTMV8fDRA2" +
           "TOezdOGZduTXZElZGT0yMNs0UkY7LScUjCk3n6FINtkIpjNHOhrHc+Oh5nHu" +
           "qlW2hPGK4tXBeiXNZnVjppRR3PH0gKfGmWWLfGKJnGm4c6+1opkkwDdm5ixH" +
           "0YB2VKG99TmirqyjaZRqfd/AvAzWF6WUStK4Nxkh61UwndDKakS2fc6lOKlF" +
           "B8JEWc95dJB1iZhqcn5lgdvh0iL6Uk3BqPU68Dlj2eI7hitNSgIVSzLGKrHB" +
           "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" +
           "uq/lxT8GsK2IOPmytdgfPob46+8CYiHZ");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("HwDUVg4gVm4NxL3jBmLR4J+fg/Nf5MXXY+ieXLhW3NKD3Quff3CM8Z+9W4ww" +
           "oKZzgLHzPcL45jkY/zAvfg84j1MKnL+VPYP0374LpIVruApomhwgndx6hf3G" +
           "OXXfzIv/CEAaNwIpHoP8o3crzmuAXvMApPk9EuefnoP0f+bFf42hB4E4haO3" +
           "1vEN5Pnf3q08c7+bHUDNbrk89247p+6O/OGfAZTGDVGeEOh3b4UP+vEDlD/+" +
           "vRHo3uVzoD6QF3cf+aCjF4THkty7591K8nFAzRcPMH7x1kvy+86py98A7z0E" +
           "4Bmn4R2LcO/hdyvC/BzIawfwXrv18L7/nLpn8+LJGLpvlyDcWH5PvdtUIPes" +
           "v3AA8BduPUDsnLpqXuwDgCAVOPOi+BggfCsAfuUA4FduPcDnz6nLE/G9HzwE" +
           "WKQA1wO89k4AZiAXPDr19L4Yqv85D1WDlPqR6374sfuxgvqlVy9fevjVyb/a" +
           "nSM6/EHBXX3o0iJxnJNH+U5cXwxCfWEV3Lprd7AvKFjAxNCH3i6NMXQbKHNo" +
           "e/Su9yCGrr6d3vmRjfz7ZF82hh4/vy/oVXyf7MXH0CM36wXoA+XJ1mIMvfdG" +
           "rUFLUJ5sKcXQlbMtwfzF98l2H4uhu4/bgXXM7uJkkxfA6KBJfvmJXI33qGx3" +
           "IumRk1ZQRLAH30q3Tiyxnjp1SKj48dDhgZ5k9/OhF9Qvv8oMf+TbtZ/dHdpW" +
           "HWVbHJm51Ifu3J0fLwbNDwV98KajHY51sfvsd+7/pbuePly03b8j+NgiT9D2" +
           "xI1PSLfdIC7ONG9/9eFf/sjffPX3i8MT/xeSaA501TUAAA==");
    }
    public static class RGB extends org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam {
        public RGB() { super(); }
        private boolean backgroundSet = false;
        public void unsetBackground() { backgroundSet =
                                          false;
        }
        public boolean isBackgroundSet() {
            return backgroundSet;
        }
        public void setBitDepth(int bitDepth) {
            if (bitDepth !=
                  8 &&
                  bitDepth !=
                  16) {
                throw new java.lang.RuntimeException(
                  );
            }
            this.
              bitDepth =
              bitDepth;
            bitDepthSet =
              true;
        }
        private int[] backgroundRGB;
        public void setBackgroundRGB(int[] rgb) {
            if (rgb.
                  length !=
                  3) {
                throw new java.lang.RuntimeException(
                  );
            }
            backgroundRGB =
              rgb;
            backgroundSet =
              true;
        }
        public int[] getBackgroundRGB() {
            if (!backgroundSet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam9"));
            }
            return backgroundRGB;
        }
        private int[] transparency;
        public void setTransparentRGB(int[] transparentRGB) {
            transparency =
              (int[])
                transparentRGB.
                clone(
                  );
            transparencySet =
              true;
        }
        public int[] getTransparentRGB() {
            if (!transparencySet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam10"));
            }
            return (int[])
                     transparency.
                     clone(
                       );
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
          ("H4sIAAAAAAAAAMV6e+zr1n0f7732vbZj+1478WNe7Dx8nSVR+6MoiXrsdm1E" +
           "iiJFig+JIkVpaR2+RYnim6KozmsatE3QAmmwOVkGtP4r6bbATYqhQdcWDVwE" +
           "XfpICyQtunZo627IsHZZgBjoY1iWZYfU730fjmtv+wG/Q+qc7/ec7/d8v9/P" +
           "+fKc8+I3oLvjCKoEvpvbrp8cmNvkYOmiB0kemPEBPUQFNYpNA3fVOJ6Aumf1" +
           "d/7C1b/51scW1y5Cl+fQm1XP8xM1cXwvHpux725MYwhdPaklXHMdJ9C14VLd" +
           "qHCaOC48dOLkxhB60ynWBLo+PBIBBiLAQAS4FAHunlABpgdML13jBYfqJXEI" +
           "/VPowhC6HOiFeAn0jrOdBGqkrg+7EUoNQA/3FL9loFTJvI2gtx/rvtf5JoU/" +
           "XoGf/xc/dO3fXoKuzqGrjicW4uhAiAQMMofuX5trzYzirmGYxhx6yDNNQzQj" +
           "R3WdXSn3HHo4dmxPTdLIPJ6kojINzKgc82Tm7tcL3aJUT/zoWD3LMV3j6Nfd" +
           "lqvaQNdHT3Tda9gv6oGC9zlAsMhSdfOI5a6V4xkJ9LbzHMc6XmcAAWC9sjaT" +
           "hX881F2eCiqgh/e2c1XPhsUkcjwbkN7tp2CUBHritp0Wcx2o+kq1zWcT6PHz" +
           "dMK+CVDdW05EwZJAj5wnK3sCVnrinJVO2ecb3Pd99Ic9yrtYymyYulvIfw9g" +
           "euoc09i0zMj0dHPPeP97h59QH/21j1yEIED8yDniPc0v/ZNX3vc9T730m3ua" +
           "v38LGl5bmnryrP4p7cGvvBV/T+dSIcY9gR87hfHPaF66v3DYcmMbgMh79LjH" +
           "ovHgqPGl8b+fffAz5tcvQvcNoMu676Zr4EcP6f46cFwzIk3PjNTENAbQvaZn" +
           "4GX7ALoC3oeOZ+5recuKzWQA3eWWVZf98jeYIgt0UUzRFfDueJZ/9B6oyaJ8" +
           "3wYQBD0M/qHHIOjCL0Hl3/6ZQFt44a9NWNVVz/F8WIj8Qv/CoJ6hwokZg3cD" +
           "tAY+rAH/X30vctCCYz+NgEPCfmTDKvCKhblvLONUzRLYWQNngHUfmA8OgKMJ" +
           "HEl4xU+hCOKDwgOD/49jb4t5uZZduABM9tbzgOGCWKN81zCjZ/XnU4x45bPP" +
           "/s7F4wA6nNEEugEEONgLcFAKUIItEOCgFOCgFOAACHBwVoDrYxKDLlwox35L" +
           "IczeVYChVwAyAJje/x7xB+kPfOSdl4CPBtldha0AKXx7TMdPQGZQQqkOPB16" +
           "6ZPZj8o/Ur0IXTwLzoUCoOq+gr0U6Bg6r58Pylv1e/XDf/E3n/vEc/5JeJ5B" +
           "+0PUuJmziPp3np/qyNdNA+DoSffvfbv6+Wd/7bnrF6G7AJQA+ExU4O4AmZ46" +
           "P8aZ6L9xhKSFLncDhS0/Wqtu0XQEf/cli8jPTmpKH3iwfH8IzPFVaB8kF37l" +
           "MD7KZ9H65qAo37L3mcJo57QokfoficHP/tHv/WW9nO4jUL96apkUzeTGKSAp" +
           "OrtaQsZDJz4wiUwT0P3pJ4V//vFvfPgflw4AKJ6+1YDXixIHAAJMCKb5x38z" +
           "/OOX/+xTf3DxxGkSsJKmmuvo22Ml7yl0evAOSoLR3nUiDwAiFwRk4TXXJW/t" +
           "G47lqJprFl76v64+g3z+v3/02t4PXFBz5Ebf8+odnNT/PQz64O/80N8+VXZz" +
           "QS8WwpM5OyHbo+ubT3ruRpGaF3Jsf/SrT/7LL6k/C3AaYGPs7MwS7qByDqDS" +
           "aHCp/3vL8uBcG1IUb4tPO//Z+DqVsDyrf+wPvvmA/M0vvFJKezbjOW1rVg1u" +
           "7N2rKN6+Bd0/dj7SKTVeALrGS9z7r7kvfQv0OAc96gDZYj4C2LM94xmH1Hdf" +
           "+Y+//sVHP/CVS9DFPnSf66tGXy2DDLoXeLcZLwBsbYMfeN/eullh7mulqtBN" +
           "yu+d4vHy12Ug4Htujy/9ImE5CdHH/yfvah/6z//jpkkokeUW6/Q5/jn84s88" +
           "gX//10v+kxAvuJ/a3ozHILk74a19Zv3XF995+TcuQlfm0DX9MHOUVTctAmcO" +
           "sqX4KJ0E2eWZ9rOZz36Zv3EMYW89Dy+nhj0PLifrAHgvqIv3+87hSTnvYMIv" +
           "fOEw1L5wHk8uQOXLD5Qs7yjL60XxD47C90oQORuQFhzG73fA3wXw/7+L/6Kz" +
           "omK/iD+MH2YSbz9OJQKwRD2ggazMjvzUAylscmcjC5GzBsi0OUym4Ocefnn1" +
           "M3/x8/tE6bxFzxGbH3n+J79z8NHnL55KT5++KUM8zbNPUcspe6AoekWMvONO" +
           "o5Qc/f/6ued+9V8/9+G9VA+fTbYI8C3x83/47S8ffPLPf+sW6/UVzfddU/X2" +
           "MF6UtaJ433520dsGzT88a9LrwDR/cmjSP7mNSUe3MWnxipdK984YB2QEQP1n" +
           "bm+cEu32c/3Czz39ez/ywtP/qQSMe5wY+Gk3sm+RUp/i+eaLL3/9qw88+dly" +
           "Ub1LU+O9x57/Frn5U+PMF0Qp+P3Hs3E/tF817+L2s7F/JlD4hiZ1ahDEcLyx" +
           "NbB2x2YEc0Ua5egrMwL9me5RJvn/ftC925CHzls8mAS65Bx+xhZIe+Ewdyud" +
           "qChmR/7xgVv7x8Xi9d0JABvHU90jP7nsmp69z+TfXxRKsD0e4uKer/z9SHK4" +
           "Phb4Bj6ofM8sltqjtn2q6fgHxx+zoHF7k7AR9N7buyFbesMJGn/pQ//ticn3" +
           "Lz7wGnLMt53z0vNd/hv2xd8i36X/s4vQpWNsvulL9yzTjbOIfF9kgk9zb3IG" +
           "l5/cz385f/vJL4pnyim+Q3YQ3qGtrAQfhHfrxVTvLXMH8s0WOoc849eIPE8D" +
           "+3z7EHm+fRvkyb8b5Lk/iVQvBokjyJ7zUvBzku1eVbK9218Ai9TdtYPWQbX4" +
           "/cFbj33p0Ksvx+VGS/FLP5LksaWrXz9au2QzioHzXF+6rSOnvXbi0PutinOC" +
           "9r5rQYFjP3jS2dD37Bs/9bWPffmnn34ZACkN3b0pUgTgn6dG5NJiI+gnXvz4" +
           "k296/s9/qkyswUwKnyCuva/o9SfvpG5R/NgZVZ8oVBVLxBmqccKWubBpHGt7" +
           "DknuAk71d9c2uaZQjXjQPfpj5TlexyRkvKqkmTcnsGGedUWGWMrz9YBpTith" +
           "T51ystPLcbI1EAMSGbmtpL6roGaqbDao0dzN2b64JVdDY+LzfU2sIVJmTZm0" +
           "14jG6rRZk5BIrRiSuO7IypaTp8Pdqkc5wTSErc6ulaKdVpebaPN07g2R1g6u" +
           "WO0WzHdgGK7JyGY1Wk9FxWdFKaEJTTP9/my1jDvbXBv7oVuRh2Tc3xD1gdyq" +
           "VS2DHwf5PO0FDElMBiiDrHvxejIejwJZ6swGa7Xv9wO2upajIUNUF+NOvuov" +
           "FUWUduNkTImhbPd4iZPnA4lrOmsGw2OXrWoqrc9Zeu56BouZNk1MZkiuMrS+" +
           "5pOOUMX05U6j04jSZ4EXzyoushPpZNeJ2Jk6Sww6rE18b70OOXI2i8iKvXJ5" +
           "VhkjlqTJ09loOuVHeUfaaQSRLOeoOvdNk0c8k9fitKZPOHY1GXNzZNtXd2vE" +
           "oCRjosuDEOZqvhTsEDfKZXmgDFBO3w5yYtaWOb+FBf3eLGmmyci2RonMbryK" +
           "N017TpoiZG/AYN0lXY8VVhxP8sQbboceGxODZVxXvB3TS0RRTpxKqxYqy4Qx" +
           "CKPeWldbUwMJqCmR4JHKDvylve2y3GKF2R1aXwXRFO6LTLCaD9JsxlNNdT0I" +
           "PQZLNho1V8WqKE4X266/tmULtZGwvawa0wbhjSb6brgTjCGzVtBV37XQdCSH" +
           "EtvkIreJ+1VlMNmMdGKNjUa76nZIeDEibqraWFrm/AbLXEpnlW6XzBYeI80t" +
           "RZQ3UxXDO4NFZo9lY5BXp8RAcKq9AOOqOEFOtkgojw1qunDEzWoyqGa6XRUQ" +
           "RJ90KXlMNgZzklxVqzApZ4PNxDLQ3JxaCaoalqW4tcUgEbsDW29EDBP7MD53" +
           "mpa0G6rzUO2zTWxG5ibRSvhmFGxUtDsa8K0qMUrVtNXJK8PtJIX1CkM6fFTt" +
           "7txhzuZOtmhVt7y1YQg4WVthld2Sdt2Qkh5KxXWUmW00tl7td1F8HbZGzmSl" +
           "Mqt6qsAwNZQ7W6aXzelqhgUrSkK8BttQAwvxGNJH+luWmwbMkgESEWIYWBEK" +
           "d7t0pnBsVV00eHTMT9ERt6JCeVOLRhVFz6RxOB1hLJJpvBNYihPn5HZItVNy" +
           "II56G9uTshVdJ+oND16sAqzHNZcr1Z2OaWk36pBLA0GwtpEvSWq6wXXbdXvL" +
           "fLYASZXOLfV8WIsCc8zibBhqa9UmpDnpzgLGkmpraTyXdIzgJGydi342I6be" +
           "bt7wJdXy68vBDLUxLIK3reoQBF/gN4huymeEUMN9nQOQQobM2nbRcb2FZTFf" +
           "p7eNcTazqXw48wf1qj0iRgOCJ3Cdsvtdkdbtrq0MugN8PMzwBa1vlFUX72qt" +
           "ui46LI7JWQcLuz22F6OJ13PzrbHRpl5vPZRIBqGUjAqi4UBH0o4t7ogFzY+N" +
           "Sd6A2/F4OdF0Uhz3bDpboTtitZpJbYdQvBFCTtWuI0auC9wFCxNvNQrzFVVT" +
           "lpWmaU7Xu3oXrQ9XWB/NuvFAi+tY0x3qdGXCOFUtTadIB55bBkLWJYKatAYB" +
           "Gtv5xBYNKqp4MPhwRXsrT1R0AMPxrBfQzVGP7mq5hqkjzm4J2qYxIq2Nw4z8" +
           "vMn5FKZydV50XK7fIRFnKrOWYbQygtx5u7aJOUhK8wyPmZXdMp90tkm86eqq" +
           "P5jOsrm3nbUlZbuoDZfbpm5ZPF3TUnQxmbr1ftbDXEts6FlbavJgovicbGTh" +
           "SGoKaG4pu1Yy7SRTXVn28kWTqVVn24iw2t1Ex0mtUvG5yNt5WRa3OiPRWJPi" +
           "JLcwOvRXNJ1LmqQqA46eUDwFDIUhIMwbudomJHXMTEU5FFfihhzBTIKgSd6q" +
           "R3lzoosYvq4wM2USxmMjq3udsKt5zkpKBUPg3O5yuJ7pxroXrLqd3OPzDcdJ" +
           "SCjoi1GthW629ZG5IvM+1+2NtdzWmOp8npHbXpr0+AbsEhUvbWp8llIxL/FW" +
           "CqN6Ig9xxdPgFZswGZzweu52xnNdc9uCuFItHG/r88Xcrqhuxe+vwJyvbb4m" +
           "bGJ/oyFDhJrp0njaJ8jZcEpOBnjFdvRc433anxqwWYeVpmNFItUdqzKNMJo8" +
           "aPgmOxlM/MCdTaUhZ3tUarb5BkgYUi6sRoxLGC3PXc6lLNlhKV+rW71hqJim" +
           "ZQkzfJf7Y2xk7DoeWPR2O5haDhyA9cwQRuuCYVX02phqGEQYdAxK67QtTjBJ" +
           "hJnIrVZbC9ZjXqFlhuDaMC6MlYnBggXaG/BGfdAVUTPbuM3RvIukVKfF1FAr" +
           "G7dI4H00Q4yrjqYtrD4j6vVlNs6xWdIN5TgZCdRmvZlNjZAcNsUFhtqLSkXh" +
           "Ns1MT2gdxllEWOqNmI1aiT6geKLTcSmz0TajLk8Izs4bDnstfptS0mCZE70+" +
           "j2F+1GwzJLINGTbBxUWVzWem2+yFwW5rV3imW8sriw1HO2BtpEdGN2k30p5i" +
           "1CnZa1U6ONluJK6SS9ORssY4a0kIUmKK9a6t6ZN2qtJ+VzbWHtlZK/jSpBeT" +
           "BiE08LbQxuBQsCvEQJqO6x0jlOtS6ElslrXdnYJXQwM3SIGyJ1J9QzU1iSUs" +
           "e4c6qaeAxaZDRkljUe1TVbyFuLSWamN4xI4WVX24mgSTsIngFWPW4aJ0aVkV" +
           "g2enA3lKJXBg4Gzd0JROE+5Qg47YrsgM2cUdGVFUEBcxQ44Yb9a06JbILGVW" +
           "sEir1mpuE663oquUSHKm1NHWTanHkC1iwaCdaqrvgnGQ+clCJjq7rrju8iYx" +
           "XMnb+qoxxIhFxVqHYk+zzKyFDwRlZ8R2RalIusgP9MYQrwo8HulKjFN2QAkw" +
           "LvuB7tEk6SpVBG1UdCEaNTqD+lasKLvGNDSVYR1ejeFohzU4jM+rnCuK+rLL" +
           "IFmrk+AbinYE2mKM6k5mYYxwMs1HQnI+SzrZppOyjV1zbShCwG6Y2Q4GS9Vu" +
           "MuU7Q4Fia8xi1mVCDF8Y2nSrcD7SIHsVJFjX2WaU132iv0uYjaLjqFiDA1Tw" +
           "qHXUH4372zTOKrFgb1sAWAcOhzhebdNYBlZFmIqjZB006kQiR3KPc9vz1Bca" +
           "JhaC1LLvr+LQTcc4I8xljdA623mMZIltM8IGBcYVIobdTqqCFZHxVIx6tsc7" +
           "dH+JTlKFxHOlvyRoD65QlVFND4bBhkKoZtBszd1gZ4opEdZlRVUma1kwK1aD" +
           "paLNTutgijfvm4Lf1tHqWNdhR96Qxg6p8vS8vZQxa00sdc+aj2cVJdQrQ6ta" +
           "Xc8Vd9LOaXMJd6MOcPlRnW80a4EUIEm4o6qTRbOD9dmlP0qpLZlOrMaqv43C" +
           "WOwQ4rLXwCeNbGIr7tK3xgleb7bxjEvCrtdFtJWqrkcrFN/4us1ukAreighY" +
           "07jZKEF6KN4bq7BFjUKf8jUtqtU5HEWVvpSNNFyVzKqzVC3Pk62UJGKuPhHr" +
           "Dp9YtlNPKlXE88YYvImHmhM3iY1Zqc+1paUhFNXFGT5fpG01zJBBKq5Jj603" +
           "4G6vSQ3z9UqZ2y5NRt0x2jGTKm3KDbRhUSAuBLnN9BDSFMKJjeDoGK31tRA0" +
           "af42iHrz+ibqUXV8u63Zu6qkNsgWFWuKLll1ftestZbZdGILWKezYlpYCrcS" +
           "eWZZIdomel5YaSazWc9qKN3NAGUzChvXhKVMNCOvL1ktxWvscmneC2Q57clt" +
           "c2P1lGkzDryKGgqI26vo48yccVg9Zdu4PNAr+G7XiMX6yJHZATaFNTXKOpad" +
           "SLNmbdHgWAQNWv2G6I4El8Mqar6EBVTYbpBOl5st4tmwQdEW+A5YC6iFKiqy" +
           "tKOdrc84nJVaquPSySy1OhZMTtq9TldpDSdIE8thXA23SNLLpEEN3VS4jBhO" +
           "BJkbmv0Rtlm6cKu7mLA1crLoNxd9FK5RHJyP3NCU4ZEfWMv1RNt2Im2eNY2E" +
           "tMajZART04iXZmq17sqGUWmndEPr0fx6bHnTIY8uxmzSdOm+YCGj+WgizdJp" +
           "tMHNhkB2XbhPNuO21Ztsx/GA5WhjvTUbFcbUQrQ5VsHXwqjXmNWN0aLZnYXS" +
           "iHWXZIsByNwTciUGK5ph4DWW67lVqZvS2M6gyWbG08Jypnk7fYTbxIaXVWYy" +
           "ay23Uy2yQzBz/AggOOa0kZ6yyVgvwOrLHDGMjbeIaw0RgSs5s67PbCZh7Rgd" +
           "wxg9VlcYH0WBqqs1ktZ4YRKhy0a8dXaGnWLUjK9syLRat1OfVjGwGk8sxVrK" +
           "0aI6tlrsLhLqwlBFZuNONQ+TwWgwrGiIgk6mCpYTXD3Bg2nTHFC1JVfRDFjp" +
           "sFFId9AOl/SwYUOkm12+pdaJFcojLc9PvZ7JtUYTetvFaREELL6pzjpWq1bz" +
           "2CiasO2OtOJzuT/GKztpPmmahIBiu7xjkxr4BN/OKwLJr4INMovg6joRDZkK" +
           "tVVXbhvu1MtA2tbI6kNBjxfWUicJbDiqLtYzmyP9ecfbLRZCy2zPRMzH9GED" +
           "ndNwN3MZnGwFA7vbLbYYPvHatj4eKnd5jm+nLN1W0fATr2F3Y3unDdNywJMz" +
           "znLL7aHzFx1O7ZWdOviCimOHJ293F6U8cvjUh55/weA/jVw83McbJtDlwytC" +
           "J/1cKd9XZw+TnwFjf/FQhi+e3687Uf7Wm3Xv3r7a3uRn7tD2YlF8OoGupl5s" +
           "JtjxQcMtd5o2vmOcmOHnXm2T6fRY59R+rKh8F9Dgtw/V/u03Xu1fvkPbrxbF" +
           "LwK1nRg7ffJVVNMnKn7+dahYWvZ7gbRfPVTxq2+MihdOCN5fEvzGHfT8UlG8" +
           "lEBvKozrJD0z2J8PfPZEx19/vTrCQJqvHer4tTdcR6Uk+ModdPz9ovhyAoY5" +
           "7cBjEjun6O++DkUfOQrTvzpU9K/eeH/90zu0vVwUfwR0tG+ho3Ki4x+/XmPe" +
           "AFh5Zc+7f/5fMOZf3kHRrxfF18BKAIw5OT58SG625n95vdYE6HPxkUNNH3nj" +
           "rfnXd2j726L4JlDSvpWSp8z5ymtRcptAl4rz4aL+kQRq/R1vnYF17vGbbsbu" +
           "b3Pqn33h6j2PvSD9h/3x8NGNy3uH0D1W6rqnLzucer8cRKbllIrfu7/6EBSP" +
           "C1ACvfu7lRGoBspSte/suS8l0PXvhrs4diuep3kvJ9BTd+YFXOXzNNe9CfT4" +
           "7biAfKA8TX1/Ar3lVtSAEpSnKa+CsD5P");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("CcYvn6fpHk6g+07oQHKxfzlNAsx+CZAUr4+Wnvzt7YWzScyxaz38aq51Ku95" +
           "+sxBb3m7+uhQNt3fr35W/9wLNPfDrzQ/vb/Wprvqblf0cs8QurK/YVd2Whzs" +
           "vuO2vR31dZl6z7ce/IV7nznKpB7cC3wSlKdke9ut75AR6yApb33t/t1jv/h9" +
           "/+qFPytP5f4PiNS1JPYuAAA=");
    }
    protected int bitDepth;
    protected boolean bitDepthSet = false;
    public abstract void setBitDepth(int bitDepth);
    public int getBitDepth() { if (!bitDepthSet) {
                                   throw new java.lang.IllegalStateException(
                                     org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                       getString(
                                         "PNGEncodeParam11"));
                               }
                               return bitDepth;
    }
    public void unsetBitDepth() { bitDepthSet =
                                    false;
    }
    private boolean useInterlacing = false;
    public void setInterlacing(boolean useInterlacing) {
        this.
          useInterlacing =
          useInterlacing;
    }
    public boolean getInterlacing() { return useInterlacing;
    }
    public void unsetBackground() { throw new java.lang.RuntimeException(
                                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                        getString(
                                          "PNGEncodeParam23"));
    }
    public boolean isBackgroundSet() { throw new java.lang.RuntimeException(
                                         org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                           getString(
                                             "PNGEncodeParam24"));
    }
    private float[] chromaticity = null;
    private boolean chromaticitySet = false;
    public void setChromaticity(float[] chromaticity) {
        if (chromaticity.
              length !=
              8) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          chromaticity =
          (float[])
            chromaticity.
            clone(
              );
        chromaticitySet =
          true;
    }
    public void setChromaticity(float whitePointX,
                                float whitePointY,
                                float redX,
                                float redY,
                                float greenX,
                                float greenY,
                                float blueX,
                                float blueY) {
        float[] chroma =
          new float[8];
        chroma[0] =
          whitePointX;
        chroma[1] =
          whitePointY;
        chroma[2] =
          redX;
        chroma[3] =
          redY;
        chroma[4] =
          greenX;
        chroma[5] =
          greenY;
        chroma[6] =
          blueX;
        chroma[7] =
          blueY;
        setChromaticity(
          chroma);
    }
    public float[] getChromaticity() { if (!chromaticitySet) {
                                           throw new java.lang.IllegalStateException(
                                             org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                               getString(
                                                 "PNGEncodeParam12"));
                                       }
                                       return (float[])
                                                chromaticity.
                                                clone(
                                                  );
    }
    public void unsetChromaticity() { chromaticity =
                                        null;
                                      chromaticitySet =
                                        false;
    }
    public boolean isChromaticitySet() { return chromaticitySet;
    }
    private float gamma;
    private boolean gammaSet = false;
    public void setGamma(float gamma) { this.
                                          gamma =
                                          gamma;
                                        gammaSet =
                                          true;
    }
    public float getGamma() { if (!gammaSet) {
                                  throw new java.lang.IllegalStateException(
                                    org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                      getString(
                                        "PNGEncodeParam13"));
                              }
                              return gamma;
    }
    public void unsetGamma() { gammaSet =
                                 false; }
    public boolean isGammaSet() { return gammaSet;
    }
    private int[] paletteHistogram = null;
    private boolean paletteHistogramSet =
      false;
    public void setPaletteHistogram(int[] paletteHistogram) {
        this.
          paletteHistogram =
          (int[])
            paletteHistogram.
            clone(
              );
        paletteHistogramSet =
          true;
    }
    public int[] getPaletteHistogram() { if (!paletteHistogramSet) {
                                             throw new java.lang.IllegalStateException(
                                               org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGEncodeParam14"));
                                         }
                                         return paletteHistogram;
    }
    public void unsetPaletteHistogram() {
        paletteHistogram =
          null;
        paletteHistogramSet =
          false;
    }
    public boolean isPaletteHistogramSet() {
        return paletteHistogramSet;
    }
    private byte[] ICCProfileData = null;
    private boolean ICCProfileDataSet = false;
    public void setICCProfileData(byte[] ICCProfileData) {
        this.
          ICCProfileData =
          (byte[])
            ICCProfileData.
            clone(
              );
        ICCProfileDataSet =
          true;
    }
    public byte[] getICCProfileData() { if (!ICCProfileDataSet) {
                                            throw new java.lang.IllegalStateException(
                                              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                getString(
                                                  "PNGEncodeParam15"));
                                        }
                                        return (byte[])
                                                 ICCProfileData.
                                                 clone(
                                                   );
    }
    public void unsetICCProfileData() { ICCProfileData =
                                          null;
                                        ICCProfileDataSet =
                                          false;
    }
    public boolean isICCProfileDataSet() {
        return ICCProfileDataSet;
    }
    private int[] physicalDimension = null;
    private boolean physicalDimensionSet =
      false;
    public void setPhysicalDimension(int[] physicalDimension) {
        this.
          physicalDimension =
          (int[])
            physicalDimension.
            clone(
              );
        physicalDimensionSet =
          true;
    }
    public void setPhysicalDimension(int xPixelsPerUnit,
                                     int yPixelsPerUnit,
                                     int unitSpecifier) {
        int[] pd =
          new int[3];
        pd[0] =
          xPixelsPerUnit;
        pd[1] =
          yPixelsPerUnit;
        pd[2] =
          unitSpecifier;
        setPhysicalDimension(
          pd);
    }
    public int[] getPhysicalDimension() {
        if (!physicalDimensionSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam16"));
        }
        return (int[])
                 physicalDimension.
                 clone(
                   );
    }
    public void unsetPhysicalDimension() {
        physicalDimension =
          null;
        physicalDimensionSet =
          false;
    }
    public boolean isPhysicalDimensionSet() {
        return physicalDimensionSet;
    }
    private org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[]
      suggestedPalette =
      null;
    private boolean suggestedPaletteSet =
      false;
    public void setSuggestedPalette(org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[] palette) {
        suggestedPalette =
          (org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[])
            palette.
            clone(
              );
        suggestedPaletteSet =
          true;
    }
    public org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[] getSuggestedPalette() {
        if (!suggestedPaletteSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam17"));
        }
        return (org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[])
                 suggestedPalette.
                 clone(
                   );
    }
    public void unsetSuggestedPalette() {
        suggestedPalette =
          null;
        suggestedPaletteSet =
          false;
    }
    public boolean isSuggestedPaletteSet() {
        return suggestedPaletteSet;
    }
    private int[] significantBits = null;
    private boolean significantBitsSet = false;
    public void setSignificantBits(int[] significantBits) {
        this.
          significantBits =
          (int[])
            significantBits.
            clone(
              );
        significantBitsSet =
          true;
    }
    public int[] getSignificantBits() { if (!significantBitsSet) {
                                            throw new java.lang.IllegalStateException(
                                              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                getString(
                                                  "PNGEncodeParam18"));
                                        }
                                        return (int[])
                                                 significantBits.
                                                 clone(
                                                   );
    }
    public void unsetSignificantBits() { significantBits =
                                           null;
                                         significantBitsSet =
                                           false;
    }
    public boolean isSignificantBitsSet() {
        return significantBitsSet;
    }
    private int SRGBIntent;
    private boolean SRGBIntentSet = false;
    public void setSRGBIntent(int SRGBIntent) {
        this.
          SRGBIntent =
          SRGBIntent;
        SRGBIntentSet =
          true;
    }
    public int getSRGBIntent() { if (!SRGBIntentSet) {
                                     throw new java.lang.IllegalStateException(
                                       org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                         getString(
                                           "PNGEncodeParam19"));
                                 }
                                 return SRGBIntent;
    }
    public void unsetSRGBIntent() { SRGBIntentSet =
                                      false;
    }
    public boolean isSRGBIntentSet() { return SRGBIntentSet;
    }
    private java.lang.String[] text = null;
    private boolean textSet = false;
    public void setText(java.lang.String[] text) {
        this.
          text =
          text;
        textSet =
          true;
    }
    public java.lang.String[] getText() {
        if (!textSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam20"));
        }
        return text;
    }
    public void unsetText() { text = null;
                              textSet = false;
    }
    public boolean isTextSet() { return textSet;
    }
    private java.util.Date modificationTime;
    private boolean modificationTimeSet =
      false;
    public void setModificationTime(java.util.Date modificationTime) {
        this.
          modificationTime =
          modificationTime;
        modificationTimeSet =
          true;
    }
    public java.util.Date getModificationTime() {
        if (!modificationTimeSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam21"));
        }
        return modificationTime;
    }
    public void unsetModificationTime() {
        modificationTime =
          null;
        modificationTimeSet =
          false;
    }
    public boolean isModificationTimeSet() {
        return modificationTimeSet;
    }
    boolean transparencySet = false;
    public void unsetTransparency() { transparencySet =
                                        false;
    }
    public boolean isTransparencySet() { return transparencySet;
    }
    private java.lang.String[] zText = null;
    private boolean zTextSet = false;
    public void setCompressedText(java.lang.String[] text) {
        this.
          zText =
          text;
        zTextSet =
          true;
    }
    public java.lang.String[] getCompressedText() {
        if (!zTextSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam22"));
        }
        return zText;
    }
    public void unsetCompressedText() { zText =
                                          null;
                                        zTextSet =
                                          false;
    }
    public boolean isCompressedTextSet() {
        return zTextSet;
    }
    java.util.List chunkType = new java.util.ArrayList(
      );
    java.util.List chunkData = new java.util.ArrayList(
      );
    public synchronized void addPrivateChunk(java.lang.String type,
                                             byte[] data) {
        chunkType.
          add(
            type);
        chunkData.
          add(
            data.
              clone(
                ));
    }
    public synchronized int getNumPrivateChunks() {
        return chunkType.
          size(
            );
    }
    public synchronized java.lang.String getPrivateChunkType(int index) {
        return (java.lang.String)
                 chunkType.
                 get(
                   index);
    }
    public synchronized byte[] getPrivateChunkData(int index) {
        return (byte[])
                 chunkData.
                 get(
                   index);
    }
    public synchronized void removeUnsafeToCopyPrivateChunks() {
        java.util.List newChunkType =
          new java.util.ArrayList(
          );
        java.util.List newChunkData =
          new java.util.ArrayList(
          );
        int len =
          getNumPrivateChunks(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            java.lang.String type =
              getPrivateChunkType(
                i);
            char lastChar =
              type.
              charAt(
                3);
            if (lastChar >=
                  'a' &&
                  lastChar <=
                  'z') {
                newChunkType.
                  add(
                    type);
                newChunkData.
                  add(
                    getPrivateChunkData(
                      i));
            }
        }
        chunkType =
          newChunkType;
        chunkData =
          newChunkData;
    }
    public synchronized void removeAllPrivateChunks() {
        chunkType =
          new java.util.ArrayList(
            );
        chunkData =
          new java.util.ArrayList(
            );
    }
    private static final int abs(int x) {
        return x <
          0
          ? -x
          : x;
    }
    public static final int paethPredictor(int a,
                                           int b,
                                           int c) {
        int p =
          a +
          b -
          c;
        int pa =
          abs(
            p -
              a);
        int pb =
          abs(
            p -
              b);
        int pc =
          abs(
            p -
              c);
        if (pa <=
              pb &&
              pa <=
              pc) {
            return a;
        }
        else
            if (pb <=
                  pc) {
                return b;
            }
            else {
                return c;
            }
    }
    public int filterRow(byte[] currRow, byte[] prevRow,
                         byte[][] scratchRows,
                         int bytesPerRow,
                         int bytesPerPixel) {
        int[] badness =
          { 0,
        0,
        0,
        0,
        0 };
        int curr;
        int left;
        int up;
        int upleft;
        int diff;
        int pa;
        int pb;
        int pc;
        for (int i =
               bytesPerPixel;
             i <
               bytesPerRow +
               bytesPerPixel;
             i++) {
            curr =
              currRow[i] &
                255;
            left =
              currRow[i -
                        bytesPerPixel] &
                255;
            up =
              prevRow[i] &
                255;
            upleft =
              prevRow[i -
                        bytesPerPixel] &
                255;
            badness[0] +=
              curr;
            diff =
              curr -
                left;
            scratchRows[1][i] =
              (byte)
                diff;
            badness[1] +=
              diff >
                0
                ? diff
                : -diff;
            diff =
              curr -
                up;
            scratchRows[2][i] =
              (byte)
                diff;
            badness[2] +=
              diff >=
                0
                ? diff
                : -diff;
            diff =
              curr -
                (left +
                   up >>
                   1);
            scratchRows[3][i] =
              (byte)
                diff;
            badness[3] +=
              diff >=
                0
                ? diff
                : -diff;
            pa =
              up -
                upleft;
            pb =
              left -
                upleft;
            if (pa <
                  0) {
                if (pb <
                      0) {
                    if (pa >=
                          pb)
                        diff =
                          curr -
                            left;
                    else
                        diff =
                          curr -
                            up;
                }
                else {
                    pc =
                      pa +
                        pb;
                    pa =
                      -pa;
                    if (pa <=
                          pb)
                        if (pa <=
                              pc)
                            diff =
                              curr -
                                left;
                        else
                            diff =
                              curr -
                                upleft;
                    else
                        if (pb <=
                              -pc)
                            diff =
                              curr -
                                up;
                        else
                            diff =
                              curr -
                                upleft;
                }
            }
            else {
                if (pb <
                      0) {
                    pb =
                      -pb;
                    if (pa <=
                          pb) {
                        pc =
                          pb -
                            pa;
                        if (pa <=
                              pc)
                            diff =
                              curr -
                                left;
                        else
                            if (pb ==
                                  pc)
                                diff =
                                  curr -
                                    up;
                            else
                                diff =
                                  curr -
                                    upleft;
                    }
                    else {
                        pc =
                          pa -
                            pb;
                        if (pb <=
                              pc)
                            diff =
                              curr -
                                up;
                        else
                            diff =
                              curr -
                                upleft;
                    }
                }
                else {
                    if (pa <=
                          pb)
                        diff =
                          curr -
                            left;
                    else
                        diff =
                          curr -
                            up;
                }
            }
            scratchRows[4][i] =
              (byte)
                diff;
            badness[4] +=
              diff >=
                0
                ? diff
                : -diff;
        }
        int filterType =
          0;
        int minBadness =
          badness[0];
        for (int i =
               1;
             i <
               5;
             i++) {
            if (badness[i] <
                  minBadness) {
                minBadness =
                  badness[i];
                filterType =
                  i;
            }
        }
        if (filterType ==
              0) {
            java.lang.System.
              arraycopy(
                currRow,
                bytesPerPixel,
                scratchRows[0],
                bytesPerPixel,
                bytesPerRow);
        }
        return filterType;
    }
    public PNGEncodeParam() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A/OPcRCPSfCz1OWY5nBjWxyfzBnXtuc8");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("rXu8pG6HEBwPq815jsbW9K6Z4E8k4sP10OAPYWasRCLN5rOpa/B4qsN0fnTS" +
       "omMPuAsBrKc4vKc8iw4ZOeQiMFGNEti/lOT9CpOHzJCyMdVjlworby0UBU9+" +
       "iZQ9TeMMYP4YB3GsYGIR1SgcacyFw+CzEtk8h8mTfLehTTD8Mb7Bw5ZsflM4" +
       "2fA14KBs+dibbEQ15pPNHyWywYdwBV/MlU3uJqzgS4XxRCsAwV84kr8UTDai" +
       "GiXQJRtUg7hBNfgGJdN0tSfRq7bHDaVLbUvgy3WdXcvucd4sjIiWEFLEl5CL" +
       "ZKvPnkQkrFEshiIiycPGgu9TMs4UUXUsJpPMyW9iZe+BmA78l3Mc5R4kw/Yh" +
       "4ekC9zdnTJBUm6d3FZVJZITPkS8qpiSgdDq8cFHehy4PbHCaDxzzdeci2ZK1" +
       "q0CkrxIRVuvAK97oVTRRIprJmJxCyYikotLuZl2NaPiKQIeUxhbmdg7qdxOH" +
       "s0kiJUxyoz8hqQNeEeOjiLnNrRnf+XimPhaIAz8+fmLe/C7046SjvTTUFUv0" +
       "hTCexNcDr9RVZYvx73l2tawx6xGWRXNRyL7lyWSSuHUk88knNsOZIzGcSkxm" +
       "UDK0S4tRVW9J9DlsZqZ3m+k3385kexgFvndyQs6rws3XW4fv3FNeMn5P+9Pm" +
       "mybSr6Ae3kBKulKxmP21iLbrIRDmd7HHXZLhLB3FntVWtISSuQN9YgZ4kqT5" +
       "sLmis0zq5ZRUDIQa3xyA33baKkqmymmBin3bqVZQMkFEhZ6uj9pLV1Nyiltp" +
       "KMmfr5cuuQqmA86S0D77tpero6TUKkfJEPPCXmQt1A5F8PL8pMtcw3zrZb/5" +
       "VJRJ3BIyBkTyOp0Mif0tuSgC9gr69NOeUs38QUQH9qxt3PHO0tvNt/SGY8r2" +
       "7VjLsAZSbL4LmFUayHmokb22dF1D1sz7YMRdQ2enn0ST9ZZgO2/MrqF/sTfq" +
       "TnS8ttaoyLy99tnbPnb4sSuHPOEnvo3Ep0AkuDH3/aD9yZROpm1scHuP4npF" +
       "Z2/UrSp9ZdPjf/+db3T6VZz4IpGpMoqO8O7DzzV3JZM3+8nQejC1eETtZy8v" +
       "XbUt3qKGe/Ws1zIO6cQD8qasGsgI7HYKzhmZZLhAyzK/4gucKZmZ+4bK3Jda" +
       "l4IDU/WV/LkD+MaYrHd+pJJJey6TbAcmi/pN/x3oaFiXTPL3GhcdZZIHV4fm" +
       "dxFzb/8HuaiiZGeCAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gx4czIVKpaL5jWV3jMXykB92U3gyZUh6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "B2SD6eu2pzom0r87B9P7s4Mgoru83eX+");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("8g273J9bpJeftiMve7XG5dsBSfUEkpfuukby8pULCHYuV7ckqxdP8oEdedl+" +
       "aJefDvzQ2kB3yfLyM85rni8G9LZbkl++YUvy89N8dEfei7PkIUBT90/eTu2Q" +
       "5sPnlearAD1+S5O/aOPc9KCXd7xw5nL2wpnL+SD3jMzjnrA521GZvvy8ZFFA" +
       "8nVbsq+9GLKXD2+uMIfJmtq37qD96ixBb402dt7I4UVrgBvaN+wFfn5Vpnbk" +
       "ZfPslwnAUz2Z55HQ4XL9vOLNetQ3bHm+4eJ5DnbkjbKkG+SetQkdbiJR7rzO" +
       "KdsX7fu2TL/v4pm+fkfePEteC5iC2OG03QoPmX77eWVKAoZv2zJ928UwPRI8" +
       "vGpNydxBNxPdZXUT4R/fhfCYVLVzcH1xdhD0ppffveX67ouXarwjL80SfxPh" +
       "n0Dz0qsOad50g6xbifDfv6X5/oun+f078v5RlrzpIMK/iTy/+yIi/I9siX7k" +
       "4om+dUfeP8uSH15H+MdZ3mikP3IB89aXP70l+umLNtJtEPHOHWzflSX/PNtI" +
       "EQj1ho0ej8r0HeftS7MQ/7Nbqp+9eJn+/I6892bJuwFL9SSWR3vSm+4idjOB" +
       "ZsHv57csP3/xLD+8I+/fZMkHQcSwMdGd0vzQeS00c0Vf2vL80sXz/MSOvGxX" +
       "qsu/CHgCCz15+89Dnv/2vPJ8BeD3jS3Pb1y4gW7C3R1vqricvani8qeC3F2Z" +
       "SI9uJnpUmp8+76qL5+Vy+7dv6m6+L1aav78j7z9nye8AguoxgkfWXVz+3Qu4" +
       "m72/XT21+b5Ygl/Ykfd/ZcnnDu5mnyrDP76A+377D2wpPnDxFL+2I+8vsuQr" +
       "67vZN24se0jxv1yAc91/bEvxsYs2xkvxmsvf7eD591nyN0HudiDI7aaPR0X4" +
       "t+dd+fVcwKuy5Ve5cBHuX9mRd2eWXAbU1GvULsXXqO3vn1d0GbVt3c33xVJ7" +
       "xo68Z2XJPUHujrUB3ii3/XvPa3qZ+9xuY79/wzb25yf38I68F2bJcwE53T+6" +
       "5+chueedV3KvBKS2KzT3z7JC89aMbv36uf2X72B4NUteshlHMsf2qD0myMfO" +
       "wXVdDMSo+8qWq3LxgsR25L0yS+DNOPIEmpfecUizfAHjyH13S9O9eJr1HXnN" +
       "LPm2g3HkTeT5mgsYR+7HW6LxxRPlduT1s6S9HkceZ3mjkXYuYEXM/nZaa//i" +
       "p7X2v31H3ndkyfhgRczgyE7Nx6R507cE3MKKmP3tSxf2L2iR11Ei2o68RZaI" +
       "6xUxgxP2oj4kKZ1XktmG3j+xJfkTF0PyeIyzH+xgusoSZ3PPL9uF15N9X5ZO" +
       "6DXd80Y72S7H790yfe/Fi/O7d+R9b5a8YXPP7waSR+Oe77yAe377H96S/PDF" +
       "k/yRHXk/miVvPrjnt1OWb7mAe3772zd67N/wRo/z03zHjryfyJK3re/5Xc/x" +
       "RuO86eb6O2iuh1RNQO/fb2n++zPQPHie52l+YmcvcLT19OB1wMeYHb7xYf0c" +
       "0eYm/f7P7OD/c1nyL8HgS5AkbvN2XCLb+vuYiH/qHNzX708D+fu/t+X+e2fm" +
       "nkF4903l/K925P1ClrxvEyCxoXWU6rr84XTB/vvPwXX9JooS4Pi5LdfPXSDX" +
       "41M/+x/fQfiXs+Sj27VDR9huX4l66Q2HhG+6wfytEN5O5+2fZTrvzIR/fQfh" +
       "38iSX7uR8I1rMfb/3Xkt+dWA6F9sCf/FfyVt/k878j6bJf8xyD3kyZazkoe2" +
       "LyjywCEcNzmu2Uet+DPn5Y3kcrdtZ/puO8tM31l4f35H3p9myR8EuWdteOOm" +
       "uYvuH56D7vpN7Q8Dmvds6d5zBrrrZQnZbYPrnvm8mXL/2Q7iX82SLwa5y8L8" +
       "uLv60nld88sAu+3U321nmfo7+cnWYyROX6ex///u4PvNLPnLIHe3K8iBxnmy" +
       "pIuB4x2j/lfnnbkGdG97/Zb6689AfUfgcdu6wG3L7Ysot27n8G1U6wVrzwKn" +
       "YDbX3XwHueRCX+yZveREiAJo/bwqtH5AF3JtFeJYcv3Qal3OjnkHbxX973fx" +
       "eN1GruvmrteO2247XTtue2qWgDa7Q9HNQPb6TnS9Ytx26SyKEQM1A9COPJPr" +
       "+l7ugWNPLXOCaADsT4gfeNc9V579ruFn93L725eTZye8o5O7ooSmeeQd5Eff" +
       "R/4UEFkq+lph7lind7trJvcHucdu9YWMwPrdzZvDbrtvU/uZQe7RW6mdvao8" +
       "+z5a94Eg9+DuuqDW+vtorecGuQdOq5V5pyg4WvrBIPeMk0qDktvXtB2UfEGQ" +
       "u/d4SXD99ffRco8GuTsPywW5p2x+HC3yEnB2UCT7+djmiarrX8DWnWe6HW8e" +
       "7n7gqHPIVCd3/81U51oVL/fIda8JcjPVOXijfcht30b0wXfR7Bu+XvmZvdxe" +
       "J3tjvJBmaz5yVzq52xXHs4TNIphL8fE3Gx0928G5nkK99Jt3f+iOFx08K3/3" +
       "BvChozqC7aHDFwsRjmkCyrpj+482LDdIsjcNpR999oe/9efe9UfZudz/H2c3" +
       "JBi5lwAA");
}
