package org.apache.batik.css.engine.value.css2;
public class FontStretchManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CONDENSED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          CONDENSED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_EXPANDED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          EXPANDED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_EXTRA_CONDENSED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          EXTRA_CONDENSED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_EXTRA_EXPANDED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          EXTRA_EXPANDED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_NARROWER_VALUE, org.apache.batik.css.engine.value.ValueConstants.
                                                NARROWER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_NORMAL_VALUE, org.apache.batik.css.engine.value.ValueConstants.
                                              NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SEMI_CONDENSED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SEMI_CONDENSED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SEMI_EXPANDED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SEMI_EXPANDED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_ULTRA_CONDENSED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ULTRA_CONDENSED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_ULTRA_EXPANDED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ULTRA_EXPANDED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_WIDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WIDER_VALUE); }
    public boolean isInheritedProperty() {
        return true;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.CSSConstants.
                 CSS_FONT_STRETCH_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.ValueConstants.
                NARROWER_VALUE) {
            sm.
              putParentRelative(
                idx,
                true);
            org.apache.batik.css.engine.CSSStylableElement p =
              org.apache.batik.css.engine.CSSEngine.
              getParentCSSStylableElement(
                elt);
            if (p ==
                  null) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         SEMI_CONDENSED_VALUE;
            }
            org.apache.batik.css.engine.value.Value v =
              engine.
              getComputedStyle(
                p,
                pseudo,
                idx);
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    NORMAL_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         SEMI_CONDENSED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    CONDENSED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         EXTRA_CONDENSED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    EXPANDED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         SEMI_EXPANDED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    SEMI_EXPANDED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         NORMAL_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    SEMI_CONDENSED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         CONDENSED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    EXTRA_CONDENSED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         ULTRA_CONDENSED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    EXTRA_EXPANDED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         EXPANDED_VALUE;
            }
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    ULTRA_CONDENSED_VALUE) {
                return org.apache.batik.css.engine.value.ValueConstants.
                         ULTRA_CONDENSED_VALUE;
            }
            return org.apache.batik.css.engine.value.ValueConstants.
                     EXTRA_EXPANDED_VALUE;
        }
        else
            if (value ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    WIDER_VALUE) {
                sm.
                  putParentRelative(
                    idx,
                    true);
                org.apache.batik.css.engine.CSSStylableElement p =
                  org.apache.batik.css.engine.CSSEngine.
                  getParentCSSStylableElement(
                    elt);
                if (p ==
                      null) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             SEMI_CONDENSED_VALUE;
                }
                org.apache.batik.css.engine.value.Value v =
                  engine.
                  getComputedStyle(
                    p,
                    pseudo,
                    idx);
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        NORMAL_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             SEMI_EXPANDED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        CONDENSED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             SEMI_CONDENSED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        EXPANDED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             EXTRA_EXPANDED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        SEMI_EXPANDED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             EXPANDED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        SEMI_CONDENSED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NORMAL_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        EXTRA_CONDENSED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             CONDENSED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        EXTRA_EXPANDED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             ULTRA_EXPANDED_VALUE;
                }
                if (v ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        ULTRA_CONDENSED_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             EXTRA_CONDENSED_VALUE;
                }
                return org.apache.batik.css.engine.value.ValueConstants.
                         ULTRA_EXPANDED_VALUE;
            }
        return value;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontStretchManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
