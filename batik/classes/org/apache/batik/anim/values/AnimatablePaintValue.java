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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4Ct/bf79Fy37eZ7F3Av/A7KJpi8jMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WDU9e83C5WSd7cop53n/ltyfg98BuP5vdmWksoTtzPkwtpu+nzqev30/G+in" +
       "z4KVd0H8t2987J/9/Y+9uKXx8NWLhjZYE//qv/+z37n0pe/81nXmJ+COPCW3" +
       "TTwPcrQfPEO/e1lwOc+qZsH7tgNff0M6si37WH53/9lDRWTr2r3vf+x/D+zp" +
       "p777v64xlHzKus7onao/gb725cexD3w/r7+fO7La74qvnd7BHmBft/KK8z8P" +
       "nzn3rw4L5yeFB9XdBiOfrIFHnoBFdXi06wCbkKvyr14gb1eDl4/nxidOq8+J" +
       "bk/PWvthA/GsdBa/99RE9Vgm5Qa4ntpZzlOnjS5fWmz9QAbpEgX2A4YePPzd" +
       "v/OVH33yxcZh5ibvylcnQCoP7sv1V9k+5tNf+8I73/LSd34+n0mOmh5tbTgP" +
       "L2bBu/PxvSMCe6/V1DaB1z4X5tuiTN1MV7Fz1O2ocC+LUn3hSn/Qb+e10Tx9" +
       "qySdqHAHWBLtnUSubdLradvwWlk8vZPF09eRRRYZZzNBFpndgEgW/VAWfDgL" +
       "rhyhf2SLHhM5rp39D3oDLstSTmE23gTmZ3aYnzkD82EWcW8O81t2mG+E1XsT" +
       "WJ/dYX32DKw5nvXNYb1ni1XkqOsh3bwJpBd3SC+egTSfRn725pA+cIw01+Xr" +
       "wf34m4D73A7uc2fAvSuLfPrm4D66h/u6yvvim8D9/A7382fgPpdFPntzuC+c" +
       "wH0jvL/wJvC+e4f33WfgPZ9FvnhzeO/f4qX6ZJujhOuh/aU3jjZfTz0Brvfu" +
       "0L73GrSFPPLy9UHmHu4vHNuWn+03hd00chrW375JWD8FrvIOVvkGsL76RmDd" +
       "sQrMozX5icln+2DpFMi/+7og80bBIIJpp3KpfqmU3X/9Jk1lYasXj1ZmIz0I" +
       "wZLj4sKuZ9mvnALUfsOAwBT8wJ5dz3ONyz//Xz73O7/w7LfB/Esfzb9ZaRlI" +
       "aPTX/mH9O9nNN28O++MZdj5/AtJTwojJt1e6lsG/3mx7p+1dI+M3Til6+Dtk" +
       "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" +
       "Z/UmkcB1fVInYHQNofUu7ZuNBTNE88dl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("r97cI7iH8seHxyfp3sSDw/iMx6Yf2p/cyH/nCqfOY514DHvixWshe6v8zhsd" +
       "mcvfKH/lUy+9rA2+Wj7cvfQlo8I9YNP807a+1u0TTV0ALb3nxu9wmfzE4P5F" +
       "6m986o8fFz4w/8hNnDt68hTO003+A+Zrv9V5Xv38YeGO49eq15xlvLrS5atf" +
       "pt4b6GDmcIWrXqm+81iy+UuBy+Bq7yTbPv2Aez+a1wzT4V4vtipx6sX6wX4w" +
       "S3mBPzjjzfsfZsHvRYW3qoGuRHrfc0+cGjulUv/uZt7K5wn/9mrGGLgGO8aD" +
       "nyTj/3wG4/+aBd+KCk9sGWOrINDdCPNsL7gh82/fKvP3gUveMZdvI/OTp1Sy" +
       "AN8Hefn/cYYgXsuCP44Kb9sJ4kwJfP9WJfAXwaXuJKDeRgkc7kvlEnglL/Xj" +
       "M3j/WRb8MCo8suUtctQNWf/oVll/AFzejrX3k2Z9cP7GrA/uyYLDqPDoMeuz" +
       "bP3gjltlToDrozvmH/2JM3/kDOZvy4IHgAc/Zv5GbP7gwq1K4GfA9eJOAi/e" +
       "RgnclZe6ay+B6xj+wZNnCCQ7GXfweFR4bC+QMyXxjtthBZ/fSeLzt1ESp/3+" +
       "QfEM1j+dBc8fGwDlzvUAbDNvRPrdt0D6HVlidlDhyzvSX74J0rtV2Bkjf/Qy" +
       "+71v8Bj4Eb2DxpGSbGP5WfSD+hkyu5wFlajwlvwLD7AAAoLLq+/lBN+CnC4U" +
       "dsL67k5O3709cjpJ4ay8ThZ8MCrcZ+hbRTg+u7Dnh94Cv4ezxOxEyPd2/L53" +
       "+/kNz8jjs6AXFc4BfrsTT6/smTG3wOyRLPFxcL22Y/ba7Wf2oTPyrmTBOCqc" +
       "VxWXPfrw6NTZg/NTz7N1xd0zlm+B8UNHuvqnO8Z/ensY733YQSOnZp9BOzvF" +
       "f2BEhXs1c7vtEPJPafA9xfmtui3gsA92DLf/t3dQ4zPy0iwIt+Y40QNv77f2" +
       "/KJbNccnANTzO37nbz+/nzsj79NZ8HEweoAfBjbGYGt7yiQ/cVPnnsGu7Xrf" +
       "+mRfLTx2zSeG28/i1K+/fOHuR18W/yD/3OX407V7eoW7ZyvbPnkc+ET8nB/o" +
       "MzPnfs/2cLCfE/qbYBd11hwEPM82kmE/+BvbSp8DO47rVooKd2Z/J8v+YlR4" +
       "8HTZqHBX/n+y3BeBUPflQLfbyMkivxwV7gBFsujf8o9m0Df6IVW+PsqFG29P" +
       "7z12UsPyrcLDrzd0J56TPHvV0438o9GjJxGr7WejV9RvvEz3P/pa7avb73tU" +
       "W0kz8yjc3Suc335qlDeaPc14+oatHbV1jnzhxw/82j3PHT15eWALeK/tJ7A9" +
       "ef0vadqOH+XfvqT/9NF//L6/9/K38tPa/w/c5AJMzTsAAA==");
}
