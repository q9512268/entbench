package org.apache.batik.ext.awt.image.codec.png;
public class PNGImageDecoder extends org.apache.batik.ext.awt.image.codec.util.ImageDecoderImpl {
    public PNGImageDecoder(java.io.InputStream input, org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam param) {
        super(
          input,
          param);
    }
    public java.awt.image.RenderedImage decodeAsRenderedImage(int page)
          throws java.io.IOException { if (page != 0) { throw new java.io.IOException(
                                                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                            getString(
                                                              "PNGImageDecoder19"));
                                       }
                                       return new org.apache.batik.ext.awt.image.codec.png.PNGImage(
                                         input,
                                         (org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam)
                                           param);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "q1ENTlLjfprlg1z72/yWXb7zX4Jbf8uKFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7R+96g/e+NvPfrOoUP4vF3pLCI4hAAA=");
}
class PNGChunk {
    int length;
    int type;
    byte[] data;
    int crc;
    final java.lang.String typeString;
    PNGChunk(int length, int type, byte[] data,
             int crc) { super();
                        this.length = length;
                        this.type = type;
                        this.data = data;
                        this.crc = crc;
                        typeString = "" +
                                     (char)
                                       (type >>>
                                          24 &
                                          255) +
                                     (char)
                                       (type >>>
                                          16 &
                                          255) +
                                     (char)
                                       (type >>>
                                          8 &
                                          255) +
                                     (char)
                                       (type &
                                          255);
    }
    public int getLength() { return length;
    }
    public int getType() { return type; }
    public java.lang.String getTypeString() {
        return typeString;
    }
    public byte[] getData() { return data;
    }
    public byte getByte(int offset) { return data[offset];
    }
    public int getInt1(int offset) { return data[offset] &
                                       255;
    }
    public int getInt2(int offset) { return (data[offset] &
                                               255) <<
                                       8 |
                                       data[offset +
                                              1] &
                                       255;
    }
    public int getInt4(int offset) { return (data[offset] &
                                               255) <<
                                       24 |
                                       (data[offset +
                                               1] &
                                          255) <<
                                       16 |
                                       (data[offset +
                                               2] &
                                          255) <<
                                       8 |
                                       data[offset +
                                              3] &
                                       255;
    }
    public java.lang.String getString4(int offset) {
        return "" +
        (char)
          data[offset] +
        (char)
          data[offset +
                 1] +
        (char)
          data[offset +
                 2] +
        (char)
          data[offset +
                 3];
    }
    public boolean isType(java.lang.String typeName) {
        return typeString.
          equals(
            typeName);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aCXAcxRXtXR2WZck6fMmXfMkmtmE35gaBwZYtvGYtqSxw" +
       "VWRseXa2JY01OzOe6ZXWIgZMhcLkoIgxZ4EqqRhMKIMJFRJS4XCK4ioIFQwJ" +
       "EAqckxCOCg4VSEIS8n/37M6xOyOrEqGq7Z3t/r/7//d///+7R4c/JBWWSZqp" +
       "xmJst0Gt2HqNdUmmRdNtqmRZl0Ffr3xbmfTx9nc7zouSyh4ydUCyNsmSRdsV" +
       "qqatHjJf0SwmaTK1OihNI0eXSS1qDklM0bUeMkOxEhlDVWSFbdLTFAm2SGaS" +
       "NEiMmUoqy2jCnoCR+UmQJM4lia/xD7cmSY2sG7sd8iYXeZtrBCkzzloWI/XJ" +
       "ndKQFM8yRY0nFYu15kyy0tDV3f2qzmI0x2I71bNsCDYmzyqCYPFDdZ98dtNA" +
       "PYdgmqRpOuPqWZuppatDNJ0kdU7vepVmrF3kKlKWJFNcxIy0JPOLxmHROCya" +
       "19ahAulrqZbNtOlcHZafqdKQUSBGFnknMSRTytjTdHGZYYYqZuvOmUHbhQVt" +
       "hZZFKt6yMn7gtu31D5eRuh5Sp2jdKI4MQjBYpAcApZkUNa016TRN95AGDYzd" +
       "TU1FUpUR29KNltKvSSwL5s/Dgp1Zg5p8TQcrsCPoZmZlppsF9fq4Q9m/KvpU" +
       "qR90nenoKjRsx35QsFoBwcw+CfzOZikfVLQ0Iwv8HAUdWy4FAmCdlKFsQC8s" +
       "Va5J0EEahYuoktYf7wbX0/qBtEIHBzQZmRM4KWJtSPKg1E970SN9dF1iCKgm" +
       "cyCQhZEZfjI+E1hpjs9KLvt82HHBjVdqG7QoiYDMaSqrKP8UYGr2MW2mfdSk" +
       "sA8EY82K5K3SzMf3RQkB4hk+YkHz46+euPjU5qPPCZq5JWg6UzupzHrlg6mp" +
       "L89rW35eGYpRZeiWgsb3aM53WZc90pozIMLMLMyIg7H84NHNz3zlmvvp+1FS" +
       "nSCVsq5mM+BHDbKeMRSVmpdQjZoSo+kEmUy1dBsfT5BJ8JxUNCp6O/v6LMoS" +
       "pFzlXZU6/w0Q9cEUCFE1PCtan55/NiQ2wJ9zBrH/KuCzwX7m34wMxgf0DI1L" +
       "sqQpmh7vMnXU34pDxEkBtgPxFHj9YNzSsya4YFw3++MS+MEAtQdwZ0rDLK5k" +
       "wPxxGaKRHDfAtbo6Lklg1zqKfWYMnc74YpfLofbThiMRMMw8f1hQYUdt0FWg" +
       "7ZUPZNeuP/Fg7wvC5XCb2LgxsgokiAkJYlwCHkRBghiXIMYliIEEMZCgbSCr" +
       "DZJIhK84HUUQbgBGHIRwAPG4Znn3to079i0uA/8zhsvBAki62JOX2pyYkQ/0" +
       "vfKRxtqRRW+veipKypOkUZJZVlIxzawx+yGAyYP2Hq9JQcZyEsdCV+LAjGfq" +
       "Mk1D3ApKIPYsVfoQNbGfkemuGfJpDTdwPDiplJSfHL19eO+Wq78cJVFvrsAl" +
       "KyDMIXsXRvhCJG/xx4hS89Zd/+4nR27dozvRwpN88jmziBN1WOz3CT88vfKK" +
       "hdIjvY/vaeGwT4ZoziTYfRAom/1reIJRaz6woy5VoHCfbmYkFYfyGFezAVMf" +
       "dnq4szbw5+ngFugapAY+XfZ25d84OtPAdpZwbvQznxY8cVzYbdz9+kt/PoPD" +
       "nc8xda7ioJuyVldcw8kaeQRrcNz2MpNSoHvr9q6bb/nw+q3cZ4FiSakFW7Bt" +
       "g3gGJgSYr3tu1xvH3z74arTg5yTn1a08RDdYZJkjBoRDFWIEOkvL5Rq4pdKn" +
       "SCmV4n76V93SVY98cGO9ML8KPXnvOXXsCZz+2WvJNS9s/7SZTxORMR07UDlk" +
       "IsZPc2ZeY5rSbpQjt/fY/Duele6GbAER2lJGKA+65Vz1cu8Wx23UnU1ZsB2V" +
       "DKA/ZOev07t2yPtauv4gctPsEgyCbsZ98W9teW3ni9y2VbjhsR/1rnVtZwgM" +
       "LseqF+B/Dn8R+PwHPwg6dog80NhmJ6OFhWxkGDmQfHlI+ehVIL6n8fjgXe8+" +
       "IBTwZ2sfMd134Oufx248ICwnSpolRVWFm0eUNUIdbM5F6RaFrcI52v90ZM9P" +
       "79tzvZCq0Zug10P9+cCv/v1i7PbfPF8i+pcpdll6BkbqQrye7rWNUGjdDXWP" +
       "3dRY1g6hIkGqspqyK0sTafeMUJFZ2ZTLWE6pxDvcqqFhGImsABtgxzne00vB" +
       "I7gDivWvmPLMk9b33nlY6FnK33z10n2HquQ3M89wf8M1zi5s0HnoEgtB18fE" +
       "/hTfjMj/Y/JOmUoasvZacNlu2VQMBsXnem1IMXUtg/LaNcIXsQz6ztJgz3bh" +
       "OnrvkpeuHl3yW3CPHlKlWJAnYW+VqGFdPB8dPv7+sdr5D/K0UY5b1La4t/gv" +
       "ru09JTu3Sh02CRE8z7LdHr/Odz2vZrDIbkb9roo/1+VKOPA8T8HBT7hOzrv/" +
       "lXN+eejbtw4LRwrZ/j6+pn92qqlrf/d3vo+KUnyJiODj74kfvmtO2+r3Ob+T" +
       "a5G7JVdcwYEdHN7T78/8Lbq48ukomdRD6mX7RLlFUrOYwXoAaSt/zIRTp2fc" +
       "eyIS5X9roZaY5w9JrmX9Wd6908uZZ1c3CCtGCE9wWznHKbxdgc1p3DJRBmff" +
       "bEpVIAFV9CmapHLec6FbpVq/qOYvxKbDcKwaFbz8dxOzsxPqAocqXaOY6PJj" +
       "oiRV9FjhQAuDpfxjvsc/NnGfdMB+a+r+3/+kpX/teGpR7Gseo9rE3wvA0iuC" +
       "Xc4vyrPXvjfnstUDO8ZRVi7w+ZF/yu9vOvz8Jcvk/VF+ZhZeUHTW9jK1em1f" +
       "bVKWNTVvXF8iPIBbr7T5+XbdLkzOx+IFyxC7hMLfesjYLmwGwXtkNL3wlBBy" +
       "VtSL9c2C0pXT+ozBeK0z8uisH15waPRtXtsZOVI66vCsxdszQyQYwWap5S72" +
       "vTZ33Rf1yje9+lHtlo+eOFEUYby17SbJaHV23TIM9bP8h7ENkjUAdGce7bii" +
       "Xj36GQ/uUyQZIrHVacKhMOephG3qikm//tlTM3e8XEai7aRa1aV0u8QPFWQy" +
       "VPPUGoDzZM646GKRNYeroKnnqpIi5YuRx45he1/P5Z0V/Plyb91cB5+EXTcn" +
       "/GcCO758TTgYNiuLq+4gbk+YOUccL7C9EpvrhGBXBSrnE7MWPhvthTYGiPmN" +
       "UDGDuJkTW/1CfnOcQuLQpfYylwYIuT9UyCBuEDItMQmfN/iEvHmcQuIhMGkv" +
       "kwwQ8o5QIYO4ob6VTbkUkHeevIzV2IsFY4e9SkeAjN8JiXq9vsPh5JD5mAjq" +
       "4uoyn9nqnawnBnwKfTdEoVwp8Ap/nusylxiufUowwswPutHkh5CD1x4YTXfe" +
       "sypfa1/EIGToxmkqHaKqa6pq/txfEAN3O2mCzzZbjG1+dB1FuQYZL5DVIawh" +
       "YflHIWOPYvMDkL+fsqQTLxysHx7LeU4mDpbCYSZ8JFsZafw4BLGG6PpUyNjT" +
       "2DzByCTAIZ/qXSg8OQEoNOLYAvhQWxU6fhSCWEM0/UXI2DFsXmCk1kbB2X33" +
       "Oli8OFFYzIaPYiukjB+LINYQfd8KGTuOzevCI9blo7+DwhsTgAJnnwWfjK1K" +
       "ZvwoBLH6NHVVd6Kuey8Eig+w+aOAYi2cTPFnpwPFOxMZInbZ+uwaPxRBrGNB" +
       "8WkIFP/A5q8CioTGVvnixMcTCUXW1ic7fiiCWMeAIlIeDEWkEjs/L0BxuheK" +
       "CJlIKEZsfUbGD0UQ61hQNIRAMQ2bmgIUZ/qgqJ2oiImV2l5bn73jhyKIdSwo" +
       "mkOgWIjNbCjrAAqRPjgaTv6IzJkANKbhGOaPG2yVbhg/GkGswWjcyzVeGYLG" +
       "adgsg7OYYhVeDoXc+01K6bpKJa3UYvbVH4fwlP8HhDlGqvKvOfGmoKnofy3E" +
       "/wfID47WVc0avfw1cf+Zf4dfkyRVfVlVdV+TuZ4rDZP2KRz2GnF853ffkfMZ" +
       "+dLJvoWFI40hTgWR8wT3hYy0nAw3Xprgt5v3Ykaaw3mBi3+7udoYaQriAvmg" +
       "dVO3MzK9FDVQQuumTMAxx08J6/NvN10StpJDB54kHtwknTA7kOBjl9gY3jOU" +
       "uAXNRfjQXLdX8Jw1Yyxncp2Llngudvj/8OQv3rLiv3h65SOjGzuuPHH2PeJt" +
       "paxKI/xeaEqSTBIvTvmkeHm3KHC2/FyVG5Z/NvWhyUvzJ60GIbCzmee6cvMw" +
       "7BQDPXmO752e1VJ4tffGwQue+Pm+ymNREtlKIhIj07YW3xfnjCwcAbcmi18M" +
       "bZFM/rKxdfmdu1ef2veXN/m1GSm6h/fT98qvHtr2yv6mg81RMiUBbqalaY5f" +
       "ZK/brW2m8pDZQ2oVa30ORIRZFEn1vHWaiptOwmDKcbHhrC304rtuRhYXv3Ar" +
       "/g+BalUfpuZaPaulcZraJJni9AjL+O4/s4bhY3B6bFNi2yZCGVoD/LE3uckw" +
       "8u8jJ6cMHnPWlY5r6Lj84mIdPqX/C4jtRQ3fJwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dCu1y8YoMOyyNBv0VwyfVlsLfsyN6Bq8xIg2TyJqqz/Vt6uOOBSkFq9pmy3c" +
       "HM6hcJXOWcwb0ZyAq8RMctQh7Gq6CUGBsSRgCdn0Oa3FUVyVoyshMicH63lK" +
       "k+RqaPcylmjWm0OcmjKSZ+OW5TqY1mBCKqk3VKkKkQ22QkOkkfLtqtBtlPub" +
       "pWBBQwGdtRrIcqkwUy2cuOW6woNUZbYShEkLbfedyFOH3U134Vn9FrEm1ShQ" +
       "l8xQI83pqjfshWN9uYaqqGzNhHk4mTsykxoxg4XL9ipFu2G/hwXE3JSnkNaP" +
       "RiaQwVRiqEd6HM8RuzHHmFnd5pv0ktdX+kiSIiyja5g/YOpSe6FLne0UGWsb" +
       "tx35pNoY9xpmZ+vWQzu12pZrcbHVtWJcXop9m44dpONAVuinRqKF8sqOYz8m" +
       "w2Ckqw20V03qzHIDXJ46MleF+thwaSem7o443OWajgsFidzvTOFZzUSzjOW3" +
       "w2pZ7FYH4ZxhJ40ejXGxysjGCFvPSCYievqkLIO8ZzlJUn+UtCbSqm72HB5l" +
       "FiwyHvggs47r3clw2CSdVTrdLmu9rJuiyw7GQu5moSCzed+eziZMJ1Ln62TV" +
       "lNUFuu4TFWi1wWq9gb8xUb2q893aBoZnhobMBgMmwziS0UKw4JUn2JSZyyKC" +
       "D5fhLJMiFGvzht0q92LVXyqdsWXFaxlMB5yNYrs7GTWnI5oWm3gopUhfU8px" +
       "mZt1GK0mLMmB5cTkYJYQLGbxbDkEYZ5QXW847SJrHRuQUKfhIqhmL4d0ZGkJ" +
       "ISzR1WZd1YSWrGnompA6mIFJvf5a7299aFLpJqEq4ejYwPA+68srftirrOZN" +
       "kLdNMapDzGu8qWArYAbFHddsDTPpmtHgrRa8VVMcExexbeozZY1tpzy69Tod" +
       "lyK3CreMmlg21jtTnFeHM44c1lKaVxVoqA/9eL0V0owGOfNkyImKr7RmDKPS" +
       "Us/eCOVKFW/yDj7m4BUT8fSoLscGiYzUnjF0IzyayUMTzBVbTuE+FMtYr95a" +
       "00KFi+S4KshlVq6Lsp5StEwbtEiXlyFbB7kjWcOprDa0BkgDlmVdJtiyOBlH" +
       "9nqA1SvqUllTSLyEVSatWJ0Y3jieEjQimNE5LobNrgaXW6FoM9zc0zqRqYj0" +
       "DCYyvD3o0fN5GJpLopMkFWTchKbRtFpZBM64123U9VEQ69ay09Jn3a3RVhh4" +
       "O1uFnc2UkrfzzUTcIOO4yqSJJTi1iWEpoRhtIRBoEexNtAhWm43FbDvMwpAc" +
       "jWqkNA4cLsExKJG4vrtYdrFoGZm6NDJhfITWoEFKDxss0GCtpqsoGzcrQ4xH" +
       "M1OSmkJExK3uvEduTEAdNalKj+uBLA/jeSiVSbOcmlOqHxg4pmLbSotZw4ls" +
       "bdFY6PCCqVURgmcHBOThiSibYliV5FokbaaQWR0uzKYKycs24kajwKulUdNU" +
       "kCpFaKsu73IGWL1kFod4DzxnIU6PnddsmoMrMwqj2EHfqkajNac5wSw2e7jA" +
       "j1QPhSt1LwgpldlEcMeDlHKXM1ayE7IcyYWGwHrceAxSsc52Up7VIb/Oqwzc" +
       "bfKDqVZLWXRI2z1o0odDQY+RENmOmwIxssi1ARLD5mSL1E1MJN0NhNa3ATWH" +
       "5XEMorX0vaXPvrnXPA8Wb6+O9hf9Dd5b7ZqeyYvnjl7/Hf2d2pNy4vXfiffN" +
       "pfyN+BN32zZUfCX97EdefkWc/UT1wsE7ymZQujewnW8zpEgyTgx1rThfHqmR" +
       "v7UuPQaODx6o8cGzbyGPgf5Nv1P83Dlt/yYvfgYoq0jB5Pjl97Fh/+XrvSI7" +
       "OeKdwD0CDu4AHPf2g/vlc9p+JS9+IShdAeAOvwGdgPaLbwHaQ3nlU+CQDqBJ" +
       "bz+0/3BO2xfz4t8HpfsPoB2/Yf7EMcAvvFWA7waHdgBQe/sB/pdz2n4/L353" +
       "57ve4ZeHY2i/9xagFWKPgsM8gGa+PdD2jgV2H/L+9Bx8f54Xf7zD102DIja/" +
       "/Rjfn7wd0849wOd+k/D9r3Pw/UVe/I8dPswKqmfm3v98O/CFB/jCbxK+b9wd" +
       "314h9tdH+Gpn8H397cCXHeDLvjn49t5x");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Dr778+LyEb76aXx7V94qteRf3l46wPfSNwnfo+fge3dePBSUrgF8O/IsIB6z" +
       "597DbwHiw3llzp4fP4D48bcd4icKGM+eA/G5vHgyKF3W/KPtiWc+il3hbduQ" +
       "OOsY9VNvBnUSlK4e7j3Nd9Q9dtsG+N2mbeFzr1y/+ugrq9/bbdE63Fh976R0" +
       "VQ4N4+R+mRPnlx1PkrXCDvfutic4BS4oKP29N7o1NihddHafZPf2d71rQenm" +
       "G+md793If0/2BRZ78vy+oFfxe7IXEpQeu1svoB8oT0rfCkrvvJM0kATlSckP" +
       "BKUbZyXB/Yvfk3IdEOXHciAedicnRXpgdCCSn/Z3+1ROf8DebYdK9k4nxUds" +
       "99DrBc2JPPrZUxtXiv9Ycbj/J9z914oXhM+/Mp5+z9eaP7Hb9SoYXJblo1yd" +
       "lK7sNuAWg+Z7iJ6562iHY10ePf/1B3763ucOM/MHdgofz78Tuj11572mfdMJ" +
       "it2h2b9+9F+9/5++8gfFp+v/D2ua8ljxMgAA");
}
class PNGImage extends org.apache.batik.ext.awt.image.codec.util.SimpleRenderedImage {
    public static final int PNG_COLOR_GRAY =
      0;
    public static final int PNG_COLOR_RGB =
      2;
    public static final int PNG_COLOR_PALETTE =
      3;
    public static final int PNG_COLOR_GRAY_ALPHA =
      4;
    public static final int PNG_COLOR_RGB_ALPHA =
      6;
    private static final java.lang.String[]
      colorTypeNames =
      { "Grayscale",
    "Error",
    "Truecolor",
    "Index",
    "Grayscale with alpha",
    "Error",
    "Truecolor with alpha" };
    public static final int PNG_FILTER_NONE =
      0;
    public static final int PNG_FILTER_SUB =
      1;
    public static final int PNG_FILTER_UP =
      2;
    public static final int PNG_FILTER_AVERAGE =
      3;
    public static final int PNG_FILTER_PAETH =
      4;
    private int[][] bandOffsets = { null,
    { 0 },
    { 0,
    1 },
    { 0,
    1,
    2 },
    { 0,
    1,
    2,
    3 } };
    private int bitDepth;
    private int colorType;
    private int compressionMethod;
    private int filterMethod;
    private int interlaceMethod;
    private int paletteEntries;
    private byte[] redPalette;
    private byte[] greenPalette;
    private byte[] bluePalette;
    private byte[] alphaPalette;
    private int bkgdRed;
    private int bkgdGreen;
    private int bkgdBlue;
    private int grayTransparentAlpha;
    private int redTransparentAlpha;
    private int greenTransparentAlpha;
    private int blueTransparentAlpha;
    private int maxOpacity;
    private int[] significantBits = null;
    private boolean suppressAlpha = false;
    private boolean expandPalette = false;
    private boolean output8BitGray = false;
    private boolean outputHasAlphaPalette =
      false;
    private boolean performGammaCorrection =
      false;
    private boolean expandGrayAlpha = false;
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam
      decodeParam =
      null;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    private boolean emitProperties = true;
    private float fileGamma = 45455 / 100000.0F;
    private float userExponent = 1.0F;
    private float displayExponent = 2.2F;
    private float[] chromaticity = null;
    private int sRGBRenderingIntent = -1;
    private int postProcess = POST_NONE;
    private static final int POST_NONE = 0;
    private static final int POST_GAMMA =
      1;
    private static final int POST_GRAY_LUT =
      2;
    private static final int POST_GRAY_LUT_ADD_TRANS =
      3;
    private static final int POST_PALETTE_TO_RGB =
      4;
    private static final int POST_PALETTE_TO_RGBA =
      5;
    private static final int POST_ADD_GRAY_TRANS =
      6;
    private static final int POST_ADD_RGB_TRANS =
      7;
    private static final int POST_REMOVE_GRAY_TRANS =
      8;
    private static final int POST_REMOVE_RGB_TRANS =
      9;
    private static final int POST_EXP_MASK =
      16;
    private static final int POST_GRAY_ALPHA_EXP =
      POST_NONE |
      POST_EXP_MASK;
    private static final int POST_GAMMA_EXP =
      POST_GAMMA |
      POST_EXP_MASK;
    private static final int POST_GRAY_LUT_ADD_TRANS_EXP =
      POST_GRAY_LUT_ADD_TRANS |
      POST_EXP_MASK;
    private static final int POST_ADD_GRAY_TRANS_EXP =
      POST_ADD_GRAY_TRANS |
      POST_EXP_MASK;
    private java.util.List<java.io.InputStream>
      streamVec =
      new java.util.ArrayList<java.io.InputStream>(
      );
    private java.io.DataInputStream dataStream;
    private int bytesPerPixel;
    private int inputBands;
    private int outputBands;
    private int chunkIndex = 0;
    private java.util.List textKeys = new java.util.ArrayList(
      );
    private java.util.List textStrings = new java.util.ArrayList(
      );
    private java.util.List ztextKeys = new java.util.ArrayList(
      );
    private java.util.List ztextStrings =
      new java.util.ArrayList(
      );
    private java.awt.image.WritableRaster
      theTile;
    private int[] gammaLut = null;
    private void initGammaLut(int bits) {
        double exp =
          (double)
            userExponent /
          (fileGamma *
             displayExponent);
        int numSamples =
          1 <<
          bits;
        int maxOutSample =
          bits ==
          16
          ? 65535
          : 255;
        gammaLut =
          (new int[numSamples]);
        for (int i =
               0;
             i <
               numSamples;
             i++) {
            double gbright =
              (double)
                i /
              (numSamples -
                 1);
            double gamma =
              java.lang.Math.
              pow(
                gbright,
                exp);
            int igamma =
              (int)
                (gamma *
                   maxOutSample +
                   0.5);
            if (igamma >
                  maxOutSample) {
                igamma =
                  maxOutSample;
            }
            gammaLut[i] =
              igamma;
        }
    }
    private final byte[][] expandBits = { null,
    { (byte)
        0,
    (byte)
      255 },
    { (byte)
        0,
    (byte)
      85,
    (byte)
      170,
    (byte)
      255 },
    null,
    { (byte)
        0,
    (byte)
      17,
    (byte)
      34,
    (byte)
      51,
    (byte)
      68,
    (byte)
      85,
    (byte)
      102,
    (byte)
      119,
    (byte)
      136,
    (byte)
      153,
    (byte)
      170,
    (byte)
      187,
    (byte)
      204,
    (byte)
      221,
    (byte)
      238,
    (byte)
      255 } };
    private int[] grayLut = null;
    private void initGrayLut(int bits) { int len =
                                           1 <<
                                           bits;
                                         grayLut =
                                           (new int[len]);
                                         if (performGammaCorrection) {
                                             java.lang.System.
                                               arraycopy(
                                                 gammaLut,
                                                 0,
                                                 grayLut,
                                                 0,
                                                 len);
                                         }
                                         else {
                                             for (int i =
                                                    0;
                                                  i <
                                                    len;
                                                  i++) {
                                                 grayLut[i] =
                                                   expandBits[bits][i];
                                             }
                                         }
    }
    public PNGImage(java.io.InputStream stream,
                    org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam decodeParam)
          throws java.io.IOException { super(
                                         );
                                       if (!stream.
                                             markSupported(
                                               )) {
                                           stream =
                                             new java.io.BufferedInputStream(
                                               stream);
                                       }
                                       java.io.DataInputStream distream =
                                         new java.io.DataInputStream(
                                         stream);
                                       if (decodeParam ==
                                             null) {
                                           decodeParam =
                                             new org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam(
                                               );
                                       }
                                       this.
                                         decodeParam =
                                         decodeParam;
                                       this.
                                         suppressAlpha =
                                         decodeParam.
                                           getSuppressAlpha(
                                             );
                                       this.
                                         expandPalette =
                                         decodeParam.
                                           getExpandPalette(
                                             );
                                       this.
                                         output8BitGray =
                                         decodeParam.
                                           getOutput8BitGray(
                                             );
                                       this.
                                         expandGrayAlpha =
                                         decodeParam.
                                           getExpandGrayAlpha(
                                             );
                                       if (decodeParam.
                                             getPerformGammaCorrection(
                                               )) {
                                           this.
                                             userExponent =
                                             decodeParam.
                                               getUserExponent(
                                                 );
                                           this.
                                             displayExponent =
                                             decodeParam.
                                               getDisplayExponent(
                                                 );
                                           performGammaCorrection =
                                             true;
                                           output8BitGray =
                                             true;
                                       }
                                       this.
                                         generateEncodeParam =
                                         decodeParam.
                                           getGenerateEncodeParam(
                                             );
                                       if (emitProperties) {
                                           properties.
                                             put(
                                               "file_type",
                                               "PNG v. 1.0");
                                       }
                                       try {
                                           long magic =
                                             distream.
                                             readLong(
                                               );
                                           if (magic !=
                                                 -8552249625308161526L) {
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder0");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }
                                       catch (java.lang.Exception e) {
                                           e.
                                             printStackTrace(
                                               );
                                           java.lang.String msg =
                                             org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                             getString(
                                               "PNGImageDecoder1");
                                           throw new java.lang.RuntimeException(
                                             msg);
                                       }
                                       do  {
                                           try {
                                               org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk;
                                               java.lang.String chunkType =
                                                 getChunkType(
                                                   distream);
                                               if (chunkType.
                                                     equals(
                                                       "IHDR")) {
                                                   chunk =
                                                     readChunk(
                                                       distream);
                                                   parse_IHDR_chunk(
                                                     chunk);
                                               }
                                               else
                                                   if (chunkType.
                                                         equals(
                                                           "PLTE")) {
                                                       chunk =
                                                         readChunk(
                                                           distream);
                                                       parse_PLTE_chunk(
                                                         chunk);
                                                   }
                                                   else
                                                       if (chunkType.
                                                             equals(
                                                               "IDAT")) {
                                                           chunk =
                                                             readChunk(
                                                               distream);
                                                           streamVec.
                                                             add(
                                                               new java.io.ByteArrayInputStream(
                                                                 chunk.
                                                                   getData(
                                                                     )));
                                                       }
                                                       else
                                                           if (chunkType.
                                                                 equals(
                                                                   "IEND")) {
                                                               chunk =
                                                                 readChunk(
                                                                   distream);
                                                               parse_IEND_chunk(
                                                                 chunk);
                                                               break;
                                                           }
                                                           else
                                                               if (chunkType.
                                                                     equals(
                                                                       "bKGD")) {
                                                                   chunk =
                                                                     readChunk(
                                                                       distream);
                                                                   parse_bKGD_chunk(
                                                                     chunk);
                                                               }
                                                               else
                                                                   if (chunkType.
                                                                         equals(
                                                                           "cHRM")) {
                                                                       chunk =
                                                                         readChunk(
                                                                           distream);
                                                                       parse_cHRM_chunk(
                                                                         chunk);
                                                                   }
                                                                   else
                                                                       if (chunkType.
                                                                             equals(
                                                                               "gAMA")) {
                                                                           chunk =
                                                                             readChunk(
                                                                               distream);
                                                                           parse_gAMA_chunk(
                                                                             chunk);
                                                                       }
                                                                       else
                                                                           if (chunkType.
                                                                                 equals(
                                                                                   "hIST")) {
                                                                               chunk =
                                                                                 readChunk(
                                                                                   distream);
                                                                               parse_hIST_chunk(
                                                                                 chunk);
                                                                           }
                                                                           else
                                                                               if (chunkType.
                                                                                     equals(
                                                                                       "iCCP")) {
                                                                                   chunk =
                                                                                     readChunk(
                                                                                       distream);
                                                                                   parse_iCCP_chunk(
                                                                                     chunk);
                                                                               }
                                                                               else
                                                                                   if (chunkType.
                                                                                         equals(
                                                                                           "pHYs")) {
                                                                                       chunk =
                                                                                         readChunk(
                                                                                           distream);
                                                                                       parse_pHYs_chunk(
                                                                                         chunk);
                                                                                   }
                                                                                   else
                                                                                       if (chunkType.
                                                                                             equals(
                                                                                               "sBIT")) {
                                                                                           chunk =
                                                                                             readChunk(
                                                                                               distream);
                                                                                           parse_sBIT_chunk(
                                                                                             chunk);
                                                                                       }
                                                                                       else
                                                                                           if (chunkType.
                                                                                                 equals(
                                                                                                   "sRGB")) {
                                                                                               chunk =
                                                                                                 readChunk(
                                                                                                   distream);
                                                                                               parse_sRGB_chunk(
                                                                                                 chunk);
                                                                                           }
                                                                                           else
                                                                                               if (chunkType.
                                                                                                     equals(
                                                                                                       "tEXt")) {
                                                                                                   chunk =
                                                                                                     readChunk(
                                                                                                       distream);
                                                                                                   parse_tEXt_chunk(
                                                                                                     chunk);
                                                                                               }
                                                                                               else
                                                                                                   if (chunkType.
                                                                                                         equals(
                                                                                                           "tIME")) {
                                                                                                       chunk =
                                                                                                         readChunk(
                                                                                                           distream);
                                                                                                       parse_tIME_chunk(
                                                                                                         chunk);
                                                                                                   }
                                                                                                   else
                                                                                                       if (chunkType.
                                                                                                             equals(
                                                                                                               "tRNS")) {
                                                                                                           chunk =
                                                                                                             readChunk(
                                                                                                               distream);
                                                                                                           parse_tRNS_chunk(
                                                                                                             chunk);
                                                                                                       }
                                                                                                       else
                                                                                                           if (chunkType.
                                                                                                                 equals(
                                                                                                                   "zTXt")) {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               parse_zTXt_chunk(
                                                                                                                 chunk);
                                                                                                           }
                                                                                                           else {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               java.lang.String type =
                                                                                                                 chunk.
                                                                                                                 getTypeString(
                                                                                                                   );
                                                                                                               byte[] data =
                                                                                                                 chunk.
                                                                                                                 getData(
                                                                                                                   );
                                                                                                               if (encodeParam !=
                                                                                                                     null) {
                                                                                                                   encodeParam.
                                                                                                                     addPrivateChunk(
                                                                                                                       type,
                                                                                                                       data);
                                                                                                               }
                                                                                                               if (emitProperties) {
                                                                                                                   java.lang.String key =
                                                                                                                     "chunk_" +
                                                                                                                   chunkIndex++ +
                                                                                                                   ':' +
                                                                                                                   type;
                                                                                                                   properties.
                                                                                                                     put(
                                                                                                                       key.
                                                                                                                         toLowerCase(
                                                                                                                           ),
                                                                                                                       data);
                                                                                                               }
                                                                                                           }
                                           }
                                           catch (java.lang.Exception e) {
                                               e.
                                                 printStackTrace(
                                                   );
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder2");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }while(true); 
                                       if (significantBits ==
                                             null) {
                                           significantBits =
                                             (new int[inputBands]);
                                           for (int i =
                                                  0;
                                                i <
                                                  inputBands;
                                                i++) {
                                               significantBits[i] =
                                                 bitDepth;
                                           }
                                           if (emitProperties) {
                                               properties.
                                                 put(
                                                   "significant_bits",
                                                   significantBits);
                                           }
                                       } }
    private static java.lang.String getChunkType(java.io.DataInputStream distream) {
        try {
            distream.
              mark(
                8);
            distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            distream.
              reset(
                );
            java.lang.String typeString =
              "";
            typeString +=
              (char)
                (type >>
                   24);
            typeString +=
              (char)
                (type >>
                   16 &
                   255);
            typeString +=
              (char)
                (type >>
                   8 &
                   255);
            typeString +=
              (char)
                (type &
                   255);
            return typeString;
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private static org.apache.batik.ext.awt.image.codec.png.PNGChunk readChunk(java.io.DataInputStream distream) {
        try {
            int length =
              distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            byte[] data =
              new byte[length];
            distream.
              readFully(
                data);
            int crc =
              distream.
              readInt(
                );
            return new org.apache.batik.ext.awt.image.codec.png.PNGChunk(
              length,
              type,
              data,
              crc);
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private void parse_IHDR_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        tileWidth =
          (width =
             chunk.
               getInt4(
                 0));
        tileHeight =
          (height =
             chunk.
               getInt4(
                 4));
        bitDepth =
          chunk.
            getInt1(
              8);
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
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder3");
            throw new java.lang.RuntimeException(
              msg);
        }
        maxOpacity =
          (1 <<
             bitDepth) -
            1;
        colorType =
          chunk.
            getInt1(
              9);
        if (colorType !=
              PNG_COLOR_GRAY &&
              colorType !=
              PNG_COLOR_RGB &&
              colorType !=
              PNG_COLOR_PALETTE &&
              colorType !=
              PNG_COLOR_GRAY_ALPHA &&
              colorType !=
              PNG_COLOR_RGB_ALPHA) {
            java.lang.System.
              out.
              println(
                org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder4"));
        }
        if (colorType ==
              PNG_COLOR_RGB &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder5");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_PALETTE &&
              bitDepth ==
              16) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder6");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_GRAY_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder7");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_RGB_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder8");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (emitProperties) {
            properties.
              put(
                "color_type",
                colorTypeNames[colorType]);
        }
        if (generateEncodeParam) {
            if (colorType ==
                  PNG_COLOR_PALETTE) {
                encodeParam =
                  new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette(
                    );
            }
            else
                if (colorType ==
                      PNG_COLOR_GRAY ||
                      colorType ==
                      PNG_COLOR_GRAY_ALPHA) {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray(
                        );
                }
                else {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB(
                        );
                }
            decodeParam.
              setEncodeParam(
                encodeParam);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setBitDepth(
                bitDepth);
        }
        if (emitProperties) {
            properties.
              put(
                "bit_depth",
                new java.lang.Integer(
                  bitDepth));
        }
        if (performGammaCorrection) {
            float gamma =
              1.0F /
              2.2F *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
            }
        }
        compressionMethod =
          chunk.
            getInt1(
              10);
        if (compressionMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder9");
            throw new java.lang.RuntimeException(
              msg);
        }
        filterMethod =
          chunk.
            getInt1(
              11);
        if (filterMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder10");
            throw new java.lang.RuntimeException(
              msg);
        }
        interlaceMethod =
          chunk.
            getInt1(
              12);
        if (interlaceMethod ==
              0) {
            if (encodeParam !=
                  null) {
                encodeParam.
                  setInterlacing(
                    false);
            }
            if (emitProperties) {
                properties.
                  put(
                    "interlace_method",
                    "None");
            }
        }
        else
            if (interlaceMethod ==
                  1) {
                if (encodeParam !=
                      null) {
                    encodeParam.
                      setInterlacing(
                        true);
                }
                if (emitProperties) {
                    properties.
                      put(
                        "interlace_method",
                        "Adam7");
                }
            }
            else {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder11");
                throw new java.lang.RuntimeException(
                  msg);
            }
        bytesPerPixel =
          bitDepth ==
            16
            ? 2
            : 1;
        switch (colorType) {
            case PNG_COLOR_GRAY:
                inputBands =
                  1;
                outputBands =
                  1;
                if (output8BitGray &&
                      bitDepth <
                      8) {
                    postProcess =
                      POST_GRAY_LUT;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
            case PNG_COLOR_RGB:
                inputBands =
                  3;
                bytesPerPixel *=
                  3;
                outputBands =
                  3;
                if (performGammaCorrection) {
                    postProcess =
                      POST_GAMMA;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_PALETTE:
                inputBands =
                  1;
                bytesPerPixel =
                  1;
                outputBands =
                  expandPalette
                    ? 3
                    : 1;
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGB;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_GRAY_ALPHA:
                inputBands =
                  2;
                bytesPerPixel *=
                  2;
                if (suppressAlpha) {
                    outputBands =
                      1;
                    postProcess =
                      POST_REMOVE_GRAY_TRANS;
                }
                else {
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                    if (expandGrayAlpha) {
                        postProcess |=
                          POST_EXP_MASK;
                        outputBands =
                          4;
                    }
                    else {
                        outputBands =
                          2;
                    }
                }
                break;
            case PNG_COLOR_RGB_ALPHA:
                inputBands =
                  4;
                bytesPerPixel *=
                  4;
                outputBands =
                  !suppressAlpha
                    ? 4
                    : 3;
                if (suppressAlpha) {
                    postProcess =
                      POST_REMOVE_RGB_TRANS;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
        }
    }
    private void parse_IEND_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk)
          throws java.lang.Exception { int textLen =
                                         textKeys.
                                         size(
                                           );
                                       java.lang.String[] textArray =
                                         new java.lang.String[2 *
                                                                textLen];
                                       for (int i =
                                              0;
                                            i <
                                              textLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               textKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               textStrings.
                                               get(
                                                 i);
                                           textArray[2 *
                                                       i] =
                                             key;
                                           textArray[2 *
                                                       i +
                                                       1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "text_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setText(
                                               textArray);
                                       }
                                       int ztextLen =
                                         ztextKeys.
                                         size(
                                           );
                                       java.lang.String[] ztextArray =
                                         new java.lang.String[2 *
                                                                ztextLen];
                                       for (int i =
                                              0;
                                            i <
                                              ztextLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               ztextKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               ztextStrings.
                                               get(
                                                 i);
                                           ztextArray[2 *
                                                        i] =
                                             key;
                                           ztextArray[2 *
                                                        i +
                                                        1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "ztext_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setCompressedText(
                                               ztextArray);
                                       }
                                       java.io.InputStream seqStream =
                                         new java.io.SequenceInputStream(
                                         java.util.Collections.
                                           enumeration(
                                             streamVec));
                                       java.io.InputStream infStream =
                                         new java.util.zip.InflaterInputStream(
                                         seqStream,
                                         new java.util.zip.Inflater(
                                           ));
                                       dataStream =
                                         new java.io.DataInputStream(
                                           infStream);
                                       int depth =
                                         bitDepth;
                                       if (colorType ==
                                             PNG_COLOR_GRAY &&
                                             bitDepth <
                                             8 &&
                                             output8BitGray) {
                                           depth =
                                             8;
                                       }
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             expandPalette) {
                                           depth =
                                             8;
                                       }
                                       int bytesPerRow =
                                         (outputBands *
                                            width *
                                            depth +
                                            7) /
                                         8;
                                       int scanlineStride =
                                         depth ==
                                         16
                                         ? bytesPerRow /
                                         2
                                         : bytesPerRow;
                                       theTile =
                                         createRaster(
                                           width,
                                           height,
                                           outputBands,
                                           scanlineStride,
                                           depth);
                                       if (performGammaCorrection &&
                                             gammaLut ==
                                             null) {
                                           initGammaLut(
                                             bitDepth);
                                       }
                                       if (postProcess ==
                                             POST_GRAY_LUT ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS_EXP) {
                                           initGrayLut(
                                             bitDepth);
                                       }
                                       decodeImage(
                                         interlaceMethod ==
                                           1);
                                       sampleModel =
                                         theTile.
                                           getSampleModel(
                                             );
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             !expandPalette) {
                                           if (outputHasAlphaPalette) {
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette,
                                                   alphaPalette);
                                           }
                                           else {
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette);
                                           }
                                       }
                                       else
                                           if (colorType ==
                                                 PNG_COLOR_GRAY &&
                                                 bitDepth <
                                                 8 &&
                                                 !output8BitGray) {
                                               byte[] palette =
                                                 expandBits[bitDepth];
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   palette.
                                                     length,
                                                   palette,
                                                   palette,
                                                   palette);
                                           }
                                           else {
                                               colorModel =
                                                 createComponentColorModel(
                                                   sampleModel);
                                           }
    }
    private static final int[] GrayBits8 =
      { 8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayAlphaBits8 =
      { 8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayBits16 =
      { 16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayAlphaBits16 =
      { 16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayBits32 =
      { 32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] GrayAlphaBits32 =
      { 32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBBits8 =
      { 8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBABits8 =
      { 8,
    8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBBits16 =
      { 16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBABits16 =
      { 16,
    16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBBits32 =
      { 32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBABits32 =
      { 32,
    32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static java.awt.image.ColorModel createComponentColorModel(java.awt.image.SampleModel sm) {
        int type =
          sm.
          getDataType(
            );
        int bands =
          sm.
          getNumBands(
            );
        java.awt.image.ComponentColorModel cm =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            switch (bands) {
                case 1:
                    cm =
                      colorModelGray8;
                    break;
                case 2:
                    cm =
                      colorModelGrayAlpha8;
                    break;
                case 3:
                    cm =
                      colorModelRGB8;
                    break;
                case 4:
                    cm =
                      colorModelRGBA8;
                    break;
            }
        }
        else
            if (type ==
                  java.awt.image.DataBuffer.
                    TYPE_USHORT) {
                switch (bands) {
                    case 1:
                        cm =
                          colorModelGray16;
                        break;
                    case 2:
                        cm =
                          colorModelGrayAlpha16;
                        break;
                    case 3:
                        cm =
                          colorModelRGB16;
                        break;
                    case 4:
                        cm =
                          colorModelRGBA16;
                        break;
                }
            }
            else
                if (type ==
                      java.awt.image.DataBuffer.
                        TYPE_INT) {
                    switch (bands) {
                        case 1:
                            cm =
                              colorModelGray32;
                            break;
                        case 2:
                            cm =
                              colorModelGrayAlpha32;
                            break;
                        case 3:
                            cm =
                              colorModelRGB32;
                            break;
                        case 4:
                            cm =
                              colorModelRGBA32;
                            break;
                    }
                }
        return cm;
    }
    private void parse_PLTE_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        paletteEntries =
          chunk.
            getLength(
              ) /
            3;
        redPalette =
          (new byte[paletteEntries]);
        greenPalette =
          (new byte[paletteEntries]);
        bluePalette =
          (new byte[paletteEntries]);
        int pltIndex =
          0;
        if (performGammaCorrection) {
            if (gammaLut ==
                  null) {
                initGammaLut(
                  bitDepth ==
                    16
                    ? 16
                    : 8);
            }
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                byte r =
                  chunk.
                  getByte(
                    pltIndex++);
                byte g =
                  chunk.
                  getByte(
                    pltIndex++);
                byte b =
                  chunk.
                  getByte(
                    pltIndex++);
                redPalette[i] =
                  (byte)
                    gammaLut[r &
                               255];
                greenPalette[i] =
                  (byte)
                    gammaLut[g &
                               255];
                bluePalette[i] =
                  (byte)
                    gammaLut[b &
                               255];
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                redPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                greenPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                bluePalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
            }
        }
    }
    private void parse_bKGD_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        switch (colorType) {
            case PNG_COLOR_PALETTE:
                int bkgdIndex =
                  chunk.
                  getByte(
                    0) &
                  255;
                bkgdRed =
                  redPalette[bkgdIndex] &
                    255;
                bkgdGreen =
                  greenPalette[bkgdIndex] &
                    255;
                bkgdBlue =
                  bluePalette[bkgdIndex] &
                    255;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette)
                       encodeParam).
                      setBackgroundPaletteIndex(
                        bkgdIndex);
                }
                break;
            case PNG_COLOR_GRAY:
            case PNG_COLOR_GRAY_ALPHA:
                int bkgdGray =
                  chunk.
                  getInt2(
                    0);
                bkgdRed =
                  (bkgdGreen =
                     (bkgdBlue =
                        bkgdGray));
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                       encodeParam).
                      setBackgroundGray(
                        bkgdGray);
                }
                break;
            case PNG_COLOR_RGB:
            case PNG_COLOR_RGB_ALPHA:
                bkgdRed =
                  chunk.
                    getInt2(
                      0);
                bkgdGreen =
                  chunk.
                    getInt2(
                      2);
                bkgdBlue =
                  chunk.
                    getInt2(
                      4);
                int[] bkgdRGB =
                  new int[3];
                bkgdRGB[0] =
                  bkgdRed;
                bkgdRGB[1] =
                  bkgdGreen;
                bkgdRGB[2] =
                  bkgdBlue;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                       encodeParam).
                      setBackgroundRGB(
                        bkgdRGB);
                }
                break;
        }
        int r =
          0;
        int g =
          0;
        int b =
          0;
        if (bitDepth <
              8) {
            r =
              expandBits[bitDepth][bkgdRed];
            g =
              expandBits[bitDepth][bkgdGreen];
            b =
              expandBits[bitDepth][bkgdBlue];
        }
        else
            if (bitDepth ==
                  8) {
                r =
                  bkgdRed;
                g =
                  bkgdGreen;
                b =
                  bkgdBlue;
            }
            else
                if (bitDepth ==
                      16) {
                    r =
                      bkgdRed >>
                        8;
                    g =
                      bkgdGreen >>
                        8;
                    b =
                      bkgdBlue >>
                        8;
                }
        if (emitProperties) {
            properties.
              put(
                "background_color",
                new java.awt.Color(
                  r,
                  g,
                  b));
        }
    }
    private void parse_cHRM_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          chunk.
            getInt4(
              0) /
            100000.0F;
        chromaticity[1] =
          chunk.
            getInt4(
              4) /
            100000.0F;
        chromaticity[2] =
          chunk.
            getInt4(
              8) /
            100000.0F;
        chromaticity[3] =
          chunk.
            getInt4(
              12) /
            100000.0F;
        chromaticity[4] =
          chunk.
            getInt4(
              16) /
            100000.0F;
        chromaticity[5] =
          chunk.
            getInt4(
              20) /
            100000.0F;
        chromaticity[6] =
          chunk.
            getInt4(
              24) /
            100000.0F;
        chromaticity[7] =
          chunk.
            getInt4(
              28) /
            100000.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setChromaticity(
                chromaticity);
        }
        if (emitProperties) {
            properties.
              put(
                "white_point_x",
                new java.lang.Float(
                  chromaticity[0]));
            properties.
              put(
                "white_point_y",
                new java.lang.Float(
                  chromaticity[1]));
            properties.
              put(
                "red_x",
                new java.lang.Float(
                  chromaticity[2]));
            properties.
              put(
                "red_y",
                new java.lang.Float(
                  chromaticity[3]));
            properties.
              put(
                "green_x",
                new java.lang.Float(
                  chromaticity[4]));
            properties.
              put(
                "green_y",
                new java.lang.Float(
                  chromaticity[5]));
            properties.
              put(
                "blue_x",
                new java.lang.Float(
                  chromaticity[6]));
            properties.
              put(
                "blue_y",
                new java.lang.Float(
                  chromaticity[7]));
        }
    }
    private void parse_gAMA_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        fileGamma =
          chunk.
            getInt4(
              0) /
            100000.0F;
        float exp =
          performGammaCorrection
          ? displayExponent /
          userExponent
          : 1.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setGamma(
                fileGamma *
                  exp);
        }
        if (emitProperties) {
            properties.
              put(
                "gamma",
                new java.lang.Float(
                  fileGamma *
                    exp));
        }
    }
    private void parse_hIST_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (redPalette ==
              null) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder18");
            throw new java.lang.RuntimeException(
              msg);
        }
        int length =
          redPalette.
            length;
        int[] hist =
          new int[length];
        for (int i =
               0;
             i <
               length;
             i++) {
            hist[i] =
              chunk.
                getInt2(
                  2 *
                    i);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setPaletteHistogram(
                hist);
        }
    }
    private void parse_iCCP_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        java.lang.String name =
          "";
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            name +=
              (char)
                b;
        }
    }
    private void parse_pHYs_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int xPixelsPerUnit =
          chunk.
          getInt4(
            0);
        int yPixelsPerUnit =
          chunk.
          getInt4(
            4);
        int unitSpecifier =
          chunk.
          getInt1(
            8);
        if (encodeParam !=
              null) {
            encodeParam.
              setPhysicalDimension(
                xPixelsPerUnit,
                yPixelsPerUnit,
                unitSpecifier);
        }
        if (emitProperties) {
            properties.
              put(
                "x_pixels_per_unit",
                new java.lang.Integer(
                  xPixelsPerUnit));
            properties.
              put(
                "y_pixels_per_unit",
                new java.lang.Integer(
                  yPixelsPerUnit));
            properties.
              put(
                "pixel_aspect_ratio",
                new java.lang.Float(
                  (float)
                    xPixelsPerUnit /
                    yPixelsPerUnit));
            if (unitSpecifier ==
                  1) {
                properties.
                  put(
                    "pixel_units",
                    "Meters");
            }
            else
                if (unitSpecifier !=
                      0) {
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder12");
                    throw new java.lang.RuntimeException(
                      msg);
                }
        }
    }
    private void parse_sBIT_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            significantBits =
              (new int[3]);
        }
        else {
            significantBits =
              (new int[inputBands]);
        }
        for (int i =
               0;
             i <
               significantBits.
                 length;
             i++) {
            int bits =
              chunk.
              getByte(
                i);
            int depth =
              colorType ==
              PNG_COLOR_PALETTE
              ? 8
              : bitDepth;
            if (bits <=
                  0 ||
                  bits >
                  depth) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder13");
                throw new java.lang.RuntimeException(
                  msg);
            }
            significantBits[i] =
              bits;
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setSignificantBits(
                significantBits);
        }
        if (emitProperties) {
            properties.
              put(
                "significant_bits",
                significantBits);
        }
    }
    private void parse_sRGB_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        sRGBRenderingIntent =
          chunk.
            getByte(
              0);
        fileGamma =
          45455 /
            100000.0F;
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          31270 /
            10000.0F;
        chromaticity[1] =
          32900 /
            10000.0F;
        chromaticity[2] =
          64000 /
            10000.0F;
        chromaticity[3] =
          33000 /
            10000.0F;
        chromaticity[4] =
          30000 /
            10000.0F;
        chromaticity[5] =
          60000 /
            10000.0F;
        chromaticity[6] =
          15000 /
            10000.0F;
        chromaticity[7] =
          6000 /
            10000.0F;
        if (performGammaCorrection) {
            float gamma =
              fileGamma *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
                encodeParam.
                  setChromaticity(
                    chromaticity);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
                properties.
                  put(
                    "white_point_x",
                    new java.lang.Float(
                      chromaticity[0]));
                properties.
                  put(
                    "white_point_y",
                    new java.lang.Float(
                      chromaticity[1]));
                properties.
                  put(
                    "red_x",
                    new java.lang.Float(
                      chromaticity[2]));
                properties.
                  put(
                    "red_y",
                    new java.lang.Float(
                      chromaticity[3]));
                properties.
                  put(
                    "green_x",
                    new java.lang.Float(
                      chromaticity[4]));
                properties.
                  put(
                    "green_y",
                    new java.lang.Float(
                      chromaticity[5]));
                properties.
                  put(
                    "blue_x",
                    new java.lang.Float(
                      chromaticity[6]));
                properties.
                  put(
                    "blue_y",
                    new java.lang.Float(
                      chromaticity[7]));
            }
        }
    }
    private void parse_tEXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        byte b;
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        for (int i =
               textIndex;
             i <
               chunk.
               getLength(
                 );
             i++) {
            value.
              append(
                (char)
                  chunk.
                  getByte(
                    i));
        }
        textKeys.
          add(
            key.
              toString(
                ));
        textStrings.
          add(
            value.
              toString(
                ));
    }
    private void parse_tIME_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int year =
          chunk.
          getInt2(
            0);
        int month =
          chunk.
          getInt1(
            2) -
          1;
        int day =
          chunk.
          getInt1(
            3);
        int hour =
          chunk.
          getInt1(
            4);
        int minute =
          chunk.
          getInt1(
            5);
        int second =
          chunk.
          getInt1(
            6);
        java.util.TimeZone gmt =
          java.util.TimeZone.
          getTimeZone(
            "GMT");
        java.util.GregorianCalendar cal =
          new java.util.GregorianCalendar(
          gmt);
        cal.
          set(
            year,
            month,
            day,
            hour,
            minute,
            second);
        java.util.Date date =
          cal.
          getTime(
            );
        if (encodeParam !=
              null) {
            encodeParam.
              setModificationTime(
                date);
        }
        if (emitProperties) {
            properties.
              put(
                "timestamp",
                date);
        }
    }
    private void parse_tRNS_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            int entries =
              chunk.
              getLength(
                );
            if (entries >
                  paletteEntries) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder14");
                throw new java.lang.RuntimeException(
                  msg);
            }
            alphaPalette =
              (new byte[paletteEntries]);
            for (int i =
                   0;
                 i <
                   entries;
                 i++) {
                alphaPalette[i] =
                  chunk.
                    getByte(
                      i);
            }
            for (int i =
                   entries;
                 i <
                   paletteEntries;
                 i++) {
                alphaPalette[i] =
                  (byte)
                    255;
            }
            if (!suppressAlpha) {
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGBA;
                    outputBands =
                      4;
                }
                else {
                    outputHasAlphaPalette =
                      true;
                }
            }
        }
        else
            if (colorType ==
                  PNG_COLOR_GRAY) {
                grayTransparentAlpha =
                  chunk.
                    getInt2(
                      0);
                if (!suppressAlpha) {
                    if (bitDepth <
                          8) {
                        output8BitGray =
                          true;
                        maxOpacity =
                          255;
                        postProcess =
                          POST_GRAY_LUT_ADD_TRANS;
                    }
                    else {
                        postProcess =
                          POST_ADD_GRAY_TRANS;
                    }
                    if (expandGrayAlpha) {
                        outputBands =
                          4;
                        postProcess |=
                          POST_EXP_MASK;
                    }
                    else {
                        outputBands =
                          2;
                    }
                    if (encodeParam !=
                          null) {
                        ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                           encodeParam).
                          setTransparentGray(
                            grayTransparentAlpha);
                    }
                }
            }
            else
                if (colorType ==
                      PNG_COLOR_RGB) {
                    redTransparentAlpha =
                      chunk.
                        getInt2(
                          0);
                    greenTransparentAlpha =
                      chunk.
                        getInt2(
                          2);
                    blueTransparentAlpha =
                      chunk.
                        getInt2(
                          4);
                    if (!suppressAlpha) {
                        outputBands =
                          4;
                        postProcess =
                          POST_ADD_RGB_TRANS;
                        if (encodeParam !=
                              null) {
                            int[] rgbTrans =
                              new int[3];
                            rgbTrans[0] =
                              redTransparentAlpha;
                            rgbTrans[1] =
                              greenTransparentAlpha;
                            rgbTrans[2] =
                              blueTransparentAlpha;
                            ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                               encodeParam).
                              setTransparentRGB(
                                rgbTrans);
                        }
                    }
                }
                else
                    if (colorType ==
                          PNG_COLOR_GRAY_ALPHA ||
                          colorType ==
                          PNG_COLOR_RGB_ALPHA) {
                        java.lang.String msg =
                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                          getString(
                            "PNGImageDecoder15");
                        throw new java.lang.RuntimeException(
                          msg);
                    }
    }
    private void parse_zTXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int textIndex =
          0;
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        byte b;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        chunk.
          getByte(
            textIndex++);
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        try {
            int length =
              chunk.
              getLength(
                ) -
              textIndex;
            byte[] data =
              chunk.
              getData(
                );
            java.io.InputStream cis =
              new java.io.ByteArrayInputStream(
              data,
              textIndex,
              length);
            java.io.InputStream iis =
              new java.util.zip.InflaterInputStream(
              cis);
            int c;
            while ((c =
                      iis.
                        read(
                          )) !=
                     -1) {
                value.
                  append(
                    (char)
                      c);
            }
            ztextKeys.
              add(
                key.
                  toString(
                    ));
            ztextStrings.
              add(
                value.
                  toString(
                    ));
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
        }
    }
    private java.awt.image.WritableRaster createRaster(int width,
                                                       int height,
                                                       int bands,
                                                       int scanlineStride,
                                                       int bitDepth) {
        java.awt.image.DataBuffer dataBuffer;
        java.awt.image.WritableRaster ras =
          null;
        java.awt.Point origin =
          new java.awt.Point(
          0,
          0);
        if (bitDepth <
              8 &&
              bands ==
              1) {
            dataBuffer =
              new java.awt.image.DataBufferByte(
                height *
                  scanlineStride);
            ras =
              java.awt.image.Raster.
                createPackedRaster(
                  dataBuffer,
                  width,
                  height,
                  bitDepth,
                  origin);
        }
        else
            if (bitDepth <=
                  8) {
                dataBuffer =
                  new java.awt.image.DataBufferByte(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
            else {
                dataBuffer =
                  new java.awt.image.DataBufferUShort(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
        return ras;
    }
    private static void decodeSubFilter(byte[] curr,
                                        int count,
                                        int bpp) {
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int val;
            val =
              curr[i] &
                255;
            val +=
              curr[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                val;
        }
    }
    private static void decodeUpFilter(byte[] curr,
                                       byte[] prev,
                                       int count) {
        for (int i =
               0;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            int prior =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   prior);
        }
    }
    private static void decodeAverageFilter(byte[] curr,
                                            byte[] prev,
                                            int count,
                                            int bpp) {
        int raw;
        int priorPixel;
        int priorRow;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            raw =
              curr[i] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   priorRow /
                   2);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            raw =
              curr[i] &
                255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   (priorPixel +
                      priorRow) /
                   2);
        }
    }
    private static void decodePaethFilter(byte[] curr,
                                          byte[] prev,
                                          int count,
                                          int bpp) {
        int raw;
        int priorPixel;
        int priorRow;
        int priorRowPixel;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            raw =
              curr[i] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   priorRow);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            raw =
              curr[i] &
                255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            priorRow =
              prev[i] &
                255;
            priorRowPixel =
              prev[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                (raw +
                   org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
                   paethPredictor(
                     priorPixel,
                     priorRow,
                     priorRowPixel));
        }
    }
    private void processPixels(int process,
                               java.awt.image.Raster src,
                               java.awt.image.WritableRaster dst,
                               int xOffset,
                               int step,
                               int y,
                               int width) {
        int srcX;
        int dstX;
        int[] ps =
          src.
          getPixel(
            0,
            0,
            (int[])
              null);
        int[] pd =
          dst.
          getPixel(
            0,
            0,
            (int[])
              null);
        dstX =
          xOffset;
        switch (process) {
            case POST_NONE:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    for (int i =
                           0;
                         i <
                           inputBands;
                         i++) {
                        int x =
                          ps[i];
                        ps[i] =
                          gammaLut[x];
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    pd[0] =
                      grayLut[ps[0]];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      grayLut[val];
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGB:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGBA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    pd[3] =
                      alphaPalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_RGB_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[r];
                        pd[1] =
                          gammaLut[g];
                        pd[2] =
                          gammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    if (r ==
                          redTransparentAlpha &&
                          g ==
                          greenTransparentAlpha &&
                          b ==
                          blueTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int g =
                      ps[0];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[g];
                    }
                    else {
                        pd[0] =
                          g;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_RGB_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[r];
                        pd[1] =
                          gammaLut[g];
                        pd[2] =
                          gammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    int gamma =
                      gammaLut[val];
                    pd[0] =
                      gamma;
                    pd[1] =
                      gamma;
                    pd[2] =
                      gamma;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_ALPHA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int val2 =
                      grayLut[val];
                    pd[0] =
                      val2;
                    pd[1] =
                      val2;
                    pd[2] =
                      val2;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
        }
    }
    private void decodePass(java.awt.image.WritableRaster imRas,
                            int xOffset,
                            int yOffset,
                            int xStep,
                            int yStep,
                            int passWidth,
                            int passHeight) {
        if (passWidth ==
              0 ||
              passHeight ==
              0) {
            return;
        }
        int bytesPerRow =
          (inputBands *
             passWidth *
             bitDepth +
             7) /
          8;
        int eltsPerRow =
          bitDepth ==
          16
          ? bytesPerRow /
          2
          : bytesPerRow;
        byte[] curr =
          new byte[bytesPerRow];
        byte[] prior =
          new byte[bytesPerRow];
        java.awt.image.WritableRaster passRow =
          createRaster(
            passWidth,
            1,
            inputBands,
            eltsPerRow,
            bitDepth);
        java.awt.image.DataBuffer dataBuffer =
          passRow.
          getDataBuffer(
            );
        int type =
          dataBuffer.
          getDataType(
            );
        byte[] byteData =
          null;
        short[] shortData =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            byteData =
              ((java.awt.image.DataBufferByte)
                 dataBuffer).
                getData(
                  );
        }
        else {
            shortData =
              ((java.awt.image.DataBufferUShort)
                 dataBuffer).
                getData(
                  );
        }
        int srcY;
        int dstY;
        for (srcY =
               0,
               dstY =
                 yOffset;
             srcY <
               passHeight;
             srcY++,
               dstY +=
                 yStep) {
            int filter =
              0;
            try {
                filter =
                  dataStream.
                    read(
                      );
                dataStream.
                  readFully(
                    curr,
                    0,
                    bytesPerRow);
            }
            catch (java.lang.Exception e) {
                e.
                  printStackTrace(
                    );
            }
            switch (filter) {
                case PNG_FILTER_NONE:
                    break;
                case PNG_FILTER_SUB:
                    decodeSubFilter(
                      curr,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_UP:
                    decodeUpFilter(
                      curr,
                      prior,
                      bytesPerRow);
                    break;
                case PNG_FILTER_AVERAGE:
                    decodeAverageFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_PAETH:
                    decodePaethFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                default:
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder16");
                    throw new java.lang.RuntimeException(
                      msg);
            }
            if (bitDepth <
                  16) {
                java.lang.System.
                  arraycopy(
                    curr,
                    0,
                    byteData,
                    0,
                    bytesPerRow);
            }
            else {
                int idx =
                  0;
                for (int j =
                       0;
                     j <
                       eltsPerRow;
                     j++) {
                    shortData[j] =
                      (short)
                        (curr[idx] <<
                           8 |
                           curr[idx +
                                  1] &
                           255);
                    idx +=
                      2;
                }
            }
            processPixels(
              postProcess,
              passRow,
              imRas,
              xOffset,
              xStep,
              dstY,
              passWidth);
            byte[] tmp =
              prior;
            prior =
              curr;
            curr =
              tmp;
        }
    }
    private void decodeImage(boolean useInterlacing) {
        if (!useInterlacing) {
            decodePass(
              theTile,
              0,
              0,
              1,
              1,
              width,
              height);
        }
        else {
            decodePass(
              theTile,
              0,
              0,
              8,
              8,
              (width +
                 7) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              4,
              0,
              8,
              8,
              (width +
                 3) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              0,
              4,
              4,
              8,
              (width +
                 3) /
                4,
              (height +
                 3) /
                8);
            decodePass(
              theTile,
              2,
              0,
              4,
              4,
              (width +
                 1) /
                4,
              (height +
                 3) /
                4);
            decodePass(
              theTile,
              0,
              2,
              2,
              4,
              (width +
                 1) /
                2,
              (height +
                 1) /
                4);
            decodePass(
              theTile,
              1,
              0,
              2,
              2,
              width /
                2,
              (height +
                 1) /
                2);
            decodePass(
              theTile,
              0,
              1,
              1,
              2,
              width,
              height /
                2);
        }
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        if (tileX !=
              0 ||
              tileY !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder17");
            throw new java.lang.IllegalArgumentException(
              msg);
        }
        return theTile;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1dCXgcxbHu3ZUsId8ntsEG2zJgMBK2sbExlyTLkkAXkmxA" +
       "2IjR7kgavNodZntl2Ym5EgKEF8JhzoATwAQCBPM4ws1zIEAIBD4cCCY8rpBH" +
       "OBMTh4SEQF5Vd+/O7Ox0r2aMou+b3tFsV1f9f3dXV89M9975CSlOWWSmnqAV" +
       "dIOppypqE7RVs1J6rCaupVIdcK0renVE233a+83LwmREJxnTp6WaolpKX2no" +
       "8Viqk8wwEimqJaJ6qlnXYyjRaukp3RrQqJFMdJLJRqqh34wbUYM2JWM6Zlit" +
       "WY1kvEapZXSnqd4gCqBkRiNYUsksqaxyf728kYyKJs0Ndvapjuw1jm8wZ7+t" +
       "K0XJuMYztAGtMk2NeGWjkaLLBy1yiJmMb+iNJ2mFPkgrzogvFhQc37g4j4LZ" +
       "d4/92xeX9o1jFEzUEokkZfBSbXoqGR/QY41krH21Nq73p84kZ5FIIxnpyExJ" +
       "eWNGaSUorQSlGbR2LrB+tJ5I99ckGRyaKWmEGUWDKJmVW4ipWVq/KKaV2Qwl" +
       "lFKBnQkD2v2zaDnKPIhXHlK5+erTxt0TIWM7yVgj0Y7mRMEICko6gVC9v1u3" +
       "UlWxmB7rJOMTUNntumVocWOjqOkJKaM3odE0VH+GFryYNnWL6bS5gnoEbFY6" +
       "SpNWFl4Pa1Div+KeuNYLWKfYWDnClXgdAJYZYJjVo0G7EyJF64xEjJL93BJZ" +
       "jOUnQAYQLenXaV8yq6ooocEFMoE3kbiW6K1sh6aX6IWsxUlogBYl06WFItem" +
       "Fl2n9epd2CJd+Vr5V5BrL0YEilAy2Z2NlQS1NN1VS476+aT5qEu+kahPhEkI" +
       "bI7p0TjaPxKEZrqE2vQe3dKhH3DBUQc3XqVNeezCMCGQebIrM8/zwDc/PW7+" +
       "zO2/5Hn28cjT0n2GHqVd0a3dY17at2besgiaUWomUwZWfg5y1staxTfLB03w" +
       "MFOyJeKXFZkvt7c9fco5t+sfhUlZAxkRTcbT/dCOxkeT/aYR1606PaFbGtVj" +
       "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" +
       "AlRMp9C4WoLlicBYVktK9u4x3rXzZIBB");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "JJeOMoWoC61jy1FHC3lIwckjmNyH65V0iov98N/LbD7u/zr4GKSktLW5jvFt" +
       "piwy1fWqRasWXQdfdUXv2jK2dO8tq17lvzCOe1RgAaMaSWlPOh53bC7h3Ghi" +
       "hGnpPXwt2CiWjmc/Gl38JCUHDfUxKiURkz+cLn6CSz9NSflQpPHHpPHTKfss" +
       "JTPVsiDFPp1Sz1MyVSYF9kHqzP0iJZO8ckNOSJ05d8Dcw50T9LNPZ75XwE3Y" +
       "+SgZwU+cWXZC6ZAFT18zMy7+6CGRzPaBaTfwCRvfq1WPsfYwyB/H5eyewX4w" +
       "cnKhlud4d2eOdFeXpnSrWAu+bcvxzd/4dMktbJOb4mhc27gRSxnZSEpwd36N" +
       "P46L5K0rd5aWKWtE/bwvxty919zM20DjucF2N97H7mFszyMTm/10e0OcKsvS" +
       "NqTK2Qduc/La1qMe//WFI3aESehUEoIAdeKpfAsbfIZbyXcbWT5opi0y49TG" +
       "3N0CnLufLJ933YZj5vf8+XU0zCR8c5p95fm7oi/fuvY3l0/dOjNMRjZAm8Sd" +
       "EzpJmZFasSHRpkcHrE4y2kjVDoKJUIqhxRtIaTphnJnWG2KyvWVG5+wtQ8ls" +
       "98/AD2EvmdGNZKR9hdeMcnsZFLCviKrElP3G51r2biM03q7GJtPMbDazV8xk" +
       "DsrwGE344tLij9kpnn3y/4RiKD3ulgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "s7FawYa9QEUUWljOZJrMaTEyPZD2RwsU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "usv2bGpisdVQRYHCubnBMY1JESxiyMLk");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "f/VkCPrdW0G/+ykS9EPnCPpjWfJvTgTNFnbfJegHngxBt2+HvHrL2yGfJEH/" +
       "3TmCfiRLPnwsaAhPwp2C3nb51osI+ntbQX/vKRL0V88R9Nez5BdPBB0QuyOj" +
       "//BkCLp9wdTVW14w9SQJ+jvnCPq7WfLxE0HpIbNT0Nu+G+0Cgl7bXu659qRf" +
       "7tkK+qlzBP2TLPnDY0HX7B7T/c9PQNDs5a3Zda1r28s7156kyzvX8gzZK1QK" +
       "7K4kF/CvzhH+b7Lkz7K3kOXjnuMlMi//04ngt3012jmC56/J6KeIX7UV/KsO" +
       "EPx2V0KuHF843byn+5TMnztH5r/Pks9mr4XL37LIRBJiWBuxT9f3/3iiYmeG" +
       "/S+2Yn/DUyf2VvYs67Wr+8W+lr2z5uo/hfl68KnYY2+X1NcKT1TqNOa/tr2I" +
       "fO2dT6LUV/NcV89IfSL6g+eI/lCWPD0sPLwRvbVU/XTovlP++56o/K9L5f7B" +
       "rfw/8M8o/wvOkf9FWfKcsPDMo/eKqqG+U/rnPlFn3kul/uhW+lve4X6O9Of4" +
       "uLvzDHfnkuY/PissPOvMRZhTfutELWcU9IpzFPTqLHlpWHiGt3nfXL78fHBG" +
       "OY89UeV8caFw1/Yl43d99MlWzm7Jz+gAOkcHuYzlMH/bRG4kwVkF3Ha50dsp" +
       "oJqiPmtz7ObziSvgpKu/9I5cjPY5ImZX+a697vj9uoPMds7I+CVPQMZ8deTn" +
       "pbK9bCvjLW+ouZ2Mr9gp46kXWp6qy7O5TguavbPm2iBb/FgNs6Wxs39feSIk" +
       "eoiQcVi4hxr2cmV5gV947pk7f5Qom+muG/KPvu+Be57zvvHvXS5cxQtXs/eL" +
       "ZEU9DS/co0WWderFIKdfEnKX56uakYv9tDy938sl4MPCKy56hyIsXEnTDPwa" +
       "tzlaCAuPXeTosHAt/zx97JvCwovOPzY9Kv88fdSXh4Xn7jsq5UvT07nTEz+y" +
       "K3eaM01P59TSwPRszvT8+efpfEbacE/yhYW7Nl9OZ7HS0tMs2VfbO/Kkr7uQ" +
       "kvPX7jBGdj1988pQVcntId5cfH/u6faQWVjhodtZ2KlbyS/d+54dIqK2r2H4" +
       "4PvQ4Vd8Bvr+/DVE12RLXK+zUu7BC3dnr0IXNxffL8VnX+lwurSjsu7qv/Lz" +
       "93/oaS87ujl9/wb4pG2eYvvCk7cOdVzL2rxpPXgMtr0wyd5Os/7p5/zEa3/g" +
       "fZ/MyvL+f7bCnQbTqgAA");
}
