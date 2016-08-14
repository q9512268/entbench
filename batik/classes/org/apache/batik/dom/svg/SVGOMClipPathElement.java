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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "EAKSvc+f/cPn74/OqftPefb7EXQd8Eec");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dfL+/jM8/ozj9iNp/MEPII1H88L8ZjDal0b0w/fw/35O3Zt59ifATRw95Vzt" +
       "8H7q+nEhHFYU7H7rB2A3f58HNUF6eZ/dl3/47P75OXXfy7M/A44MlH/6zvzw" +
       "Hnx+xOv/elsPLiLonWc9pcsfBT12x6vd3UtT9YuvXbv/Pa9Nfm9333zwGvQK" +
       "A92/iC3r+DuEY9+XvUBfmAVHV3avEoqL3guXAWd3uzeKoHtAnhN94dKu9RVA" +
       "71mtQUuQH2/5wL5BHG8ZQZeK/8fbXYugq0ftIujy7uN4k0fA6KBJ/vmod2Bt" +
       "pfMuu7qB7Bkm2Eftr7YXji2Y+wZW6OqRt9LVYZfj79XyW9Xi4fXBDWi8e3p9" +
       "W/3Sa33u5Tfrv7h7L6da8nabj3I/A923e7p3eIv69F1HOxjrcu/57z70K1ee" +
       "OwgAHtoRfGTsx2h76uyXaaTtRcVbsu0/ec+vfujvvfaHxSXX/wMFI++FES8A" +
       "AA==");
}
