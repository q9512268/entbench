package org.sunflow.core.filter;
public class SincFilter implements org.sunflow.core.Filter {
    private float s;
    public SincFilter(float size) { super();
                                    s = size; }
    public float getSize() { return s; }
    public float get(float x, float y) { return sinc1d(x) * sinc1d(y); }
    private float sinc1d(float x) { x = java.lang.Math.abs(x);
                                    if (x < 1.0E-4F) return 1.0F;
                                    x *= java.lang.Math.PI;
                                    return (float) java.lang.Math.sin(x) /
                                      x; }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYDYxUVxW+M/vL7sL+sAuUnwWWhWaBzpRatGQRgWW3LM7C" +
                                                              "ZpeSOFiGN2/u7D72zXuP9+7szm7d2hIb1hqRtpRSQzFRmlZCCzHWarQNptG2" +
                                                              "aTVprbbVlBo1Ea3EEmNrRK3n3Pv+Z3aRxE4yd+7cd8659/x959x39jKpsEzS" +
                                                              "SjUWY+MGtWLdGuuXTItmulTJsnbDWkp+pEz6275LOzdESWWSzBmWrD5ZsmiP" +
                                                              "QtWMlSRLFM1ikiZTayelGeToN6lFzVGJKbqWJC2K1ZszVEVWWJ+eoUiwRzIT" +
                                                              "pFFizFTSeUZ7bQGMLEnASeL8JPEt4cedCVIn68a4R77AR97le4KUOW8vi5GG" +
                                                              "xAFpVIrnmaLGE4rFOgsmWWPo6viQqrMYLbDYAXW9bYIdifVFJmg7X//B1aPD" +
                                                              "DdwEcyVN0xlXzxqglq6O0kyC1Hur3SrNWQfJ3aQsQWp9xIy0J5xN47BpHDZ1" +
                                                              "tPWo4PSzqZbPdelcHeZIqjRkPBAjy4NCDMmUcraYfn5mkFDNbN05M2i7zNVW" +
                                                              "aFmk4sNr4sce2dfwnTJSnyT1ijaIx5HhEAw2SYJBaS5NTWtLJkMzSdKogbMH" +
                                                              "qalIqjJhe7rJUoY0ieXB/Y5ZcDFvUJPv6dkK/Ai6mXmZ6aarXpYHlP2vIqtK" +
                                                              "Q6DrPE9XoWEProOCNQoczMxKEHc2S/mIomUYWRrmcHVs/ywQAGtVjrJh3d2q" +
                                                              "XJNggTSJEFElbSg+CKGnDQFphQ4BaDKycFqhaGtDkkekIZrCiAzR9YtHQDWL" +
                                                              "GwJZGGkJk3FJ4KWFIS/5/HN558Yjd2nbtSiJwJkzVFbx/LXA1BpiGqBZalLI" +
                                                              "A8FYtzpxXJr33FSUECBuCRELmme/cGXz2tYLLwmaRSVodqUPUJml5NPpOa8t" +
                                                              "7urYUIbHqDZ0S0HnBzTnWdZvP+ksGIAw81yJ+DDmPLww8NPP3XOGvhclNb2k" +
                                                              "UtbVfA7iqFHWc4aiUvN2qlFTYjTTS2ZRLdPFn/eSKpgnFI2K1V3ZrEVZLylX" +
                                                              "+VKlzv+DibIgAk1UA3NFy+rO3JDYMJ8XDEJIFXxJB3wriPjwX0YG48N6jsYl" +
                                                              "WdIUTY/3mzrqb8UBcdJg2+G4ldeyqj4Wt0w5rptD7n9ZN2kc9oa4iQ8qmtzD" +
                                                              "pzEMLuPjEVtAbeaORSJg6MXhNFchQ7braoaaKflYfmv3ladTr4gQwrC37cBI" +
                                                              "G+wVs/eK4V4xsVfM24tEInyLZtxT+BG8MAL5DIBa1zF45479U21lEEDGWDmY" +
                                                              "EEnbAoWly0t6B6lT8rmm2RPLL657IUrKE6RJklleUrFObDGHAIHkETtJ69JQ" +
                                                              "cjzkX+ZDfixZpi7TDADPdBXAllKtj1IT1xlp9klw6hJmYHz6qlDy/OTCibF7" +
                                                              "93zx5iiJBsEet6wAnEL2foRoF4rbw0leSm794UsfnDs+qXvpHqgeTtEr4kQd" +
                                                              "2sJBEDZPSl69THom9dxkOzf7LIBjJkH6ANK1hvcIoEmng8yoSzUonNXNnKTi" +
                                                              "I8fGNWzY1Me8FR6djXzeDGFRi+nVAt9qO9/4Lz6dZ+A4X0QzxllIC478nx40" +
                                                              "Hnvr53/6BDe3UyTqfdV9kLJOHzChsCYOQY1e2O42KQW6d070P/Tw5cN7ecwC" +
                                                              "xYpSG7bj2AWABC4EM9/30sG33714+o2oF+cMKnM+DQ1OwVUS10nNDErCbqu8" +
                                                              "8wCwqYACGDXtd2gQn0pWkdIqxcT6V/3Kdc/85UiDiAMVVpwwWnttAd76DVvJ" +
                                                              "Pa/s+7CVi4nIWFg9m3lkAq3nepK3mKY0juco3Pv6kkdflB4D3AestZQJyuEz" +
                                                              "UirXMZ8G82kL8lLJgRtG7Up0S/9+eaq9/w+iytxQgkHQtTwZ/+qeNw+8yp1c" +
                                                              "jZmP66j3bF9eA0L4IqxBGP8j+ETg+x/8otFxQSB6U5ddVpa5dcUwCnDyjhka" +
                                                              "waAC8cmmd0dOXnpKKBCuuyFiOnXs/o9iR44Jz4nmZEVRf+DnEQ2KUAeHDXi6" +
                                                              "5TPtwjl6/nhu8odPTh4Wp2oKltpu6CSf+tW/X42d+O3LJXAfUkiXRIt5a8Cd" +
                                                              "zUHvCJW2fbn+R0ebynoANXpJdV5TDuZpb8YvE7orK5/2uctre/iCXzl0DSOR" +
                                                              "1eAFvryeH+Nm9zCEH4bwZ9txWGn5wTPoLF8DnZKPvvH+7D3vP3+FKxzswP1Y" +
                                                              "0ScZwtqNOKxCa88PF7ftkjUMdLde2Pn5BvXCVZCYBIkytJ3WLhOqaiGALDZ1" +
                                                              "RdWvf/zCvP2vlZFoD6kBC2d6JA7SZBagI7WGoSAXjM9sFuAwhujQwFUlRcoX" +
                                                              "LWCCLi2d+t05g/Fknfj+/O9ufOLURY5ShpCxyHXt4kBV5vc4rzCc+cWnfvnE" +
                                                              "A8fHRDDNkBohvgX/3KWmD/3uH0Um53WwRLaE+JPxsycXdm16j/N7BQm52wvF" +
                                                              "fQ0UdY/3ljO5v0fbKn8SJVVJ0iDb96Y9kppHmE/CXcFyLlNwtwo8D/b9osnt" +
                                                              "dAvu4nC6+rYNl0J/DpSzQLx71a8OXYiTSrswVIarX4TwSZKz3MjH1Tjc5BSb" +
                                                              "KsNU4G5NQ9WmdgahkGSc+DZRWnHsxWGvkJEoFYji0Y04rHF3cqUHmmV/XfNH" +
                                                              "Gs4XMDK/qLUU/SSm25Lp7jsc2E4fOnYqs+vxdVEbBDYzyB/duEmlo1T1bVWG" +
                                                              "kgJB3cdveF6EvDPnwd//oH1o6/V0mbjWeo0+Ev8vhfBcPX2ehI/y4qE/L9y9" +
                                                              "aXj/dTSMS0NWCov8dt/Zl29fJT8Y5ddZEbpF1+AgU2cwYGtMCvd2LQjTK1y/" +
                                                              "N6KbFzjx6/wWN20lQsZthaZjnQH08zM8G8MBCljVEGWD0I3w+PZC++AMof0/" +
                                                              "YCwuDBh8XQ1aodmR4/xenxWmYw1pGuUHibpJexsXfWgGe3wJh0lGysAeIVvc" +
                                                              "/THYosmJCAcWmq9hizuL4Wo61pCWdk/imeFrM5jhARzuh5bcgnvrukzIEl/5" +
                                                              "f1iiwEiNdyvGcryg6N2aeB8kP32qvnr+qTve5LDjvrOpAwDJ5lXVXzB880rD" +
                                                              "pFmFa1MnyofBfx4tBaXils7w7RlO+JlPCPqTjDSE6Rkpxx8/2TcYqfWRMWzg" +
                                                              "+MxP9E0ILCDC6bcMB9gbeBeChTMmCmch4gNl24Dc7i3XsrvL4r+FIZTyl5sO" +
                                                              "7OXF682UfO7Ujp13Xfnk4+IWKKvSxARKqYXuU1xIXehcPq00R1bl9o6rc87P" +
                                                              "WukUmUZxYC98F/nCawAC0UCXLwxdkax296b09umNz/9sqvJ16GT2kojEyNy9" +
                                                              "xS1GwchDzdqbKO6yoczwu1tnx9fHN63N/vU3vIkjRa1bmB5aqIfe6j0/8uFm" +
                                                              "/jatAuonLfDeZ9u4NkDlUTPQss/BaJTwNSe3g22+2e4qvjNgpK34vlL8pgUa" +
                                                              "3DFqbtXzGs83aPprvZXAW1an2uQNI8TgrfjudNtw2FBA60P8pRJ9huFc5w4a" +
                                                              "PBu7S6FEN2f+Hp/i8Ox/AVtp7snnGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+//gLZ944Rt5evN/AUlaP+LCIgAA");
}
