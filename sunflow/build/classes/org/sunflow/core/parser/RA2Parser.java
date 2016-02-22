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
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwcxRWfO387/nZsh5A4ieNEckjuCCUtyCmNbWxy4eyc" +
                                                              "fCFqnTaXub0538Z7u5vdWftsagqoKG6lRmkwEFDxX0GlFZCoKmqrFuQKqYCg" +
                                                              "lUCoQCtCpVZq+hGVqBL8kbb0zcx+n+2ISj1p5+Zm37yvee/33txzV1GVaaBu" +
                                                              "otIYndWJGRtWaQobJskNKdg0j8BaRnqiAv/z+JWxO6OoegI1FbA5KmGTjMhE" +
                                                              "yZkTaLOsmhSrEjHHCMmxHSmDmMSYxlTW1AnUIZuJoq7IkkxHtRxhBEexkUSt" +
                                                              "mFJDzlqUJGwGFG1OgiZxrkl8IPy6P4kaJE2f9cg3+MiHfG8YZdGTZVLUkjyJ" +
                                                              "p3HcorIST8om7S8Z6BZdU2YnFY3GSInGTir7bBccSu4rc0HPpeaPr58ttHAX" +
                                                              "tGNV1Sg3zxwnpqZMk1wSNXurwwopmqfQA6giidb5iCnqTTpC4yA0DkIdaz0q" +
                                                              "0L6RqFZxSOPmUIdTtS4xhSjaFmSiYwMXbTYprjNwqKW27XwzWLvVtVZYWWbi" +
                                                              "Y7fEF5843vKjCtQ8gZplNc3UkUAJCkImwKGkmCWGOZDLkdwEalXhsNPEkLEi" +
                                                              "z9kn3WbKkyqmFhy/4xa2aOnE4DI9X8E5gm2GJVHNcM3L84Cyf1XlFTwJtnZ6" +
                                                              "tgoLR9g6GFgvg2JGHkPc2Vsqp2Q1R9GW8A7Xxt57gQC21hQJLWiuqEoVwwJq" +
                                                              "EyGiYHUynobQUyeBtEqDADQo2rgqU+ZrHUtTeJJkWESG6FLiFVDVcUewLRR1" +
                                                              "hMk4JziljaFT8p3P1bH9Z+5XD6pRFAGdc0RSmP7rYFN3aNM4yRODQB6IjQ27" +
                                                              "ko/jzpcWoggBcUeIWND85OvXDuzuXn5N0Ny8As3h7Eki0Yx0Idv01qahvjsr" +
                                                              "mBq1umbK7PADlvMsS9lv+ks6IEyny5G9jDkvl8d/9ZUHf0j+FkX1CVQtaYpV" +
                                                              "hDhqlbSiLivEuIeoxMCU5BKojqi5If4+gWpgnpRVIlYP5/MmoQlUqfClao3/" +
                                                              "BhflgQVzUT3MZTWvOXMd0wKfl3SEUA08aA88XUh8+DdF4/GCViRxLGFVVrV4" +
                                                              "ytCY/WYcECcLvi3ETUvNK9pM3DSkuGZMur8lzSAsJwEC4+MDt/E8M2IstvT/" +
                                                              "C9cSs6V9JhIBN28KJ7kC+XFQU3LEyEiL1uDwtRcyb4gAYkFvewEQBUTFbFEx" +
                                                              "JiomRMVcUSgS4RLWM5HiEOEIpiCZAU0b+tJfO3RioacCokefqQT/MdKeQFUZ" +
                                                              "8jLegemMdLGtcW7b5b2vRFFlErVhiVpYYUViwJgE+JGm7AxtyEK98WB/qw/2" +
                                                              "Wb0yNInkAHVWg3+bS602TQy2TtF6HwenKLH0i69eElbUHy2fn3no6DdujaJo" +
                                                              "EOmZyCoAKbY9xfDZxeHecIavxLf59JWPLz4+r3m5HigdTsUr28ls6AnHQNg9" +
                                                              "GWnXVvxi5qX5Xu72OsBiiiF3AOa6wzICUNLvwDKzpRYMzmtGESvslePjelow" +
                                                              "tBlvhQdnKxs6RJyyEAopyBH9i2n96fd+85fPcU864N/sq9ppQvt9gMOYtXFo" +
                                                              "afUi8ohBCNB9cD716GNXTx/j4QgU21cS2MvGIQAaOB3w4COvnXr/w8sX3ol6" +
                                                              "IUyh4lpZaFxK3Jb1n8InAs9/2MNAgi0IsGgbshFrqwtZOpO809MNwEuBVGfB" +
                                                              "0XufCmEo52WcVQjLn38179j74t/PtIjjVmDFiZbdN2bgrd80iB584/gn3ZxN" +
                                                              "RGLF0/OfRyYQud3jPGAYeJbpUXro7c1PvoqfBmwHPDXlOcIhEnF/IH6A+7gv" +
                                                              "buXj7aF3X2DDDtMf48E08jU5GensOx81Hv3o5Wtc22CX5D/3Uaz3iygSpwDC" +
                                                              "YsgeApDN3nbqbOwqgQ5dYaA6iM0CMLt9eeyrLcrydRA7AWIl6B/MwwYAZCkQ" +
                                                              "SjZ1Vc3vfvlK54m3KlB0BNUrGs6NYJ5wqA4inZgFwNaS/qUDQo+ZWhhauD9Q" +
                                                              "mYfKFtgpbFn5fIeLOuUnMvfTrh/v//7SZR6WuuBxs5/hTj72sWG3CFs23VNy" +
                                                              "ncU/1Ws4y8czwucbKNpUVg/SEgS2KAXMu5tX61N4j3Xh4cWl3OFn9opuoi1Y" +
                                                              "+4ehtX3+t/9+M3b+D6+vUIrqqKbvUcg0UQKKgchAORnlLZwHaR80nfvjz3on" +
                                                              "Bz9LJWFr3TeoFez3FjBi1+qVIazKqw//deORuwonPkNR2BJyZ5jlD0afe/2e" +
                                                              "ndK5KO9XRT0o63ODm/r9jgWhBoHGXGVmspVGnlLb3ShpZ0GxwX6ceSClBHrz" +
                                                              "kGPDsLuVB2P9GltDiBHlJxp1Qq2FZwDrumOi63ZedPpjMC2+B1IJrsiX10Ch" +
                                                              "42xIU1TFW5hgH8IiIm1lTegZ5CLUkWm7Rb4tdUJa6E39SQTsTStsEHQdz8a/" +
                                                              "c/Tdk2/yo61lseQ61BdHEHO+6tfChhhLmr41LpxBfeLzbR9Ofe/K80KfcH8f" +
                                                              "IiYLi9/+NHZmUSSTuARtL7uH+PeIi1BIu21rSeE7Rv58cf7nz86fjtqevpei" +
                                                              "mqymKQSr7klE3HxdH/Si0PXubzX/4mxbxQikaQLVWqp8yiKJXDBUa0wr63Or" +
                                                              "d2/yAtfWmhVgiiK7HGS8gw1HxHz//wjKbGFQLwEQub0vA+oNZddnceWTXlhq" +
                                                              "ru1auu9dDjzutawBwiNvKYrPLL+J1bpB8jI3pUEUN51/UYq6VmnFWTfCJ1xl" +
                                                              "U9DPQP6E6SmqZF9+sjmK1vnIKHMxn/mJ5imqACI2fUBfITvFBbAUKa9Bd4j+" +
                                                              "7gZud7f4GzKWCPz/CydSLPEPBlwNlg6N3X/t88+IhlBS8Nwcv+9CfIi20wXP" +
                                                              "batyc3hVH+y73nSpbocTuIGG1K8bP3wIX968bQx1SGav2yi9f2H/y79eqH4b" +
                                                              "Uu4YimCK2o/5/j0QnoI2y4KqdSxZngdQaHjr1t/31Oxdu/P/+D0v73bebFqd" +
                                                              "PiNNPPpe4tLUJwf4hbkKcpKUJlC9bN49q44TadoIJFUTi0bMMJX7wXZfo7vK" +
                                                              "bgYU9ZRDRfl9ClqfGWIMapaas9NynbcS+CPFqTeWroc2eCs+dJwSmSza6IpM" +
                                                              "clTXnbb6mzpPRiWMLXyRb/4un7Lh3H8BAi6LY8oUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fwHXPn2CDR8AAA==");
}
