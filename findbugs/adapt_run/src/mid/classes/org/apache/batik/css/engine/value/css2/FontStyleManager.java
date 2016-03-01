package org.apache.batik.css.engine.value.css2;
public class FontStyleManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ITALIC_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ITALIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OBLIQUE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OBLIQUE_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_STYLE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontStyleManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
