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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "qJUj7n8BUwwDyAkhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mysAAA==");
}
