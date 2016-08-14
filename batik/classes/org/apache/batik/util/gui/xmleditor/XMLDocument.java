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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AwsnGBwWDuaGLGw/4K/YXP8v9oA9Wk4eAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16eczr2HUf3zfz3pt5Hs97M7bHk6lnf5N4LOejRImi1Emc" +
       "SJQokSIliosWJvEzd3GnuEliOlmcNnYawDXSsevWybR/OJvjxEnRIAHaBBNk" +
       "sQ07Adwa2YDERhqgaVMD8R9Ng7ptekl9+3tvFtioAF5dXp577jnnnvO766e+" +
       "Cl2OI6gSBu7OdIPkUN8mh7aLHia7UI8PKRpl5SjWNdyV41gAZbfUZ375+t9+" +
       "/cOrGwfQFQl6i+z7QSInVuDHnB4HbqZrNHT9tLTv6l6cQDdoW85kOE0sF6at" +
       "OHmBht50pmoC3aSPRYCBCDAQAS5FgDunVKDSm3U/9fCihuwn8Rr6AegSDV0J" +
       "1UK8BHr6PJNQjmTviA1bagA43Fe8z4BSZeVtBD11ovte59sU/kgFfulfvPfG" +
       "v70Hui5B1y2fL8RRgRAJaESCHvB0T9GjuKNpuiZBD/m6rvF6ZMmulZdyS9DD" +
       "sWX6cpJG+omRisI01KOyzVPLPaAWukWpmgTRiXqGpbva8dtlw5VNoOsjp7ru" +
       "NSSKcqDgNQsIFhmyqh9XudexfC2BnrxY40THmyNAAKpe9fRkFZw0da8vgwLo" +
       "4X3fubJvwnwSWb4JSC8HKWglgR67K9PC1qGsOrKp30qgRy/SsftPgOr+0hBF" +
       "lQR620WykhPopccu9NKZ/vnq+Ds+9P3+0D8oZdZ01S3kvw9UeuJCJU439Ej3" +
       "VX1f8YF30R+VH/mNDx5AECB+2wXiPc2v/aOvffe7n3jls3uaf3AHmoli62py" +
       "S/2E8uAX34E/376nEOO+MIitovPPaV66P3v05YVtCCLvkROOxcfD44+vcL+3" +
       "/KFP6n99AF0joStq4KYe8KOH1MALLVePBrqvR3KiayR0v+5rePmdhK6CPG35" +
       "+r50YhixnpDQvW5ZdCUo34GJDMCiMNFVkLd8IzjOh3KyKvPbEIKgq+CBHgDP" +
       "U9D+V/4nkAKvAk+HZVX2LT+A2Sgo9I9h3U8UYNsVrACvd+A4SCPggnAQmbAM" +
       "/GClH30ojWCmFrz1XF2zgKPDC4buBWrqARaHha+F/19a2Ra63thcugS64R0X" +
       "QcAF8TMMXE2Pbqkvpd3+137p1ucPToLiyEoJVDR8uG/4sGx4342g4cOThg/P" +
       "NAxdulS299ZCgD0t6DAHhD4AxQee57+Pet8Hn7kH+Fq4uRdY+wCQwnfHZvwU" +
       "LMgSElXgsdArH9v88OwHqwfQwXmQLYQGRdeK6mwBjScQePNicN2J7/UP/NXf" +
       "fvqjLwanYXYOtY+i//aaRfQ+c9G8UaDqGsDDU/bvekr+1Vu/8eLNA+heAAkA" +
       "BhMZuC1AmCcutnEuil84RsRCl8tAYSOIPNktPh3D2LVkFQWb05Ky3x8s8w8B" +
       "G7+pcOtHwPNtR35e/hdf3xIW6Vv3flJ02gUtSsT9Tj78qT/+g/9aL819DM7X" +
       "zwx3vJ68cAYQCmbXy9B/6NQHhEjXAd2ffYz95x/56ge+p3QAQPHsnRq8WaQ4" +
       "AALQhcDM/+Sz6z/58p9/4ksHJ05zKQEjYqq4lro9UbIoh669ipKgtW89lQcA" +
       "igvCrfCam6LvBZplWLLi6oWX/u/rz9V+9b9/6MbeD1xQcuxG735tBqfl39KF" +
       "fujz7/2fT5RsLqnFgHZqs1OyPUq+5ZRzJ4rkXSHH9of/4+P/8jPyTwG8BRgX" +
       "W7lewhZU2gAqOw0u9X9XmR5e+FYrkifjs85/Pr7OTDxuqR/+0t+8efY3v/m1" +
       "UtrzM5ezfc3I4Qt79yqSp7aA/dsvRvpQjleArvHK+HtvuK98HXCUAEcVoFg8" +
       "iQDebM95xhH15at/+lu//cj7vngPdEBA19xA1gi5DDLofuDderwCULUNv+u7" +
       "9527uQ8kN0pVoduULwseu939D4884/DO7l+kTxfJc7c71d2qXjD/pb17lu9v" +
       "S6DD14mdRzOtUo73vEqPdoukXX5CiuQf7lVFX5dV9rSPlm9XQLc9f3fUJYrp" +
       "2ClwPfq/Jq7y/r/4u9tco8TbO8xCLtSX4E/95GP4e/66rH8KfEXtJ7a3j0xg" +
       "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" +
       "csRQFvzE+YOXHnjUI0Op3xxD3XMaTx8vY+VY/cdvU7+TJJGlpElxWFDy+oU7" +
       "G7B4/TclwaeL5GcS6AHLj/Uo2e+H3qlP7s0C64yhfvYbNdTzpW32v/U3x1AH" +
       "+yP2E0N9vKT6D69lgt8skl9LoCuR7gVZGQO/cqror38Dil4vCt8Cnh85UvRH" +
       "vukeUQLnx+/UYVeVIHB1ee/+n30tI/x+kfx2Utwl8bVTnqUJfucNnbsl0JvO" +
       "3I8oDnsfve1C1v4SkfpLL1+/7+0vi39UXhE4uehzPw3dZ6Sue/YU6kz+Shjp" +
       "hlUKff/+TCos/76UQM++jgMKAOQn+VL4/7Sv/kcJ9C13rQ4gCaRnyf80gd52" +
       "R3JgwuLvLO2fJdCNi7QJdLn8P0v3lQS6dkoHHHKfOUvyn4EkgKTI/mV4jANP" +
       "3IYDrCtb/nEXbC+dH/tO+vXh1+rXM8Pls+cGufIi3vGAlO6v4t1SP/0yNf7+" +
       "rzV/en9zQnXlvHTJ+2jo6v4Sx8mg9vRduR3zujJ8/usP/vL9zx0PwA/uBT6N" +
       "lzOyPXnnawp9L0zKiwX5r7/9333Hz7785+Vhy/8Dhv23aSEpAAA=");
}
