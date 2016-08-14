package org.apache.batik.css.parser;
public class Parser implements org.apache.batik.css.parser.ExtendedParser, org.apache.batik.i18n.Localizable {
    public static final java.lang.String BUNDLE_CLASSNAME = "org.apache.batik.css.parser.resources.Messages";
    protected org.apache.batik.i18n.LocalizableSupport localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      BUNDLE_CLASSNAME,
      org.apache.batik.css.parser.Parser.class.
        getClassLoader(
          ));
    protected org.apache.batik.css.parser.Scanner scanner;
    protected int current;
    protected org.w3c.css.sac.DocumentHandler documentHandler = org.apache.batik.css.parser.DefaultDocumentHandler.
                                                                  INSTANCE;
    protected org.w3c.css.sac.SelectorFactory selectorFactory = org.apache.batik.css.parser.DefaultSelectorFactory.
                                                                  INSTANCE;
    protected org.w3c.css.sac.ConditionFactory conditionFactory =
      org.apache.batik.css.parser.DefaultConditionFactory.
        INSTANCE;
    protected org.w3c.css.sac.ErrorHandler errorHandler =
      org.apache.batik.css.parser.DefaultErrorHandler.
        INSTANCE;
    protected java.lang.String pseudoElement;
    protected java.lang.String documentURI;
    public java.lang.String getParserVersion() { return "http://www.w3.org/TR/REC-CSS2";
    }
    public void setLocale(java.util.Locale locale)
          throws org.w3c.css.sac.CSSException { localizableSupport.
                                                  setLocale(
                                                    locale);
    }
    public java.util.Locale getLocale() { return localizableSupport.
                                            getLocale(
                                              ); }
    public java.lang.String formatMessage(java.lang.String key,
                                          java.lang.Object[] args)
          throws java.util.MissingResourceException {
        return localizableSupport.
          formatMessage(
            key,
            args);
    }
    public void setDocumentHandler(org.w3c.css.sac.DocumentHandler handler) {
        documentHandler =
          handler;
    }
    public void setSelectorFactory(org.w3c.css.sac.SelectorFactory factory) {
        selectorFactory =
          factory;
    }
    public void setConditionFactory(org.w3c.css.sac.ConditionFactory factory) {
        conditionFactory =
          factory;
    }
    public void setErrorHandler(org.w3c.css.sac.ErrorHandler handler) {
        errorHandler =
          handler;
    }
    public void parseStyleSheet(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              try { documentHandler.
                                      startDocument(
                                        source);
                                    current = scanner.
                                                next(
                                                  );
                                    switch (current) {
                                        case org.apache.batik.css.parser.LexicalUnits.
                                               CHARSET_SYMBOL:
                                            if (nextIgnoreSpaces(
                                                  ) !=
                                                  org.apache.batik.css.parser.LexicalUnits.
                                                    STRING) {
                                                reportError(
                                                  "charset.string");
                                            }
                                            else {
                                                if (nextIgnoreSpaces(
                                                      ) !=
                                                      org.apache.batik.css.parser.LexicalUnits.
                                                        SEMI_COLON) {
                                                    reportError(
                                                      "semicolon");
                                                }
                                                next(
                                                  );
                                            }
                                            break;
                                        case org.apache.batik.css.parser.LexicalUnits.
                                               COMMENT:
                                            documentHandler.
                                              comment(
                                                scanner.
                                                  getStringValue(
                                                    ));
                                    }
                                    skipSpacesAndCDOCDC(
                                      );
                                    for (;
                                         ;
                                         ) {
                                        if (current ==
                                              org.apache.batik.css.parser.LexicalUnits.
                                                IMPORT_SYMBOL) {
                                            nextIgnoreSpaces(
                                              );
                                            parseImportRule(
                                              );
                                            nextIgnoreSpaces(
                                              );
                                        }
                                        else {
                                            break;
                                        }
                                    }
                                    loop: for (;
                                               ;
                                               ) {
                                        switch (current) {
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   PAGE_SYMBOL:
                                                nextIgnoreSpaces(
                                                  );
                                                parsePageRule(
                                                  );
                                                break;
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   MEDIA_SYMBOL:
                                                nextIgnoreSpaces(
                                                  );
                                                parseMediaRule(
                                                  );
                                                break;
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   FONT_FACE_SYMBOL:
                                                nextIgnoreSpaces(
                                                  );
                                                parseFontFaceRule(
                                                  );
                                                break;
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   AT_KEYWORD:
                                                nextIgnoreSpaces(
                                                  );
                                                parseAtRule(
                                                  );
                                                break;
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   EOF:
                                                break loop;
                                            default:
                                                parseRuleSet(
                                                  );
                                        }
                                        skipSpacesAndCDOCDC(
                                          );
                                    } }
                              finally { documentHandler.
                                          endDocument(
                                            source);
                                        scanner =
                                          null;
                              } }
    public void parseStyleSheet(java.lang.String uri)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { parseStyleSheet(
                                new org.w3c.css.sac.InputSource(
                                  uri)); }
    public void parseStyleDeclaration(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              parseStyleDeclarationInternal(
                                ); }
    protected void parseStyleDeclarationInternal()
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              try { parseStyleDeclaration(
                                      false);
                              }
                              catch (org.w3c.css.sac.CSSParseException e) {
                                  reportError(
                                    e);
                              }
                              finally {
                                  scanner =
                                    null;
                              } }
    public void parseRule(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              parseRuleInternal(
                                ); }
    protected void parseRuleInternal() throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              parseRule();
                              scanner = null;
    }
    public org.w3c.css.sac.SelectorList parseSelectors(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              return parseSelectorsInternal(
                                       );
    }
    protected org.w3c.css.sac.SelectorList parseSelectorsInternal()
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              org.w3c.css.sac.SelectorList ret =
                                parseSelectorList(
                                  );
                              scanner = null;
                              return ret;
    }
    public org.w3c.css.sac.LexicalUnit parsePropertyValue(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              return parsePropertyValueInternal(
                                       );
    }
    protected org.w3c.css.sac.LexicalUnit parsePropertyValueInternal()
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              org.w3c.css.sac.LexicalUnit exp =
                                null;
                              try { exp =
                                      parseExpression(
                                        false);
                              }
                              catch (org.w3c.css.sac.CSSParseException e) {
                                  reportError(
                                    e);
                                  throw e;
                              }
                              org.w3c.css.sac.CSSParseException exception =
                                null;
                              if (current !=
                                    org.apache.batik.css.parser.LexicalUnits.
                                      EOF)
                                  exception =
                                    createCSSParseException(
                                      "eof.expected");
                              scanner = null;
                              if (exception !=
                                    null) {
                                  errorHandler.
                                    fatalError(
                                      exception);
                              }
                              return exp;
    }
    public boolean parsePriority(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              return parsePriorityInternal(
                                       );
    }
    protected boolean parsePriorityInternal()
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              scanner = null;
                              switch (current) {
                                  case org.apache.batik.css.parser.LexicalUnits.
                                         EOF:
                                      return false;
                                  case org.apache.batik.css.parser.LexicalUnits.
                                         IMPORT_SYMBOL:
                                      return true;
                                  default:
                                      reportError(
                                        "token",
                                        new java.lang.Object[] { new java.lang.Integer(
                                          current) });
                                      return false;
                              } }
    protected void parseRule() { switch (scanner.
                                           getType(
                                             )) {
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            IMPORT_SYMBOL:
                                         nextIgnoreSpaces(
                                           );
                                         parseImportRule(
                                           );
                                         break;
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            AT_KEYWORD:
                                         nextIgnoreSpaces(
                                           );
                                         parseAtRule(
                                           );
                                         break;
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            FONT_FACE_SYMBOL:
                                         nextIgnoreSpaces(
                                           );
                                         parseFontFaceRule(
                                           );
                                         break;
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            MEDIA_SYMBOL:
                                         nextIgnoreSpaces(
                                           );
                                         parseMediaRule(
                                           );
                                         break;
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            PAGE_SYMBOL:
                                         nextIgnoreSpaces(
                                           );
                                         parsePageRule(
                                           );
                                         break;
                                     default:
                                         parseRuleSet(
                                           );
                                 } }
    protected void parseAtRule() { scanner.
                                     scanAtRule(
                                       );
                                   documentHandler.
                                     ignorableAtRule(
                                       scanner.
                                         getStringValue(
                                           ));
                                   nextIgnoreSpaces(
                                     ); }
    protected void parseImportRule() { java.lang.String uri =
                                         null;
                                       switch (current) {
                                           default:
                                               reportError(
                                                 "string.or.uri");
                                               return;
                                           case org.apache.batik.css.parser.LexicalUnits.
                                                  STRING:
                                           case org.apache.batik.css.parser.LexicalUnits.
                                                  URI:
                                               uri =
                                                 scanner.
                                                   getStringValue(
                                                     );
                                               nextIgnoreSpaces(
                                                 );
                                       }
                                       org.apache.batik.css.parser.CSSSACMediaList ml;
                                       if (current !=
                                             org.apache.batik.css.parser.LexicalUnits.
                                               IDENTIFIER) {
                                           ml =
                                             new org.apache.batik.css.parser.CSSSACMediaList(
                                               );
                                           ml.
                                             append(
                                               "all");
                                       }
                                       else {
                                           ml =
                                             parseMediaList(
                                               );
                                       }
                                       documentHandler.
                                         importStyle(
                                           uri,
                                           ml,
                                           null);
                                       if (current !=
                                             org.apache.batik.css.parser.LexicalUnits.
                                               SEMI_COLON) {
                                           reportError(
                                             "semicolon");
                                       }
                                       else {
                                           next(
                                             );
                                       } }
    protected org.apache.batik.css.parser.CSSSACMediaList parseMediaList() {
        org.apache.batik.css.parser.CSSSACMediaList result =
          new org.apache.batik.css.parser.CSSSACMediaList(
          );
        result.
          append(
            scanner.
              getStringValue(
                ));
        nextIgnoreSpaces(
          );
        while (current ==
                 org.apache.batik.css.parser.LexicalUnits.
                   COMMA) {
            nextIgnoreSpaces(
              );
            switch (current) {
                default:
                    reportError(
                      "identifier");
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       IDENTIFIER:
                    result.
                      append(
                        scanner.
                          getStringValue(
                            ));
                    nextIgnoreSpaces(
                      );
            }
        }
        return result;
    }
    protected void parseFontFaceRule() { try {
                                             documentHandler.
                                               startFontFace(
                                                 );
                                             if (current !=
                                                   org.apache.batik.css.parser.LexicalUnits.
                                                     LEFT_CURLY_BRACE) {
                                                 reportError(
                                                   "left.curly.brace");
                                             }
                                             else {
                                                 nextIgnoreSpaces(
                                                   );
                                                 try {
                                                     parseStyleDeclaration(
                                                       true);
                                                 }
                                                 catch (org.w3c.css.sac.CSSParseException e) {
                                                     reportError(
                                                       e);
                                                 }
                                             }
                                         }
                                         finally {
                                             documentHandler.
                                               endFontFace(
                                                 );
                                         }
    }
    protected void parsePageRule() { java.lang.String page =
                                       null;
                                     java.lang.String ppage =
                                       null;
                                     if (current ==
                                           org.apache.batik.css.parser.LexicalUnits.
                                             IDENTIFIER) {
                                         page =
                                           scanner.
                                             getStringValue(
                                               );
                                         nextIgnoreSpaces(
                                           );
                                         if (current ==
                                               org.apache.batik.css.parser.LexicalUnits.
                                                 COLON) {
                                             nextIgnoreSpaces(
                                               );
                                             if (current !=
                                                   org.apache.batik.css.parser.LexicalUnits.
                                                     IDENTIFIER) {
                                                 reportError(
                                                   "identifier");
                                                 return;
                                             }
                                             ppage =
                                               scanner.
                                                 getStringValue(
                                                   );
                                             nextIgnoreSpaces(
                                               );
                                         }
                                     }
                                     try {
                                         documentHandler.
                                           startPage(
                                             page,
                                             ppage);
                                         if (current !=
                                               org.apache.batik.css.parser.LexicalUnits.
                                                 LEFT_CURLY_BRACE) {
                                             reportError(
                                               "left.curly.brace");
                                         }
                                         else {
                                             nextIgnoreSpaces(
                                               );
                                             try {
                                                 parseStyleDeclaration(
                                                   true);
                                             }
                                             catch (org.w3c.css.sac.CSSParseException e) {
                                                 reportError(
                                                   e);
                                             }
                                         }
                                     }
                                     finally {
                                         documentHandler.
                                           endPage(
                                             page,
                                             ppage);
                                     } }
    protected void parseMediaRule() { if (current !=
                                            org.apache.batik.css.parser.LexicalUnits.
                                              IDENTIFIER) {
                                          reportError(
                                            "identifier");
                                          return;
                                      }
                                      org.apache.batik.css.parser.CSSSACMediaList ml =
                                        parseMediaList(
                                          );
                                      try {
                                          documentHandler.
                                            startMedia(
                                              ml);
                                          if (current !=
                                                org.apache.batik.css.parser.LexicalUnits.
                                                  LEFT_CURLY_BRACE) {
                                              reportError(
                                                "left.curly.brace");
                                          }
                                          else {
                                              nextIgnoreSpaces(
                                                );
                                              loop: for (;
                                                         ;
                                                         ) {
                                                  switch (current) {
                                                      case org.apache.batik.css.parser.LexicalUnits.
                                                             EOF:
                                                      case org.apache.batik.css.parser.LexicalUnits.
                                                             RIGHT_CURLY_BRACE:
                                                          break loop;
                                                      default:
                                                          parseRuleSet(
                                                            );
                                                  }
                                              }
                                              nextIgnoreSpaces(
                                                );
                                          }
                                      }
                                      finally {
                                          documentHandler.
                                            endMedia(
                                              ml);
                                      } }
    protected void parseRuleSet() { org.w3c.css.sac.SelectorList sl =
                                      null;
                                    try {
                                        sl =
                                          parseSelectorList(
                                            );
                                    }
                                    catch (org.w3c.css.sac.CSSParseException e) {
                                        reportError(
                                          e);
                                        return;
                                    }
                                    try {
                                        documentHandler.
                                          startSelector(
                                            sl);
                                        if (current !=
                                              org.apache.batik.css.parser.LexicalUnits.
                                                LEFT_CURLY_BRACE) {
                                            reportError(
                                              "left.curly.brace");
                                            if (current ==
                                                  org.apache.batik.css.parser.LexicalUnits.
                                                    RIGHT_CURLY_BRACE) {
                                                nextIgnoreSpaces(
                                                  );
                                            }
                                        }
                                        else {
                                            nextIgnoreSpaces(
                                              );
                                            try {
                                                parseStyleDeclaration(
                                                  true);
                                            }
                                            catch (org.w3c.css.sac.CSSParseException e) {
                                                reportError(
                                                  e);
                                            }
                                        }
                                    }
                                    finally {
                                        documentHandler.
                                          endSelector(
                                            sl);
                                    } }
    protected org.w3c.css.sac.SelectorList parseSelectorList() {
        org.apache.batik.css.parser.CSSSelectorList result =
          new org.apache.batik.css.parser.CSSSelectorList(
          );
        result.
          append(
            parseSelector(
              ));
        for (;
             ;
             ) {
            if (current !=
                  org.apache.batik.css.parser.LexicalUnits.
                    COMMA) {
                return result;
            }
            nextIgnoreSpaces(
              );
            result.
              append(
                parseSelector(
                  ));
        }
    }
    protected org.w3c.css.sac.Selector parseSelector() {
        pseudoElement =
          null;
        org.w3c.css.sac.Selector result =
          parseSimpleSelector(
            );
        loop: for (;
                   ;
                   ) {
            switch (current) {
                default:
                    break loop;
                case org.apache.batik.css.parser.LexicalUnits.
                       IDENTIFIER:
                case org.apache.batik.css.parser.LexicalUnits.
                       ANY:
                case org.apache.batik.css.parser.LexicalUnits.
                       HASH:
                case org.apache.batik.css.parser.LexicalUnits.
                       DOT:
                case org.apache.batik.css.parser.LexicalUnits.
                       LEFT_BRACKET:
                case org.apache.batik.css.parser.LexicalUnits.
                       COLON:
                    if (pseudoElement !=
                          null) {
                        throw createCSSParseException(
                                "pseudo.element.position");
                    }
                    result =
                      selectorFactory.
                        createDescendantSelector(
                          result,
                          parseSimpleSelector(
                            ));
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       PLUS:
                    if (pseudoElement !=
                          null) {
                        throw createCSSParseException(
                                "pseudo.element.position");
                    }
                    nextIgnoreSpaces(
                      );
                    result =
                      selectorFactory.
                        createDirectAdjacentSelector(
                          (short)
                            1,
                          result,
                          parseSimpleSelector(
                            ));
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       PRECEDE:
                    if (pseudoElement !=
                          null) {
                        throw createCSSParseException(
                                "pseudo.element.position");
                    }
                    nextIgnoreSpaces(
                      );
                    result =
                      selectorFactory.
                        createChildSelector(
                          result,
                          parseSimpleSelector(
                            ));
            }
        }
        if (pseudoElement !=
              null) {
            result =
              selectorFactory.
                createChildSelector(
                  result,
                  selectorFactory.
                    createPseudoElementSelector(
                      null,
                      pseudoElement));
        }
        return result;
    }
    protected org.w3c.css.sac.SimpleSelector parseSimpleSelector() {
        org.w3c.css.sac.SimpleSelector result;
        switch (current) {
            case org.apache.batik.css.parser.LexicalUnits.
                   IDENTIFIER:
                result =
                  selectorFactory.
                    createElementSelector(
                      null,
                      scanner.
                        getStringValue(
                          ));
                next(
                  );
                break;
            case org.apache.batik.css.parser.LexicalUnits.
                   ANY:
                next(
                  );
            default:
                result =
                  selectorFactory.
                    createElementSelector(
                      null,
                      null);
        }
        org.w3c.css.sac.Condition cond =
          null;
        loop: for (;
                   ;
                   ) {
            org.w3c.css.sac.Condition c =
              null;
            switch (current) {
                case org.apache.batik.css.parser.LexicalUnits.
                       HASH:
                    c =
                      conditionFactory.
                        createIdCondition(
                          scanner.
                            getStringValue(
                              ));
                    next(
                      );
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       DOT:
                    if (next(
                          ) !=
                          org.apache.batik.css.parser.LexicalUnits.
                            IDENTIFIER) {
                        throw createCSSParseException(
                                "identifier");
                    }
                    c =
                      conditionFactory.
                        createClassCondition(
                          null,
                          scanner.
                            getStringValue(
                              ));
                    next(
                      );
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       LEFT_BRACKET:
                    if (nextIgnoreSpaces(
                          ) !=
                          org.apache.batik.css.parser.LexicalUnits.
                            IDENTIFIER) {
                        throw createCSSParseException(
                                "identifier");
                    }
                    java.lang.String name =
                      scanner.
                      getStringValue(
                        );
                    int op =
                      nextIgnoreSpaces(
                        );
                    switch (op) {
                        default:
                            throw createCSSParseException(
                                    "right.bracket");
                        case org.apache.batik.css.parser.LexicalUnits.
                               RIGHT_BRACKET:
                            nextIgnoreSpaces(
                              );
                            c =
                              conditionFactory.
                                createAttributeCondition(
                                  name,
                                  null,
                                  false,
                                  null);
                            break;
                        case org.apache.batik.css.parser.LexicalUnits.
                               EQUAL:
                        case org.apache.batik.css.parser.LexicalUnits.
                               INCLUDES:
                        case org.apache.batik.css.parser.LexicalUnits.
                               DASHMATCH:
                            java.lang.String val =
                              null;
                            switch (nextIgnoreSpaces(
                                      )) {
                                default:
                                    throw createCSSParseException(
                                            "identifier.or.string");
                                case org.apache.batik.css.parser.LexicalUnits.
                                       STRING:
                                case org.apache.batik.css.parser.LexicalUnits.
                                       IDENTIFIER:
                                    val =
                                      scanner.
                                        getStringValue(
                                          );
                                    nextIgnoreSpaces(
                                      );
                            }
                            if (current !=
                                  org.apache.batik.css.parser.LexicalUnits.
                                    RIGHT_BRACKET) {
                                throw createCSSParseException(
                                        "right.bracket");
                            }
                            next(
                              );
                            switch (op) {
                                case org.apache.batik.css.parser.LexicalUnits.
                                       EQUAL:
                                    c =
                                      conditionFactory.
                                        createAttributeCondition(
                                          name,
                                          null,
                                          false,
                                          val);
                                    break;
                                case org.apache.batik.css.parser.LexicalUnits.
                                       INCLUDES:
                                    c =
                                      conditionFactory.
                                        createOneOfAttributeCondition(
                                          name,
                                          null,
                                          false,
                                          val);
                                    break;
                                default:
                                    c =
                                      conditionFactory.
                                        createBeginHyphenAttributeCondition(
                                          name,
                                          null,
                                          false,
                                          val);
                            }
                    }
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       COLON:
                    switch (nextIgnoreSpaces(
                              )) {
                        case org.apache.batik.css.parser.LexicalUnits.
                               IDENTIFIER:
                            java.lang.String val2 =
                              scanner.
                              getStringValue(
                                );
                            if (isPseudoElement(
                                  val2)) {
                                if (pseudoElement !=
                                      null) {
                                    throw createCSSParseException(
                                            "duplicate.pseudo.element");
                                }
                                pseudoElement =
                                  val2;
                            }
                            else {
                                c =
                                  conditionFactory.
                                    createPseudoClassCondition(
                                      null,
                                      val2);
                            }
                            next(
                              );
                            break;
                        case org.apache.batik.css.parser.LexicalUnits.
                               FUNCTION:
                            java.lang.String func =
                              scanner.
                              getStringValue(
                                );
                            if (nextIgnoreSpaces(
                                  ) !=
                                  org.apache.batik.css.parser.LexicalUnits.
                                    IDENTIFIER) {
                                throw createCSSParseException(
                                        "identifier");
                            }
                            java.lang.String lang =
                              scanner.
                              getStringValue(
                                );
                            if (nextIgnoreSpaces(
                                  ) !=
                                  org.apache.batik.css.parser.LexicalUnits.
                                    RIGHT_BRACE) {
                                throw createCSSParseException(
                                        "right.brace");
                            }
                            if (!func.
                                  equalsIgnoreCase(
                                    "lang")) {
                                throw createCSSParseException(
                                        "pseudo.function");
                            }
                            c =
                              conditionFactory.
                                createLangCondition(
                                  lang);
                            next(
                              );
                            break;
                        default:
                            throw createCSSParseException(
                                    "identifier");
                    }
                    break;
                default:
                    break loop;
            }
            if (c !=
                  null) {
                if (cond ==
                      null) {
                    cond =
                      c;
                }
                else {
                    cond =
                      conditionFactory.
                        createAndCondition(
                          cond,
                          c);
                }
            }
        }
        skipSpaces(
          );
        if (cond !=
              null) {
            result =
              selectorFactory.
                createConditionalSelector(
                  result,
                  cond);
        }
        return result;
    }
    protected boolean isPseudoElement(java.lang.String s) {
        switch (s.
                  charAt(
                    0)) {
            case 'a':
            case 'A':
                return s.
                  equalsIgnoreCase(
                    "after");
            case 'b':
            case 'B':
                return s.
                  equalsIgnoreCase(
                    "before");
            case 'f':
            case 'F':
                return s.
                  equalsIgnoreCase(
                    "first-letter") ||
                  s.
                  equalsIgnoreCase(
                    "first-line");
        }
        return false;
    }
    protected void parseStyleDeclaration(boolean inSheet)
          throws org.w3c.css.sac.CSSException {
        for (;
             ;
             ) {
            switch (current) {
                case org.apache.batik.css.parser.LexicalUnits.
                       EOF:
                    if (inSheet) {
                        throw createCSSParseException(
                                "eof");
                    }
                    return;
                case org.apache.batik.css.parser.LexicalUnits.
                       RIGHT_CURLY_BRACE:
                    if (!inSheet) {
                        throw createCSSParseException(
                                "eof.expected");
                    }
                    nextIgnoreSpaces(
                      );
                    return;
                case org.apache.batik.css.parser.LexicalUnits.
                       SEMI_COLON:
                    nextIgnoreSpaces(
                      );
                    continue;
                default:
                    throw createCSSParseException(
                            "identifier");
                case org.apache.batik.css.parser.LexicalUnits.
                       IDENTIFIER:
            }
            java.lang.String name =
              scanner.
              getStringValue(
                );
            if (nextIgnoreSpaces(
                  ) !=
                  org.apache.batik.css.parser.LexicalUnits.
                    COLON) {
                throw createCSSParseException(
                        "colon");
            }
            nextIgnoreSpaces(
              );
            org.w3c.css.sac.LexicalUnit exp =
              null;
            try {
                exp =
                  parseExpression(
                    false);
            }
            catch (org.w3c.css.sac.CSSParseException e) {
                reportError(
                  e);
            }
            if (exp !=
                  null) {
                boolean important =
                  false;
                if (current ==
                      org.apache.batik.css.parser.LexicalUnits.
                        IMPORTANT_SYMBOL) {
                    important =
                      true;
                    nextIgnoreSpaces(
                      );
                }
                documentHandler.
                  property(
                    name,
                    exp,
                    important);
            }
        }
    }
    protected org.w3c.css.sac.LexicalUnit parseExpression(boolean param) {
        org.w3c.css.sac.LexicalUnit result =
          parseTerm(
            null);
        org.w3c.css.sac.LexicalUnit curr =
          result;
        for (;
             ;
             ) {
            boolean op =
              false;
            switch (current) {
                case org.apache.batik.css.parser.LexicalUnits.
                       COMMA:
                    op =
                      true;
                    curr =
                      org.apache.batik.css.parser.CSSLexicalUnit.
                        createSimple(
                          org.w3c.css.sac.LexicalUnit.
                            SAC_OPERATOR_COMMA,
                          curr);
                    nextIgnoreSpaces(
                      );
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       DIVIDE:
                    op =
                      true;
                    curr =
                      org.apache.batik.css.parser.CSSLexicalUnit.
                        createSimple(
                          org.w3c.css.sac.LexicalUnit.
                            SAC_OPERATOR_SLASH,
                          curr);
                    nextIgnoreSpaces(
                      );
            }
            if (param) {
                if (current ==
                      org.apache.batik.css.parser.LexicalUnits.
                        RIGHT_BRACE) {
                    if (op) {
                        throw createCSSParseException(
                                "token",
                                new java.lang.Object[] { new java.lang.Integer(
                                  current) });
                    }
                    return result;
                }
                curr =
                  parseTerm(
                    curr);
            }
            else {
                switch (current) {
                    case org.apache.batik.css.parser.LexicalUnits.
                           IMPORTANT_SYMBOL:
                    case org.apache.batik.css.parser.LexicalUnits.
                           SEMI_COLON:
                    case org.apache.batik.css.parser.LexicalUnits.
                           RIGHT_CURLY_BRACE:
                    case org.apache.batik.css.parser.LexicalUnits.
                           EOF:
                        if (op) {
                            throw createCSSParseException(
                                    "token",
                                    new java.lang.Object[] { new java.lang.Integer(
                                      current) });
                        }
                        return result;
                    default:
                        curr =
                          parseTerm(
                            curr);
                }
            }
        }
    }
    protected org.w3c.css.sac.LexicalUnit parseTerm(org.w3c.css.sac.LexicalUnit prev) {
        boolean plus =
          true;
        boolean sgn =
          false;
        switch (current) {
            case org.apache.batik.css.parser.LexicalUnits.
                   MINUS:
                plus =
                  false;
            case org.apache.batik.css.parser.LexicalUnits.
                   PLUS:
                next(
                  );
                sgn =
                  true;
            default:
                switch (current) {
                    case org.apache.batik.css.parser.LexicalUnits.
                           INTEGER:
                        java.lang.String sval =
                          scanner.
                          getStringValue(
                            );
                        if (!plus)
                            sval =
                              "-" +
                              sval;
                        long lVal =
                          java.lang.Long.
                          parseLong(
                            sval);
                        if (lVal >=
                              java.lang.Integer.
                                MIN_VALUE &&
                              lVal <=
                              java.lang.Integer.
                                MAX_VALUE) {
                            int iVal =
                              (int)
                                lVal;
                            nextIgnoreSpaces(
                              );
                            return org.apache.batik.css.parser.CSSLexicalUnit.
                              createInteger(
                                iVal,
                                prev);
                        }
                    case org.apache.batik.css.parser.LexicalUnits.
                           REAL:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_REAL,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           PERCENTAGE:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_PERCENTAGE,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           PT:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_POINT,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           PC:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_PICA,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           PX:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_PIXEL,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           CM:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_CENTIMETER,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           MM:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_MILLIMETER,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           IN:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_INCH,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           EM:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_EM,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           EX:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_EX,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           DEG:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_DEGREE,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           RAD:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_RADIAN,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           GRAD:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_GRADIAN,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           S:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_SECOND,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           MS:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_MILLISECOND,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           HZ:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_HERTZ,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           KHZ:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_KILOHERTZ,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           DIMENSION:
                        return dimension(
                                 plus,
                                 prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           FUNCTION:
                        return parseFunction(
                                 plus,
                                 prev);
                }
                if (sgn) {
                    throw createCSSParseException(
                            "token",
                            new java.lang.Object[] { new java.lang.Integer(
                              current) });
                }
        }
        switch (current) {
            case org.apache.batik.css.parser.LexicalUnits.
                   STRING:
                java.lang.String val =
                  scanner.
                  getStringValue(
                    );
                nextIgnoreSpaces(
                  );
                return org.apache.batik.css.parser.CSSLexicalUnit.
                  createString(
                    org.w3c.css.sac.LexicalUnit.
                      SAC_STRING_VALUE,
                    val,
                    prev);
            case org.apache.batik.css.parser.LexicalUnits.
                   IDENTIFIER:
                val =
                  scanner.
                    getStringValue(
                      );
                nextIgnoreSpaces(
                  );
                if (val.
                      equalsIgnoreCase(
                        "inherit")) {
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createSimple(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_INHERIT,
                        prev);
                }
                else {
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createString(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_IDENT,
                        val,
                        prev);
                }
            case org.apache.batik.css.parser.LexicalUnits.
                   URI:
                val =
                  scanner.
                    getStringValue(
                      );
                nextIgnoreSpaces(
                  );
                return org.apache.batik.css.parser.CSSLexicalUnit.
                  createString(
                    org.w3c.css.sac.LexicalUnit.
                      SAC_URI,
                    val,
                    prev);
            case org.apache.batik.css.parser.LexicalUnits.
                   HASH:
                return hexcolor(
                         prev);
            default:
                throw createCSSParseException(
                        "token",
                        new java.lang.Object[] { new java.lang.Integer(
                          current) });
        }
    }
    protected org.w3c.css.sac.LexicalUnit parseFunction(boolean positive,
                                                        org.w3c.css.sac.LexicalUnit prev) {
        java.lang.String name =
          scanner.
          getStringValue(
            );
        nextIgnoreSpaces(
          );
        org.w3c.css.sac.LexicalUnit params =
          parseExpression(
            true);
        if (current !=
              org.apache.batik.css.parser.LexicalUnits.
                RIGHT_BRACE) {
            throw createCSSParseException(
                    "token",
                    new java.lang.Object[] { new java.lang.Integer(
                      current) });
        }
        nextIgnoreSpaces(
          );
        predefined: switch (name.
                              charAt(
                                0)) {
            case 'r':
            case 'R':
                org.w3c.css.sac.LexicalUnit lu;
                if (name.
                      equalsIgnoreCase(
                        "rgb")) {
                    lu =
                      params;
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_INTEGER:
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_PERCENTAGE:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_OPERATOR_COMMA:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_INTEGER:
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_PERCENTAGE:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_OPERATOR_COMMA:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_INTEGER:
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_PERCENTAGE:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu !=
                          null) {
                        break;
                    }
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createPredefinedFunction(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_RGBCOLOR,
                        params,
                        prev);
                }
                else
                    if (name.
                          equalsIgnoreCase(
                            "rect")) {
                        lu =
                          params;
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INTEGER:
                                if (lu.
                                      getIntegerValue(
                                        ) !=
                                      0) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                if (!lu.
                                      getStringValue(
                                        ).
                                      equalsIgnoreCase(
                                        "auto")) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EM:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EX:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PIXEL:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_CENTIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_MILLIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INCH:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_POINT:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PICA:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PERCENTAGE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INTEGER:
                                if (lu.
                                      getIntegerValue(
                                        ) !=
                                      0) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                if (!lu.
                                      getStringValue(
                                        ).
                                      equalsIgnoreCase(
                                        "auto")) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EM:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EX:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PIXEL:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_CENTIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_MILLIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INCH:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_POINT:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PICA:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PERCENTAGE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INTEGER:
                                if (lu.
                                      getIntegerValue(
                                        ) !=
                                      0) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                if (!lu.
                                      getStringValue(
                                        ).
                                      equalsIgnoreCase(
                                        "auto")) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EM:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EX:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PIXEL:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_CENTIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_MILLIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INCH:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_POINT:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PICA:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PERCENTAGE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INTEGER:
                                if (lu.
                                      getIntegerValue(
                                        ) !=
                                      0) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                if (!lu.
                                      getStringValue(
                                        ).
                                      equalsIgnoreCase(
                                        "auto")) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EM:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EX:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PIXEL:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_CENTIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_MILLIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INCH:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_POINT:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PICA:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PERCENTAGE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu !=
                              null) {
                            break;
                        }
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createPredefinedFunction(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_RECT_FUNCTION,
                            params,
                            prev);
                    }
                break;
            case 'c':
            case 'C':
                if (name.
                      equalsIgnoreCase(
                        "counter")) {
                    lu =
                      params;
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_IDENT:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_OPERATOR_COMMA:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_IDENT:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu !=
                          null) {
                        break;
                    }
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createPredefinedFunction(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_COUNTER_FUNCTION,
                        params,
                        prev);
                }
                else
                    if (name.
                          equalsIgnoreCase(
                            "counters")) {
                        lu =
                          params;
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_STRING_VALUE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu !=
                              null) {
                            break;
                        }
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createPredefinedFunction(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_COUNTERS_FUNCTION,
                            params,
                            prev);
                    }
                break;
            case 'a':
            case 'A':
                if (name.
                      equalsIgnoreCase(
                        "attr")) {
                    lu =
                      params;
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_IDENT:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu !=
                          null) {
                        break;
                    }
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createString(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_ATTR,
                        params.
                          getStringValue(
                            ),
                        prev);
                }
        }
        return org.apache.batik.css.parser.CSSLexicalUnit.
          createFunction(
            name,
            params,
            prev);
    }
    protected org.w3c.css.sac.LexicalUnit hexcolor(org.w3c.css.sac.LexicalUnit prev) {
        java.lang.String val =
          scanner.
          getStringValue(
            );
        int len =
          val.
          length(
            );
        org.w3c.css.sac.LexicalUnit params =
          null;
        switch (len) {
            case 3:
                char rc =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        0));
                char gc =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        1));
                char bc =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        2));
                if (!org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        rc) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        gc) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        bc)) {
                    throw createCSSParseException(
                            "rgb.color",
                            new java.lang.Object[] { val });
                }
                int t;
                int r =
                  t =
                  rc >=
                    '0' &&
                    rc <=
                    '9'
                    ? rc -
                    '0'
                    : rc -
                    'a' +
                    10;
                t <<=
                  4;
                r |=
                  t;
                int g =
                  t =
                  gc >=
                    '0' &&
                    gc <=
                    '9'
                    ? gc -
                    '0'
                    : gc -
                    'a' +
                    10;
                t <<=
                  4;
                g |=
                  t;
                int b =
                  t =
                  bc >=
                    '0' &&
                    bc <=
                    '9'
                    ? bc -
                    '0'
                    : bc -
                    'a' +
                    10;
                t <<=
                  4;
                b |=
                  t;
                params =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      r,
                      null);
                org.w3c.css.sac.LexicalUnit tmp;
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createSimple(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_OPERATOR_COMMA,
                      params);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      g,
                      tmp);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createSimple(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_OPERATOR_COMMA,
                      tmp);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      b,
                      tmp);
                break;
            case 6:
                char rc1 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        0));
                char rc2 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        1));
                char gc1 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        2));
                char gc2 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        3));
                char bc1 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        4));
                char bc2 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        5));
                if (!org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        rc1) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        rc2) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        gc1) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        gc2) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        bc1) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        bc2)) {
                    throw createCSSParseException(
                            "rgb.color");
                }
                r =
                  rc1 >=
                    '0' &&
                    rc1 <=
                    '9'
                    ? rc1 -
                    '0'
                    : rc1 -
                    'a' +
                    10;
                r <<=
                  4;
                r |=
                  rc2 >=
                    '0' &&
                    rc2 <=
                    '9'
                    ? rc2 -
                    '0'
                    : rc2 -
                    'a' +
                    10;
                g =
                  gc1 >=
                    '0' &&
                    gc1 <=
                    '9'
                    ? gc1 -
                    '0'
                    : gc1 -
                    'a' +
                    10;
                g <<=
                  4;
                g |=
                  gc2 >=
                    '0' &&
                    gc2 <=
                    '9'
                    ? gc2 -
                    '0'
                    : gc2 -
                    'a' +
                    10;
                b =
                  bc1 >=
                    '0' &&
                    bc1 <=
                    '9'
                    ? bc1 -
                    '0'
                    : bc1 -
                    'a' +
                    10;
                b <<=
                  4;
                b |=
                  bc2 >=
                    '0' &&
                    bc2 <=
                    '9'
                    ? bc2 -
                    '0'
                    : bc2 -
                    'a' +
                    10;
                params =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      r,
                      null);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createSimple(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_OPERATOR_COMMA,
                      params);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      g,
                      tmp);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createSimple(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_OPERATOR_COMMA,
                      tmp);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      b,
                      tmp);
                break;
            default:
                throw createCSSParseException(
                        "rgb.color",
                        new java.lang.Object[] { val });
        }
        nextIgnoreSpaces(
          );
        return org.apache.batik.css.parser.CSSLexicalUnit.
          createPredefinedFunction(
            org.w3c.css.sac.LexicalUnit.
              SAC_RGBCOLOR,
            params,
            prev);
    }
    protected org.apache.batik.css.parser.Scanner createScanner(org.w3c.css.sac.InputSource source) {
        documentURI =
          source.
            getURI(
              );
        if (documentURI ==
              null) {
            documentURI =
              "";
        }
        java.io.Reader r =
          source.
          getCharacterStream(
            );
        if (r !=
              null) {
            return new org.apache.batik.css.parser.Scanner(
              r);
        }
        java.io.InputStream is =
          source.
          getByteStream(
            );
        if (is !=
              null) {
            return new org.apache.batik.css.parser.Scanner(
              is,
              source.
                getEncoding(
                  ));
        }
        java.lang.String uri =
          source.
          getURI(
            );
        if (uri ==
              null) {
            throw new org.w3c.css.sac.CSSException(
              formatMessage(
                "empty.source",
                null));
        }
        try {
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              uri);
            is =
              purl.
                openStreamRaw(
                  org.apache.batik.util.CSSConstants.
                    CSS_MIME_TYPE);
            return new org.apache.batik.css.parser.Scanner(
              is,
              source.
                getEncoding(
                  ));
        }
        catch (java.io.IOException e) {
            throw new org.w3c.css.sac.CSSException(
              e);
        }
    }
    protected int skipSpaces() { int lex =
                                   scanner.
                                   getType(
                                     );
                                 while (lex ==
                                          org.apache.batik.css.parser.LexicalUnits.
                                            SPACE) {
                                     lex =
                                       next(
                                         );
                                 }
                                 return lex;
    }
    protected int skipSpacesAndCDOCDC() {
        loop: for (;
                   ;
                   ) {
            switch (current) {
                default:
                    break loop;
                case org.apache.batik.css.parser.LexicalUnits.
                       COMMENT:
                case org.apache.batik.css.parser.LexicalUnits.
                       SPACE:
                case org.apache.batik.css.parser.LexicalUnits.
                       CDO:
                case org.apache.batik.css.parser.LexicalUnits.
                       CDC:
            }
            scanner.
              clearBuffer(
                );
            next(
              );
        }
        return current;
    }
    protected float number(boolean positive) {
        try {
            float sgn =
              positive
              ? 1
              : -1;
            java.lang.String val =
              scanner.
              getStringValue(
                );
            nextIgnoreSpaces(
              );
            return sgn *
              java.lang.Float.
              parseFloat(
                val);
        }
        catch (java.lang.NumberFormatException e) {
            throw createCSSParseException(
                    "number.format");
        }
    }
    protected org.w3c.css.sac.LexicalUnit dimension(boolean positive,
                                                    org.w3c.css.sac.LexicalUnit prev) {
        try {
            float sgn =
              positive
              ? 1
              : -1;
            java.lang.String val =
              scanner.
              getStringValue(
                );
            int i;
            loop: for (i =
                         0;
                       i <
                         val.
                         length(
                           );
                       i++) {
                switch (val.
                          charAt(
                            i)) {
                    default:
                        break loop;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '.':
                }
            }
            nextIgnoreSpaces(
              );
            return org.apache.batik.css.parser.CSSLexicalUnit.
              createDimension(
                sgn *
                  java.lang.Float.
                  parseFloat(
                    val.
                      substring(
                        0,
                        i)),
                val.
                  substring(
                    i),
                prev);
        }
        catch (java.lang.NumberFormatException e) {
            throw createCSSParseException(
                    "number.format");
        }
    }
    protected int next() { try { for (; ;
                                      ) {
                                     scanner.
                                       clearBuffer(
                                         );
                                     current =
                                       scanner.
                                         next(
                                           );
                                     if (current ==
                                           org.apache.batik.css.parser.LexicalUnits.
                                             COMMENT) {
                                         documentHandler.
                                           comment(
                                             scanner.
                                               getStringValue(
                                                 ));
                                     }
                                     else {
                                         break;
                                     }
                                 }
                                 return current;
                           }
                           catch (org.apache.batik.css.parser.ParseException e) {
                               reportError(
                                 e.
                                   getMessage(
                                     ));
                               return current;
                           } }
    protected int nextIgnoreSpaces() { try {
                                           loop: for (;
                                                      ;
                                                      ) {
                                               scanner.
                                                 clearBuffer(
                                                   );
                                               current =
                                                 scanner.
                                                   next(
                                                     );
                                               switch (current) {
                                                   case org.apache.batik.css.parser.LexicalUnits.
                                                          COMMENT:
                                                       documentHandler.
                                                         comment(
                                                           scanner.
                                                             getStringValue(
                                                               ));
                                                       break;
                                                   default:
                                                       break loop;
                                                   case org.apache.batik.css.parser.LexicalUnits.
                                                          SPACE:
                                               }
                                           }
                                           return current;
                                       }
                                       catch (org.apache.batik.css.parser.ParseException e) {
                                           errorHandler.
                                             error(
                                               createCSSParseException(
                                                 e.
                                                   getMessage(
                                                     )));
                                           return current;
                                       } }
    protected void reportError(java.lang.String key) {
        reportError(
          key,
          null);
    }
    protected void reportError(java.lang.String key,
                               java.lang.Object[] params) {
        reportError(
          createCSSParseException(
            key,
            params));
    }
    protected void reportError(org.w3c.css.sac.CSSParseException e) {
        errorHandler.
          error(
            e);
        int cbraces =
          1;
        for (;
             ;
             ) {
            switch (current) {
                case org.apache.batik.css.parser.LexicalUnits.
                       EOF:
                    return;
                case org.apache.batik.css.parser.LexicalUnits.
                       SEMI_COLON:
                case org.apache.batik.css.parser.LexicalUnits.
                       RIGHT_CURLY_BRACE:
                    if (--cbraces ==
                          0) {
                        nextIgnoreSpaces(
                          );
                        return;
                    }
                case org.apache.batik.css.parser.LexicalUnits.
                       LEFT_CURLY_BRACE:
                    cbraces++;
            }
            nextIgnoreSpaces(
              );
        }
    }
    protected org.w3c.css.sac.CSSParseException createCSSParseException(java.lang.String key) {
        return createCSSParseException(
                 key,
                 null);
    }
    protected org.w3c.css.sac.CSSParseException createCSSParseException(java.lang.String key,
                                                                        java.lang.Object[] params) {
        return new org.w3c.css.sac.CSSParseException(
          formatMessage(
            key,
            params),
          documentURI,
          scanner.
            getLine(
              ),
          scanner.
            getColumn(
              ));
    }
    public void parseStyleDeclaration(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              parseStyleDeclarationInternal(
                                ); }
    public void parseRule(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              parseRuleInternal(
                                ); }
    public org.w3c.css.sac.SelectorList parseSelectors(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              return parseSelectorsInternal(
                                       );
    }
    public org.w3c.css.sac.LexicalUnit parsePropertyValue(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              return parsePropertyValueInternal(
                                       );
    }
    public boolean parsePriority(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              return parsePriorityInternal(
                                       );
    }
    public org.w3c.css.sac.SACMediaList parseMedia(java.lang.String mediaText)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { org.apache.batik.css.parser.CSSSACMediaList result =
                                new org.apache.batik.css.parser.CSSSACMediaList(
                                );
                              if (!"all".
                                    equalsIgnoreCase(
                                      mediaText)) {
                                  java.util.StringTokenizer st =
                                    new java.util.StringTokenizer(
                                    mediaText,
                                    " ,");
                                  while (st.
                                           hasMoreTokens(
                                             )) {
                                      result.
                                        append(
                                          st.
                                            nextToken(
                                              ));
                                  }
                              }
                              return result;
    }
    public Parser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVcC5wUxZmvmWGHZWF5LPIQYYFlMfJwV1B8HIqBZVcXBthj" +
       "BM36WHt7encberub7hp2wGCCP43o5Xzi43zwu/MwKqLkPL14OaPkjCKay8VH" +
       "TDRREx935ogXMb9oPM1531ddPd3TM9Wz7e96f7/+Zrarvqr6/+urr76qrun9" +
       "H5Aa2yKNik5b6DZTsVvaddolWbaSa9Mk2z4P7vXIt6WkP1zy/tozkiTdTcYO" +
       "SPYaWbKVDlXRcnY3maHqNpV0WbHXKkoONbosxVasrRJVDb2bTFLtzkFTU2WV" +
       "rjFyCmbYKFkZMkGi1FJ781Tp5AVQMiMDLWllLWldHkxemiFjZMPc5mWf6sve" +
       "5kvBnINeXTYl4zObpK1Sa56qWmtGtenSgkUWmIa2rV8zaItSoC2btCWcglWZ" +
       "JWUUNH133Mef3TAwnlEwUdJ1gzJ49nrFNrStSi5Dxnl32zVl0N5CLiepDBnt" +
       "y0xJc8attBUqbYVKXbReLmh9vaLnB9sMBoe6JaVNGRtEyezSQkzJkgZ5MV2s" +
       "zVBCLeXYmTKgnVVE66Asg3jLgtbdt10y/pEUGddNxql6FpsjQyMoVNINhCqD" +
       "vYplL8/llFw3maBDZ2cVS5U0dTvv6QZb7dclmofud2nBm3lTsVidHlfQj4DN" +
       "ysvUsIrw+phB8f9q+jSpH7BO9rA6CDvwPgCsU6FhVp8EdsdVRmxW9RwlM4Ma" +
       "RYzNqyEDqI4cVOiAUaxqhC7BDdLgmIgm6f2tWTA9vR+y1hhggBYl04SFItem" +
       "JG+W+pUetMhAvi4nCXKNYkSgCiWTgtlYSdBL0wK95OufD9aeed1l+rl6kiSg" +
       "zTlF1rD9o0GpMaC0XulTLAXGgaM4Zn7mVmnyD3YlCYHMkwKZnTzf+/rRry5s" +
       "PPick+e4CnnW9W5SZNoj7+0d++L0tnlnpLAZtaZhq9j5JcjZKOviKUsLJniY" +
       "ycUSMbHFTTy4/tmvfXOfciRJ6jpJWja0/CDY0QTZGDRVTbHOUXTFkqiS6ySj" +
       "FD3XxtI7yUj4nlF1xbm7rq/PVmgnGaGxW2mD/Q8U9UERSFEdfFf1PsP9bkp0" +
       "gH0vmISQkXCRv4DrFOL8sU9KNrQOGINKqyRLuqobrV2WgfjtVvA4vcDtQGsv" +
       "WP3mVtvIW2CCrYbV3yqBHQwoPEG2bRyZ4Ahb2VCzWtC8zLgKLiCiiUOJBJA9" +
       "PTjUNRgl5xpaTrF65N35Fe1HH+55wTEjNH3OBSVNUFeLU1cLq6sF6mpx6nL8" +
       "hUUSCVbFMVin05fQE5thTINTHTMve/GqS3c1pcCIzKERQCNmbSqZXNq8ge96" +
       "6x75QEP99tlvLno6SUZkSIMk07yk4Vyx3OoHLyRv5gN1TC9MO573n+Xz/jht" +
       "WYas5MD5iGYBXkqtsVWx8D4lx/hKcOcmHIWt4pmhYvvJwduHdm78xklJkix1" +
       "+FhlDfgqVO9CN110x83BgV6p3HFXv//xgVt3GN6QL5lB3ImvTBMxNAWNIEhP" +
       "jzx/lvRYzw92NDPaR4FLphIMIfB2jcE6SjzKUtc7I5ZaANxnWIOShkkux3V0" +
       "wDKGvDvMOiegmOQYKppQoIHMsZ+VNe/+xU9+ezJj0p0Dxvkm76xCl/r8DhbW" +
       "wDzMBM8iz7MUBfK9cXvXzbd8cPWFzBwhx5xKFTajbAN/A70DDF713JbX3npz" +
       "7ytJz4QpTLz5XohfCgzLMV/AXwKu/8ULfQXecHxGQxt3XLOKnsvEmo/32gY+" +
       "TIPhjsbRvEEHM1T7VKlXU3D8fD5u7qLHfnfdeKe7NbjjWsvC6gV4949dQb75" +
       "wiWfNLJiEjLOoR5/XjbHMU/0Sl5uWdI2bEdh50sz/uaQdDe4eHCrtrpdYZ6S" +
       "MD4I68AljIuTmDwlkHYairm238ZLh5Ev1umRb3jlw/qNHz55lLW2NFjy9/sa" +
       "yVzqWJHTC1DZUsJFiefG1MkmyikFaMOUoKM6V7IHoLBTDq69aLx28DOothuq" +
       "lcHV2uss8JCFElPiuWtGvv7Dpydf+mKKJDtInWZIuQ6JDTgyCixdsQfAuRbM" +
       "s7/qtGOoFsR4xgcpY6jsBvbCzMr92z5oUtYj2x+f8uiZ9+15k5ml6ZRxHNOv" +
       "Q39f4mFZXO4N8n0vn/az+268dciZ2eeJPVtAb+r/rNN6r3j7T2X9wnxahagj" +
       "oN/duv+uaW3LjjB9z7mgdnOhfI4CB+3pLt43+MdkU/qZJBnZTcbLPA7eKGl5" +
       "HNfdEPvZbnAMsXJJemkc5wQtS4vOc3rQsfmqDbo1b26E75gbv9cHbHAqduEZ" +
       "PIJwv5fYYAIcSEvYxArm40z1LWvABiFWZIWvYvJ4JuehWMi6O4VfTwSXZLPo" +
       "nEKTVV3SCsUGMZua4jakQoNgLbRiw9qVmfaetszybHbt8jXtTHkqJDArROJa" +
       "nADYcdUoT0ex2qnmTKGdryw2YyzeXQbXct6Ms8t4IezL+ZVxAmmjTMug0HtK" +
       "LoCu3i2uQrHQ/ZohszUJ+MRs3jQNi7r4TijrBnXR6XpLpkwhgPuCiLgb4erg" +
       "DewQ4O51cKPoLocn0qZkpA1xI4wjF9OcMNPKOnkDcOSIcKbBtZo3aLUAzuZQ" +
       "OCJtgCPnLQgsaGmciLFYNt9rQ0ynDsI8v5WvZBZ3XSrvau561/Flx1ZQcPJN" +
       "ur/1rzf+fNOPWRRRi1Hjee749cWEEF36opPxKFpwygjxkYH2tO5oeGvzXe8/" +
       "5LQn6BADmZVdu6/9ouW63c7s7qxV55QtF/06zno10LrZYbUwjY7/PLDjX+7f" +
       "cbXTqobSlVe7nh986NU//7jl9l8frrAESKl8vwFnqEQxhj+mlGoH0Mprxj1x" +
       "Q0OqA8LHTlKb19UteaUzV+o4R9r5Xh/33hrYc6YcGkZRlCTmw/QWsFctor2e" +
       "ANdfcovrEtjrzlB77RJoQ0iSM+T8ILBxrqTnNG8YzsRhOHSyzEafLcktK0vz" +
       "BSBd8SUgnc8btVEA6dpQSBsF2gDJVjDgMCwnpNkmhJQtzReA9FcRIc2D62Le" +
       "qIsEkG4OhXSRQJuykCHH1gcBTLOCmNoCGQOgdkcEdQ5cvbxZvQJQd4WCEmlT" +
       "MkaxLMMK2N30IKB2X6YAmLsjgpkDVz9vTr8AzL2hYETalNSbtpLPGbhRCoME" +
       "b2YDrf1OxNbOhkvj9WmC1u4Pba1Im5LR7qjfsL6zUlsfCmlrQRDg4NcTvciG" +
       "/aWJeDHji/mTbu/PD5v82wtU0XNKztm4cVVmV42BcJKZIdqGZBPM3it278mt" +
       "u3dRki/4ChCsUcM8UVO2KpqvnadhSSVrkzVs49UL9N8Ye9M7/9zcvyLKxg/e" +
       "a6yytYP/z4TJb754Kg825dAV/zXtvGUDl0bYw5kZYClY5ANr9h8+53j5piTb" +
       "ZXZWIGW706VKS0unzzpLoXlLL50w5xSNpgFtpAkumxuNHTR8z1CZ1T9aavV1" +
       "IaohC/znQtKeR/E0uOB+xXmQZG0E4+M7NVlvyPyo2vAOXzPjjRUmu/9UEdNo" +
       "TMOpcjvHtD06HSLVAGQ3NOKjarxvlwFHksJq+lm4Upnvbstm2wuyYqLZsQJe" +
       "Q/FTGF24oc3KZbpMtDisDFEyYquh5jxmX4yBWWZox8G1k9OzMzqzItUQY/pt" +
       "SNoRFO8CN/0uN3jjVY+H9+LiYSZc13Aw10TnQaQawJp0XL0zbEoe0RYXO2zD" +
       "zonFLxr97FP23//HI07MX2kpFXgodP99tfIvB5991/XhW0z0+3PF/tJX2Z7v" +
       "zPnJN/bM+Q3bO6tVbfDA4LArPL3y6Xy4/60jL9XPeJh5+hHoz5lDCz72K3+q" +
       "V/KwjjV1HN8AK92xcLZ6Ko61lSYPABKk8mTMWD4RRReroYWStKbo/c5zoq0o" +
       "PjcLwa5xGzHRa0SbZugKTqJumvOcRDVaio9K2QxbqZVPOQufz33Gw9oiHgOJ" +
       "+pC0cSjqKKmRsU0OhJDsDaIR4BssCS9y2VFgjf043MM1eW5xjWrbqt6/nm92" +
       "lfi5xGTMfxSiQvYkgfJ9sMCM8VFcMwZuId/EB+VN0cezSLUyNfjvtxjoOSG9" +
       "MRdFIyUN4PgrrCTfKLKSmBknK3dwaHdEZ0WkKmbleob8pBBWFqNY4LBSYTHq" +
       "Y2VhXKycBdc9HNo90VkRqYpZuZ0hPyuElbNRnA5uCFiptJz10XJGXLQsgWsf" +
       "x7YvOi0iVTEtf8egrwqhJYOinW1v0OCi2EdJR1yUnAzXIxzXI9EpEamGO9zj" +
       "giFlp27maZa5XMbK+eIo4/XS+QzmrM51pW76QhTrgVK2wszSbZqSHVAUGqA0" +
       "GxelC+D6hPPySXRKRapiK8sy2AMhnGH6RSzXJhRyVXJycZGDz3m+4Ai/iE6O" +
       "SFVITuICBjs/LHKGUJiUTPLIWQnLYXzmzpeGPoq2xEAR2yJaDC0f5ZTpfIZQ" +
       "VL4/JFQNcUJXDIudK1HsoGRGRXY6MSLWJS3A0uVxGdKJAPFYDvXYyIYkVK1m" +
       "SNcPi6obUVyLDweRqvV5Z9Xno6XqNvSXNZ7jobVNHFtTdOMRqYYYz13DYmQP" +
       "itsomVBkRGAwt8fAzFSXmYUc3sLoBiNSrWYwDwyLngdR7KVkrDO2eNRou3Nd" +
       "2R6MmwNPXXjc3RsDd7idQhYBpCWcgCXRrUqkGmJVjw+Ltu+j+EcK5ZXQ5jOt" +
       "xEMePY/GQA+eYcCHRAl+gsD5jGZaItVqpvXMsDg6hOIgLEcYR12Wwc45s1Mo" +
       "wngsoxRUWdI26KrPun4YA3340B6zJVZxDlZFty6Raoh1vTIs5l5F8e+UTCtn" +
       "zm9hhz2KfhoDRRMxbRbg44+pEmUPuapbmEi1moX9Zlg8vYPiV/i0zOFJNSyV" +
       "Og8zWTV8D9j2fR+iZGSvYWiKpFeKaHcUPE7fiIHTyZgGcXrC5MSY0c1OpBpi" +
       "dn8YFp1/RPHfbhTq0um3uPc8dn4fVyDRCNCu5BCvjM6OSFXMTpKEpCFHic9C" +
       "AqrP4+IBRx7fD0lU20qpwININQRryHZpErdLk7WUjGY8LKflTCRHxcVEM8B4" +
       "kMN5MDoTItUQtNNC0qajmOQuZDsH8UBcBTYmx8AGHpwjEAcmXuCQXojOhkg1" +
       "BPFXQtLwKUGyyY0f1yg5VSqGhjDBLwh7At+WzWaXt5XqMO7mxLlIeZsT8HZ0" +
       "7kSqIfycGpLGsC5ylyYdhk47JLmCj0kujosPWG0lPuWgPo3Oh0g1BHNbSFo7" +
       "imXF6Vzqr8TF2XFxMQcmxDlOmc5nJC6EqiF4u0LS1qNYXTKuKpCRiYuM2QRP" +
       "8juIyo7oVidDpBoC+OKQtB4UF1AypjgJZ4Mbh8mvxbUEBX+bVDkeNToVItUQ" +
       "uJtC0jAMSyquz/CvxreUrDmTfXGtOWE2Tm7joLZF50OkGoJ5KCQNH+EkLddn" +
       "FBfiW5zpZ6po+8LjyY6BpxmYdhKAfJiDfTg6TyLVEC6+FZK2C8VOSiY6PKmD" +
       "plbGVmMZW+XZGGdVj+d+2ZXRXEJSpzplOp+ROBOqBngJPsFI3hJC3G0oboBw" +
       "T7W7Amcyfcuh5I1xeeIzAE8nx9UZnRKRqpCSxHsM9j1izl5nGfaiuHt4jyyS" +
       "e+LawZkH0C7nEC+Pzo5ItRo7B0IM5h9Q7HPXB+0F01JsfsDPt2OTfDAuSiAA" +
       "SR3guA5Ep0SkKqbkMIP9RAglT6L4nruIPk+xBgNkPB4XGV8BZCc4ZTqfkcgQ" +
       "qgawetspifc8Rg6HMPICih+501ZHXpdpuYk8ExcrEPbX7HDKdD4jsSJUrWYi" +
       "r4YQ8gsUL1JSO6AUZEMzrAAXL8U15cBwqXmeA3o+OhciVTEXbIMz+U4IF2hD" +
       "yTfBOGRLkaji+5Vav0fIW3Ed35wOaI5wVEeiEyJSDcH7YUjaRyiOUFJnb1bN" +
       "rOkefPQFI7+LiwgIRmo+5mg+jk6ESDUE7J9D0r5A8Sc8xlQkYrmea1u5rm1l" +
       "W4CRT2NgBC90Hmn+lD8d/YCAULXKbJuqE9OSGoOihpK0nmev38E8IXv/NX2a" +
       "IZWdgsV/fTv/qXSMc3N6CmdhSnQCRarDmY5S00NYbEQxBSbonAqxbXm0kpoa" +
       "1yADH5xezGEtjs6ISDUE67yQtAUomikZoSsFWjqqUnPjogBm4/Q5HMc50SkQ" +
       "qYbADNmUTDGsiygZjxR09uuGpVRyu6nY9iTnA5YejqknOh0iVaGTcdaAqZCN" +
       "yRRuTKaWUTLaUnC3nx2XxHzeCicV27bkUsDSxzH1RadDpCp0Gc6P9z5luEM2" +
       "KFO4QZlaHcpJbLuTJwOgQQ5sMDonItXKJsL+d38ZGPg5UpezxPMdAk2F7GOm" +
       "JBQXhHIWxzbmLEw7DQBfxYFfFZ0zkWq1YaWF0IGTTKqfkilOnFvGJyZf4lEz" +
       "ECc13+b4vh2dGpHqsIbYthB+LkNBh81PPq4Tj5AtfScHeWcVfsrPgAhVq5lO" +
       "cDuz4qGFFG5spnYObx8qFcfGpfuryvRejnNvdIpEqtUounlYFN2C4jrxGYbU" +
       "9TEefUzv59j2R6dFpFqNlr8dFi33oLiz7OjjlpLnKKm7Yjy7l36MA3wsOjci" +
       "1WrcPDQsbg6guL/i2b0tpSuDB2I8eZZ+koN8Mjo/ItVq/Hx/WPw8geKx4Mmz" +
       "LSXPBFL/FNewwhXDIY7vUHRqRKrVqDk0LGoOo/hXSuq8J9duCFV+mrjS8Y/U" +
       "0/8fvBUoSTs/sMcXyE0te7uv80Za+eE942qn7Nnwc+d3t+5bY8dkSG1fXtP8" +
       "rzjzfU+bltKnMqbHMDmB/TY19TI/0So48IJvSiy+bCL1kqPzKiXHVNKhJAXS" +
       "n/M1WJQFc1JSwz79+X4F3Hv5oFLniz/LW1A6ZMGvv2Z8/bngxLnH+VnFziCT" +
       "qnVGUcX/Bkn8eTR777L7M+u88+blHvnAnlVrLzt66r3OGyxhot6+HUsZnSEj" +
       "nfdkskLx9RGzhaW5ZaXPnffZ2O+Omuv+SLvkDZr+tjGTwCOTaAvTAq90tJuL" +
       "b3Z8be+ZT/7brvRLSZK4kCQkSiZeWP62vIKZt8iMCzPl73zaKFnsXZNL592x" +
       "bdnCvt//kr2PEAdR6VsIg/l75Ffuu/jlm6bubUyS0Z2kRtVzSoG9xm/lNn29" +
       "Im+1ukm9arcXoIlQiippJS+UGptjAY+q9zNeOJ31xbv4alNKmsrfpVX+Qtg6" +
       "zRhSrBVGXs9hMfUZMtq74/RM4A0cedMMKHh3eFei/DqKlgL2BtheT2aNabrv" +
       "BR25xGQ2uKOS59nB7PUo+4rfPvo/JYWUUZNdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3/ZNzW1Ocb8MsUxvpsz5ZSl2qjGjNjW3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
