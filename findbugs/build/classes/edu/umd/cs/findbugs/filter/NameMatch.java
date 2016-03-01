package edu.umd.cs.findbugs.filter;
public class NameMatch {
    @javax.annotation.CheckForNull
    private final java.lang.String spec;
    @javax.annotation.CheckForNull
    private java.lang.String exact;
    @javax.annotation.CheckForNull
    private java.util.regex.Pattern pattern;
    @java.lang.Override
    public int hashCode() { if (spec == null) { return 0; }
                            return spec.hashCode(); }
    public boolean isUniversal() { if (spec == null) { return true; }
                                   return "~.*".equals(spec); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.filter.NameMatch)) {
                                                    return false;
                                                }
                                                return edu.umd.cs.findbugs.util.Util.
                                                  nullSafeEquals(
                                                    spec,
                                                    ((edu.umd.cs.findbugs.filter.NameMatch)
                                                       o).
                                                      spec);
    }
    public java.lang.String getValue() { if (exact !=
                                               null) {
                                             return exact;
                                         }
                                         if (pattern !=
                                               null) {
                                             return pattern.
                                               toString(
                                                 );
                                         }
                                         return "~.*";
    }
    public NameMatch(java.lang.String matchSpec) {
        super(
          );
        spec =
          matchSpec;
        if (matchSpec !=
              null) {
            if (matchSpec.
                  startsWith(
                    "~")) {
                pattern =
                  java.util.regex.Pattern.
                    compile(
                      matchSpec.
                        substring(
                          1));
            }
            else {
                exact =
                  matchSpec;
            }
        }
    }
    public boolean match(java.lang.String value) {
        if (exact !=
              null) {
            return exact.
              equals(
                value);
        }
        if (pattern !=
              null) {
            return pattern.
              matcher(
                value).
              matches(
                );
        }
        return true;
    }
    @java.lang.Override
    public java.lang.String toString() { if (exact !=
                                               null) {
                                             return "exact(" +
                                             exact +
                                             ")";
                                         }
                                         if (pattern !=
                                               null) {
                                             return "regex(" +
                                             pattern.
                                               toString(
                                                 ) +
                                             ")";
                                         }
                                         return "any()";
    }
    public java.lang.String getSpec() { return spec;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUZC4xUV/XOLPtlYT/8F1h+C4bfDJRfYCmyTNmydPYTFohd" +
       "lOXNmzs7j33z3uO9O7vDVmwhVbCJFAul1BSMCU0r0kJMGzX9BG20kLaa1n5t" +
       "oEZrpFJisZGqVOs59715v/kgWuIk7747995z7j3/c+47eZmUGjpppAoLsZ0a" +
       "NUJrFdYl6AaNR2TBMDbCWK/4UInw8daLHcuDpKyHjEwKRrsoGLRVonLc6CGT" +
       "JcVggiJSo4PSOEJ06dSg+oDAJFXpIWMkoy2lyZIosXY1TnHBZkGPkjqBMV2K" +
       "pRltsxAwMjkKJwnzk4Rb/NPNUVItqtpOZ/l41/KIawZXppy9DEZqo9uFASGc" +
       "ZpIcjkoGa87oZK6myjv7ZJWFaIaFtstLLBasjy7JYcH00zVXrx1I1nIWjBIU" +
       "RWWcPGMDNVR5gMajpMYZXSvTlLGDfI2URMlw12JGmqLZTcOwaRg2zVLrrILT" +
       "j6BKOhVROTksi6lME/FAjEzzItEEXUhZaLr4mQFDBbNo58BA7VSbWpPKHBIf" +
       "nBs+9NDW2h+WkJoeUiMp3XgcEQ7BYJMeYChNxahutMTjNN5D6hQQdjfVJUGW" +
       "hixJ1xtSnyKwNIg/yxYcTGtU53s6vAI5Am16WmSqbpOX4Apl/StNyEIf0DrW" +
       "odWksBXHgcAqCQ6mJwTQOwtkWL+kxBmZ4oewaWy6AxYAaHmKsqRqbzVMEWCA" +
       "1JsqIgtKX7gbVE/pg6WlKiigzkhDQaTIa00Q+4U+2osa6VvXZU7BqkrOCARh" +
       "ZIx/GccEUmrwSckln8sdK/ffpaxTgiQAZ45TUcbzDwegRh/QBpqgOgU7MAGr" +
       "50QPC2Of2xckBBaP8S021/zoq1dWz2s8c9ZcMzHPms7YdiqyXvF4bOSrkyKz" +
       "l5fgMSo01ZBQ+B7KuZV1WTPNGQ08zFgbI06GspNnNvzizntO0EtBUtVGykRV" +
       "TqdAj+pENaVJMtVvpwrVBUbjbaSSKvEIn28j5dCPSgo1RzsTCYOyNjJM5kNl" +
       "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" +
       "hxq31vvzp2uop6N4F3uj/w2VL7fmISAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "txzJ6I688V7wYQcywp56Gf3mNfrenxfvi6GnWRHvWYChSHKuJKYLsu87muQd" +
       "i+qRJztOezKunw0+8oBr8qnh+uoXarsbkwLo964hjo/nxaMxdF5bJQeC+K1j" +
       "lj90zePs9/w4dnB73ng3+NgDibBPvR08do2+P82LTwBfMbTdhVMRW49Z/6Mf" +
       "V9t3gU874E17SrVdUFoM+Nw1GPx8Xnwqhm5w87cNZxT76R+DuyPNBQfcBU+9" +
       "5r50jb4v58VfAc3F/u7W+IzmvvgTNtrcjbMD1rOnnvV/ukbf1/PiayA4AaOd" +
       "HF4SHnP+9z+MVlOwTh89fcnv8e96wpO63TMw5cOPXLrxzkf4vylefxw91bqJ" +
       "gm7UE8c5ebt6on4+CDXdKqi+aXfXGhT//i2G7r76Y5w4fzeXVwpyv7UDeTyG" +
       "7rgCCLCAw+rJ0f8RQxePR8fQnnKq+7tAegfdYC0E5cnO74Em0JlXv18o9GPp" +
       "udPZ0JGsb38yWZ9IoF5wKu0pHjgepijJ7onjg8pHHhnQr3+88YHdUxXFkbIs" +
       "x3IjBV3YvZo5SnPuuyq2Q1zn+/d//5aP3vTCw5Tslh3Bx7Z5grbnXvldSM8N" +
       "4uIlR/aHd/7+K377ka8UV3f/B9GLzUh5KgAA");
}
