package org.apache.batik.extension.svg;
public class FlowExtTextNode extends org.apache.batik.gvt.TextNode {
    public FlowExtTextNode() { super();
                               textPainter = org.apache.batik.extension.svg.FlowExtTextPainter.
                                               getInstance(
                                                 ); }
    public void setTextPainter(org.apache.batik.gvt.TextPainter textPainter) {
        if (textPainter ==
              null)
            this.
              textPainter =
              org.apache.batik.extension.svg.FlowExtTextPainter.
                getInstance(
                  );
        else
            this.
              textPainter =
              textPainter;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO9vnD4y/CIaaYMAcKDjJbVE+UGtaAo4dTM/2" +
                                                              "ySZINWmOud053+K93WF37nx26hIipaD8gaJgUloV/0XUNiIhihK1UhTkqFKT" +
                                                              "KE0jaNTmQ01a9Y+mH0jhn9CKtumbmb3bvb07p/2nlm5vb+bNe/Pe+83vvfHF" +
                                                              "a6jBsVEfxaaGY2yOEieW4O8JbDtEGzSw4xyE0aT6xB/OHL/x6+YTYRSZQm0Z" +
                                                              "7Iyq2CHDOjE0Zwpt1E2HYVMlzhghGl+RsIlD7DxmumVOobW6M5Klhq7qbNTS" +
                                                              "CBc4hO046sSM2Xoqx8iIq4ChTXGxG0XsRtkbFBiIo1bVonPegp6yBYO+OS6b" +
                                                              "9ew5DHXEj+I8VnJMN5S47rCBgo1up5YxN21YLEYKLHbUuMcNxIH4PRVh6Huh" +
                                                              "/bObT2Y6RBjWYNO0mHDRmSCOZeSJFkft3uiQQbLOMfQdVBdHq3zCDEXjRaMK" +
                                                              "GFXAaNFfTwp2v5qYueygJdxhRU0RqvINMbSlXAnFNs66ahJiz6Chibm+i8Xg" +
                                                              "7eaSt8V0B1w8e7uy+L2HO16sQ+1TqF03J/l2VNgEAyNTEFCSTRHb2atpRJtC" +
                                                              "nSYkfJLYOjb0eTfbXY4+bWKWAwgUw8IHc5TYwqYXK8gk+GbnVGbZJffSAlTu" +
                                                              "r4a0gafB127PV+nhMB8HB1t02JidxoA9d0n9jG5qAkflK0o+Rr8BArC0MUtY" +
                                                              "xiqZqjcxDKAuCREDm9PKJIDPnAbRBgsgaAus1VDKY02xOoOnSZKh9UG5hJwC" +
                                                              "qWYRCL6EobVBMaEJstQTyJIvP9fGdp9+xNxvhlEI9qwR1eD7XwWLegOLJkia" +
                                                              "2ATOgVzY2h9/Gne/eiqMEAivDQhLmZ9++/p9d/QuvyFlNlSRGU8dJSpLqhdS" +
                                                              "bVduHdzxlTq+jSZqOTpPfpnn4pQl3JmBAgWm6S5p5JOx4uTyxC+++eiz5K9h" +
                                                              "1DKCIqpl5LKAo07VylLdIPYDxCQ2ZkQbQc3E1AbF/AhqhPe4bhI5Op5OO4SN" +
                                                              "oHpDDEUs8RtClAYVPEQt8K6baav4TjHLiPcCRQg1wge1wqcPyT/xzZClZKws" +
                                                              "UbCKTd20lIRtcf95QgXnEAfeNZillpIC/M/cuTO2S3GsnA2AVCx7WsGAigyR" +
                                                              "k/ycEtMBjxUnPw0YtmaHCuwgjI4BTcU48Oj/32SBR2HNbCgECbo1SA8GnKz9" +
                                                              "lqERO6ku5vYNXX8++ZaEHj8ubvwYioHdmLQbE3ZjJbsxsBsL2EWhkDB3C7cv" +
                                                              "sQCZnAFOAFJu3TH5rQNHTvXVAQjpbD2kgYturyhSgx55FBk/qV68MnHjnbdb" +
                                                              "ng2jMPBLCoqUVymiZZVCFjrbUokGVFWrZhR5U6ldJaruAy2fmz1x6PiXxT78" +
                                                              "5M8VNgBv8eUJTtklE9Hgoa+mt/3kJ59denrB8o5/WTUpFsGKlZxV+oLJDTqf" +
                                                              "VPs345eTry5Ew6geqAromWE4TsB8vUEbZewyUGRq7ksTOJy27Cw2+FSRXltY" +
                                                              "xrZmvRGBuk7xfgukeBU/bj3wibrnT3zz2W7Kn+skSjlmAl6ISvC1SXr+vV/9" +
                                                              "+S4R7mLRaPdV+0nCBnxExZV1CUrq9CB40CYE5H53LnHm7LWThwX+QGJrNYNR" +
                                                              "/hwEgoIUQpgff+PY+x9/dOHdsIdZBpU6l4Kmp1Byko+jlhWc5Dj39gNEZ8DJ" +
                                                              "56iJPmgCKvW0jlMG4Yfkn+3bdr78t9MdEgcGjBRhdMcXK/DGv7QPPfrWwzd6" +
                                                              "hZqQygutFzNPTLL3Gk/zXtvGc3wfhRNXN37/dXwe6gBwr6PPE0GnSMQAiaTd" +
                                                              "LfxXxPOuwNy9/BF1/OAvP1++hiipPvnup6sPfXr5uthteUflz/UopgMSXvyx" +
                                                              "rQDq1wWJZj92MiB39/LYQx3G8k3QOAUaVaBQZ9wGtiuUIcOVbmj84LWfdx+5" +
                                                              "UofCw6jFsLA2jMUhQ82AbuJkgCgLdM99MrmzTfDoEK6iCud5PDdVz9RQljIR" +
                                                              "2/mfrXtp94+WPhKgkija4C4XP7bzR38JXeIvEixhfnSVabDRxlpdhuiQLjy2" +
                                                              "uKSNP7NT9gJd5ZV7CBrT537zr1/Gzv3+zSrloJlZ9E6D5Inhs8lZfEsFi4+K" +
                                                              "JsxjoF1Xb9R9+NT61koC55p6a9Bzf216Dhp4/bG/9Bz8eubI/8DMmwKBCqr8" +
                                                              "yejFNx/Yrj4VFn2kJOWK/rN80YA/ZGDUJtAwm9wtPrJawLevnB13wec2N7W3" +
                                                              "VWfHKqgocU6tpYHTGXJzxX+vZ2hzRWGfzrMYr+MJLFpvYXlihSN+iD9GGWqD" +
                                                              "dsy3DsCwY4Wbl61ngajzbu+qLHR9PPPDT56TWAw2ugFhcmrxic9jpxclLuVt" +
                                                              "YGtFQ+5fI28EYrcdMnCfw18IPv/mH+4KH5AdYdeg25ZuLvWllBYEtlfYljAx" +
                                                              "/KdLC6/8eOFk2A3NEEP1eUuXV5Bd/DEmT/ZX/zsO4QN7CkB+gfaKk8v6ioue" +
                                                              "vJyozy+1N61bevC3osSXLhCtUBzTOcPwYdKPzwi1SVoXm26V1ErFVxo6g5Vb" +
                                                              "P4bq4Cn2TuQaHe5RtdcAeZTe/avgSHUEVzHUIL79chZDLZ4cFGH54heBdqYO" +
                                                              "RPirQ4tA31gT6DyihVAl/YqErf2ihPn4dmsZ3sV9vUgoOXljT6qXlg6MPXL9" +
                                                              "3mdkIwM3/fl5cb+D66rsqUqktKWmtqKuyP4dN9teaN5WhFun3LBHFRt8x3QP" +
                                                              "HHrKgdMTqPJOtFTs37+w+/LbpyJX4WQdRiHM0JrDvtuyvBpCq5ADxjwc9zO9" +
                                                              "778+ogEZaPnjkXf+/kGoS5Q2tzb0rrQiqZ65/GEiTekPwqh5BDXAaSKFKbj+" +
                                                              "O/fPmRNEzUMRbsqZ+rEcGdEArykrZ5au9m0c5Zjf5UVk3ICuLo3yRpihvkqO" +
                                                              "qLwcQNWfJfY+rl0QdYDGc5T6Zwv8ylvFK8jNzvP/OP7d98bhFJZt3K+t0cml" +
                                                              "ShXB/58Dr0R08MdDBclMdcn4KKUuU0XOiqxSKljipHD6cSnNJRgK9VP6H4Ez" +
                                                              "HhgBFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL05a8wkWVU13+w8d9mZXWBZR/Y9ILsFX/WrqrschO2qrn5W" +
       "d1V3V1d3l8JQ76ruenW9u3EViLoE4kp0QUxgf0FUsjxiJJoYzBqjQCAmGOIr" +
       "EYgxEUUS9odoRMVb1d+zZ2YJMbGTun3r3nPOPeeexz331Ivfhc4FPgR7rrXW" +
       "LTfcV9Nwf2Gh++HaU4P9Lo2yoh+oCmmJQcCBsZvy45+78v0ffMi4ugedF6BX" +
       "i47jhmJouk4wUgPXilWFhq4cj1KWagchdJVeiLGIRKFpIbQZhDdo6O4TqCF0" +
       "nT5kAQEsIIAFJGcBqR9DAaRXqU5kkxmG6ITBCvoF6AwNnffkjL0Qeuw0EU/0" +
       "RfuADJtLAChczN55IFSOnPrQo0eyb2W+ReAPw8jzv/nOq793FroiQFdMZ5yx" +
       "IwMmQrCIAN1jq7ak+kFdUVRFgO5zVFUZq74pWuYm51uA7g9M3RHDyFePNikb" +
       "jDzVz9c83rl75Ew2P5JD1z8STzNVSzl8O6dZog5kfeBY1q2EzWwcCHjZBIz5" +
       "miirhyh3LU1HCaFHdjGOZLzeAwAA9YKthoZ7tNRdjggGoPu3urNER0fGoW86" +
       "OgA950ZglRC6dkei2V57orwUdfVmCD24C8dupwDUpXwjMpQQeu0uWE4JaOna" +
       "jpZO6Oe7g7c+926n7ezlPCuqbGX8XwRID+8gjVRN9VVHVreI9zxFf0R84Avv" +
       "34MgAPzaHeAtzB/8/MtPv/nhl760hfnJ28Aw0kKVw5vyJ6R7v/Z68kn8bMbG" +
       "Rc8NzEz5pyTPzZ89mLmResDzHjiimE3uH06+NPrz+Xs+pX5nD7rcgc7LrhXZ" +
       "wI7uk13bMy3Vb6mO6ouhqnSgS6qjkPl8B7oA+rTpqNtRRtMCNexAd1n50Hk3" +
       "fwdbpAES2RZdAH3T0dzDvieGRt5PPQiCLoAHugc8j0PbX/4fQi5iuLaKiLLo" +
       "mI6LsL6byZ8p1FFEJFQD0FfArOciErD/5VuK+1UkcCMfGCTi+joiAqsw1O1k" +
       "5qeqEwCJkSDWgQ27CZWGHBgduIq6nxme9/+/ZJrtwtXkzBmgoNfvhgcLeFbb" +
       "tRTVvyk/HxHUy5+5+ZW9I3c52L8Q2gfr7m/X3c/X3T9adx+su7+zLnTmTL7c" +
       "a7L1t7YANLkEMQFEy3ueHL+j+673P34WGKGX3AXUkIEidw7a5HEU6eSxUgam" +
       "DL300eS9/C8W9qC909E34xkMXc7Q2SxmHsXG67tedzu6V5799vc/+5Fn3GP/" +
       "OxXOD8LCrZiZWz++u7u+K6sKCJTH5J96VPz8zS88c30PugvEChAfQxHYMwg9" +
       "D++uccq9bxyGykyWc0BgzfVt0cqmDuPb5dDw3eR4JFf7vXn/PrDHd2f2fg08" +
       "1w8cIP/PZl/tZe1rtmaSKW1HijwU/8zY+/jf/MU/l/PtPozaV06cg2M1vHEi" +
       "UmTEruQx4b5jG+B8VQVwf/9R9jc+/N1nfzY3AADxxO0WvJ61JIgQQIVgm3/5" +
       "S6u//eY3PvH1vWOjCcFRGUmWKadHQmbj0OVXEBKs9sZjfkCksYDrZVZzfeLY" +
       "rmJqpihZamal/3XlDcXP/+tzV7d2YIGRQzN6848mcDz+EwT0nq+8898fzsmc" +
       "kbOT7njPjsG24fPVx5Trvi+uMz7S9/7lQ7/1RfHjIBCD4BeYGzWPZ1C+B1Cu" +
       "NCSX/6m83d+ZK2bNI8FJ4z/tXycykpvyh77+vVfx3/vjl3NuT6c0J3XdF70b" +
       "W/PKmkdTQP51u57eFgMDwFVeGvzcVeulHwCKAqAogxgWMD4IN+kpyziAPnfh" +
       "7/7kTx9419fOQntN6LLlikpTzJ0MugSsWw0MEKlS7+1Pb5WbXATN1VxU6Bbh" +
       "t0bxYP52FjD45J3jSzPLSI5d9MH/ZCzpff/wH7dsQh5ZbnMQ7+ALyIsfu0a+" +
       "7Ts5/rGLZ9gPp7eGYJC9HeOWPmX/297j5/9sD7ogQFflg9SQF60ocxwBpEPB" +
       "Yb4I0sdT86dTm+05fuMohL1+N7ycWHY3uByHftDPoLP+5ZPx5IfgdwY8/5M9" +
       "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");
}
