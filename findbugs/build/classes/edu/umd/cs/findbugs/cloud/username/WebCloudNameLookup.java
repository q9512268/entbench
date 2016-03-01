package edu.umd.cs.findbugs.cloud.username;
public class WebCloudNameLookup implements edu.umd.cs.findbugs.cloud.username.NameLookup {
    private static final java.lang.String APPENGINE_HOST_PROPERTY_NAME = "webcloud.host";
    private static final java.lang.String KEY_SAVE_SESSION_INFO = "save_session_info";
    static final java.lang.String KEY_APPENGINECLOUD_SESSION_ID = "webcloud_session_id";
    private static final java.lang.String SYSPROP_NEVER_SAVE_SESSION = "webcloud.never_save_session";
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.
      getLogger(
        edu.umd.cs.findbugs.cloud.username.WebCloudNameLookup.class.
          getName(
            ));
    private static final int USER_SIGNIN_TIMEOUT_SECS = 60;
    private java.lang.Long sessionId;
    private java.lang.String username;
    private java.lang.String url;
    @java.lang.Override
    public boolean signIn(edu.umd.cs.findbugs.cloud.CloudPlugin plugin,
                          edu.umd.cs.findbugs.BugCollection bugCollection)
          throws java.io.IOException { loadProperties(plugin);
                                       if (softSignin()) { return true;
                                       }
                                       if (sessionId == null) { sessionId =
                                                                  loadOrCreateSessionId(
                                                                    );
                                       }
                                       LOGGER.info("Opening browser for session " +
                                                   sessionId);
                                       java.net.URL u =
                                         new java.net.URL(
                                         url +
                                         "/browser-auth/" +
                                         sessionId);
                                       edu.umd.cs.findbugs.util.LaunchBrowser.
                                         showDocument(
                                           u);
                                       for (int i =
                                              0; i <
                                                   USER_SIGNIN_TIMEOUT_SECS;
                                            i++) {
                                           if (checkAuthorized(
                                                 getAuthCheckUrl(
                                                   sessionId))) {
                                               return true;
                                           }
                                           try {
                                               java.lang.Thread.
                                                 sleep(
                                                   1000);
                                           }
                                           catch (java.lang.InterruptedException e) {
                                               break;
                                           }
                                       }
                                       LOGGER.
                                         info(
                                           "Sign-in timed out for " +
                                           sessionId);
                                       throw new java.io.IOException(
                                         "Sign-in timed out");
    }
    public void loadProperties(edu.umd.cs.findbugs.cloud.CloudPlugin plugin) {
        edu.umd.cs.findbugs.PropertyBundle pluginProps =
          plugin.
          getProperties(
            );
        url =
          pluginProps.
            getProperty(
              APPENGINE_HOST_PROPERTY_NAME);
        if (url ==
              null) {
            throw new java.lang.IllegalStateException(
              "Host not specified for " +
              plugin.
                getId(
                  ));
        }
    }
    public boolean softSignin() throws java.io.IOException {
        if (url ==
              null) {
            throw new java.lang.IllegalStateException(
              "Null host");
        }
        checkResolveHost(
          );
        if (sessionId !=
              null) {
            if (checkAuthorized(
                  getAuthCheckUrl(
                    sessionId))) {
                LOGGER.
                  fine(
                    "Skipping soft init; session ID already exists - " +
                    sessionId);
                return true;
            }
            else {
                sessionId =
                  null;
            }
        }
        long id =
          loadSessionId(
            );
        if (id ==
              0) {
            return false;
        }
        boolean authorized =
          checkAuthorized(
            getAuthCheckUrl(
              id));
        if (authorized) {
            LOGGER.
              info(
                "Authorized with session ID: " +
                id);
            this.
              sessionId =
              id;
        }
        return authorized;
    }
    public void checkResolveHost() throws java.net.UnknownHostException {
        try {
            java.lang.String host =
              new java.net.URL(
              url).
              getHost(
                );
            java.net.InetAddress.
              getByName(
                host);
        }
        catch (java.net.MalformedURLException e) {
            assert true;
        }
    }
    private java.net.URL getAuthCheckUrl(long sessionId)
          throws java.net.MalformedURLException {
        return new java.net.URL(
          url +
          "/check-auth/" +
          sessionId);
    }
    public static void setSaveSessionInformation(boolean save) {
        java.util.prefs.Preferences prefs =
          java.util.prefs.Preferences.
          userNodeForPackage(
            edu.umd.cs.findbugs.cloud.username.WebCloudNameLookup.class);
        prefs.
          putBoolean(
            KEY_SAVE_SESSION_INFO,
            save);
        if (!save) {
            clearSavedSessionInformation(
              );
        }
    }
    public static boolean isSavingSessionInfoEnabled() {
        return !java.lang.Boolean.
          getBoolean(
            SYSPROP_NEVER_SAVE_SESSION) &&
          java.util.prefs.Preferences.
          userNodeForPackage(
            edu.umd.cs.findbugs.cloud.username.WebCloudNameLookup.class).
          getBoolean(
            KEY_SAVE_SESSION_INFO,
            true);
    }
    public static void clearSavedSessionInformation() {
        java.util.prefs.Preferences prefs =
          java.util.prefs.Preferences.
          userNodeForPackage(
            edu.umd.cs.findbugs.cloud.username.WebCloudNameLookup.class);
        prefs.
          remove(
            KEY_APPENGINECLOUD_SESSION_ID);
    }
    public static void saveSessionInformation(long sessionId) {
        assert sessionId !=
          0;
        java.util.prefs.Preferences.
          userNodeForPackage(
            edu.umd.cs.findbugs.cloud.username.WebCloudNameLookup.class).
          putLong(
            KEY_APPENGINECLOUD_SESSION_ID,
            sessionId);
    }
    public java.lang.Long getSessionId() {
        return sessionId;
    }
    @java.lang.Override
    public java.lang.String getUsername() {
        return username;
    }
    public java.lang.String getHost() { return url;
    }
    private static java.security.SecureRandom
      secureRandom =
      new java.security.SecureRandom(
      );
    private long loadOrCreateSessionId() {
        long id =
          loadSessionId(
            );
        if (id !=
              0) {
            LOGGER.
              info(
                "Using saved session ID: " +
                id);
            return id;
        }
        while (id ==
                 0) {
            id =
              secureRandom.
                nextLong(
                  );
        }
        if (isSavingSessionInfoEnabled(
              )) {
            saveSessionInformation(
              id);
        }
        return id;
    }
    private long loadSessionId() { java.util.prefs.Preferences prefs =
                                     java.util.prefs.Preferences.
                                     userNodeForPackage(
                                       edu.umd.cs.findbugs.cloud.username.WebCloudNameLookup.class);
                                   return prefs.
                                     getLong(
                                       KEY_APPENGINECLOUD_SESSION_ID,
                                       0);
    }
    private boolean checkAuthorized(java.net.URL response)
          throws java.io.IOException { java.net.HttpURLConnection connection =
                                         (java.net.HttpURLConnection)
                                           response.
                                           openConnection(
                                             );
                                       int responseCode =
                                         connection.
                                         getResponseCode(
                                           );
                                       if (responseCode ==
                                             200) {
                                           java.io.InputStream in =
                                             connection.
                                             getInputStream(
                                               );
                                           java.io.BufferedReader reader =
                                             edu.umd.cs.findbugs.charsets.UTF8.
                                             bufferedReader(
                                               in);
                                           try {
                                               java.lang.String status =
                                                 reader.
                                                 readLine(
                                                   );
                                               sessionId =
                                                 java.lang.Long.
                                                   parseLong(
                                                     reader.
                                                       readLine(
                                                         ));
                                               username =
                                                 reader.
                                                   readLine(
                                                     );
                                               edu.umd.cs.findbugs.util.Util.
                                                 closeSilently(
                                                   reader);
                                               if ("OK".
                                                     equals(
                                                       status)) {
                                                   LOGGER.
                                                     info(
                                                       "Authorized session " +
                                                       sessionId);
                                                   return true;
                                               }
                                           }
                                           finally {
                                               reader.
                                                 close(
                                                   );
                                           }
                                       }
                                       connection.
                                         disconnect(
                                           );
                                       return false;
    }
    public WebCloudNameLookup() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "E/Vj1wvUtpJs6GaGM+4YplJzyNdDimLXNAijYKNrYGsBdnzJEjrutt0R5v1U" +
       "gfr4IozzemNIhHLEda12u5WyMDrsqFUN7kFjtxVsu057taa2tWoPY9cF02wp" +
       "vkK0Qnwsi2KAZc2itRqN1cYizmM3R8U1bLJxP602dWbkMqu03oFn3TAyxi4L" +
       "ww23TuImbAxHLnBlybLdQ4mtWxPq1pzpzcYJoqp+3FO8Th3K6rm9WPJyNHEC" +
       "jnT4BdlIpEaVd725bnUGW5yx/M3YjpZNojWqLRGyhTNzyWkYM2xV6EMKqnmW" +
       "Z4wKsD+uemljgGWNYVsIbAxxmxghpwMKy/I+RaVF3OKUVOibQXta5TfbeVql" +
       "+6TkQwt0NSymrKjlXWU7G0Q13xvE5rBTzDxG76OjYbgWoxAZgxONrtADwOyM" +
       "J1NDaba0tRm2tgm+2LJoT56PmxOfYaMlOTdcPIGgusUSWkQ4VQyrk0EDmUUD" +
       "sjyeho6KjCCuTrYWtXSOjaGRjPYDkpjJXVugx3Cq9621rsRObVyMOzbG6UXB" +
       "TDVSwizJjqpmshpWk2XHjZphNIDalB+lNNMdbOujlR7OqPrCTPxlP56tycSZ" +
       "x01HHW1z06VjioZhVMW7jDrGh7bdUImxGwl5r0EQ/igb5p0ePElgravrGKwb" +
       "dAOoatJmPTYSumMS1EMWm66q0rBqtrqq0+q2l21xrTHtNT9qjBQ9iSaZQbCJ" +
       "LDbhnBAcI0mUeG12LIkZoK1QSmGg1qMJFDaVsD1b1ZdKdUK7Y0iPfI5v9eG6" +
       "WgNx5qqXCUICYp1WDYeTZhEUo1huKcgkSqRpe8YpkWgHDXygsk1apkeewo9T" +
       "rRNLsznca4CDdVftBVFLlKUoZN1Wk+q6smYMAnjW1tA1ZoEISglMydkKi9Bp" +
       "igrhsvPuJhpgclIL3F61EPXFQvB408v4mtGZFjxbCEZc4/JqOlSXEEsFAbMC" +
       "stIZszt33M4gaaYY2IHNYtkSUVdcLQRwUIoWxLAjd31n3Vn3nXmGL9f2SBWB" +
       "G652eRBET6uDJlW4g1bDx9POoBnImD8tao6kDqaOBAuka4cwXp1UmX49KSbG" +
       "tCUT9kZhuXQ4XQynTs9As/V42nHRsayifVnUuUJW0xVFdLdcsSoIYlN1eHqG" +
       "kxJk+u3GMBgYcdiXnFk+UPBtUwPHZalFmIGFVEcrbwpMYbpAx05NmMrddKhY" +
       "i5VLC5rWqc/ENZ6gI6G7qFLj/rwbktCISCTbi3BFSVZdbpTZeKMv1uuKOm0y" +
       "WUoyptMQpjjkExDXhvotOcSaZF+AfT8wMNFtVjtbmeD44drUEA4yN+iIxmVw" +
       "eHOxwpmNF2Lhu1J92Q1hmqFgBUdllYmjHNlyujNqzFoLNGo1t9s+GdoWshFm" +
       "tirXFut+j1eoZT9FOK9OiPNpMlpPpuJ6QRSJj4RqXoXn885kCfWAQXnatOAG" +
       "VBpK1bGKhwufHyO0P3EtWfLpIUIvu+LChtBWa+o12kFjSKKWE2LGyMBMyqGG" +
       "hDroARZUCZihnQY+3mLTlOi4HbOb850OOs1JJEzMxQgImWMHMDgJNcX6tDHA" +
       "iUnXnQaN1NL0CStTnlGzZmsFHWtdYdlB9HxYI1ESnfZJfkq7W9M1Ck/uK30K" +
       "6kNiY5SPpg0NqQ9rSBdEeQt42pyr61VLqc5b9S42ndHDKe7WIqRe7wwXg20S" +
       "9qmI2Yi5BfQQ6UNj06ypQ6234FtGjk5ojtgsJiN76bbbMlLPOqPmsoW1MqY2" +
       "bveqbYyza0xNXAYhO86VAJEHy25r0xhsl11j2UZsYk6Yw7rX6ROJ61IFKhCT" +
       "nBmGmMQO3CRZW5nUH+sjfCP1p/RQbGNewNh4HjH4OpBImMixCMJr43gtC0hL" +
       "DMTIrElKtzlv9CNtQ0ANke6auZ+wyGqZJa1EJLsmKsSzKilYhdZk9MLTMo7k" +
       "A57GeF42Ddyg9Y7VVgVi4YMIdAx5mYnDES64k40GMQKng4OttZwadK7B/ZlX" +
       "bY4Go/bag3vNfjCSPWGRI9O0ButrtctkdSigNzRX1dkuubBD0aUMaaD1AqqF" +
       "YILgtBs61YRpKN9qa6Yl0KSuO2mLbDaC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jsGRq3SIY6ankVu+0RrWhVZMjr2Gh7NOm6MavaCTpKYGy1hHRH3RhhvtJeXQ" +
       "2CipguNlHgaekSETzq/W48U6U1NJMvy4M2Z1tzYv9GLbLBYjL2nQioyvOxHJ" +
       "zdQA6VGZ4Hc7EIQNhxDvjDsIwfXnfHUFRwqPLeO2JESxJ9Ts9lK3kuZanEuZ" +
       "IQ1N3chG8FqOoXbqF/haB8cFeJw3DWg232wZS6XhfpyYotVXBarTTpO6YlZn" +
       "c4zqNbaeH0oSmQ1ppNkeDnSY4sGGXAdaG687fbHREBLRk4q2D0l8NWpM9CBK" +
       "LCrqqjObgQistuXpLhIlIo+3JDRZ+MAvQvnag2KOZtYIcH+N0dpsEp05srWx" +
       "LMnM1qTT7PVqkFoPmnE8LB8KvvOd5ePCL9/YY8wHdo9gT7L2/h8evu6bniiL" +
       "N5880N793Va5dp7LmVyAg+On0z/2ErKcTrObync0j10rhW/3fubzH37ueZ35" +
       "xdqlo8yL96eVO9Mw+jHPWBveGQLuAzO99drvoqhdBuNpRsDvfPi/Pyr8uP2+" +
       "G8h5esMFOi9O+c+oL/7e6C3aJy5VbjnJD7git/L8oGfOZwXcFRtpFgfCudyA" +
       "x86/YCjfF77rSB7vuviC4VTiV3/d8aN7jbmQ2HJp//rhWIJvvrYEd7lprJdZ" +
       "TnDc+4mr9R5k1mkSzm7Nf3dhzYPzWrNP0XHCQ4JBC82ITsb9h7L4rTJ3wbEC" +
       "IrjaU/nb1TD0DCU41fTfPq/pd59o+sl6D56+W2DWRhw7unEd47gyDWZX8W9O" +
       "JPPKsrJ8g/6eI8m85+WRzMFph6/tOnz3QoezOUl/XBZ/mFbuLRN82Dgss4jL" +
       "aPVqLzLWoaOf8uvbL/YO4zrQd0r5GLiWR9CXLw/0s8i+f222fH3X4S/K4s/S" +
       "yl1JaKY80BRnl57wzVOI37sJiDvpPgmuZ48gPvvyQ/yb69vHYzt9DYz0cBaA" +
       "6CUP8DBJz1vKD8vir9PK/ZptaMuj1HH8KD3ov5xy4n/eBCd23d4Ark8cceIT" +
       "N8oJ9MX0/IWyw8Err8+Ox0/YQSlemb9p6DOOPMePgzIJ4OC2tHKfZaT9LLWR" +
       "ki2z2Due4+5TlnLkCXsObr8J9jxYVv44uD51xJ5P3QB7dq9/95v7i/HomzuA" +
       "r7u2Oh08VhYPpZXXJkbKK2uDP0oOCHbJrsdZpadacfDwTcB+tKwsE26eP4L9" +
       "/MsI+yyqH7lO29Nl8WRaedRJAGAnsM5ARoMye1Q/7xIO3nSzki6T4H/hCPIv" +
       "/C1BblynrVUWh2nl9RrY/uJSzPqLyhm+WdDvBNcXjkB/4W9Hvfcu4F3XQd4v" +
       "i7enlYeSl6Lbz9ysxytzX144wvzCDWB+ab7/YHKdNqosMOCtgBc7BrpT5J85" +
       "xTe6WZmW2/eXj/B9+eXHJ12nbVEWXFp5JcA3O5sYdAqPv2Y0V1b/wc3EbTv0" +
       "ZUT960fof/3lR69fp80si8sghAXoj7fqM8jfdxOC3R3g3gKurxxB+8qNQrv6" +
       "Vn2W/Og6bWVK5MEyrbymjEaZGIkNJTXOafALp0C9mwX6OLi+cQT0Gy8/0J+8" +
       "TttPlUWeVu4pgV4LYHETAF9dVr4JXN86Avitlwfgqcc9eGCH5Nlru+RdmH3w" +
       "0bL4uyCk2oWYZVAVxs72io31790I2AIcxq786qn8bOORKz7A3H80qP3K8/fd" +
       "8fDzs2/tPvw5+bDvTrJyh5l53tks+zP3t0WxYTo7Rty5z7mPdph+Lq08+eKP" +
       "LM6kLZYIDj6+H/wciLCuOTit3Lr7f3bAp8FR9yoDwPTHt2d7/xNwojntnVYu" +
       "aeeaPwscx1FzmcDon1vpc6AKNJa3/3Rvp+ez+PdfMhT7kPqRs5pXyrDy4IvJ" +
       "8GTI2Y+Oyscuu69rjx+RZPvvay9rX3p+TL//++1f3H/0pHnKdlvOcgdZuX3/" +
       "/dVu0vIxyxPXnO14rtvwp39w76/e+ebjR0L37gk+tYIztL3h6l8VoX6U7r4D" +
       "2v7Lh//5O37p+W/v0qP/L1MqWf72PAAA");
}
