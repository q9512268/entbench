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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NLe8YfAsvMSGI/8FqnyWHjcYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qPWWCrxtWpsGojkdVIzqum6ZRFQ1x7ToRCWWaNUW/dEaZRvDjCX0Stno45re" +
       "HrUXc1s3hmw6rbZ8wuyDJakzGAcCLY7TxCXCLLZXfFAeC1bdGKgdGq62shrc" +
       "wcyqEc7moqdXKh2P0prerOfz/XZp2o0DvSdxlICU0s46slEty2YdZSuPQ9Jv" +
       "lGfVoUhjmtrpGp3JBqwHq6HXoXv42Ec8s4I0R4tpQ6s0Mr1jBuKWVSxybYFA" +
       "j/ThdrDtOyu4AcvYkihXB+qWYP1x5IlJx68RJacy3oSePekRqaZqekeecEaV" +
       "sCaJuh3RI3OaVHsCM+2xjbCCTWBDhgdEN6vabYIcqVw5KSt6R0PcKeo3mHgw" +
       "jpQVNyJ7xEQbLIz6Yshva146SgLf9ipjbCNUqrGm0o6G11cU0pmK4Zw2mvgq" +
       "KZFzCavTvjN1fLK7RLAu1vaV+iDk1Uq7RSzGpeViXhqXRgaKoBWZjhfU0grh" +
       "dspqWWyS/TjVBH+6qLupZyc9K0IbJQUxLQZTa6g/a7qdZqhGlMAMmUlHyjY0" +
       "VTO6LFOPF2IrzdIUy2phNovKHVuX8bk90tnOZLHquTU9MbfMPI1QK6phTb/i" +
       "qc0OPcVEdhrOMZsFMEdMFri35nwc5aU+22xkK3dkdv1FPTL9UAxqtUXicYME" +
       "VvsjCy0lowGB1FYNVBtkDbQjNsbWPEk6EV7iaDPLauPyEB50XBtG4OXAxwiJ" +
       "HkttuG/gJCxoSCyW+xSC9Hr2oltrxdgwGI6rQoWZeW7ILxEXb6CJvmaNWc3P" +
       "IoJrl9dIWjObLmKUYytbhZZpECLbdJqNbWsqb7aEUG/Nkt7aJb0o0lOY0BZN" +
       "X7YCJSZKo1aX1WK7O2+CIMs6/bBpVVGd2pS3dJw0mM16OCX63YHTNlkkrpqb" +
       "CFYs3vBEvkQM54HOesy6h7tBsDCIngig066YJu7MK8qyq9PMJGFaCVJZhaXM" +
       "qGvKLJw2132JWveXi5hNqlZ9WmWkwIhJ3MJ7mUT0rchzvApYxKcY1ZnVKFiY" +
       "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" +
       "Bklxo7T9g/s+//rffu6bRa70fwAHkpehJyMAAA==");
}
