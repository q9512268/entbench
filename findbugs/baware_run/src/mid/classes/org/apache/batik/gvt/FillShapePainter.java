package org.apache.batik.gvt;
public class FillShapePainter implements org.apache.batik.gvt.ShapePainter {
    protected java.awt.Shape shape;
    protected java.awt.Paint paint;
    public FillShapePainter(java.awt.Shape shape) { super();
                                                    if (shape == null) throw new java.lang.IllegalArgumentException(
                                                                         "Shape can not be null!");
                                                    this.shape = shape;
    }
    public void setPaint(java.awt.Paint newPaint) { this.paint = newPaint;
    }
    public java.awt.Paint getPaint() { return paint; }
    public void paint(java.awt.Graphics2D g2d) { if (paint != null) {
                                                     g2d.
                                                       setPaint(
                                                         paint);
                                                     g2d.
                                                       fill(
                                                         shape);
                                                 } }
    public java.awt.Shape getPaintedArea() { if (paint == null) return null;
                                             return shape; }
    public java.awt.geom.Rectangle2D getPaintedBounds2D() { if (paint ==
                                                                  null ||
                                                                  shape ==
                                                                  null)
                                                                return null;
                                                            return shape.
                                                              getBounds2D(
                                                                );
    }
    public boolean inPaintedArea(java.awt.geom.Point2D pt) { if (paint ==
                                                                   null ||
                                                                   shape ==
                                                                   null)
                                                                 return false;
                                                             return shape.
                                                               contains(
                                                                 pt);
    }
    public java.awt.Shape getSensitiveArea() { return shape; }
    public java.awt.geom.Rectangle2D getSensitiveBounds2D() { if (shape ==
                                                                    null)
                                                                  return null;
                                                              return shape.
                                                                getBounds2D(
                                                                  );
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) { if (shape ==
                                                                     null)
                                                                   return false;
                                                               return shape.
                                                                 contains(
                                                                   pt);
    }
    public void setShape(java.awt.Shape shape) { if (shape == null) {
                                                     throw new java.lang.IllegalArgumentException(
                                                       );
                                                 }
                                                 this.shape =
                                                   shape;
    }
    public java.awt.Shape getShape() { return shape; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cvl1IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
