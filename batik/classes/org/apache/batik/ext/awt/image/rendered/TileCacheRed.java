package org.apache.batik.ext.awt.image.rendered;
public class TileCacheRed extends org.apache.batik.ext.awt.image.rendered.AbstractTiledRed {
    public TileCacheRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr) {
        super(
          cr,
          null);
    }
    public TileCacheRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                        int tileWidth,
                        int tileHeight) { super();
                                          java.awt.image.ColorModel cm =
                                            cr.
                                            getColorModel(
                                              );
                                          java.awt.Rectangle bounds =
                                            cr.
                                            getBounds(
                                              );
                                          if (tileWidth > bounds.
                                                            width)
                                              tileWidth =
                                                bounds.
                                                  width;
                                          if (tileHeight > bounds.
                                                             height)
                                              tileHeight =
                                                bounds.
                                                  height;
                                          java.awt.image.SampleModel sm =
                                            cm.
                                            createCompatibleSampleModel(
                                              tileWidth,
                                              tileHeight);
                                          init(cr, bounds, cm, sm,
                                               cr.
                                                 getTileGridXOffset(
                                                   ),
                                               cr.
                                                 getTileGridYOffset(
                                                   ),
                                               null); }
    public void genRect(java.awt.image.WritableRaster wr) { org.apache.batik.ext.awt.image.rendered.CachableRed src =
                                                              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                                getSources(
                                                                  ).
                                                                get(
                                                                  0);
                                                            src.
                                                              copyData(
                                                                wr);
    }
    public void flushCache(java.awt.Rectangle rect) {
        int tx0 =
          getXTile(
            rect.
              x);
        int ty0 =
          getYTile(
            rect.
              y);
        int tx1 =
          getXTile(
            rect.
              x +
              rect.
                width -
              1);
        int ty1 =
          getYTile(
            rect.
              y +
              rect.
                height -
              1);
        if (tx0 <
              minTileX)
            tx0 =
              minTileX;
        if (ty0 <
              minTileY)
            ty0 =
              minTileY;
        if (tx1 >=
              minTileX +
              numXTiles)
            tx1 =
              minTileX +
                numXTiles -
                1;
        if (ty1 >=
              minTileY +
              numYTiles)
            ty1 =
              minTileY +
                numYTiles -
                1;
        if (tx1 <
              tx0 ||
              ty1 <
              ty0)
            return;
        org.apache.batik.ext.awt.image.rendered.TileStore store =
          getTileStore(
            );
        for (int y =
               ty0;
             y <=
               ty1;
             y++)
            for (int x =
                   tx0;
                 x <=
                   tx1;
                 x++)
                store.
                  setTile(
                    x,
                    y,
                    null);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FyT2BAc2GAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fTl/aH8997zM0Q/fSqx8ivY/febJP/rEk09t1bh0dBPRAnvkT/3Vf31t95lv" +
       "f+UmK9VJsEHMfhC5mE/cIrDprLmSv0Ky5o1bj9deUnBsae/dOurWPmpnG9wD" +
       "7L/3Pzhr/p5/+OENGZIvWTdx27HxIvzcR+5rvum7+fiDtSMb/UBy4woPDgMH" +
       "Y8uftP9t55HTf7YDnRGhi/L1k4YgWVGGyCLYXQd7xw9wGjny/uhOebstvLK/" +
       "Nr7meNwcmvb4qnXgL/CcUWfP5w/QoJWcAKh+qrxb2y1mv4VtSuXt5ax5/UF6" +
       "/AyA/yA/sYARmuFIVs6nFQI4seTLeyEogBMMMPFl06rtYeXFHDoyZXa32/6D" +
       "7EW2UvyEaBjsyQq8f+cBM9oFJ4j3/+PTX/vgo98CLupBp9aZ+YBnDs3IRtmh" +
       "6lee+9D9r7j27ffnqxmAceF9n6v8MOMq3UrjrBGz5s17qt6XqTrKt4m0FIRM" +
       "vgCpyr622CF9OiFYxtz/hbbhHW/oIgGJ7f3RpZlajsdJYmtcCsettIHgPo52" +
       "hs1+xZ11XIvi2b4RLwpLkW4l7iyhuLpakysq1ahMhEpqIjVvarvtSdUaLwck" +
       "KQhNT5y5kjhprToraWgXjdVSZ93VSFiuKFsaCqOVKFDdqo6DrIClXlio1FO1" +
       "plTVtIgJDWk0L6NrFF2vwd66XJjDkrip8h1lvHCYis3wDZMxtYmk9bAqHfYN" +
       "3Jkqa745FfBC6K7riNxxppZheN2RlDKNgTKmHLrgDG2JQ+KqgrNWieVFFYkS" +
       "k5cZdRFbqWVaXDThxqldnaBwyRSLgioTViANZnij1FqNWDmquWTqcAWz2HG6" +
       "gyXSHFEcaW/oeSo7I5xd2UK/wA1orMAnMeaNRKck0oYaGmO2aDZd1NdDauAo" +
       "qNJA9Gq5QtutxbztFpI+WVcYU6z1QkMstxN7oU/7YSUpNqaGLYj6gjAF1ojX" +
       "pQpRYcJZnHiGQBopOD3UmoGK6nVbGFijDofZPS4atjoutiSFVtsflFZqs5jK" +
       "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" +
       "2hu+jGNyuQOOR9mxyX55x7m78pPr/u0VOMVlL97yMk5syc2KUPnf6eM3HseL" +
       "UPfuFb986P4Xu5TKazQfe8+1ZxXu46Wd69WUbgidC13vZ8FmRbUOscqq+o+/" +
       "eHGEye/kDioUX3rPv9zHv0l/28so6D94TM7jLH+Xee4rndfJv7YDndyvV9xw" +
       "W3h00JWjVYrzvhpGvsMfqVXcf7Qy+Dj4XLlu2Su3qAwej4ITeRRsfX+sWHWs" +
       "unt/Xj84qOZOfCPMi7jgzK/6OYdfukW566mseUcInVmozjC7aLpZaWDtGspB" +
       "jL3z5VTE8o6332gU/LpR8P8To1zaN0qmk+QsLDUfdu0Wlngmaz4YQuc1Kwr0" +
       "/LYq63nfgeJPv6xSYAjdfvjaK6vh33vDtfv2qlj+9LMXzt7z7Piv85uf/evc" +
       "czR0Voss63Bl7NDzac9XNSOX/dy2TublX78VQq9/iSX/EDq795gr8OyWw2+H" +
       "0AO35hBCp/Lvw6M+HkL3vtioEDoJ2sPUnwihV92MGlCC9jDl74XQxeOUYP78" +
       "+zDdp4HvDuhC6PT24TDJ5wB3QJI9ft7bC5b6S70fweZB6EtymLlVyS5JThwF" +
       "x/1AufSTAuUQnj56BAXzf9/YQ6xo+w8cV+XPPNtj3/5C9ePbCzbZktI043KW" +
       "hs5s7/r2Ue/hF+W2x+t097Ef3fnZc6/dQ+g7twIfpN0h2R68+W1Wy/bC/P4p" +
       "/cN7fv+Nv/PsN/NS5f8AzIgL7lcjAAA=");
}
