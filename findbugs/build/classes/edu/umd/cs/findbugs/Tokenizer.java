package edu.umd.cs.findbugs;
public class Tokenizer {
    private static final java.util.BitSet whiteSpace = new java.util.BitSet(
      );
    static { whiteSpace.set(' ');
             whiteSpace.set('\t');
             whiteSpace.set('\r');
             whiteSpace.set('\f'); }
    private static final java.util.BitSet single = new java.util.BitSet();
    static { single.set('!');
             single.set('%');
             single.set('^');
             single.set('&');
             single.set('*');
             single.set('(');
             single.set(')');
             single.set('-');
             single.set('+');
             single.set('=');
             single.set('[');
             single.set(']');
             single.set('{');
             single.set('}');
             single.set('|');
             single.set(':');
             single.set(';');
             single.set(',');
             single.set('.');
             single.set('<');
             single.set('>');
             single.set('?');
             single.set('~'); }
    private final java.io.PushbackReader reader;
    public Tokenizer(java.io.Reader reader) { super();
                                              this.reader = new java.io.PushbackReader(
                                                              reader);
    }
    public edu.umd.cs.findbugs.Token next() throws java.io.IOException {
        skipWhitespace(
          );
        int c =
          reader.
          read(
            );
        if (c <
              0) {
            return new edu.umd.cs.findbugs.Token(
              edu.umd.cs.findbugs.Token.
                EOF);
        }
        else
            if (c ==
                  '\n') {
                return new edu.umd.cs.findbugs.Token(
                  edu.umd.cs.findbugs.Token.
                    EOL);
            }
            else
                if (c ==
                      '\'' ||
                      c ==
                      '\"') {
                    return munchString(
                             c);
                }
                else
                    if (c ==
                          '/') {
                        return maybeComment(
                                 );
                    }
                    else
                        if (single.
                              get(
                                c)) {
                            return new edu.umd.cs.findbugs.Token(
                              edu.umd.cs.findbugs.Token.
                                SINGLE,
                              java.lang.String.
                                valueOf(
                                  (char)
                                    c));
                        }
                        else {
                            reader.
                              unread(
                                c);
                            return parseWord(
                                     );
                        }
    }
    private void skipWhitespace() throws java.io.IOException { for (;
                                                                    ;
                                                                    ) {
                                                                   int c =
                                                                     reader.
                                                                     read(
                                                                       );
                                                                   if (c <
                                                                         0) {
                                                                       break;
                                                                   }
                                                                   if (!whiteSpace.
                                                                         get(
                                                                           c)) {
                                                                       reader.
                                                                         unread(
                                                                           c);
                                                                       break;
                                                                   }
                                                               }
    }
    private edu.umd.cs.findbugs.Token munchString(int delimiter)
          throws java.io.IOException { final int SCAN = 0;
                                       final int ESCAPE =
                                         1;
                                       final int DONE = 2;
                                       java.lang.StringBuilder result =
                                         new java.lang.StringBuilder(
                                         );
                                       result.append((char)
                                                       delimiter);
                                       int state = SCAN;
                                       while (state != DONE) {
                                           int c =
                                             reader.
                                             read(
                                               );
                                           if (c <
                                                 0) {
                                               break;
                                           }
                                           result.
                                             append(
                                               (char)
                                                 c);
                                           switch (state) {
                                               case SCAN:
                                                   if (c ==
                                                         delimiter) {
                                                       state =
                                                         DONE;
                                                   }
                                                   else
                                                       if (c ==
                                                             '\\') {
                                                           state =
                                                             ESCAPE;
                                                       }
                                                   break;
                                               case ESCAPE:
                                                   state =
                                                     SCAN;
                                                   break;
                                               default:
                                                   break;
                                           }
                                       }
                                       return new edu.umd.cs.findbugs.Token(
                                         edu.umd.cs.findbugs.Token.
                                           STRING,
                                         result.
                                           toString(
                                             )); }
    private edu.umd.cs.findbugs.Token maybeComment() throws java.io.IOException {
        int c =
          reader.
          read(
            );
        if (c ==
              '/') {
            java.lang.StringBuilder result =
              new java.lang.StringBuilder(
              );
            result.
              append(
                "//");
            for (;
                 ;
                 ) {
                c =
                  reader.
                    read(
                      );
                if (c <
                      0) {
                    break;
                }
                else
                    if (c ==
                          '\n') {
                        reader.
                          unread(
                            c);
                        break;
                    }
                result.
                  append(
                    (char)
                      c);
            }
            return new edu.umd.cs.findbugs.Token(
              edu.umd.cs.findbugs.Token.
                COMMENT,
              result.
                toString(
                  ));
        }
        else
            if (c ==
                  '*') {
                java.lang.StringBuilder result =
                  new java.lang.StringBuilder(
                  );
                result.
                  append(
                    "/*");
                final int SCAN =
                  0;
                final int STAR =
                  1;
                final int DONE =
                  2;
                int state =
                  SCAN;
                while (state !=
                         DONE) {
                    c =
                      reader.
                        read(
                          );
                    if (c <
                          0) {
                        state =
                          DONE;
                    }
                    else {
                        result.
                          append(
                            (char)
                              c);
                    }
                    switch (state) {
                        case SCAN:
                            if (c ==
                                  '*') {
                                state =
                                  STAR;
                            }
                            break;
                        case STAR:
                            if (c ==
                                  '/') {
                                state =
                                  DONE;
                            }
                            else
                                if (c !=
                                      '*') {
                                    state =
                                      SCAN;
                                }
                            break;
                        case DONE:
                            break;
                    }
                }
                return new edu.umd.cs.findbugs.Token(
                  edu.umd.cs.findbugs.Token.
                    COMMENT,
                  result.
                    toString(
                      ));
            }
            else {
                if (c >=
                      0) {
                    reader.
                      unread(
                        c);
                }
                return new edu.umd.cs.findbugs.Token(
                  edu.umd.cs.findbugs.Token.
                    SINGLE,
                  "/");
            }
    }
    private edu.umd.cs.findbugs.Token parseWord()
          throws java.io.IOException { java.lang.StringBuilder result =
                                         new java.lang.StringBuilder(
                                         );
                                       for (; ; ) {
                                           int c =
                                             reader.
                                             read(
                                               );
                                           if (c <
                                                 0) {
                                               break;
                                           }
                                           if (whiteSpace.
                                                 get(
                                                   c) ||
                                                 c ==
                                                 '\n' ||
                                                 single.
                                                 get(
                                                   c)) {
                                               reader.
                                                 unread(
                                                   c);
                                               break;
                                           }
                                           result.
                                             append(
                                               (char)
                                                 c);
                                       }
                                       return new edu.umd.cs.findbugs.Token(
                                         edu.umd.cs.findbugs.Token.
                                           WORD,
                                         result.
                                           toString(
                                             )); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "COwTHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JwAA");
}
