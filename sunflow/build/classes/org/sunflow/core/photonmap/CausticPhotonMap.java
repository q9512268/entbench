package org.sunflow.core.photonmap;
public final class CausticPhotonMap implements org.sunflow.core.CausticPhotonMapInterface {
    private java.util.ArrayList<org.sunflow.core.photonmap.CausticPhotonMap.Photon>
      photonList;
    private org.sunflow.core.photonmap.CausticPhotonMap.Photon[] photons;
    private int storedPhotons;
    private int halfStoredPhotons;
    private int log2n;
    private int gatherNum;
    private float gatherRadius;
    private org.sunflow.math.BoundingBox bounds;
    private float filterValue;
    private float maxPower;
    private float maxRadius;
    private int numEmit;
    public CausticPhotonMap(org.sunflow.core.Options options) { super(
                                                                  );
                                                                numEmit =
                                                                  options.
                                                                    getInt(
                                                                      "caustics.emit",
                                                                      10000);
                                                                gatherNum =
                                                                  options.
                                                                    getInt(
                                                                      "caustics.gather",
                                                                      50);
                                                                gatherRadius =
                                                                  options.
                                                                    getFloat(
                                                                      "caustics.radius",
                                                                      0.5F);
                                                                filterValue =
                                                                  options.
                                                                    getFloat(
                                                                      "caustics.filter",
                                                                      1.1F);
                                                                bounds =
                                                                  new org.sunflow.math.BoundingBox(
                                                                    );
                                                                maxPower =
                                                                  0;
                                                                maxRadius =
                                                                  0;
    }
    public void prepare(org.sunflow.math.BoundingBox sceneBounds) {
        photonList =
          new java.util.ArrayList<org.sunflow.core.photonmap.CausticPhotonMap.Photon>(
            );
        photonList.
          add(
            null);
        photons =
          null;
        storedPhotons =
          (halfStoredPhotons =
             0);
    }
    private void locatePhotons(org.sunflow.core.photonmap.CausticPhotonMap.NearestPhotons np) {
        float[] dist1d2 =
          new float[log2n];
        int[] chosen =
          new int[log2n];
        int i =
          1;
        int level =
          0;
        int cameFrom;
        while (true) {
            while (i <
                     halfStoredPhotons) {
                float dist1d =
                  photons[i].
                  getDist1(
                    np.
                      px,
                    np.
                      py,
                    np.
                      pz);
                dist1d2[level] =
                  dist1d *
                    dist1d;
                i +=
                  i;
                if (dist1d >
                      0.0F)
                    i++;
                chosen[level++] =
                  i;
            }
            np.
              checkAddNearest(
                photons[i]);
            do  {
                cameFrom =
                  i;
                i >>=
                  1;
                level--;
                if (i ==
                      0)
                    return;
            }while(dist1d2[level] >=
                     np.
                       dist2[0] ||
                     cameFrom !=
                     chosen[level]); 
            np.
              checkAddNearest(
                photons[i]);
            i =
              chosen[level++] ^
                1;
        }
    }
    private void balance() { if (storedPhotons ==
                                   0) return;
                             photons = photonList.
                                         toArray(
                                           new org.sunflow.core.photonmap.CausticPhotonMap.Photon[photonList.
                                                                                                    size(
                                                                                                      )]);
                             photonList =
                               null;
                             org.sunflow.core.photonmap.CausticPhotonMap.Photon[] temp =
                               new org.sunflow.core.photonmap.CausticPhotonMap.Photon[storedPhotons +
                                                                                        1];
                             balanceSegment(
                               temp,
                               1,
                               1,
                               storedPhotons);
                             photons = temp;
                             halfStoredPhotons =
                               storedPhotons /
                                 2;
                             log2n = (int)
                                       java.lang.Math.
                                       ceil(
                                         java.lang.Math.
                                           log(
                                             storedPhotons) /
                                           java.lang.Math.
                                           log(
                                             2.0));
    }
    private void balanceSegment(org.sunflow.core.photonmap.CausticPhotonMap.Photon[] temp,
                                int index,
                                int start,
                                int end) {
        int median =
          1;
        while (4 *
                 median <=
                 end -
                 start +
                 1)
            median +=
              median;
        if (3 *
              median <=
              end -
              start +
              1) {
            median +=
              median;
            median +=
              start -
                1;
        }
        else
            median =
              end -
                median +
                1;
        int axis =
          org.sunflow.core.photonmap.CausticPhotonMap.Photon.
            SPLIT_Z;
        org.sunflow.math.Vector3 extents =
          bounds.
          getExtents(
            );
        if (extents.
              x >
              extents.
                y &&
              extents.
                x >
              extents.
                z)
            axis =
              org.sunflow.core.photonmap.CausticPhotonMap.Photon.
                SPLIT_X;
        else
            if (extents.
                  y >
                  extents.
                    z)
                axis =
                  org.sunflow.core.photonmap.CausticPhotonMap.Photon.
                    SPLIT_Y;
        int left =
          start;
        int right =
          end;
        while (right >
                 left) {
            double v =
              photons[right].
              getCoord(
                axis);
            int i =
              left -
              1;
            int j =
              right;
            while (true) {
                while (photons[++i].
                         getCoord(
                           axis) <
                         v) {
                    
                }
                while (photons[--j].
                         getCoord(
                           axis) >
                         v &&
                         j >
                         left) {
                    
                }
                if (i >=
                      j)
                    break;
                swap(
                  i,
                  j);
            }
            swap(
              i,
              right);
            if (i >=
                  median)
                right =
                  i -
                    1;
            if (i <=
                  median)
                left =
                  i +
                    1;
        }
        temp[index] =
          photons[median];
        temp[index].
          setSplitAxis(
            axis);
        if (median >
              start) {
            if (start <
                  median -
                  1) {
                float tmp;
                switch (axis) {
                    case org.sunflow.core.photonmap.CausticPhotonMap.Photon.
                           SPLIT_X:
                        tmp =
                          bounds.
                            getMaximum(
                              ).
                            x;
                        bounds.
                          getMaximum(
                            ).
                          x =
                          temp[index].
                            x;
                        balanceSegment(
                          temp,
                          2 *
                            index,
                          start,
                          median -
                            1);
                        bounds.
                          getMaximum(
                            ).
                          x =
                          tmp;
                        break;
                    case org.sunflow.core.photonmap.CausticPhotonMap.Photon.
                           SPLIT_Y:
                        tmp =
                          bounds.
                            getMaximum(
                              ).
                            y;
                        bounds.
                          getMaximum(
                            ).
                          y =
                          temp[index].
                            y;
                        balanceSegment(
                          temp,
                          2 *
                            index,
                          start,
                          median -
                            1);
                        bounds.
                          getMaximum(
                            ).
                          y =
                          tmp;
                        break;
                    default:
                        tmp =
                          bounds.
                            getMaximum(
                              ).
                            z;
                        bounds.
                          getMaximum(
                            ).
                          z =
                          temp[index].
                            z;
                        balanceSegment(
                          temp,
                          2 *
                            index,
                          start,
                          median -
                            1);
                        bounds.
                          getMaximum(
                            ).
                          z =
                          tmp;
                }
            }
            else
                temp[2 *
                       index] =
                  photons[start];
        }
        if (median <
              end) {
            if (median +
                  1 <
                  end) {
                float tmp;
                switch (axis) {
                    case org.sunflow.core.photonmap.CausticPhotonMap.Photon.
                           SPLIT_X:
                        tmp =
                          bounds.
                            getMinimum(
                              ).
                            x;
                        bounds.
                          getMinimum(
                            ).
                          x =
                          temp[index].
                            x;
                        balanceSegment(
                          temp,
                          2 *
                            index +
                            1,
                          median +
                            1,
                          end);
                        bounds.
                          getMinimum(
                            ).
                          x =
                          tmp;
                        break;
                    case org.sunflow.core.photonmap.CausticPhotonMap.Photon.
                           SPLIT_Y:
                        tmp =
                          bounds.
                            getMinimum(
                              ).
                            y;
                        bounds.
                          getMinimum(
                            ).
                          y =
                          temp[index].
                            y;
                        balanceSegment(
                          temp,
                          2 *
                            index +
                            1,
                          median +
                            1,
                          end);
                        bounds.
                          getMinimum(
                            ).
                          y =
                          tmp;
                        break;
                    default:
                        tmp =
                          bounds.
                            getMinimum(
                              ).
                            z;
                        bounds.
                          getMinimum(
                            ).
                          z =
                          temp[index].
                            z;
                        balanceSegment(
                          temp,
                          2 *
                            index +
                            1,
                          median +
                            1,
                          end);
                        bounds.
                          getMinimum(
                            ).
                          z =
                          tmp;
                }
            }
            else
                temp[2 *
                       index +
                       1] =
                  photons[end];
        }
    }
    private void swap(int i, int j) { org.sunflow.core.photonmap.CausticPhotonMap.Photon tmp =
                                        photons[i];
                                      photons[i] =
                                        photons[j];
                                      photons[j] =
                                        tmp;
    }
    public void store(org.sunflow.core.ShadingState state,
                      org.sunflow.math.Vector3 dir,
                      org.sunflow.image.Color power,
                      org.sunflow.image.Color diffuse) {
        if (state.
              getDiffuseDepth(
                ) ==
              0 &&
              (state.
                 getReflectionDepth(
                   ) >
                 0 ||
                 state.
                 getRefractionDepth(
                   ) >
                 0)) {
            org.sunflow.core.photonmap.CausticPhotonMap.Photon p =
              new org.sunflow.core.photonmap.CausticPhotonMap.Photon(
              state.
                getPoint(
                  ),
              dir,
              power);
            synchronized (this)  {
                storedPhotons++;
                photonList.
                  add(
                    p);
                bounds.
                  include(
                    new org.sunflow.math.Point3(
                      p.
                        x,
                      p.
                        y,
                      p.
                        z));
                maxPower =
                  java.lang.Math.
                    max(
                      maxPower,
                      power.
                        getMax(
                          ));
            }
        }
    }
    public void init() { org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "Balancing caustics photon map ...");
                         org.sunflow.system.Timer t =
                           new org.sunflow.system.Timer(
                           );
                         t.start();
                         balance();
                         t.end();
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "Caustic photon map:");
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Photons stored:   %d",
                             storedPhotons);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Photons/estimate: %d",
                             gatherNum);
                         maxRadius = 1.4F *
                                       (float)
                                         java.lang.Math.
                                         sqrt(
                                           maxPower *
                                             gatherNum);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Estimate radius:  %.3f",
                             gatherRadius);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Maximum radius:   %.3f",
                             maxRadius);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Balancing time:   %s",
                             t.
                               toString(
                                 ));
                         if (gatherRadius >
                               maxRadius)
                             gatherRadius =
                               maxRadius;
    }
    public void getSamples(org.sunflow.core.ShadingState state) {
        if (storedPhotons ==
              0)
            return;
        org.sunflow.core.photonmap.CausticPhotonMap.NearestPhotons np =
          new org.sunflow.core.photonmap.CausticPhotonMap.NearestPhotons(
          state.
            getPoint(
              ),
          gatherNum,
          gatherRadius *
            gatherRadius);
        locatePhotons(
          np);
        if (np.
              found <
              8)
            return;
        org.sunflow.math.Point3 ppos =
          new org.sunflow.math.Point3(
          );
        org.sunflow.math.Vector3 pdir =
          new org.sunflow.math.Vector3(
          );
        org.sunflow.math.Vector3 pvec =
          new org.sunflow.math.Vector3(
          );
        float invArea =
          1.0F /
          ((float)
             java.lang.Math.
               PI *
             np.
               dist2[0]);
        float maxNDist =
          np.
            dist2[0] *
          0.05F;
        float f2r2 =
          1.0F /
          (filterValue *
             filterValue *
             np.
               dist2[0]);
        float fInv =
          1.0F /
          (1.0F -
             2.0F /
             (3.0F *
                filterValue));
        for (int i =
               1;
             i <=
               np.
                 found;
             i++) {
            org.sunflow.core.photonmap.CausticPhotonMap.Photon phot =
              np.
                index[i];
            org.sunflow.math.Vector3.
              decode(
                phot.
                  dir,
                pdir);
            float cos =
              -org.sunflow.math.Vector3.
              dot(
                pdir,
                state.
                  getNormal(
                    ));
            if (cos >
                  0.001) {
                ppos.
                  set(
                    phot.
                      x,
                    phot.
                      y,
                    phot.
                      z);
                org.sunflow.math.Point3.
                  sub(
                    ppos,
                    state.
                      getPoint(
                        ),
                    pvec);
                float pcos =
                  org.sunflow.math.Vector3.
                  dot(
                    pvec,
                    state.
                      getNormal(
                        ));
                if (pcos <
                      maxNDist &&
                      pcos >
                      -maxNDist) {
                    org.sunflow.core.LightSample sample =
                      new org.sunflow.core.LightSample(
                      );
                    sample.
                      setShadowRay(
                        new org.sunflow.core.Ray(
                          state.
                            getPoint(
                              ),
                          pdir.
                            negate(
                              )));
                    sample.
                      setRadiance(
                        new org.sunflow.image.Color(
                          ).
                          setRGBE(
                            np.
                              index[i].
                              power).
                          mul(
                            invArea /
                              cos),
                        org.sunflow.image.Color.
                          BLACK);
                    sample.
                      getDiffuseRadiance(
                        ).
                      mul(
                        (1.0F -
                           (float)
                             java.lang.Math.
                             sqrt(
                               np.
                                 dist2[i] *
                                 f2r2)) *
                          fInv);
                    state.
                      addSample(
                        sample);
                }
            }
        }
    }
    private static class NearestPhotons {
        int found;
        float px;
        float py;
        float pz;
        private int max;
        private boolean gotHeap;
        protected float[] dist2;
        protected org.sunflow.core.photonmap.CausticPhotonMap.Photon[]
          index;
        NearestPhotons(org.sunflow.math.Point3 p,
                       int n,
                       float maxDist2) { super(
                                           );
                                         max =
                                           n;
                                         found =
                                           0;
                                         gotHeap =
                                           false;
                                         px =
                                           p.
                                             x;
                                         py =
                                           p.
                                             y;
                                         pz =
                                           p.
                                             z;
                                         dist2 =
                                           (new float[n +
                                                        1]);
                                         index =
                                           (new org.sunflow.core.photonmap.CausticPhotonMap.Photon[n +
                                                                                                     1]);
                                         dist2[0] =
                                           maxDist2;
        }
        void reset(org.sunflow.math.Point3 p,
                   float maxDist2) { found =
                                       0;
                                     gotHeap =
                                       false;
                                     px =
                                       p.
                                         x;
                                     py =
                                       p.
                                         y;
                                     pz =
                                       p.
                                         z;
                                     dist2[0] =
                                       maxDist2;
        }
        void checkAddNearest(org.sunflow.core.photonmap.CausticPhotonMap.Photon p) {
            float fdist2 =
              p.
              getDist2(
                px,
                py,
                pz);
            if (fdist2 <
                  dist2[0]) {
                if (found <
                      max) {
                    found++;
                    dist2[found] =
                      fdist2;
                    index[found] =
                      p;
                }
                else {
                    int j;
                    int parent;
                    if (!gotHeap) {
                        float dst2;
                        org.sunflow.core.photonmap.CausticPhotonMap.Photon phot;
                        int halfFound =
                          found >>
                          1;
                        for (int k =
                               halfFound;
                             k >=
                               1;
                             k--) {
                            parent =
                              k;
                            phot =
                              index[k];
                            dst2 =
                              dist2[k];
                            while (parent <=
                                     halfFound) {
                                j =
                                  parent +
                                    parent;
                                if (j <
                                      found &&
                                      dist2[j] <
                                      dist2[j +
                                              1])
                                    j++;
                                if (dst2 >=
                                      dist2[j])
                                    break;
                                dist2[parent] =
                                  dist2[j];
                                index[parent] =
                                  index[j];
                                parent =
                                  j;
                            }
                            dist2[parent] =
                              dst2;
                            index[parent] =
                              phot;
                        }
                        gotHeap =
                          true;
                    }
                    parent =
                      1;
                    j =
                      2;
                    while (j <=
                             found) {
                        if (j <
                              found &&
                              dist2[j] <
                              dist2[j +
                                      1])
                            j++;
                        if (fdist2 >
                              dist2[j])
                            break;
                        dist2[parent] =
                          dist2[j];
                        index[parent] =
                          index[j];
                        parent =
                          j;
                        j +=
                          j;
                    }
                    dist2[parent] =
                      fdist2;
                    index[parent] =
                      p;
                    dist2[0] =
                      dist2[1];
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALV6Cez71n0f/7//acfx/28nPurFjh3/k81R9qdIUSI1N20k" +
           "USKpg6REipLYrA5FPh4SL/EQKaVemuxIsAxZsDlthjXGgKU7AjcpihYLMHTw" +
           "sKMtWhRoF2xZsTVdN6DtsgDxgHZpnKR7lH73/3C8LgL49Pj4ju/5ed93vPIN" +
           "5HIcIaUwcDeWGyS3QJ7cWrjVW8kmBPGtbr8qalEMjJarxbEMy17Q3/Xz1//k" +
           "9U/bNw6QKyryNs33g0RLnMCPRyAO3DUw+sj1k9K2C7w4QW70F9paQ9PEcdG+" +
           "EyfP95G3nGqaIDf7RySgkAQUkoDuSEAbJ7Vgo7cCP/VaRQvNT+IV8teQC33k" +
           "SqgX5CXIM2c7CbVI8w67EXccwB6uFe8KZGrXOI+Qp4953/N8G8OfKaEv/fSP" +
           "3/iFi8h1Fbnu+FJBjg6JSOAgKvKAB7w5iOKGYQBDRR7yATAkEDma62x3dKvI" +
           "w7Fj+VqSRuBYSEVhGoJoN+aJ5B7QC96iVE+C6Jg90wGucfR22XQ1C/L66Amv" +
           "ew47RTlk8H4HEhaZmg6OmlxaOr6RIO883+KYx5s9WAE2veqBxA6Oh7rka7AA" +
           "eXivO1fzLVRKIse3YNXLQQpHSZAn7tppIetQ05eaBV5IkMfP1xP3n2Ct+3aC" +
           "KJokyCPnq+16glp64pyWTunnG/wPf+rDPusf7Gg2gO4W9F+DjZ4612gETBAB" +
           "Xwf7hg+8t/9T2qO//IkDBIGVHzlXeV/nX/zEax9431Ov/uq+zl+4Qx1hvgB6" +
           "8oL++fmDv/WO1nP1iwUZ18Igdgrln+F8Z/7i4Zfn8xB63qPHPRYfbx19fHX0" +
           "72c/+QXw9QPkfg65ogdu6kE7ekgPvNBxQcQAH0RaAgwOuQ/4Rmv3nUOuwnzf" +
           "8cG+VDDNGCQccsndFV0Jdu9QRCbsohDRVZh3fDM4yodaYu/yeYggyNvggzwO" +
           "n28h+9/uP0E+iNqBB1BN13zHD1AxCgr+YxT4yRzK1kbj1DfdIEPjSEeDyDp+" +
           "14MIoKEdJIHvaSHa0tIY+pG4Kxho4a3CysIfcP95wd+N7MIFKPp3nHd8F/oM" +
           "G7gGiF7QX0qb7de++MKvHxw7wqFkEuSvwEFvHQ56qxj01vGgt84PepMHGvT6" +
           "ZF8QIxcu7IZ+e0HLXuNQX0vo+RATH3hO+qvdD33iXRehqYXZJSjsoip6d2hu" +
           "nWAFt0NEHRos8upns48qHykfIAdnMbagHxbdXzQXC2Q8RsCb533rTv1e//gf" +
           "/smXfurF4MTLzoD2ofPf3rJw3nedl3QU6MCAcHjS/Xuf1n7phV9+8eYBcgki" +
           "AkTBRINWCwHmqfNjnHHi548AseDlMmTYDCJPc4tPRyh2f2JHQXZSsjOBB3f5" +
           "h6CMrxVW/SiU9aGV7/+Lr28Li/Tte5MplHaOix3gvl8KP/fV3/yjyk7cR9h8" +
           "/dRsJ4Hk+VN4UHR2fef5D53YgBwBAOv918+Kf/8z3/j4j+0MANZ49k4D3izS" +
           "FsQBqEIo5r/5q6v//LXf/fxXDo6NBsnP8nbtHrzBQd5zQgaEERe6WmEsN8e+" +
           "FxiO6WhzFxTG+Z3r78Z+6X996sZe/S4sObKe971xByflP9REfvLXf/z/PLXr" +
           "5oJeTGMnojqptsfGt5303IgibVPQkX/0t5/8B7+ifQ6iLES22NmCHVhd3LF+" +
           "ccf5Iwny2GkX9SCsQWCF02IFdvrcPUKdyPGgktaH0wP64sNfW/7MH/7cHvrP" +
           "zyXnKoNPvPS3/+zWp146ODXhPnvbnHe6zX7S3VnXW/ca+zP4uwCf7xVPoami" +
           "YA+6D7cOkf/pY+gPwxyy88y9yNoN0fmDL734L//Zix/fs/Hw2fmmDcOpn/uP" +
           "3/2NW5/9vV+7A9RddA6jLKxIqnvLIpPC0AMt2dF+a1f23C79ywWxh0ZYvP9o" +
           "kbwzPo0wZ4V+Krh7Qf/0V775VuWb/+q1HR1no8PTDgVRdS+1B4vk6UIIj52H" +
           "U1aLbViPeJX/4A331ddhjyrsUYchUSxEEN/zM+53WPvy1d/51//m0Q/91kXk" +
           "oIPcDxk0OtoOyZD7IISA2IZTQx7+6Af2vpQVznVjxypyG/N7QT2+e3vLvY2u" +
           "UwR3Jzj4+LcFd/6x3//WbULYwfcd7PBcexV95WeeaP3I13ftT3C0aP1Ufvuc" +
           "BwPhk7b4F7w/PnjXlX93gFxVkRv6YZStaG5aoJMKI8v4KPSGkfiZ72ejxH1I" +
           "9PzxPPGO845watjzCH5igDBf1C7y998JtB+Gz58eItufngftC8guM9g1eWaX" +
           "3iySv3jKPKuFIQepbxQvxB7mi/QDRcLvddi6q77Zs9T8EHy+fUjNt+9CjfwG" +
           "1ByEu9zz50gZ/wBI+bE3JGVzJ1I++AMgZf6GpGzvRIr+/ZOyKy1C2dcPSXn9" +
           "LqQ4dyblQoJcDSNnDWH3iKiL3j6WPG82izdJ1dPw+c4hVd+5C1Wru1BVZL0j" +
           "gq5aQcICLbwTXF+dB4ELNP8crdH3T+vDR7R+95DW796F1g/fVYL3hVGQQFgA" +
           "xrHzGXBCxyE8vvvu8Lib+PdT7Mv/5Nnf/MjLz/63HZpfc2IIIo3IusPa8FSb" +
           "b77yta//9luf/OIurLw01+I9nJxfVN++Zj6zFN4R/MCxMB4oeIeZgy/vZbH/" +
           "T5Dhn2/lUuw7RKjU2m1AREfLof//ne4x5njOunC41NgpvEj+xpEuP3FnXR4k" +
           "yJUwnbuOXuCn42vukUKvuMC39mvInV/89TA/HuZg3/YoQtvHdsVsAZfygQ+K" +
           "MPHo23515AS3jrdR4Mf8NoIj5L13t5vBTn0nc9uvfOx/PiH/iP2hN7Eseuc5" +
           "szrf5T8fvPJrzHv0v3eAXDye6W7bYznb6Pmz89v9EUjSyJfPzHJP7nWwk989" +
           "HP+Te6HfI/r6h/f49rki+WmoP70Q/l5X96j+j3LkHHb8xJvEjmfg871D7Pje" +
           "XbDjH9+D3Y8cgwYMaQ+N4aNnPbIY5+2HQ7z9/BBHtoW/mcX7PheG4XnuP/+G" +
           "3O8B+ALEvcv4LfJWuXj/4p35u7hTJ/SeeLexWLz9nSNuH1u4+s2j2F8BUQxN" +
           "9ubCJY/YuXHiRvutuXOEVr9vQqE7PXjSWT/wrec/+T8+/Rt/99mvQbztIpfX" +
           "RZgHveLUiHxabHz+rVc+8+RbXvq9T+5WoFBb0uXXvrqDgC/fi90i+YUzrD5R" +
           "sCoFaaSDvhYng93qERjH3J6b0y5Bw/1/5za58ZdYIuYaR7/+WG3hmZ5PFcqw" +
           "t6xu5n2/IclmdWOZbDhthFJrXLadWdovkx07d3o2resqqaNzBpDrPhnmdXo1" +
           "aoStIGy77V5D4cb9zpi3xzN7OLTbq6zLO1TIjlvDVl9ptJNOQ8FtSVkJ43mL" +
           "xdbq2sR1Up9W6JlfMbY6ya6367UIPBKwlY0uz7n1YCavRApjZNxkMCEteW6M" +
           "SfPRCiPHeIatTF0Zk6gBMHKqmm2JGa9XI3xprIzW3NDSgYO59WpfXXnV7cpZ" +
           "D0iPi+3RwuhEgsqPN1Utdeph28OEbQ+aWrAityOJbrTx8SbpMs7Cd5OVWdW2" +
           "ND5ryfjYt7qtNiFpmSDiVX5pR51BW69T3WWJoudmm5AHoD+K5XQl4yUrkydS" +
           "deVMpFWMzfVcVVU70mpc06PoRZ8yLZyUumwTpHInnwSzAUMbo5KBL5JZHxtm" +
           "LljVsplC1Jeqx9SDTNooXX8Oaoo3UEvbaCMqPdDt8vWsuyl3O7jTklpao9dL" +
           "kyYx1ulSp2a4A2/DtglQFVxNa9FseyOSTleScE2fz8POYkvT7lRfKmXLIuUt" +
           "lXR7vWHSXjO8OkvqBlafoUqbXIGlZ6zWuiVkQZbNOlx/44xVc6WqWl0IFWfl" +
           "buVgJmRAXbnjMamTrlcrY0PGoJzNrIKN+31P5VXLgxEY2Vg4rbmrTIgZmHak" +
           "LGX1dZWXmKTcYCSDjJer7mTLGqNWNrGmTEQPO+sKP+wF6ljUp90K3WSmsTaZ" +
           "Z4NG0CYHA7oaVNuuUmsOJ1KPL7dnlVWDWAKdxuqNdsNnhFaj45j8Uk2daImv" +
           "aL7dxAIdMLN+5AZUQwu7w2avm5XtIdPepk1XDWll3VerKJ660zTF6mY4UDhG" +
           "7IFZ4LDoMuuEsmWHXDneOlS7uuQsTKrylXLqiSRBjBpxk+cmjS5Vsvgupid+" +
           "RYyZobud28yMNitzb9AnXU6sJxIqaG6ykWRvM56Mi40shi5bqex6Fao2xNRy" +
           "r+2ppNkeoUxlZrL8gsR8NRbi0SAfJ1izZyv0Bp83Fnkw5nBhxURCqtKrbY8B" +
           "Ib3odWvaEqfmG1rmRtVxMlGnPD6Uk3RgVBs9WcoVJuXQVcviJ7VWb+Uxac3z" +
           "aV9NxzQRVreO1Ja58dob+qZMLCinUxei5XLA2N4kaESKYmCc0YmZjUf5nNAv" +
           "WzjBtivqRMbXjDTo4S43smkgoz1i3mmnmpUNy/UhhbUZqqLpXK2WjzmfB2Kg" +
           "AlWtLEostSwbPSmmMZ3qsZWM38ZZbViO81UZVV0M39ZTabROwXJc6jR1WqY3" +
           "mtLgBWK4kMQR6FYDsb0ph7NkJIiK3k+cZdTeDP1AoyQupdezuVVti0Gk+BJV" +
           "r2CTir7uNYzpoKyvhvySS53W0EpWFCXQTJ0mXU0QxqQpmqKIdpmeyy2X2opq" +
           "bZVBT4gTa2YpjktvfSivmbmsChMOzAnd0n1+YEsTy24orpTqU201mE3mtuCY" +
           "skmnBDPciprD1cxcdv18Oxcr/W3VTlHWEfJZJ2ws7YEVOJ0an823Jt9MWzNA" +
           "z9brCTmN1kGNr5CLFpU1aW6AV2v9QbPNjLS2Lwmxv6i6NXlbk3h0IWCrNu4Y" +
           "TUKYjWk7aue0azMBQ5RLEaN3JbdljQQG0xhtveCwaRtjSWnQntQ7gMFpr03R" +
           "SW3RsraWURkMqp7ITf0yUdHVzF6PtvV+S+psmqxZW7BrYE46a6xsYQLuLbeh" +
           "yRo0DXrx2hY63kLqzvipnaaU69ACDXC+Xi/llTVZDxyzObM69myBc90FQwzT" +
           "QYsJSuZanIqmNsEpYNLepF4RpBYVThRo0Vy/P5tlA8fP5qOGirtVKTAqnS6/" +
           "IkfmrOIAcVWfGyKxQOu23KfwdTaLIlFfi2uOqZgxoekJv8UqBDXCczn0aK+u" +
           "yK6lu5mYTOdgrrhlhV1yFXNLGUsUhBGAmNG0IiaZe7qzDmf9sp52qjSUBYCu" +
           "b3tc3m30uS5vthtZEwzyWrwuD8etDGvUZ6rh9lUnrSWbtDYhI5TjWUVoD4dd" +
           "rDJCiWTOR3hOThOn1LIGrcgZ9MeVLcsOe+wWZVfhlCnZbQrOWOiiQ+Ct1pZz" +
           "+f6sCiYuEBeMqloEMcV6ztLKekt+MSrx86Fl6mDZ6LXbFZ3zhAowqHRKyRUy" +
           "ZBTXmEOEHtAZQVm9EbGis9oUsplLSmPElMiENdDtBrVxstsBfKZs6p1lNGqi" +
           "ZJabYo5O67Vk6Wi9DjBa63HLEHhK7FKThCuPa1xgYjSOJyRDseNut1nze7U0" +
           "xCaGNqJSistVzyBNXd3UUi3nuiZPDwddXOmXhxqhR+3FwKzF9QE21eVtqelg" +
           "Vhst4VVKmnSI0HfkrK0PiRhN0dZMZZMFpTYHaLKqb6suScWmzPtUNhr4trZq" +
           "5XMKLbVpyWXVVca0c9xzGaGTpgE6s7IORkAY1EBamfUMJ+9U1HEg9DAec4Zr" +
           "X2iOBaUhVxdEjlGoMK1ETmm8xJa11RDkYyFXRn5509IH63ioLyjBFDeK3E8X" +
           "TMNa2QDKv2/DwbPagEpYV56oyyzNYhr3qToBBKU+w0u9WDBmVXfTnBJwXmvR" +
           "vLNJly6+FNZTOSdLKEmo5QX0nD7bC4aVeCvy3qIu1NFS2KZdLmpPhAlczPJk" +
           "mxiK/FwFRlu0gb0UY9fN7cZQUawAkIRLe1ndaW0SlNkMRmC8ogiFnPPKIHEq" +
           "qdPRiCippKI1sQ2CjfLNRlzVeBVtqsRYTIN6LPTN2rZMdejqRhnTYWILJV+O" +
           "ySrfzYUN4czmzXFQLTFZ1Grao0l/wcnCBlgROm1x8oAg5nqPlmhZZYCLrZcD" +
           "okqJlUFg8mqzq9NdOLtl6WypWqt61EhzgbUmk+bQtWfBckSkI35AtCQ5EXU/" +
           "zpfrTbTMpQi0qFpVbVCdcUea+9DbuqZD0WN1Knuq1olWA0bujnlXVvCuDLWj" +
           "gmncLdXpAMKN2ayjIiutzBHZLMUlg8Zyc8NwY96yyjOziS+qoS9t41Epqzdm" +
           "2Cz2/bDVEMhSzeLw1OpQRJ8lRhxoJcu5pqqdgLEJmh47bMR35VknrhKtZZ9y" +
           "PLo/6NRJR+kO1XUYdRco1kNj36xgnL3uOq6CB9KURU1l2qtVPX/ETNikX1Or" +
           "tWDi6U24OhBp14QLcyFCyWE/6SyZrqzOepRiLHy1MYfTUXVixNCqN05tIHvl" +
           "Ej2Tc1DSBXGWLUr9qFNycZsuBQqRlJ3+hpjmWalXlvOaORCdXqrZyqy+CBWl" +
           "36ooiVVrVeS2LZKR3rf7drxqUcsqEWSjjGXwOO2JHaG3LMcorq28Zm3MTlbO" +
           "qLy2JxO+NhQ2dGVQpS1jENU3nKRsKxunsWaq1pLAcS2QBSohF6LKGU0e9KuK" +
           "M6S2zXE277KqpfcWY2IRQRCraF6drOZ60oCxQBmLGgmc8rQmaaGka8W16ahr" +
           "lbbUWhbWW2OdenlW2zq1JsvTrM0CygOGXS3V9aizmZTzsoAr1bHRcGmphzWD" +
           "tKcF6zzqjdkN2ur4Qaw7nLWFAXjOs163sU7tdkyBPG1zgCu1whCAsdWnynpP" +
           "64xAyvsVd64trTUD9OHUKpltitSBWx41m6XtIN6ALFnMR0PcaWSVAQWm9dI0" +
           "1wIYxoQwZNxgA2VGg4XOr/WUyCcyA6ZhTfe0eRVTZBw0PGVkDJmBugWNNtvo" +
           "pNRs3cjHxDiYaoN5LRR5o5stmHLijtBpN4+2OKHX6zMtFupVMumq8mRodKoL" +
           "AGcvgR0EWtd3OQbn1TZbKi2mcU9qOSiXt+mpm255kRlJfclZYWYPsGZU6mQs" +
           "m9FTks1nC4XN5y07XGyjNTv07E21TqgCG1YdphPwhDyrzWQgTsfN0UpiVTRf" +
           "+2u0s8goj+i6KtkgJjjhSyktN+HiFsLAepLrZoLJVXqN0uWpB22HT+LQ2Kga" +
           "P9z2s1J12Zmj4pLZLNxNxzaw2SZfYbVRdwYDqZXF6C5XW+F+CdS666nnav1e" +
           "uTc3ZG5SE6guW+EkGIVNMbud+gM7jygXc4COcSDPWmieZ3XcCcWuuGgJ/ojK" +
           "qUwwbCtuNgS2LNVFRZnDKGZgz/UaETNNczPy4tqy3qGCycjm2qDv1sJUjCs9" +
           "rBbWNwmT15XK1Ee3zHre8yPGLqek7cmzWU+KtAq1datmOkpJt6bUqpq+8rGs" +
           "7HAVgVY4O8IXeo0UJa3EDPGWQ6gJ7SuA7Bqlhgkq1sYxSgm53ggdaTApW6qt" +
           "d0MJ76DcxPC4SQgjVw1Gbc1SW6rYmKNUFlgNF8WKiJXHrE0tYCg7K5tdVAJo" +
           "GrFDOO3M8956MJEn47gsrogZJusb1bB6dTFclSU9XLuEAnx6zG8mqONRltBx" +
           "h7gwi02mLtM62YpoJcUydlUZ+MBx035TX80ixmPa/UyZogypwHUURpMwpiht" +
           "ylvZ6K8bSbhY9EiVCWMtH8lsG6/LJbHnCNF00240Gu9/f7Fl8G/f3FbGQ7td" +
           "m+PbVQuXLD784pvYrcjvsvVaZL3dgCen/JeONr/OXNQ5tfl16jASKY5Ln7zb" +
           "XardefHnP/bSy4bws9jB4d4flSBXDq+4nfSz38d96exhz/sQ5MIDexL2/6c3" +
           "4E6Yv9tJz7n9x4MTjtEi2R/6fvUeu5S/UyT/IUEuRyAGdzy3vrQOHONEA195" +
           "o/2i0yPcieP3QE4fOeT4kT83xxdOtju/sKvwB/dg9o+K5PcT5LpuA33ZMIzD" +
           "m0ZF8X85YfG/vxkW8wR58OyFpaN9xtKb2DaFFvb4bXcq9/cA9S++fP3aYy+P" +
           "/9P+PObort59feSambru6aPfU/krcIViOjuu79sfBO/PSf93gjxxd7qKE6ej" +
           "/I6N1/at/jhBbpxvBS2j+Dtd7VsJ8pZT1RLk6mHudKXXE+QirFRkvxPeYU92" +
           "fxCeXzjrgcfKefiNlHPKaZ89c9axu9p6dC6R7i+3vqB/6eUu/+HXaj+7v4yk" +
           "u9p2d3J6rY9c3d+LOj7beOauvR31dYV97vUHf/6+dx/BwIN7gk+M+hRt77zz" +
           "FaC2Fya7SzvbLz/2iz/8T1/+3d0W8f8F");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          "6a6O9HMsAAA=";
    }
    private static class Photon {
        float x;
        float y;
        float z;
        short dir;
        int power;
        int flags;
        static final int SPLIT_X = 0;
        static final int SPLIT_Y = 1;
        static final int SPLIT_Z = 2;
        static final int SPLIT_MASK = 3;
        Photon(org.sunflow.math.Point3 p,
               org.sunflow.math.Vector3 dir,
               org.sunflow.image.Color power) {
            super(
              );
            x =
              p.
                x;
            y =
              p.
                y;
            z =
              p.
                z;
            this.
              dir =
              dir.
                encode(
                  );
            this.
              power =
              power.
                toRGBE(
                  );
            flags =
              SPLIT_X;
        }
        void setSplitAxis(int axis) { flags &=
                                        ~SPLIT_MASK;
                                      flags |=
                                        axis;
        }
        float getCoord(int axis) { switch (axis) {
                                       case SPLIT_X:
                                           return x;
                                       case SPLIT_Y:
                                           return y;
                                       default:
                                           return z;
                                   } }
        float getDist1(float px, float py,
                       float pz) { switch (flags &
                                             SPLIT_MASK) {
                                       case SPLIT_X:
                                           return px -
                                             x;
                                       case SPLIT_Y:
                                           return py -
                                             y;
                                       default:
                                           return pz -
                                             z;
                                   } }
        float getDist2(float px, float py,
                       float pz) { float dx =
                                     x -
                                     px;
                                   float dy =
                                     y -
                                     py;
                                   float dz =
                                     z -
                                     pz;
                                   return dx *
                                     dx +
                                     dy *
                                     dy +
                                     dz *
                                     dz; }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "6YKPEGaxbtJqkg63S3zTOKG0p3BXvfBvQSm99XmyllDN4z9aUtryUl/xspnB" +
           "DAy3rGBTEuFVvcuMspLaYkLH3gh9Z+qLSbU6YIVabdmTGwxi5ElsYoiCbDbl" +
           "QJzPZ2VV8KnZjB2P5oJHEc1Bi+k5qR+1FvKMJnqzbjSVy4TTrvOwxwtSty83" +
           "YqGBKFWtCmcNu6+t+nSg+JZlwmyJQWDT3DAY3K4IqmnPOU+aelQlqlB2JnVt" +
           "otxEVCxqdpclp50ofE0pi7Uat6iaTo2b18NW2Z0lPQZxpkyLdfQomtbaw/lK" +
           "aBPTiHJ5dFDGHb488FoNvtcS1HA96ikU7xnyfC3x07Sy8J1+K6+3ybUktIZS" +
           "Wd20SVUZeTOlW9MZyluJMh3DKqzV6rwp0eOVjW0k3sBsM2THsqxnM5T0Sx3U" +
           "5inX8wmRrEV0C8mHdVntRXjqjGKaCjcaF4r5fL1eCloN1SVfbq/CctmyAjHW" +
           "28PqUuRbY0ns1XhPW6jkgNqMjH65ytY7qqKEVQMlknnHMcTJUBimw0kqyMOl" +
           "Olr6qdGpS4NWo1mR1sioLi2RHhIREcNT46lsjqRw5tfn9KTTp12WGvR6sjFD" +
           "h/WWIXdaceisCZO0uxq3YetoYjko4TcNaj4Ye2N+OfJ6neW62VQ9ZNxb9Eq5" +
           "qCqhSXWHkswu5xVBanm5Mh00Ko7QYQdLcrCEaUXR20QwVqpc3ZgNKnZvWRd9" +
           "fjEJW5NwinmcNPaVXpfSm/Uy3l1Q2aajj1rTfg18kMynzRxjpoNA6QvRgm9N" +
           "6mwzURF63GzGjKSsQ01aeiPJmTXbERikjuSNbL/f19sVj+jMYmnSagYKqczG" +
           "NF+JwhlmD3pqM2yU5+Zk2MVbklCutmhqOUwYbuVMWoOkisRKP7YMLJYnHD3x" +
           "ZbHjTO1y22N4PqgEy/4Qr1aGMuL36raIzHRvmm9WJXvT3jhjxh6FrZodwtOI" +
           "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" +
           "l7/rX7385e0B3P8HrwZ6DS8sAAA=");
    }
    public boolean allowDiffuseBounced() {
        return false;
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
       "S9TTn/BXfPvp/wFqpVj96zEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jugRGadWQPYYvYUuneG8JpBGpUgbDVcZ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("uJti4M/LzEpH08a0nxZX8xHUd7g674WiGyBC1VRwFW2LKsHZWKvDwf0xk4yL" +
       "KRUaNGqYdLWzbAWkXgyWGkQ7dIPGGKQYRC2qptTbdG3KI0pbYdlgWSEXZEmX" +
       "xwPNg+ddslXjNtgUzOVg7ucthaGqzV6nPaoMmiVqvl4lHL4spxRjzkVhs5Qs" +
       "uEtzbh+vVgbMsiHCNT7gM0WkqSE2cSd0l7bJgPJIOmFaFClOuY07R9hJl7GU" +
       "uDuoxALncq677KtRqeivwnFR9y1hFFIU5i/0eGY1yE0JxQRDhScjzaPouDVJ" +
       "2f46BBJpcLjSknW1XwKq2Pf8ueivliijz91WOrDWSYrMexyruRo0KLLSSEkG" +
       "gwaeCCN9xFghOca9hJfi2KeJ0B61VrFsGQTbxFoBWOrWqPKq1uiECFVWCRiP" +
       "PYoNV80Sj0Am013VeqGO8dNAHSRtERt224hS73YrLadZn9ol0rA3a3cVKXxT" +
       "rtda081KXnqtgLKwUY+KgmmnRSvmAEWlBuWjRSNKW5FOu7XlQFkio9EKJlol" +
       "CMFZz8VQ1lDSiESlqtKiRRsHsUo1bTU4fcj4rE8xmFUUMGC1FciZuiSvw4s4" +
       "UBoBNNWaqkKrZrmorFsMCHDmIIThK6iJTLwaUpY9zgLx93S2QNOR7TO+sq67" +
       "qaUhpVhVprDULhoDuV2ul2Kp6Sd2KM+4PuEyAlaWAmKWUHNYHEvlSb/FwE4i" +
       "x+rKcSG+RIzNjkkW110JG1fW+pjHO7V06mF6OK5UO2V50FQ0ORpsVLQFYo0W" +
       "T7LAyYtkHYPbY6SOiQrHDpW6kvqYO1t13OnEN9EYXwQiEXrDrlyV1kN/lqLo" +
       "ultTSorpw5tVpcaiNa7oFdf8VO9M21Gr0mr4Kj0z3EDfdJrtaLVUK854RZPl" +
       "eg1C6UW8oTZeC9gQ78D4TB1GHhxTK29igLUC2Wg03va27FHkH1/fI9J786fB" +
       "h9udDauWZXz1Op6CJqd3eP6ww68cbb7L/7LH6id2zh57on7sjf3hxrVnr3j1" +
       "v//Cv33wFjt7h/rYWfuh8/enn3rfiy8tBr+KnN/tCHg+LNwWut5bLCVSrGO9" +
       "33n1zUC9/C350Z6r333fnz3C/6T2juvYavrEHs79Jv957zNfpt8s/9L5wg2H" +
       "O7Cu2Kh+stJze5tEfAXE7A5/YvfVYye3exbB8exuMJ7df71xpAWnv9v48a0W" +
       "7W0dPHdU4NfyAj+4yt7Cv8iSV/J9XIon+sqpz+UjV18cKeP/+lGP5I/3kd/4" +
       "nydf6SC74+D8ujiTV+N8oLJ/63p2q/SVjHe4ew2eNX/uprMldu62LCmEhbss" +
       "VxZD5djb8788lNG5c69WRtlL1t5ORr3XRkbHSdx/lbwHsuRuoBKSaGVavUft" +
       "wqulltGZ76jNXxtqN+YFbswu828G3nmU5JSeuArdp7LkkbBw944upyxtZbtR" +
       "4xjrN7xa1k+D47d2rH/rtWF9/sjRH+MKXYXrW7LkzcCig1j09hj+2KtgmLsy" +
       "Fhxf2DH8wvUyPN2V7cb1wKwfu8KsOU3MNgtkHz4pB6UevmJPwUTJNiCjBwUe" +
       "Ol5At8Wlku0Sd7O36OfemsupdhUZ/lSWlMLCTfnWpj0hoq9WiNkOmi/uhPjF" +
       "10aIx8G3r5LXzRIizL680ffVn3y1vLL8r+94ff214XU0z53DcgLjq5CbZskw" +
       "LNy+VEJOtD1L2XfZo1dBMd83/WYA5v3butvf13boxKvkyVny9rBwv2gBnSZ0" +
       "VV0HSraTRlYWp83ot0iuaymic8T+Z14t+2cAkRd27F947dl7V8nLDdcMCw/m" +
       "7FlF3X2xsRNAlqscMbVeC6Yf2jH90GvP9F1XyXt3lsTHmPriVZgmr4Lphewm" +
       "cEbnPrJj+pHXnukHrpL3wSx5/96unSNqf+d6qCVh4Z79qC/7lufhK76v3X4T" +
       "Kn/2pQu3PvTS+Ovb3bsH323exhRuVdeWdfzLimPnN4MIWtVz0rdtv7Pwcia/" +
       "GBYeOTscBcufw/MM+LmPbmu9CDDv1wKuOfs5XuzjYeGOY8WAvHZnxwv9w7Bw" +
       "AyiUnf6jfPDEZBspP3x87PPY/r4fJdfDKse/Cdv/hqC33n7UfFn+3Eud/jtf" +
       "qf7q9ps02RLTNGvlVqZwy/bzuLzRbDn21JmtHbR1c+uZH979G7e96WDpePcW" +
       "8JEeHsP2xOkfgJG2F+ab7tPffuhfvfWfvvStfIfT/wPzlybUaz4AAA==");
}
