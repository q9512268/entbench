package org.apache.xalan.xsltc.dom;
public abstract class NodeCounter {
    public static final int END = org.apache.xml.dtm.DTM.NULL;
    protected int _node = END;
    protected int _nodeType = org.apache.xalan.xsltc.DOM.FIRST_TYPE - 1;
    protected double _value = java.lang.Integer.MIN_VALUE;
    public final org.apache.xalan.xsltc.DOM _document;
    public final org.apache.xml.dtm.DTMAxisIterator _iterator;
    public final org.apache.xalan.xsltc.Translet _translet;
    protected java.lang.String _format;
    protected java.lang.String _lang;
    protected java.lang.String _letterValue;
    protected java.lang.String _groupSep;
    protected int _groupSize;
    private boolean _separFirst = true;
    private boolean _separLast = false;
    private java.util.Vector _separToks = new java.util.Vector();
    private java.util.Vector _formatToks = new java.util.Vector();
    private int _nSepars = 0;
    private int _nFormats = 0;
    private static final java.lang.String[] Thousands = { "", "m", "mm", "mmm" };
    private static final java.lang.String[] Hundreds = { "", "c", "cc", "ccc",
    "cd",
    "d",
    "dc",
    "dcc",
    "dccc",
    "cm" };
    private static final java.lang.String[] Tens = { "", "x", "xx", "xxx",
    "xl",
    "l",
    "lx",
    "lxx",
    "lxxx",
    "xc" };
    private static final java.lang.String[] Ones = { "", "i", "ii", "iii",
    "iv",
    "v",
    "vi",
    "vii",
    "viii",
    "ix" };
    private java.lang.StringBuffer _tempBuffer = new java.lang.StringBuffer(
      );
    protected NodeCounter(org.apache.xalan.xsltc.Translet translet, org.apache.xalan.xsltc.DOM document,
                          org.apache.xml.dtm.DTMAxisIterator iterator) {
        super(
          );
        _translet =
          translet;
        _document =
          document;
        _iterator =
          iterator;
    }
    public abstract org.apache.xalan.xsltc.dom.NodeCounter setStartNode(int node);
    public org.apache.xalan.xsltc.dom.NodeCounter setValue(double value) {
        _value =
          value;
        return this;
    }
    protected void setFormatting(java.lang.String format, java.lang.String lang,
                                 java.lang.String letterValue,
                                 java.lang.String groupSep,
                                 java.lang.String groupSize) { _lang =
                                                                 lang;
                                                               _groupSep =
                                                                 groupSep;
                                                               _letterValue =
                                                                 letterValue;
                                                               try {
                                                                   _groupSize =
                                                                     java.lang.Integer.
                                                                       parseInt(
                                                                         groupSize);
                                                               }
                                                               catch (java.lang.NumberFormatException e) {
                                                                   _groupSize =
                                                                     0;
                                                               }
                                                               setTokens(
                                                                 format);
    }
    private final void setTokens(final java.lang.String format) {
        if (_format !=
              null &&
              format.
              equals(
                _format)) {
            return;
        }
        _format =
          format;
        final int length =
          _format.
          length(
            );
        boolean isFirst =
          true;
        _separFirst =
          true;
        _separLast =
          false;
        _nSepars =
          0;
        _nFormats =
          0;
        _separToks.
          clear(
            );
        _formatToks.
          clear(
            );
        for (int j =
               0,
               i =
                 0;
             i <
               length;
             ) {
            char c =
              format.
              charAt(
                i);
            for (j =
                   i;
                 java.lang.Character.
                   isLetterOrDigit(
                     c);
                 ) {
                if (++i ==
                      length)
                    break;
                c =
                  format.
                    charAt(
                      i);
            }
            if (i >
                  j) {
                if (isFirst) {
                    _separToks.
                      addElement(
                        ".");
                    isFirst =
                      (_separFirst =
                         false);
                }
                _formatToks.
                  addElement(
                    format.
                      substring(
                        j,
                        i));
            }
            if (i ==
                  length)
                break;
            c =
              format.
                charAt(
                  i);
            for (j =
                   i;
                 !java.lang.Character.
                   isLetterOrDigit(
                     c);
                 ) {
                if (++i ==
                      length)
                    break;
                c =
                  format.
                    charAt(
                      i);
                isFirst =
                  false;
            }
            if (i >
                  j) {
                _separToks.
                  addElement(
                    format.
                      substring(
                        j,
                        i));
            }
        }
        _nSepars =
          _separToks.
            size(
              );
        _nFormats =
          _formatToks.
            size(
              );
        if (_nSepars >
              _nFormats)
            _separLast =
              true;
        if (_separFirst)
            _nSepars--;
        if (_separLast)
            _nSepars--;
        if (_nSepars ==
              0) {
            _separToks.
              insertElementAt(
                ".",
                1);
            _nSepars++;
        }
        if (_separFirst)
            _nSepars++;
    }
    public org.apache.xalan.xsltc.dom.NodeCounter setDefaultFormatting() {
        setFormatting(
          "1",
          "en",
          "alphabetic",
          null,
          null);
        return this;
    }
    public abstract java.lang.String getCounter();
    public java.lang.String getCounter(java.lang.String format,
                                       java.lang.String lang,
                                       java.lang.String letterValue,
                                       java.lang.String groupSep,
                                       java.lang.String groupSize) {
        setFormatting(
          format,
          lang,
          letterValue,
          groupSep,
          groupSize);
        return getCounter(
                 );
    }
    public boolean matchesCount(int node) {
        return _nodeType ==
          _document.
          getExpandedTypeID(
            node);
    }
    public boolean matchesFrom(int node) {
        return false;
    }
    protected java.lang.String formatNumbers(int value) {
        return formatNumbers(
                 new int[] { value });
    }
    protected java.lang.String formatNumbers(int[] values) {
        final int nValues =
          values.
            length;
        final int length =
          _format.
          length(
            );
        boolean isEmpty =
          true;
        for (int i =
               0;
             i <
               nValues;
             i++)
            if (values[i] !=
                  java.lang.Integer.
                    MIN_VALUE)
                isEmpty =
                  false;
        if (isEmpty)
            return "";
        boolean isFirst =
          true;
        int t =
          0;
        int n =
          0;
        int s =
          1;
        _tempBuffer.
          setLength(
            0);
        final java.lang.StringBuffer buffer =
          _tempBuffer;
        if (_separFirst)
            buffer.
              append(
                (java.lang.String)
                  _separToks.
                  elementAt(
                    0));
        while (n <
                 nValues) {
            final int value =
              values[n];
            if (value !=
                  java.lang.Integer.
                    MIN_VALUE) {
                if (!isFirst)
                    buffer.
                      append(
                        (java.lang.String)
                          _separToks.
                          elementAt(
                            s++));
                formatValue(
                  value,
                  (java.lang.String)
                    _formatToks.
                    elementAt(
                      t++),
                  buffer);
                if (t ==
                      _nFormats)
                    t--;
                if (s >=
                      _nSepars)
                    s--;
                isFirst =
                  false;
            }
            n++;
        }
        if (_separLast)
            buffer.
              append(
                (java.lang.String)
                  _separToks.
                  lastElement(
                    ));
        return buffer.
          toString(
            );
    }
    private void formatValue(int value, java.lang.String format,
                             java.lang.StringBuffer buffer) {
        char c =
          format.
          charAt(
            0);
        if (java.lang.Character.
              isDigit(
                c)) {
            char zero =
              (char)
                (c -
                   java.lang.Character.
                   getNumericValue(
                     c));
            java.lang.StringBuffer temp =
              buffer;
            if (_groupSize >
                  0) {
                temp =
                  new java.lang.StringBuffer(
                    );
            }
            java.lang.String s =
              "";
            int n =
              value;
            while (n >
                     0) {
                s =
                  (char)
                    ((int)
                       zero +
                       n %
                       10) +
                  s;
                n =
                  n /
                    10;
            }
            for (int i =
                   0;
                 i <
                   format.
                   length(
                     ) -
                   s.
                   length(
                     );
                 i++) {
                temp.
                  append(
                    zero);
            }
            temp.
              append(
                s);
            if (_groupSize >
                  0) {
                for (int i =
                       0;
                     i <
                       temp.
                       length(
                         );
                     i++) {
                    if (i !=
                          0 &&
                          (temp.
                             length(
                               ) -
                             i) %
                          _groupSize ==
                          0) {
                        buffer.
                          append(
                            _groupSep);
                    }
                    buffer.
                      append(
                        temp.
                          charAt(
                            i));
                }
            }
        }
        else
            if (c ==
                  'i' &&
                  !_letterValue.
                  equals(
                    "alphabetic")) {
                buffer.
                  append(
                    romanValue(
                      value));
            }
            else
                if (c ==
                      'I' &&
                      !_letterValue.
                      equals(
                        "alphabetic")) {
                    buffer.
                      append(
                        romanValue(
                          value).
                          toUpperCase(
                            ));
                }
                else {
                    int min =
                      (int)
                        c;
                    int max =
                      (int)
                        c;
                    if (c >=
                          945 &&
                          c <=
                          969) {
                        max =
                          969;
                    }
                    else {
                        while (java.lang.Character.
                                 isLetterOrDigit(
                                   (char)
                                     (max +
                                        1))) {
                            max++;
                        }
                    }
                    buffer.
                      append(
                        alphaValue(
                          value,
                          min,
                          max));
                }
    }
    private java.lang.String alphaValue(int value,
                                        int min,
                                        int max) {
        if (value <=
              0) {
            return "" +
            value;
        }
        int range =
          max -
          min +
          1;
        char last =
          (char)
            ((value -
                1) %
               range +
               min);
        if (value >
              range) {
            return alphaValue(
                     (value -
                        1) /
                       range,
                     min,
                     max) +
            last;
        }
        else {
            return "" +
            last;
        }
    }
    private java.lang.String romanValue(int n) {
        if (n <=
              0 ||
              n >
              4000) {
            return "" +
            n;
        }
        return Thousands[n /
                           1000] +
        Hundreds[n /
                   100 %
                   10] +
        Tens[n /
               10 %
               10] +
        Ones[n %
               10];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jSJsUokDvgcCzf66gyablh0BGFLNgh4b");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "o+wX0+33L59R5j/myb97Hh3+hRegw8WO5nYmhrt2WnXXeXX40yfq8C1Hd1nF" +
       "jtV8frnwWMHpj87g+8d58ofR7vX6a3Hx8RDpyy/U9z6SASd2bG/Y9ffisJWO" +
       "PNT/OIPt/8qTr2SzqWL7c+Xo5Z8jsv/9xSDb35Htvzhkb3DCZxjLxby/C/8n" +
       "o5hNMIp7EsVvnIdimqnGsb+5yF/Yf+iGP9bZ/hmM+oln7r3jwWek391uKz/8" +
       "w5Y7udIdRmzbx990PnZ+yQ90wyx431mk9xT7uS/efvp7+5rnRKVbsjRHe/HS" +
       "tvzlqPSKk8tHpduK7+Ol745K9+2Xzsvl38fL3ZcJ8qhcVLq0PTle5KUZlqxI" +
       "fvqyrfe5/l287evh6dbtPXRcc4qVjQeebzSOLUM8dt0u8eJvkA53dMfC7p2c" +
       "Tz7Ddt75tdpHt39bodrKZpO3cgdXun37DxpFo/mu8Fef2tphW5daT3zznk/d" +
       "+drDhY17toCPtPgYtled/AcRTcePir902Hz2wc98x8ee+f3iJfP/B6KWMcKf" +
       "SgAA");
}
