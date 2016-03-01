package org.apache.batik.css.engine.value.svg;
public class EnableBackgroundManager extends org.apache.batik.css.engine.value.LengthManager {
    protected int orientation;
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_ENABLE_BACKGROUND_VALUE;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_ENABLE_BACKGROUND_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 ACCUMULATE_VALUE;
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
            default:
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.String id =
                  lu.
                  getStringValue(
                    ).
                  toLowerCase(
                    ).
                  intern(
                    );
                if (id ==
                      org.apache.batik.util.CSSConstants.
                        CSS_ACCUMULATE_VALUE) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             ACCUMULATE_VALUE;
                }
                if (id !=
                      org.apache.batik.util.CSSConstants.
                        CSS_NEW_VALUE) {
                    throw createInvalidIdentifierDOMException(
                            id);
                }
                org.apache.batik.css.engine.value.ListValue result =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                result.
                  append(
                    org.apache.batik.css.engine.value.svg.SVGValueConstants.
                      NEW_VALUE);
                lu =
                  lu.
                    getNextLexicalUnit(
                      );
                if (lu ==
                      null) {
                    return result;
                }
                result.
                  append(
                    super.
                      createValue(
                        lu,
                        engine));
                for (int i =
                       1;
                     i <
                       4;
                     i++) {
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    if (lu ==
                          null) {
                        throw createMalformedLexicalUnitDOMException(
                                );
                    }
                    result.
                      append(
                        super.
                          createValue(
                            lu,
                            engine));
                }
                return result;
        }
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine) {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_ACCUMULATE_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 ACCUMULATE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        throw createDOMException(
                );
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            org.apache.batik.css.engine.value.ListValue lv =
              (org.apache.batik.css.engine.value.ListValue)
                value;
            if (lv.
                  getLength(
                    ) ==
                  5) {
                org.apache.batik.css.engine.value.Value lv1 =
                  lv.
                  item(
                    1);
                orientation =
                  HORIZONTAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v1 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv1);
                org.apache.batik.css.engine.value.Value lv2 =
                  lv.
                  item(
                    2);
                orientation =
                  VERTICAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v2 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv2);
                org.apache.batik.css.engine.value.Value lv3 =
                  lv.
                  item(
                    3);
                orientation =
                  HORIZONTAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v3 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv3);
                org.apache.batik.css.engine.value.Value lv4 =
                  lv.
                  item(
                    4);
                orientation =
                  VERTICAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v4 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv4);
                if (lv1 !=
                      v1 ||
                      lv2 !=
                      v2 ||
                      lv3 !=
                      v3 ||
                      lv4 !=
                      v4) {
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
                        v1);
                    result.
                      append(
                        v2);
                    result.
                      append(
                        v3);
                    result.
                      append(
                        v4);
                    return result;
                }
            }
        }
        return value;
    }
    protected int getOrientation() { return orientation;
    }
    public EnableBackgroundManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wcr1/zJHSMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MFvUOElytlTkNbz5DlbD7RJJO8tJJveFkdOWcJ9fzULc8z1U2A6lddBAW5vJ" +
       "0mtL4nRbC5HUGsWEWA2mSGc178S0Ul2F9HwpJj26zm8nFmttt/2gt1MXa6U2" +
       "Dmtec04IUTwc9HN8Wriv3vCTvhPLVWHFTSY2GrN9yqdxmlYUAte2TmWoejLZ" +
       "VLumthutbU1qzWR30cSiRt2IWgrRhAcdlrEDa4h7S4eKWSGa6vZSmcc8H8/U" +
       "btZoRpNJd9ZskfSqssYDRQ5xvDnpr5KBSK4ZYUBPTCYY2Yy6HoxIz6ZmpC9Q" +
       "824oItXucN4Y8uys11gyKD6ztlhPnNoyzk+mnDaI8wlCO16ngiQJ2jRRNZnU" +
       "FG80xRorYSqqPMzay1pXntTjyTYfKtv+vIWHvJml9Y2PblbYctTfRqNhTsGc" +
       "FclNFN1UNs6spdKb/mhnNR3Vo3fTdojPdjCXVxoyHExUZt3Xq0KbGFPwWIso" +
       "clDtkCqDdkPWijsLj5up012jqetmms4CY6fTQ492Rmmypqwkq/Va0XzG8J7k" +
       "uNXGcszONoSAcdOqX7cB5zroNiRmqMCEljkULa/kcbCWHLHa5mNr52BSDx+s" +
       "at1ZErSSmgWP+ZnWVpdjrGkMrCnXS0ewYFY0hJwyZOh7M95d255C2SJNmAjR" +
       "4+fadrcLwiYIF3I2y7gK26vJONUYxNxc700G6yYrjHl7FPLySidjTxxPu3G3" +
       "1wTwlyoLeVRnBK6qTBU3pmbTkU36fsJNsJrQneW91TAwcTAe9rghXV30UdGq" +
       "pAtiN2NxXdW7Yoejp3QwTVWpI2cNkvNiYmyjXrdWYymLzoNoIc/m+BCnd6O6" +
       "Jw+WvMvTPUbZTrYCmMTwcnPU0NM+lrBtDLMGQ7UWVDrsPEpSOIqC4YgBS+mt" +
       "vFs2KVJYMapPL+oqEVK72NAQf4rUJJbjaczpD5WZFSBuCBauQaQv5arOu64l" +
       "G+sGb0ljEoSjMYt9ZeLABo20IrcRt8csvJOxVRp35XG/M5nujPpw5Nvdvsum" +
       "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" +
       "fqR65mRcl93h6t2C5cQS9P2nFo7lTeyj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("RV66v4v9uvaVN8fMj3yn+bP7S2+aq+R5IeVhCnpof/+uFFosFF++rbQjWReJ" +
       "1773+FcfefVoUfv4XuHjPnZCtxdvfats4IVJeQ8s/5Wn/8mH/8Gbf1Tedvi/" +
       "br+QJCIvAAA=");
}
