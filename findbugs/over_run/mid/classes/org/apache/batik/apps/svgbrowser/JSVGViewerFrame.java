package org.apache.batik.apps.svgbrowser;
public class JSVGViewerFrame extends javax.swing.JFrame implements org.apache.batik.util.gui.resource.ActionMap, org.apache.batik.swing.svg.SVGDocumentLoaderListener, org.apache.batik.swing.svg.GVTTreeBuilderListener, org.apache.batik.swing.svg.SVGLoadEventDispatcherListener, org.apache.batik.swing.gvt.GVTTreeRendererListener, org.apache.batik.swing.svg.LinkActivationListener, org.apache.batik.bridge.UpdateManagerListener {
    private static java.lang.String EOL;
    static { try { EOL = java.lang.System.getProperty("line.separator", "\n");
             }
             catch (java.lang.SecurityException e) {
                 EOL =
                   "\n";
             } }
    protected static boolean priorJDK1_4 = true;
    protected static final java.lang.String JDK_1_4_PRESENCE_TEST_CLASS =
      "java.util.logging.LoggingPermission";
    static { try { java.lang.Class.forName(JDK_1_4_PRESENCE_TEST_CLASS);
                   priorJDK1_4 = false; }
             catch (java.lang.ClassNotFoundException e) {  } }
    public static final java.lang.String RESOURCES = "org.apache.batik.apps.svgbrowser.resources.GUI";
    public static final java.lang.String ABOUT_ACTION = "AboutAction";
    public static final java.lang.String OPEN_ACTION = "OpenAction";
    public static final java.lang.String OPEN_LOCATION_ACTION = "OpenLocationAction";
    public static final java.lang.String NEW_WINDOW_ACTION = "NewWindowAction";
    public static final java.lang.String RELOAD_ACTION = "ReloadAction";
    public static final java.lang.String SAVE_AS_ACTION = "SaveAsAction";
    public static final java.lang.String BACK_ACTION = "BackAction";
    public static final java.lang.String FORWARD_ACTION = "ForwardAction";
    public static final java.lang.String FULL_SCREEN_ACTION = "FullScreenAction";
    public static final java.lang.String PRINT_ACTION = "PrintAction";
    public static final java.lang.String EXPORT_AS_JPG_ACTION = "ExportAsJPGAction";
    public static final java.lang.String EXPORT_AS_PNG_ACTION = "ExportAsPNGAction";
    public static final java.lang.String EXPORT_AS_TIFF_ACTION = "ExportAsTIFFAction";
    public static final java.lang.String PREFERENCES_ACTION = "PreferencesAction";
    public static final java.lang.String CLOSE_ACTION = "CloseAction";
    public static final java.lang.String VIEW_SOURCE_ACTION = "ViewSourceAction";
    public static final java.lang.String EXIT_ACTION = "ExitAction";
    public static final java.lang.String RESET_TRANSFORM_ACTION = "ResetTransformAction";
    public static final java.lang.String ZOOM_IN_ACTION = "ZoomInAction";
    public static final java.lang.String ZOOM_OUT_ACTION = "ZoomOutAction";
    public static final java.lang.String PREVIOUS_TRANSFORM_ACTION = "PreviousTransformAction";
    public static final java.lang.String NEXT_TRANSFORM_ACTION = "NextTransformAction";
    public static final java.lang.String USE_STYLESHEET_ACTION = "UseStylesheetAction";
    public static final java.lang.String PLAY_ACTION = "PlayAction";
    public static final java.lang.String PAUSE_ACTION = "PauseAction";
    public static final java.lang.String STOP_ACTION = "StopAction";
    public static final java.lang.String MONITOR_ACTION = "MonitorAction";
    public static final java.lang.String DOM_VIEWER_ACTION = "DOMViewerAction";
    public static final java.lang.String SET_TRANSFORM_ACTION = "SetTransformAction";
    public static final java.lang.String FIND_DIALOG_ACTION = "FindDialogAction";
    public static final java.lang.String THUMBNAIL_DIALOG_ACTION = "ThumbnailDialogAction";
    public static final java.lang.String FLUSH_ACTION = "FlushAction";
    public static final java.lang.String TOGGLE_DEBUGGER_ACTION = "ToggleDebuggerAction";
    public static final java.awt.Cursor WAIT_CURSOR = new java.awt.Cursor(
      java.awt.Cursor.
        WAIT_CURSOR);
    public static final java.awt.Cursor DEFAULT_CURSOR = new java.awt.Cursor(
      java.awt.Cursor.
        DEFAULT_CURSOR);
    public static final java.lang.String PROPERTY_OS_NAME = org.apache.batik.apps.svgbrowser.Resources.
      getString(
        "JSVGViewerFrame.property.os.name");
    public static final java.lang.String PROPERTY_OS_NAME_DEFAULT =
      org.apache.batik.apps.svgbrowser.Resources.
      getString(
        "JSVGViewerFrame.property.os.name.default");
    public static final java.lang.String PROPERTY_OS_WINDOWS_PREFIX =
      org.apache.batik.apps.svgbrowser.Resources.
      getString(
        "JSVGViewerFrame.property.os.windows.prefix");
    protected static final java.lang.String OPEN_TITLE = "Open.title";
    protected static java.util.Vector handlers;
    protected static org.apache.batik.apps.svgbrowser.SquiggleInputHandler
      defaultHandler =
      new org.apache.batik.apps.svgbrowser.SVGInputHandler(
      );
    protected static java.util.ResourceBundle bundle;
    protected static org.apache.batik.util.resources.ResourceManager
      resources;
    static { bundle = java.util.ResourceBundle.getBundle(RESOURCES,
                                                         java.util.Locale.
                                                           getDefault(
                                                             ));
             resources = new org.apache.batik.util.resources.ResourceManager(
                           bundle); }
    protected org.apache.batik.apps.svgbrowser.Application application;
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Canvas
      svgCanvas;
    protected class Canvas extends org.apache.batik.swing.JSVGCanvas {
        public Canvas(org.apache.batik.swing.svg.SVGUserAgent ua,
                      boolean eventsEnabled,
                      boolean selectableText) { super(ua, eventsEnabled,
                                                      selectableText);
        }
        public java.lang.Object getRhinoInterpreter() { if (bridgeContext ==
                                                              null) {
                                                            return null;
                                                        }
                                                        return bridgeContext.
                                                          getInterpreter(
                                                            "text/ecmascript");
        }
        protected class JSVGViewerDOMViewerController implements org.apache.batik.apps.svgbrowser.DOMViewerController {
            public boolean canEdit() { return getUpdateManager() !=
                                         null; }
            public org.apache.batik.apps.svgbrowser.ElementOverlayManager createSelectionManager() {
                if (canEdit(
                      )) {
                    return new org.apache.batik.apps.svgbrowser.ElementOverlayManager(
                      Canvas.this);
                }
                return null;
            }
            public org.w3c.dom.Document getDocument() {
                return Canvas.this.
                         svgDocument;
            }
            public void performUpdate(java.lang.Runnable r) {
                if (canEdit(
                      )) {
                    getUpdateManager(
                      ).
                      getUpdateRunnableQueue(
                        ).
                      invokeLater(
                        r);
                }
                else {
                    r.
                      run(
                        );
                }
            }
            public void removeSelectionOverlay(org.apache.batik.swing.gvt.Overlay selectionOverlay) {
                getOverlays(
                  ).
                  remove(
                    selectionOverlay);
            }
            public void selectNode(org.w3c.dom.Node node) {
                org.apache.batik.apps.svgbrowser.JSVGViewerFrame.DOMViewerAction dViewerAction =
                  (org.apache.batik.apps.svgbrowser.JSVGViewerFrame.DOMViewerAction)
                    getAction(
                      DOM_VIEWER_ACTION);
                dViewerAction.
                  openDOMViewer(
                    );
                domViewer.
                  selectNode(
                    node);
            }
            public JSVGViewerDOMViewerController() {
                super(
                  );
            }
            public static final java.lang.String
              jlc$CompilerVersion$jl7 =
              "2.7.0";
            public static final long jlc$SourceLastModified$jl7 =
              1445630120000L;
            public static final java.lang.String
              jlc$ClassType$jl7 =
              ("H4sIAAAAAAAAAMVYfWwUxxWfO38bG3+ADYVgwDEofN0VQUCVaQMYjE3O+Gob" +
               "RE2bY2537rx4b3fZnbPPJpQPqYXyB4rASWkS6B8lahJBSKtGbVOBXKUNidIU" +
               "QaM2IWrSqn8k/UAK/4RWtE3fzOze7u35jrqJVEuenZt5b957v3nz3pu5cAuV" +
               "WSZqNbAm4xAdM4gVirJ+FJsWkTtUbFkDMBqTTvzx9KE7v6k6EkTlg2jmELZ6" +
               "JGyRToWosjWIFiiaRbEmEWsHITLjiJrEIuYIpoquDaImxepOGaoiKbRHlwkj" +
               "2IXNCGrAlJpKPE1Jt70ARQsjXJsw1ya8yU/QHkE1km6MuQzzchg6PHOMNuXK" +
               "syiqj+zDIzicpooajigWbc+YaIWhq2NJVachkqGhfeqDNhDbIw/mwdD6Yt3H" +
               "dx8bqucwzMKaplNuotVHLF0dIXIE1bmjW1WSsvajr6OSCJrhIaaoLeIIDYPQ" +
               "MAh17HWpQPtaoqVTHTo3hzorlRsSU4iixbmLGNjEKXuZKNcZVqiktu2cGaxd" +
               "lLXW2W6fiY+vCE98+5H6H5agukFUp2j9TB0JlKAgZBAAJak4Ma1NskzkQdSg" +
               "wYb3E1PBqjJu73ajpSQ1TNPgAg4sbDBtEJPLdLGCnQTbzLREdTNrXoI7lf2r" +
               "LKHiJNja7NoqLOxk42BgtQKKmQkMvmezlA4rmsz9KJcja2Pbw0AArBUpQof0" +
               "rKhSDcMAahQuomItGe4H59OSQFqmgwua3NcKLMqwNrA0jJMkRtFcP11UTAFV" +
               "FQeCsVDU5CfjK8EuzfPtkmd/bu3YcPKA1qUFUQB0lomkMv1nAFOLj6mPJIhJ" +
               "4BwIxprlkSdw8+XjQYSAuMlHLGh+/OjtjStbJl8TNPOnoOmN7yMSjUnn4zOv" +
               "39ex7AslTI1KQ7cUtvk5lvNTFrVn2jMGRJrm7IpsMuRMTva9+pXDz5O/BlF1" +
               "NyqXdDWdAj9qkPSUoajE3EY0YmJK5G5URTS5g893owroRxSNiNHeRMIitBuV" +
               "qnyoXOe/AaIELMEgqoa+oiV0p29gOsT7GQMh1Aj/KIRQoA/xv0CUtRTtDw/p" +
               "KRLGEtYUTQ9HTZ3ZzzaUxxxiQV+GWUMPx8H/h1etDq0PW3raBIcM62YyjMEr" +
               "hoiYhB+GFbZGknFTH4X4GN7ev2vbLoWMErMTDi8JMdcz/h9CMwyJWaOBAGzS" +
               "ff4QocLp6tJVmZgxaSK9eevtF2JvCPdjR8bGkKKdIDkkJIe45BCTHHIlh3yS" +
               "2zqwNoKtNnd4S2+P6LB4Y+oqbD4KBLhWs5mawm1g04chfED8rlnW/7Xte4+3" +
               "loC/GqOlbN+AdGlePutw44yTHGLShet9d669Wf18EAUhFMUhn7lJpS0nqYic" +
               "aOoSkSGqFUovTogNF04oU+qBJs+MHtl16PNcD2+eYAuWQYhj7FEW3bMi2vzx" +
               "Yap16459+PGlJw7qbqTISTxOvszjZAGo1e8DfuNj0vJF+KXY5YNtQVQKUQ0i" +
               "OcVw8iBItvhl5ASidieoM1sqweCEbqawyqacSFxNh8Bh3BHunA2saRJ+ytzB" +
               "pyDPB1/sN86+/es/r+FIOqmjzpPz+wlt94QrtlgjD0wNrncNmIQA3e/PRE8/" +
               "fuvYHu5aQHH/VALbWNsBYQp2BxD8xmv733n/vfNvBV13pKjKMHUKx5fIGW7O" +
               "7E/gLwD//2b/LMqwARFtGjvskLcoG/MMJnypq14HOxUS94+2nRr4n5JQcFwl" +
               "7Dj8s27J6pf+drJe7LgKI47DrLz3Au745zajw288cqeFLxOQWPZ1IXTJREif" +
               "5a68yTTxGNMjc+TGgu9cxWchOUBAtpRxwmMs4pAgvodrORZh3q7xza1jTZvl" +
               "dfPck+SpkmLSY299VLvroyu3uba5ZZZ363uw0S4cSewCCAsj0WRjPv+y2WaD" +
               "tXMyoMMcf9zpwtYQLLZ2csdX69XJuyB2EMRKEHqtXhNiZCbHm2zqsoqbP3+l" +
               "ee/1EhTsRNWqjuVOzM8cqgJnJ9YQhNeM8dBGochoJTT1HA+UhxADfeHU27k1" +
               "ZVC+AeM/mfOjDd8/9x53ROF28212/mMJbx9gzQrhp6y7MpOFhimAGpw06Hw9" +
               "0HjWDPD+XIrW3jMBTBHfGcYLCpU7vFQ7f3TinNz7zGpRlDTmlhBboUK++Nt/" +
               "/Sp05g+vT5GTyu1y1dW2HOQtzksQPbwUdIPb+ht3St49NbcmPzewlVoKRP7l" +
               "hSO/X8DVo3+ZN/Clob3TCPoLfSj5l3yu58Lr25ZKp4K8mhXxPq8KzmVq9+IF" +
               "Qk0CZbvGzGIjtfy8tGadYj7zgVbY8AHbKQb850VE56k9DDbDSMfhEuh6WQ0S" +
               "lVfBBYsEid1F5gZZ82WKKqCA2iorlIcSz5azS2h/Om7RqKmkIBOM2CXypeY7" +
               "+39RMb7FKX+nYhGUD1s9117u+iDGt6+S+UcWNI9vbDKTngxWz5pVzN+XFbly" +
               "5moUPtj4/vDTH14UGvkrfB8xOT5x4pPQyQlxDsQ16P68m4iXR1yFfNotLiaF" +
               "c3R+cOngz549eCxo490NUMd1XSVYy+5HIFuONftxFNqWrz77j0PffLsX6odu" +
               "VJnWlP1p0i3nOmSFlY57gHXvTq572nqzHEpRYLlhh7v1rOkT/fb/Lq6ygY18" +
               "uCfrocvY1ENgx27bQ3cXcXnWDOQ7dyHWIg5sFpnjOT0FSVkyCRQI/cQO/z1Y" +
               "gxum6QTjdfcMxux5gmi0d4SYKh7zsnPwtE8N3gNsCqgCMRuB2PTBK8RaBKDD" +
               "ReaOsuYARTOShG7RpTQDwEFsNkNsdI0UkvVUKGeS4/Hop8ZjFptaDcZItlHS" +
               "9PEoxOqzOZCbmRt5vcDeNEJ9aU1j5R6XdbIIVKdY8y2KauHIsRp9pyGDu3HS" +
               "mB0r2AfKw9IRXZFdoE58NkB1gf7DtrXD0weqEGtxoFrzTo01qgBqyREasg8K" +
               "l/3dIsB9jzVPwgE1SUofcQ+ozc9mJ1y0nvps0FoFRui2yfr00SrEWhyteu+J" +
               "2QGRnUu6WASbH7DmWYqqLY4K4/Hh8dz08chQtKDoG4Kj7/r/8YUCktjcvHdT" +
               "8dYnvXCurnLOuZ2/49fg7HtcDVQFibSqenKZN6+VGyZJKByRGnEpMfjnZYoW" +
               "3UtHBl72B7fsp4L5MkVNUzLDCWUfL+2kvXleWorK+NdL9wpIc+mghBMdL8mr" +
               "FJUACeteNbKe4QYc8WKYCeTfQvh+N91rv7Ms3js4q5v4g7dTVqTFkzfUcOe2" +
               "7zhwe90z4g1AUvH4OFtlBhQT4qUhW08vLrias1Z517K7M1+sWuLUOTlvEF7d" +
               "uBvCweCX9Xm+G7HVlr0Yv3N+w5U3j5ffgAptDwpgimbt8Tw3C6TgWp2GYn9P" +
               "ZKqyCW4b/LLeXv2nvdf+fjPQyG94SBRaLcU4YtLpK+9GE4bxZBBVdaMyKONI" +
               "ZhBVK9aWMa2PSCNmThVWHtfTWvZtfCbza8wewzkyNqC12VH2PATBM7/WzH8y" +
               "g8svnK7NbHW2TK3vBpI2DO8sRzYp0g1DGnwtFukxDOfJ5JccecPggeAma4b+" +
               "A6VFZonVGgAA");
            public static final java.lang.String
              jlc$CompilerVersion$jl5 =
              "2.7.0";
            public static final long jlc$SourceLastModified$jl5 =
              1445630120000L;
            public static final java.lang.String
              jlc$ClassType$jl5 =
              ("H4sIAAAAAAAAAMVaeawkR3nvXXvX9mJ712tsHINPFoJpeD09V89oCXHP3dPH" +
               "HN0zPTMhLH0f0/c1M02cABIxCpJBwSZEAkuRQCTIHEIhiUSIHOUABIlCgkhA" +
               "CqAoUkgIEv4jJApJSHXPe2/ee7teixiUkaamuqq+qu/81ddV88z3oDNhAMGe" +
               "a200y432lHW0Z1qVvWjjKeFen6oMhSBU5KYlhCEH2q5ID3/q/A9++F79wmno" +
               "7AK6U3AcNxIiw3XCsRK6VqLIFHR+19q2FDuMoAuUKSQCEkeGhVBGGF2moJcc" +
               "IY2gS9QBCwhgAQEsIDkLCL4bBYhuU5zYbmYUghOFPvTL0CkKOutJGXsR9NDx" +
               "STwhEOz9aYa5BGCGm7PnKRAqJ14H0IOHsm9lvkrgp2Dkyd9484VP3wCdX0Dn" +
               "DYfN2JEAExFYZAHdaiu2qAQhLsuKvIDucBRFZpXAECwjzfleQBdDQ3OEKA6U" +
               "QyVljbGnBPmaO83dKmWyBbEUucGheKqhWPLB0xnVEjQg6907WbcSdrJ2IOA5" +
               "AzAWqIKkHJDcuDQcOYIeOElxKOMlEgwApDfZSqS7h0vd6AigAbq4tZ0lOBrC" +
               "RoHhaGDoGTcGq0TQvc87aaZrT5CWgqZciaB7To4bbrvAqFtyRWQkEXTXyWH5" +
               "TMBK956w0hH7fI95wxNvdXrO6ZxnWZGsjP+bAdH9J4jGiqoEiiMpW8JbX0u9" +
               "X7j7c+86DUFg8F0nBm/H/P4vPffo6+5/9gvbMS+/xpiBaCpSdEX6sHj7V17R" +
               "fKR+Q8bGzZ4bGpnxj0meu/9wv+fy2gORd/fhjFnn3kHns+M/n7/tY8p3T0Pn" +
               "COis5FqxDfzoDsm1PcNSgq7iKIEQKTIB3aI4cjPvJ6CbQJ0yHGXbOlDVUIkI" +
               "6EYrbzrr5s9ARSqYIlPRTaBuOKp7UPeESM/raw+CoIvgC+1B0KkxlH9ODbMy" +
               "gnxEd20FESTBMRwXGQZuJn9mUEcWkEgJQV0GvZ6LiMD/l69H9zAkdOMAOCTi" +
               "BhoiAK/QlW0nePBCJEw0MXBXoRIgfXbanRrKSgk6IHiVvcz1vP+PRdeZJi6s" +
               "Tp0CRnrFSYiwQHT1XEtWgivSk3Gj/dwnrnzp9GHI7OswgiZg5b3tynv5ynvZ" +
               "ynu7lfdOrHypKTiJEF7aNbcG9LaS4U3gWsD40KlTOVcvzdjcug0w+hLABwDW" +
               "Wx9hf7H/lnc9fAPwV291Y2Y3MBR5fnxv7gCHyGFVAl4PPfuB1dunv1I4DZ0+" +
               "DtSZaKDpXEY+zOD1EEYvnQzQa817/vHv/OCT73/M3YXqMeTfR5CrKTMEePik" +
               "EQJXUmSAqbvpX/ug8Jkrn3vs0mnoRgArAEojAbg+QKn7T65xDAkuH6BqJssZ" +
               "ILDqBrZgZV0HUHgu0oHFdi25d9ye1+8AOkagbXEYK/lv1nunl5Uv3XpTZrQT" +
               "UuSo/XOs96G/+8t/LuXqPgD480e2TFaJLh8BlWyy8zl83LHzAS5QFDDu7z8w" +
               "fN9T33v8F3IHACNeea0FL2VlE4AJMCFQ8zu/4H/9W9/88FdP75wmArtqLFqG" +
               "tN4K+SPwOQW+/5N9M+Gyhi0gXGzuo9KDh7DkZSu/esdbM3NcKfegSxPHdmVD" +
               "NQTRUjKP/a/zr0I/869PXNj6hAVaDlzqdS88wa79ZxrQ27705n+/P5/mlJRt" +
               "kDv97YZtUffO3cx4EAibjI/12//6vt/8vPAhgN8AM0MjVXIYhHJ9QLkBC7ku" +
               "4LxETvQVs+KB8GggHI+1I4nMFem9X/3+bdPv/9FzObfHM6GjdqcF7/LW1bLi" +
               "wTWY/mUno74nhDoYV36WedMF69kfghkXYEYJAF84CABCrY95yf7oMzd944//" +
               "5O63fOUG6HQHOme5gtwR8oCDbgGeroQ6ALe19/OPbt15dTMoLuSiQlcJv3WQ" +
               "e/KnGwCDjzw/1nSyRGYXrvf858AS3/EP/3GVEnKUucb+fYJ+gTzzwXubb/xu" +
               "Tr8L94z6/vXVqA2Svh1t8WP2v51++OyfnYZuWkAXpP2McipYcRZEC5BFhQdp" +
               "Jsg6j/Ufz4i22//lQzh7xUmoObLsSaDZ7Ragno3O6ud2Bn9kfQoE4pniHrZX" +
               "yJ4fzQkfystLWfGzW61n1deAiA3zzBRQqIYjWPk8j0TAYyzp0kGMTkGmClR8" +
               "ybSwfJq7QG6ee0cmzN42vdtiVVaWtlzk9erzesPlA16B9W/fTUa5IFN89z++" +
               "98vveeW3gIn60JkkUx+wzJEVmThLnn/1mafue8mT3353DkBZqvH+9oVHs1nJ" +
               "60mcFa2saB+Iem8mKptv+5QQRnSOE4qcS3tdzxwGhg2gNdnPDJHHLn5r+cHv" +
               "fHyb9Z10wxODlXc9+Ws/2nviydNHcu1XXpXuHqXZ5ts507ftaziAHrreKjlF" +
               "558++dhnf/uxx7dcXTyeObbBi9HHv/bfX977wLe/eI1U5EbLfRGGjW77dq8c" +
               "EvjBh57OVX41Wa95dVCqid0SjLfmU23VarsqU5iOJs2pMKLnZrs0gLuuOG4X" +
               "xXmxUsKCdVksqQtHHA773mjoz2ebRjnAWX7JVhs1S9D7DZaMuuJ00JiRE8aQ" +
               "iclIoIsEH7C+U1siE5xEymM+apfUdJAqWFyqmIHfn7ZjxVlEFbFewZKSk5a8" +
               "uCLh8ZRnFz4j4nZ5jct0WZsaQR/u9EN+yUUTsbNs0Q2f45J0XSfbWFJdVttL" +
               "ztKKpt2mFtV+dzPmXN4NTZ7oGIYwFtt2mw97BEeZRj9oE/Gc8Fw/bgmEvVa8" +
               "QVdwDVIc96zV0iwSM6bZDXCr75HDNtqPsAI+HoXmrB+u0I1Q20yQUW/ZRpd2" +
               "lY5HaSrpWnXYG9BMPCPDjeGbcNoiUkPyXFcwDY0XJXguELzuF5n+FGSTS7+r" +
               "q4rfYvSWSKwQeyW3qvOo1JPXNdGPpVVKk4JnMbEbTXtUpyATM6KNirbJozwb" +
               "JoIZVAdssx/ohCC4lEIQrflwROM6ivV4YJVIcP0p1+Pckp66gTUO2UnZMNai" +
               "TXUZs03O4gXJSIupbyyjuCh1hbVsUTO+yFdVYw4nzXa9Bld61V5F0OJlZ+IV" +
               "zTrXKPQtEtcWDRzvC8syLaBMuEyXI5nVVnOx1EaHDd/sx1hJMD12hHLMUMO1" +
               "cii2GlG7P6Rkqtt0RpyYUuO2zDHBzCUwSy0GFNkz+owpYIzrU4P1slxsaNGI" +
               "JO3Rkk5sJbXwcmCHaZ3sS6ZQHIqrAo4HjYk3ctVCQOpsS6JxQR/Frk1EXaXc" +
               "q9QH7Kjj29oqFkqMRFK0v2ICvGD26eU46khDFJ1weGfaGSnNcNqaVJqqSdba" +
               "caoOo6UtI2JcmktDEkf9SWcyahQs1waMoA7eGVBm1R72Cb1fbqyItRdYS1Ze" +
               "1eCZOZqzeExbPaqrw8jAjEw2EvtWDahg4LgDm8E2NGtOHKecDpJSXVljeGhx" +
               "BEqOMGkSJcuKlTBcJ5g6RZPujvuBjRFeSMdjmkuEOuzNWmllgDSsDsps/Jnc" +
               "4mXcrPvLITsBntUuteeFud0nK93KZMyxFa1WL7mrwB2vWcZgesqYJoyoEU99" +
               "Z+POBgqCC0Sbotua7wqwa0wLXrGuDUIO645oHcVNhCTGIxdH1kmhOYnGXNRa" +
               "IR45prrtaD7hRvUetygt0lQAuLE2RlO4y0/o4brWQ3RUiVp+YciXAqFBSHS1" +
               "ON+YdDvQXWOuN+BuR1x0l06H65Vn5S6DKUkxESmXByNormXU+rQspYheb9Kr" +
               "TZ8XBg28m7KqWh65EuVVo/7UXmhrgSXripJEnWI/aQ5lcwxga0mSMtFaLvuE" +
               "Uq40mlyvR1h6acMWU2B3l4wYRy6zRXhYpRrlOez6YqtMNiidDyu2sLJRrVCW" +
               "dLXdqgWWwyPYLFLKcMlym0jXB4kNA+Ny11KGcbQqlzdcr0uxuhLV5Wq1zqto" +
               "rY1P9A490R0MoARbcPy5IQkDl12yXb8zcRPO1ZhOoexOYL/RD2G6F1lodchI" +
               "rSKszPGYH811E+u0+ZJIG0WAYXPBQ6vlSh0edq3+CvNFnyNYbj1IwtRc4F0X" +
               "VWotNWbMQtLvwORsXpkz0Wg6IiejgjGQpqua0SCiRLcqOGvIhuLSaOivlGZb" +
               "9IXVxhcktrNm9FpDLzV6sYMXQ2HchzdR2vA2rWEDRUKmVoURsNEFcIcY+LaZ" +
               "esMUXllRvTwKIkszWwUQSo7E2MQILynIcNyuIWqczHtxRRj1esgUp0SeCRvz" +
               "kVdsrFu1tZ1gpZKDJCqTNKZoySNNku5NyHVFJbo8NsDaiEatWghSFJEsTvFx" +
               "J+qaSbikJLeL0HTf2Xg+Wu4N1hO2XoaLzjgoO5X+SOqsLKxl1sIi1q96KiwH" +
               "fQWjNJIoY62ASkt4jJUrqWCuirWa5Csdaj0Y8cMFSsy4/rhtqBWhWttw3LrL" +
               "0KYEc10trktrXtIHkwYeeeP1yqbDsodriSsHg/FCL/nYOhVQk1sklqwOpSXM" +
               "ekubYufFen1KJYG7iUuxKFQWi0WpWopXBbYsscqq2cRDs8CPzWECb4q80Ipm" +
               "9MalaUmtp94qmo8oalGUQnlWrc/68aZRbNNjst3zo5nOGIum2LOBE4fAZYcl" +
               "2FIUBG3rXDhmeN+Mp4OUBqJpfadfn490RqFrcqPrSrrb5zi0h8MTfY23VKU3" +
               "KWJLdDFtwrhCI7Y6MFtyDamvK6XxoFOsFdEiYtN9cV3X0lGge9UNRnuDjm7Y" +
               "eNdbFaq9Vb3QM/nWsAXPiIAvmXSDa/TUrjSnmt4ESzojTC1xhsOkWNr1xlaL" +
               "sy29IboTEoaZCEFYr1DR4ISrdLlNjG5QmS/2BqMoXYYjgOQTmRiKsB6V2Khc" +
               "Z0TJHqbKypq65HiIWTo7QGa11tQtwQsGaVquWOKaQ5dSWbNilTZxpUYFxcqC" +
               "9MpkzdZn66FfI1N76tdhojNaFpoLMemmXcKM1E0t6gry3MRSbSrOa3hPJEdi" +
               "rVKYtivVZb3VElssrertWK/yowJrTdVGYx62DRntVLTFolbkSdJv4kUD7KOE" +
               "xKYVIWWLOjKwsbFP2kuiMaCLzRnI7+YYXKqPaRHrkDPYmevdSQsN6yiKxbDR" +
               "6kZVmIUnEs8Q9URskZyjrfm04k1TBp51RGtTsd3JMDLLSNLiemh50k2Wgdqo" +
               "rQdcZV32hqPNyFq3whHAj2rNLhuzMbrpqIwbUYbQkUpjWBo4Wlop15Xm2i3X" +
               "C8yEltEZO51vwEZOdOIBo0brDuPzQYphZmGoqlQ4q7pyPO07vDVEvYJRcgY2" +
               "27HmFUzrzRLOr2BFx097bW88pyxdxxI0GCw5RAWx6lc32hytxU01cKVkjrYZ" +
               "bV3ExFFJmkkzh28NRpi86fGEVgk7nmMOuEKHnS43zfGIQKTRAEnRubaO7eqI" +
               "M2VVotfxuqLZRgEg9ZzUsTR0hquoXWNKGhM2fa1Jj+NGccg1yNpYaJCt1lgR" +
               "BmE8x8fcgNW72NjjRq1VuxMySyaUicJkmUwnZFdhy0jP9WoLs+NFQktaEJHV" +
               "Y+vDtrse+OkABJg9jiqJ1FKYdr8uTFCzMq7OZJEgpqQ8r22KpBD3iHDs1b1N" +
               "txWXeqzdKARFXCVXdWI8W3Rkt12pMcsGqqlYKwpmAB4Vv92N1m4nSDm3gPpa" +
               "w9+M20Ko1UgLKclE2Kib6XS40too2L1VaQS7qVS3++im4CReWOi4nXFsFDdq" +
               "UCiwQZvXN5ESw/3iqDt2JnGVx1mxh7Vsfu771LxMAvn0mpwWapI+isiW2y2T" +
               "JoYESG0+aS4jU0p6MleT504ya8aBQw3iRREp11UN60VSazrqGCLrKw65YKrw" +
               "tLtZ9MnGZtx12h6tms5i7vKlSdRrWFixgamhV6Yq9HLKTFKq1eQnKgUXl8nM" +
               "Ung3IGFGpuorj5BgW9MbtEzV7KDTn+BNJVIYkVTKo7lU48l5U+HUUaLDTB0N" +
               "EowOS2ZY9itJWcNkbupznWWqTqSBUsRSfaXUC2lZQ/FJ0isPOpHV0Edc2Z/o" +
               "fKGWUIEhhOiigmIkRqNwyMfUZMBZSbuDyXEjaYI9b1af2XAX602toDBPSgy8" +
               "qkxKZkVVNdwDOY2nGbYY1bhVqVnlNN4rdudOfbgg/U2TLwMHp5RZUnQSWYVV" +
               "E8Ret15mG2OBkibleUR5JFzvtsvietFoTGWB3pADhljojSlZF3gaJKlsk7E5" +
               "fcr3IpXjk0WkNsVUqK2UVbrcMH4TLU57xSHONWgM4dNebaPVwsQhMUbs8UWO" +
               "LCUNjyi2BrVwnM69goa2us4q6sTLdWug9it9SVKkoaYpuC2URRivTjsL15l2" +
               "NRzPXvXe9OO9bd+RHywcXiKBl+yso/tjvGWur73gqQi6xQvcSJEiRV4fnrJm" +
               "hFllexNx8HvklPXISdSpg9ON8guewV/jiD17H7/v+W6c8nfxD7/jyaflwUfQ" +
               "0/vHf3wEnd2/CNwxcRZM89rnP3Sg89u23ZnU59/xL/dyb9Tf8mOcuj9wgsmT" +
               "U/4O/cwXu6+Wfv00dMPhCdVV94DHiS4fP5c6FygRAADu2OnUfYc2eXlmgoeB" +
               "vrl9m3DXPvm+tp1zx9q603WOVpPr9OWFH0E3SYLTlo3tnfD4iN9NQZ/oupYi" +
               "ODufDF7o5OPoMnmDcyjxI1njzwPmZ/sSz37yEr/zOn2PZ8XbIuhuKVCESGGV" +
               "/ZNtWnAEbd/9gN9XX9Dvs6t5xYkGiRJYwuYoea6jt78IHb0maywBca/s6+jK" +
               "T15H77tO31NZ8UQEvUQDL5auFGdyHijmpZliViVpT3btvWOdudjveRFi35k1" +
               "okACaV9s6Scj9qnjkHZxd3w6jh0nuwfJyX7rOhr5SFZ8MIJu85Qgu96aeDJw" +
               "nmtFy42Ja8g7fXzoxeqjBzhf7utj+VPRx8NXuXq4MoBytCTa2/fufJpPX0c/" +
               "v5cVHwdRFSi2m+yiap8+6/3oTimfeLFKeT1g391XivtTUcqFo27OuPLWRZ69" +
               "jgr+NCs+G0Hnwlz4jOaE2H/444i9jqD7rnuPfcAp9n+8JQeb6z1X/Xdn+38T" +
               "6RNPn7/5ZU9P/ja/CT78T8gtFHSzGlvW0WuXI/WzXqCoRq6LW7aXMF7+8xcR" +
               "9OAL8Zip7fAhl+zLW+K/iqC7rkkMIi37OTr2b/bNdnRsBJ3Jf4+O+xpYbTcO" +
               "ZB7bytEhX4+gG8CQrPoN7xo3Pdtrq/WpI9nKvqfmlr74QpY+JDl6w5xlOPmf" +
               "rg6ykXj7t6sr0ief7jNvfa76ke0Nt2QJaZrNcjMF3bS9bD/MaB563tkO5jrb" +
               "e+SHt3/qllcdpF63bxneRc0R3h649hVy2/ai/NI3/YOX/e4bPvr0N/OLp/8F" +
               "DcCIPA0nAAA=");
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
           "P37f/OGbfv8dv/3it/NTqf8FbwklxW0gAAA=");
    }
    protected javax.swing.JPanel svgCanvasPanel;
    protected javax.swing.JWindow window;
    protected static javax.swing.JFrame memoryMonitorFrame;
    protected java.io.File currentPath = new java.io.File(
      "");
    protected java.io.File currentSavePath =
      new java.io.File(
      "");
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.BackAction
      backAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.BackAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ForwardAction
      forwardAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ForwardAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PlayAction
      playAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PlayAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PauseAction
      pauseAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PauseAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.StopAction
      stopAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.StopAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PreviousTransformAction
      previousTransformAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PreviousTransformAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.NextTransformAction
      nextTransformAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.NextTransformAction(
      );
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.UseStylesheetAction
      useStylesheetAction =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.UseStylesheetAction(
      );
    protected boolean debug;
    protected boolean autoAdjust = true;
    protected boolean managerStopped;
    protected org.apache.batik.swing.svg.SVGUserAgent
      userAgent =
      new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.UserAgent(
      );
    protected org.w3c.dom.svg.SVGDocument
      svgDocument;
    protected org.apache.batik.util.gui.URIChooser
      uriChooser;
    protected org.apache.batik.apps.svgbrowser.DOMViewer
      domViewer;
    protected org.apache.batik.apps.svgbrowser.FindDialog
      findDialog;
    protected org.apache.batik.apps.svgbrowser.ThumbnailDialog
      thumbnailDialog;
    protected org.apache.batik.ext.swing.JAffineTransformChooser.Dialog
      transformDialog;
    protected org.apache.batik.util.gui.LocationBar
      locationBar;
    protected org.apache.batik.apps.svgbrowser.StatusBar
      statusBar;
    protected java.lang.String title;
    protected org.apache.batik.apps.svgbrowser.LocalHistory
      localHistory;
    protected org.apache.batik.apps.svgbrowser.TransformHistory
      transformHistory =
      new org.apache.batik.apps.svgbrowser.TransformHistory(
      );
    protected java.lang.String alternateStyleSheet;
    protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Debugger
      debugger;
    public JSVGViewerFrame(org.apache.batik.apps.svgbrowser.Application app) {
        super(
          );
        application =
          app;
        addWindowListener(
          new java.awt.event.WindowAdapter(
            ) {
              public void windowClosing(java.awt.event.WindowEvent e) {
                  application.
                    closeJSVGViewerFrame(
                      JSVGViewerFrame.this);
              }
          });
        svgCanvas =
          new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Canvas(
            userAgent,
            true,
            true) {
              java.awt.Dimension
                screenSize;
              {
                  screenSize =
                    java.awt.Toolkit.
                      getDefaultToolkit(
                        ).
                      getScreenSize(
                        );
                  setMaximumSize(
                    screenSize);
              }
              public java.awt.Dimension getPreferredSize() {
                  java.awt.Dimension s =
                    super.
                    getPreferredSize(
                      );
                  if (s.
                        width >
                        screenSize.
                          width)
                      s.
                        width =
                        screenSize.
                          width;
                  if (s.
                        height >
                        screenSize.
                          height)
                      s.
                        height =
                        screenSize.
                          height;
                  return s;
              }
              public void setMySize(java.awt.Dimension d) {
                  setPreferredSize(
                    d);
                  invalidate(
                    );
                  if (JSVGViewerFrame.this.
                        autoAdjust) {
                      org.apache.batik.util.Platform.
                        unmaximize(
                          JSVGViewerFrame.this);
                      JSVGViewerFrame.this.
                        pack(
                          );
                  }
              }
              public void setDisableInteractions(boolean b) {
                  super.
                    setDisableInteractions(
                      b);
                  ((javax.swing.Action)
                     listeners.
                     get(
                       SET_TRANSFORM_ACTION)).
                    setEnabled(
                      !b);
                  if (thumbnailDialog !=
                        null)
                      thumbnailDialog.
                        setInteractionEnabled(
                          !b);
              }
          };
        javax.swing.ActionMap map =
          svgCanvas.
          getActionMap(
            );
        map.
          put(
            FULL_SCREEN_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.FullScreenAction(
              ));
        javax.swing.InputMap imap =
          svgCanvas.
          getInputMap(
            javax.swing.JComponent.
              WHEN_FOCUSED);
        javax.swing.KeyStroke key =
          javax.swing.KeyStroke.
          getKeyStroke(
            java.awt.event.KeyEvent.
              VK_F11,
            0);
        imap.
          put(
            key,
            FULL_SCREEN_ACTION);
        svgCanvas.
          setDoubleBufferedRendering(
            true);
        listeners.
          put(
            ABOUT_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.AboutAction(
              ));
        listeners.
          put(
            OPEN_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.OpenAction(
              ));
        listeners.
          put(
            OPEN_LOCATION_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.OpenLocationAction(
              ));
        listeners.
          put(
            NEW_WINDOW_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.NewWindowAction(
              ));
        listeners.
          put(
            RELOAD_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ReloadAction(
              ));
        listeners.
          put(
            SAVE_AS_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.SaveAsAction(
              ));
        listeners.
          put(
            BACK_ACTION,
            backAction);
        listeners.
          put(
            FORWARD_ACTION,
            forwardAction);
        listeners.
          put(
            PRINT_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PrintAction(
              ));
        listeners.
          put(
            EXPORT_AS_JPG_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ExportAsJPGAction(
              ));
        listeners.
          put(
            EXPORT_AS_PNG_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ExportAsPNGAction(
              ));
        listeners.
          put(
            EXPORT_AS_TIFF_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ExportAsTIFFAction(
              ));
        listeners.
          put(
            PREFERENCES_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.PreferencesAction(
              ));
        listeners.
          put(
            CLOSE_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.CloseAction(
              ));
        listeners.
          put(
            EXIT_ACTION,
            application.
              createExitAction(
                this));
        listeners.
          put(
            VIEW_SOURCE_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ViewSourceAction(
              ));
        javax.swing.ActionMap cMap =
          svgCanvas.
          getActionMap(
            );
        listeners.
          put(
            RESET_TRANSFORM_ACTION,
            cMap.
              get(
                org.apache.batik.swing.JSVGCanvas.
                  RESET_TRANSFORM_ACTION));
        listeners.
          put(
            ZOOM_IN_ACTION,
            cMap.
              get(
                org.apache.batik.swing.JSVGCanvas.
                  ZOOM_IN_ACTION));
        listeners.
          put(
            ZOOM_OUT_ACTION,
            cMap.
              get(
                org.apache.batik.swing.JSVGCanvas.
                  ZOOM_OUT_ACTION));
        listeners.
          put(
            PREVIOUS_TRANSFORM_ACTION,
            previousTransformAction);
        key =
          javax.swing.KeyStroke.
            getKeyStroke(
              java.awt.event.KeyEvent.
                VK_K,
              java.awt.event.KeyEvent.
                CTRL_MASK);
        imap.
          put(
            key,
            previousTransformAction);
        listeners.
          put(
            NEXT_TRANSFORM_ACTION,
            nextTransformAction);
        key =
          javax.swing.KeyStroke.
            getKeyStroke(
              java.awt.event.KeyEvent.
                VK_L,
              java.awt.event.KeyEvent.
                CTRL_MASK);
        imap.
          put(
            key,
            nextTransformAction);
        listeners.
          put(
            USE_STYLESHEET_ACTION,
            useStylesheetAction);
        listeners.
          put(
            PLAY_ACTION,
            playAction);
        listeners.
          put(
            PAUSE_ACTION,
            pauseAction);
        listeners.
          put(
            STOP_ACTION,
            stopAction);
        listeners.
          put(
            MONITOR_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.MonitorAction(
              ));
        listeners.
          put(
            DOM_VIEWER_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.DOMViewerAction(
              ));
        listeners.
          put(
            SET_TRANSFORM_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.SetTransformAction(
              ));
        listeners.
          put(
            FIND_DIALOG_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.FindDialogAction(
              ));
        listeners.
          put(
            THUMBNAIL_DIALOG_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ThumbnailDialogAction(
              ));
        listeners.
          put(
            FLUSH_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.FlushAction(
              ));
        listeners.
          put(
            TOGGLE_DEBUGGER_ACTION,
            new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ToggleDebuggerAction(
              ));
        javax.swing.JPanel p =
          null;
        try {
            org.apache.batik.util.gui.resource.MenuFactory mf =
              new org.apache.batik.util.gui.resource.MenuFactory(
              bundle,
              this);
            javax.swing.JMenuBar mb =
              mf.
              createJMenuBar(
                "MenuBar",
                application.
                  getUISpecialization(
                    ));
            setJMenuBar(
              mb);
            localHistory =
              new org.apache.batik.apps.svgbrowser.LocalHistory(
                mb,
                this);
            java.lang.String[] uri =
              application.
              getVisitedURIs(
                );
            for (int i =
                   0;
                 i <
                   uri.
                     length;
                 i++) {
                if (uri[i] !=
                      null &&
                      !"".
                      equals(
                        uri[i])) {
                    localHistory.
                      update(
                        uri[i]);
                }
            }
            p =
              new javax.swing.JPanel(
                new java.awt.BorderLayout(
                  ));
            org.apache.batik.util.gui.resource.ToolBarFactory tbf =
              new org.apache.batik.util.gui.resource.ToolBarFactory(
              bundle,
              this);
            javax.swing.JToolBar tb =
              tbf.
              createJToolBar(
                "ToolBar");
            tb.
              setFloatable(
                false);
            getContentPane(
              ).
              add(
                p,
                java.awt.BorderLayout.
                  NORTH);
            p.
              add(
                tb,
                java.awt.BorderLayout.
                  NORTH);
            p.
              add(
                new javax.swing.JSeparator(
                  ),
                java.awt.BorderLayout.
                  CENTER);
            p.
              add(
                locationBar =
                  new org.apache.batik.util.gui.LocationBar(
                    ),
                java.awt.BorderLayout.
                  SOUTH);
            locationBar.
              setBorder(
                javax.swing.BorderFactory.
                  createEmptyBorder(
                    2,
                    2,
                    2,
                    2));
        }
        catch (java.util.MissingResourceException e) {
            java.lang.System.
              out.
              println(
                e.
                  getMessage(
                    ));
            java.lang.System.
              exit(
                0);
        }
        svgCanvasPanel =
          new javax.swing.JPanel(
            new java.awt.BorderLayout(
              ));
        svgCanvasPanel.
          setBorder(
            javax.swing.BorderFactory.
              createEtchedBorder(
                ));
        svgCanvasPanel.
          add(
            svgCanvas,
            java.awt.BorderLayout.
              CENTER);
        p =
          new javax.swing.JPanel(
            new java.awt.BorderLayout(
              ));
        p.
          add(
            svgCanvasPanel,
            java.awt.BorderLayout.
              CENTER);
        p.
          add(
            statusBar =
              new org.apache.batik.apps.svgbrowser.StatusBar(
                ),
            java.awt.BorderLayout.
              SOUTH);
        getContentPane(
          ).
          add(
            p,
            java.awt.BorderLayout.
              CENTER);
        svgCanvas.
          addSVGDocumentLoaderListener(
            this);
        svgCanvas.
          addGVTTreeBuilderListener(
            this);
        svgCanvas.
          addSVGLoadEventDispatcherListener(
            this);
        svgCanvas.
          addGVTTreeRendererListener(
            this);
        svgCanvas.
          addLinkActivationListener(
            this);
        svgCanvas.
          addUpdateManagerListener(
            this);
        svgCanvas.
          addMouseMotionListener(
            new java.awt.event.MouseMotionAdapter(
              ) {
                public void mouseMoved(java.awt.event.MouseEvent e) {
                    if (svgDocument ==
                          null) {
                        statusBar.
                          setXPosition(
                            e.
                              getX(
                                ));
                        statusBar.
                          setYPosition(
                            e.
                              getY(
                                ));
                    }
                    else {
                        try {
                            java.awt.geom.AffineTransform at;
                            at =
                              svgCanvas.
                                getViewBoxTransform(
                                  );
                            if (at !=
                                  null) {
                                at =
                                  at.
                                    createInverse(
                                      );
                                java.awt.geom.Point2D p2d =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      e.
                                        getX(
                                          ),
                                      e.
                                        getY(
                                          )),
                                    null);
                                statusBar.
                                  setXPosition(
                                    (float)
                                      p2d.
                                      getX(
                                        ));
                                statusBar.
                                  setYPosition(
                                    (float)
                                      p2d.
                                      getY(
                                        ));
                                return;
                            }
                        }
                        catch (java.awt.geom.NoninvertibleTransformException ex) {
                            
                        }
                        statusBar.
                          setXPosition(
                            e.
                              getX(
                                ));
                        statusBar.
                          setYPosition(
                            e.
                              getY(
                                ));
                    }
                }
            });
        svgCanvas.
          addMouseListener(
            new java.awt.event.MouseAdapter(
              ) {
                public void mouseExited(java.awt.event.MouseEvent e) {
                    java.awt.Dimension dim =
                      svgCanvas.
                      getSize(
                        );
                    if (svgDocument ==
                          null) {
                        statusBar.
                          setWidth(
                            dim.
                              width);
                        statusBar.
                          setHeight(
                            dim.
                              height);
                    }
                    else {
                        try {
                            java.awt.geom.AffineTransform at;
                            at =
                              svgCanvas.
                                getViewBoxTransform(
                                  );
                            if (at !=
                                  null) {
                                at =
                                  at.
                                    createInverse(
                                      );
                                java.awt.geom.Point2D o =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      0,
                                      0),
                                    null);
                                java.awt.geom.Point2D p2d =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      dim.
                                        width,
                                      dim.
                                        height),
                                    null);
                                statusBar.
                                  setWidth(
                                    (float)
                                      (p2d.
                                         getX(
                                           ) -
                                         o.
                                         getX(
                                           )));
                                statusBar.
                                  setHeight(
                                    (float)
                                      (p2d.
                                         getY(
                                           ) -
                                         o.
                                         getY(
                                           )));
                                return;
                            }
                        }
                        catch (java.awt.geom.NoninvertibleTransformException ex) {
                            
                        }
                        statusBar.
                          setWidth(
                            dim.
                              width);
                        statusBar.
                          setHeight(
                            dim.
                              height);
                    }
                }
            });
        svgCanvas.
          addComponentListener(
            new java.awt.event.ComponentAdapter(
              ) {
                public void componentResized(java.awt.event.ComponentEvent e) {
                    java.awt.Dimension dim =
                      svgCanvas.
                      getSize(
                        );
                    if (svgDocument ==
                          null) {
                        statusBar.
                          setWidth(
                            dim.
                              width);
                        statusBar.
                          setHeight(
                            dim.
                              height);
                    }
                    else {
                        try {
                            java.awt.geom.AffineTransform at;
                            at =
                              svgCanvas.
                                getViewBoxTransform(
                                  );
                            if (at !=
                                  null) {
                                at =
                                  at.
                                    createInverse(
                                      );
                                java.awt.geom.Point2D o =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      0,
                                      0),
                                    null);
                                java.awt.geom.Point2D p2d =
                                  at.
                                  transform(
                                    new java.awt.geom.Point2D.Float(
                                      dim.
                                        width,
                                      dim.
                                        height),
                                    null);
                                statusBar.
                                  setWidth(
                                    (float)
                                      (p2d.
                                         getX(
                                           ) -
                                         o.
                                         getX(
                                           )));
                                statusBar.
                                  setHeight(
                                    (float)
                                      (p2d.
                                         getY(
                                           ) -
                                         o.
                                         getY(
                                           )));
                                return;
                            }
                        }
                        catch (java.awt.geom.NoninvertibleTransformException ex) {
                            
                        }
                        statusBar.
                          setWidth(
                            dim.
                              width);
                        statusBar.
                          setHeight(
                            dim.
                              height);
                    }
                }
            });
        locationBar.
          addActionListener(
            new javax.swing.AbstractAction(
              ) {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    java.lang.String st =
                      locationBar.
                      getText(
                        ).
                      trim(
                        );
                    int i =
                      st.
                      indexOf(
                        '#');
                    java.lang.String t =
                      "";
                    if (i !=
                          -1) {
                        t =
                          st.
                            substring(
                              i +
                                1);
                        st =
                          st.
                            substring(
                              0,
                              i);
                    }
                    if (st.
                          equals(
                            ""))
                        return;
                    try {
                        java.io.File f =
                          new java.io.File(
                          st);
                        if (f.
                              exists(
                                )) {
                            if (f.
                                  isDirectory(
                                    )) {
                                return;
                            }
                            else {
                                try {
                                    st =
                                      f.
                                        getCanonicalPath(
                                          );
                                    if (st.
                                          startsWith(
                                            "/")) {
                                        st =
                                          "file:" +
                                          st;
                                    }
                                    else {
                                        st =
                                          "file:/" +
                                          st;
                                    }
                                }
                                catch (java.io.IOException ex) {
                                    
                                }
                            }
                        }
                    }
                    catch (java.lang.SecurityException se) {
                        
                    }
                    java.lang.String fi =
                      svgCanvas.
                      getFragmentIdentifier(
                        );
                    if (svgDocument !=
                          null) {
                        org.apache.batik.util.ParsedURL docPURL =
                          new org.apache.batik.util.ParsedURL(
                          svgDocument.
                            getURL(
                              ));
                        org.apache.batik.util.ParsedURL purl =
                          new org.apache.batik.util.ParsedURL(
                          docPURL,
                          st);
                        fi =
                          fi ==
                            null
                            ? ""
                            : fi;
                        if (docPURL.
                              equals(
                                purl) &&
                              t.
                              equals(
                                fi)) {
                            return;
                        }
                    }
                    if (t.
                          length(
                            ) !=
                          0) {
                        st +=
                          '#' +
                          t;
                    }
                    locationBar.
                      setText(
                        st);
                    locationBar.
                      addToHistory(
                        st);
                    showSVGDocument(
                      st);
                }
            });
    }
    public void dispose() { hideDebugger(
                              );
                            svgCanvas.dispose(
                                        );
                            super.dispose(
                                    ); }
    public void setDebug(boolean b) { debug =
                                        b;
    }
    public void setAutoAdjust(boolean b) {
        autoAdjust =
          b;
    }
    public org.apache.batik.swing.JSVGCanvas getJSVGCanvas() {
        return svgCanvas;
    }
    private static java.io.File makeAbsolute(java.io.File f) {
        if (!f.
              isAbsolute(
                )) {
            return f.
              getAbsoluteFile(
                );
        }
        return f;
    }
    public void showDebugger() { if (debugger ==
                                       null &&
                                       org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Debugger.
                                         isPresent) {
                                     debugger =
                                       new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.Debugger(
                                         this,
                                         locationBar.
                                           getText(
                                             ));
                                     debugger.
                                       initialize(
                                         );
                                 } }
    public void hideDebugger() { if (debugger !=
                                       null) {
                                     debugger.
                                       clearAllBreakpoints(
                                         );
                                     debugger.
                                       go(
                                         );
                                     debugger.
                                       dispose(
                                         );
                                     debugger =
                                       null;
                                 } }
    protected static class Debugger {
        protected static boolean isPresent;
        protected static java.lang.Class debuggerClass;
        protected static java.lang.Class contextFactoryClass;
        protected static final int CLEAR_ALL_BREAKPOINTS_METHOD =
          0;
        protected static final int GO_METHOD =
          1;
        protected static final int SET_EXIT_ACTION_METHOD =
          2;
        protected static final int ATTACH_TO_METHOD =
          3;
        protected static final int DETACH_METHOD =
          4;
        protected static final int DISPOSE_METHOD =
          5;
        protected static final int GET_DEBUG_FRAME_METHOD =
          6;
        protected static java.lang.reflect.Constructor
          debuggerConstructor;
        protected static java.lang.reflect.Method[]
          debuggerMethods;
        protected static java.lang.Class rhinoInterpreterClass;
        protected static java.lang.reflect.Method
          getContextFactoryMethod;
        static { try { java.lang.Class dc =
                         java.lang.Class.
                         forName(
                           "org.mozilla.javascript.tools.debugger.Main");
                       java.lang.Class cfc =
                         java.lang.Class.
                         forName(
                           "org.mozilla.javascript.ContextFactory");
                       rhinoInterpreterClass =
                         java.lang.Class.
                           forName(
                             "org.apache.batik.script.rhino.RhinoInterpreter");
                       debuggerConstructor =
                         dc.
                           getConstructor(
                             new java.lang.Class[] { java.lang.String.class });
                       debuggerMethods = (new java.lang.reflect.Method[] { dc.
                                            getMethod(
                                              "clearAllBreakpoints",
                                              (java.lang.Class[])
                                                null),
                                          dc.
                                            getMethod(
                                              "go",
                                              (java.lang.Class[])
                                                null),
                                          dc.
                                            getMethod(
                                              "setExitAction",
                                              new java.lang.Class[] { java.lang.Runnable.class }),
                                          dc.
                                            getMethod(
                                              "attachTo",
                                              new java.lang.Class[] { cfc }),
                                          dc.
                                            getMethod(
                                              "detach",
                                              (java.lang.Class[])
                                                null),
                                          dc.
                                            getMethod(
                                              "dispose",
                                              (java.lang.Class[])
                                                null),
                                          dc.
                                            getMethod(
                                              "getDebugFrame",
                                              (java.lang.Class[])
                                                null) });
                       getContextFactoryMethod =
                         rhinoInterpreterClass.
                           getMethod(
                             "getContextFactory",
                             (java.lang.Class[])
                               null);
                       debuggerClass = dc;
                       isPresent = true; }
                 catch (java.lang.ClassNotFoundException cnfe) {
                     
                 }
                 catch (java.lang.NoSuchMethodException nsme) {
                     
                 }
                 catch (java.lang.SecurityException se) {
                     
                 } }
        protected java.lang.Object debuggerInstance;
        protected org.apache.batik.apps.svgbrowser.JSVGViewerFrame
          svgFrame;
        public Debugger(org.apache.batik.apps.svgbrowser.JSVGViewerFrame frame,
                        java.lang.String url) {
            super(
              );
            svgFrame =
              frame;
            try {
                debuggerInstance =
                  debuggerConstructor.
                    newInstance(
                      new java.lang.Object[] { "JavaScript Debugger - " +
                      url });
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                ite.
                  printStackTrace(
                    );
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.InstantiationException ie) {
                throw new java.lang.RuntimeException(
                  ie.
                    getMessage(
                      ));
            }
        }
        public void setDocumentURL(java.lang.String url) {
            getDebugFrame(
              ).
              setTitle(
                "JavaScript Debugger - " +
                url);
        }
        public void initialize() { javax.swing.JFrame debugGui =
                                     getDebugFrame(
                                       );
                                   javax.swing.JMenuBar menuBar =
                                     debugGui.
                                     getJMenuBar(
                                       );
                                   javax.swing.JMenu menu =
                                     menuBar.
                                     getMenu(
                                       0);
                                   menu.getItem(
                                          0).
                                     setEnabled(
                                       false);
                                   menu.getItem(
                                          1).
                                     setEnabled(
                                       false);
                                   menu.getItem(
                                          3).
                                     setText(
                                       org.apache.batik.apps.svgbrowser.Resources.
                                         getString(
                                           "Close.text"));
                                   menu.getItem(
                                          3).
                                     setAccelerator(
                                       javax.swing.KeyStroke.
                                         getKeyStroke(
                                           java.awt.event.KeyEvent.
                                             VK_W,
                                           java.awt.Event.
                                             CTRL_MASK));
                                   debugGui.
                                     setSize(
                                       600,
                                       460);
                                   debugGui.
                                     pack(
                                       );
                                   setExitAction(
                                     new java.lang.Runnable(
                                       ) {
                                         public void run() {
                                             svgFrame.
                                               hideDebugger(
                                                 );
                                         }
                                     });
                                   java.awt.event.WindowAdapter wa =
                                     new java.awt.event.WindowAdapter(
                                     ) {
                                       public void windowClosing(java.awt.event.WindowEvent e) {
                                           svgFrame.
                                             hideDebugger(
                                               );
                                       }
                                   };
                                   debugGui.
                                     addWindowListener(
                                       wa);
                                   debugGui.
                                     setVisible(
                                       true);
                                   attach(
                                     ); }
        public void attach() { java.lang.Object interpreter =
                                 svgFrame.
                                   svgCanvas.
                                 getRhinoInterpreter(
                                   );
                               if (interpreter !=
                                     null) {
                                   attachTo(
                                     getContextFactory(
                                       interpreter));
                               } }
        protected javax.swing.JFrame getDebugFrame() {
            try {
                return (javax.swing.JFrame)
                         debuggerMethods[GET_DEBUG_FRAME_METHOD].
                         invoke(
                           debuggerInstance,
                           (java.lang.Object[])
                             null);
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        protected void setExitAction(java.lang.Runnable r) {
            try {
                debuggerMethods[SET_EXIT_ACTION_METHOD].
                  invoke(
                    debuggerInstance,
                    new java.lang.Object[] { r });
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        public void attachTo(java.lang.Object contextFactory) {
            try {
                debuggerMethods[ATTACH_TO_METHOD].
                  invoke(
                    debuggerInstance,
                    new java.lang.Object[] { contextFactory });
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        public void detach() { try { debuggerMethods[DETACH_METHOD].
                                       invoke(
                                         debuggerInstance,
                                         (java.lang.Object[])
                                           null);
                               }
                               catch (java.lang.reflect.InvocationTargetException ite) {
                                   throw new java.lang.RuntimeException(
                                     ite.
                                       getMessage(
                                         ));
                               }
                               catch (java.lang.IllegalAccessException iae) {
                                   throw new java.lang.RuntimeException(
                                     iae.
                                       getMessage(
                                         ));
                               } }
        public void go() { try { debuggerMethods[GO_METHOD].
                                   invoke(
                                     debuggerInstance,
                                     (java.lang.Object[])
                                       null);
                           }
                           catch (java.lang.reflect.InvocationTargetException ite) {
                               throw new java.lang.RuntimeException(
                                 ite.
                                   getMessage(
                                     ));
                           }
                           catch (java.lang.IllegalAccessException iae) {
                               throw new java.lang.RuntimeException(
                                 iae.
                                   getMessage(
                                     ));
                           } }
        public void clearAllBreakpoints() {
            try {
                debuggerMethods[CLEAR_ALL_BREAKPOINTS_METHOD].
                  invoke(
                    debuggerInstance,
                    (java.lang.Object[])
                      null);
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        public void dispose() { try { debuggerMethods[DISPOSE_METHOD].
                                        invoke(
                                          debuggerInstance,
                                          (java.lang.Object[])
                                            null);
                                }
                                catch (java.lang.reflect.InvocationTargetException ite) {
                                    throw new java.lang.RuntimeException(
                                      ite.
                                        getMessage(
                                          ));
                                }
                                catch (java.lang.IllegalAccessException iae) {
                                    throw new java.lang.RuntimeException(
                                      iae.
                                        getMessage(
                                          ));
                                } }
        protected java.lang.Object getContextFactory(java.lang.Object rhinoInterpreter) {
            try {
                return getContextFactoryMethod.
                  invoke(
                    rhinoInterpreter,
                    (java.lang.Object[])
                      null);
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                throw new java.lang.RuntimeException(
                  ite.
                    getMessage(
                      ));
            }
            catch (java.lang.IllegalAccessException iae) {
                throw new java.lang.RuntimeException(
                  iae.
                    getMessage(
                      ));
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ryhse+RF+kfkv0LlSsAoMgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "XEVdQTFWHa03A95uS5hQg/pRXs9s8Uq9");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("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" +
           "f/LWLz39p8Ul8P8PoSwCmXc+AAA=");
    }
    public class AboutAction extends javax.swing.AbstractAction {
        public AboutAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            org.apache.batik.apps.svgbrowser.AboutDialog dlg =
              new org.apache.batik.apps.svgbrowser.AboutDialog(
              JSVGViewerFrame.this);
            dlg.
              setSize(
                dlg.
                  getPreferredSize(
                    ));
            dlg.
              setLocationRelativeTo(
                JSVGViewerFrame.this);
            dlg.
              setVisible(
                true);
            dlg.
              toFront(
                );
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
          ("H4sIAAAAAAAAAMVZa6wr11Wee+4jNzdp7k3apCE079tC4nJm7Bl7bG4fGc94" +
           "xh7b4/eMbWhvZ8bzsufleXtKoA2iLRS1ESShldr8agVU6UOICiRUFISgrVoh" +
           "FVW8JNoKIVEolZofFESBsmd8zvE5594kiviBJY+3Z6+19l57rfXttdd+4fvQ" +
           "ed+DCq5jbjTTCfaVJNhfmuX9YOMq/j7bKfdFz1cWpCn6/hi8uy4/8oXLP/zR" +
           "0/qVPejCHHq9aNtOIAaGY/tDxXfMSFl0oMu7tw1TsfwAutJZipEIh4Fhwh3D" +
           "D651oNuOsQbQ1c7hFGAwBRhMAc6nABM7KsD0OsUOLTLjEO3AX0O/CJ3pQBdc" +
           "OZteAD18UogreqJ1IKafawAkXMz+80CpnDnxoIeOdN/qfIPCzxbgZ37r3Vd+" +
           "7yx0eQ5dNuxRNh0ZTCIAg8yh2y3FkhTPJxYLZTGH7rQVZTFSPEM0jTSf9xy6" +
           "yzc0WwxCTzlapOxl6CpePuZu5W6XM928UA4c70g91VDMxeG/86opakDXe3a6" +
           "bjWks/dAwUsGmJinirJyyHJuZdiLAHrwNMeRjlfbgACw3mIpge4cDXXOFsEL" +
           "6K6t7UzR1uBR4Bm2BkjPOyEYJYDue1mh2Vq7orwSNeV6AN17mq6/7QJUt+YL" +
           "kbEE0N2nyXJJwEr3nbLSMft8n3vbR95rN+29fM4LRTaz+V8ETA+cYhoqquIp" +
           "tqxsGW9/vPOceM+XPrQHQYD47lPEW5o/+IWXnnjrAy9+ZUvzkzeh6UlLRQ6u" +
           "y5+S7vjGm8jHamezaVx0Hd/IjH9C89z9+wc91xIXRN49RxKzzv3DzheHfz57" +
           "32eU7+1Bl1rQBdkxQwv40Z2yY7mGqXiMYiueGCiLFnSrYi/IvL8F3QLaHcNW" +
           "tm97quorQQs6Z+avLjj5f7BEKhCRLdEtoG3YqnPYdsVAz9uJC0HQbeALXYGg" +
           "c89C+Wf7G0BrWHcsBRZl0TZsB+57TqZ/ZlB7IcKB4oP2AvS6DiwB/1/9THEf" +
           "h30n9IBDwo6nwSLwCl3ZdoI/rg/7kSZ5TuwrHsyOeIY3lFjxaBC8yn7meu7/" +
           "x6BJthJX4jNngJHedBoiTBBdTcdcKN51+Zmw3njpc9e/tncUMgdrGEBvAyPv" +
           "b0fez0fez0be3428f2rkq4QE4oqQMxeAzpzJB39DNputdwDbrgBKAPy8/bHR" +
           "u9j3fOiRs8At3fgcMExGCr88jJM7XGnl6CkD54Ze/Fj8fv6XkD1o7yQeZxqA" +
           "V5cy9n6GokdoefV0HN5M7uUPfveHn3/uSWcXkScA/gAobuTMAv2R02vtObKy" +
           "ANC5E//4Q+IXr3/pyat70DmAHgAxAxF4OACjB06PcSLgrx2CZ6bLeaCw6niW" +
           "aGZdh4h3KdCBYXZvcie4I2/fCdb4chYB94FQeO4gJPLfrPf1bvZ8w9ZpMqOd" +
           "0iIH57eP3E/+zV/8M5ov9yGOXz62M46U4Nox7MiEXc5R4s6dD4w9RQF0f/+x" +
           "/m8++/0P/lzuAIDi0ZsNeDV7kgAzgAnBMv/KV9Z/++1vfeqbezunCcDmGUqm" +
           "ISdHSl7MdLrjFZQEo71lNx+APaaSO6x/dWJbzsJQDVEylcxL/+vym4tf/NeP" +
           "XNn6gQneHLrRW19dwO79T9Sh933t3f/+QC7mjJztfbs125FtAfX1O8mE54mb" +
           "bB7J+//y/o9/WfwkgGYAh76RKjnCQfkaQLnR4Fz/x/Pn/qm+YvZ40D/u/Cfj" +
           "61iOcl1++ps/eB3/gz9+KZ/tySTnuK27ontt617Z46EEiH/j6Uhvir4O6LAX" +
           "uZ+/Yr74IyBxDiTKANP8ngfAJznhGQfU52/5uz/503ve842z0B4NXTIdcUGL" +
           "eZBBtwLvVnwd4FbivvOJrXXji1uUB6pCNyi/dYp7839nwQQfe3l8obMcZRei" +
           "9/5nz5Se+of/uGERcmS5ydZ8in8Ov/CJ+8h3fC/n34V4xv1AciMgg3xux1v6" +
           "jPVve49c+LM96JY5dEU+SBZ50QyzwJmDBMk/zCBBQnmi/2Sys93Zrx1B2JtO" +
           "w8uxYU+Dy24jAO2MOmtfOo4nPwafM+D7P9k3W+7sxXaLvYs82OcfOtroXTc5" +
           "A6L1fGkf30cy/nfmUh7On1ezx09tzZQ1fxqEtZ9nqYBDNWzRzAd+IgAuZspX" +
           "D6XzIGsFNrm6NPFczN0gT8/dKdN+f5vqbQEte5ZyEVuXKL+s+/zslirfue7Y" +
           "Ces4IGv88D8+/fWPPvptYFMWOh9l6w1MeWxELswS6Q+88Oz9tz3znQ/nKAUg" +
           "qv9c48oTmdTOK2mcPRrZgz5U9b5M1VGeAnREP+jmwKIscm1f0ZX7nmEB/I0O" +
           "skT4ybu+vfrEdz+7zQBP++0pYuVDz/zaj/c/8szesbz70RtS3+M829w7n/Tr" +
           "DlbYgx5+pVFyDvqfPv/kH/3Okx/czuquk1lkAxySPvtX//31/Y9956s3SUvO" +
           "mc7/wbDBbT9oYn6LOPx0+ZkqxJMkEdQeWtOa1blab3BclyF6LJsi3HKgrqlJ" +
           "0BUxjrVUfF7nOpxg9cIFUkYL7RqqNkO7WSxV9JYRzKmqJrJamx7TasKYy4nR" +
           "Wq/EgCeE8joYrEZBd8J40/KE5QRY7Lv1Ygdj8ZEhqa41D2slqVDzLa+23kwD" +
           "vFuClbQZRTUUj1K+VFlajsyg/EhiHCyxZq4stFjYxYlg1UOmWhdPjcZsLLp9" +
           "WG0i/jyE1+OqMvSmyzXFUPakwfcqQ5XFJGvZ5rgwXMVS22swI7aBbfwRZzOt" +
           "/qw0l1x7KbJoSDEj1xH9CoMPkFibMn692OzMtURAYJOpmzE9JpHeqNxzsOW4" +
           "TRXrmoJhokkEvRBELVmbI71QwnB2LqWFpqNI2GS84cxhOqZGQtirxLhU6eFr" +
           "Ztod65pglBtVI0GKuC0v5HG9oJZXUs+srQvhWEDKpoXNxGKJGgTsKkGGjr5k" +
           "FlzDqHQtCR/3W7RpkzYy5uXpUHSr8aBGYzO+S3MmryFYu2brI1nVkESumcqo" +
           "vKRI112vZaefcJQwMSaTUrr01iur1cV6DJiy2NFFKuDDdlGXyOaYSlIabccA" +
           "HCW1rNOCIw6RUqUnr/tOtaUzTLyhNMwsDUeJPSxzrZqDicuGjrX7jaLH6Clu" +
           "DyV7ipDDXtpskBpWnxUs0EfbQSVy2JZmFUtjSxCm40HUmVCmug5YBtVIiUFT" +
           "iZ0ItYhLuhRpxNWmzxGSH07CNYvy40aqrac8g3RVZ0B2qRHP22TXnCfrkjOO" +
           "4/raHBKJT1n6kuhgKbEaeFKD0DyJKC3ZdihWXd5Qk3pjtQnIhmOW6+MWPYma" +
           "XWCMziBskzNkMB+LRLG5SRS1grDl8bK8aqYU0Y7nq6Kje1W4HeiTyUJDBjrb" +
           "KAdE0zdoikcTH18G5pzT9UYdm07qs02UYkwqK1EnWFbGE9fHGTJtUus2Tc8n" +
           "XmkmekllXoB7naKUzGrD4aZGl6sN36eLliAzSqWajGYuUGo1gRnS5TotHMZK" +
           "Yb+/wgv0RBgQRXEtrGSfXJrupI0ERa22xI2J6actraT11uxaFdqFAYOQAb4M" +
           "V/aq0iQq+JAoaW2H6/JDz1BgzVmOHIystONOELprlOxVJ36rhqc0ySBMVB52" +
           "kQ4/L1PYqlztjkereRvxJx7DjrkNYs74SFb18iAe2w1tKnPztWW6BAWvyrBK" +
           "L8KgR0u9+opYm8uSPmvUad3X2UKjtUjmlgICTqD65FK264jUL8zGlthCB+AY" +
           "V2qBBRvDvmApSqkTjEmtMZCcdFRvMHNOrm9qZMvmB1M5iiqSt5mpDSCkonQr" +
           "SI+p+VSvK5npuBfLWBo1I7a41OalZX9kt9ZJhR/EJD2wOmkP1l2WcrTA7RON" +
           "FTWmxkEzQvF407V7bYcwAdIycZMaNgXeXNeU5QppcaP2euo5uKz2Im7T53Sa" +
           "kJjRpDmvWm4zaA9LG461hY031DobYb1p0awpCF7i88ADhNRH5GYalJap0YyS" +
           "JNbHU2LeTMqay2HyLHBWxGxdEZBKddGwzSrcExJMN7nRdGCufKFqlt1ld1ZZ" +
           "U8lI4j0SxcoF2a1yrc1akzaEX7eYOtENcWIZTuQWig6mYdmTJppMu5tq2dCQ" +
           "Kk9SKtl1iI6EDDW/IVTRuKFLYYstEZW5wkncqN9k5zXfUSuVqdUTZiSv6aLf" +
           "mw4LFr1A8aKJhnQYB6bbNacwIrMVeD6ki8C5VsY6mfW11twfrPpRLZTHbre2" +
           "6DfrEkZgZmCOxW7VkqNJXWw0uLQK8l0LjdBYw4JIT9Fud71chMMRMlAtYzWd" +
           "yq4/45e9AVarYlSRkcFmUevVmMZ40rbsxTzekI3CSE35AIWnGxSpFkdJPOvS" +
           "bQJZlFC+QHJqCVOVaMMNS7USSU10c75Q0pKiWL1xGsxxqxlEjA/HckHpTzm3" +
           "CNN8gdhodR/v6emwTviNZZloWUuUVH2+KsVoty8TKjJY9GG9U61G05Yx5d0a" +
           "XFC66CwpLkKD6wk1c1kQiJpRMlA9GcJStQLwe153KIuwCbSDdgZIDbFiHx20" +
           "OaxSH9YnblG3UC2yY7Zrpq5lTiOwy9nSRAn5NR33MWdGB1LFn2gbnoAddoUx" +
           "IsX1aynmOGkwZjG/a7W89rKnFlA6Lk/s4nzjDKMyWtnAqwVum1F10Kq3HctY" +
           "hsWkWpIb6nTCI8bcbPntZRnhBSOegMNZ6OPDbg2pzix6KKBYiS9teiUt8BS+" +
           "hrTXhSoXwHDKlnCtEPEbrRcIuFph0FZ7mnjMbNI3XLzrlOFFsVQWIhXu6s58" +
           "UwtFsedKenmNm+HYwmIx6MOdaQ2h5c0wxaiOUO0ppOVUNYUyi7gaIVyNNVJx" +
           "5NutuVJ0KiIbRnhNmwBMhUvJxoeXLcZpLlKTXcNEp1HFY6kI9/i11CDZ1rrh" +
           "19LRgFkzKL1M8CTUiOGMSMZ9rcSAc6qr+aiNVqdKXPZXrLWEm80WObBoxx8h" +
           "nTk1HhEiBtIC0pZjoVolB5MCPhXjDQp7erkPXGRFG11uuak7Y3YzE+y+U1oI" +
           "bh0z+wopCUIQTgtcVA9bWDrv2CjSVjdNDI5huIxLMbFYSUEkVihlLcycRVvk" +
           "cUJx+KUxQiswmpThtaraaXW4sNFxUqSKQXva2VT1ENaNEaOWTBhD8EKXUvqN" +
           "nqeOinxLkFCVEwsUmc4A5HAmLUs1eUq7nlc0wJhjb0AlStAEyo8WXSxW61Qp" +
           "xi2hZIwCEulKLFEcV+e0LnajgPIXg6TvG2N2PTA2qg6bw6QrGSMV1k1M6Iya" +
           "7NBcN+bVQihYM2rRp0y9E0U6zTQ4vtVlVRkfrDpqK5nHYmjgjEJ3hqLWbMz1" +
           "6cax23Na49RFxycK06AsrHTYcE1YswESVTYqv8H8pp5U8KpMpn5ID6lxjLKl" +
           "CiNzDB/xyjDCZ+G6UtLWsESkZsh1anzUqZLpcIjPZmWBi7xUIeGEUFR+TaED" +
           "auyNZ3QnwWW5wHMILEzBttZvJaTVZoo6iqJS03J1dmbUC8NKr4dFpIerBjJa" +
           "IjpaRsoMCke0sqaFyaCjdBftDdJaW0oUsYXWCnUX1Z6jahQ/6ItDmDLalW55" +
           "Oq+C9GtVpnwR71iqO1lqiaPRfKvVAVGLEMthurSiuNVKca035btyeYCkgzJq" +
           "2jRbMGZUSNRZv1mTwx6FEgXKbMMSV1ZNK5zVp415oIB8Gcdry4hatRpmHV54" +
           "QmG6mvhTA1NhLhZ9K1XTZERjG4GfbPor3dUWZqEjsu21QPIsNh2ylQFilgin" +
           "2Ji6atwcsytwAE4GIMF/+9uz1P9dr+30dWd+0Dy6YACHrqyj+RpOHduuh7PH" +
           "m4+KU3ld4tLpovTx4tSuYgFlJ6n7X+7eID9FfeqpZ55f9D5d3Duo9EzBwfng" +
           "OmcnJzvKPv7yx8VufmeyKz98+al/uW/8Dv09r6Go+uCpSZ4W+bvdF77KvEX+" +
           "jT3o7FEx4obbnJNM106WIC55ShB69vhEIeL+k4XNEljOjx8s68dvXti8qQuc" +
           "yV1ga/hTVbQzBwt4UF24Lz/rizFYxUixg/1tobuRtXN2/xWKcHH2sAPospgz" +
           "9RUvK98q28uq0TFnEsABN3KMxc7LnFc7256oeQXQbceq8IdTR15rKR84zb03" +
           "3Cxub8Pkzz1/+eIbn5/8dV7APrqxurUDXVRD0zxeOTrWvuB6imrka3Hrto7k" +
           "5j+/HEAPvdrkAujS7k+u0lNb5g8E0N03ZQaLmP0cp/3VALpymjaAzue/x+l+" +
           "HYy2owMRtW0cJ/loAJ0FJFnzafeEdyT7fmzY2j44sQUeMPXWCsmZk3F9ZNq7" +
           "Xs20x6Dg0RMxnF8OH8ZbuL0evi5//nmWe+9LlU9vS/SyKaZpJuViB7ple1tw" +
           "FLMPv6y0Q1kXmo/96I4v3PrmQ3C5YzvhXSQdm9uDN6+HNyw3yCvY6R++8fff" +
           "9tvPfysviv0vkFNvpbUfAAA=");
    }
    public class OpenAction extends javax.swing.AbstractAction {
        public OpenAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            java.io.File f =
              null;
            if (org.apache.batik.util.Platform.
                  isOSX) {
                java.awt.FileDialog fileDialog =
                  new java.awt.FileDialog(
                  JSVGViewerFrame.this,
                  org.apache.batik.apps.svgbrowser.Resources.
                    getString(
                      OPEN_TITLE));
                fileDialog.
                  setFilenameFilter(
                    new java.io.FilenameFilter(
                      ) {
                        public boolean accept(java.io.File dir,
                                              java.lang.String name) {
                            java.util.Iterator iter =
                              getHandlers(
                                ).
                              iterator(
                                );
                            while (iter.
                                     hasNext(
                                       )) {
                                org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
                                  (org.apache.batik.apps.svgbrowser.SquiggleInputHandler)
                                    iter.
                                    next(
                                      );
                                if (handler.
                                      accept(
                                        new java.io.File(
                                          dir,
                                          name))) {
                                    return true;
                                }
                            }
                            return false;
                        }
                    });
                fileDialog.
                  setVisible(
                    true);
                java.lang.String filename =
                  fileDialog.
                  getFile(
                    );
                if (fileDialog !=
                      null) {
                    java.lang.String dirname =
                      fileDialog.
                      getDirectory(
                        );
                    f =
                      new java.io.File(
                        dirname,
                        filename);
                }
            }
            else {
                javax.swing.JFileChooser fileChooser =
                  null;
                java.lang.String os =
                  java.lang.System.
                  getProperty(
                    PROPERTY_OS_NAME,
                    PROPERTY_OS_NAME_DEFAULT);
                java.lang.SecurityManager sm =
                  java.lang.System.
                  getSecurityManager(
                    );
                if (priorJDK1_4 &&
                      sm !=
                      null &&
                      os.
                      indexOf(
                        PROPERTY_OS_WINDOWS_PREFIX) !=
                      -1) {
                    fileChooser =
                      new javax.swing.JFileChooser(
                        makeAbsolute(
                          currentPath),
                        new org.apache.batik.apps.svgbrowser.WindowsAltFileSystemView(
                          ));
                }
                else {
                    fileChooser =
                      new javax.swing.JFileChooser(
                        makeAbsolute(
                          currentPath));
                }
                fileChooser.
                  setFileHidingEnabled(
                    false);
                fileChooser.
                  setFileSelectionMode(
                    javax.swing.JFileChooser.
                      FILES_ONLY);
                java.util.Iterator iter =
                  getHandlers(
                    ).
                  iterator(
                    );
                while (iter.
                         hasNext(
                           )) {
                    org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
                      (org.apache.batik.apps.svgbrowser.SquiggleInputHandler)
                        iter.
                        next(
                          );
                    fileChooser.
                      addChoosableFileFilter(
                        new org.apache.batik.apps.svgbrowser.SquiggleInputHandlerFilter(
                          handler));
                }
                int choice =
                  fileChooser.
                  showOpenDialog(
                    JSVGViewerFrame.this);
                if (choice ==
                      javax.swing.JFileChooser.
                        APPROVE_OPTION) {
                    f =
                      fileChooser.
                        getSelectedFile(
                          );
                    currentPath =
                      f;
                }
            }
            if (f !=
                  null) {
                try {
                    java.lang.String furl =
                      f.
                      toURL(
                        ).
                      toString(
                        );
                    showSVGDocument(
                      furl);
                }
                catch (java.net.MalformedURLException ex) {
                    if (userAgent !=
                          null) {
                        userAgent.
                          displayError(
                            ex);
                    }
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYb2wUxxWfO//BPozPNsEQCAbMgYST3obmD2pNS4xrg+nZ" +
           "PtnEUk2aY253zrd4b3e8O2efnbqESC00H1AUnJRGwZ9ImyISoqpRK1VBrio1" +
           "idI0gkZt/qhJq35o+gcpfAmtaJu+mdm73ds7m+ZTLXlvb+bNm3nv/d7vvbmL" +
           "11CdY6NOik0Nx9ksJU48yd+T2HaI1mtgxzkMoyn18T+eOX7jN40nwqh+HDVn" +
           "sTOoYof068TQnHG0WTcdhk2VOEOEaHxF0iYOsacx0y1zHK3TnYEcNXRVZ4OW" +
           "RrjAGLYTqBUzZuvpPCMDrgKGtiTEaRRxGqUnKNCdQE2qRWe9BRvLFvT65rhs" +
           "ztvPYaglcQxPYyXPdENJ6A7rLtjoTmoZsxOGxeKkwOLHjPtcRxxK3Ffhhs6X" +
           "op/cfCLbItywFpumxYSJzghxLGOaaAkU9Ub7DJJzptA3UU0CrfYJMxRLFDdV" +
           "YFMFNi3a60nB6dcQM5/rtYQ5rKipnqr8QAxtK1dCsY1zrpqkODNoaGCu7WIx" +
           "WLu1ZG0x3AETn7pTWfjuwy0/qkHRcRTVzVF+HBUOwWCTcXAoyaWJ7fRoGtHG" +
           "UasJAR8lto4Nfc6NdpujT5iY5QECRbfwwTwlttjT8xVEEmyz8yqz7JJ5GQEq" +
           "91tdxsATYGu7Z6u0sJ+Pg4ERHQ5mZzBgz11SO6mbmsBR+YqSjbGvggAsXZUj" +
           "LGuVtqo1MQygNgkRA5sTyiiAz5wA0ToLIGgLrC2jlPuaYnUST5AUQxuCckk5" +
           "BVKNwhF8CUPrgmJCE0RpYyBKvvhcG9p7+hHzoBlGITizRlSDn381LOoILBoh" +
           "GWITyAO5sKkr8TRuf+VUGCEQXhcQljI/+cb1B+7qWHpNymyqIjOcPkZUllLP" +
           "p5uv3NG76ws1/BgN1HJ0Hvwyy0WWJd2Z7gIFpmkvaeST8eLk0sgvv/boBfK3" +
           "MIoMoHrVMvI5wFGrauWobhD7ADGJjRnRBlAjMbVeMT+AVsF7QjeJHB3OZBzC" +
           "BlCtIYbqLfEdXJQBFdxFEXjXzYxVfKeYZcV7gSKEVsM/akGo9vtI/MlPhqaU" +
           "rJUjClaxqZuWkrQtbj8PqOAc4sC7BrPUUtKA/8nP7Y7vURwrbwMgFcueUDCg" +
           "IkvkJHyhjuJMT6Rtawb4UTk0OnZgTCczxO6H5CVxDj36/9i0wD2xdiYUgiDd" +
           "EaQIA7LroGVoxE6pC/n9fddfTL0h4cdTxvUhQ92wc1zuHBc7x/nOcW/neGDn" +
           "2DAlZo/KEYBCIbH3bfwwEhwQ2kkgCWDppl2jXz909FRnDaCSztRCXLjozoqq" +
           "1euxSbEEpNSLV0ZuvPVm5EIYhYFw0lC1vNIRKysdsvLZlko04K7likiRSJXl" +
           "y0bVc6ClszMnxo7fLc7hrwZcYR0QGV+e5Bxe2iIWZIFqeqMnP/rk0tPzlscH" +
           "ZeWlWBUrVnKa6QxGOmh8Su3ail9OvTIfC6Na4C7ga4Yhv4AKO4J7lNFNd5G6" +
           "uS0NYHDGsnPY4FNFvo2wLMDCGxEQbBXvt0GIozz/bodEfN5NSPHJZ9spf66X" +
           "kOWYCVghSsOXRum5d379l3uEu4tVJOor/6OEdfuYiytrExzV6kHwsE0IyP3+" +
           "bPLMU9dOHhH4A4nt1TaM8WcvMBaEENz8rdem3v3wg/Nvhz3MMijd+TR0QYWS" +
           "kQ3cpuYVjOQ4984DzGcQkS9O7EETUKlndJw2CE+Sf0V37H7576dbJA4MGCnC" +
           "6K5bK/DGb9+PHn3j4RsdQk1I5ZXX85knJul8rae5x7bxLD9H4cTVzd97FZ+D" +
           "wgBk7OhzRPArEj5AImj3CvsV8bwnMHc/f8QcP/jL88vXIaXUJ97+eM3Yx5ev" +
           "i9OWt1j+WA9i2i3hxR87CqB+fZBoDmInC3L3Lg091GIs3QSN46BRBUZ1hm2g" +
           "vkIZMlzpulXv/fwX7Uev1KBwP4oYFtb6sUgy1AjoJk4WWLNA9z0gozvTIGsM" +
           "mIoqjOf+3FI9Un05yoRv5366/sd7f7D4gQCVRNEmd7n4spM/ukroEjORYE3z" +
           "o6tMg402L9d2iJbp/GMLi9rwc7tlc9BWXsr7oFN94bf//lX87B9er1Ib6t22" +
           "0duQU/i2CgofFC2ZRz97rt6oef/JDU2V7M01dSzDzV3Lc3Nwg1cf++vGw1/O" +
           "Hv0MtLwl4KWgyh8OXnz9wE71ybDoKiUjV3Sj5Yu6/f6CTW0C7bPJzeIjawR2" +
           "O8up8fMQzwtuXC9Up8YqkCgRznJLA6kZcmPFv2+A/lcAFM+AY6eJyeKyePfx" +
           "d7HnyAqZPcYfg5CYWCxKQtcONYFogINdK1zBbD0HBD3tNrHKfNuHk89+9ILE" +
           "YLDjDQiTUwuPfxo/vSDxKK8F2ys6c/8aeTUQx22RPvsU/kLw/x/+z23hA7I1" +
           "bOt1+9OtpQaV0oKA9QrHElv0//nS/M+enz8Zdn3Tx1DttKXLu8ge/hiSGf3F" +
           "/407+MC+AkMRr6Mqhuzuz9qVgQEbKi6J8mKjvrgYbVi/+ODvRDdQunw0QR3N" +
           "5A3Dh2A/muupTTK6sLNJsjAVH1mGtt7qcGCS90WYNCEXT8Ltqepi8CT/8MvC" +
           "taQlKMtQnfj0y03Bbp4ckJZ88YswhmpAhL/maVlWFOLODFwW4z1p6LQA4jIK" +
           "hVAlS4v4rrtVfH20vL0sPcQ9v0g9eXnTT6mXFg8NPXL9/udkv6MaeG5O3Avh" +
           "mitbrxJ9bVtWW1FX/cFdN5tfatxRRGerPLBHKpt8ab0P6IHy4rUx0Aw4sVJP" +
           "8O75vZffPFV/FRLxCAphhtYe8d2y5ZUSOoo8cOuRhL8m+H4tEn1Kd+RPR9/6" +
           "x3uhNlEB3SrSsdKKlHrm8vvJDKXPhFHjAKqD5COFcRTRna/MmiNEnYZa3ZA3" +
           "9ak8GdAAq2krb5Z+EmjmCMf8NwDhGdeha0qjvF9mqLOSUirvENAcQILt59oF" +
           "pQcIP0+pf7bAr8pVrILY7D73z+PffmcYMrDs4H5tq5x8ulQ7/L84eMWkhT8e" +
           "Kkgiq0klBiktEttVEVVKBal8Rxh9UkpzCYZCXZT+F3+RyuI5FAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AkyRsluvHwAA");
    }
    public void showSVGDocument(java.lang.String uri) {
        try {
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              uri);
            org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
              getInputHandler(
                purl);
            handler.
              handle(
                purl,
                JSVGViewerFrame.this);
        }
        catch (java.lang.Exception e) {
            if (userAgent !=
                  null) {
                userAgent.
                  displayError(
                    e);
            }
        }
    }
    public org.apache.batik.apps.svgbrowser.SquiggleInputHandler getInputHandler(org.apache.batik.util.ParsedURL purl)
          throws java.io.IOException { java.util.Iterator iter =
                                         getHandlers(
                                           ).
                                         iterator(
                                           );
                                       org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
                                         null;
                                       while (iter.
                                                hasNext(
                                                  )) {
                                           org.apache.batik.apps.svgbrowser.SquiggleInputHandler curHandler =
                                             (org.apache.batik.apps.svgbrowser.SquiggleInputHandler)
                                               iter.
                                               next(
                                                 );
                                           if (curHandler.
                                                 accept(
                                                   purl)) {
                                               handler =
                                                 curHandler;
                                               break;
                                           }
                                       }
                                       if (handler ==
                                             null) {
                                           handler =
                                             defaultHandler;
                                       }
                                       return handler;
    }
    protected static java.util.Vector getHandlers() {
        if (handlers !=
              null) {
            return handlers;
        }
        handlers =
          new java.util.Vector(
            );
        registerHandler(
          new org.apache.batik.apps.svgbrowser.SVGInputHandler(
            ));
        java.util.Iterator iter =
          org.apache.batik.util.Service.
          providers(
            org.apache.batik.apps.svgbrowser.SquiggleInputHandler.class);
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler =
              (org.apache.batik.apps.svgbrowser.SquiggleInputHandler)
                iter.
                next(
                  );
            registerHandler(
              handler);
        }
        return handlers;
    }
    public static synchronized void registerHandler(org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler) {
        java.util.Vector handlers =
          getHandlers(
            );
        handlers.
          addElement(
            handler);
    }
    public class OpenLocationAction extends javax.swing.AbstractAction {
        public OpenLocationAction() { super(
                                        );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (uriChooser ==
                  null) {
                uriChooser =
                  new org.apache.batik.util.gui.URIChooser(
                    JSVGViewerFrame.this);
                uriChooser.
                  setFileFilter(
                    new org.apache.batik.swing.svg.SVGFileFilter(
                      ));
                uriChooser.
                  pack(
                    );
                java.awt.Rectangle fr =
                  getBounds(
                    );
                java.awt.Dimension sd =
                  uriChooser.
                  getSize(
                    );
                uriChooser.
                  setLocation(
                    fr.
                      x +
                      (fr.
                         width -
                         sd.
                           width) /
                      2,
                    fr.
                      y +
                      (fr.
                         height -
                         sd.
                           height) /
                      2);
            }
            if (uriChooser.
                  showDialog(
                    ) ==
                  org.apache.batik.util.gui.URIChooser.
                    OK_OPTION) {
                java.lang.String s =
                  uriChooser.
                  getText(
                    );
                if (s ==
                      null)
                    return;
                int i =
                  s.
                  indexOf(
                    '#');
                java.lang.String t =
                  "";
                if (i !=
                      -1) {
                    t =
                      s.
                        substring(
                          i +
                            1);
                    s =
                      s.
                        substring(
                          0,
                          i);
                }
                if (!s.
                      equals(
                        "")) {
                    java.io.File f =
                      new java.io.File(
                      s);
                    if (f.
                          exists(
                            )) {
                        if (f.
                              isDirectory(
                                )) {
                            s =
                              null;
                        }
                        else {
                            try {
                                s =
                                  f.
                                    getCanonicalPath(
                                      );
                                if (s.
                                      startsWith(
                                        "/")) {
                                    s =
                                      "file:" +
                                      s;
                                }
                                else {
                                    s =
                                      "file:/" +
                                      s;
                                }
                            }
                            catch (java.io.IOException ex) {
                                
                            }
                        }
                    }
                    if (s !=
                          null) {
                        if (svgDocument !=
                              null) {
                            org.apache.batik.util.ParsedURL docPURL =
                              new org.apache.batik.util.ParsedURL(
                              svgDocument.
                                getURL(
                                  ));
                            org.apache.batik.util.ParsedURL purl =
                              new org.apache.batik.util.ParsedURL(
                              docPURL,
                              s);
                            java.lang.String fi =
                              svgCanvas.
                              getFragmentIdentifier(
                                );
                            if (docPURL.
                                  equals(
                                    purl) &&
                                  t.
                                  equals(
                                    fi)) {
                                return;
                            }
                        }
                        if (t.
                              length(
                                ) !=
                              0) {
                            s +=
                              '#' +
                              t;
                        }
                        showSVGDocument(
                          s);
                    }
                }
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
           "uEEJWWa5yQl9Cl9GX/j4A/jbvpvh70I8xX5odWNehmXdDrf4aeff9h47/6d7" +
           "yO0yclk7qBlFxY7TwJFhnRQeFpKwrjyxfrLm2R7w145S2BtOp5dj255OLrvz" +
           "AM5T6HR+8Xg++RH8nIH//5P+p+pOH2xP2iv4wXH/yNF57/urMzBazxX3a/v5" +
           "FP/tGZVHs/FqOvzE1kzp9CdhWIdZsQoxDMtV7GzjpyLoYrZ29ZC6CItXaJOr" +
           "M7uWkbkXluuZO6XS728rvm1CS8diRmLrEpVbus9Pb6Gyk+vuHTHag8XjB//h" +
           "2a99+PFvQZt2kXPLVN/QlMd2ZOK0nn7fCx958M7nvv3BLEvBFMV9lLj8VEqV" +
           "fjmJ04FIB/JQ1AdSUYWsEqCVMOpniQXombQv68pcYDkw/y4PikX06Svfmn/8" +
           "O5/ZFoKn/fYUMPjAc7/yo/0PPbd3rPx+/IYK+DjOtgTPmH7NgYYD5NGX2yXD" +
           "IP/xc0//4W8//f4tV1dOFpMEvCt95i//+2v7H/v2V25Sndxme/8Hw0Z3/mun" +
           "HFLNw09fnBhSMlqtJIMtNcxOIqNEc01O+k1NaM18VTJzo3akTKaJOuyjxbWg" +
           "SEpEaVot2ixDsRbnOF0ylmEBFwnF6lSa+TEmSLaIYjpfLFvEoh2MBFsaLPI+" +
           "480EhiLbamsj+oVhTjEsnDTyVFBcyEv4FzdQlfWXTmAH6xKDcs5G3ZSMGC2V" +
           "og2pVGdsKBLuSlHaRHEtERbgy3HdV1sRUd1ISXm1xvLqsLrCUM4NZisx5rq9" +
           "nmfwxWhTxOxROOKqutT1NrOZ4vkhm1TlnouTOEOXLZlnO0WGnVTlSWUWqcFm" +
           "joN2sFiEeZKmCiuzxUTdAuXJISr113Wr6ZfxaTCyV+25pPHxvIuXBu5IZhZ5" +
           "0UYTRVljahFjharaQPVNu+13O6ExlDptWbWm3ZLU0TF+qQ+EwkwPe4lEUSOJ" +
           "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" +
           "s/7Y/wLUE21Txx8AAA==");
    }
    public class NewWindowAction extends javax.swing.AbstractAction {
        public NewWindowAction() { super(
                                     ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            org.apache.batik.apps.svgbrowser.JSVGViewerFrame vf =
              application.
              createAndShowJSVGViewerFrame(
                );
            vf.
              autoAdjust =
              autoAdjust;
            vf.
              debug =
              debug;
            vf.
              svgCanvas.
              setProgressivePaint(
                svgCanvas.
                  getProgressivePaint(
                    ));
            vf.
              svgCanvas.
              setDoubleBufferedRendering(
                svgCanvas.
                  getDoubleBufferedRendering(
                    ));
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
           "e9NvPfetvDn2v2Tqco/BHwAA");
    }
    public class PreferencesAction extends javax.swing.AbstractAction {
        public PreferencesAction() { super(
                                       );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            application.
              showPreferenceDialog(
                JSVGViewerFrame.this);
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
           "5a2x/wXZuQePwR8AAA==");
    }
    public class CloseAction extends javax.swing.AbstractAction {
        public CloseAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            application.
              closeJSVGViewerFrame(
                JSVGViewerFrame.this);
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
           "rkG1HwAA");
    }
    public class ReloadAction extends javax.swing.AbstractAction {
        public ReloadAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if ((e.
                   getModifiers(
                     ) &
                   java.awt.event.ActionEvent.
                     SHIFT_MASK) ==
                  1) {
                svgCanvas.
                  flushImageCache(
                    );
            }
            if (svgDocument !=
                  null) {
                localHistory.
                  reload(
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
           "xeY41cPOGnU8iXZpJ2jaKOe0rT7OTlWh1Ctp82Khx3KYPfXjjRLR4XDDMGaJ" +
           "EHuYMlSVwCf9zqZstX0XQZZsk0GEVXXQ7tm8IFfiCV4khblXU5B+UGijFslU" +
           "qnFrKjRn06TCu3R5xYfigtBWPRHV1v35eFNvMEKjMm+3BJFalgKBsrsVnxZ7" +
           "GzxZ6by/QssVdeTXa0S8MqZIM5g5HZwabPrNeUQos/J0NN3M1nLRaHZmm7hm" +
           "xsXCRBgr2CDABv2YbSpdoT4tyyY+7w3Q5nhJd1N5seqN05o8XtvpejQKk2La" +
           "xGxCqZkFu9KoNdIJHLWjclRadjw/JsSuBCJzqaQIs9BYTUTG8NRwtMCjBqKN" +
           "Z5VqVV0DF2g1KLlXQEQxhrVyJ6WosVGJCvXheqqxSUHT03UgzmatulJ1vVF9" +
           "ZVNJUMbFko80F0nNRskIGG7ZrCsCxTheq8dIzDwk2uXFOvYjh0E3aB1GuW4i" +
           "DloUwc9Q1F61hnC1DWtzdphUC0WO5M02q2kpomtCjysO1arjhkGnDm+UhKWn" +
           "Q7RulPSE5ozhaKDRzEIh4k3fbG44TPUK8TQhmSgepg24TaZMB1+nG1jHSxzn" +
           "olaNh4U5WdoUZK8sT51xRYRLVE9WCbtWD6RBsxoqpKWJhupThlqHuSIxCJOw" +
           "OyziBt2xp8ako4utNeXbGInbUkVu6OW1HtqFBuENsbU2x3paqlsbDsd5LPKc" +
           "cUstB0WyyGzoOT0cGKtmVbKwiK4wNZWfl1h9Pu+bSM3RfR3uoo4yZRLOWFhz" +
           "qYKVp1NU3rAlpTsVKIdYAQtyuYkk42wl4iW8QRTdaSMQJ4SsOxIqN2Fp44UV" +
           "EuZWfTiN0FqBdmEUr5aE1aiGyjTpyYrh65MFaRpValkvmG7a4MGRXK9HUme5" +
           "8JHK0qvYUd/2NaFMy2t8JaKwqjGWj0i0blQktNWP+Qlpm3W677dQaTUuz9rT" +
           "zWIWSZTen8B8TVemcscbS73WUDZFXeDoGCnZ9HxSwLR2JS6jKxN8CAbPdZXu" +
           "TO4s5sNFK/Bht4irgybmkUaHxMPhuCVNEzli1uWgwZZkqoaThQ41JpJOlyXW" +
           "S2TVtIlmkoIgQ3CzKKhQtLkMy6VJJQwKzjplk02DwpuzGuo1Y1qexoWOnhTj" +
           "gJvDXSvoI9YQ1taLmYIraixUZYYpY3UChmETbsQCY2FyXJtpYZFRBQfkPlyR" +
           "EnqNuN9vt+FKfZ3qcD3SnbGoKqg+SidjO6quKTQoi3XTUdt6QS2UjRgOeinO" +
           "V+jC0lp0alV4iMwcHDO9Vd/zU2WF1SPWXAv9tFaeRwbJmdqou7IWjpyYBRwP" +
           "EnTQCHm7066ICMdWnbLF9IvDmUyKVdNi1LaDj8x2EcZwyV+J66YNw3g/DoVF" +
           "l5v3+S5abgzCIZBMA8eooDOd/oCarUYUB1ccezY1x1ZqgPOIHjQkzSo16dEG" +
           "8yajLl/oY71CbSKyjaS/afQJkpjKDYpx7QpSLCztRGTwcWkDyxV3NtDmHdeM" +
           "xmE8LEue71TrnCGU5IkdshMYbU3HmjxFfIVXWHeVbmJ2E8k65TTw2MLq615p" +
           "oDZput/mJjCuFWRkiqbJRE8mXH1k9ERRFsg1qYa0UCLcVY/p4/5C5ODe2iwM" +
           "2J7KufpiXNT1QqDXvPGMbTaK1aJPctaSrVbWFLkZbWwm3swTo823CjaJRQPP" +
           "m4e6k05IC/eGJdkz5cJyrI17RnMijydhOYC5dJS2OnRBqzfjOR2NGhrPui6Z" +
           "tltuV7J51OoZjNgkkHqhhJUohierGr9uBMakMF2VjHag2o3aEibX8DoadFgD" +
           "UcgGYouVwpRbamsTVnW8x41CmGlzo0lbGnNGwgkrDlGLLN9jhWJ9XjIbxGKZ" +
           "cryIuRO2YNdpSw1Shh2BBP/JJ7PU/+2v7vZ1V37RPHphAJeubIJ8FbeO7dQj" +
           "WfOmo+JUXpe4eLoqfbw4tatYQNlN6oGbPRzkt6hPPPPc8yr9ydLeQaVnCi7O" +
           "B+85OzrZVfaJm18XB/mjya788JVn/uX+8c+b73wVRdWHTjF5muRnBi98rfNm" +
           "5bf2oLNHxYjrnnNOIl09WYK46Gth5LvjE4WIB04WNhGwnZ852NbP3LiweUMT" +
           "OJObwFbxp6poZw428KC6cH9+15disItrzQ33t4VuIuvn6MHLFOHirHFD6JKU" +
           "IzGan5Vvte1rFXfMmARwwV17lrqzMu+V7rYnal4hdMfxMvwh78VXW8wHVnPf" +
           "dW+L2/cw5fPPX7rw+uf5v84r2EdvVrf1oQt6ZNvHS0fH+ueXvqZb+Wbcti0k" +
           "LfOfXw2hh1+JuRC6uPvIRXpmi/zeELrnhshgF7Of47C/HkKXT8OG0Ln89zjc" +
           "b4LVdnDApbad4yAfCqGzACTrPrs8YR7JfhBbrrEPrmyhD3S91UJy5qRjH+n2" +
           "7lfS7bFY8NgJJ86fhw8dLto+EF9TvvB8d/iul6qf3NboFVtK04zKhT506/a5" +
           "4MhpH7kptUNa58nHf3znF29702F0uXPL8M6VjvH20I0L4oSzDPMSdvqHr//9" +
           "t37q+W/nVbH/BV1C/T23HwAA");
    }
    public class BackAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public BackAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (localHistory.
                  canGoBack(
                    )) {
                localHistory.
                  back(
                    );
            }
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { boolean b =
                                    localHistory.
                                    canGoBack(
                                      );
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      ((javax.swing.JComponent)
                                         it.
                                         next(
                                           )).
                                        setEnabled(
                                          b);
                                  } }
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
           "tRH1Lk5JrUrLGnTl1agvtejleENsXFtcyhIzt8KRMJmzXWsz17kQM1s4xTMs" +
           "bmyGJL8W0Qm2YPtLqTnW+6a7DpDCwpt1aF1GtFnc7PXbzeKAFp0a252nhbFD" +
           "+x3Wo4YErXb8zmgZrCyxuBBFpxTTpl6hOpuW3PVa/c2iy5BiYBA1hi+2Ca/u" +
           "xJKKRr6F+y3C8zySE43SjOqPVbvJL1hh4A0Zqrsu9qvD2Cl3Oq2oaHS9RTKz" +
           "6qK+QpsBvQr9Yo9yk0ITEbgNOxkaZDsyO2ZphW+6jmXL7HRMkC4j9MxucS4Y" +
           "C92MNr2WyIVpUfetRmCXHbJS1orwhIKR4rrLl2ZFby5Nxu2VSo6S5szFA95w" +
           "+4nUXfZXDmdKJhcuArIWcCRj+KkQ2GKf1lQHW1k40dA9Z9Zz22wYjIvKdEZa" +
           "o5Q3umyztykbkxmP2DChD+giNtggS28jL6xpESVHAblpLZJVF5umw5luIZww" +
           "MysrRV06m95yVicwCZt007aLjLvSUuhQLRJDUJLnR2qxq5SZ1Bsj2MQzcCLx" +
           "e0hxPjMHrkjV2f5oURiQ4zE+TjSTL+LCRmfxyWghVjbKki63hG7sBRWGGabK" +
           "hGmUkrFQdXGqg6UcovPVodnGkIGyrK6a3RqBd0ZlYMp2sCFbeiOe4B2yiw17" +
           "lXbaMlVYqYZsQZo0JRQXOcl0WtZQqo8MY2a2y8lk2q1pPdUnsLbXJ5HiZt4K" +
           "68vBLNp4zenY7M9wceKkdIPprprFCjJsSbUUKLRf7zh+dyIQrMcZTlczR6G4" +
           "MhXBJxLMi2ckZkwmJukKHj/phwXa8EhtJUx7bCMYE+xgLCxZesb3qVYcDOmV" +
           "j5EmS80VYorMWKuBTnCwXWGykjvL2SxWdUJfmzJbSMYFm5mR0qiGiquVTK1Y" +
           "3BT4sN3ki/SyjtC9niyRXW1hmgpR13A4VRqaUHF4Zcnzi1l5Ti1SNegQKsnH" +
           "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");
    }
    public class ForwardAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public ForwardAction() { super();
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (localHistory.
                  canGoForward(
                    )) {
                localHistory.
                  forward(
                    );
            }
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { boolean b =
                                    localHistory.
                                    canGoForward(
                                      );
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      ((javax.swing.JComponent)
                                         it.
                                         next(
                                           )).
                                        setEnabled(
                                          b);
                                  } }
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
          ("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");
    }
    public class PrintAction extends javax.swing.AbstractAction {
        public PrintAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (svgDocument !=
                  null) {
                final org.w3c.dom.svg.SVGDocument doc =
                  svgDocument;
                new java.lang.Thread(
                  ) {
                    public void run() {
                        java.lang.String uri =
                          doc.
                          getURL(
                            );
                        java.lang.String fragment =
                          svgCanvas.
                          getFragmentIdentifier(
                            );
                        if (fragment !=
                              null) {
                            uri +=
                              '#' +
                              fragment;
                        }
                        org.apache.batik.transcoder.print.PrintTranscoder pt =
                          new org.apache.batik.transcoder.print.PrintTranscoder(
                          );
                        if (application.
                              getXMLParserClassName(
                                ) !=
                              null) {
                            pt.
                              addTranscodingHint(
                                org.apache.batik.transcoder.image.JPEGTranscoder.
                                  KEY_XML_PARSER_CLASSNAME,
                                application.
                                  getXMLParserClassName(
                                    ));
                        }
                        pt.
                          addTranscodingHint(
                            org.apache.batik.transcoder.print.PrintTranscoder.
                              KEY_SHOW_PAGE_DIALOG,
                            java.lang.Boolean.
                              TRUE);
                        pt.
                          addTranscodingHint(
                            org.apache.batik.transcoder.print.PrintTranscoder.
                              KEY_SHOW_PRINTER_DIALOG,
                            java.lang.Boolean.
                              TRUE);
                        pt.
                          transcode(
                            new org.apache.batik.transcoder.TranscoderInput(
                              uri),
                            null);
                        try {
                            pt.
                              print(
                                );
                        }
                        catch (java.awt.print.PrinterException ex) {
                            userAgent.
                              displayError(
                                ex);
                        }
                    }
                }.
                  start(
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
          ("H4sIAAAAAAAAAMVYb2wcxRWfO/+JfXH8L8RJHeIkziVSDL0l5U/UOm1wXDtx" +
           "erZPdrBUh3KZ253zbby3O96ds8+mbghSm5QPESKGpoj4U1BbFAhCIJAqIleV" +
           "CohSlBS1QFRo1Q+lLUHkC2mVtvTNzN7t3t7ZKZ9qyXt7M2/ezHvv937vzZ2/" +
           "imocG3VSbGo4xmYpcWIJ/p7AtkO0XgM7ziEYTaqP/On0seu/rT8eRrXjqDGD" +
           "nUEVO6RfJ4bmjKNNuukwbKrEGSJE4ysSNnGIPY2ZbpnjaJ3uDGSpoas6G7Q0" +
           "wgXGsB1HLZgxW0/lGBlwFTC0OS5Oo4jTKD1Bge44alAtOustaC9Z0Oub47JZ" +
           "bz+Hoeb4UTyNlRzTDSWuO6w7b6PbqGXMThgWi5E8ix017nYdcTB+d5kbOp9v" +
           "+uzGo5lm4Ya12DQtJkx0RohjGdNEi6Mmb7TPIFlnCn0PVcXRap8wQ9F4YVMF" +
           "NlVg04K9nhScfg0xc9leS5jDCppqqcoPxNDWUiUU2zjrqkmIM4OGOubaLhaD" +
           "tVuK1hbCHTDx8duUhR890PxCFWoaR026OcqPo8IhGGwyDg4l2RSxnR5NI9o4" +
           "ajEh4KPE1rGhz7nRbnX0CROzHECg4BY+mKPEFnt6voJIgm12TmWWXTQvLUDl" +
           "fqtJG3gCbG3zbJUW9vNxMDCiw8HsNAbsuUuqJ3VTEzgqXVG0MfotEIClq7KE" +
           "ZaziVtUmhgHUKiFiYHNCGQXwmRMgWmMBBG2BtWWUcl9TrE7iCZJkaENQLiGn" +
           "QKpeOIIvYWhdUExogii1B6Lki8/VoT2nHjQPmGEUgjNrRDX4+VfDoo7AohGS" +
           "JjaBPJALG7riT+C2V0+GEQLhdQFhKfPyd6/de3vH0utSZmMFmeHUUaKypHou" +
           "1Xjp1t6dX63ix6ijlqPz4JdYLrIs4c505ykwTVtRI5+MFSaXRn717YeeIX8P" +
           "o8gAqlUtI5cFHLWoVpbqBrH3E5PYmBFtANUTU+sV8wNoFbzHdZPI0eF02iFs" +
           "AFUbYqjWEt/BRWlQwV0UgXfdTFuFd4pZRrznKUJoNfyjZoRqPkbiT34yNKVk" +
           "rCxRsIpN3bSUhG1x+3lABecQB941mKWWkgL8T355V2y34lg5GwCpWPaEggEV" +
           "GSIn4Qt1FGd6ImVbM8CPysHRsf1jOpkhdj8kL4lx6NH/x6Z57om1M6EQBOnW" +
           "IEUYkF0HLEMjdlJdyO3ru/Zc8k0JP54yrg8Z2gM7x+TOMbFzjO8c83aOBXaO" +
           "JiC9WI/KIYBCIbH5Lfw0Eh0Q20lgCaDphp2j3zl45GRnFcCSzlRDYLjojrKy" +
           "1evRSaEGJNXzl0auv/1W5JkwCgPjpKBsebUjWlI7ZOmzLZVoQF7LVZECkyrL" +
           "142K50BLZ2aOjx27Q5zDXw64whpgMr48wUm8uEU0SAOV9Dad+OizC0/MWx4h" +
           "lNSXQlksW8l5pjMY6qDxSbVrC34p+ep8NIyqgbyAsBmGBAMu7AjuUcI33QXu" +
           "5rbUgcFpy85ig08VCDfCMoALb0RgsEW83wIhbuIJ2A6ZeNXNSPHJZ9sof66X" +
           "mOWYCVghasPXR+nZd3/z1zuFuwtlpMlX/0cJ6/ZRF1fWKkiqxYPgIZsQkPvD" +
           "mcTpx6+eOCzwBxLbKm0Y5c9eoCwIIbj5+69PvffhB+feCXuYZVC7cylog/JF" +
           "I+u4TY0rGMlx7p0HqM8gIl+c6H0moFJP6zhlEJ4k/2ravuulj081SxwYMFKA" +
           "0e03V+CNf2kfeujNB653CDUhlZdez2eemOTztZ7mHtvGs/wc+eOXN/34NXwW" +
           "KgOwsaPPEUGwSPgAiaDdJexXxPPOwNw9/BF1/OAvzS9fi5RUH33n0zVjn168" +
           "Jk5b2mP5Yz2IabeEF39sz4P69UGiOYCdDMjdtTR0f7OxdAM0joNGFSjVGbaB" +
           "+/IlyHCla1a9/4tfth25VIXC/ShiWFjrxyLJUD2gmzgZoM083XuvjO5MnSwy" +
           "YCoqM577c3PlSPVlKRO+nXtl/Yt7frL4gQCVRNFGd7n4soM/uoroEjORYFHz" +
           "o6tEg402Ldd3iJ7p3MMLi9rw07tkd9BaWsv7oFV99nf//nXszB/fqFAcat2+" +
           "0duQU/jWMgofFD2ZRz+7L1+vuvLYhoZy9uaaOpbh5q7luTm4wWsP/6390Dcy" +
           "R74ALW8OeCmo8meD59/Yv0N9LCzaSsnIZe1o6aJuv79gU5tA/2xys/jIGoHd" +
           "zlJq/ArE8xM3rp9UpsYKkCgSznJLA6kZcmPFv2+ABlgAFM+AY6eJyWKyePfx" +
           "d7HnyAqZPcYfg5CYWCxKQNsONYFogIOdK9zBbD0LBD3tdrHKfOuHk0999KzE" +
           "YLDlDQiTkwuPfB47tSDxKO8F28pac/8aeTcQx22WPvsc/kLw/x/+z23hA7I3" +
           "bO11G9QtxQ6V0ryA9QrHElv0/+XC/M9/On8i7Pqmj6HqaUuXl5Hd/DEkM/pr" +
           "/xt38IG9eYZW+1qqQszu+KJ9GViwoeyaKK826nOLTXXrF+/7vWgHitePBiik" +
           "6Zxh+CDsh3MttUlaF4Y2SBqm4iPD0JabHY6hiPdFmDQhF0/C/aniYnAl//DL" +
           "wsWkOSjLUI349MtNwW6eHLCWfPGLMIaqQIS/5mhJWuRjzgxcF2M9KWi1AOMy" +
           "CvlQOU2LAK+7WYB9vLytJD/ETb/APTl510+qFxYPDj147Z6nZcOjGnhuTtwM" +
           "4aIre68if21dVltBV+2BnTcan6/fXoBnizywxyobfXm9F/iB8urVHugGnGix" +
           "KXjv3J6Lb52svQyZeBiFMENrD/vu2fJSCS1FDsj1cNxfFHy/F4lGpTvy5yNv" +
           "/+P9UKsogW4Z6VhpRVI9ffFKIk3pk2FUP4BqIPtIfhxFdOebs+YIUaehWNfl" +
           "TH0qRwY0wGrKypnFHwUaOcIx/xVAeMZ16JriKG+YGeos55TySwR0B5Bg+7h2" +
           "wekBxs9R6p/N88tyBasgNrvO/vPYD94dhgwsObhf2yonlyoWD/9vDl41aeaP" +
           "+/OSyaqS8UFKC8x2RUSVUsEqPxRGn5DSXIKhUBel/wXVEUUlOxQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9D/+x3VKyDPLDbbmU/gz+PmPXybe9t0cfxfiGfaD6fUJGdRzO1z0086/7T16" +
           "65/vQbfNoEvKQbEoSnacBc4MFEjhYQUJCsoT8yeLne3OfvUohb3hdHo5tuzp" +
           "5LLbCMA4g87GF47nkx+Dzxnw/Z/sm6k7e7HdYu8hDvb5h482et9Pz4BoPYfu" +
           "V/eRDP/tOZVH8ueV7PFTWzNlw58GYR3mVSrA0C1XsvOFn4yAi9nKlUPqIqha" +
           "gU2uzO1qTuZeUKfn7pRJv78t9bYJLXuiOYmtS5Rv6j4/u4XKd667dsQYD1SN" +
           "H/ynZ7724ce+BWzagc6tMn0DUx5bsR9nhfT7nv/IA3c8++0P5lkKpCjuo61L" +
           "T2ZUmZeTOHu0sgd5KOrlTFQ+LwEYKYx6eWLR1Fzal3VlsAc7IP+uDqpE+Kl7" +
           "vrX4+Hc+s60AT/vtKWDtA8/+2o/3P/Ts3rG6+7HrSt/jONvaO2f6NQcaDqBH" +
           "Xm6VHIP858899ce/+9T7t1zdc7KKbIFD0mf++r+/tv+xb3/lBmXJLbb3fzBs" +
           "dMcP2lhI1w8/PXEqo4mSDsc6Cxc6+qRdY2rDTlujFxtL5JsMYpcFWGCdYjJp" +
           "RqkWzDg1aAhmqTtDy6WNLK9LLF5Rw1rBkQ2Td8oDrsV3Kd+bY0KxIZN1k6A7" +
           "9SVtayLhmbzd4IsDcugVBwWbEdoLAnXEaDXqb/rVqBRVZ90ZvlxPomoPhbVN" +
           "e7XCS9XVZobCluMpVEnkZcrDUmfqK2O6A/vVerRgkYnRq26s1nQkLTmYdZFQ" +
           "i+FgVNOGwWS+bFJNV2iJbGWodzDZmXf7/TheJHI3aFF8p4WtQ77vUjQ3RWey" +
           "786lTiluUrzvSWGFqg6QxJhQYaPYZmZGOkZgm2rYCTkiEJYvsx42H3WbxYah" +
           "YZhk1yM2BlFL4DOEjWWs2pnJm0Lb02RMGK379nAzavLjmK0kVbnCyUtq0huZ" +
           "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" +
           "+Z3nvpk3xf4XQiTyCrUfAAA=");
    }
    public class SaveAsAction extends javax.swing.AbstractAction {
        public SaveAsAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.JFileChooser fileChooser;
            fileChooser =
              new javax.swing.JFileChooser(
                makeAbsolute(
                  currentSavePath));
            fileChooser.
              setDialogTitle(
                resources.
                  getString(
                    "SaveAs.title"));
            fileChooser.
              setFileHidingEnabled(
                false);
            fileChooser.
              setFileSelectionMode(
                javax.swing.JFileChooser.
                  FILES_ONLY);
            fileChooser.
              addChoosableFileFilter(
                new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ImageFileFilter(
                  ".svg"));
            int choice =
              fileChooser.
              showSaveDialog(
                JSVGViewerFrame.this);
            if (choice !=
                  javax.swing.JFileChooser.
                    APPROVE_OPTION)
                return;
            final java.io.File f =
              fileChooser.
              getSelectedFile(
                );
            org.apache.batik.apps.svgbrowser.SVGOptionPanel sop;
            sop =
              org.apache.batik.apps.svgbrowser.SVGOptionPanel.
                showDialog(
                  JSVGViewerFrame.this);
            final boolean useXMLBase =
              sop.
              getUseXMLBase(
                );
            final boolean prettyPrint =
              sop.
              getPrettyPrint(
                );
            sop =
              null;
            final org.w3c.dom.svg.SVGDocument svgDoc =
              svgCanvas.
              getSVGDocument(
                );
            if (svgDoc ==
                  null)
                return;
            statusBar.
              setMessage(
                resources.
                  getString(
                    "Message.saveAs"));
            currentSavePath =
              f;
            java.io.OutputStreamWriter w =
              null;
            try {
                java.io.OutputStream tos =
                  null;
                tos =
                  new java.io.FileOutputStream(
                    f);
                tos =
                  new java.io.BufferedOutputStream(
                    tos);
                w =
                  new java.io.OutputStreamWriter(
                    tos,
                    "utf-8");
            }
            catch (java.lang.Exception ex) {
                userAgent.
                  displayError(
                    ex);
                return;
            }
            final java.io.OutputStreamWriter writer =
              w;
            final java.lang.Runnable doneRun =
              new java.lang.Runnable(
              ) {
                public void run() {
                    java.lang.String doneStr =
                      resources.
                      getString(
                        "Message.done");
                    statusBar.
                      setMessage(
                        doneStr);
                }
            };
            java.lang.Runnable r =
              new java.lang.Runnable(
              ) {
                public void run() {
                    try {
                        writer.
                          write(
                            "<?xml version=\"1.0\" encoding=\"utf-8\"?>");
                        writer.
                          write(
                            EOL);
                        org.w3c.dom.Node fc =
                          svgDoc.
                          getFirstChild(
                            );
                        if (fc.
                              getNodeType(
                                ) !=
                              org.w3c.dom.Node.
                                DOCUMENT_TYPE_NODE) {
                            writer.
                              write(
                                "<!DOCTYPE svg PUBLIC \'");
                            writer.
                              write(
                                org.apache.batik.util.SVGConstants.
                                  SVG_PUBLIC_ID);
                            writer.
                              write(
                                "\' \'");
                            writer.
                              write(
                                org.apache.batik.util.SVGConstants.
                                  SVG_SYSTEM_ID);
                            writer.
                              write(
                                "\'>");
                            writer.
                              write(
                                EOL);
                            writer.
                              write(
                                EOL);
                        }
                        org.w3c.dom.Element root =
                          svgDoc.
                          getRootElement(
                            );
                        boolean doXMLBase =
                          useXMLBase;
                        if (root.
                              hasAttributeNS(
                                org.apache.batik.util.XMLConstants.
                                  XML_NAMESPACE_URI,
                                "base"))
                            doXMLBase =
                              false;
                        if (doXMLBase) {
                            root.
                              setAttributeNS(
                                org.apache.batik.util.XMLConstants.
                                  XML_NAMESPACE_URI,
                                "xml:base",
                                svgDoc.
                                  getURL(
                                    ));
                        }
                        if (prettyPrint) {
                            org.apache.batik.transcoder.svg2svg.SVGTranscoder trans =
                              new org.apache.batik.transcoder.svg2svg.SVGTranscoder(
                              );
                            trans.
                              transcode(
                                new org.apache.batik.transcoder.TranscoderInput(
                                  svgDoc),
                                new org.apache.batik.transcoder.TranscoderOutput(
                                  writer));
                        }
                        else {
                            org.apache.batik.dom.util.DOMUtilities.
                              writeDocument(
                                svgDoc,
                                writer);
                        }
                        writer.
                          close(
                            );
                        if (doXMLBase)
                            root.
                              removeAttributeNS(
                                org.apache.batik.util.XMLConstants.
                                  XML_NAMESPACE_URI,
                                "xml:base");
                        if (java.awt.EventQueue.
                              isDispatchThread(
                                )) {
                            doneRun.
                              run(
                                );
                        }
                        else {
                            java.awt.EventQueue.
                              invokeLater(
                                doneRun);
                        }
                    }
                    catch (java.lang.Exception ex) {
                        userAgent.
                          displayError(
                            ex);
                    }
                }
            };
            org.apache.batik.bridge.UpdateManager um =
              svgCanvas.
              getUpdateManager(
                );
            if (um !=
                  null &&
                  um.
                  isRunning(
                    )) {
                um.
                  getUpdateRunnableQueue(
                    ).
                  invokeLater(
                    r);
            }
            else {
                r.
                  run(
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
           "iv0vZt4yU7cfAAA=");
    }
    public class ExportAsJPGAction extends javax.swing.AbstractAction {
        public ExportAsJPGAction() { super(
                                       );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.JFileChooser fileChooser =
              new javax.swing.JFileChooser(
              makeAbsolute(
                currentSavePath));
            fileChooser.
              setDialogTitle(
                resources.
                  getString(
                    "ExportAsJPG.title"));
            fileChooser.
              setFileHidingEnabled(
                false);
            fileChooser.
              setFileSelectionMode(
                javax.swing.JFileChooser.
                  FILES_ONLY);
            fileChooser.
              addChoosableFileFilter(
                new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ImageFileFilter(
                  ".jpg"));
            int choice =
              fileChooser.
              showSaveDialog(
                JSVGViewerFrame.this);
            if (choice ==
                  javax.swing.JFileChooser.
                    APPROVE_OPTION) {
                float quality =
                  org.apache.batik.apps.svgbrowser.JPEGOptionPanel.
                  showDialog(
                    JSVGViewerFrame.this);
                final java.io.File f =
                  fileChooser.
                  getSelectedFile(
                    );
                java.awt.image.BufferedImage buffer =
                  svgCanvas.
                  getOffScreen(
                    );
                if (buffer !=
                      null) {
                    statusBar.
                      setMessage(
                        resources.
                          getString(
                            "Message.exportAsJPG"));
                    int w =
                      buffer.
                      getWidth(
                        );
                    int h =
                      buffer.
                      getHeight(
                        );
                    final org.apache.batik.transcoder.image.ImageTranscoder trans =
                      new org.apache.batik.transcoder.image.JPEGTranscoder(
                      );
                    if (application.
                          getXMLParserClassName(
                            ) !=
                          null) {
                        trans.
                          addTranscodingHint(
                            org.apache.batik.transcoder.image.JPEGTranscoder.
                              KEY_XML_PARSER_CLASSNAME,
                            application.
                              getXMLParserClassName(
                                ));
                    }
                    trans.
                      addTranscodingHint(
                        org.apache.batik.transcoder.image.JPEGTranscoder.
                          KEY_QUALITY,
                        new java.lang.Float(
                          quality));
                    final java.awt.image.BufferedImage img =
                      trans.
                      createImage(
                        w,
                        h);
                    java.awt.Graphics2D g2d =
                      img.
                      createGraphics(
                        );
                    g2d.
                      setColor(
                        java.awt.Color.
                          white);
                    g2d.
                      fillRect(
                        0,
                        0,
                        w,
                        h);
                    g2d.
                      drawImage(
                        buffer,
                        null,
                        0,
                        0);
                    new java.lang.Thread(
                      ) {
                        public void run() {
                            try {
                                currentSavePath =
                                  f;
                                java.io.OutputStream ostream =
                                  new java.io.BufferedOutputStream(
                                  new java.io.FileOutputStream(
                                    f));
                                trans.
                                  writeImage(
                                    img,
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      ostream));
                                ostream.
                                  close(
                                    );
                            }
                            catch (java.lang.Exception ex) {
                                
                            }
                            statusBar.
                              setMessage(
                                resources.
                                  getString(
                                    "Message.done"));
                        }
                    }.
                      start(
                        );
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fGUD9Ku4fWyHHssebzwqUuX1iYunS9THi1S7ygWU3ageutVbhPw29clnn7+u" +
           "9j5V3Duo+EzABfrg5c5OTnalferW18ZO/gZlV4b40rP/+uDobfN3vYri6iOn" +
           "Fnla5O91XvhK603Kb+xBZ4+KEje82znJdPVkKeKir4WRb49OFCQeOlngRMF2" +
           "Xj/Y1us3L3De1AXO5C6wNfypatqZgw08qDI8mN/55Rjs4lqzw/1twZvK2jl7" +
           "8DLFuDh72CF0Sc6Z+pqflXG17asr/pgzieCiu3ZMdedlzivdcU/UvoDv3lCT" +
           "P1Sg8GrL+8B1HrjhbeP2DZny2euXLrz++vhv8nL20VusOzjogh5Z1vE60rH2" +
           "edfXdDPfkTu2VSU3//nlEHr0lRYXQhd3f3KVnt0yvy+E7rspM9jK7Oc47a+G" +
           "0OXTtCF0Lv89TvfrYLYdHYirbeM4yYdD6CwgyZrPuSd8JNkPYtM29vFZALIC" +
           "JdxaITlzMrqPDHzvKxn4GCA8cSKS8xfGh1EXbV8ZX1M+d53tvvulyqe2BXvF" +
           "ktM0k3KBg27fvjs4itzHbintUNZ5+skf3f35O954CDF3bxe8i6dja3vk5tVx" +
           "auWGeT07/aPX/8Fbfuf6N/MS2f8CHXQEK8kfAAA=");
    }
    public class ExportAsPNGAction extends javax.swing.AbstractAction {
        public ExportAsPNGAction() { super(
                                       );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.JFileChooser fileChooser =
              new javax.swing.JFileChooser(
              makeAbsolute(
                currentSavePath));
            fileChooser.
              setDialogTitle(
                resources.
                  getString(
                    "ExportAsPNG.title"));
            fileChooser.
              setFileHidingEnabled(
                false);
            fileChooser.
              setFileSelectionMode(
                javax.swing.JFileChooser.
                  FILES_ONLY);
            fileChooser.
              addChoosableFileFilter(
                new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ImageFileFilter(
                  ".png"));
            int choice =
              fileChooser.
              showSaveDialog(
                JSVGViewerFrame.this);
            if (choice ==
                  javax.swing.JFileChooser.
                    APPROVE_OPTION) {
                boolean isIndexed =
                  org.apache.batik.apps.svgbrowser.PNGOptionPanel.
                  showDialog(
                    JSVGViewerFrame.this);
                final java.io.File f =
                  fileChooser.
                  getSelectedFile(
                    );
                java.awt.image.BufferedImage buffer =
                  svgCanvas.
                  getOffScreen(
                    );
                if (buffer !=
                      null) {
                    statusBar.
                      setMessage(
                        resources.
                          getString(
                            "Message.exportAsPNG"));
                    int w =
                      buffer.
                      getWidth(
                        );
                    int h =
                      buffer.
                      getHeight(
                        );
                    final org.apache.batik.transcoder.image.ImageTranscoder trans =
                      new org.apache.batik.transcoder.image.PNGTranscoder(
                      );
                    if (application.
                          getXMLParserClassName(
                            ) !=
                          null) {
                        trans.
                          addTranscodingHint(
                            org.apache.batik.transcoder.image.JPEGTranscoder.
                              KEY_XML_PARSER_CLASSNAME,
                            application.
                              getXMLParserClassName(
                                ));
                    }
                    trans.
                      addTranscodingHint(
                        org.apache.batik.transcoder.image.PNGTranscoder.
                          KEY_FORCE_TRANSPARENT_WHITE,
                        java.lang.Boolean.
                          TRUE);
                    if (isIndexed) {
                        trans.
                          addTranscodingHint(
                            org.apache.batik.transcoder.image.PNGTranscoder.
                              KEY_INDEXED,
                            new java.lang.Integer(
                              256));
                    }
                    final java.awt.image.BufferedImage img =
                      trans.
                      createImage(
                        w,
                        h);
                    java.awt.Graphics2D g2d =
                      img.
                      createGraphics(
                        );
                    g2d.
                      drawImage(
                        buffer,
                        null,
                        0,
                        0);
                    new java.lang.Thread(
                      ) {
                        public void run() {
                            try {
                                currentSavePath =
                                  f;
                                java.io.OutputStream ostream =
                                  new java.io.BufferedOutputStream(
                                  new java.io.FileOutputStream(
                                    f));
                                trans.
                                  writeImage(
                                    img,
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      ostream));
                                ostream.
                                  close(
                                    );
                            }
                            catch (java.lang.Exception ex) {
                                
                            }
                            statusBar.
                              setMessage(
                                resources.
                                  getString(
                                    "Message.done"));
                        }
                    }.
                      start(
                        );
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "b/7otX/wpt957pt5i+x/AfU9IybJHwAA");
    }
    public class ExportAsTIFFAction extends javax.swing.AbstractAction {
        public ExportAsTIFFAction() { super(
                                        );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.JFileChooser fileChooser =
              new javax.swing.JFileChooser(
              makeAbsolute(
                currentSavePath));
            fileChooser.
              setDialogTitle(
                resources.
                  getString(
                    "ExportAsTIFF.title"));
            fileChooser.
              setFileHidingEnabled(
                false);
            fileChooser.
              setFileSelectionMode(
                javax.swing.JFileChooser.
                  FILES_ONLY);
            fileChooser.
              addChoosableFileFilter(
                new org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ImageFileFilter(
                  ".tiff"));
            int choice =
              fileChooser.
              showSaveDialog(
                JSVGViewerFrame.this);
            if (choice ==
                  javax.swing.JFileChooser.
                    APPROVE_OPTION) {
                final java.io.File f =
                  fileChooser.
                  getSelectedFile(
                    );
                java.awt.image.BufferedImage buffer =
                  svgCanvas.
                  getOffScreen(
                    );
                if (buffer !=
                      null) {
                    statusBar.
                      setMessage(
                        resources.
                          getString(
                            "Message.exportAsTIFF"));
                    int w =
                      buffer.
                      getWidth(
                        );
                    int h =
                      buffer.
                      getHeight(
                        );
                    final org.apache.batik.transcoder.image.ImageTranscoder trans =
                      new org.apache.batik.transcoder.image.TIFFTranscoder(
                      );
                    if (application.
                          getXMLParserClassName(
                            ) !=
                          null) {
                        trans.
                          addTranscodingHint(
                            org.apache.batik.transcoder.image.JPEGTranscoder.
                              KEY_XML_PARSER_CLASSNAME,
                            application.
                              getXMLParserClassName(
                                ));
                    }
                    final java.awt.image.BufferedImage img =
                      trans.
                      createImage(
                        w,
                        h);
                    java.awt.Graphics2D g2d =
                      img.
                      createGraphics(
                        );
                    g2d.
                      drawImage(
                        buffer,
                        null,
                        0,
                        0);
                    new java.lang.Thread(
                      ) {
                        public void run() {
                            try {
                                currentSavePath =
                                  f;
                                java.io.OutputStream ostream =
                                  new java.io.BufferedOutputStream(
                                  new java.io.FileOutputStream(
                                    f));
                                trans.
                                  writeImage(
                                    img,
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      ostream));
                                ostream.
                                  close(
                                    );
                            }
                            catch (java.lang.Exception ex) {
                                
                            }
                            statusBar.
                              setMessage(
                                resources.
                                  getString(
                                    "Message.done"));
                        }
                    }.
                      start(
                        );
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYfWwcRxWfO39fHH+lcULSOLZziRS33Db0IwIHUsfYicPZ" +
           "PtmpJZzSy9zunG/jvd3x7px9djFpKkFC/4iqxi2havxXKqBKmwpRgYQaGSHR" +
           "VqVUCRX0Q7QgkCgfkZp/GlCA8mZm73Zv7+zQv7Dkvb2ZN2/mvfd7v/fmLl5D" +
           "NY6Nuik2NRxj85Q4sQR/T2DbIVq/gR3nCIwm1cf+cPbEjV83nAyj2knUlMHO" +
           "sIodMqgTQ3Mm0TbddBg2VeKMEKLxFQmbOMSexUy3zEm0UXeGstTQVZ0NWxrh" +
           "AhPYjqNWzJitp3KMDLkKGNoeF6dRxGmUvqBAbxw1qhad9xZsKVnQ75vjsllv" +
           "P4ehlvhxPIuVHNMNJa47rDdvozuoZcxPGRaLkTyLHTfudR1xOH5vmRu6X2z+" +
           "+ObjmRbhhg3YNC0mTHTGiGMZs0SLo2ZvdMAgWWcGfQNVxdE6nzBD0XhhUwU2" +
           "VWDTgr2eFJx+PTFz2X5LmMMKmmqpyg/EUFepEoptnHXVJMSZQUM9c20Xi8Ha" +
           "zqK1hXAHTHzyDmXpOw+1/LAKNU+iZt0c58dR4RAMNpkEh5JsithOn6YRbRK1" +
           "mhDwcWLr2NAX3Gi3OfqUiVkOIFBwCx/MUWKLPT1fQSTBNjunMssumpcWoHK/" +
           "1aQNPAW2tnu2SgsH+TgYGNHhYHYaA/bcJdXTuqkJHJWuKNoY/QoIwNK6LGEZ" +
           "q7hVtYlhALVJiBjYnFLGAXzmFIjWWABBW2BtFaXc1xSr03iKJBnaHJRLyCmQ" +
           "ahCO4EsY2hgUE5ogSlsCUfLF59rIvjMPm4fMMArBmTWiGvz862BRR2DRGEkT" +
           "m0AeyIWNPfGncPvLp8MIgfDGgLCU+fHXr99/Z8fKq1JmawWZ0dRxorKkeiHV" +
           "dOX2/t2fr+LHqKeWo/Pgl1gusizhzvTmKTBNe1Ejn4wVJlfGfvHVR54jfwuj" +
           "yBCqVS0jlwUctapWluoGsQ8Sk9iYEW0INRBT6xfzQ6gO3uO6SeToaDrtEDaE" +
           "qg0xVGuJ7+CiNKjgLorAu26mrcI7xSwj3vMUIbQO/lELQnXbkfiTnwzNKBkr" +
           "SxSsYlM3LSVhW9x+HlDBOcSBdw1mqaWkAP/Tn90T26s4Vs4GQCqWPaVgQEWG" +
           "yEn4Qh3FmZ1K2dYc8KNyeHzi4IRO5og9CMlLYhx69P+xaZ57YsNcKARBuj1I" +
           "EQZk1yHL0IidVJdyBwauv5B8XcKPp4zrQ4b6YeeY3Dkmdo7xnWPezrHAztGB" +
           "PLVs1uccGRoc7FM5ElAoJM5wGz+UBAmEeBrIAti6cff41w4fO91dBeikc9UQ" +
           "Hy66q6x69XusUigFSfXilbEbb74ReS6MwkA8KaheXgmJlpQQWQFtSyUacNhq" +
           "xaRAqMrq5aPiOdDKubmTEyfuEufwVwWusAYIjS9PcC4vbhENskElvc2nPvz4" +
           "0lOLlscLJWWmUB3LVnK66Q5GPGh8Uu3pxC8lX16MhlE1cBjwNsOQZ0CJHcE9" +
           "Smint0Dh3JZ6MDht2Vls8KkC70ZYBuDhjQgotor32yDEzTwPuyAhO93EFJ98" +
           "tp3y5yYJXY6ZgBWiRHxxnJ5/+1d/uVu4u1BNmn1twDhhvT4G48raBFe1ehA8" +
           "YhMCcr87lzj75LVTRwX+QGJHpQ2j/NkPzAUhBDd/89WZdz54/8JbYQ+zDEp4" +
           "LgXdUL5oZD23qWkNIznOvfMAAxpE5IsTfcAEVOppHacMwpPkX80797z09zMt" +
           "EgcGjBRgdOetFXjjnzmAHnn9oRsdQk1I5RXY85knJml9g6e5z7bxPD9H/uTV" +
           "bd99BZ+HAgGk7OgLRPAsEj5AImj3CPsV8bw7MHcff0QdP/hL88vXKSXVx9/6" +
           "aP3ER5evi9OWtlr+WA9j2ivhxR8786B+U5BoDmEnA3L3rIw82GKs3ASNk6BR" +
           "BWZ1Rm2gwHwJMlzpmrp3f/bz9mNXqlB4EEUMC2uDWCQZagB0EycD7Jmn+++X" +
           "0Z2rl7UGTEVlxnN/bq8cqYEsZcK3Cz/Z9KN931t+X4BKomiru1x82cUfPUV0" +
           "iZlIsLb50VWiwUbbVms/ROt04dGlZW302T2ySWgrLekD0LE+/5t//zJ27vev" +
           "VagRtW776G3IKbyrjMKHRWvm0c/eqzeq3ntic2M5e3NNHatwc8/q3Bzc4JVH" +
           "/7rlyJcyxz4FLW8PeCmo8gfDF187uEt9Iiy6S8nIZV1p6aJev79gU5tAG21y" +
           "s/jIeoHd7lJq/BzEs8uNa1dlaqwAiSLhrLY0kJohN1b8+2bogwVA8Rw4dpaY" +
           "LCaL9wB/F3uOrZHZE/wxDImJxaIEdO9QE4gGONi9xlXM1rNA0LNuM6sstn0w" +
           "/cyHz0sMBjvfgDA5vfTYJ7EzSxKP8nqwo6xD96+RVwRx3Bbps0/gLwT//+H/" +
           "3BY+IFvEtn63T+0sNqqU5gWs1ziW2GLwz5cWf/r9xVNh1zcDDFXPWrq8k+zl" +
           "jxGZ0V/437iDD+zPw5HKO6tC6O76tF0aGLK57NIoLzrqC8vN9ZuWH/it6AqK" +
           "l5FGqKfpnGH4kOxHdS21SVoX9jZKNqbiI8NQ560Ox1DE+yJMmpKLp+E2VXEx" +
           "eJR/+GXhmtISlGWoRnz65WZgN08OyEu++EUYQ1Ugwl9ztCQ78jFnDi6Psb4U" +
           "dFwAdRmFfKicrUWcN94qzj563lGSJuLeX6CgnLz5J9VLy4dHHr5+37Oy71EN" +
           "vLAg7olw7ZUtWJHGulbVVtBVe2j3zaYXG3YWUNoqD+yRy1Zfeu8HmqC8iG0J" +
           "NAVOtNgbvHNh3+U3TtdehYQ8ikKYoQ1HfbduecWEziIHHHs07q8Nvl+PRL/S" +
           "G/njsTf/8W6oTVRCt5p0rLUiqZ69/F4iTenTYdQwhGogCUl+EkV058vz5hhR" +
           "Z6Fm1+dMfSZHhjTAasrKmcWfCJo4wjH/TUB4xnXo+uIo75sZ6i6nlvK7BDQJ" +
           "kGAHuHZB7QHiz1Hqn83zq3MFqyA2e87/88S33h6FDCw5uF9bnZNLFWuI/xcI" +
           "r6i08MeDeUloVcn4MKUFgvuTiCqlgly+LYw+JaW5BEOhHkr/C0MAtrpJFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "2QT1Kk4e26mr2eWNRw2qvDdx8XR/+niDate1gLLT1IO3eoWQn6Q++cxzzyv9" +
           "T5X2Dro9U3B4Pnizs5OTHWefuPWRkclfn+xaEF965p8fGL/VeOeraKw+fGqT" +
           "p0X+DvPCV8g3yb+2B509akjc8GLnJNOTJ9sQF301jHxnfKIZ8eDJ5mYZmPPq" +
           "gVmv3ry5edMQOJOHwNbxpzppZw4MeNBheCA/70sxsOJadcL9bbObyMY5e/Ay" +
           "jbg4uzghdEnKmQaqn7Vw1e17q9GxYBLAIXftmsouytxXOt+e6HuF0JUbG/KH" +
           "GhRfbXMfxM79N7xr3L4fkz/7/KULr39+8ld5L/voHdYdNHRBiyzreBPp2Ph2" +
           "z1c1MzfJHduWkpf//GIIPfJKmwuhi7s/uUrPbJnfF0L33pQZ2DL7OU77yyF0" +
           "+TRtCJ3Lf4/T/SpYbUcHEms7OE7y4RA6C0iy4bPeiSBJ9oPYdPR9bB6EPvD4" +
           "1gvJmZPpfeThK6/k4WOI8NiJVM5fFx+mXbR9YXxd/tzzXfZdL9U+te3Wy5aU" +
           "ppmUCzR0fvvi4Ch1r95S2qGs26nHf3j35+944yHG3L3d8C6hju3t4Zu3xgnb" +
           "C/NmdvoHr/+9t/zW89/M+2P/CzDyQ03HHwAA");
    }
    public class ViewSourceAction extends javax.swing.AbstractAction {
        public ViewSourceAction() { super(
                                      ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (svgDocument ==
                  null) {
                return;
            }
            final org.apache.batik.util.ParsedURL u =
              new org.apache.batik.util.ParsedURL(
              svgDocument.
                getURL(
                  ));
            final javax.swing.JFrame fr =
              new javax.swing.JFrame(
              u.
                toString(
                  ));
            fr.
              setSize(
                resources.
                  getInteger(
                    "ViewSource.width"),
                resources.
                  getInteger(
                    "ViewSource.height"));
            final org.apache.batik.util.gui.xmleditor.XMLTextEditor ta =
              new org.apache.batik.util.gui.xmleditor.XMLTextEditor(
              );
            ta.
              setFont(
                new java.awt.Font(
                  "monospaced",
                  java.awt.Font.
                    PLAIN,
                  12));
            javax.swing.JScrollPane scroll =
              new javax.swing.JScrollPane(
              );
            scroll.
              getViewport(
                ).
              add(
                ta);
            scroll.
              setVerticalScrollBarPolicy(
                javax.swing.JScrollPane.
                  VERTICAL_SCROLLBAR_ALWAYS);
            fr.
              getContentPane(
                ).
              add(
                scroll,
                java.awt.BorderLayout.
                  CENTER);
            new java.lang.Thread(
              ) {
                public void run() {
                    char[] buffer =
                      new char[4096];
                    try {
                        javax.swing.text.Document doc =
                          new org.apache.batik.util.gui.xmleditor.XMLDocument(
                          );
                        org.apache.batik.util.ParsedURL purl =
                          new org.apache.batik.util.ParsedURL(
                          svgDocument.
                            getURL(
                              ));
                        java.io.InputStream is =
                          u.
                          openStream(
                            getInputHandler(
                              purl).
                              getHandledMimeTypes(
                                ));
                        java.io.Reader in =
                          org.apache.batik.xml.XMLUtilities.
                          createXMLDocumentReader(
                            is);
                        int len;
                        while ((len =
                                  in.
                                    read(
                                      buffer,
                                      0,
                                      buffer.
                                        length)) !=
                                 -1) {
                            doc.
                              insertString(
                                doc.
                                  getLength(
                                    ),
                                new java.lang.String(
                                  buffer,
                                  0,
                                  len),
                                null);
                        }
                        ta.
                          setDocument(
                            doc);
                        ta.
                          setEditable(
                            false);
                        fr.
                          setVisible(
                            true);
                    }
                    catch (java.lang.Exception ex) {
                        userAgent.
                          displayError(
                            ex);
                    }
                }
            }.
              start(
                );
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
           "xv4XBIhgwb8fAAA=");
    }
    public class FlushAction extends javax.swing.AbstractAction {
        public FlushAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            svgCanvas.
              flush(
                );
            svgCanvas.
              setRenderingTransform(
                svgCanvas.
                  getRenderingTransform(
                    ));
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
           "337+m3lT7H8BVR2Yk7UfAAA=");
    }
    public class ToggleDebuggerAction extends javax.swing.AbstractAction {
        public ToggleDebuggerAction() { super(
                                          "Toggle Debugger Action");
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (debugger ==
                  null) {
                showDebugger(
                  );
            }
            else {
                hideDebugger(
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
          ("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" +
           "TRQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class PreviousTransformAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public PreviousTransformAction() {
            super(
              );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (transformHistory.
                  canGoBack(
                    )) {
                transformHistory.
                  back(
                    );
                update(
                  );
                nextTransformAction.
                  update(
                    );
                svgCanvas.
                  setRenderingTransform(
                    transformHistory.
                      currentTransform(
                        ));
            }
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { boolean b =
                                    transformHistory.
                                    canGoBack(
                                      );
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      ((javax.swing.JComponent)
                                         it.
                                         next(
                                           )).
                                        setEnabled(
                                          b);
                                  } }
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
          ("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");
    }
    public class NextTransformAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public NextTransformAction() { super(
                                         );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (transformHistory.
                  canGoForward(
                    )) {
                transformHistory.
                  forward(
                    );
                update(
                  );
                previousTransformAction.
                  update(
                    );
                svgCanvas.
                  setRenderingTransform(
                    transformHistory.
                      currentTransform(
                        ));
            }
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { boolean b =
                                    transformHistory.
                                    canGoForward(
                                      );
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      ((javax.swing.JComponent)
                                         it.
                                         next(
                                           )).
                                        setEnabled(
                                          b);
                                  } }
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
           "KlATLCYAAA==");
    }
    public class UseStylesheetAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public UseStylesheetAction() { super(
                                         );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        protected void update() { alternateStyleSheet =
                                    null;
                                  java.util.Iterator it =
                                    components.
                                    iterator(
                                      );
                                  org.w3c.dom.svg.SVGDocument doc =
                                    svgCanvas.
                                    getSVGDocument(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      javax.swing.JComponent stylesheetMenu =
                                        (javax.swing.JComponent)
                                          it.
                                          next(
                                            );
                                      stylesheetMenu.
                                        removeAll(
                                          );
                                      stylesheetMenu.
                                        setEnabled(
                                          false);
                                      javax.swing.ButtonGroup buttonGroup =
                                        new javax.swing.ButtonGroup(
                                        );
                                      for (org.w3c.dom.Node n =
                                             doc.
                                             getFirstChild(
                                               );
                                           n !=
                                             null &&
                                             n.
                                             getNodeType(
                                               ) !=
                                             org.w3c.dom.Node.
                                               ELEMENT_NODE;
                                           n =
                                             n.
                                               getNextSibling(
                                                 )) {
                                          if (n instanceof org.apache.batik.dom.StyleSheetProcessingInstruction) {
                                              org.apache.batik.dom.StyleSheetProcessingInstruction sspi;
                                              sspi =
                                                (org.apache.batik.dom.StyleSheetProcessingInstruction)
                                                  n;
                                              org.apache.batik.dom.util.HashTable attrs =
                                                sspi.
                                                getPseudoAttributes(
                                                  );
                                              final java.lang.String title =
                                                (java.lang.String)
                                                  attrs.
                                                  get(
                                                    "title");
                                              java.lang.String alt =
                                                (java.lang.String)
                                                  attrs.
                                                  get(
                                                    "alternate");
                                              if (title !=
                                                    null &&
                                                    "yes".
                                                    equals(
                                                      alt)) {
                                                  javax.swing.JRadioButtonMenuItem button;
                                                  button =
                                                    new javax.swing.JRadioButtonMenuItem(
                                                      title);
                                                  button.
                                                    addActionListener(
                                                      new java.awt.event.ActionListener(
                                                        ) {
                                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                                              org.apache.batik.dom.svg.SVGOMDocument doc;
                                                              doc =
                                                                (org.apache.batik.dom.svg.SVGOMDocument)
                                                                  svgCanvas.
                                                                  getSVGDocument(
                                                                    );
                                                              doc.
                                                                clearViewCSS(
                                                                  );
                                                              alternateStyleSheet =
                                                                title;
                                                              svgCanvas.
                                                                setSVGDocument(
                                                                  doc);
                                                          }
                                                      });
                                                  buttonGroup.
                                                    add(
                                                      button);
                                                  stylesheetMenu.
                                                    add(
                                                      button);
                                                  stylesheetMenu.
                                                    setEnabled(
                                                      true);
                                              }
                                          }
                                      }
                                  } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYa2wU1xW+u34b8ItgqHkZY6h4dDeEAGpMQ4zDw2QNWxus" +
           "1hSW2Zm79sDszDBz115DKQEpwYoihMKjtAV+pOSFIKA2qG2qUFdVSyKaImjU" +
           "JqFN0vAjUIISIiVOS9v03Htndh77QKhVu9LenZ177uOc853vnHtP3kQlpoGa" +
           "dEGVhBAZ1LEZitLnqGCYWGpTBNNcC29j4hN/2b9z5PcVu4KotAdV9QlmhyiY" +
           "eLmMFcnsQZNl1SSCKmJzNcYSHRE1sImNfoHImtqDxslme1JXZFEmHZqEqUC3" +
           "YERQrUCIIcdTBLdbExA0NcJ2E2a7Cbf6BVoiaLSo6YPOgAbPgDZXH5VNOuuZ" +
           "BNVENgv9QjhFZCUckU3SkjbQHF1TBnsVjYRwmoQ2KwssQ6yKLMgyQ9OZ6s9u" +
           "7+urYWYYK6iqRpiKZic2NaUfSxFU7bxdpuCkuRV9BxVF0CiXMEHNEXvRMCwa" +
           "hkVtfR0p2P0YrKaSbRpTh9gzleoi3RBB07yT6IIhJK1pomzPMEM5sXRng0Hb" +
           "xoy2trt9Kh6cEz7w3Y01PypC1T2oWla76HZE2ASBRXrAoDgZx4bZKklY6kG1" +
           "Kji8CxuyoMjbLG/XmXKvKpAUQMA2C32Z0rHB1nRsBZ4E3YyUSDQjo16Cgcr6" +
           "V5JQhF7Qtd7RlWu4nL4HBStl2JiREAB71pDiLbIqMRx5R2R0bH4EBGBoWRKT" +
           "Pi2zVLEqwAtUxyGiCGpvuAvAp/aCaIkGEDQY1vJMSm2tC+IWoRfHCJrgl4vy" +
           "LpCqYIagQwga5xdjM4GXGnxecvnn5urFe7erK9UgCsCeJSwqdP+jYNAU36BO" +
           "nMAGhjjgA0fPjhwS6l8ZCiIEwuN8wlzmJ9++9dDcKcOvcpmJOWTWxDdjkcTE" +
           "4/GqS5PaZn21iG6jXNdMmTrfozmLsqjV05LWgWnqMzPSzpDdOdz5m28+egLf" +
           "CKLKdlQqakoqCTiqFbWkLivYWIFVbAgES+2oAqtSG+tvR2XwHJFVzN+uSSRM" +
           "TNpRscJelWrsP5goAVNQE1XCs6wmNPtZF0gfe07rCKFR8EVLESq7jtin7Bpt" +
           "Cdoa7tOSOCyIgiqrWjhqaFR/6lDGOdiEZwl6dS0cB/xv+cq80KKwqaUMAGRY" +
           "M3rDAqCiD/NO+KObYbO/N25oA8CP4VVd3Su6ZTyAjeUQvDhEoaf/PxZNU0uM" +
           "HQgEwEmT/BShQHSt1BQJGzHxQGrpslsvxi5w+NGQsWxI0MOwcoivHGIrh+jK" +
           "IWflkG/l5nUm7iKDCjb7MCatIoUCCgTYJu6hu+IoAR9vAbYAuh49q2vDqk1D" +
           "TUUAT32gGBxERWdmpa82h1bsXBATT17qHLn4euWJIAoC88QhfTk5pNmTQ3gK" +
           "NDQRS0Bi+bKJzajh/Pkj5z7Q8OGBXd0772X7cKcFOmEJMBodHqVknlmi2U8H" +
           "ueat3nPts9OHdmgOMXjyjJ0es0ZSvmnyu9yvfEyc3Sicjb2yozmIioHEgLiJ" +
           "AIEGnDjFv4aHd1psDqe6lIPCCc1ICgrtsom3kvQBPpw3DIu17PkecHE1DcQm" +
           "iMibVmSyX9pbr9N2PMcuxYxPC5YjvtalH33zd9fnM3Pb6aTaVQd0YdLiojA6" +
           "WR0jq1oHgmsNjEHuz4ej+w/e3LOe4Q8kpudasJm2bUBd4EIw82Ovbn3r3XeO" +
           "vxF0MEsgh6fiUA6lM0qWU52qCihJce7sByhQwSxezOZ1KqBSTshCXME0SP5R" +
           "PWPe2Q/31nAcKPDGhtHcO0/gvP/SUvTohY0jU9g0AZGmYMdmjhjn9bHOzK2G" +
           "IQzSfaR3XZ78vfPCUcgQwMqmvA0zokXMBog57X6mf5i18319C2nTbLrB740v" +
           "V6kUE/e98fGY7o/P3WK79dZabl93CHoLhxdtZqRh+vF+olkpmH0gd//w6m/V" +
           "KMO3YcYemFEEajXXGMCBaQ8yLOmSsrd/+av6TZeKUHA5qlQ0QVousCBDFYBu" +
           "IDigz7S+5CHu3QHq7hqmKspSntpzam5PLUvqhNl220/Hv7T4uWPvMFBxFE3M" +
           "8GFjFh+yOt0J5Q+v/ODqL0Z+WMaz/Kz8/OUbN+Hva5T47vc/zzIyY64cFYhv" +
           "fE/45JGGtgdvsPEOhdDR09PZeQdI1hl734nkp8Gm0l8HUVkPqhGtmrhbUFI0" +
           "MHugDjTtQhnqZk+/t6bjBUxLhiIn+enLtayfvJx8B89Umj6P8fEVC+U5EMI3" +
           "rFC+4eerAGIPK9iQmaydRZu5FgK8U5UXmIqgSlokaSqG8wHFjdv19KjVlYqb" +
           "pFMYYAVkTHyy6bFdXy67tZB7vjGntKvWnD+ysLrxxPMqF2/OPbm3ynx/+4Wn" +
           "tT/dCNoVZK4hXPIRs+Piyys/iDFiLqf5eK1tUVembTV6XVmhJmOaKmqJOvi+" +
           "wE3Dfwna/N8tnVQZjlRyEk4B4bVyEkv0SAe2tgu1/+FqlKsmZkW249qzLz+7" +
           "aGjuN57mhp+WJ6gd+Z99/b1LR7edPsnTBDU/QXPyHUuzz8K0aphRoPJxQPTp" +
           "igeGr1/t3hC0iL2KNp0c5BMIqnLzL89VPRlODGRIrd6PJD556byjf9v5+Jtr" +
           "oCppR+UpVd6awu2SN1LLzFTcBS3nAOZEr4WrL+ATgO+/6Jfiib7guKprsw4j" +
           "jZnTiK6naT9BgdnwyIsQ2i6izUqu4AO5KJ93zaTN7AygWehX2gcP+9ddAbhZ" +
           "3jLegqySmxmyNyWHIOkwnIVWtdkM0cHSPGQwsOfkfCdMdjo+vvvAMWnNM/M4" +
           "mOq8p7Zlaip56g///G3o8Huv5TgGlFo3BM52i0wKSD90O9jp22H4RZdHiq48" +
           "NWF0dn1OZ5qSp/qenR+D/gXO7/5rw9oH+zbdReE91Wcl/5QvdJx8bcVM8akg" +
           "u0DgCSXr4sE7qMULzkoDk5SheuHY5C1+7wM0fGSh4qPcxW8OQGVKynxDfcVX" +
           "wAutBhaXwgAYtp9yED+eLaPPbM2BArXbdtrA0aBaYIOi2KBVP5bMgtVG1ADq" +
           "I3K/FdrhHXXvbjly7RTHoL+08AnjoQNPfBHae4Djkd8ATc+6hHGP4bdAPPpp" +
           "E0ubbtrMsQobsfyD0zt+/vyOPTabbSaouF+TJSfyzQKRn13s0RdL2GvV6/Qw" +
           "eOwTy3Of3L3T8w0t7PR6lmlC5gCkIBdxsPWeLODwfbTZQ9AYQZKcYfTlo45h" +
           "hv5jw9B8j6aCViOWdiMFDOOvq+DYVaEbGoEEjSVfjVVbYM4Cah8p0HeMNgeB" +
           "DlO6BNnCZ4tDd2+LNEFjc1yY2K67925vXwDuE7Iug/kFpvjisery8cfW/ZEd" +
           "9jOXjKOhTkukFMVdBbueS3UDJ2Sm/GheE/Os+BxBjXfaHBSyzh+m0rN88AmC" +
           "xuUcDHFHf9yypwiq8csSVMJ+3XJnYDVHDlzEH9wiPyaoCETo40u6hxLt6GiF" +
           "QtYAfuNeSAdc+c5K8MzR4+7k6MwQ93UC5UZ2n2/nnVTUKttOH1u1evuthc/w" +
           "6wxREbZto7OMgjKH36xkcte0vLPZc5WunHW76kzFDJvLavmGnRia6MLzEogg" +
           "nZ5NG3xnfbM5c+R/6/jic68PlV4GFl6PAgIAdn32ySutpyCxro/kKuggs7Nr" +
           "iJbKq5sufv52oI4dcBEvAacUGhET95+7Ek3o+veDqKIdlQBV4zQ7Fj48qHZi" +
           "sd/w1IelcS2lZq7+qyjCBXrXzyxjGXRM5i29DiOoKTufZF8RwtkfAmwpnd2q" +
           "Nz3ZPqXr7l5m2Q08/VBLA+pikQ5dt+vOG8zyus4Y4DxtNv4b7KwNwrQbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class PlayAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public PlayAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            svgCanvas.
              resumeProcessing(
                );
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        public void update(boolean enabled) {
            java.util.Iterator it =
              components.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                ((javax.swing.JComponent)
                   it.
                   next(
                     )).
                  setEnabled(
                    enabled);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Fxjh/BcC0ahy+hsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class PauseAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public PauseAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            svgCanvas.
              suspendProcessing(
                );
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        public void update(boolean enabled) {
            java.util.Iterator it =
              components.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                ((javax.swing.JComponent)
                   it.
                   next(
                     )).
                  setEnabled(
                    enabled);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "8i9wxvkvVDJCEfwbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class StopAction extends javax.swing.AbstractAction implements org.apache.batik.util.gui.resource.JComponentModifier {
        java.util.List components = new java.util.LinkedList(
          );
        public StopAction() { super(); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            svgCanvas.
              stopProcessing(
                );
        }
        public void addJComponent(javax.swing.JComponent c) {
            components.
              add(
                c);
            c.
              setEnabled(
                false);
        }
        public void update(boolean enabled) {
            java.util.Iterator it =
              components.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                ((javax.swing.JComponent)
                   it.
                   next(
                     )).
                  setEnabled(
                    enabled);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/POMcP4Lqvi+bfobAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMV6aezs2FWn3+vt9Uun3+tO0glN0ulOXmCSyvxdrs1lmiUu" +
           "u1xVtqvKtdllZ+DFW9ku73uVQ7MEzSSAFCLohCAl/QElYlFDRzDARDMZ9Wg0" +
           "ExBopIwQmwSJAIk1EvnAIsJ27frv770OLUCUVLeur++595x7zvndc++pF78M" +
           "PRBHUC3wnb3h+MmRvkuOtk77KNkHenxEs21OjmJdIxw5jpeg7bb6ts/c+Kuv" +
           "fsS8eRV6UIJeJ3uen8iJ5XvxXI99J9M1Frpx1tp3dDdOoJvsVs5kOE0sB2at" +
           "OHmWhV5zjjSBbrEnLMCABRiwAFcswPhZL0D0Wt1LXaKkkL0kDqHvgq6w0IOB" +
           "WrKXQM9cHCSQI9k9HoarJAAjXCufeSBURbyLoKdPZT/IfIfAH63Bz//od9z8" +
           "ufugGxJ0w/IWJTsqYCIBk0jQI67uKnoU45qmaxL0mKfr2kKPLNmxiopvCXo8" +
           "tgxPTtJIP12ksjEN9Kia82zlHlFL2aJUTfzoVLyNpTvaydMDG0c2gKxPnMl6" +
           "kJAq24GA1y3AWLSRVf2E5H7b8rQEeutlilMZbzGgAyB9yNUT0z+d6n5PBg3Q" +
           "4wfdObJnwIsksjwDdH3AT8EsCfTkPQct1zqQVVs29NsJ9KbL/bjDK9Dr4Woh" +
           "SpIEesPlbtVIQEtPXtLSOf18efLNH36/N/SuVjxruuqU/F8DRE9dIprrGz3S" +
           "PVU/ED7yLvZj8hOf+9BVCAKd33Cp86HPL33nV97z7qde/uVDn6+/S5+pstXV" +
           "5Lb6KeXRL7yZeCd2X8nGtcCPrVL5FySvzJ87fvPsLgCe98TpiOXLo5OXL8//" +
           "r/g9P63/2VXo+gh6UPWd1AV29Jjqu4Hl6NFA9/RITnRtBD2sexpRvR9BD4E6" +
           "a3n6oXW62cR6MoLud6qmB/3qGSzRBgxRLtFDoG55G/+kHsiJWdV3AQRBrwFf" +
           "CIOga2uo+lwTyjKBQtj0XR2WVdmzPB/mIr+Uv1Sop8lwosegroG3gQ8rwP7t" +
           "/4gcoXDspxEwSNiPDFgGVmHqh5fgIYjhODOUyM9jPYLpBT/gLT3XIwo4r35U" +
           "ml7w7zHprlyJm/mVK0BJb74MEQ7wrqHvaHp0W30+7fW/8rO3f/Xqqcscr2EC" +
           "PQtmPjrMfFTNfFTOfHQ289GlmW8tEj/A1dICoCtXqrlfXzJzMA6gWhuABIDP" +
           "R965+Hb6fR96233AKoP8fqCXsit8bxQnzmBlVIGnCmwbevnj+ffy312/Cl29" +
           "CMelAKDpeknOlSB6Cpa3Lrvh3ca98cE//quXPvacf+aQF/D9GCfupCz9/G2X" +
           "lzryVV0DyHk2/Lueln/h9ueeu3UVuh+ABwDMRAYGDrDoqctzXPD3Z0+ws5Tl" +
           "ASDwxo9c2SlfnQDe9cQEejlrqWzg0ar+GFjjG6UDfB3wBOnYI6rf8u3rgrJ8" +
           "/cFmSqVdkqLC5m9ZBJ/8rf/3J81quU9g/Ma5jXGhJ8+eg45ysBsVSDx2ZgPL" +
           "SNdBv9/9OPcjH/3yB99bGQDo8fa7TXirLAkAGUCFYJn/8y+Hv/3F3/vUr189" +
           "M5oE7J2p4ljq7lTIa6VMj76CkGC2bzjjB0CPo1cGG99aea6vWRtLVhy9tNK/" +
           "u/EO5Bf+/MM3D3bggJYTM3r31x7grP3retD3/Op3/PVT1TBX1HLrO1uzs24H" +
           "PH3d2ch4FMn7ko/d9/7/t/zY5+VPAmQGaBhbhV4BHFStAVQpDa7kf1dVHl16" +
           "h5TFW+Pzxn/Rv86FKLfVj/z6X7yW/4v/+ZWK24sxznldj+Xg2YN5lcXTOzD8" +
           "Gy97+lCOTdCv9fLkP910Xv4qGFECI6oA0uJpBLBnd8Eyjns/8NDv/K///cT7" +
           "vnAfdJWCrju+rFFy5WTQw8C69dgEsLULvu09B+3mpbpvVqJCdwh/MIo3VU/3" +
           "AwbfeW98ocoQ5cxF3/S3U0f5wO//zR2LUCHLXXbmS/QS/OInniS+9c8q+jMX" +
           "L6mf2t2JxyCcO6Nt/LT7l1ff9uD/uQo9JEE31eNYkZedtHQcCcRH8UkACeLJ" +
           "C+8vxjqHjf3ZUwh782V4OTftZXA52wdAvexd1q9fwpPK1WrgVzx2NfEynlyB" +
           "qsq3VSTPVOWtsvjGYw0dhvpH8LkCvv9Qfsv2suGwWT9OHEcMT5+GDAHYmK6X" +
           "gYTv6SCGBnp95h56nct5FWbdVj87+9IXPlm89OLBkxUZxBFQ7V4R+52HhhLY" +
           "3/EKm9NZLPeXg296+U/+gP/2q8e+95qLi/XIKy1W1fUNCfToeT86YA5zAOay" +
           "bJTFew6d2/d0g28qC2J3BSDkA40j9KhePk/vrob7yup/AFAaVwcDQLGxPNmp" +
           "+CcS4NaOeutEDTw4KAA/uLV10BN2b1bslhZ3dIiuL/FK/LN5Bap89Gww1geB" +
           "+g/+4Ud+7Yfe/kWgNxp6ICttHKji3IyTtDy7/JcXP/qW1zz/pR+sdgawLXAf" +
           "6998Tzmq9EoSl8WiLJYnoj5Zirqooi5WjpNxBea6Vkn7ivDBRZYL9rzsODCH" +
           "n3v8i/Yn/vhnDkH3Zay41Fn/0PM/8I9HH37+6rmjztvvOG2cpzkcdyqmX3u8" +
           "wued4C6zVBTUH7303H//yec+eODq8YuBex+cS3/mN/7+144+/qVfuUskeL/j" +
           "/wsUmzz6W8NWPMJPPmNe2qx7K2QuwClsT0c8Nspx3DT7xHBb6zDEaD+wrP6i" +
           "n+xnisgE9GjtoOukaeda1mymXa3QpJkz7Q9W2UCdmwPODpMuvqF4yyVQ1fTR" +
           "1XbZEdUOQtKzAOEDRPU3cjAIYGawC+Q6hmFoE4sQLN2lg4G8mRSTDlbDWm2s" +
           "NlWbsKupDWy6Xo2pwO/LWn/Amzgp+cK46DMKFg8IURgE896EU/F+d9sKJzCn" +
           "9CIY7zop3PDjns6Tuemae0tMqfXAcpcN33H3skn3KGXQHrpTWvZnE2VAb1cE" +
           "sQ8y2QoVVhomKi9Ic9rcSyaT4NsBQa3oec/aT/r9XG8KOL6ckNGQ702c0IgR" +
           "3ZDFGWOOkY2ob1d06tandGfeWG8LL3dnkmBGKmMAypkwcwcSPa7Ts0Z9MdFX" +
           "w02DmRuj1mJGK44gCCNNphxXEH190LZiLEV7NV8ayOIotMJ5YgjFoh3LsW84" +
           "NuPnntuZx9ROLbLOJPZZf2WnojiSZ7BszySjTtCcXGsKtsgJy1gKR0nDjKfd" +
           "mR7y+LojjkZuMK5ZREucJblMx4VAEuNVv5Fly57TENqwHOlIWuxEjp35OjxF" +
           "3X0Au74Y6DwxiJrrWXtk7YmcWGAihavbBksqtGiznGAx5kpt+vWJwJO2qGYK" +
           "IitqlPs2PifyYjXa0N48jklbE1p9TxSwwcxayLYW6NvRkKk5q9mqNa81BukE" +
           "LGstR5TOkJREJuaILW3gDXay6kYbOoznucOAJXa5Lb7H8dDmd0tcriPUsh0a" +
           "OLcihaFFMD6sUilOwzLZGVEDm5yJ1JYdLywkWXRGDTDPkKD81FHTgqr1eNwu" +
           "etTKlJlgvR3V++swQvSx53iNLOJrqBIqcrBJF+RklYj8dNuhW9TCW+kB0dVz" +
           "Y9GfpgNWypOe6euKs1pixIgs+FF356yzrYBtYgFpNbC9y7sSPQy2A5Qa+e6I" +
           "7rAO1dAbLGug231nK0y0sbsEp05djfcxK7gd2Sbt3dLehfPMKES2q3c2UbZr" +
           "SVwrNGt8Ek6IFT9eqGpv7shbSuO93s4JY9EeG8AvhjRv8UKyRTVn1oclIhaz" +
           "Tn28E4ux4AxrswDlGWvXbBDWAN/1lvyM2fDuRF5LG6pr4J29hpgT3K4xBNpf" +
           "BDWCHcAtF545IZnks36y9acEw1j70FiTpq00l7smM8V1pU5vjEhuUX6LhBUe" +
           "0/qOMZ+wQh8X8bFsS/AK763IAVnre6gvJbiKjrpywyRzsdnTtC4sD02bE+Ux" +
           "b5jqkOGWdbir2wshpJnVuDYszCAIVIsaWenEbszjXn9O7iUhQp3a1GP0vFUb" +
           "bAc8aQSB0TaIzVTtuWRCSHgXHeMqPN5qSL/eTijLIO0uOmgrnSnb0nEcabRI" +
           "2yAE1slmmeBpTjIYcH3C4YIZtwkHVreY7nk/I2lPZKyR5bGePFk3LQxjZpua" +
           "SOV+QCDeZDl3abGjT8Vi0qPYnGq0bd+cBOOhKi+4aJqQoi0PNU7JUnGa5FI+" +
           "7oh4fzbgV9wqb3NLbehLIhW3ECWGN0QxbmnDyUjl6gnDevNVMSG8yWRoYKiG" +
           "dOfUTmTb+0lGFotOf9POqSaO1Bd4DR+FEcdN7ZXYXC4lpI7WV3lL2rpmf01x" +
           "EdNOksXYIHKVbuUEJe9gt2m0DF/eoBo54iQZV91aR4tlT1GW08EskLZ7VGQ8" +
           "U8aanfpSg2GMWkhuC7WQRavudZu0XU/bIUPyy+k09EZGOh7ig+myplrzbmtC" +
           "INm6Pt7s8d0ES/tbZQ60LRJUi5GGTQepIVmWeZxFKjVSmDHBdDegGMuSGu5s" +
           "1+S5do9O7elwI+DdvSf2xExKpyQT9hbb2CH4cb++4Nr8WIDphgg3+fVIZTiy" +
           "byZDy81hg2MxbLKOWiDq3k238njZWUgIOpBGXSXYjPxCjSYmQWb+NGBQttvs" +
           "NK2MWK2M8Wwsu9wol7I97eLdhaqZG2XTJpBF0cycZOrW1wuSKxq1dY9fzCcF" +
           "vLP0pV602lq7kUyiZl/N0s4MI5Qpu/PH+y6d1+GibzcUEe/gTQrZdlBMCsVC" +
           "M3oUKq5m88FkHU9GZMd2vVHMzFgrQWttGQsTpxjP4LbAM4FvJLMwJnokLfZS" +
           "BW/h8l5B+I22Q/P2XEP0fSQz44KfoEWMpuGS33lLUiGjbgvduDxXRA3SGPNz" +
           "bDCmerAgwbjJdGvaikNb3UzP4AHb7dVX3XQBjwq+q2e6B6PUwtIxFObG3GjL" +
           "unuq19JhDTXChRYJtQ62z2YaEQ5ltT2VOjNphCQDrNtYdldNjGwJcDdkjDUv" +
           "BgKj5VsGt2WXRWZw4DQ2s8JRkwjFKGaK7JEJI4ZqR15lCDrXux67GHKLYDJF" +
           "OCzDeaLGU122OSdSAagR3Y80SdojSzduij1lLilE39iEnkX4MyMMFGEeuKMW" +
           "5ZBqSiHcEtlqFtjgU39m8lttsBur8jDxMEdmoz3qeR10wqT1aBzoHMvUAo4L" +
           "kX1XVWKjo66dGpxxQ0ytwRM+Q+otyeFM26iJw7mmy1ls5L7VdsFJjlQkai25" +
           "jYZuNiVxzTgDjwkBSLU24/Ekb8K0u40cJN6FS0YNprMWxcE9EtjoAp7ZPVRu" +
           "dFAObgn7VdiQ7DmrbBvROIPXJNWZMsOtx5FF154jI7RboGitGQvbvKFNu8t5" +
           "r1jBMxAoenU1346Zuty2kVltaRg1b5lwwniz1j2pzeqjTMob63lh13M71OBx" +
           "ViACxqzQerCykp0f25y3Ne2QgxucoE2K1GRcZ7ibOXwzQHGUpztBT5Ys2WCF" +
           "uNPetxydQLRNTnc5LquZw5bv1XxyG0YRNfW5VZC3zDTo2Gju7VlxlrJ12k9b" +
           "o4ay3pNYY7HdcO2Qc+tCYJCTWQSvOBcWm7UWk4+beycbCBK/lAuaxIiljS/E" +
           "jcmyRLoT5BEZKO5InPY4YeNMHWs/gwc0N9M54Mkcq1NGaLfgiEHmfZjyYHib" +
           "NXNhmnEaOJWEcJ31RZWWFQmhcT0cKvkMAFw8zVJyoWuwt+sIgoQtbS1ctIeY" +
           "Us8nuYz10f2+3aghg1pLawxHrLnR4m1b6M4KdKnqIZJsOGoHN+Omj3vOqEBN" +
           "b+EEHohDzFCk8RwZiq0JMKHME4kBZ8TARV22ud/ji0BYpfwM20lqNuRDhCU6" +
           "1GhJxqPpythsd8oMTuIi7NMg4NKS0WA7E9e4M2ZFn1rBTpzTYauR49p82O73" +
           "o2Q03iI6luowS0qFPchkgZrvLG7oFXWrS9SM3Z6Dp7SnxIpmIelwDaN5h9Em" +
           "9ABEEkuOZfv7LSaOi1GBwbq7yAoB+BKIx5HBkrbWu8KItxzLKb6BrONYilKM" +
           "6LXYAd1mPTZaxjVnGg2XMgICe8kk7RGt7sZDV2/khFmreQXfIWgjXbSZ7dzM" +
           "u6hpephq7MjFPqMbAVLvtBQ6kCJyzHrM0IBrBdiKFBhD6hsSm1gFQYVLH2lZ" +
           "UdZODT+0XIY3ZxnPzb12ulxyKU2sdphHykNjIC5TYy7tB9w2R7W0tZ+tbBXF" +
           "rFajP22gCGmo8WTZ3C4CZ2O0Qm+LrFbLImu0aGB3q2EYRqPxPmqLM2eozhUh" +
           "WncMZUrIBSdtdv0g9hrz7pIf1oqdOhC8HhYv9nq767pE4Eq8uSXcdQOVvF1v" +
           "1ZFWTjjqYWlN0E3MVqcbfIyiJrW2cJ+sz32svsK2wjARB/EAxNS4g+XsQgLR" +
           "Kx8heMZlCJ21J521lQUNgx9nNaZBbKe9QSOM8WKHyUmz6WA1nutq9nxlTilz" +
           "Gvt2SEet+aoeUipKTyUf492hYpiZU7TX47gxNSwLFgnVlljTyvB4GWGMqXRQ" +
           "uzPuJctJbmYeb7bRbD3P7QTveM0RvcPrwQIuRvRm1W8TXq3OSh177FMTK5mD" +
           "6MdZ1NecB8K4bnO6RyQVqTfs/rzPeWysblOv02+2V3W/xRics7OD+h7Faqbm" +
           "Urt634gmeboVbHoCz6amR9Cqz3V3Ii3vSNJvY9JSj8zhyqZdfex21cVuNcFd" +
           "4ENSg++1UWskDyM02ozjIG41+R6L13zLn7W1pJuJWcGxncJnYW46VrkWG2ZW" +
           "Tdn4CjjJfkt5xLVf3S3DY9WFymnucuug5Qv+VZyuD6+eKYt3nF4wVTdq10/y" +
           "XCe/5y++z25Dr5xc3rTvyPBUtwFGah1F+iH/dEQTJ5dtxxciUXnf8JZ7JTSr" +
           "u4ZPfeD5F7Tpp5GTe7BNAj14nGc+4+I+MMy77n2pMq6SuWcXo5//wJ8+ufxW" +
           "832vIt3z1ktMXh7yp8Yv/srgG9Qfvgrdd3pNekea+SLRsxcvR69HepJG3vLC" +
           "FelbLqZcGkAZ7z1WynvvnnK5qwFdqQzoYDaX7vevXFTjk9WNmJyDVQQBVXJ0" +
           "SMH1y3pF/n2vkB74YFl8VwLdkCsiTo/KxJJ+yKLL50xRT6D7M9/Szmz0u7/W" +
           "DdD5uaqG919cGRisyO3jlbn9b7IyT1S50KM4tzzjnCVXpM+/wqp8vCx+KIFe" +
           "K2vaGVnZ+P1n8n/kXyp/eXmuHcuv/evLf0l7Dym+7+iyV9H9+CsI/xNl8Ung" +
           "smmgyYl+SeoXXo3UuwS6fpYUPtFK/dUmlgFSvOmO/7kc/puh/uwLN6698YXV" +
           "b1b51NP/TzzMQtc2qeOcT2Scqz8YRPrGqqR9+JDWCKqfzyTQ01+LOSDS2UMl" +
           "0ksH4p9PoDfclRh4Tvlzvu8vJtDNy30T6IHq93y/z4LZzvoBnRwq57v8jwS6" +
           "D3Qpq58LLkDCieHjSpxEwL8PWthdOQfCx4ZZafbxr6XZU5LzGdsSuKu/Kp2A" +
           "bModp11eeoGevP8rnU8fMsaqIxdFOco1FnrokLw+Bepn7jnayVgPDt/51Uc/" +
           "8/A7TnaURw8MnznJOd7eevf0bN8NkiqhWvy3N/7Xb/6JF36vyhf8E8P9B59D" +
           "JgAA");
    }
    public class SetTransformAction extends javax.swing.AbstractAction {
        public SetTransformAction() { super(
                                        );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (transformDialog ==
                  null) {
                transformDialog =
                  org.apache.batik.ext.swing.JAffineTransformChooser.
                    createDialog(
                      JSVGViewerFrame.this,
                      resources.
                        getString(
                          "SetTransform.title"));
            }
            java.awt.geom.AffineTransform txf =
              transformDialog.
              showDialog(
                );
            if (txf !=
                  null) {
                java.awt.geom.AffineTransform at =
                  svgCanvas.
                  getRenderingTransform(
                    );
                if (at ==
                      null) {
                    at =
                      new java.awt.geom.AffineTransform(
                        );
                }
                txf.
                  concatenate(
                    at);
                svgCanvas.
                  setRenderingTransform(
                    txf);
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
           "xR/EfL8/5alBRZZgyxjSRGETyUXaZBoNtQzgtoS1VR/o6gx53BgW+/Kmuljz" +
           "er9UqI2aqL+qTwsLycVEgluoHXxuW0bVd/3BClsnUtAUZ4smHvZrqlAn+Q41" +
           "QFzX2dhwp0NLmyo3liiq4WzmZrqIRdzRrbC0GJbWFY/n/KHSWHaEQpXpevUm" +
           "Mwxp0WynFO7xKdct9NApFfMYK89a9oZX+3VtYuNBD5+KPtGaNMzArow0uUYq" +
           "Trhkq8Y8HGMoOCdX7E5IkJpU1Mb8BB0FPofw/IztR4Ni29TEiMStBSbh5bIk" +
           "TPlmNEqGbWwdN3o+2ZJ8dRq4RJljO+nCnZXwzVCrcJ0+ZrrwoFMVU4bzpmt9" +
           "0ZsSRteY90YYPp7F68lwwa9lFMURNOD5qWw2Wa9TNzCBWIv4aE4avDUeOBOq" +
           "34/mvN7kO4m9MPQAW02dDtH0xnBE0bitDt2h3VprvIF7caNWwCcTRJ8wwxWD" +
           "xJjKtGYja2pajVngVTdUf8FitSKNTcO5NavDSWVUVJhak1jLJU7oz9OkYg2K" +
           "odtNR7anwFIIW/GILs7bwWSjoHV4KDtdc8AX1mERQ0XFIfHIXNlLozqiSdJL" +
           "6whNm1J3OMWnZMnF+YoqjxiXt9Yu3hgXmE5izItisaVM+uygNEtbhQWnYWqp" +
           "UzQmFTXl52rc4iaeMejWmHLc6yIcis6USXtULQ0RnytvzDWldVW7ZeglDaN5" +
           "HXV9ol1ZVRtDlllVB8XG1MMJdrQpmgIXyZpeHces1VnM5JHgrk2h1YZXVVhZ" +
           "NQ2PIgSvtWlxm2p1PBy0jElhvNIGOFVZJbSAJx4a6ROKjWuKhQ6JlO7UbW1F" +
           "jFcUrXkwQrItWuqGhD5A+6Oi4CwWbT8MxwK/7LCuT9ZtvIBvCutytR1XNtay" +
           "IGD6LFhU+zOFMogiq1FqJyoPjaA3aphkazlaioqHzyy1xFAoyhBGm5bjccMc" +
           "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" +
           "fNScyvsSF0/3po83p3YdCyg7ST14q9cH+Snqk88+/4JCfaq0d9DpmYGD88Fb" +
           "nZ2c7Cj75K2Pi8P81cmu/fClZ//lAfbt+tOvoan68CklT4v83eGLX8HfIv/6" +
           "HnT2qBlxw0udk0zXTrYgLnpqEHoWe6IR8eDJxiYCttM92Fb35o3Nm4bAmTwE" +
           "to4/1UU7c7CBB92FB/KzvhiDXYxUK9jfNro72Thn91+hCRdnFyuALok5E616" +
           "WftW3b6zYo4FEw8OuJFtKLsos1/tbHui5xVAV25sxh9aUHytjX0QO/ff8J5x" +
           "+25M/uwLly688YXpX+d97KP3V3eQ0AUtNM3jDaRj4/OOp2pGviV3bNtJTv7z" +
           "SwH0yKspF0AXd39yk57dMr8vgO69KTPYy+znOO2vBNDl07QBdC7/PU73a2C1" +
           "HR1IrO3gOMmHA+gsIMmGzzkngiTZ92PDWuyDg1vgAY9vvZCcOZneRx6+8moe" +
           "PoYIj59I5fxV8WHahduXxdflz71AjN79cu1T2069bIppmkm5QEK3b18aHKXu" +
           "o7eUdijrfO+JH979+TvefIgxd28V3iXUMd0evnlbvLN2gryRnf7hG3//bb/9" +
           "wjfz3tj/Anah6XrDHwAA");
    }
    public class MonitorAction extends javax.swing.AbstractAction {
        public MonitorAction() { super();
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (memoryMonitorFrame ==
                  null) {
                memoryMonitorFrame =
                  new org.apache.batik.util.gui.MemoryMonitor(
                    );
                java.awt.Rectangle fr =
                  getBounds(
                    );
                java.awt.Dimension md =
                  memoryMonitorFrame.
                  getSize(
                    );
                memoryMonitorFrame.
                  setLocation(
                    fr.
                      x +
                      (fr.
                         width -
                         md.
                           width) /
                      2,
                    fr.
                      y +
                      (fr.
                         height -
                         md.
                           height) /
                      2);
            }
            memoryMonitorFrame.
              setVisible(
                true);
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
           "Lb/1wrfy1tj/Alb34bG9HwAA");
    }
    public class FindDialogAction extends javax.swing.AbstractAction {
        public FindDialogAction() { super(
                                      ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (findDialog ==
                  null) {
                findDialog =
                  new org.apache.batik.apps.svgbrowser.FindDialog(
                    JSVGViewerFrame.this,
                    svgCanvas);
                findDialog.
                  setGraphicsNode(
                    svgCanvas.
                      getGraphicsNode(
                        ));
                findDialog.
                  pack(
                    );
                java.awt.Rectangle fr =
                  getBounds(
                    );
                java.awt.Dimension td =
                  findDialog.
                  getSize(
                    );
                findDialog.
                  setLocation(
                    fr.
                      x +
                      (fr.
                         width -
                         td.
                           width) /
                      2,
                    fr.
                      y +
                      (fr.
                         height -
                         td.
                           height) /
                      2);
            }
            findDialog.
              setVisible(
                true);
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
           "38i7Y/8LTOf4DsMfAAA=");
    }
    public class ThumbnailDialogAction extends javax.swing.AbstractAction {
        public ThumbnailDialogAction() { super(
                                           );
        }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (thumbnailDialog ==
                  null) {
                thumbnailDialog =
                  new org.apache.batik.apps.svgbrowser.ThumbnailDialog(
                    JSVGViewerFrame.this,
                    svgCanvas);
                thumbnailDialog.
                  pack(
                    );
                java.awt.Rectangle fr =
                  getBounds(
                    );
                java.awt.Dimension td =
                  thumbnailDialog.
                  getSize(
                    );
                thumbnailDialog.
                  setLocation(
                    fr.
                      x +
                      (fr.
                         width -
                         td.
                           width) /
                      2,
                    fr.
                      y +
                      (fr.
                         height -
                         td.
                           height) /
                      2);
            }
            thumbnailDialog.
              setInteractionEnabled(
                !svgCanvas.
                  getDisableInteractions(
                    ));
            thumbnailDialog.
              setVisible(
                true);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "TxQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class FullScreenAction extends javax.swing.AbstractAction {
        public FullScreenAction() { super(
                                      ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (window ==
                  null ||
                  !window.
                  isVisible(
                    )) {
                if (window ==
                      null) {
                    window =
                      new javax.swing.JWindow(
                        JSVGViewerFrame.this);
                    java.awt.Dimension size =
                      java.awt.Toolkit.
                      getDefaultToolkit(
                        ).
                      getScreenSize(
                        );
                    window.
                      setSize(
                        size);
                }
                svgCanvas.
                  getParent(
                    ).
                  remove(
                    svgCanvas);
                window.
                  getContentPane(
                    ).
                  add(
                    svgCanvas);
                window.
                  setVisible(
                    true);
                window.
                  toFront(
                    );
                svgCanvas.
                  requestFocus(
                    );
            }
            else {
                svgCanvas.
                  getParent(
                    ).
                  remove(
                    svgCanvas);
                svgCanvasPanel.
                  add(
                    svgCanvas,
                    java.awt.BorderLayout.
                      CENTER);
                window.
                  setVisible(
                    false);
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
           "HF3wcbYalxfTWjTqMsPKdII3JG9IlpoGksQBayjJoOZQeEQIQWmlqsOaXa43" +
           "Hd1edLpEj7b96bhImPP+uFlawNLIXdINbi6zgiP4UhvDRKPWCAZFJZaaZb6J" +
           "pg0H686aQYB3aggWD52OxU0wgZxSRFeCh0sjrWsazamYZRpBRx+JZZ4SlkjZ" +
           "kSmEQEq8Py5JWD/2qIKymI37XAMXw82QWNIDwhxUSL4TcR5ntJCoNiIanepM" +
           "0RFJY4NWbNATYkogrRXbClSuTulGatGaQS0XjFVfF6l2HYu8yrpacdvTVm2u" +
           "ExOzz6Sp1a6ihZICJ1YPiUsG5waIPWsLK8mow/JkHOnA+fi+rhIuSVZ6cK8d" +
           "YpiWTJfNWRNedg1VkjszDZ6RUrHZWskVTWOmvtOHVR6uT8qdTqivWHVY7CRj" +
           "Up+XZSISLZQQWtUNutng2mo2KKhcE110CGvq0WnZbmDksDquDBnU0ApK4FFI" +
           "SOJLge1IQaGK2zDWgZMBcEdY5koNH7e9hK/W+IRvtlk7qQ+HlXJDVKsqqBo5" +
           "c12Q4gRhun3GJQVmWu6R7Tm10pUW0SvGMwkzHUemqzFqLKqLBVGpV7XEqXnt" +
           "Ya1GhVowcNBat1WSlWA9CEOtVqQ68XqCFegugytC0ki5bl9Nl321Fnsig06Q" +
           "tUXXiJRpCP6KTXohXmxOSKNhmJESFQLFQSsjLRmsG/2g4iKGMROLmrkeNBYz" +
           "IkZsgeitomIFLa5j4HVhxOK+uCDVHspzymhRmquLIW+UUVMLNHRYUZEkIUtE" +
           "m6JLawsJkx5sL3ykH3cGnfZ4MYPj0C2W6cVGDsuM2N70eHS98vEinIzjMklX" +
           "LEIq8oVo7Ggwn0wxiYeTWok1JmbFLqpJv1g1JoXA5QmiODeqdY531slErKeo" +
           "VKSG7YqVDtMNJ1e4EdYFBld7UyMprzCYnYbFUZ1Yl0Jyqvs+3GF0Q5F7KNXX" +
           "SCRRR4v2ejCqi4m/kNA1PCuB1DpoJzLXqK0HNlkJqyuRX2mp1rW7NSwZ+1KT" +
           "bTf9ZljfCH3apyvUIkXTWCfTGZ4Oeb1Mg/NqoIcVp4JN1VU1XLbtBcwwLbJv" +
           "U24sFLmoMRRwEaEbU9KQ0wmGEf1RAQ3E1boCS0SV6mi8GaZ0L0VxjFuWOq2F" +
           "gw14rqhj6zAh6m5QqHB1emo0mvI4Xm42NSJJGxiMaLBcShCdXvXLlUDhnHHg" +
           "j8pWRBJ6IrNpSkh1DXURuM4nmyrWiVHUm9WMcjnirMWkz2urTXvBoySMzRSN" +
           "JjR8UquupJpPczrK22WGsOehz+mr9TLuFaLUjGimjjhlmBqWiJrACUR3VMTr" +
           "CSr3NozSKJeE0WxaWszbnC+ZLSzpl7xQWfh0q16czLpkczrE2l0/9kyM1EDw" +
           "JCQljiwWJFNHWxTXxQoheYg8aisYNgtXhu3hBgfb4tiKqR7Xa1ArGdmUvBon" +
           "47VGizXGuDVGQjdAo7nFVJYJVwwFWVCSooGrUycY1pZTaoV1+ekicnzFKtU6" +
           "IqjIehWCMdZmKIUE25bG0WRSoqawTCndqq9J9XSQ0mbAcwTDzSNsDXxTaHHr" +
           "ZjBLi0QLCcdtB+ug1WSuqT1qDBMKl5K4ZxjRTMWUMlLVRkLBdbFObz0wOGxd" +
           "YJBqMyqxSkHgB3UYS9HY6FpNpjIOhFBhWYsJ7KKTtBvsmDcsZoGzfoMiBUoe" +
           "DAeOAPO22W06M5GtzPFKXVxitILjfnkZSNV5AdRJNtnRsPqqYdCKaohFf5HQ" +
           "ke1zPWFCekkzws1+i4uqdZcK+4rLFwuehkp4gJXGQYuboQ20sinwmuqEs07Q" +
           "CBGmGvnVFIutAQFzWEElJ5YxhGPggzW/uLQIcxkVo0QbjPsepQzX0oQpCoLT" +
           "bQ90VhkztSlaW456HkWBMj8r/9/+6k5gd+WHzaObBnDwyhaYV3Hy2C49kg1v" +
           "PGpQ5b2Ji6e708cbVLuuBZSdph642QVCfpL6+NPPPa/0PlHaO+j2TMHh+eBe" +
           "Z0cnO84+cfMjYye/PNm1IL709D/fP3yr8c5X0Vh96BSTp0n+bueFr9Bvkn99" +
           "Dzp71JC47lrnJNLVk22Ii4EaxYEzPNGMeOBkc7MM1PnFA7V+8cbNzRu6wJnc" +
           "BbaGP9VJO3OgwIMOw/35eV9cAS0mqhPtb5vdzWyeo4cv04hbZYMTQZfEHIlX" +
           "g6yFq25vrYRjzjQBh9zENZWdl7mvdL490feKoMun2/GH/BdfbWMfeM59190z" +
           "bu/G5E8/f+nC658f/VXeyT66v7qNgy5oYPvjLaRj8/NeoGpmrpDbtg0lL//5" +
           "pQh6+JWYi6CLuz+5SE9vkd8bQffcEBloMvs5DvsrQD2nYSPoXP57HO7XwG47" +
           "OBBW28lxkA9G0FkAkk2f9U64SLofrkxH38elMAqAvbdWSM+cDO4j+979SvY9" +
           "lg8eOxHI+VXxYdDF28via/Jnnm933/VS7RPbXr1siZtNRuUCB926vTY4CtxH" +
           "bkrtkNZ55vEf3vnZ2954mGHu3DK8C6djvD1048Z40/aivJW9+cPX//5bfvv5" +
           "b+bdsf8FM4oaysMfAAA=");
    }
    public class DOMViewerAction extends javax.swing.AbstractAction {
        public DOMViewerAction() { super(
                                     ); }
        public void actionPerformed(java.awt.event.ActionEvent e) {
            openDOMViewer(
              );
        }
        public void openDOMViewer() { if (domViewer ==
                                            null ||
                                            domViewer.
                                            isDisplayable(
                                              )) {
                                          domViewer =
                                            new org.apache.batik.apps.svgbrowser.DOMViewer(
                                              svgCanvas.new JSVGViewerDOMViewerController(
                                                ));
                                          java.awt.Rectangle fr =
                                            getBounds(
                                              );
                                          java.awt.Dimension td =
                                            domViewer.
                                            getSize(
                                              );
                                          domViewer.
                                            setLocation(
                                              fr.
                                                x +
                                                (fr.
                                                   width -
                                                   td.
                                                     width) /
                                                2,
                                              fr.
                                                y +
                                                (fr.
                                                   height -
                                                   td.
                                                     height) /
                                                2);
                                      }
                                      domViewer.
                                        setVisible(
                                          true);
        }
        public org.apache.batik.apps.svgbrowser.DOMViewer getDOMViewer() {
            return domViewer;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ZBYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected java.util.Map listeners = new java.util.HashMap(
      );
    public javax.swing.Action getAction(java.lang.String key)
          throws org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.Action result =
          (javax.swing.Action)
            listeners.
            get(
              key);
        if (result ==
              null) {
            throw new org.apache.batik.util.gui.resource.MissingListenerException(
              "Can\'t find action.",
              RESOURCES,
              key);
        }
        return result;
    }
    long time;
    public void documentLoadingStarted(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.documentLoad");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
            time =
              java.lang.System.
                currentTimeMillis(
                  );
        }
        statusBar.
          setMainMessage(
            msg);
        stopAction.
          update(
            true);
        svgCanvas.
          setCursor(
            WAIT_CURSOR);
    }
    public void documentLoadingCompleted(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
        if (debug) {
            java.lang.System.
              out.
              print(
                resources.
                  getString(
                    "Message.documentLoadTime"));
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
        }
        setSVGDocument(
          e.
            getSVGDocument(
              ),
          e.
            getSVGDocument(
              ).
            getURL(
              ),
          e.
            getSVGDocument(
              ).
            getTitle(
              ));
    }
    public void setSVGDocument(org.w3c.dom.svg.SVGDocument svgDocument,
                               java.lang.String svgDocumentURL,
                               java.lang.String svgDocumentTitle) {
        this.
          svgDocument =
          svgDocument;
        if (domViewer !=
              null) {
            if (domViewer.
                  isVisible(
                    ) &&
                  svgDocument !=
                  null) {
                domViewer.
                  setDocument(
                    svgDocument,
                    (org.w3c.dom.css.ViewCSS)
                      svgDocument.
                      getDocumentElement(
                        ));
            }
            else {
                domViewer.
                  dispose(
                    );
                domViewer =
                  null;
            }
        }
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        java.lang.String s =
          svgDocumentURL;
        locationBar.
          setText(
            s);
        if (debugger !=
              null) {
            debugger.
              detach(
                );
            debugger.
              setDocumentURL(
                s);
        }
        if (title ==
              null) {
            title =
              getTitle(
                );
        }
        java.lang.String dt =
          svgDocumentTitle;
        if (dt.
              length(
                ) !=
              0) {
            setTitle(
              title +
              ": " +
              dt);
        }
        else {
            int i =
              s.
              lastIndexOf(
                "/");
            if (i ==
                  -1)
                i =
                  s.
                    lastIndexOf(
                      "\\");
            if (i ==
                  -1) {
                setTitle(
                  title +
                  ": " +
                  s);
            }
            else {
                setTitle(
                  title +
                  ": " +
                  s.
                    substring(
                      i +
                        1));
            }
        }
        localHistory.
          update(
            s);
        application.
          addVisitedURI(
            s);
        backAction.
          update(
            );
        forwardAction.
          update(
            );
        transformHistory =
          new org.apache.batik.apps.svgbrowser.TransformHistory(
            );
        previousTransformAction.
          update(
            );
        nextTransformAction.
          update(
            );
        useStylesheetAction.
          update(
            );
    }
    public void documentLoadingCancelled(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.documentCancelled");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
    }
    public void documentLoadingFailed(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.documentFailed");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
    }
    public void gvtBuildStarted(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeBuild");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
            time =
              java.lang.System.
                currentTimeMillis(
                  );
        }
        statusBar.
          setMainMessage(
            msg);
        stopAction.
          update(
            true);
        svgCanvas.
          setCursor(
            WAIT_CURSOR);
    }
    public void gvtBuildCompleted(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
        if (debug) {
            java.lang.System.
              out.
              print(
                resources.
                  getString(
                    "Message.treeBuildTime"));
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
        }
        if (findDialog !=
              null) {
            if (findDialog.
                  isVisible(
                    )) {
                findDialog.
                  setGraphicsNode(
                    svgCanvas.
                      getGraphicsNode(
                        ));
            }
            else {
                findDialog.
                  dispose(
                    );
                findDialog =
                  null;
            }
        }
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        svgCanvas.
          setSelectionOverlayXORMode(
            application.
              isSelectionOverlayXORMode(
                ));
        svgCanvas.
          requestFocus(
            );
        if (debugger !=
              null) {
            debugger.
              attach(
                );
        }
    }
    public void gvtBuildCancelled(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeCancelled");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        svgCanvas.
          setSelectionOverlayXORMode(
            application.
              isSelectionOverlayXORMode(
                ));
    }
    public void gvtBuildFailed(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeFailed");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        stopAction.
          update(
            false);
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        svgCanvas.
          setSelectionOverlayXORMode(
            application.
              isSelectionOverlayXORMode(
                ));
        if (autoAdjust) {
            pack(
              );
        }
    }
    public void svgLoadEventDispatchStarted(org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.onload");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
            time =
              java.lang.System.
                currentTimeMillis(
                  );
        }
        stopAction.
          update(
            true);
        statusBar.
          setMainMessage(
            msg);
    }
    public void svgLoadEventDispatchCompleted(org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent e) {
        if (debug) {
            java.lang.System.
              out.
              print(
                resources.
                  getString(
                    "Message.onloadTime"));
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
        }
        stopAction.
          update(
            false);
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            resources.
              getString(
                "Message.done"));
    }
    public void svgLoadEventDispatchCancelled(org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.onloadCancelled");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        stopAction.
          update(
            false);
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
    }
    public void svgLoadEventDispatchFailed(org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.onloadFailed");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        stopAction.
          update(
            false);
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
    }
    public void gvtRenderingPrepare(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.treeRenderingPrep");
            java.lang.System.
              out.
              println(
                msg);
            time =
              java.lang.System.
                currentTimeMillis(
                  );
        }
        stopAction.
          update(
            true);
        svgCanvas.
          setCursor(
            WAIT_CURSOR);
        statusBar.
          setMainMessage(
            resources.
              getString(
                "Message.treeRendering"));
    }
    public void gvtRenderingStarted(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.treeRenderingPrepTime");
            java.lang.System.
              out.
              print(
                msg);
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
            time =
              java.lang.System.
                currentTimeMillis(
                  );
            msg =
              resources.
                getString(
                  "Message.treeRenderingStart");
            java.lang.System.
              out.
              println(
                msg);
        }
    }
    public void gvtRenderingCompleted(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.treeRenderingTime");
            java.lang.System.
              out.
              print(
                msg);
            java.lang.System.
              out.
              println(
                (java.lang.System.
                   currentTimeMillis(
                     ) -
                   time) +
                " ms");
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            resources.
              getString(
                "Message.done"));
        if (!svgCanvas.
              isDynamic(
                ) ||
              managerStopped) {
            stopAction.
              update(
                false);
        }
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
        transformHistory.
          update(
            svgCanvas.
              getRenderingTransform(
                ));
        previousTransformAction.
          update(
            );
        nextTransformAction.
          update(
            );
    }
    public void gvtRenderingCancelled(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeRenderingCancelled");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        if (!svgCanvas.
              isDynamic(
                )) {
            stopAction.
              update(
                false);
        }
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
    }
    public void gvtRenderingFailed(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
        java.lang.String msg =
          resources.
          getString(
            "Message.treeRenderingFailed");
        if (debug) {
            java.lang.System.
              out.
              println(
                msg);
        }
        statusBar.
          setMainMessage(
            "");
        statusBar.
          setMessage(
            msg);
        if (!svgCanvas.
              isDynamic(
                )) {
            stopAction.
              update(
                false);
        }
        svgCanvas.
          setCursor(
            DEFAULT_CURSOR);
    }
    public void linkActivated(org.apache.batik.swing.svg.LinkActivationEvent e) {
        java.lang.String s =
          e.
          getReferencedURI(
            );
        if (svgDocument !=
              null) {
            org.apache.batik.util.ParsedURL docURL =
              new org.apache.batik.util.ParsedURL(
              svgDocument.
                getURL(
                  ));
            org.apache.batik.util.ParsedURL url =
              new org.apache.batik.util.ParsedURL(
              docURL,
              s);
            if (!url.
                  sameFile(
                    docURL)) {
                return;
            }
            if (s.
                  indexOf(
                    '#') !=
                  -1) {
                localHistory.
                  update(
                    s);
                locationBar.
                  setText(
                    s);
                if (debugger !=
                      null) {
                    debugger.
                      detach(
                        );
                    debugger.
                      setDocumentURL(
                        s);
                }
                application.
                  addVisitedURI(
                    s);
                backAction.
                  update(
                    );
                forwardAction.
                  update(
                    );
                transformHistory =
                  new org.apache.batik.apps.svgbrowser.TransformHistory(
                    );
                previousTransformAction.
                  update(
                    );
                nextTransformAction.
                  update(
                    );
            }
        }
    }
    public void managerStarted(org.apache.batik.bridge.UpdateManagerEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.updateManagerStarted");
            java.lang.System.
              out.
              println(
                msg);
        }
        managerStopped =
          false;
        playAction.
          update(
            false);
        pauseAction.
          update(
            true);
        stopAction.
          update(
            true);
    }
    public void managerSuspended(org.apache.batik.bridge.UpdateManagerEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.updateManagerSuspended");
            java.lang.System.
              out.
              println(
                msg);
        }
        playAction.
          update(
            true);
        pauseAction.
          update(
            false);
    }
    public void managerResumed(org.apache.batik.bridge.UpdateManagerEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.updateManagerResumed");
            java.lang.System.
              out.
              println(
                msg);
        }
        playAction.
          update(
            false);
        pauseAction.
          update(
            true);
    }
    public void managerStopped(org.apache.batik.bridge.UpdateManagerEvent e) {
        if (debug) {
            java.lang.String msg =
              resources.
              getString(
                "Message.updateManagerStopped");
            java.lang.System.
              out.
              println(
                msg);
        }
        managerStopped =
          true;
        playAction.
          update(
            false);
        pauseAction.
          update(
            false);
        stopAction.
          update(
            false);
    }
    public void updateStarted(final org.apache.batik.bridge.UpdateManagerEvent e) {
        
    }
    public void updateCompleted(final org.apache.batik.bridge.UpdateManagerEvent e) {
        
    }
    public void updateFailed(org.apache.batik.bridge.UpdateManagerEvent e) {
        
    }
    protected class UserAgent implements org.apache.batik.swing.svg.SVGUserAgent {
        protected UserAgent() { super(); }
        public void displayError(java.lang.String message) {
            if (debug) {
                java.lang.System.
                  err.
                  println(
                    message);
            }
            javax.swing.JOptionPane pane =
              new javax.swing.JOptionPane(
              message,
              javax.swing.JOptionPane.
                ERROR_MESSAGE);
            javax.swing.JDialog dialog =
              pane.
              createDialog(
                JSVGViewerFrame.this,
                "ERROR");
            dialog.
              setModal(
                false);
            dialog.
              setVisible(
                true);
        }
        public void displayError(java.lang.Exception ex) {
            if (debug) {
                ex.
                  printStackTrace(
                    );
            }
            org.apache.batik.util.gui.JErrorPane pane =
              new org.apache.batik.util.gui.JErrorPane(
              ex,
              javax.swing.JOptionPane.
                ERROR_MESSAGE);
            javax.swing.JDialog dialog =
              pane.
              createDialog(
                JSVGViewerFrame.this,
                "ERROR");
            dialog.
              setModal(
                false);
            dialog.
              setVisible(
                true);
        }
        public void displayMessage(java.lang.String message) {
            statusBar.
              setMessage(
                message);
        }
        public void showAlert(java.lang.String message) {
            svgCanvas.
              showAlert(
                message);
        }
        public java.lang.String showPrompt(java.lang.String message) {
            return svgCanvas.
              showPrompt(
                message);
        }
        public java.lang.String showPrompt(java.lang.String message,
                                           java.lang.String defaultValue) {
            return svgCanvas.
              showPrompt(
                message,
                defaultValue);
        }
        public boolean showConfirm(java.lang.String message) {
            return svgCanvas.
              showConfirm(
                message);
        }
        public float getPixelUnitToMillimeter() {
            return 0.26458332F;
        }
        public float getPixelToMM() { return getPixelUnitToMillimeter(
                                               );
        }
        public java.lang.String getDefaultFontFamily() {
            return application.
              getDefaultFontFamily(
                );
        }
        public float getMediumFontSize() {
            return 9.0F *
              25.4F /
              (72.0F *
                 getPixelUnitToMillimeter(
                   ));
        }
        public float getLighterFontWeight(float f) {
            int weight =
              (int)
                ((f +
                    50) /
                   100) *
              100;
            switch (weight) {
                case 100:
                    return 100;
                case 200:
                    return 100;
                case 300:
                    return 200;
                case 400:
                    return 300;
                case 500:
                    return 400;
                case 600:
                    return 400;
                case 700:
                    return 400;
                case 800:
                    return 400;
                case 900:
                    return 400;
                default:
                    throw new java.lang.IllegalArgumentException(
                      "Bad Font Weight: " +
                      f);
            }
        }
        public float getBolderFontWeight(float f) {
            int weight =
              (int)
                ((f +
                    50) /
                   100) *
              100;
            switch (weight) {
                case 100:
                    return 600;
                case 200:
                    return 600;
                case 300:
                    return 600;
                case 400:
                    return 600;
                case 500:
                    return 600;
                case 600:
                    return 700;
                case 700:
                    return 800;
                case 800:
                    return 900;
                case 900:
                    return 900;
                default:
                    throw new java.lang.IllegalArgumentException(
                      "Bad Font Weight: " +
                      f);
            }
        }
        public java.lang.String getLanguages() {
            return application.
              getLanguages(
                );
        }
        public java.lang.String getUserStyleSheetURI() {
            return application.
              getUserStyleSheetURI(
                );
        }
        public java.lang.String getXMLParserClassName() {
            return application.
              getXMLParserClassName(
                );
        }
        public boolean isXMLParserValidating() {
            return application.
              isXMLParserValidating(
                );
        }
        public java.lang.String getMedia() {
            return application.
              getMedia(
                );
        }
        public java.lang.String getAlternateStyleSheet() {
            return alternateStyleSheet;
        }
        public void openLink(java.lang.String uri,
                             boolean newc) {
            if (newc) {
                application.
                  openLink(
                    uri);
            }
            else {
                showSVGDocument(
                  uri);
            }
        }
        public boolean supportExtension(java.lang.String s) {
            return false;
        }
        public void handleElement(org.w3c.dom.Element elt,
                                  java.lang.Object data) {
            
        }
        public org.apache.batik.bridge.ScriptSecurity getScriptSecurity(java.lang.String scriptType,
                                                                        org.apache.batik.util.ParsedURL scriptURL,
                                                                        org.apache.batik.util.ParsedURL docURL) {
            if (!application.
                  canLoadScriptType(
                    scriptType)) {
                return new org.apache.batik.bridge.NoLoadScriptSecurity(
                  scriptType);
            }
            else {
                switch (application.
                          getAllowedScriptOrigin(
                            )) {
                    case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                           ANY:
                        return new org.apache.batik.bridge.RelaxedScriptSecurity(
                          scriptType,
                          scriptURL,
                          docURL);
                    case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                           DOCUMENT:
                        return new org.apache.batik.bridge.DefaultScriptSecurity(
                          scriptType,
                          scriptURL,
                          docURL);
                    case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                           EMBEDED:
                        return new org.apache.batik.bridge.EmbededScriptSecurity(
                          scriptType,
                          scriptURL,
                          docURL);
                    default:
                        return new org.apache.batik.bridge.NoLoadScriptSecurity(
                          scriptType);
                }
            }
        }
        public void checkLoadScript(java.lang.String scriptType,
                                    org.apache.batik.util.ParsedURL scriptURL,
                                    org.apache.batik.util.ParsedURL docURL)
              throws java.lang.SecurityException {
            org.apache.batik.bridge.ScriptSecurity s =
              getScriptSecurity(
                scriptType,
                scriptURL,
                docURL);
            if (s !=
                  null) {
                s.
                  checkLoadScript(
                    );
            }
        }
        public org.apache.batik.bridge.ExternalResourceSecurity getExternalResourceSecurity(org.apache.batik.util.ParsedURL resourceURL,
                                                                                            org.apache.batik.util.ParsedURL docURL) {
            switch (application.
                      getAllowedExternalResourceOrigin(
                        )) {
                case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                       ANY:
                    return new org.apache.batik.bridge.RelaxedExternalResourceSecurity(
                      resourceURL,
                      docURL);
                case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                       DOCUMENT:
                    return new org.apache.batik.bridge.DefaultExternalResourceSecurity(
                      resourceURL,
                      docURL);
                case org.apache.batik.apps.svgbrowser.ResourceOrigin.
                       EMBEDED:
                    return new org.apache.batik.bridge.EmbededExternalResourceSecurity(
                      resourceURL);
                default:
                    return new org.apache.batik.bridge.NoLoadExternalResourceSecurity(
                      );
            }
        }
        public void checkLoadExternalResource(org.apache.batik.util.ParsedURL resourceURL,
                                              org.apache.batik.util.ParsedURL docURL)
              throws java.lang.SecurityException {
            org.apache.batik.bridge.ExternalResourceSecurity s =
              getExternalResourceSecurity(
                resourceURL,
                docURL);
            if (s !=
                  null) {
                s.
                  checkLoadExternalResource(
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
          ("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" +
           "E7489T91iYh0di8AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "TX7lJJz/5BQ435hmPgHw3bnFeefrJMov");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("ngDxt9Pkt4LcnSnElm1JqmfeyA/ftrBtQ+StHfR/dgro92/t9M4rW+hXzgb6" +
           "UWRfOaHsq2ny+0HuQVkMxmokGrSlBlN7oBqGaoqBeMOp6Lxk2HywY8AfnJYB" +
           "jwPgD28Z8PDZM+A/nFD2n9Lk34P55oABAPwgzfvaDt8fndaGnwa4ntzie/Ls" +
           "8X3rhLJvp8k3g9wbAL62KPGhEaA2WGDwpmrEx2z4T04rx7cBfE9vcT599jj/" +
           "1wll30uT/w5CdoBzIApqaKYwKTURjwnzL04L8ikArrQFWTobkEcc1ddSgr3z" +
           "N0e6d1ua5DYSJVRZAUaaQp2J6fO1YPf2Tgv2rwCQ2BYs9jqBvfcEsPelyV0g" +
           "lgRgm9mHlTfFevdprTSdgd6zxfqeM9fevbecUPZomjy48UIECJhDEA3611rn" +
           "3pvOwguJW3zi2eN76oSyfJpc3ehsulKlgtgQKUUEbyR+DOdbT4szD/AZW5zG" +
           "2eOsnFCW7g/sFYLc/QDnfEBkVwa8bPU93C5LjwAtnjZkegcAGGyBBmcPFDmh" +
           "rJUm7wRAVf8QJ8MbqgBW/ZvPh17dAX3XaSX6CAD4/i3Q95890MEJZaM06Qa5" +
           "27fzCn9MiPhpsaVCfH6L7fmzx8aeUPZjaTINcg8AbIgB5hGLD8SdaR5DSp92" +
           "OVoFCD+yRfqRs0F6fCXzaoZLPAFzqpt77wPytB3RSj+mTYl2S9I9/rRG+XaA" +
           "7hNblJ84G5TH1zF77gkA08w9IwDdhI5je0EnCkTL3343fsQozdOK8xkA8JNb" +
           "oJ88U3Fm7+kGUrrluYaX+4Jt7qcXxsTt3a5rv0XdfI2bgX/uBMb8zTSJgtzd" +
           "Cm8Jhrht75j441Nw5ZE0EwLc+MyWK585G67cstujxg/gP3rdbvDmmlB2R40m" +
           "iRTLCxnsv3MCS/5umnx4EzRTS091Akpchp4axAf9vO26fhaeKsji/g3IMwb+" +
           "xGnVqgIY94dbBn7t7BmYMWbHnU/d2NQO4D985IvnLdRrtjL3fjZNXgpylwCD" +
           "ljph88KGMcfU6qdPwZW7DrzKn2258mdnamzHGHLCbtdeutu19/OAK0BdUrcC" +
           "5gsjvaKYfkV9XHEKN1OcEytmzDrNllmmQjXAtMubunfd83oy69dv6qj3/kFG" +
           "8Btp8qtB7k2H6nEc/jFF+cIPgh04szsOz31uzvjXuFvme7kHr7vqurmeufyl" +
           "ly/d/saX6X+T3ak6vEJ5B5G7XQoN4+hNhiPPFxxPlNSMjXds7jU4GTP+RZB7" +
           "7LUGl24xHr5kU9kXN5VfBbHmDSsHuVvTn6O0/wpMD8dpg9z57Pco3e+D3nZ0" +
           "Qe7C5uEoyb8OcrcAkvTxy6kC7X0g2jiHB4/qX7axcOW1RHdY5ei9rPRkLbuP" +
           "fHAKFm5uJD+7/PzLveH7v1P9uc29sKXBJ0nayu1E7rbNFbWs0fQk7fGbtnbQ" +
           "1oXuU9+755fveOvBkd89mwHvbOHI2B698Q2sjukE2Z2p5J++8Vff+Qsv/3F2" +
           "BeP/AfY5qS4oPgAA");
    }
    protected static class ImageFileFilter extends javax.swing.filechooser.FileFilter {
        protected java.lang.String extension;
        public ImageFileFilter(java.lang.String extension) {
            super(
              );
            this.
              extension =
              extension;
        }
        public boolean accept(java.io.File f) {
            boolean accept =
              false;
            java.lang.String fileName =
              null;
            if (f !=
                  null) {
                if (f.
                      isDirectory(
                        )) {
                    accept =
                      true;
                }
                else {
                    fileName =
                      f.
                        getPath(
                          ).
                        toLowerCase(
                          );
                    if (fileName.
                          endsWith(
                            extension)) {
                        accept =
                          true;
                    }
                }
            }
            return accept;
        }
        public java.lang.String getDescription() {
            return extension;
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
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Fa0Xdv5H3KVqs21ql9N95EG1xVFzwVfd");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "y/8Bd7ayNzWIAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ws3mBNVApgHXGlGSJIygLjXoW1GKwJNa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "LhGi0VaVap1wfaVpIibjN+rrumkInjrx");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "vtKX/dhL//Xbv+v9H9sclPn/AbVFUQNSnQAA");
}
