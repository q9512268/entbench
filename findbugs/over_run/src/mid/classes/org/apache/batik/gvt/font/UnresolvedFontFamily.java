package org.apache.batik.gvt.font;
public class UnresolvedFontFamily implements org.apache.batik.gvt.font.GVTFontFamily {
    protected org.apache.batik.gvt.font.GVTFontFace fontFace;
    public UnresolvedFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace) {
        super(
          );
        this.
          fontFace =
          fontFace;
    }
    public UnresolvedFontFamily(java.lang.String familyName) { this(
                                                                 new org.apache.batik.gvt.font.GVTFontFace(
                                                                   familyName));
    }
    public org.apache.batik.gvt.font.GVTFontFace getFontFace() {
        return fontFace;
    }
    public java.lang.String getFamilyName() { return fontFace.
                                                getFamilyName(
                                                  ); }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.text.AttributedCharacterIterator aci) {
        return null;
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.util.Map attrs) {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a94wuMe+y9HivwEAcm3IHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "K/69y3LlSn0VfvMXnun90B9X9c+JsKz93O7OiQqscc/rIr/s/+nRi9d/8wh6" +
       "WIVu6ScLaEXzNiW9qGDRmJ6uqsEi+1L55QXgYbXzyhnRv+cqCV/o9ioFn0+Q" +
       "4L6ULu9vXGHdJ0orvw9cL5yg4YWrQLoGVTfcAUtVertMvu+U5B6NkjADozSN" +
       "E577c/C7Bq7/U15lc2XGYTXzVO9kSfXeszVVBGbvR6wTAijr18+hW+GF/1Z4" +
       "octE2l0DY3kIOcaPqwbmdx/vA+Xt9wNmTqvXClDDsgPNq6wiZSDuPf326RgV" +
       "8JoBAHPb8fCymLgyLunbHhfA7RPnYcOEYEn/M//5k7/zN9/3VQCuEfRQXjoe" +
       "YOpCbHGb8i3np9781LOPvf61n6kmFWBs4dPkrQ+VrWr3065MfrhMPnyq1jOl" +
       "WlK1QmO0NGOrecA0Ss3uH1NCYvtgusxPlvDwa0991f2FP/yVw/L8agBdETY/" +
       "/vpP//nxJ14/uvBS9L473ksu1jm8GFWDfvzEwgn0wv16qWpQ/+Xzr/3a33/t" +
       "Y4dRPXV5iU+CN9hf+df/+3eOP/O1377LuvFBD3jjL+zY7ObTw2ZKE6c/pqFa" +
       "KjHdifMclXNE2PSa/T3u1ZpYn6iNNr0xE5Imt9OzfXfobZv8iHY26Z7rZE1u" +
       "zzZZFm+gZl2fpNPYG5Oculot5FChB45GTRJqEpJFfTRyqJjUpitlMxqGrlyb" +
       "0ty0EDutQTRedPAoMHw1ELA+qccb38CXeG5itaQD47lh5H2sHYRFIXNdW6Ii" +
       "q7dk7ZWSrGR0n3r1FrOjvFmRMPPJAONQeI4KnYiEFXNLux4hDIw0n4lIoXLU" +
       "bK1Fu7hpsMpeYiQ1YhNlNt1FA6femsy4ie5Gm7XWx/zVjG+MJg3FXc/nob4I" +
       "SVSl1dFyKi1aS8lHxnVUbRGu6ol5lNJoHXGRKTyheoqjcvWFvvZ9tT+om6w2" +
       "AcGwUfeURHbqbn9qixQlTCVK2s0oQRtR+nLjJNOoFqYyx6Y56RlqL7PFuSg6" +
       "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" +
       "dVLZl3RDjzs7esjV5dTiQmGUO/tQFgPBk8kFBlNYRqZOe2YGuMPXOAfWh5St" +
       "DouauUZNobBALLGrOEMLd2vGRaEbM0Gfzx1hrIzl4YQWR2AtpZj14TanddYt" +
       "FlMmdRe6Ut/WOCMfLH2b5ontNIq2bV7FJla7h/dXliCxXn0YRvMmw8SjtkSM" +
       "GrBZ8/gViRm8q/aaqcK07YTt23LTzBha77AK14rq2xGXIHt9bAFgMMF0OxDV" +
       "vD3xMyeHh81Wl44zFsFtdqjEe83cDAArzndSQ/Oas4GuyhJJeQOgmcx1Jkqg" +
       "1xbjTEc6vKBFtuPzsKGN+8vNiu8ozgrrd7uTou5Ifq2I+orfcyf5nNoWS2pu" +
       "hCq/qhkZTQxG7pxc6puaqUksRTDbtW/X6G2M9KgWoo3TzkYQgshvkq35prfd" +
       "1lrsYr3dmXptlwEPrPOBQ4+9cNRiVxFY5OU7x2JjKQutMeGLM3mCN1pSmgOq" +
       "mMz64I3BXgGzj9FJ7G5zym2rmu5wPEozRTSLBdfhItnGhya/X67DaAv3eD1F" +
       "N+SWssLhbsRw0XowXPYoK2a1TnO7Yc1a0Rna+ZYkdB+lhxOi2ixJvrNdiier" +
       "zZezU9K/wLbL7m4bntXvOnTlZO3qhufTl7c5v+/b2K8uD5LKHYpn73VYWu1O" +
       "fO6jr79h8L/YODrZDvUz6NEsjD7gmbnpXdndfPneOzFsdVZ8vsX4Wx/9r8/I" +
       "P7T+yHdwvPT8lXFebfKX2Dd/e/C9+s8eQQ+cbTjecYp9udIrl7cZbyRmtkkC" +
       "+dJm47Nnnnh3afgXwdU+8UT7PrvWd+w0Vqg5YOU+u80/fZ+yv1EmP5lBj63M" +
       "jLq443iOrp/6Tjanq4yPnqn31Cm4iBP1iO++ep++T9lnyuRvZdDjpXoVOrkT" +
       "1xDnCv7s/4OCby8znwUXe6Ig+91R8OjkkLV8Xl+Ica/cnvVCLTs7Rao2SMsP" +
       "QY6JLEvs5SYzjd4aoFzPzITOzOoorurj79zHUL9UJp/NoBuGmdi5WULhtIcX" +
       "vmXcn5vyje+GKWcnppx9V01ZPv7dS5unlwlF1LYVS72q/7PJ177y2f3n3zzs" +
       "jS611Myg2r2+DrrzA6XyVPml+5yMn3838qeDH3zrj/6T8uFTHnzszBYvl6p/" +
       "4H62OPXO4+dHbKxWlf1a1dYX7+Ps3yiTL1xydpnzD879+A+/owOpDHrH3b4o" +
       "KI9Hn77j26bD9zj6r75x85F3vzH9N9Wh+tk3M48y0CPWxvMuntNcuL8eJaZl" +
       "Vzo8eji1iaq/38yg77knSjPoQesUpP/yIP8lMOK7yWfQAyC9KPnlDLp1VRKE" +
       "YPV/Ue53gTXP5TLo+uHmoshXQOtApLz9veguZ4eHg63dtQsT4EmMVC556lu5" +
       "5KzKxdP5En7VV2inE9xGOEH5598YcT/6jdYvHr4O0D1tvy9beYSBHj58qHA2" +
       "Sb5wz9ZO27o+fP83n/jCoy+dAvmJw4DP4/XC2J6/+1E86UdZdXi+/6fv/scf" +
       "/Htv/EF1wPN/AVmAoMkeKAAA");
}
