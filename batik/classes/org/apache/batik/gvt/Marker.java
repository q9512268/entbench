package org.apache.batik.gvt;
public class Marker {
    protected double orient;
    protected org.apache.batik.gvt.GraphicsNode markerNode;
    protected java.awt.geom.Point2D ref;
    public Marker(org.apache.batik.gvt.GraphicsNode markerNode, java.awt.geom.Point2D ref,
                  double orient) { super();
                                   if (markerNode == null) { throw new java.lang.IllegalArgumentException(
                                                               );
                                   }
                                   if (ref == null) { throw new java.lang.IllegalArgumentException(
                                                        );
                                   }
                                   this.markerNode =
                                     markerNode;
                                   this.ref = ref;
                                   this.orient = orient;
    }
    public java.awt.geom.Point2D getRef() { return (java.awt.geom.Point2D)
                                                     ref.
                                                     clone(
                                                       );
    }
    public double getOrient() { return orient; }
    public org.apache.batik.gvt.GraphicsNode getMarkerNode() {
        return markerNode;
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
