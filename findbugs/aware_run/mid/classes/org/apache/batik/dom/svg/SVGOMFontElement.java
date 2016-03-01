package org.apache.batik.dom.svg;
public class SVGOMFontElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGFontElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean externalResourcesRequired;
    protected SVGOMFontElement() { super(); }
    public SVGOMFontElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
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
    public java.lang.String getLocalName() {
        return SVG_FONT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFontElement(
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
       "PBXBY2VlDaTbxyK4/WZEEEMP+6GVSrH2hnL4+/dp+7ky+7sx9PSZHC4KoWz/" +
       "O2cM/71vg+Eny8ryTtM8Zth8szr/0Bvy+ov3afulMvtCDD1maDHtKZI9PTZX" +
       "7Iy/L34b/JWsQd8HUnjMX/id5+9X79P2epn9kxh6N+Bv+EZH6y/cxZldOk8/" +
       "k8o//Tak8lRZ+QxI+2Op7L/zM/2r92n7jTL7MpgurpZNPVU7vc87L4DThord" +
       "r3wb7D5fVvZA+ugxux/9zrP7O/dp+w9l9m/AhAZGcPmm6PT2Z33G62+/qWtG" +
       "ILbLj0fKa/Cn73i3dnhrpXzxteuPvPM1/t9W7ydO30M9SkOP6Iltn795O1e+" +
       "6oeafogAHj3cw/nV338CXN3rQiiGHgB5RfDvH6D/Swy97W7QABLk5yH/8NgY" +
       "zkPG0EPV/3m4P46ha2dwMXT1UDgP8t8BdgBSFr/hn1ha7X63WIt4b5dqOQki" +
       "rpyLA46Nq9LTk2+kp9Mu519olLFD9fTwZJ1PDo8Pbytfeo2a/vA32z97eCGi" +
       "2FJRlFgeoaGHD49VTmOF5++J7QTX1fGL33r8Fx59/0lc8/iB4DNDP0fbe+7+" +
       "FmPo+HH1eqL4x+/8pQ/+g9d+t7q++n8RFiPdEyoAAA==");
}
