package org.apache.batik.anim.values;
public class AnimatableLengthOrIdentValue extends org.apache.batik.anim.values.AnimatableLengthValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        short type,
                                        float v,
                                        short pcInterp) {
        super(
          target,
          type,
          v,
          pcInterp);
    }
    public AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        java.lang.String ident) {
        super(
          target);
        this.
          ident =
          ident;
        this.
          isIdent =
          true;
    }
    public boolean isIdent() { return isIdent; }
    public java.lang.String getIdent() { return ident;
    }
    public boolean canPace() { return false; }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableLengthOrIdentValue(
          target,
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER,
          0.0F,
          percentageInterpretation);
    }
    public java.lang.String getCssText() {
        if (isIdent) {
            return ident;
        }
        return super.
          getCssText(
            );
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableLengthOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableLengthOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableLengthOrIdentValue)
                result;
        }
        if (to ==
              null) {
            if (isIdent) {
                res.
                  hasChanged =
                  !res.
                     isIdent ||
                    !res.
                       ident.
                    equals(
                      ident);
                res.
                  ident =
                  ident;
                res.
                  isIdent =
                  true;
            }
            else {
                short oldLengthType =
                  res.
                    lengthType;
                float oldLengthValue =
                  res.
                    lengthValue;
                short oldPercentageInterpretation =
                  res.
                    percentageInterpretation;
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
                if (res.
                      lengthType !=
                      oldLengthType ||
                      res.
                        lengthValue !=
                      oldLengthValue ||
                      res.
                        percentageInterpretation !=
                      oldPercentageInterpretation) {
                    res.
                      hasChanged =
                      true;
                }
            }
        }
        else {
            org.apache.batik.anim.values.AnimatableLengthOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableLengthOrIdentValue)
                to;
            if (isIdent ||
                  toValue.
                    isIdent) {
                if (interpolation >=
                      0.5) {
                    if (res.
                          isIdent !=
                          toValue.
                            isIdent ||
                          res.
                            lengthType !=
                          toValue.
                            lengthType ||
                          res.
                            lengthValue !=
                          toValue.
                            lengthValue ||
                          res.
                            isIdent &&
                          toValue.
                            isIdent &&
                          !toValue.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          toValue.
                            isIdent;
                        res.
                          ident =
                          toValue.
                            ident;
                        res.
                          lengthType =
                          toValue.
                            lengthType;
                        res.
                          lengthValue =
                          toValue.
                            lengthValue;
                        res.
                          hasChanged =
                          true;
                    }
                }
                else {
                    if (res.
                          isIdent !=
                          isIdent ||
                          res.
                            lengthType !=
                          lengthType ||
                          res.
                            lengthValue !=
                          lengthValue ||
                          res.
                            isIdent &&
                          isIdent &&
                          !res.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          isIdent;
                        res.
                          ident =
                          ident;
                        res.
                          ident =
                          ident;
                        res.
                          lengthType =
                          lengthType;
                        res.
                          hasChanged =
                          true;
                    }
                }
            }
            else {
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
            }
        }
        return res;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uthb8h8NUFJ9kSEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zr1n0f7+++7BvH99ppEs917Dxu09pKfxQp6gXHSSVK" +
       "FCWREiWRFMU0cfgmxaf4EEV27toAXbJ1yILN6TIg9fZHukfnNmmxogW2Fh66" +
       "tQkaFEhR9DGgSVAUWB/L0GBYtzXrukPq977Xv8S1MQE8OjyP7/l+zvdxvufw" +
       "vPwN6HoUQpXAdzLD8eNDbRcfrp36YZwFWnQ4ouqMFEaaijtSFLGg7Hnl3V+4" +
       "/Rff+pR55wC6IUJvkTzPj6XY8r1orkW+s9VUCrp9Wtp3NDeKoTvUWtpKcBJb" +
       "DkxZUfwsBb3pTNcYuksdswADFmDAAlyyAHdOW4FOb9a8xMWLHpIXRxvoh6Er" +
       "FHQjUAr2Yuhd54kEUii5R2SYEgGg8EDxzgNQZeddCL3zBPse8z2AP12BX/wn" +
       "H7nz81eh2yJ02/IWBTsKYCIGg4jQQ67myloYdVRVU0XoEU/T1IUWWpJj5SXf" +
       "IvRoZBmeFCehdjJJRWESaGE55unMPaQU2MJEif3wBJ5uaY56/HZddyQDYH3b" +
       "KdY9QqIoBwBvWYCxUJcU7bjLNdvy1Bh66mKPE4x3x6AB6HrT1WLTPxnqmieB" +
       "AujRvewcyTPgRRxangGaXvcTMEoMPf6qRIu5DiTFlgzt+Rh67GI7Zl8FWj1Y" +
       "TkTRJYbeerFZSQlI6fELUjojn29M3v/JH/JI76DkWdUUp+D/AdDpyQud5pqu" +
       "hZqnaPuODz1D/YT0tl/+xAEEgcZvvdB43+YX//Y3f+B9T77yxX2b775Pm6m8" +
       "1pT4eeVz8sNfeQJ/un21YOOBwI+sQvjnkJfqzxzVPLsLgOW97YRiUXl4XPnK" +
       "/NdWP/LT2p8dQLeG0A3FdxIX6NEjiu8GlqOFA83TQinW1CH0oOapeFk/hG6C" +
       "PGV52r50quuRFg+ha05ZdMMv38EU6YBEMUU3Qd7ydP84H0ixWeZ3AQRBN8ED" +
       "PQSep6D9r/yPIQc2fVeDJUXyLM+HmdAv8Eew5sUymFsTloHW23DkJyFQQdgP" +
       "DVgCemBqRxWgmwtvJScpjdtypViSHY3SPCM2p+FQBXT4ovaw0Lrg//N4uwL/" +
       "nfTKFSCaJy46BgfYFOk7qhY+r7yYdPvf/Nnnf+PgxFCOZi6G2oCFwz0LhyUL" +
       "hwULh3sWDi9jAbpypRz5uwpW9goBxGkDxwBc5kNPLz48+ugn3n0VaGKQXgOy" +
       "uAqawq/uufFTVzIsHaYC9Bl65TPpj/J/p3oAHZx3wQX7oOhW0Z0pHOeJg7x7" +
       "0fTuR/f2x//4Lz7/Ey/4p0Z4zqcf+YZ7exa2/e6LEx36iqYCb3lK/pl3Sr/w" +
       "/C+/cPcAugYcBnCSsQSUGvifJy+Occ7Gnz32lwWW6wCw7oeu5BRVx07uVmyG" +
       "fnpaUmrAw2X+ETDHDxdK/wx4Do+soPwvat8SFOl37TWmENoFFKU/fm4R/OTv" +
       "/eaf1MrpPnbdt88shgstfvaMuyiI3S4dwyOnOsCGmgba/cFnmH/86W98/EOl" +
       "AoAW77nfgHeLFAduAogQTPOPfXHz+1/76ud+++BEaa7E0INB6MfAhjR1d4Kz" +
       "qILefAlOMOB7T1kCHscBFArFuct5rq9aulXqNFDU/3P7e5Bf+K+fvLNXBQeU" +
       "HGvS+749gdPyv9WFfuQ3PvI/nyzJXFGKFe902k6b7d3oW04pd8JQygo+dj/6" +
       "W+/4p78u/SRwyMAJRlaulX7tyn4aSuRvjaGn77FW1Xf3Frs3VTAGK4WGFpeS" +
       "hst+z5RpOUUlNaisqxXJU9FZizlvlGdimeeVT/32n7+Z//Nf+WaJ73wwdFZB" +
       "aCl4dq+TRfLOHSD/9ovugZQiE7TDXpn84B3nlW8BiiKgqAB3GE1D4K5259Tp" +
       "qPX1m//5P/zq2z76lavQAQHdcnxJJaTSMqEHgUlokQk83S744A/s1SF9ACR3" +
       "SqjQPeDLgsdPdOlNReH3gqd+pEv1+9tMkb6rTO8Wyfce6+eNIJEdS7mgnLcu" +
       "IXhBKNdKSteK1yqYr6cviW5DywWGtz2KCOAXHv2a/dk//pn9an8xfLjQWPvE" +
       "i3//rw8/+eLBmRjrPfeEOWf77OOsEv2b9+D+GvyugOf/Fk8BqijYr7OP4keL" +
       "/TtPVvsgKMT/rsvYKocg/svnX/h3/+qFj+9hPHo+xOiDCPpnfuevvnz4ma9/" +
       "6T6r13Ug+HAfWuNFMtiLYRgX7suXSlsmSgjdS0xhViTPllVYkbx/T6X5utTp" +
       "uSPpP3eJOhXJB+5VnFfregHCQcnBwV5xjhzEndJyiuj3cB/9lsOJl4D/SJFw" +
       "p+D51wJ+3/ax8u365cpLFPuC0zXysb+cOvLH/vB/3eNQyqX9Pvp8ob8Iv/zZ" +
       "x/EP/FnZ/3SNLXo/ubs3HAJ7qNO+6E+7/+Pg3Tf+0wF0U4TuKEcbtDKoASuX" +
       "CDYl0fGuDWziztWf32Dso+lnT2KIJy4a1JlhL67up4oM8kXrIn/rfgv6k+C5" +
       "e6QSdy9q0xWozJiv4p+K7PeVRAcxdNOKyvDtfvZyU/Z9R5O8U+0stcH6dtqg" +
       "nOf1u8Hz9BGvT78Kr+F3wut1q+C0ePnQBZaib8vSHtkV4Jyvo4fNw2rxnt1/" +
       "0KtF9oPAi0flPrnwG5YnOcdcvH3tKHePXRsP9s1AQ++uneb9+Bp8x3wBQ3n4" +
       "1E4pH+xRf/yPPvXlf/ierwFtHkHXy+AbKPEZY54kxbb977786Xe86cWv/3gZ" +
       "IIEZ4//ezzW/XlD92GXoiuSFIvnhY1iPF7AW5R6EkqKYLgMaTS2Q3U83rjmA" +
       "xb8x2vj2PyCxaNg5/lFVEUdTZScICTyswq2Fbs/y5jRPZ3WzF+M4z29mtkuz" +
       "s9xDhyi7oKrVKTltKs36pO2takmNQUfsjBtafZwzB05HHS79jT8e2vMORwiN" +
       "rjhbxivccFY4x2ZxQY4nHHy0sUf8MjGbNKDgwZO44YfVYITKnuBtc33LuG2X" +
       "rGUTZG2jDZfus/oYJrz+Ak45zW+yOMI2tGmUCoNdMG9KlbUeeu1mte1jG67C" +
       "uqy36eEet5rRUhXhPHYuBmY0DXy26/VRerPy81U+INHudClJEjuS6aqYE0kj" +
       "cM1WRszEjputVT+ocnQ9pnjGkCcdJ6VdiyDxBTFKbQQDiyoytefsIN7OmxjT" +
       "bWMe2hoMdUZbGpjXlBxVHQ5dHMlZO/MmmIwQLrKzXT3UFLVm47xsW3ytMXAU" +
       "AmnIS35sGuhyEpO1XVVs1NXNoLOczDIWhwdKrqS79sx1A9uSJ+3NNmpmudne" +
       "DSVnbKMznV4I2iYeGAvCruG+xQfMYm1sA040hUwfK6w54kLE8Ye0Ig+rC3ph" +
       "TSK0KfZX/byKm7acZDi6mKm2Iy4txzFXZk2oz1rqFEaaaiUeLpGgulmJfsua" +
       "duxdusRnE9wV6j1qqralcIz02ICmeyu/lS8342asZDW1sVyvuwlH0GR7RLHm" +
       "KhoZMbKdV7vCqo9qGZ7aaJMi6svpiG3ygc432PVwGmksz/mYMaWN1YgerCeO" +
       "iHtNsAaxCWJkvN3izTU1pmuq0u2MO2i96zGutgTeuzruNOZs4pvTtU7aY8rS" +
       "6FnDUBcrzKdrI3gc9DlVWfKCzCqsNCBNFx/UCbbT43vjzmg+Hdlq15xyaT/M" +
       "Z4icoZrWZnldUVbTXXVlsQMGj2ibJ+Eg6m4WST8eOY6rVI2eNbeyVsgxAju1" +
       "U31tdnpps4unJuN1nVZbiaUwrFP0Qoz6HE1PRYHLzVUrnOd0KhCwjICZ605M" +
       "P662yVmlQ47m4mKS9Kbt+SzK8lGazcUd7eAiI2+bBIG2GnncGNkNscttKivN" +
       "6jN6vDBd0qGqdafdY6crlnXYbsumxY3ZXnmN2aTfgYO5Q6+NuhelzbXRmC+J" +
       "KoMEnkESy2W3O974uL6RbJan9NU286aGQHGjYSfP7K7YJOZMs89kaoN2dXcp" +
       "DjfIpEPTuWO5mQXb2IK2U1KtB0OxxYTqQlEidIrjC5XWWIRKjd0OQOjEXj0z" +
       "NLvfj+sgmBiI1a7hhN5UGzS5Pt8Y5D10Nm94Og8Lm8qwFVWkNS10Jp1tz+IG" +
       "pDsJ/Ia1yXf1ec+c1driDlM1BGuQM2m8yZ0pYgwpXHHwWYjPZt3Vwvb5PtGJ" +
       "bMKkQw/TosVQ6SiVxmDXwcVE4j3AGjJNW8kmJZgYF8N0vkI6lB9FfQbRVHft" +
       "MBTpdKdqqCdLz2m21VHOBbbh8YLVbYRrM6R0cihyQdJGfLnldWoJHw+5uLVM" +
       "14kuSwHd5bIltYx3Y2Eh9bF00FLqU6VN+jILuDO8DdracvCIYc2GtiU9mc+A" +
       "PGtmirQ6TiPrmUPdH9a3QcYmramIJUGDktXKdkWOKk1RrgX1YbMzcQSZwe2M" +
       "W/HeatKiNgN+sgQps87R+hZJfH0m2yqHmT2LcFRfEPDxwqk54/EcsaWZhkeS" +
       "pgVrh3ZIVt95A2SqWQwusXEfznepVbdXQbY1F7LVHcP1neo3iCafB/Wp6Q0X" +
       "Xp8IRwlChXDMw+0KO8FrkqAGESKM/DSrJVtK6VsRV1lkvagdx22L7qipbFa1" +
       "ir5VmzGKCYwRzbKGKkXdrcxEZrTqj2atrMY0Pa+dqxOSbQmUbjbX4lB03F2O" +
       "exuPiIIUm/P+uj6cEXwNEBApzpgNG+xWXXaQHZehvtXDByhgCk21kKw10bUg" +
       "b/CeRTssEiCqQWkVxpazfo0R4LbpZB2Wq+FsO2ZdQ/FoppWst5MG2uCbtl9b" +
       "5wssqbRmWZuEV7NskkxjvzLiuxkrmfgir0ztIKO6m4GojUxXFJb4hFJnmojs" +
       "Vppf6yTVRdVpDMbdHmfVY9FSMHK9rpsGx4TjMCed3GG2MVpvwg07n4V1A9ZE" +
       "sAgQmza30XcDkegra6a31KprlR111J0zytX2hq/ClTkxYzsTosuOMRrd9Uyr" +
       "OqjRLhG6WyznKroXMvlu7i/IrDtJbI/vLHzLbmUde9Cd9oJRXtXDFq8O1ZGZ" +
       "mNJcs2wjNMepPBsNE2/iiXAtoXCGiStTRgXi3mF1ap6yXDJbEnN0h65sJeu3" +
       "JGRXE3oTBB0QTX9pCitvsssUIQy54aBn0CaMNsbDrpVJDdTgh8nWSdVaN8oq" +
       "PrakO4ijZFVmxoYGUR1z62l92astJrBNC5MKTxsLai3u6iO9psub0FT7C3fd" +
       "12cUqUjEspZhnQpmb8kmT03ZRldIM20NE13YIzqEOVb1JYZEjbmSO8ZyasfM" +
       "jrHX43430yuanFTazcquH8yotYKng9zA1ATO5rtd1hfr1NAVnPrc2QY7kahG" +
       "O4VwB5QjD8LlOO2usSrmtZncRWFEBgGKlqZJQnZa6TqE86YJ1tNaXq3NdWLW" +
       "rdajVnM0WdT7TMIGPrnwFoisIYxAeGKr2mn2Br2AIgyJjMYy0UOq2MKqWY6t" +
       "T+Vs41Z3WFeZsspkJOO81OHURRjlWDvldT3bkroysIllbjVqYlcRJ36IbYdM" +
       "x0d54BtylGQp1N1WdpU1keqNjS/b07WGI/ayP+rJAt8R9Ym6mEkk2V0Q6cCr" +
       "Jx5a5RqpMGFnQUPekVQdHwtRupC9MSc0J6OZNdqJw244SHrigsZCGd8gm+kW" +
       "zkUhh7FYiNxAaw/mg+FQbmOwCQu0ocKwj47Cfl+QCLovpnbLI5v1rR5X+GZq" +
       "tkIkwJvTuiUuqlNC0kit4u3gCbzOKgFMWspEUsdJQik9fzMeDKzZZISOPXWw" +
       "nA03aLei9QLebDpatOUxepSq2048aDRZGCeELGVMYhFOkqQXqCG6mVayGb0Y" +
       "Nio5qm/HVoaN3UHOub26v17vJp4VZ8TaXW/W8y039BK+jq0Qr9WiRv6wQ2FT" +
       "Z7fUsmCYdGN7NlqmmNwHbg+rDMb9hErbRrS1eLyf6FvOVunOxIQtHESSokgA" +
       "55la8/aqpU3JeZ8U6oaqZpP6EpnFAsUmjun1q3nNXgbAHPszsjuuUQEGb3My" +
       "D0O1gvTQyor1yYmZh9MomfcmLWGW43HYbfIrXtKmOi5U+CTJp6iyi51Q4Uxq" +
       "JQ6ZHltr1Xpc6FBbC/ODUdcJCYSfzTasshLsKoqlgoxP62bWilFvJaCuATPG" +
       "YCsYmuPBy43fl70muiPyWot0l0gdw5Kom9eEbaXNoltvC3Y9i2Xc69nWeljV" +
       "Fwg3w9BZezQYJnNmRU6ndp/DXJHlVp7pa1ND3Yx72x7vaMtQnQD+BQ4nCJjs" +
       "kbVuT2KMnPaRrmXS3rydb3ttpYETvSDvxVTeI5YC2ab4WY/lbEmzoiTZwNtO" +
       "yiZN0sACe4iwKJMrLUzih4g7d1GL3lKk2ES9NUaiNkNY7Gih8kuDddpNhO+s" +
       "TbLqrBIMkYmmHXR4fKwgEdcwmF0dVDPkIlH8DV4hRwlM2UGjMpY2xhwLMZ7W" +
       "VVLuN3os1tlU3A5srquxQ+gaQyiVaDY2hYHtgvZD0N5caVF/WBPwJOFdE9Uj" +
       "qzfeztfTDTkZ9rVKm9wwfE+eNM2AcFqsT8UDpekNZ2qzjdB1j8NFUuC89VbJ" +
       "WplfqSoes4iATrZ9qb5ripXNxnfoja47G6Me2Ut1gui2vm20RXkSBf4ssoVl" +
       "vS5jRpPZphsz2nFuu9kx54wpDiPW8KKG2sc2syUMZ6kqdOwePcHni20FFvAJ" +
       "RqcaiafhtNaYiWEnNgZ4bbcIHdROvLZGdMV4t4poI0ZrMoou83CDJUK3Eoxa" +
       "6hLMXcTXSV2gNaFvL6MaWATclqHboTy2qrVa0+4HubVmh3ilnsGyVR2H3CLU" +
       "NxNmDk/0QT7oSvw4qdJZsyMonaCltzGSWlbMfqvK1EKuXquoIdKWJgLDCJQB" +
       "c9tUI/Ip5sxZV4zDPOWJTRUnpk2Zqws1muiGFrY1QCi0bYZIxuvSdrsTakaV" +
       "1dAsi3rriuuRQbprxbWc3UrEQp8YNbxK8yDupXV+AyuSW7ezlaSONhW5SmAE" +
       "4Y9Hc0bojegd0/a0cduIcWrTai5bllmxK117qXETvrIUPFxWvQGLdsOJselb" +
       "LrEM2nJjXl0bFod1BAq3CGzYwIKIq1H6kF12hi11kSIin9i43c3QeSdcCVuO" +
       "HjhRlMSm3DJbE44Yte1FH2y+n3uu2JZ/8rUdFzxSnoKcfH//G5x/7O533ln+" +
       "bkAXvtlePO987PicNYTe8Wqf1ctz5M997MWX1OlPIQdHB5ujGHow9oPvd7St" +
       "5pwhdRNQeubVzynp8lbB6WHhr3/sTx9nP2B+9DV8g3zqAp8XSf5r+uUvDd6r" +
       "/KMD6OrJ0eE99x3Od3r2/IHhrVCLk9Bjzx0bvuNkZt9SzNjj4CGOZpa45BD6" +
       "vudwH9zL/pJz489dUvcviuSfnR44Fq/uqab889d8vv7ZE2iPHkOjj6DRbzy0" +
       "L1xS9/NF8m9i6AFDi0+wfegU28uvA9uJ2LgjbNwbj+3fX1L3K0Xyi0BsiuQx" +
       "kqJdENsvvQ5opb0Xh8MfPoL24TcG2oXvo+/7Dm8zlGf5JcEvXjIfXy6SX42h" +
       "W6q1t0K2vH1Cn07Jf3wdU1LMRvmlSD2aEvWNl/bvXFL3e0XylRh6CGiyqIV+" +
       "OSdF2ZdO8f3W67XUJ8DjHuFz33h8f3hJ3R8VyR8A6QF8OFgngKe/YKtffb3S" +
       "e29RfYQufWPQXd9/SyvlcJLQp2K5cDR/1fL2n/r/2yUz8d+L5E9i6E3lZTuw" +
       "zkjxRUH/6Wv66hdDT1x2M6i44/DYPRcV95frlJ996fYDb3+J+93ycszJBbgH" +
       "KegBPXGcsx/FzuRvBKGmWyWYB/efyILy7y8BJ5eZfAzd2GdKDP973+mvYuit" +
       "9+0UQ9eKvzNtr0AxdOdi2xi6Xv6fbXcV6NlpOzDsPnO2yQ0gLdCkyN4Mjh0W" +
       "+pquX+3d1pXzcdGJDB/9djI8E0q951wAVN49PQ5Wkv3t0+eVz780mvzQNxs/" +
       "tb8OpDhSnhdUHqCgm/ubSScBz7teldoxrRvk0996+AsPfs9xcPbwnuFTGznD" +
       "21P3v3jTd4O4vCqT/9Lb/+37/+VLXy2/gv0/S2tdChQsAAA=");
}
