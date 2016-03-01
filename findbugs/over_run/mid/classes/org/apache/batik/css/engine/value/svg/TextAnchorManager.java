package org.apache.batik.css.engine.value.svg;
public class TextAnchorManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_START_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          START_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MIDDLE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_END_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          END_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_TEXT_ANCHOR_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 START_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextAnchorManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9WcjoP1y/+QxnL32PNSc6vY80JysByBfUBf5u89hy2sKK78FPG88xJY3nseW" +
       "C1CZeWvJ8kiZXiuSN5ZjclsE3eUFbgSkVEDUdyksw9UISGI4olV29gQoLhec" +
       "sGR+RQRVnn9t2od+wJf20Fak9SLp7h2ieVPnebLsMr0AMOaO2kHroFq8UzcR" +
       "vsh+V5H0i2RwJO6rtpZ07Qh3OBBtA7e5trVaR/JfLT2+GKBDOc8J+cT/WUjg" +
       "0feeNEa5INp979+//ws/9dhXgNuR0B2lMYC3nepxEhcfAO/61Ide9x3PfPW9" +
       "JagCRJ1+uH/1rUWr7AtT9cFC1UUZs1BiGNEl9ilyqe0tZ9s0MGywXOwOo1v4" +
       "6fu/Yn78a5/eR67np9Y5YuU9z/zE/xy875mLp74XHrsuZD/Ns/9mKIV+2aGF" +
       "A+iRW/VScgz+4bNP/9bPP/3uvVT3n41+++Dj7tN//l9fOPjoV//wBgHU7Zb7" +
       "IgY2uvfzo0ZIdI9+NCcotYRNU1tlKtO826DVdZ+eDIdpOB5XWqxJzoS+t+3R" +
       "81EeGQjOjaeWPYk3FTRe8516TajlvUyKNdEYzA1/opkW2YcNp9qVDIJ3lxPW" +
       "5RY7jzAmRH8mMzxGstVs3iHtDB9M07Hj8fVmruRKS6GVwOQtPgpS8C3REoLW" +
       "aNNq7Wx4KDSbuoQg+MaI2XUnYjrjaNSBxVzd5rycUq4VMNFmvZwZ0+m2Zq7q" +
       "210TFltVvkKTvpKO/J024rPFYr5YditbRRyHbJZQ80kHXxBp2hlGfbLjzjyf" +
       "MHRkuPW78tI3ZmMiRri1O5tv6ImIT7jtYsumtr82RRztVtVkZmWbrjezqvHM" +
       "bM6a+pCdLDoDk8m15mgzCWWX7QgVxuQQl0MaeFddcOQMJ7ih48zNCcXRnMh3" +
       "cNY3VGGsw1ZrKU7opV1l3DbdmnU4dUfma2UhywlNt7rhGF0Efrc9WwnD4QLP" +
       "+qJfn2/nJNlc7WYTBBPwfg3pc1N2FHrx0MUm3RbmcVaFwv2FOo/nVd/a6c2o" +
       "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");
}
