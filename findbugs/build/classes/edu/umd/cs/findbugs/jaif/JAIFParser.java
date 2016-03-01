package edu.umd.cs.findbugs.jaif;
public class JAIFParser {
    private final edu.umd.cs.findbugs.jaif.JAIFScanner scanner;
    private final edu.umd.cs.findbugs.jaif.JAIFEvents callback;
    public JAIFParser(java.io.Reader reader, edu.umd.cs.findbugs.jaif.JAIFEvents callback) {
        super(
          );
        this.
          scanner =
          new edu.umd.cs.findbugs.jaif.JAIFScanner(
            reader);
        this.
          callback =
          callback;
    }
    public void parse() throws java.io.IOException, edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        parseAnnotationFile(
          );
    }
    int getLineNumber() { return scanner.getLineNumber();
    }
    private edu.umd.cs.findbugs.jaif.JAIFToken expect(java.lang.String s)
          throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException { edu.umd.cs.findbugs.jaif.JAIFToken t =
                                                         scanner.
                                                         nextToken(
                                                           );
                                                       if (!t.
                                                              lexeme.
                                                             equals(
                                                               s)) {
                                                           throw new edu.umd.cs.findbugs.jaif.JAIFSyntaxException(
                                                             this,
                                                             "Unexpected token " +
                                                             t +
                                                             " (was expecting " +
                                                             s +
                                                             ")");
                                                       }
                                                       return t;
    }
    private edu.umd.cs.findbugs.jaif.JAIFToken expect(edu.umd.cs.findbugs.jaif.JAIFTokenKind kind)
          throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        edu.umd.cs.findbugs.jaif.JAIFToken t =
          scanner.
          nextToken(
            );
        if (t.
              kind !=
              kind) {
            throw new edu.umd.cs.findbugs.jaif.JAIFSyntaxException(
              this,
              "Unexpected token " +
              t +
              " (was expecting a `" +
              kind.
                toString(
                  ) +
              "\' token)");
        }
        return t;
    }
    private void expectEndOfLine() throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        int nlCount =
          0;
        edu.umd.cs.findbugs.jaif.JAIFToken t;
        while (true) {
            if (scanner.
                  atEOF(
                    )) {
                t =
                  null;
                break;
            }
            t =
              scanner.
                peekToken(
                  );
            if (t.
                  kind !=
                  edu.umd.cs.findbugs.jaif.JAIFTokenKind.
                    NEWLINE) {
                break;
            }
            ++nlCount;
            scanner.
              nextToken(
                );
        }
        if (nlCount <
              1) {
            java.lang.String msg =
              t ==
              null
              ? "Unexpected end of file"
              : "Unexpected token " +
            t +
            " (was expecting <newline>)";
            throw new edu.umd.cs.findbugs.jaif.JAIFSyntaxException(
              this,
              msg);
        }
    }
    private java.lang.String readCompoundName()
          throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        java.lang.StringBuilder buf =
          new java.lang.StringBuilder(
          );
        boolean firstToken =
          true;
        while (true) {
            edu.umd.cs.findbugs.jaif.JAIFToken t =
              scanner.
              nextToken(
                );
            assert t.
                     kind ==
              edu.umd.cs.findbugs.jaif.JAIFTokenKind.
                IDENTIFIER_OR_KEYWORD;
            if (firstToken) {
                firstToken =
                  false;
            }
            else
                if (t.
                      lexeme.
                      startsWith(
                        "@")) {
                    throw new edu.umd.cs.findbugs.jaif.JAIFSyntaxException(
                      this,
                      "Illegal compound name (unexpected \'@\' character)");
                }
            buf.
              append(
                t.
                  lexeme);
            t =
              scanner.
                peekToken(
                  );
            if (t.
                  kind !=
                  edu.umd.cs.findbugs.jaif.JAIFTokenKind.
                    DOT) {
                break;
            }
            else {
                buf.
                  append(
                    t.
                      lexeme);
                scanner.
                  nextToken(
                    );
            }
        }
        return buf.
          toString(
            );
    }
    private java.lang.String readType() throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        java.lang.StringBuilder buf =
          new java.lang.StringBuilder(
          );
        expect(
          edu.umd.cs.findbugs.jaif.JAIFTokenKind.
            IDENTIFIER_OR_KEYWORD);
        return buf.
          toString(
            );
    }
    private void parseAnnotationFile() throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        parsePackageDefinition(
          );
        while (!scanner.
                 atEOF(
                   )) {
            parsePackageDefinition(
              );
        }
    }
    private void parsePackageDefinition()
          throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        expect(
          "package");
        edu.umd.cs.findbugs.jaif.JAIFToken t =
          scanner.
          peekToken(
            );
        java.lang.String pkgName;
        if (t.
              kind !=
              edu.umd.cs.findbugs.jaif.JAIFTokenKind.
                NEWLINE) {
            pkgName =
              readCompoundName(
                );
            expect(
              ":");
            t =
              scanner.
                peekToken(
                  );
            while (t.
                     isStartOfAnnotationName(
                       )) {
                parseAnnotation(
                  );
            }
        }
        else {
            pkgName =
              "";
        }
        expectEndOfLine(
          );
        callback.
          startPackageDefinition(
            pkgName);
        while (!scanner.
                 atEOF(
                   )) {
            t =
              scanner.
                peekToken(
                  );
            if ("package".
                  equals(
                    t.
                      lexeme)) {
                break;
            }
            parseAnnotationDefinitionOrClassDefinition(
              );
        }
        callback.
          endPackageDefinition(
            pkgName);
    }
    private void parseAnnotation() throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        java.lang.String annotationName =
          readCompoundName(
            );
        assert annotationName.
          startsWith(
            "@");
        callback.
          startAnnotation(
            annotationName);
        edu.umd.cs.findbugs.jaif.JAIFToken t =
          scanner.
          peekToken(
            );
        if (t.
              kind ==
              edu.umd.cs.findbugs.jaif.JAIFTokenKind.
                LPAREN) {
            parseAnnotationField(
              );
            t =
              scanner.
                peekToken(
                  );
            while (t.
                     kind !=
                     edu.umd.cs.findbugs.jaif.JAIFTokenKind.
                       RPAREN) {
                expect(
                  ",");
                parseAnnotationField(
                  );
                t =
                  scanner.
                    peekToken(
                      );
            }
            assert t.
                     kind ==
              edu.umd.cs.findbugs.jaif.JAIFTokenKind.
                RPAREN;
            scanner.
              nextToken(
                );
        }
        callback.
          endAnnotation(
            annotationName);
    }
    private void parseAnnotationField() throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        edu.umd.cs.findbugs.jaif.JAIFToken id =
          expect(
            edu.umd.cs.findbugs.jaif.JAIFTokenKind.
              IDENTIFIER_OR_KEYWORD);
        expect(
          "=");
        java.lang.Object constant =
          parseConstant(
            );
        callback.
          annotationField(
            id.
              lexeme,
            constant);
    }
    private java.lang.Object parseConstant()
          throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        edu.umd.cs.findbugs.jaif.JAIFToken t =
          scanner.
          peekToken(
            );
        switch (t.
                  kind) {
            case IDENTIFIER_OR_KEYWORD:
                java.lang.String name =
                  readCompoundName(
                    );
                return new edu.umd.cs.findbugs.jaif.JAIFEnumConstant(
                  name);
            case DECIMAL_LITERAL:
                t =
                  scanner.
                    nextToken(
                      );
                return java.lang.Integer.
                  parseInt(
                    t.
                      lexeme);
            case OCTAL_LITERAL:
                t =
                  scanner.
                    nextToken(
                      );
                return java.lang.Integer.
                  parseInt(
                    t.
                      lexeme,
                    8);
            case HEX_LITERAL:
                t =
                  scanner.
                    nextToken(
                      );
                return java.lang.Integer.
                  parseInt(
                    t.
                      lexeme,
                    16);
            case FLOATING_POINT_LITERAL:
                t =
                  scanner.
                    nextToken(
                      );
                boolean isFloat =
                  t.
                    lexeme.
                  toLowerCase(
                    java.util.Locale.
                      ENGLISH).
                  endsWith(
                    "f");
                if (isFloat) {
                    return java.lang.Float.
                      parseFloat(
                        t.
                          lexeme);
                }
                else {
                    return java.lang.Double.
                      parseDouble(
                        t.
                          lexeme);
                }
            case STRING_LITERAL:
                t =
                  scanner.
                    nextToken(
                      );
                return unparseStringLiteral(
                         t.
                           lexeme);
            default:
                throw new edu.umd.cs.findbugs.jaif.JAIFSyntaxException(
                  this,
                  "Illegal constant");
        }
    }
    private java.lang.Object unparseStringLiteral(java.lang.String lexeme) {
        java.lang.StringBuilder buf =
          new java.lang.StringBuilder(
          );
        int where =
          1;
        while (true) {
            assert where <
              lexeme.
              length(
                );
            char c =
              lexeme.
              charAt(
                where);
            if (c ==
                  '\"') {
                break;
            }
            if (c !=
                  '\\') {
                buf.
                  append(
                    c);
                where++;
                continue;
            }
            where++;
            assert where <
              lexeme.
              length(
                );
            c =
              lexeme.
                charAt(
                  where);
            switch (c) {
                case 'b':
                    buf.
                      append(
                        '\b');
                    where++;
                    break;
                case 't':
                    buf.
                      append(
                        '\t');
                    where++;
                    break;
                case 'n':
                    buf.
                      append(
                        '\n');
                    where++;
                    break;
                case 'f':
                    buf.
                      append(
                        '\t');
                    where++;
                    break;
                case 'r':
                    buf.
                      append(
                        '\r');
                    where++;
                    break;
                case '\"':
                    buf.
                      append(
                        '\"');
                    where++;
                    break;
                case '\'':
                    buf.
                      append(
                        '\'');
                    where++;
                    break;
                case '\\':
                    buf.
                      append(
                        '\\');
                    where++;
                    break;
                default:
                    char value =
                      (char)
                        0;
                    while (c >=
                             '0' &&
                             c <=
                             '7') {
                        value *=
                          8;
                        value +=
                          c -
                            '0';
                        where++;
                        assert where <
                          lexeme.
                          length(
                            );
                        c =
                          lexeme.
                            charAt(
                              where);
                    }
                    buf.
                      append(
                        value);
            }
        }
        return buf.
          toString(
            );
    }
    private void parseAnnotationDefinitionOrClassDefinition()
          throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        edu.umd.cs.findbugs.jaif.JAIFToken t =
          scanner.
          peekToken(
            );
        if ("annotation".
              equals(
                t.
                  lexeme)) {
            parseAnnotationDefinition(
              );
        }
        else
            if ("class".
                  equals(
                    t.
                      lexeme)) {
                parseClassDefinition(
                  );
            }
            else {
                throw new edu.umd.cs.findbugs.jaif.JAIFSyntaxException(
                  this,
                  "Unexpected token " +
                  t +
                  " (expected `annotation\' or `class\')");
            }
    }
    private void parseAnnotationDefinition()
          throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        expect(
          "annotation");
        java.lang.String retention =
          null;
        edu.umd.cs.findbugs.jaif.JAIFToken t =
          scanner.
          peekToken(
            );
        if ("visible".
              equals(
                t.
                  lexeme) ||
              "invisible".
              equals(
                t.
                  lexeme) ||
              "source".
              equals(
                t.
                  lexeme)) {
            retention =
              t.
                lexeme;
            scanner.
              nextToken(
                );
        }
        java.lang.String annotationName =
          expect(
            edu.umd.cs.findbugs.jaif.JAIFTokenKind.
              IDENTIFIER_OR_KEYWORD).
            lexeme;
        expect(
          edu.umd.cs.findbugs.jaif.JAIFTokenKind.
            COLON);
        expectEndOfLine(
          );
        callback.
          startAnnotationDefinition(
            annotationName,
            retention);
        t =
          scanner.
            peekToken(
              );
        while (t.
                 kind !=
                 edu.umd.cs.findbugs.jaif.JAIFTokenKind.
                   NEWLINE) {
            parseAnnotationFieldDefinition(
              );
        }
    }
    private void parseAnnotationFieldDefinition()
          throws java.io.IOException,
        edu.umd.cs.findbugs.jaif.JAIFSyntaxException {
        java.lang.String type =
          readType(
            );
        java.lang.String fieldName =
          expect(
            edu.umd.cs.findbugs.jaif.JAIFTokenKind.
              IDENTIFIER_OR_KEYWORD).
            lexeme;
        callback.
          annotationFieldDefinition(
            type,
            fieldName);
    }
    private void parseClassDefinition() {
        
    }
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { if (args.
                                             length !=
                                             1) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "Usage: " +
                                               edu.umd.cs.findbugs.jaif.JAIFParser.class.
                                                 getName(
                                                   ) +
                                               " <jaif file>");
                                           java.lang.System.
                                             exit(
                                               1);
                                       }
                                       edu.umd.cs.findbugs.jaif.JAIFEvents callback =
                                         new edu.umd.cs.findbugs.jaif.JAIFEvents(
                                         ) {
                                           @java.lang.Override
                                           public void annotationField(java.lang.String fieldName,
                                                                       java.lang.Object constant) {
                                               java.lang.System.
                                                 out.
                                                 println(
                                                   "    " +
                                                   fieldName +
                                                   "=" +
                                                   constant);
                                           }
                                           @java.lang.Override
                                           public void endAnnotation(java.lang.String annotationName) {
                                               
                                           }
                                           @java.lang.Override
                                           public void endPackageDefinition(java.lang.String pkgName) {
                                               
                                           }
                                           @java.lang.Override
                                           public void startAnnotation(java.lang.String annotationName) {
                                               java.lang.System.
                                                 out.
                                                 println(
                                                   "  annotation " +
                                                   annotationName);
                                           }
                                           @java.lang.Override
                                           public void startPackageDefinition(java.lang.String pkgName) {
                                               java.lang.System.
                                                 out.
                                                 println(
                                                   "package " +
                                                   pkgName);
                                           }
                                           @java.lang.Override
                                           public void startAnnotationDefinition(java.lang.String annotationName,
                                                                                 java.lang.String retention) {
                                               java.lang.System.
                                                 out.
                                                 println(
                                                   "  annotation " +
                                                   annotationName +
                                                   " " +
                                                   retention);
                                           }
                                           @java.lang.Override
                                           public void endAnnotationDefinition(java.lang.String annotationName) {
                                               
                                           }
                                           @java.lang.Override
                                           public void annotationFieldDefinition(java.lang.String type,
                                                                                 java.lang.String fieldName) {
                                               java.lang.System.
                                                 out.
                                                 println(
                                                   "    " +
                                                   type +
                                                   " " +
                                                   fieldName);
                                           }
                                       };
                                       edu.umd.cs.findbugs.jaif.JAIFParser parser =
                                         new edu.umd.cs.findbugs.jaif.JAIFParser(
                                         edu.umd.cs.findbugs.charsets.UTF8.
                                           fileReader(
                                             args[0]),
                                         callback);
                                       parser.
                                         parse(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "v+Lbk/8D3MMfOXouAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7e7Dj1nkf7tVqtVpL2tXDkqJI8lpa2ZboXoAEwUdlOyZB" +
       "AHwABEiCL7jKGm+CeL9IkK5qxX1YEyeOW8uOO43Vf+y09Sh2pk2mmbTpKO00" +
       "cSapJ/F4Wicztd1OH2kcz1jt1M3YTdIDkPfy3rsPrWa3nMFH4Dy/33e+7zsH" +
       "53x47XvQnWEA5TzXWumWGx2oSXQwt7CDaOWp4UGbxjgxCFUFt8Qw5EHaFfmp" +
       "X77wgx99anZxHzorQA+KjuNGYmS4TthXQ9daqAoNXdilEpZqhxF0kZ6LCxGO" +
       "I8OCaSOMnqehtx2rGkGX6UMWYMACDFiAMxbg2q4UqHSv6sQ2ntYQnSj0ob8B" +
       "7dHQWU9O2Yugd55sxBMD0d42w2UIQAvn0ucRAJVVTgLo0hH2DearAH8mB7/y" +
       "8z958Z/eAV0QoAuGM0jZkQETEehEgO6xVVtSg7CmKKoiQPc7qqoM1MAQLWOd" +
       "8S1AD4SG7ohRHKhHQkoTY08Nsj53krtHTrEFsRy5wRE8zVAt5fDpTs0SdYD1" +
       "4R3WDUIyTQcAzxuAsUATZfWwyhnTcJQIesfpGkcYL3dAAVD1LluNZu5RV2cc" +
       "ESRAD2zGzhIdHR5EgeHooOidbgx6iaDHrttoKmtPlE1RV69E0KOny3GbLFDq" +
       "7kwQaZUIevvpYllLYJQeOzVKx8bne933ffIjTtPZz3hWVNlK+T8HKj15qlJf" +
       "1dRAdWR1U/Ge5+jPig//xsv7EAQKv/1U4U2Zf/7X3/jge598/aubMj9+jTKs" +
       "NFfl6Ir8Bem+P3gcf7Z6R8rGOc8NjXTwTyDP1J/b5jyfeMDyHj5qMc08OMx8" +
       "vf9b05e+pH53Hzrfgs7KrhXbQI/ul13bMyw1oFRHDcRIVVrQ3aqj4Fl+C7oL" +
       "3NOGo25SWU0L1agFnbGypLNu9gxEpIEmUhHdBe4NR3MP7z0xmmX3iQdB0F3g" +
       "gu4B12Vo88v+I0iAZ66twqIsOobjwlzgpvhDWHUiCch2BmtAmaRYD+EwkOFM" +
       "dVQlhmNbgeVwlzkXDQ1u11pkZm/BQVrQ+//aepJiu7jc2wNif/y00VvAXpqu" +
       "pajBFfmVuE688eUrv7t/ZARbqUTQ06CzA9DZgRweHHZ2kHZ2sOsM2tvL+ngo" +
       "7XQzrGBQTGDewPHd8+zghfaHX37qDqBP3vIMkGhaFL6+/8V3DqGVuT0ZaCX0" +
       "+ueWPzX6KLIP7Z90pCmjIOl8Wp1L3d+Rm7t82oCu1e6Fj//xD77y2RfdnSmd" +
       "8MxbC7+6ZmqhT50WaeDKQFqBumv+uUvir175jRcv70NngNkDVxeJQDWBF3ny" +
       "dB8nLPX5Q6+XYrkTANbcwBatNOvQVZ2PZoG73KVkY31fdn8/kPHbUtV9O7ie" +
       "3epy9p/mPuil9KGNbqSDdgpF5lXfP/A+/82v/Q80E/ehA75wbEobqNHzx4w+" +
       "bexCZt7373SAD1QVlPuPn+M+/ZnvffxDmQKAEk9fq8PLKcWBsYMhBGL+21/1" +
       "//Db3/rCN/Z3ShOBWS+WLENOjkCm6dD5G4AEvb1rxw9wGhYwrVRrLg8d21UM" +
       "zRAlS0219P9eeCb/q3/6yYsbPbBAyqEavffNG9il/1gdeul3f/L/PJk1syen" +
       "k9ZOZrtiG0/44K7lWhCIq5SP5Ke+/sTf/23x88CnAj8WGms1c037mQz2M+Rv" +
       "j6D7spqGC/y7CAz4MPnGtkosgEsJs3GHsxrPZfQglVnWPJTlYSl5R3jcfk6a" +
       "6LH1yRX5U9/4/r2j7/+rNzLAJxc4x9WFEb3nNxqakksJaP6R086iKYYzUK74" +
       "evevXbRe/xFoUQAtymBWD9kAoExOKNe29J13/dFv/puHP/wHd0D7JHTeckWF" +
       "FDM7he4GBqKGM+DhEu8nPrjRj+U5QC5mUKGrwG/06tHsKV0iPnt9F0Wm65Od" +
       "lT/6Q9aSPvaf/+wqIWTO6RrT8qn6AvzaLzyGf+C7Wf2dl0hrP5lc7brBWm5X" +
       "t/Al+3/vP3X23+5DdwnQRXm7UByJVpzangAWR+Hh6hEsJk/kn1zobGb154+8" +
       "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" +
       "mqqzE8cv3g5xfGArjg/cVnEc4nnXm+NJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nVrW1K/dlOD+ZUr+2ZHg0qcv70TyK7cgkjR8CHoKXORWJOTtEclxzf+tm8L4" +
       "1ZT8ZgRd2GAk0vCo1E7S5E/twP7rWwD7YJr4NLjkLVj59oP9+k2B/UZK/l0E" +
       "XQxUUUnPI93YUbrbSeCFHdqv3SraHwfXS1u0L91+tN+6KbTfSckfRtC5FO3h" +
       "xHYM5R/dqgKnR9U/s0X5M7cf5Z/cFMo/Tcl/BdNjNpHtok7IbTDfMSX+b7cK" +
       "OA0c+vQW8KdvP+Af3BTgP0vJGxH0cAZ4Gy7aUIHLO4qxOob5f94OL/XrW8y/" +
       "ftsx7+3fDOa9M+ntnwMvdWqQT4H9i1sFmwZc/P4W7O/ffrD33RTYiym5O4Ie" +
       "ukqjVUs5iXjv/K16qkvg+uYW8TdvP+LHbgrx4ykBU/i9GeITYewno0M20Uc7" +
       "+A/fKvx0wH+4hf/D2wP/9Cpt7z03kM9zKXkajHXsZNg34S+0EamBmIZr7z25" +
       "A3v5VrX7/YCt+qbu5v/2jnXxpsY6gwJH4IXxpHbvPBgbZK+h13Npe8ityuG9" +
       "AFJ3K4fu7ZfDB29KDvWUPB9BP3ZdOZyC/b5bhZ0HCLQtbO32w6ZvCnY3JVQE" +
       "PXkt53Zd7M3b4Nj37C12+/Zjn9wgT0jJ4NCd31i1+VvAmUUPPpexvMHpvwWc" +
       "2TBtNqpu+K4VQM9cf6MnC0/eRKS9+otPf+2jrz79n7Lw3HNGOBKDWqBf43uV" +
       "Y3W+/9q3v/v1e5/4chYFf0YSw81OzOkPfa7+jufE5zkZ+/ccSeWhVAiPpbxD" +
       "W7GkJIKuXB3x+Vcv+bEYGn7sRup7NkHklzbBjJeyMNJLG+f8oRcuMWyDuNKt" +
       "McTg0vsvOepym/MR0ZZe/NDBwcELzz/reRkjL1wlwfQ5jWrbm22jOffMNxuS" +
       "o23Ds5bq6JtvUf5hWlP3ktPmdjhpPribNHHLddQ0AP0w76HDnaSjz7FAZnJN" +
       "Tl/acJp1tmEzJc+8mT0kN8hbpySOoDvllK8NjBsUfzHZ/CvX0cir8Z7Y6Nr7" +
       "aEquRNAZWzROm9uH34q5JRF0fvcxSxqZ/+hVX8htvuqSv/zqhXOPvDr8DxtN" +
       "Pvzy6m4aOqfFlnU8CvrY/VkvAG4hG+q7NzHRmQrtvRxBj15vawPASv9SXvc+" +
       "vin+CSCLaxQHr4GHt8dLfxKA2pWOoH35RPbfjaC7ttkRdAegxzNfAUkgM739" +
       "TKbITyab4Xj0uIPKFuYPvJmgj+1JP33CwWTfKh7u+sabrxWvyF95td39yBul" +
       "L24+PJEtcZ1qFXQO+ILNNzBbX3A8pvV0a4dtnW0++6P7fvnuZw53ue/bMLxz" +
       "lsd4e8e1v/IgbC/KvstY/9ojv/K+f/Tqt7Io4v8HlZVQmEQ6AAA=");
}
