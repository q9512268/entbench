package org.apache.batik.css.engine.value.svg;
public class StrokeMiterlimitManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_NUMBER_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_MITERLIMIT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_4;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
            default:
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
        }
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (unitType ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              unitType,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                unitType);
    }
    public StrokeMiterlimitManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfWwUxxWfO39/4S8MhA+DwRCZOHehhLSJSRrb2LHp+aMY" +
       "rNYEzNzenG/x3u6yO2efnZImkVpoqyBESUKqQv8hglYEUNU0rdJEpJGa0KSR" +
       "kqKmSRXST5U2pQ1qm/5B2/S92d3bvbXvLFdFPWnn9mbem3nv9968eW/uzFVS" +
       "ZBqkkak8xKd0Zoa6VD5IDZPFOhVqmtuhb1R6ooD+dfeV/juDpHiELEhQs0+i" +
       "JuuWmRIzR8gKWTU5VSVm9jMWQ45Bg5nMmKBc1tQR0iCbvUldkSWZ92kxhgTD" +
       "1IiQWsq5IUdTnPXaE3CyIgKShIUk4Xb/cFuEVEqaPuWSL/GQd3pGkDLprmVy" +
       "UhPZSydoOMVlJRyRTd6WNsgtuqZMjSkaD7E0D+1VNtkQbI1smgHB6vPVH14/" +
       "nKgRENRTVdW4UM/cxkxNmWCxCKl2e7sUljT3kQdJQYRUeIg5aY44i4Zh0TAs" +
       "6mjrUoH0VUxNJTs1oQ53ZirWJRSIk6bsSXRq0KQ9zaCQGWYo5bbughm0XZXR" +
       "1tJyhoqP3RI++sTumm8XkOoRUi2rQyiOBEJwWGQEAGXJKDPM9liMxUZIrQrG" +
       "HmKGTBV52rZ0nSmPqZSnwPwOLNiZ0pkh1nSxAjuCbkZK4pqRUS8uHMr+VRRX" +
       "6BjousjV1dKwG/tBwXIZBDPiFPzOZikcl9UYJyv9HBkdmz8FBMBakmQ8oWWW" +
       "KlQpdJA6y0UUqo6Fh8D11DEgLdLAAQ1OluacFLHWqTROx9goeqSPbtAaAqoy" +
       "AQSycNLgJxMzgZWW+qzksc/V/s2HHlB71CAJgMwxJikofwUwNfqYtrE4Mxjs" +
       "A4uxcn3kcbro+YNBQoC4wUds0Tz7uWv3tjZeeMWiWTYLzUB0L5P4qHQyuuCN" +
       "5Z0tdxagGKW6Zspo/CzNxS4btEfa0jpEmEWZGXEw5Axe2Pajzz70LfZ+kJT3" +
       "kmJJU1JJ8KNaSUvqssKM+5jKDMpZrJeUMTXWKcZ7SQm8R2SVWb0D8bjJeC8p" +
       "VERXsSZ+A0RxmAIhKod3WY1rzrtOeUK8p3VCSAk8pBKem4n1Ed+c6OGElmRh" +
       "KlFVVrXwoKGh/mYYIk4UsE2Eo+D142FTSxnggmHNGAtT8IMEswckE2nHQKbw" +
       "BFVSLGxOCL/SxlmfDD6lyEkIiFQF5zBC6Hn6/2HNNOJQPxkIgImW+wOEAnur" +
       "R1NizBiVjqY6uq6dHX3Vcj7cMDaCnNwNYoQsMUJCjBCIEbLECAkxQiBGKIcY" +
       "JBAQqy9EcSznANOOQ5CAKF3ZMrRr656DqwvAK/XJQrALkq7OOq063UjihP9R" +
       "6Vxd1XTT5Q0vBUlhhNRRiaeogodPuzEGYU0at3d+ZRTOMfc4WeU5TvAcNDSJ" +
       "xSCa5TpW7FlKtQlmYD8nCz0zOIcdbutw7qNmVvnJhWOTDw9//rYgCWafILhk" +
       "EQQ/ZB/EuJ+J783+yDHbvNUHrnx47vH9mhtDso4k5ySdwYk6rPb7hx+eUWn9" +
       "KvrM6PP7mwXsZRDjOQUngPDZ6F8jK0S1OeEedSkFheOakaQKDjkYl/OEoU26" +
       "PcJxa7FpsHwYXcgnoDgp7h7Sj//89T9sFEg6h0q1JxsYYrzNE8hwsjoRsmpd" +
       "j9xuMAZ07x4b/OpjVw/sFO4IFGtmW7AZ204IYGAdQPALr+x7+73LJy8FXRfm" +
       "cJKnopAQpYUuCz+CTwCef+ODwQc7rCBU12lHwlWZUKjjyutc2SAoKhAk0Dma" +
       "d6jghnJcplGF4f75Z/XaDc/86VCNZW4FehxvaZ17Arf/pg7y0Ku7/9EopglI" +
       "eCi7+LlkVqSvd2duNww6hXKkH35zxZMv0+NwZkCcNuVpJkIvEXgQYcBNAovb" +
       "RHu7b+zj2Kw1vT6evY08ydOodPjSB1XDH7xwTUibnX157d5H9TbLiywrwGId" +
       "xG6yjgIcXaRjuzgNMiz2B6oeaiZgstsv9N9fo1y4DsuOwLISBGhzwIDgmc5y" +
       "JZu6qOSdF19atOeNAhLsJuWKRmPdVGw4UgaezswExN20/sl7LTkmS6GpEXiQ" +
       "GQjN6EArrJzdvl1JnQuLTH9v8Xc2nzpxWbilbs2xzDvhOtG2YNNquS2+3prO" +
       "gCU+xXnAyp7TICtypTYiLTv5yNETsYGnNlgJSF12utAF2fDTP/vXa6Fjv7w4" +
       "ywlUxjX9VoVNMMWzZikumXVS9Imsz41W7y448pvvN491zOeQwL7GOY4B/L0S" +
       "lFifO+j7RXn5kT8u3X5PYs884v1KH5z+Kb/Zd+bifeukI0GR4lqhfkZqnM3U" +
       "5gUWFjUY5PIqqok9VWK3rMk4QD0adh08rbYDtPp3ixWYhTdh05VhFT5Rnoc1" +
       "TzAYzjP2GWw+zUk9lJxqAooTiJdwTIn6IztxQDsPpaImHPKYjMgTdq78scE9" +
       "0sHmwd9abnjTLAwWXcPp8KPDb+19TRisFD0kA5PHO8CTPMdVDTYh3AoteSrP" +
       "bHnC++veG//6lactefyJvo+YHTz65Y9Ch45aW8SqhtbMKEi8PFZF5JOuKd8q" +
       "gqP79+f2P3d6/4GgjXsvJyVRTVMYVTN2CWTytYXZKFqybvlS9Q8O1xV0w+br" +
       "JaUpVd6XYr2xbAcsMVNRD6xuAeW6oy01npicBNY7oewT2Gyz3jf/l1EUOzp0" +
       "0d+X7fQY6Tbanrtx/k6fizWPY+/LMyY6YXMvlM12VU5Sjoe34/U4dr8LSfJG" +
       "QbIWnrtsve6aPyS5WPOo/WCesYewmYL0ScbrCuG7OQCZvgGAVONYIzzttlbt" +
       "8wckF2sepb+SZ+xRbL4ICdAY4w4SmWR6xN75+LXL8045KZDt6yfPjsafcc82" +
       "O3ADIKzDsSZ4emwceuYPYS7WPDAdzzP2DWyOZUPYD7FKEC/hpEZkXHh7FLJu" +
       "j1yEnrwBCNXi2Cp4Bmw1B+aPUC7WPCicyTN2FptTFkJbWJymFD6M5b+D0M1z" +
       "XxS49AK40zcKuOXwDNvaD88fuFysPnCCQpCgo/8y1H9yoyTUNqkUirC0LFFl" +
       "hypzh2ZtPow6h4a6xJsQ8Tnfas6Ba8+0xFktpiVDWwb6utIS0zGnFMwvYvNd" +
       "Tiokg0FVKXDHrvMu+M/eKPBxXydtBJPzBz8Xax7w80S4Iii1jHwxLh9vHAq3" +
       "HLxCkddnNxH+/KEgeAebixA8LDN043yz2eLH/wtbpDlZnOMWDkvGJTP+ILAu" +
       "taWzJ6pLF5/Y8ZaokzIXz5WQ98ZTiuLJ17y5W7FusLgslKy0ymxdfP16Dh/P" +
       "XBjC4QOt0OVXFuvvOGmakxWsMpEJIjbjFXvv5WDkpNh68fK8DwnVbDwgFrRe" +
       "yj+D+fyUIIX49tJd46TcpYNFrRcvyd9gdiDB17/rzka+Y2642qEuMaCAFa5j" +
       "mzQdyC7AM77UMJcveWr2NVmFivijycnkU9ZfTaPSuRNb+x+4dsdT1g2bpNDp" +
       "aZylAvJ36x4vU7I25ZzNmau4p+X6gvNla53CIuuGzyub8GjYSuI2bKnvysls" +
       "ztw8vX1y8ws/OVj8JpREO0kA9mz9Ts/fPNZ/Gm1pPWWQFTsjM+sUKO/FXVhb" +
       "y9em7mmN/+UX4r6EWHXN8tz0o9KlU7t+emTJycYgqeglRVAzsfQIKZfNLVPq" +
       "NiZNGCOkSja70iAizCJTJasIWoCbjGISIXCx4azK9OLVKyerZ5Z2My+syxVt" +
       "khkdWkqN4TRQRlW4PZZlfFV/Std9DG6Pp5plVixEa4DXjkb6dN25tyzcoIuQ" +
       "E589NEIbKBWv+Fb2H1YHgQSEHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LiPD3o6qcw3GIAyds4Zbg1EsZU7hO2tlwwzhCU2E1chM6Q79cJyultrG9fCN" +
       "3912uR0M9/p8PxwSG2Rb3zfILFytgoImets03HmL0PH1XT+LZ6hc72ZtFWb8" +
       "nZjC4ZBpT4ajyJG6qNystyerEarPWXQa1LJurduaknlvuFysHY2kXM9H5/5K" +
       "iLGihvEpZqxrDJ7OtW6ADYRG0x6ntiQL1G6Xx5HW5FCP2qJWHXcUHdltti6p" +
       "+fZo2F53OzK8VHAN7iEiRstSe2hss0SRG100WMP+ppvXqbgL9wnP39gTAzO7" +
       "taltiXsu0Zt6TKcpsl1S1rjVKTJ5ltRrdCpbmEbHok9ak4RYbuYrbUCjXqIu" +
       "xnFXrRW7JpU2Eh4xklW9l+sM8IwdN2gs8XE3S3nBVN1lo9PVO+M+r07NPA3S" +
       "0UTPRki+20y0pbLYxcWGnplFc4B4hmLK4G0xTPp0f+018jYexkw6nXCD0bZI" +
       "J/jG0To5KcfInuH0YaOvgBVLo9tpSMYStXBYXRylbWGjGEWYEhndrMOh3Z3y" +
       "lsMhI59YmvPRfEcjBHhLIgs9sRukO4+n/Lif9JZa0y38TFJNWw2bWYEnWyYa" +
       "NVc0vY+5Zq3lB8wGE2rZ0kVzv8tPMJDW8CtzyiednCb4cDVyaXtDcsNGM47Q" +
       "YXON8yycLBVkuEu6aTtPbSHbLfuiJ9KzmVSAeB47S5HrT5ywaDekbt5u9/wk" +
       "odv9RsEY83TaHTGr9gCe1jl7aK6Z2q67WLodi+/FrWWHXYW9XjtpUONOUaNU" +
       "WNZrqrk2YmtSHy3a9n67tuS9O2sJnY0gDXfCqsNO9nvP6osS1QpmVnuO1xV9" +
       "W+8F6gqPWL9lZtJqy4OWjrgd8p2F62kNvkBXxY5tjqS0VghW3yazPep5vEnq" +
       "KT9xkUkRZXM8ZH1l4oxZarWbbXh93+2FGtGvh2Mn1fuK6u74KZpKS431exSL" +
       "q7VGn1+Y4RCvW2iHHTM9jGdnuojzq20L9SKDAyt57GK1WmKMYBixwXucsc7J" +
       "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" +
       "ofiNd/7q9/z9l/+wuiz9f3rfQWGnKQAA");
}
