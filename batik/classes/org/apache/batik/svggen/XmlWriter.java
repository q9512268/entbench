package org.apache.batik.svggen;
class XmlWriter implements org.apache.batik.util.SVGConstants {
    private static java.lang.String EOL;
    private static final java.lang.String TAG_END = "/>";
    private static final java.lang.String TAG_START = "</";
    private static final char[] SPACES = { ' ', ' ', ' ', ' ', ' ', ' ', ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ',
    ' ' };
    private static final int SPACES_LEN = SPACES.length;
    static { java.lang.String temp;
             try { temp = java.lang.System.getProperty("line.separator", "\n");
             }
             catch (java.lang.SecurityException e) {
                 temp =
                   "\n";
             }
             EOL = temp; }
    static class IndentWriter extends java.io.Writer {
        protected java.io.Writer proxied;
        protected int indentLevel;
        protected int column;
        public IndentWriter(java.io.Writer proxied) { super();
                                                      if (proxied == null)
                                                          throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                            org.apache.batik.svggen.ErrorConstants.
                                                              ERR_PROXY);
                                                      this.
                                                        proxied =
                                                        proxied;
        }
        public void setIndentLevel(int indentLevel) { this.
                                                        indentLevel =
                                                        indentLevel;
        }
        public int getIndentLevel() { return indentLevel;
        }
        public void printIndent() throws java.io.IOException {
            proxied.
              write(
                EOL);
            int temp =
              indentLevel;
            while (temp >
                     0) {
                if (temp >
                      SPACES_LEN) {
                    proxied.
                      write(
                        SPACES,
                        0,
                        SPACES_LEN);
                    temp -=
                      SPACES_LEN;
                }
                else {
                    proxied.
                      write(
                        SPACES,
                        0,
                        temp);
                    break;
                }
            }
            column =
              indentLevel;
        }
        public java.io.Writer getProxied() { return proxied;
        }
        public int getColumn() { return column; }
        public void write(int c) throws java.io.IOException {
            column++;
            proxied.
              write(
                c);
        }
        public void write(char[] cbuf) throws java.io.IOException {
            column +=
              cbuf.
                length;
            proxied.
              write(
                cbuf);
        }
        public void write(char[] cbuf, int off, int len) throws java.io.IOException {
            column +=
              len;
            proxied.
              write(
                cbuf,
                off,
                len);
        }
        public void write(java.lang.String str) throws java.io.IOException {
            column +=
              str.
                length(
                  );
            proxied.
              write(
                str);
        }
        public void write(java.lang.String str, int off,
                          int len) throws java.io.IOException {
            column +=
              len;
            proxied.
              write(
                str,
                off,
                len);
        }
        public void flush() throws java.io.IOException {
            proxied.
              flush(
                );
        }
        public void close() throws java.io.IOException {
            column =
              -1;
            proxied.
              close(
                );
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "9mQW2Uu38zb/5RZ13y2y94AZagVdexi3");
        public static final java.lang.String jlc$ClassType$jl5$1 =
          ("aP4/sv33v7mdeX+vyH7/Jub9B3dq3m2QkgPzTu6Oed9zvBV/90ikpS87d99t" +
           "wJ67v8gqNwZ77tydgi1iKPIDsPldd9dmieDR20F8vMgeugnEh+8UYgukTx5A" +
           "/ORdl+exie7l+cztwD5XZE/dBOz33SnYIo7wpw7A/tTdAXvCRM+9fDt01SK7" +
           "WoRQOElknkH30t1A98YBujfuPrrG7dAV78jnanuHFp2VHfx+0GVx5aGTcbmH" +
           "DvuF24bzgj3CU9f9KWAfyK595a3LF598a/r7+yX+MNj8AaZycZk4zskosRPP" +
           "F4LQWFolcx7Yx4wFJdiPx5Unb0JNEStTPhRkn/uRffteXLlytj1gVfl9sh1Y" +
           "3S4dtwND7R9ONhnElXtAk+KRLqVby/aL1FMnlaN094/djusnThZePLW3Kv+A" +
           "cfj6nuz/gvGq9tW36NGPv9f84j6cVnPUPC9GuQi2QfvI3oNt0MlArLOjHY51" +
           "of/y9x755QdeOjyreGRP8LGinqDtuRvHrhJuEJfRpvmvPfkrH/ubb/1hGeLz" +
           "fwFKdMLgGTMAAA==");
    }
    private static void writeXml(org.w3c.dom.Attr attr,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { java.lang.String name =
                                         attr.
                                         getName(
                                           );
                                       out.
                                         write(
                                           name);
                                       out.
                                         write(
                                           "=\"");
                                       writeChildrenXml(
                                         attr,
                                         out,
                                         escaped);
                                       out.
                                         write(
                                           '\"');
    }
    private static void writeChildrenXml(org.w3c.dom.Attr attr,
                                         org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                         boolean escaped)
          throws java.io.IOException { char[] data =
                                         attr.
                                         getValue(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null)
                                           return;
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           switch (c) {
                                               case '<':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&lt;");
                                                   break;
                                               case '>':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&gt;");
                                                   break;
                                               case '&':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&amp;");
                                                   break;
                                               case '\'':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&apos;");
                                                   break;
                                               case '\"':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&quot;");
                                                   break;
                                               default:
                                                   if (escaped &&
                                                         c >
                                                         127) {
                                                       out.
                                                         write(
                                                           data,
                                                           start,
                                                           last -
                                                             start);
                                                       java.lang.String hex =
                                                         "0000" +
                                                       java.lang.Integer.
                                                         toHexString(
                                                           c);
                                                       out.
                                                         write(
                                                           "&#x" +
                                                           hex.
                                                             substring(
                                                               hex.
                                                                 length(
                                                                   ) -
                                                                 4) +
                                                           ";");
                                                       start =
                                                         last +
                                                           1;
                                                   }
                                                   break;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
    }
    private static void writeXml(org.w3c.dom.Comment comment,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         comment.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           out.
                                             write(
                                               "<!---->");
                                           return;
                                       }
                                       out.
                                         write(
                                           "<!--");
                                       boolean sawDash =
                                         false;
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           if (c ==
                                                 '-') {
                                               if (sawDash) {
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last;
                                                   out.
                                                     write(
                                                       ' ');
                                               }
                                               sawDash =
                                                 true;
                                           }
                                           else {
                                               sawDash =
                                                 false;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
                                       if (sawDash)
                                           out.
                                             write(
                                               ' ');
                                       out.
                                         write(
                                           "-->");
    }
    private static void writeXml(org.w3c.dom.Text text,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { writeXml(
                                         text,
                                         out,
                                         false,
                                         escaped);
    }
    private static void writeXml(org.w3c.dom.Text text,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean trimWS,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         text.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "Null text data??");
                                           return;
                                       }
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       if (trimWS) {
                                           while (last <
                                                    length) {
                                               char c =
                                                 data[last];
                                               switch (c) {
                                                   case ' ':
                                                   case '\t':
                                                   case '\n':
                                                   case '\r':
                                                       last++;
                                                       continue;
                                                   default:
                                                       break;
                                               }
                                               break;
                                           }
                                           start =
                                             last;
                                       }
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           switch (c) {
                                               case ' ':
                                               case '\t':
                                               case '\n':
                                               case '\r':
                                                   if (trimWS) {
                                                       int wsStart =
                                                         last;
                                                       last++;
                                                       while (last <
                                                                length) {
                                                           switch (data[last]) {
                                                               case ' ':
                                                               case '\t':
                                                               case '\n':
                                                               case '\r':
                                                                   last++;
                                                                   continue;
                                                               default:
                                                                   break;
                                                           }
                                                           break;
                                                       }
                                                       if (last ==
                                                             length) {
                                                           out.
                                                             write(
                                                               data,
                                                               start,
                                                               wsStart -
                                                                 start);
                                                           return;
                                                       }
                                                       else {
                                                           continue;
                                                       }
                                                   }
                                                   break;
                                               case '<':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&lt;");
                                                   break;
                                               case '>':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&gt;");
                                                   break;
                                               case '&':
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "&amp;");
                                                   break;
                                               default:
                                                   if (escaped &&
                                                         c >
                                                         127) {
                                                       out.
                                                         write(
                                                           data,
                                                           start,
                                                           last -
                                                             start);
                                                       java.lang.String hex =
                                                         "0000" +
                                                       java.lang.Integer.
                                                         toHexString(
                                                           c);
                                                       out.
                                                         write(
                                                           "&#x" +
                                                           hex.
                                                             substring(
                                                               hex.
                                                                 length(
                                                                   ) -
                                                                 4) +
                                                           ";");
                                                       start =
                                                         last +
                                                           1;
                                                   }
                                                   break;
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
    }
    private static void writeXml(org.w3c.dom.CDATASection cdataSection,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException { char[] data =
                                         cdataSection.
                                         getData(
                                           ).
                                         toCharArray(
                                           );
                                       if (data ==
                                             null) {
                                           out.
                                             write(
                                               "<![CDATA[]]>");
                                           return;
                                       }
                                       out.
                                         write(
                                           "<![CDATA[");
                                       int length =
                                         data.
                                           length;
                                       int start =
                                         0;
                                       int last =
                                         0;
                                       while (last <
                                                length) {
                                           char c =
                                             data[last];
                                           if (c ==
                                                 ']') {
                                               if (last +
                                                     2 <
                                                     data.
                                                       length &&
                                                     data[last +
                                                            1] ==
                                                     ']' &&
                                                     data[last +
                                                            2] ==
                                                     '>') {
                                                   out.
                                                     write(
                                                       data,
                                                       start,
                                                       last -
                                                         start);
                                                   start =
                                                     last +
                                                       1;
                                                   out.
                                                     write(
                                                       "]]]]><![CDATA[>");
                                                   continue;
                                               }
                                           }
                                           last++;
                                       }
                                       out.
                                         write(
                                           data,
                                           start,
                                           last -
                                             start);
                                       out.
                                         write(
                                           "]]>");
    }
    private static void writeXml(org.w3c.dom.Element element,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        out.
          write(
            TAG_START,
            0,
            1);
        out.
          write(
            element.
              getTagName(
                ));
        org.w3c.dom.NamedNodeMap attributes =
          element.
          getAttributes(
            );
        if (attributes !=
              null) {
            int nAttr =
              attributes.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   nAttr;
                 i++) {
                org.w3c.dom.Attr attr =
                  (org.w3c.dom.Attr)
                    attributes.
                    item(
                      i);
                out.
                  write(
                    ' ');
                writeXml(
                  attr,
                  out,
                  escaped);
            }
        }
        boolean lastElem =
          element.
          getParentNode(
            ).
          getLastChild(
            ) ==
          element;
        if (!element.
              hasChildNodes(
                )) {
            if (lastElem)
                out.
                  setIndentLevel(
                    out.
                      getIndentLevel(
                        ) -
                      2);
            out.
              printIndent(
                );
            out.
              write(
                TAG_END,
                0,
                2);
            return;
        }
        org.w3c.dom.Node child =
          element.
          getFirstChild(
            );
        out.
          printIndent(
            );
        out.
          write(
            TAG_END,
            1,
            1);
        if (child.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                TEXT_NODE ||
              element.
              getLastChild(
                ) !=
              child) {
            out.
              setIndentLevel(
                out.
                  getIndentLevel(
                    ) +
                  2);
        }
        writeChildrenXml(
          element,
          out,
          escaped);
        out.
          write(
            TAG_START,
            0,
            2);
        out.
          write(
            element.
              getTagName(
                ));
        if (lastElem)
            out.
              setIndentLevel(
                out.
                  getIndentLevel(
                    ) -
                  2);
        out.
          printIndent(
            );
        out.
          write(
            TAG_END,
            1,
            1);
    }
    private static void writeChildrenXml(org.w3c.dom.Element element,
                                         org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                         boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        org.w3c.dom.Node child =
          element.
          getFirstChild(
            );
        while (child !=
                 null) {
            writeXml(
              child,
              out,
              escaped);
            child =
              child.
                getNextSibling(
                  );
        }
    }
    private static void writeDocumentHeader(org.apache.batik.svggen.XmlWriter.IndentWriter out)
          throws java.io.IOException { java.lang.String encoding =
                                         null;
                                       if (out.
                                             getProxied(
                                               ) instanceof java.io.OutputStreamWriter) {
                                           java.io.OutputStreamWriter osw =
                                             (java.io.OutputStreamWriter)
                                               out.
                                               getProxied(
                                                 );
                                           encoding =
                                             java2std(
                                               osw.
                                                 getEncoding(
                                                   ));
                                       }
                                       out.
                                         write(
                                           "<?xml version=\"1.0\"");
                                       if (encoding !=
                                             null) {
                                           out.
                                             write(
                                               " encoding=\"");
                                           out.
                                             write(
                                               encoding);
                                           out.
                                             write(
                                               '\"');
                                       }
                                       out.
                                         write(
                                           "?>");
                                       out.
                                         write(
                                           EOL);
                                       out.
                                         write(
                                           "<!DOCTYPE svg PUBLIC \'");
                                       out.
                                         write(
                                           SVG_PUBLIC_ID);
                                       out.
                                         write(
                                           "\'");
                                       out.
                                         write(
                                           EOL);
                                       out.
                                         write(
                                           "          \'");
                                       out.
                                         write(
                                           SVG_SYSTEM_ID);
                                       out.
                                         write(
                                           "\'");
                                       out.
                                         write(
                                           ">");
                                       out.
                                         write(
                                           EOL);
    }
    private static void writeXml(org.w3c.dom.Document document,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        writeDocumentHeader(
          out);
        org.w3c.dom.NodeList childList =
          document.
          getChildNodes(
            );
        writeXml(
          childList,
          out,
          escaped);
    }
    private static void writeXml(org.w3c.dom.NodeList childList,
                                 org.apache.batik.svggen.XmlWriter.IndentWriter out,
                                 boolean escaped)
          throws java.io.IOException,
        org.apache.batik.svggen.SVGGraphics2DIOException {
        int length =
          childList.
          getLength(
            );
        if (length ==
              0)
            return;
        for (int i =
               0;
             i <
               length;
             i++) {
            org.w3c.dom.Node child =
              childList.
              item(
                i);
            writeXml(
              child,
              out,
              escaped);
            out.
              write(
                EOL);
        }
    }
    static java.lang.String java2std(java.lang.String encodingName) {
        if (encodingName ==
              null)
            return null;
        if (encodingName.
              startsWith(
                "ISO8859_"))
            return "ISO-8859-" +
            encodingName.
              substring(
                8);
        if (encodingName.
              startsWith(
                "8859_"))
            return "ISO-8859-" +
            encodingName.
              substring(
                5);
        if ("ASCII7".
              equalsIgnoreCase(
                encodingName) ||
              "ASCII".
              equalsIgnoreCase(
                encodingName))
            return "US-ASCII";
        if ("UTF8".
              equalsIgnoreCase(
                encodingName))
            return "UTF-8";
        if (encodingName.
              startsWith(
                "Unicode"))
            return "UTF-16";
        if ("SJIS".
              equalsIgnoreCase(
                encodingName))
            return "Shift_JIS";
        if ("JIS".
              equalsIgnoreCase(
                encodingName))
            return "ISO-2022-JP";
        if ("EUCJIS".
              equalsIgnoreCase(
                encodingName))
            return "EUC-JP";
        return "UTF-8";
    }
    public static void writeXml(org.w3c.dom.Node node,
                                java.io.Writer writer,
                                boolean escaped)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            org.apache.batik.svggen.XmlWriter.IndentWriter out =
              null;
            if (writer instanceof org.apache.batik.svggen.XmlWriter.IndentWriter)
                out =
                  (org.apache.batik.svggen.XmlWriter.IndentWriter)
                    writer;
            else
                out =
                  new org.apache.batik.svggen.XmlWriter.IndentWriter(
                    writer);
            switch (node.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ATTRIBUTE_NODE:
                    writeXml(
                      (org.w3c.dom.Attr)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       COMMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Comment)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       TEXT_NODE:
                    writeXml(
                      (org.w3c.dom.Text)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       CDATA_SECTION_NODE:
                    writeXml(
                      (org.w3c.dom.CDATASection)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       DOCUMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Document)
                        node,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       DOCUMENT_FRAGMENT_NODE:
                    writeDocumentHeader(
                      out);
                    org.w3c.dom.NodeList childList =
                      node.
                      getChildNodes(
                        );
                    writeXml(
                      childList,
                      out,
                      escaped);
                    break;
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    writeXml(
                      (org.w3c.dom.Element)
                        node,
                      out,
                      escaped);
                    break;
                default:
                    throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                      org.apache.batik.svggen.ErrorConstants.
                        INVALID_NODE +
                      node.
                        getClass(
                          ).
                        getName(
                          ));
            }
        }
        catch (java.io.IOException io) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              io);
        }
    }
    public XmlWriter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HAKcTVqMvZP1wdn9qeBcj8W6YDjFEYAT8xcyGZh+2Wb+5SHAKWRDsmgAYsGm" +
       "egVDoM83wHPjIrBCB3TwyLjQtGJsmovOxpFCZxVIqpDT5P+Homw3Z4No3AAU" +
       "h5B6o7I5HWOdgzQ/ubuqd1Mg5rbW4Q6F64K1butw4Jq0yKjUHQO+uq7I+JaQ" +
       "f/8m3bevpHDSvitf4O8JnG/UxkRJYXdCUbwvVz31fN2g3TITxhj+qlVnvO20" +
       "yKSA1ATfm7IKblm4lY/fbSPsHW+RPPbfO26PRYrccUCKV7xD7rRIDgzB6l49" +
       "JT73hpm/Y07ym5ApXvjYEWjCYKinpng/TMFLX/Ytp3NBm+Bfc3ZKR/atarr2" +
       "zEX38A9jJEXczO5SRkdJAf/8hhHFS96ZgdQcWvkr554de/+o2c49WdqHOd69" +
       "MdljTooSn+z7ZMSsTn058uL+JY/8Znv+qRAR1hJBhFC9NvNtfFJPGGTa2mjm" +
       "G4p20WDfstTM/e6mpfO7//US+96B8Pv4qcHjO6XnDlz97M6K/ZUhMrqR5Mlq" +
       "jCbZZwL1m9Q1VOozOkixbDYkYYtARRaVtNcfY1E5RXxhznCx4SxOteIXUxap" +
       "ynz1k/mdWZGi9VNjmZZQmVcrjpLRbguXjO+ePKHrvgluiy1KLL+GxflJlAbo" +
       "Y2d0ta473x0Vva8z47wpmztm17jCEVbF2v3/BdCCcnjnLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+tStPVZ7oHpaeHxI6//jOWF64wEPyx+o");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nfq76JzEqXfJB0cP1Z+67kRM9dqA4UbHR/PKtxBvuejMVvUG4lMffP4FZf7L" +
       "zUuHD42tsHZ36Hp/1VJj1To16uur/HNn376WLwl/7pDjj55/PnwC0I3fPewf" +
       "Du9RPvcU+7b9hBy/gS0FTVryVcW1r8Jh6B9VXL3pmaArE0dRnXB/c6OnoHdJ" +
       "rmupolPx8W/O8XFwFvCHjt5iTObDVFa98m1D1e43yuRzYe1yUo5TDH7D562x" +
       "qysnCvMvb/ao9fTj/BuB3y+uTx6C/w9ee/DL218vk8+Xyb+rSL90Y3zK29+s" +
       "CL5cJv+xmLEKCHSrW4qvOgUgZfkXToT/4qsVvtS8/3wo/Jd+cJr30GnNQ13b" +
       "VvevwU5h8pWbYfLHZfIHp5TjHBZ/+GqxIIvru4dYfPeHZIWsmp4H4k9vBsS3" +
       "yuRPLgbi66+FUvzFIRDffw2BuL2iur28/eaJ0CeS//nNJP9+mfzZxZJ/5zWQ" +
       "/IDatz2Y/+BU4NEz5jCAWZjZnx47qwoHd94EkIN7yuTgQkAOLr0WgOwOAfF+" +
       "SP6hPGR/nX84ePhcD5dOxvnNo24aF61jxVo+8kVvq8sBODi36hw8Wib3XQzi" +
       "/a/BCnPwjw5B/IevPYglj284h9aVl0GrrH9TRfX2MnnipsvMwZOvFoEfKyT/" +
       "9CECn34NEThlEJ+vJDp/gvI6iymPUR7UC42rRB64clTq2lgVlf3BvlNSv+u1" +
       "MJ4vHEr9Wz8443n4tPEcSXROH979ivThvWXSu9gSoNcCkf90iMgXf0iIkK5S" +
       "nQM+h8j0FSFSHq44GF6MCPYqEHmwLHysQOKPDhH5o1tA5OAVGcWoEmJ9juDU" +
       "4ZYDoUyYQsAyJgeDUKmanQjIvloBpwWol/dt97+3MuXveMVTfv/5KT+quPdo" +
       "s7Hfu5wogHIhbIdzb5TJtYvn/n23Ak1a7AePd1PlEfFHr/tQa/9xkfyZF+67" +
       "/MgLy/+6P9V49AHQ3UTtshZZ1ukTvafyd3q+qukVUHfvz/d6lQy7sPbIBYti" +
       "eVi3ypS8Hnh7+vAQydP0Ye2O6vc0XRLW7jmhK7raZ06T5GHttoKkzL7fO56m" +
       "k0M7+4PN6X5X+OhpDapiuQdvhu5xk9PfIJSn3aoP5Y5OpkX7T+WuyZ99YUq+" +
       "/9vdX95/AyFbYp6XvVwmanftP8eoOi1Pt731wt6O+rpz/Mz37v3Vu992tNm/" +
       "d8/wiTaf4u2JG39kMLS9sPosIP/Xj/zau//JC1+pTi39P3FnNIvBOAAA");
}
