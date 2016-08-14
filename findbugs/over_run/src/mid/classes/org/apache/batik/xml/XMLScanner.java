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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RlbRiH9s+V/UtEqgoGUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV9CbgsWV1fv3vfzJsZZh9mcWAGBh4gNLzq6rXaEaW2Xqu7" +
       "lq5eVWaqq6qra6+upWsBZImCCUoIDIpfYEgU4zaKCxgMMQ6fEheIBtzjggsx" +
       "KqLgAklQyanuvsvrd9999867Se731em6dZb6/f7nf/7nf06dOvXU5zI3eG4m" +
       "69hGrBi2f0mO/EuaUbrkx47sXWpRJUZwPVnCDcHzeHDtMfEFP3bHF7/89vmd" +
       "O5kbJ5l7BMuyfcFXbcvjZM82lrJEZe44uEoasun5mTspTVgKUOCrBkSpnv8o" +
       "lXnWoax+5iK1BwECECAAAVpBgNCDVCDTbbIVmHiaQ7B8b5H55sw5KnOjI6bw" +
       "/MwjlxfiCK5gbophVgxACTel/w8AqVXmyM08f5/7mvMVhN+VhZ74rlff+RO7" +
       "mTsmmTtUq5fCEQEIH9xkkrnVlM2p7HqoJMnSJHOXJctST3ZVwVCTFe5J5m5P" +
       "VSzBD1x5X0jpxcCR3dU9DyR3q5hycwPRt919ejNVNqS9/26YGYICuN53wHXN" +
       "sJZeBwRvUQEwdyaI8l6W87pqSX7meds59jlebIMEIOsFU/bn9v6tzlsCuJC5" +
       "e113hmApUM93VUsBSW+wA3AXP/PgVQtNZe0Ioi4o8mN+5oHtdMw6CqS6eSWI" +
       "NIufuXc72aokUEsPbtXSofr5XPdr3/Yaq2HtrDBLsmik+G8CmR7eysTJM9mV" +
       "LVFeZ7z1ZdR3Cvf9zLftZDIg8b1biddp/v1rv/Cqlz/89C+u0zzniDT0VJNF" +
       "/zHx/dPbP/lc/KXV3RTGTY7tqWnlX8Z8pf7MJubRyAEt7779EtPIS3uRT3P/" +
       "efyGH5I/u5O5pZm5UbSNwAR6dJdom45qyG5dtmRX8GWpmblZtiR8Fd/MXADn" +
       "lGrJ66v0bObJfjNz3lhdutFe/Q9ENANFpCK6AM5Va2bvnTuCP1+dR04mk7kA" +
       "jswlcLwks/5b/fqZx6G5bcqQIAqWatkQ49op/7RCLUmAfNkD5xKIdWxoCvRf" +
       "fwV8qQJ5duAChYRsV4EEoBVzeR0JRaYBjTpUD5QGKF1KNc35f3CPKOV5Z3ju" +
       "HKiC524bAAO0nYZtSLL7mPhEgJFf+NHHPr6z3yA2EgLtCdzo0vpGl1Y3ugRu" +
       "dOngRplz51blPzu94bp6QeXooJkDA3jrS3vf1Hr8216wC/TKCc8Dye6CpNDV" +
       "7TB+YBiaK/MnAu3MPP3u8I2D1+d2MjuXG9QUJLh0S5qdSc3gvrm7uN2Qjir3" +
       "jrf82Rc/8J2vsw+a1GUWetPSr8yZttQXbIvTtUVZArbvoPiXPV/40GM/87qL" +
       "O5nzoPkDk+cLQEWBNXl4+x6XtdhH96xfyuUGQHhmu6ZgpFF7JusWf+7a4cGV" +
       "VT3fvjq/C8j4WakK3wuO39jo9Oo3jb3HScNnr/UirbQtFivr+sqe897f/pU/" +
       "L6zEvWeI7zjUtfVk/9FDjT8t7I5VM7/rQAd4V5ZBut9/N/POd33uLd+wUgCQ" +
       "4oVH3fBiGuKg0YMqBGL+1l9c/M6n/+D9v76zrzTnfND7BVNDFaN9kun1zC3H" +
       "kAR3e/EBHmA8DNC4Uq252LdMW1JnqjA15FRL/+GOF8Ef+su33bnWAwNc2VOj" +
       "l1+7gIPrX4Vl3vDxV3/p4VUx58S08zqQ2UGytUW856Bk1HWFOMURvfFTD333" +
       "LwjvBbYV2DNPTeSViTq3lsGK+b1+5vZVTtUGdl4AjXdVl9Aq8mWr8NKVWR65" +
       "WhsmI1F2UlCrUgpp8DzvcOu5vIEe8lIeE9/+65+/bfD5//SFFd3L3ZzDytIR" +
       "nEfX+pkGz49A8fdvm4qG4M1BuuLT3W+803j6y6DECShRBGbOo92U42WqtUl9" +
       "w4X/9tGfu+/xT+5mdmqZWwxbkGrCqpVmbgbNQ/bmwLZFzte/aq0d4U0guDM9" +
       "izL7YsqsxJRZK9WDV7afz2xU6zNHt580fCQNXnSlVl4t61ZF7awQ7OxV1D17" +
       "ddu0nMAHboi8sWkg7s5VXOqfXFr7JysU2NE1n/5bXCVopMErV/HlNPi6Ndvq" +
       "dQnmbzbs/ub0grla1qvzIFelstci2ksD6oBo5zRE12kfWP13EajoS6/eRdVS" +
       "P/XAyj/wv2lj+qY//p9XNINV53SEe7aVfwI99Z4H8a/77Cr/QS+R5n44urLb" +
       "Bj79Qd78D5l/v/OCGz+2k7kwydwpbgYMA8EIUts7AU6ytzeKAIOKy+Ivd3jX" +
       "3t2j+73gc7d7qEO33e6fDtwFcJ6mTs9v2eqSHkilXAHHyzfV//JtzVk5EXcd" +
       "6HgT+PeK7N79x//m/V9641uQndQm3rBMoQOpHGoL3SAdl7z5qXc99Kwn/vCt" +
       "qz5jr+hvWiviKryYBi9ZuyDp6VeDLsVbDXF8QEe1BGPTtXwF/J0Dxz+lR1pS" +
       "eiH9BRLDN47p8/c9Uwd4SPcRNN7vkF3+sR6PcvxjON3lyRF/vBYxrmqC3nO5" +
       "cdKh1939af09f/Yjawd8W2W2Esvf9sS/+Mqltz2xc2jY88IrRh6H86yHPqs6" +
       "uS0NZqkZfuS4u6xy1P7HB173kR943VvWqO6+3IknwRj1R37zHz9x6d1/+EtH" +
       "+I27YIB2YA1WLfLV12qRo8v1JQ8OeKMv8BH6kp48tmcEvOMqOw2kNJBXMpj5" +
       "mbt4mnmMIgcktVdfaYSxhdg/JeIsOMobxOVjEO+kJ685HeJbmOZxUF97Sqip" +
       "QB/dQH30GKgrOP/sdFDvBK7FYwSJHyvbbzkl4Bw4NknXv1cBfD49eevpAN8B" +
       "mjA/Zsjj8H77M9BecoOXPAbvDenJO0+pvWtLw6P14xA/8Qwk3Nogbh2D+Mb0" +
       "5F+fUsIrnF3+OLzvOSXeKjjoDV76GLwX0pPvPR3eBwieWKkwyqF8k+72jgP+" +
       "/lMCT00DvwHOHwP8pvTkh08H/F6cQHn0sR6Jp7CPQ/3UM1CP8Qb1+BjUN6cn" +
       "P3lK9SC7xLXU+YPPQD1evcH76mPw3pKefOR0eO9HeZ5rYn2efGyAUv1jDcd/" +
       "fAaWWdzgFo/B/az05OdOKWeAm2r2jm2GP39KvK8Ex3yDd34M3lvTk4+fDu9z" +
       "SIpcuVaHmuJx2D/xDHTa3GA3j8G+8pp+7XTYbwe4m/z4OLi//gz6FHcD1z0G" +
       "7mqs/bun7LS7NH9N+f7eKQGnLn+4ARweA/iO9ORPTmnp9gFfq+v+zClRl8Dx" +
       "2g3q1x6D+s705LOnQ30P2QWDhWtr8l8+gz7ljRvMbzwG813pyd+eDvOzN5p8" +
       "TVP3dycH/Zw9fX7LBvSbrwTtZ15y5MyVK29mwS91ZM8TlPU06JevQsrP3Oy4" +
       "tg8GuLJ0hNpj/S5BAVYU2ut10Q6ZXie3eP3DyXndnl7FwPG2Da9vv4JXJj05" +
       "d/5ouOlg5lxmD93dhi2uHrFNDbkXOI7trp8H3utnvvoK0agwYl2irshwOZdz" +
       "N5ySS/pA5J0bLu+8CpfbTsLlRnc1YbmH/2VX4F8NK1X7Unc14a0mqqWs5zi3" +
       "GNx+SgYPguPdGwbvvgqD+07C4IIYuK68Htduqf65+08J6n5wvHcD6r1XAfXQ" +
       "SUDtz7lsI3r4lIheAY7v2SD6nqsguniiip4GsxmoaDfzoqtPgKxmvdfzGU/+" +
       "uxf+yuuffOEfreZ9b1K9geCirnLE49BDeT7/1Kc/+6nbHvrR1cOV81PBW087" +
       "bT9HvvIx8WVPf1eIb90Xw0o4zwZ0bl9LYf3rZ6IzfVCXPrQXQh9STWC5INGW" +
       "ZBHy1dkM4pu1GqG6cjqLHe89JPz/du+19qirOl2fm0DZxPlmUcH2Y4ZRqgIv" +
       "39OTwtF6srPfwezb3xsN2VLWT2RTBT6XdaL98o+cHV/N+uGGbcmpjduLe/be" +
       "zPn+ogQQGV2B1M287Ooq2VlpxsH06i+86S8e5L9u/vgpnjs+b0tjt4v8wc5T" +
       "v1R/sfiOnczu/mTrFSsWLs/06OVTrLe4sh+4Fn/ZROtDa+Gv5LeWfBq8aCXi" +
       "1f8H8+Z7M95pWvyYuLQLPPcqP3ODmIp6XTPHJG9EmS3z86JTmp/UIfj+jfn5" +
       "/quYn/ZJzM9lDya3jSJ1SlSpb/XUBtVTV0HFnQTVDaA23SN7jt4pId0Hjh/f" +
       "QPrxq0AanwTSrmxJRwGaPIP+9ac2gH7qKoAeP1n/ul5udBQo4RlU3Ec2oD5y" +
       "FVDKiSpOkp0D+3QY0vyUkJ4Pjqc3kJ6+CiTrJJBudlTSklLf6CgbfWFq24Ys" +
       "WFto7VOifS44PrZB+7GroI1OJEDVIngiveRtQYpPCekRcPzyBtIvXwXS608C" +
       "6TbB911CNtIHHiv38hy0Be0Np4T2QnD86gbar14F2ptPAu1WURJ8YVO9Rwnt" +
       "LddEtlaHdPh0Q/5S5VIuzfUdpxvx3a8Z4sW9x10D4MsBc3pRMypp9PbgaHZi" +
       "QKD7vf2gD6dsS3n0rZ95+yf+5Qs/DVy/1t7jvTT140AszHeSd74qxf7E6bA/" +
       "mGLvrTwgSvD8zmqphiyl8I90aUD/pjxjSv7Db28UvSa699cZSHiJ60cTM6jM" +
       "S+a4iU/GI63dK5IcNhzUNRyJI03rdAlcL1VqnRAmc0RDLleQOFelu3EQ2XUM" +
       "a4gDaay79tIeq2A8x9dMYlb3BahnCwSbBZeEZOY0uWaeigyJ7JZbkQ0toYE0" +
       "qE6rULAIKtOqbxlWzZfE8jK7WEKV8iILNdxZMJGyjUlN67WITpfiKsN6oNfZ" +
       "HJKXTBoZJjQvuwq8UIc8O9Wm9YqLJEKQbzCWr7Zhue+aPRiNFvG4zBo+O+Jm" +
       "nE1TZo9vLkkd7lFziNOdcrnRF6gp3KLLQb+s6X0OaXH6rDedNrS6otfapKRO" +
       "cbo+mNgTG+/kegrcLOSchStTqKqUaA/PCUNK6FL9YidhG3F7zob+XMH7CU2a" +
       "KuwMG7JZG8x0p10O0ZFAL3IO12M4R0f13iRo8I02ro/nQb2pmEK7k+Uwb6m2" +
       "igu1pgg0MWzMHbMAFyr50mRISOO47g1sxFqgnbHVnlh6RMJZa462TbiyXGiy" +
       "GpcMIyJnKBnnHGGi2xM08JvmgmJbbb2g+aM2Vl0wsIy7Q9PEQoFa6D2VJnGD" +
       "jJsVj2UTGjZx1TSzeqfFxhaqeTzm8o1JFzfNqochss2b1jQblxdlupDXJXXo" +
       "aCJX6bdybJusz3VngC6wiptDYL2XqN4clnudUc1GsIqk1TUuJqdcfjlqxSQm" +
       "2rEeKjzry0TXKOOCm8s228N5OzQFneUnykRmCp1Fh5uF0ELLK5hiDbF5iVVG" +
       "xVEOHWI5LBKjLDGMGLXW81SRJ5JmOW7xzXG9UmzU+3iuvZjyYb9nLuxFEdOk" +
       "JsPL3AIbzwTaxopFj2G7kznOY5heNQWnRuh5H8OFCostJ3KvJ5aQAh+2RBtW" +
       "uDbabMm0lB/MWzlywTcEWBdKCEMjWaToUUXdVUcySVgeVm7by6LGDtUym1cn" +
       "hUV2Si9ZgtLmi2mAClOxTeQreZKlp5HmhUhSqS5pK8mrElNgECvhOybvlJdL" +
       "VINJOdetZPML2ara5UmRZGBuHrRaTW7KhF6pHY+kcdAvqSTBdPIk3zTH+dac" +
       "LlCQB2cledZcZpeO1PdLTLuPtwXVJiWN1Y2xPtYXTkBVp/NAMFjGL3U4WUvE" +
       "2KemPW5EoqV6MQmq+epMtCTJodsLyhuYQxxic/1qv8P1aiQc4UwE6Wx5as5z" +
       "emfYIMhWszaIdVKoaDgDNWaqMSnwvbFKG92hrlJctt1yzGKizNSInVhMbtJh" +
       "iRy90IfaAoX8WSdfzRazRjfu822s2fV6jkLwnDOOBIImS0F97NdNMbFxZoAK" +
       "bN0hewmTJbL2mHUiDS54SA7leIstKrgFW71eU4C9gpzrVPrsEpoPCx4j0gxO" +
       "qORYWRbJGj+K1bkz4cYw2xe6A3JWKw4ZS/NISl520aJQxqdKCZG6wszK5vzR" +
       "tAQ5aMWLYUNEvaTSpDXfKtRNGCIbgjqT61UtD1U68ySB+VlRHcgiZlQ7dGmc" +
       "uMg8hqzEE/3OnGFDGYMmnRaWn/fhOCpVR0SlBcHQwm9XBDFiemG20PFETC02" +
       "5/ySU7PiQqCw/BhKjIFfyU+DWWE07ZZsfmBXOnWV6RUNlW5pZtv0kqFUbPiE" +
       "WIS4SmBUxQZNGHAPrYZ1ppeM7KZMdBxt6caN5jgZWpYKq3UUSG+OWbztqP2q" +
       "ow2kLtZxqVnQITrTMEtpdtNojBVEIKoSZetBNMrF0riOFvWJZ+TtkMBGTFDI" +
       "6pHkQkillc1G8pzWQhr2lTrClWfdrp8l5lI/oRKm3vHqykIO2EqYrQSLbDnr" +
       "MVRiMnksMcySEISo2B0ihMXOSSJhkrhUdYaEm61Wc5MgGrLZWsjPBhhEj202" +
       "AtY6u6j1CC5R4WrYkGr2MKvBPOtpxe6AW9ra0Kj2o1wlZiqjRuJClhIvFwEG" +
       "k8V+RdDIojdqYjBUVmslukksiqXOBBkUWW2eHzrRJD+dEw0zGBTqbSGvTPvj" +
       "vObiVTqY9akpIRSlQl2PPaNmNXyKoIdEswXXemHMajg3N7sMKrk4zIzHRpdi" +
       "oqHrKR2TXUZEcZBDSwPVmcQY22d6BSuI6fLc1312GiypmpaTl1lGnYdhFFTV" +
       "hJqqoWT6jU6Fo4lxUVayTYPmKwOyF5bwpcHkpVJpVqsWoNYE9Mq63VEmUldy" +
       "zGZHDHIcXZoPBGCMFl5rUYIKpIyo/TncFeharR4ExgTlckSSK+HtEhwzWpCX" +
       "wjKsZBs2WtLYmCPIPJkTRQ+hrSqfzXfqk3E+QablllSqlpBSZWQOhjG5mBqS" +
       "qxbmvXzWmkLEmFemSsUsTdSQl6Y9zyhbHj+deXmKjfyO3K01B44el8Vmmx94" +
       "fE/kk1Gc5XjeBm1mIeMzHOgipSTCsGEnmFWRS0hxoekmkusttFJEYwjHFKqd" +
       "OVkaKrjb5RLcq0lqv85g/MxuqOWR2aGCpK+pgy5SWlIUbGr9eMYQAg9Vikir" +
       "BrlyO1nyVlyU0Hk3ay5HUj07HVarls8YeRIfT+LpQq9BE5/OlmMBtpYipLsc" +
       "2XKGYrcklthxJ85PyGy2NRuPKkjSjip5XQB9HV404Rxr+6behJYRNUQRK6eA" +
       "nomHLSc/6lYYp+Yndlzsl/KaLcBCCZ7byThUNFePGN+OILKAO5ouuXO6lkwS" +
       "u0uI+VHkaNK4mh927E65Pq0Ok5nHTCnY02ik3Mg23D4zULjBtJt1OkWO8nIW" +
       "POKjAIgsN+uQWZZyFkxEdSc0KhMkZHh4mUnGzLzt+X0R41UuwCYwUe/wNdHF" +
       "gQc1hKcLJKwikwqda/lqSFXdSV5ip9VS2JtYlfGkrlZCGW5Ve5Ljc2Yz7LQR" +
       "Pi5C09Y8mmRhbRC501xObc/wDlRaDvmGCIlLWZBHxCwhxGlxxNe6nomYsInS" +
       "+WFflDioCUMMg1a5gayi2LKIZ3MzwR/zXMwP+8UxphQJ3PULbF0TRo1qmIxG" +
       "S8huESK2KDUrdHYmz4xRIsnehGZKVtSlVd8aDtVRUfZ7hCITrbpdYOE+pcNa" +
       "LjHz0wakTUpeUBwsR5N2HEEMNqpEMpStOsv6aIggxlDqVYpBc8aOKkKzQHXJ" +
       "mSuS6gApSJAnj3pGxVdavkHPFzNVn/adJZ8XC1x+oS/07LDQnSzgvKuG8zBP" +
       "9PoyPcHb8DxrQGYW0ttZN5EreinXgQvR3IeYRCLaHaLNS5XecNGwm9gwBzUQ" +
       "i+0OuWFfQ428NBPrEL5ElFFvGaI8j8rL5UhsllGhwnOtvNUeYqXOjCJ0s9Fa" +
       "LHA9cH1pLksNakkqUySveua41lhME7g30vRBH+tE9TEYrOSzg2DgjnrdHsxa" +
       "YW8YIwbSWiiLTgXXJ4YQtk16iI/CspzPwiNlugB9QsWoJaNyTcDrY5k3dR3c" +
       "z0blSJTH446v1oR4ZkjYsJcDwouGYVurxTJihpPaAB0mZGj1ycGC8EXFsNFB" +
       "Sba9voctFFtbxuHEaIftnirAmOSP/bwzgectr5J1vb5QrxTifrlKOlh/NGCV" +
       "YbHIzYt+fZL3cN2t+xWQp+aXZSj2VTJXqwxEY0jTJdsvJTUJq49pDo0lTB+M" +
       "UTirLae4NYwKJU7RBJ/UBK9vt+0IMamWXecGfaIdtbi5CLulUJaIWVBuGl4t" +
       "cWoGshizLKVOHAIH3m5n1m7o3or7EC3gWHVeNqCCJrUEbRkSfVuYR30FW9T0" +
       "fsdQSq0BK+r9GUIw8Lyfb5SbeJYstqAecGFtxEGblXrcqlKYqrqK0xTQrigz" +
       "NblWljs9zJzzA9A9droDpcTQvY5oLhTK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "iWq+7BSmxYgoUFCJhrKOmx0u8zaKWbJVdOqVCcT5nb5LDJillhAm59ZCglhy" +
       "I74+1K1GiXENVGWr+IASVCuQRZY0pU4sGmFVXTJSlVM6fJsD/Z9WVRO+Oeo1" +
       "Wb/uxDUkSXwCAo5orVNrzXU7Xs7xQZ1rVGplLdIGTH6WyHohLHXBMK1q81Iu" +
       "XyobFgfG8UHOhJSBN6SrXqGpGhoas+1lMZoaY3tpkmUWdoRgkbRbIzrrUkY1" +
       "ohqODzdA4+775VKkDtmqg/Fe4tVyFp0UGWuYNGf4qGxMYYtZ8p2qZ4+WHS5p" +
       "LGs2GKNXKWjmLvRuPVa5hhXNmqDDbtUmbmtpJNKIKTRgsVqFFguQNzfvFxJO" +
       "qjhtW5NycJ9eSjNxGtnZ6oRkK0tbHMD2bOzA0BSM5EdloQZPfGCLe8sKuTCK" +
       "JbXgmho2pftTFS2GE1bW7KRWQBTNNjoFGoJbVmUwsxZCvV2dqhUy59bHuXEJ" +
       "9LF0fdyvGgndwtqTpsgupphr2URjPJ4zBlkuzhEwthMwzphyaqPqZQdQ3ycX" +
       "il3voyj6ylemj8zfd7pH5netHvfvb5TzDB70R4eWne2vjFj93ZjZ2lzl0MqI" +
       "VcoHrrVZwfa65vTl1YeutlPO6sXV97/piScl+vvgnfXqtIzlZ272becVhryU" +
       "jUM3Xe2bcO6V+4BvTfFdBMdXNoC/sr2U40AkR67jyHz1WqRbK+W29mO489AG" +
       "CCmtVT2c++Axy+s+nAYfACzSvW1WWY5cyrC0VelgpciPnfZV/0OSuDu9+ByA" +
       "+cZ13vXv9UviMKmPHRP3C2nwNCCs7BFOL3zogNxHr5fc87bX+V4/uZ2DRa7k" +
       "6pYv3SxmvXz7hvXb9kcqx8jZWyz0m0ff/YoVtGnaVetcrZ791JWrZ9PLSBp8" +
       "zZXLYVdicVYC/1QaoMfUyO8fE/fpNPjdNKitURyT9o+i9e8nj28jLzhoIx3V" +
       "81bvAqyXNV+2acm5P0mDT/iZ21bb5PibF0L2q2CtLP/lOpTlWXvKct9GWe47" +
       "U5uwqroVk78+RmhfSIO/8DM3gfZPbNYjnvsPBwQ/ex0E70gv3g+gPLQh+NDZ" +
       "N/UvHxP3j2nwRcBNOeCWMQ64fel6K+8RAPPihtvF/zuVt3Ph6gR30hdid3b8" +
       "zC2g8vD9Fa6Hqm9n93qr76sAmOyGYvbMq2/nnmPi7k2D2wE75TC7QxW4c8f1" +
       "sgMt7lx+wy5/9uyed0xc6tHsPOhnLgB2e2vuD1F7zllQq26oVc+eWvaYuFek" +
       "wYvX1NL99LaoveR6qT0AUG7yrn/PllrlmLhqGuTX3sN628AtcoWzcI3qG3L1" +
       "syd3zJsZO6lbvvN1a3LY6k2rxf57HytyX38WnUF3Q6579uToY+LYNGitO4Pe" +
       "/hsTB9za18vtXgCzv+HWP3tu33BM3DelwcDP3Ai4kZtXLw6YDa+D2SrZCwDI" +
       "b9ww+8azZ6YcE5eOQ3amfubuVa2lm5Ndvrj+gKV4vfUHnJNzm90Rzl2xO8L1" +
       "s/SOiQvSAAwlb9/TzfXeo1v1eM33LK7FMDUtb9owfNPZM3z9MXFvTIPEz9y6" +
       "1tAj+b3met2xtAbft+H3vrPn99Zj4r4jDd7sZ54lGrLgHhjPQ67YNV+vuFb1" +
       "3QOQbt4YO3fFG2PXT++7tuK298Hb+e40eIefOW9d6Ym98yzIfWhD7kNnQ+4K" +
       "V/p7r8Xw+9LgyaMZvu96O/YXgSHzs9Z517+nYLj3Fs8x1feBrbirbgBJ7w9z" +
       "D4j/eBr8EEiVEm9ahC0Gpmwd2U/+8PXK4fkA1eMbOTx+9nL4maPlkEb9xAHh" +
       "n02DDwOLuybM2w6VzuBtcf3p6+X6ILjzOzZc33H2XH/pRFw/ngY/DzyfNVem" +
       "ucXyY2dRox/dsPzo2bP8jROx/K00+K/7NbpSXV5Qtrh+8nq5vjiT2b1nnXf9" +
       "e7Zc/+hEXNOpqZ3f8zPPXnNFfeAZTQNfXm3AucX4989gOnO3tmFcO3vGnzsR" +
       "479Ogz/zM7etGa+mA6xt0/Tn10v1YUDxDRuqbzh7qv/rRFS/nAZ/B1ylNVXg" +
       "LV2pxn9/vUwvAoYbV2n3tK7StZnu3nASprvp9nm76fanm0pN95frrfeyvpzv" +
       "7rmzUOKf3fD92bPne9eJ+N6TBrfuK/GoQxGbry0conrbWVD92w3Vvz17qg+d" +
       "iOrz0uCBfarAofCvmOPa/arrpfqSTOb8Zv71/GnnX09A9aUnoppNg4t+5t4N" +
       "VZ5IazXdcX5vR49DlK+5d8W1KD8XUHU2lJ2zp1w6EeX0Ie5uzk+3DBGk9bB8" +
       "iyd8vTzBWO78N294fvPZ89x+HnU0TzwNvhaM6lKeuG2aV/Q5u688A+fp/JMb" +
       "ok+eDdHdVYLVI/nVk/a1iVkx6pyIN50GDeBLpbybEmCdvujublFvnoF3fP7D" +
       "G+ofPhvq22O+3fGJCH9DGvDARU4Jdzd74hyi2j8Ldf74hurHz16d5ROxTBvp" +
       "7uMbdWaaR4zudq+5Gcq1iL4MEPyrDdG/OnuiixMRTaN3DT/zwMaFMuS05R4y" +
       "y1uszTPoc2/4mnXe9e/Zsn7diVi/Pg2i/T4XjAqozRdHDlG95s4oJ7BXN35w" +
       "nXf9e7ZU//mJqL41Db5lf7DX3eyftcX1W89gPHDjn264/unZc33Xibh+Vxq8" +
       "/dB4wFf9eIvpv7pepi/MZC5sHsxcOO2DmRMw/bcnYvq9afAeP/0G3AHTI8a0" +
       "u+89g+HPBX9D1z97uj9yIrofSIMf2B/+7CnxlQ+Dd3/wLKr3iQ3fJ86e70+f" +
       "iO9H0uCDh6o3MOUjzfGHzsAcX/jJDd2fPHu628vLjqabLjTbfRqY47S33f8Q" +
       "1xbV615s9gig+OkN1U+fPdXttVRHU/21NPiEn7lj5ViQVyN7PYul9ryoC1/c" +
       "kP3i2ZPdXoh2NNl0Sdrub2+8qK7p27q8rcC/cwae8U3n13nXv2dL9M+34g68" +
       "5p2fWCX4bBp8ZjNljM+Fbdf/v18HwdX+zK8AxO7fELz/bAhuf9hp9++PkcCX" +
       "0uDzwPaKoBZ9+fAXy1Y1fUD1C6ehCryvWw6+YJh+ju2BKz6Puv6kp/ijT95x" +
       "0/1P9n9rvc/s3mc3b6YyN80Cwzj86aND5zc6rjxTV/RvXoW3r9ZY7v6Tn3n2" +
       "URta+5ldEK7c4X9cpTx/zs/cuZ3Sz9yw+j2c7jxgcpDOz9y4PjmcBPScuyBJ" +
       "enrTamXpr0XrRZYPHKr49QLvu68lxP0sh7/kl+6juvoI7d6ep8H6M7SPiR94" +
       "stV9zRfK37f+kiBw65MkLeUmKnNh/VHDVaHpvqmPXLW0vbJubLz0y7f/2M0v" +
       "2lvSffsa8IESHsL2vKM/20eajr/60F7y4fs/+LXf/+QfrL4W9X8AaMvWQR14" +
       "AAA=");
}
