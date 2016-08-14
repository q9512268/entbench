package org.apache.batik.css.engine.value.svg;
public class SpacingManager extends org.apache.batik.css.engine.value.LengthManager {
    protected java.lang.String property;
    public SpacingManager(java.lang.String prop) { super();
                                                   property = prop; }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_SPACING_VALUE; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                                NORMAL_VALUE;
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
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NORMAL_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             NORMAL_VALUE;
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
                  CSS_NORMAL_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     NORMAL_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hFaKV3zr+g8PAOCZfiEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16a8zsyFWg7zcz95XJ3DszeQxDMpmZ3ElImv3cb7c1CaHd" +
       "bvfLbrvd3e62s8uNH2W3u/1qv9vZWSBSSIBVNsAkm5XI/ECBXdCEwC4IEAoM" +
       "QhBQIqQgtAsrQSKERHgEEWlh0WYXtuz+3nPvnQ0z2pZcXa4659Q5p845dVxV" +
       "L34deSDwkZLnWjvDcsNDkIaHa6txGO48EBwO6QYn+wHQOpYcBDPYdlt9+udu" +
       "/P03P766eYBclpBHZcdxQzk0XSfgQeBaMdBo5MZpa9cCdhAiN+m1HMtoFJoW" +
       "SptB+CyNvO4Maojcoo9ZQCELKGQBLVhA26dQEOn1wInsTo4hO2GwRf4NcolG" +
       "Lntqzl6IPHWeiCf7sn1EhiskgBSu5u8CFKpATn3kyRPZ9zK/TOBPlNDn//33" +
       "3PzP9yE3JOSG6UxzdlTIRAgHkZAHbWArwA/amgY0CXnYAUCbAt+ULTMr+JaQ" +
       "RwLTcOQw8sGJkvLGyAN+Meap5h5Uc9n8SA1d/0Q83QSWdvz2gG7JBpT1Taey" +
       "7iWk8nYo4HUTMubrsgqOUe7fmI4WIm+7iHEi460RBICoV2wQrtyToe53ZNiA" +
       "PLKfO0t2DHQa+qZjQNAH3AiOEiKP35VormtPVjeyAW6HyGMX4bh9F4S6Vigi" +
       "RwmRN14EKyjBWXr8wiydmZ+vj9/zsQ86feeg4FkDqpXzfxUiPXEBiQc68IGj" +
       "gj3ig++mPym/6fMfPUAQCPzGC8B7mF/619/47u984qXf2cN8+x1gWGUN1PC2" +
       "+hnloS+/pfMu/L6cjaueG5j55J+TvDB/7qjn2dSDnvemE4p55+Fx50v8b4vf" +
       "9zPgrw6Q6wPksupakQ3t6GHVtT3TAn4POMCXQ6ANkGvA0TpF/wC5Auu06YB9" +
       "K6vrAQgHyP1W0XTZLd6hinRIIlfRFVg3Hd09rntyuCrqqYcgyBX4IA/C5x3I" +
       "/lf8h4iBrlwboLIqO6bjopzv5vIHKHBCBep2hSrQ6jdo4EY+NEHU9Q1Uhnaw" +
       "AkcdapDDGpAnNJatCKBBDO0KQkDDYmQH2oR/mBuc9/9vqDSX+mZy6RKckLdc" +
       "DAcW9KS+a2nAv60+HxHdb/zs7S8enLjHkb5CpA5HP9yPfliMfghHP9yPfliM" +
       "fghHPzw/OnLpUjHoG3Iu9hYA528DIwGMkQ++a/qvhh/46NP3QdPzkvuh8nNQ" +
       "9O6hunMaOwZFhFShASMvfSr5fuF7ywfIwfmYm3MOm67n6FweKU8i4q2LvnYn" +
       "ujc+8rW//9wnn3NPve5cED8KBi/HzJ356Ys69l0VaDA8npJ/95PyL97+/HO3" +
       "DpD7YYSAUTGUoSJhwHni4hjnnPrZ4wCZy/IAFFh3fVu28q7jqHY9XPluctpS" +
       "TP5DRf1hqOPX5Vb+bfApH5l98Z/3Purl5Rv2xpJP2gUpigD83qn36T/8vb+o" +
       "Feo+jtU3zqx+UxA+eyY+5MRuFJHg4VMbmPkAQLg//hT3Y5/4+kfeXxgAhHj7" +
       "nQa8lZcdGBfgFEI1f/h3tn/0lT/5zB8cnBpNCBfISLFMNT0RMm9Hrt9DSDja" +
       "O075gfHFgo6XW82tuWO7mqmbsmKB3Er/941nKr/41x+7ubcDC7Ycm9F3vjKB" +
       "0/ZvI5Dv++L3/M8nCjKX1Hx9O9XZKdg+aD56Srnt+/Iu5yP9/t9/63/4gvxp" +
       "GH5hyAvMDBRR7NKR4+RMvRHmIQVmvpQd7peyYjbRovvdRXmYa6JAQoq+Wl68" +
       "LTjrFecd70yCclv9+B/87euFv/21bxRinM9wzhoBI3vP7u0uL55MIfk3XwwB" +
       "fTlYQbj6S+N/edN66ZuQogQpqjDQBawPo1F6zmSOoB+48t9/4zff9IEv34cc" +
       "UMh1y5U1Si68D7kGzR4EKxjIUu99372f9eQqLG4WoiIvE35vLY8Vb/dDBt91" +
       "98BD5QnKqe8+9r9YS/nQn/7Dy5RQhJw7rMsX8CX0xR9/vPNdf1Xgn/p+jv1E" +
       "+vIIDZO5U9zqz9h/d/D05d86QK5IyE31KFMU8vgLPUqC2VFwnD7CbPJc//lM" +
       "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" +
       "77WX/ofu0fdv8+LDIfIGM2g7pi2H+fkLd2bz93tP5fyBVyvnM/ChjuSkXns5" +
       "P3mPvk/lxY+EyCNmfiOj2K68i5Q/+iqkvJE35pv3zJGUzGsv5U/co+8zefHp" +
       "ELlhgPBYvJMjzQt2fJ95dFWmkPqFVyH1I3njU/CZHUk9e+2l/vl79P2XvHjx" +
       "vNTjo/hTPhXxs69CxGIJeBI+7z8S8f2vvYifv0ffr+fFL+9FJAFc/6394dTx" +
       "AeY7X/mawSl8oY1febXaeAt8lCNtKK+NNg4KgINjob49FyqpqYUsgawe0vnX" +
       "rGzNHTM8hnnmXoJ3ptNuUStG++KF0S6cAT92PJrm2ofwM7qbqsDLF88C+ct5" +
       "8dsh8jrVB3IICmXmTb9xqtEvvFqNPg2f+Eij8Wuj0fv2udKd/P+BYOX6xal8" +
       "kRz9XoH/x3fWUf76+wXAn+bFH8I0a6+H/Wn5nbTxR682oOTe9uEjbXz4W9VG" +
       "9xW97a/v0fc3efHnIfIQ9DbWN4Gzz6Ly1p86lfBr34qEKaR2/pJPfmPhsZdd" +
       "MtxfjFN/9oUbV9/8wvy/FfdcTi6vXaORq3pkWWfPkc/UL3s+0M1Cgmv7U2Wv" +
       "+Pu7V3CTk2tIcFGAZcH7/9ij/kOIPPWKqOHRgelZxG8eue9dEEPk8r5yFucf" +
       "YRpyJxzIFizPQOYHyzcvQkIuiv+zcPeHyPVTODjovnIW5AqkDkHy6lXvOBag" +
       "r6wuGr6Fq6O5TC+dT/9PbOSRV7KRM18Mbz+X5xe3VI9z8mh/T/W2+rkXhuMP" +
       "fqP5k/t7RKolZ1lO5SqNXNlfaTrJ65+6K7VjWpf77/rmQz937Znjb5CH9gyf" +
       "utYZ3t5250s7XdsLi2s22S+/+Rfe8x9f+JPiXPz/Anyby3Y+LAAA");
}
