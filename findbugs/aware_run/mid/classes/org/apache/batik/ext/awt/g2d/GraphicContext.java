package org.apache.batik.ext.awt.g2d;
public class GraphicContext implements java.lang.Cloneable {
    protected java.awt.geom.AffineTransform defaultTransform = new java.awt.geom.AffineTransform(
      );
    protected java.awt.geom.AffineTransform transform = new java.awt.geom.AffineTransform(
      );
    protected java.util.List transformStack = new java.util.ArrayList(
      );
    protected boolean transformStackValid = true;
    protected java.awt.Paint paint = java.awt.Color.black;
    protected java.awt.Stroke stroke = new java.awt.BasicStroke(
      );
    protected java.awt.Composite composite = java.awt.AlphaComposite.
                                               SrcOver;
    protected java.awt.Shape clip = null;
    protected java.awt.RenderingHints hints = new java.awt.RenderingHints(
      null);
    protected java.awt.Font font = new java.awt.Font("sanserif",
                                                     java.awt.Font.
                                                       PLAIN,
                                                     12);
    protected java.awt.Color background = new java.awt.Color(
      0,
      0,
      0,
      0);
    protected java.awt.Color foreground = java.awt.Color.
                                            black;
    public GraphicContext() { super();
                              hints.put(java.awt.RenderingHints.
                                          KEY_RENDERING, java.awt.RenderingHints.
                                                           VALUE_RENDER_DEFAULT);
    }
    public GraphicContext(java.awt.geom.AffineTransform defaultDeviceTransform) {
        this(
          );
        defaultTransform =
          new java.awt.geom.AffineTransform(
            defaultDeviceTransform);
        transform =
          new java.awt.geom.AffineTransform(
            defaultTransform);
        if (!defaultTransform.
              isIdentity(
                ))
            transformStack.
              add(
                org.apache.batik.ext.awt.g2d.TransformStackElement.
                  createGeneralTransformElement(
                    defaultTransform));
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.g2d.GraphicContext copyGc =
                                        new org.apache.batik.ext.awt.g2d.GraphicContext(
                                        defaultTransform);
                                      copyGc.
                                        transform =
                                        new java.awt.geom.AffineTransform(
                                          this.
                                            transform);
                                      copyGc.
                                        transformStack =
                                        new java.util.ArrayList(
                                          transformStack.
                                            size(
                                              ));
                                      for (int i =
                                             0;
                                           i <
                                             this.
                                               transformStack.
                                             size(
                                               );
                                           i++) {
                                          org.apache.batik.ext.awt.g2d.TransformStackElement stackElement =
                                            (org.apache.batik.ext.awt.g2d.TransformStackElement)
                                              this.
                                                transformStack.
                                              get(
                                                i);
                                          copyGc.
                                            transformStack.
                                            add(
                                              stackElement.
                                                clone(
                                                  ));
                                      }
                                      copyGc.
                                        transformStackValid =
                                        this.
                                          transformStackValid;
                                      copyGc.
                                        paint =
                                        this.
                                          paint;
                                      copyGc.
                                        stroke =
                                        this.
                                          stroke;
                                      copyGc.
                                        composite =
                                        this.
                                          composite;
                                      if (clip !=
                                            null)
                                          copyGc.
                                            clip =
                                            new java.awt.geom.GeneralPath(
                                              clip);
                                      else
                                          copyGc.
                                            clip =
                                            null;
                                      copyGc.
                                        hints =
                                        (java.awt.RenderingHints)
                                          this.
                                            hints.
                                          clone(
                                            );
                                      copyGc.
                                        font =
                                        this.
                                          font;
                                      copyGc.
                                        background =
                                        this.
                                          background;
                                      copyGc.
                                        foreground =
                                        this.
                                          foreground;
                                      return copyGc;
    }
    public java.awt.Color getColor() { return foreground;
    }
    public void setColor(java.awt.Color c) {
        if (c ==
              null)
            return;
        if (paint !=
              c)
            setPaint(
              c);
    }
    public java.awt.Font getFont() { return font;
    }
    public void setFont(java.awt.Font font) {
        if (font !=
              null)
            this.
              font =
              font;
    }
    public java.awt.Rectangle getClipBounds() {
        java.awt.Shape c =
          getClip(
            );
        if (c ==
              null)
            return null;
        else
            return c.
              getBounds(
                );
    }
    public void clipRect(int x, int y, int width,
                         int height) { clip(
                                         new java.awt.Rectangle(
                                           x,
                                           y,
                                           width,
                                           height));
    }
    public void setClip(int x, int y, int width,
                        int height) { setClip(
                                        new java.awt.Rectangle(
                                          x,
                                          y,
                                          width,
                                          height));
    }
    public java.awt.Shape getClip() { try {
                                          return transform.
                                            createInverse(
                                              ).
                                            createTransformedShape(
                                              clip);
                                      }
                                      catch (java.awt.geom.NoninvertibleTransformException e) {
                                          return null;
                                      } }
    public void setClip(java.awt.Shape clip) {
        if (clip !=
              null)
            this.
              clip =
              transform.
                createTransformedShape(
                  clip);
        else
            this.
              clip =
              null;
    }
    public void setComposite(java.awt.Composite comp) {
        this.
          composite =
          comp;
    }
    public void setPaint(java.awt.Paint paint) {
        if (paint ==
              null)
            return;
        this.
          paint =
          paint;
        if (paint instanceof java.awt.Color)
            foreground =
              (java.awt.Color)
                paint;
    }
    public void setStroke(java.awt.Stroke s) {
        stroke =
          s;
    }
    public void setRenderingHint(java.awt.RenderingHints.Key hintKey,
                                 java.lang.Object hintValue) {
        hints.
          put(
            hintKey,
            hintValue);
    }
    public java.lang.Object getRenderingHint(java.awt.RenderingHints.Key hintKey) {
        return hints.
          get(
            hintKey);
    }
    public void setRenderingHints(java.util.Map hints) {
        this.
          hints =
          new java.awt.RenderingHints(
            hints);
    }
    public void addRenderingHints(java.util.Map hints) {
        this.
          hints.
          putAll(
            hints);
    }
    public java.awt.RenderingHints getRenderingHints() {
        return hints;
    }
    public void translate(int x, int y) {
        if (x !=
              0 ||
              y !=
              0) {
            transform.
              translate(
                x,
                y);
            transformStack.
              add(
                org.apache.batik.ext.awt.g2d.TransformStackElement.
                  createTranslateElement(
                    x,
                    y));
        }
    }
    public void translate(double tx, double ty) {
        transform.
          translate(
            tx,
            ty);
        transformStack.
          add(
            org.apache.batik.ext.awt.g2d.TransformStackElement.
              createTranslateElement(
                tx,
                ty));
    }
    public void rotate(double theta) { transform.
                                         rotate(
                                           theta);
                                       transformStack.
                                         add(
                                           org.apache.batik.ext.awt.g2d.TransformStackElement.
                                             createRotateElement(
                                               theta));
    }
    public void rotate(double theta, double x,
                       double y) { transform.
                                     rotate(
                                       theta,
                                       x,
                                       y);
                                   transformStack.
                                     add(
                                       org.apache.batik.ext.awt.g2d.TransformStackElement.
                                         createTranslateElement(
                                           x,
                                           y));
                                   transformStack.
                                     add(
                                       org.apache.batik.ext.awt.g2d.TransformStackElement.
                                         createRotateElement(
                                           theta));
                                   transformStack.
                                     add(
                                       org.apache.batik.ext.awt.g2d.TransformStackElement.
                                         createTranslateElement(
                                           -x,
                                           -y));
    }
    public void scale(double sx, double sy) {
        transform.
          scale(
            sx,
            sy);
        transformStack.
          add(
            org.apache.batik.ext.awt.g2d.TransformStackElement.
              createScaleElement(
                sx,
                sy));
    }
    public void shear(double shx, double shy) {
        transform.
          shear(
            shx,
            shy);
        transformStack.
          add(
            org.apache.batik.ext.awt.g2d.TransformStackElement.
              createShearElement(
                shx,
                shy));
    }
    public void transform(java.awt.geom.AffineTransform Tx) {
        transform.
          concatenate(
            Tx);
        transformStack.
          add(
            org.apache.batik.ext.awt.g2d.TransformStackElement.
              createGeneralTransformElement(
                Tx));
    }
    public void setTransform(java.awt.geom.AffineTransform Tx) {
        transform =
          new java.awt.geom.AffineTransform(
            Tx);
        invalidateTransformStack(
          );
        if (!Tx.
              isIdentity(
                ))
            transformStack.
              add(
                org.apache.batik.ext.awt.g2d.TransformStackElement.
                  createGeneralTransformElement(
                    Tx));
    }
    public void validateTransformStack() {
        transformStackValid =
          true;
    }
    public boolean isTransformStackValid() {
        return transformStackValid;
    }
    public org.apache.batik.ext.awt.g2d.TransformStackElement[] getTransformStack() {
        org.apache.batik.ext.awt.g2d.TransformStackElement[] stack =
          new org.apache.batik.ext.awt.g2d.TransformStackElement[transformStack.
                                                                   size(
                                                                     )];
        transformStack.
          toArray(
            stack);
        return stack;
    }
    protected void invalidateTransformStack() {
        transformStack.
          clear(
            );
        transformStackValid =
          false;
    }
    public java.awt.geom.AffineTransform getTransform() {
        return new java.awt.geom.AffineTransform(
          transform);
    }
    public java.awt.Paint getPaint() { return paint;
    }
    public java.awt.Composite getComposite() {
        return composite;
    }
    public void setBackground(java.awt.Color color) {
        if (color ==
              null)
            return;
        background =
          color;
    }
    public java.awt.Color getBackground() {
        return background;
    }
    public java.awt.Stroke getStroke() { return stroke;
    }
    public void clip(java.awt.Shape s) { if (s !=
                                               null)
                                             s =
                                               transform.
                                                 createTransformedShape(
                                                   s);
                                         if (clip !=
                                               null) {
                                             java.awt.geom.Area newClip =
                                               new java.awt.geom.Area(
                                               clip);
                                             newClip.
                                               intersect(
                                                 new java.awt.geom.Area(
                                                   s));
                                             clip =
                                               new java.awt.geom.GeneralPath(
                                                 newClip);
                                         }
                                         else {
                                             clip =
                                               s;
                                         }
    }
    public java.awt.font.FontRenderContext getFontRenderContext() {
        java.lang.Object antialiasingHint =
          hints.
          get(
            java.awt.RenderingHints.
              KEY_TEXT_ANTIALIASING);
        boolean isAntialiased =
          true;
        if (antialiasingHint !=
              java.awt.RenderingHints.
                VALUE_TEXT_ANTIALIAS_ON &&
              antialiasingHint !=
              java.awt.RenderingHints.
                VALUE_TEXT_ANTIALIAS_DEFAULT) {
            if (antialiasingHint !=
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_OFF) {
                antialiasingHint =
                  hints.
                    get(
                      java.awt.RenderingHints.
                        KEY_ANTIALIASING);
                if (antialiasingHint !=
                      java.awt.RenderingHints.
                        VALUE_ANTIALIAS_ON &&
                      antialiasingHint !=
                      java.awt.RenderingHints.
                        VALUE_ANTIALIAS_DEFAULT) {
                    if (antialiasingHint ==
                          java.awt.RenderingHints.
                            VALUE_ANTIALIAS_OFF)
                        isAntialiased =
                          false;
                }
            }
            else
                isAntialiased =
                  false;
        }
        boolean useFractionalMetrics =
          true;
        if (hints.
              get(
                java.awt.RenderingHints.
                  KEY_FRACTIONALMETRICS) ==
              java.awt.RenderingHints.
                VALUE_FRACTIONALMETRICS_OFF)
            useFractionalMetrics =
              false;
        java.awt.font.FontRenderContext frc =
          new java.awt.font.FontRenderContext(
          defaultTransform,
          isAntialiased,
          useFractionalMetrics);
        return frc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WtqrW1S2A8+M/clVP9r3BlUqWsPE7PGyg6nSjtzjBdMZmMzK1kIeaaC/IrY+" +
       "09/jLDKRck3tuqz11i1OJsFCtBmSauKgp80uFfR4IybX0ayFmCy2h8eiC5Ma" +
       "PrjWpphAn4000ZUNTg00HvGs2gev33/65+d+WGx7MzP5pjxAN+7z1Urn1nc+" +
       "y9I3asRzeFoB+vbYwQfGN1xzhtJ71hSpp/Vnz7Qw33i0lz/e+0l0atEvo6S4" +
       "nVTGme+/RlLSaKPawd81nYAA4oOM/Ezf1XbU6t3Z4pKgJfc1G7Tj3gwP91ga" +
       "78sCprscu2Y5XIuYPi0KqmKE0Js2WxtpOhOTOY6lHK4bmgVcyomAsSwTVAtR" +
       "XEJOSmnFcrUPny/zFJ8q2I3nU7BVmUiw2BLW5BIOktu8cXVTNsM8asBpiTi9" +
       "PSSn85ncHfnn4jQh5JRHbZFyl1OI++I9aK38owyj99Z0p2m1SBtoTNIRv2fq" +
       "ti2XFp9dYA+yyTlL+8KXK84tqJj8+KOqXbw2d+WZgcs7m15+WPvDmagTlOQi" +
       "sUveYK589bkV73VQd6AEvcA2R3l9/t1io8vni1RmCrcKrseYeOi3Rdbl1SWH" +
       "SiBKT/VCYBlrS/XKCVwlkFU3APgbtoYz5IQsI+p17ZHnDizcMefmh23BT+HY" +
       "T6/8s9966/iDA4cP2s4Jih/CA95KR/byCvqq0wX+tqdEnyxfNPj+6TW3Rdnk" +
       "Uo6J2u9MVeX+Wd/2kPqypjUMRgOaZFdeNO/B/95898nV4As3kpK0mlqflhsT" +
       "mUax2Ex3+lTLi+k9Q8n06iv4ROD6X7xQn/CBrVdVDSy+newGuLrej/kQKM2C" +
       "24CdkEPaiXlwtTBVbuHYibuEdoJHbZHqTDsB808qYfLGc7MBCmil+piAD485" +
       "t/754oFvOr1HFzA2oTIKpuhAHbE7q97seeBPT9iqGZyPA4XlHbu/81Xdzt22" +
       "XtrLQ9OyVmj8NPYSkd2PLndTRK1QimXvHb7zp4/eud3mqipzsWOpmu594rX/" +
       "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" +
       "aI1JAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rxKE7NSfwM/90IPM276Q1T/xc2nth1dXTkIgcj2pi33Y+cvD19z6y4e52ya5" +
       "S8o2LB5Idpx6jwkIBcOjWBmEzmfyz4Z1mxjmiWM//qpdH3uq210PezL5gfu0" +
       "dHp/545TvSeVcg1cb9maxlt2reogl920NoaV0cdT8jVHPuwOP/AiwKWmbt3Y" +
       "34K/A3D9v/RKm0sTNjHKfcw2UHr0OFLywcx8SdV0KbajY6NK23n7iT1ndsN9" +
       "JbupnUWVFqO3qOhroBpcA1V6y2ei6gKA0T62hjfIFrEV+JHgr8bWN14PW/cc" +
       "swUWPooFBserrzE4BGmZheVPKj/b/dynPrT+6HObOUGWQNyZg661wrtykZmG" +
       "CK/dE+acxP5/WXvLC3/83wffeLh1Ai85K4T79gnhyO/cc9ojb2av6Y7wv+kG" +
       "hY+CS9j2K1xD+Nb1CP/+s8IHQ9dU97snPjAdEFgstmsc+J33fdb6oT/6yc36" +
       "ZdcX7RTWnnr/d/7t5e95/+GpVeNjVyzcTtfZrBwzbu/OWF6dsY+r9JLVqH7+" +
       "o+/8+R9/53dsuLrv7BqoApb4P/lf/uaTlz/4uV+9Snh9m+x5tia5Oyqyb1BF" +
       "rwfXcKui4TVUtL4eFd3iA4cdnTWmdBLj0+QdJr/5BplMl1/fsGXyG67B5D+6" +
       "HiZvBVG4Z2lHXN57zGUvS99h89tukM0nwCVt2ZSuweZ3X5cLTBe4aWB8zOl9" +
       "x5wyR1k7zP6TG2T2UXDpW2b1azD7geth9mbFNv0r9d4zJH+Xx6dvkMe3gcva" +
       "8mhdg8dnrss4jdQ2j5h85TGTguaC0NJ0p/Uj2z3F7T+7QW7fDi5/y61/DW5/" +
       "7LokqnsnI+nuY2ar3hUD6cdvkMUiuOIti/E1WPzY9bB4pwzc8DTwYle9UvVg" +
       "meIFO5z+1A1y+mZwrbecrq/B6c9eF6dg1tA2nKYpz+/w9XNfka+NPz8Aodct" +
       "2OXiZST9/cLVe74pvX195mbSZ6OgBojdJfuIlVfObOXxo5BsoAUhiI8fn9nF" +
       "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" +
       "VoGomjN/BM+9EWnI6/ZKbQjqFEZUZoaN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2i1VGPmwrwSkY3HtptgginFC9lklFCsSBhkhpVNFyeGEsriMedfqgmVRv+4N" +
       "fLGL+EjIh8hkMQFLHDFkYhnjE4GsKm4443G2PCyPCmpXhgpQ3V6ZvF1bEjJk" +
       "k1WkDNN5ptP1vBpYa9UVGMDFOXoZNa0VvlpqbYJEKDamSLtKKaOwKejWYLRs" +
       "Cux8xmtCi2jMyB5VDycjRZ0GVLiggNpwrEkQLDejO+UWxzhJj61M7HyXKjnG" +
       "Sg/KPD2RMI6i5aUDMAyIrhrWuEqAjK0kqOAm2hKmdFHVC8si1qdKngxsirdn" +
       "rpnMKqzc9KhSfdKRlvS4xMNCExpXoZrOlFy4BvNrgCB28x6nVJCOanBh2EGj" +
       "kCjUdJeG8dGU7+vccgqDcaUJiUcNErgRr+YiLYzBOlmX7bDMRsNBOJnOG+NO" +
       "rSsMypHZoSZG3JmQTGtqdf1py9AtYiSHBbrREjEJm2ggePHmRb5rIcD3MWhL" +
       "m5ShJc8ZZpnojajGajiV6ZGFj2dNNopa8jSKtRArzSZDTQ8Y3C6jMqwT8KLY" +
       "w6CmuFaCpdsHgZVZYKSlg3UWlozVJzPMIcFsFaBtMXH6PrdEraA+LnD+im/T" +
       "dbAeotskpLDNiDCbRcsbhctQrSVEy2WLtY5YkxSDlcas3WZwvDtDlbhKB8hS" +
       "CG3Mief5IuO3DHMUsNEoaCTxICQ8E1qaIpS4Tp/FwzqdV/tepQwUvEIdrhtx" +
       "ZsEe+Uy7111NGJpbMgm3KtkNorbIg0WY2qfa3V6eHxheWCcRs1+PYh8EDkOy" +
       "KBQaizAm9LVCKnTBp4D5T4MkcmpJoi4hIk7KuDYvLxKODFDGpciBW4NUd+nV" +
       "HYtyyjjDN7Fx0FKLMcaJY5PXFBrPc5rsUIOVKFW34whEj51SCxkiIqKHlUIL" +
       "4pNeoWU3KotIEdVgNR7n5cXag5bosh6iS5RS67MCP2jQ8SIpLyhmDIdVSJ0A" +
       "XooTrcn7Pd0YIktl2kdnPCaRnJH3qSYiLoPEDVuWm9BIgWdLJYbiNWmaegu1" +
       "uWy15Fakd0dMEV8Op2AqTdAJBhGNNTRflgt94DcmsyhPoQG0btKCSPZCTSkn" +
       "6/EadcjOLO9X2G4L8RI+RJsBtEwqg7CdZ0pBOO9EYqghpogLQjWOWBxMhEW2" +
       "wLvwCrLrII5y3blcDwviLFwUO0uYaJkL09CFvj2GdRXqQFgdmpGiIjaaNtsT" +
       "mZiF8UQvFvONNiRYpuXjzQpaR/qch6glKU+zQgnTBMoyQTw7bTpQAyXrKFGt" +
       "UlLfhf1+Uh6P2KHRpDtyH27w1bnF2YHQaOg4ZuMLsTEfaJ1x2MdEHWrEJao4" +
       "oCoyAhXjUm3dngUYVijhYDqElFbcnZXzerXoWfCct1iqVRAStCM3q/HE09xy" +
       "DBX1aOgAq9bCMZSsVgN/TNFBrVvT4hE2d13XWY7bYziaK7HnD9d8YsKcayB5" +
       "3Js0wTKwrM6brjmfiYtOYx3MkcWM6gyhNTrDY30YwIO+xhd70wI1qTdava45" +
       "lMSCHSczf4EWMJMRZcdlVWnJdg21QLcwqMSL0mANF3Wpx9YdwilZtbBmVKsC" +
       "vh4hqiZbxQCCe9MJbk3Z/pqZQrGVx2qleFBdWFoTEpT+PJi3eZWl8rQoWvOF" +
       "Jy74gmE5lXILZ3VisJwOnYlfAlNFsZhU2eoQK8vMatUMtGRZkfWILRaVgm0V" +
       "1IUh6ognqQw6m0uDOMx39NUg9idsHaJmgyLKk5xOw0NHd6UG2qQo6mvT1xW/" +
       "dWOvUV6avTE63p8+s4tpxq/cwJuS1dV2qGV/t+Z29jSfesN2ahvY8b60+0/e" +
       "FTG252rpvsV0m8ND19qSnm1xePZb3/+M2vkR9GhnSpxu8PH8N9vaQrNPdfM6" +
       "0NIbr72dg8t25J9s+fqVb/2TB8W3Ge+4gd28j+zwudvkT3DP/Wrtdcr3HuZu" +
       "Ot4AdsW3AmcrPXF229edgRbFgSue2fz10LHU0104uVeC6/u2Uv++3feaJ3q9" +
       "+kvN12/sYs/uvz/bk/diSv4kyt2ipOq7ykvHzfa3E7v6wo1sHcwSPn8MNjOz" +
       "dP/kr2/B/vrFg/2bPXl/m5K/jnK3T7Xo+H308yfY/s85sGV7Q18Nrs9ssX3m" +
       "YrAdnBR4Pi1wcMe1AR68JCU3A4DhFuBV36suPFM9Bn1wyzlAXzqy3s9vQX/+" +
       "whV68MCevAdTcn+Uuw0o9GgnxHMn0F52Xn2+Blx/voX25xeuz+cyDI/vwfe6" +
       "lDwC8IXH+A7uPsH36DnwvXyL7+D2Td3N/4tVHbInLwMARbm707Fomz6dbRu5" +
       "cmuTALwP8EO2dgL7TedV69cCBI9vYT9+MbBvzgrcfLXxdtNmr9vB209IJoE9" +
       "G7YPmJSUwEBO91GlItjR/A1t4L6aCN4K0BS3IiheqAh2oJ7g5fbg7aSkvjH0" +
       "1Bp24DbOO+k8kEs3S27gti7e0Md78r4+JeLGR22h5X7wBFr/vJp8DHCpbaFp" +
       "FwPtlI/6wQyDtgdfukXn4B3XVJ10XnxvApy8Z4vvPReO730ZhvkefGniAQj7" +
       "7srm1JN9lqdBOucF+TWAnae3IJ++cJDvyoC8cw/Id6VktQkcjjbnngaYXISV" +
       "/ugW4I9eOMCnMhD/eA/A70rJt4F1BgB4vK/3NML3nBdhG/Dy/Bbh8xeD8HD7" +
       "YWP6G0yKX32NLaqPs1qSFvmLDOkH9kjhB1LyXhDfAymcaWNHGO87hzCyFU0a" +
       "WHx8K4yPX7S6D57OwPzwHqA/kpJnANDplUBzf3EC9Ctu570e7/TbW6C/faFA" +
       "s9/ycW9pKJp77b7ejszk7pNvNjgpc8c/ncnko3vkle6APfhwlHvprmGEO5bx" +
       "Ly5CYF/YQvjC34vA9vV28NMn8vl3e+TzSyn5OSAfSVX3yufnzyGfB9NECHD6" +
       "5S3HX74Y+ZwG8ut78v5jSj4BQO4Omqz0D5+A/NULmO4OX7Kpu/l/Yb5yfjbm" +
       "/MweuP81JZ8++rbMlq6Y1f/zeWHCgKHHtjAfu1CY2e+ddcatqhfL2ekFB3+Y" +
       "AfyDPeD/JCWf2wP+988LHiysDsktePJCB/oJwv+1B+FfpeTPgFiC9DHgLrwv" +
       "nhcegHTIb+HxFwPvpuPHvgd/eELSooe5awM9zGz+S9cC+uXzAgUO6XC2BTq7" +
       "8LF6CuNdezCm34gf3hblbgkVyd6BeHj7eSG+GTDz7i3Ed/9dQtzzLOswfZZ1" +
       "eH8K0dCkYAfiuZ9kpRC/fwvx+y96NOYyZ3u450nWYfok6/CRnQ95TyM8z7Os" +
       "DCECkD27Rfjs3xHCPQ+0DjMU0GadKF4D5LmfXL0egPupLcifuhiQpzG8dU/e" +
       "21JSjHKvWKQf2gJHI575/HYHKXkOpPcfIf2ZLdKfuXik9T15zZQwUe7lZihe" +
       "+YlxWiM8AVo+B9AsJiAAwBe2QF+4eKDinrxBSjqbgE/c/ZJ9z0fm2bkim8+i" +
       "n/nRx37jXc889vvZ0Ry3m+FACqhgepVDqU7V+eJzn/3Cb9790Eey42uyL+BT" +
       "5u7cPc3rysO6zpzBlSG/6+zweHSfLLOiYH2E7T2D6Kwc0iPaNDfyfT93onL+" +
       "HCo/+o7x8JNbNj95oyrnv6LK9T156SFWh1KUe8B0r2scy+fA+tVpYhrqb1+J" +
       "HV7QK7HTeII9eeli/9ABHnmq7RxrcYLPvYDXmYd/sMX3BxeP7x/uyfuWlCSb" +
       "15nHX9S/6wTb+ryvh14NML24xfbixWP7zj15352S92x0d+br9ved4Pv2886m" +
       "bwTR9i2bupv/58e3+7r28Ok9ID+YkvdFubtByEAffzu9MwK/97wW+jBAd/8W" +
       "5f0Xr8V/vifv2ZR8aPOS7wzAU2/dD58578NG4GduengL8OGLB/iRPXkfS8lP" +
       "gLB2euqxcu6pE3AfPq+NPgRAbXfk3LS7I+eCXu8c/twehP8mJc9vT3TYMc1/" +
       "dQ5wD6WJKAA12oIbXbzmPr4n7xMp+cUo97Lt1oHNA6/t0YNHocIjx0/c09MX" +
       "Ll+9XCaKf39DJ2pFuXvOnnWYHtz2wBWHrW4OCFU+8sy9t7/ymf5vbeKlo0M8" +
       "72jlbtdj2z59xNSp+1v9QNPNTER3ZPQeP8P9qSj3qn0BUJS7CdCU5cP/tKnx" +
       "aRAtXKsGKA3o6dK/BUR6tdKg5FZgRyV/J8pd2i0Jlr/Z/9PlfjfK3XlSLsrd" +
       "urk5XeRzoHVQJL39/cx6/mK1eRz8wGnjy/b43PeVFHVc5fSZginc7Mjco31i" +
       "Mb89zumjzzTb3/xi4Uc2ZxoqtrRep63cDqLVzfGK22h192io060dtXVr/Q1f" +
       "uudjd7z2aF/cPRuGTwbCKd4eufoBghXHj7Ij/9Y/88p/+dYfe+b3skMb/j/B" +
       "zR4Jy1gAAA==");
}
