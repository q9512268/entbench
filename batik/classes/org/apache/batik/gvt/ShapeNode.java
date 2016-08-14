package org.apache.batik.gvt;
public class ShapeNode extends org.apache.batik.gvt.AbstractGraphicsNode {
    protected java.awt.Shape shape;
    protected org.apache.batik.gvt.ShapePainter shapePainter;
    private java.awt.geom.Rectangle2D primitiveBounds;
    private java.awt.geom.Rectangle2D geometryBounds;
    private java.awt.geom.Rectangle2D sensitiveBounds;
    private java.awt.Shape paintedArea;
    private java.awt.Shape sensitiveArea;
    public ShapeNode() { super(); }
    public void setShape(java.awt.Shape newShape) { fireGraphicsNodeChangeStarted(
                                                      );
                                                    invalidateGeometryCache(
                                                      );
                                                    this.shape = newShape;
                                                    if (this.shapePainter !=
                                                          null) {
                                                        if (newShape !=
                                                              null) {
                                                            this.
                                                              shapePainter.
                                                              setShape(
                                                                newShape);
                                                        }
                                                        else {
                                                            this.
                                                              shapePainter =
                                                              null;
                                                        }
                                                    }
                                                    fireGraphicsNodeChangeCompleted(
                                                      ); }
    public java.awt.Shape getShape() { return shape; }
    public void setShapePainter(org.apache.batik.gvt.ShapePainter newShapePainter) {
        if (shape ==
              null)
            return;
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          shapePainter =
          newShapePainter;
        if (shapePainter !=
              null &&
              shape !=
              this.
                shapePainter.
              getShape(
                )) {
            shapePainter.
              setShape(
                shape);
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public org.apache.batik.gvt.ShapePainter getShapePainter() {
        return shapePainter;
    }
    public void paint(java.awt.Graphics2D g2d) { if (isVisible)
                                                     super.
                                                       paint(
                                                         g2d);
    }
    public void primitivePaint(java.awt.Graphics2D g2d) {
        if (shapePainter !=
              null) {
            shapePainter.
              paint(
                g2d);
        }
    }
    protected void invalidateGeometryCache() { super.
                                                 invalidateGeometryCache(
                                                   );
                                               primitiveBounds =
                                                 null;
                                               geometryBounds =
                                                 null;
                                               sensitiveBounds =
                                                 null;
                                               paintedArea =
                                                 null;
                                               sensitiveArea =
                                                 null;
    }
    public void setPointerEventType(int pointerEventType) {
        super.
          setPointerEventType(
            pointerEventType);
        sensitiveBounds =
          null;
        sensitiveArea =
          null;
    }
    public boolean contains(java.awt.geom.Point2D p) {
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case VISIBLE_FILL:
            case VISIBLE_STROKE:
            case VISIBLE:
                if (!isVisible)
                    return false;
            case PAINTED:
            case FILL:
            case STROKE:
            case ALL:
                {
                    java.awt.geom.Rectangle2D b =
                      getSensitiveBounds(
                        );
                    if (b ==
                          null ||
                          !b.
                          contains(
                            p))
                        return false;
                    return inSensitiveArea(
                             p);
                }
            case NONE:
            default:
                return false;
        }
    }
    public boolean intersects(java.awt.geom.Rectangle2D r) {
        java.awt.geom.Rectangle2D b =
          getBounds(
            );
        if (b !=
              null) {
            return b.
              intersects(
                r) &&
              paintedArea !=
              null &&
              paintedArea.
              intersects(
                r);
        }
        return false;
    }
    public java.awt.geom.Rectangle2D getPrimitiveBounds() {
        if (!isVisible)
            return null;
        if (shape ==
              null)
            return null;
        if (primitiveBounds !=
              null)
            return primitiveBounds;
        if (shapePainter ==
              null)
            primitiveBounds =
              shape.
                getBounds2D(
                  );
        else
            primitiveBounds =
              shapePainter.
                getPaintedBounds2D(
                  );
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                )) {
            invalidateGeometryCache(
              );
        }
        return primitiveBounds;
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) {
        if (shapePainter ==
              null)
            return false;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else {
                    return false;
                }
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                return shapePainter.
                  inPaintedArea(
                    pt);
            case VISIBLE:
            case ALL:
                return shapePainter.
                  inSensitiveArea(
                    pt);
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null)
                    return fillShapePainter.
                      inSensitiveArea(
                        pt);
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null)
                    return strokeShapePainter.
                      inSensitiveArea(
                        pt);
                break;
            case NONE:
            default:
        }
        return false;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds() {
        if (sensitiveBounds !=
              null)
            return sensitiveBounds;
        if (shapePainter ==
              null)
            return null;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else
                    return null;
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                sensitiveBounds =
                  shapePainter.
                    getPaintedBounds2D(
                      );
                break;
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null) {
                    sensitiveBounds =
                      fillShapePainter.
                        getSensitiveBounds2D(
                          );
                }
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null) {
                    sensitiveBounds =
                      strokeShapePainter.
                        getSensitiveBounds2D(
                          );
                }
                break;
            case VISIBLE:
            case ALL:
                sensitiveBounds =
                  shapePainter.
                    getSensitiveBounds2D(
                      );
                break;
            case NONE:
            default:
        }
        return sensitiveBounds;
    }
    public java.awt.Shape getSensitiveArea() {
        if (sensitiveArea !=
              null)
            return sensitiveArea;
        if (shapePainter ==
              null)
            return null;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else
                    return null;
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                sensitiveArea =
                  shapePainter.
                    getPaintedArea(
                      );
                break;
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null) {
                    sensitiveArea =
                      fillShapePainter.
                        getSensitiveArea(
                          );
                }
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null) {
                    sensitiveArea =
                      strokeShapePainter.
                        getSensitiveArea(
                          );
                }
                break;
            case VISIBLE:
            case ALL:
                sensitiveArea =
                  shapePainter.
                    getSensitiveArea(
                      );
                break;
            case NONE:
            default:
        }
        return sensitiveArea;
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() {
        if (geometryBounds ==
              null) {
            if (shape ==
                  null) {
                return null;
            }
            geometryBounds =
              normalizeRectangle(
                shape.
                  getBounds2D(
                    ));
        }
        return geometryBounds;
    }
    public java.awt.Shape getOutline() { return shape;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4NvnoPvvefKtsHTv0Skxcx2Yf3QTMIsT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+fwU/hf3MH/xzcLEXtd8/9c5Zd/Lk/8Rlh7WnUi0dFkMFXx/rozlZ/hnoP7p" +
       "zWq0DZ5X91BfvfVmfGasuA0oK69zcPHGIji4lCclYP8gSDFu4by9SHHCw6Hy" +
       "GP7BwU3AfyDP/D7w/Noe/q/9pXjxQ6cvLhSAdn588OA5QngkTy6DoWh/rye4" +
       "njjvXLmupYjOsUCu3KxAHgPP1/cC+fot93ChwPbMObjfnSdPhPs71EF+BTXP" +
       "efQY4pM3AfHhPPNZ8PzhHuIf3hqIJxHA55RV8+S5sHQ/GJyY0xddCvEco/yB" +
       "m1VkPhP/7h7ld2+1Ig8eKuC87xyo78+TVlhc1z9zjeKkNtu3QJsH++tHB9dc" +
       "P7p5bQ7OKSPzpLvTJnudCzbHKHs3Oyl+EjBs71Hatx4lf07ZPE+YsHTlJMqj" +
       "CzHHGCc3q0mw2jn4wh7jF249RvGcMilPfhgskwFG/NprXMcgf+RmFQkGnIMv" +
       "70F++daDtM8py/9lcLAGoRWApLdh/p+EMyrU3wy6BCzOjy7i57eKH7nmbzy7" +
       "v55IX3z58l0Pv8z/2+Iu+tHfQ+6mSnepW8s6eQn0xPsdnq+oegH47t2VUK9A" +
       "EYWlB693pRFMLkBaDBbbHWUKbPYsJZgYF98n6X4MiOSYLizdsXs5SfIR0Dog" +
       "yV9f9A5H9meve7MSXQWhL0rh4Zw9l06ymw08ctIuiunb/a8n8BNbJ+86teFR" +
       "/LPqcHNiu/tv1QvSqy8Pxz/6ncYv7G7PS5aYZXkrd1GlO3cX+YtG8w2OJ2/Y" +
       "2mFbdxDPfu/eL939zOFmzL07ho9t9ARv77z+VfWe7YXF5fLsHz7893/wl17+" +
       "g+Ji2P8Dw+HM4/I2AAA=");
}
