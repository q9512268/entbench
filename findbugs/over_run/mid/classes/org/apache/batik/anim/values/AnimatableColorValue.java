package org.apache.batik.anim.values;
public class AnimatableColorValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float red;
    protected float green;
    protected float blue;
    protected AnimatableColorValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableColorValue(org.apache.batik.dom.anim.AnimationTarget target,
                                float r,
                                float g,
                                float b) { super(target);
                                           red = r;
                                           green = g;
                                           blue = b; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableColorValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableColorValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableColorValue)
                result;
        }
        float oldRed =
          res.
            red;
        float oldGreen =
          res.
            green;
        float oldBlue =
          res.
            blue;
        res.
          red =
          red;
        res.
          green =
          green;
        res.
          blue =
          blue;
        org.apache.batik.anim.values.AnimatableColorValue toColor =
          (org.apache.batik.anim.values.AnimatableColorValue)
            to;
        org.apache.batik.anim.values.AnimatableColorValue accColor =
          (org.apache.batik.anim.values.AnimatableColorValue)
            accumulation;
        if (to !=
              null) {
            res.
              red +=
              interpolation *
                (toColor.
                   red -
                   res.
                     red);
            res.
              green +=
              interpolation *
                (toColor.
                   green -
                   res.
                     green);
            res.
              blue +=
              interpolation *
                (toColor.
                   blue -
                   res.
                     blue);
        }
        if (accumulation !=
              null) {
            res.
              red +=
              multiplier *
                accColor.
                  red;
            res.
              green +=
              multiplier *
                accColor.
                  green;
            res.
              blue +=
              multiplier *
                accColor.
                  blue;
        }
        if (res.
              red !=
              oldRed ||
              res.
                green !=
              oldGreen ||
              res.
                blue !=
              oldBlue) {
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableColorValue o =
          (org.apache.batik.anim.values.AnimatableColorValue)
            other;
        float dr =
          red -
          o.
            red;
        float dg =
          green -
          o.
            green;
        float db =
          blue -
          o.
            blue;
        return (float)
                 java.lang.Math.
                 sqrt(
                   dr *
                     dr +
                     dg *
                     dg +
                     db *
                     db);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableColorValue(
          target,
          0.0F,
          0.0F,
          0.0F);
    }
    public java.lang.String getCssText() {
        return "rgb(" +
        java.lang.Math.
          round(
            red *
              255) +
        ',' +
        java.lang.Math.
          round(
            green *
              255) +
        ',' +
        java.lang.Math.
          round(
            blue *
              255) +
        ')';
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "O/AYluiMyUu9EGoR3r5XZO37bHicogoJqxH77q6IiCtimqYQrOYXsyOsJ65Z" +
       "WA3IstNxi+PxyQurEKpHIC4e9nCqJ4pI7Fk2/ISi6rgsPG+QX2SFHd6PXTPv" +
       "3D1ZXtlhMbBj8rwXQi3C2i+KrJ1kw/MU1UA7OEQMzfFPh/EXrpnxRrY0C57d" +
       "1ul3T57xQqhFmDtdZO23bHgJ9A2MhyBLQT6wY1k9b/xYYRUQF9SOKF7+HypZ" +
       "iqblu5ljLWZLzp8F4oJbeuZwXeWMw3f/gd8OZS6ha6DZSqQUxV2xud7LdYMk" +
       "ZM5djajfRNX+BhSExcIztJvihXNwTiC9RdH0vEhQYbAvN+x5kJkXFsol/u2G" +
       "+yOI24GDbcWLG+QihHsAYa/v6cJzfdllRkYX06+mC1dlsiAr7/N/cuwcnRL/" +
       "5UD7e3j1mvsvf+UpcbMlKXh8nFGZAv2SuGTL5Pn5BanZtMpXdVyZeqJqoV3r" +
       "NIgDO1Y+02WKPRCkdGYOrZ47H7M9c/Vz/siyk6/vKj8HbcZ65MMUNa3Prf/T" +
       "egqKkPXhfJ0hVEH8Oqq7+v0NZz57x9fIry2Q6CXnFMOISvtOXogkdP1xP6rq" +
       "RWVQypE0b07u2KKuJdKokdVolse0lJr502cqs13MnIhLxhJobWaW3YxS1Jbb" +
       "defeFlcr2hgxljPqjEytpzJK6bp7lUv26yLLMUmDXUXDfbpuXzfM55LXdW5k" +
       "l3me+y+6fJ8drh0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QlbcMWtbT+zxLFqOwqBSbeAhKvDIblIj2Ykq74S1XBcjf9LTkAnb7tNuV/AN" +
       "3WwPu2Z1YUya7TxAtV5eT1x0WU30VE67vaiVkj1qNI6Gto4pA72G4ERtqMbI" +
       "uMNXq80YldPqmhXn9d5OMhseOSPixRatFzHNNpY2UWNiFUMwv9tj5lnP7adK" +
       "w2xz9aweUKIchvGaQ6ubyaxHEZtp1grUKBlGw2kliztdz7Jio4XDy7a9MXbb" +
       "XdKRq8kuo4khGsdovK5OMnMTZetxN0+dJS22xgiP1ZFmjcoM3OPxzaLnIOaw" +
       "nYiNqZ21A0LtBSlPdyZMizcRb5JGCdIKZDxMlpV2xrCNXl3JORCSSGfCSDGR" +
       "GdsxYcMNw9BHy0hcL6fivOaL3VRqs2MZsdazmo2RLMKhbGVlakCwDCXz263e" +
       "t2zXY0m5n1MILC71dFP3xjGhDipZ25x66nq12fIRKW+xKmEkJArvVFfrMLA9" +
       "E/Uplo5cZrXmJ3WHjsatedMkKvF2nC/rSR8xJ0RrxqQ1qcF7lt+crDONI9T+" +
       "KGTIKZsNZmvSksxJxGnm0JdYQt7ArsF14YXJUxnwiO1KEVZKxcVq491C7ov5" +
       "WnSmBNEgxoouw9qWy4ldrU7jLXVmIWIiycNozpq9xmrUqMzX4nCtteqJzCtw" +
       "LRYrhN6Sgs6k2yNrvS3Wy1pOBfVcmeotRDXPN4ShDIk0nixr4qYbTjU6dYig" +
       "xm6ilmN31mSLV+IljGLShFg5fEfQUHna2Q65Fj7Oa7jcFTa61oO5bT5eBZHV" +
       "MJaBrjIbLR1hw4aQ2WKybEWxlG2VRdWTYM4ee0rq6xxWo5lmVxrucHc8RAWB" +
       "McKptLNdMQqag2RMaJyMoWRrFLjUemUFKcVm4D1YrfLpSF3UqtK2wSX8tm+R" +
       "nF3PB9V8jG7RiTyhTcGfw811A6vl864ugrzZXbT7/mJLpyM6azQQjBpXq92h" +
       "3e2b3JwXGYQD4c9NOGTs94dsWx5wE3wYVDV9xNN5NZ4D1aptkOPdLZISDbqZ" +
       "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");
}
