package org.apache.batik.css.engine.value;
public class URIValue extends org.apache.batik.css.engine.value.StringValue {
    java.lang.String cssText;
    public URIValue(java.lang.String cssText, java.lang.String uri) { super(
                                                                        org.w3c.dom.css.CSSPrimitiveValue.
                                                                          CSS_URI,
                                                                        uri);
                                                                      this.
                                                                        cssText =
                                                                        cssText;
    }
    public java.lang.String getCssText() { return "url(" +
                                           cssText +
                                           ')'; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aplRUBQZ1PX/AsAbTbVuFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Nxw/yg/g0z983e+/+bdf+GZ+cva/tAlpJlYgAAA=");
}
