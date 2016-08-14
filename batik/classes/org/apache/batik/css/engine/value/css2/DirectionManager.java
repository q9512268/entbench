package org.apache.batik.css.engine.value.css2;
public class DirectionManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_LTR_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LTR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RTL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          RTL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_DIRECTION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 LTR_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public DirectionManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze2wcxRmfOzt+xa84cRLycF5OIA/uIEBD5DQlcZzE4Rxb" +
                                                              "cQitA3Hm9ubsjfd2N7tz9jk0BaK2pFVBPEIICKL+ERSaBhKhoj4oNAi1QKGo" +
                                                              "PFqgiNAHEhSKSlSVVqWFft/M7u3jfGcsNT1p5/Zmvm/me/zm+76ZO/khmWRb" +
                                                              "pIXpPMZHTWbHOnTeQy2bpdo1atvboa9fuaeM/m3Xe1tXR0lFH6kfpHaXQm22" +
                                                              "UWVayu4jc1Xd5lRXmL2VsRRy9FjMZtYw5aqh95Fm1e7MmJqqqLzLSDEk2EGt" +
                                                              "BJlCObfUZJazTmcCTuYmQJK4kCS+LjzcliC1imGOeuQzfeTtvhGkzHhr2Zw0" +
                                                              "JvbQYRrPclWLJ1Sbt+Usstw0tNEBzeAxluOxPdoVjgm2JK4oMMHC0w0ff3L7" +
                                                              "YKMwwVSq6wYX6tnbmG1owyyVIA1eb4fGMvZe8jVSliCTfcSctCbcReOwaBwW" +
                                                              "dbX1qED6OqZnM+2GUIe7M1WYCgrEyYLgJCa1aMaZpkfIDDNUcUd3wQzazs9r" +
                                                              "K7UsUPHu5fFD9+xqfLSMNPSRBlXvRXEUEILDIn1gUJZJMstel0qxVB+ZooOz" +
                                                              "e5mlUk3d53i6yVYHdMqz4H7XLNiZNZkl1vRsBX4E3ayswg0rr15aAMr5NSmt" +
                                                              "0QHQdbqnq9RwI/aDgjUqCGalKeDOYSkfUvUUJ/PCHHkdW68GAmCtzDA+aOSX" +
                                                              "KtcpdJAmCRGN6gPxXoCePgCkkwwAoMXJrKKToq1NqgzRAdaPiAzR9cghoKoW" +
                                                              "hkAWTprDZGIm8NKskJd8/vlw65rbbtA361ESAZlTTNFQ/snA1BJi2sbSzGKw" +
                                                              "DyRj7bLEYTr9iYNRQoC4OUQsaX741XNXrWg586ykmT0GTXdyD1N4v3IsWf/S" +
                                                              "nPalq8tQjCrTsFV0fkBzsct6nJG2nAkRZnp+RhyMuYNntv3iKzedYB9ESU0n" +
                                                              "qVAMLZsBHE1RjIypaszaxHRmUc5SnaSa6al2Md5JKuE9oepM9nan0zbjnaRc" +
                                                              "E10VhvgNJkrDFGiiGnhX9bThvpuUD4r3nEkIqYSH1MKziMiP+OZkT3zQyLA4" +
                                                              "Vaiu6ka8xzJQfzsOEScJth2MJwH1Q3HbyFoAwbhhDcQp4GCQOQOKjbQDIFN8" +
                                                              "mGpZhh0r4xtUC2YBzbuoDrCwYog58/+6Wg51nzoSiYBb5oSDggb7abOhpZjV" +
                                                              "rxzKru8490j/8xJwuEkcq3GyCgSISQFiQoAYrBeTAsSEANixMhYWgEQiYt1p" +
                                                              "KIiEAjhyCEICxOTapb3Xb9l9cGEZYNAcKQcvIOnCQG5q9+KGG+z7lVNNdfsW" +
                                                              "nL306SgpT5AmqvAs1TDVrLMGIIgpQ84+r01C1vKSx3xf8sCsZxkKS0HsKpZE" +
                                                              "nFmqjGFmYT8n03wzuKkNN3G8eGIZU35y5sjIzTtuvCRKosF8gUtOglCH7D0Y" +
                                                              "5fPRvDUcJ8aat+GW9z4+dXi/4UWMQAJy82YBJ+qwMIyMsHn6lWXz6WP9T+xv" +
                                                              "FWavhojOKbgfgmVLeI1AQGpzgzvqUgUKpw0rQzUccm1cwwctY8TrEZCdgk2z" +
                                                              "RC9CKCSgyAtf7DUfeP3FP18mLOmmkAZf7u9lvM0XtnCyJhGgpniI3G4xBnRv" +
                                                              "Hem56+4Pb9kp4AgUi8ZasBXbdghX4B2w4Dee3fvG22ePvRr1IMwhb2eTUP7k" +
                                                              "hC7TPoNPBJ5P8cFQgx0y5DS1O3Fvfj7wmbjyEk82CIGa3FF26zU6wFBNqzSp" +
                                                              "Mdw//25YfOljf7mtUbpbgx4XLSvGn8Drv2A9uen5Xf9oEdNEFEzBnv08MhnX" +
                                                              "p3ozr7MsOopy5G5+ee69z9AHIENAVLbVfUwEWiLsQYQDrxC2uES0l4fGVmGz" +
                                                              "2PZjPLiNfKVSv3L7qx/V7fjoyXNC2mCt5fd7FzXbJIqkF2CxK4nTBAI/jk43" +
                                                              "sZ2RAxlmhAPVZmoPwmSXn9l6XaN25hNYtg+WVSAo290WhM1cAEoO9aTK3z31" +
                                                              "9PTdL5WR6EZSoxk0tZGKDUeqAenMHoSImzO/dJWUY6QKmkZhD1JgoYIO9MK8" +
                                                              "sf3bkTG58Mi+H834wZrjR88KWJpyjtn5CDsnEGFFWe9t8hOvrPrN8TsOj8jC" +
                                                              "YGnxyBbim/mvbi154I//LPCLiGljFC0h/r74yftnta/9QPB7wQW5W3OFiQsC" +
                                                              "tMe78kTm79GFFT+Pkso+0qg4ZfQOTEuwr/ugdLTd2hpK7cB4sAyUNU9bPnjO" +
                                                              "CQc237LhsOYlTHhHanyvC2FwNrpwLTwXORi8KIzBCBEvWwTLEtEuxWaFcF8Z" +
                                                              "J9WmZXCQkkHpW2GLmp2DJKpOtVx+HQGVWSXWAV6Rtm3BMpOT5eNneFkkA7xl" +
                                                              "SMb2SmyuluuuGQvPubH1iODrxZ684lNRYm/6IExwn84tVjeLmv/YgUNHU90P" +
                                                              "XipB3BSsRTvgqPXwb//zQuzI758bo9Sp5oZ5scaGmeZbsxKXDGybLnGk8DD4" +
                                                              "Vv2df/px68D6idQk2NcyTtWBv+eBEsuK78SwKM8ceH/W9rWDuydQXswLmTM8" +
                                                              "5fe6Tj63aYlyZ1Scn+TmKDh3BZnagluixmJwUNS3BzbGojwApqJjl8Cz0gHA" +
                                                              "yvDG8EC3BJsvB7FeU4K1RO5RS4wJl8Emm6ranfognHxhy0FVJA63wToV/dyb" +
                                                              "TdpQU6oZqDOGnYPYyp7dysHWnnckDC8Yg0HSNT8Uv3XHa3teEA6rQoTkzeRD" +
                                                              "ByDJVx01YhPDrVAiRofkie9venvo/vcelvKEA3KImB089O3PYrcdkltEHrUX" +
                                                              "FZx2/TzyuB2SbkGpVQTHxndP7X/8of23RB27X8dJZdIwNEb1vF8i+eQ1LWhF" +
                                                              "KeuGbzX89Pamso2w+TpJVVZX92ZZZyoIwEo7m/SZ1Tude3B0pMYCjZPIMjdz" +
                                                              "iiDHSgS5z5G0sWO9Kfp3B0F/ITyrHeSunjjoi7GWAPbXS4x9E5sb4aij2ut0" +
                                                              "NUM51oou6nHM8Exy0/kyyWJ4nDnl98RMUoy1hNp3lBi7C5vvQKGg4l2YwG4R" +
                                                              "g9x6HgzSgGMt8GxytNo0cYMUYy2h9NESY9/F5l6otwcYdy2RP7tlnJ2PX6bv" +
                                                              "nXNSpjp3m74djT9HfdvsvvNgwiYcWwBPt2OH7ombsBhrCTOdLjH2KDbfD5pw" +
                                                              "K8QqtxprFAU+1qRO1eVZ6OR5sNAUHJsPz7WOmtdO3ELFWEtY4Wclxp7C5ifS" +
                                                              "QhtYmmY1WbC7Frpw/HrVoxeGe/w8GK4Zx7BW3eVov2vihivGWsI4L5YY+zU2" +
                                                              "z3FSD4brTEG2hAM/k3Vlr2eMX/4vjJEDoIZv/PB4OrPgrwd5Xa48crShasbR" +
                                                              "a14TRXL+SrsWip50VtP8Byjfe4VpsbQqdKuVxylTfL3OyZLPdy3JSTl+CTVe" +
                                                              "k8xvcrJgXGY4Vw3nMeQwnuVkdglGOFfJFz/PHyCfjsUDIRFaP+U7YNEwJUgh" +
                                                              "vv1073JS49HBovLFT/I+zA4k+PqB6e6ay8Y3mIcZx6O5SPDwlcdQ83gY8p3X" +
                                                              "FgWKVPEPllvFZeV/WP3KqaNbtt5w7gsPyss8RaP79uEsk6F2k1eG+ePKgqKz" +
                                                              "uXNVbF76Sf3p6sVuURm4TPTLJpAMiUhcvM0K3W7ZrflLrjeOrXnyVwcrXoZy" +
                                                              "eCeJUDgW7Cy8OMiZWTgn7kwU1qhwtBPXbm1L7xtduyL91zfF1QwpuJAJ0/cr" +
                                                              "rx6//pU7Zx5riZLJnWQS1MssJ240Nozq25gybPWROtXuyIGI6DeqBQrgetxj" +
                                                              "FBOIsItjzrp8L97ycrKwsKwvvBuv0YwRZq03snoKp4ESerLX4x5bAye+rGmG" +
                                                              "GLwe30kmJ6sE9AZAtj/RZZruFWl5kylCzejYZQO2n4pXbD77L1KHGAndHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v/vot4ozv/8Dl8YkwDApAAA=");
}
