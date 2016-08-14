package org.apache.batik.bridge;
public class SVGPolylineElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPolylineElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_POLYLINE_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPolylineElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPolylineElement pe =
          (org.apache.batik.dom.svg.SVGOMPolylineElement)
            e;
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedPoints _points =
              pe.
              getSVGOMAnimatedPoints(
                );
            _points.
              check(
                );
            org.w3c.dom.svg.SVGPointList pl =
              _points.
              getAnimatedPoints(
                );
            int size =
              pl.
              getNumberOfItems(
                );
            if (size ==
                  0) {
                shapeNode.
                  setShape(
                    DEFAULT_SHAPE);
            }
            else {
                org.apache.batik.parser.AWTPolylineProducer app =
                  new org.apache.batik.parser.AWTPolylineProducer(
                  );
                app.
                  setWindingRule(
                    org.apache.batik.bridge.CSSUtilities.
                      convertFillRule(
                        e));
                app.
                  startPoints(
                    );
                for (int i =
                       0;
                     i <
                       size;
                     i++) {
                    org.w3c.dom.svg.SVGPoint p =
                      pl.
                      getItem(
                        i);
                    app.
                      point(
                        p.
                          getX(
                            ),
                        p.
                          getY(
                            ));
                }
                app.
                  endPoints(
                    );
                shapeNode.
                  setShape(
                    app.
                      getShape(
                        ));
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_POINTS_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze5AURxnv3eOOe794hsfxOkjx2uUREskh5jju4HDv2OKA" +
       "Kg/D0jvbuzswOzPM9N4tF1GIpaBVUkguBK1wf1hEkIIQLVMalRRWjCFFjJUE" +
       "jdEKsRKrRCNlKMtoiRq/7p7ZeewDqRK3anpnu7/+ur+vf/37vu49dwNVmgZq" +
       "IyoN0X06MUPdKo1iwySJLgWb5laoi0lPVOC/7LzevzqIqgZRYxqbfRI2SY9M" +
       "lIQ5iGbKqkmxKhGzn5AE6xE1iEmMIUxlTR1Ek2SzN6MrsiTTPi1BmMB2bERQ" +
       "C6bUkONZSnotBRTNjMBMwnwm4U5/c0cE1Uuavs8Rn+oS73K1MMmMM5ZJUXNk" +
       "Nx7C4SyVlXBENmlHzkCLdU3Zl1I0GiI5GtqtrLJcsCmyqsAFc59p+vDW0XQz" +
       "d8EErKoa5eaZW4ipKUMkEUFNTm23QjLmXvRZVBFBdS5hitoj9qBhGDQMg9rW" +
       "OlIw+waiZjNdGjeH2pqqdIlNiKI5XiU6NnDGUhPlcwYN1dSynXcGa2fnrRVW" +
       "Fpj4+OLw6BM7m79TgZoGUZOsDrDpSDAJCoMMgkNJJk4MszORIIlB1KLCYg8Q" +
       "Q8aKPGKtdKspp1RMs7D8tltYZVYnBh/T8RWsI9hmZCWqGXnzkhxQ1q/KpIJT" +
       "YOtkx1ZhYQ+rBwNrZZiYkcSAO6vLuD2ymqBolr9H3sb2T4IAdB2fITSt5Yca" +
       "p2KoQK0CIgpWU+EBgJ6aAtFKDQBoUDStpFLmax1Le3CKxBgifXJR0QRSNdwR" +
       "rAtFk/xiXBOs0jTfKrnW50b/miOPqBvVIArAnBNEUtj866BTm6/TFpIkBoF9" +
       "IDrWL4ocx5MvHg4iBMKTfMJC5nufufnQkrZLl4XM9CIym+O7iURj0ql442sz" +
       "uhaurmDTqNY1U2aL77Gc77Ko1dKR04FhJuc1ssaQ3Xhpy08/deAseT+IantR" +
       "laQp2QzgqEXSMrqsEGMDUYmBKUn0ohqiJrp4ey8aD+8RWSWidnMyaRLai8Yp" +
       "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" +
       "/JUV7/0HOOvWyaccAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hk8885fFmdD/AniaYmxKJwAA");
}
