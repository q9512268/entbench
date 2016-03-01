package org.apache.batik.util.gui.xmleditor;
public class XMLTextEditor extends javax.swing.JEditorPane {
    protected javax.swing.undo.UndoManager undoManager;
    public XMLTextEditor() { super();
                             org.apache.batik.util.gui.xmleditor.XMLEditorKit kit =
                               new org.apache.batik.util.gui.xmleditor.XMLEditorKit(
                               );
                             setEditorKitForContentType(org.apache.batik.util.gui.xmleditor.XMLEditorKit.
                                                          XML_MIME_TYPE,
                                                        kit);
                             setContentType(org.apache.batik.util.gui.xmleditor.XMLEditorKit.
                                              XML_MIME_TYPE);
                             setBackground(
                               java.awt.Color.
                                 white);
                             undoManager =
                               new javax.swing.undo.UndoManager(
                                 );
                             javax.swing.event.UndoableEditListener undoableEditHandler =
                               new javax.swing.event.UndoableEditListener(
                               ) {
                                 public void undoableEditHappened(javax.swing.event.UndoableEditEvent e) {
                                     undoManager.
                                       addEdit(
                                         e.
                                           getEdit(
                                             ));
                                 }
                             };
                             getDocument(
                               ).addUndoableEditListener(
                                   undoableEditHandler);
    }
    public void setText(java.lang.String t) {
        super.
          setText(
            t);
        undoManager.
          discardAllEdits(
            );
    }
    public void undo() { try { undoManager.
                                 undo(
                                   ); }
                         catch (javax.swing.undo.CannotUndoException ex) {
                             
                         } }
    public void redo() { try { undoManager.
                                 redo(
                                   ); }
                         catch (javax.swing.undo.CannotRedoException ex) {
                             
                         } }
    public void gotoLine(int line) { javax.swing.text.Element element =
                                       getDocument(
                                         ).
                                       getDefaultRootElement(
                                         ).
                                       getElement(
                                         line);
                                     if (element ==
                                           null) {
                                         return;
                                     }
                                     int pos =
                                       element.
                                       getStartOffset(
                                         );
                                     setCaretPosition(
                                       pos);
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
       "4TUexSQAAA==");
}
