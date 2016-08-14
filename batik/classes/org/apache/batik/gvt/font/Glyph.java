package org.apache.batik.gvt.font;
public class Glyph {
    private java.lang.String unicode;
    private java.util.Vector names;
    private java.lang.String orientation;
    private java.lang.String arabicForm;
    private java.lang.String lang;
    private java.awt.geom.Point2D horizOrigin;
    private java.awt.geom.Point2D vertOrigin;
    private float horizAdvX;
    private float vertAdvY;
    private int glyphCode;
    private java.awt.geom.AffineTransform transform;
    private java.awt.geom.Point2D.Float position;
    private org.apache.batik.gvt.font.GVTGlyphMetrics metrics;
    private java.awt.Shape outline;
    private java.awt.geom.Rectangle2D bounds;
    private org.apache.batik.gvt.text.TextPaintInfo tpi;
    private org.apache.batik.gvt.text.TextPaintInfo cacheTPI;
    private java.awt.Shape dShape;
    private org.apache.batik.gvt.GraphicsNode glyphChildrenNode;
    public Glyph(java.lang.String unicode, java.util.List names, java.lang.String orientation,
                 java.lang.String arabicForm,
                 java.lang.String lang,
                 java.awt.geom.Point2D horizOrigin,
                 java.awt.geom.Point2D vertOrigin,
                 float horizAdvX,
                 float vertAdvY,
                 int glyphCode,
                 org.apache.batik.gvt.text.TextPaintInfo tpi,
                 java.awt.Shape dShape,
                 org.apache.batik.gvt.GraphicsNode glyphChildrenNode) {
        super(
          );
        if (unicode ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (horizOrigin ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (vertOrigin ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          unicode =
          unicode;
        this.
          names =
          new java.util.Vector(
            names);
        this.
          orientation =
          orientation;
        this.
          arabicForm =
          arabicForm;
        this.
          lang =
          lang;
        this.
          horizOrigin =
          horizOrigin;
        this.
          vertOrigin =
          vertOrigin;
        this.
          horizAdvX =
          horizAdvX;
        this.
          vertAdvY =
          vertAdvY;
        this.
          glyphCode =
          glyphCode;
        this.
          position =
          new java.awt.geom.Point2D.Float(
            0,
            0);
        this.
          outline =
          null;
        this.
          bounds =
          null;
        this.
          tpi =
          tpi;
        this.
          dShape =
          dShape;
        this.
          glyphChildrenNode =
          glyphChildrenNode;
    }
    public java.lang.String getUnicode() { return unicode; }
    public java.util.Vector getNames() { return names; }
    public java.lang.String getOrientation() { return orientation;
    }
    public java.lang.String getArabicForm() { return arabicForm; }
    public java.lang.String getLang() { return lang; }
    public java.awt.geom.Point2D getHorizOrigin() { return horizOrigin;
    }
    public java.awt.geom.Point2D getVertOrigin() { return vertOrigin;
    }
    public float getHorizAdvX() { return horizAdvX; }
    public float getVertAdvY() { return vertAdvY; }
    public int getGlyphCode() { return glyphCode; }
    public java.awt.geom.AffineTransform getTransform() { return transform;
    }
    public void setTransform(java.awt.geom.AffineTransform transform) {
        this.
          transform =
          transform;
        outline =
          null;
        bounds =
          null;
    }
    public java.awt.geom.Point2D getPosition() { return position;
    }
    public void setPosition(java.awt.geom.Point2D position) { this.
                                                                position.
                                                                x =
                                                                (float)
                                                                  position.
                                                                  getX(
                                                                    );
                                                              this.
                                                                position.
                                                                y =
                                                                (float)
                                                                  position.
                                                                  getY(
                                                                    );
                                                              outline =
                                                                null;
                                                              bounds =
                                                                null;
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics() {
        if (metrics ==
              null) {
            java.awt.geom.Rectangle2D gb =
              getGeometryBounds(
                );
            metrics =
              new org.apache.batik.gvt.font.GVTGlyphMetrics(
                getHorizAdvX(
                  ),
                getVertAdvY(
                  ),
                new java.awt.geom.Rectangle2D.Double(
                  gb.
                    getX(
                      ) -
                    position.
                    getX(
                      ),
                  gb.
                    getY(
                      ) -
                    position.
                    getY(
                      ),
                  gb.
                    getWidth(
                      ),
                  gb.
                    getHeight(
                      )),
                java.awt.font.GlyphMetrics.
                  COMPONENT);
        }
        return metrics;
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(float hkern,
                                                                     float vkern) {
        return new org.apache.batik.gvt.font.GVTGlyphMetrics(
          getHorizAdvX(
            ) -
            hkern,
          getVertAdvY(
            ) -
            vkern,
          getGeometryBounds(
            ),
          java.awt.font.GlyphMetrics.
            COMPONENT);
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() {
        return getOutline(
                 ).
          getBounds2D(
            );
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        if (bounds !=
              null &&
              org.apache.batik.gvt.text.TextPaintInfo.
              equivilent(
                tpi,
                cacheTPI))
            return bounds;
        java.awt.geom.AffineTransform tr =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            position.
              getX(
                ),
            position.
              getY(
                ));
        if (transform !=
              null) {
            tr.
              concatenate(
                transform);
        }
        java.awt.geom.Rectangle2D bounds =
          null;
        if (dShape !=
              null &&
              tpi !=
              null) {
            if (tpi.
                  fillPaint !=
                  null)
                bounds =
                  tr.
                    createTransformedShape(
                      dShape).
                    getBounds2D(
                      );
            if (tpi.
                  strokeStroke !=
                  null &&
                  tpi.
                    strokePaint !=
                  null) {
                java.awt.Shape s =
                  tpi.
                    strokeStroke.
                  createStrokedShape(
                    dShape);
                java.awt.geom.Rectangle2D r =
                  tr.
                  createTransformedShape(
                    s).
                  getBounds2D(
                    );
                if (bounds ==
                      null)
                    bounds =
                      r;
                else
                    bounds.
                      add(
                        r);
            }
        }
        if (glyphChildrenNode !=
              null) {
            java.awt.geom.Rectangle2D r =
              glyphChildrenNode.
              getTransformedBounds(
                tr);
            if (bounds ==
                  null)
                bounds =
                  r;
            else
                bounds.
                  add(
                    r);
        }
        if (bounds ==
              null)
            bounds =
              new java.awt.geom.Rectangle2D.Double(
                position.
                  getX(
                    ),
                position.
                  getY(
                    ),
                0,
                0);
        cacheTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
            tpi);
        return bounds;
    }
    public java.awt.Shape getOutline() { if (outline ==
                                               null) {
                                             java.awt.geom.AffineTransform tr =
                                               java.awt.geom.AffineTransform.
                                               getTranslateInstance(
                                                 position.
                                                   getX(
                                                     ),
                                                 position.
                                                   getY(
                                                     ));
                                             if (transform !=
                                                   null) {
                                                 tr.
                                                   concatenate(
                                                     transform);
                                             }
                                             java.awt.Shape glyphChildrenOutline =
                                               null;
                                             if (glyphChildrenNode !=
                                                   null) {
                                                 glyphChildrenOutline =
                                                   glyphChildrenNode.
                                                     getOutline(
                                                       );
                                             }
                                             java.awt.geom.GeneralPath glyphOutline =
                                               null;
                                             if (dShape !=
                                                   null &&
                                                   glyphChildrenOutline !=
                                                   null) {
                                                 glyphOutline =
                                                   new java.awt.geom.GeneralPath(
                                                     dShape);
                                                 glyphOutline.
                                                   append(
                                                     glyphChildrenOutline,
                                                     false);
                                             }
                                             else
                                                 if (dShape !=
                                                       null &&
                                                       glyphChildrenOutline ==
                                                       null) {
                                                     glyphOutline =
                                                       new java.awt.geom.GeneralPath(
                                                         dShape);
                                                 }
                                                 else
                                                     if (dShape ==
                                                           null &&
                                                           glyphChildrenOutline !=
                                                           null) {
                                                         glyphOutline =
                                                           new java.awt.geom.GeneralPath(
                                                             glyphChildrenOutline);
                                                     }
                                                     else {
                                                         glyphOutline =
                                                           new java.awt.geom.GeneralPath(
                                                             );
                                                     }
                                             outline =
                                               tr.
                                                 createTransformedShape(
                                                   glyphOutline);
                                         }
                                         return outline;
    }
    public void draw(java.awt.Graphics2D graphics2D) {
        java.awt.geom.AffineTransform tr =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            position.
              getX(
                ),
            position.
              getY(
                ));
        if (transform !=
              null) {
            tr.
              concatenate(
                transform);
        }
        if (dShape !=
              null &&
              tpi !=
              null) {
            java.awt.Shape tShape =
              tr.
              createTransformedShape(
                dShape);
            if (tpi.
                  fillPaint !=
                  null) {
                graphics2D.
                  setPaint(
                    tpi.
                      fillPaint);
                graphics2D.
                  fill(
                    tShape);
            }
            if (tpi.
                  strokeStroke !=
                  null &&
                  tpi.
                    strokePaint !=
                  null) {
                graphics2D.
                  setStroke(
                    tpi.
                      strokeStroke);
                graphics2D.
                  setPaint(
                    tpi.
                      strokePaint);
                graphics2D.
                  draw(
                    tShape);
            }
        }
        if (glyphChildrenNode !=
              null) {
            glyphChildrenNode.
              setTransform(
                tr);
            glyphChildrenNode.
              paint(
                graphics2D);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BsuRlHX8HCzdAo/9dhbt7w4onR9t+fZWDuuKAJPp9H/yy++8fP/0mdNciRFe" +
       "StYFRcGFoTfatFUhdtlRkN/tuObsr84P3YyM4erUY7E1Z6tnvdt18Z3Uzdo2" +
       "4UbOu625Xj3hQ9/w9YZnjjZX9IDF7CVVWVW+NSv1ptxOFIJKMzvqUhwn2mMV" +
       "bq35Av4icP0PXqgtWMG1prnLinyW50MfXc9hOyWRtXCLA1zpFLZw85hwwiSN" +
       "jUtaBsIrCI433oCNfWbxzZI0YO2pPGFJuDG5TzzSnnzXBq8DixtRD9aEPCV5" +
       "x4gfbH77wH3vPWpt5wJH5OksHTn251/E7jzG1YJH7isLgmc3DY/eOZB57laE" +
       "zcIoen555uDTDx88zLlq9sah3fCY9eg///dPYsffeaFIWARORhOoX0vw317G" +
       "R5I1DVjc4M+XXfd7KKmQ1QBye+VWF4288JErthuKJLhm2gvBq1eNcaUH04Ll" +
       "Z6F6RdFhdhiCnpZFsx9WnTG8mfW/PM8SYSzxJR/DYpXpjlG8K+56RB0Rj772" +
       "m7qh3zz7MUPN+4zrdsl9gs6XrAmLS5hh8ceQOwUzDf02ne2/qVE5+zmMOAwj" +
       "imC2zAEDItecx4FbvWfOeuNHP56/7+UKEu0h1bBMqR6BxUJkNgQhkpmGoDen" +
       "X3c9N8qTVVbkQXKkQPiCCvSDy4p72O6MTplPnP7Bgu9e+9CJt1gwoPMxljB6" +
       "jF+Weowny5Q48depV6/6p4e+cc8k18iQ/eWjW/jZgDJ66F8/LYCchZtFtpyP" +
       "fjh++r7FXdveZ/RO3IfU7bnCZweInR3ajacyv4u2Vf5DlMwaJo2ilZkYEpQs" +
       "RlPD8DRu2umKBKnztHufrPljZEc+rl3q3/Ouaf0Rp9vczqAe0+oEmfgoR5bA" +
       "td5yyOv9QWaEsBu+ZqtZuRaLy+yYbpZuyBNge31BXU3IoEAEbkGEfZY3znMY" +
       "9TgWU3yk/YHqaHjZXwTXZdZMlwWwfztnH4vbCvkMogabhiCajGKLN4rBm4RF" +
       "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" +
       "Z27R2RbuLRbHsiNs0W52i3c9/wvx2y73EDwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8uL1O6G0o9J11j7eBLP+sks6hTwavDAFBQMMXTQAfvW4QHMpcaa8t1rg8iOX" +
       "HKYfyL5pKeHYU7VixqCi/SuL8kI+RcWC2KkXnRcvDI9a/OOiPhI9P6G85yt/" +
       "fPvsj//59wv2x8PvowZuJPs7Wd2RFw/nU/+8k+6NkEMTtEM/M/6rd9mf+SEY" +
       "UQIjKsA1h3QAnOr2mDnct77hpq/9y88+981fvq50Hi/dCqZbxeXCs5RuASZd" +
       "C03gj7f+69+wWx/JzXs7XtqWnkJ+J5f7im/PPVvV8Tx6PvRL9/1v2l687Q9/" +
       "8JRJKNzpJbT/RH8J+tgHHug+/p2i/6Ffy3s/tH1qoAF2God9kY86f3b+RTf+" +
       "m/Olm6TSXcp+GzOT7Tj3FhII3cODvQ3Y6hyrPx6G72LOxy767RecXH5HbnvS" +
       "ox6qPTjPW+fnt55wonncV3o+OF61t1avOmmtzpWKkzcWXR4pykfz4mUHPusm" +
       "P7A2YPUWI78efI9dSwFKfdGK3VV0YvLiTTt5cqfKXjiO7H5wvHqP7NWnINNO" +
       "QZafygegbsgnIyzaIMdvcc9ZtzjujQodn2m5KufX7RPk9Csk90JwXNjf+cIp" +
       "5PzLIfcsL7BA/CwfhCknZ319hcAeAge0BwadAiy5HGC3glBnYSk4CO0uhWt7" +
       "hbjuAwe8xwWfguutl4Pr+nxxXQrRT1whoofBUdkjqpyC6O2XJUITyDCjA8uw" +
       "ChG2TgD76WegW8geGHIKsL95WSLcgFj+dFx/6wpxvQAc1T2u6im4fu5ycN1S" +
       "TFhb3Qj5hcdPwHryCmHlFhDdw0JPgfX3LgfWzfl0AVTipVD9/BWiegActT2q" +
       "2imoPnxZk2Xke9ju3ij3TsD6hSuE9VJw1Pew6qfA+qXLghUFshvmG78DO/vg" +
       "8Ti3revA504PWp3A/ctXiPvF4GjscTdOwf3JyxLywZ7wAPbzLxmegw3fPtI8" +
       "AvrXrhD0o+Bo7kE3TwH9zy4HdP7MLwDx5gHmV5zxxGM2LR56jHY9TjD41DPQ" +
       "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" +
       "PlsbVLDZUkFHZUHQ1cZw6Ewqk06qlWdzHEWAVvaCyIyHJGU6iLHprCvaWJF5" +
       "AkYpW6rjdVbFTdW0uq4v4eG2NXen/aajzyFm1ORELtuSLISJvuAv7X5zWK7V" +
       "2Q7MLhsNxGmszWqWNUY8My6jWaCGdssI60LQdiig02ZT0SZ0wmeYDiOuhkDr" +
       "Wa9WzpwR3U6WltNFsjbwDpGmbFF8sZnrtBaPCaZWhxplftiLYbOy6IzWbL2z" +
       "5cnV2JiYK9/pA1fuClWlNW6up7PZYjURhqsJY3W7Gw5LUb+B0PXR1LcZl2l0" +
       "jLillVtdMqoYiceMtvayU1/i5bnmJW5amwCXoPmzOlT3Ua2sKM1VpWlNIG2+" +
       "nENLycDIeh1vQpTYVUwpwiM/ZfSlWS4HDVxQN5oEsXR1oPONhduVEm3gslVg" +
       "DpV0g8bITK9h9iiRSQ+xbOBRe/4kZG0Ga2JsjMTOsDN0s4iI9YCxl1JPKQd2" +
       "dV2F6FjWYdZvbZRs3dbgstdzdMNja4t2pNbSlN60JnO5F3bisrSOpJiVqbSc" +
       "igtfitPO2NCqlY7AVwder91brPo9XRKrmTsSW1NjzlfTFSQSa5kACyiZCpIq" +
       "jexknuhZ5BLoZtHdrEaeIS+ACsjL/pAao0HHQVncLmNljrExtrOarttzEZUG" +
       "WTsUJiqlmOuuWGa0Tl9c+habCVAAMVt2sdKs5rimtTKvwYRmdwIPK5sWHraj" +
       "JNCB67XVWn+WbLvllgjCPx2bVe1BH0QYSxbrRO1eOXMHQY3QhyQhzIKlVXGy" +
       "bRtvbEB8ULHINSe7VrPvCzhhW4a4TjSqRsxMoaMuVhVEm3QDEiYlTB46zU67" +
       "P14n4qrVXK8U11b6SOJHq0lCc5jHJ31eYWQfIbZ+ooy02daRW5CLQsICr/fd" +
       "fr0qjY1Foi3XfAVEIHMmJFMZ6wRYTR6sIwpdBF0nTocgUtS7/R0uED/Ns2ja" +
       "IxAch0PdV+HNCseqPOnE8XTSVxhTGMpsu0LO+MFwidXt+XDE2LDloRsTcbbj" +
       "aOq0YbaMj0y/h0ldWqwOtyk0lJOsRkONWm9qlTt12A8CK8RoAi7b45Ehx10e" +
       "WTZ6qjmJqistzoLetjtcpC6IkVIjtK1gwAXrMJTW6LBHCzaP97vroTMlGiN7" +
       "PqNgdNFvdWqtlk4Mm/x6oICILQqnQB0tjOjX8bSD49OWuSCMgbKYo0llMHVD" +
       "T4XDpVolhsK2uxFWLF0eyFa9ErS9SZ1Ifb6H8QN/zvubUG/rCa+7wHWa42oc" +
       "9hfrLo1lFbCgOjY+5ZfOWlJnPLGJcMEU5I7Um9I9H0eXq4GdZBsBniqhKlii" +
       "E7cxstxLzU4Pm0DujNS3ajglgEnbiME4DpEFMFjYUqr3wLgEJpkz1q0qrgai" +
       "kfLGxhlcUiS4UhEEvD+o4RPWo70Jh3NUp8Wy/eYSZilJaGtCRRIg3OlnQ386" +
       "zvXRCZYEp0TD1Md4PdxkFlanJVRNXGLsCL6mO3pl1otaFDvWRwGtcHQZN1ak" +
       "bLQaSShVhRSmetO12CPGraUUd3F4QvplhyPH3MAP1pSr4URc5TYb0UGqbqzD" +
       "QkvQdL1BAlmEftCykmDDd6kWkUAIXzPqyTizG+hccGN42BQarfq8autdpEHa" +
       "jD9tTrIGp0JrnJC0gQrrklxNNb5ropDWtOubrtOTvbE1F8cVKXYFydZncBaG" +
       "9Q4XtaRZqxwvvWxVthUL6iSeJU0Ryo8HFiAgz5zutt+lXEV0Y+ArFIKuqMqa" +
       "aOF+o5kYvrqFgoHebU7qjOVQfcfhDMWyMLaHMLy5mPbCmUeTnS5WH8laB+xz" +
       "R4YGpjTsJ8QQbVC4Gw87SH8wHkx4uUnLynikzydTUufbCYptPLXZEat0LRm1" +
       "DTStUV4QDTspPRj3pobrdxF3ZsK8PSBEgq2HiUfj0YYyJ0K9Uqbnk5FKbUF0" +
       "DNpqidRFmNkSnsAGOe9Ow2gwx5JVW+JJC1twG0ML21wNbKb4iWFhEg4L8HIx" +
       "7EiNsr4Q60pM0X1MmXXRxA7HldSnvBltGx2y3++SCSkroyVP9uDqtoZVQ44y" +
       "0JnSsVI5HMJ4/kTakFCPEEMDNjs1H2bk");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
