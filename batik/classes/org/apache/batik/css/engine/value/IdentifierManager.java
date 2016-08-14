package org.apache.batik.css.engine.value;
public abstract class IdentifierManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    java.lang.String s =
                                                      lu.
                                                      getStringValue(
                                                        ).
                                                      toLowerCase(
                                                        ).
                                                      intern(
                                                        );
                                                    java.lang.Object v =
                                                      getIdentifiers(
                                                        ).
                                                      get(
                                                        s);
                                                    if (v ==
                                                          null) {
                                                        throw createInvalidIdentifierDOMException(
                                                                lu.
                                                                  getStringValue(
                                                                    ));
                                                    }
                                                    return (org.apache.batik.css.engine.value.Value)
                                                             v;
                                                default:
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                            }
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        java.lang.Object v =
          getIdentifiers(
            ).
          get(
            value.
              toLowerCase(
                ).
              intern(
                ));
        if (v ==
              null) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return (org.apache.batik.css.engine.value.Value)
                 v;
    }
    public abstract org.apache.batik.css.engine.value.StringMap getIdentifiers();
    public IdentifierManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hpf+DYy51iuWGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeewkWV2v+c3O7MywuzO7sMu67L3D4lL4q+6qPjO4UtVd" +
       "fVZXdXcd3dUiQ3Xd3XV1XV1duMihskpEAsuVwCYaiIjLGYkmBrPGKBCICYZ4" +
       "JQIxJqJIwv4hGlHxVfXvnpmdbDB2Uu/36r3v973v+Xmv3vs9933oTOBDsOda" +
       "G91yw101CXcXVnk33HhqsNujykPJD1SlYUlBwIG2q/Kjn7v4wx+917i0A52d" +
       "QS+XHMcNpdB0nWCsBq4VqwoFXTxsJS3VDkLoErWQYgmJQtNCKDMIr1DQy46w" +
       "htBlal8EBIiAABGQXAQEP6QCTLerTmQ3Mg7JCYMV9FboFAWd9eRMvBB65Pgg" +
       "nuRL9t4ww1wDMMK57F0ASuXMiQ89fKD7VudrFP4AjDzzoTdd+sJp6OIMumg6" +
       "bCaODIQIwSQz6DZbteeqH+CKoioz6E5HVRVW9U3JMtNc7hl0V2DqjhRGvnpg" +
       "pKwx8lQ/n/PQcrfJmW5+JIeuf6CeZqqWsv92RrMkHeh6z6GuWw1bWTtQ8IIJ" +
       "BPM1SVb3WW5Zmo4SQg+d5DjQ8XIfEADWW201NNyDqW5xJNAA3bX1nSU5OsKG" +
       "vunogPSMG4FZQui+Gw6a2dqT5KWkq1dD6N6TdMNtF6A6nxsiYwmhu0+S5SMB" +
       "L913wktH/PN9+vXveYvTcXZymRVVtjL5zwGmB08wjVVN9VVHVreMt72W+qB0" +
       "z5ee3oEgQHz3CeItzR/84gtveN2Dz39lS/Oq69Aw84Uqh1flj8/v+Mb9jSfq" +
       "pzMxznluYGbOP6Z5Hv7DvZ4riQcy756DEbPO3f3O58d/Lr7tU+r3dqALXeis" +
       "7FqRDeLoTtm1PdNS/bbqqL4UqkoXOq86SiPv70K3gjplOuq2ldG0QA270C1W" +
       "3nTWzd+BiTQwRGaiW0HddDR3v+5JoZHXEw+CoEvgge4GzyPQ9pf/DSENMVxb" +
       "RSRZckzHRYa+m+kfIKoTzoFtDWQOon6JBG7kgxBEXF9HJBAHhrrXIQcZrQ5k" +
       "QmLJilSkqwBWEwS5P5AcEBL+bhZv3v/bTEmm86X1qVPAHfefBAML5FHHtRTV" +
       "vyo/ExHkC5+5+rWdg+TYs1YIYWDy3e3ku/nku2Dy3e3ku/nku9dMDp06lc/5" +
       "ikyIrfuB85YABgBA3vYE+wu9Nz/96GkQd976FmD5jBS5MU43DoGjm8OjDKIX" +
       "ev7D67cLv1TYgXaOA24mOGi6kLEPM5g8gMPLJxPteuNefNd3f/jZDz7lHqbc" +
       "MQTfQ4JrObNMfvSkiX1XVhWAjYfDv/Zh6YtXv/TU5R3oFgAPABJDCdgRoM2D" +
       "J+c4ltFX9tEx0+UMUFhzfVuysq59SLsQGr67PmzJfX9HXr8T2JiE9opjMZ/1" +
       "vtzLyldsYyVz2gktcvT9Wdb72N/8xT9jubn3gfrikaWPVcMrR8AhG+xiDgN3" +
       "HsYA56sqoPv7Dw/f/4Hvv+vn8wAAFI9db8LLWdkAoABcCMz8K19Z/e23v/Xx" +
       "b+4cBk0IVsdobplyslXyx+B3Cjz/kz2ZclnDNrHvauyhy8MH8OJlMz9+KBsA" +
       "GgukYBZBl3nHdhUQz9LcUrOI/a+Lry5+8V/fc2kbExZo2Q+p1918gMP2nyKg" +
       "t33tTf/+YD7MKTlb6A7td0i2Rc+XH46M+760yeRI3v6XD3zky9LHAA4D7AvM" +
       "VM3hDMrtAeUOLOS2gPMSOdGHZsVDwdFEOJ5rRzYkV+X3fvMHtws/+OMXcmmP" +
       "72iO+n0geVe2oZYVDydg+FeezPqOFBiArvQ8/cZL1vM/AiPOwIgyQLaA8QH+" +
       "JMeiZI/6zK1/9yd/es+bv3Ea2mlBFyxXUlpSnnDQeRDpamAA6Eq8n3vDNprX" +
       "5/ZxPYGuUX4bIPfmb6eBgE/cGGta2YbkMF3v/U/Gmr/jH/7jGiPkKHOddfgE" +
       "/wx57qP3NZ78Xs5/mO4Z94PJtZgMNm+HvOin7H/befTsn+1At86gS/LezlDI" +
       "EBck0QzshoL97SLYPR7rP76z2S7jVw7g7P6TUHNk2pNAc7gWgHpGndUvHDr8" +
       "ieQUSMQz6G51t5C9vyFnfCQvL2fFa7ZWz6o/DTI2yHeYgEMzHcnKx3kiBBFj" +
       "yZf3c1QAO05g4ssLq5oPczfYY+fRkSmzu92mbbEqK7GtFHm9csNouLIvK/D+" +
       "HYeDUS7Y8b37H9/79d987NvART3oTL6gAc8cmZGOsk3wrz73gQde9sx33p0D" +
       "EEAf4dc+X/1ONmr/xTTOimZWkPuq3pepyubrOiUF4SDHCVXJtX3RyBz6pg2g" +
       "Nd7b4SFP3fXt5Ue/++nt7u1kGJ4gVp9+5td/vPueZ3aO7Jkfu2bbepRnu2/O" +
       "hb59z8I+9MiLzZJztP7ps0/90SefetdWqruO7wBJ8IHz6b/676/vfvg7X73O" +
       "RuMWy/0JHBvebnVKQRff/1FFUUXXfJLYGpMia3jNt9cBrYsVfVBuSvyyKW68" +
       "UWtB1JlUk/v4JKTXKYPRGIupaLGIzmA05curjkUSc4Jt9XVyRAiSxxVMt8cr" +
       "E3eRjsaCNLJ5pddnhQ4X4iuvSK6sZp3V2WiphSSK2Ipd15R01rKEOZvGqo04" +
       "Nlytljs+EtsYhjKr1YajxwRNrBb8WkrEuCBxkybXjZZwS4gnU8+gNrbs1+ga" +
       "MzUimCmtVkmR4JpW2Bz4865OUnzYnLQFcyWN56RNopG4bHLzJdfojeV1jyME" +
       "pV0YhuZiItLFcUuIzJFjSgOxWUNLFV3gUXfVn0XsSJSJMRsv3K5D0rM2apSV" +
       "aqliEEW34C2wjbeopsOw1nVr5VJgVvoTuE3WdHYy769cXtik0iRtjoklPfWq" +
       "/RVnM8tRm+kUWZRpTOedsMyKLhO1ym49coJNUSYGQdJb2TxWqklrOFE6k4bH" +
       "MC46i0Oh4KiM24cXDd9c0eUO12phGMGvdAHvGdTKqUsGDhckE9WWsDOGO5G3" +
       "WTVnS2/cajnLrk1wswRDG2wpDRqGsfCccjk2wn5EecnEoZqOWUqiZQGVh6Gz" +
       "wfDFZOhOZq02Ol1t+jgJfLwQWw2WSzoc6pWZJTISpXCKo9KQFKjGimtG6txn" +
       "eL8reU21jKVy156LjDjtz5w+gi+cAVqYSat5otKWSuLluOJu+kG1MRkr1VnC" +
       "O512M5UHeIUYj9JBsjDT0GIZqexKojcxpjKf1hd1hm3g/ijeGMy84K6MflMe" +
       "kJIxAF8K3bBfKjYqbWvW7WNsd0TQpjenNx43Q4PmhhlU2F437pKtYoPCWwLF" +
       "ySRa6I3VsjmQ192YGoXljapqlRo95+qbuKr0zT7erXglOxjEmC8KdEeiB+rS" +
       "JG2dW4/aSTxJaoiesDVtsemSCVMwxGUnRVhEidrKIoGnU0LGNoPFaLGSadJb" +
       "WuVeOC3U3RXs+IFvE27RsEteOrSJJTII2FT34xHfJNuzZMnS8wVlUxai1ep4" +
       "MNRcrcaI/oqw2kW/H6KdqO8Kyjw1Vl22VqyY5JjmlkaZDPkxVUc6xdF8hGMR" +
       "0x8HXMA2ZguSW3X7Fg8LEpYC55tNitB7q1VTKUypClOp6hObiRN5YLRwatjX" +
       "FWdZWiKxgZiLHssFNa4hhyKfjhXW0ytMtWbhan+5psRyfySMh5vyLLKLjQa5" +
       "qtgzfp2QbYbBo00yMVO3NyjowmTOdmkP7Xv4sgcyscuMBu1BgLkpYldGDQYZ" +
       "Nja8TmIUaTZxcVWmyWjKF7jBxtZCRytgmA7Dktile6K88HkX1dOGWOiVFng0" +
       "1LWGSBLVxdoeWGuLXK5tHiS3262Xhmmik228K8/V5TxGMcxVW3Ir6RWSycie" +
       "zCpjRZ/6fBlttxoI0YOF3ryEcU6RR+Ox1bI6lGDYiifOVMGKystWqUd1HCWJ" +
       "WLJt1XS/LVkIIfamTLE9YQl/I/lTvDRt+4XGpL9RRXcCc2apLK4tfzGuDljb" +
       "H1a92jzuG8gIkUl+Oha7Rb27CnAsXKAEOUS7bg8zqm2jQyO2WJfhyOHsFVMx" +
       "xv2mG1GTzawhV0dFudQPKJuVfV+AB9PlpqZV1Zntr3neSwy5uW7OyJk4xvst" +
       "tVVvziYTX18TjpK2GYGaL1F/NSjzZaQwAyke+n1jyo8ikCwj3V9PtPacZ4aw" +
       "7yD1ZFBVl5NUkjRNgC2aUEE0JTO7IFutVd2kE5/Ue4VquU5pQyyp1GSm1sFJ" +
       "czG1iI6UBqOa3vDXzZaTLuvsMNamRLG89PkGSvZDxWNGcsiV2sqs3uzUxmqz" +
       "3MICMabwHs7RoTaqTny20nBkcukjdAGvGxw+JkS5w8WFDT7ozsM1a/KBhlTH" +
       "cWfOmVitXGAp2Zf7g/amMC+jmp4qMIqnWKkctBEFw1FyZgtTuQ53PAevubxa" +
       "hlHblFSx4046mOWUk3ZcGrZGrVG7BwwrylOijRFwl8EGvVAeyVp1vQk10aWl" +
       "TRFZ4Bq3oWW1p044IS0H2BAx+qlaCoMOvIkQrDtJC6aps1OdMBBZn+F2cygY" +
       "8nzeSlicQCdGt7VqVWebNZMymxqtzVtkjK3ZRNwQE2LRQMfLDZ6SXd0i0tVK" +
       "nyBIYPvmGq5PxbaJVwymOG1V8CFDjqr8qCJzfVxxJ4sBonYRVvQ7LYoftYVJ" +
       "31jqjmUIU+DJSKY3i8IGEQcWVg+Bq3pCx5PaJaojpxiudLBYDHqd4bju+NUx" +
       "J5QIVsc3xrxPr2gknQ7FuayrCRM6fXRY4jAxHTAOVRl3nLC0jFwUFdvIqFnB" +
       "YrmK1MrFKJGr9bpbWANYmVTkedjvuYvVsugQY1zqJwYR17hUV33EKzJ1GO1h" +
       "iszGRT0oFtPWYIwydUHuLooBTCOT3nTaiatc4GNz2VUiXPOmhryezWIndCea" +
       "FnVURWv4fbhoE7Ap1OUOwfl1eN2lR8sCZfjVnhF4Humknmfi1GiTVCr4rFzg" +
       "cCZumOxgHdmJPp4aOvjgIt3KOGraouF1zX6NYRGr2C84Td5YlkMLc0Jx0q22" +
       "WL49DubekK8YVIBJ0XglxArFajHWtoYJzLacjkR2NY63FGkSIB3FLQ3qY2Up" +
       "LgisJhc66LzRcR1/1us2Fbi4pMoAQJNhSi+XGiJx0qBhhCEyqo91HgsGw0VN" +
       "pol0qhGBXNrU56PqMJi0tNWsbqPJajMl+aSFFegOGW34cTDqTciVyi5wslYJ" +
       "yz2mN0KopBpwMTGay4ItNd12iIwdL0CqUQeDqRkfDNkgMRdxyJL0UCo22WJg" +
       "Nkm54jmLhYHw49SX6kGnxNdVlURWpF8cGaJD1eotGVl4hRKlET2sGU+tVgqW" +
       "mZjEOGY5VRWZj01G5+oyE/vsoKAOx7NiI5pFZt/UlZ5Z6Akw6F+IvB1Va2zM" +
       "DLnqTGjizagpdaVJkWHQ9mgNorJOzCSlZjhCVDEqLNN0U7D7ME3Kx8Rug1eq" +
       "jUrSqNKyRvozh+7AjXkt4lMTKQ5kt9tBe42FzHQWKDtEa+VEb2yW8WDGIaNJ" +
       "rxBQE7qGr6sFrlhrlHFbMvk5seyXQgdnFg5dGLXguQgXEnqRNHhhMKn6TqtS" +
       "nlqq3WwiTX1B4aFiTjR2jNTmPRPFqwU30vrr6kTwNyFv1bqzthbXCTmAuUbs" +
       "KOUOW4bB+ocXB1VxFbkU68C4YAT2hl3ILR01gWKluDrgFblcVQemaLLUwDHI" +
       "uYOxq01jPXentSmFlOpluLMR0NJwPObXsGkjuLAce/oohDs1BONkbxUP3VHf" +
       "KNVmdK1R1ZuNaVSXKJ2J0RA20Do2WZgq1y1rDa/D9rxGZxSHNVcl/CotknhP" +
       "QFRnlCSJqHXgVqTZHaw2LGBVx5OwgbFs8fXhYFMt6k0AtZYWSCnYK6rzzSqs" +
       "CnJ16BnKqkjpeHvujmFsauC476/ROrMpEACozKoq0JU5qvn9tFSexuvhSBsR" +
       "rQHJU01Eh5GuHU87zWEgtY0hgcdjgXNxzVFWc83ZSFbYTmkEGWGxnxTI6YKs" +
       "akIfluM2PC0nEqPTmD/0CAGfipzuLVZkJVGWZU8t6TVRBGtmMF1RpUaf6sHr" +
       "ttv0e57o2Q0+CUvhIg3mJkVFK74+FiZurz/Emvh0wrJ2MyxMCkFVbyFxOmJh" +
       "k/NnAirPx7bZpGHGjyzGHC+IeESP7FKBaZeUctrHAnphLLjyxCdoGql3kWrf" +
       "8DQYfDKVi2Y0aYPPq+yz640v7cv3zvwj/+BiBnzwZh3tl/DFl1x/wp29w4Vz" +
       "0jwIfUkOk4NTz/x38UVOPY+cDEHZJ+4DN7qMyT9vP/6OZ55VmE8Ud/ZO1CYh" +
       "dD50vZ+x1Fi1ThwyvfbGn/KD/C7q8KTny+/4l/u4J403v4Sz7IdOyHlyyN8d" +
       "PPfV9uPy+3ag0wfnPtfckh1nunL8tOeCr4aR73DHznweOLBsbt37wfP4nmUf" +
       "v/558nU9dir32DYwThxY7mxdun/y86rs9mGNyfmlQyDJu5SamLJk8Y4Z7tO8" +
       "+sVuKBosS+a1fLbwxGyn9u4f9ka6d382xbV3m8yATGTVyzyRM6dZ4YbQy2Rf" +
       "lUI1P2nb53zNzW9JDunzQPdudrRx9AQzb7COG/9R8Dy5Z/wn/2+Mf3overP3" +
       "8ZFsFELoTGC4fniQseuc/+nrmzN7fUtO8BtZ8U6Q+1uTbQ/vckNkHW89tMYv" +
       "/wTWeDBrfB146D1r0C/BGjsHaKVe1yRHD9A/9CJ9H8mK94XQHboaHt6HBfvx" +
       "Ad88PrbGGUjeoVXe/1KskgAzX3MTl10l3HvNvwFsr67lzzx78dwrn+X/Or+M" +
       "OrhePk9B57TIso6e/B6pn/V8VTNznc9vz4G9/M9vh9AjN1Uy3DthzYX/rS3j" +
       "J/ay/AaMIXR2WznK88kQesX1eELoNCiPUv5eCF06SQmkyP8epftMCF04pAOT" +
       "bitHST4PRgckWfUL3r5jKzd3LL63LOVxv+eX5NTxlefA5XfdzOVHFqvHji0x" +
       "+f+E7C8H0fa/Qq7Kn322R7/lhconthd3siWlOYydo6Bbt3eIB0vKIzccbX+s" +
       "s50nfnTH586/en/5u2Mr8GF2HZHtoevfjJG2F+Z3WekfvvL3X/87z34rP0//" +
       "X00OSmKsIwAA");
}
