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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "u/of1PyqVDoVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rCAAAA==");
}
