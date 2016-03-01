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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fkD9xNXaXad7pzcdPl/s9MLFHdNrkZ6kkbe4sG/65KlmHy819hR4Gseabdz6" +
       "HOaWXnCl8oKD7e+w6R/foS0tCy+pPbTRE9YHiS13PPXhmbv4321D7TzTqsK+" +
       "WT7qWD7qr0e++yqC+042e5+/3bHk4QDy+IbDCfWbSupdSz3SfPfo+KSybPrw" +
       "CcEzN7HbZMnRIJID01Jjztf0E8rGTZSlm8q75MhyZTB+pHuaHpWHQEeU5SR6" +
       "dNLx+6vN4pJwo4NZzHQVeM/G0cFHyPlN04tOP5N3VSS9qP7z6ddf/2zxhVcP" +
       "e6KKHOtJrX67iyc3330pjyefv8MR69mVhL8Y/Mhrf/ZfhPedxOqDp6Z9urTk" +
       "s+Bhj03LXjbtiawPn53sjOWq7acrXh+8g2N+oiwK4JhqpMuJflBeWfeTZ475" +
       "ge/BMZ8sK2HwfOJ49p94A455FQBWEPkJMJquVSh8Sye9eiCuXKssPlRRffYO" +
       "Uv9CWfxsUnuz6nuZHiUkMCwFfChMdU/dx3c0WnVGeDDaK7/83O9+8JXn/qg6" +
       "ZrvfigU5IqLNLe6enOvzrVe/9o3fe/jJz1dH0ZVHVXh1+dLOzXdyLly1qaR4" +
       "6FTLT9SOHeWdx1qufpOa/td6AQIwccvTUz8iwFuF+Sc3Lf7fDHRwrvm5tXVV" +
       "Hlc5vpycmvnK8d2G0xOIz+VXapWr/ePbONnpGn+6vN/r6N4mMW812l3WAcN+" +
       "Mcgv+98p7J2dT3Ud39NLVDppO1zNsPyj0/teoDG/5eTtw+Srwc4lC99tFfri" +
       "Hdq+VBa/AVSmlvM6iHEH8teOw7sCgU9/ryAAgeeLx+75xTcCAuXrz7/R6P/y" +
       "HeT6Sln866T2+HH0zxMrUc2FBcx0K5Pfp/i+o8vemS5+83vVxQ+C5/VjXbz+" +
       "f10Xv38HXfxBWfy7pPbgsS5OEqh/eybtV9+ItHlSe/ud7iiVFy7edtP9ycOd" +
       "P/Xzrzx6/1tfWf6HAzae3Mt7gK3db6SOc/58/Nz7vUGkG1YlzAOH0/Kg+vmj" +
       "pPbW26QrIMIPL9X0v36g/+Okdv0yPQiV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6vc83Z8ktWtndIDV4eU8yZ8DnAAk5es3gpPQf8/tcidCiZNIVpNSbdXye3p2" +
       "e0Fz+ZWL2f+pfR7/bvY598Hw3IV1rbruepKSp/xxzvOFV0bcB77d/qXDpSPV" +
       "kYui5HI/WIIO959O0/pnbsvthNe9w3d955Ffe+D5k7TmkcOEz1z83NyevvUN" +
       "n74bJNWdnOI33vpPf/QfvPKH1TH//wHwxjIIhywAAA==");
}
