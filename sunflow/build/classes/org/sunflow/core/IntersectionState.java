package org.sunflow.core;
public final class IntersectionState {
    private static final int MAX_STACK_SIZE = 64;
    float u;
    float v;
    org.sunflow.core.Instance instance;
    int id;
    private final org.sunflow.core.IntersectionState.StackNode[] stack;
    private final float[] rstack;
    org.sunflow.core.Instance current;
    public static final class StackNode {
        public int node;
        public float near;
        public float far;
        public StackNode() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39gG2Mbg20g4IAxUU3cO0hD08g0BQwuJmf7" +
                                                                  "hAltTcDM7c3Zi/d2l91Z++yUNiBFOJGKqEIIrcB/ESVCSUBVo1ZqE1FFbVMl" +
                                                                  "rZQ0bZJWJVVVqVQpalDVpCpt0/dmdm8/zmfUP3rSzc3Nvpl5H7/5vTf7/A1S" +
                                                                  "ZVuknek8wadNZid26TxNLZtlezVq2/tgbFR5uoL+7dD1wfvjpHqENIxTe0Ch" +
                                                                  "NutTmZa1R8gaVbc51RVmDzKWxRlpi9nMmqRcNfQR0qLa/XlTUxWVDxhZhgL7" +
                                                                  "qZUiSynnlppxOOt3F+BkTQo0SQpNktujj3tSpF4xzGlffEVAvDfwBCXz/l42" +
                                                                  "J02pI3SSJh2uasmUavOegkXuNg1tekwzeIIVeOKItsV1wZ7UlhIXdFxp/OjW" +
                                                                  "6fEm4YJlVNcNLsyz9zLb0CZZNkUa/dFdGsvbR8nXSEWKLA4Ic9KZ8jZNwqZJ" +
                                                                  "2NSz1pcC7Zcw3cn3GsIc7q1UbSqoECfrwouY1KJ5d5m00BlWqOGu7WIyWLu2" +
                                                                  "aK20ssTEp+5Onnn6UNN3KkjjCGlU9WFURwElOGwyAg5l+Qyz7O3ZLMuOkKU6" +
                                                                  "BHuYWSrV1Bk30s22OqZT7kD4PbfgoGMyS+zp+wriCLZZjsINq2heTgDK/VeV" +
                                                                  "0+gY2Nrq2yot7MNxMLBOBcWsHAXcuVMqJ1Q9y8md0RlFGzsfBAGYuijP+LhR" +
                                                                  "3KpSpzBAmiVENKqPJYcBevoYiFYZAECLk1VlF0Vfm1SZoGNsFBEZkUvLRyBV" +
                                                                  "KxyBUzhpiYqJlSBKqyJRCsTnxuDWU4/ou/U4iYHOWaZoqP9imNQembSX5ZjF" +
                                                                  "4BzIifUbU2dp68uzcUJAuCUiLGW+99Wb27rbr74mZe6YR2Yoc4QpfFS5mGl4" +
                                                                  "c3Vv1/0VqEaNadgqBj9kuThlafdJT8EEhmktrogPE97Dq3t/8pVHL7EP4qSu" +
                                                                  "n1QrhubkAUdLFSNvqhqzvsh0ZlHOsv2klunZXvG8nyyCfkrVmRwdyuVsxvtJ" +
                                                                  "pSaGqg3xH1yUgyXQRXXQV/Wc4fVNysdFv2ASQlbAl6yBbwuRH/HLyXBy3Miz" +
                                                                  "JFWorupGMm0ZaL+dBMbJgG/Hk7aj5zRjKmlbStKwxor/FcNiyX4Epw0TwEg8" +
                                                                  "SCyB4DL/P8sW0JplU7EYOHp19JhrcEJ2G1qWWaPKGWfHrpsvjr4uIYSwd/3A" +
                                                                  "STfslXD3SuBeiZK9OqFVJgaBV0ksJjZbjrvLiEI8JuBkA7XWdw0f3HN4tqMC" +
                                                                  "oGROVYIzUbQjlGJ6/ePvcfaocrl5ycy6a5tfjZPKFGmmCneohhljuzUmdnaP" +
                                                                  "a30Gko+fA9YGcgAmL8tQWBYoqFwucFepMSaZheOcLA+s4GUoPIvJ8vlhXv3J" +
                                                                  "1XNTx/d/fVOcxMO0j1tWAWPh9DSSdZGUO6PHfb51G09e/+jy2WOGf/BDecRL" +
                                                                  "fyUz0YaOKByi7hlVNq6lL42+fKxTuL0WiJlTOEjAee3RPUK80uNxNNpSAwbn" +
                                                                  "DCtPNXzk+biOj1vGlD8icLoUmxYJWYRQREFB758fNi+8+4s/f0Z40ssEjYEU" +
                                                                  "Psx4T4B9cLFmwTNLfUTusxgDud+dSz/51I2TBwQcQWL9fBt2YtsLrAPRAQ8+" +
                                                                  "9trR996/dvHtuA9hDunXyUAVUxC2LP8EPjH4/ge/yBg4IJmjudelr7VF/jJx" +
                                                                  "57t83YDJNHmy7M6HdIChmlNpRmN4fv7VuGHzS3851STDrcGIh5bu2y/gj6/c" +
                                                                  "QR59/dDH7WKZmIKZ1PefLybpeZm/8nbLotOoR+H4W2u+9VN6AYgeyNVWZ5jg" +
                                                                  "SyL8QUQAtwhfbBLtvZFn92GzwQ5iPHyMAhXPqHL67Q+X7P/wlZtC23DJFIz7" +
                                                                  "ADV7JIpkFGCzTxG3CfE3Pm01sW0rgA5tUaLaTe1xWOzeq4MPN2lXb8G2I7Ct" +
                                                                  "AsWEPWQBVxZCUHKlqxb95kevth5+s4LE+0idZtBsHxUHjtQC0pk9DjRbML+w" +
                                                                  "TeoxVQNNk/AHKfFQyQBG4c7547srb3IRkZnvt31367Nz1wQsTbnGHWJ+BTJ/" +
                                                                  "iGFFde4f8ku/vO9Xz37z7JTM713lmS0yb8U/h7TMiT/8oyQugtPmqT0i80eS" +
                                                                  "z59f1fvAB2K+Ty44u7NQmq2AoP2591zK/z3eUf3jOFk0QpoUtxreTzUHz/UI" +
                                                                  "VIC2VyJDxRx6Hq7mZOnSUyTP1VFiC2wbpTU/S0IfpbG/JILBRuIWEq0uBluj" +
                                                                  "GIwR0dkjptwl2i5suiW7YPfTheJ6iBzSsMB6HPSCTBXOq5i7hp2MDTlQzQMv" +
                                                                  "Trr13z3pw8psZ/qPMvYr55kg5VqeS35j/ztH3hCsW4NZdp9nbyCHQjYOsHkT" +
                                                                  "Ngk8YgtgKqJP8ljz+xPnr78g9YkCKCLMZs888Uni1BnJhrLCX19SZAfnyCo/" +
                                                                  "ot26hXYRM/r+dPnYD547dlJq1RyuV3fBdeyFX//7jcS53/9snuKpQnVvaXii" +
                                                                  "Y8WaZ3nY1dKgnY83/vB0c0UfpNt+UuPo6lGH9WfDQFtkO5mA7/2bgw8+1zTM" +
                                                                  "OpzENgIdyIyK7eeweVDCaWtZOtoZhu8q+La5cGsrA18q4YvNQClYy81GsDK3" +
                                                                  "8kq7EcGf4UD/SxyPnUFL3Ih/D0Zty/yPtq306nzvdx7b8gvaVm42xD5HBZ3l" +
                                                                  "IjrqC+hYmJ8GKgQNQKVhi6s3ukTVqebzQqXn3nK5LpASCMJ+TbnrpID8xRNn" +
                                                                  "5rJDz2yOuyn7y7C1e8sPrsNJbbHyFw9WcNJx++sCbL+i5J2DvCcrL8411rTN" +
                                                                  "PfSOqDmLd9l6oJ2co2lByg30q02L5VShab0kYAn6E5w0RdUBzOGPUPe4FHuM" +
                                                                  "k8UBMY6nTPSCQrMQUBDC7uOmZ2yTyMuYShIylRRiYUcXg95yO2AGYrM+RJji" +
                                                                  "JY5HFo58jQNXork9g4/c/OwzshBWNDozg6ssBoqQ5XbxJrGu7GreWtW7u241" +
                                                                  "XKnd4EU7VIgHdcP+Djh6omhdFakM7c5igfjexa2v/Hy2+i0gxAMkRjlZdqA0" +
                                                                  "6RZMB2B4IFVKhZB0Rcna0/Xt6Qe6c3/9rShrXOpcXV4eioon3+2/MvHxNvHW" +
                                                                  "oAqAzAqiGtg5re9lyqQV4tUGRBfF1znCD677lhRH8UYEeC5NKaX3SCj5ppi1" +
                                                                  "w3D0rMvMi/2R0NskF7F1jmlGJvgjgSz6sGRC9D7gbzQ1YJrudSK2yRQn+2B5" +
                                                                  "Xjwvuthc+C9eOneezxUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "FcfV2R8+/Ptv/Z0Xvl4cNfwv7dL0tmIfAAA=");
    }
    public IntersectionState() { super();
                                 stack = (new org.sunflow.core.IntersectionState.StackNode[MAX_STACK_SIZE *
                                                                                             2]);
                                 for (int i =
                                        0;
                                      i <
                                        stack.
                                          length;
                                      i++)
                                     stack[i] =
                                       new org.sunflow.core.IntersectionState.StackNode(
                                         );
                                 rstack =
                                   (new float[53 *
                                                256]);
    }
    public final org.sunflow.core.IntersectionState.StackNode[] getStack() {
        return stack;
    }
    public final int getStackTop() { return current ==
                                       null
                                       ? 0
                                       : MAX_STACK_SIZE;
    }
    public final float[] getRobustStack() {
        return rstack;
    }
    public final boolean hit() { return instance !=
                                   null; }
    public final void setIntersection(int id,
                                      float u,
                                      float v) {
        instance =
          current;
        this.
          id =
          id;
        this.
          u =
          u;
        this.
          v =
          v;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VlYcwCQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mzu0/W1e/GUEXQY8TlwxDo+m8jNHbH7r");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("u2Uzv8bV3Wez++aweeb8Hdou5sWZCDqrG9GtdmkviK5rKYJzyPKZve+C5cJT" +
       "vAc8032Wp/+ALJ89cofFaUhxdv++gstH7yCBx/PiagRdye+THjszveWe9cY1" +
       "5CNRPHwvokiBS77pTDa/KvbWm+5o7+4VS1949crFx1+d/c/dkfLB3d9LNHRR" +
       "jS3r+M2eY/XzXqCoRiGgS7t7Pl7B5jMRdPX0GTFgKP/LST3z9A7sGrDqY2BA" +
       "AfZrx4HeCfQFAOXV7/ducVyxu7GUnjnp8w+N5pG7ie1YmHjuxGlvcen94GQ2" +
       "3l17vyF98dUB88NvYJ/bXWgEKV2W5Vgu0tCF3d3Kw9PdZ26L7QDX+d67vn35" +
       "S5eePwg8l3cEH6nlMdrecevbgx3bi4r7ftkvPP5zP/DvX/1Kce/p/wErDDg0" +
       "jTAAAA==");
}
