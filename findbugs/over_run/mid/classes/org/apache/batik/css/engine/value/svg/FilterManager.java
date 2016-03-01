package org.apache.batik.css.engine.value.svg;
public class FilterManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FILTER_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONE_VALUE;
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
                                                       SAC_URI:
                                                    return new org.apache.batik.css.engine.value.URIValue(
                                                      lu.
                                                        getStringValue(
                                                          ),
                                                      resolveURI(
                                                        engine.
                                                          getCSSBaseURI(
                                                            ),
                                                        lu.
                                                          getStringValue(
                                                            )));
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
                                                    throw createInvalidIdentifierDOMException(
                                                            lu.
                                                              getStringValue(
                                                                ));
                                            }
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            if (value.
                  equalsIgnoreCase(
                    org.apache.batik.util.CSSConstants.
                      CSS_NONE_VALUE)) {
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         NONE_VALUE;
            }
            throw createInvalidIdentifierDOMException(
                    value);
        }
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            return new org.apache.batik.css.engine.value.URIValue(
              value,
              resolveURI(
                engine.
                  getCSSBaseURI(
                    ),
                value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public FilterManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RVyPoslWYjGULmaetchakzU/4q+/nNi97OdznOBV1oxTVCtcKHbAiRz5wtQd" +
       "maaoKutSiZVRc3Juu8UNrXz+dHXZ7NM7fsMvNjK3qJVwXEykVNVzyPEeeEoM" +
       "kyQUbkmlqDQN/vX6JEmYufUCXIOWG3BFsL5JUdOkrBCEkcyathmv2osjDyNF" +
       "JeLFy/Nb2Icn4gG1oPVSXoOTip8StODfXro/UlTh0oFQ8eIl+TPMDiTs9S+G" +
       "s9LWTO6udjjOm1BC8/SwQ5oO5Fa6PF9mTZYvnkJ2cdb5nv9r4hx/U+J/E6g1" +
       "Tm/eev+NNWfFJZOs4v372SzT4dArrrIy1V5T3tmcuUq6l92a8Uz5Euc8nnXJ" +
       "5dWNpzGsF34hNNd362K1ZC5frp5Zd/G1wyVXoJLYiQIYqqqdnv8sxAV9W9pI" +
       "QSm6MzzR8R5qYX4h1Fbxp12X/vl2oI7fIiBREDQW4ojKxy++E0kYxreCqLwH" +
       "FUO5QdKDqEKxNu7TthF5xMyqFkpiekrL/MEygy0zzJY894zt0KpML7t/pKg5" +
       "tybKvZOtUPVRYm5gs7Npqnz1ccowvKPcs7KANeZpyMhouNcw7Gu5olXc84bB" +
       "geQjDm3/BaLW6mwaHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Znae+X90xtc2SCkAAA==");
}
