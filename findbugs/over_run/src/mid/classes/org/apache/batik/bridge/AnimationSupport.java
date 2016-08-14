package org.apache.batik.bridge;
public abstract class AnimationSupport {
    public static void fireTimeEvent(org.w3c.dom.events.EventTarget target,
                                     java.lang.String eventType,
                                     java.util.Calendar time,
                                     int detail) { org.w3c.dom.events.DocumentEvent de =
                                                     (org.w3c.dom.events.DocumentEvent)
                                                       ((org.w3c.dom.Node)
                                                          target).
                                                       getOwnerDocument(
                                                         );
                                                   org.apache.batik.dom.events.DOMTimeEvent evt =
                                                     (org.apache.batik.dom.events.DOMTimeEvent)
                                                       de.
                                                       createEvent(
                                                         "TimeEvent");
                                                   evt.
                                                     initTimeEventNS(
                                                       org.apache.batik.util.XMLConstants.
                                                         XML_EVENTS_NAMESPACE_URI,
                                                       eventType,
                                                       null,
                                                       detail);
                                                   evt.
                                                     setTimestamp(
                                                       time.
                                                         getTime(
                                                           ).
                                                         getTime(
                                                           ));
                                                   target.
                                                     dispatchEvent(
                                                       evt);
    }
    public static org.apache.batik.anim.timing.TimedElement getTimedElementById(java.lang.String id,
                                                                                org.w3c.dom.Node n) {
        org.w3c.dom.Element e =
          getElementById(
            id,
            n);
        if (e instanceof org.apache.batik.dom.svg.SVGOMAnimationElement) {
            org.apache.batik.bridge.SVGAnimationElementBridge b =
              (org.apache.batik.bridge.SVGAnimationElementBridge)
                ((org.apache.batik.dom.svg.SVGOMAnimationElement)
                   e).
                getSVGContext(
                  );
            return b.
              getTimedElement(
                );
        }
        return null;
    }
    public static org.w3c.dom.events.EventTarget getEventTargetById(java.lang.String id,
                                                                    org.w3c.dom.Node n) {
        return (org.w3c.dom.events.EventTarget)
                 getElementById(
                   id,
                   n);
    }
    protected static org.w3c.dom.Element getElementById(java.lang.String id,
                                                        org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          n.
          getParentNode(
            );
        while (p !=
                 null) {
            n =
              p;
            if (n instanceof org.apache.batik.dom.svg.SVGOMUseShadowRoot) {
                p =
                  ((org.apache.batik.dom.svg.SVGOMUseShadowRoot)
                     n).
                    getCSSParentNode(
                      );
            }
            else {
                p =
                  n.
                    getParentNode(
                      );
            }
        }
        if (n instanceof org.apache.batik.dom.svg.IdContainer) {
            return ((org.apache.batik.dom.svg.IdContainer)
                      n).
              getElementById(
                id);
        }
        return null;
    }
    public AnimationSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Jfoty70BR/YIy1uWyMGf47Dvv0TryQ5kGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ToFAPFPere0Ws99P5QMfyctLWfH6rdWz6htAxIZ5cglG6KYr2TmfxyPgMbZy" +
       "aT9GxyDZBCa+ZNm1nM3dIL3OvSNTZneboW2xKisrWynyevW63nB5X1aw+ncc" +
       "MqM8kOx94B8++PVffezbYIkI6MwqMx9YmSMzMnGW/77nxeceeNWz3/lADkAA" +
       "fbjnuxeeyriSN9I4KzpZ0d1X9f5MVT7fwSkpjOgcJzQ11/aGnskFpgOgdbWX" +
       "3MFPX/z24sPf/dQ2cTvphieItfc9+/4f7z7z7M6RdPmxqzLWo2O2KXMu9O17" +
       "Fg6gR240Sz6i94+fefqLv/v0e7dSXTye/HXBu82n/vK/vr77oe989RrZxWnb" +
       "+ykWNrq9gyEh3tz/UKWZPlmPkmSis5XGvI/Q8BqX+BndnPWDWjxYOG3Sptts" +
       "qy27bJ/E1KXEhLpS8zeNkNJqNbomiglDmgTf9OZ+bz2y/R43p0qdgd3tTZhJ" +
       "MCI9o7HsLkf+fCFGXMQvxnoDL3jdEezZclEQG3JZrqgOvNKbNlkSmVh2YCed" +
       "RqtKqK9Wqp2WiiYzQxnWTLylpfcSM3USooO4S624jkaaa1k0Hm5cOxQKKttJ" +
       "S2XYs0ZjvDbsS9yIVHVvUJN9q6eqMxkfhKU12xmN0DiZC/RI5cUQTVtVe9ph" +
       "GVwlHXZaEvmGMrJ0TSYXbLuiDtlFSyZjqWwraFqKB2tkIg4G5ZDvMSuMmc2o" +
       "uNW3R0J/pVRq7bnUZbhZs+SHNaRuoJyTdJAqH9NoELuJwcrrWpAwY9txOKsa" +
       "Omnar1ubslCDBUYRyglRtMXYqHuaY/WRAsc0wzQl+/3ZlEiGfWWqFJOGTS6I" +
       "YixwcjQWS5bdXC2cZdcZOnPCFAJv4DJNtI1sOiO22uBaasDNFrO4XGZJpNLm" +
       "RtWy7XVJhWrbzszuy6JdLPNSN1VIy6pFbk+0rAgJCZ+bapi1shZL8ERJw4MX" +
       "3bE09ExB9JI563lec4DhI2Y+IkSGbqzEgPRpjMejlmXU58xCKskjotSII8sS" +
       "wxFR7XS5Dj33adRs2G3fqQf1Nq+kCuJXqAGV1GPcwyi4NBkW2XniyrrOkYsC" +
       "0tF0Y94sSmRfdEma1+LquLoqSx7uVUk1EdgyNtK7dGfSH7v9YX3TXvaXnfV8" +
       "6Nt83xyVaYSbd1riet2RZkUCn5jUhIj7pBpIXugX2DDhXXrNFTdTu2t3xu0i" +
       "N+8tatLa4dvdiuEPFINq6g2lXMOMQrdvlRCTb7NmSC/GGDzR275XG/h2MVyX" +
       "132Nb1aYJUpz3ak8Tb0JMeDxcpHqLmIR65RqekQFVtGMedSfbZjOSiigVntU" +
       "X4oNdh1EsBQW+vh4afdcZ1btp2a9GivmxqdWvCsrTUn1KAzrJqhZ0sqrSRCk" +
       "lSLGRbLdEYqLcdArYYxokvQkURKQvddCDXVbMr0Uywt96UhY2eRGBXrOal00" +
       "aKFsygq0aKzwBnADclkyBHg9GogzvOtIXstNFXNWCZheYWYgqR13F30ZWVgy" +
       "EpjCBq8gaFHDLdGXe8sRzqRCx+LVVbdeZTotbbZuoeh4Qk1prRWYOlyQIhkr" +
       "KYpOl4ftgaLSmmWzuGl0nV6B8SclFutPeNQ2pgTtt1OKofslvD8I4aq+XhFI" +
       "3bKtxWCOoOpsTbDmQJDLTmDhNX+UOpGzaehWreTM1xWhhU1FP1VaBmGNHILm" +
       "8YQw5f562CKJdreXjmSqyHFGxG2awFs7lun1VjLTqAUUTQ5CRFquJQsvuJuF" +
       "T42QItszCnUfVTfj6ZidTssNhFoszXlb9MmuXZhq8+VyHm8CxnHW9qDpx4ul" +
       "gWt8XbODgb1obMiJMCuqZayGqtVWv6s5w1lzY/bKKI0Xm6PhVOuOqLpWqWpz" +
       "DCuVkKrf8YlKNKzpLXIa2iwAMzbsrTpGse6TiS70SvQK05bkwvGaxLxlCWYP" +
       "Xfe76mxoA0SlIkQgNX+AsG4HiyhmnGwGnNCyUNMpcwULNys9I5VE1jBYfDDq" +
       "EZ2CP8CCEhHDBSWszkYLDhbDtjiNm3UNaSJmOx173YiaosWOuqSbalEXTJHj" +
       "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");
}
