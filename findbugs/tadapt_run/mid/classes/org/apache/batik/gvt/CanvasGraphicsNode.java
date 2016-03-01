package org.apache.batik.gvt;
public class CanvasGraphicsNode extends org.apache.batik.gvt.CompositeGraphicsNode {
    protected java.awt.geom.AffineTransform positionTransform;
    protected java.awt.geom.AffineTransform viewingTransform;
    protected java.awt.Paint backgroundPaint;
    public CanvasGraphicsNode() { super(); }
    public void setBackgroundPaint(java.awt.Paint newBackgroundPaint) { this.
                                                                          backgroundPaint =
                                                                          newBackgroundPaint;
    }
    public java.awt.Paint getBackgroundPaint() { return backgroundPaint;
    }
    public void setPositionTransform(java.awt.geom.AffineTransform at) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          positionTransform =
          at;
        if (positionTransform !=
              null) {
            transform =
              new java.awt.geom.AffineTransform(
                positionTransform);
            if (viewingTransform !=
                  null)
                transform.
                  concatenate(
                    viewingTransform);
        }
        else
            if (viewingTransform !=
                  null)
                transform =
                  new java.awt.geom.AffineTransform(
                    viewingTransform);
            else
                transform =
                  new java.awt.geom.AffineTransform(
                    );
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getPositionTransform() {
        return positionTransform;
    }
    public void setViewingTransform(java.awt.geom.AffineTransform at) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          viewingTransform =
          at;
        if (positionTransform !=
              null) {
            transform =
              new java.awt.geom.AffineTransform(
                positionTransform);
            if (viewingTransform !=
                  null)
                transform.
                  concatenate(
                    viewingTransform);
        }
        else
            if (viewingTransform !=
                  null)
                transform =
                  new java.awt.geom.AffineTransform(
                    viewingTransform);
            else
                transform =
                  new java.awt.geom.AffineTransform(
                    );
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getViewingTransform() {
        return viewingTransform;
    }
    public void primitivePaint(java.awt.Graphics2D g2d) {
        if (backgroundPaint !=
              null) {
            g2d.
              setPaint(
                backgroundPaint);
            g2d.
              fill(
                g2d.
                  getClip(
                    ));
        }
        super.
          primitivePaint(
            g2d);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Wj4pAAA=");
}
