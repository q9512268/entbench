package org.apache.batik.anim.timing;
public class InstanceTime implements java.lang.Comparable {
    protected float time;
    protected org.apache.batik.anim.timing.TimingSpecifier creator;
    protected boolean clearOnReset;
    public InstanceTime(org.apache.batik.anim.timing.TimingSpecifier creator,
                        float time,
                        boolean clearOnReset) { super();
                                                this.creator = creator;
                                                this.time = time;
                                                this.clearOnReset = clearOnReset;
    }
    public boolean getClearOnReset() { return clearOnReset; }
    public float getTime() { return time; }
    float dependentUpdate(float newTime) { time = newTime;
                                           if (creator != null) {
                                               return creator.
                                                 handleTimebaseUpdate(
                                                   this,
                                                   time);
                                           }
                                           return java.lang.Float.
                                                    POSITIVE_INFINITY;
    }
    public java.lang.String toString() { return java.lang.Float.toString(
                                                                  time);
    }
    public int compareTo(java.lang.Object o) { org.apache.batik.anim.timing.InstanceTime it =
                                                 (org.apache.batik.anim.timing.InstanceTime)
                                                   o;
                                               if (time ==
                                                     it.
                                                       time)
                                                   return 0;
                                               if (time >
                                                     it.
                                                       time)
                                                   return 1;
                                               return -1;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mD9p4PgF/8Thy/8BQ/hArzcfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZfszsRYu5omlxpIwHmzFbhCByOnVvH7L3sC9pd0LqUEgcWMGa+0Un7An4SJq" +
       "mcWiienmoKaJvcBIi0lg15ZunWImYr2+bKtmS+T7TN8S+5whyIW7NutCfd5i" +
       "E7Tjs3Hitqc8Q9a0fRuvBapMdTUkh8eSKk5aDmtPPdjPwNdIZ98m1C2aDGBE" +
       "4yKHZPuTZjRgYmTUmJupASSNkyvSjTftei2OYjdE17tUcrbtMd1eanRT9Qd8" +
       "c2320pk4Y509p2ShpKtGDS9gu73xyUQp+lhIbTCbEZB9xkrxyAsoj1dbsbBH" +
       "XJvEiZZfQxhvrAoCt0OyokGtGGpjdpzIoBCrKYWJKYxczaFdsrmwOYJwwZKV" +
       "UPCYn8h7nBSHum75fW6uDjpWczojnS7iy0tVwOup1Sgiv9G0zfUaxbYtxWpp" +
       "OzZuiAyqDhWVSVKvsVcNOGC6Gq1mWjiUnBW9qtuYKNH+bOiOmm5ob/foPCK7" +
       "BJC5WhDeXku55srGBYPGQgspVtOFqmVBnvQkb86vGs3+yN0u3W7RVvIwKnLC" +
       "rU3WcD+dIqw/1YrpECy2PRRue7avoNvJgEYlR2y2Ux3JI2A59I4dF8oCy+lO" +
       "c9OCV6MCo1Y7bBT64FO0Hs/4jHCVfi+qN61IiWWLCzm9NQ239Xo4jzq6Pl9a" +
       "hklhaxNGlroqwT4axXg60cYyVa/pAsbXkCY6WNm12Xg8bpKRmKhYtCP7cdfp" +
       "0hvNa85kv2lbXbsz69phF09a4qKPdGR3h3TIMeIS6d50wFf4D5Sf5x9/a9sG" +
       "T1Q7JKdHv37QLiuWb2Fn4FD1fJm8eLqnVP2uQheOC8+fOZztgF66Y6/6zh1Q" +
       "Sd9UzN02/+n4G1/7/P6Lbxy2og0drIIg+H7XBO6+qVCeRL34gNO0swPkPxr8" +
       "+Td//3fVj1w+3qV+2ymoF0sMd52Bnt8oO9lXeufZLs/xaY1xOGT9sXI/+j33" +
       "O72uNuW/8InXXreEn66fjI/n0KN5nPy5wF7bwTmxlTc1Pnh/RHx1eH+2e/tr" +
       "n/hvz8g/6H7sLRwNvvcCnxe7/If8G18ZfMD8G5ehK6d7uXddK7iz0St37uBe" +
       "T+28SCP5jn3c95wK/B2lfF8AT/9Y4P2LAj/T03tvS37/Qc8fcAjxuQfU/e0y" +
       "+YkcurGwc+rituaZdbz2nfbNzvdbFXzmFGJlLE+Dhz+GyH/vIX7hAXV/r0z+" +
       "Tg5dAxDlkw3uM2h/97uAVh45Vrvw6jE09S1Ag+6J6tIZbLQi+NIDoP18mfwj" +
       "MHuWndiRZUe5klh6fhHiG98FxCfLwmfA4xxDdL73s/fPH1D3K2Xyizn0SB6f" +
       "7V8vz7D90neB7caJZsbH2OLvDbbjObzHFvzhXKhq9OUHgP5qmfxqXh5fla7V" +
       "luN7bXBf8Y6vhFWC+JdvRRDbHHrs/MWN8hT66bvuhR3uMpk/9/qNR556Xfn3" +
       "1d2F0/tGj3LQI04RBOdPq87lryap7Rxi8KOHs6ukev1mDj37oEPrHLp6yFQ8" +
       "/7tDo9/KoXfds1EOPVS+ztP+JyDwi7Q59HD1Pk/39Ry6fkYHhj1kzpP8DpAx" +
       "ICmzv1spxFe2l86Fp2N9qqT/5HeS/mmT8/ceypBWXdo7CT+FeLwW+OLrw9HH" +
       "v4X99OHehRno+33ZyyMcdO1wBeQ0hD1/395O+rpKv/Ttx7/06Isn4fbxA8Nn" +
       "un2Ot/fe+5JDL0zy6lrC/pee+icf+vuv/3Z1lvP/ABmLWeZNKQAA");
}
