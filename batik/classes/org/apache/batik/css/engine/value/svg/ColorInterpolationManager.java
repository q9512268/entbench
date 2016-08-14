package org.apache.batik.css.engine.value.svg;
public class ColorInterpolationManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LINEARRGB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          LINEARRGB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SRGB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SRGB_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_INTERPOLATION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 SRGB_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ColorInterpolationManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tufjl+5555yUyPadp8ej8eewx80euwYmbMCxOfBstO2wcewmLMRaxEyniow9" +
       "i833/SZcD7HKqcbqRYGPNalddbkWOnENLDQBx2bDE7fVjI/dQoVYi1jhZ0XG" +
       "XsLmJ5aFVrEUzShWwe5YaMHo9apLLwz3/DUwXCOOzYWH2trTsRuuEGsR47xR" +
       "ZOzX2JzhZDwYrjMJ2RIO/MyqK3tcY/zyf2GMLCfTCl794Tl1at5/E9Z9uvTM" +
       "kbrKKUfuPCeq5dyddw1UP6mMonhPUp73ct1gKVkoWWOdq3Tx9Q4n8z7XPSWE" +
       "IGiFNucs1vc4mTMqKxyvBnNQshnPczK9CCMcr6wXL88fIK2OxANiQeul/BAi" +
       "QJASpBDfXrqPOKl26WBR68VL8jHMDiT4elF3nOfG0c3lQsfez2zIfwbLQalx" +
       "NCh5jm1zfbWq+IPLKeYy1l9cvdLJI+vW33P5C09ad3qSQnfuxFnGQQln3Rzm" +
       "Ti1zCs7mzFW+duGV8aeq5jm1pe9O0SubADTkI3H/1hS45DJbc3dd7x5d/uKv" +
       "9pa/BVXxFhKicDrYkn9/kNUzcFzcEssvVeGEJ27f2hY+NrxiSeqv74kbGpJ3" +
       "LxOk75XOHrv77QNTjzaHybhOUgZlM8uKi41Vw+pGJg0acVIrm6uzICLuG1V8" +
       "dfB49DCKeUTYxTZnba4XL3s5acmv7vOvyKsVbYgZK7WMmsRpoJIe5/Y4p1ff" +
       "wS+j6wEGt8dzoMlaxQLuBkC2N9al685NaWmtLiLO8MjVA7afiVdsrv4XedxR" +
       "jvweAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
