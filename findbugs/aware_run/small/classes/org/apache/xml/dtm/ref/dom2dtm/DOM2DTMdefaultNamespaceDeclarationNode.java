package org.apache.xml.dtm.ref.dom2dtm;
public class DOM2DTMdefaultNamespaceDeclarationNode implements org.w3c.dom.Attr, org.w3c.dom.TypeInfo {
    static final java.lang.String NOT_SUPPORTED_ERR = "Unsupported operation on pseudonode";
    org.w3c.dom.Element pseudoparent;
    java.lang.String prefix;
    java.lang.String uri;
    java.lang.String nodename;
    int handle;
    DOM2DTMdefaultNamespaceDeclarationNode(org.w3c.dom.Element pseudoparent,
                                           java.lang.String prefix,
                                           java.lang.String uri,
                                           int handle) { super();
                                                         this.pseudoparent =
                                                           pseudoparent;
                                                         this.prefix = prefix;
                                                         this.uri = uri;
                                                         this.handle = handle;
                                                         this.nodename = "xmlns:" +
                                                                         prefix;
    }
    public java.lang.String getNodeName() { return nodename; }
    public java.lang.String getName() { return nodename; }
    public java.lang.String getNamespaceURI() { return "http://www.w3.org/2000/xmlns/";
    }
    public java.lang.String getPrefix() { return prefix; }
    public java.lang.String getLocalName() { return prefix;
    }
    public java.lang.String getNodeValue() { return uri; }
    public java.lang.String getValue() { return uri; }
    public org.w3c.dom.Element getOwnerElement() { return pseudoparent;
    }
    public boolean isSupported(java.lang.String feature, java.lang.String version) {
        return false;
    }
    public boolean hasChildNodes() { return false;
    }
    public boolean hasAttributes() { return false;
    }
    public org.w3c.dom.Node getParentNode() { return null;
    }
    public org.w3c.dom.Node getFirstChild() { return null;
    }
    public org.w3c.dom.Node getLastChild() { return null;
    }
    public org.w3c.dom.Node getPreviousSibling() {
        return null;
    }
    public org.w3c.dom.Node getNextSibling() { return null;
    }
    public boolean getSpecified() { return false;
    }
    public void normalize() { return; }
    public org.w3c.dom.NodeList getChildNodes() {
        return null;
    }
    public org.w3c.dom.NamedNodeMap getAttributes() {
        return null;
    }
    public short getNodeType() { return org.w3c.dom.Node.
                                          ATTRIBUTE_NODE;
    }
    public void setNodeValue(java.lang.String value) {
        throw new org.apache.xml.dtm.DTMException(
          NOT_SUPPORTED_ERR);
    }
    public void setValue(java.lang.String value) {
        throw new org.apache.xml.dtm.DTMException(
          NOT_SUPPORTED_ERR);
    }
    public void setPrefix(java.lang.String value) {
        throw new org.apache.xml.dtm.DTMException(
          NOT_SUPPORTED_ERR);
    }
    public org.w3c.dom.Node insertBefore(org.w3c.dom.Node a,
                                         org.w3c.dom.Node b) {
        throw new org.apache.xml.dtm.DTMException(
          NOT_SUPPORTED_ERR);
    }
    public org.w3c.dom.Node replaceChild(org.w3c.dom.Node a,
                                         org.w3c.dom.Node b) {
        throw new org.apache.xml.dtm.DTMException(
          NOT_SUPPORTED_ERR);
    }
    public org.w3c.dom.Node appendChild(org.w3c.dom.Node a) {
        throw new org.apache.xml.dtm.DTMException(
          NOT_SUPPORTED_ERR);
    }
    public org.w3c.dom.Node removeChild(org.w3c.dom.Node a) {
        throw new org.apache.xml.dtm.DTMException(
          NOT_SUPPORTED_ERR);
    }
    public org.w3c.dom.Document getOwnerDocument() {
        return pseudoparent.
          getOwnerDocument(
            );
    }
    public org.w3c.dom.Node cloneNode(boolean deep) {
        throw new org.apache.xml.dtm.DTMException(
          NOT_SUPPORTED_ERR);
    }
    public int getHandleOfNode() { return handle;
    }
    public java.lang.String getTypeName() { return null;
    }
    public java.lang.String getTypeNamespace() { return null;
    }
    public boolean isDerivedFrom(java.lang.String ns,
                                 java.lang.String localName,
                                 int derivationMethod) {
        return false;
    }
    public org.w3c.dom.TypeInfo getSchemaTypeInfo() {
        return this;
    }
    public boolean isId() { return false; }
    public java.lang.Object setUserData(java.lang.String key,
                                        java.lang.Object data,
                                        org.w3c.dom.UserDataHandler handler) {
        return getOwnerDocument(
                 ).
          setUserData(
            key,
            data,
            handler);
    }
    public java.lang.Object getUserData(java.lang.String key) {
        return getOwnerDocument(
                 ).
          getUserData(
            key);
    }
    public java.lang.Object getFeature(java.lang.String feature,
                                       java.lang.String version) {
        return isSupported(
                 feature,
                 version)
          ? this
          : null;
    }
    public boolean isEqualNode(org.w3c.dom.Node arg) {
        if (arg ==
              this) {
            return true;
        }
        if (arg.
              getNodeType(
                ) !=
              getNodeType(
                )) {
            return false;
        }
        if (getNodeName(
              ) ==
              null) {
            if (arg.
                  getNodeName(
                    ) !=
                  null) {
                return false;
            }
        }
        else
            if (!getNodeName(
                   ).
                  equals(
                    arg.
                      getNodeName(
                        ))) {
                return false;
            }
        if (getLocalName(
              ) ==
              null) {
            if (arg.
                  getLocalName(
                    ) !=
                  null) {
                return false;
            }
        }
        else
            if (!getLocalName(
                   ).
                  equals(
                    arg.
                      getLocalName(
                        ))) {
                return false;
            }
        if (getNamespaceURI(
              ) ==
              null) {
            if (arg.
                  getNamespaceURI(
                    ) !=
                  null) {
                return false;
            }
        }
        else
            if (!getNamespaceURI(
                   ).
                  equals(
                    arg.
                      getNamespaceURI(
                        ))) {
                return false;
            }
        if (getPrefix(
              ) ==
              null) {
            if (arg.
                  getPrefix(
                    ) !=
                  null) {
                return false;
            }
        }
        else
            if (!getPrefix(
                   ).
                  equals(
                    arg.
                      getPrefix(
                        ))) {
                return false;
            }
        if (getNodeValue(
              ) ==
              null) {
            if (arg.
                  getNodeValue(
                    ) !=
                  null) {
                return false;
            }
        }
        else
            if (!getNodeValue(
                   ).
                  equals(
                    arg.
                      getNodeValue(
                        ))) {
                return false;
            }
        return true;
    }
    public java.lang.String lookupNamespaceURI(java.lang.String specifiedPrefix) {
        short type =
          this.
          getNodeType(
            );
        switch (type) {
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    java.lang.String namespace =
                      this.
                      getNamespaceURI(
                        );
                    java.lang.String prefix =
                      this.
                      getPrefix(
                        );
                    if (namespace !=
                          null) {
                        if (specifiedPrefix ==
                              null &&
                              prefix ==
                              specifiedPrefix) {
                            return namespace;
                        }
                        else
                            if (prefix !=
                                  null &&
                                  prefix.
                                  equals(
                                    specifiedPrefix)) {
                                return namespace;
                            }
                    }
                    if (this.
                          hasAttributes(
                            )) {
                        org.w3c.dom.NamedNodeMap map =
                          this.
                          getAttributes(
                            );
                        int length =
                          map.
                          getLength(
                            );
                        for (int i =
                               0;
                             i <
                               length;
                             i++) {
                            org.w3c.dom.Node attr =
                              map.
                              item(
                                i);
                            java.lang.String attrPrefix =
                              attr.
                              getPrefix(
                                );
                            java.lang.String value =
                              attr.
                              getNodeValue(
                                );
                            namespace =
                              attr.
                                getNamespaceURI(
                                  );
                            if (namespace !=
                                  null &&
                                  namespace.
                                  equals(
                                    "http://www.w3.org/2000/xmlns/")) {
                                if (specifiedPrefix ==
                                      null &&
                                      attr.
                                      getNodeName(
                                        ).
                                      equals(
                                        "xmlns")) {
                                    return value;
                                }
                                else
                                    if (attrPrefix !=
                                          null &&
                                          attrPrefix.
                                          equals(
                                            "xmlns") &&
                                          attr.
                                          getLocalName(
                                            ).
                                          equals(
                                            specifiedPrefix)) {
                                        return value;
                                    }
                            }
                        }
                    }
                    return null;
                }
            case org.w3c.dom.Node.
                   ENTITY_NODE:
            case org.w3c.dom.Node.
                   NOTATION_NODE:
            case org.w3c.dom.Node.
                   DOCUMENT_FRAGMENT_NODE:
            case org.w3c.dom.Node.
                   DOCUMENT_TYPE_NODE:
                return null;
            case org.w3c.dom.Node.
                   ATTRIBUTE_NODE:
                {
                    if (this.
                          getOwnerElement(
                            ).
                          getNodeType(
                            ) ==
                          org.w3c.dom.Node.
                            ELEMENT_NODE) {
                        return getOwnerElement(
                                 ).
                          lookupNamespaceURI(
                            specifiedPrefix);
                    }
                    return null;
                }
            default:
                {
                    return null;
                }
        }
    }
    public boolean isDefaultNamespace(java.lang.String namespaceURI) {
        return false;
    }
    public java.lang.String lookupPrefix(java.lang.String namespaceURI) {
        if (namespaceURI ==
              null) {
            return null;
        }
        short type =
          this.
          getNodeType(
            );
        switch (type) {
            case org.w3c.dom.Node.
                   ENTITY_NODE:
            case org.w3c.dom.Node.
                   NOTATION_NODE:
            case org.w3c.dom.Node.
                   DOCUMENT_FRAGMENT_NODE:
            case org.w3c.dom.Node.
                   DOCUMENT_TYPE_NODE:
                return null;
            case org.w3c.dom.Node.
                   ATTRIBUTE_NODE:
                {
                    if (this.
                          getOwnerElement(
                            ).
                          getNodeType(
                            ) ==
                          org.w3c.dom.Node.
                            ELEMENT_NODE) {
                        return getOwnerElement(
                                 ).
                          lookupPrefix(
                            namespaceURI);
                    }
                    return null;
                }
            default:
                {
                    return null;
                }
        }
    }
    public boolean isSameNode(org.w3c.dom.Node other) {
        return this ==
          other;
    }
    public void setTextContent(java.lang.String textContent)
          throws org.w3c.dom.DOMException {
        setNodeValue(
          textContent);
    }
    public java.lang.String getTextContent()
          throws org.w3c.dom.DOMException {
        return getNodeValue(
                 );
    }
    public short compareDocumentPosition(org.w3c.dom.Node other)
          throws org.w3c.dom.DOMException {
        return 0;
    }
    public java.lang.String getBaseURI() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1cDXQc1XV+O5IlWf6TZCM7NtjCCA42oAUDcbAciq0fW7b+" +
       "kGQHZPB6NPtWGnt2ZjwzK69NDDGk2Iek1McYQgr2aQKUhOPgNAktIQdwWgqh" +
       "FCgOTYJpIQknCb9tnLY4hCTuvW/e7szO7jx5jjbnlMNcj+a9+9797rvv3vve" +
       "zNsjH5AptkUWm7KelFucnSa1W/rxvl+2bJps02TbHoKnCeWOn911y6kfTt0j" +
       "kaphMnNMtnsU2aadKtWS9jA5R9VtR9YVavdSmkSOfova1BqXHdXQh8lZqt2V" +
       "NjVVUZ0eI0mxwkbZ6ib1suNY6kjGoV28AYcs6mbSxJk08VXBCq3dZLpimDs9" +
       "hvkFDG2+Mqyb9vqzHVLXvVUel+MZR9Xi3arttGYtcpFpaDtHNcNpoVmnZat2" +
       "JVfEuu4ri9Sw+JuzPvx4/1gdU8NsWdcNh0G0B6htaOM02U1meU87NJq2t5Ob" +
       "SUU3mear7JDm7lynceg0Dp3m8Hq1QPoZVM+k2wwGx8m1VGUqKJBDzi1sxJQt" +
       "Oc2b6WcyQws1DsfOmAFtUx5tbrgDEO++KH7wS5vrvlVBZg2TWao+iOIoIIQD" +
       "nQyDQml6hFr2qmSSJodJvQ4DPkgtVdbUXXy0G2x1VJedDJhATi34MGNSi/Xp" +
       "6QpGErBZGcUxrDy8FDMq/teUlCaPAtZGD6uLsBOfA8BaFQSzUjLYHmep3Kbq" +
       "SWZHhRx5jM3roQKwVqepM2bku6rUZXhAGlwT0WR9ND4IxqePQtUpBpigxWwt" +
       "pFHUtSkr2+RRmnDIvGC9frcIak1likAWh5wVrMZaglGaHxgl3/h80Lvyzpv0" +
       "tbpEYiBzkioayj8NmBYGmAZoiloU5oHLOH1p9z1y45P7JEKg8lmBym6dv//s" +
       "yWsuXnjsB26dBSXq9I1spYqTUB4cmfnK2W1LrqpAMWpMw1Zx8AuQs1nWz0ta" +
       "syZ4msZ8i1jYkis8NvDs9Z97hL4nkdouUqUYWiYNdlSvGGlT1ai1hurUkh2a" +
       "7CJTqZ5sY+VdpBruu1Wduk/7UimbOl2kUmOPqgz2N6goBU2gimrhXtVTRu7e" +
       "lJ0xdp81CSHVcJFuuK4k7n/sX4fcHh8z0jQuK7Ku6ka83zIQPw4o8znUhvsk" +
       "lJpGPCuD0VyyNbEssTyxLG5bStywRuMyWMUYjWfTWjzppOMWTcWTRnoZ3rf3" +
       "9SxrH+pJ0pSc0ZxeMD8bKtN2GFOYy6iYXvBeLWiP5v8bSbKos9k7YjEYzrOD" +
       "zkQDprWGlqRWQjmYWd1x8tHEC66h4uTi2nZIB4jT4orTAuK0gAgtIE4LF6fl" +
       "zMQhsRiTYg6K5RoUmMM2cCzg2acvGbxx3ZZ9iyvAks0dlTCWWPWCokjX5nmg" +
       "XNhIKEdeGTj18ou1j0hEAic1ApHOCzfNBeHGjZaWodAk+LuwwJNzvvHwUFNS" +
       "DnLs3h17Nt5yKZPDH0GwwSng/JC9H/1+vovmoOco1e6svW9/ePSe3YbnQwpC" +
       "Ui6SFnGia1ocHPMg+ISytEl+LPHk7maJVIK/Ax/vyDAnwX0uDPZR4KJac+4e" +
       "sdQA4JRhpWUNi3I+utYZs4wd3hNmjPXsfg4MsYRz9kK4VvJJzP7F0kYT6VzX" +
       "eNFmAihYOPn0oHnoJy+9czlTdy7yzPKlDIPUafV5O2ysgfm1es8EhyxKod5/" +
       "3Nt/190f7N3E7A9qnFeqw2akbeDl0KoN689/sP21N9948FUpb7MkW4hNEmBD" +
       "8/bEACepgXtAY2neoIMxqilVHtEozo3fzzr/ssfev7POHX4NnuSs5+KJG/Ce" +
       "f2I1+dwLm08tZM3EFAzSnqq8aq7nn+21vMqy5J0oR3bP8XO+/Jx8CGII+G1b" +
       "3UWZK65k0CsZ8nkOmY3OYsflCnqHFkypKM+FoKyOtYqxusWN1fj8kzZOA99E" +
       "x5xzMDNiO/2WmoaRG+cR8Wjjqe3PVO9qz0W7UixuzfV2z8tPrP1VgllGDToE" +
       "fI6dzfBN9VXWqM8s69yhOw3/xeD6I144ZPjAjS0NbTzANeUjnGlmQfolgpS0" +
       "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" +
       "SgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GAFf7rFIy7ERGJ5TagKXc5VbT6T2utvv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "RcT39j3v26++TccH0rhCDJPSo8UtB8XUPOl4yUGR+5+fQD7ni+LP1aiFc/2q" +
       "PeRXXT3kmw+k3SyEkJTusuLeufspR4ur8Dfv3nO9++qN9XjsO/XG7+7LBccJ" +
       "n396UJyBUJaQEmnnYKMtvXWgZopWPlKBxwKx/nHZ4pB9UkHP+cb5Z1NB37Wv" +
       "oO+6mgo6P585OnDX6ai463SU7LzyHRgvfY+puC36o3vGH70axgsfuh199QHQ" +
       "dxTiK5LSA8V9fG37pbhznG+/bCcu4odP7jk/edVtuYuAj77xAOI3FeKfbJ8r" +
       "dpap5B7HSKc69Ndfti2fBtrsV3JdO7+S66rs9dsPMH5HId6blB5zg8BJwzuv" +
       "Qzn61ss2Jxh4rr1rj/qu5wn1+w6g/utCvB+gFsPr2Y+SnWvV77lsqwLLvfbx" +
       "PerHnyfUDx9A/eFCfAhMwnetetHSm6N/c9n2BK726PFd2d3f56F7/uQByJ8q" +
       "xI8nxUd4ONCQF/TOn7gE4guKgzBA26++Obqi1Te3tePPX5zheMQ9c/uaYEad" +
       "XNHCYlHktvB/LcTHktJDYEidanmy/cTndpnHqXtoRz9zWXt+CvC/bV8Pb7ua" +
       "ejjdkv/9jnV09N+2GX6zEL+6exp3FvO0Rf/aZZ/GvQ7gvWOP+Y7nyaJ//7lY" +
       "P1mI30lKjyvbT9ppx7ce2JPv5V373hPo372CaOLou/fQ3331bft/DqT9WSH+" +
       "1y6GaEnxBYPOn3wudHlS+oLP7quTxbf0nrjtI7q7D78qP/i+h+97/H2zX9t+" +
       "ePHWx1nvH5bu01PXPf0xrlP7p77odP9WPhRuEf8qKT15+EOZSene/V4BdPSZ" +
       "Xbm/TUovvbhcUroO5Km814/AmHZ7XpDv7Dmv3w060Nl8IA+Qp/PcB1rjJE9S" +
       "ume3czrLC0ApkKXYfbAwkyM733mrJ05b2XZ92WPP1Xy3ipz+tmOxTnz7IeTj" +
       "Nd3p7lPIN5UPvq9Pv+3Tze/ZfVsSNOlmU5zlvmHp3t1nLrcnLdaFv+qOZzs+" +
       "1z3U6z/z0Ifuf+3xGvaHdgqfWPwp3V558RcdO16YbL/BuPmRx3/oi//V+35r" +
       "+0Gk/wdonZRmoVoAAA==");
}
