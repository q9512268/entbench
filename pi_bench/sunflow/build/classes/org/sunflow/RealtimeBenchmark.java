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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TZFDI6ULOx+/LV75cPG/UWC0wJQUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "me/EKkrWhhOd7MnRhlS4dsmVWzYXVkhBR9XuVBkxo2ATtEbJJIB7ED6YE2LA" +
       "CWNcEupqlacoOcHtVoPbggXJypLnbEdDMCNnFbwXlRsGlpS2ZitGp8JUUU3P" +
       "sxzbnpk2MSaXqityWH/ElxJtQxLMkuF4QqmaXLswiniNc1jCr7GrLltgFyC0" +
       "yO7SpPDqRsMm0bInbEBDTLcr29Riai71ZKOzHbRjU3Hr+jbC/AHZcZO25nZM" +
       "p2GM1WCtR6OkuwmFQUdgDbMTzxV0hLX0ZjVIYl0sG1vH1y2uqruAbjcy356H" +
       "Zglurb3yOEpTTPBFvlv2sba/1XByxsnMXClIZcCwdl2bS63y2tVKqBwaPmdI" +
       "BFEsoCTPbqw0MOpRHR6D2KkrFZyJQUJfCzd6K1Iklh4UQJeFULCAuNjYrDGh" +
       "TIQONsUMamsWtfEmKG2kbtcgpusKHfQS0mi3DYNaNVord70cR8Mqz9bEFj0e" +
       "g9BbMzEJtiI6aHXUeKvrki2MdbHQqyWjYoecFLr9sKC5Q54erTBlMdsIttEh" +
       "uwrXWVYTD11O8V6VEIhuoyfpdsvqj81pVVVmpF8dKO0mUx1yQoJi3IioaCKN" +
       "DcdUIe5KQ3gLeFN2PdB+smvLvfkN7fBLArytZB39n+Bmsut6Iited5j0yn/n" +
       "T2efjye9jm7uSJZbeOSVPhDk6ZVPvvv5F3ThU8W9mxkPIkIuRa73cxbYAOsY" +
       "q+wa+MwrJwF6+feRo5v4l979Lw8N3rx420+Qr33slJynWf5u78Wv0K/Xfn0P" +
       "OXt4L7/ly81JomdP3sYvByBaB87gxJ38kUPLZil95An4KDctq9w+Z3pbL4BX" +
       "+gteYG7UCOwc4A5Zpe0d+t6RFVGEXNECAHnRwLVBFKS3vehuXFM/8qT1j7vj" +
       "nsjvQP+8JY+fJSUfvOWj3+5DlfbZF65efOCF4V/nqezDj0mXOOSisbas4zmP" +
       "Y/XzXgAMM1fs0i4D4uV/742Qu499UoC2u1nLBX3PbtCvRshZOCirfsA7yGvc" +
       "f/xLRH/3XxeZ5MxJtz+0yn0/zirHIuWpE/6dfyQ98MX17jPpDe1zL3T5t79c" +
       "/dQuM65Z6nabcbnIIRd2SfpDf37iFbkd8DrfefqHVz5/6XUHsXdlJ/CRlx2T" +
       "7bHbp6FbthfliePtHz7w+2/87Re+mSdb/hdnh7iPvR4AAA==");
}
