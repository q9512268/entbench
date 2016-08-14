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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/EiBsdPYHIcDH+Bxa3ckAMKJyQJhITy9jiS9EwchH2sBQX9UYOxpbH7ASQ2A" +
       "sJHZiqWa7knbB8aTkwBGFY6F4Yk6EkUnDkY+1oDAbuHjhIKl+W7C5PWXc2ku" +
       "ln+hAHQvYfM8J9UWS8CpDeogmpC+tBObkASCclI6ZKgxD8yfTQKY03EMw80+" +
       "B5F9EwczH2thMKcjmMPXKqGYkQy1y1JHLPabAtCdw+ZXEJRVe+MIlJeq4nAK" +
       "6j4ffAEoy6OGoTGqXy7dnf1fYJzmZMZ416J4hp+d84eM/BNBefxYbcWsY7e+" +
       "KQ6umYv+ajiQxFOa5iul/WV1mWmxuCqgqZb3Hqb4+iMn8wte20KNL76FCH+Q" +
       "TB9yMisPEwQ7+eKn/wj0EKSHecW3n+4TTio9OphKvvhJ/spJCZDg60XTtZAV" +
       "+SQAbAPIpotyLzuEPhsvp0/fXcaSrDpL/L/m1sOpLqecO3Ns67Y7L6w5IW8e" +
       "FY2OjuIsVXDCkfebmaP8oryzuXOVbVl+qeaJqUvdii3r5tO/N2FVYKzilnBO" +
       "4CrObs7cyJ07vu75Xxwoex1qzR2kCKx++g7fv1vyr5yWtJmCQ8SOSO5Jrpda" +
       "4o6wZfl3R9avjH/ylrhHIvLkNy8/fb/yxsmdv35g9vGmYlLVQabAmZKl+0il" +
       "8NFupgxZfWSaarenMdjpXKVa1jGxBm2dYmUlcHHgnJbpxStpThbnHn1zL/Ir" +
       "NWOYWRuMlB7DaeCgWeX1uFc6WbchKdMMMHg9vtM+k9EEtQGW2h/pNE33Prf0" +
       "tCncPj5+aIG2qEy84lv5vwEBq3lYex8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
