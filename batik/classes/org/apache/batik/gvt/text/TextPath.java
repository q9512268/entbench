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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oJ5RZ/WzxyJOtltCD+4+e/UjEecElFeIfMgDeXkhK358z8FP+4G5Bjv7rod/" +
       "H3xOgOd/sydjljVs9+FbG7uHgfv3TwM+2KvOZrs4o7p6ZOy5yqsv2b6y5d53" +
       "neH+gG08zEo0K+pbIfAr2tZrjyK/FzwP7SJ/6ArIe1dAnlVbuTrbEXQDWIMg" +
       "2p5frm6mw8B0QPRd757o4Cdv/dri/d/48Pa0dtwmjxGrb3/qF7+/866nTh46" +
       "Iz90yTH18JjtOTmX8qZc1MzLH7jaLPmI9r989Mk//J0n37aV6tajJ74WeKH5" +
       "8N/8z5d2nv76Fy5z9ABG6EnRsYXpv+jCbKU7AQzquvIOvlPMfj9+edVfk1Vf" +
       "DbaWMH+vyaY0XcneW4s7LVu5sGdqAnjPAV5/wbLxPeM6nweszL92ti8Hx2Rt" +
       "/79lBbq8+YAZ44H3jHf+87u/9MsPfQ3ohYauW2ceDRR4aMb+Knv1+oXn3nvP" +
       "DU99/Z35TglsSXjH7yPfzbjqV0OcFU9khbQH9e4M6jg/XjJSGPXyzU2d76Md" +
       "HcIjRGCL9H4AtNHNv0SiIUXsfRhBlMoxX0omhRWCm1GMODI77BQ7DCUvm6xp" +
       "+F7ct+oiUZSbbbbUTHu4iii1XjNM0/6mVCpW6IZAtUxh1OqypFRf43xrNB6x" +
       "3ZUZdTyuNe9MfNKmxhOLiwjfLxaXNid0msulKEjiSlXKc6eCk2o03gi2Kq9w" +
       "upSmAeLWxFIqbmCVNicdzl/68YIOJ91+Z9nuGzzfQiQmabb1xOpW05KJqV2D" +
       "gaN1IPii2OBrfkciFNJrsZPmfGHzlhHV/JY9bjZmHmXxZX7kk9bSGDQlb9hY" +
       "JGObw8fdujvv8uXJiHJLS7LTrffD9pBnlnVFLHZF0Yn64ThuGVydnI0rVkgH" +
       "MA/LXoHt2qRgGMgGG+ObZqRwfiuuSInTK7Wm5YbXbwx6xcVgtBk1+5JaVGyT" +
       "EyfkAme6rMU1WXdtt8UZ3V+Ikwpt6pUpEyWIOmzOR0mrGE/aLcGeNktWIxV4" +
       "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" +
       "/wBw7nvOzyYAAA==");
}
