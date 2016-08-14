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
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "vsi5v8kf2e1b/wVv0miA7hYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "UUM8bNTgakWQbClxDatHYO3WRpQN1hKjSo9nVz7J9AKFEQdhqTX3CVqQtCho" +
           "elY4iEHiN+xxU1NFjdnEdS5xEz5BQp3Da0iby/Chse7F7Trl9AiLmGCK1GpL" +
           "XneELFKrrrc001FrxHxIpDw7TqXhpMV4k2GsIl1ZX/klnnS3ram8rUc6Jo/l" +
           "zniNL6VImktYlilpZ1hnBo2+n0wNuhpz2DY1RmaXiUbiRJqXKVy2aXPST7hU" +
           "CsiK5c9rZNdop2V/vjZqSbO0ZuqrOsMMKMPjS31etZi+k1Ezx6wtB1Wppfvb" +
           "aalJqV5Sr1OSGsOUaQrMNI5CRO92V15f6ZGNsUnXDZvVtVWdqARNIvZtdNGI" +
           "6VBkhZLbH3vsLJbXtQ5aiqJpEg1MZ7IZSS4t0m17MR829cFyyiWoycTYCta7" +
           "Cdrs0EPLUAWfrmR6yMai3hgjCCs3qFT0s4QIpfZssBqVRn0chkumCsd+tVEt" +
           "9xd0WJJGOOklqN4dzfpqQqqVuO80si2Lo4M6oiXLlERrWr/E17F0GtSjeLNs" +
           "VZZlemWY467DVZqtZog27KqSmEpUXwL3V1NvFrbL1Vi1hXbTp0yp0VmthSTZ" +
           "zP31jBXcnkSuURWOZESHx0N92dCo5jDe1Jwp45shpdBqUvVqmh4jBlJR09Gk" +
           "P28vmGDoqyOVSXpBzEW+t3IdDrW5Vl0p6TO9tlY6NNoRZ02Pr2llZLOqMiU8" +
           "Vmy1R4xmlc544vWaDFpbziZIlytN5vC6j6RgqlZHzS4xjNGK6w83usYkG3RZ" +
           "LXeHiFXN4jRuztmMbs8ZKeCpOtLE3bSjwFVcVDJ/gRNLFnjQlPny3N5slx3S" +
           "T2Z9jG11QmMqaqUxvOBtncEMrBN3aksyG60SnWNbuk3iU2ODoNvAwbYlpj/A" +
           "8LGWVWV5oVY9oVrjtl29sdnAEu36tSYZTIMW3y23V6VlXYSRRktb+gjcCgfL" +
           "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" +
           "OjvYFiEAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uQ4AanseBvMlIAU9NgHN5+EP/fB+SGTXQHKzhFq5A/x+KL21fLp6sXORRfh2" +
       "wmxv/d8jV/nIH/7lHUYoCfku/nauvAS9/Oknuz/4jbL8CTMWpZ/K75y/QKh7" +
       "UrbxK96fX37XlX9zuXJVqtxUD+PoueymBd9IIHaMj4JrEGufeX82DtwHPc8f" +
       "M//bzzv8qWbPc/KJo4H7Qrq4v36Oht90RErvPSSo956n4UuV8oYuizxTpreK" +
       "5PvLPrlc3L43qVyJy2i9rB1JKveBuLjk7z2JF+kHioTZ9+cP3bPvibMTxHPg" +
       "evZQs2fvodnk7ppdKjU7Uuhasg8I4jMj+qwPTeWsDHdvq/9s8vWvfGb3hZf3" +
       "A1aRQTxXqd5r5XTn4q2Ye99zQfxwElP/ef/9r/zJH81/9PLhOH/oLPwbF8Ev" +
       "Rd+cVB45GX9g7BWZP3LO6tPv3OrfexSBPnfY7HN3WP3S8SRauOgBDZZBKz16" +
       "/A9//rPf+vBHW5eLaeGBTeHKwAo3T+S4tFi+/dTLn3zHQy9+/WfLeRPUfL2o" +
       "9Pbde/C+sgeLZFgQpeXL7lF33s/TUq+Ur5U5e4BN4HhgVXYO/Ydep889Da7q" +
       "IfrqPXzO+0587oFYlfcrAPicSv5rqrRHdQkEFQ80DrCDEmVyDzOB0RemimuV" +
       "I25YJMaRCk/YrnrraGabg9UzIMBbtosd+c6p/tkvOc8pinzHigKnePSkMjYA" +
       "q9ef/W+f+N2/8+6vAY9gjjyikFaAneY//Y+wrxcPP3FB1+d34nmywMOX6xBW" +
       "jpNhGeDo2jGkc95wvxt8F5CSm5+jkJhuH/2xNakLt+d1Y1F1txDK1Dptp902" +
       "rbaP+C4NLcd5h+iw2IqYdnK7KajseLPxZswmqddxDHMYYR3tXCKYthQ5YGXb" +
       "ZuqdYKqQzYWpNBta5o8DKZmNkbUyX4SLtW+kQYBAliRHog9zdbwKO0bYC3Yx" +
       "pCWYDfvweAihOKZBORIOM5jP3ImO6MPmcDvWBmnVNWOHFydBfWcIGbcltHmP" +
       "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" +
       "6rhzH3+tzj0Ve737TMRUnuw9im7S8eHX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8S+8xHA//mrzF/dnr1RX3pVR4zW2cnV/DOw4QnrmnrUd1XWFevbbj/7ag+85" +
       "iuYe3St8MkJO6fb03c859TywtC9OJu1+84lf/8AvvfTV8tvy/wP0f9PPci0A" +
       "AA==");
}
