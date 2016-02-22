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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NdQN/orNzf8C+I9frKEcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
