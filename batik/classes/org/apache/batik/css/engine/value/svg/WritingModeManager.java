package org.apache.batik.css.engine.value.svg;
public class WritingModeManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_LR_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                           LR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LR_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          LR_TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RL_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RL_TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TB_RL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TB_RL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_WRITING_MODE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 LR_TB_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public WritingModeManager() { super(); }
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
       "+HFxjyD7o+d95pW/+9g3i3O//wMWNQYaNykAAA==");
}
