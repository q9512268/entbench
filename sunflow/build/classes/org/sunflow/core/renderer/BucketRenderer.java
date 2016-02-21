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
          1450193884000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1450193884000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "wB/Y/R7v1vgOoloJWp8wThiE280abivUwOQ28Szt6pxsSLxmI0PJmfWXqB2h" +
           "cytBdIpVM8cfDJR6WUEwmhF6UdVU5myLUksSubHIbTtMiDSsOZZOChQyGvex" +
           "gCcpdjOfEktyO9NLm1JJj/Spl9orVxiaFEGhM55V6wbcjLXNugY3bXqCtisS" +
           "P7YndjMeskEkCyrfgZ0mXFWyipwSAc2Pxz0OXswXRLKAMbczhXsW1QBzoFHa" +
           "atZUsrc8NvJ8aWFQFXVZ6vPY2J9yMGPpVHnViFmnrHYnCyQl1eVgGjZnZgsW" +
           "2SGhBvh2LdQYOiOl0BB9szaNqkJIcfEY2LUHkzQ50cocYVSWZROsD0oYLvLE" +
           "cFUqgw1v1unEGOoKMRFLbTrsy/N2q7UmabmyYohBbQR7SBKbPhVsh0p9PcB9" +
           "VRaJXltb9doq5VX05rDVjlvLRZXzfaZllzctwopHih7XYWVby+JVq1WqUPM5" +
           "kah4z65hgdscLPmttjXLSk2jhmCa15PqNtg0hyW/4UgoMipt4MFCDyS1Gko8" +
           "jCWqwFJYeczpbBvHkwhPOd5gk7Lni2ycEIE7Tgxp0W3XG+HK03GuMttqXNpT" +
           "CVzGl5qy0OtRf6Ahi0HCU1yrZ6PEJqI3ZnlSSWKXhNXKeE7xsm8lpW3Vykp8" +
           "fSUu8B48wzC1TYbIhpbYDjGEO/GoNwytemOajBJySrCNUhpWGmU4qdfAJk1J" +
           "h7owk11G2c7iXreK6BFeZtCWU4+Vsd/vN2qVAe5E6zreNd2wHTkJpkUleoz1" +
           "VbTi94UqtmFaXhNvdFkCX9rTFBGXWrc/6aKATB4GKznpBmYbW84TK0W7yVBT" +
           "0SpBdxw3627CbhMDEo4aIo+Ptg1W0liiAetRqumDllgiIqfFt6nZEm4aiCPy" +
           "dZFm+wuVn9T6a81SqypZUuB5azrIGsFA4btwbyxiOjHSZxGybApSEEytClX3" +
           "K20sEmJ7Cy/X1LiyQdLhvLtmseHWUHF0bnfVGd7ur9QR3lv1RlyJUz2xQy2w" +
           "ql6CqVSbiAmr0nTJXyvt9nC84bgqgThDclH1e25vjg0tt7odmP31uLHtrjix" +
           "7kZ1zcYWFW/rCh2rkw5wuc1xjXBr4UTEzGNa4wONFwLKdJClV/EWgxpTS2cA" +
           "R92BlDluXEkyM5qLiCBh406QLLkGCRu8rZLDsO/x5LQzrG3Wkax2MKPbzbc4" +
           "5o+29bq72GUe3emAHVf+QfgRdlfrm2yv8ypxfJpYHIrccfZm4ORp4vFxCZQf" +
           "6Dx4s8ub4tzqo+985lmV+lhl7+CYqQn20Qd3asd88p3t625+7DIpLq6Ozz4+" +
           "985/eYB9g/mWH+Hw++EzQp5l+buT574weK3yG3vQ+aOTkOuu1E53evL0+cft" +
           "oRYnoceeOgV58Misl3NzvQo83zgw6zdufAB9cx+xu1B4iSO8t73Et3fkxTaG" +
           "zoeJd8O9eupb6nEgvfUHbdNPnaDF0J0n7z8OTz5+4oe9PQHuv/+6i9rd5aLy" +
           "yWcvX7rv2flfF1cGRxeAtxHQJT1xnJMHUCfqF4JQ061C8dt2x1FB8fdrMfSq" +
           "mwoVQ5cOq4UGv7rr83QMXTnbB9gr/ztJ9r4YuuMEWQxdPKidJPoAcAAgyqsf" +
           "DG5wQLSz3/rc6Rw78so9P8grJ9Ly8VP5VNyWH8Z+srsvv6Z86tkx+dYXmx/b" +
           "XWsojrzd5lwuEdDF3Q3LUf48elNuh7wuDJ/43l2fvu01h4l+107g46g+IdvD" +
           "N75MQN0gLo7/t3943+//9G8/+7XivOp/AXzcHxvGIAAA");
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
          1450193884000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fTHPpv8B2mh2EawjAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1450193884000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ouL2W/Zrj/3yd/+zV3+/OGL8f7qXXobE");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          "LwAA";
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1450193884000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KGo1AAA=");
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
      1450193884000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rh1/cnes5WfA8dC6qT2060/OpJKLn0hYHk3OV+LTj2+a7wXH1eagZ1+33x+B" +
       "vzPg+Lv4iDOLE1b98P3YOhi4vB8NOKA/OucJ4Dbhfh1oWTf0TlT8eOXW4jMc" +
       "n965Kg051ojedljEN4PjTWsR33SMiO1jRIwvsURvOJBW1DzH4KIN3AdvgIuv" +
       "CHYAd24ScAzy4TXgh48BTJ8G8F2aCYJWVhN99eT2Q7qaCZz+fB1qQtfvf2n6" +
       "qb/87CqM3G0sO8TSB5/70I/2PvLc2QPB++M3xM8HeVYBfALyngRp7H4ePamU" +
       "hKP2F5+//tu/dv0DK1T3Hw5Fq2Ck9dn/9H+/uvfJb//BEXHPbWCYsVMrw1sw" +
       "o0fWtfLIMbUinKZWXpPUSkPSFDXB9K4dYOJNAnscHJfXwC4fA0w/DbCLfBIC" +
       "Js69B7S3sfNLiZePndLeakS1A3h6k4CvgOPRNeBHjwHsnUqTBwBvwL75hkZZ" +
       "2RLtAPdvoWE+tgb+2DHAf+pUDXMFnAKxwFEWcP0mcT2ytoKNNRyF6+dOg+ue" +
       "FS7MDuJR+VHQ/uFNQnvLur439X4UtA+dBtrdG2i2K3rAXzxxvDdLIq+Vc3r+" +
       "Vx//2k8///h/S4KXOzQP9JllVzlihH6A53svvPSdb9zz8OeSAP92nvNWvefu" +
       "1MaNMxeHJiQS3HcfjmvjQeoDa2Ukv36KfZUGjgeMfDMm/fvKOpHsXfvh2pn1" +
       "ADCp/Pj0C5t6/cTR9Xo2vnwS9P2yZnHGpn7PG5KlrEb0ic39vBPuF3F2xbdp" +
       "4g9s/RFm2JYUx+ubZ6vxqmbv7U9qgYfhDWDd1NPH2083qcZtSPfl9//1Q/Q7" +
       "1PfexED1LTvmtZvlr3df+IP6jwm/cDZ1236Ad8OM12Gmq4fDurtcyQ9ciz4U" +
       "3D280n+iv5Xy49MTiYpPGGJ85oRnvx6fPg1qS4hVvaqZE8hfCFM7HuPDN+kx" +
       "4i7siXUjeeIYj/H5U/UOYmA6K+Nd9Sbj5MEKzrtBOMfbtiFx1g7eL9xCp/Dk" +
       "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" +
       "aQ+r/AjzBb3uTQH2njHG6vRQjyYhHfVh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "02Q96f8DCHLSPp5MAAA=");
}
