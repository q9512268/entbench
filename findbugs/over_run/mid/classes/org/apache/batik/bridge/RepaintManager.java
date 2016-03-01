package org.apache.batik.bridge;
public class RepaintManager {
    static final int COPY_OVERHEAD = 10000;
    static final int COPY_LINE_OVERHEAD = 10;
    protected org.apache.batik.gvt.renderer.ImageRenderer renderer;
    public RepaintManager(org.apache.batik.gvt.renderer.ImageRenderer r) {
        super(
          );
        renderer =
          r;
    }
    public java.util.Collection updateRendering(java.util.Collection areas)
          throws java.lang.InterruptedException { renderer.flush(areas);
                                                  java.util.List rects = new java.util.ArrayList(
                                                    areas.
                                                      size(
                                                        ));
                                                  java.awt.geom.AffineTransform at =
                                                    renderer.
                                                    getTransform(
                                                      );
                                                  java.util.Iterator i =
                                                    areas.
                                                    iterator(
                                                      );
                                                  while (i.
                                                           hasNext(
                                                             )) {
                                                      java.awt.Shape s =
                                                        (java.awt.Shape)
                                                          i.
                                                          next(
                                                            );
                                                      s =
                                                        at.
                                                          createTransformedShape(
                                                            s);
                                                      java.awt.geom.Rectangle2D r2d =
                                                        s.
                                                        getBounds2D(
                                                          );
                                                      int x0 =
                                                        (int)
                                                          java.lang.Math.
                                                          floor(
                                                            r2d.
                                                              getX(
                                                                ));
                                                      int y0 =
                                                        (int)
                                                          java.lang.Math.
                                                          floor(
                                                            r2d.
                                                              getY(
                                                                ));
                                                      int x1 =
                                                        (int)
                                                          java.lang.Math.
                                                          ceil(
                                                            r2d.
                                                              getX(
                                                                ) +
                                                              r2d.
                                                              getWidth(
                                                                ));
                                                      int y1 =
                                                        (int)
                                                          java.lang.Math.
                                                          ceil(
                                                            r2d.
                                                              getY(
                                                                ) +
                                                              r2d.
                                                              getHeight(
                                                                ));
                                                      java.awt.Rectangle r =
                                                        new java.awt.Rectangle(
                                                        x0 -
                                                          1,
                                                        y0 -
                                                          1,
                                                        x1 -
                                                          x0 +
                                                          3,
                                                        y1 -
                                                          y0 +
                                                          3);
                                                      rects.
                                                        add(
                                                          r);
                                                  }
                                                  org.apache.batik.ext.awt.geom.RectListManager devRLM =
                                                    null;
                                                  try {
                                                      devRLM =
                                                        new org.apache.batik.ext.awt.geom.RectListManager(
                                                          rects);
                                                      devRLM.
                                                        mergeRects(
                                                          COPY_OVERHEAD,
                                                          COPY_LINE_OVERHEAD);
                                                  }
                                                  catch (java.lang.Exception e) {
                                                      e.
                                                        printStackTrace(
                                                          );
                                                  }
                                                  renderer.
                                                    repaint(
                                                      devRLM);
                                                  return devRLM;
    }
    public void setupRenderer(java.awt.geom.AffineTransform u2d,
                              boolean dbr,
                              java.awt.Shape aoi,
                              int width,
                              int height) {
        renderer.
          setTransform(
            u2d);
        renderer.
          setDoubleBuffered(
            dbr);
        renderer.
          updateOffScreen(
            width,
            height);
        renderer.
          clearOffScreen(
            );
    }
    public java.awt.image.BufferedImage getOffScreen() {
        return renderer.
          getOffScreen(
            );
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
       "lJzEkiC0vNB/Mew57PEvnbq99112SeeWveyQzrYJUC9Hl/WHL/mg8oFq4Hnx" +
       "2DxfvOyDql3jIOMSpSMGRHlgP3nit/7ea3/4qc80r5ZGcG1bog64cvNsHJeV" +
       "0emPvv6FZ97xyrd/rHISEPR9N0ug7Wr556ryVll8XyXfq8B9JFWMmwJK7ED2" +
       "jt3IH4HfFfD83/Ip8SsbDkHBE9RxZPKB09AkApvioxQ/Wd3m570Z3Wt331xv" +
       "JrHtAwe5PQ7OkJef+Jb7E7/9c4fA67KSXBqsf/aVv/ZHR5975eq5cPdDd0Sc" +
       "5+ccQt5KCo+WxbA0u+febJVqRv+/ffXlf/YzL3/mgNUTF4O3Hvg2+bl/93++" +
       "cfTlb3/9LhHCfSAKOOwkZYmVRefAWfKeNvjRixryEfDAxxoC30VDygpVOvqy" +
       "sriHeMsqXRZMRf6wlF4pJpbheqeyKnsml7Bd/vGxfaxsff5Yp090+yK2UFW5" +
       "fXckwRb2UBSHKbA6XTtB88ETr12+1y4h94m3RO4g5isA9LX6EXlUATDvvvx9" +
       "ZfXP3smopxxPvXWi6nPw0Qcc2S3HI082m3N2d/hSuoTk8I+NJNDGx86AsSH4" +
       "6Pqx//r5b/zND30LaNbwxNLL0V3ArckXezc/Xr5Eb4+ep0t6hCpgZuUkHVfb" +
       "tK6dkjQ+h/Q0BZt9+CcgKb3xbRpLmPbJj0XXeqMjoTMXyXb9ydTDmWkH60yT" +
       "toWNMKmp9adyaHbMKHVFkUpDJVa3y7Suwstsu9bI/W7Nsv2FOkqFujPimHi2" +
       "8NOFmZp1htTmcSpwk2ha1NEub9cm3gblPR4lwn0zVAZebNRhFSa1DDEyxS6c" +
       "orlP6sokMHij2C5Jo4XXVGMFS4vdOuKEacqslisx5ORQcOohPoxqkrAcecGi" +
       "b9ncTjHg1gpThhEcN6ya21d5V3GFne4vh6GVSBtbTlbKsF0Tcl8WRyhsWxzG" +
       "bEJBQDeOG41rytwau1mhp6PBJjFHREsS+21/MOxy1MBeDkRqoa8UkW6E1Mya" +
       "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" +
       "VXbz/wFFypvy0ygAAA==");
}
