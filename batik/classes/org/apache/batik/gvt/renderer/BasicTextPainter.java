package org.apache.batik.gvt.renderer;
public abstract class BasicTextPainter implements org.apache.batik.gvt.TextPainter {
    private static org.apache.batik.gvt.text.TextLayoutFactory textLayoutFactory =
      new org.apache.batik.gvt.text.ConcreteTextLayoutFactory(
      );
    protected java.awt.font.FontRenderContext fontRenderContext =
      new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      true,
      true);
    protected java.awt.font.FontRenderContext aaOffFontRenderContext =
      new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      false,
      true);
    protected org.apache.batik.gvt.text.TextLayoutFactory getTextLayoutFactory() {
        return textLayoutFactory;
    }
    public org.apache.batik.gvt.text.Mark selectAt(double x,
                                                   double y,
                                                   org.apache.batik.gvt.TextNode node) {
        return hitTest(
                 x,
                 y,
                 node);
    }
    public org.apache.batik.gvt.text.Mark selectTo(double x,
                                                   double y,
                                                   org.apache.batik.gvt.text.Mark beginMark) {
        if (beginMark ==
              null) {
            return null;
        }
        else {
            return hitTest(
                     x,
                     y,
                     beginMark.
                       getTextNode(
                         ));
        }
    }
    public java.awt.geom.Rectangle2D getGeometryBounds(org.apache.batik.gvt.TextNode node) {
        return getOutline(
                 node).
          getBounds2D(
            );
    }
    protected abstract org.apache.batik.gvt.text.Mark hitTest(double x,
                                                              double y,
                                                              org.apache.batik.gvt.TextNode node);
    protected static class BasicMark implements org.apache.batik.gvt.text.Mark {
        private org.apache.batik.gvt.TextNode
          node;
        private org.apache.batik.gvt.text.TextHit
          hit;
        protected BasicMark(org.apache.batik.gvt.TextNode node,
                            org.apache.batik.gvt.text.TextHit hit) {
            super(
              );
            this.
              hit =
              hit;
            this.
              node =
              node;
        }
        public org.apache.batik.gvt.text.TextHit getHit() {
            return hit;
        }
        public org.apache.batik.gvt.TextNode getTextNode() {
            return node;
        }
        public int getCharIndex() { return hit.
                                      getCharIndex(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "3D8WXWwu/Qdu1jAvthoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "JQAA");
    }
    public BasicTextPainter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "91Ld0xPqx2997D7QEu9Mhz/4xdChcKxD4Yuqw0pRp8mPVKSfvI0yfqZMfuJU" +
       "GdPqIcGPnIn6whcg6sNlYXl5oh6Lqn5xRL10RvBDFcEv3UbAXymTnwfQDGKj" +
       "Z0WBBdZPRJSHZnpi9i89vZhYgvqjMVCDFi59C6XO1PALX4AaXl8Wvgl82rEa" +
       "tFeghgr4pTJ5z//d7Aet/M5ttPKpMvn1DLrbcQFiHG59z1n9N16JuEUGXbv4" +
       "TKK8533kJY+yDg+JjJ96/uo9Dz8v/0n1UuD0sc+9AnSPnfv++Wu5c/krcWLZ" +
       "bsX8vYdLurj694e3woOTJxzAt0+yFet/cGj3xwAub9Yug+4A6XnKPwPyXaTM" +
       "oLuq/+fp/iKD7jujA9B1yJwn+TToHZCU2c/EN7m9OdxnFpfOTZ/H7lSZ5cGX" +
       "M8tpk/NPD0r8qp7RnUyP+eEh3TPGJ57nxa//HPbDh6cPhq/t92Uv9wjQ3YdX" +
       "GKdT7Btu2dtJX1fYpz5//yfvffPJcuD+A8Nnrn2Otydu/raADuKseg2w/4WH" +
       "f/Yrf/T5v6ouk/4X4vSU798oAAA=");
}
