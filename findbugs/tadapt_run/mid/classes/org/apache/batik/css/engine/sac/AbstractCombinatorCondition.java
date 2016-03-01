package org.apache.batik.css.engine.sac;
public abstract class AbstractCombinatorCondition implements org.w3c.css.sac.CombinatorCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected org.w3c.css.sac.Condition firstCondition;
    protected org.w3c.css.sac.Condition secondCondition;
    protected AbstractCombinatorCondition(org.w3c.css.sac.Condition c1, org.w3c.css.sac.Condition c2) {
        super(
          );
        firstCondition =
          c1;
        secondCondition =
          c2;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractCombinatorCondition c =
                                                    (org.apache.batik.css.engine.sac.AbstractCombinatorCondition)
                                                      obj;
                                                  return c.
                                                           firstCondition.
                                                    equals(
                                                      firstCondition) &&
                                                    c.
                                                      secondCondition.
                                                    equals(
                                                      secondCondition);
    }
    public int getSpecificity() { return ((org.apache.batik.css.engine.sac.ExtendedCondition)
                                            getFirstCondition(
                                              )).
                                    getSpecificity(
                                      ) +
                                    ((org.apache.batik.css.engine.sac.ExtendedCondition)
                                       getSecondCondition(
                                         )).
                                    getSpecificity(
                                      ); }
    public org.w3c.css.sac.Condition getFirstCondition() {
        return firstCondition;
    }
    public org.w3c.css.sac.Condition getSecondCondition() {
        return secondCondition;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uoj410TG+A91l9hgoBsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OYoVcaYj6GbOxIzb0Oroqq4mYjGaOmbZ8T1GlrBSk+0VsCnerwzKEVJryLVO" +
       "db1QEMXqpFi16tso2le80gisTyuGsO7jPaNErTCWlwqbdTcyi4YvFykvLARW" +
       "lxTM/tSSOhg96YxcaR3Gg1VV0adEmqJKr19R+SJcLrDtWrUmdXtIi5njYo0j" +
       "Gd5Ce2ujbNZHkyk/CIloTE9Iem4YQjusuWhIppUCUpTWIpiEWWs20CdLAnGp" +
       "1ITDZbSuxnZxjKySDm0SsYvZHXTS1UWrObZ4hq0gjjGbDoZDeDBd4OOJWl9w" +
       "pkgPmQkNG0Ii2RPZ5ofDgGwRWFCupQujuxaVCbOctlInssPZbCj4nFfB2TKz" +
       "1qf9emRV5321DBO1tR85y3IRmbQLeL0Idmqa0wjApvKNb8y2m/ZL2/Hfmh9u" +
       "HFwogo1+VrF4CTvd5OoN7uQNhtBpYe9W5PBEOv+d37+Z2v8/eiJ9eP54cJr7" +
       "8JWnuVfcsuzTFl/spqaVhIotK4fnTNkBwr3XuqrMDw8+/uTTz8rMJ4o7e6fD" +
       "RgidCR339aayVswjCt8IJD127YOSfn5Te3hq+ZUn/+WeyZv0t72EW5v7j+l5" +
       "XOTv9p/7WvsR6dd2oBsOzjCvuEO+nOnxy08uz/pKGPn25LLzy3sPxu/2bLhe" +
       "AZ763vjVjx/5HbrP1c/7plv3O3b4fmLv7uvKc7XtkWzO9P7rnNg/lSXvDqFT" +
       "ihcJZpDTyEf8Vw+hm0THMRXBPvTt97zYKc7RVvKCJw96InNi6F7wtPZ6ovXz" +
       "6YmjRv3mdeo+liXPhNA5TQlZV5EM1ZCMcHM1w28w9j68yI3+8M9g9B1ZYXZk" +
       "PdgzevDzN/qT16l7Lks+AaALGE1eeZR9aORv/axGZmf03J6R3M/fyD+4Tt0X" +
       "suT3Qui2bGSvciZ+aOXnXoqVSQi98jrX1NmF291XfFez/RZE+vSz50/f9ez0" +
       "r/Ob2oPvNc70oNNqZJpHLz6O5E+5vqIauUlnttcgbv73xwCTXgSlgc+CNDfh" +
       "S1umPwXaX4cpC/w8c5TnyyH08qvxAOkgPUr5VQA5xylD6GT+f5Tu6yF09pAO" +
       "NLrNHCX5JpAOSLLsX+Tu8oHkxJE5Ys/b8uG77cWG74Dl6L1wNq/kn0ntzwHR" +
       "9kOpS9Jnnu0M3v5C9RPbe2nJFNI0k3K6B920vSI/mEcevKa0fVmnqEd/cu6z" +
       "Z169P+ed2yp86PlHdLv/6jfALcsN8zvb9At3/f4bfvvZ7+RXFP8LgPV4N78m" +
       "AAA=");
}
