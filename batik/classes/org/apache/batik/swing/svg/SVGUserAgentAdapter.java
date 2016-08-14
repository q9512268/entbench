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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bDEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9qVTyv5VRr4QFh5S5ZDWE9maO3o4cynd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("snRbDuUbLkW3KZbLh4cC+L2zCuBRkKKdAKLzF8DXTin7w4z8B7DeHAgAgKey" +
       "vC8f4vvKWW34zSA9v8P3/Pnj+8YpZf81I38cFl4P8HVkhY+ssOs6YZe3dSs9" +
       "YcNfP+s8PgnSB3Y4P3D+OP/slLI/z8h/A1E7wEnJkh7ZGcypvpFPTOZ/PyvI" +
       "p0H60A7kh84H5BFH9eWMYe/WmyPdu5hlfnc7o6SuasBIM6isnD0fB7tXOCvY" +
       "KyD9/A7sz79GYO89Bez9GbkLxJIAbCv/ePKmWO8+q5VmK9Bndlg/c+7au/fI" +
       "KWWPZeSNWy9EgoA5AtFgcNw69x46Dy/0Gzt8v3H++N56StmzGXlqq7PZy+o0" +
       "TC15qsng14Q4gfPKWXG+BaRXdzhfPX+clVPKahmBw8IbAM4FReaf/fv5C/hw" +
       "91p6BChy1pDprSB9cQf0i+cP9LSyVkauAqB6cA0nw1u6BN76t18NvXoI9B1n" +
       "ndGHQfryDuiXzx8oeUrZMCN4WLhjt67wJyaxd1Zs2SR+ZYftK+ePbXFK2TIj" +
       "07DwIMCGWmAdcfhQPjTNE0hnZ30dLYH0Rzukf3Q+SE++ybya45JOwaxk5Dkw" +
       "n64nO9n3sxnT4Svp3nvOapRPgfSNHcpvnA/Kk+8xe94pALPNkj0zBN1Enuf6" +
       "IZaEshPsvhM/YpTWWaezDtK3dkC/da7Tmf/ONpCyXc+4LO5Lrr2fXfqSd/ez" +
       "jn+Cuv0ANwf/Y6cI5v0ZicPC6zTekSx5196J6U/OIJXMSxUgAHAnlO3/s0vl" +
       "lsNt6t4B/Mev2xDeXvXJ75nNJ2SG5Sdz2B86RSQfycgHt0HzVPR1L5zKYuTr" +
       "YXrQz5uv60fwdUmV92/AngvwhbOqVRHI4umdAJ86fwHmgjmUzsdvbGoH8H/w" +
       "yIfOO6jHtjL3XsrIz4SFy0BAokm6vLQVzAm1+tgZpHLHzqvsXd1J5eq5GtsJ" +
       "gZyy27WX7XbtfRJIBahL5lbAemFl1wyzj6dPKg5yM8U5tWIurLNsmeUqVAa4" +
       "uZ2wzmlX8MbC+uxNHfXe384Z/nFG/mFY+IFr6nES/glF+dXvB3sCXOQNroRl" +
       "91seuu4C6vbSpPiLL12+440vzf9Nfivq2sXGO8nCHUpkWUevIxx5vuj5sqLn" +
       "grlzeznBy+H9Zlh4+OYnU2HhFkCzUe+9suX/LRBr3Jg/LNyW/z/K/Xng5U9y" +
       "A778/1G+fxEWLh3yhYWL24ejLL8HxgJYsscvZnqw995ka+MPHVWjfH/g/u81" +
       "A9eqHL1OlR2Q5VeDDw6zou3l4OfET7/UH/7ot2uf3F7nEi1+s8lauYMs3L69" +
       "WZY3mh2IPXHT1g7auth75jv3/NKdTx8c3t2zHfChSh8Z2+M3vjuF2V6Y33ba" +
       "fPaNv/qOv/fSH+QXKP4vJGumcrM9AAA=");
}
