package org.apache.batik.css.engine.value.svg;
public class ShapeRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CRISPEDGES_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          CRISPEDGES_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GEOMETRICPRECISION_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          GEOMETRICPRECISION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_SHAPE_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ShapeRenderingManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
