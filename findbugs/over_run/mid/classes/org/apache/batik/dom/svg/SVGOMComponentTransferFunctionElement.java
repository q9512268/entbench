package org.apache.batik.dom.svg;
public abstract class SVGOMComponentTransferFunctionElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGComponentTransferFunctionElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_TYPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_TABLE_VALUES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_SLOPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_INTERCEPT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_AMPLITUDE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_OFFSET_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_IDENTITY_VALUE,
    SVG_TABLE_VALUE,
    SVG_DISCRETE_VALUE,
    SVG_LINEAR_VALUE,
    SVG_GAMMA_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList
      tableValues;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      slope;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      intercept;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      amplitude;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      exponent;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      offset;
    protected SVGOMComponentTransferFunctionElement() {
        super(
          );
    }
    protected SVGOMComponentTransferFunctionElement(java.lang.String prefix,
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
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              1);
        tableValues =
          createLiveAnimatedNumberList(
            null,
            SVG_TABLE_VALUES_ATTRIBUTE,
            SVG_COMPONENT_TRANSFER_FUNCTION_TABLE_VALUES_DEFAULT_VALUE,
            false);
        slope =
          createLiveAnimatedNumber(
            null,
            SVG_SLOPE_ATTRIBUTE,
            1.0F);
        intercept =
          createLiveAnimatedNumber(
            null,
            SVG_INTERCEPT_ATTRIBUTE,
            0.0F);
        amplitude =
          createLiveAnimatedNumber(
            null,
            SVG_AMPLITUDE_ATTRIBUTE,
            1.0F);
        exponent =
          createLiveAnimatedNumber(
            null,
            SVG_EXPONENT_ATTRIBUTE,
            1.0F);
        offset =
          createLiveAnimatedNumber(
            null,
            SVG_EXPONENT_ATTRIBUTE,
            0.0F);
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getTableValues() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGComponentTransferFunctionElement.getTableValues is not im" +
           "plemented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSlope() {
        return slope;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getIntercept() {
        return intercept;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getAmplitude() {
        return amplitude;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getExponent() {
        return exponent;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getOffset() {
        return offset;
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
       "plmnCsW3cMlrGnp1aDv+uPt/2DtYJGsqAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e7Ak13nX3JV2tXruSrJsIVv2SloZSePcnndPR35N9/T0" +
       "PLpnph/T8zDWut/d0+/XdM84wo5TwQZXGRNkYyCR/8DBYBQ7uEgRQgVEKPKu" +
       "VEWVAkwVcaBCkWBcZRcQHgbC6Z65j7279+6upSpuVZ/b0+fR3+/7vvM733n0" +
       "a98tnA+DQtFzrbVmudG+kkb7S6u+H609Jdzvk/WxEISKjFlCGHLg2TXp6Z+/" +
       "9Cc/+Lx++VzhwqLwqOA4biREhuuEjBK61kqRycKlo6e4pdhhVLhMLoWVAMWR" +
       "YUGkEUYvkoX7j1WNClfJAxEgIAIERIByEaDWUSlQ6UHFiW0sqyE4UegX/nxh" +
       "jyxc8KRMvKjw1PWNeEIg2LtmxjkC0MLF7DcPQOWV06Bw5RD7FvMNgL9QhF75" +
       "ay9d/uZdhUuLwiXDYTNxJCBEBF6yKDxgK7aoBGFLlhV5UXjYURSZVQJDsIxN" +
       "Lvei8EhoaI4QxYFyqKTsYewpQf7OI809IGXYgliK3OAQnmoolnzw67xqCRrA" +
       "+vYjrFuEnew5AHifAQQLVEFSDqrcbRqOHBXec7LGIcarA1AAVL3HViLdPXzV" +
       "3Y4AHhQe2drOEhwNYqPAcDRQ9Lwbg7dEhSdObTTTtSdIpqAp16LC4yfLjbdZ" +
       "oNS9uSKyKlHhsZPF8paAlZ44YaVj9vnu8P2f+7jTdc7lMsuKZGXyXwSV3n2i" +
       "EqOoSqA4krKt+MAL5BeFt//yZ84VCqDwYycKb8v8wx/7/off9+7Xf31b5p03" +
       "KTMSl4oUXZO+Ij70u+/CnkfuysS46LmhkRn/OuS5+493OS+mHuh5bz9sMcvc" +
       "P8h8nfnV+Se/pnznXOG+XuGC5FqxDfzoYcm1PcNSAkJxlECIFLlXuFdxZCzP" +
       "7xXuAfek4SjbpyNVDZWoV7jbyh9dcPPfQEUqaCJT0T3g3nBU9+DeEyI9v0+9" +
       "QqFwGVyFCrjeW9j+Xc2SqPAJSHdtBRIkwTEcFxoHboY/M6gjC1CkhOBeBrme" +
       "C4nA/80fKe/DUOjGAXBIyA00SABeoSvbTEh2bShcAcfiiRGFAXiuozgRFwhO" +
       "CGzViR3pgEXA4/3MEb3//yKkmZYuJ3t7wIDvOkkfFuh5XdeSleCa9EqM4t//" +
       "+rXfOnfYnXb6jQofBHLsb+XYz+XYB3LsAzn2b0uOwt5e/vq3ZfJsfQdY3gQc" +
       "Atj1gefZj/Y/9pmn7wJO6yV3A7OdA0Wh00keO2KdXs6tEnD9wutfSn6c/0Tp" +
       "XOHc9WydYQCP7suqjzOOPeTSqyd76c3avfTpP/qTb3zxZfeov15H/zsaubFm" +
       "RgNPn9R24EqKDIj1qPkXrgi/cO2XX756rnA34BbAp5EA/B9Q1btPvuM6Onjx" +
       "gFozLOcBYNUNbMHKsg748L5ID9zk6EnuBg/l9w8DHT+U9Y8quIJdh8n/Z7mP" +
       "eln6tq3bZEY7gSKn7g+w3s/869/542qu7gOWv3Rs3GSV6MVjzJI1dinnkIeP" +
       "fIALFAWU+7dfGv/VL3z30x/JHQCUeOZmL7yapZmfARMCNf/kr/vf+vbvf+X3" +
       "zh06zV5UuNcL3Aj0LUVOD3FmWYUHz8AJXvjeI5EAOVlK7rrh1Ylju7KhGoJo" +
       "KZmj/u9Lz5Z/4T9/7vLWFSzw5MCT3nfrBo6e/xm08Mnfeum/vztvZk/KBscj" +
       "tR0V2zLuo0ctt4JAWGdypD/+xpN//deEnwHcDfgyNDZKToGFXA2F3G5Qjv+F" +
       "PN0/kVfOkveEx/3/+i52LIi5Jn3+9773IP+9f/L9XNrro6Dj5qYE78Wth2XJ" +
       "lRQ0/46Tnb0rhDooV3t9+OcuW6//ALS4AC1KgObCUQAYKL3OOXalz9/zb/7Z" +
       "P3/7x373rsK5TuE+yxXkjpD3s8K9wMGVUAfklXof+vDWuMnFg7EgLdwAPn/w" +
       "xI09YLPzjM3Ne0CWPpUlz97oVKdVPaH+cztay34/BuLLHGUWouxvQ5SDjGdv" +
       "SrMtEZALAN12pThj01yuD55h4XaWIHlWJUt+dAu9flta2pZ9PP/1ADDj86cT" +
       "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" +
       "KaQfDYn5eNEqrrqrDuTJFUtPBibSInC9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("N/flCq0iAl+Sew1blHTe1ttBCaKLbKfONmewXYbrUK9KD7twkw2TKCEtlGiN" +
       "ja66UmEUnkRoEWdnZtdmOR1nepBBRk0DHkyNcNjYrOoay6fDAWJyumG5lWSg" +
       "gCC0P20NovUS7kCVMCl5GOQvYKhbnw+mTEUv2tPayKhzddkmuGksKPUFiRg1" +
       "SV9SrsC1WxpvOJ5lO1g4rUqUFRCOVxbaq2I8jqBKO5r3CTCTbrU+kC0dvXFn" +
       "S1oP5yt1h4csf4g1uvSMDWsjKlwUducYjg7n5H+XCrvTegf/j611HjuLsHew" +
       "ll7N1tKTqnR8Cf1WB9Cy/b0nTzuUme/tfeVTr7wqj362fG63veNFhXsj1/sR" +
       "S1kp1jEx7svv19cv15bA9RM7CD9xcrn2SINnrtWesdX0x2fkfSdL/jAqvNNw" +
       "jCjfGVRalkUaK6UVRYEhxtFuM+XkkuTKNeQju/6HOzkickIFDxyso392p4LP" +
       "3okKosI9XmCshEi5pR7+5xl5P8iS/xIVHj/Sw/VKyPK/ewT4v74JwE8fLNF/" +
       "eQf4y3dq81vuVO6dPyPvniwpAMVpSsQd2/p77016xk32+w6VsLf3JpTwVPYQ" +
       "AtdXd0r46luvhEfPyHssSx6KCg9lSrhx4/DZM3RxtFt4pIpLb0IVT2YPnwXX" +
       "N3eq+OZbr4qnzsh7JkveBRgWqII9vu341C2VcKSAJ9+sArIO8Us7BfzSW6+A" +
       "M4407mVHGvdeiAoPAAX0jm1a7j17hK/4VuD7lR2+X3nr8b14Rl42nu81tvha" +
       "x3Y/j+OD3yy+bOv7N3f4fvOtx0eckZdtde2hUeF+gA8/2kY9Dg97s/CyDwPe" +
       "2MF7462Hd1beJEuGIKAA8EYH+7HHwd3y3NyteBgB17d24L51p+BuGYDsXTsj" +
       "T8iSBRh4Mx4+cZ7w8Iwgf4T1lqdkrjuMCoj8tr4wyM5KP37Dt1Hb73mkr796" +
       "6eI7Xp38q+05vYNvbu4lCxfV2LKOH9o8dn/BCxR1a/d7t0c48wNyezqAetpp" +
       "jqhwF0gzFHvatrQZFd52s9KgJEiPl3SiwuWTJaPC+fz/8XJ+VLjvqFxUuLC9" +
       "OV4kAq2DItlt7F03IJ5+BOUgUN47FuvufC2Plx65ldkOqxw/wJ+dQcs/bDs4" +
       "LxZvP227Jn3j1f7w499v/Oz2AwLJEjabrJWLZOGe7bcMeaPZmbOnTm3toK0L" +
       "3ed/8NDP3/vsQez+0FbgI78/Jtt7bn5UH7e9KD9cv/nFd/yD93/11d/PTwj8" +
       "P3sBEa5xOAAA");
}
