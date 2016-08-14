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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "oCfzoyUabiN/xbem/wJPFEFa+SIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6ZbdFRodtsq6SYhn+oKBmppRo9sYhGKmSQ09jZXETte2OHjS3FVRs24oodU0" +
       "iWAR7uoTGqfCncm2bC+SErwxZHMqJZuxuhA9De6jPXYySSUnRBOtPnJ43YdA" +
       "RCQJpNrwegodcfbO42fcIt1ZHazXzLRFHsEu3qFmeD3b1k17l+M7V8gDJENS" +
       "n9Bzf8dLsjmBt7LmwtlwRvZICWKLrYsPfrDYzvjEne0oPVRunh3fV7Cc8pBl" +
       "cwc7KfuqZ4rkueN9x/J3uXLujPvUvuOpE40LRxt13/c2DpyKk+BiN+mJW11b" +
       "KHeSPvfRV15Vp5+vXTw8OfqJpHJf4gcfcLSN5pwa+jKg9MKtd83G5a2NkxON" +
       "3/jof3+c+5DxkTs4H37qHJ/nSf7c+LUv9r9X+RsXK5eOzzfedJ/kbKcXz55q" +
       "XIm0JI087szZxhPHM/FwofinwDM6nInR+R3gk7m++fbv9+9t5TYHcz99m7rP" +
       "F8mrSeWBtXY4fZND3jcn9vV332qn7jTVsuDvHAv4aFFYHAZwhwJy77yAr9+m" +
       "7peK5AtJ5f5CwNPnGyfi/b3vQrxHisInwCMdiie9M+JdLBtcLN9fPuXjP16c" +
       "Xjm+dHJ4+7bOnMoxfvU2avrnRfIPk8oVVYvMjVZo6miEZ97S709U+SvvhCqt" +
       "Q1Va76gqi9d/cmaj+yygMFJWotQN5R/Pv/qlz+avv7bfx5alWEsq0K3u6b35" +
       "qmBxLeS521xtObnB9Sf9v/DGH/3B4oeOcPD+Y128UIj+gdvp4mh2Hjg52R5L" +
       "Zd2XS1q/c5vJ/t0i+eKZyS5Kfv1kHv/1dzuP7wVPfsh7/s57/H+6Td0fFMl/" +
       "BEtKcYB9ciB2zovukfdHYicy/953IfPjRWFxHvvyocwv34HMpWnuF/+3MuDy" +
       "8LNRtvrGbVTwP4rka6dVUBT81xNZ//hOZN0CKztz16u4uPLYm66P7q88Kr/w" +
       "6tV7H32V/93yutPxtcT76Mq9euo4p8/7T+UvB5GmmyWX9+1P/4Py738llUdv" +
       "cTslqVzeZ0p+v7Vv/2dJ5dr59gAxy//T");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7b4DjP+kHSC1z5xqcuFiUrkEmhTZS8FNDiv31x62F07FK4dmUWr44bfS8HGX" +
       "07ehCrQor+8exSPp7BCUXn91OPmRb7Y+v7+NpThSnhdU7qUr9+wvhh3HNM/c" +
       "ktoRrcuD57/94C/e99wR7jy4Z/jERE/x9tTNrz713CApLyvl/+jRf/ADP/Pq" +
       "75dnp/8Pk6YYqVctAAA=");
}
