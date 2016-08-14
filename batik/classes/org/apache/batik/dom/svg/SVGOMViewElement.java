package org.apache.batik.dom.svg;
public class SVGOMViewElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGViewElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      2);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                                    SVG_MAGNIFY_VALUE);
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMViewElement() { super(
                                     ); }
    public SVGOMViewElement(java.lang.String prefix,
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
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_VIEW_TAG;
    }
    public org.w3c.dom.svg.SVGStringList getViewTarget() {
        throw new java.lang.UnsupportedOperationException(
          "SVGViewElement.getViewTarget is not implemented");
    }
    public short getZoomAndPan() { return org.apache.batik.dom.svg.SVGZoomAndPanSupport.
                                     getZoomAndPan(
                                       this);
    }
    public void setZoomAndPan(short val) {
        org.apache.batik.dom.svg.SVGZoomAndPanSupport.
          setZoomAndPan(
            this,
            val);
    }
    public org.w3c.dom.svg.SVGAnimatedRect getViewBox() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFitToViewBox.getViewBox is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMViewElement(
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
      ("H4sIAAAAAAAAALVaC2wcxRmeO79f8SPO07HzctI8yF3CozR1eJwdmzg9P4iN" +
       "q9qAs96bszfe293sztkXU7eAqAiVeKUhSRFYRQoKjYCgCkorHkqVtjxbiUdL" +
       "aQVUpFJ5lJaoKlRNKf3/2d3bvb27Na5qSztez8z/z/zffPP//8z64Y9IkaGT" +
       "JqqwEDugUSPUrrBeQTdorE0WDKMf6obFowXC369/r3t7kBQPkgVjgtElCgbt" +
       "kKgcMwZJo6QYTFBEanRTGkOJXp0aVJ8QmKQqg2SRZHQmNFkSJdalxih2GBD0" +
       "KKkVGNOlkSSjnZYCRhqjMJMwn0k44m1uiZJKUdUOON2Xurq3uVqwZ8IZy2Ck" +
       "JrpPmBDCSSbJ4ahksJaUTjZrqnxgVFZZiKZYaJ98iQXB7uglWRCseaz6k/N3" +
       "jdVwCBYKiqIybp6xhxqqPEFjUVLt1LbLNGHsJ98iBVFS4erMSHPUHjQMg4Zh" +
       "UNtapxfMvooqyUSbys1htqZiTcQJMbI6U4km6ELCUtPL5wwaSpllOxcGa1el" +
       "rTWtzDLxns3hw0evr/lRAakeJNWS0ofTEWESDAYZBEBpYoTqRiQWo7FBUqvA" +
       "YvdRXRJkacpa6TpDGlUEloTlt2HByqRGdT6mgxWsI9imJ0Wm6mnz4pxQ1l9F" +
       "cVkYBVsXO7aaFnZgPRhYLsHE9LgAvLNECsclJcbISq9E2sbmr0EHEC1JUDam" +
       "pocqVASoIHUmRWRBGQ33AfWUUehapAIBdUaW51WKWGuCOC6M0mFkpKdfr9kE" +
       "vco4ECjCyCJvN64JVmm5Z5Vc6/NR9447blB2KUESgDnHqCjj/CtAqMkjtIfG" +
       "qU5hH5iClZuiR4TFzxwMEgKdF3k6m32e/Oa5Ky9oOv282achR5+ekX1UZMPi" +
       "8ZEFr6xo27i9AKdRqqmGhIufYTnfZb1WS0tKAw+zOK0RG0N24+k9v/zGjSfp" +
       "h0FS3kmKRVVOJoBHtaKa0CSZ6ldRheoCo7FOUkaVWBtv7yQl8B6VFGrW9sTj" +
       "BmWdpFDmVcUq/xsgioMKhKgc3iUlrtrvmsDG+HtKI4SUwEMa4dlAzJ/1WDBy" +
       "bXhMTdCwIAqKpKjhXl1F+40weJwRwHYsPAKsHw8balIHCoZVfTQsAA/GqNUQ" +
       "UxNhYwKoNHBVT9eARCfRKaCfRZZp86w/hfYtnAwEAPoV3o0vw57Zpcoxqg+L" +
       "h5Ot7eceHX7JJBVuBAsZRjbCkCFzyBAfMgRDhmDIkHdIEgjwkepxaHOBYXnG" +
       "YaODp63c2Hfd7r0H1xQAs7TJQsA2CF3XZEScNscb2C58WDxVVzW1+u1tZ4Kk" +
       "MErqBJElBRkDSEQfBdckjlu7t3IEYpETEla5QgLGMl0VaQw8Ur7QYGkpVSeo" +
       "jvWM1Ls02AELt2Y4f7jIOX9y+tjkTQPf3hokwcwogEMWgQND8V703Wkf3ezd" +
       "/bn0Vt/63ienjkyrjh/ICCt2NMySRBvWeLnghWdY3LRKeGL4melmDnsZ+Gkm" +
       "wL4CF9jkHSPDzbTYLhttKQWD46qeEGRssjEuZ2O6OunUcJLW8vd6oMUC3HdN" +
       "8AxZG5H/xtbFGpZLTFIjzzxW8JBwWZ92/+9+/f5FHG47elS7wn4fZS0uj4XK" +
       "6rhvqnVo269TCv3eOtb7vXs+unWIcxZ6rM01YDOWbeCpYAkB5u88v//Nd94+" +
       "/nowzfMAI2WarjLY1jSWStuJTaTKx04YcL0zJXB6MmhA4jRfowBFpbgkjMgU" +
       "99a/q9dte+Ivd9SYVJChxmbSBbMrcOqXtZIbX7r+0yauJiBi0HVgc7qZnnyh" +
       "ozmi68IBnEfqplcbv/+ccD/EBPDDhjRFuWslHAbC1+0Sbv9WXl7sabsUi3WG" +
       "m/+ZW8yVHA2Ld73+cdXAx8+e47PNzK7cy90laC0mw7BYnwL1S7z+aZdgjEG/" +
       "i093X1sjnz4PGgdBowj+1ujRwT+mMshh9S4q+f3Pzize+0oBCXaQclkVYh0C" +
       "32ekDAhOjTFwrSntiivNxZ0shaKGm0qyjM+qQIBX5l669oTGONhTP1ny+I4T" +
       "M29zomlcRWOaXBWopgEe0SKXmHsTYfklXm7CYotN2GItOQKpuoet5T4KPesa" +
       "tFw8/r0U8m5uDOZUITOnshvW5YwukRHwWoDmTlVMYmThs+30oU4PFq286StY" +
       "tJkzb/kf4ceKiGY2NPDKQoygGcGKn3scf3nytUt/c+LuI5Nm5rQxf5DwyC39" +
       "V488cvO7/8yiMQ8PObI6j/xg+OH7lrdd/iGXd/w0SjensqM+xDpH9sKTiX8E" +
       "1xT/IkhKBkmNaJ0zBgQ5id5vEHJrwz58wFkkoz0zTzaTwpZ0HFrhjRGuYb0R" +
       "wsk24B1743uVJygswnXZAc8Wi35bvHwOEP4ylJvSQXwNAa8Nfprx8LreRzEj" +
       "C1MJuV8XJNap8GCWXh2g74Ys+vINu1OF7QPH0BhNwVEYvayz3Tg/r52Nn9ek" +
       "Z4i7mLTDE7FmGMljejy36QXcdCzgXFIUlxRB9pi/3Ec55EGu8zlETDznUd22" +
       "f0ve5DCSQ8oDwugXB4EnBZfBc7U1z6vzgLDfBAGLzdmhNp80I8tgn1IdsMHD" +
       "KU+199D9SUmnsdlN5XlwRJESeERpVVWZCorHVH2OprbBM2BNdiCPqVO+puaT" +
       "Bj5r5r0MjRga7No9SGjbyO1fzMjebA0eg2/wMTjlTLw9PXH+U0ysc5f92xtg" +
       "TGccsKfbhNOdvEh0z9J1IMFg35jvJM1vAY7ffHgm1vPgNtNr12WeTtuVZOKR" +
       "3372cujYH1/IcTAqY6q2RaYTVHZNrRKHzIgTXfySwXG6by04dPanzaOtcznP" +
       "YF3TLCcW/HslGLEpf+jxTuW5mz9Y3n/52N45HE1WeuD0qvxh18MvXLVePBTk" +
       "NypmNMi6ickUasmMAeU6ZUld6c+IBGszt8dWeMYtnox7t4crs8mzN/KJ+iQY" +
       "R3zajmFxNyMNUtrVRWQ5KsH+sJ2gYfjmBL26lADRCeumJjxd9874fe89YrLS" +
       "mwB4OtODh7/7eeiOwyZDzbuvtVnXT24Z8/6LT73GBOdz+AnA8x980C6swN8Q" +
       "5tusS5hV6VsYTcONtdpvWnyIjj+fmn7qoelbgxZOtzFSOKFKMcdLHPp/pGm8" +
       "/vb0Kldi22Z4DGuVDR+C5Eh9SzRdmgAzPUGywkejDzce9Wl7DIsTjCx1eJNJ" +
       "Gmy/30HroXlAqw7b8LQ9bdk2Pct2as+EpdxH1Mf0p3zansHix4xUjlIWVUVB" +
       "7racw24HiifnAYpl2IZR5xbLnlvmDkU+UR9zn/dpexGLM4xUARQY1/oFHd7s" +
       "6NeYI/qZpys8Hzpg/XwewKq1eXOnZfGdcwcrn6gPIG/4tL2JxasmWIOqmogo" +
       "sV5BybxkxEDbl4TTpceJXti7VzzY3Psn0+MuyyFg9lv0UPj2gTf2vcwjZimG" +
       "6HSccoVnCOWuq60aLGZMYO91vf8A0nFjTNVZ2pqAld3opD5zBubgO2+rfvqu" +
       "uoIOyBw6SWlSkfYnaWcsM3qWGMkR15Scjw1OLLXmgy6ekcAmzTrncqq8Ng9U" +
       "4XcReKt+1Frvo3OnSj5RDx0sAPHPt7jWv/rw5WMs3ge+GG6+eHzuB/MACD/R" +
       "rYPnAcuqB+YOSD5RH3vP+7R9hsUnjJRbjqZVTdleZmUOL2OfA/bgp4o0Vp/O" +
       "A1absA31nbQMPjl3rPKJ5scjUO7TVolFESOLAascByEbt5APbvnEEMZA8TzA" +
       "iJ6afBWexy0sHp87jPlEfaBa5tPWgEU9IysAxvbZDt9rfMC0TtwOgIvmAcC1" +
       "NoBPWyg8PQuAOY4d+UR9QNrg04Zpa2AtI0sAwHy3LQkHleZ5QGUhtuH10RnL" +
       "tDNzRyWfqI/lPh8RAvgRIbAV0niFTnZD6LQZVONmULqBI7NtHpBZjW3b4XnR" +
       "Mu/FuSOTT9TH+p0+bR1YXAHHDeCL9z4zfUc54sBy5f/lDh2Q934nxq8bS7P+" +
       "DcX81wnx0Znq0iUz17zBr0fS/95QCdlWPCnL7rti13uxptO4xCGtNG+ONW5y" +
       "N1ib70aLkQIocd6BLrP31YzU5+oNPaF09+y3+OTuCdkc/+3u93WIqE4/RorN" +
       "F3eXQdAOXfB1SLPJmvurSPoazr7eMu/BGtxLwAPxrA4wLeL+pom3Evx/iOzE" +
       "M2n+F9GweGpmd/cN5778oPlNVZSFqSnUUgHppvl518p23ZcCXm22ruJdG88v" +
       "eKxsnX0pUGtO2NkNDa60JALJnIZ0We752mg0pz86vnl8x7O/Olj8apAEhkhA" +
       "YGThUPaXiZSW1EnjUDQ7rR4QdP4ZtGXjvQcuvyD+tz/w72nETMNX5O8/LL5+" +
       "4rrXDi093hQkFZ2kSMLLfv7JZOcBBfKiCX2QVElGewqmCFrAJ2fk7AuQ2QKe" +
       "1TguFpxV6Vr8Ig9hL/seJ/v/GMpldZLqrWpSiaEayPornBpzZTw3bElN8wg4" +
       "Na6Dy7tYzKRwNYCkw9EuTbPvhUo3aHyDn82Vep/lxOaZ9Fl8U/8Lr0C9LF8o" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nFDgazdBgfuOOPyZPQU+885T4OvnlJX3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("MH94SAHJ913cK7ZE19Pj26K1H55C/Uc3gboMgigC2z6/R/35dwb1hZMKf1xW" +
       "+PY50P9rkXwLQI9OQz+jvX9yEyjLa+VnwfNze5Q/987z9n+eU/bdIvlvMXTn" +
       "XroJPzsS7SeuI9pHl5hcEe93TIA/vwkCPF9kFu1e2xPgtXecABcunVN2R5Ec" +
       "xNBDgADXuZo9IsaVc4hxo2YFbS7cchO0KXQe+l7wfHlPmy+/87R58Jyyh4vk" +
       "cgy9D9CGerML/afOodD+Fv+EKvfdBFWePqLKr++p8utvlypv6uRcePqcsmeL" +
       "5PEYehhQ5UYxGKsTqE/cBNQHisxHwfOVPdSvvPNQzwnIu1AE5F14HjhFnpYy" +
       "vqod8fryaV4fF5RwKzcB98kisw2e393D/d13Hu6L55R9f5G0gNsGOHs21Og4" +
       "fGhxgrX9tuLUANnORh8XcZSPXPPPDYcB+covvXrv7Q+/Kvy7MgD3OGj+Dhq6" +
       "XU8c53To1qn3i0Go6WZJhTsOA7mCEloXoLpRfEoM3QLSYsIXqMPagxh69/Vq" +
       "g5ogPV2T3gvD6ZrADyi/T9djwRJzUi+GLh6+nK7Cgd5BleJ1FhxJ2vUjDI+D" +
       "ao42iYe7yUdOi1W5Mt3/Zhw6bnI6uLfYG5b/mXK0j0sO/zflJeVLrw6ZH/5O" +
       "8+cPg4sVR87zopfbaejSYZxz2WmxF3zyhr0d9XWx/9x37/nlO5492rfeczjh" +
       "ExE/Nbcnrh/GS7lBXAbe5r/28Jc//Pdf/XoZPvP/APhzcvcyNAAA");
}
