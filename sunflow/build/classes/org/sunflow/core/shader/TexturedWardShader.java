package org.sunflow.core.shader;
public class TexturedWardShader extends org.sunflow.core.shader.AnisotropicWardShader {
    private org.sunflow.core.Texture tex;
    public TexturedWardShader() { super();
                                  tex = null; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            tex =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  false);
        return tex !=
          null &&
          super.
          update(
            pl,
            api);
    }
    public org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
        return tex.
          getPixel(
            state.
              getUV(
                ).
              x,
            state.
              getUV(
                ).
              y);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wcRxmfO78fiV+J87STOE4ku+ld2/Sh1iGp48Sxwzk5" +
       "xakRF8hlbnfuvMne7mZ3zj67uI+gkoBECDRN06rNX6laoqSpEBVIpVUQgrZq" +
       "QeoDSkG0gJAIlIgGREENUL6Z2ffduco/nLSzczPffDPf6/d9s+evoBrLRN1E" +
       "ozE6YxArtl2jSWxaRB5SsWXthbG09GgV/vv+y7vujKLaFFo4ia0xCVtkWCGq" +
       "bKVQl6JZFGsSsXYRIrMVSZNYxJzCVNG1FFqsWKN5Q1UkhY7pMmEEE9hMoDZM" +
       "qalkCpSM2gwo6krASeL8JPHB8PRAAjVLujHjkS/1kQ/5Zhhl3tvLoqg1cRBP" +
       "4XiBKmo8oVh0oGiiGwxdncmpOo2RIo0dVG+zVbAzcVuJCnqea/no2onJVq6C" +
       "DqxpOuXiWXuIpatTRE6gFm90u0ry1mF0H6pKoCYfMUW9CWfTOGwah00daT0q" +
       "OP0CohXyQzoXhzqcag2JHYiiNUEmBjZx3maT5GcGDvXUlp0vBmlXu9IKKUtE" +
       "fOSG+MlH97d+pwq1pFCLoo2z40hwCAqbpEChJJ8hpjUoy0ROoTYNjD1OTAWr" +
       "yqxt6XZLyWmYFsD8jlrYYMEgJt/T0xXYEWQzCxLVTVe8LHco+19NVsU5kLXT" +
       "k1VIOMzGQcBGBQ5mZjH4nb2k+pCiyRStCq9wZez9LBDA0ro8oZO6u1W1hmEA" +
       "tQsXUbGWi4+D62k5IK3RwQFNipZXZMp0bWDpEM6RNPPIEF1STAFVA1cEW0LR" +
       "4jAZ5wRWWh6yks8+V3ZtOn6vNqJFUQTOLBNJZedvgkXdoUV7SJaYBOJALGzu" +
       "T5zCnS8eiyIExItDxILme1+6eveG7kuvCJoVZWh2Zw4Siaals5mFb6wc6ruz" +
       "ih2j3tAthRk/IDmPsqQ9M1A0AGE6XY5sMuZMXtrzk88/cI58EEWNo6hW0tVC" +
       "HvyoTdLzhqIScwfRiIkpkUdRA9HkIT4/iuqgn1A0IkZ3Z7MWoaOoWuVDtTr/" +
       "DyrKAgumokboK1pWd/oGppO8XzQQQnXwoGZ4GpH48TdFJD6p50kcS1hTND2e" +
       "NHUmPzOoJuM4JRb0ZZg19LhV0LKqPh23TCmumzn3v6SbJG5NYpmY8b0QRBAY" +
       "8uewKY/zoRhzN+P/tVGRSdwxHYmAMVaGoUCFKBrRVaBNSycLW7dffTb9mnAz" +
       "Fhq2rijqhz1j9p4xtmdM7Bkr3RNFInyrRWxvYXOw2CGIfQDf5r7xL+48cKyn" +
       "CpzNmK4GdTPSnkASGvIAwkH1tPS3nb/bODJ311tRFAUMyUAS8nLBal8uYEnM" +
       "1CUiw6Eq5QQHF+OVs0DZM6BLp6cfnLj/Jn4GP7gzhjWAS2x5kkGyu0VvOKjL" +
       "8W05evmji6fmdC+8A9nCSXIlKxlq9IQNGhY+LfWvxs+nX5zrjaJqgCKAX4oh" +
       "XADZusN7BNBjwEFiJks9CJzVzTxW2ZQDn4100tSnvRHuaW28vwhM28TCqQue" +
       "BXZ88Teb7TRYu0R4JvOVkBQc6T8zbjz5y5/9aSNXt5MUWnzZfJzQAR8QMWbt" +
       "HHLaPNfbaxICdL85nXz4kStH93G/A4q15TbsZe0QABCYENT80CuH333/vbNv" +
       "Rz1fpZCJCxkoaIqukNUOcFQSEnZb750HgEyFGGde03uPBl6pZBWcUQkLjn+3" +
       "rLv5+b8cbxV+oMKI40YbPp2BN75sK3rgtf3/7OZsIhJLpJ7OPDKBzh0e50HT" +
       "xDPsHMUH3+x67GX8JOA8YKulzBIOl4jrAHGj3crlj/N2Y2judtb0Wn7nD8aX" +
       "r+BJSyfe/nDBxIcvXeWnDVZMfluPYWNAuBdr1hWB/ZIwwIxgaxLobr206wut" +
       "6qVrwDEFHCUoE6zdJiBTMeAZNnVN3a9++KPOA29UoegwalR1LA9jHmSoAbyb" +
       "WJMAjkVjy93CuNP10LRyUVGJ8Eyfq8pbanveoFy3s99f8t1NT595jzuV8KIV" +
       "Lg6uDOAgr7K9MD731h0/f/qbp6ZFnu6rjF2hdUs/3q1mjvz+XyUK5qhVpoYI" +
       "rU/Fzz+xfGjzB3y9Bx9s9dpiaUYBgPXW3nIu/49oT+2Po6guhVolu6qdwGqB" +
       "BWUKKjnLKXWh8g3MB6syUYIMuPC4Mgxdvm3DwOVlMugzatZfEMIqVgagpQ5o" +
       "OW8/VkUQ7+zgS9bzto81GxxoqDNMBW4+JIQNTfMwpajKoV8KdVRJkrWzq4BJ" +
       "1t7BmhGx4q5yTimm1rOm3z0H/9WGCx0/Rnl+iFhodVWqRXkdffbIyTPy7qdu" +
       "Fp7YHqzvtsP15cIv/vN67PRvXy1TSDRQ3bhRJVNE9e0ZZVsGfH+Ml+meIzV+" +
       "5aaOBC1mS9M/49JdIcH3Vw6S8AYvH/nz8r2bJw9cR25fFVJSmOW3x86/umO9" +
       "9K0ov2kIvy25oQQXDQS9tdEkYH5tb8Bne1yzdjBzLYOnzTZrW/n8WsYj3KxV" +
       "aWkI36O2nWxP7S7xVK4aAhcmBnIOWaefbFy8B5Oj/FjSPBlEYc1+SLYFQ4aA" +
       "ClaI7EvCeCFjQZ2n5CHxT9l3nVuSB6Rjvck/CK9cVmaBoFv8TPzrE+8cfJ1b" +
       "up65kqtfnxsNmjlfTdMqFPcJ/CLw/Jc97LRsQNwZ2ofsi8tq9+ZiGCyU5gHq" +
       "kADxufb3Dz1x+YIQIIzKIWJy7OTXPokdPylCTFx/15bcQP1rxBVYiMMajZ1u" +
       "zXy78BXDf7w498Izc0ejtm0mAOgyuq4SrLm2i7gZbFFQ7eKs277a8oMT7VXD" +
       "UICOovqCphwukFE56Op1ViHjs4N3Y/Yc3z410zlFkX7DTp8cEtPzQGJpnmYD" +
       "W/hwyo0IHgAr7CTgJIPrDKZKS0Ou7qjLjpKukmBiFylFy7HPMIRv++V5guUo" +
       "a+6jqDFH6DYlmy1YxOG8xM9ZyeMcYUWJ/d2F6+3+69dbEZy99NbHap+lJd+Z" +
       "xLcR6dkzLfVLztzzDr+BuN8vmiH8sgVV9adnX7/WMElW4SI2i2Rt8NeJkFy+" +
       "2ygghujwo39D0D9MUWuYnqJq9vKTnaKoyUdGmUfynp/oMUjYQMS6jxuOlm+s" +
       "dDce1BRLp6ZuKJKnqGIkmGxdUyz+NFP48vPaAKjwr4BO1BXEd8C0dPHMzl33" +
       "Xr39KXF9klQ8O8u4NEGsiZucm8jWVOTm8Kod6bu28LmGdQ4ItIkDexGxwueQ" +
       "W8C3DeYPy0N3C6vXvWK8e3bTSz89VvsmwNc+FMEUdewrrfaKRgHqgn2JUkyB" +
       "JM8vPQN9j89s3pD96695OY1KqugwfVpq+Pj47BorEouihlFUA/hGirwM3Taj" +
       "7SHSlBkAqNqMXtDcj4ULmeNi9nWQa8VW5gJ3lF29KeopBeHSzxFwz5gm5lbG" +
       "3Qa8QNovGIZ/lmu1KNBPZJuqdGLMMJzs8wLXumHw+LzAmpn/ATSS/OXeFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
