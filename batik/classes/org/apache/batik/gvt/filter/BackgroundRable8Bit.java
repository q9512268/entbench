package org.apache.batik.gvt.filter;
public class BackgroundRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable {
    private org.apache.batik.gvt.GraphicsNode node;
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() { return node;
    }
    public void setGraphicsNode(org.apache.batik.gvt.GraphicsNode node) {
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
    }
    public BackgroundRable8Bit(org.apache.batik.gvt.GraphicsNode node) { super(
                                                                           );
                                                                         if (node ==
                                                                               null)
                                                                             throw new java.lang.IllegalArgumentException(
                                                                               );
                                                                         this.
                                                                           node =
                                                                           node;
    }
    static java.awt.geom.Rectangle2D addBounds(org.apache.batik.gvt.CompositeGraphicsNode cgn,
                                               org.apache.batik.gvt.GraphicsNode child,
                                               java.awt.geom.Rectangle2D init) {
        java.util.List children =
          cgn.
          getChildren(
            );
        java.util.Iterator i =
          children.
          iterator(
            );
        java.awt.geom.Rectangle2D r2d =
          null;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.gvt.GraphicsNode gn =
              (org.apache.batik.gvt.GraphicsNode)
                i.
                next(
                  );
            if (gn ==
                  child)
                break;
            java.awt.geom.Rectangle2D cr2d =
              gn.
              getBounds(
                );
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                cr2d =
                  at.
                    createTransformedShape(
                      cr2d).
                    getBounds2D(
                      );
            if (r2d ==
                  null)
                r2d =
                  (java.awt.geom.Rectangle2D)
                    cr2d.
                    clone(
                      );
            else
                r2d.
                  add(
                    cr2d);
        }
        if (r2d ==
              null) {
            if (init ==
                  null)
                return org.apache.batik.gvt.CompositeGraphicsNode.
                         VIEWPORT;
            return init;
        }
        if (init ==
              null)
            return r2d;
        init.
          add(
            r2d);
        return init;
    }
    static java.awt.geom.Rectangle2D getViewportBounds(org.apache.batik.gvt.GraphicsNode gn,
                                                       org.apache.batik.gvt.GraphicsNode child) {
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        if (r2d ==
              null)
            r2d =
              getViewportBounds(
                gn.
                  getParent(
                    ),
                gn);
        if (r2d ==
              null)
            return null;
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT) {
            if (child ==
                  null)
                return (java.awt.geom.Rectangle2D)
                         gn.
                         getPrimitiveBounds(
                           ).
                         clone(
                           );
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            return addBounds(
                     cgn,
                     child,
                     null);
        }
        java.awt.geom.AffineTransform at =
          gn.
          getTransform(
            );
        if (at !=
              null) {
            try {
                at =
                  at.
                    createInverse(
                      );
                r2d =
                  at.
                    createTransformedShape(
                      r2d).
                    getBounds2D(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException nte) {
                r2d =
                  null;
            }
        }
        if (child !=
              null) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              addBounds(
                cgn,
                child,
                r2d);
        }
        else {
            java.awt.geom.Rectangle2D gnb =
              gn.
              getPrimitiveBounds(
                );
            if (gnb !=
                  null)
                r2d.
                  add(
                    gnb);
        }
        return r2d;
    }
    static java.awt.geom.Rectangle2D getBoundsRecursive(org.apache.batik.gvt.GraphicsNode gn,
                                                        org.apache.batik.gvt.GraphicsNode child) {
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn ==
              null) {
            return null;
        }
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        if (r2d !=
              null)
            return r2d;
        r2d =
          getBoundsRecursive(
            gn.
              getParent(
                ),
            gn);
        if (r2d ==
              null) {
            return new java.awt.geom.Rectangle2D.Float(
              0,
              0,
              0,
              0);
        }
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT)
            return r2d;
        java.awt.geom.AffineTransform at =
          gn.
          getTransform(
            );
        if (at !=
              null) {
            try {
                at =
                  at.
                    createInverse(
                      );
                r2d =
                  at.
                    createTransformedShape(
                      r2d).
                    getBounds2D(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException nte) {
                r2d =
                  null;
            }
        }
        return r2d;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.awt.geom.Rectangle2D r2d =
          getBoundsRecursive(
            node,
            null);
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT) {
            r2d =
              getViewportBounds(
                node,
                null);
        }
        return r2d;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getBackground(org.apache.batik.gvt.GraphicsNode gn,
                                                                          org.apache.batik.gvt.GraphicsNode child,
                                                                          java.awt.geom.Rectangle2D aoi) {
        if (gn ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "BackgroundImage requested yet no parent has " +
              "\'enable-background:new\'");
        }
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        java.util.List srcs =
          new java.util.ArrayList(
          );
        if (r2d ==
              null) {
            java.awt.geom.Rectangle2D paoi =
              aoi;
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                paoi =
                  at.
                    createTransformedShape(
                      aoi).
                    getBounds2D(
                      );
            org.apache.batik.ext.awt.image.renderable.Filter f =
              getBackground(
                gn.
                  getParent(
                    ),
                gn,
                paoi);
            if (f !=
                  null &&
                  f.
                  getBounds2D(
                    ).
                  intersects(
                    aoi)) {
                srcs.
                  add(
                    f);
            }
        }
        if (child !=
              null) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            java.util.List children =
              cgn.
              getChildren(
                );
            java.util.Iterator i =
              children.
              iterator(
                );
            while (i.
                     hasNext(
                       )) {
                org.apache.batik.gvt.GraphicsNode childGN =
                  (org.apache.batik.gvt.GraphicsNode)
                    i.
                    next(
                      );
                if (childGN ==
                      child)
                    break;
                java.awt.geom.Rectangle2D cbounds =
                  childGN.
                  getBounds(
                    );
                java.awt.geom.AffineTransform at =
                  childGN.
                  getTransform(
                    );
                if (at !=
                      null)
                    cbounds =
                      at.
                        createTransformedShape(
                          cbounds).
                        getBounds2D(
                          );
                if (aoi.
                      intersects(
                        cbounds)) {
                    srcs.
                      add(
                        childGN.
                          getEnableBackgroundGraphicsNodeRable(
                            true));
                }
            }
        }
        if (srcs.
              size(
                ) ==
              0)
            return null;
        org.apache.batik.ext.awt.image.renderable.Filter ret =
          null;
        if (srcs.
              size(
                ) ==
              1)
            ret =
              (org.apache.batik.ext.awt.image.renderable.Filter)
                srcs.
                get(
                  0);
        else
            ret =
              new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
                srcs,
                org.apache.batik.ext.awt.image.CompositeRule.
                  OVER,
                false);
        if (child !=
              null) {
            java.awt.geom.AffineTransform at =
              child.
              getTransform(
                );
            if (at !=
                  null) {
                try {
                    at =
                      at.
                        createInverse(
                          );
                    ret =
                      new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
                        ret,
                        at);
                }
                catch (java.awt.geom.NoninvertibleTransformException nte) {
                    ret =
                      null;
                }
            }
        }
        return ret;
    }
    public boolean isDynamic() { return false;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.Rectangle2D r2d =
          getBounds2D(
            );
        java.awt.Shape aoi =
          renderContext.
          getAreaOfInterest(
            );
        if (aoi !=
              null) {
            java.awt.geom.Rectangle2D aoiR2d =
              aoi.
              getBounds2D(
                );
            if (!r2d.
                  intersects(
                    aoiR2d))
                return null;
            java.awt.geom.Rectangle2D.
              intersect(
                r2d,
                aoiR2d,
                r2d);
        }
        org.apache.batik.ext.awt.image.renderable.Filter background =
          getBackground(
            node,
            null,
            r2d);
        if (background ==
              null)
            return null;
        background =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            background,
            r2d,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        java.awt.image.RenderedImage ri =
          background.
          createRendering(
            new java.awt.image.renderable.RenderContext(
              renderContext.
                getTransform(
                  ),
              r2d,
              renderContext.
                getRenderingHints(
                  )));
        return ri;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfZAUxRXv3eO+77gPvr8OOA4IqLtCVGIOP+D4Ol2OKw6v" +
       "4qEevbO9ewOzM+NM791ySiLmQ2KVFCEIJFH+CRaEUjGpUCZFtEhMopaYKtTE" +
       "mARNRatCopZSKc2HJua97pmd2dkPvKpcrmp657rfe93v9Xu/97rn0XdJpW2R" +
       "NqbzCN9pMjuyVue91LJZokujtr0F+gaVQxX0b3dc6Lk2TKoGyMQham9UqM3W" +
       "qUxL2ANkjqrbnOoKs3sYSyBHr8VsZg1Trhr6AJmi2t1pU1MVlW80EgwJ+qkV" +
       "Iy2Uc0uNZzjrdgRwMicGK4mKlURXBYc7Y6RBMcydHvl0H3mXbwQp095cNifN" +
       "se10mEYzXNWiMdXmnVmLXGYa2s6UZvAIy/LIdu1qxwQ3xa4uMEH7E00ffrRv" +
       "qFmYYBLVdYML9ezNzDa0YZaIkSavd63G0vad5IukIkbqfcScdMTcSaMwaRQm" +
       "dbX1qGD1jUzPpLsMoQ53JVWZCi6Ik/n5Qkxq0bQjplesGSTUcEd3wQzazstp" +
       "K7UsUPHBy6IHDt3R/IMK0jRAmlS9D5ejwCI4TDIABmXpOLPsVYkESwyQFh02" +
       "u49ZKtXUUWenW201pVOege13zYKdGZNZYk7PVrCPoJuVUbhh5dRLCody/qtM" +
       "ajQFuk71dJUarsN+ULBOhYVZSQp+57BM2KHqCU7mBjlyOnbcDATAWp1mfMjI" +
       "TTVBp9BBWqWLaFRPRfvA9fQUkFYa4IAWJzNLCkVbm1TZQVNsED0yQNcrh4Cq" +
       "VhgCWTiZEiQTkmCXZgZ2ybc/7/as3HuXvkEPkxCsOcEUDddfD0xtAabNLMks" +
       "BnEgGRuWxg7SqU/tCRMCxFMCxJLmybsv3nh525nnJM2sIjSb4tuZwgeVo/GJ" +
       "52Z3Lbm2ApdRYxq2ipufp7mIsl5npDNrAsJMzUnEwYg7eGbzL2+95wR7O0zq" +
       "ukmVYmiZNPhRi2KkTVVj1nqmM4tylugmtUxPdInxblIN7zFVZ7J3UzJpM95N" +
       "Jmiiq8oQ/4OJkiACTVQH76qeNNx3k/Ih8Z41CSHV8JAGeJYR+Sd+OYlHh4w0" +
       "i1KF6qpuRHstA/W3o4A4cbDtUDQOXr8jahsZC1wwalipKAU/GGLOQGqYR2EF" +
       "4D3R1eADKcvI6InNNK6xz61WAW7A18z/yyxZ1HXSSCgE2zA7CAIaxM8GQ0sw" +
       "a1A5kFm99uLjgy9IB8OgcKzECU4ckRNHxMQRmDgiJ44UmZiEQmK+ybgAueWw" +
       "YTsg9AF7G5b03X7Ttj3tFeBr5sgEsDaStufloC4PH1xQH1ROtjaOzn992TNh" +
       "MiFGWqnCM1TDlLLKSgFYKTuceG6IQ3byksQ8X5LA7GYZCksARpVKFo6UGmOY" +
       "WdjPyWSfBDeFYbBGSyeQousnZw6P7O7/0pVhEs7PCzhlJUAasvcimudQuyOI" +
       "B8XkNt134cOTB3cZHjLkJRo3PxZwog7tQY8ImmdQWTqPnhp8aleHMHstIDen" +
       "EGkAim3BOfKAp9MFcdSlBhROGlaaajjk2riOD1nGiNcjXLVFvE8Gt6jHSGyD" +
       "p8cJTfGLo1NNbKdJ10Y/C2ghksR1febDv/3VXz4rzO3mkyZfIdDHeKcPw1BY" +
       "q0CrFs9tt1iMAd35w73ffPDd+7YKnwWKBcUm7MC2C7ALthDM/NXn7nztjdeP" +
       "vhL2/JxDEs/EoRbK5pTEflJXRkmYbZG3HsBADRACvabjFh38U02qGHUYWB83" +
       "LVx26p29zdIPNOhx3ejySwvw+mesJve8cMff24SYkII52LOZRyaBfZIneZVl" +
       "0Z24juzul+Z861n6MKQIgGVbHWUCaUNOrOOipkMVUxRT1lvUHFIVuwfiTGzv" +
       "1YL+StFehaYRUogYuxabhbY/TPIj0VdVDSr7Xnm/sf/9py8KvfLLMr9XbKRm" +
       "p3REbBZlQfy0IIxtoPYQ0F11pue2Zu3MRyBxACQqANH2JgvANJvnQw51ZfXv" +
       "fvrM1G3nKkh4HanTDJpYR0U4klqIA2YPAQ5nzRtulG4wUgNNs1CVFChf0IFb" +
       "Mbf4Jq9Nm1xsy+iPpv1w5bEjrwt/NKWMWTn8nZ2Hv6K49yDgxMsrfn3sGwdH" +
       "ZHmwpDTuBfim/2uTFr/3T/8oMLlAvCKlS4B/IProQzO7rn9b8HvQg9wd2cJ0" +
       "BvDt8S4/kf4g3F71izCpHiDNilNM91MtgwE9AAWk7VbYUHDnjecXg7Ly6cxB" +
       "6+wg7PmmDYKel0bhHanxvTGAcw0uzq1wIGBFEOdCRLzcLFgWi3YpNle4sFJt" +
       "WiocuFgAV+rLCOWwOAgyfL9G4ii2n8cmJsVcV8wX5dBibC7LTSb+qoJFlB/E" +
       "PGcjGFFzStW5okY/eu+BI4lNjyyT7taaXzuuhaPRY7/599nI4T8+X6RUqeWG" +
       "eYXGhpnmm7MWp8xz8I3iCOB5y/mJ+9/8cUdq9VhqC+xru0T1gP/PBSWWlo6Z" +
       "4FKevfevM7dcP7RtDGXC3IA5gyK/t/HR59cvUvaHxXlHunHBOSmfqTPfeess" +
       "Bgc7fUueCy/IOcB03NjF8Kx0HGBl8VRdxHdyCbAUa5kEwMqMpbDZBtieYtyf" +
       "VYTDe75Oy/j6p8Bd7OgyRf9t+YXLcni6HJW6xm6NUqwBjZ2kKpQSUq0yJhH1" +
       "QBpMYuebxC6L6b2WmoYCadg5TkZ3tb6x46ELj8ngDAJ4gJjtOXD/J5G9B2Sg" +
       "ygP6goIzsp9HHtLFcpulVT6BvxA8/8EHdcEO/AWY7nJOivNyR0XMbBaZX25Z" +
       "Yop1fz656/TxXfeFHdt8AfBw2FATnmfo4+AZ03BsHjy3Ott7axnPKILzVba4" +
       "lSlSPpYSGHCHCiGpwi3ClhYtwtCqWBSz4nEDfDNErUFHeCTFjHRkMyRISJUa" +
       "W75GKHB/GSfch82XAahpIrEaT42C6gHP7l8ZL7t/Bp7djpl2XyIiv1Zo4VKs" +
       "AV3DYiHhXF6VYfmdMhZ5GJuDnLQAUvWrbMQ0LF7UMofGyzJL4DntqHd67JYp" +
       "xfqpLHO8jGVOYPNdiHOwjLQIeFrGsiGQA6Y5Ol6maYfnPUe/9y5hmiIwXoq1" +
       "jNKnyow9ic0TnNTnDLJ8TcAS3x8HS7Ti2FxAoCopU/6OyRIlWYsDlOckQj0h" +
       "/2dlDPNzbJ7ipBENk7uQcuHqygKYwyyH8KWmaYpFLKbDqQ2PwXACwUstz5xP" +
       "j4M5J+HYbLCF4thEGbs5S7GWsdG5MmMvY3MWUFm11+yEug9AP+9ODmvhvkzc" +
       "5oEEv7x3m7Kno/ctWQ3MKMIg6aYcjz7Q/+r2s6KorcEqOldK+ipoqLZ9N0HN" +
       "2IxKow773u+G807cMDRG9WAdhHdB+WuQ06/5etNP9rVWrIPyvpvUZHT1zgzr" +
       "TuSXuNV2Ju5blHdfLzr8K8IChJPQUvcULRzlxXFwlBk4BmkrNOzs9vDYHaUU" +
       "a/FC0o2YxbkEXxAhm8Wr82FILOBCGcd6B5s3oeZULAb1mWRW9ZQ70ezARJKA" +
       "JbrxP8+6b/0vrJvlZFKR22q8PJle8HlMftJRHj/SVDPtyC2vioNh7rNLAzhx" +
       "MqNp/uO9773KtFhSFfo3yMO+KX4+5GRWmat0jh/BcvDzgeT5JyeTi/FwUgGt" +
       "n/JjTpqDlJxUil8/HfhunUcHk8oXH0koDNKBBF8rTHerVnx6FF0FgW/BKVrY" +
       "OCu9apZ/d8SmTrnUpvpuDBbkHVDEN083yjPyq+egcvLITT13XbzmEXnjq2h0" +
       "dBSl1ENsy8tnB1z854OgNFdW1YYlH018onahez5okQv24m2Wz8nhkBYy0Y1m" +
       "Bq5D7Y7crehrR1c+/eKeqpfgKLSVhCi44tbCS6asmbHInK2xQgzrp5a4p+1c" +
       "8u2d11+efO/34hqPFFzeBekHlVeO3f7y/ulH28KkvptUwtGHZcXtF+A8VFPD" +
       "1gBpVO21WVgiSFGplgeQE9HjKQassItjzsZcL34v4KS98EhX+JWlTjNGmCWq" +
       "Fgdi670euTOBO4eMaQYYvB5fnviDRGXcDXDbwdhG03SPiBPgHUfPFzswnxeu" +
       "PlW84tu0/wKEJHDYDyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tpruBgEX8f6wWe/P5kvCbvXWsNccrrNNVRmuAkeP6PFkqna1+na4k3dRHLDo" +
       "NJoOGDxv9Rgyro/gHs9WVyPMdcYdsqmvtkSvMSF7GO4uApEbRDNp3R1v8yFl" +
       "VZGk0Vmy8WI6neveHKnWgpmom3qtvpNYjV4KS2mNDmYhMfD7yWyqWFZTG3GE" +
       "r+XwJubl1ZBK1mhN60/lMBIqUw4XLWm2HA+DShPFeYRlNsQUdfGVk4ueopLY" +
       "BJsHNdfgV73JZIYHHRyfb+acTI0GIyPFOsZwuqYkudHD5v2dwBHrmeLWJsvh" +
       "TIi6ZDUfCmpoNYjNzDKJ+cRedu3hZO0Si6W5RHJFhVFYjupMskjX3cE6IyJR" +
       "7U5JTTPIahZjsiJw/DrCva5Jj5J5ZqLjzRSOiRFPZBR4+pybK1Fa96wm0vS8" +
       "Po9EvdVYacTJcmvqMx+m+01kWecUF8ECbSRlG8QOEiNA3V7kNL2AFEIs6vO7" +
       "qdfdSiaq08qOQyqd5naEitXdJlm7M8m1l8LAGtkIu57MZquat3H5Rpw7ienG" +
       "02wAcoRMcXoCuqNmS7Rfn+76Ad9pCsDM7U3bH8INsb+2MWIyGzJoa6MLQlZf" +
       "wz2rvWzUiDEza/cxWu9Lo8pYq4iSw1iNbdWusVRrEyQjJooxeF73G1hDVch4" +
       "Sg7FRdheyVa0JGrbrezYAYtNYZrmxCG9kUZIl2qQ9VFNx0hWTXutnicIbCvb" +
       "tWpzbI5itfYOzvNsWWMW4zFhdpEdhhJYT874Nj2sRlu5hjXXlNvpJNzKzDs9" +
       "vC2aKrvrEtOGuh4JTMYPRy5p2v1GY+ou7e7QZSu5YmKJPt9Kk8jsYBRKN5Vq" +
       "fYFO4lU9pnQ8bEZmNyLlcZwYjk80BkwtGzK1kRivZHHndTrIRLB4m6LnG4/g" +
       "axPS4Th2bFISO0lUnW71hnUlX0fD9qLJYSgtLYl1hI2CGUv5rSntitJcWw3y" +
       "+djASZ2SFJwe5/rQTyJvuW0NUBGFq8HM6kbogNhZTn+KyVGq2m6iDZNcBPgW" +
       "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" +
       "/jvl0fb/BcGFuZARLAAA");
}
