package org.apache.batik.css.engine.value.svg12;
public class TextAlignManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.SVG12CSSConstants.CSS_START_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          START_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.CSS_MIDDLE_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          MIDDLE_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.
                          CSS_END_VALUE, org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                                           END_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.
                          CSS_FULL_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          FULL_VALUE); }
    public boolean isInheritedProperty() {
        return true;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.SVG12CSSConstants.
                 CSS_TEXT_ALIGN_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 INHERIT_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextAlignManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
