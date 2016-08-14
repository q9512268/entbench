package org.apache.batik.css.engine.sac;
public class CSSLangCondition implements org.w3c.css.sac.LangCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected java.lang.String lang;
    protected java.lang.String langHyphen;
    public CSSLangCondition(java.lang.String lang) { super();
                                                     this.lang = lang.toLowerCase(
                                                                        );
                                                     this.langHyphen =
                                                       lang +
                                                       '-'; }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.CSSLangCondition c =
                                                    (org.apache.batik.css.engine.sac.CSSLangCondition)
                                                      obj;
                                                  return c.
                                                           lang.
                                                    equals(
                                                      lang);
    }
    public short getConditionType() { return SAC_LANG_CONDITION;
    }
    public java.lang.String getLang() { return lang;
    }
    public int getSpecificity() { return 1 << 8; }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        java.lang.String s =
          e.
          getAttribute(
            "lang").
          toLowerCase(
            );
        if (s.
              equals(
                lang) ||
              s.
              startsWith(
                langHyphen)) {
            return true;
        }
        s =
          e.
            getAttributeNS(
              org.apache.batik.util.XMLConstants.
                XML_NAMESPACE_URI,
              org.apache.batik.util.XMLConstants.
                XML_LANG_ATTRIBUTE).
            toLowerCase(
              );
        return s.
          equals(
            lang) ||
          s.
          startsWith(
            langHyphen);
    }
    public void fillAttributeSet(java.util.Set attrSet) {
        attrSet.
          add(
            "lang");
    }
    public java.lang.String toString() { return ":lang(" +
                                         lang +
                                         ')'; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u42PfxsnZe+9wOfFIf/e/OVfG39Q/tHLtftON5JvO3q/lei5W7ePr4VqDOKD" +
       "vWUT+clTyz1WGuo7wPPRY8t99OLW65lv3Hnf9TsPvnXhBOTuxyaHffGK6Ifu" +
       "cWzyw2Xxibh2Rd0lohNVfaRzzqnFtauS7zuq6J057idfb6vt/CxVxQ+caqLy" +
       "42fAQxxrgnhzNHFeqJ+4R9tPlsWPAlXpanzqy6enjBdEfyAy/DA+E/zH3oDg" +
       "j564AHUsOPXmC/537tH2M2Xxt4A5geDkyWHCmWh/+w2Idr2sfBI862PR1m++" +
       "aD9/j7ZfKIsvxbWHgWhMoMqmZspmnN/JoveZ3jl7fvkNCF2F9OPg+dix0B97" +
       "c4S+fCt8P3YC34rvHpU3s1SvOrmtV8S/dA+t/HJZ/BPgxK4Yy9Ulkb9xJvlX" +
       "34Dk1dH7d4HHPpbcfnMkPwGz86cHt64GtLivlpjn5X+0evXrXyi+8vLhcEAS" +
       "IzWuQXe7j3b7lbjydsMH7nFD4+ym0h+M/+Irv/tf+O87WcTecqqGEsSqFfiu" +
       "ajix4dvOzn8ZtbLev6nG+lf3sN5vlsW/ADilmY7Tj+PQlJK4PBu9k1ffn/qm" +
       "cmbcr71RmCqPO8NjqcI3P5b/2z3afrssXo1rD8b+4eT/Ak79p29Htgzo7+Jd" +
       "nvJiwuO33R883HmTv/zS9Qff9RL376rrLKf30h4iaw9qieOcPy4+934lCFXN" +
       "rLh/6HB4HFR//idIIl4nrQKABMqK728eiF6La+++B1G5Ulcv52n+V1x7+51o" +
       "wOigPN/zj4BCLvYECFH9Pd/vj+PatbN+YNLDy/kufwJGB13K1z+tPONT2aVz" +
       "Sd2xY1U2e/T1bHZKcv7yTBmV1XXQk6QtoY6D/ysvTRff/1rnpw+Xd2RHLIpy" +
       "lAfJ2tXDPaLTxO+Zu452MtaVyYe+9fDPPfSBk/h++MDwmZOf4+29d74pM3KD" +
       "uLrbUvzDd/3CR/7uS79VHfz+X6loeBinKwAA");
}
