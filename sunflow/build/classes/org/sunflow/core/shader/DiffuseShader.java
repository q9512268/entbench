package org.sunflow.core.shader;
public class DiffuseShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color diff;
    public DiffuseShader() { super();
                             diff = org.sunflow.image.Color.WHITE; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        diff =
          pl.
            getColor(
              "diffuse",
              diff);
        return true;
    }
    public org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
        return diff;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        return state.
          diffuse(
            getDiffuse(
              state));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        org.sunflow.image.Color diffuse;
        if (org.sunflow.math.Vector3.
              dot(
                state.
                  getNormal(
                    ),
                state.
                  getRay(
                    ).
                  getDirection(
                    )) >
              0.0) {
            state.
              getNormal(
                ).
              negate(
                );
            state.
              getGeoNormal(
                ).
              negate(
                );
        }
        diffuse =
          getDiffuse(
            state);
        state.
          storePhoton(
            state.
              getRay(
                ).
              getDirection(
                ),
            power,
            diffuse);
        float avg =
          diffuse.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              avg) {
            power.
              mul(
                diffuse).
              mul(
                1.0F /
                  avg);
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              avg;
            double v =
              state.
              getRandom(
                0,
                1,
                1);
            float s =
              (float)
                java.lang.Math.
                sqrt(
                  v);
            float s1 =
              (float)
                java.lang.Math.
                sqrt(
                  1.0 -
                    v);
            org.sunflow.math.Vector3 w =
              new org.sunflow.math.Vector3(
              (float)
                java.lang.Math.
                cos(
                  u) *
                s,
              (float)
                java.lang.Math.
                sin(
                  u) *
                s,
              s1);
            w =
              onb.
                transform(
                  w,
                  new org.sunflow.math.Vector3(
                    ));
            state.
              traceDiffusePhoton(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
                power);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06a8zkVnXeL5vdzeaxmwSSEPJmQ0mGfp73o6GAx/PwzHg8" +
       "nvGMPXYLG4/fb4/fY5rykCioqCmCQKkKUVWBoCg8VBWBhKChVQsIVIkKtbRS" +
       "AVWVSkuRyI/SqmlLrz3fezdLo6CO5Ovr63POPefcc849Pnee+RF0ve9BBdcx" +
       "N4rpBLtSEuzqZm032LiSvzvEayTv+ZKImrzvz8HYZeGhz174yfPvVS/uQGc4" +
       "6Hbetp2ADzTH9meS75iRJOLQhcPRrilZfgBdxHU+4uEw0EwY1/zgMRy68Qhq" +
       "AF3C91mAAQswYAHOWYCRQyiAdLNkhxaaYfB24K+hX4dO4dAZV8jYC6AHjxNx" +
       "eY+39siQuQSAwrnsmQZC5ciJBz1wIPtW5isE/kABfup33nzxj66DLnDQBc2m" +
       "MnYEwEQAJuGgmyzJWkmej4iiJHLQrbYkiZTkabyppTnfHHSbryk2H4SedKCk" +
       "bDB0JS+f81BzNwmZbF4oBI53IJ6sSaa4/3S9bPIKkPWOQ1m3EvaycSDgeQ0w" +
       "5sm8IO2jnDY0Wwyg+09iHMh4aQQAAOpZSwpU52Cq0zYPBqDbtmtn8rYCU4Gn" +
       "2QoAvd4JwSwBdPcLEs107fKCwSvS5QC66yQcuX0FoG7IFZGhBNDLT4LllMAq" +
       "3X1ilY6sz4+I1z35Fhuzd3KeRUkwM/7PAaT7TiDNJFnyJFuQtog3PYp/kL/j" +
       "S+/egSAA/PITwFuYz//ac2987X3Pfm0L88qrwExWuiQEl4WPrm751j3oI63r" +
       "MjbOuY6vZYt/TPLc/Mm9N48lLvC8Ow4oZi93918+O/sL9m2flH64A50fQGcE" +
       "xwwtYEe3Co7laqbk9SVb8vhAEgfQDZItovn7AXQW9HHNlrajE1n2pWAAnTbz" +
       "oTNO/gxUJAMSmYrOgr5my85+3+UDNe8nLgRBZ8EFvRZcN0HbX34PoMdh1bEk" +
       "mBd4W7MdmPScTP5sQW2RhwPJB30RvHUd2A9t2XRi2PcE2PGUg2fB8STYV3lR" +
       "8uCOJsuhL1H5025mae7/wxxJJufF+NQpsAT3nAwAJvAdzDEB7GXhqbDdfe7T" +
       "l7+xc+AQexoKoIfBdLt70+1m0+1up9s9Nh106lQ+y8uyabeLDJbIAM4OwuBN" +
       "j1BvGj7+7oeuA9blxqeBfjNQ+IWjMXoYHgZ5EBSAjULPfih+O/3W4g60czys" +
       "ZqyCofMZOpkFw4Ogd+mkO12N7oV3/eAnn/ngE86hYx2L03v+fiVm5q8PnVSq" +
       "5wiSCCLgIflHH+A/d/lLT1zagU6DIAACX8ADQwUx5b6Tcxzz28f2Y2Amy/VA" +
       "YNnxLN7MXu0HrvOB6jnx4Ui+2rfk/VuBjm/MDPkucF3Ys+z8nr293c3al22t" +
       "I1u0E1LkMfaXKfcj3/nLf67k6t4PxxeObHCUFDx2JARkxC7kzn7roQ3MPUkC" +
       "cH//IfL9H/jRu34lNwAA8aqrTXgpa1Hg+mAJgZrf+bX1337vux/99s6h0QRg" +
       "DwxXpiYkB0Jm49D5awgJZnv1IT8ghJjAxTKrubSwLUfUZI1fmVJmpf914eHS" +
       "5/71yYtbOzDByL4ZvfZnEzgcf0Ubets33vzv9+VkTgnZFnaos0OwbVy8/ZAy" +
       "4nn8JuMjeftf3fu7X+U/AiIsiGq+lkp5oIJyHUD5osG5/I/m7e6Jd6Wsud8/" +
       "avzH/etIqnFZeO+3f3wz/eMvP5dzezxXObrWY959bGteWfNAAsjfedLTMd5X" +
       "AVz1WeJXL5rPPg8ocoCiADZof+KBEJEcs4w96OvP/t1X/uyOx791HbTTg86b" +
       "Di/2+NzJoBuAdUu+CgJU4r7hjdvFjc+B5mIuKnSF8FujuCt/Og0YfOSF40sv" +
       "SzUOXfSu/5yYq3f8w39coYQ8slxlhz2Bz8HPfPhu9PU/zPEPXTzDvi+5MvKC" +
       "tOwQt/xJ6992Hjrz5zvQWQ66KOzlfDRvhpnjcCDP8fcTQZAXHnt/PGfZbtCP" +
       "HYSwe06GlyPTngwuhxEf9DPorH/+RDzJN8Y7wXXznqvdfDKenILyzhtylAfz" +
       "9lLW/MK++551PS0CG/qe//4U/E6B63+yKyOWDWy339vQvRzggYMkwAWb0Wng" +
       "b3KO/PIAuvPozqRZIM3K3NPxtmEta8tZ88btbLUXNKJfyppOcgoweH15t7Fb" +
       "zJ5HVxfiuqz7GhCI/Dw9BhiyZvNmrqoOYEk3hUv7rNMgXQZWdEk3G/ssX8wd" +
       "IFuv3W2OeYLXzv+ZV2DgtxwSwx2Qrr7nH9/7zd9+1feAFQ6h66PMQoDxHZmR" +
       "CLMM/jee+cC9Nz71/ffkcRWsCvl8+ievyajS15I4ayZZQ+6LencmKuWEniDh" +
       "vB+M81Aoibm013Q+0tMssGNEe+kp/MRt3zM+/INPbVPPk552Alh691O/+dPd" +
       "J5/aOZLwv+qKnPsozjbpz5m+eU/DHvTgtWbJMXr/9JknvviJJ9615eq24+lr" +
       "F3ydfeqv//ubux/6/tevkjGdNp2XsLDBzd/Bqv4A2f/hJRatJgs6MQpjOCj4" +
       "FMzWVjbiG+Gm15f5oiHzM0rxcdyvhsWEpWzKTYf1mlBe2bFbauCwJJW5krhE" +
       "GKoXuN0Z4i/4qp84jNnDAmbBj4bBuMvhxbJHqS1uvSIYVutxWpFWiYUUwKln" +
       "R5Zo9flhatiga5PNJhzIFRhutsS4RFvIaj1A10QRBVBDjBg5JT3eUC6pMKua" +
       "UmWpokaaUh9ueNW63G2yNFvXJjPT7xg2OySLmwWNW6Oeo603q97amI/ZxZBa" +
       "dZfCAGWToY7SxHKxSDmSiPlNuBkOx2pjumCn04Y/63VSTqWmxYY1altFYt12" +
       "qGkSdsNFRWOqg3kk9xd42ajT47CwjEmJa9mq2bMqK2Ksua4mwUhXD3nH6850" +
       "3zAbzZivz0RpsV72ek7Sp9xat7VxywyKr/oNLZ5OJSnVJVieDDm3qg2dhF+v" +
       "F0JdCrkya+nD9kLHFvVBLaQNnakMhILWdLX1uNaZ93rLtFMtoo7Yr9LoiqkJ" +
       "o1XQQkq9TXleIP0FFtqUWdJ69aETLptzbOZX+XJxXqtIfYxfu8k8kDtEHAoN" +
       "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");
}
