package org.apache.batik.css.engine;
public class FontFaceRule implements org.apache.batik.css.engine.Rule {
    public static final short TYPE = (short) 3;
    org.apache.batik.css.engine.StyleMap sm;
    org.apache.batik.util.ParsedURL purl;
    public FontFaceRule(org.apache.batik.css.engine.StyleMap sm, org.apache.batik.util.ParsedURL purl) {
        super(
          );
        this.
          sm =
          sm;
        this.
          purl =
          purl;
    }
    public short getType() { return TYPE; }
    public org.apache.batik.util.ParsedURL getURL() { return purl;
    }
    public org.apache.batik.css.engine.StyleMap getStyleMap() { return sm;
    }
    public java.lang.String toString(org.apache.batik.css.engine.CSSEngine eng) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            "@font-face { ");
        sb.
          append(
            sm.
              toString(
                eng));
        sb.
          append(
            " }\n");
        return sb.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TQUeO8DFVx3HrCPTHkesw50E1DPqrH7uGEjdlVk5M/jFvfV78ThI5dvK+dzH" +
       "mUi7guEGkdGt3lp64ps8MI4AnUoywYFNLhxS9eIshf3V556554anv/OuHEOg" +
       "6zKGRD71A3l5MStek/s273stAJgwz4UjoIrpSPYe0PwYfE6A53+yJxMwa9gm" +
       "D7cQexnM/QcpjAc2zpPDGUdeO164wFwC5Ez2cjfkyVu+bX3gux/b5mXHg+MY" +
       "sfrOp3/tx7tPPb1zJBt+9RUJ6dEx24w4t/4rsoLNltsD15olH0H90yee/Ozv" +
       "P/mOrVS3XJ7bkeDV5WN//d9f3X3/d758leThVJi5arvJZGUlK5pbk+Ivuvre" +
       "eDm2Z10P78XGw1fEBpRXZlf36Ra62AiA5jKrocdEEV+mKLeC5zV7orzmRUR5" +
       "4iVEOenFQZ7NF48JI72kMFuvnQC74KnibnU310a/VjRnBZMVnf3Z71zY8sX9" +
       "gB2DVzyARxcXdnV/nziygLbvRceEZP/PQoLguumQGeuCV6x3/eN7vvruV38b" +
       "BAqzv2Qzagps7Nz7yAtvyn54L0+fuzN9hDw5ZqUw6ubbsaocqNQ/IrQAjG+7" +
       "P4FK0U1vpUthu77/YVFRKq5Ga8yJEbpSnxaJanlJroxwQFZ9ogHgftQwy8Uu" +
       "k643A3E0ZJIUiyryvEglCr5Uwhre7wxITydNarQgRlFIIhO/XTTJ+qg38ccd" +
       "RnAlgeqMVkJvqQ9HTKsAM60iQdEldGglc5yJRUyJ8WSgbtrRVFiEcoqlmgan" +
       "9EKuKgNTai16VmHguh1u0XJmtfbU5Yih23BLLbFLrqKQ8SfNdGPDXNVLyrNQ" +
       "gVlB1/iUNXS87RP6PLRZUu0Nhjw30ldmh2gXo2Vd9njdoPloRq9bbY/wmxIr" +
       "WjgxQCd820b9qNUdTGdsbDTGhDxwrZhnuiRe1kkyGszEHlZtLaYw3qrUU7Pj" +
       "UWM+TsmxuyHrnT438Odh3xIbvVFLWVkLfYEzTM/S7HoqLBWW10TXX6wwtpPQ" +
       "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" +
       "/PhHnv1Wfmv1vzrHK1vQJgAA");
}
