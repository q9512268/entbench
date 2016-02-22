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
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "142myK5vhQFHEMXic+KVD0//F0OLqPSnFgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "mNOFBTxH4xdzquMEG75ULZvJoBZqU6LfHQm6DMGzU0RRojgZbmnWIlbNZrY1" +
           "efsr2x3emW+ED68k4KYwa+i/gl1RfP0B4Sb9FsfVQ7hpPzpTy49Tbjt9un38" +
           "TO3ooAXJNoD3v9QFRL75+9h7n3lOmXy8tLd/QCXA/f7+vdDJA5vHX3qXO8ov" +
           "X45OTT7/3n+7b/YW7Z2v4Cz4wVNCnmb5B6Pnv9h7o/wbe8hNh2co11wLnez0" +
           "xMmTkwsu8APXmp04P7n/5Hns6/Ijk93Pv/557PUnKveMnT/c4PAvuEFblBVw" +
           "Q312Gej7d2bsMbfh4VY7tHXlyJ+2L7fLPj5CXmEeKpuTvRE+T+0r+9QrVVZ9" +
           "WWV/6QZt78uKX/SRi7myENQtYBgtO29LjlR894+qogKfr++r+PUfj4rncoJz" +
           "hxHev95UnVUNW8oPqH/9qMjZPX0DqzybFU9l522OBlxwyhi/+kqMEfvIHSev" +
           "gA5O5e6+7n0RjO97r7lN3t2Ayp967uL51z7H/V1+RXJ4S3nrEDmvBoZx/Gzy" +
           "2Ps5xwWqnqt16+6k0sn/nvOR245JAAFu/y2X76M7ot/xkZsgUfb6u86B4Pcc" +
           "F5zd/TdpMj5zEu8O7XXXy9nrGEQ+egLb8tv3AxwKdvfvV+VPP0eN3/Ui9vHd" +
           "jYtsSGmacTk/RG7ZXf4cYtnDL8ntgNe5/mM/uOMzt77hAHTv2Al85JHHZHvw" +
           "+tcbXRNmftmFRPonr/2jN//ec9/Izzj/H1BVMrIWIQAA");
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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UuyBXwnwsLIKVpKWCALUoIVUUrsTa7xu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "PwAA");
}
