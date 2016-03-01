package org.apache.batik.bridge;
public class DefaultScriptSecurity implements org.apache.batik.bridge.ScriptSecurity {
    public static final java.lang.String DATA_PROTOCOL = "data";
    public static final java.lang.String ERROR_CANNOT_ACCESS_DOCUMENT_URL =
      "DefaultScriptSecurity.error.cannot.access.document.url";
    public static final java.lang.String ERROR_SCRIPT_FROM_DIFFERENT_URL =
      "DefaultScriptSecurity.error.script.from.different.url";
    protected java.lang.SecurityException se;
    public void checkLoadScript() { if (se != null) { throw se; } }
    public DefaultScriptSecurity(java.lang.String scriptType, org.apache.batik.util.ParsedURL scriptURL,
                                 org.apache.batik.util.ParsedURL docURL) {
        super(
          );
        if (docURL ==
              null) {
            se =
              new java.lang.SecurityException(
                org.apache.batik.bridge.Messages.
                  formatMessage(
                    ERROR_CANNOT_ACCESS_DOCUMENT_URL,
                    new java.lang.Object[] { scriptURL }));
        }
        else {
            java.lang.String docHost =
              docURL.
              getHost(
                );
            java.lang.String scriptHost =
              scriptURL.
              getHost(
                );
            if (docHost !=
                  scriptHost &&
                  (docHost ==
                     null ||
                     !docHost.
                     equals(
                       scriptHost))) {
                if (!docURL.
                      equals(
                        scriptURL) &&
                      (scriptURL ==
                         null ||
                         !DATA_PROTOCOL.
                         equals(
                           scriptURL.
                             getProtocol(
                               )))) {
                    se =
                      new java.lang.SecurityException(
                        org.apache.batik.bridge.Messages.
                          formatMessage(
                            ERROR_SCRIPT_FROM_DIFFERENT_URL,
                            new java.lang.Object[] { scriptURL }));
                }
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO38bG38QsMuHAWMsQeCulAAqpjTmsIPJ2Xc9" +
                                                              "G6qaNsfc7py9eG932Z21z6Q0AakB5Q8UBZLQJlhqS9QWkRBVSVupCqWq2iRK" +
                                                              "0wgatUlQk7b5o2kTpPBHQ1rapm9m9m739j5o+kct7dx45s2b996893tv5vw1" +
                                                              "VGOZqNvAmoxDdNYgVijO+nFsWkSOqNiyxmA0KT34x5P33fhNw5Egqh1H8yex" +
                                                              "NSxhiwwqRJWtcbRM0SyKNYlYI4TIbEXcJBYxpzFVdG0cLVSsoYyhKpJCh3WZ" +
                                                              "MIK92IyiNkypqaRsSoYcBhQtj3JpwlyacL+foC+KmiTdmHUXLC5YEPHMMdqM" +
                                                              "u59FUWv0AJ7GYZsqajiqWLQva6LbDV2dnVB1GiJZGjqgbnIMsTu6qcgM3c+0" +
                                                              "fHjzoclWboYFWNN0ylW0EsTS1WkiR1GLOzqgkox1EH0NVUXRPA8xRT3R3KZh" +
                                                              "2DQMm+b0dalA+mai2ZmIztWhOU61hsQEomhlIRMDmzjjsIlzmYFDPXV054tB" +
                                                              "2xV5bXPH7VPxkdvDpx67p/UHVahlHLUo2igTRwIhKGwyDgYlmRQxrX5ZJvI4" +
                                                              "atPgwEeJqWBVOeScdrulTGiY2uACObOwQdsgJt/TtRWcJOhm2hLVzbx6ae5U" +
                                                              "zn81aRVPgK6LXF2FhoNsHBRsVEAwM43B95wl1VOKJnM/KlyR17HnbiCApXUZ" +
                                                              "Qif1/FbVGoYB1C5cRMXaRHgUnE+bANIaHVzQ5L5WhimztYGlKTxBkhR1+uni" +
                                                              "YgqoGrgh2BKKFvrJOCc4pcW+U/Kcz7WRbSfu1XZpQRQAmWUiqUz+ebCoy7co" +
                                                              "QdLEJBAHYmHT2uijeNHzx4MIAfFCH7Gg+dFXr9+5ruvSi4JmSQmaWOoAkWhS" +
                                                              "Opuaf3lpZM1nq5gY9YZuKezwCzTnURZ3ZvqyBiDNojxHNhnKTV5K/PJL958j" +
                                                              "7wVR4xCqlXTVzoAftUl6xlBUYt5FNGJiSuQh1EA0OcLnh1Ad9KOKRsRoLJ22" +
                                                              "CB1C1SofqtX5/2CiNLBgJmqEvqKl9VzfwHSS97MGQqgOPrQNvuVI/PFfirTw" +
                                                              "pJ4hYSxhTdH0cNzUmf7sQDnmEAv6MswaejgF/j+1fkNoS9jSbRMcMqybE2EM" +
                                                              "XjFJxGQ4ZSryBAnvJGlsq3RUMhWDjhLJNhU6G2J+Z/zfd8wyGyyYCQTgeJb6" +
                                                              "wUGFuNqlqzIxk9Ipe8fA9aeTLwvHY8HiWI+i9bBtSGwb4tuGxLahktuiQIDv" +
                                                              "dhvbXjgCHOMUAAIgctOa0a/s3n+8uwo80JiphjNgpL1FGSriIkcO7pPS+cuJ" +
                                                              "G6++0nguiIIALinIUG6a6ClIEyLLmbpEZMCpcgkjB5rh8imipBzo0umZI3vv" +
                                                              "+zSXw4v8jGENgBZbHmd4nd+ixx/xpfi2HHv3wwuPHtbd2C9IJbkMWLSSQUq3" +
                                                              "/2z9yieltSvwc8nnD/cEUTXgFGAzxRBLAHtd/j0KoKUvB9NMl3pQOK2bGayy" +
                                                              "qRy2NtJJU59xR7jTtfH+bXDE81isrYBvtxN8/JfNLjJY2yGclPmMTwueBj43" +
                                                              "apx5/dd/2cjNncsYLZ5UP0ponwelGLN2jkdtrguOmYQA3e9Px08+cu3YPu5/" +
                                                              "QLGq1IY9rI0AOsERgpm//uLBN95+6+xrQddnKaRpOwUVTzavJBtHjRWUZH7u" +
                                                              "ygMop0LcM6/p2aOBVyppBadUwoLkny2rNzz3/olW4QcqjOTcaN2tGbjjn9qB" +
                                                              "7n/5nhtdnE1AYlnWtZlLJqB7gcu53zTxLJMje+TKsm+8gM9AEgDgtZRDhGNp" +
                                                              "FbdBFde8E4ouvpIl1JBIqLmJ5UWwIbICL0n2JKKMbAs/+jv4kjBvNzKz8R0Q" +
                                                              "n9vKmh7LG0KFUeqpqZLSQ6990Lz3g4vXuc6FRZnXY4ax0SeclDWrs8C+ww9X" +
                                                              "u7A1CXR3XBr5cqt66SZwHAeOEsCwFTMBMrMF/uVQ19S9+bOfL9p/uQoFB1Gj" +
                                                              "qmN5EPNQRQ0QI8SaBLTNGp+/U7jITD00rVxVVKQ8O5Xlpc97IGNQfkKHftzx" +
                                                              "7Lbvzr3FXVP44hK+vNpitaAfVXlB7wLC+1cff+enN75TJ8qBNeVR0Leu8x8x" +
                                                              "NXX0Tx8VGZnjX4lSxbd+PHz+icWR7e/x9S4QsdWrssVpCqDaXfuZc5m/Bbtr" +
                                                              "fxFEdeOoVXKK571YtVl4j0PBaOUqaiiwC+YLiz9R6fTlgXapHwQ92/oh0E2P" +
                                                              "0GfUrN/sQ71OdoqbHeTLIWAB6gUAR6plTDH7926+sJe3a1izToQZ664HvLF4" +
                                                              "oU5BEEXDqg93OipsQ1Hzzv6x/mQ8ERuLRWI87DYJwGVtH2uigt/2so45UKhW" +
                                                              "BL5eZ7/VpdTaXLoiIaapmyGJu0xIxFJI1iU7QzSoGU1e6+6tZAjWxFnzhRIW" +
                                                              "WF1GIopWDCQSsUQy0j8yEhtL9kciA6OjyZ2xyJ7hgZGxpINFfqN88RMaZQd8" +
                                                              "6x0R1pUyyqZKRrH4YCht6pkQYDlPwHmbJP9nm6wrIxDAs7DJaCQxFB9LDiZi" +
                                                              "w8mdQ4ODA4kKJtn/35tkPhtdBd9GR4KNRSZBvDNZWjewV4Nh6hSClMg+xZor" +
                                                              "sKUoaJFcClriyU2OuQeyEjFyZYJHNaWCamKqlzVr85Lwv1rku1J4E74Lx4Gc" +
                                                              "QL3lSulCn2AJaVm5SyK/4J49empOjj25QWB3e+HFa0CzM0/99l+/Cp3+w0sl" +
                                                              "6vkGqhvrVTJN1AIRTbSyKGMM8zu0C79brtyouvpwZ1NxCc44dZUpsNeWTy3+" +
                                                              "DV44+tfFY9sn93+C2nq5z1B+lt8fPv/SXb3Sw0H+DCDQvuj5oHBRXyHGN5qE" +
                                                              "2qY2VoD03YX17Ur4tjqesNXv6q6v+ZwoXzWWW1qhMnqgwtxx1hyBogccTZqK" +
                                                              "Qh0iHMyqmOfjppKBEnraeVIIH25/e+qJd58SPuZP6j5icvzUgx+HTpwS/iYe" +
                                                              "aVYVvZN414iHGi5uqzDIx/AXgO/f7GO6sAH2C6k74rwWrMg/FxhGlvtsBbH4" +
                                                              "FoN/vnD4J987fCzo2GYWsu60rshu7B+9FawV1GVsIJKlaGFJOGdlW2fRK5x4" +
                                                              "OZKenmup75jb8zt+Bcu/7jTB5SVtq6q3qvD0aw2TpBUuepOoMQz+c5qijjJw" +
                                                              "AvWC6HDpHxP0j0Ot7qeHeoL/eunmKGp06YCV6HhJvkVRFZCw7reNEhcBUVxl" +
                                                              "Ax58cUCU23vhreydX+K9oTF35a+guTi3xTtoUrowt3vk3uubnxQ3REnFhw4x" +
                                                              "LvOiqE5cVvNYsbIstxyv2l1rbs5/pmF1zlvahMBuBC/xhBnUQQGDnfhi3/XJ" +
                                                              "6snfot44u+3iK8drr0Bg7EMBTNGCfcVlaNawAcj2Rb0A7HlL5ze7vsZ39r/6" +
                                                              "0ZuBdl7tO5DdVWlFUjp58Wo8bRjfDKKGIVQDwUCyvEbeOasliDQN95J6W1MO" +
                                                              "2mRIBkdL6baWfzCdz9wTswsdt4xj0Ob8KHthoKi7OMSLX13gIjRDzB2MO8dP" +
                                                              "H7rahuGdzbKHxBJawdlsOPP3+x54PQbhUyC4l1udZafyQO19j3WRu5U1J7IC" +
                                                              "WKqS0WHDcIAmMMtP1TB4kP+QK/2soGYUFAXWGsZ/ABV8pwBXGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeczsVnX3W/I2kryXQJYGsr+kTYZ8ns0zY0IpY8+Ml/HY" +
       "Y8/Ys7Tli8f2jD3jfRl7DGkBqQUViaI2oaBC/goqpYGgqqiVKqpUVQsIVIkK" +
       "dZMKqKpUWopE/iitSlt67fn2t4TwR79PvuO599xzzzn3nN8999556XvQLYEP" +
       "FVzH3CxMJ9zRknBnaSI74cbVgh2aQfqyH2gqbspBMAR1u8ojn7/8gx9+RL9y" +
       "Gjo3hd4o27YTyqHh2IGgBY651lQGunxY2zY1KwihK8xSXstwFBomzBhB+DQD" +
       "veFI1xC6yuyLAAMRYCACnIsANw+pQKfbNDuy8KyHbIeBB/0SdIqBzrlKJl4I" +
       "PXyciSv7srXHpp9rADhcyL5LQKm8c+JDDx3ovtX5GoWfL8DP/da7rvz+Gejy" +
       "FLps2INMHAUIEYJBptCtlmbNND9oqqqmTqE7bE1TB5pvyKaR5nJPoTsDY2HL" +
       "YeRrB0bKKiNX8/MxDy13q5Lp5kdK6PgH6s0NzVT3v90yN+UF0PXuQ123Gnay" +
       "eqDgJQMI5s9lRdvvcnZl2GoIPXiyx4GOV7uAAHQ9b2mh7hwMddaWQQV053bu" +
       "TNlewIPQN+wFIL3FicAoIXTfDZlmtnZlZSUvtN0QuvckXX/bBKgu5obIuoTQ" +
       "XSfJck5glu47MUtH5ud77Ns//G6btE/nMquaYmbyXwCdHjjRSdDmmq/Zirbt" +
       "eOuTzEflu7/4wdMQBIjvOkG8pfnD97z6zrc+8MqXtzRvvg4NN1tqSrirvDi7" +
       "/etvwZ9Az2RiXHCdwMgm/5jmufv391qeTlwQeXcfcMwad/YbXxH+YvLez2jf" +
       "PQ1doqBzimNGFvCjOxTHcg1T8wnN1nw51FQKuqjZKp63U9B58M4Ytrat5ebz" +
       "QAsp6KyZV51z8u/ARHPAIjPRefBu2HNn/92VQz1/T1wIgs6DB3o7eB6Etn/5" +
       "ZwjZsO5YGiwrsm3YDtz3nUz/bEJtVYZDLQDvKmh1HXgG/H/1VGmnDgdO5AOH" +
       "hB1/AcvAK3Rt2wjPfENdaHBLm8uRGQ4U33DDgaZEvhFudjK/c//fR0wyG1yJ" +
       "T50C0/OWk+BggrgiHVPV/F3luQhrv/q53a+ePgiWPeuF0FNg2J3tsDv5sDvb" +
       "YXeuOyx06lQ+2puy4beOAKZxBQABQOWtTwx+kX7mg4+cAR7oxmfBHGSk8I0R" +
       "Gz+EECoHSgX4MfTKx+L3Sb9cPA2dPg69mcig6lLWvZ8B5gEwXj0Zctfje/kD" +
       "3/nByx991jkMvmNYvocJ1/bMYvqRk8b1HUVTAUoesn/yIfkLu1989upp6CwA" +
       "CgCOoQycGeDOAyfHOBbbT+/jZKbLLUDhueNbspk17YPbpVD3nfiwJp/12/P3" +
       "O4CN35A5+0Pgofe8P//MWt/oZuWbtl6STdoJLXIc/tmB+8m//ct/qeTm3ofs" +
       "y0cWwYEWPn0EJjJml3NAuOPQB4a+pgG6f/hY/zef/94Hfj53AEDx6PUGvJqV" +
       "OIAHMIXAzL/yZe/vvvXNF79x+tBpQrBORjPTUJIDJbN66NJNlASjPX4oD4AZ" +
       "EwRe5jVXRdtyVGNuyDNTy7z0vy8/VvrCv334ytYPTFCz70ZvfW0Gh/U/hUHv" +
       "/eq7/uOBnM0pJVvmDm12SLbFzjcecm76vrzJ5Eje91f3f/xL8icBCgPkC4xU" +
       "y8HsTG6DM7nmd4F0JO+ZrWg72xVtv+HBa+J2C8t5TiAKTEZWzqcezrs8mZc7" +
       "mdnyEaC8DcmKB4OjIXQ8So8kNbvKR77x/duk7//Jq7nOx7Oiox7Tk92nt06a" +
       "FQ8lgP09J/GClAMd0FVfYX/hivnKDwHHKeCoABwMOB9gVnLMv/aobzn/93/6" +
       "Z3c/8/Uz0OkOdMl0ZLUj56EKXQQxogU6gLvE/bl3bl0kvgCKK7mq0DXKb13r" +
       "3vzbeSDgEzdGqU6W1BwG+r3/xZmz9//jf15jhByfrrOWn+g/hV/6xH34O76b" +
       "9z8Eiqz3A8m1OA4SwMO+5c9Y/376kXN/fho6P4WuKHvZpSSbURZ+U5BRBfsp" +
       "J8hAj7Ufz462qcDTB0D4lpMgdWTYkxB1uH6A94w6e790ApXuzaxc20OmfYQ6" +
       "hkqnQJyfVeVQzr7ieceH8/JqVvz0Ngyy158BeBDkmWwIBDFs2dzDhR+Bv1Pg" +
       "+d/sydhnFdul/058L/946CABccFid1urOWzu9gVuyOFcHiLFLThmZS0rWlve" +
       "6A2d6B3HVcTB8/ieio9dT8Xa9Zdvzfcdf0fJ3Wdn6/c7qqNElmaDBMvPE0Pu" +
       "ZkbJCjIrqNzydAg91BYETtjFmyzLDXebON4eDHZbHC722uxwdw8STurbf536" +
       "YuB5ak/ft15PX+Rm+gZ55c7cd6wdAKn5Onig7uj1qfvgVt0BLlD94W5H4Hq7" +
       "LarTaQs30Xb842t7e1b7KHgqe9pWrtEWyl92ry82MMVF13dCEGaaui/z6UDb" +
       "x+83HwH2PSO1E0Vz99fYI1I/85pS5+xz899S3qnv5Gobr8+c9yxN5ep+1Ehg" +
       "lwjkuLo069czI/1jCwSQ9fZDRRkH7Mg+9E8f+dqvP/otAH80dMs6gyaAekeW" +
       "OTbKNqm/+tLz97/huW9/KE8LgDX7H21feWfG1X19at2XqTXIM2xGDsJevpJr" +
       "aqbZzVG/7xsWSHjWezsw+Nk7v7X6xHc+u91dnYT4E8TaB5/7tR/tfPi500f2" +
       "tI9es6082me7r82Fvm3Pwj708M1GyXt0/vnlZ//4089+YCvVncd3aG07sj77" +
       "1//ztZ2Pffsr10n8z5pgNn7iiQ1vv0BWA6q5/8eUJvNRLCbJaM5VGjOi0uCD" +
       "XkQ2R72A1/DIbDY9dzm0AqpPl8cKStQ8mQ3mSt3doBqBVsrTcimt8cWmvMIQ" +
       "viFiU4anTd0boPxoJWDSQIpc3Bt5ZUPoFuOFHIomv6rPEKe8Grp9jORLvuxa" +
       "KPivV9Al4hRWSlhXkyoSlGcoWmuglXCNrOOSRHBTj103LSdpqexkIRlLrmB3" +
       "gtFqwHmssUmsZrE7rFQTpF+pzHU2RtoLTy+RjY2WsINEN+LYE+hRqMyEXnGw" +
       "6bITc0JVh9SsPVZobJK4aUdSiaLCSIPAmWz0rkvjemU07VFdtExtDHa1cT1Z" +
       "CAbORMF0PlxWaDc2N7LCFOYOXuhaxlC1SHHM4Mik3Sd7PdXrRQjaEUfrYpOu" +
       "E5Np4MlLwxsx/FquMbOWVFZtCSsRBj0llt5iZlO9YBjVPGXRqyiF4pxcpo5i" +
       "jmbOpDNi2eLGHBXbwXBQGq0MoUQwXOotVk5SapNFVhLHQr/ZSIRhRah0p3q5" +
       "xfeswqyoymazYMlGeWpRaTjSObFW0gO+7Vi6SQm9lpUulwFlptak0+qPpSJS" +
       "DbFyIiGzcZ+sS/1kpa5bblKru7BISrJukozolI3FUIgpvUvEm9ZiYloCn/hj" +
       "ZEqvqaoc9hdxW6O9ESZx2kBR/cgcEsakHDVxbsbFvBos6BAehsJIoTndKuuM" +
       "lM6SmqwhYmo3SrIg9RfdGjPulDu6wwYkJgRSuxn3qhUMRWKzJHFd2u7BXXMj" +
       "lOqkPTPwpjsWp7wxL8GdmUQ4E6yEI4rQG8sCuRDtdmHWZCmZlFIeYZCRblhp" +
       "OCHM7jDBVrpQKkS2MVl4DuEv9DLW7XbWPs3hStVVRgUR7ippfSTMBvOoNJ66" +
       "vMA3rZFoeGJa0Ga4s6krDq8ybRprkhOLHJYjY6mxZJpUe1Rz3sHJOrEoqJ2x" +
       "jxYQP1oPjCptDXhLHnFOczXSB5wbyfOK6U57JdtDFhN0Mo26Whrj6dAWhWll" +
       "uvY2mNFinWVCsrrdHUpIF+7TDIo0lvVYEqoJ7pnjoZQ6zTmIqVpiYuIkRDos" +
       "QRuDiNdL7WaRUxhbLzVVtMt1hUBwGLpcxoGFSgNn7oVjBC7jBstgC9ry2muv" +
       "a6JSOo/JwQCt9wjeW3B9n2fXkUTB/c7c8IexS1f1CYiloUoWFTYVrXk94Fu2" +
       "1W6ua70glrXlogMvC6X5inUG6HIAQk3peZtZu9zujZcdOiH46nTgb7CmvaYJ" +
       "M/AqgtjTR62lztCsLtaIMl2YwulcbcQbYrOZ4PxwodGzWiwSnYj1TC+lkhVK" +
       "uVpj3kRlbcjEa3LSII0RVTDQGRYOiHhWDSMiYWR9FUYGT7XWqr6ejZcLnOR6" +
       "YrNJLZSQk4syHFTsQiOKnUaRNlx9yS5cptQhBr5BrRSu7vYHBSWiiVqhULQX" +
       "kUFRTbD5oUSiJtdwk2pvGMaaue1pD3eVxWqJIb7eAAjvYqlTjKwpVVmvC+lg" +
       "HFfXjSXRZhfYdEZaatVWC0aSwIk7N8okua7EcdQnw5laxlGKnq16I2Yw4EWv" +
       "ApdTdAP2HuFgHSsN227BSlscjhcdopkmAsY0yVCFl8Wu0xXXGMr2zIrLc93y" +
       "jJA3G0/YlNmQpkUETYT6chjOycJs3Go3SkbgT7B1mLANmJ6zzJKelDeEYvat" +
       "3jCONGxZrchugsCqCpeVJWsrwYSZImK/6Dp2rJkEw5aXKzX0FxFnTfhmRUP7" +
       "SbEBzFSZ9CME5hnCK1ET1KeKTS5oCwvXguGIwVgUKdQKic+rqt2VBZeLRWmY" +
       "ymsaC8mlMBKnZD3aLHqOW2SUXg12yzKHSRvXxWRVjB1mZW/KPpumFdgxR1Ve" +
       "8ZbcUJHZckjMlksb9bC6DSO2Hqp2u9ScmPYonJoMDaoXSoRU0mHC0L2lVhh2" +
       "A6vQWPTQZnvRWoRToaUTrNuZqVhH1RrtqhOtXcos0RjlMRaNiKOYmlE4U7TL" +
       "dLfbmzUDuLBcV8FMr9m0mzaEIm+j666l1xmi2O2Imud6U2bA11C0yKSVRXU9" +
       "jpRaR5ja40lVToogTzRbIz9o4IU4RsdRvVnCx0JljPmI4oW12mAak02Nawd4" +
       "3Bn2sJ7f68CRxJfQAVqYcXMGdeGIdzpgtVh6Fou0+yyAoyJPNQYyxgxZwi3A" +
       "Yn1JDVvFoi8lktTlGxwyNl0FrVMEy89XXXIepkmdma1Tv9IZS/1qVe8W1qxr" +
       "hHJzLo1NrB4zeKGkzOcFzWbryJBueBirSUKR0aJG0kjY8bg4TBoSMbWX46o5" +
       "SGZqoU+mBUMZCXUNTtBBlQ9UoGMggfW+JY/n0VRBLBibhf486bRVjXOkcbeL" +
       "1EuTUDKry2IfkznRkw0jxgsTxkhRoTYfmoux7JIxj5ZhRy+2y/0iMRd9Fg74" +
       "eolTHW9GgrCnRk2sthCbQs01hy2yjpZrhYDWKnLJSIcOP63VquSa6VQdEcHa" +
       "7XHLW6AVznADvkSm6bqWwBbfaAsRI4yoRr01oWNCCkkA4IsQLgdOFRG7+ghj" +
       "EG1ahyVXHcpjxjEoGaQpG4KOigmVdGiqZIh1Ph04hFjSaoVaOG0uR0nHTnWB" +
       "Go06JYJy3FEL5weByG+Ky8amrYcMulKMZo1bbqblZEPX9cWUSFyK7cw9ttEQ" +
       "evKUVxu1pCiUXBEE8rQr+GR1guthzV3xk5bZj0lrRvdR26rFPpW0mkG9Rcs4" +
       "n3QwlGkZUyNuWCpf5VrN6qpLhzZcQcJVH8QGpqKEUO2ywmCKrVvsdLTUYqnK" +
       "6jV9gJu9RSGZOn7QFR2Z7ii46RsbscxFvLZpLzub6YQmWXmEy1bXM1PJbyAA" +
       "dUv+KirR1Xa9yiRVQuGZijmITNwuN2lZshCQXsFVuopqlsstl2WEH2EVrUB2" +
       "5CKe9oowipoFGHcrhbgYmLX1ivD0tS8NabbUpIThDPQmer1GGhXxOjrzw00W" +
       "nPG0xCZgaa6qU9ENWG003FQKLalaLYTzzgQNbLRSwMtgJU1LWMEMG/P+Gh6M" +
       "Z5VBXCQLLbzFryOQXIKEYrwhCRbx2mVvUpacVrEyGZfqol8Nl54WsON1zaut" +
       "C9PYGaej0ajk6T3bW8RhkpT0DeYsFGU49bq8XjTI3sazuPnSdbtY2/ZlTaIo" +
       "sozAWsGjVaQx6EfTfm2JGMo6FRdJgRy68QA2JposTaT1lK2WqgZJGEjkpS0q" +
       "gZvjBQfP6wRXC5pkGa+t6lU/Hvm9BdxJdMJchwE2I6sdh4XXdqtKo436HE+d" +
       "MjEZBVGt6Ad6VMcKaEeOpRIhBRTdNWWiQ3OEao7Kc6GLJFVu2tVsK3LryHLW" +
       "SMMCpkQwWB4wZCCFXs2reOtWUY7LQxcTI83lnB6fFhTEM5ZLOm6uR3iNbLlk" +
       "0i8ui1xY9zRScxhYi2yrS7jF2gSXaqROr1eS0Jnicd3X2LauYKKUmM0EaSgi" +
       "LpYra93XNuq40EWdYaeCyIVFNDQqyTB0RN+Jw8p6VYmimZ3wFaFtd/S4mjBr" +
       "zvDaiCKt2Ukwo4Iw2azLZsmfBQjsWp1Saq5lvYdFGA4nOmaLPE+07LluVOAx" +
       "XQvsuRNWq1GhYnQbqu8XsUW93cMAWuJzRTJlVo6byrIszIrNOmkySKrV18G0" +
       "gvpwrTiNMNWshxzSUqWR2RGXLtIYOY2ZsJy3ul2CkvhWLOKbdXumcXJgGi0e" +
       "LHN0bVTqcWVLoLCVytRm8mie4mqKxsMgDtSwmgDTzRpdMtSdrlHnegNmXKos" +
       "qKXQSrFyj2uoIOn2ZT0i1HTWJROMlmPVDLh+v1JIkGqfn+niBq+apUidyvMN" +
       "z5XQZWUkRIhYousUPup6g+KIbClU0+r1wn5piFVX/QLfzSCNmIid5nhEBFO4" +
       "iUkNN8bGBA82dmBL+L7Xtyu/Iz9sOLjU/QmOGbZND2fFYwdnNvnfOejEReCR" +
       "M5sjh76n9g9iHr/RBdjxE6xsQ37/ja528834i+9/7gWV+1Tp9N7Z+ntC6GLo" +
       "uE+Z2lozj43sQ0/e+OChl99sH575fun9/3rf8B36M6/jPuzBE3KeZPm7vZe+" +
       "Qjyu/MZp6MzBCfA1d+7HOz19/Nz3kq+FkW8Pj53+3n/8Tuph8LxtbyLedvLw" +
       "7HCqrz05y51m6yo3ubr4+E3afjsrnguhy2BSlRXjyOp2MnPi+IhvvTuEzq4d" +
       "Qz10uudf6wjk2C1CCN113fPO7NLn3mt+rrH9iYHyuRcuX7jnBfFv8qvCg58B" +
       "XGSgC/PINI+erh95P+f62tzItbu4PWt3849PhdA9N/DgEDq3fcnlfnFL/+kQ" +
       "unKSPoRuyT+P0v1eCF06pAOsti9HST4XQmcASfb6snudC6vtJUNy6ojv78Vt" +
       "buk7X8vSB12O3iRm8ZL/XGbft6PtD2Z2lZdfoNl3v1r71PYmUzHlNM24XGCg" +
       "89tL1YP4ePiG3PZ5nSOf+OHtn7/42H4s374V+NBrj8j24PWvDduWG+YXfekf" +
       "3fMHb/+dF76ZH2X+H+R2PGrHJAAA");
}
