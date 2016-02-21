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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FQuOaRZA8+UVOsSgAck9rUd33fb63cKAcEEOEdO9+6//KLFvv4is6FqWlDQO" +
           "fh7RuQhz8LIGtVtcSQrn2PDavXt+fmjPdUKr1mANXg8t5t3Pf/Bk4sCfHi8D" +
           "9VWq03muwjQuYvLsYGyEQZd+vekXN7RWbQAo6SG1eV3dnac9in9GaLrsfMYX" +
           "LK8b4gN+0zAwjMRWYAxw5DzHYvzp8t1fxHD5G1KJmvh3fYFPuZo/SxQpiLNg" +
           "8X8vXjptPxoHw+zrydPyDc8daxw89tBx7qpgU+8HHyh8Ik4teFmKcZobrngb" +
           "JXsE6M450ndFs3bkJMw4BDPK0Mnamy0owYUAVDnU06b/4Ze/mrPj6SoS30Dq" +
           "wWxlg8RRn9QB3FJ7BKp3wbzoYoE7YwhEzdxUUmI8rvQzymPI+pzJ+Kqf+Mnc" +
           "H1145+QrHOWEv0/n7LXYPgQKM98IenXlrmfP//2d3755TCRdhSUU4pt3YrOW" +
           "ufbP75Y4mJfRMqsqxD+UPHxbe/faNzi/V8+Qe0mhtOWBiu/xrror9+94R82v" +
           "42T6EGmWnY3XoKTlsUoMwWbDdndjsDkLPA9uHESX3FWs1/PDy9onNlxJ/aul" +
           "mgVWRqh4tsL3PafCvBcunjHCb7ZzlmV4WVFSniK5cUkZeV3BP58RZRivfXhJ" +
           "izT4fGSOfSEo5zT4nnDknIjQklbUMoqbkbjJ/XJZSMXsJ6Ai32YNo8jxciJz" +
           "n4DI3UWRE+VEWh9fJB/F3c1JR+TJCJGjIhD8uhwvKwWWMjLdtNRRqImhJqep" +
           "wqRQPXJivxHOobEpqr4Ivu87Ut6PUP0qL4fGS3WM4gbDhg22kUrmqYrM9Ixh" +
           "aFTSy5eZkIFXf3wDW10DP3BU/CDCwG9ExqbOtAwGgEOVUHRaKkwLa1wBhF8V" +
           "PPgrdlq88RN1/YoZjzxsf/9v9wsoL9fHhY4aDt1ZK7+ce4T3cSjr/KJWM1EJ" +
           "3Gu3O1rxX0Yy/6/Nr9v8JLdaKiCxRnuhJrpb7E9BClb6pdHFzufVyR8seeqq" +
           "ySWv8rpfq9pQEqBjLXP44+M5dvjoG880LriHb9aqsfF1+qjgqVnpoVjgrIvH" +
           "pAkvNwn4LGnweIYKAif5biuffHFGasx8RlNlLBmqLml8xjUwrFF9WJywrMXL" +
           "rU77gGLigtfdNIjtBhbORLdm6BR3Lu4zcU6gGoniISM8LJQobJEFgWakl5vr" +
           "Vfb6r501K8UK2dIDApxpYcQRwIroQIYFPHrtP9q3rh3ZMYXd/xmhOIen/GHv" +
           "4ccvWybfGOenk6KRKDnVDDJ1BduHeouyvKUH2+sOL/C3RiAK3n5PBLJC43xf" +
           "hWf34+Uw5ISMARXxr0D+AM+xQV+TWglcvzlFcF0M3w8dvPkwAlx/6lWPfaUY" +
           "GsUNBsL+ysnHG4t8DcQRPdvhmx2WykkP4OXhgpvqq6ZyqibuTNP8eC77WQWX" +
           "FSKWNt5OwEK2+RsAr7JUu9YFjkp91vm2CQTxcEHUaTbfnR68dv+ksvmOs91i" +
           "cTGIdF4yePMIrDgUjMxKsLZBqCB+/R72HBDRVkayhvI07nnjHI6WfOrnKmTz" +
           "83j5LeQGvgBj5XqJ6lFDVbzo/O5UCR3YtvGlUs4fy8CYNseotqn7I4o1ZKm/" +
           "RvxvWct1+UsFB76Gl1dgRy2PUHnXOkVxzpBx+EXPbUen7rYCIzODB9KuHWdO" +
           "wQ7I6Xkl79HEux/5nsmm2rmTl78gSrT7fqYhRWqzeU3z7+189zWmRbMqt71B" +
           "7PTExuYYI+3RemHj595zM94SXG8z0hzmgpzDHz/ZO4zM8JExPJvhd36i96CJ" +
           "ByK8PWG6vmr2CrbY6RZiwTVfDFHbqULkg4klgWrLX2e6lTEvXmim5XsnN/Vd" +
           "efy8O8Spr6xJE3xrNAM6HHEAXayuiyNnc+eq2bj85Mz76pa6wNMiFPYWyum+" +
           "lByElDcx8O2hs1G7s3hE+tLBCx/6zd6aZ6Cj20ZiEjQ220rPBApmHhBxW6r0" +
           "AA06D35o27X81vG1K7NvvcwPXYhob+ZH06fluhP7JhbbsUSc1PU4FYkfVlw6" +
           "rm+h8qgVOI2ryeDO3m0MZ2KGSviak3vFcWZjcRTfGDDSUXosWfoWpR5Sh1qX" +
           "uOcGjaFeJG+a/qfcq5cKWEQvQ56lU72m6Z7HXs+9DgUOfmONvKj9F05DGdWn" +
           "IAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "5OmiF08H7ZirbGOP7tUTggT0Clq2cvOatF2vhfpwvjKDLAzx5Ta0lHQyEAi9" +
           "02hII2neHfelQYINN1S/VhHjVtRgp2lz0bXXQRPJ3FpnNMlVip7KE8XwRBwM" +
           "XlnHmTuMm4ilTnqM1q1vdYFnItKc2nzej7llO+y0K7DYqNFtUpyt5e0qY6oN" +
           "D8xOBpeMYeT13UlBoDbG6aNeBgIWbB6yuNMlZwCv4CE27YjoIsl6zjSuG1ui" +
           "sxjEup+EXoOp+8BIXVjM8kxSE6QyjbvtBt5zEM0UtzVhSnvz4XqWF0E7r1Bz" +
           "QZnqXiNadJhiSLab/ZSWtOFm1GDw+dppNGkqzWHMi123FrkTp0GY42jSMMLF" +
           "SpTCQp+iRaOCEM1CckWFD5MG0m4IEypPFwumgoq6S9tYEyv4Zn087xFFdVW4" +
           "ZlCQdAEvh/WCJ1gqF9hspaG41cQ7bHvbJwSph2duVOtEygIXl9ZmMjPILq2E" +
           "U25t1teOKUXcvKbjzoTK5q7lYvPYG8AzTQdSGBLjIMJzlkLzaNDicZqmWnN5" +
           "m1rbgadW9LCm2ATGFw08kPHNgLe6wkLapm7FaW8ph1RzYlhbxUivEaMrqpJw" +
           "7Q4wn0LD5SXesWvVpUXZo1qtGgntVuDSq3Yu4VG11ariJIr5tcacQDLg8RqD" +
           "LFM3wnyx8pXKkq7ihpOuhAa7UpR4OlYRYVrvLtbGzNngkVtZEaE5GzK1aKuT" +
           "Q9St8stavzfOLHmNZl1VWtqqODF6JDmezv1YMnwpELHxCgnn6VDt2XJXZ3sV" +
           "GQ4NNcTUvkSNshGGO9NGzcWXDXoeV5rA5IaGOxxkfbvZrWJkT5O8crFfLv//" +
           "/RvblnhwtwNzfKPKdhrlh599AzsP+R22Ucusuxvw5BT/0tFG1pnLOac2sk4d" +
           "NkLlcegTd7o/tTsP/syHX3xJG/4kcnC4j0ck0OXDa20n/ez3ZF88e5jzHgi6" +
           "cP+ehP3v6c20E+bvdJJzbi/x4IRjuEz2h7q/fZcdx98pk/+YQPdEeqzf9lz6" +
           "UuZb2okGvvh6ez+nR7gdx+8CnD58yPHD/9ccXzjZuvzsrsKf3IXZPyuTP0yg" +
           "a+pKV9ctTTu8SVQW/9cTFv/ojbCYJ9ADZy8kHe0ZVt7AFiiwsMduuUe5v/un" +
           "fu6la1cffWn6n/fnLUf38+7loKtG6jinj3ZP5S8HkW5YO67v3R/07s9B/0cC" +
           "PX5nusoTpaP8jo1X963+PIGun28FLKP8OV3tawn0plPVEujKYe50pdcS6CKo" +
           "VGa/Edxmf3V/0J1fODsDj5Xz0Osp59SkfebMucXuOuvRGUO6v9D6vPr5l9jB" +
           "B17Ff3J/2Uh15GJ3MnqVg67s7z0dn1M8fcfejvq6TD/72gM/fe87j2DggT3B" +
           "J0Z9ira33/6KD+UGye5STvGFR3/2e/7FS7+32+7930XQpWxnLAAA");
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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "vUCT/8aTv/rt//zlL24P0v4vfdPKTwssAAA=");
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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nSCh730wAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XYnBXNJdYi2LFBw20lIAbMmjjFzq+KntLHG5gqSredwtT6r2fMXLkrkRZReD" +
       "kXAdCUmZbPN9pW+KuGWNV4KJt1fr1qhvF3l7yYfMnKLLQ2siDAaLaDCZcqw9" +
       "gSuTQJHW3soJR2SYrGle61qrJe3OFHzaLa5M1Bnx8zovksk4nfWZGBpPbM7R" +
       "u+qwXFZbgiqhk9Kq0m82BX4+bAaVzZT34T635C1u2MbbU7XYQHFglfVhB5oH" +
       "3Zq4tMVJtcn53fXSZCOfpvXK0kdLzXqbULqDluVjUWnqs2VCdhC/5YgjoUSv" +
       "OhWCEFriSudbfWIVYlUqdfj2LNaHSG3gaDYqJ0OmGUtCyJMbXB9OI7ur2kmr" +
       "P1GbA8LacPhEN0pE2gfz1y6ztTWDVL1RE2WIZkhgtdKCT2YBC0Q1F01nzrXm" +
       "RlQqK2OHn1nDujpjArs+H7ZR3GQXcNSMWhNNSzcOHOo2Mu8bnk5oPkVXCH1l" +
       "uyi9sEpyosqrRqM/rYpjy1GCftxlhsbYqW9cbMrbNZObenWpI/bEKdXviorH" +
       "Mosa1S11UB83uCQqcuuuwy/8rmQHRb8ELYpEv6lMPEIXvX7DGyqwjwMwNa1i" +
       "jkaGn22udFFVTAwqrkt6PBQTV+T6LOCIcWPIdpYsA8VgHM7y1qLVgcBs4G4w" +
       "6vMWwtVqQ77PKmW5LpWS+loa4C5dtzYz1O+Pe2Sn37UX01YPTUnDIsuYtoCQ" +
       "OduZgXWHgLoCFvGtWqXVdsXSmFM3ZXpDtFahNEDK9SEzUDze8HqUWMIxS+la" +
       "sGCu56vSdOyDazUd9ylU4vmqSpqVSm+ieL2aDjUi3DIhuZgMtVmp7OEQrrXL" +
       "RK/TQ7Re10uZ6XjhMMy6BwnFkJrzqTSESric0vhg0qFlOWRauIVWV5jh1BfU" +
       "QF/I/fYKqKO0xlvVfn9ANhcRWtOiIqPMYUJMmKpClledQHfHZKMZ2DXJwxp+" +
       "2Z/ZUiNAqjUoSnilpbQhuYu1taHN42a1qFOIY46KwgqNO/M6zTDEyC3KZYKA" +
       "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" +
       "tJeW4ygERN7tljCS3dBTBBmUJgPblIrT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "v/nwv3nbP3/56/mppP8PPTO8YzM+AAA=");
}
