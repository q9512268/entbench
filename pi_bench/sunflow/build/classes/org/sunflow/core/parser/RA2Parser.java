package org.sunflow.core.parser;
public class RA2Parser implements org.sunflow.core.SceneParser {
    public boolean parse(java.lang.String filename, org.sunflow.SunflowAPI api) {
        try {
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  USER,
                "RA2 - Reading geometry: \"%s\" ...",
                filename);
            java.io.File file =
              new java.io.File(
              filename);
            java.io.FileInputStream stream =
              new java.io.FileInputStream(
              filename);
            java.nio.MappedByteBuffer map =
              stream.
              getChannel(
                ).
              map(
                java.nio.channels.FileChannel.MapMode.
                  READ_ONLY,
                0,
                file.
                  length(
                    ));
            map.
              order(
                java.nio.ByteOrder.
                  LITTLE_ENDIAN);
            java.nio.FloatBuffer buffer =
              map.
              asFloatBuffer(
                );
            float[] data =
              new float[buffer.
                          capacity(
                            )];
            for (int i =
                   0;
                 i <
                   data.
                     length;
                 i++)
                data[i] =
                  buffer.
                    get(
                      i);
            stream.
              close(
                );
            api.
              parameter(
                "points",
                "point",
                "vertex",
                data);
            int[] triangles =
              new int[3 *
                        (data.
                           length /
                           9)];
            for (int i =
                   0;
                 i <
                   triangles.
                     length;
                 i++)
                triangles[i] =
                  i;
            api.
              parameter(
                "triangles",
                triangles);
            api.
              geometry(
                filename,
                new org.sunflow.core.primitive.TriangleMesh(
                  ));
            api.
              shader(
                filename +
                ".shader",
                new org.sunflow.core.shader.SimpleShader(
                  ));
            api.
              parameter(
                "shaders",
                filename +
                ".shader");
            api.
              instance(
                filename +
                ".instance",
                filename);
        }
        catch (java.io.FileNotFoundException e) {
            e.
              printStackTrace(
                );
            return false;
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
            return false;
        }
        try {
            filename =
              filename.
                replace(
                  ".ra2",
                  ".txt");
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  USER,
                "RA2 - Reading camera  : \"%s\" ...",
                filename);
            org.sunflow.system.Parser p =
              new org.sunflow.system.Parser(
              filename);
            org.sunflow.math.Point3 eye =
              new org.sunflow.math.Point3(
              );
            eye.
              x =
              p.
                getNextFloat(
                  );
            eye.
              y =
              p.
                getNextFloat(
                  );
            eye.
              z =
              p.
                getNextFloat(
                  );
            org.sunflow.math.Point3 to =
              new org.sunflow.math.Point3(
              );
            to.
              x =
              p.
                getNextFloat(
                  );
            to.
              y =
              p.
                getNextFloat(
                  );
            to.
              z =
              p.
                getNextFloat(
                  );
            org.sunflow.math.Vector3 up =
              new org.sunflow.math.Vector3(
              );
            switch (p.
                      getNextInt(
                        )) {
                case 0:
                    up.
                      set(
                        1,
                        0,
                        0);
                    break;
                case 1:
                    up.
                      set(
                        0,
                        1,
                        0);
                    break;
                case 2:
                    up.
                      set(
                        0,
                        0,
                        1);
                    break;
                default:
                    org.sunflow.system.UI.
                      printWarning(
                        org.sunflow.system.UI.Module.
                          USER,
                        "RA2 - Invalid up vector specification - using Z axis");
                    up.
                      set(
                        0,
                        0,
                        1);
                    break;
            }
            api.
              parameter(
                "eye",
                eye);
            api.
              parameter(
                "target",
                to);
            api.
              parameter(
                "up",
                up);
            java.lang.String name =
              api.
              getUniqueName(
                "camera");
            api.
              parameter(
                "fov",
                80.0F);
            api.
              camera(
                name,
                new org.sunflow.core.camera.PinholeLens(
                  ));
            api.
              parameter(
                "camera",
                name);
            api.
              parameter(
                "resolutionX",
                1024);
            api.
              parameter(
                "resolutionY",
                1024);
            api.
              options(
                org.sunflow.SunflowAPI.
                  DEFAULT_OPTIONS);
            p.
              close(
                );
        }
        catch (java.io.FileNotFoundException e) {
            org.sunflow.system.UI.
              printWarning(
                org.sunflow.system.UI.Module.
                  USER,
                "RA2 - Camera file not found");
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
            return false;
        }
        return true;
    }
    public RA2Parser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1YfWwcxRWfO387/nZsh5A4ieNEckjuCCUtyCmNbWxy4eyc" +
                                                              "fCFqnTaXub0538Z7u5vdWftsagpIVUylRmkwECrwX0HQCkhUFbVVC3KFVEDQ" +
                                                              "SiBUoBWhUis1/YhKVAn+SFv6Zma/z3ZE1ZN2bm72zfua937vzT1/FVWZBuom" +
                                                              "Ko3RWZ2YsWGVprBhktyQgk3zCKxlpCcq8D+PXxm7M4qqJ1BTAZujEjbJiEyU" +
                                                              "nDmBNsuqSbEqEXOMkBzbkTKISYxpTGVNnUAdspko6oosyXRUyxFGcBQbSdSK" +
                                                              "KTXkrEVJwmZA0eYkaBLnmsQHwq/7k6hB0vRZj3yDj3zI94ZRFj1ZJkUtyZN4" +
                                                              "GsctKivxpGzS/pKBbtE1ZXZS0WiMlGjspLLPdsGh5L4yF/Rcav7k+tlCC3dB" +
                                                              "O1ZVjXLzzHFiaso0ySVRs7c6rJCieQo9gCqSaJ2PmKLepCM0DkLjINSx1qMC" +
                                                              "7RuJahWHNG4OdThV6xJTiKJtQSY6NnDRZpPiOgOHWmrbzjeDtVtda4WVZSY+" +
                                                              "dkt88YnjLT+qQM0TqFlW00wdCZSgIGQCHEqKWWKYA7kcyU2gVhUOO00MGSvy" +
                                                              "nH3SbaY8qWJqwfE7bmGLlk4MLtPzFZwj2GZYEtUM17w8Dyj7V1VewZNga6dn" +
                                                              "q7BwhK2DgfUyKGbkMcSdvaVySlZzFG0J73Bt7L0XCGBrTZHQguaKqlQxLKA2" +
                                                              "ESIKVifjaQg9dRJIqzQIQIOijasyZb7WsTSFJ0mGRWSILiVeAVUddwTbQlFH" +
                                                              "mIxzglPaGDol3/lcHdt/5n71oBpFEdA5RySF6b8ONnWHNo2TPDEI5IHY2LAr" +
                                                              "+TjufHkhihAQd4SIBc1PvnntwO7u5dcFzc0r0BzOniQSzUgXsk1vbxrqu7OC" +
                                                              "qVGra6bMDj9gOc+ylP2mv6QDwnS6HNnLmPNyefxXX3vwh+RvUVSfQNWSplhF" +
                                                              "iKNWSSvqskKMe4hKDExJLoHqiJob4u8TqAbmSVklYvVwPm8SmkCVCl+q1vhv" +
                                                              "cFEeWDAX1cNcVvOaM9cxLfB5SUcI1cCD9sDThcSHf1M0Gi9oRRLX5XjK0Jjp" +
                                                              "ZhzAJgtuLcRNS80r2kzcNKS4Zky6vyXNICwdAf3i4wO38RQzYiys9P83wxKz" +
                                                              "oH0mEgHnbgqntgJZcVBTcsTISIvW4PC1FzNvirBhoW7bDjgComK2qBgTFROi" +
                                                              "Yq4oFIlwCeuZSHF04PgpSGHA0Ia+9DcOnVjoqYCY0WcqwWuMtCdQS4a8PHfA" +
                                                              "OSNdbGuc23Z576tRVJlEbViiFlZYaRgwJgF0pCk7LxuyUGU8sN/qA3tWpQxN" +
                                                              "IjnAmtVA3+ZSq00Tg61TtN7HwSlFLOniqxeCFfVHy+dnHjr6rVujKBrEdyay" +
                                                              "CqCJbU8xVHbRtzec1yvxbT595ZOLj89rXoYHCoZT58p2Mht6wjEQdk9G2rUV" +
                                                              "v5R5eb6Xu70OEJhiyBgAt+6wjACA9DtgzGypBYPzmlHECnvl+LieFgxtxlvh" +
                                                              "wdnKhg4RpyyEQgpyHP9yWn/6/d/85Qvckw7kN/tqdZrQfh/MMGZtHFBavYg8" +
                                                              "YhACdB+eTz362NXTx3g4AsX2lQT2snEI4AVOBzz47ddPffDR5QvvRr0QplBn" +
                                                              "rSy0KyVuy/rP4BOB5z/sYdDAFgREtA3ZOLXVBSqdSd7p6QaQpUCqs+DovU+F" +
                                                              "MJTzMs4qhOXPv5p37H3p72daxHErsOJEy+4bM/DWbxpED755/NNuziYisZLp" +
                                                              "+c8jEzjc7nEeMAw8y/QoPfTO5idfw08DogOKmvIc4cCIuD8QP8B93Be38vH2" +
                                                              "0LsvsWGH6Y/xYBr5WpuMdPbdjxuPfvzKNa5tsDfyn/so1vtFFIlTAGExZA8B" +
                                                              "oGZvO3U2dpVAh64wUB3EZgGY3b489vUWZfk6iJ0AsRJ0DeZhAwCyFAglm7qq" +
                                                              "5ne/fLXzxNsVKDqC6hUN50YwTzhUB5FOzAJga0n/ygGhx0wtDC3cH6jMQ2UL" +
                                                              "7BS2rHy+w0Wd8hOZ+2nXj/c/u3SZh6UueNzsZ7iTj31s2C3Clk33lFxn8U/1" +
                                                              "Gs7y8Yzw+QaKNpXVg7QEgS1KAfPu5tW6E95ZXXh4cSl3+Jm9oodoC1b8YWho" +
                                                              "X/jtv9+Knf/DGyuUojqq6XsUMk2UgGIgMlBORnnj5kHah03n/viz3snBz1NJ" +
                                                              "2Fr3DWoF+70FjNi1emUIq/Law3/deOSuwonPURS2hNwZZvmD0effuGendC7K" +
                                                              "u1RRD8q62+Cmfr9jQahBoB1XmZlspZGn1HY3StpZUGywH2ceSCmB3jzk2DDs" +
                                                              "buXBWL/G1hBiRPmJRp1Qa+EZwHrtmOi1nRed/hhMi++BVIIr8tU1UOg4G9IU" +
                                                              "VfEWJtiHsIhIW1kTega5CHVk2m6Mb0udkBZ6U38SAXvTChsEXcdz8e8efe/k" +
                                                              "W/xoa1ksuQ71xRHEnK/6tbAhxpKmb41rZlCf+HzbR1NPXXlB6BPu6kPEZGHx" +
                                                              "O5/FziyKZBJXn+1ltw//HnH9CWm3bS0pfMfIny/O//y5+dNR29P3UlST1TSF" +
                                                              "YNU9iYibr+uDXhS63v1I8y/OtlWMQJomUK2lyqcsksgFQ7XGtLI+t3q3JS9w" +
                                                              "ba1ZAaYosstBxjvYcETM9/+PoMwWBvUSAJHb+zKg3lB2aRYXPenFpebarqX7" +
                                                              "3uPA417GGiA88pai+Mzym1itGyQvc1MaRHHT+RelqGuVVpx1I3zCVTYF/Qzk" +
                                                              "T5ieokr25Sebo2idj4wyF/OZn2ieogogYtMH9BWyU1z7SpHyGnSH6O9u4HZ3" +
                                                              "i78hY4nA/7VwIsUS/1vA1WDp0Nj91774jGgIJQXPzfFbLsSHaDtd8Ny2KjeH" +
                                                              "V/XBvutNl+p2OIEbaEj9uvHDh/DlzdvGUIdk9rqN0gcX9r/y64XqdyDljqEI" +
                                                              "pqj9mO8/A+EpaLMsqFrHkuV5AIWGt279fd+fvWt3/h+/5+XdzptNq9NnpIlH" +
                                                              "309cmvr0AL8mV0FOktIEqpfNu2fVcSJNG4GkamLRiBmmcj/Y7mt0V9nNgKKe" +
                                                              "cqgov09B6zNDjEHNUnN2Wq7zVgJ/nzj1xtL10AZvxYeOUyKTRRtdkUmO6rrT" +
                                                              "Vj+p82RUwtjCF/nm7/EpG879F7rsSYjAFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
