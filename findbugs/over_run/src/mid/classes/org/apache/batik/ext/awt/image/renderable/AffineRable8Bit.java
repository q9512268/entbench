package org.apache.batik.ext.awt.image.renderable;
public class AffineRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.ext.awt.image.renderable.AffineRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    java.awt.geom.AffineTransform affine;
    java.awt.geom.AffineTransform invAffine;
    public AffineRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                           java.awt.geom.AffineTransform affine) { super(
                                                                     );
                                                                   init(src);
                                                                   setAffine(
                                                                     affine);
    }
    public java.awt.geom.Rectangle2D getBounds2D() { org.apache.batik.ext.awt.image.renderable.Filter src =
                                                       getSource(
                                                         );
                                                     java.awt.geom.Rectangle2D r =
                                                       src.
                                                       getBounds2D(
                                                         );
                                                     return affine.
                                                       createTransformedShape(
                                                         r).
                                                       getBounds2D(
                                                         );
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 srcs.
                 get(
                   0);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src);
    }
    public void setAffine(java.awt.geom.AffineTransform affine) {
        touch(
          );
        this.
          affine =
          affine;
        try {
            invAffine =
              affine.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            invAffine =
              null;
        }
    }
    public java.awt.geom.AffineTransform getAffine() {
        return (java.awt.geom.AffineTransform)
                 affine.
                 clone(
                   );
    }
    public boolean paintRable(java.awt.Graphics2D g2d) {
        java.awt.geom.AffineTransform at =
          g2d.
          getTransform(
            );
        g2d.
          transform(
            getAffine(
              ));
        org.apache.batik.ext.awt.image.GraphicsUtil.
          drawImage(
            g2d,
            getSource(
              ));
        g2d.
          setTransform(
            at);
        return true;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        if (invAffine ==
              null)
            return null;
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi !=
              null)
            aoi =
              invAffine.
                createTransformedShape(
                  aoi);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        at.
          concatenate(
            affine);
        return getSource(
                 ).
          createRendering(
            new java.awt.image.renderable.RenderContext(
              at,
              aoi,
              rh));
    }
    public java.awt.Shape getDependencyRegion(int srcIndex,
                                              java.awt.geom.Rectangle2D outputRgn) {
        if (srcIndex !=
              0)
            throw new java.lang.IndexOutOfBoundsException(
              "Affine only has one input");
        if (invAffine ==
              null)
            return null;
        return invAffine.
          createTransformedShape(
            outputRgn);
    }
    public java.awt.Shape getDirtyRegion(int srcIndex,
                                         java.awt.geom.Rectangle2D inputRgn) {
        if (srcIndex !=
              0)
            throw new java.lang.IndexOutOfBoundsException(
              "Affine only has one input");
        return affine.
          createTransformedShape(
            inputRgn);
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
      ("H4sIAAAAAAAAAMV6e8zrxnUn72ffa9/rxPfaTmLHje3YuUnqKL0URUkUcbvZ" +
       "UC9KFEVKFEWK2m0ckuJTfIlPiV3vNkFbpw2aBK2TpkDr/tEEfSCPomixL7Tw" +
       "YtHXtijQomj32RSLxba7aYBkgW2LTbfdIfV9n7773UfitRcrgKPhzDkz53fm" +
       "zJnDmfnC16CLUQhVAt/ZGY4f39C28Q3badyId4EW3aDoxkQOI23VceQo4kHZ" +
       "C+pzv3j1L7/5KfPaEXRpCT0me54fy7HlexGnRb6Taisaunoo7TmaG8XQNdqW" +
       "UxlOYsuBaSuKb9LQQ2dYY+g6fSICDESAgQhwKQJMHKgA05s1L3E7BYfsxdEG" +
       "+sfQBRq6FKiFeDH07K2NBHIou8fNTEoEoIUHi3cBgCqZtyH0zlPse8y3Af50" +
       "BX75xz907Zfug64uoauWNyvEUYEQMehkCb3J1VxFCyNitdJWS+gRT9NWMy20" +
       "ZMfKS7mX0KORZXhynITaqZKKwiTQwrLPg+bepBbYwkSN/fAUnm5pzurk7aLu" +
       "yAbA+rYD1j3CflEOAF6xgGChLqvaCcv9a8tbxdAz5zlOMV4fAQLA+oCrxaZ/" +
       "2tX9ngwKoEf3Y+fIngHP4tDyDEB60U9ALzH05F0bLXQdyOpaNrQXYuiJ83ST" +
       "fRWgulwqomCJobeeJytbAqP05LlROjM+X2O++xPf6w28o1LmlaY6hfwPAqan" +
       "zzFxmq6Fmqdqe8Y3vY/+jPy2X/3YEQQB4reeI97T/NN/9I0Pvv/pV39rT/Md" +
       "d6BhFVtT4xfUzykP//47Os/j9xViPBj4kVUM/i3IS/OfHNfc3AZg5r3ttMWi" +
       "8sZJ5avcb0jf9wvaV4+gK0Pokuo7iQvs6BHVdwPL0UJS87RQjrXVELqseatO" +
       "WT+EHgB52vK0fSmr65EWD6H7nbLokl++AxXpoIlCRQ+AvOXp/kk+kGOzzG8D" +
       "CIIeAA/0HvA8D+1/7y2SGMph03c1WFZlz/J8eBL6Bf5iQL2VDMdaBPIrUBv4" +
       "sALsf/1dyA0MjvwkBAYJ+6EBy8AqTG1fWc5TOYthywXGAIPBWQFgiqPBhK4D" +
       "sbki32pbwCkBGwz+v/a+LXRzLbtwAQzbO847DQfMt4HvAP4X1JeTdu8bX3rh" +
       "d45OJ9GxVmMIByLc2ItwoxShdLhAhBulCDcOItw4JwJ04ULZ81sKUfbGAoZ6" +
       "DZwGcKdven72PdSHP/bcfcBKg+x+ME4FKXx3r945uJlh6UxVYOvQq5/NPiL8" +
       "k+oRdHSrey7EB0VXCvZJ4VRPnef189PyTu1efenP//LLn3nRP0zQW/z9sd+4" +
       "nbOY98+dV3Toq9oKeNJD8+97p/wrL/zqi9ePoPuBMwEONJaB4oBvevp8H7fM" +
       "/5snvrTAchEA1v3QlZ2i6sQBXonN0M8OJaUFPFzmHwE6fqiYEE+C58bxDCn/" +
       "i9rHgiJ9y95iikE7h6L01X9vFvzUv/29/4aW6j5x61fPLJQzLb55xpUUjV0t" +
       "ncYjBxvgQ00DdP/ps5Mf+/TXXvoHpQEAinfdqcPrRdoBLgQMIVDzD/zW5t99" +
       "5U8+94dHB6OJwVqaKI6lbk9BFuXQlXuABL295yAPcEUOmJCF1Vyfe66/snSr" +
       "MOHCSv/m6ruRX/mLT1zb24EDSk7M6P3fuoFD+dvb0Pf9zof+6umymQtqsRQe" +
       "dHYg2/vXxw4tE2Eo7wo5th/5g6d+4jflnwKeGnjHyMq10uEdlTo4KpG/NYaq" +
       "3/5U7VsOWAxPGJ8quywIDc13j+cxH8peVFhYaRNwSfu+Mi31WXYNlXWNInkm" +
       "Oju3bp2+ZyKiF9RP/eHX3yx8/de+USrj1pDqrCmN5eDm3nqL5J1b0Pzj5x3J" +
       "QI5MQFd/lfmH15xXvwlaXIIWVeA4IzYEULe3GN4x9cUH/v2/+tdv+/Dv3wcd" +
       "9aErji+v+nI5h6HLYPJokQl84jb4+x/c2072IEiulVCh28Dvbe6J8q0ISp+/" +
       "u/vqFxHRwQM88b9YR/nof/7r25RQOq47BALn+JfwF37yyc4HvlryHzxIwf30" +
       "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");
}
