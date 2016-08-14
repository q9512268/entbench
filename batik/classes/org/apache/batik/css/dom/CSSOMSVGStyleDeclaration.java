package org.apache.batik.css.dom;
public class CSSOMSVGStyleDeclaration extends org.apache.batik.css.dom.CSSOMStyleDeclaration {
    protected org.apache.batik.css.engine.CSSEngine cssEngine;
    public CSSOMSVGStyleDeclaration(org.apache.batik.css.dom.CSSOMStyleDeclaration.ValueProvider vp,
                                    org.w3c.dom.css.CSSRule parent,
                                    org.apache.batik.css.engine.CSSEngine eng) {
        super(
          vp,
          parent);
        cssEngine =
          eng;
    }
    protected org.w3c.dom.css.CSSValue createCSSValue(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        if (idx >
              org.apache.batik.css.engine.SVGCSSEngine.
                FINAL_INDEX) {
            if (cssEngine.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGPaintManager) {
                return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationPaintValue(
                  name);
            }
            if (cssEngine.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGColorManager) {
                return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationColorValue(
                  name);
            }
        }
        else {
            switch (idx) {
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FILL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STROKE_INDEX:
                    return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationPaintValue(
                      name);
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FLOOD_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       LIGHTING_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STOP_COLOR_INDEX:
                    return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationColorValue(
                      name);
            }
        }
        return super.
          createCSSValue(
            name);
    }
    public class StyleDeclarationColorValue extends org.apache.batik.css.dom.CSSOMSVGColor implements org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected java.lang.String property;
        public StyleDeclarationColorValue(java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGColor.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return StyleDeclarationColorValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      if (handler ==
                            null) {
                          throw new org.w3c.dom.DOMException(
                            org.w3c.dom.DOMException.
                              NO_MODIFICATION_ALLOWED_ERR,
                            "");
                      }
                      java.lang.String prio =
                        getPropertyPriority(
                          property);
                      CSSOMSVGStyleDeclaration.this.
                        handler.
                        propertyChanged(
                          property,
                          text,
                          prio);
                  }
              });
            property =
              prop;
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            return CSSOMSVGStyleDeclaration.this.
                     valueProvider.
              getValue(
                property);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ye2wUxxmfO7+N39jGNdiAc4Bs6F1oIRU1oYHDBpPzQxxY" +
           "6tFwzO3O3S3e2112Z+2zadKAVIX8E1FKCGkT/+UIBdEkqhq1lZrIVdQmUdpK" +
           "SegjrUKr9p+0KWpQ1bQqfX0zu3u7t3dnwj89aWfnZr75Zr7X7/tmr91ENYaO" +
           "+olCw3ReI0Z4RKFTWDeIGJWxYRyBsaTwVBX+6/EPJnYFUW0CtWSxMS5gg4xK" +
           "RBaNBOqTFINiRSDGBCEiWzGlE4Pos5hKqpJAXZIxltNkSZDouCoSRjCN9Rhq" +
           "x5TqUsqkZMxmQFFfDE4S4SeJ7PVPD8dQk6Bq8y55j4c86plhlDl3L4OitthJ" +
           "PIsjJpXkSEwy6HBeR1s1VZ7PyCoNkzwNn5R32io4FNtZooKBl1o/vn0+28ZV" +
           "sBorikq5eMZhYqjyLBFjqNUdHZFJzjiFHkFVMbTKQ0xRKOZsGoFNI7CpI61L" +
           "BadvJoqZi6pcHOpwqtUEdiCKNhYz0bCOczabKX5m4FBPbdn5YpB2Q0FaS8oS" +
           "EZ/cGrn41PG2b1eh1gRqlZQ4O44Ah6CwSQIUSnIpoht7RZGICdSugLHjRJew" +
           "LC3Ylu4wpIyCqQnmd9TCBk2N6HxPV1dgR5BNNwWq6gXx0tyh7H81aRlnQNZu" +
           "V1ZLwlE2DgI2SnAwPY3B7+wl1TOSIlK03r+iIGPoQSCApXU5QrNqYatqBcMA" +
           "6rBcRMZKJhIH11MyQFqjggPqFPVWZMp0rWFhBmdIknmkj27KmgKqBq4ItoSi" +
           "Lj8Z5wRW6vVZyWOfmxO7nzitHFSCKABnFokgs/OvgkX9vkWHSZroBOLAWtg0" +
           "FLuEu185F0QIiLt8xBbNd79864Ft/ctvWDRry9BMpk4SgSaFpVTL2+uig7uq" +
           "2DHqNdWQmPGLJOdRNmXPDOc1QJjuAkc2GXYmlw//+IuPXiUfBlHjGKoVVNnM" +
           "gR+1C2pOk2SiHyAK0TEl4hhqIIoY5fNjqA76MUkh1uhkOm0QOoaqZT5Uq/L/" +
           "oKI0sGAqaoS+pKRVp69hmuX9vIYQWgUPCsNzFFm/OGsoEiNZNUciWMCKpKiR" +
           "KV1l8hsRQJwU6DYbSYHXz0QM1dTBBSOqnolg8IMssScEw4iIai4Sjccnx+PT" +
           "B+J0Xib7wWoQrUz0MPM27f+0T57Ju3ouEABTrPMDgQwxdFCVRaInhYvmvpFb" +
           "LyTfspyMBYatKYpisHXY2jrMtw7D1mHYOlxp65B/AAyo6tNYNgkKBPhhOtnp" +
           "LJ8Ai84ANgA4Nw3GHzp04txAFTijNlcN5mCkA0VJKuoCiIP6SeHFjuaFjTe2" +
           "vxZE1THUgQVqYpnlnL16BtBMmLEDvikF6cvNIhs8WYSlP10ViAggVimb2Fzq" +
           "1Vmis3GKOj0cnBzHojlSOcOUPT9avjx3Zvor9wZRsDhxsC1rAPPY8ikG9wVY" +
           "D/kBoxzf1sc++PjFSw+rLnQUZSIngZasZDIM+N3Fr56kMLQBv5x85eEQV3sD" +
           "QDvFEIqAmv3+PYqQadhBeSZLPQicVvUcltmUo+NGmtXVOXeE+3E773eCW7Sy" +
           "UB2EJ2nHLn+z2W6NtWssv2d+5pOCZ5H749qzv/rZHz/L1e0knFZPpRAndNgD" +
           "coxZB4ezdtdtj+iEAN37l6e+/uTNx45xnwWKe8ptGGJtFMCNxYOqf/WNU+/9" +
           "9sbS9aDr5xSyvJmCYilfELKeydSygpCw22b3PBBjMgAI85rQUQX8U0pLOCUT" +
           "Flj/at20/eU/P9Fm+YEMI44bbbszA3f8U/vQo28d/3s/ZxMQWJJ2deaSWci/" +
           "2uW8V9fxPDtH/sw7fU+/jp+FHAK4bUgLhENxwI51dqgeqNn4SpaPw1Y+5tbc" +
           "yafv5e0Opgm+CPG5XazZZHijojjwPFVWUjh//aPm6Y9evcXFKC7TvE4wjrVh" +
           "y+9YszkP7Nf4UesgNrJAt2N54ktt8vJt4JgAjgIAtjGpA7Dmi1zGpq6p+/UP" +
           "X+s+8XYVCo6iRlnF4ijm0YcawO2JkQVMzmtfeMCy+hzzgzYuKioRvmSAaX59" +
           "eZuO5DTKrbDwvTXf2X1l8QZ3P83isbYAt+uK4JYX+27EX333cz+/8rVLc1a5" +
           "MFgZ5nzrev45KafO/v4fJSrnAFemlPGtT0SuPdMb3fMhX+8iDVsdypemNkBr" +
           "d+1nrub+Fhyo/VEQ1SVQm2AX1zwbQfwmoKA0nIobCvCi+eLi0KqEhgtIus6P" +
           "cp5t/RjnplToM2rWb/bBWgcz4QA8CTviE35YCyDeeZAv2cLbIdZ82kGRBk1X" +
           "KZySiD4gaV+BLQWo01VerbP/91ngydrPsyZmsbq/nEdaU1tYs7WwIXfFRqek" +
           "ct5e5PK6nB31O+5YZvAqIsQNA8loVmLxBQ7bV6l05mX/0tmLi+Lkc9stj+0o" +
           "LkdH4Lb1rV/8+yfhy797s0zlU2tffYoDpK8oQMb5lcL1tvdbLvzh+6HMvrsp" +
           "RdhY/x2KDfZ/PUgwVDnm/Ed5/eyfeo/syZ64i6pivU+XfpbPj19788Bm4UKQ" +
           "35+sMCi5dxUvGi52/kadwEVROVIUAvcUXKeLeUofPPO268yXz+xlvK6QLyst" +
           "XSGBZFaYk1iTghjJEAsVHI/dUtZjiZIBaArPMsqwS88jSVghkj4BtrOBqJaH" +
           "W2nlAts53Pa7rtrBtXtKvhVY91vhhcXW+jWLR3/JvbpwB20C/0ybsuzFNk+/" +
           "VtNJWuI6bLKQTuMvEy6NlU5HURW0XAhqUYO4neWogRJaL+VpKB38lBTV8LeX" +
           "7hGKGl06CHOr4yU5A9yBhHXPao5KN38yhMoHPIBhm5Fbv+tO1i8s8ZaRLMz5" +
           "lx4nJE3rWw/cehYPTZy+dd9zVhkLdlxY4F8GYqjOqqgLYb2xIjeHV+3Bwdst" +
           "LzVsCtpO324d2A22tZ6IiAIQaqzS6PXVeEaoUOq9t7T71Z+eq30HYPUYCmCK" +
           "Vh8rTaV5zQQ8PRZzEdXzpZAXn8OD35jfsy39l9/wYqW0RPHTJ4XrVx5690LP" +
           "EhSpq8ZQDWQAkuc5fv+8cpgIs3oCNUvGSB6OCFwkLI+helORTplkTIyhFpHH" +
           "A9ScXC+2OpsLo+wSRNFAyceeMldHKOzmiL5PNRWRAx1AsDtS9AnKQUZT03wL" +
           "3JGCKTtLZU8K+x9v/cH5jqpRCM8icbzs6wwzVUBd71cpF4bbLCz9L/wC8PyH" +
           "PczobIC9oRyK2l9oNhQ+0UAFac1VJWPjmubQ1i5rVuBcZM2lPBunKDBkjzJc" +
           "s8t+9vdpvv9l3mXNN/8HOTcgnaEWAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fLszOzssO7MLu2y37JMBumv0OU7ixNECxXbi" +
           "xLFjO3HsJG7LrGM7thO/7cRJ6BZYqeWl0lVZHpVg/wK1RcujVVErVVRbVS0g" +
           "UCUq1JdUQFWl0lIk9o/SqrSl1873npld4I9+km/8+Z5z7jn3nPO75977/Peg" +
           "80kMwWHgbiw3SPfNdbo/d7H9dBOayX6Xw0QtTkyDcrUkGYJv1/RHP3/5Bz98" +
           "xr6yB11QoVdpvh+kWuoEfjIwk8BdmQYHXT7+2nJNL0mhK9xcW2nIMnVchHOS" +
           "9AkOesUJ1hS6yh2qgAAVEKACUqiAEMdUgOmVpr/0qJxD89Mkgn4FOsdBF0I9" +
           "Vy+FHjktJNRizTsQIxYWAAkX8/8VYFTBvI6hh49s39l8ncEfhpFnP/r2K79/" +
           "C3RZhS47vpSrowMlUjCICt3hmd7UjBPCMExDhe7yTdOQzNjRXGdb6K1CdyeO" +
           "5WvpMjaPJin/uAzNuBjzeObu0HPb4qWeBvGReTPHdI3D/87PXM0Ctt57bOvO" +
           "Qjr/Dgy85ADF4pmmm4csty4c30ihh85yHNl4lQUEgPU2z0zt4GioW30NfIDu" +
           "3vnO1XwLkdLY8S1Aej5YglFS6P6bCs3nOtT0hWaZ11LovrN04q4LUN1eTETO" +
           "kkL3nCUrJAEv3X/GSyf88z3+zR98h9/x9wqdDVN3c/0vAqYHzzANzJkZm75u" +
           "7hjveJz7iHbvF9+7B0GA+J4zxDuaP/zlF9/2pgdf+PKO5mdvQCNM56aeXtM/" +
           "Ob3z66+lHmvckqtxMQwSJ3f+KcuL8BcPep5YhyDz7j2SmHfuH3a+MPiLybs+" +
           "bX53D7rEQBf0wF16II7u0gMvdFwzbpu+GWupaTDQ7aZvUEU/A90G3jnHN3df" +
           "hdksMVMGutUtPl0Iiv/BFM2AiHyKbgPvjj8LDt9DLbWL93UIQdArwAPtg0eG" +
           "dn9S3qSQgdiBZyKarvmOHyBiHOT2J4jpp1MwtzYyBVG/QJJgGYMQRILYQjQQ" +
           "B7Z50KEnCWIEHkJJktCTlLaUblyzCbwGsjU3fT+PtvD/aZx1bu+V7Nw54IrX" +
           "ngUCF+RQJ3ANM76mP7skWy9+9tpX944S42CmUogDQ+/vht4vht4HQ++Dofdv" +
           "NvTVsx+AA4NY0dylCZ07Vyjz6ly7XUwAjy4ANgDUvOMx6Ze6T7730VtAMIbZ" +
           "rcAdOSlyc/CmjtGEKTBTByENvfCx7N3KO0t70N5pFM4tAp8u5exijp1HGHn1" +
           "bPbdSO7l93znB5/7yFPBcR6egvUDeLieM0/vR8/OfRzopgEA81j84w9rX7j2" +
           "xaeu7kG3AswAOJlqIK4BBD14doxTaf7EIWTmtpwHBs+C2NPcvOsQ5y6ldhxk" +
           "x1+KoLizeL8LzPHlPO4fA8+1g0QofvPeV4V5++pdEOVOO2NFAclvkcJP/O1f" +
           "/kulmO5D9L58Yj2UzPSJE4iRC7tcYMNdxzEwjE0T0P3Dx8QPffh77/mFIgAA" +
           "xetuNODVvKUAUuTBFcS/+uXo7771zU9+Y+84aFKwZC6nrqOvj4y8mNt050sY" +
           "CUZ7w7E+IGBdkI151FyVfS8wnJmjTV0zj9L/vvx69Av/9sEruzhwwZfDMHrT" +
           "yws4/v4zJPSur779Px4sxJzT8xXveM6OyXYw+qpjyUQca5tcj/W7/+qB3/qS" +
           "9gkAyAAEE2drFrh27iBxcqXuAZVJwZkvbvu7xa3wJlJ0P160OQZCBRNU9FXy" +
           "5qHkZFacTrwTJcs1/ZlvfP+Vyvf/5MXCjNM1z8kg6GnhE7u4y5uH10D8a85C" +
           "QEdLbEBXfYH/xSvuCz8EElUgUQfolwgxQKn1qZA5oD5/29//6Z/d++TXb4H2" +
           "aOiSG2gGrRXZB90Owt5MbABw6/Dn37bzepbHwZXCVOg643fRcl/x361Awcdu" +
           "Djx0XrIc5+59/yW406f/8T+vm4QCcm6wUp/hV5HnP34/9dbvFvzHuZ9zP7i+" +
           "HrlBeXfMW/609+97j1748z3oNhW6oh/UjgXYgoxSQb2UHBaUoL481X+69tkt" +
           "9E8cYdtrz+LOiWHPos7xigHec+r8/dIZoLk7n+VHwaMe5KB6FmjOQcULUbA8" +
           "UrRX8+aNh3l9exgHKdDSNA5S+0fg7xx4/jd/cnH5h91Cfjd1UE08fFROhGA5" +
           "uwhEFIVpzl/aQVveVvOG3Imt3zRe3pw39Poc0OV8eb++Xwhgb6zvLfnrzwEw" +
           "SoqKGnDMHF9zi1mhUxD/rn71UEcFVNj5yjl36zfSi/6x9QJxe+dxynMBqGY/" +
           "8E/PfO03XvctEFxd6PwqdzyIqRO4wC/zAv/Xnv/wA6949tsfKHAUTLbyvt+r" +
           "fzuXOnwp6/JGyBvx0Kz7c7OkomrhtCTtFdBnGrllL51TYux4YIVYHVSvyFN3" +
           "f2vx8e98ZleZnk2gM8Tme599/4/2P/js3on9wOuuK8lP8uz2BIXSrzyY4Rh6" +
           "5KVGKTjof/7cU3/8O0+9Z6fV3aer2xbYvH3mr//na/sf+/ZXblBI3eoCb/zU" +
           "jk3v+HKnmjDE4R+HTsxyJq/X3kyow3ylMW/zhkPoVTKp0WjADGQ0mHSaZChu" +
           "++v1pJbS2VaoCBWpYpZRtKzC5a1msITCjPEWSrNUezFEYJkhjdYisiPUVWNG" +
           "MfqebISsZFrzWGbjRgiX2FHYR6f9aDYubZeVZT2tGH42xxvaaOarcR0Dz7iO" +
           "pF7cQFv8RBPgwKWyysBkSmp1wNLDUdNk2t3RejLYkIk2zBRyDNeQltj1J7Q8" +
           "KlHpSFr3JMyyqmt2QGo8KURDmuGdgdRsk1TLGW3bbqsK9hGYzUZhlxirzNpN" +
           "+YWkNoMlFUiDOcU3Bna0xoaRnEQLtbf2+jQ9a7aqUlUyu3VREZu40V/UyAjf" +
           "YNi8quO10LXdplvhqoKTpnZXZJJ5NxwvpFa2qXVIc4AmqKLWxQ0V8IttxvvY" +
           "oFJ2girNp2oQsKSLBsjKL8FlXFUSMoidRYSZPdWeRPMNR9LziJeNjkp3t3OH" +
           "7ixopTcdsv3SesAKatIOaJ6pUyFTQzlSM1bdIFKdWqh3hDCLUrllOBTL25Nt" +
           "aUoJ+labsmPMq9KkODV8bBKS5X6J1iQ8kFoqordjv4qK7fIUNW3UGkSu2q8K" +
           "1Sph16hM6jOy5DNhYKf1gdpmKENaWlxnPuiaGUdVJu6ymoXMhor6vmc0hhS5" +
           "KPO1zlpUUMMaYCTPZ6OoZo3XpXRj1zs4qg1cv8+rSwVVucxtlZsWU5Z8IhMn" +
           "FbIOZy46FCTGZUuVGHaYthj0JYoIxzLWj/looqURqfeIWkzqg57Kdm2mg6K9" +
           "TZ+O5pYlRrSojNReWIpHtE16BrPwvcW8XGc9i43IqMqkgeRwc1zFssGotlLU" +
           "zUiYeWuh7m+dtENLFEuQPh0srAQRVtZi3FgtRh1JjQNS4IhRapVobtlaojhG" +
           "l/qMw6X4mpzyRr2B16p0iujpatQcxJsG2QsXVcmSNDpUhlwZXjpWfRmVm52I" +
           "N0Z9T2xzXcEY8N5YbAo62u/Ol8RCL7fHE8/NEARmluLYkWek25m32UBReL9n" +
           "DWCUKofCoiw5nQ3BloYtt2rbEcMEE2zGzyOiXuvJCxtd2gvBK/WFQIvUISZH" +
           "CIcELFNK2kSkBRIcsgMlrDVsbwlsYyb9kSWLVMJvadpDhHYStBxe5WXdGfUo" +
           "NmSdAaugLm4ng343k2vNyVSadMbbUr+HGkOSlITID1wLZ3pJIumtrOowmlOV" +
           "5rrur2FxSMLd0tiZ1rNR0I/lbakn9sr1GVwaYvXushIsWwQ5jMVe0+pna4Om" +
           "lIHG+PZk5a1CespthrMk3PRI4HB2EjpJZzwpz+NemtWbqNeZCO46rGEkQhCb" +
           "oJbyE95asKRo20Lqh1wXJxy8SvAWUeWzSruzDUvVdE3QQ2fOuzqPedSCKCld" +
           "dhlQDiPWJLNDz5caPR+a5dVabaHDjmz1lWgS+q7PoTUyJXse12qunAVd01c8" +
           "Yyf4aCK5IlpSHMKyFMeblulthCqek1TarDAv6T657QRzVxJ0QRaHDW01X1fU" +
           "VRA3MnWQNO11QqExIYoT3Fm0G5kyaSILMlhvZ2iiw7A4p6UMjjm/L6sS41uq" +
           "lqhNpgeQmo6x2qLH9ckVtsYxs9VXKkmz31zRLSYivFUFFidRXzNs0pRUTuw7" +
           "urKSQUHmyQHMt710rAhjswVXWvV6xaRGdWkjk+VWt+x3OB/elkc1Ph0lyaps" +
           "wFgoUCrWqVcb0XaFxGpni3CoWVr4tCqGA8I3eKupB2uVrJpbIzXSOey0CL5S" +
           "d2smjCyH/LqKrf1sxJp4mLbb3ZTuUfx6IkQzZMTLMNJoJFOpoTVjbC1tVl2P" +
           "mjjurMWx5saQNlZIZeXytCKS5LxnEQyOxX25P8blUsgJlDyk3TmipeUSYsqI" +
           "2KA9eNLqMdXqdDpNtkRlhsvIqh+UcQOpJIi67vVH3W7ZMDVppDtIeTnClcZs" +
           "LTbTDpJk9RlQZh7CdIdgq1PZ4uwWv84YDDUiy4x4vyqFmpihExhLp/pGm60w" +
           "sySElgdTYhsba1tV7TjzYD7PRFoZyXMbQTTRq00a5kofg4WxPly1qtk8VuwN" +
           "3Jgk24VY52dV2UwsPu4SaZnHqos0xVfdtNq1iLnFEOm8HRL1pueg23YY1UIY" +
           "kcUxnMD4eKJQQc0B0ElXnblXmuhaJpS7i77S23rpzOxRG9jebq3tZMk6wWDl" +
           "SYQ2xhqmuhSw5pCNp81sNRzPymOQz321IuIVJ5lOiBRestXuZAyX661xpVLR" +
           "tzCCxwqnoxrWoy0V87exuapirDYTkFV11pVin6BNzxXb6bAkLUWjN63MevYY" +
           "xp2mkhig2PH4BRkbMOrHyylM25sAUVp9VFL6XpkYo9ts2p9lXsASJZ8JptSK" +
           "cmCwNy6xUcu2UmaZ1EQ9xFJkMPdDdxj0yvFoikzJkaVvq30Cp4Yrp1XBJtSm" +
           "aZoqsSrr3JQxVLy8aA/IBTpm1Y3kNKuWpsAk1x8FJRSUx1MRaaC+tTFiMdmo" +
           "XjKNEL9laDKaTpL6KGPGM3oQmQs9xUxMZGs+WUEFGJuoKyJikj5P4G6geNya" +
           "7NenSs0tYd4YKaUe58DcQm8kIPZLAbcwOlVuisYKgsObmb2pN+pJaevK5XQ2" +
           "mwTNkMWDfm+KuTqHpitjyq22Nlzr9FZxEg4Me4Ksy2xzpiKibGVK0/eQloEh" +
           "5mZmBghQuVYF67qzkuHxLJyKc7RRx3HSq8psv4LBSY9yMGMtr9oOVkYWmpG1" +
           "lIGgMDKx0uUxa3KmHMxEUSjX8M14C6/dFVvrc5skHUttUqW1yQJ1hpY977aI" +
           "ROkwiCGn6txRGVIjADonUSbh+FxSLHsxr5JpLJBRV+uMyr5LpAlWEbV6nMZk" +
           "Ok7Zla1MGujKtvXxCJ6PuEEF6a6mYUaWSxRS2kyT5ZbmFzCipHx3tGRqU47t" +
           "D5e9VWtT410Z68iDUWlM2JE8Eaq+OQqsQVfjYCVkyQrukkMF58xx3W6zbbdU" +
           "ozpCXN3IGNHYkHZnLGoBxvIVfGP3go7IkLaH0dMVnAqogye4qg243hZz11W/" +
           "26rEowzRTXsiDtUNbBiNrWIvOMNdT6o03gZ1lxBFFjeZltfM3OwocIXMjCTl" +
           "tkpCpaFQKVeNMlEup2qNcQimr0VbqSaOFbOlBbIQNdL6sI6qsBlVSp2JKE8o" +
           "j2IVG4+HmoJt+31cHKjbljHehiox9nGhWcHms2RTabgNJJtEo9JA7Ay71XGs" +
           "rLFao8SJLVsKI1ztN0d9YrHUsdkKxvXQYpJKQPHA5RJZEyg6W3AMbJuuMBiG" +
           "7mLIbGw67HSIhqSPKbgshAkXwJk04Glio5tmzzU6rLD1HLBx4gejAbFGiaSZ" +
           "Sg3CZ8GKMyxVMq7SbVPsMOVUGWfhdWOF6B1sHoUDqoc7+nSb1LJsq8ikUUf1" +
           "kAbQy1HbBodkFC5uOqK+DaYM1QgGG7bsNgLe7sMlmaA1HVW6I3HuLad91MFi" +
           "ZUnqaq/siuTSZ5vkYr7t6gmewo2VEa5WDbfijXkewTvCULd8rTUCO5e35Fsa" +
           "8yfbVd5VbJaPLnR+im3yruuRvHn90ZFEcfBz6fDw//D35LHg8ZHQ0ZFa9WUP" +
           "xIvz7qvFGYsYBysnP7wC28sHbnbJU2wtP/n0s88ZwqfQvYNzuCdT6MLB3dtJ" +
           "JWLo8ZvvoXvFBdfx4dCXnv7X+4dvtZ/8Cc7CHzqj5FmRv9t7/ivtN+i/uQfd" +
           "cnRUdN3V22mmJ04fEF2KzXQZ+8NTx0QPHPnkntwFD4Bnc+CTzY3Po298RlTE" +
           "zy5qXuKM86mX6Htn3qxT6KJl7o7JDv3+xhv63fQtxzf3i3OV/WP6Ih43L7e7" +
           "P3X8mEL33/zi5FAJ9Ce+jQERc991d8C7e0v9s89dvvia5+S/KS4dju4Wb+eg" +
           "i7Ol65481DvxfiGMzZlTzNXtuyO+sPh5fwrddzPtUugW0BZGvG9H/esp9Oob" +
           "UQNK0J6kfCaFrpylTKHzxe9Jug+l0KVjOpA9u5eTJB8B0gFJ/vrR8HBK3/Dj" +
           "5fP63Ik8PICTwst3v5yXj1hO3mjkuVvc4B/m2XJ3h39N/9xzXf4dL9Y+tbtR" +
           "AX7cbnMpFznott3lzlGuPnJTaYeyLnQe++Gdn7/99YegcudO4eMMOqHbQze+" +
           "vmh5YVpcOGz/6DV/8Obffu6bxQnh/wHSqPQPWiEAAA==");
    }
    public class StyleDeclarationPaintValue extends org.apache.batik.css.dom.CSSOMSVGPaint implements org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected java.lang.String property;
        public StyleDeclarationPaintValue(java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGPaint.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return StyleDeclarationPaintValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      if (handler ==
                            null) {
                          throw new org.w3c.dom.DOMException(
                            org.w3c.dom.DOMException.
                              NO_MODIFICATION_ALLOWED_ERR,
                            "");
                      }
                      java.lang.String prio =
                        getPropertyPriority(
                          property);
                      CSSOMSVGStyleDeclaration.this.
                        handler.
                        propertyChanged(
                          property,
                          text,
                          prio);
                  }
              });
            property =
              prop;
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            return CSSOMSVGStyleDeclaration.this.
                     valueProvider.
              getValue(
                property);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "7Y4irrllP/59Rux/VnSx+dp/AYQ/BPqhFgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "505eSBw9vTw8P4KyneP9t7szyneNn/rAM88rzKeRnb1zNy2ELoau91OWulat" +
       "I6Ky3fsTt98hU/mV2eF50Jc/8M/38e8w3v0aDt4fPKHnSZG/Tb3w1e5b5I/u" +
       "QKcPToduusw7znT9+JnQJV8NI9/hj50M3X8ws/dkM/YYeBp7M9u49eH3rY+F" +
       "siqxXfsTx5qnDgkmOcH7X+Hc8xez4r0hdFn2VTFUWxyXH5Ltn8bce4vT10OC" +
       "3KOefLV9+7HTRiDydvcz2WHzvTddC2+vMuXPPX/lwj3Pj/8qv6I4uG68OIAu" +
       "aJFlHT2IO1I/5/mqZuZ2Xtwey3n536/tGXars+kQOg3KXPEPb6k/EkJvvBU1" +
       "oATlUcqPhtDVk5QhdDb/P0r3bAhdOqQLoXPbylGS54B0QJJVP+7tr8buaztQ" +
       "T04dj82DJbvr1ZbsSDg/eiwI88v9/YCJttf7N+TPP0/S73m59untPQwYP00z" +
       "KRcG0PntldBB0D18W2n7ss71Hv/h5S9cfGwfIC5vFT4MhSO6PXjrSw/c9sL8" +
       "miL9g3t+722/+fy38oO8/wGZJM48dSEAAA==");
}
