package org.sunflow.core.photonmap;
public class GridPhotonMap implements org.sunflow.core.GlobalPhotonMapInterface {
    private int numGather;
    private float gatherRadius;
    private int numStoredPhotons;
    private int nx;
    private int ny;
    private int nz;
    private org.sunflow.math.BoundingBox bounds;
    private org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup[] cellHash;
    private int hashSize;
    private int hashPrime;
    private java.util.concurrent.locks.ReentrantReadWriteLock rwl;
    private int numEmit;
    private static final float NORMAL_THRESHOLD = (float) java.lang.Math.
                                                    cos(
                                                      10.0 *
                                                        java.lang.Math.
                                                          PI /
                                                        180.0);
    private static final int[] PRIMES = { 11, 19, 37, 109, 163, 251, 367,
    557,
    823,
    1237,
    1861,
    2777,
    4177,
    6247,
    9371,
    21089,
    31627,
    47431,
    71143,
    106721,
    160073,
    240101,
    360163,
    540217,
    810343,
    1215497,
    1823231,
    2734867,
    4102283,
    6153409,
    9230113,
    13845163 };
    public GridPhotonMap(int numEmit, int numGather, float gatherRadius) {
        super(
          );
        this.
          numEmit =
          numEmit;
        this.
          numGather =
          numGather;
        this.
          gatherRadius =
          gatherRadius;
        numStoredPhotons =
          0;
        hashSize =
          0;
        rwl =
          new java.util.concurrent.locks.ReentrantReadWriteLock(
            );
        numEmit =
          100000;
    }
    public void prepare(org.sunflow.math.BoundingBox sceneBounds) { bounds =
                                                                      new org.sunflow.math.BoundingBox(
                                                                        sceneBounds);
                                                                    bounds.
                                                                      enlargeUlps(
                                                                        );
                                                                    org.sunflow.math.Vector3 w =
                                                                      bounds.
                                                                      getExtents(
                                                                        );
                                                                    nx =
                                                                      (int)
                                                                        java.lang.Math.
                                                                        max(
                                                                          w.
                                                                            x /
                                                                            gatherRadius +
                                                                            0.5F,
                                                                          1);
                                                                    ny =
                                                                      (int)
                                                                        java.lang.Math.
                                                                        max(
                                                                          w.
                                                                            y /
                                                                            gatherRadius +
                                                                            0.5F,
                                                                          1);
                                                                    nz =
                                                                      (int)
                                                                        java.lang.Math.
                                                                        max(
                                                                          w.
                                                                            z /
                                                                            gatherRadius +
                                                                            0.5F,
                                                                          1);
                                                                    int numCells =
                                                                      nx *
                                                                      ny *
                                                                      nz;
                                                                    org.sunflow.system.UI.
                                                                      printInfo(
                                                                        org.sunflow.system.UI.Module.
                                                                          LIGHT,
                                                                        "Initializing grid photon map:");
                                                                    org.sunflow.system.UI.
                                                                      printInfo(
                                                                        org.sunflow.system.UI.Module.
                                                                          LIGHT,
                                                                        "  * Resolution:  %dx%dx%d",
                                                                        nx,
                                                                        ny,
                                                                        nz);
                                                                    org.sunflow.system.UI.
                                                                      printInfo(
                                                                        org.sunflow.system.UI.Module.
                                                                          LIGHT,
                                                                        "  * Total cells: %d",
                                                                        numCells);
                                                                    for (hashPrime =
                                                                           0;
                                                                         hashPrime <
                                                                           PRIMES.
                                                                             length;
                                                                         hashPrime++)
                                                                        if (PRIMES[hashPrime] >
                                                                              numCells /
                                                                              5)
                                                                            break;
                                                                    cellHash =
                                                                      (new org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup[PRIMES[hashPrime]]);
                                                                    org.sunflow.system.UI.
                                                                      printInfo(
                                                                        org.sunflow.system.UI.Module.
                                                                          LIGHT,
                                                                        "  * Initial hash size: %d",
                                                                        cellHash.
                                                                          length);
    }
    public int size() { return numStoredPhotons;
    }
    public void store(org.sunflow.core.ShadingState state,
                      org.sunflow.math.Vector3 dir,
                      org.sunflow.image.Color power,
                      org.sunflow.image.Color diffuse) {
        if (org.sunflow.math.Vector3.
              dot(
                state.
                  getNormal(
                    ),
                dir) >
              0)
            return;
        org.sunflow.math.Point3 pt =
          state.
          getPoint(
            );
        if (!bounds.
              contains(
                pt))
            return;
        org.sunflow.math.Vector3 ext =
          bounds.
          getExtents(
            );
        int ix =
          (int)
            ((pt.
                x -
                bounds.
                  getMinimum(
                    ).
                  x) *
               nx /
               ext.
                 x);
        int iy =
          (int)
            ((pt.
                y -
                bounds.
                  getMinimum(
                    ).
                  y) *
               ny /
               ext.
                 y);
        int iz =
          (int)
            ((pt.
                z -
                bounds.
                  getMinimum(
                    ).
                  z) *
               nz /
               ext.
                 z);
        ix =
          org.sunflow.math.MathUtils.
            clamp(
              ix,
              0,
              nx -
                1);
        iy =
          org.sunflow.math.MathUtils.
            clamp(
              iy,
              0,
              ny -
                1);
        iz =
          org.sunflow.math.MathUtils.
            clamp(
              iz,
              0,
              nz -
                1);
        int id =
          ix +
          iy *
          nx +
          iz *
          nx *
          ny;
        synchronized (this)  {
            int hid =
              id %
              cellHash.
                length;
            org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup g =
              cellHash[hid];
            org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup last =
              null;
            boolean hasID =
              false;
            while (g !=
                     null) {
                if (g.
                      id ==
                      id) {
                    hasID =
                      true;
                    if (org.sunflow.math.Vector3.
                          dot(
                            state.
                              getNormal(
                                ),
                            g.
                              normal) >
                          NORMAL_THRESHOLD)
                        break;
                }
                last =
                  g;
                g =
                  g.
                    next;
            }
            if (g ==
                  null) {
                g =
                  new org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup(
                    id,
                    state.
                      getNormal(
                        ));
                if (last ==
                      null)
                    cellHash[hid] =
                      g;
                else
                    last.
                      next =
                      g;
                if (!hasID) {
                    hashSize++;
                    if (hashSize >
                          cellHash.
                            length)
                        growPhotonHash(
                          );
                }
            }
            g.
              count++;
            g.
              flux.
              add(
                power);
            g.
              diffuse.
              add(
                diffuse);
            numStoredPhotons++;
        }
    }
    public void init() { org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "Initializing photon grid ...");
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Photon hits:      %d",
                             numStoredPhotons);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Final hash size:  %d",
                             cellHash.
                               length);
                         int cells = 0;
                         for (int i = 0; i <
                                           cellHash.
                                             length;
                              i++) { for (org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup g =
                                            cellHash[i];
                                          g !=
                                            null;
                                          g =
                                            g.
                                              next) {
                                         g.
                                           diffuse.
                                           mul(
                                             1.0F /
                                               g.
                                                 count);
                                         cells++;
                                     } }
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Num photon cells: %d",
                             cells); }
    public void precomputeRadiance(boolean includeDirect,
                                   boolean includeCaustics) {
        
    }
    private void growPhotonHash() { if (hashPrime >=
                                          PRIMES.
                                            length -
                                          1)
                                        return;
                                    org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup[] temp =
                                      new org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup[PRIMES[++hashPrime]];
                                    for (int i =
                                           0;
                                         i <
                                           cellHash.
                                             length;
                                         i++) {
                                        org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup g =
                                          cellHash[i];
                                        while (g !=
                                                 null) {
                                            int hid =
                                              g.
                                                id %
                                              temp.
                                                length;
                                            org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup last =
                                              null;
                                            for (org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup gn =
                                                   temp[hid];
                                                 gn !=
                                                   null;
                                                 gn =
                                                   gn.
                                                     next)
                                                last =
                                                  gn;
                                            if (last ==
                                                  null)
                                                temp[hid] =
                                                  g;
                                            else
                                                last.
                                                  next =
                                                  g;
                                            org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup next =
                                              g.
                                                next;
                                            g.
                                              next =
                                              null;
                                            g =
                                              next;
                                        }
                                    }
                                    cellHash =
                                      temp;
    }
    public synchronized org.sunflow.image.Color getRadiance(org.sunflow.math.Point3 p,
                                                            org.sunflow.math.Vector3 n) {
        if (!bounds.
              contains(
                p))
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.math.Vector3 ext =
          bounds.
          getExtents(
            );
        int ix =
          (int)
            ((p.
                x -
                bounds.
                  getMinimum(
                    ).
                  x) *
               nx /
               ext.
                 x);
        int iy =
          (int)
            ((p.
                y -
                bounds.
                  getMinimum(
                    ).
                  y) *
               ny /
               ext.
                 y);
        int iz =
          (int)
            ((p.
                z -
                bounds.
                  getMinimum(
                    ).
                  z) *
               nz /
               ext.
                 z);
        ix =
          org.sunflow.math.MathUtils.
            clamp(
              ix,
              0,
              nx -
                1);
        iy =
          org.sunflow.math.MathUtils.
            clamp(
              iy,
              0,
              ny -
                1);
        iz =
          org.sunflow.math.MathUtils.
            clamp(
              iz,
              0,
              nz -
                1);
        int id =
          ix +
          iy *
          nx +
          iz *
          nx *
          ny;
        rwl.
          readLock(
            ).
          lock(
            );
        org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup center =
          null;
        for (org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup g =
               get(
                 ix,
                 iy,
                 iz);
             g !=
               null;
             g =
               g.
                 next) {
            if (g.
                  id ==
                  id &&
                  org.sunflow.math.Vector3.
                  dot(
                    n,
                    g.
                      normal) >
                  NORMAL_THRESHOLD) {
                if (g.
                      radiance ==
                      null) {
                    center =
                      g;
                    break;
                }
                org.sunflow.image.Color r =
                  g.
                    radiance.
                  copy1(
                    );
                rwl.
                  readLock(
                    ).
                  unlock(
                    );
                return r;
            }
        }
        int vol =
          1;
        while (true) {
            int numPhotons =
              0;
            int ndiff =
              0;
            org.sunflow.image.Color irr =
              org.sunflow.image.Color.
              black(
                );
            org.sunflow.image.Color diff =
              center ==
              null
              ? org.sunflow.image.Color.
              black(
                )
              : null;
            for (int z =
                   iz -
                   (vol -
                      1);
                 z <=
                   iz +
                   (vol -
                      1);
                 z++) {
                for (int y =
                       iy -
                       (vol -
                          1);
                     y <=
                       iy +
                       (vol -
                          1);
                     y++) {
                    for (int x =
                           ix -
                           (vol -
                              1);
                         x <=
                           ix +
                           (vol -
                              1);
                         x++) {
                        int vid =
                          x +
                          y *
                          nx +
                          z *
                          nx *
                          ny;
                        for (org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup g =
                               get(
                                 x,
                                 y,
                                 z);
                             g !=
                               null;
                             g =
                               g.
                                 next) {
                            if (g.
                                  id ==
                                  vid &&
                                  org.sunflow.math.Vector3.
                                  dot(
                                    n,
                                    g.
                                      normal) >
                                  NORMAL_THRESHOLD) {
                                numPhotons +=
                                  g.
                                    count;
                                irr.
                                  add(
                                    g.
                                      flux);
                                if (diff !=
                                      null) {
                                    diff.
                                      add(
                                        g.
                                          diffuse);
                                    ndiff++;
                                }
                                break;
                            }
                        }
                    }
                }
            }
            if (numPhotons >=
                  numGather ||
                  vol >=
                  3) {
                float area =
                  (2 *
                     vol -
                     1) /
                  3.0F *
                  (ext.
                     x /
                     nx +
                     ext.
                       y /
                     ny +
                     ext.
                       z /
                     nz);
                area *=
                  area;
                area *=
                  java.lang.Math.
                    PI;
                irr.
                  mul(
                    1.0F /
                      area);
                rwl.
                  readLock(
                    ).
                  unlock(
                    );
                rwl.
                  writeLock(
                    ).
                  lock(
                    );
                if (center ==
                      null) {
                    if (ndiff >
                          0)
                        diff.
                          mul(
                            1.0F /
                              ndiff);
                    center =
                      new org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup(
                        id,
                        n);
                    center.
                      diffuse.
                      set(
                        diff);
                    center.
                      next =
                      cellHash[id %
                                 cellHash.
                                   length];
                    cellHash[id %
                               cellHash.
                                 length] =
                      center;
                }
                irr.
                  mul(
                    center.
                      diffuse);
                center.
                  radiance =
                  irr.
                    copy1(
                      );
                rwl.
                  writeLock(
                    ).
                  unlock(
                    );
                return irr;
            }
            vol++;
        }
    }
    private org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup get(int x,
                                                                     int y,
                                                                     int z) {
        if (x <
              0 ||
              x >=
              nx)
            return null;
        if (y <
              0 ||
              y >=
              ny)
            return null;
        if (z <
              0 ||
              z >=
              nz)
            return null;
        return cellHash[(x +
                           y *
                           nx +
                           z *
                           nx *
                           ny) %
                          cellHash.
                            length];
    }
    private class PhotonGroup {
        int id;
        int count;
        org.sunflow.math.Vector3 normal;
        org.sunflow.image.Color flux;
        org.sunflow.image.Color radiance;
        org.sunflow.image.Color diffuse;
        org.sunflow.core.photonmap.GridPhotonMap.PhotonGroup
          next;
        PhotonGroup(int id, org.sunflow.math.Vector3 n) {
            super(
              );
            normal =
              new org.sunflow.math.Vector3(
                n);
            flux =
              org.sunflow.image.Color.
                black(
                  );
            diffuse =
              org.sunflow.image.Color.
                black(
                  );
            radiance =
              null;
            count =
              0;
            this.
              id =
              id;
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
          ("H4sIAAAAAAAAALVYDWwUxxWeO///gH8Am/+AMUn56W0JpElkSgCDwfSAEw6W" +
           "YlKOub05e/He7rI7a5+d0kKkCLdSEVUIIRGgSiUlQklAVaNWTRNRRW1TJa2U" +
           "NG2SViVVValUKWpQy0+gafre7N7tz/kuJVJP2r3Z2ffm/cx773uzz10mVZZJ" +
           "5jONx/iYwazYRo0nqGmxdLdKLetBmEvKT1bQf+6+tO3+KKkeIFOHqLVVphbr" +
           "UZiatgbIPEWzONVkZm1jLI0cCZNZzByhXNG1ATJDsXqzhqrICt+qpxkS9FMz" +
           "Tloo56aSsjnrdRfgZF4cNJGEJtK68OuuOGmUdWPMI5/pI+/2vUHKrCfL4qQ5" +
           "vpeOUMnmiirFFYt35UyyzNDVsUFV5zGW47G96j2uC7bE7ylyQcf5pmu3jgw1" +
           "CxdMo5qmc2GetYNZujrC0nHS5M1uVFnW2ke+RiripMFHzElnPC9UAqESCM1b" +
           "61GB9lOYZme7dWEOz69UbcioECcLg4sY1KRZd5mE0BlWqOWu7YIZrF1QsNax" +
           "ssjEJ5ZJR5/c3fz9CtI0QJoUrQ/VkUEJDkIGwKEsm2KmtS6dZukB0qLBZvcx" +
           "U6GqMu7udKulDGqU27D9ebfgpG0wU8j0fAX7CLaZtsx1s2BeRgSU+1SVUekg" +
           "2Nrm2epY2IPzYGC9AoqZGQpx57JUDitampM7whwFGzu/DATAWpNlfEgviKrU" +
           "KEyQVidEVKoNSn0QetogkFbpEIAmJ7NLLoq+Nqg8TAdZEiMyRJdwXgFVnXAE" +
           "snAyI0wmVoJdmh3aJd/+XN62+vAj2mYtSiKgc5rJKurfAEzzQ0w7WIaZDPLA" +
           "YWxcGj9G216eiBICxDNCxA7ND796Ze3y+Rdec2jmTEKzPbWXyTwpn05NfXNu" +
           "95L7K1CNWkO3FNz8gOUiyxLum66cARWmrbAivozlX17Y8fOHDpxlH0RJfS+p" +
           "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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+6M3//7TXyvOXv4Hs2b3hwEjAAA=");
    }
    public boolean allowDiffuseBounced() {
        return true;
    }
    public boolean allowReflectionBounced() {
        return true;
    }
    public boolean allowRefractionBounced() {
        return true;
    }
    public int numEmit() { return numEmit;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hcJL/BXfXv4fIDQyldQxAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xdDfqhM4oqjBvLJBKGkaE+1aRcjiZBsH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("MCvQHolNPGVsVJeVzpAti/UJniHWdrhWbF5lMAY3Oqre6BGkrnJCWbDSbMkT" +
       "SEBX4W6F82jbnTPmkui1k40/xepLuq1IeBmx4qRPWRWqjQ/Upg7UTC/o9qpD" +
       "CCGjeYYFHdxvTlqrJKXZjI3E4TDpVCZgYVZJ5W5fWImD0Foqaa+xCI2JIdnS" +
       "Sh6BlZyv2VzOC6+2HLCq1bIT1hQ3LB74FQshRhNgFObadm3UfXTlAOe05bdU" +
       "08AGvV6n35hyYxubMmJjgvccootXcViLcL87TbvIhNVHtLyoj7klFph0e4mg" +
       "HjkXDQWlK1TCWS2IKWMTX2KpqSd0zNZgTLMqycrzecLj5Wq0GpTrUKPKp3rS" +
       "VaZSdWi3AltwBDRFTQ2tDUlhQA5Bo8N+L9xKaZktp67Y7aX4YiJI+kx3SUgZ" +
       "rAxFXOn8dCJkAx1trKx6e96CWUvDk+66ZocMWAP0uXCJVOneAlXDmkgNFMnU" +
       "idk6yfg6WA8FEDQieiSxNtdCp7fczFsDsNSOxJagNp1mg2KaMJKhyJCZyikx" +
       "r/VYvhr5DFnR+9xCqEstRU4VGnMXvZgWqnzYaNY0XVDJslIfQj6ykTvhpjFW" +
       "WY6SJz29sSGgrKYjWS+k55tuHY0Ya1krVyK9iRAsLnFmeyLoAlNGFxplT+UB" +
       "TNZSqBMTc7DACZEZvNXXbGVATm0PhTy+tSE1UhErwQZikUYZDeZCAimt2OF0" +
       "j68vh6QjkbKewUYa9PmJpuBUskBn1tQP6iKcWD41rjWW0chB+mKPFSBHiCAi" +
       "sf0KJq4om5k1eyLwCLNqVGHJMtGcVmx56UPtrdzr4w5dJmXfN8omDq3nRHWz" +
       "xRPJq07qYyZryMZSGYwgbK7P13WdxCeZo07Sdrv99nwr8a9vbYvz/mI39zBY" +
       "3HKaeca3bmEXMz32ZfLww0Lxd0fpVIDxsc8YRclHj+2gPxSXnrruw3XP8WXJ" +
       "OfxgTR58MM9DyB6/UdR4EUj3mQ8+94JKfxa+sL9Z3oxLd8V+8FZHW2vOsc53" +
       "H9g/eQi8CCWtgKu8D7x8+vvLEWvO/nr15h1rT23c7x0VeG9eYO/eG+/s713O" +
       "k0tFxJMWSKF25mbz2jfVwxHau+ul9pmP93GK5ssHX37evk/z218Zmo+T9Jpz" +
       "8p7Ik0fiXQRo8RXmiK5HXwZdxViy4Grv09V+Zei6rShw24HYPn6d2HJLKQ98" +
       "yQ+THEYyPHpdfAyv5bGKtYMCjxwvYLqSoeUhuH4e3Lb31oJPbz6Hh7l07D0Z" +
       "l26P8gCv/OH+IyZefblMzD/cR/tMjF554fiJc/LelieNOD/NUHwIPk4X8koI" +
       "xwf26frAK0PX8eCWU1P2TqDSHU3K48f3egVx3XMIH+ZJOy49AJRAfjYkibU8" +
       "pjCPHTnFBuxlsOEwwvBD+2z40K2ygXnJ4Z2dkyfkCROX7jNCf7NT9Hl81ikK" +
       "Jy+Dwifyl0+B6/l9Cp+/BQoPgpvuiTJPWYa+BzSU+pLjfno2F9Od8U0vzr8v" +
       "75ULyuVzuKLnybvj0qsMLT4+6G89YslPvQyWFKEleRDEt/dZ8u1XZtAvHrka" +
       "taOkoOicD9l7hYqz49JFQG2e//eOqHReBpVFLMObAOBLu7q731dWc733nLyf" +
       "zZNNXHpQcoAQ4KauJ5GWB0UqmlqogCMyXzIg8qXIBPK9d88+mfe88mR+5Jy8" +
       "X8iTvxOXHi7IZDV9/9jH2ZR+6JWgdD+GfO+6GPKXT+lz5+R9Ik8+dozSUDqH" +
       "0mdfrkcGjO7efqTu3nWRui+f0l87J+/X8+RXTwVgHZH26VshLY1L954IO81P" +
       "Az163cHc3WFS5fMvXL70yAuzf7+LnT048HnXqHRJTxzn+EmDY/d3ABOpmwXF" +
       "d+3OHQQFGb8Vlx67cTAsWBEc3ueo935zV+vFuHTldC3gf+Q/x4t9AajnY8UA" +
       "s/bvjhf6XaDVQKH89veCA9twLF5ld+4i3S2BHj0uDMW664GXYvRhleMnzfII" +
       "2OJ89EG0arI7If2M8oUXBuOf+T7y2d1JN8WRtkVM+aVR6c7dobui0Tzi9fU3" +
       "bO2grTv6T/3gvt+5640HK6z7doCPBPMYtteefayMcIO4OAi2/SeP/P7b/tEL" +
       "Xy8Cdv4/Ng9Pyrg+AAA=");
}
