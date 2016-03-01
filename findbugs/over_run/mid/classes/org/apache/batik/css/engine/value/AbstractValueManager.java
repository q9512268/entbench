package org.apache.batik.css.engine.value;
public abstract class AbstractValueManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ValueManager {
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException { throw createDOMException(
                                                    ); }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        throw createDOMException(
                );
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE &&
              value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            return new org.apache.batik.css.engine.value.URIValue(
              value.
                getStringValue(
                  ),
              value.
                getStringValue(
                  ));
        }
        return value;
    }
    public AbstractValueManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PAikGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
