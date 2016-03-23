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
                                 ent.runtime.ENT_Util.writeModeFile(
                                                        java.lang.String.
                                                          format(
                                                            "Num Instances: %d\n",
                                                            instances));
                                 if (instances >= 8) { return org.sunflow.EntMode.
                                                                HIGH_MODE;
                                 }
                                 else
                                     if (instances >=
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
    public int getImageWidth() { return this.imageWidth;
    }
    public int getImageHeight() { return this.imageHeight;
    }
    public org.sunflow.core.Display getDisplay() {
        return this.
                 display;
    }
    public int getThreads() { return threads <= 0
                                ? java.lang.Runtime.
                                getRuntime(
                                  ).
                                availableProcessors(
                                  )
                                : threads; }
    public int getThreadPriority() { return lowPriority
                                       ? java.lang.Thread.
                                           MIN_PRIORITY
                                       : java.lang.Thread.
                                           NORM_PRIORITY;
    }
    public void setCamera(org.sunflow.core.Camera camera) {
        this.
          camera =
          camera;
    }
    org.sunflow.core.Camera getCamera() { return camera;
    }
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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "otBuebgRjtsOvLuJ/yz8D1KJ/luEOwAA");
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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Gom0YWG6aNSrExF2llyAhJUwUxrY7ngR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("TDI5BOpTWW+xbAIlDbtUSRr1p/1GrUS7Ji/1mnlDiTSuDYv8SJvDoSiji3AZ" +
       "IaV+1qz6NVXgVLjMLJ1iqx+2l2TYGYVgQO+xRQQztJmKtxtpjZwscRMe2dW5" +
       "LkZcpt1GKIY051KaH/XM9jAtV8sCIY5t0baWWrfTXhaIOtUqqmbYjBjLqeBC" +
       "v97KNea8OlzkOxrFiD0ezkToAC761sLlHRXCNeA8zAhXo9PipGvyjhJQkEz6" +
       "jNqeOuMpjENmhqvL8mSGUozcR6JRplmsFvKQ33TK7QU7XDrhqNGTkAwtFuZF" +
       "Cuvqeb3fS1dZMwOcUmRckxaVNjcajZH2IkfJtXofq4lhDaunS8N+bwKx3Z5d" +
       "L7kqSYKn56Is0+OJ4EYzZF4bMUOjQbWIboG3S5OB1cemmZoTNtthBB5yh7QU" +
       "EeawuZjycOAxLa6kZcwGXymXZEjjK1Ege1jfrpMGlDPLYd6x6fKiSHSMsGmj" +
       "5ZxGjKK01SqBJ/CgMmJ9NN1QrbKBltS5woQdaySpcx0YE3puVxUrNEomM+kK" +
       "LHhMpUPaDIMKQFLCcM+pkNVRZuH5uAZMh0zh5tTVtXaTg0mkMy0Rub44FtEe" +
       "htK5ocba6ZZktQyMbhkhLdim6KXDIuUHEpHzBERRIdv2iz1ggXOG24Enir3o" +
       "Ew1MKtFzZlmCVZrTgmLaj4pMAc41HENH241yIQv67CJiajVpRgld0ll4rSzf" +
       "VvNFdt53ILM2MviZRRFExjWU0K0wOScqV4BvV+9l4TKsInM8CztdNCt0h9Nl" +
       "flKjw0CwYCLndNQ6lquyw5HnIoaTKQ0hGFEb5qBbaKsojvXCqiNWoz4YeUgC" +
       "EzRlnKXMSjmPDXrAa8+PWbtmTzK03Zs4XlBphpyPIUZpjDXKXSirMhmvozI8" +
       "0Y2ostJs0C3OsHNFCClLRb8iQTMg5Dkz9tHWQoF4ZhGSgtAmDErnVBLvLgSC" +
       "DIiyMM/N/b477k/HqD9qOXMnGFCm1yVY8NQNHq4muZk+Bma9DaGi7zOcrLcU" +
       "KOTSYBSvwqZX9UVOHqqeSwSY34GWUamW7XYgza8Ti0olfmX8Z1f2KvvO5A39" +
       "4eLln+Ld/CrpsTh46nCqI/ndmNpZ8HpkqiPJ+cB6xed6BuMh0fAOHN/wFF08" +
       "qOPUpYrnOQrne/Eyunj6++GzFi4nU98fe8/zLwrEx7N76+Vu7/ZSN3um9TOa" +
       "GKwXVKzuFy/8e93Z0/y9ZN32dhnWF97zPx+k3jR7+xUsLn10B+dulf+q99IX" +
       "m6/hf2Uvdd3hoqwTK8qPF3r2+FKsWxzRA09B1LEFWQ8fij9Zbxwvj7iwFn/y" +
       "71341yfXTr1h3/ZZV7F90xOfXq2h3FcMbz+WP7uWv/j0M/vv2H9rHL1ZrOTu" +
       "v3HfmynuwdHVSwey6OG+vp33fvqZZ1+/Lwas9jRo2newOvfcpn1XF/FNRp6i" +
       "ra4WjuKJPVMQGwDi0/HkzSo+nsFZna2WkKzOk1Wv3tOPgxvux1I6ODh4/PVb" +
       "fM88E99bkfaf3kJ+0xv3SzGTlfD2j06Y1Y14GmcNq9Vuti71iFr92f3n9oHu" +
       "iCfrKVxOPb127Xg1L18EI8abIj9P7j/3jGWF2754Vic71spx6l9ZVpLr9HWg" +
       "Pzkn7e/i4C+91CuPtX8yI7s1Bz9+ucmro7UmEX9xCDqeLU49BQ58DRrfnQQ9" +
       "wvfUGdCnV7brbBIXLp6TdnMc7AGCQFfbh3P2xwleuO5qCcbz4MM1weG1J3j3" +
       "OWn3xsFtXuq2DcEjM/1bhrdfBcOHNgzpNUP62jN89Jy0uBtceNBL3QIYHpnj" +
       "/uKW3auvgt3tceSrwHFpze7StWeXPiftZ+LgNSt21JEFEVt2r71advvgmK3Z" +
       "za49u+I5aeU4yAG/45Dd0cUVR0jCV0EyWdSaTXitfva1IXlhm+HtCRv0HKb1" +
       "OHgT8EFc0UO3q1B31wYEpiJsWb/5Klgnuzpi6v6atX8FrFMv26rDc9KoOOgB" +
       "rvKGayKjLS/8aluTAse71rzedW1acy/JsAe8wafO9gaTvRerNZwv/sYTf/Su" +
       "F5/4H8n2hZsUl2adiiOfsp/uSJkfvvTN7331lQ9/Ktnicz3Huit3bXcj4sl9" +
       "hse2Dybwbz0UyOti/rmXE8gHdtX2cFnJBW690OjCGYuS9xKhxcHhc8KNmmjI" +
       "63EyLsla4QlBxtfAjb97u+wG1UxDjL33TdpqE5hiHhzu6kxc+9OQ/sUKaXKz" +
       "I97Py6mpfU5aHHnB8FI38DGuFY1zsgdhKsmTXLztnIxJMPWADoIhd2c1/4Xm" +
       "thcwV9sLngXHB9aN/oFratMSqJcO75as48ued7dNi561xyJZHWVZ1kpC7zlH" +
       "eu+Pg+c8oOCil5RdL4U9Krl3Xq3kBuB4Yc3lhWtrP9aCOLm3gJyxwmqfyTsT" +
       "or9yjhA+Egf/GIyLQAirckQgOo4iiDuS+ODVSuKN4Pj1tSR+/ZrqUGJ1Ejb/" +
       "4hym/zIO/tmKafXYAu8dph+9Wic8XiX72TXTz14bpheTDBc3bf74KUvRgSF3" +
       "Vxv54s3t4mmD/g0gP5uo+KdPS75RMMFzeCKO394EqU8kwnvpHMH+Thz8ppd6" +
       "BRiEh6ygHF0zf3I/UaxkQPZbjInMf+sqZL4fRz4Djj9ey/yPr43Mj3L8D+ek" +
       "/X4cfG7lhFRN3xAOl90fs1E6680OknRAv2qGW/Ivu5T3HPJJZJz+9TX5r18B" +
       "+dOdrx37cs+JJhwmzz0XPpmw/y/nSOZrcfAloHeew57oZl++Ctbx9tpkg9a3" +
       "16y/fa1Yx8i+smX3jXPYfSsOvg70PmEX67W5ONUoJ+ve43266+9BJPT/9Gob" +
       "PXbEvrum/91/IPrfP4f+/4qDP4/fdcb0gUXdbeDvXO2IUQXH36wZ/s216dM7" +
       "un1y7TphHb5j/WJC86/PEcHfxsH/TjaRihbr7Arg/1yFAJKtnWAgudBdlV39" +
       "X70Arlu9lT/bi+rPTC8eQszV7r7EjUjGgL0bz5bE3i1xcAF4ojyr8b4GbPuq" +
       "niTzOw9Fsrd3FSJJXi7Hm2WOv1y+7guX93J598V+EsGb1nL1kjn5ZkTyLjRJ" +
       "0IT9N+4b4mJ/G//0wcHB4XvlVZ71e+Lt5t7N2+kjUacWOfr2+rQ32mcUOrnr" +
       "dVv4ZNqplaw2pm6Kra7OuNtqS+j2DqvrUzMf7r/c5D6MODX7KXsgNwVPSTqn" +
       "ig3d46U3secU3M4VHC+6jT+n8DG5HIk6tcjRrWObMkfjThf+4RviQ/Efxpxd" +
       "YPXG9ViJVdSpRda7njbZ15ena/h2L9Khhm+jTi2y3iW0yb6+jLOupyKOZH72" +
       "p59y2LvzvCmHvXvPSbs/Dm73UjdtDEGc6ftbW3XHldiqEHg5iamIv6HxwInP" +
       "Ua0+ocR/6sXbb7r/xdF/Xb2W2Xzm6GYsdZPka9rRTx4cOb8RjC6Sksjm5tUH" +
       "EBJB7T0CzO2u+fZS18d/Mby9h1fZHgMeypFsYLRanx3N9KSXug5kik+fsjaD" +
       "w5F9TKtPOYSrNyQPHLXPycTMXS8nqsMiR7+0Er/0Sr7vtZmu9Fdf+LrEf/rF" +
       "Dv6OHxU+vvrSC6+xURTXchOWurj66ExSaTzl+diZtW3qurH1zE9u+8zNT22m" +
       "Z29bAd6q2hFsj57+WZW6bnnJh1Cif3v/v/nZ33zxG8lGrv8PlF3Ea3hNAAA=");
}
