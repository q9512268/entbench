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
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8Zf/7uPfLbZv/wvNla2+xicAAA==");
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
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ISP1pRoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ub2gEN0uOnJuVffW3Ht/8/2u1KaZXP1xrmOayz3+XgIJeHVwOeEn5eyBP7UN" +
       "35jePYNb/BKflPxbfmv7E89tuVy6Nyzaj1a5WdS2LETqLkzhtQbjWUMtTNrL" +
       "85qfh4rGRHmtrflr/cbt2pbPaPL30yBU30XNd8trKTKfIQkqOXHed8rc8Z7G" +
       "4QTHTp3Mp0vj1XENsiFVSydy12NOThcOyl+2cKLH8tvjefk04Ro2KbbZ8tk2" +
       "c9EGoZYXbXuxaNMQ8VX0CG5J+GwZCT+Pw485aUoxbkWcQTtfOAe0eg+QMzTF" +
       "8IZpd+iFQM9cKoF2wDNsS2V45gINQvWJIywICePPczi8KLZ+vYzQ3sThFU7q" +
       "QWhughW4rlRevQRSEelpIzxTNmtT00ilRG4KQvXxWykIqSxpBRnK05EBDS4g" +
       "V5fs44j1nQz7G1fj+h5XrL8rI9b3cHiXkypZNZnBS/l45bgmJ1wZ/+oSyLgZ" +
       "17BuP2EL6sTMZRyEGmx5v8fhvNj6H2VEdBGHv01jeR/+P6SSA50HFI/Yb1pQ" +
       "9OHQ+tglnTjaUNN69JbXRI7Of5Cqg2ybzCqKtyPiea/SDZaUBYd1Vn9EXC1D" +
       "FZzMK1HVchJOyUh4KGzBVXHS6IcDY8F/XrDZnMzxgGETxHrzAtVB9QlA+Fqf" +
       "L88aRQ2KHaGI1RHKhTyVC/Fkl/nTCT+P4u0fY70hvtg6tUHW+mY7Kp08uq3/" +
       "jgvXPmr1ryWF7tuHu8yBC7vVSs/XF8sCd3P2qtq66uLcU7NXOJVYk0Wwa8+L" +
       "PKbWA0lGR1W3+Zq7Zle+x/vGseufffFQ1cthEtpFQhS0tau4d5bTs1DY7YoV" +
       "NyagFhNd5+5V35y8cW3yL78U3UliNTIWB8OPSiP3vd53auzjDeIT4SwoMllO" +
       "NPVumlQHmTRuFHQ55qIVUvx2K+Rgi68+P4tfOzjpLG7wFH8jqgVjYcYmLasm" +
       "cJt6qP3cGaeuLCjJsrruQ3BnbNXhuNuKcyh9sL/R2HZdd/pfOV24JC1d16Cd" +
       "LhWv+Lbsv3hRmce8IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e8zr1n2Y7ndf9rXje203tuPEduzctHXUfaRESaTgrKte" +
       "FCmRFClSpMS1cSiS4vshviQq9dYG7RKsWJZ1N10GtP4rxbYiTYqhRQtsHTwM" +
       "WxO0K5Ct2NIBbYqhw/oKVv+xtli6dofU97rf/e6179IK4NHhOb9zzu/9+/Gc" +
       "88VvVq7GUaUaBm5uuEFyqG+TQ9ttHiZ5qMeHI6rJKlGsaz1XiWMBtL2uvvJz" +
       "N//kW581bx1UrsmVpxXfDxIlsQI/nupx4Ga6RlVunrYOXN2Lk8otylYyBUoT" +
       "y4UoK05eoyqPnRmaVG5TxyhAAAUIoACVKECdUygw6D26n3q9YoTiJ/G68ncq" +
       "l6jKtVAt0EsqL989SahEinc0DVtSAGZ4pHgXAVHl4G1U+eAJ7Xua7yH4c1Xo" +
       "zj/52K1/eblyU67ctHy+QEcFSCRgEbnyuKd7Sz2KO5qma3LlSV/XNV6PLMW1" +
       "diXecuWp2DJ8JUkj/YRJRWMa6lG55innHlcL2qJUTYLohLyVpbva8dvVlasY" +
       "gNZnTmndU4gX7YDAGxZALFopqn485Ipj+VpSeen8iBMab48BABh63dMTMzhZ" +
       "6oqvgIbKU3vZuYpvQHwSWb4BQK8GKVglqTx/30kLXoeK6iiG/npSee48HLvv" +
       "AlCPlowohiSV954HK2cCUnr+nJTOyOebzEc/8wmf8A9KnDVddQv8HwGDXjw3" +
       "aKqv9Ej3VX0/8PGPUD+hPPPLnz6oVADwe88B72F+8Qff/r7vefGtr+xh3n8B" +
       "zGRp62ryuvqF5RNf+0Dv1fblAo1HwiC2CuHfRXmp/uxRz2vbEFjeMyczFp2H" +
       "x51vTf/D4od+Rv/Dg8oNsnJNDdzUA3r0pBp4oeXq0VD39UhJdI2sPKr7Wq/s" +
       "JyvXQZ2yfH3fOlmtYj0hK1fcsulaUL4DFq3AFAWLroO65a+C43qoJGZZ34aV" +
       "SuU6eCoYeN5b2f/K/6Ty/ZAZeDqkqIpv+QHERkFBfwzpfrIEvDWhOPVXbrCB" +
       "4kiFgsg4eVeDSIcMCyKjSNEsBYihp6imPiQHvgEwPCy0LPxrnn9b0Hdrc+kS" +
       "YP0Hzhu+C2yGCFxNj15X76Tdwdtfev1XD04M4YgzSaUKFj08WvSwWPTQsA7v" +
       "s2jl0qVyre8oFt+LGAjIAaYOnODjr/I/MPr4p1+5DHQr3FwB3C1Aofv74t6p" +
       "cyBLF6gCDa289fnND4t/Fz6oHNztVAuEQdONYjhbuMITl3f7vDFdNO/NT/3e" +
       "n3z5J94ITs3qLi99ZO33jiys9ZXzrI0CVdeA/zud/iMfVH7h9V9+4/ZB5Qpw" +
       "AcDtJQrgF/AoL55f4y6rfe3YAxa0XAUEr4LIU9yi69ht3UjMKNictpQyf6Ks" +
       "Pwl4/Fihxq+A56UjvS7/i96nw6L8jr2OFEI7R0XpYf8mH/7U13/995GS3cfO" +
       "+OaZ8MbryWtnHEAx2c3S1J881QEh0nUA91ufZ//x5775qb9dKgCA+NBFC94u" +
       "yh4wfCBCwOYf/cr6N7/x21/4jYNTpUlABEyXrqVuT4gs2is3HkAkWO07T/EB" +
       "DsQFRlZoze2Z7wWatbKUpasXWvrnNz9c+4U/+sytvR64oOVYjb7nnSc4bX9f" +
       "t/JDv/qxP32xnOaSWgSwU56dgu294tOnM3eAYeUFHtsf/k8v/NNfUX4K+Ffg" +
       "02Jrp5du6tKR4RRIvRd423uMcxKWaJVShUqwj5TlYcGRcnCl7EOK4qX4rHXc" +
       "bYBnMpHX1c/+xh+/R/zjf/N2Sc7dqcxZZaCV8LW9/hXFB7dg+mfPuwJCiU0A" +
       "13iL+f5b7lvfAjPKYEYVxO94EgFntL1LdY6gr17/b//23z3z8a9drhzglRtu" +
       "oGi4Ulph5VGg/npsAj+2Df/W9+2lv3kEFLdKUiv3EL/XmufKt8cAgq/e3wHh" +
       "RSZyasPP/Z+Ju/zkf/+ze5hQup4LAvC58TL0xZ98vve9f1iOP/UBxegXt/c6" +
       "aJC1nY6t/4z3vw9eufbvDyrX5cot9SglFBU3LSxLBmlQfJwngrTxrv67U5p9" +
       "/H7txMd94Lz/ObPsee9zGhhAvYAu6jfOOZzHCy4/B55njmzxmfMO51KlrHTK" +
       "IS+X5e2i+K5j+74eRlYG4v2Rgf8l+F0Cz18UTzFZ0bCPzk/1jlKED57kCCGI" +
       "WddjxQtdoFEPFC8bWR5wWtlRfgS98dQ3nJ/8vZ/d5z7nZXkOWP/0nb//l4ef" +
       "uXNwJuP80D1J39kx+6yzZNZ7igIvrOPlB61SjsD/55ff+Ff//I1P7bF66u78" +
       "aQA+D372v/zfXzv8/O989YLQfRnkxnvvXpSNoujueYre11Q+ercgPwCeZ48E" +
       "+ex9BMnfR5BFdVASjCfATgMgpkKrSjjyiAXFH50UahYo53EVHhLXl44U71gB" +
       "L8L1B94Nro9bfiYco1u0zc9h9rGHxOwF8LzvCLP33Qcz7d1gdsMDH2TgMwN8" +
       "lVyEl/7/gdfzR3g9fx+8nHeHl7J9AF7uQ+JVuIz3H+H1/vvgFb0bvK5EQZAc" +
       "B0v4ITLZ20yg6eeoiB+Siu86sp9jO7qIik+8GyouRxv3mIjaaWwEXl5NI5Ar" +
       "JoduoDrFBx+oA6VNprqiSZGV6BRoP0fFDz4kFc0jPTnWl4uo+JF3Q8VN4LeW" +
       "isuaQRL4IKYfU/TqPWIZ3g1IHn/hn6PkR9+Rkr2TuQRCytX6IXoIF+//4GJc" +
       "LxfV7wa5ZVzudxQuyfIV9xj5Z21XvX0cbEQ9ikHcv2276DERt0qxFBH2cL9p" +
       "cA5X/F3jCqLCE6eTUYFvvPZjv/vZX/uHH/oG8PCjytWsiOkgFJxZkUmLLZm/" +
       "98XPvfDYnd/5sTJVBsznr7799fID9/MPorgo/lFR/Pgxqc8XpPJBGqk6pcQJ" +
       "XWa3unZC7TnXfcUNvg1qk1tXiEZMdo5/1ExeIZ1ZbeVrI54zRxOOcJyO0ZmN" +
       "ucZCQwJvFAVbhewsRkTe46YhNlCQtN5Oa2meoFmcOXEqjYMchkl0Bse1sa/M" +
       "MqQH2x1KqEVDTQx0SVHx6aQ6YWsmpq0gDonmszXcChNFSiG0iqSohuqoNOfH" +
       "si+7KIJkabWNQiskk6orfQTRtIHwG5HTGzLdovNJe2xWDTN2eJYLajtpuBg2" +
       "Z3o07kLZqoZBiGjObLHXXCthKtatURLHdC6adtitS8KsKfKi17YnEkduukbT" +
       "p4djTa0l3JR2sXp1N26RTpwjrYY77FBxOFBoBicmfcHTm8qORYKe0DZNbmBK" +
       "s2l/1XLRxA4HKN8eOPMVOSAyWt8ZYUdu57ngYMsFYYeToOak4/ZwsWSp1B8Q" +
       "UmsU5J5IwoQ3aBKJZ0eUhse9ej1zjIGvqAobhY0JAwfTfo9dr6Nhd555ZJ+u" +
       "yfLGXayFrq/XRIleqjzaJMfeyLENfeG0Wgu1bsz6AdILuBZCmVNujkGz5Vgm" +
       "BtXtRm6p6/ls3JvgrpSS7qQvr7fJ1uEYmp4w2s6b851+Amc7BA9VPMIbUDMK" +
       "auQEYZAWatg87XRkmZiN8lGv19vkA5vEe5IlsH1kZJIxzZGKOOrWZyztjB0L" +
       "RekaIu3GY3meU2N7NeCSieyLntVnNGkx0A1BtccIweTUZI53ZBdqrkVxaIz1" +
       "YW2rL2cNhNztNsNe0ic5mefCutxiZnbsro2QdlfBBrNrMNLZ9AzRUxdCPWsG" +
       "eSj2zIlTF8ipqazDVre38MOgB+OOMhz3u7yYGaFlRv4stBlaHML8qK12WGng" +
       "9Bk8GHXwAepVMWIgrHsuE1Yllg2bGQS19GqTS1qhOTDGygDe8g7baBqMYHLb" +
       "0OGlxQbr0FQsNWtoh1CwODfp3qDDMhixpAcYtJhRw7Zc9/tNf8Nv1p0lbWeB" +
       "NlrhXAsPIRROx7qoaSLZdWrAkYzX7Ka3C6R5XzMiRHA00tlSK0dT7b5FhRsN" +
       "qkYeakcsslnzdbs2HXkhxRhduMaL4dDdit5yOFjTuelbQiP3Wt6IiAh92opM" +
       "llei3SjSnFmu2Kw+5R2RFiXfYhpG0BNTwxpG5lxUBC+bpLNmQ0J3njbASaYP" +
       "OTDLTkZtflVVkdGSGddcaTQdiyNRpITQUGgLGi4kcrBZyeGa8UQHXtcdYcaM" +
       "+UBeC3mWz5kFM5wRE3jXH605erqrzXo+k2RCbW15Bk2OpNCFLGjOkgiaj2Yd" +
       "c5C17azaiRo7XGZ4oWuLo2i8TNdtdUjBupoGcBeP83kv7xotpk5qQ4zpknzQ" +
       "GBCDsEfOCUmeW41QGnFw12pMYkFJXbHvt6v1aq3rdzVLYt3BCHbm3C4Yq3CV" +
       "HXZynbThwPeqGULNExSRnc16kU9lK9pS+GxjSht4ZvbUsE8sV9XMckhEDan+" +
       "zNlyG28Lkq8uyTmNMW+gNcoWlpP+aOc3+xTbd9Axl+p019JpJ+MFGFY9NGmC" +
       "n2gOLJTuILZDdUzT6rc6sBCvwmWGQW57jTSUfnOHtapqt7pbwIPuwsfzhYZ7" +
       "tNkP25gCTUjZFRdZOKsybDSB+IbZZpzpWnAIfNDhUGiozrqjMB3VDZvazTsq" +
       "Tu5oV+iOZqthImwTpcumdr8vjDK8OpRtnGB5TPAtqT5uBFDKrK1G017X55Iy" +
       "VKuUM+XTIU6uqkLNh5CtYuHpCMFgvUtBgwmr+aGFezuJajGC46X1zWZqd7K5" +
       "6DQoFEV21QbfNmKut8k0qTO3bZhbwz2cnCwyX8vQrZ1kBBLXUCZomi1es2ds" +
       "4mDxzlpNnMTIBZWJXAqMwbY82asbtflSDxajdj5by1tTwW1IScztcu1D/pYN" +
       "6jOiF28acjStVw1ErS6kZY4jLAI1t2bb8EZDYqJJc89wve5q1EIxWCG7MkNO" +
       "q2jqtmOwYrwyZK6z0KxZezeYSrNJPcqZKdCyLk5LArEMDL5u1jKuh86C3TwY" +
       "cAPaxKNadbjZZNPWtDXo68Han+n+Zr2FZii0M+pc2vNVap3XY7re8vWl5qz6" +
       "4cpfsIm0ggSFj2F4g9d2aVatT9M5PNXMbZdQZsGE22hbg2MRGg89pr9rhVUM" +
       "1nzJVyBxQPQ82EuChBjI1hpz6M0Qq2ve0BllQgbFXSdDB7vZhumEEj8ldtPp" +
       "BCAuuZqWLuGlz20jNEvmKFKN9UlmIfSMWtWlnrBRdp0lTk61mTpBfR/C3BnU" +
       "hig8Y/tdU+SGkRFPtH4d6rKIGmDcBIL8dJoPJGNcG5pVtksEDoYhjLxrIHEP" +
       "acANi6mLY6xpDChRQ8bpBPTQWm3ZHg3y9RS2bJlZ0ZOWx08FDMSBaKp1wnA9" +
       "jqmakUTsOuu01CZRo+dVZaI2ayYUIfRmhG4sBoWkKoYrxNjddIRGllR5pIp1" +
       "F1YjFT1jOeLtcbJN6fFolEgtUp20rczv5fIm9zZjnteJaleQlw7BbWOu5jby" +
       "hcP3nT4276uRqWTDxEgIPVCqwMd1NglF4uYG21bZlYf4CpLoA2ZY77rsJqYn" +
       "yAjDe+tMGVQdhUIHkEFtBHYFdbuqT/TW0VrRqzt+WfeqbYdeUl5Ks4ZiVZvZ" +
       "ajjPGtCIljoISmGb4Y6rMSuIn+a7JicC46C27NgaJi1qUYMtipA3aUcKpdoy" +
       "xcnhtsphfhuCDGwFE5SyVnpYZs4jOwEIUisUSGVFpSqwjpiL5MyY6o2Gt3Y6" +
       "HKVJ9FZjmPnQbzZSyrXoXMhYdyyIutSWNGU+pgROsellO7epTLYaopfuzCAy" +
       "RxSnaMOeOzc3kAGzNB0Plp2UWSxbhEY1FL8mLKc1o4cmLRAwBRvGt0lj0FeI" +
       "dLzubheG1KUbdN2LuitUayG+ttXwNYODXG1VIwERjkxH9kDzUCKfxduUUmMD" +
       "JhY+I4xambXZ5OwEXQ2mCpZzdUJu4ElEUNzGYFxdqve6seAFu9gOBgxwWtxI" +
       "tbTVCCKpOcOuN4nBcGjeJBWTrDuwu5FnaVUhFWehmyvZzOExyc4peeYwm1Rx" +
       "4KQDo+GUFzHUUJKl2EeJ7rZtd4fCuO64xkQY7aDR1EZ11x8aUcdMu45gxex8" +
       "EumwMeMSmYP7XDO3eIld1MguonY61XxoW6LDetRYlkW4wy4amp8zZquOdVQu" +
       "z/D6aJjbHdHk0MEIE2oTdzGEt/ZMbDljIhdFPE8SvsfYPkPJ2K5fm5m2x8Yt" +
       "FJiOX10HVgY00YRdetmMM9hU505dVgaW0miv+5jrJPm2U2OIwS7W51O93oNW" +
       "y+lwJ0W1/mKC05hZJ9h0WTcGDJxO/FEqrlYSQiQQBtXT2liR52xtG3kTJd8h" +
       "1blBjnRC3Ez0gd/U8y6LzhikaevsgllC3fHKZbfLlQf8DdZOUjFvMflOsWtK" +
       "U9L4OgWyKMrZmQm3tKUZnQhMRGHN9cpsRMMp4SXRyo0gdZnUwyWrsBQC590Z" +
       "As8ZDUuisTBegYi6nswJXcMiFZPRYYMTCCFE6BDO7Np8wMQWLvK5ltfqzEQw" +
       "1UnuVuvqmCKwJLP1lQM3pkF9vFzKWOLU1fZgGMiL+XKebhWG5jBxDveGzRFw" +
       "3XJPqLKbBtYEXne7dCSVE5LVpKPDulHl6J2AY6QcalUL5+i2Og7w+qbPxHxd" +
       "BAkgyXCZNCLzDdnTWVbdWdiYkqvZYschsWDiM3TNSWZqmFIjcqd6xk35ge6G" +
       "5G4rMF4CcgHLnQ4bYy6bb6XcIdf8NuxO/THcHHT7fMMQm6u40bBrPrdDh7WV" +
       "XTWbc8DBiGwvEZWw5k4eyozsd3nIbTSXIL7VNjJUDficMuQa2k3Z+oBqxQIt" +
       "Ay899LbNDFuZGWO3iLo40LpDIoNrtj6FqmyL5ztNmMBJaLGshVx7QnDVxHB9" +
       "wVZmDNNqj5bzKYlOVs3e2qjny11vPU5y1tIViO/Lyqy70Gqi3x7Me7U+Lu/o" +
       "cY0QVfDlmM/Mxni464pzggeOuL/AcGge9WWf3m2N4UDYEtGuk4jdNud2qvh6" +
       "RWGYMuXqY0IZkrUpMTaFXOxBuONCvlDIqJHCqwUKm1litJIZIVW9BToOYSxd" +
       "I5BtZHPWi2pRLuFokhIplnd7aCbyMTTHsbinIWx9naxbLeBkZigzn4zEhQNL" +
       "GwWrUux4KXVgdzitSUhVXqOyq1e3UDaM9XS1Akl6TU3MQRLinMnDiZI2tOZS" +
       "iIEtoYtAZHLFwE1Ga1abItLMMVVCcgrFZsjMtRiBlLrYhOUtFsm0JqKkO7uv" +
       "k0KD3wS0604YVkw9lyM8YZriBNdsrklxlm3r4+rUsFoYIBjo4c4OqSG6wQnM" +
       "XhuivVAXHqXEnjoCHhcE4qGip1TPHsVRlHJI118yczNl0rGam+2YgqbAb2oa" +
       "FK4mYr0x6tW0WqunUaaUVallnCHm1FN1jOQ6nWI74AsPt03xZLkjc3Knw3bR" +
       "ouPOQ+xE7LteLooPn+x5lb9rlXP3AM7seZ05Pjo5hnvfvVtYR/uIxSb/C/e7" +
       "zFFu8H/hk3fe1CY/XTs4Ophjyr3y8G+4eqa7ZxYrLi595P6HGXR5l+X0wOhX" +
       "PvkHzwvfa378Ic7JXzqH5/kp/wX9xa8Ov1P98YPK5ZPjo3tu2dw96LW7D41u" +
       "RHqSRr5w19HRCye8f7pgdXHK0Drifev8fuOpdC/ebPzuvXacO/c8d2j6zD3S" +
       "4lUdiKro/tcPODJ9qyh+MSlukVjJRVth15dB4OqKf6p+v/ROG2Fn1ygbfv6E" +
       "G6U2Fif3oyNujP5auPHCvdwwFc3yjeLi154p//EBTPlaUXwFmKOhJ/t92+nR" +
       "fvrxAs+eXcDyFEMvzs+PLnyVXPrqt8ulF8EjHHFJ+Kvh0kEJcFC8/npR/OcS" +
       "6rcewIlvFMXXk8p7ACdOTxXKsaek/ua3QWq5Hd8Bz50jUu88LKmDC0m9UgJc" +
       "uVBeHvjAPWQDy0+Q4/7n7ukX9eIsvrxRMD/l1e8/gFf/qyh+N6lcs/xYjy40" +
       "pitZYGmnjPsf3wbjnioai9PBLx0x7kt/NYw7oyN/UBR/VEL9+QPo/oui+NN3" +
       "0JE/exhSt0Bg9znDKq6WPHfPdc/9FUX1S2/efOTZN2f/tbyQdHKN8FGq8sgq" +
       "dd2zB/1n6tfCSF9ZJSWP7o/9w+Lv0tWk8vQFh2tJ5cCwCowvXdnDPZJUbp2H" +
       "A5Iu/s6CPZZUHjsDVpzn72tngZ5IKpcBUFG9eXKWdOZQZH/RYXvpTAg9UoyS" +
       "yU+9E5NPhpy9qFSE3fKe7XGITPc3bV9Xv/zmiPnE262f3l+UUl1ltytmeYSq" +
       "XN/f2ToJsy/fd7bjua4Rr37riZ979MPHKcETe4RPlfQMbi9dfCtp4IVJeY9o" +
       "90vP/vxH/9mbv12eCv0/E3F6BQAtAAA=");
}
