package org.apache.batik.gvt.font;
public class GVTGlyphMetrics {
    private java.awt.font.GlyphMetrics gm;
    private float verticalAdvance;
    public GVTGlyphMetrics(java.awt.font.GlyphMetrics gm, float verticalAdvance) {
        super(
          );
        this.
          gm =
          gm;
        this.
          verticalAdvance =
          verticalAdvance;
    }
    public GVTGlyphMetrics(float horizontalAdvance, float verticalAdvance,
                           java.awt.geom.Rectangle2D bounds,
                           byte glyphType) { super();
                                             this.gm = new java.awt.font.GlyphMetrics(
                                                         horizontalAdvance,
                                                         bounds,
                                                         glyphType);
                                             this.verticalAdvance =
                                               verticalAdvance;
    }
    public float getHorizontalAdvance() { return gm.getAdvance(
                                                      ); }
    public float getVerticalAdvance() { return verticalAdvance;
    }
    public java.awt.geom.Rectangle2D getBounds2D() { return gm.
                                                       getBounds2D(
                                                         );
    }
    public float getLSB() { return gm.getLSB(); }
    public float getRSB() { return gm.getRSB(); }
    public int getType() { return gm.getType(); }
    public boolean isCombining() { return gm.isCombining(
                                               ); }
    public boolean isComponent() { return gm.isComponent(
                                               ); }
    public boolean isLigature() { return gm.isLigature();
    }
    public boolean isStandard() { return gm.isStandard();
    }
    public boolean isWhitespace() { return gm.isWhitespace(
                                                ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5sHy5wo03H7+im8D/wN7Z0XAEiQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
