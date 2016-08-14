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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GBkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "C7N7yPUf3/FHr/7Y09/Krjb+D5zljGNjJQAA");
}
