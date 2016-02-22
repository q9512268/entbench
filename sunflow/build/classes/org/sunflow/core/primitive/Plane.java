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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jnrxLBnj9Ev8Fd+6/wP35JdpXiMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wJ7gY+U8QdvTt76p1nWDuLxblv+bx/71");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "d//0q18tzxH/H4zOVkHzLgAA";
}
