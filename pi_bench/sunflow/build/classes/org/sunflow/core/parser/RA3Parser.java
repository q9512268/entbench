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
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1YfWwcxRWfO387/nZsh5A4ieNEckjuSCEtyCmNbWxy4eyc" +
                                                              "fCFqnTaXub0538Z7u5vdWftsagpIVUylRmkwkCLwX0HQCkhUFbVVC3KFVEDQ" +
                                                              "SiBUoBWhUis1/YhKVAn+SFv6Zma/z3ZEVUs3t559M+9jfu/33tzzV1GVaaBu" +
                                                              "otIYndWJGRtWaQobJskNKdg0j8BcRnqiAv/z+JWxO6OoegI1FbA5KmGTjMhE" +
                                                              "yZkTaLOsmhSrEjHHCMmxFSmDmMSYxlTW1AnUIZuJoq7IkkxHtRxhAkexkUSt" +
                                                              "mFJDzlqUJOwNKNqcBEvi3JL4QPh1fxI1SJo+64lv8IkP+d4wyaKny6SoJXkS" +
                                                              "T+O4RWUlnpRN2l8y0C26psxOKhqNkRKNnVT22SE4lNxXFoKeS82fXD9baOEh" +
                                                              "aMeqqlHunjlOTE2ZJrkkavZmhxVSNE+hB1BFEq3zCVPUm3SUxkFpHJQ63npS" +
                                                              "YH0jUa3ikMbdoc5O1brEDKJoW3ATHRu4aG+T4jbDDrXU9p0vBm+3ut4KL8tc" +
                                                              "fOyW+OITx1t+VIGaJ1CzrKaZORIYQUHJBASUFLPEMAdyOZKbQK0qHHaaGDJW" +
                                                              "5Dn7pNtMeVLF1ILjd8LCJi2dGFynFys4R/DNsCSqGa57eQ4o+7+qvIInwddO" +
                                                              "z1fh4QibBwfrZTDMyGPAnb2kckpWcxRtCa9wfey9FwRgaU2R0ILmqqpUMUyg" +
                                                              "NgERBauT8TRAT50E0SoNAGhQtHHVTVmsdSxN4UmSYYgMyaXEK5Cq44FgSyjq" +
                                                              "CIvxneCUNoZOyXc+V8f2n7lfPahGUQRszhFJYfavg0XdoUXjJE8MAnkgFjbs" +
                                                              "Sj6OO19eiCIEwh0hYSHzk29eO7C7e/l1IXPzCjKHsyeJRDPShWzT25uG+u6s" +
                                                              "YGbU6pops8MPeM6zLGW/6S/pwDCd7o7sZcx5uTz+q689+EPytyiqT6BqSVOs" +
                                                              "IuCoVdKKuqwQ4x6iEgNTkkugOqLmhvj7BKqB56SsEjF7OJ83CU2gSoVPVWv8" +
                                                              "fwhRHrZgIaqHZ1nNa86zjmmBP5d0hFANfNAe+HQg8ce/KRqNF7QiietyPGVo" +
                                                              "zHUzDmSThbAW4qal5hVtJm4aUlwzJt3/Jc0gLB2B/eLjA7fxFDNiDFb6/3vD" +
                                                              "EvOgfSYSgeBuCqe2AllxUFNyxMhIi9bg8LUXM28K2DCo274Dj4CqmK0qxlTF" +
                                                              "hKqYqwpFIlzDeqZSHB0EfgpSGDi0oS/9jUMnFnoqADP6TCVEjYn2BGrJkJfn" +
                                                              "DjlnpIttjXPbLu99NYoqk6gNS9TCCisNA8YkkI40ZedlQxaqjEf2W31kz6qU" +
                                                              "oUkkB1yzGunbu9Rq08Rg8xSt9+3glCKWdPHVC8GK9qPl8zMPHf3WrVEUDfI7" +
                                                              "U1kF1MSWpxgru+zbG87rlfZtPn3lk4uPz2tehgcKhlPnylYyH3rCGAiHJyPt" +
                                                              "2opfyrw838vDXgcMTDFkDJBbd1hHgED6HTJmvtSCw3nNKGKFvXJiXE8Lhjbj" +
                                                              "zXBwtrKhQ+CUQShkIOfxL6f1p9//zV9u45F0KL/ZV6vThPb7aIZt1sYJpdVD" +
                                                              "5BGDEJD78Hzq0ceunj7G4QgS21dS2MvGIaAXOB2I4LdfP/XBR5cvvBv1IEyh" +
                                                              "zlpZaFdK3Jf1n8FfBD7/YR9GDWxCUETbkM1TW12i0pnmnZ5tQFkKpDoDR+99" +
                                                              "KsBQzss4qxCWP/9q3rH3pb+faRHHrcCMg5bdN97Am79pED345vFPu/k2EYmV" +
                                                              "TC9+npjg4XZv5wHDwLPMjtJD72z+/mv4aWB0YFFTniOcGBGPB+IHuI/H4lY+" +
                                                              "3h569yU27DD9GA+mka+1yUhn3/248ejHr1zj1gZ7I/+5j2K9X6BInAIoiyF7" +
                                                              "CBA1e9ups7GrBDZ0hYnqIDYLsNnty2Nfb1GWr4PaCVArQddgHjaAIEsBKNnS" +
                                                              "VTW/++WrnSferkDREVSvaDg3gnnCoTpAOjELwK0l/SsHhB0ztTC08HigsgiV" +
                                                              "TbBT2LLy+Q4XdcpPZO6nXT/e/+zSZQ5LXexxs3/DnXzsY8NuAVv2uKfkBov/" +
                                                              "Va8RLN+eEf68gaJNZfUgLQGwRSlg0d28WnfCO6sLDy8u5Q4/s1f0EG3Bij8M" +
                                                              "De0Lv/33W7Hzf3hjhVJURzV9j0KmiRIwDFQGyskob9w8Svuw6dwff9Y7Ofh5" +
                                                              "Kgmb675BrWD/bwEndq1eGcKmvPbwXzceuatw4nMUhS2hcIa3/MHo82/cs1M6" +
                                                              "F+VdqqgHZd1tcFG/P7Cg1CDQjqvMTTbTyFNqu4uSdgaKDfDptFHSGU4pwd4c" +
                                                              "cmwYdpdyMNavsTTEGFF+olEHai08A1ivHRO9tvOi04/BtPgeSCW4IV9dg4WO" +
                                                              "syFNURVvYYJ9CENE2sqa0DPIRagj03Zj/IXUCWmhN/UnAdibVlgg5Dqei3/3" +
                                                              "6Hsn3+JHW8uw5AbUhyPAnK/6tbAhxpKmb41rZtCe+HzbR1NPXXlB2BPu6kPC" +
                                                              "ZGHxO5/FziyKZBJXn+1ltw//GnH9CVm3bS0tfMXIny/O//y5+dNRO9L3UlST" +
                                                              "1TSFYNU9iYibr+uDURS23v1I8y/OtlWMQJomUK2lyqcsksgFoVpjWllfWL3b" +
                                                              "kgdc22pWgCmK7HKY8Q42HBHP+/9HUmYTg3oJiMjtfRlRbyi7NIuLnvTiUnNt" +
                                                              "19J973HicS9jDQCPvKUoPrf8LlbrBsnL3JUGUdx0/kUp6lqlFWfdCH/gJptC" +
                                                              "fgbyJyxPUSX78ovNUbTOJ0ZZiPmTX2ieogoQYo8P6Ctkp7j2lSLlNegO0d/d" +
                                                              "IOzuEn9DxhKB/2rhIMUSv1vA1WDp0Nj91774jGgIJQXPzfFbLuBDtJ0ueW5b" +
                                                              "dTdnr+qDfdebLtXtcIAbaEj9tvHDB/jy5m1jqEMye91G6YML+1/59UL1O5By" +
                                                              "x1AEU9R+zPebgYgUtFkWVK1jyfI8gELDW7f+vidn79qd/8fveXm382bT6vIZ" +
                                                              "aeLR9xOXpj49wK/JVZCTpDSB6mXz7ll1nEjTRiCpmhgaMeNUHgc7fI3uLLsZ" +
                                                              "UNRTThXl9ylofWaIMahZas5Oy3XeTODnE6feWLoeWuDN+NhxSmSyaKMrMslR" +
                                                              "XXfa6id1noxKmFv4JF/8Pf7IhnP/BU1UdqLAFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Lnk5/x4AAA==");
}
