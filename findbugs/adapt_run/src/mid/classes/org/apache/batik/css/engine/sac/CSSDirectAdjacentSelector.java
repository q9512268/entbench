package org.apache.batik.css.engine.sac;
public class CSSDirectAdjacentSelector extends org.apache.batik.css.engine.sac.AbstractSiblingSelector {
    public CSSDirectAdjacentSelector(short type, org.w3c.css.sac.Selector parent,
                                     org.w3c.css.sac.SimpleSelector simple) {
        super(
          type,
          parent,
          simple);
    }
    public short getSelectorType() { return SAC_DIRECT_ADJACENT_SELECTOR;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        org.w3c.dom.Node n =
          e;
        if (!((org.apache.batik.css.engine.sac.ExtendedSelector)
                getSiblingSelector(
                  )).
              match(
                e,
                pseudoE))
            return false;
        while ((n =
                  n.
                    getPreviousSibling(
                      )) !=
                 null &&
                 n.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE)
            ;
        if (n ==
              null)
            return false;
        return ((org.apache.batik.css.engine.sac.ExtendedSelector)
                  getSelector(
                    )).
          match(
            (org.w3c.dom.Element)
              n,
            null);
    }
    public void fillAttributeSet(java.util.Set attrSet) { ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                                             getSelector(
                                                               )).
                                                            fillAttributeSet(
                                                              attrSet);
                                                          ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                                             getSiblingSelector(
                                                               )).
                                                            fillAttributeSet(
                                                              attrSet);
    }
    public java.lang.String toString() { return getSelector(
                                                  ) +
                                         " + " +
                                         getSiblingSelector(
                                           ); }
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
       "q9L0D1/2e6/7nae/lV8Y/C+tD3rpLSYAAA==");
}
