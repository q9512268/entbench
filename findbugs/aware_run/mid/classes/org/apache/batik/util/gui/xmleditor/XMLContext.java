package org.apache.batik.util.gui.xmleditor;
public class XMLContext extends javax.swing.text.StyleContext {
    public static final java.lang.String XML_DECLARATION_STYLE = "xml_declaration";
    public static final java.lang.String DOCTYPE_STYLE = "doctype";
    public static final java.lang.String COMMENT_STYLE = "comment";
    public static final java.lang.String ELEMENT_STYLE = "element";
    public static final java.lang.String CHARACTER_DATA_STYLE = "character_data";
    public static final java.lang.String ATTRIBUTE_NAME_STYLE = "attribute_name";
    public static final java.lang.String ATTRIBUTE_VALUE_STYLE = "attribute_value";
    public static final java.lang.String CDATA_STYLE = "cdata";
    protected java.util.Map syntaxForegroundMap = null;
    protected java.util.Map syntaxFontMap = null;
    public XMLContext() { super();
                          java.lang.String syntaxName;
                          java.awt.Font font;
                          java.awt.Color fontForeground;
                          syntaxFontMap = new java.util.HashMap();
                          syntaxForegroundMap = new java.util.HashMap();
                          java.awt.Font defaultFont = new java.awt.Font("Monospaced",
                                                                        java.awt.Font.
                                                                          PLAIN,
                                                                        12);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         DEFAULT_STYLE;
                          font = defaultFont;
                          fontForeground = java.awt.Color.
                                             black;
                          syntaxFontMap.put(syntaxName,
                                            font);
                          syntaxForegroundMap.put(
                                                syntaxName,
                                                fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         XML_DECLARATION_STYLE;
                          font = defaultFont.
                                   deriveFont(
                                     java.awt.Font.
                                       BOLD);
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              124);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         DOCTYPE_STYLE;
                          font = defaultFont.
                                   deriveFont(
                                     java.awt.Font.
                                       BOLD);
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              124);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         COMMENT_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              128,
                              128,
                              128);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ELEMENT_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              0,
                              0,
                              255);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         CHARACTER_DATA_STYLE;
                          font = defaultFont;
                          fontForeground =
                            java.awt.Color.
                              black;
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ATTRIBUTE_NAME_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              0,
                              124,
                              0);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         ATTRIBUTE_VALUE_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              153,
                              0,
                              107);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
                          syntaxName = org.apache.batik.util.gui.xmleditor.XMLContext.
                                         CDATA_STYLE;
                          font = defaultFont;
                          fontForeground =
                            new java.awt.Color(
                              124,
                              98,
                              0);
                          syntaxFontMap.put(
                                          syntaxName,
                                          font);
                          syntaxForegroundMap.
                            put(
                              syntaxName,
                              fontForeground);
    }
    public XMLContext(java.util.Map syntaxFontMap,
                      java.util.Map syntaxForegroundMap) {
        super(
          );
        setSyntaxFont(
          syntaxFontMap);
        setSyntaxForeground(
          syntaxForegroundMap);
    }
    public void setSyntaxForeground(java.util.Map syntaxForegroundMap) {
        if (syntaxForegroundMap ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "syntaxForegroundMap can not be null");
        }
        this.
          syntaxForegroundMap =
          syntaxForegroundMap;
    }
    public void setSyntaxFont(java.util.Map syntaxFontMap) {
        if (syntaxFontMap ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "syntaxFontMap can not be null");
        }
        this.
          syntaxFontMap =
          syntaxFontMap;
    }
    public java.awt.Color getSyntaxForeground(int ctx) {
        java.lang.String name =
          getSyntaxName(
            ctx);
        return getSyntaxForeground(
                 name);
    }
    public java.awt.Color getSyntaxForeground(java.lang.String name) {
        return (java.awt.Color)
                 syntaxForegroundMap.
                 get(
                   name);
    }
    public java.awt.Font getSyntaxFont(int ctx) {
        java.lang.String name =
          getSyntaxName(
            ctx);
        return getSyntaxFont(
                 name);
    }
    public java.awt.Font getSyntaxFont(java.lang.String name) {
        return (java.awt.Font)
                 syntaxFontMap.
                 get(
                   name);
    }
    public java.lang.String getSyntaxName(int ctx) {
        java.lang.String name =
          CHARACTER_DATA_STYLE;
        switch (ctx) {
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   XML_DECLARATION_CONTEXT:
                name =
                  XML_DECLARATION_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   DOCTYPE_CONTEXT:
                name =
                  DOCTYPE_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   COMMENT_CONTEXT:
                name =
                  COMMENT_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ELEMENT_CONTEXT:
                name =
                  ELEMENT_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ATTRIBUTE_NAME_CONTEXT:
                name =
                  ATTRIBUTE_NAME_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   ATTRIBUTE_VALUE_CONTEXT:
                name =
                  ATTRIBUTE_VALUE_STYLE;
                break;
            case org.apache.batik.util.gui.xmleditor.XMLScanner.
                   CDATA_CONTEXT:
                name =
                  CDATA_STYLE;
                break;
            default:
                name =
                  DEFAULT_STYLE;
                break;
        }
        return name;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/ERwXFwtPHpx+2uf+q+Pch8xPnELt5Ge");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("OMXn6S5/dvzGbwyeU37qYum2w9e4N1x6PNnopZMvby8HWhQHLnfiFe5jJ69E" +
       "fAg8L+9L9uWzTqGvnnPa/YGd7k+9w7+wIzh15n3t4Hj93NGOXQ34vXOuBnwt" +
       "T/5N/vJAi6an3h8UDf7RMVv71ah0+8Yz1SMj/N1buUlQFPz2SanB4PmxfRw/" +
       "9oOU2uN550+91WjHpPbNc6T23/Pkv+TvJo6ktntr+o0j2fz+9yGbYr7miv7s" +
       "Preffedlc0qzt5luVLT53+cA/9M8+R/AXPSbmMtD0f6rCWkb5Ze69q8rFwL5" +
       "zjshkFf2BfLKOyqQwsHmBBcu3xz9hXvz5I6z0edVpUOsFy59H1gLssfA8+o+" +
       "1lffcax/UuB5+Bysj+TJA8DE9eMmfqDj+w51fFhawH7wnYD9pX3YX/oBqfja" +
       "ObCfy5MnTsPOCx89Qvnk94HywbzwCfC8to/ytR+QcuFzUBYoysdRUvuL3ceP" +
       "UL54S7fEotLlo1vL+RXMR274/8Tuzr/yC69fues9r/P/tri4e3gv/26ydNcy" +
       "tu3jV6aO5S/5gbY0C+R37y5Q+QWSdlR65m3cqAaxyWE+5/1Ca9f8Q1HpvTdt" +
       "DnwiSI+TfzQqPXQmOVgY86/jtN2odPU0bVS6o/g+TocCyR3RRaVLu8xxEhxw" +
       "AkjyLOEfTMHHihvpe+HWdPW94or6NErzC7OFBpILJ6O5Qyf8ljP0WAD4zImw" +
       "rfjbzEGIFTP79y6/8vqQ+pFvN35md51ZsaUsy3u5iyzdubtZfRimPXXT3g76" +
       "uoQ//937f/HuZw9Cyvt3DB9NiGO8PXH23WHU8aPitm/2D97z9z70t1//WvGq" +
       "+/8BZHmPwM80AAA=");
}
