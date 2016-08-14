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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wNb+/t6OtZv622JdrZ157OzeKQJEx9lssW3OBbDSBjiG3h1bDk8boR8r8Jg2" +
       "ws2t0U15IN43RYhItsLiuyIXxJliWjcfnDYwPwaMzIrkV8mH/ns4PLw+H56w" +
       "xS2cBYfwl5/lxgFYSzRdZbAh07gHRHmeYRnMdwKih1S7qtNhXU0qcStqjHrA" +
       "PDpFMOh3V1lcV/mA+ZWdhT2WPWe/3uDu0nNWmM9sJ/PMNpUr9+N/hcRzIOrg" +
       "6ggLCeYNdX5n1vy8/fCNBw7Fu+9baQaGNe5z4DYlmXjwD/96IXT3iedyHDyW" +
       "MFU7X6ZjVHbwLHJnmRCKdvLjfDuue7Ni/9uPNQ6vncpRIdbVn+YwEP9fACCW" +
       "+0e33qk8c+Nf5/VfPrJ9Cqd+Czzi9A75o86jz61fKu4P8rsLM+DMuvNwd2px" +
       "h5mlOmVJXXHnKovd5wZr4NltKcBur9LaKuZ3buDX1ZPDWGkY11s+6mt5kpzX" +
       "sXgZ7ZSyPo+pGnlzjh4d0l4mjVnZXXh3zVuj9773oHUKkXUI6iKmew7c+mVo" +
       "7wFTPc0rpsVZtzzOPuY1k5kAYjGARrIoHxfeo/3dY7sfv3/3zels9reMzBhT" +
       "pbhtyq98FVkdr3/RvdgXwHOTtWI3TX2x/bqebrE/yLPYJ7H4Czo4e7HNqPG4" +
       "LZB3z4BA8GSHNMJzm4XqtqkLxK9rboEYuQ+3PHq4qme7uKex5520elxlqRb+" +
       "vOF4f4uRAsm6NPZIfUuK9/zMX+wBPtuPwcaGc9gYtkFmV8EzO2Gc4ZmkdX/L" +
       "l+PvZ3I59lky3Tf15fDr6q+fBhdGeR5BVWJRnFtQ2BTMiCVQcgbEwrvXwXPA" +
       "wnZg6mLx6+ovls859Hl5xDIfi9lgtsNOs01rTnlGczK1XEK1Z1JC91gw75m6" +
       "hPy6nk5xmvJIqBmLRq+EsLLeFsiSMyCQGmxbAM9BC9XBqQvEr+vpVOaiPALh" +
       "gFc6BdJlhSqGLZBVX8mBJiOl9jU13q/MzfooxvyQQ3zoUGXxnEObXuMhZOZj" +
       "izIIBoeSsuw8snO8F2o6HZK4GMvMAzx+fhu4EiKG/+IKHeLdzDtCCFxhdo8w" +
       "co5vd/D2UDrJ2yHPzEkO8QT+OGk7GKny0kKuyH+ddFGQnE3HSKH54iTphpkA" +
       "Cb72aGmDr+N3CyFjXFKGQ/ybhD42gdeNfAVSAXcqkdlIZp9utR3Zx2JX2Me/" +
       "hUrvpMke60bi2KGNXdeduug+8zJYlIVdu3CUWVFSZN5LZ4LvRb6jpccq3ND0" +
       "RcXDJUvS+3C1OWHbds51RDGtYAUaKto8z02p0Zi5MH398Jonf7en8GUIMLeS" +
       "gABbytbso+WUloSsZ2s0+7ICEhV+hdvS9P2Jy1cMffgGvwskZlwx358+Jr56" +
       "5NpX9s89XB8kszrITIhAaYqfea+bUHqpOKYPkHLJaEvBFGEUSZBdNyEV5jkz" +
       "rCuXiyXO8kwtfkrASEN2oJz9AUaprI5Tfa21c+Jdyiy7Jp2EufKXpKZ5Otg1" +
       "1lJiefVOHhbhaoByxqKdmpa+eSlr1rhT2JI7TkItFvkrvsX/A6LQFfMnKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dfau3GH74idfe0Mf/mzt4B36P0sq9yRB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+H2usQHu66iqi6CmF2+9m8iVRw+PXvr+6if/22PiR8yP38ZJpidP4DxZ5d/h" +
       "3vx18nntJ85X7jh8BXzTocgbC71844vfS5GRpJEv3vD69/Ebj1N8GFyv7Gv2" +
       "ldN2sK+csVP+ob2+P/H+/9yewIn98qsHW/NntnbsWMHvnnGs4CtF8m+LFw9G" +
       "Ipx491AW+CfHbO1Xksqdm8DSj4zwd27nFEKZ8Vs3aq0Krh/d5/Gj30utPVFU" +
       "/vTbtXZMa18/Q2v/o0j+a/Fe40hre29cv3akm9/7LnRTjteioz+zj/Yz775u" +
       "TvTsHZaflGX+9xnE/7RI/icwl9UtzOXhZP+1hpIlxYGw/ePMpUK+9W4o5NV9" +
       "hbz6riqkdLCFwLlLt2Z/7r4iuet09sWjyiHXcxe+C66l2OPgem2f62vvOtc/" +
       "Kfk8cgbXR4vkQWDiq+MmftDH9x/28WFuSfuhd4P2F/Zpf+F71MVXz6D9fJE8" +
       "eZJ2kfnYEcunvguWDxWZT4Lr9X2Wr3+POrd6BsuSBXScJb8/2X3siOVLt3XC" +
       "LKlcOjrxXBzffPSm/1fs/SdA+4U3Lt/9vjem/6489Ht4bv8etnL3MnXd48et" +
       "jt1fCCNjaZXM79k7fBWWTDpJ5dl3cBobxCaH9wX2c+294h9OKu+/ZXHgE0F6" +
       "XPyjSeXhU8XBxFh8HZfFksqVk7JJ5a7y+7gcATR3JJdULuzdHBehABIgUtzS" +
       "4cEQfLw8zX4tzix/da083i4k2+KwbdkD+bkbo7lDJ/y2I/RYAPjsDWFb+bea" +
       "gxArHe2f2fzSGwz/Q99s/uzeUWjNVXa7opa72crFvVPZh2Ha07es7aCuC9QL" +
       "337gF+957iCkfGAP8NGAOIbtydPPHRNemJQnhXf/6H3/4MN/642vlK/J/x/C" +
       "7KSL7zQAAA==");
}
