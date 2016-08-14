package org.apache.batik.bridge;
public class SVGEllipseElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGEllipseElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_ELLIPSE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGEllipseElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMEllipseElement ee =
              (org.apache.batik.dom.svg.SVGOMEllipseElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getCx(
                  );
            float cx =
              _cx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cy =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getCy(
                  );
            float cy =
              _cy.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _rx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getRx(
                  );
            float rx =
              _rx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _ry =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getRy(
                  );
            float ry =
              _ry.
              getCheckedValue(
                );
            shapeNode.
              setShape(
                new java.awt.geom.Ellipse2D.Float(
                  cx -
                    rx,
                  cy -
                    ry,
                  rx *
                    2,
                  ry *
                    2));
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_CX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_CY_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_RX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_RY_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        java.awt.geom.Rectangle2D r2d =
          shapeNode.
          getShape(
            ).
          getBounds2D(
            );
        if (r2d.
              getWidth(
                ) ==
              0 ||
              r2d.
              getHeight(
                ) ==
              0)
            return null;
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYe2wUxxmfO7+NjR+ERyEYMIYKAnd1SUJa0xJwbTA9m5NN" +
       "kGrSHHO7c3cLe7vD7px9JnUIkRpQKtEomJQ0gX9KlBbxiKpGrVQFua3UJEpT" +
       "BI3aPNSkVf9o+kAK/4RWtE2/mdm93dt7UMQfPWln92a++Wa+x/y+75tz11Cd" +
       "baFuig0VR9gUJXYkzr/j2LKJ2q9j294FvQnlqT8eP3TjN02Hw6h+HM3NYHtY" +
       "wTYZ1Iiu2uNoqWbYDBsKsUcIUfmMuEVsYk1gppnGOJqv2UNZqmuKxoZNlXCC" +
       "3diKoQ7MmKUlc4wMOQwYWhYTu4mK3US3BAn6YqhFMemUN2Fx0YR+3xinzXrr" +
       "2Qy1x/bhCRzNMU2PxjSb9eUtdA819am0brIIybPIPv0+RxE7YveVqKH75bZP" +
       "bj6daRdqmIcNw2RCRHuU2KY+QdQYavN6B3SStQ+gx1BNDM3xETPUE3MXjcKi" +
       "UVjUldejgt23EiOX7TeFOMzlVE8VviGGVhQzodjCWYdNXOwZODQyR3YxGaRd" +
       "XpDWNXdAxBP3RGe+80j7D2tQ2zhq04wxvh0FNsFgkXFQKMkmiWVvUVWijqMO" +
       "Aww+RiwN69pBx9qdtpY2MMuBC7hq4Z05SiyxpqcrsCTIZuUUZloF8VLCqZx/" +
       "dSkdp0HWBZ6sUsJB3g8CNmuwMSuFwfecKbX7NUMVflQ8oyBjz1eBAKY2ZAnL" +
       "mIWlag0MHahTuoiOjXR0DJzPSANpnQkuaAlfq8CU65piZT9OkwRDi4J0cTkE" +
       "VE1CEXwKQ/ODZIITWGlxwEo++1wb2XTsUWO7EUYh2LNKFJ3vfw5M6gpMGiUp" +
       "YhE4B3Jiy9rYs3jBq0fDCAHx/ACxpPnxN64/uK5r9nVJs6QMzc7kPqKwhHIm" +
       "OffK3f1rvlDDt9FITVvjxi+SXJyyuDPSl6eANAsKHPlgxB2cHf3l1x4/S/4W" +
       "Rs1DqF4x9VwW/KhDMbNU04m1jRjEwoyoQ6iJGGq/GB9CDfAd0wwie3emUjZh" +
       "Q6hWF131pvgPKkoBC66iZvjWjJTpflPMMuI7TxFCDfCgFng+i+RPvBmi0YyZ" +
       "JVGsYEMzzGjcMrn83KACc4gN3yqMUjOaBP/fv743sjFqmzkLHDJqWukoBq/I" +
       "EDkYTVqamibRsd3bBnRdozbhEEEMtlX0R7jn0f/Dmnmuh3mToRCY6O4gQOhw" +
       "trabukqshDKT2zpw/ULiTel8/MA4GmSILxyRC0fEwhG5cKTCwigUEuvdxTcg" +
       "3QGMuR9gAXC5Zc3Y13fsPdpdA35IJ2vBEpx0dUmc6vfwwwX9hHLuyuiNy281" +
       "nw2jMEBMEuKUFyx6ioKFjHWWqRAV0KpS2HChM1o5UJTdB5o9OXl496HPiX34" +
       "8Z8zrAPo4tPjHLULS/QEz305vm1HPvrk4rPTpocARQHFjYMlMzmwdAetGxQ+" +
       "oaxdjl9JvDrdE0a1gFaA0AzDiQLw6wquUQQwfS5Yc1kaQeCUaWWxzodchG1m" +
       "Gcuc9HqE23WI77vAxHP4ieuGZ51zBMWbjy6gvF0o3ZT7TEAKEQy+NEZPvfPr" +
       "v2wQ6nbjRpsv4I8R1ufDKs6sU6BSh+eCuyxCgO73J+PHT1w7skf4H1CsLLdg" +
       "D2/7AaPAhKDmb75+4N0PPzjzdtjzWQbBOpeEvCdfEJL3o+YqQnI/9/YDWKfD" +
       "2ede0/OQAV6ppTSc1Ak/JP9qW9X7yt+PtUs/0KHHdaN1t2bg9X9mK3r8zUdu" +
       "dAk2IYXHWk9nHpkE8Hke5y2Whaf4PvKHry597jV8CkIBwK+tHSQCUZHQARJG" +
       "u1fIHxXthsDY/bzpsf3OX3y+fDlRQnn67Y9bd3986brYbXFS5bf1MKZ90r14" +
       "syoP7BcGgWY7tjNAd+/syMPt+uxN4DgOHBUAUXunBXCXL/IMh7qu4b2f/WLB" +
       "3is1KDyImnUTq4NYHDLUBN5N7AwgZZ5uflAad7IRmnYhKioRnutzWXlLDWQp" +
       "E7o9+JOFP9r00ukPhFNJL1riTBd/VvNmbcG7xK8+GMX83lXEwUJLKyUaIkk6" +
       "88TMaXXni70yHegsDt4DkJue/+2/fxU5+Yc3ysSDJmbS9TqZILpvTV5trChB" +
       "8WGRh3kItPHqjZr3n1nUUgrgnFNXBXheWxmegwu89sRfF+/6cmbvbSDzsoCi" +
       "gix/MHzujW2rlWfCIpWUoFySghZP6vOrDBa1COTMBheL97QK9+0umLaTm6wL" +
       "nl7HtL3l0bGMVxQwp9LUKqdztMrYLt4MM9SShkTLVLA+AtIIykVQagnP5ml0" +
       "RKbRYmAjb0ak737xfzslvGOz6B4qVsZSeB5wJHrg9pVRaWoVgfdWGUvyZg9D" +
       "c0AZroVdXXRVyo1kKuRp5uE71sxcPvR5eAYc8fqraEa0a3izzg1YTdQyGcAQ" +
       "UQMxq9XlVYZnQC01glmNK/2q6tI7paVLPY9TT25QIqqZjTgZY2U9pidYZCyD" +
       "KRkBRBCi0So2Eo3GUHMyp+mqmAeAtKbKBYClZSFZmHBKqOh054f7X/jovMTD" +
       "YL0VICZHZ576NHJsRmKjLEpXltSF/jmyMBWbbJfK/xR+IXj+wx8uBu/gb6hT" +
       "+53qaHmhPKI0L/C1yrbEEoN/vjj90+9PHwk7ahlgqHbC1FTPD/fdsR+KZG49" +
       "PPscn9Fu/4RqFaYGLBxyCgTHSTaUOAn3JHsiDYmEluV6ioEyChdLu7Gek57z" +
       "rSqe823ePAkemIGApROXU4FLP/Snicqppj01HrljNS5x1Tjl6GLqFmrUS09t" +
       "panlTy3/e4A3YiAn+D9XRTPP82YG/FGxCKhEHKo4FrcyrkVWVD62fkqhshO3" +
       "r7I8QwsrFJk8xVpUcuMlb2mUC6fbGheefuh3otAp3KS0QImQyum6LzL7o3Q9" +
       "tUhKE5K3yASTitcZ2EQFnIMqIOnh/Pck/UsQIYP0DNWJt5/uLKCVRwes5Ief" +
       "5DxDNUDCPy9QV+frq5TjQvNFesqHSlNLYY75tzKHL5dcWYSj4jrSTZZy8kIy" +
       "oVw8vWPk0ev3vyiLNEXHBw9yLnNiqEHWi4WEa0VFbi6v+u1rbs59uWmVC2Md" +
       "csPegVjic9PNgBCUu8PiQAVj9xQKmXfPbLr01tH6q4DYe1AIQyza47sMlDdf" +
       "UAblIBvcE/Nnsb5LbVFc9TX/ae/lf7wX6hRpO5K3F13VZiSU45fej6co/W4Y" +
       "NQ2hOkBpkh9HzZr9lSljlCgTUGA05gztQI4MqeCFSTNnFG4u53LfxTzHEppx" +
       "FNpa6OVFPkPdpbGn9OIDKppJYm3l3Dmb1kCKmqPUP5rnN3plpALb9J7656En" +
       "39kJZ6to435uDXYuWch2/RejkrcIg7x5LC8jXk0iNkypEwFDl4VVKRUY8HMh" +
       "9Kyk5hQMhdZS+l9jCCp54BgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u3TJd6Qfefczz6v9j5ZO7p6aTWPoxtgPHnO0peYcYpVdMD569d03k985HZzm" +
       "fPHd/3r36KeNt72MM+r7jsl5nOXvMC98ufM65ddOQqf2z3Yuuw072unxoyc6" +
       "Z0MtTkJvdORc5559y17ILHYveEq7li1d+Zz4ilFwIo+Cre+vcSgZXaMtyQov" +
       "hm6eazHtK5LD7opOHoSL/6M2/IeZ5hX2Uf3uAU9jV7/Gj1+/d1yj7V1ZsYmh" +
       "m4B+ex7aO8G692rXLNtblQMDvP0VGODWrLIMHmLXAPjLMQCYGEHox5oSa+oV" +
       "7XBq98R1V6WHr63S7tXzHvXtGfUKUXZU393ZvVG6unHmy3hnaEiBxvqqlgvz" +
       "9DUM/2xWPBVDZ+XEdNS8X043PARAkxi6bumb6oGlf+kVWDq/cnkMPNaupc0f" +
       "T6id2L002zUMcplhMutFy/kO5pludgBLm0uQQMWhKSexlh8W53x/6xrW+lhW" +
       "PA+sbkie6mh7nPa54KB+rqkZ1XMH1vrNV2Ct1+xZa71rrfXLtdavXCsgs5/v" +
       "y4pfzYoP5KS/ew0D/H5WvBBDF5RQA5rn8cJJ+R8S9gz/wNUj8jBlbplPvBzL" +
       "pDF051VuVrNrorsu+5vH9q8JyiefP3fDnc8Lf5NfLu7/feBGGrpBTxzn8Kn+" +
       "ofczQajpZq7zjdsz/iD/+mMgxFUmbwydkQ8Q6bNb+j+NofPH6WPodP59mO7P" +
       "wRQ8oAOsti+HST4fQ6cASfb6hWDP2o9d4w46t/kRO6UnjmYA+4648KMccShp" +
       "eOjIUp//B2dvWU62/8K5pHzq+R779pdqH91ejCqOtNlkXG6goeu3d7T7S/sD" +
       "V+W2x+sM+cgPbv30jQ/vpSG3bgU+iPtDst135VtIwg3i/N5w80d3/sEbP/b8" +
       "N/KriP8D6dIC8hwlAAA=");
}
