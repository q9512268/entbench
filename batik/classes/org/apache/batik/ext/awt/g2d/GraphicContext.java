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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "by3kx+kXJCUz6C3ezfx/jnJsPKBMAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eGXH9vIUvgLTu4AnAtPmK3l9iI6qjRbj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "2l6YHSOY/NzL/8WbfvKZP8gOgvh/43z8vwNZAAA=");
}
