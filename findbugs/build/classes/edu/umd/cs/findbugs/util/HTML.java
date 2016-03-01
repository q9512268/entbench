package edu.umd.cs.findbugs.util;
public class HTML {
    private static final class HTMLtoPlainTextWriter2 extends javax.swing.text.html.HTMLWriter {
        boolean inPre = false;
        boolean startingParagraph = false;
        public HTMLtoPlainTextWriter2(java.io.Writer w, javax.swing.text.html.HTMLDocument doc) {
            super(
              w,
              doc);
            setLineLength(
              80);
            setCanWrapLines(
              true);
        }
        @java.lang.Override
        protected void startTag(javax.swing.text.Element elem) throws java.io.IOException {
            java.lang.String name =
              elem.
              getName(
                );
            startingParagraph =
              true;
            if ("ul".
                  equals(
                    name)) {
                super.
                  incrIndent(
                    );
                write(
                  "  ");
            }
            else
                if ("pre".
                      equals(
                        name)) {
                    inPre =
                      true;
                }
                else
                    if ("li".
                          equals(
                            name)) {
                        super.
                          incrIndent(
                            );
                        write(
                          "* ");
                    }
        }
        @java.lang.Override
        protected void writeEmbeddedTags(javax.swing.text.AttributeSet attr)
              throws java.io.IOException {  }
        @java.lang.Override
        protected void endTag(javax.swing.text.Element elem)
              throws java.io.IOException { java.lang.String name =
                                             elem.
                                             getName(
                                               );
                                           if ("p".equals(
                                                     name)) {
                                               writeLineSeparator(
                                                 );
                                               indent(
                                                 );
                                           }
                                           else
                                               if ("pre".
                                                     equals(
                                                       name)) {
                                                   inPre =
                                                     false;
                                               }
                                               else
                                                   if ("ul".
                                                         equals(
                                                           name)) {
                                                       super.
                                                         decrIndent(
                                                           );
                                                       writeLineSeparator(
                                                         );
                                                       indent(
                                                         );
                                                   }
                                                   else
                                                       if ("li".
                                                             equals(
                                                               name)) {
                                                           super.
                                                             decrIndent(
                                                               );
                                                           writeLineSeparator(
                                                             );
                                                           indent(
                                                             );
                                                       } }
        @java.lang.Override
        protected void incrIndent() {  }
        @java.lang.Override
        protected void decrIndent() {  }
        @java.lang.Override
        protected void emptyTag(javax.swing.text.Element elem)
              throws java.io.IOException,
            javax.swing.text.BadLocationException { if ("content".
                                                          equals(
                                                            elem.
                                                              getName(
                                                                ))) {
                                                        super.
                                                          emptyTag(
                                                            elem);
                                                    } }
        @java.lang.Override
        protected void text(javax.swing.text.Element elem)
              throws java.io.IOException,
            javax.swing.text.BadLocationException { java.lang.String contentStr =
                                                      getText(
                                                        elem);
                                                    if (!inPre) {
                                                        contentStr =
                                                          contentStr.
                                                            replaceAll(
                                                              "\\s+",
                                                              " ");
                                                        if (startingParagraph) {
                                                            while (contentStr.
                                                                     length(
                                                                       ) >
                                                                     0 &&
                                                                     contentStr.
                                                                     charAt(
                                                                       0) ==
                                                                     ' ') {
                                                                contentStr =
                                                                  contentStr.
                                                                    substring(
                                                                      1);
                                                            }
                                                        }
                                                        startingParagraph =
                                                          false;
                                                    }
                                                    if (contentStr.
                                                          length(
                                                            ) >
                                                          0) {
                                                        setCanWrapLines(
                                                          !inPre);
                                                        write(
                                                          contentStr);
                                                    }
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
           "f+6bfuylvyhPGf8NUcRvojArAAA=");
    }
    private HTML() { super(); }
    public static void convertHtmlToText(java.io.Reader reader,
                                         java.io.Writer writer)
          throws java.io.IOException,
        javax.swing.text.BadLocationException { javax.swing.text.EditorKit kit =
                                                  new javax.swing.text.html.HTMLEditorKit(
                                                  );
                                                javax.swing.text.html.HTMLDocument doc =
                                                  new javax.swing.text.html.HTMLDocument(
                                                  );
                                                kit.
                                                  read(
                                                    reader,
                                                    doc,
                                                    0);
                                                edu.umd.cs.findbugs.util.HTML.HTMLtoPlainTextWriter2 x =
                                                  new edu.umd.cs.findbugs.util.HTML.HTMLtoPlainTextWriter2(
                                                  writer,
                                                  doc);
                                                x.
                                                  write(
                                                    );
                                                writer.
                                                  close(
                                                    );
    }
    public static java.lang.String convertHtmlSnippetToText(java.lang.String htmlSnippet)
          throws java.io.IOException,
        javax.swing.text.BadLocationException {
        java.io.StringWriter writer =
          new java.io.StringWriter(
          );
        java.io.StringReader reader =
          new java.io.StringReader(
          "<HTML><BODY>" +
          htmlSnippet +
          "</BODY></HTML>");
        convertHtmlToText(
          reader,
          writer);
        return writer.
          toString(
            );
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
       "9sL8+iH9/Tf87tt+84Wv56eZ/wNNfHVGGiEAAA==");
}
