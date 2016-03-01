package org.apache.batik.bridge.svg12;
public class SVG12BridgeExtension extends org.apache.batik.bridge.SVGBridgeExtension {
    public float getPriority() { return 0.0F; }
    public java.util.Iterator getImplementedExtensions() { return java.util.Collections.
                                                                    EMPTY_LIST.
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() { return "The Apache Batik Team.";
    }
    public java.lang.String getContactAddress() { return "batik-dev@xmlgraphics.apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "The required SVG 1.2 tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        super.
          registerTags(
            ctx);
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGMultiImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGSolidColorElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVG12TextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.XBLShadowTreeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.XBLContentElementBridge(
              ));
        ctx.
          setDefaultBridge(
            new org.apache.batik.bridge.svg12.BindableElementBridge(
              ));
        ctx.
          putReservedNamespaceURI(
            null);
        ctx.
          putReservedNamespaceURI(
            org.apache.batik.util.SVGConstants.
              SVG_NAMESPACE_URI);
        ctx.
          putReservedNamespaceURI(
            org.apache.batik.util.XBLConstants.
              XBL_NAMESPACE_URI);
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        java.lang.String ns =
          e.
          getNamespaceURI(
            );
        if (org.apache.batik.util.XBLConstants.
              XBL_NAMESPACE_URI.
              equals(
                ns)) {
            return true;
        }
        if (!org.apache.batik.util.SVGConstants.
               SVG_NAMESPACE_URI.
              equals(
                ns)) {
            return false;
        }
        java.lang.String ln =
          e.
          getLocalName(
            );
        if (ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SCRIPT_TAG) ||
              ln.
              equals(
                org.apache.batik.util.SVG12Constants.
                  SVG_HANDLER_TAG) ||
              ln.
              startsWith(
                "animate") ||
              ln.
              equals(
                "set")) {
            return true;
        }
        return false;
    }
    public SVG12BridgeExtension() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "d+6Myg3w9Fjr7hm5yrlY86g1nGfsR7Q5QVAlqLwCm6Ih6/Yd2KX6Dz+x6qPp" +
       "UACeiLX+yMhVz8XqUc9OWqwtPDNXdYmXlKwiNRP/Qh5D/YI2PyWowsAxuE5B" +
       "BgM3fUa5iTbzuYXCBBX1a7LkmO65T2y6sXSIwsRuS//dIzddLtb8phtLTTew" +
       "UPRLWtzfzpMUJuzlPIb6HW3OAnTK5opBSANl0eJk1Pe6jOUxXElE0xQsqLc7" +
       "gs6N3KJJgsZlKyPSi/PEjD83eEFefOZoVemEoxv/yEpZqaJ5BVwUoglFcSW4" +
       "7mS3WDdwVGaGqOC1BZ19vUnQ1LxlTsi92TfT4DJnukLQhBxMAFL8xU3/Dljd" +
       "Sw/zsm833V8IKnfoYCr+4ia5SlAhkNDXa7odD3NyaQC29Vg2WZBZYmDeG387" +
       "77kqCDPSMh32X5WdsSZCVkI1fHTNuh03Fh3n1T1REYaG6Cyj4d7Ba4ipa/b0" +
       "nLPZcxWvnn2r8tmymXbOlFZddK+NBRWEJqvETfKUu8ymVNXr9WNLTr+yr/gS" +
       "ZHubUIEAO2qT658i/rdIS1JPQLK/KZjthtUjGKwS11L+7pYL/3ijoJaVbxC/" +
       "k9Xn4wiLB09fDkV1/Vs+VNaBRsF9Dyd7UTnblV1Y7DfSLmzFES2hpv7WqqTR" +
       "LtB8h1nGMuiYVC8t/BLUmHkpzSyGlyvaADaW09npNGM8hYmErrtHmWVFjgvU" +
       "0hCF4WCnrlv1UB9byjJdZ9v6I4YM/wHuTGWPkB4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
