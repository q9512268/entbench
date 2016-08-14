package org.apache.batik.css.engine.value;
public abstract class AbstractValueFactory {
    public abstract java.lang.String getPropertyName();
    protected static java.lang.String resolveURI(org.apache.batik.util.ParsedURL base,
                                                 java.lang.String value) {
        return new org.apache.batik.util.ParsedURL(
          base,
          value).
          toString(
            );
    }
    protected org.w3c.dom.DOMException createInvalidIdentifierDOMException(java.lang.String ident) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        ident };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.identifier",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            SYNTAX_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidLexicalUnitDOMException(short type) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          type) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.lexical.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidFloatTypeDOMException(short t) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          t) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.float.type",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidFloatValueDOMException(float f) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Float(
          f) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.float.value",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidStringTypeDOMException(short t) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          t) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.string.type",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createMalformedLexicalUnitDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "malformed.lexical.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.access",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    public AbstractValueFactory() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1pmCDo5mzxCgLCgXr/hW8W+wbKGVJh8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3f8FJK5AokIqAAA=");
}
