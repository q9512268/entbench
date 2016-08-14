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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VjgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C/DrWHmf/3ffy+7efbDssuzj7pNdTK4sW7ZslkdkWZJl" +
       "PSxLfhO46GnJ1st6WRbZBphJIM2UUrqkJE12mimkhdlAyDRp0k7aZdpCEmja" +
       "MGmS0gYo7ZQEygwMTeiEBnpk+/+89/53N/dSz5xj+bx0ft/3nd/5jo6On/9m" +
       "4bowKBR9z17PbC86r6fR+bldPR+tfT0832GrghyEuobbchj2QdoF9ZFfPfuX" +
       "3/uAefuZwvXTwl2y63qRHFmeG4p66NmJrrGFs4ephK07YVS4nZ3LiQzFkWVD" +
       "rBVGT7OFVxypGhUeY/e7AIEuQKAL0KYLEHZYClS6VXdjB89ryG4ULgt/q7DH" +
       "Fq731bx7UeHh4434ciA7u2aEDQLQwo357yEAtamcBoVzB9i3mC8C/KEi9Ow/" +
       "ePvtv3ZN4ey0cNZypbw7KuhEBG4yLdzi6I6iByGmabo2Ldzh6rom6YEl21a2" +
       "6fe0cGdozVw5igP9QEh5Yuzrweaeh5K7Rc2xBbEaecEBPMPSbW3/13WGLc8A" +
       "1lcdYt0iJPN0APBmC3QsMGRV369y7cJytajw0MkaBxgfY0ABUPUGR49M7+BW" +
       "17oySCjcudWdLbszSIoCy52Botd5MbhLVLjvso3msvZldSHP9AtR4d6T5YRt" +
       "Fih100YQeZWocPfJYpuWgJbuO6GlI/r5Jv/G97/TbbtnNn3WdNXO+38jqPTg" +
       "iUqibuiB7qr6tuItr2N/Vn7Vb7/vTKEACt99ovC2zD//8W//6OsffOF3tmVe" +
       "c4kyXWWuq9EF9SPKbX9wP/5U45q8Gzf6Xmjlyj+GfGP+wi7n6dQHI+9VBy3m" +
       "mef3M18QPzN518f1b5wp3EwXrlc9O3aAHd2heo5v2XpA6a4eyJGu0YWbdFfD" +
       "N/l04QZwzVquvk3tGkaoR3ThWnuTdL23+Q1EZIAmchHdAK4t1/D2r305MjfX" +
       "qV8oFG4HoXA3CE8Vtp/Nd1RQIdNzdEhWZddyPUgIvBx/COlupADZmpACrH4B" +
       "hV4cABOEvGAGycAOTH2XoXkOFCbAlIZUl+uDIbQZSW6UMwX4Op8bm///5zZp" +
       "jvb21d4eUMT9J2nABiOo7dmaHlxQn42bxLc/ceFzZw6GxU5OUaEE7nx+e+fz" +
       "mzufB3c+D+58/jJ3LuztbW74yrwHW60DnS3A6Ae8eMtT0ts673jfI9cAc/NX" +
       "1wKBnwFFocvTM37IF/SGFVVgtIUXPrx69/AnSmcKZ47zbN5rkHRzXl3I2fGA" +
       "BR87Ob4u1e7Z9/7ZX37yZ5/xDkfaMeLeEcDFNfMB/MhJ+QaeqmuAEg+bf905" +
       "+dcv/PYzj50pXAtYATBhJAPLBSTz4Ml7HBvIT++TYo7lOgDY8AJHtvOsfSa7" +
       "OTIDb3WYslH8bZvrO4CMb8st+3EQRjtT33znuXf5efzKraHkSjuBYkO6b5L8" +
       "X/yT3//zykbc+/x89siMJ+nR00c4IW/s7Gb033FoA/1A10G5P/2w8Pc/9M33" +
       "vnVjAKDEo5e64WN5jAMuACoEYv7J31n+5y9/6SN/eObAaPaiwk1+4EVgxOha" +
       "eoAzzyrcegpOcMMnDrsEaMUGLeSG89jAdTzNMixZsfXcUP/v2cfhX/9f7799" +
       "awo2SNm3pNe/eAOH6a9uFt71ubd/98FNM3tqPq0diu2w2JYr7zpsGQsCeZ33" +
       "I333Fx74uc/KvwhYFzBdaGX6hrwKGzEUNnqDNvhft4nPn8iD8+ih8Kj9Hx9i" +
       "R9yPC+oH/vBbtw6/9a++ventcf/lqLo52X96a2F5dC4Fzd9zcrC35dAE5ZAX" +
       "+B+73X7he6DFKWhRBVQWdgPAOekx49iVvu6GL37637zqHX9wTeEMWbjZ9mSN" +
       "lDfjrHATMHA9NAFdpf5bfnSr3NWN+yyeFi4Cv0m47+IRcGFnGRcuPQLy+OE8" +
       "evxio7pc1RPiP7Ojtfz33cAz3KDMnYvzW+diP+PxSxIrpgByAaBbnhrnbLrp" +
       "15tP0XArjxqbrHIevWELvfqSpLQte+/m141AjU9dnojJ3Ek75LJ7/6prK+/5" +
       "6v+5yFQ2FHwJ3+RE/Sn0/C/ch7/5G5v6h1yY134wvXi2Ag7tYd3yx52/OPPI" +
       "9f/uTOGGaeF2dectD2U7zhlmCjzEcN+FBh71sfzj3t7WtXn6gOvvP8nDR257" +
       "koUPZ0lwnZfOr28+Qby5e1F4IwjQznagk2a3V9hc8FvL28SP5dFrt1aUXz4Z" +
       "Fa4PNz75jul+AD57IHw/D3mDecLWebkT33lQ5w5cKB9M4neljt0PZCui3c3k" +
       "caApYIdPXmSHmyHZ8mLFXtOupqe61s9Z7XCEbAyt+2KGRh+I4TV56vUg4Dsx" +
       "vOUyYpheWgzXbMSQR2IEtGC5sr0RtBQVXskSPNVvX8BanYHUvzDE2AEhAUt+" +
       "/PKWvOHWrff73C8/+vs/8dyj/21DTzdaIdA3Fswu4Y4fqfOt57/8jS/c+sAn" +
       "NrP4tYocbjV/ch1z8TLl2Opj0/9bDiT0ylwg9+Uz205Ce1t9XrhYn284t4zl" +
       "0FrGYPp70gdKstRzW/M4t5HMuS3NvPVt57hui7jAYxwhnXvTOVdf7XLeKTvK" +
       "M289f/78255+yvc3HXnLATPsbefXrQLzSN3XjXEZEwXWue1Fnvb2fb1cb+vu" +
       "LDJP5xQhsBzgMSS79Qr0zJ1fXvzCn/3Kdi1ykkBOFNbf9+zf/sH59z975sgK" +
       "8NGLFmFH62xXgZsO3rrpZT5xPXzaXTY1yK998pl/+U+fee+2V3ceX88QYLn+" +
       "K3/0158//+Gv/O4lnOdrgBHkPxQ/vdz8cNfh/IDbnqvnI20/b+tCW975g/U2" +
       "yEwv0lVQeN3lZcxtjO6QPD/7nq/f13+z+Y6X4Ts/dEJGJ5v8GPf871JPqB88" +
       "U7jmgEovWowfr/T0cQK9OdCjOHD7x2j0ga35beR3advbyy+trcmdMkW+65S8" +
       "9+TRjwNWUXPhb3V1SvGfTAsnaPCtL50GN07Im0Bo7wZ5+zI0+L5T4D65P8Je" +
       "DVStB2DA509XNotEUV/GVqBr++bzI6cv3TDXcnJCaXqercvuCVw//TJxVUDg" +
       "dri4y+D6ey8F1835Yyd2yx47IOXLAtl3lwCgfTjbqifQfPBlokFAEHdoxMug" +
       "+fmXguaWLQ9i2jwOo3088EtTTE4uOefvllRH4PzDF4WzJbg9sFC6rnwePV/K" +
       "f//jU2ZXazO7HqPwe+a2+tj+/DPUgxD047G5jW4mjBMdkl5yhwBb3XZIeazn" +
       "zp7+mf/xgc//3Ue/DPizU7guyd00QDpH/GY+zh9A/tTzH3rgFc9+5Wc2q0Ag" +
       "5uFPfwr9St7qx18erPtyWNJmxLByGHGbVZuu5cg2TSyO4PEisPYDXfwbo43u" +
       "/nAbCWls/8PCSmuMqfAYhjSULrJEMjLXMCTN5dFUFBSV0lo0RohN2BmxGtUP" +
       "phRRRmaCrowrHabciNBENyTgj5GrYnmGxFx55CGrVlX1lz6RoVSPafER2+P5" +
       "Acc2iVmNk0RfwrrRorygbWwRs2p5YCd9yChCEaqhOirWxmtj6DSiip4kGoRC" +
       "MAhQtRGVp1HJiSZVHoYprBM5TbGTkbOw2SY1x6qNYVWdpmu9LwcVWJonlSSj" +
       "kmVi+VQNZzvw0KXIoarP9Lnu+1OkU5InSoskunY2rzKl0iyd2N122eXAdTqf" +
       "uaKX2S2qNB8OJ3XecRymhSFLjXZKzASdlO3RsCS1FUwiVWbqswuu5JabcoQO" +
       "amKHl0tkAC2WY4gvjlflctY2593JuuTPEF8teet11ms4Gq3Cfpyt+woLNzVH" +
       "63C2TCN2K7bHEmbFEgyLTaJdgeFE16GiXh5Ouqs+S3JERpXHPLUcCUs1kzTa" +
       "quilFaVN/dW82tY6/YkX1vtDx8cNu+Uvid6UWy25OIJXvlMprXmFUYxqd7WK" +
       "ampNqg86nMKYYZNnw+mIQymZyFK7JlO4pJUQrkLWBlV4uhqpfWuKqna/Ua2o" +
       "xbDPy6I9C0QvNc2uiAw7XNNcYDPcdiR72a1UfJ6AhUVr0iJdYAr+0pJLhi0F" +
       "Klr21maIr8JkFbJCmMpwdzrX7XmzO+skmj21fR92larH2kI67NZKAVdvBbjX" +
       "GK90QjcwhOMdb8WNIxlTnH6HDrtySZYXxrBpzdeCoNTJ1gQvCQthGnQWhuxT" +
       "5goTJHYhEkNkPa02LdqdE63+KOIJAlcW/ZHpSuzIXtL60FG8DuEvPL5ML+nO" +
       "yMoWPYnr0CKKTdGVPZIH8MweZ0EdkotysVZMxVkJsXqUWqr2h6pRZVeUpfUo" +
       "a9D3eaXn12jMUqKlEg+H03q9YqkENVeJ0SwsJxnprxuqXndqYb3I8k7ERvwC" +
       "0ibWUiHphqCMS3G10hjVasvVaFEaMfIc0emxytVgheiPGt1JGLawoD6HranK" +
       "REIrqaGMFutVq0hKOt+riV3eGIbNWPL6/UFmL6d9fV2Hl0xp5ZiIZdUcEY0N" +
       "uFfr6ajdlXvquA9pQr/lDFvTTrvbboymUEvDeAzWaELiVaY+LdWmqLK2QzuC" +
       "XJbo0Ay8XmA1JBLbGcKv+aUaKVyJkSzGmzoOtxDLpX7RlcSJi7tgdplUm8MO" +
       "1O06k5EYERzlylxpQVYpfLT2liVnsKip6ybThJS4nSJtUmfkaQsvtUZmPNCs" +
       "EIx4Uw3nUZjYk1ZTtrjyjNJ4fNYb8sKgEknC1NX4ccssqYuxObHM0cJSKX7R" +
       "pdcGscYWRXXWofphi7amuChJGdWE110uxYOWE5UptmdkFNS3A0oJ5hGSsCGV" +
       "cmV5vJKwtEb6GkIotUTjTCoZdxrjdtmPBcU1ozTj09AyybI5Gk7FgZYMlobQ" +
       "E8rSvBQOFd/HzfWgulbjerLoaG28DBij5DCLlbEmUbnfcpd0RaCGblyrt+HJ" +
       "0krWY8wYuGyx2s0adVQ14vYQdbkeO+5x3VEvGrVUu11iWm5rrAklXBrUAgPw" +
       "laHrxUyf1KZuG/Prcz20rLUlmsXaTML6pjOUKuOlWJ9AjJJWPASlk6be4kgb" +
       "q4RIEMwobFT2GzqM1E0Wy7C6onlTUVWXZJGneCdW6g2kzy6jCGojVYsbSkNu" +
       "yqtCuQwTaHGuDAIWT8d4ZFPdXrRaGRWiU5dDFqrMtUq12J0YiiYtosQ2Z3O2" +
       "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" +
       "D+rdNG4TlarcdYx67JVFcdx17EQe1YqNIlG3ZYwpOQEfUvbanvKW0GNcmpzz" +
       "ohLNJ+2BOaHtqUY0mrMmzISiZhSJVI25QOhgLNHr1WBoXWovbdwx4YkGj2IW" +
       "sXQjYijNqfkpPkpncwnnpxBptyvqOutyDbrea9jIQhyrM3wKxgQ7VNIFM58i" +
       "7TJRXGLkrALHZay2bncag+4QS6cUNWszekrCSb1vYRYXYaS1NMmx1saoaVYV" +
       "a7EAo+S42eJKwWgFjZCpgKZrl2DpVaXdsSfKYKgLzVGvEUxaSmKti+VoBVX6" +
       "dTZUyH7XKfEdvDyei+lgDukcxPfgamqbtQCv8+KcRNR6UhVoOi13hj12xtcy" +
       "pdWQJaKmugzRQ+bzAZ7StU7cEeVo3u5hK9+UZzbJkjW/pLBtodeTVFEvA+0v" +
       "w3ZHjOBJZ03DqSBlaz0wM4bjaWwskHWi2Qmq2KCNxh2MqUByK1021ktIjCFV" +
       "aBXFgbwkumqRjkZtscXPit6siDPtiVjvNU0FHVGVsBdM6irWEVSPJTxszIRq" +
       "PGd7JcashkNkUilznqIy1QrH0rg3ophMy8Ylks2kIhGwukwvVadFsev+uuaR" +
       "lYEx61pGVYDVqkZRiypYcTGYoY2tdTwd9aq9ljbzsbi5QpeBMG7VlrNWl1um" +
       "LRSKl1WhNVyHYKEArCJzZlWVk1OqOYl1HG+jdYxtjnwbnxByqhh1XZ2Xh8CW" +
       "6FHf7WiQyyDA2weey5Twqut2U+DcyZwul7CyPFe7BkOsR/pCWfojnqYpaFHp" +
       "VPx4SKc8RYUoAk/TlK53zMmsnval2bQ3I01pCOmiS66E4ao77BHjrM3SaZGs" +
       "DTO2osQjxOyQRYbTKlLmpN2JQrYpS+5BhCbzNYieUGOmPnaWq1a3u1yj1BIR" +
       "OrRqDLFql6Icot9cC0s2ZK1GY+6Tguyqcz7Ua7RAtGKrvcAgFxliVNaOF9VJ" +
       "5gaiD1kxzjV7pZnVQ73YK6arUSc1/SbWhKaZRY4gY6LwWAuZC8NB0GVnk9he" +
       "+LFt9zhRNJfLHiX11MqqhnnlZGKQIJnz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "RQAA");
}
