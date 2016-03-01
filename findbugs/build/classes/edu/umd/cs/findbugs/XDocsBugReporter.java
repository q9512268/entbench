package edu.umd.cs.findbugs;
public class XDocsBugReporter extends edu.umd.cs.findbugs.TextUIBugReporter {
    private final edu.umd.cs.findbugs.SortedBugCollection bugCollection;
    private final edu.umd.cs.findbugs.Project project;
    private final org.dom4j.Document document;
    private final org.dom4j.Element root;
    private static final java.lang.String ROOT_ELEMENT_NAME = "BugCollection";
    private static final java.lang.String PROJECT_ELEMENT_NAME = "Project";
    private static final java.lang.String ERRORS_ELEMENT_NAME = "Errors";
    private static final java.lang.String ANALYSIS_ERROR_ELEMENT_NAME = "AnalysisError";
    private static final java.lang.String MISSING_CLASS_ELEMENT_NAME = "MissingClass";
    private static final java.lang.String SUMMARY_HTML_ELEMENT_NAME = "SummaryHTML";
    private static final java.lang.String ELEMENT_NAME = "BugInstance";
    private static final java.lang.String FILE_ELEMENT_NAME = "file";
    public XDocsBugReporter(edu.umd.cs.findbugs.Project project) { super(
                                                                     );
                                                                   this.project =
                                                                     project;
                                                                   this.
                                                                     bugCollection =
                                                                     new edu.umd.cs.findbugs.SortedBugCollection(
                                                                       project);
                                                                   this.
                                                                     document =
                                                                     org.dom4j.DocumentHelper.
                                                                       createDocument(
                                                                         );
                                                                   this.
                                                                     root =
                                                                     document.
                                                                       addElement(
                                                                         ROOT_ELEMENT_NAME);
    }
    @java.lang.Override
    public void observeClass(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor) {
        
    }
    @java.lang.Override
    public void logError(java.lang.String message) {
        bugCollection.
          addError(
            message);
        super.
          logError(
            message);
    }
    @java.lang.Override
    public void reportMissingClass(java.lang.ClassNotFoundException ex) {
        java.lang.String missing =
          edu.umd.cs.findbugs.AbstractBugReporter.
          getMissingClassName(
            ex);
        if (!isValidMissingClassMessage(
               missing)) {
            return;
        }
        bugCollection.
          addMissingClass(
            missing);
        super.
          reportMissingClass(
            ex);
    }
    @java.lang.Override
    public void doReportBug(edu.umd.cs.findbugs.BugInstance bugInstance) {
        if (bugCollection.
              add(
                bugInstance)) {
            printBug(
              bugInstance);
            notifyObservers(
              bugInstance);
        }
    }
    @java.lang.Override
    protected void printBug(edu.umd.cs.findbugs.BugInstance bugInstance) {
        try {
            toElement(
              bugInstance);
        }
        catch (java.lang.Exception e) {
            logError(
              "Couldn\'t add Element",
              e);
        }
    }
    @java.lang.Override
    public void finish() { try { writeXML(
                                   outputStream,
                                   project);
                           }
                           catch (java.lang.Exception e) {
                               logError(
                                 "Couldn\'t write XML output",
                                 e);
                           }
                           outputStream.flush(
                                          );
    }
    private void writeXML(java.io.Writer out,
                          edu.umd.cs.findbugs.Project project)
          throws java.io.IOException { org.dom4j.Document document =
                                         endDocument(
                                           project);
                                       org.dom4j.io.XMLWriter writer =
                                         new org.dom4j.io.XMLWriter(
                                         out,
                                         org.dom4j.io.OutputFormat.
                                           createPrettyPrint(
                                             ));
                                       writer.
                                         write(
                                           document);
    }
    private org.dom4j.Document endDocument(edu.umd.cs.findbugs.Project project) {
        org.dom4j.Element errorsElement =
          root.
          addElement(
            ERRORS_ELEMENT_NAME);
        for (edu.umd.cs.findbugs.AnalysisError analysisError
              :
              bugCollection.
               getErrors(
                 )) {
            errorsElement.
              addElement(
                ANALYSIS_ERROR_ELEMENT_NAME).
              setText(
                analysisError.
                  getMessage(
                    ));
        }
        for (java.util.Iterator<java.lang.String> i =
               bugCollection.
               missingClassIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            errorsElement.
              addElement(
                MISSING_CLASS_ELEMENT_NAME).
              setText(
                i.
                  next(
                    ));
        }
        return document;
    }
    private static java.lang.String xmlEscape(java.lang.String theString) {
        java.lang.StringBuilder buf =
          new java.lang.StringBuilder(
          );
        int len =
          theString.
          length(
            );
        char theChar;
        for (int i =
               0;
             i <
               len;
             i++) {
            theChar =
              theString.
                charAt(
                  i);
            switch (theChar) {
                case '>':
                    buf.
                      append(
                        "&gt;");
                    break;
                case '<':
                    buf.
                      append(
                        "&lt;");
                    break;
                case '\"':
                    buf.
                      append(
                        "&quot;");
                    break;
                case '&':
                    buf.
                      append(
                        "&amp;");
                    break;
                case '\'':
                    buf.
                      append(
                        "&apos;");
                    break;
                default:
                    buf.
                      append(
                        theChar);
            }
        }
        return buf.
          toString(
            );
    }
    public void toElement(edu.umd.cs.findbugs.BugInstance bugInstance) {
        java.lang.String className =
          bugInstance.
          getPrimaryClass(
            ).
          getClassName(
            );
        org.dom4j.Element element =
          (org.dom4j.Element)
            root.
            selectSingleNode(
              FILE_ELEMENT_NAME +
              "[@classname=\'" +
              className +
              "\']");
        if (element ==
              null) {
            element =
              root.
                addElement(
                  FILE_ELEMENT_NAME);
            element.
              addAttribute(
                "classname",
                className);
        }
        element =
          element.
            addElement(
              ELEMENT_NAME);
        element.
          addAttribute(
            "type",
            bugInstance.
              getType(
                ));
        switch (bugInstance.
                  getPriority(
                    )) {
            case edu.umd.cs.findbugs.Priorities.
                   EXP_PRIORITY:
                element.
                  addAttribute(
                    "priority",
                    "Experimental");
                break;
            case edu.umd.cs.findbugs.Priorities.
                   LOW_PRIORITY:
                element.
                  addAttribute(
                    "priority",
                    "Low");
                break;
            case edu.umd.cs.findbugs.Priorities.
                   NORMAL_PRIORITY:
                element.
                  addAttribute(
                    "priority",
                    "Normal");
                break;
            case edu.umd.cs.findbugs.Priorities.
                   HIGH_PRIORITY:
                element.
                  addAttribute(
                    "priority",
                    "High");
                break;
            default:
                assert false;
        }
        element.
          addAttribute(
            "message",
            xmlEscape(
              bugInstance.
                getMessage(
                  )));
        edu.umd.cs.findbugs.SourceLineAnnotation line =
          bugInstance.
          getPrimarySourceLineAnnotation(
            );
        element.
          addAttribute(
            "line",
            java.lang.Integer.
              toString(
                line.
                  getStartLine(
                    )));
    }
    @java.lang.Override
    @javax.annotation.Nonnull
    public edu.umd.cs.findbugs.BugCollection getBugCollection() {
        return bugCollection;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2MyIr9VsdR8ej3CTOcofsXr0/1NexGQoLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dDWuOMH78mtvvKkxv4hc3l92+EZUuify");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/E/YeqLbJ5q6D7T0wo1PK6niZuDxS/hfe+2/PCZ8avnyBa4fPXEG59km/yb1" +
       "1d/o/4D6M5dLtx29kr/uzuLpSi+efhF/b6BHceAKp17Hf/T0FaBP7t/OlA7/" +
       "njxqPx6767TgUqEFu7E/c5fkzF2UT5z3Tr24oZof4u+Gp6uHamD6kRcULf7O" +
       "TW6n/Ls8+pdR6X5vHupBohf1i5K/ekK//n5Uuj0BLvZY8b55WvHuP1K8I6BX" +
       "j8/EmUQPAlPTb6Kr118fKRL++Wnx/iAI7F687Lsq3sK4igJ/cBNp/dc8+r2o" +
       "dLftLY5eDr59LJVv31AqefJ//L755+ol7vmL74l6PXk8aoUq0F7U82JXw1NV" +
       "93MTLBr5XzeR0Z/k0X8H4x8U1xXPvok8Ia0/eo+llb9Ef3kvrZffE2k9cZ4x" +
       "nnj7l7dx6e4bC+vS/Xl0W1S6T/N2tztB5dNSunT7eyelBw+ltNxLaXkRKQFX" +
       "7wdepKuRrt3CtC7dU7B99CaSeCyPrgLT8gPTPUcMj7zHyvJowXz3W787ynKS" +
       "3nM3yftYHj0Z5VfxXTNcniH+1HtHPL9/XdzaeGVP/JWLEsfPJX55dyHo0Ep2" +
       "r1BN72AamNHuGl65IF65uXU9cliPYE65n0tYHn0C6Momb3C2uyNwQmQHt3oP" +
       "eBOZvD9PfBKE1/Yyee3dkcmJeWZHvn0Tjejm0SeBW9Bd7eTNLvmY46e+D46P" +
       "5YnPgPD6nuPrF+B4fM/LfkcT6iX6JkTZPCKAJ0kdGw9VZbe0co9pDr8PmoVd" +
       "5zfDvran+bV3x66v82vyTRj+aB5NimXxiWtvJ5T1llf0bsLw6Prj23uGb787" +
       "DE8SMG6Sl/uqS0pUemihR+3zboA+dYMJ8kzJQhDzGzm6y7dwdIedPVp8hXFw" +
       "vF04oD3XjW37Qj4yBXTOfnGRXx9/9LovuXZfH6lfe/PK3R98c/Kvi48Ojr4Q" +
       "uocs3W2Avk/e5D3xfKcf6IZZCP+e3b1ev5BoDNzeOTIDvu7wMQd8KdqVBljv" +
       "PS4dlS6rp7JfiUp37bOj0m0gPpn5YyAJZOaPP+4fivC588ZLAPu1CXFCHOnO" +
       "RT96UimLFd3VW+nyiY3lM6e2g8XXdIdbt3j3Pd019etvDulXvov94u67CLDL" +
       "ybK8lbvJ0l27TzSKRvPt31M3bO2wrTsHz3/vwV++57nDreqDO8DHBnIC2xPn" +
       "f4SAO35UfDaQ/eoH/85Lf/3Nt4vrPf8PpbIUhuY4AAA=");
}
