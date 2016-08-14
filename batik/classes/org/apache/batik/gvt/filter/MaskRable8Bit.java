package org.apache.batik.gvt.filter;
public class MaskRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.gvt.filter.Mask {
    protected org.apache.batik.gvt.GraphicsNode mask;
    protected java.awt.geom.Rectangle2D filterRegion;
    public MaskRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                         org.apache.batik.gvt.GraphicsNode mask,
                         java.awt.geom.Rectangle2D filterRegion) { super(
                                                                     src,
                                                                     null);
                                                                   setMaskNode(
                                                                     mask);
                                                                   setFilterRegion(
                                                                     filterRegion);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.awt.geom.Rectangle2D getFilterRegion() {
        return (java.awt.geom.Rectangle2D)
                 filterRegion.
                 clone(
                   );
    }
    public void setFilterRegion(java.awt.geom.Rectangle2D filterRegion) {
        if (filterRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          filterRegion =
          filterRegion;
    }
    public void setMaskNode(org.apache.batik.gvt.GraphicsNode mask) {
        touch(
          );
        this.
          mask =
          mask;
    }
    public org.apache.batik.gvt.GraphicsNode getMaskNode() {
        return mask;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return (java.awt.geom.Rectangle2D)
                 filterRegion.
                 clone(
                   );
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        org.apache.batik.ext.awt.image.renderable.Filter maskSrc =
          getMaskNode(
            ).
          getGraphicsNodeRable(
            true);
        org.apache.batik.ext.awt.image.renderable.PadRable maskPad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          maskSrc,
          getBounds2D(
            ),
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        maskSrc =
          new org.apache.batik.ext.awt.image.renderable.FilterAsAlphaRable(
            maskPad);
        java.awt.image.RenderedImage ri =
          maskSrc.
          createRendering(
            rc);
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed maskCr =
          org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed.
          wrap(
            ri);
        org.apache.batik.ext.awt.image.renderable.PadRable maskedPad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          getSource(
            ),
          getBounds2D(
            ),
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        ri =
          maskedPad.
            createRendering(
              rc);
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              ri);
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            convertToLsRGB(
              cr);
        org.apache.batik.ext.awt.image.rendered.CachableRed ret =
          new org.apache.batik.ext.awt.image.rendered.MultiplyAlphaRed(
          cr,
          maskCr);
        return ret;
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
       "TmfLjj1KFYckV3Y+yhzMbc04oDJh5/SCeBzMsO5sk3sbejw0Ai6rkytyq/KU" +
       "ye9n5l4ZDDtw7kwXvX5UsN1w6wwEIZtyMIHSKFtXkBqe12g5Rmds0cR0dK/j" +
       "kdTzmJm5mUzaM1rc7pdtRk9XfYxYFMFUtcIaFmLuLjUsi6X5bkiMBixsIfvM" +
       "3jN9nJ46ti9w44E8nnsUPdeHiFTwSFdXB8uW3YctnCYJRtG2jXqNwPLGpg/7" +
       "aDjPMiXIdtbUSgtRoWZZWu/kkafDScB7NX2nhjQwVj3uIOSy6TtrYDe9vLWm" +
       "w9hJ2L1NJbzKqcNG0ZrUPbUxlntrCxuhjbU1mIRTwm8KDlkgHViptXEcqXd0" +
       "Ag/Qwuw5QSPZtiPH3ipTEBGQvshuY1+J+CmZLXyDlmY6Rw5i8CXikEKrQ+Sw" +
       "s2ysuSWjF9iaqeXd7dQbWrSsuusuzjfqJLrqYEinLXMbt2v1vBWysRk6YppT" +
       "Wt9rMTffBgRfcOxq04BDUrNtuiuMsmC9nw0dhdH6rTE3EGcoa08Xzbog1sSe" +
       "44zEOVUjR/2tMO8RiE3H/ERomjw7IPucPFM8f46KYT8v5sam4Nw5J4rSzht1" +
       "0/GapWlHwqU9gXjsWpUzRcPnXKIICrPCI3VraCskozKvg029ie4J8SJBOBRT" +
       "kwmycJxU1wQ0EQpa2o4aVkR2SWyst0Y1YbnXfDJhokS1MCVE8DZFbAeGNJr0" +
       "VVja+DQxsTxXmnOrhVyAFVZzcQYTBZ+OAypcBCtTzklUXYwGzFyKeMNLB7XJ" +
       "iMyi0WCMDnysNRZ5bljQKTHHmnnEY7HYSyYenxZ7pAerak2eq0t8t911c7s2" +
       "GU5U2N4OZY2WrSmm5bLUwDpY4lhGi+GWVNYM+DALUqRwOyGe9+CaLan7oZ0P" +
       "dyOqXWOHWbJU3XiM4y7H4XMBzd2Cx7jpaG80E7zlFju5PXDbsUYGBD1uuUt8" +
       "HLe3u6U7oRYDf0qg3mKkj/ml0olb/pxeTBnWDfm2rc4LXK5pXOhuvO1QGu7T" +
       "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" +
       "/cxLv1edWv4/G2DOg9EqAAA=");
}
