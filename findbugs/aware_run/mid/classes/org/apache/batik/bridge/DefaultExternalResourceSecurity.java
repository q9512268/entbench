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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZhQUBboN47/+0aZfuBkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3yWmf3jX77/rt5/9Tn4Q+r+sDaGKSCUAAA==");
}
