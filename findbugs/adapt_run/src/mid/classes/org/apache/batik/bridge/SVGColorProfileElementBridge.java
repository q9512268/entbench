package org.apache.batik.bridge;
public class SVGColorProfileElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public org.apache.batik.ext.awt.color.NamedProfileCache cache = new org.apache.batik.ext.awt.color.NamedProfileCache(
      );
    public java.lang.String getLocalName() { return SVG_COLOR_PROFILE_TAG;
    }
    public org.apache.batik.ext.awt.color.ICCColorSpaceExt createICCColorSpaceExt(org.apache.batik.bridge.BridgeContext ctx,
                                                                                  org.w3c.dom.Element paintedElement,
                                                                                  java.lang.String iccProfileName) {
        org.apache.batik.ext.awt.color.ICCColorSpaceExt cs =
          cache.
          request(
            iccProfileName.
              toLowerCase(
                ));
        if (cs !=
              null) {
            return cs;
        }
        org.w3c.dom.Document doc =
          paintedElement.
          getOwnerDocument(
            );
        org.w3c.dom.NodeList list =
          doc.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_COLOR_PROFILE_TAG);
        int n =
          list.
          getLength(
            );
        org.w3c.dom.Element profile =
          null;
        for (int i =
               0;
             i <
               n;
             i++) {
            org.w3c.dom.Node node =
              list.
              item(
                i);
            if (node.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                org.w3c.dom.Element profileNode =
                  (org.w3c.dom.Element)
                    node;
                java.lang.String nameAttr =
                  profileNode.
                  getAttributeNS(
                    null,
                    SVG_NAME_ATTRIBUTE);
                if (iccProfileName.
                      equalsIgnoreCase(
                        nameAttr)) {
                    profile =
                      profileNode;
                }
            }
        }
        if (profile ==
              null)
            return null;
        java.lang.String href =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            profile);
        java.awt.color.ICC_Profile p =
          null;
        if (href !=
              null) {
            java.lang.String baseURI =
              ((org.apache.batik.dom.AbstractNode)
                 profile).
              getBaseURI(
                );
            org.apache.batik.util.ParsedURL pDocURL =
              null;
            if (baseURI !=
                  null) {
                pDocURL =
                  new org.apache.batik.util.ParsedURL(
                    baseURI);
            }
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              pDocURL,
              href);
            if (!purl.
                  complete(
                    ))
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  ERR_URI_MALFORMED,
                  new java.lang.Object[] { href });
            try {
                ctx.
                  getUserAgent(
                    ).
                  checkLoadExternalResource(
                    purl,
                    pDocURL);
                p =
                  java.awt.color.ICC_Profile.
                    getInstance(
                      purl.
                        openStream(
                          ));
            }
            catch (java.io.IOException ioEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  ioEx,
                  ERR_URI_IO,
                  new java.lang.Object[] { href });
            }
            catch (java.lang.SecurityException secEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  secEx,
                  ERR_URI_UNSECURE,
                  new java.lang.Object[] { href });
            }
        }
        if (p ==
              null) {
            return null;
        }
        int intent =
          convertIntent(
            profile,
            ctx);
        cs =
          new org.apache.batik.ext.awt.color.ICCColorSpaceExt(
            p,
            intent);
        cache.
          put(
            iccProfileName.
              toLowerCase(
                ),
            cs);
        return cs;
    }
    private static int convertIntent(org.w3c.dom.Element profile,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String intent =
          profile.
          getAttributeNS(
            null,
            SVG_RENDERING_INTENT_ATTRIBUTE);
        if (intent.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     AUTO;
        }
        if (SVG_PERCEPTUAL_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     PERCEPTUAL;
        }
        if (SVG_AUTO_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     AUTO;
        }
        if (SVG_RELATIVE_COLORIMETRIC_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     RELATIVE_COLORIMETRIC;
        }
        if (SVG_ABSOLUTE_COLORIMETRIC_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     ABSOLUTE_COLORIMETRIC;
        }
        if (SVG_SATURATION_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     SATURATION;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          profile,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_RENDERING_INTENT_ATTRIBUTE,
          intent });
    }
    public SVGColorProfileElementBridge() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NU3nIiD0a+550+SJ+hNsTv0XJV09po8ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Fo7yY723HM/xuNtBmEpFLak6HAvRqMHA0cboFkWPpSptJe6YEXgrkktrc4ga" +
       "pmd0wFuGWI24DWHPKnrPJMcDRRS7VGXlzEqiQ9mYVerLYAuVdjahASd8yPGR" +
       "32PlSZmcm6za40aoay7YxFJGDdEaqpyebkpVr2U49aaAM43Oqj8qOZTZROQC" +
       "hiEFoVsw+iHYsU66IlL33JoE3vTelL0Caq/sLfzO/MDh4CoMvHxnHdwrePvc" +
       "dj2aFY8fnOfkn9P71yb730fOc46cp53YP9x43Y0uClpB4AYH957ZC/iDN7oQ" +
       "y1++P/6uZ59X2U8Ud/aOLZ+KoFsj13uDpa0068jIJ4GkJ2580MDk94GHx2lf" +
       "fte/3D98s/HUK7gwePiYnsdF/g7zwlfbr1N+cwc6eXC4ds1N5dVMl68+UjsH" +
       "dvRx4AyvOlh78CAQd+0f2pf3AlG+/qH9y56q3eRU+Omb9L09K5IIum2uRbSr" +
       "yFZ/T3XuMLvSlzvbOCo0b4gP7Hsga0TBg+/Zh//f2HdyL0H2UvPxG6Xm9rZq" +
       "7zp8n/rujHpdUnZV197du9bKbc6H+vWbuOsDWfGrEXSPEmhypFEEkd+QCWBk" +
       "rXU4APwyR5rX5ct9/e6fwtf3Zo0XwfPMnq+feQW+3omgM15groBVOQpd1+s7" +
       "W9Ls529kxTM51Udv4rDns+K5KD+9XmlBRIFA7P034i1HkOtKBJ00nSN++PAr" +
       "8QPI3wdudlmZ3bbcd80fKbaX/8pnnz9/9t7nR3+d39cdXNDfSkNn9diyjh6O" +
       "H6mf9gJNN3MLb90elXv516ci6N4bpGIEnd5WcvU/uaX/3Qi6cJw+gk7l30fp" +
       "PhtB5w7pgKht5SjJ7wEXApKs+gVvPxEv3Whe4LMwCmQlAm7b+ig5cQR491Ir" +
       "j8RdLxeJA5aj93xZvuf/cNkH1nj7H5cryuee7/bf9lLlE9t7RsWSN5tMylka" +
       "OrO98jwA50dvKG1f1unOpR/f8flbH99fSO7YKnyY5kd0e/j6F3kt24vyq7fN" +
       "H977+2/85PPfys/N/wfQlsTreiQAAA==");
}
