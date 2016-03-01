package org.apache.batik.dom.svg;
public abstract class SVGOMTextContentElement extends org.apache.batik.dom.svg.SVGStylableElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_TEXT_LENGTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_SIZE));
             t.put(null, SVG_LENGTH_ADJUST_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final java.lang.String[] LENGTH_ADJUST_VALUES =
      { "",
    SVG_SPACING_ATTRIBUTE,
    SVG_SPACING_AND_GLYPHS_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.AbstractSVGAnimatedLength
      textLength;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      lengthAdjust;
    protected SVGOMTextContentElement() { super();
    }
    protected SVGOMTextContentElement(java.lang.String prefix,
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
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
        lengthAdjust =
          createLiveAnimatedEnumeration(
            null,
            SVG_LENGTH_ADJUST_ATTRIBUTE,
            LENGTH_ADJUST_VALUES,
            (short)
              1);
        textLength =
          new org.apache.batik.dom.svg.AbstractSVGAnimatedLength(
            this,
            null,
            SVG_TEXT_LENGTH_ATTRIBUTE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true) {
              boolean
                usedDefault;
              protected java.lang.String getDefaultValue() {
                  usedDefault =
                    true;
                  return java.lang.String.
                    valueOf(
                      getComputedTextLength(
                        ));
              }
              public org.w3c.dom.svg.SVGLength getBaseVal() {
                  if (baseVal ==
                        null) {
                      baseVal =
                        new SVGTextLength(
                          direction);
                  }
                  return baseVal;
              }
              class SVGTextLength extends org.apache.batik.dom.svg.AbstractSVGAnimatedLength.BaseSVGLength {
                  public SVGTextLength(short direction) {
                      super(
                        direction);
                  }
                  protected void revalidate() {
                      usedDefault =
                        false;
                      super.
                        revalidate(
                          );
                      if (usedDefault)
                          valid =
                            false;
                  }
              }
              
          };
        liveAttributeValues.
          put(
            null,
            SVG_TEXT_LENGTH_ATTRIBUTE,
            textLength);
        textLength.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
    }
    public org.w3c.dom.svg.SVGAnimatedLength getTextLength() {
        return textLength;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getLengthAdjust() {
        return lengthAdjust;
    }
    public int getNumberOfChars() { return org.apache.batik.dom.svg.SVGTextContentSupport.
                                      getNumberOfChars(
                                        this);
    }
    public float getComputedTextLength() {
        return org.apache.batik.dom.svg.SVGTextContentSupport.
          getComputedTextLength(
            this);
    }
    public float getSubStringLength(int charnum,
                                    int nchars)
          throws org.w3c.dom.DOMException {
        return org.apache.batik.dom.svg.SVGTextContentSupport.
          getSubStringLength(
            this,
            charnum,
            nchars);
    }
    public org.w3c.dom.svg.SVGPoint getStartPositionOfChar(int charnum)
          throws org.w3c.dom.DOMException {
        return org.apache.batik.dom.svg.SVGTextContentSupport.
          getStartPositionOfChar(
            this,
            charnum);
    }
    public org.w3c.dom.svg.SVGPoint getEndPositionOfChar(int charnum)
          throws org.w3c.dom.DOMException {
        return org.apache.batik.dom.svg.SVGTextContentSupport.
          getEndPositionOfChar(
            this,
            charnum);
    }
    public org.w3c.dom.svg.SVGRect getExtentOfChar(int charnum)
          throws org.w3c.dom.DOMException {
        return org.apache.batik.dom.svg.SVGTextContentSupport.
          getExtentOfChar(
            this,
            charnum);
    }
    public float getRotationOfChar(int charnum)
          throws org.w3c.dom.DOMException {
        return org.apache.batik.dom.svg.SVGTextContentSupport.
          getRotationOfChar(
            this,
            charnum);
    }
    public int getCharNumAtPosition(org.w3c.dom.svg.SVGPoint point) {
        return org.apache.batik.dom.svg.SVGTextContentSupport.
          getCharNumAtPosition(
            this,
            point.
              getX(
                ),
            point.
              getY(
                ));
    }
    public void selectSubString(int charnum,
                                int nchars)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.svg.SVGTextContentSupport.
          selectSubString(
            this,
            charnum,
            nchars);
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public java.lang.String getXMLlang() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLLang(
            this);
    }
    public void setXMLlang(java.lang.String lang) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_LANG_QNAME,
          lang);
    }
    public java.lang.String getXMLspace() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            this);
    }
    public void setXMLspace(java.lang.String space) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_SPACE_QNAME,
          space);
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVbe3QcVRm/u2mTNE2b9JG29P1IC21hl8pLDAIhTdvApslJ" +
       "0qKpsp3M3iTTzs5MZ+6m22LlcY6Wg4IPKqJCPWpRwfJSOYgeoRxFeSg91Adv" +
       "EPiDR0Hp8dEqCn7fvXd2Zmd3JqzJOfacuTuZe7879/t97zu3B98mEx2bLLUU" +
       "I6Mk2C6LOoluvO9WbIdm2nTFcfrgaVq99uUbrjj+u0lXxUl1P5k6rDidquLQ" +
       "dRrVM04/WaAZDlMMlTobKc0gRbdNHWqPKEwzjX7SpDkdWUvXVI11mhmKAzYr" +
       "dopMUxiztYEcox1yAkYWpfhqknw1ydbggJYUqVdNa5dHMLeIoM3Xh2Oz3vsc" +
       "RhpT25QRJZljmp5MaQ5rydtktWXqu4Z0kyVoniW26WdJIC5OnVUCw9K7G/7x" +
       "7heHGzkMMxTDMBln0emhjqmP0EyKNHhP23WadXaQT5OqFJnsG8xIc8p9aRJe" +
       "moSXuvx6o2D1U6iRy7aZnB3mzlRtqbggRpYUT2IptpKV03TzNcMMtUzyzomB" +
       "28UFbl1xB1j8yurkvq9e1vjDKtLQTxo0oxeXo8IiGLykHwCl2QFqO62ZDM30" +
       "k2kGCLyX2pqia7ultKc72pChsByogAsLPsxZ1Obv9LACSQJvdk5lpl1gb5Ar" +
       "lfxr4qCuDAGvszxeBYfr8DkwWKfBwuxBBXRPkkzYrhkZrkfFFAUemy+BAUBa" +
       "k6Vs2Cy8aoKhwAMyXaiIrhhDyV5QPmMIhk40QQVtrmshkyLWlqJuV4ZompE5" +
       "wXHdogtGTeJAIAkjTcFhfCaQ0tyAlHzyeXvjeddfbmww4iQGa85QVcf1Twai" +
       "hQGiHjpIbQp2IAjrV6VuVGb9/Jo4ITC4KTBYjLnvU8cuPHXhoUfEmHllxnQN" +
       "bKMqS6sHBqY+Ob9t5blVuIxay3Q0FH4R59zKumVPS94CTzOrMCN2JtzOQz2/" +
       "+viVt9OjcVLXQapVU89lQY+mqWbW0nRqr6cGtRVGMx1kEjUybby/g9TAfUoz" +
       "qHjaNTjoUNZBJuj8UbXJ/waIBmEKhKgO7jVj0HTvLYUN8/u8RQhphIs0wbWS" +
       "iH/8l5EdyWEzS5OKqhiaYSa7bRP5R4Fyn0MduM9Ar2UmB0D/t5+2JnFO0jFz" +
       "Nihk0rSHkgpoxTAVncmMmU06I6BYm9d3dfaBQXG7Mhh6CvhJoOpZ/4+X5hGJ" +
       "GTtjMRDS/KCL0MG6Nph6htppdV/uovZjd6YfF+qHJiMxZOR0eHNCvDnB35yA" +
       "NyfgzYmQN5NYjL9wJq5AaATIczt4BnDN9St7P3nx1muWVoEqWjsngDDiMHRF" +
       "Sahq81yI6/fT6sEne44f/m3d7XESBy8zAKHKixfNRfFChDvbVGkGHFZY5HC9" +
       "ZzI8VpRdBzl0086rNl9xOl+HPwTghBPBeyF5Nzruwiuag6Zfbt6Gva//464b" +
       "95ieEyiKKW4oLKFE37I0KN4g82l11WLl3vTP9zTHyQRwWOCkmQJGBf5vYfAd" +
       "RT6mxfXXyEstMDxo2llFxy7XydaxYdvc6T3hejeN388EEU9Fo1sO16XSCvkv" +
       "9s6ysJ0t9BR1JsAFjwcf7bVuefqJN87gcLuho8EX83spa/G5K5xsOndM0zwV" +
       "7LMphXEv3NR9w1fe3ruF6x+MWFbuhc3YtoGbAhECzJ95ZMczL7144Pfxgs7G" +
       "GJlk2SYD86WZfIFP7CJTIvhEVfeWBB5PhxlQcZo3GaCY2qCmDOgU7eTfDcvX" +
       "3PvW9Y1CFXR44mrSqaNP4D0/6SJy5eOXHV/Ip4mpGHE92Lxhwo3P8GZutW1l" +
       "F64jf9WRBV/7tXILBARwwo62m3K/SjgMhMvtTM5/krdnBPrOxqbZ8et/sYn5" +
       "MqO0+sXfvzNl8zsPHOOrLU6t/OLuVKwWoWHYLM/D9LODvmaD4gzDuDMPbfxE" +
       "o37oXZixH2ZUwZM6XTa4vHyRcsjRE2uefegXs7Y+WUXi60idbiqZdQq3MzIJ" +
       "FJw6w+At89YFFwrh7qx1A0yelDCPeC4qL6n2rMU4trt/MvvH531v/4tcr/gM" +
       "C0pNJi1VKV3eZLBdgc2qUi0MIw3IKy7dMP49B5JpvmpMlBIiUXI7lpcNBK0D" +
       "4I0ApbWmmkPvz9fVHqESl2BzIe86B5tWYT8f+WCw4oMLBMU8/gwrncUl4YOX" +
       "MJ7ne+u5b7z64PHv1IgEaGW4uw/QzflXlz5w9SsnShSSO/oyyVmAvj958Oa5" +
       "becf5fSex0XqZfnSkAwxyaP90O3Zv8eXVj8cJzX9pFGV5cJmRc+hH+uHFNlx" +
       "awgoKYr6i9Ndkdu1FCLK/KC397026Ou9VADucTTeTwm4d8yvyHlwJaXCJYO6" +
       "GiP8ZrNQV96uxOZUoXp4exoj1Q4vSgL+dGbExIzMyGf1PlvRWIfBw1JBOqCw" +
       "p5QoLLfFtWZuQIdqMkPzUNWiv/RMiWvkpaNpZHdhhfPwaTVcbXKFF4SwrpRn" +
       "vYqzjk0/A+Q1Q9ED7M91Jy0zOSMzU+0b1/dtSLeuvXhTb196c2tqU3tv0CKw" +
       "OO/NgZ1yry5KgvtnvPGjR7fWPCMsorns8ECl8crlj3/bfP5o3K0iypGIkZc4" +
       "nYd/uuG1NA/YtZin9bmq48vAWu0hX7bQaKEfXx5umr7F7//usieu2L/sZe7V" +
       "azUHFBgmK1Ng+WjeOfjS0SNTFtzJk58JuCa5nuLKtLTwLKon+VIbrHy0s0SP" +
       "FROJgtAXy1UDO8QCQPkt0EpNxWdUqsD78C8G13t4oejxAf6CfbfJImpxoYqy" +
       "IFev1qkxxIadSB/XbWtZyJNGpFiTe6a/tP3m1+8QYg06tMBges2+a99PXL9P" +
       "pCWiJF9WUhX7aURZLkSMzQiKeUnUWzjFutfu2vOz7+/ZK1Y1vbjAbDdy2Tv+" +
       "+J/fJG7606NlKpYqkCH+YUg5lQlyMzy5temmQdELuH2ibtHMRGEDBDrzJYJF" +
       "LoJhp5OriufDzzlyvOq5L8+pLy1YcLaFIeXIqnDZBV/w66vfnNt3/vDWCiqR" +
       "RQHsg1Pe1nnw0fUr1C/H+e6JCBkluy7FRC3FgaLOpixnG31F4WKpxX+M8gYQ" +
       "w9scHzESkTt8IaLvS9h8DryoigIV8o8Yvk+mEqSMYGcFfZtQ/uo1t/zzis8+" +
       "3QUupIPU5gxtR452ZIp5r3FyAz5n520LeUhIM0Bjhlp5lWX5UjkefwY+ePzh" +
       "aeJH4dogQ8SGkPjzjchMMYyakZNABakNYQm39/hORA/dkdNsmnHN5bTo/YFW" +
       "Q8uie7rINHWqGAFWb66QVZRTp1xsZwirByJZDaNmYCvAa0o4UMnbh0J5c9Ne" +
       "4NHlUJAGGLy1QgbPhKtHLrEnhME7IhkMo2akXkSH1sy2nMNcFtd8MPGhy8U4" +
       "I8trH4d3RnCYj0j4cozUKhJFL+fh/xpIYMPOx4Yv9ScYShaE7anyMHLg6n37" +
       "M123rolLq/80FO7MtE7T6QjVfVOJafcWy+J0uIbkMoaCsvBQCBNEGGmEU/pl" +
       "RN+vsHmQkXmaAaES4xJt1fUUBM3C1xSHE+6SYRZ/9jAyYcTUMp64DlVebgWw" +
       "qceu1XCZkkEzApsSR89IjWVrI6BTgUR3csSMEbD8IaLvKWyeYGSOB1kxXtj/" +
       "iIfN4TFjswC7VsH1LcnJt0bRm+uKQaiLII1g9OWIvlexeZ6RKUOU9ZV4uCVo" +
       "/jvPUP1WX+zQPHheGDM8S7FrDVy3SR5vqxyeMNIICP4S0XcMmzcZaQB4UmX8" +
       "44oIgHxO0UPp6JhRQvdHFsF1j2T1nspRCiONQOI/EX3vY3MC6h1AaWMOPxV2" +
       "DbYNQ87qhBWPgcLhrlnHd/yyZvda1xFvE04K208FMzD886t5D9F/jhnRadi1" +
       "Aq77JSz3V45oGGk4arH6iL6p2NQw0gSIYjEH7ihTbJ6xmM+RB5z6xEHdVNgo" +
       "wMVqxwe4ZXA9JLl/qHLgwkgD4MQLqUFMNBymBYFR/rIarHOO3zrXdnW251Vq" +
       "oT1y4kXYwKjpgDEopajQC2larNFD6qQxI8WTF/T8j0l2H6scqTDS8hh4IK0O" +
       "H7CYD8AdptgKRmYhEEyxmfuJVlpxOTSlr+s2NXlIgQN18vgAdQpcRyS3RyoH" +
       "Kox0NKDOHQ2oFmzOZGQmANVuZIphwr6kB8VZY4ZiBnZhTHxW8vNs5VCEkY4G" +
       "RXCLvgSK9dhcKAJjex6/7xYry+wyytKD37MLAP0PO/vl3A8C9Irk8pXKAQoj" +
       "HQ2g3tEA2oTNRkamAUA9ct/FUxSfc+kan4wA3fCbkpk3K8chjDSczSRnMx0R" +
       "xBRs+oW5IOOQGrQWfAuH0kNhy5hRwAqBfBiuv0pW/lo5CmGkHygYbR9NJbLY" +
       "DILNOBQ/9xViDhJ4dUZsaMxQLMSuj8D1nuTnvcqhCCONkPfOiD7MUGI2I/Ol" +
       "v4jcNFoakVXLnSIPLmfMcE3Hrvkgqhoxg/itCK5Q0ghIPhPRtxebKxmpA7g+" +
       "1pnCrWgcts5j+6rxMZiTYc1T5dqnVs52GGmoKZB1nL8vRfB+AzafB96dIt59" +
       "FnLd+IgcyvFYk2SgqXLew0gjWLslou+b2NzEyGQhcsdSxHcAn8y/Nj4yXwmL" +
       "ni8XP79yvsNIR5P5bRHM/wCbA8C8U8y8T+ij7pWOyvxJ2HUqrGmF5GBF5cyH" +
       "kUbwdm9E333Y3M3IDMwSpBdcR8U5WtcbLijjDWWxojm+hOqe8QEoAdwlJJeJ" +
       "ygEKI40A4RcRfQ9j84AohF2AeL7pyG2V2P0eAg+ODwJQp8XOlmycXTkCYaQR" +
       "XB6O6HsSm8dEItm7y2E0mwKPmFOGaID7x8en4lgESz9fsnB+5dyHkY7mHZ6L" +
       "gOAFbP7ISP2w4hQLP2ITpGbAlylEbIM8NWbYlmDXuTB1u+S9fRTYSj8HhJJG" +
       "oPJWRN+fsXkNanbc1g0cgCkcavmkB8Lr/8MxKyjyQs744vG2OSX/50Cck1fv" +
       "3N9QO3v/pqfEUQv3LHt9itQO5nTdf6LId19t2XRQ4zjWi/NF/Lto7O9yW6Lc" +
       "JypGqqDlavI3MfoE1CLlRsNIaP0j32WkMTiSkYn81z/uPUhTvHGMVIsb35B4" +
       "DGaHIXgbt1yfvjrqu1ov26WjjCSaebGfVfiq5QqNNI0mNN+HsGVFpwb4fxtx" +
       "92Rz4j+OpNW79l+88fJjZ98qTtKqurJ7N84yOUVqxKFePimeElgSOps7V/WG" +
       "le9OvXvScndHd5pYsGcI8zxtxZNLMQuVZm7gjKnTXDhq+syB8x747TXVR+Ik" +
       "toXEFAiZW0pPseWtnE0WbUmV+0K/WbH58deWule3Hj7xbGw6P1hJxDf9hVEU" +
       "afWGB57rHrSsr8fJpA4yUcPDYfyI3dpdRg9VR+yiD/7VA2bOKBwZmooarmC0" +
       "5shIQKcUnuJJbKh4Sk/JlJ5Or9PNndS+CGfHaaYEzlXkLMvfy5G9UfhERBrU" +
       "MJ3qtCx5TGjCCY68ZaE1x5u4V/wvpWhllxs2AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5y95W37v1/7vBaayoeCL+C2n6s+g537uXvJN39zUP+LCvPYD6YWzFXB2j+qW" +
       "P+n8+blHrv335wrXzQq3KTtPeiTZcc4wM+A9hgfuNfC2T+Sf9AS3bs/Th1x/" +
       "32kePnbb0yx8NEuC67x0fn3jKeLNXY/CG0CAdrYDnTa7vcLmoru1vE38WB69" +
       "emtF+eWTUeHacOOv75juh+CzB8IP8pA3mCdsHZs7yJ139dChe+WDSfzO1LEH" +
       "gWRFtLuZPA41BezwyQvscDMkG14s2xntqlqqqYOc1Y5GyMbQ+BcyNPpQDK/K" +
       "U68FgdyJ4c2XEMPs4mK4aiOGPBIioAXLleyNoMWo8HK22W0PqPNEgxmKg/Mj" +
       "gh02RWDJj1/akjfcuvWMn/3FR3/3J5599L9v6Ol6KwT6JgLjIq76sTrffu6r" +
       "3/zSzfd/ajOLXy1L4Vbzp9c4Fy5hTqxMNv2/6VBCL88Fcm8+s+0ktLfV5/kL" +
       "9fn6h5axFFrLGEx/T/pASZby0NY8HtpI5qEtzbz1bQ9xfKN5vktwTfGhNz7k" +
       "aqtdzjslR37XW/f399/29FO+v+nImw+ZYW87v24VmEfKgW70S5gosM5tL/K0" +
       "tx/o5Vpbc43IPJtTeoHlAI8h2a1loHfd8dXFz/3pL23XKacJ5FRh7f3P/J0f" +
       "7n/gmXPHVoePXrBAO15nu0LcdPDmTS/zievhs+6yqdH6+qff9a/+2bvet+3V" +
       "HSfXOk2wlP+lP/irL+5/9E9++yLO81XACPIfsp9ean6482h+IG3P1fKRdpC3" +
       "daEtb/9wLQ4y0wt0FRRec2kZcxujOyLPz7/3G/cO3mS+4yX4zg+ektHpJj/B" +
       "Pffb7SeUD50rXHVIpRcs1E9Wevokgd4YaFEcuIMTNHr/1vw28ru47e3ll9bW" +
       "5M6YIt99Rt578+jHAasoufC3ujqj+E+mhVM0+NYXT4MbJ+SNIFC7QU5dggbf" +
       "fwbcJw9G2CuBqrUADPj8yctmkShoy9gKNPXAfF539tKNcC0nJ5S659ma5J7C" +
       "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" +
       "G0qWtKbAGTaWE1YDxjgfs6HtxUW53F03");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "u+VKD+nCmzcwPnQGxGfy6O8CiOEJiMfM+gOXq0Cwctu7awfxriuvwGfPyPvH" +
       "efQzUeFlWwWGvqRopzT4s5erwadAT+/bwbvvR6TBT56B8bk8+jjAGJ7EeEyF" +
       "v3gZGF+ZJ74W9OaJHcYnrrwKf+2MvF/Po89EhTvz2XVHRC1te0b7gJDuvwgh" +
       "7RxwKzzmb/zK5coB5O/t7+Swf+Xl8O/OyPtcHv2b7ULsQA4bryvcraf3/uUR" +
       "0OcvFyhYYuxVd0CrVx7ofzoj70t59IWtOyVmYaQ5LCClWDK0UyC/eLle9IOg" +
       "v2/agXzTj2jk/rczkH4lj/4wKtxkSuEJVZ5eUl8nn55V/+gysD+cJ+Kgl80d" +
       "9uZLxf6CT0/3vnlG3rfy6H+BpWH+JO3Uea3DM1ijI6xff0mH/cC64xJntvPT" +
       "p/dc8B8S2/89UD717K3X3/3s8A+3B54O/pvgBrZwvR7b9vFjcMeur/UDTd8a" +
       "wg3bQ3Gbk0Z7/2e37r3Y2+9R4SoQbwbsd7elvwcc6ouVBiVBfLzkX0aF206X" +
       "jArXbL6Pl/srMJ8flYsK124vjhU5VwCtgyL55Z5/wKPFs17ZF6PMzrWzk2a6" +
       "fS5yz3Eb2zztuuOF1HVse+DRE0d6Nn8DcnD8Jt7+Ech55dPPMt13fqf68e3B" +
       "bMWW1rmzWrieLVy3PSO+aTQ/wvPwJVs7aOta6qnv3/LLNzx+sOFwy7bDR/Z+" +
       "rG8PXvwIdNPxo82h5fWv3/3P3/BPn/3K5lX9/w+ixb9mn0UAAA==");
}
