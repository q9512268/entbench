package org.apache.batik.css.engine.value.css2;
public class UnicodeBidiManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BIDI_OVERRIDE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BIDI_OVERRIDE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_EMBED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          EMBED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_UNICODE_BIDI_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public UnicodeBidiManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "k+odAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
