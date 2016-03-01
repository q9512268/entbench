package org.apache.xml.dtm.ref;
public class IncrementalSAXSource_Xerces implements org.apache.xml.dtm.ref.IncrementalSAXSource {
    java.lang.reflect.Method fParseSomeSetup = null;
    java.lang.reflect.Method fParseSome = null;
    java.lang.Object fPullParserConfig = null;
    java.lang.reflect.Method fConfigSetInput = null;
    java.lang.reflect.Method fConfigParse = null;
    java.lang.reflect.Method fSetInputSource = null;
    java.lang.reflect.Constructor fConfigInputSourceCtor = null;
    java.lang.reflect.Method fConfigSetByteStream = null;
    java.lang.reflect.Method fConfigSetCharStream = null;
    java.lang.reflect.Method fConfigSetEncoding = null;
    java.lang.reflect.Method fReset = null;
    org.apache.xerces.parsers.SAXParser fIncrementalParser;
    private boolean fParseInProgress = false;
    public IncrementalSAXSource_Xerces() throws java.lang.NoSuchMethodException {
        super(
          );
        try {
            java.lang.Class xniConfigClass =
              org.apache.xml.dtm.ref.ObjectFactory.
              findProviderClass(
                "org.apache.xerces.xni.parser.XMLParserConfiguration",
                org.apache.xml.dtm.ref.ObjectFactory.
                  findClassLoader(
                    ),
                true);
            java.lang.Class[] args1 =
              { xniConfigClass };
            java.lang.reflect.Constructor ctor =
              org.apache.xerces.parsers.SAXParser.class.
              getConstructor(
                args1);
            java.lang.Class xniStdConfigClass =
              org.apache.xml.dtm.ref.ObjectFactory.
              findProviderClass(
                "org.apache.xerces.parsers.StandardParserConfiguration",
                org.apache.xml.dtm.ref.ObjectFactory.
                  findClassLoader(
                    ),
                true);
            fPullParserConfig =
              xniStdConfigClass.
                newInstance(
                  );
            java.lang.Object[] args2 =
              { fPullParserConfig };
            fIncrementalParser =
              (org.apache.xerces.parsers.SAXParser)
                ctor.
                newInstance(
                  args2);
            java.lang.Class fXniInputSourceClass =
              org.apache.xml.dtm.ref.ObjectFactory.
              findProviderClass(
                "org.apache.xerces.xni.parser.XMLInputSource",
                org.apache.xml.dtm.ref.ObjectFactory.
                  findClassLoader(
                    ),
                true);
            java.lang.Class[] args3 =
              { fXniInputSourceClass };
            fConfigSetInput =
              xniStdConfigClass.
                getMethod(
                  "setInputSource",
                  args3);
            java.lang.Class[] args4 =
              { java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class };
            fConfigInputSourceCtor =
              fXniInputSourceClass.
                getConstructor(
                  args4);
            java.lang.Class[] args5 =
              { java.io.InputStream.class };
            fConfigSetByteStream =
              fXniInputSourceClass.
                getMethod(
                  "setByteStream",
                  args5);
            java.lang.Class[] args6 =
              { java.io.Reader.class };
            fConfigSetCharStream =
              fXniInputSourceClass.
                getMethod(
                  "setCharacterStream",
                  args6);
            java.lang.Class[] args7 =
              { java.lang.String.class };
            fConfigSetEncoding =
              fXniInputSourceClass.
                getMethod(
                  "setEncoding",
                  args7);
            java.lang.Class[] argsb =
              { java.lang.Boolean.
                  TYPE };
            fConfigParse =
              xniStdConfigClass.
                getMethod(
                  "parse",
                  argsb);
            java.lang.Class[] noargs =
              new java.lang.Class[0];
            fReset =
              fIncrementalParser.
                getClass(
                  ).
                getMethod(
                  "reset",
                  noargs);
        }
        catch (java.lang.Exception e) {
            org.apache.xml.dtm.ref.IncrementalSAXSource_Xerces dummy =
              new org.apache.xml.dtm.ref.IncrementalSAXSource_Xerces(
              new org.apache.xerces.parsers.SAXParser(
                ));
            this.
              fParseSomeSetup =
              dummy.
                fParseSomeSetup;
            this.
              fParseSome =
              dummy.
                fParseSome;
            this.
              fIncrementalParser =
              dummy.
                fIncrementalParser;
        }
    }
    public IncrementalSAXSource_Xerces(org.apache.xerces.parsers.SAXParser parser)
          throws java.lang.NoSuchMethodException { super(
                                                     );
                                                   fIncrementalParser =
                                                     parser;
                                                   java.lang.Class me =
                                                     parser.
                                                     getClass(
                                                       );
                                                   java.lang.Class[] parms =
                                                     { org.xml.sax.InputSource.class };
                                                   fParseSomeSetup =
                                                     me.
                                                       getMethod(
                                                         "parseSomeSetup",
                                                         parms);
                                                   parms =
                                                     (new java.lang.Class[0]);
                                                   fParseSome =
                                                     me.
                                                       getMethod(
                                                         "parseSome",
                                                         parms);
    }
    public static org.apache.xml.dtm.ref.IncrementalSAXSource createIncrementalSAXSource() {
        try {
            return new org.apache.xml.dtm.ref.IncrementalSAXSource_Xerces(
              );
        }
        catch (java.lang.NoSuchMethodException e) {
            org.apache.xml.dtm.ref.IncrementalSAXSource_Filter iss =
              new org.apache.xml.dtm.ref.IncrementalSAXSource_Filter(
              );
            iss.
              setXMLReader(
                new org.apache.xerces.parsers.SAXParser(
                  ));
            return iss;
        }
    }
    public static org.apache.xml.dtm.ref.IncrementalSAXSource createIncrementalSAXSource(org.apache.xerces.parsers.SAXParser parser) {
        try {
            return new org.apache.xml.dtm.ref.IncrementalSAXSource_Xerces(
              parser);
        }
        catch (java.lang.NoSuchMethodException e) {
            org.apache.xml.dtm.ref.IncrementalSAXSource_Filter iss =
              new org.apache.xml.dtm.ref.IncrementalSAXSource_Filter(
              );
            iss.
              setXMLReader(
                parser);
            return iss;
        }
    }
    public void setContentHandler(org.xml.sax.ContentHandler handler) {
        ((org.xml.sax.XMLReader)
           fIncrementalParser).
          setContentHandler(
            handler);
    }
    public void setLexicalHandler(org.xml.sax.ext.LexicalHandler handler) {
        try {
            ((org.xml.sax.XMLReader)
               fIncrementalParser).
              setProperty(
                "http://xml.org/sax/properties/lexical-handler",
                handler);
        }
        catch (org.xml.sax.SAXNotRecognizedException e) {
            
        }
        catch (org.xml.sax.SAXNotSupportedException e) {
            
        }
    }
    public void setDTDHandler(org.xml.sax.DTDHandler handler) {
        ((org.xml.sax.XMLReader)
           fIncrementalParser).
          setDTDHandler(
            handler);
    }
    public void startParse(org.xml.sax.InputSource source)
          throws org.xml.sax.SAXException {
        if (fIncrementalParser ==
              null)
            throw new org.xml.sax.SAXException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_STARTPARSE_NEEDS_SAXPARSER,
                  null));
        if (fParseInProgress)
            throw new org.xml.sax.SAXException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_STARTPARSE_WHILE_PARSING,
                  null));
        boolean ok =
          false;
        try {
            ok =
              parseSomeSetup(
                source);
        }
        catch (java.lang.Exception ex) {
            throw new org.xml.sax.SAXException(
              ex);
        }
        if (!ok)
            throw new org.xml.sax.SAXException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_COULD_NOT_INIT_PARSER,
                  null));
    }
    public java.lang.Object deliverMoreNodes(boolean parsemore) {
        if (!parsemore) {
            fParseInProgress =
              false;
            return java.lang.Boolean.
                     FALSE;
        }
        java.lang.Object arg;
        try {
            boolean keepgoing =
              parseSome(
                );
            arg =
              keepgoing
                ? java.lang.Boolean.
                    TRUE
                : java.lang.Boolean.
                    FALSE;
        }
        catch (org.xml.sax.SAXException ex) {
            arg =
              ex;
        }
        catch (java.io.IOException ex) {
            arg =
              ex;
        }
        catch (java.lang.Exception ex) {
            arg =
              new org.xml.sax.SAXException(
                ex);
        }
        return arg;
    }
    private boolean parseSomeSetup(org.xml.sax.InputSource source)
          throws org.xml.sax.SAXException,
        java.io.IOException,
        java.lang.IllegalAccessException,
        java.lang.reflect.InvocationTargetException,
        java.lang.InstantiationException {
        if (fConfigSetInput !=
              null) {
            java.lang.Object[] parms1 =
              { source.
              getPublicId(
                ),
            source.
              getSystemId(
                ),
            null };
            java.lang.Object xmlsource =
              fConfigInputSourceCtor.
              newInstance(
                parms1);
            java.lang.Object[] parmsa =
              { source.
              getByteStream(
                ) };
            fConfigSetByteStream.
              invoke(
                xmlsource,
                parmsa);
            parmsa[0] =
              source.
                getCharacterStream(
                  );
            fConfigSetCharStream.
              invoke(
                xmlsource,
                parmsa);
            parmsa[0] =
              source.
                getEncoding(
                  );
            fConfigSetEncoding.
              invoke(
                xmlsource,
                parmsa);
            java.lang.Object[] noparms =
              new java.lang.Object[0];
            fReset.
              invoke(
                fIncrementalParser,
                noparms);
            parmsa[0] =
              xmlsource;
            fConfigSetInput.
              invoke(
                fPullParserConfig,
                parmsa);
            return parseSome(
                     );
        }
        else {
            java.lang.Object[] parm =
              { source };
            java.lang.Object ret =
              fParseSomeSetup.
              invoke(
                fIncrementalParser,
                parm);
            return ((java.lang.Boolean)
                      ret).
              booleanValue(
                );
        }
    }
    private static final java.lang.Object[]
      noparms =
      new java.lang.Object[0];
    private static final java.lang.Object[]
      parmsfalse =
      { java.lang.Boolean.
          FALSE };
    private boolean parseSome() throws org.xml.sax.SAXException,
        java.io.IOException,
        java.lang.IllegalAccessException,
        java.lang.reflect.InvocationTargetException {
        if (fConfigSetInput !=
              null) {
            java.lang.Object ret =
              (java.lang.Boolean)
                fConfigParse.
                invoke(
                  fPullParserConfig,
                  parmsfalse);
            return ((java.lang.Boolean)
                      ret).
              booleanValue(
                );
        }
        else {
            java.lang.Object ret =
              fParseSome.
              invoke(
                fIncrementalParser,
                noparms);
            return ((java.lang.Boolean)
                      ret).
              booleanValue(
                );
        }
    }
    public static void main(java.lang.String[] args) {
        java.lang.System.
          out.
          println(
            "Starting...");
        org.apache.xml.dtm.ref.CoroutineManager co =
          new org.apache.xml.dtm.ref.CoroutineManager(
          );
        int appCoroutineID =
          co.
          co_joinCoroutineSet(
            -1);
        if (appCoroutineID ==
              -1) {
            java.lang.System.
              out.
              println(
                "ERROR: Couldn\'t allocate coroutine number.\n");
            return;
        }
        org.apache.xml.dtm.ref.IncrementalSAXSource parser =
          createIncrementalSAXSource(
            );
        org.apache.xml.serialize.XMLSerializer trace;
        trace =
          new org.apache.xml.serialize.XMLSerializer(
            java.lang.System.
              out,
            null);
        parser.
          setContentHandler(
            trace);
        parser.
          setLexicalHandler(
            trace);
        for (int arg =
               0;
             arg <
               args.
                 length;
             ++arg) {
            try {
                org.xml.sax.InputSource source =
                  new org.xml.sax.InputSource(
                  args[arg]);
                java.lang.Object result =
                  null;
                boolean more =
                  true;
                parser.
                  startParse(
                    source);
                for (result =
                       parser.
                         deliverMoreNodes(
                           more);
                     result ==
                       java.lang.Boolean.
                         TRUE;
                     result =
                       parser.
                         deliverMoreNodes(
                           more)) {
                    java.lang.System.
                      out.
                      println(
                        "\nSome parsing successful, trying more.\n");
                    if (arg +
                          1 <
                          args.
                            length &&
                          "!".
                          equals(
                            args[arg +
                                   1])) {
                        ++arg;
                        more =
                          false;
                    }
                }
                if (result instanceof java.lang.Boolean &&
                      (java.lang.Boolean)
                        result ==
                      java.lang.Boolean.
                        FALSE) {
                    java.lang.System.
                      out.
                      println(
                        "\nParser ended (EOF or on request).\n");
                }
                else
                    if (result ==
                          null) {
                        java.lang.System.
                          out.
                          println(
                            "\nUNEXPECTED: Parser says shut down prematurely.\n");
                    }
                    else
                        if (result instanceof java.lang.Exception) {
                            throw new org.apache.xml.utils.WrappedRuntimeException(
                              (java.lang.Exception)
                                result);
                        }
            }
            catch (org.xml.sax.SAXException e) {
                e.
                  printStackTrace(
                    );
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "elCPhNV61AyJUlxiU8IdzRSp5cYkClnCQqkNQmeCx54lk3TkzgwzHNjtwXrq" +
       "ruvFCBlS7VokTznOyJY/SrEIwhs7qrXKvtVuaUyrJ/QH2nCkrpQWAbs0wtag" +
       "OuPxnXbFUskx1rVqS14pKk5lPjCUYSgIiaeuA3pid8L1LMDEqoca82ghLX1S" +
       "10ytI/JaedRhCJsbcVQVg1el4XAZRhFXMycbQeRwokTEzKiBz4Cv58dO1eZ6" +
       "codZLKwGBobchoy7Zb06iwl3ZhHdgYuPrHRRE3kURTdQtBjEqyrLtCmuyG+M" +
       "OtSA4HKxp0z7eBUtirgT9fSWUeywiVRbN3sbuCUu1onAOiLbreoGcOpIZC+E" +
       "6bKJD0nS9PozKZD7TENoknXHCpeos3CwQdrQatAQHjSpMeomWpVNo1Jkd2sl" +
       "ekDKbXnsqEBrcsgZxbmI8sUVbFn2ROimNbU8jKYmBiwA6SgzARLp2CsixUlT" +
       "qNJN2uc1QYM4E9eqY8K3hUbVYzozC9MmU6Q49KYcmSL9Cs34swlfSVxqqK43" +
       "Lha41hJWOoTiL90J1eOFMV4SFj5tm8Ox2R36FVwYQTir1wRdr4zGYlOgBKYX" +
       "r8a9LmkTXQiexk0FoduVdBjLfLVXx+q1YVCFfaDPqhQHi0RB5m0RAV6hFnsU" +
       "XSW4xRwLWGGTVDYe2U74ZkI249p0ErS6I9KyGSEaDs2KgqhR7FfiyYyjmE4J" +
       "LXfG3bnIxhpNNsma39LSKSTKbaI01DlyqmGJt2iKKIS2fDD2i1xHZPU+as+q" +
       "yyK5pJHIm3U7nuVp1pSaVpAK3GvTVG2oWHWkXmV9peUhLagUN416JdEVLm03" +
       "mUVqeWwEl4Q0UPjhZEaJU9RZKXE5mZldChuIWHcOla0u2/LIQa2+rEhzYlyr" +
       "CmyDThc2TCIybpbhdRI1mBJlQBAYYyBlPRiVFUjknc2oLvAcFZvVBUF3VihR" +
       "CdG6R2LrotceNGaboa8E3ghK+zVC40h1Xg4TrONrC6mFmRpTT5x4ggS12nJT" +
       "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" +
       "pbPsrOkiRg34huG4Zt9NlA1elR3C11pK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "J8hP+W2++Op/+rZ/8tw38k1j/w/oQqCy00AAAA==");
}
