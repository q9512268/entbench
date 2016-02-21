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
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wcRxmfO78dJ37FdpomTuI6Fc7jtiV9qDiUOK5dXzg7" +
                                                              "h51awgm5zO3O2evs7W52Z+2zg6GtBDFIWBG4bUDUf6WioLapEBVI0MoIibZq" +
                                                              "QWqpKAXRgoREeEQ0IBWJAOWbmX2f7cIfnLRzezPffO/vN9/cU9dQlW2hTqLT" +
                                                              "FJ0ziZ0a0GkWWzZR+jVs2ydgLic/VoH/dvrqyD1JVD2Btkxhe1jGNhlUiabY" +
                                                              "E2inqtsU6zKxRwhR2I6sRWxizWCqGvoEalPtdNHUVFmlw4ZCGME4tjKoGVNq" +
                                                              "qXmHkrTLgKKdGdBE4ppIffHl3gxqkA1zLiDfFiLvD60wymIgy6aoKTONZ7Dk" +
                                                              "UFWTMqpNe0sW2m8a2tykZtAUKdHUtHan64JjmTvLXND1bON7Ny5ONXEXtGJd" +
                                                              "Nyg3zx4ltqHNECWDGoPZAY0U7XPoM6gigzaFiCnqznhCJRAqgVDP2oAKtN9M" +
                                                              "dKfYb3BzqMep2pSZQhTtiTIxsYWLLpss1xk41FLXdr4ZrN3tWyusLDPxkf3S" +
                                                              "8mOnm75dgRonUKOqjzF1ZFCCgpAJcCgp5oll9ykKUSZQsw7BHiOWijV13o10" +
                                                              "i61O6pg6EH7PLWzSMYnFZQa+gjiCbZYjU8PyzSvwhHJ/VRU0PAm2tge2CgsH" +
                                                              "2TwYWK+CYlYBQ965WyrPqrpC0a74Dt/G7o8DAWytKRI6ZfiiKnUME6hFpIiG" +
                                                              "9UlpDFJPnwTSKgMS0KJo+7pMma9NLJ/FkyTHMjJGlxVLQFXHHcG2UNQWJ+Oc" +
                                                              "IErbY1EKxefayOGl8/qQnkQJ0Fkhssb03wSbOmObRkmBWATqQGxs2Jd5FLc/" +
                                                              "v5hECIjbYsSC5rufvn7kQOfqS4Lm5jVojueniUxz8uX8ltd29PfcU8HUqDUN" +
                                                              "W2XBj1jOqyzrrvSWTECYdp8jW0x5i6ujP/7kg98if0qi+jSqlg3NKUIeNctG" +
                                                              "0VQ1Yt1PdGJhSpQ0qiO60s/X06gG3jOqTsTs8ULBJjSNKjU+VW3w3+CiArBg" +
                                                              "LqqHd1UvGN67iekUfy+ZCKEaeNBBeLYi8eHfFJ2SpowikbCMdVU3pKxlMPtZ" +
                                                              "QHUFS5TY8K7AqmlItqMXNGNWsi1ZMqxJ/7dsWIRVJ4ChdMJSecVZKZZl5v+Z" +
                                                              "f4nZ1zqbSIDrd8QLX4OaGTI0hVg5edk5OnD9mdwrIqlYIbieAZQBUSlXVIqJ" +
                                                              "SglRKV8USiS4hK1MpAgshOUsFDggbEPP2KeOnVnsqoCMMmcrwaeMtCty0vQH" +
                                                              "KOBBd07+67HfHhpa+MjPkigJQJGHkyYA/N0hwGcnlWXIRAG8WQ/4PfCT1of6" +
                                                              "NXVAq5dmHxr/7G1chzCCM4ZVAD5se5bhri+iO165a/FtvHD1vSuPLhhBDUeO" +
                                                              "BO8kK9vJoKErHse48Tl53278XO75he4kqgS8AYylGGoC4KszLiMCEb0e3DJb" +
                                                              "asHggmEVscaWPIysp1OWMRvM8ARrZkObyDWWBjEFOVJ/dMx8/Bc//cMh7kkP" +
                                                              "1BtDp/EYob0hIGHMWjhkNAdZdcIiBOh+fSn7lUeuXTjJUwoobllLYDcb+wFA" +
                                                              "IDrgwc+9dO6td96+/EYySEMKJ6mTh4akxG3Z+j58EvD8mz2s+NmEAIGWfheJ" +
                                                              "dvtQZDLJtwa6AShpULgsObof0CH51IKK8xphNfDPxr23P/fnpSYRbg1mvGw5" +
                                                              "8MEMgvmbjqIHXzn9907OJiGzQzHwX0AmkLY14NxnWXiO6VF66PWdX30RPw6Y" +
                                                              "DThpq/OEQx/i/kA8gHdwX0h8PBRbu4sN3XY4x6NlFGpecvLFN97dPP7uC9e5" +
                                                              "ttHuJxz3YWz2iiwSUQBhKeQOEShmq+0mGztKoENHHGyGsD0FzO5YHTnVpK3e" +
                                                              "ALETIFaGvsA+bgHIlSKp5FJX1fzyhz9qP/NaBUoOonrNwMog5gWH6iDTiT0F" +
                                                              "+FgyP3ZE6DFbC0MT9wcq8xBz+q61wzlQNCkPwPz3Or5z+Bsrb/MsFGl3s7ud" +
                                                              "/9jLxw+xYb9IUvZ6oOS7hn+qN3BNiGeCv2+jaEcZgo/JkMYCvJkvd67XbfBO" +
                                                              "6fLDyyvK8SduFz1BS/QEH4AG9emf/+vV1KXfvLzG4VFHDfOgRmaIFlEMREYO" +
                                                              "gGHeiAUAVv/521oztFQox37GpXMddN+3PrrHBbz48B+3n7h36sz/AOy7Yk6K" +
                                                              "s/zm8FMv33+r/OUk7yUFppf1oNFNvWF3gVCLQNOsM7PYzGZeFl1+7FtZqLfB" +
                                                              "0+bGvi1eFgKBeSKxod/fylOsfoOtsapP8jglvQRq4mnNOuKU6Ii9hfZwZo2J" +
                                                              "775smisyvgGSnGLDJyiq4q1EtB9gl8MxJ2/Dqa4W4SyYcdvXD2fPyIvd2d+J" +
                                                              "NLxpjQ2Cru1J6Uvjb06/ykNby3LHd2gob/qsydAJ1sSGg6wUeja4DEb1kRZa" +
                                                              "3jn79atPC33ivXeMmCwuf/H91NKyKBFxQbml7I4Q3iMuKTHt9mwkhe8Y/P2V" +
                                                              "he8/uXAh6Xo6TVFN3jA0gnU/Egm/CrdGvSh0ve8LjT+42FIxCN1DGtU6unrO" +
                                                              "IWklmqo1tpMPuTW40wSJ62rNDlGKEvtMF+/uZsOoeO/974CVTRwpAZj4HSfD" +
                                                              "2m1lF1lx+ZKfWWms7Vh54E3e/fgXpAZIhoKjaSEjwgZVmxYpqFzxBnEcmfzr" +
                                                              "HEUd6zTArH/gL1xjU9BTqJY4PUWV7CtMNkvRphAZZQ7lb2GieYoqgIi9njfX" +
                                                              "qEVxFSslys+Ru0VH9gFO9reEWyiW9vyfBC8vHPFfQk6+snJs5Pz1u54QLZys" +
                                                              "4fl5fvOEbBCNog+Ve9bl5vGqHuq5seXZur1emkZayLBuPPaQrLzd2h7raexu" +
                                                              "v7V56/LhF36yWP06FNhJlMAUtZ4M3eOFp6AxcuDkOZkpz3o4Rniz1dvztbl7" +
                                                              "DxT+8it+QrtVsmN9+pxc94+l+T12IpVEdWlUBRVIShOoXrXvm9NHiTxjRUqo" +
                                                              "Om84uv+HwxaWm5jhKfeK68zN/izr7CnqKoeJ8tsOtC6zxDrKuLslGTlYHNMM" +
                                                              "r3KvqqI+RYNbkcsMm6bX8C5yr5smr7wlNkz/B9I44s4iFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "euG7ecvqfwE1N5Kr6R4AAA==");
}
