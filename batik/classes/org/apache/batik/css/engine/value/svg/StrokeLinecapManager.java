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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "O+ekTLYvOT07Gn8OebbZo9fAhPU41gzPRtsOG0dvwmKsJcx0qsTYM9h832/C" +
       "9RCrnGqsThT4WJPaVZdroRPXwEITcWw2PHFbzfjoLVSMtYQVflZi7EVsfmJZ" +
       "aBVL0YxiFeyOheaPXK+69MJwz10DwzXg2Bx4qK09Hb3hirGWMM7rJcZ+jc0Z" +
       "TiaA4TqSkC3hwM+surLbNcYv/xfGyEKeKHTrh0fUaXn/Q1h359LTw7WVU4fv" +
       "PCcK5dz9dg0UPqmMongPUZ73ct1gKVnoV2MdqXTx9TYncz/T7SREH2iFIucs" +
       "1nc5aR6RFU5WAzkU2YznOZleghFOVtaLl+cPYKlCPCAWtF7KD2DzBylBCvHt" +
       "pfuQk2qXDha1XrwkH8HsQIKvF3Vn39w0srlc1Nj+zIb8x68cihpGQpHnxDbH" +
       "V6aKP7OcOi5j/Z3VI50cXrf+nsufe8K6zpMUunMnzjIOqjfr0jB3YGkuOpsz" +
       "V/naBVcmnKqa65SVvutEr2wCy5CKxNVbY+B+y2zNXXO9c3TZC7/aV/4mFMRb" +
       "SIjCwWBL/tVBVs/ASXFLLL9KhcOduHhrW/Do0PLFqb++Ky5nSN6VTJC+Rzp7" +
       "7O63Dk472hQm4zrIWKiYWVbcaawaUjcyacCIk/GyuToLIqLfqOIrgSfgDqOY" +
       "QoRdbHOOz/XiPS8nLfmFff7teLWiDTJjpZZRkzgNFNHj3B7n4Oo782V0PcDg" +
       "9njOMlmrTkBvAGR7Yp267lySjonqItgMFS4csP1UvGJz9b/DshA76B4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
