package org.apache.batik.dom.svg;
public class SVGOMCursorElement extends org.apache.batik.dom.svg.SVGOMURIReferenceElement implements org.w3c.dom.svg.SVGCursorElement {
    protected static final org.apache.batik.dom.svg.AttributeInitializer attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XMLSupport.
                                                 XMLNS_NAMESPACE_URI,
                                               null,
                                               "xmlns:xlink",
                                               org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI,
                                               "xlink",
                                               "type",
                                               "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected static org.apache.batik.util.DoublyIndexedTable
      xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t =
               new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMURIReferenceElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(null, SVG_X_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMCursorElement() { super(
                                       );
    }
    public SVGOMCursorElement(java.lang.String prefix,
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
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_CURSOR_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_CURSOR_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_CURSOR_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
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
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMCursorElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
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
       "T4OsyzQBsSxH7Rqd1XtEBi/mzYUp+ghvozO5l0bMttou4f6qs2ytEjjqaBvY" +
       "SYNo07a8SikTVqlJuBaFtZJGk8/YTaM2aq1rgTrxawYxFKlhnVwTFOZZma/I" +
       "dC9pA/c5dnCWk5LexMA1voW5m/YKOG9iv0+TChBAHM0dpKEwzlSacjA7HyuT" +
       "SlOWB36lNvYXPRJDsJI9xqo8GTo2sVZdcxsT7qBpygE6V2sJ1SwrOoGutwMa" +
       "pR0e2TRGJsdWyQTBWuUUqxqMBNwjGuvhhozq9pibEkKlUUetlWXPwEI1Q8SI" +
       "QvgI9Q0Fa2/LCetXQ970uvY0M1alxYJFLWHdHsc+vy2RgGOsljQaYLDAtTka" +
       "ASOmVmmmjsNjFZutWroaCRyHNQO3Sg9bOnA0eYHyy3OsWSM6JaXbt5sRywyx" +
       "tQf6gV2nM24QNWzGyuXIwrJZ6FaQICPKqz5L85iQGhQ3MEYrqZNUqo7AORaC" +
       "LuZbgC1JlkZJU0jO2GzV9XgdY9vupjNkRmhWS2mqXal2losuv2XFDNOdxqID" +
       "k1xbING+P9gQvbDfo6fmQm6mCwYXZtagiwzJcYZI2qCPlktda740tF5KNAep" +
       "qQBdwsKi3XdqhNGQU5vs2qI66gBxpj21k9SsJtublht8O1kHqMOKi4SHPVQb" +
       "KTIllGYNK3VmSVMkV535zGaQDcsDc1KpUre+bNPqqjLOtGg89RBJDzNuIDLT" +
       "VROh+SanGY2eajZxC4mznijPtlY9amNTc5DUmwNYq1b91RDZDiqIJYtep+J1" +
       "rUbPMapC11/j5bI/4vUM7jHzPpKm0nhUatOsTJO2zcvu2myQwPlG+0pdZlfk" +
       "aIJtQp5tkVjbT4Z+L1qqPLoKK0S/hJcr89k0RKhx3Fn4enledrGZlaKreUIm" +
       "VUyfWtiMH4qdhAo6bb9OjJfWGG0qGsz3pg7WmLVTb1QhtuNJvQ0cDDrrhsDO" +
       "RrmdiYs+WxXaoahUyBlmZQm11OxVQlRHguzCnOs0G7iX0U0nNeNJZebAfpcu" +
       "qSjYfA4pP7TWVFCtaNXy1IaTrklG6XBoVunGhnHK1YhEKtYENZWQIUsrhqun" +
       "RKtdo4QwFRacNVg2fKazAWv+oCV0I5dQxIYsA9JwNHoMBnBe1RuZlAqjESKZ" +
       "8mLTMOczrgRzeKe1QbqJHyzc0qQRV+Ks3BDE2Jj1bWrGDsNmFo+NUEbDmjRV" +
       "tVIfDUgSRpurCjyyM6NZW5h42hwB97NWKdVIKuMtRQB7yUYoqx7ahZl6haJr" +
       "84jF59tWZVYGAxqMeKeCGD2rNbDwYBBvwyVlx9WuyuAYx/g8O1PLkcd0pQ2t" +
       "NcGs8r0OLJO8K/cVLOwTMhbNQxsuqUuwjUDCCt7bAJB1vF82vLY829BG2VNh" +
       "nYhm6SDzzNSn673eGle1Fj+vqhajV0tDwtr0t8LE8WeZUrPKEuJWO4KBOCQ2" +
       "7U55frJRjHVdMrNkOpzSlkX3GFGew6bD10JsM2DVDQ1n9Q4xXeveZik3oqRv" +
       "ZK6liBELPOkt0RYlYUyG7S5nmJTs2ZThCo2SKJazsZqZHZ1mUUPULWpTllwM" +
       "w4oDsJ9/eydk9xcHf0c3XX6AI79d1tN59MLRCWvxuQgd3Io4/D5xwnritdDe" +
       "4THpU/kxaVJVT56OnroOkB+LPX6jmy7FkdiXP/HyK9roF8sXDt5d/VwE3RW5" +
       "3gctfaNbJ/q8F7T03I2P/4bFRZ/j90Gvf+K/Pcb/6PLjb+OSwJNn5Dzb5N8d" +
       "fu23uj+k/twF6Lajt0PXXEE6Xen50++E7g70KA4c/tSbocdPH3IjIDgHQ+Cc" +
       "PeQ+HuRzT7jPeTX46jl5fz+PvhpB7zaPXulgYAqYG/3oZU9YVPwbJyzsb0XQ" +
       "7RvX1I5N7++9nbeNRcJXjlRwT55YAmFzoILN21FBBF3yAnOjRPqb6uEb5+T9" +
       "eh79kwh69FgPp5WQ5//DY8D/9CYAP5AnPgHCJw8Af/LtjvmH3hTrN8/J+1d5" +
       "9BsRdM9Cj2hXVSzmwFyxY3yv3wS+/K079DQIP3uA72dvPb4/OCfvD/Pod4GN" +
       "AnyzQ9p6+jq0dfrF2TH4f30rwH/uAPzn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("bj34/3JO3h/n0Xd24KX8+d8f4/qPN4Ert1foR0D40gGuL916XG+ck/ff8+jP" +
       "Iug9ABf5Zq/ynjlnsA/e3x1r5bs3oZV35YkfAOErB1r5yq3XyvdvnLdXNPGX" +
       "EfQg0MqhEjr67pbuoTIev44ydldQ8utGx3r43s3qIc9/9UAPr95yPezde07e" +
       "5Ty6M4IePqGH3Eqc8GD937vtCOjeXTcL9DkQvn4A9Ou3Hui7zsl7dx49BDxC" +
       "AHSyDSPdphVnESsL/QzIh28C5IN5Yn5r9hsHIL9xa0DuHRfACjTvOwfp+/Po" +
       "KbBKLZXw1FCedUUuzc/M6L2nbwL7e/PEnOdeP8D++tvF/qYO2R56Tl49j+AI" +
       "egQM8I3u20jHUJGbHebHQPjWAdRv3Xqo51xZ28Pz6HkwgI6eMK6mHxLWlZOE" +
       "dZRRwH3hJuDmizLUAuH3D+D+/q2Hy5yTx+ZRD7iYYGTPXlI6ung0P8baf1s3" +
       "+CLogWtvZud3TB+95q8hu78zqL/8yuU7H3lF+IPicvLRXw7uoqE7jdiyTl5r" +
       "O/F80Qt0wyz0cNfukptXgBMBrhvdn4mg20BcsPB0V1qOoIeuVxqUBPHJkh89" +
       "MIeTJSPojuL7ZLmPR9Ddx+Ui6OLu4WQRFbQOiuSPmndoa+XzL/0I497RzezD" +
       "7e1uJ/zoSSMr1s8H3my8jqqcvASd72qL//gc7kDj3b98XlRffaXP/Ngb9V/c" +
       "XcJWLSXL8lbupKFLu/vgRaP5LvbpG7Z22NZF6tnv3fcrd73vcMd9307gY4M/" +
       "IduT17/uTNpeVFxQzv7xI//oha+88kfFtZ//B/gnhIZ8NQAA");
}
