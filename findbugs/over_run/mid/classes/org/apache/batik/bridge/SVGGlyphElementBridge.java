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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nxb89F834dbnshYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kzlXQiIAAA==");
}
