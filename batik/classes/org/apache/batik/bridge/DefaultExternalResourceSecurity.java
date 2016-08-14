package org.apache.batik.bridge;
public class DefaultExternalResourceSecurity implements org.apache.batik.bridge.ExternalResourceSecurity {
    public static final java.lang.String DATA_PROTOCOL = "data";
    public static final java.lang.String ERROR_CANNOT_ACCESS_DOCUMENT_URL =
      ("DefaultExternalResourceSecurity.error.cannot.access.document" +
       ".url");
    public static final java.lang.String ERROR_EXTERNAL_RESOURCE_FROM_DIFFERENT_URL =
      ("DefaultExternalResourceSecurity.error.external.resource.from" +
       ".different.url");
    protected java.lang.SecurityException se;
    public void checkLoadExternalResource() { if (se != null) { se.
                                                                  fillInStackTrace(
                                                                    );
                                                                throw se;
                                              } }
    public DefaultExternalResourceSecurity(org.apache.batik.util.ParsedURL externalResourceURL,
                                           org.apache.batik.util.ParsedURL docURL) {
        super(
          );
        if (docURL ==
              null) {
            se =
              new java.lang.SecurityException(
                org.apache.batik.bridge.Messages.
                  formatMessage(
                    ERROR_CANNOT_ACCESS_DOCUMENT_URL,
                    new java.lang.Object[] { externalResourceURL }));
        }
        else {
            java.lang.String docHost =
              docURL.
              getHost(
                );
            java.lang.String externalResourceHost =
              externalResourceURL.
              getHost(
                );
            if (docHost !=
                  externalResourceHost &&
                  (docHost ==
                     null ||
                     !docHost.
                     equals(
                       externalResourceHost))) {
                if (externalResourceURL ==
                      null ||
                      !DATA_PROTOCOL.
                      equals(
                        externalResourceURL.
                          getProtocol(
                            ))) {
                    se =
                      new java.lang.SecurityException(
                        org.apache.batik.bridge.Messages.
                          formatMessage(
                            ERROR_EXTERNAL_RESOURCE_FROM_DIFFERENT_URL,
                            new java.lang.Object[] { externalResourceURL }));
                }
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SPmiDrYby0rvczijU74zE99r/u72C+eucZfUBY9FfH4lyxIFEMzrfgcFLr5z" +
       "988vfPXMmKgc1pSHPs+8ln9GleTR3/2jyOQc9EpUNZ75g8FLTy0M7fiAz3fQ" +
       "h81uyxZnNkBwZ+6nLmb+5m+t+pEfVQ+iRsmus/dixWIxPQi1pZkrvqEWLxgv" +
       "rBNFUdSRR9fFXuRzLevFPSejwjejZt/1HqhrYVu4BZ7lNgos90KdD8CjMoUp" +
       "Zj/v5xPv5G07a9bzTaxgnwEAGZPX9BQEkSE7e8CmeYplKKrv6hzoTMTi0YFo" +
       "KBrJBWsjdyxmi4ComQXysnYbayJijXvKum64UNVeeFbbMqwqpeq905U4xDA0" +
       "IyBxhwqIuAukNMnKMCe2DF40PzCVmVgTY81nSthnVRnZoJwIx+PReCLU2dcX" +
       "HUh0hkLh/v5EVzS0pzfcN5CwcWvAY54Hb9M8n4VnvS3CulLm2f3JzEPs4YBh" +
       "jwfShpYJAObzRJ03FP6fDbWujJQUtQtDhR8YCMf7OiOJeLg/uiceCie649He" +
       "RFdPd3c4PoXJkp/cZLNZ70p4NtnCbCoyGeIfB0urCfas1Q2NQoiTlEfH+inY" +
       "UkhmJBchi1wRYm9COCsRPVdZuFQbmUI1MXQna9bmJeF/VchzdnHXCA6Q+3IC" +
       "bShXu5fzGZbmlpQ7l/Iz9eTR0+dS0fMbRQ5oKjzrhVUr88wv/v2TwNnfvlHi" +
       "KFFLNX29QkaJUiAsLFmQdXr5kd2B8Pdmn/r9i21DO2+n5md9S6ep6tnvZaBE" +
       "e/lE5hXltaN/WjiwY/jAbZTvyzzm9LL8du+lN+5bLZ3y8/sJkVuK7jUKJ3UU" +
       "ZpQ6g1DLUAcK8srKwhJ6LTzbbM/Z5g0Nxzc9TpcvTMtNnaIqOz7F2GOseZSi" +
       "O8AxpZEI1EBehzSnrC9ihpyBen3UvvUIHml6f+Sp688In/QWEx5icvz0Yx8H" +
       "TpwW/inukVYWXeW454i7JC54ozDNx/Dng+c/7GFasQ72hpIhZF9oLM/faLAq" +
       "y0ArphKLL9H9h8tHfvCtI8f8tpUOQ7Yf1eSUgxpfmg4Qp64OWUdIz4J/TZM6" +
       "WB3ZUnSJKC6+pGfPNdQ0n9vzSx6O+cupWRBYaUtR3JWO67tKN0ha5mrNEnWP" +
       "zl/foKi5DEhBDSM+uCJPCvpzUId46aHG4W833TcpqnPogJX4cJNMUlQBJOzz" +
       "vF6iyBEFX9bnwirbqHwv5k+3F/kp7qMic2V+iZtDA0tc4yaky+d29x2+ueW8" +
       "OKpKCp6YYFxmRlC1ODXnEWVFWW45XlW71tya/VztqpwnzRECO3G+yBWMIcBg" +
       "ne34Qs85zmzLH+fendz+yk+PV70NQbMP+TBFc/cVl8ZZ3QIo3xdxwNz1TwB+" +
       "wOxY8+T4jnXpv/yGHz5s8F9cnj4hXb3w0DunWibhIDqzB82AICFZXrN3jatx" +
       "Io0ag6heNsNZEBG4yFjpQTWWKh+ySE8qgmYz58SsVOV2sc1Zn+9lFx0UtRYH" +
       "f/H1EBzUxoixU7PUFMdYQH+np+B2OQfKlq57Jjg9+a2cV6x7Qur6SsNLJ5sq" +
       "uiHACtRxs682rWQe8N0Xzk4GaGTNyayApYpEpFfXczBVsUwXHv+CoGH9FPna" +
       "7V4GGj6RnNnP73N2L/JP1rz0X9KFG0VLGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7I/u+YM3//YzXy8OVP8XHEPx/3QlAAA=");
}
