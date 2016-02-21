package org.sunflow.core.primitive;
public class CornellBox implements org.sunflow.core.PrimitiveList, org.sunflow.core.Shader, org.sunflow.core.LightSource {
    private float minX;
    private float minY;
    private float minZ;
    private float maxX;
    private float maxY;
    private float maxZ;
    private org.sunflow.image.Color left;
    private org.sunflow.image.Color right;
    private org.sunflow.image.Color top;
    private org.sunflow.image.Color bottom;
    private org.sunflow.image.Color back;
    private org.sunflow.image.Color radiance;
    private int samples;
    private float lxmin;
    private float lymin;
    private float lxmax;
    private float lymax;
    private float area;
    private org.sunflow.math.BoundingBox lightBounds;
    public CornellBox() { super();
                          updateGeometry(new org.sunflow.math.Point3(-1, -1,
                                                                     -1),
                                         new org.sunflow.math.Point3(
                                           1,
                                           1,
                                           1));
                          left = new org.sunflow.image.Color(0.8F, 0.25F,
                                                             0.25F);
                          right = new org.sunflow.image.Color(0.25F, 0.25F,
                                                              0.8F);
                          org.sunflow.image.Color gray = new org.sunflow.image.Color(
                            0.7F,
                            0.7F,
                            0.7F);
                          top = (bottom = (back = gray));
                          radiance = org.sunflow.image.Color.WHITE;
                          samples = 16; }
    private void updateGeometry(org.sunflow.math.Point3 c0, org.sunflow.math.Point3 c1) {
        lightBounds =
          new org.sunflow.math.BoundingBox(
            c0);
        lightBounds.
          include(
            c1);
        minX =
          lightBounds.
            getMinimum(
              ).
            x;
        minY =
          lightBounds.
            getMinimum(
              ).
            y;
        minZ =
          lightBounds.
            getMinimum(
              ).
            z;
        maxX =
          lightBounds.
            getMaximum(
              ).
            x;
        maxY =
          lightBounds.
            getMaximum(
              ).
            y;
        maxZ =
          lightBounds.
            getMaximum(
              ).
            z;
        lightBounds.
          enlargeUlps(
            );
        lxmin =
          maxX /
            3 +
            2 *
            minX /
            3;
        lxmax =
          minX /
            3 +
            2 *
            maxX /
            3;
        lymin =
          maxY /
            3 +
            2 *
            minY /
            3;
        lymax =
          minY /
            3 +
            2 *
            maxY /
            3;
        area =
          (lxmax -
             lxmin) *
            (lymax -
               lymin);
    }
    public boolean update(org.sunflow.core.ParameterList pl,
                          org.sunflow.SunflowAPI api) { org.sunflow.math.Point3 corner0 =
                                                          pl.
                                                          getPoint(
                                                            "corner0",
                                                            null);
                                                        org.sunflow.math.Point3 corner1 =
                                                          pl.
                                                          getPoint(
                                                            "corner1",
                                                            null);
                                                        if (corner0 !=
                                                              null &&
                                                              corner1 !=
                                                              null) {
                                                            updateGeometry(
                                                              corner0,
                                                              corner1);
                                                        }
                                                        left =
                                                          pl.
                                                            getColor(
                                                              "leftColor",
                                                              left);
                                                        right =
                                                          pl.
                                                            getColor(
                                                              "rightColor",
                                                              right);
                                                        top =
                                                          pl.
                                                            getColor(
                                                              "topColor",
                                                              top);
                                                        bottom =
                                                          pl.
                                                            getColor(
                                                              "bottomColor",
                                                              bottom);
                                                        back =
                                                          pl.
                                                            getColor(
                                                              "backColor",
                                                              back);
                                                        radiance =
                                                          pl.
                                                            getColor(
                                                              "radiance",
                                                              radiance);
                                                        samples =
                                                          pl.
                                                            getInt(
                                                              "samples",
                                                              samples);
                                                        return true;
    }
    public void init(java.lang.String name,
                     org.sunflow.SunflowAPI api) {
        api.
          geometry(
            name,
            this);
        api.
          shader(
            name +
            ".shader",
            this);
        api.
          parameter(
            "shaders",
            name +
            ".shader");
        api.
          instance(
            name +
            ".instance",
            name);
        api.
          light(
            name +
            ".light",
            this);
    }
    public org.sunflow.math.BoundingBox getBounds() {
        return lightBounds;
    }
    public float getBound(int i) { switch (i) {
                                       case 0:
                                           return minX;
                                       case 1:
                                           return maxX;
                                       case 2:
                                           return minY;
                                       case 3:
                                           return maxY;
                                       case 4:
                                           return minZ;
                                       case 5:
                                           return maxZ;
                                       default:
                                           return 0;
                                   } }
    public boolean intersects(org.sunflow.math.BoundingBox box) {
        org.sunflow.math.BoundingBox b =
          new org.sunflow.math.BoundingBox(
          );
        b.
          include(
            new org.sunflow.math.Point3(
              minX,
              minY,
              minZ));
        b.
          include(
            new org.sunflow.math.Point3(
              maxX,
              maxY,
              maxZ));
        if (b.
              intersects(
                box)) {
            if (!b.
                  contains(
                    new org.sunflow.math.Point3(
                      box.
                        getMinimum(
                          ).
                        x,
                      box.
                        getMinimum(
                          ).
                        y,
                      box.
                        getMinimum(
                          ).
                        z)))
                return true;
            if (!b.
                  contains(
                    new org.sunflow.math.Point3(
                      box.
                        getMinimum(
                          ).
                        x,
                      box.
                        getMinimum(
                          ).
                        y,
                      box.
                        getMaximum(
                          ).
                        z)))
                return true;
            if (!b.
                  contains(
                    new org.sunflow.math.Point3(
                      box.
                        getMinimum(
                          ).
                        x,
                      box.
                        getMaximum(
                          ).
                        y,
                      box.
                        getMinimum(
                          ).
                        z)))
                return true;
            if (!b.
                  contains(
                    new org.sunflow.math.Point3(
                      box.
                        getMinimum(
                          ).
                        x,
                      box.
                        getMaximum(
                          ).
                        y,
                      box.
                        getMaximum(
                          ).
                        z)))
                return true;
            if (!b.
                  contains(
                    new org.sunflow.math.Point3(
                      box.
                        getMaximum(
                          ).
                        x,
                      box.
                        getMinimum(
                          ).
                        y,
                      box.
                        getMinimum(
                          ).
                        z)))
                return true;
            if (!b.
                  contains(
                    new org.sunflow.math.Point3(
                      box.
                        getMaximum(
                          ).
                        x,
                      box.
                        getMinimum(
                          ).
                        y,
                      box.
                        getMaximum(
                          ).
                        z)))
                return true;
            if (!b.
                  contains(
                    new org.sunflow.math.Point3(
                      box.
                        getMaximum(
                          ).
                        x,
                      box.
                        getMaximum(
                          ).
                        y,
                      box.
                        getMinimum(
                          ).
                        z)))
                return true;
            if (!b.
                  contains(
                    new org.sunflow.math.Point3(
                      box.
                        getMaximum(
                          ).
                        x,
                      box.
                        getMaximum(
                          ).
                        y,
                      box.
                        getMaximum(
                          ).
                        z)))
                return true;
        }
        return false;
    }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        state.
          init(
            );
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        int n =
          state.
          getPrimitiveID(
            );
        switch (n) {
            case 0:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      1,
                      0,
                      0));
                break;
            case 1:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      -1,
                      0,
                      0));
                break;
            case 2:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      1,
                      0));
                break;
            case 3:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      -1,
                      0));
                break;
            case 4:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      1));
                break;
            case 5:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      -1));
                break;
            default:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      0));
                break;
        }
        state.
          getGeoNormal(
            ).
          set(
            state.
              getNormal(
                ));
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                state.
                  getNormal(
                    )));
        state.
          setShader(
            this);
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        float intervalMin =
          java.lang.Float.
            NEGATIVE_INFINITY;
        float intervalMax =
          java.lang.Float.
            POSITIVE_INFINITY;
        float orgX =
          r.
            ox;
        float invDirX =
          1 /
          r.
            dx;
        float t1;
        float t2;
        t1 =
          (minX -
             orgX) *
            invDirX;
        t2 =
          (maxX -
             orgX) *
            invDirX;
        int sideIn =
          -1;
        int sideOut =
          -1;
        if (invDirX >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  0;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  1;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  1;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  0;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        float orgY =
          r.
            oy;
        float invDirY =
          1 /
          r.
            dy;
        t1 =
          (minY -
             orgY) *
            invDirY;
        t2 =
          (maxY -
             orgY) *
            invDirY;
        if (invDirY >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  2;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  3;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  3;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  2;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        float orgZ =
          r.
            oz;
        float invDirZ =
          1 /
          r.
            dz;
        t1 =
          (minZ -
             orgZ) *
            invDirZ;
        t2 =
          (maxZ -
             orgZ) *
            invDirZ;
        if (invDirZ >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  4;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  5;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  5;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  4;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        assert sideIn !=
          -1;
        assert sideOut !=
          -1;
        if (sideIn !=
              2 &&
              r.
              isInside(
                intervalMin)) {
            r.
              setMax(
                intervalMin);
            state.
              setIntersection(
                sideIn,
                0,
                0);
        }
        else
            if (sideOut !=
                  2 &&
                  r.
                  isInside(
                    intervalMax)) {
                r.
                  setMax(
                    intervalMax);
                state.
                  setIntersection(
                    sideOut,
                    0,
                    0);
            }
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        int side =
          state.
          getPrimitiveID(
            );
        org.sunflow.image.Color kd =
          null;
        switch (side) {
            case 0:
                kd =
                  left;
                break;
            case 1:
                kd =
                  right;
                break;
            case 3:
                kd =
                  back;
                break;
            case 4:
                kd =
                  bottom;
                break;
            case 5:
                float lx =
                  state.
                    getPoint(
                      ).
                    x;
                float ly =
                  state.
                    getPoint(
                      ).
                    y;
                if (lx >=
                      lxmin &&
                      lx <
                      lxmax &&
                      ly >=
                      lymin &&
                      ly <
                      lymax &&
                      state.
                        getRay(
                          ).
                        dz >
                      0)
                    return state.
                      includeLights(
                        )
                      ? radiance
                      : org.sunflow.image.Color.
                          BLACK;
                kd =
                  top;
                break;
            default:
                assert false;
        }
        state.
          faceforward(
            );
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        return state.
          diffuse(
            kd);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        int side =
          state.
          getPrimitiveID(
            );
        org.sunflow.image.Color kd =
          null;
        switch (side) {
            case 0:
                kd =
                  left;
                break;
            case 1:
                kd =
                  right;
                break;
            case 3:
                kd =
                  back;
                break;
            case 4:
                kd =
                  bottom;
                break;
            case 5:
                float lx =
                  state.
                    getPoint(
                      ).
                    x;
                float ly =
                  state.
                    getPoint(
                      ).
                    y;
                if (lx >=
                      lxmin &&
                      lx <
                      lxmax &&
                      ly >=
                      lymin &&
                      ly <
                      lymax &&
                      state.
                        getRay(
                          ).
                        dz >
                      0)
                    return;
                kd =
                  top;
                break;
            default:
                assert false;
        }
        if (org.sunflow.math.Vector3.
              dot(
                state.
                  getNormal(
                    ),
                state.
                  getRay(
                    ).
                  getDirection(
                    )) >
              0) {
            state.
              getNormal(
                ).
              negate(
                );
            state.
              getGeoNormal(
                ).
              negate(
                );
        }
        state.
          storePhoton(
            state.
              getRay(
                ).
              getDirection(
                ),
            power,
            kd);
        double avg =
          kd.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              avg) {
            power.
              mul(
                kd).
              mul(
                1 /
                  (float)
                    avg);
            org.sunflow.math.OrthoNormalBasis onb =
              org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                state.
                  getNormal(
                    ));
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              avg;
            double v =
              state.
              getRandom(
                0,
                1,
                1);
            float s =
              (float)
                java.lang.Math.
                sqrt(
                  v);
            float s1 =
              (float)
                java.lang.Math.
                sqrt(
                  1.0 -
                    v);
            org.sunflow.math.Vector3 w =
              new org.sunflow.math.Vector3(
              (float)
                java.lang.Math.
                cos(
                  u) *
                s,
              (float)
                java.lang.Math.
                sin(
                  u) *
                s,
              s1);
            w =
              onb.
                transform(
                  w,
                  new org.sunflow.math.Vector3(
                    ));
            state.
              traceDiffusePhoton(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
                power);
        }
    }
    public int getNumSamples() { return samples;
    }
    public void getSamples(org.sunflow.core.ShadingState state) {
        if (lightBounds.
              contains(
                state.
                  getPoint(
                    )) &&
              state.
                getPoint(
                  ).
                z <
              maxZ) {
            int n =
              state.
              getDiffuseDepth(
                ) >
              0
              ? 1
              : samples;
            float a =
              area /
              n;
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                double randX =
                  state.
                  getRandom(
                    i,
                    0);
                double randY =
                  state.
                  getRandom(
                    i,
                    1);
                org.sunflow.math.Point3 p =
                  new org.sunflow.math.Point3(
                  );
                p.
                  x =
                  (float)
                    (lxmin *
                       (1 -
                          randX) +
                       lxmax *
                       randX);
                p.
                  y =
                  (float)
                    (lymin *
                       (1 -
                          randY) +
                       lymax *
                       randY);
                p.
                  z =
                  maxZ -
                    0.001F;
                org.sunflow.core.LightSample dest =
                  new org.sunflow.core.LightSample(
                  );
                dest.
                  setShadowRay(
                    new org.sunflow.core.Ray(
                      state.
                        getPoint(
                          ),
                      p));
                float cosNx =
                  dest.
                  dot(
                    state.
                      getNormal(
                        ));
                if (cosNx <=
                      0)
                    return;
                float cosNy =
                  dest.
                    getShadowRay(
                      ).
                    dz;
                if (cosNy >
                      0) {
                    float r =
                      dest.
                      getShadowRay(
                        ).
                      getMax(
                        );
                    float g =
                      cosNy /
                      (r *
                         r);
                    float scale =
                      g *
                      a;
                    dest.
                      setRadiance(
                        radiance,
                        radiance);
                    dest.
                      getDiffuseRadiance(
                        ).
                      mul(
                        scale);
                    dest.
                      getSpecularRadiance(
                        ).
                      mul(
                        scale);
                    dest.
                      traceShadow(
                        state);
                    state.
                      addSample(
                        dest);
                }
            }
        }
    }
    public void getPhoton(double randX1, double randY1,
                          double randX2,
                          double randY2,
                          org.sunflow.math.Point3 p,
                          org.sunflow.math.Vector3 dir,
                          org.sunflow.image.Color power) {
        p.
          x =
          (float)
            (lxmin *
               (1 -
                  randX2) +
               lxmax *
               randX2);
        p.
          y =
          (float)
            (lymin *
               (1 -
                  randY2) +
               lymax *
               randY2);
        p.
          z =
          maxZ -
            0.001F;
        double u =
          2 *
          java.lang.Math.
            PI *
          randX1;
        double s =
          java.lang.Math.
          sqrt(
            randY1);
        dir.
          set(
            (float)
              (java.lang.Math.
                 cos(
                   u) *
                 s),
            (float)
              (java.lang.Math.
                 sin(
                   u) *
                 s),
            (float)
              -java.lang.Math.
              sqrt(
                1.0F -
                  randY1));
        org.sunflow.image.Color.
          mul(
            (float)
              java.lang.Math.
                PI *
              area,
            radiance,
            power);
    }
    public float getPower() { return radiance.
                                copy1(
                                  ).
                                mul(
                                  (float)
                                    java.lang.Math.
                                      PI *
                                    area).
                                getLuminance(
                                  ); }
    public int getNumPrimitives() { return 1;
    }
    public float getPrimitiveBound(int primID,
                                   int i) {
        switch (i) {
            case 0:
                return minX;
            case 1:
                return maxX;
            case 2:
                return minY;
            case 3:
                return maxY;
            case 4:
                return minZ;
            case 5:
                return maxZ;
            default:
                return 0;
        }
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          minX,
          minY,
          minZ);
        bounds.
          include(
            maxX,
            maxY,
            maxZ);
        if (o2w ==
              null)
            return bounds;
        return o2w.
          transform(
            bounds);
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Z9ZLFXwxtmaMZc5JEl0p8KgcejHhTFRo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "XcePiq2d2ece+ex3feLFPywWfP5flaS+8pVCAAA=");
}
