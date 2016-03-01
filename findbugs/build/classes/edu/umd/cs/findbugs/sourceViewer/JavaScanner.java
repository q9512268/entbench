package edu.umd.cs.findbugs.sourceViewer;
public class JavaScanner {
    public static final int NORMAL_TEXT = 0;
    public static final int COMMENT = 1;
    public static final int JAVADOC = 2;
    public static final int KEYWORD = 3;
    public static final int QUOTE = 4;
    public static final int EOF = -1;
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    private static final java.util.HashSet<java.lang.String> KEYWORDS = new java.util.HashSet<java.lang.String>(
      );
    private static final int MAX_KEYWORD_LENGTH;
    static { java.lang.String[] keywordList = new java.lang.String[] { "abstract",
             "assert",
             "boolean",
             "break",
             "byte",
             "case",
             "catch",
             "char",
             "class",
             "const",
             "continue",
             "default",
             "do",
             "double",
             "else",
             "enum",
             "extends",
             "false",
             "final",
             "finally",
             "float",
             "for",
             "goto",
             "if",
             "implements",
             "import",
             "instanceof",
             "int",
             "interface",
             "long",
             "native",
             "new",
             "null",
             "package",
             "private",
             "protected",
             "public",
             "return",
             "short",
             "static",
             "strictfp",
             "super",
             "switch",
             "synchronized",
             "this",
             "throw",
             "throws",
             "transient",
             "true",
             "try",
             "void",
             "volatile",
             "while" };
             int max = 0;
             for (java.lang.String s : keywordList) { if (max <
                                                            s.
                                                            length(
                                                              )) {
                                                          max =
                                                            s.
                                                              length(
                                                                );
                                                      }
                                                      KEYWORDS.
                                                        add(
                                                          s);
             }
             MAX_KEYWORD_LENGTH = max; }
    private final java.lang.StringBuilder buf = new java.lang.StringBuilder(
      );
    private final java.text.CharacterIterator iterator;
    private int kind;
    private int startPosition;
    public JavaScanner(java.text.CharacterIterator iterator) {
        super(
          );
        this.
          iterator =
          iterator;
    }
    public int getStartPosition() { return startPosition;
    }
    public int getEndPosition() { return iterator.getIndex(
                                                    ); }
    public int getLength() { return iterator.getIndex() -
                               startPosition; }
    public int getKind() { return kind; }
    public int next() { startPosition = iterator.getIndex(
                                                   );
                        char c = iterator.current();
                        iterator.next();
                        if (c == java.text.CharacterIterator.
                                   DONE) { kind = EOF; } else
                            if (java.lang.Character.
                                  isJavaIdentifierStart(
                                    c)) {
                                buf.
                                  append(
                                    c);
                                boolean couldBeKeyword =
                                  java.lang.Character.
                                  isLowerCase(
                                    c);
                                while (true) {
                                    c =
                                      iterator.
                                        current(
                                          );
                                    if (!java.lang.Character.
                                          isJavaIdentifierPart(
                                            c)) {
                                        break;
                                    }
                                    buf.
                                      append(
                                        c);
                                    if (couldBeKeyword) {
                                        if (!java.lang.Character.
                                              isLowerCase(
                                                c) ||
                                              buf.
                                              length(
                                                ) >
                                              MAX_KEYWORD_LENGTH) {
                                            couldBeKeyword =
                                              false;
                                        }
                                    }
                                    c =
                                      iterator.
                                        next(
                                          );
                                }
                                kind =
                                  NORMAL_TEXT;
                                if (couldBeKeyword) {
                                    if (KEYWORDS.
                                          contains(
                                            buf.
                                              toString(
                                                ))) {
                                        kind =
                                          KEYWORD;
                                    }
                                }
                                buf.
                                  setLength(
                                    0);
                            }
                            else
                                if (c ==
                                      '/') {
                                    char c2 =
                                      iterator.
                                      current(
                                        );
                                    if (c2 ==
                                          '/') {
                                        while (true) {
                                            c2 =
                                              iterator.
                                                next(
                                                  );
                                            if (c2 ==
                                                  '\n' ||
                                                  c2 ==
                                                  '\r' ||
                                                  c2 ==
                                                  java.text.CharacterIterator.
                                                    DONE) {
                                                break;
                                            }
                                        }
                                        kind =
                                          COMMENT;
                                        return kind;
                                    }
                                    else
                                        if (c2 ==
                                              '*') {
                                            scanComment: while (c2 !=
                                                                  java.text.CharacterIterator.
                                                                    DONE) {
                                                c2 =
                                                  iterator.
                                                    next(
                                                      );
                                                if (c2 ==
                                                      '*') {
                                                    do  {
                                                        c2 =
                                                          iterator.
                                                            next(
                                                              );
                                                        if (c2 ==
                                                              '/') {
                                                            break scanComment;
                                                        }
                                                    }while(c2 ==
                                                             '*'); 
                                                }
                                            }
                                            kind =
                                              JAVADOC;
                                            return kind;
                                        }
                                }
                                else
                                    if (c ==
                                          '\"') {
                                        kind =
                                          QUOTE;
                                        char c2 =
                                          iterator.
                                          current(
                                            );
                                        while (c2 !=
                                                 '\"' &&
                                                 c2 !=
                                                 '\n' &&
                                                 c2 !=
                                                 '\r' &&
                                                 c2 !=
                                                 java.text.CharacterIterator.
                                                   DONE) {
                                            if (c2 ==
                                                  '\\') {
                                                c2 =
                                                  iterator.
                                                    next(
                                                      );
                                                if (c2 ==
                                                      '\n' ||
                                                      c2 ==
                                                      '\r') {
                                                    break;
                                                }
                                            }
                                            c2 =
                                              iterator.
                                                next(
                                                  );
                                        }
                                        iterator.
                                          next(
                                            );
                                    }
                                    else
                                        if (c ==
                                              '\'') {
                                            kind =
                                              QUOTE;
                                            char c2 =
                                              iterator.
                                              current(
                                                );
                                            if (c2 ==
                                                  '\\') {
                                                c2 =
                                                  iterator.
                                                    next(
                                                      );
                                            }
                                            if (c2 !=
                                                  '\n' &&
                                                  c2 !=
                                                  '\r' &&
                                                  c2 !=
                                                  java.text.CharacterIterator.
                                                    DONE) {
                                                c2 =
                                                  iterator.
                                                    next(
                                                      );
                                            }
                                            if (c2 !=
                                                  '\n' &&
                                                  c2 !=
                                                  '\r' &&
                                                  c2 !=
                                                  java.text.CharacterIterator.
                                                    DONE) {
                                                iterator.
                                                  next(
                                                    );
                                            }
                                        }
                                        else {
                                            kind =
                                              NORMAL_TEXT;
                                        }
                        return kind; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e+wrWX2f7737uPtg73IX2M0C++JCWQy/GT9nnIWAPZ4Z" +
       "z3getsfj8bhtLuPxvOx5v+1kEyBKFxWFoHZJiATb/kGUNCIQVUGJVCWlqpJA" +
       "QyqljdpQqRBFlUoeqKA2pCpp0jPj3/v+7mUvoFq/Ob8z5/n5fs/3fM73HB9/" +
       "5huVe6OwUvU9e2vYXnyg5fHB2m4dxFtfiw5opjVSwkhbYbYSRVOQdlN97teu" +
       "ffs7HzMfvVy5b1F5THFdL1Ziy3OjiRZ5dqqtmMq1k1Tc1pworjzKrJVUgZLY" +
       "siHGiuIXmMpDp6rGlRvMEQQIQIAABKiEAHVPSoFKr9HcxMGKGoobR0HlJyqX" +
       "mMp9vlrAiyvPnm3EV0LFOWxmVEoAWrhavM+AUGXlPKw8cyz7XuZbBP54FXr5" +
       "53/00X95pXJtUblmuUIBRwUgYtDJovKwozlLLYy6q5W2WlRe62raStBCS7Gt" +
       "XYl7UbkeWYarxEmoHSupSEx8LSz7PNHcw2ohW5iosRcei6dbmr06ertXtxUD" +
       "yPqGE1n3EhJFOhDwQQsAC3VF1Y6q3LOx3FVcefp8jWMZbwxBAVD1fkeLTe+4" +
       "q3tcBSRUru/HzlZcAxLi0HINUPReLwG9xJUnb9tooWtfUTeKod2MK0+cLzfa" +
       "Z4FSD5SKKKrEldefL1a2BEbpyXOjdGp8vsG9+6M/5g7cyyXmlabaBf6roNJT" +
       "5ypNNF0LNVfV9hUffgfzc8obfuvDlysVUPj15wrvy/zGj3/rfe986gtf3Jd5" +
       "4wVl+OVaU+Ob6qeXj/zhm7DnO1cKGFd9L7KKwT8jeWn+o8OcF3IfzLw3HLdY" +
       "ZB4cZX5h8rvyB35F+4vLlQepyn2qZycOsKPXqp7jW7YWkpqrhUqsrajKA5q7" +
       "wsp8qnI/iDOWq+1TeV2PtJiq3GOXSfd55TtQkQ6aKFR0P4hbru4dxX0lNst4" +
       "7lcqlfvBU3kYPG+s7D/l/7iyhEzP0SBFVVzL9aBR6BXyR5DmxkugWxPSgTEt" +
       "EyOColCFjMSCtFUCJc4KUqNTeV4SqtrM0jIthGhgXwJoDwh1UNia//+ll7yQ" +
       "9dHs0iUwDG86TwI2mD8Dz15p4U315aSHf+uzN3//8vGkONRSXHkn6PUA9Hqg" +
       "RgdHvR6c7vXgVK+VS5fKzl5X9L4fbzBaGzDvASM+/LzwD+n3f/i5K8DQ/Owe" +
       "oOqiKHR7YsZOmIIq+VAF5lr5wieyD85+Er5cuXyWYQvEIOnBovqo4MVj/rtx" +
       "fmZd1O61l77+7c/93IveyRw7Q9mHU//WmsXUfe68bkNPBWoLtZPm3/GM8vmb" +
       "v/XijcuVewAfAA6MFWCzgF6eOt/HmSn8whEdFrLcCwTWvdBR7CLriMMejM3Q" +
       "y05SykF/pIy/Fuj4ocKm3wAe/NDIy/9F7mN+Eb5ubyTFoJ2ToqTb9wj+p/74" +
       "3/9Zo1T3ETNfO7XWCVr8wik2KBq7Vs77157YwDTUNFDuv35i9E8//o2X/n5p" +
       "AKDEWy7q8EYRYoAFwBACNf/0F4OvfO2rn/6jyydGE4PlMFnalpofC1mkVx68" +
       "g5Cgt7ed4AFsYoO5VljNDdF1vJWlW8rS1gor/Ztrb619/i8/+ujeDmyQcmRG" +
       "7/zuDZyk/1Cv8oHf/9G/fqps5pJarGYnOjsptqfIx05a7oahsi1w5B/8D2/+" +
       "hd9TPgXIFhBcZO20krMuHU6cAtTr48oby5rFMn2AmUBjKliyqFgrVVcOLFSW" +
       "fEcZHhRKKetXyrxGETwdnZ4gZ+fgKc/kpvqxP/rma2bf/O1vlRKddW1O2wOr" +
       "+C/sTbAInslB84+fZ4OBEpmgXPML3D941P7Cd0CLC9CiCtbziA8BIeVnrOew" +
       "9L33/5d/82/f8P4/vFK5TFQetD1lRSjlRKw8AGaAFpmAy3L/ve/bG0B2FQSP" +
       "lqJWbhF+bzhPlG/XAMDnb89BROGZnEzjJ/4Pby8/9Kf/+xYllOxzwYJ8rv4C" +
       "+swnn8R+5C/K+ic0UNR+Kr+VpIEXd1K3/ivOX11+7r7fuVy5f1F5VD10EWeK" +
       "nRSTawHcoujIbwRu5Jn8sy7Ofj1/4Zjm3nSegk51e56AThYHEC9KF/EHz3HO" +
       "E4WW3wmeNx1Oxzed55xyldiPcQHpgAIenaGF1//0n3/6rz/4Enq5MPp70wI6" +
       "0MqjJ+W4pPBE/9FnPv7mh17+k4+UpHDUdLfs/tkyvFEEf68c3ytF9O2AM6LS" +
       "qY2BOJar2Ifc8Xfgcwk8f1s8RUtFwt4LuI4duiLPHPsiPlgPH+L4Cdtlbk7x" +
       "+fTOpjMKLQdwYnroi0EvXv/a5pNf/9W9n3XeTs4V1j788j/+u4OPvnz5lHf7" +
       "llsczNN19h5uORCvKQK6mHnP3qmXsgbx3z/34r/65Rdf2qO6ftZXw8FW5Ff/" +
       "0//98sEn/uRLF7gGV4Afvl88irBZBL29XpHbTsN3nzWSt4PnqUMjeeoCIyki" +
       "WEF4RUS60wgXwaAIqFIHdFy5H+NZFuemxevoHM7594DzmUOcz9wB5+UicvMu" +
       "cdLdWbfPYxfhfP/3gPO5Q5zP3QFnicW4S5xDXJb4Sf8inOZd4nwbeG4c4rxx" +
       "B5z3FBHv7nDeOxb5KX4RSv8uUb71EOkR4gtRFoxRRLK7Q3kF54mLMOavHuMP" +
       "Fak0eJ4/xPj8LRgrZeQnbwMNjKkfWimgtlvxXT0cbQHQyDtuT3JCsoziU1vV" +
       "n7Fe+YN/91fXPrjnk7PsWJ5WHFY9X+8rf3yl/lB842dLP/OepRKVkK6C1Scq" +
       "SsaVZ25/8lG2tae+h05ovXIxrT9+4qoUjgVYOQ/KsxX/0DiAU3XO9wBFioyP" +
       "nOHTixVxU6Wcm8Lnv/JSu6TLa6kFvGJtNT08kDnrBZ7sjF44c0hzoapuql//" +
       "3M988dk/nz1W7r73WilgtYAHWfxHDw3mUmkwlyv73dVbbwP4EFHptN5Uf/yT" +
       "f/sHf/biV790pXIf2E8UToESgp032Nof3O7Q6nQDN6Yg1ge1gLPwyL625Rrl" +
       "4B4O4vXj1OOtUVx51+3aLtfOczuo4tjH9sB2s+cl7qpo9qmzzsiDie+fzi3N" +
       "4eHvxxx+Arj8r0J9x9IfTsLK9dL0HzlxWopl9HQmWDofw5iuINycyiP85qw7" +
       "obo9pmSsjxQuxiX8yBJPeT57py2/IGd/YnXGqa3k51jlA2dZ5eFjVjneSbQv" +
       "2ueXB23AWzq1ETg4Phw8OaG8kKwupisYPNVDXVRvQ1e/dAcm/albmeo6253f" +
       "PGSrmwzOkdPBRcT6y6+eWK8XqT8MnvccIn3PbZB+9mKkl4+RntD9MtGPVP34" +
       "+bHrJVZxDnMO8OfuEvC7wPPeQ8DvvQ3g33jVgK9ah9vI4h0+B+03Xz204nyt" +
       "8nrwdA+hdW8D7bcvhlZ6fj91hKp0hS8a3X99l4gKZxM7RITdBtHvvBpErwHT" +
       "IIxHp44/zkP73e8KrWwKOBTAd6kfIAeltr98d+7E42tbvXG0Y5lpYQTA3Fjb" +
       "SJH9z84Bol81oOgMjzGea7zwkf/2sS//7Fu+BtY3+miHVpTuA70Izy//5/uK" +
       "l/94d9ifLLAL5ZEio0QxWx6naKsCftkEewr0GNiADXB8zyLF13990Iyo7tGH" +
       "qSlYqyvmEzdpaKzWGEU8sulqvTwbtNx15G1I1rX6gyjq9xoejzRb037E7rhO" +
       "DHM7ts2yCNfAmt5kmCkCwY49LyRFwaZlz5tZvsTY8nJCSTOSdTaTtees8UVt" +
       "NpZhMfAVAYP1HNpVd7xcV6V1NBlzYi1dQRD40xsNqLquNlvopOvV7OlkLIwh" +
       "v55LgakMhUYk+eSmhk9wZKoFeLyLO7NsVFujbYcfNoebgO6IfZdTeLTjr+hZ" +
       "N5en0rQtM5tgscM31Vp/400FjrRFrx5QrSzZEhQUTHg4DsYWFm6NGI1oyxi1" +
       "+f6MVNbmataUejaOLHddG2bXMOlS4wVdJaRVY8Ws6ekuCpkVuUYW3Dq32ig5" +
       "EaQongr6LFIaKtZb8W2ZkteGozR8WtrOc4II1ZG1pDTP2XRiQkJ3vWmvHps2" +
       "L9CezkwDGOEb/Zm6w8WdQeOuRE63sVMPtjxOTdkZbcfignBiIaF32sQwDT/K" +
       "GpIwY6OobsiE0eh7pgPXrLWRevQwkCb4wu3DOzwnMA9l25IgqfmQEBFnw4vw" +
       "vJnbzpAjOITKZJhFWG89G7c2GKo2Wk2oVl8GjY4wHoZtYSEaHaGLjPqYmW2Z" +
       "DkVgymCIBTXfp2B8DAULwogaiTd0MStiR2p75nMkTTVH4/nSzXGGC2QxCKka" +
       "M3N7I4Oqc+o8jPyA4FBD3Kb5jMfM7biJ1RoRHVDElkDGWAZ2hWQNx/kO29yQ" +
       "yxW36VFtRyOdLUlHkqH2DWbcBGo2+WUq8pTT79l0GFBrShBH5sDudpSxRRJR" +
       "YBhDn/dTk7dCWuIHzSUHT9cBTSbqrEYSzUzZZUKP7ge+mnXWLIon0/kg3jg1" +
       "aJQETSVGOdj0fKHLdNUms6VSWu9txhwT0Am/MWdYoncpbKsTu7Rbm1ZzGjao" +
       "/rC160+XJMTvSBiN5lwvQ5bedtFek45a74YtXWzqdctAo5m/0eQQ8zEO38yl" +
       "HpejvQZd34Yh6/oK3DUVZ7SO1itP3gIXsO12Wk0UHsHZtusvBY5Isa2zCXoD" +
       "brlVZ11hEgSJPyFmvN/c1Fm/NbTG63C5HREihdL4eqbwmTrglKCxmeOWsg2E" +
       "uoSOYaHHGgIVmEvP6KvBIokYP2tvtZlhmLmOTdTUcvCE1as11O1WCZMX3f6A" +
       "7dCGJQyS2niBSrEZ9Y0+xaUminU9GO4FQjcOhyaqCYZtOhuLEFEbd7hVpM/p" +
       "YUty9DGu+aTdZKqx2Ecz0sP5QEHdzoKWazLdzMhu2OXgTk6OKTC3YFnCawKH" +
       "QvF02B66g+YGWmwNeWD4U2HtL7rDhJQ5cRw2xW3QXEZBcxEFLbprYHAdn6mN" +
       "jhnXlTxRtR2GtlS4M69VkYXYWXcFS2HXHj+han0yh/khSS3MZk6sIW6gbOP6" +
       "ru+3tjOux1otwAG2Nm3gVtXnpNXYiIglxI3Ynd2tYgrTRXO4KpswI/ms0RnP" +
       "+NAdqvlCSMaTwBkiU2upLKJ1k9ltfXkOpU11A/HzZaM9bFeX2wyQVX861DDB" +
       "lPqjDZMx07krLfpaay0P5ikhIdNGrd1he3x9SjF9qzpV5WbLpiwTVmBg9gO8" +
       "Ot/sElW3gOlFskPp/fpi2apisiHOInUIgbHxYnKc8BLuddEhFtHrzSTZUVsm" +
       "lgazuSsqDtGWolGAw3i8TbtyLWLnnIra1byDtHMxonO7vZ6HzjjC0ZyjtNay" +
       "NdchvTprOU0WbW+2pkx0CKyTS8uuytDKIvADhpnHM8EhVAlSG/P5wJ1AcSOa" +
       "wMRmyXbsIMPUiCIxRB6b/R1Y89IRNHC2Ipv2tnCnhpJ9P5MNHPfdsUQhQxXu" +
       "47ayVCAczO8ujjZ7CoxMet0UFnvGLBkPJ82o3w4dd0TLDWg5qzc8Y2zEJNiV" +
       "qHyTDkcKM/OxpduJUd8jOLzan3Rn0TZqyouZW8e4OR8GLrPcyBAc+poDVbsL" +
       "ZI1k/To25SR8sJDkuky3agsy2E4DeSt4WTT2CXPTM0bzcMH5cA4vSTaVt+w8" +
       "mlM55s0neGfR6E0WO24U9dRFqyfturNWvYNUNX6YelV9xMJjXmHzZNeGVThg" +
       "PJmWd3ij36FHas/JOD9r9BN2PuCDdkh41ZU5cRFZlLWxicViJi4dd+Gtd047" +
       "Glm1+a4zS6tzomvS6kT0CUdMomZs9mh+ZPaIXkyyeSqFdjtR8K63nY1nfd6j" +
       "uyt0anBJZuxSRIYdYlGLt1Rbn0KhPxuj6ojdwOJ04Dhs6G07+JrHstSqOnEG" +
       "QePBFoLgbKSPdr1g0p1zkLkcTaZ6a95qWBnWSKE+N2ixO0kTxxGThlWUJhAf" +
       "FiRdXXuMwvdreMOfYyhpxomV6oLZwvReHjB6D7fzUdt1dhOrvc65qUZPEUpC" +
       "RNbDaznn8Lqjskp3jDIzZ81HtRgld0wS1Vetad1cB3w+T8itSnM5lutdDoVR" +
       "MENVwmu3RJFfb4azMdkU0HFNiHVNG5goEtXTeo3qtfPMJDYDZSIs5UYokKQH" +
       "BfB6BTfTOgRJq45LLtoLLW8pkEPPdxGxpmZDvBtsyUzsBUzVlboUbKlthhY3" +
       "EJUFLX67jpCkEy/ktL9qA6Od+u2RjuAb4Iz0IFMQ5HqO79iwDitZAvltNxyJ" +
       "PMSklMGyy9lgjKTIPLbb0Ih1aM0wqxC35aZOusWFaOAIijeqMdWe3mWQESry" +
       "UqSSFEp664VvtNg8dpupSwVVI+ny5CqWOkkC6WKWyd24piC9mO1UEWg3kda6" +
       "HnEYibpDhM7RTGytaSwjB1hWp1xthwYNbEgsOx1tzecZlDbIWjbTIjZV+LE0" +
       "RdBWA4UGSIiEktqhQhjLxKxJdBIW0L/c6jRlg1hUk6o/jzuiFFKM7FF10cem" +
       "ZtWcxMLOqqU1k+mvjPoWDrCwx5njiOdg0TYGybbXXDl52hsyzpAkhUYtXnCT" +
       "lh82sXmT930D1haZFyJjgx3Cw2q3SRBcLncGlt5bZs6KwNV2vZOsB8tGE615" +
       "c2cIz7uk4iQrhh2RGCYReEpSOx03es5SivU2GvJWT5WRMdPlaC/kNLmX5Va1" +
       "KTO9Kgb3ZG5BcDVkWl82BAzdcnI23hFI01HbkjMi+6SsSUsi25Gg7wzWosZq" +
       "tCBTpa/yG9lT4axJzixNHGFd2ZmnPXGUSxnDTsPJzp5oY11TRy2MjubjWI8Q" +
       "e6hmzXFmeQN9ZAyQWU+Ux1PUwKrUdu44Ndihg1nWcTCuyfc5qU624BYfB1sX" +
       "QYUuWktldWBKjSyNVlB91YHU6SztjxbbMGiFLsqO7BGW0q2OszPFRcouthY7" +
       "XVJie+s5JDsXCBUL8eUEZcOpu8ItB6k3krYMPPe03fbyOp26CDxYmYOEMLYQ" +
       "8Kb5YD5r5nSYLjjcXa2wlcYsLXhKQu2BB5YKh2CNUX9I9fpTFRMcKGw3fDJL" +
       "snZHklNyvcLkVJXnKdVlIp7fwUbPbarT1qq2S/IEEJmULXcR2u7xUbtBa2xn" +
       "3WrIqTxuNQIPUA09aqKhmgylZNXJhUW7xUrmthG3WltL59110uyMkqSfGm4k" +
       "Rc1xdz7ktUlYTdEMHXeJukExOMr708HCBEoxMZLX9Pm2p87T4dzOUdhjG7mh" +
       "KZtEH2i7WqepV3V6kcUUDlZ+sr/YDT2pObdUM23EaTWbcOmst8Rm4/HUVpUa" +
       "RcH5aKk2uFRZkmk92FAuBjWcRUooiCeOWiS2nhGw6bfH+DRON33CHIpN30Lq" +
       "M0VM57pL15dUV4T6EGHDi7Rursbb7WylyNM6uUwXPMapzoQcxqNpI294tRU8" +
       "N3WlsVq2m56sZtaA0Ax20ueCpRpxa2bsICtiPR8ELjJxLEYTYRkeoMIK7tXt" +
       "Gj+s1bV4xSz0QZWuZaKVoOSAYXkp9LRtmCES3NRcVFfrUDM1nHpnqDDtUXWO" +
       "OmsoadNtyO60ooXoufWak679VBrlbWoVNNK5NnB2zaqe7qQg74hh0y7cgFTq" +
       "oUBfPItHg74mOOvt1LBYTejWHM6pC9JuJfldAR26ilmNWFkU6jhSD6aGAtiD" +
       "rjdxYlLdNGmXiLYIrW87OTuHFLB8jpDmdNMPm1JUtyW30dQ7yVJvLFDEJfO5" +
       "v3BHcY0imLrYXsB55NV8IZqodML0O2lE1msWaqPJBkw0fphgcOAGc0RAZjsN" +
       "HmhLk5PaKb9rI8BzEic1JAGsLLmOzDRzHvLX/Bw368hC3/Unmo7ajmR6FoyQ" +
       "oPhWHI7XM2bCzRbGtL0UdjnMhEbicNs41SFxPoWpIB/hE0NC2ZZrhlmnuUOj" +
       "Bb+0pVVSlXpDBGFMRuKagI7NjU8jW0NfrndbRLNakNbCOuue15jvNmmwaVuE" +
       "r/Z7i6oqWjN3vUaRpN2ZJQS6a5LRroPMuVBOpFZoipQbL5GNHuh1VaUGbtsh" +
       "xBaGtDKL9zq87Edtvee2dn5e1TpBJBCWSXKuyw/lvl1FLMXuIDyTUSjcTwR6" +
       "NM9FiZ4Gfm9A4L4sNNgus063uekNV6vlllZGjYVZpQdOd5rZ0w4KM3zYlahu" +
       "JttjhfXb/HI+9CCE2RhkRyfhLCNROentIGFEGOkuHs3XuLgGDrRhNsTFuj6h" +
       "ZV2Z07JIoyQMe1KmJvkUFUasMV9swW6WH4x7lhoZQh1YETbRUQZXJjXRWSBC" +
       "pDdcddPSEXMNMTgNoete4NN0b6ehmZlP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("OkYH20ak3R8ucFhvYrISzYeCtyKAY7z1Gg1ssFyRtkFiOt8apDZoE4GsiYEJ" +
       "WWM725gEgGCikS8iCjdvB1ORDIBnzkPe3KgFC3fRH3cDO52zMYfj7ixWfSi1" +
       "OaqvMfJUQRF7iyyoyFukkdPQYL+ZVeNmupsY9QhZrq1Oa4Cs3YktpCaMqL0l" +
       "NZMTjq5Wo1arYfO12AGb29pOUsNBDkN0zq9rPYOVal61NqOJPkthWBIOCE5d" +
       "h5wi6nLUUTUroGuQLEITYdMd1zfj7kBDxn6niYehMjZa3EbcIg1zVxccRm00" +
       "lkS1Lo/6aVhfaRuD4U141Kj2gb+AauFS7iQ8wqvQrDaiJKM7XfLzuDVf+hIy" +
       "XLctvpUx6YyBsI0Whn5/0PA1QQ3mMDHBZ5KwXVpbfxRTzcFMdporO8gbch7Y" +
       "faC2NSKGlu8iBNIOI4Zj9OnIzsiFlM9CdLTluyuplw/H3W5xfPXVuztWe215" +
       "JHh8A/Z7OAzcZz1bBG89Pj4tP/dVzt2aPHV8euZ7iCisvPl2F1vLCwif/tDL" +
       "r6z4X6xdPvzSYhJXHog9/122lmr2qabuvfP3kGx5r/fksszvfejPn5z+iPn+" +
       "u7gm+PQ5nOeb/BfsZ75Evk39J5crV46vztxy4/hspRfOfUcVanESutMz12be" +
       "fKzZa4XGngYPdahZ6vzB9MnYXXwq/fb92N/hztf/ukPet4vgf8SVRw0tFm45" +
       "1T4xmW9+t8PW0w2XCX95VsY3g4c9lJH9gct4qXKHvPKbju/ElUeAjMCFu42E" +
       "f/P9SlhcHxgfSjj+wUv48B3yint3l+4HswhIyGiusb/xfCLcpavfr3DFbVLx" +
       "UDjxBy/cE3fIe7IIHosr9wPhhkdfBZ2I9rrvV7THwCMfiib/4EW7cYe8txXB" +
       "0zEgDEBu5+R65m7kyuPKQ6fuZBcXTJ+45Rcg+18tqJ995drVx18R/3N5Lfn4" +
       "lwUPMJWremLbp+/6nYrf54eabpXCPrC/+eeXErwrrjzz3W6Lx5WHT78W4C+9" +
       "c18djiuPXVA9BlgOo6dLN+LKgyel48pl9Ux2G9jIYXZcuQLC05kdkAQyi+gP" +
       "l2P7qfzS2VXrmAmufzfNn1ro3nLbKxxssv91zk31c6/Q3I99q/2L+/vUqq3s" +
       "dkUrV5nK/fur3cfL0bO3be2orfsGz3/nkV974K1HS+cje8AnZnoK29MXX17G" +
       "HT8urxvvfvPxX3/3L73y1fJK5f8DmgiExDQ1AAA=");
}
