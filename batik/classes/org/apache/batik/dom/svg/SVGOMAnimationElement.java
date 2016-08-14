package org.apache.batik.dom.svg;
public abstract class SVGOMAnimationElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGAnimationElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean externalResourcesRequired;
    protected SVGOMAnimationElement() { super(); }
    protected SVGOMAnimationElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() { super.
                                                     initializeAllLiveAttributes(
                                                       );
                                                   initializeLiveAttributes(
                                                     );
    }
    private void initializeLiveAttributes() { externalResourcesRequired =
                                                createLiveAnimatedBoolean(
                                                  null,
                                                  SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                                                  false);
    }
    public org.w3c.dom.svg.SVGElement getTargetElement() {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          getTargetElement(
            );
    }
    public float getStartTime() { return ((org.apache.batik.dom.svg.SVGAnimationContext)
                                            getSVGContext(
                                              )).
                                    getStartTime(
                                      ); }
    public float getCurrentTime() { return ((org.apache.batik.dom.svg.SVGAnimationContext)
                                              getSVGContext(
                                                )).
                                      getCurrentTime(
                                        );
    }
    public float getSimpleDuration() throws org.w3c.dom.DOMException {
        float dur =
          ((org.apache.batik.dom.svg.SVGAnimationContext)
             getSVGContext(
               )).
          getSimpleDuration(
            );
        if (dur ==
              org.apache.batik.anim.timing.TimedElement.
                INDEFINITE) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NOT_SUPPORTED_ERR,
                    "animation.dur.indefinite",
                    null);
        }
        return dur;
    }
    public float getHyperlinkBeginTime() {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          getHyperlinkBeginTime(
            );
    }
    public boolean beginElement() throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          beginElement(
            );
    }
    public boolean beginElementAt(float offset)
          throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          beginElementAt(
            offset);
    }
    public boolean endElement() throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          endElement(
            );
    }
    public boolean endElementAt(float offset)
          throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          endElementAt(
            offset);
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
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
       "fKH5Ge7Y3+KP+PTt/wJkHYuhGywAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WSFMjZLnILAuLyyiUvG8EN+s8UwPkMjvZ24DdNC2bJgi9A3LxCVuhslelbMI" +
       "bkuXWo1ps2dJpJWVTaKkIdMS8JR9c1xP0NKWAaES2kgkdbOoYulyS/a9Mc10" +
       "2rVtw4kn3ng11mGG7I3n61bHq5XHtjWCkUk6s7KaVsZxMLO1lxRfQgaYaDTK" +
       "jUgSRqRDhMv5uou1FankuZ1QdSKnmakwSeNGm1nHWseXlXZ/YgeWU+pVAj2a" +
       "Jv5iTXbwVJ73WXttdOsdxVzVt/BShAnTHTJVW0KQZMbyrWiNxsSC49SqO53U" +
       "Vb5ZApFFe4oZKjxvL1fS3IXhhgzDvYXrqd1oCTultia2Qq8VdBIHb0aUzRhR" +
       "4Ky7HXwGh8lUxqMAG6U1H1Rm9DaJMD4rEvaYTOyebEppMs/6doIGG9EVw/YS" +
       "kav82Jk1W/YSl2bjpm6JbmcqDCLVHbmUrTuUtfW3XiCoo/I2HfF+ueII5pL1" +
       "iDHmKoC7DFxZNYKOM+tMBjNrBW+k5QhvYFprXiuN6BLNx3BK2Pg8MbBNiiDI" +
       "+96Xbxu99OZ27h4sNiSPbkz8LbYis+vsZOsxdLe8P+A4PrUrPueh/dH74ffp" +
       "A5bdIcXB4Rbvs/kWb1pTTu7snj6JzrfznrjWjYpiK+/TH3n5VXXymcq5/WFK" +
       "FkP3xH7wHkdba86Jbh8ELb1w7W1LsrhQcnxA8Qcf+bPH+fcbH3oT59NPnRrn" +
       "6SZ/jfzsl7F3Kj97Drrt6LjiqqsuV1Z68cpDintDLU5Cj7/iqOKJK/foy+Ch" +
       "9lKgTu/Rnzghu94G/XXOqn7hOnm/mJOfjaHvNz0zLq4VaYjjjM21hsRxaC6S" +
       "WIuKitEJDUxj6Pa1b6rHqvlzb+b4q0j4mSMW3JcnlsAj7lkgvhkWxNBdQWiu" +
       "5Vi7IR9+9Tp5v5aTX46hx475cCUT8vx/dAz4V24C8KOH1nZ5D/jym5W5fkOs" +
       "v3WdvM/n5HMxdAEEu7wcArq33EMrf/wMKz9ZpODAazfBgcL/PAGe5Z4Dy1vP" +
       "gS9eJ+/3c/J7MXQfwM7FchjzpqudpeZ3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LB1fPgH6CzcL+inwuHvQ7q0H/a+vk/dHOflKDD0AQPeSMATSzGHnqV86RvjV" +
       "m0WY3+qK9wjjW4/w35/KO7hygnrspOr2J+QgU7QgnwSKyt/IyZ+A+TaXu+kG" +
       "jtZPQvnw8swJLnz9ZrmQm/dP7LnwE7eeC392nby/yMl/jqFHAEgcTDuhY3p2" +
       "V9NN7wxx/5ebAPrwoUL/9B7oT996oN85W9z5z28WBf4qJ28AU17kCE96qVOm" +
       "fNdid+58jP2/3yz2p8Hzyh77K7cG+wl8X8oLHNxxAwYc3JUTYGkPnGQAUtyb" +
       "+usjrAcHN4s199af2mP91C2X88GDN4L5cE7ui6F7NU/dgzwF8f5bocqf2UP8" +
       "zP8jcT5xI5xP5eQxoM/HOK8S5ttuAumTeeIPgOe1PdLXbr0wn79OXiknF2Po" +
       "7XnYcaMbJc9cc7lxdI3kmCvP3QRX3pYnvhs8v7Pnyu/ceq60rpPXyUk1hh4G" +
       "XDlkAqrtbvUfMuOJM5ixu9uW31g85kPtZvmQ539xz4cv3no+DK6Th+Xkg7u5" +
       "65APuZZ40X4dd/DiMVDkZoG+AJ4v74F++dYDZa6Tx+VkvI9ENlGsuWPZ0xNZ" +
       "106BJG+FV/vaHuTXbg3IE07rAwWaH7oO0ss5mQGHZsjRkShPObT5TYDMJ+Hi" +
       "ZtvX9yC//mZB3nAFfWBeJ8/OiQoiz3w1deqy39EFPvEYq/ambooCUzjzun9+" +
       "cfmxq/5ctPtDjPK5V8/f/dZXhT8pbrwf/WnlnjF09zJxnJM3KE+83xmE2tIs" +
       "WHHP7j5lUOAL90H1WRf7Yug2QAu7XO1KJzH0lrNKg5KAniwJoF04XRIsuIrv" +
       "k+U+DOb843IxdOfu5WSRHwGtgyL5648Gh+7y7Iu+R7cRDzerdiuHx07qVhEc" +
       "PnQjMR1VOXmbPt+jKv4ZdriflOz+G3ZZee1VgvrwG83P7G7zK4683eat3D2G" +
       "7tr9saBoNN+TevqarR22dSf+/Hcf+M17njvcP3tgN+BjPT8xtqfOvjc/cIO4" +
       "uOm+/edv/e33/uqr3yguH/5fLat34LI3AAA=");
}
