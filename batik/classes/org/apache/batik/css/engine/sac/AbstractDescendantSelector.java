package org.apache.batik.css.engine.sac;
public abstract class AbstractDescendantSelector implements org.w3c.css.sac.DescendantSelector, org.apache.batik.css.engine.sac.ExtendedSelector {
    protected org.w3c.css.sac.Selector ancestorSelector;
    protected org.w3c.css.sac.SimpleSelector simpleSelector;
    protected AbstractDescendantSelector(org.w3c.css.sac.Selector ancestor,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          );
        ancestorSelector =
          ancestor;
        simpleSelector =
          simple;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractDescendantSelector s =
                                                    (org.apache.batik.css.engine.sac.AbstractDescendantSelector)
                                                      obj;
                                                  return s.
                                                           simpleSelector.
                                                    equals(
                                                      simpleSelector);
    }
    public int getSpecificity() { return ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                            ancestorSelector).
                                    getSpecificity(
                                      ) +
                                    ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                       simpleSelector).
                                    getSpecificity(
                                      ); }
    public org.w3c.css.sac.Selector getAncestorSelector() {
        return ancestorSelector;
    }
    public org.w3c.css.sac.SimpleSelector getSimpleSelector() {
        return simpleSelector;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WnvwIdNJRsvt9JYmWcpndeBGzc/tAh1JjfFNG//BzBfWnjp+lTusZs4xx9ox" +
       "SCMegObHAwcjTr/z6V+c+ubRUbPAWJYfGH18s/7ZK8f2/fYfWSbnkJij+PHx" +
       "D4TPPN3Y/sCHnN/BJuRuSWenPsB3h/fu08m/BZtLXw+SsgFSJ1rl+DZBTmHE" +
       "D0AJatg1OpTsnnFvOWnWTq0Z7J3rx0XXsn5UdFIuvCM1vlfnA8KlFkAs9QNh" +
       "gPCXbs6yFJsV2fCSjxvOT/yAB65mRxb232eiK7ZrsekxPeLBvA64wSvwSuux" +
       "33MJvKWgwPm4GakxPECAvZ/xibu1gLjm0FLeLsfmLtPNGZzCUjE4zDJSLljV" +
       "jYPT/FNr15D2txun3RFjQVizH8KyqyWbdNVkBVdHmgEnHsws/IOwnJfvSMGP" +
       "Qyf2HT4e7z252ozLBm+Z3gGn0LO//Pfl0LEP3sxR/1UwVbtLpiNUdulVjEt6" +
       "kKCbn7acsHq/5tDvftgyuO5OqjTsa5qkDsPf80GJ5fnBxS/KG/v+1LjlgaFd" +
       "d1BwzfeZ0z/l97rPvLlhiXgoyI+WZrxnHUm9TK3eKK/UKZyhlS2eWF+UcbKp" +
       "6FOz4Wm1nKw1d9GT04ED+LrDV1lUFpjMlzsDVjluOWQdTxiIcSET4/jarEDC" +
       "5Q0cF0vpHth2w1vXoxf0pyCs+nQpCSXXiHWCvbtvlzjR0vd700ln52Aw6aY/" +
       "G/76tnd3X+bbWY7+kzGiy3fAz1zVZJ1pi4/hE4DnP/igtNiB34Dk7dZxdEHm" +
       "PIrJr2AW8ykQ3ttwbfjp62dNBfwpy0dMJw5/7ePQgcNmxJmXGouy7hXcPObF" +
       "hqkONntRuoWFVuEcnX84v/elZ/fuD1p7k2CkLKaqMhWUrA2HEtprdlPW9V+t" +
       "fflgQ1EnxHIXKU8p0p4U7Yp7/bnMSMVc++DcgzjebUmNNmcksNyuLThMq5Nl" +
       "lcJlDXZ0aLx/d8btEaPJPHg6LbfvLBBD2OzJjph8rAWc/8kCY0ewOQCJa5Cy" +
       "fo2KUHKLEhvjtOPWpuLXo673JxgpkqwLQtdm4c8JlwW/8QlYkKc7rBN6LTP0" +
       "3rkF87EWsNLJAmOnsPkOI1PBgm25yhXHIt/9BCzSiGMr4HnYUuvhO7dIPtYC" +
       "Wj9fYOwFbM4yUo8+lV0POfY497+wR5qRxvw3Pni+mJV1B23em4rnjteWzzy+" +
       "9V1eEmTuNqsAxBMpWXZXwK73Uk2nCYkrWmXWwxr/ehkS7iSFEsQNtFyRl0ym" +
       "HzEypwATJiz+4ub5CSPTcvHA7NC6KV+HVOmnZKSEf7vpLjJS6dDBouaLm+QS" +
       "zA4k+HpZy5+HA66SjLiwYPpkO51hcd9hYH7jfzPYCSBl/tEQFc8f39TzyM37" +
       "Tpp3KKIsjHOwmgKwb17nZAqnhXlns+cq3bjsds1zFYvtfFRvCuyEzRyXb3cA" +
       "0GnoVI2+2wWjJXPJ8N6Jta/+bKL0bcik20lAAGjYnn0qS2spqFi3R7LTGxSZ" +
       "/Nqjddm3xx5YmfjLb/i5l5jpcG5++qh45dSOdw7NOtEUJFO6SAmkWprmx8X1" +
       "Y8pmKo7oA6RaMjrSICLMIgmyJ3fWoP8L+AcEt4tlzupML97AwbEhuyLIvres" +
       "lNVRqq9TU0rcyr5TnB7P/x9WTFWmNM3H4PS4qqb9ZhbC3QB/jEa6Nc0umEpv" +
       "aRwQJnKnJWyv8VdsPvgv74tPnIIcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Jcf/Ai5BCloEJwAA");
}
