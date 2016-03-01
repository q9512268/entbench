package org.apache.batik.dom.svg;
public class TraitInformation {
    public static final short PERCENTAGE_FONT_SIZE = org.apache.batik.dom.anim.AnimationTarget.
                                                       PERCENTAGE_FONT_SIZE;
    public static final short PERCENTAGE_VIEWPORT_WIDTH = org.apache.batik.dom.anim.AnimationTarget.
                                                            PERCENTAGE_VIEWPORT_WIDTH;
    public static final short PERCENTAGE_VIEWPORT_HEIGHT =
      org.apache.batik.dom.anim.AnimationTarget.
        PERCENTAGE_VIEWPORT_HEIGHT;
    public static final short PERCENTAGE_VIEWPORT_SIZE = org.apache.batik.dom.anim.AnimationTarget.
                                                           PERCENTAGE_VIEWPORT_SIZE;
    protected boolean isAnimatable;
    protected int type;
    protected short percentageInterpretation;
    public TraitInformation(boolean isAnimatable,
                            int type,
                            short percentageInterpretation) {
        super(
          );
        this.
          isAnimatable =
          isAnimatable;
        this.
          type =
          type;
        this.
          percentageInterpretation =
          percentageInterpretation;
    }
    public TraitInformation(boolean isAnimatable,
                            int type) { super();
                                        this.isAnimatable =
                                          isAnimatable;
                                        this.type =
                                          type;
                                        this.percentageInterpretation =
                                          -1; }
    public boolean isAnimatable() { return isAnimatable;
    }
    public int getType() { return type; }
    public short getPercentageInterpretation() { return percentageInterpretation;
    }
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
      ("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");
}
