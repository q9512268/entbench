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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cJDfnxkVU869mxupxR3OyzRC05rsDuALs3adwuy1AJ71pl3Xez3VdqvcSoL7" +
       "i6eEKCuwWIEjymMF5r7Dmm+B1xM5bl18mCfNqO3wY7fan4VrfjawRuXj38xK" +
       "VM7mlsDTZ0rUV0A9rPl2rjL8UD0CW6mbvUO9ODNbL8KWgA3QBZudtLMuJ/n9" +
       "Aur6EWu+S5l/Aw77SKCTeL6cN2FQEeO2Ap/6uBS4FJ6kqYXk+BXoh5pfgez1" +
       "Gb7q+QI6+gVrzlFUyXXUS6CKAiWxwWdthfz041JIEzz7Tan2j18hfqi3Ushr" +
       "BRRyiTW/pqicK6Q9I9IcdVz4ODfYUVOmo+NXhx/qrdTxZgF1vMWay9YeWqvh" +
       "ZDJHH1f+F/rIUFSX916XXULMyPmWZHz/EJ44UV06/cTmSzzrZb9RVED+SqQl" +
       "yXlMdvSLoWhIiFy8CuPQbBTub1M0y//WGUpjaDn71wz4dyialh8eDsv83wn9" +
       "V4pqvNAAx/+dcO/BsdmGg9rW6DhBPgBeAIR1/6FagbK5wIW5rc3WOFahnwm4" +
       "65SsLetuZUtHabPQVRLwr4JW+k4b3wWjwpkT67v33Fj5iHFrKkh4ZIStUg7n" +
       "K+NuNlsCLPBdzVqreF3TzaonJy2yiiXXra2TN+5R4OL8hnOW5xpRb8zeJr4+" +
       "tur5X44WvwInyq0ogCmasjX3hiajpqH22hrJPUdCucTvN1uavjG8ujnxzu/5" +
       "HRgyzp1z/OGjwsWT2149PGOsPojKO9FEqANJhl8drR2We4kwqPWjSlGH2KNT" +
       "WEXEkuuQWsXcHLPvhVwvpjors6PsOp2ihtwzeu5HiDJJGSLaGiUt8z0Nx9xy" +
       "e8QqBV1VVFpVPQj2iONaQjQSLLMG+Go00qWq1l10ebvKt/xO31NmoIJ3Wa/y" +
       "vweTOZExIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KgAA");
}
