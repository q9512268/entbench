package org.apache.batik.bridge;
public class UserAgentAdapter implements org.apache.batik.bridge.UserAgent {
    protected java.util.Set FEATURES = new java.util.HashSet();
    protected java.util.Set extensions = new java.util.HashSet();
    protected org.apache.batik.bridge.BridgeContext ctx;
    public void setBridgeContext(org.apache.batik.bridge.BridgeContext ctx) {
        this.
          ctx =
          ctx;
    }
    public void addStdFeatures() { org.apache.batik.util.SVGFeatureStrings.
                                     addSupportedFeatureStrings(
                                       FEATURES); }
    public java.awt.geom.Dimension2D getViewportSize() { return new java.awt.Dimension(
                                                           1,
                                                           1); }
    public void displayMessage(java.lang.String message) {  }
    public void displayError(java.lang.String message) { displayMessage(
                                                           message);
    }
    public void displayError(java.lang.Exception e) { displayError(
                                                        e.
                                                          getMessage(
                                                            )); }
    public void showAlert(java.lang.String message) {  }
    public java.lang.String showPrompt(java.lang.String message) {
        return null;
    }
    public java.lang.String showPrompt(java.lang.String message, java.lang.String defaultValue) {
        return null;
    }
    public boolean showConfirm(java.lang.String message) {
        return false;
    }
    public float getPixelUnitToMillimeter() { return 0.26458332F;
    }
    public float getPixelToMM() { return getPixelUnitToMillimeter(
                                           ); }
    public java.lang.String getDefaultFontFamily() { return "Arial, Helvetica, sans-serif";
    }
    public float getMediumFontSize() { return 9.0F *
                                         25.4F /
                                         (72.0F *
                                            getPixelUnitToMillimeter(
                                              ));
    }
    public float getLighterFontWeight(float f) { return getStandardLighterFontWeight(
                                                          f);
    }
    public float getBolderFontWeight(float f) {
        return getStandardBolderFontWeight(
                 f);
    }
    public java.lang.String getLanguages() {
        return "en";
    }
    public java.lang.String getMedia() { return "all";
    }
    public java.lang.String getAlternateStyleSheet() {
        return null;
    }
    public java.lang.String getUserStyleSheetURI() {
        return null;
    }
    public java.lang.String getXMLParserClassName() {
        return org.apache.batik.util.XMLResourceDescriptor.
          getXMLParserClassName(
            );
    }
    public boolean isXMLParserValidating() {
        return false;
    }
    public org.apache.batik.gvt.event.EventDispatcher getEventDispatcher() {
        return null;
    }
    public void openLink(org.w3c.dom.svg.SVGAElement elt) {
        
    }
    public void setSVGCursor(java.awt.Cursor cursor) {
        
    }
    public void setTextSelection(org.apache.batik.gvt.text.Mark start,
                                 org.apache.batik.gvt.text.Mark end) {
        
    }
    public void deselectAll() {  }
    public void runThread(java.lang.Thread t) {
        
    }
    public java.awt.geom.AffineTransform getTransform() {
        return null;
    }
    public void setTransform(java.awt.geom.AffineTransform at) {
        
    }
    public java.awt.Point getClientAreaLocationOnScreen() {
        return new java.awt.Point(
          );
    }
    public boolean hasFeature(java.lang.String s) {
        return FEATURES.
          contains(
            s);
    }
    public boolean supportExtension(java.lang.String s) {
        return extensions.
          contains(
            s);
    }
    public void registerExtension(org.apache.batik.bridge.BridgeExtension ext) {
        java.util.Iterator i =
          ext.
          getImplementedExtensions(
            );
        while (i.
                 hasNext(
                   ))
            extensions.
              add(
                i.
                  next(
                    ));
    }
    public void handleElement(org.w3c.dom.Element elt,
                              java.lang.Object data) {
        
    }
    public org.apache.batik.bridge.ScriptSecurity getScriptSecurity(java.lang.String scriptType,
                                                                    org.apache.batik.util.ParsedURL scriptURL,
                                                                    org.apache.batik.util.ParsedURL docURL) {
        return new org.apache.batik.bridge.DefaultScriptSecurity(
          scriptType,
          scriptURL,
          docURL);
    }
    public void checkLoadScript(java.lang.String scriptType,
                                org.apache.batik.util.ParsedURL scriptURL,
                                org.apache.batik.util.ParsedURL docURL)
          throws java.lang.SecurityException {
        org.apache.batik.bridge.ScriptSecurity s =
          getScriptSecurity(
            scriptType,
            scriptURL,
            docURL);
        if (s !=
              null) {
            s.
              checkLoadScript(
                );
        }
    }
    public org.apache.batik.bridge.ExternalResourceSecurity getExternalResourceSecurity(org.apache.batik.util.ParsedURL resourceURL,
                                                                                        org.apache.batik.util.ParsedURL docURL) {
        return new org.apache.batik.bridge.RelaxedExternalResourceSecurity(
          resourceURL,
          docURL);
    }
    public void checkLoadExternalResource(org.apache.batik.util.ParsedURL resourceURL,
                                          org.apache.batik.util.ParsedURL docURL)
          throws java.lang.SecurityException {
        org.apache.batik.bridge.ExternalResourceSecurity s =
          getExternalResourceSecurity(
            resourceURL,
            docURL);
        if (s !=
              null) {
            s.
              checkLoadExternalResource(
                );
        }
    }
    public static float getStandardLighterFontWeight(float f) {
        int weight =
          (int)
            ((f +
                50) /
               100) *
          100;
        switch (weight) {
            case 100:
                return 100;
            case 200:
                return 100;
            case 300:
                return 200;
            case 400:
                return 300;
            case 500:
                return 400;
            case 600:
                return 400;
            case 700:
                return 400;
            case 800:
                return 400;
            case 900:
                return 400;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Bad Font Weight: " +
                  f);
        }
    }
    public static float getStandardBolderFontWeight(float f) {
        int weight =
          (int)
            ((f +
                50) /
               100) *
          100;
        switch (weight) {
            case 100:
                return 600;
            case 200:
                return 600;
            case 300:
                return 600;
            case 400:
                return 600;
            case 500:
                return 600;
            case 600:
                return 700;
            case 700:
                return 800;
            case 800:
                return 900;
            case 900:
                return 900;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Bad Font Weight: " +
                  f);
        }
    }
    public org.w3c.dom.svg.SVGDocument getBrokenLinkDocument(org.w3c.dom.Element e,
                                                             java.lang.String url,
                                                             java.lang.String message) {
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          e,
          org.apache.batik.bridge.ErrorConstants.
            ERR_URI_IMAGE_BROKEN,
          new java.lang.Object[] { url,
          message });
    }
    public UserAgentAdapter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GDgGwy/hH1v/D2duOG5tRgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18ebD02FVfvzf7eDwr9oy3GY89Nh7Lfmq11FI3A8S9qDdJ" +
       "3epWS70Qe1BrV2tfWgs4sZ0KmFAYQ8Zgp8DxHzYkZMAUAQIhdoaE3VQSuwgB" +
       "qsAuAgkYCDjFGgjkqrvf997X3/c92/Xe5FXpPPXdf+ece+65i+7zf1S6IwxK" +
       "kOdamWa50YmSRiemVT2JMk8JTwZ0lRWDUJFblhiGUxD2rPS6H37gz//6/fqD" +
       "x6U7l6VHRMdxIzEyXCecKKFrbRSZLj1wFkpaih1GpQdpU9yIcBwZFkwbYfQM" +
       "XXrJuaxR6Sn6tAkwaAIMmgBvmwA3zlKBTC9VnNhuFTlEJwr90j8oHdGlOz2p" +
       "aF5UevL6QjwxEO19MewWASjh7uK3AEBtM6dB6bXXsO8w3wD4AxD83He/48Ef" +
       "ua30wLL0gOFwRXMk0IgIVLIs3Wcr9koJwoYsK/Ky9JCjKDKnBIZoGfm23cvS" +
       "w6GhOWIUB8o1JhWBsacE2zrPOHefVGALYilyg2vwVEOx5NNfd6iWqAGsLz/D" +
       "ukPYKcIBwHsN0LBAFSXlNMvta8ORo9IThzmuYXyKAglA1rtsJdLda1Xd7ogg" +
       "oPTwTnaW6GgwFwWGo4Gkd7gxqCUqvfKWhRa89kRpLWrKs1HpscN07C4KpLpn" +
       "y4giS1R62WGybUlASq88kNI5+fzR8Kvf9w1OzznetllWJKto/90g0+MHmSaK" +
       "qgSKIym7jPe9mf4u8eWfeO9xqQQSv+wg8S7Nv/nGL7ztLY+/8Au7NK+6SZrR" +
       "ylSk6Fnpo6v7P/3q1tP124pm3O25oVEI/zrkW/Vn9zHPpB7oeS+/VmIReXIa" +
       "+cLk5xbv+gHlD45L9/ZLd0quFdtAjx6SXNszLCXoKo4SiJEi90v3KI7c2sb3" +
       "S3eBd9pwlF3oSFVDJeqXbre2QXe629+ARSooomDRXeDdcFT39N0TI337nnql" +
       "Uuku8JQq4IFLu7/t/6hkwLprK7AoiY7huDAbuAX+QqCOLMKREoJ3GcR6LrwC" +
       "+r9+K3JCwKEbB0AhYTfQYBFoha7sIuFVYMiaAvOhEjQ0xYkasugBxTopVM77" +
       "/1lZWiB/MDk6AkJ59aFJsEBv6rmWrATPSs/FTfILP/Tsp46vdZE9z6LSm0CN" +
       "J7saT7Y1nuxqPDmssXR0tK3oK4qad5IHclsDCwBs431Pc28ffP17X3cbUDkv" +
       "uR0wvUgK39pEt85sRn9rGSWguKUXPpi8W/iH5ePS8fW2tmgtCLq3yM4WFvKa" +
       "JXzqsI/drNwHvvn3/vzj3/VO96y3XWe890bgxpxFJ37dIV8DV1JkYBbPin/z" +
       "a8Ufe/YT73zquHQ7sAzAGkYi0F5gaB4/rOO6zvzMqWEssNwBAKtuYItWEXVq" +
       "ze6N9MBNzkK2Ar9/+/4Q4DFa2pPr1L2IfcQr6FfsFKQQ2gGKreH9Gs773l/7" +
       "T7+Pbtl9aqMfODfqcUr0zDm7UBT2wNYCPHSmA9NAUUC63/wg+08/8Eff/HVb" +
       "BQApXn+zCp8qaAvYAyBCwOZ//Av+r3/2tz76K8dnShOBgTFeWYaU7kD+Hfg7" +
       "As/fFk8BrgjY9emHW3vD8tprlsUran7jWduAjbFA1ys06CnesV3ZUA1xZSmF" +
       "xv7NA29AfuwP3/fgTicsEHKqUm/54gWchb+iWXrXp97xF49vizmSijHujH9n" +
       "yXaG85GzkhtBIGZFO9J3f+Y1H/p58XuBCQZmLzRyZWvJSlt+lLYCLG95AW0p" +
       "fBBXKcgT4fmOcH1fO+eLPCu9/1f+5KXCn3zyC9vWXu/MnJc7I3rP7FStIK9N" +
       "QfGPHvb6nhjqIB32wvDvP2i98NegxCUoUQI2LBwFwOik12nJPvUdd/3GT//H" +
       "l3/9p28rHXdK91quKHfEbYcr3QM0XQl1YK9S7++9bafNyd2APLiFWroB/E5B" +
       "Htv+uhM08Olb25pO4YucddfH/s/IWr3nt//yBiZsrcxNhuCD/Ev4+e95Zetr" +
       "/2Cb/6y7F7kfT280xMBvO8tb+QH7z45fd+fPHpfuWpYelPZOoSBacdGJlsAR" +
       "Ck89ReA4Xhd/vVOzG8GfuWbOXn1oas5Ve2hozgYA8F6kLt7vPbAt9xdcfit4" +
       "ynvbUj60LUel7cvbtlme3NKnCvKVp135Hi9wI9BKRd6W/XRUurtDNqb8hOSA" +
       "wJ68hcAmYrJ1lJ6VfnL8uU9/b/7x53dddCUCT6AE3crnvtHtL6z3Gy4Ygc68" +
       "sT/rftULv//fhbcf7zvVS67nwkMXcWGb9GVR6aVnyg4kWQRSO+NbULQgjV1a" +
       "/Jbq/cyNzEf21SK3YP7oFswvXtunXL8XYFecsFDxbcLOjfBuWc81IIdo2C8T" +
       "zWvBg+9rwW+BZv6loLlNiq4x/Q23cl6a23/7+c5ByxdftOXbmtIjoMJ3VE6I" +
       "k3LxW7x5224rXt8Ehq1wO8MCOVTDEa3Txj5qWtJTpwOVAGZcQAhPmRZxCuDB" +
       "rdYUPfpkN005aOvTX3JbQY+6/6ww2gUznm/9nff/8re//rOg+wxKd2wKGwJ6" +
       "xLkah3ExCfym5z/wmpc897lv3Y7CgNnsd5EPvq0o1boIcUG2dkM9hfrKAiq3" +
       "dWNpMYyY7WCpyFu0F5pnNjBs4F9s9jMc+J0Pf3b9Pb/3g7vZy6EtPkisvPe5" +
       "f/J3J+977vjcnPH1N0zbzufZzRu3jX7pnsPnbdFNatnm6PzPj7/zp/7FO795" +
       "16qHr58BkWCC/4O/+n9/+eSDn/vFm7jYt1vuJQQbPZb2sLDfOP2jEak9b0jp" +
       "ch7PZZuj2Xo/3JAsvFb7zQ0cVXQzjBMNW3acLmNEK47ua8yaVPLVspJWfbkr" +
       "wWXOiHKni2ZamXH7o1ZjXWmqbS9bjFoL25d1VOqrqSAZHadfH9ud8UjPphjW" +
       "MiGK0Hys2exLMYzUR0SYxzizCr0VL/M1U1wRsqqidWUzD9DYlpVJnYkWGbdg" +
       "dHFOesl6wYhrHq/R1TZjlMUVQloZ5Hc9FM3mKpwnDJHTGLrqcaKwmU04PqDF" +
       "pWQbeMr5qY8ozFqd0K2lxwR8hde9njnGp7NoLK09wxAJZO3bFOKNU2E9mc+C" +
       "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" +
       "k9C525r7mxopeQ6sV/hqNsjGOWyMdTWW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("MBHY4KnsjYOOlixhVggwdSbwSmQt2kaXb9UCWlv1bA8KZZOH+6acdlOralCE" +
       "AlkjDkyIcFo3OV3sDuyFRXMYtxaqdODGKsnwco0Blqcu9/OmSoIZKI3w81gL" +
       "CODoQhuaquWtOGPYWOpuaobsDJ022YGsDZioJfV5hLfdMFAnCbcOmi6XSpHH" +
       "V0ij4riCYlmJMaoowKXMgO0buKRQR/X2ordEReABu2xYTVKdENdwYqiWKsum" +
       "0tKwbkzV2gue8TNIa1tVhlrS0jJMrazXpataLIya0FyfLRClWTa4Wg94YLWR" +
       "0qqxUt0RQ7OX0Oai7Uz1yXrWXSGGr1AumC0vUbvuZTTC5oIyDu2YT0ehJkBB" +
       "pi0cOek4MuGzODzrTTfK1MtFxxgva61hDjdHE4MYdZfcqlOVvblqxqDJTKwP" +
       "REmsN2S/xlJCbqvqlGGJwSJbG1Yq1a24hrMIG/O4juS1JGjXwfiJdjB+Xums" +
       "h45b1qOaZ7OdCeriHRrNpjK5mgG3nuIaUpvE+GG8kkhOwCxzveJY2B/XyZq7" +
       "sXE2M9IBbMBsEtXcvKboHN4dDhLOIGudnj1QfA8J2QpeI+NRe7yB5HYGMSAf" +
       "uwmoWgpcBmKAtiLaV/N+dcBBWNJRprqqY3RuLTpuipa17gLWcs7EJ4lZweZo" +
       "FUpk38cltcLmKtxphoTbrutNw+utjUDcYINwlRNcOFo3ksBRNGpeV7NpjW2m" +
       "E38JmNZYJPBiODTTWs4Q8ICezpwlNAnVFFWDKqwhs9E6gajQhrMwz9tcQ1gn" +
       "cjzVHVVb1qB6CIz4SAwGyLDr5r6z7uF5B50SkJkZGZp3rVFt7HkU0xvaWY2Q" +
       "M39VD3tKRRAqbneDSibWpezMTOB8bMTU1JxaVnUR+ShdL5b12GknHquLwO9T" +
       "7VS1IixdNKywzGJStezMOaTrML15WJM2bEDW0NCfYvJAbIQDbtKorTJgkT0t" +
       "LRviMsqEGe42ObMyzcaEPhyK9Y2qkOwm8YZVQ0KNeWUtirg68eBa0rfmI23B" +
       "YGmkMz4+NDuz8ohBkxpWDSbEZERp0LKpKDK12SDRYEU46WxabicW3GgtmYzp" +
       "O0udMGwF6s7WLhwbMNRMa6bosjzKDC2X6Ex7nBy7TWE5B24ysWDTVZ9htEoF" +
       "0eVgmKRpp+3XLHO46ba1bpLBeg/ZwO2KHI+61WiiNRrFFsQ7v7xdoIe2G17X" +
       "DumZFlFE6F/G7scu6smCvOHaFuL2787SrU+6nDsNcHS6ufbkFz3aVOz9vOZW" +
       "p/S2+z4ffc9zH5ZHH0NOt4bTqHRP5HpvtZSNYp2r9M2gpDffeo+L2R5SPDsH" +
       "8PPv+fwrp1+rf/2XcdLpiYN2Hhb5L5nnf7H7Ruk7j0u3XTsVcMPxyeszPXP9" +
       "WYB7AyWKA2d63YmA11yTwUsKlhenjZ7Zy+CZm20WP3jBHu6bdlpycJzl6CzB" +
       "27cJPnDBeZfvLsj7I1CNEl23ybtNHZ5TriQq3b5xDflM677ji+25na9sG/Bt" +
       "14Mv9rBbe/CtqwF/HttHL4j7voL886h0vyjLXCR3lN3R3CL0Q2cIP3IJhI8W" +
       "gW8Ez2CPcHD1CH/4grgfKci/ikoPgNm9YCiJ5wYRZ+TKaW9+xXbjWkyiE01x" +
       "7ZM2MHzbMw2V9hn+5y8r4RPwjPf4x1eu3vo2wScvYMILBflJIGbZCD1LzBgl" +
       "DEVNORDzv70szLeAZ7aHOXuRYP7SBTB/uSA/G5Xu28Mkg8ANDkD+3GVBPg2e" +
       "d+xBvuNKQZ6q5CNnZynIVFK8woJv8/3qBdh/oyCfvhj7Z64Cu7LHrrxIAv6d" +
       "C0D+j4J8FoyVoe4mDUsJogOEn7sEwoeLwFeDZ71HuH6REP7JBQj/d0H+ICrd" +
       "WyBkA9f2thD1M4h/eBUQgz3E4GogHm8THG9beobzby7A+bcF+YuLcP7lJXA+" +
       "UgQ+Dp5sjzN7cUR5dPetIR7dW5DbotJLCojAnVCNwL6ZO3HXynUtRXSuQT+6" +
       "/RLQHzrtp+/aQ3/X1UA/j+zRC+JeUZCHo9JjYLxljVSxeMeIpi5jWBYYWiMl" +
       "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");
}
