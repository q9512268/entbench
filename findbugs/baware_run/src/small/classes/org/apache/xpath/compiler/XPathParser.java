package org.apache.xpath.compiler;
public class XPathParser {
    public static final java.lang.String CONTINUE_AFTER_FATAL_ERROR = "CONTINUE_AFTER_FATAL_ERROR";
    private org.apache.xpath.compiler.OpMap m_ops;
    transient java.lang.String m_token;
    transient char m_tokenChar = 0;
    int m_queueMark = 0;
    protected static final int FILTER_MATCH_FAILED = 0;
    protected static final int FILTER_MATCH_PRIMARY = 1;
    protected static final int FILTER_MATCH_PREDICATES = 2;
    public XPathParser(javax.xml.transform.ErrorListener errorListener, javax.xml.transform.SourceLocator sourceLocator) {
        super(
          );
        m_errorListener =
          errorListener;
        m_sourceLocator =
          sourceLocator;
    }
    org.apache.xml.utils.PrefixResolver m_namespaceContext;
    public void initXPath(org.apache.xpath.compiler.Compiler compiler,
                          java.lang.String expression,
                          org.apache.xml.utils.PrefixResolver namespaceContext)
          throws javax.xml.transform.TransformerException { m_ops =
                                                              compiler;
                                                            m_namespaceContext =
                                                              namespaceContext;
                                                            m_functionTable =
                                                              compiler.
                                                                getFunctionTable(
                                                                  );
                                                            org.apache.xpath.compiler.Lexer lexer =
                                                              new org.apache.xpath.compiler.Lexer(
                                                              compiler,
                                                              namespaceContext,
                                                              this);
                                                            lexer.
                                                              tokenize(
                                                                expression);
                                                            m_ops.
                                                              setOp(
                                                                0,
                                                                org.apache.xpath.compiler.OpCodes.
                                                                  OP_XPATH);
                                                            m_ops.
                                                              setOp(
                                                                org.apache.xpath.compiler.OpMap.
                                                                  MAPINDEX_LENGTH,
                                                                2);
                                                            try {
                                                                nextToken(
                                                                  );
                                                                Expr(
                                                                  );
                                                                if (null !=
                                                                      m_token) {
                                                                    java.lang.String extraTokens =
                                                                      "";
                                                                    while (null !=
                                                                             m_token) {
                                                                        extraTokens +=
                                                                          "\'" +
                                                                          m_token +
                                                                          "\'";
                                                                        nextToken(
                                                                          );
                                                                        if (null !=
                                                                              m_token)
                                                                            extraTokens +=
                                                                              ", ";
                                                                    }
                                                                    error(
                                                                      org.apache.xpath.res.XPATHErrorResources.
                                                                        ER_EXTRA_ILLEGAL_TOKENS,
                                                                      new java.lang.Object[] { extraTokens });
                                                                }
                                                            }
                                                            catch (org.apache.xpath.XPathProcessorException e) {
                                                                if (CONTINUE_AFTER_FATAL_ERROR.
                                                                      equals(
                                                                        e.
                                                                          getMessage(
                                                                            ))) {
                                                                    initXPath(
                                                                      compiler,
                                                                      "/..",
                                                                      namespaceContext);
                                                                }
                                                                else
                                                                    throw e;
                                                            }
                                                            compiler.
                                                              shrink(
                                                                );
    }
    public void initMatchPattern(org.apache.xpath.compiler.Compiler compiler,
                                 java.lang.String expression,
                                 org.apache.xml.utils.PrefixResolver namespaceContext)
          throws javax.xml.transform.TransformerException {
        m_ops =
          compiler;
        m_namespaceContext =
          namespaceContext;
        m_functionTable =
          compiler.
            getFunctionTable(
              );
        org.apache.xpath.compiler.Lexer lexer =
          new org.apache.xpath.compiler.Lexer(
          compiler,
          namespaceContext,
          this);
        lexer.
          tokenize(
            expression);
        m_ops.
          setOp(
            0,
            org.apache.xpath.compiler.OpCodes.
              OP_MATCHPATTERN);
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            2);
        nextToken(
          );
        Pattern(
          );
        if (null !=
              m_token) {
            java.lang.String extraTokens =
              "";
            while (null !=
                     m_token) {
                extraTokens +=
                  "\'" +
                  m_token +
                  "\'";
                nextToken(
                  );
                if (null !=
                      m_token)
                    extraTokens +=
                      ", ";
            }
            error(
              org.apache.xpath.res.XPATHErrorResources.
                ER_EXTRA_ILLEGAL_TOKENS,
              new java.lang.Object[] { extraTokens });
        }
        m_ops.
          setOp(
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH),
            org.apache.xpath.compiler.OpCodes.
              ENDOP);
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) +
              1);
        m_ops.
          shrink(
            );
    }
    private javax.xml.transform.ErrorListener
      m_errorListener;
    javax.xml.transform.SourceLocator m_sourceLocator;
    private org.apache.xpath.compiler.FunctionTable
      m_functionTable;
    public void setErrorHandler(javax.xml.transform.ErrorListener handler) {
        m_errorListener =
          handler;
    }
    public javax.xml.transform.ErrorListener getErrorListener() {
        return m_errorListener;
    }
    final boolean tokenIs(java.lang.String s) {
        return m_token !=
          null
          ? m_token.
          equals(
            s)
          : s ==
          null;
    }
    final boolean tokenIs(char c) { return m_token !=
                                      null
                                      ? m_tokenChar ==
                                      c
                                      : false;
    }
    final boolean lookahead(char c, int n) {
        int pos =
          m_queueMark +
          n;
        boolean b;
        if (pos <=
              m_ops.
              getTokenQueueSize(
                ) &&
              pos >
              0 &&
              m_ops.
              getTokenQueueSize(
                ) !=
              0) {
            java.lang.String tok =
              (java.lang.String)
                m_ops.
                  m_tokenQueue.
                elementAt(
                  pos -
                    1);
            b =
              tok.
                length(
                  ) ==
                1
                ? tok.
                charAt(
                  0) ==
                c
                : false;
        }
        else {
            b =
              false;
        }
        return b;
    }
    private final boolean lookbehind(char c,
                                     int n) {
        boolean isToken;
        int lookBehindPos =
          m_queueMark -
          (n +
             1);
        if (lookBehindPos >=
              0) {
            java.lang.String lookbehind =
              (java.lang.String)
                m_ops.
                  m_tokenQueue.
                elementAt(
                  lookBehindPos);
            if (lookbehind.
                  length(
                    ) ==
                  1) {
                char c0 =
                  lookbehind ==
                  null
                  ? '|'
                  : lookbehind.
                  charAt(
                    0);
                isToken =
                  c0 ==
                    '|'
                    ? false
                    : c0 ==
                    c;
            }
            else {
                isToken =
                  false;
            }
        }
        else {
            isToken =
              false;
        }
        return isToken;
    }
    private final boolean lookbehindHasToken(int n) {
        boolean hasToken;
        if (m_queueMark -
              n >
              0) {
            java.lang.String lookbehind =
              (java.lang.String)
                m_ops.
                  m_tokenQueue.
                elementAt(
                  m_queueMark -
                    (n -
                       1));
            char c0 =
              lookbehind ==
              null
              ? '|'
              : lookbehind.
              charAt(
                0);
            hasToken =
              c0 ==
                '|'
                ? false
                : true;
        }
        else {
            hasToken =
              false;
        }
        return hasToken;
    }
    private final boolean lookahead(java.lang.String s,
                                    int n) {
        boolean isToken;
        if (m_queueMark +
              n <=
              m_ops.
              getTokenQueueSize(
                )) {
            java.lang.String lookahead =
              (java.lang.String)
                m_ops.
                  m_tokenQueue.
                elementAt(
                  m_queueMark +
                    (n -
                       1));
            isToken =
              lookahead !=
                null
                ? lookahead.
                equals(
                  s)
                : s ==
                null;
        }
        else {
            isToken =
              null ==
                s;
        }
        return isToken;
    }
    private final void nextToken() { if (m_queueMark <
                                           m_ops.
                                           getTokenQueueSize(
                                             )) {
                                         m_token =
                                           (java.lang.String)
                                             m_ops.
                                               m_tokenQueue.
                                             elementAt(
                                               m_queueMark++);
                                         m_tokenChar =
                                           m_token.
                                             charAt(
                                               0);
                                     }
                                     else {
                                         m_token =
                                           null;
                                         m_tokenChar =
                                           0;
                                     } }
    private final java.lang.String getTokenRelative(int i) {
        java.lang.String tok;
        int relative =
          m_queueMark +
          i;
        if (relative >
              0 &&
              relative <
              m_ops.
              getTokenQueueSize(
                )) {
            tok =
              (java.lang.String)
                m_ops.
                  m_tokenQueue.
                elementAt(
                  relative);
        }
        else {
            tok =
              null;
        }
        return tok;
    }
    private final void prevToken() { if (m_queueMark >
                                           0) {
                                         m_queueMark--;
                                         m_token =
                                           (java.lang.String)
                                             m_ops.
                                               m_tokenQueue.
                                             elementAt(
                                               m_queueMark);
                                         m_tokenChar =
                                           m_token.
                                             charAt(
                                               0);
                                     }
                                     else {
                                         m_token =
                                           null;
                                         m_tokenChar =
                                           0;
                                     } }
    private final void consumeExpected(java.lang.String expected)
          throws javax.xml.transform.TransformerException {
        if (tokenIs(
              expected)) {
            nextToken(
              );
        }
        else {
            error(
              org.apache.xpath.res.XPATHErrorResources.
                ER_EXPECTED_BUT_FOUND,
              new java.lang.Object[] { expected,
              m_token });
            throw new org.apache.xpath.XPathProcessorException(
              CONTINUE_AFTER_FATAL_ERROR);
        }
    }
    private final void consumeExpected(char expected)
          throws javax.xml.transform.TransformerException {
        if (tokenIs(
              expected)) {
            nextToken(
              );
        }
        else {
            error(
              org.apache.xpath.res.XPATHErrorResources.
                ER_EXPECTED_BUT_FOUND,
              new java.lang.Object[] { java.lang.String.
                valueOf(
                  expected),
              m_token });
            throw new org.apache.xpath.XPathProcessorException(
              CONTINUE_AFTER_FATAL_ERROR);
        }
    }
    void warn(java.lang.String msg, java.lang.Object[] args)
          throws javax.xml.transform.TransformerException {
        java.lang.String fmsg =
          org.apache.xalan.res.XSLMessages.
          createXPATHWarning(
            msg,
            args);
        javax.xml.transform.ErrorListener ehandler =
          this.
          getErrorListener(
            );
        if (null !=
              ehandler) {
            ehandler.
              warning(
                new javax.xml.transform.TransformerException(
                  fmsg,
                  m_sourceLocator));
        }
        else {
            java.lang.System.
              err.
              println(
                fmsg);
        }
    }
    private void assertion(boolean b, java.lang.String msg) {
        if (!b) {
            java.lang.String fMsg =
              org.apache.xalan.res.XSLMessages.
              createXPATHMessage(
                org.apache.xpath.res.XPATHErrorResources.
                  ER_INCORRECT_PROGRAMMER_ASSERTION,
                new java.lang.Object[] { msg });
            throw new java.lang.RuntimeException(
              fMsg);
        }
    }
    void error(java.lang.String msg, java.lang.Object[] args)
          throws javax.xml.transform.TransformerException {
        java.lang.String fmsg =
          org.apache.xalan.res.XSLMessages.
          createXPATHMessage(
            msg,
            args);
        javax.xml.transform.ErrorListener ehandler =
          this.
          getErrorListener(
            );
        javax.xml.transform.TransformerException te =
          new javax.xml.transform.TransformerException(
          fmsg,
          m_sourceLocator);
        if (null !=
              ehandler) {
            ehandler.
              fatalError(
                te);
        }
        else {
            throw te;
        }
    }
    void errorForDOM3(java.lang.String msg,
                      java.lang.Object[] args)
          throws javax.xml.transform.TransformerException {
        java.lang.String fmsg =
          org.apache.xalan.res.XSLMessages.
          createXPATHMessage(
            msg,
            args);
        javax.xml.transform.ErrorListener ehandler =
          this.
          getErrorListener(
            );
        javax.xml.transform.TransformerException te =
          new org.apache.xpath.domapi.XPathStylesheetDOM3Exception(
          fmsg,
          m_sourceLocator);
        if (null !=
              ehandler) {
            ehandler.
              fatalError(
                te);
        }
        else {
            throw te;
        }
    }
    protected java.lang.String dumpRemainingTokenQueue() {
        int q =
          m_queueMark;
        java.lang.String returnMsg;
        if (q <
              m_ops.
              getTokenQueueSize(
                )) {
            java.lang.String msg =
              "\n Remaining tokens: (";
            while (q <
                     m_ops.
                     getTokenQueueSize(
                       )) {
                java.lang.String t =
                  (java.lang.String)
                    m_ops.
                      m_tokenQueue.
                    elementAt(
                      q++);
                msg +=
                  " \'" +
                  t +
                  "\'";
            }
            returnMsg =
              msg +
              ")";
        }
        else {
            returnMsg =
              "";
        }
        return returnMsg;
    }
    final int getFunctionToken(java.lang.String key) {
        int tok;
        java.lang.Object id;
        try {
            id =
              org.apache.xpath.compiler.Keywords.
                lookupNodeTest(
                  key);
            if (null ==
                  id)
                id =
                  m_functionTable.
                    getFunctionID(
                      key);
            tok =
              ((java.lang.Integer)
                 id).
                intValue(
                  );
        }
        catch (java.lang.NullPointerException npe) {
            tok =
              -1;
        }
        catch (java.lang.ClassCastException cce) {
            tok =
              -1;
        }
        return tok;
    }
    void insertOp(int pos, int length, int op) {
        int totalLen =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        for (int i =
               totalLen -
               1;
             i >=
               pos;
             i--) {
            m_ops.
              setOp(
                i +
                  length,
                m_ops.
                  getOp(
                    i));
        }
        m_ops.
          setOp(
            pos,
            op);
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            totalLen +
              length);
    }
    void appendOp(int length, int op) { int totalLen =
                                          m_ops.
                                          getOp(
                                            org.apache.xpath.compiler.OpMap.
                                              MAPINDEX_LENGTH);
                                        m_ops.
                                          setOp(
                                            totalLen,
                                            op);
                                        m_ops.
                                          setOp(
                                            totalLen +
                                              org.apache.xpath.compiler.OpMap.
                                                MAPINDEX_LENGTH,
                                            length);
                                        m_ops.
                                          setOp(
                                            org.apache.xpath.compiler.OpMap.
                                              MAPINDEX_LENGTH,
                                            totalLen +
                                              length);
    }
    protected void Expr() throws javax.xml.transform.TransformerException {
        OrExpr(
          );
    }
    protected void OrExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        AndExpr(
          );
        if (null !=
              m_token &&
              tokenIs(
                "or")) {
            nextToken(
              );
            insertOp(
              opPos,
              2,
              org.apache.xpath.compiler.OpCodes.
                OP_OR);
            OrExpr(
              );
            m_ops.
              setOp(
                opPos +
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  opPos);
        }
    }
    protected void AndExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        EqualityExpr(
          -1);
        if (null !=
              m_token &&
              tokenIs(
                "and")) {
            nextToken(
              );
            insertOp(
              opPos,
              2,
              org.apache.xpath.compiler.OpCodes.
                OP_AND);
            AndExpr(
              );
            m_ops.
              setOp(
                opPos +
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  opPos);
        }
    }
    protected int EqualityExpr(int addPos)
          throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        if (-1 ==
              addPos)
            addPos =
              opPos;
        RelationalExpr(
          -1);
        if (null !=
              m_token) {
            if (tokenIs(
                  '!') &&
                  lookahead(
                    '=',
                    1)) {
                nextToken(
                  );
                nextToken(
                  );
                insertOp(
                  addPos,
                  2,
                  org.apache.xpath.compiler.OpCodes.
                    OP_NOTEQUALS);
                int opPlusLeftHandLen =
                  m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  addPos;
                addPos =
                  EqualityExpr(
                    addPos);
                m_ops.
                  setOp(
                    addPos +
                      org.apache.xpath.compiler.OpMap.
                        MAPINDEX_LENGTH,
                    m_ops.
                      getOp(
                        addPos +
                          opPlusLeftHandLen +
                          1) +
                      opPlusLeftHandLen);
                addPos +=
                  2;
            }
            else
                if (tokenIs(
                      '=')) {
                    nextToken(
                      );
                    insertOp(
                      addPos,
                      2,
                      org.apache.xpath.compiler.OpCodes.
                        OP_EQUALS);
                    int opPlusLeftHandLen =
                      m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      addPos;
                    addPos =
                      EqualityExpr(
                        addPos);
                    m_ops.
                      setOp(
                        addPos +
                          org.apache.xpath.compiler.OpMap.
                            MAPINDEX_LENGTH,
                        m_ops.
                          getOp(
                            addPos +
                              opPlusLeftHandLen +
                              1) +
                          opPlusLeftHandLen);
                    addPos +=
                      2;
                }
        }
        return addPos;
    }
    protected int RelationalExpr(int addPos)
          throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        if (-1 ==
              addPos)
            addPos =
              opPos;
        AdditiveExpr(
          -1);
        if (null !=
              m_token) {
            if (tokenIs(
                  '<')) {
                nextToken(
                  );
                if (tokenIs(
                      '=')) {
                    nextToken(
                      );
                    insertOp(
                      addPos,
                      2,
                      org.apache.xpath.compiler.OpCodes.
                        OP_LTE);
                }
                else {
                    insertOp(
                      addPos,
                      2,
                      org.apache.xpath.compiler.OpCodes.
                        OP_LT);
                }
                int opPlusLeftHandLen =
                  m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  addPos;
                addPos =
                  RelationalExpr(
                    addPos);
                m_ops.
                  setOp(
                    addPos +
                      org.apache.xpath.compiler.OpMap.
                        MAPINDEX_LENGTH,
                    m_ops.
                      getOp(
                        addPos +
                          opPlusLeftHandLen +
                          1) +
                      opPlusLeftHandLen);
                addPos +=
                  2;
            }
            else
                if (tokenIs(
                      '>')) {
                    nextToken(
                      );
                    if (tokenIs(
                          '=')) {
                        nextToken(
                          );
                        insertOp(
                          addPos,
                          2,
                          org.apache.xpath.compiler.OpCodes.
                            OP_GTE);
                    }
                    else {
                        insertOp(
                          addPos,
                          2,
                          org.apache.xpath.compiler.OpCodes.
                            OP_GT);
                    }
                    int opPlusLeftHandLen =
                      m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      addPos;
                    addPos =
                      RelationalExpr(
                        addPos);
                    m_ops.
                      setOp(
                        addPos +
                          org.apache.xpath.compiler.OpMap.
                            MAPINDEX_LENGTH,
                        m_ops.
                          getOp(
                            addPos +
                              opPlusLeftHandLen +
                              1) +
                          opPlusLeftHandLen);
                    addPos +=
                      2;
                }
        }
        return addPos;
    }
    protected int AdditiveExpr(int addPos)
          throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        if (-1 ==
              addPos)
            addPos =
              opPos;
        MultiplicativeExpr(
          -1);
        if (null !=
              m_token) {
            if (tokenIs(
                  '+')) {
                nextToken(
                  );
                insertOp(
                  addPos,
                  2,
                  org.apache.xpath.compiler.OpCodes.
                    OP_PLUS);
                int opPlusLeftHandLen =
                  m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  addPos;
                addPos =
                  AdditiveExpr(
                    addPos);
                m_ops.
                  setOp(
                    addPos +
                      org.apache.xpath.compiler.OpMap.
                        MAPINDEX_LENGTH,
                    m_ops.
                      getOp(
                        addPos +
                          opPlusLeftHandLen +
                          1) +
                      opPlusLeftHandLen);
                addPos +=
                  2;
            }
            else
                if (tokenIs(
                      '-')) {
                    nextToken(
                      );
                    insertOp(
                      addPos,
                      2,
                      org.apache.xpath.compiler.OpCodes.
                        OP_MINUS);
                    int opPlusLeftHandLen =
                      m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      addPos;
                    addPos =
                      AdditiveExpr(
                        addPos);
                    m_ops.
                      setOp(
                        addPos +
                          org.apache.xpath.compiler.OpMap.
                            MAPINDEX_LENGTH,
                        m_ops.
                          getOp(
                            addPos +
                              opPlusLeftHandLen +
                              1) +
                          opPlusLeftHandLen);
                    addPos +=
                      2;
                }
        }
        return addPos;
    }
    protected int MultiplicativeExpr(int addPos)
          throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        if (-1 ==
              addPos)
            addPos =
              opPos;
        UnaryExpr(
          );
        if (null !=
              m_token) {
            if (tokenIs(
                  '*')) {
                nextToken(
                  );
                insertOp(
                  addPos,
                  2,
                  org.apache.xpath.compiler.OpCodes.
                    OP_MULT);
                int opPlusLeftHandLen =
                  m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  addPos;
                addPos =
                  MultiplicativeExpr(
                    addPos);
                m_ops.
                  setOp(
                    addPos +
                      org.apache.xpath.compiler.OpMap.
                        MAPINDEX_LENGTH,
                    m_ops.
                      getOp(
                        addPos +
                          opPlusLeftHandLen +
                          1) +
                      opPlusLeftHandLen);
                addPos +=
                  2;
            }
            else
                if (tokenIs(
                      "div")) {
                    nextToken(
                      );
                    insertOp(
                      addPos,
                      2,
                      org.apache.xpath.compiler.OpCodes.
                        OP_DIV);
                    int opPlusLeftHandLen =
                      m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      addPos;
                    addPos =
                      MultiplicativeExpr(
                        addPos);
                    m_ops.
                      setOp(
                        addPos +
                          org.apache.xpath.compiler.OpMap.
                            MAPINDEX_LENGTH,
                        m_ops.
                          getOp(
                            addPos +
                              opPlusLeftHandLen +
                              1) +
                          opPlusLeftHandLen);
                    addPos +=
                      2;
                }
                else
                    if (tokenIs(
                          "mod")) {
                        nextToken(
                          );
                        insertOp(
                          addPos,
                          2,
                          org.apache.xpath.compiler.OpCodes.
                            OP_MOD);
                        int opPlusLeftHandLen =
                          m_ops.
                          getOp(
                            org.apache.xpath.compiler.OpMap.
                              MAPINDEX_LENGTH) -
                          addPos;
                        addPos =
                          MultiplicativeExpr(
                            addPos);
                        m_ops.
                          setOp(
                            addPos +
                              org.apache.xpath.compiler.OpMap.
                                MAPINDEX_LENGTH,
                            m_ops.
                              getOp(
                                addPos +
                                  opPlusLeftHandLen +
                                  1) +
                              opPlusLeftHandLen);
                        addPos +=
                          2;
                    }
                    else
                        if (tokenIs(
                              "quo")) {
                            nextToken(
                              );
                            insertOp(
                              addPos,
                              2,
                              org.apache.xpath.compiler.OpCodes.
                                OP_QUO);
                            int opPlusLeftHandLen =
                              m_ops.
                              getOp(
                                org.apache.xpath.compiler.OpMap.
                                  MAPINDEX_LENGTH) -
                              addPos;
                            addPos =
                              MultiplicativeExpr(
                                addPos);
                            m_ops.
                              setOp(
                                addPos +
                                  org.apache.xpath.compiler.OpMap.
                                    MAPINDEX_LENGTH,
                                m_ops.
                                  getOp(
                                    addPos +
                                      opPlusLeftHandLen +
                                      1) +
                                  opPlusLeftHandLen);
                            addPos +=
                              2;
                        }
        }
        return addPos;
    }
    protected void UnaryExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        boolean isNeg =
          false;
        if (m_tokenChar ==
              '-') {
            nextToken(
              );
            appendOp(
              2,
              org.apache.xpath.compiler.OpCodes.
                OP_NEG);
            isNeg =
              true;
        }
        UnionExpr(
          );
        if (isNeg)
            m_ops.
              setOp(
                opPos +
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  opPos);
    }
    protected void StringExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        appendOp(
          2,
          org.apache.xpath.compiler.OpCodes.
            OP_STRING);
        Expr(
          );
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
    }
    protected void BooleanExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        appendOp(
          2,
          org.apache.xpath.compiler.OpCodes.
            OP_BOOL);
        Expr(
          );
        int opLen =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH) -
          opPos;
        if (opLen ==
              2) {
            error(
              org.apache.xpath.res.XPATHErrorResources.
                ER_BOOLEAN_ARG_NO_LONGER_OPTIONAL,
              null);
        }
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            opLen);
    }
    protected void NumberExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        appendOp(
          2,
          org.apache.xpath.compiler.OpCodes.
            OP_NUMBER);
        Expr(
          );
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
    }
    protected void UnionExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        boolean continueOrLoop =
          true;
        boolean foundUnion =
          false;
        do  {
            PathExpr(
              );
            if (tokenIs(
                  '|')) {
                if (false ==
                      foundUnion) {
                    foundUnion =
                      true;
                    insertOp(
                      opPos,
                      2,
                      org.apache.xpath.compiler.OpCodes.
                        OP_UNION);
                }
                nextToken(
                  );
            }
            else {
                break;
            }
        }while(continueOrLoop); 
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
    }
    protected void PathExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        int filterExprMatch =
          FilterExpr(
            );
        if (filterExprMatch !=
              FILTER_MATCH_FAILED) {
            boolean locationPathStarted =
              filterExprMatch ==
              FILTER_MATCH_PREDICATES;
            if (tokenIs(
                  '/')) {
                nextToken(
                  );
                if (!locationPathStarted) {
                    insertOp(
                      opPos,
                      2,
                      org.apache.xpath.compiler.OpCodes.
                        OP_LOCATIONPATH);
                    locationPathStarted =
                      true;
                }
                if (!RelativeLocationPath(
                       )) {
                    error(
                      org.apache.xpath.res.XPATHErrorResources.
                        ER_EXPECTED_REL_LOC_PATH,
                      null);
                }
            }
            if (locationPathStarted) {
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH),
                    org.apache.xpath.compiler.OpCodes.
                      ENDOP);
                m_ops.
                  setOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH,
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) +
                      1);
                m_ops.
                  setOp(
                    opPos +
                      org.apache.xpath.compiler.OpMap.
                        MAPINDEX_LENGTH,
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      opPos);
            }
        }
        else {
            LocationPath(
              );
        }
    }
    protected int FilterExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        int filterMatch;
        if (PrimaryExpr(
              )) {
            if (tokenIs(
                  '[')) {
                insertOp(
                  opPos,
                  2,
                  org.apache.xpath.compiler.OpCodes.
                    OP_LOCATIONPATH);
                while (tokenIs(
                         '[')) {
                    Predicate(
                      );
                }
                filterMatch =
                  FILTER_MATCH_PREDICATES;
            }
            else {
                filterMatch =
                  FILTER_MATCH_PRIMARY;
            }
        }
        else {
            filterMatch =
              FILTER_MATCH_FAILED;
        }
        return filterMatch;
    }
    protected boolean PrimaryExpr() throws javax.xml.transform.TransformerException {
        boolean matchFound;
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        if (m_tokenChar ==
              '\'' ||
              m_tokenChar ==
              '\"') {
            appendOp(
              2,
              org.apache.xpath.compiler.OpCodes.
                OP_LITERAL);
            Literal(
              );
            m_ops.
              setOp(
                opPos +
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  opPos);
            matchFound =
              true;
        }
        else
            if (m_tokenChar ==
                  '$') {
                nextToken(
                  );
                appendOp(
                  2,
                  org.apache.xpath.compiler.OpCodes.
                    OP_VARIABLE);
                QName(
                  );
                m_ops.
                  setOp(
                    opPos +
                      org.apache.xpath.compiler.OpMap.
                        MAPINDEX_LENGTH,
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      opPos);
                matchFound =
                  true;
            }
            else
                if (m_tokenChar ==
                      '(') {
                    nextToken(
                      );
                    appendOp(
                      2,
                      org.apache.xpath.compiler.OpCodes.
                        OP_GROUP);
                    Expr(
                      );
                    consumeExpected(
                      ')');
                    m_ops.
                      setOp(
                        opPos +
                          org.apache.xpath.compiler.OpMap.
                            MAPINDEX_LENGTH,
                        m_ops.
                          getOp(
                            org.apache.xpath.compiler.OpMap.
                              MAPINDEX_LENGTH) -
                          opPos);
                    matchFound =
                      true;
                }
                else
                    if (null !=
                          m_token &&
                          ('.' ==
                             m_tokenChar &&
                             m_token.
                             length(
                               ) >
                             1 &&
                             java.lang.Character.
                             isDigit(
                               m_token.
                                 charAt(
                                   1)) ||
                             java.lang.Character.
                             isDigit(
                               m_tokenChar))) {
                        appendOp(
                          2,
                          org.apache.xpath.compiler.OpCodes.
                            OP_NUMBERLIT);
                        Number(
                          );
                        m_ops.
                          setOp(
                            opPos +
                              org.apache.xpath.compiler.OpMap.
                                MAPINDEX_LENGTH,
                            m_ops.
                              getOp(
                                org.apache.xpath.compiler.OpMap.
                                  MAPINDEX_LENGTH) -
                              opPos);
                        matchFound =
                          true;
                    }
                    else
                        if (lookahead(
                              '(',
                              1) ||
                              lookahead(
                                ':',
                                1) &&
                              lookahead(
                                '(',
                                3)) {
                            matchFound =
                              FunctionCall(
                                );
                        }
                        else {
                            matchFound =
                              false;
                        }
        return matchFound;
    }
    protected void Argument() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        appendOp(
          2,
          org.apache.xpath.compiler.OpCodes.
            OP_ARGUMENT);
        Expr(
          );
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
    }
    protected boolean FunctionCall() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        if (lookahead(
              ':',
              1)) {
            appendOp(
              4,
              org.apache.xpath.compiler.OpCodes.
                OP_EXTFUNCTION);
            m_ops.
              setOp(
                opPos +
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH +
                  1,
                m_queueMark -
                  1);
            nextToken(
              );
            consumeExpected(
              ':');
            m_ops.
              setOp(
                opPos +
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH +
                  2,
                m_queueMark -
                  1);
            nextToken(
              );
        }
        else {
            int funcTok =
              getFunctionToken(
                m_token);
            if (-1 ==
                  funcTok) {
                error(
                  org.apache.xpath.res.XPATHErrorResources.
                    ER_COULDNOT_FIND_FUNCTION,
                  new java.lang.Object[] { m_token });
            }
            switch (funcTok) {
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_PI:
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_COMMENT:
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_TEXT:
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_NODE:
                    return false;
                default:
                    appendOp(
                      3,
                      org.apache.xpath.compiler.OpCodes.
                        OP_FUNCTION);
                    m_ops.
                      setOp(
                        opPos +
                          org.apache.xpath.compiler.OpMap.
                            MAPINDEX_LENGTH +
                          1,
                        funcTok);
            }
            nextToken(
              );
        }
        consumeExpected(
          '(');
        while (!tokenIs(
                  ')') &&
                 m_token !=
                 null) {
            if (tokenIs(
                  ',')) {
                error(
                  org.apache.xpath.res.XPATHErrorResources.
                    ER_FOUND_COMMA_BUT_NO_PRECEDING_ARG,
                  null);
            }
            Argument(
              );
            if (!tokenIs(
                   ')')) {
                consumeExpected(
                  ',');
                if (tokenIs(
                      ')')) {
                    error(
                      org.apache.xpath.res.XPATHErrorResources.
                        ER_FOUND_COMMA_BUT_NO_FOLLOWING_ARG,
                      null);
                }
            }
        }
        consumeExpected(
          ')');
        m_ops.
          setOp(
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH),
            org.apache.xpath.compiler.OpCodes.
              ENDOP);
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) +
              1);
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
        return true;
    }
    protected void LocationPath() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        appendOp(
          2,
          org.apache.xpath.compiler.OpCodes.
            OP_LOCATIONPATH);
        boolean seenSlash =
          tokenIs(
            '/');
        if (seenSlash) {
            appendOp(
              4,
              org.apache.xpath.compiler.OpCodes.
                FROM_ROOT);
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  2,
                4);
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  1,
                org.apache.xpath.compiler.OpCodes.
                  NODETYPE_ROOT);
            nextToken(
              );
        }
        else
            if (m_token ==
                  null) {
                error(
                  org.apache.xpath.res.XPATHErrorResources.
                    ER_EXPECTED_LOC_PATH_AT_END_EXPR,
                  null);
            }
        if (m_token !=
              null) {
            if (!RelativeLocationPath(
                   ) &&
                  !seenSlash) {
                error(
                  org.apache.xpath.res.XPATHErrorResources.
                    ER_EXPECTED_LOC_PATH,
                  new java.lang.Object[] { m_token });
            }
        }
        m_ops.
          setOp(
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH),
            org.apache.xpath.compiler.OpCodes.
              ENDOP);
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) +
              1);
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
    }
    protected boolean RelativeLocationPath()
          throws javax.xml.transform.TransformerException {
        if (!Step(
               )) {
            return false;
        }
        while (tokenIs(
                 '/')) {
            nextToken(
              );
            if (!Step(
                   )) {
                error(
                  org.apache.xpath.res.XPATHErrorResources.
                    ER_EXPECTED_LOC_STEP,
                  null);
            }
        }
        return true;
    }
    protected boolean Step() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        boolean doubleSlash =
          tokenIs(
            '/');
        if (doubleSlash) {
            nextToken(
              );
            appendOp(
              2,
              org.apache.xpath.compiler.OpCodes.
                FROM_DESCENDANTS_OR_SELF);
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH),
                org.apache.xpath.compiler.OpCodes.
                  NODETYPE_NODE);
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
            m_ops.
              setOp(
                opPos +
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH +
                  1,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  opPos);
            m_ops.
              setOp(
                opPos +
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  opPos);
            opPos =
              m_ops.
                getOp(
                  org.apache.xpath.compiler.OpMap.
                    MAPINDEX_LENGTH);
        }
        if (tokenIs(
              ".")) {
            nextToken(
              );
            if (tokenIs(
                  '[')) {
                error(
                  org.apache.xpath.res.XPATHErrorResources.
                    ER_PREDICATE_ILLEGAL_SYNTAX,
                  null);
            }
            appendOp(
              4,
              org.apache.xpath.compiler.OpCodes.
                FROM_SELF);
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  2,
                4);
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) -
                  1,
                org.apache.xpath.compiler.OpCodes.
                  NODETYPE_NODE);
        }
        else
            if (tokenIs(
                  "..")) {
                nextToken(
                  );
                appendOp(
                  4,
                  org.apache.xpath.compiler.OpCodes.
                    FROM_PARENT);
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      2,
                    4);
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      1,
                    org.apache.xpath.compiler.OpCodes.
                      NODETYPE_NODE);
            }
            else
                if (tokenIs(
                      '*') ||
                      tokenIs(
                        '@') ||
                      tokenIs(
                        '_') ||
                      m_token !=
                      null &&
                      java.lang.Character.
                      isLetter(
                        m_token.
                          charAt(
                            0))) {
                    Basis(
                      );
                    while (tokenIs(
                             '[')) {
                        Predicate(
                          );
                    }
                    m_ops.
                      setOp(
                        opPos +
                          org.apache.xpath.compiler.OpMap.
                            MAPINDEX_LENGTH,
                        m_ops.
                          getOp(
                            org.apache.xpath.compiler.OpMap.
                              MAPINDEX_LENGTH) -
                          opPos);
                }
                else {
                    if (doubleSlash) {
                        error(
                          org.apache.xpath.res.XPATHErrorResources.
                            ER_EXPECTED_LOC_STEP,
                          null);
                    }
                    return false;
                }
        return true;
    }
    protected void Basis() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        int axesType;
        if (lookahead(
              "::",
              1)) {
            axesType =
              AxisName(
                );
            nextToken(
              );
            nextToken(
              );
        }
        else
            if (tokenIs(
                  '@')) {
                axesType =
                  org.apache.xpath.compiler.OpCodes.
                    FROM_ATTRIBUTES;
                appendOp(
                  2,
                  axesType);
                nextToken(
                  );
            }
            else {
                axesType =
                  org.apache.xpath.compiler.OpCodes.
                    FROM_CHILDREN;
                appendOp(
                  2,
                  axesType);
            }
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) +
              1);
        NodeTest(
          axesType);
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH +
              1,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
    }
    protected int AxisName() throws javax.xml.transform.TransformerException {
        java.lang.Object val =
          org.apache.xpath.compiler.Keywords.
          getAxisName(
            m_token);
        if (null ==
              val) {
            error(
              org.apache.xpath.res.XPATHErrorResources.
                ER_ILLEGAL_AXIS_NAME,
              new java.lang.Object[] { m_token });
        }
        int axesType =
          ((java.lang.Integer)
             val).
          intValue(
            );
        appendOp(
          2,
          axesType);
        return axesType;
    }
    protected void NodeTest(int axesType)
          throws javax.xml.transform.TransformerException {
        if (lookahead(
              '(',
              1)) {
            java.lang.Object nodeTestOp =
              org.apache.xpath.compiler.Keywords.
              getNodeType(
                m_token);
            if (null ==
                  nodeTestOp) {
                error(
                  org.apache.xpath.res.XPATHErrorResources.
                    ER_UNKNOWN_NODETYPE,
                  new java.lang.Object[] { m_token });
            }
            else {
                nextToken(
                  );
                int nt =
                  ((java.lang.Integer)
                     nodeTestOp).
                  intValue(
                    );
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH),
                    nt);
                m_ops.
                  setOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH,
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) +
                      1);
                consumeExpected(
                  '(');
                if (org.apache.xpath.compiler.OpCodes.
                      NODETYPE_PI ==
                      nt) {
                    if (!tokenIs(
                           ')')) {
                        Literal(
                          );
                    }
                }
                consumeExpected(
                  ')');
            }
        }
        else {
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH),
                org.apache.xpath.compiler.OpCodes.
                  NODENAME);
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
            if (lookahead(
                  ':',
                  1)) {
                if (tokenIs(
                      '*')) {
                    m_ops.
                      setOp(
                        m_ops.
                          getOp(
                            org.apache.xpath.compiler.OpMap.
                              MAPINDEX_LENGTH),
                        org.apache.xpath.compiler.OpCodes.
                          ELEMWILDCARD);
                }
                else {
                    m_ops.
                      setOp(
                        m_ops.
                          getOp(
                            org.apache.xpath.compiler.OpMap.
                              MAPINDEX_LENGTH),
                        m_queueMark -
                          1);
                    if (!java.lang.Character.
                          isLetter(
                            m_tokenChar) &&
                          !tokenIs(
                             '_')) {
                        error(
                          org.apache.xpath.res.XPATHErrorResources.
                            ER_EXPECTED_NODE_TEST,
                          null);
                    }
                }
                nextToken(
                  );
                consumeExpected(
                  ':');
            }
            else {
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH),
                    org.apache.xpath.compiler.OpCodes.
                      EMPTY);
            }
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
            if (tokenIs(
                  '*')) {
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH),
                    org.apache.xpath.compiler.OpCodes.
                      ELEMWILDCARD);
            }
            else {
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH),
                    m_queueMark -
                      1);
                if (!java.lang.Character.
                      isLetter(
                        m_tokenChar) &&
                      !tokenIs(
                         '_')) {
                    error(
                      org.apache.xpath.res.XPATHErrorResources.
                        ER_EXPECTED_NODE_TEST,
                      null);
                }
            }
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
            nextToken(
              );
        }
    }
    protected void Predicate() throws javax.xml.transform.TransformerException {
        if (tokenIs(
              '[')) {
            nextToken(
              );
            PredicateExpr(
              );
            consumeExpected(
              ']');
        }
    }
    protected void PredicateExpr() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        appendOp(
          2,
          org.apache.xpath.compiler.OpCodes.
            OP_PREDICATE);
        Expr(
          );
        m_ops.
          setOp(
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH),
            org.apache.xpath.compiler.OpCodes.
              ENDOP);
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) +
              1);
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
    }
    protected void QName() throws javax.xml.transform.TransformerException {
        if (lookahead(
              ':',
              1)) {
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH),
                m_queueMark -
                  1);
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
            nextToken(
              );
            consumeExpected(
              ':');
        }
        else {
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH),
                org.apache.xpath.compiler.OpCodes.
                  EMPTY);
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
        }
        m_ops.
          setOp(
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH),
            m_queueMark -
              1);
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) +
              1);
        nextToken(
          );
    }
    protected void NCName() { m_ops.setOp(
                                      m_ops.
                                        getOp(
                                          org.apache.xpath.compiler.OpMap.
                                            MAPINDEX_LENGTH),
                                      m_queueMark -
                                        1);
                              m_ops.setOp(
                                      org.apache.xpath.compiler.OpMap.
                                        MAPINDEX_LENGTH,
                                      m_ops.
                                        getOp(
                                          org.apache.xpath.compiler.OpMap.
                                            MAPINDEX_LENGTH) +
                                        1);
                              nextToken();
    }
    protected void Literal() throws javax.xml.transform.TransformerException {
        int last =
          m_token.
          length(
            ) -
          1;
        char c0 =
          m_tokenChar;
        char cX =
          m_token.
          charAt(
            last);
        if (c0 ==
              '\"' &&
              cX ==
              '\"' ||
              c0 ==
              '\'' &&
              cX ==
              '\'') {
            int tokenQueuePos =
              m_queueMark -
              1;
            m_ops.
              m_tokenQueue.
              setElementAt(
                null,
                tokenQueuePos);
            java.lang.Object obj =
              new org.apache.xpath.objects.XString(
              m_token.
                substring(
                  1,
                  last));
            m_ops.
              m_tokenQueue.
              setElementAt(
                obj,
                tokenQueuePos);
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH),
                tokenQueuePos);
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
            nextToken(
              );
        }
        else {
            error(
              org.apache.xpath.res.XPATHErrorResources.
                ER_PATTERN_LITERAL_NEEDS_BE_QUOTED,
              new java.lang.Object[] { m_token });
        }
    }
    protected void Number() throws javax.xml.transform.TransformerException {
        if (null !=
              m_token) {
            double num;
            try {
                if (m_token.
                      indexOf(
                        'e') >
                      -1 ||
                      m_token.
                      indexOf(
                        'E') >
                      -1)
                    throw new java.lang.NumberFormatException(
                      );
                num =
                  java.lang.Double.
                    valueOf(
                      m_token).
                    doubleValue(
                      );
            }
            catch (java.lang.NumberFormatException nfe) {
                num =
                  0.0;
                error(
                  org.apache.xpath.res.XPATHErrorResources.
                    ER_COULDNOT_BE_FORMATTED_TO_NUMBER,
                  new java.lang.Object[] { m_token });
            }
            m_ops.
              m_tokenQueue.
              setElementAt(
                new org.apache.xpath.objects.XNumber(
                  num),
                m_queueMark -
                  1);
            m_ops.
              setOp(
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH),
                m_queueMark -
                  1);
            m_ops.
              setOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH,
                m_ops.
                  getOp(
                    org.apache.xpath.compiler.OpMap.
                      MAPINDEX_LENGTH) +
                  1);
            nextToken(
              );
        }
    }
    protected void Pattern() throws javax.xml.transform.TransformerException {
        while (true) {
            LocationPathPattern(
              );
            if (tokenIs(
                  '|')) {
                nextToken(
                  );
            }
            else {
                break;
            }
        }
    }
    protected void LocationPathPattern() throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        final int RELATIVE_PATH_NOT_PERMITTED =
          0;
        final int RELATIVE_PATH_PERMITTED =
          1;
        final int RELATIVE_PATH_REQUIRED =
          2;
        int relativePathStatus =
          RELATIVE_PATH_NOT_PERMITTED;
        appendOp(
          2,
          org.apache.xpath.compiler.OpCodes.
            OP_LOCATIONPATHPATTERN);
        if (lookahead(
              '(',
              1) &&
              (tokenIs(
                 org.apache.xpath.compiler.Keywords.
                   FUNC_ID_STRING) ||
                 tokenIs(
                   org.apache.xpath.compiler.Keywords.
                     FUNC_KEY_STRING))) {
            IdKeyPattern(
              );
            if (tokenIs(
                  '/')) {
                nextToken(
                  );
                if (tokenIs(
                      '/')) {
                    appendOp(
                      4,
                      org.apache.xpath.compiler.OpCodes.
                        MATCH_ANY_ANCESTOR);
                    nextToken(
                      );
                }
                else {
                    appendOp(
                      4,
                      org.apache.xpath.compiler.OpCodes.
                        MATCH_IMMEDIATE_ANCESTOR);
                }
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      2,
                    4);
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      1,
                    org.apache.xpath.compiler.OpCodes.
                      NODETYPE_FUNCTEST);
                relativePathStatus =
                  RELATIVE_PATH_REQUIRED;
            }
        }
        else
            if (tokenIs(
                  '/')) {
                if (lookahead(
                      '/',
                      1)) {
                    appendOp(
                      4,
                      org.apache.xpath.compiler.OpCodes.
                        MATCH_ANY_ANCESTOR);
                    nextToken(
                      );
                    relativePathStatus =
                      RELATIVE_PATH_REQUIRED;
                }
                else {
                    appendOp(
                      4,
                      org.apache.xpath.compiler.OpCodes.
                        FROM_ROOT);
                    relativePathStatus =
                      RELATIVE_PATH_PERMITTED;
                }
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      2,
                    4);
                m_ops.
                  setOp(
                    m_ops.
                      getOp(
                        org.apache.xpath.compiler.OpMap.
                          MAPINDEX_LENGTH) -
                      1,
                    org.apache.xpath.compiler.OpCodes.
                      NODETYPE_ROOT);
                nextToken(
                  );
            }
            else {
                relativePathStatus =
                  RELATIVE_PATH_REQUIRED;
            }
        if (relativePathStatus !=
              RELATIVE_PATH_NOT_PERMITTED) {
            if (!tokenIs(
                   '|') &&
                  null !=
                  m_token) {
                RelativePathPattern(
                  );
            }
            else
                if (relativePathStatus ==
                      RELATIVE_PATH_REQUIRED) {
                    error(
                      org.apache.xpath.res.XPATHErrorResources.
                        ER_EXPECTED_REL_PATH_PATTERN,
                      null);
                }
        }
        m_ops.
          setOp(
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH),
            org.apache.xpath.compiler.OpCodes.
              ENDOP);
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) +
              1);
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
    }
    protected void IdKeyPattern() throws javax.xml.transform.TransformerException {
        FunctionCall(
          );
    }
    protected void RelativePathPattern() throws javax.xml.transform.TransformerException {
        boolean trailingSlashConsumed =
          StepPattern(
            false);
        while (tokenIs(
                 '/')) {
            nextToken(
              );
            trailingSlashConsumed =
              StepPattern(
                !trailingSlashConsumed);
        }
    }
    protected boolean StepPattern(boolean isLeadingSlashPermitted)
          throws javax.xml.transform.TransformerException {
        return AbbreviatedNodeTestStep(
                 isLeadingSlashPermitted);
    }
    protected boolean AbbreviatedNodeTestStep(boolean isLeadingSlashPermitted)
          throws javax.xml.transform.TransformerException {
        int opPos =
          m_ops.
          getOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        int axesType;
        int matchTypePos =
          -1;
        if (tokenIs(
              '@')) {
            axesType =
              org.apache.xpath.compiler.OpCodes.
                MATCH_ATTRIBUTE;
            appendOp(
              2,
              axesType);
            nextToken(
              );
        }
        else
            if (this.
                  lookahead(
                    "::",
                    1)) {
                if (tokenIs(
                      "attribute")) {
                    axesType =
                      org.apache.xpath.compiler.OpCodes.
                        MATCH_ATTRIBUTE;
                    appendOp(
                      2,
                      axesType);
                }
                else
                    if (tokenIs(
                          "child")) {
                        matchTypePos =
                          m_ops.
                            getOp(
                              org.apache.xpath.compiler.OpMap.
                                MAPINDEX_LENGTH);
                        axesType =
                          org.apache.xpath.compiler.OpCodes.
                            MATCH_IMMEDIATE_ANCESTOR;
                        appendOp(
                          2,
                          axesType);
                    }
                    else {
                        axesType =
                          -1;
                        this.
                          error(
                            org.apache.xpath.res.XPATHErrorResources.
                              ER_AXES_NOT_ALLOWED,
                            new java.lang.Object[] { this.
                                                       m_token });
                    }
                nextToken(
                  );
                nextToken(
                  );
            }
            else
                if (tokenIs(
                      '/')) {
                    if (!isLeadingSlashPermitted) {
                        error(
                          org.apache.xpath.res.XPATHErrorResources.
                            ER_EXPECTED_STEP_PATTERN,
                          null);
                    }
                    axesType =
                      org.apache.xpath.compiler.OpCodes.
                        MATCH_ANY_ANCESTOR;
                    appendOp(
                      2,
                      axesType);
                    nextToken(
                      );
                }
                else {
                    matchTypePos =
                      m_ops.
                        getOp(
                          org.apache.xpath.compiler.OpMap.
                            MAPINDEX_LENGTH);
                    axesType =
                      org.apache.xpath.compiler.OpCodes.
                        MATCH_IMMEDIATE_ANCESTOR;
                    appendOp(
                      2,
                      axesType);
                }
        m_ops.
          setOp(
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) +
              1);
        NodeTest(
          axesType);
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH +
              1,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
        while (tokenIs(
                 '[')) {
            Predicate(
              );
        }
        boolean trailingSlashConsumed;
        if (matchTypePos >
              -1 &&
              tokenIs(
                '/') &&
              lookahead(
                '/',
                1)) {
            m_ops.
              setOp(
                matchTypePos,
                org.apache.xpath.compiler.OpCodes.
                  MATCH_ANY_ANCESTOR);
            nextToken(
              );
            trailingSlashConsumed =
              true;
        }
        else {
            trailingSlashConsumed =
              false;
        }
        m_ops.
          setOp(
            opPos +
              org.apache.xpath.compiler.OpMap.
                MAPINDEX_LENGTH,
            m_ops.
              getOp(
                org.apache.xpath.compiler.OpMap.
                  MAPINDEX_LENGTH) -
              opPos);
        return trailingSlashConsumed;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HhazNoRbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Yit2rPjLUoGVGcnBWW8x1VtwQZ7xJU2s");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "IzDrX7j/577ix9/5x9mH4P8/S+Ktx8tuAAA=");
}
