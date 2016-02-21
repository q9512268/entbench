package org.sunflow.image;
public class RegularSpectralCurve extends org.sunflow.image.SpectralCurve {
    private final float[] spectrum;
    private final float lambdaMin;
    private final float lambdaMax;
    private final float delta;
    private final float invDelta;
    public RegularSpectralCurve(float[] spectrum, float lambdaMin, float lambdaMax) {
        super(
          );
        this.
          lambdaMin =
          lambdaMin;
        this.
          lambdaMax =
          lambdaMax;
        this.
          spectrum =
          spectrum;
        delta =
          (lambdaMax -
             lambdaMin) /
            (spectrum.
               length -
               1);
        invDelta =
          1 /
            delta;
    }
    public float sample(float lambda) { if (lambda < lambdaMin ||
                                              lambda >
                                              lambdaMax) return 0;
                                        float x = (lambda - lambdaMin) *
                                          invDelta;
                                        int b0 = (int) x;
                                        int b1 = java.lang.Math.min(
                                                                  b0 +
                                                                    1,
                                                                  spectrum.
                                                                    length -
                                                                    1);
                                        float dx = x - b0;
                                        return (1 - dx) * spectrum[b0] +
                                          dx *
                                          spectrum[b1]; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZeWxcRxmfXR/xlfjIWTen7UQ4TXZ7UopDiONcDuvEitNI" +
                                                              "dUqc2bez9kvevvf63qy9TkmPSBAXiRAgSQNK/A8pSaMcVUU4RFOCEGmrhoqm" +
                                                              "hVIqGooQFEpFA6KgBijfN7Pv3F1HBbWW3ry3M99833zHfN9vxqfeJhW2ReYy" +
                                                              "ncf4qMns2Gqd91LLZqkujdr2ZugbUB4to3/b9uaGu6Kksp9MGaJ2j0JttkZl" +
                                                              "WsruJ3NU3eZUV5i9gbEUzui1mM2sYcpVQ+8n01W7O2NqqqLyHiPFkGALtRKk" +
                                                              "kXJuqcksZ915BpzMScBK4mIl8c7wcEeC1CmGOeqRz/KRd/lGkDLjybI5aUjs" +
                                                              "oMM0nuWqFk+oNu/IWeQm09BGBzWDx1iOx3Zod+RNsD5xR4EJWp6of/fa/qEG" +
                                                              "YYKpVNcNLtSzNzHb0IZZKkHqvd7VGsvY95EHSFmC1PqIOWlLOELjIDQOQh1t" +
                                                              "PSpY/WSmZzNdhlCHO5wqTQUXxMmCIBOTWjSTZ9Mr1gwcqnhedzEZtJ3vaiu1" +
                                                              "LFDx4E3xA49ua3iyjNT3k3pV78PlKLAIDkL6waAsk2SW3ZlKsVQ/adTB2X3M" +
                                                              "Uqmm7sp7uslWB3XKs+B+xyzYmTWZJWR6tgI/gm5WVuGG5aqXFgGV/1WR1ugg" +
                                                              "6DrD01VquAb7QcEaFRZmpSnEXX5K+U5VT3EyLzzD1bHtM0AAUydlGB8yXFHl" +
                                                              "OoUO0iRDRKP6YLwPQk8fBNIKAwLQ4qS5JFO0tUmVnXSQDWBEhuh65RBQVQtD" +
                                                              "4BROpofJBCfwUnPISz7/vL1h2b779XV6lERgzSmmaLj+Wpg0NzRpE0szi8E+" +
                                                              "kBPrFicO0Rnnx6KEAPH0ELGk+e7nrq5YMvfCs5LmxiI0G5M7mMIHlGPJKS/O" +
                                                              "7mq/qwyXUWUatorOD2gudllvfqQjZ0KGmeFyxMGYM3hh08V7HjrJ3oqSmm5S" +
                                                              "qRhaNgNx1KgYGVPVmLWW6cyinKW6STXTU11ivJtMgu+EqjPZuzGdthnvJuWa" +
                                                              "6Ko0xG8wURpYoIlq4FvV04bzbVI+JL5zJiFkEjykDp4yIv/EmxMaHzIyLE4V" +
                                                              "qqu6Ee+1DNQfHaqnaJwzG75TMGoacTurpzVjJG5bStywBt3fagY8H9/EBrMa" +
                                                              "tfpMmG5RrStrDbMYhpr5UQjJoaZTRyIRcMLscArQYPesM7QUswaUA9mVq6+e" +
                                                              "GXhehhduibyNOFkE8mJ5eTEhL1ZMHolEhJhpKFf6Gby0E/Y7JNy69r7Prt8+" +
                                                              "1gLWzZkj5WBiJG0JFJ4uLyk4mXxA+ev6N25bt/uTL0VJFPJGEgqPl//n+/I/" +
                                                              "Fi7LUFgK0k+pOuDkwnjpzF90DeTC4ZGHtzx4s1iDP6EjwwrIRTi9F9OwK6It" +
                                                              "vJGL8a3f++a7Zw/tNrwtHagQTmErmImZoiXszLDyA8ri+fTcwPndbVFSDukH" +
                                                              "Ui6nsEUgm80NywhkjA4n+6IuVaBw2rAyVMMhJ2XW8CHLGPF6RJQ1iu9p4Npa" +
                                                              "3ELz4KnK7ynxxtEZJrYzZVRirIS0ENn9U33m0V++8MfbhLmdQlDvq+B9jHf4" +
                                                              "kg8yaxJpptELvc0WY0D368O9Xzv49t6tIu6AorWYwDZsuyDpgAvBzJ9/9r5X" +
                                                              "r7x+7OWoF6scqm82CSAm5yqJ/aRmAiVB2iJvPZC8NNgsGDVtd+sQlWpapUmN" +
                                                              "4eb4V/3CW879eV+DjAMNepwwWnJ9Bl7/DSvJQ89v+8dcwSaiYPH0bOaRyYw8" +
                                                              "1ePcaVl0FNeRe/jynK8/Q49Cbod8aqu7mEiRZcIGZUGgiFiuL5u0uZgtq8i9" +
                                                              "tRd/aH/z90/KKtJShDhUmk4cr1Jey1z8nZxwQ5EJkm76ifiXtryy45KIiCpM" +
                                                              "AtiPRprs2+Kd1qAvHBtcT01Bx0yFpznvqWaZ4pP/f/ZVDIvFTUvNQCAOs/hm" +
                                                              "wEP6oMZ6mD3k5PiPQEoOXLOwdE7zeWj8W60vPDje+gaESD+pUm3IimC1IsDD" +
                                                              "N+edU1feujx5zhmRRsrR+HnDBxFbISAL4Czhk3ps7srZxYOj19FQyr21d7sy" +
                                                              "1tYrggPn3Skd+j78ReD5Dz7oSOyQDm3qygOH+S5yME2U1j4B1A8Kje9uurLz" +
                                                              "yJunZUSGkVWImI0d+OL7sX0H5L6V8LO1AAH650gIKuMTm05c3YKJpIgZa/5w" +
                                                              "dvcPTuzeK1fVFARTq+GscPoX/74UO/yb54pUb0igBpWHiNswlbnFd1rQBVKl" +
                                                              "VY/UP7W/qWwNOLubVGV19b4s6075eYJf7WzSt/88YCs6/MqhaziJLEYvFC5g" +
                                                              "dqD6i/OkV7xOvnTnz49/5dCIVHkCB4bmzXpvo5bc89t/CksU1OoiPg3N74+f" +
                                                              "OtLctfwtMd8rmji7NVeIoWADeXNvPZn5e7Sl8idRMqmfNCj589sWqmWxFPXD" +
                                                              "FrGdQx2c8QLjwfOHBNsdLiiYHQ4qn9hwufZ7qpwHvNIot1+EiAK1RcxYJNp2" +
                                                              "bJYIz0TxcynGjapTTczrhPKnMX2QDwnirnzk4mstJ2Ww8fFzuc/JUclK/J7F" +
                                                              "88UGVYMTjaEzrFvOmISLqhFzT5MwWCxc5gTCpUfkFs/2NV+4eWqC59KFOBE5" +
                                                              "zS2BBBeXjquwgGf2/Kl58/Kh7R8ABM4LBUuY5eM9p55bu0j5alQcQ6WrC46v" +
                                                              "wUkdQQfXWAzO23pw87VINwufSB9js1h4TfyOu9Ylwroyv+6cYCyDzRAEhYLu" +
                                                              "k96egNxEhDGvOHZZnTG5QBu7vjfz28uOj78uYFaOhD2OP3sEtxWiEZ+3TyA0" +
                                                              "i02b7cfeQaf67lgGlP0vvzN5yztPXy3IE0Go2UPNDm/vLMR0PTN8vllH7SGg" +
                                                              "u/3ChnsbtAvXRG2tpQoUQnujBYerXACY5qkrJv3qRz+esf3FMhJdQ2ogRafW" +
                                                              "UIHxSTWAa6jscC7LmZ9eIRHLCILLBqEqKVBe7GZLbpkbRV+F+O51EVAT0rU6" +
                                                              "oNV5+wF5Pic8UCIncDIJ8McwVFTsvCeEghsn4MxJlS1OiVkRQ5+QyB/bYWwe" +
                                                              "lKxGSyoaUmIpapcXVVFCib0TJLY9pdZfiikn1RrNJFO0R9XdYPQpMPYhKPBl" +
                                                              "bB7xJNNcMcn7P6Dkj8FTmZdcWULygf/FdKWYQrpIMY3TYos/+CEs/gg2hyDg" +
                                                              "VH14VSnBRycQnPNlS1e8KzJwQeQT79t3BPPDnFJ3eALKHdtzYDy18bFbHFS7" +
                                                              "DtzMDXOpxoaZ5mMVEd8pdxloaDLTWavz9lvBUzSkgXtSLTU1lFR9CVhm3dMT" +
                                                              "ZN2z2JwAgGDTjCkv3FZ41n78em4ukscAEhS7XsKSMqvgEltevCpnxuurZo7f" +
                                                              "/Yo8oziXo3VwWExnNc2PiHzflabF0qrQok7meFO8vsNJY8GVFwSzeItVn5OE" +
                                                              "3+ek1kfIERmLLz/RU4CQgAg/z5sO6JlXeKUWUDYXCUaVa9Dp1zOoLxBbA3VQ" +
                                                              "/JvAASJZ+Y+CAeXs+PoN91/9+GPyrkXR6K5dyKUWUL689nHBzIKS3Bxeleva" +
                                                              "r015onqhE9qNcsFeXN7oixsLIkzAhObQRYTd5t5HvHps2dM/Hau8DBV1K4lQ" +
                                                              "wJFbC0FyzszCntuaKDzNANATNyQd7d8YXb4k/ZfXBNIgBYePMP2AUv3evl0L" +
                                                              "7EgsSqq7we96iuUEel81qm9iyrAVOBpVJo2s7h6Dp2DwUfz3gbBK3piT3V68" +
                                                              "p+OkpfCUWHh3CahghFkrkTuymRyCflnT9I8Kqyaw6cyhlSHsBhI9pukcjy8J" +
                                                              "q5um2GU/w6bnv0/AjEf/GwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "adh+/tY6/dwdf/TG33vmO/nx2f8A8rNFV3MnAAA=");
}
