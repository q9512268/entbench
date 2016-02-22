package org.sunflow.core;
public class Scene implements ent.runtime.ENT_Attributable {
    private org.sunflow.core.LightServer lightServer;
    private org.sunflow.core.InstanceList instanceList;
    private org.sunflow.core.InstanceList infiniteInstanceList;
    private org.sunflow.core.Camera camera;
    private org.sunflow.core.AccelerationStructure intAccel;
    private java.lang.String acceltype;
    private boolean bakingViewDependent;
    private org.sunflow.core.Instance bakingInstance;
    private org.sunflow.core.PrimitiveList bakingPrimitives;
    private org.sunflow.core.AccelerationStructure bakingAccel;
    private boolean rebuildAccel;
    private int imageWidth;
    private int imageHeight;
    private int threads;
    private boolean lowPriority;
    public int ENT_attribute() { int instances = this.instanceList.getNumPrimitives(
                                                                     );
                                 if (instances > 12) { return org.sunflow.EntMode.
                                                                HIGH_MODE;
                                 }
                                 else
                                     if (instances >
                                           6) {
                                         return org.sunflow.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return org.sunflow.EntMode.
                                                  LOW_MODE;
                                     } }
    private org.sunflow.core.Display display;
    public Scene() { super();
                     lightServer = new org.sunflow.core.LightServer(
                                     this);
                     instanceList = new org.sunflow.core.InstanceList(
                                      );
                     infiniteInstanceList = new org.sunflow.core.InstanceList(
                                              );
                     acceltype = "auto";
                     bakingViewDependent = false;
                     bakingInstance = null;
                     bakingPrimitives = null;
                     bakingAccel = null;
                     camera = null;
                     imageWidth = 640;
                     imageHeight = 480;
                     threads = 0;
                     lowPriority = true;
                     rebuildAccel = true; }
    public int getImageWidth() { return this.imageWidth; }
    public int getImageHeight() { return this.imageHeight;
    }
    public org.sunflow.core.Display getDisplay() { return this.
                                                            display;
    }
    public int getThreads() { return threads <= 0 ? java.lang.Runtime.
                                getRuntime(
                                  ).
                                availableProcessors(
                                  )
                                : threads; }
    public int getThreadPriority() { return lowPriority ? java.lang.Thread.
                                                            MIN_PRIORITY
                                       : java.lang.Thread.
                                           NORM_PRIORITY;
    }
    public void setCamera(org.sunflow.core.Camera camera) {
        this.
          camera =
          camera;
    }
    org.sunflow.core.Camera getCamera() { return camera; }
    public void setInstanceLists(org.sunflow.core.Instance[] instances,
                                 org.sunflow.core.Instance[] infinite) {
        infiniteInstanceList =
          new org.sunflow.core.InstanceList(
            infinite);
        instanceList =
          new org.sunflow.core.InstanceList(
            instances);
        rebuildAccel =
          true;
    }
    public void setLightList(org.sunflow.core.LightSource[] lights) {
        lightServer.
          setLights(
            lights);
    }
    public void setShaderOverride(org.sunflow.core.Shader shader,
                                  boolean photonOverride) {
        lightServer.
          setShaderOverride(
            shader,
            photonOverride);
    }
    public void setBakingInstance(org.sunflow.core.Instance instance) {
        bakingInstance =
          instance;
    }
    public org.sunflow.core.ShadingState getRadiance(org.sunflow.core.IntersectionState istate,
                                                     float rx,
                                                     float ry,
                                                     double lensU,
                                                     double lensV,
                                                     double time,
                                                     int instance) {
        if (bakingPrimitives ==
              null) {
            org.sunflow.core.Ray r =
              camera.
              getRay(
                rx,
                ry,
                imageWidth,
                imageHeight,
                lensU,
                lensV,
                time);
            return r !=
              null
              ? lightServer.
              getRadiance(
                rx,
                ry,
                instance,
                r,
                istate)
              : null;
        }
        else {
            org.sunflow.core.Ray r =
              new org.sunflow.core.Ray(
              rx /
                imageWidth,
              ry /
                imageHeight,
              -1,
              0,
              0,
              1);
            traceBake(
              r,
              istate);
            if (!istate.
                  hit(
                    ))
                return null;
            org.sunflow.core.ShadingState state =
              org.sunflow.core.ShadingState.
              createState(
                istate,
                rx,
                ry,
                r,
                instance,
                lightServer);
            bakingPrimitives.
              prepareShadingState(
                state);
            if (bakingViewDependent)
                state.
                  setRay(
                    camera.
                      getRay(
                        state.
                          getPoint(
                            )));
            else {
                org.sunflow.math.Point3 p =
                  state.
                  getPoint(
                    );
                org.sunflow.math.Vector3 n =
                  state.
                  getNormal(
                    );
                org.sunflow.core.Ray incoming =
                  new org.sunflow.core.Ray(
                  p.
                    x +
                    n.
                      x,
                  p.
                    y +
                    n.
                      y,
                  p.
                    z +
                    n.
                      z,
                  -n.
                     x,
                  -n.
                     y,
                  -n.
                     z);
                incoming.
                  setMax(
                    1);
                state.
                  setRay(
                    incoming);
            }
            lightServer.
              shadeBakeResult(
                state);
            return state;
        }
    }
    public org.sunflow.math.BoundingBox getBounds() {
        return instanceList.
          getWorldBounds(
            null);
    }
    void trace(org.sunflow.core.Ray r, org.sunflow.core.IntersectionState state) {
        state.
          instance =
          null;
        state.
          current =
          null;
        for (int i =
               0;
             i <
               infiniteInstanceList.
               getNumPrimitives(
                 );
             i++)
            infiniteInstanceList.
              intersectPrimitive(
                r,
                i,
                state);
        state.
          current =
          null;
        intAccel.
          intersect(
            r,
            state);
    }
    org.sunflow.image.Color traceShadow(org.sunflow.core.Ray r,
                                        org.sunflow.core.IntersectionState state) {
        trace(
          r,
          state);
        return state.
          hit(
            )
          ? org.sunflow.image.Color.
              WHITE
          : org.sunflow.image.Color.
              BLACK;
    }
    void traceBake(org.sunflow.core.Ray r,
                   org.sunflow.core.IntersectionState state) {
        state.
          current =
          bakingInstance;
        state.
          instance =
          null;
        bakingAccel.
          intersect(
            r,
            state);
    }
    public void prepare(org.sunflow.core.Options options,
                        org.sunflow.core.Display display) {
        if (display ==
              null)
            this.
              display =
              new org.sunflow.core.display.FrameDisplay(
                );
        else
            this.
              display =
              display;
        if (bakingInstance !=
              null) {
            org.sunflow.system.UI.
              printDetailed(
                org.sunflow.system.UI.Module.
                  SCENE,
                "Creating primitives for lightmapping ...");
            bakingPrimitives =
              bakingInstance.
                getBakingPrimitives(
                  );
            if (bakingPrimitives ==
                  null) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      SCENE,
                    "Lightmap baking is not supported for the given instance.");
                return;
            }
            int n =
              bakingPrimitives.
              getNumPrimitives(
                );
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  SCENE,
                ("Building acceleration structure for lightmapping (%d num pri" +
                 "mitives) ..."),
                n);
            bakingAccel =
              org.sunflow.core.AccelerationStructureFactory.
                create(
                  "auto",
                  n,
                  true);
            bakingAccel.
              build(
                bakingPrimitives);
        }
        else {
            bakingPrimitives =
              null;
            bakingAccel =
              null;
        }
        bakingViewDependent =
          options.
            getBoolean(
              "baking.viewdep",
              bakingViewDependent);
        if (bakingInstance !=
              null &&
              bakingViewDependent &&
              camera ==
              null ||
              bakingInstance ==
              null &&
              camera ==
              null) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  SCENE,
                "No camera found");
            return;
        }
        threads =
          options.
            getInt(
              "threads",
              0);
        lowPriority =
          options.
            getBoolean(
              "threads.lowPriority",
              true);
        imageWidth =
          options.
            getInt(
              "resolutionX",
              640);
        imageHeight =
          options.
            getInt(
              "resolutionY",
              480);
        imageWidth =
          org.sunflow.math.MathUtils.
            clamp(
              imageWidth,
              1,
              1 <<
                14);
        imageHeight =
          org.sunflow.math.MathUtils.
            clamp(
              imageHeight,
              1,
              1 <<
                14);
        long numPrimitives =
          0;
        for (int i =
               0;
             i <
               instanceList.
               getNumPrimitives(
                 );
             i++)
            numPrimitives +=
              instanceList.
                getNumPrimitives(
                  i);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "Scene stats:");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "  * Infinite instances:  %d",
            infiniteInstanceList.
              getNumPrimitives(
                ));
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "  * Instances:           %d",
            instanceList.
              getNumPrimitives(
                ));
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "  * Primitives:          %d",
            numPrimitives);
        java.lang.String accelName =
          options.
          getString(
            "accel",
            null);
        if (accelName !=
              null) {
            rebuildAccel =
              rebuildAccel ||
                !acceltype.
                equals(
                  accelName);
            acceltype =
              accelName;
        }
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "  * Instance accel:      %s",
            acceltype);
        if (rebuildAccel) {
            intAccel =
              org.sunflow.core.AccelerationStructureFactory.
                create(
                  acceltype,
                  instanceList.
                    getNumPrimitives(
                      ),
                  false);
            intAccel.
              build(
                instanceList);
            rebuildAccel =
              false;
        }
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "  * Scene bounds:        %s",
            getBounds(
              ));
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "  * Scene center:        %s",
            getBounds(
              ).
              getCenter(
                ));
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "  * Scene diameter:      %.2f",
            getBounds(
              ).
              getExtents(
                ).
              length(
                ));
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "  * Lightmap bake:       %s",
            bakingInstance !=
              null
              ? (bakingViewDependent
                   ? "view"
                   : "ortho")
              : "off");
        if (!lightServer.
              build(
                options))
            return;
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "Rendering ...");
        lightServer.
          showStats(
            );
        bakingPrimitives =
          null;
        bakingAccel =
          null;
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              SCENE,
            "Done.");
    }
    public boolean calculatePhotons(org.sunflow.core.PhotonStore map,
                                    java.lang.String type,
                                    int seed) {
        return lightServer.
          calculatePhotons(
            map,
            type,
            seed);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456094218000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Nh0paHq2JOzVkrBfr1JYtNbl7uuWRwj7zVhho6gZJON5JUc/qmXZGCf7lOuT" +
       "8N81gfvrGKnR3JXpgAvBnzfJ4/pbVeqHFtzlStgVod/DsfpFUYPhcP02U8yl" +
       "8dEDkqw/qFLWeUSk08T7X0HWH8fKGkUNfhpno4rIAmU5H69SzqVwnea+6bQI" +
       "OZ+MlTOKGqcv5gQ4DtPW2L5K9v3UO+j/M9y3nREh64lYWaOoAdOs5li6ss9z" +
       "gfPKXOC5ooGkw69idCj6sqwpycL/6om0qhyQJTDtJxjzO6MW/nm8v/3Kw0ez" +
       "2768NumuuFwPGSUzrXfrdNzNkgWrDuQUWkHo51sd/nT82ek3vvjt7tyGapZk" +
       "8dniUyy64u8lkIusjs6sZFEevfLPC3Z8aOyiKlZXl0goySy/2n/ssfNWqjcm" +
       "+b6OWCco2w8KE/WEM5kmm8JUwgjnLl2lfsUBT1bA1e/2a79sob7llC0QJPE2" +
       "BfMbBMxRRuVlgpkxfHnLystvb8TUvYnFK4y05ijrK/l27lJ86371VCM0fs0L" +
       "H6y3+POTYaDQqZ3vKnR+1UBh8VoFiKI4RsOQSMTU1eDDtyHn8yAKhAcfo39O" +
       "AUaLPIx2uhrtnDSMojjG4NAWU4drsIlpkB8ARgEP+WwJn0TTFODThnXz4drt" +
       "arM7Bp+w/y0t0keRxii7KKZuMRZzBRA7AvHZB2LeVAGxFK6cq02ueiCiSGOU" +
       "XRVTtwaLbkZmlIAI5gABPFZMAR48wq6Fy3KVsmLwqG7gRHGUoAgkvBrH46wY" +
       "rM7GYi2EbIeyXn9xTkqoa8dNLevjtm4KcOP7c3jDXC1ZFbgRCa3aGD4xYGyO" +
       "qduCxQYAKucBxQH2QemdKmPaAdelrjKXTpoxRXGUIEgKVuGDWKUFMr5LJ5Zi" +
       "PtH8yPedL/3hG2LZp9Lym3T04847GtXf5B95ycsbrwqn2nhzrSvjtaIfM+/0" +
       "rMJ2XBa0xSZNv2J5Zx8mlR8myiuiE8wAUke/0vWTy452/ZZvCTZqDqSskOFW" +
       "OGAToHnt2PMvP9XaeTdPjWsxAUawWuWTSeUHj0LniTjObWisQ0VvmhG9biQ7" +
       "FDEhEtRirpNQ45PJulHNUHT+1oOM1OvUyIkE70EkHraKZWbmCjXTX4Du1U2D" +
       "4p6yVyeOgWhmqnTCCyqLFYU9KYTlLwsEIC5PzFDfG1OHDxMGqKaiXEKNmObj" +
       "UQM94BPkBYrEBbzcFcN2PxYDjLTj6SJpVyvR4/uk86fKJ/XAdY07Oq+ZNJ8U" +
       "xbFygOPKfjTsNXB3I7SbyUj//3XCKbC16bmNyWXIYUhciMWh0qCM2mI1C7ZK" +
       "LcuKMB5uG1fH2M0NWFzOSAueQkOO7mJq0GaumCqbwTnREbdvjkyazURxjIhj" +
       "LsDlO4+DY0pWbF9fzaG6NQbGL2BxMySYAKOg2wbdaWt8qSGI5ZGpwvKDcN3m" +
       "an7bpGEZxTE6wbyV43EsBqu7sfiKwGpDaOdCwuqOqZrp41Lrfa5m98VgxWND" +
       "+eQkilTSuYEL0uAZ2PIKYRVCsyOO3OD5ZRHQYlax64BWiV7HTjxwKgb1WbPg" +
       "Bc6KHB7yCvIA//3tmH58FIv7GGmG/He7ktWCe0/lhyhwVEBX+3ryLr5/Crp4" +
       "Kdatgutpt5+enrThEMUxBqVfxNQ9g8VPxQxig1kwsqXdrpC7zytsLMXrAcAN" +
       "ZtGH72dTAB+vw/2wE66yJ+JHSGJjmLQ2hjTeBc8qM5rtfOUm8R2O1ksxSPK8" +
       "7nkYIcxWyvzIC1OAEvoBfpzlRVfVF6tHKYq0MkrI5Pc+GjHrqAlcR038BUYm" +
       "RwNHnjlRMc7xDSY8+Od+2MDh+utUGdU6uE66Op+sHq4o0v8FrmQyGq5kLTb7" +
       "F25SIFwQkmQD+vdUBe0NcL3lqvVWDCLVeakojvGjr3x3aZtV2uB4lgPVHgPi" +
       "LCya+KFCaim2BGGyeQog5Af6IJYntgie4n+0UVWI5ZGkkqY1XJCaiu5ZHEYY" +
       "MxlGcVMc7LpkrxdCk0tiQOvCYgHM2lRFVws6hEbBhze+2kdv4WSgVwT3yD+f" +
       "wHO/88o+sBIfBal3H21rnHt05zNiXcH7cKclQxpHC7oePJkauK+HTh/lS4uk" +
       "RZxT5QdmkmtANRkqRmrxH0qZXC2apcBVBZoxPKHD74KN1jJSA43wdp3ldUTg" +
       "XJpYfCmKef7CIBZ8S2T2qSAMbG92hVZt+Bdr3tJVQXyzNqzec3TL1ktef9+X" +
       "xfF/VVf24xScNGdIg/gSgTPFbcBlkdw8XvWbV709/d5pK7yFrxlCYN96F/o2" +
       "Q9bDTXjjtOzbw2G1+NDpbanb5r8riVuT0hlo6bRxE+BMbZ5e4JNWqOY7flx8" +
       "qC5YVrBaOobM5aojwrnj36qKYxC9gWmVLLOF69PCf9+IxcEiuiIwjTGYg1rB" +
       "53hOjpHEhy1Lap0Ae8hrWXxLcr1UB5P8GlCL123kDUp358X/LFq+lP5Rs0Xl" +
       "R812KTb/sGFYHbrpRN+9e/5+Dv8srE4zsrTID4qfu8/YTtVxO3QObTqOKAVP" +
       "UPK+d02mtfQUP5CBuUL5Mbzyz4rKO67Zf+J1X2i3WOpKIPCfuOZahmPiYxbf" +
       "XUjAtZn3peXhRjhu/Xh3E/9Z/C84//lyojsAAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.sunflow.core.Scene ENT_ld =
          new org.sunflow.core.Scene(
          );
        ENT_ld.
          lightServer =
          this.
            lightServer;
        ENT_ld.
          instanceList =
          this.
            instanceList;
        ENT_ld.
          infiniteInstanceList =
          this.
            infiniteInstanceList;
        ENT_ld.
          camera =
          this.
            camera;
        ENT_ld.
          intAccel =
          this.
            intAccel;
        ENT_ld.
          acceltype =
          this.
            acceltype;
        ENT_ld.
          bakingViewDependent =
          this.
            bakingViewDependent;
        ENT_ld.
          bakingInstance =
          this.
            bakingInstance;
        ENT_ld.
          bakingPrimitives =
          this.
            bakingPrimitives;
        ENT_ld.
          bakingAccel =
          this.
            bakingAccel;
        ENT_ld.
          rebuildAccel =
          this.
            rebuildAccel;
        ENT_ld.
          imageWidth =
          this.
            imageWidth;
        ENT_ld.
          imageHeight =
          this.
            imageHeight;
        ENT_ld.
          threads =
          this.
            threads;
        ENT_ld.
          lowPriority =
          this.
            lowPriority;
        ENT_ld.
          display =
          this.
            display;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456094218000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xIuQbtUZKO/EPacINwCM7pzzZN+zvSIk");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "k2T1b+7/3M/85kvfTM9U/T/0HlA9DU0AAA==");
}
