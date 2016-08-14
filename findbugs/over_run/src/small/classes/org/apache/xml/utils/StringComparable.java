package org.apache.xml.utils;
public class StringComparable implements java.lang.Comparable {
    public static final int UNKNOWN_CASE = -1;
    public static final int UPPER_CASE = 1;
    public static final int LOWER_CASE = 2;
    private java.lang.String m_text;
    private java.util.Locale m_locale;
    private java.text.RuleBasedCollator m_collator;
    private java.lang.String m_caseOrder;
    private int m_mask = -1;
    public StringComparable(final java.lang.String text, final java.util.Locale locale,
                            final java.text.Collator collator,
                            final java.lang.String caseOrder) { super(
                                                                  );
                                                                m_text =
                                                                  text;
                                                                m_locale =
                                                                  locale;
                                                                m_collator =
                                                                  (java.text.RuleBasedCollator)
                                                                    collator;
                                                                m_caseOrder =
                                                                  caseOrder;
                                                                m_mask =
                                                                  getMask(
                                                                    m_collator.
                                                                      getStrength(
                                                                        ));
    }
    public static final java.lang.Comparable getComparator(final java.lang.String text,
                                                           final java.util.Locale locale,
                                                           final java.text.Collator collator,
                                                           final java.lang.String caseOrder) {
        if (caseOrder ==
              null ||
              caseOrder.
              length(
                ) ==
              0) {
            return ((java.text.RuleBasedCollator)
                      collator).
              getCollationKey(
                text);
        }
        else {
            return new org.apache.xml.utils.StringComparable(
              text,
              locale,
              collator,
              caseOrder);
        }
    }
    public final java.lang.String toString() {
        return m_text;
    }
    public int compareTo(java.lang.Object o) {
        final java.lang.String pattern =
          ((org.apache.xml.utils.StringComparable)
             o).
          toString(
            );
        if (m_text.
              equals(
                pattern)) {
            return 0;
        }
        final int savedStrength =
          m_collator.
          getStrength(
            );
        int comp =
          0;
        if (savedStrength ==
              java.text.Collator.
                PRIMARY ||
              savedStrength ==
              java.text.Collator.
                SECONDARY) {
            comp =
              m_collator.
                compare(
                  m_text,
                  pattern);
        }
        else {
            m_collator.
              setStrength(
                java.text.Collator.
                  SECONDARY);
            comp =
              m_collator.
                compare(
                  m_text,
                  pattern);
            m_collator.
              setStrength(
                savedStrength);
        }
        if (comp !=
              0) {
            return comp;
        }
        comp =
          getCaseDiff(
            m_text,
            pattern);
        if (comp !=
              0) {
            return comp;
        }
        else {
            return m_collator.
              compare(
                m_text,
                pattern);
        }
    }
    private final int getCaseDiff(final java.lang.String text,
                                  final java.lang.String pattern) {
        final int savedStrength =
          m_collator.
          getStrength(
            );
        final int savedDecomposition =
          m_collator.
          getDecomposition(
            );
        m_collator.
          setStrength(
            java.text.Collator.
              TERTIARY);
        m_collator.
          setDecomposition(
            java.text.Collator.
              CANONICAL_DECOMPOSITION);
        final int[] diff =
          getFirstCaseDiff(
            text,
            pattern,
            m_locale);
        m_collator.
          setStrength(
            savedStrength);
        m_collator.
          setDecomposition(
            savedDecomposition);
        if (diff !=
              null) {
            if (m_caseOrder.
                  equals(
                    "upper-first")) {
                if (diff[0] ==
                      UPPER_CASE) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            else {
                if (diff[0] ==
                      LOWER_CASE) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        }
        else {
            return 0;
        }
    }
    private final int[] getFirstCaseDiff(final java.lang.String text,
                                         final java.lang.String pattern,
                                         final java.util.Locale locale) {
        final java.text.CollationElementIterator targIter =
          m_collator.
          getCollationElementIterator(
            text);
        final java.text.CollationElementIterator patIter =
          m_collator.
          getCollationElementIterator(
            pattern);
        int startTarg =
          -1;
        int endTarg =
          -1;
        int startPatt =
          -1;
        int endPatt =
          -1;
        final int done =
          getElement(
            java.text.CollationElementIterator.
              NULLORDER);
        int patternElement =
          0;
        int targetElement =
          0;
        boolean getPattern =
          true;
        boolean getTarget =
          true;
        while (true) {
            if (getPattern) {
                startPatt =
                  patIter.
                    getOffset(
                      );
                patternElement =
                  getElement(
                    patIter.
                      next(
                        ));
                endPatt =
                  patIter.
                    getOffset(
                      );
            }
            if (getTarget) {
                startTarg =
                  targIter.
                    getOffset(
                      );
                targetElement =
                  getElement(
                    targIter.
                      next(
                        ));
                endTarg =
                  targIter.
                    getOffset(
                      );
            }
            getTarget =
              (getPattern =
                 true);
            if (patternElement ==
                  done ||
                  targetElement ==
                  done) {
                return null;
            }
            else
                if (targetElement ==
                      0) {
                    getPattern =
                      false;
                }
                else
                    if (patternElement ==
                          0) {
                        getTarget =
                          false;
                    }
                    else
                        if (targetElement !=
                              patternElement) {
                            if (startPatt <
                                  endPatt &&
                                  startTarg <
                                  endTarg) {
                                final java.lang.String subText =
                                  text.
                                  substring(
                                    startTarg,
                                    endTarg);
                                final java.lang.String subPatt =
                                  pattern.
                                  substring(
                                    startPatt,
                                    endPatt);
                                final java.lang.String subTextUp =
                                  subText.
                                  toUpperCase(
                                    locale);
                                final java.lang.String subPattUp =
                                  subPatt.
                                  toUpperCase(
                                    locale);
                                if (m_collator.
                                      compare(
                                        subTextUp,
                                        subPattUp) !=
                                      0) {
                                    continue;
                                }
                                int[] diff =
                                  { UNKNOWN_CASE,
                                UNKNOWN_CASE };
                                if (m_collator.
                                      compare(
                                        subText,
                                        subTextUp) ==
                                      0) {
                                    diff[0] =
                                      UPPER_CASE;
                                }
                                else
                                    if (m_collator.
                                          compare(
                                            subText,
                                            subText.
                                              toLowerCase(
                                                locale)) ==
                                          0) {
                                        diff[0] =
                                          LOWER_CASE;
                                    }
                                if (m_collator.
                                      compare(
                                        subPatt,
                                        subPattUp) ==
                                      0) {
                                    diff[1] =
                                      UPPER_CASE;
                                }
                                else
                                    if (m_collator.
                                          compare(
                                            subPatt,
                                            subPatt.
                                              toLowerCase(
                                                locale)) ==
                                          0) {
                                        diff[1] =
                                          LOWER_CASE;
                                    }
                                if (diff[0] ==
                                      UPPER_CASE &&
                                      diff[1] ==
                                      LOWER_CASE ||
                                      diff[0] ==
                                      LOWER_CASE &&
                                      diff[1] ==
                                      UPPER_CASE) {
                                    return diff;
                                }
                                else {
                                    continue;
                                }
                            }
                            else {
                                continue;
                            }
                        }
        }
    }
    private static final int getMask(final int strength) {
        switch (strength) {
            case java.text.Collator.
                   PRIMARY:
                return -65536;
            case java.text.Collator.
                   SECONDARY:
                return -256;
            default:
                return -1;
        }
    }
    private final int getElement(int maxStrengthElement) {
        return maxStrengthElement &
          m_mask;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GguODEz7/guKRrX5pScAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jQ/+yUPCjyxevIkUksdO4Tw95T+iX/0C");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8Yz2d86Wzh0dlF6VjnZy0Asnj0cvhka8Dj3hxCHpI0cMfzLnb35I2jpgeOs0" +
       "w/dy+gYl/tRZ/0FmwZHMF8ck9eJn0f+1G+QG/Ku8+NW4dNfciPe5G0XXTx+R" +
       "8GDe/YnXI+FzRbHXt3/+em+Vj2MpKj5/csXHwHUwdvf9Bpl29ohp1+bXcfq/" +
       "eIO2L+XFF+LShdjfpWgULN0T+O/eBIHFKVlOJXpAIHoTBBaHJ++6Jm1nDqzR" +
       "gQ4fO1LfZQMUg37/BkR/JS/+fZwnLeTSYAhFDp6wp/r33gTVbz3c1hcPqH7x" +
       "ZrfVv/62nt33gvfC//Ub0PonefGHcemOXPiBMcYt0zxF7R+9CWofyCvzlIj3" +
       "H1D7/h8gtef29gHea37R9X/egOTv5MX/AIIBSO5ZYXREd3RD11IkN+1cyyv/" +
       "8Kkvvv+Vp/5rkc1zwYokNeyE82vkwR4b861Xv/qN37nrkc8UOXSF3yss5ekE" +
       "4qvzg0+k/RYE3HnE3sJxvRMI+z/ecXf3HZcmP8DcTD12IVygD9M+/6KmTvZS" +
       "d1qJi6O37x6epn7vDVq8uHTeMbz5Lmm2OFL98yA5rSmHRuItxxy943tG7udP" +
       "BgGWf/kobxw0JtdE+vkd0mKxY+HU61jgM3feoC3PLTtze1y6Vctx7ci4Qff7" +
       "DnSy0NxvvQnNfaR0IF+/fqC5v34TmnvuSHNv4LPP7A25UGB/6AZ0PZwXYDNu" +
       "A0pLH56TH1F65oE3a5HzbI0vHVD6pR+gjbqKyGduQGQuvmeeiEsXAZH5v2YY" +
       "u5yjY3Q+eTN0JsDGnU5yzjM2337V/1Ts/g9A+8wr91x48BXxP+xs1GGu/u1U" +
       "6YK5dpzj6XDH7s8HoWFaBfG375LjgoIYCGjOtfKugSgX3zncM5d3fatx6e6T" +
       "fePSOVAe74MAvuz7AO3e3Rzv0gKjQJf8tl1s3X9OzhyLtA92vlCN+1+PkUdD" +
       "jqf65k6h+L+Vw0h6zR081nz2FZJ537cbP79LNdYcNcvyWS4A+73Lej6Kxp+4" +
       "7myHc53vP/vdu3/59qcPnxzu3gHeS+ExbI9dO6+36wZxkYmbff7Bf/LDv/DK" +
       "V4r8wf8HJT9a7lA0AAA=");
}
