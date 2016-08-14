package org.apache.batik.css.engine.value.svg;
public class StrokeWidthManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_WIDTH_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_1;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     INHERIT_VALUE;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeWidthManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze2wUxxmfO79f+MUrPAwGQ4RD7kISUiLTEDB2MD0/isFt" +
       "TcCM9+bsxXu7y+6cfXZKmkRKoa1CESUJqQr9hwhaEUBV07RKExFFakKTVg1F" +
       "TUkFiZSqJW1Qgyqlf9A2/b7Z3dvH+c5yVfekndub+b6Z7/vNN99j7swNUmQa" +
       "pIGpPMLHdWZG2lTeQw2TxVsVaprboW9AeraA/n339a77w6S4n8wapmanRE3W" +
       "LjMlbvaTxbJqcqpKzOxiLI4cPQYzmTFKuayp/WSObHYkdUWWZN6pxRkS9FEj" +
       "Rmop54Y8mOKsw56Ak8UxkCQqJIluDA63xEilpOnjLvl8D3mrZwQpk+5aJic1" +
       "sb10lEZTXFaiMdnkLWmD3KFryviQovEIS/PIXmWtDcHW2NosCJadr/701uHh" +
       "GgFBPVVVjQv1zG3M1JRRFo+Rare3TWFJcx95lBTESIWHmJOmmLNoFBaNwqKO" +
       "ti4VSF/F1FSyVRPqcGemYl1CgThp9E+iU4Mm7Wl6hMwwQym3dRfMoO3SjLaW" +
       "llkqPn1H9Oizu2t+VECq+0m1rPaiOBIIwWGRfgCUJQeZYW6Mx1m8n9SqsNm9" +
       "zJCpIk/YO11nykMq5SnYfgcW7EzpzBBruljBPoJuRkrimpFRLyEMyv5VlFDo" +
       "EOg619XV0rAd+0HBchkEMxIU7M5mKRyR1TgnS4IcGR2bvgAEwFqSZHxYyyxV" +
       "qFLoIHWWiShUHYr2gumpQ0BapIEBGpwsyDkpYq1TaYQOsQG0yABdjzUEVGUC" +
       "CGThZE6QTMwEu7QgsEue/bnRtf7QI+oWNUxCIHOcSQrKXwFMDQGmbSzBDAbn" +
       "wGKsbI49Q+e+cjBMCBDPCRBbNC999eaDqxsuvGnRLJyEpntwL5P4gHRycNY7" +
       "i1pX3V+AYpTqminj5vs0F6esxx5pSevgYeZmZsTBiDN4YdsvvvLYD9lfw6S8" +
       "gxRLmpJKgh3VSlpSlxVmPMRUZlDO4h2kjKnxVjHeQUrgPSarzOrtTiRMxjtI" +
       "oSK6ijXxGyBKwBQIUTm8y2pCc951yofFe1onhJTAQyrhWUGsj/jmZCQ6rCVZ" +
       "lEpUlVUt2mNoqL8ZBY8zCNgORwfB6keippYywASjmjEUpWAHw8wekEykHQKZ" +
       "oqNUSbGoOSrsShthX5LjfLiTqmAXRgSNTv//LpdG7evHQiHYmEVBt6DAidqi" +
       "KXFmDEhHU5vabp4deMsyOTwmNm6crAMJIpYEESFBBCSIWBJEhAQRkCCSLQEJ" +
       "hcTCs1ESyxpgL0fAK4BbrlzVu2vrnoPLCsAM9bFC2AgkXeYLT62u63D8/YB0" +
       "rq5qovHamtfDpDBG6qjEU1TBaLPRGAI/Jo3YR71yEAKXGz+WeuIHBj5Dk1gc" +
       "3FeuOGLPUqqNMgP7OZntmcGJbniOo7ljy6TykwvHxh7v+9pdYRL2hwxcsgi8" +
       "HbL3oKPPOPSmoKuYbN7qA9c/PffMfs11Gr4Y5ITOLE7UYVnQNILwDEjNS+mL" +
       "A6/sbxKwl4FT5xT2H/xlQ3ANn09qcfw76lIKCic0I0kVHHIwLufDhjbm9gib" +
       "rcVmjmW+aEIBAUVo+Hyvfvz3v/7oHoGkE0WqPeG/l/EWj+fCyeqEj6p1LXK7" +
       "wRjQXT3W852nbxzYKcwRKJZPtmATtq3gsWB3AMEn39x35f1rJy+HXRPmELpT" +
       "g5ABpYUusz+DTwief+OD3gY7LK9T12q7vqUZ36fjyitd2cALKuAa0Diadqhg" +
       "hnJCpoMKw/Pzz+oVa178+FCNtd0K9DjWsnrqCdz+2zaRx97a/Y8GMU1Iwijs" +
       "4ueSWa693p15o2HQcZQj/filxc+9QY9DkADHbMoTTPhaIvAgYgPXCizuEu29" +
       "gbHPYbPC9Nq4/xh5sqUB6fDlT6r6Pnn1ppDWn255972T6i2WFVm7AIvdR+zG" +
       "5/txdK6O7bw0yDAv6Ki2UBOcmX7vha6Ha5QLt2DZflhWArdsdhvgN9M+U7Kp" +
       "i0ree+31uXveKSDhdlKuaDTeTsWBI2Vg6cwcBpeb1jc8aMkxVgpNjcCDZCGU" +
       "1YG7sGTy/W1L6lzsyMRP5/14/akT14RZ6tYcC70TrhTtKmxWW2aLr3emM2CJ" +
       "T3EesPxzGmRxrlxG5GEnnzh6It79/Bor46jz5wdtkP6+8Lt/vR059sHFSYJP" +
       "Gdf0OxU2yhTPmqW4pC9SdIo0z/VWV2cd+fBnTUObphMksK9hijCAv5eAEs25" +
       "nX5QlDee+MuC7Q8M75mGv18SgDM45Q86z1x8aKV0JCxyWsvVZ+XCfqYWL7Cw" +
       "qMEgeVdRTeypEqdlecYA6nFjV8LTbBtAc/C0WI5ZWBM2bRlWYRPleVjzOIO+" +
       "PGNfxuaLnNRDjakOQzUC/hLClCg4/IkD7nNvatCEIC8nwfGP2snx3T17pINN" +
       "PX+0zPC2SRgsujmno0/1vbv3bbFhpWghGZg81gGW5AlXNdhE8CisylNq+uWJ" +
       "7q97f+R711+w5Alm9gFidvDoNz+LHDpqHRGr/FmeVYF4eawSKCBdY75VBEf7" +
       "n8/tf/n0/gNhG/cOTkoGNU1hVM3sSyiTr832o2jJuvkb1T8/XFfQDoevg5Sm" +
       "VHlfinXE/QZYYqYGPbC6FZNrjrbUGDE5CTU7rmwdNtus9/X/pRfFjk266O/0" +
       "G/3t8KyxLXfN9I0+F2sew96XZ0x0wuGeLZsbVTlJOQZvx+px7GEXkuRMQYLO" +
       "f52t17rpQ5KLNY/aj+YZewybcUifZLyfELabA5CJGQCkGsca4Nlga7Vh+oDk" +
       "Ys2j9LfyjD2FzdchARpi3EEik0z32ycfv3Z53iknBbJ93+Q50fgz4TlmB2YA" +
       "wjoca4Sn3cahffoQ5mLNA9PxPGPfx+aYH8Iu8FWCeD4nNSLjwuuiiHVd5CL0" +
       "3AwgVItjS+HptNXsnD5CuVjzoHAmz9hZbE5ZCG1mCZpSeB9W/g5Ct099R+DS" +
       "C+BOzxRwi+DZbmu/ffrA5WINgBMWgoQd/Rei/mP3SEJtk0qRGEvLElV2qDJ3" +
       "aFbkw6i1t7dNvAkRXw6s5gRce6b5zmpxLRnZ3N3ZlpaYjjmlYH4Nm59wUiEZ" +
       "DKpKgTt2nXfBf2mmzjVa7R4bwT15wM+qQCDT1w2NQzHD4mn/rlTlmTOPyf4m" +
       "z9glbC5yMgvMuduQIYmhzgXBt12Ufvm/QCkNoSr7agzruPlZ1/TW1bJ09kR1" +
       "6bwTO94VxUvm+rcSktFESlE8SZQ3oSrWDZaQhXaVVu2ri6/3pjC8zAUeRARo" +
       "hRpXLNarnDROycpJ0WjmZNuMH9gHIgcjJ8XWi5fnQ8hyJuMBsaD1Uv4JHHKQ" +
       "EqQQ3166jzgpd+lgUevFS/IxzA4k+HpDd05XdGq4YvArs5fpUHaJLexnzlT2" +
       "46mgl/vKBvE/j5NXp6x/egakcye2dj1y877nrfsuSaETEzhLBWTT1q1apoBs" +
       "zDmbM1fxllW3Zp0vW+Gk+b77Nq9sworhgIq7qQWBCyCzKXMPdOXk+ld/dbD4" +
       "EhQoO0kI8ov6nZ5/Way/FFrSegoq952x7KoBim1xM9Wy6rvjD6xO/O0P4vaC" +
       "WFXGotz0A9LlU7t+e2T+yYYwqeggRVDBsHQ/KZfNzePqNiaNGv2kSjbb0iAi" +
       "zCJTxVeSzMLTRTGkC1xsOKsyvXgRysmy7EIr+/q4XNHGmLFJS6lxnAaKmgq3" +
       "x7lI8NXgKV0PMLg9ntpS0EfSuBtgrgOxTl13bhEL79aFm0lMnshBGxLeMoFv" +
       "of8AhVQj2gMeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae8zsRnX3/ZLcm4SQe5NASEPeuYEmSz+vd9frXQUKXtvr" +
       "fXhftne9u6Ukfj/Wr7W9tnchLVC1hKICahMaVMg/DSpFgdAKWqQKlLZqAYHa" +
       "UtHSVuLRCgkKjUT+KK1KWzr2fu/7iKJE/STPNzsz58z5nTnnzPGMn34OuioM" +
       "oILv2Wvd9qJdNY12LRvdjda+Gu52GHQoBqGqELYYhjxoe0i+59Nnf/yTDxrn" +
       "dqDTc+gm0XW9SIxMzw1ZNfTsWFUY6OxhK2WrThhB5xhLjEV4FZk2zJhh9CAD" +
       "veIIaQSdZ/ZFgIEIMBABzkWA8cNRgOiVqrtyiIxCdKNwCf0SdIqBTvtyJl4E" +
       "3X2ciS8GorPHZpgjAByuzn5PAKicOA2guw6wbzFfAPjxAvzYb7/t3B9eAZ2d" +
       "Q2dNl8vEkYEQEZhkDl3nqI6kBiGuKKoyh25wVVXh1MAUbXOTyz2HbgxN3RWj" +
       "VaAeKClrXPlqkM95qLnr5AxbsJIjLziAp5mqrez/ukqzRR1gvfkQ6xZhM2sH" +
       "AK81gWCBJsrqPsmVC9NVIujOkxQHGM93wQBAesZRI8M7mOpKVwQN0I3btbNF" +
       "V4e5KDBdHQy9yluBWSLo1ksyzXTti/JC1NWHIuiWk+OG2y4w6ppcERlJBL36" +
       "5LCcE1ilW0+s0pH1ea7/xve/3W25O7nMiirbmfxXA6I7ThCxqqYGqiurW8Lr" +
       "HmA+JN78+Ud3IAgMfvWJwdsxf/yO59/yhjue/dJ2zGsvMmYgWaocPSQ/JV3/" +
       "tduI++tXZGJc7XuhmS3+MeS5+Q/3eh5MfeB5Nx9wzDp39zufZf9y9s5PqD/c" +
       "ga5tQ6dlz145wI5ukD3HN201oFVXDcRIVdrQNaqrEHl/GzoD6ozpqtvWgaaF" +
       "atSGrrTzptNe/huoSAMsMhWdAXXT1bz9ui9GRl5PfQiCzoAHug4890Hbv/x/" +
       "BC1gw3NUWJRF13Q9eBh4Gf4QVt1IAro1YAlY/QIOvVUATBD2Ah0WgR0Y6l6H" +
       "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");
}
