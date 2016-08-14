package org.apache.batik.ext.awt.image.rendered;
public class CompositeRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    org.apache.batik.ext.awt.image.CompositeRule rule;
    java.awt.CompositeContext[] contexts;
    public CompositeRed(java.util.List srcs, org.apache.batik.ext.awt.image.CompositeRule rule) {
        super(
          );
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            srcs.
            get(
              0);
        java.awt.image.ColorModel cm =
          fixColorModel(
            src);
        this.
          rule =
          rule;
        org.apache.batik.ext.awt.image.SVGComposite comp =
          new org.apache.batik.ext.awt.image.SVGComposite(
          rule);
        contexts =
          (new java.awt.CompositeContext[srcs.
                                           size(
                                             )]);
        int idx =
          0;
        java.util.Iterator i =
          srcs.
          iterator(
            );
        java.awt.Rectangle myBounds =
          null;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            contexts[idx++] =
              comp.
                createContext(
                  cr.
                    getColorModel(
                      ),
                  cm,
                  null);
            java.awt.Rectangle newBound =
              cr.
              getBounds(
                );
            if (myBounds ==
                  null) {
                myBounds =
                  newBound;
                continue;
            }
            switch (rule.
                      getRule(
                        )) {
                case org.apache.batik.ext.awt.image.CompositeRule.
                       RULE_IN:
                    if (myBounds.
                          intersects(
                            newBound))
                        myBounds =
                          myBounds.
                            intersection(
                              newBound);
                    else {
                        myBounds.
                          width =
                          0;
                        myBounds.
                          height =
                          0;
                    }
                    break;
                case org.apache.batik.ext.awt.image.CompositeRule.
                       RULE_OUT:
                    myBounds =
                      newBound;
                    break;
                default:
                    myBounds.
                      add(
                        newBound);
            }
        }
        if (myBounds ==
              null)
            throw new java.lang.IllegalArgumentException(
              "Composite Operation Must have some source!");
        if (rule.
              getRule(
                ) ==
              org.apache.batik.ext.awt.image.CompositeRule.
                RULE_ARITHMETIC) {
            java.util.List vec =
              new java.util.ArrayList(
              srcs.
                size(
                  ));
            i =
              srcs.
                iterator(
                  );
            while (i.
                     hasNext(
                       )) {
                org.apache.batik.ext.awt.image.rendered.CachableRed cr =
                  (org.apache.batik.ext.awt.image.rendered.CachableRed)
                    i.
                    next(
                      );
                java.awt.Rectangle r =
                  cr.
                  getBounds(
                    );
                if (r.
                      x !=
                      myBounds.
                        x ||
                      r.
                        y !=
                      myBounds.
                        y ||
                      r.
                        width !=
                      myBounds.
                        width ||
                      r.
                        height !=
                      myBounds.
                        height)
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.PadRed(
                        cr,
                        myBounds,
                        org.apache.batik.ext.awt.image.PadMode.
                          ZERO_PAD,
                        null);
                vec.
                  add(
                    cr);
            }
            srcs =
              vec;
        }
        java.awt.image.SampleModel sm =
          fixSampleModel(
            src,
            cm,
            myBounds);
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        int tgX =
          defSz *
          (int)
            java.lang.Math.
            floor(
              myBounds.
                x /
                defSz);
        int tgY =
          defSz *
          (int)
            java.lang.Math.
            floor(
              myBounds.
                y /
                defSz);
        init(
          srcs,
          myBounds,
          cm,
          sm,
          tgX,
          tgY,
          null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        genRect(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int x, int y) { int tx =
                                                           tileGridXOff +
                                                           x *
                                                           tileWidth;
                                                         int ty =
                                                           tileGridYOff +
                                                           y *
                                                           tileHeight;
                                                         java.awt.Point pt =
                                                           new java.awt.Point(
                                                           tx,
                                                           ty);
                                                         java.awt.image.WritableRaster wr =
                                                           java.awt.image.Raster.
                                                           createWritableRaster(
                                                             sm,
                                                             pt);
                                                         genRect(
                                                           wr);
                                                         return wr;
    }
    public void emptyRect(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
          org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          getZeroRecter(
            wr);
        zr.
          zeroRect(
            new java.awt.Rectangle(
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  )));
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        java.awt.Rectangle r =
          wr.
          getBounds(
            );
        int idx =
          0;
        java.util.Iterator i =
          srcs.
          iterator(
            );
        boolean first =
          true;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            if (first) {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (r.
                      x <
                      crR.
                        x ||
                      r.
                        y <
                      crR.
                        y ||
                      r.
                        x +
                      r.
                        width >
                      crR.
                        x +
                      crR.
                        width ||
                      r.
                        y +
                      r.
                        height >
                      crR.
                        y +
                      crR.
                        height)
                    emptyRect(
                      wr);
                cr.
                  copyData(
                    wr);
                if (!cr.
                      getColorModel(
                        ).
                      isAlphaPremultiplied(
                        ))
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      coerceData(
                        wr,
                        cr.
                          getColorModel(
                            ),
                        true);
                first =
                  false;
            }
            else {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (crR.
                      intersects(
                        r)) {
                    java.awt.Rectangle smR =
                      crR.
                      intersection(
                        r);
                    java.awt.image.Raster ras =
                      cr.
                      getData(
                        smR);
                    java.awt.image.WritableRaster smWR =
                      wr.
                      createWritableChild(
                        smR.
                          x,
                        smR.
                          y,
                        smR.
                          width,
                        smR.
                          height,
                        smR.
                          x,
                        smR.
                          y,
                        null);
                    contexts[idx].
                      compose(
                        ras,
                        smWR,
                        smWR);
                }
            }
            idx++;
        }
    }
    public void genRect_OVER(java.awt.image.WritableRaster wr) {
        java.awt.Rectangle r =
          wr.
          getBounds(
            );
        java.awt.image.ColorModel cm =
          getColorModel(
            );
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.Graphics2D g2d =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            bi);
        g2d.
          translate(
            -r.
               x,
            -r.
               y);
        java.util.Iterator i =
          srcs.
          iterator(
            );
        boolean first =
          true;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            if (first) {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (r.
                      x <
                      crR.
                        x ||
                      r.
                        y <
                      crR.
                        y ||
                      r.
                        x +
                      r.
                        width >
                      crR.
                        x +
                      crR.
                        width ||
                      r.
                        y +
                      r.
                        height >
                      crR.
                        y +
                      crR.
                        height)
                    emptyRect(
                      wr);
                cr.
                  copyData(
                    wr);
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    wr,
                    cr.
                      getColorModel(
                        ),
                    cm.
                      isAlphaPremultiplied(
                        ));
                first =
                  false;
            }
            else {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  drawImage(
                    g2d,
                    cr);
            }
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                               java.awt.image.ColorModel cm,
                                                               java.awt.Rectangle bounds) {
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        int tgX =
          defSz *
          (int)
            java.lang.Math.
            floor(
              bounds.
                x /
                defSz);
        int tgY =
          defSz *
          (int)
            java.lang.Math.
            floor(
              bounds.
                y /
                defSz);
        int tw =
          bounds.
            x +
          bounds.
            width -
          tgX;
        int th =
          bounds.
            y +
          bounds.
            height -
          tgY;
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int w =
          sm.
          getWidth(
            );
        if (w <
              defSz)
            w =
              defSz;
        if (w >
              tw)
            w =
              tw;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              th)
            h =
              th;
        if (w <=
              0 ||
              h <=
              0) {
            w =
              1;
            h =
              1;
        }
        return cm.
          createCompatibleSampleModel(
            w,
            h);
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                )) {
            if (!cm.
                  isAlphaPremultiplied(
                    ))
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceColorModel(
                      cm,
                      true);
            return cm;
        }
        int b =
          src.
          getSampleModel(
            ).
          getNumBands(
            ) +
          1;
        if (b >
              4)
            throw new java.lang.IllegalArgumentException(
              "CompositeRed can only handle up to three band images");
        int[] masks =
          new int[4];
        for (int i =
               0;
             i <
               b -
               1;
             i++)
            masks[i] =
              16711680 >>
                8 *
                i;
        masks[3] =
          255 <<
            8 *
            (b -
               1);
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        return new java.awt.image.DirectColorModel(
          cs,
          8 *
            b,
          masks[0],
          masks[1],
          masks[2],
          masks[3],
          true,
          java.awt.image.DataBuffer.
            TYPE_INT);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cfsf7mz9E+H2OyXBV+9iia8Vxf+IofuB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("JY5tW1T+7rGqv/96VM1B7J789qv4kOWRW7493X8vqX3+xWtXHn5R/O39ae3h" +
       "N4330tAVI3Gck4frJ+4vBaEOxC0p90ftQfn3f2LoO7/NUAPz5OFtqcD/3nP4" +
       "kxh6/O4cYuie8v9kqz+LoUfu1ArMZKA8Sf3nMfSW21EDyuJw/JjyHBRD189S" +
       "gv7L/5N0F2Lo6jFdDF3a35wkuQS4A5Li9nLwusclrkZxqGgx8GZ+7nQeeRQj" +
       "D71WjJxIPZ8+lTCWny8fJnfJ+OAjpZdfHLI/8I3mT+0/MNMcZbcruFyhocv7" +
       "b92OEsQn78jtkNcl8t3ffOBn7n3XYTL7wF7g4zF2QrZ33v5rrl4xxxYfIO3+" +
       "1cP/4nv+yYu/Vx5S/z+dzvJ5Vy4AAA==");
}
