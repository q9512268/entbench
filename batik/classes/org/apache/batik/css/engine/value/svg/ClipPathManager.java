package org.apache.batik.css.engine.value.svg;
public class ClipPathManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_PATH_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                                    return new org.apache.batik.css.engine.value.URIValue(
                                                      lu.
                                                        getStringValue(
                                                          ),
                                                      resolveURI(
                                                        engine.
                                                          getCSSBaseURI(
                                                            ),
                                                        lu.
                                                          getStringValue(
                                                            )));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    if (lu.
                                                          getStringValue(
                                                            ).
                                                          equalsIgnoreCase(
                                                            org.apache.batik.util.CSSConstants.
                                                              CSS_NONE_VALUE)) {
                                                        return org.apache.batik.css.engine.value.ValueConstants.
                                                                 NONE_VALUE;
                                                    }
                                            }
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                if (value.
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  value,
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public ClipPathManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9BXwV/ZW+B+np29vMx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06C8w0V1Xzf23/vy2l/98WSi199y9QFr7Z98MflJmdfczu" +
       "vHZndmd3RMq8HzuvncfO7EIVMEqRCERbhAgNJhCUFIoGlMRAqgaBQFQMUTGR" +
       "NmoUBCLViEZUvDP7vfv/f9O0cb/M/e7ce86555x7zrln7r2PfR+6Kgyggu/Z" +
       "a932ol01jXYtu7YbrX013B0QNUYMQlVp22IYcqDtAfmeT5/94Y/eZ5zbgU4L" +
       "0E2i63qRGJmeG47V0LNXqkJAZw9bO7bqhBF0jrDElQjHkWnDhBlGFwjoRUdQ" +
       "I+g8sc8CDFiAAQtwzgKMHEIBpBerbuy0MwzRjcIl9HPQKQI67csZexF093Ei" +
       "vhiIzh4ZJpcAULg6e58CoXLkNIDuOpB9K/MzBH6kAD/8628697tXQGcF6Kzp" +
       "shk7MmAiAoMI0HWO6khqECKKoioCdIOrqgqrBqZom5ucbwG6MTR1V4ziQD1Q" +
       "UtYY+2qQj3mouevkTLYgliMvOBBPM1Vb2X+7SrNFHch686GsWwm7WTsQ8FoT" +
       "MBZooqzuo1y5MF0lgu48iXEg4/khAACoZxw1MryDoa50RdAA3bidO1t0dZiN" +
       "AtPVAehVXgxGiaBbL0k007UvygtRVx+IoFtOwjHbLgB1Ta6IDCWCXnoSLKcE" +
       "ZunWE7N0ZH6+T73uPW9x++5OzrOiynbG/9UA6Y4TSGNVUwPVldUt4nWvJt4v" +
       "3vz5h3YgCAC/9ATwFub33/r0G15zxxNf3sK8/CIwtGSpcvSA/FHp+q/f1r6/" +
       "dUXGxtW+F5rZ5B+TPDd/Zq/nQuoDz7v5gGLWubvf+cT4T+Zv+4T63R3oWhw6" +
       "LXt27AA7ukH2HN+01aCnumogRqqCQ9eortLO+3HoDKgTpqtuW2lNC9UIh660" +
       "86bTXv4OVKQBEpmKzoC66Wreft0XIyOvpz4EQWfAA10HnldB21/+P4IM2PAc" +
       "FRZl0TVdD2YCL5M/hFU3koBuDVgCVr+AQy8OgAnCXqDDIrADQ93rkMMMVgc8" +
       "wSvRjlU4XOnAakyfAcOToguMItjNLM7/fxwrzeQ+l5w6BabktpMBwQa+1Pds" +
       "RQ0ekB+O0c7Tn3rgqzsHDrKnsQiqgeF3t8Pv5sPvguF3t8Pv5sPvguF3TwwP" +
       "nTqVj/qSjI2tEYApXIBgAMLkdfezPzt480P3XAGsz0+uBPrPQOFLR+v2YfjA" +
       "8yApAxuGnvhA8vbpzxd3oJ3jYTdjHTRdm6EzWbA8CIrnT7rbxeiefee3f/j4" +
       "+x/0Dh3vWBzfiwfPxMz8+Z6TSg48WVVAhDwk/+q7xM8+8PkHz+9AV4IgAQJj" +
       "JAJNgphzx8kxjvn1hf0YmclyFRBY8wJHtLOu/cB2bWQEXnLYks/+9Xn9BqDj" +
       "n4T2imOWn/Xe5GflS7bWkk3aCSnyGPx61v/wX//pdyq5uvfD9dkjCyCrRheO" +
       "hIiM2Nk8GNxwaANcoKoA7m8/wPzaI99/58/kBgAg7r3YgOezsg1CA5hCoOZf" +
       "/PLym09+66Pf2Dk0mgiskbFkm3K6FfLH4HcKPP+bPZlwWcPWvW9s78WYuw6C" +
       "jJ+N/IpD3kC4sYEbZhZ0fuI6nmJqpijZamax/332vtJnv/eec1ubsEHLvkm9" +
       "5tkJHLb/BAq97atv+o87cjKn5Gy5O9TfIdg2ht50SBkJAnGd8ZG+/S9u/+CX" +
       "xA+DaAwiYGhu1DyoQbk+oHwCi7kuCnkJn+grZ8Wd4VFHOO5rR9KSB+T3feMH" +
       "L57+4AtP59wez2uOzjsp+he2ppYVd6WA/MtOen1fDEFk8KtPUG88Zz/xI0BR" +
       "ABRlEN1COgARKD1mJXvQV535mz/845vf/PUroJ0udK3tiUpXzB0OugZYuhoa" +
       "IHil/k+/YWvNydWgOJeLCj1D+K2B3JK/XQEYvP/SsaabpSWH7nrLf9G29I6/" +
       "+89nKCGPMhdZjU/gC/BjH7q1/VPfzfEP3T3DviN9ZlQGKdwhbvkTzr/v3HP6" +
       "izvQGQE6J+/lh9Ms5gInEkBOFO4njSCHPNZ/PL/ZLuYXDsLZbSdDzZFhTwaa" +
       "w9UA1DPorH7t4YTfn54CjnhVebexW8ze35Aj3p2X57PilVutZ9VXAY8N8zwT" +
       "YGimK9o5nfsjYDG2fH7fR6cg7wQqPm/ZjZzMS0GmnVtHJszuNlnbxqqsrGy5" +
       "yOv1S1rDhX1ewexff0iM8EDe9+5/eN/X3nvvk2CKBtBV+ZIGZubIiFScpcK/" +
       "9Ngjt7/o4afenQcgEH2m7/qdxlMZ1eHlJM4KLCs6+6LemonK5ms7IYYRmccJ" +
       "VcmlvaxlMoHpgNC62svz4AdvfHLxoW9/cpvDnTTDE8DqQw//8o933/PwzpHM" +
       "+d5nJK9HcbbZc870i/c0HEB3X26UHKP7T48/+Ae/9eA7t1zdeDwP7IDPnE/+" +
       "5f98bfcDT33lIqnGlbb3PCY2uv4j/WqII/s/oiRofDJJU16jKy24yjZJAylg" +
       "Ftsp6dJqNKKCCYWXokYPrVO2THJO2Bac2qrhNNJKXF/TZVVzFWTkI0t3Yprm" +
       "qGdOmqg8jtpDZLkUfHskjseO314UhSHrxw7BjtmlLxZHo+6UXRV0SfMdYaWU" +
       "pUKxsS7NlEVFiKWC2FJVuFULS41mQaIrC7Trex3RnHiY0klcYYkSPt8NnTYn" +
       "LnmMqyBCa9QacKhmreJ6o1IBkTSdUx6nD6XVGC+zkkLaQ71mDiR8uXDSodHb" +
       "WDXEqya6lLa5Xnsorn29bqKRG7LqckiQTnFaDdmx1UascXuZCiNRNsdddt4s" +
       "IZMpMVqig0UvZCVGpqPqdOSLnD9PGjXEUGp+Oe5M2LnCs0KXEjstFRn1J6Ux" +
       "r5t9we+VfKRVtsWmP59RXU8fjv05XlhXvIEul63WADFFojSG1VWUeJ6ATfDW" +
       "dCoyMtMnA5Kb2kZnjC2pwG9MB3gxWhMrbzEcLa32eJKO2abO93TWGI3RJV+I" +
       "RromTMedok1vpjEWTN1hNLd9A+1yisPVKQth+VgkKVkQTNO247LcE1PFDro8" +
       "j7mDtEdV0HmzEIkrx0h4TzXQ6brswZOi3B6wOt4bjRGWG7Qxgmz1zNl4NGWD" +
       "xCEqnSLTM600DmasMpSVKdelExibhwFG250qQyhEu62MOMkajDsUS1kzL2nY" +
       "DB8Mh5JOU3p90+hOecqiCmEfkY3FhCzjc5ismcPxmi+xRpdtFOXeOJJWutdJ" +
       "ukt2gLGGMBlNl4ZenwxKSWfEB00egeNBVURbuImNNyOvZxibxUIoWUvecHsy" +
       "hvWYFtXupmN0ZM86eg+Juti0umYMOiwuCGYYuHytKGnGgmaWg2jCwEN0Y3fM" +
       "4WQDtx102cLQaMB1zQ6l9/Wgu56qetVdaWsDbRp4r5F0kFjspoVWS8aW6SJe" +
       "tWt+d9JCQ1NNjI5RZrnFzFkR5WoI8wVkKfSWYl0g7VWTIFc1Qo8kvFzy+yx4" +
       "I9ekhKE6VmqIBS9aNZgmWhBCzdZUfb6wucnCTbySP2ALy/XIS/rAN0iu4xTR" +
       "2mRMKcEgrUSjtrTuCwMer5jl1OnYHrb2J2pXTVO3iY2x3lxfdCdYXFj3IiZU" +
       "0gqH9ltMPTGNjmuMBtxaGxUIbLW2hyhKiQudTY3uVCjNB8aozJSdYg+n0T5C" +
       "GT1Sp2QGLRYjYY4QqDWx+iGno4ltYhPd8apljAs742A4xovoeqC3NFw1rE6r" +
       "jE9dEsdJHObgamFdDDdxwe5pWE1YhJysD4n2jHLsoY0aWDHqTsYtNZKL1Krd" +
       "U6xec9y2hkQJx6p6iqjVAtLGscRKERZUaRzrr/p4rUCxtQ1eMlAG6eg1jMRR" +
       "b0a54qrCbBqe6yArpKBJo1Gzpy42U1tYKvSg1xfn/RpBl0o8RZVKUqHuad25" +
       "MOoLgtc2w3AtjSR5ZGjFoF1K1qG1GBbkiOiTNifMVxZZNCcjQ4ynw35rHvqK" +
       "h5NTHR7PKIVsGQOLr2hzuj4hl7NCnRoOirLc7wcryYI3gjMfDggc19OWhRFE" +
       "za26JkEVByTFw6VEjTXXKhS4CmWOp9Iy5Bhn0Kk5owYzIxqbBOs4gR13Zobd" +
       "UEvNgUFUqTlndULG4wbjZYEMuthE8JQS0KrfQzcciBZ8edCmZM6metTSKzZJ" +
       "JfLnJUweVJxRVOvSI6Eqr1qFgIbVQmypG5NVVkNPcWYtbUFIM6RHcFOpPyqB" +
       "0FfrS1hniDTi5aDZV5kKZ1b1RmhN2muNdRBC3ITGhOwvEZzQVLeyUgstsMbM" +
       "uo2GnhjztWKGGDpoliJHCwWtv0ngQdgiSDPBjG5Yt5aRSchhBx4UB65je2nY" +
       "YRK+jbg0bcfFZTzsyItKt4PzGxgmqHqqeDPGqk3wmiDp44bElwSGqfY5rSj3" +
       "yyu4F7jNYtOxm51FXMDcKu3MLa8lN8jGXETTmq7WZU3jtWGrBLc3CzTU+/5q" +
       "TdMdo+t2mp0ujLTGayKuOI2NxZRRRQxJqlhwgzI1w9UFrrqJLURTZCOvKjEh" +
       "Cj6I6fRKNeFJuTqZmsDL5nYNmwr4tElZPiMUKk2K1pNKGnuU0+F03yk0bEJL" +
       "NrOhr4S6YmAd1miPNmyxh5Klom1GQqkzsVcV2C7NnEZlXUNgpzYJHL1a9io1" +
       "Y0HZVdrtcJ12k1MjTZ1gHjn1htyo0keKpbbYxft8lbcn9dZqWhq6WmfW0zYE" +
       "PE4j2m1sepUpPpPX6ZprmGxUL4c8W5HtoByzvIZUfdhkeqi9KTv6QHJoktlU" +
       "wZcIUhSYMSEXou5IpeI4tUZjVVZ9GG5IsIoNNtUqg08cUSXFlSca82SUsvzG" +
       "xl1ybbAtuM+54yHI7Kq1ZoGieZVUyIXOBWItcTAJ09hmD59KDray1WkpaTQV" +
       "tVcupHRDSEFTJdBbnUYNVuobO23Jw3ElbdbpsM3wnBViAtcrxfNOzxupGBlY" +
       "+IafNKeVdYUgk9pokwrlAZcGBKLMq61ihFvoRioPqGlVnBaK41o/mjcTHtE3" +
       "LWvGa2TJjJcGEJCb4GNkhY+KqRqTDZzE+IJWmJJsZ9BuurgGRu5pJtBKhU3J" +
       "qMo1B1Qjtdq6gJYqiFOgOSQGpl9DIn5tJQukxhB0s83NaGdpWBM0MqZis8TO" +
       "y5rXabX4FgNvSJD8dJmoiq3m6pxDN62Wo6KjotbtggC8gQcDY65K49Ko0I/L" +
       "YnPhGn2qBL5d4JXPMQ1s5UWVfugNPdtzFsPEsRezWUEEdidLY7EfpKa61Cpi" +
       "NVgiEmU3meGi7Dej6qQ+tx263B4482V13p8MB7KsEGJJSJccHjU9Wpi2QJyU" +
       "0lXcg63hMPSKjAtLRWFTL1nzYiUJCLKptCqky1VnYtroV/zItfpau7as052y" +
       "11DTArJmwtmky2GTpBPMEtrU+pMRG1bbIysJK4jNOOWpU24m43XIi2h11lLl" +
       "OR3S8zE9qBBCEC4Hm64NvlGloSWVQ4QZeA2yux75VdpcN4BD0yzb4JneHHZ4" +
       "LaTra0FHaGfTrsUFukEjss6FCYpT4ygwhlo/XPpuzcMW87BktSiqlvo1YyP1" +
       "w5kw8qlEjMqkWVCCQCUnk27oTsa1ql9r9DSyOzfpTTLsRHwa9rjUaFeB27b7" +
       "ZCp4fT8AdMJ6WgtYRG7Tg6owbqMlS5AS1aTrKoz3MY+eoa6gx9VUQ5pC14WL" +
       "5BpdN2dLRNaYrtaXWib482AVr/Q2HJt0R+YoYgGNIAwmvu2MsTpDw6tqDIfC" +
       "VCMX1mZSr5YWCSH17DExdufxkK8M18WxKxR9WiODgFmk4zHPjsT2skaYm0AP" +
       "6UIbprsri2r2dF6PAjKR4W7d61l6O2JJqlIg5gN23TRTveRIQD9deBXwJby9" +
       "cTewixItY8PzQ1HnPTyKaFQtruBUG/lOz1XZBsfTfGVODVqrwMTssK4E7bqi" +
       "VYhG3NjIayXhpk0ipQSB7VJquq4UO8PWnOr4dE0ReJOPpFqpNfVn2HRTSeRx" +
       "x/bjJG1264k8oSYVoq2Hm4W36HZjul8ypGEyMcbhzEibcCKEq9qEGSJ81GsM" +
       "rUJ7URtOOoRmVpxCzTJDT6ENZDmLkgVIfcIROVClQlDWgrSiBpboSUniISAC" +
       "O2QkKl4l5iSXiUaJOyrU2Bi2eW3Sg0swzvhtN8Va2KhF1BbgE6gf2KVGhTG9" +
       "Rco2Gb3q1CdtK+6btFnjVE6yXbKsLisGVy8Ua92mz5eZKVpa8Aq/0eK11O4X" +
       "hjN+FMLUQnHYeILWGy22ZzYK4rBf7Q/9UFkjmhS59X691BSaY6XDl3xmJDsw" +
       "vmFrFRx8cE1bfiRNCsxMguuR7moFbNZfmJNBNdoUk9ZgWmysYIYfo6IswqJp" +
       "oukUrU8YVq8bMmWp9HIaD6geTnpmIDQ6S8y02oQ14EMe+FK5zM7RUY82k6k7" +
       "FcVZRUTZEraujfyo2SitY3HIdOoUyor+mEJa05GhUFaliC66atOfaXJCY+XY" +
       "81lcJg0eaaTlIcUGdVgqzcu92mZBUURPKbbQWTKFBb6AFly/3FqRaRV8kL7+" +
       "9dmn6huf227BDfnGyMGRlmU3so7ec/hK3nbdnRX3HWwG57/Tl9kMPrJhBmVf" +
       "/rdf6qQq/+r/6DseflShP1ba2dto5CPomsjzX2urK9U+QupqQOnVl97hIPOD" +
       "usMNsC+9459v5X7KePNz2OK/8wSfJ0n+NvnYV3qvkH91B7riYDvsGUeIx5Eu" +
       "HN8EuzZQozhwuWNbYbcfaPamTGOvAM9r9zT72otvs1/UCk7lVrCd+8vs4waX" +
       "6ct3pp0IuskMcddQAzNSFSbw8kPZHGF8xGCmEXRG8jxbFd1DY3Kfbcvl6JB5" +
       "g3Ug/Y1Z493gqe5JX33hpX/7Zfp+ISveGkFndTXal5ram7veoYgPPg8R8wl+" +
       "JXgu7Il44YUX8Vcu0/ferHgogl5ihohrOmKUnTHsy5r1rQ7lfNfzlfM+8KB7" +
       "cqIvvJwfvEzfb2TFwxF0o5ldQsh3GS8h5SPPQ8qzWeMd4MH3pMRfeCk/dpm+" +
       "j2fFR44b7MER3glXvcLcux2SS/2bz0PqfAm4CzzMntTMCy/1Zy7T93tZ8fhW" +
       "akzVxNjeHlvsb/e/8tkPnQ/hc218+vlq4zbw8Hva4F8YbezkADv7Qr08Eyqp" +
       "yLksoSjvEmpqyqI9cc1oH+a+ywneZtlOXstH+6MTo53aO0nfo3TL/miK5+xi" +
       "NNlJwWdstnjmyF/Ois9H0IvkQBUjNVdm1vS5Q41+4flq9B7weHsa9V4YjV6x" +
       "d4J3Eee4KjS8IF/88uToizn+Ny6uo+z1KznAN7Piz0CatdXD9mzpYtr48+ei" +
       "jRRY9okLEdmJ7i3PuJO1vUckf+rRs1e/7NHJX+V3Ag7u+lxDQFdrsW0fPYA7" +
       "Uj/tB6pm5lJcsz2O8/N/Tz2LFR3c2QABBZQ5809uUf8+gu5+VtRo74zsKOI/" +
       "7ln3JRAj6PS2chTnO2AJuxgOYAuURyG/F0HnTkICLvL/R+H+JYKuPYQDg24r" +
       "R0H+FVAHIFn13/x9V6k/u7oQKYwCUd5Gqb0pTU8dT5IPbOXGZ7OVI3n1vcey" +
       "4fxu337mGm9v9z0gP/7ogHrL0/WPba9eyLa42WRUriagM9tbIAfZ792XpLZP" +
       "63T//h9d/+lr7tvP1K/fMnzojkd4u/Pidxs6jh/ltxE2n3vZZ1738Ue/lZ+I" +
       "/h/MCV4XdCkAAA==");
}
