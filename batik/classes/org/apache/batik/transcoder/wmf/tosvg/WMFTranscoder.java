package org.apache.batik.transcoder.wmf.tosvg;
public class WMFTranscoder extends org.apache.batik.transcoder.ToSVGAbstractTranscoder implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pjInqx4AAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder ENT_ld =
          new org.apache.batik.transcoder.wmf.tosvg.WMFTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FLu4lZJmd1oSJ/Iwxse63R77Ps9QqKlwtIity/6qSrcir+Q1xz1emgOXF1aG" +
       "bS3bnfaiAzieKQdoukrndLAScTRmAoRslqVuIy1WIuD0mbBXmejubMmZsxVP" +
       "9pveiIldelJuamVfqgomI3YmS6Zjp2Vyys8m1hhDp74iTFaD6by5RtlaEKD9" +
       "FbpmHEcZCoOGTgVMg9mW6qgMFt2IZ8XFeLadkXbb7zLKXJiTm4Y7aoac64qB" +
       "YNXb0dJbJHJpPmBoVkyrnTQoNnsc0Qlnhj9YOV60XvRHmlbjelSZtOgxCYhQ" +
       "nZKrpuQKTNt2U4beuny5seaqXdLjJNZdTXGcm5LkrD2r98QWtVKsImNU+opt" +
       "F5dVRS5iowhB1g0FdfxwQvQ1ppIM1pGrJqU4VG1hGJKV4cQhtXkrWDRmGNf3" +
       "U6xf0Xo8UUdLciD1a0XcnS/L/kRRqQVHt3SCSVuoJbvBQK9LNkatBVUd4HWP" +
       "M+deO0ymstpDLJZxOzWxOzIJssdsZYfklDYqd6Z2uVasr6tmo7PlyqTY86St" +
       "j4+nFX45Crw4oTwghLPByE46WsDZa5eKNnYloSZN0GgYK5GqlYj60iLnPcCv" +
       "a7jPF6dywI8TstKkZ7EfGYm6CKJtJ+l3EbbTm3ADR++x0wQj2W5XTey+Xh3i" +
       "hitYc6XHT7k6a5u+tKzwTVkWtaXI6ozaxuvLluWVynG8bEb9oDcpkp0JqrGM" +
       "1R7TTZ3YxtWRB/qmV15xhjrcdLCIktXYbKSqgaTiuGmjyqipDeIut2kIg2ar" +
       "O8AWM6k13G42UxxzI7ZZbSymmtR0QWPuJnJLHHWTEaezjtOzpzG5qqiVaqvL" +
       "VlscV+myI85YkI0AssoxDEHUFn6yxeX6aM6CslXpqh2xbQdsf4ACpD8OK8xs" +
       "LrTYraFIHUcI2CWGJhPCq22ZcBWkk5Xre54cMkS33a9gYlCuNJqe05sken8R" +
       "B01GLLpbk6MAxQdy6I3XqjCQUAbp0X1ALtt+OyZKi+lWoBoT2WmXamCE0SzF" +
       "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" +
       "3hE+3PVa2dSdzDrEMoBVcri3U3LuRDJ+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("GEO5+R99I/Mfdzl52yhbW/KLtEfJdrS7SntD/upL/eFHX8e/tLvtJFtSmmaj" +
       "XILLwO7i1XHC/vQdRzsa62L3+R88/Gv3P3f0cvHwjuF9+Jzg7T23v1pE2l6Y" +
       "XwZKf+Pdv/7jv/zSH+Un4f8XiyMU9OEsAAA=");
}
