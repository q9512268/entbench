package org.apache.batik.css.engine.value.svg;
public class StrokeLinejoinManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_MITER_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MITER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ROUND_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BEVEL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BEVEL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_LINEJOIN_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 MITER_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public StrokeLinejoinManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "H93+2Ud+96lvZUd//we2YzC3QykAAA==");
}
