package org.apache.xpath.compiler;
class Lexer {
    private org.apache.xpath.compiler.Compiler m_compiler;
    org.apache.xml.utils.PrefixResolver m_namespaceContext;
    org.apache.xpath.compiler.XPathParser m_processor;
    static final int TARGETEXTRA = 10000;
    private int[] m_patternMap = new int[100];
    private int m_patternMapSize;
    Lexer(org.apache.xpath.compiler.Compiler compiler, org.apache.xml.utils.PrefixResolver resolver,
          org.apache.xpath.compiler.XPathParser xpathProcessor) {
        super(
          );
        m_compiler =
          compiler;
        m_namespaceContext =
          resolver;
        m_processor =
          xpathProcessor;
    }
    void tokenize(java.lang.String pat) throws javax.xml.transform.TransformerException {
        tokenize(
          pat,
          null);
    }
    void tokenize(java.lang.String pat, java.util.Vector targetStrings)
          throws javax.xml.transform.TransformerException {
        m_compiler.
          m_currentPattern =
          pat;
        m_patternMapSize =
          0;
        int initTokQueueSize =
          (pat.
             length(
               ) <
             org.apache.xpath.compiler.OpMap.
               MAXTOKENQUEUESIZE
             ? pat.
             length(
               )
             : org.apache.xpath.compiler.OpMap.
                 MAXTOKENQUEUESIZE) *
          5;
        m_compiler.
          m_opMap =
          new org.apache.xpath.compiler.OpMapVector(
            initTokQueueSize,
            org.apache.xpath.compiler.OpMap.
              BLOCKTOKENQUEUESIZE *
              5,
            org.apache.xpath.compiler.OpMap.
              MAPINDEX_LENGTH);
        int nChars =
          pat.
          length(
            );
        int startSubstring =
          -1;
        int posOfNSSep =
          -1;
        boolean isStartOfPat =
          true;
        boolean isAttrName =
          false;
        boolean isNum =
          false;
        int nesting =
          0;
        for (int i =
               0;
             i <
               nChars;
             i++) {
            char c =
              pat.
              charAt(
                i);
            switch (c) {
                case '\"':
                    {
                        if (startSubstring !=
                              -1) {
                            isNum =
                              false;
                            isStartOfPat =
                              mapPatternElemPos(
                                nesting,
                                isStartOfPat,
                                isAttrName);
                            isAttrName =
                              false;
                            if (-1 !=
                                  posOfNSSep) {
                                posOfNSSep =
                                  mapNSTokens(
                                    pat,
                                    startSubstring,
                                    posOfNSSep,
                                    i);
                            }
                            else {
                                addToTokenQueue(
                                  pat.
                                    substring(
                                      startSubstring,
                                      i));
                            }
                        }
                        startSubstring =
                          i;
                        for (i++;
                             i <
                               nChars &&
                               (c =
                                  pat.
                                    charAt(
                                      i)) !=
                               '\"';
                             i++)
                            ;
                        if (c ==
                              '\"' &&
                              i <
                              nChars) {
                            addToTokenQueue(
                              pat.
                                substring(
                                  startSubstring,
                                  i +
                                    1));
                            startSubstring =
                              -1;
                        }
                        else {
                            m_processor.
                              error(
                                org.apache.xpath.res.XPATHErrorResources.
                                  ER_EXPECTED_DOUBLE_QUOTE,
                                null);
                        }
                    }
                    break;
                case '\'':
                    if (startSubstring !=
                          -1) {
                        isNum =
                          false;
                        isStartOfPat =
                          mapPatternElemPos(
                            nesting,
                            isStartOfPat,
                            isAttrName);
                        isAttrName =
                          false;
                        if (-1 !=
                              posOfNSSep) {
                            posOfNSSep =
                              mapNSTokens(
                                pat,
                                startSubstring,
                                posOfNSSep,
                                i);
                        }
                        else {
                            addToTokenQueue(
                              pat.
                                substring(
                                  startSubstring,
                                  i));
                        }
                    }
                    startSubstring =
                      i;
                    for (i++;
                         i <
                           nChars &&
                           (c =
                              pat.
                                charAt(
                                  i)) !=
                           '\'';
                         i++)
                        ;
                    if (c ==
                          '\'' &&
                          i <
                          nChars) {
                        addToTokenQueue(
                          pat.
                            substring(
                              startSubstring,
                              i +
                                1));
                        startSubstring =
                          -1;
                    }
                    else {
                        m_processor.
                          error(
                            org.apache.xpath.res.XPATHErrorResources.
                              ER_EXPECTED_SINGLE_QUOTE,
                            null);
                    }
                    break;
                case 10:
                case 13:
                case ' ':
                case '\t':
                    if (startSubstring !=
                          -1) {
                        isNum =
                          false;
                        isStartOfPat =
                          mapPatternElemPos(
                            nesting,
                            isStartOfPat,
                            isAttrName);
                        isAttrName =
                          false;
                        if (-1 !=
                              posOfNSSep) {
                            posOfNSSep =
                              mapNSTokens(
                                pat,
                                startSubstring,
                                posOfNSSep,
                                i);
                        }
                        else {
                            addToTokenQueue(
                              pat.
                                substring(
                                  startSubstring,
                                  i));
                        }
                        startSubstring =
                          -1;
                    }
                    break;
                case '@':
                    isAttrName =
                      true;
                case '-':
                    if ('-' ==
                          c) {
                        if (!(isNum ||
                                startSubstring ==
                                -1)) {
                            break;
                        }
                        isNum =
                          false;
                    }
                case '(':
                case '[':
                case ')':
                case ']':
                case '|':
                case '/':
                case '*':
                case '+':
                case '=':
                case ',':
                case '\\':
                case '^':
                case '!':
                case '$':
                case '<':
                case '>':
                    if (startSubstring !=
                          -1) {
                        isNum =
                          false;
                        isStartOfPat =
                          mapPatternElemPos(
                            nesting,
                            isStartOfPat,
                            isAttrName);
                        isAttrName =
                          false;
                        if (-1 !=
                              posOfNSSep) {
                            posOfNSSep =
                              mapNSTokens(
                                pat,
                                startSubstring,
                                posOfNSSep,
                                i);
                        }
                        else {
                            addToTokenQueue(
                              pat.
                                substring(
                                  startSubstring,
                                  i));
                        }
                        startSubstring =
                          -1;
                    }
                    else
                        if ('/' ==
                              c &&
                              isStartOfPat) {
                            isStartOfPat =
                              mapPatternElemPos(
                                nesting,
                                isStartOfPat,
                                isAttrName);
                        }
                        else
                            if ('*' ==
                                  c) {
                                isStartOfPat =
                                  mapPatternElemPos(
                                    nesting,
                                    isStartOfPat,
                                    isAttrName);
                                isAttrName =
                                  false;
                            }
                    if (0 ==
                          nesting) {
                        if ('|' ==
                              c) {
                            if (null !=
                                  targetStrings) {
                                recordTokenString(
                                  targetStrings);
                            }
                            isStartOfPat =
                              true;
                        }
                    }
                    if (')' ==
                          c ||
                          ']' ==
                          c) {
                        nesting--;
                    }
                    else
                        if ('(' ==
                              c ||
                              '[' ==
                              c) {
                            nesting++;
                        }
                    addToTokenQueue(
                      pat.
                        substring(
                          i,
                          i +
                            1));
                    break;
                case ':':
                    if (i >
                          0) {
                        if (posOfNSSep ==
                              i -
                              1) {
                            if (startSubstring !=
                                  -1) {
                                if (startSubstring <
                                      i -
                                      1)
                                    addToTokenQueue(
                                      pat.
                                        substring(
                                          startSubstring,
                                          i -
                                            1));
                            }
                            isNum =
                              false;
                            isAttrName =
                              false;
                            startSubstring =
                              -1;
                            posOfNSSep =
                              -1;
                            addToTokenQueue(
                              pat.
                                substring(
                                  i -
                                    1,
                                  i +
                                    1));
                            break;
                        }
                        else {
                            posOfNSSep =
                              i;
                        }
                    }
                default:
                    if (-1 ==
                          startSubstring) {
                        startSubstring =
                          i;
                        isNum =
                          java.lang.Character.
                            isDigit(
                              c);
                    }
                    else
                        if (isNum) {
                            isNum =
                              java.lang.Character.
                                isDigit(
                                  c);
                        }
            }
        }
        if (startSubstring !=
              -1) {
            isNum =
              false;
            isStartOfPat =
              mapPatternElemPos(
                nesting,
                isStartOfPat,
                isAttrName);
            if (-1 !=
                  posOfNSSep ||
                  m_namespaceContext !=
                  null &&
                  m_namespaceContext.
                  handlesNullPrefixes(
                    )) {
                posOfNSSep =
                  mapNSTokens(
                    pat,
                    startSubstring,
                    posOfNSSep,
                    nChars);
            }
            else {
                addToTokenQueue(
                  pat.
                    substring(
                      startSubstring,
                      nChars));
            }
        }
        if (0 ==
              m_compiler.
              getTokenQueueSize(
                )) {
            m_processor.
              error(
                org.apache.xpath.res.XPATHErrorResources.
                  ER_EMPTY_EXPRESSION,
                null);
        }
        else
            if (null !=
                  targetStrings) {
                recordTokenString(
                  targetStrings);
            }
        m_processor.
          m_queueMark =
          0;
    }
    private boolean mapPatternElemPos(int nesting, boolean isStart,
                                      boolean isAttrName) {
        if (0 ==
              nesting) {
            if (m_patternMapSize >=
                  m_patternMap.
                    length) {
                int[] patternMap =
                  m_patternMap;
                int len =
                  m_patternMap.
                    length;
                m_patternMap =
                  (new int[m_patternMapSize +
                             100]);
                java.lang.System.
                  arraycopy(
                    patternMap,
                    0,
                    m_patternMap,
                    0,
                    len);
            }
            if (!isStart) {
                m_patternMap[m_patternMapSize -
                               1] -=
                  TARGETEXTRA;
            }
            m_patternMap[m_patternMapSize] =
              m_compiler.
                getTokenQueueSize(
                  ) -
                (isAttrName
                   ? 1
                   : 0) +
                TARGETEXTRA;
            m_patternMapSize++;
            isStart =
              false;
        }
        return isStart;
    }
    private int getTokenQueuePosFromMap(int i) { int pos =
                                                   m_patternMap[i];
                                                 return pos >=
                                                   TARGETEXTRA
                                                   ? pos -
                                                   TARGETEXTRA
                                                   : pos;
    }
    private final void resetTokenMark(int mark) { int qsz =
                                                    m_compiler.
                                                    getTokenQueueSize(
                                                      );
                                                  m_processor.
                                                    m_queueMark =
                                                    mark >
                                                      0
                                                      ? (mark <=
                                                           qsz
                                                           ? mark -
                                                           1
                                                           : mark)
                                                      : 0;
                                                  if (m_processor.
                                                        m_queueMark <
                                                        qsz) {
                                                      m_processor.
                                                        m_token =
                                                        (java.lang.String)
                                                          m_compiler.
                                                          getTokenQueue(
                                                            ).
                                                          elementAt(
                                                            m_processor.
                                                              m_queueMark++);
                                                      m_processor.
                                                        m_tokenChar =
                                                        m_processor.
                                                          m_token.
                                                          charAt(
                                                            0);
                                                  }
                                                  else {
                                                      m_processor.
                                                        m_token =
                                                        null;
                                                      m_processor.
                                                        m_tokenChar =
                                                        0;
                                                  } }
    final int getKeywordToken(java.lang.String key) { int tok;
                                                      try {
                                                          java.lang.Integer itok =
                                                            (java.lang.Integer)
                                                              org.apache.xpath.compiler.Keywords.
                                                              getKeyWord(
                                                                key);
                                                          tok =
                                                            null !=
                                                              itok
                                                              ? itok.
                                                              intValue(
                                                                )
                                                              : 0;
                                                      }
                                                      catch (java.lang.NullPointerException npe) {
                                                          tok =
                                                            0;
                                                      }
                                                      catch (java.lang.ClassCastException cce) {
                                                          tok =
                                                            0;
                                                      }
                                                      return tok;
    }
    private void recordTokenString(java.util.Vector targetStrings) {
        int tokPos =
          getTokenQueuePosFromMap(
            m_patternMapSize -
              1);
        resetTokenMark(
          tokPos +
            1);
        if (m_processor.
              lookahead(
                '(',
                1)) {
            int tok =
              getKeywordToken(
                m_processor.
                  m_token);
            switch (tok) {
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_COMMENT:
                    targetStrings.
                      addElement(
                        org.apache.xpath.compiler.PsuedoNames.
                          PSEUDONAME_COMMENT);
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_TEXT:
                    targetStrings.
                      addElement(
                        org.apache.xpath.compiler.PsuedoNames.
                          PSEUDONAME_TEXT);
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_NODE:
                    targetStrings.
                      addElement(
                        org.apache.xpath.compiler.PsuedoNames.
                          PSEUDONAME_ANY);
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_ROOT:
                    targetStrings.
                      addElement(
                        org.apache.xpath.compiler.PsuedoNames.
                          PSEUDONAME_ROOT);
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_ANYELEMENT:
                    targetStrings.
                      addElement(
                        org.apache.xpath.compiler.PsuedoNames.
                          PSEUDONAME_ANY);
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       NODETYPE_PI:
                    targetStrings.
                      addElement(
                        org.apache.xpath.compiler.PsuedoNames.
                          PSEUDONAME_ANY);
                    break;
                default:
                    targetStrings.
                      addElement(
                        org.apache.xpath.compiler.PsuedoNames.
                          PSEUDONAME_ANY);
            }
        }
        else {
            if (m_processor.
                  tokenIs(
                    '@')) {
                tokPos++;
                resetTokenMark(
                  tokPos +
                    1);
            }
            if (m_processor.
                  lookahead(
                    ':',
                    1)) {
                tokPos +=
                  2;
            }
            targetStrings.
              addElement(
                m_compiler.
                  getTokenQueue(
                    ).
                  elementAt(
                    tokPos));
        }
    }
    private final void addToTokenQueue(java.lang.String s) {
        m_compiler.
          getTokenQueue(
            ).
          addElement(
            s);
    }
    private int mapNSTokens(java.lang.String pat,
                            int startSubstring,
                            int posOfNSSep,
                            int posOfScan)
          throws javax.xml.transform.TransformerException {
        java.lang.String prefix =
          "";
        if (startSubstring >=
              0 &&
              posOfNSSep >=
              0) {
            prefix =
              pat.
                substring(
                  startSubstring,
                  posOfNSSep);
        }
        java.lang.String uName;
        if (null !=
              m_namespaceContext &&
              !prefix.
              equals(
                "*") &&
              !prefix.
              equals(
                "xmlns")) {
            try {
                if (prefix.
                      length(
                        ) >
                      0)
                    uName =
                      ((org.apache.xml.utils.PrefixResolver)
                         m_namespaceContext).
                        getNamespaceForPrefix(
                          prefix);
                else {
                    if (false) {
                        addToTokenQueue(
                          ":");
                        java.lang.String s =
                          pat.
                          substring(
                            posOfNSSep +
                              1,
                            posOfScan);
                        if (s.
                              length(
                                ) >
                              0)
                            addToTokenQueue(
                              s);
                        return -1;
                    }
                    else {
                        uName =
                          ((org.apache.xml.utils.PrefixResolver)
                             m_namespaceContext).
                            getNamespaceForPrefix(
                              prefix);
                    }
                }
            }
            catch (java.lang.ClassCastException cce) {
                uName =
                  m_namespaceContext.
                    getNamespaceForPrefix(
                      prefix);
            }
        }
        else {
            uName =
              prefix;
        }
        if (null !=
              uName &&
              uName.
              length(
                ) >
              0) {
            addToTokenQueue(
              uName);
            addToTokenQueue(
              ":");
            java.lang.String s =
              pat.
              substring(
                posOfNSSep +
                  1,
                posOfScan);
            if (s.
                  length(
                    ) >
                  0)
                addToTokenQueue(
                  s);
        }
        else {
            m_processor.
              errorForDOM3(
                org.apache.xpath.res.XPATHErrorResources.
                  ER_PREFIX_MUST_RESOLVE,
                new java.lang.String[] { prefix });
        }
        return -1;
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
       "OsRCZGgWMk147m+rruKXpQgmFkgwzY/b");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2JrdogXeWdrEugfmLx4juMZg07eauo3BaxfKguW0OUODbKX7w57cX1QjdzGy" +
       "tLi53TJVPGM8drq0l1TKePSmWY86KWTYlkJPKJRvOY0q1GpQzhrp1HEDTMkf" +
       "+EC+lfX339gW2/3FluHR9TfLLnbNfvYN7KLtPj2RF08f7bAe/T1+8vfEDuuJ" +
       "I/FSfub0yHm32orzps9+9MWXVPbn4P2D3d9VXLo79vz329pas0+druf1F04f" +
       "WL4TPM8dkPHc2Y3eY0bPO608swm9d7wD/LMFwL+8NcDhnutfKE43ijsWcSi7" +
       "UX5T5/rksKaFXeA6fr7vXyD79bz4Z3Hprthbaa6Zabfc51x7pnqsnFdfa4vz" +
       "5N75rQQEg8c5EJDzpgV0cKxSCOjUYeLpE5GRvCl0fEP5x/xXvvCZ7JWXd2eF" +
       "+dFYXCqfdwn25nu4+U2r25zbnbge+ae973/1a38kfujQiu45EsO7cm6evJ0Y" +
       "Tm+hF+ecopbfB8nb/6BA92/Pt5TPFwBfyot/c0K5+fu/PlbkF96EIh/IG58C" +
       "w/3VXd/d7+tU5MnzjDNMXDiOHuatbPHOhefZmlxc8PpageGrtzm1+UZe/BGI" +
       "Oo7sc7szk/xaNOcV0F87FsUfvwlR3Jc3Pg24euVAFK98b0RxQp9mAfDt23D6" +
       "P/Piv8WlhwwtnuTq5hMt0QCjRAiSNNk/FmjB739/E/wWYOD73q8e8Purb4Df" +
       "wk/JE1PCazC9d+F8pvcu5o1/HpfuC7XogG1aDldnzPy7b4LXe/NGEND3vnjA" +
       "6xffqG5fk80iqu9duQ2b9+fF5bh0Beh2qG03XqgWvJ7W6d49b4LP4oSyDij6" +
       "kwM+/+R7asPF++8fjfZEjvw9rzXaHxyFur133kY6j+XFg8DHQ005lMzxaeOx" +
       "Hew99GZt/jowX2jXd/f7vbf5nTE8cxt2y3lxDRiDrAJej139DLNPv9mA9g5A" +
       "d+uA2db3xhjuKADuKPgsbPe4KFhDX2NC2ys4q+TXuWSfGRe8R2ecAH4jfKdx" +
       "6WJxYTy/i/P2m/4bZfcfFMrnXrpy10MvCf9ud5Xm8L8c7qZKd+mJbZ+8MHii" +
       "fskvrrYWkLvrg37Bwgfj0jvOvd4KpmrlxL3ZvQ/s+rRAGnC2D6C8+D0J14lL" +
       "l4/h4tKlXeUkSC8uXQAgeZX0T+cYxcn67u5kunc6XT4KpQ+8lnRPZNhPncqR" +
       "iv8IOrxGknAHqdgrLw2YH/1W/ed217oVW86yHMtdVOnO3Q3zAml+FeWJc7Ed" +
       "4rpEPvOd+37p7qcPs637dgQfm+oJ2h679WXqruPHxfXn7Fce+oc/8Ldf+lJx" +
       "Ce//AoBVO9qqNQAA");
}
