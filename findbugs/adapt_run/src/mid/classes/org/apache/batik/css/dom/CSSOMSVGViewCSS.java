package org.apache.batik.css.dom;
public class CSSOMSVGViewCSS extends org.apache.batik.css.dom.CSSOMViewCSS {
    public CSSOMSVGViewCSS(org.apache.batik.css.engine.CSSEngine engine) {
        super(
          engine);
    }
    public org.w3c.dom.css.CSSStyleDeclaration getComputedStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        if (elt instanceof org.apache.batik.css.engine.CSSStylableElement) {
            return new org.apache.batik.css.dom.CSSOMSVGComputedStyle(
              cssEngine,
              (org.apache.batik.css.engine.CSSStylableElement)
                elt,
              pseudoElt);
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MBQZo/Q/7RHCIXITAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vDDYXrdAiQNwUaYX3RmBLfqE78tKW6virNpLZlY6bNhUUyiEtc1o3RCiaGSH" +
       "7nwVL+xpNC7gmu7a6KxHUQFWMDU9KhlNa+bYzIqGjXiiVjpjzJKdCpNqo3EP" +
       "a6ao70/jQKXcwTyKNnDo1/rtQd/sEbQ5pCys6cm+z8jppqBQrT4QvzfsYY2l" +
       "idTJ0VrkGsN1eyXotl/HpSIYTph6jVzjLVwYqSyFVHCkEGN631t3G32zglP9" +
       "xdjSN3jkslR50rGbyHSoloQlwREuN9zg1KZM2fORiCzwJjJZLqvLgKn6i4aN" +
       "OeGMGZbksosP/ZZYNxeh3OjOas1xxfJX7HAhydN5kXOciifQAPy7K3SDESwx" +
       "LI1Hy2acTgtie2O1dNMpIRPYraQhPHTplbxk6yDdmUSThokGdRtT+l6lWG6t" +
       "ELlvUgicVYVHK9RYFQmKNNCgRkSVeW9U9Je1Eir2hVJ/WSRFnWy3iOWgISRr" +
       "YV6spIjqlYRufSCCbBjGhlSDntICeES9O0vNr/10t6M784vgwasAcCnKJpif" +
       "4lawnXosa548KDXln7Mny8dHS02HFQUou+k8dLMKf37L+czzL7+i9j5b2tmr" +
       "xIgRdCHy/HfZ2kqzj7DKbptP3/xG181fcBxWCL76/L88KLzHfPanqJI+cuKc" +
       "J1n+bvfVr7ffrvz6DnT6oF5w3auX44uuHq8SXASpVBy4wrFawUMHmn0k0xgM" +
       "vrt7mt29caXyhl5wKveCre1PFLp2coKd/QLA3VnJbF1R8vp19hpPc/MSH5Mv" +
       "jt+iSrbJGnC7vGxoUVZhiCNN5aONre2zfuIo66wQ1+D5nKAJtJXVM/ctkLve" +
       "8iddSI8VqiLo0olie1Y5fOC6l3zbF1PKF165dP7+V0Z/ndebD14eXWCh83oM" +
       "bh5HSjdH+mf9QNOtXNYL20KOn/88H0EP3OwVQASdBm1+3g9uqT8UQffciBpQ" +
       "gvYo5QtAlycpI+hM/nuU7qMRdPGQLoLObjtHSV4E3AFJ1v2Y/9bV0YP3Fnt6" +
       "TE4dD9kDA931kwx0JMqfOBab+Rva/TiKt+9orylffIXh3v9m9bPbWjrwiDTN" +
       "uJxnoXPbsv5BLD52U277vM5ST/3oji9deHIfN+7YHvgwQo6c7ZEbF65Jx4/y" +
       "UnP6h/f//jO//cp38nrU/wIhjsApOh8AAA==");
}
