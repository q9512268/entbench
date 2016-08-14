package org.apache.batik.dom.svg;
public class SVGZoomAndPanSupport implements org.apache.batik.util.SVGConstants {
    protected SVGZoomAndPanSupport() { super(); }
    public static void setZoomAndPan(org.w3c.dom.Element elt, short val) throws org.w3c.dom.DOMException {
        switch (val) {
            case org.w3c.dom.svg.SVGZoomAndPan.
                   SVG_ZOOMANDPAN_DISABLE:
                elt.
                  setAttributeNS(
                    null,
                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                    SVG_DISABLE_VALUE);
                break;
            case org.w3c.dom.svg.SVGZoomAndPan.
                   SVG_ZOOMANDPAN_MAGNIFY:
                elt.
                  setAttributeNS(
                    null,
                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                    SVG_MAGNIFY_VALUE);
                break;
            default:
                throw ((org.apache.batik.dom.AbstractNode)
                         elt).
                  createDOMException(
                    org.w3c.dom.DOMException.
                      INVALID_MODIFICATION_ERR,
                    "zoom.and.pan",
                    new java.lang.Object[] { new java.lang.Integer(
                      val) });
        }
    }
    public static short getZoomAndPan(org.w3c.dom.Element elt) { java.lang.String s =
                                                                   elt.
                                                                   getAttributeNS(
                                                                     null,
                                                                     SVG_ZOOM_AND_PAN_ATTRIBUTE);
                                                                 if (s.
                                                                       equals(
                                                                         SVG_MAGNIFY_VALUE)) {
                                                                     return org.w3c.dom.svg.SVGZoomAndPan.
                                                                              SVG_ZOOMANDPAN_MAGNIFY;
                                                                 }
                                                                 return org.w3c.dom.svg.SVGZoomAndPan.
                                                                          SVG_ZOOMANDPAN_DISABLE;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vHjF4YX/AO97BlDOFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ze7OOrYPzbuaB0/uh44e3Z6XnAML9nx5v75fzPjfmkt5OG+vZs1PbMMUggI3" +
       "ki0TLJMLQV57Ai7ddCQrV/5kCNLMUq4eahiDWhTE5erCqueiXgOq7zylMg/s" +
       "bwu4La5lbTkXsU2L6g1T6Ce3VPkD7I6dMMYFteD7/vGDX/nA678B4kpD5+PM" +
       "5yCcxzSyUVYe/+ILz93/qme/+b4crABSjd/7u/VvZlJ7N7A6u21nDZE15KGp" +
       "92WmDvPnPiMFYS8HF03NrX3ZdOZ90wYwHB/UfvDTd31j+dFvfWpb153O3VPE" +
       "2jPP/tIP99//7N6xavr11xW0x3m2FXU+6dsPPOxDD7+clpyD+KfPPP1Hv/30" +
       "e7azuutkbdgGrz6f+qv/+sr+h7/5pTPKkZst938R2PC273cqAYUdfpjSTCuv" +
       "R0li61y9wCL1tdKZSz13xmDTidGclIdSspiVbTpNmgNu1ZkjTqQWq0ihiyKT" +
       "MZIuKnWvbw8ob7PyZnOMGk9b0+Kg2sVsVwoHE3nYXQ3bZdOjJ0N3JXrEuOtZ" +
       "I1dftclxcYG6NlLXU7YeImFFHBDTkkcjsg07tl2Ak0JSTZlSZcHOqmzkLXAK" +
       "ScnZsroscngiLcJeR216lcKmFUnCRsSnaKFB+lpdIoaTcjMkh26vRveNdckT" +
       "CE3FCdsj+zXHCLoKP9t4UZONehVdHFUHvue152Y6djgy9uwVk7THrDVkmnp5" +
       "0RkKCxsJx0MuKJNTbKj4sw1Oj9vzYb0fRGhDpJZlWuol1apXQRtrRmtahBMz" +
       "lCaE4dzglpMFJ9W9oriwG2ytIWi1otAp2f2FWjW4cbVKNwslYYrXw8WkZ7DF" +
       "aTlFqz2JFuhgvR7RK7I5m9ZAvtsTfjUqbtjlWIxVC3cmmrIuCCvP9NoEb9Oc" +
       "ZneJfo1dS3ifYyYLfzTrFFMlpcS+2nP7lVjprkoEPqSW6cQSmsmqWEsZ2qwu" +
       "8Xm9hLBjVcbEcJxoJWu8mqymi1oagXCtC2VdKnTDpkityiAfhHm32esYS6w/" +
       "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" +
       "v/m3nv96vmn6PyUaASSrIQAA");
}
