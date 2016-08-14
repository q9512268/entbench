package org.apache.batik.script;
public class InterpreterPool {
    public static final java.lang.String BIND_NAME_DOCUMENT = "document";
    protected static java.util.Map defaultFactories = new java.util.HashMap(
      7);
    protected java.util.Map factories = new java.util.HashMap(7);
    static { java.util.Iterator iter = org.apache.batik.util.Service.providers(
                                                                       org.apache.batik.script.InterpreterFactory.class);
             while (iter.hasNext()) { org.apache.batik.script.InterpreterFactory factory =
                                        null;
                                      factory = (org.apache.batik.script.InterpreterFactory)
                                                  iter.
                                                  next(
                                                    );
                                      java.lang.String[] mimeTypes =
                                        factory.
                                        getMimeTypes(
                                          );
                                      for (int i = 0; i <
                                                        mimeTypes.
                                                          length;
                                           i++) { defaultFactories.
                                                    put(
                                                      mimeTypes[i],
                                                      factory);
                                      } } }
    public InterpreterPool() { super();
                               factories.putAll(defaultFactories);
    }
    public org.apache.batik.script.Interpreter createInterpreter(org.w3c.dom.Document document,
                                                                 java.lang.String language) {
        org.apache.batik.script.InterpreterFactory factory =
          (org.apache.batik.script.InterpreterFactory)
            factories.
            get(
              language);
        if (factory ==
              null)
            return null;
        org.apache.batik.script.Interpreter interpreter =
          null;
        org.apache.batik.dom.svg.SVGOMDocument svgDoc =
          (org.apache.batik.dom.svg.SVGOMDocument)
            document;
        try {
            java.net.URL url =
              new java.net.URL(
              svgDoc.
                getDocumentURI(
                  ));
            interpreter =
              factory.
                createInterpreter(
                  url,
                  svgDoc.
                    isSVG12(
                      ));
        }
        catch (java.net.MalformedURLException e) {
            
        }
        if (interpreter ==
              null)
            return null;
        if (document !=
              null)
            interpreter.
              bindObject(
                BIND_NAME_DOCUMENT,
                document);
        return interpreter;
    }
    public void putInterpreterFactory(java.lang.String language,
                                      org.apache.batik.script.InterpreterFactory factory) {
        factories.
          put(
            language,
            factory);
    }
    public void removeInterpreterFactory(java.lang.String language) {
        factories.
          remove(
            language);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZDWwcxRWeOyeO7fg/cWJC4iSOQ5qE3PHbkDr8OI5DnJ4d" +
       "N05c9QK57O3N2Rvv7S67s/bZNBQQFaESEdDwK0ilKjRpGkhUQVtKQUG0BASt" +
       "xE9LKQWiUqlQiiBC0Kq0pe/N7N7+3J1D1GJpx+OZN2/mvXnve++Nj7xPplsm" +
       "aaMai7EJg1qxHo0NSKZFM92qZFlbYSwl310hfbTjnf41UVKZJPUjktUnSxbd" +
       "oFA1YyXJAkWzmKTJ1OqnNIMrBkxqUXNMYoquJUmLYvXmDFWRFdanZygSDElm" +
       "gjRJjJlK2ma012HAyIIEnCTOTxLvCk93JkitrBsTHnmrj7zbN4OUOW8vi5HG" +
       "xC5pTIrbTFHjCcVinXmTrDR0dWJY1VmM5llsl3qxo4JNiYuLVNB+rOGTT28b" +
       "aeQqmCVpms64eNYWaunqGM0kSIM32qPSnHUNuY5UJMhMHzEjHQl30zhsGodN" +
       "XWk9Kjh9HdXsXLfOxWEup0pDxgMxsjjIxJBMKeewGeBnBg5VzJGdLwZpFxWk" +
       "FVIWiXjnyvi+u3c0/riCNCRJg6IN4nFkOASDTZKgUJpLU9PqymRoJkmaNLjs" +
       "QWoqkqpMOjfdbCnDmsRsuH5XLThoG9Tke3q6gnsE2UxbZrpZEC/LDcr5a3pW" +
       "lYZB1jmerELCDTgOAtYocDAzK4HdOUumjSpahpGF4RUFGTu+CgSwdEaOshG9" +
       "sNU0TYIB0ixMRJW04fggmJ42DKTTdTBAk5F5ZZmirg1JHpWGaQotMkQ3IKaA" +
       "qporApcw0hIm45zgluaFbsl3P+/3r917rbZRi5IInDlDZRXPPxMWtYUWbaFZ" +
       "alLwA7GwdkXiLmnOE3uihABxS4hY0Pz0m6euOLft+LOC5uwSNJvTu6jMUvKB" +
       "dP2L87uXr6nAY1QZuqXg5Qck51424Mx05g1AmDkFjjgZcyePb3nmG9cfpu9F" +
       "SU0vqZR11c6BHTXJes5QVGpeSTVqSoxmekk11TLdfL6XzIB+QtGoGN2czVqU" +
       "9ZJpKh+q1PnfoKIssEAV1UBf0bK62zckNsL7eYMQMgM+UgvfKiJ++G9GkvER" +
       "PUfjkixpiqbHB0wd5bfigDhp0O1IPA1WPxq3dNsEE4zr5nBcAjsYoe6EbCoG" +
       "i/eilRomhXZA19UY2pjxhXLPo2yzxiMRUPv8sNOr4C8bdTVDzZS8z17Xc+rh" +
       "1PPCoNAJHK0wsgw2jIkNY3zDmNgwFtqQRCJ8n9m4sbhauJhRcHHA2Nrlg1dv" +
       "2rmnvQJsyhifBlpF0vZArOn2cMAF75R8tLlucvGb5z8dJdMSpFmSmS2pGDq6" +
       "zGEAJXnU8dvaNEQhLxgs8gUDjGKmLtMMYFG5oOBwqdLHqInjjMz2cXBDFTpl" +
       "vHygKHl+cvye8RuGvnVelESD+I9bTgfowuUDiNoFdO4I+30pvg03v/PJ0bt2" +
       "6x4CBAKKGweLVqIM7WFLCKsnJa9YJD2aemJ3B1d7NSA0k8CjAPzawnsEAKbT" +
       "BWuUpQoEzupmTlJxytVxDRsx9XFvhJtoE+/PBrOYiR43D74+xwX5b5ydY2A7" +
       "V5g02llICh4MLh00Hvj9b969kKvbjRsNvoA/SFmnD6uQWTNHpSbPbLealALd" +
       "G/cMfPfO92/ezm0WKJaU2rAD227AKLhCUPO3n73mtbfePPBK1LNzBsHaTkPO" +
       "ky8IieOkZgohYbdzvPMA1qmACGg1Hds0sE8lq0hplaJj/ath6fmP/m1vo7AD" +
       "FUZcMzr39Ay88bPWkeuf3/H3Ns4mImOs9XTmkQkAn+Vx7jJNaQLPkb/hpQX3" +
       "npAegFAA8Gspk5QjKuE6IPzSLubyn8fbi0Jzq7FZavmNP+hfvpwoJd/2yod1" +
       "Qx8+eYqfNphU+e+6TzI6hXlhc04e2M8Ng9NGyRoBuouO91/VqB7/FDgmgaMM" +
       "QGttNgEa8wHLcKinz/jDU0/P2fliBYluIDWqLmU2SNzJSDVYN7VGAFXzxuVX" +
       "iMsdr4KmkYtKioQvGkAFLyx9dT05g3FlT/5s7iNrD+5/k1uZIXiczddXINAH" +
       "UJWn5p5jH3559W8P3n7XuAjuy8ujWWhd6z83q+kb//SPIpVzHCuReITWJ+NH" +
       "7p/Xfdl7fL0HKLi6I18cnACUvbUXHM59HG2v/FWUzEiSRtlJhYck1UY3TUL6" +
       "Z7n5MaTLgflgKifyls4CYM4Pg5lv2zCUeUER+kiN/boQerXiFV4O3wWOY18Q" +
       "Rq8I4EFVRpftHNwSDvXyxct4uwKbVeIisRsD7LB46s3gMIomqSEMmTvFViD6" +
       "ut7+9an+rr6e1PrN3dv6evq38uWtUANxC0OlxER+K1AV20uw2SQ26ixrw92F" +
       "g7TgaCd8q52DrC6SmfDOUGlJo4xUG6bO4GZoBof7Q0LOnoI3SJKhWclWmfBA" +
       "BfzWJAs8D8DYPWinLbZFGucJdEq+alnjnI41H7ULF2grQevLtPc+/vNkclmj" +
       "LIjbSzEOZtiHDlbJr+ee+bNYcFaJBYKu5VD81qFXd73AI1UVpi9bXaPyJSeQ" +
       "5vjCZGNBMfWohyb4TjqKOSky1av+x1wSlkH5qOTAIuJblRzNYPmKMji56hfK" +
       "nwN0ALy8S/vRqNr1wSU/uFSodXEZ3PLoH/vayRcfmDx6RMRFVC8jK8sV3MVV" +
       "PqZJS6dI9TwD+fjKrxx/9+2hq6NOJKvHJp13Ha3Og3IIHDi4qwD5kUIiPDto" +
       "JoLz+lsafnFbc8UGyMF6SZWtKdfYtDcTRKIZlp322Y1XV3ro5BjNZ/ATge8/" +
       "+KGx4IAwmuZup8ZaVCiyIKrgPCORFdANgcPXPz84cDvFKmqtY6dry4ADKw0O" +
       "EewmQ4BQNwU/AJOsiwQ4IIXObk9xdjG1DJuVhR35TyUJ1YT+XM2LvgQteEG5" +
       "sp0/ORy4cd/+zOYHzxd23BwshXs0O/fQ7/79Quyek8+VqMSqmW6sUukYVUMR" +
       "f0HAafr4i4YXPt+ov+PtxzqG151JCYVjbacpkvDvhSDEivJ+Ej7KiRv/Om/r" +
       "ZSM7z6AaWhhSZ5jlD/uOPHflOfIdUf58I+J60bNPcFFn0IdqoIS1TS3oNUsK" +
       "BoAxlnwJvqRjAMmwCXsmFrKdQp5fbmkoI46KgOhix2ysvMcvlGMZPRdb78sZ" +
       "tvAtb50in74dmz2MNMkmlfDZtFCqu8yXfI6y3nObW07n8lPntDjQZfDxm4Kl" +
       "Xhd8tqMdduaKZWWWllYs152rgBWfQwEiqZjgB9k/hbq/j829jLQYNitebk2Z" +
       "aA+YEA6ZMuagfnx381uj97/zkJOdFJXqAWK6Z993Povt3SfAQrx5Lil6dvSv" +
       "Ee+eIjBgoyNkLZ5qF75iw1+O7n780O6b3Sh3PSPTxnQl41nIfV+UhayB7zrn" +
       "mq87cwsptzR0mxEv3AjvemSK6/4JNkcZaTVpDtCw+MZx/qCnm2P/D93kobgN" +
       "Pblhrdha9JYv3p/lh/c3VM3dv+1VDvuFN+JaAPCsrar+asbXrwTmWYULWStq" +
       "GxH9n2Rkbhl/wRqFd/jBnxD0T0FiHqaHGob/9tP9kpEajw5YiY6f5AQjFUCC" +
       "3WeNEvWLKOrykWAcLui+5XS694XuJQEv5f9LcaOOPeAklkf3b+q/9tSXHxQv" +
       "TLIqTU4il5mQi4nHrkLkWlyWm8urcuPyT+uPVS91vapJHNgz6rN9RgdIGTHw" +
       "xueFnl+sjsIrzGsH1j756z2VLwEebCcRiZFZ24vL37xhQ8qwPVGcc0KU5+9C" +
       "ncvvm7js3OwHr/MHBiJy1Pnl6VPyKwevfvmO1gNtUTKzl0wHwKB5Xpevn9C2" +
       "UHnMTJI6xerJwxGBiyKpgYS2Ho1TwiqU68VRZ11hFN8nGWkvxrXiV90aVR+n" +
       "5jrd1ngpCSnxTG8k8E8eN/jbhhFa4I34Sq+cAEsRaypSiT7DcBPo6PcM7qJa" +
       "KTDR+OrXeRebP/4X9FLebWcdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e+ws11nY3Gv72vfG8b124th1EyeObyDxwG/2NfvAgWR2" +
       "Z2d33rM7O/uYEm7m/X4/dnapU4hUEhopRMWBVCLuHw2iIIPTClpQm8oVKgGB" +
       "KqVCfUklUVupUBqJ/AFFTVs6M/t730eclq40Z8+c853vfO/znXPm9W8CjyQx" +
       "AIaBuzPcID3SivTIduGjdBdqyRFBwZwUJ5o6cqUkWZRtd5T3f/nmn337c+at" +
       "q8A1EXiH5PtBKqVW4CdzLQncXFMp4OZZ69jVvCQFblG2lEtQllouRFlJ+jIF" +
       "vO3c0BS4TZ2QAJUkQCUJUE0ChJxBlYPervmZN6pGSH6aRMAngCsUcC1UKvJS" +
       "4IWLSEIplrxjNFzNQYnhsep9WTJVDy5i4H2nvB94vovhz4PQqz/7I7f+4UPA" +
       "TRG4afl8RY5SEpGWk4jA457myVqcIKqqqSLwpK9pKq/FluRa+5puEXgqsQxf" +
       "SrNYOxVS1ZiFWlzPeSa5x5WKtzhT0iA+ZU+3NFc9eXtEdyWj5PVdZ7weOMSq" +
       "9pLBG1ZJWKxLinYy5GHH8tUUeO/lEac83iZLgHLoo56WmsHpVA/7UtkAPHXQ" +
       "nSv5BsSnseUbJegjQVbOkgLP3RdpJetQUhzJ0O6kwLOX4bhDVwl1vRZENSQF" +
       "nr4MVmMqtfTcJS2d0883mQ9/9kf9qX+1plnVFLei/7Fy0POXBs01XYs1X9EO" +
       "Ax9/ifoZ6V1f+fRVACiBn74EfID5x3/9Wx/9vuff/O0DzF+9Bwwr25qS3lG+" +
       "JD/xtXePPjR4qCLjsTBIrEr5FzivzZ877nm5CEvPe9cpxqrz6KTzzflvbX7s" +
       "l7Q/vgrcwIFrSuBmXmlHTyqBF1quFk80X4ulVFNx4Lrmq6O6HwceLeuU5WuH" +
       "VlbXEy3FgYfduulaUL+XItJLFJWIHi3rlq8HJ/VQSs26XoQAADxaPsDj5fP9" +
       "wOFX/6eACJmBp0GSIvmWH0BcHFT8J5Dmp3IpWxOSS6t3oCTI4tIEoSA2IKm0" +
       "A1M76VBiK0whvLLSMNbKkgsC96iysfD/K/ai4u3W9sqVUuzvvuz0bukv08BV" +
       "tfiO8mo2HH/rV+787tVTJziWSgp8bznh0WHCo3rCo8OER5cmBK5cqed5ZzXx" +
       "QbWlYpzSxcvg9/iH+I8RH//0+x8qbSrcPlxKtQKF7h+DR2dBAa9Dn1JaJvDm" +
       "F7Y/vvwbjavA1YvBtCK2bLpRDeeqEHga6m5fdqJ74b35qT/8szd+5pXgzJ0u" +
       "ROdjL797ZOWl778s1jhQNLWMe2foX3qf9Gt3vvLK7avAw6Xrl+EulUrzLCPJ" +
       "85fnuOCtL59EvoqXR0qG9SD2JLfqOglXN1IzDrZnLbW+n6jrT5Yyfltlvs+V" +
       "D31sz/V/1fuOsCrfebCPSmmXuKgj6w/y4Rf/7b/8o3Yt7pMgfPPcssZr6cvn" +
       "HL9CdrN28SfPbGARa1oJ9x++wP3057/5qb9WG0AJ8eK9JrxdlaPS4UsVlmL+" +
       "m78d/buv/8GXfv/qmdGk5cqXya6lFKdMVu3AjQcwWc72PWf0lIHDLd2rsprb" +
       "gu8FqqVbkuxqlZX+z5sfaP7af/vsrYMduGXLiRl933dGcNb+V4bAj/3uj/z3" +
       "52s0V5Rq4TqT2RnYIRq+4wwzEsfSrqKj+PF/9Z6/81Xpi2VcLWNZYu21OjwB" +
       "tQyAWmlQzf9LdXl0qa9ZFe9Nzhv/Rf86l2DcUT73+3/y9uWf/LNv1dRezFDO" +
       "65qWwpcP5lUV7ytK9M9c9vSplJglXOdN5odvuW9+u8QolhiVMmolbFzGmeKC" +
       "ZRxDP/Lov//nv/muj3/tIeAqBtxwA0nFpNrJgOuldWuJWYaoIvzIRw/K3T5W" +
       "FrdqVoG7mD8YxbP127WSwA/dP75gVYJx5qLP/g/WlT/5H//8LiHUkeUe6+ql" +
       "8SL0+s89N/qhP67Hn7l4Nfr54u7YWyZjZ2Nbv+T96dX3X/sXV4FHReCWcpzp" +
       "LSU3qxxHLLOb5CT9K7PBC/0XM5XDsvzyaQh79+Xwcm7ay8HlLOaX9Qq6qt+4" +
       "FE+eraT8kfJpHbta63I8uVJ66GNqoGReuXpVTR+pB79Ql7er4ntr7TxUVT9Y" +
       "enNSZ5ZpSYzlS+6xV/9F+btSPv+7eqopqobDUvzU6DgfeN9pQhCWi9RTQ5xB" +
       "7zAIPb6DsiOBHjOLGtXTZR5eW1wloKNDKneIeVXZqoqPHiaF72thP3DK/9NV" +
       "68vl0zvmv3cX/0Bdoe/N9dUUuB7GQVpqSVOrZrQWMFYSqWq6lLnpwfSt0mFi" +
       "4IX7WO9c2tap4B3lN2bf+NoX92+8fohXslTmOgB4v13F3Rubavn6wAOW4LN8" +
       "808nP/DmH/2n5ceuHkeYt10UybMPEsmJHt5+5vml11eN60uaYN66Jp44yc4+" +
       "fDzth++jiR++tyauVNXZifSv66dir1r4i9M8+aBpTvm4zMzHviMz9eS1xzzS" +
       "OuodNap37UHuUltMVYxPCH/GdpXbJx6xLHdkZci6bbu9qhu/RBD2lgkqbe+J" +
       "M6ehgnL385n//Lnf+6kXv14aGgE8klehp7Sdc57FZNWG8Cde//x73vbqNz5T" +
       "L9ilkJc/+Q/af15hdb87tp6r2OLrfJeSkpSu11hNrTh7cFTnYssrU5H8eLcD" +
       "vfLU152f+8NfPuxkLofwS8Dap1/9W39x9NlXr57bP7541xbu/JjDHrIm+u3H" +
       "Ej7vtfeYpR6B/Zc3Xvknf/+VTx2oeuribmhcbvZ/+V//r987+sI3fuceyfjD" +
       "bnBXAHvrik1vrqedBEdOftRSRFdbpZivNHansT3dgJQVMepYPDuDo3Gbm8oO" +
       "GvdZHEZ9oqMyDVgZzEi4x7aZ1jzPe3y3l0CyyAxnM0wa82MV3ZINyyXteThx" +
       "TGG2TMmZMGkMET4txgOKnK0sIXJnljUcNcioEWoQ02N6YJtoos0JERYgKzIt" +
       "yMvXfq6BIGP3Ci50E0+SaMnqjQmjGRXToMHwpIjRg1YkYq684bduu9kwdXlh" +
       "+3qnKSxJkeAE20kFny9kNcCQ5ma3JhBntffIBdFkI5/B6XjoFJGwZuhNEGWE" +
       "4FGbfO2h2GqOqZIv7gweHbueYc8Jm3DJlic1mq0pssPxsT9asIuCykfOoE04" +
       "VhoPk8XU92K7t5eZDiuwq35uwdNJMYLDBR7LC2xqj5Sl5a+9RYzOG+qK2DSX" +
       "Hg27buK2oyLoEIy1yaglMwRjdrJYtPqypM0ib7QMvaTb0ZjNSsr8aEI3HB6n" +
       "262I4/2pwGQbWCBok57ux/Z05rYbezOZBCqzXjkD0jYHU3WdrCmdLVbjLGyE" +
       "aGHQRWLbeEEMaVLTthNt6A8NeLknJiq1FUOsWDnYEl9Za9vf5RaYtZUGFFsj" +
       "ZjQnjC7OdHzMYREeXYikIRAhJQy4aOfNA8LxJIayk9kqiJwopFlbV+WRj3rJ" +
       "PMmm8JpamMFksHC0dtQ1/GTcEgpZjENxPIIoVIlhqR2u3I04bNqeFo+pEbow" +
       "WCTdBAqK7MnOVGWFzLP5UDLDCdaZC9hkkYEjg9+qY4lNzMkgYYTGYoMPG1ZB" +
       "z4lVo6Mbhkd0Wii5WKiLIeLAGCyKnhUbTWIaribSLEhpZ9bGSQmJwiBGQmXb" +
       "MHGvA+8NN5MwudQKB0LteNDsxbI4t2Ac91EXFedrjivoVboRVrKEiZJLbZHe" +
       "ZKs6a4vyfHbcziwTGRZ8x9w0uH3D62oZS+kpSLEjONvyDJEvsq5NCzk5VLkW" +
       "1e9l67jrI5vmTMyitQHPFAdudlodumjARhPxUAezbUNUdhont31vMlD0MBtg" +
       "vNDII3HebCrd4XSxJrQEni0nocYvlhEfFJ7mOM3mglJ1qrve40Nwlk6CCdNS" +
       "9stIGIhESJpg1OR8PSDxJBkjy6Yw1Bsy2W3tFYdJqJ62oWe0QYOCkeukRYDg" +
       "ZDBx8vGcE3TbsYrQiuTpsLFVYVm3DNQMG2wT55Dmiiuitsok43FnH8P+UEHs" +
       "ZBNo3bE8CiYWpFnuPPDMtYg0B8KmFdqFuaa4oLXbFxY9F7i8nzBs3Bn1ZXWx" +
       "RPci3983e2sFjM0mx40CBiGmZGObGNuWjTvMpr1HPcbYYmk0m4+Ivj/wOols" +
       "ShlhzpXpFGkxsWs01bwVe34+I5KdaelDN8QauYjErN9SaATrwfN+SrmZkk9k" +
       "eN9XCZXmQ8zjPb4VTtCou5+MEWLtC301l5jxzKQKI+kbAmpPSI9KaXqDTeCA" +
       "HW4jlZpGuG/b9L6lrIcotgjdfLozyKkLKvlO68+zSe4vNXfMoyA+kBeGHmwz" +
       "AbWYAFPZDg62G2FuNNo5xBENOW11i85oiJDkZKtRywineyuMGpGJT0iDDYG2" +
       "JM0j2sOm2mN4pOH0RzbC7aVt6VcIKS+Gq0wIZ8F4n4XewiWKXbos0HlSDNZY" +
       "bhJpMAYhbhizG2veaaO9Dlhs17AM79RNC+ktYaPRcl18ZHZoymw0prk9kAfd" +
       "gUPmsj1PmDxAIB7zfLSbzVYLZhryMidTmuQilDqBFFrndHbQgrS911iRhCS0" +
       "YgRttXoISZkjgWPbfq/tpbKucdyQbFLMfphMpYXDsc6uj1sa64hGYG5kdZ9z" +
       "NNKMPGQ0MZpTNWkk474bNczQlQgbklKzq3sc5DXzoIegmCAq9D5uD5Bdvy9z" +
       "K0fL9DY0bTNJx8M9NhmsF54zcxAfXBY9m2CkGcU5MmSGs3XbDxHNwBCkP0lC" +
       "B57ZZDbu4tyepzJ55/d12WoQ+6hX+nnuMRxo6nm4DQgVau0CtTkr+qC2iXQm" +
       "NAVQA7uLPd41166pNDpai+4zxoCZ7ObBMAsydtCEltGwB2Go4RkSTc8macoY" +
       "Y6m/nVJKmQ3sIRsVGhDX0l1ruHEzHF1FlCe0eGZP8Ohyw/SWEwRb74tsubbo" +
       "RI07pOdsUtIKZvnEQTBqVwzURRky2pi7gOCkZzExCsKQ08xEfG0pe1Vd4wwy" +
       "FYiVD4ewPW3D8GDV50qFrDPEznb9zF6tTLW777cjsJQOxHN4uNxPR9lcwxcr" +
       "AmSmvRBa66rb06nGlKSsLt7sKz4yEnJZWE9peDCdtHIIWwn7scXPU5cwN4rT" +
       "FDbthUB1xZ4P09KCMnTXIC195yad0YbucAbs5q39SNCE8Rx0LAaSg5kWry1s" +
       "2WHb2xW7afZn86iPd8bYch7q6ZTZ8mi+3hVK2sm2pLzUcKtcYtAeNex0k7ZB" +
       "44EX8WPaW+TY0iqtNO2BA8kH47irNbmYaat5V8ujdj9bpQLCFKMG6xbl1GQT" +
       "WbYa2bbFz1pdq4i3gxZm9BaGNFL7EdxC41GX93SUFSYuEXQKYdKV2c5EDIaB" +
       "3ps1KNYP8DZPkOZKcVeePkSG+n5FIEkf7aMbbmX5lCxik0wh1HEESq5v+3in" +
       "Oe0JFNYy4pmWUymngFDOOIrr2RRuy/x+zIqpNUVdmYhBTQNlZqNgEjHckBm8" +
       "RPvNCFurvTaCl5lOaA3ktcTtCF6bwbk9EifMkNZXgbmTOws7Ilne2TWlHCya" +
       "W951pnDELhA8I2R3vmc2nEfStgV3TZ30t0wDoXZ9HsrnEROX0AKUYXygrsdi" +
       "m6OCKZRLu7mie2jRndNzbDnq22Q/Wbbp5ZKLRILvqvhgsUVB3SbjooAGYMuM" +
       "ugxLkPmUCJvtqdRmjTaOT1GrE21R2BFwi0PTgAioPegmku5jstIXJjsa6/Li" +
       "KiVVfZOiymJO4qIbtlutTXO9bMcBPLQZEUIWhtaHQHJSdHBk62ViFvZFaTmy" +
       "djgZG9yILXM4hDEUbs3t+x0FzTHSi9JNV413HQQltw12rG29WWc4Y7YChBBs" +
       "Ym1nHRxfs7IzKFR70kSJbGnO2/BiJxDNzQJc0y0qN2apNp7ASdiA2Pmuo6gQ" +
       "uGc3032httrDbWKukwYL6bMe1BvMsp3m9MFlRPORt+omQuZslgI91xtTRNLj" +
       "jtXZrLkUDHKQS4t9NGnCTWK0WdqypIROjuZmmX1aOQGO7R5pzXOI9aBY5One" +
       "votIK9PkRdh2UShjuanusjquCjrcx0Gi25AZTsEwv4GrUYDzzQXfDhghIYcB" +
       "Urj+lsijuY3Q3na0TjwsJtVZCOuy5wR4p0sarGkVrV2S00ruTmiRm6tyr5+I" +
       "aY6kMtyw/F5H9fYtmqEdz9VRMcVGUdbfrXW8u2v7rLxq9Py+y/kpas9EHS28" +
       "DumuTbWfRrSqZhIprlYr190kTbgVG8OVPtuOrUi0jeHAgUw5gux+a2BTsw1j" +
       "pZrstEQJATdjpCvSmWToftHuNzN70IP2DsGqGLGOkBXZFQeDNhfkaZvXkVlc" +
       "wJTldtWcz8caqOH20Ah2jEOJcFQu9ta2CbI9v9dvsF25zZttjucWhT9zO00f" +
       "15egYEq7YW8f+17U7ynbJEz384ZXjPM2Yueax5NdqEzUHUWUFssQTUdbkBYL" +
       "KBr5XouD0EHbCWSD4WTXjFVTGhCbvB1Crgkp7SVdRh6wuUTzDGNAQkK4URJL" +
       "MSgl8jreLrzVRqBWfBpNiunAb80d2XSh7TzCVMge+gXaWDQwaxpJ00kgQ4OU" +
       "GzjhWLK38MbadHUYmdmYMBq1VxozzlcUycY7Z4UoVGaB8JrvDjrrjJiNc1gf" +
       "UIrEspyGOK6jt2UwKnHx62kxyxcUHi2EjuXC3szq+NPYoZyVu1t5/XL3nXG7" +
       "BZhxS37QzKWQmDLGvhszg7mh4pPFdFtkGua7YGIneLyfJNOm3YO7+9aS2o41" +
       "eaTMLRETW52cavcKc9aPttxyoigNUoDBwchX8tzr2Umb3U5jiJ4OLWJX5qVu" +
       "d8ntyK2W67nHNg0mFRbk3m1sp1tyCK9DLfcHo5Yw9ekFgXcLLSa2xWRo7cjQ" +
       "2PCtadBcbK1I6PaXc7HZNDGm709WTl6U68py0JCWc9CH7Vht+kY44v1iMek7" +
       "/XFfYyBbNk1M6uDtDh+BCjJO5tIu5K1FD1WGXNDlFLoXERK5QOcgG6+1uSZz" +
       "UGc9wChNXilquZP+wWqL/cp3d8rxZH14c3oh/X9xbHPoeqEqPnB6ZlX/rgGX" +
       "LjHP34ecHZID1YnFe+53z1yfVnzpk6++prI/3zw5+itS4HoahN/varnmnkP1" +
       "UInppfufzND1NfvZofdXP/lfn1v8kPnx7+Iq772X6LyM8hfp139n8j3K374K" +
       "PHR6BH7XBwAXB7188eD7RqylWewvLhx/v+dUss9UEvtg+YjHkhXvdRp46wEn" +
       "jh886P7S3c3Vw+HwyUHpO6sL121bOVID7wg9d5aO16N/+gE3Pz9bFZ8tTUuJ" +
       "NSnVzt3QniB/8S3c5p4Z3099p6Ol8wTUDZ+5ePmIlE92LK30L1VatUBOuHrp" +
       "LXB1OFrf1Tj/3gNk+AtV8VoKPB1m6d3D6yHJOcfcpsDDeWCpZ0L7u/+vQhuU" +
       "zyeOhfaJvxyhXTkDOFjRrz5AAv+oKt5IgWdjzQty7W4hVP2/eMbwl78bhsv4" +
       "cfPSlwPVNeizd32SdPiMRvmV124+9sxrwr+pL89PP3W5TgGP6Znrnr+1Ole/" +
       "ViLXrZqZ64c7rLD++0oKPHMfU6nuoupKTfE/PcC/mQK3LsOnwCP1/3m430yB" +
       "G2dwJapD5TzIb6XAQyVIVf1qeI+7qcPlXXHlYnQ+lfFT30nG5wL6ixfCcP1J" +
       "2EnIzLjjq6M3XiOYH/1W9+cPd/uKK+33FZbHKODRw2cGp2H3hftiO8F1bfqh" +
       "bz/x5esfOFkinjgQfGap52h7770v0sdemNZX3/tff+ZXP/wLr/1BfYXwfwD5" +
       "QyoMqycAAA==");
}
