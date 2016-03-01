package org.apache.batik.bridge;
public abstract class AbstractSVGLightingElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    protected AbstractSVGLightingElementBridge() { super(); }
    protected static org.apache.batik.ext.awt.image.Light extractLight(org.w3c.dom.Element filterElement,
                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.Color color =
          org.apache.batik.bridge.CSSUtilities.
          convertLightingColor(
            filterElement,
            ctx);
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
                  !(bridge instanceof org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge)) {
                continue;
            }
            return ((org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge)
                      bridge).
              createLight(
                ctx,
                filterElement,
                e,
                color);
        }
        return null;
    }
    protected static double[] convertKernelUnitLength(org.w3c.dom.Element filterElement,
                                                      org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return null;
        }
        double[] units =
          new double[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            units[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                units[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                units[1] =
                  units[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              units[0] <=
              0 ||
              units[1] <=
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        return units;
    }
    protected abstract static class AbstractSVGLightElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge {
        public abstract org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element lightElement,
                                                                         java.awt.Color color);
        public AbstractSVGLightElementBridge() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYW2wcVxk+u77Edhzf0tghrZ3E2UTk0h1C2ga0AZK4uTis" +
           "48VOLLCh67MzZ70Tz86czJyx1y4lSSVI4KGqmrQEpPgpFaIKbYWo4KWRERJt" +
           "VUqVUEEvooB44RapeWlA4fafc2Z2Zmd3E+AFSzs7e85//vNfvvP9//GVG6jJ" +
           "sdEgxaaGk2yBEieZ4e8ZbDtEGzKw4xyD0az6jd+dP3XrF61n4qh5EnUUsDOi" +
           "Yocc1ImhOZOoXzcdhk2VOEcJ0fiKjE0cYs9hplvmJFqjO8NFauiqzkYsjXCB" +
           "CWynUTdmzNZzLiPDngKG1qeFNYqwRtkXFUilUbtq0YVgwbqKBUOhOS5bDPZz" +
           "GOpKn8BzWHGZbihp3WGpko22U8tYmDEsliQlljxhPOgF4kj6waowDL7Y+eHt" +
           "JwtdIgyrsWlaTLjojBHHMuaIlkadwegBgxSdk+grqCGNVoaEGUqk/U0V2FSB" +
           "TX1/AymwfhUx3eKQJdxhvqZmqnKDGNpYqYRiGxc9NRlhM2hoYZ7vYjF4u6Hs" +
           "rZ/uiItPb1cufPORru83oM5J1Kmb49wcFYxgsMkkBJQUc8R29mka0SZRtwkJ" +
           "Hye2jg190ct2j6PPmJi5AAE/LHzQpcQWewaxgkyCb7arMssuu5cXoPJ+NeUN" +
           "PAO+9ga+Sg8P8nFwsE0Hw+w8Bux5SxpndVMTOKpcUfYx8VkQgKUrioQVrPJW" +
           "jSaGAdQjIWJgc0YZB/CZMyDaZAEEbYG1Okp5rClWZ/EMyTK0NiqXkVMg1SoC" +
           "wZcwtCYqJjRBltZFshTKz42je5541DxsxlEMbNaIanD7V8KigciiMZInNoFz" +
           "IBe2b0s/g3tfPhdHCITXRISlzA+/fHPvjoHlV6XMvTVkRnMniMqy6uVcx7X7" +
           "hrZ+soGb0UItR+fJr/BcnLKMN5MqUWCa3rJGPpn0J5fHfvqF08+RP8dR2zBq" +
           "Vi3DLQKOulWrSHWD2IeISWzMiDaMWompDYn5YbQC3tO6SeToaD7vEDaMGg0x" +
           "1GyJ3xCiPKjgIWqDd93MW/47xawg3ksUITQAH7QJPi6Sf+KboQWlYBWJglVs" +
           "6qalZGyL+88TKjiHOPCuwSy1lBzgf/b+ncndimO5NgBSsewZBQMqCkROKjlb" +
           "12aIsi8HqMcqG584lNZnCgxAxrmCmGy/EEhyCNL/5+YlHpnV87EYJO2+KGUY" +
           "cNoOW4ZG7Kx6wd1/4Obz2dclHPkR8mLK0ARYkJQWJIUFSWlB8m4WJKICFbMo" +
           "FhNm3cPtlDgCFMwCnwCht28d/9KR6XODDQBgOt8IKeSiW6oK3FBAPH61yKpX" +
           "ro3devONtufiKA7clIMCF1SZREWVkUXStlSiAc3Vqzc+5yr1K0xNO9Dyxfkz" +
           "E6c+JuwIFw6usAk4jy/PcLovb5GIEkYtvZ1n//DhC888ZgXUUVGJ/AJatZIz" +
           "0mAUBFHns+q2Dfil7MuPJeKoEWgOqJ1hOIrAmgPRPSqYKeWzPPelBRzOW3YR" +
           "G3zKp+Y2VrCt+WBEoLObP9ZIoHI4RAwUBeJT4/TS2z//4y4RSb+WdIaagHHC" +
           "UiH+4sp6BFN1B+g6ZhMCcr++mDn/9I2zUwJaILGp1oYJ/hwC3oLsQAS/+urJ" +
           "d37z/uW34gEcGWqltsXgHBOtJNy551/wF4PPP/mH0w4fkPTTM+Rx4IYyCVK+" +
           "+ZbAPKBDA7RxfCSOm4A/Pa/jnEH4cfh75+adL/3liS6ZcQNGfMDsuLuCYPwj" +
           "+9Hp1x+5NSDUxFRejoMQBmKS41cHmvfZNl7gdpTOXO//1iv4ElQLYGhHXySC" +
           "dJEICRI5fEDEQhHPXZG5h/gj4YRhXnmSQm1TVn3yrQ9WTXxw9aawtrLvCqd+" +
           "BNOUBJLMAmy2HXmPOa8IiG8+20v5s68ENvRFeecwdgqg7IHlo1/sMpZvw7aT" +
           "sK0KHOyM2kCSpQo0edJNK9798U96p681oPhB1GZYWDuIxZlDrQB24hSAX0v0" +
           "M3ulHfMt8OgS8UBVEeJBX187nQeKlIkELP6o7wd7vrP0vgCihN293nLxY7N4" +
           "fpQ/tovxBv66g6EW7HExQ82OaAVL5XCJ9f3RmhkKV+U+Nuqv19aIluzy4xeW" +
           "tNFnd8rmo6eyVTgAnfD3fvmPnyUv/va1GrWm2WtLgw0572+s4v0R0fIFnLX7" +
           "+q2G955a215N+VzTQB1C31af0KMbvPL4n9Yd+3Rh+r/g8vWRKEVVfnfkymuH" +
           "tqhPxUXXKmm8qtutXJQKxws2tQm05yZ3i4+sEsdgsJxX0Qtthc9pL6+no8dA" +
           "km5N4MQhGdTNwWWPjz0coIVDGPXdQWuEABqFukbxey1Dm+t1E7Ir8C4ovvRq" +
           "Lj2/S01qVjHptQ98asoX6BAHBs8zfl4sW3j0+TtQ0DR/fI6hlapNgIVFW+Lr" +
           "SlSZxmHBdetFaPqTgfBu/hiTMUn9Z4ebD+wtMdR/x6bIN+UT/2vPBadlbdXV" +
           "UF5n1OeXOlv6lo7/ShT28pWjHepm3jWMEK7CGGumNsnrInbtkmap+JplqK+O" +
           "kYCcXODNCSkPd4quqDxDTeI7LHeSobZADlTJl7AIcFgDiPBXl/oR+3jdiJmQ" +
           "PcYLoSi9ugqhk7EqxaoJdLfsRu6S2RAXbqrgEHF598+7K6/vWfWFpSNHH735" +
           "0LOyfYFr/+KiuOzB3VU2SWXO2FhXm6+r+fDW2x0vtm6Oe4CuaJ/CtgnAAX+K" +
           "PmNdpJg7iXJNf+fynqtvnGu+Dmw8hWIYztxU6Oos74nQEbhAaFPpMBGH/gUk" +
           "+oxU2++n3/zru7EeUZw86h6404qsev7qe5k8pd+Oo9Zh1ATFg5QmUZvuPLxg" +
           "jhF1Dspoi2vqJ10yrAEUc5Zrlu/5HRzAmF/sRWS8gK4qj/LOlqHBqht8jW4f" +
           "6vY8sfdz7YJHIyzrUhqeLfH7bw2vIDc7L/3t1NfeHoUDVmF4WNsKx82VCTv8" +
           "b4SAwbv44/6S7BwbsukRSr1OMnZcZJVSQSdfF06fldJcgqHYNkr/DRB/1LMO" +
           "FAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeSpotLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFeSpotLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_SPOT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double x =
              convertNumber(
                lightElement,
                SVG_X_ATTRIBUTE,
                0,
                ctx);
            double y =
              convertNumber(
                lightElement,
                SVG_Y_ATTRIBUTE,
                0,
                ctx);
            double z =
              convertNumber(
                lightElement,
                SVG_Z_ATTRIBUTE,
                0,
                ctx);
            double px =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_X_ATTRIBUTE,
                0,
                ctx);
            double py =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_Y_ATTRIBUTE,
                0,
                ctx);
            double pz =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_Z_ATTRIBUTE,
                0,
                ctx);
            double specularExponent =
              convertNumber(
                lightElement,
                SVG_SPECULAR_EXPONENT_ATTRIBUTE,
                1,
                ctx);
            double limitingConeAngle =
              convertNumber(
                lightElement,
                SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
                90,
                ctx);
            return new org.apache.batik.ext.awt.image.SpotLight(
              x,
              y,
              z,
              px,
              py,
              pz,
              specularExponent,
              limitingConeAngle,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYa2wU1xW+u35gG+MXsU0hGHAWJByyW0QS2pqWgIvBZG2v" +
           "bMdSTcNyd+aud2B25jJzF69NE0KkNrQ/0jSYlETCyg+iqhFNoqpR+yfIVaUm" +
           "UZpG0KjNQ01b9U9fSOFPaEVf556Z2Zmd9ZqSP7U0s+N7zz33PL77nTNz6Rqp" +
           "sy3Sy6mh0riY5cyOp+Rzilo2Uwd0atsTMJpWvvWHs6du/KrxdJTUT5GWHLWH" +
           "FWqzQY3pqj1F1muGLaihMHuEMVWuSFnMZtYJKjTTmCKdmj2U57qmaGLYVJkU" +
           "mKRWkrRTISwtUxBsyFUgyIYkWpNAaxJ7wgL9SdKsmHzWX7C2bMFAYE7K5v39" +
           "bEHakkfpCZooCE1PJDVb9Bctcjc39dlp3RRxVhTxo/p9biAOJu+rCEPvK62f" +
           "3Hwq14ZhWE0NwxTooj3GbFM/wdQkafVH9+ksbx8nj5KaJFkZEBYklvQ2TcCm" +
           "CdjU89eXAutXMaOQHzDRHeFpqueKNEiQTeVKOLVo3lWTQptBQ4NwfcfF4O3G" +
           "krdeukMunrs7Mf/dw20/rCGtU6RVM8alOQoYIWCTKQgoy2eYZe9RVaZOkXYD" +
           "Ej7OLI3q2pyb7Q5bmzaoKAAEvLDIwQJnFu7pxwoyCb5ZBUWYVsm9LILK/a8u" +
           "q9Np8LXL99XxcFCOg4NNGhhmZSlgz11Se0wzVMRR+YqSj7EHQQCWrsgzkTNL" +
           "W9UaFAZIhwMRnRrTiXEAnzENonUmQNBCrFVRKmPNqXKMTrO0IGvCcilnCqQa" +
           "MRByiSCdYTHUBFlaG8pSID/XRnY9edI4YERJBGxWmaJL+1fCop7QojGWZRaD" +
           "c+AsbO5LPkO7XjsTJQSEO0PCjsyPv3b9gW09i284MuuWkBnNHGWKSCsXMy1X" +
           "7hzY+vkaaUYDN21NJr/MczxlKXemv8iBabpKGuVk3JtcHPv5Vx57kf01SpqG" +
           "SL1i6oU84KhdMfNc05m1nxnMooKpQ6SRGeoAzg+RFfCc1AzmjI5mszYTQ6RW" +
           "x6F6E/+HEGVBhQxREzxrRtb0njkVOXwuckJIB1ykG65vEucPfwWZTeTMPEtQ" +
           "hRqaYSZSlin9lwlFzmE2PKswy81EBvB/7J7t8Z0J2yxYAMiEaU0nKKAix5zJ" +
           "RMbS1GmW2JMB1FNFjE/uT2rTOQEgk1zBDLEXBeISgvz/uXlRRmb1TCQCSbsz" +
           "TBk6nLYDpq4yK63MF/buu/5S+i0HjvIIuTEVZAIsiDsWxNGCuGNB/FYWxGBi" +
           "kI1zU+B02RyJRNCoO6SVDooAA8eATYDOm7eOP3zwyJneGoAvn6mFBErRLRXl" +
           "bcCnHa9WpJVLV8ZuvPN204tREgVmykB582tMrKzGOCXSMhWmAslVqzYe4yaq" +
           "15cl7SCL52dOT576LNoRLBtSYR0wnlyekmRf2iIWpoul9LY+8adPXn7mEdMn" +
           "jrI65JXPipWSj3rDEAg7n1b6NtJX0689EouSWiA5IHZB4SACZ/aE9yjjpX6P" +
           "46UvDeBw1rTyVJdTHjE3iZxlzvgjiM12fL4DUtwqD2ofXN92Ty7+ytkuLu/d" +
           "DpYlZkJeYA354ji/8N4v/7wDw+2Vm9ZAnzDORH+A4qSyDiSzdh+CExZjIPfb" +
           "86mz5649cQjxBxJ3LbVhTN4HgNoghRDmr79x/P3ffXTx3aiPWQE1vpCBdqlY" +
           "crJB+tSyjJMS5749QJE6MIVETewhA1CpZTWa0Zk8JP9s3bz91b892ebgQIcR" +
           "D0bbbq3AH//MXvLYW4dv9KCaiCJLtB8zX8zh/dW+5j2WRWelHcXTV9c/+zq9" +
           "ABUEWNvW5hgSMcEYEEzaveh/Au87QnP3y1vMDoK//HwFWqm08tS7H6+a/Pjy" +
           "dbS2vBcL5nqY8n4HXvK2uQjqu8NEc4DaOZC7d3Hkq2364k3QOAUaFaBce9QC" +
           "TiyWIcOVrlvxwU9/1nXkSg2JDpIm3aTqIMVDRhoB3czOAZ0W+e4HnOTOyHS3" +
           "oaukwnkZzw1LZ2pfnguM7dxPun+063sLHyGoHBStc5fjP1vwvlXetuF4VD7e" +
           "A8Czsd3zgYeL2sN1MQi8MuUWWV+tdcG26+Lj8wvq6AvbnQajo7wd2Afd7g9+" +
           "/a9fxM///s0l6km923r6G0Zhv00V7D6MbZ3PTDuv3qj58Ok1zZXELjX1VKHt" +
           "vuq0Hd7g9cf/snbiS7kjt8HYG0JRCqv8/vClN/dvUZ6OYmfqkHVFR1u+qD8Y" +
           "L9jUYtCCG9ItObIKYd1bymuXzFcvXPNuXueXZk1Ei7z1VXJRtaXLnNqJZeYm" +
           "5W1UkOZp6NtMheoj4A1KroE3N0S87MrjTleOEzvlLeWg9Qv/2+mRA7tx+MGS" +
           "R51yaiNcz7sePX/7wai2NORwLdpR67m1uVqP5HQ77muXJ71aSs/sUOKqmY+7" +
           "bZGcKkWpBaNEZ4SkBdNCszPLhPyovD0syErFYtBgY7vl6YpVmCYPgtSt5eFV" +
           "Ju4LYxYO334WioKsW6bV8wz53KftI4Ed1lS87jqvaMpLC60N3QsP/QbbldJr" +
           "VDMU+mxB1wPnKHim6rnFshpGrtkpExx/CoJ0VzESaCvjeyMceXC8LSwvSB3+" +
           "BuVOCtLky4Eq5yEo8qggNSAiH09xL2KTn7rzDguUzRYjlZUEc995q9wH6sNd" +
           "ZbyKHy08Diw4ny3SyssLB0dOXr//BacnU3Q6N4cvufDO7rSHJR7dVFWbp6v+" +
           "wNabLa80bo66kG93DPYP9LrAedgN3ReXBXZtqGGxY6W+5f2Luy6/fab+KlSo" +
           "QyRC4VQeCnwycN6PoespAMkfSgaLU+DTF/ZS/U1/PPLO3z+IdGCVJs7LSs9y" +
           "K9LK2csfprKcPxcljUOkDgoqK06RJs3+8qwxxpQT0E80FAzteIENqQDXjFkw" +
           "St83WiTIqaROjIwb0FWlUdnTC9Jb8eViifccaGBmmLVXasfaEqo8Bc6Ds0X5" +
           "3r+EV5Cb7Rf+ceob743CISwzPKhthV3IlIpY8POJX9XaHDb+D/xF4Pq3vGRK" +
           "5YD8FaRjwP2UsLH0LYHzojNXk04Oc+7KRrAI7eYcGeocKv6OvJ0tSglBIn2c" +
           "/xdi0nWcNxUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "dmR3ZpvPg8sJsBFLB5qvYScSX3/Bne2C23Os7AjjzuPn3IfPsbaHG1C66Xrg" +
           "RlcR2Ybrs++/+rzW+1x+Z+9QaAT22Hs3RFs+O4DNEzfeWXaza5jtScVX3//P" +
           "9w/ePnvqNZy/PnRMyOMsf6f7wtcbb1Y/ugOdPDi3uOaC6Oiky0dPK855AO89" +
           "e3DkzOKBA7Pek5rrUfC9umfWq9c/A72uo05kjtrEw00O3IKbjEXpwwmg26d6" +
           "QDuqbDJ7oje3IeS+2mb2MNOswzzQ7+6082Hw/cyefp/5v9HvVEZwav+g5U03" +
           "ujLYHP7v3ULuU9+VUq9QdVdzrN29W4J06Ff2CTZHLfIqSI9THS+T4JmbWPHZ" +
           "9PHuALpN9XQ50LPbh31el64RLQ3klLdhyUDCLXFm7Pe8FmPHAfSGm9x57ItQ" +
           "+WkvVED+3XfNve/mrlL94vPnz977/PCvsmuDg/vEW2no7CQ0zcPndYfaZ1xP" +
           "nxiZzW7dnN652c/HAujeGwgJgEHZavPRDf1zAXThOH0Anc5+D9N9MoDObekA" +
           "q03jMMmnAugkIEmbn3b3LSb81FdQxwmOjMYnjqLkgdcvvprXDwHrY0cQMbu9" +
           "30evcHN/f0V98fk28+5Xyp/b3I2oppwkKZezNHTL5prmAAEfuSG3fV5nmo//" +
           "+I4v3fqmfai+YyPwNm8PyfbQ9S8iKMsNsquD5A/u/b23/tbz38lOI/8HHdJ8" +
           "oVYhAAA=");
    }
    public static class SVGFeDistantLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFeDistantLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_DISTANT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double azimuth =
              convertNumber(
                lightElement,
                SVG_AZIMUTH_ATTRIBUTE,
                0,
                ctx);
            double elevation =
              convertNumber(
                lightElement,
                SVG_ELEVATION_ATTRIBUTE,
                0,
                ctx);
            return new org.apache.batik.ext.awt.image.DistantLight(
              azimuth,
              elevation,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+V8rMPXbPRUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+wQ4iGUd7VdwEkmvPeHebsLdPVZ+hXHH6avu4/dYu8sNKDt0PXC914j8wPWJ" +
           "9zz7vN77ZGnv4FJoBM7YB49EOz57gM0T1z9ZcvlLzO6m4ovv+ef7hZ+fvf0V" +
           "3L8+dErI0yx/h3vhy63Xax/cg84e3Vtc9UZ0ctCTJ28rLoRGnISucOLO4oEj" +
           "s96TmetR8P3GgVm/ce070Gs66kzuqG083ODCLb5B3zIrvBi6bWqADVNT7e6B" +
           "6O1dCPkvd5g9zjRvsI/0uztrfBh8v3Og33f+b/Q7lxOcO7xoed31Xg22l/8H" +
           "D5GH1Hdl1KuKtq97zv7BK0HW9SuHBNurFnUVZ9epXphL8K4bWPGZrHhHDL1K" +
           "Cw01NvLXh0Nel68SLQvkjLflqEDCHXFu7He+EmOnMfTgjZ89DqXAftJnFbAE" +
           "77vq9Xf7Yql95vmLt9z7vPg3+cvB0avirSx0i5nY9vEru2P1m/zQMK3cbLdu" +
           "L/D8/OdDMXTvdYQE2DDZafPBLf1zMXTpNH0Mnc9/j9N9NIYu7OgAq23lOMnH" +
           "YugsIMmqH/cPLSb9xA9RpwlO9KZnTgLlkePvfDnHH8PWx06AYv6GfwhgyfYV" +
           "/4r22ec73Xe8VPvk9nlEs9XNJuNyCwvdvH2pOQLBR67L7ZDXTe3Hf3T75259" +
           "3SFa374VeLd0j8n20LXfIkjHj/PXg80f3Pt7b/qt57+ZX0j+D8iTG/JcIQAA");
    }
    public static class SVGFePointLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFePointLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_POINT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double x =
              convertNumber(
                lightElement,
                SVG_X_ATTRIBUTE,
                0,
                ctx);
            double y =
              convertNumber(
                lightElement,
                SVG_Y_ATTRIBUTE,
                0,
                ctx);
            double z =
              convertNumber(
                lightElement,
                SVG_Z_ATTRIBUTE,
                0,
                ctx);
            return new org.apache.batik.ext.awt.image.PointLight(
              x,
              y,
              z,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "lP4XygXWbDkVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7QTYiKUDnTewE4mvv+DOdsHtOVZ2hHH78YPuw+dY28MNKN103X+ju4hsw/XJ" +
           "p597WR5+qrCzdyg0AXvsvSuiLZ8dwObxG+8s+9k9zPak4ktP/+u943fp73sD" +
           "568PHhPyOMvf67/ylfbbpI/uQCcPzi2uuSE6OunK0dOK874SLn17fOTM4v4D" +
           "s96VmusRsC8/ubHq5vfaM9DrOupE5qhNPNzkwC28ydgqfTghdKumhKQjCeZg" +
           "T/TONoTc19vMHmaadZgH+t2Zdj4ERL2wp9+F/xv9TmUEp/YPWt56ozuDzeH/" +
           "3jXkPvUdKXVUknZlx9rduyVIh35tn2Bz1CJEYXqc6viZBE/dxIrPpI/3h9Cb" +
           "JF8RQiW7fdjndfka0dJATnkblgAk3BJnxv7AGzF2HEL33ezSY18G7Ke9UgEJ" +
           "eM81N7+b20rpsy9fOHf3y+zfZPcGBzeKt5DQOVC4m4cP7A61z7i+ohqZ0W7Z" +
           "HN+52c/HQujuGwgJkEHcavPRDf0LIXTxOH0Inc5+D9N9PITOb+kAq03jMMlL" +
           "IXQSkKTNT7j7FuN+6kuo4wRHRuMTR2HywO2XXs/th5D10SOQmN3f78PXcnOD" +
           "f1X63MvE4P2vVT61uRyRTCFJUi7nSOjs5p7mAAIfviG3fV5nOo/96LbP3/LW" +
           "fay+bSPwNnEPyfbg9W8iWpYbZncHyR/d/Qfv+J2Xv5kdR/4P9o8jt1ghAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
