package org.apache.batik.css.engine.sac;
public class CSSChildSelector extends org.apache.batik.css.engine.sac.AbstractDescendantSelector {
    public CSSChildSelector(org.w3c.css.sac.Selector ancestor, org.w3c.css.sac.SimpleSelector simple) {
        super(
          ancestor,
          simple);
    }
    public short getSelectorType() { return SAC_CHILD_SELECTOR; }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        org.w3c.dom.Node n =
          e.
          getParentNode(
            );
        if (n !=
              null &&
              n.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            return ((org.apache.batik.css.engine.sac.ExtendedSelector)
                      getAncestorSelector(
                        )).
              match(
                (org.w3c.dom.Element)
                  n,
                null) &&
              ((org.apache.batik.css.engine.sac.ExtendedSelector)
                 getSimpleSelector(
                   )).
              match(
                e,
                pseudoE);
        }
        return false;
    }
    public void fillAttributeSet(java.util.Set attrSet) { ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                                             getAncestorSelector(
                                                               )).
                                                            fillAttributeSet(
                                                              attrSet);
                                                          ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                                             getSimpleSelector(
                                                               )).
                                                            fillAttributeSet(
                                                              attrSet);
    }
    public java.lang.String toString() { org.w3c.css.sac.SimpleSelector s =
                                           getSimpleSelector(
                                             );
                                         if (s.
                                               getSelectorType(
                                                 ) ==
                                               SAC_PSEUDO_ELEMENT_SELECTOR) {
                                             return java.lang.String.
                                               valueOf(
                                                 getAncestorSelector(
                                                   )) +
                                             s;
                                         }
                                         return getAncestorSelector(
                                                  ) +
                                         " > " +
                                         s;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "iEV6dd3K1oMfM8nrOgOEqwyb/w2+0qW6CRsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "I/8HIh4M+PslAAA=");
}
