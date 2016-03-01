package org.apache.batik.util.gui.xmleditor;
public class XMLView extends javax.swing.text.PlainView {
    protected org.apache.batik.util.gui.xmleditor.XMLContext context = null;
    protected org.apache.batik.util.gui.xmleditor.XMLScanner lexer = new org.apache.batik.util.gui.xmleditor.XMLScanner(
      );
    protected int tabSize = 4;
    public XMLView(org.apache.batik.util.gui.xmleditor.XMLContext context,
                   javax.swing.text.Element elem) { super(elem);
                                                    this.context =
                                                      context; }
    public int getTabSize() { return tabSize; }
    protected int drawUnselectedText(java.awt.Graphics g, int x, int y,
                                     int p0,
                                     int p1) throws javax.swing.text.BadLocationException {
        org.apache.batik.util.gui.xmleditor.XMLDocument doc =
          (org.apache.batik.util.gui.xmleditor.XMLDocument)
            getDocument(
              );
        org.apache.batik.util.gui.xmleditor.XMLToken token =
          doc.
          getScannerStart(
            p0);
        java.lang.String str =
          doc.
          getText(
            token.
              getStartOffset(
                ),
            p1 -
              token.
              getStartOffset(
                ) +
              1);
        lexer.
          setString(
            str);
        lexer.
          reset(
            );
        int pos =
          token.
          getStartOffset(
            );
        int ctx =
          token.
          getContext(
            );
        int lastCtx =
          ctx;
        while (pos <
                 p0) {
            pos =
              lexer.
                scan(
                  ctx) +
                token.
                getStartOffset(
                  );
            lastCtx =
              ctx;
            ctx =
              lexer.
                getScanValue(
                  );
        }
        int mark =
          p0;
        while (pos <
                 p1) {
            if (lastCtx !=
                  ctx) {
                g.
                  setColor(
                    context.
                      getSyntaxForeground(
                        lastCtx));
                g.
                  setFont(
                    context.
                      getSyntaxFont(
                        lastCtx));
                javax.swing.text.Segment text =
                  getLineBuffer(
                    );
                doc.
                  getText(
                    mark,
                    pos -
                      mark,
                    text);
                x =
                  javax.swing.text.Utilities.
                    drawTabbedText(
                      text,
                      x,
                      y,
                      g,
                      this,
                      mark);
                mark =
                  pos;
            }
            pos =
              lexer.
                scan(
                  ctx) +
                token.
                getStartOffset(
                  );
            lastCtx =
              ctx;
            ctx =
              lexer.
                getScanValue(
                  );
        }
        g.
          setColor(
            context.
              getSyntaxForeground(
                lastCtx));
        g.
          setFont(
            context.
              getSyntaxFont(
                lastCtx));
        javax.swing.text.Segment text =
          getLineBuffer(
            );
        doc.
          getText(
            mark,
            p1 -
              mark,
            text);
        x =
          javax.swing.text.Utilities.
            drawTabbedText(
              text,
              x,
              y,
              g,
              this,
              mark);
        return x;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
