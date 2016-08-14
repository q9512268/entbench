package org.apache.batik.transcoder.image;
public abstract class ImageTranscoder extends org.apache.batik.transcoder.SVGAbstractTranscoder implements ent.runtime.ENT_Attributable {
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
              ent.runtime.ENT_Snapshot.
                snapshot(
                  d_renderer,
                  org.apache.batik.apps.rasterizer.EntMode.
                    LOW_MODE,
                  ent.runtime.ENT_Runtime.
                    getObjMode(
                      this,
                      0),
                  true);
        }
        catch (java.lang.RuntimeException e) {
            if (recover) {
                width =
                  512;
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
              ent.runtime.ENT_Snapshot.
                forceSnapshot(
                  d_renderer,
                  org.apache.batik.apps.rasterizer.EntMode.
                    LOW_MODE,
                  ent.runtime.ENT_Runtime.
                    getObjMode(
                      this,
                      0),
                  true);
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
                 ent.runtime.ENT_Runtime.
                 putObj(
                   new org.apache.batik.gvt.renderer.StaticRenderer(
                     ),
                   new java.lang.Integer[] { org.apache.batik.apps.rasterizer.EntMode.
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwcxRWfOyeO7cQfceIk5MNJHBOUBO4IkFJkCjgXO3Fy" +
       "sU+2cYpbuIz35nyb7O1udufsi2laoKpIqUqBhq8K0n+MoCkQRIsKKlRpUQsU" +
       "VImvQqkIFa1UWkpFVJVWpS19b2b39uM+QiToSTu3N/PmzXtv3vu9N3MPvkfm" +
       "2hbpZDqP8YMms2N9Ok9Ry2aZhEZtexT60sqddfRv17wzeEmU1I+Tlhy1dyvU" +
       "Zv0q0zL2OFml6janusLsQcYyOCNlMZtZU5Srhj5OOlR7IG9qqqLy3UaGIcEY" +
       "tZJkIeXcUicKnA04DDhZlQRJ4kKSeG94uCdJFiiGedAjX+YjT/hGkDLvrWVz" +
       "0pbcR6dovMBVLZ5Ubd5TtMgm09AOTmoGj7Eij+3Ttjgm2JncUmaCrkdaP/jw" +
       "llybMMEiqusGF+rZw8w2tCmWSZJWr7dPY3n7APkyqUuS+T5iTrqT7qJxWDQO" +
       "i7raelQgfTPTC/mEIdThLqd6U0GBOFkbZGJSi+YdNikhM3Bo4I7uYjJou6ak" +
       "rdSyTMXbN8WP3HlN26N1pHWctKr6CIqjgBAcFhkHg7L8BLPs3kyGZcbJQh02" +
       "e4RZKtXUGWen2211Uqe8ANvvmgU7CyazxJqerWAfQTeroHDDKqmXFQ7l/Jqb" +
       "1egk6LrE01Vq2I/9oGCTCoJZWQp+50yZs1/VM5ysDs8o6di9Cwhg6rw84zmj" +
       "tNQcnUIHaZcuolF9Mj4CrqdPAulcAxzQ4mR5VaZoa5Mq++kkS6NHhuhScgio" +
       "GoUhcAonHWEywQl2aXlol3z7897gpTdfq+/QoyQCMmeYoqH882FSZ2jSMMsy" +
       "i0EcyIkLNibvoEueOhwlBIg7QsSS5kdfOnXFuZ0nnpU0KyrQDE3sYwpPK7MT" +
       "LS+uTGy4pA7FaDANW8XND2guoizljPQUTUCYJSWOOBhzB08M/+Kq646xd6Ok" +
       "aYDUK4ZWyIMfLVSMvKlqzNrOdGZRzjIDpJHpmYQYHyDz4D2p6kz2DmWzNuMD" +
       "ZI4muuoN8RtMlAUWaKImeFf1rOG+m5TnxHvRJIS0wUM64NlO5Ed8c5KJ54w8" +
       "i1OF6qpuxFOWgfrbcUCcCbBtLj4BXr8/bhsFC1wwbliTcQp+kGPOALeobisA" +
       "QlZczYMHxAewHS31xtDbzP/TOkXUd9F0JAJbsTIMBBrE0A5DA9q0cqSwte/U" +
       "w+nnpZNhYDiW4mQzLB2TS8fE0jFv6ZhYOhZamkQiYsXFKILceNi2/QAAgMAL" +
       "NoxcvXPv4a468Dhzeg7YHEm7Apko4aGEC+1p5Xh788zak5ufjpI5SdJOFV6g" +
       "GiaWXmsSIEvZ70T1ggnIUV6qWONLFZjjLENhGUCqainD4dJgTDEL+zlZ7OPg" +
       "JjIM2Xj1NFJRfnLirunrx75yfpREg9kBl5wLwIbTU4jpJezuDqNCJb6tN77z" +
       "wfE7DhkePgTSjZsly2aiDl1hnwibJ61sXEMfSz91qFuYvRHwm1OIN4DGzvAa" +
       "AfjpcaEcdWkAhbOGlacaDrk2buI5y5j2eoSzLhTvi8EtWjAeV8GTdAJUfOPo" +
       "EhPbpdK50c9CWohU8bkR897Xf/WnC4W53azS6isHRhjv8SEZMmsXmLXQc9tR" +
       "izGge/Ou1Ldvf+/GLwifBYp1lRbsxjYBCAZbCGb+2rMHfvPWydlXop6fc9Jo" +
       "WgaHMGeZYklPHCLNNfSEBdd7IgEYasABHaf7Sh1cVM2qdEJjGFv/bj1782N/" +
       "ublNuoIGPa4nnXt6Bl7/WVvJdc9f849OwSaiYDL2zOaRSYRf5HHutSx6EOUo" +
       "Xv/SqrufofdCrgB8ttUZJiCXCDMQsW9bhP7ni/ai0NjF2Jxt+/0/GGK+oimt" +
       "3PLK+81j7//klJA2WHX5t3s3NXukh2Gzvgjsl4bxaQe1c0B30YnBL7ZpJz4E" +
       "juPAUQH8tYcsALZiwDkc6rnz3vjp00v2vlhHov2kSTNopp+KOCON4ODMzgHE" +
       "Fs3Lr5CbO93g5p4iKVO+rAMNvLry1vXlTS6MPfP40h9eev/Rk8LRTMljhZgf" +
       "RdQPAKuo3b3YPvbyxa/ef+sd0zL7b6gOaKF5y/41pE3c8PY/y0wuoKxCZRKa" +
       "Px5/8J7licveFfM9TMHZ3cXyTAW47M294Fj+79Gu+p9Hybxx0qY4tfIY1QoY" +
       "qeNQH9puAQ31dGA8WOvJwqanhJkrw3jmWzaMZl6GhHekxvfmEIAtwy08C+Le" +
       "iWvyURjAIkS8DIgp54h2Izbnie2r41D6FybgBAUvtqjKOYih6lQLocdSl3mF" +
       "RSCB7eq7Kr21N7Fr+/DQlYPb0omh5NCwYLCMk/NrZXc3pUNNvAPKbrt7Fzso" +
       "QRfbz2KzU4rSU9W/E0F7rAB7nCNJI+ur2GOsij3wdTc2g9gMlRtBcqzAmZMV" +
       "aIT+oeFEX3p0uHdwJNU73Dc4mt6zY2C0D0mGQ3rtqaFXsbJ8USEfJw10AnIt" +
       "YIAnoPi0hotNP8Z7UUsQmlZVOw+Is8zsDUeOZobu2yzjtj1YY/fBEfKhX//n" +
       "hdhdv3uuQjnXyA3zPI1NMc23Jl4GrAogxW5xVPLC7s2W237/RPfk1jOpvrCv" +
       "8zT1Ff5eDUpsrA4+YVGeueHPy0cvy+09g0JqdcicYZbf2/3gc9vXK7dFxblQ" +
       "4kHZeTI4qSeIAk0WgwOwPhrAgnXBYmYLPFc5DrCncjEjHAubTeX1wZ4qU0OZ" +
       "tE4GixvgizHApy9UYhkjH9tmKIU8c64WYLBN5BaEw5g8+roD534cWGDWUIGb" +
       "BS5kPxASI+LU9g7D+Mdj2FdUmImbKXgKsNHQZ10Cu2aaSllqHoq5KecAHD/U" +
       "/tb+e955SIZJOCeFiNnhIzd9FLv5iAwZeaWwruxU758jrxWEoG1ytz6CTwSe" +
       "/+IjwBg++A2ZJ+GcbdeUDreYrC2ytpZYYon+Px4/9OMHDt0YdcojEGzOlKFm" +
       "PLDKnw6EaxcZ2NFriv5cye26cewCeGYdt5s9c4+tNrVG7fetGmO3YnMTJy2K" +
       "xcCAw0wHj2GW62KbylxscorHLIdKHlIDc4TtvvEp2E5EexqeRx0DPHrmtqs2" +
       "NWSfqFPpOTZYKQKaTnPnZL61kMVDWUYoXzJUiGgEAl9jKbXINLy2YpkRmjc1" +
       "hvCuCUmP1tiUWWzu5qQDDniKvASAExBgzJ6cygUWXucZ+zufgrG7cOw8eN5w" +
       "LPZGDWNXztnY7A2VE4tqcKyyB4FrDLTeSAEqgRDOXJDaqxzuTv1BgtJZFSZI" +
       "uo4H4t8ce23fCyLLNWBaLeUWX0qF9Os7PLdhc71U5JDv/auc1KkO6vuxGY7O" +
       "wfXl0tu+3vrkLe11/ZDrB0hDQVcPFNhAJpjv5tmFCZ9A3iWnl/0caRADOYls" +
       "BLjDjh+I9pEaHvUkNsc4mS/DXLgudn3X86Pvfwp+JOq0IXjednb97U/Mj6px" +
       "rOxHQldspsSKz1ZOrPhzRhD8EpufcdI0bak+c/nC7ulPwlxFOE+HLvrweLqs" +
       "7P8FeSeuPHy0tWHp0StfExVj6d56AThztqBp/gOU773etFhWFWotkMcp6TUv" +
       "cbL2tPeQcDpSSzj3opz4KpT+NSaC1bwf/nmvQ3EUngf8xbef7rfAwaODg5p8" +
       "8ZOchOgDEnx9y3QxuOat6sjY9l7nDOEZuxgJHhJKu9txut31nSvWBYon8Q+S" +
       "G/4F+R9SWjl+dOfgtac+c5+8OVM0OjODXOZD0MtLvFJZvbYqN5dX/Y4NH7Y8" +
       "0ni2W7sslAJ7kbTCF/i9cFQ2zQootbIcpeAsIW6t0sor91/98m3LZjujZP4A" +
       "OADk96K4Bdh2UB9mypQ1TppVu6+o2hy4qFQLQFoL+iXFylcI7OjZXOrFC1FO" +
       "usrrwPJr5CbNmGbWVqOgZxxQnO/1BP5zcny9qWCaoQlejw/VH5c4imYCHP28" +
       "Ka7SxKVCk7CjtFiAqg5WDndHoDuvZsLdUagmc+pkLtCP9SusdbkpYx+bv2Lz" +
       "hPhZ/B9hFIoQPx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "//yd//QHfvblPyo34/4fqB/eB6IpAAA=");
}
