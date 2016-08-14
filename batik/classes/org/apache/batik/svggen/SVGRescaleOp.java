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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYa2wcVxW+u347fiexTR524jiBPLrbQIMUnJTaGzvZZP3A" +
       "To1w2mzuztzdnXh2ZjJzx1479Cmhhj9VSJM0INW/XFVUfQlRARKtjCqRVgWk" +
       "lggoqAGJP+UR0Qip/Aivc++d1856E4Jgpbk7c++5595z7ne+c2ZeuoFqLBP1" +
       "EI3G6IJBrNiwRiewaRE5oWLLOg59aenZKvzXkx+N7Y+i2hnUksfWqIQtMqIQ" +
       "VbZm0GZFsyjWJGKNESKzGRMmsYg5h6miazNovWIlC4aqSAod1WXCBKaxmULt" +
       "mFJTydiUJB0FFG1OwU7ifCfxwfDwQAo1Sbqx4It3B8QTgREmWfDXsihqS53G" +
       "czhuU0WNpxSLDhRNtNvQ1YWcqtMYKdLYaXWf44KjqX1lLuh7rfWTW+fzbdwF" +
       "a7Gm6ZSbZ00SS1fniJxCrX7vsEoK1hn0KKpKoTUBYYr6U+6icVg0Dou61vpS" +
       "sPtmotmFhM7Noa6mWkNiG6Joa6kSA5u44KiZ4HsGDfXUsZ1PBmu3eNYKK8tM" +
       "vLQ7fvHZk23fqUKtM6hV0abYdiTYBIVFZsChpJAhpjUoy0SeQe0aHPYUMRWs" +
       "KovOSXdYSk7D1Ibjd93COm2DmHxN31dwjmCbaUtUNz3zshxQzlNNVsU5sLXT" +
       "t1VYOML6wcBGBTZmZjHgzplSPatoMkW94Rmejf3HQACm1hUIzeveUtUahg7U" +
       "ISCiYi0XnwLoaTkQrdEBgCZFGyoqZb42sDSLcyTNEBmSmxBDINXAHcGmULQ+" +
       "LMY1wSltCJ1S4HxujB14+qx2RIuiCOxZJpLK9r8GJvWEJk2SLDEJxIGY2LQr" +
       "dRl3vnEuihAIrw8JC5nvffXmA3t6Vt4WMhtXkRnPnCYSTUvLmZb3NiV27q9i" +
       "26g3dEthh19iOY+yCWdkoGgAw3R6GtlgzB1cmfzxVx5/kfwpihqTqFbSVbsA" +
       "OGqX9IKhqMQ8TDRiYkrkJGogmpzg40lUB/cpRSOidzybtQhNomqVd9Xq/Blc" +
       "lAUVzEWNcK9oWd29NzDN8/uigRCqgws1wfUZJH78n6Ivx/N6gcSxhDVF0+MT" +
       "ps7st+LAOBnwbT6eAdTPxi3dNgGCcd3MxTHgIE/cgblcjmjxqenDAHsJq2Tc" +
       "iDGAGf8/1UVm1dr5SAQcvikc7ipEyhFdlYmZli7aQ8M3X0m/K6DE4O/4AwgK" +
       "VouJ1WJ8tZhYLRZcDUUifJF1bFVxonAesxDZQK1NO6cePnrqXF8VQMmYrwZn" +
       "MtG+khST8MPf5ey09GpH8+LW63vfiqLqFOrAErWxyjLGoJkDLpJmnXBtykDy" +
       "8XPAlkAOYMnL1CUiAwVVygWOlnp9jpisn6J1AQ1uhmKxGK+cH1bdP1q5Mv/E" +
       "9GP3RlG0lPbZkjXAWGz6BCNrj5T7w+G+mt7Wpz765NXLj+h+4JfkETf9lc1k" +
       "NvSFYRB2T1ratQW/nn7jkX7u9gYgZoohkIDzesJrlPDKgMvRzJZ6MDirmwWs" +
       "siHXx400b+rzfg/HZzu/XwewWMMCrQuue5zI4/9stNNgbZfAM8NZyAqeAw5O" +
       "Gc/96md/+Bx3t5suWgN5forQgQBFMWUdnIzafdgeNwkBuQ+vTDxz6cZTJzhm" +
       "QWLbagv2szYB1ARHCG7+2ttnPvjt9eVrUR/nFHK0nYFSp+gZyfpR422MhNV2" +
       "+PsBilOBCxhq+h/UAJ9KVsEZlbDA+nvr9r2v//npNoEDFXpcGO25swK//1ND" +
       "6PF3T/6th6uJSCzF+j7zxQRvr/U1D5omXmD7KD7x/uZvXsXPQQYA1rWURcKJ" +
       "NOLEOttUN0W7b0MkDq/rplNd8IPex2fey9v7mJO4PsTH9rNmuxUMmNKYDJRP" +
       "aen8tY+bpz9+8ya3sLT+CuJjFBsDApKs2VEE9V1hQjuCrTzI3bcy9lCbunIL" +
       "NM6ARglo2Ro3gUuLJWhypGvqfv2jtzpPvVeFoiOoUdWxPIJ5YKIGiAhi5YGG" +
       "i8YXHxCAmK+Hpo2bisqML+tgh9K7+nEPFwzKD2jx+13fPfDC0nWOTEPo2BhU" +
       "+GnW7PYwyn+14RQYxGiJBhNtrlSl8Apr+cmLS/L483tFLdFRmvmHobB9+Rf/" +
       "+Ensyu/eWSX9NFDduEclc0QNrBllS5bkj1FewPkc9mHLhd//oD83dDepg/X1" +
       "3CE5sOdeMGJX5VQQ3srVJ/+44fj9+VN3kQV6Q+4Mq/z26EvvHN4hXYjyalUk" +
       "gLIqt3TSQNCxsKhJoCzXmJmsp5nDfpsHgF52sP1wHXQAcHB1Jl4FOx6/VZoa" +
       "iuqoc6IOS/RwKON5GlMKUCbHhuwsyzFykj2NG65Yhyc2CWiHCl0lfEvTt+GM" +
       "h1jzJYpqqA6U85/Q0oiiQrF/CKocUzHcN5MvsGZSxM3B/zJmWUdCGDNa7vRj" +
       "jueO3b3TK00NuSVEzd0hp3t1HV9RuY1PC6yRXZ+yh5O+k8j/wklFipqCpSbj" +
       "u+6yV1fxuiW9stRa37X04C952HuvRE0QwFlbVQP4D8ZCrWGSrMLNaRL0L+y2" +
       "KeqqAA7I6+KG75oKedhpW1gePMP/g3JnKWr05UCVuAmKPEpRFYiw28c8zH+2" +
       "ElIHM1DpAcd5iIUsCnwFN8VIOdfzo1l/p6MJkPu2Eq7jHxdcXrLF5wUo1ZeO" +
       "jp29+fnnRe0lqXhxkb+Mwru1KAM9bttaUZurq/bIzlstrzVsjzoYaxcb9sG/" +
       "MQDABMCYY2JDqDCx+r365IPlA2/+9Fzt+5BeTqAIpmjticCrvXiPherGhqRy" +
       "IuWnlcDHKV4xDez81sL9e7J/+Q1Po0i8xmyqLJ+Wrr3w8M8vdC9DZbUmiWog" +
       "E5LiDGpUrEMLGtDWnDmDmhVruAhbBC0KVpOo3taUMzZJyinUwuCL2WcH7hfH" +
       "nc1eL6vcKeor+76wyvsOlBzzxBzSbU3mbA95yO8p+erhpgfbMEIT/B7vKNeV" +
       "256WDn299YfnO6pGIARLzAmqr7PsjJd6gh9C/FzUJrjtX/CLwPVPdrFDZx3s" +
       "H1JAwvkosMX7KgC1jRirSqdGDcOVbbxqiCD6BmueKbJ+iiK7nN4AIbLHy3z9" +
       "S/yWNVf+DUVeeeoUFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IeeYxIogAAA=");
}
