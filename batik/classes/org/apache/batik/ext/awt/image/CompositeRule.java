package org.apache.batik.ext.awt.image;
public final class CompositeRule implements java.io.Serializable {
    public static final int RULE_OVER = 1;
    public static final int RULE_IN = 2;
    public static final int RULE_OUT = 3;
    public static final int RULE_ATOP = 4;
    public static final int RULE_XOR = 5;
    public static final int RULE_ARITHMETIC = 6;
    public static final int RULE_MULTIPLY = 7;
    public static final int RULE_SCREEN = 8;
    public static final int RULE_DARKEN = 9;
    public static final int RULE_LIGHTEN = 10;
    public static final org.apache.batik.ext.awt.image.CompositeRule OVER =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_OVER);
    public static final org.apache.batik.ext.awt.image.CompositeRule IN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_IN);
    public static final org.apache.batik.ext.awt.image.CompositeRule OUT =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_OUT);
    public static final org.apache.batik.ext.awt.image.CompositeRule ATOP =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_ATOP);
    public static final org.apache.batik.ext.awt.image.CompositeRule XOR =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_XOR);
    public static org.apache.batik.ext.awt.image.CompositeRule ARITHMETIC(float k1,
                                                                          float k2,
                                                                          float k3,
                                                                          float k4) {
        return new org.apache.batik.ext.awt.image.CompositeRule(
          k1,
          k2,
          k3,
          k4);
    }
    public static final org.apache.batik.ext.awt.image.CompositeRule
      MULTIPLY =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_MULTIPLY);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      SCREEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_SCREEN);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      DARKEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_DARKEN);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      LIGHTEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_LIGHTEN);
    public int getRule() { return rule; }
    private int rule;
    private float k1;
    private float k2;
    private float k3;
    private float k4;
    private CompositeRule(int rule) { super(
                                        );
                                      this.
                                        rule =
                                        rule;
    }
    private CompositeRule(float k1, float k2,
                          float k3,
                          float k4) { super(
                                        );
                                      rule =
                                        RULE_ARITHMETIC;
                                      this.
                                        k1 =
                                        k1;
                                      this.
                                        k2 =
                                        k2;
                                      this.
                                        k3 =
                                        k3;
                                      this.
                                        k4 =
                                        k4;
    }
    public float[] getCoefficients() { if (rule !=
                                             RULE_ARITHMETIC)
                                           return null;
                                       return new float[] { k1,
                                       k2,
                                       k3,
                                       k4 };
    }
    private java.lang.Object readResolve()
          throws java.io.ObjectStreamException {
        switch (rule) {
            case RULE_OVER:
                return OVER;
            case RULE_IN:
                return IN;
            case RULE_OUT:
                return OUT;
            case RULE_ATOP:
                return ATOP;
            case RULE_XOR:
                return XOR;
            case RULE_ARITHMETIC:
                return this;
            case RULE_MULTIPLY:
                return MULTIPLY;
            case RULE_SCREEN:
                return SCREEN;
            case RULE_DARKEN:
                return DARKEN;
            case RULE_LIGHTEN:
                return LIGHTEN;
            default:
                throw new java.lang.Error(
                  "Unknown Composite Rule type");
        }
    }
    public java.lang.String toString() { switch (rule) {
                                             case RULE_OVER:
                                                 return "[CompositeRule: OVER]";
                                             case RULE_IN:
                                                 return "[CompositeRule: IN]";
                                             case RULE_OUT:
                                                 return "[CompositeRule: OUT]";
                                             case RULE_ATOP:
                                                 return "[CompositeRule: ATOP]";
                                             case RULE_XOR:
                                                 return "[CompositeRule: XOR]";
                                             case RULE_ARITHMETIC:
                                                 return "[CompositeRule: ARITHMATIC k1:" +
                                                 k1 +
                                                 " k2: " +
                                                 k2 +
                                                 " k3: " +
                                                 k3 +
                                                 " k4: " +
                                                 k4 +
                                                 ']';
                                             case RULE_MULTIPLY:
                                                 return "[CompositeRule: MULTIPLY]";
                                             case RULE_SCREEN:
                                                 return "[CompositeRule: SCREEN]";
                                             case RULE_DARKEN:
                                                 return "[CompositeRule: DARKEN]";
                                             case RULE_LIGHTEN:
                                                 return "[CompositeRule: LIGHTEN]";
                                             default:
                                                 throw new java.lang.Error(
                                                   "Unknown Composite Rule type");
                                         }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+C9MhjnCHzIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9pLFtAolVCaN/iw0x3RLbKqaa2JLpddr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
