package org.apache.batik.css.engine.value.svg;
public class KerningManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_KERNING_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_KERNING_VALUE; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    if (lu.
                                                          getStringValue(
                                                            ).
                                                          equalsIgnoreCase(
                                                            org.apache.batik.util.CSSConstants.
                                                              CSS_AUTO_VALUE)) {
                                                        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                 AUTO_VALUE;
                                                    }
                                                    throw createInvalidIdentifierDOMException(
                                                            lu.
                                                              getStringValue(
                                                                ));
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
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_AUTO_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     AUTO_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    protected int getOrientation() { return HORIZONTAL_ORIENTATION;
    }
    public KerningManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JSs58rrOKCRQzon+vyRFdvorHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "i4HXHS4bMVMPLWbRrxVtamnBAdpM1l1yEQbVHFUBX0nLSctw6FLRZytKyFJ1" +
       "o611/GBk53orc92dyCNMk8RwoGlsM0HrWnvhcGaNkjW5rLn8AE5meXE6Ykq4" +
       "UCmuGEtd5wWhq80qoxE8ISfeBJPxNR/3kuE8v+jZgkElZW3WBPkhPdEwlGiO" +
       "UNeiqeXcRElkQpdcESvPBLMxAIK054FvT4aFBtYbYrNy7Ma1Hk+N3ca4NHaE" +
       "KYc0O5orCVq+q3hjo5E0Z+zA1hoIa0T4ul2u2BVrRSzwUt3hCGqRcLQajUvq" +
       "EASgUtX3e2180AdBOrdcDZrK0vVJvVZLP1ff/OJ2DG7LNkf2zrtmViXtaL2I" +
       "L+VN1/1p8dDehnD2O3mNDeEDm2ZQ+vX/mqsdY2Vf/k+96/Enld5Hka2dzcZx" +
       "CJ0OXe+NlrpUrQOkTgNKr7/6LgeTneLtb4J96V3/ehf/s8ZbX8Q2/71H+DxK" +
       "8uPM019pvVb+zS3o+N6W2GXni4eRLh7eCDvjq2HkO/yh7bDX7Gn29l1t5nY0" +
       "m7vyVvsVreBYZgWbub/GXq5/jb5sd9oOodvNgHIM1TdDVWF9NzuxzRAGBwxm" +
       "FEKnpq5rqZKzb0zO9bZdDg6ZNcz2pD+fNt6/e+Kw+//SSv/Oa/T9clq8PYTO" +
       "6mq4K3V3Z+5a+yI+egMiZhP8OvBgOyJiL72Iv3GNvvelxWMh9AozqDmmLYXp" +
       "OcOurGnfcl/OX7tROR8Czw7u5v+llfND1+j7nbR4PITOm+kNhWyn8SpSPnED" +
       "Up5NG+8BT2tHytZLL+VHr9H3sbT43cMGu3eMd8RVj5s7V0cyqX/vBqTOloD7" +
       "wNPdkbr70kv9mWv0/WFaPLORuqFqUmRtji52t/xfd/1z5334TBufvlFt3A2e" +
       "4Y42hi+NNrYygK1doV6dChUX5EyWQJK3O2piypI1dMxwF+ahawmOcxyR1bLR" +
       "/vTIaMd2TtN3KN25O5ri2tuNHkMksuqli2eG/OW0+HwIvUz2VSlUM2WmTZ/b" +
       "1+gXblSjD4DH3NGo+dJo9PjOKd4VnONEYLh+tvhlydEXM/xvXFlH6etXMoBv" +
       "psVfgjRro4fN+dKVtPFXN7oo3peBbn7Ji9EGSKU83w1VGSzk13W671yj75/S" +
       "4lshdCtwup5vqs4mmUpbP74v6HMvRtAEUDt8+SM9vb7zsotpm8tU8qeePHvz" +
       "q54c/m12/2HvwtPpDnSzFlnWwcPGA/WTnq9qZibB6c3Ro5f9PX8db9m7ngIC" +
       "Jygz3r+/Qf1BCN1/XdRw5zzwIOK/7XjxVRBD6OSmchDnh2CpvhIOYAuUByH/" +
       "K4TOHYUEXGT/B+F+HEJn9uHAoJvKQZCfAOoABFSPQd5uSICvr64OeAuNnblM" +
       "jh3+CtizkfPXs5EDHw4PHkr3s5uNu6l5tLnbeEl+5km6+7YXyh/d3C+RLWm9" +
       "Tqnc3IFOba66ZETT9P7+q1LbpXWSfPhHt3769EO7nyK3bhje97ADvN175Qsc" +
       "hO2F2ZWL9ede9Zk3fezJb2XHvv8H5jaHAXIqAAA=");
}
