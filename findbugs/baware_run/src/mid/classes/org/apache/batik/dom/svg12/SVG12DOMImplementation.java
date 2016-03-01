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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYfWwUxxWfO39gO8ZnG2xTCAbcAwmH3tYhCWpNS8DYYHrG" +
           "J5tQ1TQ55nbnfIv3dofdWfvsNCVEaqCtFEWBpLQS/ouoakQ+FDVq/glyVKlJ" +
           "lKYRNGrzoeZDlaJ+IYV/Qiv69WZm93Zv70yav2ppZ/dm3ryZ995vfu+NL15F" +
           "DY6N+ig2NZxi85Q4qQz/zmDbIdqQgR3nEPRm1R98dObE9d82n4yjxinUVsDO" +
           "mIodMqITQ3Om0HrddBg2VeIcJETjMzI2cYg9i5lumVOoS3dGi9TQVZ2NWRrh" +
           "AoexnUYdmDFbz7mMjHoKGNqQFrtRxG6U3VGBwTRqVS06H0xYWzFhKDTGZYvB" +
           "eg5D7eljeBYrLtMNJa07bLBko9uoZcxPGxZLkRJLHTPu9BxxIH1nlRv6nkt8" +
           "euPRQrtwwypsmhYTJjoTxLGMWaKlUSLoHTZI0TmOvovq0uiWkDBDybS/qAKL" +
           "KrCob28gBbtfSUy3OGQJc5ivqZGqfEMMbapUQrGNi56ajNgzaGhinu1iMli7" +
           "sWytH+6IiY/fppz90X3tz9ehxBRK6OYk344Km2CwyBQ4lBRzxHZ2axrRplCH" +
           "CQGfJLaODX3Bi3ano0+bmLkAAd8tvNOlxBZrBr6CSIJttqsyyy6blxeg8n41" +
           "5A08DbZ2B7ZKC0d4PxjYosPG7DwG7HlT6md0UxM4qpxRtjH5DRCAqSuKhBWs" +
           "8lL1JoYO1CkhYmBzWpkE8JnTINpgAQRtgbVllHJfU6zO4GmSZWhNVC4jh0Cq" +
           "WTiCT2GoKyomNEGU1kaiFIrP1YM7H7nf3G/GUQz2rBHV4Pu/BSb1RiZNkDyx" +
           "CZwDObG1P/0E7n7pdBwhEO6KCEuZX3zn2t3bepdelTLrasiM544RlWXVC7m2" +
           "y7cObf1KHd9GE7UcnQe/wnJxyjLeyGCJAtN0lzXywZQ/uDTxq289+BT5axy1" +
           "jKJG1TLcIuCoQ7WKVDeIvY+YxMaMaKOomZjakBgfRSvgO62bRPaO5/MOYaOo" +
           "3hBdjZb4DS7Kgwruohb41s285X9TzAriu0QRQl3woE3wfIjk3we8YchWClaR" +
           "KFjFpm5aSsa2uP08oIJziAPfGoxSS8kB/me+NJDaoTiWawMgFcueVjCgokDk" +
           "oKJZRcWZnR64XZk8vG/g9r3jY5wXSZGY8tCnOPbo/2XVEvfFqrlYDMJ0a5Qk" +
           "DDhf+y1DI3ZWPevuGb72TPZ1CUB+aDwvMrQPlk7JpVNi6RQsnRJLp2ovnRwx" +
           "rLm9+uyw7BvBnArmUSwm9rGab0xCBQI9A5QBnN26dfLeA0dP99UBRulcPUSJ" +
           "i26pymFDAbf4CSGrXrw8cf3NN1qeiqM40E8OcliQSJIViUTmQdtSiQZMtlxK" +
           "8WlVWT6J1NwHWjo3d/LwiS+LfYRzA1fYALTGp2c4o5eXSEY5oZbexKk/ffrs" +
           "Ew9YATtUJBs/R1bN5KTTF4161Pis2r8Rv5B96YFkHNUDkwF7MwynDYixN7pG" +
           "BfkM+kTObWkCg/OWXcQGH/LZt4UVbGsu6BFw7BDfqyHECX4ak/B85B1P8eaj" +
           "3ZS3PRK+HDMRK0Si+NokPf/2b/68XbjbzymJUDEwSdhgiMe4sk7BWB0BBA/Z" +
           "hIDcH85lzjx+9dQRgT+Q+GKtBZO8HQL+ghCCm7/36vF3Pnj/wlvxALMMErmb" +
           "g5qoVDayidvUdhMjOc6D/QAPGsAKHDXJe0xApZ7Xcc4g/JD8M7F54IW/PdIu" +
           "cWBAjw+jbZ+tIOj/wh704Ov3Xe8VamIqz8OBzwIxSe6rAs27bRvP832UTl5Z" +
           "/+NX8HlIE0DNjr5ABNsi4QMkgnaHsF8R7fbI2F28STph8Feer1C9lFUffeuT" +
           "lYc/uXRN7Lay4ArHegzTQQkv3mwugfqeKNHsx04B5O5YOvjtdmPpBmicAo0q" +
           "0KszbgMNliqQ4Uk3rHj35V92H71ch+IjqMWwsCb5DBIUoJs4BWDQEt11twzu" +
           "HA93uzAVVRnP/bmhdqSGi5QJ3y682PPznT9dfF+ASqJonTdd/Ngi2q282Sb6" +
           "4ww1U9tioIlAhdToiNIuwJ+Yu9rPff47jL9gjZj4XsPQrpqcP1xixHR0AFM1" +
           "5VdyPXf/+uXKHVGqXXjo7KI2/uSALEo6K0uIYaiQn/7dv36dOvfhazUyUqNX" +
           "roY3bqNNVcliTJSCAdHtuHK97r3H1rRW5wmuqXeZLNC/fBaILvDKQ39Ze+jr" +
           "haOfIwFsiHgpqvJnYxdf27dFfSwuqlnJ/VVVcOWkwbC/YFGbQNlucrN4z0px" +
           "SvrK+OjhcFgPz8cePj6uTcICfLzpr6a25aZGSCAuAeuDrF0cBV6Tp2RN7g+s" +
           "5uib264K0O21VJcjS2zjmzehlXt5MwHoUG0CdaWvbFVYmYdSMbaDN5PyoHz1" +
           "fzu/vGNXCUr8mgWOv+LA5y6YAL1rqq5w8tqhPrOYaOpZvOf3IjuXrwatkNfy" +
           "rmGE4hyOeSO1SV4XbmmVrEjFqwC3neV3x1CDeAtDpuWMGS8c0RkM1UEbloR7" +
           "QntUEjSKd1juOEMtgRzES36ERRhoBxH+6dIacJH3lVKsmh5FULs+K6jlKeFE" +
           "z0+3uG77J9GVF+6s+uzigYP3X7vrSVlowEV9YUFcz+C2KWue8mnetKw2X1fj" +
           "/q032p5r3hz3UNshNxycsXUhSO8CZqM8a6yNZGEnWU7G71zYeemN041XgCeP" +
           "oBgGwB8JXXalpyCVu0A1R9Jhigz900YUCIMtfzz65t/fjXWK1OORau/NZmTV" +
           "M5fey+Qp/UkcNY+iBqB1UpqC27uzd96cIOosJMkm19SPu2RUA1DmLNcs38zb" +
           "OJQxP/bCM55DV5Z7eaHKUF/VnbtG8Q5ZeY7Ye7h2wXAR/nMpDY+W+I21hlUQ" +
           "m4Hz/zjx8NvjcNQqNh7WtsJxc2UqDV/8A25tlwT5H/iLwfNv/vCQ8g55/+wc" +
           "8i7BG8u3YEpLcqwumx6j1JNt2CxgQKmgnh8Kxad48/0Sl2Ao1k/pfwGFukEU" +
           "8RMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "11YS6W5oKY5+fe31ZM01u3s9dLP3Dvm965PvfPY5jf1Uce+gNjQBV+2D10HH" +
           "1xNAT978gtnL37nsChZfeuc/Pzh6o/mWl1GGfeTUIk+L/O3e818hX6t+aA86" +
           "e1S+uO5t0EmmqyeLFhcDPVoF7uhE6eKhI/Pcn1njIfD9wYF5fnDjUugN7X4m" +
           "d7Ste52qu+1tHSN3sEOr3pNZNcbU3JhNT11lFsu545eo2r01awJgHjXQ5Ug/" +
           "FHb3cWEH1t85cfiTrsEnymMRdN+Na/eHkxVf9ssA4DkPXPd6cvtKTf3sc5cu" +
           "3P/c+K/yuvfRa6/bGOiCsXKc4wWnY/3zfqAbVr4jt23LT37+8+4IevDmq4ug" +
           "c/lvrsi7thy/cmCJ0xwRdBa0xyl/LYIun6YEEvPf43QfiKCLOzpgqm3nOMmH" +
           "gHRAknU/7N+gSrWt0SVnjkXfAdrk9rzrJ9nziOV4CT2L2PxV8mF0rbYvk6+p" +
           "n3uO7r/1xfKntiV81ZHTNJNygYFu3b5NOIrQx24q7VDW+c4TP7rj87e95hBK" +
           "7tgueBc3x9b2yI3r5a2FH+UV7vT37//d1//mc9/Mi2b/C6rWiBvjHwAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "8xMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+l+ILVNfARQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+W/ndbT/BddG+WD9HwAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYfWwUxxWfO39gO8ZfYJvyYcA9qHDobR2SoNa0DhgbTM/4" +
           "ZBOqmibH3O6cb/He7rA7a5+dpoRIKbSVoiiQhFTCfxFVjWgSVY3af4JcVWoS" +
           "pWkEjdp8qGmr/tMvpPBPaEW/3szs3u7t3ZHmr1q6ubmZN2/mvfeb33vjy9dR" +
           "g2OjfopNDSfZIiVOMs37aWw7RBsxsOMcgdGM+u0/nDt181fNp+OocQa15bEz" +
           "oWKHjOnE0JwZtEk3HYZNlTiHCdH4irRNHGLPY6Zb5gzq1p3xAjV0VWcTlka4" +
           "wFFsp1AnZszWsy4j454ChjanxGkUcRplb1RgKIVaVYsuBgvWly0YCc1x2UKw" +
           "n8NQR+oEnseKy3RDSekOGyra6E5qGYuzhsWSpMiSJ4x7PEccSt1T4Yb+l9o/" +
           "uvVEvkO4YQ02TYsJE50p4ljGPNFSqD0YHTVIwTmJvoHqUuiOkDBDiZS/qQKb" +
           "KrCpb28gBadfTUy3MGIJc5ivqZGq/EAMbS1XQrGNC56atDgzaGhinu1iMVi7" +
           "pWStH+6IiU/dqZx/5sGOH9ah9hnUrpvT/DgqHILBJjPgUFLIEtvZq2lEm0Gd" +
           "JgR8mtg6NvQlL9pdjj5rYuYCBHy38EGXElvsGfgKIgm22a7KLLtkXk6AyvvV" +
           "kDPwLNjaE9gqLRzj42Bgiw4Hs3MYsOctqZ/TTU3gqHxFycbEl0EAlq4qEJa3" +
           "SlvVmxgGUJeEiIHNWWUawGfOgmiDBRC0BdZqKOW+plidw7Mkw9C6qFxaToFU" +
           "s3AEX8JQd1RMaIIorY9EKRSf64f3PP6QedCMoxicWSOqwc9/ByzqiyyaIjli" +
           "E7gHcmHrQOpp3PPK2ThCINwdEZYyP/76jft29q28JmU2VJGZzJ4gKsuol7Jt" +
           "VzeO7Ph8HT9GE7UcnQe/zHJxy9LezFCRAtP0lDTyyaQ/uTL1868+8jz5axy1" +
           "jKNG1TLcAuCoU7UKVDeIfYCYxMaMaOOomZjaiJgfR6ugn9JNIkcnczmHsHFU" +
           "b4ihRkv8BhflQAV3UQv0dTNn+X2KWV70ixQh1A0ftBWh2EYk/mIbeMuQreSt" +
           "AlGwik3dtJS0bXH7eUAF5xAH+hrMUkvJAv7nPjuY3K04lmsDIBXLnlUwoCJP" +
           "5KSiWQXFmZ8dvEuZPnpg8K79kxOcF0mBmPLSJzn26P9l1yL3xZqFWAzCtDFK" +
           "Egbcr4OWoRE7o553943eeCHzhgQgvzSeFxk6BFsn5dZJsXUStk6KrZPVt06M" +
           "GdbCFJn12BKGxzBng0UUi4mjrOVnk2iBWM8BawBtt+6YfuDQ8bP9dQBTulDP" +
           "wwWi2yvS2EhAL35OyKiXr07dfOvNlufjKA4MlIU0FuSSRFkukanQtlSiAZnV" +
           "yio+syq180jVc6CVCwunj576nDhHOD1whQ3AbHx5mpN6aYtElBaq6W0/86eP" +
           "Xnz6YSsgiLJ846fJipWcd/qjgY8an1EHtuCXM688nIijeiAzIHCG4cIBN/ZF" +
           "9yjjnyGfy7ktTWBwzrIL2OBTPgG3sLxtLQQjApGdor8WQtzOL+RnINSbvBsq" +
           "vvlsD+Vtr0Qwx0zECpErvjhNL77zyz/vEu7200p7qB6YJmwoRGVcWZcgrc4A" +
           "gkdsQkDutxfS5566fuaYwB9IfLrahgnejgCFQQjBzY+9dvLd331w6e14gFkG" +
           "udzNQllULBnZxG1qu42RHOfBeYAKDSAGjprE/SagUs/pOGsQfkn+2b5t8OW/" +
           "Pd4hcWDAiA+jnR+vIBj/1D70yBsP3uwTamIqT8WBzwIxye9rAs17bRsv8nMU" +
           "T1/b9Oyr+CJkCmBnR18ignCR8AESQbtb2K+Idldk7l7eJJww+MvvV6hkyqhP" +
           "vP3h6qMfXrkhTltec4VjPYHpkIQXb7YVQX1vlGgOYicPcnevHP5ah7FyCzTO" +
           "gEYVGNaZtIEJi2XI8KQbVr3305/1HL9ah+JjqMWwsCb5DHIUoJs4eSDRIh2+" +
           "T0Z3gYe7Q5iKKozn/txcPVKjBcqEb5d+0vujPd9b/kCASqJog7dc/Ngu2h28" +
           "2SnG4ww1U9tioIlAkdToiOouwJ9Yu9ZPf/53GH/BHjHRX8fQcFXaHy0yYjo6" +
           "gKmS9cu5nrt/U62KR1Rrlx49v6xNPjco65Ku8ipiFIrkH/z6X79IXvj961WS" +
           "UqNXsYYPbqOtFcliQlSDAdHtvnaz7v0n17VW5gmuqa9GFhionQWiG7z66F/W" +
           "H/lS/vgnSACbI16Kqvz+xOXXD2xXn4yLglZyf0UhXL5oKOwv2NQmULmb3Cw+" +
           "slrckv4SPno5HICTYv0ePvqrk7AAH28GKqmt1tIICcQlYH2QdYirwMvypCzL" +
           "/Ym1HH0Lu1QBuv2W6nJkiWN85Ta08gBvpgAdqk2gtPSVrQkr81Aq5nbzZlpe" +
           "lC/8b/eXDwwXoSSuVeP4mw5+4rIJALyu4iEnHx/qC8vtTb3L9/9GJOjSA6EV" +
           "UlvONYxQqMNhb6Q2yenCM62SGKn4ysObp/bpGGoQ38KQWblizotIdAVDddCG" +
           "JeG10BGVBI3iOyx3kqGWQA5CJjthEQbaQYR3XVoFMfLVUoxVMqSIa/fHxbW0" +
           "JJzr+QUXj27/Mrry2Z1RX1w+dPihG/c+J2sNeK4vLYlHGrw5ZdlTutBba2rz" +
           "dTUe3HGr7aXmbXEPuJ3ywME12xBC9TBcK8oTx/pIInYSpXz87qU9V94823gN" +
           "qPIYimHA/LHQk1d6CrK5C2xzLBVmydC/bkSNMNTyx+Nv/f29WJfIPh6v9t1u" +
           "RUY9d+X9dI7S78ZR8zhqAGYnxRl4wzv7F80pos5DnmxyTf2kS8Y1AGXWcs3S" +
           "+7yNQxnzmy884zl0dWmU16oM9Ve8vKvU75CYF4i9j2sXJBehQJfS8GyRv1ur" +
           "WAWxGbz4j1PffGcSrlrZwcPaVjlutsSm4ed/QK8dkiP/A38x+Pybf3hI+YB8" +
           "hXaNeE/hLaW3MKVFOVeXSU1Q6sk2iFw/TKlgn+8IxWd4860il2AoNkDpfwGV" +
           "Zdtm9xMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "0v8C3kvWbwUUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZe6zjaHX33NmZnR2Wndn3dss+GWh3Q69j593hsU7iPG3H" +
           "sR07SQuD33biV/yIHdMtDwl2WypAsFAqwf4FaouWh6qiVqqotqpaQKBKVKgv" +
           "qYCqSqWlSOwfpVVpSz87997ce2dmV6v+0Uj54vg753znfOecn893/MIPoXOB" +
           "DxU819rolhvuq0m4v7Aq++HGU4P9AVGhRT9QlZYlBgEH7l2TH//SpR//5CPG" +
           "5T3o/By6W3QcNxRD03UCRg1ca60qBHRpdxe3VDsIocvEQlyLcBSaFkyYQXiV" +
           "gF5zjDWErhCHKsBABRioAOcqwNiOCjC9VnUiu5VxiE4YrKBfhc4Q0HlPztQL" +
           "ocdOCvFEX7QPxNC5BUDChew/D4zKmRMfevTI9q3N1xn88QL83G++4/LvnYUu" +
           "zaFLpsNm6shAiRAsModut1VbUv0AUxRVmUN3OqqqsKpvipaZ5nrPobsCU3fE" +
           "MPLVo03Kbkae6udr7nbudjmzzY/k0PWPzNNM1VIO/53TLFEHtt63s3VrYSe7" +
           "Dwy8aALFfE2U1UOWW5amo4TQI6c5jmy8MgQEgPVWWw0N92ipWxwR3IDu2vrO" +
           "Eh0dZkPfdHRAes6NwCoh9OBNhWZ77YnyUtTVayH0wGk6ejsFqG7LNyJjCaF7" +
           "T5PlkoCXHjzlpWP++SH15g+9y+k5e7nOiipbmf4XANPDp5gYVVN91ZHVLePt" +
           "TxKfEO/7yrN7EASI7z1FvKX5g1956ak3Pfzi17Y0P3sDmpG0UOXwmvwZ6Y5v" +
           "va71RONspsYFzw3MzPknLM/Dnz6YuZp4IPPuO5KYTe4fTr7I/PnsPZ9Tf7AH" +
           "XexD52XXimwQR3fKru2Zlup3VUf1xVBV+tBtqqO08vk+dCu4JkxH3d4daVqg" +
           "hn3oFiu/dd7N/4Mt0oCIbItuBdemo7mH154YGvl14kEQdC/4Qo9B0JkClH/O" +
           "PJmNIeTDhmursCiLjum4MO27mf2ZQx1FhEM1ANcKmPVcWALxv/wFZL8GB27k" +
           "g4CEXV+HRRAVhrqdhBXXhoO1jqAwy3cRtD0i+7YHMEN1tkm/n8We9/+yapLt" +
           "xeX4zBngptedBgkL5FfPtRTVvyY/FzXxl75w7Rt7R0lzsIshNAZL72+X3s+X" +
           "3gdL7+dL79946Ssdy40ZVc+wM5GtSFHx7WxHzEBhA505k2t0T6biNmiAy5cA" +
           "PACs3v4E+/bBO599/CyIVi++JfMaIIVvju6tHdz0c1CVQcxDL34yfi//7uIe" +
           "tHcSpjOzwK2LGTudgesRiF45nZ43knvpme//+IufeNrdJeoJ3D/Aj+s5s/x/" +
           "/LQDfFdWFYCoO/FPPip++dpXnr6yB90CQAUAaSiCwAcY9fDpNU7gwNVDTM1s" +
           "OQcM1lzfFq1s6hAIL4aG78a7O3lk3JFf3wn2+FKWGPtgr990kCn5bzZ7t5eN" +
           "92wjKXPaKStyzH4L6336b/7in0v5dh/C+6VjD0xWDa8eg5RM2KUcPO7cxQDn" +
           "qyqg+/tP0h/7+A+f+aU8AADF62+04JVsbAEoAS4E2/z+r63+9rvf+cy393ZB" +
           "E4JnaiRZppwcGXkhs+mOlzESrPbGnT4AkiyQoFnUXJk4tquYmilKlppF6X9d" +
           "egPy5X/90OVtHFjgzmEYvemVBezu/0wTes833vHvD+dizsjZI3G3ZzuyLc7e" +
           "vZOM+b64yfRI3vuXD/3WV8VPA8QGKBmYqZoDH5TvAZQ7Dc7tfzIf90/NIdnw" +
           "SHA8+E/m17HS5Zr8kW//6LX8j/74pVzbk7XPcV+Tond1G17Z8GgCxN9/OtN7" +
           "YmAAuvKL1C9ftl78CZA4BxJlgHTByAeIlJyIjAPqc7f+3Z/86X3v/NZZaK8D" +
           "XbRcUdkCCnhWgOhWAwOAWeK97amtd+PM3ZdzU6HrjN8GxQP5v7NAwSduji+d" +
           "rHTZpegD/zmypPf9w39ctwk5stzgiX2Kfw6/8KkHW2/9Qc6/S/GM++HkepQG" +
           "Zd6OF/2c/W97j5//sz3o1jl0WT6oIXnRirLEmYO6KTgsLEGdeWL+ZA20feBf" +
           "PYKw152Gl2PLngaX3dMBXGfU2fXF43jyU/A5A77/k32z7c5ubJ+8d7UOHv+P" +
           "Hj3/PS85A7L1HLpf2y9m/G/LpTyWj1ey4ee2bsoufx6kdZAXr4BDMx3Ryhd+" +
           "KgQhZslXDqXzoJjNHkQLq5aLuReU73k4ZdbvbyvALaBlI5qL2IZE5abh84tb" +
           "qvzJdcdOGOGCYvKD//iRb3749d8FPh1A59bZfgNXHluRirL6+gMvfPyh1zz3" +
           "vQ/mKAXgh/4EfvmpTCrxchZnA54NnUNTH8xMZfPCgBCDkMyBRVVya182lGnf" +
           "tAH+rg+KR/jpu767/NT3P78tDE/H7Sli9dnnfv2n+x96bu9YOf766yri4zzb" +
           "kjxX+rUHO+xDj73cKjlH55+++PQf/c7Tz2y1uutkcYmDs9Pn/+q/v7n/ye99" +
           "/Qa1yi2W+39wbPiar/XKQR87/JD8TBPiSZII2qjU0Ef1uTYbhC1yhKls06gK" +
           "ZXm5ak9CTBi1q4ylSfiALxbYGVpBa0JtUxoV0hEKyp4h22FbNmoNMXfpzafx" +
           "tMjw/fXQWFm9Kldp+ewSNak+qk/mAU0JJV6DV50OXR746mJqVxwFraENMmVg" +
           "RCGoVEbrKkev1wpcLxmhFrkzsddcIxM0WY1Ixx5Ou6yoVOhZIzBQv9XsqXK8" +
           "6EqTGpwaNXIprVG30JmoVLFqhvoASTpcuORbarey3Cwaku+R3c0qaVu4Sc6n" +
           "Xrdk4r1AIBvFjYd0SzU35ldi1x8ZUYki+52FjdUMzk1mNVFVmOW8nozjsIVb" +
           "3GrUL26MmqsP2kOFXQnOuCAQLXQWdGKxXyM6Lt3o9WfVSaAlRGcue0Y4ZB1t" +
           "NiGtLlo1rHQkU+aGH5isQHdhpbxYmLNopQ3bWnEdlhqbet1qGaV2e2hvxI5B" +
           "2iOPxoNZMndX/FhNserMa5lyPGjgDcEqNovGbDZjh9MG1+Tm/KxDa6UlNuT8" +
           "Amt3KwnaJGyy0+D6yLSiMwuRH9r4zAimNMd7siCNi+S4jtZ5M+jNFyjvwqUm" +
           "zjmNqu3Qa3WcFOHVkg6LVUOhqlpZ5sflZp+ivKBreAPdCn2qVyzr6ILzqBat" +
           "T4IpH1SxEJxfApkWGmZF7+MaocXjucwKhXhewFyzJUlzP3CDCE1Uzm0PCw1h" +
           "TJYwVRoVB9JgIizWg4Qkmh2jTM9H43RWr0iTtGDaA6c5icRBMCv0/T7WJPhk" +
           "PBgiC8tXPaqNjVy2SOBxd67aYyK2p8uxJGGY7ksYuhgMI7Hu8bYSO/Z4Jhgj" +
           "nq0H3rLrCouoSXRHq5GpWxQ+FJAla3bKDrB3WHZ6ixlt9/CJnlI+056WC2oB" +
           "Y6Yow8zJJYPGrUYRi6Qm0qdnVG26CDgmNvFoQ7cmkcRLyAaWSmutaITs3CpS" +
           "9swJZHG4WfTcBC1JVhp1w2l1sUhQ07RWdFruKDPCrsxRL5gPrY5ue9UNs6jO" +
           "Gy11OnDgQjhRtUGpQLmVWYIMDdGwArzXE1a811s1/V4JB+lgNzthuz3hJkkg" +
           "1FHKbWoMFy2dZRUfR5UEQ43IpUiFcU0F1l1j45ZblZUuVaKKuYG5FPfNXnXQ" +
           "d9lqeUaifYaTjIDRpH6r1KasYcy6bFNczxAcIVglEMJKvcf3sJEsttYxu0Gs" +
           "VqprhXmq123FtEcVSm+ygbqp6zrON9m+05GLq2FQCbQ1Fs1Vvw8H3VpjiZIy" +
           "Ul4yAjFkK/ASHdKwhSBEqan6FbuftKiRMpn343KvrATYhkKbDuIQYalCrwhb" +
           "kpcYbVt1Ke0XaTRW+EHkMIw0QHu+R+lVYbr2k6FhpBOUpbsasbRX5a5hM0F1" +
           "NFvW+3UzmOImnzH74zFpOHp7g635qMQtkHKdMufwwsOGFdSvIHi7yCI8KsTl" +
           "WXMJUwI3YRHZlmppqgTrVGbGvX7gtSg9ZNlV3/RkkxQ7wao4a3PWMojoAF9t" +
           "qipnRwrGFjSHM4qVwtRKFk5LKGOupI/a5foCpNu6L5isXkMoQtLWHu3U0mLa" +
           "ooS4SfKirNGWNfFHWqnIFEiN4qqLtg0chjKquhkzDDzFRLm9aJOjBlYGRUGh" +
           "wownVJte8alQ8bHyILE6tV7TK8WqZOMdtOISjD6OR0UepmZs2VFgYtBnqlFJ" +
           "YRJO1Wpit16b81jFMwdCq8MmnmpX+9OStnacnkwomjP32pVJZ1IeUwZjUsNC" +
           "wJaoyXxMt2JuvOjD2rxeiFIOKZa1jqa3TRkW0EW7iaIdndR1I6KdBIBzHa5F" +
           "NOGXpXbaJvpDoSaI5oi1Jwu7ZlCSJMfLiKyPsHrs6r163OlyKonh/Mit9ASZ" +
           "ik14QDeCUrtW24QbuTrAymSX7hghXUJbLpGkhaSzqNWQYr9YcFnRrruxXGjF" +
           "42XKwsOwVU9qUkK3G72qwvENpQH3+AJmYPiypuoEQ2MRvqhgfdsoteCAL6rV" +
           "fkqVCLs85poObMFjj+cMB9lMZXjqOMtyfT1NhKXPVhuxT8pJb07E5aBk46vF" +
           "esEQFKbGk/GoFnkTSqulLUFyia6otFwsxKt4OhvPVstWd14pxmWX1tar1LGp" +
           "adVq1jvEZNYJZ0un2F1hzpjz4qYsrIa1WoVmHJU2akbLdk1/EXH1EtKvTdgB" +
           "vikrUceBuYJKyXQnrbMuyGgBnNI7aQE1ezNfqolEnTPaqcKi3a5uTloBMloR" +
           "/RaMOciqhgbVNtyT51qAK2SDkmOA43ahXJh027jSk5sTTqvyUxJW1qVqJV7K" +
           "E4mRtVFNdTkurg3JiPMDz5zpzKrCKAVYbGgDEobhoChGosMMkbTdrGmMt/KW" +
           "JFsdxm7bVaxqY6JpxgQNxRVM4kiDLXHN2UxolwmmrZRhqQv77VK9Ig8TroJj" +
           "1JKtdzrTSok2LQqoMZkXhmbNE2SnwdP8piK2FgHRWEwGVhuzG3FA+wO2NCAK" +
           "5KJSHTGpoMdBj57GJGLODYyrqe0Ow6GAoL8Zj61yGxkrM8PXh+vUG21Ga9nh" +
           "HbqYqsi4qS5QQfSJJSuM6govFclVez1Y4spQR/Wxz/G12conk/ZqvpA288BT" +
           "+W6hQMDKNK3GUTxuRjjqlQv1RmFoE0Oyndgrz3Gmm+GqVY/ChYYQi1rcrXSd" +
           "Tb3Q4QMjHilyPDZwmqkVGNRknVasIqxTXZZXAUZU2xZXV8Y6rAtGxFmmsVyT" +
           "FM63Kb7ZrYh4WKR6fLNfNKNCXMLsrqD3K+YgDQx8MhMxmSk5vNdW232qGHv8" +
           "Ep30/VQJ43CtTpblikbVCK+mwx5SrLBk3a1ViyrdHscNba3xotCjm+Upoo+5" +
           "dF7WZX/llTZraoMCCRqvdtt+KolTO9V6tJagG53shSiitKhNrTydM84CFpj1" +
           "MFluTKeiyeua79cbntNd1VszBsFJDGZpw6hhRWs0RjpF3RFHHtmxu7CHL1hX" +
           "MKxFXVUL2rpXZ6tMk9hUiekaVC2baugQveo8teiyvvD83gQjARRZVFxeqyin" +
           "rDljgHTCgbVE16sBEm88HXeDyty3LNiXmHRoNwHK9FOnOJhaE766IUNGa4yr" +
           "64k8b2teedGwqtF02lQMzFLYYJQOtOrQF3A+6UpxvGiMtChqtCRj1RnLtIis" +
           "jYhablYzCe4yrVjqq8vNGsamcVyACzOtZ/ULfaqwnMq0GpeMRUHgSXHijBCB" +
           "Z8sVphroxTami5OWQVR9gAH2QtMIBx80HVspruut0nItSPFkAir3t2Ql/dtf" +
           "3anqzvwAefQ+ARymsoneqzhNJDdecC+EbvN8NwQnblXJ1921pPJuxD2HnenD" +
           "3+MtqV2f4szhUfZtN+zI4kmoOoEpWer1DdmT/dfsHPbQzV5G5Gewz7zvueeV" +
           "0WeRvYM+0RQcuw/eER3Xx4eevPlhk8xfxOyaF1993788yL3VeOeraMk+ckrJ" +
           "0yJ/l3zh6903yh/dg84etTKue0V0kunqyQbGRV8NI9/hTrQxHjpyz/2ZNx4C" +
           "piIH7kFu3Ba9od/P5IG2Da9TPbi9bWDkAXbo1Xsyr8YlOXdm25WjzGM5d/wy" +
           "Hbx3ZYMP3CP7qhiqh8LuPi7swPu7IA5e6Uh8olUG9vQVGvqHqyKv+lUBCKEH" +
           "rnt5uX3hJn/h+UsX7n9+8td5M/zopdhtBHRBiyzreBfq2PV5z1c1M9+a27Y9" +
           "KS//+UAIPXhz7ULoXP6bG/L+LcevHbjkNEcInQXjccrfCKHLpymBxPz3ON2H" +
           "Q+jijg74bHtxnOSjQDogyS4/5t2gdbVt3CVnjqXhAezkjr3rlRx7xHK8r56l" +
           "bv6i+TDNou2r5mvyF58fUO96qfrZbV9ftsQ0zaRcIKBbt68YjlL1sZtKO5R1" +
           "vvfET+740m1vOMSUO7YK7xLomG6P3LiJjttemLe90z+8//ff/NvPfyfvpP0v" +
           "9ETJBwEgAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "l/MTAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYb2wUxxWfO//BdozPNtimEAy4BxIOva1DEtSaloCxsckZ" +
           "n2xCVdPkmNud8y3e2x12Z+2z05QQqYUmUhQFktJI+BNR1YgmUdUo+RLkqlKT" +
           "KE0jaNTmj5q26pf+QwpfQiv6783M7u3e3pk0n2rp5uZm3ryZ995vfu+NL11D" +
           "DY6N+ig2NZxiC5Q4qQzvZ7DtEG3IwI5zGEaz6mN/OHvyxq+aT8VR4zRqK2Bn" +
           "XMUOGdGJoTnTaKNuOgybKnEOEaLxFRmbOMSew0y3zGnUpTtjRWroqs7GLY1w" +
           "gSPYTqMOzJit51xGxjwFDG1Ki9Mo4jTK3qjAYBq1qhZdCBasr1gwFJrjssVg" +
           "P4eh9vRxPIcVl+mGktYdNliy0R3UMhZmDIulSImljht3e444mL67yg19LyU+" +
           "uflkoV24YQ02TYsJE51J4ljGHNHSKBGMDhuk6JxA30J1aXRbSJihZNrfVIFN" +
           "FdjUtzeQgtOvJqZbHLKEOczX1EhVfiCGtlQqodjGRU9NRpwZNDQxz3axGKzd" +
           "XLbWD3fExKfvUM5978H2H9ehxDRK6OYUP44Kh2CwyTQ4lBRzxHb2ahrRplGH" +
           "CQGfIraODX3Ri3ano8+YmLkAAd8tfNClxBZ7Br6CSIJttqsyyy6blxeg8n41" +
           "5A08A7Z2B7ZKC0f4OBjYosPB7DwG7HlL6md1UxM4qlxRtjF5HwjA0lVFwgpW" +
           "eat6E8MA6pQQMbA5o0wB+MwZEG2wAIK2wNoKSrmvKVZn8QzJMrQuKpeRUyDV" +
           "LBzBlzDUFRUTmiBK6yNRCsXn2qHdTzxkjppxFIMza0Q1+Plvg0W9kUWTJE9s" +
           "AvdALmztTz+Du187E0cIhLsiwlLmlW9ev3dH7/IbUmZDDZmJ3HGisqx6Mdd2" +
           "5fah7V+q48doopaj8+BXWC5uWcabGSxRYJruskY+mfInlyd//vVHnid/jaOW" +
           "MdSoWoZbBBx1qFaR6gaxDxCT2JgRbQw1E1MbEvNjaBX007pJ5OhEPu8QNobq" +
           "DTHUaInf4KI8qOAuaoG+buYtv08xK4h+iSKEuuCDtiAUG0PiLzbKW4ZspWAV" +
           "iYJVbOqmpWRsi9vPAyo4hzjQ12CWWkoO8D/7hYHULsWxXBsAqVj2jIIBFQUi" +
           "JxXNKirO3MzAncrUkQMDd+6fGOe8SIrElJc+xbFH/y+7lrgv1szHYhCm26Mk" +
           "YcD9GrUMjdhZ9Zy7b/j6C9m3JAD5pfG8yNAobJ2SW6fE1inYOiW2TtXeOjli" +
           "WPNTQODDcnAEcy5YQLGYOMhafjKJFYj0LHAGkHbr9qkHDh4701cHIKXz9TxY" +
           "ILqtKokNBeTiZ4SseunK5I133m55Po7iwD85SGJBJklWZBKZCG1LJRpQ2Uo5" +
           "xedVZeUsUvMcaPn8/KkjJ78ozhFODlxhA/AaX57hlF7eIhklhVp6E6f/9MmL" +
           "zzxsBfRQkW38JFm1krNOXzTsUeOzav9m/HL2tYeTcVQPVAb0zTBcN2DG3uge" +
           "Fewz6DM5t6UJDM5bdhEbfMqn3xZWsK35YETgsUP010KIE/w6boVQH/Tup/jm" +
           "s92Utz0SvxwzEStEpvjKFL3w3i//vFO4208qiVA1MEXYYIjIuLJOQVkdAQQP" +
           "24SA3G/PZ84+fe30UYE/kPh8rQ2TvB0CAoMQgpu//caJ93/30cV34wFmGWRy" +
           "NwdFUalsZBO3qe0WRnKcB+cBIjSAFjhqkvebgEo9r+OcQfgl+Wdi68DLf3ui" +
           "XeLAgBEfRjs+XUEw/rl96JG3HrzRK9TEVJ6IA58FYpLd1wSa99o2XuDnKJ26" +
           "uvH7r+MLdZxZ6x19kQi6RcIHSATtLmG/Itqdkbl7eJN0wuCvvF+hgimrPvnu" +
           "x6uPfHz5ujhtZcUVjvU4poMSXrzZWgL1PVGiGcVOAeTuWj70jXZj+SZonAaN" +
           "KvCrM2EDD5YqkOFJN6z64Kc/6z52pQ7FR1CLYWFN8hlkKEA3cQpAoSW6514Z" +
           "3Xke7nZhKqoynvtzU+1IDRcpE75dfLXnJ7t/sPSRAJVE0QZvufixTbTbebND" +
           "jMcZaqa2xUATgRKp0RG1XYA/sXatn/z87zD+gj1ior+OoT01SX+4xIjp6ACm" +
           "as6v5Hru/o0r1TuiVrv46LklbeK5AVmVdFbWEMNQIv/o1//6Rer879+skZIa" +
           "vXo1fHAbbalKFuOiFgyIbtfVG3UfPrWutTpPcE29K2SB/pWzQHSD1x/9y/rD" +
           "Xy0c+wwJYFPES1GVPxy/9OaBbepTcVHOSu6vKoMrFw2G/QWb2gTqdpObxUdW" +
           "i1vSV8ZHD4fDRnDhhIePidokLMDHm/5qaltpaYQE4hKwPsjaxVXgRXlKFuX+" +
           "xFqOvvmdqgDdfkt1ObLEMb52C1p5gDeTgA7VJlBY+srWhJV5KBVzu3gzJS/K" +
           "l/+3+8sH9pSAMGtXOP6WA5+5ZAL4rqt6xMmHh/rCUqKpZ+n+34j0XH4ctEJi" +
           "y7uGEQp0OOiN1CZ5XfilVdIiFV8FeO+sfDqGGsS3MGRGrpj14hFdwVAdtGFJ" +
           "eCm0RyVBo/gOy51gqCWQg4DJTliEgXYQ4V2X1sCLfLGUYtX8KKLa9WlRLS8J" +
           "Z3p+vcWD27+KrnxyZ9UXlw4eeuj6Pc/JSgOe6ouL4oEG701Z9JSv85YVtfm6" +
           "Gke332x7qXlr3INthzxwcMk2hDC9By4V5WljfSQNO8lyNn7/4u7Lb59pvApE" +
           "eRTFMCD+aOi5Kz0FudwFrjmaDnNk6N82okIYbPnjsXf+/kGsU+Qej1V7b7Ui" +
           "q569/GEmT+mzcdQ8hhqA10lpGt7vzv4Fc5Koc5Alm1xTP+GSMQ1AmbNcs/w2" +
           "b+NQxvzeC894Dl1dHuWVKkN9Va/uGtU7pOV5Yu/j2gXFRQjQpTQ8W+Jv1hpW" +
           "QWwGLvzj5Hfem4CrVnHwsLZVjpsrc2n46R+Qa7tkyP/AXww+/+YfHlI+IF+g" +
           "nUPeM3hz+R1MaUnO1WXT45R6sg07BAwoFdzzuFB8mjffLXEJhmL9lP4XQ2uu" +
           "FfMTAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "KRs2y7TndonrEPSyo4SN1bJDmpVaCVU7XXaWNcbpvMutYtZf9pv62JIqo0hP" +
           "PBbvouWyi+MDv2ZtyDo+opkms3SmUpOVWjTKMcNAwCY+nuqaKOmTaLLuqfLA" +
           "qyPs0mZqdT8z2zzppCaBEPIMr5lOu6Z3zaVjikGVqhpIo+dyWZZGTWMoLKfl" +
           "OtN20WXY52fZOJrofCavGy7S4bB4ro9VURiIhFLKxk21j5F0OVnobX2TVcke" +
           "HlcnDPhRNJNSjN7KK6fSNGLL+JwaL6LJoISW2C6FbKqKLwodZJwEiO1GDQzg" +
           "Rmm0TjcZNYqpYG2zba68KVsg/Np8BSvVV5ZIoD1qNp937W7CMbwgLjVCEAZY" +
           "ZUSUaWQg1SuwoZdLkzmFLAdmPRSw8bpZahF+T1gECYKoMtMoI+WSKpYrm7ZL" +
           "T4fb/kZrT2Qnkpp8eaWXpkOPVZuw2uzaI6Jtm6vlWlcWlN8IYV4VjIUDTzWr" +
           "Wic5o5xYM50jFk3KGNoRPJtQGyR0GlWGLnfCbMg2xpTIVLsEXm/PA05DNyO5" +
           "0fCxWUJ6LINVk3WnFsI9TpNSqZqijaVgVYdqtzMixjHn0kg3XmlLxanpTL+0" +
           "SVrrdRs2F5YbDtZeklaTgdHJ8ASAt6RORHs9qQR+bzQLM2m64NCBSFu0KvKE" +
           "Pk6mdq1kzyQbHkm+R8h9dt0KexhFkvh8teTbTL+aVSusilQzHAuEWnuItrj5" +
           "tN2vm86SpYiyKgSED6IbRytSebbUa55ksit/663jbAKjXXKoBlQN1wxu5jG1" +
           "GIkGoyHBiFRJkNaJYaVjZazoSp+0e6okr2QsnRDjxZANSkManc0JJJrJsYdk" +
           "9VpGwgsbtXyw0P64hI5mcCXt2kGVaLlyVF3jnTBB/FKIjhNLDNeVKrd0FJ3F" +
           "CdEVtbYypXp9obtGfBRBqkM9rNcacLSUuvJ65qNGh1AU2WHbCW+1F9uuEhsi" +
           "XZ4Yg3CaxONgoFJYg8VGTSSYZkJnRKIp0tgiITnbllR4s2Hm7QE1QmlxkG6R" +
           "Bi83FT0A8d/hR0l1zfq9sL3BaESYKthivNICXkkn2tRC1yOxLnXIikEOPdI0" +
           "u/rA0vwl1yM7LoKvZCcO5LlAVUx2M4hsORVni+Es13EGp+0Vv1672mpBasYy" +
           "RnmFo3oKjrXQAF+Q+nhB1ETGac7hKJyajIizTTFLyouMGSGsg8BluB51GsGI" +
           "6NHxjB9UpwQO4xLBVcJVXE17bsdEwtZkxQYS7MHlil2adSpqTDHWtpbQlBCU" +
           "eN7qoy0JnxmWI2pdqy3W2zoPRwa5ouloVO7RQzoMbLRitrWNSGgx3Wb0llsa" +
           "bsWmjyz4LY4uVq2psKiQzNixqMVsLlREbIZGLc7g6Mk8ntVZlpMbU2fIjeqM" +
           "VA7gtTolsRrMhl4Kkq/JzNlUdD2xqwMVYUYLXq/6CVfxKRqApNRgRus6Phdj" +
           "w63SS71cxtLaauaE5W4/NrN0o/aWmEm2Gs1tRcSnjm2MhD5fd7Z9r4ZUkhqn" +
           "4I1gTQSUPhy3ey0SlnkLZ7NSO9E27dB2ZdLrL6v9OuYvu3Nl4NnRzICRJR1N" +
           "YEG3UbGm1CbWCq82EJpyx7CbqZpQN80VgZacgI5r62xdaas466s44bhoOh7A" +
           "9KgnoISr9NUI2WAK3BfSdaa36o0K6aBaJ5mK7LLfEMH9no4ntYAX8XmC2Nhi" +
           "1h4KthCMhfoUZtaoGUyF6Ybm1pmNdwzdrbRC0etsIk4S7SAKVcyrVIewINfi" +
           "5XaAELPNBkbgudFxunC3DS+8yUDvlc0MHqI9eeLx6HQ2ruDDarQo1ZrExm9r" +
           "WZa0m3XXNsB2phjT5RrOoDITsCRpG70xyNjflKfyb3llt6m7iovj0esDcInK" +
           "Bzqv4BaR3njCvRi6PQj9GNy0da2Y97gUVVQh7j0sRB/+nixFHdcnzh1eYd98" +
           "wwIslca6F1mKo19ffz1dd83vXw/f7N1Dcff61Luee17jP43uHdSHZuC6ffBK" +
           "6KQ+IfTUzS+ZveK9y3HR4svv+peHxr9gvu0VlGIfPaPkWZG/23vhq/Tr1Q/v" +
           "QeePShjXvRE6zfT06cLFpVCPk9AbnypfPHzkngdybzwMTOUP3MPfuBx6Q7+f" +
           "KwJtF15nam97u8AoAuzQq/fmXt2U1cKZpK8muccK7s3LVO7enjchcI8aghxf" +
           "PxR2z0lhB94/DuLoJ12FT5XIYuj+G9fvDydDX/ELARA5D173inL3Wk393POX" +
           "Lz7w/OSvi9r30auv2znoopE4zsmi04nnW4NQB8d4QbkrQQXFz3ti6KGbaxdD" +
           "F4rfwpB37zh+7cATZzli6DxoT1L+RgxdOUsJJBa/J+k+GEOXjumAq3YPJ0k+" +
           "DKQDkvzxI8ENKlW7Ol167sTuO0Cbwp93/yR/HrGcLKPnO7Z4nXy4u5LdC+Vr" +
           "6uefZ/pvf6n66V0ZX3XkLMulXOSg23ZvFI526OM3lXYo69bOkz+68wu3v+4Q" +
           "Su7cKXy8b07o9uiNa+aUG8RFlTv7wwd+/42//fy3isLZ/wJi0BmJ5x8AAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYb2wUxxWfO//BdozPNtimEAy4BxIOua1DEtSaloAx2PSM" +
           "TzYhjWk45nbnfIv3dofdWfvsNCVEaqGtFEWBpLQS/kQUJaJJVCVKvwS5qtQk" +
           "StMIGrX5o6at+qX/kMKX0Ir+ezOze7u3dybNp1q6ubmZN2/mvfeb33vjS9dQ" +
           "g2OjPopNDafYPCVOKsP7GWw7RBsysOMcgtGs+t0/nD1541fNp+KocQq1FbAz" +
           "pmKH7NOJoTlTaL1uOgybKnEOEqLxFRmbOMSexUy3zCnUpTujRWroqs7GLI1w" +
           "gcPYTqMOzJit51xGRj0FDG1Ii9Mo4jTK7qjAYBq1qhadDxasrVgwFJrjssVg" +
           "P4eh9vRxPIsVl+mGktYdNliy0R3UMuanDYulSImljhv3eI44kL6nyg19LyU+" +
           "uflEoV24YRU2TYsJE50J4ljGLNHSKBGMDhuk6JxA30R1aXRbSJihZNrfVIFN" +
           "FdjUtzeQgtOvJKZbHLKEOczX1EhVfiCGNlUqodjGRU9NRpwZNDQxz3axGKzd" +
           "WLbWD3fExKfuUM59/2j7j+tQYgoldHOSH0eFQzDYZAocSoo5Yju7NY1oU6jD" +
           "hIBPElvHhr7gRbvT0adNzFyAgO8WPuhSYos9A19BJME221WZZZfNywtQeb8a" +
           "8gaeBlu7A1ulhfv4OBjYosPB7DwG7HlL6md0UxM4qlxRtjH5VRCApSuKhBWs" +
           "8lb1JoYB1CkhYmBzWpkE8JnTINpgAQRtgbVllHJfU6zO4GmSZWhNVC4jp0Cq" +
           "WTiCL2GoKyomNEGU1kaiFIrPtYM7H3/YHDHjKAZn1ohq8PPfBot6I4smSJ7Y" +
           "BO6BXNjan34ad792Jo4QCHdFhKXMq9+4ft+23qU3pMy6GjLjueNEZVn1Yq7t" +
           "yu1DW79Yx4/RRC1H58GvsFzcsow3M1iiwDTdZY18MuVPLk38/MFHnyd/jaOW" +
           "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" +
           "8RMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZe8zjWHX3983O7Oyw7My+t1v2yUC7G/o5jp046fDYPBzb" +
           "iR95OYnTsoOfiR3HbzuO6ZaHBLstFSBYKJVg/wK1RctDVVErVVRbVS0gUCUq" +
           "1JdUQFWl0lIk9o/SqrSl1873nm8WrfpHI+XGufecc8+559zfPff4xR9A5wMf" +
           "KriOtZlbTrinJeGeaZX3wo2rBXsdptyT/EBTm5YUBCPQd115/IuXf/TjDy+u" +
           "7EIXZtDdkm07oRQajh0MtMCxYk1loMtHvYSlrYIQusKYUizBUWhYMGME4TUG" +
           "es0x1hC6yhyoAAMVYKACnKsA14+oANNrNTtaNTMOyQ4DD/pVaIeBLrhKpl4I" +
           "PXZSiCv50mpfTC+3AEi4mP0fA6Ny5sSHHj20fWvzDQZ/rAA//5tPX/m9c9Dl" +
           "GXTZsIeZOgpQIgSTzKDbV9pK1vygrqqaOoPutDVNHWq+IVlGmus9g+4KjLkt" +
           "hZGvHS5S1hm5mp/PebRytyuZbX6khI5/aJ5uaJZ68O+8bklzYOt9R7ZuLWxn" +
           "/cDASwZQzNclRTtguWVp2GoIPXKa49DGq11AAFhvXWnhwjmc6hZbAh3QXVvf" +
           "WZI9h4ehb9hzQHreicAsIfTgTYVma+1KylKaa9dD6IHTdL3tEKC6LV+IjCWE" +
           "7j1NlksCXnrwlJeO+ecH3Js/+E6bsndznVVNsTL9LwKmh08xDTRd8zVb0baM" +
           "tz/JfFy678vP7UIQIL73FPGW5g9+5eWn3vTwS1/d0vzsGTS8bGpKeF35tHzH" +
           "N1/XfKJ2LlPjousERub8E5bn4d/bH7mWuGDn3XcoMRvcOxh8afDn4rs/q31/" +
           "F7pEQxcUx4pWII7uVJyVa1iaT2q25kuhptLQbZqtNvNxGroVPDOGrW17eV0P" +
           "tJCGbrHyrgtO/h8skQ5EZEt0K3g2bN05eHalcJE/Jy4EQfeCL/QYBO1Mofyz" +
           "M8naEPLhhbPSYEmRbMN24J7vZPZnDrVVCQ61ADyrYNR1YBnE//IXkD0cDpzI" +
           "BwEJO/4clkBULLTtIKw6KziI50gJHo5JpNTiWXrlAszQ7O2m38tiz/1/mTXJ" +
           "1uLKemcHuOl1p0HCAvuLcixV868rz0cN4uXPX//67uGm2V/FECLB1Hvbqffy" +
           "qffA1Hv51HtnT32VAhYBFxPbvraUQcEG2tnJ9bgnU2wbKsDRSwAZAExvf2L4" +
           "9s47nnv8HIhRd31L5itACt8c05tHIEPnUKqASIde+sT6PeN3FXeh3ZPgnBkD" +
           "ui5l7L0MUg+h8+rpTXmW3MvPfu9HX/j4M87R9jyB9vuocSNntusfP73svqNo" +
           "KsDRI/FPPip96fqXn7m6C90CoATAZyiBcAfI9PDpOU7s/msHSJrZch4YrDv+" +
           "SrKyoQP4uxQufGd91JPHwx35851gjS9n2+EqWGtxf3/kv9no3W7W3rONn8xp" +
           "p6zIkfotQ/dTf/MX/4zmy30A6pePHZNDLbx2DEgyYZdzyLjzKAZGvqYBur//" +
           "RO+jH/vBs7+UBwCgeP1ZE17N2iYAEOBCsMzv+6r3t9/59qe/tXsUNCE4SSPZ" +
           "MpTk0MiLmU13vIKRYLY3HukDgMgC2zKLmquCvXJUQzck2dKyKP2vy29AvvSv" +
           "H7yyjQML9ByE0Zt+uoCj/p9pQO/++tP//nAuZkfJDsKjNTsi26Lr3UeS674v" +
           "bTI9kvf85UO/9RXpUwCnATYGRqrlcAflawDlToNz+5/M271TY0jWPBIcD/6T" +
           "++tYwnJd+fC3fvja8Q//+OVc25MZz3Ffs5J7bRteWfNoAsTff3qnU1KwAHTY" +
           "S9wvX7Fe+jGQOAMSFYBvAe8DHEpORMY+9flb/+5P/vS+d3zzHLTbhi5ZjqRu" +
           "AQWcECC6tWABICxx3/bU1rvrzN1XclOhG4zfBsUD+b9zQMEnbo4v7SxhOdqi" +
           "D/wnb8nv/Yf/uGERcmQ545w+xT+DX/zkg823fj/nP9riGffDyY3YDJK7I97S" +
           "Z1f/tvv4hT/bhW6dQVeU/cxxLFlRtnFmIFsKDtJJkF2eGD+Z+WyP+WuHEPa6" +
           "0/BybNrT4HJ0JoDnjDp7vnQcT34CPjvg+z/ZN1vurGN73t7V3D/0Hz089V03" +
           "2QG79XxpD98rZvxvy6U8lrdXs+bntm7KHn8ebOsgT1kBh27YkpVP/FQIQsxS" +
           "rh5IH4MUNjt+TAvPxdwLkvY8nDLr97Z53xbQsraUi9iGRPmm4fOLW6r85Lrj" +
           "SBjjgBTyA//44W986PXfAT7tQOfjbL2BK4/NyEVZVv3+Fz/20Gue/+4HcpQC" +
           "8NP7OHHlqUwq80oWZw2RNe0DUx/MTB3m6QAjBSGbA4um5ta+Yij3fGMF8Dfe" +
           "TxnhZ+76zvKT3/vcNh08HbeniLXnnv/1n+x98PndY0n462/Ig4/zbBPxXOnX" +
           "7q+wDz32SrPkHO1/+sIzf/Q7zzy71equkyklAW5Mn/ur//7G3ie++7UzMpRb" +
           "LOf/4NjwNS9RWEDXDz7sWJRLayFJJjoPww3VSXtcaKyI+gZrJDQfSUiLCIeS" +
           "5dSTUm/IjlJxYU6WWNmWbZ2OUdXR1YkeB1xzTEgeGbaJScNl+kN42Rc6Uqcz" +
           "bo678XpY9sL+chiyNOlPy05FCgveFF6y3WmR9gtayqcaHqHqRuZcxKtE8mrG" +
           "leBVrGsyisbmsKb25yXe7Dku15J0sdcc892gh5OTNT5oBJuAZ5V5SAaFsAjb" +
           "LaSMITrnFrqO0veQtlxP3VWXwjm+44yskcQgET/fyF2b4AmPSdqDlcyzQy0R" +
           "NmjatAV3FJmDie94AU4yNLKeKz1x5LF82jHCMpKQA7PYbpEIbdRYBzNHXdwz" +
           "62LDQ7yFpLYSKfDH83W745tBMJ73MG1RiwdJjw7GVmFFLkNR5SxjUxygAhtJ" +
           "dkuMrCG9ssxFjGo0hi2Zir2ZIzVmIxQi3SKccQkTB0JpJAYdolzsYJZJMhw1" +
           "7DZItrWIlpVOUkeLA0SaDuRhx1jMOF8f022urZpCmGr9ecjHne5MppguwSvp" +
           "FCEWY91okpwleI5qkgOhxg3c9Yxr9ZMUlRKym6oTRp60UJ1IunoksOUaXDJx" +
           "sxD2xTk4dyh+SBW1dj9tibO6owwdpyyaEc6JiCNUzNaCbvQIK6YWPj4fyPGo" +
           "KKlc2t7U53x10osWQ9EJanWk1uiwRKmETGazmc5t1mFfk6tSdS5pDSvC60hk" +
           "LfQY4xsmIO818NaaxCmLqazUopCwmGclg9CkyuNBs+4Oo+6iMQmqlox0HLGB" +
           "NJcLcdVIJ+6SqHbsEc2583p/EM7lsWVRHV2opDxGroazyYIbNzHTLTa9ycho" +
           "MiXS6W6cFUeQArKUjDbt90KRxSkUFqkWZXbrMxtxFl6119MbTlihsWA17OBi" +
           "g680ppwp2SgmqXit1HGwfpNS24vulPVqBUwPCyXUE1CX3VRIkzEjjSNmYxsR" +
           "PTzcREhrgtfEBIMHgyZClatkHLRTJXDWKIsYxro1UmciUmWjcY9ZolWYbVP2" +
           "RoVNiZ8I6tCZODO50UgQry0NKnMpqSX8qNQByz7oIwTCykTMm1J9WizibqfM" +
           "L7BeVO1zju+1RpQg0baOdemqx9cjySELciSGcbGadLFFwRh2iShqtjiDEAqJ" +
           "M9RxgtLYqO8PhgFtkWtjiaphZ8jKUwrXhHq7nNSpwsJnhWXcqetlG18kND6u" +
           "KxtcaCxpF6TngSi0ibliMQO/yxgpgfXQ7pilQgxWOF2rjijeqAzoEWW7AITw" +
           "Wq+wkTAbF8OxwtRni8hEusRcVvyEYoq0oY6VQlnDpDguN2rDdbc/TfyesU7D" +
           "RQUZKVEklFpOe1LRCcSzpclGpdZNmq7KdaWEKeW2sjEnxEYRUwFe0f1ug3LI" +
           "bp3FInTqlwmWMl3U9dY8W/StCmUEfXTcHa8xsSnHxKhvSTWVnBqJGcZhutYH" +
           "KDm3k3QZNJuDTjMYGsqmFXrCsDVbBNFsZBQr3kZvdF2tXymqFB4hPDmaJi27" +
           "ySuk79cbEl2MU7RBMqXCwKQ6TUYudYooXCmzE5vCiabqLWjOrvB+2+8MJSUm" +
           "44lTHa8QfcMVOnos0dUl5s2VVR2erUgSkwmSi1W62q0u7KIxS+XivE+WNyXc" +
           "qBcLZZmLm5tYRKz1mo5aIq17Pq30O/oiGhG8Q8Va4MaxFXCFcWhi/TgppkTT" +
           "JZzYTDoMnqKbtBa3C3hJKTrGuJ6whCmKmElGfptdj5dKfS2wJXrYQkswPwuK" +
           "NZVHEQKrV5c9q+avN4N4gTVhmh7Ny6tCDZzmNRRFilUVwebtJWmoKdcXEKG7" +
           "iGcJiXgRNhlQvN7QxDrVmtTbpusv4aE0FwLY50mlry/twkqdV6usr1OrwpRv" +
           "NeYJrQ/CZW1K0Aksz2uVWrdkcqjXXrlmt4q25kGxwS7jyOv3uKhUlVO4sbEE" +
           "RJ/ChQai16lho91MnU21v5ZndKHe7DhcMcTbKhGlxY26qcXLJSbCnSnaRfrx" +
           "TBVsNEawskb2GKQ6dSvFIGK7CRVwRYHtMlw5ZBwGs4dm3yw1V3WUQ5gGDmuy" +
           "kaoNGhk5baKt2VNSlloNYS5sevyKbA/gao3U1aSCC44+LyBkR5x0uGpjvuwW" +
           "iZJSNxuOoVUqo+IMNR0Nn86MruekNhwmfR5hWgPFI+RELRTj3iZdKdNe0p0v" +
           "jYVU3hSnPVyiVQPErGMnPNED2oii1Oz06ZFQcfw+U23qEz+eAWFVNbEK60Ex" +
           "LSJps+htZLtVVkR2UFTX7QFXmI2VtFaCdd/aDMoDr51U8bBicL2UnRtlht8s" +
           "OgbZ9JcUjFameA0gDFxbpcJG8Lip74g92eO4sWIZo86wWVepMKI8Ew9YG8EH" +
           "k/J6FXlTbcZwTVgHO0OOWxURrc20wtxfTHid7rcDg5q7XtwtB0IY42HB6C2W" +
           "U0RKl7DneBHFDERuoQddi3PINRqNreqsO8E6U8TSe4M1311T7QRHqhRZ5OZL" +
           "ptojV3HZlywrkGiRxBrddS+wZ0l7uuBsl0aiUSFZeVws+4HXZ/SpYJV4hiLZ" +
           "RqkMSOFkNmf6juoQlaWrlyRvzc4LlrjCKHkjWwPdHsLoDC4ozYhwRxjXDxS9" +
           "qjVSZL2uT/3puIUuygzX0idEUlSHqdYDGQIlRr01ItHg4jJVWDoZLZVqceYt" +
           "8XWEcrQ3mZFdf92tqq4IUwLLYVYgsgYyTSlzYXTLc6+OS0FzWCVqnrn0GgOd" +
           "1q2R2RKIYNGIyb7NsJ06j5lrfxn6a2JSGBe9RLIdoa+hlbDbnFhYf9STYRXz" +
           "7RDkE1OQrqYVJ2Iaa6yg91BtVhou6n0YWQC07dG9qesl5Y2vlos4I+ntEkcj" +
           "IL58VIhbduTIM3BiGphYCJtLDmsDoRufIUpLZ6LOWstZjNaScmGCpulAa8yw" +
           "6nxFg51eXdY4Y2w7HQGfM2OKWFHdEVMcJeGArm9KcI8SeRSGaU50BadGeX4J" +
           "nbjtcYrgBbbD2zVaTZDWpks6rclwsuxOI5hHbSude0a6bA7laZuFsVln0BKa" +
           "swDZpHCrE2NIi4Q5h0nROT8dL7WyKHh9FBnLBUxKRuGyPLIMvEBJDYVrF9iC" +
           "xbUSGTPgCWnNGnJdBDP0lmGtKi8q4UTRm+sQBOpqE44k3VxQaMOPNiMarjb0" +
           "VguHy4uqJpjYHC0X1H4NMwF0lNtC4g4VfDxTOdOivE1rqnTJdt3zeBXvx20X" +
           "tTd20hREIx6PClZNmhZLs+qABQn7W96SpfJvf3W3qTvzi+Ph2wNwicoGqFdx" +
           "i0jOnnA3hG5zfScEN21Nzec9KkXlVYh7DurQB7/HS1FH9Ymdgyvs286svxJJ" +
           "qNmBIVvajeXXk3XX7P710M1ePeR3r0+/9/kXVP4zyO5+fWgKrtv7b4SO6+ND" +
           "T978ksnmr12OihZfee+/PDh66+Idr6IU+8gpJU+L/F32xa+Rb1Q+sgudOyxh" +
           "3PBC6CTTtZOFi0u+Fka+PTpRvnjo0D33Z954CJj69L57nj67HHqm33fyQNuG" +
           "16na2+42MPIAO/DqPZlX16iSO7PlKFHmsZx7/QqVu3dmjQ/co/iaFGoHwu4+" +
           "Lmzf+0dBHPy0q/CJElkI3Xtm+f5gLuRVvw4AgfPADS8oty/VlM+/cPni/S8I" +
           "f52Xvg9ffN3GQBf1yLKO15yOPV9wfU038gW5bVuBcvOf94fQgzfXLoTO57+5" +
           "Ie/bcvzaviNOc4TQOdAep/yNELpymhJIzH+P030ohC4d0QFPbR+Ok3wESAck" +
           "2eNH3TMKVdsyXbJzbPPtg03uzrt+mjsPWY5X0bMNm79MPthc0fZ18nXlCy90" +
           "uHe+XPnMtoqvWFKaZlIuMtCt2xcKhxv0sZtKO5B1gXrix3d88bY3HCDJHVuF" +
           "j7bNMd0eObtkTqzcMC9yp394/++/+bdf+HZeN/tf+u1Co+UfAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "NvcTAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "U/cTAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZaezrWHX3+8+8mTePYd6bfTplVh7QmdC/4yTO0mGZxHES" +
           "J96S2E7iFh5eYzve4iWxDVMWiaWlAgQDpRLMJ1BbNCyqilqpopqqagGBKlGh" +
           "blIBVZVKS5GYD6VVaUuvnf/+3hs06odGys3N9TnnnnPPub97fO7zP4TOhwFU" +
           "8j07XdpetK8l0b5lo/tR6mvh/pBEWSkINRWzpTDkwNhV5fEvXfrxTz5iXN6D" +
           "bhGhuyXX9SIpMj03nGihZ280lYQuHY/ituaEEXSZtKSNBMeRacOkGUZPkdAr" +
           "TrBG0BXyUAUYqAADFeBCBbh9TAWYXqm5sYPlHJIbhWvoV6FzJHSLr+TqRdBj" +
           "p4X4UiA5B2LYwgIg4UL+XwBGFcxJAD16ZPvO5msM/ngJfvY333r5926CLonQ" +
           "JdOd5uooQIkITCJCtzuaI2tB2FZVTRWhO11NU6daYEq2mRV6i9Bdobl0pSgO" +
           "tKNFygdjXwuKOY9X7nYlty2IlcgLjszTTc1WD/+d121pCWy979jWnYW9fBwY" +
           "eNEEigW6pGiHLDevTFeNoEfOchzZeGUECADrrY4WGd7RVDe7EhiA7tr5zpbc" +
           "JTyNAtNdAtLzXgxmiaAHbyg0X2tfUlbSUrsaQQ+cpWN3jwDVbcVC5CwRdO9Z" +
           "skIS8NKDZ7x0wj8/pN/wobe7A3ev0FnVFDvX/wJgevgM00TTtUBzFW3HePuT" +
           "5Cek+77ygT0IAsT3niHe0fzBO158+vUPv/C1Hc3PX4eGkS1Nia4qn5Hv+Nar" +
           "sCdaN+VqXPC90Mydf8ryIvzZgydPJT7YefcdScwf7h8+fGHy54t3fU77wR50" +
           "kYBuUTw7dkAc3al4jm/aWtDXXC2QIk0loNs0V8WK5wR0K+iTpqvtRhldD7WI" +
           "gG62i6FbvOI/WCIdiMiX6FbQN13dO+z7UmQU/cSHIOhe8IUeg6BzG6j4nIvz" +
           "NoIC2PAcDZYUyTVdD2YDL7c/d6irSnCkhaCvgqe+B8sg/le/iOw34NCLAxCQ" +
           "sBcsYQlEhaHtHsKq58DhZolU4KnQRypdhiIcH2CG5u42/X4ee/7/y6xJvhaX" +
           "t+fOATe96ixI2GB/DTxb1YKryrNxB3/xC1e/sXe0aQ5WMYKGYOr93dT7xdT7" +
           "YOr9Yur96099ZerZZu5RL8B3wz0pR4MUOneuUOWeXLddtABfrwBqADy9/Ynp" +
           "W4Zv+8DjN4Ew9bc35+4CpPCNYR07xhmiQFMFBDv0wie37xbeWd6D9k7jc24P" +
           "GLqYs7M5qh6h55Wz+/J6ci+9//s//uInnvGOd+gpwD8Ajms5843/+NmVDzxF" +
           "UwGUHot/8lHpy1e/8syVPehmgCYAQSMJRDwAp4fPznEKAJ46BNPclvPAYN0L" +
           "HMnOHx0i4MXICLzt8UgREncU/TvBGl/Kd8TrwFpvD7ZI8Zs/vdvP23t2IZQ7" +
           "7YwVBVi/cep/+m/+4p+rxXIf4vqlEyflVIueOoElubBLBWrceRwDXKBpgO7v" +
           "P8l+7OM/fP8vFwEAKF59vQmv5C0GMAS4ECzze7+2/tvvfucz3947DpoIHKax" +
           "bJtKcmTkhdymO17CSDDba4/1AZFrg52ZR80V3nU81dRNSba1PEr/69JrkC//" +
           "64cu7+LABiOHYfT6ny3gePznOtC7vvHWf3+4EHNOyc/C4zU7JtsB7N3HkttB" +
           "IKW5Hsm7//Kh3/qq9GkA1QAeQzPTCsSDijWACqfBhf1PFu3+mWdI3jwSngz+" +
           "0/vrRM5yVfnIt3/0SuFHf/xioe3ppOekrynJf2oXXnnzaALE3392pw+k0AB0" +
           "tRfoX7lsv/ATIFEEEhUAcSETAChKTkXGAfX5W//uT/70vrd96yZorwddtD1J" +
           "3QEKOCRAdGuhAVAs8d/89M6729zdlwtToWuM3wXFA8W/m4CCT9wYX3p5znK8" +
           "RR/4T8aW3/MP/3HNIhTIcp2j+gy/CD//qQexN/2g4D/e4jn3w8m18Azyu2Pe" +
           "yuecf9t7/JY/24NuFaHLykHyKEh2nG8cESRM4WFGCRLMU89PJz+7k/6pIwh7" +
           "1Vl4OTHtWXA5PhZAP6fO+xdP4slPwecc+P5P/s2XOx/YHbl3YQfn/qNHB7/v" +
           "J+fAbj1f2W/sl3P+NxdSHivaK3nzup2b8u4vgG0dFlkr4NBNV7KLiZ+OQIjZ" +
           "ypVD6QLIYvMTyLIbhZh7Qd5ehFNu/f4u9dsBWt5WChG7kEBvGD6/tKMqTq47" +
           "joWRHsgiP/iPH/nmh1/9XeDTIXR+k683cOWJGek4T6zf9/zHH3rFs9/7YIFS" +
           "AH7YT+CXn86lki9lcd7gedM7NPXB3NRpkRGQUhhRBbBoamHtS4YyG5gOwN/N" +
           "QdYIP3PXd1ef+v7ndxnh2bg9Q6x94Nlf/+n+h57dO5GHv/qaVPgkzy4XL5R+" +
           "5cEKB9BjLzVLwdH7py8+80e/88z7d1rddTqrxMFL0+f/6r+/uf/J7339OknK" +
           "zbb3f3Bs9IoXBrWQaB9+KGEhV7Z8ksx0BoY7qpexdGQ6eDutdRKe2UhIF4+m" +
           "ku21k8Ug6A/RaIxwYxR1ZVcnNlXV09WZvglXHcKM1M7MXA/bvEEM9XS07kf4" +
           "am2skXltqAgzb+rPVrilBk1epWewOoSnTI+U8Dm8EV1xo1blOGVpH1nXY9kR" +
           "6QrsbHRNrlY3VtpSJ6sKY7UXPt2V9EXbFJhRyDb6s21j0gmTkKEUI+qHpbgM" +
           "u90IaSJa5JcYT5v4SI9sZ4EzGjRoZuhxLieRSMwsU3nk4gwukUlv4sgMNdW2" +
           "5bSa9V3eyyJrMgu8ddjokwtku5yyC25NxdnQjFAk6SfWttftI4TZoryaxY0a" +
           "a6utdNbIOhFVrCOFgbDc4n5ghaGwZGuakW0mCUsogl1y+qtoodJ2mpaFKk8Z" +
           "otMlYntKOLZlbKqaV6s5ZL2aLstdMuVL8UbAPYGpLSZ8hVuEQxxFhjXb6g/o" +
           "wXTU6VOWsV7Vh0l7XlZoaT4ZTIemIdKBLhA9uqdafJRp42XEbIYjUR6QfZxR" +
           "sjmCJ4JuYn3a5teeavUnfIue+FuRJsfbrCol/VGmzkh51q3qeDLSYz5E4VZ9" +
           "wAwyaZl0J6M6s+DZWm1kVLBtyo1rdmeSJQOxIiXBxLf7c2zc14lAYrrz6sSs" +
           "SlWvWVo45KrdVpuRTmN20hEbnaCOTYlhFK3DNE3rsp1oy6ZbQ9BxudluyJVO" +
           "II4wWE8UDttyC61bma+oCsvMaKqx9k1xK5COKfdZwNtuTxGFx6bRApXKEjfe" +
           "dte9CEuormN1iV6tS7tjkhu2l5bUdiLEHgx1vp4xNcOZijODFrCa5ZextcCZ" +
           "GFnpe8PUc2i8zyMryewRAdviqcagCi/YfrfPjzMm6AyEGqPB7URGJolIr6w0" +
           "wdRtN5Y7LYotlxtu1ZY7WwNn6kMMj8UBWmoqeqkCx/O5T6X1vkVwsUbjouAi" +
           "/Lph1f2yNctgfUvAk7GJDNBmfxP2MiX0tlUKSc1td9oSF0iTigWWXMEleBSz" +
           "LPjtr9RoUTfEaJxWsa615tdlExkjZiNVnJDDrYphrIfSokLE8qDcDjy/OuNS" +
           "uj/U6Zoht7dI3xl5lckI3vICylM9FWmLraqSyLrfMgWj28JXPNFS2gOZJzza" +
           "0/F5M7NJnqnwATaaUPiaduccb40qiVZ125OZMk4yT8o6JDnlB6Uh3Gr0Omuj" +
           "NFwEy0pbwJLGJOy3zeVosqr5Tm8iuLIje7IzX6ds3YhhlbEGtDbEBTNdxXot" +
           "Mi0YVdVpaztfl0SLGlucK/SnFNMpDeQ2ZamG2JLThghzfay1qg7bXdTX+82U" +
           "7nQqXc+OyvVhIDBblfdDV1q31Dk5otyxxiuhZitsg+pr3c5kSpoSE6KOxklE" +
           "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");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "9Q7zEwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZe+zseFXv/e3e3buXZe/d97qyTy7o7uCvM53pdOoiu51n" +
           "22mnnek8q3Dp9D3T92PaDq4CkYdggMCCmMD+BVHJ8oiRaGIwa4wCgZhgiK9E" +
           "IMZEFEnYP0QjKn7b+b3vvUs2/uEk851Oe875nvM953y+53v6wveh82EAlTzX" +
           "ynTLjfbVNNpfWeh+lHlquE8zKC8Foaq0LCkMx+DeVfnxL1z64Y8+ZFzeg24R" +
           "obslx3EjKTJdJxypoWttVIWBLh3f7ViqHUbQZWYlbSQ4jkwLZswweoqBXnWC" +
           "NYKuMIcqwEAFGKgAFyrAxDEVYHq16sR2K+eQnCj0oV+BzjHQLZ6cqxdBj50W" +
           "4kmBZB+I4QsLgIQL+f8pMKpgTgPo0SPbdzZfY/BHS/Bzv/mWy793E3RJhC6Z" +
           "jpCrIwMlIjCJCN1uq/ZSDUJCUVRFhO50VFUR1MCULHNb6C1Cd4Wm7khRHKhH" +
           "i5TfjD01KOY8Xrnb5dy2IJYjNzgyTzNVSzn8d16zJB3Yet+xrTsLu/l9YOBF" +
           "EygWaJKsHrLcvDYdJYIeOctxZOOVPiAArLfaamS4R1Pd7EjgBnTXzneW5Oiw" +
           "EAWmowPS824MZomgB28oNF9rT5LXkq5ejaAHztLxu0eA6rZiIXKWCLr3LFkh" +
           "CXjpwTNeOuGf7w/e+IG3OaSzV+isqLKV638BMD18hmmkamqgOrK6Y7z9SeZj" +
           "0n1feu8eBAHie88Q72j+4JdfeuYND7/4lR3NT1+HhluuVDm6Kn9qecc3XtN6" +
           "Ar8pV+OC54Zm7vxTlhfhzx88eSr1QObddyQxf7h/+PDF0Z8v3v4Z9Xt70EUK" +
           "ukV2rdgGcXSn7NqeaalBT3XUQIpUhYJuUx2lVTynoFvBNWM66u4up2mhGlHQ" +
           "zVZx6xa3+A+WSAMi8iW6FVybjuYeXntSZBTXqQdB0L3gCz0GQefeBRWfc7+W" +
           "jxEUwIZrq7AkS47puDAfuLn9uUMdRYIjNQTXCnjqufASxP/65yr7GBy6cQAC" +
           "EnYDHZZAVBjq7iGsuDYcbvQKAgvTXgVpcyxlewAzVGeX9Pt57Hn/L7Om+Vpc" +
           "Ts6dA256zVmQsEB+ka6lqMFV+bm42Xnpc1e/tneUNAerGEEkmHp/N/V+MfU+" +
           "mHq/mHr/+lNfEeIlZYPM6OxudqUcCzLo3LlCkXtyzXaxAjy9BpgB0PT2J4Q3" +
           "02997+M3gSD1kptzZwFS+Mag3jpGGarAUhmEOvTix5N3TH+1vAftnUbn3Bpw" +
           "62LOzueYeoSdV85m5fXkXnrPd3/4+Y896x7n5ym4P4CNaznztH/87LoHrqwq" +
           "AEiPxT/5qPTFq1969soedDPAEoCfkQTiHUDTw2fnOJX+Tx1CaW7LeWCw5ga2" +
           "ZOWPDvHvYmQEbnJ8pwiIO4rrO8EaX8rz4XVgrd99kCDFb/70bi8f79kFUO60" +
           "M1YUUP0LgvfJv/mLf64Wy32I6pdO7JOCGj11AklyYZcKzLjzOAbGgaoCur//" +
           "OP+Rj37/Pb9YBACgeO31JrySjy2AIMCFYJnf9RX/b7/9rU99c+84aCKwlcZL" +
           "y5TTIyMv5Dbd8TJGgtlef6wPQCIL5GUeNVcmju0qpmZKS0vNo/S/Lr2u8sV/" +
           "/cDlXRxY4M5hGL3hJws4vv9TTejtX3vLvz9ciDkn5zvh8Zodk+3g9e5jyUQQ" +
           "SFmuR/qOv3zot74sfRIANQDH0NyqBd5BxRpAhdPgwv4ni3H/zLNKPjwSngz+" +
           "0/l1omK5Kn/omz949fQHf/xSoe3pkuekr1nJe2oXXvnwaArE338200kpNABd" +
           "7cXBL122XvwRkCgCiTIAuJALABClpyLjgPr8rX/3J39631u/cRO014UuWq6k" +
           "7AAFbBEgutXQABiWek8/s/Nukrv7cmEqdI3xu6B4oPh3E1DwiRvjSzevWI5T" +
           "9IH/5KzlO//hP65ZhAJZrrNRn+EX4Rc+8WDrTd8r+I9TPOd+OL0WnEF1d8yL" +
           "fMb+t73Hb/mzPehWEbosH5SOU8mK88QRQbkUHtaToLw89fx06bPb5586grDX" +
           "nIWXE9OeBZfjTQFc59T59cWTePJj8DkHvv+Tf/Plzm/sNty7Wge7/qNH277n" +
           "pedAtp5H9rH9cs7/dCHlsWK8kg8/s3NTfvmzIK3DomYFHJrpSFYx8TMRCDFL" +
           "vnIofQpq2Hz/WVlYIeZeULUX4ZRbv78r/HaAlo9IIWIXEugNw+fnd1TFznXH" +
           "sTDGBTXk+//xQ1//4Gu/DXxKQ+c3+XoDV56YcRDnZfW7X/joQ6967jvvL1AK" +
           "wA//sc7lZ3KpzMtZnA+dfOgemvpgbqpQ1AOMFEZsASyqUlj7sqHMB6YN8Hdz" +
           "UDPCz9717fUnvvvZXT14Nm7PEKvvfe59P97/wHN7J6rw115TCJ/k2VXihdKv" +
           "PljhAHrs5WYpOLr/9Pln/+h3nn3PTqu7TteUHXBk+uxf/ffX9z/+na9ep0S5" +
           "2XL/D46NXvUiWQsp4vDDThfaLJmk6UzjqrjONURtQUctliNkob0qD3SUnvQi" +
           "iQhFfb1lS8hC8L1wnUbbjTPDsipX2nIIKHv6Qtcn/K7QJWZCeR3UmHrf70wQ" +
           "07dIbIy2AmGNmAMK0SdiyA9m1akG+90uX6MDdTW3UUdBMATncKYxnYTVwVbb" +
           "oiHSwKvYVkXwRn3k+XJvOxljPa8mjJYuO6I9Zw2vZggpsWxP8dI2S3ujLbw1" +
           "MGq93CBuqTdRB+W6Hq3QStodR2unXGO3otWrV+fjhWJMzDk37FDIRhhsOpS2" +
           "kMXAs8b+IK6O1sGkM5grYzGWFkOGZEWk5UzN1E7w+pbKUNPSpc6g73QWI6/S" +
           "RUbJrDfxjWmkGq2w14yQBWOUm9mcGY4xbphWPAozOCmrjdvqxOLqiSv1B5gv" +
           "zMJxczVrpbRppuiWWc3lhtCsMOXpMjZgT0PGdgNec7XhcmqT44jWk7K4Xq/s" +
           "OdsRkC7i8qPOgp04HO/26npszGpMa8xNBN5e9oOWR3ibOq6Lgsz705QcMgm6" +
           "SAzYlnq+0283xkPPoazuIK7V+hZtbrm2YS5tRKjNdGyyFPBlvbaoL0qDTMkC" +
           "a8Pj2zTZBhPerUrKnOuTZbU73LYXYtOVBd0TF6sYGywqbrm+GhtUk+9MN6QR" +
           "YO5ouWHKM4XddjMCBNWMjw1h4YY4UcGbNNtBkMpMFEWNzRJrqC4bkqxLKjGN" +
           "MMKKLUPb1LjmCpDzTayZ9DDSYuq2UpmkLFAZH4UrMiWIFVE2Jt1kQ88kKap3" +
           "GixR96ghuyRQt5w0S2widnpIQlB9JOm6A0/Zzrv9eKtS4rrXdcfWZMP0xabf" +
           "dTFdSFf+ynXp8ahlRWLHNVR6i6ltzksb6ahRrplhTxxIlATzWTWR+qWsT9Nr" +
           "k0X0eah3sQXn0RjJSyVlZbKdJCqPFoKzrdVxbVPFl1WYWk5sUemKNo21e2bo" +
           "pnVWiRBUWxrBtOTWGorretKqUWrNZwIazxR/2RM8YUH76nq9KNna0LEyBYaj" +
           "OTk3R/BK4masIrgzV1wSzbTiW1KzrkspnnJjhNZHy2FS6VTYZXczWEnEvDzB" +
           "PBrljA4Ty8OBu/TbY3IiUY5W61OyzxGx5PZKy3gRbsqNNKtFpbXQ78Rxrz0w" +
           "OxM16dMbXK+qcjwMVCEirF5irqtKRAvl5ZzE1AnRRVOCLBkBO1lvaGKDOvy2" +
           "tKj2OzXLDttUc844VidxWzSP9gVzNpx3bTEUN91Y5IIUbnB1vFPi5G7Zbto8" +
           "I9BbB6nzuFXJmGoqBeiM2LYUMp7QRFab17mZO+pgLopu8Voqa5mztfShvtkK" +
           "ajddS4aEjOU4XiNtl55lWrcSOv4sU+0qly6IGdYzm1vZ2K7nTL+5GDfT9WBc" +
           "ElPC66jGokaUTUxRN5NhonJOXN8QaFsozV2VabaViUd2DH2QNcaD1iiolEWN" +
           "6XFIqbppGqSstjSmJaQUza6zVZ8eUwLijaiB309n400XnUq2MpJ8lcgQzdni" +
           "aIkdKTVja6AsMR3orU1DnXrj2LaYET2a+KYdwdWJs0XRkmaRwYJQs6A/cLJh" +
           "MHWYGcjIHj/zGiOjujC78GDDiy7lYr4u+8TGsHv1ZMkiTU1xayluOImNYouy" +
           "LnfQLEN1vQyj+GDTagSLCllLKJ6U+rDtUvI4hldeaFQ6eB2vDBoNfK1mUaSa" +
           "0xJnL/QpZQ0a0sJTVa401/BaXOXKjqWJw8G42UW6LQoU5xmz7orOsNNp43ZH" +
           "H6SbbV3jeUeLKs1ek0dbNRf3ey2lxhG1brPFkoMxlqYwX9W0+Titzk1iNpTE" +
           "KltpTabDsKc4neXMxwyxI6ONLqoT+sAlZpwdCm3abwrb0rompc2SoGHixnGS" +
           "yhJsEUI3XbAtql0fRE69pvd4WCY348UsgbV6c+AvTI9PKZInViSN+WFru4yi" +
           "XgYncjri51YVdhQtbcr6OGERbrPWO1WBMYhMaCluKZmnZISHK1lbpjTXIxML" +
           "L20mbG8yEXEUL3FTY1sqaV1EjoKt2QqVOjlgjZYAq8tWvVWKam55kZp0gmd4" +
           "lmhw1yfDeTIedOrtkTGvVUQ70YcqI8qrxGtGM41vjx14Im+mfbK2iYYm0jXG" +
           "GiWKLYMYVMls2O924zgq9ZQKSsY1DmzDPktjmFzmKwJVnvSbuZNSGqvhiGbD" +
           "HpV0fFOiK1WHSRe1CBQvtG2nJs/iI3a5iJu0TlkTn11JQUhoCBNJKxgtKbgB" +
           "E1Ms7Yzg9oTDfI8pCXRnVMY7zTE9k+cNrFLlq4GETzDXkrASb6L0rGoCGBat" +
           "uTCtpMRq0mLg2kCDS+t5BnOwFtB9oRdU6oN5mvQQxBeay5VrLFgToHplFFXI" +
           "bR3zgkk2rjYH2niWJZ12lOddjZ+TMMYgZVrbjrZ4m4j0YWNKT1BNIxkMwGdt" +
           "U192s0mIMli/EeiN9bS9mMNNbyU146i6Fje9kaX2ZzitJWV5Y4RNVFbZZTtF" +
           "HZ9ubYkUjZuC7QcRAH3C6dCzJr4mVcpv9KlGfxFlGkJVRjjcUKwZsfRLVmyk" +
           "Ys0wtHg4i3hWWAqTFikZrMuQFctvMH2eFvrxCGnYIjVHFxsYgasWgcX9Ib2a" +
           "9kHIZw2SnwNE1AbKhOeYdVIe4JJk4/5c8xKlROHdtE4yo9YijFHD6PSV9spd" +
           "KUObm1Zr3nQuUMZUU+erTaVdU4ZJ1ZylekZVNFbd9KjAbrntyE9oJplwfl9w" +
           "u92GUZpxLD4Usg5JiC05TNYEZvKtWKhvwCaBLsyg29eM0QjT6mWflmZGm8U3" +
           "OGYmakUbTeVSPOb9rByS7RWawcvaXOxPmmN43h1pXUKHVZshvX6lao3HM6QU" +
           "hMtRMNaWc9tRSV7RkWzNk90sU4Qui9VoZjR3pFkzopNy3bSoqrbBVttGFDu9" +
           "eqM1GaFNdphRfErXsbXHDwW0qs9izmMpuaf51ZWkDw0rKKm8oGyqjWE97aMp" +
           "wk83VhxlfcNhqqXF1iLr1bHhk2t2kHDxmiOqGwXRNvrKoitth1qvkdgf4dVM" +
           "1HsuC3YWy6rbmJL2e4MSVps6PKXGDFXNBG9mwK43V9C5TypMxjNkVeaQVs2k" +
           "OvUuJTlmNRsg4dTPCERPtRI4mdB4ttR9b6Lw/TQy1IEtVBJJ27gkOnCNnkbB" +
           "jaba3mIwatTUSbuhz6WBmuDJVp2RLjmp+BO5OhMrbdNy7G17PqR6FhHEJVEc" +
           "apRbHacztNnhUmISwK1G3caH2LaTEEReyr/5lZ2m7iwOjkevD8AhKn9AvoJT" +
           "RHr9Cfci6DYvcCNw0laVYt7jVlTRhbjnsBF9+HuyFXXcnzh3eIR9+roN2E4a" +
           "qU5oLi312v7r6b5rfv566EbvHoqz16fe+dzzCvfpyt5Bf2gOjtsHr4RO6hNA" +
           "T974kMkW712OmxZffue/PDh+k/HWV9CKfeSMkmdF/i77wld7r5c/vAfddNTC" +
           "uOaN0Gmmp043Li4GahQHzvhU++KhI/fcn3vjIWDq+w7c877rt0Ov6/dzRaDt" +
           "wutM721vFxhFgB169Z7cq0lVLpzZduU491jBnbxM5+5t+RAA98iBKkXqobC7" +
           "Two78P5xEIc/6Sh8qkUWQfddv39/OFnlFb8QAJHzwDWvKHev1eTPPX/pwv3P" +
           "T/666H0fvfq6jYEuaLFlnWw6nbi+xQtUzSxW5LZdC8orft4dQQ/eWLsIOl/8" +
           "Foa8a8fx6weeOMsRQTeB8STlb0TQ5bOUQGLxe5LugxF08ZgOuGp3cZLkw0A6" +
           "IMkvP+Jdp1O169Ol505k3wHaFP686yf584jlZBs9z9jidfJhdsW7F8pX5c8/" +
           "Tw/e9lL907s2vmxJ220u5QID3bp7o3CUoY/dUNqhrFvIJ350xxdue90hlNyx" +
           "U/g4b07o9sj1e+Yd24uKLvf2D+///Tf+9vPfKhpn/wtftZOU5x8AAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "LDcLnPkTAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "stTru64n+63Zueuhm71xyM9cn3znc88r7KeQvYO+0Awcsw9eBB3Xx4eeuvnh" +
           "spe/bdk1K77yzn95cPLGxVteQQv2kVNKnhb5e70XvtZ+nfyhPejsUeviuvdA" +
           "J5munmxYXPTVMPKdyYm2xUNH7rk/88ZDwNQvH7jnyzdug97Q72fyQNuG16me" +
           "2942MPIAO/TqPZlX47KcO7PpylHmsZw7fpmO3Vuziw/cI/uqGKqHwu4+LuzA" +
           "+7sgDn7aEfhEawyodqOu/eFUyCt+CQDi5oHrXktuX6XJn33+0oX7n+f+Ou94" +
           "H73uuo2BLmiRZR1vNR27P+/5qmbk63HbtvHk5V/vDqEHb65dCJ3Lv3ND3rXl" +
           "+PUDP5zmCKGz4Hqc8jdD6PJpSiAx/z5O94EQurijA47a3hwn+RCQDkiy2w97" +
           "N+hPbbtzyZljuXeANbk37/pp3jxiOd48z/I1f4V8mFvR9iXyNflzz3f6b32p" +
           "9qlt8162xDTNpFxgoFu37xGO8vOxm0o7lHWeevLHd3z+ttceAskdW4V3WXNM" +
           "t0du3Clv2V6Y97bTL97/B2/4nee/nbfL/hcSIbGX2x8AAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "NMd10P0TAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "BC5IQfkTAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "XYg+8J+COX3nP/zHdZuQIcsNzupT/BP0uY8/WH3jDzP+XYin3A8n1+MzTPB2" +
           "vNinrX/be/z8X+0ht06Qy+pB9jhUzCgNnAnMmILDlBJmmCfGT2Y/26P+6hGE" +
           "vfI0vByb9jS47M4F+JxSp88Xj+PJz+DnDPz+T/pNtzvt2J65d1UPDv5Hj05+" +
           "103OwGg9h+2T+/mU/02ZlMey9kra/OLWTOnja2FYB1naCjlmhq2Y2cRPhdDF" +
           "TPXKofQhTGPTI2hhkpmYe2HinrlTqv3+NvfbAlraYpmIrUuUbuo+v7ylyk6u" +
           "O3bCOAemke/7xw9+7QOv+h60aQs5t0r3G5ry2IydKM2s3/3cRx562TPff1+G" +
           "UhB+xI8yl59KpXIvpnHaMGlTP1T1wVRVKUsJOCUI+QxYgJZp+6KuLPqGBfF3" +
           "dZA2ok/f9b3lx3/wmW1KeNpvTxGD9z7zWz/bf/8ze8cS8Vddlwsf59km49mi" +
           "X36wwz7y2IvNknHU/+lzT//p7z/9nu2q7jqZVjLw1vSZv/vvr+1/7PtfuUGW" +
           "covp/B8MG77sLxt40KQOP/xQnmLxIElGMwFFac3ZoPNRvhrLNOkIXBfbeF2n" +
           "o+TpZkwvN3wOkyXMDZZJuFnZI3JdFHIbAYNpT1uqS1UMM9uUs3Qn47hFtD1m" +
           "gBme2SBbqj50pUnPWk67XrPOuO0i4c5y3diddY1VieTJDhmRWrFXcsVw3Nuo" +
           "m86qGCQkuQFopSyPpwTFJvlppd4KlL7fKklusrRWsz7WUJodK5knmyXjJHYB" +
           "K5ZxNceNplBOYjYWddbnZEzjky458ZJOTSWm3VFYyLO1yRDX42VP4P38YpIY" +
           "NYyzRsRkQOhTLS9zhQ49tOXChI2Yqk6yWtfFZH64EiNnzYO5I49cVXILDUaZ" +
           "9LSBzOp11h1yfWfG1XUttCi8w2tmtVzP1Za85o06eN0IonycN90+vASzxgIQ" +
           "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" +
           "HwAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "U+dw9xMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "sgvRB/6TteV3/f1/XLcJObLc4Kg+xS/Cz33iQexNL+T8uxDPuB9Or4dnkN/t" +
           "eMufcf5t7/Hzf7oH3SpCl5WD5HEi2UkWOCJImKLDjBIkmCfGTyY/25P+6hGE" +
           "veo0vByb9jS47I4F8JxRZ88Xj+PJj8HnDPj+T/bNtjvr2B65d2EH5/6jRwe/" +
           "76dnQLSeK+/X94sZ/5tzKY/l7ZWsed3WTNnjz4CwjvKsFXDopivZ+cRPxcDF" +
           "bOXKofQJyGKzE8iy67mYe0HenrtTpv3+NvXbAlrWlnMRW5eo3tR9fm5LlZ9c" +
           "d+yE0R7IIt//Dx/6+gdf/W1gUwo6t8z2G5jy2IxMkiXW73nuow+94pnvvD9H" +
           "KQA/3Mfwy09lUumX0jhr8KwhDlV9MFOVzzMCWorifg4smppr+5KuzIWmA/B3" +
           "eZA1wk/f9e3FJ7732W1GeNpvTxFr73vmV3+8/4Fn9o7l4a++LhU+zrPNxfNF" +
           "v/Jgh0PosZeaJecgvvv5p//gt55+73ZVd53MKnFwafrsX/731/c//p2v3iBJ" +
           "ucX2/g+GjV/xJ51K1G0efvoTQZ+uxmk61VmkMWdRUReoGOuzTW3StorxvGIE" +
           "7XHcnHLNRjflmICMpRndryv1KpHAcTtMNo3Y9nnPGg/syDfnFCXxM5QokWMT" +
           "E4c2bzUo1Jj4vDh0FvIg6Jc7TigFhYUzXFkFg9BLtX6dqSd1FRlWA1hKXKcK" +
           "/GhJuQjiNAr1SnE5W/QZy0NqvZFQcsnRxm5bFMMW3EgrDmTValpuvzu0uCBG" +
           "Gkg14pnZhtetHkf2VH6aojXBNMrryVojq4u1Ecuh3yfXQdq2u2ZfnPkkYuKd" +
           "aNpvFNd+CUPq3moa9MiQNZIN0+8SbadfN0ZeKtQlTR0uxMZwsIqxij0K2G5x" +
           "bda9OdUG8wRTd1CY0lhN7hMrqVunCY9udLpCbRzpK5oQFd+Ie7yrC2OGINVS" +
           "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" +
           "xr75hmVYPI01NzJlW7u+Cnuy9prdwR662RuI/P71qXc986zKfrq0d1AjmoEr" +
           "98GLoePrCaEnb37R7OdvX3aFiy+/618eHL3JeNvLKMc+cmqRp0X+dv+5r5Kv" +
           "VT68B509KmNc917oJNPVk8WLi6EWJ6E7OlHCeOjIPPdn1ngIqPrCgXleuHFJ" +
           "9IZ2P5M72ta9TtXf9raOkTvYoVXvyay6QpTcmG1PSTKL5dyrl6jevT1rQmAe" +
           "JdSkWDsUdvdxYQfW3zlx9JOuwyfKZDH0wM2q+IfTlV72iwHgOw9c96py+3pN" +
           "+dyzly7c/+z4r/IK+NErsNto6IKe2Pbx0tOx5/N+qOlmvie3bQtRfv7znhh6" +
           "8Oari6Fz+W+uyLu3HL9yYIvTHDF0FrTHKX8thi6fpgQS89/jdB+MoYs7OmCs" +
           "7cNxkg8D6YAke/yIf4N61bZal545Fn8HeJNb9K6fZNEjluPF9Cxm89fKh/GV" +
           "bF8sX1M+/yzFvP3F2qe3xXzFljabTMoFGrp1+17hKEYfu6m0Q1nnO0/86I4v" +
           "3PaaQzC5Y7vgXeQcW9sjN66c444f57Xuze/f/7tv+M1nv5WXz/4XvKL0J+8f" +
           "AAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "1k/pfwE/YPuMARQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "gNykQqVe9shhkOrBbOQyxijBNjg7kaRRH5GxhVBoIwEcsSYWrVBsMSyi40VA" +
           "EWWEwswl2em3R15rsuiM2914bA0ih/cmawNdtRotgx/B3rAn9vymK6JVrSHI" +
           "6niyKTFkTEllI/L4igcTdUYcledDn+w3yxUhbGmpQOqavUYMZmrg3mwUdgqV" +
           "rjGBFYdPagWHRPGaoiGWPfHccAy3NK/TpRtUyGqTNt0lwoj3ZyZhFcWQ0riq" +
           "EWqVfsS16ZojL5fl5WK9aDY6m1KVIOeEGQWkqvW6moWiAt6j6XA1X1Xqmyic" +
           "mikbt/pLoS1rHi2nnaTaqVN6ccCvpXjB1MTJcu1bZb8+Ua3eykEpGqvX6TYy" +
           "7TaTyBQFrz8mGKeOUcRwIDJVZ6IxBakuE5XmpuE0K5vQoca4ZVFIOygMWwTI" +
           "Sm3KHQyno6XU5dS62bKnROIMQZS2sJE7bVR9HZdqstEqexrPpQQWFPmJVobh" +
           "vrmckMiqOJrTBGXX2TJDW3DIjdeDyCyWSGJIa2nXSEw1Wk4FWF7jCFKYSm7g" +
           "NbvpaoyQU4rnaJQT6bBaiAbFtK/Gi5bMbeQGXmWCqE1PQpzB+u3mKh1PZbpL" +
           "ldlCmaVXYxyuVjvsKi11Jv2u6E2lMG5izaUcTrxJv6jV7LJB6EHqOKjOWZQX" +
           "o1Sh1UOb6sopGUD8ZjCR4oAf+iOSrBilhEQ2k3oyl7hJaYhUUamsSi5v2xyN" +
           "9IhJU64WGwKxsGstzIDRaQ3b8M2w7BXrE5+kxv1N0RSnkaTq5WE8tglNxMig" +
           "xo0CpwWjk2qf6kjecj0X6sSyHVjSpNVbdokUpLFtviEpvNVYlyeuhkcdXE/x" +
           "6hArF6ejbk+o1ghrwKoujIrzriq2LVYXWky/qFDDVQsPgTvOlkTq6XZpXFwi" +
           "ZZyNmlhj0yz0y8UZSVkt3+3HlZ7ID+KQp4L5bFMIBYouINRyQXEs46FlucsN" +
           "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" +
           "v/XcN/Ja2v8CMGd4RAEgAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "9RMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "rcBSaWS4oa06xo0F2JN11+z+9fCtXj7kd69Pv/u553X+M8jeQX1oBK7bB++E" +
           "jusTQE/d+pLJ5S9edkWLr7z7Xx4avnn6tldQin30lJKnRf4u98LXWq/XPrIH" +
           "nT0qYdzwSugk07WThYtLgRHFgTs8Ub54+Mg9D2TeeBi45cKBey7cvBx6U7+f" +
           "yQNtG16nam9728DIA+zQq/dmXl1hWu5MgMdx5rGce/Uylbu3Z00A3KMFhhIZ" +
           "h8LuOS7swPu7IA5/2lX4RIksgh64RQH/cDbkFb8SAKHz4A0vKbcv1rTPP3/5" +
           "4gPPi3+dF7+PXn7dzkIXzdhxjledjj2f9wPDtPMluX1bg/Lzn/dG0EO31i6C" +
           "zuW/uSHv2XL82oErTnNE0FnQHqf8jQi6cpoSSMx/j9N9KIIu7eiAr7YPx0k+" +
           "AqQDkuzxo/5NSlXbQl165tj2O4Cb3KF3/zSHHrEcr6NnWzZ/oXy4veLtK+Xr" +
           "2heeb3ff/lLlM9s6vuYom00m5SILXdi+Ujjaoo/fUtqhrPP0kz++84u3v+4Q" +
           "S+7cKrzbOMd0e/TmRXNq4Ud5mXvzhw/8/ht/+/lv55Wz/wWV5vFV6R8AAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/wIRcqTv/RMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "01C1A0My1Wubsaf7r/k57KEbvYgozmCffvdzzyvjz5T3DvpES3DsPng/dFIf" +
           "H3ryxodNungJc9y8+Mq7/+VB9i2rt7+CluwjZ5Q8K/J36Re+1n2D/JE96Kaj" +
           "VsY1r4dOMz11uoFx0VfDyLfZU22Mh47cc3/ujYeAW+49cM+912+LXtfv54pA" +
           "24XXmR7c3i4wigA79Oo9uVcTVC6cSThylHus4E5epoP3jvziA/fIviqG6qGw" +
           "u08KO/D+cRAHP+1IfKpVFkKveZlm/uGM5Vf8igCEzwPXvLTcvWiTP//8pQv3" +
           "Pz//66IRfvQy7LYhdEGLTPNkB+rE/S0uqLyNYllu2/Wj3OLnvSH04I21C6Hz" +
           "xW9hyHt2HL924I6zHCF0E7iepPyNELp8lhJILH5P0n0ohC4e0wF/7W5OknwE" +
           "SAck+e1H3eu0rXZNu/TciRQ8gJzCqXf9NKcesZzsqedpW7xgPkyxaPeK+ar8" +
           "hef7o3e8hH1m19OXTXG7zaVcGEK37l4vHKXpYzeUdijrlt4TP77ji7e9/hBP" +
           "7tgpfJw8J3R75PoNdNJyw6Llvf3D+3//Tb/9/LeLLtr/Ao86iDr5HwAA");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MH968N929zKuzyQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aqv85+fy5PMXgP+Vgtmv5ck/vACmf3pB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2W/myVfz5JWdJBfQ/laye/+dC2h+O08+FpWuKoEmRdpR3zmE/ZnXiZknqIux" +
       "+G+93unLSQF2yBw5w9vzzKfBc/PAGW6+NYPHHcdzjGLqIB8q9+ipU82D0SIP" +
       "ugWbr59hc9Kct1RmRkSiaH4+PheV/0WefC0qPbDD9exQ9PbzWj5G8Z+/CRQf" +
       "PkTRP0DRf0tRvL1jnByCD1U6xrzg+R8v8MQ/yZNvHHkisTtfpvmjKHgSsoPS" +
       "Y8ReexOIPZln5lPATx4g9sm3BrGT2v2PC8r+LE/+W1R67LSvEBuQ8LHvg6h2" +
       "CELlXNS1nDLcv23FAqH//iYQejTPfBY8nz9A6PNvDUJnutRTF/oU7alFx9zb" +
       "uz2We5fzzL+ISg8deNE5GL73IgzPx+4v3wR2+Wy4hIIh4vqu7u79PWJ3PBB1" +
       "Xs/F9h68oOzhPLkPxJ2lFp17fUM8Unbv/jeibBKVHjn/umh+9+3RW26w725d" +
       "K1968erd73xx8q92c9rDm9H3UKW79di2T15VOvF9xQ803SxwuGd3cckvlHsM" +
       "dJ3b32YFs5PinYu+9327Go8fROCzNcB0DKQnKZ+MStfOUgKOxfsk3fWodO8x" +
       "HZjx7T5OkrwHcAck+ecP+BevZIDA+SXcWzBN9k6vTI8c9KHXs9mJxez1UyuV" +
       "4l8RDpeL8e6fEW4qX35xQP/4d5qf290MVWwpy3Iud4NFxe6S6tGS86nbcjvk" +
       "daX/vu8+8Mo9zxwujx/YCXzs9Sdke/f51zAJx4+Ki5PZb7zzKz/8+Re/UVyp" +
       "+b8hcYGOIzIAAA==");
}
