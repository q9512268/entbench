package org.apache.batik.bridge;
public class SVGTextPathElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public SVGTextPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_TEXT_PATH_TAG; }
    public void handleElement(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element e) {
        
    }
    public org.apache.batik.gvt.text.TextPath createTextPath(org.apache.batik.bridge.BridgeContext ctx,
                                                             org.w3c.dom.Element textPathElement) {
        java.lang.String uri =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            textPathElement);
        org.w3c.dom.Element pathElement =
          ctx.
          getReferencedElement(
            textPathElement,
            uri);
        if (pathElement ==
              null ||
              !SVG_NAMESPACE_URI.
              equals(
                pathElement.
                  getNamespaceURI(
                    )) ||
              !pathElement.
              getLocalName(
                ).
              equals(
                SVG_PATH_TAG)) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              textPathElement,
              ERR_URI_BAD_TARGET,
              new java.lang.Object[] { uri });
        }
        java.lang.String s =
          pathElement.
          getAttributeNS(
            null,
            SVG_D_ATTRIBUTE);
        java.awt.Shape pathShape =
          null;
        if (s.
              length(
                ) !=
              0) {
            org.apache.batik.parser.AWTPathProducer app =
              new org.apache.batik.parser.AWTPathProducer(
              );
            app.
              setWindingRule(
                org.apache.batik.bridge.CSSUtilities.
                  convertFillRule(
                    pathElement));
            try {
                org.apache.batik.parser.PathParser pathParser =
                  new org.apache.batik.parser.PathParser(
                  );
                pathParser.
                  setPathHandler(
                    app);
                pathParser.
                  parse(
                    s);
            }
            catch (org.apache.batik.parser.ParseException pEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  pathElement,
                  pEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_D_ATTRIBUTE });
            }
            finally {
                pathShape =
                  app.
                    getShape(
                      );
            }
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              pathElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_D_ATTRIBUTE });
        }
        s =
          pathElement.
            getAttributeNS(
              null,
              SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            java.awt.geom.AffineTransform tr =
              org.apache.batik.bridge.SVGUtilities.
              convertTransform(
                pathElement,
                SVG_TRANSFORM_ATTRIBUTE,
                s,
                ctx);
            pathShape =
              tr.
                createTransformedShape(
                  pathShape);
        }
        org.apache.batik.gvt.text.TextPath textPath =
          new org.apache.batik.gvt.text.TextPath(
          new java.awt.geom.GeneralPath(
            pathShape));
        s =
          textPathElement.
            getAttributeNS(
              null,
              SVG_START_OFFSET_ATTRIBUTE);
        if (s.
              length(
                ) >
              0) {
            float startOffset =
              0;
            int percentIndex =
              s.
              indexOf(
                '%');
            if (percentIndex !=
                  -1) {
                float pathLength =
                  textPath.
                  lengthOfPath(
                    );
                java.lang.String percentString =
                  s.
                  substring(
                    0,
                    percentIndex);
                float startOffsetPercent =
                  0;
                try {
                    startOffsetPercent =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          percentString);
                }
                catch (java.lang.NumberFormatException e) {
                    startOffsetPercent =
                      -1;
                }
                if (startOffsetPercent <
                      0) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      textPathElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_START_OFFSET_ATTRIBUTE,
                      s });
                }
                startOffset =
                  (float)
                    (startOffsetPercent *
                       pathLength /
                       100.0);
            }
            else {
                org.apache.batik.parser.UnitProcessor.Context uctx =
                  org.apache.batik.bridge.UnitProcessor.
                  createContext(
                    ctx,
                    textPathElement);
                startOffset =
                  org.apache.batik.bridge.UnitProcessor.
                    svgOtherLengthToUserSpace(
                      s,
                      SVG_START_OFFSET_ATTRIBUTE,
                      uctx);
            }
            textPath.
              setStartOffset(
                startOffset);
        }
        return textPath;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UzUMzgRL3OjvCmkmQVGgyzD+A97EdT9yFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVae+zrVn33/d3ee9tL23t7C23X0fdtWRv4OXHi2Nllo44d" +
       "x0mc2LET57HBxfEjceJX/I6hG1TbioYE1VY6JkEnTaABKg9NQ5s0MXWaNkCg" +
       "SUxoL2mApkljY0j0j7FpbGPHzu99H6gCaZF84pzz/X7P93U+55WXvwud8T2o" +
       "4DrmZm46wa6WBLtLE90NNq7m77ZZlJc9X1NJU/b9Aai7qjz6uQvf/8Hzi4s7" +
       "0NkpdLds204gB4Zj+4LmO2akqSx04bC2YWqWH0AX2aUcyXAYGCbMGn5whYVe" +
       "d4Q1gC6z+yrAQAUYqADnKsDEIRVgukOzQ4vMOGQ78NfQL0GnWOisq2TqBdAj" +
       "x4W4sidbe2L43AIg4dbstwSMypkTD3r4wPatzdcY/KEC/MJvvePi75+GLkyh" +
       "C4YtZuooQIkAdDKFbrc0a6Z5PqGqmjqF7rI1TRU1z5BNI831nkKXfGNuy0Ho" +
       "aQdOyipDV/PyPg89d7uS2eaFSuB4B+bphmaq+7/O6KY8B7bec2jr1kI6qwcG" +
       "njeAYp4uK9o+yy0rw1YD6KGTHAc2Xu4AAsB6ztKChXPQ1S22DCqgS9vYmbI9" +
       "h8XAM+w5ID3jhKCXALr/hkIzX7uyspLn2tUAuu8kHb9tAlS35Y7IWALoDSfJ" +
       "ckkgSvefiNKR+Hy399YPvMtm7J1cZ1VTzEz/WwHTgyeYBE3XPM1WtC3j7U+x" +
       "L8r3fOF9OxAEiN9wgnhL84fvfvXpNz/4ype2ND99HRputtSU4KrysdmdX3sj" +
       "+WTtdKbGra7jG1nwj1mepz+/13IlccHIu+dAYta4u9/4ivAXk/d8SvvODnS+" +
       "BZ1VHDO0QB7dpTiWa5ia19RszZMDTW1Bt2m2SubtLegceGcNW9vWcrrua0EL" +
       "usXMq846+W/gIh2IyFx0Drwbtu7sv7tysMjfExeCoHPggd4GnjdB288TWRFA" +
       "a3jhWBosK7Jt2A7Me05mfxZQW5XhQPPBuwpaXQeegfxfvaW0i8G+E3ogIWHH" +
       "m8MyyIqFtm2EZ56hzjVYlJoDMJp4oEGGGJod1POG3Sz13P+PTpPMExfjU6dA" +
       "kN54EiJMMLoYx1Q176ryQlhvvPqZq1/ZORgyez4MoCLoeXfb827e8+62590b" +
       "9QydOpV3+PpMg21GgHiuADIAzLz9SfHt7Xe+79HTIBXd+BYQjIwUvjF0k4dY" +
       "0soRUwEJDb3y4fi90i8Xd6Cd4xicaQ2qzmfsfIacBwh5+eTYu57cC899+/uf" +
       "ffEZ53AUHgP1PXC4ljMb3I+e9K/nKJoK4PJQ/FMPy5+/+oVnLu9AtwDEACgZ" +
       "yCCrAQA9eLKPY4P8yj5gZracAQbrjmfJZta0j3Lng4XnxIc1eeDvzN/vAj5+" +
       "XZb1j4HnzXvDIP/OWu92s/L120TJgnbCihyQf050P/q3f/kv5dzd+9h94chs" +
       "KGrBlSN4kQm7kCPDXYc5MPA0DdD9w4f53/zQd5/7hTwBAMVj1+vwclaSACdA" +
       "CIGbf/VL67/75jc+9vWdw6QJwIQZzkxDSQ6MzOqh8zcxEvT2xKE+AG9MMPyy" +
       "rLk8tC1HNXRDnplalqX/feHx0uf/7QMXt3lggpr9NHrzjxZwWP9Tdeg9X3nH" +
       "fzyYizmlZPPdoc8OybYgevehZMLz5E2mR/Lev3rgt78ofxTAMYBA30i1HNWg" +
       "3AdQHjQ4t/+pvNw90VbKiof8o8l/fHwdWZdcVZ7/+vfukL73J6/m2h5f2ByN" +
       "dVd2r2zTKyseToD4e0+OdEb2F4Cu8krvFy+ar/wASJwCiQrAMZ/zAOAkxzJj" +
       "j/rMub//0z+7551fOw3t0NB505FVWs4HGXQbyG7NXwCsSty3Pb0NbnwrKC7m" +
       "pkLXGL9NivvyX6eBgk/eGF/obF1yOETv+y/OnD37j/95jRNyZLnOdHyCfwq/" +
       "/JH7yZ//Ts5/OMQz7geTa0EYrOEOeZFPWf++8+jZP9+Bzk2hi8reAlGSzTAb" +
       "OFOwKPL3V41gEXms/fgCZzubXzmAsDeehJcj3Z4El0PwB+8ZdfZ+/iie/BB8" +
       "ToHnf7Mnc3dWsZ1WL5F7c/vDB5O76yanwGg9g+xiu8WM/225lEfy8nJWvGkb" +
       "puz1Z8Cw9vOVKeDQDVs2846fDkCKmcrlfekSWKmCmFxemlgu5g1gbZ6nU2b9" +
       "7nZ5twW0rERyEduUQG+YPj+7pcpnrjsPhbEOWCm+/5+e/+oHH/smiGkbOhNl" +
       "/gahPNJjL8wWz7/28oceeN0L33p/jlIAovgXGxefzqSyN7M4KxpZQe+ben9m" +
       "qphP+6zsB90cWDQ1t/amqcx7hgXwN9pbGcLPXPrm6iPf/vR21Xcyb08Qa+97" +
       "4dd/uPuBF3aOrLUfu2a5e5Rnu97Olb5jz8Me9MjNesk56H/+7DN//Ilnnttq" +
       "den4yrEBNkaf/uv/+eruh7/15essRW4xnR8jsMHtzzMVv0Xsf7rSRB/FipCM" +
       "dK5c0+F2uUmt7GW7hS5pSquti/aArCetCdK1Bz6MbMaToKLWFdSe2dhypiG1" +
       "sp8Gpl1HOWvoBn1HIEqzuSlV0kK/U613rNgV5pO+3BQZQVpLQ1IYF/tYfw6v" +
       "67jQ9ArykKhv3HBaVsMaP62xSb02QTy7lLb9Ml7D8HJYqCHDaDycSMDsCSWn" +
       "La5YsqgR15holdqiuGlv7AqApySpVmrsUk8XMB6CnCxW6KE2XK1XtaVcXJL0" +
       "wuwbpDtbIcbAMVdDOekki7klIJPNRBQTY2Bx62rPWY3W6mSemJQkijQVrjaT" +
       "fmuAtDZGe7Vx16K4MYlUJo2lzHAjzNApVeBnWH28Ntb0TFxKZjl2ZJIcI1pX" +
       "lGeKqqWd5rrL+PyAa3dMY7FudxazYDO1HXbVG09L3Hrgd1cCzjOlHoK0YpRW" +
       "Ew119DK9cGqRPfTLylLzk+naGiJVozd0/PG0aCmLfilky7WOb06SGjMeSquh" +
       "pzdaw1pfUAW5F3dawqgnJiV0RJZVRWCnkVvEVmipRw/l4cLvJ0LASoIxqffs" +
       "GTVMIkvvDxulAIHNlc9M2bLp2SFTtHjbHE85ZiYkLjxqTeS22aQcB0mwoRGT" +
       "/TU7aLUpUZzWB80QZus9tLGUXIWrLxNajNd+OnVrJb8jrnrFTULETIOt4rGc" +
       "cIIXelVyFQ9maSdpqINeNHY71CaqRq21bdC9pVwJnDVbT+bwqD4XW82eNVx1" +
       "EZazzQbuWn6SSNR8OUN4htgQxLDqbxadWQmmWbPpTLgSGc8dqxXQworCmyu3" +
       "0Sn3iUnLSkpO21XScd2VLaXlNTqSF5mVsN2akuvKBJ0PNwsZTfSlFZLDXrTg" +
       "NuNuoVTRy/YSWTCqSHaIOmY61sqPkGg+NINoZS3bDbNL2I15O5giwhQmWbGg" +
       "k2KrEYcBHq9Y0GcBU3SYC0JpvFDSJj0Smg1fawkcLw7XbKHqlmpciuqJNxVm" +
       "mjGK51U4ZlradEBjLqnaRI8rotRoE8+INKTSqlHFcbieonJC0nWzabqdaEpx" +
       "pCOqrXSxbol4TAlGa+Wu+qpAqcyKX1YKRseb82AvJfAi1253R8BFzpiTVHPg" +
       "wUxpM6zXx11BpCsSJq4wL55ZnRmq4ShB0uP6HJ7V8dJqBS/dab/GJCLt8SvC" +
       "GPmdqaMZglX1k4K6JhWlMqextNNt2s6K0A099HwsIlWjKq0GRN0WUqnfIDae" +
       "KBBJs7GeGG5xsZpxLME1hAHFzAiu1XaCtsIv6nZxycOMs7QtYzZM531CKbql" +
       "gmESi3COrdertBuyYh/TEBgfsrjab8D0soNQG6taL004Ax1TOjeKR5SpyNZw" +
       "SPIEjSEE1mgZBI7G5HReX3tBMakF5MJBdHkTk51kFaMMMRlgYtKRxsVwMTBw" +
       "BlXCsYDUCtpk5mgaiP3cX1XqQ1ST2aXTxltqR10Pg0bdb63NwUqpOZthuhh6" +
       "2LwbjNE52hszG8ar8LPYnZNGSETqstgk+RCut1Q4qOviCKaqfRyOonQYcVWx" +
       "36A5RWovisO0yWrlQgUezhhUqwYhOa4YMK/GgsAJxGhFDegGPSB0pFzo9Z2K" +
       "6+sLGZmyPcFQSt1iVwqsfh9rLazlrNScaUylWm1HNbwuYJtmXS0iGjOTh8oC" +
       "RkYGG6vuaC5xzeYUl/h6DVeUTaXAyxHsbdiwFrSZPqLZVK0ptwqM5xqb6Qrt" +
       "DsRKIymWyD6HlmmEtW0sKRSWFMMUF/4IsetUMEOIYbnemHRmTLlcKlC+HrFw" +
       "UQoomm1JuD0sEdUpzzZxuzoEvbcSmyvrRaIsr/pwPy4x/dp63nDMtUY2RNPo" +
       "w2wP7PNVVk+jWYch530HpxwU0T2fCuBiHGnRstRK9VnYXhNJrxNU0954wFCV" +
       "kamnesA3fCTWQ4kf9+yyTY9jwZ83Yr8z7jaG1bXB+wQ+5DCz5usVrRiWa4ua" +
       "x1lxxBHRkqzxI0Ecp165NFTLDaGkhnivOCqZYwDGGCk4BYJGQgQt1mtrtOZQ" +
       "VsujxmyZndfgQKJVABByu9hc1ilhvZwuCRVbkdPeUqSlcQSHqc0OtchcM3OC" +
       "WLucO2G6BL6RCN5pmxN5TbVtjA10hkO7vYHYK9PCcEqlKVqQpUHVgSclKkQw" +
       "C5iHOhisjMoFbd4A85HcgG24LG5cI+TZCB2DrIrRmsaypkrN2ULkVo2UZsZl" +
       "qzoNUSPoo36v5w6dwdicBPysA6YMHEc2xY7BzUi1h/MlLU0j2B6zeHesR7BM" +
       "RtZyEXrNsrietteubSCjGO1NjOICNsxpwI6YMCyLCYZV7FKgSHiaiiVzRKVe" +
       "0PYxE56bQ73gWwwuFqxlUGRWVhnh8HWExypplmK0KK7whqY3XI7dgBkUUUpc" +
       "r9QUk3VjbWx6o8moWrWXchPmW9XmlBnHM75XRBqeO24HXanfFu013R5IsW3h" +
       "0rjZNudp36QDcuWkY4Vdd+nlcs6SQj1ueVGXM3BuQmml+aBRouDYxsdSJ1ky" +
       "hVrBoci01iVTBJs6tUIRc2rC0MbpeuQU5pPaDBl6DdMwKGwaSi0PGYtdLFz5" +
       "ncSObbmUsNpo1B0FUQutGZ1OtUeIjBgmboNaYZJnz6yV01yFZFEfhK2UUuEu" +
       "P+4u8AIb85LeHqck2k3JClpopJtqq1Wflb1RiZYSLGIYxq64QUC3sFqdr5A4" +
       "v5nxSiyWfLpQ6XujaaIXRnBHihBmxdWbvm8ghaRL6qwPwzU+St0Kh0xjtC9R" +
       "1aCDtVhX5OEu2q9ssBlVRKKlo+uIIwnrqu/2J1Gt45G0UpuYkkNRvGVZnaox" +
       "Gsw5TgmDsC6VfaFJ84NKA2ku520BIPIUKasSZVUJV3FrZpiOaDDsG7RqVSdj" +
       "GuTLKOmr8KYYcTA7QmhnXZrSU4mXB3ZbqXfijdBeqIHaKXVq8RjXnKpREnpC" +
       "nRenWkg0eTIyI4K3K6horStsTQtHNZFmWLPflir4xMWNamvTaDYjNE6ZKop7" +
       "Qp/BeuKI6ohRk+u1JHIc23Z7yNJNtaobS48PS33c5PCe6GMTvlrfNMzmSG+2" +
       "OySqjpdxUefYpq4UOpZpirgaK0WsZRlrt1GYorxMB6xs94qSgCmKHBWSqRcM" +
       "on7J6CNYZUYJ85JYmRFKd+GsepHDilV/OTY13Mdm5U3i2h25SBQXpQZBpEWt" +
       "Zm+0hoobDun1+t6kxvDSiJxi/JJNR1jfruGaMdPLeLnY3Xgdsh+uEMRLJwsW" +
       "rRZwuujLSdCrSxTX6jh1RWxWxIUw8DYYL3faTctRq15qeR1cjKcm0eyQA8RD" +
       "Z7hZGnSJCTqjwqbqL2ozU6tZKlnpJBbVYbEq3Z90K30fVV20aGtS3F5RShez" +
       "LF4f0XJM+lWrUGjBgyWG1ObzxqjLNCN1vfaasTEulip8aYSiw+FSxkSlxa03" +
       "GjNodZupQS1n8TAddtO5wJa5ZURaK6svNeeblCoQNQys/WobOkNBsDV5+2vb" +
       "Hd6Vb4QPLj3ApjBrYF7Drmjb9EhWPH5weJZ/zu4fkO9/Hz08OzxRObW/6X7i" +
       "RkfDDc9zvIMbrmxj+MCNrj7yTeHHnn3hJZX7eGln7+BqHEC3BY77FlOLNPPE" +
       "Wc5TN94Ad/Obn8MDlS8++6/3D35+8c7XcEz80Ak9T4r8ZPflLzefUH5jBzp9" +
       "cLxyzZ3UcaYrxw9VzntaEHr24NjRygMHgbiU+f1B8JT2AlG6/lHtdZPmVJ40" +
       "21S5yblgeJO2OCvAXvv2uRawjiKbvT3VmcPsWv+oPfdRoXmFdfwo+gp40D37" +
       "0J+MfTs5wc5+aj5+o9Tc3lHsXXzuU9+dUcdlZVd1rN29y4y8l/fexFPPZcW7" +
       "A+iOhWyrprbHlpOKR8bgKIBuiRxDPXTfMz+G+16fVT4Knvqe++o/UfdlP5/N" +
       "il/JqV64ifkvZsUHA+hOxdPkQNu/Ctp36aPXBGAegUGVjdljpLlHnn8tHkkC" +
       "6L4b3T1lB+n3XXMXvr2/VT7z0oVb731p+Df59cvBHettLHSrHprm0XPPI+9n" +
       "XU/Tjdzi27anoG7+9TsBdO8NciyAzm5fctVf2tL/bgBdPEkfQGfy76N0Hw+g" +
       "84d0QNT25SjJJwLoNCDJXj/p7vsbuVHCE7ZhyUF2MZGfyRoK8N3WWcmpI9C6" +
       "l2l5OC79qHAcsBy9v8lCm/9bYR86w+3/Fa4qn32p3XvXq9WPb++PFFNO00zK" +
       "rSx0bnuVdQC/j9xQ2r6ss8yTP7jzc7c9vj9V3LlV+DDrj+j20PUvaxqWG+TX" +
       "K+kf3fsHb/29l76Rn9j+HzDEGWtGIgAA");
}
