package edu.umd.cs.findbugs;
public class StringAnnotation implements edu.umd.cs.findbugs.BugAnnotation {
    private static final long serialVersionUID = 1L;
    public static final java.lang.String DEFAULT_ROLE = "STRING_DEFAULT";
    public static final java.lang.String STRING_CONSTANT_ROLE = "STRING_CONSTANT";
    public static final java.lang.String STRING_NONSTRING_CONSTANT_ROLE =
      "STRING_NONSTRING_CONSTANT";
    public static final java.lang.String REGEX_ROLE = "STRING_REGEX";
    public static final java.lang.String ERROR_MSG_ROLE = "STRING_ERROR_MSG";
    public static final java.lang.String STRING_MESSAGE = "STRING_MESSAGE";
    public static final java.lang.String PARAMETER_NAME_ROLE = "STRING_PARAMETER_NAME";
    public static final java.lang.String TYPE_QUALIFIER_ROLE = "STRING_TYPE_QUALIFIER";
    public static final java.lang.String REMAINING_OBLIGATIONS_ROLE = "STRING_REMAINING_OBLIGATIONS";
    public static final java.lang.String FORMAT_STRING_ROLE = "STRING_FORMAT_STRING";
    public static final java.lang.String FORMAT_SPECIFIER_ROLE = "STRING_FORMAT_SPECIFIER";
    private final java.lang.String value;
    private java.lang.String description;
    static class QuotedStringMarker {
        public QuotedStringMarker() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVXbWwcxRmeu/N37JztJE4IiZOYC5JDuCXiS8hpG8fYjdOz" +
                                                                  "c8QhVc9tjrndOd/Ge7ubmVn7bMpXpYrwB0UiQFoJ/wqqVLUQIVD7A5ARUktF" +
                                                                  "WwmEWmhF4CdViSBCgh/pB+/M7N1+nA384aSb23vnnfd7nvfd31xBrYyiQWLz" +
                                                                  "LF9yCcuO2zyPKSPGmIUZOwG0ov50Cn926qPpu5KorYA2VjCb0jEjEyaxDFZA" +
                                                                  "O02bcWzrhE0TYogTeUoYoQuYm45dQFtMNll1LVM3+ZRjEMFwEtMc6sOcU7Pk" +
                                                                  "cTLpC+BoZw4s0aQl2mh8eySHunXHXQrYt4XYx0I7grMa6GIc9eZO4wWsedy0" +
                                                                  "tJzJ+EiNoptcx1qasxyeJTWePW3d7ofgaO72phAMXUp/fu1cpVeGYBO2bYdL" +
                                                                  "99hxwhxrgRg5lA6o4xapsjPoQZTKoQ0hZo4yubpSDZRqoLTubcAF1vcQ26uO" +
                                                                  "OdIdXpfU5urCII72RIW4mOKqLyYvbQYJHdz3XR4Gb3c3vFVeNrn45E3a+adP" +
                                                                  "9b6QQukCSpv2jDBHByM4KClAQEm1RCgbNQxiFFCfDcmeIdTElrnsZ7qfmXM2" +
                                                                  "5h6kvx4WQfRcQqXOIFaQR/CNejp3aMO9siwo/19r2cJz4OtA4KvycELQwcEu" +
                                                                  "EwyjZQx15x9pmTdtg6Nd8RMNHzM/AAY42l4lvOI0VLXYGAioX5WIhe05bQZK" +
                                                                  "z54D1lYHCpBytH1doSLWLtbn8RwpioqM8eXVFnB1ykCIIxxtibNJSZCl7bEs" +
                                                                  "hfJzZfrg4/fbR+wkSoDNBtEtYf8GODQYO3SclAklcA/Uwe59uafwwCtnkwgB" +
                                                                  "85YYs+L53U+vHto/uPqG4rl+DZ5jpdNE50X9YmnjWzvGhu9KCTM6XIeZIvkR" +
                                                                  "z+Uty/s7IzUXEGagIVFsZuubq8f/8KOHf03+nURdk6hNdyyvCnXUpztV17QI" +
                                                                  "/T6xCcWcGJOok9jGmNyfRO3wnDNtoqjHymVG+CRqsSSpzZH/IURlECFC1AXP" +
                                                                  "pl126s8u5hX5XHMRQhvgi3rhewipj/zlaFarOFWiYR3bpu1oeeoI/5kGiFOC" +
                                                                  "2Fa0MhRTyZtjGqO6JkuHGJ7mVQ1NZ8GmqqTgdmcFp/vtiq8J7zYtJhIQ+B3x" +
                                                                  "a2/BjTniWAahRf28d3j86nPFN1VJiWvgx4WjO0FbFrRldZata8vGtWXu8RzI" +
                                                                  "jiJPYTpPKEokpN7NwhCVbEjVPFx6QN3u4ZmfHL3v7FAKqsxdbIE4C9ahSPcZ" +
                                                                  "C5ChDudF/fn+nuU9lw+8nkQtOdSPde5hSzSTUToHMKXP+ze5uwR9KWgPu0Pt" +
                                                                  "QfQ16ujgFSXrtQlfSoezQKigc7Q5JKHevMQ11dZvHWvaj1YvLD5y8qFbkigZ" +
                                                                  "7QhCZSuAmTieFzjewOtMHAnWkpt+9KPPn3/qASfAhEiLqXfGppPCh6F4ZcTD" +
                                                                  "U9T37cYvFV95ICPD3gmYzTHcMYDDwbiOCOSM1OFb+NIBDpcdWsWW2KrHuItX" +
                                                                  "qLMYUGTJ9olli6peUUIxAyXyf2fGfebdv/7rVhnJepNIh7r7DOEjIWASwvol" +
                                                                  "BPUFFXmCEgJ871/IP/HklUdnZTkCxw1rKcyIdQwACbIDEfz5G2fe++DyxXeS" +
                                                                  "jRJGNenC5v/DJwHf/4mvoAuCwpL+MR/QdjcQzRUKbwxMAmyzAABETWTutaH6" +
                                                                  "zLKJSxYR1+Y/6b0HXvr48V6VZQso9SLZ//UCAvp1h9HDb576YlCKSeiitwZh" +
                                                                  "C9gUYG8KJI9SipeEHbVH3t75iz/iZwD6AW6ZuUwkgiI/DMKo22QsNLneGtu7" +
                                                                  "Qyx7Wbi0o7cnNAMV9XPvfNpz8tNXr0pro0NUON1T2B1RxaOyAMoyyF8iiC52" +
                                                                  "B1yxbq2BDVvj+HQEswoIu211+se91uo1UFsAtTqMF+wYBbSsRSrI525t/8dr" +
                                                                  "rw/c91YKJSdQl+VgYwLLe4Y6ocAJqwDQ1tzv+YYsdvitBtVQU4SaCCILu9bO" +
                                                                  "73jV5TIjy7/f+uLBX61cltXoKhnXhwXeKNdhsexXgMtRG5OTXa0RMMnf9RUB" +
                                                                  "i8qlaOd6U4qcsC7+7PyKcezZA2qW6I92/nEYbH/7t//+OXvhwz+t0Xba/Ckz" +
                                                                  "rBDuT3OfkRzbAO2+SZ8Ck7c1jb9qZNOfW0l3bF259+8S4xpjVTdASNmzrIZx" +
                                                                  "YUPFKE5J2ZR1162qz5U/93C0aQ2DOAjzH6XdecV9gqOugJujpB7Z/iGHSUdt" +
                                                                  "c5SCNbxZABJsisdZtx6MXlkuYoLNqnGtlmguiTsVysrnkXVLM5TtGyLXVb5t" +
                                                                  "+EGc8tT7BjTolaPT91+941kFy/Cesrwsp1MYthX4N/rannWl1WW1HRm+tvFS" +
                                                                  "596kjxuRthC2TTyPQklLLN0eAyyWaeDWexcPvvqXs21vQ73NogSGHM2GZn0V" +
                                                                  "KUA9Dwp7NhcMI6G3VYmkI8O/XPru/vIn/5S3zR9edqzPX9QLT7w7eWn+i0Ny" +
                                                                  "vG2FCiC1Ary4sLuX7ONEXwCY6PBs84xHJuGdaKOoPSwKV8bBD19Pgyr6M0dD" +
                                                                  "TS8Ya0w1gESLhB52PNsQYnoAQANK5LXHr+cuz3VjBwJKI3Wbm30t6nc/ln75" +
                                                                  "XH9qAu5PxJ2w+HbmlQS3Lzt4E5IEmcdesdxcU/0yVcxNua7fP9t3uarAq4pF" +
                                                                  "kDlK7POpAjITCtrEX3U75KwvsYt+CX8ikjLjEAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "uMwgVFSyji1VLlcMWVajNcEzhnjoUzRN5Pr0uDBn2wtmJS4VTmw1tXVe6Bca" +
           "Sl7NL+sjves7BbyWlzOy1isrRY4LZxTvLXPTaqVZWXUKbcomudoc61MTpcvF" +
           "Vr1OGVV1rtPaoGb7TiARC2MudHK4WZwt48KYM/oqtxBYui5zfZTq6lMvL3fY" +
           "cmBFLoqV/ZzaWhdYQBbay5VaY7hIrYW1aDWVuBjD47I3H2hgUuxqpX6n21x3" +
           "UJIUCzm7YC9ZOjtiBLFBWq6Aj2lTz+IKJ7XXeKGK2WKT8ior0MQ0l2fGDFCc" +
           "Uj/yLHfRKenCqO5UsNUMuiOOgaV0W7xE2YRSC0yjtZYMf1JADaWfiWa8W+1W" +
           "QA2IRqnBVjmRzfOqTc5slUSHkY6XQ9mIIgo4s2hSKeGiGGQYPD/MLJvARcPe" +
           "olHw7UxVwqee1q3hWaEszp3peL1smGG5TQ06RYHWJXo5668zQ7BCA4JeD4Va" +
           "Q57Qo3oghaGyKBloqc02jWw+4wz72qxodrXVakk5MErWYIQRHI0OijGljtVG" +
           "i3Vn5Wlj3l0ZfTYfOdUucBfT5mo+amSo/iLgeW8tNVF62LdrVJ3CSKHn2Viu" +
           "GJRC3BRwodnpc+ZyYuV9U48sb4qubbku+2x9bIn9vOKFmKvrLo3is4ZVZ6lc" +
           "Xc52zP5gJYFpY8EWW7Ow2WgR8xGHdaVSY75YDCbaXK176BJYi1KLWIugZdJc" +
           "ppKP5RxamQ4ca0zKZt/IlbT8tFR0evUuNmpZ4+UEhs2UzdaVut+3NUkGcmnZ" +
           "AGMhLPXX9NRq9cSB12vX3JnXJbqRSY2U2nTUq8dFrpsPC9LcaDL5JVEn24sg" +
           "1hS6VqDKssn3VInCKbMaanXUcDJOOCzbUabkzDjAanxP03GTX/OD4cBtdtpC" +
           "L7PW8TDql9vjSS/M9gBncFgxnE7qvOADzjZ4V19zbWuiEhzeajf1ZYfDME1a" +
           "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" +
           "/M1XvpVetP8HfiidVLMbAAA=");
    }
    public StringAnnotation(java.lang.String value) {
        super(
          );
        this.
          value =
          value;
        this.
          description =
          DEFAULT_ROLE;
    }
    public static edu.umd.cs.findbugs.StringAnnotation fromRawString(java.lang.String value) {
        return new edu.umd.cs.findbugs.StringAnnotation(
          edu.umd.cs.findbugs.util.Strings.
            escapeLFCRBackSlash(
              value));
    }
    public static edu.umd.cs.findbugs.StringAnnotation fromXMLEscapedString(java.lang.String value) {
        return new edu.umd.cs.findbugs.StringAnnotation(
          edu.umd.cs.findbugs.util.Strings.
            unescapeXml(
              value));
    }
    @java.lang.Override
    public java.lang.Object clone() { try {
                                          return super.
                                            clone(
                                              );
                                      }
                                      catch (java.lang.CloneNotSupportedException e) {
                                          throw new java.lang.AssertionError(
                                            e);
                                      } }
    public java.lang.String getValue() { return value;
    }
    @java.lang.Override
    public void accept(edu.umd.cs.findbugs.BugAnnotationVisitor visitor) {
        visitor.
          visitStringAnnotation(
            this);
    }
    @java.lang.Override
    public java.lang.String format(java.lang.String key,
                                   edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        java.lang.String txt =
          value;
        return txt;
    }
    @java.lang.Override
    public void setDescription(java.lang.String description) {
        this.
          description =
          description;
    }
    @java.lang.Override
    public java.lang.String getDescription() {
        return description;
    }
    @java.lang.Override
    public int hashCode() { return value.
                              hashCode(
                                ); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (!(o instanceof edu.umd.cs.findbugs.StringAnnotation)) {
            return false;
        }
        return value.
          equals(
            ((edu.umd.cs.findbugs.StringAnnotation)
               o).
              value);
    }
    @java.lang.Override
    public int compareTo(edu.umd.cs.findbugs.BugAnnotation o) {
        if (!(o instanceof edu.umd.cs.findbugs.StringAnnotation)) {
            return this.
              getClass(
                ).
              getName(
                ).
              compareTo(
                o.
                  getClass(
                    ).
                  getName(
                    ));
        }
        return value.
          compareTo(
            ((edu.umd.cs.findbugs.StringAnnotation)
               o).
              value);
    }
    @java.lang.Override
    public java.lang.String toString() { java.lang.String pattern =
                                           edu.umd.cs.findbugs.I18N.
                                           instance(
                                             ).
                                           getAnnotationDescription(
                                             description);
                                         edu.umd.cs.findbugs.FindBugsMessageFormat format =
                                           new edu.umd.cs.findbugs.FindBugsMessageFormat(
                                           pattern);
                                         return format.
                                           format(
                                             new edu.umd.cs.findbugs.BugAnnotation[] { this },
                                             null);
    }
    private static final java.lang.String
      ELEMENT_NAME =
      "String";
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput)
          throws java.io.IOException { writeXML(
                                         xmlOutput,
                                         false,
                                         false);
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean addMessages,
                         boolean isPrimary)
          throws java.io.IOException { edu.umd.cs.findbugs.xml.XMLAttributeList attributeList =
                                         new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                         ).
                                         addAttribute(
                                           "value",
                                           value);
                                       java.lang.String role =
                                         getDescription(
                                           );
                                       if (!DEFAULT_ROLE.
                                             equals(
                                               role)) {
                                           attributeList.
                                             addAttribute(
                                               "role",
                                               role);
                                       }
                                       edu.umd.cs.findbugs.BugAnnotationUtil.
                                         writeXML(
                                           xmlOutput,
                                           ELEMENT_NAME,
                                           this,
                                           attributeList,
                                           addMessages);
    }
    @java.lang.Override
    public boolean isSignificant() { return true;
    }
    @java.lang.Override
    public java.lang.String toString(edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        return toString(
                 );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZeX458GJK35BOi4IoL4TsxhQz7/lMo8Jt33+NHMLxwODYYuZ4Ymg2U/YaDvO" +
       "JQHUXYpZLyPTDMo2FMXnoXMcCi86Rpa6GNJlFurLJoJCP2EBDA0F1GUxo8De" +
       "gJc9twFmPn/26rEON/IrLMBXTAR7fsICGNoZUHc5Zgz2nkHBGGxVrT33IpfP" +
       "9PjPCsm6Xegxc4tgTnbu8yd7BtbhK+nVFj9XTwTZfsJ8V3toPmd1TwDjezHb" +
       "DY6Sbof3MmM0vqv6VVWmgjIa59cdIwPHjewGi6YbJoJzP2H+HvYvnNfvBHB+" +
       "ELPbGV4cwCs4tAcv9oW+4rB3xzFyrhiI7rcA758I9vyEBZDz3YC6xzB7ANwD" +
       "U50XIJdbPXSM9vWTId1tQb17InjzExYcuZY998ln5Qi8N3bmmJZjnMXDwVLM" +
       "i1KSGol3xvIYt9rx1s8x+xGwP6JLjILM7cUhwRPHiP3NkB6wCHtgItj3E+bh" +
       "raJwYBj6KWY38YxT9by/S36KN3gRs2f8uXz2GO1ZiyE9bsF/fCK49BMWsMr/" +
       "GFD3FmZ/YGSqZHRLA4qUkURBYZx4h7zXjqH7fNLC++REkOcnzN+6EpylIwEM" +
       "fojZO/4+9N3Pgbw8fk/3nPrhTcE5Jf/hYf5XgvjQgfrq2Qc2v8zPkAv/OVCX" +
       "INWZnCy777K5nis1nWYkTnydebONX9YJ/Rt8XBlPCZTYjzju0FGz9SeM1Dit" +
       "GQmL7upwGGIiqxqiUcjdlZOhCCrxsVKz/WvJsVTedL3z3aTx48+Zo520FLq4" +
       "7/niKTj/hxr7xDpn/ktNSnz4wPkdlx1Zc5d5z1iUhZ07UUptglSZV565UDz1" +
       "XuIrzZZVuWnF0WmPTFlufx+Ybg7YsfL5js3h7YqQhhM8z3MJ12gq3MV99eDa" +
       "nzyzu/K5MAltISEB5mhL6V3HvJbTyYItidILXr2Czm8HN6/45o51qzLv/96+" +
       "VxgqvkPqbZ8S+25+Jf7I0Mfn8f/gmAwWQPP8EuaGHUqSisN60W2xaWh7Alou" +
       "58Gib2qhFG+lM7K09KZc6V3+Glkdofp6NaekUczUBKl1SsyZ8HwoyGmap4NT" +
       "Yk0d5rx9Xx7ZB/tLJdo1zb5IeKfGV2CmfPiOdjqXP+LTvP8BusqHqVs3AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbDsWHlevzczbxaGeW9mGGYYwzDDzBhmGj+1elPLAxi1" +
       "Wt0ttaRWt9SLBOGhtVvd2rdWC+MAFQIOZYKdYXFiU0nACzY2JGUHVwUcXK54" +
       "CY6rSJG1KuBKucokNilTThyXSUKOdPuu794LF97LrTqn1Wf9vv/8/39+qY/u" +
       "p79RuisMSmXPtbYLy42u62l0fWU1rkdbTw+vU3SDk4NQ13BLDkMBlN1QX/PZ" +
       "q3/5rQ8tr10uXZFKD8uO40ZyZLpOONZD10p0jS5dPSwlLN0Oo9I1eiUnMhRH" +
       "pgXRZhi9QJdecqRrVHqG3ocAAQgQgAAVECDssBXo9FLdiW087yE7UeiXfqx0" +
       "iS5d8dQcXlR66vggnhzI9m4YrmAARrgn/z4FpIrOaVB68oD7HuebCH+4DL34" +
       "0bdd+6d3lK5Kpaumw+dwVAAiApNIpftt3Vb0IMQ0Tdek0oOOrmu8HpiyZWYF" +
       "bqn0UGguHDmKA/1ASHlh7OlBMeeh5O5Xc25BrEZucEDPMHVL2/92l2HJC8D1" +
       "5Ydc9xh283JA8D4TAAsMWdX3u9y5Nh0tKr36ZI8Djs8MQAPQ9W5bj5buwVR3" +
       "OjIoKD20t3aW7CwgPgpMZwGa3uXGYJao9PiZg+ay9mR1LS/0G1HpsZPtuL0q" +
       "0OreQhB5l6j0yMlmxUhglR4/sUpH1ucb7Bs++A6n71wuMGu6auX47wGdnjjR" +
       "aawbeqA7qr7X8f7n6Y/IL//C+y+XSqDxIyca77X53I9+882vf+KLv7fX5gdO" +
       "aTNUVroa3VA/qTzw5Vfiz6F35DDu8dzQzBf/GPNC/bldzQupByzv5Qcj5pXX" +
       "9yu/OP4d8V2/pP/p5dJ9ZOmK6lqxDfToQdW1PdPSg57u6IEc6RpZuld3NLyo" +
       "J0t3g2vadPS90qFhhHpElu60iqIrbvEdiMgAQ+Qiuhtcm47h7l97crQsrlOv" +
       "VCrdDVKpCdJrSnt/xWdUegu0dG0dklXZMR0X4gI35x9CuhMpQLZLyADKpMSL" +
       "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" +
       "cpPwtha5IRjDXUlDqF5G2Rq3UDYtYw3V");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
