package org.apache.batik.transcoder.image;
public abstract class ImageTranscoder extends org.apache.batik.transcoder.SVGAbstractTranscoder implements panda.runtime.PANDA_Attributable {
    protected ImageTranscoder() { super(); }
    protected void transcode(org.w3c.dom.Document document, java.lang.String uri,
                             org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        super.
          transcode(
            document,
            uri,
            output);
        int w =
          (int)
            (width +
               0.5);
        int h =
          (int)
            (height +
               0.5);
        org.apache.batik.gvt.renderer.ImageRenderer d_renderer =
          createRenderer(
            );
        d_renderer.
          updateOffScreen(
            w,
            h);
        d_renderer.
          setTransform(
            curTxf);
        d_renderer.
          setTree(
            this.
              root);
        java.lang.String recovstr =
          java.lang.System.
          getenv(
            "PANDA_RECOVER");
        boolean recover =
          true;
        if (recovstr !=
              null &&
              recovstr.
              equals(
                "false")) {
            recover =
              false;
        }
        org.apache.batik.gvt.renderer.ImageRenderer renderer =
          null;
        try {
            renderer =
              panda.runtime.PANDA_Snapshot.
                snapshot(
                  d_renderer,
                  org.apache.batik.apps.rasterizer.PandaMode.
                    LOW_MODE,
                  panda.runtime.PANDA_Runtime.
                    getObjMode(
                      this,
                      0),
                  true);
            panda.runtime.PANDA_Util.
              writeModeFile(
                panda.runtime.PANDA_Util.
                  dumpMode(
                    renderer) +
                "\n");
        }
        catch (java.lang.RuntimeException e) {
            if (recover) {
                width =
                  1024;
                super.
                  updateTransform(
                    document,
                    uri);
                w =
                  (int)
                    (width +
                       0.5);
                h =
                  (int)
                    (height +
                       0.5);
                d_renderer.
                  setTransform(
                    curTxf);
            }
            renderer =
              panda.runtime.PANDA_Snapshot.
                forceSnapshot(
                  d_renderer,
                  org.apache.batik.apps.rasterizer.PandaMode.
                    LOW_MODE,
                  panda.runtime.PANDA_Runtime.
                    getObjMode(
                      this,
                      0),
                  true);
            if (recover) {
                panda.runtime.PANDA_Util.
                  writeModeFile(
                    "Recovered to " +
                    panda.runtime.PANDA_Util.
                      dumpMode(
                        renderer) +
                    "\n");
            }
            else {
                panda.runtime.PANDA_Util.
                  writeModeFile(
                    "Forced to " +
                    panda.runtime.PANDA_Util.
                      dumpMode(
                        renderer) +
                    "\n");
            }
        }
        this.
          root =
          null;
        try {
            java.awt.Shape raoi =
              new java.awt.geom.Rectangle2D.Float(
              0,
              0,
              width,
              height);
            renderer.
              repaint(
                curTxf.
                  createInverse(
                    ).
                  createTransformedShape(
                    raoi));
            java.awt.image.BufferedImage rend =
              renderer.
              getOffScreen(
                );
            renderer =
              null;
            java.awt.image.BufferedImage dest =
              createImage(
                w,
                h);
            java.awt.Graphics2D g2d =
              org.apache.batik.ext.awt.image.GraphicsUtil.
              createGraphics(
                dest);
            if (hints.
                  containsKey(
                    KEY_BACKGROUND_COLOR)) {
                java.awt.Paint bgcolor =
                  (java.awt.Paint)
                    hints.
                    get(
                      KEY_BACKGROUND_COLOR);
                g2d.
                  setComposite(
                    java.awt.AlphaComposite.
                      SrcOver);
                g2d.
                  setPaint(
                    bgcolor);
                g2d.
                  fillRect(
                    0,
                    0,
                    w,
                    h);
            }
            if (rend !=
                  null) {
                g2d.
                  drawRenderedImage(
                    rend,
                    new java.awt.geom.AffineTransform(
                      ));
            }
            g2d.
              dispose(
                );
            rend =
              null;
            writeImage(
              dest,
              output);
        }
        catch (java.lang.Exception ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    protected org.apache.batik.gvt.renderer.ImageRenderer createRenderer() {
        return (org.apache.batik.gvt.renderer.StaticRenderer)
                 panda.runtime.PANDA_Runtime.
                 putObj(
                   new org.apache.batik.gvt.renderer.StaticRenderer(
                     ),
                   new java.lang.Integer[] { org.apache.batik.apps.rasterizer.PandaMode.
                                               DYNAMIC_MODE });
    }
    protected void forceTransparentWhite(java.awt.image.BufferedImage img,
                                         java.awt.image.SinglePixelPackedSampleModel sppsm) {
        int w =
          img.
          getWidth(
            );
        int h =
          img.
          getHeight(
            );
        java.awt.image.DataBufferInt biDB =
          (java.awt.image.DataBufferInt)
            img.
            getRaster(
              ).
            getDataBuffer(
              );
        int scanStride =
          sppsm.
          getScanlineStride(
            );
        int dbOffset =
          biDB.
          getOffset(
            );
        int[] pixels =
          biDB.
          getBankData(
            )[0];
        int p =
          dbOffset;
        int adjust =
          scanStride -
          w;
        int a =
          0;
        int r =
          0;
        int g =
          0;
        int b =
          0;
        int pel =
          0;
        for (int i =
               0;
             i <
               h;
             i++) {
            for (int j =
                   0;
                 j <
                   w;
                 j++) {
                pel =
                  pixels[p];
                a =
                  pel >>
                    24 &
                    255;
                r =
                  pel >>
                    16 &
                    255;
                g =
                  pel >>
                    8 &
                    255;
                b =
                  pel &
                    255;
                r =
                  (255 *
                     (255 -
                        a) +
                     a *
                     r) /
                    255;
                g =
                  (255 *
                     (255 -
                        a) +
                     a *
                     g) /
                    255;
                b =
                  (255 *
                     (255 -
                        a) +
                     a *
                     b) /
                    255;
                pixels[p++] =
                  a <<
                    24 &
                    -16777216 |
                    r <<
                    16 &
                    16711680 |
                    g <<
                    8 &
                    65280 |
                    b &
                    255;
            }
            p +=
              adjust;
        }
    }
    public abstract java.awt.image.BufferedImage createImage(int width,
                                                             int height);
    public abstract void writeImage(java.awt.image.BufferedImage img,
                                    org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException;
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_BACKGROUND_COLOR =
      new org.apache.batik.transcoder.keys.PaintKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_FORCE_TRANSPARENT_WHITE =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445633703000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445633703000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NdOY62pkcXqTWEdDOd7pQ84lOrAk+XLY05xOi57sZkqN769Cuz+eYf5utSE4" +
       "FJYaMlMPJl7OjWycwndsVVo1m1XT0NWksmlndHu9SitbUx/O4ZpRmTZCW9Ph" +
       "lef17GrK8NZaJ2GCp7tSG2/GxgjptxZWrDX8GGtpME9ttV6HzfDFKjN7ynie" +
       "dSoMO5u3vRlZRxCKj+qVHs9mbr2h0st16sVrf52N5GYlnNFCMhpKVDdOWa1v" +
       "7+zett2QM2OO01Nz2OhM0xzFqsFmFMc4njbNuj33F3p3EC25Cs+b8yLBXrAM" +
       "3tHcqkkJGcbluCAuTF3fjJh5vK2J2cqeJro1zyg7nqOhua6onGYOuV2HFOto" +
       "vUYSGcrbE16ZmT2YcrrLRS1t6+6202lMGrE8kBQzqTUJ8NnhBqifSiA/d9xU" +
       "9NBhEs/nOAzPR/VEDOuTPjapNWoKNWit5j3GoqjpdKPQi5zoD4Z+G50PjDHB" +
       "ILV+uKnbltgNW2NsvuS3WqNt5pKeVmkr4L1dC1s7u/VMqMN8U81bA02Q1q62" +
       "IDNeM92J2V85IUNtZCtB/SEidSbA8BwxZVOiqWQesMeVn2p9uMdZNL4kwIfJ" +
       "DqdbendFCvAcF6uDVYD2rM4Kre/SrCXbLLuJ6TGGFZ/M/hvbtXi03KA5Oym1" +
       "3XbRsXgDX+v5nQc8KgdMoAcVNU4iRUvON+LL3/XDo7eLG/Hnu7NXTneKng2L" +
       "o7DjKPUTyzOOeYwlsFtYkkSWmibFtnqxj/H03Y5Ryz2Mz33kpZd17ieRo5Pt" +
       "byuBHkqC8P2ukRnuwY7we+++XzMqT5HPt2V/9SN/8pT4PasPvoHzpncd8HlI" +
       "8t+OXvl16ju0HzuC7jvbpL3tfPsy0guXt2YfjowkjXzx0gbt05fPfJrgWZxM" +
       "wezOZz53nNorRfU79xZ0cLpw397YTift8WJbdVPXjvXAOyYCLfUMvzwqWZxC" +
       "vO8b2Xg1Ii5NwjQph/zYwZBXLtsJ/I0R7OWaERazVNL8RFH8UGEOpwAlOf2C" +
       "7a8S6P4ssPRzp/hnr7eFdfHEoWz48Jn+bxaNNfB8/kT/n//W6P/i6c5n79H3" +
       "r4riMwn0iBYZSmJMDB/oxIhOlVi5TYnLLDmOTqD2Z7qXcEqF/Pg3oZDSIG+B" +
       "54snCvnit0YhR/tgdCrYO8vdX2WTnJxO46lZnKXqpURn0h8ACZa/dA3eyg23" +
       "uNZh6ILiha4xAmbiloP+u3to+t8Xxb9OoCfMINL2B+GhAjSZzFZWUvrmj51r" +
       "8Ke+CQ0+XzQWZwqvnWjwtTegwaOz5WHzumo88Ir7rL1L/2KJ+Av3UMWrRfGf" +
       "EuhNe6MrdV40vXKugJ//JhTweNHIgecrJwr4yrdeASW7RfHxEuq/3TkWFa8/" +
       "WgJ8qSh+OYEe3kTWBYkvTPmvvBGJ8wS6fnChojgafvK2O177e0naz7x8/cG3" +
       "vzz93fJOwdndoYcY6EEzdd2LJ3kX6tfCyDCtkv2H9ud6Yfn3PxLoude975FA" +
       "V60zX/qtPeLvJNA77oEItHP+chHv9xPoxiEeoF/+X4T7X4DCOVwCXdtXLoJ8" +
       "GdgpACmqr4Wnfn7P2yuCRGEnmcu5svMrF9KEEwMsZ/Gx15vFM5SLlxqK1KK8" +
       "xXeaBqT7e3y3tC+8PGA/9LXWT+4vVWiustsVVB5koAf29zvOUonn7krtlNY1" +
       "+j1ff+RnH/r207TnkT3D585wgbd33fn6Qs8Lk/LCwe6Lb/+P3/1TL/9BeVj2" +
       "97Grv/JeKQAA");
}
