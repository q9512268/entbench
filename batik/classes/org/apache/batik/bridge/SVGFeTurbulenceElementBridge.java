package org.apache.batik.bridge;
public class SVGFeTurbulenceElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeTurbulenceElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_TURBULENCE_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          filterRegion;
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        float[] baseFrequency =
          convertBaseFrenquency(
            filterElement,
            ctx);
        int numOctaves =
          convertInteger(
            filterElement,
            SVG_NUM_OCTAVES_ATTRIBUTE,
            1,
            ctx);
        int seed =
          convertInteger(
            filterElement,
            SVG_SEED_ATTRIBUTE,
            0,
            ctx);
        boolean stitchTiles =
          convertStitchTiles(
            filterElement,
            ctx);
        boolean isFractalNoise =
          convertType(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.TurbulenceRable turbulenceRable =
          new org.apache.batik.ext.awt.image.renderable.TurbulenceRable8Bit(
          primitiveRegion);
        turbulenceRable.
          setBaseFrequencyX(
            baseFrequency[0]);
        turbulenceRable.
          setBaseFrequencyY(
            baseFrequency[1]);
        turbulenceRable.
          setNumOctaves(
            numOctaves);
        turbulenceRable.
          setSeed(
            seed);
        turbulenceRable.
          setStitched(
            stitchTiles);
        turbulenceRable.
          setFractalNoise(
            isFractalNoise);
        handleColorInterpolationFilters(
          turbulenceRable,
          filterElement);
        updateFilterMap(
          filterElement,
          turbulenceRable,
          filterMap);
        return turbulenceRable;
    }
    protected static float[] convertBaseFrenquency(org.w3c.dom.Element e,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          e.
          getAttributeNS(
            null,
            SVG_BASE_FREQUENCY_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new float[] { 0.001F,
            0.001F };
        }
        float[] v =
          new float[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            v[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                v[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                v[1] =
                  v[0];
            }
            if (tokens.
                  hasMoreTokens(
                    )) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_BASE_FREQUENCY_ATTRIBUTE,
                  s });
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_BASE_FREQUENCY_ATTRIBUTE,
              s });
        }
        if (v[0] <
              0 ||
              v[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_BASE_FREQUENCY_ATTRIBUTE,
              s });
        }
        return v;
    }
    protected static boolean convertStitchTiles(org.w3c.dom.Element e,
                                                org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          e.
          getAttributeNS(
            null,
            SVG_STITCH_TILES_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return false;
        }
        if (SVG_STITCH_VALUE.
              equals(
                s)) {
            return true;
        }
        if (SVG_NO_STITCH_VALUE.
              equals(
                s)) {
            return false;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          e,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_STITCH_TILES_ATTRIBUTE,
          s });
    }
    protected static boolean convertType(org.w3c.dom.Element e,
                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          e.
          getAttributeNS(
            null,
            SVG_TYPE_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return false;
        }
        if (SVG_FRACTAL_NOISE_VALUE.
              equals(
                s)) {
            return true;
        }
        if (SVG_TURBULENCE_VALUE.
              equals(
                s)) {
            return false;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          e,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dr+e2Pb5s/Nz7/f6oaZblTAPHE7S/err");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("D+La22+TkgAPP7xU0//6gf4P49r1y/TAVarv83R/FNeundEBVoeX8yR/CuIE" +
       "IClfv+GfuP77bpcf4ZsoDmUlLtVWLbGn57oXNJdfuZjhn9rn8e9mn3N/Cp67" +
       "sHZV111P0u6EPc5rvvDKePqhb7d//nAhSbHloii53A+WmcPdqNPU/Znbcjvh" +
       "de/wPd955JceeP4kdXnkMOEziJ+b29O3vv3Td/y4uq9T/Orb/+UP/eNXfr+6" +
       "AvB/AeQiZrmHLAAA");
}
