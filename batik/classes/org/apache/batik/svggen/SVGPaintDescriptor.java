package org.apache.batik.svggen;
public class SVGPaintDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String paintValue;
    private java.lang.String opacityValue;
    public SVGPaintDescriptor(java.lang.String paintValue, java.lang.String opacityValue) {
        super(
          );
        this.
          paintValue =
          paintValue;
        this.
          opacityValue =
          opacityValue;
    }
    public SVGPaintDescriptor(java.lang.String paintValue, java.lang.String opacityValue,
                              org.w3c.dom.Element def) { this(
                                                           paintValue,
                                                           opacityValue);
                                                         this.
                                                           def =
                                                           def;
    }
    public java.lang.String getPaintValue() { return paintValue;
    }
    public java.lang.String getOpacityValue() { return opacityValue;
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
            SVG_FILL_ATTRIBUTE,
            paintValue);
        attrMap.
          put(
            SVG_STROKE_ATTRIBUTE,
            paintValue);
        attrMap.
          put(
            SVG_FILL_OPACITY_ATTRIBUTE,
            opacityValue);
        attrMap.
          put(
            SVG_STROKE_OPACITY_ATTRIBUTE,
            opacityValue);
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
      ("H4sIAAAAAAAAALVZfZAUxRXv3eM+uO87PgXugPMOA+iuRjHBE+NxHHBkDy4c" +
       "XpXLxzk723s3MDszzvTe7Z2aiFWW5A8pQvAjJpJKFQYwKMZoJZpISFlRicbE" +
       "j2iMBSHRqmiMpZSlSQXz8V73zM7HflCXyFZN72z3e6/fe/369/r1HnmflFsm" +
       "aaUai7Bxg1qRHo31S6ZFk92qZFmboG9IvqdM+mjbO+uXh0lFnNSPSFafLFl0" +
       "tULVpBUnLYpmMUmTqbWe0iRy9JvUouaoxBRdi5MZitWbNlRFVlifnqRIMCiZ" +
       "MdIkMWYqiQyjvbYARlpioEmUaxLtCg53xkitrBvjLvlsD3m3ZwQp0+5cFiON" +
       "se3SqBTNMEWNxhSLdWZNstTQ1fFhVWcRmmWR7eoy2wXrYsvyXND2SMMnZ/eM" +
       "NHIXTJM0TWfcPGsjtXR1lCZjpMHt7VFp2rqRfJWUxUiNh5iR9pgzaRQmjcKk" +
       "jrUuFWhfR7VMulvn5jBHUoUho0KMLPQLMSRTStti+rnOIKGK2bZzZrB2Qc5a" +
       "YWWeiXctje67Z1vjo2WkIU4aFG0A1ZFBCQaTxMGhNJ2gptWVTNJknDRpsNgD" +
       "1FQkVZmwV7rZUoY1iWVg+R23YGfGoCaf0/UVrCPYZmZkpps581I8oOxf5SlV" +
       "GgZbZ7q2CgtXYz8YWK2AYmZKgrizWabsULQkI/ODHDkb278MBMBamaZsRM9N" +
       "NUWToIM0ixBRJW04OgChpw0DabkOAWgyMqeoUPS1Ick7pGE6hBEZoOsXQ0A1" +
       "lTsCWRiZESTjkmCV5gRWybM+76+/evdN2lotTEKgc5LKKupfA0ytAaaNNEVN" +
       "CvtAMNYuid0tzXxqV5gQIJ4RIBY0P775zLUXtx5/TtDMLUCzIbGdymxIPpCo" +
       "f2le9+LlZahGlaFbCi6+z3K+y/rtkc6sAQgzMycRByPO4PGNz1x/64P0vTCp" +
       "7iUVsq5m0hBHTbKeNhSVmmuoRk2J0WQvmUq1ZDcf7yWV8B5TNCp6N6RSFmW9" +
       "ZIrKuyp0/htclAIR6KJqeFe0lO68GxIb4e9ZgxBSCQ/phudCIj78m5Gt0RE9" +
       "TaOSLGmKpkf7TR3tt6KAOAnw7Ug0AVG/I2rpGRNCMKqbw1EJ4mCEOgOjw8NU" +
       "iw4MrumXIFRXUUs2FQPiPYJhZpzvCbJo4bSxUAicPy+49VXYNWt1NUnNIXlf" +
       "ZmXPmYeHnhdhhVvB9g0jS2DOiJgzwueMiDkj+XOSUIhPNR3nFmsMK7QD9jqA" +
       "be3iga3rbtjVVgbBZYxNAfeGgbTNl3S6XUBwUHxIPtpcN7Hw1GVPh8mUGGmW" +
       "ZJaRVMwhXeYwoJO8w97AtQlIR25WWODJCpjOTF2mSQClYtnBllKlj1IT+xmZ" +
       "7pHg5CzcndHiGaOg/uT4vWM7B792aZiE/YkApywHDEP2foTvHEy3BwGgkNyG" +
       "O9755Ojdt+guFPgyi5MQ8zjRhrZgMATdMyQvWSA9PvTULe3c7VMBqhksNqJg" +
       "a3AOH9J0OqiNtlSBwSndTEsqDjk+rmYjpj7m9vAobeLv0yEsanDrtcDzOXsv" +
       "8m8cnWlgO0tENcZZwAqeFVYMGPf//sV3L+fudhJIgyfzD1DW6QEtFNbM4anJ" +
       "DdtNJqVAd/Le/m/e9f4dm3nMAsWFhSZsx7YbwAqWENx8+3M3vvHHUwdeDefi" +
       "PMQga2cScPjJ5ozEflJdwkiYbZGrD4CeCriAUdN+nQbxqaQUKaFS3FifNnRc" +
       "9vjfdjeKOFChxwmji88twO2/YCW59fltf2/lYkIyJl3XZy6ZQPJpruQu05TG" +
       "UY/szpdbvvWsdD/kBMBhS5mgHFrD9l5HpWbDGYxzYn6NiPyK/VfyJV3GaS7l" +
       "7RXoDs5J+NhybDos79bw7z7P0WlI3vPqh3WDHx47w23xn728kdAnGZ0i+LBZ" +
       "lAXxs4LQtVayRoDuiuPrtzSqx8+CxDhIlAGMrQ0mYGfWFzc2dXnlH37x9Mwb" +
       "Xioj4dWkWtWl5GqJb0EyFWKfWiMAu1njS9eKpR+rgqaRm0ryjM/rQPfPL7yw" +
       "PWmD8aWY+Mmsx64+uP8Uj0GDi2jJ318RO/QihfcXthdhszQ/aouxBlawjOtc" +
       "xpeYN04UTMOkMna5HEnq6QgelAFq+bS9JWKgD5tVfOgqbHqEc1b8j37Ejm5D" +
       "DMwVimKa9CUkXt64mPjgK1/43cFv3D0mDkiLiyeCAN/sf25QE7f9+R958chT" +
       "QIHDW4A/Hj3ynTnd17zH+V0sRu72bH5qh3zm8n7+wfTH4baKX4ZJZZw0ynY5" +
       "MSipGUS4OByhLafGgJLDN+4/DouzX2cu18wL5gHPtMEs4B4p4B2p8b0uAPy1" +
       "uC6z4Wm3o6s9GJghwl+uF7HJ2yXYXOLgbKVhKlBy0gDQ1pQQykhZkqbwdZ0b" +
       "9zy+4ueKrwG/6q3wdNizdBRRPeFuqy35OhbjZqTawKMWX5XcbvKoKk9S1QXw" +
       "LLInW1REVaWkqsW4GanV4bCosPGiym4voWy2EOzwTwUJnM6DsDPXn2g6Spxb" +
       "3SOrQ72wBPXAOOy3LGaHlmKFGS8qD9y2b39ywwOXCXRo9hc7PVDLP/Tav16I" +
       "3Hv6RIFT9lSmG5eodJSqHlvwVqbFh0d9vGZ1N/fJ+r1vPdE+vHIyZ2Psaz3H" +
       "6Rd/zwcjlhSHuKAqz9721zmbrhm5YRLH3PkBdwZFHu47cmLNInlvmBfoAnXy" +
       "Cns/U6cfa6pNyjKmtsmHOBfmAqsZ42g+PMvswFoW3AvnToXFWEsksttLjN2B" +
       "za2M1A1T1u/f8+4O2vlZZD7ef7PfFwvhWW4btHzyvijGWsLevSXG9mFzJ5zZ" +
       "wBcbgqDiemP3efDGNBy7AJ4VtkkrJu+NYqwlLP5uibHvYXMf1BLgjVV2xnKd" +
       "8O3z4IQGHMOs1mVb0jV5JxRjDRgaEhncD3iIZAOZhMU2SmMcaofkLRc1zmxf" +
       "/lGbwNjWArSey7LdP30yHr+oURbEbYUE+y/JDh2skt9MP/O2YLigAIOgm3Eo" +
       "eufg69tf4FhXheCaQxgPsAIIewrcxpxv6tEVTfCctn3DvxnZ8n/eBQFbOsqU" +
       "NBRV0U1Kmibtg7Vz13Re5fPiyZer3EX7wQ6164Mvfn+FcOvCIjnFpX/iK6df" +
       "un/i6BGRJ9G9jCwtdmeef1GPFxwdJS5p3AD5eM1Vx999a3Br2N5i9dg8mnUO" +
       "BXVumQVFHXY+WSBgp/vDREhe9fWGn+1pLlsNibmXVGU05cYM7U36k1OllUl4" +
       "4sa9GnZTlR00/4FPCJ5/44PBgh0iaJq77WvSBbl7UsPI4jgjoSXwyuUcKYEr" +
       "T2NzUKBs7u8W294fugBz6DwADGdfAE+fvRP6Jg8wxViLAAz+fsi/FTHzHbal" +
       "HHak/IhLeUxY8jg2v83FRb33kkBct7wcnAh/HhPOf7GE81/D5gQjjQLUFY3f" +
       "SUFhhv2/cb3/q8+k1oVwyb+1xQuF2Xn/C4n/MuSH9zdUzdp/3ev8gJn7v6EW" +
       "UC+VUVVvVed5rzBMMIXbVytqPIN/nWJkVpFzNqQ18cJ1Pyno/wR+CdIzUs6/" +
       "vXRvQ33k0oEo8eIl+QuUeUCCr+8YBe6iRHGbDXlO37YfuftnnMv9ORbvJSFC" +
       "D/9fzoGHTL+NcEf3r1t/05krHxCXlLIqTUyglBoABXFfmjsjLywqzZFVsXbx" +
       "2fpHpnY4INYkFHZ3zlxPvHVDaBq44nMCN3hWe+4i740DVx/79a6KlwF+N5OQ" +
       "xMi0zfnXAFkjA7l6cywf/KCe4FeLnYvvG7/m4tQHb/JbKBss5xWnH5JfPbj1" +
       "lb2zD7SGSU0vKYeKimb5/cSqcW0jlUfNOKlTrJ4sqAhSFEn1IWs9BqeEN4rc" +
       "L7Y763K9eMXNSFveX3MF/hioVvUxaq7UM1rSxuYat8eplXxlRsYwAgxuj+cM" +
       "8BQ2P88K5C4bivUZhoPk1c8bfJceKwwk2J7lr9h8+l/Z5qDzsx8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9/2D136/vGj7f5gSgkimKgAA");
}
