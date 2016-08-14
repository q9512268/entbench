package org.apache.batik.dom.svg;
public class SVGOMFETurbulenceElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFETurbulenceElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_BASE_FREQUENCY_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_NUM_OCTAVES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_SEED_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_STITCH_TILES_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_TYPE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      STITCH_TILES_VALUES =
      { "",
    SVG_STITCH_VALUE,
    SVG_NO_STITCH_VALUE };
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_FRACTAL_NOISE_VALUE,
    SVG_TURBULENCE_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedInteger
      numOctaves;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      seed;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      stitchTiles;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected SVGOMFETurbulenceElement() {
        super(
          );
    }
    public SVGOMFETurbulenceElement(java.lang.String prefix,
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
        numOctaves =
          createLiveAnimatedInteger(
            null,
            SVG_NUM_OCTAVES_ATTRIBUTE,
            1);
        seed =
          createLiveAnimatedNumber(
            null,
            SVG_SEED_ATTRIBUTE,
            0.0F);
        stitchTiles =
          createLiveAnimatedEnumeration(
            null,
            SVG_STITCH_TILES_ATTRIBUTE,
            STITCH_TILES_VALUES,
            (short)
              2);
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              2);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_TURBULENCE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBaseFrequencyX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFETurbulenceElement.getBaseFrequencyX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBaseFrequencyY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFETurbulenceElement.getBaseFrequencyY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getNumOctaves() {
        return numOctaves;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSeed() {
        return seed;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getStitchTiles() {
        return stitchTiles;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFETurbulenceElement(
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
       "RlC36RCatymLZDb1jsv6qK1Ua+HKp+oU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("mknLGdiBVeWBJPGTITHVrFalV6nP4XIl7ld9qEZCNWuYkGsYqRmmasD+omPV" +
       "B3NqXPVgat6ANlUzbuEZlYAYPmw09cCWmwysNeQyb0prKlJNCGrhjUbU86XQ" +
       "rDe6KG53BYKnekS77TRqHZJpdNwp6bY3SIsj6dDNAkBoqE4mDhZTcsg1ERF2" +
       "lW4SjMho6+tGiq05rrzQQagMJRYdb3rMpL7pgUU22XRgMk2m62yoYa1+pQnW" +
       "fA0Dzk4RnXUjGK4GLi7ieiKZjheuY17xSGbawGJvWsWZhUhNoTXplyWx3a21" +
       "oA4Ydqsm9YGPIEjx9Ozrt/Z47aHiqeHxocQf4nlheuqdx/GD1eIvf6nw3P7+" +
       "uTMPVk+9yz84evL79vzJb1JXTj/wvcFJrvx12JM3O5pYvAr7/MdefkUd/VL1" +
       "wv79yCYs3R263o9aWqxZp0a+p7jPrn0cXMnx7aVOzj4OPtHLuc+Cz3lX84fn" +
       "lP2XPPlmWHqL6Zhh8SJNQyyLMmMNCUPfXETh/jH52YeesWuqJ9b697dyquKM" +
       "Cu7NM8vg+sheBR+5FRWEpTs934zlUHtVPfzZOWXfyZP/HpYeP9HDtUrIy//o" +
       "BPCfvA7AD+eZT4HrU3vAn7pVm7/nVbH++Tllf5kn3wtL9xpaSLmKbDH7143I" +
       "Cb7vvw58T+aZefln9/g++4bjOzg4p6wgnr8CRAPwoXKgdX1tE4HZvJWOpv3T" +
       "N5j2176uOtHEX78RmvjFvSZ+8Y3XxAPnlD2UJ5duoIlZXnDHMciDe14HyNyT" +
       "i/n7hT3IL7zxIN9yTln+Mvzg0bB0HwDJXPee9ZlzTL1/uXqihsder62vgOsr" +
       "ezV85Y1Xw/PnlJXz5AqgQ6AGXtPUMxZ+7nVAeybPzBep39hD+403HlrznLI8" +
       "QDiohKX7c2jXv7690SJ+g3e2J7qovl5dPA+ur+518dU3XhfYOWVEnrx3Z+b9" +
       "oZCDk+ONB+97HdAeyTPzU1Zf30P7+q1Ce9VY5GB0Ttk4T4YAmqMljKsen/V5" +
       "8LR9jwsKuOTrgPt0ngmD6xt7uN944+G+eE7Z1TyRQMiRW/LM4cPjA4XSCdbZ" +
       "LZ1cBf3e7LuE/IT149d9DrX7hEf58isP3PXYK5P/uDu/d/SZzd1U6S49sqzT" +
       "hzpP3V/0fE03C23cvTviWRycO9CBFDc7WxGWbgNpLviBtqtthqU33ag2qAnS" +
       "0zWtvVOcrhmW7ij+n67nhqVLJ/XC0sXdzekqPugdVMlvA+/I4973Kt96mFao" +
       "+cfn4fhQdlTZV0+CxXQXnjx+2vGKYOLhV7PhcZPTHwTkJ9eKr9yOTplFu+/c" +
       "ripfeWXIfPj7rV/afZCgWHKW5b3cRZXu3H0bUXSan1R7+qa9HfV1sf/8D+7/" +
       "1bufO9rC3L8T+GQSnJLtbTc++k/YXlgc1s9+87F/9u5/9MofF0cx/h+rW0F3" +
       "fjgAAA==");
}
