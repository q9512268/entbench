package org.apache.batik.swing.svg;
public class SVGUserAgentAdapter implements org.apache.batik.swing.svg.SVGUserAgent {
    public SVGUserAgentAdapter() { super(); }
    public void displayError(java.lang.String message) { java.lang.System.
                                                           err.println(message);
    }
    public void displayError(java.lang.Exception ex) { ex.printStackTrace(
                                                            ); }
    public void displayMessage(java.lang.String message) { java.lang.System.
                                                             out.println(
                                                                   message);
    }
    public void showAlert(java.lang.String message) { java.lang.System.err.
                                                        println(
                                                          message); }
    public java.lang.String showPrompt(java.lang.String message) { return "";
    }
    public java.lang.String showPrompt(java.lang.String message, java.lang.String defaultValue) {
        return defaultValue;
    }
    public boolean showConfirm(java.lang.String message) { return false;
    }
    public float getPixelUnitToMillimeter() { return 0.26458332F;
    }
    public float getPixelToMM() { return getPixelUnitToMillimeter(
                                           ); }
    public java.lang.String getDefaultFontFamily() { return "Serif";
    }
    public float getMediumFontSize() { return 9.0F * 25.4F / (72.0F *
                                                                getPixelUnitToMillimeter(
                                                                  ));
    }
    public float getLighterFontWeight(float f) { int weight =
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
    public float getBolderFontWeight(float f) { int weight =
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
    public java.lang.String getLanguages() {
        return "en";
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
    public java.lang.String getMedia() { return "screen";
    }
    public java.lang.String getAlternateStyleSheet() {
        return null;
    }
    public void openLink(java.lang.String uri,
                         boolean newc) { 
    }
    public boolean supportExtension(java.lang.String s) {
        return false;
    }
    public void handleElement(org.w3c.dom.Element elt,
                              java.lang.Object data) {
        
    }
    public org.apache.batik.bridge.ScriptSecurity getScriptSecurity(java.lang.String scriptType,
                                                                    org.apache.batik.util.ParsedURL scriptURL,
                                                                    org.apache.batik.util.ParsedURL docURL) {
        return new org.apache.batik.bridge.RelaxedScriptSecurity(
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
       "rwEp2gsgungBfO2Msj/KyX8E682RAAB4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ks/78jG+r5x3Dr8epGf3+J69eHzfOKPsv+XkT8LSywG+jrqSIjMkHDskJMsw" +
       "01Nz+Ovn1ePjIL1nj/M9F4/zz88o+4uc/HcQtQOclKoYkZXD5IxMPaXM/3Fe" +
       "kE+C9P49yPdfDMgTjurLOcPB7bdGenBnnvndnUZJQ9PBJM2hCmr+fD3Yg9J5" +
       "wV4B6Rf3YH/xRQL7wBlgH8rJS0AsCcC2ig8fb4n1vvPO0nwF+vQe66cv3HoP" +
       "Xn1G2aM5edXOC5EgYI5ANBhcPzsPHr4IL/Sbe3y/efH43nhG2dM5eWJns/nL" +
       "KhempsrpKvjFDk7hvHJenG8A6XN7nJ+7eJy1M8rqOYHC0isAzjlFFp/z+8UL" +
       "OL1/LT0BFD5vyPRGkL64B/rFiwd6VlkrJ1cBUCO4hnMmmYYC3vp3X/x87hjo" +
       "W86r0UdA+vIe6JcvHih5Rhmdk15Yunu/rkinlNg/L7ZciV/ZY/vKxWObn1Em" +
       "5oQLS68E2HATrCO2FKrHU/MU0ul5X0erIP3xHukfXwzS028ynytwKWdgXuXk" +
       "GaBPx1Xt/NvXnOn4lfTgHeedlE+A9I09ym9cDMrT7zEH7hkA882Sg00Iuolc" +
       "1/HDbhKqdrD/xvvEpDTPq84GSN/aA/3Whaqz+J1vIOW7njEiHyqOdZhf5lL3" +
       "966u/3x09/FsAf7HzxDMu3MSh6WX6pKtmOq+vVPqT84hldxLlcoA4F4ou//n" +
       "l8ptx9vU/SP4j92wIby7wlPcH+NZMsfyUwXs958hkg/m5L27oJmTfcMNOVWO" +
       "fCNMj/p5/Q39LH1D0dTDm7AXAnzfec2qAmTx5F6AT1y8AAvBHEvnozefakfw" +
       "f/DER8p7qNdtZR48n5OfC0uXgYDkDelIyk4wp8zqI+eQyt17r3JwdS+Vqxc6" +
       "2U4J5IzdroN8t+vg40AqwFxytwLWCzO/Pph/+HzacOBbGc6ZFQthnWfLrDAh" +
       "BOBe7IV1QbuCNxfWZ27pqA/+dsHwT3Lyj8LSD1wzj9PwTxnKr30/2BPgIm9y" +
       "nSu/m/LwDRdLd5ch5V9+/vLdr3qe/7fFjaZrFxbvIUt3ryLTPHmV4MTzna6v" +
       "roxCMPfsLha4BbzfCkuP3PpkKizdBmg+6oMXdvy/DWKNm/OHpTuK/ye5Pw+8" +
       "/GluwFf8P8n3L8PSvcd8YenO3cNJlt8HYwEs+eMXczs4eGeym+MPnzSjYn/g" +
       "oe+lgWtVTl6Fyg/Iiiu/R4dZ0e7S7zPyp54f0j/27frHd1exZFPKsryVu8nS" +
       "XbtbYUWj+YHY627Z2lFbd/af+s79v3LPk0eHd/fvBnxs0ifG9tjN7z11LTcs" +
       "bipln3nVr73l7z3/h8Xlh/8HIGxhKYs9AAA=");
}
