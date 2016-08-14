package org.apache.batik.css.engine.value.svg;
public class DominantBaselineManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ALPHABETIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALPHABETIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CENTRAL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          CENTRAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_HANGING_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          HANGING_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_IDEOGRAPHIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          IDEOGRAPHIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MATHEMATICAL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MATHEMATICAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MIDDLE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                              MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_NO_CHANGE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                 NO_CHANGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_RESET_SIZE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RESET_SIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BEFORE_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BOTTOM_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BOTTOM_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_TOP_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_TOP_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_USE_SCRIPT_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          USE_SCRIPT_VALUE);
    }
    public boolean isInheritedProperty() {
        return false;
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
        return org.apache.batik.util.CSSConstants.
                 CSS_DOMINANT_BASELINE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public DominantBaselineManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "M5z5HQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
