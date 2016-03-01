package org.apache.xalan.trace;
public class EndSelectionEvent extends org.apache.xalan.trace.SelectionEvent {
    public EndSelectionEvent(org.apache.xalan.transformer.TransformerImpl processor,
                             org.w3c.dom.Node sourceNode,
                             org.apache.xalan.templates.ElemTemplateElement styleNode,
                             java.lang.String attributeName,
                             org.apache.xpath.XPath xpath,
                             org.apache.xpath.objects.XObject selection) {
        super(
          processor,
          sourceNode,
          styleNode,
          attributeName,
          xpath,
          selection);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pICOeA/n/wUbpIEefhEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "32xTrdXM0uSNGEz5qUYvzOGiYpJhWaMIO60hbLsqt6kuShpJFE05aotpol3q" +
       "8RuJrTtIxlca2pInwlKFjrJ0PVv2iDpPWemKbWR1LN2WGqV6AuOE6nSsuKvW" +
       "tmiWddOeR9l8Z2U1F9qmHfVB/o2bDTwhdZVhlu46SIYb2BubPOc0+1jmNIdY" +
       "U3cYSwyrjRIOS+pyUHH70iLSyDCya51eIC/m3IigmWnJJCi+KrdqTRB2f02l" +
       "nbHF2guOByk5WhEMHGH4co2I9QYjdIzNcMRTwwyFnXq/rG7cjt91Mdcsp55u" +
       "WY12GnZXqFHXZnOnNKJbjfJSDKhqzZDV5RqPsUaf3AyCZoOoVbWAqxAOO7Z0" +
       "IhOlURRKMjXWlKlmZxsFRyhO6FWEVQsj2fKyXhc4c4Z3OIsnnamYcINVC142" +
       "t+hoIHNcRUepRdx1h1xaUbeYvrDV3mbFmXSnEjcbSbe9phh7wGKkaaTV5ZrX" +
       "52psCeOKu+WWVcxrJPZ0pUlJebI2CYWhZuKM5RbV1hLhG3hVoui0U2tIdlb1" +
       "8RZpdjmkV+L10dDN4kAb4KSEbBRfr/WENi6iWG20YRaoBdZisy7JC2O8blnL" +
       "Mpktuky9Jc9VrJTBpa3aJoK0bNGzAWtb9LjNBrrOTNsdk143vYWWmjCsNUOd" +
       "WGVuU7ACYd5VvJJAN9bdyjKZt6dxZ2TiYr1CtbB5VpoEwnhbFXktgdOsh+Mo" +
       "MhgPYZscg2RQJpuytCSJxlqqErKLLtdYVUd4var6cCBWVkJS7aUCKcCNUgzD" +
       "LIHXJ3VYRJhE8ZYdHB+shiEl8E1vi/bITbnVEhegykGmWUDWMLSBpryqaFjX" +
       "5cLOfKNueks+rm1rW1KviIwvz03ebjKsT9Gdbb22cJQhPoraLbluRIxSTqfZ" +
       "RvZ7gdSn1864nJUNthMYTVQHoG4S7Vm3pgFgsIdKNUIT2Qw6Uzqcd4NGnJXG" +
       "QZTqTNiy11SWRaJkrRV1QnQ42A0aNjNbIpUGtcZWjVkdDuteFyP8xdxh150R" +
       "Cge2iazczE3itL0M3E6CNhJ1NAd+JIZ1q4esegun4qid+mo86QJk2Ygrp8PM" +
       "tjKrN3B41BqhJYXFy2NrKUjESNOcCj4Q9cpI0NpDdWb4FdiujFMWn8ziyqC8" +
       "hmvSVFSxOkyxU26UGOrUrCZTpAurpQWmc6SLlR0Ws1y2tXJbwnq8sdVRKepn" +
       "DOWWp1YID+I6xjE+2AmRIKgyOgrzQbnL0oth0BptN5M+Nm+rKcd3rHF/0Uba" +
       "IqKtJ7znVPVqE49id9JnCN+FmYqgoesOipabMRwlMMtQ5VKJ3lA8suxsaFJO" +
       "sm1dl9mml3gzH1trymxkZgNYsyuMhTGJzrq99lITepLUZviZWGKlXpUTUqwH" +
       "tzi3uUC3I4puShubZaujVGUsxB+2aaUJu/BmJvrDrqLqXVDQPluc7bX/22nj" +
       "vuIQdXT9/xMcn3ZDj+fNU0fXS8Xnwtkr45PXS8encSg/OTxyu1v94tTw6Q/e" +
       "eEmmP4PsHdxiiDF0Kfb8d9rKWrFPiQIW3XTHml8YPXjTu53d+wjpCy9duest" +
       "L83+prhmPHpncImE7lIT2z558j3Rv+CHimoUqlzanYP94mdz5gbn+OYXHF6L" +
       "30LZ9Y46O7hYOkkN6Irfk3TPxdDlYzpwHt51TpI8H0N3AJK8+wH/8Lboqdtc" +
       "Qp/2TnrudCyOgn7/jztanQjfk6eOpcXrtgNHU8nuhdt16YsvEeP3v1r7zO5i" +
       "VLKFLCtez5DQxd0d7dH18+O3lXYo68Lg6dfu/dKlpw4T4t6dwsdpe0K3t976" +
       "FrLr+HFxb5h95S2//67feenbxcH9fwHenMJbBx0AAA==");
}
