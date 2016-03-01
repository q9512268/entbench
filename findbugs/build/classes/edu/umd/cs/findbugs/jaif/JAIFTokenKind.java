package edu.umd.cs.findbugs.jaif;
public enum JAIFTokenKind {
    NEWLINE ( "<newline>" ), COLON ( ":" ), DOT ( "." ), IDENTIFIER_OR_KEYWORD ( "<identifier or keyword>" ),
     LPAREN ( "(" ),
     RPAREN ( ")" ),
     COMMA ( "," ),
     EQUALS ( "=" ),
     OCTAL_LITERAL ( "<octal literal>" ),
     DECIMAL_LITERAL ( "<decimal literal>" ),
     HEX_LITERAL ( "<hex literal>" ),
     FLOATING_POINT_LITERAL ( "<floating point literal>" ),
     STRING_LITERAL ( "<string literal>" );
     
    private java.lang.String
      stringRep;
    private JAIFTokenKind(java.lang.String stringRep) {
        this.
          stringRep =
          stringRep;
    }
    @java.lang.Override
    public java.lang.String toString() {
        return stringRep;
    }
    public static final java.lang.String
      jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long
      jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String
      jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String
      jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long
      jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String
      jlc$ClassType$jl5 =
      ("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" +
       "evKtIgLOu2J+qfsTV+rtW9T9WZ78aTZW");
    public static final java.lang.String
      jlc$ClassType$jl5$1 =
      ("ATe8RUxNphpFYNP2pvqNv/fs7/7CG8/+5yIE6KIRTsXsRLg4Jeb1SJ8fvPmd" +
       "7/3+g098sQigOyeJ4VZ2TwYL3xgLfCzEt4D9wBF2Ze4ecCsG/+80Ah48FuOY" +
       "x2s9dkME9TbqV/7iG5cvPvrG5D9uUe5H5t5LAxe12LaPxsEcyZ/3A1Uziunu" +
       "3UbF+MXXjyLgsZvFXUbAufyrwPzDbfMfR8DDpzTPFGk/e6T1mZ0IuO+wdQTs" +
       "yMeq78mEcK86As5m6dHKi1lRVpln7/VvbRDHsRRGR0KXf9l44+v/9s8vv7R9" +
       "Ozj+ElJEr+91PdnvW988W7k/uvapwpAeLP9FGrgnzFtGwNM3j4Qvxto+c9y/" +
       "tXJFyM/pMUDvOIx5yp8ydotAe99P923LkYelvD7nwZVjryans+C6TDnXx1/+" +
       "1stw8ShyOTFCI1IVbi80/3h44GHM7AvHwvVPZdJ1+btf+uWvPvMn04eLOOwt" +
       "P3Kw9XQr2I09q3emsHo7wDbu9maauoeoiGa8Ln/s9b/8+h+/+O2vnQXOZ7qV" +
       "y7MYqNm+EgG7N/v3haMDXOOyHJ71ynagS9vemT0vlnVv+a4elB4EzUbAT99s" +
       "7OKF7ERsbf4PALa3UoOWF7tKPuyTJ7a72PeP1m5twF0Lws8HwAdug3cHpO9t" +
       "ovm2mgYnxedopZ/pL0Y3x+Pr3HxAXJ82R1SzRROFhOVhaGeIHPOZ+/LkUqGH" +
       "V7bSl6dXb7bUeeXjRXIsABJIt/bvZOGZ427TwaZ79Se90W27FM+IrTxh82Sa" +
       "Jx/Ok4L1Vp4UgYvrPPl4nrycJ6/kyWt58np6LDD4pMT34+2/tVyXv/RGl/m5" +
       "t+Ff2wYmZ4uz2eyJ1IVtjPSBQ/XMTUfbH+s8+dwPL/3Gve/dd/4undxPj7iR" +
       "T50eBEw4flSE7W7+2aP/5IN//41vF0/I/w+XoesdbTQAAA==");
}
