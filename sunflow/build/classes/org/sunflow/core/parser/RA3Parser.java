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
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwcxRWfO387/nZsh5A4ieNEckjuSCEtyCmNbWxy4eyc" +
                                                              "fCFqnTaXub0538Z7u5vdWftsagpIKKZSozQYSBH4r6DSCkhUFbVVC3KFVEDQ" +
                                                              "SiBUoBWhUis1/YhKVAn+SFv6Zma/z3ZEpVq6ufXsm3kf83u/9+aev4qqTAN1" +
                                                              "E5XG6KxOzNiwSlPYMEluSMGmeQTmMtKTFfifx6+M3RlF1ROoqYDNUQmbZEQm" +
                                                              "Ss6cQJtl1aRYlYg5RkiOrUgZxCTGNKaypk6gDtlMFHVFlmQ6quUIEziKjSRq" +
                                                              "xZQactaiJGFvQNHmJFgS55bEB8Kv+5OoQdL0WU98g098yPeGSRY9XSZFLcmT" +
                                                              "eBrHLSor8aRs0v6SgW7RNWV2UtFojJRo7KSyzw7BoeS+shD0XGr+5PrZQgsP" +
                                                              "QTtWVY1y98xxYmrKNMklUbM3O6yQonkKPYAqkmidT5ii3qSjNA5K46DU8daT" +
                                                              "AusbiWoVhzTuDnV2qtYlZhBF24Kb6NjARXubFLcZdqiltu98MXi71fVWeFnm" +
                                                              "4uO3xBefPN7yowrUPIGaZTXNzJHACApKJiCgpJglhjmQy5HcBGpV4bDTxJCx" +
                                                              "Is/ZJ91mypMqphYcvxMWNmnpxOA6vVjBOYJvhiVRzXDdy3NA2f9V5RU8Cb52" +
                                                              "er4KD0fYPDhYL4NhRh4D7uwllVOymqNoS3iF62PvvSAAS2uKhBY0V1WlimEC" +
                                                              "tQmIKFidjKcBeuokiFZpAECDoo2rbspirWNpCk+SDENkSC4lXoFUHQ8EW0JR" +
                                                              "R1iM7wSntDF0Sr7zuTq2/8z96kE1iiJgc45ICrN/HSzqDi0aJ3liEMgDsbBh" +
                                                              "V/IJ3PnyQhQhEO4ICQuZn3zz2oHd3cuvC5mbV5A5nD1JJJqRLmSb3t401Hdn" +
                                                              "BTOjVtdMmR1+wHOeZSn7TX9JB4bpdHdkL2POy+XxX33twR+Sv0VRfQJVS5pi" +
                                                              "FQFHrZJW1GWFGPcQlRiYklwC1RE1N8TfJ1ANPCdllYjZw/m8SWgCVSp8qlrj" +
                                                              "/0OI8rAFC1E9PMtqXnOedUwL/LmkI4Rq4IP2wKcDiT/+TdF4vKAVSRxLWJVV" +
                                                              "LZ4yNOa/GQfGyUJsC3HTUvOKNhM3DSmuGZPu/5JmEJaTQIHx8YHbeJ4ZMYYt" +
                                                              "/f+ya4n50j4TiUCYN4WTXIH8OKgpOWJkpEVrcPjai5k3BYAY6O0oAKOAqpit" +
                                                              "KsZUxYSqmKsKRSJcw3qmUhwiHMEUJDOwaUNf+huHTiz0VAB69JlKiB8T7QlU" +
                                                              "lSEv4x2azkgX2xrntl3e+2oUVSZRG5aohRVWJAaMSaAfacrO0IYs1BuP9rf6" +
                                                              "aJ/VK0OTSA5YZzX6t3ep1aaJweYpWu/bwSlKLP3iq5eEFe1Hy+dnHjr6rVuj" +
                                                              "KBpkeqayCkiKLU8xfnZ5uDec4Svt23z6yicXn5jXvFwPlA6n4pWtZD70hDEQ" +
                                                              "Dk9G2rUVv5R5eb6Xh70OuJhiyB2gue6wjgCV9Du0zHypBYfzmlHECnvlxLie" +
                                                              "Fgxtxpvh4GxlQ4fAKYNQyEDO6F9O68+8/5u/3MYj6ZB/s69qpwnt9xEO26yN" +
                                                              "U0urh8gjBiEg9+H51GOPXz19jMMRJLavpLCXjUNANHA6EMFHXj/1wUeXL7wb" +
                                                              "9SBMoeJaWWhcStyX9Z/BXwQ+/2EfRhJsQpBF25DNWFtdytKZ5p2ebUBeCqQ6" +
                                                              "A0fvfSrAUM7LOKsQlj//at6x96W/n2kRx63AjIOW3TfewJu/aRA9+ObxT7v5" +
                                                              "NhGJFU8vfp6YYOR2b+cBw8CzzI7SQ+9s/t5r+BngduBTU54jnCIRjwfiB7iP" +
                                                              "x+JWPt4eevclNuww/RgPppGvyclIZ9/9uPHox69c49YGuyT/uY9ivV+gSJwC" +
                                                              "KIshewhQNnvbqbOxqwQ2dIWJ6iA2C7DZ7ctjX29Rlq+D2glQK0H/YB42gCBL" +
                                                              "ASjZ0lU1v/vlq50n3q5A0RFUr2g4N4J5wqE6QDoxC8CtJf0rB4QdM7UwtPB4" +
                                                              "oLIIlU2wU9iy8vkOF3XKT2Tup10/3v/9pcsclrrY42b/hjv52MeG3QK27HFP" +
                                                              "yQ0W/6teI1i+PSP8eQNFm8rqQVoCYItSwKK7ebU+hfdYFx5eXModfnav6Cba" +
                                                              "grV/GFrbF37777di5//wxgqlqI5q+h6FTBMlYBioDJSTUd7CeZT2YdO5P/6s" +
                                                              "d3Lw81QSNtd9g1rB/t8CTuxavTKETXnt4b9uPHJX4cTnKApbQuEMb/mD0eff" +
                                                              "uGendC7K+1VRD8r63OCifn9gQalBoDFXmZtsppGn1HYXJe0MFBvg02mjpDOc" +
                                                              "UoK9OeTYMOwu5WCsX2NpiDGi/ESjDtRaeAawrjsmum7nRacfg2nxPZBKcEO+" +
                                                              "ugYLHWdDmqIq3sIE+xCGiLSVNaFnkItQR6btFvkLqRPSQm/qTwKwN62wQMh1" +
                                                              "PBf/ztH3Tr7Fj7aWYckNqA9HgDlf9WthQ4wlTd8aF86gPfH5to+mnr7ygrAn" +
                                                              "3N+HhMnC4rc/i51ZFMkkLkHby+4h/jXiIhSybttaWviKkT9fnP/5c/Ono3ak" +
                                                              "76WoJqtpCsGqexIRN1/XB6MobL370eZfnG2rGIE0TaBaS5VPWSSRC0K1xrSy" +
                                                              "vrB69yYPuLbVrABTFNnlMOMdbDginvf/j6TMJgb1EhCR2/syot5Qdn0WVz7p" +
                                                              "xaXm2q6l+97jxONeyxoAHnlLUXxu+V2s1g2Sl7krDaK46fyLUtS1SivOuhH+" +
                                                              "wE02hfwM5E9YnqJK9uUXm6NonU+MshDzJ7/QPEUVIMQeH9BXyE5xASxFymvQ" +
                                                              "HaK/u0HY3SX+howlAv/9wkGKJX7BgKvB0qGx+6998VnREEoKnpvj913Ah2g7" +
                                                              "XfLctupuzl7VB/uuN12q2+EAN9CQ+m3jhw/w5c3bxlCHZPa6jdIHF/a/8uuF" +
                                                              "6ncg5Y6hCKao/Zjv1wMRKWizLKhax5LleQCFhrdu/X1Pzd61O/+P3/PybufN" +
                                                              "ptXlM9LEY+8nLk19eoBfmKsgJ0lpAtXL5t2z6jiRpo1AUjUxNGLGqTwOdvga" +
                                                              "3Vl2M6Cop5wqyu9T0PrMEGNQs9ScnZbrvJnADylOvbF0PbTAm/Gx45TIZNFG" +
                                                              "V2SSo7rutNWP6DwZlTC38Em++Lv8kQ3n/gs/A2RlyhQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eNfvvPStvN31v5Zqh6sRHwAA");
}
