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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DbCLE1xPVrHlL7B5nJMWVff5VfF1DhYdw7mkzQPpZU18l3KgN/6WzEXzyzBI" +
       "uq4Ho1/d8cru06J6aMBypZCzfaUKlDW+S4R2bPLS7Nz3PslJfdIwNEb1EktY" +
       "ZHbxGuT019ze9tM7OmsGoY4aIg05Xb05x4ZSxbVEvZ1L+hblXeaKDv+KMP1x" +
       "ElrlnsmEK/14ulBomRAh//JTd6VKrFUc4pUqY69i8yIn7RB4w0y3hS+UwaGX" +
       "pguH8LSxz9Fp39TNUYm1ispvVRn7MzZvcDLbbw4XiXDs+55J3pwusOmB53ZH" +
       "r9unbpJKrJUr3J8JqWer2OV9bN7l4itT0Eue9kxyZjpLmyOOXkembpJKrJVN" +
       "sk5I/aiySUJCzr9l0T/snuJ9ZcyH01nt3ucodN/UbVGJtYqqzVXGWrCpk9Vu" +
       "wQwecITq/x9myANABb9n4I3bvJJPpPKznvLIsbaGuceuf0UctAuf3mZCrhrN" +
       "aZr/Tsj3XmdabFQVJpwpb4hMoWIX4EG5+wZOaqDFNYdmS0pI2u1BSqhyxX8/" +
       "3UJOmjw6Turki5+kG6QDCb4uMd2KoF1UBHgpFpGXYnlZLCz02094X9f5zF5g" +
       "8V+c41FVfJx2M25Ofp4eUU4eu3bLLWfX3S8v7hWNTk6ilGbIs/IbgpPo/SfF" +
       "oDRXVt2mledaH21c7p4UO+SCPddd6EOefghIE/d6QeBW2+4tXG6/evyKJ391" +
       "oO5FOBTvJCEKh5KdpdeHeTNnkcU7Y6X1xA5qiev2vpXf3HPVhaN//4O4oCWy" +
       "/lhUmX5EefmBG186NO94d5g0D5EZcAhmeXGvec0eHerTcSsBRZg9kIclghSV" +
       "akXFSiu6JcXP1sIujjlbCr342YeTntLDfenHsibNmGCWyFMoBsqdZq9H7kzg" +
       "oiVnmgEGr8dXsz2PTV7UGuCPI7HNpuleFtSeM0V0ni4Hn6eFD68Rr/h26f8A" +
       "W/Dd7rgiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
