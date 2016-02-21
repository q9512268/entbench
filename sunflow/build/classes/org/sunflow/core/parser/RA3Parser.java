package org.sunflow.core.parser;
public class RA3Parser implements org.sunflow.core.SceneParser {
    public boolean parse(java.lang.String filename, org.sunflow.SunflowAPI api) {
        try {
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  USER,
                "RA3 - Reading geometry: \"%s\" ...",
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
            java.nio.IntBuffer ints =
              map.
              asIntBuffer(
                );
            java.nio.FloatBuffer buffer =
              map.
              asFloatBuffer(
                );
            int numVerts =
              ints.
              get(
                0);
            int numTris =
              ints.
              get(
                1);
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  USER,
                "RA3 -   * Reading %d vertices ...",
                numVerts);
            float[] verts =
              new float[3 *
                          numVerts];
            for (int i =
                   0;
                 i <
                   verts.
                     length;
                 i++)
                verts[i] =
                  buffer.
                    get(
                      2 +
                        i);
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  USER,
                "RA3 -   * Reading %d triangles ...",
                numTris);
            int[] tris =
              new int[3 *
                        numTris];
            for (int i =
                   0;
                 i <
                   tris.
                     length;
                 i++)
                tris[i] =
                  ints.
                    get(
                      2 +
                        verts.
                          length +
                        i);
            stream.
              close(
                );
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  USER,
                "RA3 -   * Creating mesh ...");
            api.
              parameter(
                "triangles",
                tris);
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
            org.sunflow.core.Shader s =
              api.
              lookupShader(
                "ra3shader");
            if (s ==
                  null) {
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
            }
            else {
                api.
                  parameter(
                    "shaders",
                    "ra3shader");
            }
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
        return true;
    }
    public RA3Parser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wcRxmfO78dJ37FdpomTuI6Fc7jtiV9qDiUOK5dXzg7" +
                                                              "h51awgm5zO3O2evs7W52Z+2zg6Gt1MYgYUXUbVNE/VcqCmqbClGBBK2MkGir" +
                                                              "FqSWilIQLUhIhEdEA1KRCFC+mdn32Sn8wUk7tzfzzff+fvPNPXMFVdkW6iQ6" +
                                                              "TdE5k9ipAZ1msWUTpV/Dtn0M5nLy4xX4bycvj9yVRNUTaNMUtodlbJNBlWiK" +
                                                              "PYG2q7pNsS4Te4QQhe3IWsQm1gymqqFPoDbVThdNTZVVOmwohBGMYyuDmjGl" +
                                                              "lpp3KEm7DCjangFNJK6J1Bdf7s2gBtkw5wLyLSHy/tAKoywGsmyKmjLTeAZL" +
                                                              "DlU1KaPatLdkob2moc1NagZNkRJNTWu3uy44krm9zAVdzzd+cO38VBN3QSvW" +
                                                              "dYNy8+xRYhvaDFEyqDGYHdBI0T6DvoAqMmhDiJii7ownVAKhEgj1rA2oQPuN" +
                                                              "RHeK/QY3h3qcqk2ZKUTRrigTE1u46LLJcp2BQy11beebwdqdvrXCyjITH90r" +
                                                              "LT9+sunbFahxAjWq+hhTRwYlKAiZAIeSYp5Ydp+iEGUCNesQ7DFiqVhT591I" +
                                                              "t9jqpI6pA+H33MImHZNYXGbgK4gj2GY5MjUs37wCTyj3V1VBw5Nga3tgq7Bw" +
                                                              "kM2DgfUqKGYVMOSdu6XytKorFO2I7/Bt7P40EMDWmiKhU4YvqlLHMIFaRIpo" +
                                                              "WJ+UxiD19EkgrTIgAS2Ktq7LlPnaxPJpPElyLCNjdFmxBFR13BFsC0VtcTLO" +
                                                              "CaK0NRalUHyujBxcOqsP6UmUAJ0VImtM/w2wqTO2aZQUiEWgDsTGhj2Zx3D7" +
                                                              "i4tJhIC4LUYsaL77+auH9nWuviJoblyD5mh+msg0J1/Mb3pjW3/PXRVMjVrT" +
                                                              "sFUW/IjlvMqy7kpvyQSEafc5ssWUt7g6+uPP3v8t8qckqk+jatnQnCLkUbNs" +
                                                              "FE1VI9a9RCcWpkRJozqiK/18PY1q4D2j6kTMHi0UbELTqFLjU9UG/w0uKgAL" +
                                                              "5qJ6eFf1guG9m5hO8feSiRCqgQfth6cNiQ//puiENGUUiYRlrKu6IWUtg9nP" +
                                                              "AqorWKLEhncFVk1Dsh29oBmzkm3JkmFN+r9lwyKsOgEMpdG+A7zirBTLMvP/" +
                                                              "zL/E7GudTSTA9dviha9BzQwZmkKsnLzsHB64+lzuNZFUrBBczwDKgKiUKyrF" +
                                                              "RKWEqJQvCiUSXMJmJlIEFsJyGgocELahZ+xzR04tdlVARpmzleBTRtoVOWn6" +
                                                              "AxTwoDsn//XIbw8MLXziZ0mUBKDIw0kTAP7OEOCzk8oyZKIA3qwH/B74SetD" +
                                                              "/Zo6oNULsw+Mf/EWrkMYwRnDKgAftj3LcNcX0R2v3LX4Np67/MGlxxaMoIYj" +
                                                              "R4J3kpXtZNDQFY9j3PicvGcnfiH34kJ3ElUC3gDGUgw1AfDVGZcRgYheD26Z" +
                                                              "LbVgcMGwilhjSx5G1tMpy5gNZniCNbOhTeQaS4OYghypPzlmPvmLn/7hAPek" +
                                                              "B+qNodN4jNDeEJAwZi0cMpqDrDpmEQJ0v76QfeTRK+eO85QCipvWEtjNxn4A" +
                                                              "EIgOePChV8688967F99KBmlI4SR18tCQlLgtmz+ETwKef7OHFT+bECDQ0u8i" +
                                                              "0U4fikwm+eZANwAlDQqXJUf3fTokn1pQcV4jrAb+2bj71hf+vNQkwq3BjJct" +
                                                              "+z6aQTB/w2F0/2sn/97J2SRkdigG/gvIBNK2Bpz7LAvPMT1KD7y5/YmX8ZOA" +
                                                              "2YCTtjpPOPQh7g/EA3gb94XExwOxtTvY0G2HczxaRqHmJSeff+v9jePvv3SV" +
                                                              "axvtfsJxH8Zmr8giEQUQlkLuEIFittpusrGjBDp0xMFmCNtTwOy21ZETTdrq" +
                                                              "NRA7AWJl6AvsoxaAXCmSSi51Vc0vf/ij9lNvVKDkIKrXDKwMYl5wqA4yndhT" +
                                                              "gI8l81OHhB6ztTA0cX+gMg8xp+9YO5wDRZPyAMx/r+M7B7+x8i7PQpF2N7rb" +
                                                              "+Y/dfPwYG/aKJGWv+0q+a/in+jquCfFM8PctFG0rQ/AxGdJYgDfz5fb1ug3e" +
                                                              "KV18cHlFOfrUraInaIme4APQoD7783+9nrrwm1fXODzqqGHu18gM0SKKgcjI" +
                                                              "ATDMG7EAwOofvqU1Q0uFcuxnXDrXQfc966N7XMDLD/5x67G7p079D8C+I+ak" +
                                                              "OMtvDj/z6r03y19N8l5SYHpZDxrd1Bt2Fwi1CDTNOjOLzWzkZdHlx76VhXoL" +
                                                              "PO1u7NvjZSEQmCcSG/r9rTzF6q+zNVb1SR6npJdATTytWUecEh2xt9Aezqwx" +
                                                              "8d2XTXNFxq+DJCfY8BmKqngrEe0H2OVwzMnbcKqrRTgLZtz29ePZU/Jid/Z3" +
                                                              "Ig1vWGODoGt7WvrK+NvTr/PQ1rLc8R0ayps+azJ0gjWxYT8rhZ7rXAaj+kgL" +
                                                              "Le+d/vrlZ4U+8d47RkwWl7/8YWppWZSIuKDcVHZHCO8Rl5SYdruuJ4XvGPz9" +
                                                              "pYXvP71wLul6Ok1RTd4wNIJ1PxIJvwo3R70odL3nS40/ON9SMQjdQxrVOrp6" +
                                                              "xiFpJZqqNbaTD7k1uNMEietqzQ5RihJ7TBfv7mTDqHjv/e+AlU0cKgGY+B0n" +
                                                              "w9otZRdZcfmSn1tprO1Yue9t3v34F6QGSIaCo2khI8IGVZsWKahc8QZxHJn8" +
                                                              "6wxFHes0wKx/4C9cY1PQU6iWOD1FlewrTDZL0YYQGWUO5W9honmKKoCIvZ41" +
                                                              "16hFcRUrJcrPkTtFR/YRTva3hFsolvb8nwQvLxzxX0JOvrRyZOTs1TueEi2c" +
                                                              "rOH5eX7zhGwQjaIPlbvW5ebxqh7qubbp+brdXppGWsiwbjz2kKy83doa62ns" +
                                                              "br+1eefiwZd+slj9JhTYcZTAFLUeD93jhaegMXLg5DmeKc96OEZ4s9Xb87W5" +
                                                              "u/cV/vIrfkK7VbJtffqcXPePpflddiKVRHVpVAUVSEoTqF6175nTR4k8Y0VK" +
                                                              "qDpvOLr/h8MmlpuY4Sn3iuvMjf4s6+wp6iqHifLbDrQus8Q6zLi7JRk5WBzT" +
                                                              "DK9yr6qiPkWDW5HLDJum1/A+xL1umrzyltgw/R+i4n7NIhQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GNdQYsziCK9rxIgM4+akIJJqZwE3CnZSd0J+JPGiYo1tNHR9Bl1Ecj0sxaVy" +
       "uzrsjHtC0ymutF6t15nywYwUNLE25NNu365Vk7TdlYNCQqZIuVkXFyg7nFT1" +
       "GUOgbVNOfI7gqcJiMezMJkxlVtcc2yJJp9mL+TKKVrW2OJr4fdFnV1zYHiGL" +
       "ERcLJa2ddbqXNTsZxlS6SeeFPhP7ozXPcAHKRXJLL4o+063Ic2yjdZKhIfRY" +
       "cxnPKvIy9TTMi5ZLF1760tx1O7NAT5bGprgi17WS5AjVoh0sfRiVZUVPeAkO" +
       "TKPe17iFyHN4m5rIRL1kaIKsDuaUWiEsmQTuzbT4clCfL2ug4I0QcYrEPV9Z" +
       "kdh02Q8VxRPnrMy6iilJOjkddafuFJ9Mxy0HPH+rKFaxuVF5VVsUpqRHuDFD" +
       "+YhWG1imGy3KY7ukR/HAUMpBFU7cqu51dYVaEv4wCmrD6obSsf5oVZk1NhxB" +
       "1td+1dPZ1YyYVboU0Y8sFMHhlEIjy9+szVBNkBGsl22M7mlDUNy/5z1Z2f/k" +
       "T/bmdVf+knnQ8gcvXNlG5yd449huPZYNbz1orOW/s2/QWDvSfDi1/0L74A0t" +
       "1LEo2/K2e5q9aj10q3Z//pr1qadfeEliPo3u7HV2ZiF0IXTcd5lyLJvHzvOh" +
       "d9z6lXKQf+047Dh8+el/fYB7r/aBn6Cn+sgJPk+S/N3By1/tvE389R3o9EH/" +
       "4YbvMMeRrh3vOlz05TDybe5Y7+GhA/Xfk2n7fnBd2VP/lZv3NW/qKqdyV9k6" +
       "yInG2U4OsJO7yL7Vrhy12nj7j7O9HD98g8ZbPjghdCbvk+cgoyO+Ng2hc0vH" +
       "MWXBPvRD98e9+R5rcAH7HzTfs+7h/Td809t+hxI/99Kl8/e9NPmbvP988K3o" +
       "AgWdVyLTPNrsOTI/6/ogpeRSXNi2ftz87+kQuu8W3wKy5mw+yXn98Bb+IyF0" +
       "+SQ8eO/P/o6CPRtCtx8BA9rZmx0Fei6ETgOgbPqr7k36RNumV3rqSDTsxW+u" +
       "3rt/nHoPUI72p7MIyj+q7nt7tP2sel38/Et9+oOvVT+97Y+LprDZZFTOU9C5" +
       "bav+IGIeuyW1fVpnu0+8fucXLrx1P7rv3DJ86MdHeHvk5g3oluWGect484f3" +
       "/f67f/ulb+Vtq/8F3mvhre0eAAA=");
}
