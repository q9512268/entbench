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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PgvVaHxN9vpmduFa/opvdf8DMzsR2Pk0AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MgWjC7VhuOW1vsaEONFlYbkZSgxVpqBm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "P2DSYEKrQgAA");
}
