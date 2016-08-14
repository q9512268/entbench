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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
