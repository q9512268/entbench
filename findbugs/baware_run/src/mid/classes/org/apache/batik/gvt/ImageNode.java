package org.apache.batik.gvt;
public class ImageNode extends org.apache.batik.gvt.CompositeGraphicsNode {
    protected boolean hitCheckChildren = false;
    public ImageNode() { super(); }
    public void setVisible(boolean isVisible) { fireGraphicsNodeChangeStarted(
                                                  );
                                                this.isVisible = isVisible;
                                                invalidateGeometryCache();
                                                fireGraphicsNodeChangeCompleted(
                                                  ); }
    public java.awt.geom.Rectangle2D getPrimitiveBounds() { if (!isVisible)
                                                                return null;
                                                            return super.
                                                              getPrimitiveBounds(
                                                                );
    }
    public void setHitCheckChildren(boolean hitCheckChildren) { this.
                                                                  hitCheckChildren =
                                                                  hitCheckChildren;
    }
    public boolean getHitCheckChildren() { return hitCheckChildren;
    }
    public void paint(java.awt.Graphics2D g2d) { if (isVisible) {
                                                     super.
                                                       paint(
                                                         g2d);
                                                 }
    }
    public boolean contains(java.awt.geom.Point2D p) {
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case VISIBLE_FILL:
            case VISIBLE_STROKE:
            case VISIBLE:
                return isVisible &&
                  super.
                  contains(
                    p);
            case PAINTED:
            case FILL:
            case STROKE:
            case ALL:
                return super.
                  contains(
                    p);
            case NONE:
                return false;
            default:
                return false;
        }
    }
    public org.apache.batik.gvt.GraphicsNode nodeHitAt(java.awt.geom.Point2D p) {
        if (hitCheckChildren)
            return super.
              nodeHitAt(
                p);
        return contains(
                 p)
          ? this
          : null;
    }
    public void setImage(org.apache.batik.gvt.GraphicsNode newImage) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        if (count ==
              0)
            ensureCapacity(
              1);
        children[0] =
          newImage;
        ((org.apache.batik.gvt.AbstractGraphicsNode)
           newImage).
          setParent(
            this);
        ((org.apache.batik.gvt.AbstractGraphicsNode)
           newImage).
          setRoot(
            getRoot(
              ));
        count =
          1;
        fireGraphicsNodeChangeCompleted(
          );
    }
    public org.apache.batik.gvt.GraphicsNode getImage() {
        if (count >
              0) {
            return children[0];
        }
        else {
            return null;
        }
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
       "NyoAAA==");
}
