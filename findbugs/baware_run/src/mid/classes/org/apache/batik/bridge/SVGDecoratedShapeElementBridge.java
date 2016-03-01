package org.apache.batik.bridge;
public abstract class SVGDecoratedShapeElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    protected SVGDecoratedShapeElementBridge() { super(); }
    org.apache.batik.gvt.ShapePainter createFillStrokePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element e,
                                                              org.apache.batik.gvt.ShapeNode shapeNode) {
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    org.apache.batik.gvt.ShapePainter createMarkerPainter(org.apache.batik.bridge.BridgeContext ctx,
                                                          org.w3c.dom.Element e,
                                                          org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertMarkers(
            e,
            shapeNode,
            ctx);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.gvt.ShapePainter fillAndStroke;
        fillAndStroke =
          createFillStrokePainter(
            ctx,
            e,
            shapeNode);
        org.apache.batik.gvt.ShapePainter markerPainter =
          createMarkerPainter(
            ctx,
            e,
            shapeNode);
        java.awt.Shape shape =
          shapeNode.
          getShape(
            );
        org.apache.batik.gvt.ShapePainter painter;
        if (markerPainter !=
              null) {
            if (fillAndStroke !=
                  null) {
                org.apache.batik.gvt.CompositeShapePainter cp =
                  new org.apache.batik.gvt.CompositeShapePainter(
                  shape);
                cp.
                  addShapePainter(
                    fillAndStroke);
                cp.
                  addShapePainter(
                    markerPainter);
                painter =
                  cp;
            }
            else {
                painter =
                  markerPainter;
            }
        }
        else {
            painter =
              fillAndStroke;
        }
        return painter;
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_START_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_MID_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_END_INDEX:
                if (!hasNewShapePainter) {
                    hasNewShapePainter =
                      true;
                    org.apache.batik.gvt.ShapeNode shapeNode =
                      (org.apache.batik.gvt.ShapeNode)
                        node;
                    shapeNode.
                      setShapePainter(
                        createShapePainter(
                          ctx,
                          e,
                          shapeNode));
                }
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RAcNw0brwGWuecPg4foKa77zP+DiH0WCGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Bp9T4Pnf7MnMnTVs99o72nsb/kMHO77nJafAgr2ptFvfLWTj35RzeTgvL2fF" +
       "z2/dFIK8OJpbJlgmZ4M8ZQWjNNORrHzyp0IQZpZ8eX+GKUhhgV8uL6x6zuou" +
       "kLTnIZVZYHeb921xLStLOYttWFSvG0K/sKXKN7DbDplRLkgh3/9PH/z6bzz6" +
       "beDXPnRTnNkcuPPIjMMoy6rf/cKH73/FM995fw5WAKlGz+KXnsq4Dq6jdVbF" +
       "s6KTFd19Ve/LVGXzTICSgnCQg4uq5NreMJxHvmkDGI73Ukbk6Tu+vfzIdz+1" +
       "TQdPxu4JYvW9z7zvx7sfeGbnSBL+6FV58NEx20Q8F/rWPQv70MM3miUf0fnn" +
       "zzz9xd97+j1bqe44nlLi4I3pU3/9P1/ffe47X71GXnLGcn8Kx4a3YkQl6KH7" +
       "n8FUUEvrSZLYGp3C64WMj/QVPsb6OtYZa5G5NNCVhOPYQLBFJCZxaSVY9jBS" +
       "4GpUn5cVkdfokbeutchxl6y5Y2xSJVcl0sMtgjV7rCuF7GrCtKarjcBwDF6Q" +
       "4uF4WZw3e/ASI7U1NwvxEjIT7WZZjOuFzhiJjD5dD8qNRqHcqBfhcqqkyGK1" +
       "CgrpRJy1hondqSXt1oweSLDQNAvmcOMLQSy16oV+TVgiTlqtNcrqMKmQrqZz" +
       "w7TU8ieD3qw2pXukFSykvm3OGMbH/W633SfERd/oU12SFmq+W9INadXRsdlk" +
       "OO33JnQNdLZGUdKdTEO70+dYVXC7c1ScUOPGxpG5yjzqz0cy18QZJqiN50xz" +
       "3Wcrrt0kAPNuecbLsLnCJjUzUJI+Lk+HTH9KDVfcsIk3jVVFZaWghomDBibA" +
       "q2bTJkstuukXxkOehYsaQflTUpquSniruGAV2eiGscyxRR43mWKXKtVDqj91" +
       "/AHhTooTjuHRRsJIXTco6XjHLaOuW2tQBh9oRp2RQ0t1hBAjJvWiEYxLzJAg" +
       "BVPoDh1iJhqjhboWaExhZ86k0ZWm8sQj+EGdGSUrPjAHzUazNPIX3XCcReiE" +
       "kmulXgO3yfZ6g+quVWLHia+WNhw9Zoqk1FqrI3xKtYGS/mzuq5OwJ3qYlaKT" +
       "ceynLQevdqNapPcp3U5sbkXWZgwaJ2KZRCyVnzi4JNLFtchM2KbfgXGq1deF" +
       "kkiON7BYgD1iOijYWsg0hE17QeKEPm7babBk7RCn2OZ01cW8cVRGmc4s9tjW" +
       "RuYKASaJBZqyjQ1fi1GLdqT1sCdw3gBnhLipYHjS6rBDvtUJ2ssJhcxYGS8a" +
       "nik3SSIOZaLpbRrA7vw6MlE6EfseRTYXDb7v8LV+VLDIWY810UESzJd1eMFF" +
       "KgF83ULHFDJm2tWVpsWjLgoHNapeiKS+NHMZi14YZL+/YtKNZvF1uKqo5caw" +
       "VJAwdxqQg3KNqWIpKcRij2tWUI9eunKXxYSZti6EVW2EpEID5uKxMi7otGvx" +
       "ctFaC4jUx4o+2XYTJaGHdl9n1TFaxJflqKoOMAmtNphkNjSHdWM6cE0FxaYr" +
       "f+PzkYaMJxNPGHQmRZTTTG/OOrMGVlinSGoEPXcqVgp4vzJeLhpwPzLNidFN" +
       "q72e5bdtiXCXYuQNNFscLxYOrtsNkdELzaXOIUQxQnrzdVWIllU8WW9cL/ba" +
       "qBRvWmjSxW3J9Nb2UlvAZS7qewQtVgwrwHvChCEHdZhoC7SEJUgxqKV1diO0" +
       "e2O0N1Lqgkx1WDLki4olmNLSVjY0zykq11nP/GDRTpqCw4ihjsxbwqiR8lgl" +
       "Lq6bPM9UcJRHhAj0GL0SZgxklETp2A61TlzHloXydIKltjUo9vrVLm1Ly4ib" +
       "1iokuVwv2UJsg7Buqup85MEsGBdVlj3ernZZZmLhHRxdMEVT1lFBnG5MgXaW" +
       "si+68BoukJMUb2glAimw5YpcJrl2VxFazpxYDca8ZZgiqmEDP5lzTlJgZd7x" +
       "6iw/1d3Nok/L5kbcKG17U2ouYwTtg/XX0RZOUrPGrtl1W2u9XSIFYY0WuKBJ" +
       "NhkDc5uY20tnjIdW+kwk+gRpGKkwl3ripNpcq/VFOdSIOGpgeKO4FHyXdkqV" +
       "KoXY0oIYi35nbcUiV18sK33HJItJBU7nMVL2mVU16lftgkquUJrEm4TeWqRD" +
       "tzqlZlXKX4z6KOcijm4r8cqrbWRaHjUw0+Ktjr5JQkNF24V1T4rrs1pF02AV" +
       "a8qlRocXYWs1xNfKeGVwNNMYTyolgxanS5GuRn5grXF0SmMY0eZKS302WJHj" +
       "iTOVKbM6bISrVG0gPZjz5d50ShvJqOsodcauIFNE0JlaXRu17H5J5pYdnVZC" +
       "3l7qls7DrU3ZrkkwupgzSF0IZ7ymrkuawYxbQXftLSvjBaX2V+NhEjXLVLVX" +
       "T5VaK54noKmq8UjFwNIi7vZrCjMnGsgcQYhOt7wpJ/JsVmxusBKtM0QgSUXe" +
       "0uOGORpqZWGjY0osqt04rK143+0QuIq6a7AH6qU5SoDVE6nrlRrb8Sii+LIg" +
       "R9YK052SyyqzpNxTqg7Z6cpEyxTHaNpoSKVWhUn6yUq2+kOiL/dSja3E85ql" +
       "zIThpjypw/NhZxQu1nU4rZdJuNNh4bKHDBpSeVW1UvC+SdSYMU1L7KQ35Iq9" +
       "Noei9HqkaE2YRDoOUmvULbVg9OzZVPLGKjEt1uPFwMfSRoqKDFMf8yJSVCZD" +
       "Fm6MYgRpi43qshlb+FJZTMfl4ipcOqSpDmehsREnFoshvXaq8x4nalHRScse" +
       "gN1C2HIcYuWjmFEWJ0aZQlCpoSGhzWnTlCTqertpIcGkOtOqboNI53Ci9tKC" +
       "WMVmLkrX2JI/rUzcJi/O2y4rYULRMwS/K6tNGI5025nbAxtuD5q1Up3zN5uh" +
       "O5srrZHLrnyZIjqNoOjg+BCpw4IbzqakTjKwWsCMJd3UO53RvM+1A68yLG1m" +
       "gIUors1lkwvoht3S241yP2lacsty6cCcdgss1utb7U7TXHltV4JHukpUBLkv" +
       "iiXeUuabiQ30nUpdhyrDJbQrK6WyUQ6HxoCiV6VS5CuzYDrwezY/W83Z4oic" +
       "CTyMJN6KmPE02LXh0F0ocKHX2kgCMS5t0FJSMTyp0hsSPDVdar5csxYrtbMY" +
       "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" +
       "/wHEAxqRSyQAAA==");
}
