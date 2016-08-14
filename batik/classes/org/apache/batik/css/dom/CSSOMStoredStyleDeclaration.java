package org.apache.batik.css.dom;
public abstract class CSSOMStoredStyleDeclaration extends org.apache.batik.css.dom.CSSOMSVGStyleDeclaration implements org.apache.batik.css.dom.CSSOMStyleDeclaration.ValueProvider, org.apache.batik.css.dom.CSSOMStyleDeclaration.ModificationHandler, org.apache.batik.css.engine.StyleDeclarationProvider {
    protected org.apache.batik.css.engine.StyleDeclaration declaration;
    public CSSOMStoredStyleDeclaration(org.apache.batik.css.engine.CSSEngine eng) {
        super(
          null,
          null,
          eng);
        valueProvider =
          this;
        setModificationHandler(
          this);
    }
    public org.apache.batik.css.engine.StyleDeclaration getStyleDeclaration() {
        return declaration;
    }
    public void setStyleDeclaration(org.apache.batik.css.engine.StyleDeclaration sd) {
        declaration =
          sd;
    }
    public org.apache.batik.css.engine.value.Value getValue(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        for (int i =
               0;
             i <
               declaration.
               size(
                 );
             i++) {
            if (idx ==
                  declaration.
                  getIndex(
                    i)) {
                return declaration.
                  getValue(
                    i);
            }
        }
        return null;
    }
    public boolean isImportant(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        for (int i =
               0;
             i <
               declaration.
               size(
                 );
             i++) {
            if (idx ==
                  declaration.
                  getIndex(
                    i)) {
                return declaration.
                  getPriority(
                    i);
            }
        }
        return false;
    }
    public java.lang.String getText() { return declaration.
                                          toString(
                                            cssEngine);
    }
    public int getLength() { return declaration.size(
                                                  );
    }
    public java.lang.String item(int idx) { return cssEngine.
                                              getPropertyName(
                                                declaration.
                                                  getIndex(
                                                    idx));
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
       "lwM0n/W20QRD+G6frjkcCfPAIcCb6LrI9lt4JyXhGLwlWQwaS+NsLWy241Ur" +
       "2YnezM3Ggux6nXDKtRtwzDRGPJK52HbORCuNqZmwwezrxXiB5uu6HLosRQy7" +
       "k4Xptaf9OHZ7m4kguCPcrAv91CTb0zrFkILd8VXG2iptrVjFPSuotzlW3bR3" +
       "dKhpW1+ZcvKkLcPr1I+ncNi3UhKIKM1CAXhqS245ZsNWWTvQwLIOb0aE66EZ" +
       "2qILg/Pa9eFaEsRQD2Sr3421ydA0Vw1+JYa06o+NKIyCdQ+Hp8JSXYvtYNpl" +
       "Mm07bfaVpWS1+o2QxRo+1m8R4x7a0eJZn4iZHSaRm353xpN+rnuMmKRRKCR+" +
       "VJcF2s1qIIGojZfTwDLHWk1AsrwbE619tFR9VuNCvbNEWd7gtgPZ2jT3ubXx" +
       "B3HU94Zpvt7N0sUYNXBhPBn7aSrnuJ7Pxs1QyUQnLoazpjUaRXTQBokNPByL" +
       "pER2sf06XkwyZR3L9eZkO7PQqSxMmd6A6LJ+jralOuUj+qYtkzWX77NhHHi6" +
       "F8r7rUEVmUkHeW2W1MYyTMJrDFlOcDJF0fL12XhzOxhPVps158eQewspG7g3" +
       "8eae3X3Aq6ebRI9KMpgpSYmOe9/V7/rZedbZ/8W97+MW5wNnu0afeKPTndv3" +
       "v25We4ds4CaGqgVnTLA3yeSwoaNUD6TkqNaR1d1Pm+6xG3cmR7nv8r57naNW" +
       "ey5f/vQrr6qzn25cPd3nViPoscj1/qSlJZp1QS+PAE4v3nt/iamOkY/7r1/7" +
       "9H9+jvu+3afexBnU+y/JeZnl32Je+7XRR5S/chV64Hw39o4D7ts7vXT7Huy1" +
       "QIviwOFu24l937mZvPfsWKR3aia9u58D3X0btjK/g5Xf5xjhM/dp+9Gy+HQE" +
       "Pa1r0d22V6mjf/yFN9rZusi7qvih24+7SmifPIX5ybcH5pUjAVUR/MR9sH6h" +
       "LD4HsIZ3Yq063LoQBpQIejBxDfWI/8ffAv4qInwPuMhT/OTbjp+rCP76ffB/" +
       "uSy+BKIVmOsqcpy5+Ufv5+bV/vLJkb7SxatvQRdPl5XPg4s/1QX//0gXX72P" +
       "Ln6+LP52BD1uhJTtucH5hz6XbOAR2XUtTXKO0F97C9CfOjMD+RS6/PZ7+z+6" +
       "T9svl8U/AKiABXAgnla6OkL7xbcArVzqoGfBZZxCM95+aF+/T9s/LYtfAQsJ" +
       "gEYD0412d5vOB4zTaa7wfu2tTuUz4PJO8XpvuxX/84rgt+8D+t+Wxb8EkcqI" +
       "NPvSZP7WmwGXRdD33ucDkvI0/Nk7PmA7fHSl/Nyr1x99z6v8v6q+oTj/MOox" +
       "Gnp0G1vWxePIC/cPe4G2NSoQjx0OJ73q799H0LP3yl/A9IGykv13D9T/MYLe" +
       "dTdqQAnKi5S/H0E3LlNG0EPV/0W6P4yga0e6CHr4cHOR5L8A7oCkvP22dxZC" +
       "G2+QdK1Gl3WaXbmQ6ZyaVzVxT73RxJ13ufitRpkdVV8inmUy8eFbxFvKV14d" +
       "T3/wO92fPnwrAsYvipLLozT0yOGzlfNs6IV7cjvj9TD5se8+8dXHPnyWuT1x" +
       "EPho6hdke//dP8wgbC+qPqUo/v57/u4n/sarv1OdT/4fT5eDPiIqAAA=");
}
