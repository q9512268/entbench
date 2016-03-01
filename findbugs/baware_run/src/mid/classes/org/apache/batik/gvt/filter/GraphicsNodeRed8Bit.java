package org.apache.batik.gvt.filter;
public class GraphicsNodeRed8Bit extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private org.apache.batik.gvt.GraphicsNode node;
    private java.awt.geom.AffineTransform node2dev;
    private java.awt.RenderingHints hints;
    private boolean usePrimitivePaint;
    public GraphicsNodeRed8Bit(org.apache.batik.gvt.GraphicsNode node, java.awt.geom.AffineTransform node2dev,
                               boolean usePrimitivePaint,
                               java.awt.RenderingHints hints) { super(
                                                                  );
                                                                this.
                                                                  node =
                                                                  node;
                                                                this.
                                                                  node2dev =
                                                                  node2dev;
                                                                this.
                                                                  hints =
                                                                  hints;
                                                                this.
                                                                  usePrimitivePaint =
                                                                  usePrimitivePaint;
                                                                java.awt.geom.AffineTransform at =
                                                                  node2dev;
                                                                java.awt.geom.Rectangle2D bounds2D =
                                                                  node.
                                                                  getPrimitiveBounds(
                                                                    );
                                                                if (bounds2D ==
                                                                      null)
                                                                    bounds2D =
                                                                      new java.awt.geom.Rectangle2D.Float(
                                                                        0,
                                                                        0,
                                                                        1,
                                                                        1);
                                                                if (!usePrimitivePaint) {
                                                                    java.awt.geom.AffineTransform nodeAt =
                                                                      node.
                                                                      getTransform(
                                                                        );
                                                                    if (nodeAt !=
                                                                          null) {
                                                                        at =
                                                                          (java.awt.geom.AffineTransform)
                                                                            at.
                                                                            clone(
                                                                              );
                                                                        at.
                                                                          concatenate(
                                                                            nodeAt);
                                                                    }
                                                                }
                                                                java.awt.Rectangle bounds =
                                                                  at.
                                                                  createTransformedShape(
                                                                    bounds2D).
                                                                  getBounds(
                                                                    );
                                                                java.awt.image.ColorModel cm =
                                                                  createColorModel(
                                                                    );
                                                                int defSz =
                                                                  org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
                                                                  getDefaultTileSize(
                                                                    );
                                                                int tgX =
                                                                  defSz *
                                                                  (int)
                                                                    java.lang.Math.
                                                                    floor(
                                                                      bounds.
                                                                        x /
                                                                        defSz);
                                                                int tgY =
                                                                  defSz *
                                                                  (int)
                                                                    java.lang.Math.
                                                                    floor(
                                                                      bounds.
                                                                        y /
                                                                        defSz);
                                                                int tw =
                                                                  bounds.
                                                                    x +
                                                                  bounds.
                                                                    width -
                                                                  tgX;
                                                                if (tw >
                                                                      defSz)
                                                                    tw =
                                                                      defSz;
                                                                int th =
                                                                  bounds.
                                                                    y +
                                                                  bounds.
                                                                    height -
                                                                  tgY;
                                                                if (th >
                                                                      defSz)
                                                                    th =
                                                                      defSz;
                                                                if (tw <=
                                                                      0 ||
                                                                      th <=
                                                                      0) {
                                                                    tw =
                                                                      1;
                                                                    th =
                                                                      1;
                                                                }
                                                                java.awt.image.SampleModel sm =
                                                                  cm.
                                                                  createCompatibleSampleModel(
                                                                    tw,
                                                                    th);
                                                                init(
                                                                  (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                                    null,
                                                                  bounds,
                                                                  cm,
                                                                  sm,
                                                                  tgX,
                                                                  tgY,
                                                                  null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        genRect(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        java.awt.image.BufferedImage offScreen =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.Graphics2D g =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            offScreen,
            hints);
        g.
          setComposite(
            java.awt.AlphaComposite.
              Clear);
        g.
          fillRect(
            0,
            0,
            wr.
              getWidth(
                ),
            wr.
              getHeight(
                ));
        g.
          setComposite(
            java.awt.AlphaComposite.
              SrcOver);
        g.
          translate(
            -wr.
              getMinX(
                ),
            -wr.
              getMinY(
                ));
        g.
          transform(
            node2dev);
        if (usePrimitivePaint) {
            node.
              primitivePaint(
                g);
        }
        else {
            node.
              paint(
                g);
        }
        g.
          dispose(
            );
    }
    static final boolean onMacOSX;
    static { onMacOSX = "Mac OS X".equals(
                                     java.lang.System.
                                       getProperty(
                                         "os.name"));
    }
    public java.awt.image.ColorModel createColorModel() {
        if (onMacOSX)
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     sRGB_Pre;
        return org.apache.batik.ext.awt.image.GraphicsUtil.
                 sRGB_Unpre;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "X1/Apvc/neCec0IcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u2pvsc6rGpe1uj2Z9PGsoiYmQ1pul+9iFDffrWy6tc1W/EJ1aJu0iAbH6mNl" +
       "u6GkJGIsV7JQstlBN4hnaY0EQfR6rvIbhxtpa0CkMlHbNlzgPB5ft9YbyuNN" +
       "cpnzIxKxaUfRvVyjpG6DrDI2Km09zGK2Po626OG4ZShjB6n5VhqR9fmMddie" +
       "WOk1BqN0wTN2Mh+qWbNhZwuL1EYLZUIs6ArAv+jMO3C3s/QE3uHqLN5Papsu" +
       "Fs03lXmjJ/MYQwMbh95iAIszlrc6VKcWVJMK0MnopUTYXNlDejEexxWweHJg" +
       "sJ4JNMMyI3FmMevhTGIoLq/3UYxfDcy4rrZmfRCMVVWrmIvRWlgTwXo+WLXM" +
       "Rofo+7NEGy25rpQqTVWS+juJDNw+U8V9w502jWbMzVKiL0VDJ1/FjhPVApqb" +
       "UfluMWpLa0xgBiHRD0KpAQL7nO+EI6dlyq2EtL0KXNcoa51K8+lqJSxRxbEZ" +
       "Wtgs0nhEkGuKoavTmCH6WTJugBVTn+vJnjgIuyKYkzV/sVii3UBE7Zjd+uzW" +
       "Jd1wYOn+Ggy02cZaueC6QjRlJpY/rXO+ZLVFcicRvtDv14d1k46tKTPYVRrV" +
       "RO5QAQg8c8ejcaZR47rqkFpYPddkdIpEcW5UW+BZY0Q7kq7PF5WKm4eDtCOv" +
       "ufoowjZi5qZkR9bjCbtIp2PW7WZtZOimyzQNekxPJzckDfNg9qW8OvZbOWkv" +
       "5vQOabDoWlzlsii1/am1Ugf1SZp0dKq7GESZLcfLTqdWneZY6pDcLqJXTX/A" +
       "rehtqKex3NDgdX2ZrH1J0FLY9jRrADcnrNbZwfXmVhrlFmnI4nDTleY6bpra" +
       "lgk1Sg2jbDNbuXa3F83kLhWF1LyXZE6/Ss7zroOEndlSa9srZFYz7FCcrVfT" +
       "ZbYKRDbAUruSLvH2CO6jtSa/iGy3brHEOp8NBM1IB1jeo6TpVGtWasNEMSrt" +
       "uiGR2xRN+Spd1fIGXKF4H5stXLVSd6byUmwMaLTPjgOLnYpaCjyqSswwZ94e" +
       "Uu1Nc9ar1ac5iPKVcW1Ax1vEnWMU3HabDdq0SDwYdpvYppZ1ZN7Llj5Wyyor" +
       "EOsmO+DTEe+O8PFyUF8J/ApTAsmjlVHTTBF8le5wO4iq+cqq26OOW0lNP1vK" +
       "fSsiauiy2ZSldp1Xk7jRaOpNU+m6AkKqO2EosfBwNet0Glg0MpiR5NXzCTEe" +
       "jSruTLDZljudNlvcLtE3LbbqqK2dKay9fGxVfQ8W2LleXQ3sSV/MCFXrmKnb" +
       "o5sKgfoajDKwETn9/qinkXY9CdB0gTTHS7CEs1mzGg7VNoa0qyOwZOOpWky7" +
       "OyPv+FFGaVpLDhvoHF2s4bzd3E5iGs5hBNeStGXWGms72EVEtuNYpi2k8Iw0" +
       "AMw50Z40NbnWUuWdUA98V5uA7eictQNL2PacqYQ22IrU1F1rGAWVCc4uOjI6" +
       "MpQKMKrSbIKdTTVPle3aG201I/Y9QBn1NCA601zQJSYnlkHYQ+wWq+RLhVrB" +
       "IdyQs3pvBQIHO5iM3Zok5OPB2G4qVDJgBKoLDxeOQo+35rAVttMm0stzrDry" +
       "GqTX2VHScMPnaiWnzGnIdzJ+5oV4tqmiTmsd5Ltmm+l1sUxT8e6k36lOhG1j" +
       "XOe4Olph2hvMbdPNpU1VbYseRoMZKZqwKAE6CLgE5UOp5ZvrGoz4iQy7KqrK" +
       "VVwGO9nvK7a4P/Xitt4PlKcMx/fXYMddPNi9iN31/tHjRfK644OZ8nMPdO7O" +
       "89TBzKlzV6g4GX70TtfS5SH5h9/xzHPK7CO1i4fn1U9F0L2R57/JVhPVPtXU" +
       "XaClJ+98hEuWt/In56iff8ffP8K+2Xjbi7jFe/U5nOeb/Cj58d/HXi//zEXo" +
       "ruNT1VveFzhb6amzZ6lXAzWKA5c9c6L66LFlHzk68goPLRueP/I6GbvbH8e9" +
       "YT/2564DLhzehR6eLp1c1JiOqKsHqwBEW8lWaTGM1KBs4Rde4ELhw0XygQi6" +
       "Int+PhAjsfj/iycO9cFvdVxzusGy4P1n7xKfLEX3n+z/1AIl0lLgky+g4KeL" +
       "5KMRdFlXXbq4Qr/dOVXimcqJzh/7X+j8UFFYnMN+4FDnD/zf6Hxapc+9wLPf" +
       "KpLPRtB1OVDFqLhh9ALSUw4nH/CX7zjnL+ckSgP8+osxQBZBL7vN3X5xUfnK" +
       "W1402r8cI3/yuWtXHn6O+9Pyevv4BZZ7CeiKFtv26fuKU/l7/EDVzFLLe/e3" +
       "F37584UI+s4XePEgKl4nKjIl8s/v63wxgl5+uzoRdBdIT0v+IbDleckIulT+" +
       "npb7UgRdPZEDne4zp0W+DFoHIkX2j/2j8WjcAqNgw5PxCcoLQlU5QKQwCkQ5" +
       "AvbNLpxl5eOBe/BbDdwpIn/tGfot3xw7osp4/+7YTflTz02oH/5G+yP763zZ" +
       "FndlwLlCQJf3bxYc0+3jd2ztqK17xm/85v2fvvd1R6Hh/j3gk+lwCturb393" +
       "PnT8qLzt3n324V/93l967qvlefb/AG1SzMvSJwAA");
}
