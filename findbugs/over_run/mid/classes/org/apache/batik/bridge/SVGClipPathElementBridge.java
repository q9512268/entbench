package org.apache.batik.bridge;
public class SVGClipPathElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.ClipBridge {
    public SVGClipPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_CLIP_PATH_TAG; }
    public org.apache.batik.ext.awt.image.renderable.ClipRable createClip(org.apache.batik.bridge.BridgeContext ctx,
                                                                          org.w3c.dom.Element clipElement,
                                                                          org.w3c.dom.Element clipedElement,
                                                                          org.apache.batik.gvt.GraphicsNode clipedNode) {
        java.lang.String s;
        java.awt.geom.AffineTransform Tx;
        s =
          clipElement.
            getAttributeNS(
              null,
              SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            Tx =
              org.apache.batik.bridge.SVGUtilities.
                convertTransform(
                  clipElement,
                  SVG_TRANSFORM_ATTRIBUTE,
                  s,
                  ctx);
        }
        else {
            Tx =
              new java.awt.geom.AffineTransform(
                );
        }
        short coordSystemType;
        s =
          clipElement.
            getAttributeNS(
              null,
              SVG_CLIP_PATH_UNITS_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                USER_SPACE_ON_USE;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  clipElement,
                  SVG_CLIP_PATH_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            Tx =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  Tx,
                  clipedNode);
        }
        java.awt.geom.Area clipPath =
          new java.awt.geom.Area(
          );
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        boolean hasChildren =
          false;
        for (org.w3c.dom.Node node =
               clipElement.
               getFirstChild(
                 );
             node !=
               null;
             node =
               node.
                 getNextSibling(
                   )) {
            if (node.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element child =
              (org.w3c.dom.Element)
                node;
            org.apache.batik.gvt.GraphicsNode clipNode =
              builder.
              build(
                ctx,
                child);
            if (clipNode ==
                  null) {
                continue;
            }
            hasChildren =
              true;
            if (child instanceof org.apache.batik.dom.svg.SVGOMUseElement) {
                org.w3c.dom.Node shadowChild =
                  ((org.apache.batik.dom.svg.SVGOMUseElement)
                     child).
                  getCSSFirstChild(
                    );
                if (shadowChild !=
                      null &&
                      shadowChild.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    child =
                      (org.w3c.dom.Element)
                        shadowChild;
                }
            }
            int wr =
              org.apache.batik.bridge.CSSUtilities.
              convertClipRule(
                child);
            java.awt.geom.GeneralPath path =
              new java.awt.geom.GeneralPath(
              clipNode.
                getOutline(
                  ));
            path.
              setWindingRule(
                wr);
            java.awt.geom.AffineTransform at =
              clipNode.
              getTransform(
                );
            if (at ==
                  null)
                at =
                  Tx;
            else
                at.
                  preConcatenate(
                    Tx);
            java.awt.Shape outline =
              at.
              createTransformedShape(
                path);
            org.apache.batik.gvt.ShapeNode outlineNode =
              new org.apache.batik.gvt.ShapeNode(
              );
            outlineNode.
              setShape(
                outline);
            org.apache.batik.ext.awt.image.renderable.ClipRable clip =
              org.apache.batik.bridge.CSSUtilities.
              convertClipPath(
                child,
                outlineNode,
                ctx);
            if (clip !=
                  null) {
                java.awt.geom.Area area =
                  new java.awt.geom.Area(
                  outline);
                area.
                  subtract(
                    new java.awt.geom.Area(
                      clip.
                        getClipPath(
                          )));
                outline =
                  area;
            }
            clipPath.
              add(
                new java.awt.geom.Area(
                  outline));
        }
        if (!hasChildren) {
            return null;
        }
        org.apache.batik.gvt.ShapeNode clipPathNode =
          new org.apache.batik.gvt.ShapeNode(
          );
        clipPathNode.
          setShape(
            clipPath);
        org.apache.batik.ext.awt.image.renderable.ClipRable clipElementClipPath =
          org.apache.batik.bridge.CSSUtilities.
          convertClipPath(
            clipElement,
            clipPathNode,
            ctx);
        if (clipElementClipPath !=
              null) {
            clipPath.
              subtract(
                new java.awt.geom.Area(
                  clipElementClipPath.
                    getClipPath(
                      )));
        }
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          clipedNode.
          getFilter(
            );
        if (filter ==
              null) {
            filter =
              clipedNode.
                getGraphicsNodeRable(
                  true);
        }
        boolean useAA =
          false;
        java.awt.RenderingHints hints;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertShapeRendering(
              clipElement,
              null);
        if (hints !=
              null) {
            java.lang.Object o =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_ANTIALIASING);
            useAA =
              o ==
                java.awt.RenderingHints.
                  VALUE_ANTIALIAS_ON;
        }
        return new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
          filter,
          clipPath,
          useAA);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYa2xUxxWeXb+NwQ9im0Iw4BgkTLILJQS1piXG5WGytlc2" +
       "sVTTsMzeO+u9cPfe4d5Ze+2EEiK1Qf2RpoGktBL+RVQ1oklUNWr/BLmq1ASl" +
       "aQSN2jzUtFX/9IUU/oRW9HXO3Ofe9TrlV1e6d2dnzpyZc8433zmzV26SOtsi" +
       "vZwaKk2IOc7sRBrbaWrZTB3SqW0fgd6M8o0/nD9z+1dNZ+OkfoqsylN7RKE2" +
       "O6AxXbWnyHrNsAU1FGaPMqbijLTFbGbNUKGZxhTp1OzhAtc1RRMjpspQYJJa" +
       "KdJOhbC0bFGwYVeBIBtScjdJuZvkYFRgIEVaFJPPBRPWlk0YCo2hbCFYzxak" +
       "LXWCztBkUWh6MqXZYqBkkW3c1OemdVMkWEkkTui7XEccTu2qcEPvq62f3Hk2" +
       "3ybdsJoahimkifY4s019hqkp0hr07tdZwT5FvkpqUmRFSFiQvpS3aBIWTcKi" +
       "nr2BFOx+JTOKhSFTmiM8TfVcwQ0JsqlcCacWLbhq0nLPoKFRuLbLyWDtRt9a" +
       "L9wRE5/flrzw7WNtP6whrVOkVTMmcDsKbELAIlPgUFbIMsseVFWmTpF2AwI+" +
       "wSyN6tq8G+0OW5s2qCgCBDy3YGeRM0uuGfgKIgm2WUVFmJZvXk6Cyv1Vl9Pp" +
       "NNjaFdjqWHgA+8HAZg02ZuUoYM+dUntSM1SJo/IZvo19j4AATG0oMJE3/aVq" +
       "DQodpMOBiE6N6eQEgM+YBtE6EyBoSaxVUYq+5lQ5SadZRpA1Ubm0MwRSTdIR" +
       "OEWQzqiY1ARRWhuJUig+N0f3PPO4cciIkxjsWWWKjvtfAZN6IpPGWY5ZDM6B" +
       "M7GlP/UC7Xr9XJwQEO6MCDsyP37i1sP39yy+6cisW0JmLHuCKSKjXM6uun7v" +
       "0NbP1eA2Grlpaxj8MsvlKUu7IwMlDkzT5WvEwYQ3uDj+8y8/+RL7a5w0D5N6" +
       "xdSLBcBRu2IWuKYz6yAzmEUFU4dJEzPUITk+TBqgndIM5vSO5XI2E8OkVpdd" +
       "9ab8DS7KgQp0UTO0NSNnem1ORV62S5wQ0gAPWQ/PNuJ8+vElyKlk3iywJFWo" +
       "oRlmMm2ZaD8GVHIOs6Gtwig3k1nA/8kHdiR2J22zaAEgk6Y1naSAijxzBpNZ" +
       "S1OnWXJi8uCQrvE07AA5ghlinxxIIPT4/2PREnpi9WwsBkG6N0oROpyuQ6au" +
       "MiujXCju23/r5cxbDvzwyLg+FGQ7rJxwVk7IlRPOyolqK5NYTC54D+7AQQTE" +
       "8yQwA1Bzy9aJxw4fP9dbA1Dks7UQDBTdUpGqhgIK8Xg/o1y5Pn77nbebX4qT" +
       "OLBMFlJVkC/6yvKFk+4sU2EqEFa1zOGxZ7J6rlhyH2Tx4uzZyTPb5T7CKQAV" +
       "1gF74fQ0Ere/RF/06C+lt/XpP33yygunzYAEynKKlworZiK39EbDGzU+o/Rv" +
       "pK9lXj/dFye1QFhA0oLCoQL+64muUcYxAx5foy2NYHDOtApUxyGPZJtF3jJn" +
       "gx6Ju3bZvgdCvAIP3X3wbHdPofzG0S6O724Hp4iZiBUyH3xhgl9675d/3ind" +
       "7aWO1lDOn2BiIERXqKxDElN7AMEjFmMg99uL6fPP33z6qMQfSNy31IJ9+B4C" +
       "moIQgpu/9uap93/30eV34wFmBeTrYhZKn5JvJPaT5mWMRJwH+wG60+H0I2r6" +
       "HjUAlVpOo1md4SH5Z+vmHa/97Zk2Bwc69Hgwuv/TFQT9n9lHnnzr2O0eqSam" +
       "YLoNfBaIORy+OtA8aFl0DvdROntj/XfeoJcgGwAD29o8k6RKpA+IDNqD0v6k" +
       "fO+MjD2Erz47DP7y8xUqizLKs+9+vHLy46u35G7L66pwrEcoH3Dgha/NJVDf" +
       "HSWaQ9TOg9yDi6NfadMX74DGKdCoAI3aYxbwXakMGa50XcMHP/1Z1/HrNSR+" +
       "gDTrJlUPUHnISBOgm9l5oMoS3/uwE9zZRni1SVNJhfHozw1LR2p/gQvp2/mf" +
       "dP9oz/cWPpKgclC0zp0uf2zBV7+PLvmp9xKY9x1GV6AhJttrBOmtRt3I2w5Z" +
       "o//WVytLZEl1+akLC+rYizuc4qGjPNXvh0r2B7/+1y8SF39/bYnc0SRM/oDO" +
       "Zpge2l4cltxUQfgjsmoLyGr3jds1Hz63pqWS61FTTxUm76/O5NEF3njqL2uP" +
       "fDF//C5IfEPEUVGV3x+5cu3gFuW5uCw8Hf6uKFjLJw2EXQaLWgwqbAPNwp6V" +
       "Eum9Pgo6MOg98OxyUbBraSJdAkA+PVWbusxBPrLM2CS+xgRpmYayzFSoPgrW" +
       "eABsk4cAi+6EU3TLgd34Sjsw//z/dqCwY6/sfsS3qBOHNsAz6Fo0ePfOqDY1" +
       "YnCt3EetZ9bmaufKOVPurcqTXo3SszuVhGoWEm6lhEO+lzZVqJueEYmDFuV5" +
       "TbFHAebSkuwyUTiBr8cEaVYsBiU1nm9P+84K7Xg06KxIaAW4uyQgzwMlYuaQ" +
       "tDCOrSBMx+4+TCW4LlSrDZEZ11TcVZ37lfLyQmtj98Kjv5H1iX8HaoHMnivq" +
       "euiUhE9MPbdYTpNOaHHyApdfkDa6q4QJkrfTkAZYjvwMoDUqL0id/A7LzYGT" +
       "AzlQ5TTCIk8IUgMi2Dzth+Gz1TAzaEAcBHpdXog0BXzncnOsMi3IoHR+WlD8" +
       "KeECB8Mu/03w2Kvo/J+QUV5ZODz6+K2HXnQKLEWn8/Py9gmXaafW8xlwU1Vt" +
       "nq76Q1vvrHq1aXPcRWa7s+HgKK4LwXYvJCuOmFgbqT7sPr8Ief/ynqtvn6u/" +
       "AenlKIlROE9HQ3d55+IKJUwR6PloKpxWQv9JycJooPmPx9/5+wexDplyiXPz" +
       "6FluRkY5f/XDdI7z78ZJ0zCpg2zISlOkWbO/NGeMM2UGioPGoqGdKrJhFaCY" +
       "NYuG/8fDKgQwRdKTnnEdutLvxQIdUnTFXwpLXFqgGpll1j7ULrNCJGcUOQ+P" +
       "lvBCvoRVEJsdl/5x5uvvjcEBK9t4WFuDXcz66Sf8v0aQj9ocHv0PfGLw/Bsf" +
       "DCl24LcgHUPuHX+jf8nnvOSM1WRSI5y7srFrEgacS+o4LxV/E1/fKqGEILF+" +
       "zv8LsEIKV9AUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xW/k14v/A2a8qYbzIAAA");
}
