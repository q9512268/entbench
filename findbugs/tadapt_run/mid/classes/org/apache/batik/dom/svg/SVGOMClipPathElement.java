package org.apache.batik.dom.svg;
public class SVGOMClipPathElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGClipPathElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_CLIP_PATH_UNITS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected static final java.lang.String[] CLIP_PATH_UNITS_VALUES =
      { "",
    SVG_USER_SPACE_ON_USE_VALUE,
    SVG_OBJECT_BOUNDING_BOX_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      clipPathUnits;
    protected SVGOMClipPathElement() { super(); }
    public SVGOMClipPathElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
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
    private void initializeLiveAttributes() { clipPathUnits =
                                                createLiveAnimatedEnumeration(
                                                  null,
                                                  SVG_CLIP_PATH_UNITS_ATTRIBUTE,
                                                  CLIP_PATH_UNITS_VALUES,
                                                  (short)
                                                    1);
    }
    public java.lang.String getLocalName() { return SVG_CLIP_PATH_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getClipPathUnits() {
        return clipPathUnits;
    }
    protected org.w3c.dom.Node newNode() { return new org.apache.batik.dom.svg.SVGOMClipPathElement(
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
       "P3oP/+8X1L1RJH8C3MTTMtpXj++Vrp0W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wnFFye63fwh2izd3lS74Xjpk96UfPbt/fkHd94vkz4AjA+Wfv+s+vr9envD6" +
       "v97SQ4mk8vZbPYErHvM8etNL3P3rUeXLr169512v8r+3vyc+euF5L1W5R984" +
       "zun3A6fyV4JI062So3v3rwnKC9pLVwBnt7vvSSp3gLQg+tJd+9b3Anpv1Rq0" +
       "BOnplvcfGsTplknlrvL/6XZXk8p9J+2SypV95nSTh8HooEmRfSQ4srbqRZdU" +
       "w0gKTEuJj1bbS6cWzEMDK3X18Jvp6rjL6XdmxW1o+Zj66OZys39OfUP5yqsk" +
       "/dIb7V/cv3NTHGm3K0a5h6rcvX9yd3z7+dRtRzsa6wrx/Pce/JV7nzsKAB7c" +
       "E3xi7Kdoe/LWL8pwN0jKN2C7f/yuX/3g33v1D8rLqf8HpGGQVeUuAAA=");
}
