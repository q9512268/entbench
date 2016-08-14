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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hlPxV3xhcMAYLAz3rL3IP1nz9r8BuVSQE6wbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JgAA");
}
