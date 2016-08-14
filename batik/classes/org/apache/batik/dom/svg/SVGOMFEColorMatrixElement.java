package org.apache.batik.dom.svg;
public class SVGOMFEColorMatrixElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEColorMatrixElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_TYPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_VALUES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_MATRIX_VALUE,
    SVG_SATURATE_VALUE,
    SVG_HUE_ROTATE_VALUE,
    SVG_LUMINANCE_TO_ALPHA_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected SVGOMFEColorMatrixElement() {
        super(
          );
    }
    public SVGOMFEColorMatrixElement(java.lang.String prefix,
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
        in =
          createLiveAnimatedString(
            null,
            SVG_IN_ATTRIBUTE);
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              1);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_COLOR_MATRIX_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getValues() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEColorMatrixElement.getValues is not implemented");
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEColorMatrixElement(
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
       "2RyyvTl/GHqimAtPQi84bf5nF7T9i7z4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("WlB6h2ZpQfEpQEYMg9IiGQExpa3DQPZveXoX2Zp0Yq5ffyPfg8+p4L68sgwe" +
       "61AF1htRQVC62/G0SAjk19TDNy5o+2ZefD0oPXqih7NKyNt/40Tgf/UmBH4o" +
       "r3yiIN39JW/U5u9/TVm/dUFbcbj7+0HpPkUOKFsUjPHhBxPkRL4/eBPyPZ5X" +
       "Pg2ejx3K97EfvXx/dEHbH+fFfwpKl4B8A6t6FOxP3iLYz37TOBH/P78J8Z/K" +
       "K58FzycPxf/kj178P72g7c/y4r+BuADiz099HHn3BfKf+iJyooT//iaU8GRe" +
       "+Rx4fuFQCb/wI1fC3qUL2i7nRX6tCyihuJPhH6nhmQvUsPsgkt+TOtbC3v6b" +
       "0MLDeWX+5f3zh1r4/BvVwmui+975m0Gn2x7JiyvAFSw5HtvSsStcPa2D44ZC" +
       "3Ktv1ugd8HzxUNwv/ujFfeqCtny0vccBiOeef+4iyvHlkuWJrE+8oVtMQenH" +
       "bntJNb9u9+hN1+N3V7rFr7x85fLbX178m92ljqNr1/dQpcub0DBO3/A59X7J" +
       "8eSNVqjjnt19n+I2xV4ZiHe7r5xB6Q5Q5pzvPbejPghKb70VNaAE5WnK6qFX" +
       "nKYMSncV/56mawSle0/oAMjuXk6TtMDogCR/bTtHLveTr3HzVzMC2Tu+JMEE" +
       "giUJnnSy/iZ7p7KoQ88rUOqh1zLicZfTt0Pz6wzF/3o4unoQ7v7fww3xqy+T" +
       "44/+oPnLu9upoiFkWT7KZap09+6ibDFofn3hyduOdjTWJeLZHz7wq/c8c5QV" +
       "PrBj+CQKTvH2rlvfA8VMJyhubmb/+O3/8H1/5+VvFZ9p/y8Is9XDjjIAAA==");
}
