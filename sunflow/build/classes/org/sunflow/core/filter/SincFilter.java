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
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO9vnT/AHGAgfBoxBMqG3ISQlqSkJGIxNznDC" +
                                                              "BDWm4djbm7MX9naX3Tn7bOomICXQVkE0cYBEwX8RJUUkpFWjVmoTUVVtEiWt" +
                                                              "lI82TasmbVWptClqaNW0Cm3T92ZuP+9shKpautn1zHtv5n393pu9cIVU2RZp" +
                                                              "ozqLszGT2vGtOkvKlk0z3Zps27thLqWcrpD/tu/yjjujJDZIZg/Ldr8i27RH" +
                                                              "pVrGHiRLVN1msq5QewelGeRIWtSm1ojMVEMfJK2q3ZczNVVRWb+RoUiwR7YS" +
                                                              "pFlmzFLTeUb7igIYWZKAk0j8JNKm8HJXgjQohjnmkS/wkXf7VpAy5+1lM9KU" +
                                                              "OCCPyFKeqZqUUG3WVbDIzaahjQ1pBovTAosf0G4vmmB74vYSE7S/0PjxtZPD" +
                                                              "TdwEc2RdNxhXz95FbUMboZkEafRmt2o0Zx8iXyYVCVLvI2akI+FsKsGmEmzq" +
                                                              "aOtRwelnUT2f6za4OsyRFDMVPBAjy4NCTNmSc0UxSX5mkFDDirpzZtB2maut" +
                                                              "0LJExcdvliZP72v6VgVpHCSNqj6Ax1HgEAw2GQSD0lyaWvamTIZmBkmzDs4e" +
                                                              "oJYqa+p40dMttjqkyywP7nfMgpN5k1p8T89W4EfQzcorzLBc9bI8oIr/VWU1" +
                                                              "eQh0nefpKjTswXlQsE6Fg1lZGeKuyFJ5UNUzjCwNc7g6dtwDBMBanaNs2HC3" +
                                                              "qtRlmCAtIkQ0WR+SBiD09CEgrTIgAC1GFk4rFG1tyspBeYimMCJDdEmxBFS1" +
                                                              "3BDIwkhrmIxLAi8tDHnJ558rOzacOKz36lESgTNnqKLh+euBqS3EtItmqUUh" +
                                                              "DwRjw+rEKXneS8ejhABxa4hY0HznS1fvXtN26VVBs6gMzc70AaqwlHIuPfvN" +
                                                              "xd2dd1bgMWpMw1bR+QHNeZYliytdBRMQZp4rERfjzuKlXT++78Hz9MMoqesj" +
                                                              "McXQ8jmIo2bFyJmqRq1tVKeWzGimj9RSPdPN1/tINbwnVJ2K2Z3ZrE1ZH6nU" +
                                                              "+FTM4P+DibIgAk1UB++qnjWcd1Nmw/y9YBJCquFHOuFXRcQffzJyvzRs5Kgk" +
                                                              "K7Ku6oaUtAzUHx2qZ2SJURveM7BqGpKd17OaMSrZliIZ1pD7v2JYVIJTQARJ" +
                                                              "A6qu9PDXOIaZ+f/eoIAazhmNRMD4i8Opr0HW9BpahlopZTK/eevV51Ovi7DC" +
                                                              "VCjahpF22Cte3CuOe8XFXnFvLxKJ8C3m4p7Ct+CZg5DjALINnQP3b99/vL0C" +
                                                              "gsocrQSzIml7oNh0e0DgoHdK+ev2367rnfjc21ESBaxIQ7HxMH+ZD/OxWFmG" +
                                                              "QjMAOdNhv4N/0vRoX/YM5NKZ0SN7HriFn8EP4iiwCvAH2ZMIve4WHeHkLSe3" +
                                                              "8djljy+emjC8NA5UBaeYlXAiOrSHHRlWPqWsXia/mHppoiNKKgFyAGaZDGkB" +
                                                              "CNYW3iOAEl0O4qIuNaBw1rBysoZLDkzWsWHLGPVmeIQ18/e54Np6TJtW+NUU" +
                                                              "84g/cXWeieN8EZEYKyEtOKJ/fsA8+4uf/nEdN7cD/o2+qj1AWZcPcFBYC4eW" +
                                                              "Zi/0dluUAt2vzyQfe/zKsb087oBiRbkNO3DsBqABF4KZH3r10HsfvH/unagX" +
                                                              "qwwqbj4NjUvBVRLnSd0MSsJuq7zzAGBpkNMYNR336hCValaV0xrF5PhX48q1" +
                                                              "L/75RJOIAw1mnDBac30B3vxNm8mDr+/7RxsXE1GwYHo288gECs/xJG+yLHkM" +
                                                              "z1E48taSJ16RzwKeA4ba6jjlsBgpl6/Yvw3k0zZknZoDN4wUK8ytyf3K8Y7k" +
                                                              "70X1uKkMg6BrfVZ6ZM+7B97gTq7BvMZ51HuWL2s3WUO+CGsSxv8U/iLw+w/+" +
                                                              "0Og4IZC6pbtYLpa59cI0C3DyzhkavKAC0kTLBwefuvycUCBcT0PE9PjkVz+N" +
                                                              "n5gUnhNNx4qSuu/nEY2HUAeHO/B0y2fahXP0/OHixPeenTgmTtUSLKFboUN8" +
                                                              "7uf/fiN+5jevlcFuSCFDFq3juoA75wa9I1Ta8pXG759sqegB1OgjNXldPZSn" +
                                                              "fRm/TOia7Hza5y6vneETfuXQNYxEVoMX+PRt/BiSexjCD0P42jYcOmw/eAad" +
                                                              "5WuMU8rJdz6ateejl69yhYOdtR8r+mVTWLsZh5Vo7fnhAtUr28NAd9ulHV9s" +
                                                              "0i5dA4mDIFGBdtLeaUFlLASQpUhdVf3LH/xw3v43K0i0h9SBhTM9MgdpUgvo" +
                                                              "SO1hKKoF8667BTiMIjo0cVVJifKYj0vLZ/rWnMl4bo5/d/63Nzwz9T4HJYFC" +
                                                              "i1xHLg7UUX4b88rA+bfX/+yZr58aFaEzQyKE+BZ8slNLH/3dP0sMzKtemdwI" +
                                                              "8Q9KF55a2L3xQ87vlR/kXlEo7USgQHu8t57P/T3aHvtRlFQPkialePvZI2t5" +
                                                              "BPVB6Pht50oEN6TAerB7F61ql1teF4eT07dtuPD5I76SBaLbq3UN6EF8iRXL" +
                                                              "QCxc6yKEv3yBs6ziYycOa5zSUm1aKtyQaai21M8gFFKKE68XhRTHXhzuEzLu" +
                                                              "KRd2YmkVDqvdnVzpgZbXX8X8kYbvCxiZX9IMig4Qk2vJdLcWDmPnjk5OZXY+" +
                                                              "vTZaTPm7GGSLYX5GoyNU821VgZICQd3P72lehNQ9fMucBCtkS/tClNI2Tee3" +
                                                              "evroD2/wytE/Ldy9cXj/DTR9S0O6h0V+o//Ca9tWKY9G+VVTBGTJFTXI1BUM" +
                                                              "wzqLwp1aD0Jtu+vNZnTeAicqnWdp41UmENx2ZjrWGYDbnmEtjwPcCauHKBuA" +
                                                              "joJHrRewxgwBW4qTOJHk0weCOs91uJznjek8HWtIryg/R9RNvPVc9AMzaH8E" +
                                                              "h3FGKkD7kOaH/2fNWxxvO4k89zqa7y0FmOlYQzoVewZP6a/NoPQjODwMLbMN" +
                                                              "d8O1mZDex25c7wIjdd49E6vlgpIvWOKri/L8VGPN/Kl73+V3HvfLSAO0mNm8" +
                                                              "pvkB3fceMy2aVfnZGwS8m/wxWQ7qxL2X4TcqfOFHfkzQn2akKUzPSCU+/GRP" +
                                                              "MlLvI2PYTvE3P9FZCBogwtcp0wHeJt4kYGGLi8JWiPhAs4jw3Mqt17Oyy+K/" +
                                                              "EyEo8k+IDoDlxUfElHJxavuOw1c/+7S4kymaPD6OUuqhFxTXQxcEl08rzZEV" +
                                                              "6+28NvuF2pVOEWgWB/aCdZEvmJIQdia6fGHowmJ3uPeW985tePknx2NvQaex" +
                                                              "l0RkRubsLW0BCmYeasreRGnPCwWC36S6Op8c27gm+5df8R6LlLRWYfqUUvvJ" +
                                                              "ifHldiQeJbV9pArqGy3w3mTLmL6LKiNWoIGOpY287n5pnI2xKeOnRW6VojFn" +
                                                              "ubN4n2ekvfQuUfqNA5rPUWptRum8KIRKRt40/avcqt043FFAK0OcpRL9pulc" +
                                                              "og5xq5smT71v4rDlvz0oX2IbGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nt974pMvfCNLT/4vyjw9J5YiAAA=");
}
