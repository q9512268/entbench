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
           "zvaLj/7S9/7Ll/5wtz38fwFG4yqwWywA");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          "AA==";
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
           "bS8dLAAA");
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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Fd9+8H9u66DI4TEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "E1h1bpXGPbtO8PV+RRs0ViGDTjq1Lrzp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("F7sp2RsOih45DKS1vxZDuGPaakKjddSjB4jIAz/IjhiujwyTYA6ktRoTjEH7" +
       "zLytGEbRDOlmschQsREiQar4JbIqLhAQUE0EhUyoYAkv/AkPdtxaF4mggdmf" +
       "EvVqacQsDM0zUoLlmn3XbCGWv3QGPdaYSMAIK3FiVeCONqotIZmGfVJtzgOk" +
       "bNerPZ1s9bpIzesTxJgjmUm/NJmR7GQ8qE7b3YE9ngJfMRpOHFTqrLoGYZhz" +
       "GIO88XJt9d2GplpEOqFSuNxp9PrEEJ3xcZlScAvIkpSaKsVRZSKZSSzOUI6a" +
       "dBR8GkQVcRUYTq/bVPyOaeqBOURVfjw3OlSLoKvegPMbDC+j/WZrSVD1YtA3" +
       "50GrPdN69KQuhmkdHzfJ5URu63OcHCPIxG7ZsyofOnTTgeIeRZpcAIWxxpeM" +
       "6UgncV+ft0aLai1kRkZVIz3JGEptaIqs/XK8VEqjkSrh6WToRf1KeTRcUW18" +
       "7vNrIB/YTNqVpGSUMXTSDjR9qRcnMCaMeKWxQSprk5IqlSJabhMc560q7Kyo" +
       "V1ZoNIwrG7FPqBgvezNCHFqqzE860ips8suxz3OiDNdXioSHVQ+j6LTcbaL+" +
       "BvPoplXBVQiaUFIi6yG2WgcthV8EXbEdSWa68YsyiVAqiFU4OvTDsNREUxid" +
       "9iwXdyk6LDcnosbCi3Vt0B41ZlHUVKM11t7waLrQm5028CM4auOqAtGCFq9J" +
       "l523rGRUlC1OEDDZ5bX1qCeO1jY84JtGvMHa1rQ4KuIIX2QH7GBUq+AVvbTB" +
       "gr7KVEqYH0WqAFlIQoZi35XHxaZat9KSqFqd6iZqKkk806OZWkGDyrQmh1ht" +
       "YVuSFDDmol/lxm2rvYb0pUK4/nTSS6vd9rI9L9YobMXJnodHSMQho3DVjxql" +
       "AQPjfIRRKl7EaDys1ZrtypCs1+tve1v2CPKPbuzR6H35U+DDw80LC80KvnID" +
       "Tz+T0wc8fzjgl48O3eV/2eP0E+dkjz1JP/am/vDA2nNXvfLff9HfPnh7nb07" +
       "ffys08/5e9NPvvell9XeL8PndycBXggKdwSO+xZLizTr2Oh3XfsQEJu/HT86" +
       "a/Xb7/3TR4c/brzjBo6YPrmHc7/Lf8F++kutNyt//3zhpsOTV1cdSz/Z6Pm9" +
       "wyGeFoSePTxx6urxk8c8S+B6bjcZz+2/1jjSgtPfafzoVov2jgyeO6rwK3mF" +
       "71/jTOGfZ8n38vNbmit72qnP4yPHVI+U8X//sEfxx8fIM/7XyVc58O46uL8h" +
       "zuS1OB+o7N+6kVMqnJbxDnavv7Puz91ytsTO3ZElhaBwt+UocqAde2v+F4cy" +
       "Onfu1cooe7nK7mTEvjYyOk7igWuUPZgl9wCVmMlWptV71C6+WmoZncmO2uS1" +
       "oXZzXuHm7Gf+hcA7j5Kc0pPXoPt0ljwaFO7Z0RW0+UrbHtA4xvoNr5b1M+D6" +
       "jR3r33htWJ8/cvTHuBavwfUtWfJmYNFgr+XuMfyRV8Ewd2UDcH1+x/DzN8rw" +
       "dFe2m9cDs378KrMWDDk7JJB95qQd1HrkqrMEIy07eIwcVHj4eAVzJc+17HS4" +
       "k709P/fWXE7oNWT4E1lSDgq35Eea9oSIvFohZidnvrAT4hdeGyEeB9++Rlk3" +
       "S5pB9p2Nua/+5KvllZV/bcfra68Nr6N17hyWExCvQW6cJXxQuDDXAkFeuZa2" +
       "77L7r4Jifl76zQDM+7Ztt/9f26mTr1GmZMlPBoUHZAvodNPU9dDXshM0iqae" +
       "tqLfNnMcS5PtI/Y/9WrZPwuIvLhj/+Jrz969RlluuMug8FDOfqDpuy81dgLI" +
       "SrUjptZrwfSDO6YffO2ZvusaZT+TJfExpp58DabJq2B6McsEzujch3dMP/za" +
       "M33/Nco+kCXv2zutc0Tt79wItSQo3Lsf9WXf8Dxy1de02y9Alc+8fPH2h18W" +
       "v7Y9tXvwleYdTOF2PbSs419UHLu/FUTQupmTvmP7fYWbM/mFoPDo2eEo2P4c" +
       "3mfAz31k2+olgHm/FXDN2b/j1T4WFO48Vg3Ia3d3vNI/Cgo3gUrZ7T/OJ09O" +
       "tpHyI8fnPo/t7/9hcj1scvxbsP1vB9hw+wnzFeWzL3e4d36v9svbb9EUS95s" +
       "sl5uZwq3bT+LyzvNtmNPn9nbQV+30s/+4J5fu+NNB1vHe7aAj/TwGLYnT//w" +
       "i1y5QX7YfvObD//rt/6zl7+Rn2z6/5FUaqFZPgAA");
}
