package org.apache.batik.bridge;
public class SVGFeImageElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeImageElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_IMAGE_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        java.lang.String uriStr =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            filterElement);
        if (uriStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { "xlink:href" });
        }
        org.w3c.dom.Document document =
          filterElement.
          getOwnerDocument(
            );
        boolean isUse =
          uriStr.
          indexOf(
            '#') !=
          -1;
        org.w3c.dom.Element contentElement =
          null;
        if (isUse) {
            contentElement =
              document.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_USE_TAG);
        }
        else {
            contentElement =
              document.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_IMAGE_TAG);
        }
        contentElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            uriStr);
        org.w3c.dom.Element proxyElement =
          document.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_G_TAG);
        proxyElement.
          appendChild(
            contentElement);
        java.awt.geom.Rectangle2D defaultRegion =
          filterRegion;
        org.w3c.dom.Element filterDefElement =
          (org.w3c.dom.Element)
            filterElement.
            getParentNode(
              );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          getBaseFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            ctx);
        contentElement.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getX(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getY(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getWidth(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getHeight(
                    )));
        org.apache.batik.gvt.GraphicsNode node =
          ctx.
          getGVTBuilder(
            ).
          build(
            ctx,
            proxyElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          node.
          getGraphicsNodeRable(
            true);
        short coordSystemType;
        java.lang.String s =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            filterDefElement,
            null,
            SVG_PRIMITIVE_UNITS_ATTRIBUTE,
            ctx);
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
                  filterDefElement,
                  SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        java.awt.geom.AffineTransform at =
          new java.awt.geom.AffineTransform(
          );
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            at =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  at,
                  filteredNode);
        }
        filter =
          new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
            filter,
            at);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        java.awt.geom.Rectangle2D primitiveRegionUserSpace =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegionUserSpace,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createSVGFeImage(org.apache.batik.bridge.BridgeContext ctx,
                                                                                       java.awt.geom.Rectangle2D primitiveRegion,
                                                                                       org.w3c.dom.Element refElement,
                                                                                       boolean toBBoxNeeded,
                                                                                       org.w3c.dom.Element filterElement,
                                                                                       org.apache.batik.gvt.GraphicsNode filteredNode) {
        org.apache.batik.gvt.GraphicsNode node =
          ctx.
          getGVTBuilder(
            ).
          build(
            ctx,
            refElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          node.
          getGraphicsNodeRable(
            true);
        java.awt.geom.AffineTransform at =
          new java.awt.geom.AffineTransform(
          );
        if (toBBoxNeeded) {
            short coordSystemType;
            org.w3c.dom.Element filterDefElement =
              (org.w3c.dom.Element)
                filterElement.
                getParentNode(
                  );
            java.lang.String s =
              org.apache.batik.bridge.SVGUtilities.
              getChainableAttributeNS(
                filterDefElement,
                null,
                SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                ctx);
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
                      filterDefElement,
                      SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                      s,
                      ctx);
            }
            if (coordSystemType ==
                  org.apache.batik.bridge.SVGUtilities.
                    OBJECT_BOUNDING_BOX) {
                at =
                  org.apache.batik.bridge.SVGUtilities.
                    toObjectBBox(
                      at,
                      filteredNode);
            }
            java.awt.geom.Rectangle2D bounds =
              filteredNode.
              getGeometryBounds(
                );
            at.
              preConcatenate(
                java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    primitiveRegion.
                      getX(
                        ) -
                      bounds.
                      getX(
                        ),
                    primitiveRegion.
                      getY(
                        ) -
                      bounds.
                      getY(
                        )));
        }
        else {
            at.
              translate(
                primitiveRegion.
                  getX(
                    ),
                primitiveRegion.
                  getY(
                    ));
        }
        return new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          filter,
          at);
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createRasterFeImage(org.apache.batik.bridge.BridgeContext ctx,
                                                                                          java.awt.geom.Rectangle2D primitiveRegion,
                                                                                          org.apache.batik.util.ParsedURL purl) {
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
          getRegistry(
            ).
          readURL(
            purl);
        java.awt.geom.Rectangle2D bounds =
          filter.
          getBounds2D(
            );
        java.awt.geom.AffineTransform scale =
          new java.awt.geom.AffineTransform(
          );
        scale.
          translate(
            primitiveRegion.
              getX(
                ),
            primitiveRegion.
              getY(
                ));
        scale.
          scale(
            primitiveRegion.
              getWidth(
                ) /
              (bounds.
                 getWidth(
                   ) -
                 1),
            primitiveRegion.
              getHeight(
                ) /
              (bounds.
                 getHeight(
                   ) -
                 1));
        scale.
          translate(
            -bounds.
              getX(
                ),
            -bounds.
              getY(
                ));
        return new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          filter,
          scale);
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
      ("H4sIAAAAAAAAAL1aeewjV32f3c3uJptjNwkkIQ05N7TJ0N/YMx4fhBbG54w9" +
       "Mx6P7fHRwjKnPZ7Tc3toCkQtpEUCRAOkKskfFQiKAqFVKT1EFdRSQKBKVKiX" +
       "VEBtpUIpEvkDikpb+mb8u/egEVUt+Xn83vd93/d6n/f1+/q570CnfQ+CXcfc" +
       "LEwn2FGTYGdl4jvBxlX9nS6Nc6Lnq0rDFH1/BPouyQ9+8vz3f/ie5YWT0Jk5" +
       "dLto204gBrpj+7zqO2akKjR0/qC3ZaqWH0AX6JUYiUgY6CZC637wGA3deGhq" +
       "AF2k90RAgAgIEAHJRUCIAyow6WbVDq1GNkO0A38N/TJ0gobOuHImXgA9cJSJ" +
       "K3qitcuGyzUAHK7PvgtAqXxy4kH37+u+1fkyhd8HI0994I0Xfu8UdH4Ondft" +
       "YSaODIQIwCJz6CZLtSTV8wlFUZU5dKutqspQ9XTR1NNc7jl0m68vbDEIPXXf" +
       "SFln6KpevuaB5W6SM928UA4cb189TVdNZe/bac0UF0DXOw503WrYzvqBgud0" +
       "IJinibK6N+U6Q7eVALrv+Ix9HS/2AAGYetZSg6Wzv9R1tgg6oNu2vjNFe4EM" +
       "A0+3F4D0tBOCVQLo7qsyzWztirIhLtRLAXTXcTpuOwSobsgNkU0JoJcfJ8s5" +
       "AS/dfcxLh/zzHfa173qzTdonc5kVVTYz+a8Hk+49NolXNdVTbVndTrzpUfr9" +
       "4h2fefIkBAHilx8j3tJ8+pdefP2r733hC1uan7oCTV9aqXJwSf6QdMtX7mk8" +
       "UjuViXG96/h65vwjmufhz+2OPJa4YOfdsc8xG9zZG3yB/4vZWz+mfvskdI6C" +
       "zsiOGVogjm6VHcvVTdXrqLbqiYGqUNANqq008nEKOguead1Wt719TfPVgIKu" +
       "M/OuM07+HZhIAywyE50Fz7qtOXvPrhgs8+fEhSDoLHhDN4H3o9D2lX8GkIQs" +
       "HUtFRFm0ddtBOM/J9PcR1Q4kYNslIoGoNxDfCT0QgojjLRARxMFS3R2QPF1Z" +
       "qMhQ6LRVygIhkEEEmFzP+3eyWHP/X1ZJMl0vxCdOADfccxwETLB/SMdUVO+S" +
       "/FRYb734iUtfOrm/KXatFEDZwjvbhXfyhXe2C+9cZWHoxIl8vZdlAmxdDhxm" +
       "gK0PQPGmR4Zv6L7pyQdPgVhz4+uAtTNS5OrY3DgACyqHRBlELPTC0/HbhLcU" +
       "TkInj4JsJjToOpdN5zJo3IfAi8c315X4nn/HN7///Psfdw622RHU3t39l8/M" +
       "du+Dx83rObKqADw8YP/o/eKnLn3m8YsnoesAJAAYDEQQtgBh7j2+xpFd/Nge" +
       "Ima6nAYKa45niWY2tAdj54Kl58QHPbnfb8mfbwU2vjEL6wfBu7Ab5/lnNnq7" +
       "m7Uv28ZJ5rRjWuSI+3ND95m//ctvYbm598D5/KHjbqgGjx0ChIzZ+Xzr33oQ" +
       "AyNPVQHdPzzN/cb7vvOOX8gDAFA8dKUFL2ZtAwABcCEw869+Yf13X//ah756" +
       "8iBoAnAihpKpy8m+klk/dO4aSoLVXnUgDwAUE2y3LGoujm3LUXRNFyVTzaL0" +
       "P88/XPzUv73rwjYOTNCzF0av/vEMDvpfUYfe+qU3/vu9OZsTcnagHdjsgGyL" +
       "krcfcCY8T9xkciRv+6tX/ubnxWcA3gKM8/VUzWELym0A5U5Dcv0fzdudY2PF" +
       "rLnPPxz8R/fXocTjkvyer373ZuG7f/piLu3RzOWwrxnRfWwbXllzfwLY33l8" +
       "p5OivwR0pRfYX7xgvvBDwHEOOMoAxfy+B/AmORIZu9Snz/79Z//sjjd95RR0" +
       "sg2dMx1RaYv5JoNuANGt+ksAVYn7utdvnRtfD5oLuarQZcpvg+Ku/NspIOAj" +
       "V8eXdpZ4HGzRu/6jb0pP/OMPLjNCjixXOG+PzZ8jz33w7sbPfzuff7DFs9n3" +
       "JpdjMEjSDuaiH7O+d/LBM587CZ2dQxfk3QxQEM0w2zhzkPX4e2khyBKPjB/N" +
       "YLbH9WP7EHbPcXg5tOxxcDnAfvCcUWfP5w7jyY/A6wR4/3f2zsyddWzPzdsa" +
       "u4f3/funt+smJ8BuPY3uVHYK2fzX5VweyNuLWfPTWzdljz8DtrWfp55ghqbb" +
       "opkv/PoAhJgpX9zjLoBUFPjk4sqs5GxeDpLvPJwy7Xe2+dsW0LIWzVlsQwK/" +
       "avi8ZkuVn1y3HDCjHZAKvvOf3/Pldz/0deDTLnQ6yuwNXHloRTbMsuO3P/e+" +
       "V9741DfemaMUgCjh134X+0HGlb6WxlnTypr2nqp3Z6oO80OfFv2AyYFFVXJt" +
       "rxnKnKdbAH+j3dQPefy2rxsf/ObHt2nd8bg9Rqw++dSv/2jnXU+dPJRMP3RZ" +
       "Pnt4zjahzoW+edfCHvTAtVbJZ7T/5fnH/+Sjj79jK9VtR1PDFvjl8/G//q8v" +
       "7zz9jS9eIRO5znR+AscGt/w5WfIpYu9FF+cqGo+TxNBspNUspUpELESG0EiK" +
       "nNqDri2oiU8u5K7ujYapwFFlPJKsSjINKxu4LGtzfWgWu/UxLnTMZiKyWtLu" +
       "uM5Q73lD1kdX3rpXNenBsDFZi7xtUroyNOixOyhyQy5ooYiESphiIVFq2aLr" +
       "zkPJQlALRSwYljBEwqNkLYdG3ZOoZZHB0Q6MoTyq9rj+rDbcTKTu1KmINVLz" +
       "9I2NCbUep1TiokwOe0WqPMAHMBo0PGFuV9cFt1lstNdWORWtkCFDwh8O+3rb" +
       "ZubBbIaL6+UKb87XAaqxI0EYa+aEqpqDWXcpjpVupy9pY54qp5oh17ulUPe7" +
       "PWrSsowuopf7BUdsy5xcKdlctWRjcFBezFlR2sCiwUrr6SpoU6t1IHZ7nhg1" +
       "g8gYTSxHLXJiPOP8NOYqtemkvymXetIaToiJsqrMqwhjK5YgLReuOS7GhTCl" +
       "GdKaFJ3ZJp53h0W1UhDZuVqs4fX5kByOU43pyUprqgyHTCwOBpYiYkW30yyO" +
       "xik3n/rsbIBjrDIRG3qZMsrT9tBI1gVxs+rq0qRZ99bhpF/pEOmE1s1Zr1zw" +
       "Ga2jsvP2qgYXQ2RsFEXeWNKiAy+ZgJ/VW3J3adSXla6/ME10lNJdQ+8bo5nG" +
       "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");
}
