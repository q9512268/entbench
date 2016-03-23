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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
