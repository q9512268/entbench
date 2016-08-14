package org.apache.batik.bridge;
public abstract class AbstractSVGGradientElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.PaintBridge, org.apache.batik.bridge.ErrorConstants {
    protected AbstractSVGGradientElementBridge() { super(); }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element paintElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) { java.lang.String s;
                                                       java.util.List stops =
                                                         extractStop(
                                                           paintElement,
                                                           opacity,
                                                           ctx);
                                                       if (stops ==
                                                             null) {
                                                           return null;
                                                       }
                                                       int stopLength =
                                                         stops.
                                                         size(
                                                           );
                                                       if (stopLength ==
                                                             1) {
                                                           return ((org.apache.batik.bridge.AbstractSVGGradientElementBridge.Stop)
                                                                     stops.
                                                                     get(
                                                                       0)).
                                                                    color;
                                                       }
                                                       float[] offsets =
                                                         new float[stopLength];
                                                       java.awt.Color[] colors =
                                                         new java.awt.Color[stopLength];
                                                       java.util.Iterator iter =
                                                         stops.
                                                         iterator(
                                                           );
                                                       for (int i =
                                                              0;
                                                            iter.
                                                              hasNext(
                                                                );
                                                            ++i) {
                                                           org.apache.batik.bridge.AbstractSVGGradientElementBridge.Stop stop =
                                                             (org.apache.batik.bridge.AbstractSVGGradientElementBridge.Stop)
                                                               iter.
                                                               next(
                                                                 );
                                                           offsets[i] =
                                                             stop.
                                                               offset;
                                                           colors[i] =
                                                             stop.
                                                               color;
                                                       }
                                                       org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum spreadMethod =
                                                         org.apache.batik.ext.awt.MultipleGradientPaint.
                                                           NO_CYCLE;
                                                       s =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                           getChainableAttributeNS(
                                                             paintElement,
                                                             null,
                                                             SVG_SPREAD_METHOD_ATTRIBUTE,
                                                             ctx);
                                                       if (s.
                                                             length(
                                                               ) !=
                                                             0) {
                                                           spreadMethod =
                                                             convertSpreadMethod(
                                                               paintElement,
                                                               s,
                                                               ctx);
                                                       }
                                                       org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace =
                                                         org.apache.batik.bridge.CSSUtilities.
                                                         convertColorInterpolation(
                                                           paintElement);
                                                       java.awt.geom.AffineTransform transform;
                                                       s =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                           getChainableAttributeNS(
                                                             paintElement,
                                                             null,
                                                             SVG_GRADIENT_TRANSFORM_ATTRIBUTE,
                                                             ctx);
                                                       if (s.
                                                             length(
                                                               ) !=
                                                             0) {
                                                           transform =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                               convertTransform(
                                                                 paintElement,
                                                                 SVG_GRADIENT_TRANSFORM_ATTRIBUTE,
                                                                 s,
                                                                 ctx);
                                                       }
                                                       else {
                                                           transform =
                                                             new java.awt.geom.AffineTransform(
                                                               );
                                                       }
                                                       java.awt.Paint paint =
                                                         buildGradient(
                                                           paintElement,
                                                           paintedElement,
                                                           paintedNode,
                                                           spreadMethod,
                                                           colorSpace,
                                                           transform,
                                                           colors,
                                                           offsets,
                                                           ctx);
                                                       return paint;
    }
    protected abstract java.awt.Paint buildGradient(org.w3c.dom.Element paintElement,
                                                    org.w3c.dom.Element paintedElement,
                                                    org.apache.batik.gvt.GraphicsNode paintedNode,
                                                    org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum spreadMethod,
                                                    org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                                                    java.awt.geom.AffineTransform transform,
                                                    java.awt.Color[] colors,
                                                    float[] offsets,
                                                    org.apache.batik.bridge.BridgeContext ctx);
    protected static org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum convertSpreadMethod(org.w3c.dom.Element paintElement,
                                                                                                        java.lang.String s,
                                                                                                        org.apache.batik.bridge.BridgeContext ctx) {
        if (SVG_REPEAT_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.MultipleGradientPaint.
                     REPEAT;
        }
        if (SVG_REFLECT_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.MultipleGradientPaint.
                     REFLECT;
        }
        if (SVG_PAD_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.MultipleGradientPaint.
                     NO_CYCLE;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          paintElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_SPREAD_METHOD_ATTRIBUTE,
          s });
    }
    protected static java.util.List extractStop(org.w3c.dom.Element paintElement,
                                                float opacity,
                                                org.apache.batik.bridge.BridgeContext ctx) {
        java.util.List refs =
          new java.util.LinkedList(
          );
        for (;
             ;
             ) {
            java.util.List stops =
              extractLocalStop(
                paintElement,
                opacity,
                ctx);
            if (stops !=
                  null) {
                return stops;
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                paintElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return null;
            }
            java.lang.String baseURI =
              ((org.apache.batik.dom.AbstractNode)
                 paintElement).
              getBaseURI(
                );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              baseURI,
              uri);
            if (contains(
                  refs,
                  purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintElement,
                  ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              add(
                purl);
            paintElement =
              ctx.
                getReferencedElement(
                  paintElement,
                  uri);
        }
    }
    protected static java.util.List extractLocalStop(org.w3c.dom.Element gradientElement,
                                                     float opacity,
                                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.util.LinkedList stops =
          null;
        org.apache.batik.bridge.AbstractSVGGradientElementBridge.Stop previous =
          null;
        for (org.w3c.dom.Node n =
               gradientElement.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                e);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.AbstractSVGGradientElementBridge.SVGStopElementBridge)) {
                continue;
            }
            org.apache.batik.bridge.AbstractSVGGradientElementBridge.Stop stop =
              ((org.apache.batik.bridge.AbstractSVGGradientElementBridge.SVGStopElementBridge)
                 bridge).
              createStop(
                ctx,
                gradientElement,
                e,
                opacity);
            if (stops ==
                  null) {
                stops =
                  new java.util.LinkedList(
                    );
            }
            if (previous !=
                  null) {
                if (stop.
                      offset <
                      previous.
                        offset) {
                    stop.
                      offset =
                      previous.
                        offset;
                }
            }
            stops.
              add(
                stop);
            previous =
              stop;
        }
        return stops;
    }
    private static boolean contains(java.util.List urls,
                                    org.apache.batik.util.ParsedURL key) {
        java.util.Iterator iter =
          urls.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            if (key.
                  equals(
                    iter.
                      next(
                        )))
                return true;
        }
        return false;
    }
    public static class Stop {
        public java.awt.Color color;
        public float offset;
        public Stop(java.awt.Color color,
                    float offset) { super(
                                      );
                                    this.
                                      color =
                                      color;
                                    this.
                                      offset =
                                      offset;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ohsE7RAsiiZNT+NscTMsE0spmzdiJAtLQTdOJBgz/FFrAwtKRZ1tsXjBGDiM" +
           "qolMxr1JaNiEAqDOl60MFygPnozYXr9WFedLsE4n6yTFzkNdEXWDm7nCCuax" +
           "biWLGyN0PAgSpslW5rAAFooyTg9pn09nwiqo10DA9KXNdK2iHQmjqyOR52dp" +
           "k9IaW90rGV22FwuWlcbDCJ9UK44waBnzxtosc93SVJThzXwsN3AKj7WxXt1Q" +
           "E4LItyz+j7eVurfYNR7dMoEdVN7w9h9jt5TdesC94wGPzzCLE5d7z15YnDzD" +
           "PD6LgfLTotfc7k6pOBb7+LPPPa+MPlHZOzjDwsHm+OCq7yQfsAPMD+4PN8LY" +
           "//b4H8jz0E03kbvbM/mzz1+5+ODzs78pzr6PbrjuZqCLWmLbJ89JTpQv+KGq" +
           "mYXod+9OTfzi9UtgN38bIYGGu0KhzbM7+neD3f1Z+hg6X7xP0r0vhi4d0wFW" +
           "u8JJkl+NoTsASV78Nf8WRwe746Ls3OmJOnKUay+3rT4xt0+eOmgrboIPrDpI" +
           "dnfBN+TPPd8bvuPF+id2R/OyLW63OZeLDHTX7pbg6ALk8dtyO+R1ofvUDy5/" +
           "/u7XHXrL5Z3Ax65+QrbX3vocvO34cXFyvf2DB3/vjb/9/NeLk4z/AaWJxPGi" +
           "HwAA");
    }
    public static class SVGStopElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.Bridge {
        public java.lang.String getLocalName() {
            return SVG_STOP_TAG;
        }
        public org.apache.batik.bridge.AbstractSVGGradientElementBridge.Stop createStop(org.apache.batik.bridge.BridgeContext ctx,
                                                                                        org.w3c.dom.Element gradientElement,
                                                                                        org.w3c.dom.Element stopElement,
                                                                                        float opacity) {
            java.lang.String s =
              stopElement.
              getAttributeNS(
                null,
                SVG_OFFSET_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  stopElement,
                  ERR_ATTRIBUTE_MISSING,
                  new java.lang.Object[] { SVG_OFFSET_ATTRIBUTE });
            }
            float offset;
            try {
                offset =
                  org.apache.batik.bridge.SVGUtilities.
                    convertRatio(
                      s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  stopElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_OFFSET_ATTRIBUTE,
                  s,
                  nfEx });
            }
            java.awt.Color color =
              org.apache.batik.bridge.CSSUtilities.
              convertStopColor(
                stopElement,
                opacity,
                ctx);
            return new org.apache.batik.bridge.AbstractSVGGradientElementBridge.Stop(
              color,
              offset);
        }
        public SVGStopElementBridge() { super(
                                          );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO39gjL8BQwgYMDaSgd6FJBQikzTYscH0bE4Y" +
           "qGoSjrm9ubvFe7vL7px9duo2iVThRC1FhCQ0SvjLKWmVhKhq1FZtIqpITaKk" +
           "lZKipmkVUqmVSj9Qgyqlf9A2fW9m93Zvz2cUVPWkm9ubefPmff7em33hKqmx" +
           "LdLBdB7hUyazIwM6j1PLZql+jdr2AZhLKE9V0X8cuTJyV5jUjpGmLLWHFWqz" +
           "QZVpKXuMrFF1m1NdYfYIYyncEbeYzawJylVDHyPLVXsoZ2qqovJhI8WQ4BC1" +
           "YqSVcm6pyTxnQw4DTtbEQJKokCS6K7jcGyMNimFOeeQrfeT9vhWkzHln2Zy0" +
           "xI7RCRrNc1WLxlSb9xYsstk0tKmMZvAIK/DIMW2bY4K9sW1lJuh8ufmT66ey" +
           "LcIES6muG1yoZ+9ntqFNsFSMNHuzAxrL2cfJV0lVjCzxEXPSFXMPjcKhUTjU" +
           "1dajAukbmZ7P9RtCHe5yqjUVFIiT9aVMTGrRnMMmLmQGDnXc0V1sBm3XFbWV" +
           "Wpap+MTm6JmnjrR8v4o0j5FmVR9FcRQQgsMhY2BQlksyy96VSrHUGGnVwdmj" +
           "zFKppk47nm6z1YxOeR7c75oFJ/Mms8SZnq3Aj6CblVe4YRXVS4uAcv7VpDWa" +
           "AV3bPV2lhoM4DwrWqyCYlaYQd86W6nFVT3GyNrijqGPXF4EAti7KMZ41ikdV" +
           "6xQmSJsMEY3qmegohJ6eAdIaAwLQ4mRVRaZoa5Mq4zTDEhiRAbq4XAKqxcIQ" +
           "uIWT5UEywQm8tCrgJZ9/ro7sPPmgvkcPkxDInGKKhvIvgU0dgU37WZpZDPJA" +
           "bmzYFHuStr86GyYEiJcHiCXND79y7d4tHRfflDS3zkOzL3mMKTyhzCWb3l3d" +
           "33NXFYpRZxq2is4v0VxkWdxZ6S2YgDDtRY64GHEXL+7/+Zcf+h77a5jUD5Fa" +
           "xdDyOYijVsXImarGrN1MZxblLDVEFjM91S/Wh8gieI6pOpOz+9Jpm/EhUq2J" +
           "qVpD/AcTpYEFmqgenlU9bbjPJuVZ8VwwCSFt8CVrCAltJOIT6saRk/Fo1six" +
           "KFWorupGNG4ZqL8dBcRJgm2z0SRE/XjUNvIWhGDUsDJRCnGQZc5C0lJTGRbd" +
           "lYQ4pwofPbR7t0VTKmxHdICfPkEQwaAz/7/HFVD7pZOhEDhmdRAWNMioPYaW" +
           "YlZCOZPvG7j2UuJtGXKYJo7dOBkGCSJSgoiQICIliNxIgi5YGOWGWTJJQiEh" +
           "zTIUT4YIOHgcoAKwuqFn9IG9R2c7qyA2zclq9BGQdpbUrH4PT9wikFAutDVO" +
           "r7+89fUwqY6RNpApTzUsQbusDICbMu7kf0MSqplXVNb5igpWQ8tQWAowrVJx" +
           "cbjUGRPMwnlOlvk4uCUPkztaueDMKz+5eHby4UNfuy1MwqV1BI+sAQjE7XFE" +
           "/yLKdwXxYz6+zSeufHLhyRnDQ5KSwuTW07KdqENnMF6C5kkom9bRVxKvznQJ" +
           "sy8GpOcUMhNAtCN4RglQ9bqgj7rUgcJpw8pRDZdcG9fzrGVMejMikFtxWC5j" +
           "GkMoIKCoF3ePms/+5pd/vkNY0i0tzb6eYJTxXh+cIbM2AVytXkQesBgDug/P" +
           "xh9/4uqJwyIcgWLDfAd24dgPMAbeAQt+/c3jH3x0ee5S2AthDvU8n4S2qCB0" +
           "WfYpfELw/Q9+EYJwQkJRW7+Dh+uKgGjiyRs92QAaNcALDI6ugzqEoZpWaVJj" +
           "mD//au7e+srfTrZId2sw40bLlhsz8OZv6SMPvX3knx2CTUjB0uzZzyOTeL/U" +
           "47zLsugUylF4+L01336DPguVA9DaVqeZAGAi7EGEA7cJW9wmxjsDa9tx6Lb9" +
           "MV6aRr4WKqGcuvRx46GPX7smpC3twfx+H6Zmr4wi6QU4rIPIoVgQxC+utps4" +
           "riiADCuCQLWH2llgdufFkftbtIvX4dgxOFYBrLb3WQCmhZJQcqhrFv32Z6+3" +
           "H323ioQHSb1m0NQgFQlHFkOkMzsLOFwwv3CvFGSyDoYWYQ9SZqGyCfTC2vn9" +
           "O5AzufDI9I9W/GDn+XOXRViaksetfoYbxdiDwxYxH8bHz0Hs2qI7LBStJja1" +
           "uuXT/fVZzcc8JJ5XAiBUKiKyKqCh11RqiEQzN/fImXOpfc9tlW1LW2mTMQA9" +
           "9Iu//vc7kbO/f2ueClbrNLSeXGE8r6SsDItG0YO2D5tO/+HHXZm+z1JRcK7j" +
           "BjUD/68FDTZVrhBBUd545C+rDtyTPfoZisPagC2DLL87/MJbuzcqp8OiK5Z1" +
           "oaybLt3U67cqHGoxaP91VBNnGkVqbSgGSTvGRCcEwGYnSDYHU0ui+LyhFxKh" +
           "50UcZgNpWoDZAlgytsDa/Tgc4KQhA12koVBtBPRzI7ZFZBTeESLyjiAWduBw" +
           "UIq28ybTFSf6TDEfL+q4zMWi7Y6O2xcwGA5fKjdPpa0BE1QLQapdRbsXTk3n" +
           "WuhSL0XqyTuUSMrIRZzODpe00kYNU2U0Dw1i3FJzUGgnnBvK7fGjymxX/I8y" +
           "jW+ZZ4OkW/589JuH3j/2joj5OkyyYqT5EgyS0dcetOAQQSjpWeC+XypPdKbt" +
           "o/Fnrrwo5QlerwLEbPbMY59GTp6RECPvoBvKroH+PfIeGpBu/UKniB2Df7ow" +
           "85PnZ06EnUCNcWxlDMqLPgwVu+NlpTaUkt73aPNPT7VVDQJ6DZG6vK4ez7Oh" +
           "VGkGL7LzSZ9RvUurl8+OzNifcBLaBIVDTKsL5NQMDmCXesVi0L5g/++Gzt03" +
           "f5FwuYj0Y/+L9CtA8z7f/cQVdsfNCgsuWVn2Aka+NFBeOtdct+LcwfdFUSle" +
           "7BsgwtN5TfP5xu+nWtNiaVUYt0E2MKb4eZSTFRWEhJKX9LSZlfTfAEwL0kNc" +
           "iV8/3bfAeR4dsJIPfpLTnFQBCT4+XnTv7RUtpqs5yrHFFE2tqoDpnLIfKm9E" +
           "dsgm/wYuLm7xd+WY7OIVmZsPefmSDO6H5/aOPHjt88/JW4Gi0elp5LIEskDe" +
           "PYqVc31Fbi6v2j0915teXtztJmfJrcQvmwg0SFLRwa8KtMl2V7Fb/mBu52u/" +
           "mK19D2DlMAlRwNjDvhdU8m0M9Np5aFkOx8qzHboM0b/39jw9dc+W9N9/J3o8" +
           "Bx1WV6ZPKJfOP/Cr0yvnoM9fMkRqAHdYYYzUq/Z9U/p+pkxYY6RRtQcKICJw" +
           "UalWAiVNGL4UC6Owi2POxuIsXhc56SyHx/JLNvTDk8zqM/J6ygGjJd5Mybs7" +
           "t/nIm2ZggzfjqwhTEr/QGxCxidiwabp3reqjpkCC6SCkikmx+zviEYfz/wV1" +
           "nKjDPhcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ae+wsV12f++vtbXspvbcP2lrpk1u0LPnNvmcnlyK7Mzuz" +
           "Mzv7mJ3dmZ0Rucxzd3bn/diZHahSooKQINEWa4T6D0Ql5aGRaGIwNUaBQEww" +
           "xFciEGMiiiT0D5GIimdmf6/7u/e2KRp/yZ49e873fM/3+Tmv3wvfgW4OA6jk" +
           "udZ2YbnRvp5G+yursR9tPT3cp5nGWA5CXcMsOQynoO2K+thnL3zvBx9eXtyD" +
           "zknQ3bLjuJEcma4TTvTQtTa6xkAXjlu7lm6HEXSRWckbGY4j04IZM4wuM9Br" +
           "TgyNoEvMoQgwEAEGIsCFCHD7mAoMeq3uxDaWj5CdKPShn4XOMNA5T83Fi6BH" +
           "r2biyYFsH7AZFxoADrfmv3mgVDE4DaBHjnTf6XyNws+W4Gd+7R0Xf+8m6IIE" +
           "XTAdLhdHBUJEYBIJut3WbUUPwram6ZoE3enousbpgSlbZlbILUF3hebCkaM4" +
           "0I+MlDfGnh4Ucx5b7nY11y2I1cgNjtQzTN3SDn/dbFjyAuh677GuOw2JvB0o" +
           "eN4EggWGrOqHQ86uTUeLoIdPjzjS8VIfEICht9h6tHSPpjrryKABumvnO0t2" +
           "FjAXBaazAKQ3uzGYJYIeuCHT3NaerK7lhX4lgu4/TTfedQGq2wpD5EMi6HWn" +
           "yQpOwEsPnPLSCf98Z/iWD73L6Tl7hcyarlq5/LeCQQ+dGjTRDT3QHVXfDbz9" +
           "TcxH5Hs///49CALErztFvKP5g3e/9LY3P/TiF3c0P34dmpGy0tXoivpx5Y6v" +
           "vh57Ar0pF+NWzw3N3PlXaV6E//ig53Lqgcy794hj3rl/2Pni5M/F93xS//Ye" +
           "dJ6CzqmuFdsgju5UXdszLT0gdUcP5EjXKOg23dGwop+CbgF1xnT0XevIMEI9" +
           "oqCzVtF0zi1+AxMZgEVuoltA3XQM97DuydGyqKceBEF3gQ/0IASdeSNU/J15" +
           "PC8jaA0vXVuHZVV2TMeFx4Gb6x/CuhMpwLZLWAFRv4ZDNw5ACMJusIBlEAdL" +
           "/aBDCUxtocNtBcS5rEYcT5KBrJlgeI4V4KtTEOznQef9/06X5tpfTM6cAY55" +
           "/WlYsEBG9VxL04Mr6jNxp/vSp698ee8oTQ7sFkEDIMH+ToL9QoL9nQT7ryTB" +
           "JdDBRa53VSN05kwhzT25eLsQAQ5eA6gAIHr7E9zP0O98/2M3gdj0krO5jwAp" +
           "fGMsx47BhSogVAURDr34XPI0/3PlPWjvalDOVQJN5/Ph4xxKjyDz0ulkvB7f" +
           "C+/71vc+85Gn3OO0vArlD9Di2pF5tj922viBq+oawM9j9m96RP7clc8/dWkP" +
           "OgsgBMBmJIMwB4j00Ok5rsr6y4cImutyM1DYcANbtvKuQ9g7Hy0DNzluKaLi" +
           "jqJ+J7DxQ9CuOMqL4jvvvdvLy3t2UZQ77ZQWBUI/yXkf+5u/+OdaYe5DML9w" +
           "Ynnk9OjyCQDJmV0ooOLO4xiYBroO6P7+ufGvPvud9/10EQCA4g3Xm/BSXmIA" +
           "OIALgZl/4Yv+337j6x//2t5x0ERgBY0Vy1TTnZI/BH9nwOe/80+uXN6wS/67" +
           "sAMEeuQIgrx85jceywbAyAIZmkfQpZlju5ppmLJi6XnE/ueFxyuf+9cPXdzF" +
           "hAVaDkPqza/M4Lj9xzrQe778jn9/qGBzRs0Xw2P7HZPtEPbuY87tIJC3uRzp" +
           "03/54K9/Qf4YwGqAj6GZ6QXkQYU9oMKB5cIWpaKET/VV8+Lh8GQiXJ1rJzYt" +
           "V9QPf+27r+W/+8cvFdJeves56feB7F3ehVpePJIC9vedzvqeHC4BXf3F4dsv" +
           "Wi/+AHCUAEcVAF84CgAypVdFyQH1zbf83Z/86b3v/OpN0B4BnbdcWSPkIuGg" +
           "20Ck6+ESgFrq/dTbduGc3AqKi4Wq0DXK7wLk/uLXTUDAJ26MNUS+aTlO1/v/" +
           "Y2Qp7/2H719jhAJlrrNWnxovwS989AHsrd8uxh+nez76ofRatAYbvOOx1U/a" +
           "/7b32Lk/24NukaCL6sHukZetOE8iCeyYwsMtJdhhXtV/9e5nt9RfPoKz15+G" +
           "mhPTngaa41UC1HPqvH7+2OFPpGdAIt5c3Uf2y/nvtxUDHy3KS3nxEzur59Wf" +
           "BBkbFrtQMMIwHdkq+DwRgYix1EuHOcqDXSkw8aWVhRRsXgf24UV05Mrs77Zy" +
           "O6zKy9pOiqLevGE0XD6UFXj/jmNmjAt2hR/8xw9/5Zff8A3gIhq6eZObD3jm" +
           "xIzDON8o/+ILzz74mme++cECgAD68L/0u7Xv51z7L6dxXuB50T1U9YFcVa5Y" +
           "9hk5jAYFTuhaoe3LRuY4MG0ArZuDXSD81F3fWH/0W5/a7fBOh+EpYv39z3zg" +
           "h/sfembvxL76DddsbU+O2e2tC6Ffe2DhAHr05WYpRhD/9Jmn/ui3n3rfTqq7" +
           "rt4ldsEh6FN/9V9f2X/um1+6zhbkrOX+Lxwb3f7dXj2k2od/TEU0hGSWpoIx" +
           "qqGLFdPqsMlCHOAyt9CaBN1hzXU2FUO1V1a6ddEnXW4V2GisbAgd2TCIl6Ja" +
           "7FZNfrqcYBViibFlbrNi+oLNL/tLv0JIEeV71FTury2pb3r2mp/5Ns+tUHax" +
           "9S0DbVcNAbXRmrTJquqMHwvrnLtujG3DQHS7Vlv2fTtlNKajdZDlbCtnVDJo" +
           "ripjRvKt0koLqm1pyfS7KF+et9R4Sm/5xmq28kibYYQeIfgZK/Fefx4PAoKo" +
           "2JWhJhoiJW4dtavoYiYn9Nbi8d52zPDz0JWqvu9u6CXVEth6B6uIPserdtPb" +
           "TlOHTer4NFK6LN131xjX7CMrldwOhqZNjHSdDQx9im6WwjrrWU5V2pZTCplg" +
           "k2CoVgQmtTgFTUVwjF2Xo749kDZtqg/j1ECoKmK9j4ZCxaLjZSs27GmzqW8Z" +
           "lepyTTsmK1tXKqFO5BPDkOAGw16ctdOAqaoGzZctfoVlaXc+5oj5YLxS+8vZ" +
           "dDWraPKqHa8VW0LG6CTCenpj669mPEGZU1TmB1MymDiDgc3YLIk7c7XMV8KO" +
           "XZsTisALnuyVBlO7SdvOKpi0NnW3vGoQNj9BCXXCsotwsBSrHdZah9st2uS5" +
           "oDcjSYdPNHuVEX3PW9cRx25mFTEd6RNERRouQcMDO2xxkuPX2qsmpli8Xhcn" +
           "c56rx211g/AeLshtvqaM+aq1dAd1PAkEf4uJliyyWqspNB2Cn9bI7TAwVz45" +
           "nhP1bjsykf5AqlfMtcY3U9bm6HDQFWu+rS/cJd3U2xoltxOGrdsTfiJLrtwY" +
           "+PVsineX5qSt+PV5u++nKsXGlDBtzLrbhLVbERYsaAmFAxcJx2N7sVmr43WK" +
           "Uw7Z7y831GYxK2uLWQ0RJE/Cx3RbsTOR6MUAaVtNcit2TVrtmdh8iCPoFtHq" +
           "UW9iGBbO1bL1KGNq9qA/3S4zTFBqVk2r1YZzQvQmUupXzbC+KfPpWtBSqclV" +
           "xQWORxOxWSd73TlTQuCSpBqlJYLIIK7xBiGnGr4dieaKD+eULQdkMKwMpFSx" +
           "GJzvEqsBWuFgYdlamDrV9EbeKCuhtGfD3eXMr9I+sDbcVqee2CVsf6E71gxV" +
           "lNWYjnmpxScJxhFRC+MDrG1F9IiaNkN5soYJtxKaaZ8Q3CD2yCFZl3ympXXU" +
           "Cb2wq1mZm3Th+Wo23FDCksRnIU5PMIdkJbWBlS16Sk4UzRLZupe4xliZIFGZ" +
           "n/bttKdRmDFed9lEbmcwAvcIHkc8abTs4ktbm7SF4cB0x6IsiJaEjaTxhkRW" +
           "1VlMR+S8L9Iuoo06axLjaG7hmiyFUZY5TKmF2RDJkUAKU5pmze4ym1KzaV2k" +
           "Rr2F6rb7SewTDkqR6KSqIv62Xc1Uy0c7JKt5yizo1cdTNDHXRDuOcH4UIKUW" +
           "aswSX2xOhl7bm2azkFXiEKcwZRAja6M84HzPmvNDpWEuPIFtRazQdpOAp1NV" +
           "Wc3IyXiQONbI2qzrMTYbr7NIjnV80M9KDb2nbOuzoRFvK4PE5ysdqhS22VUX" +
           "mRNdeMv0tWSeilmzlHF6bPSY5Xbi4GyjzyXxVCgjfc3vDp0B0cQa67Vro8qE" +
           "T/ubzGHpcNsivZE6GyyH7Qgb1icLi0UVf7FCgtlCpb2k5U1wSVNJ1MgCkh/o" +
           "qwHQN0oFrLEi1wOX6mMuUdPHdgiXGp4Gb9ZDsWyWo0xp6iI9TefLkkopg2qb" +
           "30bzNauHnQUeL+BxukTheuzTyZZSFwKDG22tWtcW40Fb0dtsVILV2qpXS8u6" +
           "3uCq7WiJb2Ytp85VfaxTFgzRM7pMArNoqSvSCbumJwJSwpeluL8gV+Z2EqJV" +
           "ti0P1TaDU814kfldV/IEmadXNg7DcozopTAwpoFEadUwqZcVxlqGWWskbZrc" +
           "YLyZ19ZOWsWms1WnHGdSth1NdQae1ZGMCePFbGsR9RJTrtRqTXy8iPk2isu8" +
           "r0ttsm0iXbLbRlRaQBM7XYW4jEZpk1HQAd+UJ0Fd6PukGm8mab0JgAkJbQ+r" +
           "RYmRlnpNyQ7qidlkZ/WAGlMuv2BTrBRHXlgPTLONYzHGgvWpalkLLTaItREp" +
           "EbWZA5ulI0LsBIxSE1jMXko0q/rLgNjUqlKzVOvVqjXTZXucUrHLQ3ZBsFaP" +
           "WI/WgyxkRkSSbGrYhiC5Le6KgsiinOSTW8yYYtWNg44a7Sw2cAqlUAEGyF+a" +
           "j+YT3pTXoR4ZrqikmoknqZj2WkovK/fCqk8hTIeL6JVcieP5FDZ4KVPVFk03" +
           "5m2zM+ub/W3fx5aVysQ3u2w2hA3Kno88Q0UjS6gwQtWeDtg2ilIxDG9UZK2M" +
           "YKMa65ilBEOG0+dktxU0OZBPEVkWR1W8EY3gUq83l+xSVqEnKlhgOwDy4GaL" +
           "wKcSHyw7nZnWqDewUoBH2+nYcCUzHIPjbxVnmBYCD2glzlTfa43MfkOquPJW" +
           "YaLarImofo90U3mMVvjO0CHXvK9wC5KbbsgJpnYTUnQ4XOzNyrFZYrZLIu0v" +
           "G+WZKi2GnuDiUttabCPgeni6UOt9dtmuVNcu34k640lGIRIhdaZ6l2O2K7Mt" +
           "aHEnmVF+tbVVpgRnNMGKYzAlsPQMBBMRm6NqqiZku2H0V9rYk8udboVlWNnT" +
           "Jko4n65rjhAvOaY897fTeMYNAmoiZSPc08vltTicVWdlPKmYNYLOZuTCcTqb" +
           "PmKQq62dzmGqtV0JJUmqj9YC3GihdNyrreDqyl01RuvtVvSnje5iy5U1VY9G" +
           "bZblVp6gY6X51htrfSVyYcIJgsRtsOBkkTBdZawMxAZKTr3mpIuNNy6YK3B7" +
           "pbFB6aTXieFZ3zE7VdxA3KTVGDtSudl1ZthQFVILH/jMeJHwcWloeVN5to6Q" +
           "mjwejqcIz+Ms3cQlsrnp1/UMGS15ck0yCJNxEjrZzOLAapVG2dA01A4jdyge" +
           "n/ZDpjFkB7iNzfWQN8tMYwGXSmQWlWtGg0hicVUW4RKDYlG7lSEGrLK8FhpD" +
           "bBHGAu9U22u5NCQ6+ijS1KjEqImhETPO0pFOuEiiYWNqjBtpXHKEaGjK/EyM" +
           "yt3qoK/UdYmbEhOhu6T7c5ThJMuYGu1uwpTXQ9XkW3BNMdr6pK6FNDU2PGbq" +
           "EGwHm9ZLc2e6QSazyPPDxjboEUS3Gvku7jkMZfRttKuFCxtOxJixkVQrCSIy" +
           "onhbCse6YXP4qNlrwPJo3FtFrRZMC3XSLOuW12CobrjG9bHo82qtQihmc1Nd" +
           "ldFKI9LnURbRtkEHKruxk0WZI5hJIrf60cCq8gihwHYnblRj2O5XULyKW4O2" +
           "NUmGK3yz1GYtuzxAh15DBgCStvysp7iDsgLX0FWCampJQIcoTNfcVietCHxT" +
           "GvdpYzSGsaC83TjuADUG64nf7mmiKGYzH5bQGeyVvHUqguVyErFqn8LoZCZb" +
           "QtvkhyRTn2HNUWJWx6M0psL5Um00uW0vhWlmuJni61bmD2C6uQWAT2uNwVYJ" +
           "kQh2KLsqLRaZsfKT5bQbwCyZYqmpmYmseLVA91feGsOaHLY213ZayjZmVzQy" +
           "OOErTn+Fj5cqOOA8+WR+9Hn7qzt93lkctI8eUMChM+8gX8WpK73+hHvHE6ZH" +
           "d47F7cudh3fwh98n7hxP3MucOTzrP3Sjm+jd1XJ+Dn3wRq8qxRn04+995nlt" +
           "9InK3sG1lxBB5w4eu46n2wNs3nTjw/ageFE6vov5wnv/5YHpW5fvfBW3zQ+f" +
           "EvI0y98ZvPAl8o3qr+xBNx3dzFzz1nX1oMtX38ecD/QoDpzpVbcyDx5Z/97c" +
           "2I8By5YOrF+6/o3vdf15pvDnLmxe5koxfpm+JC/Auf72hR4xripbwwPRyeNI" +
           "81/pfH+SadFgH+l3z+GNNnKgH/J/o9/ZguDsYTw+/vLxePCgekh9d06d1NR9" +
           "zbX3D95E8q6fLwgmJ7KLzy/BLFeOCiGefhlDfiAv3h1B59VAlyM9f205nO7J" +
           "H/3Z5pBL4YenXo0f0gi653qvPodCtX5UoUBO3n/Ns/buKVb99PMXbr3v+dlf" +
           "Fw8nR8+ltzHQrUZsWSdvKU/Uz3mBbpiFEW/b3Vl6xdezEXTfDYQEYKEca/PM" +
           "jv65CLp4mh64r/g+SfcbwEnHdIDVrnKS5PkIugmQ5NXfPHJj9YYWc0xbjvJn" +
           "hOLhwlSB6Q5w8MwJNDvIjcKVd72SK4+GnHx5yRGw+MeDQ7SKd/96cEX9zPP0" +
           "8F0vNT+xe/lRLTnLci63MtAtu0eoI8R79IbcDnmd6z3xgzs+e9vjh9B8x07g" +
           "4zw9IdvD139a6dpeVDyGZH943++/5bee/3pxIfs/94QfCBEiAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae5AUxRnv3Xtwd3BP4EDejwMK0F1FjZoT4nHewZnlODk8" +
       "ywM8Zmd774abnRlmeu8WlKikUiJGyhgUk9LLH0FRg2JZsYwx6qWsoEZjBTU+" +
       "gq9Ek2iUUmI0KUlivq97ZuexD8RIqJreue6vv+7v+37fo3vYf4SUWSaZQTUW" +
       "YVsMakXaNNYlmRZNtKqSZa2Fvj55T4n08eXvdp4XJuW9pGZAslbJkkXbFaom" +
       "rF4yXdEsJmkytTopTeCMLpNa1BySmKJrvWSiYnWkDFWRFbZKT1Ak6JHMGKmX" +
       "GDOVeJrRDpsBI9NjsJMo30m0JTjcHCPjZN3Y4pJP9pC3ekaQMuWuZTFSF9sk" +
       "DUnRNFPUaEyxWHPGJIsNXd3Sr+osQjMsskk921bBRbGzc1Qw5/7aT4/dOFDH" +
       "VTBe0jSdcfGsNdTS1SGaiJFat7dNpSlrM/kWKYmRsR5iRppizqJRWDQKizrS" +
       "ulSw+2qqpVOtOheHOZzKDRk3xMhsPxNDMqWUzaaL7xk4VDBbdj4ZpJ2VlVZI" +
       "mSPizYuju/dcXvdACantJbWK1o3bkWETDBbpBYXSVJyaVksiQRO9pF4DY3dT" +
       "U5FUZatt6QZL6dcklgbzO2rBzrRBTb6mqyuwI8hmpmWmm1nxkhxQ9l9lSVXq" +
       "B1kbXVmFhO3YDwJWKbAxMykB7uwppYOKlmBkZnBGVsambwIBTB2TomxAzy5V" +
       "qknQQRoERFRJ6492A/S0fiAt0wGAJiNTCjJFXRuSPCj10z5EZICuSwwBVSVX" +
       "BE5hZGKQjHMCK00JWMljnyOd5++6QluphUkI9pygsor7HwuTZgQmraFJalLw" +
       "AzFx3KLYLVLjozvChADxxACxoHnoyqMXnDpj9ClBMzUPzer4JiqzPnlvvObQ" +
       "tNaF55XgNioM3VLQ+D7JuZd12SPNGQMiTGOWIw5GnMHRNQcvu/oe+n6YVHWQ" +
       "cllX0ynAUb2spwxFpeYKqlFTYjTRQSqplmjl4x1kDLzHFI2K3tXJpEVZBylV" +
       "eVe5zv8GFSWBBaqoCt4VLak774bEBvh7xiCE1MFDIvCcRsS/xdgwMhgd0FM0" +
       "KsmSpmh6tMvUUX4rChEnDrodiMYB9YNRS0+bAMGobvZHJcDBALUH4qaS6KfR" +
       "ljjgXJJZd8+KFaaUUGA6Rgf4Wc4JIgg64/+7XAalHz8cCoFhpgXDggoetVJX" +
       "E9Tsk3enl7cdva/vGQE5dBNbb4ycCzuIiB1E+A4iYgeR4+2AhEJ84Qm4E4EG" +
       "sOUgRAUIy+MWdm+4aOOOOSUAQ2O4FAyBpHN86anVDR1OvO+TDzRUb539xhlP" +
       "hElpjDTA8mlJxWzTYvZDHJMHbVcfF4fE5eaPWZ78gYnP1GWagPBVKI/YXCr0" +
       "IWpiPyMTPByc7IZ+HC2cW/Lun4zeOnxNz1Wnh0nYnzJwyTKIdji9CwN9NqA3" +
       "BUNFPr6117776YFbtulu0PDlICd15sxEGeYEoRFUT5+8aJb0YN+j25q42ish" +
       "qDMJnBDi5YzgGr6Y1OzEd5SlAgRO6mZKUnHI0XEVGzD1YbeHY7aev08AWNQ4" +
       "XrvE9lr+i6ONBraTBMYRZwEpeP5Y2m3c/spz753J1e2kmlpPjdBNWbMnvCGz" +
       "Bh7I6l3YrjUpBbrXb+36/s1Hrl3HMQsUc/Mt2IRtK4Q1MCGo+TtPbX71zTf2" +
       "vhh2cc5IpWHqDJyeJjJZOXGIVBeRExac724JIqQKHBA4TZdoAFElqUhxlaJv" +
       "/at23hkPfrCrTkBBhR4HSacen4Hbf8pycvUzl/9jBmcTkjFDu2pzyUTYH+9y" +
       "bjFNaQvuI3PN89N/8KR0OyQQCNqWspXyOEy4Ggi329lc/tN5e1Zg7Bxs5lle" +
       "/PtdzFNJ9ck3vvhRdc9Hjx3lu/WXYl5zr5KMZoEwbOZngP2kYHxaKVkDQHfW" +
       "aOf6OnX0GHDsBY4yRGNrtQnhMuMDh01dNub3v3yiceOhEhJuJ1WqLiXaJe5n" +
       "pBIATq0BiLQZ4xsXCOMOVzgJKUNyhM/pQAXPzG+6tpTBuLK3/mzST8/fN/IG" +
       "B5oheEz1MlzA20XYnMb7wwwKzXQc6nVGKiQ7mLuA5P9qnTTp/HoB6S4R5u+T" +
       "GZlbKFl0Qbiw84JDO78QbZtp6ma2JkYTTS9ULPFCb+/23SOJ1XecIUqaBn8B" +
       "0gb19b0v/fvZyK1vPZ0nu1Uy3ThNpUNU9YhTjkv6UtEqXke64fD1mpvefrip" +
       "f/mJZCHsm3GcPIN/zwQhFhXOKsGtPLn9r1PWLhvYeAIJZWZAnUGWd6/a//SK" +
       "+fJNYV40i1ySU2z7JzV7FQuLmhROBxqKiT3V3OXmZrFVj1CaBs9SG1tL8wf1" +
       "vLgN4WtbIHJWFWEWiDFlnEuZA8N5hWAo0Gofixzq8Ug9fKYcSeipiF3u4FCf" +
       "QzA7h13/EItAgWQMKLLVCTb21zmImu40eF+XqaQgBQ3ZtfySro3yjqaudwSo" +
       "T8kzQdBNvCt6Q8/Lm57l5q9AvGWV7sEa4NKTXeuE7j6HfyF4/oMP6gw7RE3c" +
       "0GoX5rOylTkGFZMsLHKU9gsQ3dbw5uBt794rBAieXALEdMfunZ9Hdu0WHiqO" +
       "d3NzTljeOeKIJ8TBJom7m11sFT6j/S8Htj1y17Zrw3aS6WRYFegSy8IjlK1G" +
       "J/iVLnZ64XW1v7ixoaQdPL+DVKQ1ZXOadiT86B9jpeMeK7jnQdcX7D2jxhkJ" +
       "LQLl8u71RfIhx1kPI2Nlk4JBeER1UFfDs4M0zCJu97nYXCr8pPlLJh7saDF4" +
       "/xp/STYVnutth7v+BLw3jK8RbNoDLtwIz06b487iLlzJWVVyx8s2kqOMZTku" +
       "iFhF5axKq0wxVOqcV7iymlq3yCoV4QyzhcNm6Ymy0VXd7AZ66uUyPWuZfgoh" +
       "oyWZhLp5rSlpFpbC/iu5rGvzEkrgbf3Yg49bP/7zA8KN8gWOwCXAXfsq5MOp" +
       "g+84CE9ktYym5yXmxbaWLw7aDbYzr7CDe3Y1cufc564amfsHXhtVKBbkMggx" +
       "ea41PHM+2v/m+89XT7+P58xSjFS2f/jvg3Kve3y3OFymWmy+m8lFP7eBYRgk" +
       "6M7452Yx4bqsQqag/DPhWWArZIGIfpf+j0d0mJaK8q20wBvPxs7p/2SxFqLd" +
       "gM1uriKaJ6BN89U0/FrXTfr3vHDO7/Z975ZhAbQicT4wb/Jnq9X49j/+M6fw" +
       "5vVHntAfmN8b3X/blNZl7/P57skSZzdlcq8tAGnu3CX3pD4Jzyn/VZiM6SV1" +
       "sl0y9khqGs9rvYAly6kjY6TaN+6/BhR3Xs3ZamdaMPd4lg2eab2Rv5T5ony9" +
       "sEeIcP/6UZGI2IZ5SNEklc9LQmmuUq2fDXDiATvB4Q9srkQRNccew43YYX8d" +
       "Lo5jKBrUyrpG8WTnjIn7GEWPZC91YTCTAxce81087RGbx+Yyvp0imer+ImMP" +
       "YHMvSCvjvoQYRcgfLJSTMgVcHNsNvN1ehO3D2FzJSHU8ragJJ45j55CbO7ed" +
       "hNzZjGOd8IzYIWfkhHMnYMPiN/aB/DmhCNeAKko4uxKeOh1Y1LmQEZfiriYP" +
       "FtHkr7F5HBAH3gWHGNZtQHWSENkUh77t6nP0JOiTh/B58DxkS/7QCesTmyfy" +
       "6LIQxyK65IHX1dtLRfT2Cja/hWoO4iu/RYWDqP/Y6SZ4aZgfeKEYWFDX2HTe" +
       "x3PsmjoPreczwq5Hft7bu6BOdgqBnf4CrgGeu20R+S8j67+K5MSg5IaIulZJ" +
       "0YR9QHKS30nlz69yfAnO1dtPBtWWD8+9c6nQ2+wCuc2lf/jitw7dvvXAfnEc" +
       "wVKFkcWFPujlfkXEO9UidZTHRp+s+Proe2/3bHBsVIPN64HCxr6aEtd4fypS" +
       "2XAvO3SyvGwRPIdtwBz+yrysEMcv7mV/K+Jlf8fmAwhutpfFdFlS0dWw/zVX" +
       "aUdOgtLwhETmgoVKBE/x+0WVxsgYw1SG4KCXT3MNRdgG1BF2jfCag6uZOUcb" +
       "8bGOw/iSNTHcWShUWK+hMuz8jJEKu16zOJWMjV2nBGqWMXFdV6mkHQ+9x74K" +
       "Q2QYmXW8r1MYbCfnfCkXX3fl+0ZqKyaNXPKyOKo4X2DHxUhFMq2q3nrP814O" +
       "mS+pcKOOE9WfwXXVwMikAndMkMrj2TvRkE0/EeAapId6if966cCOVS4dsBIv" +
       "XpKpUCwCCb5OMxzjLyn4QY+fKLAa5Jc+igy6E8rKCCz47pO5uSYez1zZKd7P" +
       "JRgR+f9lcLJXussOvAdGLuq84ujX7hCfa2RV2roVuYyFQ6D4cmQfAoNB3MvN" +
       "4VW+cuGxmvsr5zmxtV5s2HW6qZ5A0QJYNBATUwIfMqym7PeMV/ee/9hvdpQ/" +
       "D1lhHQlJUPOsyz1CZIw0ZPF1sdy7IzhC8C8szQt/uGXZqckPD/OrepJzNAvS" +
       "98kv7tvwwk2T984Ik7EdpEzREjTDzzYXbtHWUHnI7CXVitWWgS0CFyjpfRdT" +
       "NQhfCQs6rhdbndXZXvzYx8ic3Mu23E+kVao+TM3lelrjpR0c3ce6Pc5p3XcN" +
       "nDaMwAS3x3OeN0SwEFVISV9slWE4d5GlcYOPbi5Y7oei/BXfTv8v8DtVteck" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "E0OqAjja7QH/SsjcpO7BssUNGADuYwJPs0QmsVZoLpazjo8jfQFWmVUTX4lS" +
       "FLUW4rSlKpa9lvNZI8DyYIkxcsvZZvFu3DYc3+Ecp+6mlpEuOnbHpll+i9Ut" +
       "mWcd3JjBQn9HcBO5m5KZhaHxzveF2cR2MEt0sSEbSo68G2MM1mA8J+3mWZPd" +
       "Wu5isfQGS3xJtJBOowvRNd3sRrXdsEuYFNPbEDi/jOl5b1Ov5c2BOO7F9G6H" +
       "sWBjbNA0xOFksRmRvUmtRnCkvXGzmdqsVlsLO/aNlTXu+Nk69AJ0tIsZcb1w" +
       "AgknJHu66+Z4Ck+mwpSdbrw86Rndfpp2e6k3cr1sS/Ju3990ejZG5qt5rgUI" +
       "YW7zuWsnyUxeRJSEN5v8mjI9Emani2ofJWJRrTfoOTVckCYznHHjXXPokqMl" +
       "tVCSGPK0qtsS2BG3UGybr2VudyU3Qn+X4r4mTLY2zggbZrmgt77tbGwkrVv9" +
       "aT7Cx40JHPGEP2BFLLNZjdWaedIe4jSHYdLW60UIO5UsYM/yAEsMNDV7gzqJ" +
       "98dJT1mGNJSq6x1prNUaTtYmoUP7jtGKyGS14pGgZwzcfgAcMylgHYFa0rWq" +
       "3CWHnpyII0LpY93paoRsJbo10Zf2ZrPmCUJU29UJLkmr1bDbWq51hFMQYrxe" +
       "txCoivJdyR7lbaXn4Ya/5vvrtadFLMEPOkxowZpro4oKAnwyXAyaKkbJMpIp" +
       "vTwem1h9UO0iprDWlki10TUGRBtZOMgAGQzD2Wq97K7GWZXkVKeKSDPwR6+6" +
       "i8YMwbsZ5o+odkty2f6yPktmVaafL1dyE+6khj03Bra/6TPdtmMTKZczQiL2" +
       "RwQ5kllFxxF90NSkOSei7bXgzutDTlrPMXYyhgS+F9TGnG/OM5KZY5mCjsXq" +
       "qNdQOGgau0iuzdyUyuuca9Rcwc2JXcZMxurG7PR2VIfadmFsBbxG0KrXURRt" +
       "CbgcxXZcm/ftcU+tN8N0MNSEgbfEV0yz2pYIuSZQ1U2juUUaZmhs+yThYn2z" +
       "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" +
       "48fq9nAx9hj4vP1Q3d6+VzfuNWoCmOZA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("pWS74KmMaEdK9r1auqTw/TdXpM8fKdIX/pSKVDSfLJpPFc3nrteY4ufPFc0/" +
       "uoUKfL5c7HNF89ItRPMvbzH2K0Xzz4vmM3tMbgH7xbQMAu8tf/yNWwD+66L5" +
       "qahyjxybtnpkqUXnB08i1F97DRHq6aKTAp8XDlXrhT9ThMJvaCC3nWSyZXAa" +
       "nxD95VsQ/dtF82+AjSuem2hBRPsgXKv72FQM/fQJ6f/2NZBeWtWT4PPZQ9I/" +
       "+z0k/f0npH/tFqT/btF8BWQowEmX5WogeT1zNX02PC6lXZn/Pqt8fvG1L30i" +
       "f+nF/c1zEeaiSvVmVb3XFxYXtWC3iMGn6j2/M/zhl7/+X9kfO8qwX3fMz9cX" +
       "VHz/rfh5Nqwc1t3sa5S+fiLT//RaZfoU+HzlEIev/PnI9H/fQqbfKZr/GVXu" +
       "O5Tp1FMkuxRsMfB71/Pvlrh//Ry3/tdr4FaRmVaeAI7wtv3c/feflltR5U4/" +
       "MBOQSN+cZaej9gml14ptfuCV9j1FKdCZx65LRPclu6Uer5bTYsqFizcXw4XL" +
       "Recfgffbw+Km8EaZx52y59ma5J7w949fDX/TqPL4K1WaFvb80HVV7/tKbeXT" +
       "L1y9/MYXVv9un60eVVNfmVYu67Ftny5xOvV8CfhH3Sx5dmVf8OSXFD8QVd54" +
       "k7czkH7Jx2/gF+7fwxelSOfhQdZSfp+Geyiq3HUCB5baP5wGeRNI4gBI8fiI" +
       "fyTCxk2Lc8sUocjSyvIrUwG82zMr3cfoh07rbymWB15JLMdTTldrFo6t/L+E" +
       "o5fyeH7oP196gaDe++3Wp/bVooot5XmxymXwHrAvXD18Dzjvi0+vdrTWpdE7" +
       "vnvvL1558shF3rtH+MSWTuH22I3rMgeOH5WVlPnn3vjLP/IPXvidsjDr/wOw" +
       "qQZRMDIAAA==");
}
