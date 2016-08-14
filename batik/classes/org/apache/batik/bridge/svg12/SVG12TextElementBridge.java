package org.apache.batik.bridge.svg12;
public class SVG12TextElementBridge extends org.apache.batik.bridge.SVGTextElementBridge implements org.apache.batik.bridge.svg12.SVG12BridgeUpdateHandler {
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.svg12.SVG12TextElementBridge(
                                                            ); }
    protected void addTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                         org.apache.batik.dom.events.NodeEventTarget e) {
        if (childNodeRemovedEventListener ==
              null) {
            childNodeRemovedEventListener =
              new org.apache.batik.bridge.svg12.SVG12TextElementBridge.DOMChildNodeRemovedEventListener(
                );
        }
        if (subtreeModifiedEventListener ==
              null) {
            subtreeModifiedEventListener =
              new org.apache.batik.bridge.svg12.SVG12TextElementBridge.DOMSubtreeModifiedEventListener(
                );
        }
        org.apache.batik.bridge.svg12.SVG12BridgeContext ctx12 =
          (org.apache.batik.bridge.svg12.SVG12BridgeContext)
            ctx;
        org.apache.batik.dom.AbstractNode n =
          (org.apache.batik.dom.AbstractNode)
            e;
        org.apache.batik.dom.svg12.XBLEventSupport evtSupport =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            n.
            initializeEventSupport(
              );
        evtSupport.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        ctx12.
          storeImplementationEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        evtSupport.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
        ctx12.
          storeImplementationEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected void removeTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                            org.apache.batik.dom.events.NodeEventTarget e) {
        org.apache.batik.dom.AbstractNode n =
          (org.apache.batik.dom.AbstractNode)
            e;
        org.apache.batik.dom.svg12.XBLEventSupport evtSupport =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            n.
            initializeEventSupport(
              );
        evtSupport.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        evtSupport.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected class DOMChildNodeRemovedEventListener extends org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            super.
              handleEvent(
                org.apache.batik.dom.events.EventSupport.
                  getUltimateOriginalEvent(
                    evt));
        }
        public DOMChildNodeRemovedEventListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "c3bn+CMbvvE/m59a/DsVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8wkWVWv+WZndmbY3Zndhd11Zd8Dulvkq+7qrn5kAOmq" +
           "flQ/6tHVXf0okaGeXdVd73c3rgI+FiHiqgtiAvsXRCXLQyPRxGDWGAUCMcEQ" +
           "X4lAjIkokrB/iERUvFX9fV9/3zczu1lN7KRv3657zrnn3HvOr84994XvQOcC" +
           "H4Jdx1wvTCfcV9Nwf2li++HaVYP93gBjRT9QFcIUg2AMnl2XH//s5e/94Fn9" +
           "yh50XoDuFW3bCcXQcOyAUwPHjFVlAF3ePW2ZqhWE0JXBUoxFJAoNExkYQXht" +
           "AL3mGGsIXR0cqoAAFRCgApKrgDR2VIDpTtWOLCLjEO0w8KCfgc4MoPOunKkX" +
           "Qo+dFOKKvmgdiGFzC4CEC9n/CTAqZ0596NEj27c232Dwh2Dkud94x5XfOwtd" +
           "FqDLhj3K1JGBEiGYRIDusFRLUv2goSiqIkB326qqjFTfEE1jk+stQPcExsIW" +
           "w8hXjxYpexi5qp/PuVu5O+TMNj+SQ8c/Mk8zVFM5/HdOM8UFsPW+na1bC9vZ" +
           "c2DgJQMo5muirB6y3LYybCWEHjnNcWTj1T4gAKy3W2qoO0dT3WaL4AF0z3bv" +
           "TNFeIKPQN+wFID3nRGCWEHrwlkKztXZFeSUu1Osh9MBpOnY7BKgu5guRsYTQ" +
           "606T5ZLALj14apeO7c936Dd/8F02ae/lOiuqbGb6XwBMD59i4lRN9VVbVreM" +
           "dzw1+LB43+fftwdBgPh1p4i3NH/w0y+97U0Pv/jFLc2P3oSGkZaqHF6XPy7d" +
           "9dXXE0/Wz2ZqXHCdwMg2/4TlufuzByPXUhdE3n1HErPB/cPBF7k/n7/7k+q3" +
           "96BLXei87JiRBfzobtmxXMNU/Y5qq74YqkoXuqjaCpGPd6HbQX9g2Or2KaNp" +
           "gRp2odvM/NF5J/8PlkgDIrIluh30DVtzDvuuGOp5P3UhCLoLfKF7wdeBtp/8" +
           "N4QWiO5YKiLKom3YDsL6TmZ/gKh2KIG11REJeP0KCZzIBy6IOP4CEYEf6OrB" +
           "gOQbykJFgnhRRJHRpFNExyCOMpwAEvB8cD9zOPf/b6o0s/pKcuYM2JDXn4YD" +
           "E0QS6ZiK6l+Xn4vw1kufvv7lvaPwOFivEOLB7Pvb2ffz2fe3s+/ns+/ffPar" +
           "TYYidMNUaEdROdVyAAi0YjCcYWS2x9CZM7lWr83U3LoI2OAVgApAcMeTo5/q" +
           "vfN9j58Fvukmt4HdyUiRW2M5sQOXbg6hMvBw6MWPJO+Z/GxhD9o7CcqZaeDR" +
           "pYydzaD0CDKvng7Gm8m9/My3vveZDz/t7MLyBMofoMWNnFm0P356E3xHVhWA" +
           "nzvxTz0qfu7655++ugfdBiAEwGYoAjcHiPTw6TlORP21QwTNbDkHDNYc3xLN" +
           "bOgQ9i6Fuu8kuye5d9yV9+8Ga9yDDhr3IC7y32z0XjdrX7v1pmzTTlmRI/Rb" +
           "Ru7H/uYv/rmUL/chmF8+9nocqeG1YwCSCbucQ8XdOx8Y+6oK6P7+I+yvf+g7" +
           "z/xk7gCA4ombTXg1awkAHGALwTL/whe9v/3G1z/+tb2d04TgDRpJpiGnWyN/" +
           "CD5nwPe/s29mXPZgG/z3EAcI9OgRBLnZzG/c6QbAyARRmnnQVd62HMXQDFEy" +
           "1cxj//PyG4qf+9cPXtn6hAmeHLrUm15ZwO75j+DQu7/8jn9/OBdzRs5ehrv1" +
           "25FtEfbeneSG74vrTI/0PX/50G9+QfwYwGqAj4GxUXPIg/L1gPINLORrAect" +
           "cmoMzZpHguOBcDLWjiUt1+Vnv/bdOyff/eOXcm1PZj3H950S3WtbV8uaR1Mg" +
           "/v7TUU+KgQ7oyi/Sb79ivvgDIFEAEmUAfgHjA4RKT3jJAfW52//uT/70vnd+" +
           "9Sy014YumY6otMU84KCLwNPVQAfglro/8batNycXQHMlNxW6wfitgzyQ/zsL" +
           "FHzy1ljTzpKWXbg+8B+MKb33H75/wyLkKHOTd/UpfgF54aMPEm/9ds6/C/eM" +
           "++H0RtQGCd6OF/2k9W97j5//sz3odgG6Ih9kjxPRjLIgEkDGFBymlCDDPDF+" +
           "MvvZvuqvHcHZ609DzbFpTwPN7m0B+hl11r+02/An0zMgEM+h+9X9Qvb/bTnj" +
           "Y3l7NWt+bLvqWffHQcQGeRYKODTDFs1czpMh8BhTvnoYoxOQlYIlvro0q7mY" +
           "14E8PPeOzJj9bSq3xaqsLW21yPuVW3rDtUNdwe7ftRM2cEBW+IF/fPYrv/LE" +
           "N8AW9aBzcbZ8YGeOzUhHWaL8iy986KHXPPfND+QABNBn8ku/W/p+JrX/chZn" +
           "TTNrWoemPpiZOspf/QMxCKkcJ1Qlt/ZlPZP1DQtAa3yQBSJP3/ON1Ue/9alt" +
           "hnfaDU8Rq+977v0/3P/gc3vH8uonbkhtj/Nsc+tc6TsPVtiHHnu5WXKO9j99" +
           "5uk/+u2nn9lqdc/JLLEFDkGf+qv/+sr+R775pZukIreZzv9hY8M7SLIcdBuH" +
           "n0FxLk0TmUstlSkhLcVaa2zarbqDzpjpKV0loMPSSBquvVZBiTarJF41mbLd" +
           "EGeMgGJoFS3psVKlqgJWV5qdgml28SFBtcNGZQBjosOHPNr2Gjjer9D9sM3j" +
           "3ognCMvrpw2E4ArDpct2l0PStIVYQaUaPOuzJXw0Vks0wjLwpsTCtTKsJKUJ" +
           "ikteb+nRhZk1Rgdt3eaxxXot9VddIYSTJdVTedtDGsi4mCjRGqZET+HkVJKc" +
           "TR9dz/U+TU1VzkQ9yWSCdW2odguczqznwVyn/bbJTgp9jePCKYMVUtqc8BXR" +
           "MFotbtOcLPrF+coJaWFq95hy4vQXfkNwuzOcdrUSjnW7LVGQGbleW5Rg2SA1" +
           "IqKoSOsFhumNhA0RFJd9vjgdtzyXxhNnGoVUIWQtSggb877SnPenaFwuD5qG" +
           "VDQHkY5R2gBfaqzQjiqE4m18PJpZqMC2aJ8THIMbpr1AKa6WDOugsNF3RuIA" +
           "Za1+z0l03ltMGj194E9Vc7TQOJarVVf6AgubM75SdIOEdyy92ueo8XSztIOe" +
           "vWAWDMlE/nyzVJuhEvWLC8dfF9Ia0sLcirwaDxQ4Hrptt90mi31RZJotd9hq" +
           "dummMcXaAzJA5i5hdmzeWzGJWzbM+aqoyMRAEbxAIBWqptP1IoHFlFUbG9Sy" +
           "qA25DU4bQczXKM9yNYtQZzWvYPpMg0EV20CJRUiizWSO9glibs7FYb2MTSuu" +
           "PWmjutgJE65OdiodFfisGK3TjkjPPcOzeapV0Wm3a3Tq86SAi+AkVSYKqdNo" +
           "hcRSnPVabq067WGcJXd5a7oadiqE1GpN2JncmiYDjouaQi8Zcx1z0215MNxO" +
           "JLSkRXMNHZKruV5or/QgkAqzBJaiBSP1VpY4bYyZhbKcoz2l3LDVmtYUqRaO" +
           "x028MbD0OlzWnGZUDWezVC4olRSnsHKFm45Es62MNtN62FG9ul/2XH4qi2Hg" +
           "ETO0i7EoP94EbiMZjlqVkb4WukGqlNrFWqRqGsxVsU5dL+I4GUp9HZsxQ66C" +
           "rldjerKcLEiDLwfj7mrEIZPWpCyVVX0dLmC15elUymAYg5bHHV6adVzUoRG9" +
           "LpuN+XTT4ulaf+OJMl2nlyQN5iEMDvd0o+7pFRhPuxrCuyMuWInMqL3sRJ4j" +
           "FRzOpNgwJLiGjUtVemTYXVi3e3Tcnbp9fDXFV71hiq0MiRkG5tAcrrkqHdJI" +
           "uOGK1U4TKfHagmy2V41Gpak1yU4rqNaQ8sqj+rGEFbo6QRnTLp46cq/LdASX" +
           "8PujmonX5DjGiNoK5cQoLTNsxagQeneZ2C41Ktd73piM2PEcDftLvCaQwMM9" +
           "10nwfgse2Y3Wgmomg3Wy7k/nKdenRkU0aPJtYkU0hDLuNQgiDSuunlQ0lg7H" +
           "uGS6G3PSVHDdHRdsuhMPkpQoECPNHE3rLFE3YrBvAqcMASYIthXIQr9Alv0G" +
           "3LA2IKbiTatdlBO/H4Y1bj6ZDGvR0Bj25xPPKjPtjZcQxmAzYQqJrOGDmR3I" +
           "rWhC1Coi7LETo8SwZByPZtMWP/AKy3FnSA+JpsQG5DAuL9eFEQ77FF+SI8nD" +
           "MVWdNoe1HrFyx51yfaDEPYlZ9LBVacjyFialIdzX7PXcHVVjrjK0rW7ZGhJG" +
           "iW8JPb5RLHe7cFDhQTyXpckC8yXKLspDlp4GwBtq1DhyebpTmERBOuz3qaWf" +
           "iqq16StwvRIhJYqqVwRxavRrtkX0CklDsZftlYRXsOlgzbDT7rBRkoJZr1rF" +
           "4AG/SUurSiOYMuGQ66DjRYtqSFxjWIdhbTauVtOSoE7WaCvUjcil1xU8KXTN" +
           "UZkRAhhvwF1tCZulgkD4rd6CF8JhUl5J2akpsFpVZMA3SmN+gceDJaxz5LjH" +
           "jcWg7HIALNiyAgAFKYQIG86NrrhpLnvBJppu2ARb1lADx7BabYRES0taUWsv" +
           "gBViWUgbmh+TqlQ3yzPL4mCSC6sRXOdcmHAcEmBOONAJJpkbVZxtzavRFI66" +
           "EasmPd9Gx81xGGmYx9trRWn31NnGrNdjJpbgfl3FQm8SWk2k4NQXcqu7WjmL" +
           "JtE0aJvqoWJCIoLoaL00KBMVuiGkfbeJUmUi2KD+PIFRsR+UhkxSMHo8HkTF" +
           "lCgRRb7Xo5v2jI5CBKnSU2aF1ieO1uiKYYPyu+lCi4QhOxpWA4lqrIezTSGp" +
           "dVlV8uadpY6scJM0PGneJueRLdT0EmVhXFuA26TdROb1oLRuC5W5q9IbXaga" +
           "g2W1GKBEYW1uinDcxgttTwkJXRjaVbqvTjzHK/bZBIk2pqxOTXeWukjY7tV7" +
           "U3QpU8NiXEM6CHiFx/N0DMMBL6SePalMWrWFl3JKT5gYJqvApOnV0dJGH29g" +
           "RlgIsVswkkjFJLNBoto6nBfaslDvMl7MSvPZRtaicb1aW0qJZsUNs9CZbspl" +
           "uF6T8JnWb1OdegFXRjNaNkwrkWqzxVRvOx1mZilW4K4szeTQdp/S5hMyLCet" +
           "mV1ncWfdb6hqkV+4hABzY7kpFQtz3Wasaq/fbLDlFjkwNiwWL5YiXx8pG/Cu" +
           "T1N52SaYIO0yfqDDcRoJUWNdpgOYSNuVKj2fbMYEXSDROl1dmZbhMqPFLChU" +
           "tMEIReOxtrHFmDVqCU1HPD63e2hFDDTgA6ExSqY0JiuCIJNIiqUq3PFCv6Gn" +
           "QXVUd8NeeRx2EDt1ayMNRFAyVoI1xReHdbGyNOo2FXfWYruGKHWuh+utMm01" +
           "OM+eliYYSIRQrTdUW85GmZBiu63IETyfmaN2ya6FpFZb0nKMO8XEMilsM6PN" +
           "2gZO++XiQOhNI74m4lpFQgiF5BWFbosjR4/ra3kzSgmZsINa11qTZFruK7a/" +
           "HhF1ipghiO8KIAeqMUbDnC2TVS0dTxr8qkqSuNIu1KbBipCZahjCapsnTSVq" +
           "q4WZpHRJDgmq6wU2YtemPgxFVSPFxtJHMZleNosIktKMMcaoYjxoNgZVMxFS" +
           "TZnjZDk0tRUW9z1W4aoOYrdhtxiVXa1gzKqK2ug2dZboiDazEKudZapKIOGc" +
           "1H1ks5aYkiR3RqyTgqyURctVbIpHeL1ZwRjSsKlaWeHlUiGIS6syXSexKhJX" +
           "lcoMqS0ERXYLQujxa80kakitTsQDNBUXkuBr3GaSgERBn9q8QzskFk963aAu" +
           "Fip6L5zLA7at8+nEkYvqpFifjdS0x7dESyIbEjvrKEm8XEaS4TPBQlQdN00r" +
           "a69WL/SqVGsaD9dM0B8kk6E7WAsrX3alqNQFCeJisVHGTWbakcNoXHM6MUdi" +
           "ldgrengXKxhjE65HcaD13bmJJPF0kBLYiDDFft9fOSZXAAl+JXTt8awtx4bg" +
           "oM207Ywxu2gqEkrDsVySbJigpDhuIRZWF5FmMAEnh7dkR4q3v7pT3d35Afbo" +
           "YgIc5rKBzqs4zaQ3nxAcri+6vhOCA7yqpEfVvLyucefpKvexat6xigeUHd0e" +
           "utVFRH5s+/h7n3teYT5R3DuoFE3BSf3gfmgnJzs7P3Xr8ymVX8LsyhdfeO+/" +
           "PDh+q/7OV1GgfeSUkqdF/g71wpc6b5R/bQ86e1TMuOF66CTTtZMljEu+Gka+" +
           "PT5RyHjoaFkvZ8v1VL6S24938yLpzbcq942tR5yqwp05WMCDcsYDWdE9Kcn7" +
           "imPtq1nhPNjP6+c5c/gyJby8cULoNbpoK6aaM+WE3DH/moCzdOwYys7x3Fc6" +
           "Rp+oloXQo69U4D+0pPy/uT4AfvTADbeX2xs3+dPPX75w//P8X+f18aNbsYsD" +
           "6IIWmebxYtSx/nnXVzUjX5uL29KUm//8fAg99LIKhtC5/Dc35+e2TM+E0P23" +
           "YAJRse0cp39/CF05TQ/k5r/H6X45hC7t6ICobec4ybMhdBaQZN1fdQ+XmLqV" +
           "BWBxX/3NTHrmJDIcucg9r+Qix8DkiRMokN9XH0ZstL2xvi5/5vke/a6XKp/Y" +
           "XhjIprjZZFIuDKDbt3cXR1H/2C2lHco6Tz75g7s+e/ENh/B011bhXSwe0+2R" +
           "m1fkW5Yb5jX0zR/e//tv/q3nv57X8f4H3PihlkggAAA=");
    }
    protected class DOMSubtreeModifiedEventListener extends org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            super.
              handleEvent(
                org.apache.batik.dom.events.EventSupport.
                  getUltimateOriginalEvent(
                    evt));
        }
        public DOMSubtreeModifiedEventListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcRxWfO3/EdmyfPxI7pLGTOE4ku+GubhNo5VAaO3Zy" +
           "4fyB7UbgtLnM7c7dbby3u9mdPZ8dAm0llIBQCMFtA6L+y1WhapsKUQGCVkaV" +
           "aKsCUksEFNQUiT8IHxGNkMofAcqbmd3bvT1fovQPTrq5vZk3b97n773Z566h" +
           "GstE3USjUbpgECs6otFJbFpEHlaxZc3AXFJ6sgr/89jV8fvCqHYWNWexNSZh" +
           "i4wqRJWtWdSlaBbFmkSscUJktmPSJBYx85gqujaLNipWPGeoiqTQMV0mjOAI" +
           "NhOoFVNqKimbkrjDgKKuBEgS45LE9geXBxOoUdKNBY98k4982LfCKHPeWRZF" +
           "LYkTOI9jNlXUWEKx6GDBRHcaurqQUXUaJQUaPaHudUxwOLG3zAQ9L0Y+uHE+" +
           "28JN0I41TadcPWuKWLqaJ3ICRbzZEZXkrJPoi6gqgdb7iCnqTbiHxuDQGBzq" +
           "autRgfRNRLNzwzpXh7qcag2JCUTR9lImBjZxzmEzyWUGDnXU0Z1vBm23FbUV" +
           "Wpap+PidsaUnj7V8vwpFZlFE0aaZOBIIQeGQWTAoyaWIae2XZSLPolYNnD1N" +
           "TAWryqLj6TZLyWiY2uB+1yxs0jaIyc/0bAV+BN1MW6K6WVQvzQPK+VeTVnEG" +
           "dO3wdBUajrJ5ULBBAcHMNIa4c7ZUzymaTNHW4I6ijr2fAQLYui5HaFYvHlWt" +
           "YZhAbSJEVKxlYtMQeloGSGt0CECTos0VmTJbG1iawxmSZBEZoJsUS0BVzw3B" +
           "tlC0MUjGOYGXNge85PPPtfF9505ph7QwCoHMMpFUJv962NQd2DRF0sQkkAdi" +
           "Y2N/4gnc8fLZMEJAvDFALGh++IXrD+zuXn1d0NyxBs1E6gSRaFJaSTW/tWW4" +
           "774qJkadoVsKc36J5jzLJp2VwYIBCNNR5MgWo+7i6tTPP//Is+RvYdQQR7WS" +
           "rto5iKNWSc8ZikrMg0QjJqZEjqN6osnDfD2O1sFzQtGImJ1Ipy1C46ha5VO1" +
           "Ov8PJkoDC2aiBnhWtLTuPhuYZvlzwUAINcMXtcN3AYkP/6UoE8vqORLDEtYU" +
           "TY9NmjrT34oB4qTAttlYCqJ+LmbptgkhGNPNTAxDHGSJs5AyFTlDYlY+M3B3" +
           "bPrIwYG7ZyCPGDIAhyG+GGUBZ/z/jiowrdvnQyFwyJYgHKiQSYd0VSZmUlqy" +
           "h0auv5B8U4QaSw/HXhTNwOlRcXqUnx4Vp0f56dG1T+89MDE2baeoSQiUAAUS" +
           "XR7JwypDYuZiFApxoTYwKUWEgH/nACmAoLFv+uHDx8/2VEFoGvPV4BxG2lNS" +
           "soY9OHFrQFK61Na0uP3KwKthVJ1AbViiNlZZBdpvZgDbpDkn/RtTUMy8mrLN" +
           "V1NYMTR1icgAaZVqi8OlTs8Tk81TtMHHwa14LLdjlevNmvKj1Yvzjx750l1h" +
           "FC4tI+zIGkBAtn2SgX8R5HuD8LEW38iZqx9ceuK07gFJSV1yy2nZTqZDTzBs" +
           "guZJSv3b8EvJl0/3crPXA9BTDIkJGNodPKMEpwZdzGe61IHCad3MYZUtuTZu" +
           "oFlTn/dmeDy3smGjCG0WQgEBebn41LTx1O9+9Zd7uCXdyhLxtQTThA760Iwx" +
           "a+O41epF5AxEL9C9e3Hym49fO3OUhyNQ7FjrwF42DgOKgXfAgl9+/eQ7711Z" +
           "uRz2QpiiesPUKeQ5kQtcnQ0fwicE3/+yLwMhNiHAqG3YQcRtRUg02OG7PPEA" +
           "HFXgxuKj90Etx9MMp1TCUujfkZ0DL/39XIvwuAozbsDsvjUDb/5jQ+iRN4/9" +
           "q5uzCUmsOHsm9MgE4rd7nPebJl5gchQefbvrW6/hp6B2AF5byiLhEIy4SRD3" +
           "4V5ui7v4uCew9kk27LT8YV6aSb4mKimdv/x+05H3X7nOpS3twvyuH8PGoAgk" +
           "4QU4LI6cYdEpCfyXrXYYbOwsgAydQaw6hK0sMNuzOv5Qi7p6A46dhWMlQGxr" +
           "wgRYLZREk0Nds+73P3u14/hbVSg8ihpUHcujmOccqodgJ1YWELlgfPoBIcd8" +
           "HQwt3B6ozEJlE8wLW9f270jOoNwjiz/q/MG+Z5av8Mg0BI87/Ax38bGPDbtF" +
           "5LLHjxeKxuK0TcH66TNWKU8TdVVqcXh7tvLY0rI88fSAaETaStuGEeiKn//N" +
           "f34RvfjHN9aoTbVOi+odyCpFV0mlGOOtn4dW7zZf+NOPezNDt1Mk2Fz3LcoA" +
           "+78VNOivDPpBUV577K+bZ+7PHr8NvN8asGWQ5ffGnnvj4C7pQpj3uQLqy/rj" +
           "0k2DfqvCoSaBhl5jarKZJp4qO4rejzCv9sP3lOP9U8FUEcC8diiByww7BVdD" +
           "L5xYhPOerBLDAD6EHD+z/5ugC2Xtyfw9UlTWc1HCegzwOvvhcnzuJuDyEBs+" +
           "S9H6LNZklfBNED19N7kkmkoOykXeabNjp9vem/vO1edF5AZ78gAxObv01Q+j" +
           "55ZEFIuLy46yu4N/j7i8cFFb2BBlubT9ZqfwHaN/vnT6J989fSbsqBmnqDqv" +
           "K+Lycy8bpoTx931EkGETQ0YB4uoWTZ7roj0fpYMEXTeVXWDFpUt6YTlS17n8" +
           "4G95ChcvRo2QjGlbVX2x7I/rWsMkaYWbpFHAv8F/chR13VRAimr4L1dHFZsA" +
           "ezorbIIQFw9+evZCIkgPfPmvny5PUYNHB6zEg59kgaIqIGGPi4Zr4kQlDcC4" +
           "t92cF0LlVeFe0XTdInB8oL+jJI34GwsXsmzxzgL69eXD46euf+Jp0aVJKl5c" +
           "5DdcuLCLXrAIe9srcnN51R7qu9H8Yv1ON+xLukS/bDx8AUB4O7U50LNYvcXW" +
           "5Z2Vfa/88mzt25CwR1EIU9R+1Pe+QFyOofGxod4cTXgVx/fGizdTg33fXrh/" +
           "d/off+AF16lQWyrTJ6XLzzz86wubVqDpWh9HNZDRpDCLGhTrwII2RaS8OYua" +
           "FGukwJ1FFazGUZ2tKSdtEpcTqJllA2bvMrhdHHM2FWdZ+05RTznwlF96oDmZ" +
           "J+aQbmsyLwRQoryZklcpbuWwDSOwwZspunJDue5J6cBXIj8931Y1Chldoo6f" +
           "/TrLThWrkv/tilemHJwULXRVMjFmGG5LXfusIbLla4KGzVMU6ndmfZWF/f06" +
           "Z3eOP7LhG/8DntYO5zgVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected org.w3c.dom.Node getFirstChild(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblFirstChild(
            );
    }
    protected org.w3c.dom.Node getNextSibling(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblNextSibling(
            );
    }
    protected org.w3c.dom.Node getParentNode(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblParentNode(
            );
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        if (isParentDisplayed(
              childNode)) {
            if (getParentNode(
                  childNode) !=
                  childNode.
                  getParentNode(
                    )) {
                computeLaidoutText(
                  ctx,
                  e,
                  node);
            }
            else {
                laidoutText =
                  null;
            }
        }
    }
    public void handleBindingEvent(org.w3c.dom.Element bindableElement,
                                   org.w3c.dom.Element shadowTree) {
        
    }
    public void handleContentSelectionChangedEvent(org.apache.batik.bridge.svg12.ContentSelectionChangedEvent csce) {
        computeLaidoutText(
          ctx,
          e,
          node);
    }
    public SVG12TextElementBridge() { super(
                                        );
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
