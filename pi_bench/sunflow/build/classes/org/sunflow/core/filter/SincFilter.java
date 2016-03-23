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
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYDWwUxxWeO/9iG/yDDYQfA8YQGchdSEMbZEoBYwfTs7Fs" +
                                                              "gtSj4djbm7MX7+0uu3P22anTBLWCpiolCSGkIlRqiZIiElDVNK3aRFRRm0RJ" +
                                                              "KyVNmqRVSNVWKm2KGlQ1qUrb9L2Z/b+zKVJ60s7Ozbz3Zt6b9773Zs9eJhWW" +
                                                              "SVqpxmJswqBWrFtjA5Jp0UyXKlnWLhhLyQ+XSX/be6l/Q5RUJsmcEcnqkyWL" +
                                                              "9ihUzVhJskTRLCZpMrX6Kc0gx4BJLWqOSUzRtSRpUazenKEqssL69AxFgt2S" +
                                                              "mSCNEmOmks4z2msLYGRJAnYS5zuJbwlPdyZInawbEx75Ah95l28GKXPeWhYj" +
                                                              "DYn90pgUzzNFjScUi3UWTLLG0NWJYVVnMVpgsf3qetsEOxLri0zQdr7+g6tH" +
                                                              "Rxq4CeZKmqYzrp41SC1dHaOZBKn3RrtVmrMOkLtJWYLU+ogZaU84i8Zh0Tgs" +
                                                              "6mjrUcHuZ1Mtn+vSuTrMkVRpyLghRpYHhRiSKeVsMQN8zyChmtm6c2bQdpmr" +
                                                              "rdCySMWH1sSPPby34btlpD5J6hVtCLcjwyYYLJIEg9JcmprWlkyGZpKkUYPD" +
                                                              "HqKmIqnKpH3STZYyrEksD8fvmAUH8wY1+ZqereAcQTczLzPddNXLcoey/1Vk" +
                                                              "VWkYdJ3n6So07MFxULBGgY2ZWQn8zmYpH1W0DCNLwxyuju2fBQJgrcpRNqK7" +
                                                              "S5VrEgyQJuEiqqQNx4fA9bRhIK3QwQFNRhZOKxRtbUjyqDRMU+iRIboBMQVU" +
                                                              "s7ghkIWRljAZlwSntDB0Sr7zudy/8chd2nYtSiKw5wyVVdx/LTC1hpgGaZaa" +
                                                              "FOJAMNatThyX5j17OEoIELeEiAXNM1+4snlt64UXBc2iEjQ70/upzFLy6fSc" +
                                                              "Vxd3dWwow21UG7ql4OEHNOdRNmDPdBYMQJh5rkScjDmTFwZ/9rl7ztD3oqSm" +
                                                              "l1TKuprPgR81ynrOUFRq3k41akqMZnrJLKpluvh8L6mCfkLRqBjdmc1alPWS" +
                                                              "cpUPVer8P5goCyLQRDXQV7Ss7vQNiY3wfsEghFTBQzrgqSDix9+M9MdH9ByN" +
                                                              "G0p8wNRRdSsOYJMGs47ErbyWVfXxuGXKcd0cdv/LuknjsCy4THxI0eQe3o2h" +
                                                              "Xxkfu8QC6jB3PBIB8y4OB7cKcbFdVzPUTMnH8lu7rzyVelk4Djq7rT0jbbBW" +
                                                              "zF4rhmvFxFoxby0SifAlmnFNcXpg+1GIYoDRuo6hO3fsO9xWBm5jjJeD4ZC0" +
                                                              "LZBOurxQd/A5JZ9rmj25/OK656OkPEGaJJnlJRWzwxZzGHBHHrVDsy4NicbD" +
                                                              "+2U+vMdEZeoyzQDcTIf7tpRqfYyaOM5Is0+Ck40w7uLT54KS+ycXTozfu/uL" +
                                                              "N0dJNAjxuGQFoBOyDyAwuwDcHg7tUnLrD1364NzxKd0L8kDOcFJdESfq0BZ2" +
                                                              "grB5UvLqZdLTqWen2rnZZwEIMwmCBvCtNbxGAEM6HTxGXapB4axu5iQVpxwb" +
                                                              "17ARUx/3Rrh3NvJ+M7hFLQZVCzzVdpTxN87OM7CdL7wZ/SykBcf7Tw8Zj771" +
                                                              "iz99gpvbSQ31vpw+RFmnD45QWBMHnkbPbXeZlALdOycGHnzo8qE93GeBYkWp" +
                                                              "Bdux7QIYgiMEM3/5xQNvv3vx9OtRz88Z5ON8GsqagqskjpOaGZSE1VZ5+wE4" +
                                                              "UwEF0Gva79DAP5WsIqVVioH1r/qV657+y5EG4QcqjDhutPbaArzxG7aSe17e" +
                                                              "+2ErFxORMZ16NvPIBEbP9SRvMU1pAvdRuPe1JY+8ID0KaA8IaymTlINmpFSs" +
                                                              "YzwN5dMWxKWSg2MYs/PPLQP75MPtA38QueWGEgyCruWJ+Nd2v7n/FX7I1Rj5" +
                                                              "OI56z/bFNSCEz8MahPE/gl8Env/gg0bHAYHjTV12MlnmZhPDKMDOO2Yo/4IK" +
                                                              "xKea3h09eelJoUA424aI6eFj930UO3JMnJwoSVYUVQV+HlGWCHWw2YC7Wz7T" +
                                                              "Kpyj54/npn70xNQhsaumYILthvrxyV/9+5XYid++VAL3IYR0SRSWtwaOszl4" +
                                                              "OkKlbV+p//HRprIeQI1eUp3XlAN52pvxy4SaysqnfcflFTt8wK8cHg0jkdVw" +
                                                              "Cnx4Pd/Gze5mCN8M4XPbsVlp+cEzeFi+sjklH339/dm733/uClc4WHf7saJP" +
                                                              "MoS1G7FZhdaeH05u2yVrBOhuvdD/+Qb1wlWQmASJMhSb1k4TsmohgCw2dUXV" +
                                                              "r3/y/Lx9r5aRaA+pAQtneiQO0mQWoCO1RiAhF4zPbBbgMI7o0MBVJUXKFw1g" +
                                                              "gC4tHfrdOYPxYJ38wfzvbXz81EWOUoaQscg92sWBrMxvb15iOPPLT73x+P3H" +
                                                              "x4UzzRAaIb4F/9yppg/+7h9FJud5sES0hPiT8bMnF3Zteo/zewkJudsLxXUN" +
                                                              "JHWP95Yzub9H2yp/GiVVSdIg27el3ZKaR5hPwg3Bcq5QcKMKzAerfVHadroJ" +
                                                              "d3E4XH3LhlOhPwbKWcDfvexXh0eInUo7MVSGs1+E8E6Ss9zI29XY3OQkmyrD" +
                                                              "VOBGTUPZpnYGoRBknPg2kVqx7cVmj5CRKOWIYupGbNa4K7nSAyWyP6/5PQ37" +
                                                              "CxiZX1RainoSw23JdLccDmynDx47ldn52LqoDQKbGcSPbtyk0jGq+pYqQ0kB" +
                                                              "p+7j9zrPQ96Z88Dvf9g+vPV6qkwca71GHYn/l4J7rp4+TsJbeeHgnxfu2jSy" +
                                                              "7zoKxqUhK4VFfqfv7Eu3r5IfiPJLrHDdostvkKkz6LA1JoXbuhaE6RXuuTfi" +
                                                              "MS9w/Nd5FxdtJVzGLYWmY50B9PMzzI1jAwmsapiyIahGuH97rn1gBtf+HzAW" +
                                                              "BwYNPq4GrdDsyHHe12eF6VhDmkb5RqJu0N7GRR+cwR5fwmaKkTKwR8gWd/8f" +
                                                              "bNHkeIQDC83XsMWdxXA1HWtIS7sm8czw9RnMcD8290FJbsG9dV0mZImvfhyW" +
                                                              "KDBS492KMR0vKPqiJr4CyU+dqq+ef+qONznsuF9q6gBAsnlV9ScMX7/SMGlW" +
                                                              "4drUifRh8NcjpaBU3NIZfjPDDt/zCUF/kpGGMD0j5fjyk32TkVofGcMCjvf8" +
                                                              "RN8CxwIi7H7bcIC9gVchmDhjInEWIj5Qtg3I7d5yLbu7LP5bGEIp/6TpwF5e" +
                                                              "fNRMyedO7ei/68onHxO3QFmVJidRSi1Un+JC6kLn8mmlObIqt3dcnXN+1kon" +
                                                              "yTSKDXvuu8jnXoPgiAYe+cLQFclqd29Kb5/e+NzPD1e+BpXMHhKRGJm7p7jE" +
                                                              "KBh5yFl7EsVVNqQZfnfr7PjGxKa12b/+hhdxpKh0C9NDCfXgW73nRz/czL+h" +
                                                              "VUD+pAVe+2yb0AapPGYGSvY56I0SftzkdrDNN9sdxW8GjLQV31eKv7RAgTtO" +
                                                              "za16XuPxBkV/rTcS+LbqZJu8YYQYvBHfnW4bNhsKaH3wv1SizzCc69wbBo/G" +
                                                              "7lIo0c2Zv8+72DzzXxAjwgzdGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "U5TL8029gJY7aTqNm8tokSp98KmVfYLpr+/T8I78K/jg2gh8EWYd09fx9bft" +
       "eiQr3nyQMTjIEhy7ajia0jzM2Jza/+K+97oU/TYvn+WcHnit26I8ufbS08+/" +
       "qAw/XtrZy4ShAXQxcNyfMtWNah6Z6jTg9PhrJ4eo/LLsMEPzhaf/5f7R2/V3" +
       "v45s/UMn5DzJ8neol7/Uf4v8qzvQ6YN8zXXXeMcHPXE8S3PJU4PQs0fHcjUP" +
       "HFg+t/59+0mb/ff1GfMbJ2pyL9n6xk0SjU/dpO/prHhPAJ1fqOC7Js1lRA49" +
       "6b0/LI9wlF/eEB9X7a59+v33j67aTk6wc5CQQnKqX76Jks9lxTMBdBooeULB" +
       "Z38EBe/cX7u79hS86/UqSN1QwVOHBFvdXriJbr+RFR/K0maGLZeUE+o9/3rU" +
       "iwPo0uH1WnZXcN91V/Pb62T50y9evnDvi+O/zm+YDq58L5LQBS00zaNJyiP1" +
       "c66nakYu9cVtytLNX791IyzZXvcF2eV7VsmF/c0t/UsBdOUkfQCdyV5HyT4R" +
       "QLccIQM+vlc7SvRJ4BWAKKv+rnuDXOI2WRufOoJKex6Q2/fOH2bfgyFHb6Ay" +
       "JMv/N2IfdcLtf0dckz/zIk6/59Xax7c3YLIppmnG5QIJnd9exh0g1yOvyW2f" +
       "17nBY9+//bMX37yPsrdvBT70ySOyPXTj66au5Qb5BVH6h/f+/ts+8eLX89Tm" +
       "/wKQE8grtCIAAA==");
}
