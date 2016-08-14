package org.apache.batik.css.engine.value.svg;
public class ColorRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZEQUALITY_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZEQUALITY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ColorRenderingManager() { super(
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
      ("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" +
       "jxKkf3T7Zx/53ae+lW/9/R9irUFRQykAAA==");
}
