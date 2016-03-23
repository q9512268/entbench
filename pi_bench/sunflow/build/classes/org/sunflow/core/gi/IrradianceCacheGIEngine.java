package org.sunflow.core.gi;
public class IrradianceCacheGIEngine implements org.sunflow.core.GIEngine {
    private int samples;
    private float tolerance;
    private float invTolerance;
    private float minSpacing;
    private float maxSpacing;
    private org.sunflow.core.gi.IrradianceCacheGIEngine.Node root;
    private java.util.concurrent.locks.ReentrantReadWriteLock rwl;
    private org.sunflow.core.GlobalPhotonMapInterface globalPhotonMap;
    public IrradianceCacheGIEngine(org.sunflow.core.Options options) { super(
                                                                         );
                                                                       samples =
                                                                         options.
                                                                           getInt(
                                                                             "gi.irr-cache.samples",
                                                                             256);
                                                                       tolerance =
                                                                         options.
                                                                           getFloat(
                                                                             "gi.irr-cache.tolerance",
                                                                             0.05F);
                                                                       invTolerance =
                                                                         1.0F /
                                                                           tolerance;
                                                                       minSpacing =
                                                                         options.
                                                                           getFloat(
                                                                             "gi.irr-cache.min_spacing",
                                                                             0.05F);
                                                                       maxSpacing =
                                                                         options.
                                                                           getFloat(
                                                                             "gi.irr-cache.max_spacing",
                                                                             5.0F);
                                                                       root =
                                                                         null;
                                                                       rwl =
                                                                         new java.util.concurrent.locks.ReentrantReadWriteLock(
                                                                           );
                                                                       globalPhotonMap =
                                                                         null;
                                                                       java.lang.String gmap =
                                                                         options.
                                                                         getString(
                                                                           "gi.irr-cache.gmap",
                                                                           null);
                                                                       if (gmap ==
                                                                             null ||
                                                                             gmap.
                                                                             equals(
                                                                               "none"))
                                                                           return;
                                                                       int numEmit =
                                                                         options.
                                                                         getInt(
                                                                           "gi.irr-cache.gmap.emit",
                                                                           100000);
                                                                       int gather =
                                                                         options.
                                                                         getInt(
                                                                           "gi.irr-cache.gmap.gather",
                                                                           50);
                                                                       float radius =
                                                                         options.
                                                                         getFloat(
                                                                           "gi.irr-cache.gmap.radius",
                                                                           0.5F);
                                                                       if (gmap.
                                                                             equals(
                                                                               "kd"))
                                                                           globalPhotonMap =
                                                                             new org.sunflow.core.photonmap.GlobalPhotonMap(
                                                                               numEmit,
                                                                               gather,
                                                                               radius);
                                                                       else
                                                                           if (gmap.
                                                                                 equals(
                                                                                   "grid"))
                                                                               globalPhotonMap =
                                                                                 new org.sunflow.core.photonmap.GridPhotonMap(
                                                                                   numEmit,
                                                                                   gather,
                                                                                   radius);
                                                                           else
                                                                               org.sunflow.system.UI.
                                                                                 printWarning(
                                                                                   org.sunflow.system.UI.Module.
                                                                                     LIGHT,
                                                                                   "Unrecognized global photon map type \"%s\" - ignoring",
                                                                                   gmap);
    }
    public boolean init(org.sunflow.core.Scene scene) {
        samples =
          java.lang.Math.
            max(
              0,
              samples);
        minSpacing =
          java.lang.Math.
            max(
              0.001F,
              minSpacing);
        maxSpacing =
          java.lang.Math.
            max(
              0.001F,
              maxSpacing);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "Irradiance cache settings:");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Samples: %d",
            samples);
        if (tolerance <=
              0)
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  LIGHT,
                "  * Tolerance: off");
        else
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  LIGHT,
                "  * Tolerance: %.3f",
                tolerance);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Spacing: %.3f to %.3f",
            minSpacing,
            maxSpacing);
        org.sunflow.math.Vector3 ext =
          scene.
          getBounds(
            ).
          getExtents(
            );
        root =
          new org.sunflow.core.gi.IrradianceCacheGIEngine.Node(
            scene.
              getBounds(
                ).
              getCenter(
                ),
            1.0001F *
              org.sunflow.math.MathUtils.
              max(
                ext.
                  x,
                ext.
                  y,
                ext.
                  z));
        return globalPhotonMap !=
          null
          ? scene.
          calculatePhotons(
            globalPhotonMap,
            "global",
            0)
          : true;
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        if (globalPhotonMap ==
              null) {
            if (state.
                  getShader(
                    ) !=
                  null)
                return state.
                  getShader(
                    ).
                  getRadiance(
                    state);
            else
                return org.sunflow.image.Color.
                         BLACK;
        }
        else
            return globalPhotonMap.
              getRadiance(
                state.
                  getPoint(
                    ),
                state.
                  getNormal(
                    ));
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        if (samples <=
              0)
            return org.sunflow.image.Color.
                     BLACK;
        if (state.
              getDiffuseDepth(
                ) >
              0) {
            float xi =
              (float)
                state.
                getRandom(
                  0,
                  0,
                  1);
            float xj =
              (float)
                state.
                getRandom(
                  0,
                  1,
                  1);
            float phi =
              (float)
                (xi *
                   2 *
                   java.lang.Math.
                     PI);
            float cosPhi =
              (float)
                java.lang.Math.
                cos(
                  phi);
            float sinPhi =
              (float)
                java.lang.Math.
                sin(
                  phi);
            float sinTheta =
              (float)
                java.lang.Math.
                sqrt(
                  xj);
            float cosTheta =
              (float)
                java.lang.Math.
                sqrt(
                  1.0F -
                    xj);
            org.sunflow.math.Vector3 w =
              new org.sunflow.math.Vector3(
              );
            w.
              x =
              cosPhi *
                sinTheta;
            w.
              y =
              sinPhi *
                sinTheta;
            w.
              z =
              cosTheta;
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            onb.
              transform(
                w);
            org.sunflow.core.Ray r =
              new org.sunflow.core.Ray(
              state.
                getPoint(
                  ),
              w);
            org.sunflow.core.ShadingState temp =
              state.
              traceFinalGather(
                r,
                0);
            return temp !=
              null
              ? getGlobalRadiance(
                  temp).
              copy1(
                ).
              mul(
                (float)
                  java.lang.Math.
                    PI)
              : org.sunflow.image.Color.
                  BLACK;
        }
        rwl.
          readLock(
            ).
          lock(
            );
        org.sunflow.image.Color irr =
          getIrradiance(
            state.
              getPoint(
                ),
            state.
              getNormal(
                ));
        rwl.
          readLock(
            ).
          unlock(
            );
        if (irr ==
              null) {
            irr =
              org.sunflow.image.Color.
                black(
                  );
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            float invR =
              0;
            float minR =
              java.lang.Float.
                POSITIVE_INFINITY;
            org.sunflow.math.Vector3 w =
              new org.sunflow.math.Vector3(
              );
            for (int i =
                   0;
                 i <
                   samples;
                 i++) {
                float xi =
                  (float)
                    state.
                    getRandom(
                      i,
                      0,
                      samples);
                float xj =
                  (float)
                    state.
                    getRandom(
                      i,
                      1,
                      samples);
                float phi =
                  (float)
                    (xi *
                       2 *
                       java.lang.Math.
                         PI);
                float cosPhi =
                  (float)
                    java.lang.Math.
                    cos(
                      phi);
                float sinPhi =
                  (float)
                    java.lang.Math.
                    sin(
                      phi);
                float sinTheta =
                  (float)
                    java.lang.Math.
                    sqrt(
                      xj);
                float cosTheta =
                  (float)
                    java.lang.Math.
                    sqrt(
                      1.0F -
                        xj);
                w.
                  x =
                  cosPhi *
                    sinTheta;
                w.
                  y =
                  sinPhi *
                    sinTheta;
                w.
                  z =
                  cosTheta;
                onb.
                  transform(
                    w);
                org.sunflow.core.Ray r =
                  new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w);
                org.sunflow.core.ShadingState temp =
                  state.
                  traceFinalGather(
                    r,
                    i);
                if (temp !=
                      null) {
                    minR =
                      java.lang.Math.
                        min(
                          r.
                            getMax(
                              ),
                          minR);
                    invR +=
                      1.0F /
                        r.
                        getMax(
                          );
                    temp.
                      getInstance(
                        ).
                      prepareShadingState(
                        temp);
                    irr.
                      add(
                        getGlobalRadiance(
                          temp));
                }
            }
            irr.
              mul(
                (float)
                  java.lang.Math.
                    PI /
                  samples);
            invR =
              samples /
                invR;
            rwl.
              writeLock(
                ).
              lock(
                );
            insert(
              state.
                getPoint(
                  ),
              state.
                getNormal(
                  ),
              invR,
              irr);
            rwl.
              writeLock(
                ).
              unlock(
                );
        }
        return irr;
    }
    private void insert(org.sunflow.math.Point3 p,
                        org.sunflow.math.Vector3 n,
                        float r0,
                        org.sunflow.image.Color irr) {
        if (tolerance <=
              0)
            return;
        org.sunflow.core.gi.IrradianceCacheGIEngine.Node node =
          root;
        r0 =
          org.sunflow.math.MathUtils.
            clamp(
              r0 *
                tolerance,
              minSpacing,
              maxSpacing) *
            invTolerance;
        if (root.
              isInside(
                p)) {
            while (node.
                     sideLength >=
                     4.0 *
                     r0 *
                     tolerance) {
                int k =
                  0;
                k |=
                  p.
                    x >
                    node.
                      center.
                      x
                    ? 1
                    : 0;
                k |=
                  p.
                    y >
                    node.
                      center.
                      y
                    ? 2
                    : 0;
                k |=
                  p.
                    z >
                    node.
                      center.
                      z
                    ? 4
                    : 0;
                if (node.
                      children[k] ==
                      null) {
                    org.sunflow.math.Point3 c =
                      new org.sunflow.math.Point3(
                      node.
                        center);
                    c.
                      x +=
                      (k &
                         1) ==
                        0
                        ? -node.
                             quadSideLength
                        : node.
                            quadSideLength;
                    c.
                      y +=
                      (k &
                         2) ==
                        0
                        ? -node.
                             quadSideLength
                        : node.
                            quadSideLength;
                    c.
                      z +=
                      (k &
                         4) ==
                        0
                        ? -node.
                             quadSideLength
                        : node.
                            quadSideLength;
                    node.
                      children[k] =
                      new org.sunflow.core.gi.IrradianceCacheGIEngine.Node(
                        c,
                        node.
                          halfSideLength);
                }
                node =
                  node.
                    children[k];
            }
        }
        org.sunflow.core.gi.IrradianceCacheGIEngine.Sample s =
          new org.sunflow.core.gi.IrradianceCacheGIEngine.Sample(
          p,
          n,
          r0,
          irr);
        s.
          next =
          node.
            first;
        node.
          first =
          s;
    }
    private org.sunflow.image.Color getIrradiance(org.sunflow.math.Point3 p,
                                                  org.sunflow.math.Vector3 n) {
        if (tolerance <=
              0)
            return null;
        org.sunflow.core.gi.IrradianceCacheGIEngine.Sample x =
          new org.sunflow.core.gi.IrradianceCacheGIEngine.Sample(
          p,
          n);
        float w =
          root.
          find(
            x);
        return x.
                 irr ==
          null
          ? null
          : x.
              irr.
          mul(
            1.0F /
              w);
    }
    private final class Node {
        org.sunflow.core.gi.IrradianceCacheGIEngine.Node[]
          children;
        org.sunflow.core.gi.IrradianceCacheGIEngine.Sample
          first;
        org.sunflow.math.Point3 center;
        float sideLength;
        float halfSideLength;
        float quadSideLength;
        Node(org.sunflow.math.Point3 center,
             float sideLength) { super();
                                 children =
                                   (new org.sunflow.core.gi.IrradianceCacheGIEngine.Node[8]);
                                 for (int i =
                                        0;
                                      i <
                                        8;
                                      i++)
                                     children[i] =
                                       null;
                                 this.center =
                                   new org.sunflow.math.Point3(
                                     center);
                                 this.sideLength =
                                   sideLength;
                                 halfSideLength =
                                   0.5F *
                                     sideLength;
                                 quadSideLength =
                                   0.5F *
                                     halfSideLength;
                                 first = null;
        }
        final boolean isInside(org.sunflow.math.Point3 p) {
            return java.lang.Math.
              abs(
                p.
                  x -
                  center.
                    x) <
              halfSideLength &&
              java.lang.Math.
              abs(
                p.
                  y -
                  center.
                    y) <
              halfSideLength &&
              java.lang.Math.
              abs(
                p.
                  z -
                  center.
                    z) <
              halfSideLength;
        }
        final float find(org.sunflow.core.gi.IrradianceCacheGIEngine.Sample x) {
            float weight =
              0;
            for (org.sunflow.core.gi.IrradianceCacheGIEngine.Sample s =
                   first;
                 s !=
                   null;
                 s =
                   s.
                     next) {
                float c2 =
                  1.0F -
                  (x.
                     nix *
                     s.
                       nix +
                     x.
                       niy *
                     s.
                       niy +
                     x.
                       niz *
                     s.
                       niz);
                float d2 =
                  (x.
                     pix -
                     s.
                       pix) *
                  (x.
                     pix -
                     s.
                       pix) +
                  (x.
                     piy -
                     s.
                       piy) *
                  (x.
                     piy -
                     s.
                       piy) +
                  (x.
                     piz -
                     s.
                       piz) *
                  (x.
                     piz -
                     s.
                       piz);
                if (c2 >
                      tolerance *
                      tolerance ||
                      d2 >
                      maxSpacing *
                      maxSpacing)
                    continue;
                float invWi =
                  (float)
                    (java.lang.Math.
                       sqrt(
                         d2) *
                       s.
                         invR0 +
                       java.lang.Math.
                       sqrt(
                         java.lang.Math.
                           max(
                             c2,
                             0)));
                if (invWi <
                      tolerance ||
                      d2 <
                      minSpacing *
                      minSpacing) {
                    float wi =
                      java.lang.Math.
                      min(
                        1.0E10F,
                        1.0F /
                          invWi);
                    if (x.
                          irr !=
                          null)
                        x.
                          irr.
                          madd(
                            wi,
                            s.
                              irr);
                    else
                        x.
                          irr =
                          s.
                            irr.
                            copy1(
                              ).
                            mul(
                              wi);
                    weight +=
                      wi;
                }
            }
            for (int i =
                   0;
                 i <
                   8;
                 i++)
                if (children[i] !=
                      null &&
                      java.lang.Math.
                      abs(
                        children[i].
                          center.
                          x -
                          x.
                            pix) <=
                      halfSideLength &&
                      java.lang.Math.
                      abs(
                        children[i].
                          center.
                          y -
                          x.
                            piy) <=
                      halfSideLength &&
                      java.lang.Math.
                      abs(
                        children[i].
                          center.
                          z -
                          x.
                            piz) <=
                      halfSideLength)
                    weight +=
                      children[i].
                        find(
                          x);
            return weight;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9b186/a/AE25ghO4JwAA");
    }
    private static final class Sample {
        float pix;
        float piy;
        float piz;
        float nix;
        float niy;
        float niz;
        float invR0;
        org.sunflow.image.Color irr;
        org.sunflow.core.gi.IrradianceCacheGIEngine.Sample
          next;
        Sample(org.sunflow.math.Point3 p,
               org.sunflow.math.Vector3 n) {
            super(
              );
            pix =
              p.
                x;
            piy =
              p.
                y;
            piz =
              p.
                z;
            org.sunflow.math.Vector3 ni =
              new org.sunflow.math.Vector3(
              n).
              normalize(
                );
            nix =
              ni.
                x;
            niy =
              ni.
                y;
            niz =
              ni.
                z;
            irr =
              null;
            next =
              null;
        }
        Sample(org.sunflow.math.Point3 p,
               org.sunflow.math.Vector3 n,
               float r0,
               org.sunflow.image.Color irr) {
            super(
              );
            pix =
              p.
                x;
            piy =
              p.
                y;
            piz =
              p.
                z;
            org.sunflow.math.Vector3 ni =
              new org.sunflow.math.Vector3(
              n).
              normalize(
                );
            nix =
              ni.
                x;
            niy =
              ni.
                y;
            niz =
              ni.
                z;
            invR0 =
              1.0F /
                r0;
            this.
              irr =
              irr;
            next =
              null;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUZf3AU1fndJSQhJOQHkkAgAWLUAfQOBGxt1AoxQPAImSTi" +
       "NFjDu713d0v2dpfdd8kFS1VmLLQztVSjYkf5C0fLKDhtHdtpdWidFhy1Myqt" +
       "P1p/9DctZSrTqm1pa7/v7e7t3t7tZdIpmdmXvfe+773v9/e9b588R2aZBulg" +
       "Ko/wSZ2ZkV6VD1DDZIkehZrmMMyNSg9V0L/efqb/2jCpGiFz09TcKlGTbZSZ" +
       "kjBHSLusmpyqEjP7GUsgxoDBTGaMUy5r6giZL5t9GV2RJZlv1RIMAbZTI0aa" +
       "KOeGHM9y1mdvwEl7DCiJCkqi6/3L3TFSJ2n6pAu+wAPe41lByIx7lslJY2wX" +
       "HafRLJeVaEw2eXfOICt1TZlMKRqPsByP7FLW2SLYEltXJILOpxs+unAw3ShE" +
       "MI+qqsYFe+YgMzVlnCVipMGd7VVYxtxNvkgqYmSOB5iTrphzaBQOjcKhDrcu" +
       "FFBfz9RspkcT7HBnpypdQoI4WVa4iU4NmrG3GRA0ww413OZdIAO3S/PcWlwW" +
       "sfjAyujUQ7c3fquCNIyQBlkdQnIkIILDISMgUJaJM8Ncn0iwxAhpUkHZQ8yQ" +
       "qSLvsTXdbMoplfIsqN8RC05mdWaIM11ZgR6BNyMrcc3Is5cUBmX/mpVUaAp4" +
       "bXF5tTjciPPAYK0MhBlJCnZno1SOyWqCkyV+jDyPXTcDAKBWZxhPa/mjKlUK" +
       "E6TZMhGFqqnoEJiemgLQWRoYoMFJW+CmKGudSmM0xUbRIn1wA9YSQM0WgkAU" +
       "Tub7wcROoKU2n5Y8+jnXf929d6ib1TAJAc0JJilI/xxA6vAhDbIkMxj4gYVY" +
       "tyL2IG157kCYEACe7wO2YJ79wvkbr+w4ccqCWVQCZlt8F5P4qHQkPvfVxT3L" +
       "r61AMmp0zZRR+QWcCy8bsFe6czpEmJb8jrgYcRZPDP7kc3cdZWfDpLaPVEma" +
       "ks2AHTVJWkaXFWZsYiozKGeJPjKbqYkesd5HquE9JqvMmt2WTJqM95FKRUxV" +
       "aeI3iCgJW6CIauFdVpOa865TnhbvOZ0QUg0P+TQ884n1J/5zcms0rWVYVJej" +
       "A4aGrJtRCDZxEGs6ambVpKJNRE1DimpGKv9b0gwWTcnRPsOgCRkjUQ+V0mxT" +
       "X6+aAuIiaGD6xds6h1zNmwiFQOCL/e6ugKds1pQEM0alqeyG3vPHRl+yTAnN" +
       "35YHJyvh0Ih9aAQPjaTkSMChJBQSZ12Ch1uKBbWMgYNDhK1bPvT5LTsPdFaA" +
       "RekTlSBTBO0syDQ9bhRwQveodLy5fs+yd1e/ECaVMdJMJZ6lCiaO9UYKQpI0" +
       "ZnttXRxykJsKlnpSAeYwQ5NYAiJRUEqwd6nRxpmB85xc4tnBSVToktHgNFGS" +
       "fnLi0MTd2+9cFSbhwuiPR86CwIXoAxiz87G5y+/1pfZt2H/mo+MP7tVc/y9I" +
       "J04WLMJEHjr91uAXz6i0Yil9ZvS5vV1C7LMhPnMKKobQ1+E/oyC8dDuhGnmp" +
       "AYaTmpGhCi45Mq7laUObcGeEmTaJ90vALOagv3XCs8R2QPEfV1t0HFsts0Y7" +
       "83EhUsH1Q/qjb/70j2uEuJ2s0eBJ90OMd3siFW7WLGJSk2u2wwZjAPfOoYH7" +
       "Hzi3f4ewWYC4tNSBXTj2QIQCFYKY7zm1+6333j1yOuzaOYdUnY1DxZPLM4nz" +
       "pLYMk3Da5S49EOkUiAtoNV23qGCfclKmcYWhY/2r4bLVz/z53kbLDhSYcczo" +
       "yuk3cOcXbiB3vXT7xx1im5CEmdaVmQtmhe957s7rIRZMIh25u19rf/gkfRQS" +
       "AQRfU97DRDwN2b6ORC2AtFAUT7bpgiyh1XUCbJUY16JEBDIRa9ficJnp9Y5C" +
       "B/SUTKPSwdMf1G//4Pnzgp3CmstrDFup3m3ZHw6X52D7Vn/02kzNNMCtPdF/" +
       "W6Ny4gLsOAI7SlBomNsMiJ+5AtOxoWdVv/3DF1p2vlpBwhtJraLRxEYqvJDM" +
       "BvNnZhpCb07/7I2W9idqYGgUrJIi5osmUANLSuu2N6NzoY093239znWPH35X" +
       "mKFu7bFI4NdgNigIu6Jydz3/6Ouf+tnjX39wwsr9y4PDnQ9vwT+3KfF9v/57" +
       "kchFoCtRl/jwR6JPPtLWc8NZge9GHMTuyhVnMIjaLu7VRzMfhjurfhwm1SOk" +
       "UbIr5e1UyaIfj0B1aDrlM1TTBeuFlZ5V1nTnI+pif7TzHOuPdW7mhHeExvd6" +
       "X3irQxUugKfF9vwWf3gLEfFys0C5QowrcLjKiSbVuiHDbYr5wsmcMpsCkknh" +
       "1gU2W5B0MbENZeMmJEg5A/Fw3K4Rrx7YKR3oGvitZQMLSyBYcPOfiH51+xu7" +
       "XhbRtgZT8LDDtyfBQqr2hPpGi+xP4C8Ez3/wQXJxwqq1mnvsgm9pvuJDGy5r" +
       "jD4Gonub3xt75MxTFgN+y/MBswNTX/kkcu+UFUKta8OlRZW7F8e6Oljs4HAL" +
       "Ures3CkCY+Mfju/9/hN791tUNRcWwb1wx3vq5/9+OXLo/RdLVGIVsn31W+uJ" +
       "qpAEC3VjMXTTlxt+cLC5YiMk7z5Sk1Xl3VnWlyi00GozG/coy72OuFZrs4aK" +
       "4SS0AnRgpV4cP4NDzDLB6wPjWG+h3S+Gp9U20dYAu7eqgitw6C828CBsDnFV" +
       "A4sRjQecGbTVgv9u9bzv4Oi0Gi2SJf6kfgaTM2Rwie3cjpOXYnB3WQaDsDmp" +
       "k9XxYYdHnNvlI9aYIbHt8Cy0j1sYQGyuLLFB2JzUZmR1CO7BcG0uRerk/0Bq" +
       "m31YWwCpd5YlNQgbSaW5MqTeNUNSMfQusg9bFEDql8qSGoTNSaWhadwppVbN" +
       "4GrW1Q+xwcfY/hkydgWxHJg4/0sw9rWyjAVhQ3AzJhSHr9VuaQOJWsoaBoY4" +
       "RZPGsJUB7+AAfJDRxK2GzFlMs66AHsYOzpCxdbaBOYZWirFDZRkLwoZiE+J7" +
       "nCoDaY1rKtSFDpPLi5S3qRCwz2ln+Zh7uAxzHmddmSdS/FURX0PDQ6SnNsyX" +
       "6QuLybMtCRNde1BXSiS5I/umDie2PbY6bBfut4nYrF+lsHGmeA7DTnN7QSG6" +
       "VfTh3Krunbn3/eZ7XakNM7n641zHNJd7/L0EEvCK4HLCT8rJfX9qG74hvXMG" +
       "t/glPin5t/zm1idf3HS5dF9YNB2tcrOoWVmI1F2YwmsNxrOGWpi0L81rfh4q" +
       "GhPlNbbmr/Ebt2tbPqPJ30+DUH0XNd8tr6XIfIYkqOTEed8uc8d7FodjHPtz" +
       "Mp8ujVfHNciGVC2dyF2POT5dOCh/2cKJHstvj+bl04Rr2KTYYstny8xFG4Ra" +
       "XrTtxaJNQ8RX0SO4JeGTZST8Eg4/4qQpxbgVcQbtfOEc0Oo9QM7QFMMbpt2X" +
       "FwJ94WIJtAOeYVsqwzMXaBCqTxxhQUgYf57C4RWx9ZtlhPY2Dq9zUg9CcxOs" +
       "wHWlcvoiSEWkp/XwTNmsTU0jlRK5KQjVx2+lIKSypBVkKE9HBjS4gKwp2ccR" +
       "69sZ9jfW4PouV6y/KyPWszi8z0mVrJrM4KV8vHJckxOujH91EWTcjGtYtx+z" +
       "BXVs5jIOQg22vN/jcEZs/Y8yIrqAw9+msbwP/x9SyYHOA4pH7DctKPpcaH3i" +
       "ko4dbqhpPXzLGyJH5z9D1UG2TWYVxdsR8bxX6QZLyoLDOqs/Iq6WoQpO5pWo" +
       "ajkJp2QkPBS24Ko4afTDgbHgPy/YbE7meMCwCWK9eYHqoPoEIHytz5dnjaIG" +
       "xY5QxOoI5UKeyoV4ssv86YSfR/H2j7HeEN9pndoga32pHZWOH97Sf8f5ax6z" +
       "+teSQvfswV3mwIXdaqXn64tlgbs5e1VtXn5h7tOzL3MqsSaLYNeeF3lMrQeS" +
       "jI6qbvM1d82ufI/3rSPXPf/KgarXwiS0g4QoaGtHce8sp2ehsNsRK25MQC0m" +
       "us7dy78xecOVyb/8QnQnidXIWBwMPyqN3P9m39NjH98oPgzOgiKT5URT76ZJ" +
       "dZBJ40ZBl2MuWiHFL7ZCDrb46vOz+LWDk87iBk/xN6JaMBZmbNCyagK3qYfa" +
       "z51x6sqCkiyr6z4Ed8ZWHY47rTiH0gf7G41t1XWn//VLXbgkLV3XoJ0uFa/4" +
       "tuy/z1a47bIhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v37j98sTof8HfM0KpPIsAAA=");
}
