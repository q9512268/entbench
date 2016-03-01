package org.apache.batik.css.engine.value.svg;
public class SVGPaintManager extends org.apache.batik.css.engine.value.svg.SVGColorManager {
    public SVGPaintManager(java.lang.String prop) { super(prop); }
    public SVGPaintManager(java.lang.String prop, org.apache.batik.css.engine.value.Value v) {
        super(
          prop,
          v);
    }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_PAINT; }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    if (lu.
                                                          getStringValue(
                                                            ).
                                                          equalsIgnoreCase(
                                                            org.apache.batik.util.CSSConstants.
                                                              CSS_NONE_VALUE)) {
                                                        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                 NONE_VALUE;
                                                    }
                                                default:
                                                    return super.
                                                      createValue(
                                                        lu,
                                                        engine);
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                            }
                                            java.lang.String value =
                                              lu.
                                              getStringValue(
                                                );
                                            java.lang.String uri =
                                              resolveURI(
                                                engine.
                                                  getCSSBaseURI(
                                                    ),
                                                value);
                                            lu =
                                              lu.
                                                getNextLexicalUnit(
                                                  );
                                            if (lu ==
                                                  null) {
                                                return new org.apache.batik.css.engine.value.URIValue(
                                                  value,
                                                  uri);
                                            }
                                            org.apache.batik.css.engine.value.ListValue result =
                                              new org.apache.batik.css.engine.value.ListValue(
                                              ' ');
                                            result.
                                              append(
                                                new org.apache.batik.css.engine.value.URIValue(
                                                  value,
                                                  uri));
                                            if (lu.
                                                  getLexicalUnitType(
                                                    ) ==
                                                  org.w3c.css.sac.LexicalUnit.
                                                    SAC_IDENT) {
                                                if (lu.
                                                      getStringValue(
                                                        ).
                                                      equalsIgnoreCase(
                                                        org.apache.batik.util.CSSConstants.
                                                          CSS_NONE_VALUE)) {
                                                    result.
                                                      append(
                                                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                          NONE_VALUE);
                                                    return result;
                                                }
                                            }
                                            org.apache.batik.css.engine.value.Value v =
                                              super.
                                              createValue(
                                                lu,
                                                engine);
                                            if (v.
                                                  getCssValueType(
                                                    ) ==
                                                  org.w3c.dom.css.CSSValue.
                                                    CSS_CUSTOM) {
                                                org.apache.batik.css.engine.value.ListValue lv =
                                                  (org.apache.batik.css.engine.value.ListValue)
                                                    v;
                                                for (int i =
                                                       0;
                                                     i <
                                                       lv.
                                                       getLength(
                                                         );
                                                     i++) {
                                                    result.
                                                      append(
                                                        lv.
                                                          item(
                                                            i));
                                                }
                                            }
                                            else {
                                                result.
                                                  append(
                                                    v);
                                            }
                                            return result;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.svg.SVGValueConstants.
                NONE_VALUE) {
            return value;
        }
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            org.apache.batik.css.engine.value.ListValue lv =
              (org.apache.batik.css.engine.value.ListValue)
                value;
            org.apache.batik.css.engine.value.Value v =
              lv.
              item(
                0);
            if (v.
                  getPrimitiveType(
                    ) ==
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_URI) {
                v =
                  lv.
                    item(
                      1);
                if (v ==
                      org.apache.batik.css.engine.value.svg.SVGValueConstants.
                        NONE_VALUE) {
                    return value;
                }
                org.apache.batik.css.engine.value.Value t =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    v);
                if (t !=
                      v) {
                    org.apache.batik.css.engine.value.ListValue result =
                      new org.apache.batik.css.engine.value.ListValue(
                      ' ');
                    result.
                      append(
                        lv.
                          item(
                            0));
                    result.
                      append(
                        t);
                    if (lv.
                          getLength(
                            ) ==
                          3) {
                        result.
                          append(
                            lv.
                              item(
                                1));
                    }
                    return result;
                }
                return value;
            }
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "chi+Qipzgl+En3zPXY1XfivnP8TDjPue9PJlC+S/h7ylDzn/vvPC03+xA50R" +
       "ofPKXnKduwugjAgSymg/4wYJ+LH248nhNhO6eID3LziJxUe6PYnEh8sleM+o" +
       "s/ezR8H3B+DvFHj+N3syd2cV25Tk9sZeXnTfQWLk++kpAG03lHax3WLG392G" +
       "Xl5eyIqXbIcpe/1pgIFRntUDDt1yJTvvmI/BtLOVC/vSxyDLB2NyYW5jefAd" +
       "RnQeKvzThUprS5Uv6bceIk3HAxn1W7/+js+//UVfBePHQjfkAQuG7QgcdZfZ" +
       "R8YvP/nOu29+7GtvzeEb4FbvcfL8Q5nU2bWsy4phVoz2zborM0vIM6OOFMVc" +
       "jriamll27bDthZYDFqbVXgYNP3L7Vxfv+eaHt9nxyRg9Qay96bG3/GD3bY/t" +
       "HPkmedFlnwVHebbfJbnSz9rzcAjdf61ecg7qGx995I9/+5E3brW6/XiGTYIP" +
       "yA//zf98fvfdX/vsFRK1620wGj/2wMa3Nply1ML3/7iRKE+SUYpOl/NmLS3g" +
       "XGLjtWZqNk2WUSmzJY9irj+j0xVfaPW70rK4SOsbzaXrpozqoiv3ekNrYUpG" +
       "sCCDFkHarbFPSQtZaAneXBx4iEiMyaLc8j2jTfstz5LigtX1R9VhwmKCJeuh" +
       "hvGYisZVprwWhY6GRmiUYnJBrK82SkGplEZOIvpFaSF5CVkI59yG5OQV1xxz" +
       "1DIeBfSCT5yU1FbD3gDWVZhBEX1e8OlGa0PWh9GiOmeXzsRJucSMFuZkOKqM" +
       "LdGW6VlkDmLTYOddui0qiDqbcwsF1fw21lpEGywmzKZBoKMGS9LrcGEOEF6p" +
       "qx7JUwuFDBTWijmSxxIcEyihXXKrGiGaulFp+KWoOxN7IjxK+eqCx6oNo+uH" +
       "VkSQ/HqtroZEaKtIZZiSo+kcF2XHGKNt2o76TrEb1qJhv+Zu1BTTeJYPKJoW" +
       "B2N1Up51GSVdpF16MknJttvZuDO/Q7vLllpbiAK5RvtTTpisWqVhvwV8ZY7K" +
       "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" +
       "AA==");
}
