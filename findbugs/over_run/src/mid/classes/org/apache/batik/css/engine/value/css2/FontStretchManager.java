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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
