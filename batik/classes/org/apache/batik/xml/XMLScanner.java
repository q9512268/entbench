package org.apache.batik.xml;
public class XMLScanner implements org.apache.batik.i18n.Localizable {
    public static final int DOCUMENT_START_CONTEXT = 0;
    public static final int TOP_LEVEL_CONTEXT = 1;
    public static final int PI_CONTEXT = 2;
    public static final int XML_DECL_CONTEXT = 3;
    public static final int DOCTYPE_CONTEXT = 4;
    public static final int START_TAG_CONTEXT = 5;
    public static final int CONTENT_CONTEXT = 6;
    public static final int DTD_DECLARATIONS_CONTEXT = 7;
    public static final int CDATA_SECTION_CONTEXT = 8;
    public static final int END_TAG_CONTEXT = 9;
    public static final int ATTRIBUTE_VALUE_CONTEXT = 10;
    public static final int ATTLIST_CONTEXT = 11;
    public static final int ELEMENT_DECLARATION_CONTEXT = 12;
    public static final int ENTITY_CONTEXT = 13;
    public static final int NOTATION_CONTEXT = 14;
    public static final int NOTATION_TYPE_CONTEXT = 15;
    public static final int ENUMERATION_CONTEXT = 16;
    public static final int ENTITY_VALUE_CONTEXT = 17;
    protected static final java.lang.String BUNDLE_CLASSNAME = "org.apache.batik.xml.resources.Messages";
    protected org.apache.batik.i18n.LocalizableSupport localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      BUNDLE_CLASSNAME,
      org.apache.batik.xml.XMLScanner.class.
        getClassLoader(
          ));
    protected org.apache.batik.util.io.NormalizingReader reader;
    protected int current;
    protected int type;
    protected char[] buffer = new char[1024];
    protected int position;
    protected int start;
    protected int end;
    protected int context;
    protected int depth;
    protected boolean piEndRead;
    protected boolean inDTD;
    protected char attrDelimiter;
    protected boolean cdataEndRead;
    public XMLScanner(java.io.Reader r) throws org.apache.batik.xml.XMLException {
        super(
          );
        context =
          DOCUMENT_START_CONTEXT;
        try {
            reader =
              new org.apache.batik.util.io.StreamNormalizingReader(
                r);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.xml.XMLException(
              e);
        }
    }
    public XMLScanner(java.io.InputStream is, java.lang.String enc)
          throws org.apache.batik.xml.XMLException { super();
                                                     context = DOCUMENT_START_CONTEXT;
                                                     try { reader =
                                                             new org.apache.batik.util.io.StreamNormalizingReader(
                                                               is,
                                                               enc);
                                                           current =
                                                             nextChar(
                                                               );
                                                     }
                                                     catch (java.io.IOException e) {
                                                         throw new org.apache.batik.xml.XMLException(
                                                           e);
                                                     }
    }
    public XMLScanner(java.lang.String s)
          throws org.apache.batik.xml.XMLException {
        super(
          );
        context =
          DOCUMENT_START_CONTEXT;
        try {
            reader =
              new org.apache.batik.util.io.StringNormalizingReader(
                s);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.xml.XMLException(
              e);
        }
    }
    public void setLocale(java.util.Locale l) {
        localizableSupport.
          setLocale(
            l);
    }
    public java.util.Locale getLocale() {
        return localizableSupport.
          getLocale(
            );
    }
    public java.lang.String formatMessage(java.lang.String key,
                                          java.lang.Object[] args)
          throws java.util.MissingResourceException {
        return localizableSupport.
          formatMessage(
            key,
            args);
    }
    public void setDepth(int i) { depth =
                                    i; }
    public int getDepth() { return depth;
    }
    public void setContext(int c) { context =
                                      c; }
    public int getContext() { return context;
    }
    public int getType() { return type; }
    public int getLine() { return reader.
                             getLine(
                               ); }
    public int getColumn() { return reader.
                               getColumn(
                                 ); }
    public char[] getBuffer() { return buffer;
    }
    public int getStart() { return start;
    }
    public int getEnd() { return end; }
    public char getStringDelimiter() { return attrDelimiter;
    }
    public int getStartOffset() { switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             SECTION_END:
                                          return -3;
                                      case org.apache.batik.xml.LexicalUnits.
                                             PI_END:
                                          return -2;
                                      case org.apache.batik.xml.LexicalUnits.
                                             STRING:
                                      case org.apache.batik.xml.LexicalUnits.
                                             ENTITY_REFERENCE:
                                      case org.apache.batik.xml.LexicalUnits.
                                             PARAMETER_ENTITY_REFERENCE:
                                      case org.apache.batik.xml.LexicalUnits.
                                             START_TAG:
                                      case org.apache.batik.xml.LexicalUnits.
                                             FIRST_ATTRIBUTE_FRAGMENT:
                                          return 1;
                                      case org.apache.batik.xml.LexicalUnits.
                                             PI_START:
                                      case org.apache.batik.xml.LexicalUnits.
                                             END_TAG:
                                      case org.apache.batik.xml.LexicalUnits.
                                             CHARACTER_REFERENCE:
                                          return 2;
                                      case org.apache.batik.xml.LexicalUnits.
                                             COMMENT:
                                          return 4;
                                      default:
                                          return 0;
                                  } }
    public int getEndOffset() { switch (type) {
                                    case org.apache.batik.xml.LexicalUnits.
                                           STRING:
                                    case org.apache.batik.xml.LexicalUnits.
                                           ENTITY_REFERENCE:
                                    case org.apache.batik.xml.LexicalUnits.
                                           CHARACTER_REFERENCE:
                                    case org.apache.batik.xml.LexicalUnits.
                                           PARAMETER_ENTITY_REFERENCE:
                                    case org.apache.batik.xml.LexicalUnits.
                                           LAST_ATTRIBUTE_FRAGMENT:
                                        return -1;
                                    case org.apache.batik.xml.LexicalUnits.
                                           PI_DATA:
                                        return -2;
                                    case org.apache.batik.xml.LexicalUnits.
                                           COMMENT:
                                        return -3;
                                    case org.apache.batik.xml.LexicalUnits.
                                           CHARACTER_DATA:
                                        if (cdataEndRead) {
                                            return -3;
                                        }
                                        return 0;
                                    default:
                                        return 0;
                                } }
    public void clearBuffer() { if (position <=
                                      0) {
                                    position =
                                      0;
                                }
                                else {
                                    buffer[0] =
                                      buffer[position -
                                               1];
                                    position =
                                      1;
                                } }
    public int next() throws org.apache.batik.xml.XMLException {
        return next(
                 context);
    }
    public int next(int ctx) throws org.apache.batik.xml.XMLException {
        start =
          position -
            1;
        try {
            switch (ctx) {
                case DOCUMENT_START_CONTEXT:
                    type =
                      nextInDocumentStart(
                        );
                    break;
                case TOP_LEVEL_CONTEXT:
                    type =
                      nextInTopLevel(
                        );
                    break;
                case PI_CONTEXT:
                    type =
                      nextInPI(
                        );
                    break;
                case START_TAG_CONTEXT:
                    type =
                      nextInStartTag(
                        );
                    break;
                case ATTRIBUTE_VALUE_CONTEXT:
                    type =
                      nextInAttributeValue(
                        );
                    break;
                case CONTENT_CONTEXT:
                    type =
                      nextInContent(
                        );
                    break;
                case END_TAG_CONTEXT:
                    type =
                      nextInEndTag(
                        );
                    break;
                case CDATA_SECTION_CONTEXT:
                    type =
                      nextInCDATASection(
                        );
                    break;
                case XML_DECL_CONTEXT:
                    type =
                      nextInXMLDecl(
                        );
                    break;
                case DOCTYPE_CONTEXT:
                    type =
                      nextInDoctype(
                        );
                    break;
                case DTD_DECLARATIONS_CONTEXT:
                    type =
                      nextInDTDDeclarations(
                        );
                    break;
                case ELEMENT_DECLARATION_CONTEXT:
                    type =
                      nextInElementDeclaration(
                        );
                    break;
                case ATTLIST_CONTEXT:
                    type =
                      nextInAttList(
                        );
                    break;
                case NOTATION_CONTEXT:
                    type =
                      nextInNotation(
                        );
                    break;
                case ENTITY_CONTEXT:
                    type =
                      nextInEntity(
                        );
                    break;
                case ENTITY_VALUE_CONTEXT:
                    return nextInEntityValue(
                             );
                case NOTATION_TYPE_CONTEXT:
                    return nextInNotationType(
                             );
                case ENUMERATION_CONTEXT:
                    return nextInEnumeration(
                             );
                default:
                    throw new java.lang.IllegalArgumentException(
                      "unexpected ctx:" +
                      ctx);
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.xml.XMLException(
              e);
        }
        end =
          position -
            (current ==
               -1
               ? 0
               : 1);
        return type;
    }
    protected int nextInDocumentStart() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                context =
                  depth ==
                    0
                    ? TOP_LEVEL_CONTEXT
                    : CONTENT_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '<':
                switch (nextChar(
                          )) {
                    case '?':
                        int c1 =
                          nextChar(
                            );
                        if (c1 ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameFirstCharacter(
                                (char)
                                  c1)) {
                            throw createXMLException(
                                    "invalid.pi.target");
                        }
                        context =
                          PI_CONTEXT;
                        int c2 =
                          nextChar(
                            );
                        if (c2 ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  c2)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     PI_START;
                        }
                        int c3 =
                          nextChar(
                            );
                        if (c3 ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  c3)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     PI_START;
                        }
                        int c4 =
                          nextChar(
                            );
                        if (c4 !=
                              -1 &&
                              org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  c4)) {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     PI_START;
                        }
                        if (c1 ==
                              'x' &&
                              c2 ==
                              'm' &&
                              c3 ==
                              'l') {
                            context =
                              XML_DECL_CONTEXT;
                            return org.apache.batik.xml.LexicalUnits.
                                     XML_DECL_START;
                        }
                        if ((c1 ==
                               'x' ||
                               c1 ==
                               'X') &&
                              (c2 ==
                                 'm' ||
                                 c2 ==
                                 'M') &&
                              (c3 ==
                                 'l' ||
                                 c3 ==
                                 'L')) {
                            throw createXMLException(
                                    "xml.reserved");
                        }
                        return org.apache.batik.xml.LexicalUnits.
                                 PI_START;
                    case '!':
                        switch (nextChar(
                                  )) {
                            case '-':
                                return readComment(
                                         );
                            case 'D':
                                context =
                                  DOCTYPE_CONTEXT;
                                return readIdentifier(
                                         "OCTYPE",
                                         org.apache.batik.xml.LexicalUnits.
                                           DOCTYPE_START,
                                         -1);
                            default:
                                throw createXMLException(
                                        "invalid.doctype");
                        }
                    default:
                        context =
                          START_TAG_CONTEXT;
                        depth++;
                        return readName(
                                 org.apache.batik.xml.LexicalUnits.
                                   START_TAG);
                }
            case -1:
                return org.apache.batik.xml.LexicalUnits.
                         EOF;
            default:
                if (depth ==
                      0) {
                    throw createXMLException(
                            "invalid.character");
                }
                else {
                    return nextInContent(
                             );
                }
        }
    }
    protected int nextInTopLevel() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '<':
                switch (nextChar(
                          )) {
                    case '?':
                        context =
                          PI_CONTEXT;
                        return readPIStart(
                                 );
                    case '!':
                        switch (nextChar(
                                  )) {
                            case '-':
                                return readComment(
                                         );
                            case 'D':
                                context =
                                  DOCTYPE_CONTEXT;
                                return readIdentifier(
                                         "OCTYPE",
                                         org.apache.batik.xml.LexicalUnits.
                                           DOCTYPE_START,
                                         -1);
                            default:
                                throw createXMLException(
                                        "invalid.character");
                        }
                    default:
                        context =
                          START_TAG_CONTEXT;
                        depth++;
                        return readName(
                                 org.apache.batik.xml.LexicalUnits.
                                   START_TAG);
                }
            case -1:
                return org.apache.batik.xml.LexicalUnits.
                         EOF;
            default:
                throw createXMLException(
                        "invalid.character");
        }
    }
    protected int nextInPI() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (piEndRead) {
            piEndRead =
              false;
            context =
              depth ==
                0
                ? TOP_LEVEL_CONTEXT
                : CONTENT_CONTEXT;
            return org.apache.batik.xml.LexicalUnits.
                     PI_END;
        }
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '?':
                if (nextChar(
                      ) !=
                      '>') {
                    throw createXMLException(
                            "pi.end.expected");
                }
                nextChar(
                  );
                if (inDTD) {
                    context =
                      DTD_DECLARATIONS_CONTEXT;
                }
                else
                    if (depth ==
                          0) {
                        context =
                          TOP_LEVEL_CONTEXT;
                    }
                    else {
                        context =
                          CONTENT_CONTEXT;
                    }
                return org.apache.batik.xml.LexicalUnits.
                         PI_END;
            default:
                do  {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '?'); 
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         current !=
                         '>'); 
                nextChar(
                  );
                piEndRead =
                  true;
                return org.apache.batik.xml.LexicalUnits.
                         PI_DATA;
        }
    }
    protected int nextInStartTag() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '/':
                if (nextChar(
                      ) !=
                      '>') {
                    throw createXMLException(
                            "malformed.tag.end");
                }
                nextChar(
                  );
                context =
                  --depth ==
                    0
                    ? TOP_LEVEL_CONTEXT
                    : CONTENT_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         EMPTY_ELEMENT_END;
            case '>':
                nextChar(
                  );
                context =
                  CONTENT_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case '=':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         EQ;
            case '\"':
                attrDelimiter =
                  '\"';
                nextChar(
                  );
                for (;
                     ;
                     ) {
                    switch (current) {
                        case '\"':
                            nextChar(
                              );
                            return org.apache.batik.xml.LexicalUnits.
                                     STRING;
                        case '&':
                            context =
                              ATTRIBUTE_VALUE_CONTEXT;
                            return org.apache.batik.xml.LexicalUnits.
                                     FIRST_ATTRIBUTE_FRAGMENT;
                        case '<':
                            throw createXMLException(
                                    "invalid.character");
                        case -1:
                            throw createXMLException(
                                    "unexpected.eof");
                    }
                    nextChar(
                      );
                }
            case '\'':
                attrDelimiter =
                  '\'';
                nextChar(
                  );
                for (;
                     ;
                     ) {
                    switch (current) {
                        case '\'':
                            nextChar(
                              );
                            return org.apache.batik.xml.LexicalUnits.
                                     STRING;
                        case '&':
                            context =
                              ATTRIBUTE_VALUE_CONTEXT;
                            return org.apache.batik.xml.LexicalUnits.
                                     FIRST_ATTRIBUTE_FRAGMENT;
                        case '<':
                            throw createXMLException(
                                    "invalid.character");
                        case -1:
                            throw createXMLException(
                                    "unexpected.eof");
                    }
                    nextChar(
                      );
                }
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInAttributeValue() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (current ==
              -1) {
            return org.apache.batik.xml.LexicalUnits.
                     EOF;
        }
        if (current ==
              '&') {
            return readReference(
                     );
        }
        else {
            loop: for (;
                       ;
                       ) {
                switch (current) {
                    case '&':
                    case '<':
                    case -1:
                        break loop;
                    case '\"':
                    case '\'':
                        if (current ==
                              attrDelimiter) {
                            break loop;
                        }
                }
                nextChar(
                  );
            }
            switch (current) {
                case -1:
                    break;
                case '<':
                    throw createXMLException(
                            "invalid.character");
                case '&':
                    return org.apache.batik.xml.LexicalUnits.
                             ATTRIBUTE_FRAGMENT;
                case '\'':
                case '\"':
                    nextChar(
                      );
                    if (inDTD) {
                        context =
                          ATTLIST_CONTEXT;
                    }
                    else {
                        context =
                          START_TAG_CONTEXT;
                    }
            }
            return org.apache.batik.xml.LexicalUnits.
                     LAST_ATTRIBUTE_FRAGMENT;
        }
    }
    protected int nextInContent() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case -1:
                return org.apache.batik.xml.LexicalUnits.
                         EOF;
            case '&':
                return readReference(
                         );
            case '<':
                switch (nextChar(
                          )) {
                    case '?':
                        context =
                          PI_CONTEXT;
                        return readPIStart(
                                 );
                    case '!':
                        switch (nextChar(
                                  )) {
                            case '-':
                                return readComment(
                                         );
                            case '[':
                                context =
                                  CDATA_SECTION_CONTEXT;
                                return readIdentifier(
                                         "CDATA[",
                                         org.apache.batik.xml.LexicalUnits.
                                           CDATA_START,
                                         -1);
                            default:
                                throw createXMLException(
                                        "invalid.character");
                        }
                    case '/':
                        nextChar(
                          );
                        context =
                          END_TAG_CONTEXT;
                        return readName(
                                 org.apache.batik.xml.LexicalUnits.
                                   END_TAG);
                    default:
                        depth++;
                        context =
                          START_TAG_CONTEXT;
                        return readName(
                                 org.apache.batik.xml.LexicalUnits.
                                   START_TAG);
                }
            default:
                loop: for (;
                           ;
                           ) {
                    switch (current) {
                        default:
                            nextChar(
                              );
                            break;
                        case -1:
                        case '&':
                        case '<':
                            break loop;
                    }
                }
                return org.apache.batik.xml.LexicalUnits.
                         CHARACTER_DATA;
        }
    }
    protected int nextInEndTag() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                if (--depth <
                      0) {
                    throw createXMLException(
                            "unexpected.end.tag");
                }
                else
                    if (depth ==
                          0) {
                        context =
                          TOP_LEVEL_CONTEXT;
                    }
                    else {
                        context =
                          CONTENT_CONTEXT;
                    }
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            default:
                throw createXMLException(
                        "invalid.character");
        }
    }
    protected int nextInCDATASection() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (cdataEndRead) {
            cdataEndRead =
              false;
            context =
              CONTENT_CONTEXT;
            return org.apache.batik.xml.LexicalUnits.
                     SECTION_END;
        }
        while (current !=
                 -1) {
            while (current !=
                     ']' &&
                     current !=
                     -1) {
                nextChar(
                  );
            }
            if (current !=
                  -1) {
                nextChar(
                  );
                if (current ==
                      ']') {
                    nextChar(
                      );
                    if (current ==
                          '>') {
                        break;
                    }
                }
            }
        }
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        nextChar(
          );
        cdataEndRead =
          true;
        return org.apache.batik.xml.LexicalUnits.
                 CHARACTER_DATA;
    }
    protected int nextInXMLDecl() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case 'v':
                return readIdentifier(
                         "ersion",
                         org.apache.batik.xml.LexicalUnits.
                           VERSION_IDENTIFIER,
                         -1);
            case 'e':
                return readIdentifier(
                         "ncoding",
                         org.apache.batik.xml.LexicalUnits.
                           ENCODING_IDENTIFIER,
                         -1);
            case 's':
                return readIdentifier(
                         "tandalone",
                         org.apache.batik.xml.LexicalUnits.
                           STANDALONE_IDENTIFIER,
                         -1);
            case '=':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         EQ;
            case '?':
                nextChar(
                  );
                if (current !=
                      '>') {
                    throw createXMLException(
                            "pi.end.expected");
                }
                nextChar(
                  );
                context =
                  TOP_LEVEL_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         PI_END;
            case '\"':
                attrDelimiter =
                  '\"';
                return readString(
                         );
            case '\'':
                attrDelimiter =
                  '\'';
                return readString(
                         );
            default:
                throw createXMLException(
                        "invalid.character");
        }
    }
    protected int nextInDoctype() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  TOP_LEVEL_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case 'S':
                return readIdentifier(
                         "YSTEM",
                         org.apache.batik.xml.LexicalUnits.
                           SYSTEM_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'P':
                return readIdentifier(
                         "UBLIC",
                         org.apache.batik.xml.LexicalUnits.
                           PUBLIC_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case '\"':
                attrDelimiter =
                  '\"';
                return readString(
                         );
            case '\'':
                attrDelimiter =
                  '\'';
                return readString(
                         );
            case '[':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                inDTD =
                  true;
                return org.apache.batik.xml.LexicalUnits.
                         LSQUARE_BRACKET;
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInDTDDeclarations()
          throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case ']':
                nextChar(
                  );
                context =
                  DOCTYPE_CONTEXT;
                inDTD =
                  false;
                return org.apache.batik.xml.LexicalUnits.
                         RSQUARE_BRACKET;
            case '%':
                return readPEReference(
                         );
            case '<':
                switch (nextChar(
                          )) {
                    case '?':
                        context =
                          PI_CONTEXT;
                        return readPIStart(
                                 );
                    case '!':
                        switch (nextChar(
                                  )) {
                            case '-':
                                return readComment(
                                         );
                            case 'E':
                                switch (nextChar(
                                          )) {
                                    case 'L':
                                        context =
                                          ELEMENT_DECLARATION_CONTEXT;
                                        return readIdentifier(
                                                 "EMENT",
                                                 org.apache.batik.xml.LexicalUnits.
                                                   ELEMENT_DECLARATION_START,
                                                 -1);
                                    case 'N':
                                        context =
                                          ENTITY_CONTEXT;
                                        return readIdentifier(
                                                 "TITY",
                                                 org.apache.batik.xml.LexicalUnits.
                                                   ENTITY_START,
                                                 -1);
                                    default:
                                        throw createXMLException(
                                                "invalid.character");
                                }
                            case 'A':
                                context =
                                  ATTLIST_CONTEXT;
                                return readIdentifier(
                                         "TTLIST",
                                         org.apache.batik.xml.LexicalUnits.
                                           ATTLIST_START,
                                         -1);
                            case 'N':
                                context =
                                  NOTATION_CONTEXT;
                                return readIdentifier(
                                         "OTATION",
                                         org.apache.batik.xml.LexicalUnits.
                                           NOTATION_START,
                                         -1);
                            default:
                                throw createXMLException(
                                        "invalid.character");
                        }
                    default:
                        throw createXMLException(
                                "invalid.character");
                }
            default:
                throw createXMLException(
                        "invalid.character");
        }
    }
    protected int readString() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        do  {
            nextChar(
              );
        }while(current !=
                 -1 &&
                 current !=
                 attrDelimiter); 
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        nextChar(
          );
        return org.apache.batik.xml.LexicalUnits.
                 STRING;
    }
    protected int readComment() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (nextChar(
              ) !=
              '-') {
            throw createXMLException(
                    "malformed.comment");
        }
        int c =
          nextChar(
            );
        while (c !=
                 -1) {
            while (c !=
                     -1 &&
                     c !=
                     '-') {
                c =
                  nextChar(
                    );
            }
            c =
              nextChar(
                );
            if (c ==
                  '-') {
                break;
            }
        }
        if (c ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        c =
          nextChar(
            );
        if (c !=
              '>') {
            throw createXMLException(
                    "malformed.comment");
        }
        nextChar(
          );
        return org.apache.batik.xml.LexicalUnits.
                 COMMENT;
    }
    protected int readIdentifier(java.lang.String s,
                                 int type,
                                 int ntype)
          throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        int len =
          s.
          length(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            nextChar(
              );
            if (current !=
                  s.
                  charAt(
                    i)) {
                if (ntype ==
                      -1) {
                    throw createXMLException(
                            "invalid.character");
                }
                else {
                    while (current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)) {
                        nextChar(
                          );
                    }
                    return ntype;
                }
            }
        }
        nextChar(
          );
        return type;
    }
    protected int readName(int type) throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        if (!org.apache.batik.xml.XMLUtilities.
              isXMLNameFirstCharacter(
                (char)
                  current)) {
            throw createXMLException(
                    "invalid.name");
        }
        do  {
            nextChar(
              );
        }while(current !=
                 -1 &&
                 org.apache.batik.xml.XMLUtilities.
                 isXMLNameCharacter(
                   (char)
                     current)); 
        return type;
    }
    protected int readPIStart() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        int c1 =
          nextChar(
            );
        if (c1 ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        if (!org.apache.batik.xml.XMLUtilities.
              isXMLNameFirstCharacter(
                (char)
                  current)) {
            throw createXMLException(
                    "malformed.pi.target");
        }
        int c2 =
          nextChar(
            );
        if (c2 ==
              -1 ||
              !org.apache.batik.xml.XMLUtilities.
              isXMLNameCharacter(
                (char)
                  c2)) {
            return org.apache.batik.xml.LexicalUnits.
                     PI_START;
        }
        int c3 =
          nextChar(
            );
        if (c3 ==
              -1 ||
              !org.apache.batik.xml.XMLUtilities.
              isXMLNameCharacter(
                (char)
                  c3)) {
            return org.apache.batik.xml.LexicalUnits.
                     PI_START;
        }
        int c4 =
          nextChar(
            );
        if (c4 !=
              -1 &&
              org.apache.batik.xml.XMLUtilities.
              isXMLNameCharacter(
                (char)
                  c4)) {
            do  {
                nextChar(
                  );
            }while(current !=
                     -1 &&
                     org.apache.batik.xml.XMLUtilities.
                     isXMLNameCharacter(
                       (char)
                         current)); 
            return org.apache.batik.xml.LexicalUnits.
                     PI_START;
        }
        if ((c1 ==
               'x' ||
               c1 ==
               'X') &&
              (c2 ==
                 'm' ||
                 c2 ==
                 'M') &&
              (c3 ==
                 'l' ||
                 c3 ==
                 'L')) {
            throw createXMLException(
                    "xml.reserved");
        }
        return org.apache.batik.xml.LexicalUnits.
                 PI_START;
    }
    protected int nextInElementDeclaration()
          throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case '%':
                nextChar(
                  );
                int t =
                  readName(
                    org.apache.batik.xml.LexicalUnits.
                      PARAMETER_ENTITY_REFERENCE);
                if (current !=
                      ';') {
                    throw createXMLException(
                            "malformed.parameter.entity");
                }
                nextChar(
                  );
                return t;
            case 'E':
                return readIdentifier(
                         "MPTY",
                         org.apache.batik.xml.LexicalUnits.
                           EMPTY_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'A':
                return readIdentifier(
                         "NY",
                         org.apache.batik.xml.LexicalUnits.
                           ANY_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case '?':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         QUESTION;
            case '+':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PLUS;
            case '*':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         STAR;
            case '(':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         LEFT_BRACE;
            case ')':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         RIGHT_BRACE;
            case '|':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PIPE;
            case ',':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         COMMA;
            case '#':
                return readIdentifier(
                         "PCDATA",
                         org.apache.batik.xml.LexicalUnits.
                           PCDATA_IDENTIFIER,
                         -1);
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInAttList() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                return type =
                  org.apache.batik.xml.LexicalUnits.
                    END_CHAR;
            case '%':
                int t =
                  readName(
                    org.apache.batik.xml.LexicalUnits.
                      PARAMETER_ENTITY_REFERENCE);
                if (current !=
                      ';') {
                    throw createXMLException(
                            "malformed.parameter.entity");
                }
                nextChar(
                  );
                return t;
            case 'C':
                return readIdentifier(
                         "DATA",
                         org.apache.batik.xml.LexicalUnits.
                           CDATA_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'I':
                nextChar(
                  );
                if (current !=
                      'D') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             ID_IDENTIFIER;
                }
                if (current !=
                      'R') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'E') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'F') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             IDREF_IDENTIFIER;
                }
                if (current !=
                      'S') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             IDREFS_IDENTIFIER;
                }
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLNameCharacter(
                           (char)
                             current)); 
                return type =
                  org.apache.batik.xml.LexicalUnits.
                    NAME;
            case 'N':
                switch (nextChar(
                          )) {
                    default:
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.xml.XMLUtilities.
                                 isXMLNameCharacter(
                                   (char)
                                     current)); 
                        return org.apache.batik.xml.LexicalUnits.
                                 NAME;
                    case 'O':
                        context =
                          NOTATION_TYPE_CONTEXT;
                        return readIdentifier(
                                 "TATION",
                                 org.apache.batik.xml.LexicalUnits.
                                   NOTATION_IDENTIFIER,
                                 org.apache.batik.xml.LexicalUnits.
                                   NAME);
                    case 'M':
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'T') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'O') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'K') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'E') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'N') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NMTOKEN_IDENTIFIER;
                        }
                        if (current !=
                              'S') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NMTOKENS_IDENTIFIER;
                        }
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.xml.XMLUtilities.
                                 isXMLNameCharacter(
                                   (char)
                                     current)); 
                        return org.apache.batik.xml.LexicalUnits.
                                 NAME;
                }
            case 'E':
                nextChar(
                  );
                if (current !=
                      'N') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'T') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'I') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'T') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return type =
                      org.apache.batik.xml.LexicalUnits.
                        NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                switch (current) {
                    case 'Y':
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     ENTITY_IDENTIFIER;
                        }
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.xml.XMLUtilities.
                                 isXMLNameCharacter(
                                   (char)
                                     current)); 
                        return org.apache.batik.xml.LexicalUnits.
                                 NAME;
                    case 'I':
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'E') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'S') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        return org.apache.batik.xml.LexicalUnits.
                                 ENTITIES_IDENTIFIER;
                    default:
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.xml.XMLUtilities.
                                 isXMLNameCharacter(
                                   (char)
                                     current)); 
                        return org.apache.batik.xml.LexicalUnits.
                                 NAME;
                }
            case '\"':
                attrDelimiter =
                  '\"';
                nextChar(
                  );
                if (current ==
                      -1) {
                    throw createXMLException(
                            "unexpected.eof");
                }
                if (current !=
                      '\"' &&
                      current !=
                      '&') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '\"' &&
                             current !=
                             '&'); 
                }
                switch (current) {
                    case '&':
                        context =
                          ATTRIBUTE_VALUE_CONTEXT;
                        return org.apache.batik.xml.LexicalUnits.
                                 FIRST_ATTRIBUTE_FRAGMENT;
                    case '\"':
                        nextChar(
                          );
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                    default:
                        throw createXMLException(
                                "invalid.character");
                }
            case '\'':
                attrDelimiter =
                  '\'';
                nextChar(
                  );
                if (current ==
                      -1) {
                    throw createXMLException(
                            "unexpected.eof");
                }
                if (current !=
                      '\'' &&
                      current !=
                      '&') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '\'' &&
                             current !=
                             '&'); 
                }
                switch (current) {
                    case '&':
                        context =
                          ATTRIBUTE_VALUE_CONTEXT;
                        return org.apache.batik.xml.LexicalUnits.
                                 FIRST_ATTRIBUTE_FRAGMENT;
                    case '\'':
                        nextChar(
                          );
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                    default:
                        throw createXMLException(
                                "invalid.character");
                }
            case '#':
                switch (nextChar(
                          )) {
                    case 'R':
                        return readIdentifier(
                                 "EQUIRED",
                                 org.apache.batik.xml.LexicalUnits.
                                   REQUIRED_IDENTIFIER,
                                 -1);
                    case 'I':
                        return readIdentifier(
                                 "MPLIED",
                                 org.apache.batik.xml.LexicalUnits.
                                   IMPLIED_IDENTIFIER,
                                 -1);
                    case 'F':
                        return readIdentifier(
                                 "IXED",
                                 org.apache.batik.xml.LexicalUnits.
                                   FIXED_IDENTIFIER,
                                 -1);
                    default:
                        throw createXMLException(
                                "invalid.character");
                }
            case '(':
                nextChar(
                  );
                context =
                  ENUMERATION_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         LEFT_BRACE;
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInNotation() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case '%':
                int t =
                  readName(
                    org.apache.batik.xml.LexicalUnits.
                      PARAMETER_ENTITY_REFERENCE);
                if (current !=
                      ';') {
                    throw createXMLException(
                            "malformed.parameter.entity");
                }
                nextChar(
                  );
                return t;
            case 'S':
                return readIdentifier(
                         "YSTEM",
                         org.apache.batik.xml.LexicalUnits.
                           SYSTEM_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'P':
                return readIdentifier(
                         "UBLIC",
                         org.apache.batik.xml.LexicalUnits.
                           PUBLIC_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case '\"':
                attrDelimiter =
                  '\"';
                return readString(
                         );
            case '\'':
                attrDelimiter =
                  '\'';
                return readString(
                         );
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInEntity() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case '%':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PERCENT;
            case 'S':
                return readIdentifier(
                         "YSTEM",
                         org.apache.batik.xml.LexicalUnits.
                           SYSTEM_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'P':
                return readIdentifier(
                         "UBLIC",
                         org.apache.batik.xml.LexicalUnits.
                           PUBLIC_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'N':
                return readIdentifier(
                         "DATA",
                         org.apache.batik.xml.LexicalUnits.
                           NDATA_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case '\"':
                attrDelimiter =
                  '\"';
                nextChar(
                  );
                if (current ==
                      -1) {
                    throw createXMLException(
                            "unexpected.eof");
                }
                if (current !=
                      '\"' &&
                      current !=
                      '&' &&
                      current !=
                      '%') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '\"' &&
                             current !=
                             '&' &&
                             current !=
                             '%'); 
                }
                switch (current) {
                    default:
                        throw createXMLException(
                                "invalid.character");
                    case '&':
                    case '%':
                        context =
                          ENTITY_VALUE_CONTEXT;
                        break;
                    case '\"':
                        nextChar(
                          );
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                }
                return org.apache.batik.xml.LexicalUnits.
                         FIRST_ATTRIBUTE_FRAGMENT;
            case '\'':
                attrDelimiter =
                  '\'';
                nextChar(
                  );
                if (current ==
                      -1) {
                    throw createXMLException(
                            "unexpected.eof");
                }
                if (current !=
                      '\'' &&
                      current !=
                      '&' &&
                      current !=
                      '%') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '\'' &&
                             current !=
                             '&' &&
                             current !=
                             '%'); 
                }
                switch (current) {
                    default:
                        throw createXMLException(
                                "invalid.character");
                    case '&':
                    case '%':
                        context =
                          ENTITY_VALUE_CONTEXT;
                        break;
                    case '\'':
                        nextChar(
                          );
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                }
                return org.apache.batik.xml.LexicalUnits.
                         FIRST_ATTRIBUTE_FRAGMENT;
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInEntityValue() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case '&':
                return readReference(
                         );
            case '%':
                int t =
                  nextChar(
                    );
                readName(
                  org.apache.batik.xml.LexicalUnits.
                    PARAMETER_ENTITY_REFERENCE);
                if (current !=
                      ';') {
                    throw createXMLException(
                            "invalid.parameter.entity");
                }
                nextChar(
                  );
                return t;
            default:
                while (current !=
                         -1 &&
                         current !=
                         attrDelimiter &&
                         current !=
                         '&' &&
                         current !=
                         '%') {
                    nextChar(
                      );
                }
                switch (current) {
                    case -1:
                        throw createXMLException(
                                "unexpected.eof");
                    case '\'':
                    case '\"':
                        nextChar(
                          );
                        context =
                          ENTITY_CONTEXT;
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                }
                return org.apache.batik.xml.LexicalUnits.
                         FIRST_ATTRIBUTE_FRAGMENT;
        }
    }
    protected int nextInNotationType() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '|':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PIPE;
            case '(':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         LEFT_BRACE;
            case ')':
                nextChar(
                  );
                context =
                  ATTLIST_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         RIGHT_BRACE;
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInEnumeration() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '|':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PIPE;
            case ')':
                nextChar(
                  );
                context =
                  ATTLIST_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         RIGHT_BRACE;
            default:
                return readNmtoken(
                         );
        }
    }
    protected int readReference() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        nextChar(
          );
        if (current ==
              '#') {
            nextChar(
              );
            int i =
              0;
            switch (current) {
                case 'x':
                    do  {
                        i++;
                        nextChar(
                          );
                    }while(current >=
                             '0' &&
                             current <=
                             '9' ||
                             current >=
                             'a' &&
                             current <=
                             'f' ||
                             current >=
                             'A' &&
                             current <=
                             'F'); 
                    break;
                default:
                    do  {
                        i++;
                        nextChar(
                          );
                    }while(current >=
                             '0' &&
                             current <=
                             '9'); 
                    break;
                case -1:
                    throw createXMLException(
                            "unexpected.eof");
            }
            if (i ==
                  1 ||
                  current !=
                  ';') {
                throw createXMLException(
                        "character.reference");
            }
            nextChar(
              );
            return org.apache.batik.xml.LexicalUnits.
                     CHARACTER_REFERENCE;
        }
        else {
            int t =
              readName(
                org.apache.batik.xml.LexicalUnits.
                  ENTITY_REFERENCE);
            if (current !=
                  ';') {
                throw createXMLException(
                        "character.reference");
            }
            nextChar(
              );
            return t;
        }
    }
    protected int readPEReference() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        nextChar(
          );
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        if (!org.apache.batik.xml.XMLUtilities.
              isXMLNameFirstCharacter(
                (char)
                  current)) {
            throw createXMLException(
                    "invalid.parameter.entity");
        }
        do  {
            nextChar(
              );
        }while(current !=
                 -1 &&
                 org.apache.batik.xml.XMLUtilities.
                 isXMLNameCharacter(
                   (char)
                     current)); 
        if (current !=
              ';') {
            throw createXMLException(
                    "invalid.parameter.entity");
        }
        nextChar(
          );
        return org.apache.batik.xml.LexicalUnits.
                 PARAMETER_ENTITY_REFERENCE;
    }
    protected int readNmtoken() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        while (org.apache.batik.xml.XMLUtilities.
                 isXMLNameCharacter(
                   (char)
                     current)) {
            nextChar(
              );
        }
        return org.apache.batik.xml.LexicalUnits.
                 NMTOKEN;
    }
    protected int nextChar() throws java.io.IOException {
        current =
          reader.
            read(
              );
        if (current ==
              -1) {
            return current;
        }
        if (position ==
              buffer.
                length) {
            char[] t =
              new char[1 +
                         position +
                         position /
                         2];
            java.lang.System.
              arraycopy(
                buffer,
                0,
                t,
                0,
                position);
            buffer =
              t;
        }
        return buffer[position++] =
          (char)
            current;
    }
    protected org.apache.batik.xml.XMLException createXMLException(java.lang.String message) {
        java.lang.String m;
        try {
            m =
              formatMessage(
                message,
                new java.lang.Object[] { new java.lang.Integer(
                  reader.
                    getLine(
                      )),
                new java.lang.Integer(
                  reader.
                    getColumn(
                      )) });
        }
        catch (java.util.MissingResourceException e) {
            m =
              message;
        }
        return new org.apache.batik.xml.XMLException(
          m);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NorPzU5xUtJaVrBUJMRDMMauzTsNFKQL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+YmX/8XmS1P/H+L7hW49eAAA");
}
