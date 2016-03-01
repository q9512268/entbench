package edu.umd.cs.findbugs.filter;
public class MethodMatcher extends edu.umd.cs.findbugs.filter.MemberMatcher implements edu.umd.cs.findbugs.filter.Matcher {
    public MethodMatcher(java.lang.String name) { super(name); }
    public MethodMatcher(java.lang.String name, java.lang.String role) { super(
                                                                           name,
                                                                           null,
                                                                           role);
    }
    public MethodMatcher(java.lang.String name, java.lang.String params,
                         java.lang.String returns) { super(name, edu.umd.cs.findbugs.filter.SignatureUtil.
                                                             createMethodSignature(
                                                               params,
                                                               returns));
    }
    public MethodMatcher(java.lang.String name, java.lang.String params,
                         java.lang.String returns,
                         java.lang.String role) {
        super(
          name,
          edu.umd.cs.findbugs.filter.SignatureUtil.
            createMethodSignature(
              params,
              returns),
          role);
    }
    @java.lang.Override
    public boolean match(edu.umd.cs.findbugs.BugInstance bugInstance) {
        edu.umd.cs.findbugs.MethodAnnotation methodAnnotation =
          null;
        if (role ==
              null ||
              "".
              equals(
                role)) {
            methodAnnotation =
              bugInstance.
                getPrimaryMethod(
                  );
        }
        else {
            for (edu.umd.cs.findbugs.BugAnnotation a
                  :
                  bugInstance.
                   getAnnotations(
                     )) {
                if (a instanceof edu.umd.cs.findbugs.MethodAnnotation &&
                      role.
                      equals(
                        a.
                          getDescription(
                            ))) {
                    methodAnnotation =
                      (edu.umd.cs.findbugs.MethodAnnotation)
                        a;
                    break;
                }
            }
        }
        if (methodAnnotation ==
              null) {
            return false;
        }
        if (!name.
              match(
                methodAnnotation.
                  getMethodName(
                    ))) {
            return false;
        }
        if (signature !=
              null &&
              !signature.
              match(
                methodAnnotation.
                  getMethodSignature(
                    ))) {
            return false;
        }
        return true;
    }
    @java.lang.Override
    public java.lang.String toString() { return "Method(" +
                                         super.
                                           toString(
                                             ) +
                                         ")"; }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean disabled) throws java.io.IOException {
        edu.umd.cs.findbugs.xml.XMLAttributeList attributes =
          new edu.umd.cs.findbugs.xml.XMLAttributeList(
          ).
          addAttribute(
            "name",
            name.
              getSpec(
                ));
        if (signature !=
              null &&
              signature.
              getSpec(
                ) !=
              null) {
            java.lang.StringBuilder paramsBuilder =
              new java.lang.StringBuilder(
              );
            edu.umd.cs.findbugs.ba.SignatureConverter converter =
              new edu.umd.cs.findbugs.ba.SignatureConverter(
              signature.
                getSpec(
                  ));
            converter.
              skip(
                );
            while (converter.
                     getFirst(
                       ) !=
                     ')') {
                if (paramsBuilder.
                      length(
                        ) >
                      1) {
                    paramsBuilder.
                      append(
                        ", ");
                }
                paramsBuilder.
                  append(
                    converter.
                      parseNext(
                        ));
            }
            converter.
              skip(
                );
            java.lang.String params =
              paramsBuilder.
              toString(
                );
            java.lang.String returns =
              converter.
              parseNext(
                );
            attributes.
              addAttribute(
                "params",
                params);
            attributes.
              addAttribute(
                "returns",
                returns);
        }
        attributes.
          addOptionalAttribute(
            "role",
            role);
        if (disabled) {
            attributes.
              addAttribute(
                "disabled",
                "true");
        }
        xmlOutput.
          openCloseTag(
            "Method",
            attributes);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6CawrV3Xz31/zSfJ/fiBJf8nKDyUxvLE9Ho+tzxJ77BmP" +
       "PWOPPYvtaeEznsUez77ZY9NQiNSCipRSGiitIFIl6ILCIlpEJUSVqmoBgVCp" +
       "6CoVUFWptBSJqCqtSlt6Z/ze83vvLyiQWprr8b3nnHv2cxc/913odBhAOc+1" +
       "VlPLjXa1JNqdW+hutPK0cLdNo6wchJqKW3IY8qDvmvLIpy58/wfvnV3cgc5I" +
       "0N2y47iRHBmuEw600LUWmkpDF7a9TUuzwwi6SM/lhQzHkWHBtBFGV2noZYdQ" +
       "I+gKvc8CDFiAAQtwxgJc20IBpDs0J7bxFEN2otCH3g6doKEznpKyF0EPHyXi" +
       "yYFs75FhMwkAhXPpbxEIlSEnAfTQgewbma8T+P05+Jlff8vFT5+ELkjQBcPh" +
       "UnYUwEQEJpGg223NnmhBWFNVTZWguxxNUzktMGTLWGd8S9Cl0Jg6chQH2oGS" +
       "0s7Y04Jszq3mbldS2YJYidzgQDzd0Cx1/9dp3ZKnQNZ7trJuJCTSfiDgeQMw" +
       "Fuiyou2jnDINR42gB49jHMh4pQMAAOpZW4tm7sFUpxwZdECXNrazZGcKc1Fg" +
       "OFMAetqNwSwRdPmmRFNde7JiylPtWgTddxyO3QwBqNsyRaQoEfSK42AZJWCl" +
       "y8esdMg+3+2+/um3OS1nJ+NZ1RQr5f8cQHrgGNJA07VAcxRtg3j74/QH5Hs+" +
       "/+4dCALArzgGvIH57M+/8MRrH3j+ixuYn74BTG8y15TomvKRyZ1feyX+WPVk" +
       "ysY5zw2N1PhHJM/cn90buZp4IPLuOaCYDu7uDz4/+LPxOz6mfWcHOk9BZxTX" +
       "im3gR3cpru0ZlhaQmqMFcqSpFHSb5qh4Nk5BZ8E7bTjapren66EWUdApK+s6" +
       "42a/gYp0QCJV0Vnwbji6u//uydEse088CILOggfCwfMgtPlk3xF0DZ65tgbL" +
       "iuwYjguzgZvKH8KaE02AbmewDpxpEk9DOAwUOHMdTY3h2FZhJdwOAiaAA8FM" +
       "5nGMHCkzLdhNob3//ymSVMqLyxMngAFeeTz8LRA5LddSteCa8kxcb77wiWtf" +
       "3jkIhz39RNBrwIy7YMZdJdzdn3F3M+PukRmhEyeyiV6ezryxMrCRCaId5MHb" +
       "H+Pe3H7rux85CdzLW54CCj4FQOGbp2N8mx+oLAsqwEmh5z+4fKf4C/kdaOdo" +
       "Xk25BV3nU3Q2zYYHWe/K8Xi6Ed0L7/r29z/5gSfdbWQdSdR7AX89ZhqwjxzX" +
       "a+AqQGWBtiX/+EPyZ659/skrO9ApkAVA5otk4KkgqTxwfI4jgXt1PwmmspwG" +
       "AutuYMtWOrSfuc5Hs8Bdbnsyg9+Zvd8FdPyy1JPvA8/De66dfaejd3tp+/KN" +
       "g6RGOyZFlmTfwHkf/puv/jOSqXs/H184VOE4Lbp6KAekxC5k0X7X1gf4QNMA" +
       "3N9/kP2193/3XT+bOQCAeNWNJryStjiIfWBCoOZf/KL/t9/8xke+vnPgNCci" +
       "UATjiWUoyYGQaT90/hZCgtleveUH5BALBFnqNVcEx3ZVQzfkiaWlXvrfFx4t" +
       "fOZfn7648QML9Oy70Wt/NIFt/0/VoXd8+S3/8UBG5oSS1rCtzrZgm8R495Zy" +
       "LQjkVcpH8s6/uP83viB/GKRYkNZCY61lmerERgeZ5K8Aa40MMy1Xu5tylVkT" +
       "zoYfz9rdVBMZEpSNIWnzYHg4Ko4G3qFFyDXlvV//3h3i9/7ohUyMo6uYw07A" +
       "yN7Vjd+lzUMJIH/v8RTQksMZgCs93/25i9bzPwAUJUBRAaU77AUgAyVHXGYP" +
       "+vTZv/vjP7nnrV87Ce0Q0HnLlVVCzqIPug24vRbOQPJKvDc9sbH68hxoLmai" +
       "QtcJn3Vcvj4uHt1zmUdvHBdp+3DaPHq9t90M9Zj6dzIOdtKf+azJSD9xCyPV" +
       "0+ZqNlRKm9dvuMd+IkEf2+P2sRcv6M1Qj4lwMuPg5FbQrbSdW0jLpA2xlZZ8" +
       "KaR93R7Lr3vx0t4M9ZgIpzY17Ji0W5HFW4g8Spv+VuTBixF5A3vfRtkg1B67" +
       "eQkl0uX0tgrd9189a/LUP/zndeGcFc8brCKP4Uvwcx+6jL/xOxn+toql2A8k" +
       "168vwNZji1v8mP3vO4+c+dMd6KwEXVT29jWibMVpbZDAWj7c3+yAvc+R8aPr" +
       "8s0i9OpBlX7l8Qp6aNrj9XO7rgHvKXT6fv5wyfwh+JwAz/+mT6rutCP9Bkzg" +
       "e0vShw7WpJ6XnAAF6XRxF9vNTD/ZeFbWXkmbn9nGxGtA5QqzDRXAAOso2com" +
       "Br/unVvKlX3qIthgAZtcmVvYgUdd3LqK8qNc5c0bqGwhdue2PtAu2My85x/f" +
       "+5VfedU3gf3a0OlFqltgtkNFpBun+7tfeu7997/smW+9Jyu6oNpwj03+7YmU" +
       "qn0r6dImW1Mb+2JdTsXi3DhQNFoOIyark5qaSnZrt2UDwwbLicXe5gV+8tI3" +
       "zQ99++ObjclxHz0GrL37mV/+4e7Tz+wc2g6+6rod2WGczZYwY/qOPQ0H0MO3" +
       "miXDIP7pk09+7neffNeGq0tHNzdNsHf/+F/9z1d2P/itL91gRX3KAtb4sQ0b" +
       "3fHnrVJI1fY/dH4sF5dCgjjx2q6GcK8m1dZjsl8Em/sSSXJd3qwp417bVkOm" +
       "2xi26wmmIWyxFCCqNNKH7DwqkCvKiokhLdeoNj+IBFEYdF2Dm0YWMYnGpuJx" +
       "XruC1riBgHAdv7/wJ31PtnALralRPpebFCcLtYiE0048a/ewEKkgiK734IWN" +
       "OGXKsBG+28a7A8luLuXCMsrLJFpnjJVcFhl7pYZdhW+VzDZbWMMlQSVLPXPs" +
       "zpmWR4asZa9kqooXxv3CoD127VAweXkybJgubzSIqeDG8jhp8ypZpNZEL0Q8" +
       "btYJaDy36DcHY7xqzkxrPmjPvVkHIbVCAW/gq3bNVwaNqWMqSA5VSq4viYVx" +
       "hSJGuWkdgzshRfIdBCzPPJwoC3Wfp+YSX2jOhFCcOUWDCxpiUSUJqUD4kkfM" +
       "y+7EqQtho1imhAqxqmBDHVmjxea0IVaaCqd280k4XKsWQYsV1aXMwEdUK7Zk" +
       "Oezn+kG73rfC9bo2pwctBo3IcZehJm1/UHAFHItjV/K1soqXeqsC7jPkwDTa" +
       "ZHGEd0ip6XqzyrKGJqYrNoiW6paYvIF1OSM213U2SXoBVRH0YhdeLgc9v8XR" +
       "RaPBURgzb9THbWYm4LNuIlveRCiZMtmhuqQ3xZqE3/E6Pt/wh5OgI4yFgtH1" +
       "prCbgDVXreBX5gV1NG6qfX7CW54VS6FIK666gj3BEYfmWGoji5XhmhhDoE26" +
       "TtaUCePVBjm0jAtzzpOnHjFk89IwWYyxWr/e7xR6wlybS4Hi5nFOokykNhDV" +
       "DkmV2KkWuctpexKUqJpNVQqEIXfihmBq1ljyGg2Eq6+VqTXFfRtUDWFgSOhS" +
       "n1tMvbPmS2CzkazButJ2YdUtYv0p3m+wOOcHK7YS9skgoTRgxaHHGbVefUiH" +
       "fi6o5WHY8Si8WWOZSosm67lKLNJRuerZI0ta4ku/1mV0Nj+zCK/LJkUNjidG" +
       "MC4yVFGertRmVC/lVGrtd8Ml4Xh8Pe6PNcnpaG2jRzOlMBeNRliAdHRvZnb5" +
       "vDn1JDGXF3IEOQ86CjOQR3ZL5OZeOHBdTxWEFTJIVBXjOLEySIZdI3JyUrdj" +
       "BG1N8Ecrvx/rcF8Q2xTV9H2XWAyEhW8Pq42xwVZ6xXy/bwQzSkSWUZ1OSsUq" +
       "OfaaA1YQ5qaReIYvtermUkUnimG2WobbjQdcvaN0hiV2mLRoC2cVdTjH58D9" +
       "B02uiDTFaW22dPOhUg3MqlGZTgvL5SwasZUob8wthyVAAloti3U41zH5Xtcq" +
       "dIUGY7dAhlGJarm7kH0FzzP1vALPW8uhOl035nZLwm212KBCdbk2MdPEa5N1" +
       "f6Qm0rA+i7v9YNCIfSQi6QTLlVqexBFLutirNOoDpe43aCX0ehYacoxjVtpe" +
       "1fO9KOxhcOxxNc9AKZsbykWPpMTicNnrI2VugOb7gVto9Ed0sLTa7EjBcSl2" +
       "VwbZ4saLUd0VO9a80OTRxJbKZbLvi+7YQVtGV2amcJG3UXY+W4i5KiMYeCwL" +
       "tWi1atHUxK2h81pYssuIVMHxiIxYhJ6V1gzL56yYCQ2PlmzOprQ2Y6zXcamt" +
       "szyBFkTai9X5WsgVFEwdggRgNpd9EQ2ZITzIl+OysjYnEmfh00GvbEsdwWl6" +
       "bo6Ruzbtl3IlplolSHieHyEkNaxHVVzr+orcGyxG7cKiRM9quQZftoVKZzRT" +
       "Y5LvaxqsdRdIueevI74fu9VolOuHJsoWzbbB80m9O/HiuBqbRK+hsWtnmads" +
       "egBLibMcUuhYKE4YLcGrlGjXG4LOwvSsimEldu1Fpa7ELitLvxsVW11fVwmJ" +
       "cnCl0B5zTUSUy3CzIQur5sLtanms2qqx6NCkQlE03FYhgF2xjGJYrtokS33F" +
       "X5O8IjNFEZ/M193iEkxRLsMoM+SN8XRctQqqJuOGuMwl5WGlyAPdaP25rhtR" +
       "W63k2us8Kfabq1AWGcFDlVqeao3YDpGnxITvrJZjkZjFvIBUesIkN5ryskvN" +
       "m5NysTlWRGuu+MqUZfNrnUDJ7kIvcEi1zIxop5kos3ARJGyeE2Sn0ggV0Zfr" +
       "cK0NFyLXHnJMTa2yzDwI5ULbofutJtVhgv5EnFeBVrsqhdG9bsOyJtVqRR6h" +
       "9WqJMYc11heJQkdtzivadF7QGsVC3a/r7bA4CSJ12CpWcHdM0iDKm2t0UZuD" +
       "whyBwsnZDYWLGNjh6/O1Xi11ByjmlMg21jRZbDDsEWXEdepuSZ9KLWLi9IrL" +
       "RGxXiCm6dii2XLX7OUUlK+1eNddeFuRctWUqMagtk4Wpq2OBHwmCmO8RVH7U" +
       "KuCGQZZnTJTUzXbc95bRBHdmdTk3ZXo1vzRUCwWGlpPCoGCVq4Trz3JmP2ii" +
       "I81biiNCpNqiMi0hvaFfitHA7ftJyExpdNAbwCufCpIFKE9Tt1vOR52qMDe0" +
       "EqVUVtw4yFdZVFMWMVzyBR4u5aJmvVoWiqsqskRaS1uFKzlstFypOVjw622/" +
       "KJdDsCkYF/hCWNdxesSU6S65iMVRDlZNFo4tB1O6k8CX0WVgDzvYgM3RFXFG" +
       "zMQF4axChI4XQaWAYWgBZepitWlHrDMqczwmVeF+oJZXQmu5XjEo6po63ZsF" +
       "FuWIGLH0x/ZM6YUzmzb4egFZ90RphNq8IfOFuZ8L6YRo68SKWBaCGctOJTqq" +
       "8QTO2kYi6tIwH6FUe4L1SEZqr0R/QCfqzGgpwqQj5IxlrOTRXMhNWxNtaooS" +
       "l29o3V5fp6t9poX2nOKUr9AWVpzVqE7NhtUm2o4wZA2cYK7GxMjjRV/Q+GVn" +
       "UcG4ZkOg1k6FWtSYKlxpErbSp3WFwBaKWW5zGNsaMGyt1wtdRc7xnXzd9GO7" +
       "kdeqmtYcU6VGlcyVGl6VJRd64uY0a910sFkwbKMIwuqGwYYk1S/1Gqs6MpHF" +
       "Ymkwreprc13VGcdzS82WyrpzgidVsWiZnuTosdFQqkKsdZFypHt6iwyB6etm" +
       "FaX8YYHpFSd9xNQWqiWN1Wp1Xl+kVVxFZqQz6nEkLpa4Qd/xGnzct9GuF/fD" +
       "NSahLQmDpZrE42LdyOlLf1Vwxbm0sh2QgaWy21w7AzkhyWRsiHintbDEOcZO" +
       "yyxj0YTabaEVI3DlBYMNJsN2fqXFsypaopDahG2EqjBSNRzLi1RBLvUrqxJn" +
       "geG22PO15qJqjrDJcDKGidmazeku37OYTrPkGDMsxrRqb1Xlax3gBWCkYRZx" +
       "XBG7M6I2W89J02HYVqEBbJ04faskBZav5xpDtcMUeiPFI3FnsW4sImuiMEzA" +
       "Or6/GDp1H1SMimSri9ownAUrKRL1YTNa60JnueLbs2E8E72k0miVynmRtN0F" +
       "Qk9XC4klG8q6NBdapTZplGs1O+jqLX+2XhNcKU+tm95gbTmVrq0UJMnoN11E" +
       "T1TJwAd6UllWZuMIHhQIAu1LiR/3W+VFks+XsbzfleoTQsvxLS6kF0W+5xVm" +
       "YwTjW+i640S9XBlVWXZeCr266I/anNxf4UknjFmE6hpJNJAtSybEsIxNK7ni" +
       "umCYa3uS9JkYIUurdpeLwxrd0DlRiqooQgZsK1zoPQzxZqrmdKpl3A6GbB3n" +
       "lgiPsfREK+XBanfRL6qlAHV1g6yjLqoTrUGRbXhJGQ1MFsFaDVRqEm2MSDRi" +
       "XonqDQyWtZaOmKpTTobLMunG5kzwu+PhSsuPxL7GID0/byf58dJeU5HWcEH9" +
       "wfBEE5rkyBGrQaUMF0rdWpUP81Hs5y2HdosrFGnHeh3p+yzZnS716XwxLwta" +
       "z+BX9eJUg+fNEdZgut5AoHRyvuIWuRHLtVYcBefqeo5eJnAFhyNiVHCoCVhA" +
       "vSHd2r39xe2u78oODQ7uNX+M44LkRsdg2ecMdOwu7Pgx2H1Hz6EfudUN0eZu" +
       "KN1U33+zm81sQ/2Rp555Vu19tLCzd0i2iqDbItd7naUtNOvYmdfjNz882NxI" +
       "bQ+evvDUv1zm3zh764u4MXrwGJ/HSf4e89yXyFcr79uBTh4cQ1135XwU6erR" +
       "w6fzgRbFgcMfOYK6/8AId+8fYxb3jFC8xTHmcYc5kTnMxk2OnUEeuz548EZm" +
       "q8fTfaYzGh+4xTnmb6bNr0bQaTs1cgYSHfK6JILOTlzX0mRn65HvO+qRtx94" +
       "5AFbl7YHUr2FFgSGqt3CiW9yJvz0gTIvpZ2XwUPvKZN+aZR5WBEfu8XYc2nz" +
       "0Qg6F7mbS5osTrcK+e2bKiTt/q2fRPTsOPxN4Onvid5/aUTfu9LYN9jDN/Kj" +
       "xLZ2RwzdiyMvzpziQxmpz97aJTd3YYa7S/XAKlzz0kjN8D6XNp8GWlwGRqQB" +
       "wjfytlML11C3mv39l1CzgPodRy6705u7+677Q83mTyDKJ569cO7eZ4W/zu57" +
       "D/6ocRsNndNjyzp8Cn3o/YwXaPomv9+2OZP2sq8vRtDlmyfYKP3XTPqSsfyF" +
       "DcqXgSZvgALUt/96GPqrEXR+Cx1BO8qR4a+BMN4bjqCToD08+HXQBQbT17/0" +
       "9q14638MpGfM+1XhxKHEvue+meku/ajT0AOUwxfJaTHI/gq1n7jjzZ+hrimf" +
       "fLbdfdsL5Y9uLrIVS16vUyrnaOjs5k79IPk/fFNq+7TOtB77wZ2fuu3R/UJ1" +
       "54bhbSgd4u3BG98aN20vyu5513947x+8/nee/UZ21v5/ros966MmAAA=");
}
