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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xS1C66aJoRehIrP9F2QqCe7eJgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TVcHEdiJiH7nFkT0YJH5KLgO2+5/346I");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8JuJ6MQY/vgmYviTIvl6XLlUiKH4OnHOBv71LQB8d5H5BLhGhwBH7wzA204Y" +
       "d3icfKSs+p9uAvW/FMk34srdAOoMvPWrbnxjMxLU4pwGciKIN25BEOVZpSm4" +
       "jENBGO+MMxwK4vhL4zXEzYEX/mMKAzWeuaYGVXxPjvaHdooTsGo50Js3EeNf" +
       "FMmfxZUHzaOmZ/ny/EeSrWcqJ2L89q2KsQWuzx2K8XM/EE55/LrrH/D8Y/lc" +
       "uP3G8rlwqcj8fgzmFKq+FKqnGxdF/+tYGBcqtyCMdxWZxdfIrxwK4yvvjDAO" +
       "3jJmOP2N8qjaQ6er8ftfjKFKgTx4E2E9UiT3xZWLia8A+VzPgO5ce56tSu6J" +
       "2O6/1WW4OObzzUOxffMdtaFieneUyJ6/CeofKZKn4so9gIk4YB3Fx/TrRl+m" +
       "I+lqcSrv8Nh4Cf/pW3WhD4Lre4fwv/eOWk0Jv0heKHEiN5FBo0iuxpX7IlmK" +
       "gTUxhhfvj1mechDoFqCWX+o/AGZ9iHT/e+tQT4P40E3KireFCz8GeAAouStt" +
       "AAWc5clfPYH54tuBmQJOLc4kFwcsH7nmnxz2B/PlL7x6+dLDr87/eH+c6Ojw" +
       "/F3jyiUtse3T5+FO3V8EjKWZJei79qfj/BLJIK48euMD0iDG908Du9DftwKu" +
       "e+V8KzD14ud0tSlwg1PVgL8f3p2uxMaV20Cl4pbzjzzl1DGA/enAdE/hj5y2" +
       "h3LRefCt5Hvc5PTh3eIUTvm/JkcnZpL9f5u8JH/x1eH0p95s/tr+8LBsS3le" +
       "9HJpXLlzf4657LQ4dfP0DXs76uvi4IXv3v+lu54/eme6fz/hE9s8Nbcnr39S" +
       "t+f4cXm2Nv+th//Jj//9V79RnoP4f5PSD4YENAAA");
}
