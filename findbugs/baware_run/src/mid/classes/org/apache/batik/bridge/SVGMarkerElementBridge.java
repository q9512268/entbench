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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ZeewkWV2v+c3Oye7O7Czsrgt7MmB2G37V1Xc7yG71VV3d" +
       "XV3dXVV9lMpQd9d9X42rQIJsJMGNzAIa2L8gKlmOGIkmBrPGKBCICYZ4JQIx" +
       "JqJIwv4hGlHxVfXvnoNsNHbSr6vf+77v+56f9633Xv4+dMb3oIJjG6li2MGu" +
       "lAS7mlHdDVJH8ncHo+qE83xJbBuc79Og77rw5Bcu/fBHL6wv70BnWeh+zrLs" +
       "gAtU2/Jnkm8bkSSOoEuHvV1DMv0AujzSuIiDw0A14JHqB9dG0OuOTA2gq6N9" +
       "EWAgAgxEgHMRYPSQCky6R7JCs53N4KzAd6Ffgk6NoLOOkIkXQE8cZ+JwHmfu" +
       "sZnkGgAO57P/c6BUPjnxoMcPdN/qfJPCLxbgGx971+XfPQ1dYqFLqkVl4ghA" +
       "iAAswkJ3m5LJS56PiqIkstB9liSJlOSpnKFucrlZ6IqvKhYXhJ50YKSsM3Qk" +
       "L1/z0HJ3C5luXigEtnegnqxKhrj/74xscArQ9YFDXbca9rJ+oOBFFQjmyZwg" +
       "7U+5S1ctMYAeOznjQMerQ0AApp4zpWBtHyx1l8WBDujK1ncGZykwFXiqpQDS" +
       "M3YIVgmgh2/LNLO1wwk6p0jXA+ihk3ST7RCgupAbIpsSQG84SZZzAl56+ISX" +
       "jvjn++N3fPg9Vt/ayWUWJcHI5D8PJj16YtJMkiVPsgRpO/Hup0cf5R740vM7" +
       "EASI33CCeEvz+7/46rNve/SVr2xp3ngLGpLXJCG4LnyKv/cbb2o/1TydiXHe" +
       "sX01c/4xzfPwn+yNXEsckHkPHHDMBnf3B1+Z/dnqvZ+RvrcDXcShs4JthCaI" +
       "o/sE23RUQ/IwyZI8LpBEHLogWWI7H8ehc+B5pFrStpeUZV8KcOguI+86a+f/" +
       "gYlkwCIz0TnwrFqyvf/scME6f04cCILOgS8Eg+/T0PbzVNYEkA2vbVOCOYGz" +
       "VMuGJ56d6Z851BI5OJB88CyCUceGeRD/+tuR3Trs26EHAhK2PQXmQFSspe0g" +
       "zHuqqEgwNccIztMlL8MLyQpaefduFnjO//+SSWaFy/GpU8BBbzoJDwbIrL5t" +
       "iJJ3XbgRtrqvfu7613YO0mXPfgG0C9bd3a67m6+7u11399brQqdO5cu9Plt/" +
       "GwvAkzrABICWdz9F/cLg3c8/eRoEoRPfBdyQkcK3B+32IYrgOVYKIJShVz4e" +
       "v2/+y8UdaOc4+mYyg66L2fRJhpkH2Hj1ZNbdiu+lD373h5//6HP2Yf4dg/M9" +
       "WLh5ZpbWT560rmcLkgiA8pD9049zX7z+peeu7kB3AawA+BhwIJ4B9Dx6co1j" +
       "6X1tHyozXc4AhWXbMzkjG9rHt4vB2rPjw57c7ffmz/cBG9+bxfvVvSTYTwYo" +
       "G73fydrXb8Mkc9oJLXIo/lnK+eRf//k/lXNz76P2pSP7ICUF144gRcbsUo4J" +
       "9x3GAO1JEqD7u49PPvLi9z/4c3kAAIo332rBq1nbBggBXAjM/IGvuH/z7W99" +
       "6ps7h0ETQBcczw5A7khicqBnNgTdcwc9wYJvPRQJgI0BOGSBc5WxTFtUZZXj" +
       "DSkL1P+89Bbki//y4cvbUDBAz34kve0nMzjs/6kW9N6vvevfHs3ZnBKyze7Q" +
       "bIdkWwS9/5Az6nlcmsmRvO8vHvmNL3OfBFgM8M9XN1IOaVBuBij3G5zr/3Te" +
       "7p4YQ7LmMf9o/B9PsSNFyXXhhW/+4J75D/7o1Vza41XNUXcTnHNtG2FZ83gC" +
       "2D94Mtn7nL8GdJVXxj9/2XjlR4AjCzgKAMZ80gOIkxwLjj3qM+f+9o//5IF3" +
       "f+M0tNODLho2J/a4PM+gCyDAJX8NwCpxnnl269z4PGgu56pCNym/DYqH8n+n" +
       "gYBP3R5iellRcpilD/0HafDv//t/v8kIObjcYi8+MZ+FX/7Ew+13fi+ff5jl" +
       "2exHk5tRGBRwh3NLnzH/defJs3+6A51jocvCXnU454wwyx0WVET+fskIKshj" +
       "48erm+1Wfu0Axd50EmGOLHsSXw7RHzxn1NnzxaOQ8mPwOQW+/519M3NnHds9" +
       "9Up7b2N//GBnd5zkFEjYM6Xd+m4xm/9MzuWJvL2aNT+9dVMA6t+QN1SQJmf9" +
       "vDQFs2TV4ox88WcDEGaGcHV/hTkoVYFfrmpGPWf1BlCc5yGVWWB3W99tcS1r" +
       "SzmLbVhUbxtCP7Olyjewew+ZjWxQKn7oH174+q+9+dvArwPoTJTZHLjzyIrj" +
       "MKuef+XlFx953Y3vfCgHK4BUk492Lz+bcSVuo3X22M2aXtZg+6o+nKlK5Tv/" +
       "iPMDIgcXScy1vWM4TzzVBDAc7ZWG8HNXvq1/4ruf3ZZ9J2P3BLH0/I1f/fHu" +
       "h2/sHCm233xTvXt0zrbgzoW+Z8/CHvTEnVbJZ/T+8fPP/eFvP/fBrVRXjpeO" +
       "XfBm9Nm//K+v7378O1+9RT1yl2H/LxwbvO4H/YqPo/ufEbLiSzGTJAs5hCey" +
       "WinDLTZoEyQqUX0e5ylddztMgIoSWhP1QmlKIY5fTIJNUF56aZksbMjSQqbX" +
       "rbbTkdz+EC1Ni7pX6SL9udpmZwinNbsh5TIOYdPU2EZIbmJ6vGvA1U7bKCg9" +
       "uVxmTb4smnC0UQ0ZlLXjulBqSPQkikS4UXbCpqAQCKmtOHusMcIAD5gQ14tw" +
       "XNUWpT7XJjDRibXiIJhFsNkXamIE1zyEbk2RDYciflNh5/VepxNq3eIgZoNe" +
       "t9xfsWODVug1tm7MAtvseH2LEIlAiLkAYUsJqs2L84WsGTpXiXs930HQJetv" +
       "Fn5xjiVG3OtgyFAVi/ZKk4eR10EF1EXcGSs225LvVZW4u9Y0X5nDk5W03gTT" +
       "wQQvzPGAGA84ps6P1roNhw5LbczOyjeolW7QiTIJ7UrF6rtxqhQ7o7IshNGE" +
       "4IdiPI0bJXrlD7rVolMxNGwy7lEuMYn69ByPaXPQ16WkB9ITJ5IpHjKB67fV" +
       "trpxS8CQsVTn1bnuaz2t3SdZh3Nxt5y0OovUnTPYRlNc3xzJKwIz3BVXD1ed" +
       "MRuOjMhb04FesZd1Q57Iskdv1ps+Q6yImtgnOb4o9Wi6tWLRlUApDrvSovoY" +
       "R2yipo3WeGvSRaL+2qvrMy/iizJhsvoCVUhhUTZMPWmxXsGrtSl8EIhGzzCM" +
       "YmmUimhVrnqbll7p1PlSwWOH7RiOZQ2NPX+C1VsxVh8ZNBayRSYhKq6TzAKt" +
       "n8xmbdQVir3Y5IKGgY8H9opE2sX1ykQ3XjHuFIi4oXZYDu32+NWwRDJh1VMD" +
       "pmq1BXYdcL2qOEjbwxm3piaVHs4v1v6iO7A1qmC0GTTCqgTft2rziYnT5BD3" +
       "WpbGKVgZbjSJoQ6PMXNYxdfjSmuDqwuk40piXK8Flh2rrcbYnfoDutoQxXDi" +
       "pU25MEeGPLle+4neVGazBcM1rR6yqfO1WSzA3QKQ0SWX9mSizAEA0IbF9te6" +
       "z5hDruwNupOBV24ZnCnLsDnoNdaynSqFteMwaaos0K4ousZCCfW+rzSm+thk" +
       "u1iRDJLxDEsmCkgY3jKwClWiQzbdmF2N62LT8hRZSDgctpX+0FNHlajtmxtr" +
       "JNW41WblWV2dwccCsRzKqDiN8E3aCrERtlwM12jPbWoMzQSDUsKVrVhkBLSa" +
       "VHpmh1nYzkLowGWUqOueP09SD9hd6/kRMWwZNNHVTJvFEDFNxkYh1FrCYjPp" +
       "goRqdfqsHGBilWhrMNwwqGY8mkxD4FnajjS0ifXbaccwsVmYEpJXq8gwbapV" +
       "vTyQ6Yqw7DcTBKUQvTwU2bFa5mbCGDHqyxk1UMllWAXxP+qierWC0sqA5luu" +
       "BEuRVimtuitlgIbjLroKSbXkqlOk4pD9BFbYpgDyWAyiKJnD+MpV43aTpXqD" +
       "gqOvGRZ12RqWjAYzZzrnS0JFxkxGa46QcdxfeGZFIHm7xhQG8pQeWGngt8Z1" +
       "tdgkBd8PRgNi2I8cXtJcuSCSoVFNahuYHMs6U2oMegqi1yfDaUetrCRiUwta" +
       "Jtz1TEQQKEaconN0WdwAiBmU2gU4QrmeFKf1ThcJakyvQ1RZUenyMqFqyEbl" +
       "A67Yi4qS4ul+oxz766VPThYNvKk0q+ysnxYNeFiia0NmlbL6WlC6VjU0jWYd" +
       "jDbLbUusUxyh6WTJas98stuaLxG1aLtC2K+0ML476NTrwrIYTv2ypdlmAxUo" +
       "q5YiK3xYxoutabc7iBtNUZ7AllTf1Bpwt84kadLxRKqEtRLRdpZDMcLXyKg2" +
       "tGYbF3Y4tBZvpjGO0RIx7a5Iu9pfCOPYhweTTViqW5rBF5tlSlVWRZJYc3LU" +
       "H8Kd+qTeBajUN+26XF+zLp5aZFDfsDLdGlS0WrNqlcrajK9Nio7lYXV4g4Gt" +
       "yJ12bKSJLVWsxQzGKTobJ6W27M+LUoXQ6HLXrEzppA8b3WnEzFoWYi6FAqfB" +
       "taK44FeeNJ/NmbhMkquOHnYbC9Zri3R5zVtmt8+a00V9mfqzJWmX5mStlbQ0" +
       "yo2HI9JBS915zUbXaSSWJpsCXYYXEpxwnS4zsUfr9Uoqor1QIILpCFVpYrTs" +
       "maqUFBbxHLEVjqVN3HU1Ui6Ue9M64xK91J5FRrlONWtEs4xEBYZsDW1T7ZBI" +
       "uVGieG4qVv1mqbOc4QHrjubNDW5M9KpMR+OGUrXSJiNjjY6uGn13DIQTGnXF" +
       "iNxUaHBBuFhyVUWaKSVEDYJZzygVBGuTNj29sQl0VByIC6pGTLVlQ0FguJbI" +
       "A7XehO3iiuRMZiELqNJoULZPiNii5lBJXbXh/oYrlctNMUw7bFNC5sCvnmvC" +
       "tF5ZuU6DjpWw0QxnMrKGqzC5ScKi0jeLQ7LtRg04UufjuBoy1cJYDQdz1h66" +
       "tiemRaszZfm2TXOt4bhusNFQFPsDtUWYaY1kADjw0WgtlMKSM/UFQuVhlvF7" +
       "SNOoqU6jMZzPE5OtEA1kukiqQ7IY9RJltqpUsJipxsbSUyxW6oYti99UbaXR" +
       "GcDNcqNi1JuKF6qSZ/H9ZbDQojIdauWAmsY0lmjVtYUEbI0t+tJUFs2qbpUF" +
       "0uxZC4fyY2cQFHh1WvdWy1JlXq449RbKy67GtVaGLwlFOFi7zrhKiiyholp5" +
       "kDaljbTExzDjrbvVCVfzQrc8xKp8rWIN+lQTTvF6YyYyXrUXTDGMri7HeIwm" +
       "9rjC1/BSyhj9gLD0KTGf6BxWIPUKNvbLNZqQ9AmZVol0M2GGk0pHcMWVqoUp" +
       "SInCDGUkNl1juBYnzQkjwJxVK84bVk1fEuTEWSDpQGwxjUEVmasGbbXWGBXM" +
       "Gks9Avgx7HcKTNqg4XbFSUERhNGMUV1N6GpaK4idjR+0qA6fFgdkTQbAtRjP" +
       "C2xU5xlE4h1Os4sSJo/TGsLbaaUdFigMXpFFfNqakJ3pLNXA1mVQbRI30oE8" +
       "kqo0sixvPF5slah402VQalPuo5FQDZfznuSucKcDdpxpPJzSEmVbLtfRCklh" +
       "HMFwuUmNZDwsatJ04izNam+2QcpNfFACqB3MwK6NYSq21EWcUMOI7CX8eMiN" +
       "yGllOWU0GtGLTOooXcZH+Nlo1KwtCKKldQyjLRQqHbMYNeFB2+KwlusIwzFV" +
       "iZgB7k/7vFlSFtY6UWEKM+KAoKJqZ+ErgeaHE2pSbDYrYoKTC2KJKU2XsxbD" +
       "ktVJ2/yGb/Bj3FnIKNzALbTZhBtpcTIkYSWaNotaXUVgATY5umQMNJ9J3WVv" +
       "uBQtfDTtdihlnixb7WHUWPBCyoTxvKWr4xGMahYXOjzVAyV+Vvq/67W9fd2X" +
       "v2ge3CqAl65sAH8Nbx3JrRc8lS94eGSVf87un0nv/x49sjo8x9jZf829ersT" +
       "2e1x7PYcdp/4rbcj7nqe7R3cQGXvbY/c7moif2f71PtvvCSSn0Z29s6WVgF0" +
       "IbCdtxtSJBnHxPSgp2//fkrkNzOHZx5ffv8/P0y/c/3u13CY+9gJOU+y/B3i" +
       "5a9ibxV+fQc6fXACctOd0fFJ146fe1z0pCD0LPrY6ccjB167kjnpUfCt7Hmt" +
       "cusD1TuFQB5Adzi6S+8w9p6sCQLobgWUebbAGeM90fHD4Ax/0ivxUaZ5h3uz" +
       "fs/s6ffM/41+p/fO4/ZC8y23C81tBO9dTO5T359Rx2VhV7TN3b0rh2zo+Xyp" +
       "D9zBXB/KmvcCcwmexAXSNkv22b7xJiGUKNg9QpNb832vxZpJAD1w68uR7Jj3" +
       "oZuuabdXi8LnXrp0/sGXmL/K7wcOrv8ujKDzcmgYR0/ljjyfdTxJVnM1L2zP" +
       "6Jz850YAPXgb8wbQWf4QIj6ypf9YAF0+SR9AZ/Lfo3S/GUAXD+kAq+3DUZJP" +
       "BtBpQJI9vuTsm7l0O1+jlgreYbNj8/zEUBWA5bbGSk4dQZW9GM2dceUnOeNg" +
       "ytELhgyJ8ov0fdQIt1fp14XPvzQYv+fV2qe3FxyCwW02GZfzI+jc9q7lAHme" +
       "uC23fV5n+0/96N4vXHjLPkreuxX4MF+OyPbYra8SuqYT5If/mz948Pfe8Vsv" +
       "fSs/S/wfrt2gReEgAAA=");
}
