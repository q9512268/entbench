package org.apache.batik.css.parser;
public class DefaultPseudoClassCondition extends org.apache.batik.css.parser.AbstractAttributeCondition {
    protected java.lang.String namespaceURI;
    public DefaultPseudoClassCondition(java.lang.String namespaceURI, java.lang.String value) {
        super(
          value);
        this.
          namespaceURI =
          namespaceURI;
    }
    public short getConditionType() { return SAC_PSEUDO_CLASS_CONDITION;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return null; }
    public boolean getSpecified() { return false; }
    public java.lang.String toString() { return ":" + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za2wUx3nujN9v84wBY4wh4pG7kAYiakIDxg4mZ2NhQK1J" +
                                                              "OOb25nyL93aX3Tn77NRpglJBU5USSoBWxL+ISBABVDVKqjSIKE2TKGmlJLQJ" +
                                                              "rUKqtlJpU9SgqmlV2qbfzOzt6x7UUqmlnd2b+b5vvvf3zfjMNVRqGqiFqDRE" +
                                                              "x3RihrpU2o8Nk8Q7FWya22AuKh0rwX/ZdbVvTRCVDaK6JDZ7JWySbpkocXMQ" +
                                                              "zZdVk2JVImYfIXGG0W8QkxgjmMqaOohmymZPSldkSaa9WpwwgB3YiKBGTKkh" +
                                                              "x9KU9FgEKJofAU7CnJPwev9yRwTVSJo+5oDPcYF3ulYYZMrZy6SoIbIHj+Bw" +
                                                              "mspKOCKbtCNjoOW6powNKRoNkQwN7VFWWSrYHFmVo4K28/Wf3TiUbOAqmI5V" +
                                                              "VaNcPHMrMTVlhMQjqN6Z7VJIytyLHkElEVTtAqaoPZLdNAybhmHTrLQOFHBf" +
                                                              "S9R0qlPj4tAspTJdYgxRtNBLRMcGTllk+jnPQKGCWrJzZJC21ZZWSJkj4lPL" +
                                                              "w0eO7Wr4fgmqH0T1sjrA2JGACQqbDIJCSSpGDHN9PE7ig6hRBWMPEEPGijxu" +
                                                              "WbrJlIdUTNNg/qxa2GRaJwbf09EV2BFkM9IS1QxbvAR3KOtXaULBQyDrLEdW" +
                                                              "IWE3mwcBq2RgzEhg8DsLZdqwrMYpWuDHsGVsfwAAALU8RWhSs7eapmKYQE3C" +
                                                              "RRSsDoUHwPXUIQAt1cABDYqaCxJlutaxNIyHSJR5pA+uXywBVCVXBEOhaKYf" +
                                                              "jFMCKzX7rOSyz7W+tQcfVjepQRQAnuNEUhj/1YDU4kPaShLEIBAHArFmWeQo" +
                                                              "nvXKgSBCADzTByxgXvzq9ftWtFx8U8DMzQOzJbaHSDQqnYzVvTuvc+maEsZG" +
                                                              "ha6ZMjO+R3IeZf3WSkdGhwwzy6bIFkPZxYtbf/KVR0+TT4KoqgeVSZqSToEf" +
                                                              "NUpaSpcVYtxPVGJgSuI9qJKo8U6+3oPK4Tsiq0TMbkkkTEJ70DSFT5Vp/Deo" +
                                                              "KAEkmIqq4FtWE1r2W8c0yb8zOkKoHB5UA888JP74m6I94aSWImEsYVVWtXC/" +
                                                              "oTH5zTBknBjoNhmOgdcPh00tbYALhjVjKIzBD5LEWpBMk0UmJMLwRpLAaYX2" +
                                                              "myQd17hFIariXAEh5nP6/3W3DJN9+mggAGaZ508KCsTTJk2JEyMqHUlv6Lp+" +
                                                              "Nvq2cDgWJJbWKLoHGAgJBkKcgRAwEBIMhIowgAIBvu8MxohwBTDkMKQEyMk1" +
                                                              "Swce2rz7QFsJ+KA+Og2swEDbPLWp08kb2WQflc411Y4vvLLytSCaFkFNWKJp" +
                                                              "rLBSs94YgiQmDVtxXhODquUUj1ZX8WBVz9AkEofcVaiIWFQqtBFisHmKZrgo" +
                                                              "ZEsbC+Jw4cKSl3908fjoYzu+dmcQBb31gm1ZCqmOofezLG9n83Z/nshHt37/" +
                                                              "1c/OHZ3QnIzhKUDZupmDyWRo83uGXz1RaVkrfiH6ykQ7V3slZHSKIQIhWbb4" +
                                                              "9/AkpI5scmeyVIDACc1IYYUtZXVcRZOGNurMcJdt5N8zwC2qWYQugWexFbL8" +
                                                              "zVZn6WycLVyc+ZlPCl487h3Qn/7wZ3/4Ald3ts7UuxqEAUI7XLmNEWviWazR" +
                                                              "cdttBiEA99Hx/u88dW3/Tu6zALEo34btbOyEnAYmBDV//c29lz++cvJS0PFz" +
                                                              "CsU9HYMeKWMLyeZRVREhYbclDj+QGxXIGMxr2rer4J9yQsYxhbDA+mf94pUv" +
                                                              "/Olgg/ADBWaybrTi5gSc+ds2oEff3vW3Fk4mILHa7OjMARMJf7pDeb1h4DHG" +
                                                              "R+ax9+Z/9w38NJQOSNemPE54Bg5yHQS55HOgVeOYrAyHRBlm86u5SVdxmDv5" +
                                                              "eDdTB8dEfG0NGxab7tDwRp+rw4pKhy59Wrvj0wvXuSzeFs3tCb1Y7xDOx4Yl" +
                                                              "GSA/25+6NmEzCXB3X+x7sEG5eAMoDgJFCdK0ucWARJrx+I0FXVr+y1dfm7X7" +
                                                              "3RIU7EZViobj3ZiHIKoE3ydmEnJwRv/SfcL0oxUwNHBRUY7wORNM/QvyG7Yr" +
                                                              "pVNuivGXZv9g7anJK9wHdUFjrp1z53lyLm/0nbA//f49Pz/15NFR0SosLZzr" +
                                                              "fHhz/rFFie37zd9zVM6zXJ42xoc/GD5zorlz3Scc30k3DLs9k1vKIGU7uHed" +
                                                              "Tv012Fb2ehCVD6IGyWqsd2AlzYJ4EJpJM9ttQ/PtWfc2hqIL6rDT6Tx/qnNt" +
                                                              "6090TgmFbwbNvmt9ua2OmbANnlYr7Fv9uS2A+McDHOV2Pi5jwx3ZVFKpGxoF" +
                                                              "Lkncl01qi5ClqIaxZ0JNJ9u39vCYE1mUjV9kQ0SQuzefV4ql29mw3N6U/5X5" +
                                                              "Wyt3CnPcDrHYml+o++Wd+8l9RybjW55ZKRyvydtRdsGB6flf/Oud0PFfv5Wn" +
                                                              "Yamkmn6HQkaI4tqTHX3ne1y9lx8MHL/5qO7wb3/YPrRhKp0Fm2u5Se/Afi8A" +
                                                              "IZYVjh4/K2/s+2PztnXJ3VNoEhb41Okn+VzvmbfuXyIdDvJTkHDonNOTF6nD" +
                                                              "68ZVBoHjnrrN48yLbAdoZIZdCE/IcoBQ/kKdx3fs8lcItUgpIEXWeDXZDVVm" +
                                                              "iFC7LeWdhqfVZEYeSMdMaAvlFMCMWGepu/p3Swfa+38nfPC2PAgCbuaz4W/t" +
                                                              "+GDPO9xaFcw9bB25XAPcyNXgNAjhP4e/ADz/Zg/jm02wN2SiTutg1GqfjFjy" +
                                                              "LpqFfQKEJ5o+Hj5x9XkhgD/l+oDJgSNPfB46eEQElDheL8o54bpxxBFbiMMG" +
                                                              "hXG3sNguHKP79+cmXn52Yn/QstKXKQRnUjOobcOAXZxmeJUuON34jfofHWoq" +
                                                              "6YZA7UEVaVXemyY9ca+zlpvpmMsKznnccV2LZ6ZxigLLspWRpz9cJP39F0WZ" +
                                                              "TXTqfP5B28ubsgGy2vLy1VMPkEKoRYJgX5G1x9kwAW0QBEifvyI42njkVmmj" +
                                                              "BZ51lkjrpq6NQqhFJP52kbUn2fAEFEfQRkSTsNJn+ZNLFd+8BaqYztYWwNNt" +
                                                              "ydM9dVUUQi0i7okia5NsOCZUMaATCc4HRNyhyVaks5fq+oajYHlM0xSCVX8c" +
                                                              "s5+jruA6fqvcqRmeXksRvVPXYSHUIno6W2TtPBueo6iCaq6zjaOG0/8LNWQo" +
                                                              "mlvkDoYdD+bkXAaLC0zp7GR9xezJ7R/whse+ZKyBGpZIK4q7gXV9l+kGSchc" +
                                                              "wBrRzur89RIwUuSiiB16+QcX5EWB8zJFM/LhUFQCoxvyAhRxPySUDf52w71K" +
                                                              "UZUDB5uKDzfIj4E6gLDP1/XsOXR1sTuu9VDpDegH7X9S2OrNBLxdrW3bmTez" +
                                                              "rasRXuSp5/yCP1vy0uKKPyqdm9zc9/D11c+IawxJwePjjEo1FDpxo2L3gQsL" +
                                                              "UsvSKtu09Ebd+crF2frbKBh24mOuy4k7IX515kXNvjO+2W4f9S+fXHvhpwfK" +
                                                              "3oPOYScKYIqm78w9RWX0NDTgOyO5BR16Zn750LH0e2PrViT+/Ct+TkU5p1M/" +
                                                              "fFS6dOqh9w/POdkSRNU9qBRaC5Lhx7uNY+pWIo0Yg6hWNrsywCJQkbHi6Rbq" +
                                                              "mMNjFpdcL5Y6a+1ZdglGUVtuB5R7dQhn+lFibNDSapyRgX6j2pnx/OfBCqKq" +
                                                              "tK77EJwZV5c4IhIsswZ4bTTSq+vZBrF8ic5TwGj+bMvGD/knGy7/BwhsaPP8" +
                                                              "GwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uHtOB58Tw54OPcc7BKjn1Hn93Kloc2s+yw+B54EDR3zgdLQ5AxUVtGB5sCgv" +
       "5sWPHzr3zX7gRUBLXTvw7++Dzxnw/Hf+5OLyht0mfnvnIJN44CiV8MH2dUuu" +
       "agi2L33KkYVH7GJcXtbzAtuJbr2ozbwuL7rpGaDPDdX91n4hgL66ztfl1Z8A" +
       "USksMmrAYSxd2S5mphsBH7DVi4d6CiDDBkZzcWW3rqZX93+tF7DdW499n/FA" +
       "Nvuef3jfl3/54a8DA6OgGzb54gO7OhEg2DhP8N/x3AfufdlT33hPEVDBhAu/" +
       "+KnWN3Kpk2uhy4thXowOYd2dw+KLfIWRw2hQxEBdy5Fd269GwdIBW8XmIHuF" +
       "n7z969aHvvmxXWZ62olOEevveurd399/71N7J94HHr4iJT/Js3snKJR++cEM" +
       "B9CD1xql4Oj+4yee/OPfevKdO61uvzy7JcDL28f+8r++vP/0N754leTpetvb" +
       "xeH/08JGt4769ZBEDz9MWZKryTStufGKRTbteoLN64lZ93stC50vZYvE00Xd" +
       "kaqsOaYr1HCoVBtuxiA1eVabuK0Wy/kLm8KmjSnPe5iYMiWSx1BMwAV6veJJ" +
       "mqhO6J5jU8yYCqb0OrIpf4rwi7VjC9W1YmyH26iZtqZT0OBqVaWkNDabjVHb" +
       "GqsBK3Dr3nrZXeMckda4pRn406rXZq32uNUVM7laRWPaLAfJDJY0RdhMuI6A" +
       "y3STwqUWJWa84lueOhuMt5ImWFVKIJ25Qc56vbLYHlvpYuUM1vLQM53MkUa8" +
       "rVm8LCOinyQLrDZf0lhvQltmitBTpLsgaMoz0Gmr41KjRN8gGZdMBJ7ySg0P" +
       "H6nzbi2253NpEEhZk/dIheyvSljihD497NBK1GFX3lBs+l7C0pzHWuOEbQld" +
       "UeSDeb/rCF6drrZh0ahNllNliK4dsiEIMquO+oNgMBFsczBerdmm1BIoMosy" +
       "pm8RNiFMInQteyOJ0Vg0U0ynPwmY8bDbxwwe4cpre7SqR2joTyhtvki5iMUY" +
       "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");
}
