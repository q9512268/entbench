package org.apache.batik.css.engine.sac;
public class CSSDescendantSelector extends org.apache.batik.css.engine.sac.AbstractDescendantSelector {
    public CSSDescendantSelector(org.w3c.css.sac.Selector ancestor, org.w3c.css.sac.SimpleSelector simple) {
        super(
          ancestor,
          simple);
    }
    public short getSelectorType() { return SAC_DESCENDANT_SELECTOR;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        org.apache.batik.css.engine.sac.ExtendedSelector p =
          (org.apache.batik.css.engine.sac.ExtendedSelector)
            getAncestorSelector(
              );
        if (!((org.apache.batik.css.engine.sac.ExtendedSelector)
                getSimpleSelector(
                  )).
              match(
                e,
                pseudoE))
            return false;
        for (org.w3c.dom.Node n =
               e.
               getParentNode(
                 );
             n !=
               null;
             n =
               n.
                 getParentNode(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE &&
                  p.
                  match(
                    (org.w3c.dom.Element)
                      n,
                    null)) {
                return true;
            }
        }
        return false;
    }
    public void fillAttributeSet(java.util.Set attrSet) { ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                                             getSimpleSelector(
                                                               )).
                                                            fillAttributeSet(
                                                              attrSet);
    }
    public java.lang.String toString() { return getAncestorSelector(
                                                  ) + " " +
                                         getSimpleSelector(
                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Wyl78AaTvK4zVLjKAPrf8tPOKR0bAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dcMtByYAAA==");
}
