package org.apache.batik.css.engine.value.svg;
public class TextAnchorManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_START_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          START_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MIDDLE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_END_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          END_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_TEXT_ANCHOR_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 START_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextAnchorManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
