package org.apache.batik.gvt.text;
public class TextPath {
    private org.apache.batik.ext.awt.geom.PathLength pathLength;
    private float startOffset;
    public TextPath(java.awt.geom.GeneralPath path) { super();
                                                      pathLength = new org.apache.batik.ext.awt.geom.PathLength(
                                                                     path);
                                                      startOffset =
                                                        0; }
    public void setStartOffset(float startOffset) { this.startOffset =
                                                      startOffset;
    }
    public float getStartOffset() { return startOffset; }
    public float lengthOfPath() { return pathLength.lengthOfPath(
                                                      ); }
    public float angleAtLength(float length) { return pathLength.
                                                 angleAtLength(
                                                   length); }
    public java.awt.geom.Point2D pointAtLength(float length) { return pathLength.
                                                                 pointAtLength(
                                                                   length);
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
      ("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" +
       "JgAA");
}
