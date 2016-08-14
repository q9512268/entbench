package org.apache.batik.css.engine.value.svg;
public class TextRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GEOMETRICPRECISION_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          GEOMETRICPRECISION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_OPTIMIZELEGIBILITY_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                          OPTIMIZELEGIBILITY_VALUE);
    }
    public boolean isInheritedProperty() {
        return true;
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
                 CSS_TEXT_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextRenderingManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6Z53zkmJbF9yejwafw573OzR62DCWhxrgKfbtkP36E1YiLWImU4XGXsGm+/7" +
       "TdgBscqpxmpEgY81qV11uRY6eR0sNBHH5sCzxVZzy+gtVIi1iBV+VmTsRWx+" +
       "YlloDUvStGIV7I6FFoxcr7r0wnDPXQfD1eHYXHgkW3tp9IYrxFrEOK8XGfs1" +
       "Nmc5mQCGa0tAtoQDP7Pqyi7XGL/8XxgjA3ki360fHlGn5fwPYd2dS08frS6f" +
       "evSu86JQzt5vV0Hhk0wrivcQ5Xkv1Q2WlIV+VdaRShdfb3My7zPdTkL0gVYo" +
       "ct5ifZeThhFZ4WQ1mEWRzXiBkxlFGOFkZb14ef4AlsrHA2JB66X8AJw/SAlS" +
       "iG8v3YecVLp0sKj14iX5CGYHEny9pDt+c8vI5nJRY+9nJuQ/fmVRVDcSijwn" +
       "trm+MlX8meXUcWnr76xe6dTR9R33XPncE9Z1nqTQnTtxlnFQvVmXhtkDS0PB" +
       "2Zy5StctvDrhdMU8p6z0XSd6ZRNYhlQkrt6mB+63zKbsNdc7x1a88Kt9pW9C" +
       "QbyZhCgcDDbnXh1k9DScFDfHcqtUONyJi7fmhY8Or1yS/Ou74nKG5FzJBOl7" +
       "pXPH737r4LRj9WEyro2MhYqZZcSdxpphdSOTBo0eMl42WzMgIu4bVXwl8AT0" +
       "MIrOKexim3N8thfveTlpzC3sc2/HKxVtiBmrtbSawGmgiB7n9jgHV9+ZL63r" +
       "AQa3x3OWyVh1Au4GQLY31q7rziXpmGW6CDbD+QsHbD8Vr9hc+y8Dj3jR6B4A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "apjVtpfERBsZYPW62GwP1vCkDQKkfnOFSoYm0FE5oeaVqiPW8L5EdINNK+qk" +
       "Ja25ImvBgJNKrWCwZGHTFziho02c+ToAHloaemLTN8SpNgviRj0z6jrPtTgU" +
       "FceB1m3JlWDBswGfZl7QY1eCL9qp25mUxxgib2qTVEsBjNr6cNqM6tuyONHr" +
       "IAaRbI9147TuY6U6uqXUZKRrjayiNJtU2opmLZxVN7KNW1qnowaiXXFbnYnW" +
       "65iEtkinzGgzcBqmb0tNJq5sJjCzbFQDql/rbQcY4zUiEax4aCOu0ty8Netu" +
       "4hAZ2tJClrWJnkWRrU8YHgvLxtCrIrPt0CKXVVUQ116zzZeHZMxQRub46KiZ" +
       "2ib4PPaiLY4mGgITVCakDubHqTpR1n3fcrBG0JpbhNAqyXQdjdusgmYoM9sI" +
       "dqUNPlxZWkIri0a8dcTI74NPko7aKbEJoXaaQtyytdKm2Zmjc66OVcFH7ytf" +
       "mX8Om09vR+KWYvPl8GRw7jXyCvZpfInvqu7Jk/sPN7qK37mrbKIf22iE8t2F" +
       "l1zpwK/YWfjwmx97XGc+Ujm7v0GrpNANaRj9gmesDO9YU+dBSy+78i7KsDjv" +
       "PNo4/MKb//UO/lX2a5/G0chdp+Q83eTvDz/2pf5LtXedha453EZ80knsSaaH" +
       "Tm4e3gg++JdxwJ/YQnzJoWVvyy32UvA09i3buPzxxGW94EzhBbuxv8r+9+uv" +
       "UveGPFmn0G1OQga2ETupoY/jsDjbLhgePuYwr02h82oYeoYSHDlT9lTbOse7" +
       "LArSk9o/sL+JerCZ+ixr//ar1P1mnrwlhZ7nJO3A8ZU0P7g4UD+ve+ORnm99" +
       "pnreD57uvp7dZ1/P912l7gN58q4UutXJLzoU23xX0PLdz0DLC3nhneCh97Wk" +
       "n30tf+cqdR/Jk8dT6IJlpAfqHZ4LnvLja5z9GyiF1r/9DLS+NS+8Bzz8vtb8" +
       "s6/1p69S95k8+fhJrUf7+MMeqfiJZ6BisQTcDZ6H91V8+NlX8fNXqXsiT/54" +
       "p2LHMJWltzvuOThSeOCpj0SO6Atr/MkzsMbteeF94NH2raE9+9b4ylXqvpon" +
       "X0ihm4E1SN0I0vzQYXffiDjS8ItPR8MMQODl7jPkB7IvfNINq92tIO0Tj1+4" +
       "/gWPT/+2ONI/vLlzAw1dby497/j52bH8uSg2TKfQ44bdaVpU/P11Ct3/M927" +
       "AFMXpIUGX9+xfiOF7nlK1nT/OOg44z+k0IuuwphC53aZ4zzfBJa6HA8QC6TH" +
       "Kf8phS6epgRSFP/H6b6TQjce0YFOd5njJN8FrQOSPPu96MDp0ac215F37I9n" +
       "duZkoHboLbc+lbcci+3uOxGRFdf0DqKn5e6i3iPaJx8fjF73o/pHdtcmNE/Z" +
       "bvNWrqeh87sbHIcR2D1XbO2grXPEgz+5+VM33H8QLd68E/hokh2T7a7L30vo" +
       "+lFa3CTY/tELPvOK3338m8XJ3/8BLm3p8j8pAAA=");
}
