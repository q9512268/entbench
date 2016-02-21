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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "khgAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ae8zkVnX3fkk2m+duEkhCCiGPpSUM/ex5zyjQ4vF4XrbH" +
           "9szYM+O2LH7b4+f4MbanTQtUFFokitSEUgnyF6gUBYJoUStVtKmqtlSgSlSo" +
           "L6mAqkqlokhEKuGRUnrt+d7ZzZJW6ifZc319zrm/c8+5v3uv7/fMt6CbwgAq" +
           "+Z6d6bYX7atptL+y6/tR5qvh/oisM2IQqgpmi2E4A3VX5Ec+c/GFFz9oXNqD" +
           "zgvQPaLrepEYmZ4bTtTQszeqQkIXj2txW3XCCLpErsSNCMeRacOkGUaPk9Bt" +
           "J1Qj6DJ5CAEGEGAAAS4gwOixFFC6Q3VjB8s1RDcK19AvQ+dI6Lwv5/Ai6OHT" +
           "RnwxEJ0DM0zhAbBwIX/mgVOFchpADx35vvP5JQ4/VYKf/O23X/rsDdBFAbpo" +
           "utMcjgxARKARAbrdUR1JDUJUUVRFgO5yVVWZqoEp2ua2wC1Ad4em7opRHKhH" +
           "nZRXxr4aFG0e99ztcu5bEMuRFxy5p5mqrRw+3aTZog58vffY152HvbweOHir" +
           "CYAFmiirhyo3WqarRNDrz2oc+XiZAAJA9WZHjQzvqKkbXRFUQHfvYmeLrg5P" +
           "o8B0dSB6kxeDViLogWsazfvaF2VL1NUrEXT/WTlm9wpI3VJ0RK4SQa8+K1ZY" +
           "AlF64EyUTsTnW+O3fOAX3YG7V2BWVNnO8V8ASg+eUZqomhqorqzuFG9/E/kh" +
           "8d7Pv28PgoDwq88I72T+8Jeef9ubH3zuCzuZn7iKDC2tVDm6In9MuvPLr8Ue" +
           "a9+Qw7jge6GZB/+U50X6MwdvHk99MPLuPbKYv9w/fPnc5C+X7/yk+s096NYh" +
           "dF727NgBeXSX7Dm+aatBX3XVQIxUZQjdoroKVrwfQjeDMmm66q6W1rRQjYbQ" +
           "jXZRdd4rnkEXacBE3kU3g7Lpat5h2RcjoyinPgRBt4MLugtc/wnt/orfCJJh" +
           "w3NUWJRF13Q9mAm83P88oK4iwpEagrIC3voeHMauZnsJHAYy7AX60bPsBSrs" +
           "G17kuY7ow/3AVJjiiRL9/TzZ/P+fZtLc20vJuXMgEK89SwM2GEEDz1bU4Ir8" +
           "ZNzBn//0lS/uHQ2Lg36KoBpocf+gxf28xf2jFvdPtXh5V+oHXuxD584Vjb4q" +
           "R7GLPIibBRgAcOPtj01/YfSO9z1yA0g5P7kRdHouCl+borFjzhgWzCiDxIWe" +
           "+3DyLv5XkD1o7zTX5shB1a25OpMz5BETXj47xq5m9+J7v/HCsx96wjsebafI" +
           "+4AEXqqZD+JHzvZx4MmqAmjx2PybHhI/d+XzT1zeg24EzADYMBJB9gKiefBs" +
           "G6cG8+OHxJj7chNwWPMCR7TzV4dsdmtkBF5yXFME/86inGf5hTy77wHXDw/S" +
           "vfjN397j5/dX7ZIlD9oZLwrifevU/+g//M2/V4vuPuToiydmvakaPX6CF3Jj" +
           "FwsGuOs4B2aBqgK5f/4w81tPfeu9P1ckAJB49GoNXs7vGOADEELQze/5wvof" +
           "v/bVj31l7yhpoPS0bxdexjfQyE8ewwB0YoOxlifLZc51PMXUTFGy1Tw5/+vi" +
           "G8qf+48PXNqF3wY1h9nz5usbOK5/TQd65xff/t0HCzPn5Hw6O+6qY7EdR95z" +
           "bBkNAjHLcaTv+tvX/c5fiR8FbAsYLjS3akFae4Xre0DpsZdZ0gSmA4KwOZgG" +
           "4Cfu/pr1kW98akfxZ+eMM8Lq+578jR/tf+DJvRMT66MvmdtO6uwm1yJ77thF" +
           "5Efg7xy4/ju/8kjkFTtyvRs7YPiHjije91PgzsMvB6toovdvzz7xx5944r07" +
           "N+4+Pa/gYNn0qb/74Zf2P/z1v74Kid1gHqymXg3mq5OE5oApYZ9X84FcLVzY" +
           "L8QeK+4/nWM+yLX8+S357fXhSSI53fcn1nJX5A9+5dt38N/+k+cLOKcXgyfH" +
           "DWDOXefdmd8eyvvivrOsORBDA8jVnhv//CX7uReBRQFYlMEKKKQDQODpqVF2" +
           "IH3Tzf/0Z39+7zu+fAO014NutT1R6YkFYUG3AKZQQwNwf+r/7Nt2IybJh8+l" +
           "wlXoJc7vRtr9xdOtL597vXwtd0x39/+AtqV3/8v3XtIJBUtfJR3P6AvwMx95" +
           "APuZbxb6x3SZaz+YvnRSA+veY93KJ53v7D1y/i/2oJsF6JJ8sKjmRTvOSUgA" +
           "C8nwcKUNFt6n3p9eFO5WQI8fTQevPTseTjR7lqiP8xCUc+m8fOvVuPkiuL5z" +
           "wF/fOcvN56CiMCpUHi7ul/PbT51Iz2oE7ZlKXqrsqDy/vzW/EbsAvu2awcZP" +
           "Q7kbXC8cQHnhGlDY60C5SfZiN7oamskrRHMfuL57gOa710CzuA6a824xX+ZP" +
           "7TNwlq8QTj6Hfu8AzveuAefKdeDcqNlxekhI950kJNMBm4Z8gvGCMzjf8b/o" +
           "tu8f4Pz+NXAa18F5IRAVM0/r/Fk5A8h8hYDuBdcPDgD94BqAvOsAuhlMtVoc" +
           "XhWP/wrxvAZcLx7gefEaeDbXC6QLGLDAcQZMcl0whYX03DkwVCr7zX0kf37i" +
           "6s3dABLYjyXbBAuJ82GxPQdamumK9iGQ+1a2fPlwcuXBdh2Q7OWV3TxMskvF" +
           "/JDT2f5uj3sGb/XHxgv4/85jY6QHtsvv/9cPfuk3H/0aIOkRdNMmJ1DAzSda" +
           "HMf5F4Rfe+ap19325NffXyzhwKKfeXH7p2/Mrf76NbzOi+/Kb+/Ob7966OoD" +
           "uatTLw5klRTDiCqWX6py5C18wp86CJHt/R+8je5446AWDtHDPxJZipVEnlTd" +
           "GB6Icmk0wLdBPKohbG2l1j1ktVzPLGpWrtUUMrQmUV1o6Py2H1eZysiNm067" +
           "LJRKW3OzZisdz/LMLjv2pTluEwZf7i55bz2cRqiPsT2c5Iw2i62HPQOfsObc" +
           "RJmRz2YbbdyMq4GGNf0u0hRjxRGa9c0GFox2fZX5oZVlumO1ElkeCybfGI8a" +
           "jh8uLMnnxbJdSWyfU9eNLlwdKHG5Uk45HzFaiOhFPG324oh3MF/qSyMZmab0" +
           "eGkLcWrO8OkYdHIseHU2iP2lgaXzgKmUPHM9S1wpoPA+xjqmO511rao97Uth" +
           "tVlF8cbcr2Ezn0ateDZvVAXO7AqjeMVsdDMh9eoSVwxq24ywlHbs4aCBGeOK" +
           "nU6szO3VbKRntVOvQQe1kAi2HWyTpOig3LPlHl0mqjZh6rDm9qdtlV6t2FFP" +
           "zlxnLWyHQqNslJ0GHQZWr+8ifDXi7ECmLS0aTpYBhbGdLeLja9xCMGTKsiQX" +
           "BGwyqMp126k3o/KQrW1cexJNKZ0dNTaYka44f+BWHXKm97mGVxebIWo41kK1" +
           "Rw3EEIYxsRpnIsNI4qYhhbzf7XX7Bh+hY2eioxY96RI6N1pqy7VY5gVRcLHB" +
           "uG8YTX1kEbzAjcrtYWSviJCbN7qlZbROuIW0JES9oYZEEzUzR5JwRaFmZCYD" +
           "DytBtraRfn8Sted8eURve8oESxb6oL/tJL1NdTwh9NbaCbejLo9Ts5ZIkwmK" +
           "emPJ6k/gCcMTfN/jekhM1Ex8Xa6pLAqyttIlOjy9MvVMdqahp5qBjqwH4qxL" +
           "DkO1v+yRdDlE+anM6VNTJocZZgoMOrVCk9eDZR3O4i2nxWVtjdBDq7PdEjOe" +
           "nsBdE4tMrBstZ7ZDeXq30+wZC9WrSYuyT1i1IYqVKLQbJlUYJozZZh5sV01T" +
           "p7cKKi6rHDVwqOkWCR1DFVubRqnRClhSWHd5ZIoMVkbGLjhBqChNj+g40yUf" +
           "t/EqnnDjFhyXVKvdradOs6WMtFnJt90Zv/UobcxFjard4QSn7vZXlC9Uh/B6" +
           "TotVrFopIdZ426OJ1N/yVcmR04UOr/lZjwu4uGr1evRMx3ieZWRkQTbkeZ3V" +
           "nKHTkSnW0rsMwQqu25rUM61EC/3psLpWR6KNj7nFzKrYswnsTryRT1n1VKBG" +
           "ilFuYzN7XbX5ARKKgj3lVupgs1BG47I77Y/79SCe+5aSxoQ7Ejd0xZrohLLV" +
           "VrCFOXrEMIPlCk9ScuT1bdTQNz7CzwWHX/mOVIrrrd62wstaj8JSmVn0Mqrc" +
           "oeIOO5t2BwbHZTgxWNbCUsWRjNDqGWO8l6GLVbzoSLpsoAhKSLEulxiChnkm" +
           "6qmdLLV1m+iUOxWEttfjiMFbC9n1F6VQpZk+HDoMrDguxRpWknYIbRgkoY9O" +
           "5M5UiL2pleGGLYZUqmZLstcihXjacbtI2o67Oiy0eAadzJhOfdlRrBGi0Eun" +
           "i0wHyoB1Y1dOQ8YlfaTOrN0mO2ms+zI/5WvEKBapthitvVbP9qtc0GDBLJMt" +
           "a7X1cop3cGfJJbqY9VuBt5pgtDgNnGF7YtseSxOqpIqBya/6o/KGmnApvOVr" +
           "M2a83NTRVSciWYnXBnpJXo8pmB7H61pv5ZToVQMLJwQ3LW2qVVRlhtUNvA0m" +
           "60G8dGyvO54hqCw20dgadivhxBQ1QWlWmjNqiTY3sotE7Vab2RobmdygfbI8" +
           "Q9mmTGf9Mco6nS4Hw9TaUNr1Zrs0kWS5vZhO8XBeQsJQB4N7VpMsiuewQQ+x" +
           "vUZzvOj0R6LGDgXemDFZU5bLYxLeRtPReKUZ/NyMGlvYp5jWWF5IGcVsyGDT" +
           "0v10hm8xIl4Hma5suQ0YHaVp5FvuwFrCmF5phXBbYhojmq1j/XQeejjetDLS" +
           "mjJGi+KcptdRWya27DGZx5QnUSkNp3Rp4a+CqVYViCweCngnqxlcy91sm7W2" +
           "N1gY/XJACWk6UOdqP1nNA1VIErIvDmge7pKtJcPAnU59TmNIsyHFdkVsGURQ" +
           "05cTHa8165ndSELSGqWhqsI6XlJVhZ0Oe5E1pEZhox3MGRxRaVoQtrQ/4Edy" +
           "GcUpzZ8YaSqPTbxKVMTVMkAbTJV0ZEtjuuV6he6vR3y6UBudSGOkxaBZmYPM" +
           "HbitEptiIRfVN7I+dudZ0yKTQEg7ZLBd1xCYGftThI19z4e5iu9nWV9qy5sO" +
           "LhJsqGaGTpJwF2ejDqKgiUvN5h5bToQJjnSpPmF5quh2DMsZDytYkI1Rc2vI" +
           "3EZeU0yVMZJG0O8QXSXMEDx1fXG80WadamtIL8jEaBvkJl2iYgeJuaWXOoPx" +
           "3KQiZyU01swco7qKNpAWdj3gwramp2gmEzhOijFS8ZbDObtx+4bYWJfUCqNF" +
           "WQOGOQKPW3Zb9Ok6X1sDnvH1+nYUdHBvoy9Wrapci+cUhSPODB/NOWwIG2rI" +
           "UKaIulIVncQGtYnc8qZVZmbNms/Vp0ZzzYFJWPW09bppdmJ5YbTHG2kT8Fy7" +
           "VWNioVY20xQPe5IymFfpzYx1Gw2O6K24xLCxUY3QprPmNh2RMam2SI1seUNN" +
           "WrOOO0CdhZS2ywntttKq3WxbW9PPBNTJJCTt8iSf2lNN52OMl9J+IiLrqAN4" +
           "flStRGEYxGFshhMwarLKIBEwr44Nqisw2iauHsf2wlwGLJZ65rKKjdlyTCRB" +
           "MOvbFOOMiOaQJjc8IbK1dkyz8iLReUXqdMIRPo+xer1D1Pmh1IMlOpujDcnK" +
           "/FG05Up4XUPowA71kppNS0rWnzYGQmmeDbpLtywEnrTBolGLdLLBPDMnVaYn" +
           "aKw9G4ViAOywDSmBy/1IKlsVQ6B8kCySny0HC3abBHCJUGYtDySaUVnUBvWY" +
           "h6vk0h1PRb63TFymq5irjhjj9f681K83fKIx96RJqSLYUSepjLYLdknzoYgs" +
           "S81mm2YMrSu3KrZCIJSbwEzmyHVpgA67s1EZmeKl8gKJhlGyCpOVKxEIv8xk" +
           "ulEvV9Bokk/YXrsXlfQsI8ppMo3nw4GKtjliSfSUqlMPwBIA3QZ1hOz5qqb6" +
           "TmkU0020x0ZSm+5wLaNO1VGlT6gbl4Ib3mLZH0+yqbytb2mmPU6RZaUqtcfl" +
           "jVmJuXbmOKgSLFyisk7ASHJ6sjQKQ1+Pqb6/XS5rMSy5WOJvU9ZVlLqcMVhN" +
           "3y7GU57isHKCwrWRXk3wqEOhtchJzZ7ONjABMVB6gNiE6o2inrvslymanKc4" +
           "GkvZgp4ZQotDkwEZ6PVyTyVJQRpsIzAz2GXX3zJTeqEpaszMObntzPiul+qi" +
           "RumL5ixeKA2+5INlWytw7YVSrtpRdTMui7V1CYmTpNndNBCro5W4RbJIqPEm" +
           "m2QjadjYjDYTOpPB/JGRa9Wrej1XmFYIzoLt5rQZD3Wn38VL7bGtSTyCz4dx" +
           "2V/US8xq3pZceFNrIuJy4idtjTdqJaLNK8yMSDPPs2vraeyWJ50+iWFiH44H" +
           "Y61C9V2u2134ZW7MiiTCuAzDspldQiYTURa4erm86XWTuRyNNJW3PNi1ujAd" +
           "SpS00BuDFVVt0mQ5cnBcqfHzqNRP1suO2FnBpO8uRcONxmYbiaN+bTnU45aJ" +
           "M1UtwZuTijO2DB1sjN5abKyeemVbubuKXevRMS3YweUv3vMKdmvp1RsEu+qb" +
           "/cDciJF6fExQ7Nxvg86c+J3Y9Z/4zAnlH2Jfd61D2eKD9Mfe/eTTCv3x8t7B" +
           "54AG2JwfnJWftBNBt504GTvcj7/xxz1WAzDuf8kJ/u7UWf700xcv3Pc09/fF" +
           "YdLRyfAtJHRBi2375JfHE+XzfqBqZoH4lt13SL/4+T2ws742qAi65ahc+PCJ" +
           "ndYzEXTprBbYc+c/J8WeBb1wQgxE56B0UuizEXQDEMqLv+9f5cPF7jtseu50" +
           "mI7S5O7rbepPRPbRU1+wi3+kOOhcKt79K8UV+dmnR+NffL7x8d2Rl2yL221u" +
           "5QIJ3bw7fTs6WHz4mtYObZ0fPPbinZ+55Q2HuXLnDvBxop/A9vqrHzThjh8V" +
           "R0PbP7rvD97yu09/tfiO8j9Xn8qT4SIAAA==");
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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aDZAUxRXu3TvujuPgfvg7/v8OIj/egoioCHocf0f24OoO" +
       "sDyUY262925gdmac6b1bUFSMP8SqIImImghlIka0UAzRiqlEJZUKamlM/IlG" +
       "rYimUkZCrIBJTEqTmPe6Z3ZmZ3cGV9Ctmt6Z6X7d73vv9Xuve/rgh2SAZZLx" +
       "VGONbItBrcalGmuTTIsmmlXJstbAuy75rhLp7xs+WHVRlJR1kiG9ktUqSxZd" +
       "plA1YXWScYpmMUmTqbWK0gRStJnUomafxBRd6yTDFaslZaiKrLBWPUGxwTrJ" +
       "jJNaiTFT6U4z2mJ3wMi4OHAS45zEmvzVC+KkStaNLW7zek/zZk8Ntky5Y1mM" +
       "1MQ3SX1SLM0UNRZXLLYgY5KZhq5u6VF11kgzrHGTOs8Wwcr4vDwRTH6s+uNP" +
       "d/XWcBEMlTRNZxye1U4tXe2jiTipdt8uVWnKuppcR0riZJCnMSMNcWfQGAwa" +
       "g0EdtG4r4H4w1dKpZp3DYU5PZYaMDDEyKbcTQzKllN1NG+cZeqhgNnZODGgn" +
       "ZtEKlHkQ75wZ233XhprDJaS6k1QrWgeyIwMTDAbpBIHSVDc1raZEgiY6Sa0G" +
       "yu6gpiKpylZb03WW0qNJLA3qd8SCL9MGNfmYrqxAj4DNTMtMN7Pwktyg7KcB" +
       "SVXqAawjXKwC4TJ8DwArFWDMTEpgdzZJ6WZFSzAywU+RxdjwdWgApOUpynr1" +
       "7FClmgQvSJ0wEVXSemIdYHpaDzQdoIMBmoyMDuwUZW1I8maph3ahRfratYkq" +
       "aDWQCwJJGBnub8Z7Ai2N9mnJo58PV12y8xpthRYlEeA5QWUV+R8ERON9RO00" +
       "SU0K80AQVs2I75FGPLUjSgg0Hu5rLNr85NpTl80af+Q50WZMgTaruzdRmXXJ" +
       "+7uHvDy2efpFJchGhaFbCio/BzmfZW12zYKMAR5mRLZHrGx0Ko+0H73ihofp" +
       "iSipbCFlsq6mU2BHtbKeMhSVmsupRk2J0UQLGUi1RDOvbyHlcB9XNCrerk4m" +
       "LcpaSKnKX5Xp/BlElIQuUESVcK9oSd25NyTWy+8zBiGkHC6yCK5qIn78nxE5" +
       "1qunaEySJU3R9FibqSN+VKiWkGKMWnCfgFpDj1lpLanq/THLlGO62ZN9lnWT" +
       "xoxenelaSjJiy00l0cafWiWjEY3N+GqGySDaof2RCChirN8NqDCDVuhqgppd" +
       "8u704qWnHu16QZgYTgtbToycAyM22iM24oiN2REbc0YkkQgfaBiOLLQNutoM" +
       "sx7cbtX0jqtWbtwxuQTMzOgvBUFj08k54afZdQ2OP++SP1r53twV2y5+NUqi" +
       "4D26Ify4UWCiJwpg+DJ1mSbACQVFA8cjxoL9f0EeyJG7+7evu34258Hr1rHD" +
       "AeCRkLwNnXF2iAb/dC7Ub/WtH3x8aM823Z3YOXHCCW95lOgvJvvV6QffJc+Y" +
       "KD3R9dS2higpBScEjpdJMFHAp433j5HjNxY4PhixVADgpG6mJBWrHMdZyXpN" +
       "vd99w+2slt8PA9UOwolUD9cke2bxf6wdYWA5Utgl2ooPBffxCzuMvb9/6fhc" +
       "Lm4nHFR74ngHZQs8Lgg7q+POptY1vTUmpdDuD3e33XHnh7eu53YHLaYUGrAB" +
       "y2ZwPaBCEPPNz1395rF39r8WdW2VQQxOd0Mqk8mCxPekMgQkjDbN5QdcmArz" +
       "G62mYa0GVqkkFalbpTg5/lM9dc4Tf91ZI+xAhTeOGc06fQfu+1GLyQ0vbPjX" +
       "eN5NRMYQ6srMbSb88lC35ybTlLYgH5ntr4y751lpL3h48KqWspVyR1nCZVCS" +
       "O18xo+tId1sw65QUqKHPjjnntW2UdzS0/UnEk1EFCES74Qdi31r3xqYXuZIr" +
       "cF7je8Q92DNrm8wej4XVCOF/Br8IXP/DC4WOL4Tvrmu2A8jEbAQxjAxwPj0k" +
       "5csFENtWd2zzvR88IgD4I6yvMd2x+7bPGnfuFpoTaciUvEzASyNSEQEHiwuR" +
       "u0lho3CKZX8+tO1nB7bdKriqyw2qSyFnfOT1/77YePe7zxfw4CWKnUrORVPO" +
       "Ot9huboRgJZ8s/rnu+pKloHPaCEVaU25Ok1bEt4eIYuy0t0eZbnpDX/hhYaK" +
       "YSQyA3SAL+ZzLubZsPHvYs/9IoaTXZfyeMXHJRnew/m8LpZtQXgLwuviWDRY" +
       "Xt+bq2tPpt0l73rt5OB1J58+xeWVm6p7XQ3ENaGsWiymorJG+uPbCsnqhXbn" +
       "H1l1ZY165FPosRN6lCE/tVabEF4zOY7Jbj2g/K1f/HLExpdLSHQZqQTYiWUS" +
       "9/FkIDhXavVCZM4Yl14mfEt/BRQ1HCrJA4/TeUJhR7E0ZTA+tbc+OfLxSx7c" +
       "9w73aULeYzj5EEwNcsIwX965UeThV+f/7sFv7+kXlhcyj3x09Z+sVrtv/OO/" +
       "8wTMg2aBqeWj74wdvHd086ITnN6NXkg9JZOfzkB8d2nPezj1z+jksl9FSXkn" +
       "qZHt5dQ6SU1jTOiEJYTlrLFgyZVTn7scELnvgmx0Huuf255h/XHTO2VKWc70" +
       "cENlFWpwtKNc598bKiOE31zFSabxcjoWs5zIVG6YCiy5qS80DQrplJGB4DKW" +
       "QzosBDpfxGMsW7HYIPpqCzS/y3MBTICr1h6rNgBAUgDAYmM+p0HUjFT1cDbb" +
       "pYSS5nTLfMz2FMksxuk6e7i6AGZTocwGUTNSA2LtgFlM7bTYKiRdrUiGx8A1" +
       "1B5yaADDLJThIGpGolqmEIvpL4HFa7DowyG3FBry2i9hyBuyQ24tNOT2L2Dm" +
       "w+whhwUMeXOoIoKoIb/s1tNawuIk9eBovKuuFMyAxsVYr2g9i/WMD8YtRcKY" +
       "Atdwm5HhATB2hsIIomakQqaqiiEud3Mxm/zxXFOkGlcOOvqMdf/7h0VgKZRa" +
       "+rYzDjxYIb+dOspTSxzuglxYI8NgATtTg0OXh6t9P5zy0vX7przHo3iFYoGD" +
       "hyS0wAaNh+bkwWMnXhk87lG+0CrFXJa7ev/OVv7GVc5+FMdUjcWejGMG53/e" +
       "xXeDuFtu6mkjL9fjNiA6ttW7t3A0ieLtuZiHKZqkcoYuBNNUqdYjdk4WYnGP" +
       "nUDgEFFB5/ArVhUYOhubVV2juEBx6sS+gKI3ZjcPoTKTx6xJxuWkI61cRG5s" +
       "r7xl9tA4yyTzNwSwp/EBS/4Zwcr3D/DsjX8ZvWZR78YiVvsTfLbh7/Kh1oPP" +
       "L58mfyfKdx1FKpG3W5lLtCA3gag0KUubWm6WPVnolOvEna8zuNpCEuVDIXU/" +
       "wuIgWICM6hPaDmn+OLemtZ6kNCdn9zmq24t0VKPgGmHP6BEBjurJUEcVRA2O" +
       "qhecVAcscQsFhp8Wyeho2/04bqgQo8+EMhpEDZkaMooLwoKcHimS068RsTND" +
       "nP8CnB4N5TSIGtaZZr/qTPY57noE0ms5bZo4qVVd3oy71HBvQsLdTqXE5abC" +
       "aBze+4A9WySwetteHLspBOw3ocCCqCHDhqxuKSzICyngt5+fT97xeiJSF+L8" +
       "F+Dz9cLeuQRvJfDHFv9Ag0/3+ZL++pDeITtdtbq9tSnetWZF+9KOFavjS/C9" +
       "P51+o0hAS4hIjPA3NgDQsTBAWLwVBGZsQM8ghbb2ltalHZzkjizhEGxX65cC" +
       "I91na7fd2ZmJrYEgpvWotBXW6s6e/lcwipDRXVi879lUKRju33fkfyIs3AvR" +
       "86CBxfex4HH+eH6cx8f7sXggP3Dj8wGXr+NYPBISOz4KqfsHFiexOCw4CWn7" +
       "cVEx6N0Q8854gmjWovivjPg+E3lMkbcc4xECuL/peXnbclXvltRsvtbipIKY" +
       "mY4L+vbHt/7237h7X2L1A3OctPdSiAlMN85VaR9VPYNXCQ1kGee78LPhmmkz" +
       "PtM/O13R+DBn97aDSH3q8Aj8Nuw1UhGsr0glFiV834IakinyQ99GYGmfriSy" +
       "SouUns4n5WyHcXPwCYMrDZeJC21EC4sXRhBpCNawulFY1DGx0e7OZA546BkD" +
       "5tpvh6vJ5rqpeMBBpD5QpZyPUsf2x+XZfkevhCtXPFeQXQ3U5y1w11Hc/5zr" +
       "NBjpbaCkpB6KO5s67ldFzuECnBIi3JlYjIc81sLdGHyocqU74exIF5NKyxaR" +
       "Vbx0g0hDUM0LqcPEJDKb4Rdvnql4Ac85e+a03eZ6e/GAg0h9oLxLypBvBeXd" +
       "uq5SSQv0+pHFvGwKkdkKLC5hpA5cER49SDOK+4z2YtIrwYVnLMHs3uNNthhu" +
       "Oo0EC6SoQaQhENtD6tZg0crIkB5T7xehCbdufNBXnTH08Vg1Ha69Nv97Q6AX" +
       "TlIYhLctmtxr6hp4y4QvUxwZ0neIdfm9DHdDbbqisbkIfBoX0sYQASawuIKR" +
       "QT2UeQ3nHFd6nWcsPb7QwjT2uI3wePGGE0Tqw1bipuXz3YJD1ULEgH1FFFgA" +
       "ghgcwX7xnSsutk1nLDa+JzwNHEKF6EH8F+WxAklDZHFtSN11WPQzMlRSQSpL" +
       "lGQybVHc15Upt6TFLv7M2cEPky5SZYOoKh5/EGkIxh0hdbdh8Q1GRnD87TRp" +
       "f6csLIKbzp4I7O9gkbyPa6cXQRBpCMzdIXV7sLjdIwJTChHBrrOT90KiErGX" +
       "MpG87xanF0EQaQjM+0LqfoDF93y7Ki7me4vHnGFkcI5PwS/i9XnHXsVRTfnR" +
       "fdUVI/etfUPs1jvHKavipCKZVlXvR1vPfRlkCEmFC6tKfMLlRxoiDzEyOtjT" +
       "wUote4+8Rw4IqoOM1PipIHPDP2+zQxBZPM0Ynrzgd95Gh8HvQiO8/bHheN8a" +
       "dx9efMLOiKXpGFtuWXGT4acTd5bEe3gKN9H56WNnwzstzh93yYf2rVx1zakL" +
       "HhCHt2RV2so/vQ2Kk3Jxjox3ipvmkwJ7c/oqWzH90yGPDZzqrHxrBcOuxY5x" +
       "zYqsBQvlih/tO9lkNWQPOL25/5Knf72j7JUoiawnEQk88fr8j/0ZIw1L8vXx" +
       "/OMx6ySTH7laMP27WxbNSv7tbX6agoivFmOD23fJAz/ZuXWSFWmMkoEtZAAs" +
       "6mmGn0JYskVrp3KfmXPWxv4UyOUUJ0PQQiU8lcylYgtzcPYtHvxjZHL+oaP8" +
       "w5CVYDrU5B8SsZvBvk8MacPw1nKpNmNxYQalDHbWFW81DOe01e1c6obBo/9R" +
       "fFjyf4jgXpVWMAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JFQn+qgGfFmt4YlqxCnoKF0I1aRXS3Wu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "meaqnD4AAA==");
}
