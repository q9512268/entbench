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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2Pbp4/RT+St+qGpmyeXD+8P1/Zz9J+B3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9wCU4mi7zJTc/sc9/R/G0PXz9MDzyv/TdH8UQ1dP6EBX+8xpkv8aQ5cASZH9" +
       "zjFOVu+Fbm0pikNRjo9Rrrt3BzXML5xdUI5n4PHvNwOn1qDnzxyklTdijw69" +
       "kv2d2NvyF16hmA98t/5L+6tMsi3uSpN4iIYe3N+qOj44e9s9ezvq68rwhe89" +
       "+qsPv+NoVXt0z/AJnpzi7bm73xvqO35c3vTZ/d2n/va7/sYrXy+vL/xfP0sq" +
       "oKosAAA=");
}
