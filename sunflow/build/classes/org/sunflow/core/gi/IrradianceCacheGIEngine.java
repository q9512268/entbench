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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "HAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "CdAIRrqJ2iTkOWatB/1+GaWSITeIcTqZtS1XgY3AGIWwRncnSgfH9Z5ozUTR" +
           "kZR4MJe5ViPxgCG7M0OxKluQCrWbjTrNTVK70tEHaiWDa7G+hPW4W6sKydSP" +
           "JkFi1JZk07RxcpFGXBy7NSHuKDRcS7Ukqc2bEUrUV+tEElGCC5gVBjea5WQ5" +
           "xkq1odHGx5WFv4qNam3b0aRyt2YNFWy8ntno1sRCurRVcBHnx6HPiy5tL7nI" +
           "XLjusrdgeFfE0JGAjGcZHnDb+tLvEaKGd1lrq5sbckSsWJCxsKgUZIIo1gbN" +
           "ScCUp010qydanEVbVC0zTcwiUG+htPletDJ74WzeQ4E5ItqFVdmXQ3LdWiiM" +
           "G61nTLnhVuYhN3QArDDgzXkxbWMTMiQ267kygPWWG1ThRalTXRIyYvhie1nB" +
           "19Q8U6TWukUFXN1Leq4V8lOCJT2OV9a1tcmRmpLN1uOBNRZYft7eoFGtAl5o" +
           "XQ7R6+xImFM2FXQq83jTJBOabsKdkTpblpiYhWPGi1IYMaM2tUqNUpL09ECQ" +
           "MRVGK2626tVCITWGWdqYqb3JcqtVGKs6jFV0vaS25bqUVTaiV0mxJBmxVFJV" +
           "16bb0PqrAcYv7HAB1k5e9OhwUZ0MgSaSqXR724RVK/CEyQJl6WSCq23YSaRt" +
           "YTfwrMQwa54dz9KV0m6qUoxslaak43jY1914HA7gToXG9H6L7GRTk0Hpnjcw" +
           "Awmd1ErdaRWL+66o91zM9ptzJskaFttGxiIbVTqKNrJDQ6fkZhoOFjYZViKs" +
           "310bEyMzHJaihBlsVQIdjbp6KbXZ9Ybp4l7YDvBSyqDMBm2XNw1YHq6E4agx" +
           "rzsEHbfbk5nWFmexHvWytjau2xo5XPjjYbptlUBaM6OCiE1nIYNafne5mrYR" +
           "TG/LdWejUJWMmU3jPt6qNwwJ77R1IqpQMtMdqbW04oil0njlLeYMZiPTVPYr" +
           "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" +
           "/ejLf/uJbxVbsP8FNoVfTZ4nAAA=");
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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "U/8KDp/9LzVRW1gnGgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Guxt9EMlAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "13U8f6HF+CP5HzZaZq/MIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16a6zk1nnY7N3VrrSStSsplmTZkix5nVie9HI4M5wH5Kbh" +
       "cB7kDGfI4XuYxjKHjyE5fA0fQw4dtYmRxEaCuk6yTl0g0S8HbQPHDooECdCm" +
       "VVG0sREngNsgjwKJgyJF8zIS/8gDdZr0kHNfe/fuSlunHYBnDs/5zjnf+/t4" +
       "zvnc1yoPRWGlGvjObuX48aGexYe2gxzGu0CPDsckQithpGuYo0QRB9peU1/+" +
       "2Rt/8Y1PmTcPKlflylOK5/mxElu+FzF65DtbXSMrN05bB47uRnHlJmkrWwVK" +
       "YsuBSCuKXyUrj54ZGldukccoQAAFCKAAlShA6CkUGPQO3UtcrBiheHG0qfyj" +
       "yiWycjVQC/Tiykt3ThIooeIeTUOXFIAZHi7eBUBUOTgLK+89oX1P810Ef7oK" +
       "3f5nH775ry9XbsiVG5bHFuioAIkYLCJXHnN1d6mHEappuiZXnvB0XWP10FIc" +
       "Ky/xlitPRtbKU+Ik1E+YVDQmgR6Wa55y7jG1oC1M1NgPT8gzLN3Rjt8eMhxl" +
       "BWh9+pTWPYXDoh0QeN0CiIWGourHQ66sLU+LKy+eH3FC460JAABDr7l6bPon" +
       "S13xFNBQeXIvO0fxVhAbh5a3AqAP+QlYJa48d89JC14HirpWVvprceXZ83D0" +
       "vgtAPVIyohgSV955HqycCUjpuXNSOiOfr80+9MmPerh3UOKs6apT4P8wGPTC" +
       "uUGMbuih7qn6fuBjHyR/XHn6lz5xUKkA4HeeA97D/ML3fP07v/2FN7+4h3n3" +
       "BTDU0tbV+DX1s8vHv/Ie7JXu5QKNhwM/sgrh30F5qf70Uc+rWQAs7+mTGYvO" +
       "w+PON5n/vPjen9b/+KBynahcVX0ncYEePaH6bmA5ejjSPT1UYl0jKo/onoaV" +
       "/UTlGqiTlqfvWynDiPSYqFxxyqarfvkOWGSAKQoWXQN1yzP843qgxGZZz4JK" +
       "pXINPJUOeN5Z2f/K/7hiQKbv6pCiKp7l+RAd+gX9hUA9TYFiPQJ1DfQGPhQl" +
       "nuH4KRSFKuSHq5N31Q91aGVBRBgqmqUAgWCKauojYuCtAK6Hhb4F/99Wygqa" +
       "b6aXLgFxvOe8M3CAHeG+o+nha+rtpDf4+udf+5WDE+M44lZcqYJFD48WPSwW" +
       "PVxZh/dYtHLpUrnWtxSL78UOhLYG5g8c42OvsN89/sgnXr4M9C1IrwCOF6DQ" +
       "vf0zduowiNItqkBrK29+Jv0+4R/XDioHdzraAmHQdL0YThfu8cQN3jpvYBfN" +
       "e+Pjf/AXX/jx1/1TU7vDcx95gLtHFhb88nnWhr6qa8Annk7/wfcqP//aL71+" +
       "66ByBbgF4ApjBfALeJkXzq9xhyW/euwVC1oeAgQbfugqTtF17Mqux2bop6ct" +
       "pcwfL+tPAB4/Wqj2y+B58UjXy/+i96mgKL9lryOF0M5RUXrdv88GP/lbv/aH" +
       "jZLdxw76xpmQx+rxq2ecQjHZjdL8nzjVAS7UdQD3O5+hf+zTX/v4d5UKACDe" +
       "d9GCt4oSA84AiBCw+Qe+uPntr/7uZ3/94FRpYhAVk6VjqdkJkUV75fp9iASr" +
       "fespPsCpOMDcCq25xXuur1mGpSwdvdDSv77xfvjn/+STN/d64ICWYzX69ree" +
       "4LT9Xb3K9/7Kh//yhXKaS2oR1E55dgq295RPnc6MAsPaFXhk3/dfnv/nv6z8" +
       "JPC5wM9FVq6XruvSkeEUSL0TeOC7jJMKSrRKqUIl2AfL8rDgSDm4UvY1iuLF" +
       "6Kx13GmAZ7KT19RP/fqfvUP4s3/39ZKcO9Obs8owVYJX9/pXFO/NwPTPnHcF" +
       "uBKZAK755uwf3nTe/AaYUQYzqiCmR1QInFF2h+ocQT907b/9h//49Ee+crly" +
       "MKxcd3xFGyqlFVYeAeqvRybwY1nwD75zL/30YVDcLEmt3EX8XmueLd8eBQi+" +
       "cm8HNCyyk1MbfvZ/Uc7yY//9r+5iQul6LgjK58bL0Od+4jnsO/64HH/qA4rR" +
       "L2R3O2iQyZ2Orf+0++cHL1/9TweVa3LlpnqUJgqKkxSWJYPUKDrOHUEqeUf/" +
       "nWnOPqa/euLj3nPe/5xZ9rz3OQ0MoF5AF/Xr5xzOYwWXnwXP00e2+PR5h3Op" +
       "UlbQcshLZXmrKL7t2L6vBaG1BTnAkYH/LfhdAs/fFE8xWdGwj9hPYkdpw3tP" +
       "8oYAxKxrkeIGDtCo+4qXDi0XOK3tUc4Evf7kV9c/8Qc/s8+HzsvyHLD+ids/" +
       "9LeHn7x9cCYLfd9dieDZMftMtGTWO4piWFjHS/dbpRwx/J9feP3f/MvXP77H" +
       "6sk7c6oB+GT4md/4318+/MzvfemC0H0Z5Mt7716UzaLo7XnavqepfOhOQb4H" +
       "PM8cCfKZewiSvYcgi+qgJHgYAzv1gZgKrSrhiCMWFH/TuFAzXzmPK/eAuL54" +
       "pHjHCngRrt/9dnB9zPK23DG6RZt0DrMPPyBmz4PnXUeYvesemGlvB7PrLvhI" +
       "A58e4EvlIrz0/wu8njvC67l74LV+e3gp2X3wch4Qr8JlvPsIr3ffA6/w7eB1" +
       "JfT9+DhY1h4gk7018zX9HBXRA1LxbUf2c2xHF1Hx0bdDxeUwdY6JgE9jI/Dy" +
       "ahKCXDE+dHx1XXwEgjpQ2pjRFU0MrVgnQfs5Kr7nAalAjvTkWF8uouL73w4V" +
       "N4DfWioObfqx74GYfkzRK3eJZXQnIHH81X+Okh94S0r2TuYSCCkP1Q/bh7Xi" +
       "/Z9cjOvlovoBkFtG5R5I4ZIsT3GOkX/GdtRbx8FG0MMIxP1bttM+JuJmKZYi" +
       "wh7uNxLO4Tp827iCqPD46WSk761e/eHf/9SX/+n7vgo8/Ljy0LaI6SAUnFlx" +
       "lhTbND/4uU8//+jt3/vhMlUGzKe/kf/7DxSzfuZ+FBfFjxTFjx6T+lxBKusn" +
       "oaqTShRPy+xW106oPee6rzj+N0FtfOPLeDMi0OMfCcuGjKoMI20bxnaKyGQb" +
       "Ix2SDB1SNbPFsEokBIONhzsaXy863VnHEdu+PWSWdODpDc0Tmbpsk5zeVsf4" +
       "ejwZD4MhtuUJZYBXsZXAEgrqBAI/yRxi0OtDzcGA5fttvmatLAa16ljTi7rT" +
       "PMmjPFlS4aizAZxtS61ttd2Qwga07coRFyLTUW3X63IUzxjrnie7rL0zaX46" +
       "dFrMZORSc6TL6m6d2oZiO6aXsC+Mmykrey3aFXxXWY7pqUPOkbkUOLDO8I5s" +
       "IfZyUFOt+VS2x/baG8v8ziDmsTtFJGHouGxV4KN8PDPHNmcH/jhdqpsQFdWd" +
       "vhrTOjVYsUN5PDChRn/ewNmJ67VQWeusF1on61OYgzsNUqa47tbUqbVr99hm" +
       "WFuaUWczsuZsm53pAirEw6bZExB50t25Yh2rGaYzZJe+0erH3pJqILPNEGPk" +
       "uaCJTX4KqSmfzVyRC6iRk+u5uiFHUDLu6kxiW3Jrh7sy1k/I3mbIKFS6mVAx" +
       "m0psXp9tCK5qYZLYnMKUTW6GqDdJfa/Ger2osazt2EHe7/WnbQ0ednartjFh" +
       "40ARhyz4fHSGNSRcam2tGhH1GhcMYDGDURVbcKtouhqMxpzDd9LU7M4CJ2iu" +
       "cDaIuuYqlych0avWtbbNOeEgQNDl0pjO4/rQY1yrD6jpDKorFxnN9YnCC8SW" +
       "yPIJFItzXlyJGgXvtCVfaxBc1x9hZJ8g5NE8qMptmm8jtDDDDBLqpQ4+V6vo" +
       "nEPrAePRE11wNoE0kdg5F8XD4SRw/Tq90l1fZHtRTR1g/TXSRlkNF6lAqtfY" +
       "jPTXRqvVI8XBsD8bLGR0uG6K1cgbcGSPpJeI1klyutXdinjbERvKZMTOzTVn" +
       "z8Zzw/NQhzLs+hrf5Vg/5dx0NIylzIfY0FcpM133mj5fXfhbt450ELUjbrYO" +
       "RYscQ27iXsRVYWew7k4ymM492G9NQyvpR4IP2wLIvGrbGrxTI3/enTocj4qj" +
       "FmvT1mI6l2lSsrOuphq7bpvkM2WxYZhawGD4dgegyV2ySdNFPuNcfoCwHYPA" +
       "J4rLdJim3ed6OpyJria2aXmajRZVRl8LtRmIVDNk5aMwtbKEcCUJi9zdUgmP" +
       "NLl2TdQGM2LQb69Vz5cGVZOGKNUZqPBGZxRnIAie4K+c/hyCs3mXr9nS2E29" +
       "SGE8PlbMJW9PxjOGh/uWG4ziLbOsrVIxV0PGHeHzmMjR2WDi4LNIrbdMd64t" +
       "iGqwrRpwElh9wDR0M1z0EyCLIbqSqBoj0Gw+MCfTJh/OkCbiSjmm2vMOTiow" +
       "Ra6Jod9YWDU5rfGmaK/mEbsmzEiTkYS04PayF1Sr/SYKtep9H+nqHkc3jWar" +
       "09e6G7MZ2RuuK0tDP5vyRK9rcbW4i0twPZeNjZ03mfFohK57Ek705wZJ6wO0" +
       "iVgmy6YzpTfnh2bm2+gCX2383XpINbhuPe20pxKWuZ0q0eRmK7RGSBHGL91a" +
       "RvQhaagv42rdrVUh1WgwilrrNkW1lzaddDhOx/i20cUhkFsEskS2FvTYbC3w" +
       "dDPXa+hq7g7pxXiFNehtR5Hn6A4h0KwVE1PMVWtErSPgOHBbhOT1R41Jmxkl" +
       "sIXreZOKvUXkbcyqLhsLZgB1s3iwxeM43nHGXPCyBdbud+pBDCEbBOrqi1oa" +
       "Z1Opbqc9Y5FnxLwjNkVWQz2+Jc3U5Sxb9ZMY0r2tPQkVyABzNXEBU6V6o4eK" +
       "GY4SsxXWwaezvFWHmqIk5WF1ObNhYd7uJWMM8ybygjfJNstHs7E4gjEYRtBp" +
       "xFOU5M/mM2lTxQR1rbiThWQ2JWvbXpBCH2rDLLl1emlYo0atWitOuYSuk+GO" +
       "k+g23sYbMFAxbBBpLOzysYsac0yryiY17eA80bb6PATCmcDolobSKhZOmO4a" +
       "tYf9rucMfWbR6wy1VerJmoUJ9a4w7g1NKR6FLLHAZKuNj6PeOt+22BW0GrfW" +
       "E8wDPmG37DSUatVAZZ9HECERYHMD83ib7PSRiLTsXjfOqr3YQfNeg5VAWljf" +
       "SEsHHroLdT52HQwTpqS6XBH4cAo+tDdMohjbeh9vLGNd2VBmX2eGa9Fu8TDv" +
       "DQgQ7XaGy7lo3iKrHTaJGjJQ242sbQb+xhnofbKVVB1mm1OmMaIhS2u71XgL" +
       "bRdshwzJvrYkYms5WELkajheN5MmsoV02YbyXdvqaN5ybFVFNE1orzkM622J" +
       "X2vVuAZN0jRaTOCJl+C217T0ZDLz5OksXMXQcFidV7fwSlZTrCdpCNmO6hCu" +
       "I1sDY6auJRNJnQHqkQR81OOoFJfBd/I6RVDNadYluY6Irj3m06jqGG6ek1SM" +
       "z2xDTLmYbUJRB0csuLlqJqsNsLVE0wwbJQfGgB3sUsnyFnMX5inN5gJztWsQ" +
       "1UXfbq/h8Yp31x0ixuxdjRzkli1uonWfMOtTB5mT3TFV1dtjcohT9m5eJWgH" +
       "bSbhdGjWsGp13AjzvLqEaczN4sxDW+3EjjF52WfiRb9N1cU6BfWl1NKNKtVv" +
       "uhPc4WLYjlfjBj1mexsj1HvjkJrMQJAxa0hn227bZtdriWgDmnUyKk/znmHY" +
       "2U6O5n0uWSmqhIzGesONNk3M6duyPZnVJwBdwl7DUOJBrQTSpo06M4YFV4dH" +
       "rQHVjbs51Ah3qh2HeaaPJX2zrtbDRs+nzTVJTLqdJdsahdu4X98KUauVy70N" +
       "0WIQn9i0d9VUJEN1jmyn82iTi3obTreCIuaSOhog2KQ+oMMBRra5IGKsmiT1" +
       "qoRo0Y4RdnjPbS+ZZdSHhq0d1Gst9YnY7zWG+Xw4mNGDBT8IUW8hdkgo3Cqd" +
       "RnOW1aiwNg+Wzai6ljp4jewJqmx2EwTpSTyMhRsRnc92ehzZPtJOLMLgXCOi" +
       "/cjU60O5Peo2KAJdsFqImdtBzjuk5Czx5rBJwtXexl+3u8MWWa8TW7hHrFqS" +
       "QPPEqMk7jBxaeKiRA2HYGsIW2V6s5zOOhpk5bI0TTl/TXDKeNiVuR+66HDqL" +
       "0JFXJxq5M8n6GR6iPdozMmm43LQCsYc2VuMoCzizFUqLfJTaPB8N0gFF8Jy2" +
       "wYO50zRTGtVyTIE2c1PNFNwIuhZTV4L6SKyvcpcS1vXMz3kBq05GcI9MaV4U" +
       "mEHbdleB7E/o9WIquUu26dl9z5nI3V3cFeZhspokS2Id0GY4JpuYyWsEV0cW" +
       "bORLQhOk1RkxSuLWahJMCTVS6ZzJyGW7G2qaSdV26mCWRIYQr9Z8viMXutiM" +
       "dynTYMON4iIiDJGIlRkDnRtyuuDhouFjYTINV8h0AKUTGt8GZA5Zo8YYkRtT" +
       "VqpKXIODPDhkVb3R2JldSkwnKKywIgPS0ZGqKKsO8FsLu6dOYy7lu4hRV9Nh" +
       "gjcVKDbkargV2yEVZbSj+g1u1BfxukRq3VmobLGJuljvptBAj6u+ynfbg3HE" +
       "4ZPYn9pdoIzIRGH69mbod2ly6zVJJMeNyQ7LZvU+sU30Wii2pqhJYsm0Hi8W" +
       "3rJmrmAzHLUnjVqAIvNRDbZyId8hTWjj4nTW7iO0pWqiuojhmWku2q18TmoN" +
       "lHPoKE23lqTE0tjewjQ0MvBGas+i+mhc7VYX44WhbnCTyUyIXhMzu8PweXeZ" +
       "1jh6YcxyLlF6lrabT3BTG0G5hXZj1CS6pj6SI0ZcUovFdBOxFAErmraVMXub" +
       "+BSy82iGIRSp1xeFSX1j0SOtP4lmSgPtIFmYOUwwgrBpnWyQ7GQSudOGBddg" +
       "H9qoTgC3JlBVRcW2OjfzyZiuuwuEkkBqHw5GelcM63SmA20X+wuqY6sNI0+G" +
       "wrKT6701UOBmf9Dno66186tbwTWsFstl3Y2SNLsatNz5u/Gi2lpyGMdlHN9j" +
       "tjOVzBub1ZLEpqQhbOK6z8ChlNDrVBCm64BKHUfe4Q3R96lwQSZG30x7UMMj" +
       "QFJCIV5IRGjP3ErueGT1c3Q3Bk5p5zBJzYI6sw03ZTeZyfS9za6nj0g09Sg5" +
       "iTgr1BhLsLCqzvnMdtTrdvls0s06y4a0jN2l0BBlwWLBx2O/SkRqdbRb9sSY" +
       "hT3UivqyR66VON3pngGhHpqo5MTuD2Ibbli8nqUEgeluE+bq1enGR/jJxt16" +
       "vQ6kTiFay5va2BpowWBuag1FENzGJPGH7CSoZ2xCogFqWkaY1Ki+1HezhSN5" +
       "NiMMFuPhglmI69QQJkqn2mJWu+2UB/EOiRgC3THNEFtNFEfVeFxNFY3wNzla" +
       "C0IWE7d+jTK73XUyafCjgVBH7JwNG01nMeKgKGDZqig5mZzioqxaS9qe0bMO" +
       "Jcx6cBtkYJtNm1QybNKkjLE+W2paPZgKjgg3+I7RwodVjEbwXFbkDTQtPuKL" +
       "z/rPPth2wxPlzsrJfQ3baRcdtx9gR2Hf9VJRvP9k76r8Xa2cO+M/s3d15hjo" +
       "5DjtXXdvRR3tBxab9c/f66JGuVH/2Y/dfkOjfgo+ODpgm5V73sHfc/St7pxZ" +
       "rLiU9MF7H0pMy3sqpwc/v/yxP3qO+w7zIw9w3v3iOTzPT/mvpp/70uhb1R89" +
       "qFw+OQa66wbNnYNevfPw53qox0nocXccAT1/wvunClYXpwWtI963zu8bnkr3" +
       "4k3DD+y149z55bnDz6fvkhaIGkBURfe/vc/R55tF8QtxcUPEii/a0rq29H1H" +
       "V7xT9fvFt9rQOrtG2fBzJ9wotbE4gR8fcWP8/4Qbz9/NDVPRLG9VXOraM+VX" +
       "78OUrxTFF4E5rvR4v//KHO2LHy/wzNkFLFdZ6cU5+NFlrpJLX/pmufQCeLgj" +
       "LnF/N1w6KAEOitdfK4r/WkL9zn048dWi+K248g7AidPTgXLsKam//U2QWm6r" +
       "o+C5fUTq7QcldXAhqVdKgCsXystVYvOQ9i0vbhz3P3tXv6AXZ+rlzQDplFd/" +
       "eB9e/WlR/H5cuWp5kR5eaExXtr6lnTLuf3wTjHuyaCxO+T5/xLjP/90w7oyO" +
       "/FFR/EkJ9df3oftviuIv30JH/upBSM2AwO5xFlVcEXn2rquc++uH6uffuPHw" +
       "M2/wv1leLDq5IvgIWXnYSBzn7IH9mfrVINQNq6Tkkf3xfVD8XXoorjx1wSFZ" +
       "XDlYWQXGl67s4R6OKzfPwwFJF39nwR6NK4+eASvO5fe1s0CPx5XLAKio3jg5" +
       "EzpzuLG/sJBdOhNCjxSjZPKTb8XkkyFnLxwVYbe8Q3scIpP9LdrX1C+8MZ59" +
       "9Outn9pfeFIdJc+LWR4mK9f2d69OwuxL95zteK6r+CvfePxnH3n/cUrw+B7h" +
       "UyU9g9uLF98uGrhBXN4Hyn/xmZ/70L9443fL053/A0CpV9TcLAAA");
}
