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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m88tbxg84S+zwfoffBMtcUgYAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "RbIq7SIAAA==");
    }
    public SVGTextContentSupport() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "z2PMA9g/cRuwP5Yn/wh0+xTsk3beXuwey0l0vNBBAznCsruw9Sp2APof3wHQ" +
       "35FnVvLPe6CTbznrPnF7m71+llhgouqlqu7nTq0o/C/z5J9HpUcBUmwkB9HJ" +
       "zYDz7Lx+E3aOvXO2+i/uALXH88zvAs+P71H78TeK2odfl5f5z5/Mk48coPv5" +
       "23DoF/Pk01HpwTPInMDx1vMsKpA4y6DP3CmD8u8f32Px8W85g/7dzRmU//yZ" +
       "QuDf58nnotJbcntytfMcyb998qD7r9wpD/K57LN73T/77eHBb96GB7+VJ1/Y" +
       "+5JC9zzjlw4K/6c7UPhankmB5/N7hT//TRzsMwrvBvug8B/cRuE/zJP/DGaq" +
       "UM/PvdmNsjvZu9l0fXfsmdoBit+7Ayiu55n5fP3FPRRf/Jbz/i9ug8JX8uTP" +
       "QDwMhn26DwPP+MQLONxj2J58xhn+1zsF4j3g+fIeiC9/E4E4Y9phIfDXt8Hg" +
       "b/LkfwB3BzDIz4A3YP7P52JKdxe7K1yvHlT+n3eqch6efG2v8te+LWZw6e5b" +
       "K3/pcp75jah0Lff/JzZwM80vle5A80f3ml96cFd29/9bpPmrRVJod/V1XP6l" +
       "a3ny4M7l56wHkTt6GhwUCB4AeOiNAJACPt30alp+t+b6ay7J7i52qj/38pX7" +
       "3vYy/8Xidtbp5cv7qdJ9xsa2z16FOPN+2Q90wyyguX93McIvdHv7PqC5WbwJ" +
       "liAgzXt96fpO+h0AhJtJA0mQnpV8EixyLkoC31D8Pyv3dFR64CAXlS7vXs6K" +
       "PAtqByL567v8k7DjzNWH3c2RdBflXT/LrcIYr73eiJxZaT9zbn1cXGY+Wctu" +
       "dteZX1A//fJg9ANfbfz07pKZastZltdyH1W6d3ffrag0Xw8/dcvaTuq63H/u" +
       "6w9/5v5nT9buD+86fOD5mb49efNbXD3Hj4p7V9kvve3nv+dnXv7j4u7H/wPQ" +
       "wMHbZS4AAA==");
}
