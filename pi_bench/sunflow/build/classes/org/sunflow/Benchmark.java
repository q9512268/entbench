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
                                                                     kernelMain(
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
    }
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
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "TJFd3wgDjiCKxRfEKx+e/i/6EVLtnRYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "dRecyU3UKkDwQKKnHUoqxyq50hvdZKw0uwksIzpSbXJMYI0XYAPylrdkW5O3" +
           "v7Ld4Z35RvjgIgJsCrMO+hXsipLrTwg26eccT4/Apv3wTC0/Trnt5Jn20TO1" +
           "w4MWKNsA3n+ja4d88/fJp599Xhp8qrizd0A1B/v9vdug4wc2j994l9vLr1wO" +
           "T02+9PS/3Td9q/bOV3AW/OAJIU+y/IPeC19pvVH8jR3o9MEZyjWXQccHXTl+" +
           "cnLBk4PQs6bHzk/uP34e+zrwRHtmja5/Hnv9hco9Y+sPNzn8C2/SF2cF2FCf" +
           "WYb63k3Z5IjbzMBWO7J16dCf3JfbZR+dIW8wD5TNyd4Ing/vKfvhV6qs8rLK" +
           "/vJN+t6fFe8JoIu5sg3bs2TDIOy8Lz1U8amfVEUJPN/cU/GbPx0Vz+YEZw8i" +
           "nL7eUp1RDFvID6h//bDI2T1zE6s8lxUfys7bHE325BPG+NVXYowkgO44fgW0" +
           "fyp393Xvi0B833vNHfL23lP87PMXz7/2efbv8iuSg7vJWxnovBIaxtGzySP1" +
           "s44nK3qu1q3bk0on/3s+gG47IgEAuL1aLt8ntkS/E0CnAVFW/V1nX/B7jgo+" +
           "2f7jw3Zy6jjeHdjrrpez1xGIfPQYtuV37vs4FG5v3a+Kn3u+03/XS9VPbW9c" +
           "REPYbDIu5xno3Pby5wDLHr4ht31eZ+nHfnTH5299wz7o3rEV+NAjj8j24PWv" +
           "N5qmE+QXEps/ee0fvfn3nv9Wfsb5/8gqeLwMIQAA");
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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WYB0QUZIKFNNJzhVb5fkCt3CGm1KK/Wq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("w0qRGZtYYupFBRtMXJPjLeCdKKrYMUXRm/PTWir3u4roBpQmhP1lDamCdMqk" +
       "poKMsEFsDYt9xU+xYjhEaosuUp2MhHLQbsbiiOaYViXuqWJlSSNME485odpM" +
       "iwo+mU4qClVL8S48Idk0XJVtlhEbzVlj1tqEML+B+dRPLeAwNrA2DDVt0qRL" +
       "clTtMJy6IEetxEcGEO2rPbZt+wKmpfM0Cc1KWhyVEcsxofJ045U1hEaK3NSb" +
       "LSvtJQ2Sx+IKoQcbqVgGplidJyQ2aqaeZJHzigghTN+OA3+chJ4FQz7f3ZhT" +
       "YrlGWuuKBHyZyiicOZN6ZagoAgNihv2lq864gVxt9JBKuesofkIllZW+oRpy" +
       "v1Hpj2d8RbNYI5l02sNpGgMZ1b0WZnd4HWtON+pUhDdjEC1WWFOB1GK9iExM" +
       "W0eWFEEQ73539tju39zY48QH8ienRzs/l1YtK/jaDTwxTK61XSD/u6Owt1vw" +
       "xKPmEy/ozx4+pb1wcv9dmIaRah9vwxurYXRaRT5Ug/YVb6xAxUdPVsxeBV1q" +
       "GGCmpDTbAvL49faQ5ts/PvuRF19S2M/BZ3avBZpR4a7I9X7QUleqdYL77Uvx" +
       "zxwhfzAD+i5wPLtD/uz+Q/Zj2V7nxVI+S8m1XnmcfFP1saMhsx0dhceygt2Q" +
       "+W9UuHz15pcfuuDHUggivRup79zuOLuwfZ5+IX+XdWH7ePx977/QYxvU5T7R" +
       "o7gL777gqOtdyQcle/78+y5duvT+5571vJzJr13/Rdo3D98ofPvV8O4UMiOf" +
       "OnqV8MdXv0HLLj+dkb999SuxfCK2w+atM/L3TnnT8z9PKfteRv5HRj6/5eSU" +
       "un+abH+/cUqdP8vIf40Kt9mS4VzzQf3KNZRji/vDG97mc6yC+TafN4NjudOH" +
       "5Q2oYP6S553X1L4TeA7OnVJ2V0bORIVzaqLKcZS/tvrzI2gHZ28W2uPg+KMd" +
       "tD+69dAeOqXs4YzcFxXeYKpgWWbVVd1w9uCdv1l4bwXHN3fwvnnr4T1xSlnm" +
       "xQ8eiwp3b+H1pKvQveVm0WW7hv5kh+5Pbj264illP5iRtwM/vkVHOcoeuHfc" +
       "LLjnAJ9ntm23vzcP7uyVMfKt1wp97Ys9V4mPtxBcMz62Lw6AA4+YLH5l9b6W" +
       "y6R2iryyfOKgHBVu97KGe7JCblZWVQD7rp2s7rqlssrRZSQPIvlWw4PWKTiz" +
       "rUkH9Sy+S6HJRVKwj/VVX5i+GlYQnA/u3WG999YrPXdKGZ+RflS4cwvO9faw" +
       "sTeL7R2AzV3Kt/29eWwHxxW2s3f5FIBSRkTgszKAvKdIVwWc990sRAww8/AO" +
       "4sO3XFXre6pqngLWzogGwBrZfpBrhR/9Vujqm3dg33zrdXV9SlmakQDoao7u" +
       "av8c3iy29wA2H99he/zWYNvf6HyCHLrjR0664xxa9rGFG+SY/8op8nghIz8G" +
       "HFPeqGlY1p5APnSzAgHtDnbbZA+u2iZ7ywVyrON/8xTUP5ORvx4V7slRDwLV" +
       "k4J9k/6pmwVOAQy7nZsHV+3c/P+jCccLNjgbEAVHecvB9jcqNF7vBsfdqvZw" +
       "o+Qt6Sefi7+675Pz62xtd/B3dmu7g5+/tqROX9sdvPT61nZg2Lx1dn3K2u7g" +
       "i6eUvZyRL2Qln99yckrdL23XdgefOaXOVzLyabAoyBX2miHoZ2/o6wVg8UfP" +
       "PbJvqR696pvk7Xe08pdeOn/nIy/x/267lffwW9e7mMKdWmxZJ3fynzi/wwtU" +
       "zcjn5K7tvv58HX/wywDBCU8F1m+7s4zBg3+yrfTPo8JZUCk7/RXv0MGd2Oy2" +
       "/fQg2U7YoycNMF/WPvhqcjhqcvJTumx/a/719uFe1Hj7/fZl+csvdfof/C76" +
       "ue2nfLIlbTZZL3cyhXPbrwrzTrP9rE9et7fDvu6gn/3+fV+565nDJz73bRk+" +
       "dgYneHvi2t/NUbYX5V+6bf7pI//4h//+S7+f7/b7fz8xkD5WPwAA");
}
