package org.apache.batik.dom.svg;
public abstract class SVGOMTextPositioningElement extends org.apache.batik.dom.svg.SVGOMTextContentElement implements org.w3c.dom.svg.SVGTextPositioningElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextContentElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_DX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_DY_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_ROTATE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      dx;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      dy;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList
      rotate;
    protected SVGOMTextPositioningElement() {
        super(
          );
    }
    protected SVGOMTextPositioningElement(java.lang.String prefix,
                                          org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedLengthList(
            null,
            SVG_X_ATTRIBUTE,
            getDefaultXValue(
              ),
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH);
        y =
          createLiveAnimatedLengthList(
            null,
            SVG_Y_ATTRIBUTE,
            getDefaultYValue(
              ),
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH);
        dx =
          createLiveAnimatedLengthList(
            null,
            SVG_DX_ATTRIBUTE,
            "",
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH);
        dy =
          createLiveAnimatedLengthList(
            null,
            SVG_DY_ATTRIBUTE,
            "",
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH);
        rotate =
          createLiveAnimatedNumberList(
            null,
            SVG_ROTATE_ATTRIBUTE,
            "",
            true);
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getDx() {
        return dx;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getDy() {
        return dy;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getRotate() {
        return rotate;
    }
    protected java.lang.String getDefaultXValue() {
        return "";
    }
    protected java.lang.String getDefaultYValue() {
        return "";
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Zvj/watwPQ8mAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "R1ulyXeb9bRCM6QoIMqctEtKIrT7BMVIAY70BnpqYt5sNFuWvZ5BYYxRqY17" +
       "plQRA3wtpvUFY1Ke2hDCkoKDDH7M89smzthCuU05W1aIuFZdbfLJtjRpscSs" +
       "XOPHyyXWCdRRJCjNKhpOBgRZpz261KFFZ0VO5ZHRhuk+MMGGjjekeo+bcZQx" +
       "Edy2Kdgto2kD64NJtLWMw5WM1VjVpLeywwCZyHaGxnrAdig2dIeZxlYtNqva" +
       "I4RPS8pmgncnGLYyUtypcDOnklbHvZ7R8OHYEPouLwQELYVaqvdqBLHC1s1m" +
       "UseV3syhViuntk2mQ6zWGcuTTnciV7LSQmL7w4CrYhI15spMuGjREkdWswDH" +
       "yKWKNh3CTutssxslhkNTGunMKoNpOfbTUavk21Kny0uS0Y34qSU5WLMWB7Ux" +
       "rmxH+JQrx9uegCc2l8zH+GoKyz46qG6RZtLYdqXONrOX5MLBkjETJOUthS9X" +
       "LIuPnSXZbC9EyfHobtrXqnUhsOJRNeNaDpv0pjV8G2MJxmw4eJNNmFZY5qcx" +
       "ik1JmifMZsWvIxKMBkGlXoEtqlSDpenUd8vLxSJFF6Zv1SROK2my3i+l+MRb" +
       "9nmdHpgakaF2baa2l5ZMs4OWx2GdBFnNNTiVbGyFoqVlu9vthQo39xordRgh" +
       "mClsUmy8ROi4o+M2ZffnMtpJN3SDG8v6HKuu3FRfBubKybTSHHW0ZaiKs5Y6" +
       "9NmGNZCV1G6r62EpriRiUlHKnSToMOEc+EBjFJGoqMKZjX59JS4xH1shcZUT" +
       "ajaqSVJSwxisNfedyqLHBwO9CfccGB5OjG7TVmPYmEV6Hdv4EkxQpkF1um26" +
       "uy1VM8KX0uWIn4+Wc6QW++LaqTk+bLRZzGx6QmfeXzWZ2pglZ/iInG3a3fkW" +
       "jaUkygTMDb3+xLBYoZdNmyldj8ccu5IqvkGNGo36ersODBjtt7fYsF1i7P60" +
       "zgo0GlbnDIP2w3FpMPRjGuFoqrxSWjMu5vEGssUnxqgsrYy5lFaXhkluSrFt" +
       "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" +
       "MdAD69iyTj6DORG/6AXKWi8Ucmn3KMYr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("UKIA4O2uzyPoHhDmsl8o70pXIugttyoNSoLwZMk6MI6zJQHlFf9Plnshgi4f" +
       "l4ugi7vIySIvgtZBkTz6fu+QUV7nzj9Xa/F63okOHfkLJ3zxvbEVXPPo643b" +
       "UZWTryNz/714+3/oa8e71/83pC+/0h/+5Heqv7R7nSlZ4nabt/IAA92/eyh6" +
       "5K8/c9vWDtu62Hvuuw9/5dKzh3uLh3cCHxv+CdmevvU7yLbtRcXLxe2vv/1X" +
       "3/f5V/6wuOr/f80uQOmUMQAA");
}
