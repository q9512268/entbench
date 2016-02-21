package org.sunflow;
public class Benchmark implements org.sunflow.system.BenchmarkTest, org.sunflow.system.UserInterface, org.sunflow.core.Display {
    private int resolution;
    private boolean showOutput;
    private boolean showBenchmarkOutput;
    private boolean saveOutput;
    private int threads;
    private int[] referenceImage;
    private int[] validationImage;
    private int errorThreshold;
    public static void main(java.lang.String[] args) { if (args.length ==
                                                             0) { java.lang.System.
                                                                    out.
                                                                    println(
                                                                      "Benchmark options:");
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      ("  -regen                        Regenerate reference images " +
                                                                       "for a variety of sizes"));
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      ("  -bench [threads] [resolution] Run a single iteration of th" +
                                                                       "e benchmark using the specified thread count and image resol" +
                                                                       "ution"));
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      ("                                Default: threads=0 (auto-det" +
                                                                       "ect cpus), resolution=256"));
                                                       }
                                                       else
                                                           if (args[0].
                                                                 equals(
                                                                   "-regen")) {
                                                               int[] sizes =
                                                                 { 32,
                                                               64,
                                                               96,
                                                               128,
                                                               256,
                                                               384,
                                                               512 };
                                                               for (int s
                                                                     :
                                                                     sizes) {
                                                                   org.sunflow.Benchmark b =
                                                                     new org.sunflow.Benchmark(
                                                                     s,
                                                                     true,
                                                                     false,
                                                                     true);
                                                                   b.
                                                                     kernelMain(
                                                                       );
                                                               }
                                                           }
                                                           else
                                                               if (args[0].
                                                                     equals(
                                                                       "-bench")) {
                                                                   int threads =
                                                                     0;
                                                                   int resolution =
                                                                     256;
                                                                   if (args.
                                                                         length >
                                                                         1)
                                                                       threads =
                                                                         java.lang.Integer.
                                                                           parseInt(
                                                                             args[1]);
                                                                   if (args.
                                                                         length >
                                                                         2)
                                                                       resolution =
                                                                         java.lang.Integer.
                                                                           parseInt(
                                                                             args[2]);
                                                                   org.sunflow.Benchmark benchmark =
                                                                     new org.sunflow.Benchmark(
                                                                     resolution,
                                                                     true,
                                                                     true,
                                                                     false,
                                                                     threads);
                                                                   benchmark.
                                                                     kernelBegin(
                                                                       );
                                                                   benchmark.
                                                                     kernelMain(
                                                                       );
                                                                   benchmark.
                                                                     kernelEnd(
                                                                       );
                                                               }
    }
    public Benchmark() { this(384, false,
                              true,
                              false); }
    public Benchmark(int resolution, boolean showOutput,
                     boolean showBenchmarkOutput,
                     boolean saveOutput) {
        this(
          resolution,
          showOutput,
          showBenchmarkOutput,
          saveOutput,
          0);
    }
    public Benchmark(int resolution, boolean showOutput,
                     boolean showBenchmarkOutput,
                     boolean saveOutput,
                     int threads) { super(
                                      );
                                    org.sunflow.system.UI.
                                      set(
                                        this);
                                    org.sunflow.system.UI.
                                      verbosity(
                                        4);
                                    this.
                                      resolution =
                                      resolution;
                                    this.
                                      showOutput =
                                      showOutput;
                                    this.
                                      showBenchmarkOutput =
                                      showBenchmarkOutput;
                                    this.
                                      saveOutput =
                                      saveOutput;
                                    this.
                                      threads =
                                      threads;
                                    errorThreshold =
                                      6;
                                    if (saveOutput)
                                        return;
                                    java.net.URL imageURL =
                                      org.sunflow.Benchmark.class.
                                      getResource(
                                        java.lang.String.
                                          format(
                                            "/resources/golden_%04X.png",
                                            resolution));
                                    if (imageURL ==
                                          null)
                                        org.sunflow.system.UI.
                                          printError(
                                            org.sunflow.system.UI.Module.
                                              BENCH,
                                            "Unable to find reference frame!");
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          BENCH,
                                        "Loading reference image from: %s",
                                        imageURL);
                                    try {
                                        java.awt.image.BufferedImage bi =
                                          javax.imageio.ImageIO.
                                          read(
                                            imageURL);
                                        if (bi.
                                              getWidth(
                                                ) !=
                                              resolution ||
                                              bi.
                                              getHeight(
                                                ) !=
                                              resolution)
                                            org.sunflow.system.UI.
                                              printError(
                                                org.sunflow.system.UI.Module.
                                                  BENCH,
                                                ("Reference image has invalid resolution! Expected %dx%d found" +
                                                 " %dx%d"),
                                                resolution,
                                                resolution,
                                                bi.
                                                  getWidth(
                                                    ),
                                                bi.
                                                  getHeight(
                                                    ));
                                        referenceImage =
                                          (new int[resolution *
                                                     resolution]);
                                        for (int y =
                                               0,
                                               i =
                                                 0;
                                             y <
                                               resolution;
                                             y++)
                                            for (int x =
                                                   0;
                                                 x <
                                                   resolution;
                                                 x++,
                                                   i++)
                                                referenceImage[i] =
                                                  bi.
                                                    getRGB(
                                                      x,
                                                      resolution -
                                                        1 -
                                                        y);
                                    }
                                    catch (java.io.IOException e) {
                                        org.sunflow.system.UI.
                                          printError(
                                            org.sunflow.system.UI.Module.
                                              BENCH,
                                            "Unable to load reference frame!");
                                    } }
    public void execute() { org.sunflow.system.BenchmarkFramework framework =
                              new org.sunflow.system.BenchmarkFramework(
                              10,
                              600);
                            framework.execute(
                                        this);
    }
    private class BenchmarkScene extends org.sunflow.SunflowAPI {
        public BenchmarkScene() { super();
                                  build();
                                  render(
                                    org.sunflow.SunflowAPI.
                                      DEFAULT_OPTIONS,
                                    saveOutput
                                      ? new org.sunflow.core.display.FileDisplay(
                                      java.lang.String.
                                        format(
                                          "resources/golden_%04X.png",
                                          resolution))
                                      : Benchmark.this);
        }
        public void build() { parameter("threads",
                                        threads);
                              parameter("threads.lowPriority",
                                        false);
                              parameter("resolutionX",
                                        resolution);
                              parameter("resolutionY",
                                        resolution);
                              parameter("aa.min",
                                        -1);
                              parameter("aa.max",
                                        1);
                              parameter("filter",
                                        "triangle");
                              parameter("depths.diffuse",
                                        2);
                              parameter("depths.reflection",
                                        2);
                              parameter("depths.refraction",
                                        2);
                              parameter("bucket.order",
                                        "hilbert");
                              parameter("bucket.size",
                                        32);
                              parameter("gi.engine",
                                        "igi");
                              parameter("gi.igi.samples",
                                        90);
                              parameter("gi.igi.c",
                                        8.0E-6F);
                              options(org.sunflow.SunflowAPI.
                                        DEFAULT_OPTIONS);
                              buildCornellBox(
                                ); }
        private void buildCornellBox() { parameter(
                                           "eye",
                                           new org.sunflow.math.Point3(
                                             0,
                                             0,
                                             -600));
                                         parameter(
                                           "target",
                                           new org.sunflow.math.Point3(
                                             0,
                                             0,
                                             0));
                                         parameter(
                                           "up",
                                           new org.sunflow.math.Vector3(
                                             0,
                                             1,
                                             0));
                                         parameter(
                                           "fov",
                                           45.0F);
                                         camera(
                                           "main_camera",
                                           new org.sunflow.core.camera.PinholeLens(
                                             ));
                                         parameter(
                                           "camera",
                                           "main_camera");
                                         options(
                                           org.sunflow.SunflowAPI.
                                             DEFAULT_OPTIONS);
                                         org.sunflow.image.Color gray =
                                           new org.sunflow.image.Color(
                                           0.7F,
                                           0.7F,
                                           0.7F);
                                         org.sunflow.image.Color blue =
                                           new org.sunflow.image.Color(
                                           0.25F,
                                           0.25F,
                                           0.8F);
                                         org.sunflow.image.Color red =
                                           new org.sunflow.image.Color(
                                           0.8F,
                                           0.25F,
                                           0.25F);
                                         org.sunflow.image.Color emit =
                                           new org.sunflow.image.Color(
                                           15,
                                           15,
                                           15);
                                         float minX =
                                           -200;
                                         float maxX =
                                           200;
                                         float minY =
                                           -160;
                                         float maxY =
                                           minY +
                                           400;
                                         float minZ =
                                           -250;
                                         float maxZ =
                                           200;
                                         float[] verts =
                                           new float[] { minX,
                                         minY,
                                         minZ,
                                         maxX,
                                         minY,
                                         minZ,
                                         maxX,
                                         minY,
                                         maxZ,
                                         minX,
                                         minY,
                                         maxZ,
                                         minX,
                                         maxY,
                                         minZ,
                                         maxX,
                                         maxY,
                                         minZ,
                                         maxX,
                                         maxY,
                                         maxZ,
                                         minX,
                                         maxY,
                                         maxZ };
                                         int[] indices =
                                           new int[] { 0,
                                         1,
                                         2,
                                         2,
                                         3,
                                         0,
                                         4,
                                         5,
                                         6,
                                         6,
                                         7,
                                         4,
                                         1,
                                         2,
                                         5,
                                         5,
                                         6,
                                         2,
                                         2,
                                         3,
                                         6,
                                         6,
                                         7,
                                         3,
                                         0,
                                         3,
                                         4,
                                         4,
                                         7,
                                         3 };
                                         parameter(
                                           "diffuse",
                                           gray);
                                         shader(
                                           "gray_shader",
                                           new org.sunflow.core.shader.DiffuseShader(
                                             ));
                                         parameter(
                                           "diffuse",
                                           red);
                                         shader(
                                           "red_shader",
                                           new org.sunflow.core.shader.DiffuseShader(
                                             ));
                                         parameter(
                                           "diffuse",
                                           blue);
                                         shader(
                                           "blue_shader",
                                           new org.sunflow.core.shader.DiffuseShader(
                                             ));
                                         parameter(
                                           "triangles",
                                           indices);
                                         parameter(
                                           "points",
                                           "point",
                                           "vertex",
                                           verts);
                                         parameter(
                                           "faceshaders",
                                           new int[] { 0,
                                           0,
                                           0,
                                           0,
                                           1,
                                           1,
                                           0,
                                           0,
                                           2,
                                           2 });
                                         geometry(
                                           "walls",
                                           new org.sunflow.core.primitive.TriangleMesh(
                                             ));
                                         parameter(
                                           "shaders",
                                           new java.lang.String[] { "gray_shader",
                                           "red_shader",
                                           "blue_shader" });
                                         instance(
                                           "walls.instance",
                                           "walls");
                                         parameter(
                                           "points",
                                           "point",
                                           "vertex",
                                           new float[] { -50,
                                           maxY -
                                             1,
                                           -50,
                                           50,
                                           maxY -
                                             1,
                                           -50,
                                           50,
                                           maxY -
                                             1,
                                           50,
                                           -50,
                                           maxY -
                                             1,
                                           50 });
                                         parameter(
                                           "triangles",
                                           new int[] { 0,
                                           1,
                                           2,
                                           2,
                                           3,
                                           0 });
                                         parameter(
                                           "radiance",
                                           emit);
                                         parameter(
                                           "samples",
                                           8);
                                         org.sunflow.core.light.TriangleMeshLight light =
                                           new org.sunflow.core.light.TriangleMeshLight(
                                           );
                                         light.
                                           init(
                                             "light",
                                             this);
                                         parameter(
                                           "eta",
                                           1.6F);
                                         shader(
                                           "Glass",
                                           new org.sunflow.core.shader.GlassShader(
                                             ));
                                         sphere(
                                           "glass_sphere",
                                           "Glass",
                                           -120,
                                           minY +
                                             55,
                                           -150,
                                           50);
                                         parameter(
                                           "color",
                                           new org.sunflow.image.Color(
                                             0.7F,
                                             0.7F,
                                             0.7F));
                                         shader(
                                           "Mirror",
                                           new org.sunflow.core.shader.MirrorShader(
                                             ));
                                         sphere(
                                           "mirror_sphere",
                                           "Mirror",
                                           100,
                                           minY +
                                             60,
                                           -50,
                                           50);
                                         geometry(
                                           "teapot",
                                           (org.sunflow.core.Tesselatable)
                                             new org.sunflow.core.tesselatable.Teapot(
                                             ));
                                         parameter(
                                           "transform",
                                           org.sunflow.math.Matrix4.
                                             translation(
                                               80,
                                               -50,
                                               100).
                                             multiply(
                                               org.sunflow.math.Matrix4.
                                                 rotateX(
                                                   (float)
                                                     -java.lang.Math.
                                                        PI /
                                                     6)).
                                             multiply(
                                               org.sunflow.math.Matrix4.
                                                 rotateY(
                                                   (float)
                                                     java.lang.Math.
                                                       PI /
                                                     4)).
                                             multiply(
                                               org.sunflow.math.Matrix4.
                                                 rotateX(
                                                   (float)
                                                     -java.lang.Math.
                                                        PI /
                                                     2).
                                                 multiply(
                                                   org.sunflow.math.Matrix4.
                                                     scale(
                                                       1.2F))));
                                         parameter(
                                           "shaders",
                                           "gray_shader");
                                         instance(
                                           "teapot.instance1",
                                           "teapot");
                                         parameter(
                                           "transform",
                                           org.sunflow.math.Matrix4.
                                             translation(
                                               -80,
                                               -160,
                                               50).
                                             multiply(
                                               org.sunflow.math.Matrix4.
                                                 rotateY(
                                                   (float)
                                                     java.lang.Math.
                                                       PI /
                                                     4)).
                                             multiply(
                                               org.sunflow.math.Matrix4.
                                                 rotateX(
                                                   (float)
                                                     -java.lang.Math.
                                                        PI /
                                                     2).
                                                 multiply(
                                                   org.sunflow.math.Matrix4.
                                                     scale(
                                                       1.2F))));
                                         parameter(
                                           "shaders",
                                           "gray_shader");
                                         instance(
                                           "teapot.instance2",
                                           "teapot");
                                         instance(
                                           "teapot.instance3",
                                           "teapot");
                                         instance(
                                           "teapot.instance4",
                                           "teapot");
                                         instance(
                                           "teapot.instance5",
                                           "teapot");
                                         instance(
                                           "teapot.instance6",
                                           "teapot");
                                         instance(
                                           "teapot.instance7",
                                           "teapot");
        }
        private void sphere(java.lang.String name,
                            java.lang.String shaderName,
                            float x,
                            float y,
                            float z,
                            float radius) {
            geometry(
              name,
              new org.sunflow.core.primitive.Sphere(
                ));
            parameter(
              "transform",
              org.sunflow.math.Matrix4.
                translation(
                  x,
                  y,
                  z).
                multiply(
                  org.sunflow.math.Matrix4.
                    scale(
                      radius)));
            parameter(
              "shaders",
              shaderName);
            instance(
              name +
              ".instance",
              name);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "YDPx1rdm24x3vbKd3p35pvbgygFs8LIG4hXscJLrDwg23OdcT4vABvzwfCw/" +
           "Grnt5On10fOxw0MTKNvM3X+jC4Z8I/fJDzzznDT8VGln77BpDvbue/c+xw9f" +
           "Hr/xjrWfX64cnoB86QP/ch/7NvU9r+Bc98ETQp5k+Tv957/SfaP4KzvQ6YPz" +
           "kGuufY53unL8FOSCJwehZ7PHzkLuP362+rr8+GP7C65/tnp9Q+WesfWHmxzk" +
           "hTdpi7MCbI7PLENt706MOeI2M7BtjhxNOvSn9cvtmI+OkH+wDpTNyd4Inqf2" +
           "lH3qlSq7elllf+4mbR/MivcF0MVcWdzxbNk0m07elh6q+OSPq6IEnm/uqfjN" +
           "/xsVz+YEZw8inLieqc6sTEfID5t/+bDI2T19k1l5Niueys7OXFX25BOT8Yuv" +
           "ZDKSALrj+HXO/gnb3de9+wHxfe81t8XbG07xs89dPP/a57i/zq87Dm4hb6Wh" +
           "86vQNI+eMx6pn3U9eaXlat26PXV087/nAui2IxIAgNur5fJ9Ykv0GwF0GhBl" +
           "1d909wW/56jgzPYfG/WSU8fx7mC+7nq5+ToCkY8ew7b8dn0fh8Lt/fpV8XPP" +
           "kYP3vlj71Pb2RDSFzSbjcp6Gzm0vcg6w7OEbctvndZZ47KU7Pn/rG/ZB946t" +
           "wIceeUS2B69/VdG23CC/XNj8wWt/7y2/9dy38vPK/wVJLkmE9iAAAA==");
    }
    public void kernelBegin() { validationImage =
                                  (new int[resolution *
                                             resolution]);
    }
    public void kernelMain() { org.sunflow.Benchmark.BenchmarkScene t =
                                 new org.sunflow.Benchmark.BenchmarkScene(
                                 ); }
    public void kernelEnd() { int diff = 0;
                              if (referenceImage !=
                                    null &&
                                    validationImage.
                                      length ==
                                    referenceImage.
                                      length) {
                                  for (int i =
                                         0;
                                       i <
                                         validationImage.
                                           length;
                                       i++) {
                                      diff +=
                                        java.lang.Math.
                                          abs(
                                            (validationImage[i] &
                                               255) -
                                              (referenceImage[i] &
                                                 255));
                                      diff +=
                                        java.lang.Math.
                                          abs(
                                            (validationImage[i] >>
                                               8 &
                                               255) -
                                              (referenceImage[i] >>
                                                 8 &
                                                 255));
                                      diff +=
                                        java.lang.Math.
                                          abs(
                                            (validationImage[i] >>
                                               16 &
                                               255) -
                                              (referenceImage[i] >>
                                                 16 &
                                                 255));
                                  }
                                  if (diff >
                                        errorThreshold)
                                      org.sunflow.system.UI.
                                        printError(
                                          org.sunflow.system.UI.Module.
                                            BENCH,
                                          "Image check failed! - #errors: %d",
                                          diff);
                                  else
                                      org.sunflow.system.UI.
                                        printInfo(
                                          org.sunflow.system.UI.Module.
                                            BENCH,
                                          "Image check passed!");
                              }
                              else
                                  org.sunflow.system.UI.
                                    printError(
                                      org.sunflow.system.UI.Module.
                                        BENCH,
                                      "Image check failed! - reference is not comparable");
    }
    public void print(org.sunflow.system.UI.Module m,
                      org.sunflow.system.UI.PrintLevel level,
                      java.lang.String s) {
        if (showOutput ||
              showBenchmarkOutput &&
              m ==
              org.sunflow.system.UI.Module.
                BENCH)
            java.lang.System.
              out.
              println(
                org.sunflow.system.UI.
                  formatOutput(
                    m,
                    level,
                    s));
        if (level ==
              org.sunflow.system.UI.PrintLevel.
                ERROR)
            throw new java.lang.RuntimeException(
              s);
    }
    public void taskStart(java.lang.String s,
                          int min,
                          int max) {  }
    public void taskStop() {  }
    public void taskUpdate(int current) {
        
    }
    public void imageBegin(int w, int h, int bucketSize) {
        
    }
    public void imageEnd() {  }
    public void imageFill(int x, int y, int w,
                          int h,
                          org.sunflow.image.Color c) {
        
    }
    public void imagePrepare(int x, int y,
                             int w,
                             int h,
                             int id) {  }
    public void imageUpdate(int x, int y,
                            int w,
                            int h,
                            org.sunflow.image.Color[] data) {
        for (int j =
               0,
               index =
                 0;
             j <
               h;
             j++,
               y++)
            for (int i =
                   0,
                   offset =
                     x +
                     resolution *
                     (resolution -
                        1 -
                        y);
                 i <
                   w;
                 i++,
                   index++,
                   offset++)
                validationImage[offset] =
                  data[index].
                    copy1(
                      ).
                    toNonLinear(
                      ).
                    toRGB(
                      );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8taG7rdEip+ah0CMm3hP5Ia1L214mjtsOcZofI5TjnNF4MXmgCtaVAsIn8Ff" +
       "CK7/4oWi4wORTmtb7Zw+O5PUDQPXvymgCs8GENlc+/rGO48eEAC8RY9nMN26" +
       "/frPmrdtF14oKsO5OcWZm0ZUhwIONp0o3ZygWThF+98ObX7gns1bhFS12XVO" +
       "G5TxB/74n6ebd/zlyTypt0ixq3tczJAIThhHs9dGALr4+1UP3lhb1A7xv5OU" +
       "JzXl8iTtjLk5QmFrJftdi+VUnPyBGxouDCOh+bgG+KTdRow/y133Kxkp69d1" +
       "lUqaV1D8dw3n+Q3e8Nu2gIhyKTYX8a5zsFkspjjv83klPrjQz9WW2/6yvHBX" +
       "8yP1ACnhcpTgvx0O5kzTwWeKB6DnJafkoO8vHL2gmM6flWPFl1Vw8f24Uy/s" +
       "e+GcP+y96bZhYZcBXuahm/LJSrX/2r9+nBPJeXmUx/E89L2R/XdOa130Lqd3" +
       "6hSknpvKrVKhknNoz9iX+DBcX/pomJT1kmrZ3v+uldQkZv9e2PNZ6U0x7JGz" +
       "+rP3b2Kz0pKpw2Z4Pd81rbdCcjtUMctyHqcoGovLMh2u2bb5zPZaXojwG0sY" +
       "H2+bsFmQrkHKDFMZgjjoKUIqA5gyUmHiHjqZLpQ6HPvmRsVOZFSJbAS415lj" +
       "TzbHB8GVjvsM5YrqRw2iQtIdXplkRpJl3MQl6uYCRf0aXPX2ZPU+ol4XKKof" +
       "NQOxQNTM1sdf5u98AfXOtWed6yPz9YEy+1GjeqUh6i/qDwoUdQpcDfZkDT6i" +
       "3hQoqh81WDqWYJI4b/Fa7M0Fyol21mjP1Ogj545AOf2oGRlvpndOnQlpgGYf" +
       "jGaqJF5gi5x8SeVjv7HufvuwiLH5ajDPUcw9e8vlVxKP8RoMJ12aEW88SlND" +
       "RFAh6V9G+r/8kYGsmzRipAuXyGpTgRCp0i6oitMHE/+HWbCaavTPQi6t7vrJ" +
       "3Gev2jX3DV75lysWxGqoNvMcjrlo3t//+rvPj6s7yHfHxVi08qjtPVXMPTTM" +
       "Ogvka1KFzY/5bUdOccYtUgywjW1v/gAfxttTGaQWRZNUzq0T9p0q1QbE6dMK" +
       "bPbY5RdOERZ0/P8pzN7SYTZrblV1jeLuMN0nDmUUvTlzAAudqRxhTVKXVSF0" +
       "cahOuq343mkToiwVzz2NQU4zfc5b5vsvoneCx699Z9rqRYPrCzhqmeVZYy/L" +
       "n3btf3LpPPnmMD+5Fdk958Q3m6glO6dDCmVJU8sui+udRd/jKhf5sgUUdb8O" +
       "6HsAm1+CBci4fGK1A4Y/bNd4xLuM+O8aVyHLw+YdBYZNzHnz7Mgyzyds/i4w" +
       "bPpRwwZ/CEwwxheWx018fJdH3ke+QOY82Z7xZB95nwyU148awjw1Td1cnT4W" +
       "yJeVfh8gbirfdoL/lRLPKbJrWlfpXpR249nuk1drxGI04RzArsagGzBwjUWh" +
       "hHVHMxg4xT0QI3LzxYplqNIIRt86v3cLfB+7+9rtu2Ir95yeTk3djIxhunGq" +
       "Soeo6pJ+PL8/nEFei0Dnw9VkI2/yLpejW98oWWrxl02eUrgmgKvHk9zxeacd" +
       "VO+2f0Ev1U4wFa928gd2I21a7wSJi80+EdGx+Vkmmr+dG83x3wPYHMoNz1yP" +
       "Bmf0Njb3B0SH4wF9H2DzHjYPCikCxn4YHGX4mLcC6D/G5lVGihOwq8t3WlA8" +
       "pCsxx5Fe+4J7fMe++B5/KlyDtiUMBthXtlNm9vh+pP5AQyUBfWXYQG1WRlNU" +
       "TjIe8D7JYA6FRgdzHVxv2oK/WThmP9IAXDUBfROwGctI5UZqalRdQgcUzYN7" +
       "3OjgngHXUVv4o4Xj9iMNwFYX0DcLG4ggFQJ3l5QDe+rowMZ6/5gt+7HCYfuR" +
       "BkBrCug7BZsGSAECdpsW86BuHB3ULRB6bMnFb0GofUk9yIqy8+6MfOm0swE2" +
       "bUmnxs6bczsbuiF7sGgmJ+bLLVyBCwOUewE2p0FlaCAzj2JPHx3FLgStlNna" +
       "KStcsX6k+RWLcp+Hz3gdxc9CQ0sDFIB5M7QECwzJ2tjDJNOrhNbRUcI0QFBp" +
       "I6ksXAl+pAHIegL61mCzgpFygVo3PKBXjg5oKHhDVbbkVYWD9iPNX3A5690X" +
       "gFzCpheCKCJfY8BewZsz140O9q+DSBNsABMKx+5H6mv1tsE7WtgYoAU8NwjF" +
       "QQsK7pLyZdCB0TP7yTaUyYVrwY80ANpwQN8INiaYPYedm0ms0QG9CCS2z87E" +
       "b2Gg/Ug9wLyvgVxNOh9MdicOjhnfIesmV8Z1AYrags23ISpyonZFVT2aump0" +
       "NAXUIXubGvJuUz+HpvxIP7+mHHe5KUAdt2DzQ0bGcnV0m9SQTG/YuGF0NNIG" +
       "cOyT9lDOOf2JNeJHWqDt7MxwbkNGy+B6RnAWv4x888sf04pKJsIPaoCMqukj" +
       "4K+Mt70Zx+W6K3UiJzEMI2BrGtoZYC97sdkBOxTOLm+WOeGpWZ53ruCPmTMZ" +
       "/DRkSs53tOLbT/ngrqryybvWvCSOoNPfZ46NkvJ4UlXdLxVd96WGSeMKt7Gx" +
       "4hUjPxAIHQQcLhUxfLXP71DM0AEx6OeMFMEgvD1s5ClHxVvQlDhpmG7DymiD" +
       "TDyRNjIk7i+t8NCXf3GcPqBNim+O++RDu5atuOL42XvEl16yKm3ahFwqo6RM" +
       "fHTGmeIh7xxfbmlepR1Nn46/d0xj+jSqRgjs+OJ0Z+XJhWAkBq7NNM9nUFZD" +
       "5muol3ef//AzW0ufD5PQOhKSGJmwLvd9ccpImqRuXTT3+4u1ksm/z2pp+tHI" +
       "ogXx917hX/4Qcco+w398nzzmk22b5lih5jAZ00lKFC1GU/xF9sUj2ioqD5lZ" +
       "H3OU9utJLfO2YjwakYRbCq4VW5njMk/xK0FG6nO/asn9crICTIeaS5A7shnn" +
       "ORJPGoa7l2t1NTadKRF5ivqiXYaR/pynkWsdfBVN71Hun/8DvPLy3EowAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C9Dj1nUe/11Jq5e1smRbimxZK2llS0KyIEGCBKLYCUES" +
       "4AMvPsAHXGeNN0A8iQcJ0lXsOG3kqRvXTWTX6cRqO7Fd11VsT9o0bTOu1cm0" +
       "SSaZdJLJ9DXTOK0zUyWuZuxO62bitOkFyP+x3N1fWu+aMzgEcF/nO/fcc+65" +
       "9+Ll1wq3R2EBCnxnbTh+fElL40tzB70UrwMtutSlUV4KI01tOFIUjcC7y8oT" +
       "Xzn/ne9+wrz/TOEOsfCg5Hl+LMWW70UDLfKdpabShfPHb1uO5kZx4X56Li0l" +
       "OIktB6atKH6OLtxzomhcuEgfsgADFmDAApyzANePc4FCb9K8xG1kJSQvjhaF" +
       "nygc0IU7AiVjLy48fmUlgRRK7q4aPkcAargzex4DUHnhNCxcOMK+xXwV4E9C" +
       "8It/58fv/+WzhfNi4bzlDTN2FMBEDBoRC/e6mitrYVRXVU0VC2/2NE0daqEl" +
       "OdYm51ssPBBZhifFSagdCSl7mQRamLd5LLl7lQxbmCixHx7B0y3NUQ+fbtcd" +
       "yQBY33aMdYuQzN4DgHdbgLFQlxTtsMhttuWpceGx/RJHGC/2QAZQ9JyrxaZ/" +
       "1NRtngReFB7Y9p0jeQY8jEPLM0DW2/0EtBIXHrlupZmsA0mxJUO7HBce3s/H" +
       "b5NArrtyQWRF4sJb97PlNYFeemSvl070z2vsj3z8g17bO5PzrGqKk/F/Jyj0" +
       "zr1CA03XQs1TtG3Be5+lPyW97asfPVMogMxv3cu8zfOrf/XbP/aD73zlN7d5" +
       "3n6NPJw815T4svJZ+b7fe0fjGfxsxsadgR9ZWedfgTxXf36X8lwagJH3tqMa" +
       "s8RLh4mvDP7t7MNf1L55pnB3p3CH4juJC/TozYrvBpajhZTmaaEUa2qncJfm" +
       "qY08vVM4B+5py9O2bzldj7S4U7jNyV/d4efPQEQ6qCIT0Tlwb3m6f3gfSLGZ" +
       "36dBoVA4B64CBa7HCttf/h8XeNj0XQ2WFMmzPB/mQz/Dn3Wop0pwrEXgXgWp" +
       "gQ9Hiac7/gqOQgX2Q+PomQB9YLpSaF/KNCv4PtSZZjjuXx0cABG/Y3+AO2Bs" +
       "tH1H1cLLyosJ0fr2ly7/9pkjhd9JAOgiqP7SrvpLR9UXDg7yWt+SNbPtNCBy" +
       "GwxeYNbufWb4/u4HPvrEWaAtweo2IK+zICt8fevaOB7undyoKUDnCq98evWT" +
       "4w8VzxTOXGkmM9bAq7uz4nxm3I6M2MX94XGtes+/8Op3vvyp5/3jgXKF3d2N" +
       "36tLZuPviX0hhr6iqcCiHVf/7AXpVy5/9fmLZwq3gUENDFksAcUDNuKd+21c" +
       "MQ6fO7RpGZbbAWDdD13JyZIODdHdsRn6q+M3ee/el9+/Gcj4nkwx3wKuxk5T" +
       "8/8s9cEgo2/ZakPWaXsocpv5nmHwmf/4u39SzsV9aF7Pn3BYQy1+7sSQzio7" +
       "nw/eNx/rwCjUNJDvv3ya/7lPvvbC+3IFADmevFaDFzPaAEMZdCEQ81//zcV/" +
       "+voffvYPzhwpzUEMfFoiO5aSHoHM3hfuPgUkaO1dx/wAk+CAIZRpzUXBc33V" +
       "0i1JdrRMS//i/FOlX/kfH79/qwcOeHOoRj/4+hUcv/8BovDh3/7x//POvJoD" +
       "JXNJxzI7zra1cw8e11wPQ2md8ZH+5O8/+vO/IX0GWExgpSJro+WGp5DLoJB3" +
       "Gpzjfzanl/bSShl5LDqp/FeOrxNTh8vKJ/7gW28af+tffTvn9sq5x8m+ZqTg" +
       "ua16ZeRCCqp/aH+kt6XIBPkqr7B/5X7nle+CGkVQowIcbsSFwKqkV2jGLvft" +
       "5/7zv/71t33g984WzpCFux1fUkkpH2SFu4B2a5EJDFIa/OiPbTt3dScg9+dQ" +
       "C1eBz188crX6UzvNoK6t/hl9PCNPXa1U1yu6J/7bcg5uA0J55pQZY2i5YKAs" +
       "d14Wfv6Br9u/8OovbT3ovkvey6x99MW/8ZeXPv7imRPzlievmjqcLLOdu+QQ" +
       "37TF9ZfgdwCu/5ddGZ7sxdZ3PdDYOdALRx40CLI+fvw0tvImyP/+5ed/7QvP" +
       "v7CF8cCVbrsFZqW/9O//7+9c+vQf/dY1PMlZazdZ/dGMNLYd2IoL52TfdzQp" +
       "tyidnOQ43nuK0jMZwfMkJCM/vK0MvSnF6e16v3fjinO9onsQbs85uD17JI7R" +
       "HhEib2l8Cu5pRvrHuAc3gnub9+H86Z7TlZfM5trHPu3hP+cc+SP/7c+ushq5" +
       "K76GPu+VF+GXf+GRxnu/mZc/9olZ6XemV09NQFxyXBb5ovu/zzxxx785Uzgn" +
       "Fu5XdkHPWHKSzNOIYKIfHUZCIDC6Iv3KSft2hvrckc9/x/6AOtHsvjc+VmRw" +
       "n+XO7u/ec8D3ZlJ+O7gu7LThwr4iHRTyG3mrSzm9mJF3H/q7c0FoLcF4zGtu" +
       "xIW7wywmSg79LXGsiXn3K6/X/e+/krls7vr4jrnHr8Pc/DrMZbf6EV/AUK+4" +
       "JA6S+Eh7T/Bl3yBfT4PriR1fT1yHr8Ub4evBjK+jSer1GQy/B8E9uWPwyesw" +
       "mL4xwUlL7fp8rW+Qr4fBdXHH18Xr8PWhN8LXucz7StuYd1/LPnyDTGWa9dSO" +
       "qaeuw9RPvxGm7gsPZ8gdFwTJwGQ9dX2Tlc+ntu7zpc8/+bsfeunJ/5pPSe60" +
       "IjCw66FxjfD5RJlvvfz1b/7+mx79Uj5tv02Wou0Q3193uHpZ4YrVgpzze6/0" +
       "D1kE+eBOHPl/XJjcfKCn+KEGE4lia3E+2zqMIb9fVefIiCOfcrDtrm33Z+Tj" +
       "hz37s9fu2TPZ7dMxMKuWJzmHPXyHo3nGNtzOte5ngvSoiTPbcvnzW+Pd1Dmz" +
       "5Jcaju9p2Sz8MG0bhVr+paMVJ5CYXsVsWHj2+vrD5N147Hd+4yN/+sjoveYH" +
       "biD8fGxPvfar/EfMy79FvUv52TOFs0de6KrlqCsLPXel7wH+IE5Cb3SFB3p0" +
       "K/9cfidmKbmIT5lL/OIpaZ/LyN8HvaVkot72zCnZv5AW9mzGCzdoMzKr/67d" +
       "IHnXdWzGP34jNuP8EvS/mvdUbjRy3veYe/l7sP7v3jH37usw98tvyKBpYeiH" +
       "o8NA51rG9p+8Lm95XekBmC3cjlyqXSpmz//i2q2f3Q26O6J8sTZ7+uQhLw/N" +
       "HeXiYSAw1sIISOzi3Kkdjqn7j8fbdrlzj9HGG2YUjLv7jiujfc947mN//Inf" +
       "+VtPfh0Y6G7h9mU2VwPD50SLbJItJv/0y5989J4X/+hj+ZIAkCX/3c3Xns5q" +
       "/fXT4Gbkq1dAfSSDOvSTUNFoKYqZPIrX1CO0e/HIbUDnv3e08YNxuxJ16oc/" +
       "uiQ1pnUlHUzjqYhMZC5aLa2iHrl9a1YbKKbfrM/qy64dIuuxKMfdZseYI2It" +
       "kElPrEji1HUchbaGSKNNpJN2PaCJLjkVmTYBt0ihO2y3yYYym8wtizHNerfh" +
       "d4ymMiOb/aHZ6S9rSy9GRE8titG6YS0SWx3pOgyr8FIvT/laE6eG1nq06fUl" +
       "CZnNiXAiIZvRhBbtyVyeLGx3EpuuimNJiSwa2rQ9LqVyYAl4QKcGSo+7QjSR" +
       "x5pPhWx1KCLWRNgMRWoR+80hRbJFN5YMtNskyVI57A6Y6WJEWIuOlUTDCj5o" +
       "08SEWXD2wKWZMb8Yzduy1CSswKp07NYQ7Yo0VU7W4x6Qe5XROowHdaRyEi5W" +
       "Yqsrrqu0rYU+4TodyxqKvi1ZmZcXrBmaqs2x3SfHIlYspqJfXtTjmByuaTpK" +
       "B30dwccDHNcS1mDHOkG0vJHKyOZESvxAipssMXPGSm3EBoIbMstuXHQGDjms" +
       "EnN+2GqVeMonu50NEVCL4qax6OuD2tj2namnkJYkVG3TLzaYDeO4M9tyHbop" +
       "qm1ONAQGjWrkZmbXa1yFnfjMmtC4KLA1pDwtiXjSMQVc7CwGWkwok37fiFr2" +
       "UiL6bmJ5QShUyAWXTp3efDWhywLJDcbUZLRUeyVn3jOGw1V3jeKTxgZlqHhk" +
       "K5tF1fCElkyJQzFciMZA9wh3Co/T7jTot+tc5BE9s4FUykx90qPqM0pU6mGy" +
       "Gc78cs9ZMPbY0SxjQ5mJsKq35nQr6LPVAFiIudBtB4Q0G/YWQb3U0qJmMa63" +
       "ZpNFr1kXF8yIZx0r9JFu252zrWat2OjglVpAkpWVtEonRLeTMni9Nveoxjjw" +
       "nMlaFqC0JClLqNgLBYa202an3ePW1rI7rcck08RbC2qhuMQI65sU7w0QaNSd" +
       "I0VWWHWa3ZpPDTdUuQ072CyabJqbtUkYG16BZo5elBfMpoqyZbyCQnJRDYqy" +
       "SfWESc13/B7tVSaKVnLLZZUbMlazMWKCVcrUXJXTBuMZjlehAMfZ4mqhGXYg" +
       "95KuyRqDzWTtzeuCIwb0QhBZSyVn3dRpxmMjrEGYLU7r+njUX3hATdN1ucfZ" +
       "bro2oXF1mcIC2VImvUavlxBaUetWobjaRxoNeJS6LbvZq6zJXkU022laxsTq" +
       "rMJUDVuyJ4OusOnjRbe8sAhsOu7E3ZYwi5MOToRVsh32+pMxPDUtatprqUVl" +
       "za9hghUNpkGJFLocRP56aVBKTxFWs6Y/rqcjDmsuqg25PPIlfy3pOo2g3R5S" +
       "Wek1z6QpYyUupRURtVSjjEBrmYHSbo8Zop4/GlktoelMsBZamfqcLAUo3nWq" +
       "NX1CVqgSxfCk38MsilzojjCW2n2cNyEBgkSYLs+tzQxmUboy6FKdbp1H+oMu" +
       "OudVY7zZtHouHTOzlOjBfrfCyUQbZrrolPC6dgrXS1IVq86VpTGPap2o3m80" +
       "0G55VtywI7Zt4EqA6b0EafNlv0ghsqoocIR1cc5eOkKPlkvl5XRjJNAIrcCT" +
       "2mJZq7bZ5oQcNulWq2JpoxVbMVmmXNwEbQe2yoHQCWZrg1xNm8rI9gO1qpvT" +
       "VV9kddVEVz6yMGNIJ1qxbOnVOltFEAMm9Fq3ZM+asUg12pJlKGQTF6Y4YdRg" +
       "eBSVMdiu2mgbHwZTLqmaISOMhyIh0jNMZGe1IBzNAnNKLWuJBaGqOJ/gYppU" +
       "mIECsyzSIeJesd+ftLp9rKzpCb9xSiVYhiedyqwamcTCLiJ9bDwc+s1WAI0s" +
       "o9Fn2AgbpNXOoBFUaCdgV6nPhmSv2yv14GHcQmGnPNb4AIdxc0Jrad0cqgFT" +
       "ClYzQ+awqkOv2TE/1aWlK6bskBGZKjdnqKHcqK6GbQyhR05L7M/jfmmD6yom" +
       "W8XWqlMiWiqNCAN02WAVotJfIo6t6JVhWSyH1U0kuatpR9ZrIpwMFxN+6VEk" +
       "jukxLONmBQezcpZuL1VJLTqUtakvZSIYrdrVNYsRxSE7M+bNZbjugHEWC3Nv" +
       "RbenSd3vo9XyOPD7G7IrOi7F05ZXwxBMd+URlAw7Q9lSxgurRiLWNBGpPjNp" +
       "aiXCanGBv6LptEdzpRU3Gk3aQ4+u+xvUQ8dQEPsjIqEqZXgSrmmspidQVJKd" +
       "odIvIclyvS6NJk6gezChmhUEK3NxsQMLUalGTrmRVWMtejAV+SiGGo2eb696" +
       "E6rWpI05VythsUTVQrVlBZBkAl/glk0e7UglGilV3HkccYro6x10NPdYssJM" +
       "XaMRS+N61PEwUm/0anDFn1iVFTcYubFcE1cQh/JCs89Pl2uQNcKoFusoEBxS" +
       "XAXTWvUGNpjhHsMiVVgPeTdUY7JU8XsRh3LKRHSLomCuOhwbFP2yuDYmI5OE" +
       "cIyTpzXDA3BNclhCpmOOQkcpAdcqXlWTVXjjZOFwXLTSRTlWNt16Z2Sa7QhX" +
       "qTodVqCSwJcdUy7Va+kS5YTuZupg1iie0zbad8mwq8eqBY0Fj18TVOonzQZn" +
       "QrJBQb2ROgCB5bpULvdSO6jiaskRFtK41MTUVdmD+mUNYxPE6Jjr3mg2xSR0" +
       "E5F2FMznS6xsO3w472/wyQSBq+tlm5hia75Ub3imEoyMZVrkUHszWk20HlFt" +
       "el1Jt30OW7ZpxHCZqu5MeNIpjVeYjlSENRxpEKXw0BqvyqI5ExVimkimC9Pd" +
       "YTiFkRCHPILvalNXSOEWhtPIAJ6qnFQqF+mFWq6aQ9sLlr1w3DNtj/U3uDWF" +
       "moQyhQPf7Y5KthuK5SWUOGrfFpe4hvCsWBWKaa1LbaCQL8tIb1MMesEKESu8" +
       "ipVCWW0o81hglHjdXig+5S9pxkQSRJbRDS9KU3++oorRrI1AckS6/dBu95ok" +
       "Ixrzud8TOos6aqwFt2215wuRDvrVNr90B9GYE8lhV64PKyXUmY82cpvAqPF8" +
       "GTHoLFwMVojVjzvqNHDsQdB1ykzfqSazxkAvSlN+ioi8APlOZdrr+Trb59I+" +
       "O2JKkaqjCY7V9SkXTzS1uuY3+Ky1hkrUXFsIZtWCF82VL6j9QGnqot0cVa2y" +
       "2fcXJlaaNBeTWbdTkWFSqjFFcu07SMmd8yXOmKMVtM7piE8NnGXgqZzXdwKD" +
       "mulzSlp0SdSw0BQbaoD1WjvRl8nKotuoNG/ygrLCNWzpjNMejw18pltCpNYE" +
       "w4YO2xyQdbM6xikohDF7RkXuZmAF9WS6poCyAENZtKq+FTPtFgy1J3JDkpYj" +
       "vm9V49oy7JYpbYnMp+XmuIY662iSUgufXTLKPHT8cgzDULjk59Wotm7r7XRs" +
       "FbHFPObHU4YfjRjOWNpSqQcmejAqCyqnKLNYMNar+aS0hI26nsbxiJL6k4HI" +
       "CptFcYQHxUWpL7eqKtOTeXmGDlSuNRCLMI8FG7Y2nI3EUHbGpblGJwxb9Jqu" +
       "ICxHzqZeT9TFIDVH4950PCSLimRyyaJcKbv2yLdWwMEibF+obHQFldFltATh" +
       "eyOt4riIg76f8WFjYy5cbSzO1jDtleVYL9MBz3su04RQUrVxFOuX3arhcFW1" +
       "2XDBFB+LgLdK1IEKz3umjkaGIKgyxlXbUd0tQQ1CsSo61SvVKzNYZtVKCtiF" +
       "OEwar9v0CpqpxExkN21vU2OM9WatRjCwcDIfDFYrEW60VqvU1CZpsYTpXbVd" +
       "tjWoz80wEP6kIoGj3motlCqYtJqvSiO1pHijymTd1ca6iRmyFeqqT8POgOZ7" +
       "cjecOHowDQZIBfcSu6SGKdUpVgabehhJBrUhVnNhAizZuM2kRiUdFfudMr1J" +
       "Z4GzYDudQYxVl2WF1gmoBuFhnCCdEEfX2sguq/NOaiYetRj6ml8NuhBPY7DX" +
       "IjWr2PRW+NjuIPCaDjTgyzF/MglTp4hoQmi4Rm/ZtvFNqkmKOuYgRC+2liWh" +
       "siIlHMEMFekgJam2GnYtrAi1VCqFxrbrhpBKYeW0vOJnbcZnN6U1T7h6kZ3L" +
       "ZeAh26A03kaam/Z8xjcsu5F6lVmbmlZcWmlUmzCFOmPKMrnVAovLE6eOBY0o" +
       "TVFSgyrdms5oEESgcM9ZN2NLYIjYnMYO6+JLEwp4tN5fC4Q+mc76VGkycFhh" +
       "NO9oWLPWndWr5MBQN+1xukT8Hgz8iMvjnfq0CfIPuBWlxB1UEBeSM1D7hiJs" +
       "ZmytzM0Nz2hPhfGy4lemc9xi2BU5mxabCk1VDIPsd8sO2m9qUOivGLEKo0YM" +
       "1dqNmZ4MCJsIG4lRI8SIGtZbDTWIJliVSNpEWaAHRFVmPFIuUr4u2Pi6s1hj" +
       "UJXRObcYrVqILLheGlVlZRPJiUXWIspwu5BM0+M10VhxggbyBEXSkRr1zRzp" +
       "8u20TNLGEIjBk3rDWImmVRsaTGglgNqbsqGmCt7oF6Mm2SFQptZvNVabLhLP" +
       "m12WC01WHghKp9gniaBTtaNp3YGCerujGXS15DY2RkCujbFf5nvEdG6gfq9t" +
       "NseybI9nkyZu8ey0XEereHFqkJtGYGqNXqOrzzBCW4nRplQpcvgCag4JNqoT" +
       "TC+F0HbVXZbiqFWbxMbMrwsYu5qT/X7UqwX0WlQbRHHE19YjSVjPxuFqhhXr" +
       "bLDqs1iHtaQZP9NUt+hGxT6FNxpDZIPVWjJCGbBg4CsaxAvjlOVMnFEthZub" +
       "nt7RIneMiaX6LJSMCCl3hsHa90RyPEKkxA2KbH0qdKaJTC27ibCB2sEy7fA1" +
       "yG23NbQn1NUY6Gi/KFOKNy66+LA/ouBZQpFFlu1QCrce4U6TA3a/y2rd9mTR" +
       "jGtMupJtllpDRHXg1SfLSophWKQXK0GvG3V4yW8wi8SeV3oQE9eKYgpNqr2y" +
       "YHU3LaaDECEV++Ksgdci1SY4EPDQLjThNCqYiGg5TBq8O2JEuDmwhxFajjla" +
       "HsGeES7C9VpeTpaNIeezvC5Wqqy97FYEZ6rS6VjFqxNqqDG9uEalFVOY82m9" +
       "0+73FdoUUp2e8rVSkynWW2mV0xiSaRnL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ZilCGw7wC8u+0zQDF8wK167VHDXXA3besWsWFGNsY6qXwfxjQbCWC3EQNGgm" +
       "qBQnHF1BpsuWU6que25ZMsnVwq8OGL09olytY9bSVJddRwsGJdarVGG1mM6h" +
       "+XAxAFESxHWLIjTtmpO6TSxqLMvgnkCKTdRNfAfEETBc30yKid5E+T5n9oZU" +
       "113RSxVXlKDjLgbJdDQqQ5WkZEcuvEGCAIrbHd+YpnipZk7hSl9RfGhVxjFv" +
       "s3FtBJFRxzLReV0sFp0e2ShRApySeCTMEctfNFFHbJc5AU/iLq1zyGy+kuzZ" +
       "QG4sKuMJ6s0ZG057RZKqehwsRR6uhJ3GqKNJQ7Rei0zP4wZdnvKlmoPEJXYk" +
       "qb0BiVrLhTWdSQM4WHv2BExEiDFbK7UTD8aaS55el1v+ql6vvydbfvt3N7Ys" +
       "+OZ8BfTo9OfcqWUJX7uBlb/0WocC8t8dhb0TgyeWjE9sw589XG29cPKUXbSO" +
       "Ys09Pmw3ynZtTskoRFrYuWJfCmR8+GTGbEvnUtOKAkdaZwc9Hr3eOdL8kMdn" +
       "P/LiSyr3udKZ3fI+GRfuiv3ghxxtqTknuN9ufX/mCPkDGdBnwfXMDvkz+4vl" +
       "x7K9zgZR3kvptbYuTu44feyoyezcRuGRLGHXZP4fFy5ffcTlhy8sEimyFokf" +
       "a09vz5Vd2K6LX8j3pC5sl7nf9/4LDNdsXWbrTGt44T0XPG21S/mg5MrPv+/S" +
       "pUvvf+6ZIMiZ/Nr1N8T+9HBn4LXXw7tTyIx86mhL4E+u3gnLHj+dkb979dZW" +
       "3hHbZvPSGfkHp+zY/K9T0r6Tkf+Zkc9vOTkl75+l2/9XT8nz5xn5Rly4zZUs" +
       "75oL7kvfUo9H3B/f8GGeYxXMD/P8ALjMnT6YN6CC+WbN09fUvhN4Ds6dknZX" +
       "Rs7EhXNaqilJnG8//cURtIOzNwvtUXB9YwftG7ce2oOnpL01I/fFhXtsLfQ0" +
       "h9AMy9uDd/5m4b0DXK/u4L166+E9dkpaZsUPHokLd2/hMdJV6N5+s+iys0Gv" +
       "7dC9duvRQaek/VBG3gXs+BZdy1P3wL37ZsE9t2eDbwG4s1f6yHdcy/V1LjK+" +
       "mhwfBbimf+xc5IEBj+nMf2X5vpbLpHaKvLL5xAESF24PsoJ7sirfrKxQAPvc" +
       "TlbnbqmscnQZyZ1IfqDwgDoFZ3YA6YDI/LsU2cNYCvexvu7G5+thBc754J4d" +
       "1ntuvdIPT0kTMsLGhTu34PxgDxt3s9jeDdg8v8N2/tZgOzjOsO29y6cAlDIi" +
       "ApuVARQCVbrK4bzvZiFigJnd6aXt/y1VVWJPVe1TwLoZ0QFYKzvXcS33Y9wK" +
       "XX1oB/ahW6+rq1PS1hkJga7m6K62z9HNYnsvYPPtO2xvvzXY9o8znyCH5vih" +
       "k+Y4h5Z9UuGHOeafOkUeL2TkJ4BhyguRluPsCeRDNysQUO5gF6Id7Idot14g" +
       "xzr+t09B/XMZ+Ztx4d4cNR9qgRTuD+mfuVngLYBhd5j14KrDrN8fTTgO2EpZ" +
       "g1VwIVsOtv9xYXiLzi3ugtzD45Dfj2rznvpr+xY7f84iv4O/t4v8Dn7x2nI8" +
       "PfI7eOl7i/xAs3np7PmUyO/gi6ekvZyRL2Qpn99yckreL20jv4PPnJLnKxn5" +
       "NAgZcnW+poP6+Rv6ggHYg6NVkex7qoev+mp5+6Wt8qWXzt/50EvCf9ge5z38" +
       "GvYuunCnnjjOydP8J+7vCEJNt/I+uWt7tj+P8g9+FSA4YcdAdLe7yxg8+Gfb" +
       "TP8yLpwFmbLbXwsOzd+JI23bzw/SbYc9fHJ45kHvA68nh6MiJz+ny06x5t93" +
       "H544TbZfeF9WvvxSl/3gt6uf237OpzjSZpPVciddOLf9sjCvNDu1+vh1azus" +
       "6472M9+97yt3PXW4HnTfluFjU3GCt8eu/e1cyw3i/Gu3zT9/6J/+yD986Q/z" +
       "M33/H3WIcZl4PwAA");
}
