package org.apache.batik.extension.svg;
public class RegionInfo extends java.awt.geom.Rectangle2D.Float {
    private float verticalAlignment = 0.0F;
    public RegionInfo(float x, float y, float w, float h, float verticalAlignment) {
        super(
          x,
          y,
          w,
          h);
        this.
          verticalAlignment =
          verticalAlignment;
    }
    public float getVerticalAlignment() { return verticalAlignment;
    }
    public void setVerticalAlignment(float verticalAlignment) { this.
                                                                  verticalAlignment =
                                                                  verticalAlignment;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FU36+/f97ht/84Vv5YnD/wZmCmZWdSIAAA==");
}
