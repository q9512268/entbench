package org.apache.batik.bridge;
public abstract class SVGShapeElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    protected SVGShapeElementBridge() { super(); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.ShapeNode shapeNode =
          (org.apache.batik.gvt.ShapeNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (shapeNode ==
              null) {
            return null;
        }
        associateSVGContext(
          ctx,
          e,
          shapeNode);
        buildShape(
          ctx,
          e,
          shapeNode);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertShapeRendering(
              e,
              hints);
        if (hints !=
              null)
            shapeNode.
              setRenderingHints(
                hints);
        return shapeNode;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.ShapeNode(
          );
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        org.apache.batik.gvt.ShapeNode shapeNode =
          (org.apache.batik.gvt.ShapeNode)
            node;
        shapeNode.
          setShapePainter(
            createShapePainter(
              ctx,
              e,
              shapeNode));
        super.
          buildGraphicsNode(
            ctx,
            e,
            node);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertFillAndStroke(
            e,
            shapeNode,
            ctx);
    }
    protected abstract void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                                       org.w3c.dom.Element e,
                                       org.apache.batik.gvt.ShapeNode node);
    public boolean isComposite() { return false;
    }
    protected void handleGeometryChanged() {
        super.
          handleGeometryChanged(
            );
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
    protected boolean hasNewShapePainter;
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        hasNewShapePainter =
          false;
        super.
          handleCSSEngineEvent(
            evt);
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_WIDTH_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINECAP_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINEJOIN_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_MITERLIMIT_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHARRAY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHOFFSET_INDEX:
                {
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
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   SHAPE_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertShapeRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertColorRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
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
       "jyw3TXTV0DQeNP4LUhKC2C8gAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16C8zs2F2f77d77+69Sfbe3c1mt0uyyWZvILsmnz1jz6vL" +
       "Ix6PZ8aesWfG9ngepWw8tsfvx3j8nLBtkgo2AhFWsAkhghWgIAjKAxAIqiqw" +
       "iFKIgqqmoqUgIFC1KiWNSqSWVqSFHnu+932E1a76ST7fmXP+53/O//U7f5/j" +
       "T38VurwNITjwnVx3/OhQy6JDy6kdRnmgbQ+ZYW0sh1tNJR15uxVB23PKO3/h" +
       "+l9//UXjxgF0ZQk9LHueH8mR6XtbXtv6TqKpQ+j6aSvlaO42gm4MLTmRkTgy" +
       "HWRobqNnh9AbzgyNoJvD4yUgYAkIWAJSLgEhTqnAoDdpXuySxQjZi7Yb6J9A" +
       "l4bQlUAplhdBT55nEsih7B6xGZcSAA73F78lIFQ5OAuhd5zIvpf5FoE/CiMv" +
       "/eh33/ile6DrS+i66QnFchSwiAhMsoTe6GruSgu3hKpq6hJ60NM0VdBCU3bM" +
       "XbnuJfTQ1tQ9OYpD7URJRWMcaGE556nm3qgUsoWxEvnhiXhrU3PU41+X146s" +
       "A1nfcirrXsJu0Q4EvGaChYVrWdGOh9xrm54aQW+/OOJExpsDQACG3udqkeGf" +
       "THWvJ4MG6KG97RzZ0xEhCk1PB6SX/RjMEkGP35FpoetAVmxZ156LoMcu0o33" +
       "XYDqaqmIYkgEPXKRrOQErPT4BSudsc9XuW/7yPu9vndQrlnVFKdY//1g0BMX" +
       "BvHaWgs1T9H2A9/4zPBj8ls+/+EDCALEj1wg3tP86vd87b3f+sQrv7un+abb" +
       "0IxWlqZEzymfXD3wpbeST7fuKZZxf+BvzcL45yQv3X981PNsFoDIe8sJx6Lz" +
       "8LjzFf5fLT7w89pXDqBrNHRF8Z3YBX70oOK7geloYU/ztFCONJWGrmqeSpb9" +
       "NHQfqA9NT9u3jtbrrRbR0L1O2XTFL38DFa0Bi0JF94G66a3943ogR0ZZzwII" +
       "gm6AB3oEPDeh/V/5P4I8xPBdDZEV2TM9HxmHfiF/YVBPlZFI24K6CnoDH1kB" +
       "/7ffUzlsIFs/DoFDIn6oIzLwCkPbdyKr0FR1DRGknmDIgVbAheZF7bL1sPC7" +
       "4P/7jFmhgxvppUvAPG+9CA4OiKu+76ha+JzyUtymvvbZ5754cBIsR9qLoPeA" +
       "aQ/30x6W0x7upz287bTQpUvlbG8upt87AjCjDQABQOUbnxb+MfO+D7/zHuCB" +
       "QXovsEFBitwZsclTCKFLoFSAH0OvfDz9oPRP0QPo4Dz0FksGTdeK4eMCME+A" +
       "8ebFkLsd3+sv/MVff+5jz/unwXcOy48w4daRRUy/86JyQ1/RVICSp+yfeYf8" +
       "K899/vmbB9C9ACgAOEYycGaAO09cnONcbD97jJOFLJeBwGs/dGWn6DoGt2uR" +
       "EfrpaUtp9QfK+oNAxw8Uzv4UeJ4+8v7yf9H7cFCUb957SWG0C1KUOPztQvAT" +
       "/+Ff/1esVPcxZF8/swkKWvTsGZgomF0vAeHBUx8QQ00DdH/y8fGPfPSrL/yj" +
       "0gEAxVO3m/BmUZIAHoAJgZq/93c3f/jlP/3k7x+cOk0EXQ1CPwKRo6nZiZxF" +
       "F/Smu8gJJvzm0yUBpHEAh8Jxbk4911fNtSmvHK1w1P9z/V2VX/lvH7mxdwUH" +
       "tBx70rd+Ywan7f+gDX3gi9/9v54o2VxSip3uVG2nZHv4fPiUMxGGcl6sI/vg" +
       "v33bj/2O/BMAiAH4bc2dVuIZVKoBKu2GlPI/U5aHF/oqRfH27Vn/Px9iZzKS" +
       "55QXf/+v3iT91a9/rVzt+ZTmrLlZOXh272FF8Y4MsH/0YrD35a0B6PBXuO+6" +
       "4bzydcBxCTgqAMS2oxAATnbOOY6oL9/3R7/5W29535fugQ660DXHl9WuXMYZ" +
       "dBU4uLY1AFZlwXe+d2/c9P5jYM+gW4TfO8Vj5a97wQKfvjPEdIuM5DRKH/ub" +
       "kbP60H/837cooQSX22zEF8YvkU//+OPkd3ylHH8a5cXoJ7JbQRhkb6djqz/v" +
       "/s+Dd1757QPoviV0QzlKDSXZiYvYWYJ0aHucL4L08Vz/+dRmv48/e4Jib72I" +
       "MGemvYgvp+AP6gV1Ub92O0gpwusTR6H2iYuQcgkqK99ZDnmyLG8WxbfsI7io" +
       "vvsodP8O/F0Cz98WT8GnaNhv0A+RR1nCO07ShABsSQ8Z8pbT0nL3Gctlknh3" +
       "I49D0wXglBxlS8jzD33Z/vG/+Mw+E7po0QvE2odf+v6/O/zISwdn8s+nbkkB" +
       "z47Z56Clyt5UFGQRI0/ebZZyRPe/fO75f/Fzz7+wX9VD57MpCrwsfObf/9/f" +
       "O/z4n33hNpv0fSvfdzTZ2yN5UVaL4r17FdfuGDT/cL++SwBSL1cPG4do8Xt8" +
       "e6PdE4HXk3jlmADIrmzLNwcwam16slPKSkYACBzl5rHNJGAVEDk3LadRsnoE" +
       "vDuVQV/46OE+/b6wXvLvvV6g0QdOmQ19kMn/wH968fd+6KkvA+0w0OWkiAqg" +
       "xjMzcnHxcvN9n/7o297w0p/9QLmdAE8cf4y68d6C63fdQeqiKhbFtCikY1Ef" +
       "L0QVysxsKG8jtoR/TT2RtntGHiYCm4j/GqSNrr/Ux7c0cfw3RJdyjZhmKwez" +
       "sCSPCTWfU8R4RNQ3ox6FmTS8YPOBMqYa1Ya1UBZ92x6G7C5ZKdZ2N+6II0Tt" +
       "+wtaIt2pIxkU2tbX0iDTGZ6YNhtt03YYhpfZGTvhLSroDZik189sTZLImWYL" +
       "ogs3Ak91l14fngwGFaWyXmEihqiVNYwk9Z1XH2/c6lBlDCH0TV41F4JWofsj" +
       "NctXgwDdcEwUom3MXNkjBM6RxirDWvOEDEYyLdLRUHVaW1cUK0IodfsxPR8M" +
       "N1zAoa4athxyQ1MrzRdllDdltze2eXfTXyZZxE9nM6ll2DS/YDg7m5q7jDEd" +
       "JhyxLcuneowt4nWNaUYcJaWTduxytunmi0XWIENiQPWjppy6chOZZT3XHWAC" +
       "yQkcG02HfCCuVFndNk0n2PS4zmzbM1uEYrZyc65RNO6vFt2pZNb7ZrOpcDu4" +
       "xXBzYicyEor1emt+breiSRYbgp+imtuayyJvrXJuzUjTjI3s/o4yvB2HomQQ" +
       "9RbSaD5PmwPRgqV65LBWs79cCHWn54x7xI7KwxpJDyRHyExKrFWVHunNWXyJ" +
       "WkRD3TVbeb2u11ONhR10Ml4nQy8wKjNbWejoJvH1vq31JrvOYknolGBxjBzZ" +
       "YZeebiZ1ftnGp+OpHUtcf9bwYXQ2y7AZs1x0KazT1U14x4Rz3Avq2wkzJtza" +
       "THJnfac6jTIfY2BJVlCZN/DVWsK7fB5nyZpY0Oyg3eAEKjI1fccEm7ofYjQ+" +
       "YNd0U93gHYIiox1wJC5hVqJKOxrVlQ3a8W0LV/oT0UJxpR1xPkE1BDxcTg0z" +
       "pKvM3A05KhWt4aSLa4xJyp1NLBATY0ktJ2J7RK4m6KBOOB7W0BoNxA2dpBLN" +
       "Nwtj1GHJYFoZj1v2pOeP6UHVG8wCvkmM2qPBNFQ3yBSORI0lQfCQLDHsteFm" +
       "MNtV8ko8Ruqkzjgq4S50bRJLsykNO0xWrccDjZfUOS72NyLLzaZru+v12cTc" +
       "bUNMtEXaroSeScd8tOvicISo6nhEI6LK9jyfEWe5P5vuFtSa2wZUJi0qslw3" +
       "RsOFwwfL9XRawQJci1tBe+Wy0szD4woxcCWxYm9deZ1JltJFdNwQJgTTrRDt" +
       "nTRtLhtRPp0x4VjJF0ZA2BqrjzTRHMJwv9Vr9Sw550ifoeL6xkj4uDfVkbox" +
       "6XsjvzNnu5KNWq4uNrBGYMuasNn0KvZQ7NCbHsXx+Sw1rYlktnp2IIQdrrPB" +
       "ZaWizyw6aOvmZlubN1cTMdolIIRrRqc3TdedhUSMeaWv42xvHc5naJvfMNqk" +
       "U13Owp1Vn41Iiu3UsK7N45ZQ7axMTq+mocaZPdRiVorj8511Qxgqc0MnN30q" +
       "bBMCnXfZWWcOZjArjVE9JIgtxgsy0Wl3Kwtn0K0nrGUYSUytx+IUTnricDdV" +
       "yCWbthnFXpJ6Is4ns4Bw+ZqQdQI9pDZzmknTqoyu6cCPJ7V83G/wYE+P4+oO" +
       "ae/gnG5Sm7zr03NfwTEJNpt1PatpJgBSrzGBx9gq6TT7OUIzM7y3ImgK5QZ8" +
       "hcQm2kJUIlWpLzxqutvW0+pEyEiX3k1Tco4P0krWUPycRNVhZPQ8NyDwpWgE" +
       "M57rZvmiuu0IlaS3GWu9XgXdeZUmNQjqvcRarD17NmoifSTmgg1uGSIIfFmk" +
       "iaGnyzDb0+HWKEiQUGbNVsL16CosdVr0bKUkgtnLukZ97FqoiPXaPOm1kdiE" +
       "YaTWwFrVndvSlUkTjaIq7VgddOJNyR4NrxfzKKjAOCJ1QnzScqszGwsnbNuv" +
       "DR0p18RKak7zJAWvOXF/YpPeZDFF+0SdgwPd7QUDZ0nLvIjUJHgEwg5uqhVN" +
       "ZIkph4XmLBpbzfZwh3kVh1GDOq6tctVOPcbt6a3t3NFpLxgDWE22ZBZ0WJiv" +
       "IvOcUVv1uefTTb1DzZ1EFT0bZ6SUNUZJpGxriEMjQ8KN5njUDmC4iqCs1GxL" +
       "XRJL1oN2hcXW6w46mzfk1A8HIYzDuZbOuv6qoxv5xMtcEL1bZ5RWUidDEqQy" +
       "ENUkVabtlDStITXtJ4TumfPBDoBFY1NvhdIaGTKVvG5vKKfG9Sy+M3WWQ4xt" +
       "0WNexyOVnQy8sduMY0qx1yE2zAUanbP+buc53Gq68XdM3Mux8c7bZS212YI7" +
       "ITaoU10FGxlNocYLPR7oTeMaLazmU5iXeYi4wejaIhkYDYKYR0mfqAR5q9JE" +
       "Bgaddyq4U/dTAnE6aJ0e7bRNreXAXGMK3K4GawMl3VGzCYJtzdFyjU8a4G1s" +
       "aLd8AzUnDUdruoISm6u01o5mWqMmtqdZOg+N5Ww16I7qzUo/x12CalbRldVt" +
       "aSufrU1irilv3Imh1RoJPB60UrUj+Vaa85vR1iD7YcwQUwJfxTTlbmrwqJlM" +
       "lg5mSnkLowJsvg0m8k5YJt2hOO3YM4zarIVRtKglWmNZhREp7krKgJ+S8RaJ" +
       "Roi7i2aprY20bbqY1VJ4PXNSYz7bkq0tl9rx2O8hVGeHpBN1bOUtaqeKAp7x" +
       "sYKMJLfqmgAa0lQHWRKPRqtq1mqOKv32JGqb6ZZAG2i/kaS2EiltahJ1YRFG" +
       "NsQQw3F9NhmSnTQltZVTd+ai1auH2qixtmotbLWlZHUzEDJXQntJK9bXSIKF" +
       "eb+CrMMuZUnCiiNyTvB8mPLFPIxSucK09U11FUwQuNlY1ObtnFBbtUE9HNTi" +
       "vMVogUrAMlzZohslDxteuuKWBsXNO8JAH3JkTxiAMfiqPTOY1djBg9XCtY1+" +
       "tja2jLkebXO9o6CuL3NeQOGk0qD1jhfUrKRZaftRsK41dgvDaaNSSwgjxFhY" +
       "MAo32+2lRvLBjPLkWU42WJ9VcKfH1y2XrszHDq+zJlZt5ghn7rrTxKpoaryK" +
       "IsHr8SYjynlNIOaaxHENq91sJGt3NTeqiTAjJR5R0mGzjdpaw0rqeLDpNqOK" +
       "gW3Mgd1dTfH2wlR5RRZ8rusL4zmJVi26DmdcxFPd3W7Yp9FoUKm2nZXQo6i6" +
       "M2E8cUp3Fz5J0GQtMZPWdjGTyNjNOpGOsRI+ZcY8bPHLOUOxIs0HTUQ3GtPQ" +
       "aVesUW+iT7f2zFiTaBYM2YgMV4jcxh243vQdlrUabZoSRIweVsl2JnlrL8+8" +
       "YWvWzAcraxrP09V4RKlunUzoxEaTgS/JkxRGpUqy0rfMiHc1Jrfqdnui9fNw" +
       "ibOqU0075MpCwVBsNEmVmKste8Rs1sq5pUR01t1VplREQ6zgIE9vu6NxJZHa" +
       "HWZt5HBmGzt2E22EgIrWXJcBjQmdj0Rez6TmRERbU6QvMCvCxmRcpBBFYDeG" +
       "Z7eI0IlRB5sM55uZ3h/rTOJU2gatphrZSbTJ3BGn8/EAhPrEw1Ldn9apmhYb" +
       "PQ0Aiat2F7zsEGoW60J/SXaa0WozFZxOc47vssWqEXXygG7aCr5mYL7t1tl5" +
       "Z4fXjBpQipLMOpaoyLbqWehogG3dRjB0QLimLUfoRjMwPzPgc1UfLPvGcId4" +
       "cQux4PpkvtvJUUOk1w2PHSduw/Sc6ShKuXjYVZcjfExs6d1YmHK8rxJohQ34" +
       "5WKHpUpN3xAKirRgm8KbCPC3TifbsmIFS2sVgpyvzP427rfmNsh0I6NqwBbw" +
       "vmVPS5WutB4uNxmL7ZJ6U484FkcYmTdxcUKGVIe1kkpdsrjKmlBUQ0fG/V44" +
       "WKjyZLbI+kyOUqjRluRwhylmX981sRpi8Ngm1WOvkK/KR+HOB6HYHsO9KRfa" +
       "GGPW4X7X2OU8eJFvZ8EACSaMWI9BDqGuBvlKm3esPmJHAIA7eVv05xVuKa7H" +
       "WCOs1ayZxzusv3Rzuq6pVM9bzOuBnddIoTpywSvaOu/oSLNGTzNSs2chjKVN" +
       "rOP1l3rKCYuY7sO8NSVyAh/PtHrmtZaxGmCGytnwYjui5UzZDMlV7kZ2BjwZ" +
       "dxOiZmgoh2SiH8WDJTvvZzTfbIwIDllpWrKmeUVBN3JrWG1MDYf1BAPfLjCs" +
       "2WAHaMIF0mynRr2avEDmQ6y9it1ltmCbyDKJWEV0FuHCrrJClBIzB6vFTUPM" +
       "4HotduetSG52GAxbGgPBJ5HFvJ+qTme0Q3tRZAXzTVTvL3FMs7AJiDDLq6Gz" +
       "2Oh6jZC3hT7m4Ayd95M1ErDj3kxu4SqzFuDA8OtSLTHAy6ZkwZ6/sSp6tzGP" +
       "OHRrbQCgjtAWSTDrHZuTc4vs8xvErGho4WPzfDVd7wLfpnb8xq1QG9tyZbfd" +
       "ttqhm9SkYWQblFCboC7JmZK5lsVwPup1NStPMXEuSmhnonFjfDg1BmSVbOrg" +
       "Lfzbi9dz49UdGzxYnpCc3FZaTqPomL+Kk4Hs9hMelBNG0P3yahuFshKdHoyX" +
       "f9cvXn+dPRg/PS2FirOqt93phrI8p/rkh156WR39TOXg6JR5EEFXIz94j6Ml" +
       "mnOG1VXA6Zk7n8mx5QXt6enn73zoLx8Xv8N436u41nn7hXVeZPkp9tNf6H2z" +
       "8sMH0D0nZ6G3XB2fH/Ts+RPQa6EWxaEnnjsHfduJZh8rNPYMeLAjzWK3v1q5" +
       "8yGouHeMC4f4B3uTHh+bvetOV3D7O7ej+/tj6ocL6hRTDlXfPTy6nCtn+cBd" +
       "rgq+ryjeH0EPKaEmR1ovlAPDVLacr2rHfJ+8ZRV6Eh3eQlk68Pd8o6Ots/OX" +
       "Dafu+k1FYxU8gyOlDl6tUt99W6WeFfeH79L3UlH8YAQ9au4P2M0L+ii6P3wq" +
       "6kdeg6hvKBpx8CyORJ29Pv5zzykGfbAo/lm55pL05btI/pNF8WMApFax6ai3" +
       "WPbikWbim+qpHj7xWk3+HvAYR3owXh+T36KHY19+4ra+XF4oFOKWzD5zF039" +
       "YlH83Em4nLuJuGu43EJZ6u5Tr0F3jxaNdfB86Eh3H3gVuit3jXcXxebv70if" +
       "LUk/fxf1/EZR/FoEXSsdqZS5aPnpU4n/+WuQ+OGi8QnwvHAk8QuvT9ScleAL" +
       "d+n7YlH8ywh6Q3Ef55b33qV49Kl4v/0axCsv14pN5cUj8V58fYLhrAj/7i59" +
       "f1AU/yaCHjFkT3W0nua7WhTmJPipa+oFO37ptaJfEzw/dSToT70+drx09GnJ" +
       "USA+c0sgKtvtoebppqcdkoJAlTUqOd4m//wuuvnPRfHHEfTmvW7Oj76gmj95" +
       "rT7QAs+njlTzqdfHB86q5gKc32Meyf/f7yL//yiKv4ygx07kH4d++e3f7d3j" +
       "K69GBxnwudt+VFR8HvHYLd827r/HUz778vX7H315+gfldzUn38xdHUL3r2PH" +
       "OXubfaZ+JQi1tVmKdHV/tx2U/74Otv07JFsRdGVfKdf9N3v6v42gGxfpI+hy" +
       "+f8MXXG/eu2UDrDaV86S3AtMAEiK6uXg2Herd8r8iKMs/+wmvVdWdul8On9i" +
       "i4e+kS3OvAE8dS5vL78+Pc6x4/33p88pn3uZ4d7/tfrP7D8MUhx5tyu43D+E" +
       "7tt/o3SSpz95R27HvK70n/76A79w9V3H7xQP7Bd86uRn1vb223+CQ7lBVH40" +
       "s/u1R3/523725T8tb3j/H7vnjfoWLAAA");
}
