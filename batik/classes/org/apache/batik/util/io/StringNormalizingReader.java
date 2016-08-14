package org.apache.batik.util.io;
public class StringNormalizingReader extends org.apache.batik.util.io.NormalizingReader {
    protected java.lang.String string;
    protected int length;
    protected int next;
    protected int line = 1;
    protected int column;
    public StringNormalizingReader(java.lang.String s) { super();
                                                         string = s;
                                                         length = s.length(
                                                                      ); }
    public int read() throws java.io.IOException { int result = length ==
                                                     next
                                                     ? -1
                                                     : string.
                                                     charAt(
                                                       next++);
                                                   if (result <= 13) { switch (result) {
                                                                           case 13:
                                                                               column =
                                                                                 0;
                                                                               line++;
                                                                               int c =
                                                                                 length ==
                                                                                 next
                                                                                 ? -1
                                                                                 : string.
                                                                                 charAt(
                                                                                   next);
                                                                               if (c ==
                                                                                     10) {
                                                                                   next++;
                                                                               }
                                                                               return 10;
                                                                           case 10:
                                                                               column =
                                                                                 0;
                                                                               line++;
                                                                       }
                                                   }
                                                   return result;
    }
    public int getLine() { return line; }
    public int getColumn() { return column;
    }
    public void close() throws java.io.IOException {
        string =
          null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZDWwUxxWeO///4R/wD2AMGAPCEB+kQERNaOBiB5PzjzAg" +
       "1RAfe3tzvsV7u8vunH02pU2QKtyqQYQ4hLYEVRURBEGIqtLfJKKKGpImqZpA" +
       "m6ZVSNVWCm2KGlQ1rUrb9M3M3u3P3R5y1fSkndubeW/mvTfvfe/N3PmbqMjQ" +
       "UQtWSAeZ0LDR0aWQAUE3cDQoC4axA/rC4pMFwl+Gb/Rt8KPiITQrLhi9omDg" +
       "bgnLUWMILZAUgwiKiI0+jKOUY0DHBtbHBCKpyhCql4yehCZLokR61SimBLsE" +
       "PYRqBUJ0KZIkuMecgKAFIZAkwCQJbHYPd4ZQpahqExZ5k408aBuhlAlrLYOg" +
       "mtA+YUwIJIkkB0KSQTpTOlqpqfLEiKySDpwiHfvkdaYJtoXWZZmg9bnqj24f" +
       "jdcwE8wWFEUlTD1jOzZUeQxHQ6ja6u2SccLYjz6PCkKowkZMUFsovWgAFg3A" +
       "omltLSqQvgoryURQZeqQ9EzFmkgFImixcxJN0IWEOc0AkxlmKCWm7owZtF2U" +
       "0ZZrmaXiEysD008O13yrAFUPoWpJGaTiiCAEgUWGwKA4EcG6sTkaxdEhVKvA" +
       "Zg9iXRJkadLc6TpDGlEEkoTtT5uFdiY1rLM1LVvBPoJuelIkqp5RL8YcyvxV" +
       "FJOFEdC1wdKVa9hN+0HBcgkE02MC+J3JUjgqKVGCFro5Mjq2PQgEwFqSwCSu" +
       "ZpYqVAToQHXcRWRBGQkMguspI0BapIID6gTN85yU2loTxFFhBIepR7roBvgQ" +
       "UJUxQ1AWgurdZGwm2KV5rl2y7c/Nvo1HDihbFT/ygcxRLMpU/gpganExbccx" +
       "rGOIA85Y2R46LjS8MOVHCIjrXcSc5rufu3XfqpbLr3Ca+Tlo+iP7sEjC4unI" +
       "rDebgys2FFAxSjXVkOjmOzRnUTZgjnSmNECYhsyMdLAjPXh5+8ufffgc/sCP" +
       "yntQsajKyQT4Ua2oJjRJxvoDWMG6QHC0B5VhJRpk4z2oBN5DkoJ5b38sZmDS" +
       "gwpl1lWsst9gohhMQU1UDu+SElPT75pA4uw9pSGESuBBlfAsQPzDvgkSA3E1" +
       "gQOCKCiSogYGdJXqbwQAcSJg23ggAl4/GjDUpA4uGFD1kYAAfhDH5gAzgqSa" +
       "rtSn6gkaKfC6HQtRrHdQZ9P+P8ukqLazx30+2IhmNwzIEEFbVRlow+J0ckvX" +
       "rWfDr3EXo2Fh2omg1bByB1+5g63MN1JSOzxWRj4fW3AOlYATw56NQvQD/Fau" +
       "GHxo296p1gJwN228EAxOSVsdaShoQUQa18PixbqqycXX17zkR4UhVCeIJCnI" +
       "NKts1kcAr8RRM6QrI5CgrDyxyJYnaILTVRFHAaa88oU5S6k6hnXaT9Ac2wzp" +
       "LEbjNeCdQ3LKjy6fGH9k1xdW+5HfmRrokkWAapR9gAJ6Brjb3JCQa97qwzc+" +
       "unj8oGqBgyPXpFNkFifVodXtEm7zhMX2RcKl8AsH25jZywC8iQDBBrjY4l7D" +
       "gT2daRynupSCwjHmJXQobeNyEtfVcauH+Wote58DblFBg7EVno1mdLJvOtqg" +
       "0baR+zb1M5cWLE/cO6g99cuf/uFTzNzplFJtqwUGMem0wRidrI4BVq3ltjt0" +
       "jIHu3RMDjz9x8/Bu5rNAsSTXgm20DQJ8wRaCmb/4yv533rt++prf8nMCeTwZ" +
       "gXIolVGS9qPyPErCassseQAGZcAI6jVtOxXwTykmCREZ08D6Z/XSNZf+dKSG" +
       "+4EMPWk3WnXnCaz+uVvQw68N/62FTeMTaRq2bGaRcWyfbc28WdeFCSpH6pG3" +
       "Fnz1ivAUZAlAZkOaxAxsfWasU6GaoCpjnDTjmijCdnMdG17N2rXUEowJsbEN" +
       "tFlq2KPCGXi2OiosHr32YdWuD1+8xdRwFmJ2J+gVtE7ud7RZloLpG92otVUw" +
       "4kC39nLfnhr58m2YcQhmFAGTjX4d4C7lcBmTuqjkVz96qWHvmwXI343KZVWI" +
       "dgss+lAZuD024oC7Ke0z9/FdHy+FpoapirKUz+qgll+Ye0+7EhphuzD5vcZv" +
       "bzxz6jpzP43PMZ/x06q/2QG3rJy3Iv7c1Xt+fuax4+O8IFjhDXMuvqZ/9MuR" +
       "Q7/9e5bJGcDlKFZc/EOB8yfnBTd9wPgtpKHcbans9AVobfHefS7xV39r8Y/9" +
       "qGQI1Yhm+bxLkJM0foegZDTSNTWU2I5xZ/nHa53ODJI2u1HOtqwb46y0Ce+U" +
       "mr5XuWBtFt3CZhPa0hDngDUfYi8PMpblrG2nzV1pFCnTdJWAlDjqApKqPNMC" +
       "+Bgs0Oiv9Rw6aftp2oT4RPd6+mOXU/658Cw3F1ruIf8OLj9t+rLF9OIGMWWs" +
       "jJC4syigiXcwGTEggUsJwOsxs8C9e2CvONU28Hvuq3NzMHC6+rOBR3e9ve91" +
       "lg1KaYmwI70/tgIASglbKqrhUn8MHx88/6YPlZZ28EKxLmhWq4sy5SqNtbxB" +
       "41IgcLDuvdGTNy5wBdwR4iLGU9Nf/rjjyDSHeH7mWZJ17LDz8HMPV4c2e6h0" +
       "i/Otwji637948IdnDx7mUtU5K/guOKBe+MW/Xu848ZtXc5SLBZJ5bl1rQ31I" +
       "0s694Qrd/6Xq54/WFXRDcdGDSpOKtD+Je6LOSCoxkhHbZllnKSu6TNXoxhDk" +
       "a4c9cPn3zhn6dyM8q0wPXeXh33Je//biJqAb+AR93+0SMjFDIefDs8ZcZo2H" +
       "kEZeIb24CT9R5RKS/BdIsd5cZr2HkJN5hfTiJulTYy4xD+QRM2UttzKzHPsU" +
       "I9dZ0F6IWRkU0SBa4HVcZwF0+tD0qWj/02v8ZvECdVQZUbW7ZDyGZdtUhXQm" +
       "RzLuZRcUVmZ7d9ax332/bWTLTI49tK/lDgcb+nshBHe7N1S5Rbly6I/zdmyK" +
       "753BCWahy0ruKZ/pPf/qA8vEY352G8NTbtYtjpOp0wkP5TomSV1xAsKSzL5W" +
       "0/2aDU+3ua/dbie0PMflEpna3Is1T7H6mGvMVf3yuhlO0D39XSkRa9SKjO9x" +
       "2nwF4k+HkzRzbMunH71T6OUvGmlHUGP9U07zNMAzbOo4PHPzeLHmMc838ox9" +
       "kzZfJ6hkBJNQGoUsK5z8pKzQBA82VcEzt4IXax5NL+QZu0ibs4AaYIWgBXOW" +
       "HZ75BOzAjtw098mmMvLM7eDFmkfXH+QOFvpzmhE8T5tLBBWJsmrw24Jh2uzh" +
       "ikUgXsZUKWoZ5zv/C+OkCGr0uOGiJ7CmrFt1fhMsPnuqurTx1M63GWJnbmsr" +
       "AXtjSVm2nxFs78WajmMS07aSnxh4EXOFoCav+zeC/JLKpH+ZE/+EoPqcxGAg" +
       "+mWnfQPO4G5asDD7ttP9jKByiw6SLn+xk1yFog9I6Os1LQ1x7Z63hlnWTPmc" +
       "yTWzjfV32kZbPl7iyGPsj5F0zknyv0bC4sVT2/oO3Fr/NL8TEmVhcpLOUgFF" +
       "Jr+eyuStxZ6zpecq3rri9qznypamM3wtF9gKkPk2Dw+CO2vUaea5LkyMtsy9" +
       "yTunN774xlTxW1BS70Y+AZLE7uxzaUpLQsGwO5RdTEOOZzc5nSu+NrFpVezP" +
       "v2Ynf8SL72Zv+rB47cxDV481nW7xo4oeVATFC06xA/P9E8p2LI7pQ6hKMrpS" +
       "ICLMIgmyo1KfRf1boEHC7GKasyrTS28UCWrNPqRk38OWy+o41reoSYVlPqj1" +
       "K6wexz82ZsyUJzXNxWD12A5yIxwr6G6Ap4ZDvZqWPsOV3KOxaI/nAp84436f" +
       "vdLmxn8ALn+YojQdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "e2F+j53+8W2ffOPvPvX1/MD8/wAHWxDtkycAAA==");
}
