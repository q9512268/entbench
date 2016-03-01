package org.apache.batik.gvt;
public class StrokeShapePainter implements org.apache.batik.gvt.ShapePainter {
    protected java.awt.Shape shape;
    protected java.awt.Shape strokedShape;
    protected java.awt.Stroke stroke;
    protected java.awt.Paint paint;
    public StrokeShapePainter(java.awt.Shape shape) { super();
                                                      if (shape == null) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            );
                                                      }
                                                      this.shape =
                                                        shape; }
    public void setStroke(java.awt.Stroke newStroke) { this.stroke =
                                                         newStroke;
                                                       this.strokedShape =
                                                         null; }
    public java.awt.Stroke getStroke() { return stroke; }
    public void setPaint(java.awt.Paint newPaint) { this.paint = newPaint;
    }
    public java.awt.Paint getPaint() { return paint; }
    public void paint(java.awt.Graphics2D g2d) { if (stroke != null &&
                                                       paint !=
                                                       null) { g2d.
                                                                 setPaint(
                                                                   paint);
                                                               g2d.
                                                                 setStroke(
                                                                   stroke);
                                                               g2d.
                                                                 draw(
                                                                   shape);
                                                 } }
    public java.awt.Shape getPaintedArea() { if (paint == null ||
                                                   stroke ==
                                                   null) return null;
                                             if (strokedShape == null)
                                                 strokedShape =
                                                   stroke.
                                                     createStrokedShape(
                                                       shape);
                                             return strokedShape;
    }
    public java.awt.geom.Rectangle2D getPaintedBounds2D() { java.awt.Shape painted =
                                                              getPaintedArea(
                                                                );
                                                            if (painted ==
                                                                  null)
                                                                return null;
                                                            return painted.
                                                              getBounds2D(
                                                                );
    }
    public boolean inPaintedArea(java.awt.geom.Point2D pt) {
        java.awt.Shape painted =
          getPaintedArea(
            );
        if (painted ==
              null)
            return false;
        return painted.
          contains(
            pt);
    }
    public java.awt.Shape getSensitiveArea() { if (stroke ==
                                                     null)
                                                   return null;
                                               if (strokedShape ==
                                                     null)
                                                   strokedShape =
                                                     stroke.
                                                       createStrokedShape(
                                                         shape);
                                               return strokedShape;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds2D() {
        java.awt.Shape sensitive =
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return null;
        return sensitive.
          getBounds2D(
            );
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) {
        java.awt.Shape sensitive =
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return false;
        return sensitive.
          contains(
            pt);
    }
    public void setShape(java.awt.Shape shape) { if (shape ==
                                                       null) {
                                                     throw new java.lang.IllegalArgumentException(
                                                       );
                                                 }
                                                 this.
                                                   shape =
                                                   shape;
                                                 this.
                                                   strokedShape =
                                                   null;
    }
    public java.awt.Shape getShape() { return shape;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "X3HNaxquv1Af/jjzP+afbBfVJAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7+lC6OLu4yQJ2LTeA0jyz753NDWcePWw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("e+WU7maNx05aQRHRr30/AR83Ofk2Md8gFs/tjzZz0e7B/UvyF18nRx/8TuMX" +
       "dm8jZUvMsryX+yjo0u6ZZtFpviF89ra9HfV1kXj+uw/96v3vOtq8PrRjeG+R" +
       "J3h7+tYPEXu2FxZPB7N/+OiX3veLr/9e8ezj/wJG/f9LBzEAAA==");
}
