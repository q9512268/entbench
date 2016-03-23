package org.sunflow.core.shader;
public class ShinyDiffuseShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color diff;
    private float refl;
    public ShinyDiffuseShader() { super();
                                  diff = org.sunflow.image.Color.GRAY;
                                  refl = 0.5F; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        diff =
          pl.
            getColor(
              "diffuse",
              diff);
        refl =
          pl.
            getFloat(
              "shiny",
              refl);
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
        org.sunflow.image.Color d =
          getDiffuse(
            state);
        org.sunflow.image.Color lr =
          state.
          diffuse(
            d);
        if (!state.
              includeSpecular(
                ))
            return lr;
        float cos =
          state.
          getCosND(
            );
        float dn =
          2 *
          cos;
        org.sunflow.math.Vector3 refDir =
          new org.sunflow.math.Vector3(
          );
        refDir.
          x =
          dn *
            state.
              getNormal(
                ).
              x +
            state.
              getRay(
                ).
              getDirection(
                ).
              x;
        refDir.
          y =
          dn *
            state.
              getNormal(
                ).
              y +
            state.
              getRay(
                ).
              getDirection(
                ).
              y;
        refDir.
          z =
          dn *
            state.
              getNormal(
                ).
              z +
            state.
              getRay(
                ).
              getDirection(
                ).
              z;
        org.sunflow.core.Ray refRay =
          new org.sunflow.core.Ray(
          state.
            getPoint(
              ),
          refDir);
        cos =
          1 -
            cos;
        float cos2 =
          cos *
          cos;
        float cos5 =
          cos2 *
          cos2 *
          cos;
        org.sunflow.image.Color ret =
          org.sunflow.image.Color.
          white(
            );
        org.sunflow.image.Color r =
          d.
          copy1(
            ).
          mul(
            refl);
        ret.
          sub(
            r);
        ret.
          mul(
            cos5);
        ret.
          add(
            r);
        return lr.
          add(
            ret.
              mul(
                state.
                  traceReflection(
                    refRay,
                    0)));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        org.sunflow.image.Color diffuse;
        state.
          faceforward(
            );
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
        float d =
          diffuse.
          getAverage(
            );
        float r =
          d *
          refl;
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              d) {
            power.
              mul(
                diffuse).
              mul(
                1.0F /
                  d);
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              d;
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
        else
            if (rnd <
                  d +
                  r) {
                float cos =
                  -org.sunflow.math.Vector3.
                  dot(
                    state.
                      getNormal(
                        ),
                    state.
                      getRay(
                        ).
                      getDirection(
                        ));
                power.
                  mul(
                    diffuse).
                  mul(
                    1.0F /
                      d);
                float dn =
                  2 *
                  cos;
                org.sunflow.math.Vector3 dir =
                  new org.sunflow.math.Vector3(
                  );
                dir.
                  x =
                  dn *
                    state.
                      getNormal(
                        ).
                      x +
                    state.
                      getRay(
                        ).
                      getDirection(
                        ).
                      x;
                dir.
                  y =
                  dn *
                    state.
                      getNormal(
                        ).
                      y +
                    state.
                      getRay(
                        ).
                      getDirection(
                        ).
                      y;
                dir.
                  z =
                  dn *
                    state.
                      getNormal(
                        ).
                      z +
                    state.
                      getRay(
                        ).
                      getDirection(
                        ).
                      z;
                state.
                  traceReflectionPhoton(
                    new org.sunflow.core.Ray(
                      state.
                        getPoint(
                          ),
                      dir),
                    power);
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "e7yLzfv/AziO7l6LGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "h+57LgitFGTwA//9AfidAdf/5FdOLB/Y5dt7sIOk/9KjrB+AjHQz8De9QL43" +
       "hu4/mZ4sF9RVuXv64S6s5W0lb57czVa7rhH9zNUi3nUg4l3XEXF8HRHzLlbo" +
       "rQuYDTXdubEh0qHlguiZHtRm8NP3fN3+wDc/uqu7TlvdKWDt7c/82g/23/nM" +
       "3olq9+VXFZwncXYVb8HenQWPuR8/eqNZCoz+P3386T/+3afftuPqnitrtx54" +
       "NfnoX/33l/ff/40vXqOEAGbmS/GpFSF+6IrsuDsDTOaWyn5jv5zfi9fW+U15" +
       "91UgNUTFG0o+peVJzuEi3L90lEuHxsSDNxbg15eWTuPQiC4WISn3oP1dmX+K" +
       "1+7/mVegy7uOiRE+eGN4xz+++8vvevnXgV5G0C1p7rNAgSdmpJL8JepXnnvP" +
       "Q7c/8413FJkOGBHz5Fv9N+VUtRtJnDdvyJvLh6I+mIvK+EmoaIQUxWSRnDT1" +
       "SFr6hDwsME/H/zGkje96aohGePvwR/CiLqy5zUbQJ9UWrKPdWpzaW36Y2cQK" +
       "1IgCY5BTCavPnMkAy/rByGqlrKejYVUV57pALyOH5dtLaTxjXAMzeY0ocXyH" +
       "YYzxeBDy/LTM9Acm7oTitCzLKMeFAs8EidVxeGoV4xVdaLmtqpg2mii+4pdS" +
       "onpiq9UgNZjWGo2y6DWc8djasmofo2aqhU6lKj7zq/2ROrG2sxofrdYq2V3Y" +
       "NNJz4Xm16khI1Sx7Dj5wSAaRdKLvlO0ywQddHq+Yc2oR4C5XicKA82xrlHJ+" +
       "IvmbzkwdbGexFQsyyc/6vGPp3mqGkxgmkipukcJihYnpbG4rbbxU3gg9lwu3" +
       "rDTUM6XP0Ejk1kmtxGT6ZNpKrRbu6kM3Ms1gmVT42Urws9kUAexESMAh2yng" +
       "pKkNeRHpSyOx31qtwuGMiiypnJDkwFLKFX3eLTFysnBdTAzcqI6CdFKREm81" +
       "7lUHzIisJs7AGQiRrokYt+EsdVmzZllgNKTZ1F0qYzsMF1pf2pYMIagEtu7V" +
       "l505t+JMFMUXgmikm1GHHGsT3NJJxEBnq1qynLjcUO6wTmyKi/7YrMk9tlrf" +
       "TBpurRnj5W0n4MJZaY6jpFVpr7dMe+EMFgxCMHW77EpDbBoP3E2Fzjie4TnX" +
       "GyFJLM5MVsArMtEK++a23BXC7YRF5DVbx+TVIiZbVXIl6lY3EZq8NOOkGVg1" +
       "bRiMl6xiTibGYlzGsIxie6mlrhG85LvmaJYshpM5Xlc9VMRwDBnblChELYqX" +
       "aiOy15HMReLby4XSmOrzMip14h4+7GRT0eUpZkyFkj2ZziTRmPicMqhPCKuH" +
       "dHmlRxrYloqnLJ5gczFgXWyu03Gmaom0Xrd8t8GtMWUg2chMUHQEWVPT2YIK" +
       "JlyLsXttDYvmtVqDMMoovDVJrN+udhZGfzmF4WSFaIhYmQ/Nfplcx9OQjCNR" +
       "H8s9o+QKZnOBNOgoTAml4/GmiwYJ7dTclPStLNaTEB/g5Jb0emxzMOzB83hZ" +
       "anpl2pMWusk5MVF3OVWdT4xOCdkOwwHXn62qdoRI9oocefGoqwoMrW8aAA7T" +
       "7Wy26ixVxw5EhxYYJeBoEE2bQ27Ltc2+7zuhP0aCsQongw01bnoZh+P8fG33" +
       "52ukQ2821aY4WFhua7qlBrZflpOVn5hcP+q5bUGlZtuWyKyWqBBz69oqSLvJ" +
       "XBWpiscxdjySbLlRRv1KavdHgbAlWunExOjVXFEiW0QGniRMzN7IbMyX3QW/" +
       "sNhM9sdxj95y87S1cVO6K5fdYdtVq43eAG/GZuYbmbhmvSVu1HCUz2wHw9mM" +
       "U2sbqYF50bYd96hmfwWHdDMU4IUiONNBw2VIZ0F17PlsNg/CoMl02xutbJaE" +
       "Tbhusti2HiWm7dSWxGxMhqTTl6lBnNmkhjH0BOvLHtru1SZCpyOjTaPtkchA" +
       "kDodY+VMm8pYndfHXX7jjYYBbTiJE43Q5Uie9Lj5nN3WlcEwRtFBAuKRjQ7h" +
       "YLM1gjYBlgavdD2DsLMBTfRr3YWa0sSootENlYHRZnU8ctc4MekPhjOu72Gj" +
       "wGP69dJ0GJh1OiuxbqMyMDreyO6t21oN6Ux0fF1bJP26OnMqwXQyFuQB5/XZ" +
       "ep2SEE9CSK3Z0+oOIa/hobq1uv4kHoo1dwSHKFGtqwuh3eCqBlJynDZWQ4dI" +
       "upDZRjVbZS3YC1KZnTlU6mQ6i7jzbl2cClg0DDoyLc+1hdMm1M5Wt5abUkPz" +
       "2vMW4hpCfxOt7VqkrTFt0U47GV5qRgmsdrclXcfSCAjQpQdlz6eyUS1gewqP" +
       "N0wRX1eQUUpPO9l41cY0u+qxRrXJle2As8fOoL+EZWe1rfsCPHRRQV91MWsS" +
       "D8aVZrTuJHoqos0WFSZslqDuCCMlVcpcTnGjYSKNGp5MjfnNvKdXUFaX0yo1" +
       "0ozVto1hacBtpt2V1Kug3TXLp1RLLqlxVRmkcaWfzQiiAWe1psaFJirbeKXV" +
       "qna76yaXzkuDMKtvPXieqqNZoK6JylYQ7WEzw9qoLEoRRXVVTRiGsFJdmVpk" +
       "KLO2vXU6PYGKySnBR56roEiH5xtwtYn665ZcY2ZNDPhRKQD+SfcMNOOMocqO" +
       "19W2uxRKKg4vqkR/paJaFvS6NcPolZt0ZgkNZbPIOkkDZJyMzmbuSvGIKpmS" +
       "KEMm4hpe9i3drK+a41TBSjCTNuCQKreaJdqSt6WQYKSObLiwkMpCaK0nMCwI" +
       "ne3SpfqSj7bhSrecjagM5J7WhrZb094wydyNqRujactbppNRtTarmrMaA2PB" +
       "YDWlyHjSZ9fGipUGdabD6YEoD+yJ49FKK0V9dsTF8+6y63WUIUlVytNtuG1i" +
       "w4q98WrdNoGgK7bNesbCizoJVu9wVkrRhMA2hpXSfFGdSNhM5M2x12F8Y1Be" +
       "jWJs3KZaeIfKTMclM5r1ZIzrbhixbgvoGCXZitUyox5LlZ05y3r2GBkEZZ4a" +
       "iVMJVadYLV6gekAoCl1nxYBpriOMJcKWGo2x2hix2+N46GkEskwNrcR3PBiH" +
       "MUNQ5otZpywrrV6aeetW3JhrDKgd0pFhNuIgTaa0uJimXVYgqHlzoG/7KOxH" +
       "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");
}
