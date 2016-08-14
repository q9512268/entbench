package org.apache.batik.dom.svg;
public class SVGOMAngle implements org.w3c.dom.svg.SVGAngle {
    protected short unitType;
    protected float value;
    protected static final java.lang.String[] UNITS = { "", "", "deg", "rad",
    "grad" };
    public short getUnitType() { revalidate();
                                 return unitType; }
    public float getValue() { revalidate();
                              return toUnit(unitType, value, SVG_ANGLETYPE_DEG);
    }
    public void setValue(float value) throws org.w3c.dom.DOMException { revalidate(
                                                                          );
                                                                        this.
                                                                          unitType =
                                                                          SVG_ANGLETYPE_DEG;
                                                                        this.
                                                                          value =
                                                                          value;
                                                                        reset(
                                                                          );
    }
    public float getValueInSpecifiedUnits() { revalidate(
                                                );
                                              return value;
    }
    public void setValueInSpecifiedUnits(float value)
          throws org.w3c.dom.DOMException { revalidate(
                                              );
                                            this.
                                              value =
                                              value;
                                            reset(
                                              ); }
    public java.lang.String getValueAsString() { revalidate(
                                                   );
                                                 return java.lang.Float.
                                                   toString(
                                                     value) +
                                                 UNITS[unitType];
    }
    public void setValueAsString(java.lang.String value)
          throws org.w3c.dom.DOMException { parse(
                                              value);
                                            reset(
                                              ); }
    public void newValueSpecifiedUnits(short unit,
                                       float value) {
        unitType =
          unit;
        this.
          value =
          value;
        reset(
          );
    }
    public void convertToSpecifiedUnits(short unit) {
        value =
          toUnit(
            unitType,
            value,
            unit);
        unitType =
          unit;
    }
    protected void reset() {  }
    protected void revalidate() {  }
    protected void parse(java.lang.String s) { try {
                                                   org.apache.batik.parser.AngleParser angleParser =
                                                     new org.apache.batik.parser.AngleParser(
                                                     );
                                                   angleParser.
                                                     setAngleHandler(
                                                       new org.apache.batik.parser.DefaultAngleHandler(
                                                         ) {
                                                           public void angleValue(float v)
                                                                 throws org.apache.batik.parser.ParseException {
                                                               value =
                                                                 v;
                                                           }
                                                           public void deg()
                                                                 throws org.apache.batik.parser.ParseException {
                                                               unitType =
                                                                 SVG_ANGLETYPE_DEG;
                                                           }
                                                           public void rad()
                                                                 throws org.apache.batik.parser.ParseException {
                                                               unitType =
                                                                 SVG_ANGLETYPE_RAD;
                                                           }
                                                           public void grad()
                                                                 throws org.apache.batik.parser.ParseException {
                                                               unitType =
                                                                 SVG_ANGLETYPE_GRAD;
                                                           }
                                                       });
                                                   unitType =
                                                     SVG_ANGLETYPE_UNSPECIFIED;
                                                   angleParser.
                                                     parse(
                                                       s);
                                               }
                                               catch (org.apache.batik.parser.ParseException e) {
                                                   unitType =
                                                     SVG_ANGLETYPE_UNKNOWN;
                                                   value =
                                                     0;
                                               }
    }
    protected static double[][] K = { { 1,
    java.lang.Math.
      PI /
      180,
    java.lang.Math.
      PI /
      200 },
    { 180 /
      java.lang.Math.
        PI,
    1,
    1800 /
      (9 *
         java.lang.Math.
           PI) },
    { 0.9,
    9 *
      java.lang.Math.
        PI /
      1800,
    1 } };
    public static float toUnit(short fromUnit,
                               float value,
                               short toUnit) {
        if (fromUnit ==
              1) {
            fromUnit =
              2;
        }
        if (toUnit ==
              1) {
            toUnit =
              2;
        }
        return (float)
                 (K[fromUnit -
                      2][toUnit -
                           2] *
                    value);
    }
    public SVGOMAngle() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fSoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "x9lQc2Las4FmH/vBfUad3d99Jrbcm0n5cXC9cxdb3nk2thwU8pv3512eystn" +
       "s+KdR658lxe4EeBSVfKxn48KV2LHiPJwdqHCBoFhg4iz2iUy0EsPfs383Dd+" +
       "YZuknNXOGWL14y//xJ8efvLlSydSw2duyM5O9tmmhzmLb835zOz9qYtmyXu0" +
       "/uMXX/qHP/fSx7ZcPXg60SFBHv8L/+r//ubhZ7/+5XPW2zuApQfRNjhnJZIV" +
       "+Nakqzc1/2unlfPY0Qpw9H2OcgY3UU522zzSyh2rzL5ymtZOANlXN8rMxpXO" +
       "8jn83vn8waz2MriQHZ+lm/Apns/nbTmfYFEI801JxpDhSNYx42OW4kdAW8/d" +
       "3JbyQLs1jVf+5jO/9eFXnvmDPFZdMULgIniwOCf7PtHn269+7Zu//dbHv5Cv" +
       "7bfPpXDrLGe3LTfuSk5tNnKG7zkWy0NH6jvYieVgu6Rdv3FJ++GrfiyFhh8D" +
       "T3rXdmm8uhXG1VwUV7dblhc+cJXpN8nrLM6Qo6vvu+qoya7lQ5I9f+mFw8PD" +
       "D1x73vO2qns72LHmsTkLJYdbuuMAe7BL33JNZoVypCTjfCVdym7flRXXjxRz" +
       "2VKdRaSfZ1K3AUllt/KOl2zKS9txjnh72543wnIdNVtxj9q22afhHh7vQUFj" +
       "egPzQeHdNzcJJtfMPij/+kf/82P8j+gffANp55NnLObskH+befXL7R+S/9ql" +
       "wm3HIfqGDerpTtdOB+a7AxXsqB3+VHh+fKuPXH5Z8cwFmcGHLmh7KSvWwIHk" +
       "TL5bdVxA/pG0cCYGvPC9x4C3H8WAX94Z+9+7SQz4SxeYVzMrXjwyrwM6J5KO" +
       "53hXNuQhuJq7OZpbhxJuccuVPWaRkggybLCXh3rGQo+OdnPfr6HTM9Aywebx" +
       "frGDtthCM29x/nlgKGBisL9rgXTWWWVPaBgJhII0e6YFRmnkBEdw/39Ol54X" +
       "Ny4rLoh+qud5hew6Y49/+XXtcTvaAUhL7igfYodw9vvTF6w6eUB78VRUe2Rp" +
       "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" +
       "+jM8h9s2PZUVzx0/by0cPa6+2ZmKE++d");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("D47eSjyanZ9JEPnksZn80Ez2KvHxm53tyl8jfv6jL7+i9H+2dGn3rJ2OCndF" +
       "rvfnLHWlWifmemt+vzrmM+f1HeCq7fisnX2svpfE+e//3rWV5AXP/b90Qds/" +
       "zopfiQpvWajRePdWN6ui9rL/B6/3VPDkmOfB+wFw7fpuv99ceF++oO0rWfHP" +
       "osIVAC9//Z79Hu+x/dotYHtLVvkcuDo7bJ03B9vBnmCcE/zL8wnOtdpmnyFT" +
       "WfWyF19559/Nin8BJBDuJHDuw+CVayh7qXz1VjX+PLi4nVS4N1/j/+GCtm9k" +
       "xR8AqRxpnHJGnirnz8IzAw/PWMAf3qoFoOB6YYf1he+TBfy3mxP8Xk7w37Pi" +
       "WwB1eAHqf7tH/V9vAfWDWWUWTpUdauXN1/Cf3LztIJ/qf0eF+480jIfbd99Z" +
       "vbbH+Me3qtnsTaS1w2i96ZrVcjB3v45mD+7JijsA2vActHuNHly+VbQ/Cq54" +
       "hzZ+c9Be2r/5pY6N+eDhC3T7aFY8EBUedtRke5zqAis+ePBWMWfnWT68w/zh" +
       "N13DVA7p6QvgZkMePB4VHpFdZ6UGEe9eiPeJW8B7fNboEzu8n3ijeJuv57UH" +
       "hxe0ZW9qD7LDPoEKLPkMsHffKrAnwfVTO2A/9eYD++EL2t6bFWiUnfRYSZah" +
       "SJF6Bl31VtFlwfYzO3SfeXPQ3RCIWhdA7GQFDnTnZf86OYOucQvoHs0qnwDX" +
       "r+7Q/eobQLc/sPTiuRBv2+87ttFn75PcBWD5rGCiwuXIzXww77lHy74RtCmw" +
       "iv3J++zo8KM3/I1n+9cT+Quv3HflkVfGv7s9oHb095C7eoUrWmxZJ096nri/" +
       "7AWqZuTg79qe+/RyCC/sksLz/goQFW4DZcbqgbilfjEqPHQeNaAE5UlKCSxD" +
       "ZymBVeTfJ+kUgHtPB0S5vTlJkvEBSLJbfXtm6fRptu3B2HSb5D560nrytf11" +
       "I/9xl5Nn2LMjZPnfrY6Oe8XbP1xdl7/4Spf90HeqP7s9Qy9b0maTjXKlV7hz" +
       "e5w/HzQ7MvbUTUc7Guty5/nv3vuLdz13tBW8d8vw3pJP8Pbk+YfUSduL8mPl" +
       "m1955O+/92+98vv54ZD/B0wZZ4MHNwAA");
}
