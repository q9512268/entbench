package org.apache.batik.util.gui.xmleditor;
public class XMLDocument extends javax.swing.text.PlainDocument {
    protected org.apache.batik.util.gui.xmleditor.XMLScanner lexer;
    protected org.apache.batik.util.gui.xmleditor.XMLContext context;
    protected org.apache.batik.util.gui.xmleditor.XMLToken cacheToken = null;
    public XMLDocument() { this(new org.apache.batik.util.gui.xmleditor.XMLContext(
                                  )); }
    public XMLDocument(org.apache.batik.util.gui.xmleditor.XMLContext context) {
        super(
          );
        this.
          context =
          context;
        lexer =
          new org.apache.batik.util.gui.xmleditor.XMLScanner(
            );
    }
    public org.apache.batik.util.gui.xmleditor.XMLToken getScannerStart(int pos)
          throws javax.swing.text.BadLocationException { int ctx =
                                                           org.apache.batik.util.gui.xmleditor.XMLScanner.
                                                             CHARACTER_DATA_CONTEXT;
                                                         int offset =
                                                           0;
                                                         int tokenOffset =
                                                           0;
                                                         if (cacheToken !=
                                                               null) {
                                                             if (cacheToken.
                                                                   getStartOffset(
                                                                     ) >
                                                                   pos) {
                                                                 cacheToken =
                                                                   null;
                                                             }
                                                             else {
                                                                 ctx =
                                                                   cacheToken.
                                                                     getContext(
                                                                       );
                                                                 offset =
                                                                   cacheToken.
                                                                     getStartOffset(
                                                                       );
                                                                 tokenOffset =
                                                                   offset;
                                                                 javax.swing.text.Element element =
                                                                   getDefaultRootElement(
                                                                     );
                                                                 int line1 =
                                                                   element.
                                                                   getElementIndex(
                                                                     pos);
                                                                 int line2 =
                                                                   element.
                                                                   getElementIndex(
                                                                     offset);
                                                                 if (line1 -
                                                                       line2 <
                                                                       50) {
                                                                     return cacheToken;
                                                                 }
                                                             }
                                                         }
                                                         java.lang.String str =
                                                           getText(
                                                             offset,
                                                             pos -
                                                               offset);
                                                         lexer.
                                                           setString(
                                                             str);
                                                         lexer.
                                                           reset(
                                                             );
                                                         int lastCtx =
                                                           ctx;
                                                         int lastOffset =
                                                           offset;
                                                         while (offset <
                                                                  pos) {
                                                             lastOffset =
                                                               offset;
                                                             lastCtx =
                                                               ctx;
                                                             offset =
                                                               lexer.
                                                                 scan(
                                                                   ctx) +
                                                                 tokenOffset;
                                                             ctx =
                                                               lexer.
                                                                 getScanValue(
                                                                   );
                                                         }
                                                         cacheToken =
                                                           new org.apache.batik.util.gui.xmleditor.XMLToken(
                                                             lastCtx,
                                                             lastOffset,
                                                             offset);
                                                         return cacheToken;
    }
    public void insertString(int offset, java.lang.String str,
                             javax.swing.text.AttributeSet a)
          throws javax.swing.text.BadLocationException {
        super.
          insertString(
            offset,
            str,
            a);
        if (cacheToken !=
              null) {
            if (cacheToken.
                  getStartOffset(
                    ) >=
                  offset) {
                cacheToken =
                  null;
            }
        }
    }
    public void remove(int offs, int len)
          throws javax.swing.text.BadLocationException {
        super.
          remove(
            offs,
            len);
        if (cacheToken !=
              null) {
            if (cacheToken.
                  getStartOffset(
                    ) >=
                  offs) {
                cacheToken =
                  null;
            }
        }
    }
    public int find(java.lang.String str,
                    int fromIndex,
                    boolean caseSensitive)
          throws javax.swing.text.BadLocationException {
        int offset =
          -1;
        int startOffset =
          -1;
        int len =
          0;
        int charIndex =
          0;
        javax.swing.text.Element rootElement =
          getDefaultRootElement(
            );
        int elementIndex =
          rootElement.
          getElementIndex(
            fromIndex);
        if (elementIndex <
              0) {
            return offset;
        }
        charIndex =
          fromIndex -
            rootElement.
            getElement(
              elementIndex).
            getStartOffset(
              );
        for (int i =
               elementIndex;
             i <
               rootElement.
               getElementCount(
                 );
             i++) {
            javax.swing.text.Element element =
              rootElement.
              getElement(
                i);
            startOffset =
              element.
                getStartOffset(
                  );
            if (element.
                  getEndOffset(
                    ) >
                  getLength(
                    )) {
                len =
                  getLength(
                    ) -
                    startOffset;
            }
            else {
                len =
                  element.
                    getEndOffset(
                      ) -
                    startOffset;
            }
            java.lang.String text =
              getText(
                startOffset,
                len);
            if (!caseSensitive) {
                text =
                  text.
                    toLowerCase(
                      );
                str =
                  str.
                    toLowerCase(
                      );
            }
            charIndex =
              text.
                indexOf(
                  str,
                  charIndex);
            if (charIndex !=
                  -1) {
                offset =
                  startOffset +
                    charIndex;
                break;
            }
            charIndex =
              0;
        }
        return offset;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Rbwaoz/32SapYQUvLUKC/HbNHpibY6vM3S/UNkyo0fzWpj+PMIITtHmcoEpZ" +
       "NeHE6lrgYSvm6NdBgoqHNFlyrPrE/8aqbcwa/LNt8lYtxOrR2s/vQ5hVWcOm" +
       "/u5Etvk+bU7BidTASW2IhfY3HQuc/q8tUE2H6uHZZ6mxb/IWKMRaOK6+7gTX" +
       "HpeLPe4ujWmaggU1n3W+wnfy2Yns9zxtniP0PlGVnFWZ9X70H5xXCJriug2j" +
       "Z8GZOVfz/DpZfHq0umzG6MZX2Y1M5sq3EvJHPKUo7nLc9R7QDRyXmeiVvDjX" +
       "2dcFQOpbqMegesm8MxV+xdlfIei2guwAztC6yS8RND0vORiSfrlprwA6eGmh" +
       "nmffbrpXoch06CCi+Yub5CpIAiT09ZpuI0xjDsJEFDh72S5I+7Irw4x3p0/k" +
       "XVcx2ZyVb9lfMnZKSvE/ZaBYGF23fseNe57iF1WiIoyM0FmmQCLid2aZimtB" +
       "wdnsuQJr225Ofaa81c6PtVxgZ6vNdh2zl0NA6zTSZnluccyWzGXO6yeWnXv5" +
       "QOAyZPbNyCcQVL8599yY1lNQDm4O50u5UI+yC6b2ire2XPzwqq+OXV0gnqQb" +
       "x+OIikfOXYvEdf0JPyrvQiWwz3CaHWpXb1c3YHHIyMrggZiWUjP/3kyl20Kg" +
       "eM8sYxm0KtNLLzoJasqtUXIvfysUbRgbq+jsdJoqT42a0nX3KLPsIY431NIQ" +
       "edFwt65bxVk526vLdZ1t+78wxPk3830uL3cdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
