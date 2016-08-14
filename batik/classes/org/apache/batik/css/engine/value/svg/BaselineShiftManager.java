package org.apache.batik.css.engine.value.svg;
public class BaselineShiftManager extends org.apache.batik.css.engine.value.LengthManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BASELINE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BASELINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SUB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SUB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SUPER_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SUPER_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_BASELINE_SHIFT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_BASELINE_SHIFT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 BASELINE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.Object v =
                  values.
                  get(
                    lu.
                      getStringValue(
                        ).
                      toLowerCase(
                        ).
                      intern(
                        ));
                if (v ==
                      null) {
                    throw createInvalidIdentifierDOMException(
                            lu.
                              getStringValue(
                                ));
                }
                return (org.apache.batik.css.engine.value.Value)
                         v;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        java.lang.Object v =
          values.
          get(
            value.
              toLowerCase(
                ).
              intern(
                ));
        if (v ==
              null) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return (org.apache.batik.css.engine.value.Value)
                 v;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_PERCENTAGE) {
            sm.
              putLineHeightRelative(
                idx,
                true);
            int fsi =
              engine.
              getLineHeightIndex(
                );
            org.apache.batik.css.engine.CSSStylableElement parent;
            parent =
              (org.apache.batik.css.engine.CSSStylableElement)
                elt.
                getParentNode(
                  );
            if (parent ==
                  null) {
                parent =
                  elt;
            }
            org.apache.batik.css.engine.value.Value fs =
              engine.
              getComputedStyle(
                parent,
                pseudo,
                fsi);
            float fsv =
              fs.
              getFloatValue(
                );
            float v =
              value.
              getFloatValue(
                );
            return new org.apache.batik.css.engine.value.FloatValue(
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER,
              fsv *
                v /
                100.0F);
        }
        return super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            value);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public BaselineShiftManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aCbLZu/QWvGKb+f+B0uClNNRIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4XEOCVLKM+1n05392v7iLTh753moOdXteaA5WRLAe0FdvF85hy3vKLz8AfAg" +
       "R9iCnMeWC1D58sGS5dmyvFEU7y3H5IEIuuwHXgS01EGKdyksc9MIaGK5sl12" +
       "9gKoLtecsGR+awTB916e9nkeiKU9tBVltSja+4DA7xg8L5ZdZhcAxlysHDYO" +
       "0eI3fQfli9e/VhTdoqCO1X372lZvHOOOCFJrEDY31nbjWP9rZcQXA3Sk5zkl" +
       "X/h/VhJE9KMnwmgPpLaf+E+f+vo/fPc3QdgNoYulM0C0nepxHBfZ/k988dNP" +
       "venlb32iBFWAqOLH/3HjW4XU2esz9cnCVL7MXGg5jJgS+3SttPaus20SWA5Y" +
       "LpKjVBZ56fo3Nz/37S/t09TzU+scsf6xl//+9w8/+fLBqY+Dd78mPz/Ns/9A" +
       "KJV+85GHA+jZu/VSclD/+Ssv/dY/eumje62un011u+BL7kv/5q++fviZb/3e" +
       "bXKoB23vPgY2utbv18JB+/iPxiRymaoZN48cY8H2o4ayiJLavJ8s5B2jMM2x" +
       "vd7m6+UIWehMNTQ1bSm1K4xc9bcaSFfwOY7LVckVuJQdqlS3vegtZxWC2g3M" +
       "NWEx3d2ma3L2kiQGg65DkHybdjYs2e3SBLfbDITmooW2DHWXzXlHsZVtxYcD" +
       "ZJsgBoIskAAOOv06sUV3bU1gRW6y3eRMa+s2HWrrkLm4xTpCtV1vkboTj5Ig" +
       "s3m1R6eWsCNX/s4m8ulo4FR2aT6cz9mNNd/J7mjLh6kqkTuqzzA9pr7JhADk" +
       "cjK7WQhKI2x4Fp8PDJQaMORCmg7QujzS9Z7LZBnmtCYp4/Bs1+S7dbo7Nvm+" +
       "Do82U41GeUlrmku9ieUsaVN2lZZYwU5WMbupr1m+FoTKKmz6eHM6awjjubgT" +
       "xlTNZsW6Rus7zJNMuZpF3SmnCTmHNONN5HBLIuV22+3KW+C+qzijjV/bpeKw" +
       "icVKHSHDWBLrTLwZbeqOXjPr+LLWsJqSiXJmiDvrYOb10fUsH0uLEPOm9ark" +
       "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" +
       "DMc/8l38c/vrYqot53kh5WEaemh/c60U");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Wnw1PXtHaceyLvVf+N6jv3z5+eMvvEf3Cp9MsFO6vev297G6jh+VN6jyX3/7" +
       "r77/8698o7zx8H8BQKteGTcuAAA=");
}
