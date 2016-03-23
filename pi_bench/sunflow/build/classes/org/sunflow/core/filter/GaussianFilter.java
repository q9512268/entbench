package org.sunflow.core.filter;
public class GaussianFilter implements org.sunflow.core.Filter {
    private float s;
    private float es2;
    public GaussianFilter(float size) { super();
                                        s = size;
                                        es2 = (float) -java.lang.Math.exp(
                                                                        -s *
                                                                          s);
    }
    public float getSize() { return s; }
    public float get(float x, float y) { float gx = (float) java.lang.Math.
                                                      exp(
                                                        -x *
                                                          x) + es2;
                                         float gy = (float) java.lang.Math.
                                                      exp(
                                                        -y *
                                                          y) + es2;
                                         return gx * gy; }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwU1xF/d/7+wB8HmG8DxlDxdRdoaINMKWBsMD2DZROk" +
                                                              "Hg1mb++dvXhvd9l9a5+dkCaoESRVEQVCSAX8RZQUkUCrRm3VJqKK2iRKWikf" +
                                                              "bZJWIVVbqbQpalDVpCpt05n3dm8/7myE1J507969nZk3M2/mN/P20g1SYZmk" +
                                                              "lWoszsYNasW7NNYnmRbNdKqSZe2GtUH5iTLpb/uu71wfJZUp0jAsWb2yZNFu" +
                                                              "haoZK0UWKJrFJE2m1k5KM8jRZ1KLmqMSU3QtRWYqVk/OUBVZYb16hiLBHslM" +
                                                              "kmaJMVNJ24z2OAIYWZAETRJck8Tm8OOOJKmXdWPcI5/tI+/0PUHKnLeXxUhT" +
                                                              "8oA0KiVspqiJpGKxjrxJVhq6Oj6k6ixO8yx+QF3nuGBHcl2RC9quNH586/hw" +
                                                              "E3fBdEnTdMbNs/qppaujNJMkjd5ql0pz1kHyIClLkjofMSPtSXfTBGyagE1d" +
                                                              "az0q0H4a1excp87NYa6kSkNGhRhZHBRiSKaUc8T0cZ1BQjVzbOfMYO2igrXC" +
                                                              "yiITH1+ZOPXEvqbvlpHGFGlUtAFURwYlGGySAofSXJqa1uZMhmZSpFmDwx6g" +
                                                              "piKpyoRz0jFLGdIkZsPxu27BRdugJt/T8xWcI9hm2jLTzYJ5WR5Qzr+KrCoN" +
                                                              "ga0tnq3Cwm5cBwNrFVDMzEoQdw5L+YiiZRhZGOYo2Nj+JSAA1qocZcN6Yaty" +
                                                              "TYIFEhMhokraUGIAQk8bAtIKHQLQZGTupELR14Ykj0hDdBAjMkTXJx4BVQ13" +
                                                              "BLIwMjNMxiXBKc0NnZLvfG7s3HDsfm27FiUR0DlDZRX1rwOm1hBTP81Sk0Ie" +
                                                              "CMb6FcnTUssLR6OEAPHMELGg+f4DNzetar36iqCZV4JmV/oAldmgfCHd8Mb8" +
                                                              "zuXry1CNakO3FDz8gOU8y/qcJx15AxCmpSARH8bdh1f7f/blhy7SD6OktodU" +
                                                              "yrpq5yCOmmU9ZygqNbdRjZoSo5keUkO1TCd/3kOqYJ5UNCpWd2WzFmU9pFzl" +
                                                              "S5U6/w8uyoIIdFEtzBUtq7tzQ2LDfJ43CCFV8CWr4VtBxIf/MtKfGNZzNGEo" +
                                                              "iT5TR9OtBIBNGtw6nLBsLavqYwnLlBO6OVT4L+smTcC2EDKJbZJtWYqkdfO/" +
                                                              "cYwt4/8iNY+2TB+LRMDN88NJrkJ+bNfVDDUH5VP2lq6bzw2+JgIIg97xAiPL" +
                                                              "YL+4s18c94uL/eLB/UgkwreZgfuKk4RzGIGMBkitXz5w3479R9vKIISMsXJw" +
                                                              "IpK2BUpLp5f2LlYPypdj0yYWX1vzUpSUJ0lMkpktqVgpNptDgEHyiJOm9Wko" +
                                                              "Oh72L/JhPxYtU5dpBqBnshrgSKnWR6mJ64zM8ElwKxPmYGLyulBSf3L1zNjD" +
                                                              "e756V5REg3CPW1YAUiF7H4J0AYzbw2leSm7jkesfXz59SPcSPlA/3LJXxIk2" +
                                                              "tIUDIeyeQXnFIun5wRcOtXO31wAgMwkSCLCuNbxHAE86XGxGW6rB4Kxu5iQV" +
                                                              "H7k+rmXDpj7mrfAIbebzGRAWdZhgc+Bb42Qc/8WnLQaOs0REY5yFrODY/4UB" +
                                                              "49y7v/jTZ7m73TLR6KvvA5R1+KAJhcU4CDV7YbvbpBTo3j/Td/LxG0f28pgF" +
                                                              "iiWlNmzHsRMgCY4Q3PzIKwff++DahbejXpwzqM12GlqcfMFIXCe1UxgJuy3z" +
                                                              "9AFoUwENMGra79UgPpWsIqVVion1r8ala57/y7EmEQcqrLhhtOr2Arz1OVvI" +
                                                              "Q6/t+6SVi4nIWFo9n3lkAq+ne5I3m6Y0jnrkH35zwZMvS+cA+QFtLWWCcgCN" +
                                                              "lMp1zKcBO21BXio5OIZRpxat7dsvH23v+4OoM3NKMAi6mc8kvrHnnQOv80Ou" +
                                                              "xszHdbR7mi+vASF8EdYknP8pfCLw/Q9+0em4IDA91ukUlkWFymIYedB8+RSt" +
                                                              "YNCAxKHYByNnrz8rDAhX3hAxPXrqsU/jx06JkxPtyZKiDsHPI1oUYQ4O61G7" +
                                                              "xVPtwjm6/3j50I+eOXREaBULFtsu6CWf/dW/X4+f+e2rJbAfUkiXRJN5d+A4" +
                                                              "ZwRPR5i09dHGHx+PlXUDavSQaltTDtq0J+OXCf2VZad9x+U1PnzBbxweDSOR" +
                                                              "FXAKfHkdV+OugjKEK0P4s+04LLX84Bk8LF8LPSgff/ujaXs+evEmNzjYg/ux" +
                                                              "olcyhLebcViG3p4VLm7bJWsY6O6+uvMrTerVWyAxBRJlaDytXSZU1nwAWRzq" +
                                                              "iqpf/+Sllv1vlJFoN6kFD2e6JQ7SpAbQkVrDUJTzxhc3CXAYq4ahiZtKiowv" +
                                                              "WsAEXVg69btyBuPJOvGDWd/b8PT5axylDCFjHuePYp8QqMr8JucVhotvff6X" +
                                                              "T3/z9JgIpilSI8Q3+5+71PTh3/2jyOW8DpbIlhB/KnHp7NzOjR9yfq8gIXd7" +
                                                              "vri3gaLu8a69mPt7tK3yp1FSlSJNsnNz2iOpNsJ8Cm4LlnudgttV4Hmw8xdt" +
                                                              "bkeh4M4Pp6tv23Ap9OdAOQvEu1f96vEIcVLpFIbKcPWLED5JcZbP8HEFDqvd" +
                                                              "YlNlmArcrmmo2tRNIRSSjBPfI0orjj047BUykpMG4u6g4i1ux+z+llBcForj" +
                                                              "cF+xhpNxM1JGrbWldMxMoWPe22tlYa+CBwItvb/2etkg3DKbkVlFLbDoeRES" +
                                                              "Fkx2K+Pge+HwqfOZXU+tiTpAtYlBjuvGapWOUjWUeAsCidfL76FeFL/fcOL3" +
                                                              "P2wf2nInnTCutd6m18X/CyGFVkyey2FVXj7857m7Nw7vv4OmdmHIS2GR3+69" +
                                                              "9Oq2ZfKJKL90i/QquqwHmTqCSVVrUmabWrCULCmcezMe82z4Njjn3hCOUC+y" +
                                                              "QiFTaNcmY52iMD0wxbMHcRiDlB2ibAA6Jh7fXmjnb5d+U9cBXOg3+LoV9AJO" +
                                                              "Yo4psTv3wmSsIUujIq4LSXsPF/3oFP74Og5fg1wHf4R88cj/whd5RhqCd1Ys" +
                                                              "lrOL3n2J9zXyc+cbq2edv/cdnnCFdyr1kDpZW1X9cO6bVxomzSrcnHoB7gb/" +
                                                              "OVkKRMQ9muHbLZxwvU8I+tOMNIXpGSnHHz/Zk4zU+cgYtld85ic6Cy4FIpye" +
                                                              "M1xIa+I9Apa1uChr+YgPjhwnct/PvJ3vCyz+OxKCCH/56Ca8LV4/wpX+/I6d" +
                                                              "99/83FPijiar0sQESqmD3lBcFwugsXhSaa6syu3LbzVcqVnqwmuzUNgL4nm+" +
                                                              "+OoHRDfwyOeGLjBWe+Ee896FDS/+/Gjlm9Bn7CURiZHpe4sbgLxhA1rvTRb3" +
                                                              "wACw/GbVsfxb4xtXZf/6G95iEdEzz5+cHhqck+/2XBn5ZBN/21UBlYPmeWey" +
                                                              "dVzrp/KoGWioGzAaJXwNyf3guG9aYRVv9Iy0Fd8mit+DQPs5Rs0tuq1lOGwC" +
                                                              "oHsrgbegLs7ahhFi8FZ8N66tOKzPo/ch/gaTvYbhXrbeMnhGdoXvFXyRM1/h" +
                                                              "Uxy+81/7+NDKhxgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7RluIgAA");
}
