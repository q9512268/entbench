package org.apache.batik.util;
public class ParsedURLJarProtocolHandler extends org.apache.batik.util.ParsedURLDefaultProtocolHandler {
    public static final java.lang.String JAR = "jar";
    public ParsedURLJarProtocolHandler() { super(JAR); }
    public org.apache.batik.util.ParsedURLData parseURL(org.apache.batik.util.ParsedURL baseURL,
                                                        java.lang.String urlStr) {
        java.lang.String start =
          urlStr.
          substring(
            0,
            JAR.
              length(
                ) +
              1).
          toLowerCase(
            );
        if (start.
              equals(
                JAR +
                ":"))
            return parseURL(
                     urlStr);
        try {
            java.net.URL context =
              new java.net.URL(
              baseURL.
                toString(
                  ));
            java.net.URL url =
              new java.net.URL(
              context,
              urlStr);
            return constructParsedURLData(
                     url);
        }
        catch (java.net.MalformedURLException mue) {
            return super.
              parseURL(
                baseURL,
                urlStr);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "08hiINAjoqOznrWhLZNrdYfzsGPo+MJOhzLnD3oLcahqg9Co4645lMyhmKY0" +
       "WzbNZCGN1hyj1GIc471lEQSutay3LBNVJGM+Kg4C01dsbDxrLItzum/00sha" +
       "ps68x4ZkaxjiOm6M50sMKdl0Gmud/kjkI6SJD1SlQK9bbbqH9DqSL6J2LKaJ" +
       "QYy6K787742ZAi6pWLHaqg1E1DIN3iZJZ5FKgT0KN/0OMxRQrsnirFNiW6LK" +
       "iGtJGkSsyCWW07YFvyG6tFRtKgtDnvVTgk07rYmxQRfmsL9paArqpXXNmy+H" +
       "FG+2+pvupGTUSTrmxqJaJDoGaQZW01wU1NpE2RTWfnlVwiTWGa8deakP/G6E" +
       "dkKKVpucUq5MyXraNJKlLeJ41U04id70qLgsmVQV51EnUlFemCphqo0lEkGS" +
       "cLxarFN0aclUbyARDMnN+bCGLUS8Y5Y9tkPNlw7VFnF2xPexGVft9ZbobJGO" +
       "TGFRs0f1YN6R+Fgdkr35pECWhqP2XGJ4ZTLAC+PidKWJAt1vuCWVH9iTtUf6" +
       "Fd3HqpVyoTeKiXBhsnOaaEs2NVlHvem6MButu53KUKNAsDbIoNro1aaOZRgO" +
       "jqeVQVLoEONxu+90XHNASmXKGjNsHweA0N5gquEv0A2+GsFNrlAYSisqnLSM" +
       "zjqZTOFOxxgMyv2ejVLyIJh7ZHtZhUe0SWscNSbaU2dJeWR5rTGB2m/IxWhU" +
       "qzXZgdcpdKtKuY0zsoUpJICzLok11/0Eq6QzrinJ7aS2oKtye8NHQZCOBAxb" +
       "BNMiVRlMnMQfs36iNpvBQBzog7Q09VryeEx0paLVbY3Vnoprk9JQnfPCEmyy" +
       "5FHPjpkiP2wBx1+WRp6C++JSohJP8csmbVb6Wopb3Xmk9bvphLNK8orGkkKd" +
       "xeuGaXmbQTVM116LDaSG4+C1lrKqw/J8YDqw1UmaDbhP2/NkRJKbjZ+EtSE/" +
       "jCWMLhVcGA2otMM0Y3TSqTUaCAOLE4OrCALZIYpty0YaHAYnHQWdu6E9xNaE" +
       "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");
}
