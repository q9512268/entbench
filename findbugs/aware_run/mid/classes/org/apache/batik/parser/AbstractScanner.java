package org.apache.batik.parser;
public abstract class AbstractScanner {
    protected org.apache.batik.util.io.NormalizingReader reader;
    protected int current;
    protected char[] buffer = new char[128];
    protected int position;
    protected int type;
    protected int previousType;
    protected int start;
    protected int end;
    protected int blankCharacters;
    public AbstractScanner(java.io.Reader r) throws org.apache.batik.parser.ParseException {
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
            throw new org.apache.batik.parser.ParseException(
              e);
        }
    }
    public AbstractScanner(java.io.InputStream is, java.lang.String enc)
          throws org.apache.batik.parser.ParseException { super();
                                                          try { reader =
                                                                  new org.apache.batik.util.io.StreamNormalizingReader(
                                                                    is,
                                                                    enc);
                                                                current =
                                                                  nextChar(
                                                                    );
                                                          }
                                                          catch (java.io.IOException e) {
                                                              throw new org.apache.batik.parser.ParseException(
                                                                e);
                                                          }
    }
    public AbstractScanner(java.lang.String s)
          throws org.apache.batik.parser.ParseException {
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
            throw new org.apache.batik.parser.ParseException(
              e);
        }
    }
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
    public int getType() { return type; }
    public java.lang.String getStringValue() {
        return new java.lang.String(
          buffer,
          start,
          end -
            start);
    }
    public int next() throws org.apache.batik.parser.ParseException {
        blankCharacters =
          0;
        start =
          position -
            1;
        previousType =
          type;
        nextToken(
          );
        end =
          position -
            endGap(
              );
        return type;
    }
    protected abstract int endGap();
    protected abstract void nextToken() throws org.apache.batik.parser.ParseException;
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
      ("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" +
       "fvE8LgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XQfe2Mqyw0E9R1KZ5dSD2+ba6vvWSNNT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("iyM3RG2JsQZEIuWiZqYLeiF06HBGlPvLteVUHb7vjwK/hjRGWllbtUnTTgTV" +
       "kmcOVDPD6WwGpWtdIycbM+3q5cRO9AmdzEw9bRS7BLLaxLyymdi+1p/JpdqU" +
       "mwTlyiqSk7rdmi1RtbpaGuKgj7EWZyw3qbyaWFxliIxh3FwXVYqXigq5bogl" +
       "gx4sxwoJG8i0Rg074bLoefNAjawyCOJjBPF8B4FrcqS1B2CNMMHHZJuqcI0S" +
       "TZs1TdGIqoDTa80Y2JNpeel1aUukJY1rQNKqPeFVpclGaGlVw7nRNBaCOJEm" +
       "Y6wjGzOOEmyjh5vlYiJP6Hmx3QK2ZSYp01XsUuIQbpVnXYmS16ncczfyWK4J" +
       "0jpyDG9NzeZxG8yEZuxTgc2WECkxXH3VbketuNZM4IoWkxij1+vZ67Cv39hr" +
       "uvvyt49Hh16/j/eOZ+xsHu5Y3S7uTvodH7rKfxcLe6coT7zMPXGCopDtAD96" +
       "1kHXfPf3Cx996WWl/yvlc7vtlCAs3BG63g9baqxaJ7q6J7/+6SMyLh6+5H5x" +
       "R8aL+++Uj7lw9RfKP7Tl4jW2dv77Ncr+NMv+a1i4oKthdkI1fwt9zPP/dsOn" +
       "a/agZVsKH9tB+9hbD+17Z5cd5F38OZADgLY9iLsH7rs3Ae7+7GG24/VTO3A/" +
       "9ZaDO7jrGmXZyYSD81twRL5hn9V68QjcwYWblVy2cfbSDtxLbz24h65R9gNZ" +
       "dj+YtgDc8Ggn6RjbAzeLLTs9/Qs7bL/w1mN7+hpl2Z7uwWNh4TzARu62pI6R" +
       "PX4TyPLTbI+C9Ms7ZL/81iPbP515sqycZc+FhbtkSxX9rVJedZcldk3lGHLx" +
       "ZoWZWc9Xd5Bffeshv+8aZdme1AG+tZ5Hm7DH0P7SzRqYJ0B6bQfttbceWuca" +
       "ZUyWkWHh3nwOZucz83N2WVXyGGHrZoX3AEhf2iH80luPcLJXtn/K8iDbvTsY" +
       "AKV01GTfzPA3AS5zDYUnQfrKDtxXbgBcHraIWfbH10V4rbLMuhx8ANga1VEo" +
       "0duDd91Df9eAlzmH/Pzj7+/g/f7/I3jO9QSYDXdgAkeYCXDkLtXM2hzAxzCv" +
       "e5DuGjAza5qXv7GD+cb3BfOrV4V57rhWvu//13M8m2sw48eyLALxshmQq0i0" +
       "aN1xfbUhBurV7OwFyXWBJXaOWRHfrD3Kzn1+bceKr93obBWvK+y/eXVh5/en" +
       "TpP3Tx30P/hklv0NEC9kOpCdqNjT9J+4oaPTYeHi3odB2VcOD1/xNeL2Czr5" +
       "1Zcv3v7Qy+N/vT3LePiV2x1M4XYtsqyTh4lPXJ/3fFUzc4bcsT1a7OVIXgoL" +
       "D53xhUP24Uh+kVF88DPb+j8bFi7t1w8Lt+X/J+v9fFi487ge6Gp7cbLK58PC" +
       "LaBKdvmyd8jyEycztmeqk600Hj6pJHkwff/1eHxiKfX0qSN8+degh8ftou33" +
       "oC/IX3y50/vR76C/sv10R7bEzSbr5XamcGH7FVHeaXZk78kzezvs63z72e/e" +
       "+5t3vPNwcXbvluBjhT1B2+NX/06GtL0w/7Jl848e+vs/8qsvfz0/mvJ/AdmG" +
       "fbamOwAA");
}
