package org.apache.batik.bridge;
public class SVGGlyphElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    protected SVGGlyphElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_GLYPH_TAG; }
    public org.apache.batik.gvt.font.Glyph createGlyph(org.apache.batik.bridge.BridgeContext ctx,
                                                       org.w3c.dom.Element glyphElement,
                                                       org.w3c.dom.Element textElement,
                                                       int glyphCode,
                                                       float fontSize,
                                                       org.apache.batik.gvt.font.GVTFontFace fontFace,
                                                       org.apache.batik.gvt.text.TextPaintInfo tpi) {
        float fontHeight =
          fontFace.
          getUnitsPerEm(
            );
        float scale =
          fontSize /
          fontHeight;
        java.awt.geom.AffineTransform scaleTransform =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scale,
            -scale);
        java.lang.String d =
          glyphElement.
          getAttributeNS(
            null,
            SVG_D_ATTRIBUTE);
        java.awt.Shape dShape =
          null;
        if (d.
              length(
                ) !=
              0) {
            org.apache.batik.parser.AWTPathProducer app =
              new org.apache.batik.parser.AWTPathProducer(
              );
            app.
              setWindingRule(
                org.apache.batik.bridge.CSSUtilities.
                  convertFillRule(
                    textElement));
            try {
                org.apache.batik.parser.PathParser pathParser =
                  new org.apache.batik.parser.PathParser(
                  );
                pathParser.
                  setPathHandler(
                    app);
                pathParser.
                  parse(
                    d);
            }
            catch (org.apache.batik.parser.ParseException pEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  glyphElement,
                  pEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_D_ATTRIBUTE });
            }
            finally {
                java.awt.Shape shape =
                  app.
                  getShape(
                    );
                java.awt.Shape transformedShape =
                  scaleTransform.
                  createTransformedShape(
                    shape);
                dShape =
                  transformedShape;
            }
        }
        org.w3c.dom.NodeList glyphChildren =
          glyphElement.
          getChildNodes(
            );
        int numChildren =
          glyphChildren.
          getLength(
            );
        int numGlyphChildren =
          0;
        for (int i =
               0;
             i <
               numChildren;
             i++) {
            org.w3c.dom.Node childNode =
              glyphChildren.
              item(
                i);
            if (childNode.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                numGlyphChildren++;
            }
        }
        org.apache.batik.gvt.CompositeGraphicsNode glyphContentNode =
          null;
        if (numGlyphChildren >
              0) {
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            glyphContentNode =
              new org.apache.batik.gvt.CompositeGraphicsNode(
                );
            org.w3c.dom.Element fontElementClone =
              (org.w3c.dom.Element)
                glyphElement.
                getParentNode(
                  ).
                cloneNode(
                  false);
            org.w3c.dom.NamedNodeMap fontAttributes =
              glyphElement.
              getParentNode(
                ).
              getAttributes(
                );
            int numAttributes =
              fontAttributes.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   numAttributes;
                 i++) {
                fontElementClone.
                  setAttributeNode(
                    (org.w3c.dom.Attr)
                      fontAttributes.
                      item(
                        i));
            }
            org.w3c.dom.Element clonedGlyphElement =
              (org.w3c.dom.Element)
                glyphElement.
                cloneNode(
                  true);
            fontElementClone.
              appendChild(
                clonedGlyphElement);
            textElement.
              appendChild(
                fontElementClone);
            org.apache.batik.gvt.CompositeGraphicsNode glyphChildrenNode =
              new org.apache.batik.gvt.CompositeGraphicsNode(
              );
            glyphChildrenNode.
              setTransform(
                scaleTransform);
            org.w3c.dom.NodeList clonedGlyphChildren =
              clonedGlyphElement.
              getChildNodes(
                );
            int numClonedChildren =
              clonedGlyphChildren.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   numClonedChildren;
                 i++) {
                org.w3c.dom.Node childNode =
                  clonedGlyphChildren.
                  item(
                    i);
                if (childNode.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    org.w3c.dom.Element childElement =
                      (org.w3c.dom.Element)
                        childNode;
                    org.apache.batik.gvt.GraphicsNode childGraphicsNode =
                      builder.
                      build(
                        ctx,
                        childElement);
                    glyphChildrenNode.
                      add(
                        childGraphicsNode);
                }
            }
            glyphContentNode.
              add(
                glyphChildrenNode);
            textElement.
              removeChild(
                fontElementClone);
        }
        java.lang.String unicode =
          glyphElement.
          getAttributeNS(
            null,
            SVG_UNICODE_ATTRIBUTE);
        java.lang.String nameList =
          glyphElement.
          getAttributeNS(
            null,
            SVG_GLYPH_NAME_ATTRIBUTE);
        java.util.List names =
          new java.util.ArrayList(
          );
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          nameList,
          " ,");
        while (st.
                 hasMoreTokens(
                   )) {
            names.
              add(
                st.
                  nextToken(
                    ));
        }
        java.lang.String orientation =
          glyphElement.
          getAttributeNS(
            null,
            SVG_ORIENTATION_ATTRIBUTE);
        java.lang.String arabicForm =
          glyphElement.
          getAttributeNS(
            null,
            SVG_ARABIC_FORM_ATTRIBUTE);
        java.lang.String lang =
          glyphElement.
          getAttributeNS(
            null,
            SVG_LANG_ATTRIBUTE);
        org.w3c.dom.Element parentFontElement =
          (org.w3c.dom.Element)
            glyphElement.
            getParentNode(
              );
        java.lang.String s =
          glyphElement.
          getAttributeNS(
            null,
            SVG_HORIZ_ADV_X_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              parentFontElement.
                getAttributeNS(
                  null,
                  SVG_HORIZ_ADV_X_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  parentFontElement,
                  ERR_ATTRIBUTE_MISSING,
                  new java.lang.Object[] { SVG_HORIZ_ADV_X_ATTRIBUTE });
            }
        }
        float horizAdvX;
        try {
            horizAdvX =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_HORIZ_ADV_X_ATTRIBUTE,
              s });
        }
        s =
          glyphElement.
            getAttributeNS(
              null,
              SVG_VERT_ADV_Y_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              parentFontElement.
                getAttributeNS(
                  null,
                  SVG_VERT_ADV_Y_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                s =
                  java.lang.String.
                    valueOf(
                      fontFace.
                        getUnitsPerEm(
                          ));
            }
        }
        float vertAdvY;
        try {
            vertAdvY =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VERT_ADV_Y_ATTRIBUTE,
              s });
        }
        s =
          glyphElement.
            getAttributeNS(
              null,
              SVG_VERT_ORIGIN_X_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              parentFontElement.
                getAttributeNS(
                  null,
                  SVG_VERT_ORIGIN_X_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                s =
                  java.lang.Float.
                    toString(
                      horizAdvX /
                        2);
            }
        }
        float vertOriginX;
        try {
            vertOriginX =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VERT_ORIGIN_X_ATTRIBUTE,
              s });
        }
        s =
          glyphElement.
            getAttributeNS(
              null,
              SVG_VERT_ORIGIN_Y_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              parentFontElement.
                getAttributeNS(
                  null,
                  SVG_VERT_ORIGIN_Y_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                s =
                  java.lang.String.
                    valueOf(
                      fontFace.
                        getAscent(
                          ));
            }
        }
        float vertOriginY;
        try {
            vertOriginY =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                -scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VERT_ORIGIN_Y_ATTRIBUTE,
              s });
        }
        java.awt.geom.Point2D vertOrigin =
          new java.awt.geom.Point2D.Float(
          vertOriginX,
          vertOriginY);
        s =
          parentFontElement.
            getAttributeNS(
              null,
              SVG_HORIZ_ORIGIN_X_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              SVG_HORIZ_ORIGIN_X_DEFAULT_VALUE;
        }
        float horizOriginX;
        try {
            horizOriginX =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              parentFontElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_HORIZ_ORIGIN_X_ATTRIBUTE,
              s });
        }
        s =
          parentFontElement.
            getAttributeNS(
              null,
              SVG_HORIZ_ORIGIN_Y_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            s =
              SVG_HORIZ_ORIGIN_Y_DEFAULT_VALUE;
        }
        float horizOriginY;
        try {
            horizOriginY =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  s) *
                -scale;
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              glyphElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_HORIZ_ORIGIN_Y_ATTRIBUTE,
              s });
        }
        java.awt.geom.Point2D horizOrigin =
          new java.awt.geom.Point2D.Float(
          horizOriginX,
          horizOriginY);
        return new org.apache.batik.gvt.font.Glyph(
          unicode,
          names,
          orientation,
          arabicForm,
          lang,
          horizOrigin,
          vertOrigin,
          horizAdvX,
          vertAdvY,
          glyphCode,
          tpi,
          dShape,
          glyphContentNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AYclPwpXFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IgAA");
}
