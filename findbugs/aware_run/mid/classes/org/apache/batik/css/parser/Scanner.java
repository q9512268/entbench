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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1lRk6TaxtGMUtTpjLhiDXXIxFASDQEY2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "vpEf7vy/lkofVEZCAAA=");
}
