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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "x9UFKwAA");
}
