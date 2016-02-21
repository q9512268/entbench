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
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wcRxmfO78dJ37FdpomTuI6Fc7jtm36UOtQ4rh2feHs" +
                                                              "HHZqCSfkMrc7Z6+zt7vZnbXPDoa2AmKQsCJw24Co/0pFQW1TISqQoJUREm3V" +
                                                              "gtRSUQqiBQmJ8IhoQCoSAdpvZvZ9dgp/YOnm5ma++d7fb77xU1dQlW2hTqLT" +
                                                              "FJ0ziZ0a0GkWWzZR+jVs28dgLSc/VoH/fvLyyN1JVD2BNk1he1jGNhlUiabY" +
                                                              "E2i7qtsU6zKxRwhR2ImsRWxizWCqGvoEalPtdNHUVFmlw4ZCGME4tjKoGVNq" +
                                                              "qXmHkrTLgKLtGdBE4ppIffHt3gxqkA1zLiDfEiLvD+0wymIgy6aoKTONZ7Dk" +
                                                              "UFWTMqpNe0sW2msa2tykZtAUKdHUtHaH64IjmTvKXND1bON7185PNXEXtGJd" +
                                                              "Nyg3zx4ltqHNECWDGoPVAY0U7TPoM6gigzaEiCnqznhCJRAqgVDP2oAKtN9I" +
                                                              "dKfYb3BzqMep2pSZQhTtijIxsYWLLpss1xk41FLXdn4YrN3pWyusLDPxkb3S" +
                                                              "8mMnm75TgRonUKOqjzF1ZFCCgpAJcCgp5oll9ykKUSZQsw7BHiOWijV13o10" +
                                                              "i61O6pg6EH7PLWzRMYnFZQa+gjiCbZYjU8PyzSvwhHJ/VRU0PAm2tge2CgsH" +
                                                              "2ToYWK+CYlYBQ965RypPq7pC0Y74Cd/G7o8DARytKRI6ZfiiKnUMC6hFpIiG" +
                                                              "9UlpDFJPnwTSKgMS0KJo67pMma9NLJ/GkyTHMjJGlxVbQFXHHcGOUNQWJ+Oc" +
                                                              "IEpbY1EKxefKyMGls/qQnkQJ0Fkhssb03wCHOmOHRkmBWATqQBxs2JN5FLc/" +
                                                              "v5hECIjbYsSC5nufvnpoX+fqS4LmxjVojuaniUxz8sX8pte29ffcXcHUqDUN" +
                                                              "W2XBj1jOqyzr7vSWTECYdp8j20x5m6ujP/nkg98mf06i+jSqlg3NKUIeNctG" +
                                                              "0VQ1Yt1PdGJhSpQ0qiO60s/306gG5hlVJ2L1aKFgE5pGlRpfqjb4b3BRAVgw" +
                                                              "F9XDXNULhjc3MZ3i85KJEKqBD9oPnw4k/vg3RSekKaNIJCxjXdUNKWsZzH4W" +
                                                              "UF3BEiU2zBXYNQ3JdvSCZsxKtiVLhjXp/5YNi7DqBDCURvtu4xVnpViWmf9n" +
                                                              "/iVmX+tsIgGu3xYvfA1qZsjQFGLl5GXn8MDVZ3KviKRiheB6BlAGRKVcUSkm" +
                                                              "KiVEpXxRKJHgEjYzkSKwEJbTUOCAsA09Y586cmqxqwIyypytBJ8y0q7ITdMf" +
                                                              "oIAH3Tn5b0d+d2Bo4Z6fJ1ESgCIPN00A+DtDgM9uKsuQiQJ4sx7we+AnrQ/1" +
                                                              "a+qAVi/MPjT+2Vu4DmEEZwyrAHzY8SzDXV9Ed7xy1+LbeO7ye5ceXTCCGo5c" +
                                                              "Cd5NVnaSQUNXPI5x43Pynp34udzzC91JVAl4AxhLMdQEwFdnXEYEIno9uGW2" +
                                                              "1ILBBcMqYo1teRhZT6csYzZY4QnWzIY2kWssDWIKcqT+6Jj5+C9/9scD3JMe" +
                                                              "qDeGbuMxQntDQMKYtXDIaA6y6phFCND95kL2q49cOXecpxRQ3LSWwG429gOA" +
                                                              "QHTAg59/6cxb77x98Y1kkIYUblInDw1Jiduy+X34S8DnP+zDip8tCBBo6XeR" +
                                                              "aKcPRSaTfHOgG4CSBoXLkqP7AR2STy2oOK8RVgP/atx963N/WWoS4dZgxcuW" +
                                                              "fR/OIFi/4TB68JWT/+jkbBIyuxQD/wVkAmlbA859loXnmB6lh17f/rUX8eOA" +
                                                              "2YCTtjpPOPQh7g/EA3g794XExwOxvTvZ0G2HczxaRqHmJSeff+PdjePvvnCV" +
                                                              "axvtfsJxH8Zmr8giEQUQlkLuEIFitttusrGjBDp0xMFmCNtTwOz21ZETTdrq" +
                                                              "NRA7AWJl6AvsoxaAXCmSSi51Vc2vfvTj9lOvVaDkIKrXDKwMYl5wqA4yndhT" +
                                                              "gI8l82OHhB6ztTA0cX+gMg8xp+9YO5wDRZPyAMx/v+O7B7+58jbPQpF2N7rH" +
                                                              "+Y/dfPwIG/aKJGXTfSXfNfyv+jquCfFM8PkWiraVIfiYDGkswJv5cvt63Qbv" +
                                                              "lC4+vLyiHH3iVtETtERv8AFoUJ/+xb9fTV347ctrXB511DD3a2SGaBHFQGTk" +
                                                              "AhjmjVgAYPVfuKU1Q0uFcuxnXDrXQfc966N7XMCLD/9p67F7p079D8C+I+ak" +
                                                              "OMtvDT/18v03y19J8l5SYHpZDxo91Bt2Fwi1CDTNOjOLrWzkZdHlx76VhXqL" +
                                                              "+/HmkbIQCMwTiQ39/lGeYvXXORqr+iSPU9JLoCae1qwjTomO2NtoD2fWmPju" +
                                                              "y6a5IuPXQZITbPgERVW8lYj2A+xxOObkbbjV1SLcBTNu+3pb9pS82J39vUjD" +
                                                              "G9Y4IOjanpS+PP7m9Ks8tLUsd3yHhvKmz5oM3WBNbNjPSqHnOo/BqD7SQss7" +
                                                              "p79x+WmhT7z3jhGTxeUvvZ9aWhYlIh4oN5W9EcJnxCMlpt2u60nhJwb/cGnh" +
                                                              "B08unEu6nk5TVJM3DI1g3Y9Ewq/CzVEvCl3v+2LjD8+3VAxC95BGtY6unnFI" +
                                                              "Wommao3t5ENuDd40QeK6WrNLlKLEHtPFu7vYMCrmvf8dsLKFQyUAE7/jZFi7" +
                                                              "pewhKx5f8jMrjbUdKw+8ybsf/4HUAMlQcDQtZETYoGrTIgWVK94griOTf52h" +
                                                              "qGOdBpj1D3zCNTYFPYVqidNTVMm+wmSzFG0IkVHmUD4LE81TVAFEbHrWXKMW" +
                                                              "xVOslCi/R+4SHdmHONk/Em6hWNrz/yR4eeGI/yXk5EsrR0bOXr3zCdHCyRqe" +
                                                              "n+cvT8gG0Sj6ULlrXW4er+qhnmubnq3b7aVppIUM68ZjD8nK262tsZ7G7vZb" +
                                                              "m7cuHnzhp4vVr0OBHUcJTFHr8dA7XngKGiMHbp7jmfKsh2uEN1u9PV+fu3df" +
                                                              "4a+/5je0WyXb1qfPyXX/XJrfZSdSSVSXRlVQgaQ0gepV+745fZTIM1akhKrz" +
                                                              "hqP7/3DYxHITMzzlXnGdudFfZZ09RV3lMFH+2oHWZZZYhxl3tyQjF4tjmuFd" +
                                                              "7lVV1KdocCtymWHT9Brez3GvmyavvCU2TH8Aitc9UCIUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u0FSlIu3f/Dg773tt174ZlGy+l9myaRv6R4AAA==");
}
