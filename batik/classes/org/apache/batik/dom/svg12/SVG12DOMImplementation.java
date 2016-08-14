package org.apache.batik.dom.svg12;
public class SVG12DOMImplementation extends org.apache.batik.dom.svg.SVGDOMImplementation {
    public SVG12DOMImplementation() { super();
                                      factories = svg12Factories;
                                      registerFeature("CSS", "2.0");
                                      registerFeature("StyleSheets", "2.0");
                                      registerFeature("SVG", new java.lang.String[] { "1.0",
                                                      "1.1",
                                                      "1.2" });
                                      registerFeature("SVGEvents",
                                                      new java.lang.String[] { "1.0",
                                                      "1.1",
                                                      "1.2" });
    }
    public org.apache.batik.css.engine.CSSEngine createCSSEngine(org.apache.batik.dom.AbstractStylableDocument doc,
                                                                 org.apache.batik.css.engine.CSSContext ctx,
                                                                 org.apache.batik.css.parser.ExtendedParser ep,
                                                                 org.apache.batik.css.engine.value.ValueManager[] vms,
                                                                 org.apache.batik.css.engine.value.ShorthandManager[] sms) {
        org.apache.batik.util.ParsedURL durl =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             doc).
          getParsedURL(
            );
        org.apache.batik.css.engine.CSSEngine result =
          new org.apache.batik.css.engine.SVG12CSSEngine(
          doc,
          durl,
          ep,
          vms,
          sms,
          ctx);
        java.net.URL url =
          getClass(
            ).
          getResource(
            "resources/UserAgentStyleSheet.css");
        if (url !=
              null) {
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              url);
            org.w3c.css.sac.InputSource is =
              new org.w3c.css.sac.InputSource(
              purl.
                toString(
                  ));
            result.
              setUserAgentStyleSheet(
                result.
                  parseStyleSheet(
                    is,
                    purl,
                    "all"));
        }
        return result;
    }
    public org.w3c.dom.Document createDocument(java.lang.String namespaceURI,
                                               java.lang.String qualifiedName,
                                               org.w3c.dom.DocumentType doctype)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.svg.SVGOMDocument result =
          new org.apache.batik.dom.svg12.SVG12OMDocument(
          doctype,
          this);
        result.
          setIsSVG12(
            true);
        if (qualifiedName !=
              null)
            result.
              appendChild(
                result.
                  createElementNS(
                    namespaceURI,
                    qualifiedName));
        return result;
    }
    public org.w3c.dom.Element createElementNS(org.apache.batik.dom.AbstractDocument document,
                                               java.lang.String namespaceURI,
                                               java.lang.String qualifiedName) {
        if (namespaceURI ==
              null)
            return new org.apache.batik.dom.GenericElement(
              qualifiedName.
                intern(
                  ),
              document);
        java.lang.String name =
          org.apache.batik.dom.util.DOMUtilities.
          getLocalName(
            qualifiedName);
        java.lang.String prefix =
          org.apache.batik.dom.util.DOMUtilities.
          getPrefix(
            qualifiedName);
        if (org.apache.batik.util.SVG12Constants.
              SVG_NAMESPACE_URI.
              equals(
                namespaceURI)) {
            org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory ef =
              (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                factories.
                get(
                  name);
            if (ef !=
                  null) {
                return ef.
                  create(
                    prefix,
                    document);
            }
        }
        else
            if (org.apache.batik.util.XBLConstants.
                  XBL_NAMESPACE_URI.
                  equals(
                    namespaceURI)) {
                org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory ef =
                  (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                    xblFactories.
                    get(
                      name);
                if (ef !=
                      null) {
                    return ef.
                      create(
                        prefix,
                        document);
                }
            }
        if (customFactories !=
              null) {
            org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory cef;
            cef =
              (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                customFactories.
                get(
                  namespaceURI,
                  name);
            if (cef !=
                  null) {
                return cef.
                  create(
                    prefix,
                    document);
            }
        }
        return new org.apache.batik.dom.svg12.BindableElement(
          prefix,
          document,
          namespaceURI,
          name);
    }
    public org.apache.batik.dom.events.DocumentEventSupport createDocumentEventSupport() {
        org.apache.batik.dom.events.DocumentEventSupport result =
          super.
          createDocumentEventSupport(
            );
        result.
          registerEventFactory(
            "WheelEvent",
            new org.apache.batik.dom.events.DocumentEventSupport.EventFactory(
              ) {
                public org.w3c.dom.events.Event createEvent() {
                    return new org.apache.batik.dom.svg12.SVGOMWheelEvent(
                      );
                }
            });
        result.
          registerEventFactory(
            "ShadowTreeEvent",
            new org.apache.batik.dom.events.DocumentEventSupport.EventFactory(
              ) {
                public org.w3c.dom.events.Event createEvent() {
                    return new org.apache.batik.dom.svg12.XBLOMShadowTreeEvent(
                      );
                }
            });
        return result;
    }
    public org.apache.batik.dom.events.EventSupport createEventSupport(org.apache.batik.dom.AbstractNode n) {
        return new org.apache.batik.dom.svg12.XBLEventSupport(
          n);
    }
    protected static org.apache.batik.dom.util.HashTable
      svg12Factories =
      new org.apache.batik.dom.util.HashTable(
      svg11Factories);
    static { svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_DIV_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowDivElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_LINE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowLineElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_PARA_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowParaElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_BREAK_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionBreakElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_EXCLUDE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionExcludeElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_ROOT_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRootElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_SPAN_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowSpanElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_HANDLER_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.HandlerElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_MULTI_IMAGE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.MultiImageElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SOLID_COLOR_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SolidColorElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SUB_IMAGE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SubImageElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SUB_IMAGE_REF_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SubImageRefElementFactory(
                                  )); }
    protected static class FlowDivElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowDivElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowDivElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "5a+s+fZ/AZFOWkyIFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class FlowLineElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowLineElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowLineElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m2/8F0suIBSKFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "FjgXZZXy9A8e+L3X/+Zz38yLb/8Le7/7ew8gAAA=");
    }
    protected static class FlowParaElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowParaElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowParaElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f2XN9/4LUar78IoUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class FlowRegionBreakElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionBreakElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionBreakElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "r18V+58Xr/j42n8BE2lEVJgUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "wZ68+x/+44ZJyJHlJmvyKf4x/PynHibf9P2cf5fiGfej6Y0YDTZyO97S55x/" +
           "23vy/J/tQbePoSvawS6xr9pxljhjsDMKD7eOYCd5ov/kLme7pF87grBXn4aX" +
           "Y8OeBpfd2gCeM+rs+eJxPPkJ+JwB3//Jvtl0Zy+2a+s95MEC//jRCu/76RmQ" +
           "redK+9h+MeN/cy7liby9mjU/t3VT9vjzIK3DfHsKOKamq9r5wG+JQIjZ2tVD" +
           "6X2wXc2WoYWN5WLuBxv0PJwy6/e3e7wtoGVtKRexDQn0luHzC1uqfOW6tBPG" +
           "emC7+MF//Mg3P/yaF4FP29C5JJtv4MpjI/JxtoN+7/Mff+RVz373gzlKAfjp" +
           "f+B3se9mUtmXszhrqKyhD019ODNVzrcFrBpGXA4shp5b+7KhLAamA/A3Odge" +
           "ws/c86L1qe99frv1Ox23p4iN9z/7az/Z/9Cze8c23K+5Yc97nGe76c6Vvutg" +
           "hgPoiZcbJeeg/+mLz/zRbz/zvq1W95zcPlLgdPT5v/rvb+5/8rtfv8lO5Tbb" +
           "+z84NrrzSqsSMvXDD4uM1NJK66eDQlzGKN1ZJ+UV2sZIOabSrovx46iOdIXJ" +
           "oNzqzTeDRs1u+w2v6GDhRi9rruuXxht+nSLrKh3N20vTrjPMoNhQkjLb7yrL" +
           "yUjxGhV7IPl9b7lqy/KqqyBMg3LhDqMykjL1ekNhqDu6M3aRiks21imqJxND" +
           "wws1FN0kU2GqTQ1KXU5orhiGxVY8ZYlANEfpcuqpExqlm/1BNEqbVNTeID0p" +
           "QeHqSAiMTsfR23gRVS2kgzTZBWnztopixU47oJfyKFUrXtrsTzmHS03UZG1z" +
           "ifFWEaOdcDZZmow/pTvDZnepeU1VjmhW6Mn9SNtM5p2YtNory5VHZq/NTBrF" +
           "It8umgs/DZgkMZWZOF+OupqDJ+iUlpVk3aBLFjkOA9Xs+IPW2hu127X5shKP" +
           "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" +
           "H/z9N/zWc9/J63H/C4CCkCopIAAA");
    }
    protected static class FlowRegionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+58Xr/j41n8B5xaNeI4UAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class FlowRegionExcludeElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionExcludeElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionExcludeElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "yuLXb4r9z4tXfHzrvxoDj2ecFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "dtaR+18nbKJlLSAAAA==");
    }
    protected static class FlowRootElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRootElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRootElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f56/suY7/wX988aMihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "d34IPb5uAAey7AX1Mk4kyc0H3A+hOzzfDcGpXVPzcXdlrbyicd9R4fro92RZ" +
           "a1fr2Ds6Dr/ppsXcVhJqTmDKlnZjLfd0DTc7yz1yq7uK/Bz36Xc9+5zKfqa4" +
           "f1hrmoKj++EV0sn5+NDTtz6w9vN7ml0B5Cvv+peHhV+Yv+1llHUfOzPJsyJ/" +
           "p//819qvVT6yD507LofccIN0muna6SLIJV8LI98RTpVCHjk2z4OZNR4Bqh5a" +
           "e/t7Y2n1pnbfyx1t615n6nj7W8fIHezIqvdlVo1RJTdm01WizGI5d/wSVcC3" +
           "Z40PzKP4mhRqR8LuPSns0Po7Jw5+2rH6VLkthB64+V3A0WDFl325ADznoRuu" +
           "NLfXcMrnn7t88cHnRn+d19GPr8ruoKGLemRZJwtYJ54veL6mm/mK3LEtZ3n5" +
           "z3tC6OFbzy6Ezue/uSLv3nK8/9ASZzlC6BxoT1L+eghdOUsJJOa/J+k+FEKX" +
           "dnTAVNuHkyQfAdIBSfb4Ue8mVa9tzS/ZOxF9h2iT2/Oen2bPY5aTJfksYvPr" +
           "56PoirYX0NeVLzzXZd7+YvUz2ysBsBmmaSblIg3dvr2dOI7QJ24p7UjWBeqp" +
           "H9/1xTtecwQld20nvIubE3N77Ob195bthXnFPP3DB3//Db/13LfzItz/AkHQ" +
           "bsEXIAAA");
    }
    protected static class FlowSpanElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowSpanElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowSpanElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f1684uMb/wV3fVRSihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xNvFoJo2F8ZiWeGJwsjxvZVooWhDbCFVgCcgl6ecrvjWfDUPi+gUo73yEkSw" +
           "uRaYoNCuNecC3k4bnllJyeE8XAmBKfuOSKAmXUHTYgsbVRrD4qavWAVNtqpG" +
           "QJd0gBk4UigMBN9EBQGLqgmxCgdWsbhAaCFYYWiP6CnlNN3UKtXuxKEiulEy" +
           "zWBo1dKAMOneiiPcEV3iiwDKccJYK5uqwDQSPRkM+74OtGhPVzreWFtzEIu9" +
           "StQVdIyteZJL+v2+iMY05fBieUSl+FSZD1bUsM30u4rHuBiF89oq5Yy+Nncq" +
           "NWqaLDYzZsLh/rqv2QtSg+uVEC5zjlobTRS922Jskqh38Vbid1NNIGwFa0QL" +
           "2mZnDbhmVTldXw2UKTclpCVjRiVXaRRaSWvqssOZF8P1WJEaZRTWjHEXYVV0" +
           "nngrqUqMup7MBriuTBY1kuvNo6hc1zv4bLxu9kbFckNtlhO/Px3b46lMN1S4" +
           "EoSECDt+AVHJVttk9cVA0cQODsOujaF9sszDpcW4atIcYc4MCUans1qgwB0E" +
           "Q0NbVOkN0WqgUUGXegVzw054lVxGkuR2SdNotnCBUpjCGhb5zaodIo3WvFAL" +
           "2lhlDbNBEZ9bXjMSB3ZSqOtEgNTH3noTp9Nu4vgYtUyaoRFX4tlqEbF8PBDW" +
           "7kAVJzEvluZjpFRtppYz7DZxZ4KwtkrqKdayY61fIstwbdmQa3ytPuponaTo" +
           "L/wxNazi65noStZUlxnNLVOxgTcQAqP0gKXHAnBDOmvWdHGBFN1kgrVL6gqu" +
           "YjU90XWxtvQFclrpB1OSEFFu0DSSOrdMqXiyTPgWgvnuFEQcYsWztiFw3WiE" +
           "6LYxLMwqi2KjYnYa9ZJaJmIE6DLpa2zY0lvjCe90u8mU9Ei9sVnOi5ocD0TL" +
           "H3loRdEGvthY0fE05eSqDterVh3mkE0hQaJx24q1UmNJYkmtZkkTta3haSHg" +
           "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");
    }
    protected static class HandlerElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public HandlerElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMHandlerElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "z/NX9nj8v7I4iJqIFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "SW+84F4I3e76TgjOIlUp1j0uaRXVjHsPa9aHvydLWsd1jnOHV+E33bCOS6ah" +
           "ageGZKrXl3FP12/ze9zDN3umKO5wn3rnc88rw0+jewd1pjm4th+8Hp3kx4ee" +
           "uvlltV880RwXP778zn95aPoLq7e+gpLuo2eYPEvyd/ovfJV6vfzhPej8USnk" +
           "usej00hPny6AXPLVMPLt6akyyMNH6nkg18bDQNRnDtTzzI3LqjfU+7nC0Hbm" +
           "daaGt7czjMLADrV6b67VpCIXyiQcOco1VmAnL1MBfFve+EA9sq+KoXpI7J6T" +
           "xA60f2zEwU+6Up8qtYXQfTd8BjhcC33FzwrAcB687jFz9wAnf+75yxcfeH72" +
           "10UJ/eiR7HYWuqhFpnmydnWif6vrq5pRbMjtu0qWW/y8O4Qeujl3IXSh+C0E" +
           "edcO430HijiLEULnQXsS8tdD6MpZSECx+D0J98EQunQMBzS165wE+TCgDkDy" +
           "7kfcGxS8duW+9NwJ5zsINoU67/5J6jxCOVmNzx22eHg+dK5o9/R8Tf78893B" +
           "216qf3r3GiCbYpblVC6y0G27h4kjB338ptQOad1KP/mjO79w++sOI8mdO4aP" +
           "3eYEb4/euPROWm5YFMuzP3zg99/4W89/q6i//S97nmG+ESAAAA==");
    }
    protected static class MultiImageElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public MultiImageElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMMultiImageElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ya2wc1RW+u37Edmyv7fiR5uEkxgmKk+5iIG2RU8Bx7GTT" +
           "9UNxEgmnZHN35u7uxLMzk5k79tqUFpAq0qpK0zRAQMK/jFArCqgqaisBcoVU" +
           "QLSVoFFbWpFW6h/6iEpUif5IX+fcmdmZnd0lSn/Ukmdn7z333HvO+c53zt0X" +
           "rpEGyyT9TONxvmQwKz6u8RlqWkweU6llHYOxtPRUHf37qQ+n7omSxjnSnqfW" +
           "pEQtNqEwVbbmyFZFszjVJGZNMSbjihmTWcxcoFzRtTnSo1jJgqEqksIndZmh" +
           "wAlqpkgn5dxUMjZnSVcBJ1tTcJKEOEliNDw9kiKtkm4s+eIbA+JjgRmULPh7" +
           "WZx0pM7QBZqwuaImUorFR4om2WPo6lJO1XmcFXn8jLrPdcGR1L4KFwy8HPv4" +
           "xoV8h3DBBqppOhfmWUeZpasLTE6RmD86rrKCdZZ8mdSlyPqAMCeDKW/TBGya" +
           "gE09a30pOH0b0+zCmC7M4Z6mRkPCA3Gyo1yJQU1acNXMiDODhibu2i4Wg7Xb" +
           "S9Y6VlaY+MSexKWnTnV8v47E5khM0WbxOBIcgsMmc+BQVsgw0xqVZSbPkU4N" +
           "gj3LTIWqyrIb6S5LyWmU2xB+zy04aBvMFHv6voI4gm2mLXHdLJmXFYByvzVk" +
           "VZoDW3t9Wx0LJ3AcDGxR4GBmlgLu3CX184omc7ItvKJk4+AXQACWriswntdL" +
           "W9VrFAZIlwMRlWq5xCxAT8uBaIMOADQ52VRTKfraoNI8zbE0IjIkN+NMgVSz" +
           "cAQu4aQnLCY0QZQ2haIUiM+1qf3nH9IOa1ESgTPLTFLx/OthUX9o0VGWZSaD" +
           "PHAWtg6lnqS9r52LEgLCPSFhR+aHX7p+/97+tbccmc1VZKYzZ5jE09Jqpv3d" +
           "LWO776nDYzQZuqVg8MssF1k2486MFA1gmN6SRpyMe5NrR3/6wCPfZX+JkpYk" +
           "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" +
           "f1684uNb/wVGLRkajhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fLszuzssO7Pv7ZZ9MkB3jT4nseMkHSjEjh07" +
           "sfOwkzhxC4PjVxy/X4kTui0g8SoVIFgolWD/ArVFy6NVUStVVFtVLSBQJSrU" +
           "l1RAVaXSUiT2j9KqtKXXzveemUWrSo2UG+f6nHPPuefc3z333Od/AJ2PIwgO" +
           "fGdjOn6yr2fJ/tKp7iebQI/3O1x1oESxrpGOEscj0HdNffKLl3704w8vLu9B" +
           "F2ToXsXz/ERJLN+LBT32nZWucdCl417K0d04gS5zS2WlIGliOQhnxclVDnrF" +
           "CdYEusIdqoAAFRCgAlKogDSPqQDTK3UvdcmcQ/GSOIR+BTrHQRcCNVcvgZ44" +
           "LSRQIsU9EDMoLAASbs//T4BRBXMWQY8f2b6z+TqDPwYjz/7GWy//3i3QJRm6" +
           "ZHliro4KlEjAIDJ0p6u7cz2Km5qmazJ0t6frmqhHluJY20JvGbontkxPSdJI" +
           "P5qkvDMN9KgY83jm7lRz26JUTfzoyDzD0h3t8N95w1FMYOsDx7buLKTzfmDg" +
           "RQsoFhmKqh+y3GpbnpZAj53lOLLxShcQANbbXD1Z+EdD3eopoAO6Z+c7R/FM" +
           "REwiyzMB6Xk/BaMk0MM3FZrPdaCotmLq1xLoobN0g90rQHVHMRE5SwLdf5as" +
           "kAS89PAZL53wzw96b/jg2z3G2yt01nTVyfW/HTA9eoZJ0A090j1V3zHe+TT3" +
           "ceWBL79vD4IA8f1niHc0f/DLL7759Y++8NUdzc/egKY/X+pqck399Pyub76K" +
           "fKpxS67G7YEfW7nzT1lehP/g4M3VLAAr74EjifnL/cOXLwh/PnvHZ/Xv70EX" +
           "WeiC6jupC+LobtV3A8vRo7bu6ZGS6BoL3aF7Glm8Z6HbwDNnefqut28YsZ6w" +
           "0K1O0XXBL/6DKTKAiHyKbgPPlmf4h8+BkiyK5yyAIOh+8IWegKBzJlR8zhl5" +
           "m0AasvBdHVFUxbM8HxlEfm5/jOheMgdzu0DmIOptJPbTCIQg4kcmooA4WOgH" +
           "LzTfReKVWa4g4qRdrrT6POsGACUAf7Fc9vNoC/6fxslyey+vz50DrnjVWSBw" +
           "wBpifEfTo2vqsylBvfj5a1/fO1oYBzOVQB0w9P5u6P1i6H0w9H4x9P6Nh77C" +
           "p05isS6If2rXTSv5it9A584VqtyX67aLCOBPGyADwMw7nxLf0nnb+568BYRi" +
           "sL41dwkgRW4O3eQxlrAFYqogoKEXPrF+5+RXS3vQ3mkMzu0BXRdz9kGOnEcI" +
           "eeXs2ruR3Evv/d6PvvDxZ/zjVXgK1A/A4XrOfHE/eXbmI1/VNQCXx+Kfflz5" +
           "0rUvP3NlD7oVIAZAyUQBUQ0A6NGzY5xa5FcPATO35Tww2PAjV3HyV4codzFZ" +
           "RP76uKcIibuK57vBHF/Ko/51YK4XB8ug+M3f3hvk7X27EMqddsaKApDfKAaf" +
           "+pu/+Ge0mO5D7L50YjcU9eTqCbzIhV0qkOHu4xgYRboO6P7+E4OPfuwH7/3F" +
           "IgAAxatvNOCVvCUBTgAXgml+91fDv/3Otz/9rb3joEnAhpnOHUvNjoy8Pbfp" +
           "rpcwEoz22mN9AN44YC3mUXNl7Lm+ZhmWMnf0PEr/69Jryl/61w9e3sWBA3oO" +
           "w+j1P13Acf/PENA7vv7Wf3+0EHNOzfe74zk7JtuB6L3HkptRpGxyPbJ3/uUj" +
           "v/kV5VMAjgEExtZWL1ANKuYAKpyGFPY/XbT7Z96V8+ax+GTwn15fJ/KSa+qH" +
           "v/XDV05++McvFtqeTmxO+ppXgqu78MqbxzMg/sGzK51R4gWgw17o/dJl54Uf" +
           "A4kykKgCiIv7EYCi7FRkHFCfv+3v/uRPH3jbN2+B9mjoouMr2g5QwEYAoluP" +
           "FwDFsuBNb955d527+3JhKnSd8bugeKj4dwtQ8Kmb4wud5yXHS/Sh/+w783f9" +
           "w39cNwkFstxgOz7DLyPPf/Jh8he+X/AfL/Gc+9HsengGOdwxb+Wz7r/tPXnh" +
           "z/ag22TosnqQIE4UJ80XjgySovgwawRJ5Kn3pxOc3W5+9QjCXnUWXk4MexZc" +
           "jrcF8JxT588XT+LJT8DnHPj+T/7Npzvv2G2r95AHe/vjR5t7EGTnwGo9X9mv" +
           "7Zdy/jcVUp4o2it587qdm/LHnwPLOi4yU8BhWJ7iFAO/OQEh5qhXDqVPQKaa" +
           "70BLp1aIuR/k5kU45dbv79K7HaDlbaUQsQuJ6k3D5+d3VMXOddexMM4HmeIH" +
           "/vHD3/jQq78DfNqBzq/y+QauPDFiL82T5/c8/7FHXvHsdz9QoBSAn8n7f7f2" +
           "3Vwq91IW5w2VN/ShqQ/npopFRsApccIXwKJrhbUvGcqDyHIB/q4OMkPkmXu+" +
           "Y3/ye5/bZX1n4/YMsf6+Z3/tJ/sffHbvRK796uvS3ZM8u3y7UPqVBzMcQU+8" +
           "1CgFB/1PX3jmj377mffutLrndOZIgYPR5/7qv7+x/4nvfu0GScqtjv9/cGxy" +
           "550MFrPNww9XnimVtVoWJDhFa5TmblY1wxKqKWVnptu14arFtivCuE5ktfZo" +
           "1Bj3MsoEGSzTQ6tpLc04fmtX7VojCcd00AxLYdAtbYXmkO8iS7oZkaEZKlZM" +
           "qP5kPOTEiU/TcymgJXyB4BYVjC2jyk5hQ3U1V/a0kiN6yNh2Na+2RVGUWfVh" +
           "tYpuk9I0Cqj2ZjNqjPq9bOUO190tntYFJ5TstT7GHYeZ9bNkIIwZA62FQ9ir" +
           "+a6YLT3RCw0poIZJL6TWk/nc3dAyHW+Xk05b7vHifGkt3JGkZqpPb4Vk5Il+" +
           "edkxQyq0Y9bTZHexbjphYJteVcvG/FL2xIlKdMrJSO10qT7lWL3WumFb3cR2" +
           "sRjW2XkT7ixNwR1zg0VNkrNSwNeGhByuU4V1x35EC5jvVqSBjzudfnnqqvTU" +
           "qy+5aKCpbaHMYV16vakzgxWW+ZP6Am0RRBgE/YXhSmNdDpSYG1G44LbqeBR1" +
           "SU2W664mOptB2ORJvdWVkBHR3igmVWooaCnoM6V5Cd6SLlnjMRl3BXtANtH2" +
           "xi9vOsNxWVF7U95q9VsLa55WLEwya9O52JjhE0eZwbyoZ13JG3mT+gqrUVV7" +
           "wZekedYnWNWMeVeFieEkNtelLJzI4nxgj7GeuUS5ESuFm4id42KV20juuJIR" +
           "8HZTwhRixdPMCl/5LGa6FZebMhrXcaf0jNisthN7IvstCU0aUlbiOmhTbbUz" +
           "AWsTrmNyKUpOy3Uwb2qNTVbdjo3BzemwSUqRFa+9ROOkxiSimzLrrHnBkcJq" +
           "RmbNUT0lFJbvN1vDamUijLpGpPg9tr6dUyV2ydo9uMebE3GrNocppgw9jpyV" +
           "hvKwslDYscXD5dBAPabB9pUyJZqjATeiuQzpJ4vxtOGXJm1JFpXWgGlKiYk7" +
           "Xig2omqFo0yOHIj0QoAVZloLYKRRg5O5qrpqeSJ3Z1u5ugSe6YTBCgVK92s1" +
           "3GvNtkM5DSdmnY9jumxXsDrO082y6fZwUQg2vF7tRQKK4GtyYMhTuGMHM1uR" +
           "hVJZxJrLpe+spKbfXfIDflaRnRZfFeVQ7vhwBxYFmYDrgSAN+jgzrCjbtt4Z" +
           "SGG7HY2zqbYeC/LYZxMFo1EhjiJ07pA6DTdoM2uJTaRhE5u2wBA0YotruC9T" +
           "I32ONilHtNyQCyzBGQkgDSJaRJ/wNvNRZdhsGHxHrGk9s02QPZTvkMsly6Ma" +
           "WTbjjrKhUKOtWY1YXGCjeDCy6xZZY8mIMALK1kttA/aMWeDXsDktNgUyFic8" +
           "QUZ2qU1rjuzKjlWTibqyWlUXcLamgH3zqDvG++uenMlwilVafl+qG3R5xYTS" +
           "utGvWMHUNqdNpGZuBxSVYVWN7ZDdfskve2rWJOrympFNIpwnpQYMk0IJVtu4" +
           "SXYzl20sTIEi6kG33FkMmKzmBbg0TZNQ0sprzbB6Xdzp2ySqbMKZP5EbI74p" +
           "a516BceTCjgBDuyyzKTmwm1lPCp1NmNikUhhJ8QnnWml6S69gchoLXMyWvLV" +
           "8SiBHa6MtEdJPe0uO7XqRqgK1KYet+eJ3VyyBidXW7GID+F2V+EUL1guUQSr" +
           "j5PBINzWMpqWFrXtRppT4lwwWXMzjb1oWEo6Fdj2agk2ZhYNd2ZqNragZtQW" +
           "rvdqzoARLd7IFCoetTvbyXbYmahqtFWHq4GLhNYAwAJKenq6piR+vB1X1pSu" +
           "j7RtJhr9xiLCakxvuNyanCTS4aaveUtJQ+pYjKDiVK3J0lzqEgO3Pal3KCIL" +
           "uxln067XaiTLjsubjTrjuFIdUXU0swF6sww9T4Ylpj6y2+XmbEG0NKShVLY1" +
           "BIFxsCBCtrFtLaf61iajCbmWK7NhJZnCpD1vzblVvT7sUGGpqVvyisSI1WIc" +
           "m1EvbK5HeBXOPLW/QgYAPzG+RY9n9Xa/0kiHHQSheWZDDlbeIGBW5ebInhMU" +
           "vK1tM2GrozARMctJL/VHXrdVw1GQFqL4aDA0x0Q5UsZgvbNu0zQool0yVA7u" +
           "10fbWtICmW47K61DcrXdIM2wPJaiYF1V+hUqgxuGU1GTaD0l6zJuL/xlK9qu" +
           "YyVm8dWKrDLiTPLcYYomCe7HGp74vVLLZNrWxJSllUIMZrFjMS1Hqs4ajdRY" +
           "9WgAJiWcCkompwR9eaa2/OmMSAN3QsBs0l4ZWq0koJQ60Njx2qFVedrqkq2k" +
           "PB6g0yWB8Zy82SIhXGfgallPyWAoL/1abziTUAtWh4MllmRhX+0Rqbu1qYmJ" +
           "KmFJ6DR8tsHG8/m8Wx3pckYKyAIT6nNcsJE0pH0kY11dCYZkvesmjK5Om2Z7" +
           "k5SFtLNya+V4HEf1lbBdlzCmVJ7qcyxr9ZFKY4qgkYwwnIFaNdF1Io1ZzTGe" +
           "XqxqXZHfOLgQIJWBayEwrxoteNZHqbC8njOw2xiOEA7rcYQVTkcoKaDeNh41" +
           "Vn1PXiGrYUKz1YSdwO3JtOrVfQltwRWRs2XahLfjJRu1U28riD0yirteByMV" +
           "05dtrGQpG7w2E62VP+zRK6KkhBwbjXF9mLKY2xt0xKkkLXxriZstZQ13GbGz" +
           "jPnKoF+pwL1Gu9emK3Ux44aD7oLrpZ0B0+8TI5xc9lp4vzmb2QDEItzy5hQ9" +
           "cmeOxxtDzMiq5VJ7ZRv1DGMEv2T1epVy39qu2nwfRbkhUW9p0pSQNBxDS5gd" +
           "xqGEOHC3TlftZGrTcnPekKXyuLU2S4TfozbSZCaupEWl21NHzKC3CZUA7tvr" +
           "edYdrqsYvh2ihEVPUEIk6rBZpW1WLZtij40GPrH1Al6ampsmzpXagqA1++zK" +
           "7C7otMPqmj5hQc4TpqzGIz3WKStUulb4/pROtCo3aqTVCtUfpWjHxkMm8lCv" +
           "j0982xGxlVWJTbQdakQYjrFlEiqrXqkn1HRDGTSquqKNBaPrqTiBqKM5w7eq" +
           "XVJUTGHijXHLlrC+AzJQGF/VpgYKcrxRxax0eHtoUdzInKXlGe75JLw2J8kg" +
           "8LJKy1jHHSbs2Ro64HqVWg9JURRzreqcy5wk2ii6162vEbiecu2JvuiULa3T" +
           "LA9bk2C95GZBWaXs2iYc0iqGl7qajFEzjJUWYtix3VEkOt5cVsZjfKiZ441A" +
           "zgRjyugVZ6xkVXhi+32QwMCS22xOYFu2GY1OR4RuE4wRL+V5HdXJLGiXZN8c" +
           "NUTSnaCBXg5wvTWdhQ0d74Zzsz2M+Y3uG0HZkUs+zwzWnXVo2C1fmyLrHkIZ" +
           "S6SHVJclhmmmQwddzr1pHQwPbxclKq6q05FfVgRLn/f60SLgrWndYHqYj21t" +
           "x94QZbrlx1hVkBDDGcRGGa9jaW+OrCdtTrCV5WIIkv83vjE/Frzl5Z3M7i4O" +
           "oUcXDuBAlr9gXsaJJLvxgHsJdEcQ+Qk4tetaMe5xWauoaNx3WLo+/D1Z1jqu" +
           "dZw7PA6/6YblXCpLdC+25o5+fTX3dA03P8s9crPbiuIc9+l3Pfuc1v9Mee+g" +
           "1jQFR/eDS6ST+kTQ0zc/sPLFTc1xAeQr7/qXh0e/sHjbyyjrPnZGybMif4d/" +
           "/mvt16of2YNuOSqHXHeHdJrp6ukiyMVIT9LIG50qhTxy5J4Hc288Akx1Dtzj" +
           "3Li0ekO/nysCbRdeZ+p4e7vAKALs0Kv35V5do2rhzJavprnHCu71S1QB3543" +
           "EXCPGulKoh8Ku/eksAPvHwdx/NOO1afKbQn00M1uAw6HK7/sCwYQOw9dd625" +
           "u4pTP//cpdsffG7810Ul/ei67A4Out1IHedkCevE84Ug0g2rmJM7dgWtoPh5" +
           "TwI9fHPtEuh88VsY8u4dx/sPfHGWI4FuAe1Jyl9PoMtnKYHE4vck3YcS6OIx" +
           "HXDW7uEkyUeAdECSP340uEHda1f1y86dWH8HeFN49J6f5tEjlpNF+XzNFlfQ" +
           "h+sr3V1CX1O/8Fyn9/YX8c/sLgVUR9lucym3c9Btu/uJozX6xE2lHcq6wDz1" +
           "47u+eMdrDsHkrp3CxyvnhG6P3bgCT7lBUtTMt3/44O+/4bee+3ZRhvtfN7sV" +
           "0RsgAAA=");
    }
    protected static class SolidColorElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SolidColorElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSolidColorElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/wviFR9f/y/JG0rjjhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "hB49OIALWTbRfQU3kvTGC+5F0G1+4EXg1q6p+bq7slZe0bjnsHR9+Hu8rLWr" +
           "dZw5vA6/9Ybl3HYaaW5oyrZ2fTX3ZA03u8s9dLPXivwe95n3Pvu8yn4W2Tuo" +
           "NU3B1f3gEek4PwH05M0vrP38pWZXAPnqe//lQeEt83e8grLuI6eYPE3yd/ov" +
           "fL3zeuVje9DZo3LIdW9IJ5GuniyCXAy0KA5c4UQp5KEj9dyfaeMhIOq7DtTz" +
           "rhuXVm+o9zO5oW3N61Qdb29rGLmBHWr1nkyrSVnJldnylDjTWI6dvEwV8J1Z" +
           "EwD1KIEmRdohsbuPEzvQ/s6Iw591rT5RbougB272GnC4HPKKHxiA7Txw3bPm" +
           "9ilO+cLzly7c//zor/NK+tFz2W00dEGPbft4CetY/7wfaLqZ78lt24KWn/+8" +
           "P4IevDl3EXQu/80Fed8W40MHujiNEUFnQXsc8tcj6PJpSEAx/z0O99EIuriD" +
           "A8rado6DfAxQByBZ9+P+Depe26pfeuaY/x3Em1yjd/0sjR6hHC/KZz6bP0Ef" +
           "+le8fYS+pnzx+R7zzpdqn90+Cii2tNlkVC7Q0K3b94kjH33sptQOaZ3vPvGT" +
           "O7502+sOg8kdW4Z3nnOMt0duXIFvO36U18w3f3j/77/pt57/Tl6G+1+5+okj" +
           "GyAAAA==");
    }
    protected static class SubImageElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SubImageElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSubImageElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/7x4xcfX/wt9vIVSihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3983O7Oyw7My+t1v2yUC7G/TZTuLY6fBYx48k" +
           "TmI7cZ5uYXBsx3HiV/xO6LaACixLBQgWSiXYv0Bt0fJoVdRKFdVWVQsIVIkK" +
           "9SUVUFWptBSJ/aO0Km3ptfO955tFq0qNlBvn+pxzz7nn3N8999wXfgCdD3yo" +
           "4LnW2rDccE9Pw72Fhe2Fa08P9rg2Jip+oGuUpQRBH/RdVx//4uUf/fjD8yu7" +
           "0AUZultxHDdUQtN1gp4euFasa23o8lEvY+l2EEJX2gslVuAoNC24bQbhtTb0" +
           "qmOsIXS1faACDFSAgQpwrgJMHlEBplfrTmRTGYfihMEK+hVopw1d8NRMvRB6" +
           "7KQQT/EVe1+MmFsAJFzM/g+BUTlz6kOPHtq+tfkGgz9WgJ/7jbdd+b1z0GUZ" +
           "umw6UqaOCpQIwSAydLut21PdD0hN0zUZutPRdU3SfVOxzE2utwzdFZiGo4SR" +
           "rx9OUtYZebqfj3k0c7ermW1+pIauf2jezNQt7eDf+ZmlGMDW+45s3VrIZv3A" +
           "wEsmUMyfKap+wHLL0nS0EHrkNMehjVdbgACw3mrr4dw9HOoWRwEd0F1b31mK" +
           "Y8BS6JuOAUjPuxEYJYQevKnQbK49RV0qhn49hB44TSduXwGq2/KJyFhC6N7T" +
           "ZLkk4KUHT3npmH9+wL/xg+9wGs5urrOmq1am/0XA9PAppp4+033dUfUt4+1P" +
           "tj+u3PflZ3YhCBDfe4p4S/MHv/zSU294+MWvbml+9gwaYbrQ1fC6+unpHd98" +
           "DfVE9VymxkXPDczM+Scsz8Nf3H9zLfXAyrvvUGL2cu/g5Yu9P5+887P693eh" +
           "S03ogupakQ3i6E7VtT3T0v267ui+EupaE7pNdzQqf9+EbgXPbdPRt73CbBbo" +
           "YRO6xcq7Lrj5fzBFMyAim6JbwbPpzNyDZ08J5/lz6kEQdC/4Qo9B0M57oPyz" +
           "82tZG0IaPHdtHVZUxTEdFxZ9N7M/gHUnnIK5ncNTEPVLOHAjH4Qg7PoGrIA4" +
           "mOv7LzTXhoPYQIuwNKyjRVroNG0PoATgz5fLXhZt3v/TOGlm75VkZwe44jWn" +
           "gcACa6jhWpruX1efi2rMS5+//vXdw4WxP1Mh1ABD722H3suH3gND7+VD7509" +
           "9FUpmjZtEP3MtpNVsvW+hnZ2ckXuyTTbxgPw5hLgAkDM25+Q3sq9/ZnHz4FA" +
           "9JJbMocAUvjmwE0dIUkzx0sVhDP04ieSdw1/FdmFdk8icGYN6LqUsYsZbh7i" +
           "49XTK+8suZff970ffeHjT7tHa/AEpO9Dw42c2dJ+/PS8+66qawAsj8Q/+ajy" +
           "petffvrqLnQLwAuAkaECYhrAz8OnxzixxK8dwGVmy3lg8Mz1bcXKXh1g3KVw" +
           "7rvJUU8eEHfkz3eCOb6cxfzrwFy/d38R5L/Z27u9rL1nG0CZ005ZkcPxmyTv" +
           "U3/zF/9cyqf7ALkvH9sLJT28dgwtMmGXc1y48ygG+r6uA7q//4T40Y/94H2/" +
           "mAcAoHjtWQNezVoKoARwIZjm93x19bff+fanv7V7FDQh2C6jqWWq6aGRFzOb" +
           "7ngZI8Forz/SB6CNBVZiFjVXB47taubMVKaWnkXpf11+Hfqlf/3glW0cWKDn" +
           "IIze8NMFHPX/TA1659ff9u8P52J21Gy3O5qzI7IthN59JJn0fWWd6ZG+6y8f" +
           "+s2vKJ8CYAwAMDA3eo5pUD4HUO40OLf/ybzdO/UOzZpHguPBf3J9HctKrqsf" +
           "/tYPXz384R+/lGt7Mq057uuO4l3bhlfWPJoC8fefXukNJZgDuvKL/C9dsV78" +
           "MZAoA4kqALhA8AEQpSciY5/6/K1/9yd/et/bv3kO2mWhS5araFtAAdsAiG49" +
           "mAMMS723PLX1bpK5+0puKnSD8dugeCD/dw4o+MTN8YXNspKjJfrAfwrW9N3/" +
           "8B83TEKOLGdsxqf4ZfiFTz5Ivfn7Of/REs+4H05vBGeQwR3xFj9r/9vu4xf+" +
           "bBe6VYauqPvp4VCxomzhyCAlCg5yRpBCnnh/Mr3Z7uXXDiHsNafh5diwp8Hl" +
           "aFMAzxl19nzpOJ78BHx2wPd/sm823VnHdlO9i9rf2R893No9L90Bq/V8cQ/f" +
           "QzL+t+RSHsvbq1nzc1s3ZY8/D5Z1kOelgGNmOoqVD/xUCELMUq8eSB+CPDXb" +
           "fxYWnou5F2TmeThl1u9tk7stoGVtMRexDQnspuHzC1uqfOe640hY2wV54gf+" +
           "8cPf+NBrvwN8ykHn42y+gSuPjchHWer83hc+9tCrnvvuB3KUAvAzfP/v4t/N" +
           "pLZfzuKsYbKGPTD1wcxUKc8H2koQdnJg0bXc2pcNZdE3bYC/8X5eCD9913eW" +
           "n/ze57Y53+m4PUWsP/Pcsz/Z++Bzu8cy7dfekOwe59lm27nSr96fYR967OVG" +
           "yTnYf/rC03/020+/b6vVXSfzRgYciz73V//9jb1PfPdrZ6Qot1ju/8Gx4e23" +
           "N8pBkzz4tNGJUkzUYToqRCWc0ex1jM+MHuGQEprYLaY09UODWc1xRZgQ6hQ1" +
           "YFZSuhWei/BOSStxWEWz1Y0aaGo0nyomz3TdOUcVScUpYIpLWVOZGjZrTLPC" +
           "t0J2UFtJA4qyPbK8rGI9uke1FjBVwRK8s4k2QSGsl7v6SKRDHMcdp+SIgoZj" +
           "G9zHEkfryVxkWXUX3vQmvEwM63wfFfuTuNWUzJLfaq4tb6StKnxVjBdVbIr1" +
           "BxusPRLbA5urr9LOZOQFi2E7NFdKqiztziiSOj1r3OfiziSaENhkFW3kZpQO" +
           "3BHNjnosXZmvk4RdWJ1NT3M9rKJIQd9qR4ZbLsorarnuM1KvTZd1e87W7ZFW" +
           "F3tslZgwNYLbtGrLRIPb5VU31GRfQMp9nu2PegMzKQzpPtdY8mO2JKw2kRCs" +
           "BcFBx8WISipO1RqVXQG2ik211C70p3MyKA6YUj/q06IQNIOxjDqq6zMwz/as" +
           "3ijoFLptj5JZFOSegm6JuhzYE77DTAVPriBxrTKMJvJcq2t1Rqhu+sN62tRN" +
           "rqNhA7ejhC1qVZQVp7ZE+AY91nxm4vOoDnAnDYI248GTZXuBboIIxXmpW5SK" +
           "rRbvio2lTnYbtCLXJvq66yoy6pNBp2SPwnrQxWuW3bJ6QytMmxo6b/VXojqP" +
           "a/g0YGvFImUXebHEqt3elOZDUw/t9XQdkFwf96WKj8w3k2JUmlYsozyPeGPC" +
           "dajaRtiwDdppr2xtsJHkZbE0Z6XBtLAh2qRfQ8aTRhqzuLKylEWHISuNpukO" +
           "O4ElG7XKyMCYSqlLuh2H8xajobsi+FZQ6jWYYNFc8muEKA8ketDqFUip7/vU" +
           "ZNns9+pWv8WsagV2PSs14MJkhKom1mw6rGUvXd8ZJ4W2vhTai8zm1FkaUyHR" +
           "JRrlBbRQHa0HTI2OKGOJdxZwGW4ijWqsRHHUaE5bZbODDbCNJOmWNVn7o2pc" +
           "16zqNEF0l2h0290RPS4q2LrNeVpRcRWSpjVORcp2X7XRpEqEnUYDRoQCEg14" +
           "asjFiuRrBpugFO7VBnzPHttNRV0vnY7FIYGB6IN+hyOWFZ0hvLrD1z2ck02Y" +
           "Wa6GY3bQRqLYFQAYk9RY6zJ4eTVCp2jJgFuEThHKnCOjAqXiVHNJdNXeDGPi" +
           "Msb0BEwcUBJKcYq7srmKzDf0YokJyHJ9VgtFj6mhHcJq80iRnDS5kppYLYE0" +
           "NtWEG0nE0hcdtcwWOVsXGrWIqAj0qNbuGK2ArSyldNOT4/WsChAy7gWj5pxp" +
           "pvIkYRSz2y0Ildais2kPi2u6vNF1ulG1jM66T27GA2zdSapyKheicpF2hREx" +
           "Y9G4sRrBM7HIWUtSI+GKsRYG6qbU67U4s8kj5WCpigyJYGVybHDmVCMIQhMX" +
           "g+K0rJCtVjpoBjVSqxcCo4mWPaGRwnOvoowEazXQ0ESemVhbYQWbdEbr1cRH" +
           "ZN4RSZlvqXZhw9eluTYzxnJjZRgj0euMR801w88VS+0PkRUtdlKxIejLjiLS" +
           "q3pRXk+i0moQjwlZHK8TW2zEpbljMf22mcjRqKsRcyICKaTXtvjyjHPDlW7z" +
           "YhzDcwkhYDeOkMFQYWOBk4MeF1bIkOb0tR7SUuJMK9IsHvVmUaPYW9XQvsnw" +
           "Rp/Fk1I0CLRWN4VrrpR0Jg4/5klrmK5jPmWIwrTgNuHmglbbYRkne5O0zwsa" +
           "2STiqJS5r14sEjVnUeaxlHWalMXWxAW/EMVoOoY33jRiI7+6YEirRNECT5MT" +
           "jpZ7RWodetVirYzWuwJWXWPirCB4FaSgM5zBmv1oNdVMcZMyBm8Y80i0OZ6o" +
           "EAU49FuovhCDMjZsGDhZRqVg1FuSVX9QAEib2BUcFjtkV/HIhmsqsN1RyqzI" +
           "tRbSorNcBzNCLtI+vkZhPqQNbFAXWSMUZyMq3qSLFDEWOIYS80K1u0SZxGiH" +
           "BSIZq+gcNipVrEj3vaZXWRR4Ax/hMCY4yKhiaEm4GgSdQYPuiSZptuiQgaez" +
           "loyX5sKkMJ8UtOGcJrDZcqi0+hLijvwG3lXhAt2ixw2FWJaDuhBwipFgRKfd" +
           "8M2Wiyd2H9mYKGHWSpuCv8SAbagcGWpvgkgBzaFelyuxy6Bbnvjj6SwKN1XM" +
           "n8WD4mawFJaKMuRKLdrQKKzLIZ11IIZsgOAOTJp6mZr7IW8z7mrRIiZdUotX" +
           "aaWCTNq1+VQYz8LFBp6VxDZK9Ft0R23IEU0tQKAZYrnQ7E4WpbakcEalhg46" +
           "9sqqSCWpJppttrisxP3GatYd9Cs60mcKiCzgq6oCdGk7YO8jY2rl1zYW2+3Q" +
           "gTMKN8s5okmROEZXIw8rTzVxNV7EXDRJJaWiw4WKRcAmChcSLBxSVlQtVpd1" +
           "OsFxSx6plMakBb9fGkcxK8IVVyzNDG3l8ot4rLseblSLqJGotIJKPGHx6gyG" +
           "BduFZ1a/itbLmjEi7OEEm6rO2FlsEICPE0tCUgTnV3XTX6cqX5siLRtzO7jB" +
           "KLa7XLSlFo6b5nxFarUgHagzFWORqbPCKMQwXaJqyVIZDZtdfdDVRo2wO611" +
           "ZANBC6W6s44nlpAKC6okt0hsyWrBnIXLc0OcGV3Nm7EpS5NLu5sowwEsgwHW" +
           "LBGaeCiWBUFZIlUatkW13KknA2O88qvoTG925TgqMnQRQFBETSrDNPZSfTjp" +
           "EvA6GBLtlNOjBlEkS8o6XLmNbq3IdqcYOLMkc5HvB4xSNkVhOu/5Y6TSj3zG" +
           "29DLsM1T6rozGAcsR/fX9NJWjXWd5RDKKBillrpcyzN62XZjsseySxI3BdJH" +
           "6ohleAk+6LPSWgHnbatYMh3ek6Y1J2l2x8OSGwujkjMwiBCP2/P1RItnYhPz" +
           "inpv2F4hXKtCqi0eLa40yYiqkwEWOasSRlSJ0shKw1LPQoxwEzSqIR+pCW0l" +
           "WM2uhcq0r9SpaTwaV+IV3oKjGBbTAO6HZEBp2bYgOORcBZAmdoeaQeKCLoF9" +
           "pR7POanRVbp4BIfjxawUbWYzU2tZQcyOqsqoj4RjpwS7VqqW/GWtESwwrrIi" +
           "R4HQDJRhKzDKscJIU97GhWVvytbNUo1BWlyXHyyVKYNgE9DvUK2QqkstkaKJ" +
           "sr/aeH2p1ZAIZ9YblQqmX6pRi5giEsLlI6VNGeKaN2YtsGwTnW8WNzWKgtcg" +
           "9zPwVhEVpUSHmThO55OK0hks6h1HoCogS9RWUyYm6rNGKaWmDj+p9uGELTfg" +
           "WaED1+ZIw2HDJC3PcVar6pEb0o1Co4MqvT5Tns7XfVntyMlAmOiin8qpw4lN" +
           "g45adE1OTTMswLI/gfG0nKqzMZyE1bg5lMx5FyT/b3pTdix46ys7md2ZH0IP" +
           "rxvAgSx70XgFJ5L07AF3Q+g2z3dDcGrXtXzco7JWXtG456BwffB7vKx1VOvY" +
           "OTgOv+XMYi6ThroTmFNLv7GWe7KGm53lHrrZXUV+jvv0u597XhM+g+7u15rG" +
           "4Oi+f4V0XB8fevLmB9ZOfk9zVAD5yrv/5cH+m+dvfwVl3UdOKXla5O90Xvha" +
           "/fXqR3ahc4flkBtukE4yXTtZBLnk62HkO/0TpZCHDt1zf+aNh4Cpz+6759mz" +
           "S6tn+n0nD7RteJ2q4+1uAyMPsAOv3pN5NSmpuTNpV40yj+XcyctUAd+RNT5w" +
           "j+rrSqgfCLv7uLB97x8FcfDTjtUnym0hdN/ZdwEHg6Gv+HIBRM4DN1xpbq/h" +
           "1M8/f/ni/c8P/jqvox9eld3Whi7OwEH5eAHr2PMFz9dnZj4jt23LWV7+894Q" +
           "evDm2oXQ+fw3N+Q9W47373viNEcInQPtccpfD6ErpymBxPz3ON2HQujSER1w" +
           "1fbhOMlHgHRAkj1+1Duj6rWt+aU7x1bfPtrk/rzrp/nzkOV4ST5bsfn188Hq" +
           "irYX0NfVLzzP8e94qfKZ7ZWAaimbTSblYhu6dXs7cbhCH7uptANZFxpP/PiO" +
           "L972ugMouWOr8NG6OabbI2fX3xnbC/OK+eYP7//9N/7W89/Oi3D/C5L9vOYX" +
           "IAAA");
    }
    protected static class SubImageRefElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SubImageRefElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSubImageRefElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "b/P9z/FX9nj8v1LEzo2QFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/S+n5ww+HSAAAA==");
    }
    protected static org.apache.batik.dom.util.HashTable
      xblFactories =
      new org.apache.batik.dom.util.HashTable(
      );
    static { xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_XBL_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLXBLElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_DEFINITION_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLDefinitionElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_TEMPLATE_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLTemplateElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_CONTENT_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLContentElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_HANDLER_GROUP_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLHandlerGroupElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_IMPORT_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLImportElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_SHADOW_TREE_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLShadowTreeElementFactory(
                                )); }
    protected static class XBLXBLElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLXBLElementFactory() { super(
                                          );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMXBLElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "vvNfzQRUKIYUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "i6Db/cCLwG1dU/N1d+WsvJJx7+my9fFy1q7GcebwGvzGm5ZwW2mkuaEp29qN" +
           "FdyTtdvsDvfwrV4o8vvbp9757HMq9+nS3kGNaQKu7AcPR8f5CaCnb31RZfPX" +
           "mV3h4yvv/JeHRm8w3voyyrmPnmLyNMnfYZ//Wvs1yof3oLNHZZAb3o1OIl07" +
           "Wfy4FGhRHLijEyWQh4/U80CmjYeBqF8+UM+Xb15Svanez+SGtjWvU/W7va1h" +
           "5AZ2qNV7M62uykquTMJT4kxjOfbqJap/b8uaAKhHCTQp0g6J3XOc2IH2d0Yc" +
           "/rTr9IkyG2DtZi8Ah0uVXvaDArCbB294xtw+vSmfe+7yxQeeG/91Xj0/eh67" +
           "nYEu6rFtHy9bHetf8ANNN/P9uH1bxPLzr3dH0EO35i6CzuffuSDv2mK870AP" +
           "pzEi6Cxoj0P+egRdOQ0JKObfx+E+GEGXdnBAUdvOcZAPA+oAJOt+xL9JrWtb" +
           "6UvPHPO9g1iTa/Pun6bNI5TjhfjMX/Mn50PfirePzteVzz/X7b3txdqntw8B" +
           "CjgqNxmViwx02/ZN4sg/H78ltUNaF6infnznF25/9WEguXPL8M5rjvH26M2r" +
           "7i3Hj/I6+eYPH/j91/3Wc9/OS2//CyHmvwYLIAAA");
    }
    protected static class XBLDefinitionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLDefinitionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMDefinitionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "mtj/rHjFx9f/C7y/H3KUFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "YSEgAAA=");
    }
    protected static class XBLTemplateElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLTemplateElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMTemplateElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fpfvf4a/ssf3/gsDchCykBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "r8X9L/OZ9+whIAAA");
    }
    protected static class XBLContentElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLContentElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMContentElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "r/L9z/JX9nj8v7D8KWyOFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "B3AMi8l10a76YsnjYRtra9MUnopxLcRmzQLONDSeXyRhHw31oc42kV4zsVQh" +
           "KsA6uyTFOqqrFDPw22onYkJmQTl4MIHtzho2RJNDFoleihr8CEf9cM0Nei1s" +
           "ZI6cyG2oY4Fn0/VapJfAtmilizrFYGLGIdvgk42CDw1R4aMWRtTDyZBhpKUM" +
           "r4tdY0OuzXlHJq2OX7Rta6MzoznjTWeKniZNNpkvywQllteomHLLGWf0qimZ" +
           "RAWBZhN+imr9QVrvhfFgOaHGqRyt+6yrla22mHpMhEvlaB22Oz29SPeW9rpL" +
           "xo3aVIsXkV8aj2UPM3x1JA2SYqOr16jVFHhij5YnAMBH3VrZaPQpoaHaoliD" +
           "LX8yIKPumqw1FxNpafr2yhITvg2nne6oT88ZqTnu6qisK+v5vI/WR5NiydOH" +
           "fkSO+gFVgoPCKujy5ZqGMu2g5gxGpginlTLWHEwxazCbt42mR1WoWizVkx5f" +
           "VEvTdNEf1GI6XrBkH1YJN6hihI8hUWNIp/GM7Qq8N1pMbGa6wPBVgNpST1F6" +
           "6nrWEOfGcpMWO3MpZTsROi/O2I5V7yooZTnFhFhgcUvDBa1frSzGZcYTB+x4" +
           "U5ScUq3ZIiRm0EMnvUlNbQtm0jVBXNCeE1t8qzSU+hxucEshFDyBnFtUuuyI" +
           "1gge08iagEmzwRjA6Zekgk55ulcmzInDrRKlazRrU4TpKiQ1hU3e0Eo1JBzO" +
           "KbM0W1cWEtlVxiPcb7rsjJckyqpztLuRFlWmBrtup2es2Tapz8e2ROrtriwP" +
           "5VF7g8zJqmNg5QkQodJSVEG6lfFswQ0MfgRPOYqT4Ck47lUaIS7VZuYIhJc3" +
           "7PQBP+cYHhk0hxV97Cp8KpJlB693jdksMFUv1vtSvTCdVLQS6rZmXFjGLVtT" +
           "1ZhMvbXLtVJPaVa6gkNPK5TnU3CTKmPKgmqbpFqp1Lr9Lt6LYSnmcWEjtCq9" +
           "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" +
           "r+OoGyAAAA==");
    }
    protected static class XBLHandlerGroupElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLHandlerGroupElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMHandlerGroupElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "To3Fr18T+58Vr/h47L8yxZBzmBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fLOzj2HZmX1vt+yTgXY36HMcJ3bShULiR+LE" +
           "jpPYcRK3MDj2jeP4GT8SJ3RbQOJVKkCwUCrB/gVqi5ZHq6JWqqi2qlpAoEpU" +
           "qC+pgKpKpaVIrFpoKW3ptfO9Z2bRqlIj5cbxPefcc+4553fvPfe57yIXohAp" +
           "BL6zMR0/3gdpvL9wKvvxJgDRfpuv9LQwAgblaFEkw3dX9cc/d+kHP/rA/PIe" +
           "crOK3K15nh9rseV70QBEvrMCBo9cOn7LOMCNYuQyv9BWGprEloPyVhQ/xSMv" +
           "O8EaI1f4QxVQqAIKVUBzFdD6MRVkejnwEpfKODQvjpbILyPneOTmQM/Ui5HH" +
           "TgsJtFBzD8T0cgughFuz/wo0KmdOQ+TRI9t3Nl9j8IcL6DO//qbLv3seuaQi" +
           "lyxPytTRoRIxHERFbneBOwVhVDcMYKjInR4AhgRCS3Osba63itwVWaanxUkI" +
           "jiYpe5kEIMzHPJ652/XMtjDRYz88Mm9mAcc4/Hdh5mgmtPW+Y1t3FrLZe2jg" +
           "RQsqFs40HRyy3GRbnhEjj5zlOLLxSgcSQNZbXBDP/aOhbvI0+AK5a+c7R/NM" +
           "VIpDyzMh6QU/gaPEyIM3FJrNdaDptmaCqzHywFm63q4LUt2WT0TGEiP3niXL" +
           "JUEvPXjGSyf8893ua9/3Fq/l7eU6G0B3Mv1vhUwPn2EagBkIgaeDHePtT/If" +
           "0e77wrv3EAQS33uGeEfz+7/0whte8/DzX9rR/PR1aMTpAujxVf0T0zu+9grq" +
           "idr5TI1bAz+yMuefsjwP/95Bz1NpADPvviOJWef+Yefzgz+bvPVT4Dt7yEUO" +
           "uVn3ncSFcXSn7ruB5YCwCTwQajEwOOQ24BlU3s8ht8Bn3vLA7q04m0Ug5pCb" +
           "nPzVzX7+H07RDIrIpugW+Gx5M//wOdDief6cBgiC3Au/yKsQ5Ny/Ifnn3L9m" +
           "bYwY6Nx3Aarpmmd5PtoL/cz+CAVePIVzO0enMOptNPKTEIYg6ocmqsE4mIOD" +
           "DsN30WhlYiVUUppYiRYFzg0gSkD+PF32s2gL/p/GSTN7L6/PnYOueMVZIHBg" +
           "DrV8xwDhVf2ZpMG88JmrX9k7SoyDmYoREQ69vxt6Px96Hw69nw+9f/2hr4wb" +
           "fEvzjMyToZ8EzK6P1bK03yDnzuX63JMpuAsL6FQbwgMEztufkN7YfvO7Hz8P" +
           "4zFY35T5BZKiN8Zv6hhQuBw2dRjVyPMfXb9N+ZXiHrJ3Gogzo+Crixl7L4PP" +
           "I5i8cjYBryf30ru+/YPPfuRp/zgVTyH7AUJcy5ll+ONnpz/0dWBAzDwW/+Sj" +
           "2uevfuHpK3vITRA2IFTGGgxtiEIPnx3jVKY/dYiamS0XoMEzP3Q1J+s6hLqL" +
           "8Tz018dv8ri4I3++E87xpSz0XwPn+vsHuZD/Zr13B1l7zy6OMqedsSJH5ddJ" +
           "wcf/+s//Cc+n+xDAL51YEiUQP3UCNDJhl3J4uPM4BuQQAEj3dx/tfejD333X" +
           "L+QBACleeb0Br2QtBcECuhBO8zu+tPybb37jE1/fOw6aGK6aydSx9PTIyFsz" +
           "m+54ESPhaK8+1geCjgMTMouaK0PP9Q1rZmlTB2RR+l+XXoV9/l/ed3kXBw58" +
           "cxhGr/nJAo7f/1QDeetX3vTvD+dizunZonc8Z8dkOyS9+1hyPQy1TaZH+ra/" +
           "eOg3vqh9HGIyxMHI2oIc2pB8DpDcaWhu/5N5u3+mD8uaR6KTwX86v05sTq7q" +
           "H/j6916ufO+PXsi1Pb27OelrQQue2oVX1jyaQvH3n830lhbNIV35+e4vXnae" +
           "/xGUqEKJOsS5SAwhHqWnIuOA+sItf/vHf3Lfm792HtljkYuOrxk7QIGrAYxu" +
           "EM0hlKXB69+w8+46c/fl3FTkGuN3QfFA/u88VPCJG+MLm21OjlP0gf8Unenb" +
           "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" +
           "fiOvyf0vs82OBS0gAAA=");
    }
    protected static class XBLImportElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLImportElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMImportElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/soeX/8vv7+AHYwUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class XBLShadowTreeElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLShadowTreeElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMShadowTreeElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/Y7Y/6x4xccT/wUliP4+lBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
    }
    protected static final org.w3c.dom.DOMImplementation
      DOM_IMPLEMENTATION =
      new org.apache.batik.dom.svg12.SVG12DOMImplementation(
      );
    public static org.w3c.dom.DOMImplementation getDOMImplementation() {
        return DOM_IMPLEMENTATION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8Ed8Wvd/gXiucL4lAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4WPWjhesRVt53RB+4TCEv/lthjAvfjkv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fiUvfv3WWOU/P5UXn77A+V8ohP16XvyjC9z02xe0/U5efDEvXtlpcgHt7ya7" +
       "75+5gOb38uJDQemq7KlioB6NnUO3P/M6uHiCuphvf+r1TmdOKrDzzFEyvDWv" +
       "fBp8bh4kw83vzARxx/E6olgeSIfGPXrq1PNgRsiBtRDz5TNiTobzFmZy0k9k" +
       "1c3n4IL5X+TFl4LSAzu/np1u3npez8de/OdvwosPH3rRPfCi+x314u0T4+Q0" +
       "e2jSsc8Lmf/xgkz8s7z4ylEm9nfnz1PmCAVPuuyg9dhjr70Jjz2ZV+bLvI8e" +
       "eOyj3xmPnbTuf1zQ9hd58d+C0mOnc6UfgYIJXReg2qETKud6Xc0p/f3bMhYe" +
       "+u9vwkOP5pXPgs+nDzz06e+Mh84MqacuzKmpoxQD89Kl2/vy0uW88q+C0kMH" +
       "WXSOD999kQ/P991fvwnf5SveUgtMEdd3vLvvb9N3xxNR7/VS7NKDF7Q9nBf3" +
       "AdxZqcG51zuWR8Zeuv+NGJsEpUfOv06a34179JZb7Lub1/LnXrx699tf5P7V" +
       "bt16eDv6HqJ0txaa5smrTCeer7iequmFH+7ZXWxyC+MeA0Pn9rddweqk+M5V" +
       "v/RdO47HDxD4LAdYjoHyJOWTQenaWUogsfg+SXc9KN17TAdWfLuHkyTvAtIB" +
       "Sf74Pe7FuxWgcH5J9xafJpdO7z6PEvSh14vZiQ3r9VO7keLfEQ63hOHuHxJu" +
       "yp9/cTT90W8in9rdHJVNMctyKXeDjcPuEuvRtvKp20o7lHUFe8+3HnjlnmcO" +
       "t8AP7BQ+zvoTur3z/GuafcsNiouV2W++/Qs/8OkXv1Jcufm/EDCPhycyAAA=");
}
