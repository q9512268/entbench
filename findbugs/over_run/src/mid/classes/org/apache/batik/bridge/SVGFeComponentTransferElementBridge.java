package org.apache.batik.bridge;
public class SVGFeComponentTransferElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeComponentTransferElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COMPONENT_TRANSFER_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcR =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcG =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcB =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcA =
          null;
        for (org.w3c.dom.Node n =
               filterElement.
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
                  !(bridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge)) {
                continue;
            }
            org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge funcBridge =
              (org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge)
                bridge;
            org.apache.batik.ext.awt.image.ComponentTransferFunction func =
              funcBridge.
              createComponentTransferFunction(
                filterElement,
                e);
            if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncRElementBridge) {
                funcR =
                  func;
            }
            else
                if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncGElementBridge) {
                    funcG =
                      func;
                }
                else
                    if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncBElementBridge) {
                        funcB =
                          func;
                    }
                    else
                        if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncAElementBridge) {
                            funcA =
                              func;
                        }
        }
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.ComponentTransferRable8Bit(
          in,
          funcA,
          funcR,
          funcG,
          funcB);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    public static class SVGFeFuncAElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncAElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_A_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeFuncRElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncRElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_R_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeFuncGElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncGElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_G_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMU5a6zjaHWeOzuzs8OyMzvA7nbLvgfa3dDrvBzHHR6b2I6T" +
           "2Emc2E7itDD4HcfP2I5jB5bHSsC2SBS1C6US7C9QW7Q8VBW1UkW1bdUCYlWJ" +
           "CvUlFVBVqbQUif1RWpW29LNz7829d2aWIio1kp3P33fO+c7b5zt+/rvQuTCA" +
           "Cr5np4btRftaEu0vbGQ/Sn0t3O8yCCsFoabithSGPJi7rjz6+Uvf/8GH55f3" +
           "oPMz6FWS63qRFJmeG4600LNjTWWgS7tZ0tacMIIuMwspluBVZNowY4bRNQZ6" +
           "xTHUCLrKHLIAAxZgwAKcswA3dlAA6ZWau3LwDENyo3AJvQs6w0DnfSVjL4Ie" +
           "OUnElwLJOSDD5hIAChey5zEQKkdOAujhI9m3Mt8g8EcK8LO//rbLv3MWujSD" +
           "Lpkul7GjACYisMkMutPRHFkLwoaqauoMutvVNJXTAlOyzU3O9wy6EpqGK0Wr" +
           "QDtSUja58rUg33OnuTuVTLZgpURecCSebmq2evh0TrclA8h6z07WrYStbB4I" +
           "eNEEjAW6pGiHKLdZpqtG0EOnMY5kvEoDAIB6u6NFc+9oq9tcCUxAV7a2syXX" +
           "gLkoMF0DgJ7zVmCXCLr/lkQzXfuSYkmGdj2C7jsNx26XANQduSIylAh6zWmw" +
           "nBKw0v2nrHTMPt/tv/FD73Db7l7Os6opdsb/BYD04CmkkaZrgeYq2hbxzieY" +
           "j0r3fPGZPQgCwK85BbyF+b13vvTkGx584ctbmJ++CcxAXmhKdF35pHzX116L" +
           "P46dzdi44HuhmRn/hOS5+7MHK9cSH0TePUcUs8X9w8UXRn8mvufT2nf2oIsd" +
           "6Lzi2SsH+NHdiuf4pq0FlOZqgRRpage6Q3NVPF/vQLeDMWO62nZ2oOuhFnWg" +
           "2+x86ryXPwMV6YBEpqLbwdh0de9w7EvRPB8nPgRBV8AF3QuuP4a2v/w/gt4J" +
           "zz1HgyVFck3Xg9nAy+TPDOqqEhxpIRirYNX3YBn4v/VzpX0UDr1VABwS9gID" +
           "loBXzLXtIiwHpmpoMDemWhoOpPNczY34QHJDYKoseYDHZg6zn3mh//+8f5Lp" +
           "5/L6zBlguteeThw2iLm2Z6tacF15dtUkX/rs9a/uHQXSgWYjiANM7G+Z2M+Z" +
           "2N8ysf+/YOJqDtNauQp1Yh46cybn6dUZk1tXAo5ggZQCku2dj3Nv7b79mUfP" +
           "Ah/217cBK2ag8K1zPr5LQp081SogEqAXPrZ+7/jdxT1o72TyzgQDUxczdDZL" +
           "uUep9erpoL0Z3Usf+Pb3P/fRp7xd+J54GxxklRsxs6zw6GkTBJ6iqSDP7sg/" +
           "8bD0hetffOrqHnQbSDUgvUYSCAeQuR48vceJ7HDtMNNmspwDAute4Eh2tnSY" +
           "Hi9G88Bb72Zy37grH98NdHwpC5fXg+tLB/GT/2err/Kz+6u3vpQZ7ZQUeSZ/" +
           "E+d/4q///J8quboPk/6lY69RTouuHUs0GbFLeUq5e+cDfKBpAO7vPsb+2ke+" +
           "+4FfyB0AQDx2sw2vZvfM+4AJgZrf9+Xl33zzG5/8+t7OaSLwpl3JtqkkR0Je" +
           "yGS662WEBLu9fscPSFQ2CNbMa64KruOppm5Ksq1lXvqfl15X+sK/fOjy1g9s" +
           "MHPoRm/40QR28z/VhN7z1bf924M5mTNK9qLc6WwHts2+r9pRbgSBlGZ8JO/9" +
           "iwd+40vSJ0AeB7kzNDdang6hXAdQbjQ4l/+J/L5/aq2U3R4Kjzv/yfg6VtBc" +
           "Vz789e+9cvy9P3wp5/ZkRXTc1j3Jv7Z1r+z2cALI33s60ttSOAdw1Rf6v3jZ" +
           "fuEHgOIMUFRA1gsHAchJyQnPOIA+d/vf/tGf3PP2r52F9lrQRduT1JaUBxl0" +
           "B/BuLZyDdJb4b3lya9x1Zu7LuajQDcJvneK+/OksYPDxW+eXVlbQ7EL0vv8Y" +
           "2PLTf//vNyghzyw3eY+fwp/Bz3/8fvzN38nxdyGeYT+Y3JinQfG3wy1/2vnX" +
           "vUfP/+kedPsMuqwcVJZjyV5lgTMD1VR4WG6C6vPE+snKaFsGXDtKYa89nV6O" +
           "bXs6uezeD2CcQWfji8fzyQ/B7wy4/ju7MnVnE9v38RX8oCh4+Kgq8P3kDIjW" +
           "c+V9dL+Y4b8lp/JIfr+a3X5ma6Zs+LMgrMO8pAUYuulKdr7xkxFwMVu5ekh9" +
           "DEpcYJOrCxvNybwGFPW5O2XS72/rwm1Cy+7lnMTWJZBbus/Pb6HyN9ddO2KM" +
           "B0rMD/7Dh1/8lce+CWzahc7Fmb6BKY/t2F9lVff7n//IA6949lsfzLMUSFHs" +
           "R8nLT2ZUmZeTOLuR2a11KOr9mahcXiQwUhj18sSiqbm0L+vKbGA6IP/GByUl" +
           "/NSVb1of//ZntuXiab89Baw98+wv/3D/Q8/uHSvSH7uhTj6Osy3Uc6ZfeaDh" +
           "AHrk5XbJMVr/+Lmn/uC3nvrAlqsrJ0tOEpyoPvOX//Xi/se+9ZWbVCu32d5P" +
           "YNjoFXa7GnYah7/eWJQnayFJHG2ArdroyNRlsdvvjOZrwhwqir0SCIyTbA9n" +
           "1toodMubtmCV5Tq2WVX6FTNWS3M1kXR33MR9QvTYWsezuqPJOiiAgVg0JZ9C" +
           "Z3UjQsa05zepIsP358iyXPOxQkcUYG80xTRHddDKLEarNUtajqVVUMacqa5p" +
           "fAGc3JCKPiAlyW2FfRJPlhppTWo8yUkyAvxPJiKKIrR1tbjBJWEG1yuaxfcr" +
           "qKYuaFoMBl5YxdXeSEBn5NCdr+Se55VrNb4ZLsPhrFvkFzTWKSviHCMIVu05" +
           "+mgSFWfMuEuMK0J55jgkXk+MQXVS600GZdcVZpQuCD1m6HelZDQnpnQlIBpC" +
           "wy8tmzMVa2phUPLW7e5iEVpjmK1q8yAajvTGOmCiXr8rCahMzy0PXXkzbuMQ" +
           "YmhzomUvkkVFE8mqzSzjrrEmgvoQjmO76AkrUhwWy7wYdltIqVu1F1RPom2h" +
           "v9Yrk8LQc3uCPiyWfLUZNSYURS7d1Dd8IBvuzKYYRsvNQp9vq9WgYVeols3z" +
           "1FLxemLZpqM51ZFbm2JJmpAbiZrb7goze1MTXWndaKAW5y2kgHEbd7MRNTSO" +
           "NLIa9LzAj/hKcz1eUPg65dak3eQ2SVsuS/NgNLOpCj509E4gDYhppZtWJNYr" +
           "qP1NK20MCSvU+7idNGdoIaBwvtONo2WYprVa1U4GRt2tlZBGqjRLGKqPC/Y8" +
           "7dfbzSQs1cn1oKo0NazGIa6rlhrcYGmrgk6u63iDXqutySjsdMdlKZglBN7Q" +
           "zBFJUBvH5qyGi1jt4khkOpTBBMR4mDr9fsgv2XrKE0VmuZ62/IEx5mS8MdLX" +
           "ESGF3cWwCeqtdt3nOgQ8TVwFxsQ5UuykJt43Q1KdGlhUp0zYJ8x01l1EBrnx" +
           "WkqZoETNQCuxKy7NeaMTrItdDrF0th1gxqiC0TWMcYal0gyX0lF1QfdWASIP" +
           "tPGgKlX0Wq3rYC2aEXQ3leB02k3TiFA2Y5pp9JnieDFdp5MZojj6xrcTDLX0" +
           "NWJGflsQ0hLBKJ3BwJ8EHDMmJh29g0tJj2MlmvIW/kIMAQsj2p2zNU4aeckA" +
           "cUlWBGvlpEX0yKA+HxH2cC2wArEq1ByZpdGE2xiuEQviaEhUkmG7khQWA04v" +
           "ULInSGOjJTr4eLJZ+suJJYsxukl6y0FHqdZptMkwE4EZNGF4VVPTcZkWUavc" +
           "aNEJyqRAvUKrY2rjgC4FmtTtbUZrsaOwhjsROKtYkcvtoTGerVfVgVLozFiL" +
           "pnkYgUsMSyBBy+yMuH5RFbXOutpbq1Ej7ZebbmnBRDEMT6Y9B6MFliYQcjLx" +
           "OGvdMZ0+1/AWVkR3EFoBzy1rZCc8O26UFoCWqLJRhTS63SGBs60GrbSDNrZ0" +
           "4rbvoX21QVK0yGxmzRYTLCM/FPsFLOGZuTHDFHqcjqI4xqYFcT5qGbNaKgzY" +
           "+tAfePSCS/loOeEWI2NlibZfTFFu1TMFTBlE7W65qvE9U6nTgypdMtIobKjB" +
           "IsUGSp2L5G6PVgQBi+GOBevsJlXqSuRuykvTppB5JIUIPSyS5KxRZp3eIDBm" +
           "MeIj6NQwTX/ZrImESokyj/f4WRurLUw/pVKLZ/WJ1ZpXBpOpMqTcdLlRNmFQ" +
           "7ks4m9JGmatoclUREtj2K0NJ5zA0aalYPfL1dIYUyF6o9tJGNOKY6nqkFLAC" +
           "2oMrJotPpSpSF/BNj5yKQodwV0xHW08WKmtwrix0G2ikusWapse6TIoiCVuM" +
           "ual4Yhde8cY8GeEOAxcKUbuix+y8MNVM1hFnrbZXwTclfql1LRrW/HoyGyj+" +
           "BsWMJkuFjXGbmHTnxaThz1BeUUUD7hJ1VkZKSC2CNclnqiHesHi6p7pp2nDh" +
           "eg+Oh2K5XtDpvr7sOF5MomhPZ1td1onr/DSOJuV6Oih6rpzW6uPVtE5YXqdI" +
           "qIsAIZvNcEEOe5blSnG9VR9tKhGuwPpmVO90jQCu6Y1pbSluahgR6sEMRWqD" +
           "bkmclErDRO5hI9MZJl0NZqhScxCga2u0IYmwZTFRZaavg6ki07zaqOKJP+60" +
           "Su7amNFMS5ivkf5qok8LiwrKDSqajQvjtsBEc3FSJM3igCobhJrgVsNBZPC2" +
           "Vy1lrlZXwYpc1haUNkJZXhc2kYx1HHERFQ0YjQMYnWsC25QMy1zMqml9wsoa" +
           "jbg8VjZZ0tPRomwMslN4ve3aC6HN1QZDrTmmZX2UWDJmFkxss8AKMxsUce2a" +
           "ixLd2tJd4bBKpHqsTWHUVFg2lvuFpWAhi6kOe7LiyroQsiuxRlfqiO2XMEHm" +
           "R/V6WKst7MhE/LhKRURFdBiZoEpJDSbhwEcx0WFDlmpHPE36c1utz1YwQRmT" +
           "yrJXao9ca5kGjh0sE6Xf1HotB/PIgovzq/q4PTYikSjxaTmMN/0hrqclRGMw" +
           "1eVFcgLPzRCRuhRXxhJpqcY9XifaSa+natxck/uC3EmJfrGbtscbvTnoIhJS" +
           "EwLZEcvgFSqJ7mRTKdSK9V4b84dizQG+1B1W2qwXO3OtgchLKUWkeoc2YkZR" +
           "5QIi6gV/4lmI4MRGb8n3qqUF2cCNutMTZrGlNimbCG123E7mIPKb7jQrDBBC" +
           "KXU0xlJVcepQk3BUEXCUFZgwbtYCiysRFk72+51eV0fKFhCFha1qLZYCQ1hK" +
           "QmzpUslF+HIDd9XJdCIm0wmis01Fm7QHS7wetxMfBqUvtqlHVANHJa4YmxpQ" +
           "6kh1+HEDjW1PltLAN5uorqPt1JYnsWBUpEq/b8DCPMRX/ToxIkVkWauzY8Fy" +
           "Bc6ZoKD00nUqElAqGHZWbWHIc/Fqtq4ynaVcng0lu2TY4cDv4D0KXlkmHs+H" +
           "hQLsVmI0KCCkJoy8OrEqwyVx2dPiwGwWLMVXCwMvmI1KjU7IWyA/sVE5DkYe" +
           "P2dKVJNLxpEuLFDfauFoOZQ2tuNPZJVT2oOB7I4FnsILi2VqzuNuE5SKjLUp" +
           "lZ2VN/FWZDvUS2m1wwijCrOcNssjGgamSnCX3oBaVefdzaIytKpGa0I10Umk" +
           "REk45x2iVdF0LgitNlxlYJNZFzgdrnf5tDG1YbTplpmAkmlUFTkrSkEVDyoo" +
           "VrCqlfoQ5B/Bag261alZhZPEC4c21fF6QuzHvDDBSJTkQXX9pqzsfuuPd/K5" +
           "Oz/kHX0JAAeebKH9Y1T8yc033NttuOsX5a2Cu083lY/3i3ZNBCg73Dxwq75/" +
           "frD55NPPPqcOPlXaO2i+TMFZ9uBzzI5Odrp84tYnuF7+zWPXEfjS0/98P//m" +
           "+dt/jD7nQ6eYPE3yt3vPf4V6vfKre9DZo/7ADV9jTiJdO9kVuBho0Spw+RO9" +
           "gQeO1HpPpq5HwfXigVpfvHmv8aaGOpMbausPL9PYil5mLc5uXgTdaWgR4ymS" +
           "3T9gvb1zIf9HHRpPNJMi6N5btLoPuw/XfoI2OvCI+2747Lf9VKV89rlLF+59" +
           "TvirvGF89DnpDga6oK9s+3in5tj4vB9oupnr4o5t38bP/94N5LgFn8BV5Z1A" +
           "79rCPx1Bl0/DR9C5/P843Psi6OIODpDaDo6DPBNBZwFINvwl/1Bpo/+Tbw8n" +
           "ppMzJ2P2yOBXfpTBj4X5YyfiM/9wexhLq+2n2+vK557r9t/xUu1T2464Ykub" +
           "TUblAgPdvm3OH8XjI7ekdkjrfPvxH9z1+Tted5g47toyvIuSY7w9dPP2M+n4" +
           "Ud4w3vz+vb/7xt987ht5D+p/AP4Qg/JRHwAA");
    }
    public static class SVGFeFuncBElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncBElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_B_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected abstract static class SVGFeFuncElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge {
        protected SVGFeFuncElementBridge() {
            super(
              );
        }
        public org.apache.batik.ext.awt.image.ComponentTransferFunction createComponentTransferFunction(org.w3c.dom.Element filterElement,
                                                                                                        org.w3c.dom.Element funcElement) {
            int type =
              convertType(
                funcElement,
                ctx);
            switch (type) {
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       DISCRETE:
                    {
                        float[] v =
                          convertTableValues(
                            funcElement,
                            ctx);
                        if (v ==
                              null) {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getIdentityTransfer(
                                );
                        }
                        else {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getDiscreteTransfer(
                                v);
                        }
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       IDENTITY:
                    {
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getIdentityTransfer(
                            );
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       GAMMA:
                    {
                        float amplitude =
                          convertNumber(
                            funcElement,
                            SVG_AMPLITUDE_ATTRIBUTE,
                            1,
                            ctx);
                        float exponent =
                          convertNumber(
                            funcElement,
                            SVG_EXPONENT_ATTRIBUTE,
                            1,
                            ctx);
                        float offset =
                          convertNumber(
                            funcElement,
                            SVG_OFFSET_ATTRIBUTE,
                            0,
                            ctx);
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getGammaTransfer(
                            amplitude,
                            exponent,
                            offset);
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       LINEAR:
                    {
                        float slope =
                          convertNumber(
                            funcElement,
                            SVG_SLOPE_ATTRIBUTE,
                            1,
                            ctx);
                        float intercept =
                          convertNumber(
                            funcElement,
                            SVG_INTERCEPT_ATTRIBUTE,
                            0,
                            ctx);
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getLinearTransfer(
                            slope,
                            intercept);
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       TABLE:
                    {
                        float[] v =
                          convertTableValues(
                            funcElement,
                            ctx);
                        if (v ==
                              null) {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getIdentityTransfer(
                                );
                        }
                        else {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getTableTransfer(
                                v);
                        }
                    }
                default:
                    throw new java.lang.Error(
                      "invalid convertType:" +
                      type);
            }
        }
        protected static float[] convertTableValues(org.w3c.dom.Element e,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
            java.lang.String s =
              e.
              getAttributeNS(
                null,
                SVG_TABLE_VALUES_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                return null;
            }
            java.util.StringTokenizer tokens =
              new java.util.StringTokenizer(
              s,
              " ,");
            float[] v =
              new float[tokens.
                          countTokens(
                            )];
            try {
                for (int i =
                       0;
                     tokens.
                       hasMoreTokens(
                         );
                     ++i) {
                    v[i] =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          tokens.
                            nextToken(
                              ));
                }
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_TABLE_VALUES_ATTRIBUTE,
                  s });
            }
            return v;
        }
        protected static int convertType(org.w3c.dom.Element e,
                                         org.apache.batik.bridge.BridgeContext ctx) {
            java.lang.String s =
              e.
              getAttributeNS(
                null,
                SVG_TYPE_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_MISSING,
                  new java.lang.Object[] { SVG_TYPE_ATTRIBUTE });
            }
            if (SVG_DISCRETE_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         DISCRETE;
            }
            if (SVG_IDENTITY_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         IDENTITY;
            }
            if (SVG_GAMMA_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         GAMMA;
            }
            if (SVG_LINEAR_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         LINEAR;
            }
            if (SVG_TABLE_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         TABLE;
            }
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
              s });
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVZe5AUxRnv3Tv2HjzugRzkkAPuDhIQd4OgJDmjwsFxh3tw" +
           "4ZAkR+IxO9t7NzA7M8z0cssJ4VExUP5BWYKGJHCpJJhECsE8rDyMSB4+KKKW" +
           "xIoiiUStihq0Cv5ATEhivq97ZuexD7S0zFVNz2z3119/r/59X/cdfpuMskzS" +
           "bEhaUoqyTQa1oj343SOZFk22q5JlrYLefvmuV/ZsvfSnqu1hEukj4wYlq1uW" +
           "LNqhUDVp9ZEpimYxSZOptZzSJM7oMalFzY0SU3Stj0xQrK60oSqywrr1JEWC" +
           "1ZIZJ3USY6aSyDDaZTNgZGqcSxPj0sQWBgna4mSMrBub3AmNvgntnjGkTbvr" +
           "WYzUxtdJG6VYhilqLK5YrC1rkmsMXd00oOosSrMsuk693jbEsvj1eWZofqjm" +
           "nct3D9ZyM4yXNE1nXEVrJbV0dSNNxkmN27tEpWlrA/kaKYuT0R5iRlrjzqIx" +
           "WDQGizr6ulQg/ViqZdLtOleHOZwihowCMTLdz8SQTClts+nhMgOHSmbrzieD" +
           "ttNy2jruDqh47zWxvd+8vfanZaSmj9QoWi+KI4MQDBbpA4PSdIKa1sJkkib7" +
           "SJ0GDu+lpiKpyrDt7XpLGdAkloEQcMyCnRmDmnxN11bgSdDNzMhMN3PqpXhQ" +
           "2b9GpVRpAHRtcHUVGnZgPyhYrYBgZkqC2LOnlK9XtCSPI/+MnI6ttwIBTK1I" +
           "Uzao55Yq1yToIPUiRFRJG4j1QvBpA0A6SocQNHmsFWGKtjYkeb00QPsZmRSk" +
           "6xFDQFXFDYFTGJkQJOOcwEuNAS95/PP28ht336F1amESApmTVFZR/tEwqSkw" +
           "aSVNUZPCPhATx8yO3yc1PLorTAgQTwgQC5pfbL5wy5ym408JmskFaFYk1lGZ" +
           "9csHE+Oeu7p91mfLUIxKQ7cUdL5Pc77LeuyRtqwBSNOQ44iDUWfw+Monvrzt" +
           "ED0XJtVdJCLraiYNcVQn62lDUam5lGrUlBhNdpEqqiXb+XgXqYDvuKJR0bsi" +
           "lbIo6yLlKu+K6Pw3mCgFLNBE1fCtaCnd+TYkNsi/swYhpAke0gLP34n4429G" +
           "NscG9TSNSbKkKZoe6zF11B8dyjGHWvCdhFFDjyUg/tdfOze6IGbpGRMCMqab" +
           "AzEJomKQisFYwlSSAzTWu3ppB20H7XSNamyVKWkWuArhAn4u4jRRjELj/7x+" +
           "Fu0zfigUAtddHQQOFfZcp64mqdkv780sWnLhSP9JEZS4kWzLMrIShIgKIaJc" +
           "iKgQIvo+hGjlNB0ZTfZ1k1CIi3QVyigiCeJgPSAKQPqYWb1fXbZ2V3MZhLAx" +
           "VA5ORNKZeSmu3YUeJ1/0y4efW3np2aerD4VJGNApASnOzTOtvjwj0qSpyzQJ" +
           "QFcs4zioGyueYwrKQY7vG9q+euunuRze1IEMRwHq4fQeBPzcEq1ByCjEt2bn" +
           "G+8cvW+L7oKHLxc5KTRvJmJSczAAgsr3y7OnSQ/3P7qlNUzKAegA3JkEmxFw" +
           "sym4hg+b2hycR10qQeGUbqYlFYcccK5mg6Y+5PbwyKzj31eBi+txs34Knrfs" +
           "3cvfONpgYDtRRDLGTEALnkc+32scePGZN+dxczspp8ZTK/RS1uaBOWRWzwGt" +
           "zg3BVSalQPfXfT177n175xoef0DRUmjBVmwx9sGFYOY7n9pw+uzLB58PuzHL" +
           "SJVh6gz2Ok1mc3pWolp1JfTEUHdFAqRUgQMGTuttGgSmklKkhEpxn/y7Zsbc" +
           "h9/aXStCQYUeJ5LmXJmB2/+JRWTbydsvNXE2IRkztWs2l0zA/3iX80LTlDah" +
           "HNntp6Z860npACQSAG9LGaYcjwk3A+F+m8/1j/F2XmDsBmxaLW/8+7eYp6Lq" +
           "l+9+/vzY1eePXeDS+ksyr7u7JaNNRBg2M7LAfmIQazolaxDo5h9f/pVa9fhl" +
           "4NgHHGWAXWuFCaCY9QWHTT2q4qXf/r5h7XNlJNxBqlVdSnZIfJ+RKghwag0C" +
           "nmaNm28Rzh1Cd9dyVUme8mjPqYU9tSRtMG7b4V9O/PmNPxp5mceViKLJ9nT+" +
           "YyZvZ2Ezh/eX4ee1jFRKCYAAEI2RiMULQDcG+fwpwUzpjUHfOiaZUqyY4YXY" +
           "wR17R5Ir7p8rSo56f4GwBOrfB//8nz9G9/3tRIHcErGLUXfBMlhveh7Wd/NC" +
           "z8WpBaculZ25Z9KYfJhHTk1FQHx2cRAPLvDkjn80rrppcO0HwO+pASsFWT7Q" +
           "ffjE0pnyPWFeqwrozqtx/ZPavPaCRU0KRbmGamHPWB7hzTm/zkJ/dcJz0fbr" +
           "xcIYWjBwAK8iRiahegOFg9W4EgwD2zrMOYX570mMjMfCYWieHE3q6aid/3Ho" +
           "S1yOL5bAhDXY9IB5ZJNC2ZhXY2BBkfMGrPSZvBIFHSwNsaiShqI9WprBAmy+" +
           "INT+3PvbuthxM++O56zVjEPzwZLzBAfxfp/mD/N9i83igP0nleBY2P7cxo5p" +
           "ZhSr3kQlZh8LuWiDJTzCzygJOFxBTbARCoJVmERWS2oG0BLPpJ4NixcEvRmA" +
           "H54hxLHkV+Pf/NmJtRWnBUa0FiQPnHZevePk9/W/nAs7J5lCUwTlrVb3s7/u" +
           "fL2f79VKBIPcDvEAwUJzwFN51OaM3Ig6ToXnk3aQ8zcj9COt24FJGrOpbi6E" +
           "Lw4lzgHh41kIcXxGcfzz+Grkhy3PbB1peYUnxErFAgQF2xU403rmnD989typ" +
           "sVOO8LqxHF1gm99/GZB/1vcd4blnarAxs1axMOkxlTTUcBvtMDnacGnDHyqG" +
           "F4ftQDWEY9+DvxA8/8UHHYodwrH17fapdFruWGoYuN6sEvdI/kVjW+rPrt//" +
           "xoMiNoPH9gAx3bX3rveiu/eK9CfuNlryrhe8c8T9hohTbIazPCmWWIXP6Hj9" +
           "6JZHfrxlp2OKToalsC6x3I4O5Y5TDUHbClkjcw/8c+s3XlwBfuwilRlN2ZCh" +
           "XUl/FqqwMgnPBnOvQ9ycZEuNNmckNNuwSxe/CNPysjy/jXQT5ltnvvPaY5d+" +
           "UCGsXMI7gXmT/rVCTex49d28GpHn7gIOC8zvix3e39h+0zk+3z0E4eyWbP45" +
           "GvaHO/e6Q+mL4ebI42FS0UdqZfvmjwMlHC36YAdYznVgnIz1jftvrsQ1TVuu" +
           "Urg6GDGeZYPHL6+3ypnPM3Vid4UITyC7SySjVRg9iiapfN4wlAcq1QaYSBKb" +
           "7bDE1zZGyhSR2Yc8jg4WA7zSRdWgfIRcjPnDGRPXAIoezd1DwmB+yPB0K+Tn" +
           "iwnhsenl4pRIX98tMfY9bPaDtjLKJdQoQX5QJH9PVWDLhz/vzLoVhfyhKwqs" +
           "0fFQHOq283/3R1ZRFONYoqLARuErHi1hnp9g8wAjo51CwTnxizDi7Z4rme7Q" +
           "BzddFg6uhS+bnChr+xD3WABXk/Lu3cVdsXxkpKZy4shtL4jc59znjoFSJJVR" +
           "Ve9W9HxHDJOmhDXHiI1p8NdvGJlYRE7YgQlXoUcE/WOM1AbpIZT520v3O0aq" +
           "XTpgJT68JI/DPgYS/HzCcIx2XTGjieoCNyrPoooMVhS2yobyz6ncqxOu5FXP" +
           "kbPFh/b8PyNOssqI/41A6h9ZtvyOCzfcLy59ZFUaHkYuoyFFifun3NFselFu" +
           "Dq9I56zL4x6qmuHkzjohsLu/Jnti/GYIWQOP742B6xCrNXcrcvrgjcee3hU5" +
           "BUlkDQlJAIBr8tE9a2Tg3LgmXigZA77zm5q26tfWPvvuS6F6fgdg586mUjP6" +
           "5T3HzvSkDOPbYVLVRUZBaUCzPPUs3qStpPJG05fbIwk9o+VKtHEYwBL+14Rb" +
           "xjbo2FwvXhoy0pxfv+RfpFar+hA1FyF3u1bwHWYzhuEd5Zb9ugAJUaiV9ce7" +
           "DcMu3EIvcMsbBt/upzli/A+e5UKU/hwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "sCYEbSRYOeFooZbL3tgLuWAUxqs6hi7lbrhZItpc9PT10nGVCO1g4nZU3S7o" +
           "LuIuurOAlGdllaPpdOXQlUbU9ed2gMMraSjEfJmtWawdLLP1IJ13Jj0rC+qx" +
           "PTHgmbUWVSoa21p/LCaW6SXtEU+pWZOb8G07CkuuOTLGfc6Rg8zSOlFEbyvL" +
           "IO6szWojm6cbtdTc6JIrSpyzxCbe3CoNB9XRpNOSfbzKcOpgKCEhuVpZcoMj" +
           "y71OXLJ9a+hvg07UWPhUT8VXttedKKNt22WdjuOmNILIBqd26GxkjmiUWfsL" +
           "c1KRsZ4/Y328z0ZKfzrruaLBbE0hEFqGuFq3K9TYtYfYImpzzAAujdxBPYqS" +
           "QYsfIoNpJnm1mrBGtrw3YKYWS7Bkr7pEJpuWj5fxOucpE7rvhMS8N4yWwkqT" +
           "y+UJE4oOy63qKdGZEAuiIxB8j1xNyPFYSboxjXNYDWaYStOMULROIJLT5XDf" +
           "4WeEyMJRN1lzq0TiZvRUZNqMifNpcztGtwrCUF7A48aET4xJu+brMlVLtrWt" +
           "Uy03SSdcERIhrBC7J2JK2O+Wxlrc8DHE0anpIB1OGspUBQCmNBqUFm/ZaJ20" +
           "OHo8qVatznSuJ6WR526CLOp2ygsymqlkmwokS6CV2cStV+zOVHJqdi+Y2i2T" +
           "Vv3uem0t5NLCWKyFziYekmxZDi1bHnj1LWUP49KwziSo0zYIim51Eb0dSW1X" +
           "LfHCig4tOEwE08dXWtmgGLTqVqsVrEeHSg/jOZqTh6uh6Gn1jECQVlPdLnv9" +
           "+aatmgTRWW6nBhyp+jjT6oOe7PfYUXu0lmQ865KeM5xYISEkNsfhGT+PUd9v" +
           "Vcr9xoKjJWc7G85X8xgPTNytxtUlyy671BJupCUiLme6ZUzxSFX7k8mY0EXF" +
           "r1edtbraNJrlcO5SJsdgZFfkqqt5Ro2CAWcOjOFAIhVraEwGG69k9pY23SqL" +
           "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" +
           "UFc9fab40msfwoyK4uXxwd5n3/Qvd/O/YL7maVQs7jsj5FmWHxo9+fnei5Rf" +
           "24NuODrmu6KsenrSw6cP924NtCgOXP7UEd89R2Z9KDdXH1zfPzDr969eNbjq" +
           "np0rnGTnGmfOp/cKgr3DM7tn5SWoBFX2Vc/ZP6gk5UNJMXlzncPtLG/WQGsl" +
           "0KToympVXpo6MjJYqXlFsSvfNymJ9i1HMrT96zMovDf4cedMJ2UsOtwje96f" +
           "d1aBadDd3N33T2jPvSIGdo5/HaMWhjvU98FrFfd2hbqDtwYKdm++jpnfljdv" +
           "jKA7FfD3WwsiPi9xFGfOIQiCB68dBEURY3ew+MTvPPCl1z/xwN8VdYALVjgD" +
           "uU1gXKWWfmLOd5/8+re+8sx7PlqUy26UpXDnpWdfQrjyHYNTrw4UKtx2tAl3" +
           "52rdB64XHzj1i3fn1tr/aCUXMHHy8o4X4OCuiPTDkvH/zUI73+NPAO4iP0u3" +
           "PSk62uNzB/XXo+PRd6bnoMITH7+OD3ZPYf55W3ONyLzaajdYuzh+h59eM/SP" +
           "D8/bNoi83LEOx3blY8vbP3p/BQymVxXe3QlfLPa00eikp3/wOmMfypvfBkZU" +
           "ckl3il2H/MkDPChQ400/BWrkz7W8dntudIAao/8l1MibtxRUn7iOXp/Mm49H" +
           "0DMOweDg4fFbx9r+3tPRNo2gu67+HsGhIzz8U7yiAPDpeVe8UrV7DUj56BMX" +
           "Lzz3ielf7uDl8FWdWyjogh7b9ska2In7836g6VZhiVt2FTG/+Hoqgp57DTlB" +
           "kMjHCv3Jjv7TEXTpLD3wreL7JN1nIujWYzrAandzkuTzINQASX775/6h0SrX" +
           "MtoOJvJYKupzlgKsuLNVeu50mnS0n3f+uP08kVk9cOppULz0dpi+xLvX3h5R" +
           "PvYESb/2e/UP7F4nUGwpKx7kFwBw795sOEqBXnhNboe8zvcf+uHtH7/lwcNc" +
           "7fadwMchcUK2+65euO86flSU2rM/fO4fvPyDT3ytqNz9N9U7LuKNKAAA");
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
      ("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" +
       "94bfeu6b+fH0/wDwAyqzVCMAAA==");
}
