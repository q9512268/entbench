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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cDXAcxZXu3bVWsvwj2cY/+N+SANvYWgwYDkQAWbZsgWQL" +
       "r22CIMij3ZE09mhmNDNrr+0YYxcEwxGKMw7h19SB4XLG2DkuwN1xcA65iyGE" +
       "/1z4u4RALkU4QxW+uiA4SLj3unt2Zme3ZzXR1qlq3q6m+3X39/Xr1697eufw" +
       "J6TCMkmdIWlpqdHeZshWYyd+75RMS063qJJlrYO73alb3r9j19Abo3dHSbyL" +
       "jO+XrI6UZMmtiqymrS4yS9EsW9JSsrValtOo0WnKlmxukWxF17rIZMVqGzBU" +
       "JaXYHXpaxgwbJLOdTJBs21R6MrbcxguwyZx22poEbU2i2Z+hqZ2MTenGNldh" +
       "ep5CiycN8w649Vk2qW3fJG2REhlbURPtimU3ZU1ypqGr2/pU3W6Us3bjJnUp" +
       "J+Ky9qUFNNT9sOazL2/vr6U0TJI0TbcpRGutbOnqFjndTmrcuytUecAaJNeR" +
       "WDsZ48lsk4Z2p9IEVJqASh28bi5o/ThZywy06BSO7ZQUN1LYIJvMyy/EkExp" +
       "gBfTSdsMJVTZHDtVBrRzc2id7vZB/N6Zif3fv7b28Rip6SI1ipbE5qSgETZU" +
       "0gWEygM9smk1p9NyuotM0KDDk7KpSKqynff2REvp0yQ7Aybg0II3M4Zs0jpd" +
       "rqAnAZuZSdm6mYPXS42K/1fRq0p9gHWKi5UhbMX7ALBagYaZvRLYHlcZtVnR" +
       "0tSO8jVyGBsuhwygWjkg2/16rqpRmgQ3yERmIqqk9SWSYHxaH2St0MEETWpr" +
       "gkKRa0NKbZb65G6bTPPn62RJkGs0JQJVbDLZn42WBL003ddLnv75ZPVFt+3Q" +
       "VmlREoE2p+WUiu0fA0qzfUpr5V7ZlGEcMMWxC9vvlKY8szdKCGSe7MvM8jz1" +
       "7ZOXLpp97HmWZ0aRPGt6Nskpuzt1sGf8azNbFlwQw2ZUGbqlYOfnIaejrJOn" +
       "NGUN8DRTciViYqOTeGztT6+6/pB8Ikqq20g8pauZAbCjCSl9wFBU2Vwpa7Ip" +
       "2XK6jYyWtXQLTW8jlfC9XdFkdndNb68l221klEpvxXX6P1DUC0UgRdXwXdF6" +
       "dee7Idn99HvWIIRUwkUuhOtcwv7op01SiX59QE5IKUlTND3RaeqIHzuU+hzZ" +
       "gu9pSDX0RA/Y/+bFSxrPT1h6xgSDTOhmX0ICq+iXWWIiZVk4TsE1JujAMxvR" +
       "2Iz/n2qyiHbS1kgEOmKm3w2oMIJW6WpaNrtT+zPLVpw80v0iMzEcFpwnm9RB" +
       "XY2srkZaVyPU1cjqYr7EJJEIreIUrJP1M/TSZhjv4HDHLkh+67KNe+tiYGDG" +
       "1lFAMWY9vWACanEdg+PNu1OHX1s79MpL1YeiJAq+owcmIHcWaMibBdgkZuop" +
       "OQ1uSDQfOD4xIZ4BiraDHLtr6+4Nu86i7fA6diywAnwSqneiO85V0eAf0MXK" +
       "rbnp958dvXOn7g7tvJnCmeAKNNFj1Pk71A++O7VwrvRE9zM7G6JkFLghcL22" +
       "BEMFvNpsfx15nqPJ8cKIpQoA9+rmgKRikuM6q+1+U9/q3qGWNgHFZGZ0aA6+" +
       "BlIH/o2kcf9bL390DmXS8fU1nkk6KdtNHv+ChU2knmSCa13rTFmGfL+6q/OO" +
       "731y09XUtCBHfbEKG1C2gF+B3gEGb3x+8O33fn3wF1HXHG2YYDM9EKtkKZZT" +
       "voa/CFx/wgt9At5gvmFiC3dQc3MeysCaT3fbBr5KhYGMxtGwXgPjU3oVqUeV" +
       "cSx8VXPakic+vq2WdbcKdxxrWVS6APf+qcvI9S9eOzSbFhNJ4Vzp8udmYw54" +
       "kltys2lK27Ad2d2vz7r7uHQ/uHJwn5ayXaYekVA+CO3AcykXCSrP8aWdh6LB" +
       "8tp4/jDyxDTdqdt/8em4DZ8+e5K2Nj8o8vZ7h2Q0MStivQCVNREu8jw0pk4x" +
       "UE7NQhum+p3OKsnqh8LOPbb6mlr12JdQbRdUmwK3aa0xwdtl80yJ566ofOfH" +
       "P5my8bUYibaSalWX0q0SHXBkNFi6bPWDo8wal1zK2rG1CkQt5YMUMISkzyne" +
       "nSsGDJt2wPZ/mPqji/7mwK+pFTKzm0HVqy0M2Py+kUbd7rD++N17f/svQw9V" +
       "sjl7gdiX+fSm/e8atWfPB58X9AT1YkXiCZ9+V+LwfdNbLj5B9V13gtr12cIZ" +
       "Bhyuq3v2oYE/ROvi/xYllV2kNsUj3A2SmsGR3AVRneWEvRAF56XnR2gsHGnK" +
       "ucuZflfmqdbvyNyZDb5jbvw+zmd107AXL+CxgfM9z+oi4DIag6ZFMBg2UTd2" +
       "gNVBFEgLX0XlaVTOR3Em7fIYfl0ETsiicbcNTVY0Sc3mGkTNaqrTkCINglXO" +
       "svWrl7ev6G5pb04mVzd3rKDK0yCBGiIS18hCW+acUZ6Poo1V0yS07GW5ZozH" +
       "uxfD1cybcUkBL4R+WV8cJ5A22jB1G3pPTvvQjXOKK1IsdL+qp+hqA7xgMmMY" +
       "umk7+OYXdIOy5C+0xvYCBR/uDSFxz4arlTewVYB7I8ON4puF8ETaNqm0IAaE" +
       "ceRgqg8yrSTL64MjhYQzHa7LeYMuF8BRAuGItAFOKmNCKGHT+cHjyXAfIJnp" +
       "sexOUxmAuX0LX6UcnTI0+K+V25c7K5BiKizn5VbHK/+06sNuGjtUYTS4zhnD" +
       "njiv2ezzxCS1KBbjRBHgJ30tSuyc+N7m+37/GGuR3yn6Mst799/ydeNt+9mc" +
       "zlai9QWLQa8OW436WjcvqBaq0frh0Z1P/2DnTaxVE/PXVSu0zMBjv/zjzxvv" +
       "+s0LRYL4mMJ3E3CiiuSi8Cl+shmk+JL7v9j1nbfWQNjYRqoymjKYkdvS+e6z" +
       "0sr0eNh317iuS+XgMHqySWShYWR9VrsppNXOh+sKbnedAqvdFWi1nQJtCEXS" +
       "eiozAGa7CihR3cE4Bwfj1nNSdAxaUqpxeX4+H6Tr/wxIV/JGbRBA2hsIaYNA" +
       "GyBZMkYeuslCmW1CSMn8fD5IN4eEtACub/FGXSOA9FeBkK4RaNs0cEjTdYEP" +
       "01w/phZfRh+ofSFBrYSrhzerRwDqnkBQIm2bjJVNUzd9djfTD2iFJ5MPzL0h" +
       "wdTD1ceb0ycA81AgGJG2TcYZlpxJ67gRCoMEb17ha+3BkK2dB5fK61MFrT0U" +
       "2FqRtk3GOKN+/dq2Ym19NKCtWUGYg18XufEN/YsT8SLGE/1Hnd5fGBQCrMja" +
       "spaW02zzxVGZVzISwmlmlmibkU4xB/fsP5Be8/CSKF/obYGQzdaNxaq8RVY9" +
       "7TyfTlj+VUoH3Vx1Q/7zXx+Kvbtv2tjCzRssabZga2aheJr2V3B8z39NX3dx" +
       "/8YQuzJzfPj9Rf5tx+EXVp6e2hel+8NshVGwr5yv1JQ/MVabsp0xtfypsC5n" +
       "DhOx9+vgsrg5WH6Tdk2Q2vPj+fZcHaAasGT/aUDa8yh+DM61T7aZTW0As+J7" +
       "L1e4g+G5UgM3bxWMNy6lt5/JIRiDSTjlbecItocHL1L1AXSCHD46aj27BDgi" +
       "ZFrT68FKBT64JZlckU3JBhoZLeCXKF6CUYIbz7RcqjuIYjGjK2OTUVt0Je3y" +
       "+PKIeaRGNAOu3ZyM3eF5FKkGGMrvAtI+RPEbYKLPYQJvvOGifr88qOfAdTNv" +
       "+s3hUYtUfciizB2zAeDbkcktSuh2GouY/3HSR3//wsbKt1lsXnzZ43s488GO" +
       "Fx/U/+NE1PG1uoH++TSx9/NUd+CR+pd3Hah/n+5tVSkW+E9Y9RR5iuTR+fTw" +
       "eydeHzfrCN0LHoXemLon/+O3wqdreQ/NaFNr+JZV/v4C25gpOpaWGc5E/WXx" +
       "SZMyvQjFalrDYpvEVVnrY89raBgxxCv1dI/TiEluI1pUXZNxsnPS2DMJRW/M" +
       "PbKkM2GxVj7DFihDHgOibRFbfaQqIK0aRYVNKlLYJgYhIPs4ZvOewRBx44kd" +
       "Wdq0k8H+qs51ch2KZSla31q+EZXntSJ0YfYxxGp0X9/me1Q+b/9Jebw9bt/u" +
       "44NuX/jxKlItTgT+ewOFODOA6dkocFsJnHaR1dw7OQ4i08rHwT0cyD3hORCp" +
       "ijn4LsU5P4CDhSjqGQdFln8eDhrKw8E34HqQA3kwPAciVTEHd1KcAY8xIvgY" +
       "I5IA9wEcFFsuekg4qzwkLIXrEEdyKDwJIlUxCQ9QoJcGkLAMRRPdLLD9S0wP" +
       "AReVhwDM9ThH8Xh4AkSqwW5xhj+Ma9OMjJ2kjpFy0C6e/d/Mn2NgHmlbk+9M" +
       "O1GsBALp6ixpb1PlZL8s2z4CV5WHwDPhGuIsDIUnUKQqtqArKMhrAhjCdJbr" +
       "WhRXlqTim+WhAp+CfM3xfB2eCpGqkIpIBwXZPywqNqFI2WSyS8VyWEziM2i+" +
       "sPIQkh4xIXSj5Gxo52hWAvsMIKRwl0SoGuA87GFxsQWFbpNZRblow3hTk1Qf" +
       "J0Z5jGQxADqVAzs1tJEIVUsZyfXDImYPih34WAyJWZthayYPCd8uj2GcDm2r" +
       "40jqwhuGSDXAMG4dFv7bUNxkkwk5/AJj2DtiHqY5PCziYBaFNwaRailjuGtY" +
       "ZNyD4g6bjGejhMdkljP/FOxFODnwOIHL1P4RM4XbCmQJAFjK4S4NbzEi1QCL" +
       "eWRYJP0AxV/b+ODKS5LHbCL3uWQ8OGIy8Kk7PtCI8Gfe7DOc2YhUS5nN48Ni" +
       "5EcoHoNAnjLSaer0zC09NyGMf9rlrJKS1PWa4rGcIyMmCx8q4+525DKO+LLw" +
       "liNSDbCcY8Pi6TkUT9tkeiFPXut50iXkn0dMyCRMmgto+OOSSMHDltLWI1It" +
       "ZT0/HxYrL6M4jk9tGCuKbio2e6hGgxS+h+nbz6zs0XVVlrRi8eKOrMvg8yNm" +
       "cAomQcwbMTgNRniTEqkGmNSvhkXeeyjecmI8hzyvNb3qcvF2eaby2QDkBg7o" +
       "hvBciFQDuPgoIO0Eiv8MCGB+Vx7UOIb4DkCk1OZBEdQi1QBkfwhIG0LxqU3G" +
       "UNTNdhHcJ8uDuwEa/Shv/KPhcYtUxdiikYA0PKgW+cpZ3rUN4LGqItj/OGLs" +
       "eNiKQJQVeZEDeDE8dpFqAL5xAWk1KKqc6KxDTitSLvCCKfbMoOe1Lclksrkl" +
       "XweZio4uX3j/AYf7QXimRKoBbMwISJuFYooT1Lfqmt0qpYr4hujU8qCHVUnk" +
       "Cw7hi/DoRaoBCM8ISFuAoi43oUp9xZDXlwd5PUxJ9awE9hkKuVA1AN05AWlL" +
       "UTTmjZAi0BPlgT6P4Dlt1v6C45iloYtUA+BdEpDWjOJCm4zNTYNJ/6ZXtKk8" +
       "CzPwilGFt14JD1ykGgDu8oC0DhStzlj3rkgH81Zi0ZXlWYnBfBjdxiFsC49e" +
       "pBqA8MqAtKtQrHXGem4xOsimhGmiBbvLSnLErMzCpLMA0hEO7Uh4VkSqAcjl" +
       "gDQ8YR7daJNJjBVlwFALuJldwE1hNspQyXPNw1tBnEZI7DxWAvsMxZBQ1ceC" +
       "f9c8agXQlEGhQTClWJ2+E3OeZUNUL4+/vABa38ZRtIUnQKQqJCDyKgW5S8zQ" +
       "mzTDbhTbh7dNHt1Rnh2KBQDkOg7ouvBciFRLcfGXAcbwXRTfcSLrFVnDlC1+" +
       "AMuzIxG9qTwEwIQfO8pRHA1PgEhVTMCTFOT3Awi4G8U+ZyG5TjYHfNDvKA/0" +
       "MwDHfFYC+wwFXajqQ+ZuF0RedfE/FID/YRQHnKmkNaOl7MLuf6A8HEDAXLGT" +
       "lcA+Q3EgVC3V/UcD4P8dikM2qeqXsyld1U0f8qBjuCGmATD8ip/x5v8sPHKR" +
       "qhg53YqLPh2A/BkUT0LHp0xZsmXPr3tkF/5T5Tk6NxPafoJjOBEevkg1AN3x" +
       "gLQXUDxnk2prs2IkDefAmeHC/kl5YMPkX/EZb/tn4WGLVAOgvRGQ9u8oXsZD" +
       "JznYzVq6ZfmaluUtPvyvjBg/PX8Ogz7On+3Gwz8WFqqWmu/eCyDhfRTv2CSu" +
       "ZeirRTBPwH5zRa+qSwUnC/Ffz25z9N2yzY7xqRzz1PB0iVSHNUV8GsDZf6M4" +
       "AVNkWoE4sUh08HF5hgt4yvjZHMTZ4fGLVAOQfRWQ9icUQzYZpclZ2zc+Pi8P" +
       "YJgP4yt5q1eGByxSFYOKBZwajeGp0VjMJrUIuK1P0025mHOMjSrPwmAhtLyb" +
       "I+gOD16kKnQObGUUOyWAgSkoamwyxpRxh5keSsN87kogVlse8E3Q8l6OoDc8" +
       "eJGqcKiznxf9D0U5N4CBOhQzAhmYWR4GIFd8gMMYCM+ASLV499P/nV8q+X5W" +
       "0ckWPp6DdbFFAQydheKMQIbmj5ihuZh0PsC7kcO8MTxDItVSA+TCAPAXoVhq" +
       "k6ksZixgD5MXu0ScVz4ibuVobg1PhEh1WIOlNYCNVSiah83GsvKcKzsXoNzL" +
       "Id1bgo3Cp/pC1VJmsVZMl/tgOrYORcfwdlViq8v2q674QY7qYHhCRKqlCLl2" +
       "WIRsRHGV+Dl1rKtsB8zihzmSw+FJEKmWImHTsEjAEwkxueCA2WDeTn2st2xn" +
       "puJPcDhPhGdCpFqKiS3DYoKKwaJnpgbzYuqYWbYzQPFnOaRnw7MhUi3Fxp5h" +
       "sXEDip3+M0CDefvQsevKM0Aw1j7O0RwPT4RItRQRtw2LiNtR3GyTavcJphOy" +
       "FJ6+LPZAP3ZLeJaysApmP7rF90ZNK3hXJ3u/ZOrIgZqqqQfWv8l+vee8A3Js" +
       "O6nqzaiq97VGnu9xw5R7FcrrWCon0F+4xe7mZwIFBxbwfWi5n5bH7mI699nk" +
       "lGI6NomB9OZ8ABYv/pywhqef3nwPAtNuPqiUffFmeRhKhyz49RFK1+dZFkXO" +
       "4BzmqCeTS1GfU/G+Jw5/ZEnfour8WDPD3qPanTp64LLVO06e9zB7Tx1Mntu3" +
       "Yylj2kklexseLRR/Uj5PWJpTVnzVgi/H/3D0ac5PPfPek+dtG7UIPKqGtjDd" +
       "9+I2qyH3/ra3D1707Et7469HSeRqEpFsMunqwjdkZY2MSeZc3V7sHS8bJJO+" +
       "U66p+rcbX/n8nchE+iIyHDQWvvAmQKM7dcez73b2GsY9UTK6jVQoWlrO0td3" +
       "Ld+mrZVTW8y8V8bEe/SMlvtx6fg0DUMUrY8ywwkdl7uLrzC0SV3h23MKX+tY" +
       "repbZXMZlo7FjPP9CD9jGN5UyiztwMVZZBrsqru9wzD4m/1i9BWhlxoGGlns" +
       "Kfxnx/8B/s24/CpZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ll0FB+5/A9NlZYX1aas2r3jGsqaajT6d");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
