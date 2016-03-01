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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+h0fFPohnvel571YKTo8ed9cPOjMX0a8");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("cPge4oUzb2tOvSzcO3omjd30NklPogM1P0dxQAWSb5hyOPAUlfXiUJ0ZKnCi" +
           "w2MV+eP2J293sKh41P7ZD7/0ssL9Krx/+PzViEoXDs97nYxk97JtfePRgGbx" +
           "AmX3F51953SivpvftxWGSG/1THnvRtzQa8TdV7fFoZKizV8/5+HyK3nyK1Hp" +
           "flvd8oEahqpyy0egiWcqJ7b/7A96+nm6m1tpCgPXRw419ZE3VFP5z98oBL50" +
           "DuzfyZPfjkpvArBHqqNKAHee9bkTjF+8U4wNcH38EOPHf0QYf/8cjF/Ok1ej" +
           "0kWAMXfuswB/7w4AFm+YSXB96hDgJ18vQOqWAPdPeOL5E5RfPQflf8qTr0Sl" +
           "RxUz9KVINoDrLz0pUAr/PwP5P94p5Ba4vnQI+UtvDOSbbPr1c9B+I0/+DFD0" +
           "Edqxmka3Qvrnd4D0sTzzKri+doj0a284Uq0Q+OtzkH4rT/4qKj24knxgUsaT" +
           "paMzUdoJzP9+BzCLYwI/A7zt+V3dffF1wDy9lL0WR94B/ptzAP9dnnwnKj3i" +
           "x1FXARbN30kFADoB+PyMdb97p7AhMDb1ELb6o7Hu3t7twe4VocffR6XHdtbN" +
           "IY69E9SF2k7g/sOdUnEbwPQO4XqvF+5rWpgbrzsgOV6f9958jqIeypOLUenS" +
           "6rgi6yVnuXzvvjvV0LuAZg4X5P03dkE+0hD8ejR0opwfP0c5T+XJY1HpgUI5" +
           "nfwUzE2aefxONXMNaOQzh5r5zBuqmXx4byuAPHcOyHKeXAWhyg5kakY3YXz2" +
           "TjH+NMD2hUOMX/gRYayfgzHfYOxVQBRaYLyVg8N3unK/G0D79iHEb75eiLdm" +
           "vAuFwIUTssoP0uRevkHkA8VbHeQfwuyW5r3WkcDu5IO0iQ54b3cuZ+9tRdmZ" +
           "iPvepeeBuNQt9IOfo7tenrwrKj18FBKcTKAzOnz3neoQuMld9xzq8PtvjA7v" +
           "LQTuLXRY6Ok4aReqyRNyfbymjM9RxDRPuNeiiB94duaGw6oggj7aPB4Zsf5D" +
           "He0HO8+33vTh0e5jGflzL1+6+PjLk/+8O+p39EHLfUzpohY7zulDn6fuL/iB" +
           "qpmFXu/bHQH1C01cj0pPnjvCqHRP8T/Hs/f+XaVlVHr8NpXABnh3c1oe5F4+" +
           "Kw/aLf6flgPb5/tP5EBTu5vTIqDeXUAkv3X8Ix0j5x/HvuU3E+lutXnraR8u" +
           "IoiHf5DFj6ucPkqfH2MrPig7OnIW7z4puy5//uXe4APfbfzq7ii/7EhZlrdy" +
           "kSndu/uqoGg0P7b29G1bO2rrAv3c9x78wn3PHj1veHA34JP5dGpsT9363Hxn" +
           "5UfFSffs3z7+2+/6Vy//RXFC6v8BLARcb+k3AAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cVYY/W0pzSXgzNdP6X8ANelFr4cUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
