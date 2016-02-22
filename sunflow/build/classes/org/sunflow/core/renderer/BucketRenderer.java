package org.sunflow.core.renderer;
public class BucketRenderer implements org.sunflow.core.ImageSampler, ent.runtime.ENT_Attributable {
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.Display display;
    private int imageWidth;
    private int imageHeight;
    private java.lang.String bucketOrderName;
    private org.sunflow.core.BucketOrder bucketOrder;
    private int bucketSize;
    private int bucketCounter;
    private int[] bucketCoords;
    private boolean dumpBuckets;
    private int minAADepth;
    private int maxAADepth;
    private int superSampling;
    private float contrastThreshold;
    private boolean jitter;
    private boolean displayAA;
    private double invSuperSampling;
    private int subPixelSize;
    private int minStepSize;
    private int maxStepSize;
    private int[] sigma;
    private float thresh;
    private boolean useJitter;
    private java.lang.String filterName;
    private org.sunflow.core.Filter filter;
    private int fs;
    private float fhs;
    public int ENT_attribute() { if (useBat) { if (ent.runtime.ENT_Util.Battery.
                                                     percentRemaining(
                                                       ) >=
                                                     0.75) { return org.sunflow.EntMode.
                                                                      HIGH_MODE;
                                               }
                                               else
                                                   if (ent.runtime.ENT_Util.
                                                         Battery.
                                                         percentRemaining(
                                                           ) >=
                                                         0.5) {
                                                       return org.sunflow.EntMode.
                                                                MID_MODE;
                                                   }
                                                   else {
                                                       return org.sunflow.EntMode.
                                                                LOW_MODE;
                                                   }
                                 }
                                 else {
                                     if (this.
                                           maxAADepth >=
                                           2) {
                                         return org.sunflow.EntMode.
                                                  LOW_MODE;
                                     }
                                     else
                                         if (this.
                                               maxAADepth >=
                                               1) {
                                             return org.sunflow.EntMode.
                                                      MID_MODE;
                                         }
                                         else {
                                             return org.sunflow.EntMode.
                                                      HIGH_MODE;
                                         }
                                 } }
    private boolean useBat = false;
    public BucketRenderer() { super();
                              bucketSize = 32;
                              bucketOrderName = "hilbert";
                              displayAA = false;
                              contrastThreshold =
                                0.1F;
                              filterName = "box";
                              jitter = false;
                              dumpBuckets = false;
                              java.lang.String useBatStr =
                                java.lang.System.
                                getenv(
                                  "PANDA_BATTERY_RUN");
                              if (useBatStr != null &&
                                    useBatStr.
                                    equals(
                                      "true")) { useBat =
                                                   true;
                              } }
    public void preprepare(org.sunflow.core.Options options) {
        minAADepth =
          options.
            getInt(
              "aa.min",
              minAADepth);
        maxAADepth =
          options.
            getInt(
              "aa.max",
              maxAADepth);
    }
    public boolean prepare(org.sunflow.core.Options options,
                           org.sunflow.core.Scene scene,
                           int w,
                           int h) { java.lang.String recovstr =
                                      java.lang.System.
                                      getenv(
                                        "PANDA_RECOVER");
                                    boolean recover =
                                      true;
                                    if (recovstr !=
                                          null &&
                                          recovstr.
                                          equals(
                                            "false")) {
                                        recover =
                                          false;
                                    }
                                    try { this.scene =
                                            ent.runtime.ENT_Snapshot.
                                              snapshot(
                                                scene,
                                                org.sunflow.EntMode.
                                                  LOW_MODE,
                                                ent.runtime.ENT_Runtime.
                                                  getObjMode(
                                                    this,
                                                    0),
                                                false);
                                    }
                                    catch (java.lang.RuntimeException e) {
                                        this.
                                          scene =
                                          ent.runtime.ENT_Snapshot.
                                            forceSnapshot(
                                              scene,
                                              org.sunflow.EntMode.
                                                LOW_MODE,
                                              ent.runtime.ENT_Runtime.
                                                getObjMode(
                                                  this,
                                                  0),
                                              false);
                                        if (recover) {
                                            maxAADepth =
                                              0;
                                        }
                                    }
                                    imageWidth = w;
                                    imageHeight =
                                      h;
                                    bucketSize = options.
                                                   getInt(
                                                     "bucket.size",
                                                     bucketSize);
                                    bucketOrderName =
                                      options.
                                        getString(
                                          "bucket.order",
                                          bucketOrderName);
                                    superSampling =
                                      options.
                                        getInt(
                                          "aa.samples",
                                          superSampling);
                                    displayAA = options.
                                                  getBoolean(
                                                    "aa.display",
                                                    displayAA);
                                    jitter = options.
                                               getBoolean(
                                                 "aa.jitter",
                                                 jitter);
                                    contrastThreshold =
                                      options.
                                        getFloat(
                                          "aa.contrast",
                                          contrastThreshold);
                                    bucketSize = org.sunflow.math.MathUtils.
                                                   clamp(
                                                     bucketSize,
                                                     16,
                                                     512);
                                    int numBucketsX =
                                      (imageWidth +
                                         bucketSize -
                                         1) /
                                      bucketSize;
                                    int numBucketsY =
                                      (imageHeight +
                                         bucketSize -
                                         1) /
                                      bucketSize;
                                    bucketOrder =
                                      org.sunflow.core.bucket.BucketOrderFactory.
                                        create(
                                          bucketOrderName);
                                    bucketCoords =
                                      bucketOrder.
                                        getBucketSequence(
                                          numBucketsX,
                                          numBucketsY);
                                    minAADepth =
                                      org.sunflow.math.MathUtils.
                                        clamp(
                                          minAADepth,
                                          -4,
                                          5);
                                    maxAADepth =
                                      org.sunflow.math.MathUtils.
                                        clamp(
                                          maxAADepth,
                                          minAADepth,
                                          5);
                                    superSampling =
                                      org.sunflow.math.MathUtils.
                                        clamp(
                                          superSampling,
                                          1,
                                          256);
                                    invSuperSampling =
                                      1.0 /
                                        superSampling;
                                    subPixelSize =
                                      maxAADepth >
                                        0
                                        ? 1 <<
                                        maxAADepth
                                        : 1;
                                    minStepSize =
                                      maxAADepth >=
                                        0
                                        ? 1
                                        : 1 <<
                                        -maxAADepth;
                                    if (minAADepth ==
                                          maxAADepth)
                                        maxStepSize =
                                          minStepSize;
                                    else
                                        maxStepSize =
                                          minAADepth >
                                            0
                                            ? 1 <<
                                            minAADepth
                                            : subPixelSize <<
                                            -minAADepth;
                                    useJitter =
                                      jitter &&
                                        maxAADepth >
                                        0;
                                    contrastThreshold =
                                      org.sunflow.math.MathUtils.
                                        clamp(
                                          contrastThreshold,
                                          0,
                                          1);
                                    thresh =
                                      contrastThreshold *
                                        (float)
                                          java.lang.Math.
                                          pow(
                                            2.0F,
                                            minAADepth);
                                    filterName =
                                      options.
                                        getString(
                                          "filter",
                                          filterName);
                                    filter =
                                      org.sunflow.core.filter.FilterFactory.
                                        get(
                                          filterName);
                                    if (filter ==
                                          null) {
                                        org.sunflow.system.UI.
                                          printWarning(
                                            org.sunflow.system.UI.Module.
                                              BCKT,
                                            "Unrecognized filter type: \"%s\" - defaulting to box",
                                            filterName);
                                        filter =
                                          new org.sunflow.core.filter.BoxFilter(
                                            1);
                                        filterName =
                                          "box";
                                    }
                                    fhs =
                                      filter.
                                        getSize(
                                          ) *
                                        0.5F;
                                    fs = (int)
                                           java.lang.Math.
                                           ceil(
                                             subPixelSize *
                                               (fhs -
                                                  0.5F));
                                    sigma =
                                      org.sunflow.math.QMC.
                                        generateSigmaTable(
                                          subPixelSize <<
                                            7);
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "Bucket renderer settings:");
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "  * Resolution:         %dx%d",
                                        imageWidth,
                                        imageHeight);
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "  * Bucket size:        %d",
                                        bucketSize);
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "  * Number of buckets:  %dx%d",
                                        numBucketsX,
                                        numBucketsY);
                                    if (minAADepth !=
                                          maxAADepth)
                                        org.sunflow.system.UI.
                                          printInfo(
                                            org.sunflow.system.UI.Module.
                                              BCKT,
                                            "  * Anti-aliasing:      %s -> %s (adaptive)",
                                            aaDepthToString(
                                              minAADepth),
                                            aaDepthToString(
                                              maxAADepth));
                                    else
                                        org.sunflow.system.UI.
                                          printInfo(
                                            org.sunflow.system.UI.Module.
                                              BCKT,
                                            "  * Anti-aliasing:      %s (fixed)",
                                            aaDepthToString(
                                              minAADepth));
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "  * Rays per sample:    %d",
                                        superSampling);
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "  * Subpixel jitter:    %s",
                                        useJitter
                                          ? "on"
                                          : (jitter
                                               ? "auto-off"
                                               : "off"));
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "  * Contrast threshold: %.2f",
                                        contrastThreshold);
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "  * Filter type:        %s",
                                        filterName);
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BCKT,
                                        "  * Filter size:        %.2f pixels",
                                        filter.
                                          getSize(
                                            ));
                                    return true;
    }
    private java.lang.String aaDepthToString(int depth) {
        int pixelAA =
          depth <
          0
          ? -(1 <<
                -depth)
          : 1 <<
          depth;
        return java.lang.String.
          format(
            "%s%d sample%s",
            depth <
              0
              ? "1/"
              : "",
            pixelAA *
              pixelAA,
            depth ==
              0
              ? ""
              : "s");
    }
    public void render(org.sunflow.core.Display display) {
        this.
          display =
          display;
        display.
          imageBegin(
            imageWidth,
            imageHeight,
            bucketSize);
        bucketCounter =
          0;
        org.sunflow.system.UI.
          taskStart(
            "Rendering",
            0,
            bucketCoords.
              length);
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
              new org.sunflow.core.renderer.BucketRenderer.BucketThread(
                i);
            renderThreads[i].
              setPriority(
                scene.
                  getThreadPriority(
                    ));
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
        org.sunflow.system.UI.
          taskStop(
            );
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
        private int threadID;
        BucketThread(int threadID) { super(
                                       );
                                     this.
                                       threadID =
                                       threadID;
        }
        public void run() { org.sunflow.core.IntersectionState istate =
                              new org.sunflow.core.IntersectionState(
                              );
                            while (true) {
                                int bx;
                                int by;
                                synchronized (BucketRenderer.this)  {
                                    if (bucketCounter >=
                                          bucketCoords.
                                            length)
                                        return;
                                    org.sunflow.system.UI.
                                      taskUpdate(
                                        bucketCounter);
                                    bx =
                                      bucketCoords[bucketCounter +
                                                     0];
                                    by =
                                      bucketCoords[bucketCounter +
                                                     1];
                                    bucketCounter +=
                                      2;
                                }
                                renderBucket(
                                  display,
                                  bx,
                                  by,
                                  threadID,
                                  istate);
                                if (org.sunflow.system.UI.
                                      taskCanceled(
                                        ))
                                    return;
                            } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456094250000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456094250000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private void renderBucket(org.sunflow.core.Display display,
                              int bx,
                              int by,
                              int threadID,
                              org.sunflow.core.IntersectionState istate) {
        int x0 =
          bx *
          bucketSize;
        int y0 =
          by *
          bucketSize;
        int bw =
          java.lang.Math.
          min(
            bucketSize,
            imageWidth -
              x0);
        int bh =
          java.lang.Math.
          min(
            bucketSize,
            imageHeight -
              y0);
        display.
          imagePrepare(
            x0,
            y0,
            bw,
            bh,
            threadID);
        org.sunflow.image.Color[] bucketRGB =
          new org.sunflow.image.Color[bw *
                                        bh];
        int sx0 =
          x0 *
          subPixelSize -
          fs;
        int sy0 =
          y0 *
          subPixelSize -
          fs;
        int sbw =
          bw *
          subPixelSize +
          fs *
          2;
        int sbh =
          bh *
          subPixelSize +
          fs *
          2;
        sbw =
          sbw +
            (maxStepSize -
               1) &
            ~(maxStepSize -
                1);
        sbh =
          sbh +
            (maxStepSize -
               1) &
            ~(maxStepSize -
                1);
        if (maxStepSize >
              1) {
            sbw++;
            sbh++;
        }
        org.sunflow.core.renderer.BucketRenderer.ImageSample[] samples =
          new org.sunflow.core.renderer.BucketRenderer.ImageSample[sbw *
                                                                     sbh];
        float invSubPixelSize =
          1.0F /
          subPixelSize;
        for (int y =
               0,
               index =
                 0;
             y <
               sbh;
             y++) {
            for (int x =
                   0;
                 x <
                   sbw;
                 x++,
                   index++) {
                int sx =
                  sx0 +
                  x;
                int sy =
                  sy0 +
                  y;
                int j =
                  sx &
                  sigma.
                    length -
                  1;
                int k =
                  sy &
                  sigma.
                    length -
                  1;
                int i =
                  j *
                  sigma.
                    length +
                  sigma[k];
                float dx =
                  useJitter
                  ? (float)
                      sigma[k] /
                  (float)
                    sigma.
                      length
                  : 0.5F;
                float dy =
                  useJitter
                  ? (float)
                      sigma[j] /
                  (float)
                    sigma.
                      length
                  : 0.5F;
                float rx =
                  (sx +
                     dx) *
                  invSubPixelSize;
                float ry =
                  (sy +
                     dy) *
                  invSubPixelSize;
                ry =
                  imageHeight -
                    ry -
                    1;
                samples[index] =
                  new org.sunflow.core.renderer.BucketRenderer.ImageSample(
                    rx,
                    ry,
                    i);
            }
        }
        for (int x =
               0;
             x <
               sbw -
               1;
             x +=
               maxStepSize)
            for (int y =
                   0;
                 y <
                   sbh -
                   1;
                 y +=
                   maxStepSize)
                refineSamples(
                  samples,
                  sbw,
                  x,
                  y,
                  maxStepSize,
                  thresh,
                  istate);
        if (dumpBuckets) {
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  BCKT,
                "Dumping bucket [%d, %d] to file ...",
                bx,
                by);
            org.sunflow.image.Bitmap bitmap =
              new org.sunflow.image.Bitmap(
              sbw,
              sbh,
              true);
            for (int y =
                   sbh -
                   1,
                   index =
                     0;
                 y >=
                   0;
                 y--)
                for (int x =
                       0;
                     x <
                       sbw;
                     x++,
                       index++)
                    bitmap.
                      setPixel(
                        x,
                        y,
                        samples[index].
                          c.
                          copy1(
                            ).
                          toNonLinear(
                            ));
            bitmap.
              save(
                java.lang.String.
                  format(
                    "bucket_%04d_%04d.png",
                    bx,
                    by));
        }
        if (displayAA) {
            float invArea =
              invSubPixelSize *
              invSubPixelSize;
            for (int y =
                   0,
                   index =
                     0;
                 y <
                   bh;
                 y++) {
                for (int x =
                       0;
                     x <
                       bw;
                     x++,
                       index++) {
                    int sampled =
                      0;
                    for (int i =
                           0;
                         i <
                           subPixelSize;
                         i++) {
                        for (int j =
                               0;
                             j <
                               subPixelSize;
                             j++) {
                            int sx =
                              x *
                              subPixelSize +
                              fs +
                              i;
                            int sy =
                              y *
                              subPixelSize +
                              fs +
                              j;
                            int s =
                              sx +
                              sy *
                              sbw;
                            sampled +=
                              samples[s].
                                sampled(
                                  )
                                ? 1
                                : 0;
                        }
                    }
                    bucketRGB[index] =
                      new org.sunflow.image.Color(
                        sampled *
                          invArea);
                }
            }
        }
        else {
            float cy =
              imageHeight -
              1 -
              (y0 +
                 0.5F);
            for (int y =
                   0,
                   index =
                     0;
                 y <
                   bh;
                 y++,
                   cy--) {
                float cx =
                  x0 +
                  0.5F;
                for (int x =
                       0;
                     x <
                       bw;
                     x++,
                       index++,
                       cx++) {
                    org.sunflow.image.Color c =
                      org.sunflow.image.Color.
                      black(
                        );
                    float weight =
                      0.0F;
                    for (int j =
                           -fs,
                           sy =
                             y *
                             subPixelSize;
                         j <=
                           fs;
                         j++,
                           sy++) {
                        for (int i =
                               -fs,
                               sx =
                                 x *
                                 subPixelSize,
                               s =
                                 sx +
                                 sy *
                                 sbw;
                             i <=
                               fs;
                             i++,
                               sx++,
                               s++) {
                            float dx =
                              samples[s].
                                rx -
                              cx;
                            if (java.lang.Math.
                                  abs(
                                    dx) >
                                  fhs)
                                continue;
                            float dy =
                              samples[s].
                                ry -
                              cy;
                            if (java.lang.Math.
                                  abs(
                                    dy) >
                                  fhs)
                                continue;
                            float f =
                              filter.
                              get(
                                dx,
                                dy);
                            c.
                              madd(
                                f,
                                samples[s].
                                  c);
                            weight +=
                              f;
                        }
                    }
                    c.
                      mul(
                        1.0F /
                          weight);
                    bucketRGB[index] =
                      c;
                }
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
    private void computeSubPixel(org.sunflow.core.renderer.BucketRenderer.ImageSample sample,
                                 org.sunflow.core.IntersectionState istate) {
        float x =
          sample.
            rx;
        float y =
          sample.
            ry;
        double q0 =
          org.sunflow.math.QMC.
          halton(
            1,
            sample.
              i);
        double q1 =
          org.sunflow.math.QMC.
          halton(
            2,
            sample.
              i);
        double q2 =
          org.sunflow.math.QMC.
          halton(
            3,
            sample.
              i);
        if (superSampling >
              1) {
            sample.
              add(
                scene.
                  getRadiance(
                    istate,
                    x,
                    y,
                    q1,
                    q2,
                    q0,
                    sample.
                      i));
            for (int i =
                   1;
                 i <
                   superSampling;
                 i++) {
                double time =
                  org.sunflow.math.QMC.
                  mod1(
                    q0 +
                      i *
                      invSuperSampling);
                double lensU =
                  org.sunflow.math.QMC.
                  mod1(
                    q1 +
                      org.sunflow.math.QMC.
                      halton(
                        0,
                        i));
                double lensV =
                  org.sunflow.math.QMC.
                  mod1(
                    q2 +
                      org.sunflow.math.QMC.
                      halton(
                        1,
                        i));
                sample.
                  add(
                    scene.
                      getRadiance(
                        istate,
                        x,
                        y,
                        lensU,
                        lensV,
                        time,
                        sample.
                          i +
                          i));
            }
            sample.
              scale(
                (float)
                  invSuperSampling);
        }
        else {
            sample.
              set(
                scene.
                  getRadiance(
                    istate,
                    x,
                    y,
                    q1,
                    q2,
                    q0,
                    sample.
                      i));
        }
    }
    private void refineSamples(org.sunflow.core.renderer.BucketRenderer.ImageSample[] samples,
                               int sbw,
                               int x,
                               int y,
                               int stepSize,
                               float thresh,
                               org.sunflow.core.IntersectionState istate) {
        int dx =
          stepSize;
        int dy =
          stepSize *
          sbw;
        int i00 =
          x +
          y *
          sbw;
        org.sunflow.core.renderer.BucketRenderer.ImageSample s00 =
          samples[i00];
        org.sunflow.core.renderer.BucketRenderer.ImageSample s01 =
          samples[i00 +
                    dy];
        org.sunflow.core.renderer.BucketRenderer.ImageSample s10 =
          samples[i00 +
                    dx];
        org.sunflow.core.renderer.BucketRenderer.ImageSample s11 =
          samples[i00 +
                    dx +
                    dy];
        if (!s00.
              sampled(
                ))
            computeSubPixel(
              s00,
              istate);
        if (!s01.
              sampled(
                ))
            computeSubPixel(
              s01,
              istate);
        if (!s10.
              sampled(
                ))
            computeSubPixel(
              s10,
              istate);
        if (!s11.
              sampled(
                ))
            computeSubPixel(
              s11,
              istate);
        if (stepSize >
              minStepSize) {
            if (s00.
                  isDifferent(
                    s01,
                    thresh) ||
                  s00.
                  isDifferent(
                    s10,
                    thresh) ||
                  s00.
                  isDifferent(
                    s11,
                    thresh) ||
                  s01.
                  isDifferent(
                    s11,
                    thresh) ||
                  s10.
                  isDifferent(
                    s11,
                    thresh) ||
                  s01.
                  isDifferent(
                    s10,
                    thresh)) {
                stepSize >>=
                  1;
                thresh *=
                  2;
                refineSamples(
                  samples,
                  sbw,
                  x,
                  y,
                  stepSize,
                  thresh,
                  istate);
                refineSamples(
                  samples,
                  sbw,
                  x +
                    stepSize,
                  y,
                  stepSize,
                  thresh,
                  istate);
                refineSamples(
                  samples,
                  sbw,
                  x,
                  y +
                    stepSize,
                  stepSize,
                  thresh,
                  istate);
                refineSamples(
                  samples,
                  sbw,
                  x +
                    stepSize,
                  y +
                    stepSize,
                  stepSize,
                  thresh,
                  istate);
                return;
            }
        }
        float ds =
          1.0F /
          stepSize;
        for (int i =
               0;
             i <=
               stepSize;
             i++)
            for (int j =
                   0;
                 j <=
                   stepSize;
                 j++)
                if (!samples[x +
                               i +
                               (y +
                                  j) *
                               sbw].
                      processed(
                        ))
                    org.sunflow.core.renderer.BucketRenderer.ImageSample.
                      bilerp(
                        samples[x +
                                  i +
                                  (y +
                                     j) *
                                  sbw],
                        s00,
                        s01,
                        s10,
                        s11,
                        i *
                          ds,
                        j *
                          ds);
    }
    private static final class ImageSample {
        float rx;
        float ry;
        int i;
        int n;
        org.sunflow.image.Color c;
        org.sunflow.core.Instance instance;
        org.sunflow.core.Shader shader;
        float nx;
        float ny;
        float nz;
        ImageSample(float rx, float ry, int i) {
            super(
              );
            this.
              rx =
              rx;
            this.
              ry =
              ry;
            this.
              i =
              i;
            n =
              0;
            c =
              null;
            instance =
              null;
            shader =
              null;
            nx =
              (ny =
                 (nz =
                    1));
        }
        final void set(org.sunflow.core.ShadingState state) {
            if (state ==
                  null)
                c =
                  org.sunflow.image.Color.
                    BLACK;
            else {
                c =
                  state.
                    getResult(
                      );
                checkNanInf(
                  );
                shader =
                  state.
                    getShader(
                      );
                instance =
                  state.
                    getInstance(
                      );
                if (state.
                      getNormal(
                        ) !=
                      null) {
                    nx =
                      state.
                        getNormal(
                          ).
                        x;
                    ny =
                      state.
                        getNormal(
                          ).
                        y;
                    nz =
                      state.
                        getNormal(
                          ).
                        z;
                }
            }
            n =
              1;
        }
        final void add(org.sunflow.core.ShadingState state) {
            if (n ==
                  0)
                c =
                  org.sunflow.image.Color.
                    black(
                      );
            if (state !=
                  null) {
                c.
                  add(
                    state.
                      getResult(
                        ));
                checkNanInf(
                  );
            }
            n++;
        }
        final void checkNanInf() { if (c.
                                         isNan(
                                           ))
                                       org.sunflow.system.UI.
                                         printError(
                                           org.sunflow.system.UI.Module.
                                             BCKT,
                                           "NaN shading sample!");
                                   else
                                       if (c.
                                             isInf(
                                               ))
                                           org.sunflow.system.UI.
                                             printError(
                                               org.sunflow.system.UI.Module.
                                                 BCKT,
                                               "Inf shading sample!");
        }
        final void scale(float s) { c.mul(
                                        s);
        }
        final boolean processed() { return c !=
                                      null;
        }
        final boolean sampled() { return n >
                                    0; }
        final boolean isDifferent(org.sunflow.core.renderer.BucketRenderer.ImageSample sample,
                                  float thresh) {
            if (instance !=
                  sample.
                    instance)
                return true;
            if (shader !=
                  sample.
                    shader)
                return true;
            if (org.sunflow.image.Color.
                  hasContrast(
                    c,
                    sample.
                      c,
                    thresh))
                return true;
            float dot =
              nx *
              sample.
                nx +
              ny *
              sample.
                ny +
              nz *
              sample.
                nz;
            return dot <
              0.9F;
        }
        static final org.sunflow.core.renderer.BucketRenderer.ImageSample bilerp(org.sunflow.core.renderer.BucketRenderer.ImageSample result,
                                                                                 org.sunflow.core.renderer.BucketRenderer.ImageSample i00,
                                                                                 org.sunflow.core.renderer.BucketRenderer.ImageSample i01,
                                                                                 org.sunflow.core.renderer.BucketRenderer.ImageSample i10,
                                                                                 org.sunflow.core.renderer.BucketRenderer.ImageSample i11,
                                                                                 float dx,
                                                                                 float dy) {
            float k00 =
              (1.0F -
                 dx) *
              (1.0F -
                 dy);
            float k01 =
              (1.0F -
                 dx) *
              dy;
            float k10 =
              dx *
              (1.0F -
                 dy);
            float k11 =
              dx *
              dy;
            org.sunflow.image.Color c00 =
              i00.
                c;
            org.sunflow.image.Color c01 =
              i01.
                c;
            org.sunflow.image.Color c10 =
              i10.
                c;
            org.sunflow.image.Color c11 =
              i11.
                c;
            org.sunflow.image.Color c =
              org.sunflow.image.Color.
              mul(
                k00,
                c00);
            c.
              madd(
                k01,
                c01);
            c.
              madd(
                k10,
                c10);
            c.
              madd(
                k11,
                c11);
            result.
              c =
              c;
            return result;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456094250000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "eRvtdCN/xKee/wBX4lg40iQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456094250000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "y0DVVrLiIvUqU7qye6R4HLc9e8vejvq6");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("3Hv+mw/+0n3vOgowH9wBPjGrU9ievvg9Hun4cfGCLvt3j/2b7/4Xr/xhcU35" +
           "/wHtPdYP9C8AAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456094250000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVbDZAcxXXu3fuV7k53ktC/7vR3wuiHXUtIYHz8nQ7JOvkk" +
       "XXRCNheb09xs791IszOjmd7TSljBkHLAropCbCFIGeSykc1PZKBI/JMAsWRX" +
       "AJcpqmzj/xhsJ5XgEJWhHGwqcuK8192zM9u7PfJeIpWmd2a6X7/vvX793uue" +
       "vjPnSVPgkx7qsAw74tEgs9Vhw4Yf0NyAbQTBXng3Zt7fYPz6ttd3XZsmzaNk" +
       "1qQR7DSNgG6zqJ0LRkm35QTMcEwa7KI0hxTDPg2oP2Uwy3VGyTwrGCx4tmVa" +
       "bKebo9hgn+EPkdkGY741XmR0UHbASPcQIMlyJNl+tbpviLSbrnckar4w1nwg" +
       "VoMtCxGvgJGuoQPGlJEtMsvODlkB6yv5ZJ3n2kcmbJdlaIllDtibpQp2DG2u" +
       "UsHKpzp/c+HeyS6ugrmG47iMixfsoYFrT9HcEOmM3m61aSE4RP6ENAyRtlhj" +
       "RnqHQqZZYJoFpqG0UStA30GdYmHA5eKwsKdmz0RAjKyo7MQzfKMguxnmmKGH" +
       "ViZl58Qg7fKytELKKhHvW5c9cf9tXU83kM5R0mk5IwjHBBAMmIyCQmlhnPpB" +
       "fy5Hc6NktgODPUJ9y7Cto3Kk5wTWhGOwIgx/qBZ8WfSoz3lGuoJxBNn8oslc" +
       "vyxenhuUfGrK28YEyDo/klVIuA3fg4AzLQDm5w2wO0nSeNBycowsUynKMva+" +
       "HxoAaUuBskm3zKrRMeAFmSNMxDaciewImJ4zAU2bXDBAn5HF2k5R155hHjQm" +
       "6BhapNJuWFRBqxlcEUjCyDy1Ge8JRmmxMkqx8Tm/67rjtzvbnTRJAeYcNW3E" +
       "3wZEPQrRHpqnPoV5IAjb1w6dNOY/d0+aEGg8T2ks2nzlI2/dtL7n7IuizZIa" +
       "bXaPH6AmGzNPj8/69tKBNdc2IIxWzw0sHPwKyfksG5Y1fSUPPMz8co9YmQkr" +
       "z+55/taPPk7fSJOZg6TZdO1iAexotukWPMum/vuoQ32D0dwgmUGd3ACvHyQt" +
       "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" +
       "dYH7UP5Y+l9TZlL1XzYAAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.sunflow.core.renderer.BucketRenderer ENT_ld =
          new org.sunflow.core.renderer.BucketRenderer(
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
          bucketOrderName =
          this.
            bucketOrderName;
        ENT_ld.
          bucketOrder =
          this.
            bucketOrder;
        ENT_ld.
          bucketSize =
          this.
            bucketSize;
        ENT_ld.
          bucketCounter =
          this.
            bucketCounter;
        ENT_ld.
          bucketCoords =
          this.
            bucketCoords;
        ENT_ld.
          dumpBuckets =
          this.
            dumpBuckets;
        ENT_ld.
          minAADepth =
          this.
            minAADepth;
        ENT_ld.
          maxAADepth =
          this.
            maxAADepth;
        ENT_ld.
          superSampling =
          this.
            superSampling;
        ENT_ld.
          contrastThreshold =
          this.
            contrastThreshold;
        ENT_ld.
          jitter =
          this.
            jitter;
        ENT_ld.
          displayAA =
          this.
            displayAA;
        ENT_ld.
          invSuperSampling =
          this.
            invSuperSampling;
        ENT_ld.
          subPixelSize =
          this.
            subPixelSize;
        ENT_ld.
          minStepSize =
          this.
            minStepSize;
        ENT_ld.
          maxStepSize =
          this.
            maxStepSize;
        ENT_ld.
          sigma =
          this.
            sigma;
        ENT_ld.
          thresh =
          this.
            thresh;
        ENT_ld.
          useJitter =
          this.
            useJitter;
        ENT_ld.
          filterName =
          this.
            filterName;
        ENT_ld.
          filter =
          this.
            filter;
        ENT_ld.
          fs =
          this.
            fs;
        ENT_ld.
          fhs =
          this.
            fhs;
        ENT_ld.
          useBat =
          this.
            useBat;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456094250000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6HmYXQG7L0PA0ltykbOmDmv1OMcdjkfd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3ISXGFiVewjMmpUJiOBapPq5nBoyo3qVHAwXxUnUW4W5NizrEaPHE3YFRh+r" +
       "mj+wWMvKcxo1wGdw0xbDEjMt9/P9SX2aIxhBn3r9vrwiy1jHVt2GPSiG7Wa7" +
       "7vZ9ZKSLQTRvw41u5ILuezajp47bm5KOOOKmiMoEJFPPyoxRLIhdv9tlCA/q" +
       "dBBzoI7yEILWJLJbX616s7g28UstY1hiu+1xrJRg3Jez43JbiLVmRxWWHogh" +
       "4rIDYp7Q6qntgLF03kCrARbpXlXpjrjlIrsMxrwFBRRbBfZRVxbLvDUsSOGK" +
       "agPdrlpQmJ/D2tIllqLQioQO7g4afI1EezGbLTLCEOboHEJ6s6E8GsuG5Qw4" +
       "BS9qDXKpqrLW69j9uiEMqWHTjDnUw5VIFPN9CwSGSKIsCMdaJUEx+0U2zq+y" +
       "o9is1KCGZmfp9iQ3MjpjrrBwxnCksctus7hQJ2qYjTXVnM7LjdKogGTVympW" +
       "ZNkBHFb1eWXB+NlqEV0Ni3Bcmi17C5gLtJGK5e2oM8SV8riJg3CodfxsBaBy" +
       "FlDdUKv9Qh2fdEuUIBZtJFZyNrWUB/2IqpfEeofoFOpCMdDFoUTEklZG6vXK" +
       "EK8Mi0WzH3VyUpmjlTyBNsme1XHx4WBWzI6ajlAZdksTqGfP/YC1m7NhfTSf" +
       "VT0op6DFPkYhDQYe1KZwpExyeg9dgHhehuMGBVUaip61ug16WB/P50jXLpHa" +
       "pNXtUqP2sp8NxjYFDzXeMhq4kB1LufosRxoG6toSurTKUqdDDsuNVRcZF+Vs" +
       "AwWZoSS2UEIYFLggKwwiv6TT7UKU88lB0B1RvFVfSToEQZFaqqvduCVP6la+" +
       "Ry9zWFEtMTaqdM2u7k5M2tEr2VZtRKpgAJynvC5He0oOwiosxkOzXq1VHIgm" +
       "mVP7pQlL5ufacMR5w/ayIaKrkMdNjsTqbFNslVdaG3JZHuq3FzzfMGrt0hCn" +
       "vYJVEmRqKhIS48Z0zNbzYIwkzKuOTjn6otHqz2uih7iT3GTFNc2QbvA5Ho9X" +
       "SBWLvQbeEybTLDewEd71g7y3jPFgsCQ4D+BpMTzb0fpcRDWAQ+lZCl4qGIu4" +
       "S8TEDNmPTXsZdd0VGIAH5ZzY5+u6xhdZwR4G+siRLGaG8+2cY8LmzGRo3lIX" +
       "YtbTW53CakkgBlcx8W7Fz0n1PBKSI6YaGHiLKBZJE8SlYY5sz0eVDpCCH7NE" +
       "3i3WqysJF2wDETCdk+ZMUNE8i8MbOVTNNVWulCVdHBb6VFHjmSG8NMNKoTWy" +
       "ioFpFnW4QlhlrFFAuGwk0R5eKnqr+mhS5zRfsqEltfK7Y3dQsgu+6ER43B9A" +
       "cIi3jFqA5Ztg5FqrryKbo4z5CAOjXbpLGnonGwmGMh7IdE2Iy9mOQmtZzQrw" +
       "UZxXquoyLHVGs5LvRMWC5yudLhmOzAjA6bHVIpXLwSurZC8wCx92sy1ezob4" +
       "nK3CI0LouEVxSmJDBp1m9dJgptPwJJ6Wy+Wnn05mbNkbm9K9N52pPtw7dhNz" +
       "1Otb6xU3h1P66b/Lmb39Rkem9FPK+48vcHrwulcvVLI8NH3bfGRVo2R6B45v" +
       "eqohHdQ7g2fKHkjseN9bL3lyMg+etrssXTr7qfc997zY/VX44mblzru9zB2e" +
       "Zb9FlwJJP4LqjvT8nx1KdNv2pdOFjUTpX+/i4PrV3G+9uvQ5V136lic9sd7V" +
       "cVU1vasJWG4DVnriyavvvfrT6vzqE+v3Fe/lDP7ZpCwpAiKm11s51xcJ/9BT" +
       "9fUV4AE58erAlhwB0Pclg1NN1ZRBxW9/+mruAEOT2tbLpa4e1WzdTGbuN3WS" +
       "FEE+0+7W6teuPnsVKED6sT3/XI9vU7XjT39pFro7PmQ5ZEpAe4rqHuwW7SQo" +
       "8ufBcLTCQw2cUBn8dyTQsSZ49l3s1WeftO1o54GnudYxQ0w8W7bPWKJ2QTvj" +
       "npEcJC9z9zETTd8z7t6ezV/q1c3RWve859VJYbIqQdyAFvdf8R2R98T3e0+s" +
       "I9aeEEdXYZ64DaFrp0sWUynDMzTw3uTgeJk7bUdK/nOOdOIrrcBSxZ1K3Jeh" +
       "kvu2AUXdqET98ajk1pTg1gReep9ImzE9pJJ+4AwtfDA5/EK6mSVVQfoSdSfu" +
       "S654filxk5Xiv7MR93duVNzqWRawk++5M+T7eHL4iJe5h+NStwYDi8NV/NZO" +
       "zo++DDnTrYk/CX5f3Mj5xR+rpSeXTCrLPz1Dzn+eHP6Jl7m83tKaXD27E++T" +
       "L0O89F39HPx+sBHvBz+eZryUElxKxdsZ7C4CAed+5Pr0IFl27q43HSYb+aVU" +
       "+BfOUMznk8Onvcxda8Wsl8nuqefXXq56OkDS96x5139fvnr2loIXzrt3+bEj" +
       "GVQi22dSLfzWGRr6veTwBeAiyfZ00Amwm/Vze0r6Vy9XSe8D8q42Slr9eJR0" +
       "W0pwW3r9kcOnJdsuMm9+iadd+G3btjN7hnd4+MZOdV8+Q3VfSQ6/D3pRR5qr" +
       "5kbr7p7i/t3LUFyagyYx9HgOeum/nC8H3U+W0wLBslfrXPS45aS5SUqhi1ef" +
       "vmpK4dUTCJ44ODh48tpTV6WA059YE6+TmnQzI+BL86j04kSyzULXLeHm8kTS" +
       "3Qa+LfWu5HSG9d6yYxzrohNZ9nZ9bdn2il+K9QS2M1iSZZbHOZKSMxg2W5KO" +
       "82wKz2RLtgvtcyVlJ7fMbhfBYevsik5k2S3k33LsSk5m2OXXW4bDkpOt6ujq" +
       "40PrOlp4Itt1y9K3rNfdOJF9vUJ8y7O+Osuay+U9ey6XTzbQveXUh1a6V36K" +
       "Knbrmnea2JWd1kLblb1HmmhbdFobXceyKzoZWrJM9xBTcnEi2Xrp7JZufXUi" +
       "4eF61i3tYcGJ5Lt1plv6XckZDMeJTyY8dIX5yR4wV3YUyskk69H+EUnAVUK4" +
       "GSUeIb32MoaC3zhzKPjHZ9z7ZnL4mpe5fds5JNfP7Pqvr99I/xV5mVce7zWS" +
       "L0Pcf91HmtYfFhI++/w9t7/u+eEfr7cbbj/+cweduX3u6/rRjfxHzi/bSXeb" +
       "KumO9bb+VGMXvu1lXn9qmgTk256mHfS31jz/w8tc2ecBg77kz1GyP/MyrzhC" +
       "BsZLm7OjRH/pZW4BRMnpX9nbxO3I0sz1Rw2iC0fmnDYdfjrl9qqX0vMhy9Fv" +
       "jiSb+tIvZW034Pnrb2U9I3zu+Wbnvd8v/ur6myeCzsVxUsvtdOa29edX0kqT" +
       "TXwPn1rbtq7L5JM/fOXn73h8O4f2yjXgnZ0ewfamkz8wUjdsL/0kSPxvXveb" +
       "b/v083+ark39/+XOxYnCTAAA");
}
