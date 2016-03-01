package edu.umd.cs.findbugs.sourceViewer;
public class JavaSourceDocument {
    static final javax.swing.text.SimpleAttributeSet commentAttributes = new javax.swing.text.SimpleAttributeSet(
      );
    static final javax.swing.text.SimpleAttributeSet javadocAttributes =
      new javax.swing.text.SimpleAttributeSet(
      );
    static final javax.swing.text.SimpleAttributeSet quotesAttributes =
      new javax.swing.text.SimpleAttributeSet(
      );
    static final javax.swing.text.SimpleAttributeSet keywordsAttributes =
      new javax.swing.text.SimpleAttributeSet(
      );
    static final javax.swing.text.SimpleAttributeSet whiteAttributes =
      new javax.swing.text.SimpleAttributeSet(
      );
    static java.awt.Font sourceFont = new java.awt.Font("Monospaced",
                                                        java.awt.Font.
                                                          PLAIN,
                                                        (int)
                                                          edu.umd.cs.findbugs.gui2.Driver.
                                                          getFontSize(
                                                            ));
    static final java.awt.Color HIGHLIGHT_COLOR = new java.awt.Color(
      1.0F,
      1.0F,
      0.3F);
    javax.swing.text.TabSet TAB_SET;
    static { commentAttributes.addAttribute(javax.swing.text.StyleConstants.
                                              Foreground,
                                            new java.awt.Color(
                                              0.0F,
                                              0.5F,
                                              0.0F));
             javadocAttributes.addAttribute(javax.swing.text.StyleConstants.
                                              Foreground,
                                            new java.awt.Color(
                                              0.25F,
                                              0.37F,
                                              0.75F));
             quotesAttributes.addAttribute(javax.swing.text.StyleConstants.
                                             Foreground, new java.awt.Color(
                                             0.0F,
                                             0.0F,
                                             1.0F));
             keywordsAttributes.addAttribute(javax.swing.text.StyleConstants.
                                               Foreground,
                                             new java.awt.Color(
                                               0.5F,
                                               0.0F,
                                               0.5F));
             keywordsAttributes.addAttribute(javax.swing.text.StyleConstants.
                                               Bold, true);
    }
    final edu.umd.cs.findbugs.sourceViewer.HighlightInformation
      highlights =
      new edu.umd.cs.findbugs.sourceViewer.HighlightInformation(
      );
    final edu.umd.cs.findbugs.sourceViewer.NumberedEditorKit
      dek =
      new edu.umd.cs.findbugs.sourceViewer.NumberedEditorKit(
      highlights);
    final javax.swing.text.DefaultStyledDocument doc;
    final edu.umd.cs.findbugs.ba.SourceFile sourceFile;
    public edu.umd.cs.findbugs.sourceViewer.HighlightInformation getHighlightInformation() {
        return highlights;
    }
    public javax.swing.text.StyledDocument getDocument() {
        return doc;
    }
    public edu.umd.cs.findbugs.sourceViewer.NumberedEditorKit getEditorKit() {
        return dek;
    }
    private final java.lang.String title;
    public java.lang.String getTitle() { return title;
    }
    public edu.umd.cs.findbugs.ba.SourceFile getSourceFile() {
        return sourceFile;
    }
    public JavaSourceDocument(java.lang.String title,
                              java.io.Reader in,
                              edu.umd.cs.findbugs.ba.SourceFile theSource)
          throws java.io.IOException { super();
                                       doc = new javax.swing.text.DefaultStyledDocument(
                                               );
                                       this.
                                         title =
                                         title;
                                       this.
                                         sourceFile =
                                         theSource;
                                       edu.umd.cs.findbugs.gui2.Debug.
                                         println(
                                           "Created JavaSourceDocument for " +
                                           title);
                                       try {
                                           dek.
                                             read(
                                               in,
                                               doc,
                                               0);
                                       }
                                       catch (javax.swing.text.BadLocationException e) {
                                           throw new java.lang.RuntimeException(
                                             e);
                                       }
                                       in.
                                         close(
                                           );
                                       doc.
                                         putProperty(
                                           javax.swing.text.Document.
                                             TitleProperty,
                                           title);
                                       java.awt.Toolkit toolkit =
                                         java.awt.Toolkit.
                                         getDefaultToolkit(
                                           );
                                       java.awt.FontMetrics fontMetrics =
                                         toolkit.
                                         getFontMetrics(
                                           sourceFont);
                                       javax.swing.text.TabStop[] tabs =
                                         new javax.swing.text.TabStop[50];
                                       float width =
                                         fontMetrics.
                                         stringWidth(
                                           " ");
                                       int tabSize =
                                         edu.umd.cs.findbugs.gui2.GUISaveState.
                                         getInstance(
                                           ).
                                         getTabSize(
                                           );
                                       for (int i =
                                              0;
                                            i <
                                              tabs.
                                                length;
                                            i++) {
                                           tabs[i] =
                                             new javax.swing.text.TabStop(
                                               width *
                                                 (tabSize +
                                                    tabSize *
                                                    i));
                                       }
                                       TAB_SET =
                                         new javax.swing.text.TabSet(
                                           tabs);
                                       javax.swing.text.StyleConstants.
                                         setTabSet(
                                           commentAttributes,
                                           TAB_SET);
                                       javax.swing.text.StyleConstants.
                                         setTabSet(
                                           javadocAttributes,
                                           TAB_SET);
                                       javax.swing.text.StyleConstants.
                                         setTabSet(
                                           quotesAttributes,
                                           TAB_SET);
                                       javax.swing.text.StyleConstants.
                                         setTabSet(
                                           keywordsAttributes,
                                           TAB_SET);
                                       javax.swing.text.StyleConstants.
                                         setTabSet(
                                           commentAttributes,
                                           TAB_SET);
                                       javax.swing.text.StyleConstants.
                                         setTabSet(
                                           whiteAttributes,
                                           TAB_SET);
                                       javax.swing.text.StyleConstants.
                                         setFontFamily(
                                           whiteAttributes,
                                           sourceFont.
                                             getFamily(
                                               ));
                                       javax.swing.text.StyleConstants.
                                         setFontSize(
                                           whiteAttributes,
                                           sourceFont.
                                             getSize(
                                               ));
                                       javax.swing.text.StyleConstants.
                                         setLeftIndent(
                                           whiteAttributes,
                                           edu.umd.cs.findbugs.sourceViewer.NumberedParagraphView.
                                             NUMBERS_WIDTH);
                                       doc.
                                         setParagraphAttributes(
                                           0,
                                           doc.
                                             getLength(
                                               ),
                                           whiteAttributes,
                                           true);
                                       edu.umd.cs.findbugs.sourceViewer.JavaScanner parser =
                                         new edu.umd.cs.findbugs.sourceViewer.JavaScanner(
                                         new edu.umd.cs.findbugs.sourceViewer.DocumentCharacterIterator(
                                           doc));
                                       while (parser.
                                                next(
                                                  ) !=
                                                edu.umd.cs.findbugs.sourceViewer.JavaScanner.
                                                  EOF) {
                                           int kind =
                                             parser.
                                             getKind(
                                               );
                                           switch (kind) {
                                               case edu.umd.cs.findbugs.sourceViewer.JavaScanner.
                                                      COMMENT:
                                                   doc.
                                                     setCharacterAttributes(
                                                       parser.
                                                         getStartPosition(
                                                           ),
                                                       parser.
                                                         getLength(
                                                           ),
                                                       commentAttributes,
                                                       true);
                                                   break;
                                               case edu.umd.cs.findbugs.sourceViewer.JavaScanner.
                                                      KEYWORD:
                                                   doc.
                                                     setCharacterAttributes(
                                                       parser.
                                                         getStartPosition(
                                                           ),
                                                       parser.
                                                         getLength(
                                                           ),
                                                       keywordsAttributes,
                                                       true);
                                                   break;
                                               case edu.umd.cs.findbugs.sourceViewer.JavaScanner.
                                                      JAVADOC:
                                                   doc.
                                                     setCharacterAttributes(
                                                       parser.
                                                         getStartPosition(
                                                           ),
                                                       parser.
                                                         getLength(
                                                           ),
                                                       javadocAttributes,
                                                       true);
                                                   break;
                                               case edu.umd.cs.findbugs.sourceViewer.JavaScanner.
                                                      QUOTE:
                                                   doc.
                                                     setCharacterAttributes(
                                                       parser.
                                                         getStartPosition(
                                                           ),
                                                       parser.
                                                         getLength(
                                                           ),
                                                       quotesAttributes,
                                                       true);
                                                   break;
                                               default:
                                                   break;
                                           }
                                       } }
    public static final edu.umd.cs.findbugs.sourceViewer.JavaSourceDocument
      UNKNOWNSOURCE;
    static { try { UNKNOWNSOURCE = new edu.umd.cs.findbugs.sourceViewer.JavaSourceDocument(
                                     "Unknown source",
                                     new java.io.StringReader(
                                       "Unable to find source"),
                                     null);
             }
             catch (java.io.IOException e) {
                 throw new java.lang.RuntimeException(
                   e);
             } }
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
       "6m7k2SMJ9BDgb3p0S3LM26PfB29P5YUv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("g6Qe8qb+4Hl7/13qns+zpxPoMcDb5PQd1TGDz9wPg1kC3bj9TWb+wOyZ256F" +
       "754yK19769pDT7/F/5viWeLRc+OHGeghPXXdky9zTnxfDiNNtwrmH9690wkL" +
       "jl5JoBff644T6OrJnzkPF27uun8ogZ68Q3cw+/vPk63hBLp63DqBLiqnqg8S" +
       "6MphdQJdAvnJyjIoApX5ZyXce4wTlzy750zZhdOL4JHHuPFek3Ji3Xz51GpX" +
       "POLfr0zp7hn/LeXrb/WHP/pu4+d3bywVV9pucyoPMdCV3XPPo9XtpXOp7Wld" +
       "7r763cd/5eFX9ivx4zvAx6p8AtsLd37Q2PHCpHiCuP2HT/+9j/3CW79b3HL9" +
       "P5/0ioNdMQAA");
}
