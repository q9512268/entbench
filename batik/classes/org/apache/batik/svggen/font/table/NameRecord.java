package org.apache.batik.svggen.font.table;
public class NameRecord {
    private short platformId;
    private short encodingId;
    private short languageId;
    private short nameId;
    private short stringLength;
    private short stringOffset;
    private java.lang.String record;
    protected NameRecord(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        platformId =
          raf.
            readShort(
              );
        encodingId =
          raf.
            readShort(
              );
        languageId =
          raf.
            readShort(
              );
        nameId =
          raf.
            readShort(
              );
        stringLength =
          raf.
            readShort(
              );
        stringOffset =
          raf.
            readShort(
              );
    }
    public short getEncodingId() { return encodingId; }
    public short getLanguageId() { return languageId; }
    public short getNameId() { return nameId; }
    public short getPlatformId() { return platformId; }
    public java.lang.String getRecordString() { return record; }
    protected void loadString(java.io.RandomAccessFile raf, int stringStorageOffset)
          throws java.io.IOException { java.lang.StringBuffer sb =
                                         new java.lang.StringBuffer(
                                         );
                                       raf.seek(stringStorageOffset +
                                                  stringOffset);
                                       if (platformId == org.apache.batik.svggen.font.table.Table.
                                                           platformAppleUnicode) {
                                           for (int i =
                                                  0;
                                                i <
                                                  stringLength /
                                                  2;
                                                i++) {
                                               sb.
                                                 append(
                                                   raf.
                                                     readChar(
                                                       ));
                                           }
                                       }
                                       else
                                           if (platformId ==
                                                 org.apache.batik.svggen.font.table.Table.
                                                   platformMacintosh) {
                                               for (int i =
                                                      0;
                                                    i <
                                                      stringLength;
                                                    i++) {
                                                   sb.
                                                     append(
                                                       (char)
                                                         raf.
                                                         readByte(
                                                           ));
                                               }
                                           }
                                           else
                                               if (platformId ==
                                                     org.apache.batik.svggen.font.table.Table.
                                                       platformISO) {
                                                   for (int i =
                                                          0;
                                                        i <
                                                          stringLength;
                                                        i++) {
                                                       sb.
                                                         append(
                                                           (char)
                                                             raf.
                                                             readByte(
                                                               ));
                                                   }
                                               }
                                               else
                                                   if (platformId ==
                                                         org.apache.batik.svggen.font.table.Table.
                                                           platformMicrosoft) {
                                                       char c;
                                                       for (int i =
                                                              0;
                                                            i <
                                                              stringLength /
                                                              2;
                                                            i++) {
                                                           c =
                                                             raf.
                                                               readChar(
                                                                 );
                                                           sb.
                                                             append(
                                                               c);
                                                       }
                                                   }
                                       record =
                                         sb.
                                           toString(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16aaws11lgvWu/Z7+H7ffskNh4vPuRIWm41Vt1desxCdXV" +
       "S3V1dVV3VVcvxeLU3rXv3dUFniGRQgKRQjTjQEYC/wozQ2SSDCKA2GRAQBCL" +
       "BIqYAYkkQjPs0ZAfwzAThnCq+t7b99737rOdWLRUp0+dc77vfPv56pzzypeg" +
       "y1EIlXzP3uq2Fx+qaXxo2shhvPXV6JCkkLEYRqqC22IUTUHbC/Jzn77+91/5" +
       "yOrGAXRFgN4iuq4Xi7HhuRGrRp69VhUKur5v7dqqE8XQDcoU1yKcxIYNU0YU" +
       "36KgbzgFGkM3qWMSYEACDEiACxJgbD8KAD2ouomD5xCiG0cB9G+hSxR0xZdz" +
       "8mLo2bNIfDEUnSM044IDgOH+/H0GmCqA0xB65oT3Hc+3MfzREvzSj37PjZ++" +
       "B7ouQNcNl8vJkQERMZhEgB5wVEdSwwhTFFURoIddVVU4NTRE28gKugXokcjQ" +
       "XTFOQvVESHlj4qthMedecg/IOW9hIsdeeMKeZqi2cvx2WbNFHfD6tj2vOw57" +
       "eTtg8JoBCAs1UVaPQe61DFeJoafPQ5zweHMIBgDQ+xw1XnknU93riqABemSn" +
       "O1t0dZiLQ8PVwdDLXgJmiaHHL0Say9oXZUvU1Rdi6LHz48a7LjDqaiGIHCSG" +
       "3np+WIEJaOnxc1o6pZ8v0d/+4e91CfegoFlRZTun/34A9NQ5IFbV1FB1ZXUH" +
       "+MA7qR8R3/bLHzyAIDD4recG78b83Pd9+Tu+9alXP7sb86/uMIaRTFWOX5A/" +
       "Lj30B0/g72jdk5Nxv+9FRq78M5wX5j8+6rmV+sDz3naCMe88PO58lf3N5fd/" +
       "Qv2bA+jaALoie3biADt6WPYc37DVsK+6aijGqjKArqqughf9A+g+UKcMV921" +
       "MpoWqfEAutcumq54xTsQkQZQ5CK6D9QNV/OO674Yr4p66kMQdB94oAfA8wS0" +
       "+xX/MfQeeOU5KizKomu4HjwOvZz/CFbdWAKyXcESsHoLjrwkBCYIe6EOi8AO" +
       "Vupxx1rXVRfWgGzgWJRsFaaBmbGq7IXKYW5p/r/AHGnO543NpUtABU+cDwA2" +
       "8B3CsxU1fEF+KWl3v/zJF37n4MQhjiQUQ98Gpj3cTXtYTHu4m/Ywn/awmPZw" +
       "Py106VIx2zfm0++UDVRlAacH4fCBd3DfTb7ng8/dA6zM39wL5JwPhS+Oyvg+" +
       "TAyKYCgDW4Ve/djmvbN/Vz6ADs6G15xk0HQtBx/nQfEk+N0871Z3wnv9A3/5" +
       "95/6kRe9vYOdiddHfn87ZO63z50XbujJqgIi4R79O58RP/PCL7948wC6FwQD" +
       "EABjERgsiC1PnZ/jjP/eOo6FOS+XAcOaFzqinXcdB7Br8Sr0NvuWQusPFfWH" +
       "gYwfyg36MfC8/cjCi/+89y1+Xn7jzkpypZ3jooi1/4bzf/y///5f1QpxH4fl" +
       "66cWOk6Nb50KBTmy64XTP7y3gWmoqmDcn35s/B8++qUPfGdhAGDE83ea8GZe" +
       "4iAEABUCMb//s8Eff+HzH//cwd5oYuiqH3ox8BVVSU/4zLugB+/CJ5jw7XuS" +
       "QDSxAYbccG7yruMphmbkxpwb6j9e/+bKZ/72wzd2pmCDlmNL+tbXRrBv/6Y2" +
       "9P2/8z3/56kCzSU5X832YtsP24XIt+wxY2EobnM60vf+4ZP/8bfEHwfBFgS4" +
       "yMjUImZdOvKdnKi3gtBbQBreISu6iudgMggWUQ9Ev0KxcDHsnUV5eDvwW46B" +
       "B0w3lVU/J6iAq+XF09Fp5znrn6dSlhfkj3zu7x6c/d2vfLlg9WzOc9pWRqJ/" +
       "a2eeefFMCtA/ej5SEGK0AuPqr9LfdcN+9SsAowAwFkwxIYhW6RnLOhp9+b4/" +
       "+dVff9t7/uAe6KAHXbM9UemJhZNCV4F3qNEKBLrUf/d37Cxjcz8obuS1FDoR" +
       "DFQIBkp3FvVY8XYNEPiOi+NTL09Z9i7+2P9jbOl9f/YPtwmhiEx3WKnPwQvw" +
       "Kz/2OP6uvyng9yEih34qvT2Cg/RuD1v9hPO/D5678hsH0H0CdEM+yh1nop3k" +
       "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" +
       "FNvHH3/fSy8rzE9U8u2UHHAcQ1djz/82W12r9ilUVwCmd168VT4qblXsTyR+" +
       "631//fj0Xav3vIFz2qfP0Xke5U+OXvnt/tvlf38A3XNyPnHbfY+zQLfOnkpc" +
       "C9U4Cd3pmbOJJ08kW0g3P4+AjyQLn9/V22vzIjUVSj536HZ8tpS/f/IufZ/O" +
       "i5+MoQd1Ne6e3QrfW9AnXmvP6TTWouE/3c5g7YjB2pvP4C/cpe+X8uIzOwap" +
       "s3vqewZ/9utlMN+XRY8YRN98Bn/zLn2fzYtfBR4EGKT3m/N75n7tzdDerSPm" +
       "br35zP3hXfo+lxe/t9Pe+OQE7RyDv/91MPhI3pifiLz7iMF3v/kMfv4ufcUu" +
       "8h/H0HXA4O5Cy37//cU9i3/ydbBYXMegwIMfsYi/URa/5Y4sHhQDDvLX8p12" +
       "r+8x3LgA/OtzgJf2mOvFgP+VF/8z3h2j7/i/43b42jOUvUz+/I3IJAXY95eG" +
       "8usPj912P3F3p07+5MvX73/0Zf6/FfdmTu69XaWg+7XEtk8fOJ+qX/FDVTMK" +
       "bq7ujp/94u//xtBzr32fKYYuF/8F2f+wg/zHGHribpBAHvnfaZCvxtCjF4Dk" +
       "Jy1F5dT4SwcxdOP8eEBK8X963GUgvP04gGpXOT3kfqBvMCSvXvXvcKq0O+RP" +
       "L51NFE50+chr6fJUbvH8mYyguIx6vHonu+uoL8ifepmkv/fLjZ/Y3SGSbTHL" +
       "ciz3U9B9u+tMJxnAsxdiO8Z1hXjHVx769NVvPs5WHtoRvHeaU7Q9fefbOl3H" +
       "j4v7NdnPP/oz3/6fX/58cZD0z1W4tKIlLAAA");
}
