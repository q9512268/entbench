package org.apache.batik.css.engine.value.css2;
public class FontVariantManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SMALL_CAPS_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SMALL_CAPS_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_VARIANT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontVariantManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze3BU1Rk/uwl5EUgIBJBHeAWUh7uCUEtDURKILG4gEmRK" +
       "UJKzd88mF+7ee7n3bLLBUpFpC+1UBhERHWX6Bw6WojBOnT6sFsdplWqdqrRo" +
       "HbEPZ6RSpjKd2k5ppd937r17H5vdmJnSnbln757zfed8j9/3ne+cPXGJjDAN" +
       "0sBUHuEDOjMjq1TeTg2TJVsUapoboK9LeqSE/m3LhbVLw6Ssk4zupWabRE3W" +
       "KjMlaXaSqbJqcqpKzFzLWBI52g1mMqOPcllTO0m9bMbSuiJLMm/TkgwJNlIj" +
       "TsZQzg05keEsZk/AydQ4SBIVkkRXBIeb4qRa0vQBl3yih7zFM4KUaXctk5Pa" +
       "+FbaR6MZLivRuGzypqxB5uuaMtCjaDzCsjyyVVlim2BNfEmeCWaeqvn0yv7e" +
       "WmGCsVRVNS7UM9czU1P6WDJOatzeVQpLm9vJ10hJnIz0EHPSGHcWjcKiUVjU" +
       "0dalAulHMTWTbtGEOtyZqUyXUCBOZvgn0alB0/Y07UJmmKGC27oLZtB2ek5b" +
       "S8s8FR+eHz34yJbaZ0tITSepkdUOFEcCITgs0gkGZekEM8wVySRLdpIxKji7" +
       "gxkyVeQdtqfrTLlHpTwD7nfMgp0ZnRliTddW4EfQzchIXDNy6qUEoOxfI1IK" +
       "7QFdx7u6Whq2Yj8oWCWDYEaKAu5sltJtsprkZFqQI6dj4x1AAKzlacZ7tdxS" +
       "pSqFDlJnQUShak+0A6Cn9gDpCA0AaHAyqeCkaGudSttoD+tCRAbo2q0hoKoU" +
       "hkAWTuqDZGIm8NKkgJc8/rm0dtm+e9XVapiEQOYkkxSUfyQwNQSY1rMUMxjE" +
       "gcVYPS9+iI5/YW+YECCuDxBbND/86uXbFjScftWimTwIzbrEVibxLuloYvSb" +
       "U1rmLi1BMSp0zZTR+T7NRZS12yNNWR0yzPjcjDgYcQZPr//Fpl3H2cUwqYqR" +
       "MklTMmnA0RhJS+uywozbmcoMylkyRiqZmmwR4zFSDu9xWWVW77pUymQ8RkoV" +
       "0VWmid9gohRMgSaqgndZTWnOu055r3jP6oSQcnhINTyziPUR35wo0V4tzaJU" +
       "oqqsatF2Q0P9zShknATYtjeaANRvi5paxgAIRjWjJ0oBB73MHpBMpO0BmaJ9" +
       "VMkw7FgUbQVTQVTKENZtVAVgGBFEnf5/Xi+L+o/tD4XANVOCiUGBmFqtKUlm" +
       "dEkHM82rLj/T9ZoFOgwU23KcLAURIpYIESFCBFaMWCJEhAjYsSiSLwIJhcTK" +
       "41AUCxDgzm2QGCAzV8/tuGdN996ZJYBEvb8UfIGkM307VIubPZyU3yWdrBu1" +
       "Y8b5hS+HSWmc1FGJZ6iCG84KowdSmbTNjvbqBOxd7hYy3bOF4N5naBJLQgYr" +
       "tJXYs1RofczAfk7GeWZwNjgM5Wjh7WVQ+cnpw/33b7zvpjAJ+3cNXHIEJDxk" +
       "b8dcn8vpjcFsMdi8NXsufHry0E7NzRu+bcjZPfM4UYeZQWwEzdMlzZtOn+t6" +
       "YWejMHsl5HVOAQCQMhuCa/jSUpOT4lGXClA4pRlpquCQY+Mq3mto/W6PAO0Y" +
       "bOot/CKEAgKK3eHLHfoT77zx55uFJZ2NpMZTAXQw3uRJXjhZnUhTY1xEbjAY" +
       "A7r3D7c/9PClPZsFHIFi1mALNmLbAkkLvAMW/Mar29/94PzRs2EXwhx270wC" +
       "iqCs0GXcVfiE4PkMH0w42GElnroWO/tNz6U/HVee48oGiVCB5IDgaLxLBRjK" +
       "KZkmFIbx8++a2Quf+8u+WsvdCvQ4aFkw9ARu/3XNZNdrW/7RIKYJSbgRu/Zz" +
       "yazsPtadeYVh0AGUI3v/W1MffYU+AfsE5GZT3sFEuiXCHkQ4cImwxU2iXRwY" +
       "uwWb2aYX4/4w8hRMXdL+s5+M2vjJi5eFtP6Ky+v3Nqo3WSiyvACLfYnYjS/9" +
       "4+h4HdsJWZBhQjBRraZmL0y2+PTau2uV01dg2U5YVoLEbK4zIHFmfVCyqUeU" +
       "/+6ll8d3v1lCwq2kStFospWKgCOVgHRm9kLOzeq33mbJ0V8BTa2wB8mzUF4H" +
       "emHa4P5dlda58MiOH034wbJjR84LWOrWHJNzGXaKL8OK4t4N8uNv3/KbYw8e" +
       "6rfKg7mFM1uAb+K/1imJ3X/8Z55fRE4bpHQJ8HdGTzw+qWX5RcHvJhfkbszm" +
       "b12QoF3eRcfTfw/PLPt5mJR3klrJLqY34sYEcd0JBaTpVNhQcPvG/cWgVfk0" +
       "5ZLnlGBi8ywbTGvulgnvSI3vowIYnIwuXA7PDTYGbwhiMETEyxrBMke0c7FZ" +
       "INxXwkmlbmgcpGRQAJeZonLnIImsUiWbW0dAZVKRdYBXbNymYJnIyfyh93ir" +
       "VAZ4WykZ2y9ic4e17rLB8JwdXI8Qvt7oyis+ZUVi0wNhgnE6tVD1LCr/o7sP" +
       "Hkmue3KhBeI6f0W6Cg5cT//2P69HDv/+zCDFTiXX9BsV1scUz5rluKQvbNrE" +
       "wcLF4PujD/zpx409zcOpSbCvYYiqA39PAyXmFY7EoCiv7P540oblvd3DKC+m" +
       "BcwZnPJ7bSfO3D5HOhAWpygrOPJOX36mJn9IVBkMjovqBl9gzMoBYCw6dg48" +
       "i20ALA4Ghgu6Odh8xY/1qiKsRfYeuciYcBkE2VjZjKm9cP6FkIOqSBxx/XUq" +
       "+rkjkzChppTTUGf02cexRe3d0t7G9g8tGF43CINFV/9U9IGN57a+LhxWgQjJ" +
       "mcmDDkCSpzqqxSaCoVAkRwfkie6s+2Db4xeetuQJJuQAMdt78NtXI/sOWiFi" +
       "Hbhn5Z15vTzWoTsg3YxiqwiO1o9O7nz+qZ17wrbd7+akPKFpCqNqzi+h3OY1" +
       "zm9FS9aV36r56f66klYIvhipyKjy9gyLJf0ALDczCY9Z3TO6C0dbaizQOAnN" +
       "c3ZOkeRYkST3OTZt7GjWRX+3H/TXw9NkI7dp+KAvxFoE2F8vMvZNbO6Do45s" +
       "rlDlNOVYKzqoxzHNNcmua2WS2fA023o1D98khViLqP1gkbGHsPkOFAoy3ogJ" +
       "7BYwyAPXwCA1ONYAT8zWKjZ8gxRiLaL0kSJj38XmUai3exh3LJE7u6XtyMcv" +
       "3fPOOSmR7RtOT0TjzwFPmD12DUxYh2Mz4LnTtsOdwzdhIdYiZjpVZOxZbL7v" +
       "N+FayFVONVYrCnysSe2qy7XQiWtgoTE4Nh2eTbaam4ZvoUKsRazwsyJjL2Hz" +
       "E8tCK1mKZhSrYHcsdP3Q9apLLwz3/DUwXD2OYa3abWvfPXzDFWItYpw3ioz9" +
       "GpsznIwGw8WSsFvCgZ9ZdWWHa4xf/i+MkYWkmH/nhwfUiXl/QVjX5tIzR2oq" +
       "Jhy565wok3NX29VQ9qQyiuI9Qnney3SDpWShXbV1oNLF1zuczPl8V5OclOKX" +
       "UOScxfweJzOGZIaTVV8ORTbjeU4mF2GEk5X14uX5A+yog/FAUoTWS/khBH+Q" +
       "EqQQ3166jzipculgUevFS/IxzA4k+HpRd+Lm5qEN5qLG9mg25D9+5VBUPxSK" +
       "PCe2Wb4yVfyT5dRxGeu/rC7p5JE1a++9/IUnres8SaE7duAsI6F6sy4NcweW" +
       "GQVnc+YqWz33yuhTlbOdstJ3neiVTWAZtiJx9TYpcL9lNuauud49uuzFX+0t" +
       "ewsK4s0kROFgsDn/6iCrZ+CkuDmeX6WKIIFiqmnuYwPLF6T++p64nCF5VzJB" +
       "+i7p7LF73j4w8WhDmIyMkRFQMbOsuNNYOaCuZ1Kf0UlGyeaqLIiIfqOKrwQe" +
       "jTFGcQsRdrHNOSrXi/e8nMzML+zzb8erFK2fGc1aRk3iNFBEj3R7nIOr78yX" +
       "0fUAg9vjOctkrToBvQGQ7Yq36bpzSVo6XRfJZmDwwgHbz8QrNlf/Cxg0tP7l" +
       "HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qSA+So4DSBBPnis/H+scFvbbJ3T27otUc6bbi0RzuiKA97J2+f7IBW55V2nl" +
       "j4DnQ0fc8qGL3HIJql4+Wok8W6U3y+SD1Zg8kEIPR3GYAi0tEN9dTarANAWa" +
       "OIHmVZ09D7KrJSephN+WQrXXXp0OQR7wpQO1lSlSJtjBITr3dJ7bVZe7S4Bj" +
       "HmzeQm/Vy+/0PZQvXz9UJsMyIY7VfcfaM24e844E4mrgNjfXHnqs/43K48sB" +
       "OtLzgpLP/6WVBB792GljdAji2k/98We+/lPPfQu4HQU9WBkDeNuZHpmsDPV/" +
       "8ouffc8PvPztT1WkChhV+rv/CP122ar4+qA+VULlq7iF1pJ0WnGfZVZo7zvb" +
       "ZrHjg+ViexTHwi898S33F77zpUOMenFqXahsffLlv/cXtz798uUzvwyeuyM4" +
       "Pytz+HVQKf2WIwvH0LP366WSIP7kKy/99i+/9ImDVk+cj3OH4Gfcl/7N//n6" +
       "rc99+/fuEkJd8cI3MLDp9SvjVkJix390Q7WQvtjgXDjLvfZQtMk+1R9bmCyu" +
       "0AwXh+lA5CYkPWrZQ5+biNSkMLtdn6ihloUGiE7TfTEiIrzWEPurITeWF51+" +
       "3pHDdZ8NhE5CJGbkyRtzE3PhWB/O1A7HR+uJ2XTbUWT2EDRuoOP21vSpgA90" +
       "L0DbaLG0zO66ByOBVTNmixG1HmBMPemL42w4YNfT9aYhWILdFCgpEbUo1MNJ" +
       "j7Y2/BD2EXqlS3Te4RO3VWSRrOncEJEn66mnLTR+o1MbYxNNCqKg5T7ZbtoN" +
       "f7phZ4bnCWzd7+lTnc8cip76sODaOcV45FpI1Hlh19uuNUxUF8b25rzF90nJ" +
       "dblFn7T01obT6tt530P2zgotiGlrImoLI3XbM61G6BrXmaq0s+WyUbGPNrt+" +
       "O8u0aYqvtUGBJ+v9XpI8x2/2meXQt3BZszbboL7fopbsj/BE4iSGR8VpzyjE" +
       "xqwjDyhWSwtLmke039tSjfqKCsiiPhzP+NHYkNfGxBGltVg3NQ/LvPFUkAU9" +
       "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");
}
