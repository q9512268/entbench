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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Z+PuUv7gtesPPHbo5korlk8J9l8+vdH/Wa70bHn7sxySuefKk2f49Luju28Y" +
       "03bG+1zfdSGofWw6N8KAk3V1T7or+UmkqeLJCKnsJvWSnfmuEpUULsxuyPZM" +
       "Jx2G7DirPDtzs9KU1oyLPNrvvjzd+p2XG9ngHmvjfa3PXw3DWZwI1wx7Kc/w" +
       "+yuB8JtFXGUyl1NQTHfcQ6VuyLBDoj7/MDSkUUaqcaljPmSiAXltAHdWXake" +
       "k60Q1/N8MS79pOmSzcdVHpxlmcDEvLU9qeXMQ7PqJt51h2pVb87feHZS+fYF" +
       "+27S/vF+xEkY86lYNZeaHc89tPidOPfQVRiYVzrUekLuPKPPEx7qM8xMd7zl" +
       "nTYzd1rp2dqS5krQCOyg5CQk/dGVcpImcAdHVeZkZt9ib+i0xuYscXdq73/o" +
       "ttlbp3/3Jov4YwJWt1v/wbPf2r9z457dVrxA+hmZFrQLzd36YvowKSQFco3o" +
       "k0Wn7X3vwKrzIraHH46iy7Lx0SxvDMGi1RkPKWRSvka/OVk9VMzY+flFl768" +
       "HHKUdlKVUuV1KdqeyF63lWaqx2Nf7qbLXcu2cX0NPwJc/8ULjQofWMbV0GZv" +
       "QCZmdiC6nsZyRoSpcGulJChno1hsoTwtMADMy3Yfx8F1km3PJwW4Dytbmoxi" +
       "Sa6fCNJmpNakdkBZBsQ57B+TN01fZIh6vyyZWNMHqbdISLhrmmkPamYAJDUU" +
       "UpA2A+frhbRC05gDa1JeWFgjBJoWAi3tDnFqZoj8p4L4toje7M2N0IIztHF5" +
       "h+bsg3CVjwva6/P3FLds2bErsfzWGdY6b8jePy9QU8m7X/zqzy3XvvVMnk1Z" +
       "NdP0ExQ6SBXPyMaY6C78jqWDvwpxA/Hs5w+VvXbV6GG52yhsaXzAJmlqsIfw" +
       "d/DUln+PWXlG/5oi9kcTfET5m7yzY/cziyZLV0X42xwr7ue8BcpWas32GjWw" +
       "T00ZarafaMreo3zHvpz7PHuUPLaTyfyDVH05spBtRTPyWhHMrJq9eju0lEkX" +
       "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" +
       "xcT/B32yHHunNQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ory4GaCbFBsq8AbK4naDjHpCf5ZZKMNNCV3h6vM4o9od18RgujNZz2aSr0iW" +
       "ydoToyVYUYtQeUFaa+s6wqEw06AnWBM4+iRX1DnhpZatdLoJNWv6mkBzGOuT" +
       "UQ1dlb253MB0jRAnkL7oQWVsAic9KO2uF426tWBETSKURjNiDXXE6tx8bCzm" +
       "eTDT1lTMDlm2m2I+3UhpFcstZ7rIVTTwyqo/qa0DDh9lyxrOrWG1P1e8ga20" +
       "VGKuiWsxahoyZCBpvAgVQfWxCuxGkSV7FbhCukl1sSH5CE3gjczq5aCZV2uY" +
       "Og/SFrSyxV7AUblaqS8SdzOccD3FrbhrhHcwoZJshkE+CMBkrFo3MoxKkUma" +
       "dOi+gY7X7JAfT5K1BI/m6+aczheQbvUsrN4giOFMtYbzWTxHh6qvZb16xeIl" +
       "Py0zOubLlKDEZUVAGHZDKnBjRpkcMANaniN9MeFwMJkz8LoTitnYnXhKP7ZI" +
       "fOW46Cp0p5uIbnXorLLQ00YPXdsVltzw1Q5I4rabGhOpruMMaXuMtFbXbRHk" +
       "5hrWhqYMguriYFVPskzkGZrwZXUwoVaBba9ZyV60yM5sNvNa5RakByt5jCO1" +
       "ZUdCSY3vLc026fItoxJ1nJ4vumbDq1LVyDU1jC4zyGCQR0SvtoLkcFnB5+Ym" +
       "keowW+lRaliWu0Go53xfXdTlhqmxWZObNWxMgHM/zypCksxpZ42KjMoi3ZSr" +
       "T9oCm9HSoo5jDdPnO8nGS1swEdY20DwR5Hm936+Vs1UoCXmLtC0/HOgbFe7M" +
       "LAdiecHqwzXXaK6Vqd6d1mwsyxewkhuZSM0RoVpONwEWa4224vFSWCn3TX4z" +
       "RUCCCyRdogPNreRE4uUYS8QzlpKmmZ515gRSC712NJ6yGb8i6ID0m5oZI1Z3" +
       "LVT7NGTRUYeOmxGIY6sR2V8iGxnr0cYwV9vdUB21FrSw5tSQHecKmnSszQaL" +
       "Knxd9vKN17Q0hydEFa7IZLQq8zZqxPVFhdXWjoUGjIpYftQPJ2KkLRnVserV" +
       "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" +
       "dqWcEUTsMFyrVWwD/uwL24m9b7vpfOmQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jWlhxQPjBexA7h49VpAnLm3qb//dUjpxMOP4K9uj93gHhxvcrzh1h/7w9EGx" +
       "9/qKq52w2e67fvJdT39CHX0KPXxBk0Wl2yPX+3FLSzTr2IAPgZ5ed/U9Znp7" +
       "wOjo7d0X3vUnD03fuHrrCziT8MgJPk92+cv0M1/qv1r54LnSTZfe5V1x9Ony" +
       "Rk9e/gbvjkCL4sCZXvYe7xWXnwto7K/D+1POBVz9jcprdhZy4iX0weUaQ0/V" +
       "GBC3c/nbIdqNQ61bFG97/fAZr7b/dkH+VlS6yy7a4JahrLXdaa/omCWmUenm" +
       "xDXUIxP94HNtkh8faFvw/iul9Ya9tN5wXaVV/PzItsKnzwD+ywX5+4fAO4G0" +
       "XGpqUfaxI5D/4HqA3Lfd/b0BIP/JGSA/X5DPHoLsFqcArwD5uWsFiYGrswfZ" +
       "uUEg/9UZIH+zIL8Wle7cgUyN6AqMv36tGOvgIvYYiRuE8ctnYPzdgvx2VLpj" +
       "i5F2kysgfuF62OpwD3F4gyD+/hkQv1aQ3zu0VTbQwvAKkP/uWkE2wTXagxzd" +
       "IJB/eAbIPyrI16PS3VuQY5BrpStRfuNaUVbBNdmjnFxXlIeZCH6emWioZUd5" +
       "6E/PEMz/KsifAANfa9npuv/2tUqlOMbG76XCX3fdf3db4YdnQPxRQf4SxCkA" +
       "8Sqa//61YiwOo7xlj/EtNwbjwe1Xx3hwZ0Fujkq3AYzFZOkEwIPz1wqwmCo8" +
       "tQf41A0x7fLzNG18JTnLo1nWwUvOEMvLCnIBuL2ybTSJpOCKJHVw37XK5o3g" +
       "kveyka+38g8e2CJ51RkonyjIw1Hp3h3K4myNpV2J85HrYeTOHqdzfXCe21Y4" +
       "d2gDD1/9pDYtBesCBbKFfMap0YNKQV4HElqo7c9074/0HpMFdK2yeBRcb9/L" +
       "4u3XRxbHMfzkGc/eVJBGVLpHAbEsuBrC5jUgvOfQ49+3R/i+F4IQLEe9wI0A" +
       "V5r6fBz/9c/T8Y9cnjxDOkxBwIr/ftCdst5Jp6+FxRc/JyTUvQYJvbgofAJc" +
       "f7aX0J+9UBvAn8vvh1s4whlQxYJMotJ9RtjRwuNIt9VPLCRvlV0XGIxzJIDp" +
       "tQrgNeD6/l4A379BAlieIYBi/+ZAjkovNsKdorcB/kjbBz91BFa5VrCvBtcP" +
       "92B/eIPAhmeAjQviAMM+BNt11NOhutcKFQJMHeza7v7eAKg/dwbUdxYkj0ov" +
       "PYRafOFnOLF2Ot63XQfVHpzf4z1/g/C+9wy87yvILxxTbcuyTof67muAen9R" +
       "+DBg6u491LtfKNTnzlsfOePZLxXkgyAvL4/l5cMkcOwM7u70/xHmX7wGzC8q" +
       "Ch8C7D+4x/zg9cf8qTOefbogfxcEXyPs2l6UnVDn37sOmwcHj+yhPXJ9oJ3I" +
       "zq89Iztf0uJRav5HZwij2BU7eCYqPaAaoSdFyury9kWTY+n5M9dhz+HgTXvZ" +
       "vOmGyOasmcslbNT+M4+tCM7YTzv4rYL8Gshmkqpe0fqEcK55Yw3M7g7IvXDI" +
       "6yqcgr1nt4B+9wyw/7YgXwQhPtBsN9GeC++XrgHv9suLNxbH+Pd42ReK9/QQ" +
       "v1+7FOwNizJjC+xrZ4D+zwX5alS6JdA8Nzhp8P/+hWAEE7oXn/bxavEl3oNX" +
       "fEa/+/Rb+ewn7r3tpZ+Y/f72+81Ln2ffTpVu02PLOv7h1LH7W7xA07fYSrfv" +
       "PqPytmD+ICq97KrLtah0c/GnYPvgv+7q/xHg+LT6UekmQI/X/BZIBydrRqXz" +
       "27/H6307Kt1xVA+IdXdzvMr/BL2DKsXtnxbKPvg76c57HzxuK9s9oPufS/yX" +
       "mhz/6LNYmm7/c4PDV2Axu/9g63OfIJm3fa/+qd1Hp4ol5XnRy21U6dbd96/b" +
       "TovXaI9dtbfDvm4hXvuDe3719icOX/nds2P4yG6P8fbI6V94btNP4V35P3/p" +
       "P33Dpz/x9e3HLf8POSu9GHVCAAA=");
}
