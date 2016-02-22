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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5puy202RQ8OlCzsfvyte+XDhv3TXl9GeFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
