package org.apache.batik.css.parser;
public class DefaultDirectAdjacentSelector extends org.apache.batik.css.parser.AbstractSiblingSelector {
    public DefaultDirectAdjacentSelector(short type, org.w3c.css.sac.Selector parent,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          type,
          parent,
          simple);
    }
    public short getSelectorType() { return SAC_DIRECT_ADJACENT_SELECTOR;
    }
    public java.lang.String toString() { return getSelector(
                                                  ) + " + " +
                                         getSiblingSelector(
                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7P6WeMXh2/8B4eM97rEWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u2/9jRe+kZ/E/Tc4c1JvaiEAAA==");
}
