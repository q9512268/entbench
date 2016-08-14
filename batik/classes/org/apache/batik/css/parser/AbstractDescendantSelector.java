package org.apache.batik.css.parser;
public abstract class AbstractDescendantSelector implements org.w3c.css.sac.DescendantSelector {
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
    public org.w3c.css.sac.Selector getAncestorSelector() { return ancestorSelector;
    }
    public org.w3c.css.sac.SimpleSelector getSimpleSelector() {
        return simpleSelector;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fwEtQtzNMBgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "73ff+BvPfSs7E/1vZqR2hycjAAA=");
}
