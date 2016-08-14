package org.apache.batik.css.engine.value.svg;
public class StrokeWidthManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_WIDTH_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_1;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     INHERIT_VALUE;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeWidthManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "O6yR/guDwDJh8hwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
