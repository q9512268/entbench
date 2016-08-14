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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RrZkpcHP89H8yQva9RX8EZ82/xfERAH+RicAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "L9zu+pcD918davlXb76Wf3ZB25/nxZ+A");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("BKCAqeI0PywIP30WAJ47FPNI3ELEf1GI+GvpkXc+f/M1rzjkDg9X2Nxhd8Pc" +
       "MuK+fBRxX/1/jLi8+NfFpOTFX9wYWvnX38qL374gVr5cMPuL14uVb17Q9t/z" +
       "4ut58bmdJBfQfut0oHzxTXChvTt2fXd/b9+F9k4IOgXBd26tzV5B9tdn/agw" +
       "wYmO374NHfOfAKXvB9JcO9Tx2t+Mjnv3X6BjfjNh7xJI+QodmQLjWcksrtd8" +
       "5VjPvbtvQ8/vOdLz+UM9n3+jer7u74G9Ry9o++68uLoDPQHkZYG9NV29mM5z" +
       "Wj58G1o+mFd+HxAYOdQSeXNm87QmF4Tw3rN5cQ2stKZrRsUyei5/P7do37nx" +
       "TOVE9SffiOppVHriwsur+e27x264P7+78y1/6pXL9zz6ivAfdhnd0b3se5nS" +
       "PVps26cvS516v+QHqmYWFrp3d3XKL9SGotKjt/hNB3KW5fGvur2DHX0tKl05" +
       "Tw/ygOLvaTo0Kt13QgdY7V5Ok2Ag8wEk+SvuHy0X0Otf9j1jqXQH1o+ddqoC" +
       "Wa6+3oSc2np55kz2Xfx7w9HmRrz7B4cX5U+/0hv+6DfqP7+7fSrbUpblXO4B" +
       "ifLuIuxhonz6itJ5bke8LtHPffvBX7732aPNnAd3Ap84+CnZnrz59U7K8aPi" +
       "Qmb2rx79tR/8xVe+WFwK+789ktjOdzIAAA==");
}
