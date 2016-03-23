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
           "IgAA");
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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "L/8P8UzSnsAxAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7edDsWHVff+/N8maYmfdmhlk8ZmaAeWCGNk/qVkvd7QFM" +
       "q1tSa+tWS+oV7EEtqbUvraUltcEGDIHYKaCcYbENE5cLHNs1gMtLJVUJKVJO" +
       "gl1QruByNlcCZKkKBFMFf8RxhSSOpP72971v3mOGrtJtSXf7nXPPOffcq3Nf" +
       "+G7l9jCoVH3PzjTbi66paXTNtOFrUear4TWKgTkpCFWla0thKObvnpVf+3uX" +
       "//oHH9WvXKjcsag8KLmuF0mR4bkhr4aevVEVpnL56C1mq04YVa4wprSRgDgy" +
       "bIAxwugZpvKKY1WjylXmAAKQQwByCEAJAegclcor3au6sdMtakhuFK4rP1/Z" +
       "Yyp3+HIBL6q85mQjvhRIzn4zXElB3sKl4nmSE1VWToPKqw9p39F8HcEfqwLP" +
       "feJnr/z+xcrlReWy4QoFHDkHEeWdLCr3OKqzVIOwoyiqsqjc76qqIqiBIdnG" +
       "tsS9qDwQGporRXGgHjKpeBn7alD2ecS5e+SCtiCWIy84JG9lqLZy8HT7ypa0" +
       "nNaHj2jdUYgX73MC7zZyYMFKktWDKrdZhqtElSdP1zik8SqdF8ir3umoke4d" +
       "dnWbK+UvKg/sxs6WXA0QosBwtbzo7V6c9xJVHrthowWvfUm2JE19Nqo8eroc" +
       "t8vKS91VMqKoElUeOl2sbCkfpcdOjdKx8fnu4M0f/jm3714oMSuqbBf4L+WV" +
       "njhViVdXaqC6srqreM8bmY9LD3/xQxcqlbzwQ6cK78r8o3d9/20/+cSX/mRX" +
       "5sfPKDNcmqocPSt/Znnf117Vfbp9sYBxyfdCoxj8E5SX4s/t5zyT+rnmPXzY" +
       "YpF57SDzS/y/mr/nd9XvXKjcTVbukD07dnI5ul/2HN+w1YBQXTWQIlUhK3ep" +
       "rtIt88nKnfk9Y7jq7u1wtQrViKzcZpev7vDK55xFq7yJgkV35veGu/IO7n0p" +
       "0sv71K9UKnfmV+Wt+XW5svuV/1FFBHTPUQHfALjAK0gPAdWNljlbdSCM3ZXt" +
       "JUAYyIAXaIfPshfkNXQv8lxH8gEiMBSufGIl/1ohXf6PqN20oOdKsreXs/pV" +
       "pxXdznWk79mKGjwrPxej2Pc//+xXLhwK/j4nosob8h6v7fd4rejx2mGP1070" +
       "WNnbKzt6ZdHzbjzz0bByvc4t3j1PCz9DvfNDr72YC5Kf3JazsigK3Njwdo8s" +
       "AVnaOzkXx8qXPpm8d/IL4IXKhZMWtECbv7q7qM4Vdu/Qvl09rTlntXv5g9/6" +
       "6y98/N3ekQ6dMMn7qn19zUI1X3uar4Enq0pu7I6af+OrpT969ovvvnqhcluu" +
       "77mNi6RcJnPz8cTpPk6o6DMH5q6g5fac4JUXOJJdZB3YqLsjPfCSozflgN9X" +
       "3t+f8/gVhcw+ml+v2Rfi8r/IfdAv0lfuBKQYtFNUlOb0LYL/6X//Z9+GSnYf" +
       "WN7Lx+YyQY2eOabtRWOXS72+/0gGxEBV83L/6ZPc3//Ydz/49lIA8hJPndXh" +
       "1SLt5lqeD2HO5g/8yfo/fOPrn/mLC0dCE+XTXby0DTk9JLJ4X7n7HCLz3l5/" +
       "hCe3FnauXoXUXB27jqcYK0Na2mohpf/n8utqf/RXH76ykwM7f3MgRj/54g0c" +
       "vf8xtPKer/zs/3qibGZPLmarI54dFduZwAePWu4EgZQVONL3/vnjv/pl6dO5" +
       "Mc0NWGhs1dImXSx5cDGv9PQ5HktgOPlobPatPPDuB75hfepbn9tZ8NNTwqnC" +
       "6oee+6W/vfbh5y4cmzefum7qOl5nN3eWYnTvbkT+Nv/t5df/K65iJIoXO9v5" +
       "QHffgL/60IL7fpqT85rzYJVd4P/9C+/+J7/97g/uyHjg5LSB5V7R5/7t//3q" +
       "tU9+80/PsGAXc5egeIBKgGCRNHbig0SFWHtSVBIAlO/eWKbXCsQluytl3luL" +
       "5MnwuD05yfljjtqz8kf/4nv3Tr73z75fgjnp6R1Xn9xo7lh3X5G8uuDEI6eN" +
       "Z18K9bxc40uDd1yxv/SDvMVF3qKcuzfhMMhtd3pC2fZL337nX/7zP374nV+7" +
       "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" +
       "8JmAR3rd0KCan8ptSadTr4lKWEOTh3V6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "9qNnKZw+AAA=");
}
