package org.apache.batik.gvt.flow;
class WordInfo {
    int index = -1;
    float ascent = -1;
    float descent = -1;
    float lineHeight = -1;
    org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups = null;
    java.lang.Object flowLine = null;
    WordInfo(int index) { super();
                          this.index = index; }
    WordInfo(int index, float ascent, float descent, float lineHeight, org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups) {
        super(
          );
        this.
          index =
          index;
        this.
          ascent =
          ascent;
        this.
          descent =
          descent;
        this.
          lineHeight =
          lineHeight;
        this.
          glyphGroups =
          glyphGroups;
    }
    public int getIndex() { return index; }
    public float getAscent() { return ascent; }
    public void setAscent(float ascent) { this.ascent = ascent; }
    public float getDescent() { return descent; }
    public void setDescent(float descent) { this.descent = descent;
    }
    public void addLineMetrics(org.apache.batik.gvt.font.GVTFont font,
                               org.apache.batik.gvt.font.GVTLineMetrics lm) {
        if (ascent <
              lm.
              getAscent(
                ))
            ascent =
              lm.
                getAscent(
                  );
        if (descent <
              lm.
              getDescent(
                ))
            descent =
              lm.
                getDescent(
                  );
    }
    public float getLineHeight() { return this.lineHeight; }
    public void setLineHeight(float lineHeight) { this.lineHeight =
                                                    lineHeight; }
    public void addLineHeight(float lineHeight) { if (this.lineHeight <
                                                        lineHeight)
                                                      this.
                                                        lineHeight =
                                                        lineHeight;
    }
    public java.lang.Object getFlowLine() { return this.flowLine;
    }
    public void setFlowLine(java.lang.Object fl) { this.flowLine =
                                                     fl; }
    public int getNumGlyphGroups() { if (glyphGroups == null) return -1;
                                     return glyphGroups.length; }
    public void setGlyphGroups(org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups) {
        this.
          glyphGroups =
          glyphGroups;
    }
    public org.apache.batik.gvt.flow.GlyphGroupInfo getGlyphGroup(int idx) {
        if (glyphGroups ==
              null)
            return null;
        return glyphGroups[idx];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dwOl/JX3E7fbr1a82f/Cx19+RWF/qXJp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/5C0EZXuizz/R211o9onutptZlGP2Liad/8oOOp7NupnH8keA/2LvpL51xfU" +
       "/Zu8+EpUuqKrUf/oRcWxXL/6Rt6nnMFWiPlxcKB7bOidx/Z7F9T9p7z4GlAE" +
       "wIYdv2Y4Bvdv3wS4t+U33wuO5h5c886AOzgmIAuCP7wA4R/lxTcAwvAQ4blP" +
       "fjeeoRyj/oM3q9IfBMf79qjfd+dV+j8vqPtuXvyPqHQ/UGlXPU+n336zOn0B" +
       "HDf36G6+NTo9KN0e4sGl/Ob3AMTwFMQ/OYb4Z28W4o+B48U9xBfvDMQzL9qf" +
       "Pn9ThedGN8CSGvf2hnr77Rd7yvwdE6NGgSGHhXAeuEBwj+TFvVHpIUlRTrQ7" +
       "LbyDK2/W+p8ER28vvN4dt/6Dd19Q92RePBqVHgTWT59+UXkM8LE3ax1lcOB7" +
       "gPhbNAHeewHKF/LiWYAyPIvyhBqv3wmU5B4l+RahrF2AspEXMEC5t9ZzUZbf" +
       "BMpH8ptPgIPZo2TuvLF+8IK6dl7czN9fqxG+f12c0/3iMbz334n4O9zDG95x" +
       "Jf5igYO+AOMwLwiAMTyN8YQKyTeBsUgOnwIHt8fI3XkVzi+oE/NiAlJwoMJh" +
       "7BCnNyIcZ4kH0zeryPeDY7YHObvjimQKNMoFSLW8eAnEDqDIMzBP6PLDbwJm" +
       "ngcX+0Hme5jzOw6zWkC5YEfVQb5f8MDaBZBjmDnl6Bil/Ya2UIGlw+EXE/k+" +
       "8Mdu+fZq972Q/KVXrl559JXZv9/tTD38puc+unRFi2375ObAE+f3+IGqGQXu" +
       "+3ZbBf0CxzYq/cBtt22ChDf/y1k9SHf0PxWV3nEefVS6C5QnKT8ala6dpYxK" +
       "l4v/k3QfBwnaMV2+r6o4OUnyM6B3QJKffsLf+ZODQn6PnbSQIqN75PVEfmId" +
       "+uyp7YfFF3GHWwXj3TdxL8lffoUa/uR3Gr+0+9JBtqUsy3u5Qpfu3X10UXSa" +
       "bzd8+ra9HfZ1D/n89x761fueO1zZPrRj+NhaT/D2nvO/L+g5flR8EZD940f/" +
       "4fv/7iu/X2x9+f/nsKLHqjgAAA==");
}
