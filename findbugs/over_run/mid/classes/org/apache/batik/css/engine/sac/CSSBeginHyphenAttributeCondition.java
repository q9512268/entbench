package org.apache.batik.css.engine.sac;
public class CSSBeginHyphenAttributeCondition extends org.apache.batik.css.engine.sac.CSSAttributeCondition {
    public CSSBeginHyphenAttributeCondition(java.lang.String localName, java.lang.String namespaceURI,
                                            boolean specified,
                                            java.lang.String value) {
        super(
          localName,
          namespaceURI,
          specified,
          value);
    }
    public short getConditionType() { return SAC_BEGIN_HYPHEN_ATTRIBUTE_CONDITION;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        return e.
          getAttribute(
            getLocalName(
              )).
          startsWith(
            getValue(
              ));
    }
    public java.lang.String toString() { return '[' + getLocalName(
                                                        ) +
                                         "|=\"" +
                                         getValue(
                                           ) +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7k/+9M4nvnITtNeGztuepLalHL+gWwBwaKEJ0kLi//Tj23WzPgeKi7mq0DXK" +
       "b9fbXfmvm24cY+1si7hDv7v+g7Lld/7Dv19jhBy0rxN2J/hF+IUP30287ds5" +
       "/w49M+57k2vzHdhO73iRTzj/uvfgmT/bg86K0EXl6l59ItmrDJNEsD8NDzbw" +
       "YD9/rP/4XnO7sXr0MDu84WTcH5n2JG7v4g3UM+qsfn7n8FpyCuDaaWS/vl/M" +
       "fvdzxgfy8nJW/OTW6ln1pwAAhvmeH3DolivZ+Ti1CESMrVw+WEIT8A4ATHx5" +
       "btfzuN7CfFa+bTtjXsdf1vPtA7mAp2/bwczAA/vt937z/V9+30NfB+7oQafj" +
       "zFTAC0ewaLTKXkF+6YXn7nnVs994b47dALjpD7YuPp6NOr6RdllBZQV9oNbd" +
       "mVpcvlkaSGE0zOFWUzPN8iGQI/qgEQBtb4uDP5K20a3fJCthFz/4DEszXVjz" +
       "SSLoVBnVGy6KJ/Npw2i2uw7FIRbe6De5soEMyF6HryCMFKhVfy67+jAqR5Fa" +
       "R+uiWFOo7oTvc5YnGbztt2JrsOyUWozNlKSIX6ZtIejZHanrzPnqYjQSYoH2" +
       "Wwi7nmNJH1s6MiIjaqwjG1dk4Jpjkxo8imnd0ZVyHKv2YFQi2rLUQlqFsD+P" +
       "er0FNmcpckXP0NDhfK0j6yGzIeRFAmNoNZordWRJmSXSbrWXQuJK8LxT5ryk" +
       "NwpnOtOxhXJfFe2ZiRpsp6Uos3iWNAJy0pwWuzLLRXqY+ku5318Vy+1ht9t0" +
       "hoFpemtflKRNe8BV15YhdZChlI4SWeIwZjagOv0lYKe5GWL4M2qeBmNSmg80" +
       "fTxpY3XC0JJSX1j6Hs8jZcmRaaYd0UxvoRSNotibLyRaikKVLaS0zGEpg0UD" +
       "VYQ1bd5TNxiyJqlVjZGdHmYQSVNAlH6zzVfREiKl7Hxe65D8ZDEc6C2Wxxgt" +
       "RdDlWppxcm9ZLtWGRF1UOFqM/WFgVEdEwS/6nMiYXDRIWGtmRC7ZbCfBfNRd" +
       "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");
}
