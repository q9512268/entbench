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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZe2wUxxmfO7+NwQ+CoQYMGENlB+4KCU2RaRrbgWByxifs" +
       "oMZuc8ztzdmL93aX3Tn77JQCkVpQ/kBRgJSkwapU6IMSiNpEjVKFuGqah0hK" +
       "oVHzQCFNU4k0BCn80TgtbdJvZnZv9/YexEmlnrRzezPzffM9f/PN3IkrqMQ0" +
       "UJOO1RgO0DGdmIEwew9jwySxTgWbZh/0RqT73zmwa+pPFXv8qLQfzRrCZreE" +
       "TbJBJkrM7EcLZdWkWJWIuZmQGKMIG8Qkxgimsqb2ozmy2ZXQFVmSabcWI2zC" +
       "VmyEUC2m1JCjSUq6LAYULQpxaYJcmmC7d0JbCFVJmj7mEDRkEHS6xtjchLOe" +
       "SVFNaDsewcEklZVgSDZpW8pAN+qaMjaoaDRAUjSwXVljGWJTaE2WGZoer/7o" +
       "2gNDNdwMs7GqapSraG4hpqaMkFgIVTu96xWSMHeg76KiEJrhmkxRc8heNAiL" +
       "BmFRW19nFkg/k6jJRKfG1aE2p1JdYgJRtCSTiY4NnLDYhLnMwKGcWrpzYtB2" +
       "cVpb290eFQ/dGDz4g3tqflmEqvtRtaz2MnEkEILCIv1gUJKIEsNsj8VIrB/V" +
       "quDwXmLIWJHHLW/XmfKgimkSQsA2C+tM6sTgazq2Ak+CbkZSopqRVi/Og8r6" +
       "VRJX8CDoWu/oKjTcwPpBwUoZBDPiGGLPIikeltUYj6NMirSOzXfCBCAtSxA6" +
       "pKWXKlYxdKA6ESIKVgeDvRB86iBMLdEgBA0ea3mYMlvrWBrGgyRC0TzvvLAY" +
       "glkV3BCMhKI53mmcE3ipweMll3+ubF63/151o+pHPpA5RiSFyT8DiBo9RFtI" +
       "nBgE8kAQVrWGHsL1z+zzIwST53gmizm//s7V21Y0Tr4o5szPMacnup1INCId" +
       "jc46t6CzZW0RE6Nc10yZOT9Dc55lYWukLaUD0tSnObLBgD04ueX5u3cfJ5f9" +
       "qLILlUqakkxAHNVKWkKXFWLcQVRiYEpiXaiCqLFOPt6FyuA9JKtE9PbE4yah" +
       "XahY4V2lGv8NJooDC2aiSniX1bhmv+uYDvH3lI4QKoMHVcGzEIkP/6ZoPDik" +
       "JUgQS1iVVS0YNjSmP3MoxxxiwnsMRnUtGIX4H165KnBL0NSSBgRkUDMGgxii" +
       "YoiIwSAwSQRHsJLkqS4nMMVRhWxOspTqMbpiRKVb2WiAxaD+f109xWwze9Tn" +
       "A7ct8IKGAvm2UVNixIhIB5Md66+ejJwRAcmSyLIqRWtBhIAQIcBFCDARAkKE" +
       "QCERkM/HV76BiSKCBVw9DKABqF3V0vvtTdv2NRVBlOqjxeCnIpi6PGsX63TQ" +
       "xd4SItKJc1umzr5SedyP/ABAUdjFnK2kOWMrETuhoUkkBliWb1OxgTWYfxvJ" +
       "KQeaPDy6Z+uur3A53LsDY1gCwMbIwwzT00s0e1EhF9/qve99dOqhnZqDDxnb" +
       "jb1LZlEy2Gny+tmrfERqXYyfjDyzs9mPigHLAL8phnwDaGz0rpEBP202lDNd" +
       "ykHhuGYksMKGbPytpEOGNur08ACs5e83gItnsXxshWe1laD8m43W66ydKwKW" +
       "xYxHC75VfL1XP/L6H/5+Eze3vatUu8qBXkLbXEjGmNVxzKp1QrDPIATmvXU4" +
       "fODQlb0DPP5gxtJcCzazthMQDFwIZv7eizveePvi0Vf96Zj1UVShGxqFhCax" +
       "VFpPNoRmFtCThbojEoChAhxY4DTfpUJgynGZpRTLk39XL1v15Af7a0QoKNBj" +
       "R9KK6zNw+r/UgXafuWeqkbPxSWwzdszmTBMIP9vh3G4YeIzJkdpzfuHDL+Aj" +
       "sFcAPpvyOOGQ6xNm4JrPo6glCyxiWkIAhkAKWKMPG4OEck/fzOmCvL2JmYhz" +
       "Q3zsa6xpNt0Zk5mUrjIrIj3w6oczt354+irXL7NOcwdIN9bbREyyZlkK2M/1" +
       "otNGbA7BvJsnN3+rRpm8Bhz7gaMEaGz2GICWqYxwsmaXlL3529/VbztXhPwb" +
       "UKWi4dgGzDMTVUBKEHMIgDalf+M2EQ6j5dDUcFVRlvLMA4ty+3Z9QqfcG+NP" +
       "zX1i3U8nLvJI5BwWpoNvBuPyZXjWWsG3NneSsXY5b1tYs8IO6FI9GYUy3xPN" +
       "lQUYerxYJOCc/VzD/efCdHZ06E1GTRo25AQk6YhV2Jyqn9rxXNn47XbRkotE" +
       "zLzT7D779MZLEQ4C5Qz7WT9bbKYL1duNQRcC1QhdPoWPD55P2MN0YB2iRKjr" +
       "tOqUxelCRddZeLQUOFlkqhDcWff28KPvPSZU8BZynslk38H7Pw3sPyjSWlS7" +
       "S7MKTjeNqHiFOqzpZtItKbQKp9hw6dTO3/xs514hVV1m7bYejiaP/fk/LwcO" +
       "/+WlHFs/QKyGadqvdq6zEtDjH6FU6aoj/9z1/dd7YF/pQuVJVd6RJF0xN1co" +
       "2M1k1OUwp5LmHW71mHMo8rUyP7CeTZbW7KvH9d5LUVlU0xSCVa+o7OfdKc60" +
       "qwDUYNZ08KG1rOkUjNd9tnRlHe35crDDSpmOAjnImvXZ2ZaP1KOIn8vhF9lm" +
       "wXANhw92/AmI4w9fbnsBE/C9kjgmiE/fBIJifrqWW5xVy/GrBqcM+eDCD999" +
       "durHZSI0CySah27ev3qU6H1//TgL63nVlSP3PPT9wROPNnTeepnTO+UPo16a" +
       "yi6UoUB0aFcfT/zD31T6ez8q60c1knWs5+UuFBX9cJQ17bM+HP0zxjOPpeIM" +
       "1pYu7xZ4k9+1rLfwcudTMc3IHU+t1QhPkxVHTd4Q9CH+MuZEYWt2BZOPGpJO" +
       "Nnmtz34OOOHMw2f8euFjZso530oXO21yybm7oJz5qAHFZFvKYY+Ue6Yp5VJ4" +
       "VlrrrMwj5d6CUuajpqgKoJgYspTXpPsKCJvKBST8U4o8p2EvkMy3chgSdmG+" +
       "Cwu+kRy97+BErOfYKr+FGH1Q+lJNX6mQEaK4WJXwbcmb+t38msbJo1vOTxVd" +
       "eHBeVfYJjnFqzHM+a82PEd4FXrjv/Ya+W4e2TeNotsijv5flz7tPvHTHculB" +
       "P79pEmmbdUOVSdSWmayVBqFJQ83c7prSHpvNPNEAT8jyWMgbZNffNfKRFsD+" +
       "iQJjP2LNw5DsElbDWHhnwAnKRz7nTnkoLXitnf59luB909c5H6lHL89ZZcVn" +
       "vNjg4M2lOF7AUCdZc4yiypgsXN/HL6lCjq1+8oVtxczEAW7AUnhg+rbKR1pA" +
       "tacKjD3Nml8BfMGRrp8YGjcW6/uFo/gTX1jxOja0AJ6oJX10+ornIy2g3HMF" +
       "xp5nzbPgb1C8E2ASAIlvMY7ak/8bfy+HR7Nk16avdj5Sj2olAru559JNyHFk" +
       "geK7SFazzgjsp1V4/7GAEV9jzRmKZvA/AABJ4dzlCZ6XP0chCtVUoXtJdsCe" +
       "l/UXirj2l05OVJfPnbjrNX43lr6ar4KjZjypKO7Cy/VeqhskLnOVqkQZpvOv" +
       "iyBJIZSBw7Z44Zq8JYjeoWhOTiKKitmXe+7foNb3zoWKh3+7512CQHXmwbLi" +
       "xT3lffAkTGGvl3UbI1dP6/JXIKUvs65Ie3LO9TzpKkWWZmz0/F8xe1NOiv/F" +
       "ItKpiU2b77361WPiNlBS8Pg44zIDzpjiYjK9sS/Jy83mVbqx5dqsxyuW2cVN" +
       "rRDYSa/5rqhthwDXWRA1eO7JzOb0ddkbR9edfmVf6Xk4YwwgH6Zo9kB28Z/S" +
       "k1B1DIRynaah7OFXeG2V7247+/Gbvjp+1YPE+buxEEVEOnD6Qjiu64/4UUUX" +
       "lL9qjKT4yeT2MXULkUaMjMN5aVRLquk/0GaxiMfsyMgtYxl0ZrqX3SZT1JR9" +
       "U5F9w16paKPE6GDcGZuZnlIoqevuUW7ZbwpkYZaGaIyEunXdvqLhd1Ttus5T" +
       "/BOOL/8Fr4yg1PoeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tIDXjJJG5tRSPvmqj9p/5IS1R47PIcUj1sRvDGsXPri9/Wv8PF6eD5cIf/YS" +
       "efx8UXwmhW6Y9l6dYnnVYXAqks9+HSIppFEex773SCTv/cZr+5cv6fvVovh8" +
       "Cj20sFLVisNSJkXb5075+8Wvg79Hi8YnwKMf8ad/4/n73Uv6fq8ovgC0B/jD" +
       "QMABIaOMf6fc/dbXq723gSc84i78xnB3dR/sSj2cFINTtVw4a73PDvbfjv/s" +
       "Ekl8sSj+KIVeU97sAgFLSy8q+o9f1ZekFHrisqsmxUfzx+64Fbe/yWX89Ms3" +
       "H3jTy9KflLctTm5bPUhDD8zXnnf2Q8uZ+rUotuZ2ycyD+88uUfn3N4CSy1w+" +
       "ha7tKyUPf70f9Hcp9Ia7Dkqh+4u/s7D/kEK3LsKm0NXy/yzcfwF2dgoHpt1X" +
       "zoL8V6AtAFJU/1t0HLBqr+o+zz5sXTm/wJ7o8NGvpsMza/Iz51bS8qLj8aq3" +
       "3l91fMH4zMsk+51fRn9sf7/E8ECyWmB5gIau76+6nKycb70ntmNc10bPfuXh" +
       "zz74zcer/MN7gk995Axtb777TQ7cj9Ly7kX+82/62Xf++Mt/Xn7W+H+WCJ33" +
       "gSoAAA==");
}
