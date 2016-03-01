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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wXI8PzfyRN3Z1h9e+c67P5/4fpEZ5pdk5zKfXs0/uuTorj9/nLYSnMUypCA+" +
       "/f7wySO1rfd8wPUdOmHaC5PpIQcI19H9zIn434L1hb8KoqJ+VClYSfEmLCfY" +
       "Tu6HRNCwM2VInD3t3qTOzGCaU3Q5x09lrmH9ROaEOqgzaVYv86GunK3iPHhu" +
       "t1B3ux91AcQr7VxlES8/xYplNp9M03SVwiyJmEx1y8FRlqNbiopjkiIZQ0Tk" +
       "W8sFAnbq6k1A9O3WpTjQ4rCVE56pntj+y6KxtXa+l0nFlNxgdF54rv29AU67" +
       "xSyQ9tnmu0Jkiz7oovNKVixneywHxHwzCo9XvbPtyPunzBn58eQTJnsO7P0k" +
       "tO+ASYdm3r8wLfV265i5v292C3KNwjXWvXdm/GdPju82Z1XlzWLb4JB26vV/" +
       "/SZ0+I8vZUiIiqKqKhOspPZ5IJXEVPsdbppV2HT07zu+9kYXRN0OVJxQpO0J" +
       "0iF60VdkJKKuFXBOFQ4iLQNZ8KEosFTTrMDKypWs6DDB1ZyVldZ4Mb0InkYL" +
       "fI1ZML3FxDQrNqRDN5s2ZSdNcDmWe9yU0mUtEfvqcdU3QcQVVQi5xO9U9vN+" +
       "v504h53JLHuQVRudzcc/hTkiiYuCEcPU3GwnOI6n47sOHBO7nmgKWgHxi7Dl" +
       "qaotl8kwkV1dFXJ0+tm8k59bHWpceWki78pjNaXpSS7rqS5LCrs0+570D3B+" +
       "119r++4Z2jKF7HWez35/lz/qPPnSvYuFx4L86G0ycdqR3avU7N0BJTqhCV3x" +
       "Yr4+tWIz2UosgKfJWrEmP2IdlHC4xr1wLcmhmiO1Gc/RtoMVSYrK4bhqH36s" +
       "DPULDlpHJ9uVnlyBvVjNX9PU/KezpqXw3G3N/+6pm55N1WeezWXsdw1Ft/K0" +
       "BY8ApoaJQoHTEgZpY1U+5NdzOOcbrHiYMqyCDrs/NIiYaefnD6uS6LjrkZvj" +
       "rmXwtFs2t0/dXdlUM7uL/dzLe308h0eOsOIgRWXcIz0Eggi4hL38pmP+oZtj" +
       "/hJ4+iwb+qZufjbVycz/QQ7zn2TFdymazs1vS0o0zfjv3bytIlgWCFM3Ppvq" +
       "ZMY/ncP4Z1hxyt4Na3U8OJhm/en/2fo61rQcHtkyQZ7E+gwhPZuqz7g8Po88" +
       "myiqUkSxVooTxfgvIn6eZN2BZwz3L/DybA6XnmfFTyHT0PntU58OKRm7l7Cn" +
       "NDc1pUGixkMtMUimfVLc7c9N3e3A+TXZ7r7Yaa8m7VLevEgWTh+rKJ597L7f" +
       "8/uX1GVvKWTgsYQsuw8jrnqhppOYxG0uNY8mZub3O4pqs1/OgYOh5AZcMOVf" +
       "pag6szxFBfzbLf06RZV+aZDj3265yxSVOHKQyJkVt8gfYC4gwqpvafbyNOa4" +
       "V3S82SJiDerJgDcfSy3erMkWz5XCLfQkSPzvFTuZSZh/sMAB6tj6jQ9ev+sJ" +
       "8zZKkPHYGOtlOiTo5p1XKiFakLU3u6/C9iU3yp+atshOCj23Ye65cUwB+vnN" +
       "Ua3vesZoSN3SXD6+6uwrewovwaFkMwpgimZuTj8HJ7UEZGubI5mOIpAu8puj" +
       "5pJ3t1z4+M1AFb9uQObhpS6XxoCw/+yV7pimPR5E0zpQAeS8JMkP6WtHlR4i" +
       "DOuek01hVE0oqX9iyhnQMfvrhXvGcmhZ6i27qKSoPv2gl355WyKrI0Rfw3pn" +
       "3ZT5UsiEprlbuWc3m7TDPA04HIh0app1f1e8inte0/iuvsbJ5z/5/dt7Qx0A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "N/Obmv8FZgwGxHQoAAA=");
}
