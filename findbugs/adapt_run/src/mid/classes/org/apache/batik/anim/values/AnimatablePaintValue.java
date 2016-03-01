package org.apache.batik.anim.values;
public class AnimatablePaintValue extends org.apache.batik.anim.values.AnimatableColorValue {
    public static final int PAINT_NONE = 0;
    public static final int PAINT_CURRENT_COLOR = 1;
    public static final int PAINT_COLOR = 2;
    public static final int PAINT_URI = 3;
    public static final int PAINT_URI_NONE = 4;
    public static final int PAINT_URI_CURRENT_COLOR = 5;
    public static final int PAINT_URI_COLOR = 6;
    public static final int PAINT_INHERIT = 7;
    protected int paintType;
    protected java.lang.String uri;
    protected AnimatablePaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    protected AnimatablePaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                   float r,
                                   float g,
                                   float b) { super(target,
                                                    r,
                                                    g,
                                                    b); }
    public static org.apache.batik.anim.values.AnimatablePaintValue createNonePaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_NONE;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createCurrentColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_CURRENT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                          float r,
                                                                                          float g,
                                                                                          float b) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target,
          r,
          g,
          b);
        v.
          paintType =
          PAINT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURIPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                        java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURINonePaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                            java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_NONE;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURICurrentColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                                    java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_CURRENT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURIColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                             java.lang.String uri,
                                                                                             float r,
                                                                                             float g,
                                                                                             float b) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target,
          r,
          g,
          b);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createInheritPaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_INHERIT;
        return v;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatablePaintValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatablePaintValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatablePaintValue)
                result;
        }
        if (paintType ==
              PAINT_COLOR) {
            boolean canInterpolate =
              true;
            if (to !=
                  null) {
                org.apache.batik.anim.values.AnimatablePaintValue toPaint =
                  (org.apache.batik.anim.values.AnimatablePaintValue)
                    to;
                canInterpolate =
                  toPaint.
                    paintType ==
                    PAINT_COLOR;
            }
            if (accumulation !=
                  null) {
                org.apache.batik.anim.values.AnimatablePaintValue accPaint =
                  (org.apache.batik.anim.values.AnimatablePaintValue)
                    accumulation;
                canInterpolate =
                  canInterpolate &&
                    accPaint.
                      paintType ==
                    PAINT_COLOR;
            }
            if (canInterpolate) {
                res.
                  paintType =
                  PAINT_COLOR;
                return super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
            }
        }
        int newPaintType;
        java.lang.String newURI;
        float newRed;
        float newGreen;
        float newBlue;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatablePaintValue toValue =
              (org.apache.batik.anim.values.AnimatablePaintValue)
                to;
            newPaintType =
              toValue.
                paintType;
            newURI =
              toValue.
                uri;
            newRed =
              toValue.
                red;
            newGreen =
              toValue.
                green;
            newBlue =
              toValue.
                blue;
        }
        else {
            newPaintType =
              paintType;
            newURI =
              uri;
            newRed =
              red;
            newGreen =
              green;
            newBlue =
              blue;
        }
        if (res.
              paintType !=
              newPaintType ||
              res.
                uri ==
              null ||
              !res.
                 uri.
              equals(
                newURI) ||
              res.
                red !=
              newRed ||
              res.
                green !=
              newGreen ||
              res.
                blue !=
              newBlue) {
            res.
              paintType =
              newPaintType;
            res.
              uri =
              newURI;
            res.
              red =
              newRed;
            res.
              green =
              newGreen;
            res.
              blue =
              newBlue;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public int getPaintType() { return paintType;
    }
    public java.lang.String getURI() { return uri;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return org.apache.batik.anim.values.AnimatablePaintValue.
          createColorPaintValue(
            target,
            0.0F,
            0.0F,
            0.0F);
    }
    public java.lang.String getCssText() {
        switch (paintType) {
            case PAINT_NONE:
                return "none";
            case PAINT_CURRENT_COLOR:
                return "currentColor";
            case PAINT_COLOR:
                return super.
                  getCssText(
                    );
            case PAINT_URI:
                return "url(" +
                uri +
                ")";
            case PAINT_URI_NONE:
                return "url(" +
                uri +
                ") none";
            case PAINT_URI_CURRENT_COLOR:
                return "url(" +
                uri +
                ") currentColor";
            case PAINT_URI_COLOR:
                return "url(" +
                uri +
                ") " +
                super.
                  getCssText(
                    );
            default:
                return "inherit";
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVae5AUxRnv3XsfB/dAHvLmOLBAvPWi+MiBEdZDDvYeOQ6M" +
       "h/GYm+27G5idGWZ6YYEQhSqF0sQygEYNUFaJmlgoViqWlimRlEnUMobyUYlK" +
       "+Qj+4bsif+hp1Jjv657ZmZ3dGbjjqnJV09s33f19/fv1119/3dNHPiMllknq" +
       "DUlLSo1sq0Gtxk7Md0qmRZNxVbKsbnjbK9/2r303Db1WsTNKSnvIuEHJapMl" +
       "iy5XqJq0esh0RbOYpMnUaqc0iS06TWpRc7PEFF3rIRMUqzVlqIqssDY9SbHC" +
       "WslMkFqJMVPpSzPaagtgZGaC9ybGexNb6q/QnCBVsm5sdRtMyWkQ95Rh3ZSr" +
       "z2KkJrFB2izF0kxRYwnFYs0Zk1xo6OrWAVVnjTTDGjeoi2wiViYW5dFQ/3j1" +
       "l9/cOVjDaRgvaZrOOESri1q6upkmE6Tafdui0pS1ifycFCXIGE9lRhoSjtIY" +
       "KI2BUgevWwt6P5Zq6VRc53CYI6nUkLFDjMzOFWJIppSyxXTyPoOEcmZj540B" +
       "7awsWme4fRDvujC2/9c31vy+iFT3kGpFW43dkaETDJT0AKE01UdNa2kySZM9" +
       "pFaDAV9NTUVSlW32aNdZyoAmsTSYgEMLvkwb1OQ6Xa5gJAGbmZaZbmbh9XOj" +
       "sv8r6VelAcA60cUqEC7H9wCwUoGOmf0S2J7dpHijoiW5HeW2yGJsWAUVoGlZ" +
       "irJBPauqWJPgBakTJqJK2kBsNRifNgBVS3QwQZPbWoBQ5NqQ5I3SAO1lZLK/" +
       "XqcogloVnAhswsgEfzUuCUZpim+UPOPzWfviO7ZrK7QoiUCfk1RWsf9joNEM" +
       "X6Mu2k9NCvNANKxakLhbmvjMnighUHmCr7Ko8+TPTl+9cMbxF0SdqQXqdPRt" +
       "oDLrlQ/3jXtlWnz+lUXYjXJDtxQc/BzkfJZ12iXNGQM8zcSsRCxsdAqPd/31" +
       "+psfoZ9ESWUrKZV1NZ0CO6qV9ZShqNS8lmrUlBhNtpIKqiXjvLyVlEE+oWhU" +
       "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" +
       "YeDMjjzNF8L/ATGy5giGLwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Mx55fmh/6iL/nSucOmd14hHqiZemheyN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8NtvdhQufxv85U+99Ioy/ApyuHth240K90Wu9z5LjVXrRFMXQEvvvfn710F+" +
       "EnD/EvQ3P/WnT4w/uPjILZwZeuoUztNN/sPB13678y7584eFu45fiV53RvHa" +
       "SleufRF6f6BGq8AZX/M69O3Hks0f6F8BF7GTLHH64fR+NK8bpsO9XmxV4tRL" +
       "8YP9YMJ5gT884635H2XB70eFN8tg0xiptOucOPF1SqX+3a28Uc8T/u21jHFw" +
       "DXeMhz9Jxv/5DMb/NQu+FRWe3DLGV0GgOhHuWm5wU+bfvl3m7wfXfMd8fgeZ" +
       "nzxhkgWtfZCX/x9nCOK1LPjTqPCWnSDOlMD3blcCfxVc8k4C8h2UwOG+VC6B" +
       "r+alfnQG77/Igh9EhUe3vHmWvCnrH94u6w+Cy92xdn/SrA/O35z1wX1ZcBgV" +
       "HjtmfZatH9x1u8zb4ProjvlHf+LMHz2D+Vuy4CHgwY+Zvx6bP7hwuxL4aXC9" +
       "uJPAi3dQAvfkpe7ZS+AGhn/w1BkCyU61HTwRFR7fC+RMSbztTljB53eS+Pwd" +
       "lMRpv39QPIP1+7LgXccGQDoLNTCim5J+922QfluWmB0y+NKO9JdugfRuFXbG" +
       "yB+9iH7+dR7hPqJ3UD9Skm0sP0d+UDtDZleyoBQV3pR/uQEWQEBwefW9nNDb" +
       "kNOFwk5Y39nJ6Tt3Rk4nKZyV18mCF6LCA7q6VYTjcwd7fo3b4PdIlpid5vju" +
       "jt937zy/0Rl5XBZQUeEc4Lc7rfTVPbPBbTB7NEt8Alyv7Zi9dueZfeiMvKtZ" +
       "MIsK52XRYY4+KDp1buC85LqWKjp7xvPbYPzwka7++Y7xn98ZxnsfdlDPqVln" +
       "0M5O4B/oUeF+xdhuO8b5JzKtPcXF7bot4LAPdgy39zs7qOkZeZssCLfmKKiB" +
       "u/dbe37R7ZrjkwDq+R2/83ee38+ekffpLPg4GD3ADwcbY7C1PWWSn7ilM8tg" +
       "13aj73SyLw4ev+7Twe3nbvLXX7lw72Ov8H+Yf6py/EnafVThXm1lWSeP8p6I" +
       "n/MCVTNy7vdtD/Z6OaG/A3ZRZ81BwPNsIxn2g7+9rfQ5sOO4YaWocHd2O1n2" +
       "F6LCxdNlo8I9+f1kuZeBUPflQLfbyMkivxQV7gJFsugve0cz6Ov9CCpfH+XC" +
       "Tbcn7x4/qWH5VuGRHzd0J56TPHfN0438Y9CjJxGr7eegV+VvvNKjP/pa9Svb" +
       "b3NkS9xk5lG4lyqc334mlDeaPc145qatHbV1rvueHz306/e98+jJy0NbwHtt" +
       "P4HtqRt/BUPYXpR/t7L5p4/94/f//Ve+lZ+0/n8Up2jrpTsAAA==");
}
