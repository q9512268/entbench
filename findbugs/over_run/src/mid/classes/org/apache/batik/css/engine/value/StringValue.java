package org.apache.batik.css.engine.value;
public class StringValue extends org.apache.batik.css.engine.value.AbstractValue {
    public static java.lang.String getCssText(short type, java.lang.String value) {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return "url(" +
                value +
                ')';
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_STRING:
                char q =
                  value.
                  indexOf(
                    '\"') !=
                  -1
                  ? '\''
                  : '\"';
                return q +
                value +
                q;
        }
        return value;
    }
    protected java.lang.String value;
    protected short unitType;
    public StringValue(short type, java.lang.String s) { super();
                                                         unitType =
                                                           type;
                                                         value = s;
    }
    public short getPrimitiveType() { return unitType; }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        !(obj instanceof org.apache.batik.css.engine.value.StringValue)) {
                                                      return false;
                                                  }
                                                  org.apache.batik.css.engine.value.StringValue v =
                                                    (org.apache.batik.css.engine.value.StringValue)
                                                      obj;
                                                  if (unitType !=
                                                        v.
                                                          unitType) {
                                                      return false;
                                                  }
                                                  return value.
                                                    equals(
                                                      v.
                                                        value);
    }
    public java.lang.String getCssText() {
        return getCssText(
                 unitType,
                 value);
    }
    public java.lang.String getStringValue()
          throws org.w3c.dom.DOMException {
        return value;
    }
    public java.lang.String toString() { return getCssText(
                                                  );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "kmle11kSuM7q6f8AIzN0ZhgdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
