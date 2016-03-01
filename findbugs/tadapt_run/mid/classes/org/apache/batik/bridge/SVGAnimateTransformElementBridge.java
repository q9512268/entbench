package org.apache.batik.bridge;
public class SVGAnimateTransformElementBridge extends org.apache.batik.bridge.SVGAnimateElementBridge {
    public java.lang.String getLocalName() { return SVG_ANIMATE_TRANSFORM_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGAnimateTransformElementBridge(
                                                            ); }
    protected org.apache.batik.anim.AbstractAnimation createAnimation(org.apache.batik.dom.anim.AnimationTarget target) {
        short type =
          parseType(
            );
        org.apache.batik.anim.values.AnimatableValue from =
          null;
        org.apache.batik.anim.values.AnimatableValue to =
          null;
        org.apache.batik.anim.values.AnimatableValue by =
          null;
        if (element.
              hasAttributeNS(
                null,
                SVG_FROM_ATTRIBUTE)) {
            from =
              parseValue(
                element.
                  getAttributeNS(
                    null,
                    SVG_FROM_ATTRIBUTE),
                type,
                target);
        }
        if (element.
              hasAttributeNS(
                null,
                SVG_TO_ATTRIBUTE)) {
            to =
              parseValue(
                element.
                  getAttributeNS(
                    null,
                    SVG_TO_ATTRIBUTE),
                type,
                target);
        }
        if (element.
              hasAttributeNS(
                null,
                SVG_BY_ATTRIBUTE)) {
            by =
              parseValue(
                element.
                  getAttributeNS(
                    null,
                    SVG_BY_ATTRIBUTE),
                type,
                target);
        }
        return new org.apache.batik.anim.TransformAnimation(
          timedElement,
          this,
          parseCalcMode(
            ),
          parseKeyTimes(
            ),
          parseKeySplines(
            ),
          parseAdditive(
            ),
          parseAccumulate(
            ),
          parseValues(
            type,
            target),
          from,
          to,
          by,
          type);
    }
    protected short parseType() { java.lang.String typeString =
                                    element.
                                    getAttributeNS(
                                      null,
                                      SVG_TYPE_ATTRIBUTE);
                                  if (typeString.equals("translate")) {
                                      return org.w3c.dom.svg.SVGTransform.
                                               SVG_TRANSFORM_TRANSLATE;
                                  }
                                  else
                                      if (typeString.
                                            equals(
                                              "scale")) {
                                          return org.w3c.dom.svg.SVGTransform.
                                                   SVG_TRANSFORM_SCALE;
                                      }
                                      else
                                          if (typeString.
                                                equals(
                                                  "rotate")) {
                                              return org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_ROTATE;
                                          }
                                          else
                                              if (typeString.
                                                    equals(
                                                      "skewX")) {
                                                  return org.w3c.dom.svg.SVGTransform.
                                                           SVG_TRANSFORM_SKEWX;
                                              }
                                              else
                                                  if (typeString.
                                                        equals(
                                                          "skewY")) {
                                                      return org.w3c.dom.svg.SVGTransform.
                                                               SVG_TRANSFORM_SKEWY;
                                                  }
                                  throw new org.apache.batik.bridge.BridgeException(
                                    ctx,
                                    element,
                                    org.apache.batik.bridge.ErrorConstants.
                                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                                    new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
                                    typeString });
    }
    protected org.apache.batik.anim.values.AnimatableValue parseValue(java.lang.String s,
                                                                      short type,
                                                                      org.apache.batik.dom.anim.AnimationTarget target) {
        float val1;
        float val2 =
          0;
        float val3 =
          0;
        int i =
          0;
        char c =
          ',';
        int len =
          s.
          length(
            );
        while (i <
                 len) {
            c =
              s.
                charAt(
                  i);
            if (c ==
                  ' ' ||
                  c ==
                  ',') {
                break;
            }
            i++;
        }
        val1 =
          java.lang.Float.
            parseFloat(
              s.
                substring(
                  0,
                  i));
        if (i <
              len) {
            i++;
        }
        int count =
          1;
        if (i <
              len &&
              c ==
              ' ') {
            while (i <
                     len) {
                c =
                  s.
                    charAt(
                      i);
                if (c !=
                      ' ') {
                    break;
                }
                i++;
            }
            if (c ==
                  ',') {
                i++;
            }
        }
        while (i <
                 len &&
                 s.
                 charAt(
                   i) ==
                 ' ') {
            i++;
        }
        int j =
          i;
        if (i <
              len &&
              type !=
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SKEWX &&
              type !=
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SKEWY) {
            while (i <
                     len) {
                c =
                  s.
                    charAt(
                      i);
                if (c ==
                      ' ' ||
                      c ==
                      ',') {
                    break;
                }
                i++;
            }
            val2 =
              java.lang.Float.
                parseFloat(
                  s.
                    substring(
                      j,
                      i));
            if (i <
                  len) {
                i++;
            }
            count++;
            if (i <
                  len &&
                  c ==
                  ' ') {
                while (i <
                         len) {
                    c =
                      s.
                        charAt(
                          i);
                    if (c !=
                          ' ') {
                        break;
                    }
                    i++;
                }
                if (c ==
                      ',') {
                    i++;
                }
            }
            while (i <
                     len &&
                     s.
                     charAt(
                       i) ==
                     ' ') {
                i++;
            }
            j =
              i;
            if (i <
                  len &&
                  type ==
                  org.w3c.dom.svg.SVGTransform.
                    SVG_TRANSFORM_ROTATE) {
                while (i <
                         len) {
                    c =
                      s.
                        charAt(
                          i);
                    if (c ==
                          ',' ||
                          c ==
                          ' ') {
                        break;
                    }
                    i++;
                }
                val3 =
                  java.lang.Float.
                    parseFloat(
                      s.
                        substring(
                          j,
                          i));
                if (i <
                      len) {
                    i++;
                }
                count++;
                while (i <
                         len &&
                         s.
                         charAt(
                           i) ==
                         ' ') {
                    i++;
                }
            }
        }
        if (i !=
              len) {
            return null;
        }
        org.apache.batik.dom.svg.SVGOMTransform t =
          new org.apache.batik.dom.svg.SVGOMTransform(
          );
        switch (type) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                if (count ==
                      2) {
                    t.
                      setTranslate(
                        val1,
                        val2);
                }
                else {
                    t.
                      setTranslate(
                        val1,
                        0.0F);
                }
                break;
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                if (count ==
                      2) {
                    t.
                      setScale(
                        val1,
                        val2);
                }
                else {
                    t.
                      setScale(
                        val1,
                        val1);
                }
                break;
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
                if (count ==
                      3) {
                    t.
                      setRotate(
                        val1,
                        val2,
                        val3);
                }
                else {
                    t.
                      setRotate(
                        val1,
                        0.0F,
                        0.0F);
                }
                break;
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWX:
                t.
                  setSkewX(
                    val1);
                break;
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWY:
                t.
                  setSkewY(
                    val1);
                break;
        }
        return new org.apache.batik.anim.values.AnimatableTransformListValue(
          target,
          t);
    }
    protected org.apache.batik.anim.values.AnimatableValue[] parseValues(short type,
                                                                         org.apache.batik.dom.anim.AnimationTarget target) {
        java.lang.String valuesString =
          element.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        int len =
          valuesString.
          length(
            );
        if (len ==
              0) {
            return null;
        }
        java.util.ArrayList values =
          new java.util.ArrayList(
          7);
        int i =
          0;
        int start =
          0;
        int end;
        char c;
        outer: while (i <
                        len) {
            while (valuesString.
                     charAt(
                       i) ==
                     ' ') {
                i++;
                if (i ==
                      len) {
                    break outer;
                }
            }
            start =
              i++;
            if (i <
                  len) {
                c =
                  valuesString.
                    charAt(
                      i);
                while (c !=
                         ';') {
                    i++;
                    if (i ==
                          len) {
                        break;
                    }
                    c =
                      valuesString.
                        charAt(
                          i);
                }
            }
            end =
              i++;
            java.lang.String valueString =
              valuesString.
              substring(
                start,
                end);
            org.apache.batik.anim.values.AnimatableValue value =
              parseValue(
                valueString,
                type,
                target);
            if (value ==
                  null) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
                  valuesString });
            }
            values.
              add(
                value);
        }
        org.apache.batik.anim.values.AnimatableValue[] ret =
          new org.apache.batik.anim.values.AnimatableValue[values.
                                                             size(
                                                               )];
        return (org.apache.batik.anim.values.AnimatableValue[])
                 values.
                 toArray(
                   ret);
    }
    protected boolean canAnimateType(int type) {
        return type ==
          org.apache.batik.util.SVGTypes.
            TYPE_TRANSFORM_LIST;
    }
    public SVGAnimateTransformElementBridge() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Es0L7ReToMOK//wpnL33MtScG/Yy0JwtCOC5pC6fHzyb8GfzKyAQ72kcYUe1" +
       "8v+Hq45PV+WNsvjgwerl4w+AiI2qZBT0MCxPdio+z8bAYxz1xkmMLkFyCkx8" +
       "Y+tgFZt3gXS88o5SmaNDRnfAqrJED1JUz+3besPzJ7KC2X/4jNnEB8nhJ7/1" +
       "6d/7e898E0wRBd2TluYDM3NuxGlS5st/+5XPPPG2l/7kkxUAAfThPktc/3DJ" +
       "lb6TxmUxKAviRNXHS1WFaoWfyFHMVDiha5W2d/RMLrRcAK3pcTKIvPjoN+2f" +
       "+7NfOyR6l93wErH+iZf+zl8dfeqlq+fS62duynDP9zmk2JXQbz+2cAg9fadR" +
       "qh7D//SlF//lL7/48YNUj15MFgnwLvRrf/i/f+/oc3/y1VtkG3c7/luY2Pja" +
       "t8bNiMRPPsxSMiR8kfOrFDUiGAs3XKuPk708G/fNAiMNi9eZNU7lnbHezZZm" +
       "nS94EpMaWhuzNVdaywoq9vvkYmPPdg1SmgkihZodyiX5PtND3GgvrAQ/F3jL" +
       "mzHWZLSvC8FMiGe7tUkT6VTvdvZsjrZUop+0domrtdF2CiNLLESRtCulA6xF" +
       "FkUxAwnszAnwrbJ28LDmcyknUUFtIYxpxxNHyTZ24G5T0WG20+mKKN90W6u6" +
       "jdE9W1NdgZfU3ZKorw1RoMHqwdRcfhfKZG3DZ10qFH1WmOW8ZrSL8XbYtjNp" +
       "Z5FhSMTcos+v6Zad1yw8l6wwn9Ks1t0IzJys57JMqW5iWSQxxLbTOZmE46Ek" +
       "be01vM22/WFcOCi33s1gzY9qFLGaz4ejLaMuLYx35/vBsqapCb4LGXKvDMgJ" +
       "iOXYosScxtjFgptk6CpdKWYYUe1wLRW2PA+3IsaLi1q8MhsbiwdBgVqL3Xzp" +
       "KgXdsClCGenkRpLXtZZVk8yasInayX4VzCaB3HbFubfyjUHKuAC47CGx4XcK" +
       "Ru0Je1ELpRrCZ644GgmuknpzbqDsNEeDkzWLDYY6LI263QaaptiYkoVk250F" +
       "ogXTZJOZDXpKgDdXwpIq5PqOIjaW0hZIZtRLYCew6KBwFKXhN0Rm16MmeC1p" +
       "0psh22VGU8OVwx2G2yGOMkVtj6p5Mum4WpG20wnt0Dg2WFGenq59bRLxnYZI" +
       "N/D1SBLwGN6LCx+lnV0fbo0MEkvH9WCJ43S2pFV/1NVzIZB8YizzfEJudvKM" +
       "41ceDiuzHlmgfDaTOEz0h9RC00fUCF703A1C5uxAG9StPm3tkj49M6VxPpuT" +
       "MFE3g0XUo8dp0kngsM1iWlBgi6y/HjN9YRfSXGe9HvksQzdcQQwEFtf7kSix" +
       "2LAdtDWiu17QuD4ucHE66CD91BuG6/p2nwVyH+NmXUZLmys6HHZgotfF1t5k" +
       "jDHw0u9ZS9NtBvJ4b+xTO2hjw3Fjy4xIoj7X7LW6HVgDsp0iHXqlDGJiv15O" +
       "NEENnNWi4WVkR5YGdYfu+3WnPpq6Jr21Fi2BV5ZEL0dSqrfKxsDtaW+H2TV3" +
       "EtktYZfSiRqgyKAI6MwUfLCmNJeYYGNhphBmamO5OyCGZG/QdnutzLeQdJOS" +
       "9cTaoDuat5ZSzeSnW0Res0nTGKh+btbDzPN7/KyJjDKjg+6DyEjm0q4t2vPx" +
       "gN652ZTvK7llk2FPnuYLYsPUGmHcaAjUVFBHYj2wBMla1pnmcj2biw23NyVq" +
       "wIIIbFgjbc4kTMMkemasmnixHJhxgS7qM7UO68tuuyNRex7ZGUTSJvnOVqQF" +
       "1ujNbGvmk6RT4BZFWgy1ISjT2PadNmFnDofvzajHzPqF3FBQNMytrNUWCa/H" +
       "r1EmGOEOJcEiEQEHF4O8Wet3DC4ctxFu5O0yeCjw2xmVNc09WduGSrNJRvRm" +
       "p0Y1fNETaRAdu54fjwmuKOzhqOvCsKE32DnKtFKa6FFFNlgSXGO8mdewHh3P" +
       "Flty2kA0LDR0Fg1TLa4Ne3U4UheUPbA0a26nsz0znnY78T6wXa47gNvpfMkI" +
       "mzGJTwqpR6pTdUK0EnLN6V1fGzN6d8nQo5pOC5bNsPBQ3s+WnIFxUoY0UlwK" +
       "84xfCeMNiXd64wKuo9uNKRr6KsLr7YUwYW14jbXFCF1PZ+zQ3uZtclTHUtGl" +
       "Zn1UQtAuXHRbXRSgvxniqsgYeNJYx1GvwOciPqvDmOpMg3qrBau9/VpTtdF6" +
       "7mu9ovBme6NoLIxs2SE9D9lu2lZ/PKO00TaOLCoR8/lmsGxhYBmU/KBDmzxA" +
       "znRhD1p1VrBMfkVL7aHRVaYeh5Asaoh9lA1r7LQpdFOfwLZdrx4wihfvEMNx" +
       "ObtO5u42bEcdh8hxeA8EskWHFut9ds/WvADdh33d7vXxNZ5RcuGsKIZaZobZ" +
       "SzN6157Qo86qx8hJJivLTrprIrnZinYUDMuYt4/lhDPSNSu0Y66NFo2wPmHi" +
       "3XCY2WE2okNrijaZXmvsZnlENXjc3Di92tBOxDWTNZaL7Q5rqWGzpW5GK2w9" +
       "tCVyquymG2LA7FuraOcBCMQ6mA7L0yDzSX3kBMNwGai8YPGd5mIj6vNdvbdh" +
       "YKazFoczH5s62mChoo3ZGG+YtZ3hTmFdcJhRE1cUeB1RXIggcIdJ1X5zpazE" +
       "9r6Ddt1OKtEKu6apzmoV27k4NYo0Jc0dMmZlidiZA3LpLTOtgZkxq/VgdYLQ" +
       "JO8hi1VGUdiC4xA44WyjkY6jaD7d7dZKlM/bfG/JibGYUZO5uu/DVqFlk21L" +
       "0xGqU+guRnUVO9umbH2Y4SmrLnoJssFtJELYxJ7OVUYJNyRKNeXFkM8Ks9sY" +
       "z9sNhZI6Wmvr+ThdqCi14uostmyI2Y6wzYYmZWLXnBdYA6bEVOa3vMTs8zh2" +
       "PWXjNFOcUrD+fK2JSynBdN8KiQXblXxr3Ujytijb0gYvpsOGWB+K2ajWbBF6" +
       "y0enao402yRCRdyKjKdbdLDupkiCjgbjWdzu1nYwQxt4FI31WpOll4u1VS9I" +
       "Zcura6Ex3TNFz5yZ7tTkc2NqLknfFqyW6zhIIe0k057yOt3ex6imESpqZ7it" +
       "ih1uMZrh87k479A7kOO6Gj4RCMzDpii3j71uZneH66HK9hY8LLBqOhCF/irc" +
       "RoEzdAYFsV/IJDGhKFIN3IbUcMLIlAQrm5u1jNpMY26/F5NVOBlN0GknUhFx" +
       "Hnf8dLd16HA9k/PhEutnRddZgrd0Jo+EPV7bj5jCxNTcCKZKHi5qLrOjVcs3" +
       "k73S0kZupxXDK2xc5xPDdcnucEG3a4mPIXLqKgifD+h8ZEedrYPr5rDl4x7R" +
       "3o8lExt5mjPcbZewJU+UUR2RdK6rDDKX2gTGFh+MtQiG2W1BoZjJ5cJwNpMS" +
       "Xm2GtY7v+zN71GpHy0Uz75LotoEh3RncwDJMGTnISOg5Nl4oE3bGN8Ws5S9U" +
       "U+ZSuDdAlUjfEUqU9thF4IkOUQ8agZflzRlN5yi6my5iNgTZX7CW7fpwNPMY" +
       "hm0gm72HhtQ8QntmXlDzoo3J43Y+j1FSk3G8pWXsIszQomtFmapYnS5i5ENj" +
       "3FEA3si7RIZTR+NrQ09ROjuuR9B6Hs20uUzplNxAESrj+ipMtNYNpLtnlmHI" +
       "98JZb2lObLXpT3oDnucbIyoZEPSm0w/ZzA+2acix2MYYrFbNFgYXxnjqCCqx" +
       "UXOu5ROyI6YKmu4SJJhInQlLa66G6muw4uiNUFiORbQ/94Ouv5vNp9u5aqBq" +
       "ZqV1dg5rncgc4UW0Hyx0ZYYhbJ+R0DWzRwFy1aLdcBYVYmfAcmCVAtmLlLVh" +
       "lV3aWGtmIXlLtXrTqNkUYLgVS6IhLOdKYLeVcXsBGxsvz7qtGkoVBteeZovG" +
       "Ct17XW+uwSrSwoYqLVm2MMCnCDHA0iXMYCu0A7emMslIK7vPk31kgoZNxLa1" +
       "aWtvIiMswDHHk8ZUKI3woYOoe7M+QfoTfcHlTXe4atirUAnhZTZMpXl9IzXj" +
       "oLMBeaEIqyvwEmDyRgPjUJPxen12KU0ds9ZZyONFIk96ONo3rXF/I5K20QzH" +
       "tkxOfWcp1ARh2enUt8GwcBobXGkxvBF3mA3iFQObn2Rjb991+fqaowdbnYma" +
       "0+4qXYzFqe+qzXV70gxgi8em6nDE7O0E34/nBYGsOsU8WU1zKxlIlkBt943J" +
       "fsDmIh96xBTMDlcgMxTn9qShy4aietGg1SyEkdVfa/JaDyf5bG9121SfJ8Yi" +
       "mXjNiTtUlR7CpTUb7ro+Txm1odtlmS2+8jV2h8yjYep0NBT3WgtC0+rOIpRl" +
       "Oui2dWrpNoZ2w90O5X6BzMGCI/fXcJcxx2YCVrdsb3T7ai9gsLHbC0m5NQ2W" +
       "hqizTBdLxLEQgBVyYXGs1xki+y1Z+GqvO8haMjpBc2SBzpAcTUC+0+4Mt3C7" +
       "vcQGKKk6WdslrK5ub5BNgpNU6rV8tq9mrBd20Z0ezBnToJhAltLcd9LxwhGV" +
       "JkHVkRrKF6Yyb+42DrrVieUOk7UEljc7zqN3IV+nO82il9DzXT/3LKBKv4O5" +
       "+6EIG5w8jGbd1X41KwZLZNoQIkXLzYyttw2Pn/kbZxc3lmFp9RWHKDUvpedE" +
       "fyvaEk6QEzUZdog9H/v2omsMO9aquWFHHS6OdUSVR00YRkaj0OZB2sZt16sm" +
       "bK26+1YjsbRgNO2wdjtgFxtlNZBCs6mvRhMt2NEbWErTuK8vc07uOhsul7vL" +
       "DtXud3Um1Aay0u/CA7dvU4bGOlxClWv9tA4WErWVtHLgx85KZibFdjXhjOFI" +
       "01tj0kEUIsmwftiiR4MVx442C7WxZGIOOBo+E8hGS9lswFv9j5Sv+z/+5nZc" +
       "Hqk2l07PDrcOVjaM3sROw6Hp6bL4wOmGevW59w4b6uc2HaFy9+SJ2x0JVjsn" +
       "X/jYSy9r7C/Urx5v1oox9EDsBz/o6KnunGN1H+D0odvvEjHViejZJuJvf+y/" +
       "PD7/UfMjb+KY5H2X5LzM8leYV746+n71H1yF7jrdUrzprPZip+cvbiQ+GOpx" +
       "EnrzC9uJT5xa9tHSYk+C73PHln3u1kcVt/SCK5UXHOb+Dnvh4R3aqt19N4Ye" +
       "2ujxxFdlZ3os+ujMXbw32pg6z7Sq2F7U7wnwRY/1Q7/3+v3UHdo+WhZFDL0N" +
       "6HcyQyc7rU/e7sjvcLB3ZoD9WzDAU2Vl2f5Dxwb4oTdjABAYQejHuhrr2i3t" +
       "cOX4UPFYpWdvUknz3SPZs9yjwyEmCIe5HAJjVNz+7h0s9/fL4uMxdE0NdTnW" +
       "T7ufDPXBm4Y6DKNEcSir8UX6yoyfeAtmfOeJH0nHZpTerB998g396PN3aPvH" +
       "ZfG5cjrKKyinJ4/8OThdxtA9kemH8ZnGP/sWNC5BAfoB8PWPNfa/NxrfdbaA" +
       "VOvCz5fFpyrSV+5ggC+WxS/F0IOVAaqTlxNPeO7WnlAdL0THfleeDp51qozz" +
       "y281qmDwfe3YOK99b4xztSK4esku/+IOdvlXZfEVADDn7AKWrQ/cftmqjjgP" +
       "ZxUv/+Izv//TLz/zH6tTwvutaCmHeLi5xZWac32+88o3X/va25/4YnWqfrci" +
       "R4d15fJdpJuvGl24QVTJ/tCpPR8v9Xn22KYntoViSP+e3uko3aI8/PXDU3Q4" +
       "uTzy/2agSusv3xI8q8OV38yvQJX//NatPadyjCrtOs247nV0bxObt0KDu8AU" +
       "lI+vBvllBzsJnXecHb31Hd/TyzA5aTtcKLH8o9Mba6Axv6Xw24Pw1WBl8cwd" +
       "HPbrd2j7w7L4GsAxtRTmIPsdyP/oOFCrcP6nbyGcHysrbwBtvu/Q9/D71sP5" +
       "yhnBVyuCP72DNt8qiz+OoYeBD57c+LkNzt+n+L6jy+fWtm+8Ge3zGHrqja4V" +
       "lfci3nPT9cfDlT31iy9fu//dLy/+3QEDTq7VPTCB7jcSxzl/jH3u+d4g1A2r" +
       "UvWBw6F2UP38txh6920yIeDeylku9O0D/esxdP0yPXCZ6vc83X8Hi8UZHWB1" +
       "eDhP8hcgSABJ+fiXwYnfI298E+uCpfIrF98+Tufk0Teak3MvLM9cwOvqdurJ" +
       "K0FyuJ/6gvqll6npT77e/oXDvSDVkff7ksv9AFoPV5ROXyuevi23E173jp/9" +
       "7sNffuADJ69ADx8EPnPzc7K979YXbwg3iKurMvt//u5/8sO/9PI3quP6/wv+" +
       "ThNGNiwAAA==");
}
