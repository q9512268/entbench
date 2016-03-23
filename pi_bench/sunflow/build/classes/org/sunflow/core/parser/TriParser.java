package org.sunflow.core.parser;
public class TriParser implements org.sunflow.core.SceneParser {
    public boolean parse(java.lang.String filename, org.sunflow.SunflowAPI api) {
        try {
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  USER,
                "TRI - Reading geometry: \"%s\" ...",
                filename);
            org.sunflow.system.Parser p =
              new org.sunflow.system.Parser(
              filename);
            float[] verts =
              new float[3 *
                          p.
                          getNextInt(
                            )];
            for (int v =
                   0;
                 v <
                   verts.
                     length;
                 v +=
                   3) {
                verts[v +
                        0] =
                  p.
                    getNextFloat(
                      );
                verts[v +
                        1] =
                  p.
                    getNextFloat(
                      );
                verts[v +
                        2] =
                  p.
                    getNextFloat(
                      );
                p.
                  getNextToken(
                    );
                p.
                  getNextToken(
                    );
            }
            int[] triangles =
              new int[p.
                        getNextInt(
                          ) *
                        3];
            for (int t =
                   0;
                 t <
                   triangles.
                     length;
                 t +=
                   3) {
                triangles[t +
                            0] =
                  p.
                    getNextInt(
                      );
                triangles[t +
                            1] =
                  p.
                    getNextInt(
                      );
                triangles[t +
                            2] =
                  p.
                    getNextInt(
                      );
            }
            api.
              parameter(
                "triangles",
                triangles);
            api.
              parameter(
                "points",
                "point",
                "vertex",
                verts);
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
            p.
              close(
                );
            java.io.RandomAccessFile stream =
              new java.io.RandomAccessFile(
              filename.
                replace(
                  ".tri",
                  ".ra3"),
              "rw");
            java.nio.MappedByteBuffer map =
              stream.
              getChannel(
                ).
              map(
                java.nio.channels.FileChannel.MapMode.
                  READ_WRITE,
                0,
                8 +
                  4 *
                  (verts.
                     length +
                     triangles.
                       length));
            map.
              order(
                java.nio.ByteOrder.
                  LITTLE_ENDIAN);
            java.nio.IntBuffer ints =
              map.
              asIntBuffer(
                );
            java.nio.FloatBuffer floats =
              map.
              asFloatBuffer(
                );
            ints.
              put(
                0,
                verts.
                  length /
                  3);
            ints.
              put(
                1,
                triangles.
                  length /
                  3);
            for (int i =
                   0;
                 i <
                   verts.
                     length;
                 i++)
                floats.
                  put(
                    2 +
                      i,
                    verts[i]);
            for (int i =
                   0;
                 i <
                   triangles.
                     length;
                 i++)
                ints.
                  put(
                    2 +
                      verts.
                        length +
                      i,
                    triangles[i]);
            stream.
              close(
                );
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
        return true;
    }
    public TriParser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1Ye2wcxRmfO78dv58hJE7iOJEckjvSkhbklMY2Nrlwdk45" +
                                                              "E7VOm8vc3pxv473dze6sfTY1BaQqbqVGaTCQPvBfQaUVkKgqaqsW5AqpgKCV" +
                                                              "QKhAK0KlVmr6iEpUCf5IW/rNzL7PdkRVSze3nv1mvsf8vt/3zT1zDVWZBuoh" +
                                                              "Ko3ROZ2YsRGVprBhktywgk1zAuYy0hMV+J8nro7fFUXVk6ipgM0xCZtkVCZK" +
                                                              "zpxEW2TVpFiViDlOSI6tSBnEJMYMprKmTqJO2UwUdUWWZDqm5QgTOIaNJGrF" +
                                                              "lBpy1qIkYW9A0ZYkWBLnlsQHw68HkqhB0vQ5T3yjT3zY94ZJFj1dJkUtyVN4" +
                                                              "BsctKivxpGzSgZKBbtM1ZW5K0WiMlGjslLLfDsHh5P6yEPRebv7wxrlCCw9B" +
                                                              "O1ZVjXL3zKPE1JQZkkuiZm92RCFF8zR6EFUk0QafMEV9SUdpHJTGQanjrScF" +
                                                              "1jcS1SoOa9wd6uxUrUvMIIq2BzfRsYGL9jYpbjPsUEtt3/li8Hab663wsszF" +
                                                              "x26LLz1xouVHFah5EjXLapqZI4ERFJRMQkBJMUsMczCXI7lJ1KrCYaeJIWNF" +
                                                              "nrdPus2Up1RMLTh+Jyxs0tKJwXV6sYJzBN8MS6Ka4bqX54Cy/6vKK3gKfO3y" +
                                                              "fBUejrJ5cLBeBsOMPAbc2Usqp2U1R9HW8ArXx777QACW1hQJLWiuqkoVwwRq" +
                                                              "ExBRsDoVTwP01CkQrdIAgAZFm9bclMVax9I0niIZhsiQXEq8Aqk6Hgi2hKLO" +
                                                              "sBjfCU5pU+iUfOdzbfzA2QfUQ2oURcDmHJEUZv8GWNQTWnSU5IlBIA/Ewobd" +
                                                              "ycdx1wuLUYRAuDMkLGR+8pXrB/f0rLwiZG5dReZI9hSRaEa6mG16Y/Nw/10V" +
                                                              "zIxaXTNldvgBz3mWpew3AyUdGKbL3ZG9jDkvV47+6osP/ZD8LYrqE6ha0hSr" +
                                                              "CDhqlbSiLivEuJeoxMCU5BKojqi5Yf4+gWrgOSmrRMweyedNQhOoUuFT1Rr/" +
                                                              "H0KUhy1YiOrhWVbzmvOsY1rgzyUdIVQDH7QXPh1I/PFvisbiBa1I4rocTxka" +
                                                              "c92MA9lkIayFuGmpeUWbjZuGFNeMKfd/STMIS0dgv/iEIfMUM2IMVvr/e8MS" +
                                                              "86B9NhKB4G4Op7YCWXFIU3LEyEhL1tDI9ecyrwnYMKjbvgOPgKqYrSrGVMWE" +
                                                              "qpirCkUiXEMHUymODgI/DSkMHNrQn/7y4ZOLvRWAGX22EqLGRHsDtWTYy3OH" +
                                                              "nDPSpbbG+e1X9r0URZVJ1IYlamGFlYZBYwpIR5q287IhC1XGI/ttPrJnVcrQ" +
                                                              "JJIDrlmL9O1darUZYrB5ijp8OziliCVdfO1CsKr9aOXC7MPHvnp7FEWD/M5U" +
                                                              "VgE1seUpxsou+/aF83q1fZvPXP3w0uMLmpfhgYLh1LmylcyH3jAGwuHJSLu3" +
                                                              "4eczLyz08bDXAQNTDBkD5NYT1hEgkAGHjJkvteBwXjOKWGGvnBjX04KhzXoz" +
                                                              "HJytbOgUOGUQChnIefxzaf3Jd37zl0/zSDqU3+yr1WlCB3w0wzZr44TS6iFy" +
                                                              "wiAE5N67kHr0sWtnjnM4gsSO1RT2sXEY6AVOByL4tVdOv/v+lYtvRT0IU6iz" +
                                                              "VhbalRL3peNj+IvA5z/sw6iBTQiKaBu2eWqbS1Q607zLsw0oS4FUZ+Dou18F" +
                                                              "GMp5GWcVwvLnX8079z3/97Mt4rgVmHHQsufmG3jztwyhh1478VEP3yYisZLp" +
                                                              "xc8TEzzc7u08aBh4jtlRevjNLd9+GT8JjA4sasrzhBMj4vFA/AD381jczsc7" +
                                                              "Qu8+y4adph/jwTTytTYZ6dxbHzQe++DF69zaYG/kP/cxrA8IFIlTAGUxZA8B" +
                                                              "omZvu3Q2dpfAhu4wUR3CZgE2u2Nl/EstysoNUDsJaiXoGswjBhBkKQAlW7qq" +
                                                              "5ne/fKnr5BsVKDqK6hUN50YxTzhUB0gnZgG4taR//qCwY7YWhhYeD1QWobIJ" +
                                                              "dgpbVz/fkaJO+YnM/7T7xwe+v3yFw1IXe9zq33AXH/vZsEfAlj3uLbnB4n/V" +
                                                              "6wTLt2eEP2+kaHNZPUhLAGxRClh0t6zVnfDO6uIjS8u5I0/tEz1EW7Dij0BD" +
                                                              "++xv//167MIfXl2lFNVRTd+rkBmiBAwDlYFyMsYbN4/S3ms6/8ef9U0NfZJK" +
                                                              "wuZ6blIr2P9bwYnda1eGsCkvP/LXTRN3F05+gqKwNRTO8JY/GHvm1Xt3Seej" +
                                                              "vEsV9aCsuw0uGvAHFpQaBNpxlbnJZhp5Su1wUdLOQLERPp02SjrDKSXYm0OO" +
                                                              "DSPuUg7G+nWWhhgjyk806kCthWcA67Vjotd2XnT5MZgW34OpBDfkC+uw0Ak2" +
                                                              "pCmq4i1MsA9hiEhbWRN6BrkIdWTGbow/lTopLfal/iQAe8sqC4Rc59Pxbx57" +
                                                              "+9Tr/GhrGZbcgPpwBJjzVb8WNsRY0vSvc80M2hNfaHt/+ntXnxX2hLv6kDBZ" +
                                                              "XPrGx7GzSyKZxNVnR9ntw79GXH9C1m1fTwtfMfrnSws/f3rhTNSO9H0U1WQ1" +
                                                              "TSFYdU8i4uZrRzCKwtZ7vt78i3NtFaOQpglUa6nyaYskckGo1phW1hdW77bk" +
                                                              "Ade2mhVgiiK7HWa8kw0T4vnA/0jKbGJILwERub0vI+qNZZdmcdGTnlturu1e" +
                                                              "vv9tTjzuZawB4JG3FMXnlt/Fat0geZm70iCKm86/KEXda7TirBvhD9xkU8jP" +
                                                              "Qv6E5SmqZF9+sXmKNvjEKAsxf/ILLVBUAULs8UF9lewU175SpLwG3Sn6u5uE" +
                                                              "3V3ib8hYIvBfLRykWOJ3C7gaLB8ef+D6Z54SDaGk4Pl5fssFfIi20yXP7Wvu" +
                                                              "5uxVfaj/RtPlup0OcAMNqd82fvgAX968bQp1SGaf2yi9e/HAi79erH4TUu44" +
                                                              "imCK2o/7fjMQkYI2y4KqdTxZngdQaHjrNtD/nbm79+T/8Xte3u282by2fEaa" +
                                                              "fPSdxOXpjw7ya3IV5CQpTaJ62bxnTj1KpBkjkFRNDI2YcSqPgx2+RneW3Qwo" +
                                                              "6i2nivL7FLQ+s8QY0iw1Z6flBm8m8POJU28sXQ8t8GZ87DgtMlm00RWZ5Jiu" +
                                                              "O231d3WejEqYW/gkX/wt/siG8/8FjLg7VcAUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ylz/C8yLS4z/HgAA");
}
