package org.apache.batik.util;
public class Service {
    static java.util.HashMap providerMap = new java.util.HashMap();
    public static synchronized java.util.Iterator providers(java.lang.Class cls) {
        java.lang.String serviceFile =
          "META-INF/services/" +
        cls.
          getName(
            );
        java.util.List l =
          (java.util.List)
            providerMap.
            get(
              serviceFile);
        if (l !=
              null)
            return l.
              iterator(
                );
        l =
          new java.util.ArrayList(
            );
        providerMap.
          put(
            serviceFile,
            l);
        java.lang.ClassLoader cl =
          null;
        try {
            cl =
              cls.
                getClassLoader(
                  );
        }
        catch (java.lang.SecurityException se) {
            
        }
        if (cl ==
              null)
            cl =
              org.apache.batik.util.Service.class.
                getClassLoader(
                  );
        if (cl ==
              null)
            return l.
              iterator(
                );
        java.util.Enumeration e;
        try {
            e =
              cl.
                getResources(
                  serviceFile);
        }
        catch (java.io.IOException ioe) {
            return l.
              iterator(
                );
        }
        while (e.
                 hasMoreElements(
                   )) {
            java.io.InputStream is =
              null;
            java.io.Reader r =
              null;
            java.io.BufferedReader br =
              null;
            try {
                java.net.URL u =
                  (java.net.URL)
                    e.
                    nextElement(
                      );
                is =
                  u.
                    openStream(
                      );
                r =
                  new java.io.InputStreamReader(
                    is,
                    "UTF-8");
                br =
                  new java.io.BufferedReader(
                    r);
                java.lang.String line =
                  br.
                  readLine(
                    );
                while (line !=
                         null) {
                    try {
                        int idx =
                          line.
                          indexOf(
                            '#');
                        if (idx !=
                              -1)
                            line =
                              line.
                                substring(
                                  0,
                                  idx);
                        line =
                          line.
                            trim(
                              );
                        if (line.
                              length(
                                ) ==
                              0) {
                            line =
                              br.
                                readLine(
                                  );
                            continue;
                        }
                        java.lang.Object obj =
                          cl.
                          loadClass(
                            line).
                          newInstance(
                            );
                        l.
                          add(
                            obj);
                    }
                    catch (java.lang.Exception ex) {
                        
                    }
                    line =
                      br.
                        readLine(
                          );
                }
            }
            catch (java.lang.Exception ex) {
                
            }
            catch (java.lang.LinkageError le) {
                
            }
            finally {
                if (is !=
                      null) {
                    try {
                        is.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    is =
                      null;
                }
                if (r !=
                      null) {
                    try {
                        r.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    r =
                      null;
                }
                if (br ==
                      null) {
                    try {
                        br.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    br =
                      null;
                }
            }
        }
        return l.
          iterator(
            );
    }
    public Service() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2xUxxWeXdvrB8ZeTGwID2OMoeHlxSWBtoYUMA8vWeOt" +
                                                              "DW5rAsvdu7P2hbv3Xu6dtdemCQGJgqqKRjxS0hZ+pKQP5IaoKmobKdRV1SYR" +
                                                              "TRE0apPQpmn40aYEKfxInJa+zszc9+46qpTG0h3fnTlzZuac73znzB27jcoM" +
                                                              "HTVrgpISWsmIho3WOH2PC7qBUx2yYBjboTchfuXPJw9O/LbyUBCF+lHNoGB0" +
                                                              "iYKBN0tYThn9aK6kGERQRGxswzhFZ8R1bGB9SCCSqvSjesmIZjRZEiXSpaYw" +
                                                              "FegT9BiaJhCiS8kswVFTAUHzYmw3EbabyHq/QHsMVYuqNuJMmOWZ0OEao7IZ" +
                                                              "Zz2DoHBsrzAkRLJEkiMxySDtOR0t1VR5ZEBWSSvOkda98gOmIbbGHsgzQ/Oz" +
                                                              "te/ffXwwzMwwXVAUlbAjGj3YUOUhnIqhWqd3k4wzxn70KCqJoSkuYYJaYtai" +
                                                              "EVg0Aota53WkYPdTsZLNdKjsOMTSFNJEuiGC5nuVaIIuZEw1cbZn0FBBzLOz" +
                                                              "yXDaJvu0lrt9Rzy9NHLq67vDPyxBtf2oVlJ66XZE2ASBRfrBoDiTxLqxPpXC" +
                                                              "qX40TQGH92JdEmRp1PR2nSENKALJAgQss9DOrIZ1tqZjK/AknE3PikTV7eOl" +
                                                              "GajMX2VpWRiAszY4Z+Un3Ez74YBVEmxMTwuAPXNK6T5JSTEceWfYZ2x5CARg" +
                                                              "ankGk0HVXqpUEaAD1XGIyIIyEOkF8CkDIFqmAgR1hrUiSqmtNUHcJwzgBEEz" +
                                                              "/XJxPgRSlcwQdApB9X4xpgm8NMvnJZd/bm9bc/yA0qkEUQD2nMKiTPc/BSY1" +
                                                              "+ib14DTWMcQBn1i9JPaE0PD8sSBCIFzvE+YyP/7SnXXLGsdf5DKzC8h0J/di" +
                                                              "kSTE88maa3M6Fn+6hG6jQlMNiTrfc3IWZXFzpD2nAdM02BrpYKs1ON7zqy8+" +
                                                              "dgHfCqKqKAqJqpzNAI6miWpGk2Ssb8EK1gWCU1FUiZVUBxuPonJ4j0kK5r3d" +
                                                              "6bSBSRSVyqwrpLLfYKI0qKAmqoJ3SUmr1rsmkEH2ntMQQuXwoGp4liP+x/4T" +
                                                              "tDsyqGZwRBAFRVLUSFxX6fmpQxnnYAPeUzCqqZEk4H/f8rbW1RFDzeoAyIiq" +
                                                              "D0QEQMUg5oPcJBAuQ5KIWynOtP/7Cjl6xunDgQCYf44/+GWIm05VTmE9IZ7K" +
                                                              "bth055nEFQ4sGgymdQiaC8u08mVa2TLcfeYyKBBg2u+hy/ERcMs+CHBg2OrF" +
                                                              "vbu27jnWXAKI0oZLwaZUdFFexulwmMCi74Q4dq1n4urLVReCKAhkkYSM49B+" +
                                                              "i4f2edbSVRGngHeKJQCLBCPFKb/gPtD4meFDfQdXsH24mZwqLAMSotPjlH/t" +
                                                              "JVr8EVxIb+3Rv75/8YlHVCeWPanBymh5MylFNPt96T98QlzSJFxKPP9ISxCV" +
                                                              "Au8A1xIBYgNorNG/hocq2i3apWepgAOnVT0jyHTI4soqMqirw04PA9k02tRz" +
                                                              "vFE4+DbIGHttr3b21d+8vZJZ0iL3WldW7sWk3UUoVFkdo45pDrq26xiD3B/P" +
                                                              "xE+evn10J4MWSCwotGALbTuASMA7YMEjL+5/7U9vnH8l6MCRQEbNJqE4ybGz" +
                                                              "3PMf+AvA82/6UBKgHZwM6jpMRmqyKUmjKy9y9gbkJEP4UnC07FAAfFJaEpIy" +
                                                              "prHwz9qFbZfeOR7m7pahx0LLsg9X4PTfuwE9dmX3RCNTExBpcnTs54hxxp3u" +
                                                              "aF6v68II3Ufu0PW5T74gnAXuBr40pFHMKBAxeyDmwPuZLSKsXekbW0WbFsON" +
                                                              "cW8YuYqYhPj4K+9O7Xv38h22W28V5PZ7l6C1cxRxL8Bi9chsPJRMRxs02s7I" +
                                                              "wR5m+EmnUzAGQdn949seDsvjd2HZflhWBLI0unUgupwHSqZ0WfnrP/9Fw55r" +
                                                              "JSi4GVXJqpDaLLCAQ5WAdGwMAkfmtM+u4/sYroAmzOyB8ixEjT6vsDs3ZTTC" +
                                                              "HDD6kxk/WvPdc28wFHLYzba5sSmPG1mZ7YT1Oze+efNnE98u50l6cXEu882b" +
                                                              "+Y9uOXn4rQ/yPMFYrEAB4ZvfHxn71qyOB2+x+Q6d0NkLcvnJBQjXmfvJC5n3" +
                                                              "gs2hXwZReT8Ki2ZJ2yfIWRrJ/VDGGVadC2WvZ9xbkvH6o92myzl+KnMt6ycy" +
                                                              "J6nBO5Wm71N9qJtCvRiBZ4WJuhV+1AUQe+lkUxay9j7aLLX5xGA1c87WyZBR" +
                                                              "NYlOgqZoujokAT4BjRRBbhDQO1NvNmmQHmGYVYIJ8avNRw59ovzOKo6BpoLS" +
                                                              "rqJx5cSq2qYL31O4eEth5d5y8a0DV55S/3AraJWChaZwyYeMrqvPdf4lwTi9" +
                                                              "gmbp7ZZtXfl3vT7gyhVh2zY1VpRvNG2zkXNt+iMti0BJBi5XUoZfzJQBQK5V" +
                                                              "gH1MK1G2mp0X245LLz33ndXHln3hKW7w+UXC2pH/6efevHZ29OIYzybU7AQt" +
                                                              "LXavzL/M0hpi4SR1kAOe97Z8Zvztm327gib/19BmO0f3TFKATenAwzYxBmxm" +
                                                              "a/CDiOsPtZ39+8Evv9oNZUoUVWQVaX8WR1PecC03skkXqpxLlBPCYdosz9Fs" +
                                                              "TVBgiaaZlQhtV9MmyrfcXojGc0WCmb4ucwKZ/YUmSUkuLkfU4XOLXeTYJfT8" +
                                                              "4VPnUt1Pt3GX13kvR5vg7v+D3/3r161n3nypQE1eSVRtuYyHsOzLH/PzMNbF" +
                                                              "7rkOGa++PlFy48TM6vyymmpqLFI0LykOFv8CLxz+26ztDw7u+R/q5Xk+Q/lV" +
                                                              "fr9r7KUti8QTQXZV59yfd8X3Tmr3QqhKxySrK17QNNuuvY+6rA2etaZr1/p5" +
                                                              "34FTHk5KGE5oEyOo2hhRRKiPFSisUr4k0DjJAr6Sy4ob+rvbq6USHtXUonK6" +
                                                              "lD5SEpPaPqVEYqrIvupA8dmb1TRVJxZjfnyLcfN9njajNuPUMsah5QCPJ9r9" +
                                                              "qN9u9OeeHHNabpJi9jBt9kM4WfnX8BmckgRjiV2mwXdZbtvB3Nbn2uIRe4t1" +
                                                              "DilGCWZXDzpytPAuHY7SJ+Go/FKTdqzLEVRu3sRp5TAz7wMf/yglPnOutmLG" +
                                                              "uR2/Z7dB+8NRNaTsdFaW3aWR6z2k6TgtMUtV80KJ0+rXCKov+FGAoFL6j+31" +
                                                              "OJc9QVDYL0tQGfvvljtNUJUjB2UUf3GLnCGoBETo65OaZeuwAwdeHeYCXhq2" +
                                                              "rVv/YdZ1MfcCD92xj6sWNWXjZgq+eG7rtgN3Vj3Nb7OiLIyOUi1TIF/xO7NN" +
                                                              "b/OLarN0hToX3615tnKhlWU9t2n33pjTATrs5jnLd70zWuxb3mvn11x++Vjo" +
                                                              "OuSOnSggEDR9Z34dndOywL07Y4UyM5A/u3m2V93cc/WD1wN17LpiZpnGyWYk" +
                                                              "xJOXb8TTmvaNIKqMojJIdTjHivyNI0oPFod0T6IPJdWsYn+HraHQFOiHVzu4" +
                                                              "waBT7V76oYOg5rwvrAU+/sBNbhjrG6h2s3DwJATgGfcos2yCVxGcVEsSsS5N" +
                                                              "M+//lfcyy2saC7sxFrn/BT7ud3ZBGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
