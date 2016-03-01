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
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "Tqr//Tz5/Vuo/h/creq3wBMeqn54b1T/");
        public static final java.lang.String jlc$ClassType$jl5$1 =
          ("wt5Nf/eYpYWdO3fxDmDP3Z8npZuDPXfubsHm8RHZIdjsnpvyTYHg0TtBfDxP" +
           "HroFxIfvFiICnk8eQvzkPefnXkV3/HzmTmCfy5OnbgH2B+4WbB4j+NOHYH/6" +
           "3oA9oaLnXr4TunKeXM/DI4zQ35xB99K9QPfGIbo37j26xp3Q5d/P5yo7g+af" +
           "5R38ftAlQemhkzG3Rwb7hTuG6gL/4akb/hlgF8AuffWtq5effGv2+7vt/yjI" +
           "/AGydFkNDeNkBNiJ/CXHU1StWJwHdvFgTgH240HpyVtQk8fBFJmc7HM/umvf" +
           "DUrXzrYHS1X8nmwHdrcr+3ZgqF3mZBMiKF0ATfLssOBuJdltUk+dFI7C3D92" +
           "p1U/cerw4im/q/jHi6NP+3D3rxevSl97a0j/xHvNL+1CZSVDzLJ8lMvARdpF" +
           "7R66SCeDrM6OdjTWpcHL33/klx946egc45EdwXtBPUHbczePS+2ZTlBEkma/" +
           "9uSvfOxvvfWHRfjO/wX9YvZWETMAAA==");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YOhWqZT05QbX8RmmOu9XVuVms6F3q4whu9OJ7rrjFdVSVqNBSeshHtFatfip" +
       "S/FOqWI463XLjWYhHLhoup7wlgl1zPocaXY9Xhx7dIt0R+t6q6ohyyGP8ahZ" +
       "BvPL27QTTiPYt4NeF1r4Y6HVqadRNShprFtOqBJlrPXeOpDcPjuckLVJj+3X" +
       "ytQIIQm3TCtUu+lBSXUpaN0RwY0Td2m0SAahQmrWEppmW+mkVKfIrt2OZ/iO" +
       "kPKG31vGsOsV2cQwtTk9bS8dbD0gGlHCDGcs7Je7wyozpceVkONpVVZX7QrR" +
       "HsaCNiuN1VY86/kbEvMGWmxvHJl0HGqp+RqLV7uEvFl3liuanMfBmrUVBoml" +
       "CA5DvRfTNhx32BZRWoapYxQ5JJnIfIJw7VWxLoYro1+bkkN9iK/WfdBjY46G" +
       "TjpcYuyMmlklblV1eq1ltb3Cx3S7nqYGK4cbNR6VvaAMYbWQLCO+Hrda8VgJ" +
       "m6hQi1UnQCDLZhNv7pW9YXFQoXlGbirlkavFjhlMucpQUIRas+hM2bHA2PoS" +
       "IskgmJIbmqhSLFovO7rXYmJJYZszeFxdDedkS+r7tXEr9uCZMUKnc5JuitJi" +
       "MofX7brWsqUBFltyN2jLUIsxSDvqpV4ZAh1ENExRqlEt6i6rDRCDd1gyHGNp" +
       "JxQ7iWdPy1N+iNkjKJKUVVqrRBVvPbBG4jDtO+VZG55yamsybIdoFSuzc9vT" +
       "Uswn7bhopmLHsNDViq0OFiij2uqASBf9dnM4gbm6OLJcDx6vloyKgKmBun1s" +
       "nSiBE9UkYpoM6q5AkI6g45FeBUstpjUhUZDhstdHuaS0stoNCF0IdbWscpYL" +
       "V2XLr8+wFt0ZJTJsVuN6hV8LMsJoejdIyLWhuIjYrMVmwta1SO5aVkTxGxpe" +
       "tZddRkpolPIrPc2DSwkRTa1yfZjy1Ya9qpqAtiGo4urlelJqJrA0t4ZaDXi/" +
       "VG6F1YaABnEHFfB5RDX63mxgkqRsUr3aqt2tw8FUt2ZQn402/lyK+HFEsk5X" +
       "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" +
       "J17yR/9jvnN8LC97k/Dkeee18rcIn/7g");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("iy8pg18u7x8++DWDwn2B4/6YqUaqeWrUB/L8C2ffrmYvAX/uUOKP7j7jPQHo" +
       "5u8Ptg94tyjvPIm+azshx29YM0XjinygONYBGgTeUcHBLc/8XKVsRbWD7cXN" +
       "nmTeO3ccU5XsXI5/vSPH3lnAHzl6E0EN8ERW3eyNQd7uN7Pk80HhYpyNAwa/" +
       "6TPTyNGVE4P5F7d6XHr6kfzNwG+Cz6cOwf+Hdx787PI3suQLWfJv86pfvjk+" +
       "2eVv5RW+kiX/AcxYDgSm6abiqTYAJLv/xRPlv/R6lc8s7z8dKv/lH5zlPXLa" +
       "8jDHstTtq6xTmHz1Vpj8aZb84Snj2MHij14vFgz4fPcQi+/+kLyQU5NdIP78" +
       "VkB8K0v+7Hwgvn4njOKvDoH4/h0E4kJe60J2+c0TpU80/8tbaf79LPmL8zX/" +
       "zh3QfI/dtt0b/OBM4PEz7tBGOXS8PR121hT27rkFIHuXsmTvXED29u8EIOtD" +
       "QNwfEj9kB+xv4Ie9R3d62D8Z57eOuimdt46BtbzjSa6myz7c3ll19h7Pksvn" +
       "g3jlDqwwe//4EMR/dOdBzGR8ww5aV18Fraz8TXmtt2XJ07dcZvaeeb0IvBto" +
       "/plDBD5zBxE45RBfyDXaPSF5g8dkxyT3isDicpXbjhxmtkaqkrI9uHdK63fe" +
       "Cef54qHWv/2Dc55HTzvPkUY79vCu12QP2Rvvvfr5ntC4E4j8x0NEvvRDQoRx" +
       "lPyc7w4i3deESHZAYg8/HxHidSDycHbzCYDEHx8i8se3gcjea3KKTq6EsFPh" +
       "1AGVPTFLxkDBLCaH/UDJm50oyL1eBbsA1Ivbttvv25nyt7/mKb+yO+VHBQ8e" +
       "bTa2e5cTA1DOhe1w7ldZcv38uX/f7UCTgP3g8W4qOwL++A0/0tr+sEj+7EuX" +
       "Lz720uS/bE8tHv345z66cHERmubpE7un8ve4nrrQc6Du257fdXMd1kHhsXMW" +
       "xewwbp7JZN1zt/WDQyRP1w8Kd+ffp+vFQeHSST3Q1TZzukoaFO4CVbLs+93j" +
       "aTo5eLM9uJxsd4WPn7agPJZ7+FboHjc5/RuD7MRa/iO5o9Nl4fZnctflz73U" +
       "Zd7/beSXt79xkE0pTbNeLtKFe7c/t8g7zU6oveXc3o76uod8/nsP/tp9bz3a" +
       "7D+4FfjEmk/J9vTNf0SAW26QH/tP/9Vj//xd//Slr+Ynj/4vxtOKrr04AAA=");
}
