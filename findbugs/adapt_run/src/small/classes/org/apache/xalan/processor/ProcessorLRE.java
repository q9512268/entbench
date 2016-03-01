package org.apache.xalan.processor;
public class ProcessorLRE extends org.apache.xalan.processor.ProcessorTemplateElem {
    static final long serialVersionUID = -1490218021772101404L;
    public void startElement(org.apache.xalan.processor.StylesheetHandler handler,
                             java.lang.String uri,
                             java.lang.String localName,
                             java.lang.String rawName,
                             org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        try {
            org.apache.xalan.templates.ElemTemplateElement p =
              handler.
              getElemTemplateElement(
                );
            boolean excludeXSLDecl =
              false;
            boolean isLREAsStyleSheet =
              false;
            if (null ==
                  p) {
                org.apache.xalan.processor.XSLTElementProcessor lreProcessor =
                  handler.
                  popProcessor(
                    );
                org.apache.xalan.processor.XSLTElementProcessor stylesheetProcessor =
                  handler.
                  getProcessorFor(
                    org.apache.xalan.templates.Constants.
                      S_XSLNAMESPACEURL,
                    "stylesheet",
                    "xsl:stylesheet");
                handler.
                  pushProcessor(
                    lreProcessor);
                org.apache.xalan.templates.Stylesheet stylesheet;
                try {
                    stylesheet =
                      getStylesheetRoot(
                        handler);
                }
                catch (javax.xml.transform.TransformerConfigurationException tfe) {
                    throw new javax.xml.transform.TransformerException(
                      tfe);
                }
                org.apache.xml.utils.SAXSourceLocator slocator =
                  new org.apache.xml.utils.SAXSourceLocator(
                  );
                org.xml.sax.Locator locator =
                  handler.
                  getLocator(
                    );
                if (null !=
                      locator) {
                    slocator.
                      setLineNumber(
                        locator.
                          getLineNumber(
                            ));
                    slocator.
                      setColumnNumber(
                        locator.
                          getColumnNumber(
                            ));
                    slocator.
                      setPublicId(
                        locator.
                          getPublicId(
                            ));
                    slocator.
                      setSystemId(
                        locator.
                          getSystemId(
                            ));
                }
                stylesheet.
                  setLocaterInfo(
                    slocator);
                stylesheet.
                  setPrefixes(
                    handler.
                      getNamespaceSupport(
                        ));
                handler.
                  pushStylesheet(
                    stylesheet);
                isLREAsStyleSheet =
                  true;
                org.xml.sax.helpers.AttributesImpl stylesheetAttrs =
                  new org.xml.sax.helpers.AttributesImpl(
                  );
                org.xml.sax.helpers.AttributesImpl lreAttrs =
                  new org.xml.sax.helpers.AttributesImpl(
                  );
                int n =
                  attributes.
                  getLength(
                    );
                for (int i =
                       0;
                     i <
                       n;
                     i++) {
                    java.lang.String attrLocalName =
                      attributes.
                      getLocalName(
                        i);
                    java.lang.String attrUri =
                      attributes.
                      getURI(
                        i);
                    java.lang.String value =
                      attributes.
                      getValue(
                        i);
                    if (null !=
                          attrUri &&
                          attrUri.
                          equals(
                            org.apache.xalan.templates.Constants.
                              S_XSLNAMESPACEURL)) {
                        stylesheetAttrs.
                          addAttribute(
                            null,
                            attrLocalName,
                            attrLocalName,
                            attributes.
                              getType(
                                i),
                            attributes.
                              getValue(
                                i));
                    }
                    else
                        if ((attrLocalName.
                               startsWith(
                                 "xmlns:") ||
                               attrLocalName.
                               equals(
                                 "xmlns")) &&
                              value.
                              equals(
                                org.apache.xalan.templates.Constants.
                                  S_XSLNAMESPACEURL)) {
                            
                        }
                        else {
                            lreAttrs.
                              addAttribute(
                                attrUri,
                                attrLocalName,
                                attributes.
                                  getQName(
                                    i),
                                attributes.
                                  getType(
                                    i),
                                attributes.
                                  getValue(
                                    i));
                        }
                }
                attributes =
                  lreAttrs;
                try {
                    stylesheetProcessor.
                      setPropertiesFromAttributes(
                        handler,
                        "stylesheet",
                        stylesheetAttrs,
                        stylesheet);
                }
                catch (java.lang.Exception e) {
                    if (stylesheet.
                          getDeclaredPrefixes(
                            ) ==
                          null ||
                          !declaredXSLNS(
                             stylesheet)) {
                        throw new org.xml.sax.SAXException(
                          org.apache.xalan.res.XSLMessages.
                            createWarning(
                              org.apache.xalan.res.XSLTErrorResources.
                                WG_OLD_XSLT_NS,
                              null));
                    }
                    else {
                        throw new org.xml.sax.SAXException(
                          e);
                    }
                }
                handler.
                  pushElemTemplateElement(
                    stylesheet);
                org.apache.xalan.templates.ElemTemplate template =
                  new org.apache.xalan.templates.ElemTemplate(
                  );
                if (slocator !=
                      null)
                    template.
                      setLocaterInfo(
                        slocator);
                appendAndPush(
                  handler,
                  template);
                org.apache.xpath.XPath rootMatch =
                  new org.apache.xpath.XPath(
                  "/",
                  stylesheet,
                  stylesheet,
                  org.apache.xpath.XPath.
                    MATCH,
                  handler.
                    getStylesheetProcessor(
                      ).
                    getErrorListener(
                      ));
                template.
                  setMatch(
                    rootMatch);
                stylesheet.
                  setTemplate(
                    template);
                p =
                  handler.
                    getElemTemplateElement(
                      );
                excludeXSLDecl =
                  true;
            }
            org.apache.xalan.processor.XSLTElementDef def =
              getElemDef(
                );
            java.lang.Class classObject =
              def.
              getClassObject(
                );
            boolean isExtension =
              false;
            boolean isComponentDecl =
              false;
            boolean isUnknownTopLevel =
              false;
            while (null !=
                     p) {
                if (p instanceof org.apache.xalan.templates.ElemLiteralResult) {
                    org.apache.xalan.templates.ElemLiteralResult parentElem =
                      (org.apache.xalan.templates.ElemLiteralResult)
                        p;
                    isExtension =
                      parentElem.
                        containsExtensionElementURI(
                          uri);
                }
                else
                    if (p instanceof org.apache.xalan.templates.Stylesheet) {
                        org.apache.xalan.templates.Stylesheet parentElem =
                          (org.apache.xalan.templates.Stylesheet)
                            p;
                        isExtension =
                          parentElem.
                            containsExtensionElementURI(
                              uri);
                        if (false ==
                              isExtension &&
                              null !=
                              uri &&
                              (uri.
                                 equals(
                                   org.apache.xalan.templates.Constants.
                                     S_BUILTIN_EXTENSIONS_URL) ||
                                 uri.
                                 equals(
                                   org.apache.xalan.templates.Constants.
                                     S_BUILTIN_OLD_EXTENSIONS_URL))) {
                            isComponentDecl =
                              true;
                        }
                        else {
                            isUnknownTopLevel =
                              true;
                        }
                    }
                if (isExtension)
                    break;
                p =
                  p.
                    getParentElem(
                      );
            }
            org.apache.xalan.templates.ElemTemplateElement elem =
              null;
            try {
                if (isExtension) {
                    elem =
                      new org.apache.xalan.templates.ElemExtensionCall(
                        );
                }
                else
                    if (isComponentDecl) {
                        elem =
                          (org.apache.xalan.templates.ElemTemplateElement)
                            classObject.
                            newInstance(
                              );
                    }
                    else
                        if (isUnknownTopLevel) {
                            elem =
                              (org.apache.xalan.templates.ElemTemplateElement)
                                classObject.
                                newInstance(
                                  );
                        }
                        else {
                            elem =
                              (org.apache.xalan.templates.ElemTemplateElement)
                                classObject.
                                newInstance(
                                  );
                        }
                elem.
                  setDOMBackPointer(
                    handler.
                      getOriginatingNode(
                        ));
                elem.
                  setLocaterInfo(
                    handler.
                      getLocator(
                        ));
                elem.
                  setPrefixes(
                    handler.
                      getNamespaceSupport(
                        ),
                    excludeXSLDecl);
                if (elem instanceof org.apache.xalan.templates.ElemLiteralResult) {
                    ((org.apache.xalan.templates.ElemLiteralResult)
                       elem).
                      setNamespace(
                        uri);
                    ((org.apache.xalan.templates.ElemLiteralResult)
                       elem).
                      setLocalName(
                        localName);
                    ((org.apache.xalan.templates.ElemLiteralResult)
                       elem).
                      setRawName(
                        rawName);
                    ((org.apache.xalan.templates.ElemLiteralResult)
                       elem).
                      setIsLiteralResultAsStylesheet(
                        isLREAsStyleSheet);
                }
            }
            catch (java.lang.InstantiationException ie) {
                handler.
                  error(
                    org.apache.xalan.res.XSLTErrorResources.
                      ER_FAILED_CREATING_ELEMLITRSLT,
                    null,
                    ie);
            }
            catch (java.lang.IllegalAccessException iae) {
                handler.
                  error(
                    org.apache.xalan.res.XSLTErrorResources.
                      ER_FAILED_CREATING_ELEMLITRSLT,
                    null,
                    iae);
            }
            setPropertiesFromAttributes(
              handler,
              rawName,
              attributes,
              elem);
            if (!isExtension &&
                  elem instanceof org.apache.xalan.templates.ElemLiteralResult) {
                isExtension =
                  ((org.apache.xalan.templates.ElemLiteralResult)
                     elem).
                    containsExtensionElementURI(
                      uri);
                if (isExtension) {
                    elem =
                      new org.apache.xalan.templates.ElemExtensionCall(
                        );
                    elem.
                      setLocaterInfo(
                        handler.
                          getLocator(
                            ));
                    elem.
                      setPrefixes(
                        handler.
                          getNamespaceSupport(
                            ));
                    ((org.apache.xalan.templates.ElemLiteralResult)
                       elem).
                      setNamespace(
                        uri);
                    ((org.apache.xalan.templates.ElemLiteralResult)
                       elem).
                      setLocalName(
                        localName);
                    ((org.apache.xalan.templates.ElemLiteralResult)
                       elem).
                      setRawName(
                        rawName);
                    setPropertiesFromAttributes(
                      handler,
                      rawName,
                      attributes,
                      elem);
                }
            }
            appendAndPush(
              handler,
              elem);
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new org.xml.sax.SAXException(
              te);
        }
    }
    protected org.apache.xalan.templates.Stylesheet getStylesheetRoot(org.apache.xalan.processor.StylesheetHandler handler)
          throws javax.xml.transform.TransformerConfigurationException {
        org.apache.xalan.templates.StylesheetRoot stylesheet;
        stylesheet =
          new org.apache.xalan.templates.StylesheetRoot(
            handler.
              getSchema(
                ),
            handler.
              getStylesheetProcessor(
                ).
              getErrorListener(
                ));
        if (handler.
              getStylesheetProcessor(
                ).
              isSecureProcessing(
                ))
            stylesheet.
              setSecureProcessing(
                true);
        return stylesheet;
    }
    public void endElement(org.apache.xalan.processor.StylesheetHandler handler,
                           java.lang.String uri,
                           java.lang.String localName,
                           java.lang.String rawName)
          throws org.xml.sax.SAXException {
        org.apache.xalan.templates.ElemTemplateElement elem =
          handler.
          getElemTemplateElement(
            );
        if (elem instanceof org.apache.xalan.templates.ElemLiteralResult) {
            if (((org.apache.xalan.templates.ElemLiteralResult)
                   elem).
                  getIsLiteralResultAsStylesheet(
                    )) {
                handler.
                  popStylesheet(
                    );
            }
        }
        super.
          endElement(
            handler,
            uri,
            localName,
            rawName);
    }
    private boolean declaredXSLNS(org.apache.xalan.templates.Stylesheet stylesheet) {
        java.util.List declaredPrefixes =
          stylesheet.
          getDeclaredPrefixes(
            );
        int n =
          declaredPrefixes.
          size(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            org.apache.xalan.templates.XMLNSDecl decl =
              (org.apache.xalan.templates.XMLNSDecl)
                declaredPrefixes.
                get(
                  i);
            if (decl.
                  getURI(
                    ).
                  equals(
                    org.apache.xalan.templates.Constants.
                      S_XSLNAMESPACEURL))
                return true;
        }
        return false;
    }
    public ProcessorLRE() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "r+ssS99kif5f8JxZKUobAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+zsWF3vvXsfu8uy9+4Cu+sKCwsXYRn8dabz6IyrwrTT" +
       "zkyn05lpO4+Oj0vfj+n7NZ3iKhAVIgkSXRAVN8ZgQMIrRiJG0VWiYDQmGuIr" +
       "CsaYiCKJ/OEj4uu083vfexdWjZP0zOnp95zzfX7Ot+f0I1+BLkchVPE9e6fb" +
       "XnygZvGBZTcP4p2vRgcU3ZyKYaQquC1GEQ/absqv/MS1f/7au43rF6Era+hF" +
       "out6sRibnhuxauTZqarQ0LWTVsJWnSiGrtOWmIpwEps2TJtR/CQNveBU1xi6" +
       "QR+xAAMWYMACXLIAd0+oQKcXqm7i4EUP0Y2jAPp+6AINXfHlgr0YevzsIL4Y" +
       "is7hMNNSAjDC3cX9AghVds5C6BXHsu9lvkXg91Tgp3/ie6//4l3QtTV0zXS5" +
       "gh0ZMBGDSdbQfY7qSGoYdRVFVdbQA66qKpwamqJt5iXfa+jByNRdMU5C9VhJ" +
       "RWPiq2E554nm7pML2cJEjr3wWDzNVG3l6O6yZos6kPWhE1n3EpJFOxDwXhMw" +
       "FmqirB51ubQxXSWGXn6+x7GMN0aAAHS96qix4R1PdckVQQP04N52tujqMBeH" +
       "pqsD0steAmaJoUfvOGiha1+UN6Ku3oyhR87TTfePANU9pSKKLjH0kvNk5UjA" +
       "So+es9Ip+3yF+fZ3vdkduBdLnhVVtgv+7wadHjvXiVU1NVRdWd13vO919HvF" +
       "hz79josQBIhfco54T/PL3/fVN77+sWc/t6f55tvQTCRLleOb8gek+//wpfgT" +
       "nbsKNu72vcgsjH9G8tL9p4dPnsx8EHkPHY9YPDw4evgs+zvCWz6sfvkidO8Q" +
       "uiJ7duIAP3pA9hzftNWwr7pqKMaqMoTuUV0FL58PoaugTpuuum+daFqkxkPo" +
       "kl02XfHKe6AiDQxRqOgqqJuu5h3VfTE2ynrmQxB0FVzQfeBqQ/tf+R9DBmx4" +
       "jgqLsuiargdPQ6+QvzCoq4hwrEagroCnvgdnInCab7VuIjfRmwgchTLshTos" +
       "Aq8w1P1D2A894KiRFxYD7Ws0SxwUHuf/P86VFXJf3164AEzy0vOAYINYGni2" +
       "ooY35acTjPjqx27+3sXjADnUWAy9Bkx4sJ/woJzw4HjCg9MTQhculPO8uJh4" +
       "b3ZgtA0IfwCM9z3BfQ/1pne88i7gb/72EtB4QQrfGZ/xE8AYlrAoA6+Fnn3f" +
       "9q2LH6hehC6eBdqCWdB0b9F9WsDjMQzeOB9gtxv32tu/9M8ff+9T3kmonUHu" +
       "QwS4tWcRwa88r9ZCJQrAxJPhX/cK8ZM3P/3UjYvQJQALAApjEbguQJnHzs9x" +
       "JpKfPELFQpbLQGDNCx3RLh4dQdm9sRF625OW0t73l/UHoFO/zun/4umL/KJ8" +
       "8d4/CqOdk6JE3e/g/J/50z/4u3qp7iOAvnZqyePU+MlToFAMdq0M/wdOfIAP" +
       "VRXQ/eX7pj/+nq+8/btKBwAUr7rdhDeKEgdgAEwI1PxDnwv+7Itf+MDnL544" +
       "TQxWxUSyTTnbC/lf4HcBXP9ZXIVwRcM+oB/ED1HlFcew4hczf8sJbwBgbBB4" +
       "hQfdmLuOp5iaKUq2Wnjsv197de2T//Cu63ufsEHLkUu9/usPcNL+TRj0lt/7" +
       "3n95rBzmglwscCf6OyHbo+aLTkbuhqG4K/jI3vpHL/vJz4o/A/AXYF5k5moJ" +
       "Y1CpD6g0YLXURaUs4XPPkKJ4eXQ6EM7G2qlE5Kb87s//4wsX//jrXy25PZvJ" +
       "nLb7WPSf3LtaUbwiA8M/fD7qB2JkALrGs8x3X7ef/RoYcQ1GlAu4mIQAc7Iz" +
       "XnJIffnqn//mZx560x/eBV0koXttT1RIsQw46B7g6WpkALjK/De8ce/N27tB" +
       "cb0UFbpF+L2DPFLeXQIMPnFnrCGLROQkXB/5t4ktve2v//UWJZQoc5v191z/" +
       "NfyR9z+Kf+eXy/4n4V70fiy7FYdB0nbSF/mw808XX3nlty9CV9fQdfkwI1yI" +
       "dlIE0RpkQdFRmgiyxjPPz2Y0++X7yWM4e+l5qDk17XmgOcF/UC+oi/q957Cl" +
       "xJc3gOvbDrHl285jS7ka3F/auGDpgPZAivXOv3n37//oq74IdENBl9OCb6CS" +
       "6ydETFJknT/8kfe87AVP/9U7y8j/8uxjP/UHcvY3xahvLOd/vCxvFMVrSgNf" +
       "BLgQlflrDEQxXdEuuX0CZOhRmbMuQCYLTDgf9p7bFaah6QAsSw9TKfipB7+4" +
       "ef+XPrpPk87b/Ryx+o6nf+S/Dt719MVTyemrbskPT/fZJ6glqy8s+S0i6fHn" +
       "mqXsQf7tx5/61Q899fY9Vw+eTbUI8Cbx0T/+j98/eN9f/e5tVvNLNrDCHvWL" +
       "sl4U3X2stO4YV0/umbsA4PcycoAeVIt7/vamuKuovrYo+kUxODLEw5Yt3ziC" +
       "5ENz3LBstOz/kvi0D+yz8XNMPvENM1neYWCxmIrVn/5UcfM9z4/VRwtWOS8J" +
       "ZZUWo3hcwrqqFNwWFOP/MWfx/X8xaETD7tGPrgkqsp1nmaNN0ApjsW2ikfv6" +
       "FtPFlatiBtMjmN5ubM7rEwsOu9wGkQS0iq53cIRyLVSGJXHEETojYoRnmoLN" +
       "YPqCC6q91VAPjKDGzxY1W2Ipu6vibFTtMSLL+KOZzU3608yxfafeyKN6gsZ1" +
       "zSWJVcDxap2B4069nufTFaoxOVMh2aWAOeEMW8y5mcMKGSJ6Zt6s44JI+cs1" +
       "OR5X4zEW8QPYzRs8wms7a92vcmS6tFp6H0fMxohi2rawkTOVIZQlz428oSWg" +
       "Y0rw2KaK8cvtGN/wyxrZqM5zSSJCIElO+bUdO8ZXHjFsjAKMGI4TrkPJVBTr" +
       "I7xJiGvG6W/4VdJ2xWGgj+0Bb9SQfmJx/XXURjk/3tbyMRV4eUR0RVKm6CFn" +
       "6abT4qlxjHGrxaRfyZaMQWPkzErmC0kwmI2yXK9No7F2RnyrrfUDY7P2dSMY" +
       "+X0EkxjJyYKdiS+HgYW7yxorj2nZYJuEyhLVfM6M5/0pseRnY7OxNuZLFaaN" +
       "hbdqoIv1iFoLnciwAhZfibMRwc/glaAnfYLGyXhKKl2BymRenSCTfl1u0qiy" +
       "zmKkQrNNsc+iHVirrKZtGyPpVjCrccaC3c5sHM85fCuRJt+MnElk4/OkExAe" +
       "aVTVbDhLRtM+hYKWeaW2xCicIAb0dLYTuUlPEh1xl26pSc5wQ58Y12jJRCd6" +
       "lLYXGbY0BvBabFRaC7Te5V1BZuwo0B2MWA2n68hOd0pkBtmECF1ugmTtRUPv" +
       "MqKJ4UJv6QS+Ri67+IJnZtUZW5s2t+SQmqIzjevqNbzaxzN7M/ZiaZ6YvYTU" +
       "jK0VMOtprb3Quos5Nd6y9nBpOm4jo7omvKhI+aYtwwvLmg8GNUyqcd2RPm5w" +
       "pLEM4JzVg1TOFHXcYKzepruUo2VGNVcjvanu8CGB9aYdjMwdu9NudoLWWpvz" +
       "dL0vOuh0pkyleIuPKJPTWr5dEepS3sitXcCG/cThqZoWhxPgBDVkWRFpDJn5" +
       "IKQ2UmM84dpu4sJwLiiTBhdjCybo45sFw3GCbgU+QYsDGrekZMt5CDYc2YzN" +
       "4QvRWafLTo/VuvJmsRqv89SS2QnP+FwajWzc0qoDor3AsN6CHfE5DVas3HWX" +
       "WI/GXK4qD0mZWNnyoC42DBjBO1i3QmC0MOjppulFQUAm2x2D+u2W3ScmTEKu" +
       "9VBtkaFA4FRoT5BhKLRia9SeOENBqHl5O5qRs7EwbexCLBKxUeD3F7OZ1vCr" +
       "cYP1sokLZ+g8SpL2etYgukmfQwZZd74bLZb8ur8lWGawyWIx9JFJKo96FicO" +
       "Jb6Pp7pHG6mJD6W1PqIX+o6OdFznhYmlsYbkStvlBh1qVUxrR0sWrXRULcEM" +
       "azdk6lVvsMsmHKvYtRHjkDtZlocVqpGpLapdgReuF5jDYZda1WZWZ2dWKWNJ" +
       "DgzGq/qUTgTNnTfubdSBjHH9cOBYZovpqa6F1McW0p4QbZLUMWKuCYkZtXyK" +
       "DTuVdY2RolXFyhudNmwkuVwHoEUbNToa87qn91attGLJGtHUxkSzxbhKXekT" +
       "fBPM1c0Irpt3+7MAVtPNTNjws4ZXRavzbUOyHJ+YkdNwNFMobuxg3qzSGOOo" +
       "HEyifLOZa72tKOtbeJKy8MqS0Hql1kkEiq2DF/XeHMV1h2dbDU8eBX0JmydK" +
       "v5bJXaE1bVbjSbrdiCkao4NZ1/NIhF1Hfn+cb7tZA9vljfpaQdJVvVlnmRRj" +
       "aluKxNJNvT5LbCOic6XT89tdbdrppdnMbHW5gZn4Tr8FO/4Mo/1dlMruvNci" +
       "h7q/tLdMv7kYatYmwfPqaG0527AdkEGz0UkmPVvJFTzaNqoSHZnbZaNdg9c6" +
       "1mw1NZRSTcEZMjTXUsIppTKN6XiySJnG1ugD5ERX9Ya/dVcGN+miw57jhzu8" +
       "L3TNtd4hBlMdlbdLgZfUphvXsawq8svK2G+prN9eUqagqZUR1242mbzWNJEW" +
       "j3C1ChzrMUp4DQPtrjYVpe7DLSUSXaGV0wxm2EanutQXeXfIK9N4kIVz325Y" +
       "XoRsU9o0uHiiI90pHsV2Pw/0gKpradzONYFWObOBr+eBY2IxYVu4x46GSn87" +
       "6ZK+WIn92mpYMQRDDxy+NjO8pVdVFUdBFHpmauMuN4Hd6Spn+PZabSrkcFZB" +
       "ndpUmODtXr+24dFAqmVNpdKeNlPK7cwzIm004kxoJpMQXqpuNdRSutmx1eHI" +
       "WFISso00rZ814ShAm6iZjOuNOb8L692duc27tJ6gbZ83pfagv/VhssqSqQgE" +
       "w1J1sCGp6iZPDE6aKrSvi8OQrwdyXaK3qDgPseZyC9sDZ9mZTdbLDqo7C5pv" +
       "1imtRi5YutUi0VoNqTF128r9JToScrI2WcwMgplExmCaW9VWKi9XXQkszAKp" +
       "19h0TDg21+FYn6jXthVm0NxsJU3tsM1UD+u50UEHK7biYSNpuQpphLfoFSvs" +
       "kqGBT7BNlIryllxvFgs8skfDqI4H7hybTWY7KUTqie5sQUaD1KUdRS+JGloN" +
       "sTXT8Z3Nrtnlu7TZU0yl6TvrXW0bk8MsUWiLkPCW2q4hWxiu5aGRE/3WeFll" +
       "+52sN4n8NEkYbVMBazjfk/2gM99yKd+abtEkpCdNuN3qO8mG73CazDe2E91y" +
       "G/LEcsFCIqokxm6YpKkO3MxoIxGiicaqH6lub4zGMKxMlQpqL2uq05G2kYyu" +
       "0UoD7Wg9ttZBK/MIXSwrXbcPoKXTHaWdEAbZg7rzZVnbamrWrIBVdKSyUcAH" +
       "4S402WTTGfUS8P7bcd0xmjWJOoHXlaoS9jd9jJL8pIZErTBY9/qNytZ3Mn2N" +
       "LKdVHeus+qLdratG2pki7EgYtNlurQOyCWNHOk1sirKRusn9cai7UgeZC12b" +
       "XwAEGg4idcjackdu6tpUcQVCoUivI6+olEimtfXa7vjsfO4iQBckhW56NRru" +
       "mWkILyTJRoVpxDDDONe0tG7Wd4Gm5baaiZS1Xa1Ha6G3aks+00T8EV/dcXp1" +
       "nNXntSkriHOjEXrr1qyhxKaK7KwBzMsj0h5izczsLeiR4Mk23krSzc7QU9PX" +
       "YSSilpZEDjlmZBhLL2VNfpF2NzFZnWy2yqoy66u5NV7QgroxoqBGbMIhOcpm" +
       "LQ+l1gRLuVV/gsZOFC/QZWsaoktzy7Y6XM8abOoDDuvs2r0JFhCrGWNWEhUo" +
       "VZhWOgRV6SHBrjmRFuANZDcKJ5SHTUOE5rgonUWVxFvOB7PYbmOwnOv+sCob" +
       "oozvsKHn2kEGlgVEmjlrZN7pwzqya+q1qSQbc9TqUSGxYWb8KpjrU1TRomGf" +
       "nCKNOtWuVvo10QmIaXVJwLPFquPQJlsd1fwM61fGOIPgBOrhIW/7poKsMFmu" +
       "MMNEGLhcT0toJJGCNCHaDS5bLwdIP5+oQmbmsWHJEtIzl0g+no49sAInBKVv" +
       "gmwU2wbnaEiSCo1OsIq368BWbWMZWbJdXxhDMnH6065VkfXxrkHpvt3mZSRr" +
       "2majNpVXwyYvqDxGLXgcm49pprqyVizRX7rzDbqrsDgaVPMZiSMBwkiKFFo2" +
       "rE2mTtzFBikp+50pNnPqJLyrtEHyxlikvMyzUKzsBDQPVik2dky0sbHJtiYi" +
       "bqLgdRnLHBWpWAO1lU6GMFvDFCmxbGHc18DrLNywM7e7SjsrBgfJaTutzzjC" +
       "nUcDnsvgNjVs87WuumF6A7I+cz0E7qxaLTmODYr3piIe8HXCtN18ujXXdUu0" +
       "tgs/W9eVyErIydhNEZGwBnEqt2W8NqmiAIKToesT7MiZiwxZb6smu8gnmmtP" +
       "pOHIyRRtUG+Nd3PaFQQHVWkiyBKaEPSqEtmzZp5STgPxu3BdojqirFZq3cZ8" +
       "5Y1D1dCJ3szqI2t2t6b56siNOIQLJYRYeIoytrgFiLkO3NdSbBSuu7NVZoRs" +
       "ZeS1BHVqyb7YaoRGm/b8IbLo9jr9UBLUJWpFTMBkc8IKF1GMMhNOTHxcs0Lw" +
       "AmDpeW+EzOSYjzq8DfLOjZK01p16thUxGAcBELiC53fQOcwt6vXUWS4tjaj6" +
       "4D1kOcxIxF0paeJR02gehZUo4jqdjak1tTaVrUdzTwJvs99RvOYqz+9V+4Fy" +
       "V+D4wO7wDVt4Hm/Y+0ePF8Wrz258Xzl/yHNqc+rU5iBUbLq87E7ncOWGywfe" +
       "9vQzyuTnaxcPN1UnMXRP7Pnfaqupap/bZ3zdnTeXxuUx5Mlm32ff9veP8t9p" +
       "vOl5HGe8/Byf54f8hfFHfrf/LfKPXYTuOt76u+WA9GynJ89u+N0bqnESuvyZ" +
       "bb+XHWv2nkJjJriIQ832bn+kcFsvuFB6wd725/asL5cEl492g17/HIdOXLyz" +
       "1chQ1Xgguoq931kVToqjMR4qxsgc+yASs4NuHIemlMRqVE6fn5v+wuGZ1GHX" +
       "R0535borIpNVvzBN2fktRZHE0H1AgWFcfAqgHp7aU6e8lYmhS6lnKidunH69" +
       "jaLT+9dlQ3is94eLxtcCFt+w77v//0b1DvwV6C9W5VhVbqv+Cyf2eXNJ8O7n" +
       "VlCzPF0sVRSHohsVR1MH/FFNDXHP1Uw9CfcfS5zR3o8VxY+A0NfV+MSUrOfF" +
       "R4O/+hbjx6rj2yIw3injn+j1nf8LvZb+zALJuEO9sv83/nxpDwilQs/5Z0n/" +
       "s3c2wFtLgp8rip+OoXtVVzl0saLlB0/Efv//QuwSJB8DEyqHYivPz52u+qGZ" +
       "AoN8PWd6b0nw0ec4oPp4UXwwhl5YgJUYqsqKoxnudtF0VfI8WxXdEw186Plo" +
       "IAMBe/q8ujhwe+SWj2T2H3bIH3vm2t0PPzP/k/LI9vjji3to6G4tse3T5yOn" +
       "6lf8UNXMUqp79qclfvn3KzH06J3xbB+b+3rJ9Kf2vX4thq6f7xVDl8v/03S/" +
       "AXzkhC6Gruwrp0l+K4buAiRF9TP+UZRVv5Fzff4w8AoPzC6cXTWPzfDg1zPD" +
       "qYX2VWeWx/JTpqOlLNl/zHRT/vgzFPPmr7Z+fn/uDLwiz4tR7qahq/sj8OPl" +
       "8PE7jnY01pXBE1+7/xP3vPpo6b5/z/CJd5/i7eW3P9glHD8uj2LzTz38S9/+" +
       "wWe+UJ5K/TdmHOHfYyYAAA==");
}
