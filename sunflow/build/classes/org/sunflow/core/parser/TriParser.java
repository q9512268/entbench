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
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwcxRWfO387dvxth5A4ieNEckjuSEtakFMa29jkwtk5" +
                                                              "+UzUOm0uc3tzvo33dje7s/bZ1BSQqphKjdJgIK2K/woqrYBEVVFbtSBXSAUE" +
                                                              "rQRCBVoRKrVS04+oRJXgj7Slb2b2+2xHVKqlm1vPvpn3Mb/3e2/u2WuoyjRQ" +
                                                              "N1FpjM7pxIwNqzSFDZPkhhRsmhMwl5GerMD/PHF17K4oqp5EGwvYHJWwSUZk" +
                                                              "ouTMSbRVVk2KVYmYY4Tk2IqUQUxizGAqa+ok6pDNRFFXZEmmo1qOMIFj2Eii" +
                                                              "FkypIWctShL2BhRtTYIlcW5JfCD8uj+JGiRNn/PEN/nEh3xvmGTR02VS1Jw8" +
                                                              "hWdw3KKyEk/KJu0vGeg2XVPmphSNxkiJxk4pB+wQHEkeKAtBz+Wmj26cKzTz" +
                                                              "ELRhVdUod88cJ6amzJBcEjV5s8MKKZqn0YOoIok2+IQp6k06SuOgNA5KHW89" +
                                                              "KbC+kahWcUjj7lBnp2pdYgZRtCO4iY4NXLS3SXGbYYdaavvOF4O3211vhZdl" +
                                                              "Lj5+W3zpyRPNP6pATZOoSVbTzBwJjKCgZBICSopZYpgDuRzJTaIWFQ47TQwZ" +
                                                              "K/K8fdKtpjylYmrB8TthYZOWTgyu04sVnCP4ZlgS1QzXvTwHlP1fVV7BU+Br" +
                                                              "p+er8HCEzYOD9TIYZuQx4M5eUjktqzmKtoVXuD723gcCsLSmSGhBc1VVqhgm" +
                                                              "UKuAiILVqXgaoKdOgWiVBgA0KNq85qYs1jqWpvEUyTBEhuRS4hVI1fFAsCUU" +
                                                              "dYTF+E5wSptDp+Q7n2tjB88+oB5WoygCNueIpDD7N8Ci7tCicZInBoE8EAsb" +
                                                              "9iSfwJ0vLkYRAuGOkLCQ+cnXrh/a273yqpC5dRWZo9lTRKIZ6WJ245tbhvru" +
                                                              "qmBm1OqaKbPDD3jOsyxlv+kv6cAwne6O7GXMebky/qsvP/RD8rcoqk+gaklT" +
                                                              "rCLgqEXSirqsEONeohIDU5JLoDqi5ob4+wSqgeekrBIxezSfNwlNoEqFT1Vr" +
                                                              "/H8IUR62YCGqh2dZzWvOs45pgT+XdIRQDXzQPvi0I/HHvykajxe0IoljCauy" +
                                                              "qsVThsb8N+PAOFmIbSFuWmpe0WbjpiHFNWPK/V/SDMJyEigwPmHIPM+MGMOW" +
                                                              "/n/ZtcR8aZuNRCDMW8JJrkB+HNaUHDEy0pI1OHz9+czrAkAM9HYUgFFAVcxW" +
                                                              "FWOqYkJVzFWFIhGuoZ2pFIcIRzANyQxs2tCX/uqRk4s9FYAefbYS4sdEewJV" +
                                                              "ZcjLeIemM9Kl1sb5HVf2vxxFlUnUiiVqYYUViQFjCuhHmrYztCEL9caj/e0+" +
                                                              "2mf1ytAkkgPWWYv+7V1qtRlisHmK2n07OEWJpV987ZKwqv1o5cLsw8e+fnsU" +
                                                              "RYNMz1RWAUmx5SnGzy4P94YzfLV9m85c/ejSEwual+uB0uFUvLKVzIeeMAbC" +
                                                              "4clIe7bjFzIvLvTysNcBF1MMuQM01x3WEaCSfoeWmS+14HBeM4pYYa+cGNfT" +
                                                              "gqHNejMcnC1s6BA4ZRAKGcgZ/Qtp/al3f/OXz/JIOuTf5KvaaUL7fYTDNmvl" +
                                                              "1NLiIXLCIATk3r+Qeuzxa2eOcziCxM7VFPaycQiIBk4HIviNV0+/98GVi29H" +
                                                              "PQhTqLhWFhqXEvel/RP4i8DnP+zDSIJNCLJoHbIZa7tLWTrTvNuzDchLgVRn" +
                                                              "4Oi9XwUYynkZZxXC8udfTbv2v/D3s83iuBWYcdCy9+YbePO3DKKHXj/xcTff" +
                                                              "JiKx4unFzxMTjNzm7TxgGHiO2VF6+K2t33kFPwXcDnxqyvOEUyTi8UD8AA/w" +
                                                              "WNzOxztC7z7Phl2mH+PBNPI1ORnp3NsfNh778KXr3Npgl+Q/91Gs9wsUiVMA" +
                                                              "ZTFkDwHKZm87dTZ2lcCGrjBRHcZmATa7Y2XsK83Kyg1QOwlqJegfzKMGEGQp" +
                                                              "ACVbuqrmd798ufPkmxUoOoLqFQ3nRjBPOFQHSCdmAbi1pH/xkLBjthaGZh4P" +
                                                              "VBahsgl2CttWP9/hok75icz/tOvHB7+/fIXDUhd73OrfcDcf+9iwV8CWPe4r" +
                                                              "ucHif9XrBMu3Z4Q/b6JoS1k9SEsAbFEKWHS3rtWn8B7r4iNLy7mjT+8X3URr" +
                                                              "sPYPQ2v73G///Ubswh9eW6UU1VFN36eQGaIEDAOVgXIyyls4j9Le33j+jz/r" +
                                                              "nRr8NJWEzXXfpFaw/7eBE3vWrgxhU1555K+bJ+4unPwURWFbKJzhLX8w+uxr" +
                                                              "9+6Wzkd5vyrqQVmfG1zU7w8sKDUINOYqc5PNNPKU2umipI2BYhN8OmyUdIRT" +
                                                              "SrA3hxwbht2lHIz16ywNMUaUn2jUgVozzwDWdcdE1+286PRjMC2+B1IJbsiX" +
                                                              "1mGhE2xIU1TFW5hgH8IQkbayJvQMchHqyIzdIn8mdVJa7E39SQD2llUWCLmO" +
                                                              "Z+LfOvbOqTf40dYyLLkB9eEIMOerfs1siLGk6Vvnwhm0J77Q+sH0964+J+wJ" +
                                                              "9/chYbK49M1PYmeXRDKJS9DOsnuIf424CIWs27GeFr5i5M+XFn7+zMKZqB3p" +
                                                              "+yiqyWqaQrDqnkTEzdf2YBSFrfc82vSLc60VI5CmCVRrqfJpiyRyQajWmFbW" +
                                                              "F1bv3uQB17aaFWCKInscZryTDRPi+eD/SMpsYlAvARG5vS8j6k1l12dx5ZOe" +
                                                              "X26q7Vq+/x1OPO61rAHgkbcUxeeW38Vq3SB5mbvSIIqbzr8oRV1rtOKsG+EP" +
                                                              "3GRTyM9C/oTlKapkX36xeYo2+MQoCzF/8gstUFQBQuzxQX2V7BQXwFKkvAbd" +
                                                              "Kfq7m4TdXeJvyFgi8N8vHKRY4hcMuBosHxl74PrnnhYNoaTg+Xl+3wV8iLbT" +
                                                              "Jc8da+7m7FV9uO/Gxst1uxzgBhpSv2388AG+vHnbHOqQzF63UXrv4sGXfr1Y" +
                                                              "/Rak3HEUwRS1Hff9eiAiBW2WBVXreLI8D6DQ8Natv++7c3fvzf/j97y823mz" +
                                                              "ZW35jDT52LuJy9MfH+IX5irISVKaRPWyec+cOk6kGSOQVBsZGjHjVB4HO3yN" +
                                                              "7iy7GVDUU04V5fcpaH1miTGoWWrOTssN3kzghxSn3li6HlrgzfjYcVpksmij" +
                                                              "KzLJUV132upFnSejEuYWPskXf5s/suH8fwGE/5mqyhQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vJ4PP7PVej79WRCxUVEnAgzddBW7oPN0DDzGVq8fxKgE6kag4utLu1aQuR9U" +
       "yoV35MLsboutba7KR2zLRTGv3tEbbhzwCqx/9xGxngfqtg/844e++uuv/xYw" +
       "URc6n+bqA5Y5tuMgyUvZX3npw4++5oVvf6BIQCD7COdf+UZRGDCvJnE+tPKh" +
       "fSDqw7mogpeEqtZTorhf5AltXkj7qp7JhaYDUmu6X6chz977Letj3/n0tgY7" +
       "7YangLXnX/jVH+1+8IWdY5Xv628pPo/jbKvfgunX7ms4hJ58tV0KDPKfPvvs" +
       "H//us+/fcnXvyTquDY4pn/7r//7q7ke//eXblBXnbO//YNj4rutUOaIbB7+e" +
       "NNHllbrmZZ3F8No8XcdGpVE2tUFbtZaJ0I4Vi+wraH1prWKrAo+yEevsJSoW" +
       "Z6mHYfOlVouQ2bRECMPAN5jlvLugGZRBVl4QToi2JJGzWCDGQmPUDod8k5A8" +
       "ngklYa8Me3x3vFjWBHuGzlAYXVMSE9hOKeVS38X6MwTTUCRB5cTbLPnhoET6" +
       "y37NX9OrQZAJZGvKWYbBR47RX9mVjhb2WwhHkaUaU/YCv9LurNIJ1ZVXwmhq" +
       "eYnYF2a8JFkoI02cyaQsWigdjIajtZl1GoECe1bVbw14khxP247jlQK2T5NL" +
       "tG2apLXxaVmNBaOHEgYfixPaVuVKV2+28GQJdzsmP3ARrj1A3LaBrVOnI/J7" +
       "qCSUuivckOcrjGE2bQthusle2tEW6FjiHN8QBmvL7K6tsk/AqyHVtjSmERMZ" +
       "LDtLtKoymZi1e7whzUfeHMfVblVxsi6htpdSJcL7DDMN3L0J69GehcL00K9a" +
       "e1UhYReDRoWhZLzOzJqwpRiyOlouazbh+qg/nyymfNxky+akPBj3BEwYd2aT" +
       "yVxR0pQlyyyGlkqpMZ3bvWUFlrHM3/DcgKv6DXHKeoI0EzNi1V0yzcWUoJuC" +
       "508n/qKV8FlXVGiZHJZr4nA1ZRAG1+dM7C839sQJCVyMjcmUlcXFJtkrR5Lb" +
       "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" +
       "P3rwD976Oy9+s2h3/S+REspnER8AAA==");
}
