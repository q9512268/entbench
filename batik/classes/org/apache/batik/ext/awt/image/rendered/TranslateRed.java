package org.apache.batik.ext.awt.image.rendered;
public class TranslateRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    protected int deltaX;
    protected int deltaY;
    public TranslateRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                        int xloc,
                        int yloc) { super(cr, new java.awt.Rectangle(xloc,
                                                                     yloc,
                                                                     cr.
                                                                       getWidth(
                                                                         ),
                                                                     cr.
                                                                       getHeight(
                                                                         )),
                                          cr.
                                            getColorModel(
                                              ),
                                          cr.
                                            getSampleModel(
                                              ),
                                          cr.
                                            getTileGridXOffset(
                                              ) +
                                            xloc -
                                            cr.
                                            getMinX(
                                              ),
                                          cr.
                                            getTileGridYOffset(
                                              ) +
                                            yloc -
                                            cr.
                                            getMinY(
                                              ),
                                          null);
                                    deltaX = xloc - cr.getMinX();
                                    deltaY = yloc - cr.getMinY();
    }
    public int getDeltaX() { return deltaX; }
    public int getDeltaY() { return deltaY; }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.lang.Object getProperty(java.lang.String name) { return getSource(
                                                                          ).
                                                                   getProperty(
                                                                     name);
    }
    public java.lang.String[] getPropertyNames() { return getSource(
                                                            ).
                                                     getPropertyNames(
                                                       );
    }
    public java.awt.image.Raster getTile(int tileX, int tileY) {
        java.awt.image.Raster r =
          getSource(
            ).
          getTile(
            tileX,
            tileY);
        return r.
          createTranslatedChild(
            r.
              getMinX(
                ) +
              deltaX,
            r.
              getMinY(
                ) +
              deltaY);
    }
    public java.awt.image.Raster getData() { java.awt.image.Raster r =
                                               getSource(
                                                 ).
                                               getData(
                                                 );
                                             return r.createTranslatedChild(
                                                        r.
                                                          getMinX(
                                                            ) +
                                                          deltaX,
                                                        r.
                                                          getMinY(
                                                            ) +
                                                          deltaY);
    }
    public java.awt.image.Raster getData(java.awt.Rectangle rect) {
        java.awt.Rectangle r =
          (java.awt.Rectangle)
            rect.
            clone(
              );
        r.
          translate(
            -deltaX,
            -deltaY);
        java.awt.image.Raster ret =
          getSource(
            ).
          getData(
            r);
        return ret.
          createTranslatedChild(
            ret.
              getMinX(
                ) +
              deltaX,
            ret.
              getMinY(
                ) +
              deltaY);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        java.awt.image.WritableRaster wr2 =
          wr.
          createWritableTranslatedChild(
            wr.
              getMinX(
                ) -
              deltaX,
            wr.
              getMinY(
                ) -
              deltaY);
        getSource(
          ).
          copyData(
            wr2);
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0Za2wcxXnu7Pjt+JE4MU7sBNsJSgh3vCswBBInThwujhUb" +
       "UxyCs96bszfZ21125+xLIEBREaFVEaQhpBW4PwgNRYEgBH2oDQ1C5SEoFZCW" +
       "UsqjFLWUFEFUFVChpd83s3v7uLsNlupa2vHezPd9872/b2YPf0hmWSZpoxqL" +
       "sZ0GtWJrNdYvmRZNdquSZQ3C3Ih8T4n0j2vf77soSsqGyexxydooSxbtUaia" +
       "tIZJq6JZTNJkavVRmkSMfpNa1JyQmKJrw6RJsXrThqrICtuoJykCDElmgjRI" +
       "jJnKaIbRXpsAI60J4CTOOYmvCi53JUiNrBs7XfBmD3i3ZwUh0+5eFiP1ie3S" +
       "hBTPMEWNJxSLdWVNcqahqzvHVJ3FaJbFtqsX2CrYkLggTwXtj9Z98vmd4/Vc" +
       "BXMkTdMZF8/aTC1dnaDJBKlzZ9eqNG1dR24kJQlS7QFmpDPhbBqHTeOwqSOt" +
       "CwXc11Itk+7WuTjMoVRmyMgQI6f7iRiSKaVtMv2cZ6BQwWzZOTJIuzgnrZAy" +
       "T8S7z4zvu+fa+sdKSN0wqVO0AWRHBiYYbDIMCqXpUWpaq5JJmhwmDRoYe4Ca" +
       "iqQqu2xLN1rKmCaxDJjfUQtOZgxq8j1dXYEdQTYzIzPdzImX4g5l/5qVUqUx" +
       "kHWeK6uQsAfnQcAqBRgzUxL4nY1SukPRkowsCmLkZOy8AgAAtTxN2bie26pU" +
       "k2CCNAoXUSVtLD4ArqeNAegsHRzQZKSlKFHUtSHJO6QxOoIeGYDrF0sAVckV" +
       "gSiMNAXBOCWwUkvASh77fNh3yR3Xa+u1KIkAz0kqq8h/NSC1BZA20xQ1KcSB" +
       "QKxZntgvzTu6J0oIADcFgAXMT244efmKtmPPCZgFBWA2jW6nMhuRD47Ofnlh" +
       "97KLSpCNCkO3FDS+T3IeZf32SlfWgAwzL0cRF2PO4rHNz1x980P0RJRU9ZIy" +
       "WVczafCjBllPG4pKzXVUo6bEaLKXVFIt2c3Xe0k5vCcUjYrZTamURVkvKVX5" +
       "VJnOf4OKUkACVVQF74qW0p13Q2Lj/D1rEELK4SE18LQT8cf/MzIWH9fTNC7J" +
       "kqZoerzf1FF+Kw4ZZxR0Ox4fBa/fEbf0jAkuGNfNsbgEfjBO7QWMTGmSxZU0" +
       "mD8O5kiCTZLxQVPSLBVk2kyTMXQ44/+3VRalnjMZiYBBFgbTgQqRtF5XAXVE" +
       "3pdZvfbkIyMvCFfD8LD1xcj5sHtM7B7ju/PkCbvH+O4xZ/eYd3cSifBN5yIX" +
       "wgPAfjsgE0Aqrlk2sHXDtj3tJeB6xmQpKB9B230lqdtNF06OH5GPNNbuOv2t" +
       "c56OktIEaZRklpFUrDCrzDHIXfIOO7xrRqFYuTVjsadmYLEzdZkmIWUVqx02" +
       "lQp9gpo4z8hcDwWnomHsxovXk4L8k2MHJr8xdNPZURL1lwncchZkOETvx+Se" +
       "S+KdwfRQiG7dbe9/cmT/bt1NFL6645TLPEyUoT3oFkH1jMjLF0tPjBzd3cnV" +
       "XgmJnEkQeJAj24J7+PJQl5PTUZYKEDilm2lJxSVHx1Vs3NQn3Rnurw38fS64" +
       "RTUG5nx4VtiRyv/j6jwDx/nCv9HPAlLwmnHpgHHf71/623lc3U55qfP0BQOU" +
       "dXlSGhJr5MmrwXXbQZNSgHvzQP937/7wti3cZwGio9CGnTh2QyoDE4Kab33u" +
       "utfffuvg8ajr5wxqemYUWqNsTkicJ1UhQsJuS11+ICWqkCvQazqv1MA/lZQi" +
       "jaoUA+uLuiXnPPH3O+qFH6gw47jRilMTcOdPW01ufuHaT9s4mYiMJdnVmQsm" +
       "8vwcl/Iq05R2Ih/Zb7zS+r1npfugYkCWtpRdlCfeEq6DEi55MyPnfdXE0g0g" +
       "yCHkFX+ewFgcyIxaENNKGkw4Yde/c/u3yXs6+98Tte20AggCrunB+HeGXtv+" +
       "IneQCswaOI/s1XpyAmQXj3fWC8N9CX8ReP6DDxoMJ0Qdaey2i9niXDUzjCxw" +
       "viyk/fQLEN/d+PaOe99/WAgQrPYBYLpn37e+jN2xT1hdtEQdeV2JF0e0RUIc" +
       "HLqQu9PDduEYPX89svvnD+6+TXDV6C/wa6F/ffh3/34xduCd5wtUkRLFbmvP" +
       "xzDIJf25ftsIgdbcXveLOxtLeiDf9JKKjKZcl6G9SS9F6OiszKjHWG6rxSe8" +
       "oqFhGIksBxvgxMV8vIDzcnaOI8I5InxtAw5LLG/u9dvL07mPyHce/7h26OMn" +
       "T3KZ/a2/N9VslAyh8AYclqLC5wdr43rJGge484/1XVOvHvscKA4DRRk6AGuT" +
       "CaGQ9SUmG3pW+R+eenretpdLSLSHVKm6lOyReI4nlZBcqTUOFT5rXHa5yC2T" +
       "FTDUc1FJnvB5ExjfiwpnjrVpg/FY3/XT+Y9fcmjqLZ7kDEFjAcePYtPhK+r8" +
       "AOnWlYde/dpvD921f1L4U0h0BPCa/7VJHb3l3c/yVM7LaIGACeAPxw/f29K9" +
       "8gTHd+sZYndm8xsl6Alc3HMfSv8z2l72qygpHyb1sn1gG5LUDFaJYTikWM4p" +
       "Dg51vnX/gUN01125er0wGLGebYOV1BsIpczn9G7xnI0mPA2eTruudAaLZ4Tw" +
       "l2s4yhl8XI7DWU6tqjRMnQGXNBkoV7UhZKHEJanKpK/zaBMFGscrcNgqCPUV" +
       "9cehfP6X2BstKcK/6B3OwGEkn81i2A6bVxdiMxXCZtbd7szcdvyvLHim8BZx" +
       "Ny4IBn9rsWMfz7QHb9k3ldz0wDlROyWtBlsw3ThLpRNU9ZCqREq+ENvID7qu" +
       "v745e++ff9Y5tno6LTPOtZ2iKcbfiyBYlheP2iArz97yQcvgyvFt0+h+FwW0" +
       "FCT5o42Hn1+3VN4b5ad6EUh5twF+pC5/+FSZlGVMzV85OnJ2rUN7NcNzsW3X" +
       "i4NO6HpOwCVyfV0x1JASdEPI2o04TIJDjFG2xg0013mzp4qx8JyPE4MGn7fy" +
       "9XCZLcxl09dDMdQQWW8PWfs2Dt/06OHqgB5unQE94GGELIZnjS3MmunroRhq" +
       "iKz7Q9YO4HCX0MMAvzDAiQtdPeydAT004lorPOttYdZPXw/FUAOyOs0i/oZT" +
       "Qz3vR7CExsSdHd/p/hAFHcJhipFqUBCcbvndZAFqoiC7avvBDKitCdewEiVs" +
       "2RPTV1sx1BANPB6y9mMcjoAmPNrpg/xo+b8S5E5O/JAn+vRrqp/5pXX/Xx4T" +
       "/Vuhc1ngXvLBQxXyG+ln3nPK2kX8WLSkeAnxbDb1w46Xbprq+BPviisUC4oS" +
       "1LACF6genI8Pv33ildrWR3jxK8USx3N88OY5/2LZd1/MWa2zW9tCHljQVYcM" +
       "pz95qnB/FcXXGIPOTtEklW/SBU2JSrUxcVt5OQ5HDde3onZbbfMxx+WjW9U1" +
       "ikdkZ03cuyl6LHdhD4vZgoxa4lx01ON0nJcQn/lNyNrLOLwIYsnIkxAhBPx4" +
       "scjxBJnNLf5cl3UD9NGZymvYdPbbUdY//QAthhrQQtT1At5+ioPpOyG6eheH" +
       "Nxgph1AdVFxjN3FjuxcnmyUL/NlV1B9nUlFX2dJeNX1FFUMNUcFHIWsncfhA" +
       "qGeNxCT8+Z6rhRMzqYWttihbp6+FYqjhZbAxZ/PNULUgB0B449IXxRUU4dQ/" +
       "Laqgz2ZAQS24hmchaktJp6+gYqjhCmoNBMVVpsL4JSIPDq6P6hBd1eFQxkgF" +
       "fn+2lRWpySkrUv6/UFaWkRrvVxO8b2nO+2orvjTKj0zVVcyfuvI1Ucycr4E1" +
       "cCZLZVTVeyPgeS8zTJpSuJJrxP0Az/YROP6e8RWvX0EHzivKEZknKLQw0hZO" +
       "AWoA/+/FamWkuRgWIyUweqEXQyErBA2QMHohO6AsByFhf/7fC7eUkSoXDsqt" +
       "ePGCLAPqAIKvyw3Hm77yXfUq6HpMOGaDNbPCFxd4nYAHWtOpfMdzT9Dha474" +
       "h3+nycqIT/8j8pGpDX3Xn7zwAfGdQ1alXbuQSjX0MeKTi93HeO94g9QcWmXr" +
       "l30++9HKJU6L1iAYdqN0gSfjDkK8Gei0LYGPAFZn7lvA6wcvefLXe8pegb5t" +
       "C4lI0LZsyb8FyxoZk7RuSeTfBkObx79OdC37/s6VK1IfvcHvGYm4PV5YHH5E" +
       "Pn5o66t7mw+2RUl1L3gi2CfLr+fW7NQgZU6Yw6RWsdZmgUWgAj2S76p5NsaX" +
       "hM0d14utztrcLH4lY6Q9/5Y9/9tilapPUnO1ntGSSAa6z2p3xmk4fVcSGcMI" +
       "ILgznpa0B4euLFoDXHYksdEwnI8Qlc0GTzHrCvdQ6NuX8ld8W/lfXsZuMhQk" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Qa3iQy/t1HvZ0rDWgbeMxMCE8FkNkvjyrG2o7jIk5abd7eFLVNWZWcIsRuWo" +
       "hdLe1MkNQQvSbhuuGlUSESqLSofBFKgpDol5zamp0EYcN0ll0EcxHWWyNWTA" +
       "7VG7ZfKEVo7lmae5rSx2GijwM2JscGlrCztNONyYAbGZV2OvavbrpNAFK4kZ" +
       "b9nTMRJ0zXo19STIFKhKvjTTo8q6T/b1+YwWq514EKhbr91vZt6g4jIorPPR" +
       "aqWhCikj/NqBY2SzcFrSoNmdCo0kXE7GHtuXqI7ti01hIY+I3lDxRsEI2iqd" +
       "Md6P1UilzBBjBLGt6guDaUhwJ05G6ghqdGr0ut+zvVbVgtHGXMw0a5xJmJzM" +
       "tWa8VbV0k5KE5bY6ckZtkEHHa0fxdGxsmywxb9s1R9tW1l1nQm+mSceJ1zV+" +
       "QQYTCuQ+LJz0wnKPAhbUDFdpE6nr5bJhtGf1xPMbJM/QiQxbI3VuWJvOzFno" +
       "DGyh0bbd3LBqam5SPKmUF2V8Pa3gGF/3EZjwqiD3UMi8rmiNnrCoJ2u8HGB1" +
       "qIxzstMXx1uxVae9IRwJVJNSqW08rUkWQtENIqDXmLgxxEpWHaKc1mMGsF9B" +
       "+MGwu8T7cGZWKtWauw2QMGsNNwxYVfe9prFpAzGQauZU2lp3rLHsdNpipkYM" +
       "dxMozz6h2amvPLbXRvr9HjmQvSVXG7srL/Ini9AaAQm1ZzRCYFJlPEbTbRe1" +
       "2ERj9I2G8pUK4vgRkEAy02RGWkO4gNIbOq5YkC/z7LaWTppYL4s5jdCgAFqg" +
       "OKEOF1aAh0IHU+epp8koHvoW1lTStNMdWQmm6eueJcbwhOHFapxVOyjFdBqb" +
       "tjtWlz7qMlQE/CHzy/MWV+/VaWiIeuV0EoUBVA8kCZIyhIfE1UKteqaUkh02" +
       "kzb9suPVPGYE21JrSnK2jnrZvDuvrpGGNA+isNxhUsuKBQzxuSqJYnjD1L1B" +
       "i0lrNcvRoumktsxGLYHLalSrRc/qEEzKWhUaTxV4O20nGOEsWXGmjoNtux56" +
       "HQhXJak/YGg+6dnOFOI6AjzkIiFTxaROs3Wiq+k135Pnc2OcZeXpctoWqpat" +
       "2XKlpq42ToMktEUXSWXTzxTEySpVmqp4Q5X1IIfaUBFJk+vBLPYGdoYuOkyG" +
       "xOoy6ww9ijTqqlMTum2qL2/cdKYx87mgzSCIRZPFImLZhK+iSb1s+UxAb/oN" +
       "faETVGYGiyqqiXi2pGr4cpWpnrsRSIhygP+2PcHBJVgb6pQEVmDCmBJUnBhM" +
       "Y081FmjY16kM41tluREtJuNtOJsmibWYB40yPguXC3mOgrURQwmkYHYqHQRp" +
       "D6RsIgiIxkKkEppbWEZZDkYWrrpQ7GQI+pl5P8z1qc5YFIOYRIbcgOmGDaax" +
       "6GhVHWcz28QNrww7k2mw4exISBuQgCtTexKlYka35rBHl2E/Spf8aFnZiqK6" +
       "AWl+UBXUjRohvaoKXEEWeVHfMKbOtbb8MOBWw2GUMRV0C80mNNPQW5NpKlV6" +
       "xNZKRz3Z9kYku64sZBqd+ihUhnDFndqriTkdbIS1HvYkdtOLOijMjgl/QTfQ" +
       "uLPBFwbUNLCmLticL3XjMNGZPkaiTIgORulmXSPcZnMjGUIIfHpM95UuNWcw" +
       "PNPAuwdKTBM6MMbalm93FwrSRBa1srdRwwEPtZatoB90pZrkNbdr1OhrbFVx" +
       "pPmK5ZbAPfURb7VrhE63EbPNqlNXipxapVxuE6Oh0CCrFjrTQqpicsaya49a" +
       "fd2qkLM+g+Ky13RStLFWU90gJb0V6Oa8nmCIM6iQcryZt/BN5st2c7LidN7o" +
       "2PQ8a7ZpDQPLrLghjqoDI1WJtD9zEUaszwii3mO8ut9oJE13XYYnglMla6YF" +
       "YwYZlY1pk2JNWWjMwDvwNNZk1xTA68cS5pqNoE7FirQYV7Qqskq2SaSSBOLM" +
       "Gmwbqs/aUDuxHCVgBI+uekmf41ClsYWDWubaiCGqXF8dDwakufUCBVibviJx" +
       "vysRMzvWemvgz6yjVvr8loiwVGMb1EpqOVprCjmGFMur8YK1URQttnLD720r" +
       "5ZFi1+jkEHrpNPMG5XvYLdk1vTMvnjvZYSs+F88eXJ4+3Nhvvpby7eGn7na2" +
       "XGyFf/ZjL7+i0T9XPTjatG4npcuJH/xFR09159RQl8FI7777Pu64OFrfb6b+" +
       "xsf+y5P8+xcf/h7O5d5xhs+zQ/698au/1f9+9ScOSudPtlZvO/S/tdMLt26o" +
       "XgFrrlXk8bdsqz51ItmrucSeAN/3Hkn2vWf3Lve6u/PG5bt2ur/HmcDH79H2" +
       "o3nxMSB/U0+6+83Yva381dfbWTs9YlHx0dvBfeAI3AfuP7ifvEfbp/Pik6fA" +
       "zc6A+/E3AC4/0CxdB9/uEbju/Qf3d+7R9nfz4m/twO02T/OKyh7c334D4B7N" +
       "K58CX+IIHHF/wJ3bE+yuCPz9eyD8XF78fFJ6E0DIRH5xtecO29+7o4897l94" +
       "A7gfyyvz4wPyCDd5/5X6T+7R9qt58SsA3inIFAgmMYiEz909EhZHtrsD0Fd+" +
       "/tnf/egrz/7H4gDukhWLSoRG5h2u+5zq881Xv/L1L735qc8XNwMemCvxLlSd" +
       "vSd1+zWoW243FQAeOhHlW3NQT+ZiORJl8ZuUbt5+hPre6+FKia1w5Sf6u3YH" +
       "69d3pyLXizOR67sTjg++eH1Md3s3KXTc466/77qnr49aPqK485c+eHh4+OIL" +
       "zwdBwYhy1ub2xwCvHZ8H/fqd9XhQ6DEvTvLqRUf3zN1VnuJQ6J8F2cn4B7tO" +
       "x5b5lr1lYo7v6fmR93Hb7lKK5R+e3GYDjdkdOf3ojtNislMp+fWM61/fo+1L" +
       "efGvktIFNedrB+Me5P/myF0Kp/riGw0m+fkcc2QJzP1xqoO9tgql7E7Hv3wP" +
       "SF/Niz9ISg8C9+KtvV4eK/Syv7MwUWJg6Xv0f3g/0E+P0E/vf0j5k3u0/de8" +
       "+OMd5q6SFGvBP9pD+9r9gPbiEbQX7w+0034AtPPoiXYmINADxwI+kzd9+x6o" +
       "/ywv/ttdUf/3N4A6j2nFAlg/Qq3/P0H91BmbnEZWUlyfKWwzH+HcxbsL4NyV" +
       "vDiXlC6pfrA5ksC5B08kcO7ge5FAlpQe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("On3JLr8x9MRtl3x3F1PVz79y9dLjrwj/bpdNji+PXiZLl4yV45y+a3Dq+WIQ" +
       "6YZVyOXy7uZBEcbPPZKUfuC7vGAEsB4/5gDOXduN8Nak9PS9RwARsfg93evx" +
       "pPTE3XolpfOgPE39JAjtd6IGlKA8TfkUyO1nKcH8xe9puutJ6cqeDiSg3cNp" +
       "kmfB6IAkf7wRHFvNd30bC53HSaSoCdBmtrO5J06be+Elj76ejZx643v2ltVJ" +
       "cU/8+J1qtbspflP9witD6iPfavzc7iaf6ijbbT7KJbCQ2F0qPFpInL5OdXa0" +
       "47EuEs9/5+Ffvvzc8TvkwzuG9653ird33PnaXM8NkuKi2/YfP/4rP/gLr3y5" +
       "uMjwfwFkC2SowC8AAA==");
}
