package org.apache.xalan.templates;
public class FuncDocument extends org.apache.xpath.functions.Function2Args {
    static final long serialVersionUID = 2483304325971281424L;
    public org.apache.xpath.objects.XObject execute(org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException { int context =
                                                              xctxt.
                                                              getCurrentNode(
                                                                );
                                                            org.apache.xml.dtm.DTM dtm =
                                                              xctxt.
                                                              getDTM(
                                                                context);
                                                            int docContext =
                                                              dtm.
                                                              getDocumentRoot(
                                                                context);
                                                            org.apache.xpath.objects.XObject arg =
                                                              (org.apache.xpath.objects.XObject)
                                                                this.
                                                                getArg0(
                                                                  ).
                                                                execute(
                                                                  xctxt);
                                                            java.lang.String base =
                                                              "";
                                                            org.apache.xpath.Expression arg1Expr =
                                                              this.
                                                              getArg1(
                                                                );
                                                            if (null !=
                                                                  arg1Expr) {
                                                                org.apache.xpath.objects.XObject arg2 =
                                                                  arg1Expr.
                                                                  execute(
                                                                    xctxt);
                                                                if (org.apache.xpath.objects.XObject.
                                                                      CLASS_NODESET ==
                                                                      arg2.
                                                                      getType(
                                                                        )) {
                                                                    int baseNode =
                                                                      arg2.
                                                                      iter(
                                                                        ).
                                                                      nextNode(
                                                                        );
                                                                    if (baseNode ==
                                                                          org.apache.xml.dtm.DTM.
                                                                            NULL) {
                                                                        warn(
                                                                          xctxt,
                                                                          org.apache.xalan.res.XSLTErrorResources.
                                                                            WG_EMPTY_SECOND_ARG,
                                                                          null);
                                                                        org.apache.xpath.objects.XNodeSet nodes =
                                                                          new org.apache.xpath.objects.XNodeSet(
                                                                          xctxt.
                                                                            getDTMManager(
                                                                              ));
                                                                        return nodes;
                                                                    }
                                                                    else {
                                                                        org.apache.xml.dtm.DTM baseDTM =
                                                                          xctxt.
                                                                          getDTM(
                                                                            baseNode);
                                                                        base =
                                                                          baseDTM.
                                                                            getDocumentBaseURI(
                                                                              );
                                                                    }
                                                                }
                                                                else {
                                                                    arg2.
                                                                      iter(
                                                                        );
                                                                }
                                                            }
                                                            else {
                                                                assertion(
                                                                  null !=
                                                                    xctxt.
                                                                    getNamespaceContext(
                                                                      ),
                                                                  "Namespace context can not be null!");
                                                                base =
                                                                  xctxt.
                                                                    getNamespaceContext(
                                                                      ).
                                                                    getBaseIdentifier(
                                                                      );
                                                            }
                                                            org.apache.xpath.objects.XNodeSet nodes =
                                                              new org.apache.xpath.objects.XNodeSet(
                                                              xctxt.
                                                                getDTMManager(
                                                                  ));
                                                            org.apache.xpath.NodeSetDTM mnl =
                                                              nodes.
                                                              mutableNodeset(
                                                                );
                                                            org.apache.xml.dtm.DTMIterator iterator =
                                                              org.apache.xpath.objects.XObject.
                                                                CLASS_NODESET ==
                                                              arg.
                                                              getType(
                                                                )
                                                              ? arg.
                                                              iter(
                                                                )
                                                              : null;
                                                            int pos =
                                                              org.apache.xml.dtm.DTM.
                                                                NULL;
                                                            while (null ==
                                                                     iterator ||
                                                                     org.apache.xml.dtm.DTM.
                                                                       NULL !=
                                                                     (pos =
                                                                        iterator.
                                                                          nextNode(
                                                                            ))) {
                                                                org.apache.xml.utils.XMLString ref =
                                                                  null !=
                                                                  iterator
                                                                  ? xctxt.
                                                                  getDTM(
                                                                    pos).
                                                                  getStringValue(
                                                                    pos)
                                                                  : arg.
                                                                  xstr(
                                                                    );
                                                                if (null ==
                                                                      arg1Expr &&
                                                                      org.apache.xml.dtm.DTM.
                                                                        NULL !=
                                                                      pos) {
                                                                    org.apache.xml.dtm.DTM baseDTM =
                                                                      xctxt.
                                                                      getDTM(
                                                                        pos);
                                                                    base =
                                                                      baseDTM.
                                                                        getDocumentBaseURI(
                                                                          );
                                                                }
                                                                if (null ==
                                                                      ref)
                                                                    continue;
                                                                if (org.apache.xml.dtm.DTM.
                                                                      NULL ==
                                                                      docContext) {
                                                                    error(
                                                                      xctxt,
                                                                      org.apache.xalan.res.XSLTErrorResources.
                                                                        ER_NO_CONTEXT_OWNERDOC,
                                                                      null);
                                                                }
                                                                int indexOfColon =
                                                                  ref.
                                                                  indexOf(
                                                                    ':');
                                                                int indexOfSlash =
                                                                  ref.
                                                                  indexOf(
                                                                    '/');
                                                                if (indexOfColon !=
                                                                      -1 &&
                                                                      indexOfSlash !=
                                                                      -1 &&
                                                                      indexOfColon <
                                                                      indexOfSlash) {
                                                                    base =
                                                                      null;
                                                                }
                                                                int newDoc =
                                                                  getDoc(
                                                                    xctxt,
                                                                    context,
                                                                    ref.
                                                                      toString(
                                                                        ),
                                                                    base);
                                                                if (org.apache.xml.dtm.DTM.
                                                                      NULL !=
                                                                      newDoc) {
                                                                    if (!mnl.
                                                                          contains(
                                                                            newDoc)) {
                                                                        mnl.
                                                                          addElement(
                                                                            newDoc);
                                                                    }
                                                                }
                                                                if (null ==
                                                                      iterator ||
                                                                      newDoc ==
                                                                      org.apache.xml.dtm.DTM.
                                                                        NULL)
                                                                    break;
                                                            }
                                                            return nodes;
    }
    int getDoc(org.apache.xpath.XPathContext xctxt,
               int context,
               java.lang.String uri,
               java.lang.String base) throws javax.xml.transform.TransformerException {
        org.apache.xpath.SourceTreeManager treeMgr =
          xctxt.
          getSourceTreeManager(
            );
        javax.xml.transform.Source source;
        int newDoc;
        try {
            source =
              treeMgr.
                resolveURI(
                  base,
                  uri,
                  xctxt.
                    getSAXLocator(
                      ));
            newDoc =
              treeMgr.
                getNode(
                  source);
        }
        catch (java.io.IOException ioe) {
            throw new javax.xml.transform.TransformerException(
              ioe.
                getMessage(
                  ),
              (javax.xml.transform.SourceLocator)
                xctxt.
                getSAXLocator(
                  ),
              ioe);
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new javax.xml.transform.TransformerException(
              te);
        }
        if (org.apache.xml.dtm.DTM.
              NULL !=
              newDoc)
            return newDoc;
        if (uri.
              length(
                ) ==
              0) {
            uri =
              xctxt.
                getNamespaceContext(
                  ).
                getBaseIdentifier(
                  );
            try {
                source =
                  treeMgr.
                    resolveURI(
                      base,
                      uri,
                      xctxt.
                        getSAXLocator(
                          ));
            }
            catch (java.io.IOException ioe) {
                throw new javax.xml.transform.TransformerException(
                  ioe.
                    getMessage(
                      ),
                  (javax.xml.transform.SourceLocator)
                    xctxt.
                    getSAXLocator(
                      ),
                  ioe);
            }
        }
        java.lang.String diagnosticsString =
          null;
        try {
            if (null !=
                  uri &&
                  uri.
                  length(
                    ) >
                  0) {
                newDoc =
                  treeMgr.
                    getSourceTree(
                      source,
                      xctxt.
                        getSAXLocator(
                          ),
                      xctxt);
            }
            else
                warn(
                  xctxt,
                  org.apache.xalan.res.XSLTErrorResources.
                    WG_CANNOT_MAKE_URL_FROM,
                  new java.lang.Object[] { (base ==
                                              null
                                              ? ""
                                              : base) +
                  uri });
        }
        catch (java.lang.Throwable throwable) {
            newDoc =
              org.apache.xml.dtm.DTM.
                NULL;
            while (throwable instanceof org.apache.xml.utils.WrappedRuntimeException) {
                throwable =
                  ((org.apache.xml.utils.WrappedRuntimeException)
                     throwable).
                    getException(
                      );
            }
            if (throwable instanceof java.lang.NullPointerException ||
                  throwable instanceof java.lang.ClassCastException) {
                throw new org.apache.xml.utils.WrappedRuntimeException(
                  (java.lang.Exception)
                    throwable);
            }
            java.io.StringWriter sw =
              new java.io.StringWriter(
              );
            java.io.PrintWriter diagnosticsWriter =
              new java.io.PrintWriter(
              sw);
            if (throwable instanceof javax.xml.transform.TransformerException) {
                javax.xml.transform.TransformerException spe =
                  (javax.xml.transform.TransformerException)
                    throwable;
                {
                    java.lang.Throwable e =
                      spe;
                    while (null !=
                             e) {
                        if (null !=
                              e.
                              getMessage(
                                )) {
                            diagnosticsWriter.
                              println(
                                " (" +
                                e.
                                  getClass(
                                    ).
                                  getName(
                                    ) +
                                "): " +
                                e.
                                  getMessage(
                                    ));
                        }
                        if (e instanceof javax.xml.transform.TransformerException) {
                            javax.xml.transform.TransformerException spe2 =
                              (javax.xml.transform.TransformerException)
                                e;
                            javax.xml.transform.SourceLocator locator =
                              spe2.
                              getLocator(
                                );
                            if (null !=
                                  locator &&
                                  null !=
                                  locator.
                                  getSystemId(
                                    ))
                                diagnosticsWriter.
                                  println(
                                    "   ID: " +
                                    locator.
                                      getSystemId(
                                        ) +
                                    " Line #" +
                                    locator.
                                      getLineNumber(
                                        ) +
                                    " Column #" +
                                    locator.
                                      getColumnNumber(
                                        ));
                            e =
                              spe2.
                                getException(
                                  );
                            if (e instanceof org.apache.xml.utils.WrappedRuntimeException)
                                e =
                                  ((org.apache.xml.utils.WrappedRuntimeException)
                                     e).
                                    getException(
                                      );
                        }
                        else
                            e =
                              null;
                    }
                }
            }
            else {
                diagnosticsWriter.
                  println(
                    " (" +
                    throwable.
                      getClass(
                        ).
                      getName(
                        ) +
                    "): " +
                    throwable.
                      getMessage(
                        ));
            }
            diagnosticsString =
              throwable.
                getMessage(
                  );
        }
        if (org.apache.xml.dtm.DTM.
              NULL ==
              newDoc) {
            if (null !=
                  diagnosticsString) {
                warn(
                  xctxt,
                  org.apache.xalan.res.XSLTErrorResources.
                    WG_CANNOT_LOAD_REQUESTED_DOC,
                  new java.lang.Object[] { diagnosticsString });
            }
            else
                warn(
                  xctxt,
                  org.apache.xalan.res.XSLTErrorResources.
                    WG_CANNOT_LOAD_REQUESTED_DOC,
                  new java.lang.Object[] { uri ==
                    null
                    ? (base ==
                         null
                         ? ""
                         : base) +
                  uri
                    : uri.
                    toString(
                      ) });
        }
        else {
            
        }
        return newDoc;
    }
    public void error(org.apache.xpath.XPathContext xctxt,
                      java.lang.String msg,
                      java.lang.Object[] args)
          throws javax.xml.transform.TransformerException {
        java.lang.String formattedMsg =
          org.apache.xalan.res.XSLMessages.
          createMessage(
            msg,
            args);
        javax.xml.transform.ErrorListener errHandler =
          xctxt.
          getErrorListener(
            );
        javax.xml.transform.TransformerException spe =
          new javax.xml.transform.TransformerException(
          formattedMsg,
          (javax.xml.transform.SourceLocator)
            xctxt.
            getSAXLocator(
              ));
        if (null !=
              errHandler)
            errHandler.
              error(
                spe);
        else
            java.lang.System.
              out.
              println(
                formattedMsg);
    }
    public void warn(org.apache.xpath.XPathContext xctxt,
                     java.lang.String msg,
                     java.lang.Object[] args)
          throws javax.xml.transform.TransformerException {
        java.lang.String formattedMsg =
          org.apache.xalan.res.XSLMessages.
          createWarning(
            msg,
            args);
        javax.xml.transform.ErrorListener errHandler =
          xctxt.
          getErrorListener(
            );
        javax.xml.transform.TransformerException spe =
          new javax.xml.transform.TransformerException(
          formattedMsg,
          (javax.xml.transform.SourceLocator)
            xctxt.
            getSAXLocator(
              ));
        if (null !=
              errHandler)
            errHandler.
              warning(
                spe);
        else
            java.lang.System.
              out.
              println(
                formattedMsg);
    }
    public void checkNumberArgs(int argNum)
          throws org.apache.xpath.functions.WrongNumberArgsException {
        if (argNum <
              1 ||
              argNum >
              2)
            reportWrongNumberArgs(
              );
    }
    protected void reportWrongNumberArgs()
          throws org.apache.xpath.functions.WrongNumberArgsException {
        throw new org.apache.xpath.functions.WrongNumberArgsException(
          org.apache.xalan.res.XSLMessages.
            createMessage(
              org.apache.xalan.res.XSLTErrorResources.
                ER_ONE_OR_TWO,
              null));
    }
    public boolean isNodesetExpr() { return true;
    }
    public FuncDocument() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MPB2Ro7nF/x/AgSF1CchAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9QKfF7v8B5OXfmv4ffJPHVQun2zP3naIfb7Rc+c3Ze8P1TgJvcW5rdnHz2/N" +
       "Pgr+5JFmyTsf+9zRCi6VVrCf+wvnCpeODu6OduweP3swWByyHgo0SI9uEJQ9" +
       "5K/cw9vLM8rDzHUO41D0ouKA63BxnFPDQSarQaHtsrMfLZIkrlxTM1VOYvW4" +
       "lydv48MvN7+jQ2G/C35qpOmrbdWdPUEoC8ITrRamWh4cf+1Iq197DVqt3FGh" +
       "V/anE8Xr+8rC0RlPmsaVy6YXn/jaquzib9xZo8Xr+0uCv1UkH4orV3U17vty" +
       "8faRUwV8+HUo4L6isNhX/fF92/3z9ZvV5VP0eV8pKPDQt93dQ8uTsf2O+4t/" +
       "95nfff+Lz/zn8nDpXjPixBAN9TtcqzjT5lsvfeUbv/fg458pD2OvSGK0d6GL" +
       "91Fuv25y7hZJKcgD51VzHfx/4cg2ymdcUb9bB/2uA4UAFYQJNQhDPyxu1hTb" +
       "09HxjYK/mIGyO2zWn3Gxix5e7nv/QnapUprHp+9ydHOy6pwsOFcd1dP3dzY+" +
       "UiQvBtlJ/wf7RseMvOGUEczxPbU4fD2u219EMP3Dk2tLoDK7I6fhntNysCJ5" +
       "5hVOVP/hK9T94yL5bFy5Ry6Y2fP+CuSfz/bPn301py5PMT4B+lWLSbkTVFxJ" +
       "fVM59fOfeb1+joLxj4x5//z/4OelfkrS33g1BXyhSF4GYm7FsLxn8M9OZf21" +
       "1yvrs2Cozx/J+vnvjqxnBPhISfClV14J4dvWMC3x9hcLDvnQ9/T9uShAt+j8" +
       "ovhviuSLceU6aCnbp1QXdPSvX4eOijWv8nbA7K8f6ejXX4uOQBgWhH4MMEJV" +
       "7qiqsw7x1bur8cslwdeK5PfjyhtDNfDD+IJqLgj9H1+H0GUM9QQY+7ePhP7t" +
       "745hnJX2j16h7r8XyR/GlQfNaOoraqTGgyy4o+dfk3zfUUXvVO6vvxa5s7jy" +
       "wNlrXMU9lEdvuzu6v+8of+bF6/e++cXlv9svnsd3Eu+jKvdqieOcvTZwJn81" +
       "CFXNLKW6b3+JICgffxpXHrv73bIifD/O");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("l0z/yb7Vd8Dqc7EVAMbyeZbuz+LK/ad0YFHZZ86QFMfZlwFJkT0ITmLSV/BE" +
       "/CjXKIwtu3T+A+VE/Y+8mvrPfNM8cy7OKW/2Hn81JPu7vbfkz744mr7v2+1P" +
       "769hyY6Y50Uv94KQZH8j7OTL46m79nbc11Xi2e889Mv3ve34K+mhPcOntnyG" +
       "t7fe+Z7TwA3i8mZS/itv/ic/9Pde/IPyksb/AVlyfP5yLQAA");
}
