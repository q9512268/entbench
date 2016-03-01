package org.apache.batik.dom.svg;
public class SVGOMImageElement extends org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement implements org.w3c.dom.svg.SVGImageElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      5);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns:xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "embed");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMImageElement() { super(
                                      ); }
    public SVGOMImageElement(java.lang.String prefix,
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
            SVG_IMAGE_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_IMAGE_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_IMAGE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMImageElement(
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
      ("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" +
       "/ge+B0w5wiYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wRDz1FpFKo23JFxJ4kHbT9v9NHYrVZhIq1t6zVI1X4ylajYYo82avFz2quYo" +
       "mXrjDbmyfGfOdLWt3ooWemeVIZWSLmqhE86RVq2hJK6jJuFi7ThOPBou3Drd" +
       "jGa1akuNaIXXtSZWa46nLEzgaH+JwZueJjr0yMAaI7SJe/a6to2aWIgaU39b" +
       "rUejEboqVaqMtK3Vp7XeZq2JlC50jT66miLONtvC7KqybokeMiwjqGQzVWFM" +
       "qhO9BkL5udbD5pzTEemp2+lhuNrslTuVfjYf0XyfmQlrgws68Lo0mqHz0kaZ" +
       "+1u82uQbQ5xHHUn2M8zXhHZo9IwOInc7GlU2mylgbrwnZiLHryNN6U5LNLaA" +
       "e7Shwri/slJW4uZwq1M1FkCnbrtB1zuxMtmM0vEYq7aTcNuZAO8586cgoJ06" +
       "TqsEs5SbyQgH+IrgYQ4bcTBeXzVwEngyuRVmbLICkQqbLGGsWcLqMmG1VHaD" +
       "wcK4Mx4gtM+GDuE1N4JRwRaVcSKWKwaPprDbJ+YaY25gtlMd57IYncbI78S9" +
       "zaZkUMLYIOr8FK7UhX6rlvlGI8R8y2kM6EUlaPpsuQvPe4RsDP16gLnzyphy" +
       "8XpGDOerMQ68Z2IOXI3BCWkRRkOw/jlC3ZYT0gEBCIK4obfIuliW8mJflYiw" +
       "QvOY5JQktBZtjZLcsVb9BmcQ89qsP5SwfrsCd2BQH+2MOrKpLBEhGHYRYRTM" +
       "JCIxKkIWaDxtTdUOTLM2Dc+IqjEpdetzt1tjnCpcIte9GYGA2E+dmVUpnWFk" +
       "rGMw3XQ1A1fVgaPBS2kgc54/QJd9ownIxe2ngS2h06zK1Ht132oEqMkn9QWV" +
       "wHa8qrF+VU7DuNnUpwtdDAdr3QqMfr1Z4SckCIuwFVbSK1ZvYne6MTIa8qIy" +
       "bW5Jj6AidyIJDW8WDAFdStvBJFVgrSFRdLkTRD1qjSitjBFdoiKTFOpvJcUU" +
       "Yrxj4HFvtBok9YESjCPgyklGr2sRiDsdqccaA7Iz8LK4npCrRsAtYxc2Fny8" +
       "acmM0twgFs4OebQZTKdOsE27i1Hk4Maw0tBXVuBWfX6w6PYpKx6UtGo9YcqW" +
       "VJuHxLRbK7m2tEhmnkcbNdSj6ZFY95SOtx50sDWKgsB1U0lGSaA19Ki0mYvo" +
       "fNp3aaaymU26y6VXEblmy0P5MOjM0SWH9jOqCgdgLdTFcnkK4hgQaqDGutys" +
       "qUibbDZVMDfkoDtuoIGts6XUS5AQPFPUJ6TU5ZpBc8bWN4rqYoSwKPctShNl" +
       "LgiDsdNWMsa31hbcKgmmuqxgWilR6das41XGi6qXaJzlUa1anQhgL/CmIi17" +
       "CzPyuO2YZ3GhLSGtTXm02LKcYQl0Rx72k2xT25STlkqEw05HDWSU2uDKdpk6" +
       "cdKoz+KACLMRNeiTVRPpIFyjJSByyqjwKiz5nt8DT4WIqZbolTQPFJog/S7L" +
       "wwYgXyStpeYMw7D3FZtLX7i93af7i021w/M2P8J22q7oqTx57+EeZvG5AO2f" +
       "zTj4PraHeez91N7BduQT+XZkiqrHdyGPH0vId5weO+24TbHb9PmPvPiSNvpC" +
       "+dz+O7TPRdDdkes9Z+mJbh0b8h7Q07On76zRxWmjo/dSX/vIf3mU/4nlh27j" +
       "sMITJ+Q82eXfpr/0u713qr90Drrj8C3VTeegbmx0/cZ3U5cCPYoDh7/hDdVj" +
       "N+4iI+D68P4MfPjkLvLRHJ+5hXzGK8qvnlH2j/LkNyPorebhixjMsoZmoh++" +
       "ogmLhn/jmIH9zQi6M3FN7cjy/v7tvPUsMl4+VMG9eWYJXB/dV8FHb0cFEXTR" +
       "C8xEjvRX1cM/O6PsX+TJ1yLokSM93KiEvPy3jwB//XUAfiDPzE9GfXYf8Gdv" +
       "d87f96pY/+CMsn+XJ9+KoHsNPRq6qmwx++aKHeH7l68D32N55lPg+tw+vs+9" +
       "8fj+8xllf5Qn3wE2CvBND1jrqVuw1o0v8I7A/4c3AvwX98F/8Y0H/z/OKPuz" +
       "PPlvO/Cz/P5PjnD999eL62lwfXkf15ffeFw/PL1sr+jiLyLoLoBLOnileAzb" +
       "D14vttz1vbyP7eU3HNvePWeU5W9q9i4A");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Jwiw9Q/fTR6B27v4OsA9m2fm7X5rH9xvvfHgHj6j7Mfy5IEIegiAu8UryoP1" +
       "ee2M9Xlas0I3D74O3bwjz3wPuH5nXze/c7u6eVXvu/f0GWU/nidPRtDDQDen" +
       "HYlQjqA+9TqgPphnPgqub+xD/cYbD7V8RhmaJ+8G3trRU8bV9IN5v3J83g8L" +
       "CrjPvQ64OQNDLXB9cx/uN994uO8/oywPzffeA+IJMLMnT/4cnuaZHmG9flvH" +
       "xsADwU2ngfNzjY/c9F+E3fl59csvXb7r4ZeEf10ciD084373ELprEVvW8aNU" +
       "x+4veIG+MAs13L07WOUV2PoA1mlHEiLoDpDmEu/1drWpCHrzrWqDmiA9XpPZ" +
       "t4bjNSPofPF9vN44gi4d1YugC7ub41V40Duokt8K3oGpNc46RyFw5OFZ4F4g" +
       "e0tTDQ8eaHaPPo8ct7TC5zzwapN22OT48dv8Oab4a8nBM0e8+3PJ8+pXXhow" +
       "P/39+hd2x39VS95u817uGkIXdyeRi07z55anTu3toK8L/Wd+cN9v3P30wTPW" +
       "fTuBj6z+mGxP3Pqgbdf2ouJo7PY3H/677/3iS39YnKH4fwSfPrTzMwAA");
}
