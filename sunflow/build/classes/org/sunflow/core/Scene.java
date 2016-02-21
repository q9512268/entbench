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
      1450193710000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ysB9PXRoVuPKbRHnKfnBjuR8ABJVDCO1+IVCJueJZovAxQSaMTxJwu+CjZYy" +
       "UgON8LbL8tQeOD8lFi6KYo5c2lPzFEbmnUthgW24ntCKB/9/lLcUVBD/kBpX" +
       "Hz6ybfuNZ97wSXEoXdWV/fuRS/MgaRDn4zlT3NhaKeXm8arfuubl2Z+btcpb" +
       "SJojBPZtdYlvIeRyuAlv8JX9021cLT62ri11/6LXJnGzLXJWN3Iqtgn0TG0e" +
       "8vFJK1TzPSwuPlQXLCtYHTkuy+WqI8JN42dNxRGHwztrlQyzheNp4b8PYXGw" +
       "iG4GTGMS5nNW8Dme52IkcbllRVonwB7yWgbfklwXqYNJdA3A4nUX8galu/Xx" +
       "P4uWL6V/JGpp+ZGoUcXmx+3H1Vl/uXP/SieRSpJZA6ROMzK0yA80X7nP2EnV" +
       "KTt0Xqp+gudernJn4/hS8NwftwTXgFpLT/FPHJC7lx8eK/9jS3k3hrY+K/Vi" +
       "SF+Jf7P4insCrq2VXBPptLg+34T3dxX/Cb2POP37OQAA");
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
      1450193710000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Fgp9sbuUzYig9VaTSJdMFUdoYmSi1Tys");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("CdGoSXfJdEUl8hku22S6mRxZIGy9wWUMyhSVpYJyfrWGeD3TBW9kVl/Pc9Sk" +
       "ycxKQj4SbR0tkj2nPdKnXE0yR3A/S6DiuKJ4pqdjRl0q5OdmhjSVajvvSsjY" +
       "r1ehNJch7SbNeqMOHhjoFEZMXNbGIdQ2ceDyyWpYy5v9hoD3EJaqSgbiSuYy" +
       "MIEbFxrgTc7k2rQ5txWyjzHj9CyPlQZWHpFHJj7SlUaPRNsFSxqHBj/B7I4z" +
       "JX2tRoZ+NYicoE3iAgU6hzxTM0OBNeGmUBgGJZ3VZzRnwpM+tURbmDQku37k" +
       "KoyPt9JDYLmdUWcKxuSiibJtLRh47bajWj6dS5cyYVYhUL3J6rjE0B1HaiwI" +
       "nPGzDB+1Or6nsvPe3NedXptddCgnCjGGlTu0P89kBrSJTmCjDbcGoTKE+UwL" +
       "rrANiivMHK6Fzoa+UjeJZTFb0rAROcPZoFdWKp2li5YpjrZYn+qKdMvsjk10" +
       "6tOlCtpha1UyA7XZasdXOrwVVMIeI+D9sLPwoeqUHy0HE5IoYSJW8noKWSvp" +
       "Da3QHVl5MOxTUaMuGubAUyfDbM70ql0ULsM6JgF7UINnqM21osJSHPsEXy4u" +
       "GK5ucfKQhcc+zcD4RKBrZi7S+wihCl2FM0qCM/Z9Uc/ykOhJtsh0rCkKhkB5" +
       "pAdtBRixih6UOlw5nc1IWL+QdbRMBi5gXMdsRiAcEkh77k3MdL+ZVkpBo9PN" +
       "9COKWfgUeFHAqt6o1Z/5S2gI+k6HyGVlIqSbrUXkOXpvGakKYefEEjXimgut" +
       "mWv2mziTN4lhqWYo+Wx7Jom6TrOWuUCLy+FEHM/0BTcfER25glRy5oArTQTd" +
       "h7mQyvlDrMDCnaZtQ3zTGkicEUJIK8PqsM9RMKMpNGN3+EqBJvGom15WSmmu" +
       "aFLZusl2+16am9vQxJcVx+yYOVhlSsRi7C363KRhY324QbU61aIelpQuXJ4y" +
       "yAxRnRHUhVmNaUCdcZHKaaZbdeZZlkMp28MmEJLrI3LIwVUxS5EUArpcpRJP" +
       "Af/F1U1N35XMuB9sVf4p5tpXSY/HwdMHSxfJ3/nUzvbWQ0sXSc4H1zs41ysS" +
       "Dyumt+/4pqcZyn6d6D9X8TxHE30v3hYXL2c/cto25WQp+2PvfvElmfx4Zm+9" +
       "fe1dXuoWz7J/RleC9QaJ1fPijXyvP33ZHk92aW+3VX3x3f/zof6b1LdfxWbR" +
       "x3Zw7lb5r/GXv9R8rfQbe6kbDjZZHds/frTQ5aNbq251FM93zP6RDVaPHIg/" +
       "2V0cb3c4txZ/8t87lzu+F+pnL8198H4x9y1PeWa1J/KSZnqXYvkLa/krzzx7" +
       "6R2X3hpHbzYfuZfeeMlTNXf/8G6k/YniEb6xXcd+5tnLb7ikjS89sy32pkuZ" +
       "bFzbisClw4tQdTNeGlHeIRji8/utdrP1HE7W6pcvPX8JtJ9yrJ7ClVSDt2tH" +
       "a3nlIhg53BT5BebS88/adrjtDqfp+RFBx6l/a9tJrpO3Vv7kjLS/j4O/8VKv" +
       "OtIEySLntkf+6JXWgw7XmkT89QHoeAE29TS48DVofHdd8RDfExcVn1mZj9NJ" +
       "nLtwRtotcbAHCAJ1aR8sgx8leO6GayUYLy331gR715/gPWek3RcHd3ipOzYE" +
       "Dy2ebxlevAaGD28YDtYMB9ef4WNnpMXd4NxDXupWwPDQsvGXtuxecw3sLsaR" +
       "rwbX29bs3nb92UFnpP1MHLx2xa5/aI/Blt3rrpXdJXBN1uwm159d8Yy0chxk" +
       "wdB/wO7wfoVDJJFrIJnsE82Ay16TtK8PyXPbDG9P2FTPYFqPgzcBN8BVvOp2" +
       "Y+fucntgafKW9ZuvgXVyUCKm7q1Ze1fBOvWKrUqfkdaPAxxwnWy4JjLa8iKu" +
       "tTX74HphzeuF69Oae0mGPeCQPX26Q5YcZ1hti3zpE0/+yTtfevK/JScCbtZc" +
       "VnAqzuSEA2yHyvzg5W9992uveuTTyamZG0XBXXlMuyf/jh/sO3JeL4F/+4FA" +
       "Xh/zz76SQH51V20PdmqcE9d7d86dss93LxFaHBy46ud1xZysx8m4pGCHxwQZ" +
       "/wae9D3bnSxV3TKV2IHepK3OVWnW/sExysS7PgnpX6+QJg875P28kprOz0iL" +
       "I8+ZXuomKca1onFG9iBMJXmSH287I2MSjDygg2DI3dkgf6657QX8tfaCy+D6" +
       "lXWj/8p1tWkJ1OcOnpZsjcuc9bRNi552bCHZcGTb9kpC7z5Deu+Ng+c9oOCK" +
       "l5Rd7y49LLkXrlVysRP2oTWXD11f+7EWxPHt+owqyKujGy8kRH/jDCF8MA7+" +
       "KRgXgRBW5chAcRxNVnYk8b5rlcQbwfXRtSQ+el11KLE6CZt/dQbTj8bBv1gx" +
       "RY/smd5h+pFrdcLjjaefWzP93PVheiHJcGHT5k+csLsbGHJ3dTYuPk2unDTo" +
       "3wTyC4mKf+ak5POyBV6FE3H8ziZIfTIR3stnCPb34uC3vNRtYBCmBVk7vA39" +
       "+BGdWMmA7LcYE5n/9jXI/FIc+Sy4vr6W+devj8wPc/z3Z6T9YRx8fuWEoJZv" +
       "ygc72Y/YKEPw1P0kHdBHrXBL/hV3x55BPomM07+xJv+NqyB/svO1Y1/uPdaE" +
       "dPLec+5TCfv/fIZkvh4HXwZ65znCsW72lWtgHZ9YTc48/eWa9V9eL9Yxsq9u" +
       "2X3zDHbfjoM/A3qfsIv12lqcaJSTreTx0df1BxgS+n9+rY0eO2LfWdP/zj8S" +
       "/e+dQf9/xcFfxdONMX1gUXcb+DvXOmKg4PrxmuGPr0+f3tHt49vBSftgmvNL" +
       "Cc0fnyGCv4uD/52cy1RswdkVwP+5BgEkpyXBQHKusyq7+n/tArhhNTF+uhdF" +
       "qZYXDyHW6sBc4kYkY8De+dMlsXdrHJwDnqgk6JKvA9u+qifJ/MKBSPb2rkEk" +
       "yfxufP7k6PzuDV+8svnd3bn1JEKy7OVqnjf5DEMyF5ok6PKlN14ylcWlbfwz" +
       "+/v78dSuEgj6M6s8q7nTQ4dqNxPEh6JOLHJ4AvmkSeVTCh0/SLotfDztxEpW" +
       "Zz03xVa/Tnna6pTl9gmr3ydmPjjSuMl9EHFi9hOOFW4KnpB0RhUbukdLb2LP" +
       "KLidrj9adBt/RuEjcjkUdWKRw6exNmUOx50s/IMZ4gPxH8ScXmA143qkxCrq" +
       "xCLrg0Sb7OufJ2v49njPgYZvo04ssj54s8m+/hlnXS9FHMp8+adfcti766wl" +
       "h737zkh7IA4ueqmbN4YgzvS9ra2682psVQi8nMRUxJ+lePDY959W3yySPv3S" +
       "xZsfeGnwX1bTMpvvCt2CpW4e+7p++CsCh+7Pg9FlrCWyuWX1TYFEUHuPAnO7" +
       "a7691I3xvxje3iOrbI8DD+VQNjBare8OZ3rKS90AMsW3T9ubweHQ0aDV1xHC" +
       "1QzJg4ftc7Iwc/crieqgyOGPl8STXskHtTYrhv7qk1rPSZ95qUO844eFj68+" +
       "niLpQhTFtdyMpS6svuOSVBqvOj5+am2bus63nv3JHZ+95enNCukdK8BbVTuE" +
       "7bGTv1RSN2wv+bZI9G8e+NzP/dZL30zORv1/C/KsyelMAAA=");
}
