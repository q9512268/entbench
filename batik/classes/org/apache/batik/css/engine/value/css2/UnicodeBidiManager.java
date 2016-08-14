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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "kuUeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/ugFn3vV7z727eL07/8A7Q3Tf0ApAAA=");
}
