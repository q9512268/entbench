package org.sunflow.core.primitive;
public class Hair implements org.sunflow.core.PrimitiveList, org.sunflow.core.Shader {
    private int numSegments;
    private float[] points;
    private org.sunflow.core.ParameterList.FloatParameter widths;
    public Hair() { super();
                    numSegments = 1;
                    points = null;
                    widths = new org.sunflow.core.ParameterList.FloatParameter(
                               1.0F); }
    public int getNumPrimitives() { return numSegments * (points.length /
                                                            (3 *
                                                               (numSegments +
                                                                  1))); }
    public float getPrimitiveBound(int primID, int i) { int hair = primID /
                                                          numSegments;
                                                        int line = primID %
                                                          numSegments;
                                                        int vn = hair * (numSegments +
                                                                           1) +
                                                          line;
                                                        int vRoot =
                                                          hair *
                                                          3 *
                                                          (numSegments +
                                                             1);
                                                        int v0 = vRoot +
                                                          line *
                                                          3;
                                                        int v1 = v0 +
                                                          3;
                                                        int axis =
                                                          i >>>
                                                          1;
                                                        if ((i & 1) ==
                                                              0) {
                                                            return java.lang.Math.
                                                              min(
                                                                points[v0 +
                                                                         axis] -
                                                                  0.5F *
                                                                  getWidth(
                                                                    vn),
                                                                points[v1 +
                                                                         axis] -
                                                                  0.5F *
                                                                  getWidth(
                                                                    vn +
                                                                      1));
                                                        }
                                                        else {
                                                            return java.lang.Math.
                                                              max(
                                                                points[v0 +
                                                                         axis] +
                                                                  0.5F *
                                                                  getWidth(
                                                                    vn),
                                                                points[v1 +
                                                                         axis] +
                                                                  0.5F *
                                                                  getWidth(
                                                                    vn +
                                                                      1));
                                                        }
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          );
        for (int i =
               0,
               j =
                 0;
             i <
               points.
                 length;
             i +=
               3,
               j++) {
            float w =
              0.5F *
              getWidth(
                j);
            bounds.
              include(
                points[i] -
                  w,
                points[i +
                         1] -
                  w,
                points[i +
                         2] -
                  w);
            bounds.
              include(
                points[i] +
                  w,
                points[i +
                         1] +
                  w,
                points[i +
                         2] +
                  w);
        }
        if (o2w !=
              null)
            bounds =
              o2w.
                transform(
                  bounds);
        return bounds;
    }
    private float getWidth(int i) { switch (widths.
                                              interp) {
                                        case NONE:
                                            return widths.
                                                     data[0];
                                        case VERTEX:
                                            return widths.
                                                     data[i];
                                        default:
                                            return 0;
                                    } }
    private org.sunflow.math.Vector3 getTangent(int line,
                                                int v0,
                                                float v) {
        org.sunflow.math.Vector3 vcurr =
          new org.sunflow.math.Vector3(
          points[v0 +
                   3] -
            points[v0 +
                     0],
          points[v0 +
                   4] -
            points[v0 +
                     1],
          points[v0 +
                   5] -
            points[v0 +
                     2]);
        vcurr.
          normalize(
            );
        if (line ==
              0 ||
              line ==
              numSegments -
              1)
            return vcurr;
        if (v <=
              0.5F) {
            org.sunflow.math.Vector3 vprev =
              new org.sunflow.math.Vector3(
              points[v0 +
                       0] -
                points[v0 -
                         3],
              points[v0 +
                       1] -
                points[v0 -
                         2],
              points[v0 +
                       2] -
                points[v0 -
                         1]);
            vprev.
              normalize(
                );
            float t =
              v +
              0.5F;
            float s =
              1 -
              t;
            float vx =
              vprev.
                x *
              s +
              vcurr.
                x *
              t;
            float vy =
              vprev.
                y *
              s +
              vcurr.
                y *
              t;
            float vz =
              vprev.
                z *
              s +
              vcurr.
                z *
              t;
            return new org.sunflow.math.Vector3(
              vx,
              vy,
              vz);
        }
        else {
            v0 +=
              3;
            org.sunflow.math.Vector3 vnext =
              new org.sunflow.math.Vector3(
              points[v0 +
                       3] -
                points[v0 +
                         0],
              points[v0 +
                       4] -
                points[v0 +
                         1],
              points[v0 +
                       5] -
                points[v0 +
                         2]);
            vnext.
              normalize(
                );
            float t =
              1.5F -
              v;
            float s =
              1 -
              t;
            float vx =
              vnext.
                x *
              s +
              vcurr.
                x *
              t;
            float vy =
              vnext.
                y *
              s +
              vcurr.
                y *
              t;
            float vz =
              vnext.
                z *
              s +
              vcurr.
                z *
              t;
            return new org.sunflow.math.Vector3(
              vx,
              vy,
              vz);
        }
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        int hair =
          primID /
          numSegments;
        int line =
          primID %
          numSegments;
        int vRoot =
          hair *
          3 *
          (numSegments +
             1);
        int v0 =
          vRoot +
          line *
          3;
        int v1 =
          v0 +
          3;
        float vx =
          points[v1 +
                   0] -
          points[v0 +
                   0];
        float vy =
          points[v1 +
                   1] -
          points[v0 +
                   1];
        float vz =
          points[v1 +
                   2] -
          points[v0 +
                   2];
        float ux =
          r.
            dy *
          vz -
          r.
            dz *
          vy;
        float uy =
          r.
            dz *
          vx -
          r.
            dx *
          vz;
        float uz =
          r.
            dx *
          vy -
          r.
            dy *
          vx;
        float nx =
          uy *
          vz -
          uz *
          vy;
        float ny =
          uz *
          vx -
          ux *
          vz;
        float nz =
          ux *
          vy -
          uy *
          vx;
        float tden =
          1 /
          (nx *
             r.
               dx +
             ny *
             r.
               dy +
             nz *
             r.
               dz);
        float tnum =
          nx *
          (points[v0 +
                    0] -
             r.
               ox) +
          ny *
          (points[v0 +
                    1] -
             r.
               oy) +
          nz *
          (points[v0 +
                    2] -
             r.
               oz);
        float t =
          tnum *
          tden;
        if (r.
              isInside(
                t)) {
            int vn =
              hair *
              (numSegments +
                 1) +
              line;
            float px =
              r.
                ox +
              t *
              r.
                dx;
            float py =
              r.
                oy +
              t *
              r.
                dy;
            float pz =
              r.
                oz +
              t *
              r.
                dz;
            float qx =
              px -
              points[v0 +
                       0];
            float qy =
              py -
              points[v0 +
                       1];
            float qz =
              pz -
              points[v0 +
                       2];
            float q =
              (vx *
                 qx +
                 vy *
                 qy +
                 vz *
                 qz) /
              (vx *
                 vx +
                 vy *
                 vy +
                 vz *
                 vz);
            if (q <=
                  0) {
                if (line ==
                      0)
                    return;
                float dx =
                  points[v0 +
                           0] -
                  px;
                float dy =
                  points[v0 +
                           1] -
                  py;
                float dz =
                  points[v0 +
                           2] -
                  pz;
                float d2 =
                  dx *
                  dx +
                  dy *
                  dy +
                  dz *
                  dz;
                float width =
                  getWidth(
                    vn);
                if (d2 <
                      width *
                      width *
                      0.25F) {
                    r.
                      setMax(
                        t);
                    state.
                      setIntersection(
                        primID,
                        0,
                        0);
                }
            }
            else
                if (q >=
                      1) {
                    float dx =
                      points[v1 +
                               0] -
                      px;
                    float dy =
                      points[v1 +
                               1] -
                      py;
                    float dz =
                      points[v1 +
                               2] -
                      pz;
                    float d2 =
                      dx *
                      dx +
                      dy *
                      dy +
                      dz *
                      dz;
                    float width =
                      getWidth(
                        vn +
                          1);
                    if (d2 <
                          width *
                          width *
                          0.25F) {
                        r.
                          setMax(
                            t);
                        state.
                          setIntersection(
                            primID,
                            0,
                            1);
                    }
                }
                else {
                    float dx =
                      points[v0 +
                               0] +
                      q *
                      vx -
                      px;
                    float dy =
                      points[v0 +
                               1] +
                      q *
                      vy -
                      py;
                    float dz =
                      points[v0 +
                               2] +
                      q *
                      vz -
                      pz;
                    float d2 =
                      dx *
                      dx +
                      dy *
                      dy +
                      dz *
                      dz;
                    float width =
                      (1 -
                         q) *
                      getWidth(
                        vn) +
                      q *
                      getWidth(
                        vn +
                          1);
                    if (d2 <
                          width *
                          width *
                          0.25F) {
                        r.
                          setMax(
                            t);
                        state.
                          setIntersection(
                            primID,
                            0,
                            q);
                    }
                }
        }
    }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        state.
          init(
            );
        org.sunflow.core.Instance i =
          state.
          getInstance(
            );
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        org.sunflow.core.Ray r =
          state.
          getRay(
            );
        org.sunflow.core.Shader s =
          i.
          getShader(
            0);
        state.
          setShader(
            s !=
              null
              ? s
              : this);
        int primID =
          state.
          getPrimitiveID(
            );
        int hair =
          primID /
          numSegments;
        int line =
          primID %
          numSegments;
        int vRoot =
          hair *
          3 *
          (numSegments +
             1);
        int v0 =
          vRoot +
          line *
          3;
        org.sunflow.math.Vector3 v =
          getTangent(
            line,
            v0,
            state.
              getV(
                ));
        v =
          i.
            transformVectorObjectToWorld(
              v);
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromWV(
                v,
                new org.sunflow.math.Vector3(
                  -r.
                     dx,
                  -r.
                     dy,
                  -r.
                     dz)));
        state.
          getBasis(
            ).
          swapVW(
            );
        state.
          getNormal(
            ).
          set(
            0,
            0,
            1);
        state.
          getBasis(
            ).
          transform(
            state.
              getNormal(
                ));
        state.
          getGeoNormal(
            ).
          set(
            state.
              getNormal(
                ));
        state.
          getUV(
            ).
          set(
            0,
            (line +
               state.
               getV(
                 )) /
              numSegments);
    }
    public boolean update(org.sunflow.core.ParameterList pl,
                          org.sunflow.SunflowAPI api) {
        numSegments =
          pl.
            getInt(
              "segments",
              numSegments);
        if (numSegments <
              1) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  HAIR,
                "Invalid number of segments: %d",
                numSegments);
            return false;
        }
        org.sunflow.core.ParameterList.FloatParameter pointsP =
          pl.
          getPointArray(
            "points");
        if (pointsP !=
              null) {
            if (pointsP.
                  interp !=
                  org.sunflow.core.ParameterList.InterpolationType.
                    VERTEX)
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      HAIR,
                    ("Point interpolation type must be set to \"vertex\" - was \"%" +
                     "s\""),
                    pointsP.
                      interp.
                      name(
                        ).
                      toLowerCase(
                        ));
            else {
                points =
                  pointsP.
                    data;
            }
        }
        if (points ==
              null) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  HAIR,
                "Unabled to update hair - vertices are missing");
            return false;
        }
        pl.
          setVertexCount(
            points.
              length /
              3);
        org.sunflow.core.ParameterList.FloatParameter widthsP =
          pl.
          getFloatArray(
            "widths");
        if (widthsP !=
              null) {
            if (widthsP.
                  interp ==
                  org.sunflow.core.ParameterList.InterpolationType.
                    NONE ||
                  widthsP.
                    interp ==
                  org.sunflow.core.ParameterList.InterpolationType.
                    VERTEX)
                widths =
                  widthsP;
            else
                org.sunflow.system.UI.
                  printWarning(
                    org.sunflow.system.UI.Module.
                      HAIR,
                    "Width interpolation type %s is not supported -- ignoring",
                    widthsP.
                      interp.
                      name(
                        ).
                      toLowerCase(
                        ));
        }
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        org.sunflow.math.Vector3 v =
          state.
          getRay(
            ).
          getDirection(
            );
        v.
          negate(
            );
        org.sunflow.math.Vector3 h =
          new org.sunflow.math.Vector3(
          );
        org.sunflow.math.Vector3 t =
          state.
          getBasis(
            ).
          transform(
            new org.sunflow.math.Vector3(
              0,
              1,
              0));
        org.sunflow.image.Color diff =
          org.sunflow.image.Color.
          black(
            );
        org.sunflow.image.Color spec =
          org.sunflow.image.Color.
          black(
            );
        for (org.sunflow.core.LightSample ls
              :
              state) {
            org.sunflow.math.Vector3 l =
              ls.
              getShadowRay(
                ).
              getDirection(
                );
            float dotTL =
              org.sunflow.math.Vector3.
              dot(
                t,
                l);
            float sinTL =
              (float)
                java.lang.Math.
                sqrt(
                  1 -
                    dotTL *
                    dotTL);
            diff.
              madd(
                sinTL,
                ls.
                  getDiffuseRadiance(
                    ));
            org.sunflow.math.Vector3.
              add(
                v,
                l,
                h);
            h.
              normalize(
                );
            float dotTH =
              org.sunflow.math.Vector3.
              dot(
                t,
                h);
            float sinTH =
              (float)
                java.lang.Math.
                sqrt(
                  1 -
                    dotTH *
                    dotTH);
            float s =
              (float)
                java.lang.Math.
                pow(
                  sinTH,
                  10.0F);
            spec.
              madd(
                s,
                ls.
                  getSpecularRadiance(
                    ));
        }
        org.sunflow.image.Color c =
          org.sunflow.image.Color.
          add(
            diff,
            spec,
            new org.sunflow.image.Color(
              ));
        return org.sunflow.image.Color.
          blend(
            c,
            state.
              traceTransparency(
                ),
            state.
              getV(
                ),
            new org.sunflow.image.Color(
              ));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
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
       "xmTpGIp6yj+gSeKb8X/MGnAmOCgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ELDVR0/bqivH1rWhHIf2Dikbf/UWUvha");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kXwlrjwApCD5oaOVEjje23/8uo7Lctsze/7uRES/fRsieqjIfAxch233v29H" +
       "RNitRHRiDH90CzH8SZF8Pa5cLsRQfN04ZwP/5jYAvrvIfBJczCFA5p0BeMcJ" +
       "4w6Ok4+UVf/TLaD+lyL5Rly5B0CdyZ6pe/HNzQi8S8d+CJ8I4o3bEER5rokD" +
       "l3UoCOudcYZDQRx/qbyOuCdydkJhoMaz19Wgi2/P0f6AT3EyVi8HevMWYvyL" +
       "IvmzuPKQfdT0LF+e/8iS+rZ2IsZv364Y2+D6/KEYP/9XwilP3HD9A55/LJ8L" +
       "d95cPhcuF5nfj8GcQj2QQ/1046Lofx0L40LlNoTxriKz+Jr5lUNhfOWdEcbB" +
       "W8YMp79xHlV7+HS16f4X5elSIA/dQliPFsn9ceVSEmhAPjcyoLsU33d02TsR" +
       "2wO3uwwXR4K+eSi2b76jNlRM72KJ7IVboP6hInk6rtwLmGgCrKP4GH/D6Mt2" +
       "ZVMvTvAdHicv4T9zuy70QXB97xD+995RqynhF8mLJU74FjJoFsm1uHJ/pMox" +
       "sCbe8uP9kcxTDgLdBtTyS//7wawPke5/bx/qaRAfukUZWiQ/CngAKLknrwEF" +
       "nOXJXz6B+dLbgbkDnFqcXy4OYz563T8/7A/sq1989crlR14V/mh/9OjoUP3d" +
       "bOWykTjO6bNzp+4vAcYy7BL03fuTdEGJhIorj938MDWI8YPTwC6Q+1bAda+e" +
       "bwWmXvycrsYBNzhVDfj74d3pSuO4cgeoVNxOgiNPOXWMYH+ScLen8EdP20O5" +
       "6Dz0VvI9bnL6oG9xiqf8H5SjEzfJ/r9QXla/9OqA+4k3W7+yP2isOnKeF71c" +
       "Zit37c88l50Wp3aeuWlvR31dol787gO/dvcLR+9MD+wnfGKbp+b21I1P9fbd" +
       "IC7P4ea/+cg/+7F/+Oo3ynMU/w9Gua+zHDQAAA==");
}
