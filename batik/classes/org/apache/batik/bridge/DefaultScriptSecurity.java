package org.apache.batik.bridge;
public class DefaultScriptSecurity implements org.apache.batik.bridge.ScriptSecurity {
    public static final java.lang.String DATA_PROTOCOL = "data";
    public static final java.lang.String ERROR_CANNOT_ACCESS_DOCUMENT_URL =
      "DefaultScriptSecurity.error.cannot.access.document.url";
    public static final java.lang.String ERROR_SCRIPT_FROM_DIFFERENT_URL =
      "DefaultScriptSecurity.error.script.from.different.url";
    protected java.lang.SecurityException se;
    public void checkLoadScript() { if (se != null) { throw se; } }
    public DefaultScriptSecurity(java.lang.String scriptType, org.apache.batik.util.ParsedURL scriptURL,
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
                    new java.lang.Object[] { scriptURL }));
        }
        else {
            java.lang.String docHost =
              docURL.
              getHost(
                );
            java.lang.String scriptHost =
              scriptURL.
              getHost(
                );
            if (docHost !=
                  scriptHost &&
                  (docHost ==
                     null ||
                     !docHost.
                     equals(
                       scriptHost))) {
                if (!docURL.
                      equals(
                        scriptURL) &&
                      (scriptURL ==
                         null ||
                         !DATA_PROTOCOL.
                         equals(
                           scriptURL.
                             getProtocol(
                               )))) {
                    se =
                      new java.lang.SecurityException(
                        org.apache.batik.bridge.Messages.
                          formatMessage(
                            ERROR_SCRIPT_FROM_DIFFERENT_URL,
                            new java.lang.Object[] { scriptURL }));
                }
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcRxWfu/N3/J0Pm3zYieOkytddQ5pA69DWOZ8Th/OH" +
                                                              "zk5EHZrL3N6cvfHe7mZ31j47BNoUlNA/ohDSNJTWEpKjQJQ2FaIqhbYKqqCt" +
                                                              "Ckhtw0dBTRH8QaBENEIURIDyZmbvdm/vziH8gaWdG8+8efPem/d+781cvI7K" +
                                                              "TQO1EZUG6bROzGBEpUPYMEkyrGDTHIGxuPR4AP9l/7WBu/2oYhTVj2OzX8Im" +
                                                              "6ZWJkjRH0QpZNSlWJWIOEJJkK4YMYhJjElNZU0fRYtnsS+uKLMm0X0sSRrAX" +
                                                              "G1HUhCk15IRFSZ/NgKIVUZAkxCUJdXunu6KoVtL0aYe81UUeds0wyrSzl0lR" +
                                                              "Y/QgnsQhi8pKKCqbtCtjoA26pkyPKRoNkgwNHlS22ibYHd1aYIKOZxs+vHly" +
                                                              "vJGbYCFWVY1y9cwYMTVlkiSjqMEZjSgkbR5Cn0eBKFrgIqaoM5rdNASbhmDT" +
                                                              "rLYOFUhfR1QrHda4OjTLqUKXmEAUrcpnomMDp202Q1xm4FBFbd35YtB2ZU5b" +
                                                              "oWWBio9tCJ1+fH/jtwOoYRQ1yOowE0cCIShsMgoGJekEMczuZJIkR1GTCoc9" +
                                                              "TAwZK/KMfdLNpjymYmrB8WfNwgYtnRh8T8dWcI6gm2FJVDNy6qW4Q9n/lacU" +
                                                              "PAa6LnF0FRr2snFQsEYGwYwUBr+zl5RNyGqSonbvipyOnZ8GAlhamSZ0XMtt" +
                                                              "VaZiGEDNwkUUrI6FhsH11DEgLdfAAQ2KlpZkymytY2kCj5E480gP3ZCYAqpq" +
                                                              "bgi2hKLFXjLOCU5pqeeUXOdzfWD7icPqLtWPfCBzkkgKk38BLGrzLIqRFDEI" +
                                                              "xIFYWLs+egYveem4HyEgXuwhFjTPf+7G/RvbLr8maJYVoRlMHCQSjUtzifo3" +
                                                              "l4fX3R1gYlTpmimzw8/TnEfZkD3TldEBYZbkOLLJYHbycuxHDzx0gbzvRzV9" +
                                                              "qELSFCsNftQkaWldVoixk6jEwJQk+1A1UZNhPt+HKqEflVUiRgdTKZPQPlSm" +
                                                              "8KEKjf8PJkoBC2aiGujLakrL9nVMx3k/oyOEKuFD2+FrR+KP/1J0IDSupUkI" +
                                                              "S1iVVS00ZGhMfzMEiJMA246HEuD1EyFTswxwwZBmjIUw+ME4sScShpwcI6Ee" +
                                                              "ksKWQoclQ9bpMJEsQ6bTQeZp+v9hjwzTc+GUzwdHsNwLAArEzi5NSRIjLp22" +
                                                              "dkRuPBN/QzgXCwjbQhRtgm2DYtsg3zYotg0W3Rb5fHy3RWx7cdhwVBMQ9IC6" +
                                                              "teuGH9x94HhHALxMnyoDOzPSjrzsE3aQIQvncelSc93MqqubX/GjsihqxhK1" +
                                                              "sMKSSbcxBjAlTdiRXJuAvOSkh5Wu9MDymqFJJAnoVCpN2FyqtElisHGKFrk4" +
                                                              "ZJMXC9NQ6dRRVH50+ezUw3u/cKcf+fMzAtuyHMCMLR9iOJ7D604vEhTj23Ds" +
                                                              "2oeXzhzRHEzISzHZzFiwkunQ4fUHr3ni0vqV+Ln4S0c6udmrAbMphhgDOGzz" +
                                                              "7pEHOV1Z+Ga6VIHCKc1IY4VNZW1cQ8cNbcoZ4Y7axPuLwC0WsBhcCd9uOyj5" +
                                                              "L5tdorO2RTg28zOPFjw9fGpYf+qXP/3DFm7ubCZpcJUAw4R2udCLMWvmONXk" +
                                                              "uO2IQQjQvXt26KuPXT+2j/ssUKwutmEna8OAWnCEYOYvvXbonfeuzl3xO35O" +
                                                              "IX1bCaiCMjkl2TiqmUdJ2G2tIw+gnwLowLymc48K/imnZJxQCAusfzas2fzc" +
                                                              "n040Cj9QYCTrRhtvzcAZ/9gO9NAb+//Wxtn4JJZ9HZs5ZALSFzqcuw0DTzM5" +
                                                              "Mg+/teJrr+KnIDkAIJvyDOEYG+A2CHDNW6EY4ytZog2KRJudaC+AGpEteKmy" +
                                                              "JxZlZJ/kR7+VL7mTt3cxs/EdEJ/rYs0a0x1C+VHqqrXi0skrH9Tt/eDlG1zn" +
                                                              "/GLN7TH9WO8STsqatRlg3+KFuF3YHAe6uy4PfLZRuXwTOI4CRwmg2xw0AGYz" +
                                                              "ef5lU5dX/uoHryw58GYA+XtRjaLhZC/moYqqIUaIOQ4IndHvu1+4yFQVNI1c" +
                                                              "VVSgfMEAO6b24g4QSeuUH9nMd1u+s/387FXuq7rgsYyvL2NJIw+becnvwMOF" +
                                                              "tz/xs/NfOTMlioZ1pTHRs671H4NK4uhv/15gco6GRQoaz/rR0MUnl4bvfZ+v" +
                                                              "d2CJre7MFCY6gHZn7ccvpP/q76j4oR9VjqJGyS6x92LFYsE+CmWlma27oQzP" +
                                                              "m88vEUU91JWD3eVeSHRt6wVEJ8FCn1Gzfp0HA1vZEW6zcTCLh3kY6ANUKUti" +
                                                              "itm//XzhHbxdz5pNIuhYNwjoY/JynoIgsooVDwq1zLMNRXU93SPd8aHY4Mhg" +
                                                              "eJAH4TYBv6zdzpoBwe++km66M1+tMHxr7f3WFFNrW/GahhiGZgQl7jJBEVnB" +
                                                              "pCZZaeamlsEr4s/MZwjWxFgzXMQCa0pIBJVEJBYbjMXD3QMDgyPx7nA4Mjwc" +
                                                              "7xkM7+mPDIzEbWTyGuWB2zTKDvg22SJsLGaUrfMZxeSDwZShpYOA7Dwd52yC" +
                                                              "/2ebbCwhEIC1sMlwONY3NBLvjQ32x3v6ensjsXlMkvjvTVLPRlfDt8WWYEuB" +
                                                              "SRDvHCyuG9irWjc0CkFKkh7F6uZhS5HfJNmEtMyVqWxzRzIS0bNFg0u1iXlU" +
                                                              "E1N3sGZDThL+V4E8Fw93+neg2JcVaG2pYjzfJ1h6WlHqKsmvwXNHT88mB89t" +
                                                              "FtjdnH89i6hW+umf/+vHwbO/eb3IjaCaavomhUwSJU9E2DIvW/TzW7YDve/W" +
                                                              "n/rdC51jO26niGdjbbco09n/7aDE+tIJyCvKq0f/uHTk3vEDt1GPt3vM6WX5" +
                                                              "rf6Lr+9cK53y8ycFkRMKniLyF3XlZ4Iag1DLUEfy8sHq/Jp4FXz32P5yjzcg" +
                                                              "HI/0uFqu0iy1dJ5q6vg8c4+y5hEolMAdpYko1C7CDc15q4EhQ05D2T1pP0+E" +
                                                              "jjS/N/HktaeFJ3pTv4eYHD/96EfBE6eFV4oHn9UFby7uNeLRh4vbKAzyEfz5" +
                                                              "4Ps3+5gubID9QoIP2y8PK3NPD6wmMtCq+cTiW/T+/tKR73/zyDG/bZvDkJsn" +
                                                              "NTnpIMQXbwV+89dybCCiZyhaXDQNsFqvteCNT7xLSc/MNlS1zO75BQ+93NtR" +
                                                              "LQRRylIUdzXi6lfoBknJXJlaUZvo/OfrFLWUgCGoM0SHi/+EoJ+Fit9LD3UI" +
                                                              "/3XTfYOiGocOWImOm2SOogCQsO45vch1QhRlGZ8Ll2xT8hNYfKsTyC1x3/OY" +
                                                              "A/M31mzkW+KVNS5dmt09cPjGtnPinikpeGaGcVkQRZXiyptDj1UluWV5Vexa" +
                                                              "d7P+2eo1Wf9pEgI7Mb3MFXgRwFudnfhSzyXM7Mzdxd6Z2/7yT45XvAWhsg/5" +
                                                              "MEUL9xWWrxndAtjeF3WA2/VGz2+HXeuemL53Y+rPv+YXBBvol5emj0tXzj/4" +
                                                              "9qnWObhFLuhD5RAaJMPr6p5pNUakSWMU1clmJAMiAhcZK32oylLlQxbpS0ZR" +
                                                              "PXNOzC6F3C62Oetyo+yVgqKOwpAvfNuBy9QUMXZolprkeApI74zkPf5mAdjS" +
                                                              "dc8CZyR3lIsKdY9LPV9uePFkc6AXAixPHTf7StNK5MDd/R7soH0ja05mBBgF" +
                                                              "4tF+Xc+CU2C5Ljz+eUHDxinyrbdHGVT4RCJm/36Ps3uBd1nz4n8AlGUvY+oZ" +
                                                              "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fM8fvvV3nvtGfiT6f6sFy8nzJAAA");
}
