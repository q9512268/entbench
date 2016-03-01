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
