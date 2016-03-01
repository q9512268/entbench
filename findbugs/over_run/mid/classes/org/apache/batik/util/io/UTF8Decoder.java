package org.apache.batik.util.io;
public class UTF8Decoder extends org.apache.batik.util.io.AbstractCharDecoder {
    protected static final byte[] UTF8_BYTES = { 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    4,
    4,
    4,
    4,
    4,
    4,
    4,
    4,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0 };
    protected int nextChar = -1;
    public UTF8Decoder(java.io.InputStream is) { super(is); }
    public int readChar() throws java.io.IOException { if (nextChar != -1) {
                                                           int result =
                                                             nextChar;
                                                           nextChar =
                                                             -1;
                                                           return result;
                                                       }
                                                       if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           return END_OF_STREAM;
                                                       }
                                                       int b1 = buffer[position++] &
                                                         255;
                                                       switch (UTF8_BYTES[b1]) {
                                                           default:
                                                               charError(
                                                                 "UTF-8");
                                                           case 1:
                                                               return b1;
                                                           case 2:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               return (b1 &
                                                                         31) <<
                                                                 6 |
                                                                 buffer[position++] &
                                                                 63;
                                                           case 3:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b2 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b3 =
                                                                 buffer[position++];
                                                               if ((b2 &
                                                                      192) !=
                                                                     128 ||
                                                                     (b3 &
                                                                        192) !=
                                                                     128) {
                                                                   charError(
                                                                     "UTF-8");
                                                               }
                                                               return (b1 &
                                                                         31) <<
                                                                 12 |
                                                                 (b2 &
                                                                    63) <<
                                                                 6 |
                                                                 b3 &
                                                                 31;
                                                           case 4:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               b2 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               b3 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b4 =
                                                                 buffer[position++];
                                                               if ((b2 &
                                                                      192) !=
                                                                     128 ||
                                                                     (b3 &
                                                                        192) !=
                                                                     128 ||
                                                                     (b4 &
                                                                        192) !=
                                                                     128) {
                                                                   charError(
                                                                     "UTF-8");
                                                               }
                                                               int c =
                                                                 (b1 &
                                                                    31) <<
                                                                 18 |
                                                                 (b2 &
                                                                    63) <<
                                                                 12 |
                                                                 (b3 &
                                                                    31) <<
                                                                 6 |
                                                                 b4 &
                                                                 31;
                                                               nextChar =
                                                                 (c -
                                                                    65536) %
                                                                   1024 +
                                                                   56320;
                                                               return (c -
                                                                         65536) /
                                                                 1024 +
                                                                 55296;
                                                       }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwUxxWfO38bGxsDxjVfxhgkCPhKQ5og0zTG2MHkjC1s" +
       "kGJSjr29OXthb3e9O2fOpoSQNgFRCaFAUtqAVaWkH5RA2iZK+hFK1Y8E0QRB" +
       "ozaENjTJH0lKkOCPxmlpm743s3u7t3dnWqnKSTs7t/Nm5r15v/m9N3PiGimy" +
       "TNJoSFpMamYjBrWae7DeI5kWjbWpkmX1wdeIvO/tg7vGf1+2O0iK+8nkQcnq" +
       "kiWLdihUjVn9ZLaiWUzSZGqtozSGPXpMalFzWGKKrvWT6YrVmTBURVZYlx6j" +
       "KLBRMsNkisSYqUSTjHbaAzAyN8y1CXFtQq1+gZYwqZB1Y8TtUJ/Roc3ThrIJ" +
       "dz6LkerwVmlYCiWZoobCisVaUia5zdDVkQFVZ800xZq3qnfYC7E2fEfWMjQ+" +
       "W/XRzQOD1XwZpkqapjNuorWeWro6TGNhUuV+bVdpwhoiD5KCMJnkEWakKexM" +
       "GoJJQzCpY68rBdpXUi2ZaNO5OcwZqdiQUSFG5mUOYkimlLCH6eE6wwilzLad" +
       "dwZrG9LWOu72mfj4baFDX99c/aMCUtVPqhStF9WRQQkGk/TDgtJElJpWayxG" +
       "Y/1kigYO76WmIqnKqO3tGksZ0CSWBAg4y4IfkwY1+ZzuWoEnwTYzKTPdTJsX" +
       "56Cy/xXFVWkAbK11bRUWduB3MLBcAcXMuATYs7sUblO0GMdRZo+0jU33gQB0" +
       "LUlQNqinpyrUJPhAagREVEkbCPUC+LQBEC3SAYImx1qeQXGtDUneJg3QCCN1" +
       "frke0QRSZXwhsAsj0/1ifCTwUr3PSx7/XFu3cv8ObY0WJAHQOUZlFfWfBJ3m" +
       "+Dqtp3FqUtgHomPF4vATUu1Le4OEgPB0n7CQeeHLN+5ZMufMK0JmZg6Z7uhW" +
       "KrOIfCw6+cKstkUrClCNUkO3FHR+huV8l/XYLS0pA5imNj0iNjY7jWfW//b+" +
       "h47Tq0FS3kmKZV1NJgBHU2Q9YSgqNe+lGjUlRmOdpIxqsTbe3klKoB5WNCq+" +
       "dsfjFmWdpFDln4p1/h+WKA5D4BKVQ13R4rpTNyQ2yOspgxBSAg+pgKeBiB9/" +
       "M0JDg3qChiRZ0hRND/WYOtqPDuWcQy2ox6DV0ENRwP+2pcua7wxZetIEQIZ0" +
       "cyAkASoGqWgUS6LooQ19HXetpjJwk9mMcDM+rYlSaPHU7YEAOGOWnwpU2EVr" +
       "dBVkI/Kh5Kr2Gycj5wTMcGvYawXkBbM1i9ma+WzCmYre7JmNBAJ8kmk4qxAA" +
       "X22DXQ+0W7Go90trt+xtLACYGdsLYaFRdGFWGGpz6cHh9Ih84sL68fOvlh8P" +
       "kiAwSBTCkBsLmjJigQhlpi7TGJBRvqjgMGMofxzIqQc5c3j77o27Psv18NI7" +
       "DlgEzITde5CU01M0+bd1rnGr9rz/0aknduruBs+IF06Yy+qJvNHod6nf+Ii8" +
       "uEF6PvLSzqYgKQQyAgJmEmwY4LY5/jky+KPF4WK0pRQMjutmQlKxySHQcjZo" +
       "6tvdLxxrU3h9Grh4Em6oWnhW2DuMv7G11sByhsAmYsZnBef6L/QaR9947YPb" +
       "+XI7YaHKE897KWvxUBEOVsNJZ4oLwT6TUpD78+Geg49f27OJ4w8k5ueasAnL" +
       "NqAgcCEs8yOvDF268tax14MuZhnE4mQU0ppU2kj8TsonMBJx7uoDVKbCLkfU" +
       "NG3QAJVKXJGiKsVN8s+qBcue/3B/tcCBCl8cGC259QDu98+sIg+d2zw+hw8T" +
       "kDGUumvmigl+nuqO3Gqa0gjqkdp9cfY3XpaOAtMDu1rKKOWEGbD3LSpVx+ye" +
       "wAGdmpFkEDiplOAOXc4lQry8HReD9yO87S4smizvxsjce550KCIfeP165cbr" +
       "p29wSzLzKS8OuiSjRUAPiwUpGH6Gn4TWSNYgyC0/s+6BavXMTRixH0aUgUqt" +
       "bhPYK5WBGlu6qOTNX/6qdsuFAhLsIOWqLsU6JL4BSRkgn1qDQJ0p44v3CMdv" +
       "L4WimptKsozHtZ6b24vtCYPxdR99ccZzK7879hYHnEDYTN49aGEa5+dKnou7" +
       "2/zDy0+++4vxb5eISL4oP7f5+tX9o1uNPvzOx1mLzFktR5bh698fOnGkvu3u" +
       "q7y/Sy/Ye34qO+YAAbt9P3c88bdgY/FvgqSkn1TLdt67UVKTuGn7IdeznGQY" +
       "cuOM9sy8TSQpLWn6nOWnNs+0fmJzYx3UURrrlT4um4leLIYnZG/zhX4uCxBe" +
       "6eRdFvJyERZLuAsLGCkzTJ2BlhRy1WKLJ9kMNFE0SfXRSb0zfo55GCnHoBtZ" +
       "dX9fe68fF3jW6k1GLcb3ssjwfjL1gx+f3VJySeCiKae4L3F8Z8e5p/Q/XQ06" +
       "SWGuLkLyPqvr/E/XvBfhHF2KobnPWUBP0G01BzwBojpt7Cw77Qr8XNgq3owM" +
       "/V8zo6ipxAZoaBUo1yubisEgw2/XhhVT1xJUY0469ulPikS1IP8+9fhw7Dvz" +
       "X9s1Nv9tTluligVohjXNcWzw9Ll+4srVi5WzT/KwX4iusd2Sed7KPk5lnJK4" +
       "x6qw2Jiy8sGnx1QSEIKHbficqh0f+nXJ6OqgTfp9wuGfwC8Az7/xQUfjB+Hw" +
       "mjY78W9IZ/6GgfNNQGO+SUM7a65sO/L+MwKzfs7yCdO9h/Z90rz/kIi04vg4" +
       "P+sE5+0jjpACv1hsRu3mTTQL79Hx3qmdP/vezj1Cq5rMw1A7nPWf+cO/ftd8" +
       "+C9nc2TdhdERRtOBJJDOmmv9PhA2FS87+vddj77RDf7uJKVJTRlK0s5YJr2V" +
       "WMmoZ4O6J1OX8mzr0DeMBBYbdiDyqoD/2wQkbNJL5Ca9IFaXYtHNx94MxKdS" +
       "bYANcskt9kLiCxxQAEjE6ibPlEE7/mXkHMj4cEDWNYqJj9M2zclH0pcT0Jit" +
       "PHrNH0m7OODdsHTnxfGCy4/VVWQfOHC0OXmOE4vzY9U/wcsP/7W+7+7BLf/D" +
       "SWKuD2v+Ib/fdeLsvQvlx4L8ZkNEwawbkcxOLZngKDcpS5paJhwahZ+5X4ST" +
       "sVjMPTdBnrd7gravYPEghD4ZXSg8PoH4oxxhrZ6cynYl/t1qHyGwXIHFWuHx" +
       "lXmTsrZ09JnsHPqX26F2eZ6Qvi83urkCXb7QXTnBeIyUagCNtkEbNA8I/GM5" +
       "9F8Z97UJjEt5vJNWiThZS4Ndb/Cp5EkyCTLa7HzXUJzNjj18aCzW/fQyh9gh" +
       "CStjurFUpcNU9QwlKGI0rUYVDj8DnlZbjVb/SruG+ixIH6/ydZ0AOd/yteU9" +
       "wHS3p2Rq4Abk/Z7C4knwFhxpYugt/H/AdcORW2EsI/EX6GVkkueuBE8DdVn3" +
       "suIuUT45VlU6Y2zDH0Xgdu77KiC/iidV1ZuseurFhknjCle/QqSuBn/9gJG6" +
       "fLc3jAQVnSt8XAifZGR6TmEIRvjyyv6QkWq/LOxp/vbKPQcJqysHAUBUvCIv" +
       "APeDCFZfNBzvLMl759QKGYcJ5zD0jL2eqUAmkNOumn4rV3mwPz+Dv/nlusO1" +
       "SXG9DqnN2Np1O258/mlxJyGr0ugojjIJQqu4Hknz9by8ozljFa9ZdHPys2UL" +
       "nN00RSjsboWZHiwD7AMGwqbed2C3mtLn9kvHVp5+dW/xRcglNpGABAjflH1E" +
       "ShlJCCabwrmSCIhm/C6hpfzdLec/fjNQw0+iRITNORP1iMgHT1/uiRvGN4Ok" +
       "rJMUAVnQFD+/rR7R1lN52MzISYqjelJLp6CTEeMSXrzzlbEXtDL9Fe+0GGnM" +
       "zs+y7/ngkL6dmqtwdB7DfBEuaRjeVr6yimBhXGnAYSTcZRh2Ylr2Vb7yhsH3" +
       "8DlOyf8BOEr6NEEbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A9DPofP+hVOx5iW5lM+BC9l3w1edjjVnoKKDF1NeXrSX8+bnC53clEC3hlGQ" +
       "ACo1UMydi4sqNAGUWL7s7rv7T8DvDLj+O79y/PmDXdq+k9ivHR48LB5CkLou" +
       "5Bnqams+IXmg9FfeWOmF8+1qosc//tDX3/74Q39X2Oh5KwaiwSPjOkXasTk/" +
       "fPKZ73/zhfc/VcT4sws53gnpdHV7bfF6oiYtZHrboUxful+WnPnCTqS7ewIt" +
       "/18rh0VkqYaGtADNvBJZYQIqYNJfWVHge5qfHJQrP/tFs+d202FkeSDvrPar" +
       "XeTRO59xPvK9T+4q2dM+eQpYe+9jv/aTK+9/bO/Y/uGha0r443N2e4hCQS/M" +
       "m25O3cufa5ViRucfP/Xo5//g0ffsqLrzZDVMgs3eJ//yv7525cPf/cp1yq6z" +
       "i02iHQay49H/9XnDHniUdH2P2su7r84bqiC7C7zK1XwjMQvI0T4X+U1IoJuA" +
       "ZebdQZgdLrm3w3My4eThBGxPAl/Ls97B2IsPktHh1hAMZtcQH0EP31ihg8IT" +
       "joLfl971z/dN3mi+5aco9152SiGnUf7h4MmvUK9SfnMPuukwFF6zbzw56ZGT" +
       "AfBCpIGNrj85EQbv3+mjkN9OGXnzykLCz5GMvecYK3YtNoh/Si7qnWaeAzzK" +
       "oF0tl7e1vGntpI/eMDu+/jDO3H6w/antx+7aDWJ3en1LO5N3yQMjO+8DzRKm" +
       "XGS4N5+iavW8VO3M8gwo9W6uXEGvlPL/b7tBzji08M4JM7/HdpXLB/lgqkUx" +
       "MJrLtoseGOulI0PebfhPEdn9XxMJDPr2I2RM4BuPvO8fPvC1X3/oGeDPNHTz" +
       "Ks/EwC6Prcim+XHKrz75wftf8Nh331fUtkCCww+Rl96UY333T8fqfTmrfBFl" +
       "GTlOBkU5qqmH3J7y8rPAmP7v3Ca3f7tbi3v4wY8pz3VxLWSZqHPV5oLK4nZm" +
       "T/XMNBxiaPZH9cAobSdUZdB1bKIcOxTN21EF42aJuahqGFfRuTDgR6zRGRNy" +
       "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");
}
