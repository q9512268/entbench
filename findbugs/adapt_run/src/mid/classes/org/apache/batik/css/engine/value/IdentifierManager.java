package org.apache.batik.css.engine.value;
public abstract class IdentifierManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    java.lang.String s =
                                                      lu.
                                                      getStringValue(
                                                        ).
                                                      toLowerCase(
                                                        ).
                                                      intern(
                                                        );
                                                    java.lang.Object v =
                                                      getIdentifiers(
                                                        ).
                                                      get(
                                                        s);
                                                    if (v ==
                                                          null) {
                                                        throw createInvalidIdentifierDOMException(
                                                                lu.
                                                                  getStringValue(
                                                                    ));
                                                    }
                                                    return (org.apache.batik.css.engine.value.Value)
                                                             v;
                                                default:
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                            }
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
        java.lang.Object v =
          getIdentifiers(
            ).
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
    public abstract org.apache.batik.css.engine.value.StringMap getIdentifiers();
    public IdentifierManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Noz/B+sp9WffFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tfnDV//+m377uW9lZ+L/C1m2sRyMIwAA");
}
