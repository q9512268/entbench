package org.apache.batik.ext.awt.image.rendered;
public class FormatRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public static org.apache.batik.ext.awt.image.rendered.CachableRed construct(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                                                java.awt.image.ColorModel cm) {
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                ) !=
              srcCM.
              hasAlpha(
                ) ||
              cm.
              isAlphaPremultiplied(
                ) !=
              srcCM.
              isAlphaPremultiplied(
                ))
            return new org.apache.batik.ext.awt.image.rendered.FormatRed(
              src,
              cm);
        if (cm.
              getNumComponents(
                ) !=
              srcCM.
              getNumComponents(
                ))
            throw new java.lang.IllegalArgumentException(
              "Incompatible ColorModel given");
        if (srcCM instanceof java.awt.image.ComponentColorModel &&
              cm instanceof java.awt.image.ComponentColorModel)
            return src;
        if (srcCM instanceof java.awt.image.DirectColorModel &&
              cm instanceof java.awt.image.DirectColorModel)
            return src;
        return new org.apache.batik.ext.awt.image.rendered.FormatRed(
          src,
          cm);
    }
    public FormatRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                     java.awt.image.SampleModel sm) { super(
                                                        cr,
                                                        cr.
                                                          getBounds(
                                                            ),
                                                        makeColorModel(
                                                          cr,
                                                          sm),
                                                        sm,
                                                        cr.
                                                          getTileGridXOffset(
                                                            ),
                                                        cr.
                                                          getTileGridYOffset(
                                                            ),
                                                        null);
    }
    public FormatRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                     java.awt.image.ColorModel cm) { super(
                                                       cr,
                                                       cr.
                                                         getBounds(
                                                           ),
                                                       cm,
                                                       makeSampleModel(
                                                         cr,
                                                         cm),
                                                       cr.
                                                         getTileGridXOffset(
                                                           ),
                                                       cr.
                                                         getTileGridYOffset(
                                                           ),
                                                       null);
    }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.lang.Object getProperty(java.lang.String name) {
        return getSource(
                 ).
          getProperty(
            name);
    }
    public java.lang.String[] getPropertyNames() { return getSource(
                                                            ).
                                                     getPropertyNames(
                                                       );
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        java.awt.image.ColorModel cm =
          getColorModel(
            );
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          getSource(
            );
        java.awt.image.ColorModel srcCM =
          cr.
          getColorModel(
            );
        java.awt.image.SampleModel srcSM =
          cr.
          getSampleModel(
            );
        srcSM =
          srcSM.
            createCompatibleSampleModel(
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  ));
        java.awt.image.WritableRaster srcWR;
        srcWR =
          java.awt.image.Raster.
            createWritableRaster(
              srcSM,
              new java.awt.Point(
                wr.
                  getMinX(
                    ),
                wr.
                  getMinY(
                    )));
        getSource(
          ).
          copyData(
            srcWR);
        java.awt.image.BufferedImage srcBI =
          new java.awt.image.BufferedImage(
          srcCM,
          srcWR.
            createWritableTranslatedChild(
              0,
              0),
          srcCM.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.image.BufferedImage dstBI =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            srcBI,
            dstBI);
        return wr;
    }
    public static java.awt.image.SampleModel makeSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                                                             java.awt.image.ColorModel cm) {
        java.awt.image.SampleModel srcSM =
          cr.
          getSampleModel(
            );
        return cm.
          createCompatibleSampleModel(
            srcSM.
              getWidth(
                ),
            srcSM.
              getHeight(
                ));
    }
    public static java.awt.image.ColorModel makeColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                                                           java.awt.image.SampleModel sm) {
        java.awt.image.ColorModel srcCM =
          cr.
          getColorModel(
            );
        java.awt.color.ColorSpace cs =
          srcCM.
          getColorSpace(
            );
        int bands =
          sm.
          getNumBands(
            );
        int bits;
        int dt =
          sm.
          getDataType(
            );
        switch (dt) {
            case java.awt.image.DataBuffer.
                   TYPE_BYTE:
                bits =
                  8;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_SHORT:
                bits =
                  16;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_USHORT:
                bits =
                  16;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_INT:
                bits =
                  32;
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Unsupported DataBuffer type: " +
                  dt);
        }
        boolean hasAlpha =
          srcCM.
          hasAlpha(
            );
        if (hasAlpha) {
            if (bands ==
                  srcCM.
                  getNumComponents(
                    ) -
                  1)
                hasAlpha =
                  false;
            else
                if (bands !=
                      srcCM.
                      getNumComponents(
                        ))
                    throw new java.lang.IllegalArgumentException(
                      "Incompatible number of bands in and out");
        }
        else {
            if (bands ==
                  srcCM.
                  getNumComponents(
                    ) +
                  1)
                hasAlpha =
                  true;
            else
                if (bands !=
                      srcCM.
                      getNumComponents(
                        ))
                    throw new java.lang.IllegalArgumentException(
                      "Incompatible number of bands in and out");
        }
        boolean preMult =
          srcCM.
          isAlphaPremultiplied(
            );
        if (!hasAlpha)
            preMult =
              false;
        if (sm instanceof java.awt.image.ComponentSampleModel) {
            int[] bitsPer =
              new int[bands];
            for (int i =
                   0;
                 i <
                   bands;
                 i++)
                bitsPer[i] =
                  bits;
            return new java.awt.image.ComponentColorModel(
              cs,
              bitsPer,
              hasAlpha,
              preMult,
              hasAlpha
                ? java.awt.Transparency.
                    TRANSLUCENT
                : java.awt.Transparency.
                    OPAQUE,
              dt);
        }
        else
            if (sm instanceof java.awt.image.SinglePixelPackedSampleModel) {
                java.awt.image.SinglePixelPackedSampleModel sppsm;
                sppsm =
                  (java.awt.image.SinglePixelPackedSampleModel)
                    sm;
                int[] masks =
                  sppsm.
                  getBitMasks(
                    );
                if (bands ==
                      4)
                    return new java.awt.image.DirectColorModel(
                      cs,
                      bits,
                      masks[0],
                      masks[1],
                      masks[2],
                      masks[3],
                      preMult,
                      dt);
                else
                    if (bands ==
                          3)
                        return new java.awt.image.DirectColorModel(
                          cs,
                          bits,
                          masks[0],
                          masks[1],
                          masks[2],
                          0,
                          preMult,
                          dt);
                    else
                        throw new java.lang.IllegalArgumentException(
                          "Incompatible number of bands out for ColorModel");
            }
        throw new java.lang.IllegalArgumentException(
          "Unsupported SampleModel Type");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUZC5AUxbV379j7cHAf5OPpHXAcWvx2xU9IcsaIC8jhHlxx" +
       "SCpHwtI723s3MDszzPRyC4YgVCVcrIqxBMUkelVJMB8LP5WEijEFkkr5C1FL" +
       "tBKRxG9V1KCJpEoxIdG81z2zMzv7EUKqslXTO9v93ut+/9dvD7xLxtkW6TKp" +
       "nqZRvtVkdrQf3/upZbN0XKO2vQZmk8otr+3Zcfr5hp1hEhkkE4ep3adQmy1T" +
       "mZa2B0mHqtuc6gqzVzKWRox+i9nM2kK5auiDZLJq92ZNTVVU3mekGQKspVaC" +
       "tFLOLTWV46zXIcDJ9IQ4TUycJrY4CNCTIE2KYW71ENqLEOK+NYTNevvZnLQk" +
       "NtItNJbjqhZLqDbvyVtknmloW4c0g0dZnkc3alc5gliRuKpEDF0PNX9w5rbh" +
       "FiGGSVTXDS5YtFcz29C2sHSCNHuzSzWWtTeTr5KaBBnvA+akO+FuGoNNY7Cp" +
       "y68HBaefwPRcNm4IdrhLKWIqeCBOZhYTMalFsw6ZfnFmoFDPHd4FMnA7o8Ct" +
       "q+4Ai3fMi+3dt77lpzWkeZA0q/oAHkeBQ3DYZBAEyrIpZtmL02mWHiStOih8" +
       "gFkq1dRtjrbbbHVIpzwHJuCKBSdzJrPEnp6sQJPAm5VTuGEV2MsIo3J+jcto" +
       "dAh4neLxKjlchvPAYKMKB7MyFGzPQandpOppYUfFGAUeu28AAECtyzI+bBS2" +
       "qtUpTJA2aSIa1YdiA2B8+hCAjjPABC1haxWIoqxNqmyiQyzJybQgXL9cAqgG" +
       "IQhE4WRyEExQAi21B7Tk08+7K6++9SZ9uR4mIThzmikann88IHUGkFazDLMY" +
       "+IFEbJqbuJNOOTQaJgSAJweAJcwvvnLq2vmdR56UMBeVgVmV2sgUnlT2pyY+" +
       "d3F8zmdq8Bj1pmGrqPwizoWX9TsrPXkTIs2UAkVcjLqLR1Y//sWb72Mnw6Sx" +
       "l0QUQ8tlwY5aFSNrqhqzrmc6syhn6V7SwPR0XKz3kjp4T6g6k7OrMhmb8V5S" +
       "q4mpiCF+g4gyQAJF1Ajvqp4x3HeT8mHxnjcJIXXwkCZ4LiPyI745sWLDRpbF" +
       "qEJ1VTdi/ZaB/KNCRcxhNrynYdU0Yimw/00LFkYXxWwjZ4FBxgxrKEbBKoaZ" +
       "XBR+Skd4TM2CMcRAOWnQUDq2zLCylK9m6Sjanvl/2TWPspg0EgqBmi4OBgkN" +
       "/Gu5oQFeUtmbu27pqQeSR6UBotM4UuRkIWwdlVtHxdYipMLWUbF11N06Wtia" +
       "hEJixwvwCNIoQKWbIDhAdG6aM/DlFRtGu2rAGs2RWtBHGEAvKclWcS+KuKE/" +
       "qRx4bvXpZ59uvC9MwhBoUpCtvJTRXZQyZMazDIWlIWZVSh5uAI1VThdlz0GO" +
       "3DWyc+2Oy8Q5/FkACY6DAIbo/Ri7C1t0B72/HN3m3W998OCd2w0vDhSlFTcb" +
       "lmBieOkK6jfIfFKZO4MeTB7a3h0mtRCzIE5zCn4FIbAzuEdRmOlxQzbyUg8M" +
       "Z1DTGi65cbaRD1vGiDcjDK9VvF8AKh6PfocvNziOKL5xdYqJ41RpqGgzAS5E" +
       "SvjcgHnPi8+8fYUQt5s9mn1pf4DxHl/EQmJtIja1eia4xmIM4P50V/+eO97d" +
       "vU7YH0DMKrdhN45xiFSgQhDz157cfPyVl/e/EC7YbIhDys6loPrJF5jEedJY" +
       "hUm0c+88EPE08H+0mu4bdbBKNaPSlMbQSf7VPHvhwXdubZF2oMGMa0bzP5mA" +
       "N3/hdeTmo+tPdwoyIQUzriczD0yG8Uke5cWWRbfiOfI7j3V8+wl6DyQECMK2" +
       "uo2JuBp2/BYPNY2TK842QsQBBE8IMcLFbRe7erADFGpKhgWlJmziSgEYE+MV" +
       "KE+xNRFrn8Wh2/b7VrH7+gqvpHLbC+9NWPve4VNCGMWVm9+U+qjZI60Xh9l5" +
       "ID81GMeWU3sY4K48svJLLdqRM0BxECgqEKftVRawmi8yPAd6XN1Lv/7NlA3P" +
       "1ZDwMtKoGTS9jAofJg3gPMwehlCcNz9/rbSdkXoYWgSrpIR5VNf08oawNGty" +
       "obptD0/9+dU/GntZ2Kyg0FHqjgOOpQ6Ud0ccL8FhbqmRV0IN6MsxFfx5lavz" +
       "CwM6h/Mblqfy3ioq78NhiVjqwWGpdL9rzk5sOBGXGBc5c+V4FJ9IsGwI8lig" +
       "YJGOSpWdqEr379o7ll5170JZf7UVV0tL4TJw/+///bvoXa8+VSb5NnDDXKCx" +
       "LUzz7VkHW84sSZh9ovD1gv2iY6drTtw+rak0VyKlzgqZcG7lTBjc4Ildf2lf" +
       "c83whnNIgtMDggqS/Enfgaeuv0S5PSxqd5n/Smr+YqQev8hgU4vBJUVHtnBm" +
       "grCaroJqO1Fll8JzuaPay6tYvhjn4DDfs+IFEPltcX0KRP7WKlSrOAUOK8Su" +
       "rIrdD+GwnoukLZO/51HCEZLn7ghierDAxFRcmgHPeoeJ9eceFCqhVuFsc5U1" +
       "MQkm0DDE+IAohANcZ8+b6zZc6oAn5Rw9de5cV0INcBaSlYMbBVtEFMQraVRe" +
       "ScVO26uIYycOeU7GgziguhNX7zLU5G3OE9LW8xbSZFyaDU/G4TRz7kKqhFqF" +
       "329WWfsWDqPAt08WKyEM2Da2Q3yxEfPKQC5lc1HUyBvxLye9/bOnNtQdlxG5" +
       "uyx44KL9+k1Hv2/88WTYvUSXQ5GQN9h9zz6y/M2kCIv1GHcLwcgXcxdbQ75K" +
       "ucXENDK7cuz1HX7sh7Oe2TE26zVRddSrNkRvIFamv+DDee/AKyePTeh4QBT+" +
       "tXgm5zzFjZnSvktRO0UctdnMV7TgElMP6ELkKdFf9EL+Oye++8ajp39QJwU7" +
       "p7IIAnjT/rlKS+16/cOSck5knzKdkwD+YOzA3e3xa04KfO8uhNiz8qW3ZZCy" +
       "h3v5fdn3w12Rx8KkbpC0KE4vby3VcnjDGAQ52m6DL0EmFK0X96Kkq/YUct3F" +
       "wVzn2zZ4C/NnvVpelO9azXyICPf6XvVMNi6j6lRzEtnH8AnB8xE+6Gg4gd9w" +
       "5rjTtZlRaNuYUJ1ENKYP8WG7qt76LTULt7ItjiPFtre9sunut+6X+g4qKQDM" +
       "Rvfe8nH01r2yMpI9wFklbTg/juwDSqfC4d68KJaq7CIwlr354PZf/Xj77rAT" +
       "XtZyUgPOgK/7HIP3JW7XASZ5DhDXDJ3h3cZdk80P1YgWGqmwmC+bDAZNsec+" +
       "X/wUR68S/h6usvYIDgdBuQqeSbJQBfyQUxaTMt47JRjnpFoiC+/5x46vv7gK" +
       "wkkvqc/p6uYc600Xm2SdnUv5Ap/XIfXM1FEQmhknobmmI2iRtL5x3kmrHZe6" +
       "4NnoZJ6N5560KqFWz+wdgfvNFyyVi2svtSG8im1/W0Uhz+DwGCf1+JfIEsop" +
       "/j7qiebx8xaNqIIXwLPL4W9XFdGUjx04pMpUwJUonlUFfLyKVE7g8Dzc1bN0" +
       "E/N1CXB6kSecF85bOFgMknnwjDqsjP7PhFOJ4icIZ5HY8c9VhPMWDq9yMhGF" +
       "412nhWQ92bz2X1yWofgu9HWx7TCt5K8m+feI8sBYc/3UsRv/IEsM9y+MJiiB" +
       "MjlN8+cq33vEtFhGFSw0uZkLv/7GyaVn2VQCP3FfBQ9/lRT+zklndQoQIMW3" +
       "H+t9TqZVwoKMAKMf+kOI8uWgARJGP+QZKJaCkLC/+PbDfcRJowcHCVa++EBC" +
       "IaAOIPgaNt2Ic9YduMVQplpUQW3mQ6WNEGEmkz/JTHydj1lFeV/8W+lmi5z8" +
       "vzKpPDi2YuVNpz51r+zeKhrdtg2pjIccIRvJhfbAzIrUXFqR5XPOTHyoYbab" +
       "p1vlgT2PvMjnFXGIySYabXugtWl3Fzqcx/dfffjp0cgxqDDWkRCFnL6utD7L" +
       "mzmLTF+XKJcNoUITXdeexjc2PPvhS6E20XAjMn92VsNIKnsOn+jPmOZ3wqSh" +
       "F6wRdJQXxeOSrfpqpmyxipJrJGXk9EKpPhE9jGLRLSTjCHRCYRa7/5x0ldZK" +
       "pf+INGrGCLOuQ+pOsi5qqORM078qJPuozNwoaTDHZKLPNJ1iMfJpIXnTxPgR" +
       "mow/jvwHGKGdw5IgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9rf4oIbQqyYxq5NNRvGQoYUR5bjUwlCkw1ecyqTRwPuEhm5KCWmKNj1SFdtp" +
       "WXp/xdaXC2ZBs/N+ldNHLUyumCUnHhIZQ9Uywq3SjNLM1pQ2dPp2OsiU7djA" +
       "uXmZHLWtek1V5CFZTtoWqS5JtiElNN5kzbqw8NSEz6w+26sBcQXdannoB20j" +
       "a4o1SkyWqtFxBQuH8cVsPIhrUcNxy/6iSqYdG6EGTjdmlnJZt+Rq6jBcVaiV" +
       "JATW+w1MS8bYrFMiOTbUTL5aSy1aNAYmmZVrmLoQtpKN6AhFYDOFMcltVLc9" +
       "IezStSWla92ZOXZKKozjlECV8A5cctZVRQNmw8uCaHPKQFxgktBJzM1UWytz" +
       "GvW4NieXlEyoOU2+gpiaPnI8OBa0jbdlBuMstNSMLG3bOEhFNXUyGSoLq79g" +
       "sGVFwuGNXSe3A4rgWHTtod11y0eR1kzgZ+iIxavoIBq0WhTOcGqPVoY6podN" +
       "km77rGlM7K6TWaJBzSiYk1gKTvkhHbr4xEQRBZPCDgYbQeJ3egoBN/iJkOhV" +
       "iSfa3ERyGvAYDpZzpl6amg27xpB4uc3pk3ElmlXZKh4l3V5PC4ZcqZVShBFQ" +
       "7CKWhvLGsfCt0NTqU77cSxCMt5sVoTwnN1zMeu2R2Fg2vUXXqBgCt9FNm1D5" +
       "rIGEiqitpt5sYoihzwxrEr8o4Z684dvx1lP8mCwhDVgbI203nqPs1ijRnWBp" +
       "9Pv+oD7WSqraw2lTCZyhVGL4Ohel9CKt2XKSERuubiKcYgeLbcXyAgznTUta" +
       "BptJ29d6jTBb1aJ+qz1tt9SaCktVGmTKqL1hcNsyZt12X/QnWkCFoMbwMNuu" +
       "lbFSd77AxpJUinvVUXeDwAiCKIk3lXFYEpUa75LklCXS3jjLMGnVmeDVSJyb" +
       "DS8hy0aCWrO6Fo7iDRzKq5K0Ze3MCOZqG7NHraVaZWxtgdoLFa9sTJdnjJgj" +
       "DSMQEcpdGLK+TkpiTRDTQKu5iOiE8AwElAQ3jXE1aXXHUid2W44REnLodYN+" +
       "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" +
       "st3d0zqp9t95V2zHuC53nvnhQ1994Onj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "L5OHdgTv3ewUbe+4800kyvHj4u5Q9o/f9qs/83df+oPipPz/AJE0t5AmLQAA";
}
