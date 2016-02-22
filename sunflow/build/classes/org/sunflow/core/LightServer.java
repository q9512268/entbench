package org.sunflow.core;
class LightServer {
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.LightSource[] lights;
    private org.sunflow.core.Shader shaderOverride;
    private boolean shaderOverridePhotons;
    private int maxDiffuseDepth = 4;
    private int maxReflectionDepth = 16;
    private int maxRefractionDepth = 16;
    private org.sunflow.core.CausticPhotonMapInterface causticPhotonMap;
    private org.sunflow.core.GIEngine giEngine;
    private int photonCounter;
    private org.sunflow.core.LightServer.CacheEntry[] shadingCache;
    private float shadingCacheResolution;
    private long cacheLookups;
    private long cacheEmptyEntryMisses;
    private long cacheWrongEntryMisses;
    private long cacheEntryAdditions;
    private long cacheHits;
    private static class CacheEntry {
        int cx;
        int cy;
        org.sunflow.core.LightServer.Sample first;
        public CacheEntry() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1Yf2xbRx0/O7/TpHGdJs26NGtTdyhtaq9jZUwpo62b0HRO" +
                                                                  "YiVdBO5W9/x8tl/z/N7re+fESRe2dUINSFRFy9qCtvzVaVO1rRViAgk2BU3A" +
                                                                  "0AbSxmAbiA4hJIpGxSrEhigwvnf37PfDcaZJRPLlfPf93vfHfb+f7/f83HVU" +
                                                                  "Zxqoh6g0TGd1YoYHVRrHhknSUQWb5mFYS0rna/Dfj14bvceP6hNobQ6bIxI2" +
                                                                  "yZBMlLSZQJtk1aRYlYg5SkiaccQNYhJjGlNZUxOoQzaH87oiSzId0dKEEUxi" +
                                                                  "I4bWYUoNOVWgZNg6gKJNMdAkwjWJ7PNuD8RQi6TpszZ5l4M86thhlHlblklR" +
                                                                  "IHYcT+NIgcpKJCabdKBooB26psxmFY2GSZGGjyu7LRcciu2ucEHvlbYPb57N" +
                                                                  "BbgL2rGqapSbZ44TU1OmSTqG2uzVQYXkzRPoq6gmhtY4iCkKxUpCIyA0AkJL" +
                                                                  "1tpUoH0rUQv5qMbNoaWT6nWJKUTRFvchOjZw3jomznWGExqpZTtnBms3l60V" +
                                                                  "VlaY+MSOyOL5o4Hv1qC2BGqT1QmmjgRKUBCSAIeSfIoY5r50mqQTaJ0Klz1B" +
                                                                  "DBkr8px100FTzqqYFuD6S25hiwWdGFym7Su4R7DNKEhUM8rmZXhAWd/qMgrO" +
                                                                  "gq2dtq3CwiG2DgY2y6CYkcEQdxZL7ZSspim6zctRtjF0HxAAa0Oe0JxWFlWr" +
                                                                  "YlhAQREiClazkQkIPTULpHUaBKBB0caqhzJf61iawlmSZBHpoYuLLaBq4o5g" +
                                                                  "LBR1eMn4SXBLGz235Lif66N7zpxUD6p+5AOd00RSmP5rgKnHwzROMsQgkAeC" +
                                                                  "sWV77BzufGnBjxAQd3iIBc33H7qxt79n+VVBc+sKNGOp40SiSeliau0b3dG+" +
                                                                  "e2qYGo26Zsrs8l2W8yyLWzsDRR0QprN8ItsMlzaXx3/6lUcukff9qHkY1Uua" +
                                                                  "UshDHK2TtLwuK8T4ElGJgSlJD6MmoqajfH8YNcA8JqtErI5lMiahw6hW4Uv1" +
                                                                  "Gv8OLsrAEcxFzTCX1YxWmuuY5vi8qCOE2uGDuuCzA4k//p+ikUhOy5MIlrAq" +
                                                                  "q1okbmjMfjMCiJMC3+YiZkHNKNpMxDSkiGZky98lzSCAMdkchfSYJkaYhZX+" +
                                                                  "/z6wyCxon/H5wLnd3tRWICsOakqaGElpsbB/8MYLyddE2LBQt2yn6DMgJWxJ" +
                                                                  "CTMpYYeUUBRLOQLlwJhFPh+Xs54JFhcI7p+CRAYkbembePDQsYXeGogcfaYW" +
                                                                  "fMdIe10VJWpnewmik9LlYOvclqu7XvGj2hgKYokWsMIKxD4jC9AjTVnZ2ZKC" +
                                                                  "WmND/mYH5LNaZWgSSQPiVIN+65RGDUxi6xStd5xQKkgs9SLVy8GK+qPlCzOP" +
                                                                  "Tj58hx/53SjPRNYBQDH2OMPmMgaHvNm90rltp699ePncvGbnuatslKpdBSez" +
                                                                  "odcbCV73JKXtm/GLyZfmQ9ztTYDDFEPeAMT1eGW4YGSgBMnMlkYwOKMZeayw" +
                                                                  "rZKPm2nO0GbsFR6i69jQIaKVhZBHQY7mX5jQn3rnl3/5LPdkCfjbHBV7gtAB" +
                                                                  "B9iww4IcVtbZEXnYIATofn8h/vgT108f4eEIFFtXEhhiYxRABm4HPPi1V0+8" +
                                                                  "+97Vi2/57RCmqEE3ZGhhSJEbs/5j+PPB57/swxCCLQikCEYtuNpcxiudib7d" +
                                                                  "Vg6QS4FkZ9ERul+FOJQzMk4phCXQv9u27Xrxr2cC4r4VWCmFS/8nH2Cv37If" +
                                                                  "PfLa0Y96+DE+iVVO24E2mYDjdvvkfYaBZ5kexUff3PTtn+GnANgBTE15jnB8" +
                                                                  "RNwhiN/gbu6LO/h4l2fvbjZsM51B7s4jR4eTlM6+9UHr5Acv3+Daulsk58WP" +
                                                                  "YH1AhJG4BRAWQtbgwmu226mzcUMRdNjgRaqD2MzBYXctjz4QUJZvgtgEiJWg" +
                                                                  "eTDHDMDJoiuWLOq6ht/++JXOY2/UIP8QalY0nB7CPONQE4Q6MXMAsUX9i3uF" +
                                                                  "HjONMAS4P1CFhyoW2C3ctvL9DuZ1ym9k7gcbvrfnmaWrPC51ccatnL+Gob4L" +
                                                                  "Ynk3bmf5pV/d/etnvnVuRtTzvurQ5uHr+teYkjr1x39W3AsHtRV6DQ9/IvLc" +
                                                                  "kxuj977P+W10YdyhYmWlAoS2ee+8lP+Hv7f+J37UkEAByep+J7FSYImdgI7P" +
                                                                  "LLXE0CG79t3dm2hVBsro2e1FNodYL67ZFRLmjJrNWz0xyG6aNw79Vgz2e2PQ" +
                                                                  "h/jkEGe5nY99bOh3xkP5qMZVjqLILxXdFZVVrYlCyoTqJ+cBEaetRu/O+DFp" +
                                                                  "IRT/k7j0W1ZgEHQdz0a+Ofn28dc53jay+nq4ZKijekIdduB4gA1hpsgqweTR" +
                                                                  "JzIffG/qyWvPC328keMhJguL3/g4fGZRwKBo5bdWdNNOHtHOe7TbspoUzjH0" +
                                                                  "58vzP3x2/rTQKuhuTAfh3fX8b/7zevjCH36+QsdUI1vPMZbKvnK3s97tamHQ" +
                                                                  "ga+3/ehssGYICu0waiyo8okCGU67I6zBLKQcvrefCHbUWaaxckORbzvggKil" +
                                                                  "bPw8G+4TwbSnKg4d+PRxi9kQY6E3y2bjHpGpTymyAz47LZE7q4jMiFRhw0hl" +
                                                                  "dlTjppC9MjzwOUcXRMyqLe0EzuviTeAwJruKMcWV89fPpjspqjf5G9nOZp7c" +
                                                                  "wVWKkwPDEQvXTdXeezxUL55aXEqPPb3Lb9XYL4NI6xnuPIeiZrtZL3miezVP" +
                                                                  "gOSuit8DxBtWemGprXHD0v1v8wax/M5sAaTIFBTFCY+Oeb1ukIzMlWwRYCni" +
                                                                  "9CGKAl5FKKpl/7iiJwXZwxStcZBRlhh85iQ6BfkHRGz6mF4yM8BrKIP9sID9" +
                                                                  "os/t4/I9d3xS0DquZasL4/gPLKX8LoifWOD9snRo9OSNzz0tulZJwXNz/EEO" +
                                                                  "WS1643Lbv6XqaaWz6g/23Vx7pWlb6aJdXbNTNzbfD6DDG8yNni7ODJWbuXcv" +
                                                                  "7nn5Fwv1bwKGHUE+TFH7kcoCWdQLEIFHYpXoBQWSt5cDfd+Zvbc/87ff8RbE" +
                                                                  "Qrvu6vTQADz+zvCVqY/28hd9HcQwKfLKfWBWHSfStOGCwrUsujD7qYX7wXJf" +
                                                                  "a3mVPV8o6q2sApWPPmjPZoixXyuoaQtM19grrl96rIhtLui6h8FecRS+BwT+" +
                                                                  "Mu9D/CVjI7putf6+XTpP6ge9FYEvcuZzfMqG8/8D1BHZRWsVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fpgJDbs+aiKRYdikLdmWzfRJXp6Vxn1d9ocDXJSUIeZ5WBXxwxRIXCVYgSBW" +
           "2xilGFk242osd8nElnhaaqBjTNKpakCsRZ+VhHp9Nq9MHHa2JqpxtpjySytj" +
           "aG+N6I4R8XUTt4bp3Mf7W2Bia0BVIn/ukeVgPk0a65E09kRuhrjcYDifMb1E" +
           "NiYrYVNbeU7mckQ3XfvCLHIxJ6zZSHmxsEW+NGIn2wnV8OpkUlnjVYxYzypT" +
           "x1npzHCO4Wy7r7Ja3+MbQaPsrKczcVAe2lkF62BW0PTTSrncm2XrNd+LOwhb" +
           "bRjmhlOI3tZB2bjOoJ3xsGvMR83AEZZGm1Pg9UgPJvq6qkTrGr4xiWpH56tb" +
           "BOctuTtVUoFCBTb0TQfJ5IiJVr0ymbbbYnmilgcp17O5gLeN9pTpmiBhz6yp" +
           "1adnc8on5yI2xLCyLK6NbKAhFVPc2A4rYKTv8TFFidi67jV0CmMq6sits0uM" +
           "IrJqrUGZGoKM0cxP5x3ELzXaE6VcZliHbgT60CU3GTMZhVPdaqt4yC1QFMti" +
           "jXCxVdqeKjWzj8m1Gomu0whtuaXFApNL4XBMTPx6mTVZ1TbFuCzVFKKkVtc8" +
           "4VURIQzCpl3lmtstxWVhh2HKUz8YN/tROLIzcZnWYMSey7Glaa01afGVeSzO" +
           "Q6NDDquziNrEw+as3rWJgc7agw4ycry1uNLIJj+W283BOuoG/YY9MkVjgxhc" +
           "fZ5UiKQ5ocKg3ZXTXjbDlxU+5Zw45huJ2Vzjk241JjpxjGftugXDfsm05sZk" +
           "2xj17aC9Xlc8S3JWI201ws3BCK+VeFOwyPFw7I/SDogoQrC2raadsXh7pFiy" +
           "obH8wBJ5Q1iW4AzZbPHUc2GysaFcpRYxXB8PJ6K1Fomu7YcSBjdHPLVVlG6V" +
           "wqZRdesinZE+4NIBPhv5PK/O5xhDTaaUvRkYPdooLcNGfdAz5D7ql3CmzVtS" +
           "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" +
           "mJwbLR8AAA==");
    }
    private static class Sample {
        org.sunflow.core.Instance i;
        org.sunflow.core.Shader s;
        float nx;
        float ny;
        float nz;
        org.sunflow.image.Color c;
        org.sunflow.core.LightServer.Sample
          next;
        public Sample() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "vBAYAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4+KSZfuHD/3+G37ruW8VXzL+B1hComADIgAA");
    }
    LightServer(org.sunflow.core.Scene scene) {
        super(
          );
        this.
          scene =
          scene;
        lights =
          (new org.sunflow.core.LightSource[0]);
        causticPhotonMap =
          null;
        shaderOverride =
          null;
        shaderOverridePhotons =
          false;
        causticPhotonMap =
          null;
        giEngine =
          null;
        shadingCache(
          0);
    }
    void setLights(org.sunflow.core.LightSource[] lights) {
        this.
          lights =
          lights;
    }
    void shadingCache(float shadingRate) {
        shadingCache =
          shadingRate >
            0
            ? (new org.sunflow.core.LightServer.CacheEntry[4096])
            : null;
        shadingCacheResolution =
          (float)
            (1 /
               java.lang.Math.
               sqrt(
                 shadingRate));
    }
    org.sunflow.core.Scene getScene() { return scene;
    }
    void setShaderOverride(org.sunflow.core.Shader shader,
                           boolean photonOverride) {
        shaderOverride =
          shader;
        shaderOverridePhotons =
          photonOverride;
    }
    boolean build(org.sunflow.core.Options options) {
        giEngine =
          org.sunflow.core.gi.GIEngineFactory.
            create(
              options);
        java.lang.String caustics =
          options.
          getString(
            "caustics",
            null);
        if (caustics ==
              null ||
              caustics.
              equals(
                "none"))
            causticPhotonMap =
              null;
        else
            if (caustics !=
                  null &&
                  caustics.
                  equals(
                    "kd"))
                causticPhotonMap =
                  new org.sunflow.core.photonmap.CausticPhotonMap(
                    options);
            else {
                org.sunflow.system.UI.
                  printWarning(
                    org.sunflow.system.UI.Module.
                      LIGHT,
                    "Unrecognized caustics photon map engine \"%s\" - ignoring",
                    caustics);
                causticPhotonMap =
                  null;
            }
        org.sunflow.system.Timer t =
          new org.sunflow.system.Timer(
          );
        t.
          start(
            );
        int numLightSamples =
          0;
        for (int i =
               0;
             i <
               lights.
                 length;
             i++)
            numLightSamples +=
              lights[i].
                getNumSamples(
                  );
        if (giEngine !=
              null) {
            if (!giEngine.
                  init(
                    scene))
                return false;
        }
        if (!calculatePhotons(
               causticPhotonMap,
               "caustic",
               0))
            return false;
        t.
          end(
            );
        cacheLookups =
          0;
        cacheHits =
          0;
        cacheEmptyEntryMisses =
          0;
        cacheWrongEntryMisses =
          0;
        cacheEntryAdditions =
          0;
        if (shadingCache !=
              null) {
            for (int i =
                   0;
                 i <
                   shadingCache.
                     length;
                 i++)
                shadingCache[i] =
                  null;
        }
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "Light Server stats:");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Light sources found: %d",
            lights.
              length);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Light samples:       %d",
            numLightSamples);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Max raytrace depth:");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "      - Diffuse          %d",
            maxDiffuseDepth);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "      - Reflection       %d",
            maxReflectionDepth);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "      - Refraction       %d",
            maxRefractionDepth);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * GI engine            %s",
            options.
              getString(
                "gi.engine",
                "none"));
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Caustics:            %s",
            caustics ==
              null
              ? "none"
              : caustics);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Shader override:     %b",
            shaderOverride);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Photon override:     %b",
            shaderOverridePhotons);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Shading cache:       %s",
            shadingCache ==
              null
              ? "off"
              : "on");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Build time:          %s",
            t.
              toString(
                ));
        return true;
    }
    void showStats() { if (shadingCache ==
                             null) return;
                       int numUsedEntries =
                         0;
                       for (org.sunflow.core.LightServer.CacheEntry e
                             :
                             shadingCache)
                           numUsedEntries +=
                             e !=
                               null
                               ? 1
                               : 0;
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "Shading cache stats:");
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Used entries:        %d (%d%%)",
                           numUsedEntries,
                           100 *
                             numUsedEntries /
                             shadingCache.
                               length);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Lookups:             %d",
                           cacheLookups);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Hits:                %d",
                           cacheHits);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Hit rate:            %d%%",
                           100 *
                             cacheHits /
                             cacheLookups);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Empty entry misses:  %d",
                           cacheEmptyEntryMisses);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Wrong entry misses:  %d",
                           cacheWrongEntryMisses);
                       org.sunflow.system.UI.
                         printInfo(
                           org.sunflow.system.UI.Module.
                             LIGHT,
                           "  * Entry adds:          %d",
                           cacheEntryAdditions);
    }
    boolean calculatePhotons(final org.sunflow.core.PhotonStore map,
                             java.lang.String type,
                             final int seed) {
        if (map ==
              null)
            return true;
        if (lights.
              length ==
              0) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  LIGHT,
                "Unable to trace %s photons, no lights in scene",
                type);
            return false;
        }
        final float[] histogram =
          new float[lights.
                      length];
        histogram[0] =
          lights[0].
            getPower(
              );
        for (int i =
               1;
             i <
               lights.
                 length;
             i++)
            histogram[i] =
              histogram[i -
                          1] +
                lights[i].
                getPower(
                  );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "Tracing %s photons ...",
            type);
        int numEmittedPhotons =
          map.
          numEmit(
            );
        if (numEmittedPhotons <=
              0 ||
              histogram[histogram.
                          length -
                          1] <=
              0) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  LIGHT,
                "Photon mapping enabled, but no %s photons to emit",
                type);
            return false;
        }
        map.
          prepare(
            scene.
              getBounds(
                ));
        org.sunflow.system.UI.
          taskStart(
            "Tracing " +
            type +
            " photons",
            0,
            numEmittedPhotons);
        java.lang.Thread[] photonThreads =
          new java.lang.Thread[scene.
                                 getThreads(
                                   )];
        final float scale =
          1.0F /
          numEmittedPhotons;
        int delta =
          numEmittedPhotons /
          photonThreads.
            length;
        photonCounter =
          0;
        org.sunflow.system.Timer photonTimer =
          new org.sunflow.system.Timer(
          );
        photonTimer.
          start(
            );
        for (int i =
               0;
             i <
               photonThreads.
                 length;
             i++) {
            final int threadID =
              i;
            final int start =
              threadID *
              delta;
            final int end =
              threadID ==
              photonThreads.
                length -
              1
              ? numEmittedPhotons
              : (threadID +
                   1) *
              delta;
            photonThreads[i] =
              new java.lang.Thread(
                new java.lang.Runnable(
                  ) {
                    public void run() {
                        org.sunflow.core.IntersectionState istate =
                          new org.sunflow.core.IntersectionState(
                          );
                        for (int i =
                               start;
                             i <
                               end;
                             i++) {
                            synchronized (LightServer.this)  {
                                org.sunflow.system.UI.
                                  taskUpdate(
                                    photonCounter);
                                photonCounter++;
                                if (org.sunflow.system.UI.
                                      taskCanceled(
                                        ))
                                    return;
                            }
                            int qmcI =
                              i +
                              seed;
                            double rand =
                              org.sunflow.math.QMC.
                              halton(
                                0,
                                qmcI) *
                              histogram[histogram.
                                          length -
                                          1];
                            int j =
                              0;
                            while (rand >=
                                     histogram[j] &&
                                     j <
                                     histogram.
                                       length)
                                j++;
                            if (j ==
                                  histogram.
                                    length)
                                continue;
                            double randX1 =
                              j ==
                              0
                              ? rand /
                              histogram[0]
                              : (rand -
                                   histogram[j]) /
                              (histogram[j] -
                                 histogram[j -
                                             1]);
                            double randY1 =
                              org.sunflow.math.QMC.
                              halton(
                                1,
                                qmcI);
                            double randX2 =
                              org.sunflow.math.QMC.
                              halton(
                                2,
                                qmcI);
                            double randY2 =
                              org.sunflow.math.QMC.
                              halton(
                                3,
                                qmcI);
                            org.sunflow.math.Point3 pt =
                              new org.sunflow.math.Point3(
                              );
                            org.sunflow.math.Vector3 dir =
                              new org.sunflow.math.Vector3(
                              );
                            org.sunflow.image.Color power =
                              new org.sunflow.image.Color(
                              );
                            lights[j].
                              getPhoton(
                                randX1,
                                randY1,
                                randX2,
                                randY2,
                                pt,
                                dir,
                                power);
                            power.
                              mul(
                                scale);
                            org.sunflow.core.Ray r =
                              new org.sunflow.core.Ray(
                              pt,
                              dir);
                            scene.
                              trace(
                                r,
                                istate);
                            if (istate.
                                  hit(
                                    ))
                                shadePhoton(
                                  org.sunflow.core.ShadingState.
                                    createPhotonState(
                                      r,
                                      istate,
                                      qmcI,
                                      map,
                                      LightServer.this),
                                  power);
                        }
                    }
                });
            photonThreads[i].
              setPriority(
                scene.
                  getThreadPriority(
                    ));
            photonThreads[i].
              start(
                );
        }
        for (int i =
               0;
             i <
               photonThreads.
                 length;
             i++) {
            try {
                photonThreads[i].
                  join(
                    );
            }
            catch (java.lang.InterruptedException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      LIGHT,
                    "Photon thread %d of %d was interrupted",
                    i +
                      1,
                    photonThreads.
                      length);
                return false;
            }
        }
        if (org.sunflow.system.UI.
              taskCanceled(
                )) {
            org.sunflow.system.UI.
              taskStop(
                );
            return false;
        }
        photonTimer.
          end(
            );
        org.sunflow.system.UI.
          taskStop(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "Tracing time for %s photons: %s",
            type,
            photonTimer.
              toString(
                ));
        map.
          init(
            );
        return true;
    }
    void shadePhoton(org.sunflow.core.ShadingState state,
                     org.sunflow.image.Color power) {
        state.
          getInstance(
            ).
          prepareShadingState(
            state);
        org.sunflow.core.Shader shader =
          getPhotonShader(
            state);
        if (shader !=
              null)
            shader.
              scatterPhoton(
                state,
                power);
    }
    void traceDiffusePhoton(org.sunflow.core.ShadingState previous,
                            org.sunflow.core.Ray r,
                            org.sunflow.image.Color power) {
        if (previous.
              getDiffuseDepth(
                ) >=
              maxDiffuseDepth)
            return;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        if (previous.
              getIntersectionState(
                ).
              hit(
                )) {
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createDiffuseBounceState(
                previous,
                r,
                0);
            shadePhoton(
              state,
              power);
        }
    }
    void traceReflectionPhoton(org.sunflow.core.ShadingState previous,
                               org.sunflow.core.Ray r,
                               org.sunflow.image.Color power) {
        if (previous.
              getReflectionDepth(
                ) >=
              maxReflectionDepth)
            return;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        if (previous.
              getIntersectionState(
                ).
              hit(
                )) {
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createReflectionBounceState(
                previous,
                r,
                0);
            shadePhoton(
              state,
              power);
        }
    }
    void traceRefractionPhoton(org.sunflow.core.ShadingState previous,
                               org.sunflow.core.Ray r,
                               org.sunflow.image.Color power) {
        if (previous.
              getRefractionDepth(
                ) >=
              maxRefractionDepth)
            return;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        if (previous.
              getIntersectionState(
                ).
              hit(
                )) {
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createRefractionBounceState(
                previous,
                r,
                0);
            shadePhoton(
              state,
              power);
        }
    }
    private org.sunflow.core.Shader getShader(org.sunflow.core.ShadingState state) {
        return shaderOverride !=
          null
          ? shaderOverride
          : state.
          getShader(
            );
    }
    private org.sunflow.core.Shader getPhotonShader(org.sunflow.core.ShadingState state) {
        return shaderOverride !=
          null &&
          shaderOverridePhotons
          ? shaderOverride
          : state.
          getShader(
            );
    }
    org.sunflow.core.ShadingState getRadiance(float rx,
                                              float ry,
                                              int i,
                                              org.sunflow.core.Ray r,
                                              org.sunflow.core.IntersectionState istate) {
        scene.
          trace(
            r,
            istate);
        if (istate.
              hit(
                )) {
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createState(
                istate,
                rx,
                ry,
                r,
                i,
                this);
            state.
              getInstance(
                ).
              prepareShadingState(
                state);
            org.sunflow.core.Shader shader =
              getShader(
                state);
            if (shader ==
                  null) {
                state.
                  setResult(
                    org.sunflow.image.Color.
                      BLACK);
                return state;
            }
            if (shadingCache !=
                  null) {
                org.sunflow.image.Color c =
                  lookupShadingCache(
                    state,
                    shader);
                if (c !=
                      null) {
                    state.
                      setResult(
                        c);
                    return state;
                }
            }
            state.
              setResult(
                shader.
                  getRadiance(
                    state));
            if (shadingCache !=
                  null)
                addShadingCache(
                  state,
                  shader,
                  state.
                    getResult(
                      ));
            return state;
        }
        else
            return null;
    }
    void shadeBakeResult(org.sunflow.core.ShadingState state) {
        org.sunflow.core.Shader shader =
          getShader(
            state);
        if (shader !=
              null)
            state.
              setResult(
                shader.
                  getRadiance(
                    state));
        else
            state.
              setResult(
                org.sunflow.image.Color.
                  BLACK);
    }
    org.sunflow.image.Color shadeHit(org.sunflow.core.ShadingState state) {
        state.
          getInstance(
            ).
          prepareShadingState(
            state);
        org.sunflow.core.Shader shader =
          getShader(
            state);
        return shader !=
          null
          ? shader.
          getRadiance(
            state)
          : org.sunflow.image.Color.
              BLACK;
    }
    private static final int hash(int x, int y) {
        return x ^
          y;
    }
    private synchronized org.sunflow.image.Color lookupShadingCache(org.sunflow.core.ShadingState state,
                                                                    org.sunflow.core.Shader shader) {
        if (state.
              getNormal(
                ) ==
              null)
            return null;
        cacheLookups++;
        int cx =
          (int)
            (state.
               getRasterX(
                 ) *
               shadingCacheResolution);
        int cy =
          (int)
            (state.
               getRasterY(
                 ) *
               shadingCacheResolution);
        int hash =
          hash(
            cx,
            cy);
        org.sunflow.core.LightServer.CacheEntry e =
          shadingCache[hash &
                         shadingCache.
                           length -
                         1];
        if (e ==
              null) {
            cacheEmptyEntryMisses++;
            return null;
        }
        if (e.
              cx ==
              cx &&
              e.
                cy ==
              cy) {
            for (org.sunflow.core.LightServer.Sample s =
                   e.
                     first;
                 s !=
                   null;
                 s =
                   s.
                     next) {
                if (s.
                      i !=
                      state.
                      getInstance(
                        ))
                    continue;
                if (s.
                      s !=
                      shader)
                    continue;
                if (state.
                      getNormal(
                        ).
                      dot(
                        s.
                          nx,
                        s.
                          ny,
                        s.
                          nz) <
                      0.95F)
                    continue;
                cacheHits++;
                return s.
                         c;
            }
        }
        else
            cacheWrongEntryMisses++;
        return null;
    }
    private synchronized void addShadingCache(org.sunflow.core.ShadingState state,
                                              org.sunflow.core.Shader shader,
                                              org.sunflow.image.Color c) {
        if (state.
              getNormal(
                ) ==
              null)
            return;
        cacheEntryAdditions++;
        int cx =
          (int)
            (state.
               getRasterX(
                 ) *
               shadingCacheResolution);
        int cy =
          (int)
            (state.
               getRasterY(
                 ) *
               shadingCacheResolution);
        int h =
          hash(
            cx,
            cy) &
          shadingCache.
            length -
          1;
        org.sunflow.core.LightServer.CacheEntry e =
          shadingCache[h];
        if (e ==
              null)
            e =
              (shadingCache[h] =
                 new org.sunflow.core.LightServer.CacheEntry(
                   ));
        org.sunflow.core.LightServer.Sample s =
          new org.sunflow.core.LightServer.Sample(
          );
        s.
          i =
          state.
            getInstance(
              );
        s.
          s =
          shader;
        s.
          c =
          c;
        s.
          nx =
          state.
            getNormal(
              ).
            x;
        s.
          ny =
          state.
            getNormal(
              ).
            y;
        s.
          nz =
          state.
            getNormal(
              ).
            z;
        if (e.
              cx ==
              cx &&
              e.
                cy ==
              cy) {
            s.
              next =
              e.
                first;
            e.
              first =
              s;
        }
        else {
            e.
              cx =
              cx;
            e.
              cy =
              cy;
            s.
              next =
              null;
            e.
              first =
              s;
        }
    }
    org.sunflow.image.Color traceGlossy(org.sunflow.core.ShadingState previous,
                                        org.sunflow.core.Ray r,
                                        int i) {
        if (previous.
              getReflectionDepth(
                ) >=
              maxReflectionDepth ||
              previous.
              getDiffuseDepth(
                ) >
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        return istate.
          hit(
            )
          ? shadeHit(
              org.sunflow.core.ShadingState.
                createGlossyBounceState(
                  previous,
                  r,
                  i))
          : org.sunflow.image.Color.
              BLACK;
    }
    org.sunflow.image.Color traceReflection(org.sunflow.core.ShadingState previous,
                                            org.sunflow.core.Ray r,
                                            int i) {
        if (previous.
              getReflectionDepth(
                ) >=
              maxReflectionDepth ||
              previous.
              getDiffuseDepth(
                ) >
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        return istate.
          hit(
            )
          ? shadeHit(
              org.sunflow.core.ShadingState.
                createReflectionBounceState(
                  previous,
                  r,
                  i))
          : org.sunflow.image.Color.
              BLACK;
    }
    org.sunflow.image.Color traceRefraction(org.sunflow.core.ShadingState previous,
                                            org.sunflow.core.Ray r,
                                            int i) {
        if (previous.
              getRefractionDepth(
                ) >=
              maxRefractionDepth ||
              previous.
              getDiffuseDepth(
                ) >
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        return istate.
          hit(
            )
          ? shadeHit(
              org.sunflow.core.ShadingState.
                createRefractionBounceState(
                  previous,
                  r,
                  i))
          : org.sunflow.image.Color.
              BLACK;
    }
    org.sunflow.core.ShadingState traceFinalGather(org.sunflow.core.ShadingState previous,
                                                   org.sunflow.core.Ray r,
                                                   int i) {
        if (previous.
              getDiffuseDepth(
                ) >=
              maxDiffuseDepth)
            return null;
        org.sunflow.core.IntersectionState istate =
          previous.
          getIntersectionState(
            );
        scene.
          trace(
            r,
            istate);
        return istate.
          hit(
            )
          ? org.sunflow.core.ShadingState.
          createFinalGatherState(
            previous,
            r,
            i)
          : null;
    }
    org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        if (giEngine ==
              null)
            return org.sunflow.image.Color.
                     BLACK;
        return giEngine.
          getGlobalRadiance(
            state);
    }
    org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                          org.sunflow.image.Color diffuseReflectance) {
        if (giEngine ==
              null ||
              state.
              getDiffuseDepth(
                ) >=
              maxDiffuseDepth)
            return org.sunflow.image.Color.
                     BLACK;
        return giEngine.
          getIrradiance(
            state,
            diffuseReflectance);
    }
    void initLightSamples(org.sunflow.core.ShadingState state) {
        for (org.sunflow.core.LightSource l
              :
              lights)
            l.
              getSamples(
                state);
    }
    void initCausticSamples(org.sunflow.core.ShadingState state) {
        if (causticPhotonMap !=
              null)
            causticPhotonMap.
              getSamples(
                state);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fnwXaY4izjVR5qCQ77wzb/JMXj6fFW/eWnZQuNP19A0Yt3fu/Xfg7wBsf5tt" +
       "WWfZge0o+3BnN9Q/fTzWu2BkuuJnPpA1hrchLSsrWdHa9lk/11RevJbIM2B7" +
       "eEfk4XOI4OcQyXa7uXTQoHCHmY2NPjC4F843uNz3txnVK//0uS9+zyvP/Unu" +
       "H3fpPlBLy1uekeKdavPVT33pz377vid/Jh9ZbhcFf6ug/dz4+tT3mow2R3zv" +
       "sRjelLEuge0HdmL4ga3osUvlI3mQOkptblVX8VFQPC8zcUJvR/rte5H0xaxg" +
       "jjQ6P1ujh0CNbiiaOojmV1TdFswT7Sr2MtAuDie0p1tgZNzs8mr45Ye/tPqx" +
       "L//0Nmfejx17lZUPfuQf/N3VD33k8NRM5bnrJgun22xnKznA+3KUWTR+5qKr" +
       "5C16/+PTL//iP3v5+7eoHr4270bBtPKn/9Pf/MbVH/njXzsjIbwNGFb2Y+zG" +
       "x0I+3EruSDPbgS6LRGBu4thKNmYendumirpz9XheCE7G16nLK7z1fBmTuSGf" +
       "xM0vfOB/PjH9du07byJHfOOejPa7/Ofkp34Ne5P0Dw8Ltx1H0esmjdc2evHa" +
       "2HmPp4BZrj29JoI+ubXAXH4XBJR3bU3ugpHdv+BcmBUOsF4pE/5WVxdUj+PC" +
       "Xvwc3mT8fBZsj+wCxyPnxM/33kj8vN/XBJAdUGBq4enysc08dn36k9fbg/1d" +
       "Nwn7rWB7dAf70XNg//0bgf3ItbBpzQmA8eVtvmPnldk/EQx6ouOYimDvIf/e" +
       "m0T+PNhet0P+unOQf+hGkD9gCXFXV9XQV7qKu53yCnvgfugmwX0r2J7YgXvi" +
       "HHAfvRFwDwNwYHa0y6HPxfexbwDf63f4Xn8Ovh+7CXyecDG+H79JfA2wPbXD" +
       "99Q5+H7yRvA9KAmhH+jS1h5Bgn3kT2+9zp86ezUHR8nDHpeP3ySXDP8bd1ze" +
       "eA6XT90Il7uWOmovQSZ9xOF113HABtsae5B/+huA/PQO8tPnQP7ZG4F8n5tL" +
       "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" +
       "1THJ9yXWwjAqbHGUFU0QK3FtRucF1cer");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Sv/NY//62z7xyh/lry/9f5D1LckoUgAA");
}
