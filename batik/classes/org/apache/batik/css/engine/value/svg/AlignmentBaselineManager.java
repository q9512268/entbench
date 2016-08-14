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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TPgeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a2rHRestG+82ymMK9zaVpTyuM70pwyzKNdCtJbRjc7HKzo2aanm1lWI0G3g5" +
       "IsKSErUBLrNuN9SKQhMzBsumZQ28tNOVi2upkoJZItQk3iguQo1UCX827NhO" +
       "CYtIdlEyuQgu/S3W33ar5bTOeWUCZWKlaAjzUr0oECQHllEEvbV2hujUDsrB" +
       "RKyF9RAdmyGPFzG+3hE0wWU3a3WjecZKwYCkFVjO6IFKfbySRw17sw10IlV1" +
       "ZWTY9gr1x15n1OlU8ID1QrU94/ABpk1rcqFLVcWKpWtirVADK0VK0KUSjBOe" +
       "EgrWpjUeSMMwGijLkZhEwqCn05w2C4EzaUw6EwmHC5hM41G/7/mr1qpVi2Rc" +
       "stXNcGP7lINFfRRjxNoUUC0HtC1hsHT5MUXXYhVPmmsUlfFaG4/7fcnD3FF3" +
       "iIv6otCwqOKgJtpEtdIiJD1djDm5LLTZRjHGaAJbLkaFDRyFAT/SVfjP99XZ" +
       "X2Ltme1K3JJvwByeFJo2mTWMn8G/8V3TvVnxwOFmV/45d5WN9GObjUi2w3DX" +
       "lQ4A892FD7/58SeU4Ufws/ubtCJAbgCe/wvQvap9TNR5KOkVV95J6efnn0eb" +
       "h19487/eyT+8evQZHI+89JSep0X+fv9jX2q/TH7XWeSaw63Ep5zMnmR66OQG" +
       "4o2BCqLA5U9sI9516NnbMo+9DD70vmfpyx9RXDYKzuRRsBv7q+yBv+Eqbb+S" +
       "FTFAbjNCxl2pgQFUZRR4+Vl3zvDaYwHzKEDOS55nq6J7FEzJ023tHO8yrwAn" +
       "rc82Ttl969nn3vq3X6XtN7PiLQB5gQGzC8MRQXZ4cWB+1vbGIzvf+mztfAA+" +
       "3L6d3HNv5/uu0vaBrHgXQG41sosP+VbfFax897Ow8kJWeTd8hH0rhefeyt+5" +
       "SttHsuIJgFzQVXBg3uHZ4Kk4vsbYv5GSW/3bz8LqW7PKe+Ej7VstPfdWf/oq" +
       "bZ/Jio+ftHqwjz/jIxM/8SxMzJeAe+Bj7ptoPvcmfv4qbU9mxR/vTGyqmhjZ" +
       "uyOfg2OFlz/9scgRfe6NP3kW3nhhVnl/7oDdZ/3ce+MrV2n7alZ8ASA3Q28w" +
       "iuqC7OBhd/+oc2ThF5+JhQlA7rjSvYbsYPaOp9y62t0Ukj/xxIXrX/TE9G/z" +
       "o/3D2zw3sMj1WmTbx8/Rjr2f8wNVM3Jbbtidqvn5118D5IGf6Q4GnL6wzK34" +
       "+o71GwC592lZwf6x0HHGfwDIi6/CCJBzu5fjPN+EC8bleKBasDxO+U8AuXia" +
       "EmqRfx+n+w5Abjyig53uXo6TfBdKhyTZ6/f8g8AvPb27jiJkfzyTMyeTtcOI" +
       "ufXpIuZYfnf/iawsv7p3kEFFu8t7j8iffKI7eP2PiI/srk/ItrjdZlKuZ5Hz" +
       "u5sch1nYvVeUdiDrXOfBn9z8qRseOMgYb94pfDTRjun20svfT6AdH+Q3CrZ/" +
       "9KLPvOp3n/hmfgL4f8Id1dZTKQAA");
}
