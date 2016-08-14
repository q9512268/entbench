package org.apache.batik.bridge;
public class SVGFeComponentTransferElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeComponentTransferElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COMPONENT_TRANSFER_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcR =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcG =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcB =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcA =
          null;
        for (org.w3c.dom.Node n =
               filterElement.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                e);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge)) {
                continue;
            }
            org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge funcBridge =
              (org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge)
                bridge;
            org.apache.batik.ext.awt.image.ComponentTransferFunction func =
              funcBridge.
              createComponentTransferFunction(
                filterElement,
                e);
            if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncRElementBridge) {
                funcR =
                  func;
            }
            else
                if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncGElementBridge) {
                    funcG =
                      func;
                }
                else
                    if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncBElementBridge) {
                        funcB =
                          func;
                    }
                    else
                        if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncAElementBridge) {
                            funcA =
                              func;
                        }
        }
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.ComponentTransferRable8Bit(
          in,
          funcA,
          funcR,
          funcG,
          funcB);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    public static class SVGFeFuncAElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncAElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_A_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8qw+tV6Gn//I/Y03fidfv0vxbPWDyY04DQq83Vr0k86/7T16/s/2oNtl6LJ6" +
           "UD1Kih1niSODiik8LClBhXli/mT1s33UXzuCsFefhpdj254Gl93zAdxn1Nn9" +
           "xeN48iPwOQO+/519M3NnA9tn7pXGwYP/4aMnv+8nZ0C2nkP3K/vFbP2bci6P" +
           "5Ner2eXntm7Kbn8epHWYl61ghWG5ip1v/GQEQsxWrx5yl0AZC3xydW5Xcjav" +
           "AoV7Hk6Z9vvb2m8LaNkVzVlsQ6J8y/D5hS1V/uS6a8eM8UAZ+b5//MBXf+2x" +
           "bwKfdqBzq8zewJXHduzHWWX9K89/8IGXPfut9+UoBSBKeu/vlX6QcWVeSuPs" +
           "QmaX1qGq92eq8nmRwChh1MuBRddybV8ylLnAcgD+rg7KRvipK99cfOTbn9qW" +
           "hKfj9hSx/syzv/qj/fc/u3esEH/shlr4+JptMZ4L/fIDCwfQIy+1S76i9U+f" +
           "eeqPPvHUe7ZSXTlZVpLg1PSpv/qvr+5/+Ftfvkm1cpvt/RSOjV72OQoLaeLw" +
           "wyATY7RWh8nIYEswqTkbo8IPUb5Nu6q8mbFsOyYHyGDMW8hYiMsqpfRcKZgV" +
           "W6mjxUbcjyrTkp6yqKOPB6Y/7IiWZy0Ypb4UcArZIF6/M7KI5UBpS6I1nSxp" +
           "RiIHJNnnuUTgLFqhZRFeR1olrMQlvRQXTIJpFONStBq7adktFUpmCKvlYnHU" +
           "mPqTZMlVi6PmyGgN52KNL6LMxiK9CE/ng17EzDVjsOrUCnLciLptR+voWEvB" +
           "ki6CduYNqe8onSnald32klc3yoRM25Tcc8LyrCxUHEup9BcLtGtbnrLkCc9A" +
           "0FG72eREodNnN4Hjy+0SKy4xQnADwSPthtKhJw2r6hbxoVT0kJZbQtIZVVyE" +
           "dFcdGtXQKrNsrb3AhaSHSrUhOQpaWOjwvDFRYiaWJVfVZEvVuOVa01pJ0qfw" +
           "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");
    }
    public static class SVGFeFuncRElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncRElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_R_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "SZkAfEXrmJtoYa3kxBFLeYNL1Na4v+GWHFG2G10jmLrEfMIJha5XwyKl2p0Q" +
           "eomNulSnz3JJPlTIihhOpTloqk2qX93wYjNur+KeXVAMqsmO7TrN9+Zqbdpp" +
           "qJv8ZBw15QoQvdbY9xqN2OcLHQMjlBkezuf+yOKoZOSaNZWUeF3p6b1+Zyj2" +
           "/A1Wtzhpw/eXkymr8wnNO/JqU6bkcpTvbJqhUJiz1YSMO4Fesg2erU4oCkTJ" +
           "bGh6rm8SlbbhqLGmipZY8htjPqiOY6I9ctv9Oj90HMmauqVOoeJOpDE2HvUD" +
           "R8LNZuLnkiiK2Gm+rswSEFrO2MFIfTIsduUOx0hgqgc8r/h12cV6pOXCrDAc" +
           "QRvnh7I0s8Z1J+n5Q7zIRXWxzEb1ZmUuUf0pLxhkt4l1R9xyaOfWi3pcqg4b" +
           "4XIkLCm1I0tul8nJBZrnCwu+AxVfYpTar4ezXL4/wIjSJFkKnRqYsu2x3CoR" +
           "4zXOzO0ZgXabUWVQMsXiwhr1e45lu0DslavBDM5q4pRdsXWj7I4b0WYTTUR+" +
           "NvcMjqkb9Z6ELQ3Gl6uxNOm0cNyttjSpVe4vZYkXuIq7ojfkoGCMq1NSX/Ui" +
           "YrOQLKGHWwLb6LCtOeM5hSG77irCgreFdtXyY013VqJAr8TiZE3Q9HhE1hlr" +
           "RarYhCkH5cpwYoJ1XWGHS72lUfpEI4t8CasSSrltEvaq3pHnFCtMeCruW4u1" +
           "NCMFUmkM9IJNzGt5n7AYFiu0hwIfuiYj9IzGoNWb9FZTo5SfG/La08m6TwJ8" +
           "yKrzYn41lupKvaYX+0Avts0FPrfRatxnym02T5So9rypMs16LKy6QSM0oL82" +
           "eTWogdYs2Uw0P+gMyGicx0OFb1OcIoBOSNeMiqGP0AQI5XqPaFemFi/NRhw3" +
           "NFR6NeAWnlvzm6Cu6jW8WQGDyQQtjgY2sHydL+KlsaML/loeV2Vi3sqHxNwl" +
           "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");
    }
    public static class SVGFeFuncGElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncGElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_G_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze6wjV3mfvZvdbJaQ3SyQpCl5L7SJ0R0/xmO7SyFje54e" +
           "22PPeOyZFpZ5esbz9Dz8ouERCQhFoqgNlEqQv0BtUXi0Kmqliipt1QIiqkSF" +
           "+pIKqKpUWopE/ihFpS09M773+t67u6GIqpY8Hp/zne98z9/55pvnvwOdiyOo" +
           "EAbueuoGyb6xSvZnbnU/WYdGvM+wVU6JYkNvuUocC2Dsuvbo5y597wcfsi7v" +
           "Qedl6FWK7weJktiBHw+NOHAXhs5Cl3ajuGt4cQJdZmfKQoHTxHZh1o6Tayz0" +
           "imNLE+gqeygCDESAgQhwLgKM7ajAolcafuq1shWKn8Rz6B3QGRY6H2qZeAn0" +
           "yEkmoRIp3gEbLtcAcLiQ/ReBUvniVQQ9fKT7VucbFP5wAX721996+XfPQpdk" +
           "6JLt85k4GhAiAZvI0J2e4alGFGO6bugydLdvGDpvRLbi2ptcbhm6EttTX0nS" +
           "yDgyUjaYhkaU77mz3J1apluUakkQHaln2oarH/47Z7rKFOh6z07XrYZENg4U" +
           "vGgDwSJT0YzDJbc5tq8n0EOnVxzpeLUDCMDS2z0jsYKjrW7zFTAAXdn6zlX8" +
           "Kcwnke1PAem5IAW7JND9t2Sa2TpUNEeZGtcT6L7TdNx2ClDdkRsiW5JArzlN" +
           "lnMCXrr/lJeO+ec7vTd+8O0+5e/lMuuG5mbyXwCLHjy1aGiYRmT4mrFdeOcT" +
           "7EeUe77wzB4EAeLXnCLe0vz+L7305BsefOFLW5qfvglNX50ZWnJd+4R611df" +
           "23q8cTYT40IYxHbm/BOa5+HPHcxcW4Ug8+454phN7h9OvjD8c+ldnzK+vQdd" +
           "pKHzWuCmHoiju7XAC23XiEjDNyIlMXQausPw9VY+T0O3g3vW9o3taN80YyOh" +
           "odvcfOh8kP8HJjIBi8xEt4N72zeDw/tQSaz8fhVCEHQFfKF7wfdPoO0n/00g" +
           "H7YCz4AVTfFtP4C5KMj0j2HDT1RgWwtWQdQ7cBykEQhBOIimsALiwDIOJtTI" +
           "1qcGzIskYbSAPoEPVgqR4sfAORlcgL/NnGY/i7vw/33HVWaDy8szZ4B7Xnsa" +
           "HFyQV1Tg6kZ0XXs2beIvfeb6V/aOkuXAegnEAyH2t0Ls50Lsb4XY/18IcTWn" +
           "IVJfI0+MQ2fO5DK9OhNyGy7A2Q6ADQCodz7Ov4V52zOPngVxGi5vA57KSOFb" +
           "43prBzR0DqcaiHbohY8u3y2+s7gH7Z0E6EwxMHQxW85lsHoEn1dPJ+bN+F56" +
           "37e+99mPPBXsUvQE4h8gx40rs8x/9LQLokAzdIClO/ZPPKx8/voXnrq6B90G" +
           "4ARAaKKAkAfo9ODpPU4gwLVDNM10OQcUNoPIU9xs6hACLyZWFCx3I3ls3JXf" +
           "3w1sfClLideD7xcPciT/zWZfFWbXV29jKXPaKS1ytP55Pvz43/zFP1dycx8C" +
           "+6VjRyVvJNeOgUnG7FIOG3fvYkCIDAPQ/f1HuV/78Hfe9wt5AACKx2624dXs" +
           "mkUfcCEw83u+NP/bb3z9E1/b2wVNAk7TVHVtbXWk5IVMp7teRkmw2+t38gAw" +
           "ckF6ZlFzdeR7gW6btqK6Rhal/3npdaXP/+sHL2/jwAUjh2H0hh/NYDf+U03o" +
           "XV95678/mLM5o2WH4c5mO7Itwr5qxxmLImWdybF6918+8BtfVD4OsBrgY2xv" +
           "jBzyoNwGUO40ONf/ify6f2qulF0eio8H/8n8Ola0XNc+9LXvvlL87h+9lEt7" +
           "suo57uuuEl7bhld2eXgF2N97OtMpJbYAHfJC7xcvuy/8AHCUAUcNoF7cjwAm" +
           "rU5ExgH1udv/7o//9J63ffUstEdAF91A0QklTzLoDhDdRmwBOFuFb35y69xl" +
           "5u7LuarQDcpvg+K+/N9ZIODjt8YXIitadil633/0XfXpf/j+DUbIkeUmZ/Wp" +
           "9TL8/Mfub73p2/n6XYpnqx9c3YjToMDbrS1/yvu3vUfP/9kedLsMXdYOqkdR" +
           "cdMscWRQMcWHJSWoME/Mn6x+tkf9tSMIe+1peDm27Wlw2Z0P4D6jzu4vHseT" +
           "H4LPGfD97+ybmTsb2J65V1oHB//DRyd/GK7OgGw9V96v7Rez9W/OuTySX69m" +
           "l5/Zuim7/VmQ1nFetoIVpu0rbr7xkwkIMVe7eshdBGUs8MnVmVvL2bwGFO55" +
           "OGXa729rvy2gZddyzmIbEtVbhs/Pbanyk+uuHTM2AGXkB/7xQy/+ymPfAD5l" +
           "oHOLzN7Alcd27KVZZf3e5z/8wCue/eYHcpQCECW+/3cq38+4si+ncXbBswtx" +
           "qOr9map8XiSwSpx0c2Ax9Fzblw1lLrI9gL+Lg7IRfurKN5yPfevT25LwdNye" +
           "IjaeefaXf7j/wWf3jhXij91QCx9fsy3Gc6FfeWDhCHrk5XbJVxD/9Nmn/vC3" +
           "nnrfVqorJ8tKHDw1ffqv/uvF/Y9+88s3qVZuc4OfwLHJKz5HITGNHX7YkqSU" +
           "l5q4GhfSSg3XvfWixg/LPEn7mrye9kmygg9KA5W3SxMhWY3bC1KwS0ulLVfk" +
           "Qi0VZstat+pVJbShtzwXd03Mtx1Wac4F1EXjTonR5p35bCQGcickRu2RE+NE" +
           "j8dWDLy2SRsXKRQvbdyK7MueXCsyTYl3fbnYaDRWmw3crVXhuUyiQr/rOFyx" +
           "Ymvsata1p43IpDsKEfYpkQzlIUKO3RANgkm9Ci9qCCcSPFfsKfXGQHHQGTG0" +
           "eG+dSF1UlIp2qdeTEgmRNmzqtVvySltW15YI1MZVgkyLUsfuhBy2moxVuotX" +
           "egTp+T6TdFapHJeaE4yfaJ0e7tDCkG4jhujYsyGbRtQ0Lte7MVYnxLC1QZiG" +
           "q+mdcd/xfaXLenYY0p2hzBFOeb1qtEVLXs/rm2lUX1iMrsLRNO6H8HCUolTR" +
           "aqRk0oKdMiIxJbHXK7LxesOEnjuv9LpCSErCqjQeazg6VKsdxWUcVWrJTg0d" +
           "6eVpq+1UsEBGS5ylB5U6XUw3LadV6SMM6hsOgVmgfp20NmTAD9LUwzyrW7QC" +
           "pFNLpFlPStGSE417riV5XG3kakbKIGUkLjFtuS0FQdkyQjrAeGpQVrFAWQ8k" +
           "RSrR3aTr21RCToc1O3Q6oiwSvQatuyErdFhQ6TNV1SGn6qY59AsR2urTTBLa" +
           "pVWFX8vuasRUTXS+RoNisyaXC5GEEgEypQareORgq24xtmqNZZKo/Q7j99c9" +
           "dT2TSc6sIngzmSNhl6lN+KIpKtaADrs9BpfFeaoNRiGDjrGGhFJDdlAlh4Ko" +
           "UIGC9DrxRqCKoT2kVYSRlx5CBqOZhsU+WWfigcXgitgN+IBCKs0prHGIVZOx" +
           "MTOkBuOxwtuL+cIaFRvBqCywQOemP5mq5CYVNqV+v1RvEOsR7rUN3GuWjVoF" +
           "dqt+qWaUVEOjpuWozmwYqs/zwjJhx7pSaSDrhEsN0uVnSx1LmlLPlCMviKdu" +
           "hRGdIkbiKL9iVl0DSSJnUyjgqb+oLwpkS+wF6NAouuMaRvkjNnWIQYmUDbkZ" +
           "bjq8tlb6jjP21w4xNZnxYsopYrDp4MZ6LCUrR2ciPqQbaoS0+VpnOrWKo2G/" +
           "3imF40YD6a0XnL0YTweDWTQd1KJpfc3ZMO0uhGiIT+zCssmMg9CzUClmR8UJ" +
           "EmGSLWA67OErny4kHh7qsReSzVav0mVavjeQC9XWyhUcCk+6wrCuSaPedIbW" +
           "mpt51yvxS7o9pXG4uRxxFNXtFzjY9OihqTZTzuo06+SSmSLdjj4RabEseuFc" +
           "ZBtpe7kxTF7deIxVn9hGUBA6ImbX7OmQKEY4xU9sGJF4U2L8VU9xpmWxiAcO" +
           "7evKzHFQdMA2fUyQsKSaVIDPkEKXr1asiB6V+wXC7hARW3Lh8YJerZQFrfBu" +
           "dZMoRKSbFVhH3R7v8ZghpnhJVHGtLU9RTAjDUqxgVaxa6ambtopNi2Qf7Yd8" +
           "cUmancVYIZZh2wy0bpXqr8051uzADUnB/fnMMEVz5Heqpk9V/ULZLQ1xu7Lo" +
           "TCyH0jBLDWFMcJstmEWW7nzp9SpqGR4UTBNeWZWRIca26jZ0peOPrba6saJl" +
           "WmV4uKKi+CIUV3CKl6uLZk/wiU4wwtiRb+KSrLTGjWbQKvfodnOsF+NRczzh" +
           "mvVKXV2HGxikmlZLEL/YCPFRd16ZTswOish8uaCpE2FJGhMHRiV5jUdDmqvW" +
           "GGFVbTXgwiLhWr5eW/DTMdnqeCReJ+tYgdAHtqPAptCYzxiSazX0im97CKz3" +
           "qaQLImJZI2bJsl2tSzGBtbpUb1arrtCkYk6IQoFYTDZ+t4tJpD6d2fPxjFxh" +
           "XilcSGteS+LFpAk3heZIaEZ9tzagubrI0p2NMu22Cskiliu1ySISCoLkt0v8" +
           "1CC9YqOOtEwuopqxHyZIDU5GBm2PZtKiUjYL41V/VJr5/ApZCuocM6yBaShm" +
           "bVwyA6fRNLAencgyzrgttdUsDnBVLSzhdW21aKfFhufWayzfWosNY4Lg1c66" +
           "pKec3FzDAypqFEflUOKUmJBmJXyGKoMJ50viYLKakMyyP+JjzqSMxYwqVAWx" +
           "XG0OGX/QofEBWdS7A4K0y2MZmbCTyPTFdglecBxRbkte32nJYgjTNDESSdIm" +
           "a548opotRPFrC65lIHUrSnoeHsxnnfo0oPuVyEJRRGKbltqdmI12aTHocWyp" +
           "OBmPJaQ7k6jmpKpx3GJVH7jNWYGJKIId4knf8pHQHlVSZDaQhXi0Rnh1HglC" +
           "aPNuXNDKLsMt2BHnaQbK2yYVyFafqpWrlQJMRnC9vNEnyigq1ebCnEKmjSBK" +
           "4yGyZlp6m5qbusLCtbSq1jQE18N2cRalo2572WuoS4ktoD5miumk4wmNuO+H" +
           "CzgGwMvNE1oskMNJ1a8xTqVdQHnWUYm0n2JmdyxNWCQkzcGcIoO1149LvWY3" +
           "ZBVa00PeriDusCZNOFEwUbGkU+MqIRR6lmCPKTFJUK881xcxLBMmtW46BUlr" +
           "03102BNXMS4v1UCIgta0S3GT2WY+XRAztD0rOn5Y5WBJH1mShgVawoiyulmJ" +
           "+KxAoOBY5jjSTlNNW46Hvpt2epNBwpkY62ieqxTpTZUUxmIiYjzNWZGgd113" +
           "jFeqATAEhxOltZ/OwZbAO/VBmac4REvbandT9PQCVlv7Bu+sDa090qqs0wH1" +
           "x6C8RDqJZ+CoCjNw1ytPHGk+4BvOwFZZS6CnAqbiumwAsE5Fo5P4XddaukXU" +
           "bCODjQY35MFmFDdF0yeGk357yqXg9ETFdcWtip5tRHDSTsdocdHro9009o2a" +
           "PYuJBgD11qgLqkWljCFly5wnJVGfp4V6SlVmCVMw55UljnAjyXaZXmm1ZCeS" +
           "YabNYkVtWsuGu+gMexzGUQJOM5QOGwWQBLoDw6WwSDT1alISfKG4mPh+bQkK" +
           "sgobc1hMKaMSRq3jAt2t9MtJYWUUeV7teULfGaogDVDM5gky6DuBouLFqqz2" +
           "hv2RqHTVYliaw0u7sOi7Fi02S0zfsBdptZN263qzUa061XkvVVgM6wc9w3e5" +
           "sr/Ee3h502yRlVWnIwtRp1zieFiHaVjtWBKq4Pxs2PX7LSTRJX2u4ElMwNRi" +
           "tiwXwGnQhi122THNAkZNEQSH+4oj1e0GT9ajisJbGyGJwDYjjySQBTXx24pJ" +
           "Cyk3E5pU6OMCOuHD1qQ7DENzthlNqEKpPoq4uFZobRacWgtpAhg9K93f8uM9" +
           "Pd2dPygevTEAD03ZBPVjPDWsbr7h3m7DXc8pbzfcfbr5fLzntGtEQNkD0gO3" +
           "ej+QPxx94ulnn9P7nyztHTRwJuB5+OC1zY5P9oT6xK2fArv5u5FdV+GLT//L" +
           "/cKbrLf9GL3Sh04JeZrlb3ef/zL5eu1X96CzRz2GG97anFx07WRn4WJkJGnk" +
           "Cyf6Cw8cmfWezFyPgu+LB2Z98eb9yps66kzuqG08vExzLHmZuUV2CRLozqmR" +
           "sIGmuL0D0aldCIU/6sHzREMqge69Rbv8sINx7SdoxYOIuO+G14PbV1raZ567" +
           "dOHe50Z/nTedj1473cFCF8zUdY93e47dnw8jw7RzW9yx7f2E+c87gR63kBOE" +
           "qrpT6B1b+qcT6PJp+gQ6l/8ep3tPAl3c0QFW25vjJM8k0FlAkt2+Pzw02vD/" +
           "5P3FieHVmZM5e+TwKz/K4cfS/LET+Zm/4D3MpXT7ive69tnnmN7bX0I/ue2q" +
           "a66y2WRcLrDQ7dsG/1E+PnJLboe8zlOP/+Cuz93xukPguGsr8C5Ljsn20M1b" +
           "2LgXJnnTefMH9/7eG3/zua/nfaz/AbQvYdN5HwAA");
    }
    public static class SVGFeFuncBElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncBElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_B_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL05a6zjaHWeOzuzs8OyMzvA7nbLvgfa3aBrx3HspENh87Dj" +
           "2I7zcOIkbmFw/I6f8SNxQpfHSsBSJIrahVIJ9heoLVoerYpaqaLaqmoBgSpR" +
           "obZU6oKqSqWlSOyPUlTa0s/OvTf33plZiqgayY79feec77y/8x0//13oXBRC" +
           "hcB31objx/taGu/PnfJ+vA60aJ/hyj05jDS14chRNARj15VHP3fp+z/8kHl5" +
           "DzovQa+SPc+P5djyvWigRb6z1FQOurQbJR3NjWLoMjeXlzKcxJYDc1YUX+Og" +
           "VxxDjaGr3CELMGABBizAOQtwbQcFkF6peYnbyDBkL44W0DugMxx0PlAy9mLo" +
           "kZNEAjmU3QMyvVwCQOFC9i4CoXLkNIQePpJ9K/MNAn+4AD/7m2+9/PtnoUsS" +
           "dMnyhIwdBTARg0Uk6E5Xc2daGNVUVVMl6G5P01RBCy3ZsTY53xJ0JbIMT46T" +
           "UDtSUjaYBFqYr7nT3J1KJluYKLEfHomnW5qjHr6d0x3ZALLes5N1KyGVjQMB" +
           "L1qAsVCXFe0Q5Tbb8tQYeug0xpGMV1kAAFBvd7XY9I+Wus2TwQB0ZWs7R/YM" +
           "WIhDyzMA6Dk/AavE0P23JJrpOpAVWza06zF032m43nYKQN2RKyJDiaHXnAbL" +
           "KQEr3X/KSsfs813+jR98u0d7eznPqqY4Gf8XANKDp5AGmq6FmqdoW8Q7n+A+" +
           "It/zhWf2IAgAv+YU8BbmD3/lpSff8OALX9rC/OxNYLqzuabE15VPzO762msb" +
           "j1fPZmxcCPzIyox/QvLc/XsHM9fSAETePUcUs8n9w8kXBn8xfdentO/sQRfb" +
           "0HnFdxIX+NHdiu8GlqOFLc3TQjnW1DZ0h+apjXy+Dd0OnjnL07ajXV2PtLgN" +
           "3ebkQ+f9/B2oSAckMhXdDp4tT/cPnwM5NvPnNIAg6Aq4oHvB9XVo+8v/Y8iD" +
           "Td/VYFmRPcvz4V7oZ/JHsObFM6BbE54Br7fhyE9C4IKwHxqwDPzA1A4mZqGl" +
           "GhosiC1KawB5fA9gDkPZi4BxsnQBXus5zH7md8H/+4pppoPLqzNngHleezo5" +
           "OCCuaN9RtfC68mxSJ1/6zPWv7B0Fy4H2YkgATOxvmdjPmdjfMrH/v2Diag5D" +
           "JZ5SPzEOnTmT8/TqjMmtuwBj2yBtgIR65+PCW5i3PfPoWeCnweo2YKkMFL51" +
           "Xm/sEk07T6cK8HbohY+u3i2+E9mD9k4m6EwwMHQxQ+9lafUofV49HZg3o3vp" +
           "fd/+/mc/8pS/C9ETGf8gc9yImUX+o6dNEPqKpoJcuiP/xMPy569/4amre9Bt" +
           "IJ2AFBrLwOVBdnrw9BonMsC1w2yayXIOCKz7oSs72dRhCrwYm6G/2o3kvnFX" +
           "/nw30PGlLCReD65vHMRI/p/NvirI7q/e+lJmtFNS5Nn6F4Xg43/7l/9cytV9" +
           "mNgvHdsqBS2+diyZZMQu5Wnj7p0PDENNA3B//9Heb3z4u+/7pdwBAMRjN1vw" +
           "anbPvA+YEKj5PV9afOObL37i63s7p4nBbprMHEtJj4S8kMl018sICVZ7/Y4f" +
           "kIwcEJ6Z11wdea6vWrolzxwt89L/vPS64uf/9YOXt37ggJFDN3rDjyewG/+Z" +
           "OvSur7z13x/MyZxRss1wp7Md2DbDvmpHuRaG8jrjI333Xz3wW1+UPw5yNciP" +
           "kbXR8pQH5TqAcqPBufxP5Pf9U3PF7PZQdNz5T8bXsaLluvKhr3/vleL3/uSl" +
           "nNuTVc9xW3fk4NrWvbLbwykgf+/pSKflyARw2Av8L192XvghoCgBigrIelE3" +
           "BDkpPeEZB9Dnbv+7P/2ze972tbPQHgVddHxZpeQ8yKA7gHdrkQnSWRq8+cmt" +
           "cVeZuS/nokI3CL91ivvyt7OAwcdvnV+orGjZheh9/9F1Zk//ww9uUEKeWW6y" +
           "V5/Cl+DnP3Z/403fyfF3IZ5hP5jemKdBgbfDRT/l/tveo+f/fA+6XYIuKwfV" +
           "oyg7SRY4EqiYosOSElSYJ+ZPVj/brf7aUQp77en0cmzZ08lltz+A5ww6e754" +
           "PJ/8CPzOgOu/sytTdzaw3XOvNA42/oePdv4gSM+AaD2H7hP7SIb/5pzKI/n9" +
           "anb7ua2ZssefB2Ed5WUrwNAtT3byhZ+MgYs5ytVD6iIoY4FNrs4dIifzGlC4" +
           "5+6USb+/rf22CS27ozmJrUuUb+k+v7CFyneuu3bEOB+UkR/4xw999dce+yaw" +
           "KQOdW2b6BqY8tiKfZJX1e5//8AOvePZbH8izFEhR4vt/r/SDjCr3chJnNzK7" +
           "UYei3p+JKuRFAidHcSdPLJqaS/uyrtwLLRfk3+VB2Qg/deWb9se+/eltSXja" +
           "b08Ba888+6s/2v/gs3vHCvHHbqiFj+Nsi/Gc6VceaDiEHnm5VXIM6p8++9Qf" +
           "/85T79tydeVkWUmCU9On//q/vrr/0W99+SbVym2O/1MYNn7F52gsatcOf1xx" +
           "KqMrRUzHhaREkKq7XhLCABVabU+R1ka31SqR/WJ/JljFyTBOx81la2gVV3JT" +
           "KkkFIhnOV0Sn7JaneFVtuN6ITaieNeLk+mKIO3jEFhllsTBlRrRlUWajxsiO" +
           "yDolNFMGXlstixRpnCxunJLkSa5EIEx9KjiehFSr1XSzgTtEGV5IOD7sdmy7" +
           "h5QshUvnHcuohnqblamgS4utQEqx1tgJcN+fVMoFncAmIiX0EF6uVPuyjc+p" +
           "gSm463jawcUpYhV5fhpPsemGS9xmQ0qVVXltikDs1oxqJciUtdigV0sn41m7" +
           "Q5Z4quV6HhOzaSJFxfqkJkwUlift9nDQbmKaaFvzAZeEtBGhlW5Uq1Bi0Nhg" +
           "TNVRVHbctUue3OFcKwja7EDqUTa63lSboimtF5WNEVaWZlCVm6Gx6AZGOkpw" +
           "GjGrCc1bsI1i0zYv8jzCResNE7jOosR3hkFrOkyL47FC4n2izMoOY+vThmQT" +
           "+EhFjUbTLtV8CS/2TNUvVdpIsmnYjVIXY3BPs6maOfTkcWPT8oV+krg11+wg" +
           "po+xRDyd89ME5+1wzDvm1O0Ro1jREwYwERWZptSc+j5qakHbrwl0H53VfHnd" +
           "n8rTYrsTdzyLjlvGgLACmxUlkeKrbdUJuCHLgUqfKc/sljHb1AdeIcQb3TYT" +
           "B1YxLQlryUlHTFnHF2vcR+qEhBbCKU75mEH302hk19IOEplEdRXHsy7LeN11" +
           "b7aeS62eXsbIerzAwg5DTAREF2Wz3w46PENK4iJR+qOAwce16hSnB1y/3Bpw" +
           "okz7Msaz0WZII4E1aM8wRlq5WMsfzZVa5LkVJuqbDCmPIl/waWxSr8DVrtFE" +
           "TTIWLNaIKiub0kW9WY7xfhC5Y0mWmt2whqpzxSstFDUs4+2R3+60KmxnGFW4" +
           "Euyk8xKhFWegALDQMKI2HN2VheEq5saqXKraaNzTkpYjzFdqLa5PeV0KXT8y" +
           "nBIIEqTWInEhZdKOhsWhvSngZOwtK8tCqyHyPj7QEGdM1GhvxCU21S+2JE0y" +
           "gw0rKGu5a9tjb21Ths5oS6Mni/6GJbU1Oo1TW2VCIWhXZyHWFAjWMExkNOhW" +
           "2GIwrlYxfr3sWcux0e/PQ6NPhIZSHmF6gZ2Ra3RQXEVRXxgvWGmhuc16Mear" +
           "bK3L2CtOLw9q8lqfSyY+mzKsNO9vxHWjbxK2O0v6ncGonKbMEMFUGq0DF0KT" +
           "VYUwGb6fNIxVrd5bKdQQhPhmacFe0SRpdD2dI32jxy8bGFtvTAalgQhSgqy5" +
           "697QrGCEh6AIYU1nLayU8HYjENpdJCTNAZMOMA9b4hTpFWpSNBSDqJ1222bL" +
           "RBBphNj2pNGbRqvazFCXPW2hJz0vDPvjFV+Wo82kvxD64Fwa6atSGe22iyY3" +
           "RHRS57CIEGt4lRbGKKtSDQYtDil1PjDKRtMPKECz7G8Q3qvUw84caTVWnfIC" +
           "T1vDWowu+DSYCH6nkpIFV5nV0naF93XKW1jakpdGpcJacScFX3OXpQHpIDqr" +
           "GbY+rg02VtXwIiA5Sazi+VoM1tOCrsNwE+gRHuliP5CLjDbDS1NrOEPMsOMS" +
           "DI4UuUJzGQwKVYUsYLrU6tPFrj/y6yN62ZDKQl2MmbDWMrlaailFBWmIE5qp" +
           "lMjhprzEl2RlgKurpDRXG+NIWFlLvVYuB7Ni0p6Jm4jX6WkZn1bLVMg0eGYO" +
           "zOD04CXrLeGCrXD6xELZenvMspVxvwYX61MTaeDqvBrPy0mnplYJcS0XCuq8" +
           "WFmr5Mbg6DAcdYlOx6OMNUnym8qaib1wWXRV3VkUO9VN0+jWvClZXjjGOjKo" +
           "WA5RoOmmTDsVfUVWRLI23gRJpdDUmeFa8BF/045CDqZUs4rho0IvBnWAX+Mo" +
           "Ae9V41Q3kE0FFTo40CK77I2YzqDDFQh92ZFKXXllSHrFrweIMRn58LyfVEu6" +
           "5ncKDQ2h2nxRoAKnJgtMpU8O+00jJIi02esifOhVZvTMSqZwd1KkJGuDxBy1" +
           "SAvIkIZXqIGaM901KH9TbDXHwtALzSlSGaS0Rq00ux3rXE0t6GyB0WdFBmww" +
           "NNliSL9W5KcpiTaQMTOVOE9XEweuVnqT7qgAj+yu0ZZFpsj61f5oLNjkjJ2N" +
           "J04NY7k0mSQK1inPEz4hF/KwUaj5ja43J9AFOeNMU+nSy9SRiSU9CXBZFG1X" +
           "o9to3R8VaDolOjrNrPpVa1FNBVLkhm21wPoBT2gk2rI3VCchXVzGUHxqBDPd" +
           "U8rCpIxSHdqjXdsvpXirPTMLvAv8s0RXhATWxwkfOMPlcBEWDNWYJ1GMp4w1" +
           "rdGooi3gIpIUCqWyMoMb87g2tqsxatcKdESM+bpOa0RzEaYpYVRn87ig9uDR" +
           "wKbLxJpRTVutSFpBjlelxBaKZErMfWOyIV0HrbL1EGHNst8pez6/GQ1Ya23R" +
           "E3niqygz0gqtDW5LsDpGEWroUvMSKrYoKcbX6ELX/bFchMk0VTBZIeod1uTE" +
           "OkLLq6EnhUbXirjaaAgn815gYcMe5tKDdXdp66KJCHV/ZTHFopiacc/UBjDY" +
           "lOtdt5AkHawsps0gkcVpv6oL+qzSd8U1zswHzaErxWIfJfn6XNMi3h6PJlio" +
           "OvWuzVdWk/FigS20UUuRSusmgymFulzpVTxeYIh1U5dHuKw3sX55tiLH/YVS" +
           "BBXb0l20ysSQgStuZTyaJgMrMIfrYSOII6dvNDtqMBZjwupruOh3i+raJRuT" +
           "uY/BSpcfDjf2vC5uHCrVqXqfSPxKGRmtQ88Tx4424xbzwrqK6kEDK+C+W9jE" +
           "84gp2GOEFzugZGQbdWJc5xZ8VdblMaqhpTLSiuBEbMJc1AwaA9b0WiuMnBnd" +
           "bkmBZd5Hsa7FOO2CbUxg3yJJI9H1WaOkLzcwUS7i7DzpWEQ4DOBxGOLVHgIn" +
           "xKDc6sutKtjPAEWdGuvGzIXVBK/zHdfreg0ytuaiUq+LdcvmxJHKGHLFl1ys" +
           "xLIqy+IjNNV9UZ/QGuqwBmbTnDAukd4E7XbMAkZsKmm9pEp2bVKrLUGJSjQr" +
           "FG1xsmnSMkbxrK+mU3kSy8lSD6NBVQG7pWQM2nFnrfh6UHQkJPBb8MYz+gV4" +
           "1sdbsNkrtJfNcr2ErXByXpshGG7Ga67aJoThIJSXHD+2EZxvTWf0GFb41dpd" +
           "R7CBiUgfZ8pUwcH8PlWiZFYvVwbMBo7oOZXCDlxTJxV7KLUpUKJnpftbfrLT" +
           "0935QfHoiwE4NGUT9E9wakhvvuDebsFdzylvN9x9uvl8vOe0a0RA2QHpgVt9" +
           "H8gPR594+tnn1O4ni3sHDZwJOA8ffLbZ0clOqE/c+hTYyb+N7LoKX3z6X+4f" +
           "vsl820/QK33oFJOnSf5u5/kvt16v/PoedPaox3DDV5uTSNdOdhYuhlqchN7w" +
           "RH/hgSO13pOp61FwvXig1hdv3q+8qaHO5Iba+sPLNMfil5lbZjc/hu40tJjz" +
           "FdnhD1indy4U/LiD54mGVAzde4t2+WEH49pP0YoHHnHfDZ8Ht5+0lM88d+nC" +
           "vc+N/iZvOh99drqDgy7oieMc7/Ycez4fhJpu5bq4Y9v7CfK/dwI5bsEncNXZ" +
           "TqB3bOGfjqHLp+Fj6Fz+fxzuPTF0cQcHSG0fjoM8E0NnAUj2+P7gUGmD/5Pv" +
           "FyeG0zMnY/bI4Fd+nMGPhfljJ+Iz/8B7GEvJ9hPvdeWzzzH821/CP7ntqiuO" +
           "vNlkVC5w0O3bBv9RPD5yS2qHtM7Tj//wrs/d8brDxHHXluFdlBzj7aGbt7BJ" +
           "N4jzpvPmj+79gzf+9nMv5n2s/wHvkUtBeR8AAA==");
    }
    protected abstract static class SVGFeFuncElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge {
        protected SVGFeFuncElementBridge() {
            super(
              );
        }
        public org.apache.batik.ext.awt.image.ComponentTransferFunction createComponentTransferFunction(org.w3c.dom.Element filterElement,
                                                                                                        org.w3c.dom.Element funcElement) {
            int type =
              convertType(
                funcElement,
                ctx);
            switch (type) {
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       DISCRETE:
                    {
                        float[] v =
                          convertTableValues(
                            funcElement,
                            ctx);
                        if (v ==
                              null) {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getIdentityTransfer(
                                );
                        }
                        else {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getDiscreteTransfer(
                                v);
                        }
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       IDENTITY:
                    {
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getIdentityTransfer(
                            );
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       GAMMA:
                    {
                        float amplitude =
                          convertNumber(
                            funcElement,
                            SVG_AMPLITUDE_ATTRIBUTE,
                            1,
                            ctx);
                        float exponent =
                          convertNumber(
                            funcElement,
                            SVG_EXPONENT_ATTRIBUTE,
                            1,
                            ctx);
                        float offset =
                          convertNumber(
                            funcElement,
                            SVG_OFFSET_ATTRIBUTE,
                            0,
                            ctx);
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getGammaTransfer(
                            amplitude,
                            exponent,
                            offset);
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       LINEAR:
                    {
                        float slope =
                          convertNumber(
                            funcElement,
                            SVG_SLOPE_ATTRIBUTE,
                            1,
                            ctx);
                        float intercept =
                          convertNumber(
                            funcElement,
                            SVG_INTERCEPT_ATTRIBUTE,
                            0,
                            ctx);
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getLinearTransfer(
                            slope,
                            intercept);
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       TABLE:
                    {
                        float[] v =
                          convertTableValues(
                            funcElement,
                            ctx);
                        if (v ==
                              null) {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getIdentityTransfer(
                                );
                        }
                        else {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getTableTransfer(
                                v);
                        }
                    }
                default:
                    throw new java.lang.Error(
                      "invalid convertType:" +
                      type);
            }
        }
        protected static float[] convertTableValues(org.w3c.dom.Element e,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
            java.lang.String s =
              e.
              getAttributeNS(
                null,
                SVG_TABLE_VALUES_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                return null;
            }
            java.util.StringTokenizer tokens =
              new java.util.StringTokenizer(
              s,
              " ,");
            float[] v =
              new float[tokens.
                          countTokens(
                            )];
            try {
                for (int i =
                       0;
                     tokens.
                       hasMoreTokens(
                         );
                     ++i) {
                    v[i] =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          tokens.
                            nextToken(
                              ));
                }
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_TABLE_VALUES_ATTRIBUTE,
                  s });
            }
            return v;
        }
        protected static int convertType(org.w3c.dom.Element e,
                                         org.apache.batik.bridge.BridgeContext ctx) {
            java.lang.String s =
              e.
              getAttributeNS(
                null,
                SVG_TYPE_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_MISSING,
                  new java.lang.Object[] { SVG_TYPE_ATTRIBUTE });
            }
            if (SVG_DISCRETE_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         DISCRETE;
            }
            if (SVG_IDENTITY_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         IDENTITY;
            }
            if (SVG_GAMMA_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         GAMMA;
            }
            if (SVG_LINEAR_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         LINEAR;
            }
            if (SVG_TABLE_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         TABLE;
            }
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
              s });
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "B8cT4hOHN/8LkHlNQKMdAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "D/kBkk/y3U/xRzY8/S/yAjYkZBgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zJ1VbNfWO/G9Bf6hgxXe85JTYLaeRnZru8Ws/xtyLg/n5cWs+Nmtm7LXnwPT" +
       "OsjTU9BDMx3Jygd+YwggZskX97mPQboKfHJxYdVyNi8HCXoOp0z73W2Otw1o" +
       "WYnkLLaQqFwTPq/ZUuUr1+2HzBgXpIvv++cPfuUDj34D+JSGTq8zewNXHhmx" +
       "H2UZ9Luf+/D9tzz9zfflUQqEqPEv/275hxlX5noaZ0UrK8h9Ve/LVBXyZICR" +
       "grCXBxZVybW9LpQ537RB/F3vpYfwk3d+Y/mxb316m/qdxO0JYvW9T//Kj3ff" +
       "//TOkYT70Sty3qN9tkl3LvRtexb2oYevN0reg/yX55/8499+8j1bqe48nj62" +
       "wO7o03/9X1/ZfeabX7pKVnKj5f4vHBve9rYOGlDY/ocpzVQ0HibJUivUFuUC" +
       "Siw0uZnoncXI0OdSEWc5tGYSVK1GVATUKQ3TnkogiFVarxl/vWAbME/jfJfU" +
       "VqaJdQ1LxdYjrzsyVsaq1BVDdxWYFam9tEYGX0wHXX7kw0J/ZTZb4z5cxddz" +
       "RETWA3je4labCkdWK164XkfauoDM1tMWO/bcVtVseYRCUo64MjhvTAY2PhRX" +
       "CDHsUO1KxPFoU6ugZTgkbLTrdl1J6oW6bDFNumBPTLpXnE1MwaeDyYrvxcbA" +
       "owO+MdDpRafdE0el/ky0NwURG1vKUpAkYuJRsW6RAU9ivhcKg1ZqdZtm3CZx" +
       "pKvjvMEsbTSpwXJn1OovVyLHRnw6VYWGb4zb9nTK9kxrZfIphqam7NYoYRHo" +
       "dk1G5xKFRF2x7/FSz1iuVAOre+1NPKhRRsQM+0RlzvWcPlqxJr5OizY9LgnG" +
       "NG0k5LBVFOn6kpIc0S4kgtAfFMxmiSSb/UnNxJ0VgFXHiDqDXjNZSYVwoGtC" +
       "n++VLDWdRIQ/qozVpdBCTdMboza7EOOSTQ0rQ4owEm9VldGyXhMZPHS7zCwc" +
       "cUA5jWUSTSjCfovo95RBsKr3ex3MbrmdJkVgSTfQLdMmyjTdctqjbtBNDdQ2" +
       "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" +
       "2k74jnzTf3DLAzbAWUPnJewAt00PZ8VjBweF+efMyZuBoweFh6dHULarvf9a" +
       "lzf5jvYTTz39rMJ+srSzd+o2DaGbQ9f7eUtdq9YRVjuA0xPX3r338rurw9Og" +
       "Lzz1r/cNX2+85SWccT94Qs6TLH+n99yX2q+SP7QD3XBwNnTFrdrxTpeOnwid" +
       "89Uw8p3hsXOh+w8se2dmsQfAg+5ZFr36OfNVUXAqR8HW99c51Ayu0xZlhRNC" +
       "t+pqyLiyZPX3RO8cwsX9SQcGR5nmFcsr9aP39KP/b/Q7mxOc3T/Meuxaty/b" +
       "C5a9q9t96rsy6rgs7yquvbt3E5M1PbVP8PAV7PR1uNv2Jc8w5aDvKuo+ZfEK" +
       "ygymUhzumrYExvdVR1H97JB7lzStUPX3O74iPwzLCHUVSMGrMkCPbqkIcexQ" +
       "6DjoeSnOZ9Jl+Y8G3/zqx9Pnn9ue+cylQA2hwrVu1K+81M+uXx67zhXS4V3r" +
       "99uveeHb/zR+0/5cveXAtQ9mnnwEPNyea7mTrt3X9bbDk+uelLd9IOf19usA" +
       "80NZkQJgyr4qherWeFnduw+B+daXAswkhB79Ke7isouFe6/4g8D2Ulv+zLPn" +
       "b7rn2dHf5NdRBxfPNzPQTVpkWUfPgY+8n/F8VTNzpW7engp7+ddHQ+iea8A2" +
       "hM5sX3ItntnSfyyELpykD6HT+fdRul8PoXOHdIDV9uUoyW+E0A2AJHv9TW/f" +
       "S2+41hzC5kHoS3KYWS93w8EZ5THLJaeOrwIHbrrzJ7npyMLx6DFQ5v/n2A/N" +
       "EbeH/eefpftvfbH6ye3lmmxJaZpxuYmBzm7v+Q7C+8PX5LbP60zn8R/d/tmb" +
       "H9uH9+1bgQ+D0hHZHrz6TVbL9sL87in9w3t+/7W/9ezX8+Ps/wGq/VexaCMA" +
       "AA==");
}
