package org.apache.batik.dom.events;
public class DOMUIEvent extends org.apache.batik.dom.events.AbstractEvent implements org.w3c.dom.events.UIEvent {
    private org.w3c.dom.views.AbstractView view;
    private int detail;
    public org.w3c.dom.views.AbstractView getView() { return view; }
    public int getDetail() { return detail; }
    public void initUIEvent(java.lang.String typeArg, boolean canBubbleArg,
                            boolean cancelableArg,
                            org.w3c.dom.views.AbstractView viewArg,
                            int detailArg) { initEvent(typeArg, canBubbleArg,
                                                       cancelableArg);
                                             this.view = viewArg;
                                             this.detail = detailArg; }
    public void initUIEventNS(java.lang.String namespaceURIArg, java.lang.String typeArg,
                              boolean canBubbleArg,
                              boolean cancelableArg,
                              org.w3c.dom.views.AbstractView viewArg,
                              int detailArg) { initEventNS(namespaceURIArg,
                                                           typeArg,
                                                           canBubbleArg,
                                                           cancelableArg);
                                               this.view = viewArg;
                                               this.detail = detailArg;
    }
    protected java.lang.String[] split(java.lang.String s) { java.util.List a =
                                                               new java.util.ArrayList(
                                                               8);
                                                             java.lang.StringBuffer sb;
                                                             int i =
                                                               0;
                                                             int len =
                                                               s.
                                                               length(
                                                                 );
                                                             while (i <
                                                                      len) {
                                                                 char c =
                                                                   s.
                                                                   charAt(
                                                                     i++);
                                                                 if (org.apache.batik.xml.XMLUtilities.
                                                                       isXMLSpace(
                                                                         c)) {
                                                                     continue;
                                                                 }
                                                                 sb =
                                                                   new java.lang.StringBuffer(
                                                                     );
                                                                 sb.
                                                                   append(
                                                                     c);
                                                                 while (i <
                                                                          len) {
                                                                     c =
                                                                       s.
                                                                         charAt(
                                                                           i++);
                                                                     if (org.apache.batik.xml.XMLUtilities.
                                                                           isXMLSpace(
                                                                             c)) {
                                                                         a.
                                                                           add(
                                                                             sb.
                                                                               toString(
                                                                                 ));
                                                                         break;
                                                                     }
                                                                     sb.
                                                                       append(
                                                                         c);
                                                                 }
                                                                 if (i ==
                                                                       len) {
                                                                     a.
                                                                       add(
                                                                         sb.
                                                                           toString(
                                                                             ));
                                                                 }
                                                             }
                                                             return (java.lang.String[])
                                                                      a.
                                                                      toArray(
                                                                        new java.lang.String[a.
                                                                                               size(
                                                                                                 )]);
    }
    public DOMUIEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "j6ZZt6IlzzDLaxpL4isMB/4Ln9wNunIeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16eazr1nkn37X9nu3Yfs/OYo8b28/xixNHySUlSqLU17QW" +
       "qYWiSIoSN4lp8kyRFEWJm7hLqds0nWmCFkiD1klTNDVmgGQ6UzhJUbSYDW1d" +
       "FF2CFgW6L8DUmZmi004aIPljOoPJdDmk7r26974lNRJUAI8Oz/Kd7/vO9/3O" +
       "x3POK1+B7gkDqOR79sa0vejQyKLDpV07jDa+ER5SdI1Tg9DQCVsNQwGU3dDe" +
       "9rOX//brH19cOYAuKtAbVdf1IjWyPDccG6FnJ4ZOQ5f3pR3bcMIIukIv1USF" +
       "48iyYdoKo+s09IZTXSPoGn3MAgxYgAELcMEC3Nq3Ap0eNNzYIfIeqhuFa+h7" +
       "oQs0dNHXcvYi6OmzRHw1UJ0jMlwhAaBwb/4uAaGKzlkAXT2RfSfzTQJ/ogS/" +
       "9OMfuPJzd0GXFeiy5fI5OxpgIgKDKNADjuHMjCBs6bqhK9DDrmHovBFYqm1t" +
       "C74V6JHQMl01igPjREl5YewbQTHmXnMPaLlsQaxFXnAi3twybP347Z65rZpA" +
       "1rfsZd1J2M3LgYD3W4CxYK5qxnGXu1eWq0fQU+d7nMh4bQAagK6XHCNaeCdD" +
       "3e2qoAB6ZDd3tuqaMB8FlmuCpvd4MRglgh6/LdFc176qrVTTuBFBj51vx+2q" +
       "QKv7CkXkXSLozeebFZTALD1+bpZOzc9X2O/42Add0j0oeNYNzc75vxd0evJc" +
       "p7ExNwLD1YxdxwfeRX9SfcsvfvQAgkDjN59rvGvzH77na8+/+8lXf3PX5ttu" +
       "0WY4WxpadEP7zOyh330r8VzzrpyNe30vtPLJPyN5Yf7cUc31zAee95YTinnl" +
       "4XHlq+Nfn37oZ4wvH0D396GLmmfHDrCjhzXP8S3bCHqGawRqZOh96D7D1Ymi" +
       "vg9dAnnaco1d6XA+D42oD91tF0UXveIdqGgOSOQqugTyljv3jvO+Gi2KfOZD" +
       "EHQJPNDz4LkG7X7FfwSZ8MJzDFjVVNdyPZgLvFz+fEJdXYUjIwR5HdT6HjwD" +
       "9r96T/kQg0MvDoBBwl5gwiqwioWxq4R1z4GNxADODLeHjNjv5PnD3OD8f76h" +
       "slzqK+mFC2BC3noeDmzgSaRn60ZwQ3spxjtf+/yN3zo4cY8jfUXQs2C8w914" +
       "h8V4h2C8w914h/vxoAsXimHelI+7m3MwYyvg+wAVH3iOfz/1wkffdhcwNj+9" +
       "G6g7bwrfHpyJPVr0C0zUgMlCr34q/X7p+5AD6OAsyua8gqL78+5cjo0nGHjt" +
       "vHfdiu7lj/zV337hky96ez87A9tH7n9zz9x933Zeq4GnGToAxD35d11Vf+HG" +
       "L7547QC6G2ACwMFIBXYLIObJ82OccePrx5CYy3IPEHjuBY5q51XHOHZ/tAi8" +
       "dF9STPdDRf5hoOMWdJScMfS89o1+nr5pZx75pJ2TooDc9/L+T/3J7/w1Wqj7" +
       "GJ0vn1rveCO6fgoRcmKXC99/eG8DQmAYoN1//RT3Y5/4ykfeVxgAaPHMrQa8" +
       "lqcEQAIwhUDN/+o313/62p9/5g8O9kYTgSUxntmWlu2E/AfwuwCev8+fXLi8" +
       "YOfNjxBHkHL1BFP8fORn97wBdLGB2+UWdE10HU+35pY6s43cYv//5beXf+Fv" +
       "PnZlZxM2KDk2qXd/YwL78n+BQx/6rQ/8nycLMhe0fHXb62/fbAeZb9xTbgWB" +
       "usn5yL7/9574id9QfwqALwC80NoaBYZBhT6gYgKRQhelIoXP1VXy5KnwtCOc" +
       "9bVTUcgN7eN/8NUHpa/+0tcKbs+GMafnnVH96ztTy5OrGSD/6HmvJ9VwAdpV" +
       "X2W/+4r96tcBRQVQ1AB+hcMAQE52xkqOWt9z6c9+5Vff8sLv3gUddKH7bU/V" +
       "u2rhcNB9wNKNcAHQKvO/6/mdNaf3guRKISp0k/A7A3mseMsDwedujzXdPArZ" +
       "u+tj/29ozz783//vTUooUOYWi++5/gr8yqcfJ77zy0X/vbvnvZ/MboZhELHt" +
       "+1Z+xvnfB2+7+GsH0CUFuqIdhYOSase5EykgBAqPY0QQMp6pPxvO7Nbu6ydw" +
       "9tbzUHNq2PNAs4d/kM9b5/n7z2HLA7mWnwTPs0fY8ux5bLkAFZnniy5PF+m1" +
       "PHnHsStf8gMrAX5ZUH4ugu5OLCMt2r0ZYGO+6qSoViw2RcVhawYAGNiDBN52" +
       "wJWnaJ60dtNdv61pXD/L+KPgeccR4++4DePUbRjPs+1jni/qBphe+84GxgWW" +
       "AxAyOYrO4BcfeW316b/63C7yOm9N5xobH33ph/7h8GMvHZyKd5+5KeQ83WcX" +
       "8xYMPlhwmfvn03capejR/Z9fePG//LsXP7Lj6pGz0VsHfJx87o/+7rcPP/Wl" +
       "L94iRLgLRObnZmTwDWdkx9sFYAj3VA6xQyR/n95a53fl2XcCbYfFFwroMbdc" +
       "1T6ehEeXtnbtGO4l8MUCvPXa0saObelKATS5XxzuwvxzvD73T+YVaPKhPTHa" +
       "A18MP/wXH//tH3nmNaAVCronyT0RqO/UiGycf0T94CufeOINL33ph4u1DBgR" +
       "98nOledzqvqdJM6T9+fJB45FfTwXlS8CQVoNI6ZYcgz9RNrhKXl44FK2901I" +
       "G13+NFkN+63jH11W5mhLLI/LsI6sYg5Z9Amc5lutLpFy/aVelweCNZc75mCa" +
       "9qUV0euzZYdNsHJlE9IGhg2rNl4Nql4dYeZlvGdGuIz4K3nGhKbcjUgV0Wik" +
       "7JeDbjCKLCKSqM1QJsc9eL2cIr5SSkpwhCb1KplmS7/mKnoFRhMDxuCk3sDQ" +
       "sAbjHZ9BBd4z7cHItGbOVlovuDhFN3MPX5WRjUctgn4vYSYkGWMxOpmstw2v" +
       "YxKjyqghDgmEZwa4jcSiYC/aFO6vnMHUtCh+msk2oQoeUrfxpkzidndsm50N" +
       "vxzWRWoVWwqnesTUE8qmX7c76UjoDidVxxF0O6Sd3hiUrYSpTnWGSSpU1sOV" +
       "bPPl7aiGr6qGiWzlnlZmhlyDWel6h02D1ohXYp7s24NF5BiIZjcERUTbjfW6" +
       "p04VBsvwiTNSpisJEadVRfbrIQycOFh36oqnUuZ64FE2N5Y7CCuN647FW74+" +
       "q8arijuodIS4v5HGTFgtV3g+EpXIx6lFzxw4UbBlaH9QWvDLQFoLVFkgY3tF" +
       "qNaIUJW6VO500NFC4VEhq/C9Lu8zPKr32mww3PT8IG7GbtXHaiu919SbWlMS" +
       "qTWOWJHPARUR/f50NBBaQssTNNmfuaNVZznKRkBhVQ4vrVcxQfcqWdItJ3x/" +
       "OJgOpgu8t9lWGQMZu5MegnUkA6cQpDm01oavNJV+uB5s0HA9Ctv9Qdye1uMJ" +
       "w9klHBEDimoxbcQfDTOFGogzip/g1XBBr3Q503mJabH0ptuWyTKxCcSV3GrX" +
       "eWNRNcNBfziem2ZJGROOvV6NzOWajkYD2lsj5ZGeem12MOXHQbMBB9UOs1kr" +
       "faXV8VmmsWouB9XexHEzQ0tAnFCWUYzOyLo0IKhWa0PVTc+Dt0tzsFTGGK9S" +
       "a3vYHzWq07ncqA9YIoW5mVkVWrWOU9pMtkMG1o0JvTFL+pKeM3WRI9l6NYs9" +
       "lZl1WjCZUXWlsk3KPDH1x57q9BYMhqpMfRMwDVXVmp7ZHrGVsZQxvZQj7aTp" +
       "bJOEQ0YJ3rElNnWotZ8NR+OM7bCySIW2mFSRtYTrjBObji2NKZ2ms5ndH8Kq" +
       "tRK5epmtrZA1a7O8M6kMVH6jb/FxxweylyV8Uh7w6wid4OSw3xQYta+ONDLo" +
       "T117RsBNK+FH0+Wosh6MzfFYJMbd5VzwB/GaazvydJSiHlXBRXHDZhZXYmej" +
       "pM0iGsOq5faoo4hzoWWNuiNGFKpTXrV8Aq84K2Yz9mdIM0K1JEWr0xaCYTBG" +
       "Djx2KozTPq4xC5HLtv1Vx9bX/sY0Vqkm8E1FT7p9rCsaqm8adlBmGHNeXQgO" +
       "zAyZCe7WFlsLDhvEEG/12C05p23ONLjZVNBwmIjcKIGj8SSIMEMc0bjfr0vm" +
       "zE/rVEXb1t1xK13NKg65rGZDn55hmazzi77ptZaabjEuXlmUZ8yy0SqzEiKr" +
       "rY65jtrzaQk3/QRPVvaU0Srb+SZl/WhSwTdxp2N0N2l73qE3nCc4dD+S5yjt" +
       "yti8Up0P5yRZRta5t8jzSdg2MLLjd5aZCoswOsga4xpT5d1po5nMRhVe9For" +
       "s9cVTHqEL3pJpQETJk/H7GawoHHe0iROFvvD4aitslLNJ+LlcjGX6TGb9qZ8" +
       "e5syeK3UajMbQBmOOHhSx7dayjfX1UkpUUMu9isGRvTsTeiuyQFOGPVybIlp" +
       "kMJYKZklhrFcNI0M6feVEO5nM0audLatXtJiZJiZ0Q5Sn8+NeUtGOi7ZQacz" +
       "ls3W3XAjUPMgCPF5i8Lgap+rmnijKkRjVHZa5X41knvuwKg2zF5MSO2Rw6YR" +
       "W49HHE7xotPfZONtVSqVw0wrwQY5HMa1uDfDpsiMNutmWEW3JXTBbuF6VJk4" +
       "0WrTGpOooOml7RIgxWKo20KETMCcac7IGLbdqLJpUKWUlFuix6qjyK53rCk3" +
       "WmyrfZTpLkgZjVuzOHVmUsjo1WYV0SIRBWvKRM7gScCh1cU0YmSnhNc4BVvW" +
       "iXJjs7QmJu6Q2njN9SzWSxE18pltn2FXXGmBENp0RJOzZShJaFlzSdrkZi25" +
       "FbTcVE0Ez5yEU4GPZmGYDNAlXFpP5xWqs6A0Ye2vJNEMu+UlsRLXfb3nMS1p" +
       "4USDRlhzB4zUwYWslOGatemM/ZKB1lBa9AOKpNt2RVvBcUkmp6VSOhiOF2xV" +
       "HuMpEqLJdroh/JSqIzDHcXoTrdXqo7k950qGnAFcInkWLm2kaloySluB7KTb" +
       "biMayVyyxjdDknSWfpJobY8UFnjddhS0i/RarLGAjcGizJbatNqZmPVxw2R5" +
       "SgpkTPLbgsOs2uKwo+jmiunOui7ajaOGPlhxo3giwuVRzaEDfEu5epUpbUOl" +
       "tOTh9Trq0dt5mwlVCtgvvG5543K8WFIzVimRflJj/bqoYl7H3wzUDY8NgM1o" +
       "K1FixaUXIuNuD2mZraWQJJsWYlXQtjKizWU7CFv4UFKNITOySihbIcfbcYx0" +
       "q+iQkrCEanSzhJhQzZaBgkVnNg2YTPKyVnnac4iRvey38bKmTVM3zYGVJVx+" +
       "Y7eaTi+YLFFV67lC0IhRmpYCZJKu5kNl4JUMtoYFxhLr6V5KBaYgV/ByBZv3" +
       "tVKdXY/rAe6Paqa3ssSSxVOzeqMZz4fbRqecWnMkqFIRF3nbOF6QxlBbCa5S" +
       "o5ShphFsisA2bK2cssMQdXYKJ9g4mMFVRFfJWBLKqOljvXFquvCynaCNGQii" +
       "JhI8EDVe5nUVrEYtf6ViwGexXo1f97oluJRhSuwa665XJ6aSKk5UezDTCRne" +
       "2Hjix0xS3zouyfMLeqinmCcSml9ZKZMmEQ/GA8QZDfyFjnQFW82SMjFua4Nu" +
       "0OpgkRJoa3kihfZ0YdXrUylejLIoS6sMOQ5FIUmnEq5uIm3W6Pc82Y8YK13F" +
       "mCUx6ryuzTYkKYq6SG9rtYHMM9UGIsWGHGELXquSli5hYEGYbo2hiydbOYon" +
       "kgcLEzHQ2WYpiScwSXJVSY+dDVPqOLyrTjF8qOopXe5hLGqt9d7a0TVxRltl" +
       "xd+qVrs+byOVaS3SKpzYqZrMZKlW+7K7tgar8XStGtWYQadzlhi2630GJcBk" +
       "CRvFCVK15HJMi7OattvfRFV61hEnlRGVxEtV52sdecUnmDjp6U572+mP0Dq9" +
       "EUeCX+qRBAInvlteeGhn2edcW5brRBxPjFDCxUXT8SVFlu3FCK8EW4wwCI6b" +
       "kdtZKo1iriEb+jprtLcNXZJUlah6+ng+kJgtjYQDymIrwGw6ehJnJWVGLVbu" +
       "QKH8qdgoBetJe+2PU5rGgnmFy/B5W1MUN1o6MQriqy5PovWFb2r9yVZfVdBK" +
       "LeBEjx/IQ2/LjhROjIlNeb1owPOwlG1Kw3mFr007VM9vdHF6KAUd2l0NkpUP" +
       "1kPE4ysuIcG01O26go9NAy+ZpnrYkEMt2la4bWfRX8oK4yJktt7YYwZrzLsR" +
       "bGgCBy9BmJrQAswQfbcZ1YKI5sg5t242JzCIUdVes6JX1tWRVo0TrlKt9JEm" +
       "FyflmTzcos6EDNKAMlsIw4Ogya5VY8drcC5WTkNnBpBJ0cVpMOtPBgB/GnKt" +
       "XO0ZpVrVUa1yee2sp4M6xm+6jUmdVhZGiS7NEC0bVomQXPCiySsA9NuqbTgb" +
       "i4Cns3TmlBh5Uk5LKoV6dHvlDF0K2ax9oiFmyRLuzRhkxSobWJkKhCCViXa3" +
       "TJMTAUwHseLpXkPuzcMmGzTakciLlhoBFXu+u6wDufotTxkKQrmMCY7CiLGk" +
       "DeJ+Fi9JF82WjbqNNBhbmTETN2wu4Q0glmT1ZDGhcGaD0Zg9nK8XW16nLNkZ" +
       "L0W4gXYFdzmhbKI/cQ18hTpdK2mw/tYjuUbUbYWjSmSUlHl/RDeZBqlhrNbE" +
       "tpmHNdK2H2yXrtvHJQ+4PFcehQjrzoIOJicJsxkkM3MQtSi+NhdmazXA+its" +
       "GVa2JFZBN+ZsrNMNuNxN/QVY3Iy1YW01vUbqDc/Kwsp0ECz7bKcmGFRFprZK" +
       "SEoYLRGTCZMs0dJGC1Rgc1UAbHpI90dmh7WbE4pLkBBAol5rukIt3aQxiIdK" +
       "Ot7DVRAjErWhXEfZuLuk1B7vLnSWbVCEQjCoZpQlwBLslTk0xcQQCbU0bIpb" +
       "TfSmMR13GxhCCZNoCFygIqKDajvDwUq0npbAAieI0gKdcCYfilKTHXSTSW9a" +
       "G9FWF2YYX8FVjJo35sGEIio1pQFrA7izlseVRQms3+iImgqoY5SXAjqgmbCO" +
       "KTbC9kcLuust64oS1fv2dguWzMynq1bI4HCVdpspG7t9A3yNvzf/TPdf3/bB" +
       "w8VOycnp6NLG8ooXXscOwa7q6Tx5+8meWvG7eIeDhlObsReOd2UeP73Dd3Sc" +
       "dHSWlO9YPXG7c9Fit+ozH37pZX342fLB0T63EEH3RZ7/HhsQss9t/b7r9jtz" +
       "THEsvN9//Y0P/6/Hhe9cvPA6TpieOsfneZL/nnnli71ntR89gO462Y296cD6" +
       "bKfrZ/dg7w+MKA5c4cxO7BMnyn8s1/VT4HnPkfLfc+tTntvvZr5zZx53OEb4" +
       "6B3qfihPfiCCLpnGydZsd29M//IbbTedplcUfOhEtMvQkXy1I9Fq33rRXrpD" +
       "3Sfz5EeAaQHR2sVGb14w3gv38W9CuDfkhe8CD3skHPWtEe6eneEXjn2rPcFL" +
       "M8+zDbU4rvs3xWQVQhW0/vUdlPHZPPnJCHqD5VrRkaPecs8x8Sx9r6JPf7Mq" +
       "ejd4vvtIRfK3RkUXiwYXT7DvhRNdnFfIz91BIT+fJ5+LoAdPKYTl88Kf3ov/" +
       "+W9C/PyUAnoreIwj8Y3XIz4wWz/wIkOLDP2WWriwV9MLRYNfvoOwv5In/ykC" +
       "gOrbVgRQ9e23R9Xi8HJ3fPHyv33md77v5Wf+W3H+d68VSmrQCsxbXHs51eer" +
       "r7z25d978InPF+fld8/UcAd75+8L3Xwd6Mwtn4LrB050+aZcksdzeY90WfxH" +
       "0I2bj4m//eo6VkNrHQPlvXN33Hx1d/BwtTh2uLo7RHjf+68yw3bnBttiOvzV" +
       "9151jfSo5oOqM3vxfYeHh++//pzvZ3tPPKX1/U77rx8fOH3x1hN5UNhxnpws" +
       "4xdtwzV3V1rGefJrfnZC/2DX6XiVfeP+JIKwPdfIj6eP63ZXNSzv8ORWF6jM" +
       "bsnph3acFoPlyTN3MJU/vEPdH+fJ7wMz0nJmdrzfofmfHTlJ4Ur/+fW4UhZB" +
       "9+8vp+Sn64/ddB1ud4VL+/zLl+999GXxj3f2dnzN6j4aunce2/bpw9BT+Yt+" +
       "YMytgsn7dkeju4n+UgR92x0uzIC522UKhl/b9fkfYCpu1SeC7gLp6ZZ/GUFX" +
       "zrcEyiz+T7f7ayD9vh0YdJc53eRvAHXQJM9+xT+2iOfudNfn+Px1F6JdOBVl" +
       "HSFXMUuPfKNZOuly+hZIjiHFrcbjKCre3Wu8oX3hZYr94Nfqn93dQtFsdbvN" +
       "qdwL3H13IeYkEnv6ttSOaV0kn/v6Qz9739uPo8aHdgzvUfQUb0/d+ppHx/Gj" +
       "4mLG9j8++vPf8dMv/3lxovePJeP3m24qAAA=");
}
