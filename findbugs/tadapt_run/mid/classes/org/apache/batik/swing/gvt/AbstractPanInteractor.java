package org.apache.batik.swing.gvt;
public abstract class AbstractPanInteractor extends org.apache.batik.swing.gvt.InteractorAdapter {
    public static final java.awt.Cursor PAN_CURSOR = new java.awt.Cursor(
      java.awt.Cursor.
        MOVE_CURSOR);
    protected boolean finished = true;
    protected int xStart;
    protected int yStart;
    protected int xCurrent;
    protected int yCurrent;
    protected java.awt.Cursor previousCursor;
    public boolean endInteraction() { return finished; }
    public void mousePressed(java.awt.event.MouseEvent e) { if (!finished) {
                                                                mouseExited(
                                                                  e);
                                                                return;
                                                            }
                                                            finished = false;
                                                            xStart = e.getX(
                                                                         );
                                                            yStart = e.getY(
                                                                         );
                                                            org.apache.batik.swing.gvt.JGVTComponent c =
                                                              (org.apache.batik.swing.gvt.JGVTComponent)
                                                                e.
                                                                getSource(
                                                                  );
                                                            previousCursor =
                                                              c.
                                                                getCursor(
                                                                  );
                                                            c.
                                                              setCursor(
                                                                PAN_CURSOR);
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        if (finished) {
            return;
        }
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        xCurrent =
          e.
            getX(
              );
        yCurrent =
          e.
            getY(
              );
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            xCurrent -
              xStart,
            yCurrent -
              yStart);
        java.awt.geom.AffineTransform rt =
          (java.awt.geom.AffineTransform)
            c.
            getRenderingTransform(
              ).
            clone(
              );
        rt.
          preConcatenate(
            at);
        c.
          setRenderingTransform(
            rt);
        if (c.
              getCursor(
                ) ==
              PAN_CURSOR) {
            c.
              setCursor(
                previousCursor);
        }
    }
    public void mouseExited(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        c.
          setPaintingTransform(
            null);
        if (c.
              getCursor(
                ) ==
              PAN_CURSOR) {
            c.
              setCursor(
                previousCursor);
        }
    }
    public void mouseDragged(java.awt.event.MouseEvent e) {
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        xCurrent =
          e.
            getX(
              );
        yCurrent =
          e.
            getY(
              );
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            xCurrent -
              xStart,
            yCurrent -
              yStart);
        c.
          setPaintingTransform(
            at);
    }
    public AbstractPanInteractor() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pP4H+o6KUVofAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ty99vTwL+X9so7zs0ioAAA==");
}
