package edu.umd.cs.findbugs;
public class NonReportingDetectorToDetector2Adapter extends edu.umd.cs.findbugs.DetectorToDetector2Adapter implements edu.umd.cs.findbugs.NonReportingDetector {
    public NonReportingDetectorToDetector2Adapter(edu.umd.cs.findbugs.Detector detector) {
        super(
          detector);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVXW2wc1Rk+u+t77KztJE7IxSTGSZtLd0ibVAoObZyN3Thd" +
                                                              "O9s4BLGGLGdnznonnp0Zz5yx16a0UKkifUGRCJBWwk9BSFULUVXUPhRkhNRS" +
                                                              "0VYCoZaLCH2kaqMSVYKH9Pb/Z647u6Z560p79uw5//nPf/n+y/nJDdJqW2SQ" +
                                                              "6TzDl0xmZ8Z0nqeWzZSsRm37LKwV5WdT9B/nP546kiRtBbK+Qu1JmdpsXGWa" +
                                                              "YhfIDlW3OdVlZk8xpuCJvMVsZi1Qrhp6gWxS7YmqqamyyicNhSHBOWrlSB/l" +
                                                              "3FJLDmcTHgNOduRAEklIIo3Gt0dypFs2zKWQfEuEPBvZQcpqeJfNSW/uAl2g" +
                                                              "ksNVTcqpNh+pWWS/aWhLs5rBM6zGMxe0w54JTuUON5hg6Fr601uXKr3CBBuo" +
                                                              "rhtcqGefYbahLTAlR9Lh6pjGqvY8+Q5J5ci6CDEnwzn/UgkuleBSX9uQCqTv" +
                                                              "YbpTzRpCHe5zajNlFIiTXfVMTGrRqscmL2QGDh3c010cBm13Btq6Wjao+PR+" +
                                                              "6fKz53t/liLpAkmr+jSKI4MQHC4pgEFZtcQse1RRmFIgfTo4e5pZKtXUZc/T" +
                                                              "/bY6q1PugPt9s+CiYzJL3BnaCvwIulmOzA0rUK8sAOX9ay1rdBZ0HQh1dTUc" +
                                                              "x3VQsEsFwawyBdx5R1rmVF3h5M74iUDH4W8CARxtrzJeMYKrWnQKC6TfhYhG" +
                                                              "9VlpGqCnzwJpqwEAtDjZuiZTtLVJ5Tk6y4qIyBhd3t0Cqk5hCDzCyaY4meAE" +
                                                              "Xtoa81LEPzemjj75iH5ST5IEyKwwWUP518GhwdihM6zMLAZx4B7s3pd7hg68" +
                                                              "cjFJCBBvihG7NL/49s1jBwZX33BptjWhOV26wGRelK+W1r+1Pbv3SArF6DAN" +
                                                              "W0Xn12kuoizv7YzUTMgwAwFH3Mz4m6tnfv3AYz9mf02SrgnSJhuaUwUc9clG" +
                                                              "1VQ1Zn2D6cyinCkTpJPpSlbsT5B2mOdUnbmrp8tlm/EJ0qKJpTZD/AcTlYEF" +
                                                              "mqgL5qpeNvy5SXlFzGsmIaQdvmQBvncQ9yN+OZmXKkaVSVSmuqobUt4yUH9b" +
                                                              "goxTAttWpDKAqeTM2pJtyZKADlMcyakqkmyHm1OGfoaZhsUBTycYZ4j4s4Y/" +
                                                              "+/KoQk0AWAbPm/+PS2toiQ2LiQQ4aXs8RWgQXScNTWFWUb7sHB+7+WLxTRd+" +
                                                              "GDKeDTm5B2TIgAwZ2c74MmRuTwaSSIirN6IsLjbAs3OQIyBJd++dfujUwxeH" +
                                                              "UgBKc7EF3IKkQ3XFKhsmEj/7F+WX+nuWd10/+HqStORIP5W5QzWsPaPWLGQ1" +
                                                              "ec4L/O4SlLGwmuyMVBMsg5Yhg2IWW6uqeFw6jAVm4TonGyMc/FqHUS2tXWma" +
                                                              "yk9Wryw+fu67dydJsr6A4JWtkPvweB7TfpDeh+OJoxnf9BMff/rSM48aYQqp" +
                                                              "q0h+IW04iToMxcERN09R3reTvlx85dFhYfZOSPGcQkhC9hyM31GXoUb8bI+6" +
                                                              "dIDCZcOqUg23fBt38YplLIYrArV9Yr4RYLEOQ/YgfLd5MSx+cXfAxHGzi3LE" +
                                                              "WUwLUU3unTafe/cPf/mKMLdfeNKRjmGa8ZFIskNm/SKt9YWwPWsxBnQfXsk/" +
                                                              "9fSNJ2YEZoHirmYXDuOYhSQHLgQzf/+N+fc+un71nWSIcw7V3ilB01QLlMR1" +
                                                              "0vU5SsJte0J5IFlqEGqImuH7dMCnWlZpSWMYWP9M7z748t+e7HVxoMGKD6MD" +
                                                              "/5tBuH7HcfLYm+c/GxRsEjIW69BmIZlbATaEnEctiy6hHLXH397xw9/Q56CW" +
                                                              "QP621WUmUnLCi3UUagsn25ulFz+RCM8eFqR3i/EQWkUwIGLvCA677WiE1Adh" +
                                                              "pPMqypfe+aTn3Cev3hQq1bduUUBMUnPExSAOe2rAfnM8g52kdgXoDq1OPdir" +
                                                              "rd4CjgXgKEO/Yp+2IKXW6uDjUbe2v//a6wMPv5UiyXHSpRlUGaciEkknhACz" +
                                                              "K5CNa+bXj7kIWOyAoVeoShqUb1hAL9zZ3L9jVZMLjyz/cvPPj76wcl1A0XR5" +
                                                              "bIsy/AIO+wNQik9bvHpGQRlyCBz6xdutF2jXHWt1RKKbu/q9yyvK6ecPun1L" +
                                                              "f32XMQZN9E//+K/fZa78+bdNylYnN8wvaWyBaXVqcrLn9moX2nNLQ1ftdoLy" +
                                                              "iyvpjs0r9/1J5MKgW+uGLFJ2NC2QIyoTdvgWK6sCWN0uvEzx8y1ONjSxGQdm" +
                                                              "3lRokHepz3LSFVJzkpTrtu/n0EC525ykYIxuFmAJNnE6Y/r+ynxeADbapZZo" +
                                                              "hM09OGxy5/euCd/gSDRvYrSKJ45n4knHfeRAmV85NfXIza8+7+ZteBwtL4uW" +
                                                              "GDp8t4QE1XHXmtx8Xm0n995af61zd9JLG32uwG7diMqG8yyA2UT3b40lNXs4" +
                                                              "yG3vXT366u8vtr0NwJshCQoenIk8MNxuGjKjAwifyYUtTeSJLLLtyN4fLX3t" +
                                                              "QPnvH4iI9Fqg7WvTF+XCU+9OXJv77JjoqVvBXaxWgNeSfWIJQC0vQCrpcHR1" +
                                                              "3mET8BBbj8ik+NgRdvDM1xOsYpXnZKjhVdOkN4Jstcis44ajK8imB/JnuFL3" +
                                                              "1vLQ3uWYZuxAuBK4bmOjrkX5xA/Sv7rUnxqH6KpTJ8q+3XZKSO3xDp9fYkH4" +
                                                              "sdfNY/+BTwK+/8YvOhkX3FdAf9Z7iuwM3iKQFt29VDE3aZoebdtrphsvVRyM" +
                                                              "Gi5zktjnrR4Kyxr+dcvWvJjiwP8L5HZeYokRAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9nK0osZSJMy6gFOFVputZFZsxXXk5iCLmzW+RFHTeUlfoN3ZQFlVO9mo502c" +
       "sSXSc22k9BbdfNvzZd3L56U5XdJNCmtbQZ3BsyuGxQNhIgYRGVB0fmr25u5i" +
       "TEQkxq2K7tCKls0C7fDt0hLFxyLN9fCo6pTVyQJWk4rahQhP8SGNYqXJqqct" +
       "xnhdIdWyWNSDsIPrNFv3c+VRtYZLog2miu86mrcaDeJOQyfWC39uuYM8HUcu" +
       "qsgrYdWe62G/xBBNEUzsxQBWqR9JytcrP9kJ4vb0sHRwjw4PDslE+yeonDdT" +
       "DyfNYwe3MOnn9PG718O3MNtT98ENxofe621jcny4/0b36enR4dVPXX1F6X0+" +
       "u7N3vSH6yDnfdn7aACtgHFobiXzkg+/tQjO5nbnnmr9aNn8PyF965cLZu18Z" +
       "/nV6p3dwhX+OQc6qgWEcPicf6p92XKDqqX7nNqdmJ/1a+sgd13GFD4XtdVML" +
       "nA217yPnt9Q+siMfmQ595MzetI+chO3hyTUcgpNJ9xlnfxt23+0i6Vq/RCeO" +
       "+HMbNJd+3HHrgOXw/V9yVE3/99pzcSfY/PN1RX79lXb3mbcLn9/cP8qGtF6n" +
       "/5MwyJnNVejBLe/DN5S2L+t08/F3bvvyucf24+O2jcLbsD+k24PXv+yrmY6f" +
       "Xs+tf//urzz12698Jz3M/y9M/5whkBwAAA==");
}
