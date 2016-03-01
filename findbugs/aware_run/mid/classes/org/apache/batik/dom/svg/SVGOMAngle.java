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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cPBMfZCU7kn84PsddaU6J/q6v7hfHelZ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6PoOcDUO9Gycfnx+bImz3/O9a2fJc57vf+mcsl/Ok19MSm/R1YQ/eHubZ1HH" +
       "tv9Hb/QU72SbZ8H7HnAd1N193154Xz6n7Ct58qtJ6RKAV7xmz3/zx9h+7Raw" +
       "vSXPfB5cvQNsvduDbe9YgC8E/sXZAmdGbXs86mSyGuQvuIrKv5sn/xxYID6w" +
       "wJkPb1e+qRxb5au36vEXwMUeWIW9/R7/9+eUfT1P/hBY5dDjlDcNVLl4dp0H" +
       "eHwqAv7oViMABdeLB1hf/H8UAf/15gK/Vwj8tzz5JkAdn4P63xyj/i+3gPrh" +
       "PDOnU+UAtXL7PfynNy/bK7r6X0np8qGH8Xj3jjvP144x/smtejZ/4+gcYHRu" +
       "u2e1Asy9b+DZvfvy5C6ANj4D7bFH9y7eKtofAld6gDa9PWgvHL/hpY6Cee+R" +
       "c3z7WJ48lJQe8dT17tjUOVG89/CtYs7PrXz4APOHb7uHqQLSM+fAzZvceyIp" +
       "PSr73kqNEs4/F++Tt4D36EzRjxzg/ZE3i7f9RqN2b/+csvzN6l5+qCdSQSSf" +
       "AvbuWwX2FLh+7ADYj91+YD9wTtl78wRN8hMdK9ExFTFRT6Gr3yq6nGw/c4Du" +
       "M7cH3Q1ERJ4DsZcnOPBdkP/z5BQ64hbQPZZnPgmuXzpA90tvAt3xwaSXzoR4" +
       "x/G+Y8c+x2OSPQcslyejpHQx8fMxWNQ8Rku/GbQZiIrjE/b5EeHHbvgrz+7v" +
       "J/IXXn3w0qOv8r+7O4h2+BeRe4alS1rqOCdPdJ64vxhEqmYW4O/Zne8MCggv" +
       "HiwKzzryn5TuAGmu6p6wk34pKb3tLGkgCdKTkiKYhk5Lgqgovk/KKQD3sRww" +
       "5e7mpEiuBxDJb43d2aTrT63tDsBmu0XuYyejp5jb35D5j6qcPKueHxUr/nJ1" +
       "eKwr3f3p6pr8xVf79Ie+Xf+J3Vl52RG327yVS8PS3btj+0Wj+dGwp2/a2mFb" +
       "F3svfOeBn7nn+cOt4AM7hY8j+YRuT519GL3jBklxfHz7i4/+w/f+/Vd/vzjM" +
       "8X8BFHAGZws3AAA=");
}
