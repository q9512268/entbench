package org.apache.batik.bridge;
public class SVGAnimateElementBridge extends org.apache.batik.bridge.SVGAnimationElementBridge {
    public java.lang.String getLocalName() { return SVG_ANIMATE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGAnimateElementBridge(
                                                            ); }
    protected org.apache.batik.anim.AbstractAnimation createAnimation(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatableValue from =
          parseAnimatableValue(
            SVG_FROM_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue to =
          parseAnimatableValue(
            SVG_TO_ATTRIBUTE);
        org.apache.batik.anim.values.AnimatableValue by =
          parseAnimatableValue(
            SVG_BY_ATTRIBUTE);
        return new org.apache.batik.anim.SimpleAnimation(
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
          by);
    }
    protected int parseCalcMode() { if (animationType == org.apache.batik.anim.AnimationEngine.
                                                           ANIM_TYPE_CSS &&
                                          !targetElement.
                                          isPropertyAdditive(
                                            attributeLocalName) ||
                                          animationType ==
                                          org.apache.batik.anim.AnimationEngine.
                                            ANIM_TYPE_XML &&
                                          !targetElement.
                                          isAttributeAdditive(
                                            attributeNamespaceURI,
                                            attributeLocalName)) {
                                        return org.apache.batik.anim.SimpleAnimation.
                                                 CALC_MODE_DISCRETE;
                                    }
                                    java.lang.String calcModeString =
                                      element.
                                      getAttributeNS(
                                        null,
                                        SVG_CALC_MODE_ATTRIBUTE);
                                    if (calcModeString.
                                          length(
                                            ) ==
                                          0) {
                                        return getDefaultCalcMode(
                                                 );
                                    }
                                    else
                                        if (calcModeString.
                                              equals(
                                                org.apache.batik.util.SMILConstants.
                                                  SMIL_LINEAR_VALUE)) {
                                            return org.apache.batik.anim.SimpleAnimation.
                                                     CALC_MODE_LINEAR;
                                        }
                                        else
                                            if (calcModeString.
                                                  equals(
                                                    org.apache.batik.util.SMILConstants.
                                                      SMIL_DISCRETE_VALUE)) {
                                                return org.apache.batik.anim.SimpleAnimation.
                                                         CALC_MODE_DISCRETE;
                                            }
                                            else
                                                if (calcModeString.
                                                      equals(
                                                        org.apache.batik.util.SMILConstants.
                                                          SMIL_PACED_VALUE)) {
                                                    return org.apache.batik.anim.SimpleAnimation.
                                                             CALC_MODE_PACED;
                                                }
                                                else
                                                    if (calcModeString.
                                                          equals(
                                                            org.apache.batik.util.SMILConstants.
                                                              SMIL_SPLINE_VALUE)) {
                                                        return org.apache.batik.anim.SimpleAnimation.
                                                                 CALC_MODE_SPLINE;
                                                    }
                                    throw new org.apache.batik.bridge.BridgeException(
                                      ctx,
                                      element,
                                      org.apache.batik.bridge.ErrorConstants.
                                        ERR_ATTRIBUTE_VALUE_MALFORMED,
                                      new java.lang.Object[] { SVG_CALC_MODE_ATTRIBUTE,
                                      calcModeString });
    }
    protected boolean parseAdditive() { java.lang.String additiveString =
                                          element.
                                          getAttributeNS(
                                            null,
                                            SVG_ADDITIVE_ATTRIBUTE);
                                        if (additiveString.
                                              length(
                                                ) ==
                                              0 ||
                                              additiveString.
                                              equals(
                                                org.apache.batik.util.SMILConstants.
                                                  SMIL_REPLACE_VALUE)) {
                                            return false;
                                        }
                                        else
                                            if (additiveString.
                                                  equals(
                                                    org.apache.batik.util.SMILConstants.
                                                      SMIL_SUM_VALUE)) {
                                                return true;
                                            }
                                        throw new org.apache.batik.bridge.BridgeException(
                                          ctx,
                                          element,
                                          org.apache.batik.bridge.ErrorConstants.
                                            ERR_ATTRIBUTE_VALUE_MALFORMED,
                                          new java.lang.Object[] { SVG_ADDITIVE_ATTRIBUTE,
                                          additiveString });
    }
    protected boolean parseAccumulate() {
        java.lang.String accumulateString =
          element.
          getAttributeNS(
            null,
            SVG_ACCUMULATE_ATTRIBUTE);
        if (accumulateString.
              length(
                ) ==
              0 ||
              accumulateString.
              equals(
                org.apache.batik.util.SMILConstants.
                  SMIL_NONE_VALUE)) {
            return false;
        }
        else
            if (accumulateString.
                  equals(
                    org.apache.batik.util.SMILConstants.
                      SMIL_SUM_VALUE)) {
                return true;
            }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          element,
          org.apache.batik.bridge.ErrorConstants.
            ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_ACCUMULATE_ATTRIBUTE,
          accumulateString });
    }
    protected org.apache.batik.anim.values.AnimatableValue[] parseValues() {
        boolean isCSS =
          animationType ==
          org.apache.batik.anim.AnimationEngine.
            ANIM_TYPE_CSS;
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
        java.util.ArrayList values =
          new java.util.ArrayList(
          7);
        int i =
          0;
        int start =
          0;
        int end;
        char c;
        outer: while (i <
                        len) {
            while (valuesString.
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
                  valuesString.
                    charAt(
                      i);
                while (c !=
                         ';') {
                    i++;
                    if (i ==
                          len) {
                        break;
                    }
                    c =
                      valuesString.
                        charAt(
                          i);
                }
            }
            end =
              i++;
            org.apache.batik.anim.values.AnimatableValue val =
              eng.
              parseAnimatableValue(
                element,
                animationTarget,
                attributeNamespaceURI,
                attributeLocalName,
                isCSS,
                valuesString.
                  substring(
                    start,
                    end));
            if (!checkValueType(
                   val)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
                  valuesString });
            }
            values.
              add(
                val);
        }
        org.apache.batik.anim.values.AnimatableValue[] ret =
          new org.apache.batik.anim.values.AnimatableValue[values.
                                                             size(
                                                               )];
        return (org.apache.batik.anim.values.AnimatableValue[])
                 values.
                 toArray(
                   ret);
    }
    protected float[] parseKeyTimes() { java.lang.String keyTimesString =
                                          element.
                                          getAttributeNS(
                                            null,
                                            SVG_KEY_TIMES_ATTRIBUTE);
                                        int len =
                                          keyTimesString.
                                          length(
                                            );
                                        if (len ==
                                              0) {
                                            return null;
                                        }
                                        java.util.ArrayList keyTimes =
                                          new java.util.ArrayList(
                                          7);
                                        int i =
                                          0;
                                        int start =
                                          0;
                                        int end;
                                        char c;
                                        outer: while (i <
                                                        len) {
                                            while (keyTimesString.
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
                                                  keyTimesString.
                                                    charAt(
                                                      i);
                                                while (c !=
                                                         ' ' &&
                                                         c !=
                                                         ';') {
                                                    i++;
                                                    if (i ==
                                                          len) {
                                                        break;
                                                    }
                                                    c =
                                                      keyTimesString.
                                                        charAt(
                                                          i);
                                                }
                                            }
                                            end =
                                              i++;
                                            try {
                                                float keyTime =
                                                  java.lang.Float.
                                                  parseFloat(
                                                    keyTimesString.
                                                      substring(
                                                        start,
                                                        end));
                                                keyTimes.
                                                  add(
                                                    new java.lang.Float(
                                                      keyTime));
                                            }
                                            catch (java.lang.NumberFormatException nfEx) {
                                                throw new org.apache.batik.bridge.BridgeException(
                                                  ctx,
                                                  element,
                                                  nfEx,
                                                  org.apache.batik.bridge.ErrorConstants.
                                                    ERR_ATTRIBUTE_VALUE_MALFORMED,
                                                  new java.lang.Object[] { SVG_KEY_TIMES_ATTRIBUTE,
                                                  keyTimesString });
                                            }
                                        }
                                        len =
                                          keyTimes.
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
                                                 keyTimes.
                                                 get(
                                                   j)).
                                                floatValue(
                                                  );
                                        }
                                        return ret;
    }
    protected float[] parseKeySplines() {
        java.lang.String keySplinesString =
          element.
          getAttributeNS(
            null,
            SVG_KEY_SPLINES_ATTRIBUTE);
        int len =
          keySplinesString.
          length(
            );
        if (len ==
              0) {
            return null;
        }
        java.util.List keySplines =
          new java.util.ArrayList(
          7);
        int count =
          0;
        int i =
          0;
        int start =
          0;
        int end;
        char c;
        outer: while (i <
                        len) {
            while (keySplinesString.
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
                  keySplinesString.
                    charAt(
                      i);
                while (c !=
                         ' ' &&
                         c !=
                         ',' &&
                         c !=
                         ';') {
                    i++;
                    if (i ==
                          len) {
                        break;
                    }
                    c =
                      keySplinesString.
                        charAt(
                          i);
                }
                end =
                  i++;
                if (c ==
                      ' ') {
                    do  {
                        if (i ==
                              len) {
                            break;
                        }
                        c =
                          keySplinesString.
                            charAt(
                              i++);
                    }while(c ==
                             ' '); 
                    if (c !=
                          ';' &&
                          c !=
                          ',') {
                        i--;
                    }
                }
                if (c ==
                      ';') {
                    if (count ==
                          3) {
                        count =
                          0;
                    }
                    else {
                        throw new org.apache.batik.bridge.BridgeException(
                          ctx,
                          element,
                          org.apache.batik.bridge.ErrorConstants.
                            ERR_ATTRIBUTE_VALUE_MALFORMED,
                          new java.lang.Object[] { SVG_KEY_SPLINES_ATTRIBUTE,
                          keySplinesString });
                    }
                }
                else {
                    count++;
                }
            }
            else {
                end =
                  i++;
            }
            try {
                float keySplineValue =
                  java.lang.Float.
                  parseFloat(
                    keySplinesString.
                      substring(
                        start,
                        end));
                keySplines.
                  add(
                    new java.lang.Float(
                      keySplineValue));
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  nfEx,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_KEY_SPLINES_ATTRIBUTE,
                  keySplinesString });
            }
        }
        len =
          keySplines.
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
                 keySplines.
                 get(
                   j)).
                floatValue(
                  );
        }
        return ret;
    }
    protected int getDefaultCalcMode() { return org.apache.batik.anim.SimpleAnimation.
                                                  CALC_MODE_LINEAR;
    }
    protected boolean canAnimateType(int type) {
        return true;
    }
    public SVGAnimateElementBridge() { super(
                                         );
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
       "HxwCNKXvZqYL/Lio/eJpJyl2zvcdMPm+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Qyb/Vcnkv85uhuiXDMdX4lvb1x8f2td3/h/tqyh+58i2vn2jbRVff7co/v05" +
       "xvLHJbFvv5GxfO/WbRdKvf9pUfynPSfn9L3jpKX84e3Y0v7oYBH+6LZbyoX7" +
       "zmkr8kUu3H24pQFL4YMiZbPs++0jES9cfqsR2jXA7fP7sfu/t1fER89pe6wo" +
       "Ho4rD4HgtqcbSuLEh2FaaXbHUr79rS5kIWXvQMre7ZHywnGHnynFuXaOqO8t" +
       "iifjygNgFzpIAT38fXkcn1x46s2ImcWVd94iobTIiHv0hgz2fda19plXrlx+" +
       "5yvC7+z39cPM6HvoymUjcZyTCUwn3u8KQt0wSz3cs09nCkq5vh8wcYvfZGB7" +
       "Uo9+lV14/74/HFeunu0PoKv8e7JfI67ce9wPkNq/nOzSBoE76FK8IsHhVlZ7" +
       "w9Tbg38/ONJVtseqR08aTwkeD73RYpw4PHn6VBRW/ovB4fFEsv8ngxe0z74y" +
       "Yn/kW+2f3eeEao6S5wWVyyBg2qenHgRMJxOHzlI7pHXX4NnvPvC5e545PI55" +
       "YM/wsSGf4O3JmyddEm4Ql2mS+T9+5z/8gZ9/5Stlqtb/Be2qMN37MQAA");
}
