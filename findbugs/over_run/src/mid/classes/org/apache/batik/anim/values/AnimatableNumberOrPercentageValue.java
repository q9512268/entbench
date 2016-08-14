package org.apache.batik.anim.values;
public class AnimatableNumberOrPercentageValue extends org.apache.batik.anim.values.AnimatableNumberValue {
    protected boolean isPercentage;
    protected AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target,
                                             float n) { super(
                                                          target,
                                                          n);
    }
    public AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target,
                                             float n,
                                             boolean isPercentage) {
        super(
          target,
          n);
        this.
          isPercentage =
          isPercentage;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOrPercentageValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
                result;
        }
        float newValue;
        boolean newIsPercentage;
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue toValue =
          (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
            to;
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue accValue =
          (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
            accumulation;
        if (to !=
              null) {
            if (toValue.
                  isPercentage ==
                  isPercentage) {
                newValue =
                  value +
                    interpolation *
                    (toValue.
                       value -
                       value);
                newIsPercentage =
                  isPercentage;
            }
            else {
                if (interpolation >=
                      0.5) {
                    newValue =
                      toValue.
                        value;
                    newIsPercentage =
                      toValue.
                        isPercentage;
                }
                else {
                    newValue =
                      value;
                    newIsPercentage =
                      isPercentage;
                }
            }
        }
        else {
            newValue =
              value;
            newIsPercentage =
              isPercentage;
        }
        if (accumulation !=
              null &&
              accValue.
                isPercentage ==
              newIsPercentage) {
            newValue +=
              multiplier *
                accValue.
                  value;
        }
        if (res.
              value !=
              newValue ||
              res.
                isPercentage !=
              newIsPercentage) {
            res.
              value =
              newValue;
            res.
              isPercentage =
              newIsPercentage;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean isPercentage() { return isPercentage;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableNumberOrPercentageValue(
          target,
          0,
          isPercentage);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              value));
        if (isPercentage) {
            sb.
              append(
                '%');
        }
        return sb.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfYxU1RW/M7s7+8HCfiAf5ZtloQFxpvhZs1SFFWRxlp2w" +
       "SMpiXe68ubP75M17j/fu7A7YLWpCocSgEVTaAkkjpkpATCPph5FiWotGKQFN" +
       "q9JKq2nUqon8UbHV1p5z73vz3rz5wNUmneTdeXPvOefec87vnHvuncMfkhrb" +
       "Im0m1VM0yjebzI4m8D1BLZulOjVq22ugt1/Z+dfdWy++Un9PmET6yLhBancr" +
       "1GbLVaal7D4yXdVtTnWF2asYSyFHwmI2s4YoVw29j0xQ7a6MqamKyruNFEOC" +
       "tdSKkxbKuaUms5x1OQI4mRkXq4mJ1cSWBAk64qRRMczNHsOUAoZO3xjSZrz5" +
       "bE6a43fSIRrLclWLxVWbd+QscrlpaJsHNINHWY5H79SucQyxMn5NkRnanmr6" +
       "+NMHBpuFGcZTXTe4UNFezWxDG2KpOGnyepdpLGNvIt8jVXEyxkfMSXvcnTQG" +
       "k8ZgUldfjwpWP5bp2UynIdThrqSIqeCCOJldKMSkFs04YhJizSChjju6C2bQ" +
       "dlZeW9fdARUfujy255E7mn9WRZr6SJOq9+JyFFgEh0n6wKAsk2SWvSSVYqk+" +
       "0qKDw3uZpVJN3eJ4u9VWB3TKswAB1yzYmTWZJeb0bAWeBN2srMINK69eWoDK" +
       "+VWT1ugA6DrR01VquBz7QcEGFRZmpSlgz2Gp3qjqKYGjQo68ju23AgGw1mYY" +
       "HzTyU1XrFDpIq4SIRvWBWC+ATx8A0hoDIGgJrJURirY2qbKRDrB+TiYH6RJy" +
       "CKjqhSGQhZMJQTIhCbw0JeAln38+XLV41136Cj1MQrDmFFM0XP8YYJoRYFrN" +
       "0sxiEAeSsXFB/GE68dkdYUKAeEKAWNL8/LsXblo448QLkmZqCZqe5J1M4f3K" +
       "weS4M9M6519fhcuoMw1bRecXaC6iLOGMdORMyDQT8xJxMOoOnlj9u3V3H2Lv" +
       "h0lDF4kohpbNAI5aFCNjqhqzbmE6syhnqS5Sz/RUpxjvIrXwHld1Jnt70mmb" +
       "8S5SrYmuiCF+g4nSIAJN1ADvqp423HeT8kHxnjMJIbXwkEZ4phP5Ed+cbI0N" +
       "GhkWowrVVd2IJSwD9UeHipzDbHhPwahpxJKA/41XLIpeF7ONrAWAjBnWQIwC" +
       "KgaZHIyBkExsiGpZEepqhnKa1NiqLIZUj5VgwKVzwMlaJIkiEM3//xJyaKXx" +
       "w6EQOHBaMH1oEHkrDC3FrH5lT3bpsgtP9r8koYnh5NiXkxtgHVG5jqhYRxTX" +
       "EZXriF5yHSQUEtNfhuuR2AHPb4QcAkm8cX7vd1Zu2NFWBaA1h6vBbVVAOq9o" +
       "U+v0ko27Q/Qrh8+svnj6VMOhMAlDPkrCpubtLO0FO4vcGC1DYSlIbeX2GDfP" +
       "xsrvKiXXQU7sHb5n7dZviHX4NwsUWAN5DtkTmOLzU7QHk0QpuU3b3/346MMj" +
       "hpcuCnYfd9Ms4sQs1BZ0dlD5fmXBLHqs/9mR9jCphtQG6ZxTCD/IlDOCcxRk" +
       "ow43s6MudaBw2rAyVMMhNx038EHLGPZ6BApbxPtl4OJxGJ4xeL7uxKv4xtGJ" +
       "JraTJGoRMwEtxM7xrV5z/2u/f+8qYW53k2nyVQe9jHf4EhsKaxUprMWD4BqL" +
       "MaD7897E7oc+3L5e4A8o5pSasB3bTkho4EIw87YXNr1+/s2Dr4bzmA1xUm9a" +
       "BofQZqlcXk8cImMr6IlQ95YEuVEDCQic9tt0AKaaVjGuME4+a5q76NgHu5ol" +
       "FDTocZG08NICvP6vLSV3v3THxRlCTEjBvdkzm0cmE/54T/ISy6KbcR25e85O" +
       "/+FJuh+2DkjXtrqFiQwckmYQmk/mZH5RxkgZGZk1ZLqAOdZQa4Bx4emrBV9M" +
       "tFehiYQ0Isa+iU277Y+YwqD0VV39ygOvfjR27UfHLwj9Css2P0C6qdkhMYnN" +
       "3ByInxTMTiuoPQh0V59YdXuzduJTkNgHEhXIy3aPBSkzVwAnh7qm9o3nfjNx" +
       "w5kqEl5OGjSDppZTEZmkHkKC2YOQbXPmjTdJOAzXQdMsVCVFyqMHZpb27bKM" +
       "yYU3tvxi0tOLf3rgTYFEIWF6HnxjUMpCeKIO+KKlgwzbeaKdj81CF9ARM5uE" +
       "qj+A5oYKAgNeDAtJYfx5jfCfL6fjSaI3m7R5wlIzEKRDTp1zdOLFTb+t3XKz" +
       "W8OUYpGUt9rdp3+14p1+kQTqMPdjP0421pfVl1gDvgzULHX5HD4heP6DD+qA" +
       "HbJiaO10ypZZ+brFNBEe8yscNApViI20nt+4790jUoVgXRcgZjv27Pw8umuP" +
       "DGtZ/M4pqj/9PLIAlupg042rm11pFsGx/J2jI888PrJdrqq1sJRbBieVI3/4" +
       "98vRvX95scT+DynWoDzvVzfWsSIM+EcqFVm0/59bv/9aD+wrXaQuq6ubsqwr" +
       "5ZcK9budTfoc5hXWosOvHjqHk9AC8IPo7qqQLG7HZqkYuh6bTonexV8s4LBj" +
       "SbkoutYB/bUVogibZcXxUo41oEiVLH9EvGATFyMrHSfjV4/vvZeT2qRhaIzq" +
       "Qc/gz3XSWKyCscTZY4NnLDp6Y0mOqXlAzCqq28Qtg1dyfHDux2//+uKjtRKG" +
       "FYIqwDf5Xz1a8t63PinK66LCKhFnAf6+2OF9UzpveF/we6UOcs/JFVfGUAx6" +
       "vFceyvwj3BZ5Pkxq+0iz4pzoRWkLBUQfnGJt95gPp/6C8cITqTx+deRLuWnB" +
       "QPdNGyyy/LFTzQviJFBXzYGnzUFcWxCsISJehj28LiiuVspxc9Ko2l5xj31p" +
       "D/0CQ7kKGMqVChLxiZDA0S0YJFMd1AHEppc7XYs0d/DePQdSPY8tCjsYXwOF" +
       "GTfMKzQ2xDSfqIhImkGwdos7Bc/z1529WHXuwcmNxecLlDSjzOlhQXlUByc4" +
       "ee/fp6y5YXDDKA4OMwP6B0U+0X34xVvmKQ+GxbWIBFrRdUohU0chvBosxrOW" +
       "XpiM2/Iem4qemAfPjY7Hbhx9RizHGshWNcJXNW5VufALnkNF6CHP/SKNirdL" +
       "5dIqVS/a4Xx5dFeFPPoINj/gZIy4zQJLQ9XgzSnCYueX3Ie25U03HodmwpN1" +
       "TJcdvdXLsVbQ7ScVxh7FZl+ppOApvv9/o/gUeEac1Y+MXvFyrBWUO1Jh7Cg2" +
       "j8P+q1A9QZWgzk98ZZ1biBNn25yFbxu9zuVYA3r5oH6/kPrLCoo/g83TnDSk" +
       "VJk51ogLubin+7GvrLtIL3hOvs9R4L7R616OtYJqz1cYO4nNCQA6nFf7mGV4" +
       "+cVT/LmvrHgrDk2DZ7ez+t2jV7wcawXlzlQYewWbl8HfoHgn7LKwn7m5uFmc" +
       "TLGsicqLds8Up75EHcnJ7EveI+KBeHLRPyDy1l558kBT3aQDt/1R3GXlb9Yb" +
       "4WiYzmqav3jyvUdMi6VVoWqjLKVM8fUnqM0q7TVwOJYvQp1zkuk8JxNKMnFS" +
       "jV9+2rfAgEFaOGeJbz/d38D2Hh1MK1/8JO/C3gUk+Pqe6XrnylHd2Arr5kKF" +
       "lVbenRMu5U5fcTanoPQRf2q5ZUpW/q0FR/wDK1fddeHax+TtnaLRLVtQyhg4" +
       "E8qLxHypM7usNFdWZMX8T8c9VT/XLfda5IK9QJnqQ/MSyHMmgmhK4F7Lbs9f" +
       "b71+cPHxUzsiZ+GcsJ6EKCfj1xcX8DkzC3XY+nip0y8UguLKraPh7Q2nP3kj" +
       "1CquZog8Hs2oxNGv7D5+LpE2zR+FSX0XqYFqluXE6eLmzfpqpgxZBYfpSNLI" +
       "6vn/v8Yh4inGobCMY9Cx+V68/eWkrfhmofhGvEEzhpm1FKWjmLGB4jBrmv5R" +
       "YdlvY9OdQ0sDGvvj3abpXqksEJY3TRHnn2Gz7r9w6V95uR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P/nF4vvM/wJgtq5dMSoAAA==");
}
