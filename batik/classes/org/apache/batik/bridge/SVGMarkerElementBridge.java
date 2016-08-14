package org.apache.batik.bridge;
public class SVGMarkerElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.MarkerBridge, org.apache.batik.bridge.ErrorConstants {
    protected SVGMarkerElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_MARKER_TAG; }
    public org.apache.batik.gvt.Marker createMarker(org.apache.batik.bridge.BridgeContext ctx,
                                                    org.w3c.dom.Element markerElement,
                                                    org.w3c.dom.Element paintedElement) {
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.CompositeGraphicsNode markerContentNode =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        boolean hasChildren =
          false;
        for (org.w3c.dom.Node n =
               markerElement.
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
            org.w3c.dom.Element child =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.gvt.GraphicsNode markerNode =
              builder.
              build(
                ctx,
                child);
            if (markerNode ==
                  null) {
                continue;
            }
            hasChildren =
              true;
            markerContentNode.
              getChildren(
                ).
              add(
                markerNode);
        }
        if (!hasChildren) {
            return null;
        }
        java.lang.String s;
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            paintedElement);
        float markerWidth =
          3;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_MARKER_WIDTH_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            markerWidth =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalLengthToUserSpace(
                  s,
                  SVG_MARKER_WIDTH_ATTRIBUTE,
                  uctx);
        }
        if (markerWidth ==
              0) {
            return null;
        }
        float markerHeight =
          3;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_MARKER_HEIGHT_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            markerHeight =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalLengthToUserSpace(
                  s,
                  SVG_MARKER_HEIGHT_ATTRIBUTE,
                  uctx);
        }
        if (markerHeight ==
              0) {
            return null;
        }
        double orient;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_ORIENT_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            orient =
              0;
        }
        else
            if (SVG_AUTO_VALUE.
                  equals(
                    s)) {
                orient =
                  java.lang.Double.
                    NaN;
            }
            else {
                try {
                    orient =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          s);
                }
                catch (java.lang.NumberFormatException nfEx) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      markerElement,
                      nfEx,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_ORIENT_ATTRIBUTE,
                      s });
                }
            }
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            paintedElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              STROKE_WIDTH_INDEX);
        float strokeWidth =
          val.
          getFloatValue(
            );
        short unitsType;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_MARKER_UNITS_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            unitsType =
              org.apache.batik.bridge.SVGUtilities.
                STROKE_WIDTH;
        }
        else {
            unitsType =
              org.apache.batik.bridge.SVGUtilities.
                parseMarkerCoordinateSystem(
                  markerElement,
                  SVG_MARKER_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        java.awt.geom.AffineTransform markerTxf;
        if (unitsType ==
              org.apache.batik.bridge.SVGUtilities.
                STROKE_WIDTH) {
            markerTxf =
              new java.awt.geom.AffineTransform(
                );
            markerTxf.
              scale(
                strokeWidth,
                strokeWidth);
        }
        else {
            markerTxf =
              new java.awt.geom.AffineTransform(
                );
        }
        java.awt.geom.AffineTransform preserveAspectRatioTransform =
          org.apache.batik.bridge.ViewBox.
          getPreserveAspectRatioTransform(
            markerElement,
            markerWidth,
            markerHeight,
            ctx);
        if (preserveAspectRatioTransform ==
              null) {
            return null;
        }
        else {
            markerTxf.
              concatenate(
                preserveAspectRatioTransform);
        }
        markerContentNode.
          setTransform(
            markerTxf);
        if (org.apache.batik.bridge.CSSUtilities.
              convertOverflow(
                markerElement)) {
            java.awt.geom.Rectangle2D markerClip;
            float[] offsets =
              org.apache.batik.bridge.CSSUtilities.
              convertClip(
                markerElement);
            if (offsets ==
                  null) {
                markerClip =
                  new java.awt.geom.Rectangle2D.Float(
                    0,
                    0,
                    strokeWidth *
                      markerWidth,
                    strokeWidth *
                      markerHeight);
            }
            else {
                markerClip =
                  new java.awt.geom.Rectangle2D.Float(
                    offsets[3],
                    offsets[0],
                    strokeWidth *
                      markerWidth -
                      offsets[1] -
                      offsets[3],
                    strokeWidth *
                      markerHeight -
                      offsets[2] -
                      offsets[0]);
            }
            org.apache.batik.gvt.CompositeGraphicsNode comp =
              new org.apache.batik.gvt.CompositeGraphicsNode(
              );
            comp.
              getChildren(
                ).
              add(
                markerContentNode);
            org.apache.batik.ext.awt.image.renderable.Filter clipSrc =
              comp.
              getGraphicsNodeRable(
                true);
            comp.
              setClip(
                new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                  clipSrc,
                  markerClip));
            markerContentNode =
              comp;
        }
        float refX =
          0;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_REF_X_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            refX =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  SVG_REF_X_ATTRIBUTE,
                  uctx);
        }
        float refY =
          0;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_REF_Y_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            refY =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  SVG_REF_Y_ATTRIBUTE,
                  uctx);
        }
        float[] ref =
          { refX,
        refY };
        markerTxf.
          transform(
            ref,
            0,
            ref,
            0,
            1);
        org.apache.batik.gvt.Marker marker =
          new org.apache.batik.gvt.Marker(
          markerContentNode,
          new java.awt.geom.Point2D.Float(
            ref[0],
            ref[1]),
          orient);
        return marker;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1uatG3sVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
