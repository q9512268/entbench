package org.apache.batik.css.engine.sac;
public abstract class AbstractDescendantSelector implements org.w3c.css.sac.DescendantSelector, org.apache.batik.css.engine.sac.ExtendedSelector {
    protected org.w3c.css.sac.Selector ancestorSelector;
    protected org.w3c.css.sac.SimpleSelector simpleSelector;
    protected AbstractDescendantSelector(org.w3c.css.sac.Selector ancestor,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          );
        ancestorSelector =
          ancestor;
        simpleSelector =
          simple;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractDescendantSelector s =
                                                    (org.apache.batik.css.engine.sac.AbstractDescendantSelector)
                                                      obj;
                                                  return s.
                                                           simpleSelector.
                                                    equals(
                                                      simpleSelector);
    }
    public int getSpecificity() { return ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                            ancestorSelector).
                                    getSpecificity(
                                      ) +
                                    ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                       simpleSelector).
                                    getSpecificity(
                                      ); }
    public org.w3c.css.sac.Selector getAncestorSelector() {
        return ancestorSelector;
    }
    public org.w3c.css.sac.SimpleSelector getSimpleSelector() {
        return simpleSelector;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1+0yJvhXYXldFwF/RWSM/wG/1V/WvRsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bD+/300/e8+n3/CRZ7+eX1b8L2piwAPoJgAA");
}
