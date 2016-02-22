package org.sunflow.core;
public class LightSample {
    private org.sunflow.core.Ray shadowRay;
    private org.sunflow.image.Color ldiff;
    private org.sunflow.image.Color lspec;
    org.sunflow.core.LightSample next;
    public LightSample() { super();
                           ldiff = (lspec = null);
                           shadowRay = null;
                           next = null; }
    boolean isValid() { return ldiff != null && lspec != null && shadowRay !=
                          null; }
    public void setShadowRay(org.sunflow.core.Ray shadowRay) { this.shadowRay =
                                                                 shadowRay;
    }
    public final void traceShadow(org.sunflow.core.ShadingState state) { org.sunflow.image.Color opacity =
                                                                           state.
                                                                           traceShadow(
                                                                             shadowRay);
                                                                         org.sunflow.image.Color.
                                                                           blend(
                                                                             ldiff,
                                                                             org.sunflow.image.Color.
                                                                               BLACK,
                                                                             opacity,
                                                                             ldiff);
                                                                         org.sunflow.image.Color.
                                                                           blend(
                                                                             lspec,
                                                                             org.sunflow.image.Color.
                                                                               BLACK,
                                                                             opacity,
                                                                             lspec);
    }
    public org.sunflow.core.Ray getShadowRay() {
        return shadowRay;
    }
    public org.sunflow.image.Color getDiffuseRadiance() {
        return ldiff;
    }
    public org.sunflow.image.Color getSpecularRadiance() {
        return lspec;
    }
    public void setRadiance(org.sunflow.image.Color d,
                            org.sunflow.image.Color s) {
        ldiff =
          d.
            copy1(
              );
        lspec =
          s.
            copy1(
              );
    }
    public float dot(org.sunflow.math.Vector3 v) {
        return shadowRay.
          dot(
            v);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OAJ741WALTd6f+yWiC+dVuiXFf7VHWB/skheSqEHEiMVz23FX8B+eRMeCaUE" +
       "/uuvAXhpQxh4Do+AH74K4Acntm7dCf3xfu5TN50mFCidwCqutxglhd++g3j+" +
       "bZF8JoXuT2NFM/YCKrJ+41QSn30Nkii30t8EnuaRJJqvjwqchfDyHcp+r0g+" +
       "D0bfOjP6peKc4vsPr3WknwVP+whf+/XH95U7lP1RkXwxhR4B+LqOaa4TQwCj" +
       "XzimooQ/Rfml14qyMN7hEcrh64/y63co+5Mi+S8p9GgxipGhrT0lvg3Mr71W" +
       "f/Vu8MyPYM5fH5gHp3ZdHlPxZa0/vwPg/1Ek3wBWCZzWWaBnrPKbr3U8i2sH" +
       "+hFQ/fUBesE1PXHWNflKah9KRnFSXi8bf+cO+P+6SL6VQnfpYXorX30FkFTS" +
       "U2H81asRBmh//5l7QMWlhiduuju4v++mffala/c8/tL0v5VXYU7upN3LQPeY" +
       "a887ewZ95v3uKDZMpwRy7/5EOir//jaFrl/01iDuFH8lk98vqxWHgPefqQai" +
       "8tHb2UqXgXBApeL1SnSLs7392Xp+6fxM7URgj/wggZ2Z3D17bkpWXsY8nj6t" +
       "99cxn9c+9xI9+rlX8E/ur95onrLbFVTuYaCr+1tAJ1OwZ25L7ZjW3YN3fu+h" +
       "37r37cfTxYf2DJ+q5Bne3nLrey6kH6XlzZTdv3/837znN176s/Ko8e8BZiRY" +
       "9iUrAAA=");
}
