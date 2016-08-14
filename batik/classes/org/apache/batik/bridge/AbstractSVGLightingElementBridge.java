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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f7YkuG+lFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+c+IVxy+/V+LXgoW4BUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "cf7T4hWH7/4X4ot1kOYVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ZeawsWVmvd+e9mTePYd6bGWZxZPYHOtN4q/fucti6q7tr" +
           "6erqpaqru0vhUV17d+1L1wIji1FGSZDAgJDA/AVRybBoJJoYzBijQEATlCia" +
           "CMSQiCIJ84dIRMVT1ffevve+ZTJovElV1z3n+77zbed3vnPOc9+DzvkeVHBs" +
           "I1ENO9iX42B/ZdT2g8SR/X2Sqo0Ez5cl1BB8nwVtV8RHP3vxBz96n3ZpD7qZ" +
           "h+4SLMsOhEC3LX8i+7axkSUKurhr7Rqy6QfQJWolbAQ4DHQDpnQ/eJKCXnaM" +
           "NYAuU4cqwEAFGKgA5yrArR0VYHq5bIUmmnEIVuC70C9BZyjoZkfM1AugR04K" +
           "cQRPMA/EjHILgITz2f8cMCpnjj3o4SPbtzZfZfAHC/Azv/nmS793E3SRhy7q" +
           "FpOpIwIlAjAID91myuZS9vyWJMkSD91hybLEyJ4uGHqa681Dd/q6aglB6MlH" +
           "TsoaQ0f28jF3nrtNzGzzQjGwvSPzFF02pMP/zimGoAJb79nZurWwl7UDAy/o" +
           "QDFPEUT5kOXsWrekAHroNMeRjZf7gACw3mLKgWYfDXXWEkADdOc2doZgqTAT" +
           "eLqlAtJzdghGCaD7rys087UjiGtBla8E0H2n6UbbLkB1a+6IjCWA7j5NlksC" +
           "Ubr/VJSOxed79Gvf+1YLt/ZynSVZNDL9zwOmB08xTWRF9mRLlLeMtz1BfUi4" +
           "5/NP70EQIL77FPGW5g/e9sIbX/Pg81/c0vz0NWiGy5UsBlfEjy9v/+or0ceR" +
           "mzI1zju2r2fBP2F5nv6jg54nYwfMvHuOJGad+4edz0/+fPGOT8rf3YMuENDN" +
           "om2EJsijO0TbdHRD9jDZkj0hkCUCulW2JDTvJ6BbwDelW/K2dagovhwQ0Fkj" +
           "b7rZzv8HLlKAiMxFt4Bv3VLsw29HCLT8O3YgCLoTPNC94PkLaPuX/wbQGtZs" +
           "U4YFUbB0y4ZHnp3Z78OyFSyBbzV4CbJ+Dft26IEUhG1PhQWQB5p80LH0dEmV" +
           "4dYS5LkgBgyHUbqqBSCtMqwAUto5wX6WdM7/73BxZv2l6MwZEJhXnoYFA8wo" +
           "3DYk2bsiPhO2uy98+sqX946myYHfAmgGNNjfarCfa7C/1WD/xTS4DDp6ckfP" +
           "oS2nONENnTmT6/WKTNFtsoBQrwFoAI7bHmfeRL7l6UdvAlnqRGdBnDJS+Pqo" +
           "ju5ghsjBVAS5Dj3/4eid3NuLe9DeSXjOjANNFzL2UQaqR+B5+fS0vJbci+/+" +
           "zg8+86Gn7N0EPYH3B7hxNWc27x89HQbPFmUJIOlO/BMPC5+78vmnLu9BZwGY" +
           "AAANBJDwAJsePD3Gifn/5CGWZracAwYrtmcKRtZ1CIAXAs2zo11Lnh+35993" +
           "AB9fzCbEz4Hnrw9mSP6b9d7lZO9XbPMpC9opK3Ksfh3jfOzrf/nPldzdh7B+" +
           "8dhCycjBk8egJBN2MQeNO3Y5wHqyDOj+4cOjD3zwe+/+hTwBAMVj1xrwcvZG" +
           "AYSAEAI3/8oX3b/75jc+/rW9XdIEYC0Nl4YuxkdGns9suv0GRoLRXr3TB0CR" +
           "AeZnljWXp5ZpS7qiC0tDzrL0Py++qvS5f33vpW0eGKDlMI1e8+ICdu0/1Ybe" +
           "8eU3//uDuZgzYrYU7ny2I9vi6107yS3PE5JMj/idf/XAR74gfAwgNUBHX0/l" +
           "HPCg3AdQHjQ4t/+J/L1/qq+UvR7yjyf/yfl1rGS5Ir7va99/Off9P34h1/Zk" +
           "zXM81gPBeXKbXtnr4RiIv/f0TMcFXwN01efpX7xkPP8jIJEHEkUAe/7QA7gU" +
           "n8iMA+pzt/z9n/zpPW/56k3QXg+6YNiC1BPySQbdCrJb9jUAabHzhjdugxtl" +
           "4b6UmwpdZfw2Ke7L/7sJKPj49fGll5Usuyl6338MjeW7/vGHVzkhR5ZrrNSn" +
           "+Hn4uY/ej77+uzn/bopn3A/GV2M1KO92vOVPmv+29+jNf7YH3cJDl8SD2pET" +
           "jDCbODyol/zDghLUlyf6T9Y+24X+ySMIe+VpeDk27Glw2a0R4Dujzr4vHMeT" +
           "H4O/M+D57+zJ3J01bFfcO9GDZf/ho3XfceIzYLaeK+839osZ/xtyKY/k78vZ" +
           "62e2Yco+fxZMaz8vWgGHoluCkQ/8xgCkmCFePpTOgSIWxOTyymjkYu4GZXue" +
           "Tpn1+9vKbwto2buci9imRO266fPzW6p85bp9J4yyQRH5nm+/7yu/8dg3QUxJ" +
           "6Nwm8zcI5bER6TCrq3/1uQ8+8LJnvvWeHKUARHG/9ruVH2ZSqRtZnL262at3" +
           "aOr9malMXiVQgh8McmCRpdzaG6byyNNNgL+bg6IRfurOb64/+p1PbQvC03l7" +
           "ilh++plf//H+e5/ZO1aGP3ZVJXycZ1uK50q//MDDHvTIjUbJOXr/9Jmn/ui3" +
           "n3r3Vqs7TxaVXbBn+tTf/NdX9j/8rS9do2I5a9j/i8AGt+F41Sdah39UaaHM" +
           "IjGezJRhpdkIfKS8WG1orTCoGqVJHGnFidOa1hxJH1qsigzrValCL5xQTIM0" +
           "KAUbSm6U+TKVRou+03cIuNibmA7a0jfNZOwWbbvv2h7HjPv1MYB68KyEIuGW" +
           "prDbUqaLtVtkYcaDJVMqwxXESoZdY1YK8JFnstKmEiqbjbSee05XSBJWYoeD" +
           "eGQ2o34q+M2x4c7WkTx1DQNfYDUHZ2J900DKA2WFVHmyMY6dhCM9tk/MsBK2" +
           "6Bt+ylNDfcbHbtcbYRhPx3GVJSlMkG0jnQQTi7E5fTWc0hxJzEZ1luyopuGS" +
           "a3VZk+Lp1LKGE62IWVg8VNFJTEyNJkGtRCtp02uzMZALrKfIk85Gm61T3LBm" +
           "fFIk143xNGXkWtUW2ESdNZLCgidlzYUHPCeLMReicbfgyHHE4F1rQ7F0pyGG" +
           "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");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "4vxnxCMO3/4vSkvTrOIVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze6zrSHn3PffefVyWvXfvso9u970X2t2g4zzsPLpAcRw7" +
           "TuIkjp3YiVu4+BXbiV/xK45hW6Bq2RaJIlgoSLB/gdqi5dGqqJUqqq2qFhCo" +
           "EhXqSyqgqlJpKRL7RykqLXTsnHNyzrmP1dKqkTKZzHzzzfea33wz88J3ofOB" +
           "DxU819rolhvua0m4v7DQ/XDjacF+l0YZyQ80FbekIBiDtqvK45+7+P0fvt+4" +
           "tAfdIkJ3S47jhlJouk7AaoFrxZpKQxd3rYSl2UEIXaIXUizBUWhaMG0G4dM0" +
           "9KpjQ0PoCn0oAgxEgIEIcC4CjO2owKBXa05k49kIyQmDFfRL0BkausVTMvFC" +
           "6LGTTDzJl+wDNkyuAeBwW/afB0rlgxMfevRI963O1yj8oQL83G+99dLvn4Uu" +
           "itBF0+EycRQgRAgmEaE7bM2WNT/AVFVTReguR9NUTvNNyTLTXG4RuhyYuiOF" +
           "ka8dGSlrjDzNz+fcWe4OJdPNj5TQ9Y/Um5uapR7+Oz+3JB3oeu9O162GZNYO" +
           "FLxgAsH8uaRoh0POLU1HDaFHTo840vFKDxCAobfaWmi4R1OdcyTQAF3e+s6S" +
           "HB3mQt90dEB63o3ALCH0wA2ZZrb2JGUp6drVELr/NB2z7QJUt+eGyIaE0D2n" +
           "yXJOwEsPnPLSMf98d/CG973doZy9XGZVU6xM/tvAoIdPDWK1ueZrjqJtB97x" +
           "FP1h6d4vPLsHQYD4nlPEW5o/fMdLb379wy9+aUvz09ehGcoLTQmvKp+Q7/za" +
           "g/iTjbOZGLd5bmBmzj+heR7+zEHP04kHVt69Rxyzzv3DzhfZv5i981Pad/ag" +
           "Cx3oFsW1IhvE0V2Ka3umpfltzdF8KdTUDnS75qh43t+BbgV12nS0betwPg+0" +
           "sAOds/KmW9z8PzDRHLDITHQrqJvO3D2se1Jo5PXEgyDoMvhC94HvD6DtJ/8N" +
           "oSVsuLYGS4rkmI4LM76b6R/AmhPKwLYGLIOoX8KBG/kgBGHX12EJxIGhHXTI" +
           "vqnqGozJIM4lJeT4Nm3qRgjCKsMKwKWZE+xnQef9/06XZNpfWp85Axzz4GlY" +
           "sMCKolxL1fyrynNRk3jpM1e/sne0TA7sFkITIMH+VoL9XIL9rQT7LyfBFdBB" +
           "aowLlm/ef6ITOnMml+o1mZjbUAGOXgLIAGB6x5PcW7pve/bxsyBGvfU54KWM" +
           "FL4xpuM7kOnkUKqASIde/Mj6XfwvF/egvZPgnKkGmi5kw5kMUo+g88rpRXk9" +
           "vhff8+3vf/bDz7i75XkC7Q9Q49qR2ap//LQTfFfRVICjO/ZPPSp9/uoXnrmy" +
           "B50DUALgM5RAuANkevj0HCdW/9OHSJrpch4oPHd9W7KyrkP4uxAavrveteTR" +
           "cWdevwvY+GK2HArg+6OD9ZH/Zr13e1n5mm00ZU47pUWO1G/kvI//7V/+SyU3" +
           "9yGoXzy2TXJa+PQxIMmYXcwh465dDIx9TQN0//AR5oMf+u57fiEPAEDxxPUm" +
           "vJKVOAAQ4EJg5l/90urvvvmNT3x9bxc0IdhJI9kyleRIydsyne68iZJgttft" +
           "5AFAZIHVmUXNlYlju6o5NyXZ0rIo/a+Lry19/t/ed2kbBxZoOQyj1788g137" +
           "TzWhd37lrf/xcM7mjJJthDub7ci26Hr3jjPm+9ImkyN511899NEvSh8HOA2w" +
           "MTBTLYc7KLcBlDsNzvV/Ki/3T/WVsuKR4Hjwn1xfxxKWq8r7v/69V/Pf+5OX" +
           "cmlPZjzHfd2XvKe34ZUVjyaA/X2nVzolBQagQ14c/OIl68UfAo4i4KgA0AuG" +
           "PkCl5ERkHFCfv/Xv//TP7n3b185CeyR0wXIllZTyRQbdDqJbCwwAaIn382/e" +
           "OneduftSrip0jfLboLg//3cWCPjkjfGFzBKW3RK9/z+Hlvzuf/zBNUbIkeU6" +
           "+/Sp8SL8wscewN/0nXz8bolnox9OrkVqkNztxpY/Zf/73uO3/PkedKsIXVIO" +
           "MkdesqJs4YggWwoO00mQXZ7oP5n5bLf5p48g7MHT8HJs2tPgstshQD2jzuoX" +
           "juPJj8HnDPj+KPtm5s4atvvtZfxg03/0aNf3vOQMWK3ny/u1/WI2/udzLo/l" +
           "5ZWs+Jmtm7Lqz4JlHeQpKxgxNx3Jyid+cwhCzFKuHHLnQQoLfHJlYdVyNveA" +
           "pD0Pp0z7/W3etwW0rCznLLYhgd4wfH5uS5XvXHfumNEuSCHf+0/v/+pvPvFN" +
           "4NMudD7O7A1ceWzGQZRl1b/2woceetVz33pvjlIAovhf/73KDzKu9M00zgoi" +
           "K8hDVR/IVOXyHIGWgrCfA4um5treNJQZ37QB/sYHKSP8zOVvLj/27U9v08HT" +
           "cXuKWHv2ud/48f77nts7loQ/cU0efHzMNhHPhX71gYV96LGbzZKPIP/5s8/8" +
           "8e88856tVJdPppQEODF9+q//+6v7H/nWl6+Tr5yz3P+FY8M7KAoJOtjhhy7N" +
           "5sJaYRNhHsGDityFw4SSO0ahj4wtXFEGmtuS2U2P5tVhhayq7kYVhq3RdCiW" +
           "0QJSroSxWuvXRLGmWTLnT+pEnTckttsrrOApyZOeVByRXIvdrHRO5nlMcm1M" +
           "N1ajQk+tsy0W7y3N5tqJ0qim1rQUpUwWcypqqqXdoFKDmUolSuhS0SyJYify" +
           "YmI2TfEZycZCARuVaG7GrFRuswi6ysR3J+60DtdVCmEEkusXh1LQGEnL6oJk" +
           "Dc7ehLN+WfJccqVJSS9JEnus9AViY6JWauFRdbBkJFIIimLV7HkMlkwFsdMn" +
           "KoNm27acbtjrBbC46g+xZbXYXeKjqNtZMs3uvEZUWbboFslFZbNYVNJOiPQm" +
           "Q60emOhQSPBllS0MUH+1SIw2ncBut9swzGrkNVmVRRdNFql5GloZUxgSyHC/" +
           "2SrH7KKAKlxN7iw3a8deSanLV0sml6qUMNyMllxDkChelNKxN4yXRRP3mT6r" +
           "NHqyghUG6yqZDAdjvrTq41UxmllBfVCddNSa01v1udHE7DKhN1n3pbCnrMsi" +
           "vsHWStU3F1FD75ed2TSUhRJNMgni1RBjEjiCj0w7KiESllDssSyFmQRCtTqt" +
           "pi2gZGsYYrxl1/XEKyktcVJPJqueGww9NApQrs+CDbAyLEhNbp42Fwxpi9Vw" +
           "3SnoNmpPozYilCYRrVN0gZdU3tZJdZgmqjwqUUoTmchkE+u3BoOOVlVoXkhN" +
           "U0wDs4y4VWNRWw8wjAx9BUmchtZleXZF4mrXNhCjF06SOr7sMpt10wtHSFOi" +
           "epsV1x2HNN/0eFuaTez+BmupBl0keGaKE7RJLuGZbmsYMQ3dSb1LM0xj3m6l" +
           "aWlJiR0c7Y82+DrlJlO0VG/bfoDbnCjaXbdfD1pKuWEKmmeUY2ddHGPBOMSE" +
           "nozqCjOtNWK5Me+VU3mAWry7WLHD/mzpeBo/qVdC2XDkOVEkkqqeqpOwhXbF" +
           "FU13wzUfu3TTbPZZlFjQgawk4rTrVGqlQCusY4Ttrjemt5yOSg7SRyRvWnR6" +
           "bTdtpZ1BW+TSiGUnQb2oTcxggXYljUDctj9wFtXxmIyGC49w+UkqVAtY3eb0" +
           "Pj0giRaDh5LgaPOWskoR39IJgpYQIqgi85CZOTBBb7S0Lm20WYVYTSYVtsGY" +
           "xEpiCryxHnXXQjlVxDHBCKkyiRk7wXFFrfQT3CFG4gzFN9Z4Oe4HjIfjw57C" +
           "OahbsElsI4xQw9B0bIrNyNFo00rjBUxZKlZT54xRpHUbLzUFEjPcdc1bBWnf" +
           "o0YGkxp1WJsuo4rcmYkuokbMsk3oo2AjdPCRZYY6l9hFZ4Svg4VM9KhGc+p3" +
           "Z8GSbHY5eYIlNR5rsvU6LmJNe1CoalrcWm/kfoOYGeyshvTiDrdkOKEk1Rct" +
           "UlZm3R4/LXuuEJZgtVGWZjzOd9p1U/A2K8HViRTbYE46dpFi18RX0Yy3yuhc" +
           "UdoraehyyzUl94yJaBQjlQnUvjNUlzpSaAmwu95oQx6vF1Z1b8hv4CEzThtV" +
           "FjUJrhB0KWs5mHQWcreG9chBuzBA9MUKbg+Y2GG71Xodni2izsTr6lMaJBTW" +
           "sNQjnHZLbdY3nBXbtaoQ0yW2siLLWtCsj22yhU3WtdFKm4y6M5irIe4GLblU" +
           "UxpUBpOEm04TvViXCn5acdedKiknMUbhHdcVY0wrOKnr0VM0CRUGC9TBEOts" +
           "Ur0pmRGVJBtnEQ1qMFJEK3iljahm7Eom7rQLlcrMqKdSs78qaTZZK7VH/Wqr" +
           "WmeYdmg2NI3BUZM0jbJPiTqNoC2dcvTRopUOGkgBVqjY36BzfBom6YpC0BIz" +
           "GiVCjwslYxyU/B5mO7U5vcS0ZILx2FpyVozE4nPOWhk9kTdmcdGPHGYuVRqN" +
           "VSAMsYS3K62WpFX67UqcOM3AWtTQGsKiqk6gvbXqBOV6fRHofktD0kS3nVET" +
           "5fQ6HNcEsVE10yLpYWOzYhETm+i6nXbSMkKmhMNpTGikqtdGAVKjx/U1X5Cm" +
           "NUTrbWw1grtJER5Tcmk9LXqzsjRF54tSe1FZIzFFzXidKjlEdz2ccAGtUlq4" +
           "oAohy5dRjE0cvdcnhu2i2h+RHXwjsAjfnJbgWrlbbpQdah2Pgg5YvxS/Gic4" +
           "K/ZYzTUi0Z409XXctgrV1BlHTM1G2JXX2aBKYBf7LZl35qrSr+nr0KSZQlqH" +
           "XWJqraq9XmsQUF7caLXqfrJAFMac22tYn+klvMi2564h0bNS0w3cOTqi22S0" +
           "XJX5yEhZlyvPIxlbUhWr4DTKdNjly62AGbUpuMLDcEHQ0g3VQEWPS/khWV6p" +
           "ZWyWbiKPEIZmAQZbU8DY9QpcnwgNu07KPayOlirSCEOYRugS5FyUdcaMacEe" +
           "N+KhAwSMRmGHKZd1vNyiybqiFWxg+GhZL1NsNXT1aWNmWuXaqlEK+NZiIjaY" +
           "kbRyl+mY66iqwTUqCKnVRu2RGS6GYQWmi7xMkBha2yzwAAlnpcApVReyECNM" +
           "0xobblrEFivCmlIjNmxGbDvSzU4S9MtMWSgXBFqXjeKy5sVh3C+E61mAjerl" +
           "AUmpYeKzYdFM3SprwyrTFcrNZTLqjjhPMaaqIFlkUAlCtCw7k1WDqsaAh2gG" +
           "aLk7nCAiLYiaLqjmIHUYgmgUJzO/X3K6rRbCjZzqhhuPRvXYXpSnfLkgSl1d" +
           "2pAxgN2ihxoEDTwIG3y957QTcQWrRVGOa+oilLHuaiCKalAod9xYXk98LVSG" +
           "sejrY4rclIKFS0yqfnVVEJm+M3VLRuCPzMXAckubZgvGk3XRspoc0cKsnjpY" +
           "SyLc7nQKXL/RDUE0F9NKj5sNqGY1DZop3G1PEHPU6THjxIwSSYwLG2TUxQ2R" +
           "no17JtrpGLAkG7NhXBquXYyHk1UwIjd+2gj0cdQsZmhSqMKx49RmIjOJHNP1" +
           "DalbNMPKNBDWU7HGCkjko14rKteLcWkF9wvJcgTOAkF3vrArRa+vY6gs4EnF" +
           "GLvGKtVmFlNcz3vNQQUthJHY6FEyxc0M3DVqlVgy13JhOppEgrExSoxGTYeN" +
           "qjcI204jQhtqRKlxwS7ABCxoZUpzaHHqLRs9nkxqdXRuDzaN1tBnA6vE41NB" +
           "aLcH+EKAR7HU7TJ22nQ4j1y0mizGRrgxoTi+pE2KqCNoC8XtFGeIMWZJ1SDr" +
           "mjJWeDHGUWBnphzaHM8lcpGNmT41GKe2mfZaCduWq/KSmqGyD/fahLrQU5ZV" +
           "I4lUwG5RhFNtwaS1KWnYzQFeYpN6oVAKVo7pT0dwyad6CBIO3DHcTBGjQFV7" +
           "08qoOo6wuFsutVIzGtaiTq1lL/AazXf6C9Ju42hY4pzW2OfoIbleIa21445R" +
           "h3SJSCTrXH1YSBGAoQneH1ZgJOaW8dgfdnhwcnhjdqR4yys71d2VH2CPXjHA" +
           "YS7roF7BaSa5/oR7uwl3d2H5Nchdpy/Ej9+F7S5IoOzg9tCN3izyQ9sn3v3c" +
           "8+rwk6W9g4ulKTinHzwl7fjsATZP3fh02s/fa3a3HV98978+MH6T8bZXcIf7" +
           "yCkhT7P83f4LX26/TvnAHnT26O7jmpekk4OePnnjcQGgRuQ74xP3Hg8dmfXe" +
           "zFyPg7P92a1Vt7/X3qNe11Fnckdt4+Eml3bhTfrirHBD6A5dC2lXkazBgejU" +
           "LoS8lzsQH2eaN1hH+t2TNT4KRL14oN/F/xv9zuUE5w4va157o3eH7QPCwXPl" +
           "IfXdGfW6ouyrrr1/8NKQdf3KIcH2ukZah9mVrOvnErzzJlZ8NiveHkKvUnxN" +
           "CrX8BeOQ15VrRMsCOeNt2hKQcEecG/sdr8TYSQg9eLOHk0MZ6j/pswxYgPdf" +
           "80K8fdVUPvP8xdvue37yN/nbw9HL4+00dNs8sqzjl37H6rd4vjY3c6Pdvr0C" +
           "9PKfD4bQfTcQEiCDvNPmA1v6D4fQpdP0IXQ+/z1O99EQurCjA6y2leMkHwuh" +
           "s4Akq37cO7QY/xM/ZJ0mONGbnDkJk0duv/xybj+GrE+cgMT8nf8QvqLtS/9V" +
           "5bPPdwdvf6n6ye0Di2JJaZpxuY2Gbt2+9RxB4GM35HbI6xbqyR/e+bnbX3uI" +
           "1XduBd4t3GOyPXL91wzC9sL8/SH9o/v+4A2//fw38ivN/wHhxn7agCEAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dd3G7Yoxnaf4THEYYeMZ/siGs/8EQX5MJw0ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Nn901x+89ref/lp+iP8/h2rWllwkAAA=");
}
