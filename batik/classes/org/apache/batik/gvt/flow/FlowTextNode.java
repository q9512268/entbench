package org.apache.batik.gvt.flow;
public class FlowTextNode extends org.apache.batik.gvt.TextNode {
    public FlowTextNode() { super();
                            textPainter = org.apache.batik.gvt.flow.FlowTextPainter.
                                            getInstance(
                                              ); }
    public void setTextPainter(org.apache.batik.gvt.TextPainter textPainter) {
        if (textPainter ==
              null)
            this.
              textPainter =
              org.apache.batik.gvt.flow.FlowTextPainter.
                getInstance(
                  );
        else
            this.
              textPainter =
              textPainter;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwcRxWfO387/o5jp0nsxI6TyEm4bURDqRxKHddOHM72" +
                                                              "KXYj6tBc5vbm7jbe293szp7PLoa2EoopIoqC2wZE/Zer8tE2FaICBK2MKtFW" +
                                                              "BaSWCCioKRJ/ED4iGiGVPwKUNzO7t3t7d4mKxEk7tzfz5s28N7/3e2/uueuo" +
                                                              "xjJRL9FohC4YxIqMajSGTYskR1RsWTPQF5efqsL/OHVt8p4wqp1FLRlsTcjY" +
                                                              "ImMKUZPWLOpRNItiTSbWJCFJNiNmEouYOUwVXZtFmxRrPGuoiqzQCT1JmMAJ" +
                                                              "bEZRO6bUVBI2JeOOAop6orATie9EGg4OD0VRk6wbC574Zp/4iG+ESWa9tSyK" +
                                                              "2qJncA5LNlVUKapYdChvon2Gri6kVZ1GSJ5GzqgHHRccix4scUH/i60f3LyQ" +
                                                              "aeMu2Ig1TafcPOs4sXQ1R5JR1Or1jqoka51FX0BVUbTBJ0zRQNRdVIJFJVjU" +
                                                              "tdaTgt03E83OjujcHOpqqjVktiGK+oqVGNjEWUdNjO8ZNNRTx3Y+GazdUbBW" +
                                                              "WFli4hP7pJWnTrV9rwq1zqJWRZtm25FhExQWmQWHkmyCmNZwMkmSs6hdg8Oe" +
                                                              "JqaCVWXROekOS0lrmNpw/K5bWKdtEJOv6fkKzhFsM22Z6mbBvBQHlPOrJqXi" +
                                                              "NNja5dkqLBxj/WBgowIbM1MYcOdMqZ5TtCRF24MzCjYOfAYEYGpdltCMXliq" +
                                                              "WsPQgToERFSspaVpgJ6WBtEaHQBoUrSlolLmawPLczhN4gyRAbmYGAKpBu4I" +
                                                              "NoWiTUExrglOaUvglHznc33y0PmHtaNaGIVgz0kiq2z/G2BSb2DScZIiJoE4" +
                                                              "EBOb9kafxF0vL4cRAuFNAWEh84PP37hvf+/660JmaxmZqcQZItO4vJZoeWvb" +
                                                              "yOA9VWwb9YZuKezwiyznURZzRobyBjBMV0EjG4y4g+vHf/bgI98hfw2jxnFU" +
                                                              "K+uqnQUctct61lBUYh4hGjExJclx1EC05AgfH0d18B5VNCJ6p1Ipi9BxVK3y" +
                                                              "rlqd/wYXpUAFc1EjvCtaSnffDUwz/D1vIITq4EFN8PQh8eHfFD0oZfQskbCM" +
                                                              "NUXTpZipM/stCRgnAb7NSAlA/Zxk6bYJEJR0My1hwEGGOAPpHJVSqj4PgNXn" +
                                                              "ZyCEJoGQIgxixv9TeZ5ZtnE+FAKnbwuGvArRclRXk8SMyyv24dEbL8TfFHBi" +
                                                              "IeD4hKLdsF5ErBfh60VgvQhbL+JfD4VCfJlOtq44VziVOYhvINimwemHjp1e" +
                                                              "7q8CQBnz1eBSJtpflGhGPBJwmTsuX+5oXuy7euDVMKqOog4sUxurLG8Mm2lg" +
                                                              "JHnOCdqmBKQgLxPs8GUClsJMXSZJIKJKGcHRUq/niMn6Ker0aXDzFItIqXKW" +
                                                              "KLt/tH5p/tETX7wzjMLF5M+WrAHeYtNjjLIL1DwQDPpyelvPXfvg8pNLuhf+" +
                                                              "RdnETYIlM5kN/UEgBN0Tl/fuwC/FX14a4G5vAHqmGMIJmK83uEYRuwy5TM1s" +
                                                              "qQeDU7qZxSobcn3cSDMmgKbQwxHazt87ARYbWLh1w7PTiT/+zUa7DNZ2C0Qz" +
                                                              "nAWs4JngU9PG07/95Z8/zt3tJo1WX7afJnTIR1RMWQenpHYPtjMmISD37qXY" +
                                                              "1564fu4kxyxI7Cy34ABrR4Cg4AjBzV96/ew7711duxL2cE4hU9sJKHjyBSNZ" +
                                                              "P2q8hZGw2m5vP0B0KvABQ83AAxrgU0kpOKESFlj/at114KW/nW8TOFChx4XR" +
                                                              "/tsr8PrvOIweefPUP3u5mpDMEq3nM09MsPdGT/OwaeIFto/8o2/3fP01/DTk" +
                                                              "AeBeS1kknE4R9wHih3aQ238nb+8KjN3Nml2WH/zF8eUriOLyhSvvN594/5Ub" +
                                                              "fLfFFZX/rCewMSTgxZrdeVDfHSSno9jKgNxd65Ofa1PXb4LGWdAoA81aUyYw" +
                                                              "Y74IGY50Td3vfvpq1+m3qlB4DDWqOk6OYR5kqAHQTawMkGre+PR94nDn66Fp" +
                                                              "46aiEuNLOpiDt5c/utGsQbmzF3/Y/f1Dz65e5SgzhI6tfoV7WLOvgDf+qQ0m" +
                                                              "NT/eijSYqKdS3cFrprXHVlaTU88cENVBR3EuH4VS9flf//vnkUt/eKNMMmmg" +
                                                              "uvExleSI6luT5YKeolwwwUsyj4/ebbn4xx8NpA9/lDTA+npvQ/Ts93YwYm9l" +
                                                              "Wg9u5bXH/rJl5t7M6Y/A6NsD7gyq/PbEc28c2S1fDPP6U5B5Sd1aPGnI71hY" +
                                                              "1CRQaGvMTNbTzGG/s5hV74ZnjwOAPeVZtQx2ClxVaWogqkPOibLfmyETly0e" +
                                                              "WM0Qw7xk5yvP3IIaPsuaKYpaoIzzzQPIDN7ixmYqWSD4nFPzSksd781989rz" +
                                                              "ArHBAjkgTJZXHv8wcn5FoFfcInaWFPL+OeImwXfbJhz3IXxC8PyHPcwU1iEq" +
                                                              "yY4Rp5zdUahnWQybqO9W2+JLjP3p8tKPv7V0Luy45ghF1TldEVeXT7ImJuJ/" +
                                                              "6H/kHtYxbOQpavJXdoySNpfcF8UdR35htbW+e/WB3/DILNxDmiDGUraq+iDq" +
                                                              "h2utYZKUwm1oEgxt8C+FojsqVptgLPviu84IeYiTznLyFFVB65fU4dIflKSo" +
                                                              "hn/75aDEafTkIHeLF7+IDdpBhL3mDBfnPRVxzjyYD5VyND+vTbc7Lx8p7yyC" +
                                                              "O7/mu3xii4s+lMurxyYfvvGJZ0T9I6t4cZFfC+GWK0qxAif1VdTm6qo9Oniz" +
                                                              "5cWGXS7a2sWGPabY6ovSYYh5gwFlS6A4sAYKNcI7a4de+cVy7dsQWCdRCFO0" +
                                                              "8aTvki1ulFBh2JAMTka9dOD7m4hXLUOD31i4d3/q77/n6c9JH9sqy8flK88+" +
                                                              "9KuLm9egutkwjmogkEh+FjUq1v0L2nEi58xZ1KxYo3nYImhRsDqO6m1NOWuT" +
                                                              "8WQUtTBMY/YHAPeL487mQi+rninqLyWI0jsHlArzxDys21qSszTkD6+n6P8H" +
                                                              "l9ZtwwhM8HoKR9lZantcvv/LrT+50FE1BnFZZI5ffZ1lJwopw/+XhJdD2lhz" +
                                                              "Ki+oqyoenTAMl8pqv2sI+C8LGdZPUWiv0+tLBuznV7i6x/kra776Xz5Jtgxt" +
                                                              "FAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU5a8wraVlzvrPnusueswvsLit7P4C7xW867Uxn6kGgl5l2" +
       "ptPOtJ3eRuEwnUtn2rnfW1y5RF2EuBJdEBPYXxCVLBeNRBODWWMUCMQEQ7wl" +
       "AjEmokjC/hCJqPjO9Lv0+845S4ixSd9O3/d5nve5v8/7zAvfgc4FPlRwHXO9" +
       "MJ1wX03D/aWJ7YdrVw32GRbjJT9QlYYpBYEA5m7Ij3/2yvd+8EH96h50XoRe" +
       "Kdm2E0qh4djBQA0cM1YVFrpyPEuaqhWE0FV2KcUSHIWGCbNGEF5noTt3UEPo" +
       "GnvIAgxYgAELcM4CXDuGAkivUO3IamQYkh0GHvQL0BkWOu/KGXsh9NhJIq7k" +
       "S9YBGT6XAFC4mP0fA6Fy5NSHHj2SfSvzTQJ/qAA/95tvv/r7Z6ErInTFsIcZ" +
       "OzJgIgSbiNBdlmrNVT+oKYqqiNA9tqoqQ9U3JNPY5HyL0L2BsbClMPLVIyVl" +
       "k5Gr+vmex5q7S85k8yM5dPwj8TRDNZXDf+c0U1oAWe87lnUrIZXNAwEvG4Ax" +
       "X5Nk9RDljpVhKyH0yGmMIxmvdQAAQL1gqaHuHG11hy2BCejere1MyV7Aw9A3" +
       "7AUAPedEYJcQevC2RDNdu5K8khbqjRB64DQcv10CUJdyRWQoIfTq02A5JWCl" +
       "B09Zacc+3+m96dl32m17L+dZUWUz4/8iQHr4FNJA1VRftWV1i3jXU+yHpfs+" +
       "/749CALArz4FvIX5w59/6a1vfPjFL25hfuIWMNx8qcrhDfnj87u/+trGk9Wz" +
       "GRsXXScwMuOfkDx3f/5g5Xrqgsi774hitrh/uPji4C9m7/6k+u096DINnZcd" +
       "M7KAH90jO5ZrmKrfUm3Vl0JVoaFLqq008nUaugCeWcNWt7OcpgVqSEN3mPnU" +
       "eSf/D1SkARKZii6AZ8PWnMNnVwr1/Dl1IQi6AL7QXeD7GLT95L8hNIN1x1Jh" +
       "SZZsw3Zg3ncy+QNYtcM50K0Oz4HXr+DAiXzggrDjL2AJ+IGuHiws4hDWTCcB" +
       "DuskAgihnqOo+5mLuf+fxNNMsqvJmTNA6a89HfImiJa2Yyqqf0N+LqqTL336" +
       "xpf3jkLgQCch9Hqw3/52v/18v32w33623/7uftCZM/k2r8r23doVWGUF4htk" +
       "vrueHL6Necf7Hj8LHMpN7gAqzUDh2yfgxnFGoPO8JwO3hF78SPKe8buKe9De" +
       "yUya8QqmLmfofJb/jvLctdMRdCu6V5751vc+8+GnneNYOpGaD0L8ZswsRB8/" +
       "rVXfkVUFJL1j8k89Kn3uxuefvrYH3QHiHuS6UAK+CdLIw6f3OBGq1w/TXibL" +
       "OSCw5viWZGZLh7nqcqj7wAJHM7m5786f7wE6vjPz3fvB94kDZ85/s9VXutn4" +
       "qq17ZEY7JUWeVn9m6H7sb//yX8q5ug8z8JWdM22ohtd3oj4jdiWP73uOfUDw" +
       "VRXA/cNH+N/40Hee+dncAQDEE7fa8Fo2NkC0AxMCNf/SF72/+8bXP/61vWOn" +
       "CcGxF81NQ06PhMzmocsvIyTY7fXH/ICsYYLgyrzm2si2HMXQDGluqpmX/teV" +
       "1yGf+7dnr279wAQzh270xh9N4Hj+NXXo3V9++388nJM5I2en1rHOjsG2qfCV" +
       "x5Rrvi+tMz7S9/zVQ7/1BeljIKmCRBYYGzXPTVCuAyg3GpzL/1Q+7p9aQ7Lh" +
       "kWDX+U/G1051cUP+4Ne++4rxd//kpZzbk+XJrq27knt9617Z8GgKyN9/OtLb" +
       "UqADOPTF3s9dNV/8AaAoAooyyFkB54M0k57wjAPocxf+/k//7L53fPUstEdB" +
       "l01HUigpDzLoEvBuNdBBhkrdt7x1a9zkIhiu5qJCNwm/dYoH8n9nAYNP3j6/" +
       "UFl1cRyiD/wnZ87f+4/fv0kJeWa5xaF6Cl+EX/jog403fzvHPw7xDPvh9ObU" +
       "CyqxY9zSJ61/33v8/J/vQRdE6Kp8UOaNJTPKAkcEpU1wWPuBUvDE+skyZXsm" +
       "Xz9KYa89nV52tj2dXI5TPnjOoLPny7v55IfgcwZ8/yf7ZurOJraH472NgxP6" +
       "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" +
       "rv8FTUsEyjwfAAA=");
}
