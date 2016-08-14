package org.apache.batik.dom.svg;
public class SVGLocatableSupport {
    public SVGLocatableSupport() { super(); }
    public static org.w3c.dom.svg.SVGElement getNearestViewportElement(org.w3c.dom.Element e) {
        org.w3c.dom.Element elt =
          e;
        while (elt !=
                 null) {
            elt =
              org.apache.batik.css.engine.SVGCSSEngine.
                getParentCSSStylableElement(
                  elt);
            if (elt instanceof org.w3c.dom.svg.SVGFitToViewBox) {
                break;
            }
        }
        return (org.w3c.dom.svg.SVGElement)
                 elt;
    }
    public static org.w3c.dom.svg.SVGElement getFarthestViewportElement(org.w3c.dom.Element elt) {
        return (org.w3c.dom.svg.SVGElement)
                 elt.
                 getOwnerDocument(
                   ).
                 getDocumentElement(
                   );
    }
    public static org.w3c.dom.svg.SVGRect getBBox(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        org.apache.batik.dom.svg.SVGContext svgctx =
          svgelt.
          getSVGContext(
            );
        if (svgctx ==
              null)
            return null;
        if (svgctx.
              getBBox(
                ) ==
              null)
            return null;
        return new org.w3c.dom.svg.SVGRect(
          ) {
            public float getX() {
                return (float)
                         svgelt.
                         getSVGContext(
                           ).
                         getBBox(
                           ).
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
                         svgelt.
                         getSVGContext(
                           ).
                         getBBox(
                           ).
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
                         svgelt.
                         getSVGContext(
                           ).
                         getBBox(
                           ).
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
                         svgelt.
                         getSVGContext(
                           ).
                         getBBox(
                           ).
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
    public static org.w3c.dom.svg.SVGMatrix getCTM(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        return new org.apache.batik.dom.svg.AbstractSVGMatrix(
          ) {
            protected java.awt.geom.AffineTransform getAffineTransform() {
                return svgelt.
                  getSVGContext(
                    ).
                  getCTM(
                    );
            }
        };
    }
    public static org.w3c.dom.svg.SVGMatrix getScreenCTM(org.w3c.dom.Element elt) {
        final org.apache.batik.dom.svg.SVGOMElement svgelt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        return new org.apache.batik.dom.svg.AbstractSVGMatrix(
          ) {
            protected java.awt.geom.AffineTransform getAffineTransform() {
                org.apache.batik.dom.svg.SVGContext context =
                  svgelt.
                  getSVGContext(
                    );
                java.awt.geom.AffineTransform ret =
                  context.
                  getGlobalTransform(
                    );
                java.awt.geom.AffineTransform scrnTrans =
                  context.
                  getScreenTransform(
                    );
                if (scrnTrans !=
                      null)
                    ret.
                      preConcatenate(
                        scrnTrans);
                return ret;
            }
        };
    }
    public static org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.Element elt,
                                                                  org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        final org.apache.batik.dom.svg.SVGOMElement currentElt =
          (org.apache.batik.dom.svg.SVGOMElement)
            elt;
        final org.apache.batik.dom.svg.SVGOMElement targetElt =
          (org.apache.batik.dom.svg.SVGOMElement)
            element;
        return new org.apache.batik.dom.svg.AbstractSVGMatrix(
          ) {
            protected java.awt.geom.AffineTransform getAffineTransform() {
                java.awt.geom.AffineTransform cat =
                  currentElt.
                  getSVGContext(
                    ).
                  getGlobalTransform(
                    );
                if (cat ==
                      null) {
                    cat =
                      new java.awt.geom.AffineTransform(
                        );
                }
                java.awt.geom.AffineTransform tat =
                  targetElt.
                  getSVGContext(
                    ).
                  getGlobalTransform(
                    );
                if (tat ==
                      null) {
                    tat =
                      new java.awt.geom.AffineTransform(
                        );
                }
                java.awt.geom.AffineTransform at =
                  new java.awt.geom.AffineTransform(
                  cat);
                try {
                    at.
                      preConcatenate(
                        tat.
                          createInverse(
                            ));
                    return at;
                }
                catch (java.awt.geom.NoninvertibleTransformException ex) {
                    throw currentElt.
                      createSVGException(
                        org.w3c.dom.svg.SVGException.
                          SVG_MATRIX_NOT_INVERTABLE,
                        "noninvertiblematrix",
                        null);
                }
            }
        };
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AV14s6gJGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
