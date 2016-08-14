package org.apache.batik.svggen;
public class SVGCSSStyler implements org.apache.batik.svggen.SVGSyntax {
    private static final char CSS_PROPERTY_VALUE_SEPARATOR = ':';
    private static final char CSS_RULE_SEPARATOR = ';';
    private static final char SPACE = ' ';
    public static void style(org.w3c.dom.Node node) { org.w3c.dom.NamedNodeMap attributes =
                                                        node.
                                                        getAttributes(
                                                          );
                                                      if (attributes !=
                                                            null) {
                                                          org.w3c.dom.Element element =
                                                            (org.w3c.dom.Element)
                                                              node;
                                                          java.lang.StringBuffer styleAttrBuffer =
                                                            new java.lang.StringBuffer(
                                                            );
                                                          int nAttr =
                                                            attributes.
                                                            getLength(
                                                              );
                                                          java.util.List toBeRemoved =
                                                            new java.util.ArrayList(
                                                            );
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 nAttr;
                                                               i++) {
                                                              org.w3c.dom.Attr attr =
                                                                (org.w3c.dom.Attr)
                                                                  attributes.
                                                                  item(
                                                                    i);
                                                              java.lang.String attrName =
                                                                attr.
                                                                getName(
                                                                  );
                                                              if (org.apache.batik.svggen.SVGStylingAttributes.
                                                                    set.
                                                                    contains(
                                                                      attrName)) {
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      attrName);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      CSS_PROPERTY_VALUE_SEPARATOR);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      attr.
                                                                        getValue(
                                                                          ));
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      CSS_RULE_SEPARATOR);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      SPACE);
                                                                  toBeRemoved.
                                                                    add(
                                                                      attrName);
                                                              }
                                                          }
                                                          if (styleAttrBuffer.
                                                                length(
                                                                  ) >
                                                                0) {
                                                              element.
                                                                setAttributeNS(
                                                                  null,
                                                                  SVG_STYLE_ATTRIBUTE,
                                                                  styleAttrBuffer.
                                                                    toString(
                                                                      ).
                                                                    trim(
                                                                      ));
                                                              int n =
                                                                toBeRemoved.
                                                                size(
                                                                  );
                                                              for (int i =
                                                                     0;
                                                                   i <
                                                                     n;
                                                                   i++) {
                                                                  element.
                                                                    removeAttribute(
                                                                      (java.lang.String)
                                                                        toBeRemoved.
                                                                        get(
                                                                          i));
                                                              }
                                                          }
                                                      }
                                                      org.w3c.dom.NodeList children =
                                                        node.
                                                        getChildNodes(
                                                          );
                                                      int nChildren =
                                                        children.
                                                        getLength(
                                                          );
                                                      for (int i =
                                                             0;
                                                           i <
                                                             nChildren;
                                                           i++) {
                                                          org.w3c.dom.Node child =
                                                            children.
                                                            item(
                                                              i);
                                                          style(
                                                            child);
                                                      }
    }
    public SVGCSSStyler() { super(); }
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
