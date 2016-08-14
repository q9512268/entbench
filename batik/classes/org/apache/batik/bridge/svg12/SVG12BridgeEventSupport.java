package org.apache.batik.bridge.svg12;
public abstract class SVG12BridgeEventSupport extends org.apache.batik.bridge.BridgeEventSupport {
    protected SVG12BridgeEventSupport() { super(); }
    public static void addGVTListener(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Document doc) { org.apache.batik.bridge.UserAgent ua =
                                                                    ctx.
                                                                    getUserAgent(
                                                                      );
                                                                  if (ua !=
                                                                        null) {
                                                                      org.apache.batik.gvt.event.EventDispatcher dispatcher =
                                                                        ua.
                                                                        getEventDispatcher(
                                                                          );
                                                                      if (dispatcher !=
                                                                            null) {
                                                                          final org.apache.batik.bridge.svg12.SVG12BridgeEventSupport.Listener listener =
                                                                            new org.apache.batik.bridge.svg12.SVG12BridgeEventSupport.Listener(
                                                                            ctx,
                                                                            ua);
                                                                          dispatcher.
                                                                            addGraphicsNodeMouseListener(
                                                                              listener);
                                                                          dispatcher.
                                                                            addGraphicsNodeMouseWheelListener(
                                                                              listener);
                                                                          dispatcher.
                                                                            addGraphicsNodeKeyListener(
                                                                              listener);
                                                                          org.w3c.dom.events.EventListener l =
                                                                            new org.apache.batik.bridge.BridgeEventSupport.GVTUnloadListener(
                                                                            dispatcher,
                                                                            listener);
                                                                          org.apache.batik.dom.events.NodeEventTarget target =
                                                                            (org.apache.batik.dom.events.NodeEventTarget)
                                                                              doc;
                                                                          target.
                                                                            addEventListenerNS(
                                                                              org.apache.batik.util.XMLConstants.
                                                                                XML_EVENTS_NAMESPACE_URI,
                                                                              "SVGUnload",
                                                                              l,
                                                                              false,
                                                                              null);
                                                                          storeEventListenerNS(
                                                                            ctx,
                                                                            target,
                                                                            org.apache.batik.util.XMLConstants.
                                                                              XML_EVENTS_NAMESPACE_URI,
                                                                            "SVGUnload",
                                                                            l,
                                                                            false);
                                                                      }
                                                                  }
    }
    protected static class Listener extends org.apache.batik.bridge.BridgeEventSupport.Listener implements org.apache.batik.gvt.event.GraphicsNodeMouseWheelListener {
        protected org.apache.batik.bridge.svg12.SVG12BridgeContext
          ctx12;
        public Listener(org.apache.batik.bridge.BridgeContext ctx,
                        org.apache.batik.bridge.UserAgent u) {
            super(
              ctx,
              u);
            ctx12 =
              (org.apache.batik.bridge.svg12.SVG12BridgeContext)
                ctx;
        }
        public void keyPressed(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            if (!isDown) {
                isDown =
                  true;
                dispatchKeyboardEvent(
                  "keydown",
                  evt);
            }
            if (evt.
                  getKeyChar(
                    ) ==
                  java.awt.event.KeyEvent.
                    CHAR_UNDEFINED) {
                dispatchTextEvent(
                  evt);
            }
        }
        public void keyReleased(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            dispatchKeyboardEvent(
              "keyup",
              evt);
            isDown =
              false;
        }
        public void keyTyped(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            dispatchTextEvent(
              evt);
        }
        protected void dispatchKeyboardEvent(java.lang.String eventType,
                                             org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            org.apache.batik.bridge.FocusManager fmgr =
              context.
              getFocusManager(
                );
            if (fmgr ==
                  null) {
                return;
            }
            org.w3c.dom.Element targetElement =
              (org.w3c.dom.Element)
                fmgr.
                getCurrentEventTarget(
                  );
            if (targetElement ==
                  null) {
                targetElement =
                  context.
                    getDocument(
                      ).
                    getDocumentElement(
                      );
            }
            org.w3c.dom.events.DocumentEvent d =
              (org.w3c.dom.events.DocumentEvent)
                targetElement.
                getOwnerDocument(
                  );
            org.apache.batik.dom.events.DOMKeyboardEvent keyEvt =
              (org.apache.batik.dom.events.DOMKeyboardEvent)
                d.
                createEvent(
                  "KeyboardEvent");
            java.lang.String modifiers =
              org.apache.batik.dom.util.DOMUtilities.
              getModifiersList(
                evt.
                  getLockState(
                    ),
                evt.
                  getModifiers(
                    ));
            keyEvt.
              initKeyboardEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                eventType,
                true,
                true,
                null,
                mapKeyCodeToIdentifier(
                  evt.
                    getKeyCode(
                      )),
                mapKeyLocation(
                  evt.
                    getKeyLocation(
                      )),
                modifiers);
            try {
                ((org.w3c.dom.events.EventTarget)
                   targetElement).
                  dispatchEvent(
                    keyEvt);
            }
            catch (java.lang.RuntimeException e) {
                ua.
                  displayError(
                    e);
            }
        }
        protected void dispatchTextEvent(org.apache.batik.gvt.event.GraphicsNodeKeyEvent evt) {
            org.apache.batik.bridge.FocusManager fmgr =
              context.
              getFocusManager(
                );
            if (fmgr ==
                  null) {
                return;
            }
            org.w3c.dom.Element targetElement =
              (org.w3c.dom.Element)
                fmgr.
                getCurrentEventTarget(
                  );
            if (targetElement ==
                  null) {
                targetElement =
                  context.
                    getDocument(
                      ).
                    getDocumentElement(
                      );
            }
            org.w3c.dom.events.DocumentEvent d =
              (org.w3c.dom.events.DocumentEvent)
                targetElement.
                getOwnerDocument(
                  );
            org.apache.batik.dom.events.DOMTextEvent textEvt =
              (org.apache.batik.dom.events.DOMTextEvent)
                d.
                createEvent(
                  "TextEvent");
            textEvt.
              initTextEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "textInput",
                true,
                true,
                null,
                java.lang.String.
                  valueOf(
                    evt.
                      getKeyChar(
                        )));
            try {
                ((org.w3c.dom.events.EventTarget)
                   targetElement).
                  dispatchEvent(
                    textEvt);
            }
            catch (java.lang.RuntimeException e) {
                ua.
                  displayError(
                    e);
            }
        }
        protected int mapKeyLocation(int location) {
            return location -
              1;
        }
        protected static java.lang.String[][]
          IDENTIFIER_KEY_CODES =
          new java.lang.String[256][];
        static { putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_0,
                                      java.awt.event.KeyEvent.
                                        VK_0);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_1,
                                      java.awt.event.KeyEvent.
                                        VK_1);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_2,
                                      java.awt.event.KeyEvent.
                                        VK_2);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_3,
                                      java.awt.event.KeyEvent.
                                        VK_3);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_4,
                                      java.awt.event.KeyEvent.
                                        VK_4);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_5,
                                      java.awt.event.KeyEvent.
                                        VK_5);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_6,
                                      java.awt.event.KeyEvent.
                                        VK_6);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_7,
                                      java.awt.event.KeyEvent.
                                        VK_7);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_8,
                                      java.awt.event.KeyEvent.
                                        VK_8);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_9,
                                      java.awt.event.KeyEvent.
                                        VK_9);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ACCEPT,
                                      java.awt.event.KeyEvent.
                                        VK_ACCEPT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_AGAIN,
                                      java.awt.event.KeyEvent.
                                        VK_AGAIN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_A,
                                      java.awt.event.KeyEvent.
                                        VK_A);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ALL_CANDIDATES,
                                      java.awt.event.KeyEvent.
                                        VK_ALL_CANDIDATES);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ALPHANUMERIC,
                                      java.awt.event.KeyEvent.
                                        VK_ALPHANUMERIC);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ALT_GRAPH,
                                      java.awt.event.KeyEvent.
                                        VK_ALT_GRAPH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ALT,
                                      java.awt.event.KeyEvent.
                                        VK_ALT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_AMPERSAND,
                                      java.awt.event.KeyEvent.
                                        VK_AMPERSAND);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_APOSTROPHE,
                                      java.awt.event.KeyEvent.
                                        VK_QUOTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ASTERISK,
                                      java.awt.event.KeyEvent.
                                        VK_ASTERISK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_AT,
                                      java.awt.event.KeyEvent.
                                        VK_AT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_BACKSLASH,
                                      java.awt.event.KeyEvent.
                                        VK_BACK_SLASH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_BACKSPACE,
                                      java.awt.event.KeyEvent.
                                        VK_BACK_SPACE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_B,
                                      java.awt.event.KeyEvent.
                                        VK_B);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CANCEL,
                                      java.awt.event.KeyEvent.
                                        VK_CANCEL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CAPS_LOCK,
                                      java.awt.event.KeyEvent.
                                        VK_CAPS_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CIRCUMFLEX,
                                      java.awt.event.KeyEvent.
                                        VK_CIRCUMFLEX);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_C,
                                      java.awt.event.KeyEvent.
                                        VK_C);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CLEAR,
                                      java.awt.event.KeyEvent.
                                        VK_CLEAR);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CODE_INPUT,
                                      java.awt.event.KeyEvent.
                                        VK_CODE_INPUT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COLON,
                                      java.awt.event.KeyEvent.
                                        VK_COLON);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_ACUTE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_ACUTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_BREVE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_BREVE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_CARON,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_CARON);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_CEDILLA,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_CEDILLA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_CIRCUMFLEX,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_CIRCUMFLEX);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_DIERESIS,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_DIAERESIS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_DOT_ABOVE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_ABOVEDOT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_DOUBLE_ACUTE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_DOUBLEACUTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_GRAVE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_GRAVE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_IOTA,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_IOTA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_MACRON,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_MACRON);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_OGONEK,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_OGONEK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_RING_ABOVE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_ABOVERING);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMBINING_TILDE,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_TILDE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMMA,
                                      java.awt.event.KeyEvent.
                                        VK_COMMA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COMPOSE,
                                      java.awt.event.KeyEvent.
                                        VK_COMPOSE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CONTROL,
                                      java.awt.event.KeyEvent.
                                        VK_CONTROL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CONVERT,
                                      java.awt.event.KeyEvent.
                                        VK_CONVERT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_COPY,
                                      java.awt.event.KeyEvent.
                                        VK_COPY);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_CUT,
                                      java.awt.event.KeyEvent.
                                        VK_CUT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_DELETE,
                                      java.awt.event.KeyEvent.
                                        VK_DELETE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_D,
                                      java.awt.event.KeyEvent.
                                        VK_D);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_DOLLAR,
                                      java.awt.event.KeyEvent.
                                        VK_DOLLAR);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_DOWN,
                                      java.awt.event.KeyEvent.
                                        VK_DOWN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_E,
                                      java.awt.event.KeyEvent.
                                        VK_E);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_END,
                                      java.awt.event.KeyEvent.
                                        VK_END);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ENTER,
                                      java.awt.event.KeyEvent.
                                        VK_ENTER);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_EQUALS,
                                      java.awt.event.KeyEvent.
                                        VK_EQUALS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ESCAPE,
                                      java.awt.event.KeyEvent.
                                        VK_ESCAPE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_EURO,
                                      java.awt.event.KeyEvent.
                                        VK_EURO_SIGN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_EXCLAMATION,
                                      java.awt.event.KeyEvent.
                                        VK_EXCLAMATION_MARK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F10,
                                      java.awt.event.KeyEvent.
                                        VK_F10);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F11,
                                      java.awt.event.KeyEvent.
                                        VK_F11);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F12,
                                      java.awt.event.KeyEvent.
                                        VK_F12);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F13,
                                      java.awt.event.KeyEvent.
                                        VK_F13);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F14,
                                      java.awt.event.KeyEvent.
                                        VK_F14);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F15,
                                      java.awt.event.KeyEvent.
                                        VK_F15);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F16,
                                      java.awt.event.KeyEvent.
                                        VK_F16);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F17,
                                      java.awt.event.KeyEvent.
                                        VK_F17);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F18,
                                      java.awt.event.KeyEvent.
                                        VK_F18);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F19,
                                      java.awt.event.KeyEvent.
                                        VK_F19);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F1,
                                      java.awt.event.KeyEvent.
                                        VK_F1);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F20,
                                      java.awt.event.KeyEvent.
                                        VK_F20);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F21,
                                      java.awt.event.KeyEvent.
                                        VK_F21);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F22,
                                      java.awt.event.KeyEvent.
                                        VK_F22);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F23,
                                      java.awt.event.KeyEvent.
                                        VK_F23);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F24,
                                      java.awt.event.KeyEvent.
                                        VK_F24);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F2,
                                      java.awt.event.KeyEvent.
                                        VK_F2);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F3,
                                      java.awt.event.KeyEvent.
                                        VK_F3);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F4,
                                      java.awt.event.KeyEvent.
                                        VK_F4);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F5,
                                      java.awt.event.KeyEvent.
                                        VK_F5);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F6,
                                      java.awt.event.KeyEvent.
                                        VK_F6);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F7,
                                      java.awt.event.KeyEvent.
                                        VK_F7);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F8,
                                      java.awt.event.KeyEvent.
                                        VK_F8);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F9,
                                      java.awt.event.KeyEvent.
                                        VK_F9);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FINAL_MODE,
                                      java.awt.event.KeyEvent.
                                        VK_FINAL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FIND,
                                      java.awt.event.KeyEvent.
                                        VK_FIND);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_F,
                                      java.awt.event.KeyEvent.
                                        VK_F);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FULL_STOP,
                                      java.awt.event.KeyEvent.
                                        VK_PERIOD);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FULL_WIDTH,
                                      java.awt.event.KeyEvent.
                                        VK_FULL_WIDTH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_G,
                                      java.awt.event.KeyEvent.
                                        VK_G);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_GRAVE,
                                      java.awt.event.KeyEvent.
                                        VK_BACK_QUOTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_GREATER_THAN,
                                      java.awt.event.KeyEvent.
                                        VK_GREATER);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HALF_WIDTH,
                                      java.awt.event.KeyEvent.
                                        VK_HALF_WIDTH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HASH,
                                      java.awt.event.KeyEvent.
                                        VK_NUMBER_SIGN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HELP,
                                      java.awt.event.KeyEvent.
                                        VK_HELP);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HIRAGANA,
                                      java.awt.event.KeyEvent.
                                        VK_HIRAGANA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_H,
                                      java.awt.event.KeyEvent.
                                        VK_H);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_HOME,
                                      java.awt.event.KeyEvent.
                                        VK_HOME);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_I,
                                      java.awt.event.KeyEvent.
                                        VK_I);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_INSERT,
                                      java.awt.event.KeyEvent.
                                        VK_INSERT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_INVERTED_EXCLAMATION,
                                      java.awt.event.KeyEvent.
                                        VK_INVERTED_EXCLAMATION_MARK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_JAPANESE_HIRAGANA,
                                      java.awt.event.KeyEvent.
                                        VK_JAPANESE_HIRAGANA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_JAPANESE_KATAKANA,
                                      java.awt.event.KeyEvent.
                                        VK_JAPANESE_KATAKANA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_JAPANESE_ROMAJI,
                                      java.awt.event.KeyEvent.
                                        VK_JAPANESE_ROMAN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_J,
                                      java.awt.event.KeyEvent.
                                        VK_J);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_KANA_MODE,
                                      java.awt.event.KeyEvent.
                                        VK_KANA_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_KANJI_MODE,
                                      java.awt.event.KeyEvent.
                                        VK_KANJI);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_KATAKANA,
                                      java.awt.event.KeyEvent.
                                        VK_KATAKANA);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_K,
                                      java.awt.event.KeyEvent.
                                        VK_K);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT_BRACE,
                                      java.awt.event.KeyEvent.
                                        VK_BRACELEFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT,
                                      java.awt.event.KeyEvent.
                                        VK_LEFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT_PARENTHESIS,
                                      java.awt.event.KeyEvent.
                                        VK_LEFT_PARENTHESIS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT_SQUARE_BRACKET,
                                      java.awt.event.KeyEvent.
                                        VK_OPEN_BRACKET);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LESS_THAN,
                                      java.awt.event.KeyEvent.
                                        VK_LESS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_L,
                                      java.awt.event.KeyEvent.
                                        VK_L);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_META,
                                      java.awt.event.KeyEvent.
                                        VK_META);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_META,
                                      java.awt.event.KeyEvent.
                                        VK_META);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_MINUS,
                                      java.awt.event.KeyEvent.
                                        VK_MINUS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_M,
                                      java.awt.event.KeyEvent.
                                        VK_M);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_MODE_CHANGE,
                                      java.awt.event.KeyEvent.
                                        VK_MODECHANGE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_N,
                                      java.awt.event.KeyEvent.
                                        VK_N);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_NONCONVERT,
                                      java.awt.event.KeyEvent.
                                        VK_NONCONVERT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_NUM_LOCK,
                                      java.awt.event.KeyEvent.
                                        VK_NUM_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_NUM_LOCK,
                                      java.awt.event.KeyEvent.
                                        VK_NUM_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_O,
                                      java.awt.event.KeyEvent.
                                        VK_O);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PAGE_DOWN,
                                      java.awt.event.KeyEvent.
                                        VK_PAGE_DOWN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PAGE_UP,
                                      java.awt.event.KeyEvent.
                                        VK_PAGE_UP);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PASTE,
                                      java.awt.event.KeyEvent.
                                        VK_PASTE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PAUSE,
                                      java.awt.event.KeyEvent.
                                        VK_PAUSE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_P,
                                      java.awt.event.KeyEvent.
                                        VK_P);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PLUS,
                                      java.awt.event.KeyEvent.
                                        VK_PLUS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PREVIOUS_CANDIDATE,
                                      java.awt.event.KeyEvent.
                                        VK_PREVIOUS_CANDIDATE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PRINT_SCREEN,
                                      java.awt.event.KeyEvent.
                                        VK_PRINTSCREEN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PROPS,
                                      java.awt.event.KeyEvent.
                                        VK_PROPS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_Q,
                                      java.awt.event.KeyEvent.
                                        VK_Q);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_QUOTE,
                                      java.awt.event.KeyEvent.
                                        VK_QUOTEDBL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT_BRACE,
                                      java.awt.event.KeyEvent.
                                        VK_BRACERIGHT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT,
                                      java.awt.event.KeyEvent.
                                        VK_RIGHT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT_PARENTHESIS,
                                      java.awt.event.KeyEvent.
                                        VK_RIGHT_PARENTHESIS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT_SQUARE_BRACKET,
                                      java.awt.event.KeyEvent.
                                        VK_CLOSE_BRACKET);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_R,
                                      java.awt.event.KeyEvent.
                                        VK_R);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ROMAN_CHARACTERS,
                                      java.awt.event.KeyEvent.
                                        VK_ROMAN_CHARACTERS);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SCROLL,
                                      java.awt.event.KeyEvent.
                                        VK_SCROLL_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SCROLL,
                                      java.awt.event.KeyEvent.
                                        VK_SCROLL_LOCK);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SEMICOLON,
                                      java.awt.event.KeyEvent.
                                        VK_SEMICOLON);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SEMIVOICED_SOUND,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_SEMIVOICED_SOUND);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SHIFT,
                                      java.awt.event.KeyEvent.
                                        VK_SHIFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SHIFT,
                                      java.awt.event.KeyEvent.
                                        VK_SHIFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_S,
                                      java.awt.event.KeyEvent.
                                        VK_S);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SLASH,
                                      java.awt.event.KeyEvent.
                                        VK_SLASH);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SPACE,
                                      java.awt.event.KeyEvent.
                                        VK_SPACE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_STOP,
                                      java.awt.event.KeyEvent.
                                        VK_STOP);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_TAB,
                                      java.awt.event.KeyEvent.
                                        VK_TAB);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_T,
                                      java.awt.event.KeyEvent.
                                        VK_T);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_U,
                                      java.awt.event.KeyEvent.
                                        VK_U);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UNDERSCORE,
                                      java.awt.event.KeyEvent.
                                        VK_UNDERSCORE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UNDO,
                                      java.awt.event.KeyEvent.
                                        VK_UNDO);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UNIDENTIFIED,
                                      java.awt.event.KeyEvent.
                                        VK_UNDEFINED);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UP,
                                      java.awt.event.KeyEvent.
                                        VK_UP);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_V,
                                      java.awt.event.KeyEvent.
                                        VK_V);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_VOICED_SOUND,
                                      java.awt.event.KeyEvent.
                                        VK_DEAD_VOICED_SOUND);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_W,
                                      java.awt.event.KeyEvent.
                                        VK_W);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_X,
                                      java.awt.event.KeyEvent.
                                        VK_X);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_Y,
                                      java.awt.event.KeyEvent.
                                        VK_Y);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_Z,
                                      java.awt.event.KeyEvent.
                                        VK_Z);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_0,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD0);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_1,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD1);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_2,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD2);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_3,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD3);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_4,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD4);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_5,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD5);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_6,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD6);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_7,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD7);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_8,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD8);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_9,
                                      java.awt.event.KeyEvent.
                                        VK_NUMPAD9);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_ASTERISK,
                                      java.awt.event.KeyEvent.
                                        VK_MULTIPLY);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_DOWN,
                                      java.awt.event.KeyEvent.
                                        VK_KP_DOWN);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_FULL_STOP,
                                      java.awt.event.KeyEvent.
                                        VK_DECIMAL);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_LEFT,
                                      java.awt.event.KeyEvent.
                                        VK_KP_LEFT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_MINUS,
                                      java.awt.event.KeyEvent.
                                        VK_SUBTRACT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_PLUS,
                                      java.awt.event.KeyEvent.
                                        VK_ADD);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_RIGHT,
                                      java.awt.event.KeyEvent.
                                        VK_KP_RIGHT);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_SLASH,
                                      java.awt.event.KeyEvent.
                                        VK_DIVIDE);
                 putIdentifierKeyCode(org.apache.batik.dom.events.DOMKeyboardEvent.
                                        KEY_UP,
                                      java.awt.event.KeyEvent.
                                        VK_KP_UP);
        }
        protected static void putIdentifierKeyCode(java.lang.String keyIdentifier,
                                                   int keyCode) {
            if (IDENTIFIER_KEY_CODES[keyCode /
                                       256] ==
                  null) {
                IDENTIFIER_KEY_CODES[keyCode /
                                       256] =
                  (new java.lang.String[256]);
            }
            IDENTIFIER_KEY_CODES[keyCode /
                                   256][keyCode %
                                          256] =
              keyIdentifier;
        }
        protected java.lang.String mapKeyCodeToIdentifier(int keyCode) {
            java.lang.String[] a =
              IDENTIFIER_KEY_CODES[keyCode /
                                     256];
            if (a ==
                  null) {
                return org.apache.batik.dom.events.DOMKeyboardEvent.
                         KEY_UNIDENTIFIED;
            }
            return a[keyCode %
                       256];
        }
        public void mouseWheelMoved(org.apache.batik.gvt.event.GraphicsNodeMouseWheelEvent evt) {
            org.w3c.dom.Document doc =
              context.
              getPrimaryBridgeContext(
                ).
              getDocument(
                );
            org.w3c.dom.Element targetElement =
              doc.
              getDocumentElement(
                );
            org.w3c.dom.events.DocumentEvent d =
              (org.w3c.dom.events.DocumentEvent)
                doc;
            org.apache.batik.dom.svg12.SVGOMWheelEvent wheelEvt =
              (org.apache.batik.dom.svg12.SVGOMWheelEvent)
                d.
                createEvent(
                  "WheelEvent");
            wheelEvt.
              initWheelEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "wheel",
                true,
                true,
                null,
                evt.
                  getWheelDelta(
                    ));
            try {
                ((org.w3c.dom.events.EventTarget)
                   targetElement).
                  dispatchEvent(
                    wheelEvt);
            }
            catch (java.lang.RuntimeException e) {
                ua.
                  displayError(
                    e);
            }
        }
        public void mouseEntered(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
            java.awt.Point clientXY =
              evt.
              getClientPoint(
                );
            org.apache.batik.gvt.GraphicsNode node =
              evt.
              getGraphicsNode(
                );
            org.w3c.dom.Element targetElement =
              getEventTarget(
                node,
                new java.awt.geom.Point2D.Float(
                  evt.
                    getX(
                      ),
                  evt.
                    getY(
                      )));
            org.w3c.dom.Element relatedElement =
              getRelatedElement(
                evt);
            int n =
              0;
            if (relatedElement !=
                  null &&
                  targetElement !=
                  null) {
                n =
                  org.apache.batik.bridge.svg12.DefaultXBLManager.
                    computeBubbleLimit(
                      targetElement,
                      relatedElement);
            }
            dispatchMouseEvent(
              "mouseover",
              targetElement,
              relatedElement,
              clientXY,
              evt,
              true,
              n);
        }
        public void mouseExited(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
            java.awt.Point clientXY =
              evt.
              getClientPoint(
                );
            org.apache.batik.gvt.GraphicsNode node =
              evt.
              getRelatedNode(
                );
            org.w3c.dom.Element targetElement =
              getEventTarget(
                node,
                clientXY);
            if (lastTargetElement !=
                  null) {
                int n =
                  0;
                if (targetElement !=
                      null) {
                    n =
                      org.apache.batik.bridge.svg12.DefaultXBLManager.
                        computeBubbleLimit(
                          lastTargetElement,
                          targetElement);
                }
                dispatchMouseEvent(
                  "mouseout",
                  lastTargetElement,
                  targetElement,
                  clientXY,
                  evt,
                  true,
                  n);
                lastTargetElement =
                  null;
            }
        }
        public void mouseMoved(org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt) {
            java.awt.Point clientXY =
              evt.
              getClientPoint(
                );
            org.apache.batik.gvt.GraphicsNode node =
              evt.
              getGraphicsNode(
                );
            org.w3c.dom.Element targetElement =
              getEventTarget(
                node,
                clientXY);
            org.w3c.dom.Element holdLTE =
              lastTargetElement;
            if (holdLTE !=
                  targetElement) {
                if (holdLTE !=
                      null) {
                    int n =
                      0;
                    if (targetElement !=
                          null) {
                        n =
                          org.apache.batik.bridge.svg12.DefaultXBLManager.
                            computeBubbleLimit(
                              holdLTE,
                              targetElement);
                    }
                    dispatchMouseEvent(
                      "mouseout",
                      holdLTE,
                      targetElement,
                      clientXY,
                      evt,
                      true,
                      n);
                }
                if (targetElement !=
                      null) {
                    int n =
                      0;
                    if (holdLTE !=
                          null) {
                        n =
                          org.apache.batik.bridge.svg12.DefaultXBLManager.
                            computeBubbleLimit(
                              targetElement,
                              holdLTE);
                    }
                    dispatchMouseEvent(
                      "mouseover",
                      targetElement,
                      holdLTE,
                      clientXY,
                      evt,
                      true,
                      n);
                }
            }
            dispatchMouseEvent(
              "mousemove",
              targetElement,
              null,
              clientXY,
              evt,
              false,
              0);
        }
        protected void dispatchMouseEvent(java.lang.String eventType,
                                          org.w3c.dom.Element targetElement,
                                          org.w3c.dom.Element relatedElement,
                                          java.awt.Point clientXY,
                                          org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt,
                                          boolean cancelable) {
            dispatchMouseEvent(
              eventType,
              targetElement,
              relatedElement,
              clientXY,
              evt,
              cancelable,
              0);
        }
        protected void dispatchMouseEvent(java.lang.String eventType,
                                          org.w3c.dom.Element targetElement,
                                          org.w3c.dom.Element relatedElement,
                                          java.awt.Point clientXY,
                                          org.apache.batik.gvt.event.GraphicsNodeMouseEvent evt,
                                          boolean cancelable,
                                          int bubbleLimit) {
            if (ctx12.
                  mouseCaptureTarget !=
                  null) {
                org.apache.batik.dom.events.NodeEventTarget net =
                  null;
                if (targetElement !=
                      null) {
                    net =
                      (org.apache.batik.dom.events.NodeEventTarget)
                        targetElement;
                    while (net !=
                             null &&
                             net !=
                             ctx12.
                               mouseCaptureTarget) {
                        net =
                          net.
                            getParentNodeEventTarget(
                              );
                    }
                }
                if (net ==
                      null) {
                    if (ctx12.
                          mouseCaptureSendAll) {
                        targetElement =
                          (org.w3c.dom.Element)
                            ctx12.
                              mouseCaptureTarget;
                    }
                    else {
                        targetElement =
                          null;
                    }
                }
            }
            if (targetElement !=
                  null) {
                java.awt.Point screenXY =
                  evt.
                  getScreenPoint(
                    );
                org.w3c.dom.events.DocumentEvent d =
                  (org.w3c.dom.events.DocumentEvent)
                    targetElement.
                    getOwnerDocument(
                      );
                org.apache.batik.dom.events.DOMMouseEvent mouseEvt =
                  (org.apache.batik.dom.events.DOMMouseEvent)
                    d.
                    createEvent(
                      "MouseEvents");
                java.lang.String modifiers =
                  org.apache.batik.dom.util.DOMUtilities.
                  getModifiersList(
                    evt.
                      getLockState(
                        ),
                    evt.
                      getModifiers(
                        ));
                mouseEvt.
                  initMouseEventNS(
                    org.apache.batik.util.XMLConstants.
                      XML_EVENTS_NAMESPACE_URI,
                    eventType,
                    true,
                    cancelable,
                    null,
                    evt.
                      getClickCount(
                        ),
                    screenXY.
                      x,
                    screenXY.
                      y,
                    clientXY.
                      x,
                    clientXY.
                      y,
                    (short)
                      (evt.
                         getButton(
                           ) -
                         1),
                    (org.w3c.dom.events.EventTarget)
                      relatedElement,
                    modifiers);
                ((org.apache.batik.dom.events.AbstractEvent)
                   mouseEvt).
                  setBubbleLimit(
                    bubbleLimit);
                try {
                    ((org.w3c.dom.events.EventTarget)
                       targetElement).
                      dispatchEvent(
                        mouseEvt);
                }
                catch (java.lang.RuntimeException e) {
                    ua.
                      displayError(
                        e);
                }
                finally {
                    lastTargetElement =
                      targetElement;
                }
            }
            if (ctx12.
                  mouseCaptureTarget !=
                  null &&
                  ctx12.
                    mouseCaptureAutoRelease &&
                  "mouseup".
                  equals(
                    eventType)) {
                ctx12.
                  stopMouseCapture(
                    );
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Cq92u1UPHXCralN2HZVeowSjStMFxlZgq2uZWItFmnODUNRtKioMXBks+ApB" +
           "BRWzE3TFoKKTK3RR71UXW6KHozETto16SvQMl2sGGKVYGRlMYGHjTmB6q867" +
           "fL2xYMVVVYtZ01w0zT69IOi5U0Z72hhfZ76RrssRFaBIr7+S69thxnQiwoqM" +
           "hCbIiFJsJwSaWkASZa5YNCmjS69Si1ir11YxceGZChvbLlkJ0pbJSB2HHBnd" +
           "wYIzseZiHK9FpS7XoH5bEsQ2PWiPKYbxJtyyOuP0LtF0l501pbizhUhlS5ey" +
           "sxHr62vXZ/kyOWOZrQAPGFazLalDjhqLqu5OllJj6UYk1OXReh8dzJci0rH9" +
           "ZbXRAQOiV4boxBzoY7ee9id1W6fbgjga6UIjthrN7Zox2dlgRcdJzdQiTFiv" +
           "t3VGRGp4Eg/dTpsNIkpHqPW66sOy313UKoNN0KsOaXWzovzZahPCChaOSa3m" +
           "L/FlRMgNq7626Zkzwm1sPhf9LNpCmbNEQlEke93JVg8teTtBELwJ08BWVblM" +
           "dVJpNeMSKJCX+nqUuai22GqT2ripY9tyMhFJEIj2N6Q7z6D5bDReLixqPq/P" +
           "ZmRMMigf9yTBJuxul9aGFi2LM5ZdrQg87qazLYvNexhOZIxD0mzLFgmso8Gp" +
           "7ln42CJFlkxEPVkMKayt+xPeXAtLnosW/XFjVKu59TI+D7G03d74Gpn2VBFi" +
           "uIXbbxPsalFOFmm0LPMmCqHJNF1YSDqCnKTWL8ONYQUiVgIZTyqC0KrrFIpz" +
           "kzlh4ejQVsqxNCI0uivAvVHqpdoy6CRNi9TCbOMKQQ9N/THB65mSzAyT8KsD" +
           "pN0mNzhSk1CaZKBIIJBYq4+2mbqI57a6mraqGTdl9YUql+00M9BxT5wlBKXa" +
           "bVFDgrXV1MmwD4uiGTWg+TxWa06lohvxRBBWbaPTJoJxFxBrLOHzTEvm7U01" +
           "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" +
           "PW4VTldaN+zPIEzvC5FDbupBTYZiBGnM");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("I0lQ/W63++yz+eOsX3h9j9keLJ4eHm8q+j6eGybnvaApGjx5b108MM1fajx/" +
           "+D7j+TNvfU69dNw7erbduemt1DYKDuR8P8bByOMdRRX9mS3JUzv0ZVaRZeNo" +
           "e0b+2P7x221CKh7Zf/pDL70sEb9a3T98jqsEpYuHe8NOerJ7aefeuMWgXbyI" +
           "2f2Cs++uTtR383u7whDJrZ5N792IG3qNuCdyWmxOKer8tXMeUr+SJ/88KN2n" +
           "yynpyb4vS7d8lBrZqnRi+09/r6eop5u5laY64PjwoaY+/IZqKr/89ULgC+fA" +
           "/u08+a2g9CYAewHCUB7gzrM+c4Lx83eKsQmOFw8xvvgDwvh752D8Yp68GpQu" +
           "AYy5c58F+Lt3ALB4Uz0ExycOAX789QIc3RLg/glPPHeC8svnoPzPefKloPRW" +
           "SfUdPhAV4PqCzXtS4f9nIP+nO4XcA8cXDiF/4Y2BfJNNv3oO2q/lyZ8Cij5C" +
           "S8tJcCukf3YHSB/JM6+B4yuHSL/yhiPdFAJ/dQ7Sb+TJXwalB0zeASbFbZE/" +
           "2lu1OYH5P+4AZrHd4CeAtz23K7vPvQ6Yp6ey1+LIO8B/fQ7gv82TbwWlh50w" +
           "QCVg0fzdlgegI4DPz1j323cKGwJ9kw9hyz8Y6+7t3R7sXhF6/H1QemRn3Rwi" +
           "bZ+gLtR2Avcf7pSK+wCmfQjXfr1wX9PE3HzdAcnx/Lz35nMU9WCeXApKl83j" +
           "glM7Osvle/feqYbeAzRzOCHvv7ET8pGGqq9HQyfK+eFzlPNEnjwSlO4vlDPI" +
           "d9PcpJlH71QzzwCNfOpQM596QzWTd+/tBZCnzwFZzpNrIFTZgUzU4CaMT90p" +
           "xh8H2D53iPFzPyCMjXMw5guMvQqIQguMt3Lw6p3O3M8CaN88hPj11wvx1ox3" +
           "sRC4eEJW+Yac3MtjWDyQbPMg/2hmNzXv9Y4Edjso+Dg4IO3d/p69txf3zkTc" +
           "9wi2DeJSq9BP9xzdYXnynqD00FFIcDKAzujw2TvVIXCTuy4c6vC7b4wO7ykE" +
           "7il0WOjpOOkXqsmToXs8p9DnKGKZJ8RrUcT33INzw6ZXEEEfLR6PjNj4vj4R" +
           "ACvPt930kdLuwxrxMy9fvvToy8x/2W0ZPPr45V68dGkTGsbpzaOnzi86nrxR" +
           "C73eu9tK6hSauB6UHj+3h0HpQvGf49l7/66QEJQevU0hsADenZyWB7lXzsqD" +
           "eov/03Jg+XzfiRyoandyWgSUuwuI5KeGc6Rj+Pxt3bf89iLZzTZvO+3DRQTx" +
           "0Pey+HGR01vy8+1wxcdnR1vXwt3nZ9fFz76MzT7w7eav7j4JEA0+y/JaLuGl" +
           "e3ZfJxSV5tvf3nnb2o7qujh++jsPfO7ep46eNzyw6/DJeDrVtyduvf9+YDpB" +
           "sWM++7eP/tZ7/uXLf17stPp/FUJdPhU4AAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwcRxUfnz9iO/6OP0ISO4ljB9lN7+q2ASqnpbZjJw5n" +
       "x7LTSHVoLnO7c3cb7+1uZufOZ7eGthJK4I8QgtuGqvVfrgqobSpEBQhaGVWi" +
       "rQpILRFQUFMk/iB8RDRCKn8EKG9mdm/39nyOyh+ctB838+bNvDe/93tv9oXr" +
       "qNKmqIsYLMwWLGKHRw02halN1BEd2/YxaIspT5Xjf5y8NnlPCFXNooYUticU" +
       "bJMxjeiqPYs6NcNm2FCIPUmIykdMUWITmsVMM41Z1KbZ42lL1xSNTZgq4QLH" +
       "MY2iZswY1eIZRsYdBQx1RmElEbGSyFCwezCK6hTTWvDEt/rER3w9XDLtzWUz" +
       "1BQ9jbM4kmGaHolqNhvMUXSbZeoLSd1kYZJj4dP6fscFR6L7i1zQ/XLjRzcv" +
       "pJqEC7ZgwzCZMM+eJrapZ4kaRY1e66hO0vYZ9CVUHkWbfcIM9UTdSSMwaQQm" +
       "da31pGD19cTIpEdMYQ5zNVVZCl8QQ7sLlViY4rSjZkqsGTRUM8d2MRis3ZW3" +
       "VlpZZOITt0WWnzrZ9L1y1DiLGjVjhi9HgUUwmGQWHErScULtIVUl6ixqNmCz" +
       "ZwjVsK4tOjvdYmtJA7MMbL/rFt6YsQgVc3q+gn0E22hGYSbNm5cQgHL+VSZ0" +
       "nARb2z1bpYVjvB0MrNVgYTSBAXfOkIo5zVAZ2hkckbex5wsgAEM3pQlLmfmp" +
       "KgwMDahFQkTHRjIyA9AzkiBaaQIAKUPbSirlvrawMoeTJMYRGZCbkl0gVSMc" +
       "wYcw1BYUE5pgl7YFdsm3P9cnD5x/2DhshFAZrFklis7XvxkGdQUGTZMEoQTi" +
       "QA6s648+idtfPRdCCITbAsJS5geP3Lh/X9fam1Jm+zoyR+OnicJiymq84Z0d" +
       "I333lPNlVFumrfHNL7BcRNmU0zOYs4Bh2vMaeWfY7Vyb/tmDj36X/DWEasdR" +
       "lWLqmTTgqFkx05amE3qIGIRiRtRxVEMMdUT0j6NN8B7VDCJbjyYSNmHjqEIX" +
       "TVWm+A8uSoAK7qJaeNeMhOm+W5ilxHvOQgg1wYXa4BpE8ieeDKUiKTNNIljB" +
       "hmaYkSlqcvvtCDBOHHybisQB9XMR28xQgGDEpMkIBhykiNMRp5qaJBE7mxy4" +
       "MzJz/NDAncOiZTQLGmYylmVSIB1AnPV/nCvH7d4yX1YGW7IjSAg6xNJhU1cJ" +
       "jSnLmeHRGy/F3pZg4wHieIyh/TB9WE4fFtOH5fRhMX24xPSorEzM2sqXIUEA" +
       "WzgHZABsXNc389CRU+e6ywF91nwF+J+LdhdkpRGPMVyajymXW+oXd18deD2E" +
       "KqKoBSssg3WeZIZoEuhLmXMivC4O+cpLG7t8aYPnO2oqRAXWKpU+HC3VZpZQ" +
       "3s5Qq0+Dm9R4+EZKp5R114/WLs0/dvzLd4RQqDBT8CkrgeT48CnO73ke7wky" +
       "xHp6G89e++jyk0umxxUFqcfNmEUjuQ3dQVwE3RNT+nfhV2KvLvUIt9cAlzMM" +
       "sQeb3BWco4CKBl1a57ZUg8EJk6axzrtcH9eyFDXnvRYB2Gbx3gqwaOCx2QvX" +
       "vU6wiifvbbf4vUMCnOMsYIVIG/fOWM/+9pd/vku4280wjb7SYIawQR+rcWUt" +
       "gr+aPdgeo4SA3PuXpr75xPWzJwRmQWLPehP28PsIsBlsIbj5K2+eee+Dq6tX" +
       "Qh7OGaqxqMkg3Imay9vJu1D9BnbChHu9JQEx6qCBA6fnAQMgqiU0HNcJj61/" +
       "NfYOvPK3800SCjq0uEjad2sFXvunhtGjb5/8Z5dQU6bwxOy5zROTbL/F0zxE" +
       "KV7g68g99m7nt97Az0LeAK62tUUi6BcJNyCxb/uF/XeI+92Bvs/yW6/tx39h" +
       "iPkKqJhy4cqH9cc/fO2GWG1hBebf7glsDUqE8dveHKjvCPLTYWynQO7utckv" +
       "NulrN0HjLGhUgIftoxS4MlcADke6ctPvfvp6+6l3ylFoDNXqJlbHsIgzVAMA" +
       "J3YKaDZnff5+ubnz1W4eyqEi44sauIN3rr91o2mLCWcv/rDj+weeX7kqgGZJ" +
       "Hdv9Cj8t7v38drtoDzGoLzNxKNMZqsZxIAZYsAdI8WsMZkk/IAumoKizVCEj" +
       "irDVx5dX1KPPDchyo6WwOBiF2vfFX//75+FLf3hrnfxTw0zrdp1kie6bk+eL" +
       "zoJ8MSFqPI+z3m+4+Mcf9SSHP0mq4G1dt0gG/P9OMKK/NPUHl/LG43/Zduy+" +
       "1KlPwPo7A+4MqvzOxAtvHdqrXAyJglYSflEhXDho0O9YmJQSqNwNbiZvqRdx" +
       "sScPgBa+sWNwjTgAGFmfedcHF38dBYTZ4kwR4LnmDbQGGCEk1Yn/WxnqLVWK" +
       "yPrDObu40q1cev4uJaya6fBBU8mkATBi2Q9uQDwxfptmqAGr6qHjx3h08aoU" +
       "8Na3wfmRamnIIFmnAo8stXww98y1FyXcg+V6QJicW/7ax+HzyxL68kyzp+hY" +
       "4R8jzzVitU3StR/Drwyu//CLm8IbZF3bMuIU17vy1TVnCIp2b7QsMcXYny4v" +
       "/fjbS2dDjmuOMFSRNTV5kPocv83IrR38H5mNNwxZOYY6SlSRnPu2Fh1k5eFL" +
       "eWmlsbpj5YHfiAjPH5DqIFYTGV33Qd0P+yqLkoQmzKmTqcASDyCazg0LXYYq" +
       "xVNYYcpBkF46SgwC8MsXv3yWoaagPOgVT7/cAkO1nhyoki9+kUcYKgcR/rpk" +
       "uYjv3zg+/J7NlRUnCbGlbbfaUh/p7ymICPFdwuWrjPwyASX7ypHJh2985jlZ" +
       "gyk6XlwU51g4lstyMM95u0tqc3VVHe672fByTa8LyGa5YI+JtvsCeQiyhMUB" +
       "tC1Qndg9+SLlvdUDr/3iXNW7EHsnUBlmaMsJ31cBeQSGEicDyeZE1Es3vu9a" +
       "omwa7Ht64b59ib//XuRfJz3tKC0fU648/9CvLm5dhfJq8ziqhFgjuVlUq9kH" +
       "F4xpomTpLKrX7NGcIB+mYX0cVWcM7UyGjKtR1MCxjvkXC+EXx531+VZewTPU" +
       "XcwhxeceqFXmCR02M4YqsgDkJ6+l4IOJmzYAPoEBXkt+K1uLbY8pB7/a+JML" +
       "LeVjEK8F5vjVb7Iz8XxK8n9D8XJUE7+RnGS38lh0wrJctqtatmQsfF3K8HY4" +
       "ifY7rZx7ymT5wP9eFOq+IV75bfm/G/XjLh4VAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OegGtMSQEcEyVs1I/bGNb/lkzYajSjRZxzJnR8NWnaJEEgl6UY0LZxorYT6s" +
       "OaVuuaz3OVoc21Vppg1ImKX5ktOai+UtKnocu47bJSoYsxq3oNutlToxCbe6" +
       "ZVt8WTclU1TSahJqrS6FeTOLtFXbG2kJ1RH03sxcDOZrIms1W1vTaAvCjGiN" +
       "mKlIG4EVB0JCucpiSHHzPo+LplXSWJqSEk5K0DbHdKueZtW5nhza2LQpOZ1q" +
       "ipQ7eqj3WnzQM0ECVF/FqdmXZ0x/wVNdd7YwZq1aWKs0YEOO1OlcxnFiIbbC" +
       "IV3VlClG6siqqQo2OrThrZvN4YljSEMjs/1GhS/JBIZh1nRssb2NHaiDMVlv" +
       "S/OxzZS2Ey6stPVyTAnKUuXqbCYikd1ZY7UV0ll2hVCeW0vStxcLze+Zaakq" +
       "2F3MJ/rE3JhH85TtUpTMLErr2njcaNfZDj4U1xlHj+3B2u8SqwW7tOFWY0O7" +
       "rVHdHwrKWKH0iQ0vq4aVDuLJTNPQhFsJlbbXbRiK0hkxxmgxHhMADnRb4Eza" +
       "8qU4jvBOezIYZKIRztrNFTUvN9KZ1u90Pcok2npmGmNq7lV9Ydju1u00q1Db" +
       "4RYZd1qONDH4xYzs21xm2SxNtNGWM2URB48HdbmSrVCuv6wTa7ql1dLxUGdQ" +
       "abimHdJWBvN+hvQwj9cqycBQiExHFu3msltRe9FkUFXnOrUqV9Ip7QbdLVUO" +
       "/RXBdFvLrTbgW+1wNZawRhOfM7BSy5JeE3WSHjyESVmXTW/en1JsJqwze7WE" +
       "3ZWMNmSlU+6O/JHbpsNQw5YKT/Bud6OT9ooyYrwygSWP7NejhsBNnUnZ9eet" +
       "1XLkMfAAx1je42dYWJ35JbhjN+cVuMuPvOocRSvIkgxLiBxvSbkyn/md9qKB" +
       "m4GmLCoNHAAqZir1xMzSgVfrN5oKDK8zs7Sx05Tp+ZI6trvMejPD5BmbdLH5" +
       "eAE7qs6WRzEZM0TUlFrWlqLCmSJi7aXkVvBR20KFap1ntEZ3aNaEdBtE0qCp" +
       "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" +
       "6BEpNyAAAA==");
}
