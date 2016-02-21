package org.sunflow.core.renderer;
public class SimpleRenderer implements org.sunflow.core.ImageSampler, ent.runtime.ENT_Attributable {
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.Display display;
    private int imageWidth;
    private int imageHeight;
    private int numBucketsX;
    private int numBucketsY;
    private int bucketCounter;
    private int numBuckets;
    public int ENT_attribute() { int batteryMode = org.sunflow.BatteryContext.
                                                     batteryMode;
                                 if (batteryMode == 2) { return org.sunflow.EntMode.
                                                                  HIGH_MODE;
                                 }
                                 else
                                     if (batteryMode ==
                                           1) {
                                         return org.sunflow.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return org.sunflow.EntMode.
                                                  LOW_MODE;
                                     } }
    public boolean prepare(org.sunflow.core.Options options, org.sunflow.core.Scene scene,
                           int w,
                           int h) { this.scene = scene;
                                    imageWidth = w;
                                    imageHeight = h;
                                    numBucketsX = imageWidth +
                                                    31 >>>
                                                    5;
                                    numBucketsY = imageHeight +
                                                    31 >>>
                                                    5;
                                    numBuckets = numBucketsX *
                                                   numBucketsY;
                                    return true; }
    public void render(org.sunflow.core.Display display) {
        this.
          display =
          display;
        display.
          imageBegin(
            imageWidth,
            imageHeight,
            32);
        bucketCounter =
          0;
        org.sunflow.system.Timer timer =
          new org.sunflow.system.Timer(
          );
        timer.
          start(
            );
        java.lang.Thread[] renderThreads =
          new java.lang.Thread[scene.
                                 getThreads(
                                   )];
        for (int i =
               0;
             i <
               renderThreads.
                 length;
             i++) {
            renderThreads[i] =
              new org.sunflow.core.renderer.SimpleRenderer.BucketThread(
                );
            renderThreads[i].
              start(
                );
        }
        for (int i =
               0;
             i <
               renderThreads.
                 length;
             i++) {
            try {
                renderThreads[i].
                  join(
                    );
            }
            catch (java.lang.InterruptedException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      BCKT,
                    "Bucket processing thread %d of %d was interrupted",
                    i +
                      1,
                    renderThreads.
                      length);
            }
        }
        timer.
          end(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              BCKT,
            "Render time: %s",
            timer.
              toString(
                ));
        display.
          imageEnd(
            );
    }
    private class BucketThread extends java.lang.Thread {
        public void run() { org.sunflow.core.IntersectionState istate =
                              new org.sunflow.core.IntersectionState(
                              );
                            while (true) { int bx;
                                           int by;
                                           synchronized (SimpleRenderer.this)  {
                                               if (bucketCounter >=
                                                     numBuckets)
                                                   return;
                                               by =
                                                 bucketCounter /
                                                   numBucketsX;
                                               bx =
                                                 bucketCounter %
                                                   numBucketsX;
                                               bucketCounter++;
                                           }
                                           renderBucket(bx,
                                                        by,
                                                        istate);
                            } }
        public BucketThread() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1450193775000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "Q7G9tv1fJcv0c44TAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1450193775000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "oqKnu/3D1/3+2377hW8UfaX/AZdl8MuwHgAA");
    }
    public void renderBucket(int bx, int by, org.sunflow.core.IntersectionState istate) {
        int x0 =
          bx *
          32;
        int y0 =
          by *
          32;
        int bw =
          java.lang.Math.
          min(
            32,
            imageWidth -
              x0);
        int bh =
          java.lang.Math.
          min(
            32,
            imageHeight -
              y0);
        org.sunflow.image.Color[] bucketRGB =
          new org.sunflow.image.Color[bw *
                                        bh];
        for (int y =
               0,
               i =
                 0;
             y <
               bh;
             y++) {
            for (int x =
                   0;
                 x <
                   bw;
                 x++,
                   i++) {
                org.sunflow.core.ShadingState state =
                  scene.
                  getRadiance(
                    istate,
                    x0 +
                      x,
                    imageHeight -
                      1 -
                      (y0 +
                         y),
                    0.0,
                    0.0,
                    0.0,
                    0);
                bucketRGB[i] =
                  state !=
                    null
                    ? state.
                    getResult(
                      )
                    : org.sunflow.image.Color.
                        BLACK;
            }
        }
        display.
          imageUpdate(
            x0,
            y0,
            bw,
            bh,
            bucketRGB);
    }
    public SimpleRenderer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1450193775000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "v98LwXOiKIA1G1xjH4lw91/V/ErZHB4AAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.sunflow.core.renderer.SimpleRenderer ENT_ld =
          new org.sunflow.core.renderer.SimpleRenderer(
          );
        ENT_ld.
          scene =
          this.
            scene;
        ENT_ld.
          display =
          this.
            display;
        ENT_ld.
          imageWidth =
          this.
            imageWidth;
        ENT_ld.
          imageHeight =
          this.
            imageHeight;
        ENT_ld.
          numBucketsX =
          this.
            numBucketsX;
        ENT_ld.
          numBucketsY =
          this.
            numBucketsY;
        ENT_ld.
          bucketCounter =
          this.
            bucketCounter;
        ENT_ld.
          numBuckets =
          this.
            numBuckets;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1450193775000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oXaeeYcuAAA=");
}
