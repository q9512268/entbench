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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+KV73jknJbJ92+nxaPw55HGzx6+BCBtwbSY8KVsOqdGLsBBqETGdKrL2HA7f" +
       "94twHcQqpxqrFwU+1qR21eVK6MQ1kNA4XJsBj26zqY9eQoVQi0jhZ0XWXsbh" +
       "J5aEVrAkzShWwe5IaO7I9aoLLwT3wjUQXCOuzUIom/vB0QuuEGoR4bxZZO3X" +
       "OJzhZCwIriMB2RIafmbVld2uMH75vxBGlpNJBS7+sEudnPefhHWPLj17pK5y" +
       "0pG7zolaOXfXXQO1TzKjKN4+yvNerhssKQsWa6yuShdf73Iy+wvdUUIAglHw" +
       "cs5CfZ+TmSOiQnM1kDMkG/E8J1OKIEJzZb14cf4ASXU4HCALRi/kR+D/QUig" +
       "Qnx74T7mpNqFg0OtFy/IJ7A7gODrRd1xnZtGFpdrOLY+syF/B5YzpMaRDMnT" +
       "tM3yVarijy2nlMtYf231SiePrFl37+UvPWXd6EkK3bkTdxkDBZx1b5jrWWYW" +
       "3M3Zq3z1vCtjT1XNdipL342ilzZhzpCNxO1bU+CKy2zN3XS9d3TJS7/aW/42" +
       "1MRbSIhCb7Al//Ygq2egWdwSyy9Uob8Td29t8x4fWrow+df3xf0MybuVCcL3" +
       "SmeP3fPOgclHm8NkTAcpg6KZZcW1xoohdQOTBoweUiubK7NAIuqNKr4qeCx6" +
       "GMUsIuRii7M2N4tXvZy05Nf2+Rfk1Yo2yIzlWkZN4DZQR49xZ5ze1df2ZXQ9" +
       "gODOeNqZrFUqoDbAZHtjnbru3JOWTtBFvBkavnbA8XPxisPV/wKlm+lb9B4A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
