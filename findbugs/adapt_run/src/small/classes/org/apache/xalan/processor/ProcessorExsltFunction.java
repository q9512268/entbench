package org.apache.xalan.processor;
public class ProcessorExsltFunction extends org.apache.xalan.processor.ProcessorTemplateElem {
    static final long serialVersionUID = 2411427965578315332L;
    public void startElement(org.apache.xalan.processor.StylesheetHandler handler,
                             java.lang.String uri,
                             java.lang.String localName,
                             java.lang.String rawName,
                             org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        java.lang.String msg =
          "";
        if (!(handler.
                getElemTemplateElement(
                  ) instanceof org.apache.xalan.templates.Stylesheet)) {
            msg =
              "func:function element must be top level.";
            handler.
              error(
                msg,
                new org.xml.sax.SAXException(
                  msg));
        }
        super.
          startElement(
            handler,
            uri,
            localName,
            rawName,
            attributes);
        java.lang.String val =
          attributes.
          getValue(
            "name");
        int indexOfColon =
          val.
          indexOf(
            ":");
        if (indexOfColon >
              0) {
            
        }
        else {
            msg =
              "func:function name must have namespace";
            handler.
              error(
                msg,
                new org.xml.sax.SAXException(
                  msg));
        }
    }
    protected void appendAndPush(org.apache.xalan.processor.StylesheetHandler handler,
                                 org.apache.xalan.templates.ElemTemplateElement elem)
          throws org.xml.sax.SAXException {
        super.
          appendAndPush(
            handler,
            elem);
        elem.
          setDOMBackPointer(
            handler.
              getOriginatingNode(
                ));
        handler.
          getStylesheet(
            ).
          setTemplate(
            (org.apache.xalan.templates.ElemTemplate)
              elem);
    }
    public void endElement(org.apache.xalan.processor.StylesheetHandler handler,
                           java.lang.String uri,
                           java.lang.String localName,
                           java.lang.String rawName)
          throws org.xml.sax.SAXException {
        org.apache.xalan.templates.ElemTemplateElement function =
          handler.
          getElemTemplateElement(
            );
        validate(
          function,
          handler);
        super.
          endElement(
            handler,
            uri,
            localName,
            rawName);
    }
    public void validate(org.apache.xalan.templates.ElemTemplateElement elem,
                         org.apache.xalan.processor.StylesheetHandler handler)
          throws org.xml.sax.SAXException {
        java.lang.String msg =
          "";
        while (elem !=
                 null) {
            if (elem instanceof org.apache.xalan.templates.ElemExsltFuncResult &&
                  elem.
                  getNextSiblingElem(
                    ) !=
                  null &&
                  !(elem.
                      getNextSiblingElem(
                        ) instanceof org.apache.xalan.templates.ElemFallback)) {
                msg =
                  ("func:result has an illegal following sibling (only xsl:fallb" +
                   "ack allowed)");
                handler.
                  error(
                    msg,
                    new org.xml.sax.SAXException(
                      msg));
            }
            if ((elem instanceof org.apache.xalan.templates.ElemApplyImport ||
                   elem instanceof org.apache.xalan.templates.ElemApplyTemplates ||
                   elem instanceof org.apache.xalan.templates.ElemAttribute ||
                   elem instanceof org.apache.xalan.templates.ElemCallTemplate ||
                   elem instanceof org.apache.xalan.templates.ElemComment ||
                   elem instanceof org.apache.xalan.templates.ElemCopy ||
                   elem instanceof org.apache.xalan.templates.ElemCopyOf ||
                   elem instanceof org.apache.xalan.templates.ElemElement ||
                   elem instanceof org.apache.xalan.templates.ElemLiteralResult ||
                   elem instanceof org.apache.xalan.templates.ElemNumber ||
                   elem instanceof org.apache.xalan.templates.ElemPI ||
                   elem instanceof org.apache.xalan.templates.ElemText ||
                   elem instanceof org.apache.xalan.templates.ElemTextLiteral ||
                   elem instanceof org.apache.xalan.templates.ElemValueOf) &&
                  !ancestorIsOk(
                     elem)) {
                msg =
                  "misplaced literal result in a func:function container.";
                handler.
                  error(
                    msg,
                    new org.xml.sax.SAXException(
                      msg));
            }
            org.apache.xalan.templates.ElemTemplateElement nextElem =
              elem.
              getFirstChildElem(
                );
            while (nextElem ==
                     null) {
                nextElem =
                  elem.
                    getNextSiblingElem(
                      );
                if (nextElem ==
                      null)
                    elem =
                      elem.
                        getParentElem(
                          );
                if (elem ==
                      null ||
                      elem instanceof org.apache.xalan.templates.ElemExsltFunction)
                    return;
            }
            elem =
              nextElem;
        }
    }
    boolean ancestorIsOk(org.apache.xalan.templates.ElemTemplateElement child) {
        while (child.
                 getParentElem(
                   ) !=
                 null &&
                 !(child.
                     getParentElem(
                       ) instanceof org.apache.xalan.templates.ElemExsltFunction)) {
            org.apache.xalan.templates.ElemTemplateElement parent =
              child.
              getParentElem(
                );
            if (parent instanceof org.apache.xalan.templates.ElemExsltFuncResult ||
                  parent instanceof org.apache.xalan.templates.ElemVariable ||
                  parent instanceof org.apache.xalan.templates.ElemParam ||
                  parent instanceof org.apache.xalan.templates.ElemMessage)
                return true;
            child =
              parent;
        }
        return false;
    }
    public ProcessorExsltFunction() { super(
                                        );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IKvn1Hn94glsKfDltdnV2MOWxklsKVaD2wsf5yLtDtwsAXvnPz7+pV955GuZ" +
       "bXrAmVUud2aSy4dEwzjPSX/5qfe87EVPfP2dxcx/aH3fd+afPovnXF9XjP9Q" +
       "UV7Ji58oHLyT4UJYZLdRporpiHYh7aNZ/h4WGS2f5bmZCzkSf+5QYAJzmWHZ" +
       "ai/Rgh6782uLD3zjo9sk6qTfTxCrb3/iHd/ffdcTO0dS10euyx6P9tmmr4Wo" +
       "txXy5jPpoecapejR+aePPfbHv/vY27ZS3Xk8EWtn7xkf/av//tLu+77+hRus" +
       "66ftzAtb1M/LSl5g27lSu+m8uroV7lQGv2fKu/XdUn4/ubErbsmrP5kX3bwg" +
       "9h1xt2XLV/Yhec8dVyy7XvR/aXQ0Bra5+gkhH/2BhSzumtliwYil3/xUfvP6" +
       "FybqvbmorBsHsjoQw4gqYF1VcmlzCur/LFl0+78R1ZDE9n8UL4jlNQcnUzCu" +
       "VCU9abRHa5uZw02kPhLZUcudmFZ7OfQ3iTAa+hMq3NCV1YzwTKU7leKyO5wY" +
       "1RanN8lemwTbUYxB5NTvE+0mz4nelBv6JZZv6a2mD7M8hkusa0tzktPMMc2i" +
       "q5KDhyldp9O4Ns8eBGylV1ZoVZMb9UDLcvC40YJZgTYXE4Pm4mbTpNOxb+DB" +
       "erVgRvjYWy30GT7FUMYF+6mW+iUZHFcEKW55A1Oy6JC3cGFM0YZvyl7iIhFl" +
       "j1m8NfdIazblEq9rjWpyF9bCds+3+0NkoXdFuDcRhLYpTT157ra7aw4d+W4n" +
       "cUaeveyX4LGEbZgRCW8kKhotKqC+EEl/3OIHnDIImQVOzpdpGi8mUpB25wk3" +
       "luZ9jSOrCTtCiF6bgpe4Lwxqy40V1YTetONTdmsKTgmJU0NzspGRuVijkKlW" +
       "SZ3RtDFTqA4y6vT4pF2FadE3NkQVJtj+rB51lkt2StVVgeTGlD7H07aFjjtO" +
       "yWpSXVfoEbNI6UdNcNDh2Q0r8ssGJbPyVDQxN6Gs4cRsSe4oIqelRgdu6ks7" +
       "HYgKVaVhCh1M6ZgoL2fGQltZ6xYSB5qdYP0g6nniuOROXLNPdfTFEln325Wu" +
       "362WkpgqVRZlvzMyqh2Us0fCvFvvWrNup8+QAcZ5JG51nM285Fs0UhmjTaHd" +
       "LkMst+mMUImvtXrIDPU3utFKYV2swYFfnhmis6abnjBwe6babuEVqSe1JIFk" +
       "kcqS2wjdcjirRm2sGbBCfzOzOJQX2+YaG7Lz2pQctHS0yiIk43MES0Yc2+4q" +
       "COyqrmoEk3Gr0pqUSptQXzBwmciduwl0a0FOx61ZdTPQl+ZwuJj1OLQh+bAU" +
       "xY2ex3G9hY67RF81LcZnMFHwGF+glz5WM2a8TvESZabrFdyrS93NqG22tKrZ" +
       "Kot8Ha2rjWlLHGtq1LXitERMiCjqj8dzftKYdGdChR0ystQUja4vzsW2PofW" +
       "lT64sYJwuC4vmwtjskREclBi6M06VoIUAuG2U5OFFhchPZMT+Akrm5Zod4ai" +
       "16NQWXVHzrRZmulBXxz2V+QSkjacLTfBcafrohLXWOCUJ7IiQRHJNIBwtdrH" +
       "2mapPbPlVsNrKVMEXk+mGxAdWuMmixmqp3fDXjipN5ZJG630w6XI66Mmx7Mw" +
       "0SICf4B2Oy2aVlgMTM0GrLDrPoezg+FanI0TpWuX5KEzSgLaReej7sb1FHHQ" +
       "oMVg0Te7vk/r/qYuRPSorPoc6ZPWyDPq5RVq88YQpaQq1Cax9UTr4gaWBn5p" +
       "yldhljFdZdJHopVT9UGB5fSBEUhmdR3qvo3D0chgHM5lZpyLoqNFm8bSiiv7" +
       "0/aiSSqlbhXD3RnerdTSKIjiTdSvNkOYcQfkGCFpUw2m1hTp0z1Mg0fyKnIR" +
       "OeY3oLzQW6PBKOk3xZidZu4fLqZNjoHnIS7EXEDoNcxY0TMTSWoLLCLAihJV" +
       "mAUGN4ZSk2/q7RE2Dx1ZV3zV8Rl1BdnJpg8pDZRxPGSt8J21vMkMM8Elqtrm" +
       "6z7EEHA3afBIozRKFxKDK3OCZTt6J8ZK7XJTwUZjutEAx9iEGuJL1hpkDpHb" +
       "A35R7VNBspEHUxWNo2DFxN0eX63gzVZIUGO40XL6Ja0+HtBQnZYgqEYy6oJL" +
       "dJ8ZT1GzTnbxxDTCpkvTKB8rfmXWH01rTFKPaGKygD1kyAym2NwW45YaJRJG" +
       "jvTYxJoICspQXB+iVagxk0YTLsPSic7rDamLDCQZ3fANzMHR7qbRbhOJjnH2" +
       "cFGFlxTaW3sxQclwqmBDY5HlFB1OQpu6yk7aHjlabJaxMUOnqY2UUG+I8rxY" +
       "FWaWKVBxK15Ha6eCRr2Z4wdyySrVzblOmh1Ym2psWTTQmTGTfTpupdEIrzCz" +
       "LLnU1BJVxQOdmXYjEkMmeA8kQBLfYHilo2UBU3VpSGkbqY9PQVrYVK3JmuI6" +
       "I7ABqc7cEkB11SjDqbrRV0Rn1a6Puv1qHPabOCPUnEoXhaaiZdDDdpcwZ9mK" +
       "Oe5SMwMvl0gertRq7ADdNEUpMqZGJ/HhEtHAqZQLl8uB6SF1RF3B0xoyXbRa" +
       "fmmJBFiQwKOeJvdHFOWVxNW8JXkradgR5iokcmue6ECL1ppxFdpB1ogjwz2L" +
       "wTCcQSrVRZmDCMLXhFqXV1aqE8463Y4lbToRrMAeKkONNrFKDCSUR36DYNI5" +
       "smQklITK8Wxet1BoMeZ61pJElnpD0ypKFRxaCy/mNLlSnU28Zt32bEXGmuuZ" +
       "Uu/0EFprqnFfS6hFTykv2GAiVefllkP1+QpWilyaKG2G2Eaop4xEq2HF5wxc" +
       "UCZQB18ulTkjdGuGXokXySpOVv4mSEw9NsBwTINhBpeyMqhkLw6kMfb4ZtvQ" +
       "6ptYasjxYAzBemWdjj0WJpWaXor9Wb8H96cbxEkWIOXMqKqwYhoyztR70Kas" +
       "Mk6W5Rlwcw5C5TWoGWUCnKw1XW/SzSWkdgXd7M97oWfM7Bo/h02/v+YnvSpf" +
       "b4xVp0w2qtKUn6VjNSIHSqWn+ILVpLMcoDXHJQFSBa8cEdEKrAndFl8qMct5" +
       "0HbhLLnlK/VpY9nlsIrr2bEFW1m0J5IyrkNtzjRduRMPfILlEW3sd5rlKJbw" +
       "VbnExtPxCqHQMTFZzVUNmvRL9TrWiYaCOreFKQ1CdqjNJ0wMLy1rPkBgC62q" +
       "TtOpNxoxpbG+KaZUuda1lEawgqCZp+DjZaKkw47foeLxsGtVWzWN12qQWhZ4" +
       "JnHjIVSBHIoG4VHaiXoi548jX3HFdJ36XEzxVGppjipVTbEmjSvTYXveaqST" +
       "YRDJ1UE4NWDZXxt2ogugRJd0XB1YWKpLq3mlqtSpiMZVbKQwk5nGu4s6KE/i" +
       "dYlJUE+eNtVKLawumn1/JY48p8wpC8t3TSLFQFWabfBaazAuLUOrqcjMxA/I" +
       "ummPS8GoQah0AyId3wFbw8oMlFYEks0doS42RQcE04oJJeMyhHcSUCSb1WHD" +
       "KofNGSqpdI/2yAmVbhyuv6wsbCrR/JLRDtYlgxyucAOB21BtYAuUERLL5XxI" +
       "LqfeGunjsKL0OsNlso7ASbezWG8c0TLB8sjVBHZju/oiapZpbq3OBtMyCpmy" +
       "X9ZrvQHnwqW0T3LUegQuJn2SmniztU9PV4zgVRaCCvtQR0z7PDkkG6bQrHQx" +
       "hA+bWjQXCB0dg3DiuOssfR1yw1o9Ymx1EMeRC26CoC+Zg/V6FIDTNlLPkMeb" +
       "dAiphERElnROuy7fwRDE5vDEq1AbqmIYBK/XBMaWO4HUbzNQKGvV6WYUGi7n" +
       "0QadCq1aD4JRE5J4OB1oko3rOKgh2IiQFQvfdIxmqaazEjwxCXaJ1yG+Ek/q" +
       "Cojw6MagoXattpAktFGvLlZImYCXvEWirLUIHCa1R2iDIeYVe50aDYy0EBVj" +
       "yogMakmKViDDGvBrPLLbOArWGK2fIlx5ASlrdwZpA2VFYKyRyEJ/zi3ZqodP" +
       "V3ZDpskArGHyDJ21FNktI8MRGuCMOYVXTU6dLIYVDnLAQdjvxWu+0q7iE7xt" +
       "gUnil/slCaS52bg6byw6LMslvMC6bixK8jxwQYZgVow1asoOpeFgtyt2BlMz" +
       "s8bG9NWu74bOxCxVR1DDbPXQtu02g+nI7MkrVYvgdFZLvWGrkwzh8bwirfhE" +
       "SrsbetJA5FFrRMdqF2oHJhjBfksBB7FZBiV1Vjf7IdOT6a7DBMki2phCu0VS" +
       "hLRBXNxaQ43hWvFnmfMxxEG5iRu2weq0s0AHQza25ioB9VNrOJaDmrDu1qB+" +
       "G64htepKHdm1tNm1yWkTE0abpuH1ag3dqYjZAtNaDRf8TKZWGh3jQztESsuB" +
       "Sq03/VBKE4mkZ8iaiuwKvSQ4b93wKlY5qWfuW8mzmUsw6hgjWyRIVYRpA5+w" +
       "pU5FoZdsvzbtKm5Fc3CWY+pN24y0VVN1q0IYz62ZUCpJlkn6RGpDK7ZriWiV" +
       "XgQ9jhuN0P5EQoiZxOM1cWw6SH2sjzUC7rEspEcm0RITvV3qodU0Kg0Iz0uM" +
       "zTj2N8qGEQREs8PIY1CBcwl5SmUvC6W+aFJOoMkh3AnWIu2QY9VaTIRhWAVX" +
       "esjIDSTowmA0XMUTCFvPV80MI4nsNTd//VVe2Cv4HcVuwcEx396b9/wFvHlv" +
       "Hz2UFy8/viF+9uTR0JFNqyObhkC+GfOym53eFRsxH3rrE08q9Ifhnb3NVjoC" +
       "LkSu92pbXan2EVb5SfUrb77pRBWHl4ebgJ9767/cO3mt8cYXcMzxwAk5T7L8" +
       "PeqpL3RfIf/qDnDLwZbgdceqxztdPb4ReDFQozhwJse2A192YNkLucXMvS3B" +
       "/PdTNz5quGEUnCqiYOv7E3vZZ/YMuLdL9KrnOJZio42thoaqRoToKPZ2x3V+" +
       "WOzzuCvnkSzt3VBMdrEoCkwpjtSwGD49MfypvbOqva73HO3KYrN2Iqte7pqi" +
       "85vzIo6AWzMDBlH+AYG6d9bfOxKtwwg4vXJN5TCMV8+3gXR0X7toCA7sfuv+" +
       "Nuy1Pbu/4YXYPYvXzH6RKkeqckPz72y3V/PbN+0bYfc6H0Tq0rPFzIa7udKT" +
       "vbs9AxR8H7+xXfPbtxQET+TFOyLgNtHzVEfBHIWJw+JQ9xcPDfXOH8JQRYCO" +
       "s2u5Zyj7RxOgp7cnDIWFTgRcQf/k82n+W3nx/gi4mKm9Z7ITav/GD6t2P7vS" +
       "PbXTH43aRwLj3YXuBdVHnk/Zp/LiwxFwfiXappIFyQlVf/uHUPVi3nhXdj29" +
       "p+rTL0BV4IZaHpH/3QXBHz7HUVux1fz72fTP0TPMT61CenGj6X9Ocl1bFZ1D" +
       "tT/xQtROMgi78RF8foZ4z3VfBW2/ZJGffvLS+buf5P66OIU++NrkwgA4r8W2" +
       "ffTI50j9rBeomlmod2F7AOQVf38aAffeHIq3sLKtF+J/ZtvrsxFw+WSvCDhT" +
       "/B+l+3w2Gw7pIuDstnKU5IsRcEtGkle/5O0jU+kH+WjhKDwlp44v+AcOufP5" +
       "HHIkR3jk2MpefLu1vwrH26+3rskfe7I3fNOztQ9vj9JlW0zTnMv5AXBue6p/" +
       "sJI/dFNu+7zOEo9+7/aPX3j5ftZx+1bgw+A+ItsDNz6rbi+9qDhdTj919x+8" +
       "5nee/Gpx0Pa/kEgd4FQnAAA=");
}
