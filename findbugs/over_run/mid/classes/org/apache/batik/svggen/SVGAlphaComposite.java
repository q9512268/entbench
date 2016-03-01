package org.apache.batik.svggen;
public class SVGAlphaComposite extends org.apache.batik.svggen.AbstractSVGConverter {
    private java.util.Map compositeDefsMap = new java.util.HashMap();
    private boolean backgroundAccessRequired = false;
    public SVGAlphaComposite(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              Src,
            compositeToSVG(
              java.awt.AlphaComposite.
                Src));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              SrcIn,
            compositeToSVG(
              java.awt.AlphaComposite.
                SrcIn));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              SrcOut,
            compositeToSVG(
              java.awt.AlphaComposite.
                SrcOut));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              DstIn,
            compositeToSVG(
              java.awt.AlphaComposite.
                DstIn));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              DstOut,
            compositeToSVG(
              java.awt.AlphaComposite.
                DstOut));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              DstOver,
            compositeToSVG(
              java.awt.AlphaComposite.
                DstOver));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              Clear,
            compositeToSVG(
              java.awt.AlphaComposite.
                Clear));
    }
    public java.util.List getAlphaCompositeFilterSet() { return new java.util.LinkedList(
                                                           compositeDefsMap.
                                                             values(
                                                               ));
    }
    public boolean requiresBackgroundAccess() { return backgroundAccessRequired;
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 (java.awt.AlphaComposite)
                   gc.
                   getComposite(
                     ));
    }
    public org.apache.batik.svggen.SVGCompositeDescriptor toSVG(java.awt.AlphaComposite composite) {
        org.apache.batik.svggen.SVGCompositeDescriptor compositeDesc =
          (org.apache.batik.svggen.SVGCompositeDescriptor)
            descMap.
            get(
              composite);
        if (compositeDesc ==
              null) {
            java.lang.String opacityValue =
              doubleString(
                composite.
                  getAlpha(
                    ));
            java.lang.String filterValue =
              null;
            org.w3c.dom.Element filterDef =
              null;
            if (composite.
                  getRule(
                    ) !=
                  java.awt.AlphaComposite.
                    SRC_OVER) {
                java.awt.AlphaComposite majorComposite =
                  java.awt.AlphaComposite.
                  getInstance(
                    composite.
                      getRule(
                        ));
                filterDef =
                  (org.w3c.dom.Element)
                    compositeDefsMap.
                    get(
                      majorComposite);
                defSet.
                  add(
                    filterDef);
                java.lang.StringBuffer filterAttrBuf =
                  new java.lang.StringBuffer(
                  URL_PREFIX);
                filterAttrBuf.
                  append(
                    SIGN_POUND);
                filterAttrBuf.
                  append(
                    filterDef.
                      getAttributeNS(
                        null,
                        SVG_ID_ATTRIBUTE));
                filterAttrBuf.
                  append(
                    URL_SUFFIX);
                filterValue =
                  filterAttrBuf.
                    toString(
                      );
            }
            else
                filterValue =
                  SVG_NONE_VALUE;
            compositeDesc =
              new org.apache.batik.svggen.SVGCompositeDescriptor(
                opacityValue,
                filterValue,
                filterDef);
            descMap.
              put(
                composite,
                compositeDesc);
        }
        if (composite.
              getRule(
                ) !=
              java.awt.AlphaComposite.
                SRC_OVER)
            backgroundAccessRequired =
              true;
        return compositeDesc;
    }
    private org.w3c.dom.Element compositeToSVG(java.awt.AlphaComposite composite) {
        java.lang.String operator =
          null;
        java.lang.String input1 =
          null;
        java.lang.String input2 =
          null;
        java.lang.String k2 =
          "0";
        java.lang.String id =
          null;
        switch (composite.
                  getRule(
                    )) {
            case java.awt.AlphaComposite.
                   CLEAR:
                operator =
                  SVG_ARITHMETIC_VALUE;
                input1 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input2 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_CLEAR;
                break;
            case java.awt.AlphaComposite.
                   SRC:
                operator =
                  SVG_ARITHMETIC_VALUE;
                input1 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input2 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_SRC;
                k2 =
                  SVG_DIGIT_ONE_VALUE;
                break;
            case java.awt.AlphaComposite.
                   SRC_IN:
                operator =
                  SVG_IN_VALUE;
                input1 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input2 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_SRC_IN;
                break;
            case java.awt.AlphaComposite.
                   SRC_OUT:
                operator =
                  SVG_OUT_VALUE;
                input1 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input2 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_SRC_OUT;
                break;
            case java.awt.AlphaComposite.
                   DST_IN:
                operator =
                  SVG_IN_VALUE;
                input2 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input1 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_DST_IN;
                break;
            case java.awt.AlphaComposite.
                   DST_OUT:
                operator =
                  SVG_OUT_VALUE;
                input2 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input1 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_DST_OUT;
                break;
            case java.awt.AlphaComposite.
                   DST_OVER:
                operator =
                  SVG_OVER_VALUE;
                input2 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input1 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_DST_OVER;
                break;
            default:
                throw new java.lang.Error(
                  "invalid rule:" +
                  composite.
                    getRule(
                      ));
        }
        org.w3c.dom.Element compositeFilter =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FILTER_TAG);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_ID_ATTRIBUTE,
            id);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_FILTER_UNITS_ATTRIBUTE,
            SVG_OBJECT_BOUNDING_BOX_VALUE);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            SVG_ZERO_PERCENT_VALUE);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_ZERO_PERCENT_VALUE);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            SVG_HUNDRED_PERCENT_VALUE);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            SVG_HUNDRED_PERCENT_VALUE);
        org.w3c.dom.Element feComposite =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_COMPOSITE_TAG);
        feComposite.
          setAttributeNS(
            null,
            SVG_OPERATOR_ATTRIBUTE,
            operator);
        feComposite.
          setAttributeNS(
            null,
            SVG_IN_ATTRIBUTE,
            input1);
        feComposite.
          setAttributeNS(
            null,
            SVG_IN2_ATTRIBUTE,
            input2);
        feComposite.
          setAttributeNS(
            null,
            SVG_K2_ATTRIBUTE,
            k2);
        feComposite.
          setAttributeNS(
            null,
            SVG_RESULT_ATTRIBUTE,
            SVG_COMPOSITE_VALUE);
        org.w3c.dom.Element feFlood =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_FLOOD_TAG);
        feFlood.
          setAttributeNS(
            null,
            SVG_FLOOD_COLOR_ATTRIBUTE,
            "white");
        feFlood.
          setAttributeNS(
            null,
            SVG_FLOOD_OPACITY_ATTRIBUTE,
            "1");
        feFlood.
          setAttributeNS(
            null,
            SVG_RESULT_ATTRIBUTE,
            SVG_FLOOD_VALUE);
        org.w3c.dom.Element feMerge =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_MERGE_TAG);
        org.w3c.dom.Element feMergeNodeFlood =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_MERGE_NODE_TAG);
        feMergeNodeFlood.
          setAttributeNS(
            null,
            SVG_IN_ATTRIBUTE,
            SVG_FLOOD_VALUE);
        org.w3c.dom.Element feMergeNodeComposite =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_MERGE_NODE_TAG);
        feMergeNodeComposite.
          setAttributeNS(
            null,
            SVG_IN_ATTRIBUTE,
            SVG_COMPOSITE_VALUE);
        feMerge.
          appendChild(
            feMergeNodeFlood);
        feMerge.
          appendChild(
            feMergeNodeComposite);
        compositeFilter.
          appendChild(
            feFlood);
        compositeFilter.
          appendChild(
            feComposite);
        compositeFilter.
          appendChild(
            feMerge);
        return compositeFilter;
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
       "a575dL2NrjMu3dsh6QvdNqkzbJCxjLCVdHeHqHYAj6xWi3XGMLKKuc6Q3FCB" +
       "KljSgOGsbZsKkL66ZlYpks9zEXPp3B4wKuc6gT7Dd6PBet5U2eVyovstfYlp" +
       "PXM6J6XtRp8H8JTWOLep8x6213S4hvvWomkEmN/KWLqtim1i2G14GwSrpUaq" +
       "OXgwkpEtW4RNGemom26LWpur3boDm/1tG6Y4UST95qxVD3ZEvTXo8NM9y9su" +
       "wvp7JU8Yj0tdvNXqRWit8PKiMy0MvNFFGyMshwdGY5qkKzqRSGD2LZilRBhe" +
       "doI6EcF7K+NFvDlphYieo01TDdvwKu8WYdQq9mJ7M8oDZBPuuGadSJ1p0gTd" +
       "eYXlUGolNiJy7OXzPUZ1u+w68pOs0Q6TbDAw0XafWeRaX3VEdrHBY8zWiNEs" +
       "F/2ubqTGkJalqZPZo2262wOklEdiOLYYVebwtOmnrY0KN6YTW2VoqgcGsRE0" +
       "ybl6DTXDHTZLls5Syyd5Vxbqq6a8ba8CNhtFqagjKN9o7Ysd26pphDL1w2Wd" +
       "hLtUw3VGfXaJ97FBY7xBo/5uMmT2fVpIF5jCzySjzUjqBN+vR3Nzsw7gHLgj" +
       "E2lI6BTZW3423wjCAC1CFfYcAUG0iZ+u9J4iq8sB3OARHjFttakORrbRtnU/" +
       "kRmpE3nunJDhLSISuOWuBqQynoRUkqjdrhrnUgDcQbRFCUwyuKSP1xabBbVF" +
       "PHq7SUf1+djwmJmumXwdiakI2Efk5hbpTOUOgo+0kbhkW8VWXS7DutQQJ0Wi" +
       "ORjXD7k6UWvCrSbbIXu4J+eEQvUactuYNX0G8zCYbmEGbqyyolZLezOjBnOM" +
       "ihLsmtjiU8XfLxcovujI3n65cjcFo8IDGkVQWNBtAvZrNpYEnKIuuX6nMxHi" +
       "dojCE25axGPOS5AezyKFItMxMQjH4riPeSvRHI15zbcsvh2M8Tybs6gw0HXJ" +
       "A6JW8X00gvPmcDJrul2luTNQlsT21Hq48rfLBuHCWxQzyRZPEMu+qK9rmhPj" +
       "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" +
       "H7syfRTdKQAA");
}
