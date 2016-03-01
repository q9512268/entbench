package org.apache.batik.svggen;
public class SVGRescaleOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    public SVGRescaleOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.RescaleOp)
            return toSVG(
                     (java.awt.image.RescaleOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.RescaleOp rescaleOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              rescaleOp);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (filterDesc ==
              null) {
            org.w3c.dom.Element filterDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FILTER_TAG);
            org.w3c.dom.Element feComponentTransferDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_COMPONENT_TRANSFER_TAG);
            float[] offsets =
              rescaleOp.
              getOffsets(
                null);
            float[] scaleFactors =
              rescaleOp.
              getScaleFactors(
                null);
            if (offsets.
                  length !=
                  scaleFactors.
                    length)
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  ERR_SCALE_FACTORS_AND_OFFSETS_MISMATCH);
            if (offsets.
                  length !=
                  1 &&
                  offsets.
                    length !=
                  3 &&
                  offsets.
                    length !=
                  4)
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  ERR_ILLEGAL_BUFFERED_IMAGE_RESCALE_OP);
            org.w3c.dom.Element feFuncR =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_R_TAG);
            org.w3c.dom.Element feFuncG =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_G_TAG);
            org.w3c.dom.Element feFuncB =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_B_TAG);
            org.w3c.dom.Element feFuncA =
              null;
            java.lang.String type =
              SVG_LINEAR_VALUE;
            if (offsets.
                  length ==
                  1) {
                java.lang.String slope =
                  doubleString(
                    scaleFactors[0]);
                java.lang.String intercept =
                  doubleString(
                    offsets[0]);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
            }
            else
                if (offsets.
                      length >=
                      3) {
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[0]));
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[1]));
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[2]));
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[0]));
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[1]));
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[2]));
                    if (offsets.
                          length ==
                          4) {
                        feFuncA =
                          domFactory.
                            createElementNS(
                              SVG_NAMESPACE_URI,
                              SVG_FE_FUNC_A_TAG);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_TYPE_ATTRIBUTE,
                            type);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_SLOPE_ATTRIBUTE,
                            doubleString(
                              scaleFactors[3]));
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_INTERCEPT_ATTRIBUTE,
                            doubleString(
                              offsets[3]));
                    }
                }
            feComponentTransferDef.
              appendChild(
                feFuncR);
            feComponentTransferDef.
              appendChild(
                feFuncG);
            feComponentTransferDef.
              appendChild(
                feFuncB);
            if (feFuncA !=
                  null)
                feComponentTransferDef.
                  appendChild(
                    feFuncA);
            filterDef.
              appendChild(
                feComponentTransferDef);
            filterDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FE_COMPONENT_TRANSFER));
            java.lang.String filterAttrBuf =
              URL_PREFIX +
            SIGN_POUND +
            filterDef.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE) +
            URL_SUFFIX;
            filterDesc =
              new org.apache.batik.svggen.SVGFilterDescriptor(
                filterAttrBuf,
                filterDef);
            defSet.
              add(
                filterDef);
            descMap.
              put(
                rescaleOp,
                filterDesc);
        }
        return filterDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ya2wU1xW+u34vBj8ItgvBgLOgYsJOaZKmkaGNcTAsrPHK" +
       "Jkhd0ix3Z+56B2ZnLjN37LVpSojUBlVqmgaS0kr4F1HViCZR1aj9E+SqUpMo" +
       "pRE0avNQ01b90xdS+BNa0de5d547u+uEP11pZmfvnHvuPed85zvn7qXrqMUy" +
       "0RDFuoJTbJ4SK5Xlz1lsWkQZ07BlHYLRvPyNP549dfPXHafjqDWHVpWwNSFj" +
       "i4yrRFOsHFqv6hbDukysg4QofEbWJBYxZzFTDT2H1qhWukw1VVbZhKEQLnAY" +
       "mxnUgxkz1YLNSNpVwNCGjNiNJHYjjUYFRjKoUzbofDBhbdWEsdA7LlsO1rMY" +
       "6s4cw7NYspmqSRnVYiMVE22jhjY/oxksRSosdUy7z3XE/sx9NW4Yernro1tP" +
       "l7qFG1ZjXTeYMNGaIpahzRIlg7qC0T0aKVsn0FdRUwatCAkzlMx4i0qwqASL" +
       "evYGUrD7lUS3y2OGMId5mlqpzDfE0KZqJRSbuOyqyYo9g4Z25touJoO1G31r" +
       "vXBHTHx2m3TuO492/6gJdeVQl6pP8+3IsAkGi+TAoaRcIKY1qihEyaEeHQI+" +
       "TUwVa+qCG+1eS53RMbMBAp5b+KBNiSnWDHwFkQTbTFtmhumbVxSgcn+1FDU8" +
       "A7b2BbY6Fo7zcTAwocLGzCIG7LlTmo+ruiJwVD3DtzF5AARgaluZsJLhL9Ws" +
       "YxhAvQ5ENKzPSNMAPn0GRFsMgKApsNZAKfc1xfJxPEPyDA1E5bLOK5DqEI7g" +
       "UxhaExUTmiBKayNRCsXn+sGdT53U9+lxFIM9K0TW+P5XwKTByKQpUiQmgTxw" +
       "JnYOZ57Dfa+eiSMEwmsiwo7MT75y48G7B5ded2TW1ZGZLBwjMsvLFwurrt45" +
       "tvWBJr6NdmpYKg9+leUiy7Lum5EKBabp8zXylynv5dLUL770+Avkb3GUSKNW" +
       "2dDsMuCoRzbKVNWIuZfoxMSMKGnUQXRlTLxPozZ4zqg6cUYni0WLsDRq1sRQ" +
       "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" +
       "bJjS/wFoPemhaxQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F+Vp+vT37/vdd/zmS9/Is3j/DXMrkU5qIAAA");
}
