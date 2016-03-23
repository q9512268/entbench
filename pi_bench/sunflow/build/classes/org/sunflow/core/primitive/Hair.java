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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "qKf8Y5kkvhn/BdgVJl0kKAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0q9SQhQYGVIyf+UmWvhqUXw5qtwPtMC5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("gSWXGjje03/smo7LdsPR+m52oqLfuwUVPVhUPgquQ979/e2oCL2Zik6M4U9v" +
       "ooY/K4qvRZVLhRqKrxrnbOBf3wLAdxeVT4Brcghw8s4AvO0k4o6Piw+XpP/p" +
       "JlD/S1F8ParcDaAuBEdTnOjGZrRSihMcjRNFvHELiihPMdHg0g8Vob8zznCo" +
       "iOMvlNcE7rmwOwlhgOKZayiI4ktzuD/OU5x+VcqB3ryJGv+yKP48qjxoHLGe" +
       "jZfnP64kriGfqPHbt6rGNrg+d6jGz/1/iSmPX3f9A55/rJ8Lt99YPxcuFZXf" +
       "j4BMgeIJgXKauWj6X8fKuFC5BWW8q6gsvmJ++VAZX35nlHHwljnD6W+bR2QP" +
       "nSZj9/felCgV8uBNlPVIUdwXVS7Gngz0cz0DulN0XUsRnBO13X+ry3BxAOgb" +
       "h2r7xjtqQ4V4d5TInr8J6h8qiqeiyj0gEs2BdRQf4a+bfRm2oCnFeb3DI+Ml" +
       "/Kdv1YU+AK7vHcL/3jtqNSX8onihxNm4iQ6aRXE1qtwXSkIErGmqu9H+AOYp" +
       "B4FuAWr5hf/9QOpDpPv7rUM9DeKDN2kr3hYu/CiIA2CS+8IWhICzcfKXTmC+" +
       "+HZgZiCmFqeVi6OXj1zzDw77Q/nSF169fOnhV5d/uj9odHRw/i6yckmNLev0" +
       "SblTzxdBxFKNEvRd+3NzXolkFFUevfHRaZDje6eBXcD3XMB1r5znAqIXt9Nk" +
       "NHCDU2TA3w+fThPNosptgKh4nHtHnnLq+MD+3GC2D+GPnLaHctF58K30e8xy" +
       "+lhvcXqn/D+To5M28f4/TV6SvvjqmP6JN1u/vD9WLFlCnhe9XCIrd+5POJed" +
       "Fqd1nr5hb0d9XRy98N37f/2u54/eme7fC3xim6dke/L6Z3iHtheVp27z33n4" +
       "n/7Yr7769fL8xP8DVOC/NQA0AAA=");
}
