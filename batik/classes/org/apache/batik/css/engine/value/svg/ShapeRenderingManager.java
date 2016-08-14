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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
