package org.apache.batik.svggen;
public class DOMGroupManager implements org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    public static final short DRAW = 1;
    public static final short FILL = 16;
    protected org.apache.batik.ext.awt.g2d.GraphicContext gc;
    protected org.apache.batik.svggen.DOMTreeManager domTreeManager;
    protected org.apache.batik.svggen.SVGGraphicContext groupGC;
    protected org.w3c.dom.Element currentGroup;
    public DOMGroupManager(org.apache.batik.ext.awt.g2d.GraphicContext gc,
                           org.apache.batik.svggen.DOMTreeManager domTreeManager) {
        super(
          );
        if (gc ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_GC_NULL);
        if (domTreeManager ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_DOMTREEMANAGER_NULL);
        this.
          gc =
          gc;
        this.
          domTreeManager =
          domTreeManager;
        recycleCurrentGroup(
          );
        groupGC =
          domTreeManager.
            gcConverter.
            toSVG(
              gc);
    }
    void recycleCurrentGroup() { currentGroup = domTreeManager.getDOMFactory(
                                                                 ).
                                                  createElementNS(
                                                    SVG_NAMESPACE_URI,
                                                    SVG_G_TAG); }
    public void addElement(org.w3c.dom.Element element) { addElement(
                                                            element,
                                                            (short)
                                                              (DRAW |
                                                                 FILL));
    }
    public void addElement(org.w3c.dom.Element element, short method) {
        if (!currentGroup.
              hasChildNodes(
                )) {
            currentGroup.
              appendChild(
                element);
            groupGC =
              domTreeManager.
                gcConverter.
                toSVG(
                  gc);
            org.apache.batik.svggen.SVGGraphicContext deltaGC;
            deltaGC =
              processDeltaGC(
                groupGC,
                domTreeManager.
                  defaultGC);
            domTreeManager.
              getStyleHandler(
                ).
              setStyle(
                currentGroup,
                deltaGC.
                  getGroupContext(
                    ),
                domTreeManager.
                  getGeneratorContext(
                    ));
            if ((method &
                   DRAW) ==
                  0) {
                deltaGC.
                  getGraphicElementContext(
                    ).
                  put(
                    SVG_STROKE_ATTRIBUTE,
                    SVG_NONE_VALUE);
            }
            if ((method &
                   FILL) ==
                  0) {
                deltaGC.
                  getGraphicElementContext(
                    ).
                  put(
                    SVG_FILL_ATTRIBUTE,
                    SVG_NONE_VALUE);
            }
            domTreeManager.
              getStyleHandler(
                ).
              setStyle(
                element,
                deltaGC.
                  getGraphicElementContext(
                    ),
                domTreeManager.
                  getGeneratorContext(
                    ));
            setTransform(
              currentGroup,
              deltaGC.
                getTransformStack(
                  ));
            domTreeManager.
              appendGroup(
                currentGroup,
                this);
        }
        else {
            if (gc.
                  isTransformStackValid(
                    )) {
                org.apache.batik.svggen.SVGGraphicContext elementGC =
                  domTreeManager.
                    gcConverter.
                  toSVG(
                    gc);
                org.apache.batik.svggen.SVGGraphicContext deltaGC =
                  processDeltaGC(
                    elementGC,
                    groupGC);
                trimContextForElement(
                  deltaGC,
                  element);
                if (countOverrides(
                      deltaGC) <=
                      domTreeManager.
                        maxGCOverrides) {
                    currentGroup.
                      appendChild(
                        element);
                    if ((method &
                           DRAW) ==
                          0) {
                        deltaGC.
                          getContext(
                            ).
                          put(
                            SVG_STROKE_ATTRIBUTE,
                            SVG_NONE_VALUE);
                    }
                    if ((method &
                           FILL) ==
                          0) {
                        deltaGC.
                          getContext(
                            ).
                          put(
                            SVG_FILL_ATTRIBUTE,
                            SVG_NONE_VALUE);
                    }
                    domTreeManager.
                      getStyleHandler(
                        ).
                      setStyle(
                        element,
                        deltaGC.
                          getContext(
                            ),
                        domTreeManager.
                          getGeneratorContext(
                            ));
                    setTransform(
                      element,
                      deltaGC.
                        getTransformStack(
                          ));
                }
                else {
                    currentGroup =
                      domTreeManager.
                        getDOMFactory(
                          ).
                        createElementNS(
                          SVG_NAMESPACE_URI,
                          SVG_G_TAG);
                    addElement(
                      element,
                      method);
                }
            }
            else {
                currentGroup =
                  domTreeManager.
                    getDOMFactory(
                      ).
                    createElementNS(
                      SVG_NAMESPACE_URI,
                      SVG_G_TAG);
                gc.
                  validateTransformStack(
                    );
                addElement(
                  element,
                  method);
            }
        }
    }
    protected int countOverrides(org.apache.batik.svggen.SVGGraphicContext deltaGC) {
        return deltaGC.
          getGroupContext(
            ).
          size(
            );
    }
    protected void trimContextForElement(org.apache.batik.svggen.SVGGraphicContext svgGC,
                                         org.w3c.dom.Element element) {
        java.lang.String tag =
          element.
          getTagName(
            );
        java.util.Map groupAttrMap =
          svgGC.
          getGroupContext(
            );
        if (tag !=
              null) {
            java.util.Iterator iter =
              groupAttrMap.
              keySet(
                ).
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                java.lang.String attrName =
                  (java.lang.String)
                    iter.
                    next(
                      );
                org.apache.batik.svggen.SVGAttribute attr =
                  org.apache.batik.svggen.SVGAttributeMap.
                  get(
                    attrName);
                if (attr !=
                      null &&
                      !attr.
                      appliesTo(
                        tag))
                    groupAttrMap.
                      remove(
                        attrName);
            }
        }
    }
    protected void setTransform(org.w3c.dom.Element element,
                                org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        java.lang.String transform =
          domTreeManager.
            gcConverter.
          toSVG(
            transformStack).
          trim(
            );
        if (transform.
              length(
                ) >
              0)
            element.
              setAttributeNS(
                null,
                SVG_TRANSFORM_ATTRIBUTE,
                transform);
    }
    static org.apache.batik.svggen.SVGGraphicContext processDeltaGC(org.apache.batik.svggen.SVGGraphicContext gc,
                                                                    org.apache.batik.svggen.SVGGraphicContext referenceGc) {
        java.util.Map groupDelta =
          processDeltaMap(
            gc.
              getGroupContext(
                ),
            referenceGc.
              getGroupContext(
                ));
        java.util.Map graphicElementDelta =
          gc.
          getGraphicElementContext(
            );
        org.apache.batik.ext.awt.g2d.TransformStackElement[] gcTransformStack =
          gc.
          getTransformStack(
            );
        org.apache.batik.ext.awt.g2d.TransformStackElement[] referenceStack =
          referenceGc.
          getTransformStack(
            );
        int deltaStackLength =
          gcTransformStack.
            length -
          referenceStack.
            length;
        org.apache.batik.ext.awt.g2d.TransformStackElement[] deltaTransformStack =
          new org.apache.batik.ext.awt.g2d.TransformStackElement[deltaStackLength];
        java.lang.System.
          arraycopy(
            gcTransformStack,
            referenceStack.
              length,
            deltaTransformStack,
            0,
            deltaStackLength);
        org.apache.batik.svggen.SVGGraphicContext deltaGC =
          new org.apache.batik.svggen.SVGGraphicContext(
          groupDelta,
          graphicElementDelta,
          deltaTransformStack);
        return deltaGC;
    }
    static java.util.Map processDeltaMap(java.util.Map map,
                                         java.util.Map referenceMap) {
        java.util.Map mapDelta =
          new java.util.HashMap(
          );
        java.util.Iterator iter =
          map.
          keySet(
            ).
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.String key =
              (java.lang.String)
                iter.
                next(
                  );
            java.lang.String value =
              (java.lang.String)
                map.
                get(
                  key);
            java.lang.String refValue =
              (java.lang.String)
                referenceMap.
                get(
                  key);
            if (!value.
                  equals(
                    refValue)) {
                mapDelta.
                  put(
                    key,
                    value);
            }
        }
        return mapDelta;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xbvNcpBaGuT7NkD1eVUTa5d+NMs+v8vS13VHv+fhX3d1zauSU4j+iTdqjYXn" +
       "uGBPfDNy2VfEWxgWDzMlrmixcKcSp6lsL4XnI0qfX314NqmO3u7uV1d+eMEd" +
       "Fwq9zcyB+U7/hy45fvTW7YcPiQNHxG5GFub6t0zmX3TwjjNPYHGt0cdN3zjy" +
       "3psbNqXWqALt6Nw00pc7lyQtEkfpZdnRBpuW8PLsPL50ERYLGal0+5JNeInj" +
       "TIv+H86UhGl8F/R47TM5458/4t8q8r37K0sm7V//kgiXqX+UjImQkt6Eqrov" +
       "JlzvxYZJexWuuTHimoIfxQbWMDIpxyEJXhbwF2Q80CT6X8xIlb8/hAb+7e7X" +
       "CpsYpx+QEi/uLpdAqg5d8HVd+pDJdckh7meSIq5NdSuRI/6E0+k+PcR9H4wm" +
       "xv95lYKDRLttyYf3r23dcfL828V9tKxK27cjlTJIM8TVuJ1m+L3CTS1Fq3jN" +
       "/FMV942ekzLWsYJhBwWnulJzSIoDBq74FN9lrVWbvrN9+cCyR/+0u/g5cLON" +
       "JACbnHEbM2+ykkYCYHFjJPM8H7IwfotcN/8nQ8sX9X74avrKyHtD6O/fLb9w" +
       "cNPzeycfqAmSsmZSpGhRmuRXbKuHtHVUHjC7SLliNSSBRaACuYnnsqACjVPC" +
       "/2RxvdjqLE/X4r8ZGJmVeVOS+R+QUlUfpOYq2AhGt4nksMypSeWDnnOkhGH4" +
       "Bjg1royxl6dGSQHrBd2RFsNIXSSVPmRwF43lRhI+Gzfh3v8Cc3iloZUpAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Z258tUSVgU4nd4Jf+vB/f2jxTvN9NxFM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8eg5Ps8P+Q+pl34Xf6vyty5Xbjm+IbwmBOtsp+fO3gveHWtpFvuLM7eDD5+9" +
       "63+k3KX9Jzr/jv1EKK4Rr/3qkRfcan/xgrZfLbJ/lFYeiDVlq7gaev79/PmX" +
       "xOvAUk+k86VXej98er6y4nNnwzggkN5/iPr9N4G6vFZ4+3WhXzoh+GBJ8C8v" +
       "wP9bRfbP08rdkqqeunr4tROIv/FaIXZB+tlDiD/744F4GDJRQiwypqT68gU4" +
       "/02R/fZFOL/0GnDeX1Q+BtLXDnF+7WZxaq+0lVlJ8IcXQPyjIvtqWrmiBJmf" +
       "TtdaHFuqllxPim+xDmNOS+T/9jUgL6/HGJD+5BD5n/x4kJ/a4exEkv/rBfC/" +
       "VWR/nAIbHVve4bXfMIivv9nffK2Qi6vfHx1C/uGPHfIHgc1/y41tfhlRtI8O" +
       "ePHvP/n7P/3ik39cRszcaSW8FPdi4zphpqf6fPelr3/7q697+PNl4NqtspTs" +
       "jfL5+Nxrw2/PRNWWGO49q+pABS6/vF+U/Xdaee9rDIMswp+lTQobdRU+e6d7" +
       "FGj5FzzD8clfvzAwaxFLflKE8rGppDiHUndekU+uDH9wdG38o+vLSSkGpdN0" +
       "7C/d7mq+sY9r/Y9F9v0wPy87xzfKJ5erqBv4WhHIdtS2D+S0goPj0G7QmF+X" +
       "08/tOS0nO+VqXU94T2nipbsuaLunyG5PK7cpBV97GBeQX8n3yv2/LqApw0G+" +
       "kwJZ1NLjXTin7//zNej7w0UlOKcv3bnvu/++GX0fvyoTV1r4Sw9dgPTNRQa2" +
       "8EpYRKMmyUBzUwlHy87HWC+98TVgvVpUAk/s0nOHWJ/7sWI9E4d01qwx0qb0" +
       "j59X/tn8G1/5zO4LL+3DjArzlFagG/2p4tr/dRTRuxfYzlPh9t/Hf/LlP/3P" +
       "/HuOPPB7jpfh0QL1Exctw5E2ve4kKpGSirZLzxZNl952PNbbj8TnoiW99GyZ" +
       "lcW3XiABtSJ7PK1cPS0BYOJzc5bG+Mqrm/NEcJ64GcHJARPnQsWLuNcHr/kP" +
       "yv5/E8rnX7x655te5P5wf+gc/bfhLrJyp5657ukYwlPl28NY061yc+7aRxSG" +
       "Jec/mVbedIPnsCKuryyUS9Ld078jrdx3nh7YoPL7NN27gYN4QgeG2hdOk6DA" +
       "ewIkRXFwHMFzKjJmH0qZXzr1BHeoZaUhuv+V1vi4y+lg6kKKy/8AHT2hZbND" +
       "ZfnCi2P6/d9r/9I+mFtxpd2uGOVOcFjv48qPn/Iev+FoR2PdPnr6h1e+eNdb" +
       "jvThyp7hE40/xduj14+cxrwwLWOdd//0Tb/2U//gxa+VAZn/H1D2S6icNQAA");
}
