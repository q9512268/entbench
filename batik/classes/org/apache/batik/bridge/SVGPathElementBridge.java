package org.apache.batik.bridge;
public class SVGPathElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.dom.svg.SVGPathContext {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_PATH_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPathElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPathElement pe =
          (org.apache.batik.dom.svg.SVGOMPathElement)
            e;
        org.apache.batik.parser.AWTPathProducer app =
          new org.apache.batik.parser.AWTPathProducer(
          );
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedPathData _d =
              pe.
              getAnimatedPathData(
                );
            _d.
              check(
                );
            org.w3c.dom.svg.SVGPathSegList p =
              _d.
              getAnimatedPathSegList(
                );
            app.
              setWindingRule(
                org.apache.batik.bridge.CSSUtilities.
                  convertFillRule(
                    e));
            org.apache.batik.dom.svg.SVGAnimatedPathDataSupport.
              handlePathSegList(
                p,
                app);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        finally {
            shapeNode.
              setShape(
                app.
                  getShape(
                    ));
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null &&
              alav.
              getLocalName(
                ).
              equals(
                SVG_D_ATTRIBUTE)) {
            buildShape(
              ctx,
              e,
              (org.apache.batik.gvt.ShapeNode)
                node);
            handleGeometryChanged(
              );
        }
        else {
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_RULE_INDEX:
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                break;
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    protected java.awt.Shape pathLengthShape;
    protected org.apache.batik.ext.awt.geom.PathLength
      pathLength;
    protected org.apache.batik.ext.awt.geom.PathLength getPathLengthObj() {
        java.awt.Shape s =
          ((org.apache.batik.gvt.ShapeNode)
             node).
          getShape(
            );
        if (pathLengthShape !=
              s) {
            pathLength =
              new org.apache.batik.ext.awt.geom.PathLength(
                s);
            pathLengthShape =
              s;
        }
        return pathLength;
    }
    public float getTotalLength() { org.apache.batik.ext.awt.geom.PathLength pl =
                                      getPathLengthObj(
                                        );
                                    return pl.
                                      lengthOfPath(
                                        );
    }
    public java.awt.geom.Point2D getPointAtLength(float distance) {
        org.apache.batik.ext.awt.geom.PathLength pl =
          getPathLengthObj(
            );
        return pl.
          pointAtLength(
            distance);
    }
    public int getPathSegAtLength(float distance) {
        org.apache.batik.ext.awt.geom.PathLength pl =
          getPathLengthObj(
            );
        return pl.
          segmentAtLength(
            distance);
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
      ("H4sIAAAAAAAAALV6eczs1nUfvyfpSe9peU+SLSmKtdnPieVxPs4+nCpxzCGH" +
       "w5nhMjPkcGbYJs/cyRluw2W4pGoTI63tGFDcVnbcNNYfgY02iRMnbYNuSKC2" +
       "aO0gbgEXQdIFiYO0QJK6BqICdYO6rXvJ+fa3OKqU74H3ce4999zzO/eccw/v" +
       "vV/4BnRfGEAV37Mzw/aiQy2NDtd26zDKfC08HFGtiRSEmorZUhjyoO6m8u5f" +
       "vvbNb33SvH4JuixCj0uu60VSZHluONNCz95pKgVdO63t25oTRtB1ai3tJDiO" +
       "LBumrDB6iYIePNM1gm5QxyLAQAQYiACXIsDoKRXo9LDmxg5W9JDcKNxCfwU6" +
       "oKDLvlKIF0EvnGfiS4HkHLGZlAgAhweK3wIAVXZOA+j5E+x7zLcA/lQFfvWn" +
       "fvj6378HuiZC1yyXK8RRgBARGESEHnI0R9aCEFVVTRWhR11NUzktsCTbyku5" +
       "Reix0DJcKYoD7URJRWXsa0E55qnmHlIKbEGsRF5wAk+3NFs9/nWfbksGwPrE" +
       "KdY9QqKoBwCvWkCwQJcU7bjLvRvLVSPouYs9TjDeGAMC0PV+R4tM72Soe10J" +
       "VECP7efOllwD5qLAcg1Aep8Xg1Ei6Ok7Mi107UvKRjK0mxH01EW6yb4JUF0p" +
       "FVF0iaB3XiQrOYFZevrCLJ2Zn28w3//Kj7ike6mUWdUUu5D/AdDp2QudZpqu" +
       "BZqraPuOD72f+rT0xK997BIEAeJ3XiDe0/yjv/zGhz7w7Otf3tN8921oWHmt" +
       "KdFN5XPyI199F/Zi955CjAd8L7SKyT+HvDT/yVHLS6kPPO+JE45F4+Fx4+uz" +
       "f7360Z/Xvn4JujqELiueHTvAjh5VPMe3bC0YaK4WSJGmDqErmqtiZfsQuh+8" +
       "U5ar7WtZXQ+1aAjda5dVl73yN1CRDlgUKrofvFuu7h2/+1Jklu+pD0HQ/eCB" +
       "ngfPIbT/+76iiKCbsOk5Giwpkmu5HjwJvAJ/CGtuJAPdmrAMrH4Dh14cABOE" +
       "vcCAJWAHpnbUIAeWamgwJwwmYLwiPoCevbLysDA0/89/iLRAeT05OAAT8K6L" +
       "7m8DzyE9W9WCm8qrca//xi/d/M1LJ+5wpJ8I+gAY9XA/6mE56uF+1MPbjQod" +
       "HJSDvaMYfT/TYJ42wONBLHzoRe6HRh/+2LvvASbmJ/cCJRek8J1DMnYaI4Zl" +
       "JFSAoUKvfyb5MeGvVi9Bl87H1kJiUHW16D4pIuJJ5Ltx0adux/faR//om1/8" +
       "9MveqXedC9ZHTn9rz8Jp331Rt4GnaCoIg6fs3/+89Ks3f+3lG5ege0EkANEv" +
       "koC1gsDy7MUxzjnvS8eBsMByHwCse4Ej2UXTcfS6GpmBl5zWlJP+SPn+KNDx" +
       "g4U1Pwee7pF5l/8XrY/7RfmOvZEUk3YBRRlof4DzP/vv/+0fN0p1H8fka2dW" +
       "OU6LXjoTBwpm10qPf/TUBvhA0wDd735m8rc+9Y2P/sXSAADFe2434I2ixID/" +
       "gykEav5rX97+h6/93ud+69Kp0URgIYxl21LSE5BFPXT1LiDBaN9zKg+IIzZw" +
       "tMJqbsxdx1Mt3ZJkWyus9H9fe2/tV//bK9f3dmCDmmMz+sB3ZnBa/1096Ed/" +
       "84f/57MlmwOlWMdOdXZKtg+Oj59yRoNAygo50h/7d8/87S9JnwVhFoS20Mq1" +
       "MlpBpQ6gctLgEv/7y/LwQlutKJ4Lzxr/ef86k2/cVD75W3/ysPAnv/5GKe35" +
       "hOXsXNOS/9LevIri+RSwf/Kip5NSaAK65uvMX7puv/4twFEEHBUQv0I2AMEm" +
       "PWcZR9T33f8f//m/fOLDX70HukRAV21PUgmpdDLoCrBuLTRBnEr9H/zQfnKT" +
       "B0BxvYQK3QJ+bxRPlb8uAwFfvHN8IYp849RFn/pfrC1/5A/+9BYllJHlNsvs" +
       "hf4i/IWfeRr74NfL/qcuXvR+Nr01AIPc7LRv/eed/3Hp3Zf/1SXofhG6rhwl" +
       "foJkx4XjiCDZCY+zQZAcnms/n7jsV+mXTkLYuy6GlzPDXgwup4EfvBfUxfvV" +
       "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" +
       "eQJEUkBSvD7pH1tS+y539HBN8cpbEuUq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fE5h6cGZPPtoCkrLe+w7TcdJl7OXuIrcvLyKfJxHx/vLyDeVL742Yn7kjfbn" +
       "95fIFFvK84LLAxR0//4+20ku/sIduR3zuky++K1HfvnKe4+/Gx7ZC3xqzmdk" +
       "e+72N7b6jh+Vd6zyf/zkP/z+v/va75Xn8v8Pk4nV4CMuAAA=");
}
