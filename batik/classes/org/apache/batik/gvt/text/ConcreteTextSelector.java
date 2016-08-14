package org.apache.batik.gvt.text;
public class ConcreteTextSelector implements org.apache.batik.gvt.Selector {
    private java.util.ArrayList listeners;
    private org.apache.batik.gvt.GraphicsNode selectionNode;
    private org.apache.batik.gvt.RootGraphicsNode selectionNodeRoot;
    public ConcreteTextSelector() { super(); }
    public void mouseClicked(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseDragged(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseEntered(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseExited(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseMoved(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        
    }
    public void mousePressed(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void mouseReleased(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
        checkSelectGesture(
          evt);
    }
    public void keyPressed(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
        report(
          evt,
          "keyPressed");
    }
    public void keyReleased(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
        report(
          evt,
          "keyReleased");
    }
    public void keyTyped(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
        report(
          evt,
          "keyTyped");
    }
    public void changeStarted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent gnce) {
        
    }
    public void changeCompleted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent gnce) {
        if (selectionNode ==
              null) {
            return;
        }
        java.awt.Shape newShape =
          ((org.apache.batik.gvt.Selectable)
             selectionNode).
          getHighlightShape(
            );
        dispatchSelectionEvent(
          new org.apache.batik.gvt.event.SelectionEvent(
            getSelection(
              ),
            org.apache.batik.gvt.event.SelectionEvent.
              SELECTION_CHANGED,
            newShape));
    }
    public void setSelection(org.apache.batik.gvt.text.Mark begin,
                             org.apache.batik.gvt.text.Mark end) {
        org.apache.batik.gvt.TextNode node =
          begin.
          getTextNode(
            );
        if (node !=
              end.
              getTextNode(
                )) {
            throw new java.lang.Error(
              "Markers not from same TextNode");
        }
        node.
          setSelection(
            begin,
            end);
        selectionNode =
          node;
        selectionNodeRoot =
          node.
            getRoot(
              );
        java.lang.Object selection =
          getSelection(
            );
        java.awt.Shape shape =
          node.
          getHighlightShape(
            );
        dispatchSelectionEvent(
          new org.apache.batik.gvt.event.SelectionEvent(
            selection,
            org.apache.batik.gvt.event.SelectionEvent.
              SELECTION_DONE,
            shape));
    }
    public void clearSelection() { if (selectionNode ==
                                         null) {
                                       return;
                                   }
                                   dispatchSelectionEvent(
                                     new org.apache.batik.gvt.event.SelectionEvent(
                                       null,
                                       org.apache.batik.gvt.event.SelectionEvent.
                                         SELECTION_CLEARED,
                                       null));
                                   selectionNode =
                                     null;
                                   selectionNodeRoot =
                                     null;
    }
    protected void checkSelectGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        org.apache.batik.gvt.event.GraphicsNodeMouseEvent mevt =
          null;
        if (evt instanceof org.apache.batik.gvt.event.GraphicsNodeMouseEvent) {
            mevt =
              (org.apache.batik.gvt.event.GraphicsNodeMouseEvent)
                evt;
        }
        org.apache.batik.gvt.GraphicsNode source =
          evt.
          getGraphicsNode(
            );
        if (isDeselectGesture(
              evt)) {
            if (selectionNode !=
                  null) {
                selectionNodeRoot.
                  removeTreeGraphicsNodeChangeListener(
                    this);
            }
            clearSelection(
              );
        }
        else
            if (mevt !=
                  null) {
                java.awt.geom.Point2D p =
                  new java.awt.geom.Point2D.Double(
                  mevt.
                    getX(
                      ),
                  mevt.
                    getY(
                      ));
                java.awt.geom.AffineTransform t =
                  source.
                  getGlobalTransform(
                    );
                if (t ==
                      null) {
                    t =
                      new java.awt.geom.AffineTransform(
                        );
                }
                else {
                    try {
                        t =
                          t.
                            createInverse(
                              );
                    }
                    catch (java.awt.geom.NoninvertibleTransformException ni) {
                        
                    }
                }
                p =
                  t.
                    transform(
                      p,
                      null);
                if (source instanceof org.apache.batik.gvt.Selectable &&
                      isSelectStartGesture(
                        evt)) {
                    if (selectionNode !=
                          source) {
                        if (selectionNode !=
                              null) {
                            selectionNodeRoot.
                              removeTreeGraphicsNodeChangeListener(
                                this);
                        }
                        selectionNode =
                          source;
                        if (source !=
                              null) {
                            selectionNodeRoot =
                              source.
                                getRoot(
                                  );
                            selectionNodeRoot.
                              addTreeGraphicsNodeChangeListener(
                                this);
                        }
                    }
                    ((org.apache.batik.gvt.Selectable)
                       source).
                      selectAt(
                        p.
                          getX(
                            ),
                        p.
                          getY(
                            ));
                    dispatchSelectionEvent(
                      new org.apache.batik.gvt.event.SelectionEvent(
                        null,
                        org.apache.batik.gvt.event.SelectionEvent.
                          SELECTION_STARTED,
                        null));
                }
                else
                    if (isSelectEndGesture(
                          evt)) {
                        if (selectionNode ==
                              source) {
                            ((org.apache.batik.gvt.Selectable)
                               source).
                              selectTo(
                                p.
                                  getX(
                                    ),
                                p.
                                  getY(
                                    ));
                        }
                        java.lang.Object oldSelection =
                          getSelection(
                            );
                        if (selectionNode !=
                              null) {
                            java.awt.Shape newShape;
                            newShape =
                              ((org.apache.batik.gvt.Selectable)
                                 selectionNode).
                                getHighlightShape(
                                  );
                            dispatchSelectionEvent(
                              new org.apache.batik.gvt.event.SelectionEvent(
                                oldSelection,
                                org.apache.batik.gvt.event.SelectionEvent.
                                  SELECTION_DONE,
                                newShape));
                        }
                    }
                    else
                        if (isSelectContinueGesture(
                              evt)) {
                            if (selectionNode ==
                                  source) {
                                boolean result =
                                  ((org.apache.batik.gvt.Selectable)
                                     source).
                                  selectTo(
                                    p.
                                      getX(
                                        ),
                                    p.
                                      getY(
                                        ));
                                if (result) {
                                    java.awt.Shape newShape =
                                      ((org.apache.batik.gvt.Selectable)
                                         selectionNode).
                                      getHighlightShape(
                                        );
                                    dispatchSelectionEvent(
                                      new org.apache.batik.gvt.event.SelectionEvent(
                                        null,
                                        org.apache.batik.gvt.event.SelectionEvent.
                                          SELECTION_CHANGED,
                                        newShape));
                                }
                            }
                        }
                        else
                            if (source instanceof org.apache.batik.gvt.Selectable &&
                                  isSelectAllGesture(
                                    evt)) {
                                if (selectionNode !=
                                      source) {
                                    if (selectionNode !=
                                          null) {
                                        selectionNodeRoot.
                                          removeTreeGraphicsNodeChangeListener(
                                            this);
                                    }
                                    selectionNode =
                                      source;
                                    if (source !=
                                          null) {
                                        selectionNodeRoot =
                                          source.
                                            getRoot(
                                              );
                                        selectionNodeRoot.
                                          addTreeGraphicsNodeChangeListener(
                                            this);
                                    }
                                }
                                ((org.apache.batik.gvt.Selectable)
                                   source).
                                  selectAll(
                                    p.
                                      getX(
                                        ),
                                    p.
                                      getY(
                                        ));
                                java.lang.Object oldSelection =
                                  getSelection(
                                    );
                                java.awt.Shape newShape =
                                  ((org.apache.batik.gvt.Selectable)
                                     source).
                                  getHighlightShape(
                                    );
                                dispatchSelectionEvent(
                                  new org.apache.batik.gvt.event.SelectionEvent(
                                    oldSelection,
                                    org.apache.batik.gvt.event.SelectionEvent.
                                      SELECTION_DONE,
                                    newShape));
                            }
            }
    }
    private boolean isDeselectGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_CLICKED &&
          ((org.apache.batik.gvt.event.GraphicsNodeMouseEvent)
             evt).
          getClickCount(
            ) ==
          1;
    }
    private boolean isSelectStartGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_PRESSED;
    }
    private boolean isSelectEndGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_RELEASED;
    }
    private boolean isSelectContinueGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_DRAGGED;
    }
    private boolean isSelectAllGesture(org.apache.batik.gvt.event.GraphicsNodeEvent evt) {
        return evt.
          getID(
            ) ==
          org.apache.batik.gvt.event.GraphicsNodeMouseEvent.
            MOUSE_CLICKED &&
          ((org.apache.batik.gvt.event.GraphicsNodeMouseEvent)
             evt).
          getClickCount(
            ) ==
          2;
    }
    public java.lang.Object getSelection() {
        java.lang.Object value =
          null;
        if (selectionNode instanceof org.apache.batik.gvt.Selectable) {
            value =
              ((org.apache.batik.gvt.Selectable)
                 selectionNode).
                getSelection(
                  );
        }
        return value;
    }
    public boolean isEmpty() { return getSelection(
                                        ) ==
                                 null; }
    public void dispatchSelectionEvent(org.apache.batik.gvt.event.SelectionEvent e) {
        if (listeners !=
              null) {
            java.util.Iterator iter =
              listeners.
              iterator(
                );
            switch (e.
                      getID(
                        )) {
                case org.apache.batik.gvt.event.SelectionEvent.
                       SELECTION_DONE:
                    while (iter.
                             hasNext(
                               )) {
                        ((org.apache.batik.gvt.event.SelectionListener)
                           iter.
                           next(
                             )).
                          selectionDone(
                            e);
                    }
                    break;
                case org.apache.batik.gvt.event.SelectionEvent.
                       SELECTION_CHANGED:
                    while (iter.
                             hasNext(
                               )) {
                        ((org.apache.batik.gvt.event.SelectionListener)
                           iter.
                           next(
                             )).
                          selectionChanged(
                            e);
                    }
                    break;
                case org.apache.batik.gvt.event.SelectionEvent.
                       SELECTION_CLEARED:
                    while (iter.
                             hasNext(
                               )) {
                        ((org.apache.batik.gvt.event.SelectionListener)
                           iter.
                           next(
                             )).
                          selectionCleared(
                            e);
                    }
                    break;
                case org.apache.batik.gvt.event.SelectionEvent.
                       SELECTION_STARTED:
                    while (iter.
                             hasNext(
                               )) {
                        ((org.apache.batik.gvt.event.SelectionListener)
                           iter.
                           next(
                             )).
                          selectionStarted(
                            e);
                    }
                    break;
            }
        }
    }
    public void addSelectionListener(org.apache.batik.gvt.event.SelectionListener l) {
        if (listeners ==
              null) {
            listeners =
              new java.util.ArrayList(
                );
        }
        listeners.
          add(
            l);
    }
    public void removeSelectionListener(org.apache.batik.gvt.event.SelectionListener l) {
        if (listeners !=
              null) {
            listeners.
              remove(
                l);
        }
    }
    private void report(org.apache.batik.gvt.event.GraphicsNodeEvent evt,
                        java.lang.String message) {
        org.apache.batik.gvt.GraphicsNode source =
          evt.
          getGraphicsNode(
            );
        java.lang.String label =
          "(non-text node)";
        if (source instanceof org.apache.batik.gvt.TextNode) {
            char[] cbuff;
            java.text.CharacterIterator iter =
              ((org.apache.batik.gvt.TextNode)
                 source).
              getAttributedCharacterIterator(
                );
            cbuff =
              (new char[iter.
                          getEndIndex(
                            )]);
            if (cbuff.
                  length >
                  0)
                cbuff[0] =
                  iter.
                    first(
                      );
            for (int i =
                   1;
                 i <
                   cbuff.
                     length;
                 ++i) {
                cbuff[i] =
                  iter.
                    next(
                      );
            }
            label =
              new java.lang.String(
                cbuff);
        }
        java.lang.System.
          out.
          println(
            "Mouse " +
            message +
            " in " +
            label);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/74jMoW/4lvjfwAp8Uil0jcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "c4SKm6LGmxt40SE5pLZqc6lMDb25moi9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/s9e8k9e/+lPfH17SOb/AYDTeO2hQgAA");
}
