package org.apache.batik.anim.values;
public class AnimatableNumberOrIdentValue extends org.apache.batik.anim.values.AnimatableNumberValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected boolean numericIdent;
    protected AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        float v,
                                        boolean numericIdent) {
        super(
          target,
          v);
        this.
          numericIdent =
          numericIdent;
    }
    public AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        java.lang.String ident) {
        super(
          target);
        this.
          ident =
          ident;
        this.
          isIdent =
          true;
    }
    public boolean canPace() { return false; }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableNumberOrIdentValue(
          target,
          0.0F,
          numericIdent);
    }
    public java.lang.String getCssText() {
        if (isIdent) {
            return ident;
        }
        if (numericIdent) {
            return java.lang.Integer.
              toString(
                (int)
                  value);
        }
        return super.
          getCssText(
            );
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOrIdentValue)
                result;
        }
        if (to ==
              null) {
            if (isIdent) {
                res.
                  hasChanged =
                  !res.
                     isIdent ||
                    !res.
                       ident.
                    equals(
                      ident);
                res.
                  ident =
                  ident;
                res.
                  isIdent =
                  true;
            }
            else
                if (numericIdent) {
                    res.
                      hasChanged =
                      res.
                        value !=
                        value ||
                        res.
                          isIdent;
                    res.
                      value =
                      value;
                    res.
                      isIdent =
                      false;
                    res.
                      hasChanged =
                      true;
                    res.
                      numericIdent =
                      true;
                }
                else {
                    float oldValue =
                      res.
                        value;
                    super.
                      interpolate(
                        res,
                        to,
                        interpolation,
                        accumulation,
                        multiplier);
                    res.
                      numericIdent =
                      false;
                    if (res.
                          value !=
                          oldValue) {
                        res.
                          hasChanged =
                          true;
                    }
                }
        }
        else {
            org.apache.batik.anim.values.AnimatableNumberOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableNumberOrIdentValue)
                to;
            if (isIdent ||
                  toValue.
                    isIdent ||
                  numericIdent) {
                if (interpolation >=
                      0.5) {
                    if (res.
                          isIdent !=
                          toValue.
                            isIdent ||
                          res.
                            value !=
                          toValue.
                            value ||
                          res.
                            isIdent &&
                          toValue.
                            isIdent &&
                          !toValue.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          toValue.
                            isIdent;
                        res.
                          ident =
                          toValue.
                            ident;
                        res.
                          value =
                          toValue.
                            value;
                        res.
                          numericIdent =
                          toValue.
                            numericIdent;
                        res.
                          hasChanged =
                          true;
                    }
                }
                else {
                    if (res.
                          isIdent !=
                          isIdent ||
                          res.
                            value !=
                          value ||
                          res.
                            isIdent &&
                          isIdent &&
                          !res.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          isIdent;
                        res.
                          ident =
                          ident;
                        res.
                          value =
                          value;
                        res.
                          numericIdent =
                          numericIdent;
                        res.
                          hasChanged =
                          true;
                    }
                }
            }
            else {
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
                res.
                  numericIdent =
                  false;
            }
        }
        return res;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0Za3BU1fnsJiQhJOTBUyABQsDhtStU7dCoFUKQ6JKkJDLT" +
       "TTGcvXs2uXD33su9Z5MFi1VHB/piKMVXK/zo4GApitPWaW2rQ8epj1E7o9Cq" +
       "7aidtlOtlqmMre3Utvb7zrl372MfNB3tztyzd8/5vu987+87Z0+dJ1Nsi7Qz" +
       "ncf4HpPZsR6dD1DLZulujdr2EMyNKPdU0fdueqtvXZTUJMn0MWpvUajNNqlM" +
       "S9tJ0qbqNqe6wuw+xtKIMWAxm1njlKuGniSzVLs3a2qqovItRpohwDZqJUgL" +
       "5dxSUznOeh0CnLQlgJO44CS+PrzclSANimHu8cDn+sC7fSsImfX2sjlpTuyk" +
       "4zSe46oWT6g278pbZKVpaHtGNYPHWJ7HdmpXOCq4PnFFkQo6Hml6/4NDY81C" +
       "BTOorhtciGdvZbahjbN0gjR5sz0ay9q7yS2kKkGm+YA56Uy4m8Zh0zhs6krr" +
       "QQH3jUzPZbsNIQ53KdWYCjLEyeIgEZNaNOuQGRA8A4U67sgukEHaRQVppZRF" +
       "It61Mn7knpuav1tFmpKkSdUHkR0FmOCwSRIUyrIpZtnr02mWTpIWHYw9yCyV" +
       "aupex9KttjqqU54D87tqwcmcySyxp6crsCPIZuUUblgF8TLCoZxfUzIaHQVZ" +
       "Z3uySgk34TwIWK8CY1aGgt85KNW7VD3NycIwRkHGzhsAAFBrs4yPGYWtqnUK" +
       "E6RVuohG9dH4ILiePgqgUwxwQIuTeWWJoq5Nquyio2wEPTIENyCXAGqqUASi" +
       "cDIrDCYogZXmhazks8/5vqsO3qxv1qMkAjynmaIh/9MAqT2EtJVlmMUgDiRi" +
       "w4rE3XT24weihADwrBCwhPnB5y9cu6r9zDMSZn4JmP7UTqbwEeV4avqLC7qX" +
       "r6tCNupMw1bR+AHJRZQNOCtdeRMyzOwCRVyMuYtntj712VtPsneipL6X1CiG" +
       "lsuCH7UoRtZUNWZdx3RmUc7SvWQq09PdYr2X1MJ7QtWZnO3PZGzGe0m1JqZq" +
       "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" +
       "0gkKxkiteMW3uv8AnZk3rfUfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o/6ApibbLO+Ngn6HMga7VnW3nc7cnk0yi2FHofJOne5i2iqpsJ3pbo66G2tK" +
       "KLLbiXBuQi38djAibXhIWiwXbRbhIsEwO+NNb+Z1RT/pqIhCrANaG1CS4MWN" +
       "natUjS62Go4yfLjCVVKWdtsRX2UGI0QbkbiH7DZmrg6bM3uGjhSXJASquaCz" +
       "llXhNQfzaqiihQvajXmZ7vroUJpRXM+orAm7sh1yWLpzTGRYtWEZbq8wL4ZV" +
       "aRGhlIUP6rohGe461ZZai/JrWk9UBtR4E2QVusG5K9nbsmrDmJk9i93qdZOb" +
       "WEGg9qlKhlBkZ6COR8K6tlh064tWTtL2uGsbLFczx7qEdpUZIzQWKT0W8Xm+" +
       "28hxPpvmDo9r5DiNhpQQUMhybFfnWgUOtTFOAgvKyhDJlgwTYVZW71JBf7EN" +
       "DWWsLNVwtybiaBGSiYMtKqs6kdpqd7m1PWIW7TBKYbrmssdqcCPnGot6fdOu" +
       "0Jabqq2N00sReskSNZqtJmbHoT1yAEAXN8KwZZndobztdEl5lU8NRJ0zNXdA" +
       "LZci3A7FILCrs5amDOXYZQZMs2oH9Bbr2Fh728EcJJaSCmJi1BTMalUPk8cE" +
       "LlVEDbVYTelHNWLFTRO96USJv/IEeW1saS3S+NbMn61NhO9snVYybPlUb5vL" +
       "GRM6FNYZYkS/H1hk32jyYa9uz82ku5sPR+tpqCw5oynWxrURPtGtIKnKwqSy" +
       "0hUtr2EGszDIvAuH9YTqx26Nn7d7rmbpfAceNvIpa7EYwXXicXtcj0Ulyjta" +
       "h5lshb66WWtBqz+YLVcqcDh9G0RBHWs2uFSjEXnaxCU+2G2rydIGPjmdUTy/" +
       "HE+UISe2KxUr8AiDRRhiQguCPW31hJk8HPW9ZV3b5mKDYWCdbGEN2BKcTVCN" +
       "FywjDFl3hG3WbDZPR3kekKSmz4lNqNK7xQY3dmKcNfRlReLV7pqqLLR2d0kZ" +
       "MaIMXbcDB+lO7IZZZY3ZAjG31FygJ5tNyFZZv0uqfjd3yVVWUeytQVE9GxPX" +
       "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");
}
