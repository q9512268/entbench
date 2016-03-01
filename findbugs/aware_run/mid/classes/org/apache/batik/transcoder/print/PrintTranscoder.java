package org.apache.batik.transcoder.print;
public class PrintTranscoder extends org.apache.batik.transcoder.SVGAbstractTranscoder implements java.awt.print.Printable, panda.runtime.PANDA_Attributable {
    public int PANDA_attribute() { return org.apache.batik.apps.rasterizer.PandaMode.
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6OcH0UxO0iP7WYj8f1/1PFIESAAA");
    public panda.runtime.PANDA_Attributable PANDA_copy() {
        org.apache.batik.transcoder.print.PrintTranscoder PANDA_ld =
          new org.apache.batik.transcoder.print.PrintTranscoder(
          );
        PANDA_ld.
          inputs =
          this.
            inputs;
        PANDA_ld.
          printedInputs =
          this.
            printedInputs;
        PANDA_ld.
          curIndex =
          this.
            curIndex;
        PANDA_ld.
          theCtx =
          this.
            theCtx;
        return PANDA_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "daDAI5LSfGFkxhr03HqlyGEw4yi1udcf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("lhAfrperNWgEr8fVIVvTNFqS6029ZFQ7qxhRrW5xPhyqRTa2KWDPK9XuDB0k" +
       "KcStHJWYG3J7itMkPK7hvZHJwJXYksQlPkrIbglpheqgzSkVGhgbI5pOISzs" +
       "8IvWWBDbrDPH1RECG74pZTI/HZkGZ3cGuuFGPL5ul6qYPalDDb9Vp7FSwFvE" +
       "AO1Vq2mszOsVWjIjK2ynE3Q87kZltjNl3TCymmlUao6gfgUHHm95qSSdTn0W" +
       "wRQTs7Go081Bw8sSMF6QMblfD2l9tU6oaMzhaKnT1dV6RIbh0PAmtSK/VpzV" +
       "YCkoRsXvjv1uR3FaWmpwLcTneWxRZ2smzSxjojFYSCW3pMdx6E9mk0YdXRj0" +
       "YmzZ8MpNeQsaELNsOrLsdVpHeOBbsixwP3xVqWahKVngPizrQ7WXoJLuhtrU" +
       "KcG8j5ZXfZNDay5dVFQgY05flWwYSnkY0kcCrNegMsZraBXv8n0vtWaiQsNt" +
       "XZ9PydSt9YpVi8AGxV5/MRoo1SKmqmB8Zo41zNFcFMNXWszjcU9xRb8dEHDs" +
       "WtNipcZmglZZrRrUuLIeMqQ885d1VjPcAXhHSLdbvQq6bFcIYNmKkRi1YdEX" +
       "ZFiWVLeatUV4OWvi0bgs+mKbHLlhY6m2zK6MxDNiLQ6YcO5Di6DudamiFgY8" +
       "6dYUz4VErTmfk3UmImLXaZurIbWQWqYLRgBsWcQTSBWaXkrWIoMAxVgDx5vD" +
       "peWcVqZ4H3MljU8IJ8OqNQBwFFLtZOBEeFQWLHfQrIiuALwHXJQiAxiH7pBu" +
       "z+YiVjNNftpGOh5Vo1wxnmkNTG2pektsdZu+qNKzTiVoJWozdOEA63LjVGdT" +
       "toNIK51up03Ngo1mLR6XY21OAX4+too6/YUyVhRclUQBdjvyAGvoYTERwirw" +
       "Av0JG7aIWQstCmgwI6QVQ6srRWjALGFFIs2MLBaZW2xFHwsaWZeLiENzs0pc" +
       "GkjVajFDbFQns3DSqVamEyN10IFMObEjaKgxC1c9J/Z4uqhOAhfv1Sxcn02N" +
       "ElKWCThZO0bFLLl+r0myhjhcTkqViJgEgCPaWguwWkMktxyUSguWSoUOtp6U" +
       "qCm/RJqDdomv6cDidTWl6pVRMk5RkR2OyJIFy2aG6rnnoLNRtlykpAtBQzay" +
       "Vn3J6Sczb1kZSMwIdHzKiIO4UQUapV4llpclTBYtrNZJ2qP5YFFpMfV5XcbG" +
       "3krm2XpbMcjKYrqWwQg9M4egwiys52oQ5VbUucurM82YQmJbDhdK2bDKa1Jb" +
       "ltzRUEalqLdymSq3XOHRvNQS6WRoy02ciazeEoz/hxbarjQXFMFMSdm2Mhln" +
       "7VJWw+U6r2mJ7jrydFhb+BTcqfHiIKtNdGZeDlTVFBf8oA3nA4eYrgqgIhpz" +
       "k+aBkY7sdJzGiyZZhweBsopWydipqapgNHoCWuU7lYnqcv0pgrCtBmxGolLx" +
       "+0rZBx7gZNolWEM2+ny3pPWiObNsckxk1zGxIfc81C+X54GnungmiXF7Bs/M" +
       "xQA1BgKPZArDlcDQckmuUHwJdbP2mFW0JU6X1uN4nikGl/hFy9Uxzuwv7FVN" +
       "JmG47EaJKfPr8hJm5Mao3mxATU5Z4nARkZl6Ly6apSQuS1BWpBmmXyo6xRpU" +
       "4ZQ2aSpGFa+Umn6tHkDAcEQy7CYV2yxyJXTeiZUKL1t4GxU6EjoGyh90V6tl" +
       "x4zU+RiZ1zOjOcXi2mxsY3WhHEzS3ggPghpexeBquTe0YbmE1oQqIWSOqjax" +
       "qlhC2JiBYabF1EbkpNuYU605vWwMquQQGnZVVx1BejBr2T1rOpBLWmIUYx2P" +
       "Bl1vnPCBIYTlsLxyZUJIVlirpwuz0shr6tVm0BkoYFAVa26NrUlqlNUbWj9Y" +
       "zro86MeGwPQTjDlTp+x42FiX19BCHRrwOmHQVB8VAyZbhywZdxVVspYVGc1q" +
       "PO1Pw0yDx2kpM+rteNUhHNeZ8vNRMuj4NrfweyXR9mh53Z7G5FIUMr1K+rZW" +
       "nith1qJbE3PVnC4YJBKnmTGMgZ5ZjKkIXWOKCKmMMnJPJRJpVq4vg1JREDVO" +
       "z/r4tIgPKmY9cRJy7TJlqC0NaytI7+uBBbrjphlDobAyhzhoWlo/7dTQXj9W" +
       "A6GoQoN+ZaHXyHBOi0yH6CkVLq1IRhIvzHU9bslrmCmxIy+c4vZ0OCs1BpO2" +
       "OxTNpFJKRsxKdUd8v1XzqlTRBx123VdUKmqDnmM0L8fUzAtDXpuSEuUq87GA" +
       "JeNJDCqDh0oZuZwMNHohKhMBbukrvY30lk1YzlpLbC6K0LxCBFPIbTNlr1Uk" +
       "u72ZLEay3ySXnj5AjD5FyBLSyIoYwavFeDbpLfW2byIuy6xMmu6Vu02o20Zg" +
       "FXPCWWi7SbO8Bpo+1YfNcVXxKUjhSmbSM/S4PW6o60mogLGaRGfl+WKoBtrc" +
       "bgh1D6cm635tgLUnkFfjhGVT4KnJLG5HripniTB3+mLoMH3fFXuMQ83mXZZw" +
       "I64JVTtoh2KmAiPHcWViSaqhrvsrPFiuuYoYw8W1vigPl4taZykFIVJBEmZZ" +
       "j23gGvSWQQc0AXJmJhTqWlZWw8w1gnqiZiOik/Xh2YRlsSI6MwRkvOBgcdCh" +
       "MrFRa0x5iPDwtit3pTZu1MomhpYAhVINmjF1KK0Dg+kI5arUKJcFOO12a9N5" +
       "g5QQxoSZILYUVplWGD/hRZLCpWLbGratcrMjN1wiDI2QiFf1vlvtx1jK1Vkq" +
       "nMFIdUpSvkeUuvIKmsksrI04f1QU4Kwc60HUXNalno0INZ6U1w49rpWqgtmP" +
       "o5UXzQcj1K4zlq5kBhoN5FVjGrPDcnu64CZVm2+li2pUrqwmYV2y4BEvNwJn" +
       "xC6WsLSSMd7rL/iqqZXQoTPGptJoVW+gBMuUQAupEcDtr1WNEE6XlXo86RWD" +
       "aXkptqoMNI0a5LQdTfm6kLQa5UUxbhPeeiy2QRNf8zoaxsw8cRc9qEX0HFbX" +
       "2SmwO+FoMscbiW3Q7QoUkI0qF6JiJvVgWi4vca/ZCSx+jqgQ5DbH2VqqkX01" +
       "Zlg1RCbLMabTUUVoVKrVDhkZfJ1H1k03nE1Vi50TbTtMVAvpzYDdt2cxX2py" +
       "SNShaBHqwx3did2oFyrdut5TzVUMBm+VarmF02qtypkdpJ9xiMNjqjatjYpw" +
       "kW9ThNRoNPK1og9dcjlzs7p2/eSDW1hX2z56ax68/fqi5ubvzsJul/zR/xOL" +
       "mpuU2z2VB0ff2Dy5WWvTl8nJtcx8E+xRgqthvr39MEr9xPHsQ74BusprjSSJ" +
       "HCPdJMy/u3r6vKMRNt9c/eC3ffRVi/uh4u6DvysPJYV7kiD8Wtde2O4JUA+C" +
       "kt55/vdlzOZkiOPdlj/7bX/4lPwNk/dfYg/5M2dwni3yXzGf/HnyefN7Dwq3" +
       "Xd97ecOZFaczvXR6x+W9kZ2kkS+f2nf59PU62pxo8GZwXdnV0eZ/Uvj2G3dE" +
       "ft3VearHzjwNEvuF7Vbpq6Burm5rQN/VgP3Ci1c/cPW927feuFath2F8GOlx" +
       "YkfO2o4ON2cVMIFlf0D3jFcOaU69xnAt4qWXpauvvBiG2bEOnqdcp4Dntfl9" +
       "4BV5qr07mK/8kwuefSIPPpYUHjpDKY9+4HjF+6b7V06Wu1m7/d7rsDef8sDg" +
       "+oc72B85u9B/gvHeL+5e2LbaMzQOTrci6LV8qWZH2y9Cd3ne9drycGkCMm3k" +
       "9SMXyPJTefDP84Z1lHPvivYicKxjyf6L1yHZB/PICrj+2U6y//Qyks23PkVA" +
       "sU2g6HsFfNvWgh4J67FcWEvUPLQC77AVmKlnb7/FzK3mlR/diOAnzhRxZXc6" +
       "xa4I+LXJm8hM0EsAM7Ip8z/kwWdPijWP+MyxCG+6s+RmyvkEuD69E+ENH1Xe" +
       "mnKe1ItfuFgoz+wz/2eF8Et58DMnNmCcFMDPvg4BPJRHPgbgPL6zKY9/dQRw" +
       "RnkeuU6SjPRw4pjx0ZOvOUtfH9vt/GyODcsHNux/8wLpfj4Pfu2kZE7YrV9/" +
       "va0L5Luy+0Dpyg0fKN1EMld+/GZ266xtuGPkBlvef7jh9gcX8P6jPPjdpHB/" +
       "frqPB4Qmgd7ljGL83uugv/kSEwVMPrKjf2mz/eWL6Ocv+60jHXjD8ddGp9X+" +
       "zy8QwF/mwZ8Au2BF+pKIoiA6w/5/vw72j+aR7wQ4P7TNu/3/GtkfbJpFHrT2" +
       "iuDIAFy4W2Nzfsn2y/xXf/htv/wtr77tv26OALnbiRU9akTjPcdhncjzx5/8" +
       "/Bd/9YGnP705JmezlSR/+71nzxG78ZiwU6d/beDff10qj+VCyI/AOeM6XXtt" +
       "rtP2jIqrmxMqrm6Pknjvy1dz5+davotNuvr1V317uXuy8Y7ee3h4+PJLR14R" +
       "tdeE5l97Hdy7+6zx4IGbVcn1IcCdru2PNxsIr+S7Fw7uCbPzfIsT+om7gW+f" +
       "dM63JzQ5weH10942DvkepFe+d4t087ITDt4+FTmh6AdPXfDszXnwBLAcZo5r" +
       "S+OC5M9k2/937tfIHORfbBLkyA6Ai3C7pzv+6XZ1cPB62xUJRPulXbv64lex" +
       "XZ3pc55/bd7GRrNylM9umEMXiA/Og+eTwuPA5h4X0M6NdueGbvngppsJbian" +
       "HqD8lZ2c/uKrL6cc47vOsK9fwP6lPCgnhadOsReBAwkahmvvkcBNdwDcTAIU" +
       "gPnGbd7b3vA3IwHiAgnke0YO3gNG7Kck0AwC19b9PfwbX4WWctszO/5P/83w" +
       "Fy7gL+UBnRSeOMV/a6/30GdeL30wtrntHTv6z38V6R/7INspH2rD7uULmF/L" +
       "g0FSeHgCRu+uvTkvao/PcaC9DsqbiYmc5une9Yr+2nrXG6eFdlFmEK62UxRn" +
       "vpLfdLG7RK616333pXkBdMMvvvSuq/ZCd184Sr+dvtjubgV5k4kT736dk/TU" +
       "nsyjHKciz8l4tPfxKM/R73OSb7flHSXe/sqT7iZoTiV+HbMuB6OLZl0Ophc8" +
       "y48mPbCSwr3HFZSrwt871iP7MnqU5fM3p6stPwzvyRuOtN0ew2p++tWH7n7i" +
       "1f5/3vqGR0el3kMX7h6lrnvy7LIT93eGkT1yNnK6Z3uS2UZoB/mBuzfdn3E0" +
       "PMuhH0TbjIuk8KYLMgLpHP84mW8FWuHZfKD8zf+T6b4ZlHCcDvh725uTSb4l" +
       "KdwGkuS3HwqP3IYLD+uUFLJhxCDCPCHsbOuIPnmiWW/njx+9WS1ez3LyDMd8" +
       "KLA5tPhohjTld/vDP/Nql/3Al6s/tD1D0nT19Tov5W7gtW+Ps9x57Wf3mp8s" +
       "7aisOzsvfuXBH7vn7UdbwB/cAj5uByewPbP/wEbCC5PNEYvrf//Ev3n3j7z6" +
       "O5vNIf8fH9s6uk1aAAA=");
}
