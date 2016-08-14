package org.apache.batik.transcoder.print;
public class PrintTranscoder extends org.apache.batik.transcoder.SVGAbstractTranscoder implements java.awt.print.Printable, ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
                                          LOW_MODE; }
    public static final java.lang.String KEY_AOI_STR = "aoi";
    public static final java.lang.String KEY_HEIGHT_STR = "height";
    public static final java.lang.String KEY_LANGUAGE_STR = "language";
    public static final java.lang.String KEY_MARGIN_BOTTOM_STR = "marginBottom";
    public static final java.lang.String KEY_MARGIN_LEFT_STR = "marginLeft";
    public static final java.lang.String KEY_MARGIN_RIGHT_STR = "marginRight";
    public static final java.lang.String KEY_MARGIN_TOP_STR = "marginTop";
    public static final java.lang.String KEY_PAGE_HEIGHT_STR = "pageHeight";
    public static final java.lang.String KEY_PAGE_ORIENTATION_STR =
      "pageOrientation";
    public static final java.lang.String KEY_PAGE_WIDTH_STR = "pageWidth";
    public static final java.lang.String KEY_PIXEL_TO_MM_STR = "pixelToMm";
    public static final java.lang.String KEY_SCALE_TO_PAGE_STR = "scaleToPage";
    public static final java.lang.String KEY_SHOW_PAGE_DIALOG_STR =
      "showPageDialog";
    public static final java.lang.String KEY_SHOW_PRINTER_DIALOG_STR =
      "showPrinterDialog";
    public static final java.lang.String KEY_USER_STYLESHEET_URI_STR =
      "userStylesheet";
    public static final java.lang.String KEY_WIDTH_STR = "width";
    public static final java.lang.String KEY_XML_PARSER_CLASSNAME_STR =
      "xmlParserClassName";
    public static final java.lang.String VALUE_MEDIA_PRINT = "print";
    public static final java.lang.String VALUE_PAGE_ORIENTATION_LANDSCAPE =
      "landscape";
    public static final java.lang.String VALUE_PAGE_ORIENTATION_PORTRAIT =
      "portrait";
    public static final java.lang.String VALUE_PAGE_ORIENTATION_REVERSE_LANDSCAPE =
      "reverseLandscape";
    private java.util.List inputs = new java.util.ArrayList(
      );
    private java.util.List printedInputs = null;
    private int curIndex = -1;
    private org.apache.batik.bridge.BridgeContext theCtx;
    public PrintTranscoder() { super();
                               hints.put(KEY_MEDIA, VALUE_MEDIA_PRINT);
    }
    public void transcode(org.apache.batik.transcoder.TranscoderInput in,
                          org.apache.batik.transcoder.TranscoderOutput out) {
        if (in !=
              null) {
            inputs.
              add(
                in);
        }
    }
    protected void transcode(org.w3c.dom.Document document,
                             java.lang.String uri,
                             org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        super.
          transcode(
            document,
            uri,
            output);
        theCtx =
          ctx;
        ctx =
          null;
    }
    public void print() throws java.awt.print.PrinterException {
        java.awt.print.PrinterJob printerJob =
          java.awt.print.PrinterJob.
          getPrinterJob(
            );
        java.awt.print.PageFormat pageFormat =
          printerJob.
          defaultPage(
            );
        java.awt.print.Paper paper =
          pageFormat.
          getPaper(
            );
        java.lang.Float pageWidth =
          (java.lang.Float)
            hints.
            get(
              KEY_PAGE_WIDTH);
        java.lang.Float pageHeight =
          (java.lang.Float)
            hints.
            get(
              KEY_PAGE_HEIGHT);
        if (pageWidth !=
              null) {
            paper.
              setSize(
                pageWidth.
                  floatValue(
                    ),
                paper.
                  getHeight(
                    ));
        }
        if (pageHeight !=
              null) {
            paper.
              setSize(
                paper.
                  getWidth(
                    ),
                pageHeight.
                  floatValue(
                    ));
        }
        float x =
          0;
        float y =
          0;
        float width =
          (float)
            paper.
            getWidth(
              );
        float height =
          (float)
            paper.
            getHeight(
              );
        java.lang.Float leftMargin =
          (java.lang.Float)
            hints.
            get(
              KEY_MARGIN_LEFT);
        java.lang.Float topMargin =
          (java.lang.Float)
            hints.
            get(
              KEY_MARGIN_TOP);
        java.lang.Float rightMargin =
          (java.lang.Float)
            hints.
            get(
              KEY_MARGIN_RIGHT);
        java.lang.Float bottomMargin =
          (java.lang.Float)
            hints.
            get(
              KEY_MARGIN_BOTTOM);
        if (leftMargin !=
              null) {
            x =
              leftMargin.
                floatValue(
                  );
            width -=
              leftMargin.
                floatValue(
                  );
        }
        if (topMargin !=
              null) {
            y =
              topMargin.
                floatValue(
                  );
            height -=
              topMargin.
                floatValue(
                  );
        }
        if (rightMargin !=
              null) {
            width -=
              rightMargin.
                floatValue(
                  );
        }
        if (bottomMargin !=
              null) {
            height -=
              bottomMargin.
                floatValue(
                  );
        }
        paper.
          setImageableArea(
            x,
            y,
            width,
            height);
        java.lang.String pageOrientation =
          (java.lang.String)
            hints.
            get(
              KEY_PAGE_ORIENTATION);
        if (VALUE_PAGE_ORIENTATION_PORTRAIT.
              equalsIgnoreCase(
                pageOrientation)) {
            pageFormat.
              setOrientation(
                java.awt.print.PageFormat.
                  PORTRAIT);
        }
        else
            if (VALUE_PAGE_ORIENTATION_LANDSCAPE.
                  equalsIgnoreCase(
                    pageOrientation)) {
                pageFormat.
                  setOrientation(
                    java.awt.print.PageFormat.
                      LANDSCAPE);
            }
            else
                if (VALUE_PAGE_ORIENTATION_REVERSE_LANDSCAPE.
                      equalsIgnoreCase(
                        pageOrientation)) {
                    pageFormat.
                      setOrientation(
                        java.awt.print.PageFormat.
                          REVERSE_LANDSCAPE);
                }
        pageFormat.
          setPaper(
            paper);
        pageFormat =
          printerJob.
            validatePage(
              pageFormat);
        java.lang.Boolean showPageFormat =
          (java.lang.Boolean)
            hints.
            get(
              KEY_SHOW_PAGE_DIALOG);
        if (showPageFormat !=
              null &&
              showPageFormat.
              booleanValue(
                )) {
            java.awt.print.PageFormat tmpPageFormat =
              printerJob.
              pageDialog(
                pageFormat);
            if (tmpPageFormat ==
                  pageFormat) {
                return;
            }
            pageFormat =
              tmpPageFormat;
        }
        printerJob.
          setPrintable(
            this,
            pageFormat);
        java.lang.Boolean showPrinterDialog;
        showPrinterDialog =
          (java.lang.Boolean)
            hints.
            get(
              KEY_SHOW_PRINTER_DIALOG);
        if (showPrinterDialog !=
              null &&
              showPrinterDialog.
              booleanValue(
                )) {
            if (!printerJob.
                  printDialog(
                    )) {
                return;
            }
        }
        printerJob.
          print(
            );
    }
    public int print(java.awt.Graphics _g, java.awt.print.PageFormat pageFormat,
                     int pageIndex) { if (printedInputs ==
                                            null) {
                                          printedInputs =
                                            new java.util.ArrayList(
                                              inputs);
                                      }
                                      if (pageIndex >=
                                            printedInputs.
                                            size(
                                              )) {
                                          curIndex =
                                            -1;
                                          if (theCtx !=
                                                null)
                                              theCtx.
                                                dispose(
                                                  );
                                          userAgent.
                                            displayMessage(
                                              "Done");
                                          return NO_SUCH_PAGE;
                                      }
                                      if (curIndex !=
                                            pageIndex) {
                                          if (theCtx !=
                                                null)
                                              theCtx.
                                                dispose(
                                                  );
                                          try {
                                              width =
                                                (int)
                                                  pageFormat.
                                                  getImageableWidth(
                                                    );
                                              height =
                                                (int)
                                                  pageFormat.
                                                  getImageableHeight(
                                                    );
                                              super.
                                                transcode(
                                                  (org.apache.batik.transcoder.TranscoderInput)
                                                    printedInputs.
                                                    get(
                                                      pageIndex),
                                                  null);
                                              curIndex =
                                                pageIndex;
                                          }
                                          catch (org.apache.batik.transcoder.TranscoderException e) {
                                              drawError(
                                                _g,
                                                e);
                                              return PAGE_EXISTS;
                                          }
                                      }
                                      java.awt.Graphics2D g =
                                        (java.awt.Graphics2D)
                                          _g;
                                      g.setRenderingHint(
                                          java.awt.RenderingHints.
                                            KEY_ANTIALIASING,
                                          java.awt.RenderingHints.
                                            VALUE_ANTIALIAS_ON);
                                      g.setRenderingHint(
                                          java.awt.RenderingHints.
                                            KEY_INTERPOLATION,
                                          java.awt.RenderingHints.
                                            VALUE_INTERPOLATION_BILINEAR);
                                      g.setRenderingHint(
                                          org.apache.batik.ext.awt.RenderingHintsKeyExt.
                                            KEY_TRANSCODING,
                                          org.apache.batik.ext.awt.RenderingHintsKeyExt.
                                            VALUE_TRANSCODING_PRINTING);
                                      java.awt.geom.AffineTransform t =
                                        g.
                                        getTransform(
                                          );
                                      java.awt.Shape clip =
                                        g.
                                        getClip(
                                          );
                                      g.translate(
                                          pageFormat.
                                            getImageableX(
                                              ),
                                          pageFormat.
                                            getImageableY(
                                              ));
                                      g.transform(
                                          curTxf);
                                      try {
                                          root.
                                            paint(
                                              g);
                                      }
                                      catch (java.lang.Exception e) {
                                          g.
                                            setTransform(
                                              t);
                                          g.
                                            setClip(
                                              clip);
                                          drawError(
                                            _g,
                                            e);
                                      }
                                      g.setTransform(
                                          t);
                                      g.setClip(
                                          clip);
                                      return PAGE_EXISTS;
    }
    protected void setImageSize(float docWidth,
                                float docHeight) {
        java.lang.Boolean scaleToPage =
          (java.lang.Boolean)
            hints.
            get(
              KEY_SCALE_TO_PAGE);
        if (scaleToPage !=
              null &&
              !scaleToPage.
              booleanValue(
                )) {
            float w =
              docWidth;
            float h =
              docHeight;
            if (hints.
                  containsKey(
                    KEY_AOI)) {
                java.awt.geom.Rectangle2D aoi =
                  (java.awt.geom.Rectangle2D)
                    hints.
                    get(
                      KEY_AOI);
                w =
                  (float)
                    aoi.
                    getWidth(
                      );
                h =
                  (float)
                    aoi.
                    getHeight(
                      );
            }
            super.
              setImageSize(
                w,
                h);
        }
    }
    private void drawError(java.awt.Graphics g,
                           java.lang.Exception e) {
        userAgent.
          displayError(
            e);
    }
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_SHOW_PAGE_DIALOG =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_SHOW_PRINTER_DIALOG =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_PAGE_WIDTH =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_PAGE_HEIGHT =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_MARGIN_TOP =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_MARGIN_RIGHT =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_MARGIN_BOTTOM =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_MARGIN_LEFT =
      new org.apache.batik.transcoder.keys.LengthKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_PAGE_ORIENTATION =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_SCALE_TO_PAGE =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final java.lang.String USAGE =
      ("java org.apache.batik.transcoder.print.PrintTranscoder <svgF" +
       "ileToPrint>");
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { if (args.
                                             length <
                                             1) {
                                           java.lang.System.
                                             err.
                                             println(
                                               USAGE);
                                           java.lang.System.
                                             exit(
                                               0);
                                       }
                                       org.apache.batik.transcoder.print.PrintTranscoder transcoder =
                                         new org.apache.batik.transcoder.print.PrintTranscoder(
                                         );
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_LANGUAGE_STR,
                                         KEY_LANGUAGE);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_USER_STYLESHEET_URI_STR,
                                         KEY_USER_STYLESHEET_URI);
                                       setTranscoderStringHint(
                                         transcoder,
                                         KEY_XML_PARSER_CLASSNAME_STR,
                                         KEY_XML_PARSER_CLASSNAME);
                                       setTranscoderBooleanHint(
                                         transcoder,
                                         KEY_SCALE_TO_PAGE_STR,
                                         KEY_SCALE_TO_PAGE);
                                       setTranscoderRectangleHint(
                                         transcoder,
                                         KEY_AOI_STR,
                                         KEY_AOI);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_WIDTH_STR,
                                         KEY_WIDTH);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_HEIGHT_STR,
                                         KEY_HEIGHT);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_PIXEL_TO_MM_STR,
                                         KEY_PIXEL_UNIT_TO_MILLIMETER);
                                       setTranscoderStringHint(
                                         transcoder,
                                         KEY_PAGE_ORIENTATION_STR,
                                         KEY_PAGE_ORIENTATION);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_PAGE_WIDTH_STR,
                                         KEY_PAGE_WIDTH);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_PAGE_HEIGHT_STR,
                                         KEY_PAGE_HEIGHT);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_MARGIN_TOP_STR,
                                         KEY_MARGIN_TOP);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_MARGIN_RIGHT_STR,
                                         KEY_MARGIN_RIGHT);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_MARGIN_BOTTOM_STR,
                                         KEY_MARGIN_BOTTOM);
                                       setTranscoderFloatHint(
                                         transcoder,
                                         KEY_MARGIN_LEFT_STR,
                                         KEY_MARGIN_LEFT);
                                       setTranscoderBooleanHint(
                                         transcoder,
                                         KEY_SHOW_PAGE_DIALOG_STR,
                                         KEY_SHOW_PAGE_DIALOG);
                                       setTranscoderBooleanHint(
                                         transcoder,
                                         KEY_SHOW_PRINTER_DIALOG_STR,
                                         KEY_SHOW_PRINTER_DIALOG);
                                       for (int i =
                                              0;
                                            i <
                                              args.
                                                length;
                                            i++) {
                                           transcoder.
                                             transcode(
                                               new org.apache.batik.transcoder.TranscoderInput(
                                                 new java.io.File(
                                                   args[i]).
                                                   toURL(
                                                     ).
                                                   toString(
                                                     )),
                                               null);
                                       }
                                       transcoder.
                                         print(
                                           );
                                       java.lang.System.
                                         exit(
                                           0);
    }
    public static void setTranscoderFloatHint(org.apache.batik.transcoder.Transcoder transcoder,
                                              java.lang.String property,
                                              org.apache.batik.transcoder.TranscodingHints.Key key) {
        java.lang.String str =
          java.lang.System.
          getProperty(
            property);
        if (str !=
              null) {
            try {
                java.lang.Float value =
                  new java.lang.Float(
                  java.lang.Float.
                    parseFloat(
                      str));
                transcoder.
                  addTranscodingHint(
                    key,
                    value);
            }
            catch (java.lang.NumberFormatException e) {
                handleValueError(
                  property,
                  str);
            }
        }
    }
    public static void setTranscoderRectangleHint(org.apache.batik.transcoder.Transcoder transcoder,
                                                  java.lang.String property,
                                                  org.apache.batik.transcoder.TranscodingHints.Key key) {
        java.lang.String str =
          java.lang.System.
          getProperty(
            property);
        if (str !=
              null) {
            java.util.StringTokenizer st =
              new java.util.StringTokenizer(
              str,
              " ,");
            if (st.
                  countTokens(
                    ) !=
                  4) {
                handleValueError(
                  property,
                  str);
            }
            try {
                java.lang.String x =
                  st.
                  nextToken(
                    );
                java.lang.String y =
                  st.
                  nextToken(
                    );
                java.lang.String width =
                  st.
                  nextToken(
                    );
                java.lang.String height =
                  st.
                  nextToken(
                    );
                java.awt.geom.Rectangle2D r =
                  new java.awt.geom.Rectangle2D.Float(
                  java.lang.Float.
                    parseFloat(
                      x),
                  java.lang.Float.
                    parseFloat(
                      y),
                  java.lang.Float.
                    parseFloat(
                      width),
                  java.lang.Float.
                    parseFloat(
                      height));
                transcoder.
                  addTranscodingHint(
                    key,
                    r);
            }
            catch (java.lang.NumberFormatException e) {
                handleValueError(
                  property,
                  str);
            }
        }
    }
    public static void setTranscoderBooleanHint(org.apache.batik.transcoder.Transcoder transcoder,
                                                java.lang.String property,
                                                org.apache.batik.transcoder.TranscodingHints.Key key) {
        java.lang.String str =
          java.lang.System.
          getProperty(
            property);
        if (str !=
              null) {
            java.lang.Boolean value =
              "true".
              equalsIgnoreCase(
                str)
              ? java.lang.Boolean.
                  TRUE
              : java.lang.Boolean.
                  FALSE;
            transcoder.
              addTranscodingHint(
                key,
                value);
        }
    }
    public static void setTranscoderStringHint(org.apache.batik.transcoder.Transcoder transcoder,
                                               java.lang.String property,
                                               org.apache.batik.transcoder.TranscodingHints.Key key) {
        java.lang.String str =
          java.lang.System.
          getProperty(
            property);
        if (str !=
              null) {
            transcoder.
              addTranscodingHint(
                key,
                str);
        }
    }
    public static void handleValueError(java.lang.String property,
                                        java.lang.String value) {
        java.lang.System.
          err.
          println(
            "Invalid " +
            property +
            " value : " +
            value);
        java.lang.System.
          exit(
            1);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EF4W8q6yJMc1De+ewuJd/Gfh/wDJbf1kJkkAAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.print.PrintTranscoder ENT_ld =
          new org.apache.batik.transcoder.print.PrintTranscoder(
          );
        ENT_ld.
          inputs =
          this.
            inputs;
        ENT_ld.
          printedInputs =
          this.
            printedInputs;
        ENT_ld.
          curIndex =
          this.
            curIndex;
        ENT_ld.
          theCtx =
          this.
            theCtx;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GLlGIrmeb3V+H95fuQU113d49X1478l9czU3ldsnsN+4HOarW8w3DKe5v97L" +
       "bSeD7KPwm7dg6Y0dBWMfhbs91w99ydhI/Xcux+CZcxgwNMuznf7eNvjdSxIo" +
       "PLDljsByH4GHfS3WctUnTjbF71+OyAvnEGERAcm7wsVN8j9eO6P7i9R35sHf" +
       "MfJvYFTa/PjSfvw53bvyLhLnj9NH0O80HC8Kg8AvvfWcCRRWSjZW4ZryE6Mv" +
       "/Oonss98cjtlJkuBFpbK5y173bjyVsygvv2CWeDjBZE/w77uc3/434WXD3aT" +
       "XPedlsDDF0ngaFrgwZMTVtvJvb84I/k/vqTkn99c2X7ScyT/V+dIvvj55esm" +
       "fmOnNLW/lX2R+qc3Ujz3Vte5nCX015ck9JY8vLK7yyv7CV2547UQuluJ/L6j" +
       "aunFE3G5X2IboRHvlq+AVx79vPmDf/Cp7dLU2Vm3M5m17/rY3/mbw4987ODE" +
       "guDbbliTO1lmuyi4gfjABmd6Ssv33GVTAv2fn3nlJ//FK9+5RfXo6eUtxIns" +
       "T/3mX//S4Q984Rf2rKTctht+jtvkyp2XbJO35uHbdm3ybee0yWOvpU3uDHUN" +
       "Dq/3h7ffsMgj+4a60A67m6/davAZ8G+8pLV9Uw7iM9usVz59Dvinb2Fy4aw7" +
       "fUSqctHK1dFyleEs8LxdgueG2voMv7fcAr9f2PH7+XP4PX85fk+c42sXVT17" +
       "Bu47Lgn3qRzmF3ZwP38O3K+9HNwHTz8H70N5eAso/3yH8s/OQQldDuVDZyZJ" +
       "9sGsXx7mwf3brAf3nQPzpVsQ5vEM1D6U774FlM/uUL71HJTdy6F8+Oz03j6c" +
       "8C3gbO1wNs/B2b+kE3/DvO8+oINbAErtgJLnAGVuQTtPzPPugzm6BZi7R+qD" +
       "GycGtjAnt2B5z/q0+7BOL29FD75ph/WD52B9/y20/akZo31Ar10S6CoH+KEd" +
       "0A/dADT3prHCybx66dcnrr47iBeosZkhK658fQHukosFd4y5LcuzDxRXbr48" +
       "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" +
       "trL2vLtuS/3muNkElxBYjmIidjBroIog");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "KZ1dWgAA");
}
