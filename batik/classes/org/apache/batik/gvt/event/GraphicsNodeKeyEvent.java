package org.apache.batik.gvt.event;
public class GraphicsNodeKeyEvent extends org.apache.batik.gvt.event.GraphicsNodeInputEvent {
    static final int KEY_FIRST = 400;
    public static final int KEY_TYPED = KEY_FIRST;
    public static final int KEY_PRESSED = 1 + KEY_FIRST;
    public static final int KEY_RELEASED = 2 + KEY_FIRST;
    protected int keyCode;
    protected char keyChar;
    protected int keyLocation;
    public GraphicsNodeKeyEvent(org.apache.batik.gvt.GraphicsNode source,
                                int id,
                                long when,
                                int modifiers,
                                int lockState,
                                int keyCode,
                                char keyChar,
                                int keyLocation) { super(source, id, when,
                                                         modifiers,
                                                         lockState);
                                                   this.keyCode = keyCode;
                                                   this.keyChar = keyChar;
                                                   this.keyLocation = keyLocation;
    }
    public int getKeyCode() { return keyCode; }
    public char getKeyChar() { return keyChar; }
    public int getKeyLocation() { return keyLocation; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za5AUxblv77j3m/cBx+sg8nBXCCaQEyMcd7CwHFd3QIUj" +
                                                              "sszO9u7O3ezMMNN7t4eSKBUDSUoKCa+khMoPLAxBoVKamIpYWFSiRGNFJUFj" +
                                                              "icaYComhIpWKmpjEfF/P7M5jH3hW4lZN72z39/6+/r6ve09fI2MMnbRShfnZ" +
                                                              "iEYNf6fCegTdoNEOWTCMjTAXFo+UCn/bdrV7mY+U95P6hGCsFwWDdklUjhr9" +
                                                              "ZJqkGExQRGp0UxpFjB6dGlQfEpikKv1kvGQEk5osiRJbr0YpAmwW9BBpEhjT" +
                                                              "pUiK0aBFgJFpIZAkwCUJrPAut4dIrahqIzb4JAd4h2MFIZM2L4ORxtCAMCQE" +
                                                              "UkySAyHJYO1pnSzQVHkkLqvMT9PMPyDfaplgbejWHBPMOtvw3of7E43cBGMF" +
                                                              "RVEZV8/opYYqD9FoiDTYs50yTRo7yFdIaYjUOIAZaQtlmAaAaQCYZrS1oUD6" +
                                                              "Oqqkkh0qV4dlKJVrIgrEyEw3EU3QhaRFpofLDBQqmaU7RwZtZ2S1NbXMUfHQ" +
                                                              "gsDBI9saf1hKGvpJg6T0oTgiCMGAST8YlCYjVDdWRKM02k+aFHB2H9UlQZZ2" +
                                                              "Wp5uNqS4IrAUuD9jFpxMaVTnPG1bgR9BNz0lMlXPqhfjAWX9GhOThTjoOsHW" +
                                                              "1dSwC+dBwWoJBNNjAsSdhVI2KClRRqZ7MbI6tq0DAECtSFKWULOsyhQBJkiz" +
                                                              "GSKyoMQDfRB6ShxAx6gQgDojLQWJoq01QRwU4jSMEemB6zGXAKqKGwJRGBnv" +
                                                              "BeOUwEstHi85/HOt+7Z9dylrFB8pAZmjVJRR/hpAavUg9dIY1SnsAxOxdn7o" +
                                                              "sDDh3F4fIQA83gNswvz47ut3LGw9/6wJMyUPzIbIABVZWDwRqX9xase8ZaUo" +
                                                              "RqWmGhI636U532U91kp7WoMMMyFLERf9mcXzvT/fcs8p+o6PVAdJuajKqSTE" +
                                                              "UZOoJjVJpvpqqlBdYDQaJFVUiXbw9SCpgPeQpFBzdkMsZlAWJGUynypX+W8w" +
                                                              "UQxIoImq4V1SYmrmXRNYgr+nNUJIBTykFp5pxPzwb0YigYSapAFBFBRJUQM9" +
                                                              "uor6GwHIOBGwbSIQgagfDBhqSocQDKh6PCBAHCSotRAfgt05hPlptS5oCUk0" +
                                                              "uiEjraMjnTjpx1jTPhUuadR17HBJCbhhqjcJyLB/1qhylOph8WBqZef1R8PP" +
                                                              "mQGGm8KyEiPI2G8y9nPGfmDs54z9+RiTkhLObxwKYLocHDYIWx9yb+28vjvX" +
                                                              "bt87qxRiTRsuA2sj6CxXDeqw80MmqYfFM811O2deWXTBR8pCpFkQWUqQsaSs" +
                                                              "0OOQrMRBaz/XRqA62UVihqNIYHXTVZFGIUcVKhYWlUp1iOo4z8g4B4VMCcPN" +
                                                              "GihcQPLKT84fHb5381dv8RGfuy4gyzGQ0hC9B7N5Nmu3efNBProNe66+d+bw" +
                                                              "LtXODK5Ck6mPOZiowyxvRHjNExbnzxAeD5/b1cbNXgWZmwmw0yAptnp5uBJP" +
                                                              "eyaJoy6VoHBM1ZOCjEsZG1ezhK4O2zM8VJv4+zgIixrcidPh2WxtTf6NqxM0" +
                                                              "HCeaoY1x5tGCF4nlfdqxV17402e5uTP1pMHRCPRR1u7IYUismWerJjtsN+qU" +
                                                              "AtzrR3u+fejanq08ZgFidj6GbTh2QO4CF4KZ73t2x6tvXDlxyWfHOYMinopA" +
                                                              "L5TOKonzpLqIksBtri0P5EAZMgRGTdsmBeJTiklCRKa4sf7VMGfR43/Z12jG" +
                                                              "gQwzmTBaeGMC9vzkleSe57a938rJlIhYg22b2WBmYh9rU16h68IIypG+96Vp" +
                                                              "33lGOAYlAtKyIe2kPNNWchtUcs0nQReTN6c4s4k7K+DO60tFDNjBUhIcNmSV" +
                                                              "t8U928W9bT1vm6Vrch4EE278w4H7N18eeJ6HQyXmCJxHYeocGQByiSMWG003" +
                                                              "fQSfEnj+gw+6ByfMMtHcYdWqGdlipWlpkHxeke7SrUBgV/Mbgw9efcRUwFvM" +
                                                              "PcB078FvfuTfd9D0sdnxzM5pOpw4ZtdjqoNDO0o3sxgXjtH1xzO7fvrwrj2m" +
                                                              "VM3u+t0J7ekjv/n38/6jb17MUy5KJatrXYJBn03x49y+MRVa9Y2GJ/c3l3ZB" +
                                                              "dgmSypQi7UjRYNRJERo2IxVxOMvupPiEUzV0DFSf+egDnFlqaYxfyx3vKxhs" +
                                                              "EFWJe6XEn6s5wS/Yww0piQmrbuSnxMdbOcAtWTDCwQhf24jDHMOZ7t1B4zgd" +
                                                              "hMX9l96t2/zuU9e54d3HC2d2Wy9optebcJiLXp/oLcdrBCMBcEvOd3+5UT7/" +
                                                              "IVDsB4oitBrGBh2agrQrF1rQYyp++/SFCdtfLCW+LlItq0K0S+BlhVRBPqdG" +
                                                              "AvqJtPbFO8x0NlwJQyNXleQonzOBKWV6/mTVmdQYTy87n5j42G0nj1/hedXy" +
                                                              "8xSOX4EtjquP4IdUu5Sdevnzvz75wOFhM6iLbFEP3qR/bpAju9/6IMfkvHLn" +
                                                              "2bUe/P7A6QdbOm5/h+PbJRSx29K5bRm0ITbu4lPJv/tmlf/MRyr6SaNoHQo3" +
                                                              "C3IKC1M/HISMzEkRDo6udfehxuzg27MtwlRv2nCw9RZv524sY66dZ9frJnTh" +
                                                              "HKtmZ2q3q17zptCMKBTJH4QzXJzqzW9978T79+5Z6sOCMWYIRQerNNpw3Sk8" +
                                                              "e3799KFpNQff/BZ3PGyx/Ug0xtl/ho/zcbiZh4IPSq3BT7AMNJEUQfaU3MYi" +
                                                              "cjJSta5zS7gr2Nu3MZsGxnL8TTjETVpfKhjj27O8JuHsYnhusnjdlGsT/B7A" +
                                                              "wcivSym++nFI4qB4NJlYhLqlycYtPZ2r8mnCRqnJUnj8Fi9/Hu/iSwJc8wC+" +
                                                              "3PWJ1SnEgpEaVKent7OvL79Cd49SoWXwLLG4LSmi0AF8+donVqgQC0ZqUaHe" +
                                                              "zlDnigIa3ffxNarH2RZ4llvsludoRPjL/fkVgf60StNVBmmCRj1a1BUhy0jF" +
                                                              "IB3pgJqeT4F9o1RgCjyrLE6rCihw2FQAh/25chbCtuSEao0/uz1yHhmlnK3w" +
                                                              "BC1OwQJyHisqZyFsCHOQM6SKQuZc4rXp8SKypm2eC7I8+aeceK45HDwdZZRg" +
                                                              "rzCt0E0U7w5P7D54PLrhoUU+q4NZCZHDVO1mmQ5R2UGqFCm5KvJ6fvdml7fX" +
                                                              "6w/8/idt8ZWjOdTjXOsNju34ezpUkfmFi7xXlGd2/7ll4+2J7aM4n0/3WMlL" +
                                                              "8vvrT19cPVc84OMXjWbdzbmgdCO1u6tttU5ZSlfc3e7srF8b0F+T4YlYfo14" +
                                                              "I9GOHE9IZE+ehVCLdKyPFVn7EQ5nGKmOU7bOkRbs6D17o51WvEfEiW0an/9B" +
                                                              "VhuOjrlvwNJmYPSGKIRaRNmni6xdwOFJ2xCZvGMb4tz/wRANmd29w9Jmx+gN" +
                                                              "UQi1iLIvFFn7FQ4XGak3DeFKbLYxfvG/MEaakXH5biTxYDEp5y8Q89pefPR4" +
                                                              "Q+XE45su8xyUvVqvhWwSS8mys/V1vJdrOo1JXL9asxHW+NcrjLQUvi6FbpR/" +
                                                              "c/kvmxivgcz5MOAgDaMT8gojjV5IoMi/nXC/g6Cz4aAVNl+cIG8DdQDB1z9o" +
                                                              "mTuZRR/znjeoaCnG7ZoucReOrDfH38ibjloz25Wj+f9ZmXyaMv/RCotnjq/t" +
                                                              "vuv65x4yb/NEWdi5E6nUhEiFebGYzckzC1LL0CpfM+/D+rNVczLVq8kU2N4X" +
                                                              "UxzBuw36Ig3Dp8Vz1WW0ZW+8Xj1x21O/3Fv+EhxgtpISgZGxW3MPXmktBcVw" +
                                                              "ayj3FgTqF7+Da5/33ZHbF8b++pp1wuG3JlMLw4fFSyfvfPnApBOtPlIDJyco" +
                                                              "zDTNT4SrRpReKg7p/aROMjrTICJQkQTZdcVSj5Eu4D9d3C6WOeuys3gXzMis" +
                                                              "3Nul3Bv0alkdpvpKNaVEeZWC+mnPZGqzq6ylNM2DYM84buC6cGhPozcgYMOh" +
                                                              "9ZqWuXwre0Ljm3514auXD/grDv/4LzCeDpHrHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e8zk2FWn5+uZnu6eyXTP5DUMmZlM0oEkBZ/r4XppEqDs" +
       "KrvsKpfLdrkeBtJx+e3y2y4/CmaXhEcCSCHABIKAEX8E8dCEALsIEAo7K55R" +
       "EFIQr93VJgittOyykcgfC2izu+y163v31530LtqS7vWte88993fOPffc4+v7" +
       "6hehR6IQqvieneu2Fx+qWXxo2c3DOPfV6JAaN6dSGKkKZktRNAN1d+S3/fLN" +
       "v//yR41bB9BVEXq95LpeLMWm50acGnl2oipj6OZp7cBWnSiGbo0tKZHgbWza" +
       "8NiM4hfH0GNnusbQ7fExBBhAgAEEuIQA906pQKfXqe7WwYoekhtHAfQvoIfG" +
       "0FVfLuDF0AvnmfhSKDlHbKalBIDDteL/HAhVds5C6K0nsu9lvkvgj1Xgl3/8" +
       "fbd+9Qp0U4Rumi5fwJEBiBgMIkKPO6qzVsOopyiqIkJPuqqq8GpoSra5K3GL" +
       "0FORqbtSvA3VEyUVlVtfDcsxTzX3uFzIFm7l2AtPxNNM1VaO/z2i2ZIOZH3T" +
       "qax7CfGiHgh4wwTAQk2S1eMuD29MV4mh5y/2OJHx9ggQgK6POmpseCdDPexK" +
       "oAJ6aj93tuTqMB+HpqsD0ke8LRglhp65J9NC174kbyRdvRNDT1+km+6bANX1" +
       "UhFFlxh640WykhOYpWcuzNKZ+fni5D0f+Q536B6UmBVVtgv810Cn5y504lRN" +
       "DVVXVvcdH3/3+MekN336wwcQBIjfeIF4T/Pr3/mlb/mG5177wz3N115Cw6wt" +
       "VY7vyJ9YP/G5t2Dv6l4pYFzzvcgsJv+c5KX5T49aXsx8sPLedMKxaDw8bnyN" +
       "+/3Vd/2i+rcH0A0Suip79tYBdvSk7Dm+aashobpqKMWqQkLXVVfBynYSehSU" +
       "x6ar7msZTYvUmIQetsuqq175H6hIAywKFT0KyqarecdlX4qNspz5EAQ9ChL0" +
       "OEjPQvtf+YyhNWx4jgpLsuSargdPQ6+QP4JVN14D3RrwGlj9Bo68bQhMEPZC" +
       "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" +
       "z73y+fIj4P8B4vXpuWkpAAA=");
}
