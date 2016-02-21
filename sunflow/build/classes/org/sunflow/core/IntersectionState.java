package org.sunflow.core;
public final class IntersectionState {
    private static final int MAX_STACK_SIZE = 64;
    float u;
    float v;
    org.sunflow.core.Instance instance;
    int id;
    private final org.sunflow.core.IntersectionState.StackNode[] stack;
    private final float[] rstack;
    org.sunflow.core.Instance current;
    public static final class StackNode {
        public int node;
        public float near;
        public float far;
        public StackNode() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wcRxmfO78dJ3d24kfc2E0cB9WJuaVNHyoOpYlr40sv" +
                                                                  "tokTS5xpLnN7c/bGe7ub3Tn77GKaFkEMElEQbhqq1n+lahW1TYWoQIJWRggo" +
                                                                  "akHqA0pBtICQCCoRDYiCGqB8M7N7+7g7R/yBpZsbz3wz8z1+8/u+uaevoBrL" +
                                                                  "RN1EozG6YBArNqTRcWxaJDOoYss6AmMp+ZEq/Ldjl0fvDKPaJNo0g61DMrbI" +
                                                                  "sELUjJVEXYpmUazJxBolJMNWjJvEIuYcpoquJVGrYsVzhqrICj2kZwgTmMRm" +
                                                                  "AjVjSk0lnackbm9AUVcCNJG4JtL+4PRAAjXJurHgind4xAc9M0wy555lURRN" +
                                                                  "nMBzWMpTRZUSikUHCibaY+jqwrSq0xgp0NgJ9TbbBQcTt5W4oOe5yPvXzs5E" +
                                                                  "uQs2Y03TKTfPOkwsXZ0jmQSKuKNDKslZJ9HnUVUCbfAIU9SbcA6V4FAJDnWs" +
                                                                  "daVA+41Ey+cGdW4OdXaqNWSmEEU7/JsY2MQ5e5txrjPsUE9t2/lisHZ70Vph" +
                                                                  "ZYmJD++RVh45Fv1mFYokUUTRJpg6MihB4ZAkOJTk0sS09mcyJJNEzRoEe4KY" +
                                                                  "ClaVRTvSLZYyrWGah/A7bmGDeYOY/EzXVxBHsM3My1Q3i+ZlOaDs/2qyKp4G" +
                                                                  "W9tcW4WFw2wcDGxUQDEziwF39pLqWUXLUHRjcEXRxt57QQCW1uUIndGLR1Vr" +
                                                                  "GAZQi4CIirVpaQKgp02DaI0OADQp6qy4KfO1geVZPE1SDJEBuXExBVIN3BFs" +
                                                                  "CUWtQTG+E0SpMxAlT3yujO47c782ooVRCHTOEFll+m+ARd2BRYdJlpgE7oFY" +
                                                                  "2LQ7cQ63vbAcRgiEWwPCQubbn7t6d3/32ktC5oYyMmPpE0SmKflCetOr2wb7" +
                                                                  "7qxiatQbuqWw4Pss57ds3J4ZKBjAMG3FHdlkzJlcO/yjz5y6SN4No8Y4qpV1" +
                                                                  "NZ8DHDXLes5QVGJ+imjExJRk4qiBaJlBPh9HddBPKBoRo2PZrEVoHFWrfKhW" +
                                                                  "5/+Di7KwBXNRI/QVLas7fQPTGd4vGAihDvigLvi0IvHHvym6T5rRc0TCMtYU" +
                                                                  "TZfGTZ3ZzwKqZbBEiQX9DMwaumTltayqz0uWKUu6OV38X9ZNIsUZTC1YCuay" +
                                                                  "K0ViDGbG//uAArNw83woBM7fFrz6KtyaEV3NEDMlr+QPDF19NvWygBW7CrZv" +
                                                                  "KOqHs2L2WTF2VqzkrF5o5dlR4FoUCvHDtrDTRZQhRrNw24Fum/om7jt4fLmn" +
                                                                  "CuBlzFeDg5lojy/tDLqU4PB4Sv7rwd/tHVn6+OthFAbWSEPacdl/u4f9Wdoy" +
                                                                  "dZlkgHwqZQGHCaXKvF9WB7R2fv7ByQc+xnXw0jnbsAaYiC0fZyRcPKI3eI3L" +
                                                                  "7Rs5ffn9S+eWdPdC+/KDk9ZKVjKe6AmGNGh8St69HT+femGpN4yqgXyAcCmG" +
                                                                  "CwJc1h08w8cXAw73MlvqweCsbuawyqYcwmykM6Y+745wrDWzplXAjsEgoCCn" +
                                                                  "7U9MGI//8md/2ss96TB8xJOaJwgd8LAK26yF80ezi6ojJiEg95vz419/+Mrp" +
                                                                  "KQ4pkNhZ7sBe1g4Cm0B0wINffOnkW++8feGNsAtDCmk1n4bqpMBt2fIh/IXg" +
                                                                  "8x/2YUzABgQjtAzatLS9yEsGO/kjrm7AUKq4HVbvUQ3Ap2QVnFYJuwP/iuy6" +
                                                                  "+fk/n4mKcKsw4qCl//obuONbD6BTLx/7RzffJiSzDOn6zxUTtLvZ3Xm/aeIF" +
                                                                  "pkfhwde6vvFj/DgQOJCmpSwSzoOI+wPxAN7KfSHxdm9g7nbW9FpejPuvkaeS" +
                                                                  "Scln33hv4+R7L17l2vpLIW/cD2FjQKBIRAEOuwnZjY+X2Wybwdr2AujQHiSb" +
                                                                  "EWzNwGa3ro1+NqquXYNjk3CsDEWCNWYC3xV8ULKla+p+9f0ftB1/tQqFh1Gj" +
                                                                  "quPMMOYXDjUA0ok1A1RZMD55t9Bjvh6aKPcHKvEQc/qN5cM5lDMoD8Did9q/" +
                                                                  "te/J1bc5CgXsbuDLqxhX+ziR19julb74+h0/f/Jr5+ZFlu6rzGOBdR0fjKnp" +
                                                                  "h37/z5IocAYrU0EE1ielpx/rHLzrXb7epRK2emehNL8A2bprb7mY+3u4p/aH" +
                                                                  "YVSXRFHZrmknsZpntzgJdZzlFLpQ9/rm/TWZKEAGilS5LUhjnmODJObmNegz" +
                                                                  "adbfGEBcBNnlQJuNuLYg4kKId0b4kl28vYk1ewSXsG5/obgfwwnatM5+FPSC" +
                                                                  "/OTPhOyNNJFPW5DPlByw4Jxdxd0yflxe7h3/g4j91jILhFzrU9JXJ9888Qrn" +
                                                                  "2HqWMY849nry4X5z2sPdUdZ8lF2odTAV0Edaanln9rHLzwh9ggAKCJPlla98" +
                                                                  "GDuzIrhP1Ok7S0pl7xpRqwe027HeKXzF8B8vLX33qaXTQqsWf9U5BI+qZ37x" +
                                                                  "71di53/7kzLlTpViv7XYhQ4Vq5QtflcLg+75cuR7Z1uqhiG5xlF9XlNO5kk8" +
                                                                  "4wdanZVPe3zv1v8u+GzTWI6hKLTbMOz8ydo7WBMXcBqoSD4H/PDthE+7Dbf2" +
                                                                  "CvBNCfiy5t5SsFZazcBK7Cpq1I4I+/q0p3+Usmun4xI3sn+ngrYd/x9t2+pU" +
                                                                  "6853Gdtm17Wt0mqIfRZzOssEdFTX0bFQngaqOA1AXWHxBzRziaJh1eWFase9" +
                                                                  "lTKbJyUgBvuuSo9CDvkLD62sZsaeuDlsJ+hJONp+q3v3oaihWKvziQ6Keq5f" +
                                                                  "4MPxHSW/HIjXrvzsaqS+ffXom7zCLL5Im4B2snlV9VKup19rmCSrcE2bBAEL" +
                                                                  "0J+iKBpUBzDHvri6DwixL1C0wSNG2S3jPa/QlyCgIMS6pw3H2ChPyyyVxEQq" +
                                                                  "KYT8ji4GvfV6wPTEZqePMPlPMQ5Z5MWPMSn50urB0fuv3v6EKHtlFS8u8qc7" +
                                                                  "UIQorovvhh0Vd3P2qh3pu7bpuYZdTrR9ZbdXN9YH/UO8RO0M1IFWb7EcfOvC" +
                                                                  "vhd/ulz7GhDiFAphijZPlSbdgpEHGE4lSqkQki4vUAf6Hl24qz/7l1/zqsam" +
                                                                  "zm2V5VNywwdnFndYoVgYNcRRDQCZFHg1cM+CdpjIc6aPV2vTel4r/mKziWEN" +
                                                                  "s59ouFdsZ24sjrLXEKC7NMGUvhCh3Jsn5gG2u83TXrA25g3DO8u9mhSMx7wM" +
                                                                  "OEslDhmG/UgISdzrhsHv8aOc9f4LvknYM2MVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public IntersectionState() { super();
                                 stack = (new org.sunflow.core.IntersectionState.StackNode[MAX_STACK_SIZE *
                                                                                             2]);
                                 for (int i =
                                        0;
                                      i <
                                        stack.
                                          length;
                                      i++)
                                     stack[i] =
                                       new org.sunflow.core.IntersectionState.StackNode(
                                         );
                                 rstack =
                                   (new float[53 *
                                                256]);
    }
    public final org.sunflow.core.IntersectionState.StackNode[] getStack() {
        return stack;
    }
    public final int getStackTop() { return current ==
                                       null
                                       ? 0
                                       : MAX_STACK_SIZE;
    }
    public final float[] getRobustStack() {
        return rstack;
    }
    public final boolean hit() { return instance !=
                                   null; }
    public final void setIntersection(int id,
                                      float u,
                                      float v) {
        instance =
          current;
        this.
          id =
          id;
        this.
          u =
          u;
        this.
          v =
          v;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+0TXW8mh7H+ZoxD90iMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6eezk9nUf97fSHjp2V3Ik2Yol61jFsegu5+ZMFcUmOcPh" +
       "cMi5SM5BNVlzeA05vI8hh4ns2EFjI0Fdt5FdF3UEF7B7GIpttAkatE2jImiT" +
       "IIGBBEEvIHZqBGgS14X9R5wiTpt+yfndu/tbbx0NwO98ye/13vu+93nve7zx" +
       "Tej+MIBgz7W2uuVGN9Q0umFa9RvR1lPDGzRTH0lBqCqEJYUhD77dlJ/78tXv" +
       "fPcTq2t70AURepvkOG4kRYbrhBM1dK2NqjDQ1aOvHUu1wwi6xpjSRkLiyLAQ" +
       "xgijlxjowWNNI+g6c0ACAkhAAAlIQQKCHdUCjR5Wndgm8haSE4U+9EHoHANd" +
       "8OScvAh69mQnnhRI9n43o4ID0MOl/H0KmCoapwH0zCHvO55vYfiTMPLaP/jx" +
       "a//iPHRVhK4aDpeTIwMiIjCICD1kq/ZSDUJMUVRFhB5xVFXh1MCQLCMr6Bah" +
       "R0NDd6QoDtRDIeUfY08NijGPJPeQnPMWxHLkBofsaYZqKQdv92uWpANeHz/i" +
       "dcchmX8HDD5gAMICTZLVgyb3rQ1HiaB3nW5xyOP1PqgAml601WjlHg51nyOB" +
       "D9Cju7mzJEdHuCgwHB1Uvd+NwSgR9OQdO81l7UnyWtLVmxH09tP1RrsiUOty" +
       "IYi8SQQ9drpa0ROYpSdPzdKx+fnm4Ec+/hMO5ewVNCuqbOX0XwKNnj7VaKJq" +
       "aqA6srpr+NCLzKekx3/1Y3sQBCo/dqryrs6/+slvv/+9T7/5m7s6P3ibOsOl" +
       "qcrRTflzyyu/+07iPa3zORmXPDc08sk/wXmh/qP9kpdSD1je44c95oU3Dgrf" +
       "nPzHxU99Qf3GHvRAD7ogu1ZsAz16RHZtz7DUoKs6aiBFqtKDLquOQhTlPegi" +
       "yDOGo+6+DjUtVKMedJ9VfLrgFu9ARBroIhfRRZA3HM09yHtStCryqQdB0MPg" +
       "gR4FzyVo9yv+I+jHkJVrq4gkS47huMgocHP+8wl1FAmJ1BDkFVDquUgYO5rl" +
       "JkgYyIgb6IfvshuoSC9X0xA0BezmJqXeyNXMe6sHSHMOryXnzgHhv/O06VvA" +
       "aijXUtTgpvxajHe+/cWbv713aAr7somg58BYN/bHupGPdeOWsaBz54ohfiAf" +
       "cze3YGbWwMYB+j30Hu7H6A987LnzQKm85D4g1rwqcmcQJo5QoVdgnwxUE3rz" +
       "08mHpx8q7UF7J9E0pxN8eiBvPsox8BDrrp+2otv1e/Wjf/ydL33qVffInk7A" +
       "876Z39oyN9PnTks0cGVVAcB31P2Lz0i/fPNXX72+B90HbB/gXSQB/QRQ8vTp" +
       "MU6Y60sH0Jfzcj9gWHMDW7LyogO8eiBaBW5y9KWY6itF/hEg4wdz/X0neJ7e" +
       "V+jiPy99m5enP7BTjXzSTnFRQOvLnPcL/+Urf1ItxH2AwleP+TVOjV46Zvl5" +
       "Z1cLG3/kSAf4QFVBvT/49OjnP/nNj75SKACo8fztBryepwSweDCFQMx/+zf9" +
       "//q1r37u9/eOlCYCri9eWoacHjKZf4ceOINJMNoPHdEDkMPaaW14XXBsVzE0" +
       "Q1paaq6lf3n1hfIv/8+PX9vpgQW+HKjRe+/ewdH3d+DQT/32j//500U35+Tc" +
       "cx3J7KjaDg7fdtQzFgTSNqcj/fDvPfUPf0P6BQCsAMxCI1MLfIIKGUDFpCEF" +
       "/y8W6Y1TZeU8eVd4XPlP2texCOOm/Inf/9bD02/9u28X1J4MUY7PNSt5L+3U" +
       "K0+eSUH3T5y2dEoKV6Be7c3B37pmvfld0KMIepSBXw6HAYCY9IRm7Ne+/+J/" +
       "+/e//vgHfvc8tEdCD1iupJBSYWTQZaDdargC6JR673v/bnKTHJOvFaxCtzC/" +
       "U4q3F28PAgLfc2d8IfMI48hE3/4XQ2v5ka//71uEUCDLbRzrqfYi8sZnniR+" +
       "9BtF+yMTz1s/nd4KuyAaO2pb+YL9Z3vPXfgPe9BFEbom74d6U8mKc8MRQXgT" +
       "HsR/IBw8UX4yVNn55ZcOIeydp+Hl2LCnweUI7kE+r53nHziFJ+/IpVwGz+V9" +
       "U7t8Gk8KD7Cb45ykwkvoavDo1z/7uT//8Eebe7lC37/JSQdSuXZUbxDnEeXP" +
       "vPHJpx587Q9/rjB40PP7807fVwz/bJFez5N3F/N7PoIueoGxAZ4HgEJYRKgR" +
       "4MlwJGsfHP4K/M6B5//mT05p/mHn0h8l9uOKZw4DCw+4uSssNr/J8RjRv8n1" +
       "xM7ZKjQKDBvg3mY/tkJeffRr68/88S/u4qbT+nKqsvqx1372r258/LW9Y9Hq" +
       "87cEjMfb7CLWYkIezpNeboHPnjVK0YL8H1969d/8s1c/uqPq0ZOxVwcsLX7x" +
       "P/2f37nx6T/8rds4/fMgrt45iDyt5Mn7d6Kt39Ec/+ZJXL66j80HGH1SWaAi" +
       "M739BO+wrBdB5+KiiNnnOv8b5TMNoOI0ebO3gLwP3I28TZ555RQl0j1S8viB" +
       "uz74vw0l+l0ouWTsG3dR47EIesdtorZdjVPUru6R2pzCh/apfegO1Hp3oXbP" +
       "UPLc8BQp/vdOSh6qQ9eh/cD94P82pCS3J2Uvz5J5Qh0QdT8Qj7wGlvXCne2+" +
       "cNM7M379nzz/lQ+9/vx/LzzdJSMEAIsF+m0Wb8fafOuNr33j9x5+6otFNHjf" +
       "Ugp3UHt61XvrovbEWrUg+KGTovjBs0RxoBPvvXskf53LhTBwFfXQw57bj9mL" +
       "CciTDx3I9qfPkO0Pn5DtBUt19N16q5j0D3rpYf97u0YHRL7tyDMQluuoeXx1" +
       "ULZbXxjujcMtB1CY3kJpAL145ylkC0keueDf+MifPsn/6OoD97CweNepGT7d" +
       "5T9n3/it7g/Jf38POn/okG/ZjzjZ6KWTbviBQI3iwOFPOOOndsIv5LeTfJ68" +
       "UIj4jJDw588o+2SefALovpyLejczZ1T/dAqdMtn0Hk32WfBc2dfTK3cw2X/0" +
       "PZvshWBns/nrTx4OVKASyOz9ym6c3X8EvfLXtNT28j2zAOGIYvMsOFjJv5Xd" +
       "Fwy/cmeT/McHsvv892iSefIzh+b42VvNMX/9WJ787K32lb//nd2wRes8+Xtn" +
       "qM0bZ5R9MU++kCef2lFyRt0v36J+n7lH5/UYtHP80MH/bdTvX97FeV2U4wAs" +
       "1Iv4wzpFzy/dlZ6iExArA5ur3EBvlPL3f32HMPdw0rontP4J05KvHwSxU4Df" +
       "AK2umxZ6gJLHYuvdDuYpInvfM5EASa8cdca4jv7Sz/3RJ37n7z7/NeD16INo" +
       "Pq+NA70YfTf7tYLcX783fp7M+eHcOJBVRgojtlhWq8ohS6eiv/sAVP3/sxRd" +
       "+7dULexhBz+mLBGzRC5PLDhG0U0PnmwXHlvjfX9RGwo9oU3MWX4tl93adJiS" +
       "ZZ2thigZoevIFheqFG3G9XJPJPtjP+rqE6/XRwl/4CUDTOkaQjAfu31X1iN6" +
       "a02Zfl+ZbMkOKZGcr5dGLWRZWToVYrjGiWxgt6w6ilQ3mxZaReCmRlWNuUWu" +
       "bUlipUalz+PBrDG1rVBo9yI7Xk1pOZRWjpzC8oJrTOH5hrcS0TMEs95usLLj" +
       "W9sZE1iSawd4l+vHxkzIOLHrDgQ6wLoL1o4kvc6YJFkuLXtLdu5zqe33jDic" +
       "l1pjisFp1h+uuRnDToe0N9lEIeZuSxO3yxNDeV1ajULUbXAza12lo+qqmWVt" +
       "NSu1hm3GCmwhLa1Mpe+WmTU/4cudlRBOV9XUGDtdxm0MpcAPAAuzgTJr8ZMl" +
       "rsaGB89cd1RRV3oTrpqb2ZYUEq7VKzlzKg2wqlCKpqntGhy+0aK+N7MDdkNH" +
       "pRVtDSY13BxxnbkwM2XC6ExNYa0sFFzJ5gJXURrRrD5kt6tpF+1tccw0kHKn" +
       "zdqCYEriWK5lQn+1juK0ya4NtE/E0bpNU+kwGhmdTFNJx9xws/ViMS71B+44" +
       "NNh2J0lm3XGXLFmcbFviqLfu8L3GhMYq7EiYDifT7gxdqpbNpc6UphfdZhb5" +
       "iah4et1r8lNlvuio40zIGB5Iq2bM6uOWjWy9vj/A/G3mkBY56cfpRtYXjECY" +
       "tEUTWjZ0rH6DVzqciSeaQ3enocoaXQzn++W+YKqO6AlumZg2xmLcMXyfG0zc" +
       "JdZaTiZd0rf1ZCiZzFige35jYEzqdjbpL2Bjos+7bVePutM5SdbwSVfUVUoW" +
       "PN0TJczis4o613S0XZ5L3bjMYms8S9a+31whbSH1iVImjemR4DHYKGV5KYv1" +
       "QclLKMWVaV3uZlhtRNpkq9lE2vV+yx2OuKDLsHomOuVmvz4V+UFNC6otf6Ei" +
       "W7YUj03Ba0fpuLRZt7abMOyiIhqbWKfHbhWmw8eow9bb3RSFU2taLTka4TH+" +
       "yGLjhr1u4FQ2p9XQG0+7fuxO3DItLHhN4vqSa6nVqEX1Y6zu2ythQ1Y0nvSF" +
       "lkhy1rLplxFrI5AdjusTfT8mxZLYbzQraW/ZSxAxSQkOL8sebsecwcAwXZlw" +
       "24Gpul6XJh2O7FRGbdptbN1mtzyhuRXZYZzVaCzB+qTfKFnTeclYeNZ20lao" +
       "EG1ZVYmbjJwJTzQkImYMS8LVhq2RFlPHcWKmDFadvo705nggIURg2YGfWH4a" +
       "814LmwXtFcyOOFQmApUIJlG3YncjxokjxtoG/YocdfQgpRdoe7CYRgnPLBe9" +
       "Zns7WMQU6pWq4lJBubk+ZcVOX9KnK3SJ6uvKhkjGQzXU1lqjjqIKVxYqcquz" +
       "FVdJz63heDhvpkqdxeE2AHxmgHXHQmKilLZlyM4S3bS34zES2oq9bTQNfqin" +
       "Wmc9w8Qa1hpSJd7NOHTSUbZNWNUrKBVkOhpt7AGjLNUtQ6xrybZu040Bpg66" +
       "kzFMm3IsGA0GWWLTjrqwMGaNscmWWC7IHrlaylhJ45wxavTi7bTHYJxSZjnO" +
       "qwx5XMxkkdVkupVkldDgmxrekKJkVsk6/VpFTZF0iCyH7JJQ+lnCaZyg44JW" +
       "kmsSayNIs07GjuwIaG2A6IbitS1qimKYSg/mA1ea08qyZaxJVmpFXSSBWyoS" +
       "V8KslYWLkOM1fVVdtHRmrGMWniktuDXqzeeOVUfQwapclsXJIC1ReH/Ok2JP" +
       "68C+kei0vy1n8JjCAAjaIe9WpJiYclZ/UjMCMtNIOmn1eRTZUM56ucK3flNW" +
       "UjcVO3Q8RJx5iYjVzXbbboU1WyRYTBlNbR74xxEWWtX+SBJ8fttR7LQFQKu6" +
       "6sQrJ6HabUEIRL7txp1GDU/cRnXdXCs1teLraHUSDo3tpolsqtZWTQ3ZQp1q" +
       "BVlGI7SdonZ15Ga9BhzB25k5Q/X5YB1mY6oed7rtGRctFiYZ1aUhwU0283Fa" +
       "wlOcMPtrrL5olMpY5GYjFs4m4mSKqKpRldFFcyowhF+yy/46pssTRhP74z5A" +
       "bmmREP2uOmw2a9OUzjBhQNETboEmPouYzXLkT2VPnzPaEgWSbaKDjV21xWF9" +
       "nrj6tKkaMyPUm5TKL6NlzKJO5pixEsebGUmkw5G1WnYCtouoE3gzhVl0jtSH" +
       "5qJXl9R5n0xG28m2113OnGCkLbSRAnfa4hah650Fh5GrKmpYVW9TU5YGgszF" +
       "lWDSeLci19VByfK7pmYR3UloeSNu7C6DBqI48y0zbbAoUWv2dIWyZ+1xf95t" +
       "UnpX0Ey5XMJ8WDJxAe76zUAF+IUHQxoHWjQKw3G7utXLdhlBSloN0JE1gPOr" +
       "cq11LdTrkjTnqbY0Trkl2khGs2igDDeapy0pztDMEj9vDmfz5nxRHxhxrV8f" +
       "J4LdXRDedjbGNiBkgBtd2VhLdE/C6Hp9wq9sj2kgdZhZAOUcoaVZ6i4bk6lW" +
       "7xlbdePOeVl3DM/DcCyFq3KT5nFGY2Iz7FRXNDLIsgFu0lFLhSeoXUc1WOeo" +
       "eslnt+xwuDSraRTKckvmgGSolohgcz2O+A2NBxpBboOhqA5b5NJiq6U2Nqiq" +
       "aZdqJ/rYnnmwqESDZatm4diqoVSwpMpXW44MN1rrhMnwObXihHp3GVVNU98S" +
       "VDepLHiZ4RoVwoNTOG5VeaTqt3xL0f3I1hAQdYX1ioKA6Su1Suh8Uw75VJzW" +
       "LINC1uOlwIjRcF3bVCqdMa6oJaQdbGQwqVtKatWpftQXQcQktgitGftMm5MX" +
       "cFrtDntxNghLCpaYvXEjGS+MqT1AcVMMVpyqTieYCFyYWrEJiuMUGd7Is9oY" +
       "oZFRjOP0Fo4w3Vu0l4MJcClRSC1TEXW4KuZgcub08QmSugPOdGq0sOmJi2bb" +
       "HbYbrj6Zi4JUq61aBm05o1HY6OnxOFnSU3W6mi0ywbOjGkww6iJjs/oINtIO" +
       "3uekkaB7ctxa2i4qYWQ77nMW6Q6MwYpekKNuwoboJmsyQ1pcU+MxXOHd6miY" +
       "xO0YwWpaKo+JZbLAgkEqrAi31o+9WRWWonQ24e2GGCyadU0YjZJlY6sgcVnR" +
       "uazBtusZskThSHBqaYtvUyqZBhUC8XW7b2BmxBCVYbpqxOKsLjdVdc6uI6VG" +
       "WZI3wwmjNwnW/mxVqwcpUqOnVcevByPZHPV9YTHtbtmmpxKyEbY2em9oNda4" +
       "DfDXjON4OGLoaMb2ynwJG4YhPoNrI93Ho4ZTJnmqAqKzKUUtTL0fTbuTeXnF" +
       "ZkteiRpUix0Y63C0ZtrgjZyWzRltoAhHN1HOUCpTZjkgxK1KCXS/AjNMX2s0" +
       "p4Ot5G9GtjWzujMuHiueN5jMan1TnimmkYwFtaJZlS1C1BfleFjzJk2NxVa6" +
       "wW8abSSp0J7VdKaruRfy3Rk+5OUm4iuh1pS8wTbq23W3laJyX68SizhyJtsw" +
       "FerVVjrxhrBTGST9YVnpNhMrIFMLXjMbThUb2YQhdYUtT3qRaMTDIFpOUw1j" +
       "qBiZN8d+ik+a1JQf40u4Sg+VLasNdH9DOqG5MVluJCyrjMz0o20bD9uzsuBp" +
       "5USmhr5kIXh/TVPlCpVxlVq5zBNsVtEEJy1bHp0OJrSIO1SoumnN7xprJluI" +
       "/KqeVHpCkIThQNBZmDI2hDjkezMxcnQtNdaaPJ2201hlMwpfDAaSP0IHJTho" +
       "DRuK04mjzVCxaZGWt0NGC1J37VOS6q/KY1FD6qnllmc00xSCdWNpyg2dsar1" +
       "Ub2lO0Oq21txTI3Fs4nmqym8GK1724EQLtrkCFUbaWCbJWXbI2FajweDMa65" +
       "gj2ezIkoyixZZcslwbVWnWqkMi2mgmfTpujPyRIrpZm6ihRlmZVWyhznElLT" +
       "4VC2ESszvXWDsDphb0OjE80dLhB25owGODXZlNSBt6WAd5luBxsqjQcLgqya" +
       "chWx7aG9BstFo2S2wEIL5lGqjnVQdpG4aMnsJj0fDcDaBUBPO2rESJtpJIhJ" +
       "O+sRYwCHZFNm3YHBmGyjv+qQ9LI2D7tdJ/Om87YozMuG0pMSAhioKMntkSTW" +
       "S0Ox2eCaSpkWqenMN/0GM5stpLFHbx3Kjf2mgyHTWjz0NYqw3TkTZ+zSSecU" +
       "Do9xqbudTbdLzlfjCHZiZZuANcxKiptTa4yr845ZZuneAiHGWJdZtSfrIRB8" +
       "e6aT8IhlF1NrVFtXtXHPwfFujxsZScnREVnABaHFpqMtjsbhtlmC15tesznv" +
       "0kw2d+ZIQxm03WizqVJ1JnLKelmWgSebNTmHJO1pZINY3ZwmyxWtKcu+Bw/7" +
       "RBlPpfosnmvlFOFbU46GexViISrtMqpXFojeIjptHsARzNZ1ZTZGBug2QeCE" +
       "0lAYRbrrGl2p2b2xNRyLUdZHm2IvqXjJUHSX4ZoxDaeJlcxqc9UaOkFowEqD" +
       "4d11ud6HXRwsvet9f9SyU23ZmzUSn/PN+gRn151sQ0xaNYmr6HJgen4LBkH1" +
       "vFQOKhjpjzbGcqUlkyRQzH7AxnAqtxKT4R1yRWejUnmmw9G4mfTXps37mK7O" +
       "oy5ZU1FrRi+pTGA3uoiS7qbSqZEKlwGtWsHAz8+a9gqlYNFN262SwWIY9vLL" +
       "+TbGV+5te+WRYrvo8PabaaF5wa/dww5KevdNxcNttuKX78CeuEh1bJvt2Dk9" +
       "lJ9jPnWnu27FGebnPvLa68rw8+W9/f23cQRdjlzvb1jqRrWOdXX/blPykIyn" +
       "8u5fAM+L+2S8eHq374j/u++WnrEn+fUzyv4oT/4ggi7palScq+TvHzyS+Vfv" +
       "tmt1vMNTDOY7mdAz4KntM1h7ixj8X2eUfStP/iSCHjxgkHeLwYdHPP7p98Fj" +
       "cefg3eB5eZ/Hl98iHv/ijLK/zJM/i6ArgMeJu4zDo6n87BGb3/l+2cyvanX3" +
       "2ey+NWyeu3BG2aU8ORdB51dGdLtd14tL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("17VUyTlk+dze98FygRTvAw+/zzL/18jy+SM4LE43ivP5VwouHztDAk/kybUI" +
       "uprfIz12LnrbPeiNayhHonjkXkSRAki+5dw1vw729lvuZu/uE8tffP3qpSde" +
       "F/7z7tj44M7vZQa6pMWWdfz2zrH8BS9QNaMQ0OXdXR6vYPPZCLp2+hwYMJT/" +
       "5aSee2ZX7Tqw6mPVgALs545XejfQF1Apz/6wd5vjh92tpPTcScw/NJpH7ya2" +
       "Y27i+RMnusVl94PT13h33f2m/KXX6cFPfLvx+d2lRdmSsizv5RIDXdzdnzw8" +
       "wX32jr0d9HWBes93r3z58gsHjufKjuAjtTxG27tuf0OwY3tRcacv+5UnfulH" +
       "/unrXy3uNv0/Dyc74YUwAAA=");
}
