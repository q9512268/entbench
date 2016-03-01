package org.apache.xml.utils;
public class PrefixResolverDefault implements org.apache.xml.utils.PrefixResolver {
    org.w3c.dom.Node m_context;
    public PrefixResolverDefault(org.w3c.dom.Node xpathExpressionContext) {
        super(
          );
        m_context =
          xpathExpressionContext;
    }
    public java.lang.String getNamespaceForPrefix(java.lang.String prefix) {
        return getNamespaceForPrefix(
                 prefix,
                 m_context);
    }
    public java.lang.String getNamespaceForPrefix(java.lang.String prefix,
                                                  org.w3c.dom.Node namespaceContext) {
        org.w3c.dom.Node parent =
          namespaceContext;
        java.lang.String namespace =
          null;
        if (prefix.
              equals(
                "xml")) {
            namespace =
              org.apache.xml.utils.Constants.
                S_XMLNAMESPACEURI;
        }
        else {
            int type;
            while (null !=
                     parent &&
                     null ==
                     namespace &&
                     ((type =
                         parent.
                           getNodeType(
                             )) ==
                        org.w3c.dom.Node.
                          ELEMENT_NODE ||
                        type ==
                        org.w3c.dom.Node.
                          ENTITY_REFERENCE_NODE)) {
                if (type ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    if (parent.
                          getNodeName(
                            ).
                          indexOf(
                            prefix +
                            ":") ==
                          0)
                        return parent.
                          getNamespaceURI(
                            );
                    org.w3c.dom.NamedNodeMap nnm =
                      parent.
                      getAttributes(
                        );
                    for (int i =
                           0;
                         i <
                           nnm.
                           getLength(
                             );
                         i++) {
                        org.w3c.dom.Node attr =
                          nnm.
                          item(
                            i);
                        java.lang.String aname =
                          attr.
                          getNodeName(
                            );
                        boolean isPrefix =
                          aname.
                          startsWith(
                            "xmlns:");
                        if (isPrefix ||
                              aname.
                              equals(
                                "xmlns")) {
                            int index =
                              aname.
                              indexOf(
                                ':');
                            java.lang.String p =
                              isPrefix
                              ? aname.
                              substring(
                                index +
                                  1)
                              : "";
                            if (p.
                                  equals(
                                    prefix)) {
                                namespace =
                                  attr.
                                    getNodeValue(
                                      );
                                break;
                            }
                        }
                    }
                }
                parent =
                  parent.
                    getParentNode(
                      );
            }
        }
        return namespace;
    }
    public java.lang.String getBaseIdentifier() { return null; }
    public boolean handlesNullPrefixes() { return false; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO9vnDwz+AAzlw4AxRDjkLkBoGhnSGIODydk+" +
                                                              "YUJV0+aY253zLeztLrtz9tkp4UMKINSgNJCUNsAfDWkbBCFqG7VqFeqqH0mU" +
                                                              "pggatUlQk7b5I2kTpPBH47S0Td/M7O3u7X0EpKiWdm89896beW9+7zdv5uxV" +
                                                              "VGWZqM3AmozDdMwgVjjGvmPYtIjcrWLL2gKtcenwX47umfx97b4gCg2haSls" +
                                                              "9UnYIj0KUWVrCM1XNItiTSJWPyEy04iZxCLmCKaKrg2hmYrVmzZURVJony4T" +
                                                              "JrAVm1HUhCk1lUSGkl7bAEULonw2ET6bSJdfoDOK6iXdGHMV5uQpdHv6mGza" +
                                                              "Hc+iqDG6A4/gSIYqaiSqWLQza6JbDV0dG1Z1GiZZGt6hrrYDsSm6uiAMbc81" +
                                                              "fHT90VQjD8N0rGk65S5am4mlqyNEjqIGt3WDStLWLvQQqoiiKR5hitqjuUEj" +
                                                              "MGgEBs3560rB7KcSLZPu1rk7NGcpZEhsQhQtyjdiYBOnbTMxPmewUENt37ky" +
                                                              "eLvQ8Ta33D4XH781cuybDzT+oAI1DKEGRRtk05FgEhQGGYKAknSCmFaXLBN5" +
                                                              "CDVpsOCDxFSwqozbq91sKcMaphmAQC4srDFjEJOP6cYKVhJ8MzMS1U3HvSQH" +
                                                              "lf1fVVLFw+Bri+ur8LCHtYODdQpMzExiwJ6tUrlT0WSOo3wNx8f2+0AAVKvT" +
                                                              "hKZ0Z6hKDUMDahYQUbE2HBkE8GnDIFqlAwRNjrUSRlmsDSztxMMkTtFsv1xM" +
                                                              "dIFULQ8EU6Fopl+MW4JVmuNbJc/6XO1fc+RBbaMWRAGYs0wklc1/Cii1+pQ2" +
                                                              "kyQxCeSBUKzviD6BW144FEQIhGf6hIXMj7927Z7lrRMvCZm5RWQGEjuIROPS" +
                                                              "6cS0S/O6l91VwaZRY+iWwhY/z3OeZTG7pzNrANO0OBZZZzjXObH5N1/ee4a8" +
                                                              "H0R1vSgk6WomDThqkvS0oajEvJdoxMSUyL2olmhyN+/vRdXwHVU0IloHkkmL" +
                                                              "0F5UqfKmkM7/hxAlwQQLUR18K1pSz30bmKb4d9ZACFXDg9bAsxCJP/5L0c5I" +
                                                              "Sk+TCJawpmh6JGbqzH+2oJxziAXfMvQaeiSLATS37YivjN8ZXxmxTCmim8MR" +
                                                              "DKhIkUg2rfKAgKZJkkrWTgJzPUnijAq8A6Az/r/DZZn300cDAViYeX5aUCGj" +
                                                              "NuqqTMy4dCyzbsO1Z+OvCMixNLHjRlEHjBkWY4ZhTL6soF1sTBQI8KFmsLHF" +
                                                              "+sPq7QQeACKuXzb41U3bD7VVAPCM0UoIPRNdWrAxdbuEkWP5uHT20ubJi6/W" +
                                                              "nQmiIHBKAjYmd3doz9sdxOZm6hKRgZ5K7RM5royU3hmKzgNNHB/dt3XP7Xwe" +
                                                              "XsJnBquAq5h6jNG0M0S7P9GL2W04+N5H55/Yrbspn7eD5Da+Ak3GJG3+hfU7" +
                                                              "H5c6FuLn4y/sbg+iSqAnoGSKIYWA7Vr9Y+QxSmeOnZkvNeBwUjfTWGVdOUqt" +
                                                              "oylTH3VbOOKa+PcMWOJalmKt8Nxu5xz/Zb0tBnvPEghlmPF5wdl/7aBx8vXf" +
                                                              "/W0VD3duo2jw7PCDhHZ6yIkZa+Y01ORCcItJCMj96Xjs6ONXD27j+AOJxcUG" +
                                                              "bGfvbiAlWEII88Mv7Xrj7bdOvxZ0MUthd84koNDJOk4GmU81ZZxkOHfnA+Sm" +
                                                              "QsYz1LTfrwEqlaSCEyphSfLvhiUrnv/gSKPAgQotORgt/3QDbvvn1qG9rzww" +
                                                              "2crNBCS2uboxc8UEY093LXeZJh5j88juuzz/Wy/ik8D9wLeWMk44hQbsvGWT" +
                                                              "mg21FqOG0VVSWNbT4X5IL76ad/DuCH+vYpHgSoj3fYG92i1vVuQnnqc6ikuP" +
                                                              "vvbh1K0fXrjG3cgvr7wg6MNGp8Adey3JgvlZfgbaiK0UyN0x0f+VRnXiOlgc" +
                                                              "AosS1BTWgAkUmM2DjC1dVf3mL37Zsv1SBQr2oDpVx3IP5tmHagH2xEoBe2aN" +
                                                              "L94jVn2UQaCRu4oKnGeBXlB8CTekDcqDPv6TWT9a871Tb3G0CXjNdYhyYQFR" +
                                                              "8tLczfEPrjz5zs8nn6oWG/uy0sTm05v9rwE1sf+vHxcEmVNakaLDpz8UOXti" +
                                                              "Tvfd73N9l1uY9uJs4bYD7OvqrjyT/kewLfTrIKoeQo2SXQZvxWqGZewQlH5W" +
                                                              "rjaGUjmvP7+MEzVLp8Od8/y85hnWz2rudgffTJp9T/URGc/xJnhusXP8Fj+R" +
                                                              "BRD/6OUqS/l7GXsttxGQbypYxhRFtem4JMpx1rBacCR738Vem4StNcWAJ7qW" +
                                                              "sleHMyL/C/krHy9BebFmJ/fiG9j3WarNL1XI8iL89P5jp+SBp1cIVDbnF4cb" +
                                                              "4Oxz7g//+W34+J9fLlJ51FLduE0lI0T1zK8ShlxUkAt9vM53gXXn5cmKK4/N" +
                                                              "ri+sF5il1hLVQEfppPEP8OL+v8/Zcndq+00UAgt8gfKbfKbv7Mv3LpUeC/Kj" +
                                                              "isBxwREnX6kzH711JoEzmbYlD8NtDgw4RJbAs9aGwdrim3ERBDlbXClVH+f7" +
                                                              "NwrOfCxTw+LAxUeSy2wUvG6HY9bMYUL7wUMLgEh6dFPgj3USNyG2l0mIQiZm" +
                                                              "DV28eVthaKK2f9GbD00pVZ+XQT6PIHeBZzc3bZaJBSeB9A3GQvtsYrEIngO2" +
                                                              "QwduPhalVMt4+VCZvr3sNUZRE0RgHUtmmWgUqh6xzXi8H/9svF8MzyO2C4/c" +
                                                              "sPcBJlldRrWMh4fL9H2dvR6maHoKqE4lVn9GVcXaQ/XCSikPG7LLt8FMwqIx" +
                                                              "U0lDTTxiXw2cb5nc9avq8fW5Y38xFSF5n9V38acb341zZqth1OnwiYc2u8xh" +
                                                              "T8HfKGLwCfwF4Pkve9j0WQP7hc262z7pL3SO+obBto8yhYrPhcju5rd3nnjv" +
                                                              "nHDBX5X4hMmhY4c/CR85JrYVcV+0uODKxqsj7oyEO+z1jSzfacqMwjV63j2/" +
                                                              "+2ff330waC/WlyiqTui6SrBWwIbsdsQXeDHb0IqT/9xz4PUBOJ/1opqMpuzK" +
                                                              "AMbzyb3ayiQ8K+FeMrlUb8+bRR3O4h2GXUTyzDhw85mRBcopes5nxezsgltG" +
                                                              "cTMmPXuqoWbWqfv/yM+azu1VPWApCbj11lqe75DhcFm9qLwM/vMURTOK1SEU" +
                                                              "VfFfPvPvCNnvUjQtX5YCPNOqV+YZiupcGTjLiQ+vyFnQAhH2ec4osoGJUjMb" +
                                                              "8NQkyBPnmZ8WZ0fFewRl2Oe3uzloZMT9LiTuqU39D177/NPiCCypeHycWZkC" +
                                                              "gBCncae+WFTSWs5WaOOy69Oeq12Sw2qTmLBLaHM9rNMFiDXYSs/xnQ+tdueY" +
                                                              "+MbpNRdePRS6DFm2DQUwUNS2wqI8a2Sg+NkWLQZ9qL740bWz7p3tFz9+M9DM" +
                                                              "zz52srSW04hLRy9ciSUN49tBVNuLqiAVSZafGNaPaZuJNGLmZVIooWc05yJ4" +
                                                              "GoMlZoUIj4wd0KlOK7tCoaitkC8Kr5XgWDhKzHXMup2ZeRVZxjC8vTyyT4o0" +
                                                              "FcRYEY/2GUaOKH/II28YPAEn2OvE/wDhl5B1whkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
