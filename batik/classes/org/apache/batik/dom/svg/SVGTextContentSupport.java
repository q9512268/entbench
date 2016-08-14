package org.apache.batik.dom.svg;
public class SVGTextContentSupport {
    public static int getNumberOfChars(org.w3c.dom.Element elt) { final org.apache.batik.dom.svg.SVGOMElement svgelt =
                                                                    (org.apache.batik.dom.svg.SVGOMElement)
                                                                      elt;
                                                                  return ((org.apache.batik.dom.svg.SVGTextContent)
                                                                            svgelt.
                                                                            getSVGContext(
                                                                              )).
                                                                    getNumberOfChars(
                                                                      );
    }
    public static org.w3c.dom.svg.SVGRect getExtentOfChar(org.w3c.dom.Element elt,
                                                          final int charnum) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.w3c.dom.svg.SVGRect(
          ) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public void setX(float x)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
            public void setY(float y)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getWidth() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getWidth(
                           );
            }
            public void setWidth(float width)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
            public float getHeight() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getExtent(
                           svgelt,
                           context,
                           charnum).
                         getHeight(
                           );
            }
            public void setHeight(float height)
                  throws org.w3c.dom.DOMException {
                throw svgelt.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.rect",
                    null);
            }
        };
    }
    protected static java.awt.geom.Rectangle2D getExtent(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                         org.apache.batik.dom.svg.SVGTextContent context,
                                                         int charnum) {
        java.awt.geom.Rectangle2D r2d =
          context.
          getExtentOfChar(
            charnum);
        if (r2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return r2d;
    }
    public static org.w3c.dom.svg.SVGPoint getStartPositionOfChar(org.w3c.dom.Element elt,
                                                                  final int charnum)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.apache.batik.dom.svg.SVGTextContentSupport.SVGTextPoint(
          svgelt) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getStartPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getStartPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
        };
    }
    protected static java.awt.geom.Point2D getStartPos(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                       org.apache.batik.dom.svg.SVGTextContent context,
                                                       int charnum) {
        java.awt.geom.Point2D p2d =
          context.
          getStartPositionOfChar(
            charnum);
        if (p2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return p2d;
    }
    public static org.w3c.dom.svg.SVGPoint getEndPositionOfChar(org.w3c.dom.Element elt,
                                                                final int charnum)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return new org.apache.batik.dom.svg.SVGTextContentSupport.SVGTextPoint(
          svgelt) {
            public float getX() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getEndPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getX(
                           );
            }
            public float getY() {
                return (float)
                         org.apache.batik.dom.svg.SVGTextContentSupport.
                         getEndPos(
                           this.
                             svgelt,
                           context,
                           charnum).
                         getY(
                           );
            }
        };
    }
    protected static java.awt.geom.Point2D getEndPos(org.apache.batik.dom.svg.SVGOMElement svgelt,
                                                     org.apache.batik.dom.svg.SVGTextContent context,
                                                     int charnum) {
        java.awt.geom.Point2D p2d =
          context.
          getEndPositionOfChar(
            charnum);
        if (p2d ==
              null)
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        return p2d;
    }
    public static void selectSubString(org.w3c.dom.Element elt,
                                       int charnum,
                                       int nchars) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        context.
          selectSubString(
            charnum,
            nchars);
    }
    public static float getRotationOfChar(org.w3c.dom.Element elt,
                                          final int charnum) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getRotationOfChar(
            charnum);
    }
    public static float getComputedTextLength(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getComputedTextLength(
            );
    }
    public static float getSubStringLength(org.w3c.dom.Element elt,
                                           int charnum,
                                           int nchars) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        if (charnum <
              0 ||
              charnum >=
              getNumberOfChars(
                elt)) {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  INDEX_SIZE_ERR,
                "",
                null);
        }
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getSubStringLength(
            charnum,
            nchars);
    }
    public static int getCharNumAtPosition(org.w3c.dom.Element elt,
                                           final float x,
                                           final float y)
          throws org.w3c.dom.DOMException {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        final org.apache.batik.dom.svg.SVGTextContent context =
          (org.apache.batik.dom.svg.SVGTextContent)
            svgelt.
            getSVGContext(
              );
        return context.
          getCharNumAtPosition(
            x,
            y);
    }
    public static class SVGTextPoint extends org.apache.batik.dom.svg.SVGOMPoint {
        org.apache.batik.dom.svg.SVGOMElement
          svgelt;
        SVGTextPoint(org.apache.batik.dom.svg.SVGOMElement elem) {
            super(
              );
            svgelt =
              elem;
        }
        public void setX(float x) throws org.w3c.dom.DOMException {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  NO_MODIFICATION_ALLOWED_ERR,
                "readonly.point",
                null);
        }
        public void setY(float y) throws org.w3c.dom.DOMException {
            throw svgelt.
              createDOMException(
                org.w3c.dom.DOMException.
                  NO_MODIFICATION_ALLOWED_ERR,
                "readonly.point",
                null);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "kcV3v8CnbLj4H+nY3vPpGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9x8JIwAA");
    }
    public SVGTextContentSupport() { super(
                                       );
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
       "215Y3NfKfvltv/jdP/PyHxR3Rv4ft8iT4IEuAAA=");
}
