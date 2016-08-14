package org.apache.batik.bridge;
public class SVGPatternElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.PaintBridge, org.apache.batik.bridge.ErrorConstants {
    public SVGPatternElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_PATTERN_TAG; }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element patternElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) { org.apache.batik.gvt.RootGraphicsNode patternContentNode;
                                                       patternContentNode =
                                                         (org.apache.batik.gvt.RootGraphicsNode)
                                                           ctx.
                                                           getElementData(
                                                             patternElement);
                                                       if (patternContentNode ==
                                                             null) {
                                                           patternContentNode =
                                                             extractPatternContent(
                                                               patternElement,
                                                               ctx);
                                                           ctx.
                                                             setElementData(
                                                               patternElement,
                                                               patternContentNode);
                                                       }
                                                       if (patternContentNode ==
                                                             null) {
                                                           return null;
                                                       }
                                                       java.awt.geom.Rectangle2D patternRegion =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                         convertPatternRegion(
                                                           patternElement,
                                                           paintedElement,
                                                           paintedNode,
                                                           ctx);
                                                       java.lang.String s;
                                                       java.awt.geom.AffineTransform patternTransform;
                                                       s =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                           getChainableAttributeNS(
                                                             patternElement,
                                                             null,
                                                             SVG_PATTERN_TRANSFORM_ATTRIBUTE,
                                                             ctx);
                                                       if (s.
                                                             length(
                                                               ) !=
                                                             0) {
                                                           patternTransform =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                               convertTransform(
                                                                 patternElement,
                                                                 SVG_PATTERN_TRANSFORM_ATTRIBUTE,
                                                                 s,
                                                                 ctx);
                                                       }
                                                       else {
                                                           patternTransform =
                                                             new java.awt.geom.AffineTransform(
                                                               );
                                                       }
                                                       boolean overflowIsHidden =
                                                         org.apache.batik.bridge.CSSUtilities.
                                                         convertOverflow(
                                                           patternElement);
                                                       short contentCoordSystem;
                                                       s =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                           getChainableAttributeNS(
                                                             patternElement,
                                                             null,
                                                             SVG_PATTERN_CONTENT_UNITS_ATTRIBUTE,
                                                             ctx);
                                                       if (s.
                                                             length(
                                                               ) ==
                                                             0) {
                                                           contentCoordSystem =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                               USER_SPACE_ON_USE;
                                                       }
                                                       else {
                                                           contentCoordSystem =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                               parseCoordinateSystem(
                                                                 patternElement,
                                                                 SVG_PATTERN_CONTENT_UNITS_ATTRIBUTE,
                                                                 s,
                                                                 ctx);
                                                       }
                                                       java.awt.geom.AffineTransform patternContentTransform =
                                                         new java.awt.geom.AffineTransform(
                                                         );
                                                       patternContentTransform.
                                                         translate(
                                                           patternRegion.
                                                             getX(
                                                               ),
                                                           patternRegion.
                                                             getY(
                                                               ));
                                                       java.lang.String viewBoxStr =
                                                         org.apache.batik.bridge.SVGUtilities.
                                                         getChainableAttributeNS(
                                                           patternElement,
                                                           null,
                                                           SVG_VIEW_BOX_ATTRIBUTE,
                                                           ctx);
                                                       if (viewBoxStr.
                                                             length(
                                                               ) >
                                                             0) {
                                                           java.lang.String aspectRatioStr =
                                                             org.apache.batik.bridge.SVGUtilities.
                                                             getChainableAttributeNS(
                                                               patternElement,
                                                               null,
                                                               SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                                               ctx);
                                                           float w =
                                                             (float)
                                                               patternRegion.
                                                               getWidth(
                                                                 );
                                                           float h =
                                                             (float)
                                                               patternRegion.
                                                               getHeight(
                                                                 );
                                                           java.awt.geom.AffineTransform preserveAspectRatioTransform =
                                                             org.apache.batik.bridge.ViewBox.
                                                             getPreserveAspectRatioTransform(
                                                               patternElement,
                                                               viewBoxStr,
                                                               aspectRatioStr,
                                                               w,
                                                               h,
                                                               ctx);
                                                           patternContentTransform.
                                                             concatenate(
                                                               preserveAspectRatioTransform);
                                                       }
                                                       else {
                                                           if (contentCoordSystem ==
                                                                 org.apache.batik.bridge.SVGUtilities.
                                                                   OBJECT_BOUNDING_BOX) {
                                                               java.awt.geom.AffineTransform patternContentUnitsTransform =
                                                                 new java.awt.geom.AffineTransform(
                                                                 );
                                                               java.awt.geom.Rectangle2D objectBoundingBox =
                                                                 paintedNode.
                                                                 getGeometryBounds(
                                                                   );
                                                               patternContentUnitsTransform.
                                                                 translate(
                                                                   objectBoundingBox.
                                                                     getX(
                                                                       ),
                                                                   objectBoundingBox.
                                                                     getY(
                                                                       ));
                                                               patternContentUnitsTransform.
                                                                 scale(
                                                                   objectBoundingBox.
                                                                     getWidth(
                                                                       ),
                                                                   objectBoundingBox.
                                                                     getHeight(
                                                                       ));
                                                               patternContentTransform.
                                                                 concatenate(
                                                                   patternContentUnitsTransform);
                                                           }
                                                       }
                                                       org.apache.batik.gvt.GraphicsNode gn =
                                                         new org.apache.batik.bridge.SVGPatternElementBridge.PatternGraphicsNode(
                                                         patternContentNode);
                                                       gn.
                                                         setTransform(
                                                           patternContentTransform);
                                                       if (opacity !=
                                                             1) {
                                                           org.apache.batik.ext.awt.image.renderable.Filter filter =
                                                             gn.
                                                             getGraphicsNodeRable(
                                                               true);
                                                           filter =
                                                             new org.apache.batik.ext.awt.image.renderable.ComponentTransferRable8Bit(
                                                               filter,
                                                               org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                                                                 getLinearTransfer(
                                                                   opacity,
                                                                   0),
                                                               org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                                                                 getIdentityTransfer(
                                                                   ),
                                                               org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                                                                 getIdentityTransfer(
                                                                   ),
                                                               org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                                                                 getIdentityTransfer(
                                                                   ));
                                                           gn.
                                                             setFilter(
                                                               filter);
                                                       }
                                                       return new org.apache.batik.gvt.PatternPaint(
                                                         gn,
                                                         patternRegion,
                                                         !overflowIsHidden,
                                                         patternTransform);
    }
    protected static org.apache.batik.gvt.RootGraphicsNode extractPatternContent(org.w3c.dom.Element patternElement,
                                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.util.List refs =
          new java.util.LinkedList(
          );
        for (;
             ;
             ) {
            org.apache.batik.gvt.RootGraphicsNode content =
              extractLocalPatternContent(
                patternElement,
                ctx);
            if (content !=
                  null) {
                return content;
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                patternElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return null;
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                patternElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURL(
                  ),
              uri);
            if (!purl.
                  complete(
                    ))
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  patternElement,
                  ERR_URI_MALFORMED,
                  new java.lang.Object[] { uri });
            if (contains(
                  refs,
                  purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  patternElement,
                  ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              add(
                purl);
            patternElement =
              ctx.
                getReferencedElement(
                  patternElement,
                  uri);
        }
    }
    protected static org.apache.batik.gvt.RootGraphicsNode extractLocalPatternContent(org.w3c.dom.Element e,
                                                                                      org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.RootGraphicsNode content =
          null;
        for (org.w3c.dom.Node n =
               e.
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
            org.apache.batik.gvt.GraphicsNode gn =
              builder.
              build(
                ctx,
                (org.w3c.dom.Element)
                  n);
            if (gn !=
                  null) {
                if (content ==
                      null) {
                    content =
                      new org.apache.batik.gvt.RootGraphicsNode(
                        );
                }
                content.
                  getChildren(
                    ).
                  add(
                    gn);
            }
        }
        return content;
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
    public static class PatternGraphicsNode extends org.apache.batik.gvt.AbstractGraphicsNode {
        org.apache.batik.gvt.GraphicsNode
          pcn;
        java.awt.geom.Rectangle2D pBounds;
        java.awt.geom.Rectangle2D gBounds;
        java.awt.geom.Rectangle2D sBounds;
        java.awt.Shape oShape;
        public PatternGraphicsNode(org.apache.batik.gvt.GraphicsNode gn) {
            super(
              );
            this.
              pcn =
              gn;
        }
        public void primitivePaint(java.awt.Graphics2D g2d) {
            pcn.
              paint(
                g2d);
        }
        public java.awt.geom.Rectangle2D getPrimitiveBounds() {
            if (pBounds !=
                  null)
                return pBounds;
            pBounds =
              pcn.
                getTransformedBounds(
                  IDENTITY);
            return pBounds;
        }
        public java.awt.geom.Rectangle2D getGeometryBounds() {
            if (gBounds !=
                  null)
                return gBounds;
            gBounds =
              pcn.
                getTransformedGeometryBounds(
                  IDENTITY);
            return gBounds;
        }
        public java.awt.geom.Rectangle2D getSensitiveBounds() {
            if (sBounds !=
                  null)
                return sBounds;
            sBounds =
              pcn.
                getTransformedSensitiveBounds(
                  IDENTITY);
            return sBounds;
        }
        public java.awt.Shape getOutline() {
            if (oShape !=
                  null)
                return oShape;
            oShape =
              pcn.
                getOutline(
                  );
            java.awt.geom.AffineTransform tr =
              pcn.
              getTransform(
                );
            if (tr !=
                  null)
                oShape =
                  tr.
                    createTransformedShape(
                      oShape);
            return oShape;
        }
        protected void invalidateGeometryCache() {
            pBounds =
              null;
            gBounds =
              null;
            sBounds =
              null;
            oShape =
              null;
            super.
              invalidateGeometryCache(
                );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZfWwUxxWfO+NP/M03GAPGUBnIHdCQiprQ2IcNJodxMLFa" +
           "Ezjm9ubuFu/tLrtz9tmp2wQpheYPSikhJEpQ/yClpRCiNlHTj0REUUqiNJGS" +
           "0LRpFYgaqSVJUYOqplVJQ9/M7t5+nPeQo1JLnpubee/Ne2/e/N6budNXUKmu" +
           "oWYi0xAdVYke6pJpH9Z0kohIWNe3w1hMeLgE/33X5d61QVQ2iGrTWN8iYJ10" +
           "i0RK6INovijrFMsC0XsJSTCOPo3oRBvGVFTkQTRD1HsyqiQKIt2iJAgjGMBa" +
           "FDVgSjUxnqWkxxRA0fwoaBLmmoQ7vNPtUVQtKOqoTT7bQR5xzDDKjL2WTlF9" +
           "dA8exuEsFaVwVNRpe05Dy1VFGk1JCg2RHA3tkdaYLtgcXVPggpan6j65dihd" +
           "z10wDcuyQrl5+jaiK9IwSURRnT3aJZGMvhd9A5VE0VQHMUWtUWvRMCwahkUt" +
           "a20q0L6GyNlMROHmUEtSmSowhSha5BaiYg1nTDF9XGeQUEFN2zkzWLswb61h" +
           "ZYGJDy0PH3l4V/1PSlDdIKoT5X6mjgBKUFhkEBxKMnGi6R2JBEkMogYZNruf" +
           "aCKWxDFzpxt1MSVjmoXtt9zCBrMq0fiatq9gH8E2LStQRcubl+QBZX4rTUo4" +
           "BbbOtG01LOxm42BglQiKaUkMcWeyTBkS5QRFC7wceRtb7wQCYC3PEJpW8ktN" +
           "kTEMoEYjRCQsp8L9EHpyCkhLFQhAjaK5vkKZr1UsDOEUibGI9ND1GVNAVckd" +
           "wVgomuEl45Jgl+Z6dsmxP1d61x28V94kB1EAdE4QQWL6TwWmZg/TNpIkGoFz" +
           "YDBWL4sexTOfOxBECIhneIgNmp99/eodK5rPvWzQzJuAZmt8DxFoTDgRr32j" +
           "KdK2toSpUaEqusg232U5P2V95kx7TgWEmZmXyCZD1uS5bb/+2n2nyEdBVNWD" +
           "ygRFymYgjhoEJaOKEtE2EplomJJED6okciLC53tQOfSjokyM0a3JpE5oD5oi" +
           "8aEyhX8HFyVBBHNRFfRFOalYfRXTNO/nVIRQI/yjWQgF7kD8z/ikKB5OKxkS" +
           "xgKWRVkJ92kKs18PA+LEwbfpcByifiisK1kNQjCsaKkwhjhIE3MiromJFAn3" +
           "D2zsA6AjGgcFYO7k4yEWa+r/ZZUcs3XaSCAA29DkBQEJzs8mRUoQLSYcyXZ2" +
           "XX0y9qoRYOxQmF6iKAILh4yFQ3zhkLFwyGfhVnNwo4bVtCjovQDGKBDgOkxn" +
           "ShlhAJs4BHAAeFzd1r9z8+4DLSUQf+rIFLYPQNriyksRGzMsoI8JZxtrxhZd" +
           "XPViEE2JokYs0CyWWJrp0FIAYMKQecar45Cx7MSx0JE4WMbTFIEkALf8Eogp" +
           "pUIZJhobp2i6Q4KV1tgBDvsnlQn1R+eOjdw/8M2VQRR05wq2ZCnAHGPvYwif" +
           "R/JWL0ZMJLdu/+VPzh4dV2y0cCUfK2cWcDIbWrxR4nVPTFi2ED8Te268lbu9" +
           "EtCcYjh9AJTN3jVcYNRuATuzpQIMTipaBktsyvJxFU1ryog9wsO3gfenQ1jU" +
           "sdPZAuHRbR5X/slmZ6qsnWWEO4szjxU8cdzerz7++9c/+CJ3t5Vj6hzFQT+h" +
           "7Q5cY8IaOYI12GG7XSME6N491ve9h67s38FjFigWT7RgK2sjgGewheDmB17e" +
           "+86liycuBO04p5DYs3Goj3J5IyuYTbVFjITVltr6AC5KgBosalrvliE+xaSI" +
           "4xJhB+vTuiWrnvnrwXojDiQYscJoxY0F2ONzOtF9r+76ZzMXExBYXrZ9ZpMZ" +
           "YD/NltyhaXiU6ZG7/835j5zHj0PaAKjWxTHC0TdgnnWm1GyobApwJjVMQ04U" +
           "4du7htOv5O2tzDVcCuJza1mzRHceE/dJdFRaMeHQhY9rBj5+/iq3y12qOaNi" +
           "C1bbjUBkzdIciJ/lhbFNWE8D3a3neu+pl85dA4mDIFEA2Na3agCwOVcMmdSl" +
           "5X944cWZu98oQcFuVCUpONGN+XFElXAOiJ4GbM6pXzFz0wgLjHpuKiowvmCA" +
           "bcWCiTe5K6NSvi1jz856et3J4xd5PKqGjHmcn90Lmlz4ywt+GwJOvfWl3578" +
           "7tERo2Ro88c9D9/sf2+V4vv+9K8Cl3PEm6Cc8fAPhk8/Njey/iPOb0MP427N" +
           "FaY4gG+bd/WpzD+CLWUvBVH5IKoXzAJ7AEtZdqAHoajUraobinDXvLtANKqh" +
           "9jy0Nnlhz7GsF/Ts1Ap9Rs36NR6c4xAwB45GhwkBHV6cCyDeuZOzfIG3y1hz" +
           "izMe8qIqioiiqEQVONTdZoAna7/Mmqgh5XbfAOxyr9IE0jvNVTp9FO43FGZN" +
           "b6GOftwUlaudSlZO6BZWzOGhjUdoKEWUDBS9Ang7JZHVGzxGbP8cRkRMNSI+" +
           "RtxT1Ag/bjAiZRjBvn7Vo+fOz6HnBnOlDT56CkX19OMGPXV/PROT1HMerNBl" +
           "rtTlo+eeonr6cUPqVPrT2CwVICZq8zHBhz2KDxVRPDfxMQqybgjW0flt2D5U" +
           "/Iw1eK8NzhRtQyli+WK+382O30pP7DtyPLH1iVUGmDa6b0tdcjZz5u3//CZ0" +
           "7L1XJijOy8ybub1gGVvPhd1b+I3XBsJ3aw+///PWVOdkymY21nyDwph9XwAW" +
           "LPNPB15Vzu/7cO729endk6iAF3h86RX5oy2nX9m4VDgc5Nd7A6ELngXcTO1u" +
           "XK7SCM1q8nYXOi92V6GrEatljN3v8ca1HXo8qJcX1nZ+rJ7axlMhTctHuFUV" +
           "rd7AF/tWkZroQdbcD8dD1cQM1LXD4E9RpnrRtN1n0RovBOHxxktDj10+Y0So" +
           "N0d7iMmBIw9eDx08YkSr8S6zuOBpxMljvM1wbesNX12HvwD8f8b+mSlsgH1C" +
           "Jo6YDwQL8y8ErHjR0KJiavEluv9ydvyXPxzfHzRdM0rRlGFFTNgose9G8Fa8" +
           "6GIDEZWPj+c3fR6buwUxbxibHp18vPixFtn340Xmvs+aR8CXKULzbnKAvu2Q" +
           "R2+WQ1aANXeZVt01eYf4sRYx+sdF5s6w5gcUNYBDNkJFQag2OqE/Tt7MABkw" +
           "jRqYvD/8WIvY/GyRuV+w5qdGgPQTWfcPkKdvgkNmsLkFYM0O06odk3eIH2sR" +
           "o18qMneeNecoqgKHbM1S9tzIRhTbES/cBEfw98mVYIVgWiMUcYS3fAlQVKlq" +
           "CoXamCQ8N4KGIjKLeOFCkbm3WfMaRbNEeRhLYgKA2TpJEXanZ9Pfsd31+v/C" +
           "XTnIiRO8Nlr5MjzJl0tIIrMLfikxXveFJ4/XVcw6fvfveNGUf4GvhvInmZUk" +
           "563O0S9TNZIUuXuqjTueyj/eAzf56AYlndHhRlwy6N+nqN5LT1Ep/3TS/RkC" +
           "1KYDUUbHSfIBXPiAhHU/VC1HtU349NIR16kG5aHrCSbgrm3z+znjRvvpKIcX" +
           "uwoP/hOWVcxljR+xYsLZ45t777162xPGY50g4bExJmVqFJUb74b5gnCRrzRL" +
           "Vtmmtmu1T1UusfJ+g6GwfXbmOeIY7m0BlT2fzPW8ZOmt+Qetd06se/61A2Vv" +
           "Bhm+BDBE4Y7C94GcmoVKfEfUrsUdP4HyJ7b2tkdH169I/u2P/AUGGe/eTf70" +
           "MeHCyZ1vHZ59ojmIpvagUihpSI4/XGwYleEOPKwNohpR78qBiiBFxFIPqsjK" +
           "4t4s6UlEUS2LWsx+3OJ+Md1Zkx9lT70UtRSWaoUP5FWSMkI0nhCYmBoo3u0R" +
           "62LgqqmzquphsEfyWzm90PaYsOHbdb861FjSDSfPZY5TfLmejefrdefPbXzA" +
           "qCxZcyjH9hmOQCy6RVWtorJsgWochU8NGjZOUWCZOeqoxNnX61zcZ7wLTSDw" +
           "X+Bv/OZJHwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
      ("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");
}
