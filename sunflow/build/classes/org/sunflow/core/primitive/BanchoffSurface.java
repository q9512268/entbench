package org.sunflow.core.primitive;
public class BanchoffSurface implements org.sunflow.core.PrimitiveList {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          1.5F);
        if (o2w !=
              null)
            bounds =
              o2w.
                transform(
                  bounds);
        return bounds;
    }
    public float getPrimitiveBound(int primID, int i) { return (i &
                                                                  1) ==
                                                          0
                                                          ? -1.5F
                                                          : 1.5F;
    }
    public int getNumPrimitives() { return 1; }
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
        org.sunflow.math.Point3 n =
          parent.
          transformWorldToObject(
            state.
              getPoint(
                ));
        state.
          getNormal(
            ).
          set(
            n.
              x *
              (2 *
                 n.
                   x *
                 n.
                   x -
                 1),
            n.
              y *
              (2 *
                 n.
                   y *
                 n.
                   y -
                 1),
            n.
              z *
              (2 *
                 n.
                   z *
                 n.
                   z -
                 1));
        state.
          getNormal(
            ).
          normalize(
            );
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
        org.sunflow.math.Vector3 worldNormal =
          parent.
          transformNormalObjectToWorld(
            state.
              getNormal(
                ));
        state.
          getNormal(
            ).
          set(
            worldNormal);
        state.
          getNormal(
            ).
          normalize(
            );
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
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        float rd2x =
          r.
            dx *
          r.
            dx;
        float rd2y =
          r.
            dy *
          r.
            dy;
        float rd2z =
          r.
            dz *
          r.
            dz;
        float ro2x =
          r.
            ox *
          r.
            ox;
        float ro2y =
          r.
            oy *
          r.
            oy;
        float ro2z =
          r.
            oz *
          r.
            oz;
        double A =
          rd2y *
          rd2y +
          rd2z *
          rd2z +
          rd2x *
          rd2x;
        double B =
          4 *
          (r.
             oy *
             rd2y *
             r.
               dy +
             r.
               oz *
             r.
               dz *
             rd2z +
             r.
               ox *
             r.
               dx *
             rd2x);
        double C =
          -rd2x -
          rd2y -
          rd2z +
          6 *
          (ro2y *
             rd2y +
             ro2z *
             rd2z +
             ro2x *
             rd2x);
        double D =
          2 *
          (2 *
             ro2z *
             r.
               oz *
             r.
               dz -
             r.
               oz *
             r.
               dz +
             2 *
             ro2x *
             r.
               ox *
             r.
               dx +
             2 *
             ro2y *
             r.
               oy *
             r.
               dy -
             r.
               ox *
             r.
               dx -
             r.
               oy *
             r.
               dy);
        double E =
          3.0F /
          8.0F +
          (-ro2z +
             ro2z *
             ro2z -
             ro2y +
             ro2y *
             ro2y -
             ro2x +
             ro2x *
             ro2x);
        double[] t =
          org.sunflow.math.Solvers.
          solveQuartic(
            A,
            B,
            C,
            D,
            E);
        if (t !=
              null) {
            if (t[0] >=
                  r.
                  getMax(
                    ) ||
                  t[t.
                      length -
                      1] <=
                  r.
                  getMin(
                    ))
                return;
            for (int i =
                   0;
                 i <
                   t.
                     length;
                 i++) {
                if (t[i] >
                      r.
                      getMin(
                        )) {
                    r.
                      setMax(
                        (float)
                          t[i]);
                    state.
                      setIntersection(
                        0,
                        0,
                        0);
                    return;
                }
            }
        }
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public BanchoffSurface() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IlDXdbEKr2Ax9h9dbNLmjRsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
