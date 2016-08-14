package org.apache.batik.anim.values;
public class AnimatableAngleValue extends org.apache.batik.anim.values.AnimatableNumberValue {
    protected static final java.lang.String[] UNITS = { "", "", "deg", "rad",
    "grad" };
    protected short unit;
    public AnimatableAngleValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableAngleValue(org.apache.batik.dom.anim.AnimationTarget target,
                                float v,
                                short unit) { super(target,
                                                    v);
                                              this.unit =
                                                unit; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableAngleValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableAngleValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableAngleValue)
                result;
        }
        float v =
          value;
        short u =
          unit;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableAngleValue toAngle =
              (org.apache.batik.anim.values.AnimatableAngleValue)
                to;
            if (toAngle.
                  unit !=
                  u) {
                v =
                  rad(
                    v,
                    u);
                v +=
                  interpolation *
                    (rad(
                       toAngle.
                         value,
                       toAngle.
                         unit) -
                       v);
                u =
                  org.w3c.dom.svg.SVGAngle.
                    SVG_ANGLETYPE_RAD;
            }
            else {
                v +=
                  interpolation *
                    (toAngle.
                       value -
                       v);
            }
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableAngleValue accAngle =
              (org.apache.batik.anim.values.AnimatableAngleValue)
                accumulation;
            if (accAngle.
                  unit !=
                  u) {
                v +=
                  multiplier *
                    rad(
                      accAngle.
                        value,
                      accAngle.
                        unit);
                u =
                  org.w3c.dom.svg.SVGAngle.
                    SVG_ANGLETYPE_RAD;
            }
            else {
                v +=
                  multiplier *
                    accAngle.
                      value;
            }
        }
        if (res.
              value !=
              v ||
              res.
                unit !=
              u) {
            res.
              value =
              v;
            res.
              unit =
              u;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public short getUnit() { return unit;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableAngleValue o =
          (org.apache.batik.anim.values.AnimatableAngleValue)
            other;
        return java.lang.Math.
          abs(
            rad(
              value,
              unit) -
              rad(
                o.
                  value,
                o.
                  unit));
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableAngleValue(
          target,
          0,
          org.w3c.dom.svg.SVGAngle.
            SVG_ANGLETYPE_UNSPECIFIED);
    }
    public java.lang.String getCssText() {
        return super.
          getCssText(
            ) +
        UNITS[unit];
    }
    public static float rad(float v, short unit) {
        switch (unit) {
            case org.w3c.dom.svg.SVGAngle.
                   SVG_ANGLETYPE_RAD:
                return v;
            case org.w3c.dom.svg.SVGAngle.
                   SVG_ANGLETYPE_GRAD:
                return (float)
                         java.lang.Math.
                           PI *
                  v /
                  200;
            default:
                return (float)
                         java.lang.Math.
                           PI *
                  v /
                  180;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZeZBUxRnvmT1Y9t7llGO5FiwOZ8B4lFkvWBdZnF222IUK" +
       "i7r0vunZffDmvcd7PbsDSlTKFCRWLGLwLN0/EgxooVhWzKmGhIpHaUxEojGW" +
       "kMMyJoZEKommJIn5vu735h1zICnJVL2eN939fd3f9fu+7jl4klTYFmlhOo/x" +
       "bSazYx0676GWzZLtGrXtPugbUO4to3+78b3uy6Kksp/UD1O7S6E2W6kyLWn3" +
       "k5mqbnOqK8zuZiyJFD0Ws5k1Qrlq6P1kkmp3pk1NVVTeZSQZTlhPrQRpopxb" +
       "6mCGs06HASczE7CTuNhJfHl4uC1BahXD3OZNn+qb3u4bwZlpby2bk8bEZjpC" +
       "4xmuavGEavO2rEUWm4a2bUgzeIxleWyzdrGjgtWJi/NUMPeJhg9P7xluFCqY" +
       "QHXd4EI8ey2zDW2EJROkwevt0Fja3kq+SMoSpMY3mZPWhLtoHBaNw6KutN4s" +
       "2H0d0zPpdkOIw11OlaaCG+JkTpCJSS2adtj0iD0DhyruyC6IQdrZOWmllHki" +
       "3r04vvfeGxufLCMN/aRB1XtxOwpsgsMi/aBQlh5klr08mWTJftKkg7F7maVS" +
       "Td3uWLrZVod0yjNgflct2JkxmSXW9HQFdgTZrIzCDSsnXko4lPOrIqXRIZB1" +
       "sierlHAl9oOA1SpszEpR8DuHpHyLqic5mRWmyMnYeh1MANJxacaHjdxS5TqF" +
       "DtIsXUSj+lC8F1xPH4KpFQY4oMXJtKJMUdcmVbbQITaAHhma1yOHYNZ4oQgk" +
       "4WRSeJrgBFaaFrKSzz4nuy+/8yZ9lR4lEdhzkika7r8GiFpCRGtZilkM4kAS" +
       "1i5K3EMnP7M7SghMnhSaLOd89+ZTVy9pOfyCnDO9wJw1g5uZwgeUfYP1r85o" +
       "X3hZGW6jyjRsFY0fkFxEWY8z0pY1AWEm5zjiYMwdPLz2uQ23Psrej5LqTlKp" +
       "GFomDX7UpBhpU9WYdS3TmUU5S3aS8UxPtovxTjIO3hOqzmTvmlTKZryTlGui" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e/Dr2FmY7u8+dvdms/fu5rUs+7jJ3oRsHH6SLcu2ehMS" +
       "W7Zky5IlW7JlKyQ3siRLsp7Ww5KdLJBMaFJ2JmTohqYzsH+FPphNAplmYGCg" +
       "y3RKYEKZITBQOtNsCnRKSTPN/lFgmhZ6JP/e93dvsiRTz+j46JzvnPO9v++c" +
       "oxe/CV2OQqgU+M7GcPx4X8/i/aWD7cebQI/2aQbjlTDSNcJRokgEbbfVt/zS" +
       "tb/+9qfM63vQFRl6neJ5fqzElu9FIz3ynbWuMdC149aOo7tRDF1nlspagZPY" +
       "cmDGiuJbDPSaE0Nj6CZziAIMUIABCnCBAtw8hgKDXqt7iUvkIxQvjlbQj0EX" +
       "GOhKoOboxdCbT08SKKHiHkzDFxSAGe7P3yeAqGJwFkI3jmjf0XwHwZ8uwc//" +
       "sw9c/+JF6JoMXbM8IUdHBUjEYBEZetDV3bkeRk1N0zUZetjTdU3QQ0txrG2B" +
       "tww9ElmGp8RJqB8xKW9MAj0s1jzm3INqTluYqLEfHpG3sHRHO3y7vHAUA9D6" +
       "xmNadxSSeTsg8KoFEAsXiqofDrlkW54WQ0+dHXFE480+AABD73P12PSPlrrk" +
       "KaABemQnO0fxDFiIQ8szAOhlPwGrxNBjd50053WgqLZi6Ldj6NGzcPyuC0A9" +
       "UDAiHxJDbzgLVswEpPTYGSmdkM83B+/65Ie8rrdX4KzpqpPjfz8Y9OSZQSN9" +
       "oYe6p+q7gQ++g/lZ5Y2/8Yk9CALAbzgDvIP5lQ+/8t53PvnS7+xgfvAcGG6+" +
       "1NX4tvrZ+UN/8DjxDH4xR+P+wI+sXPinKC/Unz/ouZUFwPLeeDRj3rl/2PnS" +
       "6LdnP/GL+jf2oKs96IrqO4kL9Ohh1XcDy9FDSvf0UIl1rQc9oHsaUfT3oPtA" +
       "nbE8fdfKLRaRHvegS07RdMUv3gGLFmCKnEX3gbrlLfzDeqDEZlHPAgiC7gMP" +
       "9CB4noJ2v+I/hjTY9F0dVlTFszwf5kM/pz+CdS+eA96a8BxovQ1HfhICFYT9" +
       "0IAVoAemftABhrnwWnGSwrgtV4mVuaM3PcMBZgla93NtC/4/rZPl9F5PL1wA" +
       "onj8rCNwgA11fUfTw9vq80mr88rnb39l78gwDjgVQ2Ww9P5u6f1i6f186f3d" +
       "0vvnLQ1duFCs+PochZ3ggdhs4ACAa3zwGeH99Ac/8ZaLQOOC9BLg+R4Ahe/u" +
       "oYljl9ErHKMK9BZ66TPpRyY/juxBe6ddbY42aLqaD+dzB3nkCG+eNbHz5r32" +
       "8b/86y/87LP+sbGd8t0HPuDOkbkNv+Usg0Nf1TXgFY+nf8cN5Uu3f+PZm3vQ" +
       "JeAYgDOMFaC8wM88eXaNU7Z869Av5rRcBgQv/NBVnLzr0Jldjc3QT49bCsk/" +
       "VNQfBjx+zaGGIwfaXvznva8L8vL1O03JhXaGisLvvlsIfv4//v5/Rwt2H7ro" +
       "ayeCnqDHt064hXyya4UDePhYB8RQ1wHcf/4M/08//c2Pv69QAADx9HkL3sxL" +
       "ArgDIELA5p/8ndWfvvy1z/7R3pHSXIhBXEzmjqVmR0Tm7dDVexAJVnvbMT7A" +
       "rTjA5HKtuTn2XF+zFlauyLmW/p9rby1/6X988vpODxzQcqhG7/zOExy3/0AL" +
       "+omvfOBvniymuaDmYe2YZ8dgO1/5uuOZm2GobHI8so989Yl//mXl54HXBZ4u" +
       "srZ64bwu7HhQUP6GGHrmDhPVfHdnpjv7BGuISmjocSFmuBj3jqLcz1lUzAYV" +
       "fWhePBWdNJfTFnkiYbmtfuqPvvXaybd+85WCvtMZz0ntYJXg1k4h8+JGBqZ/" +
       "01nf0FUiE8BVXxr86HXnpW+DGWUwowp8X8SFwEdlp3TpAPryff/pt/7dGz/4" +
       "BxehPRK66viKRiqFWUIPAHvQIxO4tyx4z3t36pDeD4rrBanQHcQXDY/daTD1" +
       "A12qn28wefnmvHjrnWp4t6Fn2H+xwOBi/ooAzjxzj2Q1tFxgX+uDAA8/+8jL" +
       "9s/95ed2wftsNnAGWP/E8z/19/uffH7vRMr09B1Zy8kxu7SpoPO1O+L+Hvwu" +
       "gOfv8icnKm/Yhc1HiIPYfeMoeAdBLug33wutYgnyv33h2V//V89+fEfGI6cz" +
       "hg5IiD/3x//39/Y/8/XfPSc4AV/kK7tMuZkXnZ0cKdADhB/u9P2999B3Li9u" +
       "FV3VvHjXboL6d6UzO9hHi7fL9xYdmSe5x4Hg0f/NOfOP/tnf3mE4Rfw6R5pn" +
       "xsvwiz/3GPEj3yjGHweSfPST2Z2xHmwIjsdWftH9X3tvufLv96D7ZOi6erDb" +
       "KCI3cM8yyLCjwy0I2JGc6j+dLe9Sw1tHgfLxs+p0YtmzIexYjKCeQ+f1q2ei" +
       "1g/mXL4CnrcdWNLNs0Z4ASoqs50dFuXNvPihnU3F0ANB6McASx2o+5Wo2Nrk" +
       "WmN5ilMs1gFv40FPFID43np38RUOeWdIL/yLp3//x194+r8UHup+KwJENkPj" +
       "nBz+xJhvvfjyN7762ic+X8T9S3Ml2pF7dvNz597m1JalQPjBI+68PmfGY3kc" +
       "OODOhZ0p3r7TFP/RjVWiRNYqAbx4+y5s3tgx40bBihu7jc/73n+D5dqd24Mm" +
       "2xFuvPuGp6cHPR9S3Pmz79vf33//rWdyuz4IPNcLj5wrw/4O7shETkYoMS+0" +
       "Q1lZ58tqL6++PS9uHwrmiqN7RmyeZ90XAafyqnqAS77k3kE2eYDb645xIxzf" +
       "0/PIfNi3y0wtf/9oJws6szuQD6F33F0l2EIyx2b15Y/+1WPij5gffBUp6VNn" +
       "NObslP+affF3qbepP7MHXTwysju2uacH3TptWldDHezLPfGUgT2xk0fBvxMB" +
       "rODwPVzlh+/R92N5sQG2pOas3knmHuAfyaDj8Fn4Xfk7+V3xSO8fylt/ADyl" +
       "A70v3cUrfOx8TbuQV99/qGSXEs8qVKl/BqOf/I4Y7VTyAkhFL1f26/tI/v7c" +
       "XTzRkXZ/4JSKv2npqDcP7XWihxFQmJtLp553L84g1PmuEQKK+9Cx9jO+Z9x6" +
       "7i8+9Xs//fTLwGnR0OVi7wb074T5DpL8lOcfv/jpJ17z/NefK/JswKnJP/nl" +
       "+tfzWX/m1ZH1WE6WUGxdGSWK2SI11rWcsvOs+RJQGuMfTG187S+61ajXPPwx" +
       "ZVmXW+Ns5K1dsTzD47rjUByIwCknN1pVh7TXUkuTPbJSqfTGfaseIuvEkxeL" +
       "trtWtTo/j9qCI/ZJYiQxFJMyAwTuGJnvT0xp23cpsxd0lXHW8ZeUZLPshvbl" +
       "Tt93XbrnYeukjmJmedsjPHrCVPQBjuILDV3gi6RUXzpV2xFnpOuYnA9nc0HZ" +
       "zjKkVq9R0lZmYiqcxnxizMdcNfbRUr0xR5NNrW9HATxul7m6UOtUpJq9YSQP" +
       "tTF3Nfe4Vb+xTWRrQ5NtRIowuzwMnVWNL9u2G6CBXR5MJqIuC0NZdEw+HI4C" +
       "P8jmNZegIqTWbQrqtlMnxGRg0ouuU02Icksxp22UkwdeaQVWr85T2Qnmm8rc" +
       "bsw78jIgqpmbKGuqo6y5StgZS25VqczHxlbvZY4ubbZaSC2NWKIteDBmeZ02" +
       "DZyvZ05CEqvZsDvVqp1eQ99Utm2p0qFHnJ3q6xghlwpqr0oC6wsBO0NdmZdM" +
       "Jva7LWWQ1vpJPKhGlS6iIVs+0Gyul5bLnKMoBFWibTEgaEGoKFq8RKw20jY3" +
       "YbIhar2hFsqc5DpO17bQEKmu1wudypIFQ7ADWBm1ytM449IgMiLWgpXW0DEx" +
       "2wmRhiuJ9CLu20adrLvKRBA1NJGYUJ74GrJZDoyFo8YV2s5cYSrh3SGpGaIc" +
       "9rZEW4i8qe1XHZ4Le6vpqCe3ypGlh0636eA+1ywLQbTtBKNGO+kG3Q2zslTM" +
       "HUnuhvVmullmmwM6U1Slu9QyARNXZDvuRdOxsCw5RIMsZ3y32g/I4azqs1M6" +
       "7tPsWFPdyXw+7IlKs2u6SnnDdWcDueoPDbsqjQSdDo0WqShk2Be226qXbEpw" +
       "YyPjzqjqdDRza1u2Ug8blEUGxIiKZcux2ardFMoW1kc7rMfX2bpgmKxnCgrD" +
       "aQ28JIuTDR5wiw3htTk8pdOygSVyaujjxYwvhw3Mn6KmTEm15WY5isgZsrDJ" +
       "rCPNGlskmJWbUsfFtktrxqYaz2wrybCC8lGoLzFmJTr9gCJ9tz2tj4OWGYxx" +
       "aaYJqOiOx5iAKkJjnPGxv87EZY9DTW61dcW1C+xTDjeiQyXWCu8N1whJ9iWi" +
       "1V+tKK084Sm9VhcWbqqzJcWkW1mDbik6NRuVRt2FR4jLFFGUTHEIbTJGq8uK" +
       "ZCyYuTom1KHWjtVuOlx3MQZtzzZkaBooQ1BVU2zMaANrIoS09PEhI3CEhJRF" +
       "0VDLsZMuEKsZ+aJOoe685OFz2g9TcWSxI5aVWLbV8jsdLmwTKB02SWdekcms" +
       "5nVb5Zog+kqrKll9uyKlWidNuqMBk6HtwCXT2sQ1g47v9khhYZEr0UylbJ67" +
       "N0OKpnhcS3XgLRJpaqi67HO60SAc3mst6VFSVQUmHPL9nq7U6nOem9cjgRbG" +
       "NGJsJ1OLUgJz5jhxu0l6fbCrWCmpao5QN5iFs/VEIrgo3ZD0kAqs1Zg1kWTC" +
       "qr2ozmm275fabsNIZY4nEWTZgmW+jVdRPV7XpGDSEdrSrDtleoTRRGk9a4sq" +
       "vtQoWyGHXjrXQhStKmRdMw2dN0RhKUdOY2OOzNAxvdQKZaQlD+ioNFi02aWj" +
       "mPiaaqJYRqybHST2xSnBtng3XTv9TjQh6HQTtsWJyi4nqjhexH42ChG1qmCD" +
       "qpeayVhnKWzS84bsGF3a1UokI5Y3WuMMIZBCazLFaZ+H9dWERzFuNVgP+kal" +
       "pK6IaUOcLWyL2so+KYtyfY47LpvON2i9tMZKMeJpFWTMG9EWMydK1JrONbuZ" +
       "sgTll8bRet5FtxlP4lmth/FVPBU4SR4qVi9a2mYk42MnawoTZ23Uh/pw3OTG" +
       "wz4eTBW9vaj5ASmxfLMUL9oLbsovph6XJU63shxW6+HIXrLbBh/yEkImC92j" +
       "lmW/41YtwtWWoitqg3QddZbwYLOpAf0FEqlU69yax7GS2bQJo+VJOMq1BhgV" +
       "NGsdjGQxSba6fdteMjJJDo1VhIz1uKcqpCs0JK0Tk3pGrYRuczlL0s2cm89h" +
       "r0mPVsI6M4Mhbm7rPlXHW42S3ln3SGsrwBo6GkUIUqPbMyaKWiXBXHITh6xT" +
       "nKxpzLJesudxg/KMSrOhkrNWqFcRMqL9QYnubZMKo4Yo3pD5vjtpxD2NkIKy" +
       "sVGmHYeUaCbrNGG2a8idbRBMpwKqzebDvmvPzH5ki/yq0RbFfhgxnTpizaZY" +
       "7JXWgrdYe1u40u2aTk02WJGFMQsro3xXSJdUt77wZgwL4jPVt3vDRLLEyrSq" +
       "4oxh2M3hfIayFaMt9ePAYpFRgNWwiNLFKEzKWFaWV1g2NTptzkWHBhxPy/NK" +
       "VpLGoxKpzNp1VidrXma0K167tU0GYx+oQItrYVu4WuVr2RCfkVu9zKlirz7B" +
       "KjM6DMnUZLqW0mw2RuiArs8apQG2HPutFB8pyrY7X8P5rltcoxuPkGi91lgT" +
       "oShueGZK2NzAqVSTretMzM64D+Opwqp8u7Sd0dPFpEtsZ1zSbDTiZQijVUyL" +
       "8fXUyoZUSiRUIHpzLqS4TmuDtAMhoJISyrcRL1E2jtzqc7YzGTk6KgOTRKKG" +
       "qHjDOlsytk5ZbVhpDVYpQxGtPoM0w1mEr0bUHJYA3vWZHA0nk7k+WHc9c5UZ" +
       "lYlNTC2jUq5a5rbCiz3N0Rtiiep3FYQrJ7q3imHZEFddtNvBHSb1a7hWitb4" +
       "tB57E3Llm0yJrPXl0rozm6O8W1+U5JanGFUC+GKLqcKLdRs48/J0bcH+WhP4" +
       "ch+V4V5P2Fg6j0d0F4FLve0KbSiywNY2+sDyOJvUxyY9GJU4di7Xl/Z0GVZa" +
       "DZ0YiXQVrnh9ByRiaZu3pPZI1RaRusLSjtdIVmxNsqaCZ0gc255QkdIgWp11" +
       "ZFXr07rARIzTHJqGV0VQpsq0mNYSBNzZess2FGrlsLHDrbxkkTJhk7Vrdb9e" +
       "QldtcstiaoulJ8ZcwMUpD6vLEhbGvOCrfouumH6JaMGTaV8qeV6rK1pSrNIY" +
       "HSxQetCwqmVcwathXN0OSrVyb16WVu0FsEgiS+X1dLTotlMQKbu1yqzE+CGl" +
       "+iODxmptE0YbEbo1LKJWqSTtDhEP2aXQL/uTRQfrdLVBpyxw/RU+ICbWZImL" +
       "22bd2ZICv9YXrQg3MqTUs+peaz6bqkMKNxTWizViWlOdJju2XDqeVZZzDokj" +
       "rhz5xIifOinXrXhNwUtqhI1MXDKM0U7fMdFGDZ817HJ7g29RZcZPaWSOGWOF" +
       "qlDKsjx2VMM3JFpN/VTtzvEFyJnX6zitxRy9blOwUvY4smqGuGcIjaSf1PtV" +
       "BWms4QGPwKukO8CAh9RTSejE5sQuId40zUCc7Hc1MptLQtZ3G7WaYYwn0dBT" +
       "/DhbclLXzpBGtTczFybiSPx01aA5HYTMEOQgfX4yIXqxlLQpFCM5HTYmm14D" +
       "aVcIsVPBPEEN3JWDhH0c03qbGG7KVsMbDOnWcDAYLlEntBICK9X5HvCMsIjU" +
       "ZJAoVMhRfTBW5AruzfyRExCVSOsvWyiBGU2vWiL8mK2TnXGDWWJpyCgtRrXV" +
       "8WItK/3OTLFj0SOHjV64bPj+bOVFU7dvl1Z23+ciEd/itJjFC05VlQ7fwdZe" +
       "inKbnsbzslJjZwrIbr1NI8OtXoUvUTbpbSyv7FIkttH7fk1tlsdIFTdYncJQ" +
       "jPHwOjkZLRmhk7AAP6bCbVW4RSPNSV1uK702MmYEtYEttlaXMLqzMVvdZBXO" +
       "7OrjcadWXflLS0nTeb88Ugb01KAGNFOmWKfZXS0lngIhJqiT2HppDIaSOJOJ" +
       "mjryVGNryVTfpCpCY0NbCt7QJzAzIPXpJvKlsF9hfFTudgPYIgWiPAE53iCA" +
       "A2aBl7FAsjYOsSJX2LDbJEkcNkYDcjUadlvzcqMj9FWnI3gc7YztprniFtvN" +
       "FkbqHBlUGUesVeMIrm/4dCw1dIaIFzDJllo23yS7KT6fB/qCozxx0NaoRToX" +
       "KwZKpa5kiO5cXK5EcVqZVOtZMxOmJQsVQr+6bQxQusmJQiVZJ+4YUxsMhxvk" +
       "rJwAN6wqqzbn4ItWMgxC0SETZgX3J8OYL28b2SLE5tZ2TrenUcbiqBeXKkMW" +
       "yRCwpTQJZFUfTDW+pCulDQbjFb3e91EiqYwNy6FZmoI53pvY22YNbGhssaQN" +
       "5bFfYtyYQs0mniRTmqnVymtr6KO9WrUhZ7rK99lFBYXbyhRkQPF4RIuCHhjt" +
       "/lxWJ1iJDuKSs3KX5BIPOjWw6+ynI52wxlY5nZT7PGxXR+FspHe7Uwmbhlkr" +
       "KInJwgbOx4P18ijMLGs7MQ0ZuIqKx2KrdauGIkZ1vBp5YrtFVvk5yLYzPa2p" +
       "K2ugtpatjNaCxNN9rIMHxhJvjyV+LpO1xixYtxcNcjUbbMKaaoC09935dv+F" +
       "V3cM8XBxunL0Gcg/4FwlO++CBzo8lj716cCJA6gT1wJQfgfyxN2+7ijuPz77" +
       "0edf0LhfKO8dHI51Y+iB2A9+2NHXunNiqitFfX36dDw/GX/PARrvOXsOdkzo" +
       "+Ydgb8/OO/O7fHCfcXBW+s7v8v6/uCDIx3wxL9pHNbdY5JfvcRr4pbx4MYZe" +
       "Uxx/A14p8W6iYxl97tVcy5zhUyGyR8HjHPDJ+f7w6SQJ//Yefb+VF78WQ/cZ" +
       "ejw+PGw8Ju3Xv1fScj2ID0iLvz+kXTgG+GIB8JV70Pcf8uK3Y+iqZu3OoMXi" +
       "k5v2MYlf/h5ILLT8h8Dz4QMSP/z9l96f3KPvT/PiqzH0IJCerIf+sZof0/eH" +
       "3wN9j+SNj4PnYwf0fez7T9+f36Pvv+bF14D0AH0E8Ep6Vijo4pi6l78H6h49" +
       "VNDnDqh77lVQd3wl9IFzSdw7hircTb+A+p/3IPaVvPirGLoYKtoZHf3Gq7r4" +
       "jaHXn/flU/4Zx6N3fHC5+0hQ/fwL1+5/0wvjP9ldAh5+yPcAA92/SBzn5H3o" +
       "ifqVINQXVoH8A7vb0aD4+9sYevxejjmGruwqBe5/sxv07Rh6w7mDYuhS/ncS" +
       "9u9i6PpZ2Bi6XPyfgMtvP64ew4Fld5WTIJcAwwFIXr0cHIaVyncZVnYXEwV3" +
       "swunA+uR7B75TrI7EYufPnWjV3xDe3j7luy+or2tfuEFevChV2q/sPvcSXWU" +
       "7Taf5X4Gum/35dXRDd6b7zrb4VxXus98");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+6FfeuCth9H9oR3Cx2p/Arenzv+2qOMGcfE10PZX3/Rv3vUvX/hacT3z/wCd" +
       "hnWV3CwAAA==");
}
