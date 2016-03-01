package org.apache.batik.ext.awt.image.rendered;
public class Any2LumRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public Any2LumRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          src,
          src.
            getBounds(
              ),
          fixColorModel(
            src),
          fixSampleModel(
            src),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
        props.
          put(
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              PROPERTY_COLORSPACE,
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              VALUE_COLORSPACE_GREY);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.image.Raster srcRas =
          src.
          getData(
            wr.
              getBounds(
                ));
        if (srcCM ==
              null) {
            float[][] matrix =
              null;
            if (sm.
                  getNumBands(
                    ) ==
                  2) {
                matrix =
                  (new float[2][2]);
                matrix[0][0] =
                  1;
                matrix[1][1] =
                  1;
            }
            else {
                matrix =
                  (new float[sm.
                               getNumBands(
                                 )][1]);
                matrix[0][0] =
                  1;
            }
            java.awt.image.BandCombineOp op =
              new java.awt.image.BandCombineOp(
              matrix,
              null);
            op.
              filter(
                srcRas,
                wr);
        }
        else {
            java.awt.image.WritableRaster srcWr =
              (java.awt.image.WritableRaster)
                srcRas;
            if (srcCM.
                  hasAlpha(
                    ))
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    srcWr,
                    srcCM,
                    false);
            java.awt.image.BufferedImage srcBI;
            java.awt.image.BufferedImage dstBI;
            srcBI =
              new java.awt.image.BufferedImage(
                srcCM,
                srcWr.
                  createWritableTranslatedChild(
                    0,
                    0),
                false,
                null);
            java.awt.image.ColorModel dstCM =
              getColorModel(
                );
            if (!dstCM.
                  hasAlpha(
                    )) {
                dstBI =
                  new java.awt.image.BufferedImage(
                    dstCM,
                    wr.
                      createWritableTranslatedChild(
                        0,
                        0),
                    dstCM.
                      isAlphaPremultiplied(
                        ),
                    null);
            }
            else {
                java.awt.image.PixelInterleavedSampleModel dstSM;
                dstSM =
                  (java.awt.image.PixelInterleavedSampleModel)
                    wr.
                    getSampleModel(
                      );
                java.awt.image.SampleModel smna =
                  new java.awt.image.PixelInterleavedSampleModel(
                  dstSM.
                    getDataType(
                      ),
                  dstSM.
                    getWidth(
                      ),
                  dstSM.
                    getHeight(
                      ),
                  dstSM.
                    getPixelStride(
                      ),
                  dstSM.
                    getScanlineStride(
                      ),
                  new int[] { 0 });
                java.awt.image.WritableRaster dstWr;
                dstWr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      smna,
                      wr.
                        getDataBuffer(
                          ),
                      new java.awt.Point(
                        0,
                        0));
                dstWr =
                  dstWr.
                    createWritableChild(
                      wr.
                        getMinX(
                          ) -
                        wr.
                        getSampleModelTranslateX(
                          ),
                      wr.
                        getMinY(
                          ) -
                        wr.
                        getSampleModelTranslateY(
                          ),
                      wr.
                        getWidth(
                          ),
                      wr.
                        getHeight(
                          ),
                      0,
                      0,
                      null);
                java.awt.image.ColorModel cmna =
                  new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8 },
                  false,
                  false,
                  java.awt.Transparency.
                    OPAQUE,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
                dstBI =
                  new java.awt.image.BufferedImage(
                    cmna,
                    dstWr,
                    false,
                    null);
            }
            java.awt.image.ColorConvertOp op =
              new java.awt.image.ColorConvertOp(
              null);
            op.
              filter(
                srcBI,
                dstBI);
            if (dstCM.
                  hasAlpha(
                    )) {
                copyBand(
                  srcWr,
                  sm.
                    getNumBands(
                      ) -
                    1,
                  wr,
                  getSampleModel(
                    ).
                    getNumBands(
                      ) -
                    1);
                if (dstCM.
                      isAlphaPremultiplied(
                        ))
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      multiplyAlpha(
                        wr);
            }
        }
        return wr;
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm !=
              null) {
            if (cm.
                  hasAlpha(
                    ))
                return new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8,
                  8 },
                  true,
                  cm.
                    isAlphaPremultiplied(
                      ),
                  java.awt.Transparency.
                    TRANSLUCENT,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
            return new java.awt.image.ComponentColorModel(
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_GRAY),
              new int[] { 8 },
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
        }
        else {
            java.awt.image.SampleModel sm =
              src.
              getSampleModel(
                );
            if (sm.
                  getNumBands(
                    ) ==
                  2)
                return new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8,
                  8 },
                  true,
                  true,
                  java.awt.Transparency.
                    TRANSLUCENT,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
            return new java.awt.image.ComponentColorModel(
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_GRAY),
              new int[] { 8 },
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int width =
          sm.
          getWidth(
            );
        int height =
          sm.
          getHeight(
            );
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm !=
              null) {
            if (cm.
                  hasAlpha(
                    ))
                return new java.awt.image.PixelInterleavedSampleModel(
                  java.awt.image.DataBuffer.
                    TYPE_BYTE,
                  width,
                  height,
                  2,
                  2 *
                    width,
                  new int[] { 0,
                  1 });
            return new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              width,
              height,
              1,
              width,
              new int[] { 0 });
        }
        else {
            if (sm.
                  getNumBands(
                    ) ==
                  2)
                return new java.awt.image.PixelInterleavedSampleModel(
                  java.awt.image.DataBuffer.
                    TYPE_BYTE,
                  width,
                  height,
                  2,
                  2 *
                    width,
                  new int[] { 0,
                  1 });
            return new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              width,
              height,
              1,
              width,
              new int[] { 0 });
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KMOAc4lm35OM53H4Tg4pBAn0c/5fUrDCn1QWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVae8zjWHX3fLvz2GF3Z3Zhl2XKvgfobuCznXe0QHGcOInj" +
       "xHacp9sy+Bk7fsaPxDZdHisKqKhbRAdKJVhVKrQFLSyqilqpotqqagEtqkSF" +
       "+pIKqKpUWorE/lFalbb02vm+L9+XecCIPxrJNzf3nnPuPeee8/O59+b570Gn" +
       "fQ/KuY4Zz00n2FeiYH9hlvaD2FX8fZIqMYLnKzJuCr4/BG1XpMe+cOEHP/yw" +
       "dnEPOsNDrxRs2wmEQHdsf6D4jrlSZAq6sG1tmorlB9BFaiGsBDgMdBOmdD94" +
       "ioJecYw1gC5Th1OAwRRgMAU4mwKMbakA012KHVp4yiHYgb+E3gWdoqAzrpRO" +
       "L4AePSnEFTzBOhDDZBoACefS32OgVMYcedAjR7pvdL5G4Y/m4Ku/8faLv38b" +
       "dIGHLug2l05HApMIwCA8dKelWKLi+ZgsKzIP3WMriswpni6YepLNm4fu9fW5" +
       "LQShpxwZKW0MXcXLxtxa7k4p1c0LpcDxjtRTdcWUD3+dVk1hDnS9f6vrRkMi" +
       "bQcKntfBxDxVkJRDltsN3ZYD6OFdjiMdL3cBAWA9aymB5hwNdbstgAbo3s3a" +
       "mYI9h7nA0+05ID3thGCUALp0Q6GprV1BMoS5ciWAHtilYzZdgOqOzBApSwDd" +
       "t0uWSQKrdGlnlY6tz/f6b372nXbb3svmLCuSmc7/HGB6aIdpoKiKp9iSsmG8" +
       "80nqY8L9X/rgHgQB4vt2iDc0f/hLL7/tjQ+9+JUNzc9ch4YWF4oUXJE+Jd79" +
       "9dfiT9RuS6dxznV8PV38E5pn7s8c9DwVuSDy7j+SmHbuH3a+OPiL2Xs+q3x3" +
       "Dzrfgc5IjhlawI/ukRzL1U3Faym24gmBInegOxRbxrP+DnQW1CndVjattKr6" +
       "StCBbjezpjNO9huYSAUiUhOdBXXdVp3DuisEWlaPXAiCzoIHuhM8+9Dmk30H" +
       "kA9rjqXAgiTYuu3AjOek+qcLassCHCg+qMug13VgEfi/8SZ0vwL7TugBh4Qd" +
       "bw4LwCs0ZdOZxamwDmDdAs4Ag8WRwQrJIOrjPBVaA0XeT53P/f8ZNkqtcXF9" +
       "6hRYqNfuwoQJIqztmIDxinQ1rDdf/vyVl/aOwubAjgGUB2Pvb8bez8bOIBaM" +
       "vZ+NvX849v52bOjUqWzIV6Vz2PgFWFUD4ANAzjuf4H6RfMcHH7sNOKS7vh0s" +
       "SUoK3xjA8S2idDLclIBbQy9+fP3e8buRPWjvJBKn8wZN51N2JsXPI5y8vBuB" +
       "15N74QPf+cELH3va2cbiCWg/gIhrOdMQf2zXwp4jKTIAza34Jx8RvnjlS09f" +
       "3oNuB7gBsDIQgG8DGHpod4wTof7UIWymupwGCquOZwlm2nWIdecDzXPW25Zs" +
       "6e/O6vcAG78i9f37wFM6CIbsO+19pZuWr9q4SrpoO1pksPwWzv3k3/7lvxQy" +
       "cx8i+IVj70ROCZ46hhqpsAsZPtyz9YGhpyiA7h8+zvz6R7/3gZ/PHABQPH69" +
       "AS+nJQ7QAiwhMPMvf2X5d9/65qe+sbd1mgC8NkPR1KXoSMm0HTp/EyXBaK/f" +
       "zgegjglCMPWayyPbcmRd1QXRVFIv/e8Lr0O/+G/PXtz4gQlaDt3ojT9ewLb9" +
       "NXXoPS+9/T8eysScktK33tZmW7INlL5yKxnzPCFO5xG9968e/M0vC58EoAyA" +
       "0NcTJcO2UweBk07qvgAq/KQxigOSdIYgSLMFhzMJT2ZlBo+ZXCjrK6TFw/7x" +
       "wDkZm8cymyvSh7/x/bvG3/+TlzNNT6ZGx/2kJ7hPbVwzLR6JgPhX76JEW/A1" +
       "QFd8sf8LF80Xfwgk8kCiBHDQpz2gR3TCqw6oT5/9+z/9s/vf8fXboD0COm86" +
       "gkwIWYBCd4DIUHwNIF3k/tzbNo6xPgeKi5mq0DXKbxzqgezXbWCCT9wYm4g0" +
       "s9mG9wP/RZviM//4n9cYIUOl67zQd/h5+PlPXMLf+t2MfwsPKfdD0bUQDrLA" +
       "LW/+s9a/7z125s/3oLM8dFE6SDHHghmmQceDtMo/zDtBGnqi/2SKtMkHnjqC" +
       "v9fuQtOxYXeBafvqAPWUOq2fP45FPwKfU+D53/RJzZ02bF7M9+IH2cEjR+mB" +
       "60anQKSfzu9X9pGUH8ukPJqVl9PiDZtlSqs/CyDBz3JbwKHqtmBmA9cD4GKm" +
       "dPlQ+hjkumBNLi/MymH8XMzcKdV+f5MgbsAwLYuZiI1LVG7oPm/eUGVvvbu3" +
       "wigH5Jof+qcPf+3XHv8WWFMSOr1K7Q2W8tiI/TBNv9///EcffMXVb38oQzgQ" +
       "2szHmhfflkrt30zjtGilRftQ1UupqlyWNlCCH/QyUFLkTNubujLj6RbA7tVB" +
       "bgk/fe+3jE9853ObvHHXb3eIlQ9e/ZUf7T97de9Ytv74NQnzcZ5Nxp5N+q4D" +
       "C3vQozcbJeMg/vmFp//4957+wGZW957MPZtga/W5v/6fr+1//NtfvU4ic7vp" +
       "/BQLG9w5bRf9Dnb46Y1nQn49QqNJLqyI01rYKeTr2LDR0Fv4nK6QM84yJoZY" +
       "RLD1RKHHDZFFG9JKtsSVMpctPq5GspJDkA6HmayQb450zNVnA5ieos1+x1oO" +
       "wrzaIZSxZbDIQqgPrKIC9l9LdeU2cLuGd1d+ueRX/ISuBB7LFAamItIVqmDb" +
       "NsOUk8AuhR10ZMmiS8pDtjwa9CSab8/shVSKhL5Jt+WWJ+byWN6ZJotGXmEK" +
       "sDYuFo05Psqz5oJDB9Fg6aOIgKDjynyZcA0iYNl8Oz/1+VGh3ipYvbzf5RwE" +
       "Kc3nNu/UbLpVdi1NjwiWb2rxfOzEyChu+hRvjMXGgmHJxrg3tYRlI+rL/TrT" +
       "q2OL4cwj+dq6X+BGoraIPI4MopJs4UFvQiO4ISSs219UZ8hknRgU1R1YsNdz" +
       "W+Uu3gvJuE7UJrUiq+QpMfYTNod6npso6lCUyV4cm5rV7C6FTi2yoqGdJ5cL" +
       "iiv7SYCaXosxOLkznK396gCjEE3y8E4eR/B5h1IW3shvu1bJGiRszI80dFCs" +
       "D3VcK3UMamIOGzoq4CJD6hWmUV8LA6JUCAcWMh0zoyCsh3bRY8RZrORgQQs0" +
       "eGL0ZySydPhiYS7V2aLG9ubNFjkwDT+O6+hkvBzQRoHF24ukTzkVJ2/Bcl4r" +
       "o/2WOTA6LNvl/TZJtZSJSdsCvliToWnyA16bjMT8qNH1qqvKcjTU5Toal6Zj" +
       "RG1Mh3MGd2YoTepjR6tXclweHSTjhjklRuGSdma16oLF6mI56ffcXl5fEsvG" +
       "ej50pSbZdKu8IddjPCnNm8jCGbIBzvljgejKS2GUGzn2hCXZsVgsKxTdNDGU" +
       "M5g5YTTL8ITjmgXdzeckc1EAoSCjudyCWARR08CGehJrrJxUqs3+alrsO/mI" +
       "oHqzUqeV+IIB1xZJoIT9kVHH5pUVO6ATFoZXHlpPVJSiEhPpxj7boAWm1xkZ" +
       "44ZlxOi0olWEahPrt5d03aoIrUSHB9MWzzNUNTZoGusTKLHw5rMutw4XTKG6" +
       "RHK5hCkKJE1oTZPsMXxYp1vuNMGSqdya1RIsskZSezSTqU6jPe5489xQsXVa" +
       "YPkEWGTY5UNyNu56cdliu2quoY8pDDOQkWapfY60CB4pEZNFxabxltHWK1yd" +
       "UJp0o1Yiqhzt+khPR7tEy3W1QUhPdHW5YOOp1auHyni8MPkFS1anNaRaEjvw" +
       "uC0mhMMaRHtoORGndxxEinjTDki3KYNIwqKB1Cl222ZHK+fVcDEZJTMk7s+Y" +
       "RgQX4VmbcBflKTvHOuVyfl0d0tZwJoI4X7C2OW2L7SQMVyRerHRmmmtUlEWH" +
       "UfBKZ76gY9LkUIzID5oujXbZ9pQwDaSO6Wbc4gsNHfOiMsFgdYxy3TWsL5R1" +
       "WS0v8/U5PRwGCsaRBKqOPbw1xTHXadfwcKqZlZ5QqRQHasPtzGdNhMNdXuyr" +
       "bheEwrCGR8MZ52Fjb1oeSQ1WYCbdkdqUeLpdrXWMRpRUvSTXDOo9fd1YYL2g" +
       "Kg1WYFORW62xUcdcAd+Fc6vhuBRVC1Nu7iy5mJiber4ZtSw0V5uv4A7pTqt9" +
       "dViIorBfY8cdysfGLMXpBrGszxdorYXLnR5BYKI8MTBtTFum0CxT2mTe1xPO" +
       "XNhB4i86Qkll4mqD4JIGSodtwfRrhCKpYxCoC0mXud6Er058fVntjCM1bNem" +
       "cKm0TAYFZ4Yjiu7BdL3XaAd1nNcQzg48udmP7B7LI6sEURl4JQUTiY5X84YO" +
       "ckNcSRoSu8Bwc93h7crSm/RUmK4scqqCi/66u+x7PNkYYKHQ5egmjOuxTkpK" +
       "Wakjdaa+HmJL2hZFpD4SdKtP2pMWp1IMao/F6QoWy8OZ3bC5WXc2HLimn0i0" +
       "usobLWXVTpyBUzOaKL4uU05eqhoSScBLSSsjVGPZKFV1OaS8pTZU3bowJ+c9" +
       "Ot/3fSPAxFiZhe2J3u6gQUjoeHO+HvTwgaG3C7FUGtCTIjFDzNygW6rZhpSz" +
       "olXRHVruUgFOvWBWK5msFgmGMvNTy+XzfFAstgSiusbMfrsvmnMGjRlkEbj2" +
       "TCjTJTHPhGjfLmikjUsY8P81hdUEp6mEfNeJTWaKTuEiUqqhbbHEscVuhSPm" +
       "haW4pOI5eI3xGJ80iw2EFotmVEIwiy5js1l+yTnuKCrVfHEZmwXZCsl6zlIL" +
       "ZFWrBXCuIkVJZ26zmmTJ1RAuJ21HrM4stTOtujIu5rmJRDU6S8uT9TBGSkZO" +
       "sdB+e1rz9Fqdld1BARta2lqFG54KI7q0qhREVHLIYgEvkQHa98fIoroWmpSV" +
       "97BuL26J9ECAK16t7OSURU9fgtSgKdPMeDJfidVywPjEqm3HVK1QWbnznIop" +
       "zgpYp9uAqUqxJqnMSqtJS96ho3Z7hK3K+T7VX6PFIcvjFCv0gyKxLI7ipNGH" +
       "FccKK8hkUpOwgjUdBrPW2PAGzdHAK7tBbTKxqVwwjQca6sMJZeq8IZk9kbZ8" +
       "Vw6qek5Fxu3mDOyp6oVVUXEcRoNX8aCGdZRiswr8L67ZUotkh4sah7aqfaBe" +
       "S4jLq0Jtrbtue1HX1nmOL9VxYhxaLMktqq3KoKpPKATJ+UQujzNMN/JpOF8e" +
       "gF2bFpA2URyTDcskhQbckAK1p07wogDHebnYLk6QwrIN56euJ3FGF81NqnNX" +
       "XUVtr9ht5AWvhceCFq34YTfSe5YldfCCOZit88NFXyLz43w3EfmkB+tDTlAU" +
       "uRWvQUagBapGF8e8AC8SPTSqvisJVSYO1TxsSOi0OpyscHk5GRPilBnYq0Qt" +
       "skGkOSRuyWt/alZEkAdV7P5y7rtjWx9xi0STGnNyKsN6G+Nco6CuvKU6V8WG" +
       "QAEkmjEDzo5IY8KNl05nOOBgs8/KXtXE62rBQxG32lYorWC4KjMnVWMiYRKn" +
       "NpJGpaIRrVGEi+u82ULDEds2NQDwnCL4xep4yCmI113AsT4CKdhEUcShQZbk" +
       "SYUp+Eqo5oqmW0HHcsOp6Gg8iZp6Dckb07haEJbBurtqdiv9WuQrAhpNh7hK" +
       "5Ar0XEalqWKSrXmjivWUeUUVUdXmVZ+dVmftSsWdyrQmlHBqWOtgJse6rFQr" +
       "oLS0WKss2xI0Qiv3lElYLFXCudj022u7WgXYpjLrCIm7AkHTtRozWwUcrtlU" +
       "ARkNC+3czMWQhtFD5k4tbsacn2fhfqvV71kzKr/UCU/oKbFI6MS0aQkTgSlW" +
       "BYnoFRMdjUquJUZ1qxgmubZjcC2Y50tI1ysmbIIgibCWYzOezsZlPLHbwVSC" +
       "tYHbISdF0g8IuBTBtF0YrJt1bl4JS2N+xZcYYhLCtSBkJ3Aya4/UamO1rktw" +
       "dUZNZ85QqSvGLF7A9mTcr456VCkxbY+bDVq5ZnUYrYRuj8akomkVSnSvVGgX" +
       "h/OiW8dsRIJL6sgDeTzKTsBO4i3pFuPKre3y7sk2tEfXH2Bzl3aQt7C72XQ9" +
       "mhavOzpAyz5ndo/Mjx+gbU9GoHTH9uCNbjWy3dqnnrn6nEx/Gt07OFHiA+iO" +
       "wHHfZCorxdw5ZHnyxjvTXnapsz3p+PIz/3pp+FbtHbdw9vvwzjx3RX6m9/xX" +
       "W6+XPrIH3XZ07nHNddNJpqdOnnac95Qg9OzhiTOPB48seym12GPgwQ4si13/" +
       "/PW6XnAq84LN2u8c2O0cBD6YHStsD/4mnh5k532CHyheJiG8yZFfnBZgq3xO" +
       "cty4IQRC+nu1dajlj9suHxeYNVhHFngkbXwTeJ47sMBzt2CBPeA5rucEihQo" +
       "chYON7NG+hPJCN53E2XfnxbvCqC7VD3CHdPxeo584JbAkq/ZseQORWaOd/8U" +
       "5ng0bYTB89KBOV66FXOk1WduwQ4fuYkdrqbFrwbQ3cAOnGC5pnLCEJd2DLFL" +
       "klni2VuxRBRA57eXRenJ9wPXXGFvrl2lzz934dyrnxv9TXZfcnQ1egcFnVPB" +
       "bvj4YeOx+hnXU4AuGeXm6NHNvj4ZQG/4CQ/KQQgcVrPpf2Ij4bcC6KGbSwig" +
       "09n3ca7fDqAHbsQVQLeB8jj17wTQq65HDShBeZzyMwF0cZcSjJ99H6d7Hth7" +
       "SxdAZzaV4yQvAOmAJK1+wb3lWwVM9ANPkIL0VuHUyVfEkYfc++M85Nhb5fET" +
       "74LsXxCHuB1u/gdxRXrhObL/zpfLn97cSEmmkCSplHMUdHZzOXaE/Y/eUNqh" +
       "rDPtJ3549xfueN3he+ruzYS3AXhsbg9f//qnablBdmGT/NGr/+DNv/vcN7Nz" +
       "3P8D4bmYe54iAAA=");
}
