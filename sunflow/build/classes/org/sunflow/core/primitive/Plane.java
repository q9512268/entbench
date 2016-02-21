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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OsKtruuYe4nl+I/+H0EzCS9KIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
