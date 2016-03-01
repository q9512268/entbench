package org.apache.batik.transcoder;
public abstract class XMLAbstractTranscoder extends org.apache.batik.transcoder.AbstractTranscoder implements panda.runtime.PANDA_Attributable {
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
