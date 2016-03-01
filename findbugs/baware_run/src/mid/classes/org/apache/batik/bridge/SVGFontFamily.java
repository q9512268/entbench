package org.apache.batik.bridge;
public class SVGFontFamily implements org.apache.batik.gvt.font.GVTFontFamily {
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    protected org.apache.batik.gvt.font.GVTFontFace fontFace;
    protected org.w3c.dom.Element fontElement;
    protected org.apache.batik.bridge.BridgeContext ctx;
    protected java.lang.Boolean complex = null;
    public SVGFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace,
                         org.w3c.dom.Element fontElement,
                         org.apache.batik.bridge.BridgeContext ctx) {
        super(
          );
        this.
          fontFace =
          fontFace;
        this.
          fontElement =
          fontElement;
        this.
          ctx =
          ctx;
    }
    public java.lang.String getFamilyName() { return fontFace.getFamilyName(
                                                                );
    }
    public org.apache.batik.gvt.font.GVTFontFace getFontFace() { return fontFace;
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.text.AttributedCharacterIterator aci) {
        return deriveFont(
                 size,
                 aci.
                   getAttributes(
                     ));
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.util.Map attrs) {
        org.apache.batik.bridge.SVGFontElementBridge fontBridge;
        fontBridge =
          (org.apache.batik.bridge.SVGFontElementBridge)
            ctx.
            getBridge(
              fontElement);
        java.lang.ref.SoftReference sr =
          (java.lang.ref.SoftReference)
            attrs.
            get(
              TEXT_COMPOUND_ID);
        org.w3c.dom.Element textElement =
          (org.w3c.dom.Element)
            sr.
            get(
              );
        return fontBridge.
          createFont(
            ctx,
            fontElement,
            textElement,
            size,
            fontFace);
    }
    public boolean isComplex() { if (complex != null)
                                     return complex.
                                       booleanValue(
                                         );
                                 boolean ret = isComplex(
                                                 fontElement,
                                                 ctx);
                                 complex = ret ? java.lang.Boolean.
                                                   TRUE
                                             : java.lang.Boolean.
                                                 FALSE;
                                 return ret; }
    public static boolean isComplex(org.w3c.dom.Element fontElement,
                                    org.apache.batik.bridge.BridgeContext ctx) {
        org.w3c.dom.NodeList glyphElements =
          fontElement.
          getElementsByTagNameNS(
            org.apache.batik.util.SVGConstants.
              SVG_NAMESPACE_URI,
            org.apache.batik.util.SVGConstants.
              SVG_GLYPH_TAG);
        int numGlyphs =
          glyphElements.
          getLength(
            );
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            org.w3c.dom.Element glyph =
              (org.w3c.dom.Element)
                glyphElements.
                item(
                  i);
            org.w3c.dom.Node child =
              glyph.
              getFirstChild(
                );
            for (;
                 child !=
                   null;
                 child =
                   child.
                     getNextSibling(
                       )) {
                if (child.
                      getNodeType(
                        ) !=
                      org.w3c.dom.Node.
                        ELEMENT_NODE)
                    continue;
                org.w3c.dom.Element e =
                  (org.w3c.dom.Element)
                    child;
                org.apache.batik.bridge.Bridge b =
                  ctx.
                  getBridge(
                    e);
                if (b !=
                      null &&
                      b instanceof org.apache.batik.bridge.GraphicsNodeBridge) {
                    return true;
                }
            }
        }
        return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "w87CfR9zyxsGBqDvXA5t/wdTpe5XNiIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BheyaLBeIxzjSfO6TY0HmJtMxUwTlXgCz/rWMidCsTMl2n5rCY3tNtEeKhmv" +
       "qukS38CDdnW46BPKJmqOp2i3rTRlvzqJYJHrxQB2qaZtLpltjoxoI2l0elLW" +
       "xnWynkfMFkO7xrSd77KIwje9dNFpxmABEQK9uWDN4gjigx8sjiU+cWcnQw+V" +
       "h2DHbxIsp7wsSe/gRGRf9EwRPXd8flj+LlfO3WOfOj88dTNx4ejA7fvexsVR" +
       "caNbnAo9caunCeWJ0Oc/+sqrGvcF+OLhDdBPxpV7Yz/4gKOnunNq6Mugpxdu" +
       "ffrFlC8zTm4mfvWj//1x4UPrj9zBPe9T5+g83+XfZV77EvW96k9frFw6vqd4" +
       "05uRs41ePHs7cR8w7ST0hDN3FE8cz8TDheCfAmF0OBOj8ye5J3N982Pc79/r" +
       "ym0u2P7Wbcq+UESvxpUHVvrh9LGHtKcn+vU33+rE7XSvZcbfOGbw0SKzONQX" +
       "DhkU3nkGX79N2d8voi/GlfsLBk/fU5yw9/e+C/YeKTKfAEE+ZE9+Z9i7WFa4" +
       "WH6/fMrGf6K4hXJ8+eQS9m3dHZVj/PJtxPQviugfxZX7ND00U72Q1NEIz7yl" +
       "3Z+I8pfeCVFah6K03lFRFp//9MyB9VlAmcrbEqVuqP9k8rUvfy5//bX9ebQi" +
       "R3pcqd7qLd6bnwMWzzueu80TlZNXWn9M/YU3/vD3xR8+wsH7j2XxQsH6B24n" +
       "i6PZeeDkhpqRy7KvlH395m0m+7eK6EtnJrvI+Vcn8/hvv9t5fC8I+SHt+Ttv" +
       "8b93m7LfL6LfBktKcRF9crF1zoruUfZXWyc8/853wfPjRWZxr/ryIc8v3wHP" +
       "pWruF/+3UuDyErNR1vrmbUTwP4ro66dFUGT81xNe/+hOeM2Alp15s1U8QHns" +
       "TU9E988a1Z9/9eqVR1+d/Vb5bOn46eG9dOWKkTjO6Xv7U+nLQagbZknlvftb" +
       "/KD8+19x5dFbvDKJK5f3iZLeP93X/7O4cu18fYCY5f/pet8Byn9SD3S1T5yq" +
       "cuFiXLkEqhTJS8FNLh33zxeyC6f8lUO1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("KCX88FtJ+LjJ6VdNBVqUT3SP/JFkfAhKr786ZH/0W60v7F9VqY6c50UvV+jK" +
       "PfsHXsc+zTO37O2or8v957/94C/c+9wR7jy4J/hERU/R9tTNnzARbhCXj47y" +
       "f/zoP/yBv/3q75Z3oP8P/WoisTstAAA=");
}
