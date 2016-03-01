package org.apache.batik.css.engine.value.svg;
public class StrokeLinecapManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BUTT_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BUTT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ROUND_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SQUARE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SQUARE_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_LINECAP_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 BUTT_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public StrokeLinecapManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gC/8KH8JkP7hHZ975Hef+nZ+c/d/6KIUlRspAAA=");
}
