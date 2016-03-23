package org.sunflow.core;
public class Geometry implements org.sunflow.core.RenderObject {
    private org.sunflow.core.Tesselatable tesselatable;
    private org.sunflow.core.PrimitiveList primitives;
    private org.sunflow.core.AccelerationStructure accel;
    private int builtAccel;
    private int builtTess;
    private java.lang.String acceltype;
    public Geometry(org.sunflow.core.Tesselatable tesselatable) { super();
                                                                  this.tesselatable =
                                                                    tesselatable;
                                                                  primitives =
                                                                    null;
                                                                  accel =
                                                                    null;
                                                                  builtAccel =
                                                                    0;
                                                                  builtTess =
                                                                    0;
                                                                  acceltype =
                                                                    null;
    }
    public Geometry(org.sunflow.core.PrimitiveList primitives) { super(
                                                                   );
                                                                 tesselatable =
                                                                   null;
                                                                 this.
                                                                   primitives =
                                                                   primitives;
                                                                 accel =
                                                                   null;
                                                                 builtAccel =
                                                                   0;
                                                                 builtTess =
                                                                   1;
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        acceltype =
          pl.
            getString(
              "accel",
              acceltype);
        if (tesselatable !=
              null) {
            primitives =
              null;
            builtTess =
              0;
        }
        accel =
          null;
        builtAccel =
          0;
        if (tesselatable !=
              null)
            return tesselatable.
              update(
                pl,
                api);
        return primitives.
          update(
            pl,
            api);
    }
    int getNumPrimitives() { return primitives == null ? 0
                               : primitives.
                               getNumPrimitives(
                                 ); }
    org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        if (primitives ==
              null) {
            org.sunflow.math.BoundingBox b =
              tesselatable.
              getWorldBounds(
                o2w);
            if (b !=
                  null)
                return b;
            if (builtTess ==
                  0)
                tesselate(
                  );
            if (primitives ==
                  null)
                return null;
        }
        return primitives.
          getWorldBounds(
            o2w);
    }
    void intersect(org.sunflow.core.Ray r, org.sunflow.core.IntersectionState state) {
        if (builtTess ==
              0)
            tesselate(
              );
        if (builtAccel ==
              0)
            build(
              );
        accel.
          intersect(
            r,
            state);
    }
    private synchronized void tesselate() { if (builtTess !=
                                                  0)
                                                return;
                                            if (tesselatable !=
                                                  null &&
                                                  primitives ==
                                                  null) {
                                                org.sunflow.system.UI.
                                                  printInfo(
                                                    org.sunflow.system.UI.Module.
                                                      GEOM,
                                                    "Tesselating geometry ...");
                                                primitives =
                                                  tesselatable.
                                                    tesselate(
                                                      );
                                                if (primitives ==
                                                      null)
                                                    org.sunflow.system.UI.
                                                      printError(
                                                        org.sunflow.system.UI.Module.
                                                          GEOM,
                                                        "Tesselation failed - geometry will be discarded");
                                                else
                                                    org.sunflow.system.UI.
                                                      printDetailed(
                                                        org.sunflow.system.UI.Module.
                                                          GEOM,
                                                        "Tesselation produced %d primitives",
                                                        primitives.
                                                          getNumPrimitives(
                                                            ));
                                            }
                                            builtTess =
                                              1;
    }
    private synchronized void build() { if (builtAccel !=
                                              0)
                                            return;
                                        if (primitives !=
                                              null) {
                                            int n =
                                              primitives.
                                              getNumPrimitives(
                                                );
                                            if (n >=
                                                  1000)
                                                org.sunflow.system.UI.
                                                  printInfo(
                                                    org.sunflow.system.UI.Module.
                                                      GEOM,
                                                    "Building acceleration structure for %d primitives ...",
                                                    n);
                                            accel =
                                              org.sunflow.core.AccelerationStructureFactory.
                                                create(
                                                  acceltype,
                                                  n,
                                                  true);
                                            accel.
                                              build(
                                                primitives);
                                        }
                                        else {
                                            accel =
                                              new org.sunflow.core.accel.NullAccelerator(
                                                );
                                        }
                                        builtAccel =
                                          1;
    }
    void prepareShadingState(org.sunflow.core.ShadingState state) {
        primitives.
          prepareShadingState(
            state);
    }
    org.sunflow.core.PrimitiveList getBakingPrimitives() {
        if (builtTess ==
              0)
            tesselate(
              );
        if (primitives ==
              null)
            return null;
        return primitives.
          getBakingPrimitives(
            );
    }
    org.sunflow.core.PrimitiveList getPrimitiveList() {
        return primitives;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUabWwcxXXu/O34O7HjfNhJHCetA7kLlECpaSAxDrn0nJzi" +
       "kIIDOHt7c76N93Y3u3P22ZAWkAKBqohA+GgF+dMgKAoEoaK2akGpEAUErQql" +
       "BdoC/ZKAUlSittCWtvS92d3bj7vdyBW2tOP1zHtv3nvzPmd94n1SY+iklyos" +
       "xmY0asSGFZYSdINmhmTBMHbD3Lh4T5Xw12ve2XFhlNSOkZacYIyIgkG3SlTO" +
       "GGOkR1IMJigiNXZQmkGMlE4Nqk8JTFKVMdIpGYm8JkuixEbUDEWAPYKeJO0C" +
       "Y7qULjCasAgw0pMETuKck/hm//JgkjSJqjbjgHe7wIdcKwiZd/YyGGlL7hem" +
       "hHiBSXI8KRlssKiTszRVnpmQVRajRRbbL2+0VLA9ubFMBX2PtX748e25Nq6C" +
       "hYKiqIyLZ+yihipP0UyStDqzwzLNGwfIV0hVkixwATPSn7Q3jcOmcdjUltaB" +
       "Au6bqVLID6lcHGZTqtVEZIiRVV4imqALeYtMivMMFOqZJTtHBmlXlqQ1pSwT" +
       "8a6z4kfvuabt8SrSOkZaJWUU2RGBCQabjIFCaT5NdWNzJkMzY6RdgcMepbok" +
       "yNKsddIdhjShCKwAx2+rBScLGtX5no6u4BxBNr0gMlUviZflBmX9VZOVhQmQ" +
       "tcuR1ZRwK86DgI0SMKZnBbA7C6V6UlIyjKzwY5Rk7P8SAABqXZ6ynFraqloR" +
       "YIJ0mCYiC8pEfBRMT5kA0BoVDFBnZGkgUdS1JoiTwgQdR4v0waXMJYBq4IpA" +
       "FEY6/WCcEpzSUt8puc7n/R0X3Xatsk2JkgjwnKGijPwvAKReH9IumqU6BT8w" +
       "EZvWJe8Wup48HCUEgDt9wCbMd687fcnZvaeeM2GWVYDZmd5PRTYuHk+3vLR8" +
       "aODCKmSjXlMNCQ/fIzn3spS1MljUIMJ0lSjiYsxePLXrx1de/zB9L0oaE6RW" +
       "VOVCHuyoXVTzmiRT/TKqUF1gNJMgDVTJDPH1BKmD96SkUHN2ZzZrUJYg1TKf" +
       "qlX536CiLJBAFTXCu6RkVftdE1iOvxc1QkgdPGQ9PG3E/OG/GRmO59Q8jWtS" +
       "PKWrKLoRh2CTBrXm4kZBycrqdNzQxbiqT5T+FlWdxi+jgMf0mRiak/ZpESoi" +
       "xwunIxFQ5nK/K8vgBdtUOUP1cfFoYcvw6UfHXzDNBE3bkpWRJbBFzNoihlvE" +
       "7C1IJMIpL8KtzCMCBU+Cq0KsbBoYvXr7vsN9VWAb2nQ1aCcKoH2enDHk+LMd" +
       "hMfFkx3Ns6vePOfpKKlOkg5BZAVBxhSwWZ+A4CJOWv7XlIZs4gT1la6gjtlI" +
       "V0WagZgSFNwtKvXqFNVxnpFFLgp2ykHnigcH/Ir8k1P3Tt+w56sboiTqjeO4" +
       "ZQ2EIERPYfQtRdl+v/9Wott68zsfnrz7oOp4sicx2PmsDBNl6POfvV894+K6" +
       "lcIT408e7Odqb4BIywTwDAhivf49PIFi0A66KEs9CJxV9bwg45Kt40aW09Vp" +
       "Z4YbZTt/XwRmsQA9ZyE8vZYr8d+42qXhuNg0YrQznxQ8qH9xVLv/tZ+++zmu" +
       "bjv+t7oS9yhlg66Yg8Q6eHRpd8x2t04pwL1xb+rOu96/eS+3WYBYXWnDfhyH" +
       "INbAEYKaDz134PW33jz+SrRk5xEGSbeQhtqlWBIS50ljiJCw21qHH4hZMvg8" +
       "Wk3/5QrYp5SVhLRM0bH+3brmnCf+fFubaQcyzNhmdPaZCTjzS7aQ61+45qNe" +
       "TiYiYs50dOaAmYF4oUN5s64LM8hH8YaXe77xrHA/hHQIo4Y0S3lkjJg64JJ3" +
       "Q21WFj12U8OgssCQHX60GznsBj6eh2rhFAhfuxCHNYbbRbxe6KqAxsXbX/mg" +
       "ec8HT53mMnlLKLdFjAjaoGmEOKwtAvnF/hC2TTByAHfeqR1XtcmnPgaKY0BR" +
       "hLrB2KlDyCx67MeCrqn71Y+e7tr3UhWJbiWNsipktgrcFUkD+AA1chBti9rF" +
       "l5gmMF1v540iKRO+bAKPYUXlAx7Oa4wfyez3Fn/nogePvcltUeMkesr9bL1l" +
       "gusr+xmOn8HhrHLrDUL1naDPBnrLbCClS3nwxilu0HzfRIgRjOBwKV/6Ag7D" +
       "pna++H8qEieGNHNhGZ+sxfToyUy8TXGC48M/v+AXDx65e9osdAaCM4IPr/tf" +
       "O+X0jb//R5lB8lxQoQjz4Y/FT9y3dGjTexzfCcqI3V8sT+mQ2Bzccx/O/z3a" +
       "V/tMlNSNkTbRagv2CHIBQ90YlMKG3StA6+BZ95a1Zg03WEo6y/0JwbWtPx04" +
       "pQS8IzS+N/syQBOey1p42i3zavdbZoTwlytN4+TjOhzW2wG3TtMlaB2pL+Iu" +
       "CCHKSBNzhSKcO9/xAG5oY2cytFGvDGvg6bC26wiQIe042FXlzAZhM9Ko2T7D" +
       "sbb7WBXnyOpnrWBgB4VKrEqhrAZhM1KDcVK2vX9tmfdvxmUs0cETRnm1ApWI" +
       "T579c5RnGTyLLI4WBcijh8oThA2qTxckmXGuvSUslomjhbTBSvHM7IvOTe0T" +
       "D/en/miGiyUVEEy4zofiX9/z6v4Xee1SjwXtbttFXOUqFL6uwqnN5PwT+InA" +
       "8198kGOcwN/gu0NWI7Sy1AlpGia5kLjlEyB+sOOtyfveecQUwB+kfMD08NFb" +
       "P4nddtQsSMx2enVZR+vGMVtqUxwcZpG7VWG7cIytb588+IOHDt5sctXhbQ6H" +
       "lUL+kV/+58XYvb99vkIXUyVZVyLu/AQlpfdsTIEuvaX1h7d3VG2FUjhB6guK" +
       "dKBAExlvMKszCmnXYTltuhPgLNHwYBiJrIMz8Nm4MUcbXwpPp2WlnQE2fmuo" +
       "jQdhM9LAbRxrM5yY8XH6tTly2gNPl7VXVwCnR0I5DcIGTnl0YXY7ARGmjZdF" +
       "mKti5hWMj/s7QrgvVqp3+E8t8XX3/npn2Zkq3V1UgUrRTJ9o4T1B1zTcuo/f" +
       "ePRYZucD50StqucGEJWp2nqZTlnB1NywASl5ipURfjHlZP43Wu74w/f7J7bM" +
       "pYPGud4z9Mj49wrwvHXBccTPyrM3/mnp7k25fXNohlf4tOQn+e2RE89ftla8" +
       "I8pv4cySpOz2zos06PXdRp1CxlG83rq6dPo8oS2BZ6N1+hv9FuzYV1ChHITq" +
       "q3Kj1sWIZUIVCmVUDWVUx0LZButyg42avzenEpytEyF19OM4PAjdaUHLQFbg" +
       "MNNW/MVf17ner4eaKq2qMhUUf9jEP28qOu710KdRjvP5b5UUiSRINzzDliKH" +
       "Q87AXw8SXxVYHUInRF1Ph6w9g8OTEHomKNtRyKc8tdmMo5un5kE3HB3vDxKW" +
       "TIkz2OepcnUEoYY3ct1uw8sLLBcbESDgFs/jO/4sRF+v4PACIy2gry+rupzZ" +
       "ohaUjGETXl5GmK9DKN+iuiztxXnQJl87F54rLJVcMXdtBqGGe/ui8oQhzNiL" +
       "fWWLCfxyYZg9P35lMS9Pfhei9Ldx+A2kEclGreTm1VOqlHF0/MY86BiDKRmA" +
       "Z5+lqH0hOvZ7cxRfr4ZuzZhRxJyuKtIszfg8vDuEdoiCPgpZ+ycOH2AOtppE" +
       "nivedRR1er4UtYbzb/4cmLOicPhbBfUEUQxWQaQmZK0OJ6GurcG6MeNVTYTM" +
       "l59ugOeQJcihENUE+GkQanjUKy/sRnMCxqaSF0Y6QjTVhUMzIws1nWqCTt3I" +
       "Pr21zIPeOmyTusUS/pa56y0INUTqVSFrq3FYDhqBZLBFgIZxwps/tzsa6Zkv" +
       "jfTBc8QS68jcNRKEGiJ1LGRtAw4DZjnhuRv1qWPdp3LzyUi9/QkPb5W7y77x" +
       "m9+lxUePtdYvPnb5q7yPKH07boKOIFuQZffNnuu9Fsw8K3EVNpn3fLzvjXwe" +
       "pPM7EiQf/IWMRi4wwQYZWeACY9ho8zc30Cbo5wEIXy/WbDd1dYFWy2V68DK3" +
       "Onjk7jyTFkso7k9A2Ovwf5qw+5KC+W8T4+LJY9t3XHv6/AfMT1CiLMzOIpUF" +
       "SVJnfg3jRLG3WRVIzaZVu23g45bHGtbYXWC7ybBjkctcOWoIopSGR7jU933G" +
       "6C99pnn9+EVP/eRw7ctREtlLIgJ43d7yu92iVoCmcm+y/DYE+kD+4Whw4Jsz" +
       "m87O/uXX/NsCMW9PlgfDj4tjd76WeGzyo0v4V/oaaHBpkV86Xzqj7KLilO65" +
       "WmlB6xKwd+d6sNTXXJrFD5ZQFJXfKpV/5m0EY6E6rx+RTDP0nc6MeRK+drCg" +
       "aT4EZ8Y6OhwP4TBbRO2D/Y0nRzTNvnSb1Lhv3VS5VUI73cVf8W30f3RWZGk/" +
       "JQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAK16e+zkxn3f3p3uTneSdafTw7JiSbZ8ci1vfNwHd5cLuanJ" +
       "fXK5XO6SXC6XbXPim9zla/lepkocF66dOHCcVE5dwNFfDpoGSmwECVK0SKE2" +
       "aB0jQYq0QdMWqB20BZrUNRAVSNLWbdwh9/fc391J1zOBmeXOfGfm+/nO9/ud" +
       "L2fmze+ULgZ+qey51la33PCWmoa3VlbjVrj11ODWaNyYin6gKh1LDAIWlN2W" +
       "X/zatT//7heM6+dLl4TSE6LjuKEYmq4T0GrgWrGqjEvXjkt7lmoHYen6eCXG" +
       "IhSFpgWNzSB8ZVx65ETTsHRzfMgCBFiAAAtQwQKEHlOBRu9Rncju5C1EJww2" +
       "pR8tnRuXLnlyzl5Y+uDpTjzRF+2DbqYFAtDDw/l/DoAqGqd+6QNH2HeYzwD+" +
       "Yhl6/e/98PVfvVC6JpSumQ6TsyMDJkIwiFB61FZtSfUDVFFURSg97qiqwqi+" +
       "KVpmVvAtlG4Epu6IYeSrR0LKCyNP9YsxjyX3qJxj8yM5dP0jeJqpWsrhv4ua" +
       "JeoA69PHWHcI+3k5AHjVBIz5miirh00eWpuOEpZe2G9xhPEmAQhA08u2Ghru" +
       "0VAPOSIoKN3YzZ0lOjrEhL7p6ID0ohuBUcLSs3ftNJe1J8prUVdvh6Vn9umm" +
       "uypAdaUQRN4kLD21T1b0BGbp2b1ZOjE/35l8/PM/4gyd8wXPiipbOf8Pg0bP" +
       "7zWiVU31VUdWdw0f/ej458Snf/Oz50slQPzUHvGO5jf+1tuf+MHn3/rtHc0P" +
       "3IGGklaqHN6WvyI99vvv77zcvpCz8bDnBmY++aeQF+o/Pah5JfWA5T191GNe" +
       "eeuw8i36Xy4/+Uvqt8+XruKlS7JrRTbQo8dl1/ZMS/UHqqP6YqgqeOmK6iid" +
       "oh4vXQbvY9NRd6WUpgVqiJcesoqiS27xH4hIA13kIroM3k1Hcw/fPTE0ivfU" +
       "K5VKl0EqfQyk66XdU/yGpR5kuLYKeSY09d0cegCpTigBsRpQEDma5SZQ4MuQ" +
       "6+tH/2XXV6GBCtqF/vZWrk7e96ujNOf4enLuHBDm+/dN2QJWMHQtRfVvy69H" +
       "WO/tX7n9O+ePVPsAa1h6Hxji1sEQt/Ihbh0OUTp3ruj5yXyo3RQBAa+BqQIn" +
       "9ujLzN8cvfrZFy8A3fCSh4B0zgNS6O6+tHNs3HjhwmSgYaW3vpT8OPdjlfOl" +
       "86edYs4eKLqaN5/mruzIZd3cN4Y79XvtM3/851/9udfcY7M45WUPrPVsy9za" +
       "XtwXpO/KqgL813H3H/2A+Ou3f/O1m+dLDwETBm4rFIGaAY/w/P4Yp6zulUMP" +
       "lmO5CABrrm+LVl516HauhobvJsclxQw/Vrw/DmT8SK6GT4D0/IFeFr957RNe" +
       "nj+504h80vZQFB7yrzLez/+73/uTeiHuQ2d67cTyxKjhKycMOO/sWmGqjx/r" +
       "AOurKqD7j1+a/t0vfuczf71QAEDxoTsNeDPPO8BwwRQCMX/6tzf//lvf/Mof" +
       "nD9SmnMhWMEiyTLl9AhkXl66eg+QYLQPH/MDHIAFDCjXmptzx3YVUzNFyVJz" +
       "Lf0/116q/vp///z1nR5YoORQjX7wnTs4Ln8fVvrk7/zwXzxfdHNOzhegY5kd" +
       "k+282hPHPaO+L25zPtIf/9fP/f2viz8P/CPwSYGZqYWbObeTQYH8qbD03BlT" +
       "ZNUgUC0xzNkpphYqaD9a5LdysRQ9lIq6ep69EJw0kdNWeCKcuC1/4Q/+9D3c" +
       "n/7TtwtMp+ORkxpBit4rOyXMsw+koPv37vuDoRgYgA5+a/I3rltvfRf0KIAe" +
       "ZbAIB5QP/E96Sn8OqC9e/g//7LeefvX3L5TO90tXLVdU+mJhiqUrwAbUwACu" +
       "K/X+2id2KpA8fOiE09IZ8EXBs2eN5GMH+vOxOxtJnn8wz146q3p3a7on/r0J" +
       "fP7MBE590wamFBfaWIz7iXvMYDfPXimq4Dz7+A5a611JYUf7TPHvCpiml+/u" +
       "i/t5UHXszp7535Qlfeo//c8zqlB44TvEEnvtBejNLz/b+aFvF+2P3WHe+vn0" +
       "7MoEAtDjtrVfsv/s/IuX/sX50mWhdF0+iG450YpyJyOAiC44DHlBBHyq/nR0" +
       "tgtFXjly9+/fd8Unht13xMcrInjPqfP3q3u+99Fcyh8G6fED3Xh8X63OlYqX" +
       "yU6zivxmnv2VQ1d32fPNGIQuB77ue+A5B9Jf5invLC/YBRo3OgfRzgeOwh0P" +
       "LNaPhiccQt5H5ViVC42h3klj8NN4XgLpxgGeG3fBw98FT/5KF0JiwtJV71DT" +
       "Czp0j6/lffL1kQMTPjTlO/F1+93wdTH3Q9ahgX74jIGieXUuYKDvTBENgJV+" +
       "j/lX75P5HwDpyQPmn7wL88a7EqoUmVZYsHhvgz5yM7vAHXrtxrfWX/7jX94F" +
       "7vvWu0esfvb1n/zerc+/fv7E59KHznyxnGyz+2QqmHxPwWm+KnzwXqMULfr/" +
       "9auv/ZNffO0zO65unA7+e+Db9pf/7f/93Vtf+qNv3CFKvQA+7PZmxbzPWXkW" +
       "pKcOZuWpu8xK8m5m5UoxK/nSnBd4e2yl98nWcyA9fcDW03dh60ffFVuFpoeH" +
       "oSPQ9uvFopt7x1u7b9c9Vn/sHVndze454Lou1m61bhXe5jN3ZuZC/voREM4F" +
       "xRYBaKGZjmgdcvfelSXfPHRqnOoHwN5urqxWXv239/hi3jVfQO8eOwY5dsHn" +
       "+ef+yxd+96c/9C2gQ6PSxThfJ4CynZDEJMp3LP7Om1987pHX/+hzRSQKJMl8" +
       "4tPuJ/Nev3AvdHn2uTz7qUNYz+awGDfyZXUsBiFZBI+qkiMrurBP4NmEIAR1" +
       "z8zCu0cbXv/FIRzg6OEznovSIpFTno8gqg5TreFKmxijYUcN0dZ6bPU6nsig" +
       "add3Ks4oM9c43qWGYUtuNSft+rIe1ae1moAu1iiBbVwDLQ/0flkhdQJ1e65I" +
       "1MT1wOuh854/21iY4nYggUDnFmOGYWcRxky7ptSlVStWttiiFlLTajYM47oT" +
       "Z1NbacNOlVmWzbW1dYPUXlbEgBn0hSWj4BPbsFmMHErd+tiA2QafVGuxWuP7" +
       "hjVhqLUgykt8i+vrQZ2xWGowoNZ0FSdHpm5OeGFmrwek1YMnmzUyYvsERyq4" +
       "N1jayGgdmWlPmnd7C3S6JNQRVeksW5v5eNURA1RPKh7ZYyNCXkOGDUEjfb1i" +
       "RpuVtNKHaivBFZlITEGBltvBwBq3DNU2hibG8DhC0FYQECYbZDTnePaMo8UV" +
       "TUvSuFaucGO0HUl9EuNr05BvwYhaa0w2zY6xJMwNvh0L5a1pmN60Mt8yYXeT" +
       "Jdl4Mkg0nKsY3NpME5SdMk5rVl/JlC0rq7kVihgaNaUNN8a7TUseDgR2E3I9" +
       "ATdpjoNNe4OO1WVImjFJ9qmNMGLDIWZbvLWZVT0mYRGxmcFrLY5EKUQYvxDm" +
       "aDGf1+gB1pmJ0grvd0S2MVEWk2y0JrNlk1Z0mVQ9yV1vJ0SgKLhirBijQyRo" +
       "Wiv7GCOPByHfcNxmBGMpNvErOmnNY1PQLMzm25xAccbMnoVyRFcFOiGQZlfH" +
       "KwxJCA4moa1Ok2vOLXy7IrJk2aDXrSnCoCi24YXm1un74sZy6SU+qtidpdlB" +
       "vJ6G0STbWKMVzOW6fcwRBmt9rjDVkWuyiT5TaDiuJCJPjpbYBsY9tN9bNqFF" +
       "R+55GTMPES+SWw5EV/g6L4bBujZa66vEIQbmaprEKEGrwzYe2Zt5E2ORpCfE" +
       "i5GKLCIPRoadeU/vhu2kI5FKE2lpsiPEoqqStcGCW3YFW2lMaXYZDdflejym" +
       "EZHqdgibWfEWOenMIA3PnHrgMVXSWs2BplYsZmUug1Sdjnk/rSoqlGHtccUV" +
       "e016wVFcZxhtXZ5jM9ukWYglNvN+VZ+MSL3LsaPudFjFCLvbbjLr+XBSEzLB" +
       "n4+WepUltI3FN+rNjjkeYWif5TtRk15zWqj0qiYVp3J1ttaV6WDWng7qPYga" +
       "QAPaphrtGbJahMyUWPjE2KWNWofFfN6G1wK2lf2NMslmqWRu2AZb7lsLJTXL" +
       "K53UKjZtimtI8HqMCzQ1cvC0P2s4BEQgsY4p4ZyaT6uy1neXcpw059qQz7oT" +
       "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" +
       "PUb4vgdF+CJIP3OA8Ge+rwhfvkddOc9u");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7ha5U5d09uC9dF9XcMLSw4e3J/OrYM+cuV69uxIs/8ob1x5+7xvzPywuEB5d" +
       "270yLj2sRZZ18jbKifdLQN00s0B9ZXc3xSug1ACKfYUGrjX/yTk8V92RNcLS" +
       "IyfIQMBy8HaSCAlLFwBR/tr2Ds3lxOnpQQB87kQMWzqx6N14J2kdNTl5YTCP" +
       "e4v76ocxarS7sX5b/uobo8mPvN38hd2FRdkSsyzv5eFx6fLu7uRRnPvBu/Z2" +
       "2Nel4cvffexrV146jMkf2zF8rGEneHvhzrcDe7YXFvf5sn/03l/7+D9445vF" +
       "8fH/AxyXMFFIMAAA");
}
