package org.apache.batik.dom.svg;
public class SVGOMFEImageElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEImageElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(XLINK_NAMESPACE_URI, XLINK_HREF_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XMLSupport.
                                                 XMLNS_NAMESPACE_URI,
                                               null,
                                               "xmlns:xlink",
                                               org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "embed");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMFEImageElement() { super(
                                        );
    }
    public SVGOMFEImageElement(java.lang.String prefix,
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
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_IMAGE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
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
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEImageElement(
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
      ("H4sIAAAAAAAAALVaaXAcxRXuXd2Xddmy8CFfMsTXLmeIkTHIsoTlrI6yhAMy" +
       "WIxme6XBszPjmV5pJXDCkRROqKKIYwzhcCqUiQMF2EmFIpBAHEgAF5DiykEI" +
       "R5EfIRAKXKkAFQjkvZ6ZnWN3RohCqprWbHe/1/2+/vq9Pubed0mJoZMWqrAY" +
       "m9SoEetUWL+gGzTZIQuGMQh5w+LNRcK/d77Vuz5KSofInDHB6BEFg3ZJVE4a" +
       "Q2SxpBhMUERq9FKaRIl+nRpUHxeYpCpDZJ5kdKc1WRIl1qMmKVbYLugJUi8w" +
       "pksjGUa7LQWMLE5AT+K8J/F2f3FbglSLqjbpVG92Ve9wlWDNtNOWwUhd4nJh" +
       "XIhnmCTHE5LB2rI6WaOp8uSorLIYzbLY5fJZFgRbE2flQbD8aO0HH984Vsch" +
       "aBQURWXcPGMbNVR5nCYTpNbJ7ZRp2thNvkmKEqTKVZmR1oTdaBwajUOjtrVO" +
       "Leh9DVUy6Q6Vm8NsTaWaiB1iZJlXiSboQtpS08/7DBrKmWU7FwZrl+asNa3M" +
       "M/GmNfH9N++s+3kRqR0itZIygN0RoRMMGhkCQGl6hOpGezJJk0OkXoHBHqC6" +
       "JMjSlDXSDYY0qggsA8Nvw4KZGY3qvE0HKxhHsE3PiEzVc+alOKGsXyUpWRgF" +
       "W5scW00LuzAfDKyUoGN6SgDeWSLFuyQlycgSv0TOxtavQwUQLUtTNqbmmipW" +
       "BMggDSZFZEEZjQ8A9ZRRqFqiAgF1RhYEKkWsNUHcJYzSYWSkr16/WQS1KjgQ" +
       "KMLIPH81rglGaYFvlFzj827vhhuuULYoURKBPiepKGP/q0CoxSe0jaaoTmEe" +
       "mILVqxMHhKZH9kYJgcrzfJXNOg9eeeL8tS3HnjLrLCxQp2/kciqyYfHQyJzn" +
       "F3WsWl+E3SjXVEPCwfdYzmdZv1XSltXAwzTlNGJhzC48tu2Ji6+6h74TJZXd" +
       "pFRU5UwaeFQvqmlNkql+AVWoLjCa7CYVVEl28PJuUgbvCUmhZm5fKmVQ1k2K" +
       "ZZ5VqvLfAFEKVCBElfAuKSnVftcENsbfsxohpAweshSeVcT8OwUTRobjY2qa" +
       "xgVRUCRFjffrKtpvxMHjjAC2Y/ERYP2uuKFmdKBgXNVH4wLwYIxaBUk1HTfG" +
       "gUrbL+jr6ersTgML0C+gq0WiabPfRBatbJyIRGAAFvmnvwwzZ4sqJ6k+LO7P" +
       "bOo8cf/w0ya1cDpY+DCyFlqNma3GeKsxaDUGrcYKtEoiEd7YXGzdHGkYp10w" +
       "48HlVq8auHTrZXuXFwHFtIliADkKVZd7Qk+H4xZsXz4sHmmomVr22mmPR0lx" +
       "gjQIIssIMkaSdn0UfJS4y5rG1SMQlJzYsNQVGzCo6apIk+CagmKEpaVcHac6" +
       "5jMy16XBjlw4R+PBcaNg/8mxWyau3v6tU6Mk6g0H2GQJeDIU70cnnnPWrX43" +
       "UEhv7XVvfXDkwB7VcQie+GKHxTxJtGG5nw5+eIbF1UuFB4Yf2dPKYa8Ah80E" +
       "mGDgC1v8bXj8TZvtu9GWcjA4peppQcYiG+NKNqarE04O52k9f58LtJiDE3AZ" +
       "PDutGcn/Y2mThul8k9fIM58VPDacO6Dd8Zc//PMMDrcdRmpd8X+AsjaX60Jl" +
       "DdxJ1Tu0HdQphXqv3tL/g5vevW4H5yzUWFGowVZMO8BlwRACzN95avfLr792" +
       "6KVojucRRio0XWUwuWkym7MTi0hNiJ3Q4MlOl8D7yaABidN6oQIUlVKSMCJT" +
       "nFuf1K487YF/3VBnUkGGHJtJa6dX4OSftIlc9fTOD1u4moiI0deBzalmuvRG" +
       "R3O7rguT2I/s1S8s/uGTwh0QHMAhG9IU5T6WcBgIH7ezuP2n8vRMX9nZmKw0" +
       "3Pz3TjHXKmlYvPGl92u2v//oCd5b7zLLPdw9gtZmMgyTk7Ogfr7fP20RjDGo" +
       "d+ax3kvq5GMfg8Yh0CiC1zX6dHCRWQ85rNolZX/97eNNlz1fRKJdpFJWhWSX" +
       "wOcZqQCCU2MMvGtWO+98c3AnyiGp46aSPOPzMhDgJYWHrjOtMQ721C/n/2LD" +
       "4YOvcaJpXMXiHLmqUE0LPCmLXKnCkwjTU3i6GpN1NmFLtcwIrNl9bK0MUegb" +
       "16jl4vF3MyzAuTG4uIqZiyu7YGXBANM+Al4L0NysihmMLLy33SHU6cNkEy/6" +
       "GiYdZs/bviD8mNGumQULeSbukxZ5ghXfADn+8p4Xz/7j4e8fmDCXUKuCg4RP" +
       "rvm/ffLINW9+lEdjHh4KLO988kPxe29f0LHxHS7v+GmUbs3mB36IdY7s6fek" +
       "/xNdXvr7KCkbInWiteHYLsgZ9H5DsMg27F0IbEo85d4Fs7k6bMvFoUX+GOFq" +
       "1h8hnAUHvGNtfK/xBYV5OC4b4IlZ9Iv5+Rwh/GVHYUpH8TUGvDb4tsbH67kh" +
       "ihlpzKblQV2QWLfCg1ludIC+X8mjL5+wm1WYPrAfTdIs7InRyzrTjfPzkun4" +
       "eWGuhwsxtxOejVYPNwaYnipsehE3HRPYoJSkJEWQfeYvCFEO6yDXRh0iJm74" +
       "qG7bvy5wfdheQMoHwujnB4EvCnBp3mf1sy8AhN0mCJisyQ+1QdKMFIPLTtlW" +
       "TbPqbVekNG5LTE/mM0qfoVEd8Axa3RoMMGoq1KggaWCuZh7F0HZDg/m5Dalr" +
       "27j+89nYn6/BZ/AVMzT4XHgutrp8cYDB14YaHCTNyEngbakODMezBr5t2kZ3" +
       "ZySdJqcnrMfsTaoqU0HxmfrtEFOzTpc7c13mf6UWdW0K50VNM8JE7C4uwy5O" +
       "nCG6e+bdaOEiZnHQUQE/5jh0zf6Dyb67TjOjUYN3+92pZNL3/el/z8RueeN4" +
       "gT1fBVO1dTIdp7KrdzXYpCf+9fBTFCeYvDpn398fah3dNJN9Gua1TLMTw99L" +
       "wIjVwSHV35Unr3l7weDGsctmsOVa4oPTr/LunnuPX3CyuC/Kj4zMKJd31OQV" +
       "avPGtkqdsoyuDHoi3Arv3DgVHtWiiuqfGw4ZgyZGkGjIwulHIWU/xuRWRhZK" +
       "ORfeLssJCbyB7dwNI3St069LaRAdt46i4nsaXt91+1v3maz0L2x8lene/d/7" +
       "LHbDfpOh5uHeirzzNbeMecDHu15ngvMZ/EXg+RQftAsz8D8sXzqsU6aluWMm" +
       "TcOJtSysW7yJrn8c2fOrn+65LmrhtA/Cx7gqJR1HcduXsfzk+Qdyo1yNZWuw" +
       "ljXKEyEEKbCkL9N0aRzM9AX/qhCNIdx4MKTsIUyOMtLs8MZLGiz/iYPWz2YB" +
       "rQYsww3QtZZt104znTq9sFSGiIaY/ruQsicw+Q0j1aOUJVRRkHst57DVgeLY" +
       "LECxGMta4bnesuf6mUMRJBpi7vMhZS9i8gxwEqDY4lp4FQp93tWWA9WzswDV" +
       "aixDffsse/fNHKog0RA43ggpexOTVxhpAqgKLMZs5GIhyAWJcRj/NluTbxE8" +
       "t1lY3DZzGINEQ6B6L6TsBCZvM1IJMF7Uk8Bdq2/qvTMLQPBjGFzz3WlZc+fM" +
       "gQgS9RkbMf08N4pr/SQEjU8x+RDQMDxouHzyR7NFC/RGd1sm3T1zNIJEg42N" +
       "VISUVWFSzEiVSQsDNgY+lxwpmS1e4I3TUcucozNHIkh0Gl5EmkLgaMakHuAw" +
       "vHA4xIg0zAIcGKfJOfA8bNn08MzhCBINsXZFSNlKTFoYWQTE6JxuU7k8xPla" +
       "O0kHwCWzAOAKG8DHLBQemwbAApuHINEQkE4PKTsTk3WMzAcAg86C0g4qsVlA" +
       "pRHL8HDruGXa8ZmjEiQaYvl5IWXtmJwDCx+FTvTC5tZmUJ2bQbkCjkzbLCCD" +
       "12tkPTzPWeY9N3NkgkRDrO8NKevHpBs2DcAX/2lr7gR1xIFl65dyws9IY4GL" +
       "bLx+ac77YMb8yEO8/2Bt+fyDF/6Zn3PkPsSoTpDyVEaW3YfZrvdSDVa5Eke1" +
       "2jza1rjVF4HBQSdSjBRBil2PfMOsvYORuYVqQ01I3TV3WpRy12SkhP931xNg" +
       "DeDUY6TUfHFXgW13EVTBV6rZfD1vmu8CJBlcZm7nPMAEJSnoSWcHmDVPuxa6" +
       "x4evO+ZNN6w5Efd1LB488O+g7NObjPkl1LB45ODW3itOfPUu8zpYlIWpKdRS" +
       "lSBl5s00V4onQMsCtdm6Sres+njO0YqV9r6/3uywM1UWupZY7RB0NSTSAt9F" +
       "qdGauy99+dCGR5/dW/pClER2EByLxh35lypZLaOTxTsSzuGb6zs6foPbturW" +
       "yY1rU++9wq8CCR4lei6r/PWHxZcOX/rivuZDLVFS1U1KJLyn4Lc9myeVbVQc" +
       "14dIjWR0ZqGLoAUcdjcpzyjS7gztTibIHOS8gJsxjosFZ00uFz8mgJiYf1ST" +
       "/wlGpaxOUH2TmlGSqKYmQaqcHHNkfIdoGU3zCTg5uaGcm2/7sLj5u7W/vrGh" +
       "qAvmrccct/oyIzOSO6Bzf7PFM8yTJUwOZ3GcYWIMJ3o0zT5UKvvUvIeNTJh1" +
       "MJ+RyGrrdta7GotM8dk1yV8xufL/6i3wLI4pAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iSO4a7mu0+dux/j/wy3gfzHPzOt9YYf/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("C289/j86p+xP8uQPE+gxgP8ax2+H7Ng/hx3Xq1bw5r/fqu4/BZ6f2vHmp956" +
       "3vzZOWV/kSffS6B7AG+mNJUfXZ3R/DduAV1xZyWfRX92h+5n3xp0e8cEnZxg" +
       "b+/6EPeKKOIvAcT4FMQTzuuvblWAuYV/ZQfxK2+5APfuO6fsUp7clUBvOxBg" +
       "HKraGd+1d/etSjC/Uvr1Hbyv/w1J8O3nYHxHnjwCMManMR6LcO/RW8CYTz3Q" +
       "+8DzKzuMv/LWi/Dd55S9J0+eTaCngAixGx3BP3+Ol9qdux9z5blb4Mq7Drny" +
       "Gzuu/MbNcuWGkdhe7ZyyRp7sJ9DjgCvXu9UyO4YK3wLUh/PMJ8Hz+g7q6289" +
       "1A+dU5avXPbeByZo31gzgW4cyvqBk7I+KijgvnQLcPNrtFAbPL+7g/u7bz1c" +
       "+pwyNk8IEFsCyZ69vHV0IWt6jJW8qZt/CfTwNa5055dTn7jqryMHf3fQfumV" +
       "S3c9/orwn4pbzUd/Sbibgu4yU9c9eR/uxPvFEIRSdsGIuw9ux4UFOhEAu941" +
       "mQS6DaT5mPeEA2o5gR65FjWgBOlJyo/s9OEkZQLdUXyfpLsCZrpjugS6ePBy" +
       "kmQGWgck+asWHirbh25wQ952gWc6ursxAWs7XY304wXB5mAOfuKkzhWz60M3" +
       "Et9RlZN3qfPVbfGPoMOVaHrwn6Ar2tdeGTA/8kbz5w7ucmuummV5K3dR0J0H" +
       "18qLRvPV7HPXbe2wrYvEC9+//+t3v/tw5X3/wYCP9f/E2N557VvTmBcmxT3n" +
       "7J8//k/f//Ov/EFx1+f/AeqNbCaqNQAA");
}
