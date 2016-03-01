package org.apache.batik.anim.values;
public class AnimatableLengthListValue extends org.apache.batik.anim.values.AnimatableValue {
    protected short[] lengthTypes;
    protected float[] lengthValues;
    protected short percentageInterpretation;
    protected AnimatableLengthListValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableLengthListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                     short[] types,
                                     float[] values,
                                     short pcInterp) { super(
                                                         target);
                                                       this.
                                                         lengthTypes =
                                                         types;
                                                       this.
                                                         lengthValues =
                                                         values;
                                                       this.
                                                         percentageInterpretation =
                                                         pcInterp;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableLengthListValue toLengthList =
          (org.apache.batik.anim.values.AnimatableLengthListValue)
            to;
        org.apache.batik.anim.values.AnimatableLengthListValue accLengthList =
          (org.apache.batik.anim.values.AnimatableLengthListValue)
            accumulation;
        boolean hasTo =
          to !=
          null;
        boolean hasAcc =
          accumulation !=
          null;
        boolean canInterpolate =
          !(hasTo &&
              toLengthList.
                lengthTypes.
                length !=
              lengthTypes.
                length) &&
          !(hasAcc &&
              accLengthList.
                lengthTypes.
                length !=
              lengthTypes.
                length);
        short[] baseLengthTypes;
        float[] baseLengthValues;
        if (!canInterpolate &&
              hasTo &&
              interpolation >=
              0.5) {
            baseLengthTypes =
              toLengthList.
                lengthTypes;
            baseLengthValues =
              toLengthList.
                lengthValues;
        }
        else {
            baseLengthTypes =
              lengthTypes;
            baseLengthValues =
              lengthValues;
        }
        int len =
          baseLengthTypes.
            length;
        org.apache.batik.anim.values.AnimatableLengthListValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableLengthListValue(
                target);
            res.
              lengthTypes =
              (new short[len]);
            res.
              lengthValues =
              (new float[len]);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableLengthListValue)
                result;
            if (res.
                  lengthTypes ==
                  null ||
                  res.
                    lengthTypes.
                    length !=
                  len) {
                res.
                  lengthTypes =
                  (new short[len]);
                res.
                  lengthValues =
                  (new float[len]);
            }
        }
        res.
          hasChanged =
          percentageInterpretation !=
            res.
              percentageInterpretation;
        res.
          percentageInterpretation =
          percentageInterpretation;
        for (int i =
               0;
             i <
               len;
             i++) {
            float toV =
              0;
            float accV =
              0;
            short newLengthType =
              baseLengthTypes[i];
            float newLengthValue =
              baseLengthValues[i];
            if (canInterpolate) {
                if (hasTo &&
                      !org.apache.batik.anim.values.AnimatableLengthValue.
                      compatibleTypes(
                        newLengthType,
                        percentageInterpretation,
                        toLengthList.
                          lengthTypes[i],
                        toLengthList.
                          percentageInterpretation) ||
                      hasAcc &&
                      !org.apache.batik.anim.values.AnimatableLengthValue.
                      compatibleTypes(
                        newLengthType,
                        percentageInterpretation,
                        accLengthList.
                          lengthTypes[i],
                        accLengthList.
                          percentageInterpretation)) {
                    newLengthValue =
                      target.
                        svgToUserSpace(
                          newLengthValue,
                          newLengthType,
                          percentageInterpretation);
                    newLengthType =
                      org.w3c.dom.svg.SVGLength.
                        SVG_LENGTHTYPE_NUMBER;
                    if (hasTo) {
                        toV =
                          to.
                            target.
                            svgToUserSpace(
                              toLengthList.
                                lengthValues[i],
                              toLengthList.
                                lengthTypes[i],
                              toLengthList.
                                percentageInterpretation);
                    }
                    if (hasAcc) {
                        accV =
                          accumulation.
                            target.
                            svgToUserSpace(
                              accLengthList.
                                lengthValues[i],
                              accLengthList.
                                lengthTypes[i],
                              accLengthList.
                                percentageInterpretation);
                    }
                }
                else {
                    if (hasTo) {
                        toV =
                          toLengthList.
                            lengthValues[i];
                    }
                    if (hasAcc) {
                        accV =
                          accLengthList.
                            lengthValues[i];
                    }
                }
                newLengthValue +=
                  interpolation *
                    (toV -
                       newLengthValue) +
                    multiplier *
                    accV;
            }
            if (!res.
                   hasChanged) {
                res.
                  hasChanged =
                  newLengthType !=
                    res.
                      lengthTypes[i] ||
                    newLengthValue !=
                    res.
                      lengthValues[i];
            }
            res.
              lengthTypes[i] =
              newLengthType;
            res.
              lengthValues[i] =
              newLengthValue;
        }
        return res;
    }
    public short[] getLengthTypes() { return lengthTypes;
    }
    public float[] getLengthValues() { return lengthValues;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        float[] vs =
          new float[lengthValues.
                      length];
        return new org.apache.batik.anim.values.AnimatableLengthListValue(
          target,
          lengthTypes,
          vs,
          percentageInterpretation);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        if (lengthValues.
              length >
              0) {
            sb.
              append(
                formatNumber(
                  lengthValues[0]));
            sb.
              append(
                org.apache.batik.anim.values.AnimatableLengthValue.
                  UNITS[lengthTypes[0] -
                          1]);
        }
        for (int i =
               1;
             i <
               lengthValues.
                 length;
             i++) {
            sb.
              append(
                ',');
            sb.
              append(
                formatNumber(
                  lengthValues[i]));
            sb.
              append(
                org.apache.batik.anim.values.AnimatableLengthValue.
                  UNITS[lengthTypes[i] -
                          1]);
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
      ("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" +
       "r5b9dPxV7omcwuyc801CKu1wLbOdb1nxIMNxIR87cFjkOHSlkUlAd+/z5toA" +
       "gj4rlnNK5fi41MIm1ZPTcccwkElYjDuW6FN+2/LuL49sqnpJ9CntRcF97c+b" +
       "25/6sf7KibDT2hRDEZAXW71HH1zzdpznjGosFfgeeav3FIHl5rAnYTXmJ6wW" +
       "W5+OXvN0CQIuKF01PFKO/6TtmZ3jbW9wf6pWLKg7sGqR9tCD88GB104cq599" +
       "H0/U5ci8zXh+X13YNud1w1ymBhzWZa1SCu43lTQkzVFbwQenntryWNW2i8J2" +
       "NMaESj6DvxBc/8ELVYEvRG/V3G03ePNyHZ5h4HodAVuy/EWjO5pf23zHO/cK" +
       "q/o7YB8w3b13z2eR6/aKxCi2CW0FnboXR2wVhIVxGETu5getwjFWvX1wx+9+" +
       "tuNawVVzftO7EvZ0977w6Z8jt75+pEjnVAGBb7JcZDjZEntnnxGEUJVL7vx4" +
       "5zUv9oHBe0h1RlO2ZGhP0ksVbGtlEh4fdrcg/IVXPDQOI6FOtEMhC/MKei1+" +
       "AuC2Ce8dv/2tR07dVSUEDzCjD2/6v/rUxFVvflSQi3lXVMSyPvyh6IE7ZnRf" +
       "cILju+0JYrdlC7tYCCQX9xv70/8Mt1Y+HiZVQ6RRtnfbvB2Foj8EoWI5W3DY" +
       "kefN5+8WxdaoK9d+zfK7lmdZf2PktVY5y7NMkwjDEOHpQymehMN4uwq8J6Vo" +
       "ksrxBiEvq7y95sAbbP/FnyFGyiAB4O13PIYO2021XZlFTUfRYP+paxTbA2dO" +
       "NOiKHsnt/WGymMvML3CZXp5nXP2fd+xU2fEbptcVduZIbU6JvruztG/5F3ji" +
       "qr/PGLxgZNMEWu65Pofxk/x574EjqxfKN4T5wYEwd8GBQz5SV76Ra03KMqaW" +
       "H4StwtTcLsLOOKzklgvoe64ImLsSh+3gGDKaUFg8APwH3MmWe3oM25T4uEkY" +
       "eG2u1s1wNspn2LXuDJHY6Ve/c4WeRjdzDaGzRf56FhJi9+Fwjbhf7wkmX2BB" +
       "WOtSQf72qM8bH/gsC7p2fF8fFN842MGNQxoHvmX5YWEU4yNPgKz4smNiWY6N" +
       "w+UBXnFLwNxtONyEwy7BSQDs7cHeheMAH3sCiIzjsIJPnY9Dt5Bv2RfrlAUD" +
       "/P1M/q5MGCG/f2sN6t9sS93lRmhn4TauFDYjk0RSzu14e3FoceXZ93ny+Hht" +
       "g6vTXq2zBK/7A3kthc1IneCVFzuOd7WP2XsmyOxiuM6ylzurBLO/CGS2FDYj" +
       "06GpkSmU/mGoINDdGpBiJWdTP+Bj/FAA41lP7s0xwP8qie+A0MOAx6cItomz" +
       "S53h8hZx31V7x5N9dy9xuuWNDLZ9urFYpaNU9ZCqEsGaY2Mmkl8I12qbjdV+" +
       "LbqC+iTIbcpKofqCroIzUOGU/EVf8EiPOwviPI7DHn7nTZo8aRVPAHzusYDY" +
       "/xMOj0AM8e0LKBj2DO4C3LCHJ54OfCrGzRuZD9c9tp7umbiKS6EGyPZ8wNwL" +
       "OBxlZPIwZTFf+nBF/8tXIzomv0M2/4cmLnop1ADxXg+YexOH44w05ET3ZCNX" +
       "9le+Gtmxo3nQFuDBicteCjVAvvcC5v6Bw9uMVEF/0+/s1QN6j6qErqtUKhFd" +
       "rrLe+dLKasIpzEWP2hI/OnFllUL1KcQjw+Oc6qcBGvsMh48YqU0qou0e5N97" +
       "9riyf/ylZecpGDvdI7YARyYueynU0qKFagLmJuFQDvUagmSImrqbg3OChyq+" +
       "tODNODULruds7p+buOClUAOEmxIwNw2HRrA3CN4N5RU2g069anS3r+I7rquK" +
       "pv+hZWTk9JKfrfD8dXrBh3XxMVi+b7yhetr4JX8VJ3LOB9u6GKlOZVTVu+/3" +
       "3FdC85JSuD7rxCmAweWdx8isoDoMe35xg2KE5gqkNkamFEVipBx/vLALQXF+" +
       "WNjU8F8vXAfo3IWDZcWNF2QRI2UAgreLDRG+ofwmKReUUz7PIJ6+qi1v58//" +
       "68HZpWfE/z3E5YPja9dtP3nu3eKzj6xK27YhlUkxUiW+QHGiuNOfX5KaQ6ty" +
       "Tccnk++vWeB0ak2CYdfVZ3ryz3LIVAa6wwzfBxGrPfdd5KV9yx5+enflsTAJ" +
       "bSQhiZGWjYWnSFkjY5K5G2PFDv02SCb/VtNV+9amox+9HGrmZ/pEHLjMCcKI" +
       "yzc+fLw/ZRg/CpOaHlIBjSjN8iOui7Zq66k8auadIVYm9IyWOzOejL4rYSRx" +
       "zdgKrc+9xc+GjLQWHqgWfkqtVfUxaq5A6kim3nc2kjEM7yzXbFyUOtQ0+FU8" +
       "1msYzklyG9e8YaCThS7gxe6/WiikcdokAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0tsjp5Ms/ME5ff8+L74ZQ/eBxJE5c9Z9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zOG/eqsc5gfyXzng8CtvP4f/+Zy+P86Lb8fQtSMOTxyaH7P4R2+Vxfzj168f" +
       "sPjrbz+Lr5/T99/y4k9j6IqquMLhXYszx7xX5p5n64p7zPF33wLHRaTJffw3" +
       "Dzj+zbeH471jgG/kAHvQ7dneK76AfT+Grmrm7rvpqPiCmR6z+OdvgcUiguUf" +
       "ML92wOLX3nal7t1zTl/+zX3vSgzdA+xW1kPvOIQd8bd351vg74G88RHw/P4B" +
       "f7//9vP30Dl9D+fFg0B7gD8CrDh6VlwG+OIxd+94U98EY+iHbnu9NL8o99BN" +
       "F+B3l7bVL71y7c53vzL+N7urTIcXq+9ioDuNxLZPXoo4Ub/sh7phFgK4a3dF" +
       "wi+4ejKGHjlvTYqhy7tKzsDeE7tBN2LonbccFEMX85+TsM/E0PWzsDF0qfg9" +
       "CfcckOwxHJh2VzkJ8v4YugOA5NV9f+dye6ezgyNHeuAHqeJEQvH0qesWxX8n" +
       "HF6NSHb/n/Ci+uVXetxHX6/9/O52qGor222O5U4GurK7qFogza9XPHlbbIe4" +
       "Lnef/f59v3LXew5TlPt2BB9b7wnaHr/1PUzS8ePi5uT21979j174B6/8YfEN" +
       "7v8CrrsuwDYyAAA=");
}
