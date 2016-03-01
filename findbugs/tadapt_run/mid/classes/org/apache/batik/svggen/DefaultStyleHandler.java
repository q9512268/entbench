package org.apache.batik.svggen;
public class DefaultStyleHandler implements org.apache.batik.svggen.StyleHandler, org.apache.batik.util.SVGConstants {
    static java.util.Map ignoreAttributes = new java.util.HashMap();
    static { java.util.Set textAttributes = new java.util.HashSet();
             textAttributes.add(SVG_FONT_SIZE_ATTRIBUTE);
             textAttributes.add(SVG_FONT_FAMILY_ATTRIBUTE);
             textAttributes.add(SVG_FONT_STYLE_ATTRIBUTE);
             textAttributes.add(SVG_FONT_WEIGHT_ATTRIBUTE);
             ignoreAttributes.put(SVG_RECT_TAG, textAttributes);
             ignoreAttributes.put(SVG_CIRCLE_TAG, textAttributes);
             ignoreAttributes.put(SVG_ELLIPSE_TAG, textAttributes);
             ignoreAttributes.put(SVG_POLYGON_TAG, textAttributes);
             ignoreAttributes.put(SVG_POLYGON_TAG, textAttributes);
             ignoreAttributes.put(SVG_LINE_TAG, textAttributes);
             ignoreAttributes.put(SVG_PATH_TAG, textAttributes); }
    public void setStyle(org.w3c.dom.Element element, java.util.Map styleMap,
                         org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        java.lang.String tagName =
          element.
          getTagName(
            );
        java.util.Iterator iter =
          styleMap.
          keySet(
            ).
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.String styleName =
              (java.lang.String)
                iter.
                next(
                  );
            if (element.
                  getAttributeNS(
                    null,
                    styleName).
                  length(
                    ) ==
                  0) {
                if (appliesTo(
                      styleName,
                      tagName)) {
                    element.
                      setAttributeNS(
                        null,
                        styleName,
                        (java.lang.String)
                          styleMap.
                          get(
                            styleName));
                }
            }
        }
    }
    protected boolean appliesTo(java.lang.String styleName, java.lang.String tagName) {
        java.util.Set s =
          (java.util.Set)
            ignoreAttributes.
            get(
              tagName);
        if (s ==
              null) {
            return true;
        }
        else {
            return !s.
              contains(
                styleName);
        }
    }
    public DefaultStyleHandler() { super(); }
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
       "v54fff8PYn5UDtkkAAA=");
}
