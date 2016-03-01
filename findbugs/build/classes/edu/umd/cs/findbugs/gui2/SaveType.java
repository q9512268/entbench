package edu.umd.cs.findbugs.gui2;
enum SaveType {
    NOT_KNOWN, HTML_OUTPUT, XML_ANALYSIS, FBP_FILE, FBA_FILE; 
    public edu.umd.cs.findbugs.gui2.FindBugsFileFilter getFilter() { switch (this) {
                                                                         case XML_ANALYSIS:
                                                                             return edu.umd.cs.findbugs.gui2.FindBugsAnalysisFileFilter.
                                                                                      INSTANCE;
                                                                         case HTML_OUTPUT:
                                                                             return edu.umd.cs.findbugs.gui2.FindBugsHtmlFileFilter.
                                                                                      INSTANCE;
                                                                         case FBP_FILE:
                                                                             return edu.umd.cs.findbugs.gui2.FindBugsFBPFileFilter.
                                                                                      INSTANCE;
                                                                         case FBA_FILE:
                                                                             return edu.umd.cs.findbugs.gui2.FindBugsFBAFileFilter.
                                                                                      INSTANCE;
                                                                         default:
                                                                             throw new java.lang.IllegalArgumentException(
                                                                               "No filter for type NOT_UNKNOWN");
                                                                     }
    }
    public boolean isValid(java.io.File f) {
        if (f.
              isDirectory(
                )) {
            return false;
        }
        edu.umd.cs.findbugs.gui2.FindBugsFileFilter filter =
          getFilter(
            );
        return filter.
          accept(
            f);
    }
    public java.lang.String getFileExtension() {
        switch (this) {
            case HTML_OUTPUT:
                return ".html";
            case XML_ANALYSIS:
                return ".xml";
            case FBP_FILE:
                return ".fbp";
            case FBA_FILE:
                return ".fba";
            default:
                throw new java.lang.IllegalArgumentException(
                  "No filter for type NOT_UNKNOWN");
        }
    }
    public static edu.umd.cs.findbugs.gui2.SaveType forFile(java.io.File f) {
        java.lang.String extension =
          edu.umd.cs.findbugs.util.Util.
          getFileExtension(
            f);
        if ("html".
              equals(
                extension) ||
              "htm".
              equals(
                extension)) {
            return edu.umd.cs.findbugs.gui2.SaveType.
                     HTML_OUTPUT;
        }
        if ("fba".
              equals(
                extension)) {
            return edu.umd.cs.findbugs.gui2.SaveType.
                     FBA_FILE;
        }
        if ("fbp".
              equals(
                extension)) {
            return edu.umd.cs.findbugs.gui2.SaveType.
                     FBP_FILE;
        }
        if ("xml".
              equals(
                extension)) {
            return edu.umd.cs.findbugs.gui2.SaveType.
                     XML_ANALYSIS;
        }
        if ("html".
              equals(
                extension)) {
            return edu.umd.cs.findbugs.gui2.SaveType.
                     XML_ANALYSIS;
        }
        if (f.
              getName(
                ).
              toLowerCase(
                ).
              endsWith(
                "xml.gz")) {
            return edu.umd.cs.findbugs.gui2.SaveType.
                     XML_ANALYSIS;
        }
        return edu.umd.cs.findbugs.gui2.SaveType.
                 NOT_KNOWN;
    }
    private SaveType() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ypvHIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "r9pPPF/xA21pFDPdvbt494ufP4mgR26F");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2xF0Kf8p2P0fu+5/GkEPn9MdsH74eLL3VyPonuPeEbSnnGr+OrC/g+YIugjK" +
       "k43fAFWgMX98xb/9ts7HchidyH/8cePFz/3OX1x73+5C6/T1XJECezD07Lgv" +
       "/uFF5N7oxk8U4cDRyl+loMth3jOCnrh1Om1Ba3f3du8OtIq0o/PzkN5wnFaR" +
       "36/tF9m6vp8ebjgnbjvz9rz2W6eu8s5XwU2FcG7yn/7iB9Dipu7axgiNSFOF" +
       "g/ze04lGx5l4z57K+T1XSTeVr3zqxz/z5FcnDxfJnDt95GzV0p1NNw7g7kIB" +
       "d3vQLpvvVk56wFGRF3VTee/H/vpzf/b8lz57EboC3Cq3ZynQQHQUQfu3yoE+" +
       "SeCGAJ46YBSIox7YjTZcvVjWg+W7flR7lIoXQd93K9rFte2ZjL08i9j2Ei3A" +
       "vdhVc7KPnwnaYt8/2bpz/+/YEH4ogN75OnR3JPrBnphHAmlw1nxONvrAf9sU" +
       "xvM3hfmoe3OCcQSG75IJvuWDxgvdguc/z4tvFkJ8a2d9efmXt1pqUH1hryhO" +
       "5VhB6Q76zlZeOB38H22d119r69wNuZw/FgcbKi/4vFjkhZSeSiM8a8l0vMt5" +
       "v6l86sUh84OvoD+7S2MESs+yA1O5a5dReRTuP3lLaoe0rgye+fYDv3j32w+P" +
       "Jg+c3SJPHHLedn6aYNfxoyKxL/uVN/+bd/38i18q8hX+H/IC/0mKMAAA");
}
