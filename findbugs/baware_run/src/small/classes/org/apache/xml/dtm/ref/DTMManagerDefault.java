package org.apache.xml.dtm.ref;
public class DTMManagerDefault extends org.apache.xml.dtm.DTMManager {
    private static final boolean DUMPTREE = false;
    private static final boolean DEBUG = false;
    protected org.apache.xml.dtm.DTM[] m_dtms = new org.apache.xml.dtm.DTM[256];
    int[] m_dtm_offsets = new int[256];
    protected org.apache.xml.utils.XMLReaderManager m_readerManager = null;
    protected org.xml.sax.helpers.DefaultHandler m_defaultHandler = new org.xml.sax.helpers.DefaultHandler(
      );
    public synchronized void addDTM(org.apache.xml.dtm.DTM dtm, int id) {
        addDTM(
          dtm,
          id,
          0);
    }
    public synchronized void addDTM(org.apache.xml.dtm.DTM dtm, int id,
                                    int offset) { if (id >= IDENT_MAX_DTMS) {
                                                      throw new org.apache.xml.dtm.DTMException(
                                                        org.apache.xml.res.XMLMessages.
                                                          createXMLMessage(
                                                            org.apache.xml.res.XMLErrorResources.
                                                              ER_NO_DTMIDS_AVAIL,
                                                            null));
                                                  }
                                                  int oldlen =
                                                    m_dtms.
                                                      length;
                                                  if (oldlen <=
                                                        id) {
                                                      int newlen =
                                                        java.lang.Math.
                                                        min(
                                                          id +
                                                            256,
                                                          IDENT_MAX_DTMS);
                                                      org.apache.xml.dtm.DTM[] new_m_dtms =
                                                        new org.apache.xml.dtm.DTM[newlen];
                                                      java.lang.System.
                                                        arraycopy(
                                                          m_dtms,
                                                          0,
                                                          new_m_dtms,
                                                          0,
                                                          oldlen);
                                                      m_dtms =
                                                        new_m_dtms;
                                                      int[] new_m_dtm_offsets =
                                                        new int[newlen];
                                                      java.lang.System.
                                                        arraycopy(
                                                          m_dtm_offsets,
                                                          0,
                                                          new_m_dtm_offsets,
                                                          0,
                                                          oldlen);
                                                      m_dtm_offsets =
                                                        new_m_dtm_offsets;
                                                  }
                                                  m_dtms[id] =
                                                    dtm;
                                                  m_dtm_offsets[id] =
                                                    offset;
                                                  dtm.
                                                    documentRegistration(
                                                      );
    }
    public synchronized int getFirstFreeDTMID() {
        int n =
          m_dtms.
            length;
        for (int i =
               1;
             i <
               n;
             i++) {
            if (null ==
                  m_dtms[i]) {
                return i;
            }
        }
        return n;
    }
    private org.apache.xml.dtm.ref.ExpandedNameTable
      m_expandedNameTable =
      new org.apache.xml.dtm.ref.ExpandedNameTable(
      );
    public DTMManagerDefault() { super();
    }
    public synchronized org.apache.xml.dtm.DTM getDTM(javax.xml.transform.Source source,
                                                      boolean unique,
                                                      org.apache.xml.dtm.DTMWSFilter whiteSpaceFilter,
                                                      boolean incremental,
                                                      boolean doIndexing) {
        if (DEBUG &&
              null !=
              source)
            java.lang.System.
              out.
              println(
                "Starting " +
                (unique
                   ? "UNIQUE"
                   : "shared") +
                " source: " +
                source.
                  getSystemId(
                    ));
        org.apache.xml.utils.XMLStringFactory xstringFactory =
          m_xsf;
        int dtmPos =
          getFirstFreeDTMID(
            );
        int documentID =
          dtmPos <<
          IDENT_DTM_NODE_BITS;
        if (null !=
              source &&
              source instanceof javax.xml.transform.dom.DOMSource) {
            org.apache.xml.dtm.ref.dom2dtm.DOM2DTM dtm =
              new org.apache.xml.dtm.ref.dom2dtm.DOM2DTM(
              this,
              (javax.xml.transform.dom.DOMSource)
                source,
              documentID,
              whiteSpaceFilter,
              xstringFactory,
              doIndexing);
            addDTM(
              dtm,
              dtmPos,
              0);
            return dtm;
        }
        else {
            boolean isSAXSource =
              null !=
              source
              ? source instanceof javax.xml.transform.sax.SAXSource
              : true;
            boolean isStreamSource =
              null !=
              source
              ? source instanceof javax.xml.transform.stream.StreamSource
              : false;
            if (isSAXSource ||
                  isStreamSource) {
                org.xml.sax.XMLReader reader =
                  null;
                org.apache.xml.dtm.ref.sax2dtm.SAX2DTM dtm;
                try {
                    org.xml.sax.InputSource xmlSource;
                    if (null ==
                          source) {
                        xmlSource =
                          null;
                    }
                    else {
                        reader =
                          getXMLReader(
                            source);
                        xmlSource =
                          javax.xml.transform.sax.SAXSource.
                            sourceToInputSource(
                              source);
                        java.lang.String urlOfSource =
                          xmlSource.
                          getSystemId(
                            );
                        if (null !=
                              urlOfSource) {
                            try {
                                urlOfSource =
                                  org.apache.xml.utils.SystemIDResolver.
                                    getAbsoluteURI(
                                      urlOfSource);
                            }
                            catch (java.lang.Exception e) {
                                java.lang.System.
                                  err.
                                  println(
                                    "Can not absolutize URL: " +
                                    urlOfSource);
                            }
                            xmlSource.
                              setSystemId(
                                urlOfSource);
                        }
                    }
                    if (source ==
                          null &&
                          unique &&
                          !incremental &&
                          !doIndexing) {
                        dtm =
                          new org.apache.xml.dtm.ref.sax2dtm.SAX2RTFDTM(
                            this,
                            source,
                            documentID,
                            whiteSpaceFilter,
                            xstringFactory,
                            doIndexing);
                    }
                    else {
                        dtm =
                          new org.apache.xml.dtm.ref.sax2dtm.SAX2DTM(
                            this,
                            source,
                            documentID,
                            whiteSpaceFilter,
                            xstringFactory,
                            doIndexing);
                    }
                    addDTM(
                      dtm,
                      dtmPos,
                      0);
                    boolean haveXercesParser =
                      null !=
                      reader &&
                      reader.
                      getClass(
                        ).
                      getName(
                        ).
                      equals(
                        "org.apache.xerces.parsers.SAXParser");
                    if (haveXercesParser) {
                        incremental =
                          true;
                    }
                    if (m_incremental &&
                          incremental) {
                        org.apache.xml.dtm.ref.IncrementalSAXSource coParser =
                          null;
                        if (haveXercesParser) {
                            try {
                                coParser =
                                  (org.apache.xml.dtm.ref.IncrementalSAXSource)
                                    java.lang.Class.
                                    forName(
                                      "org.apache.xml.dtm.ref.IncrementalSAXSource_Xerces").
                                    newInstance(
                                      );
                            }
                            catch (java.lang.Exception ex) {
                                ex.
                                  printStackTrace(
                                    );
                                coParser =
                                  null;
                            }
                        }
                        if (coParser ==
                              null) {
                            if (null ==
                                  reader) {
                                coParser =
                                  new org.apache.xml.dtm.ref.IncrementalSAXSource_Filter(
                                    );
                            }
                            else {
                                org.apache.xml.dtm.ref.IncrementalSAXSource_Filter filter =
                                  new org.apache.xml.dtm.ref.IncrementalSAXSource_Filter(
                                  );
                                filter.
                                  setXMLReader(
                                    reader);
                                coParser =
                                  filter;
                            }
                        }
                        dtm.
                          setIncrementalSAXSource(
                            coParser);
                        if (null ==
                              xmlSource) {
                            return dtm;
                        }
                        if (null ==
                              reader.
                              getErrorHandler(
                                )) {
                            reader.
                              setErrorHandler(
                                dtm);
                        }
                        reader.
                          setDTDHandler(
                            dtm);
                        try {
                            coParser.
                              startParse(
                                xmlSource);
                        }
                        catch (java.lang.RuntimeException re) {
                            dtm.
                              clearCoRoutine(
                                );
                            throw re;
                        }
                        catch (java.lang.Exception e) {
                            dtm.
                              clearCoRoutine(
                                );
                            throw new org.apache.xml.utils.WrappedRuntimeException(
                              e);
                        }
                    }
                    else {
                        if (null ==
                              reader) {
                            return dtm;
                        }
                        reader.
                          setContentHandler(
                            dtm);
                        reader.
                          setDTDHandler(
                            dtm);
                        if (null ==
                              reader.
                              getErrorHandler(
                                )) {
                            reader.
                              setErrorHandler(
                                dtm);
                        }
                        try {
                            reader.
                              setProperty(
                                "http://xml.org/sax/properties/lexical-handler",
                                dtm);
                        }
                        catch (org.xml.sax.SAXNotRecognizedException e) {
                            
                        }
                        catch (org.xml.sax.SAXNotSupportedException e) {
                            
                        }
                        try {
                            reader.
                              parse(
                                xmlSource);
                        }
                        catch (java.lang.RuntimeException re) {
                            dtm.
                              clearCoRoutine(
                                );
                            throw re;
                        }
                        catch (java.lang.Exception e) {
                            dtm.
                              clearCoRoutine(
                                );
                            throw new org.apache.xml.utils.WrappedRuntimeException(
                              e);
                        }
                    }
                    if (DUMPTREE) {
                        java.lang.System.
                          out.
                          println(
                            "Dumping SAX2DOM");
                        dtm.
                          dumpDTM(
                            java.lang.System.
                              err);
                    }
                    return dtm;
                }
                finally {
                    if (reader !=
                          null &&
                          !(m_incremental &&
                              incremental)) {
                        reader.
                          setContentHandler(
                            m_defaultHandler);
                        reader.
                          setDTDHandler(
                            m_defaultHandler);
                        reader.
                          setErrorHandler(
                            m_defaultHandler);
                        try {
                            reader.
                              setProperty(
                                "http://xml.org/sax/properties/lexical-handler",
                                null);
                        }
                        catch (java.lang.Exception e) {
                            
                        }
                    }
                    releaseXMLReader(
                      reader);
                }
            }
            else {
                throw new org.apache.xml.dtm.DTMException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_NOT_SUPPORTED,
                      new java.lang.Object[] { source }));
            }
        }
    }
    public synchronized int getDTMHandleFromNode(org.w3c.dom.Node node) {
        if (null ==
              node)
            throw new java.lang.IllegalArgumentException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_NODE_NON_NULL,
                  null));
        if (node instanceof org.apache.xml.dtm.ref.DTMNodeProxy)
            return ((org.apache.xml.dtm.ref.DTMNodeProxy)
                      node).
              getDTMNodeNumber(
                );
        else {
            int max =
              m_dtms.
                length;
            for (int i =
                   0;
                 i <
                   max;
                 i++) {
                org.apache.xml.dtm.DTM thisDTM =
                  m_dtms[i];
                if (null !=
                      thisDTM &&
                      thisDTM instanceof org.apache.xml.dtm.ref.dom2dtm.DOM2DTM) {
                    int handle =
                      ((org.apache.xml.dtm.ref.dom2dtm.DOM2DTM)
                         thisDTM).
                      getHandleOfNode(
                        node);
                    if (handle !=
                          org.apache.xml.dtm.DTM.
                            NULL)
                        return handle;
                }
            }
            org.w3c.dom.Node root =
              node;
            org.w3c.dom.Node p =
              root.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ATTRIBUTE_NODE
              ? ((org.w3c.dom.Attr)
                   root).
              getOwnerElement(
                )
              : root.
              getParentNode(
                );
            for (;
                 p !=
                   null;
                 p =
                   p.
                     getParentNode(
                       )) {
                root =
                  p;
            }
            org.apache.xml.dtm.ref.dom2dtm.DOM2DTM dtm =
              (org.apache.xml.dtm.ref.dom2dtm.DOM2DTM)
                getDTM(
                  new javax.xml.transform.dom.DOMSource(
                    root),
                  false,
                  null,
                  true,
                  true);
            int handle;
            if (node instanceof org.apache.xml.dtm.ref.dom2dtm.DOM2DTMdefaultNamespaceDeclarationNode) {
                handle =
                  dtm.
                    getHandleOfNode(
                      ((org.w3c.dom.Attr)
                         node).
                        getOwnerElement(
                          ));
                handle =
                  dtm.
                    getAttributeNode(
                      handle,
                      node.
                        getNamespaceURI(
                          ),
                      node.
                        getLocalName(
                          ));
            }
            else
                handle =
                  ((org.apache.xml.dtm.ref.dom2dtm.DOM2DTM)
                     dtm).
                    getHandleOfNode(
                      node);
            if (org.apache.xml.dtm.DTM.
                  NULL ==
                  handle)
                throw new java.lang.RuntimeException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_COULD_NOT_RESOLVE_NODE,
                      null));
            return handle;
        }
    }
    public synchronized org.xml.sax.XMLReader getXMLReader(javax.xml.transform.Source inputSource) {
        try {
            org.xml.sax.XMLReader reader =
              inputSource instanceof javax.xml.transform.sax.SAXSource
              ? ((javax.xml.transform.sax.SAXSource)
                   inputSource).
              getXMLReader(
                )
              : null;
            if (null ==
                  reader) {
                if (m_readerManager ==
                      null) {
                    m_readerManager =
                      org.apache.xml.utils.XMLReaderManager.
                        getInstance(
                          );
                }
                reader =
                  m_readerManager.
                    getXMLReader(
                      );
            }
            return reader;
        }
        catch (org.xml.sax.SAXException se) {
            throw new org.apache.xml.dtm.DTMException(
              se.
                getMessage(
                  ),
              se);
        }
    }
    public synchronized void releaseXMLReader(org.xml.sax.XMLReader reader) {
        if (m_readerManager !=
              null) {
            m_readerManager.
              releaseXMLReader(
                reader);
        }
    }
    public synchronized org.apache.xml.dtm.DTM getDTM(int nodeHandle) {
        try {
            return m_dtms[nodeHandle >>>
                            IDENT_DTM_NODE_BITS];
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e) {
            if (nodeHandle ==
                  org.apache.xml.dtm.DTM.
                    NULL)
                return null;
            else
                throw e;
        }
    }
    public synchronized int getDTMIdentity(org.apache.xml.dtm.DTM dtm) {
        if (dtm instanceof org.apache.xml.dtm.ref.DTMDefaultBase) {
            org.apache.xml.dtm.ref.DTMDefaultBase dtmdb =
              (org.apache.xml.dtm.ref.DTMDefaultBase)
                dtm;
            if (dtmdb.
                  getManager(
                    ) ==
                  this)
                return dtmdb.
                  getDTMIDs(
                    ).
                  elementAt(
                    0);
            else
                return -1;
        }
        int n =
          m_dtms.
            length;
        for (int i =
               0;
             i <
               n;
             i++) {
            org.apache.xml.dtm.DTM tdtm =
              m_dtms[i];
            if (tdtm ==
                  dtm &&
                  m_dtm_offsets[i] ==
                  0)
                return i <<
                  IDENT_DTM_NODE_BITS;
        }
        return -1;
    }
    public synchronized boolean release(org.apache.xml.dtm.DTM dtm,
                                        boolean shouldHardDelete) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Releasing " +
                (shouldHardDelete
                   ? "HARD"
                   : "soft") +
                " dtm=" +
                dtm.
                  getDocumentBaseURI(
                    ));
        }
        if (dtm instanceof org.apache.xml.dtm.ref.sax2dtm.SAX2DTM) {
            ((org.apache.xml.dtm.ref.sax2dtm.SAX2DTM)
               dtm).
              clearCoRoutine(
                );
        }
        if (dtm instanceof org.apache.xml.dtm.ref.DTMDefaultBase) {
            org.apache.xml.utils.SuballocatedIntVector ids =
              ((org.apache.xml.dtm.ref.DTMDefaultBase)
                 dtm).
              getDTMIDs(
                );
            for (int i =
                   ids.
                   size(
                     ) -
                   1;
                 i >=
                   0;
                 --i)
                m_dtms[ids.
                         elementAt(
                           i) >>>
                         org.apache.xml.dtm.DTMManager.
                           IDENT_DTM_NODE_BITS] =
                  null;
        }
        else {
            int i =
              getDTMIdentity(
                dtm);
            if (i >=
                  0) {
                m_dtms[i >>>
                         org.apache.xml.dtm.DTMManager.
                           IDENT_DTM_NODE_BITS] =
                  null;
            }
        }
        dtm.
          documentRelease(
            );
        return true;
    }
    public synchronized org.apache.xml.dtm.DTM createDocumentFragment() {
        try {
            javax.xml.parsers.DocumentBuilderFactory dbf =
              javax.xml.parsers.DocumentBuilderFactory.
              newInstance(
                );
            dbf.
              setNamespaceAware(
                true);
            javax.xml.parsers.DocumentBuilder db =
              dbf.
              newDocumentBuilder(
                );
            org.w3c.dom.Document doc =
              db.
              newDocument(
                );
            org.w3c.dom.Node df =
              doc.
              createDocumentFragment(
                );
            return getDTM(
                     new javax.xml.transform.dom.DOMSource(
                       df),
                     true,
                     null,
                     false,
                     false);
        }
        catch (java.lang.Exception e) {
            throw new org.apache.xml.dtm.DTMException(
              e);
        }
    }
    public synchronized org.apache.xml.dtm.DTMIterator createDTMIterator(int whatToShow,
                                                                         org.apache.xml.dtm.DTMFilter filter,
                                                                         boolean entityReferenceExpansion) {
        return null;
    }
    public synchronized org.apache.xml.dtm.DTMIterator createDTMIterator(java.lang.String xpathString,
                                                                         org.apache.xml.utils.PrefixResolver presolver) {
        return null;
    }
    public synchronized org.apache.xml.dtm.DTMIterator createDTMIterator(int node) {
        return null;
    }
    public synchronized org.apache.xml.dtm.DTMIterator createDTMIterator(java.lang.Object xpathCompiler,
                                                                         int pos) {
        return null;
    }
    public org.apache.xml.dtm.ref.ExpandedNameTable getExpandedNameTable(org.apache.xml.dtm.DTM dtm) {
        return m_expandedNameTable;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC5AUxRnu3eOePO445BFewnEQQNj1bZnzBXccHN4dJ3dA" +
       "chiWudm+u4HZmWGm91hQRLCMlBUfAVRihMQKJlERLI0VK75I4gNi1JKo8RUf" +
       "sSqagJZWEvGRxPx/98zO7OzOAGGTrZqe2em//+7/6//VPb3nQ1JqmaTOkLSk" +
       "FGPrDGrFOvC5QzItmmxUJcvqgrcJ+fp3t208+vvKTVFS1k2G9UtWmyxZtFmh" +
       "atLqJhMUzWKSJlOrndIktugwqUXNAYkputZNRipWS8pQFVlhbXqSIsFSyWwl" +
       "wyXGTKUnzWiLzYCRU1v5aOJ8NPE5foKGVjJE1o11boOxOQ0aPXVIm3L7sxip" +
       "aV0lDUjxNFPUeKtisYaMSU4zdHVdn6qzGM2w2Cr1HBuIha3n5MFQd3/1p1/e" +
       "3F/DYRghaZrOuIjWYmrp6gBNtpJq9+08laasNeQqUtJKBnuIGalvdTqNQ6dx" +
       "6NSR16WC0Q+lWjrVqHNxmMOpzJBxQIxMzmViSKaUstl08DEDhwpmy84bg7ST" +
       "stI60+0T8ZbT4ttvW1HzQAmp7ibVitaJw5FhEAw66QZAaaqHmtacZJImu8lw" +
       "DSa8k5qKpCrr7dmutZQ+TWJpUAEHFnyZNqjJ+3SxgpkE2cy0zHQzK14vVyr7" +
       "X2mvKvWBrKNcWYWEzfgeBKxSYGBmrwS6ZzcZtFrRklyPcltkZay/FAigaXmK" +
       "sn4929UgTYIXpFaoiCppffFOUD6tD0hLdVBBk+taAFPE2pDk1VIfTTAyxk/X" +
       "IaqAqpIDgU0YGekn45xglsb6ZskzPx+2X3DjFdoCLUoiMOYklVUc/2BoNNHX" +
       "aDHtpSYFOxANh8xsvVUa9diWKCFAPNJHLGh+ceUnl8yauP+AoBlXgGZRzyoq" +
       "s4S8u2fYi+MbZ5xfgsOoMHRLwcnPkZxbWYdd05AxwNOMynLEyphTuX/x09+6" +
       "+h56OEqqWkiZrKvpFOjRcFlPGYpKzflUo6bEaLKFVFIt2cjrW0g5PLcqGhVv" +
       "F/X2WpS1kEEqf1Wm8/8AUS+wQIiq4FnRenXn2ZBYP3/OGISQcrjIELhaiPjx" +
       "OyNKvF9P0bgkS5qi6fEOU0f5cUK5z6EWPCeh1tDjGQmUZvaqxJmJ8xJnxi1T" +
       "jutmX1wCrein8UxKjSdZKm7S3nhTV1ubpIE6mE20V0qr4HVA5Yz/Z2cZlHzE" +
       "2kgEJmW83yWoYE0LdDVJzYS8PT133id7E88KdUMTsTFjZDr0GBM9xqDHGPQY" +
       "gx5jeT2SSIR3dAr2LGYe5m01eABwwUNmdH574cotdSWgcsbaQQA6kk7LC0mN" +
       "rqtw/HtC3vPi4qMvPFd1T5REwZv0QEhy40J9TlwQYc3UZZoExxQUIRwvGQ+O" +
       "CQXHQfbvWLtp6cbT+Ti8rh4ZloKXwuYd6KCzXdT7TbwQ3+rrPvh0360bdNfY" +
       "c2KHE/LyWqIPqfNPq1/4hDxzkvRQ4rEN9VEyCBwTOGMmgfGAn5vo7yPHlzQ4" +
       "fhllqQCBe3UzJalY5TjTKtZv6mvdN1zfhvPnU2CKK9G4xsL1gm1t/I61owws" +
       "Rwv9RJ3xScH9/oWdxs5Xn//LWRxuJ0RUe2J7J2UNHreEzGq5AxruqmCXSSnQ" +
       "/XFHx7ZbPrxuOdc/oJhSqMN6LBvBHcEUAszXHljz2ttv7X4p6uosg7ic7oEU" +
       "J5MVMooyVYQIiXrujgfcmgrWjlpTv0QDrVR6FalHpWgk/6yeesZDR26sEXqg" +
       "whtHjWYdm4H7/mtzydXPrjg6kbOJyBhWXcxcMuGrR7ic55imtA7Hkdl0aML3" +
       "n5F2gtcHT2sp6yl3noRjQPiknc3lj/PyLF/duVjUW17lz7UvT/qTkG9+6eOh" +
       "Sz9+/BM+2tz8yTvXbZLRINQLi6kZYD/a72gWSFY/0J29v/3yGnX/l8CxGzjK" +
       "kDRYi0zwc5kczbCpS8tf/9VvRq18sYREm0mVqkvJZokbGakE7aZWP7jIjHHx" +
       "JWJy1+JM13BRSZ7wiOephWdqXspgHNv1D4/++QU/3fUWVyqhReN483IL0za/" +
       "P+S5t2vKR974wXtPHP1xuYjcM4L9l6/dmC8WqT2b//RZHsjccxXIKnztu+N7" +
       "7hjbeNFh3t51Idh6SiY/toCTddueeU/qH9G6sqeipLyb1Mh2nrtUUtNomN2Q" +
       "21lO8gu5cE59bp4mkpKGrIsc73dfnm79zsuNafCM1Pg81OevRuMsng5Xu23K" +
       "7X5/xQOc0CEcUmyurqtU0p6bZF798h1ffMQ1rnQAhw4Wg03mc+bTeDkDi1l8" +
       "sksYKTdMBVZOIGOZxZNvBiNWNEn1uZZRIeNhpKJpSVtH1+J587i5ebQHV2Cd" +
       "6R6LdZhKCtzjgJ0f7ht1dM2T5eubnNyvUBNBeanV9sIvF7yf4O63AqNul4Ob" +
       "J57OMfs8vr9GjP0r+EXg+jdeOGZ8ITKt2kY73ZuUzfcMA605RJl9IsQ31L69" +
       "+o4P7hMi+DXXR0y3bL/+q9iN24VPFYuGKXl5u7eNWDgIcbBYgqObHNYLb9H8" +
       "/r4Nj/xsw3ViVLW5KfA8WOHd98q/fhfb8c7BAjlWeY/Qo6xHiWRTpFH+GRJi" +
       "lZ2x8/ON33l1EcT0FlKR1pQ1adqSzNXzcivd45kyd0ni6r4tIE4P5G8zYSZE" +
       "RMbyPCwWCG38RqD/m5NrPbPhuszW1svyrQfvC7GgAXaBj21YtGOxqIAtBHEH" +
       "82maN3fJfPzT5ZOi9/ilwMUBmQ7XCrufFXlSEP6QKiwBpAiVhqkz8FQ06Rv+" +
       "4BC24AZSCcitLZjzqcGmwGO0UIFdP5ny/MZdU97lTqdCscD7gTEWWFZ62ny8" +
       "5+3Dh4ZO2MtTwUFo07Zy5K7H85fbOatoriTVuZBVh0HGScdAIlJgLQHriDy1" +
       "51OCxVoH7SsKox3Fx9lCVbgqA4wq1fpYP6dcZtsv3pYzUgJi4eOAHXixy6jg" +
       "44xwhOvbG1Vdo5hZOXViYaPosexOCFRmCtjs5Lww3sbRc2PieYeOlryxdcyQ" +
       "/BUNcpsYsF6ZGawX/g6e2fzXsV0X9a88gaXKqT618bO8u23PwfnT5K1Rvo0i" +
       "QnDe9ktuo4Zch1RlUpY2tVwXVCfmmc+LmGQsZvKZC0kybwqp+x4W3wWHIOMU" +
       "ihkPId/ONeziDPF5De34vQY376lwpWwTSAV4jdsK6zHxeYpoCCtGhnJPkRB7" +
       "HxZvybLt65H866CI94rm4s7IsiLvOoDdOhsa/yvWApTFwoix3Og3Nvwr5Ztg" +
       "1n/scnDffZz+A4ureFdY7Mx3FPj3GiyuLdztFtEtb43FDSGKd29I3X1Y3I3F" +
       "VjGSENp9AQq84wTD3tlwWbbWWQEK/IBro0Z+dAtqDWu5VMKkEizC7E0jx6lO" +
       "9YUETJes2DfbWhd7qX2CPXiCgjXyGvHLBAj2SKhgQa0ZqQFjFBtgC0DdVVey" +
       "OpQMRbKkTKyfqpB8WbGmHFKfWI8ev1hV+HY8XAftgR0IEOvJgDQFH9t8XqfS" +
       "4VOAH4TGVAJWNTBwmmwHn97lDY1Bm4Tz/A18Ej8VInHGEw2y4+S/MuLbwPWM" +
       "07OiJpi4TwjaY+dJ++7N23clF911RtS2pMshe2O6MVulA1T1sBLrmi3ZYWAi" +
       "Ss6Ea7M9jM1++F1BA5wOI0OsdZrcb+qasj4vVRwZwtvnCTyOifd6Jy/fDPEX" +
       "b2HxMqRKUjLppF++VGnQgK4k3Xl65ViambMNwr1RIcQugusmW6qbThgxLF4r" +
       "gFMQRx8CJe4KQ+DkgnUkBKyPsPhzFiz8944LzPsnDQzuj5LT4HrYFuPhogET" +
       "xDFE2s9D6r7E4m+MDO+jrFkxLdZsUgqQtDRxJF1Q/l4cUCbBdcQW4UjRQAni" +
       "6BO8lLMqdRzcWJ6PcN/GTFio4154rFNPmyJj73LoJhZe4SzrbFZUJhw+X5x2" +
       "oQCRsmC0I0OwgLytDNC29S6ThTgSKQ7EMYgEhwUHcS8GxIEcfdJ60yaArgah" +
       "W3uWHEvqqVg7LH84DCHKGhmHxXBYmAmIRFBtNvUUts7VyUjtSQOG6khmgZhd" +
       "goO4FwOwQI6FAUNxyjkA00LAmY7FJIgyAE42nXKwHunNTXJrOVqTi+PvLwSZ" +
       "BmzZBoqGVhDHYLRmckTOCUGLSx0HJTSpSmE5nsVkTY6/j5xeNNcWvcYW45qi" +
       "ARPEMRAYEf4ic0OAQd8euSDIDV1YHDimw6B32oPfWTQ4gjgGw5HhIi8KgeMy" +
       "LFoYGSbgaElSjSlsnc/ZLDxpWCZi1VQY/NO2EE8XDZYgjsdIK0XEujwEmxVY" +
       "LGWk3LYh3soFZVlxdOV0GNTntgifFw2UII4h4iohdauxwC+vMix6GW3S5XQK" +
       "NKXZlPrw7rOi5EkjU4dVQFUyRnAQ92IgE8gxOLu+04ky4wsnQ55UiIM1EALk" +
       "eiwMyDltIMHkGOVf54+RceWQcZTXFA/lGTYmM4qGchDHwkaZTZnc3WpxiM2p" +
       "mFJwV6UDluRKxj6YZ3J8rwvB/gYsNhXCHiuudJHdXDxkz7dxOL9oyAZxPFZQ" +
       "3BGCzO1YbD0OZLYVDxl7w6PEv+Hx3yMTxPG4dU58kHchuysEMtzKjPzwOCD7" +
       "0UlDNg6r4iDYMlvAZSGQYTEzF5uKkKbHyh0eDIHgISz2iuVKwY2x37oo7Dtx" +
       "FDIAbt6hPDySMibvMLA4wCrv3VVdMXrXkj+Ir4HOIdMhraSiN62q3hMTnucy" +
       "g3sRTinOT/CPxpFHC3/eA2JGSqDEUUceEbRPMFKbTwt0+AHUQ/drSLRy6YAG" +
       "Si/NU4xUuTS4T8MfvCQHoBWQ4ONBw9HjCYXjhg1fRixLsxuJzsSQkceaGM/e" +
       "45Sc73X85LbzbS0tzm4n5H27FrZf8cm5d4lDbrIqrceQRwa3knJx3o4zxe9z" +
       "kwO5ObzKFsz4ctj9lVOd3czhYsCuto9ztZFcDHproHqM9Z0As+qzB8Fe233B" +
       "489tKTsUJZHlJCIxMmJ5/nmcjJE2yanLWwsdVFgqmfxwWkPVeytf+Oz1SC0/" +
       "9kTEZ9KJYS0S8rbH3+joNYzbo6SyhZQqYC0ZflioaZ22mMoDZs65h7IePa1l" +
       "v18PQ12WMCByZGxAh2bf4iFJRuryj4HkHxytUvW11JyL3JHNUN8XzbRheGs5" +
       "siuxWMK/FIDiJVrbDMM5/9LBkTcMtNjIm/hH+g/Ae/pHnjEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZX0m14bNMNl0IGMWUea0S1jrtTYktGkv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "2efv/yc//ivPfa3YGPj/ACtfMQqFPwAA");
}
