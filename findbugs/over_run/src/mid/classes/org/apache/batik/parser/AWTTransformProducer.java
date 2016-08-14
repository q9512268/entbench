package org.apache.batik.parser;
public class AWTTransformProducer implements org.apache.batik.parser.TransformListHandler {
    protected java.awt.geom.AffineTransform affineTransform;
    public static java.awt.geom.AffineTransform createAffineTransform(java.io.Reader r)
          throws org.apache.batik.parser.ParseException { org.apache.batik.parser.TransformListParser p =
                                                            new org.apache.batik.parser.TransformListParser(
                                                            );
                                                          org.apache.batik.parser.AWTTransformProducer th =
                                                            new org.apache.batik.parser.AWTTransformProducer(
                                                            );
                                                          p.
                                                            setTransformListHandler(
                                                              th);
                                                          p.
                                                            parse(
                                                              r);
                                                          return th.
                                                            getAffineTransform(
                                                              );
    }
    public static java.awt.geom.AffineTransform createAffineTransform(java.lang.String s)
          throws org.apache.batik.parser.ParseException {
        org.apache.batik.parser.TransformListParser p =
          new org.apache.batik.parser.TransformListParser(
          );
        org.apache.batik.parser.AWTTransformProducer th =
          new org.apache.batik.parser.AWTTransformProducer(
          );
        p.
          setTransformListHandler(
            th);
        p.
          parse(
            s);
        return th.
          getAffineTransform(
            );
    }
    public java.awt.geom.AffineTransform getAffineTransform() {
        return affineTransform;
    }
    public void startTransformList() throws org.apache.batik.parser.ParseException {
        affineTransform =
          new java.awt.geom.AffineTransform(
            );
    }
    public void matrix(float a, float b, float c,
                       float d,
                       float e,
                       float f) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            new java.awt.geom.AffineTransform(
              a,
              b,
              c,
              d,
              e,
              f));
    }
    public void rotate(float theta) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getRotateInstance(
                java.lang.Math.
                  toRadians(
                    theta)));
    }
    public void rotate(float theta, float cx,
                       float cy) throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getRotateInstance(
            java.lang.Math.
              toRadians(
                theta),
            cx,
            cy);
        affineTransform.
          concatenate(
            at);
    }
    public void translate(float tx) throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            tx,
            0);
        affineTransform.
          concatenate(
            at);
    }
    public void translate(float tx, float ty)
          throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            tx,
            ty);
        affineTransform.
          concatenate(
            at);
    }
    public void scale(float sx) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getScaleInstance(
                sx,
                sx));
    }
    public void scale(float sx, float sy)
          throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getScaleInstance(
                sx,
                sy));
    }
    public void skewX(float skx) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getShearInstance(
                java.lang.Math.
                  tan(
                    java.lang.Math.
                      toRadians(
                        skx)),
                0));
    }
    public void skewY(float sky) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getShearInstance(
                0,
                java.lang.Math.
                  tan(
                    java.lang.Math.
                      toRadians(
                        sky))));
    }
    public void endTransformList() throws org.apache.batik.parser.ParseException {
        
    }
    public AWTTransformProducer() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "w1Av/vHg/wAT+DajfyQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Q8SasGhv8ZDLUpHy41gd8YsKKG9AWeWNO1LFm1hEI2xHjTasz7Vk5CbtshJ3" +
       "1dZ8PJGzykDxYGQMU6vVpsXOAl9N2vWQW6Hium0hA2E9jFEy8xjcUlBVmWx7" +
       "22CjsQbWbJQ6QTPpjhEV5ra6SGO4MO9htLhO/Y5fLXVUci7a0hLHfKSpiuHQ" +
       "m4ep1O159pKSApA+FE83e16nWZfDjBqXDckYLAYhqGAUSy93RRqlXdwvt/qI" +
       "ICp1IcO4MCaVmkCug3rPDiWyMg9FM5tw6ngx7A59YTEbtGSaWvG6K4UUxlOE" +
       "CQ+Hk2paEZtMyYvCrctHoYmSXkdAmpFENvvRnMjqET8ap+6E0N1xzei3omon" +
       "m4qGJNY3Apm0Fm4laVbVFd9WSzqtDHVE61GWJI4VoYmQ+BarB7GOtVZbPFEI" +
       "UNFZ6apvbbp2r7RZho16zQsSsRZFcGWbVObECHf7KIovWLg03zaG6DBK8PE0" +
       "SB0DSaXq0GnKjSHeU6LqIOuDmp7r2TzOCN2oDselaD5S43K/WvJEZD6dG23R" +
       "pZREY1csqMvIWjSvautNXFvgbX9b8yq615QtpYGm5lBr6IhLmIvaeul6Ccmg" +
       "1LqkxmZWc/kJk+E+4k/dtNaG0ZrXoGekRoXT8VIksyxiFFHJyoZSW2BCqqqt" +
       "RViX3J6MjIVS2yzpy04mblpamCzjaReFt2UTPAiSqC/MZF6tcuKy1VuUusFw" +
       "ytCkTbEjpM7hzoZpYrXeZL4WAi/h03BGl2ukGitwOjOzVntMZFNlsDEbszrF" +
       "JkumQ43TWNwuWl5L6Phlvex0JJolloPJsilW9GaH6S2ckZK6cBt2cNdgxAZb" +
       "5QYMP0GaxMAeRWaAc5VZ1ulk6lSvjcQRWbfwteZ0LKZBi6EW8+t2uxcZdQK2" +
       "uVGJm2xLetdq4Lpsz0boitmMYFCt6PB8HNjbUq/SVrUq4eICZtRDJJ3UQtqk" +
       "N/NZcxgwA6w7WgRRNBEkAG6sl92ezpIkC7stvTlG6irPmqYNV9Wq2lVX2Ril" +
       "CbJKsghKdC03tTAX4aZp1wphw9FBULmcTtH1YeRO0G6i6DMCxF22XJuNFbsx" +
       "5mba2wQNdSqg/KAWekOK3VAoRrJku5CHzLlksFmiVDuVF6qTNBVXG3bYTb1q" +
       "b6qGpMcuLells7NKJ0amCYTgeaRrxpKTjJU2lcosPdx05mOElUdimHFa1q57" +
       "Gr6uuS5r4w1p0YilkQDPTQ0P+iPUqo7XA3ljmoMSgo55GeY6kryZBVK30ZLG" +
       "Uo81bGnLdFBjkTIKOZtRzngTh02+quNwqz7uTeso16g5PtOVsoyReEEZNwYK" +
       "zxDjoN8I2imPdErwXJ27czZSkjARHLa/RhB1ovZrBByU2sh0mQVjE/W39gp2" +
       "sbarl6xgaFfgZthHA01RJzI5nW1X9IIwK8FMsdiWWnPRUTMsCc46dgM2qjXF" +
       "UXVQ67h0E91aiFXVsSHmuE5vXorq6JZBm2FzSRsbpNQaOq2hAnfaAhG0eeBA" +
       "J40ScsU2DKdDD8vyoCZ7VaI3bHLTaW3ZmUexUlqawoyO0QT8Yeb8YNAzUVCs" +
       "mcF4Y6swyHeVkTaVV0Y3XG/qrQUS+uhamnBsF6mD94IWtpGTBtzte5xrjBNR" +
       "5JxFb1ZF+CRDxNJ0FQ62i5gM5B5rTqf91UhpsOXtFEF1YhvHaExKXssMZ7I1" +
       "nuGVeJBhPCghm9zaTpNhYxvEaQVLYPCyBKfYtNSRV8vNGLy8v+c9+Wv98rXt" +
       "rNxfbCIdf8Rc2WjeMX4NOwq7ridy8vbjHbrid+FVdv9P7ZDuHW1YXfeTz/Fu" +
       "W74pTcmuamtBvrXyyPU+aBbbKh//wIsvq+wnKvuH29FyBN0def4ztpZo9qn5" +
       "7wOS3nX9LSSm+J57sk36hQ987eHp9xnvew0fgh47p+d5kT/LfOrXuu9Q/s0+" +
       "dNvxpulVX5rPDnr27FbpPYEWxYE7PbNh+sixO57MrY+C6+lDdzx97Y8x1wyd" +
       "/ZPQ2UXNuS3/vbNe3O0Umt4Bp8n5Xnve/KOvPuQd13N8cY6AyBTNzy1ciPpA" +
       "TjYR9BYl0ORIu8Z2LHkSt9sb7YSd3rUvGpKrbdY8tFnz1tusWGsFwwvXZ/jn" +
       "BcOHcvKv/pG4f+ImcH933vgMuKhD3NRrwF0o/M5rQj79Zeg/vErfR3Py4Qh6" +
       "QNeiV0f50k2gfEPeeBlc7CFK9taj/I838unP5OSnAFSwpoPoTJYrBv3Aqdz7" +
       "vgi6PfFM9QT+T98sfBpc80P481sD/0LBcOFa2t+xtD25+JD5X65FCnGfu5HF" +
       "/ntOPhtBFxw5Csyi6ZMnFvn5m7VI/h3pyqFFrtwai5yCsMP4v2+E8fM5+V8A" +
       "Y5A/WbRzGF+5WYx5StMPMeq3BuNtJyXGeY/+xo3Q/lZOvng9tF+6FR71D9H6" +
       "r5NHf/9GGL+ck9/Jy498idtXw/zdm4X5TMG6+2W3Bub+yYPslD+/eiOsX8vJ" +
       "H78K1j+5Wax5Kfn+Q6zvf51c+pc3gvntnPwFyGqhItvnIX7zZiHm5dnzhxCf" +
       "fx3duQfdAOdeMeA718H5dzeL83FwvXCI84XXx5V7994IYn6QZO/OHKKlpcJZ" +
       "iHt33QqILx1CfOl1gvjQjSA+nJM3HUIUz0F8881CzCvllw8hvnxrIJ4qo/Yu" +
       "3wjdO3LyWARd0lz1TBF1DujjrwVoFkFvvtZRw/ys1ENXHXfeHdFVPv3yxbse" +
       "fHn2O8Vpu+NjtHfT0F3L2LZPH205dX/BD7Tlrpa5e3fQxS9gPRNBD17nxSg/" +
       "ilbc5GrvvXvHXwYWOM8PXF78Pc1Xi6B7TviAqN3NaZZGBN0GWPJb1C9Mc/Y8" +
       "ye6ET7Z7gXvodGgUeeGBGxn6eMjpw3j5m3dx3PzoLTneHTi/onzm5f7wh7/V" +
       "+MTuMKBiy9ttLuUuGrpzdy6xEJq/aT9xXWlHsi5QT3/nvs/e/fajXYH7dgqf" +
       "hOkp3R679mk7wvGj4nzc9r89+J+/9z+9/OXieMv/B4KmwDkHMAAA");
}
