package org.apache.batik.css.parser;
public class Scanner {
    protected org.apache.batik.util.io.NormalizingReader reader;
    protected int current;
    protected char[] buffer = new char[128];
    protected int position;
    protected int type;
    protected int start;
    protected int end;
    protected int blankCharacters;
    public Scanner(java.io.Reader r) throws org.apache.batik.css.parser.ParseException {
        super(
          );
        try {
            reader =
              new org.apache.batik.util.io.StreamNormalizingReader(
                r);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    public Scanner(java.io.InputStream is, java.lang.String enc) throws org.apache.batik.css.parser.ParseException {
        super(
          );
        try {
            reader =
              new org.apache.batik.util.io.StreamNormalizingReader(
                is,
                enc);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    public Scanner(java.lang.String s) throws org.apache.batik.css.parser.ParseException {
        super(
          );
        try {
            reader =
              new org.apache.batik.util.io.StringNormalizingReader(
                s);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    public int getLine() { return reader.getLine(
                                           ); }
    public int getColumn() { return reader.getColumn(
                                             ); }
    public char[] getBuffer() { return buffer; }
    public int getStart() { return start; }
    public int getEnd() { return end; }
    public void clearBuffer() { if (position <= 0) {
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
    public int getType() { return type; }
    public java.lang.String getStringValue() { return new java.lang.String(
                                                 buffer,
                                                 start,
                                                 end -
                                                   start);
    }
    public void scanAtRule() throws org.apache.batik.css.parser.ParseException {
        try {
            loop: for (;
                       ;
                       ) {
                switch (current) {
                    case '{':
                        int brackets =
                          1;
                        for (;
                             ;
                             ) {
                            nextChar(
                              );
                            switch (current) {
                                case '}':
                                    if (--brackets >
                                          0) {
                                        break;
                                    }
                                case -1:
                                    break loop;
                                case '{':
                                    brackets++;
                            }
                        }
                    case -1:
                    case ';':
                        break loop;
                }
                nextChar(
                  );
            }
            end =
              position;
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    public int next() throws org.apache.batik.css.parser.ParseException {
        blankCharacters =
          0;
        start =
          position -
            1;
        nextToken(
          );
        end =
          position -
            endGap(
              );
        return type;
    }
    protected int endGap() { int result = current ==
                               -1
                               ? 0
                               : 1;
                             switch (type) { case org.apache.batik.css.parser.LexicalUnits.
                                                    FUNCTION:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    STRING:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    S:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    PERCENTAGE:
                                                 result +=
                                                   1;
                                                 break;
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    COMMENT:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    HZ:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    EM:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    EX:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    PC:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    PT:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    PX:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    CM:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    MM:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    IN:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    MS:
                                                 result +=
                                                   2;
                                                 break;
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    KHZ:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    DEG:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    RAD:
                                                 result +=
                                                   3;
                                                 break;
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    GRAD:
                                                 result +=
                                                   4;
                             }
                             return result +
                               blankCharacters;
    }
    protected void nextToken() throws org.apache.batik.css.parser.ParseException {
        try {
            switch (current) {
                case -1:
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        EOF;
                    return;
                case '{':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        LEFT_CURLY_BRACE;
                    return;
                case '}':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        RIGHT_CURLY_BRACE;
                    return;
                case '=':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        EQUAL;
                    return;
                case '+':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        PLUS;
                    return;
                case ',':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        COMMA;
                    return;
                case ';':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        SEMI_COLON;
                    return;
                case '>':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        PRECEDE;
                    return;
                case '[':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        LEFT_BRACKET;
                    return;
                case ']':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        RIGHT_BRACKET;
                    return;
                case '*':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        ANY;
                    return;
                case '(':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        LEFT_BRACE;
                    return;
                case ')':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        RIGHT_BRACE;
                    return;
                case ':':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        COLON;
                    return;
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                case '\f':
                    do  {
                        nextChar(
                          );
                    }while(org.apache.batik.css.parser.ScannerUtilities.
                             isCSSSpace(
                               (char)
                                 current)); 
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        SPACE;
                    return;
                case '/':
                    nextChar(
                      );
                    if (current !=
                          '*') {
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            DIVIDE;
                        return;
                    }
                    nextChar(
                      );
                    start =
                      position -
                        1;
                    do  {
                        while (current !=
                                 -1 &&
                                 current !=
                                 '*') {
                            nextChar(
                              );
                        }
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 current ==
                                 '*'); 
                    }while(current !=
                             -1 &&
                             current !=
                             '/'); 
                    if (current ==
                          -1) {
                        throw new org.apache.batik.css.parser.ParseException(
                          "eof",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        COMMENT;
                    return;
                case '\'':
                    type =
                      string1(
                        );
                    return;
                case '\"':
                    type =
                      string2(
                        );
                    return;
                case '<':
                    nextChar(
                      );
                    if (current !=
                          '!') {
                        throw new org.apache.batik.css.parser.ParseException(
                          "character",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
                    nextChar(
                      );
                    if (current ==
                          '-') {
                        nextChar(
                          );
                        if (current ==
                              '-') {
                            nextChar(
                              );
                            type =
                              org.apache.batik.css.parser.LexicalUnits.
                                CDO;
                            return;
                        }
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '-':
                    nextChar(
                      );
                    if (current !=
                          '-') {
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            MINUS;
                        return;
                    }
                    nextChar(
                      );
                    if (current ==
                          '>') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            CDC;
                        return;
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '|':
                    nextChar(
                      );
                    if (current ==
                          '=') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            DASHMATCH;
                        return;
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '~':
                    nextChar(
                      );
                    if (current ==
                          '=') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            INCLUDES;
                        return;
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '#':
                    nextChar(
                      );
                    if (org.apache.batik.css.parser.ScannerUtilities.
                          isCSSNameCharacter(
                            (char)
                              current)) {
                        start =
                          position -
                            1;
                        do  {
                            nextChar(
                              );
                            while (current ==
                                     '\\') {
                                nextChar(
                                  );
                                escape(
                                  );
                            }
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.css.parser.ScannerUtilities.
                                 isCSSNameCharacter(
                                   (char)
                                     current)); 
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            HASH;
                        return;
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '@':
                    nextChar(
                      );
                    switch (current) {
                        case 'c':
                        case 'C':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'h') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'a') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'r') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    's') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'e') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    't')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    CHARSET_SYMBOL;
                                return;
                            }
                            break;
                        case 'f':
                        case 'F':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'o') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'n') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    't') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    '-') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'f') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'a') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'c') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'e')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    FONT_FACE_SYMBOL;
                                return;
                            }
                            break;
                        case 'i':
                        case 'I':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'm') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'p') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'o') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'r') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    't')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    IMPORT_SYMBOL;
                                return;
                            }
                            break;
                        case 'm':
                        case 'M':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'e') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'd') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'i') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'a')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    MEDIA_SYMBOL;
                                return;
                            }
                            break;
                        case 'p':
                        case 'P':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'a') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'g') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'e')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    PAGE_SYMBOL;
                                return;
                            }
                            break;
                        default:
                            if (!org.apache.batik.css.parser.ScannerUtilities.
                                  isCSSIdentifierStartCharacter(
                                    (char)
                                      current)) {
                                throw new org.apache.batik.css.parser.ParseException(
                                  "identifier.character",
                                  reader.
                                    getLine(
                                      ),
                                  reader.
                                    getColumn(
                                      ));
                            }
                            start =
                              position -
                                1;
                    }
                    do  {
                        nextChar(
                          );
                        while (current ==
                                 '\\') {
                            nextChar(
                              );
                            escape(
                              );
                        }
                    }while(current !=
                             -1 &&
                             org.apache.batik.css.parser.ScannerUtilities.
                             isCSSNameCharacter(
                               (char)
                                 current)); 
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        AT_KEYWORD;
                    return;
                case '!':
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.css.parser.ScannerUtilities.
                             isCSSSpace(
                               (char)
                                 current)); 
                    if (isEqualIgnoreCase(
                          current,
                          'i') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'm') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'p') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'o') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'r') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            't') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'a') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'n') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            't')) {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            IMPORTANT_SYMBOL;
                        return;
                    }
                    if (current ==
                          -1) {
                        throw new org.apache.batik.css.parser.ParseException(
                          "eof",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
                    else {
                        throw new org.apache.batik.css.parser.ParseException(
                          "character",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
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
                    type =
                      number(
                        );
                    return;
                case '.':
                    switch (nextChar(
                              )) {
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
                            type =
                              dotNumber(
                                );
                            return;
                        default:
                            type =
                              org.apache.batik.css.parser.LexicalUnits.
                                DOT;
                            return;
                    }
                case 'u':
                case 'U':
                    nextChar(
                      );
                    switch (current) {
                        case '+':
                            boolean range =
                              false;
                            for (int i =
                                   0;
                                 i <
                                   6;
                                 i++) {
                                nextChar(
                                  );
                                switch (current) {
                                    case '?':
                                        range =
                                          true;
                                        break;
                                    default:
                                        if (range &&
                                              !org.apache.batik.css.parser.ScannerUtilities.
                                              isCSSHexadecimalCharacter(
                                                (char)
                                                  current)) {
                                            throw new org.apache.batik.css.parser.ParseException(
                                              "character",
                                              reader.
                                                getLine(
                                                  ),
                                              reader.
                                                getColumn(
                                                  ));
                                        }
                                }
                            }
                            nextChar(
                              );
                            if (range) {
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    UNICODE_RANGE;
                                return;
                            }
                            if (current ==
                                  '-') {
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    throw new org.apache.batik.css.parser.ParseException(
                                      "character",
                                      reader.
                                        getLine(
                                          ),
                                      reader.
                                        getColumn(
                                          ));
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    UNICODE_RANGE;
                                return;
                            }
                        case 'r':
                        case 'R':
                            nextChar(
                              );
                            switch (current) {
                                case 'l':
                                case 'L':
                                    nextChar(
                                      );
                                    switch (current) {
                                        case '(':
                                            do  {
                                                nextChar(
                                                  );
                                            }while(current !=
                                                     -1 &&
                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                     isCSSSpace(
                                                       (char)
                                                         current)); 
                                            switch (current) {
                                                case '\'':
                                                    string1(
                                                      );
                                                    blankCharacters +=
                                                      2;
                                                    while (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSSpace(
                                                               (char)
                                                                 current)) {
                                                        blankCharacters++;
                                                        nextChar(
                                                          );
                                                    }
                                                    if (current ==
                                                          -1) {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "eof",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    if (current !=
                                                          ')') {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "character",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    nextChar(
                                                      );
                                                    type =
                                                      org.apache.batik.css.parser.LexicalUnits.
                                                        URI;
                                                    return;
                                                case '\"':
                                                    string2(
                                                      );
                                                    blankCharacters +=
                                                      2;
                                                    while (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSSpace(
                                                               (char)
                                                                 current)) {
                                                        blankCharacters++;
                                                        nextChar(
                                                          );
                                                    }
                                                    if (current ==
                                                          -1) {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "eof",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    if (current !=
                                                          ')') {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "character",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    nextChar(
                                                      );
                                                    type =
                                                      org.apache.batik.css.parser.LexicalUnits.
                                                        URI;
                                                    return;
                                                case ')':
                                                    throw new org.apache.batik.css.parser.ParseException(
                                                      "character",
                                                      reader.
                                                        getLine(
                                                          ),
                                                      reader.
                                                        getColumn(
                                                          ));
                                                default:
                                                    if (!org.apache.batik.css.parser.ScannerUtilities.
                                                          isCSSURICharacter(
                                                            (char)
                                                              current)) {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "character",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    start =
                                                      position -
                                                        1;
                                                    do  {
                                                        nextChar(
                                                          );
                                                    }while(current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSURICharacter(
                                                               (char)
                                                                 current)); 
                                                    blankCharacters++;
                                                    while (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSSpace(
                                                               (char)
                                                                 current)) {
                                                        blankCharacters++;
                                                        nextChar(
                                                          );
                                                    }
                                                    if (current ==
                                                          -1) {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "eof",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    if (current !=
                                                          ')') {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "character",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    nextChar(
                                                      );
                                                    type =
                                                      org.apache.batik.css.parser.LexicalUnits.
                                                        URI;
                                                    return;
                                            }
                                    }
                            }
                    }
                    while (current !=
                             -1 &&
                             org.apache.batik.css.parser.ScannerUtilities.
                             isCSSNameCharacter(
                               (char)
                                 current)) {
                        nextChar(
                          );
                    }
                    if (current ==
                          '(') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            FUNCTION;
                        return;
                    }
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        IDENTIFIER;
                    return;
                default:
                    if (current ==
                          '\\') {
                        do  {
                            nextChar(
                              );
                            escape(
                              );
                        }while(current ==
                                 '\\'); 
                    }
                    else
                        if (!org.apache.batik.css.parser.ScannerUtilities.
                              isCSSIdentifierStartCharacter(
                                (char)
                                  current)) {
                            nextChar(
                              );
                            throw new org.apache.batik.css.parser.ParseException(
                              "identifier.character",
                              reader.
                                getLine(
                                  ),
                              reader.
                                getColumn(
                                  ));
                        }
                    while (current !=
                             -1 &&
                             org.apache.batik.css.parser.ScannerUtilities.
                             isCSSNameCharacter(
                               (char)
                                 current)) {
                        nextChar(
                          );
                        while (current ==
                                 '\\') {
                            nextChar(
                              );
                            escape(
                              );
                        }
                    }
                    if (current ==
                          '(') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            FUNCTION;
                        return;
                    }
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        IDENTIFIER;
                    return;
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    protected int string1() throws java.io.IOException {
        start =
          position;
        loop: for (;
                   ;
                   ) {
            switch (nextChar(
                      )) {
                case -1:
                    throw new org.apache.batik.css.parser.ParseException(
                      "eof",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '\'':
                    break loop;
                case '\"':
                    break;
                case '\\':
                    switch (nextChar(
                              )) {
                        case '\n':
                        case '\f':
                            break;
                        default:
                            escape(
                              );
                    }
                    break;
                default:
                    if (!org.apache.batik.css.parser.ScannerUtilities.
                          isCSSStringCharacter(
                            (char)
                              current)) {
                        throw new org.apache.batik.css.parser.ParseException(
                          "character",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
            }
        }
        nextChar(
          );
        return org.apache.batik.css.parser.LexicalUnits.
                 STRING;
    }
    protected int string2() throws java.io.IOException {
        start =
          position;
        loop: for (;
                   ;
                   ) {
            switch (nextChar(
                      )) {
                case -1:
                    throw new org.apache.batik.css.parser.ParseException(
                      "eof",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '\'':
                    break;
                case '\"':
                    break loop;
                case '\\':
                    switch (nextChar(
                              )) {
                        case '\n':
                        case '\f':
                            break;
                        default:
                            escape(
                              );
                    }
                    break;
                default:
                    if (!org.apache.batik.css.parser.ScannerUtilities.
                          isCSSStringCharacter(
                            (char)
                              current)) {
                        throw new org.apache.batik.css.parser.ParseException(
                          "character",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
            }
        }
        nextChar(
          );
        return org.apache.batik.css.parser.LexicalUnits.
                 STRING;
    }
    protected int number() throws java.io.IOException {
        loop: for (;
                   ;
                   ) {
            switch (nextChar(
                      )) {
                case '.':
                    switch (nextChar(
                              )) {
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
                            return dotNumber(
                                     );
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
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
            }
        }
        return numberUnit(
                 true);
    }
    protected int dotNumber() throws java.io.IOException {
        loop: for (;
                   ;
                   ) {
            switch (nextChar(
                      )) {
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
            }
        }
        return numberUnit(
                 false);
    }
    protected int numberUnit(boolean integer)
          throws java.io.IOException { switch (current) {
                                           case '%':
                                               nextChar(
                                                 );
                                               return org.apache.batik.css.parser.LexicalUnits.
                                                        PERCENTAGE;
                                           case 'c':
                                           case 'C':
                                               switch (nextChar(
                                                         )) {
                                                   case 'm':
                                                   case 'M':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                CM;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'd':
                                           case 'D':
                                               switch (nextChar(
                                                         )) {
                                                   case 'e':
                                                   case 'E':
                                                       switch (nextChar(
                                                                 )) {
                                                           case 'g':
                                                           case 'G':
                                                               nextChar(
                                                                 );
                                                               if (current !=
                                                                     -1 &&
                                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                                     isCSSNameCharacter(
                                                                       (char)
                                                                         current)) {
                                                                   do  {
                                                                       nextChar(
                                                                         );
                                                                   }while(current !=
                                                                            -1 &&
                                                                            org.apache.batik.css.parser.ScannerUtilities.
                                                                            isCSSNameCharacter(
                                                                              (char)
                                                                                current)); 
                                                                   return org.apache.batik.css.parser.LexicalUnits.
                                                                            DIMENSION;
                                                               }
                                                               return org.apache.batik.css.parser.LexicalUnits.
                                                                        DEG;
                                                       }
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'e':
                                           case 'E':
                                               switch (nextChar(
                                                         )) {
                                                   case 'm':
                                                   case 'M':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                EM;
                                                   case 'x':
                                                   case 'X':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                EX;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'g':
                                           case 'G':
                                               switch (nextChar(
                                                         )) {
                                                   case 'r':
                                                   case 'R':
                                                       switch (nextChar(
                                                                 )) {
                                                           case 'a':
                                                           case 'A':
                                                               switch (nextChar(
                                                                         )) {
                                                                   case 'd':
                                                                   case 'D':
                                                                       nextChar(
                                                                         );
                                                                       if (current !=
                                                                             -1 &&
                                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                                             isCSSNameCharacter(
                                                                               (char)
                                                                                 current)) {
                                                                           do  {
                                                                               nextChar(
                                                                                 );
                                                                           }while(current !=
                                                                                    -1 &&
                                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                                    isCSSNameCharacter(
                                                                                      (char)
                                                                                        current)); 
                                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                                    DIMENSION;
                                                                       }
                                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                                GRAD;
                                                               }
                                                       }
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'h':
                                           case 'H':
                                               nextChar(
                                                 );
                                               switch (current) {
                                                   case 'z':
                                                   case 'Z':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                HZ;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'i':
                                           case 'I':
                                               switch (nextChar(
                                                         )) {
                                                   case 'n':
                                                   case 'N':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                IN;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'k':
                                           case 'K':
                                               switch (nextChar(
                                                         )) {
                                                   case 'h':
                                                   case 'H':
                                                       switch (nextChar(
                                                                 )) {
                                                           case 'z':
                                                           case 'Z':
                                                               nextChar(
                                                                 );
                                                               if (current !=
                                                                     -1 &&
                                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                                     isCSSNameCharacter(
                                                                       (char)
                                                                         current)) {
                                                                   do  {
                                                                       nextChar(
                                                                         );
                                                                   }while(current !=
                                                                            -1 &&
                                                                            org.apache.batik.css.parser.ScannerUtilities.
                                                                            isCSSNameCharacter(
                                                                              (char)
                                                                                current)); 
                                                                   return org.apache.batik.css.parser.LexicalUnits.
                                                                            DIMENSION;
                                                               }
                                                               return org.apache.batik.css.parser.LexicalUnits.
                                                                        KHZ;
                                                       }
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'm':
                                           case 'M':
                                               switch (nextChar(
                                                         )) {
                                                   case 'm':
                                                   case 'M':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                MM;
                                                   case 's':
                                                   case 'S':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                MS;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'p':
                                           case 'P':
                                               switch (nextChar(
                                                         )) {
                                                   case 'c':
                                                   case 'C':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                PC;
                                                   case 't':
                                                   case 'T':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                PT;
                                                   case 'x':
                                                   case 'X':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                PX;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'r':
                                           case 'R':
                                               switch (nextChar(
                                                         )) {
                                                   case 'a':
                                                   case 'A':
                                                       switch (nextChar(
                                                                 )) {
                                                           case 'd':
                                                           case 'D':
                                                               nextChar(
                                                                 );
                                                               if (current !=
                                                                     -1 &&
                                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                                     isCSSNameCharacter(
                                                                       (char)
                                                                         current)) {
                                                                   do  {
                                                                       nextChar(
                                                                         );
                                                                   }while(current !=
                                                                            -1 &&
                                                                            org.apache.batik.css.parser.ScannerUtilities.
                                                                            isCSSNameCharacter(
                                                                              (char)
                                                                                current)); 
                                                                   return org.apache.batik.css.parser.LexicalUnits.
                                                                            DIMENSION;
                                                               }
                                                               return org.apache.batik.css.parser.LexicalUnits.
                                                                        RAD;
                                                       }
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 's':
                                           case 'S':
                                               nextChar(
                                                 );
                                               return org.apache.batik.css.parser.LexicalUnits.
                                                        S;
                                           default:
                                               if (current !=
                                                     -1 &&
                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                     isCSSIdentifierStartCharacter(
                                                       (char)
                                                         current)) {
                                                   do  {
                                                       nextChar(
                                                         );
                                                   }while(current !=
                                                            -1 &&
                                                            org.apache.batik.css.parser.ScannerUtilities.
                                                            isCSSNameCharacter(
                                                              (char)
                                                                current)); 
                                                   return org.apache.batik.css.parser.LexicalUnits.
                                                            DIMENSION;
                                               }
                                               return integer
                                                 ? org.apache.batik.css.parser.LexicalUnits.
                                                     INTEGER
                                                 : org.apache.batik.css.parser.LexicalUnits.
                                                     REAL;
                                       } }
    protected void escape() throws java.io.IOException {
        if (org.apache.batik.css.parser.ScannerUtilities.
              isCSSHexadecimalCharacter(
                (char)
                  current)) {
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
        }
        if (current >=
              ' ' &&
              current <=
              '~' ||
              current >=
              128) {
            nextChar(
              );
            return;
        }
        throw new org.apache.batik.css.parser.ParseException(
          "character",
          reader.
            getLine(
              ),
          reader.
            getColumn(
              ));
    }
    protected static boolean isEqualIgnoreCase(int i,
                                               char c) {
        return i ==
          -1
          ? false
          : java.lang.Character.
          toLowerCase(
            (char)
              i) ==
          c;
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3as3NgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "e2m7NmiRNXM4Lk+DtqL5cDTtjU0+tae9Udcd270YSaN45upWpGgjvDvrGN4E" +
       "4jDOtVpTZkKuS9NSb6ybZtFSiek6WVIsUyyjmsyWGjE6K/VsEo0Gg97Asnlh" +
       "BSuGydUd3ShDcbNCwDXXDks+PI2wUZ8RWNdL+s1yh6yWOsOKKYusvkQkTKBT" +
       "rNKpOyWV1JbTodKcjpllq28qS7DysZhxilOMOuEnTXi8KvMhmrhxvxpQfLE5" +
       "JA1lbhkswhvLVTicaPX5apAOi2EEiJiglrpkV7rkT4aspyW1om1tFlW7D7Eo" +
       "6QYOHnKJl4wmdmmyXk1idcj6pdlsSJtxT21qy2Q99xKg29IYs1R6OLZnfFku" +
       "t2bmNFh1WYNvumXI2ChDhQl1DHdDdFWSvVKLINf+qF+02jiOj2eRzncjatyP" +
       "42KRFDvTfgthKdYb6sOVLcETtGxQxaHiyw46j/q2V1FaS2rMloqcjQ/GVSlh" +
       "WBfpIy0WTFEiiDEpLPnRpKigKO6u5XHQbUzcLllLpe5IaVfbw2LsVhBrVQxc" +
       "a2C3mjasgwjAwEWjPlYVdugVKVRl0iWB4T0sxdDaBlminXhOjiQNH2MyHg3o" +
       "obqcOCo5mqBecxho3epYkki4ofO6YXfknmMMEF9hudSvDImkQsOcIIp2sblp" +
       "dE3QzovTpjRwp3FJbQ8IzHR6WGNubqqKSo/RSpnvt3RCF0YEwncFJCLXRkMb" +
       "UgoEAW0dV4j6otFpL2KGJSeLdkWPYpJbBiOIpieGFSdNQWTmnh7SWJ2KwIql" +
       "jwsbZMF262jVc7WOGDYDp7GxYC/wILghN8R5ddJveDTGtr1KfYap7T7dmodY" +
       "1ymJEt0NG5uiNCamJaGl9RVjpXdmyojmG6uqhiVWyYkrJWxNDEaa4NT9ASvM" +
       "XYpczXiyPaVSYxP2XbrWbE5GWMUtCTZXo91SuoRlf8GxijTTbaFhr+KaIyFI" +
       "bSMCdZaJFK5X8doU7quas9Dpou5RlmHBWIqGjUGsGW7Y5PQu5bZEk+mLogiF" +
       "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" +
       "qlcgqjtCBgsJUoPNMO60MCtkdC0qbcJ4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "funr+WbR/wdOcHJ8XkIAAA==");
}
