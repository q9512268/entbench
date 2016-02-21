package org.sunflow.core.filter;
public class GaussianFilter implements org.sunflow.core.Filter {
    private float s;
    private float es2;
    public GaussianFilter(float size) { super();
                                        s = size;
                                        es2 = (float) -java.lang.Math.exp(
                                                                        -s *
                                                                          s);
    }
    public float getSize() { return s; }
    public float get(float x, float y) { float gx = (float) java.lang.Math.
                                                      exp(
                                                        -x *
                                                          x) + es2;
                                         float gy = (float) java.lang.Math.
                                                      exp(
                                                        -y *
                                                          y) + es2;
                                         return gx * gy; }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfYxUVxW/M7s7+8l+Acv3AstCspTOtNBK6yItLCy7dBYm" +
                                                              "LCV2UYY7b+7sPnjz3uO9+3Znt10tJJbVRMQKlJqWv2haCS2NsdFE22CMtk2r" +
                                                              "ST+0VmOrxkS0EovGaopaz7l3Zt7HzCzhHyeZO2/uPffc8/k7576LV0mNbZFO" +
                                                              "pvMonzSZHd2u8wS1bJbu06ht74W5pPJYFf37gSu77g6TyAhpHqP2kEJt1q8y" +
                                                              "LW2PkGWqbnOqK8zexVgadyQsZjNrnHLV0EfIfNUezJqaqqh8yEgzJNhHrThp" +
                                                              "o5xbasrhbDDPgJNlcZAkJiSJbQku98ZJk2KYky75Qg95n2cFKbPuWTYnrfFD" +
                                                              "dJzGHK5qsbhq896cRW4xDW1yVDN4lOV49JB2Z94EO+N3lpig6/mWj66fHGsV" +
                                                              "JphLdd3gQj17D7MNbZyl46TFnd2usax9hHyBVMVJo4eYk+544dAYHBqDQwva" +
                                                              "ulQg/RymO9k+Q6jDC5wipoICcbLSz8SkFs3m2SSEzMChjud1F5tB2xVFbaWW" +
                                                              "JSqeviV26rEDrd+uIi0jpEXVh1EcBYTgcMgIGJRlU8yyt6TTLD1C2nRw9jCz" +
                                                              "VKqpU3lPt9vqqE65A+4vmAUnHZNZ4kzXVuBH0M1yFG5YRfUyIqDy/2oyGh0F" +
                                                              "XTtcXaWG/TgPCjaoIJiVoRB3+S3Vh1U9zcny4I6ijt33AQFsrc0yPmYUj6rW" +
                                                              "KUyQdhkiGtVHY8MQevookNYYEIAWJ4srMkVbm1Q5TEdZEiMyQJeQS0BVLwyB" +
                                                              "WziZHyQTnMBLiwNe8vjn6q5NJx7UB/QwCYHMaaZoKH8jbOoMbNrDMsxikAdy" +
                                                              "Y9Pa+Bna8eJMmBAgnh8gljTffejaves6L78iaZaUodmdOsQUnlTOp5rfWNrX" +
                                                              "c3cVilFnGraKzvdpLrIskV/pzZmAMB1FjrgYLSxe3vOTBx6+wD4Ik4ZBElEM" +
                                                              "zclCHLUpRtZUNWbtYDqzKGfpQVLP9HSfWB8ktfAcV3UmZ3dnMjbjg6RaE1MR" +
                                                              "Q/wHE2WABZqoAZ5VPWMUnk3Kx8RzziSE1MKX3ArfGiI/4pcTGhszsixGFaqr" +
                                                              "uhFLWAbqjw7V0zTGmQ3PaVg1jZjt6BnNmIjZlhIzrNHif8WwWAykgAiK7aCO" +
                                                              "batU7xd/oxhq5v/jkBxqOnciFAInLA1CgAbZM2BoaWYllVPO1u3Xnku+JsML" +
                                                              "UyJvI07WwHnR/HlRPC8qz4v6zyOhkDhmHp4r/QxeOgz5DoDb1DP8+Z0HZ7qq" +
                                                              "IMDMiWowMZJ2+QpPnwsKBSRPKn/b+bsNA9OffitMwoAbKSg8Lv6v8OA/Fi7L" +
                                                              "UFga4KdSHShgYawy8peVgVw+O3F03xdvEzJ4AR0Z1gAW4fYEwnDxiO5gIpfj" +
                                                              "23L8ykeXzkwbbkr7KkShsJXsRKToCjozqHxSWbuCvpB8cbo7TKoBfgByOYUU" +
                                                              "ATTrDJ7hQ4zeAvqiLnWgcMawslTDpQJkNvAxy5hwZ0SUtYnneeDaRkyhRfCt" +
                                                              "z+eU+MXVDhPHBTIqMVYCWgh0/8yw+eQvf/anDcLchULQ4qngw4z3esAHmbUL" +
                                                              "mGlzQ2+vxRjQ/eZs4hunrx7fL+IOKFaVO7Abxz4AHXAhmPlLrxx59/33zr8d" +
                                                              "dmOVQ/V1UtDE5IpK4jxpmEVJOG2NKw+Alwa5jVHTfb8OUalmVJrSGCbHv1tW" +
                                                              "3/7CX060yjjQYKYQRutuzMCdX7SVPPzagX92CjYhBYunazOXTCLyXJfzFsui" +
                                                              "kyhH7uibyx5/mT4J2A54aqtTTEBkqFy+Yi837KRsyDo1C24Yz1eb9YmDykx3" +
                                                              "4g+ykiwqs0HSzX8m9tV97xx6XTi5DvMa51HvOZ6s3WKNeiKsVRr/E/iE4Ptf" +
                                                              "/KLRcUKidntfvnSsKNYO08yB5D2zNHt+BWLT7e8ffuLKs1KBYG0NELOZU1/5" +
                                                              "JHrilPScbEBWlfQA3j2yCZHq4HAXSrdytlPEjv4/Xpr+/jPTx6VU7f5yuh26" +
                                                              "xWd/8Z/Xo2d/+2oZ/IYUMqhsIzf43DnP7x2p0rYvt/zgZHtVP6DGIKlzdPWI" +
                                                              "wwbTXp7QQdlOyuMut7URE17l0DWchNaCF8T0HUKMWFEYIoQhYm0HDt22Fzz9" +
                                                              "zvI0yUnl5Nsfztn34UvXhML+LtuLFUPUlNZuw2E1WntBsEANUHsM6O64vOtz" +
                                                              "rdrl68BxBDgq0Frauy2ojjkfsuSpa2p/9cMfdRx8o4qE+0kDWDjdTwVIk3pA" +
                                                              "R2aPQWHNmffcK8Fhog6GVqEqKVEe83F5+UzfnjW5yM2p7y34zqanz70nQEmi" +
                                                              "0BKxPYyV3VdHxc3MLQMX3tr486e/fmZChs4siRDYt/Dj3Vrq2O//VWJgUfXK" +
                                                              "5EZg/0js4hOL+zZ/IPa75Qd3r8qVdiNQoN296y9k/xHuivw4TGpHSKuSvwnt" +
                                                              "o5qDoD4C3b9duB7Bbcm37u/kZdvaWyyvS4PJ6Tk2WPi8EV/NfdHt1rom9CA+" +
                                                              "RPJlIBKsdSEiHj4rtqwRYw8O6wqlpda0VLgts0BtaZyFKaSUIN4oCymOAzg8" +
                                                              "IHncVzHs9vgF7yh0wIXfMoJTKTgO+0slrLSbkypmry8nY2oWGXPuWWuLZxUt" +
                                                              "4GvRvZXWzQZploWcLChpWmWXigCwrNItS0Dt+WOnzqV3P3V7OA9L93DIaMO8" +
                                                              "VWPjTAsk3jJf4g2Je6UbxQ2P3DY3znOZ0t4VuXRW6E7XVs7Q4AEvH/vz4r2b" +
                                                              "xw7eRGO6PKB7kOW3hi6+umON8mhYXI1l0pRcqf2bev2p0mAx7li6vxx0Fb3Z" +
                                                              "hs5bCN/mvDebyzeHZQKh2HJV2jpLcZmaZe0hHBxIxFHGh6HrEVHrBuz4jZLK" +
                                                              "h+U4kRDTR/w640N7XvD2m9e50taAXmEZm8XE2yhYPzKL9jM4HIV8Be0Dmh+7" +
                                                              "ec1znDT774VY3RaWvH2Sb0yU58611C04d/874o5SfKvRBC1hxtE0LwB7niOm" +
                                                              "xTKqEL5JwrEpfr5WLu3lXZXj+yV8EGKfkPSPctIapOekGn+8ZKc5afSQcWx/" +
                                                              "xJOX6CwYEIjw8XGzAEKtoqhjIYrKQpQLeQAkj3bC0vNvZOniFu8dBgFCvP4r" +
                                                              "JLMjXwAmlUvndu568NqnnpJ3KEWjU1PIpRF6N3mdKwLCyorcCrwiAz3Xm5+v" +
                                                              "X10AxDYpsBuySzzRlAAMNtHliwMXDLu7eM949/yml346E3kTOoP9JEQ5mbu/" +
                                                              "tGTnTAfwdX+8tEcFsBQ3n96eb05uXpf5669FT0RkT7u0Mn1Sqf/4xNRKOxQN" +
                                                              "k/pBUgNYz3Kil9g2qe9hyrjla3gjKcPRi28JmzE2Kb4WFFbJG3NOcRbv35x0" +
                                                              "lfb+pe8koFmcYNZW5C4AMgCfjml6V4VV+3C4K4dWhjhLxodMs3DpEdffhGmK" +
                                                              "9LuIw7b/AdBtMAHXFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ws4GE2FCrgc9sNu1NgSRfT45r+yz7s78C/bgtgp8zWUd117Bl9u266GseMPB" +
       "p/5ByuHYDcfR/Ohh+ufU/tfy3dfl/LdJ/iyBdd9LXVLlmbpPPfH0s/Lg06Wd" +
       "vbQaFkDnA8d9i6lEinlkqh3A6dGXzjT18ju6w3TPl5/4p3unb9Pe8wpS/w+c" +
       "kPMky9/qPffV9hulX9yBTh8kf667PTw+6LHjKZ8LnhKEnj09lvi578DyufXv" +
       "Ac/FPctfPJlkOVzbG2dY3rT1jZtkLZ+8Sd/PZ8UTAXRuqQQTPc1lRA496Wde" +
       "LgdwlF/e8L7jqmU5rSt7ql35v1FtZ+sbB8kkJKf66E2UfCYrngqg00DJEwp+" +
       "+JUoGAfQxeMXWll2/p7rrs23V73S5569dOvdz87+Mr/TObiOPc9At6qhaR5N" +
       "Cx6pn3U9RdVzsc9vk4Ru/vOJGwXc9pItyC7Gs0ou8K9s6X81gC6fpA+gW7Kf" +
       "o2S/FkC3HSEDjrBXO0r0aWA6QJRVf929QbJsmx6NTx0J3T1vyG185eVsfDDk" +
       "6J1PFu75/y3sh2a4/c+Fa9Lnn+323/tC9dPbOyfJFNI043IrA53bXn8dhPdD" +
       "L8ltn9dZ6pEXL37h/Bv2oejiVuBDzzwi2wM3vuAhLTfIr2TS37v7d976G89+" +
       "K8/d/TePkxaqUCIAAA==");
}
