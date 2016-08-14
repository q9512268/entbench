package org.apache.batik.svggen;
public class SVGCompositeDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String opacityValue;
    private java.lang.String filterValue;
    public SVGCompositeDescriptor(java.lang.String opacityValue, java.lang.String filterValue) {
        super(
          );
        this.
          opacityValue =
          opacityValue;
        this.
          filterValue =
          filterValue;
    }
    public SVGCompositeDescriptor(java.lang.String opacityValue, java.lang.String filterValue,
                                  org.w3c.dom.Element def) {
        this(
          opacityValue,
          filterValue);
        this.
          def =
          def;
    }
    public java.lang.String getOpacityValue() { return opacityValue;
    }
    public java.lang.String getFilterValue() { return filterValue;
    }
    public org.w3c.dom.Element getDef() { return def; }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_OPACITY_ATTRIBUTE,
            opacityValue);
        attrMap.
          put(
            SVG_FILTER_ATTRIBUTE,
            filterValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null)
            defSet.
              add(
                def);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6605EhqqT2ctc2wSQzZkdIB5wna1Fi0ujav8hAgbVgNlkokTTOdNUuHYGUEA" +
       "69vYdIh3ZvEstISmL2RNewhLOdPuWdumpXtKxNfbgh1wuYtk8GocKBWT3MmW" +
       "WevjIy3u5I1OGx/1Wp22o0+meDCkdatdd7lVkiHLCkYs1/BozMyyVcYmCt6i" +
       "eBZvb+HRDiy2fF3TN81xJ/W3zW0u8AOm2u3VUlzjkmmoWbimKg6xrI2bnizP" +
       "+v1ha8HUqOkC1TCD4pF4asrVoVSjcIUOVJ9AZaPltTR1Sm19oWpTFSaW8Pmm" +
       "N4qplZpU4NYII9EOOm7Nna3K0NRIiHdbdjka7eRJbT6lMFmd9tYdLK5inahR" +
       "a8IplsAjqSOtc8JBpaVQ8/Dd1ko5z5ObjTYswf0uVhfyWGzYIBLzHb8cNKYs" +
       "JfntkF73nGlX7bmaifdwsYVTqzBlRl1jOBUEV5is59J82EL0IQbvWBhhg6A+" +
       "G/X7hMLmUxvGMbmCeUleR1kRViuiPVkN5hKr+3To4m3eSxsUNnUJebKq5GM3" +
       "kysVxAdTLrkl480Zx2mAGE0WPcNtxJ3Kqs/akYQM5sGmTcI9d6GRYZ5yiWUs" +
       "x7nj15FeGI/t2kbZ2HmOjVkqlDeGseim6x63amBOslmhkt4YNIcGQ1tkCyHy" +
       "4XKzkieGpdA1bzXpm1YsoSqViKuw2rH7YG3BmWg+tLgtU0lpqpE2N9yA26A7" +
       "uyEHi13VqtOKO9cFryGmg1AYyV0MYBI5wlEFzV0m6lfrtcWE7QNdyVhm8GgA" +
       "O3MSLDKoOiUq5JCBfRPdDiVt3B9rmdLHeQLm8hEy6i/W/Nb0SIxdqXSrOUYo" +
       "Kll2wJKee2LLXvgrnukxNJGvyJbNh8PmuD6S5GAoc0hNszubdTYHQ9Kx4om5" +
       "5ddMOOArecBoU9wc9QLXCc2JMez3eW2KoZuGgLWwNoOqWSx6ytzPJlZ36cEc" +
       "NwWoXmvAsMMb3AafzBBmSVbGHL9tV/QayoVGIzezOe1g8cpzUSOQd9iGrLRp" +
       "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" +
       "P/fun3jl98oTt/8Hs3BewbwqAAA=");
}
