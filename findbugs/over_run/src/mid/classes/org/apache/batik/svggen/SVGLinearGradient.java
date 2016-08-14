package org.apache.batik.svggen;
public class SVGLinearGradient extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGLinearGradient(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Paint paint =
          gc.
          getPaint(
            );
        return toSVG(
                 (java.awt.GradientPaint)
                   paint);
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.GradientPaint gradient) {
        org.apache.batik.svggen.SVGPaintDescriptor gradientDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              gradient);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (gradientDesc ==
              null) {
            org.w3c.dom.Element gradientDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_LINEAR_GRADIENT_TAG);
            gradientDef.
              setAttributeNS(
                null,
                SVG_GRADIENT_UNITS_ATTRIBUTE,
                SVG_USER_SPACE_ON_USE_VALUE);
            java.awt.geom.Point2D p1 =
              gradient.
              getPoint1(
                );
            java.awt.geom.Point2D p2 =
              gradient.
              getPoint2(
                );
            gradientDef.
              setAttributeNS(
                null,
                SVG_X1_ATTRIBUTE,
                doubleString(
                  p1.
                    getX(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_Y1_ATTRIBUTE,
                doubleString(
                  p1.
                    getY(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_X2_ATTRIBUTE,
                doubleString(
                  p2.
                    getX(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_Y2_ATTRIBUTE,
                doubleString(
                  p2.
                    getY(
                      )));
            java.lang.String spreadMethod =
              SVG_PAD_VALUE;
            if (gradient.
                  isCyclic(
                    ))
                spreadMethod =
                  SVG_REFLECT_VALUE;
            gradientDef.
              setAttributeNS(
                null,
                SVG_SPREAD_METHOD_ATTRIBUTE,
                spreadMethod);
            org.w3c.dom.Element gradientStop =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_STOP_TAG);
            gradientStop.
              setAttributeNS(
                null,
                SVG_OFFSET_ATTRIBUTE,
                SVG_ZERO_PERCENT_VALUE);
            org.apache.batik.svggen.SVGPaintDescriptor colorDesc =
              org.apache.batik.svggen.SVGColor.
              toSVG(
                gradient.
                  getColor1(
                    ),
                generatorContext);
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_COLOR_ATTRIBUTE,
                colorDesc.
                  getPaintValue(
                    ));
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_OPACITY_ATTRIBUTE,
                colorDesc.
                  getOpacityValue(
                    ));
            gradientDef.
              appendChild(
                gradientStop);
            gradientStop =
              domFactory.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_STOP_TAG);
            gradientStop.
              setAttributeNS(
                null,
                SVG_OFFSET_ATTRIBUTE,
                SVG_HUNDRED_PERCENT_VALUE);
            colorDesc =
              org.apache.batik.svggen.SVGColor.
                toSVG(
                  gradient.
                    getColor2(
                      ),
                  generatorContext);
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_COLOR_ATTRIBUTE,
                colorDesc.
                  getPaintValue(
                    ));
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_OPACITY_ATTRIBUTE,
                colorDesc.
                  getOpacityValue(
                    ));
            gradientDef.
              appendChild(
                gradientStop);
            gradientDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_LINEAR_GRADIENT));
            java.lang.StringBuffer paintAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            paintAttrBuf.
              append(
                SIGN_POUND);
            paintAttrBuf.
              append(
                gradientDef.
                  getAttributeNS(
                    null,
                    SVG_ID_ATTRIBUTE));
            paintAttrBuf.
              append(
                URL_SUFFIX);
            gradientDesc =
              new org.apache.batik.svggen.SVGPaintDescriptor(
                paintAttrBuf.
                  toString(
                    ),
                SVG_OPAQUE_VALUE,
                gradientDef);
            descMap.
              put(
                gradient,
                gradientDesc);
            defSet.
              add(
                gradientDef);
        }
        return gradientDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "k1bb45EUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d9/+my9+K0/q/Q8/11QriCAAAA==");
}
