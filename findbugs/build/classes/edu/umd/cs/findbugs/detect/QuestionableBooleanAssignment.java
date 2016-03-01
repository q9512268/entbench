package edu.umd.cs.findbugs.detect;
public class QuestionableBooleanAssignment extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    public static final int SEEN_NOTHING = 0;
    public static final int SEEN_ICONST_0_OR_1 = 1;
    public static final int SEEN_DUP = 2;
    public static final int SEEN_ISTORE = 3;
    public static final int SEEN_GOTO = 4;
    public static final int SEEN_IF = 5;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private int state;
    private edu.umd.cs.findbugs.BugInstance bug;
    public QuestionableBooleanAssignment(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitCode(org.apache.bcel.classfile.Code obj) { state =
                                                                  SEEN_NOTHING;
                                                                super.
                                                                  visitCode(
                                                                    obj);
                                                                bug =
                                                                  null;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == GOTO && getBranchOffset(
                                                            ) == 4) {
                                          state =
                                            SEEN_GOTO;
                                      }
                                      else {
                                          switch (state) {
                                              case SEEN_NOTHING:
                                                  if (seen ==
                                                        ICONST_1 ||
                                                        seen ==
                                                        ICONST_0) {
                                                      state =
                                                        SEEN_ICONST_0_OR_1;
                                                  }
                                                  break;
                                              case SEEN_ICONST_0_OR_1:
                                                  if (seen ==
                                                        DUP) {
                                                      state =
                                                        SEEN_DUP;
                                                  }
                                                  else {
                                                      state =
                                                        SEEN_NOTHING;
                                                  }
                                                  break;
                                              case SEEN_DUP:
                                                  if (seen >=
                                                        ISTORE_0 &&
                                                        seen <=
                                                        ISTORE_3 ||
                                                        seen ==
                                                        ISTORE) {
                                                      state =
                                                        SEEN_ISTORE;
                                                  }
                                                  else {
                                                      state =
                                                        SEEN_NOTHING;
                                                  }
                                                  break;
                                              case SEEN_ISTORE:
                                                  if (seen ==
                                                        IFEQ ||
                                                        seen ==
                                                        IFNE) {
                                                      bug =
                                                        new edu.umd.cs.findbugs.BugInstance(
                                                          this,
                                                          "QBA_QUESTIONABLE_BOOLEAN_ASSIGNMENT",
                                                          HIGH_PRIORITY).
                                                          addClassAndMethod(
                                                            this).
                                                          addSourceLine(
                                                            this);
                                                      state =
                                                        SEEN_IF;
                                                  }
                                                  else {
                                                      state =
                                                        SEEN_NOTHING;
                                                  }
                                                  break;
                                              case SEEN_IF:
                                                  state =
                                                    SEEN_NOTHING;
                                                  if (seen ==
                                                        NEW) {
                                                      java.lang.String cName =
                                                        getClassConstantOperand(
                                                          );
                                                      if ("java/lang/AssertionError".
                                                            equals(
                                                              cName)) {
                                                          break;
                                                      }
                                                  }
                                                  bugReporter.
                                                    reportBug(
                                                      bug);
                                                  break;
                                              case SEEN_GOTO:
                                                  state =
                                                    SEEN_NOTHING;
                                                  break;
                                              default:
                                                  break;
                                          }
                                      } }
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
      ("H4sIAAAAAAAAAL16e6zk1nnf7F1pV1rL2tU6llXVkiV57VqiczlvciA5Nckh" +
       "OZwHOUPODGfYJmu+H8PX8DWcSdXYLloZDeAYiZw4gCPkDwd51ImDokELBElV" +
       "BK1jJAiQB5omQGI3CBA3qYsYRZOibpsecu577669aNEBzpkz5/n7vvOd3/nm" +
       "nPPFb1QejaMKFAbu1nSD5FDPk0PHbR0m21CPD/vD1liOYl0jXDmOpyDvrvrS" +
       "L978q299xrp1ULkmVd4l+36QyIkd+DGvx4Gb6dqwcvM0l3R1L04qt4aOnMlw" +
       "mtguPLTj5NVh5R1nmiaVO8NjCDCAAAMIcAkBxk5rgUbv1P3UI4oWsp/E68o/" +
       "rFwZVq6FagEvqbx4vpNQjmTvqJtxKQHo4bHi9xwIVTbOo8oLJ7LvZb5H4M9C" +
       "8Js/9n23/vnVyk2pctP2hQKOCkAkYBCp8oSne4oexZim6ZpUecrXdU3QI1t2" +
       "7V2JW6rcjm3Tl5M00k+UVGSmoR6VY55q7gm1kC1K1SSITsQzbN3Vjn89ariy" +
       "CWR9+lTWvYRUkQ8EvGEDYJEhq/pxk0dWtq8llfddbHEi450BqACaXvf0xApO" +
       "hnrEl0FG5fZ+7lzZN2EhiWzfBFUfDVIwSlJ59r6dFroOZXUlm/rdpPLMxXrj" +
       "fRGo9XipiKJJUnn3xWplT2CWnr0wS2fm5xvsa5/+fr/nH5SYNV11C/yPgUbP" +
       "X2jE64Ye6b6q7xs+8crwR+Wnf+VTB5UKqPzuC5X3df7lP/jmRz/8/Nu/vq/z" +
       "ty+pwymOriZ31S8oT/72e4mXO1cLGI+FQWwXk39O8tL8x0clr+YhWHlPn/RY" +
       "FB4eF77N/7vlx39O/4uDyg2mck0N3NQDdvSUGnih7eoRrft6JCe6xlQe132N" +
       "KMuZynWQHtq+vs/lDCPWE6byiFtmXQvK30BFBuiiUNF1kLZ9IzhOh3Jilek8" +
       "rFQq10GoWCA8V9l/yu+kEsBW4OmwrMq+7QfwOAoK+WNY9xMF6NaCDWBMSmrG" +
       "cBypcGk6upbCqafBanxaqOkJaAZPUj0uBJYVV8eDwNVlH4uL5eKB/g6L1uH/" +
       "/yHzQgu3NleugAl670V6cMHK6gWupkd31TdTnPzmL9z9jYOT5XKkv6SCAgSH" +
       "AMGhGh8eIzjcIzh8IILKlSvlwN9VINlbBZjTFWAHwJtPvCx8b/9jn3rpKjDH" +
       "cPMImJCiKnx/+iZO+YQpWVMFRl15+3ObT8x/oHpQOTjPwwV6kHWjaD4u2POE" +
       "Je9cXH+X9Xvzja//1Zd+9PXgdCWeI/Yjgri3ZbHAX7qo5yhQgQoj/bT7V16Q" +
       "f+nur7x+56DyCGANwJSJDCwbkNDzF8c4t9BfPSbNQpZHgcBGEHmyWxQdM92N" +
       "xIqCzWlOaQBPlumngI7fUVj+h0CoHi2F8rsofVdYxN+1N5hi0i5IUZLyR4Tw" +
       "J/7Db/2nRqnuY/6+eWZHFPTk1TOcUXR2s2SHp05tYBrpOqj3R58b/8hnv/HG" +
       "3ysNANR4/2UD3iliAnAFmEKg5n/86+s/+Ooff+H3Dk6NJgGbZqq4tpqfCFnk" +
       "V248QEgw2gdP8QDOcYEtF1ZzZ+Z7gWYbdmHPhZX+z5sfqP3Sf/70rb0duCDn" +
       "2Iw+/O07OM3/W3jl47/xfX/9fNnNFbXY8051dlptT6TvOu0ZiyJ5W+DIP/E7" +
       "z/34l+WfAJQMaDC2d3rJbFeOFk4B6t1gX7xspeKpyethEIFNrpxcuKz9Shkf" +
       "Foop+6iUZY0iel98dpGcX4dnfJi76md+7y/fOf/LX/1mKdV5J+isTYzk8NW9" +
       "GRbRCzno/j0XGaEnxxao13yb/fu33Le/BXqUQI8q2PljLgIElZ+zoKPaj17/" +
       "w3/za09/7LevVg6oyg03kDVKLhdj5XGwCvTYAtyWh3/3o3sj2DwGolulqJV7" +
       "hN8bzzPlrycAwJfvz0NU4cOcLuVn/gfnKp/8k/9+jxJKBrpk677QXoK/+Pln" +
       "ie/5i7L9KRUUrZ/P7yVt4O+dtq3/nPffDl669m8PKtelyi31yJmcy25aLDAJ" +
       "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" +
       "xWs//dYfl/fk/wdB/EtgMysAAA==");
}
