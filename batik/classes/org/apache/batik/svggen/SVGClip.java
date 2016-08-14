package org.apache.batik.svggen;
public class SVGClip extends org.apache.batik.svggen.AbstractSVGConverter {
    public static final java.awt.Shape ORIGIN = new java.awt.geom.Line2D.Float(
      0,
      0,
      0,
      0);
    public static final org.apache.batik.svggen.SVGClipDescriptor NO_CLIP =
      new org.apache.batik.svggen.SVGClipDescriptor(
      SVG_NONE_VALUE,
      null);
    private org.apache.batik.svggen.SVGShape shapeConverter;
    public SVGClip(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        this.
          shapeConverter =
          new org.apache.batik.svggen.SVGShape(
            generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Shape clip =
          gc.
          getClip(
            );
        org.apache.batik.svggen.SVGClipDescriptor clipDesc =
          null;
        if (clip !=
              null) {
            java.lang.StringBuffer clipPathAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            java.awt.geom.GeneralPath clipPath =
              new java.awt.geom.GeneralPath(
              clip);
            org.apache.batik.svggen.ClipKey clipKey =
              new org.apache.batik.svggen.ClipKey(
              clipPath,
              generatorContext);
            clipDesc =
              (org.apache.batik.svggen.SVGClipDescriptor)
                descMap.
                get(
                  clipKey);
            if (clipDesc ==
                  null) {
                org.w3c.dom.Element clipDef =
                  clipToSVG(
                    clip);
                if (clipDef ==
                      null)
                    clipDesc =
                      NO_CLIP;
                else {
                    clipPathAttrBuf.
                      append(
                        SIGN_POUND);
                    clipPathAttrBuf.
                      append(
                        clipDef.
                          getAttributeNS(
                            null,
                            SVG_ID_ATTRIBUTE));
                    clipPathAttrBuf.
                      append(
                        URL_SUFFIX);
                    clipDesc =
                      new org.apache.batik.svggen.SVGClipDescriptor(
                        clipPathAttrBuf.
                          toString(
                            ),
                        clipDef);
                    descMap.
                      put(
                        clipKey,
                        clipDesc);
                    defSet.
                      add(
                        clipDef);
                }
            }
        }
        else
            clipDesc =
              NO_CLIP;
        return clipDesc;
    }
    private org.w3c.dom.Element clipToSVG(java.awt.Shape clip) {
        org.w3c.dom.Element clipDef =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_CLIP_PATH_TAG);
        clipDef.
          setAttributeNS(
            null,
            SVG_CLIP_PATH_UNITS_ATTRIBUTE,
            SVG_USER_SPACE_ON_USE_VALUE);
        clipDef.
          setAttributeNS(
            null,
            SVG_ID_ATTRIBUTE,
            generatorContext.
              idGenerator.
              generateID(
                ID_PREFIX_CLIP_PATH));
        org.w3c.dom.Element clipPath =
          shapeConverter.
          toSVG(
            clip);
        if (clipPath !=
              null) {
            clipDef.
              appendChild(
                clipPath);
            return clipDef;
        }
        else {
            clipDef.
              appendChild(
                shapeConverter.
                  toSVG(
                    ORIGIN));
            return clipDef;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nif2wvOJkxh0CsozjbzJI3l6OUt+MB+T01n2h0Dch/laMwIiGK5k78X/98Dv" +
       "FHj+J3syxlnBdnK+C99bITx8sETwwTR2lh73u/3hfhDdkfuWtIp2WV3aanAp" +
       "r0OzpLntBruuJ73xuJ4oeJ7e07NwHT2HN9IzS9pZ0snN2I2gc0P6Ck72R/sC" +
       "P/kq03BLDeXA8EEwnNCF/v51yZY60GXwFPd0KV5HF+HaugCYPucHRgJsvq/G" +
       "HWFmXuCTCZj41GBfm4dvoM21BmT6qkrk/aWngAhnSrvYLpK9Szdn8ntNW768" +
       "7z08EBYE9WXTxvaFvpT7TBY+u9tNwAkhu9+3kABv7jhkRnpgP/G+f/zAl37h" +
       "sa8BUCCgM0kWsAALjvQ4jLMt1s+8+PwDr3nu6+/Lp0ZgcP69v4t9PeNq3pyq" +
       "92eqsvlKkpTCiMpnM1XJtb0hFo4CwwGTfrK3f4Cfvetr1oe/8Ynt3uAk8J0g" +
       "Vt/z3M9+b/f9z+0c2ZE9dtWm6Gib7a4sF/r2PQsH0CM36iVv0fmnl579o996" +
       "9t1bqe46vr9og+3zJ/7qv7+0+6Gvf+Eay91bbO//MLDR7b/WQ8N+Y/9H8jO1" +
       "tJqkqbOgC6NyabMJa62m1iLaacxEBNvmhxKV6ihlVvpiwhRNRpbL0UZZRVhc" +
       "S2K3hzj+pMQs/VZBYzVbbzMdXvJMvs1yy24g1ds9a+AsuUG3ZBMjdswvO3wB" +
       "gaVOS/Ake8knQSVREqU0LwDAX3ICElaHIoZVxACbYnDkBNFKK0piM/bdAVNO" +
       "u2JJ9FiaN4utpkgtCQapr3qzcs9fs0G1go4S01kNLd8nEH+gV4Jmm5uLpGgF" +
       "rIuzgTicWjwhzGiZmLVtlerKqZXqnB0uRdpaCuuuXF4axoZYdHSSMrgZhyIz" +
       "SVLlbrlvpEV3IoYtYqkbMoGndFvHEG4Ft1mCtqocFaui2hvRA5GRl2FcWRAs" +
       "n4QUUTLQ8XpqT5vUMLEbZaNVj5dzym8KQ71oqPoKDYTSisf6xWjAd5obmI56" +
       "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");
}
class ClipKey {
    int hashCodeValue = 0;
    public ClipKey(java.awt.geom.GeneralPath proxiedPath,
                   org.apache.batik.svggen.SVGGeneratorContext gc) {
        super(
          );
        java.lang.String pathData =
          org.apache.batik.svggen.SVGPath.
          toSVGPathData(
            proxiedPath,
            gc);
        hashCodeValue =
          pathData.
            hashCode(
              );
    }
    public int hashCode() { return hashCodeValue; }
    public boolean equals(java.lang.Object clipKey) { return clipKey instanceof org.apache.batik.svggen.ClipKey &&
                                                        hashCodeValue ==
                                                        ((org.apache.batik.svggen.ClipKey)
                                                           clipKey).
                                                          hashCodeValue;
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
      ("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");
}
