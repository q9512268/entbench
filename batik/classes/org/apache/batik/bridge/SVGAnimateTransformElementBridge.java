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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze5AcRRnv3XvmHrnL5UmSu7wu4IVjl6c8LkaS40IO9y5n" +
       "Lpy6AS6zs717k5udGWZ67zbBCMSyEkRSGEOCFtwfGgxSeSBKiaVgLEoCBVJF" +
       "CPIqwAcqGFOSskQlIn5f98zOYx9XQeNVTe9c99fdX//669/39TcHTpIqyyRt" +
       "VGMRttmgVqRHYwOSadFktypZ1nqoG5b3Vkh/vemd/ivDpDpOpo5IVp8sWXS1" +
       "QtWkFSetimYxSZOp1U9pEnsMmNSi5pjEFF2Lk5mK1ZsxVEVWWJ+epCgwJJkx" +
       "Mk1izFQSWUZ77QEYaY2BJlGuSXRlsLkrRhpk3djsis/xiHd7WlAy485lMdIc" +
       "2ySNSdEsU9RoTLFYV84k5xu6ujmt6ixCcyyySb3MhuC62GUFECx+uOn903eP" +
       "NHMIpkuapjO+PGsdtXR1jCZjpMmt7VFpxrqZfIlUxEi9R5iR9pgzaRQmjcKk" +
       "zmpdKdC+kWrZTLfOl8OckaoNGRViZJF/EEMypYw9zADXGUaoZfbaeWdY7cL8" +
       "asUqC5Z4z/nR3Xtvan6kgjTFSZOiDaI6MijBYJI4AEozCWpaK5NJmoyTaRps" +
       "9iA1FUlVttg73WIpaU1iWdh+BxaszBrU5HO6WME+wtrMrMx0M7+8FDco+7+q" +
       "lCqlYa2z3LWKFa7GelhgnQKKmSkJ7M7uUjmqaElGFgR75NfY/hkQgK41GcpG" +
       "9PxUlZoEFaRFmIgqaenoIJielgbRKh0M0GRkbslBEWtDkkelNB1GiwzIDYgm" +
       "kJrCgcAujMwMivGRYJfmBnbJsz8n+5fvvEVbo4VJCHROUllF/euhU1ug0zqa" +
       "oiaFcyA6NiyL7ZFmPb4jTAgIzwwIC5kfffHU1Z1tR54WMvOKyKxNbKIyG5b3" +
       "Jaa+ML+748oKVKPW0C0FN9+3cn7KBuyWrpwBDDMrPyI2RpzGI+ue+sJtD9ET" +
       "YVLXS6plXc1mwI6myXrGUFRqXks1akqMJnvJFKolu3l7L6mB95iiUVG7NpWy" +
       "KOsllSqvqtb5/wBRCoZAiOrgXdFSuvNuSGyEv+cMQkgNPKQBnvOI+OO/jIxG" +
       "R/QMjUqypCmaHh0wdVy/FQXGSQC2I9EEWP1o1NKzJphgVDfTUQnsYITaDQlT" +
       "SaZpdHDo2pWakoFFrDclzUrpZgbZAUZZxQUiaHTG/3e6HK5++ngoBBszP0gL" +
       "KpyoNbqapOawvDu7qufUoeFnhcnhMbFxY+QK0CAiNIhwDSJCg8hkGpBQiE88" +
       "AzUR1gB7OQqsALTc0DF443UbdyyuADM0xithI1B0sc89dbvU4fD9sHy4pXHL" +
       "ojcvejJMKmOkRZJZVlLR26w008Bj8qh91BsS4Lhc/7HQ4z/Q8Zm6TJNAX6X8" +
       "iD1KrT5GTaxnZIZnBMe74TmOlvYtRfUnR+4dv33o1gvDJOx3GThlFbAddh9A" +
       "os8TenuQKoqN27T9nfcP79mqu6Th80GO6yzoiWtYHDSNIDzD8rKF0qPDj29t" +
       "57BPAVJnEhxC4Mu24Bw+Tupy+B3XUgsLRiuRVGxyMK5jI6Y+7tZwm52GxUxh" +
       "vmhCAQW5a/jUoHH/K8+/ewlH0vEiTR73P0hZl4e5cLAWzlHTXItcb1IKcm/c" +
       "O/CNe05u38DNESSWFJuwHctuYCzYHUDwK0/f/Opbb+47HnZNmIHrziYgAsrx" +
       "tcz4CP5C8PwbH2QbrBCs09JtU9/CPPcZOPO5rm7AgipQAxpH+/UamKGSUqSE" +
       "SvH8/Ktp6UWP/nlns9huFWoca+mcfAC3/pxV5LZnb/p7Gx8mJKMXdvFzxQS1" +
       "T3dHXmma0mbUI3f7sdZvHpXuBycBxGwpWyjnWsLxIHwDL+NYXMjLSwNtl2Ox" +
       "1PLauP8YeaKlYfnu4+81Dr33xCmurT/c8u57n2R0CSsSuwCT9RO78HE/ts4y" +
       "sJydAx1mB4lqjWSNwGCXHum/oVk9chqmjcO0MtCytdYE3sz5TMmWrqp57edP" +
       "ztr4QgUJryZ1qi4lV0v8wJEpYOnUGgHKzRmfvlroMV4LRTPHgxQgVFCBu7Cg" +
       "+P72ZAzGd2TLY7N/uHz/xJvcLA0xxjzvgOfysgOLTmG2+HpBLg8W/6suA5Z/" +
       "TJO0lopleBy2b9vuieTaBy4SEUeLPz7ogfD34K8+fC5y76+fKeJ8pjDduECl" +
       "Y1T1zFmDU/o8RR8P81y2emPqrt/9uD296kycBNa1TeIG8P8FsIhlpUk/qMrR" +
       "bX+au37FyMYz4PsFATiDQ36v78Az154r7wrzmFZQfUEs7O/U5QUWJjUpBO8a" +
       "LhNrGvlpWZI3gBbc2DZ4Om0D6AyeFkHM3Jqw6Ml35TZRV6ZrGTIYKtP2eSw+" +
       "y0hDGiI+XZbUflgNl5wDdz5+JDCej4h4njdcgcU6YdbLP+Z5w4pVBq/v88PT" +
       "Cs8l9hovOXN4SnUtAwEt05bGYiMj9QCPs+cOOm2lAjgRprlYSWcBq4XYFoXn" +
       "KnvBV5XBqoCYgAAMU2fAcTSZ84PYWGbMAFAhO7608egowCOpZyIQjWciIp6F" +
       "07leMgFJrttYGdi3YKGD95FNCh48392Z6ryCqcQ0CYjCgJX88nwPjLOwBzMc" +
       "e43beMUnsVezEOpSXcuAs71M2x1YbMPtxeQED/580T+S9WAWYBowlQxEb2P2" +
       "DffigY3yjvaBt4UvOadIByE388HoXUMvb3qOs24t0nye6zwUD+7AE3M2YxFB" +
       "f9ZRJl/k1ye6teWt0fveOSj0CV7PA8J0x+6vfhTZuVv4OZHDWFKQRvD2EXmM" +
       "gHaLys3Ce6z+4+GtP3lw6/awjXYvI1UQd5is4EhAaO3HUGh6zR1NP727pWI1" +
       "+M9eUpvVlJuztDfp9yE1VjbhAdVNergexdYZg15GQsucaIQb+pfPgqGjyyKf" +
       "gEe3rVU/c0Mv1TVgzBVckQr8N47FXViM8/G/Xcbu92FxPyN13O6HJDWbp+nO" +
       "4lwxxmVsZsLg3e3EcZw4W6R9PjwnbDBOnDmOpboGwAlzRcIBCL9fBsIfYHEA" +
       "XJ0HQn9mO88F/JYiLPqG+qd+Zn3nD4+Ig1qMaQK5tAf318qvZ5562zlDX8sv" +
       "cS6q0mEj5CAFN7rP/ZeJHdxuvHPpZt4vODmjszU00snS0mTnwW/iu0uev3Vi" +
       "yW/4HahWsSA6BvYsksf09HnvwFsnjjW2HuJReCWSsM0V/gRwYX7Xl7bl6Ddh" +
       "8Vju458VP+nN990e+PcNN7x+6MXLX9r/9T3jwlTK+IJAvzkfrFUT2377j4Lb" +
       "Kc5fVcQ9BPrHowfum9u94gTv76ZYsHd7rjB/Bzvg9r34oczfwourfxEmNXHS" +
       "LNvfE/jyBymLA8aW85EhRhp97f58uEj+duXvFfOD/skzbTC54/UOlcznCaaJ" +
       "/QsRTgJHi4d7nAUuAF+VUjRJ5f0ijFSrVEuzES6803aC+LOLkQqwHHx93MgF" +
       "CcWxlOnu1aBb1TWKVuG0icSkokfyXzegMVdgLpwbhf58Mk9cz9Upw1WvlGl7" +
       "DYuXYLUy6iWWUUb8jVLc7aH5kHud3+txtQfPgouYhW3tMNk8Mab4PSMXUbJr" +
       "mfD9TmEAWD5XfNm87d0yQJ7E4m1GpgKZOvlrJ/l4p8e+ArZWk9B1lUraZGD/" +
       "/n8Bdo6RhZOl1zEXNKfgU5/4PCUfmmiqnT1x/cuCep1PSA0QC6eyquo9p573" +
       "asOkKYWD1CBOrcF/PmBkdok7JBzPhHuL/KeQ/xBu5EF5sHP+65ELgc+sc+Vg" +
       "KPHiFamAQw4i+FppOOc2OvkXCR9SOWE7viQY36uZk+2VJ8e1xOcH+JdYJ4LI" +
       "im+xw/Lhiev6bzn1yQdERlpWpS38glgPHk3kvW2P5o3hg6M5Y1Wv6Tg99eEp" +
       "S534w5cR9+rGLQYMkWeP5wZStFZ7PlP76r7lT/xyR/UxcC8bSEgCatxQyPs5" +
       "I2uS1g2xwksB8D7PHXd1fGvzis7UX17n+cVCfxqUH5aP77/xxV1z9rWFSX0v" +
       "qYLrCc1xh3TNZm0dlcfMOGlUrJ4cqAijAA/7bhxT0XYlzOlwXGw4G/O1+KmC" +
       "kcWFt6jCDzx1qj5OzVV6VkvacUi9W+OEHr4sWdYwAh3cGk9wskcwhYgCK4Zj" +
       "fYbh5Pmr0gY/0nuL0wba9Wz+im9z/gNzpOMrpSEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
