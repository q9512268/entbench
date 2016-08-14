package org.apache.batik.css.engine.value.svg;
public class ImageRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZEQUALITY_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZEQUALITY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_IMAGE_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ImageRenderingManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze5AUxRnv3YN7cXAPOEAeBxwHFA93RSXGOiTCccjhHlzd" +
       "IZUsytE723s3MDszzPTe7WGISCWBpCKFiIiWXuUPLAxBoaxYeRgNlpUo0VhR" +
       "SdBYYh5WSSRUpFIxqZBIvq9nZuexj/OqQrZqeme7v6/7e/y+r7/uPXGJjDUN" +
       "0sRUHuFDOjMj7SrvoobJkm0KNc2N0NcrPVJG/7blwvpbw6Q8Tib0U7NToiZb" +
       "IzMlacbJTFk1OVUlZq5nLIkcXQYzmTFAuaypcdIomx1pXZElmXdqSYYEm6gR" +
       "I/WUc0NOZDjrsCfgZGYMJIkKSaIrg8OtMVIjafqQSz7VQ97mGUHKtLuWyUld" +
       "bBsdoNEMl5VoTDZ5a9Ygi3VNGepTNB5hWR7ZpiyzTbAutizPBM2naj+9cqC/" +
       "TphgIlVVjQv1zG5masoAS8ZIrdvbrrC0uYN8jZTFyDgPMSctMWfRKCwahUUd" +
       "bV0qkH48UzPpNk2ow52ZynUJBeJkjn8SnRo0bU/TJWSGGSq5rbtgBm1n57S1" +
       "tMxT8eHF0UOPbKl7tozUxkmtrPagOBIIwWGROBiUpRPMMFcmkywZJ/UqOLuH" +
       "GTJV5J22pxtMuU+lPAPud8yCnRmdGWJN11bgR9DNyEhcM3LqpQSg7F9jUwrt" +
       "A10nu7paGq7BflCwWgbBjBQF3NksY7bLapKTWUGOnI4tdwIBsFakGe/XckuN" +
       "USl0kAYLIgpV+6I9AD21D0jHagBAg5NpRSdFW+tU2k77WC8iMkDXZQ0BVZUw" +
       "BLJw0hgkEzOBl6YFvOTxz6X1y/ffq65VwyQEMieZpKD844CpKcDUzVLMYBAH" +
       "FmPNothhOvmFfWFCgLgxQGzR/PCrl29f0nT6VYtmegGaDYltTOK90tHEhDdn" +
       "tC28tQzFqNQ1U0bn+zQXUdZlj7Rmdcgwk3Mz4mDEGTzd/Yuv7D7OLoZJdQcp" +
       "lzQlkwYc1UtaWpcVZtzBVGZQzpIdpIqpyTYx3kEq4D0mq8zq3ZBKmYx3kDGK" +
       "6CrXxG8wUQqmQBNVw7uspjTnXae8X7xndUJIBTykBp5mYn3ENydqtF9LsyiV" +
       "qCqrWrTL0FB/MwoZJwG27Y8mAPXbo6aWMQCCUc3oi1LAQT+zByQTaftApugA" +
       "VTIsag70RTvSgIVuEJohvjqpCj+NCOJO/7+vmEUbTBwMhcA9M4LJQYG4Wqsp" +
       "wNUrHcqsar/8TO9rFvAwWGzrcdIKQkQsISJCiAgIEbGEiAghIiBEpKAQJBQS" +
       "a09CYSxYgFO3Q3qA/FyzsOeedVv3NZcBHvXBMeARJG327VNtbg5xEn+vdLJh" +
       "/M4555e+HCZjYqSBSjxDFdx2Vhp9kNCk7XbM1yRgB3M3ktmejQR3QEOTWBLy" +
       "WLENxZ6lUhtgBvZzMskzg7PNYUBHi28yBeUnp48M3r/pvhvCJOzfO3DJsZD2" +
       "kL0LM34us7cEc0aheWv3Xvj05OFdmps9fJuRs4fmcaIOzUF0BM3TKy2aTZ/r" +
       "fWFXizB7FWR3TgECkDibgmv4klOrk+hRl0pQOKUZaargkGPjat5vaINuj4Bt" +
       "PTaNFoIRQgEBxR5xW4/+xDtv/PkmYUlnO6n11AE9jLd6UhhO1iCSVb2LyI0G" +
       "Y0D3/pGuhx6+tHezgCNQzC20YAu2bZC6wDtgwW+8uuPdD84fPRt2IcxhD88k" +
       "oBTKCl0mXYVPCJ7P8MG0gx1W+mlos3Pg7FwS1HHl+a5skA4VSBAIjpa7VICh" +
       "nJJpQmEYP/+unbf0ub/sr7PcrUCPg5YlI0/g9l+3iux+bcs/msQ0IQm3Y9d+" +
       "LpmV4ye6M680DDqEcmTvf2vmo6/QJ2C3gAxtyjuZSLpE2IMIBy4TtrhBtDcH" +
       "xm7BZp7pxbg/jDxlU6904Own4zd98uJlIa2/7vL6vZPqrRaKLC/AYrcRu/Ft" +
       "Ajg6Wcd2ShZkmBJMVGup2Q+T3Xx6/d11yukrsGwclpUgOZsbDMh1WR+UbOqx" +
       "Fb976eXJW98sI+E1pFrRaHINFQFHqgDpzOyHrJvVv3S7JcdgJTR1wh4kz0J5" +
       "HeiFWYX9257WufDIzh9N+cHyY8PnBSx1a47puQw7w5dhRYnvBvnxt2/5zbEH" +
       "Dw9aRcLC4pktwDf1XxuUxJ4//jPPLyKnFShgAvzx6InHp7WtuCj43eSC3C3Z" +
       "/M0LErTLe+Px9N/DzeU/D5OKOKmT7JJ6E25NENdxKCNNp86Gsts37i8Jrfqn" +
       "NZc8ZwQTm2fZYFpzN014R2p8Hx/A4HR04Qp4FtgYXBDEYIiIl3WCZb5oF2Kz" +
       "RLivjJMq3dA4SMmgDC43Rf3OQRJZpUo2t46AyrQS6wCv2LpNwTKVk8Uj7/JW" +
       "wQzwtlIytl/E5k5r3eWF8JwtrEcIX6935RWf8hKx6YEwwTidWayGFvX/0T2H" +
       "hpMbnlxqgbjBX5e2w7Hr6d/+5/XIkd+fKVDuVHFNv15hA0zxrFmBS/rCplMc" +
       "L1wMvj/h4J9+3NK3ajQ1CfY1jVB14O9ZoMSi4pEYFOWVPR9P27iif+soyotZ" +
       "AXMGp/xe54kzd8yXDobFWcoKjrwzmJ+p1R8S1QaDQ6O60RcYc3MAmIiOnQ/P" +
       "MhsAy4KB4YJuPjZf9mO9ugRrib1HLjEmXAZBNlE2O9R+qGoh5KAqEgddf52K" +
       "fu7JJEyoKeU01BkD9qHsxq6t0r6Wrg8tGF5XgMGia3wq+sCmc9teFw6rRITk" +
       "zORBByDJUx3VYRPBUCiRowPyRHc1fLD98QtPW/IEE3KAmO079O2rkf2HrBCx" +
       "jt1z806+Xh7r6B2Qbk6pVQTHmo9O7nr+qV17w7bd7+akIqFpCqNqzi+h3OY1" +
       "yW9FS9bV36r96YGGsjUQfB2kMqPKOzKsI+kHYIWZSXjM6p7UXTjaUmOBxklo" +
       "kbNziiTHSiS5z7FpY8cqXfRv9YMeM/NyG7nLRw/6YqwlgP31EmPfxOY+OOrI" +
       "5kpVTlOOtaKDehzTXJPsvlYmmQdPm61X2+hNUoy1hNoPlhh7CJvvQKEg472Y" +
       "wG4RgzxwDQxSi2NN8KyztVo3eoMUYy2h9HCJse9i8yjU232MO5bInd3SduTj" +
       "l+5555yUyfY9pyei8eeQJ8weuwYmbMCxOfB023boHr0Ji7GWMNOpEmPPYvN9" +
       "vwnXQ65yqrE6UeBjTWpXXa6FTlwDC9Xj2Gx44raa8dFbqBhrCSv8rMTYS9j8" +
       "xLLQapaiGcUq2B0LLRi5XnXpheGevwaGa8SxufBQW3s6esMVYy1hnDdKjP0a" +
       "mzOcTADDdSRht4QDP7Pqyh7XGL/8Xxgjy0ljwWs/PKNOzfsvwro/l54Zrq2c" +
       "MnzXOVEp5+64a6DySWUUxXuK8ryX6wZLyULBGutMpYuvdziZ97nuJyH9QCs0" +
       "OWexvsfJnBFZ4Wg1kIORzXiek+klGOFoZb14ef4AW2ohHhALWi/lhxD9QUqQ" +
       "Qnx76T7ipNqlg0WtFy/JxzA7kODrRd0JnJtGNpcLG9uf2ZD//JWDUeNIMPIc" +
       "2eb66lTxh5ZTyGWsv7R6pZPD69bfe/kLT1r3eZJCd+7EWcZB+WbdGuZOLHOK" +
       "zubMVb524ZUJp6rmOXWl7z7RK5sAM+xF4u5tWuCCy2zJ3XO9e3T5i7/aV/4W" +
       "VMSbSYjCyWBz/t1BVs/AUXFzLL9MhdOduHlrXfjY0Iolqb++J25nSN6dTJC+" +
       "Vzp77J63D0492hQm4zrIWCiZWVZcaqweUruZNGDEyXjZbM+CiOg3qvhq4AkY" +
       "YRSDU9jFNuf4XC9e9HLSnF/Z51+PVyvaIDNWaRk1idNAFT3O7XFOrr5DX0bX" +
       "Awxuj+cwk7UKBfQGQLY31qnrzi3pmBZdZJuhwpUDtp+JV2yu/hfskFj97B4A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
