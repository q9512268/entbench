package org.sunflow;
public class RealtimeBenchmark extends org.sunflow.SunflowAPI {
    public RealtimeBenchmark(boolean showGUI, int threads) { super();
                                                             org.sunflow.core.Display display =
                                                               showGUI
                                                               ? new org.sunflow.core.display.FastDisplay(
                                                               )
                                                               : new org.sunflow.core.display.FileDisplay(
                                                               false);
                                                             org.sunflow.system.UI.
                                                               printInfo(
                                                                 org.sunflow.system.UI.Module.
                                                                   BENCH,
                                                                 "Preparing benchmarking scene ...");
                                                             parameter(
                                                               "threads",
                                                               threads);
                                                             parameter(
                                                               "threads.lowPriority",
                                                               false);
                                                             parameter(
                                                               "resolutionX",
                                                               512);
                                                             parameter(
                                                               "resolutionY",
                                                               512);
                                                             parameter(
                                                               "aa.min",
                                                               -3);
                                                             parameter(
                                                               "aa.max",
                                                               0);
                                                             parameter(
                                                               "depths.diffuse",
                                                               1);
                                                             parameter(
                                                               "depths.reflection",
                                                               1);
                                                             parameter(
                                                               "depths.refraction",
                                                               0);
                                                             parameter(
                                                               "bucket.order",
                                                               "hilbert");
                                                             parameter(
                                                               "bucket.size",
                                                               32);
                                                             options(
                                                               org.sunflow.SunflowAPI.
                                                                 DEFAULT_OPTIONS);
                                                             org.sunflow.math.Point3 eye =
                                                               new org.sunflow.math.Point3(
                                                               30,
                                                               0,
                                                               10.967F);
                                                             org.sunflow.math.Point3 target =
                                                               new org.sunflow.math.Point3(
                                                               0,
                                                               0,
                                                               5.4F);
                                                             org.sunflow.math.Vector3 up =
                                                               new org.sunflow.math.Vector3(
                                                               0,
                                                               0,
                                                               1);
                                                             parameter(
                                                               "eye",
                                                               eye);
                                                             parameter(
                                                               "target",
                                                               target);
                                                             parameter(
                                                               "up",
                                                               up);
                                                             parameter(
                                                               "fov",
                                                               45.0F);
                                                             java.lang.String name =
                                                               getUniqueName(
                                                                 "camera");
                                                             camera(
                                                               name,
                                                               new org.sunflow.core.camera.PinholeLens(
                                                                 ));
                                                             parameter(
                                                               "camera",
                                                               name);
                                                             options(
                                                               org.sunflow.SunflowAPI.
                                                                 DEFAULT_OPTIONS);
                                                             createGeometry(
                                                               );
                                                             org.sunflow.system.UI.
                                                               printInfo(
                                                                 org.sunflow.system.UI.Module.
                                                                   BENCH,
                                                                 "Rendering warmup frame ...");
                                                             render(
                                                               org.sunflow.SunflowAPI.
                                                                 DEFAULT_OPTIONS,
                                                               display);
                                                             org.sunflow.system.Timer t =
                                                               new org.sunflow.system.Timer(
                                                               );
                                                             t.
                                                               start(
                                                                 );
                                                             double phi =
                                                               0;
                                                             double totalPhi =
                                                               java.lang.Math.
                                                                 PI *
                                                               4;
                                                             int frames =
                                                               0;
                                                             while (phi <
                                                                      totalPhi) {
                                                                 eye.
                                                                   x =
                                                                   30 *
                                                                     (float)
                                                                       java.lang.Math.
                                                                       cos(
                                                                         phi);
                                                                 eye.
                                                                   y =
                                                                   30 *
                                                                     (float)
                                                                       java.lang.Math.
                                                                       sin(
                                                                         phi);
                                                                 phi +=
                                                                   java.lang.Math.
                                                                     PI /
                                                                     30;
                                                                 frames++;
                                                                 parameter(
                                                                   "eye",
                                                                   eye);
                                                                 parameter(
                                                                   "target",
                                                                   target);
                                                                 parameter(
                                                                   "up",
                                                                   up);
                                                                 camera(
                                                                   name,
                                                                   null);
                                                                 render(
                                                                   org.sunflow.SunflowAPI.
                                                                     DEFAULT_OPTIONS,
                                                                   display);
                                                             }
                                                             t.
                                                               end(
                                                                 );
                                                             org.sunflow.system.UI.
                                                               set(
                                                                 new org.sunflow.system.ui.ConsoleInterface(
                                                                   ));
                                                             org.sunflow.system.UI.
                                                               printInfo(
                                                                 org.sunflow.system.UI.Module.
                                                                   BENCH,
                                                                 "Benchmark results:");
                                                             org.sunflow.system.UI.
                                                               printInfo(
                                                                 org.sunflow.system.UI.Module.
                                                                   BENCH,
                                                                 "  * Average FPS:         %.2f",
                                                                 frames /
                                                                   t.
                                                                   seconds(
                                                                     ));
                                                             org.sunflow.system.UI.
                                                               printInfo(
                                                                 org.sunflow.system.UI.Module.
                                                                   BENCH,
                                                                 "  * Total time:          %s",
                                                                 t);
    }
    private void createGeometry() { parameter(
                                      "source",
                                      new org.sunflow.math.Point3(
                                        -15.5945F,
                                        -30.0581F,
                                        45.967F));
                                    parameter(
                                      "dir",
                                      new org.sunflow.math.Vector3(
                                        15.5945F,
                                        30.0581F,
                                        -45.967F));
                                    parameter(
                                      "radius",
                                      60.0F);
                                    parameter(
                                      "radiance",
                                      org.sunflow.image.Color.
                                        white(
                                          ).
                                        mul(
                                          3));
                                    light(
                                      "light",
                                      new org.sunflow.core.light.DirectionalSpotlight(
                                        ));
                                    parameter(
                                      "gi.engine",
                                      "fake");
                                    parameter(
                                      "gi.fake.sky",
                                      new org.sunflow.image.Color(
                                        0.25F,
                                        0.25F,
                                        0.25F));
                                    parameter(
                                      "gi.fake.ground",
                                      new org.sunflow.image.Color(
                                        0.01F,
                                        0.01F,
                                        0.5F));
                                    parameter(
                                      "gi.fake.up",
                                      new org.sunflow.math.Vector3(
                                        0,
                                        0,
                                        1));
                                    options(
                                      DEFAULT_OPTIONS);
                                    parameter(
                                      "diffuse",
                                      org.sunflow.image.Color.
                                        white(
                                          ).
                                        mul(
                                          0.5F));
                                    shader(
                                      "default",
                                      new org.sunflow.core.shader.DiffuseShader(
                                        ));
                                    parameter(
                                      "diffuse",
                                      org.sunflow.image.Color.
                                        white(
                                          ).
                                        mul(
                                          0.5F));
                                    parameter(
                                      "shiny",
                                      0.2F);
                                    shader(
                                      "refl",
                                      new org.sunflow.core.shader.ShinyDiffuseShader(
                                        ));
                                    parameter(
                                      "subdivs",
                                      10);
                                    geometry(
                                      "teapot",
                                      (org.sunflow.core.Tesselatable)
                                        new org.sunflow.core.tesselatable.Teapot(
                                        ));
                                    parameter(
                                      "shaders",
                                      "default");
                                    org.sunflow.math.Matrix4 m =
                                      org.sunflow.math.Matrix4.
                                        IDENTITY;
                                    m = org.sunflow.math.Matrix4.
                                          scale(
                                            0.075F).
                                          multiply(
                                            m);
                                    m = org.sunflow.math.Matrix4.
                                          rotateZ(
                                            (float)
                                              java.lang.Math.
                                              toRadians(
                                                -45.0F)).
                                          multiply(
                                            m);
                                    m = org.sunflow.math.Matrix4.
                                          translation(
                                            -7,
                                            0,
                                            0).
                                          multiply(
                                            m);
                                    parameter(
                                      "transform",
                                      m);
                                    instance(
                                      "teapot.instance",
                                      "teapot");
                                    parameter(
                                      "subdivs",
                                      10);
                                    geometry(
                                      "gumbo",
                                      (org.sunflow.core.Tesselatable)
                                        new org.sunflow.core.tesselatable.Gumbo(
                                        ));
                                    m = org.sunflow.math.Matrix4.
                                          IDENTITY;
                                    m = org.sunflow.math.Matrix4.
                                          scale(
                                            0.5F).
                                          multiply(
                                            m);
                                    m = org.sunflow.math.Matrix4.
                                          rotateZ(
                                            (float)
                                              java.lang.Math.
                                              toRadians(
                                                25.0F)).
                                          multiply(
                                            m);
                                    m = org.sunflow.math.Matrix4.
                                          translation(
                                            3,
                                            -7,
                                            0).
                                          multiply(
                                            m);
                                    parameter(
                                      "shaders",
                                      "default");
                                    parameter(
                                      "transform",
                                      m);
                                    instance(
                                      "gumbo.instance",
                                      "gumbo");
                                    parameter(
                                      "center",
                                      new org.sunflow.math.Point3(
                                        0,
                                        0,
                                        0));
                                    parameter(
                                      "normal",
                                      new org.sunflow.math.Vector3(
                                        0,
                                        0,
                                        1));
                                    geometry(
                                      "ground",
                                      new org.sunflow.core.primitive.Plane(
                                        ));
                                    parameter(
                                      "shaders",
                                      "refl");
                                    instance(
                                      "ground.instance",
                                      "ground");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fuv5bxUJlP8Fnw4G3q8eAAA=");
}
