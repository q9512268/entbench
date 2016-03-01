package org.apache.batik.dom.svg;
public class SVGPathSupport {
    public static float getTotalLength(org.apache.batik.dom.svg.SVGOMPathElement path) {
        org.apache.batik.dom.svg.SVGPathContext pathCtx =
          (org.apache.batik.dom.svg.SVGPathContext)
            path.
            getSVGContext(
              );
        return pathCtx.
          getTotalLength(
            );
    }
    public static int getPathSegAtLength(org.apache.batik.dom.svg.SVGOMPathElement path,
                                         float x) { org.apache.batik.dom.svg.SVGPathContext pathCtx =
                                                      (org.apache.batik.dom.svg.SVGPathContext)
                                                        path.
                                                        getSVGContext(
                                                          );
                                                    return pathCtx.
                                                      getPathSegAtLength(
                                                        x);
    }
    public static org.w3c.dom.svg.SVGPoint getPointAtLength(final org.apache.batik.dom.svg.SVGOMPathElement path,
                                                            final float distance) {
        final org.apache.batik.dom.svg.SVGPathContext pathCtx =
          (org.apache.batik.dom.svg.SVGPathContext)
            path.
            getSVGContext(
              );
        if (pathCtx ==
              null)
            return null;
        return new org.w3c.dom.svg.SVGPoint(
          ) {
            public float getX() {
                java.awt.geom.Point2D pt =
                  pathCtx.
                  getPointAtLength(
                    distance);
                return (float)
                         pt.
                         getX(
                           );
            }
            public float getY() {
                java.awt.geom.Point2D pt =
                  pathCtx.
                  getPointAtLength(
                    distance);
                return (float)
                         pt.
                         getY(
                           );
            }
            public void setX(float x)
                  throws org.w3c.dom.DOMException {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
            public void setY(float y)
                  throws org.w3c.dom.DOMException {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
            public org.w3c.dom.svg.SVGPoint matrixTransform(org.w3c.dom.svg.SVGMatrix matrix) {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
        };
    }
    public SVGPathSupport() { super(); }
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
       "SiX9g1f+3ht/+9lv5ce6/wPfyXlaKyIAAA==");
}
