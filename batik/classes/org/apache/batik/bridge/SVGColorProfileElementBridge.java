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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Yf4xURx2f3fv9izsOjqMUDjgOkqN0H1CwNkexd9c7OLp3" +
       "XDh6iYtlmX07u/e4t+893pu927sWbYkNSJQgUopK+cdrqIQfjbFRo22ojbZN" +
       "q0lbtFZTatREtBJLjNWItn5n5r19P/Z2kUTdZGdnZ74z8/35+X5nzl1DFZaJ" +
       "2ohGI3TKIFakT6PD2LRIslfFlrUTxuLyk2X4L7uvDt0TRpUxNGcMW4Mytki/" +
       "QtSkFUNLFM2iWJOJNURIkq0YNolFzAlMFV2LoRbFGsgYqiIrdFBPEkYwis0o" +
       "mospNZVElpIBewOKlkSBE4lzInUHp7uiqF7WjSmXfKGHvNczwygz7lkWRU3R" +
       "vXgCS1mqqFJUsWhXzkR3GLo6lVZ1GiE5GtmrbrRVsC26sUAF7c82fnjj6FgT" +
       "V8E8rGk65eJZO4ilqxMkGUWN7mifSjLWPvRZVBZFdR5iijqizqESHCrBoY60" +
       "LhVw30C0bKZX5+JQZ6dKQ2YMUbTcv4mBTZyxtxnmPMMO1dSWnS8GaZflpRVS" +
       "Foj4xB3S8Sd3N32rDDXGUKOijTB2ZGCCwiExUCjJJIhpdSeTJBlDczUw9ggx" +
       "Fawq07almy0lrWGaBfM7amGDWYOY/ExXV2BHkM3MylQ38+KluEPZ/ypSKk6D" +
       "rAtcWYWE/WwcBKxVgDEzhcHv7CXl44qWpGhpcEVexo4HgACWVmUIHdPzR5Vr" +
       "GAZQs3ARFWtpaQRcT0sDaYUODmhStKjopkzXBpbHcZrEmUcG6IbFFFDVcEWw" +
       "JRS1BMn4TmClRQEreexzbWjTkYe1rVoYhYDnJJFVxn8dLGoLLNpBUsQkEAdi" +
       "Yf3q6Am84PlDYYSAuCVALGi+88j1+9a0XXpF0Nw+C832xF4i07g8k5jzxuLe" +
       "znvKGBvVhm4pzPg+yXmUDdszXTkDEGZBfkc2GXEmL+348acfPUveD6PaAVQp" +
       "62o2A340V9YzhqIScwvRiIkpSQ6gGqIle/n8AKqCflTRiBjdnkpZhA6gcpUP" +
       "Ver8P6goBVswFdVCX9FSutM3MB3j/ZyBEKqCL1oC39VIfDpZQ1FaGtMzRMIy" +
       "1hRNl4ZNnclvSYA4CdDtmJQArx+XLD1rggtKupmWMPjBGLEnEqaSTBNpZHQL" +
       "sK2bsJ7xw5ABdujhkxHmcMb/76gck3reZCgEBlkchAMVImmrriaJGZePZ3v6" +
       "rl+IvyZcjYWHrS+KNsDpEXF6hJ8eEadHSp2OQiF+6HzGhfAAsN84IAFAcX3n" +
       "yEPb9hxqLwPXMybLQfmMtN2XknpduHAwPi5fbG6YXn5l3UthVB5FzVimWayy" +
       "DNNtpgG75HE7vOsTkKzcnLHMkzNYsjN1mSQBsorlDnuXan2CmGycovmeHZyM" +
       "xmJXKp5PZuUfXTo5+djo59aGUdifJtiRFYBwbPkwA/c8iHcE4WG2fRsPXv3w" +
       "4on9ugsUvrzjpMuClUyG9qBbBNUTl1cvw8/Fn9/fwdVeA0BOMQQeYGRb8Awf" +
       "DnU5mM5kqQaBU7qZwSqbcnRcS8dMfdId4f46lzUtwnWZCwUY5Ong3hHjqV/8" +
       "9A93cU06maPRk/JHCO3yoBXbrJnj0lzXI3eahADduyeHv/LEtYO7uDsCxYrZ" +
       "DuxgbS+gFFgHNPj4K/veee/KzOWw68IU0nU2AVVPjssy/2P4hOD7EfsyhGED" +
       "Ammae224W5bHO4OdvMrlDSJLBUhgztHxoAZuqKQUnFAJi59/Nq5c99yfjjQJ" +
       "c6sw4njLmptv4I7f1oMefW3339r4NiGZZV5Xfy6ZgPN57s7dpomnGB+5x95c" +
       "8tWX8VOQGACMLWWacHxFXB+IG3Aj18Va3m4IzN3NmpWW18f9YeSpkOLy0csf" +
       "NIx+8MJ1zq2/xPLafRAbXcKLhBXgsDZkNw7e8182u8BgbWsOeGgNAtVWbI3B" +
       "ZhsuDX2mSb10A46NwbEywLG13QTMzPlcyaauqPrliy8t2PNGGQr3o1pVx8l+" +
       "zAMO1YCnE2sM4DZnfOo+wcdkNTRNXB+oQEMFA8wKS2e3b1/GoNwi099t/fam" +
       "M6evcLc0xB635xF2sQ9heTXvBvnZt+7+2Zkvn5gU9UBncWQLrFv4j+1q4sBv" +
       "/l5gF45ps9QqgfUx6dypRb2b3+frXXBhqztyhVkLANpdu/5s5q/h9sofhVFV" +
       "DDXJdvU8itUsi+sYVIyWU1JDhe2b91d/otTpyoPn4iCweY4NwpqbLaHPqFm/" +
       "IeCDdcyE98JXsn1QCvpgCPHONr5kFW87WbNGmI9178zl9+MuUVtiP4oqZJay" +
       "+YqFFK0tyOLMsHiSRmSWwyNDIETSzuS9jErAL2s/yZoHxNmbZvNdMbWKNYN5" +
       "Dvmn0qmunF8Phz7ntLlcVazW6DNN3cxfj1jALilWN/Oaf+bA8dPJ7U+vE97c" +
       "7K9F++Cqdf7n/3o9cvLXr85S8NRQ3bhTJRNE9bBYxo70xc8gv1K4zvjunGO/" +
       "/V5HuudWihM21naT8oP9XwpCrC4ekkFWXj7wx0U7N4/tuYU6Y2lAncEtvzl4" +
       "7tUtq+RjYX5/ElFScO/yL+ryx0atSeCiqO30RciKvL80Oyi9wfaXDcEIcT0y" +
       "4Gr5YCi2tEQSSpeYU1iToKg+DbcLXcYqCxLHVZs4FDP0iIi7oxsrcolY+Q9w" +
       "ng30GHx8d17GxWxuPXy7bRm7b109xZYGVFBmO7wt6MpiMSkqffu5wKGex6gn" +
       "75IjST0Tsa8EbGqc8zdRQtuPsGYfVCGySaAiGujt5beLETiZ9LkHSDcBslnX" +
       "cbOY/wOztLK5DvgetnV7uIRZgqAepqjKMJUJkBaKR4u/vgQgvrnE1gFdhsWe" +
       "7O8Uayb50V8sofEjrPk85ZkRwIYOgCUBXX1XMYZgI9mEBdcmJQOl9IT9xLB+" +
       "eI98qGP4dwJgb5tlgaBreUb60ujbe1/nUFTNsC8PAB7cA4z0XACaWBNhIF+i" +
       "DAnwI+1vfm/81NXzgp9gzREgJoeOH/44cuS4AH/xiLSi4B3Hu0Y8JAW4W17q" +
       "FL6i//cX93//mf0Hw7bGYxSVKfb7HrNGKF+bzfdrUPB5/xcaf3C0uawfUsoA" +
       "qs5qyr4sGUj6YbXKyiY8KnXfnFyQtTlm9w+KQqudwpAHxeP/jaDIQcVU6jWA" +
       "la4LC14jxQuafOF0Y3Xr6Qff5nkz/8pVD96Syqqqt7jy9CsNk6QULl29KLUM" +
       "/jNDUWsRvIIQEx0uxTcE/RkA8iA9lE7810t3lqJalw62Eh0vyXmwLZCw7gXD" +
       "QavOYuDZDRFiQpEAahM6yoU81QbyWKjlZhbKL/FeXVm88Gdix6my4qE4Ll88" +
       "vW3o4eufeFpcnWUVT0+zXerAlcQFPV8TLC+6m7NX5dbOG3OerVnp+Lfv6u7l" +
       "jfsJeDq/5i4K3CWtjvyV8p2ZTS/85FDlmxCZu1AIQz7ZVVim54wsFGO7ooUh" +
       "A/UTv+R2dX5tavOa1J9/xS9CqOD6E6SPy5fPPPTWsYUzcBmuG0AVELokx+8P" +
       "909pO4g8YcZQg2L15YBF2EXBqi8e5zCvxawI4Hqx1dmQH2VvKhS1FyJM4UsU" +
       "XBonidmjZ7WkHdF17ojv/dopq7KGEVjgjnhA9esCBJg1wFHj0UHDcB4kyj8y" +
       "eCCfCuISH+SrX+Rd1vzw39hggmNCGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JwAUliQAAA==");
}
