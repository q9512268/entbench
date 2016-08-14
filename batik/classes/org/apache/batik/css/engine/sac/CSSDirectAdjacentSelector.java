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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8L8aP34NRSYAAA==");
}
