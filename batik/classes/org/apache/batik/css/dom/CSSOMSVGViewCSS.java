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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Qb8pw59fFfKfEK84fO2/jjzCvQkUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KC9Zp3/0+j94y2+/+M28rvW/N3+oYGYfAAA=");
}
