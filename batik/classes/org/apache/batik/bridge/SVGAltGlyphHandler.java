package org.apache.batik.bridge;
public class SVGAltGlyphHandler implements org.apache.batik.gvt.font.AltGlyphHandler, org.apache.batik.util.SVGConstants {
    private org.apache.batik.bridge.BridgeContext ctx;
    private org.w3c.dom.Element textElement;
    public SVGAltGlyphHandler(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element textElement) {
        super(
          );
        this.
          ctx =
          ctx;
        this.
          textElement =
          textElement;
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      float fontSize,
                                                                      java.text.AttributedCharacterIterator aci) {
        try {
            if (SVG_NAMESPACE_URI.
                  equals(
                    textElement.
                      getNamespaceURI(
                        )) &&
                  SVG_ALT_GLYPH_TAG.
                  equals(
                    textElement.
                      getLocalName(
                        ))) {
                org.apache.batik.bridge.SVGAltGlyphElementBridge altGlyphBridge =
                  (org.apache.batik.bridge.SVGAltGlyphElementBridge)
                    ctx.
                    getBridge(
                      textElement);
                org.apache.batik.gvt.font.Glyph[] glyphArray =
                  altGlyphBridge.
                  createAltGlyphArray(
                    ctx,
                    textElement,
                    fontSize,
                    aci);
                if (glyphArray !=
                      null) {
                    return new org.apache.batik.gvt.font.SVGGVTGlyphVector(
                      null,
                      glyphArray,
                      frc);
                }
            }
        }
        catch (java.lang.SecurityException e) {
            ctx.
              getUserAgent(
                ).
              displayError(
                e);
            throw e;
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IBzySc59iT+y4fL/AOyX3oLGGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tf3De3//9b/17NeLOuv/AOLo3ENHIwAA");
}
