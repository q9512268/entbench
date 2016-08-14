package org.apache.batik.css.engine.value;
public class FloatValue extends org.apache.batik.css.engine.value.AbstractValue {
    public static java.lang.String getCssText(short unit, float value) { if (unit <
                                                                               0 ||
                                                                               unit >=
                                                                               UNITS.
                                                                                 length) {
                                                                             throw new org.w3c.dom.DOMException(
                                                                               org.w3c.dom.DOMException.
                                                                                 SYNTAX_ERR,
                                                                               "");
                                                                         }
                                                                         java.lang.String s =
                                                                           java.lang.String.
                                                                           valueOf(
                                                                             value);
                                                                         if (s.
                                                                               endsWith(
                                                                                 ".0")) {
                                                                             s =
                                                                               s.
                                                                                 substring(
                                                                                   0,
                                                                                   s.
                                                                                     length(
                                                                                       ) -
                                                                                     2);
                                                                         }
                                                                         return s +
                                                                         UNITS[unit -
                                                                                 org.w3c.dom.css.CSSPrimitiveValue.
                                                                                   CSS_NUMBER];
    }
    protected static final java.lang.String[]
      UNITS =
      { "",
    "%",
    "em",
    "ex",
    "px",
    "cm",
    "mm",
    "in",
    "pt",
    "pc",
    "deg",
    "rad",
    "grad",
    "ms",
    "s",
    "Hz",
    "kHz",
    "" };
    protected float floatValue;
    protected short unitType;
    public FloatValue(short unitType, float floatValue) {
        super(
          );
        this.
          unitType =
          unitType;
        this.
          floatValue =
          floatValue;
    }
    public short getPrimitiveType() { return unitType;
    }
    public float getFloatValue() { return floatValue;
    }
    public java.lang.String getCssText() {
        return getCssText(
                 unitType,
                 floatValue);
    }
    public java.lang.String toString() { return getCssText(
                                                  );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nLvO0p0GjxGdeev3ohr+im+1/wPsBz5cJyAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QQ8CtNCBMmwt87/7e/bBkl4FxY1SVOg24feKekf568q93W5Y5G+nkPeO/8XY" +
       "ysf+4/+8TQklUt/BEy+Ml+BXf+zx3gtfLcefQmYx+sns9g0N5LqnY+s/6/z3" +
       "g3df+fUD6AEJuqEeJdLlHgWASALJY3ScXYNk+1z/+URwn/U8f7IlvOtiKJxZ" +
       "9iJYn7ogqBfURf3aBXx+Z6HlK+BpHEFX7SI+X4LKClUOebosny2Kv1ba5L4Y" +
       "etAPvRhwqYNQvRKVWXvh15Yr2+ViDfBLmJD8DJjvPXc3Xwk9exB45Sef+Z2P" +
       "vvLMfyi97aoVASHRcHWH9PTMmK+/+uWv/u7DT3y+3OHuV+RoL+7FvP72tP1c" +
       "Nl4y/NCJdt5SKOPxAvWPtHPpKDm7HUY+cDNI5MgKEqCL9+43iJt7ZdwsVXFz" +
       "n9N/6MM3aaY/uDVB6cHs5gdvunp61PMR2VFe+tDh4eGHn3+uwKSCh7eCV7oy" +
       "ugpnONzTnYTIpaMkpviNF8X82Fbfe2dbHRTV9xYFd2yYKzZIpWLzTsh0H9BU" +
       "URWPeDk8A/9HvL35lLee7bl6sQcd9+1zMMs7PHlJA53ZbcyH0Pvu7hJ0aZnT" +
       "sPqNj/3Z4/wL5otvIPl66oLHXJzyZ+hXfwv/TvXvHkD3nQTZbW9w5wc9fz60" +
       "roU6eOV0+XMB9sTeHqX+9sYoiveUGr4HzHv36AuKAnB3WS1UvbfMPcjjDNpn" +
       "VkX53UVB77WP3RV38RO/f6RofQo83SO/794FFdI7e9qlojo9drJrxkmGXrR8" +
       "4AJf2Rvk6wnwvHDE1wt34ev7/zJ8XU1cKz62G3KBq4++Llf7cLkEEsLL9cP2" +
       "YRk+P3QXlDyJPPZc+L19bavPHmOJqIcRcOZn13a76F5eYKjxl2YIBNUjp5FJ" +
       "ee7q+R/540/99t955ssAUEfQ5fK1CcTGGWiZJMXhyg+/+ukn3vTyV36kzHaB" +
       "tsS/+Y/aXylm/dtvTKzHC7Fm5WsjJUcxXSaoulZIdiekuR849OqvLG18/d8T" +
       "jYhEj/8oQZIRTKgZ9qaz629cAxVmPXTTmmKpuMsCuj3wTHRmOU10lvZwz2km" +
       "balJU1ql0kWIqD5X+o0lvcTcmWMPR8P6hKiMl1a912iylZpGtrr8UJ43xSBk" +
       "xaCtcHPZ2vLiejuruW2DMYzE0NN1Ws0lZ7Gtt9euoXXaiOGn3Yo18GMhn3F9" +
       "YS7F0UT2hPZEW7oOJ0+0ljWT5DqRSOvOkiKq3e7WaNer1EYhMWFNW3O+vpMm" +
       "g8SU/UxuoNWxHw5Hg7ojWhVbVXmPbtnDXMRHY8Wrs+OlL7rGTMBEacnXWm6P" +
       "QrnIoTduMKJFWpqtCVmZw+gMp4UxaacziwxX0TYWRNJudaT6ENk5WDvvR40x" +
       "OzPUyGrirRYm+SIZbJzxCPe8cFiPaWc+z73WVjLFuWY6jmJSuleLV2Zi2S1+" +
       "tKSafFeqGDhhzLDqIuW4URXh8boynQtCvODqm87MCbW60BJHQS1uDpozojcX" +
       "CQfD58GU8bhBY4KOCSbetYQB1p1o4mzHtrSow6iu6tE4a1v+xIGtGS4JMaX7" +
       "Hsz3+4lAN2NkvcrVPIrTcXtNL7c4lkmDfr/b1Ls1Ngu46ipehvN1hSdZdNZn" +
       "Uwn1+myTG9RCjs+YRspsFquJ3a1N+I3I2WYL8bFNJNWs2RzdCu1lRIzswXBi" +
       "BMtw3EXXHVx2pLGs4MZyhoz70aIljETOwxeB3t6iHpMgqI6PM3bVR3NySWj1" +
       "2cqeZ0KcR2uVHMh41pUVlMXY0U7w8e4g55qiN9jsWMwZWEHATjg4xLoUZ6I9" +
       "RExZbMI5io1wnK0I653oOMssRi0UwbrLlbMauROMRL11tTFaGT2DrQY71F7n" +
       "rYrSRyphDZHxpDrobXpOMhFEn6jMNljQs3qxl9qBsEX7K9GqjQmfdbZt2jVR" +
       "E+2nMdrLVtutbndyNZH5sOl5PcllJ05bQ+fjkFkahOU1Q6FJsFvF8nFa3TDI" +
       "cDirrJFpIi2Q+szdyit0lU8Vek2Bt4BMmoZu3K12K9PqgjQFbUTv5qLGz5Te" +
       "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" +
       "VN5Q/D/C18NwVisAAA==");
}
