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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
