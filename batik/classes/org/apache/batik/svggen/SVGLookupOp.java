package org.apache.batik.svggen;
public class SVGLookupOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    private static final double GAMMA = 1.0 / 2.4;
    private static final int[] linearToSRGBLut = new int[256];
    private static final int[] sRGBToLinear = new int[256];
    static { for (int i = 0; i < 256; i++) { float value = i / 255.0F;
                                             if (value <= 0.0031308) { value *=
                                                                         12.92F;
                                             }
                                             else {
                                                 value =
                                                   1.055F *
                                                     (float)
                                                       java.lang.Math.
                                                       pow(
                                                         value,
                                                         GAMMA) -
                                                     0.055F;
                                             }
                                             linearToSRGBLut[i] = java.lang.Math.
                                                                    round(
                                                                      value *
                                                                        255);
                                             value = i / 255.0F;
                                             if (value <= 0.04045) {
                                                 value /=
                                                   12.92F;
                                             }
                                             else {
                                                 value =
                                                   (float)
                                                     java.lang.Math.
                                                     pow(
                                                       (value +
                                                          0.055F) /
                                                         1.055F,
                                                       1 /
                                                         GAMMA);
                                             }
                                             sRGBToLinear[i] = java.lang.Math.
                                                                 round(
                                                                   value *
                                                                     255);
             } }
    public SVGLookupOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.LookupOp)
            return toSVG(
                     (java.awt.image.LookupOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.LookupOp lookupOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              lookupOp);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (filterDesc ==
              null) {
            org.w3c.dom.Element filterDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FILTER_TAG);
            org.w3c.dom.Element feComponentTransferDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_COMPONENT_TRANSFER_TAG);
            java.lang.String[] lookupTables =
              convertLookupTables(
                lookupOp);
            org.w3c.dom.Element feFuncR =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_R_TAG);
            org.w3c.dom.Element feFuncG =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_G_TAG);
            org.w3c.dom.Element feFuncB =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_B_TAG);
            org.w3c.dom.Element feFuncA =
              null;
            java.lang.String type =
              SVG_TABLE_VALUE;
            if (lookupTables.
                  length ==
                  1) {
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
            }
            else
                if (lookupTables.
                      length >=
                      3) {
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[0]);
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[1]);
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[2]);
                    if (lookupTables.
                          length ==
                          4) {
                        feFuncA =
                          domFactory.
                            createElementNS(
                              SVG_NAMESPACE_URI,
                              SVG_FE_FUNC_A_TAG);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_TYPE_ATTRIBUTE,
                            type);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_TABLE_VALUES_ATTRIBUTE,
                            lookupTables[3]);
                    }
                }
            feComponentTransferDef.
              appendChild(
                feFuncR);
            feComponentTransferDef.
              appendChild(
                feFuncG);
            feComponentTransferDef.
              appendChild(
                feFuncB);
            if (feFuncA !=
                  null)
                feComponentTransferDef.
                  appendChild(
                    feFuncA);
            filterDef.
              appendChild(
                feComponentTransferDef);
            filterDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FE_COMPONENT_TRANSFER));
            java.lang.String filterAttrBuf =
              URL_PREFIX +
            SIGN_POUND +
            filterDef.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE) +
            URL_SUFFIX;
            filterDesc =
              new org.apache.batik.svggen.SVGFilterDescriptor(
                filterAttrBuf,
                filterDef);
            defSet.
              add(
                filterDef);
            descMap.
              put(
                lookupOp,
                filterDesc);
        }
        return filterDesc;
    }
    private java.lang.String[] convertLookupTables(java.awt.image.LookupOp lookupOp) {
        java.awt.image.LookupTable lookupTable =
          lookupOp.
          getTable(
            );
        int nComponents =
          lookupTable.
          getNumComponents(
            );
        if (nComponents !=
              1 &&
              nComponents !=
              3 &&
              nComponents !=
              4)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_ILLEGAL_BUFFERED_IMAGE_LOOKUP_OP);
        java.lang.StringBuffer[] lookupTableBuf =
          new java.lang.StringBuffer[nComponents];
        for (int i =
               0;
             i <
               nComponents;
             i++)
            lookupTableBuf[i] =
              new java.lang.StringBuffer(
                );
        if (!(lookupTable instanceof java.awt.image.ByteLookupTable)) {
            int[] src =
              new int[nComponents];
            int[] dest =
              new int[nComponents];
            int offset =
              lookupTable.
              getOffset(
                );
            for (int i =
                   0;
                 i <
                   offset;
                 i++) {
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          i /
                            255.0)).
                      append(
                        SPACE);
                }
            }
            for (int i =
                   offset;
                 i <=
                   255;
                 i++) {
                java.util.Arrays.
                  fill(
                    src,
                    i);
                lookupTable.
                  lookupPixel(
                    src,
                    dest);
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          dest[j] /
                            255.0)).
                      append(
                        SPACE);
                }
            }
        }
        else {
            byte[] src =
              new byte[nComponents];
            byte[] dest =
              new byte[nComponents];
            int offset =
              lookupTable.
              getOffset(
                );
            for (int i =
                   0;
                 i <
                   offset;
                 i++) {
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          i /
                            255.0)).
                      append(
                        SPACE);
                }
            }
            for (int i =
                   0;
                 i <=
                   255;
                 i++) {
                java.util.Arrays.
                  fill(
                    src,
                    (byte)
                      (255 &
                         i));
                ((java.awt.image.ByteLookupTable)
                   lookupTable).
                  lookupPixel(
                    src,
                    dest);
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          (255 &
                             dest[j]) /
                            255.0)).
                      append(
                        SPACE);
                }
            }
        }
        java.lang.String[] lookupTables =
          new java.lang.String[nComponents];
        for (int i =
               0;
             i <
               nComponents;
             i++)
            lookupTables[i] =
              lookupTableBuf[i].
                toString(
                  ).
                trim(
                  );
        return lookupTables;
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
       "D0mnuj0PSCdzBLgvqIv7q+cw6PsKK1fBBR+GJ3weg8pZ43o5xoVIB70ARLjx" +
       "wV/7B/QLq+88AKzTgy5vCsnzM2RsWuSdP/HqJ555w8tf/2iJET/8lU8Xv18u" +
       "+OKlBG8ry5tF8QPlEF9KoAfDyN6A7AFgSVzmsglQy/ZV9xBT/gT8LoDrfxVX" +
       "IWzxYj/5P949zEBuHKcgIZgeLw/w0Qi/v/Pwke0BlNwcJl/wS49/bfWzf/CZ" +
       "fWJ13lPOERsfefkv/8nBx16+eCqdff6OjPJ0m31KWw7FG4tiWMTe2+7XS9mi" +
       "/x8/99Kv/+JLH95L9fjZ5IwA3x6f+Wf/83cOPvn1L94lR7iil+O2n1GKslEU" +
       "nb1R0XvG4rvOesq7wdU89JTmHZ4ClTfTewxtcUsWBVUUdKn9ECBSkQCq0TiQ" +
       "xEGHSRNgiXfce5xKEN6b/ZW//vzvfuCV5/9NiUkP2TEIBTyy7pKNn2rzrVe/" +
       "9o0vv/GZz5Zz/QMLNd4HxfnPmDu/Us58fJSiP3JsmSINha6BqY7dG2b/n0Da" +
       "nzJjVMMwLtLGBUgiYiOC2UA3eFtbGRGv+oZ7lJj+/+hm7ybsoa8Wf2ICXbIP" +
       "v3IPzs1+7yqK9x35g3V3f7hY3L7zjCtccQ3f2mf5WlHcDvNj/hf3jY5m1ydO" +
       "kKbrBsCBgG8f1e1TXDs4OP7QBZX5HZJG0Iv39rNROdwniP5bH/pPT4/fvXzf" +
       "68htnzvnhudZ/tLo1S8Ovl/7qYvQpWN8v+Mr+GyjW2dR/WpkgM92f3wG25/Z" +
       "G7+0397yRfGO0sT3yTCy+9RtiyIBQKoVpt6PzH3IfyyHzsHM7HXCzC1wtQ5h" +
       "pnUPmPnA64OZR2IAL+OAKcGmVOGcjB/8rjLuvf8CyHIv1w/Qg2rx/BP3keKd" +
       "d0rxlONqN49mqYkRxcCFbjoueuS6pybQ/WLGOSGH37OQwL0fPWHGBL5166P/" +
       "7uO/85PPfw3gJX00ZRfUPRAMk7/0q+jXi4effH36PF3oI5XIwqhxMirTbUM/" +
       "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" +
       "++Lrcbw8gd5w6qhUce7jLXecu9yfFdQ+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+8q1h556Rf7n+x3Eo/N8DzPQQ2bquqe33E/dXwkjw7RLKR/eb8Dvx+w/gLi7" +
       "B6AU29/lTSntv9/T/2ECXT9PDyKv/D9N90cJdPWEDrDa35wm+c8JdAmQFLff" +
       "OsbJ+r3QDV/ESaRqyTHKdffhYET5hbMTyvEIPP7dRuDUHPT8mY248mTs0aZZ" +
       "uj8be1v73Cs0+/5vt35+f9xJc9Vd6RIPMdCD+5NXxxtvb7sntyNeV8gXvvPo" +
       "rzz8jqNZ7dG9wCd4ckq25+5+tojwwqQ8DbT720/9zXf9witfLY84/G/LAUKN" +
       "siwAAA==");
}
