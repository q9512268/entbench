package org.apache.batik.apps.rasterizer;
public final class DestinationType {
    public static final java.lang.String PNG_STR = "image/png";
    public static final java.lang.String JPEG_STR = "image/jpeg";
    public static final java.lang.String TIFF_STR = "image/tiff";
    public static final java.lang.String PDF_STR = "application/pdf";
    public static final int PNG_CODE = 0;
    public static final int JPEG_CODE = 1;
    public static final int TIFF_CODE = 2;
    public static final int PDF_CODE = 3;
    public static final java.lang.String PNG_EXTENSION = ".png";
    public static final java.lang.String JPEG_EXTENSION = ".jpg";
    public static final java.lang.String TIFF_EXTENSION = ".tif";
    public static final java.lang.String PDF_EXTENSION = ".pdf";
    public static final org.apache.batik.apps.rasterizer.DestinationType PNG =
      new org.apache.batik.apps.rasterizer.DestinationType(
      PNG_STR,
      PNG_CODE,
      PNG_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType JPEG =
      new org.apache.batik.apps.rasterizer.DestinationType(
      JPEG_STR,
      JPEG_CODE,
      JPEG_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType TIFF =
      new org.apache.batik.apps.rasterizer.DestinationType(
      TIFF_STR,
      TIFF_CODE,
      TIFF_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType PDF =
      new org.apache.batik.apps.rasterizer.DestinationType(
      PDF_STR,
      PDF_CODE,
      PDF_EXTENSION);
    private java.lang.String type;
    private int code;
    private java.lang.String extension;
    private DestinationType(java.lang.String type, int code, java.lang.String extension) {
        super(
          );
        this.
          type =
          type;
        this.
          code =
          code;
        this.
          extension =
          extension;
    }
    public java.lang.String getExtension() { return extension; }
    public java.lang.String toString() { return type; }
    public int toInt() { return code; }
    protected org.apache.batik.transcoder.Transcoder getTranscoder() {
        switch (code) {
            case PNG_CODE:
                return (org.apache.batik.transcoder.image.PNGTranscoder)
                         ent.runtime.ENT_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.PNGTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.EntMode.
                                                       DYNAMIC_MODE });
            case JPEG_CODE:
                return (org.apache.batik.transcoder.image.JPEGTranscoder)
                         ent.runtime.ENT_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.JPEGTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.EntMode.
                                                       DYNAMIC_MODE });
            case TIFF_CODE:
                return (org.apache.batik.transcoder.image.TIFFTranscoder)
                         ent.runtime.ENT_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.TIFFTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.EntMode.
                                                       DYNAMIC_MODE });
            case PDF_CODE:
                try {
                    java.lang.Class pdfClass =
                      java.lang.Class.
                      forName(
                        "org.apache.fop.svg.PDFTranscoder");
                    return (org.apache.batik.transcoder.Transcoder)
                             pdfClass.
                             newInstance(
                               );
                }
                catch (java.lang.Exception e) {
                    return null;
                }
            default:
                return null;
        }
    }
    public org.apache.batik.apps.rasterizer.DestinationType[] getValues() {
        return new org.apache.batik.apps.rasterizer.DestinationType[] { PNG,
        JPEG,
        TIFF,
        PDF };
    }
    public java.lang.Object readResolve() {
        switch (code) {
            case PNG_CODE:
                return PNG;
            case JPEG_CODE:
                return JPEG;
            case TIFF_CODE:
                return TIFF;
            case PDF_CODE:
                return PDF;
            default:
                throw new java.lang.Error(
                  "unknown code:" +
                  code);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KPd6kevWEMdUjYq82hxATdNsGwnZSWNt2rav9ecrcqORMUubbPT25dc1wIbE" +
       "gDpUaGgzIxU6FeLWna+MTzo2Rc0DEls7A1+FdtKMVHtWl3jINSXn8pt5YUt8" +
       "4HB12eTDV79mWkPmUlUlTI8SKVl2HsM4vks1nSYkrthK81CGHz2GVEZmnWvt" +
       "y2Cekv3Bx1IxO0PNxLydYXaO/5xtU6BIb1tIEfy/sx1oo9xux0ip+eFsshtW" +
       "UdAEP6/TfEcpHXLPejODRiaea9AcE+UGl0/zW4uZIJIy7y0OiCcOr+/afXb5" +
       "PeaFDVEWdu1CKhXgfubdkeyEcrYvtQyt0nXzPx334Ni5mRBUawps+8M022hJ" +
       "L/irhqYy1XOZwWjM3ml448iqx1/YV/oyhJtNJCQwMn5T7oFfWkvBTH5TR+7B" +
       "N0Qnfsuief5Pdl6+MPHRm5mDgJD7INXbfkB89ei1r9w65Uh9mFTESAmsKmia" +
       "n0S27lQ2UnFE7ydVktGWBhGBiiTIrlP1cWjVAs6guF4sdVZlS/G6DyNzci8U" +
       "5F6SKpfVHVRfo6aUuBU0K+ySTJx0zclTmubpYJc4IilfxTenzSBUNNDRqWmZ" +
       "+xbkuMZ9e23+6IqGewv/xK8D/wM7TGj+0SwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3zW5Pk1DWuBxY8iP+rizxOstrJGObRaWo3jF9KJw3tcmAgNN4FG0btSC5YZL" +
       "ayEFOWR5xguuuRBbgTy1JmWCjsXempk2ebU+IPSpyXTIUXuiqjqf1GeizMHI" +
       "ZkaQfTK1h3hqGU5jxXT9OpLEm15twhtsAhv+klz6/ZFOB4LmjFjHKdrLJdsp" +
       "aaNW1VzUrKlY7JVIhuiuzdDS+aXdTYi+VicWA55HWMEdqNXxALfQNsdNxhVk" +
       "MGUxSnXCdrc4lwWiSrMxSy2rfRvbYFDRTfBkvIwdgZtMWiw3LXWNSmD0i0Ts" +
       "0XzSgsdJLLcGa7VjzlkbrTrdzrzkCRoqmy0ymPgtuJp6Q13XqIhYLS1ZXEq4" +
       "pc/DwdIct5OlCIyAYeFKpdoT8AlG0rCYGJN4Qc2W84FU0ygjlqdCFJAUhiWu" +
       "oxs1XWBdWl9gSNXsjyUCoZHWJhkvpMYcdTy65Y5R3CZxSU6cWFSwIl5pBAgl" +
       "K6tKvb9m9O7CqQtmtzUdM4pShe32sDclUmleQqlOZx7N1uVyIjXxqdjpCfQY" +
       "79gDC+sGwUjoEZ1av5ym80BP8VZ37hpAgSgC7zO23Ol6Uozw0nrY9u2aZnIh" +
       "n9LtSXXgTNMupAelTdpBkKnkYsVyNVSgWgL0Sl5KXb5jtdlJuS6XR+gmFle0" +
       "0yRSwAxlBfkmDElrSylpVTIolekpjyNUgmE9IekrzUlKMOIY12NJKTcposRU" +
       "Z5opMfHI0oYRX1dE3WAqpGMa4xmptSWWmllEd8TRoWqLHX0uNzW70uGDoirh" +
       "JBENZJL3G51EV6YqZNZnzKiXUCMHFutSimkrpZ9WlvCqhECNWWMuVTiXtZal" +
       "RVqfTErOhqjGesh4Stj1o7BY4QYLriwmlSUUdaJesS4nXXg2Mxlr0TSIerIg" +
       "5ps27o0F0W26xWTpVMx6LESrsmQxXWEY9ixjIGwGw26bQ6daqyduRALXsNCb" +
       "9EetsLtszmK8bevtCZnqk2atDnFS2qwVW1BdgBPMAlq9gKXhBq6gwwA4LtHV" +
       "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" +
       "F32pShi2mjAgYpu22NEIo5czhy8morUi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+aZSrhRrxLKrxGsoGTQwKCbrTNcswtMYRdHX8lSV/3GxV2KP5q/zDtNm7+JF" +
       "3jn/7Nw7XJA+StjK/7JXoicyMI+9Dc17PrHLQAmDwlPnJcnmGUBf+OQbb8rj" +
       "nynt7XJ1mlHhWuT5H7KVtWIfm+oKmOnl89NXyDxH+CiH5Hc++d+eZD6sf+wC" +
       "yYYfOIXz9JQ/T771e90XpX+0V7h8mFFyW/byyUGvnMwjuT9QolWQ51tmNdts" +
       "kqcOOZultRaeBhe+4yx++j3zkUjPfslMbVUibzszFerS/XdoezAr7o0KD2pK" +
       "hJ94SX2oRZeuvNO70+OTZhWX9k7S9yS4iB19xPeevsfv0PZEVjwaFa5G3jbj" +
       "7hRtN74L2q5nle8FF7mjjfze0/bcHdqy2S49FRXujTximxaHHBH29HdB2LNZ" +
       "ZdbO7QjjLkIY2Mx+4EWKFCnyO9J3hxS+S6WseCkqPAR0kwkEN8z+r7P9GOGx" +
       "qPDibenO0WGf/VPdc468/F1wJPtPUJ7b4+844l+EI+9O1K/doe0jWdEAnAWs" +
       "yJPeQmAaXzjfNOZ5qdtE0Df/2fN/8CNvPv9neSLiVSPkhAANtDM+ZDg25ltv" +
       "fe0bf/TQU1/M85/vEYVwa7tOfwFy+wceJ77byCl+8JCHDxyYgjvz0Pf9wpHQ" +
       "mt+t7ckkF+0WjL73QiPv0DbOil5UeCBQBHn3Zc2B9h7LnNpmLB6RTFyE5CQq" +
       "XD+V1p+lKD9x26dE289fpC++ef3q+95k/91WsgefqFwbFq6qK9s+nv947P6K" +
       "HyiqkfPi2jYb0s8JnEeFZ97po4MIeMDDh1xAs+3gH4oKj505OCrck/0c7/tR" +
       "wLDTfYHdy3+P9xPAakf9osKV7c3xLnJUuAy6ZLdKpgWXJsmlk9HLgSAK7+gb" +
       "jgU8z5/Yi/n3XgchxWr7xdct6Utv9kc//O3az2yz8yVb2GyyWa6CbbP9UOAw" +
       "LHn23NkO5rrSe+k7D3/52gsHIdTDW8BHCn0M2wfOzoTHHT/Kc9c3v/6+X3n1" +
       "Z9/8kzxp7/8BgkKPU4g3AAA=");
}
