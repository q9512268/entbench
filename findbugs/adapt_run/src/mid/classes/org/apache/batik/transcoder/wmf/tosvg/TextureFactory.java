package org.apache.batik.transcoder.wmf.tosvg;
public class TextureFactory {
    private static org.apache.batik.transcoder.wmf.tosvg.TextureFactory fac =
      null;
    private java.util.Map textures = new java.util.HashMap(1);
    private static final int SIZE = 10;
    private float scale = 1.0F;
    private TextureFactory(float scale) { super(); }
    public static org.apache.batik.transcoder.wmf.tosvg.TextureFactory getInstance() {
        if (fac ==
              null)
            fac =
              new org.apache.batik.transcoder.wmf.tosvg.TextureFactory(
                1.0F);
        return fac;
    }
    public static org.apache.batik.transcoder.wmf.tosvg.TextureFactory getInstance(float scale) {
        if (fac ==
              null)
            fac =
              new org.apache.batik.transcoder.wmf.tosvg.TextureFactory(
                scale);
        return fac;
    }
    public void reset() { textures.clear(); }
    public java.awt.Paint getTexture(int textureId) { java.lang.Integer _itexture =
                                                        new java.lang.Integer(
                                                        textureId);
                                                      if (textures.
                                                            containsKey(
                                                              _itexture)) {
                                                          java.awt.Paint paint =
                                                            (java.awt.Paint)
                                                              textures.
                                                              get(
                                                                _itexture);
                                                          return paint;
                                                      }
                                                      else {
                                                          java.awt.Paint paint =
                                                            createTexture(
                                                              textureId,
                                                              null,
                                                              null);
                                                          if (paint !=
                                                                null)
                                                              textures.
                                                                put(
                                                                  _itexture,
                                                                  paint);
                                                          return paint;
                                                      }
    }
    public java.awt.Paint getTexture(int textureId,
                                     java.awt.Color foreground) {
        org.apache.batik.transcoder.wmf.tosvg.TextureFactory.ColoredTexture _ctexture =
          new org.apache.batik.transcoder.wmf.tosvg.TextureFactory.ColoredTexture(
          textureId,
          foreground,
          null);
        if (textures.
              containsKey(
                _ctexture)) {
            java.awt.Paint paint =
              (java.awt.Paint)
                textures.
                get(
                  _ctexture);
            return paint;
        }
        else {
            java.awt.Paint paint =
              createTexture(
                textureId,
                foreground,
                null);
            if (paint !=
                  null)
                textures.
                  put(
                    _ctexture,
                    paint);
            return paint;
        }
    }
    public java.awt.Paint getTexture(int textureId,
                                     java.awt.Color foreground,
                                     java.awt.Color background) {
        org.apache.batik.transcoder.wmf.tosvg.TextureFactory.ColoredTexture _ctexture =
          new org.apache.batik.transcoder.wmf.tosvg.TextureFactory.ColoredTexture(
          textureId,
          foreground,
          background);
        if (textures.
              containsKey(
                _ctexture)) {
            java.awt.Paint paint =
              (java.awt.Paint)
                textures.
                get(
                  _ctexture);
            return paint;
        }
        else {
            java.awt.Paint paint =
              createTexture(
                textureId,
                foreground,
                background);
            if (paint !=
                  null)
                textures.
                  put(
                    _ctexture,
                    paint);
            return paint;
        }
    }
    private java.awt.Paint createTexture(int textureId,
                                         java.awt.Color foreground,
                                         java.awt.Color background) {
        java.awt.image.BufferedImage img =
          new java.awt.image.BufferedImage(
          SIZE,
          SIZE,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
        java.awt.Graphics2D g2d =
          img.
          createGraphics(
            );
        java.awt.geom.Rectangle2D rec =
          new java.awt.geom.Rectangle2D.Float(
          0,
          0,
          SIZE,
          SIZE);
        java.awt.Paint paint =
          null;
        boolean ok =
          false;
        if (background !=
              null) {
            g2d.
              setColor(
                background);
            g2d.
              fillRect(
                0,
                0,
                SIZE,
                SIZE);
        }
        if (foreground ==
              null)
            g2d.
              setColor(
                java.awt.Color.
                  black);
        else
            g2d.
              setColor(
                foreground);
        if (textureId ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                HS_VERTICAL) {
            for (int i =
                   0;
                 i <
                   5;
                 i++) {
                g2d.
                  drawLine(
                    i *
                      10,
                    0,
                    i *
                      10,
                    SIZE);
            }
            ok =
              true;
        }
        else
            if (textureId ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    HS_HORIZONTAL) {
                for (int i =
                       0;
                     i <
                       5;
                     i++) {
                    g2d.
                      drawLine(
                        0,
                        i *
                          10,
                        SIZE,
                        i *
                          10);
                }
                ok =
                  true;
            }
            else
                if (textureId ==
                      org.apache.batik.transcoder.wmf.WMFConstants.
                        HS_BDIAGONAL) {
                    for (int i =
                           0;
                         i <
                           5;
                         i++) {
                        g2d.
                          drawLine(
                            0,
                            i *
                              10,
                            i *
                              10,
                            0);
                    }
                    ok =
                      true;
                }
                else
                    if (textureId ==
                          org.apache.batik.transcoder.wmf.WMFConstants.
                            HS_FDIAGONAL) {
                        for (int i =
                               0;
                             i <
                               5;
                             i++) {
                            g2d.
                              drawLine(
                                0,
                                i *
                                  10,
                                SIZE -
                                  i *
                                  10,
                                SIZE);
                        }
                        ok =
                          true;
                    }
                    else
                        if (textureId ==
                              org.apache.batik.transcoder.wmf.WMFConstants.
                                HS_DIAGCROSS) {
                            for (int i =
                                   0;
                                 i <
                                   5;
                                 i++) {
                                g2d.
                                  drawLine(
                                    0,
                                    i *
                                      10,
                                    i *
                                      10,
                                    0);
                                g2d.
                                  drawLine(
                                    0,
                                    i *
                                      10,
                                    SIZE -
                                      i *
                                      10,
                                    SIZE);
                            }
                            ok =
                              true;
                        }
                        else
                            if (textureId ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    HS_CROSS) {
                                for (int i =
                                       0;
                                     i <
                                       5;
                                     i++) {
                                    g2d.
                                      drawLine(
                                        i *
                                          10,
                                        0,
                                        i *
                                          10,
                                        SIZE);
                                    g2d.
                                      drawLine(
                                        0,
                                        i *
                                          10,
                                        SIZE,
                                        i *
                                          10);
                                }
                                ok =
                                  true;
                            }
        img.
          flush(
            );
        if (ok)
            paint =
              new java.awt.TexturePaint(
                img,
                rec);
        return paint;
    }
    private class ColoredTexture {
        final int textureId;
        final java.awt.Color foreground;
        final java.awt.Color background;
        ColoredTexture(int textureId, java.awt.Color foreground,
                       java.awt.Color background) {
            super(
              );
            this.
              textureId =
              textureId;
            this.
              foreground =
              foreground;
            this.
              background =
              background;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "hmEP2W3nuOcNg/eib7Fb4r+OLb11lxYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Z79enLb8L1OSJYn+IAAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iqXojBENwwTTKEbDBV9IieFyhqYtZtjGtjBK2E7sVJdrrLeiN9PR0s78GZPp" +
       "dW4tbEWsE0ZjFOPE7TBOPLk3Q9CoZ8nrag0xPNPs2lG41tjaRGm22SrWFGJY" +
       "mNXcqlOeSwwW9+MpbBvYpuvMg2QiJct6zOPrRp+JCLTSGkpoebnpsrMOPwiR" +
       "NNz2vGAAVn0dI1ku2hs06WFbY7M0tzCORrxSZwZZhNMrPVQGbdKOa4iAK+ac" +
       "wKyhOe/W5KDUD5zmds7IK5el2To2byBI13KI4dbzEV0nyqKcDeqroE4qmEdq" +
       "tOIKHQOJB+uxTq9XZKqtsu4acbrJmtRBxKJZdaWu6wN1utTQmDZ4c6s2Wyox" +
       "YkqNRGF69ZAozQkX4fpGxRjwrUE2mSJVPV1UzbqCu/MWXo9bxnTri+U50ZyQ" +
       "Y3bbnbVma9US29XaBrYXc9ZdAzGgS7brKf1ydc30ZDeyMF6MDW6gMjbfMWxY" +
       "sulgLVGLzVbF0HilT2pBRzNSREPEbdxf95pivCbKdpxWlnGD1E2iYY/DdGBt" +
       "hYDVBu0mAjvyYDYmsD6JLEGgpWwtdVAdCWlvIyirzRKmukOSa7a4llGpDJTM" +
       "0NuTUiL3Y669GI41brWdlUijXFeItpnMqk1G10QVqQ1Koucp9WDSxzCZM7AK" +
       "XF/DiLAUqo2KZVnUxCmjwwANMAnNuiOvbFNBpetJUcDDsI2bsu1U8HknG89g" +
       "h1SY8bLVWvg+RSW9nqxJvVGlRZHpeNAie9OxUkIQbkBXGF9TcaPUwJAaYbSQ" +
       "UqPDjbqwuMg27UGo435lwfenluisRvXJmqTkXjz2Sb/vENuub1AVeyOS9VGp" +
       "hq7IsC+MGzHHoH5Fw2ors4vV/SU8IINOC9Etqzvl7HVJFNWFMqeHK3+UavNV" +
       "VakIWJk2AIausE6HQUQjhFXu98mu5PK92FDmijq1mCoVZ5VWXWw2le24TMST" +
       "tV1WW6vetDwNM79OguWouymrtanSkV2uPdxWgSroES0s4W0Z43BAj6UttrLX" +
       "I6ZijakR5bk2K5eQgen1J0i5K7FbpunYsaeOqHbKopKYEULDArFcvGblDtfQ" +
       "3I4S+5Y5JLuL9UJJ6ZQwDMGulVFb2eqeGa7hzSxtoe7GySzR8tjlOBYDu4o4" +
       "7bStc6NQ45nQjngQFSqwDia7Aa+hiWwjHWwIJ0xmsO4wxfMthg98IN92+Mev" +
       "bTvk0WJ75+TqgWGhecH2Nex4pBdsZKX7c6zidwU6d4B9amPs1DY9lB8kvO1e" +
       "dwyKE5PPfeSFF6Xxz1SOtz3REHogdL33WnIsW+d2/J+990YqXVyx2G+7f/Ej" +
       "f/EE+wPah17DGexT5+g83+W/ol/6Uu/7xH9yAN13sgl/x+WPs42eO7v1ft2X" +
       "w8h32DMb8G874ezTOcfeA57qEWer57cc99K8++77Ti92KnHBEdJPX1D2L/Pk" +
       "X4TQg6ocHsM4p0SfebVts9N9FhmfvhPj+44wvu91xHhpr7C1osJLFwD9fJ78" +
       "7IVAf+67AJqf9EKPg6d9BLT9GoAe2dyryfHXLij7t3nySyF02ZcDObzrjmjs" +
       "6tIe7C9/F2ALv/AW8JBHYMnXB+wpgWpFhS9egPhLefIfQ+g6EOjRnY/jve3d" +
       "djSfhIcMrx/dcCtA/8brAXp5BHr5+oA+2Ou6dicA3LVcv2j3Xy/gxe/nyX8+" +
       "w4s858t75F95PZBrR8i11wf5ffsZrrgx9XtFUlT9owvA/kmefPUisF/7LsA+" +
       "lmfmB0HJEdjktYJ992sF+78uAPtKnvxFCD0s+jIfynfH+43XgjcF6nX2jlR+" +
       "3+PNd9zf3N05FD//4o1rj7/I/bfimtDJvcAHhtA1JbKs0wfNp96veL6s6AWA" +
       "B3bHzl7x9zch9K7v6BYXcGTFf0H9t3aNvw3m31dpHAI228rpRn8bQm+5oBHQ" +
       "ov3HqXb58dvN8+0AUcX/6Xr3gx729ULoyu7ldJWrgCpQJX+95t3l+G130p9e" +
       "OhtInQj3sVcT7qnY651nIqbi5u5xdBMxRyfcX3iRGv3oK42f2d2fEi1+W0SN" +
       "14bQ1d1VrpMI6el79nbc15X+M99+5Bcf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("eNdxNPfIjuC9hZyi7am731UibC8sbhdtf+3xX37/z7741eJ8+P8BIotAylIt" +
       "AAA=");
}
