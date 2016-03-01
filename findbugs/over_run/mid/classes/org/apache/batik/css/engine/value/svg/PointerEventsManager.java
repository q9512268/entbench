package org.apache.batik.css.engine.value.svg;
public class PointerEventsManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FILL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          FILL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FILLSTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          FILLSTROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_PAINTED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          PAINTED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_STROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          STROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLEFILL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLEFILL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLEFILLSTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLEFILLSTROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_VISIBLEPAINTED_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                      VISIBLEPAINTED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_VISIBLESTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLESTROKE_VALUE); }
    public boolean isInheritedProperty() { return true;
    }
    public boolean isAnimatableProperty() { return true;
    }
    public boolean isAdditiveProperty() { return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_POINTER_EVENTS_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 VISIBLEPAINTED_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public PointerEventsManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6e8zsxnUf75V0r6TIuleSX5VtWY8ru/ImH3e578pxTHJ3" +
       "yeVySS65L7JpZC7fXC7fz3WUOAYSGzXqGonsOECi/lEbbQM/giBBkxYJFASJ" +
       "HcQIkMJt0xa10yJA3KYG4j+aFnXbdMj93rr3KoIEdAHON9/MnJlzzpzzmzOP" +
       "L30Xui8KoZrvOYXhePGRlsdHttM+igtfi44ous3JYaSpuCNH0RyUvaA8/Ss3" +
       "/ur7nzFvXoWuSdBjsut6sRxbnhvxWuQ5qabS0I2z0qGj7aIYuknbcirDSWw5" +
       "MG1F8fM09APnSGPoFn3CAgxYgAELcMUCjJ61AkRv0dxkh5cUshtHAfQT0BUa" +
       "uuYrJXsx9NTFTnw5lHfH3XCVBKCH+8v/l0CoijgPoSdPZT/I/CqBP1uDX/r5" +
       "H7v5q/dANyTohuUKJTsKYCIGg0jQQzttt9HCCFVVTZWgR1xNUwUttGTH2ld8" +
       "S9CjkWW4cpyE2qmSysLE18JqzDPNPaSUsoWJEnvhqXi6pTnqyX/36Y5sAFnf" +
       "fibrQcJRWQ4EfNACjIW6rGgnJPduLVeNofdepjiV8dYENACk13dabHqnQ93r" +
       "yqAAevQwd47sGrAQh5ZrgKb3eQkYJYYev2Onpa59WdnKhvZCDL3zcjvuUAVa" +
       "PVApoiSJobddblb1BGbp8UuzdG5+vst88NMfdUn3asWzqilOyf/9gOiJS0S8" +
       "pmuh5iragfChD9Cfk9/+W5+8CkGg8dsuNT60+ec//r0P/+ATr3z90OZdt2nD" +
       "bmxNiV9QvrB5+I/fjT/Xv6dk437fi6xy8i9IXpk/d1zzfO4Dz3v7aY9l5dFJ" +
       "5Sv874sf+2XtL65CD46ha4rnJDtgR48o3s63HC0kNFcL5VhTx9ADmqviVf0Y" +
       "ug7ytOVqh1JW1yMtHkP3OlXRNa/6H6hIB12UKroO8pareyd5X47NKp/7EARd" +
       "Bx/0EPiehg6/6m8MfRQ2vZ0Gy4rsWq4Hc6FXyl9OqKvKcKxFIK+CWt+DN8D+" +
       "tz/UOOrCkZeEwCBhLzRgGViFqR0qYSWKYM01AIdwKjuJBkepAVRU2fAw1YCT" +
       "T2UX2El4VBqh//93+LzUzs3syhUwce++DBsO8DjSc1QtfEF5KcGG3/vKC394" +
       "9dSNjvUaQ38H8HB04OGo4uEI8HB04OGo4uEI8HB0Ox6gK1eqod9a8nKwFzDb" +
       "W4AbAFEfek74e9RHPvn0PcBQ/exeMFVlU/jOwI6fIc24wlMFmDv0yuezn1r+" +
       "ZP0qdPUiQpf8g6IHS3KuxNVT/Lx12TNv1++NT3znr776uRe9Mx+9APnH0PFq" +
       "ytL1n76s6dBTNBWA6Vn3H3hS/vUXfuvFW1ehewGeAAyNZaBOAE9PXB7jAgQ8" +
       "fwKnpSz3AYF1L9zJTll1goEPxmboZWcllQk8XOUfATr+IHScXHCSsvYxv0zf" +
       "ejCZctIuSVHB9Q8L/i/9yR/9l2al7hNkv3FurRS0+PlzaFJ2dqPCjUfObGAe" +
       "ahpo9x8/z/3cZ7/7ib9bGQBo8cztBrxVpjhAETCFQM0//fXg3337W1/45tUz" +
       "o4nBcppsHEvJD0L+NfhdAd//Lb9SuLLggASP4sdw9OQpHvnlyO874w0gkwPc" +
       "s7SgWwt356mWbskbRyst9n/feLbx6//t0zcPNuGAkhOT+sHX7uCs/G9h0Mf+" +
       "8Mf+xxNVN1eUcmU8099ZswPcPnbWMxqGclHykf/Uv3rPL3xN/iUA3AAsI2uv" +
       "VfgHVfqAqgmsV7qoVSl8qQ4pk/dG5x3hoq+di2BeUD7zzb98y/Ivf/t7FbcX" +
       "Q6Dz8z6V/ecPplYmT+ag+3dc9npSjkzQrvUK86M3nVe+D3qUQI8KwLmIDQEM" +
       "5Res5Lj1fdf//e/87ts/8sf3QFdH0IOOJ6sjuXI46AFg6VpkAgTL/R/58MGa" +
       "s/tBcrMSFXqV8AcDeWf1372AwefujDWjMoI5c9d3/i/W2Xz8P//PVymhQpnb" +
       "LNyX6CX4S7/4OP6hv6joz9y9pH4ifzU0g2jvjBb55d1/v/r0td+7Cl2XoJvK" +
       "cSi5LIEXOJEEwqfoJL4E4eaF+ouh0GHdf/4Uzt59GWrODXsZaM6WBJAvW5f5" +
       "By9hy7tKLX8IfO8/xpb3X8aWK1CV+XBF8lSV3iqT91dzck8MPeCHXgy41ED4" +
       "dy2q4tYYcGK5slMN9hwortacqCJ+WwzVXnt5OsSAwJYO0FamzTJBDwbRuaPx" +
       "PF8NmV8BGHMfctQ9qpf/03dgvsz+7TIZlsnohN132I5y6wR3liDsBmZzy3a6" +
       "J/zfrCy+nKBjPi8x+dzfmElg0Q+fdUZ7IOz91J995hv/8JlvA7OjoPsqZQBr" +
       "Ozcik5Q7gZ/50mff8wMv/emnKlAFiMp9bnjzw2Wvi9cn6uOlqEIVudByFE8r" +
       "7NPUStq7ehsXWjuwXKTHYS784qPf3v7id758CGEvu9alxtonX/r7f3306Zeu" +
       "nts4PPOq2P08zWHzUDH9lmMNh9BTdxulohj9+Vdf/Jf/9MVPHLh69GIYPAS7" +
       "vC//m//zjaPP/+kf3CaGutfx3sDExg9/nWxFY/TkN11KWhOd57mjF0uzJnLo" +
       "YDMxMKNVZ9rCarn1BMQ3Zxlly3wkRtQ0X8Qtl5cLUeXUnq4WprjbGBN15AdS" +
       "fZtlk9UWh/N5Rxza43i6rW/rLa8jTM1tIU4ZokHtqPGuJjD+ENngZMud1+1N" +
       "X01Vtt8fDPoqLsmJtAr6aYrAdS2FkdqmobphwAizuhLvgsHQFAZSgAxtZKh3" +
       "dZFKWqRF0phNMK6xGWl9uNez+q1uLUXYPmnMLJmzUJGTKaM1rAtOwhDYFJmP" +
       "xtOx5VkMzdvkZKHptoFEg8wZLvzFOPC1adef7YQONdTiWcs35htsjkxlY4mr" +
       "+G5FhfbGHeNGbTXczUWTGjbClFoZnFf4fEPfyINxPTGNLklMlgyiRRLGrIZq" +
       "Fg9mlslQg+3CMfaCG5P8dIss+4XkODM+Nw2+WXS1jRkbSmo3yQHe4JZkv95r" +
       "ERixkwlCnFjBWPBlYj8yLY9rrQ1xqcYpi6yUaSobYYcVplQYjHHZY1ZZTHjU" +
       "aNbFPV/uM5hKcVnd6zTkYaGKRmNRR+fBAh0ym8itz3hVoNx5f0BIoigVYhKy" +
       "uyG5wZZOTK/V7nJQdOjBHEmleoMrGliDHy1owe0vsYw3cTwT0NnUcqZ5iKVh" +
       "qzlU7A4mY/xes5tLajtZ8PV+3DB9foFRYwIfmTtPgOdEvJF2IFjKKNbYtVsr" +
       "S/bdxiLKFtQOFky22KK8SiC5mojypkPGs2g0xjNdGKKMsV/J4lTYBkpLsZmt" +
       "usr7QstAGbkY4eIA7BH8ieihdANVzZYRTabOjGthnDCj/GDmzRqYu8K3+WQj" +
       "16lWgM/yEYFLburXUmO2GC2yWQNdGUnQl4hs1xtN7LwesXBjr0fJJuOCJd0T" +
       "pnqB7Ulvu3fczJ/O+c4unFuYOtt3jQGzomd1mBrMelrP4obYYK21jPZegdNk" +
       "M0o0lWvj7Xw3NztyMzYTmpp42mCMwCqt2NZKpzsjyyGSYLwk3WTPu0lnz5GE" +
       "y8kY5hPheF+PCINZm7UOzOiJ1qvrUY2bhDE/G80dFfWzJZ4EkwUiROuWuwzR" +
       "ZIjtU95citZay3qr9gJLkcwnBrXY1vjpYODzDrPtWwGItvuGZ/DT2aKxwNcN" +
       "SpDN1Trnxigbu8yYnxHzwsP91iofwNGug/W92bBhLlh8gluC5206KrUO5nlz" +
       "IhotxMNq5GJRZ/LZADaKeIU5GjkYrGK0wAaB35riIj5BlYycdSjTpHEBQ53B" +
       "rDVRcmtkT9DtTjTthJxOsmIdDbE1bmHFdhzrcNozncDl3QFn9lqboNXcTK2s" +
       "1fUXrNhtBANr1YyxdgsmPSEvBBVLJNVaezgYczuNZtJgPJyJouEU5FhCLXww" +
       "HfWmFq7bRb2/7YV4b0aDPavQQkWiK29dMN2blI15Ad0OlmagoUFh+56fDxvA" +
       "KQg8CvnpYu90ZXbdLNq9cKbXhCGRCziPqLttQ1oy2oBeLHkSDJYtCytebdD6" +
       "cm/x7fZi4NpZM202u6nUNpS9wWNUUYyQ4UaqIaa4L7p8x6hPa5occ6md8Iii" +
       "E846HrLkhB3J1p4ltltZH3UQK+05o7wzowF71h54dY1B1zgh8tnYQ5vjuYdo" +
       "qprxMoZM2v58rfhYSxQCPxOkgbM1E2o87bBBBouiGVEi0ueL6Qhtaehya9WI" +
       "Caym+8mk2VdzIffbYh7wXTrNO3N1KOueRC6icbyWO0ywE7O8ru+7K7U29/ri" +
       "tEvQAiruiBq2jH0kI3N8kw1G6X5nAuhI12TcnsQ1otUaDt1FB7OXnJlsi17O" +
       "tWrsoM00G95mAjb648Lv7NFBU6QinwFw6sURIgx2xWaQT+am3G2IqD6i8OEO" +
       "NHRTE6BQPGn3O3ATZdSuMt0URZ2m+i00Tfv+XjZqDTBRanfopwTFsLrcDzlK" +
       "w3FdVGq9dayN0qXA7rku3cvbtdncYCczEo9wghExSRpupqRodHq2urVyxl+6" +
       "4bArM0zADsikuZVZxDICLh0EWJ9F9OYgwXxutV5mbVht2TJbV3g1oyPGkKWB" +
       "nAjDPkns5/I+CtABzfZmskpPUQn4XspuYCew1/saZWUbY7Uc4TRDhFmbn7Is" +
       "vt066irddJRuP0HIlY9x26a38KWRNtlg9MZcoAuD5KPBcIjuEV9fKfMdUXQI" +
       "X9QllOVli/drerONqBOxnmGtrMdpKcXMex1FRMztlEnmtojQkQWW9bwTd/VG" +
       "raHomp6sW/ue1+qWW++R2E6IDSz2NXa9MUKxv+emhLWiOp18OtVxqdGO6ZHd" +
       "XSfTZtZyHTI2KVvfz6Z4Q5v3u2y6MtNina32vcDqoHJdLhZxn+2hdtRG45Up" +
       "SmtuMUS6eYwsSasfIiFnKsC/ncFu1Z+JBVtjMLdBz2F7xnUSaUZ3OiOpS1BJ" +
       "tNQa3HbWac5yx96sdN9DirZBC5kV1ElhaVAzMYgTNFP8AvWpsWVhbpRE5Qq8" +
       "Ws3U1kptNYhpHBm+xLgTqk3OCrS9JcQ4iP16r7neKDWyNcxr3LqoJ/1i5TTr" +
       "OL+WbbQnj7tR3jYXvr2MZZ0bYMg4bndla0EqEtJtssWw3udtHd6vuy2ahFPK" +
       "cp3AMQJbxs0tJ6q7XDK3ESIVe3UdioVCEi0tpFvFck22c9VZxnyd2sl4PAOy" +
       "pOlU6+F0vm+taiwSz9gu5QyDPaeIhZ0682bIpqTtjtMRxu3TnsLYLkmFypxt" +
       "JNFID4hhu13Y4ro9SorQb2DrjTh2t915LDW0gokzOeAY1dYmk1aSjaKtXQiU" +
       "Pdw1LBAbzWyi7aDjThxROyPbAY9tS21y3Nkx+brfkUys5s58bLkebMkdy8ZR" +
       "liZKUxKmm3DOCJwpsZqk8wpMSKELAIpwnRG2lBb77Sxatjk2CFQiDiJviKZD" +
       "b9gfekui02+JOjdX8645bLqDcKzIZJ50YYo0WzbRQ3VH0nYko6g6nfW6FJkk" +
       "khXscXau1RRSb47susLVts0NnxnAznaBjS6cTh7rjF1vaGxz7M+QiOO6Ta3b" +
       "b/i8GuzBeug68pZbuQq51gfRNB/neUHEM1hkQIyWrFyKl7A0WEk7Pt8Mc5zC" +
       "6IHC1HM9RNhE3QSDOYtFSJ0PNI5B6YgXsR7cssR+zdjP68M9UEZfDBZDw4r7" +
       "QrGtd4nFRhzwcKuOIcnAZ7prz+1mGB4OVwt93OUVuSa048GWnTmasx5tRw4K" +
       "r2A9SsOlOjEo17OACPOiY6oWLdNWVl8TZEAyBDPHhUUWpRvODbaj/ag/TXOV" +
       "IMeNgpJGrTrrii48dyNkgJGbvmOoa8EjpI4YrJdRzxDDfBQOJxONtinE3Au7" +
       "ZraRUJsmAh/zV1qfKf2V2JBpr0dt4sUiIUcRvkcafNCvzeOFaDWsaZsb5U7X" +
       "tEW4BW9EC2PwVSI5EbLicp5Z23OxP+2z8xgpdpod1LcTl+Sa0W7TkYDoy2lv" +
       "XfDRLKlrYsforPBd1zZXOFaEUxnO0l0RwkFKBe0OhlDNdOkVGorobpMl9xqi" +
       "5z2eW7Y3DNvk6q5qs/OUTxIjGdtbSXLae3JUn/U9dtsez6ko0Hc2jzDqyIjD" +
       "WtCPuhYWzqZ2Q2vJxRpfBdoWW7P0lpFMyioDPG9ujgiWTjPb51wceC+Z1caY" +
       "jMx7lh+JRc8RpkTNXc/X+CSod1YY33QJIUV3ezRz4zQAeymEXuasXExXdGda" +
       "Y/ZkEy92k52OD1h22h/hy447hg2rmATbOlxE4yIW57suCDObJDkBHktFIV6g" +
       "lioJ4WIOZxbtAn/FW63dfrn2iJTaaw63pHnJl5qhFbV8ojUtfAxDXHXtJfNp" +
       "sQqZNd+pqWuSS9oLFisa+KK7RWvoLKyTmx3ZaxUr0+EAYuA1wSTYpZZ1gi7Y" +
       "fizra67ZVZc9PZlheEpLyURZgK1STUv61qLe1ePaElidEIyKnHcQpYvlYXe8" +
       "tOpsJ4DRac4I9W3a5ORBqIoZxWC9rPC3hCupsIA0WHzl0nSnn23aYA0jlQ2I" +
       "A7yuu5LldsdaNuy5O6G5aDiF1QYzRnPEavF9bir0VsJ+T9Jy7tGUWSsGXEu3" +
       "9jW6m9RVsHP94XJLq7++U4VHqgOU05s/2+mWFbPXsZs+VD1VJs+eHlZVv2t3" +
       "OQg/d1gIlScE77nThV51OvCFj7/0ssp+sXH1+JBVjqEHYs//IUdLNedcV9dB" +
       "Tx+480nItLrPPDv8+9rH/+vj8w+ZH3kd1xvvvcTn5S7/2fRLf0C8T/nZq9A9" +
       "p0eBr7ppvUj0/MUDwAdDLU5Cd37hGPA9p5p9rNTY+8A3PNbs8PZXDLe1giuV" +
       "FRzm/i5n2D9+l7qfKJMshh6zorFraqEVg91c6FV31xXBj54zmI/E0PWN5zma" +
       "7J4ZU/5aRzPnh6wK4ovSlwef9LH09Jsv/afuUvcPyuRnYuitVoS61k6Oy8uH" +
       "E/HLuo+dyfmJNyrns+ATjuUU3nw5f/4udb9QJj8bQ49a5UOG6qjuDlL+3BuQ" +
       "8kZZ+AT4pGMppTdfyn98l7ovlsnLMXTD0OIT8U7v9i7Z8T3W8QuTSup/9Aak" +
       "frQsfAp8m2OpN2++1L96l7pfK5MvX5SaOcaf2ZmIX3kDIlZLwJPgs49FtN98" +
       "EX/7LnWvlMlvHkQcaLqcOIcrm5Nrgfe/9rXGWftKG//iDWjjbWXhM5UCDr/g" +
       "zdfGN+5S90dl8rUYehhoY6xqblxeHBzeE5FnEn799UiYAwi83ZuE8lL1na96" +
       "QXV49aN85eUb97/j5cW/ra7lT1/mPEBD9+uJ45y/AzuXv+aHmm5VcjxwuBHz" +
       "qz//Ooae/Ru9nQCuC9JKgm8eSP8khp56TdL4+ErnPOF/iKF33YUwhq4dMudp" +
       "vgU0dTsawBZIz7f8TzF083JLwEX193y7P4uhB8/agUEPmfNN/hz0DpqU2e/4" +
       "J0bffG11nVnH8XzmVy4GaqfW8uhrWcu52O6ZCxFZ9QzvJHpKDg/xXlC++jLF" +
       "fPR7nS8enj4ojrzfl73cT0PXD68wTiOwp+7Y20lf18jnvv/wrzzw7Em0+PCB" +
       "4TMnO8fbe2//tmC48+PqNcD+N97xax/8Jy9/q7q9+3/9jX4qHykAAA==");
}
