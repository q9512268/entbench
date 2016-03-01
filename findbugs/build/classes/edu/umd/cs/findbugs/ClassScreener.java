package edu.umd.cs.findbugs;
public class ClassScreener implements edu.umd.cs.findbugs.IClassScreener {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findbugs.classscreener.debug");
    private static final java.lang.String SEP = "[/\\\\]";
    private static final java.lang.String START = "(?:^|" + SEP + ")";
    private static final java.lang.String JAVA_IDENTIFIER_PART = "[^./\\\\]";
    private final java.util.LinkedList<java.util.regex.Matcher> patternList;
    public ClassScreener() { super();
                             this.patternList = new java.util.LinkedList<java.util.regex.Matcher>(
                                                  ); }
    private static java.lang.String dotsToRegex(java.lang.String dotsName) {
        java.lang.String tmp =
          dotsName.
          replace(
            "$",
            "\\$");
        return tmp.
          replace(
            ".",
            SEP);
    }
    public void addAllowedClass(java.lang.String className) { java.lang.String classRegex =
                                                                START +
                                                              dotsToRegex(
                                                                className) +
                                                              ".class$";
                                                              if (DEBUG) {
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      "Class regex: " +
                                                                      classRegex);
                                                              }
                                                              patternList.
                                                                add(
                                                                  java.util.regex.Pattern.
                                                                    compile(
                                                                      classRegex).
                                                                    matcher(
                                                                      ""));
    }
    public void addAllowedPackage(java.lang.String packageName) {
        if (packageName.
              endsWith(
                ".")) {
            packageName =
              packageName.
                substring(
                  0,
                  packageName.
                    length(
                      ) -
                    1);
        }
        java.lang.String packageRegex =
          START +
        dotsToRegex(
          packageName) +
        SEP +
        JAVA_IDENTIFIER_PART +
        "+.class$";
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Package regex: " +
                packageRegex);
        }
        patternList.
          add(
            java.util.regex.Pattern.
              compile(
                packageRegex).
              matcher(
                ""));
    }
    public void addAllowedPrefix(java.lang.String prefix) {
        if (prefix.
              endsWith(
                ".")) {
            prefix =
              prefix.
                substring(
                  0,
                  prefix.
                    length(
                      ) -
                    1);
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Allowed prefix: " +
                prefix);
        }
        java.lang.String packageRegex =
          START +
        dotsToRegex(
          prefix) +
        SEP;
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Prefix regex: " +
                packageRegex);
        }
        patternList.
          add(
            java.util.regex.Pattern.
              compile(
                packageRegex).
              matcher(
                ""));
    }
    @java.lang.Override
    public boolean matches(java.lang.String fileName) {
        if (patternList.
              isEmpty(
                )) {
            return true;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Matching: " +
                fileName);
        }
        for (java.util.regex.Matcher matcher
              :
              patternList) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  print(
                    "\tTrying [" +
                    matcher.
                      pattern(
                        ));
            }
            matcher.
              reset(
                fileName);
            if (matcher.
                  find(
                    )) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "]: yes!");
                }
                return true;
            }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "]: no");
            }
        }
        return false;
    }
    @java.lang.Override
    public boolean vacuous() { return patternList.
                                 isEmpty(
                                   ); }
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
       "yecM8DvY9evtfkSCpW+B12yqMq0LwWqEE5WqLeWVEDWxdLNAiI3KcdwyM2CU" +
       "s8cu1ZAjA2bxGK6P6A3MLwx74LdrNipMVW2At0MxRDvtId+qc5NRaKkdLZyt" +
       "MQsZNmOKn+vzrkP1evCAVuedvqdsdvJcGs0kDNshVcPVXCfedMSZ5fiSnTEB" +
       "YzQsBWfmQ0zqdchWnq2mMzPkF9OxNOxnhtToOMtanWRde1lvEr7YjXkWdWdw" +
       "RFXi2EFDltN341aamfBwg24wbdX0Wv2Zrlda9VmeuKImVhrzud5vqsAA9Jwe" +
       "wohIGMHYDeAKU4VteqCzfjeswB6dzsQljxEbeKZjSafj7yJE3KUZ2wnDEYYN" +
       "sOm61aMorcVbodetmhsNn+Gwz2oTcayvmtpoJ4uktVMamZaClNuXEbpHjNre" +
       "SFFrFmwT7pocNie9CA6Wo1WtU6+M02i4HaFqAMwFX3NtcjSI/IRCBrnitioD" +
       "b74VJ4Pu3LMQ2qGy2TDqJtF4SLq1VF9WyW3Y2TWCUW0SJi1PmRO9UdZmOlRd" +
       "6jKd5XaI+O4q9OtRK2jKbtDirMZ6siLpsahZ7SU9g4VavKwv1up63EO5ZtiT" +
       "cpNKRynettSsKcArLiX4BrxZKQFFKJQ4pGeKOswrs1qTYmxsMnRTYo3qSKJh" +
       "SQMZ1vAO11pXQLhOVsPZckKryyqQoLkaiaHL5e1qy7M647qD5+TMQL3heOv2" +
       "+EiuLxAeJTAsqJlSCzUkThfZwMFgOF8q1T6aLClrJe8C3drMJMH3R7Nxv0Gz" +
       "zm6B5eSUjSoyTazaetVuIpTera4l2R4iStOx5uJMxeOozRBByuR4mlOWnKct" +
       "mpzjZoXUJxxBtdfJPOguegg1nyKbbStwcRmWxWWi1jueRrUGXOZXd7O6k2kZ" +
       "TudRup1rTlqlEpaYd7zdNBN9bMTXqlt+2vDN/mBNjheNbBAZc9YM5owba+iu" +
       "ZbFmTckqqaijs5Zmqy3JqO9CTu6lypSqhAGGoARa8Xi3h7jNTp1e4lXEiKvU" +
       "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" +
       "F6FLx99cX3XP7Oygm+fOlAMjigNXPPO9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9W3HSni8kPkz4JkcKmFy/vPLiZrv8u2F2NvKuRsDF/a6K62l7PDP7nKl4LeK" +
       "4tcj6IGFF4WiNymOg8uRJyb2G9/r4PE0zbLi185eVKmBZ3UIdPU6gJYQ3vna" +
       "MH7xLhh/ryh+J4KuqYtFxy6+BewvQt725DXxzMUJ9n/x/WJvgCc5xJ78gLD/" +
       "yV2wf6Uo/ghEkxPsh3cUi4YvnyD9N98vUhg8Hz9E+vEfENL/eBek/7kovhpB" +
       "D59CGhhLMzsH9GvfB9BHoUPnfekQ6Es/IKD/7S5AXymKb0TQFaf8alP24U7w" +
       "ffMsvgeP8R1H8+unPgwlRhCYC+Mui8hrF8pvHwrlt///COU05u/eue1COdX/" +
       "AvJIVD324vPy+Ks7yqOo/vbrQp5F0BvOrHrFRa/HXnXVen89WP+Vl65dfctL" +
       "0z8prwceX+G9j4OuLmPbPn0v59T7Zf/YaO/b39LxS5RXI+jR26zCESB2+Fpw" +
       "e+HKvvcDEXT/Se8IuqifaX4ISOuwOYIugfJ04yOgCjQWr9dLBX48u3Dmu+CJ" +
       "bK9/L186HnL6YuD5z9SDeH+P/Zb++ZeY4U+80vzF/cVE3VbzvKBylYOu7O9I" +
       "Hi/hT92R2hGty/Sz33noV+975ijdeGjP8IktnuLt7be/BUg6flTe28t/4y2/" +
       "9u5/+NJXy8+A/xeTI6RmXjAAAA==");
}
