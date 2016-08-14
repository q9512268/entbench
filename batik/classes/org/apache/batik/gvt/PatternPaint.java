package org.apache.batik.gvt;
public class PatternPaint implements java.awt.Paint {
    private org.apache.batik.gvt.GraphicsNode node;
    private java.awt.geom.Rectangle2D patternRegion;
    private java.awt.geom.AffineTransform patternTransform;
    private org.apache.batik.ext.awt.image.renderable.Filter tile;
    private boolean overflow;
    private org.apache.batik.gvt.PatternPaintContext lastContext;
    public PatternPaint(org.apache.batik.gvt.GraphicsNode node, java.awt.geom.Rectangle2D patternRegion,
                        boolean overflow,
                        java.awt.geom.AffineTransform patternTransform) {
        super(
          );
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (patternRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
        this.
          patternRegion =
          patternRegion;
        this.
          overflow =
          overflow;
        this.
          patternTransform =
          patternTransform;
        org.apache.batik.gvt.CompositeGraphicsNode comp =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        comp.
          getChildren(
            ).
          add(
            node);
        org.apache.batik.ext.awt.image.renderable.Filter gnr =
          comp.
          getGraphicsNodeRable(
            true);
        java.awt.geom.Rectangle2D padBounds =
          (java.awt.geom.Rectangle2D)
            patternRegion.
            clone(
              );
        if (overflow) {
            java.awt.geom.Rectangle2D nodeBounds =
              comp.
              getBounds(
                );
            padBounds.
              add(
                nodeBounds);
        }
        tile =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            gnr,
            padBounds,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
    }
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() { return node;
    }
    public java.awt.geom.Rectangle2D getPatternRect() { return (java.awt.geom.Rectangle2D)
                                                                 patternRegion.
                                                                 clone(
                                                                   );
    }
    public java.awt.geom.AffineTransform getPatternTransform() {
        return patternTransform;
    }
    public boolean getOverflow() { return overflow; }
    public java.awt.PaintContext createContext(java.awt.image.ColorModel cm,
                                               java.awt.Rectangle deviceBounds,
                                               java.awt.geom.Rectangle2D userBounds,
                                               java.awt.geom.AffineTransform xform,
                                               java.awt.RenderingHints hints) {
        if (patternTransform !=
              null) {
            xform =
              new java.awt.geom.AffineTransform(
                xform);
            xform.
              concatenate(
                patternTransform);
        }
        if (lastContext !=
              null &&
              lastContext.
              getColorModel(
                ).
              equals(
                cm)) {
            double[] p =
              new double[6];
            double[] q =
              new double[6];
            xform.
              getMatrix(
                p);
            lastContext.
              getUsr2Dev(
                ).
              getMatrix(
                q);
            if (p[0] ==
                  q[0] &&
                  p[1] ==
                  q[1] &&
                  p[2] ==
                  q[2] &&
                  p[3] ==
                  q[3]) {
                if (p[4] ==
                      q[4] &&
                      p[5] ==
                      q[5])
                    return lastContext;
                else
                    return new org.apache.batik.gvt.PatternPaint.PatternPaintContextWrapper(
                      lastContext,
                      (int)
                        (q[4] -
                           p[4] +
                           0.5),
                      (int)
                        (q[5] -
                           p[5] +
                           0.5));
            }
        }
        lastContext =
          new org.apache.batik.gvt.PatternPaintContext(
            cm,
            xform,
            hints,
            tile,
            patternRegion,
            overflow);
        return lastContext;
    }
    public int getTransparency() { return TRANSLUCENT;
    }
    static class PatternPaintContextWrapper implements java.awt.PaintContext {
        org.apache.batik.gvt.PatternPaintContext
          ppc;
        int xShift;
        int yShift;
        PatternPaintContextWrapper(org.apache.batik.gvt.PatternPaintContext ppc,
                                   int xShift,
                                   int yShift) {
            super(
              );
            this.
              ppc =
              ppc;
            this.
              xShift =
              xShift;
            this.
              yShift =
              yShift;
        }
        public void dispose() {  }
        public java.awt.image.ColorModel getColorModel() {
            return ppc.
              getColorModel(
                );
        }
        public java.awt.image.Raster getRaster(int x,
                                               int y,
                                               int width,
                                               int height) {
            return ppc.
              getRaster(
                x +
                  xShift,
                y +
                  yShift,
                width,
                height);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYf3BURx3fu/wgCfkNCRBIgHCA/PBO2qKDQQTSpAQvkCGA" +
           "Y2g59t7t3T3y7r3He3vJJTWVMirojIiYUnTa+IcwVIYWdNqpWtvB6WhLwTot" +
           "YKlOqaPOiFbGMo7VEbV+d/fdvR+Xuwwzkpm3ebf73e9+f3+++87cRGWmgdqI" +
           "SoN0RCdmsEulfdgwSaxTwaa5HeYi0uMl+G+7b2xZ40flA6g2ic1eCZukWyZK" +
           "zBxArbJqUqxKxNxCSIzt6DOISYwhTGVNHUBNstmT0hVZkmmvFiOMYCc2wqgB" +
           "U2rI0TQlPRYDilrDIEmISxLa4F3uCKNqSdNHbPLZDvJOxwqjTNlnmRTVh/fi" +
           "IRxKU1kJhWWTdmQMtELXlJGEotEgydDgXmW1ZYLN4dV5Jmg/V/fB7SPJem6C" +
           "GVhVNcrVM7cRU1OGSCyM6uzZLoWkzH3oEVQSRtMdxBQFwtlDQ3BoCA7NamtT" +
           "gfQ1RE2nOjWuDs1yKtclJhBFC91MdGzglMWmj8sMHCqopTvfDNouyGkrtMxT" +
           "8bEVofHHd9f/oATVDaA6We1n4kggBIVDBsCgJBUlhrkhFiOxAdSggrP7iSFj" +
           "RR61PN1oygkV0zS4P2sWNpnWicHPtG0FfgTdjLRENSOnXpwHlPWrLK7gBOja" +
           "bOsqNOxm86BglQyCGXEMcWdtKR2U1RhF8707cjoGPgMEsHVaitCkljuqVMUw" +
           "gRpFiChYTYT6IfTUBJCWaRCABkUtBZkyW+tYGsQJEmER6aHrE0tAVckNwbZQ" +
           "1OQl45zASy0eLzn8c3PL2sMPq5tUP/KBzDEiKUz+6bCpzbNpG4kTg0AeiI3V" +
           "y8PHcPOLh/wIAXGTh1jQPP/5W+tXtp1/VdDMnYRma3QvkWhEOhGtfWNe57I1" +
           "JUyMCl0zZeZ8l+Y8y/qslY6MDhWmOceRLQazi+e3/fxz+0+T9/yoqgeVS5qS" +
           "TkEcNUhaSpcVYjxAVGJgSmI9qJKosU6+3oOmwXtYVomY3RqPm4T2oFKFT5Vr" +
           "/DeYKA4smImq4F1W41r2Xcc0yd8zOkJoOjyoE54LSPzx/xRtDyW1FAlhCauy" +
           "qoX6DI3pb4ag4kTBtslQFKJ+MGRqaQNCMKQZiRCGOEgSayExRMH5FKJH7cMQ" +
           "q0EWXfpd4pth+swY9vnA1PO8ia5AjmzSlBgxItJ4emPXrWciF0UQscC3LEHR" +
           "WjgqKI4K8qOCcFTQeVTA+cMqDJ81sA5hjXw+fvhMJo3wMXhoEHIdim31sv6H" +
           "Nu851F4CwaUPl4J5GWm7C3Q67YKQreIR6WxjzejC66te9qPSMGrEEk1jhWHI" +
           "BiMB1UkatBK4OgpwZKPCAgcqMDgzNInEoCgVQgeLS4U2RAw2T9FMB4csZrHs" +
           "DBVGjEnlR+ePDz+68wsf8yO/GwjYkWVQw9j2Pla+c2U64C0Ak/GtO3jjg7PH" +
           "xjS7FLiQJQuIeTuZDu3e8PCaJyItX4Cfi7w4FuBmr4RSTcHhrAq2ec9wVZqO" +
           "bNVmulSAwnHNSGGFLWVtXEWThjZsz/C4beDvMyEsKljqtcNzycpF/p+tNuts" +
           "nCXinMWZRwuOCp/q15+89vqf7uXmzgJInQP5+wntcBQtxqyRl6cGO2y3G4QA" +
           "3TvH+7752M2Du3jMAsWiyQ4MsLETihW4EMz8pVf3vf3u9RNX/Lk4Rxm3bhVF" +
           "dINDlthiQK1ToC6wYAnsUCEs5biMowph+fTvusWrnvvL4XrhfgVmstGzcmoG" +
           "9vycjWj/xd3/aONsfBLDWttUNpko4DNszhsMA48wOTKPvtn6rVfwkwAFUH5N" +
           "eZTwilrCVS/hms+m6CNT1hWrlLhrAsu7/nTUhPyVU+CuIQvN7unbIx0K9P1B" +
           "INWcSTYIuqanQl/b+dbeSzwYKliFYPNMphpH/kMlcURivfDWh/Dng+e/7GFe" +
           "YhMCFRo7LWhakMMmXc+A5MuKNJNuBUJjje8OPnHjaaGAF7s9xOTQ+Fc/DB4e" +
           "F64WDc6ivB7DuUc0OUIdNnySSbew2Cl8R/cfz4698NTYQSFVoxuuu6AbffpX" +
           "/7kUPP7bC5MgR4lsNan3stKeK/Az3b4RCt3/lbqfHGks6Yba0oMq0qq8L016" +
           "Yk6O0J+Z6ajDWXbjxCecqjHHUORbDj5gE2v4eB+XJZSTCFmpyH73sGGx6ayz" +
           "bn85+vCIdOTK+zU733/pFtfZ3cg7y0ov1oXBG9iwhBl8lhcHN2EzCXT3nd/y" +
           "YL1y/jZwHACOEkC8udUAaM64ipBFXTbt1z99uXnPGyXI342qFA3HujGv56gS" +
           "Cikxk4DqGf3T60VBGWbVpZ6rivKUz5tgST1/8nLRldIpT/DRH856du2pieu8" +
           "oOmCx1wru6HRcAE4vw7aGHL68ieunvrGsWERT0Wyw7Nv9r+2KtEDv/tnnsk5" +
           "ZE6SMJ79A6EzT7R0rnuP77exi+0OZPKbI8B/e+89p1N/97eX/8yPpg2gesm6" +
           "fu3ESpohwgBcOczsnQyuaK519/VB9ModOWye581Yx7Fe1HQmQil1Bb0HKBfA" +
           "85oFJq95gdKH+MsuvmUpG1bkQ1Gh3ZDSui6x19UCcNm4mQ0PiiDoLRhzO9yn" +
           "zIXnonXKxQIyRovKWGg3ReWZ/qQc59i3xiOmdBfElNkA5bd8pOCxe4scK5aW" +
           "8nE5Gz4qCiUwNPlN224VeIJWIc+VxNkq2Inoy8JsE89lPMyg1cZUVotaC90p" +
           "eeE/cWB8Irb15Cq/VSE3gEDWVd+d7q2udO/lV2g7d96pPfr7HwUSG++kVWdz" +
           "bVM04+z3fEjc5YUriFeUVw78uWX7uuSeO+i653tM5GX5vd4zFx5YIh318+8F" +
           "IqnzvjO4N3W4U7nKIDRtqG4UW5RzeR3zcCs8ly2XX/ZGoR1qk8aQno4qzhji" +
           "YV1bhGERkPxikbUvs2GMomkx2YQ+WvTxa61Gg/1bT1HpkCbH7Kx4ZKpkLI5T" +
           "bKJf5/MjOfVa2NpSeK5a6l0tYi827M+3TKGtRbQfL7J2jA1fp6gmQSD7FM1g" +
           "4a9k03NOLj3lFE6QoIeCG+rIXTBUM1ubD881S9trd26oQls9xijlgpTmCqNj" +
           "4Id8t4jxTrJhgqJKMN42bFKr+rjqmjCcY5Ub7Tv/D6NlKGop/HEjK8rCKW8y" +
           "UCZn531nFd8GpWcm6ipmTex4i1fI3Pe7aqh18bSiOFHf8V6uGyQucxNVix5A" +
           "dLrfp2jmZNIAcsPIBT4nKJ+lqN5LSVEZ/++ke56iKpsOKop4cZL8GLgDCXt9" +
           "Qc8apZ77h7U9QdH2ZHwO4LBMzj3VNJWncluc121W7vkX7mxpTotv3BHp7MTm" +
           "LQ/f+vhJcd2XFDw6yrhMhwuE+PKQK+8LC3LL8irftOx27bnKxVkUbBAC27kx" +
           "1xGs/VByddY/t3guxWYgdzd++8Tal35xqPxN6EN3IR+maMau/AYxo6cBV3eF" +
           "8y9KAIX8tt6x7Nsj61bG//ob3oIjcbGaV5g+Il059dDlo7NPwK1+eg8qA4An" +
           "Gd653j+ibiPSkDGAamSzKwMiAhcZK65bWC0LS8y+fXO7WOasyc2yj0UUtedf" +
           "QPM/scF1ZZgYG7W0GuOAB1Bsz7g+vWcRMs1yzbXBnnFc0rsE2DBvQDxGwr26" +
           "nr2fVy3WeUJ3e2+jfJLvfp2/suGX/wPIbfXm/RoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVae+zrVn33vbf39vbS9t4W+qDQJxdYMfs5jp3YUQsjcRLH" +
           "Sew4iWMn2cbFbzvxK34kTlg3QGJ0Y2IVK4xt0GkSaIAKZdPQXmLqxDYeRZMY" +
           "sLFJAzRNGhtDon+MobGNHTu/932tAiL55Pic7znfx/l+P+flp78NnY5CCA58" +
           "Z206fryjp/HOzCntxOtAj3ba3RIvh5GuUY4cRQIou6Q+9Inz3/3+E9aFk9CZ" +
           "KfRi2fP8WI5t34sGeuQ7S13rQucPShuO7kYxdKE7k5cyksS2g3TtKH6kC73o" +
           "UNMYutjdEwEBIiBABCQXAakeUIFGt+he4lJZC9mLowX089CJLnQmUDPxYujB" +
           "o50Ecii7u93wuQagh7PZuwiUyhunIfTAvu5bnS9T+D0w8uSvv/HC75+Czk+h" +
           "87Y3zMRRgRAxYDKFbnZ1V9HDqKppujaFbvN0XRvqoS079iaXewrdHtmmJ8dJ" +
           "qO8bKStMAj3MeR5Y7mY10y1M1NgP99UzbN3R9t5OG45sAl3vPNB1q2EzKwcK" +
           "nrOBYKEhq/pekxvmtqfF0P3HW+zreLEDCEDTG109tvx9Vjd4MiiAbt+OnSN7" +
           "JjKMQ9szAelpPwFcYuieq3aa2TqQ1bls6pdi6O7jdPy2ClDdlBsiaxJDdxwn" +
           "y3sCo3TPsVE6ND7f5h5915u9lncyl1nTVSeT/yxodN+xRgPd0EPdU/Vtw5tf" +
           "032vfOenHj8JQYD4jmPEW5o//Lnn3/Da+5797JbmZVeg6SkzXY0vqR9Ubv3i" +
           "y6mHK6cyMc4GfmRng39E89z9+d2aR9IARN6d+z1mlTt7lc8O/mrylo/q3zoJ" +
           "nWOgM6rvJC7wo9tU3w1sRw9p3dNDOdY1BrpJ9zQqr2egG0G+a3v6trRnGJEe" +
           "M9ANTl50xs/fgYkM0EVmohtB3vYMfy8fyLGV59MAgqAXgQeiwPM5aPvL/2NI" +
           "QCzf1RFZlT3b8xE+9DP9I0T3YgXY1kIU4PVzJPKTELgg4ocmIgM/sPTdCnMZ" +
           "g8GPgfd4vAx8dSfzruDH1G+a6XNhdeIEMPXLjwe6A2Kk5TuaHl5Sn0xqjec/" +
           "fum5k/uOv2uJGHoUsNrZstrJWe0AVjuHWV08/LILDFIoB8CtoRMncuYvyaTZ" +
           "jjEYoTmIdYCCNz88/Nn2mx5/6BRwrmB1AzBvRopcHYypA3RgcgxUgYtCz75v" +
           "9VbxFwonoZNHUTXTABSdy5rzGRbuY97F49F0pX7Pv+Ob333mvY/5B3F1BKZ3" +
           "w/3yllm4PnTc1qGv6hoAwIPuX/OA/MlLn3rs4knoBoABAPdiYL0MUu47zuNI" +
           "2D6yB4GZLqeBwoYfurKTVe3h1rnYCv3VQUnuBLfm+duAjc9mfvwQeL6w69j5" +
           "f1b74iBLX7J1mmzQjmmRQ+zrhsEHvvrX/4rl5t5D4/OH5rehHj9yCAGyzs7n" +
           "sX7bgQ8Ioa4Dun98H/9r7/n2O346dwBA8YorMbyYpRSIfDCEwMxv/+zi77/+" +
           "tQ9++eS+00DpUd3OXkM3wORVB2IA4HBAkGXOcnHkub5mG7asOHrmnP99/pXo" +
           "J//9XRe2w++Akj3vee31Ozgof2kNestzb/zP+/JuTqjZxHVgqgOyLRq++KDn" +
           "ahjK60yO9K1/c+9vfEb+AMBVgGWRvdFzeDqVq34q1/yOGPqJ6wbpblwCLg9f" +
           "Y7UT2i4YteXuDIE8dvvX5+//5se26H98OjlGrD/+5C//YOddT548NOe+4rJp" +
           "73Cb7bybu9st2yH8AfidAM//Zk82dFnBFndvp3bB/4F99A+CFKjz4LXEylk0" +
           "/+WZx/70w4+9Y6vG7UennAZYUX3sb//nCzvv+8bnroB+p4Dpshc8F3MnF/Ph" +
           "PP3JTK5dB8zeH82S+6PD6HLUvoeWcpfUJ778nVvE7/zZ8znLo2vBw8HEysHW" +
           "QLdmyQOZvncdh9KWHFmADn+W+5kLzrPfBz1OQY8qmCWiXgjQPT0ServUp2/8" +
           "hz//9J1v+uIp6GQTOuf4staUcxSDbgLwoUcWmBjS4KfesA2jVRZTF3JVocuU" +
           "34bf3fnbmWv7VzNbyh1g4N3/1XOUt/3T9y4zQg7dV3C5Y+2nyNPvv4d6/bfy" +
           "9gcYmrW+L718xgPL3oO2xY+6/3HyoTN/eRK6cQpdUHfX1KLsJBkyTcE6Mtpb" +
           "aIN195H6o2vC7QLokf054uXHff4Q2+PofeBrIJ9RZ/lzVwLsB8Dz+V1Q+/xx" +
           "wD4B5Zl23uTBPL2YJa8+5J4l4MtBoGZZZAvwWfq6LOlsR/ANVx3txlFZXgae" +
           "53Zlee4qsvSvI8uZdGjZxja0jokz+DGIM76eOOurijO5rjh5H+mJEzF0urhD" +
           "7BSy90tXZngKsAoSxbHBTHAmyndSoJVhe7KzJ8pdM0e9uAd2IthZgYC4OHOI" +
           "Pai/kMdy5no72+3IMXlL/295QazeetBZ1wc7m3f+8xNf+NVXfB0EVBs6vcyc" +
           "HcTRIY5ckm32fvHp99z7oie/8c58DgarNvGXfg/7Xtbr/CpaZ9nc9bQs0fdU" +
           "vSdTdZivaLtyFLP5/Klr+9qih/QhYjAL+z+EtvGtj7bwiKnu/brixMBqo0GK" +
           "GQmyMiljzlGDGmO2qCrC13rFRafe7wvDoNpfzim6OimapUpMxJiArYkQa+nY" +
           "st0WJJG1wUqdsScjT5BhRl2JzETSuEUgxctaWbK6K8GPJx2nt5D5nt1UaNYn" +
           "xIYiwhpiaMsBPE5Wq808cDFdMQhMr8AGBsMwSagDWnJNbcEMfa4woDQ3aiSO" +
           "oZmroZwKK1kutfSJXUhYB6ZhQimmU7xgONWyWbRVVKemyVxaTzubWloNlfZi" +
           "tEg7KZdSQ2YTl+s9ZjhZWQItcq1RjYtiVyhY4nTuusum3WMnlFpcLczaqBgy" +
           "BaHv8INJ3XbCOtNwmWHalfEmllAdbjHUuJbCd6f1ZbuXrhYzgXM8dyCIFmLY" +
           "zCDtjNB525IkQXP7bNzojp023fDjhrnW6ubYldDppMvhmlhquyYiIkaNGPJt" +
           "3S1TtGiJnBqKLDDBCO3RQ2rNlpPNtOtL800L8xtifziIWS2t9Zur2Kn3sZpP" +
           "VQlOdmPBNProoFH0ejMpqUfouhOrTtuqNakKymr0xnRYyZ2REduiFn4gLI06" +
           "5ydreh7GbCqQSkP0jVZLqxiIXxXEulwtSzrq4XPTrDFivRZRZrs2cqxwbgE7" +
           "pVVtaJohT9jD5mwwKKM8h/prcy4WNkOcL0YSF3iSrbb4mC40DVPQZt1Bgxv2" +
           "vHGwajm8FHY7hFnrzWSlFy24XuqS5Zrp9NcUPW6wqqTFnUFxhA6sJkkUCHXm" +
           "07zJNqKWKNsxNXdmyUJkRytzEDRtypoIE6HMGMKo1qYkeUBVa/NRXJvO1xIc" +
           "T+io3264jUFZboWNQlwV1Tm3UqZ9tNd38NKmOlwX9O7GI1WM7xYjll+U4hGP" +
           "dGqbesPujDZwWaGCjcIFND4XzEJVtxlMXJN8S+V7XQtZMdUxLVjorM/zSAnw" +
           "G8cBiohanfUmA1fGQOxIVqNn0bEhcXqJYND2aM1STmEz1aekA0/INbKInEmZ" +
           "rVuS21P1Qbcvb2xYxxAj3cAFWKgga39h6uKwtBgK84bKjSx5GKjiZJZWRbpt" +
           "Dl2msmh3/GhUhjG/567G8UT03Qk2WPAuLhT9ZqcplMQQqeuTThWPXMZd4E1U" +
           "wtGwOFbVwlojN7152+/N1n6jhHeH/CZF0kFcX0tos+pYlJysF/64XGewQMFl" +
           "E5ihFkdOv9lpwyw9WMh9jmI7/ak9oOhewxzK60Y6YFslUN8iVLa/KDSksRFo" +
           "eBBbcLSaVJZeFeV7pC2XqjN3M3RqZsrEbVx3+XEoqXazMOpHKoV1G62BNDMX" +
           "HQbvkIsepTaFvi4KVVhlF/U2iUbVkjUbr2BjabFtH1uxY8tvtBjNdjE0WpZb" +
           "XEKW0CZOreQR7+DtEoATgsL6ZWLS6YN96KAspbONPqPK5VivLPghS4eNxhyd" +
           "WVKLqdlsDR3N5bjWwXtmsJp2eKpqqgu2bm44xmv4lCn2Tb07xEfFQXVVFCpN" +
           "toar0TRsRfWaSM8anjOAdb4O3IdcRQa57iH0ajaZS2J/VZkVeUeG1eKojFOF" +
           "6hyh4x42m5kE30pnQ6LZtfvtfsLoQjKtJ5hO8pTcXjPxGKcMm1jhzaTmhvhg" +
           "KKgtK6wuirpaWYnTRU/hRDdxhtWV1+KGNN3sSmI8bkiCNZtGG4TCFb2+ZNeN" +
           "qOPMFrHKbdZq0EQCOOaSOPKose2x0nSwSnpUgCzQEkxWlguDSMbuxmwzXp8v" +
           "wSsvVmv9OF2sB05ZpXvFNUbj/SomLFswQZSKbBGIO2OrkWSv+zgbdRuCbUl4" +
           "g92QgWhgSwNLKgNujHTn+CB1McUSmxrD1Z3YsvsdVPCp8mpS9aIR1YhKis36" +
           "q8CCDWGZRFLoLZddfBxahim6UUxvVNenK8u1OpNmSKphiNzjIqPWrUtxPOKC" +
           "uY/XuWhjRWwVJ1c9ocMvY68cisZqvqo2R60Sp0+FFcB0ShwilhvBAHU5AbWk" +
           "0OkCk0YJgXjCyOLX4gimEqa/5IjEU5i00KnwaI3hJHUoTJhkIXt9B1FgTdGH" +
           "mxWY4uzmhOfYwApayJx11NHABggrWUjdM2EdIeimPrFYqjnwia5kyXOWdccq" +
           "XC2xSYdrc0lt1J7NdLLHe62ZLNPVJhFV0p7Qh5sqUq/herOMS3W1bC9rRD0Z" +
           "qYXeiNE4bz0cKvqqSDnkAFGNDV6ukJww6Q+bop8mSVKuKoYRjBFiPuJ5QqFK" +
           "rDnAnYiTPSyKO3oHqW4wBR9QMYY4ysJo0fOoPFHkgs8uCosF2S2g5cm83Cu0" +
           "4WlZntWlsTJLKV1dzFqtUW+g1Gcls1Fc4noNHrenQ4FqusG6RWARTadleb1R" +
           "PLIELylGA4MAb0YEhiFBMzammGoS64K/RP1xja7YK6vmkI6ltrhiY0ONBczT" +
           "kPWki66R2XTVqlK9xpwiE21Uldkybge15lhQYnRTqSRjj6fXYwbDi4tmFWsl" +
           "M3pZKptDyp6nc7y+oA1MKBfEGi0pYjAth/YSIHopNocCipBedwD2UoGA1Act" +
           "slTWkmJg6wkJIJRK0VWYlFsDtdrAlytCplvdMgkqvWVIR1JjIBSk9YrglpUQ" +
           "LnbiRn2JxJ4XzUvTRnnItolKtdzYCMSgEHoJTxB6asOF3pTvKAxZQ3QQWgHK" +
           "IRVCHyPkmg/MoqlHbtlIsMYw8K2VWVN76iby+utE7pTQCiLWKmBl2JPWeolE" +
           "JynR1NFW3+3bDlpTCq1OzaiSJb/ZXlRKptZpwWyULN1RQKPKvI/SFjatDxO7" +
           "nKKVEaVyLu72C7xt1/3uwNr0Kmtvw4w93xt30j6zHvjLjkSb2ECXpsiir5Yq" +
           "NpbaPVerGQ2Hm1dLikYGPSrV8UjtlGSJ9BoleoMvKHu04niHKxZxUWfaEqPC" +
           "YsrNF0XG89dkO2qQFYdn1yaqTkci2ONSlUKg6w1ElWokEypoiVog4rCBmY26" +
           "JGqwRiyKidZDHLFoElqlHPBGSLRWoyENw3NR0jaKyBZweIMZjZlamoxCu6mP" +
           "xBVBJtKYSJKh3oPtcgmL2RI9Li01fNNMSxPGwlASJpvMwtssZz2cwyR8RHgd" +
           "pj6IFzQ+kkqDjT7ANioVkc66OB4jU9ofoIs5Kfc9H19srJk9EVHFohuDOZ/a" +
           "c2W0jIpgOevO0+KkD0tLIZXLKG0iqCKgrWBOKS2ik+LTTjDvMiVB6bSNEsLO" +
           "eoYoF7lgqAMDlp1CPLHJIsHCmNCh44HSN7pEuzirokZQNt3+sE40WdTE5cq8" +
           "gHG97gxzmo1y32d0ioZDZizURiyaKHWSRIeVONSKZb/vANywZ44ZCC614GY4" +
           "o5ExPkuFsG2ZYKHAcnhRaXZCOJwt3BmlTkojhRCWSL3MOR3aD5BWY9YhQ6oj" +
           "kesRNfVKGOo1NZIOJNUt24Er6CluowaD8TohLyyUVIZ2r9kySLGc0Ot+oqac" +
           "aKelqtYNjaA4c6ccU1UjnqkJuAeWDM6CK3WHYmOKgLHUS2W7E0S9jh/g6rRL" +
           "0l2zTo3jSl8l5WBKEBYxqvS1VnHaWvXwbo3dzDCRa0ue6iQqWkQlYjkfE24a" +
           "gC3GEqu1AoIV3G4fMeCl1Va14rhZX5XXocVaq6QB851+Bya7YGXRJe3QiHtp" +
           "kVC8TirOR0qtShWJeYqmdATCba1pEyTGzCSVJqa20cB+RJAdrJQu+JQrNziM" +
           "GcCuzMoJUp2kflmtiZjeJNeVTpUZk3FcTgkumpVRhUYQX8F8ZqYqtCyWTJhx" +
           "CqWKVnd8guNXHRTWTXJRxaserQF3ncG2YvPDeZ2uyu5w01mxdtVSp51ySZGo" +
           "QndIrmFj3COknhyt1eJ6VhiNYl0z+jyLRGoTnU7NCU1IBTrpVWtoLdoQJryU" +
           "1AEL9gEbZVzzvKZaCKNGsV5b9uspvQqLZS8sGuIak/RRG9OL8Mxod5dg0JAo" +
           "ocfIimcUY+wiAx9sFl+XbzZXL2x7e1u+k9+/ZQS72qzihexg0yszPJHzOjj2" +
           "zo8yzkHH7qoOH3sfnNCd2DtHuCPf1cur7Jj44Hw4O2G892qXjflp6gff9uRT" +
           "Wu9D6Mnd0xMyhs7s3gEfcDkFunnN1c8B2fyi9eAw7jNv+7d7hNdbb3oBdzj3" +
           "HxPyeJcfYZ/+HP0q9d0noVP7R3OXXQEfbfTI0QO5c6EeJ6EnHDmWu3ff6Ocz" +
           "G98Lni/tGv1Lx8+eDgb6yiOobh3lGmfKT1yj7t1Z8s4YulGzo8CP9CuemCx9" +
           "WztwtV+53mHJYR55weP76t6TFb4aPF/ZVfcrP3p1f/sadb+TJb8ZQ7eYOvBV" +
           "xw/BmkB39pz5pfvObLuyqe8co8i1/60fQvs7s8L7wfPVXe2/+qPR/oac4Ib9" +
           "c8dDSU7/sWtY5Jks+XAM3QQsMpCjeDcAj4T21hqHanNLfOSFWCKNoXuufsG7" +
           "x/LB615AAUS4+7JvTbbfR6gff+r82bueGv1dfhm6/w3DTV3orJE4zuFD8kP5" +
           "M0GoG3Zuipu2R+ZB/vcnMfSSK0kTQ6dAmgv8x1vKT8XQheOUMXQ6/z9M92wM" +
           "nTugA3i3zRwm+TToHZBk2b8IrnBUu70lSE8cwshdJ8tH5Pbrjch+k8O3pBmu" +
           "5l/57GFgsv3O55L6zFNt7s3Plz+0vaVVHXmzyXo524Vu3F4Y7+Pog1ftba+v" +
           "M62Hv3/rJ2565R7g37oV+MDhD8l2/5XvRhtuEOe3mZs/uusPHv3dp76Wnxz/" +
           "H7DaPlp+JQAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "izN3KolgCRAN3EaVh1d1R3P69sZCDXo1CqtEWl/BlDmr8EaTNz1G1eIY7ZBj" +
       "Z03AY76jz2hpQfSV/rST4fOll4zbZsdHwmbb6TmRrSJK0oIrxsAzaZZYLjFE" +
       "rNXMIBqx9AaNKoSvoXO26WqBjXOGm/Od2bQ1AdbFUV2F8IfdwYqsBsMtnnaW" +
       "wgKvtsftRqhmuwHSmJrT/tIaDtx1b0w31z5JD6cLeuTala44IYksleduwDhN" +
       "GrjekB114T7TH+MhF1SwOl1nXGrjWK0dr4nVqLXtU2PG5psDZ+VjdJpzQ6eC" +
       "p9ym2Zna81oba8q6aAjGBoRU4IW7k02aYQuqw9WNZctoTP3ZYKwrChOaJCYZ" +
       "8K7TMaozY2tvMollamSNqjhzll6txXa7b6ezdtdpT3W7zza7GhsKjF5tyWNu" +
       "XlsvVkOBbS1aK7SLz6Y4pg/ckVeX4xjzM2Ku15cDJ4eRBSXthoMRKs/Uvj0y" +
       "B7s8D3Kb2uST+jAec2Of2q5G5gydEaMpTIbjbkrhuwonL22aWA8bPK6P7BSe" +
       "bdFQQLe4IPe5xTSZz0Yoi0Vox7OX4sC1WSxs9Ou9/kjqx4mptvvxdtWos1jc" +
       "rKuMzEyBoi7IpQWTgWYsI04Vkumit1SL7QAZqZTHz3cOZsw9WyQ7Xmqyhlhb" +
       "shnJ82NqtE7NTQXGBdeaikzGuWuB5/FcVOKGAFYqPp92G8yiTWykMHcnK3g1" +
       "jHYUseG8VU1Q8oS1xHk0mlAsagwak7Xl5+sx3EsSa9Br87VRZTDe9BfNpEtP" +
       "5qJMSxWw9PFsoMfpTBigeWQRNbXd3K0ZZum6bGzKmGi1Yt4yYDZ2fE2oZhuk" +
       "Fq7H3ca0UYunPidHHUILpi0q77a37d6SNKt9ctfAJE0KanDccMgdmXVNG61s" +
       "uKpCp8NOXWHcJpGxY7iVblsIQtpeum26o5xWlVaL47UBwlXmbByGWDhJdnzI" +
       "JUjV2SyVKK8vBZTaNgRWcnjey5YzL25MKpHDpTaaBJwcpFKzxawmLrzJ7dHc" +
       "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" +
       "MSwAAA==");
}
