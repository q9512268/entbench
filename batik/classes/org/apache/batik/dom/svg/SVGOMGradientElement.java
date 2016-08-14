package org.apache.batik.dom.svg;
public abstract class SVGOMGradientElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGGradientElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_GRADIENT_UNITS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_SPREAD_METHOD_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_GRADIENT_TRANSFORM_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(XLINK_NAMESPACE_URI, XLINK_HREF_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns:xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected static final java.lang.String[]
      UNITS_VALUES =
      { "",
    SVG_USER_SPACE_ON_USE_VALUE,
    SVG_OBJECT_BOUNDING_BOX_VALUE };
    protected static final java.lang.String[]
      SPREAD_METHOD_VALUES =
      { "",
    SVG_PAD_VALUE,
    SVG_REFLECT_VALUE,
    SVG_REPEAT_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      gradientUnits;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      spreadMethod;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMGradientElement() { super(
                                         );
    }
    protected SVGOMGradientElement(java.lang.String prefix,
                                   org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        gradientUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_GRADIENT_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              2);
        spreadMethod =
          createLiveAnimatedEnumeration(
            null,
            SVG_SPREAD_METHOD_ATTRIBUTE,
            SPREAD_METHOD_VALUES,
            (short)
              1);
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getGradientTransform() {
        throw new java.lang.UnsupportedOperationException(
          "SVGGradientElement.getGradientTransform is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getGradientUnits() {
        return gradientUnits;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getSpreadMethod() {
        return spreadMethod;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMAElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "20PcvG/lt3i373+WkOaixysAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C6zk1nne3JW0ktaSdvWwpciSvJJWjqRxLoePmeFYlm0O" +
       "yeFjOC+S86Jrr/gaDmf4Gj6GnHHVJA5SOxXgurGcOEAsIIXjJoFiJUEDFy3S" +
       "KCjaxEgawEHQukUbuUXQunXd2kDrFnXa9HBm7nN3r7SR0Auccznn+X//+c93" +
       "/nN4+Op3C7dFYaEY+M7Kcvx438zi/ZlT3o9XgRnt80K5q4aRaZCOGkUySLuq" +
       "P/EbF3/ww89NL50rnFcK96ue58dqbPteJJqR7yxNQyhcPEqlHdON4sIlYaYu" +
       "VSiJbQcS7Ch+Tii861jVuHBFOBABAiJAQARoIwJEHJUCle42vcQl8xqqF0eL" +
       "wt8o7AmF84GeixcXHj/ZSKCGqrtrprtBAFq4I/89AKA2lbOwcPkQ+xbzNYC/" +
       "UIRe/vlPXPqtWwoXlcJF25NycXQgRAw6UQp3uaarmWFEGIZpKIV7PdM0JDO0" +
       "Vcdeb+RWCvdFtuWpcRKah0rKE5PADDd9HmnuLj3HFiZ67IeH8Ca26RgHv26b" +
       "OKoFsL7nCOsWYSNPBwAv2ECwcKLq5kGVW+e2Z8SF952ucYjxShMUAFVvd814" +
       "6h92daungoTCfduxc1TPgqQ4tD0LFL3NT0AvceHhGzaa6zpQ9blqmVfjwkOn" +
       "y3W3WaDUnRtF5FXiwrtPF9u0BEbp4VOjdGx8vtv+0Gc/6bHeuY3Mhqk7ufx3" +
       "gEqPnaokmhMzND3d3Fa861nh59T3/M5nzhUKoPC7TxXelvnaX//+Rz/w2Ot/" +
       "sC3z3uuU6WgzU4+v6l/W7vnGI+QztVtyMe4I/MjOB/8E8o35d3c5z2UBmHnv" +
       "OWwxz9w/yHxd/Gfjn/g18zvnChe4wnnddxIX2NG9uu8GtmOGjOmZoRqbBle4" +
       "0/QMcpPPFW4Hz4LtmdvUzmQSmTFXuNXZJJ33N7+BiiagiVxFt4Nn25v4B8+B" +
       "Gk83z1lQKBQugVB4HIRnC9u/p/MoLrwATX3XhFRd9WzPh7qhn+OPINOLNaDb" +
       "KaQBq59DkZ+EwAQhP7QgFdjB1NxlGL4LRUtgSgOm02JC1bBBzZwmwL/93NKC" +
       "/w99ZDnOS+neHhiCR04TgAPmDus7hhle1V9O6vT3v3r1D88dToidhuLCj4Fu" +
       "97fd7m+63Qfd7oNu96/XbWFvb9PbA3n328EGQzUHkx7Q4V3PSB/nX/jME7cA" +
       "KwvSW4Gez4Gi0I1ZmTyiCW5Dhjqw1cLrX0x/cvDjpXOFcyfpNRcZJF3Iq3dz" +
       "Ujwkvyunp9X12r346W//4LWfe9E/mmAn+Ho376+tmc/bJ04rN/R10wBMeNT8" +
       "s5fV3776Oy9eOVe4FZABIMBYBQYLuOWx032cmL/PHXBhjuU2AHjih67q5FkH" +
       "BHYhnoZ+epSyGfV7Ns/3Ah3fkxv0EyB8cmfhm/957v1BHj+wtZJ80E6h2HDt" +
       "81LwpW/+8X9CN+o+oOWLxxY6yYyfO0YFeWMXN5P+3iMbkEPTBOX+7Re7n//C" +
       "dz/9sY0BgBJPXq/DK3lMAgoAQwjU/NN/sPhXb/zZl//03KHR7MWFO4PQj8Fc" +
       "MY3sEGeeVbj7DJygw/cfiQTYxAEt5IZzpe+5vmFPbFVzzNxQ/+LiU/Bv/5fP" +
       "XtqaggNSDizpA2/ewFH6j9QLP/GHn/ifj22a2dPz1exIbUfFthR5/1HLRBiq" +
       "q1yO7Cf/5NFf+H31S4BsAcFF9trccFZho4bCZtygDf5nN/H+qTw4j94XHbf/" +
       "k1PsmNdxVf/cn37v7sH3/vH3N9KedFuOD3dLDZ7bWlgeXc5A8w+enuysGk1B" +
       "Oez19l+75Lz+Q9CiAlrUAYlFnRAQTnbCOHalb7v9X//eP3nPC9+4pXCuUbjg" +
       "+KrRUDfzrHAnMHAzmgKuyoKPfHQ7uOkdB+SdFa4Bv0l4+NoZ8FM7y/ip68+A" +
       "PH48j5661qhuVPWU+s/taC3//W7gEG5Q5j7F/tanOMh46rqsSmiAXABoyteT" +
       "nE03cn34jBGm8qi2yULy6INb6OW3pKVt2Yc2v94FhvGZGxNxI/fNjrjsof/d" +
       "cbRP/fv/dY2pbCj4Oi7JqfoK9OovPkx++Dub+kdcmNd+LLt2qQJ+7FFd5Nfc" +
       "/3HuifP/9FzhdqVwSd85yQPVSXKGUYBjGB14zsCRPpF/0snbejTPHXL9I6d5" +
       "+Fi3p1n4aIkEz3np/PnCKeJ9d67lD4EA7WwHOm12e4XNQ3treZv4Sh796NaK" +
       "8sen48L5aOOK75juL8HfHgj/Nw95g3nC1me5j9w5TpcPPacArOD3Z64jh6od" +
       "c95m8TgcKWCHT19jh5spSfmJ5qw4zzAz05BzVjuaIRtD67yZoXGHanhvnkqD" +
       "QO7UQN5ADcr11XDLRg15JMZgFGxPdTaKluLCA2oMZpUGfHTOA4tPvhcxwwNo" +
       "N3ZciOvUOoXvYzeJ7zwIox0++Qb4jDfFl0efOAB3V7/NydLVASH0aQlMz6du" +
       "PD03C8bWk3/lK0/+8Y+/8uS/23DuHXYEjJgIretsLY7V+d6rb3znT+5+9Ksb" +
       "1+RWTY225nx6T3btluvETmoj912Hankg18LDIOzt1LK3NdKr1xrpBy8vEjWy" +
       "FwlY058OgOXZ+uWtzV/eDPflLXd+7OOXWx2KvtomWrR0+fnLnpnucj6putqL" +
       "H9vf3//4c88EwUaQjxzS3d7WadiOWh45BwPi32DegSm3leLEeJx3TM+Kp2cT" +
       "ZTe0XWBTy93eC3rxvjfmv/jtX9/uq06z4qnC5mde/lt/uf/Zl88d280+ec2G" +
       "8nid7Y52I+DdGynz1fjxs3rZ1Gj8x9de/Ee/8uKnt1Ldd3JvRnuJ++v/4v/8" +
       "0f4Xv/X162wHbgFGkP+YB9mNFr37jxY90vE9M6ePg7ztvsD29w/PDkBmds1Y" +
       "hYVnb6zj1sbojlaE3//Uf35Y/vD0hZvYELzvlI5ON/mrrVe/zrxf/9lzhVsO" +
       "14drDhZOVnru5KpwITTjJPTkE2vDo1vz2+jv+ra3lz+GW5M7Y93/mTPyXsqj" +
       "nwZUqefK347VGcU/mxVOcZ/5V+A+bTfJP34D7vs7N8d9D0hdkSaoqy1aZjvU" +
       "jgM3UE7J+rNvXdaNF1gGwdrJat1A1i+eMTRPH0h4t7Xb+PbBGhIdmDd89maZ" +
       "8Gw3J7x8juXUt9suHcPzCzeJBwPB2eFxboDnl94KnruiIDRVY2vTedqXTkn2" +
       "d29Ssh/dCLP9W9xAsl95K5LdCpz/yYGCP/DWFLxdFk4h+NWbRPA8CMsdguUN" +
       "EPzmW0HwI4DCzBAsZPkJ6OYsRzQXiR2axpv7Kidg1X3fMdXTNvNbb4pruzbs" +
       "gY3zbch+db+U//6HZ8zI8NoZ+eDM0a8cLN0D4GUB270yc6p59kdOCSS9ZYEA" +
       "0d9ztFoIvmc999Kff+6P/vaTb4Clhy/ctszddsDXx/ZR7SQ/h/6br37h0Xe9" +
       "/K2XNqcCQN+Dn/nN6rfyVn/v5mA9nMOSNoMiqFHc2uziTSNHtmkiPoYnA7YI" +
       "KPW0Wb11tPF9/4bFIo44+BNglUKJPiw6kJHOp1NOoqcsTpIiQa5CvNpXPdWn" +
       "hjTRpgWFnnFqnaKUBHKikEST4qoopZg/dBvqoo8Z4kBeqMy4Uh/QTCYv4Djs" +
       "L+CF04z1ihW7vuGrcBxrg6E7rqqLwag6GdZQDYL0qj7GgsBTjHJcq6LLZRGt" +
       "TmpVDNKgiW8iUstXWpVFSIyRSlnkaqodsUq9jdiroThu+VnHrI2naMPyoCRR" +
       "jVg0WKk/R12DWDIMYo/bQJpgKIszM3BEiSLHATfThn0+YOyRqjNwT6d5IGO7" +
       "PI8YFQ5kRaFtbRhIY59KrF6tJ42bs44jaZgmDtyIFF1fTmlX1zN+iXs6ys/t" +
       "8oIJNc9k5VGro43kEtZKkEiR65JjWDZFzDKK785NmlsNmfaQx6LSwKiYc6c/" +
       "9OH5EFlxy2hFYl2BjihMqExXPlRMpCFk+53eGLGaZDjDpl64UNkmsZYUjh91" +
       "SpmqBD4clxuB5JDUbDRuKWp/NrZxZVqSrUidL8MZISTNii1JshmO6pm7hiXb" +
       "1q0eh3bwOWKTwkKKVcMvr9d1qqm152W8Z1XNlR431b4pCebStosQXg4XUyzh" +
       "gpERNHipExAGrUytiLZQgg7l5aCHugHPu0nq0tmgZ1iTAd9nhoZjq+FMnTtk" +
       "M6Was8nU6k+UmbTA130jpMkuxycmrbiLMi6HWKo4kGy6cqZIXCfqi7Aip84I" +
       "Y4leNMeIbNnHiaTa5uzQaEpBUxyOKk2PS9sDnCC4OqIFi2yyluBBSMxSqyFp" +
       "vM0JEmA1QlW9gKF8pt5v9Rljbibk3Bb6rt1IGo0OXLchqa2uzeq43cMoS5Ja" +
       "lKB0sXW33lio1bgjSWtoGQ7gIl4qOzORc2iTKEv9vlIU8a7I9ov+cliaFf1+" +
       "zW/wQwFL9bGelidMrd/nLZyRJ2O22/JrOK7XPDtJul132HYbdXsderrQGLhd" +
       "U6ijaeQq616UCHMOkWajwbxBldnIKwtugprTxZrx7HFTmyuR3HaNrDyB8GyA" +
       "rgMSxRApcoC+FsGKt2Ck3Wj0S2V/3kdL8EC1khYfRLzZ8efu2oVUeC60U4/n" +
       "hqpcm8A10e3HCm+7Mr7oTzyIaNATmaN7js7Ugq4U1MKSG7Hlolfrc9xgkM5l" +
       "JxUk2UXX3rglcGV0UXTVQdqr9wcSzNrVcCHg4jTFZbtmIRm0rKvLCTOb9GcE" +
       "5jKNCTxopESnaHuDuSHJutkmZNIJ41GIOFrYczhS8nqtCrMUS6EMpVmgOELb" +
       "bdW5ekNflzopodQiTB30y9KyP9E92BP1RKt7idHGcK49llh6VefHbXecMMWu" +
       "kLmUwpCp1qz2IrsvY2rQTs1BV/GbizjqePVKebystKeloqnWav2BpRiB1TIJ" +
       "faqysJfM5CprMUgZRe2WuWiiWj6bSxXJCuSgvugNe0pPV6zSQvJSGuGHFcQY" +
       "tTFB1+c8VW0bWI+duYtKs014ZlOatoZCp7+w2v2saLZkVmiPCX2JNrUMa9fF" +
       "OVtbQS3Kqg3QkSdGgAlqdEqOWItqU7inlbC1A6Emhda5kRtq66k3LnZQrSEY" +
       "oxXJ4/J4LjNd2h36tVpCsWXM1M1GhCmMmaE6rLdnrKXXXCJJM50zYGjWx4XF" +
       "RDRi3JdWcw5tThZqn2WE6XLWitXlAut2aKTi05BX4ylSIDWLrRRZVR3CTchP" +
       "av21GAWA4WYjzZ1jTXZaiioxG5sm1FiW0Q5W7U+lSt+vd+xpaLDzpddcqcWK" +
       "y89iB6kEMplQejdu15AiGqFap4eQq67bcBYpYcQu3lhYPZ8qI3gtNiG0tBh3" +
       "liLbRli3MfeaakgJY1QeKmvd5UaLni3SmapXqwRNOSTDGPWUmY39cZOXvJVc" +
       "Wk1lFPbwsLyCa+U6jg7Krsu1WjJS5obUuljHoVXUMEVtDUNrXUQmvM3bBKtY" +
       "OqYqoxBlXM3hYWwUr+gJUgyMxRIqRjoB0XWI4qehROkzQ+gQK7qClABh1XTU" +
       "qVqVatRzUZdBoEptiK8Gze6Qi6vrVa8/GtVLRR0zskprhaBJHNGhwZRazNpV" +
       "ELayGFWhmB6nRZfV6/pkNHJKDgvhtJKsGKY/ShN8XGFH2Rx2WzqcWNkYhSC4" +
       "3ZbbAR5xcWMQ0NlwavYWlomvWxbW8uphDWtU1shMT1rlfnXIhKy7WvP0urok" +
       "ehy+qFKLYcypGEItix2vz65wqMtKTaYcMkFl1kZLYlXodNU+asnjUYS0/eWq" +
       "Kjc5uDmpLzqjFj6pBXMGXsczRrYDV3HapSxEiEg1/QaUSlg4kBtUa9xbx5MF" +
       "TbaDFBk3qlWfc5GxvNTHS1LuFdW20JpNPXwseYxUqo2xeNjBMre7ZNdTLYUm" +
       "ZmRaroTHJIGx3TAIIHju1YrVYqkKrSl+zFpWs+xxRTARqqVq4rWdalWoiEh3" +
       "1u61kUk6pmC27cvoUuqGlMqifFjh5xplBvQCXfjzpNcqzrzEZmbtZCURK78n" +
       "V3G0swZrja6ApdwLZqmaKBMkS1vzGKuXWQxFGmsI7ophKZqu4sQdQLpWnYup" +
       "W0xaPjKK0yQbDjkVDDjDkPPMJNAZXjXlnq24AalqziyGe8NmTFo1rWMiRFGp" +
       "yEq1jKuVcr9VLa0afI13/T7JdJEgqjLYZDTuKmXc6PTKHtZuDRPej6kgokQa" +
       "HzZChLOxapu3NE7CfKuISxN2xpUVapUsppnNwQo6ECYOVcIabhr0in3S4lJp" +
       "Wm9ioSBjVaJU703Tft2FMJJke8y6lXHFsQqHSsnoDuC23SvFrFGl6H5a76wF" +
       "KxzZpdYq8Ra4DuEVOUureFFjF2TRalITczSejA0hkydgiVwrPGWHBEeXtSVf" +
       "w80avNRCp65UaYfhXQRxlg14YpJTN21inUVpRiLrXoyIqyozLVaMYpGHe2gX" +
       "WpFtYzGUicAf8WQsWULgd2dBuVirDJuIZZR7jt3qNjzc5JYo1A71PsqvB3YU" +
       "T7NoLMT1hoiv5yu5110bWsXoMVV2puL1WSzSMeCwbF3kvHptOtUXTAZZAmSX" +
       "lMWy4/GlsE31fZMO5ouFOF5m7AKugQo9ZNh1iaCtVcLiUh4mtVo5bUgLFPOq" +
       "9bhTKyIQ3mW19WTWHrRKeFxOxgYrTIM13xL6+GhcpWl4nTradNCJzOVyHEaT" +
       "BEGH1GowhONUWfZlIaijVbTSSzICxbG+SkXNlDMwYD1tybCLEY/P1A6qOM6g" +
       "yfrFBC9G0KoHO7NoZkXlyHN5uJ9EfISgusyvxjVTpSdDqBaSDDy2pQa7roRM" +
       "RS2lUM0jpLFgrUeRUhwp6Kg4QT0ngIpjEWbJ9aQermTUgZAaLS+KplCsCDjT" +
       "8luB57EDuGKLLs4JRitYFafNYGWCuT3C1niVRFYSGVeXZZsqTTuGZnAjmELq" +
       "K6JINm1kXgpJ0StaONm3s15q0445Q6aJq4wm4WQNFrBBY4ETneHcCcSAQZTh" +
       "NCz5y8aQ7MoVtCmuPVezsBVsGkSjVeeVBeMmDd5imyYs1JuO2SyLEWlNpRoK" +
       "BZzQD8aMNh5N0bgCJ+pgqZbikZQMtYlEOtq4nE38VV0f2W1dWBXrzaGeuIQl" +
       "V/rDGU/TcluiR82OvVQJ2iXHo6QZmKwnlZCmQ2vdWQdrToC7H4YxPWFtmls0" +
       "yytRlXWf5LopPmiNLXVuGVSp4vbaXT3qLhN+VvNYMZpFyCht4EhNI4R2dypz" +
       "mtiCuZYi+RNtrAITztqKVUfsSV8o6T5MDlJqMI2oXo+rmXEPLGY+I4n9oW7V" +
       "uA7aiFMUR9leDVVU0eB9vesvYUkIyMGwvyhyaFwU62K0YgcrpsxI1jBcewOk" +
       "syyGfFudRhAaziNjMC8pEdgYiRDOrkV5oi2d9lgmagsLxhy8LVtYp1rr4Q48" +
       "LSuMINZq9Ko7c5t+PDfnhDNAQmfJVqFBteb1liNZ1Ng25MHllBgGQmqVAgJU" +
       "VTgULqYdfcRRpDMy1zKvW5zkD7LBeLbQquWZ6dWgCdkZQz4d8GK14y2xgKrX" +
       "a2rZsFGyWdUEvrEkS3QowMS65Why0KNT0alFTB1fjdNpj8W00mS8bnczVyn7" +
       "lC+KVBVFtZ7p4f0SExJLf2klsSlVjfJU6wB/epU5nCrX/blpcyO0UezWZVvQ" +
       "g1WS1uDFXLD9hkeUyzPCKDKxAHPajDDhtZdO5HET7zREdj3vhm5rWI8MhnLw" +
       "ntqb0nSpW1FDIpimYbeu4F6xhXeB8zDAR11ClAKGrNqOTsELaQL5K44WOKtU" +
       "V1CFG61LSCuzg3qHqCxJp6EITSqLMrHXbA2LKBF2XZevdWSu1AN7RaWBSf3p" +
       "hOXjdVovkYwb6x090elOnHmSmC7qaotwRBjpGnBCl8d4gI07A7EekI1UIKAg" +
       "ySSNBDoiByRM8Trf0P35pON2iWK94aeUNaoviXkGPCZMr0c0gdD9nkrE3ADo" +
       "CNNsZmUHTEAwVG9hKsN6eTTwsTogfGUKVmeVN4KQK+mOna9IdkwVw0VWGRPG" +
       "ok3V4wE5QDKlX9ZUa0QYbOC1+vMWu2y3Zg2dR5CMimq6K5ES3ZnL2KgkGbNS" +
       "L+HoWsJDWrlebVQpxeqPcCkuD7CeQ1gqvsR5dBoLaXepr7pzvMdOV4EQpOXY" +
       "bPfxpdCHODLoztvN4oxcVVE8warzyCp2RZ5tKyt8VWp31x1eIzq8VfR90V9Y" +
       "ImDYsuUIU4KBpn2NkpiZwaV67KLNrsL0WhA67CJ4g3PlTmcuCutsBs8beNrp" +
       "QRQyjEoIQg+m2QBnkVVlBuxosbJXZSW0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("B6nWQVd6N2jRExtyMELOZuUYDZHKQGOgxmIprlPE6HqqNzSLRjTDR3OmPxVL" +
       "VZ3XMlIWhhArkTLme7bXIpVq12s67hrjWzyFIZqSGQhdQhhvVMrSdcMsWeJg" +
       "6itMq4aifFzzVwLam0CohdtGMapO5oFk8xrZEy2FUWcTb0mEbbVuh53Z2MOj" +
       "apT0THMChjdJmGU1GC+rqFeklpXILTveZN2hsq7JhdO1WVsykJpqvs8YtWY2" +
       "n2Gmj0BBYwUswulmPabmwiInziPg/ohKSsVVyhp7PlsSXIJPR2SKNVG+iw+j" +
       "EclR5aBYLaOpPViZvgUPTJ8ZDyeVRm++Ymeerc4VtNKIxLiN11uYLJVHYzYS" +
       "XTlTYULV1Dkyk9vdpSMyjoTBy1q/hVEiv6aQUlcHMjoxaoOVtDicd1Q7W0UE" +
       "QTz/fH7M9c9v7vjt3s2p4uEFzb/CeWJ2xrvzMC7coe6uVBzdE9r8XSzsbvod" +
       "/D92tnvsWsTewQHtE/kBbYrqx89lT119y9+9PXqj+5ub925f/tTLrxidX4bP" +
       "7V69rOLCnbEf/JhjLk3nWK8XNs+fOnkaXQLhpZ3EL50+jT5S2JlH0We8Bvrz" +
       "M/L+Qx69ERfeax++LyccR7CX5uGb9Oi6p6VL3zaOhvFbN3M55ZQK7soTiyB8" +
       "fqeCz9+MCuLC7UEIPI7YfFM9/Pcz8n6QR/81Ljx0pIeTSsjzv30E+L+9DcBX" +
       "8kQchK/sAH/lZsf8Td8i7hXOyNtMoB/GhQcsMz4wdDlUvSi/QnLi9sipWXHw" +
       "ruKwcH6R7Ugnf/E2dJJf4SogILy208lr77xO7jkj71Ie3RkXLh3TyYnXf+8/" +
       "Qx/H3vkdamPvwtvVBgzC13ba+No7r41Hzsh7LI8ejAsXgTakky8P9+47gvjQ" +
       "24D4aGE3E353B/F333mIT5+R92wePQnYA0Bkj72FfPyMcT52z2+D/8rbwP9Y" +
       "nvhBEL6+w//1dx5/5Yw8PI/guPAIwE+/2TvM6y2Rp15cHmkFeRtaefJAK9/Y" +
       "aeUbN6uVN10O96gz8hp59JG48CDQyo2ukr1wBPWjbwPq/Xlifonqmzuo33zn" +
       "oXbPyMu9tb0mmACembZ94/Aaz6XjY32YsYErvA24+XcYhRoIb+zgvvHOw/3E" +
       "GXkv5NEYLPBgZE/fmDy8BTk4wqrc1HXb/FrLdT6ZyC9/P3TN11nbL4r0r75y" +
       "8Y4HX+n/y+3VvIOvfu4UCndMEsc5fgv12PN5wMYTe6OJO7d3Ujd34vYsgOxG" +
       "Fw3iwi0gzoXem2xLz4C81ysNSoL4eEl3ZxDHS8aF2zb/j5cL4sKFo3Jx4fz2" +
       "4XiRCLQOiuSPcXBgbcWzbkdI8crJh+bAC9875kjvDGzjeNz3ZmN1WOX4dwn5" +
       "5bPNB3YHF8WS7Sd2V/XXXuHbn/x+5Ze330Xojrpe563cIRRu336isWk0v2z2" +
       "+A1bO2jrPPvMD+/5jTufOtgY3LMV+MjYj8n2vut/gUC7Qbz5ZmD9Dx78+x/6" +
       "e6/82eZmxP8DLHBuqfk4AAA=");
}
