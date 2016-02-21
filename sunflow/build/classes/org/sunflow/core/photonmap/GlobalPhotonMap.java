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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "A7dr6Gv4Y+3/AfIZNnAqIgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Z0/8+vf+oxe/tP0i938BPj/wa3ctAAA=");
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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "06EgAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "vAdiI13HwfiM53tyr4Pd/N2DDD6xn/R7RGR/+x7vvlAmPwn0p5WTv9fVPar/" +
           "nRw6xyc/8ib55BkA+9Yhn9y6C5/83XuI++FjIgFh7qExfOTsKn1kv1Ih6Oj3" +
           "9BBHtlV9E/v5fS6KovPCf/ENhd9z8gVAhffVbjZvVsrnL99ZvIs7bYLFk+wO" +
           "H8unHz8S9jHX024cbQdkI06Axd5wveaRNNdPVtH++O4cUOw7BgpW00MnnXFh" +
           "YD3/if/80m986tmvAwruQfdlZeQHFsWpEfl1eTj6N1/57JNvufX7n9htSoGy" +
           "xNeLf/qXyl6/ei9xy+QXzoj6RCmqFK5jzeDUJB3sNpSGfiztOTd3Cdjt/7m0" +
           "6bVvM2jCEkd/XFUhpxutOvLgdX2u1dDAZeEx0SPpPKCsXkVClwxV5YkWs9S4" +
           "qFbv2PN4IhS+UsXUSmsrFIJiTNfZWB6Ek2Xa8EftgdTuopRV8ewZwdLmhJp4" +
           "M4/qSdMwz+meOk1Jp0r3qKnHLSQPQRCjGDRyAVsv+567bQ62C6SOIPCiiZg1" +
           "WMioqV9rK8qQmU7n/YGfjsRY5+fxdKzIgjvrpbFJTukVvJ5EDQVJFqKauVFX" +
           "JYq2IzW7mJKsvYY3XfXFScdfNWO+R9d83YI9MuAq01Tyq3GHkqmByXL8ZL1N" +
           "A3W1ShIf64QTd8hVl1HF2eTKylfEPq8XljQoKLjdW/prCQwNMzLjLLezzkyc" +
           "sBgSszBSySZMPyBNTlkNo1QeqF7UwyI/7nndVeGGPbpwKX4xGw0HVYekPduJ" +
           "6mobRXv8apj2Z3y7ZsJCswm3FuqaXftkEK2TLmqY86lqZ+qAlqWIpxYz1RwF" +
           "XG1h9rBJpFkVpqDcpuTN1Haf6i27odqoMm09rE86NbNRSKigbfWVpk4mEt2l" +
           "rUkwkGRu6wZjnOnr87miYqkr+Bqj2hM5tpWJ10uxyjjgHGxd5TtVaZRbjLQS" +
           "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" +
           "/d+bWMpNZiwAAA==");
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
      ("H4sIAAAAAAAAAL1aC5AcRRnu3btcLvfIvfJOLuRxhLoQdiERAh6CyeVCLuwl" +
       "Ry6cxQXYzM323g2ZnZnM9OY2gfCylKgQUAOiYKpEkIcR0JKSQoVYlDwErBLw" +
       "gSgPi9IoUIKWQsnL/++e2XnszBxrUl7V9M3O9N/9f3///f1/d8+hN8kUyyQL" +
       "qcZSbLdBrVSfxgYl06K5XlWyrK3wLCt/rUb658VHNp2RJHUjZPq4ZA3IkkXX" +
       "K1TNWSOkU9EsJmkytTZRmkOJQZNa1NwlMUXXRshMxeovGKoiK2xAz1GsMCyZ" +
       "GdImMWYqo0VG++0GGOnMgCZprkl6TfB1T4Y0ybqx260+x1O91/MGaxbcvixG" +
       "WjOXSLukdJEpajqjWKynZJITDV3dPabqLEVLLHWJeqptgo2ZUytMsOT+ln+/" +
       "d8N4KzdBh6RpOuPwrC3U0tVdNJchLe7TPpUWrJ3kclKTIY2eyox0ZZxO09Bp" +
       "Gjp10Lq1QPtmqhULvTqHw5yW6gwZFWJksb8RQzKlgt3MINcZWqhnNnYuDGgX" +
       "ldEKlBUQbzwxfeBrF7f+oIa0jJAWRRtCdWRQgkEnI2BQWhilprUml6O5EdKm" +
       "wWAPUVORVGWPPdLtljKmSawIw++YBR8WDWryPl1bwTgCNrMoM90sw8tzh7J/" +
       "Tcmr0hhgneViFQjX43MA2KCAYmZeAr+zRWp3KFqOkeOCEmWMXedCBRCdWqBs" +
       "XC93VatJ8IC0CxdRJW0sPQSup41B1Sk6OKDJyLzIRtHWhiTvkMZoFj0yUG9Q" +
       "vIJa07ghUISRmcFqvCUYpXmBUfKMz5ubztx/qbZBS5IE6Jyjsor6N4LQwoDQ" +
       "FpqnJoV5IASblmdukmb9dF+SEKg8M1BZ1PnRZW9/esXCw0+IOvND6mwevYTK" +
       "LCvfPjr9Vwt6u8+oQTXqDd1ScPB9yPksG7Tf9JQMYJhZ5RbxZcp5eXjLYxdc" +
       "eQ99PUka+kmdrKvFAvhRm6wXDEWl5jlUo6bEaK6fTKNarpe/7ydT4T6jaFQ8" +
       "3ZzPW5T1k1qVP6rT+W8wUR6aQBM1wL2i5XXn3pDYOL8vGYSQZrjIerhaiPjj" +
       "/xmh6XG9QNOSLGmKpqcHTR3x44BqOSnNqAX3OXhr6GmrqOVVfSJtmXJaN8fK" +
       "v2XdpGljXGe6VpCM9DmqPiqpg/z3gGSk0N2M/1dHJUTcMZFIwGAsCFKBCrNo" +
       "g67mqJmVDxTX9r19b/Yp4WY4NWxbMbIc+kzZfaawz1S5z1SgT5JI8K5mYN9i" +
       "zGHEdsDcB/Jt6h66aOP2fUtqwNmMiVowN1Zd4gtCvS5BOKyelf+x8dVVG/Z+" +
       "8rkkSQKHjEIQcmPBIk8swCBm6jLNARVFxQSHF9PRUSBUB3L45omrhq84mevg" +
       "JXdscArwEooPIiWXu+gKTuqwdluuOfLv+27aq7vT2xctnCBXIYmssSQ4oEHw" +
       "WXn5IumB7E/3diVJLVAR0C+TYLoAsy0M9uFjjx6HiRFLPQDO62ZBUvGVQ58N" +
       "bNzUJ9wn3NPa+P0MGNpGnE7z4Oq05xf/j29nGVjOFp6JvhJAwZn+U0PGN3/3" +
       "y7+u4uZ2gkKLJ5oPUdbjISJsrJ1TTpvreltNSqHeH28e/OqNb16zjfsd1Fga" +
       "1mEXlr1AQDCEYObPPbHzhZdfuv35pOurDCJxcRQSmlIZJD4nDTEgobdlrj5A" +
       "ZCrMcfSarvM18Eolr0ijKsXJ8X7L8ac88Mb+VuEHKjxx3GjF5A24z+euJVc+" +
       "dfE7C3kzCRkDqWszt5pg5w635TWmKe1GPUpXPdv59celbwLPA7dayh7K6bKG" +
       "26DGP18xrxsqjlow65QCDMMuO/KsHNwu7+safE1ElbkhAqLezLvS1w3/9pKn" +
       "+SDX47zG54i72TNr15hjHg9rFcb/CP4ScH2IFxodHwgGb++1w8iichwxjBJo" +
       "3h2T+PkBpPe2v7zj1iPfEwCCcTZQme478MWPUvsPiJETycjSinzAKyMSEgEH" +
       "i9NRu8VxvXCJ9X+5b++P79p7jdCq3R9a+yBz/N5vPng6dfMrT4ZweI1iJ5Sr" +
       "0JXL5DvDPzYC0LovtPzkhvaa9cAZ/aS+qCk7i7Q/520RcimrOOoZLDfJ4Q+8" +
       "0HBgGEkshzHAB6u5FqfasPHfJz33ZzGc7LpUoSv+XFfiLXyCv0uXaxBeg/B3" +
       "GSy6LC/3+sfak29n5Ruef6t5+K2H3+b28ifsXqqBuCYGqw2L43GwZgfj2wbJ" +
       "God6nzi86cJW9fB70OIItChDlmptNiHAlnzEZNeeMvX3P3t01vZf1ZDketIA" +
       "sHPrJc7xZBqQK7XGITaXjLM/Lbhloh6KVg6VVIDH6XxcOFH0FQzGp/aeB2f/" +
       "8Mw7D77EOU3Yez4Xb8LkwBeG+SLPjSL3PLf613d++aYJ4Xkx8yggN+c/m9XR" +
       "q//0boWBedAMmVoB+ZH0oVvn9Z71Opd3oxdKLy1VJjQQ313ZlfcU/pVcUvfz" +
       "JJk6Qlple1E1LKlFjAkjsJCwnJUWLLx87/2LApEB95Sj84Lg3PZ0G4yb3ilT" +
       "y3zTww2VTTiC3c7gOv+9oTJB+M1FXGQZL7uxWOFEpqmGqcDCmwZCU2NMo4w0" +
       "iDQOXQOjYghN88KzFtEvbGu87d4havNiiISn8v4fPzQyckKrLCqHhY3AguWu" +
       "O+vlFwuP8bCBKp7mUj0Jp/q57iQtB7AUXy0Lxu/0OXVQwVc3LWjQdwy2CQWX" +
       "R3t1UPA65eAzv/hXy1Vh04Gvym3RoNwLv6tZ2ci6rufxrhbjHV/Kgc9YWBOT" +
       "2cgVPm9L0NB0LMbFUM9hoVEcX+l+fncMkJVLM7fO6G467xWh/uJJcGfl/kJ2" +
       "6IEXrjmNz8KWXQpkXGLDR+yxzPLtsTjJfo9v7yHUMln5yH3XPbH4b8MdfFEp" +
       "jICabwI6w//n2dSX4NSXtGPWfB8mWw+eBmXlp1coq+v/8PzdAtrxEdD8Mpfd" +
       "+uEzf9370pM1pA6yWpzjkglLT1jbpqJ2bbwNdG2Fu3UgBXN/upBWtDE+6vbo" +
       "tpeflhN0Rk6KaptnI5WLGAgPE9Rcqxe1HKc/P7c0FA3D+5b7ScvRzZ/LIfX8" +
       "GAYs47d5hrRz20/nXokEylMT70tIRzp6M2uGhrJbLxjsyw6v2dK/Zm2mj/us" +
       "AS8TfY5rt7qNCBYuO/0pH39N2iXuSt6IR0rhCYZYk2A5gMXFotpgZAj+jJ/E" +
       "Mf1vs5G2RZD4lwSJY7G9kq2jpJHiOQzLCidePn6CZi5sfOwR69t//oHDo3m/" +
       "ku1xSlrRswYc09PJwe8s/eUVB5e+yjOdesUCJ4BEPWQryyPz1qGXX3+2ufNe" +
       "vhgt819zcA+wcovPt3MnfBuLrxyFOxiGQT6WD1xbpQ8stE3smDrMB26J9YEo" +
       "aUaaLcgOaU4g4IKrA9reWqW2S+DqsPvriND2tlhto6QZaRuX1PzQZBp/u0qN" +
       "Z8E1w+5zRoTGd8dqHCUNaw9VH1uphWl5T5Va4s7HTLufmRFa3h+rZZQ0I9OA" +
       "T8+R2LhIhIOafr9KTY+zberYNkzTH8VqGiXNSNMYV3OLlFOKXG59QNkH/wdl" +
       "Z9vdzY5Q9uFYZaOkGakbxfBpOZSywEspBcCR4uEVovhaPcgRj1QJYxFcc2xF" +
       "5kTAeDwWRpQ0I43jkoUG50dz+CxmrT11VNdVKmkfiwifqBLkfLjm2mrOjQD5" +
       "XCzIKGlG6gtSaRATojCner5KRRcQMV+J8z9E0d/HKholDXMVFI12/xer1HSO" +
       "bVbHvGGavhqraZQ0+AKwSl9BYWGc8qcYPUvhi9Ik3p6E2zmKJqnuupT/IRjf" +
       "uYtHE0+WlnDmYndFeA8E9X4nY+CrvqjDNL6LdvvVBw7mNt9xipMdnQ2DxHTj" +
       "JJXuoqqn8+aK9eMAT0LcHYaGz5/ckWGlfOWxBLayMOLgIWadGezg8av/Nm/r" +
       "WePbqzhzOC6APdjk3QOHnjxnmfyVJD8BFRsaFSenfqGewFIDVi9FU/Pv9S3x" +
       "7/ufDNcJ9vieEPRT17e4ky6v3E2PEg1s/HnI6lHe6vsxO4MfYvEO3ymhsBKl" +
       "YXRYu0tXcq7XvzvZ7PRtwOGD8/njf/qNsQWulI0oVb0xokQDWGu5HrXOjOms" +
       "mDFD4xIGLzzep06tORUxbpjiBuQqp8JsbwWlII1R3FrUkXYTrah8ojHa5okO" +
       "LOqAA3jaij9I2bqJqUdtXU6Jp8B1um2i0yexbggfRomGu5pjljOqWG5souht" +
       "zM6AuV06Y2y2GAvoolnVZRgpN3H22m7usbEdhquttgG2Vm+7KNEYdCfGvDsJ" +
       "i2WYlEiqTaJezCccG8wDcG23Fd9ePeYo0fDZiD+/vNMJqKLgWFfH2OEMLFYy" +
       "Mt22wxAdK0AcCphj1bExx1K4HrIxPVS9OaJEA/CSbkrgMUJvjBFwNyiBlGxN" +
       "SEYA+tnHhpdxufKBrf8Hk0AP4eUo0RhQm2PenYfFRoafrCjBsT732ADuAgaz" +
       "12qJipXepIAjRWNAbYt5dxEWw4y0Q0DGD3+KjDrLlgD8zxw1fL7NBWl+YtjG" +
       "MFw9/CjRcFcPDaA8wg7qisZWIa7p3A5jMTbagcUorOnGKPMap9U1jnzUxuEb" +
       "N8sA2Ss2wleqN06UaAy2Ysy7CSxwm1hSwW7rlHy+aFFcfsuU728/7eLfeWzw" +
       "d4Pyr9kgXqsef5RoDMarYt59FovLGJnF8W+hefswN9wEe4+dCY7YOI5Ub4Io" +
       "0RiY18W8ux6LfR4TmFKMCb5w1Cbgy1CgtsQbNo43qjdBlGgMzK/HvLsFiwOB" +
       "lbmL+cbqMZcYaQnkp/jhwJyKb4TFd63yvQdb6mcfPP+3YsPe+fa0KUPq80VV" +
       "9Z5te+7rgNDzCjdXkzjp5l9+JG5jZF503gyr8PI9T3e/JaTuYKQ1KAVREv95" +
       "q90FJOmpxvADFX7nrfRdRmqgEt4eMhyGrjxjEmm+76CIrwdnTmbwsoj3G7Pg" +
       "0edAUXysnZXvO7hx06Vvn3aH+MZNVqU9e7CVxgyZKj63443WVJzReltz2qrb" +
       "0P3e9PunHe/sarQJhV2fne86FjkffJQP/LzA0bHVVT4GfOH2Mx9+Zl/ds0mS" +
       "2EYSEnDxtspvIkpG0SSd2zKVXxE5p4M93d/YfdaK/N9f5B+dEHGCuyC6flae" +
       "9p/9exZbiVSSTOsnUxQtR0v8Y411u7UtVN5l+j5JsvdsuZ2ijl+bfcevjCyp" +
       "/DZr0uPW5tjjVrEH0ovF6SW0MvhZNjNgGM5J67Xc6obBM9lH8Me6/wIDYXIG" +
       "gzEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JcJdGiWRTNNSt9z2Oyk3HeF9gSbrMDES");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
