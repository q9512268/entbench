package org.apache.xalan.serialize;
public class SerializerUtils {
    public static void addAttribute(org.apache.xml.serializer.SerializationHandler handler,
                                    int attr) throws javax.xml.transform.TransformerException {
        org.apache.xalan.transformer.TransformerImpl transformer =
          (org.apache.xalan.transformer.TransformerImpl)
            handler.
            getTransformer(
              );
        org.apache.xml.dtm.DTM dtm =
          transformer.
          getXPathContext(
            ).
          getDTM(
            attr);
        if (org.apache.xalan.serialize.SerializerUtils.
              isDefinedNSDecl(
                handler,
                attr,
                dtm))
            return;
        java.lang.String ns =
          dtm.
          getNamespaceURI(
            attr);
        if (ns ==
              null)
            ns =
              "";
        try {
            handler.
              addAttribute(
                ns,
                dtm.
                  getLocalName(
                    attr),
                dtm.
                  getNodeName(
                    attr),
                "CDATA",
                dtm.
                  getNodeValue(
                    attr),
                false);
        }
        catch (org.xml.sax.SAXException e) {
            
        }
    }
    public static void addAttributes(org.apache.xml.serializer.SerializationHandler handler,
                                     int src) throws javax.xml.transform.TransformerException {
        org.apache.xalan.transformer.TransformerImpl transformer =
          (org.apache.xalan.transformer.TransformerImpl)
            handler.
            getTransformer(
              );
        org.apache.xml.dtm.DTM dtm =
          transformer.
          getXPathContext(
            ).
          getDTM(
            src);
        for (int node =
               dtm.
               getFirstAttribute(
                 src);
             org.apache.xml.dtm.DTM.
               NULL !=
               node;
             node =
               dtm.
                 getNextAttribute(
                   node)) {
            addAttribute(
              handler,
              node);
        }
    }
    public static void outputResultTreeFragment(org.apache.xml.serializer.SerializationHandler handler,
                                                org.apache.xpath.objects.XObject obj,
                                                org.apache.xpath.XPathContext support)
          throws org.xml.sax.SAXException {
        int doc =
          obj.
          rtf(
            );
        org.apache.xml.dtm.DTM dtm =
          support.
          getDTM(
            doc);
        if (null !=
              dtm) {
            for (int n =
                   dtm.
                   getFirstChild(
                     doc);
                 org.apache.xml.dtm.DTM.
                   NULL !=
                   n;
                 n =
                   dtm.
                     getNextSibling(
                       n)) {
                handler.
                  flushPending(
                    );
                if (dtm.
                      getNodeType(
                        n) ==
                      org.apache.xml.dtm.DTM.
                        ELEMENT_NODE &&
                      dtm.
                      getNamespaceURI(
                        n) ==
                      null)
                    handler.
                      startPrefixMapping(
                        "",
                        "");
                dtm.
                  dispatchToEvents(
                    n,
                    handler);
            }
        }
    }
    public static void processNSDecls(org.apache.xml.serializer.SerializationHandler handler,
                                      int src,
                                      int type,
                                      org.apache.xml.dtm.DTM dtm)
          throws javax.xml.transform.TransformerException {
        try {
            if (type ==
                  org.apache.xml.dtm.DTM.
                    ELEMENT_NODE) {
                for (int namespace =
                       dtm.
                       getFirstNamespaceNode(
                         src,
                         true);
                     org.apache.xml.dtm.DTM.
                       NULL !=
                       namespace;
                     namespace =
                       dtm.
                         getNextNamespaceNode(
                           src,
                           namespace,
                           true)) {
                    java.lang.String prefix =
                      dtm.
                      getNodeNameX(
                        namespace);
                    java.lang.String desturi =
                      handler.
                      getNamespaceURIFromPrefix(
                        prefix);
                    java.lang.String srcURI =
                      dtm.
                      getNodeValue(
                        namespace);
                    if (!srcURI.
                          equalsIgnoreCase(
                            desturi)) {
                        handler.
                          startPrefixMapping(
                            prefix,
                            srcURI,
                            false);
                    }
                }
            }
            else
                if (type ==
                      org.apache.xml.dtm.DTM.
                        NAMESPACE_NODE) {
                    java.lang.String prefix =
                      dtm.
                      getNodeNameX(
                        src);
                    java.lang.String desturi =
                      handler.
                      getNamespaceURIFromPrefix(
                        prefix);
                    java.lang.String srcURI =
                      dtm.
                      getNodeValue(
                        src);
                    if (!srcURI.
                          equalsIgnoreCase(
                            desturi)) {
                        handler.
                          startPrefixMapping(
                            prefix,
                            srcURI,
                            false);
                    }
                }
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se);
        }
    }
    public static boolean isDefinedNSDecl(org.apache.xml.serializer.SerializationHandler serializer,
                                          int attr,
                                          org.apache.xml.dtm.DTM dtm) {
        if (org.apache.xml.dtm.DTM.
              NAMESPACE_NODE ==
              dtm.
              getNodeType(
                attr)) {
            java.lang.String prefix =
              dtm.
              getNodeNameX(
                attr);
            java.lang.String uri =
              serializer.
              getNamespaceURIFromPrefix(
                prefix);
            if (null !=
                  uri &&
                  uri.
                  equals(
                    dtm.
                      getStringValue(
                        attr)))
                return true;
        }
        return false;
    }
    public static void ensureNamespaceDeclDeclared(org.apache.xml.serializer.SerializationHandler handler,
                                                   org.apache.xml.dtm.DTM dtm,
                                                   int namespace)
          throws org.xml.sax.SAXException {
        java.lang.String uri =
          dtm.
          getNodeValue(
            namespace);
        java.lang.String prefix =
          dtm.
          getNodeNameX(
            namespace);
        if (uri !=
              null &&
              uri.
              length(
                ) >
              0 &&
              null !=
              prefix) {
            java.lang.String foundURI;
            org.apache.xml.serializer.NamespaceMappings ns =
              handler.
              getNamespaceMappings(
                );
            if (ns !=
                  null) {
                foundURI =
                  ns.
                    lookupNamespace(
                      prefix);
                if (null ==
                      foundURI ||
                      !foundURI.
                      equals(
                        uri)) {
                    handler.
                      startPrefixMapping(
                        prefix,
                        uri,
                        false);
                }
            }
        }
    }
    public SerializerUtils() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Htfk6jTR7GJ5B8+ZTj9+fFzue36ZyA4acs/ydZCqvvy7f70bPvHHdwocFJVU" +
       "N5aqZISonjlDMOW8PI7v4WmZy08rrtws+ejozOp8emeamouQd1tx8vZP8Pbj" +
       "f23a9LXhHXfB23N8jvKrfLHnzDvrF0pHgzyzFJSdl5HmDmr3ugwmNQmk0Bpb" +
       "Fuup4ahvyYa2gYVsI3yX26Fd7ke9INiCOAlynACjWTy5dwHDgVA/gVbffg8K" +
       "dfz/TIrC3mwgpbq5gBnOqRG6IMxAj5wbPNFnteFAOmHRmKmkgNdH7Mz1bOPN" +
       "3b8s37PWyUoLDRGSG62eSz/r+iTOI1nBoJL1nwcmq80hz3lUx5qlDP2LJqgE" +
       "cy2K7G24tuvZT18WFvkTb58wOXz8yS/CR46LXSGqk/l5BYJ3jKhQfNbNm2gW" +
       "PqLzk7N73/jB3kNBm4HXU1Si2IUji1Ygm1g1+n0oLA0tO/WPfU9c7YNMoBtV" +
       "pDVld5p0y7m4LLfSCY9T3XLGRaltMzsQKQq0GUaGd2/xgccxxwbPfTwn5bih" +
       "JtYslk7AGW4/EXNdRiIGQw9XxlP3PoqqsSxnLwm4qkdsj7GfHRSVjuiKqPFW" +
       "sCYmXrT/dyTNOlbx7o35O2+7vUe23/XOY81AgV1XTGPhXcf+foM12/iMmcLu" +
       "ZX8VLrCHNZDW1eS5THX9Y02Of2bDd8xezcik+WekiEbfyku4qhLuHwddc73U" +
       "xEq/sM4rWSu8VZS0juDsPMGtMWjtCxBu+8GJgTyTaeD0B3AeWL01F7jfZs0+" +
       "JpWmRpr2EyutUpaqdpp4KEU06gvI/skJCBvxnO2+8UkLyHgRjT4HlXJVpS5g" +
       "eeP4q9F3asg0FV67qYdbdeJOoH6WNUcpmmqwwsayegfWwmHrR/Wx/9mJTewV" +
       "S5+u2ku+OmlOLKZxAlRnnXiST/vCBGn4i6z5PmTRirWWJKGwkz0uetjDlT7e" +
       "LE/oukqwVsj1JOO69rnJwWcjfG/bjrg1aa69VUTjHVx70mXVnxYH4He4wBus" +
       "+RFFs4hmQVndCyelBVgmzMfsi00i+9D42t27LAMB9N2nsApiZt5trriBlF4Z" +
       "r62YMb7597ymz94SVkNSlEyrquc49x7tIcMEhPBVVYsiy+A/P6eoqfg9D+T2" +
       "2Wdu/Vti1K8oqvOPoqiM/3rlLlBU5cpBUioevCIXIZEBEfb4ruHQRh2vntg9" +
       "bVgweCaQXyJxf0+/k789FdD8nByQ36k7aVJa3KpDPjq+ofexG8ufF7cTEOI9" +
       "/GidAsmRuAPJlgnzimpzdIW6Ft2e+mrlAidny7kd8drGYQDI4zcJTb5y3WrN" +
       "Vu0fnF557r3DoSuQbW5DAUzRtG2eG23hKaj501DDbIsWSgOhiOI3Ce1Vf95x" +
       "6daHgQZefiKRODZPNCIuHTv3USxpGN8LospuVAYpKckMoipgnjGtn0gjZk5W" +
       "GUroaS17/T5V5ptF0Ya4Z2yH1mR72cUVRS35eXP+ZR5U5qPEXMO0MzU1vsIq" +
       "bRjet9yzsiA/5mnAWjzaYxj2fU7wIPe8YfCNeI3T338AESg3NTgbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/NqVc5E9RPXesjN3Whqhhh0GdVRUK+uGNEMaS45FTdbtlUwGlZc21YMNmWWo" +
       "xsjrz+gZH3DcWPEWa4btsXXOFMdVahZ0SuNic5mYpLiUlmhFKzVGtMq3zR7S" +
       "alRIlHUWboMYjrSO21QFTV1Xc/3RolHPT6pcx4xQm3bEZFZz5lhh3Bg7mGbO" +
       "4oI5s5vT7kxstJA+LfXLHLqmaX7VbcY0qZRwxNOT2JRYo9as1oX5uOckVMEZ" +
       "9PT5sKQp3Y7R5Wq5jioxAcJK60IxbKtrrVZujxW/SxTLE2nlNb2xQpXqy67B" +
       "jHrcyp8PO8N6SZos44rSgtu2m5sOiIFLDNExS9USxi/mWTHKIcVCpLaWvB95" +
       "8xgnkrKVwF4Eg1NMv8hGNUbiyZHTWzlNsm7Pgu5k4XbGYpKntc7SWQoB3ZXa" +
       "S2JVyrWKM0JEJ7RG6sE45oKRF9Cu6OIj3YOJuNhTVc+0NafAeOMlrq8Fs4on" +
       "xUJca9Tddr/ktvC4s6RW8cw2MJqboM2OoddNt+8s55rjw2yitvtkh+bKMUyw" +
       "SH0wJ3q1eagPc0o+asJUqTOf2nSejntcg2gOao1Vp8hXpojewCZUI1+NZX/Q" +
       "GUgDAZZwe8DCGIJMgU+yyJUVzadYsymFmj0ZxAVpUqrMpRzJ5BrTGinMh0K/" +
       "QqPVebLwWZGbFC2SCCyMEK26OikwlLwOp7NyZ+bialWuaj1/RrCJ4pPD9Xi9" +
       "rCaRGtQkMUE4plhDyfY4Usm4LBuDooILaLHk5VyjU7XrTjxRuXaXWlR4EUEa" +
       "ouByYYO2bFdSi4VZzXAovTsdVkmJwhulTiPI4fgAV6pjyhhyNSNpLnxAGitb" +
       "PMWsKo1uiV9XKrmVNZ/Dgos7AkVOW6IaV1bdFjluWhUV5kJqjKFJWV5FQ1jG" +
       "akbDQWrD0cBn1wuOCMwVmhSJWi8sU6RQRxifrC8Fl1/HRqFoNJ3mAkErKJlf" +
       "aL3ASmajGgWotwotEeuXS1w3LuWcEKYG1Uppvq4Fc5yQC8RIUuHVoDUdWq22" +
       "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" +
       "Tj77kk+/5mOPfSdLVv0fZ+0XuAonAAA=");
}
