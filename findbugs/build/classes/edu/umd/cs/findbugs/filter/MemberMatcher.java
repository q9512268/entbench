package edu.umd.cs.findbugs.filter;
public class MemberMatcher {
    protected final edu.umd.cs.findbugs.filter.NameMatch name;
    @javax.annotation.CheckForNull
    protected final java.lang.String role;
    @javax.annotation.CheckForNull
    protected final edu.umd.cs.findbugs.filter.NameMatch signature;
    public MemberMatcher(java.lang.String name) { this(name, null, null);
    }
    public MemberMatcher(java.lang.String name, java.lang.String signature) {
        this(
          name,
          signature,
          null);
    }
    public MemberMatcher(java.lang.String name, java.lang.String signature,
                         java.lang.String role) { super();
                                                  if (name == null) { if (signature ==
                                                                            null) {
                                                                          throw new edu.umd.cs.findbugs.filter.FilterException(
                                                                            this.
                                                                              getClass(
                                                                                ).
                                                                              getName(
                                                                                ) +
                                                                            " must have eiter name or signature attributes");
                                                                      }
                                                                      else {
                                                                          name =
                                                                            "~.*";
                                                                      }
                                                  }
                                                  this.
                                                    name =
                                                    new edu.umd.cs.findbugs.filter.NameMatch(
                                                      name);
                                                  this.
                                                    signature =
                                                    new edu.umd.cs.findbugs.filter.NameMatch(
                                                      signature);
                                                  this.
                                                    role =
                                                    role;
    }
    @java.lang.Override
    public java.lang.String toString() { java.lang.StringBuilder buf =
                                           new java.lang.StringBuilder(
                                           );
                                         if (!name.
                                               isUniversal(
                                                 )) {
                                             buf.
                                               append(
                                                 "name=\"");
                                             buf.
                                               append(
                                                 name.
                                                   getSpec(
                                                     ));
                                             buf.
                                               append(
                                                 "\"");
                                         }
                                         if (signature !=
                                               null) {
                                             if (buf.
                                                   length(
                                                     ) >
                                                   0) {
                                                 buf.
                                                   append(
                                                     " ");
                                             }
                                             buf.
                                               append(
                                                 "signature=\"");
                                             buf.
                                               append(
                                                 signature);
                                             buf.
                                               append(
                                                 "\"");
                                         }
                                         return buf.
                                           toString(
                                             );
    }
    @java.lang.Override
    public int hashCode() { return name.hashCode(
                                          ) +
                              edu.umd.cs.findbugs.util.Util.
                              nullSafeHashcode(
                                signature);
    }
    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (o ==
              null ||
              this.
              getClass(
                ) !=
              o.
              getClass(
                )) {
            return false;
        }
        edu.umd.cs.findbugs.filter.MemberMatcher other =
          (edu.umd.cs.findbugs.filter.MemberMatcher)
            o;
        return name.
          equals(
            other.
              name) &&
          edu.umd.cs.findbugs.util.Util.
          nullSafeEquals(
            signature,
            other.
              signature);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jUXs+fygQdvr7JU2H/0X3IriUiUeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVaC6zsRnn2PTf35t5LkpsHJOGWvG8gydJj73qfCtDYXnu9" +
       "XnufXnvXPG68ttfrt9ePXe/SUECiUJAAtYFSCaJWAtHSQFAFbaWKNlVLAYEq" +
       "QREtVUtQhVRaikRUlValLR17zzl7zrmPNEBX8ux4Zv6Z//vnn///Z8ZPfx86" +
       "FQZQzvfslW570a6WRLumXdqNVr4W7jJsqSsHoaYSthyGPCi7pNz/6fM//NH7" +
       "ZzfvQKcl6DbZdb1IjgzPDfta6NkLTWWh89tS0tacMIJuZk15IcNxZNgwa4TR" +
       "oyz0kkOkEXSR3WcBBizAgAU4YwHGtq0A0Y2aGztESiG7UTiH3gKdYKHTvpKy" +
       "F0H3He3ElwPZ2eummyEAPZxJ3wUAKiNOAujeA+wbzJcB/kAOfvLX33Tz752E" +
       "zkvQecMdpOwogIkIDCJBNziaM9GCEFNVTZWgW1xNUwdaYMi2sc74lqBbQ0N3" +
       "5SgOtAMhpYWxrwXZmFvJ3aCk2IJYibzgAN7U0Gx1/+3U1JZ1gPX2LdYNQiot" +
       "BwDPGYCxYCor2j7JdZbhqhF0z3GKA4wXW6ABIL3e0aKZdzDUda4MCqBbN3Nn" +
       "y64OD6LAcHXQ9JQXg1Ei6MJVO01l7cuKJevapQi683i77qYKtDqbCSIliaCX" +
       "HW+W9QRm6cKxWTo0P99vv+a9b3ZpdyfjWdUUO+X/DCC6+xhRX5tqgeYq2obw" +
       "hkfYD8q3f+5dOxAEGr/sWONNmz/4xecfe/Xdz35x0+bnrtCmMzE1JbqkfHRy" +
       "01dfQTxcO5myccb3QiOd/CPIM/Xv7tU8mvhg5d1+0GNaubtf+Wz/L8Zv/YT2" +
       "vR3oXBM6rXh27AA9ukXxHN+wtaChuVogR5rahM5qrkpk9U3oepBnDVfblHam" +
       "01CLmtB1dlZ02svegYimoItURNeDvOFOvf28L0ezLJ/4EARdDx7oBvDcBW1+" +
       "2X8EXYJnnqPBsiK7huvB3cBL8Yew5kYTINsZPAXKNIn1EA4DBc5UR1NjOHZU" +
       "WAm3lYAJoEAwly0eTo6UmRbspq39//8hkhTlzcsTJ8AEvOL48rfByqE9W9WC" +
       "S8qTMU4+/6lLX945WA578omgh8CIu2DEXSXc3R9xdzPi7pERoRMnsoFemo68" +
       "mWUwRxZY7cAO3vDw4I3M4++6/yRQL395HRDwSdAUvro5Jrb2oZlZQQUoKfTs" +
       "h5ZvE34J2YF2jtrVlFtQdC4l76bW8MDqXTy+nq7U7/l3fveHz3zwCW+7so4Y" +
       "6r0FfzllumDvPy7XwFOAyAJt2/0j98qfvfS5Jy7uQNcBKwAsXyQDTQVG5e7j" +
       "YxxZuI/uG8EUyykAeOoFjmynVfuW61w0C7zltiSb8Juy/C1Axi9JNflO8Lxq" +
       "T7Wz/7T2Nj9NX7pRkHTSjqHIjOxrB/5H/uYv/wnNxL1vj88f8nADLXr0kA1I" +
       "OzufrfZbtjrAB5oG2v39h7q/9oHvv/P1mQKAFg9cacCLaUqAtQ+mEIj5HV+c" +
       "f/O5b3306zsHSnMiAk4wntiGkhyATMuhc9cACUZ75ZYfYENssMhSrbk4dB1P" +
       "NaaGPLG1VEv/6/yD+c/+y3tv3uiBDUr21ejVL9zBtvzlOPTWL7/p3+/Oujmh" +
       "pD5sK7Nts41hvG3bMxYE8irlI3nb1+76jS/IHwEmFpi10FhrmaU6sZFBhvxl" +
       "INbIKFN3tbtxV9lswln1I1m6m0oiI4KyOjRN7gkPr4qjC+9QEHJJef/Xf3Cj" +
       "8IM/fj6DcTSKOawEnOw/utG7NLk3Ad3fcdwE0HI4A+2Kz7bfcLP97I9AjxLo" +
       "UQGuO+wEwAIlR1Rmr/Wp6//2T//s9se/ehLaoaBztierlJytPugsUHstnAHj" +
       "lfi/8Nhm1pdnQHJzBhW6DHxWcOHydZHbU5nclddFmt6XJg9erm1XIz0m/p2M" +
       "g530FcmSrOvHrjFJeJo8mlUV0+Q1G+4rPxVQeI9b+MUDvRrpMQgnN1Z9C3SL" +
       "tnUNtFyaUFu0jReDdtP2zuztNNC7h6/uT6g0ttya5Dv/s2NP3v4P/3GZbmee" +
       "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" +
       "jvP/FzSSHj9rKAAA");
}
