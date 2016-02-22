package org.sunflow.core.photonmap;
public final class GlobalPhotonMap implements org.sunflow.core.GlobalPhotonMapInterface {
    private java.util.ArrayList<org.sunflow.core.photonmap.GlobalPhotonMap.Photon>
      photonList;
    private org.sunflow.core.photonmap.GlobalPhotonMap.Photon[] photons;
    private int storedPhotons;
    private int halfStoredPhotons;
    private int log2n;
    private int numGather;
    private float gatherRadius;
    private org.sunflow.math.BoundingBox bounds;
    private boolean hasRadiance;
    private float maxPower;
    private float maxRadius;
    private int numEmit;
    public GlobalPhotonMap(int numEmit, int numGather, float gatherRadius) {
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
        bounds =
          new org.sunflow.math.BoundingBox(
            );
        hasRadiance =
          false;
        maxPower =
          0;
        maxRadius =
          0;
    }
    public void prepare(org.sunflow.math.BoundingBox sceneBounds) {
        photonList =
          new java.util.ArrayList<org.sunflow.core.photonmap.GlobalPhotonMap.Photon>(
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
    public void store(org.sunflow.core.ShadingState state,
                      org.sunflow.math.Vector3 dir,
                      org.sunflow.image.Color power,
                      org.sunflow.image.Color diffuse) { org.sunflow.core.photonmap.GlobalPhotonMap.Photon p =
                                                           new org.sunflow.core.photonmap.GlobalPhotonMap.Photon(
                                                           state.
                                                             getPoint(
                                                               ),
                                                           state.
                                                             getNormal(
                                                               ),
                                                           dir,
                                                           power,
                                                           diffuse);
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
    private void locatePhotons(org.sunflow.core.photonmap.GlobalPhotonMap.NearestPhotons np) {
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
                                           new org.sunflow.core.photonmap.GlobalPhotonMap.Photon[photonList.
                                                                                                   size(
                                                                                                     )]);
                             photonList =
                               null;
                             org.sunflow.core.photonmap.GlobalPhotonMap.Photon[] temp =
                               new org.sunflow.core.photonmap.GlobalPhotonMap.Photon[storedPhotons +
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
    private void balanceSegment(org.sunflow.core.photonmap.GlobalPhotonMap.Photon[] temp,
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
          org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
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
              org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
                SPLIT_X;
        else
            if (extents.
                  y >
                  extents.
                    z)
                axis =
                  org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
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
                    case org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
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
                    case org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
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
                    case org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
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
                    case org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
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
    private void swap(int i, int j) { org.sunflow.core.photonmap.GlobalPhotonMap.Photon tmp =
                                        photons[i];
                                      photons[i] =
                                        photons[j];
                                      photons[j] =
                                        tmp;
    }
    static class Photon {
        float x;
        float y;
        float z;
        short dir;
        short normal;
        int data;
        int power;
        int flags;
        static final int SPLIT_X = 0;
        static final int SPLIT_Y = 1;
        static final int SPLIT_Z = 2;
        static final int SPLIT_MASK = 3;
        Photon(org.sunflow.math.Point3 p,
               org.sunflow.math.Vector3 n,
               org.sunflow.math.Vector3 dir,
               org.sunflow.image.Color power,
               org.sunflow.image.Color diffuse) {
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
              0;
            normal =
              n.
                encode(
                  );
            data =
              diffuse.
                toRGB(
                  );
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
          ("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" +
           "9LVEPyYL4Hnenuf5Ai1D+WMJ1haRDpWzfmY0vvPj3Se3bvtaGEvuikGsQSBT" +
           "1Dt0XRm8qPvO3ttnThx5+/uigsuJ/omFWLSLsDlPOEYYXN8U130ITlap4ju0" +
           "TC2hJydVPd2xjrXxq4pZ5KfjsMhhe6bDRSyCnZ/lfPnhADjY3YPNA0VwBEnP" +
           "47i6GI5948BxxJ7pSAkcQtfHxoMjSHoeR18xHI+PEceX4XnBnumFEjjKsDM6" +
           "HhxB0jmpsXB0Lu+5shiU/SWgZItrIrxmj6OEOBDVEN/ln0sJ18GHYAE3M+h+" +
           "VhRvu28a2ZVcfd/isH3mvBb2lX1t7sgpRzGeA1SnuI52TiNvTr7tj79s6V8x" +
           "ljsvHJt1ilst/D0bYsWi4BrZr8rBm443r710YMMYrq9m+0zkF/lA597nLj9b" +
           "ui0s7t6tY1LBnb2XqdVbldYYjGcM1VuHzvd61nx4jtqLetTvt44jBQX/IFbf" +
           "BYMrr94spB4tcQPxB2xe4XCCZrxHV2S+PCubxVJ3+aAmJx0/f/VUW7b0aR8H" +
           "2nUx/mIeKN6wkSZ4jtlAj43dRkGsp7LR8RI2eh+bP3NS3c94m6YZSfy9zrHF" +
           "X75IWxy3AR0fuy2CWH1Qy4QiIlaucxoh/2QJq/wLm39YVrlMNvlin1U++iKt" +
           "8rEN7eOxWyWI9bStEioPtkqoEgc/c6xyvtcqIfJ5WCULIdz6viEoZnCy6PS/" +
           "jECkn1Hw2dX6VCg9vKuuevquda+JIJ//nFcL4TqVURT3VZCrX6kbLCULy9da" +
           "F0PiuB2q56Q5WC1OJuT7iCJUZ3FN4aTezwXRB/+5yZo4megi43grIHpuojPg" +
           "xAFE2G3Wc6ZyFaXWxVg25E2oeQ+edqq1cuXg+Z70Jb5+51JNxvr+HZf27bqi" +
           "64YTX73P+g4gKXSzOFdPjJEq65NEPl3NDZSWk1W5auGnkx+ZsCCX1RsshR33" +
           "P9O1Vdsh1Om48M2+23KzJX9p/sbupU++sL3yJajg15MQ5WTK+sIrxKyegTph" +
           "fazw6gZSu7jGb1149/Cl56b+/vtciR/yXs366eNS387XOx7ZdHKZ+NxaAQUL" +
           "y4q7zcuG1TVMGjQ890CT0ScpfgcXdrDNNyk/il+NOJlXeAlW+K2tRsFj3Qot" +
           "o4p4PglKCWckV6Z4MnxG130Mzoi9dNhSK3Gi9cH/4rFOXc/dEd6iix2cCDwD" +
           "h84TXexF/g8nHHW8CCMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "17/nXz7/5e3XvP8PZ6jp1p8tAAA=");
    }
    public void init() { org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "Balancing global photon map ...");
                         org.sunflow.system.UI.
                           taskStart(
                             "Balancing global photon map",
                             0,
                             1);
                         org.sunflow.system.Timer t =
                           new org.sunflow.system.Timer(
                           );
                         t.start();
                         balance();
                         t.end();
                         org.sunflow.system.UI.
                           taskStop(
                             );
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "Global photon map:");
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
                             numGather);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Estimate radius:  %.3f",
                             gatherRadius);
                         maxRadius = 1.4F *
                                       (float)
                                         java.lang.Math.
                                         sqrt(
                                           maxPower *
                                             numGather);
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
                         t.start();
                         precomputeRadiance(
                           );
                         t.end();
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Precompute time:  %s",
                             t.
                               toString(
                                 ));
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Radiance photons: %d",
                             storedPhotons);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Search radius:    %.3f",
                             gatherRadius);
    }
    public void precomputeRadiance() { if (storedPhotons ==
                                             0)
                                           return;
                                       int quadStoredPhotons =
                                         halfStoredPhotons /
                                         2;
                                       org.sunflow.math.Point3 p =
                                         new org.sunflow.math.Point3(
                                         );
                                       org.sunflow.math.Vector3 n =
                                         new org.sunflow.math.Vector3(
                                         );
                                       org.sunflow.math.Point3 ppos =
                                         new org.sunflow.math.Point3(
                                         );
                                       org.sunflow.math.Vector3 pdir =
                                         new org.sunflow.math.Vector3(
                                         );
                                       org.sunflow.math.Vector3 pvec =
                                         new org.sunflow.math.Vector3(
                                         );
                                       org.sunflow.image.Color irr =
                                         new org.sunflow.image.Color(
                                         );
                                       org.sunflow.image.Color pow =
                                         new org.sunflow.image.Color(
                                         );
                                       float maxDist2 =
                                         gatherRadius *
                                         gatherRadius;
                                       org.sunflow.core.photonmap.GlobalPhotonMap.NearestPhotons np =
                                         new org.sunflow.core.photonmap.GlobalPhotonMap.NearestPhotons(
                                         p,
                                         numGather,
                                         maxDist2);
                                       org.sunflow.core.photonmap.GlobalPhotonMap.Photon[] temp =
                                         new org.sunflow.core.photonmap.GlobalPhotonMap.Photon[quadStoredPhotons +
                                                                                                 1];
                                       org.sunflow.system.UI.
                                         taskStart(
                                           "Precomputing radiance",
                                           1,
                                           quadStoredPhotons);
                                       for (int i =
                                              1;
                                            i <=
                                              quadStoredPhotons;
                                            i++) {
                                           org.sunflow.system.UI.
                                             taskUpdate(
                                               i);
                                           org.sunflow.core.photonmap.GlobalPhotonMap.Photon curr =
                                             photons[i];
                                           p.
                                             set(
                                               curr.
                                                 x,
                                               curr.
                                                 y,
                                               curr.
                                                 z);
                                           org.sunflow.math.Vector3.
                                             decode(
                                               curr.
                                                 normal,
                                               n);
                                           irr.
                                             set(
                                               org.sunflow.image.Color.
                                                 BLACK);
                                           np.
                                             reset(
                                               p,
                                               maxDist2);
                                           locatePhotons(
                                             np);
                                           if (np.
                                                 found <
                                                 8) {
                                               curr.
                                                 data =
                                                 0;
                                               temp[i] =
                                                 curr;
                                               continue;
                                           }
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
                                           for (int j =
                                                  1;
                                                j <=
                                                  np.
                                                    found;
                                                j++) {
                                               org.sunflow.core.photonmap.GlobalPhotonMap.Photon phot =
                                                 np.
                                                   index[j];
                                               org.sunflow.math.Vector3.
                                                 decode(
                                                   phot.
                                                     dir,
                                                   pdir);
                                               float cos =
                                                 -org.sunflow.math.Vector3.
                                                 dot(
                                                   pdir,
                                                   n);
                                               if (cos >
                                                     0.01F) {
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
                                                       p,
                                                       pvec);
                                                   float pcos =
                                                     org.sunflow.math.Vector3.
                                                     dot(
                                                       pvec,
                                                       n);
                                                   if (pcos <
                                                         maxNDist &&
                                                         pcos >
                                                         -maxNDist)
                                                       irr.
                                                         add(
                                                           pow.
                                                             setRGBE(
                                                               phot.
                                                                 power));
                                               }
                                           }
                                           irr.
                                             mul(
                                               invArea);
                                           irr.
                                             mul(
                                               new org.sunflow.image.Color(
                                                 curr.
                                                   data)).
                                             mul(
                                               1.0F /
                                                 (float)
                                                   java.lang.Math.
                                                     PI);
                                           curr.
                                             data =
                                             irr.
                                               toRGBE(
                                                 );
                                           temp[i] =
                                             curr;
                                       }
                                       org.sunflow.system.UI.
                                         taskStop(
                                           );
                                       numGather /=
                                         4;
                                       maxRadius =
                                         1.4F *
                                           (float)
                                             java.lang.Math.
                                             sqrt(
                                               maxPower *
                                                 numGather);
                                       if (gatherRadius >
                                             maxRadius)
                                           gatherRadius =
                                             maxRadius;
                                       storedPhotons =
                                         quadStoredPhotons;
                                       halfStoredPhotons =
                                         storedPhotons /
                                           2;
                                       log2n =
                                         (int)
                                           java.lang.Math.
                                           ceil(
                                             java.lang.Math.
                                               log(
                                                 storedPhotons) /
                                               java.lang.Math.
                                               log(
                                                 2.0));
                                       photons =
                                         temp;
                                       hasRadiance =
                                         true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.math.Point3 p,
                                               org.sunflow.math.Vector3 n) {
        if (!hasRadiance ||
              storedPhotons ==
              0)
            return org.sunflow.image.Color.
                     BLACK;
        float px =
          p.
            x;
        float py =
          p.
            y;
        float pz =
          p.
            z;
        int i =
          1;
        int level =
          0;
        int cameFrom;
        float dist2;
        float maxDist2 =
          gatherRadius *
          gatherRadius;
        org.sunflow.core.photonmap.GlobalPhotonMap.Photon nearest =
          null;
        org.sunflow.core.photonmap.GlobalPhotonMap.Photon curr;
        org.sunflow.math.Vector3 photN =
          new org.sunflow.math.Vector3(
          );
        float[] dist1d2 =
          new float[log2n];
        int[] chosen =
          new int[log2n];
        while (true) {
            while (i <
                     halfStoredPhotons) {
                float dist1d =
                  photons[i].
                  getDist1(
                    px,
                    py,
                    pz);
                dist1d2[level] =
                  dist1d *
                    dist1d;
                i +=
                  i;
                if (dist1d >
                      0)
                    i++;
                chosen[level++] =
                  i;
            }
            curr =
              photons[i];
            dist2 =
              curr.
                getDist2(
                  px,
                  py,
                  pz);
            if (dist2 <
                  maxDist2) {
                org.sunflow.math.Vector3.
                  decode(
                    curr.
                      normal,
                    photN);
                float currentDotN =
                  org.sunflow.math.Vector3.
                  dot(
                    photN,
                    n);
                if (currentDotN >
                      0.9F) {
                    nearest =
                      curr;
                    maxDist2 =
                      dist2;
                }
            }
            do  {
                cameFrom =
                  i;
                i >>=
                  1;
                level--;
                if (i ==
                      0)
                    return nearest ==
                      null
                      ? org.sunflow.image.Color.
                          BLACK
                      : new org.sunflow.image.Color(
                      ).
                      setRGBE(
                        nearest.
                          data);
            }while(dist1d2[level] >=
                     maxDist2 ||
                     cameFrom !=
                     chosen[level]); 
            curr =
              photons[i];
            dist2 =
              curr.
                getDist2(
                  px,
                  py,
                  pz);
            if (dist2 <
                  maxDist2) {
                org.sunflow.math.Vector3.
                  decode(
                    curr.
                      normal,
                    photN);
                float currentDotN =
                  org.sunflow.math.Vector3.
                  dot(
                    photN,
                    n);
                if (currentDotN >
                      0.9F) {
                    nearest =
                      curr;
                    maxDist2 =
                      dist2;
                }
            }
            i =
              chosen[level++] ^
                1;
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
        protected org.sunflow.core.photonmap.GlobalPhotonMap.Photon[]
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
                                           (new org.sunflow.core.photonmap.GlobalPhotonMap.Photon[n +
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
        void checkAddNearest(org.sunflow.core.photonmap.GlobalPhotonMap.Photon p) {
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
                        org.sunflow.core.photonmap.GlobalPhotonMap.Photon phot;
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
          ("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" +
           "n8L29jt/BNR1/Hj32U7+lcd+4fv+2ct/");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          "sDsl/r+99inbciwAAA==";
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
       "K779y/8DV6BzXQMzAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hK/b/V53BZemBl4trwl/FiyavLFZkZ68");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("SGG6140rCN3oId1hcUgRFFeOzLpcr+HSuDbfuEN6xHHBcEGHA36zXk3qapNP" +
       "55ThN+FyxDl1ujllRFXvbDSug5u8IRAU2WjpbCUocfEmmuIgWiT70wqvVniX" +
       "MLjFtG962Mo2ZJ12SbhbLYmmY/Nkk9zQ41KVavbppEWjZq8Gt7lZOXHVOgj4" +
       "wdpxtSGYVkej6nV+upFHQXncdMyRrFj1WVdadpJiR2uJtov2HYVbS8MNGbSV" +
       "BmFT7Zlpd5cTBvW6IWkQmF3pasN2FzjzJF4vxVV10iY9OqEMMhnATKrCtNYy" +
       "513KBWYz6rfjsV3v+esYivzJiFt4fNLSnYY6gNcpMjdVhwfY+x6bYhxOTBPb" +
       "7nBrriuFmwiNmqbhqgjdW/uuEi8Z0Ux7bdJiKyJMyVjMWopZC8LZsLm2yxuC" +
       "iAyrywoClbogEhlX5XrLUaddyAMr9dpgajTF1WBBWjVqDNXNsM25QWMsSEVB" +
       "IR2sm0Q1abyCmBnN44jljSB86KYW04bWg5gqsqI2FHUcXxZ1vB30OsKiRQyC" +
       "SDGgKi4wXYMUnbFvlDbxvFnahCycrgRxkM7Cptir27QEIR5m1FkjQlVlRadY" +
       "sbool9ywPUe7/FJI5wy2LkJayihtDXJJDapSYZg0RoGDWFBqJkbdXE1SdALW" +
       "ffZgg+iogmBIjTBabtBP+1wFM/tEOaRdvObSZifiUSyBZKYapKIOI2yxBrOU" +
       "aC99li81ppIGAqfFfDavgoJjClqvV50xWhZhlPSRark3MfRidYoNE7FHkWyv" +
       "IaxQY9lfpnRImmNBY8qUi+BRVVtP8aVUqxp1kURYCB8ti71hhUvwIAqWiV+l" +
       "SGwyCysYQxjRom2MY1xIGqukZuJTbbYZz+ZOTTKCIkLMoRmJrSej7iaOlJqH" +
       "iRJVhZXSXKhHXCtqTWLWHnILWymXxgxGTL2YKw0NfI0OO02VqbpGVTHTxDNq" +
       "rm7CBm/pRrWPYfgaqjVFtA4CcBroBfGz2ePLb1zfY9X78ifIB3ukbRfLMr5y" +
       "HU9O09M7PHfQ4ZcPN+3lv+xR/LHttkeewh950723/xD72SvemJ94T97df/mb" +
       "baV6/Gp7qPMNZZ98z4svacxvls/tXqRjSeH2JAjf4upL3T3S+d1nb6Gh85fL" +
       "hxuPPv+ev3hUeOvsHdexQ/UNJ3CebPJ36Ze/SL5J/bVzhfMH25Cu2Nx+vNLz" +
       "J7ZWRHqyiHzh2Bakxw/GIt8lWgLHm3dj8eaTb0QOleD01yE/uVWiPO9w/9ze" +
       "YYFP5gX++kSBoxvs/leW/Pd8M5MeytGpb8puWgaWdqiL/+PVnuIf7SO/8d+O" +
       "c+bAcWnH+dJrw/mmvMBN+xr7+BUay8/k7P1k9lWFvl/qkSteY4p6tl0P2S/w" +
       "8NEClieberYLNcje0O3dmeHYu+Xqot3Ldhfm75jyrQNZiR8dCHHv3A0IMX+V" +
       "VgZHbSfE2vUKkT1LcfbZ49exUWagZ7qT7PYf5PQfOUM0j2XJA0nhbjdQwYAc" +
       "2bZwREQP3qiIshefwk5EwmsjoqMk3nRGXuZ3957KXjLLbuYZTlB7+kap0eB4" +
       "x47aO14bajsTyi7zfOQwySnBZ9CtZMlbksI9O7q8bnr6dvfvEdaXbpT1M+D4" +
       "3I71514b1ucO58ojXN96Bte3ZQkOvGK8ksMTDH/6Rl1jtn/kxzuGP75ehqe7" +
       "xqPYe2fkUVnSSrKPdayTI9e+UV4XAcTdHpm9K/bI3Dgv8Yy8SZYMk8L9YIbL" +
       "vmxaJPr+tpATLLkbYJkHV48BwOKOpfjasNzp56kzUj5lsYHlJ5nq7t2e01XO" +
       "EIWRJb+QFO409eSIDPbuPJTB229ABvkutjcBOt/ayeBbr/1Ih2fk5fOykxQe" +
       "kF0gnqZlGItYz3YmqXq+t/VThzTdG6X5LED87R3Nb7/2NN95Rt67smSVFB7K" +
       "aXK6sfuu5XSm6WvB9Ds7pt957Zm+74y892fJrxxhGslnMH3VHY5nMM2XQcAx" +
       "7X1vx/R7rz3TF8/I+2iWfOjEvqZDah++HmppUrhwIj7LPnh65IovkLdfzaqf" +
       "funCbQ+/NPoP2y2++1+23k4VbjMWrnv0Y4oj57cAb2pYOefbt59WhDmRTySF" +
       "R68eN4LF3sF5hnvv49tav5EU7j1ZC8xE2d/RYv8EuK4jxYC4dmdHC/1WUjgP" +
       "CmWnv52PnZ1uQ9pHjg59vpK5/9XEelDl6IdzJ78zoBfbz74vq595qTf4xR+i" +
       "v7n9cE915c0ma+U2qnDr9hvCvNFs8fnUVVvbb+uWzrM/uuf3b3/j/kL5ni3g" +
       "QzU8gu0Np38l1/LCJN+Yv/nnD//hz/z2S9/It4D9X4Hpu5GNPwAA");
}
