package org.apache.batik.bridge;
public class SVGAnimateMotionElementBridge extends org.apache.batik.bridge.SVGAnimateElementBridge {
    public java.lang.String getLocalName() { return SVG_ANIMATE_MOTION_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGAnimateMotionElementBridge(
                                                            ); }
    protected org.apache.batik.anim.AbstractAnimation createAnimation(org.apache.batik.dom.anim.AnimationTarget target) {
        animationType =
          org.apache.batik.anim.AnimationEngine.
            ANIM_TYPE_OTHER;
        attributeLocalName =
          "motion";
        org.apache.batik.anim.values.AnimatableValue from =
          parseLengthPair(
            SVG_FROM_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue to =
          parseLengthPair(
            SVG_TO_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue by =
          parseLengthPair(
            SVG_BY_ATTRIBUTE);
        boolean rotateAuto =
          false;
        boolean rotateAutoReverse =
          false;
        float rotateAngle =
          0;
        short rotateAngleUnit =
          org.w3c.dom.svg.SVGAngle.
            SVG_ANGLETYPE_UNKNOWN;
        java.lang.String rotateString =
          element.
          getAttributeNS(
            null,
            SVG_ROTATE_ATTRIBUTE);
        if (rotateString.
              length(
                ) !=
              0) {
            if (rotateString.
                  equals(
                    "auto")) {
                rotateAuto =
                  true;
            }
            else
                if (rotateString.
                      equals(
                        "auto-reverse")) {
                    rotateAuto =
                      true;
                    rotateAutoReverse =
                      true;
                }
                else {
                    class Handler implements org.apache.batik.parser.AngleHandler {
                        float
                          theAngle;
                        short
                          theUnit =
                          org.w3c.dom.svg.SVGAngle.
                            SVG_ANGLETYPE_UNSPECIFIED;
                        public void startAngle()
                              throws org.apache.batik.parser.ParseException {
                            
                        }
                        public void angleValue(float v)
                              throws org.apache.batik.parser.ParseException {
                            theAngle =
                              v;
                        }
                        public void deg()
                              throws org.apache.batik.parser.ParseException {
                            theUnit =
                              org.w3c.dom.svg.SVGAngle.
                                SVG_ANGLETYPE_DEG;
                        }
                        public void grad()
                              throws org.apache.batik.parser.ParseException {
                            theUnit =
                              org.w3c.dom.svg.SVGAngle.
                                SVG_ANGLETYPE_GRAD;
                        }
                        public void rad()
                              throws org.apache.batik.parser.ParseException {
                            theUnit =
                              org.w3c.dom.svg.SVGAngle.
                                SVG_ANGLETYPE_RAD;
                        }
                        public void endAngle()
                              throws org.apache.batik.parser.ParseException {
                            
                        }
                        public Handler() {
                            super(
                              );
                        }
                    }
                    ;
                    org.apache.batik.parser.AngleParser ap =
                      new org.apache.batik.parser.AngleParser(
                      );
                    Handler h =
                      new Handler(
                      );
                    ap.
                      setAngleHandler(
                        h);
                    try {
                        ap.
                          parse(
                            rotateString);
                    }
                    catch (org.apache.batik.parser.ParseException pEx) {
                        throw new org.apache.batik.bridge.BridgeException(
                          ctx,
                          element,
                          pEx,
                          org.apache.batik.bridge.ErrorConstants.
                            ERR_ATTRIBUTE_VALUE_MALFORMED,
                          new java.lang.Object[] { SVG_ROTATE_ATTRIBUTE,
                          rotateString });
                    }
                    rotateAngle =
                      h.
                        theAngle;
                    rotateAngleUnit =
                      h.
                        theUnit;
                }
        }
        return new org.apache.batik.anim.MotionAnimation(
          timedElement,
          this,
          parseCalcMode(
            ),
          parseKeyTimes(
            ),
          parseKeySplines(
            ),
          parseAdditive(
            ),
          parseAccumulate(
            ),
          parseValues(
            ),
          from,
          to,
          by,
          parsePath(
            ),
          parseKeyPoints(
            ),
          rotateAuto,
          rotateAutoReverse,
          rotateAngle,
          rotateAngleUnit);
    }
    protected org.apache.batik.ext.awt.geom.ExtendedGeneralPath parsePath() {
        org.w3c.dom.Node n =
          element.
          getFirstChild(
            );
        while (n !=
                 null) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE &&
                  SVG_NAMESPACE_URI.
                  equals(
                    n.
                      getNamespaceURI(
                        )) &&
                  SVG_MPATH_TAG.
                  equals(
                    n.
                      getLocalName(
                        ))) {
                java.lang.String uri =
                  org.apache.batik.dom.util.XLinkSupport.
                  getXLinkHref(
                    (org.w3c.dom.Element)
                      n);
                org.w3c.dom.Element path =
                  ctx.
                  getReferencedElement(
                    element,
                    uri);
                if (!SVG_NAMESPACE_URI.
                      equals(
                        path.
                          getNamespaceURI(
                            )) ||
                      !SVG_PATH_TAG.
                      equals(
                        path.
                          getLocalName(
                            ))) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      element,
                      org.apache.batik.bridge.ErrorConstants.
                        ERR_URI_BAD_TARGET,
                      new java.lang.Object[] { uri });
                }
                org.apache.batik.dom.svg.SVGOMPathElement pathElt =
                  (org.apache.batik.dom.svg.SVGOMPathElement)
                    path;
                org.apache.batik.parser.AWTPathProducer app =
                  new org.apache.batik.parser.AWTPathProducer(
                  );
                org.apache.batik.dom.svg.SVGAnimatedPathDataSupport.
                  handlePathSegList(
                    pathElt.
                      getPathSegList(
                        ),
                    app);
                return (org.apache.batik.ext.awt.geom.ExtendedGeneralPath)
                         app.
                         getShape(
                           );
            }
            n =
              n.
                getNextSibling(
                  );
        }
        java.lang.String pathString =
          element.
          getAttributeNS(
            null,
            SVG_PATH_ATTRIBUTE);
        if (pathString.
              length(
                ) ==
              0) {
            return null;
        }
        try {
            org.apache.batik.parser.AWTPathProducer app =
              new org.apache.batik.parser.AWTPathProducer(
              );
            org.apache.batik.parser.PathParser pp =
              new org.apache.batik.parser.PathParser(
              );
            pp.
              setPathHandler(
                app);
            pp.
              parse(
                pathString);
            return (org.apache.batik.ext.awt.geom.ExtendedGeneralPath)
                     app.
                     getShape(
                       );
        }
        catch (org.apache.batik.parser.ParseException pEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              element,
              pEx,
              org.apache.batik.bridge.ErrorConstants.
                ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_PATH_ATTRIBUTE,
              pathString });
        }
    }
    protected float[] parseKeyPoints() { java.lang.String keyPointsString =
                                           element.
                                           getAttributeNS(
                                             null,
                                             SVG_KEY_POINTS_ATTRIBUTE);
                                         int len = keyPointsString.
                                           length(
                                             );
                                         if (len == 0) { return null;
                                         }
                                         java.util.List keyPoints =
                                           new java.util.ArrayList(
                                           7);
                                         int i = 0;
                                         int start = 0;
                                         int end;
                                         char c;
                                         outer: while (i <
                                                         len) {
                                             while (keyPointsString.
                                                      charAt(
                                                        i) ==
                                                      ' ') {
                                                 i++;
                                                 if (i ==
                                                       len) {
                                                     break outer;
                                                 }
                                             }
                                             start =
                                               i++;
                                             if (i !=
                                                   len) {
                                                 c =
                                                   keyPointsString.
                                                     charAt(
                                                       i);
                                                 while (c !=
                                                          ' ' &&
                                                          c !=
                                                          ';' &&
                                                          c !=
                                                          ',') {
                                                     i++;
                                                     if (i ==
                                                           len) {
                                                         break;
                                                     }
                                                     c =
                                                       keyPointsString.
                                                         charAt(
                                                           i);
                                                 }
                                             }
                                             end =
                                               i++;
                                             try {
                                                 float keyPointCoord =
                                                   java.lang.Float.
                                                   parseFloat(
                                                     keyPointsString.
                                                       substring(
                                                         start,
                                                         end));
                                                 keyPoints.
                                                   add(
                                                     new java.lang.Float(
                                                       keyPointCoord));
                                             }
                                             catch (java.lang.NumberFormatException nfEx) {
                                                 throw new org.apache.batik.bridge.BridgeException(
                                                   ctx,
                                                   element,
                                                   nfEx,
                                                   org.apache.batik.bridge.ErrorConstants.
                                                     ERR_ATTRIBUTE_VALUE_MALFORMED,
                                                   new java.lang.Object[] { SVG_KEY_POINTS_ATTRIBUTE,
                                                   keyPointsString });
                                             }
                                         }
                                         len =
                                           keyPoints.
                                             size(
                                               );
                                         float[] ret =
                                           new float[len];
                                         for (int j =
                                                0;
                                              j <
                                                len;
                                              j++) {
                                             ret[j] =
                                               ((java.lang.Float)
                                                  keyPoints.
                                                  get(
                                                    j)).
                                                 floatValue(
                                                   );
                                         }
                                         return ret;
    }
    protected int getDefaultCalcMode() { return org.apache.batik.anim.MotionAnimation.
                                                  CALC_MODE_PACED;
    }
    protected org.apache.batik.anim.values.AnimatableValue[] parseValues() {
        java.lang.String valuesString =
          element.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        int len =
          valuesString.
          length(
            );
        if (len ==
              0) {
            return null;
        }
        return parseValues(
                 valuesString);
    }
    protected org.apache.batik.anim.values.AnimatableValue[] parseValues(java.lang.String s) {
        try {
            org.apache.batik.parser.LengthPairListParser lplp =
              new org.apache.batik.parser.LengthPairListParser(
              );
            org.apache.batik.parser.LengthArrayProducer lap =
              new org.apache.batik.parser.LengthArrayProducer(
              );
            lplp.
              setLengthListHandler(
                lap);
            lplp.
              parse(
                s);
            short[] types =
              lap.
              getLengthTypeArray(
                );
            float[] values =
              lap.
              getLengthValueArray(
                );
            org.apache.batik.anim.values.AnimatableValue[] ret =
              new org.apache.batik.anim.values.AnimatableValue[types.
                                                                 length /
                                                                 2];
            for (int i =
                   0;
                 i <
                   types.
                     length;
                 i +=
                   2) {
                float x =
                  animationTarget.
                  svgToUserSpace(
                    values[i],
                    types[i],
                    org.apache.batik.dom.anim.AnimationTarget.
                      PERCENTAGE_VIEWPORT_WIDTH);
                float y =
                  animationTarget.
                  svgToUserSpace(
                    values[i +
                             1],
                    types[i +
                            1],
                    org.apache.batik.dom.anim.AnimationTarget.
                      PERCENTAGE_VIEWPORT_HEIGHT);
                ret[i /
                      2] =
                  new org.apache.batik.anim.values.AnimatableMotionPointValue(
                    animationTarget,
                    x,
                    y,
                    0);
            }
            return ret;
        }
        catch (org.apache.batik.parser.ParseException pEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              element,
              pEx,
              org.apache.batik.bridge.ErrorConstants.
                ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
    }
    protected org.apache.batik.anim.values.AnimatableValue parseLengthPair(java.lang.String ln) {
        java.lang.String s =
          element.
          getAttributeNS(
            null,
            ln);
        if (s.
              length(
                ) ==
              0) {
            return null;
        }
        return parseValues(
                 s)[0];
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue() {
        return new org.apache.batik.anim.values.AnimatableMotionPointValue(
          animationTarget,
          0.0F,
          0.0F,
          0.0F);
    }
    protected void initializeAnimation() {
        java.lang.String uri =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            element);
        org.w3c.dom.Node t;
        if (uri.
              length(
                ) ==
              0) {
            t =
              element.
                getParentNode(
                  );
        }
        else {
            t =
              ctx.
                getReferencedElement(
                  element,
                  uri);
            if (t.
                  getOwnerDocument(
                    ) !=
                  element.
                  getOwnerDocument(
                    )) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_URI_BAD_TARGET,
                  new java.lang.Object[] { uri });
            }
        }
        animationTarget =
          null;
        if (t instanceof org.apache.batik.dom.svg.SVGOMElement) {
            targetElement =
              (org.apache.batik.dom.svg.SVGOMElement)
                t;
            animationTarget =
              targetElement;
        }
        if (animationTarget ==
              null) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              element,
              org.apache.batik.bridge.ErrorConstants.
                ERR_URI_BAD_TARGET,
              new java.lang.Object[] { uri });
        }
        timedElement =
          createTimedElement(
            );
        animation =
          createAnimation(
            animationTarget);
        eng.
          addAnimation(
            animationTarget,
            org.apache.batik.anim.AnimationEngine.
              ANIM_TYPE_OTHER,
            attributeNamespaceURI,
            attributeLocalName,
            animation);
    }
    public SVGAnimateMotionElementBridge() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7GZZ7OzHAtaejs1ibqT42JrNQcP+ygOg8c6pk9nFEhOWVO3fuXs02XPrUp4+" +
       "NHiD/SrIZe/8y7//FNn72pMFYkaVqWpLZDpEZdeak2DJeXk+vpvlbY5/WnHw" +
       "aMmha2fU5Lt3nKmpiPNeVNx5+xd4fOf7MzecO7h5An57jg8o/5S3dx94cs2p" +
       "4rVhlnpyl52XsnqZ2tyQwaI6hRxbQbGwp5ZZfXNOtQ2osib4nG2p9my/1XMH" +
       "y+wEm44cK9N2dQBrwKHeEDC2EZsek9QMQGKmioK8DqRhlDOgNGO2jml3hKfd" +
       "bGAFNnFusG1f7dxgx3mse60XjNnwabckap84GMVYAwROBIwlsbnIJJMADFvD" +
       "NhZNxfInnig5yFx83MjMxaEofDot8ToDkMlzJ3BsNV01wTHRZNYLWW3AnD5Y" +
       "QlY+Z0m/ME/6pJqOQBacjvDkEU7eBkEH3Nje9ACQh7DZAhFC1ClE2Ry7vdRp" +
       "eUvxZRKQKYHj9tIzxOXjRrwZhxbDZ4+Fzp5xbFHJB7YYawAUOwPGfoDNdlQm" +
       "3gbEoTCyAVqaBxA6S2HYjAxQUMqqrAmlF03yNEbOcTKoLjtuqBpxqAU+Y5a8" +
       "YxOHqhhrABzXBIxdi82PTTKZQbWWjsRVSTENA29WXHEKr7l6M2BGLFnixfXv" +
       "pr73qyc3V7zIo2NLQXJfzf7GpU/9XH35cNiuxwuxcMq1Rvezv+98p5+FqEqM" +
       "gbnA4Ip/7fqAK9Guz6E1E+WbA5/TLLTYt0noCa1B8WxhYqnquYNlF7v/m4Uw" +
       "g1lQPOy7dDX6i/nP7Bid/zpL+yolAxIHwK7AzYyL56MDrx4+WDv7LlYmlaIK" +
       "LPi9V1r5N1aeiyimmTps9maNYmYS16U01DVDlpnc3Xh06x8rtp0ftox0DzZL" +
       "kH1hwOWmd47o9oZXt9z87p3c1Px3ST5iumv3VV9Grt7N8zh+4TY/787LzcMv" +
       "3bjZ5XY3L2gVxrH6nbu3P3Db9ittydaYWO2pgpkXPPByyQcV32v50n2f7/jR" +
       "Cz2gli5SmVGkrRnalfTmUhVGJuE6L84dHetw7xqLOJOEFmlWvu3dwty8XJVd" +
       "kTtp3weHbnrzD0dvqeAoB2jHxzfjix45sfONz/KqH9xDWQGF+fj7ogduntlx" +
       "7mHG75TwyD0/m3/RA+bu8H7jjvQn4ebyR8Okoo/Ui9Z19EZBzmD13AcGbdh3" +
       "1DFS6xn3Xqfyu8O2XL57it9iXMv6Lw/c2io1PZqZwg9LiDDHfm/hVCWMj61o" +
       "PZIiyIxvCVTsMlUGrJj1M8ss8Wu/SUrgmOLjPpeiw3wqOzhOdVLWDllVKJbX" +
       "9hi/xJLUSO5yHAbzTYbFO75/tpgrA2XbCYhEjwSMPYrNGEgr4r64GAHkT/Do" +
       "6wrLIadcvD3rhPSfnJhMHEP6x1ak+XjiIb0Ya4CEBwPGnsfmaTBVyCjPpykh" +
       "I5sdgiyiB2H0o9wwsL1/PICeOTEJOaaHn1tSfj5xgIqxBoDwWsDYG9gcglKF" +
       "5TzsYBuMcLc3gVho7dyWgC19A1v6Ro7LTdi8lbUPSWvh9HuIrWAl+3hu+JKF" +
       "zs4BPqF19t8POvvY3McPPja/YfrE5u38E44/H8DmwYAj+xab7G1sHg5A70jA" +
       "2D+x+Qc2j/GdBNB+8lUP6csnzAZDJXwG/j0hGyzKWrj2w5/fYbN+WRyCECP7" +
       "wmuI2PV3R/hjxy083pmQJbCnJkuCpokLX4x1HOFDkwKEr8WmHGpZJnyMBa64" +
       "IOlf/zAhYKGK4wZslg1YqyV16ziA5V+uFGUNwOPkgLFZ2JzEXfqFUKDq8oik" +
       "DDDJcaTOEX/acYs/GYdOh70vs2RYNnF7KcYaIOKCgLHTsJkLCYqkQDqN2Yfv" +
       "6sOX65QOqVLSwWTexDHJmmR24Ms9vM6ekfe/B/x9uXjXaF3l9NEL/8orJ/ud" +
       "dg0UsqmMLLszP9dzuabTlMTAreF5oMaEX2qS6UXuzyDhS+Ru0EJncPplJqn3" +
       "00PmxL7ddCtMUu3QwVT8wU1yNqSNQIKPbZp9LqPjvwz1IJXlIcZzkc9c27im" +
       "6rqnn++pLNi/htiFUYb/cwhUjaMXrLv0yFm38ndooixs24azTIJyiL+pswpS" +
       "d53mn82eq7xz4bHJ91QtsOs0zzs8996YtYCls/ddM30vlYyW3LulF/ef89DT" +
       "u8oPQsGyiYQEsOVN+ZVEVsvoZM6mWKHCD2oJ9r6rrfrNzc9+9lKogb0kIbxO" +
       "awri6Beve+hQPKVpN4ZJVRcpgzKUZlmZc/6Isp6KQ7qnjixPqBklV91PRusV" +
       "8P6aIWMBWpvrxderJmnOr5XzXzlXy+ow1Vfi7DhNre/6P6Np7lGG7G38XCPS" +
       "YIr9sW5Ns946hm5hyGsantfQOvxx+38B3P4rs/8lAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "E/uoIPzMWXB47lDMI3ELEf9xIeJvpEfe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+fzN18PiIDs6XH1zh90Nc8uI+8pRxH3t/zDi8uJfFJOSF39xY2jlP38rL377" +
       "glj5SsHsL94oVr51Qdt/yYtv5MXnd5JcQPvt04HypbfAhfbu2PXdfd++C+2d" +
       "EHQLgu/eWpu9guyvzvpRYYITHb9zGzrmrwel9wBprh3qeO3/jo5791+gY377" +
       "YO8SSAcLHZkC4znJLK7QfPVYz727b0PP7zvS8/lDPZ9/s3q+4bvC3qMXtH1v" +
       "Xlzdgd4U5GyhvTVdvZjOc1o+fBtaPphX/gAQuHaoZe2tmc3TmlwQwnvP5sU1" +
       "sNKarhkXy+i53P7con3n2jOVE9WffDOqp3HpiQsvqOY37B674f787s63/OlX" +
       "L9/z6KvTf7vL9o7uZd/LlO7REts+fSHq1PMlP1Q1s7DQvbvrUX6hNhSXHr3F" +
       "+x7IWZbHb3x7Bzt6OC5dOU8P8oDi+zQdGpfuO6EDrHYPp0kaIPMBJPkj7h8t" +
       "F9AbX+g9Y6l0B9aPnXaqAlmuvtGEnNqWeeZMZl78e8PRxkey+weHF+XPvNpn" +
       "f+Kb9Z/b3TCVbSnLci73gCR6d9n1MIk+fQ3pPLcjXpd6z33nwV+999mjjZ4H" +
       "dwKfOPgp2Z68+RVO0vHj4tJl9k8f/Y0f+oVXv1Rc/Prf6ZSAOHcyAAA=");
}
