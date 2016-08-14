package org.apache.batik.swing.gvt;
public abstract class AbstractResetTransformInteractor implements org.apache.batik.swing.gvt.Interactor {
    protected boolean finished = true;
    public boolean endInteraction() { return finished; }
    public void keyTyped(java.awt.event.KeyEvent e) { resetTransform(e); }
    public void keyPressed(java.awt.event.KeyEvent e) { resetTransform(e);
    }
    public void keyReleased(java.awt.event.KeyEvent e) { resetTransform(e);
    }
    public void mouseClicked(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mousePressed(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseReleased(java.awt.event.MouseEvent e) { resetTransform(
                                                               e); }
    public void mouseEntered(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseExited(java.awt.event.MouseEvent e) { resetTransform(
                                                             e); }
    public void mouseDragged(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseMoved(java.awt.event.MouseEvent e) { resetTransform(
                                                            e); }
    protected void resetTransform(java.awt.event.InputEvent e) { org.apache.batik.swing.gvt.JGVTComponent c =
                                                                   (org.apache.batik.swing.gvt.JGVTComponent)
                                                                     e.
                                                                     getSource(
                                                                       );
                                                                 c.
                                                                   resetRenderingTransform(
                                                                     );
                                                                 finished =
                                                                   true;
    }
    public AbstractResetTransformInteractor() { super(
                                                  );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+/x/ANmxxCOrIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UsU/fuwffs/fe+VL1aWA/wMSkwa2KC4AAA==");
}
