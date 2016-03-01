package org.apache.batik.css.engine.value.svg;
public class AlignmentBaselineManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ALPHABETIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALPHABETIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BASELINE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BASELINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BEFORE_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_HANGING_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          HANGING_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_IDEOGRAPHIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          IDEOGRAPHIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MATHEMATICAL_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                    MATHEMATICAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MIDDLE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                              MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BEFORE_EDGE_VALUE);
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
                 CSS_ALIGNMENT_BASELINE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public AlignmentBaselineManager() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+/0dAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
