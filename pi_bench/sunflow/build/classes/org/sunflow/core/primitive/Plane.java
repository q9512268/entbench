package org.sunflow.core.primitive;
public class Plane implements org.sunflow.core.PrimitiveList {
    private org.sunflow.math.Point3 center;
    private org.sunflow.math.Vector3 normal;
    int k;
    private float bnu;
    private float bnv;
    private float bnd;
    private float cnu;
    private float cnv;
    private float cnd;
    public Plane() { super();
                     center = new org.sunflow.math.Point3(0, 0, 0);
                     normal = new org.sunflow.math.Vector3(0, 1, 0);
                     k = 3;
                     bnu = (bnv = (bnd = 0));
                     cnu = (cnv = (cnd = 0)); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        center =
          pl.
            getPoint(
              "center",
              center);
        org.sunflow.math.Point3 b =
          pl.
          getPoint(
            "point1",
            null);
        org.sunflow.math.Point3 c =
          pl.
          getPoint(
            "point2",
            null);
        if (b !=
              null &&
              c !=
              null) {
            org.sunflow.math.Point3 v0 =
              center;
            org.sunflow.math.Point3 v1 =
              b;
            org.sunflow.math.Point3 v2 =
              c;
            org.sunflow.math.Vector3 ng =
              normal =
              org.sunflow.math.Vector3.
                cross(
                  org.sunflow.math.Point3.
                    sub(
                      v1,
                      v0,
                      new org.sunflow.math.Vector3(
                        )),
                  org.sunflow.math.Point3.
                    sub(
                      v2,
                      v0,
                      new org.sunflow.math.Vector3(
                        )),
                  new org.sunflow.math.Vector3(
                    )).
                normalize(
                  );
            if (java.lang.Math.
                  abs(
                    ng.
                      x) >
                  java.lang.Math.
                  abs(
                    ng.
                      y) &&
                  java.lang.Math.
                  abs(
                    ng.
                      x) >
                  java.lang.Math.
                  abs(
                    ng.
                      z))
                k =
                  0;
            else
                if (java.lang.Math.
                      abs(
                        ng.
                          y) >
                      java.lang.Math.
                      abs(
                        ng.
                          z))
                    k =
                      1;
                else
                    k =
                      2;
            float ax;
            float ay;
            float bx;
            float by;
            float cx;
            float cy;
            switch (k) {
                case 0:
                    {
                        ax =
                          v0.
                            y;
                        ay =
                          v0.
                            z;
                        bx =
                          v2.
                            y -
                            ax;
                        by =
                          v2.
                            z -
                            ay;
                        cx =
                          v1.
                            y -
                            ax;
                        cy =
                          v1.
                            z -
                            ay;
                        break;
                    }
                case 1:
                    {
                        ax =
                          v0.
                            z;
                        ay =
                          v0.
                            x;
                        bx =
                          v2.
                            z -
                            ax;
                        by =
                          v2.
                            x -
                            ay;
                        cx =
                          v1.
                            z -
                            ax;
                        cy =
                          v1.
                            x -
                            ay;
                        break;
                    }
                case 2:
                default:
                    {
                        ax =
                          v0.
                            x;
                        ay =
                          v0.
                            y;
                        bx =
                          v2.
                            x -
                            ax;
                        by =
                          v2.
                            y -
                            ay;
                        cx =
                          v1.
                            x -
                            ax;
                        cy =
                          v1.
                            y -
                            ay;
                    }
            }
            float det =
              bx *
              cy -
              by *
              cx;
            bnu =
              -by /
                det;
            bnv =
              bx /
                det;
            bnd =
              (by *
                 ax -
                 bx *
                 ay) /
                det;
            cnu =
              cy /
                det;
            cnv =
              -cx /
                det;
            cnd =
              (cx *
                 ay -
                 cy *
                 ax) /
                det;
        }
        else {
            normal =
              pl.
                getVector(
                  "normal",
                  normal);
            k =
              3;
            bnu =
              (bnv =
                 (bnd =
                    0));
            cnu =
              (cnv =
                 (cnd =
                    0));
        }
        return true;
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
        org.sunflow.core.Instance parent =
          state.
          getInstance(
            );
        org.sunflow.math.Vector3 worldNormal =
          parent.
          transformNormalObjectToWorld(
            normal);
        state.
          getNormal(
            ).
          set(
            worldNormal);
        state.
          getGeoNormal(
            ).
          set(
            worldNormal);
        state.
          setShader(
            parent.
              getShader(
                0));
        state.
          setModifier(
            parent.
              getModifier(
                0));
        org.sunflow.math.Point3 p =
          parent.
          transformWorldToObject(
            state.
              getPoint(
                ));
        float hu;
        float hv;
        switch (k) {
            case 0:
                {
                    hu =
                      p.
                        y;
                    hv =
                      p.
                        z;
                    break;
                }
            case 1:
                {
                    hu =
                      p.
                        z;
                    hv =
                      p.
                        x;
                    break;
                }
            case 2:
                {
                    hu =
                      p.
                        x;
                    hv =
                      p.
                        y;
                    break;
                }
            default:
                hu =
                  (hv =
                     0);
        }
        state.
          getUV(
            ).
          x =
          hu *
            bnu +
            hv *
            bnv +
            bnd;
        state.
          getUV(
            ).
          y =
          hu *
            cnu +
            hv *
            cnv +
            cnd;
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                normal));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r, int primID,
                                   org.sunflow.core.IntersectionState state) {
        float dn =
          normal.
            x *
          r.
            dx +
          normal.
            y *
          r.
            dy +
          normal.
            z *
          r.
            dz;
        if (dn ==
              0.0)
            return;
        float t =
          ((center.
              x -
              r.
                ox) *
             normal.
               x +
             (center.
                y -
                r.
                  oy) *
             normal.
               y +
             (center.
                z -
                r.
                  oz) *
             normal.
               z) /
          dn;
        if (r.
              isInside(
                t)) {
            r.
              setMax(
                t);
            state.
              setIntersection(
                0,
                0,
                0);
        }
    }
    public int getNumPrimitives() { return 1; }
    public float getPrimitiveBound(int primID, int i) { return 0;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        return null;
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
       "GKdf4a/41v1fqm7fB1QjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qLxTlv/a47/83T/32lfK88P/ByMtuLfh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "LgAA";
}
