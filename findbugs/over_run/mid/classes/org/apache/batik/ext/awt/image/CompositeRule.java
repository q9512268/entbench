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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JD/Pgsv/AEcww2hEMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KZpOXcueJfFiBCzVHVdntUk5EhcrnYZH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
