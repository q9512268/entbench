package org.sunflow.core.shader;
public class AmbientOcclusionShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color bright;
    private org.sunflow.image.Color dark;
    private int samples;
    private float maxDist;
    public AmbientOcclusionShader() { super();
                                      bright = org.sunflow.image.Color.WHITE;
                                      dark = org.sunflow.image.Color.BLACK;
                                      samples = 32;
                                      maxDist = java.lang.Float.POSITIVE_INFINITY;
    }
    public AmbientOcclusionShader(org.sunflow.image.Color c, float d) {
        this(
          );
        bright =
          c;
        maxDist =
          d;
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        bright =
          pl.
            getColor(
              "bright",
              bright);
        dark =
          pl.
            getColor(
              "dark",
              dark);
        samples =
          pl.
            getInt(
              "samples",
              samples);
        maxDist =
          pl.
            getFloat(
              "maxdist",
              maxDist);
        if (maxDist <=
              0)
            maxDist =
              java.lang.Float.
                POSITIVE_INFINITY;
        return true;
    }
    public org.sunflow.image.Color getBrightColor(org.sunflow.core.ShadingState state) {
        return bright;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        return state.
          occlusion(
            samples,
            maxDist,
            getBrightColor(
              state),
            dark);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Zf4wUVx1/u3fcLzjuB+X4eQccBwlX3G1LadMeAsfBlaN7" +
       "cHItxkNZ3s6+vR2YnRlm3t4tVLSQKGgioQoUm5b4B00r0kLUxhptxWhtCdWk" +
       "LbWtjaDGRLQSS43VFLV+v+/N7MzO/sBT4yXzZva973vv+/Pz/b53p6+SSbZF" +
       "OpjOI3y3yezIOp0PUctmyT6N2vZ90BdXHq6if952ZeNdYVIzQqamqT2oUJv1" +
       "q0xL2iOkXdVtTnWF2RsZS+KMIYvZzBqjXDX0ETJdtQcypqYqKh80kgwJtlAr" +
       "Rloo55aayHI24CzASXsMOIkKTqK9weGeGJmiGOZuj3ymj7zPN4KUGW8vm5Pm" +
       "2A46RqNZrmrRmGrznpxFbjYNbfeoZvAIy/HIDm25o4INseVFKug82/T+9cPp" +
       "ZqGCaVTXDS7Eszcz29DGWDJGmrzedRrL2LvIZ0hVjEz2EXPSFXM3jcKmUdjU" +
       "ldajAu4bmZ7N9BlCHO6uVGMqyBAnCwoXMalFM84yQ4JnWKGOO7KLySDt/Ly0" +
       "UsoiEY/eHD3y8Lbmb1aRphHSpOrDyI4CTHDYZAQUyjIJZtm9ySRLjpAWHYw9" +
       "zCyVauoex9KttjqqU54F87tqwc6sySyxp6crsCPIZmUVblh58VLCoZxfk1Ia" +
       "HQVZ2zxZpYT92A8CNqjAmJWi4HfOlOqdqp7kZF5wRl7GrnuBAKbWZhhPG/mt" +
       "qnUKHaRVuohG9dHoMLiePgqkkwxwQIuT2WUXRV2bVNlJR1kcPTJANySHgKpe" +
       "KAKncDI9SCZWAivNDljJZ5+rG1ccekBfr4dJCHhOMkVD/ifDpI7ApM0sxSwG" +
       "cSAnTumOHaNtzx0MEwLE0wPEkuY7n762emnHuZckzZwSNJsSO5jC48rJxNRX" +
       "5vYtuasK2agzDVtF4xdILqJsyBnpyZmAMG35FXEw4g6e2/yTTzx4ir0TJg0D" +
       "pEYxtGwG/KhFMTKmqjHrHqYzi3KWHCD1TE/2ifEBUgvfMVVnsndTKmUzPkCq" +
       "NdFVY4jfoKIULIEqaoBvVU8Z7rdJeVp850xCSC08ZDk89UT+iTcnajRtZFiU" +
       "KlRXdSM6ZBkoPxpUT9IoZzZ8J2HUNKJ2Vk9pxnjUtpSoYY3mfyuGxaJ2miaZ" +
       "Fe3NJFQAq02KomVtkHxYdEfQ5cz/52Y5lHzaeCgERpkbhAQNomm9oQFtXDmS" +
       "XbPu2tPxC9LdMEQcnXESgX0jzr4R3Dci942U3peEQmK7m3B/aX+w3k7AAQDi" +
       "KUuGP7Vh+8HOKnA8c7waVB8G0s6ChNTngYWL8HHlvQ2/XrZ+792vhUkY8CQB" +
       "CcnLC/N9eQETmmUoLAmwVC4/uBgZLZ8RSvJAzh0f37fls7cIHvxAjwtOAozC" +
       "6UMIz/ktuoIBXmrdpgNX3j9zbK/hhXpB5nATXtFMRJDOoFGDwseV7vn0mfhz" +
       "e7vCpBpgCaCYUwgdQLmO4B4FSNLjojLKUgcCpwwrQzUccqG0gactY9zrEd7W" +
       "Ir5vAtNOxtBaAE+TE2vijaNtJrYzpHeirwSkEKj/0WHzsTd/9vtlQt1ugmjy" +
       "ZfZhxnt8oISLtQr4afFc7z6LMaD75fGhrxy9emCr8DugWFhqwy5s+wCMwISg" +
       "5s+9tOuty5dOXgznfTXEIStnE1Dc5PJCYj9pqCAk7LbY4wdATYNYR6/pul8H" +
       "r1RTKk1oDIPj702Lbn3mj4eapR9o0OO60dIbL+D1z1pDHryw7a8dYpmQgknV" +
       "05lHJpF6mrdyr2XR3chHbt+r7V99kT4GmA84a6t7mIBOInRAhNFuF/JHRbss" +
       "MHYHNl223/kL48tX/MSVwxffbdzy7vPXBLeF1ZPf1oPU7JHuhc2iHCw/Iwgw" +
       "66mdBrrbz238ZLN27jqsOAIrKlAy2JssQKZcgWc41JNqf/HDH7Vtf6WKhPtJ" +
       "g2bQZD8VQUbqwbuZnQaAzJmrVkvjjtdB0yxEJUXCoz7nlbbUuozJhW73PDvj" +
       "2yueOHFJOJVYob04XtocV2orHS/YLsamu9gLy00N2CvsYC/+nsnJDD/Eqxmo" +
       "YJB7KNYKsBnr+eFswgaEVTMQcmNOxXHb0HblYNfQb2U1MavEBEk3/cnol7a8" +
       "seNlEdB1iOHYjyw0+hC61xr1oUmzFPFD+AvB8098UDTskJm7tc8pH+bn6wfT" +
       "RP9YUqHgLxQgurf18s5HrzwlBQjWVwFidvDIFz+MHDoio1QWoQuL6kD/HFmI" +
       "SnGwuRe5W1BpFzGj/3dn9n7vyb0HJFethSXVOjgxPPXzf7wcOf6r8yVyNsCl" +
       "QXne3CEJX4i0hdaRIq39QtP3D7dW9UOGGCB1WV3dlWUDSf+aUEXb2YTPXF55" +
       "Kzr8wqFpOAl1gxVE97oKWDGCzWoxdCc2vRJY7/734g07VskZc0RfNZY5BcWE" +
       "OLZ6ufDUa3e+/sRDx8alTit4SGDezA82aYn9v/lbEUqJ1F/CaQLzR6KnH53d" +
       "t/IdMd/LwTh7Ya64NIMqxZt726nMX8KdNS+ESe0IaVacY+IWqmUxs43A0ch2" +
       "z45wlCwYLzzmyJq+J19jzA16rW/bYPb3u0I1LzC7l/CnoFlmOUjkIlIBgIWI" +
       "+JD1wmLRLsFmqZtfa01LHYMYDiTYyRUWhaScsNTRtMiW/R5ECodK3cih4oXc" +
       "z3Bx2H2X4F73EDhdzGa52RzUTq2dpZg0JsjkTPfDfZdgMluRyXKzwQA2zZga" +
       "pEz8vd6BK3wN+r4/xkmVqhfhC/78eC4g3NgEhZsNT6PDXmMZ4fZVFK7cbBAu" +
       "Q3NrnbpqQ4DP/RX4zJXKueKvhgSOksGcO8eB3lKZVhym5KkJU0J7udsAkQ5O" +
       "7j9yIrnp8VvDDnRu5lChGOZHNDbGtAAGthdg4KC4//AApeHzt0yL8Vyq+CyF" +
       "q3SUOS11lwfL4AYv7v/D7PtWprdP4KA0LyB7cMmvD54+f89i5cthcYUj8avo" +
       "6qdwUk8hajVYjGctvTBldeatOQ2Nh9g117Hm3KDv3bj4Kje1cvHVUeQSQjWM" +
       "MwsrRpeszU82LN+9QwOCrUcqpNivYXMUQDJrJgFYbxTXtQnD0BjVS8e2Fy7H" +
       "Jp6pRfdDebW14NA8eBY7als8cY2XmxrQR6gwCNtLBqGqj+IlKBPbnqmg0W9h" +
       "c4qTqaOMrxGZRxTLAtk9BX3jf6Mg9KVuR8ruiSuo3NTSCsKfZ8Wqz1WQ/wfY" +
       "PMvJZJB/M+jNRQ6f8N/9r4UX6XMlPBFHgsjEhS83tXQ8CuGFHGLp8xU0cAGb" +
       "H3PSaCuUQ5wOpQ3uwFsgnKrHDDXp6eWF/6C+hdAvfdOG582ZRff88m5aefpE" +
       "U92ME/e/IW598vfHU+Dglcpqmr+a833XmBZLqULEKbK2M8Xr9VKJS94CArDI" +
       "D8H+RUn/JifNQXrQBb78ZG+DD/nIsPiQX36iS1BrABF+XjbdCG4Wx2ysaiOy" +
       "qs2FfCmQ+HBq+o00np/ivxXCFCf+0eKmo6z8V0tcOXNiw8YHrt3xuLyVUjS6" +
       "Zw+uMhlOSPKCLJ/SFpRdzV2rZv2S61PP1i9yU3qLZNhz7Dk+n1sF8WmiyWcH" +
       "rmzsrvzNzVsnVzz/04M1r8IxYysJUU6mbS2u/3NmFiqErbHikyCke3GX1LPk" +
       "kd0rl6b+9La4pSDy5Di3PH1cqf/g0J4FdigSJvUDZBJUKywnDiZrd+ubmTJm" +
       "FRwraxJGVs//P2Yq+ibFf8AIrTjKbMz34o0mJ53FJ+ziW94GcB1mrcHVcZnG" +
       "QAGQNU3/qNDqFhmuqGXws3hs0DTdq4VTQuumKcLwPZH//gVmPg0uQR0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pJ9+4s6P/dTvPPm1fOf+/wDUxkesqCgAAA==");
}
