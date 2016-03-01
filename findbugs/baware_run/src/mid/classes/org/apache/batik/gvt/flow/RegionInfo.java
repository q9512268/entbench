package org.apache.batik.gvt.flow;
public class RegionInfo {
    private java.awt.Shape shape;
    private float verticalAlignment;
    public RegionInfo(java.awt.Shape s, float verticalAlignment) { super(
                                                                     );
                                                                   this.shape =
                                                                     s;
                                                                   this.verticalAlignment =
                                                                     verticalAlignment;
    }
    public java.awt.Shape getShape() { return shape; }
    public void setShape(java.awt.Shape s) { this.shape =
                                               s; }
    public float getVerticalAlignment() { return verticalAlignment;
    }
    public void setVerticalAlignment(float verticalAlignment) {
        this.
          verticalAlignment =
          verticalAlignment;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vMc1r+s8Tn/Nlr7/AFLrThhJGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ife2t29nyvocSC7mUKErwG9n2N35r9PXD65WtoE75Lu7/1OwZ0/+w39cMQg5" +
       "TV8l3k60nyIvfOwe8q3fy9sf8mXW+t7kylUMbHYP2xY/tfy3nQfP/NkOdHYK" +
       "XVT2dtJD2Y4yFpqC3WOwv70Gu+1j9cd3gtttz+MH68HrTgb8kW5PMvVhoIF8" +
       "Jp3lz58g52zrAd0Nnkf2eOuRk+R8CsoznbzJA3l6KUt+dp8Lz3q+GYP5kmsu" +
       "g5AOMiLIfhS2xJ6lb80SdutN4pqebx236xJ44D274GvYJV7Driwr7Jt0WwwW" +
       "OlORbcIG7whLzckptXTCvMHLmperS04B0KeLu5XdHN/06gbckGXfAFaKIH+R" +
       "yWa66cj2vkV3LWzl0j7lDMGLDYjMSwu7sk+rF/NJlcXA7vZt4ISt5f+zrWDS" +
       "3HqojHXBi8X7//GDX//AQ98Gkc1Ap+Ms6kBAH+mRj7J3rV994dnXv+qZ77w/" +
       "X/jAiHY/3Lz49kyrdj3EWfKOLLm8D/WeDKqY7xhZOQi5fK3S1AO0xSN4qiFY" +
       "8dyfAG14yw9oPGgT+x+2MJGLaynBnGjGVHWquyYWtDXlCJnpwyWyWfJ6Fl5P" +
       "FDq1FmS12JM9TwnSMFULYUUoRBHWLeKTnmjV3V43IXiLJ0ZWx+2FUrMn8UFh" +
       "KIe91aIs8s1Cn6dWA5echlWT95rlwdrFWnJxNdNTIVW7UbkudUK56Dto2lVr" +
       "1UpB1+CJvFo0ebRjL/gJ1VA7qpBSpBRLWjKZMk0fZ3gl6QbJqtfQ03JVgxms" +
       "No6rnQZJeisxEcS6YSEDpt9cTtpFM/IZV1ol7YRPOuKkbvTnpUWT4oYSGvb6" +
       "fKtQXCe2aomjaWM5Z9ZzojjZCORoQdqGkXYlo1MkW0SBrXZK5LgV9RaoNhfw" +
       "tuz1Crqs8RwXtQpCgE8qxBROywM3mrX5xabTQ61Vp0y1ZzwbOW1qVJ6uNlx5" +
       "6PJNY8OzBj8aWd7E4q3ptCkLQRXTx/5CYlfTVbG5GtojXjFovj1iVhvTYPot" +
       "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" +
       "/wXOBSHBKiUAAA==");
}
