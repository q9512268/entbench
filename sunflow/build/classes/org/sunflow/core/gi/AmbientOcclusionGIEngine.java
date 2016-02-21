package org.sunflow.core.gi;
public class AmbientOcclusionGIEngine implements org.sunflow.core.GIEngine {
    private org.sunflow.image.Color bright;
    private org.sunflow.image.Color dark;
    private int samples;
    private float maxDist;
    public AmbientOcclusionGIEngine(org.sunflow.core.Options options) { super(
                                                                          );
                                                                        bright =
                                                                          options.
                                                                            getColor(
                                                                              "gi.ambocc.bright",
                                                                              org.sunflow.image.Color.
                                                                                WHITE);
                                                                        dark =
                                                                          options.
                                                                            getColor(
                                                                              "gi.ambocc.dark",
                                                                              org.sunflow.image.Color.
                                                                                BLACK);
                                                                        samples =
                                                                          options.
                                                                            getInt(
                                                                              "gi.ambocc.samples",
                                                                              32);
                                                                        maxDist =
                                                                          options.
                                                                            getFloat(
                                                                              "gi.ambocc.maxdist",
                                                                              0);
                                                                        maxDist =
                                                                          maxDist <=
                                                                            0
                                                                            ? java.lang.Float.
                                                                                POSITIVE_INFINITY
                                                                            : maxDist;
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        return org.sunflow.image.Color.
                 BLACK;
    }
    public boolean init(org.sunflow.core.Scene scene) {
        return true;
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        org.sunflow.math.OrthoNormalBasis onb =
          state.
          getBasis(
            );
        org.sunflow.math.Vector3 w =
          new org.sunflow.math.Vector3(
          );
        org.sunflow.image.Color result =
          org.sunflow.image.Color.
          black(
            );
        for (int i =
               0;
             i <
               samples;
             i++) {
            float xi =
              (float)
                state.
                getRandom(
                  i,
                  0,
                  samples);
            float xj =
              (float)
                state.
                getRandom(
                  i,
                  1,
                  samples);
            float phi =
              (float)
                (2 *
                   java.lang.Math.
                     PI *
                   xi);
            float cosPhi =
              (float)
                java.lang.Math.
                cos(
                  phi);
            float sinPhi =
              (float)
                java.lang.Math.
                sin(
                  phi);
            float sinTheta =
              (float)
                java.lang.Math.
                sqrt(
                  xj);
            float cosTheta =
              (float)
                java.lang.Math.
                sqrt(
                  1.0F -
                    xj);
            w.
              x =
              cosPhi *
                sinTheta;
            w.
              y =
              sinPhi *
                sinTheta;
            w.
              z =
              cosTheta;
            onb.
              transform(
                w);
            org.sunflow.core.Ray r =
              new org.sunflow.core.Ray(
              state.
                getPoint(
                  ),
              w);
            r.
              setMax(
                maxDist);
            result.
              add(
                org.sunflow.image.Color.
                  blend(
                    bright,
                    dark,
                    state.
                      traceShadow(
                        r)));
        }
        return result.
          mul(
            (float)
              java.lang.Math.
                PI /
              samples);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwcRxWfO39/xV+NnTiJkzhOJKfhrm1aIDiEOo6dXDjH" +
       "VpxEwim5zO3NnTfZ293sztlnF0MbCWIQjdKSpKG04Q9StUT5qKpWIEqjVFDa" +
       "qgWpH9AWRAsIiUCJaEAU1ADlvdnd2729O0cWEift7N7MezPva37vzZy7SipM" +
       "g3QylYf4lM7M0IDKR6hhskS/Qk1zF/TFpAfL6N/2XdmxIUgqx8iCcWoOSdRk" +
       "gzJTEuYYWSarJqeqxMwdjCWQY8RgJjMmKJc1dYwslM1IWldkSeZDWoIhwR5q" +
       "REkz5dyQ4xnOIvYEnCyLgiRhIUm4zz/cGyX1kqZPueSLPOT9nhGkTLtrmZw0" +
       "RQ/QCRrOcFkJR2WT92YNcrOuKVMpReMhluWhA8odtgm2R+8oMEHXE40fXD82" +
       "3iRM0EpVVeNCPXMnMzVlgiWipNHtHVBY2jxEvkjKoqTOQ8xJd9RZNAyLhmFR" +
       "R1uXCqRvYGom3a8JdbgzU6UuoUCcrMyfRKcGTdvTjAiZYYZqbusumEHbFTlt" +
       "LS0LVDxxc/j4g/uaniwjjWOkUVZHURwJhOCwyBgYlKXjzDD7EgmWGCPNKjh7" +
       "lBkyVeRp29MtppxSKc+A+x2zYGdGZ4ZY07UV+BF0MzIS14ycekkRUPa/iqRC" +
       "U6Brm6urpeEg9oOCtTIIZiQpxJ3NUn5QVhOcLPdz5HTs/iwQAGtVmvFxLbdU" +
       "uUqhg7RYIaJQNRUehdBTU0BaoUEAGpx0lJwUba1T6SBNsRhGpI9uxBoCqhph" +
       "CGThZKGfTMwEXurwecnjn6s7Nh69W92mBkkAZE4wSUH564Cp08e0kyWZwWAf" +
       "WIz1a6Mnaduzs0FCgHihj9ii+d4Xrt25rvPyixbNkiI0w/EDTOIx6Ux8watL" +
       "+3s2lKEY1bpmyuj8PM3FLhuxR3qzOiBMW25GHAw5g5d3/uRz95xl7wVJbYRU" +
       "SpqSSUMcNUtaWpcVZmxlKjMoZ4kIqWFqol+MR0gVfEdllVm9w8mkyXiElCui" +
       "q1IT/8FESZgCTVQL37Ka1JxvnfJx8Z3VCSFV8JAN8NQT6yfenKTC41qahalE" +
       "VVnVwiOGhvqjQ9UEDXNmwncCRnUtbGbUpKJNhk1DCmtGKvdf0gwWTsnhvnRc" +
       "BqAaliQlY4LWWyMDagqEDWHA6f+/pbKodetkIAAOWeqHAwV20jZNSTAjJh3P" +
       "bB64diH2shVquD1se3GyDlYN2auGcNVQSg6VWpUEAmKxm3B1y/Pgt4OAAADB" +
       "9T2jn9++f7arDEJOnywHoyNpV14q6ndhwsH2mPTX7b9dv23mU68HSRCQJA6p" +
       "yM0IKzwZAVOZoUksAYBUKjM46BgunQuKykAun5q8d8+XbhEyeCEeJ6wAdEL2" +
       "EQTm3BLd/q1dbN7GI1c+uHhyRnM3eV7OcFJdASdiR5ffpX7lY9LaFfTp2LMz" +
       "3UFSDoAEIMwpuAnwrdO/Rh6G9Dp4jLpUg8JJzUhTBYccEK3l44Y26faIWGsW" +
       "3zeBa+twU62Cp8XeZeKNo206tu1WbGKs+LQQeP/pUf2Rt372x/XC3E5qaPTk" +
       "9FHGez1whJO1COBpdkNvl8EY0P361Mg3Tlw9slfEHVCsKrZgN7b9AEPgQjDz" +
       "l1889Pa775x5I+jGKod8nIlDWZPNKYn9pHYOJWG1Na48AGcK7HOMmu7dKkSl" +
       "nJRpXGG4Of7VuPrWp/98tMmKAwV6nDBad+MJ3P7Fm8k9L+/7R6eYJiBhOnVt" +
       "5pJZGN3qztxnGHQK5cje+9qyb75AHwG0B4Q15WkmQDNg71cUahFgfwEoDOtC" +
       "LOHV2wVZWLTr0SKCmYixT2LTbXp3R/4G9NRFMenYG+837Hn/0jWhTn5h5Q2G" +
       "Iar3WvGHzeosTN/uR6Bt1BwHutsv77irSbl8HWYcgxklqCbMYQNAMJsXOjZ1" +
       "RdUvn/tR2/5Xy0hwkNQqGk0MUrELSQ2EPzPHAT+z+mfutLw/WQ1Nk1CVFCiP" +
       "Bl9e3JUDaZ0L409/v/2pjY+dfkdEnRVmSwR7OQJ4HlCKYtzd52df/8TPH7v/" +
       "5KSVzntKg5uPb9GHw0r88O/+WWBgAWtFSg0f/1j43MMd/ZveE/wuviD3qmxh" +
       "0gEEdnlvO5v+e7Cr8vkgqRojTZJd/O6hSgZ37RgUfKZTEUOBnDeeX7xZlUpv" +
       "Dj+X+rHNs6wf2dxkB99Ijd8NPjATFcJieBrsfd7gB7MAER8RwbJGtD3YrHOw" +
       "o0o3ZDggMR941M0xKQBO3JBT49zZde3eXSenocrEMNIMC0mx3YDNdmuNjSXD" +
       "sj9fsXZ4FtgyLCih2C5LMWyihRqU4ubgEWocxO8Rn5C75ynkInga7WUaSwi5" +
       "d04hS3GDb0wK51UAgrxqBM+uo5m4CTWFnIYkM2FX17eN7Jdmu0d+b221xUUY" +
       "LLqFj4fv2/PmgVdECqvGqmWXE16emqTPSHnyZ5Ml9kfwC8DzH3xQXOzAN8R9" +
       "v10qr8jVyrqOgDfHnvcpEJ5peffgw1fOWwr4N7iPmM0e/9pHoaPHrbxkHbhW" +
       "FZx5vDzWoctSBxsJpVs51yqCY/APF2eeeXzmiCVVS/7xYQBOx+d/8e9XQqd+" +
       "81KRGrVMtg/N6z2pCiqLfN9YCm35auMPj7WUDUJFFCHVGVU+lGGRRD4QVJmZ" +
       "uMdZ7kHOBQdbNXQMJ4G14ANfgN81zwDvcIadd5EAN+cM8FLcEOBpmt0C+UXw" +
       "7Ledgi/m+ZY5IqNGCyyJfzW/enwO9bKumGtzYopfJfEdu7y1kpvucnXG4oI6" +
       "wzlpYFAtK3V2FgF15vDx04nhR28N2pXHAQ5JW9M/prAJpngWK8OZ8nLrkLgt" +
       "cBNV7VduaY3ybLLw/IGzdJY4YawtvSH9C7xw+E8duzaN75/H4WK5T3f/lN8d" +
       "OvfS1jXSA0Fx4WHlxYKLknym3vxNUGswnjHU/LDvyvmzGd3XZQeuE8BFCvwi" +
       "oZArm0ux+upHX/G5rCAoRsdpQlZTeIHFxLL3z1GBnsDm65w0pxjfqmhxquwE" +
       "bsebI26I33ejHZxX3mFHn+iezSnaikOYXjttRTvnb6NSrHPbqK3QRhLkC7He" +
       "t+cwzneweYjj/Yl8Q7ioimuawqhaHDBcQ37rfzZks2OBLtsaXfM3ZClWnzWC" +
       "Qo4g/n1ABISY+sk5bPYUNuc5aYCAisA5qmgwXZi/DbJwzip10YKniUUFF7zW" +
       "paR04XRjdfvp3W+KQ3/u4rAeqpBkRlG8Ba/nu1I3WFIWCtVb5a+V0p7hpLXI" +
       "FRAnwZQsBP+BRXeJkyY/HcQRvrxkz3FS5yHD4sv68hL9GFI6EOHn87oT0k3i" +
       "8IQFf8gq+LMBD4oTT7wtvJGtcyzeywBEaXGz7iBqxrpbj0kXT2/fcfe1jz9q" +
       "XUZICp2exlnqoFCw7kVyqLyy5GzOXJXbeq4veKJmtZOVmi2B3fBd4omsPthM" +
       "Orq6w3dSN7tzB/a3z2y89NPZytegLNpLAhS8tbfwaJTVM5Dk9kYLCyLIWOIK" +
       "obfnoalN65J/+ZU4exKrgFpamj4m1Xx4dHqlGQgFSU2EVEDCZVlxZtsype5k" +
       "0oSRV11VxrWMmruAX4AxSfHGXVjFNmZDrhcvsjjpKiwzCy/34FA+yYzNOLvI" +
       "Ur4cltF176iwqmqhGFoZ4iwWHdJ1p74WovTputiAbwkc+y/cBJ+5MhsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fPh/AF8jbW1AJgAA");
}
