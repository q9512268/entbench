package org.apache.batik.transcoder.wmf.tosvg;
public class WMFTranscoder extends org.apache.batik.transcoder.ToSVGAbstractTranscoder implements panda.runtime.PANDA_Attributable {
    public int PANDA_attribute() { return org.apache.batik.apps.rasterizer.PandaMode.
                                            LOW_MODE; }
    public WMFTranscoder() { super(); }
    public void transcode(org.apache.batik.transcoder.TranscoderInput input,
                          org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        java.io.DataInputStream is =
          getCompatibleInput(
            input);
        org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore =
          new org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore(
          );
        try {
            currentStore.
              read(
                is);
        }
        catch (java.io.IOException e) {
            handler.
              fatalError(
                new org.apache.batik.transcoder.TranscoderException(
                  e));
            return;
        }
        float wmfwidth;
        float wmfheight;
        float conv =
          1.0F;
        if (hints.
              containsKey(
                KEY_INPUT_WIDTH)) {
            wmfwidth =
              ((java.lang.Integer)
                 hints.
                 get(
                   KEY_INPUT_WIDTH)).
                intValue(
                  );
            wmfheight =
              ((java.lang.Integer)
                 hints.
                 get(
                   KEY_INPUT_HEIGHT)).
                intValue(
                  );
        }
        else {
            wmfwidth =
              currentStore.
                getWidthPixels(
                  );
            wmfheight =
              currentStore.
                getHeightPixels(
                  );
        }
        float width =
          wmfwidth;
        float height =
          wmfheight;
        if (hints.
              containsKey(
                KEY_WIDTH)) {
            width =
              ((java.lang.Float)
                 hints.
                 get(
                   KEY_WIDTH)).
                floatValue(
                  );
            conv =
              width /
                wmfwidth;
            height =
              height *
                width /
                wmfwidth;
        }
        int xOffset =
          0;
        int yOffset =
          0;
        if (hints.
              containsKey(
                KEY_XOFFSET)) {
            xOffset =
              ((java.lang.Integer)
                 hints.
                 get(
                   KEY_XOFFSET)).
                intValue(
                  );
        }
        if (hints.
              containsKey(
                KEY_YOFFSET)) {
            yOffset =
              ((java.lang.Integer)
                 hints.
                 get(
                   KEY_YOFFSET)).
                intValue(
                  );
        }
        float sizeFactor =
          currentStore.
          getUnitsToPixels(
            ) *
          conv;
        int vpX =
          (int)
            (currentStore.
               getVpX(
                 ) *
               sizeFactor);
        int vpY =
          (int)
            (currentStore.
               getVpY(
                 ) *
               sizeFactor);
        int vpW;
        int vpH;
        if (hints.
              containsKey(
                KEY_INPUT_WIDTH)) {
            vpW =
              (int)
                (((java.lang.Integer)
                    hints.
                    get(
                      KEY_INPUT_WIDTH)).
                   intValue(
                     ) *
                   conv);
            vpH =
              (int)
                (((java.lang.Integer)
                    hints.
                    get(
                      KEY_INPUT_HEIGHT)).
                   intValue(
                     ) *
                   conv);
        }
        else {
            vpW =
              (int)
                (currentStore.
                   getWidthUnits(
                     ) *
                   sizeFactor);
            vpH =
              (int)
                (currentStore.
                   getHeightUnits(
                     ) *
                   sizeFactor);
        }
        org.apache.batik.transcoder.wmf.tosvg.WMFPainter painter =
          new org.apache.batik.transcoder.wmf.tosvg.WMFPainter(
          currentStore,
          xOffset,
          yOffset,
          conv);
        org.w3c.dom.Document doc =
          this.
          createDocument(
            output);
        svgGenerator =
          new org.apache.batik.svggen.SVGGraphics2D(
            doc);
        svgGenerator.
          getGeneratorContext(
            ).
          setPrecision(
            4);
        painter.
          paint(
            svgGenerator);
        svgGenerator.
          setSVGCanvasSize(
            new java.awt.Dimension(
              vpW,
              vpH));
        org.w3c.dom.Element svgRoot =
          svgGenerator.
          getRoot(
            );
        svgRoot.
          setAttributeNS(
            null,
            SVG_VIEW_BOX_ATTRIBUTE,
            java.lang.String.
              valueOf(
                vpX) +
            ' ' +
            vpY +
            ' ' +
            vpW +
            ' ' +
            vpH);
        writeSVGToOutput(
          svgGenerator,
          svgRoot,
          output);
    }
    private java.io.DataInputStream getCompatibleInput(org.apache.batik.transcoder.TranscoderInput input)
          throws org.apache.batik.transcoder.TranscoderException {
        if (input ==
              null) {
            handler.
              fatalError(
                new org.apache.batik.transcoder.TranscoderException(
                  java.lang.String.
                    valueOf(
                      ERROR_NULL_INPUT)));
        }
        java.io.InputStream in =
          input.
          getInputStream(
            );
        if (in !=
              null) {
            return new java.io.DataInputStream(
              new java.io.BufferedInputStream(
                in));
        }
        java.lang.String uri =
          input.
          getURI(
            );
        if (uri !=
              null) {
            try {
                java.net.URL url =
                  new java.net.URL(
                  uri);
                in =
                  url.
                    openStream(
                      );
                return new java.io.DataInputStream(
                  new java.io.BufferedInputStream(
                    in));
            }
            catch (java.net.MalformedURLException e) {
                handler.
                  fatalError(
                    new org.apache.batik.transcoder.TranscoderException(
                      e));
            }
            catch (java.io.IOException e) {
                handler.
                  fatalError(
                    new org.apache.batik.transcoder.TranscoderException(
                      e));
            }
        }
        handler.
          fatalError(
            new org.apache.batik.transcoder.TranscoderException(
              java.lang.String.
                valueOf(
                  ERROR_INCOMPATIBLE_INPUT_TYPE)));
        return null;
    }
    public static final java.lang.String WMF_EXTENSION = ".wmf";
    public static final java.lang.String SVG_EXTENSION = ".svg";
    public static void main(java.lang.String[] args) throws org.apache.batik.transcoder.TranscoderException {
        if (args.
              length <
              1) {
            java.lang.System.
              out.
              println(
                "Usage : WMFTranscoder.main <file 1> ... <file n>");
            java.lang.System.
              exit(
                1);
        }
        org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder transcoder =
          new org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder(
          );
        int nFiles =
          args.
            length;
        for (int i =
               0;
             i <
               nFiles;
             i++) {
            java.lang.String fileName =
              args[i];
            if (!fileName.
                  toLowerCase(
                    ).
                  endsWith(
                    WMF_EXTENSION)) {
                java.lang.System.
                  err.
                  println(
                    args[i] +
                    " does not have the " +
                    WMF_EXTENSION +
                    " extension. It is ignored");
            }
            else {
                java.lang.System.
                  out.
                  print(
                    "Processing : " +
                    args[i] +
                    "...");
                java.lang.String outputFileName =
                  fileName.
                  substring(
                    0,
                    fileName.
                      toLowerCase(
                        ).
                      indexOf(
                        WMF_EXTENSION)) +
                SVG_EXTENSION;
                java.io.File inputFile =
                  new java.io.File(
                  fileName);
                java.io.File outputFile =
                  new java.io.File(
                  outputFileName);
                try {
                    org.apache.batik.transcoder.TranscoderInput input =
                      new org.apache.batik.transcoder.TranscoderInput(
                      inputFile.
                        toURL(
                          ).
                        toString(
                          ));
                    org.apache.batik.transcoder.TranscoderOutput output =
                      new org.apache.batik.transcoder.TranscoderOutput(
                      new java.io.FileOutputStream(
                        outputFile));
                    transcoder.
                      transcode(
                        input,
                        output);
                }
                catch (java.net.MalformedURLException e) {
                    throw new org.apache.batik.transcoder.TranscoderException(
                      e);
                }
                catch (java.io.IOException e) {
                    throw new org.apache.batik.transcoder.TranscoderException(
                      e);
                }
                java.lang.System.
                  out.
                  println(
                    ".... Done");
            }
        }
        java.lang.System.
          exit(
            0);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wFcfptABR4AAA==");
    public panda.runtime.PANDA_Attributable PANDA_copy() {
        org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder PANDA_ld =
          new org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder(
          );
        return PANDA_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6e9Ak11Vf76fVSlpL2pX8UoQlf7JWjqUxX8+7e1gMnunp" +
       "nu559Ux3T09P22bd06/pmX6/Z5wNtotgFVQ5BmRjCiP+sUkA2aZSuJJU4pRS" +
       "qYQ3lF0uEqBAQFGFwTElVYGhMITc7vm+b77H7kqK/8hUzZ2ee8+595x7zvnd" +
       "0/feF74J3R34UMF1zLVuOuGBmoYHS7N2EK5dNTjo9msjyQ9UBTOlIOBA3Q35" +
       "Hb905Vvf/sTi6h50SYTeKNm2E0qh4dgBowaOGatKH7qyq8VN1QpC6Gp/KcUS" +
       "HIWGCfeNILzeh95wgjWErvWPRICBCDAQAc5FgJs7KsD0gGpHFpZxSHYYeNC/" +
       "hC70oUuunIkXQk+c7sSVfMk67GaUawB6uDf7zwOlcubUh/aPdd/qfE7hTxbg" +
       "537yB67+u7ugKyJ0xbDZTBwZCBGCQUTofku15qofNBVFVUToIVtVFVb1Dck0" +
       "NrncIvRwYOi2FEa+ejxJWWXkqn4+5m7m7pcz3fxIDh3/WD3NUE3l6N/dminp" +
       "QNe37HTdakhk9UDBywYQzNckWT1iubgybCWE3n6W41jHaz1AAFjvsdRw4RwP" +
       "ddGWQAX08NZ2pmTrMBv6hq0D0rudCIwSQo/ettNsrl1JXkm6eiOEHjlLN9o2" +
       "Aar78onIWELozWfJ8p6AlR49Y6UT9vnm8Hs//iGbtPdymRVVNjP57wVMj59h" +
       "YlRN9VVbVreM9z/T/5T0li8/uwdBgPjNZ4i3NP/+X7zy3nc//uKvbmm+6xY0" +
       "9HypyuEN+bPzB7/yNuzpxl2ZGPe6TmBkxj+lee7+o8OW66kLIu8txz1mjQdH" +
       "jS8y/2P24V9Qv7EHXaagS7JjRhbwo4dkx3INU/U7qq36UqgqFHSfaitY3k5B" +
       "94DnvmGr21pa0wI1pKCLZl51ycn/gynSQBfZFN0Dng1bc46eXSlc5M+pC0HQ" +
       "PeAL3Q++74e2n/w3hEJ44VgqLMmSbdgOPPKdTP/MoLYiwaEagGcFtLoOPAf+" +
       "v/ru0gECB07kA4eEHV+HJeAVC3XbCIe+ZAeyo6g+nFgaHDpBrMPTAcEd1x9k" +
       "3uf+fxo3zebjanLhAjDV284ChQlijHRMQHtDfi5q4a984cZv7B0HzuFMhlAF" +
       "DH6wHfwgH/xgN/gBGPwgH/zg1ODQhQv5mG/KhNi6BjDsCkAEAM/7n2Y/0P3g" +
       "s++4C/ikm1wEVslI4dtjOLYDFSqHThl4NvTip5OP8D9Y3IP2ToNxJjioupyx" +
       "jzIIPYbKa2eD8Fb9XvnY17/1xU/ddHbheArdD1HiPGcW5e84O8W+I6sKwM1d" +
       "98/sS1+68eWb1/agiwA6AFyGEnBvgESPnx3jVLRfP0LOTJe7gcKa41uSmTUd" +
       "wd3lcOE7ya4mt/2D+fNDYI7fkLn/I+CrHsZD/pu1vtHNyjdtfSUz2hktcmR+" +
       "D+v+zP/67b+o5NN9BOJXTiyLrBpePwEcWWdXcoh4aOcDnK+qgO4PPz36iU9+" +
       "82Pvyx0AUDx5qwGvZSUGAAOYEEzzv/pV7/de+qPPfm1v5zQhWDmjuWnI6bGS" +
       "WT10+Q5KgtHeuZMHAI8JgjDzmmsT23IUQzOkualmXvoPV54qfel/f/zq1g9M" +
       "UHPkRu9+9Q529f+sBX34N37gbx/Pu7kgZwvfbs52ZFs0feOu56bvS+tMjvQj" +
       "X33sp35F+hmAywALA2Oj5vAG5XMA5UaDc/2fycuDM22lrHh7cNL5T8fXiQTl" +
       "hvyJr738AP/yf3kll/Z0hnPS1gPJvb51r6zYT0H3bz0b6aQULABd9cXh+6+a" +
       "L34b9CiCHmWAZgHtA4hIT3nGIfXd9/z+f/1vb/ngV+6C9gjosulICiHlQQbd" +
       "B7xbDRYArlL3+9+7NW5yLyiu5qpC55TfOsUj+b8sR3z69vhCZAnKLkQf+Xva" +
       "nH/0T//u3CTkyHKLdfkMvwi/8JlHse/7Rs6/C/GM+/H0PA6DZG7HW/4F62/2" +
       "3nHpv+9B94jQVfkwU+QlM8oCRwTZUXCUPoJs8lT76Uxnu6xfP4awt52FlxPD" +
       "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" +
       "4Vcz/zHLyZtE2SqTX6A9Sr6j7RXaG/IX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("n+8OP/RK/XPbm0yyKW02WS/3ggVhe6nqOIF/4ra9HfV1iXz62w/+0n1PHb1s" +
       "PLgVeBdAJ2R7+62vDeGWG+YXfTb/4a2//L3/5vk/yk+5/y/rcKJL2SwAAA==");
}
