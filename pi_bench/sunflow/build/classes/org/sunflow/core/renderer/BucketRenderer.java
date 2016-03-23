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
                                            minAADepth =
                                              -1;
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
           "KK4Osj+67w/e8DvPfrM46/pfJXbfJuQgAAA=");
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
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "buSP+NTzH/XtzivIJAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "HZau7C4nHsdtz96ytaO2Lnef//aDv3rf");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("O44CzAd3gE/M6hS2py++h9dx/Ki4OZf928d+7Qd+8ZUvF8eT/x+k44JH4i8A" +
           "AA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV8ebDkxnnf7JK7S1Ikd0nqoCiSWpJLm+RQD3NjRivKwmAO" +
       "YAbHYDCDOSxphXuAwX0NBjJjWbYjlVQlyQ6lyBWZlaTkyHZRR6WsHHbJRdtJ" +
       "JJdVSklyxVZSMZWjfCmqEv+IjyixAmBm3rw3+97j2yW9tdMPaHxf9+/7+uuv" +
       "v25044XvZ865TiZrmdpS1kxvTwy9PVUr73lLS3T3Oli5xzquKMAa67qDOO8a" +
       "/+iXLv7VDz8xu3Q2c36auY81DNNjPcU03L7omlogCljm4ja3qYm662UuYSob" +
       "sIDvKRqAKa53Fcu87gCrl7mCbSAAMQQghgCkEABoSxUz3SUavg4nHKzhuXbm" +
       "H2TOYJnzFp/A8zKPHC7EYh1WXxfTSyWIS7gtuWdioVLm0Mlc3pd9JfN1An8y" +
       "Czz3j9976V/ekrk4zVxUDDqBw8cgvLiSaeZOXdQ50XEhQRCFaeYeQxQFWnQU" +
       "VlOiFPc0c6+ryAbr+Y64r6Qk07dEJ61zq7k7+UQ2x+c909kXT1JETdjcnZM0" +
       "Vo5lfeNW1pWErSQ/FvAOJQbmSCwvblhunSuG4GXeusuxL+OVbkwQs17QRW9m" +
       "7ld1q8HGGZl7V22nsYYM0J6jGHJMes7041q8zAPHFpro2mL5OSuL17zM/bt0" +
       "vdWjmOr2VBEJi5d5wy5ZWlLcSg/stNKB9vk+8Y6Pvd9AjLMpZkHktQT/bTHT" +
       "wztMfVESHdHgxRXjnU9hn2Lf+JUPn81kYuI37BCvaP71T738rqcffvFrK5q3" +
       "HEFDcqrIe9f4z3J3f/NB+MnaLQmM2yzTVZLGPyR5av699ZOroRX3vDful5g8" +
       "3Ns8fLH/HyYf+HXxe2czd6CZ87yp+XpsR/fwpm4pmui0RUN0WE8U0MztoiHA" +
       "6XM0cyG+xhRDXOWSkuSKHpq5VUuzzpvpfawiKS4iUdGF+FoxJHNzbbHeLL0O" +
       "rUwmcyH+Zd4Z/96cWf1L/3qZATAzdRGwFKDnmInoLiAaHherdQa4viFp5gJw" +
       "HR4wHXn/njcdEYg1L8Tqd4C6z89Fr7++3Uusy/p7KjdM5Lm0OHMmVvWDux1d" +
       "i/sIYmox9TX+Ob/efPkL1/7g7L7hrzXhZZ6Ia9xb17iX1Li3qXHvcI2ZM2fS" +
       "il6f1Lxqz7g15nG/jj3enU/S7+m878OP3hIbkrW4NVZlQgoc73jhrSdAU3/H" +
       "x+aYefHTi59hfjp3NnP2sAdN0MZZdyTsvcTv7fu3K7s956hyL37oz//qi596" +
       "1tz2oUMued21r+dMuuaju3p1TF4UYme3Lf6py+yXr33l2StnM7fG/T32cR4b" +
       "22TsPh7ereNQF726cXeJLOdigSXT0VktebTxUXd4M8dcbHPSBr87vb4n1vHr" +
       "NoY7XBtx+jd5ep+VpK9fGUjSaDtSpO70Gdr65T/+xl8UU3VvPO/FA2MZLXpX" +
       "D/T2pLCLab++Z2sDA0cUY7r/+uneP/rk9z/0k6kBxBSPHVXhlSSF414eN2Gs" +
       "5p//mv2dl/7ks394dms0Xjzc+Zym8OG+kEl+5o4ThIxr+7EtnthbaHH3Sqzm" +
       "ytDQTUGRFJbTxMRK/+/Fx/Nf/l8fu7SyAy3O2ZjR069cwDb/zfXMB/7gvX/9" +
       "cFrMGT4ZrbY625KtXOB925Ihx2GXCY7wZ7710C99lf3l2JnGDsxVIjH1SZlU" +
       "B5m00YBU/qfSdG/nWT5J3uoeNP7D/etAVHGN/8Qf/uAu5ge//XKK9nBYcrCt" +
       "cda6ujKvJLkcxsW/abenI6w7i+lKLxLvvqS9+MO4xGlcIh+PxS7pxE4iPGQZ" +
       "a+pzF/7z7/zeG9/3zVsyZ1uZOzSTFVps2skyt8fWLbqz2EeF1k+8a9W4i9vi" +
       "5FIqauY64VdGcX96l8j/5PH+pZVEFdsuev//ITXug//9b65TQupZjhhMd/in" +
       "wAufeQB+5/dS/m0XT7gfDq93vnEEtuUt/Lr+v88+ev7fn81cmGYu8evwjmE1" +
       "P+k40zikcTcxXxwCHnp+ODxZjcVX913Yg7vu5UC1u85l6/Tj64Q6ub5jx5/c" +
       "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" +
       "55lWNK63FKZR8wTFdbWConKLLOoiGjM0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FwhbwToTFmv1O65iMVCfz6O47zG8TNaYYZeHBV6bu3MNNlVuorRtu65by0m5" +
       "oo2mY2AxKPQofq4tmq3QKoTt1ng4geSFX5taDoENRa2KR00M4uajPiLVxoNl" +
       "15g0MVfEvbLJ5FAcKxZwr+eETBw3KQLVigS+oI0RXZLbgIc4jbDY4XpBt2tk" +
       "AbjPofOy6hntgMZHdrvdiIWIh/DFGIPa7cmyqS9029MghLeJ+ZDjuxKc43oD" +
       "sADQE8kwsEmrzXdbDJLlRJejQInKQSWFWTZJjFYGflRHZU9cIk0L8AR+pOih" +
       "PStE6nCxWMat71bHpagKlEzP79h1VivXQGwOm4uJ1ufYOdZyFyU7Z8owq+rU" +
       "yIoHfm04qebaA7Hk4kyNz+OsU23XORUgXTu/TAwIIR21PCBdwquSBF0lSSPH" +
       "6K0RW1KcURjKtEmGXVVB66w07faZHKDAoskLEsSWMa3RsaoViA7UmWFIcdgC" +
       "DysVxI6Gs5atcZ06qE7GpbC/HMW+FuLG3UmlUJri8WQD0/EK1EHk0ZLv5QdK" +
       "0OtVzHyj3zf7Hlpq2CLJwu0JjgFR2eNUfpIl2x7Mk4YPd8ZVJy+0Rbxh1mb8" +
       "IDahEkWG4nTa7xBIVKZ0r9qh2EqnV2V8pmON5s1xUx1lW07RBztLvEwBTTxf" +
       "xIdMzcpNpoMKFEq5RR9AULYMzqahnq2jRbMaegZtAWM5wtoWg7XtmmgoKqXw" +
       "Q9xUkaxVgIKujJcitI9T1b7bXnQCUaZsqlCZDxAqQvgRVrBUnFGsXj3byPHx" +
       "pLA36TVldJnzo749KpPTVt/PzoCqZLb6ynSomDKiwNx4zNrjctjMZ6vlnGeW" +
       "KlWZiUpybxiUrao4ycYBEKEXuJLS6pmBV67j3IzU3VG9UyyjqNTMoUVyyJrC" +
       "cOkAmhzU4Fxv2Z1zE7PBUotsnfBrutfW5xjR7lTmJUSa9ZUaRMkVotpji6pe" +
       "RU0eAEvObIz2kW6bHSrZEZiE+FaQk+le4HeKpahk5LlSsSgtS2bVmQV9UC1E" +
       "ohgwTrlYaxmNIjMY5asI4lkVBSdKM9kFQxpo0nm65nNFhqtZBXZu1XJ5tuJL" +
       "0HAxliekQ8QTZELo4M2uVLCZYIrgc6JS4tuMw86DKJrH3TEbT6qlBTqXhI5J" +
       "iotJjxMnASdB3rBaWU4WJckOSLJpL4nYbSt+bNBit9bvYnZgUli9tIB1VhiQ" +
       "Y6s8B6oFNidjpdGg3Ru261p+4QMhVsdVhXf5Tg2tQBJL4VGnWpMGY7peqJMz" +
       "GMsDOUKpiZhQrHqteatlY5xMtprScOygeBzy0kA4BKdQNtvTpJpXKWarRSwr" +
       "VIM83qZnM67UjacQ2UrkMfVaRFdL2IBvTe12sx26gqjPQ6xKF8TInFDjcXlo" +
       "ByEuAgZEUEwAkE0nO6Um7WHcoYkyyi+Lg0kWqzVUgNWX9WVhMBCqDNPmCbfC" +
       "Txxw2CtPsvUsUKBUM54tQBD0zDPJ6ix9Y8u396Sr0vtnwm5iPXr1aLW7Zn/5" +
       "Pv13PrNzjujA8n1Kef/hzUwPXfeaBU02gKZvlg/sWxQNb8/xDU/Rxb0mMbgG" +
       "eZ6jcL632t7kZB467tRYujn2sx987nmB/JX82fUunfd6mds903qbJgaidgDV" +
       "7en1P9uX6MLmBdOZtUTpX+/s4Pr92m+/bPusq9i+6YlPrM5tXFYM73ICll2D" +
       "FZ948vL7L/+kIl1+YvVu4v2szj2b5CVZsYjp/UbO1U3CP/QUbXUX83iis9yz" +
       "RIeP6fuiziqGYshxwe985nJuDywnpa22Rl0+qNmmkazSr8tE0DZyDScbzauX" +
       "n70cK0B8zeo/VfU42jhc+yuzYORon2WfKQHtzRR3b7tBJ0FROA2GgwXua+CI" +
       "wvJ/TwIdaoJn30NffvZJywq3PfC4rnXIEJOeLVsnbEc7Mz/hmZ4kope565CJ" +
       "pu8Ut2/KpFd6TXOw1J3e8/okM9mBIKxBC7uv8w7Ie+S7vCdWHmtHiIM7Lo88" +
       "aEBa6fbEVMrFCRp4f5I4XuYOyxGT/6wjHvn6KjAVYasS91Wo5L6NQ1HWKlFe" +
       "G5XcmhLcmsBLn7fTZkyTVNIPn6CFjyTJz6bHVVIVpC9Mt+K+4p7mVxI32Qv+" +
       "lbW4X7lRceGTLGAr33MnyPepJPm4l7nIsmm3HpjbffrmVs5PvAo508OHPx7/" +
       "fnct5+++ppae3PZSWf7pCXL+8yT5J17m/OrQanL37Fa8z7wK8dL38lL8+9u1" +
       "eH/72jTjuZTgXCre1mC3Hiju3I9eHx4kG8vd1bHC5IC+mAr/wgmK+VKSfM7L" +
       "3LlSzGpL7I56fvXVqoeIJWVXvKu/r149O9u+S6c9nXzlQASVyPb5VAu/eYKG" +
       "fjtJvhx3keTYeTwI0Ou9cjtK+levVkkfjOWN1kqKXhslXUgJLqT3H9+vLTlY" +
       "kXnqFWo781uWZWV2DG8/+fZWdV87QXVfT5Lfi0dRR5QUY611d0dx/+5VKC6N" +
       "QRMfejgGPfdfTheD7gbLaQZvWstVLHrYctLYJKXQhMvPXDbExeUjCJ7Y29t7" +
       "8urTl8WA1Z5YEa+CmvS4YsyXxlHpzZFk602tG8L17ZGk2yN6G+ptzvEMq9Nj" +
       "hzhWWUey7Jzr2rDtZL8S6xFsJ7AkWyoPcyQ5JzCsDx0d5llnnsiWHAja5Ury" +
       "jm6Z7YmB/dbZZh3Jst20v+HY5hzNsI2vNwz7OUdb1cGdxvvWdTDzSLbrtqBv" +
       "WK97cCT7ajf4hmd1d5I1Q9COPUPQ0Qa6s3V630p38o9RxXYP81YT27zjWmiz" +
       "i/dAE22yjmuj61i2WUdDS7bk7mNKbo4kW22T3dCt7o4k3N+7uqHdzziSfLun" +
       "dEO/zTmB4TDx0YT7XUE6ugdIsy3F7GiS1Wz/gCTxXUK4niUeIL36KqaC3z5x" +
       "KvhHJzz7TpJ808vcthkckvtr2/HrWzcyfoVe5u7Do0by7Yf7r/v40uqDQfwX" +
       "nr9425ueH/7R6kDh5qM+t2OZ2yRf0w4e1T9wfd5KhttUSbevDu6nGjvzXS/z" +
       "5mPDpFi+zWU6QL+04vkfXubSLk886Uv+HCT7Uy/zugNk8XxpfXWQ6C+8zC0x" +
       "UXL5l9YmcDuwDXP12YLwzIE1p/WAny653ftKet5nOfhVkeQAX/oFrM1hO3/1" +
       "Daxr/Bef7xDvf7nyK6uvmvAaG0VJKbdhmQurD6ykhSYH9h45trRNWeeRJ394" +
       "95duf3yzhnb3CvDWTg9ge+vRnxBp6paXfvQj+jdv+o13fO75P0n3of5/O/is" +
       "tZpMAAA=");
}
