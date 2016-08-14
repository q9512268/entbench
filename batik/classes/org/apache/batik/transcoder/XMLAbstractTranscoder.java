package org.apache.batik.transcoder;
public abstract class XMLAbstractTranscoder extends org.apache.batik.transcoder.AbstractTranscoder implements ent.runtime.ENT_Attributable {
    protected XMLAbstractTranscoder() { super();
                                        hints.put(KEY_XML_PARSER_VALIDATING,
                                                  java.lang.Boolean.
                                                    FALSE); }
    public void transcode(org.apache.batik.transcoder.TranscoderInput input,
                          org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException { org.w3c.dom.Document document =
                                                                     null;
                                                                   java.lang.String uri =
                                                                     input.
                                                                     getURI(
                                                                       );
                                                                   if (input.
                                                                         getDocument(
                                                                           ) !=
                                                                         null) {
                                                                       document =
                                                                         input.
                                                                           getDocument(
                                                                             );
                                                                   }
                                                                   else {
                                                                       java.lang.String parserClassname =
                                                                         (java.lang.String)
                                                                           hints.
                                                                           get(
                                                                             KEY_XML_PARSER_CLASSNAME);
                                                                       java.lang.String namespaceURI =
                                                                         (java.lang.String)
                                                                           hints.
                                                                           get(
                                                                             KEY_DOCUMENT_ELEMENT_NAMESPACE_URI);
                                                                       java.lang.String documentElement =
                                                                         (java.lang.String)
                                                                           hints.
                                                                           get(
                                                                             KEY_DOCUMENT_ELEMENT);
                                                                       org.w3c.dom.DOMImplementation domImpl =
                                                                         (org.w3c.dom.DOMImplementation)
                                                                           hints.
                                                                           get(
                                                                             KEY_DOM_IMPLEMENTATION);
                                                                       if (parserClassname ==
                                                                             null) {
                                                                           parserClassname =
                                                                             org.apache.batik.util.XMLResourceDescriptor.
                                                                               getXMLParserClassName(
                                                                                 );
                                                                       }
                                                                       if (domImpl ==
                                                                             null) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 "Unspecified transcoding hints: KEY_DOM_IMPLEMENTATION"));
                                                                           return;
                                                                       }
                                                                       if (namespaceURI ==
                                                                             null) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 ("Unspecified transcoding hints: KEY_DOCUMENT_ELEMENT_NAMESPAC" +
                                                                                  "E_URI")));
                                                                           return;
                                                                       }
                                                                       if (documentElement ==
                                                                             null) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 "Unspecified transcoding hints: KEY_DOCUMENT_ELEMENT"));
                                                                           return;
                                                                       }
                                                                       org.apache.batik.dom.util.DocumentFactory f =
                                                                         createDocumentFactory(
                                                                           domImpl,
                                                                           parserClassname);
                                                                       boolean b =
                                                                         ((java.lang.Boolean)
                                                                            hints.
                                                                            get(
                                                                              KEY_XML_PARSER_VALIDATING)).
                                                                         booleanValue(
                                                                           );
                                                                       f.
                                                                         setValidating(
                                                                           b);
                                                                       try {
                                                                           if (input.
                                                                                 getInputStream(
                                                                                   ) !=
                                                                                 null) {
                                                                               document =
                                                                                 f.
                                                                                   createDocument(
                                                                                     namespaceURI,
                                                                                     documentElement,
                                                                                     input.
                                                                                       getURI(
                                                                                         ),
                                                                                     input.
                                                                                       getInputStream(
                                                                                         ));
                                                                           }
                                                                           else
                                                                               if (input.
                                                                                     getReader(
                                                                                       ) !=
                                                                                     null) {
                                                                                   document =
                                                                                     f.
                                                                                       createDocument(
                                                                                         namespaceURI,
                                                                                         documentElement,
                                                                                         input.
                                                                                           getURI(
                                                                                             ),
                                                                                         input.
                                                                                           getReader(
                                                                                             ));
                                                                               }
                                                                               else
                                                                                   if (input.
                                                                                         getXMLReader(
                                                                                           ) !=
                                                                                         null) {
                                                                                       document =
                                                                                         f.
                                                                                           createDocument(
                                                                                             namespaceURI,
                                                                                             documentElement,
                                                                                             input.
                                                                                               getURI(
                                                                                                 ),
                                                                                             input.
                                                                                               getXMLReader(
                                                                                                 ));
                                                                                   }
                                                                                   else
                                                                                       if (uri !=
                                                                                             null) {
                                                                                           document =
                                                                                             f.
                                                                                               createDocument(
                                                                                                 namespaceURI,
                                                                                                 documentElement,
                                                                                                 uri);
                                                                                       }
                                                                       }
                                                                       catch (org.w3c.dom.DOMException ex) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 ex));
                                                                       }
                                                                       catch (java.io.IOException ex) {
                                                                           handler.
                                                                             fatalError(
                                                                               new org.apache.batik.transcoder.TranscoderException(
                                                                                 ex));
                                                                       }
                                                                   }
                                                                   if (document !=
                                                                         null) {
                                                                       try {
                                                                           transcode(
                                                                             document,
                                                                             uri,
                                                                             output);
                                                                       }
                                                                       catch (org.apache.batik.transcoder.TranscoderException ex) {
                                                                           handler.
                                                                             fatalError(
                                                                               ex);
                                                                           return;
                                                                       }
                                                                   }
    }
    protected org.apache.batik.dom.util.DocumentFactory createDocumentFactory(org.w3c.dom.DOMImplementation domImpl,
                                                                              java.lang.String parserClassname) {
        return new org.apache.batik.dom.util.SAXDocumentFactory(
          domImpl,
          parserClassname);
    }
    protected abstract void transcode(org.w3c.dom.Document document,
                                      java.lang.String uri,
                                      org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException;
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_XML_PARSER_CLASSNAME =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_XML_PARSER_VALIDATING =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_DOCUMENT_ELEMENT =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_DOCUMENT_ELEMENT_NAMESPACE_URI =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_DOM_IMPLEMENTATION =
      new org.apache.batik.transcoder.keys.DOMImplementationKey(
      );
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze4wTxxkf++BecNxxcEB4HK+DioPYUELT9FISYwxn8D10" +
       "d1yTa4PZW4/PC+vdZXd85yOhJSgRNFIRoQSolKC0IqVBEKIqqM9EVFEelKht" +
       "GvqUQh79o7QpUlDVtAlt6ffN7nofto+H2lra8Xrmm2++1/y+b8YnL5Pxhk6a" +
       "qcJCbFSjRiimsG5BN2gqKguG0Qd9SfFwhfDXzZc67wqSygEyKSMYHaJg0HUS" +
       "lVPGAJkjKQYTFJEanZSmcEa3Tg2qDwtMUpUB0iQZ8awmS6LEOtQURYJ+QU+Q" +
       "yQJjujSYYzRuMWBkTgIkCXNJwhH/cFuCTBRVbdQhn+Eij7pGkDLrrGUw0pDY" +
       "KgwL4RyT5HBCMlhbXidLNVUeHZJVFqJ5Ftoqr7JMsCGxqsgEC56v/+jq/kwD" +
       "N8EUQVFUxtUzeqihysM0lSD1Tm9MplljO/kyqUiQCS5iRloS9qJhWDQMi9ra" +
       "OlQgfR1VctmoytVhNqdKTUSBGJnvZaIJupC12HRzmYFDNbN055NB23kFbU0t" +
       "i1R8Ymn44OHNDd+tIPUDpF5SelEcEYRgsMgAGJRmB6luRFIpmhogkxVwdi/V" +
       "JUGWdliebjSkIUVgOXC/bRbszGlU52s6tgI/gm56TmSqXlAvzQPK+jU+LQtD" +
       "oOs0R1dTw3XYDwrWSiCYnhYg7qwp47ZJSoqRuf4ZBR1bNgIBTK3KUpZRC0uN" +
       "UwToII1miMiCMhTuhdBThoB0vAoBqDMysyxTtLUmiNuEIZrEiPTRdZtDQFXD" +
       "DYFTGGnyk3FO4KWZPi+5/HO58+59DyrtSpAEQOYUFWWUfwJMavZN6qFpqlPY" +
       "B+bEia2JQ8K0F/cGCQHiJh+xSfO9h67cu6z57OsmzawSNF2DW6nIkuKxwUlv" +
       "zo4uuasCxajWVENC53s057us2xppy2uAMNMKHHEwZA+e7Xn1/l0n6AdBUhsn" +
       "laIq57IQR5NFNatJMtXXU4XqAqOpOKmhSirKx+OkCt4TkkLN3q502qAsTsbJ" +
       "vKtS5b/BRGlggSaqhXdJSav2uyawDH/Pa4SQBnhIEzyriPnh34ykwhk1S8OC" +
       "KCiSooa7dRX1N8KAOINg20x4EKJ+W9hQczqEYFjVh8ICxEGGWgNMFxRDBBDS" +
       "w/d1JCKDEO6CyPoKvSGMNu3/tE4e9Z0yEgiAK2b7gUCGPdSuykCbFA/m1sSu" +
       "PJc8bwYZbgzLUoysgKVD5tIhvnTIWTpUcmkSCPAVp6IIpuPBbdsAAACBJy7p" +
       "fWDDlr0LKiDitJFxYHMkXeDJRFEHJWxoT4qnG+t2zL+44uUgGZcgjbBgTpAx" +
       "sUT0IYAscZu1qycOQo5yUsU8V6rAHKerIk0BUpVLGRaXanWY6tjPyFQXBzuR" +
       "4ZYNl08jJeUnZ4+MPNz/leVBEvRmB1xyPAAbTu9GTC9gd4sfFUrxrd9z6aPT" +
       "h3aqDj540o2dJYtmog4L/DHhN09SbJ0nnEm+uLOFm70G8JsJsN8AGpv9a3jg" +
       "p82GctSlGhROq3pWkHHItnEty+jqiNPDg3Uyf58KYTEJ9+NCeD5nbVD+jaPT" +
       "NGynm8GNcebTgqeKz/dqT/32Z39ayc1tZ5V6VznQS1mbC8mQWSPHrMlO2Pbp" +
       "lALd20e6v/7E5T1f5DELFAtLLdiCbRQQDFwIZn709e2/e+fisQtBJ84ZqdF0" +
       "lcE2p6l8QU8cInVj6AkLLnZEAjCUgQMGTssmBUJUSkvCoExxb/2zftGKM3/Z" +
       "12CGggw9diQtuz4Dp/+2NWTX+c1/b+ZsAiImY8dsDpmJ8FMczhFdF0ZRjvzD" +
       "v5zzjdeEpyBXAD4b0g7KIZdwMxDut1Vc/+W8vcM3dic2iwx3/Hu3mKtoSor7" +
       "L3xY1//hS1e4tN6qy+3uDkFrMyMMm8V5YD/dj0/tgpEBujvOdn6pQT57FTgO" +
       "AEcR8Nfo0gHY8p7gsKjHV/3+Jy9P2/JmBQmuI7WyKqTWCXyfkRoIcGpkAGLz" +
       "2j33ms4dqbZzT54UKV/UgQaeW9p1sazGuLF3fH/6C3cfP3qRB5pm8pjF52OJ" +
       "P9sDrLx2d/b2ibfu/NXxxw+NmNl/SXlA882b8UmXPLj7/X8UmZxDWYnKxDd/" +
       "IHzyyZnR1R/w+Q6m4OyWfHGmAlx25n76RPZvwQWVrwRJ1QBpEK1auV+Qc7hT" +
       "B6A+NOwCGuppz7i31jMLm7YCZs7245lrWT+aORkS3pEa3+t8ADYDXTgTnvPW" +
       "xv6pH8AChL/E+ZRP8bYVm9u5+yoYlP65QThBwYvBq3IGYkiKIPvQY7rNvMQi" +
       "UKFtjN2fhESd7I709MZ6ktFEpLe3M9IR40xmMLJ8rAxvp3Woi9uh9DZaNtJR" +
       "E3ix/Sw2G0xx2srGeNRrk1nwvG+J+14Zm/SXsQm+dmDTiU1XCUO8V4YzI7f5" +
       "DNEfScTXRvrineuRoMen1RduUiv09CfW2h+X0WrzLWv1cRnOUJ+gVmu7ops6" +
       "Yp19yVgiht+lFErevEKBKSZpoLGMQulbVcjkWIIzIwtKKZTEgO3tjkRjyU09" +
       "8VLqDd2keotg8aWWEK1l1FNuWb3WMpwhmZrqdSTjHd2mbhCCXZ2lVFLHUClf" +
       "WrQgF42RasEqyx3Z+Kee+E487kLDSR0E8+OccodSfqA+tvvg0VTXMyvM5NHo" +
       "PejFlFz21K//9UboyLvnSpwpapiq3S7TYSq71qzAJT3pqoOf1x3sf3vSgT/8" +
       "oGVozc0cAbCv+TpFPv6eC0q0ls+AflFe2/3nmX2rM1tuopqf6zOnn+WzHSfP" +
       "rV8sHgjyywkzKRVdangntXlTUa1OWU5X+jwJaWEhACagY+PwtFsB0O4Peyf+" +
       "igIrwAPLF+m1YzDzFXhBMzztnLP0RnIOhQSs5Zg9Z9mNzenKMZjEdXnMJ0TA" +
       "OnBaDMM3xjCWF6mGzuU892PzCMawTWCMWTt161IWThjD1q1MeGfjO9uevHTK" +
       "3Db+QslHTPcefOxaaN9BcwuZ91wLi66a3HPMuy4uaIPpq2vwCcDzb3zQR9iB" +
       "31AORa0Ll3mFGxesIHUyfyyx+BLr/nh654++s3NP0KrZH2Jk3LAqpRzwevR6" +
       "eDx25YsdEY337yoEXTOOrYTnaSvonh4jgrFZWnzMKjd17Hidg6EyslIMpdRs" +
       "CNAbr7ZpFtDK2fVA1cBrdSwvQ+ZVIpfn22OcdU5i801GmkSdgv3XqmIOuZpH" +
       "iFGb75KiQEUxONKWmsHt/63/gf2xEiGr4TltGfHUTSAIT00hbPI+GJlmcyrB" +
       "0We7CitVWIaZ6nGLZQocexabr3FxflgaBPDn45zgJWxecO9o7DjsmPLMf8OU" +
       "eXByyesyPOTNKLqlN2+WxeeO1ldPP7rpNzzlFW5/J0LySudk2X0Mcb1XajpN" +
       "S1y3ieahRONfrzIyawzIY5C1Cj+4Gq+Y885BZPvnwVGEf7vp3gAODh2cWswX" +
       "N8nPGakAEnz9hWZ7MTQWDhcbLB/wVioFPzVdz0+u4mahB7H5fyl2Xs6Z/6Yk" +
       "xdNHN3Q+eOUzz5h3SKIs7NiBXCYkSJV5nVXI7fPLcrN5VbYvuTrp+ZpFNmBO" +
       "NgV29sssFypE4EXTitKW5zjv+lON398kxQvHH3jrwIxjzUEyIU7GA0jTPD8P" +
       "rx1Veqg4rA+QOsmI5SWDARdJkOOkOqdI23M0nkqQSRhbAmIWF9jSs67Qi1eD" +
       "UJsXJ5/iC9VaWR2h+ho1p6R4GQIFktPj+ffFrltymuab4PQUbDy1WPekuPar" +
       "9T/e31ixDvaHRx03+yojN1ioidx/yDhFUgM2R/JmWgzcp/HrqgA2NdxDpi8u" +
       "uqkqQCd/dwC6s1LK3x2E5JiRhjKefkzHsNY9mokP2LzrG78G463WeP4/H8TW" +
       "SrQdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "acf/A6wOF5gZKQAA");
}
