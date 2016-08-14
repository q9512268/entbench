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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jTzh+N8YM0W6kSIAAA==");
}
