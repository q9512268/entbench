package edu.umd.cs.findbugs.sourceViewer;
public class DocumentCharacterIterator implements java.text.CharacterIterator {
    private final javax.swing.text.Document doc;
    private final javax.swing.text.Segment text;
    private int docPos = 0;
    private int segmentEnd;
    DocumentCharacterIterator(javax.swing.text.Document doc) { super();
                                                               this.doc =
                                                                 doc;
                                                               text = new javax.swing.text.Segment(
                                                                        );
                                                               text.
                                                                 setPartialReturn(
                                                                   true);
                                                               try {
                                                                   doc.
                                                                     getText(
                                                                       0,
                                                                       doc.
                                                                         getLength(
                                                                           ),
                                                                       text);
                                                               }
                                                               catch (javax.swing.text.BadLocationException e) {
                                                                   throw new java.lang.RuntimeException(
                                                                     e);
                                                               }
                                                               segmentEnd =
                                                                 text.
                                                                   count;
    }
    @java.lang.Override
    public java.lang.Object clone() { throw new java.lang.UnsupportedOperationException(
                                        );
    }
    @java.lang.Override
    public char current() { return text.current(
                                          );
    }
    @java.lang.Override
    public char first() { throw new java.lang.UnsupportedOperationException(
                            ); }
    @java.lang.Override
    public int getBeginIndex() { throw new java.lang.UnsupportedOperationException(
                                   ); }
    @java.lang.Override
    public int getEndIndex() { throw new java.lang.UnsupportedOperationException(
                                 ); }
    @java.lang.Override
    public int getIndex() { return docPos;
    }
    @java.lang.Override
    public char last() { throw new java.lang.UnsupportedOperationException(
                           ); }
    @java.lang.Override
    public char next() { ++docPos;
                         if (docPos < segmentEnd ||
                               segmentEnd >=
                               doc.
                               getLength(
                                 )) { return text.
                                        next(
                                          );
                         }
                         try { doc.getText(
                                     segmentEnd,
                                     doc.
                                       getLength(
                                         ) -
                                       segmentEnd,
                                     text);
                         }
                         catch (javax.swing.text.BadLocationException e) {
                             throw new java.lang.RuntimeException(
                               e);
                         }
                         segmentEnd += text.
                                         count;
                         return text.current(
                                       );
    }
    @java.lang.Override
    public char previous() { throw new java.lang.UnsupportedOperationException(
                               ); }
    @java.lang.Override
    public char setIndex(int position) { throw new java.lang.UnsupportedOperationException(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "H8oT5c1ZJQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6e8wj13Xf7K60K61l7WptS7JsvayNijXtb4ZDzpCsUtfk" +
       "kMMhOSTnQQ4fdSwP5/1+DzmTqo0NtDYawDVS2XULR38UTtOmdhwEeQGBAwVp" +
       "G6cJijhIm7ZA7CAI0DSu0QhFk6B2k94Zfu992G5WKYG5nLn3nnvP79xzzj33" +
       "8YVvQg9GIVTxPTvTbC8+UHbxgWljB3HmK9HBkMYYMYwUmbDFKJqBvJel9/zU" +
       "tT/51qf06xehy2vobaLrerEYG54bcUrk2aki09C1k9yerThRDF2nTTEV4SQ2" +
       "bJg2ovglGnrLKdIYukkfsQADFmDAAlyyALdPagGitypu4hAFhejGUQD9HegC" +
       "DV32pYK9GHr+bCO+GIrOYTNMiQC08FDxLQBQJfEuhJ47xr7HfBvgT1fgV//x" +
       "h6//9CXo2hq6Zrh8wY4EmIhBJ2voEUdxNkoYtWVZkdfQY66iyLwSGqJt5CXf" +
       "a+hGZGiuGCehciykIjPxlbDs80Ryj0gFtjCRYi88hqcaii0ffT2o2qIGsD5+" +
       "gnWPkCzyAcCrBmAsVEVJOSJ5wDJcOYaePU9xjPHmCFQApFccJda9464ecEWQ" +
       "Ad3Yj50tuhrMx6HhaqDqg14Ceomhp+7aaCFrX5QsUVNejqEnz9dj9kWg1sOl" +
       "IAqSGHrH+WplS2CUnjo3SqfG55uT7//kD7qUe7HkWVYku+D/IUD0zDkiTlGV" +
       "UHElZU/4yHvpz4iPf/kTFyEIVH7Hucr7Oj//t9/44Pueef0r+zrvukOd6cZU" +
       "pPhl6fObR7/6buJW61LBxkO+FxnF4J9BXqo/c1jy0s4Hlvf4cYtF4cFR4evc" +
       "v1390E8o37gIXR1AlyXPThygR49JnuMbthL2FVcJxViRB9DDiisTZfkAugLe" +
       "acNV9rlTVY2UeAA9YJdZl73yG4hIBU0UIroC3g1X9Y7efTHWy/edD0HQFfBA" +
       "BHiehfa/8j+GfFj3HAUWJdE1XA9mQq/AH8GKG2+AbHVYBcq0SbQIjkIJ1hID" +
       "VuQEThwZlqJTZV4SSopgKFslhLuelDiAntCBxUpArwZxAc8LDwrN8/8/9Lkr" +
       "5HB9e+ECGKJ3n3cQNrAtyrNlJXxZejXp9N74yZd//eKxwRxKMIb+OuDhAPBw" +
       "IEUHRzwcnObh4K48QBculF2/veBlrxlgXC3gIYDvfOQW/wPDj3ziPZeASvrb" +
       "B8CgFFXhu7tw4sSnDErPKQHFhl7/7Pajwt9FLkIXz/rign+QdbUgZwoPeuwp" +
       "b563wTu1e+3jf/gnX/rMK96JNZ5x7odO4nbKwsjfc17SoScBIYbKSfPvfU78" +
       "2Ze//MrNi9ADwHMAbxmLQLuBI3rmfB9njP2lI8dZYHkQAFa90BHtoujI212N" +
       "9dDbnuSUKvBo+f4YkHEhZ+hp8FQOzaH8L0rf5hfp2/cqUwzaORSlY/4bvP+j" +
       "/+nf/7daKe4jH37t1KzIK/FLp/xG0di10kM8dqIDs1BRQL3f/Szzjz79zY//" +
       "rVIBQI0X7tThzSIlgL8QS436e18J/vPXv/b53754rDTQ7iy2B+6BDXTy4gkb" +
       "wN3YwPwKZbk5dx1PNlRD3NhKoZzfvvZ91Z/975+8vh9+G+Qcac/7vnMDJ/nv" +
       "7EA/9Osf/tNnymYuSMV0dyKqk2p7H/q2k5bbYShmBR+7j/7W0//kV8UfBd4Y" +
       "eMDIyJXSqV04tJeCqXfE0DtLWz+ItmBSOyim82OTLEfzoKx3q0zfX4jkUHDF" +
       "N1okz0anreKs4Z0KXF6WPvXbf/xW4Y9/6Y0Sz9nI57QSjEX/pb3eFclzO9D8" +
       "E+ddACVGOqhXf33yoev2698CLa5BixKY7qNpCHzS7ozKHNZ+8Mp/+eVfefwj" +
       "X70EXSShq7YnyqRYWh/0MFB7JdKBO9v5f/OD++HfPgSS6yVU6Dbwe7V5svy6" +
       "Ahi8dXfHQxaBy4ntPvm/p/bmY7//Z7cJoXQ5d5ivz9Gv4S987iniA98o6U9s" +
       "v6B+Zne7nwZB3gkt+hPO/7r4nsv/5iJ0ZQ1dlw4jSEG0k8Ki1iBqio7CShBl" +
       "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" +
       "+po8/bHqxcPDiw/H0MOx57/fVlLFPtXdVdDSe+++SzkurwecbKr/6sf+6KnZ" +
       "B/SPfA9niM+e4/N8k/9y/IVf678o/chF6NLxFvttFxfOEr10dmP9aqjESejO" +
       "zmyvP312P/oJ8LQOpd86v5V4MuJ3G8pSEe5xNvRP71H2uSL5dAw9KNmeq9xh" +
       "m29/wHCicZ85q3GPHGvcsW7cOEWcKmFoyMo9lPT2E50y40eOJXT9SEIfOJTQ" +
       "B+6/hP7VPcq+WCT/PIauSEkYKofXfM5vDkr64RWeUkY/flcZFdn/7C8tjXdA" +
       "+6sQ0NH//ZXGL96j7MtF8nPlSU64P0z90gnun3/zcF8rMt8NHuoQN3X/cX/l" +
       "HmX/rkh+JYbeqilxR9EMd+DKSlnyoRP8//pNxv8UeMaH+Mf3H/9/uEfZ7xTJ" +
       "b8bQWwD+nivfCf1X32T0hQ/gDtFz9x/979+j7A+K5Hdj6CGA/k7Qv/YmG/zb" +
       "wbM4hL64/9D/xz3K3iiSPyrOP8Tb7P0bfwWwpUPY0v2H/e17lP15kfwpgO2C" +
       "sOMc7D97k2E/CZ7wEHZ432FfePgeZW8pkgeAovuhkhre/kjtBPqFB/8KoG8P" +
       "oW/vD/QLJxU+VGJ8/B74nyySxwD+6JShn8J/4z7i38XQO+965a64SPTkbVeB" +
       "99dXpZ987dpDT7w2/53y1tnxFdOHaeghNbHt07c6Tr1fBkOqGiWgh/d3PPwS" +
       "8nMx9Nx3uhoYQ4+c/iygXHh2T/5CDL3tDuRAhEevp2u/GENXT2rH0EXpTPEt" +
       "EGYdFsfQJZCeLnwfyAKFxev7S414bbePOZ88rVClhd74TgezxySnr6sVC4zy" +
       "kvbRYiDZX9N+WfrSa8PJD76B/9j+upxki3letPIQDV3Z39wrGy0WFM/ftbWj" +
       "ti5Tt7716E89/H1Hi59H9wyfKPcp3p698yW1nuPH5bWy/Bee+Jnv//HXvlae" +
       "hf9faFTkvT0vAAA=");
}
