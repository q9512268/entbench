package org.sunflow.core.renderer;
public class ProgressiveRenderer implements org.sunflow.core.ImageSampler, ent.runtime.ENT_Attributable {
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.Display display;
    private int imageWidth;
    private int imageHeight;
    private int[] sigma;
    private java.util.concurrent.PriorityBlockingQueue<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket>
      smallBucketQueue;
    private int counter;
    private int counterMax;
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
    public ProgressiveRenderer() { super();
                                   imageWidth = 640;
                                   imageHeight = 480;
                                   sigma = null;
                                   smallBucketQueue = null;
    }
    public boolean prepare(org.sunflow.core.Options options,
                           org.sunflow.core.Scene scene,
                           int w,
                           int h) { this.scene = scene;
                                    imageWidth = w;
                                    imageHeight = h;
                                    sigma = org.sunflow.math.QMC.
                                              generateSigmaTable(
                                                1 <<
                                                  7);
                                    return true; }
    public void render(org.sunflow.core.Display display) {
        this.
          display =
          display;
        display.
          imageBegin(
            imageWidth,
            imageHeight,
            0);
        org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket b =
          new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket(
          );
        b.
          x =
          (b.
             y =
             0);
        int s =
          java.lang.Math.
          max(
            imageWidth,
            imageHeight);
        b.
          size =
          1;
        while (b.
                 size <
                 s)
            b.
              size <<=
              1;
        smallBucketQueue =
          new java.util.concurrent.PriorityBlockingQueue<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket>(
            );
        smallBucketQueue.
          add(
            b);
        org.sunflow.system.UI.
          taskStart(
            "Progressive Render",
            0,
            imageWidth *
              imageHeight);
        org.sunflow.system.Timer t =
          new org.sunflow.system.Timer(
          );
        t.
          start(
            );
        counter =
          0;
        counterMax =
          imageWidth *
            imageHeight;
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
              new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucketThread(
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
                      IPR,
                    "Thread %d of %d was interrupted",
                    i +
                      1,
                    renderThreads.
                      length);
            }
        }
        org.sunflow.system.UI.
          taskStop(
            );
        t.
          end(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              IPR,
            "Rendering time: %s",
            t.
              toString(
                ));
        display.
          imageEnd(
            );
    }
    private class SmallBucketThread extends java.lang.Thread {
        public void run() { org.sunflow.core.IntersectionState istate =
                              new org.sunflow.core.IntersectionState(
                              );
                            while (true) {
                                int n =
                                  progressiveRenderNext(
                                    istate);
                                synchronized (ProgressiveRenderer.this)  {
                                    if (counter >=
                                          counterMax)
                                        return;
                                    counter +=
                                      n;
                                    org.sunflow.system.UI.
                                      taskUpdate(
                                        counter);
                                }
                                if (org.sunflow.system.UI.
                                      taskCanceled(
                                        ))
                                    return;
                            } }
        public SmallBucketThread() { super(
                                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1450193753000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "EyZ/WVJzCoZiu237v8II64msEwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1450193753000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private int progressiveRenderNext(org.sunflow.core.IntersectionState istate) {
        final int TASK_SIZE =
          16;
        org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket first =
          smallBucketQueue.
          poll(
            );
        if (first ==
              null)
            return 0;
        int ds =
          first.
            size /
          TASK_SIZE;
        boolean useMask =
          !smallBucketQueue.
          isEmpty(
            );
        int mask =
          2 *
          first.
            size /
          TASK_SIZE -
          1;
        int pixels =
          0;
        for (int i =
               0,
               y =
                 first.
                   y;
             i <
               TASK_SIZE &&
               y <
               imageHeight;
             i++,
               y +=
                 ds) {
            for (int j =
                   0,
                   x =
                     first.
                       x;
                 j <
                   TASK_SIZE &&
                   x <
                   imageWidth;
                 j++,
                   x +=
                     ds) {
                if (useMask &&
                      (x &
                         mask) ==
                      0 &&
                      (y &
                         mask) ==
                      0)
                    continue;
                int instance =
                  (x &
                     sigma.
                       length -
                     1) *
                  sigma.
                    length +
                  sigma[y &
                          sigma.
                            length -
                          1];
                double time =
                  org.sunflow.math.QMC.
                  halton(
                    1,
                    instance);
                double lensU =
                  org.sunflow.math.QMC.
                  halton(
                    2,
                    instance);
                double lensV =
                  org.sunflow.math.QMC.
                  halton(
                    3,
                    instance);
                org.sunflow.core.ShadingState state =
                  scene.
                  getRadiance(
                    istate,
                    x,
                    imageHeight -
                      1 -
                      y,
                    lensU,
                    lensV,
                    time,
                    instance);
                org.sunflow.image.Color c =
                  state !=
                  null
                  ? state.
                  getResult(
                    )
                  : org.sunflow.image.Color.
                      BLACK;
                pixels++;
                display.
                  imageFill(
                    x,
                    y,
                    java.lang.Math.
                      min(
                        ds,
                        imageWidth -
                          x),
                    java.lang.Math.
                      min(
                        ds,
                        imageHeight -
                          y),
                    c);
            }
        }
        if (first.
              size >=
              2 *
              TASK_SIZE) {
            int size =
              first.
                size >>>
              1;
            for (int i =
                   0;
                 i <
                   2;
                 i++) {
                if (first.
                      y +
                      i *
                      size <
                      imageHeight) {
                    for (int j =
                           0;
                         j <
                           2;
                         j++) {
                        if (first.
                              x +
                              j *
                              size <
                              imageWidth) {
                            org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket b =
                              new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket(
                              );
                            b.
                              x =
                              first.
                                x +
                                j *
                                size;
                            b.
                              y =
                              first.
                                y +
                                i *
                                size;
                            b.
                              size =
                              size;
                            b.
                              constrast =
                              1.0F /
                                size;
                            smallBucketQueue.
                              put(
                                b);
                        }
                    }
                }
            }
        }
        return pixels;
    }
    private static class SmallBucket implements java.lang.Comparable<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket> {
        int x;
        int y;
        int size;
        float constrast;
        public int compareTo(org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket o) {
            if (constrast <
                  o.
                    constrast)
                return -1;
            if (constrast ==
                  o.
                    constrast)
                return 0;
            return 1;
        }
        public SmallBucket() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1450193753000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Vgr9Ptt1TWOH9jWWOv4F3nrCx0sdAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1450193753000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1450193753000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9W9/UqBghlo+xYSHfiS6/4653ee9z+ht+KDUS3OFSQUA1qY9dV/mw/CS8t+F" +
       "UcUIqhfN8nZYkLM0KEegpDOsmhdKYNe4uzzjtUhnHh7ne6HLsa0XuOxkBn06" +
       "m/ZrPFg1k1pwETxNZhg3ebEqhFjnAkaynLUraLPSgoYKTZfgCIQ92FBdZFEC" +
       "hzERSh5GMQcitSDTxukwh0nankmbDXyHcwKdssst1nx4ZpkczAoQa5CLRZuN" +
       "hfwHUYPQKcnQZGHSkmBOgQTr+ASPDPFpykBRtcXkoiVAhkuLyhBETcALM1Cw" +
       "XyylyJi7GKGn13g2aUBJIWUgx4yb9fWpA1vEXe0Df+eh2OpDwOc13x+9cfiV" +
       "rc+yDFZJi5Yhy/0cJUmXPupIn/Wc8y/hJwTPF/ShHNMX9DfERbdZLC/KV8ua" +
       "RgGxCCZ4BIjuaHxj2x1HHuQCeAHAMxnv2vP9LyO79/C0xI9cSwtOPU4afuzi" +
       "4tBGpNwtLrYLo1j/zsEdj96/YyfnqtF9gOiB8/GDf/zPs5Hb3nzap0Ytkcxj" +
       "MwXkUL6ynOW2DRdo3ffqfnVTY8l6KIh6UWVWka7I4t6UGygqjGzSYSz7KGeD" +
       "hykaNQxBoQ6wgcfHN38NPs4oLiOomvnsBiyNjrEqIenZm0xz7znwzDb3nh2w" +
       "d65ofAVRU4yTRjOC+9YpHyms6uB22Vz9xG+Mu//xMLe/Xxx6zrn331cp/jnz" +
       "BItDupeQ56qWMtEAzzyTq3k8dpL/p3OXZjlvdEiXIEHJuA9KBet09w3sQiNq" +
       "WXC8O7Q69ZOlz18ztfQtVg5VSgZkSkAcn5sHB80H+994/8WaBQfYkaGUApcZ" +
       "B+4rm8IbGddFC7NJHW2uZd1kQYAyR+QTTB/b6Z9ew7S7ClwpLSmCzFaDwrZc" +
       "xsooP9qz5gazoqJbhDmdlZd4nUtriUi3rCqYlszWGD+pSmokf7sFgzkfNFng" +
       "qs/6mKh2sVP13ZObYiSXLjyi0pXaAg6hHcFG9G7w5PXvzR06b2zLNM6fCz02" +
       "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");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.sunflow.core.renderer.ProgressiveRenderer ENT_ld =
          new org.sunflow.core.renderer.ProgressiveRenderer(
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
          sigma =
          this.
            sigma;
        ENT_ld.
          smallBucketQueue =
          this.
            smallBucketQueue;
        ENT_ld.
          counter =
          this.
            counter;
        ENT_ld.
          counterMax =
          this.
            counterMax;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1450193753000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SSivlSSz43pWPZ/PMYvquOkg9XKV65en");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "OkH6QUH8uw//zrt//bWvpDvf/w/2t1ycIzkAAA==");
}
