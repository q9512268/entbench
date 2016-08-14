package org.apache.batik.swing.gvt;
public class AbstractRotateInteractor extends org.apache.batik.swing.gvt.InteractorAdapter {
    protected boolean finished;
    protected double initialRotation;
    public boolean endInteraction() { return finished; }
    public void mousePressed(java.awt.event.MouseEvent e) { finished = false;
                                                            org.apache.batik.swing.gvt.JGVTComponent c =
                                                              (org.apache.batik.swing.gvt.JGVTComponent)
                                                                e.
                                                                getSource(
                                                                  );
                                                            java.awt.Dimension d =
                                                              c.
                                                              getSize(
                                                                );
                                                            double dx =
                                                              e.
                                                              getX(
                                                                ) -
                                                              d.
                                                                width /
                                                              2;
                                                            double dy =
                                                              e.
                                                              getY(
                                                                ) -
                                                              d.
                                                                height /
                                                              2;
                                                            double cos =
                                                              -dy /
                                                              java.lang.Math.
                                                              sqrt(
                                                                dx *
                                                                  dx +
                                                                  dy *
                                                                  dy);
                                                            initialRotation =
                                                              dx >
                                                                0
                                                                ? java.lang.Math.
                                                                acos(
                                                                  cos)
                                                                : -java.lang.Math.
                                                                acos(
                                                                  cos);
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        java.awt.geom.AffineTransform at =
          rotateTransform(
            c.
              getSize(
                ),
            e.
              getX(
                ),
            e.
              getY(
                ));
        at.
          concatenate(
            c.
              getRenderingTransform(
                ));
        c.
          setRenderingTransform(
            at);
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
    }
    public void mouseDragged(java.awt.event.MouseEvent e) {
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        c.
          setPaintingTransform(
            rotateTransform(
              c.
                getSize(
                  ),
              e.
                getX(
                  ),
              e.
                getY(
                  )));
    }
    protected java.awt.geom.AffineTransform rotateTransform(java.awt.Dimension d,
                                                            int x,
                                                            int y) {
        double dx =
          x -
          d.
            width /
          2;
        double dy =
          y -
          d.
            height /
          2;
        double cos =
          -dy /
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        double angle =
          dx >
          0
          ? java.lang.Math.
          acos(
            cos)
          : -java.lang.Math.
          acos(
            cos);
        angle -=
          initialRotation;
        return java.awt.geom.AffineTransform.
          getRotateInstance(
            angle,
            d.
              width /
              2,
            d.
              height /
              2);
    }
    public AbstractRotateInteractor() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
