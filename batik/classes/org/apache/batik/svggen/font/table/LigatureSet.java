package org.apache.batik.svggen.font.table;
public class LigatureSet {
    private int ligatureCount;
    private int[] ligatureOffsets;
    private org.apache.batik.svggen.font.table.Ligature[] ligatures;
    public LigatureSet(java.io.RandomAccessFile raf, int offset) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            offset);
        ligatureCount =
          raf.
            readUnsignedShort(
              );
        ligatureOffsets =
          (new int[ligatureCount]);
        ligatures =
          (new org.apache.batik.svggen.font.table.Ligature[ligatureCount]);
        for (int i =
               0;
             i <
               ligatureCount;
             i++) {
            ligatureOffsets[i] =
              raf.
                readUnsignedShort(
                  );
        }
        for (int i =
               0;
             i <
               ligatureCount;
             i++) {
            raf.
              seek(
                offset +
                  ligatureOffsets[i]);
            ligatures[i] =
              new org.apache.batik.svggen.font.table.Ligature(
                raf);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze4xU1Rk/O/tgn+yDp8juwrJoAJ3xRRtdSoF1F5bOwobV" +
                                                              "jV2U4eydMzMX7tx7vffM7oClKolhayKhiEob3X+KhVoEazTatFoaUx+Rmoi2" +
                                                              "1hqxr7S01hTS1Da1rf2+c+6d+5iZpaRpN7mPOff7zjnfd77v9/vO2eMfkWrb" +
                                                              "Ih1M51G+y2R2tE/nQ9SyWbJXo7Z9C7QllEcq6Z+3ndt0Y4TUjJKZGWoPKtRm" +
                                                              "/SrTkvYoaVd1m1NdYfYmxpKoMWQxm1njlKuGPkrmqPZA1tRUReWDRpKhwAi1" +
                                                              "4qSVcm6pYznOBpwOOGmPw0xiYiaxteHPPXHSqBjmLk98vk+81/cFJbPeWDYn" +
                                                              "LfEddJzGclzVYnHV5j15i6wwDW1XWjN4lOV5dIe20nHBxvjKIhd0PdX88ScH" +
                                                              "Mi3CBbOorhtcmGdvYbahjbNknDR7rX0ay9p3ki+Tyjhp8Alz0h13B43BoDEY" +
                                                              "1LXWk4LZNzE9l+01hDnc7anGVHBCnCwOdmJSi2adbobEnKGHWu7YLpTB2kUF" +
                                                              "a6WVRSY+tCJ26JFtLU9XkuZR0qzqwzgdBSbBYZBRcCjLjjHLXptMsuQoadVh" +
                                                              "sYeZpVJN3e2sdJutpnXKc7D8rluwMWcyS4zp+QrWEWyzcgo3rIJ5KRFQzq/q" +
                                                              "lEbTYOtcz1ZpYT+2g4H1KkzMSlGIO0elaqeqJznpDGsUbOz+AgiA6ows4xmj" +
                                                              "MFSVTqGBtMkQ0aiejg1D6OlpEK02IAAtThaU7RR9bVJlJ02zBEZkSG5IfgKp" +
                                                              "OuEIVOFkTlhM9ASrtCC0Sr71+WjTqv136Rv0CKmAOSeZouH8G0CpI6S0haWY" +
                                                              "xSAPpGLj8vjDdO4LkxFCQHhOSFjKPPelC2uu6jj1qpS5vITM5rEdTOEJ5cjY" +
                                                              "zDcX9i67sRKnUWsatoqLH7BcZNmQ86UnbwLCzC30iB+j7sdTW17+4j1PsA8j" +
                                                              "pH6A1CiGlstCHLUqRtZUNWatZzqzKGfJAVLH9GSv+D5AZsB7XNWZbN2cStmM" +
                                                              "D5AqTTTVGOI3uCgFXaCL6uFd1VOG+25SnhHveZMQMgMu0ghXO5F/4skJjWWM" +
                                                              "LItRheqqbsSGLAPtt2OAOGPg20xsDKJ+Z8w2chaEYMyw0jEKcZBh7ofxdJrp" +
                                                              "sZSBCEXHNAa4kxbJMcwAbSDUzP/HIHm0dNZERQUswsIwBGiQPRsMLcmshHIo" +
                                                              "t67vwonE6zK8MCUcH3EShXGjctyoGDcqx43iuFExbtQ3LqmoEMPNxvHlesNq" +
                                                              "7YS8B+BtXDZ8x8btk12VEGjmRBW4GkW7AgTU64GDi+gJ5WRb0+7FZ699KUKq" +
                                                              "4qSNKjxHNeSTtVYakErZ6SRz4xhQk8cQi3wMgdRmGQpLwjTLMYXTS60xzixs" +
                                                              "52S2rweXvzBTY+XZo+T8yanDE/eO3H1NhESCpIBDVgOeofoQQnkBsrvDYFCq" +
                                                              "3+Z95z4++fAew4OFAMu45FikiTZ0hQMi7J6EsnwRfTbxwp5u4fY6gG1OIc0A" +
                                                              "ETvCYwRQp8dFcLSlFgxOGVaWavjJ9XE9z1jGhNciIrVVvM+GsGjANJwLV7eT" +
                                                              "l+KJX+eaeJ8nIxvjLGSFYIjPDZuP/eyN318v3O2SSbOvCoBA7fEBGHbWJqCq" +
                                                              "1QvbWyyGAf3+4aEHH/po31YRsyCxpNSA3XjvBeCCJQQ33/fqne9+cPbI2xEv" +
                                                              "zjkweG4MCqF8wUhsJ/XTGAmjXeHNBwBQA3zAqOm+VYf4VFMqZh8m1j+al177" +
                                                              "7B/3t8g40KDFDaOrLt6B137ZOnLP69v+2iG6qVCQgD2feWIS1Wd5Pa+1LLoL" +
                                                              "55G/90z7116hjwE/ACbb6m4mYDYifBARls8HthCaqhHdQvWkkV2rALzZ/QDY" +
                                                              "QTDAhBvOjdmQuGoW1mncobTrhrYrk91Dv5F0dVkJBSk351jsgZF3dpwWUVCL" +
                                                              "0IDtOIcmX+IDhPhCsEWuzqfwVwHXv/DCVcEGSQ1tvQ4/LSoQlGnmYebLpqko" +
                                                              "gwbE9rR9sPPRc09KA8IEHhJmk4fu/zS6/5BcWlnlLCkqNPw6stKR5uCtB2e3" +
                                                              "eLpRhEb/707u+d6xPfvkrNqCnN0HJemTP/3n6ejhX7xWgiQqVadSvQFjvYDs" +
                                                              "s4NrIw26+SvN3z/QVtkPoDJAanO6emeODST9PUKRZufGfIvlVU+iwW8aLgyQ" +
                                                              "znJYA9G8UkzjmqLJOKE3yw29gc19eYWZGM5CbyPeltp+3A0uo69GTygH3j7f" +
                                                              "NHL+xQvCFcEi3w8zg9SU69CKtytwHeaFeXEDtTMgd8OpTbe3aKc+gR5HoUeR" +
                                                              "EpstIOd8AJQc6eoZP//hS3O3v1lJIv2kXjNosp8KfCd1AKzMzgCv583Pr5G4" +
                                                              "MlELtxZ8y5OCY4hwDMkXNWBud5ZGjb6syUWe735+3jOrjk6dFQBnyj4uF/qV" +
                                                              "WGoECF1sFT1OeeKtz/7k6FcfnpBhNk3ShPTm/32zNrb3V38rcrmg0BJ5FNIf" +
                                                              "jR1/dEHv6g+FvsdlqN2dLy6PoB7wdK97IvuXSFfNjyJkxihpUZyt2QjVcsgQ" +
                                                              "o7Adsd39GmzfAt+DWwtZR/cUuHphOJF9w4ZZ1J8fVTyQCx5xYi1LOuDqdDil" +
                                                              "M0ycFUS8bBMqV4r7crxd7fLUDNNSYfvOQkTVME2nnDRpTgnYa+R0QT43SYbG" +
                                                              "+yDeErK/obJBeVvQiC64FjnjLSpjhPTNlXijxbMtpw056s5Wbh/s4ClIgUYE" +
                                                              "rUnQur3h5R/Y3/jt0zJqS5FUaN917Git8l72ZUFSOOqNhfnNxOm0wuU4Qj45" +
                                                              "2fpfbgfwNIBO8FiaGVnYefIM1K5pnnF3G//L7hHYlpbPZJ8fp7655I27p5b8" +
                                                              "UsBcrWpDvAMBl9j7+nTOH//gwzNN7SdEFVqFPO7QQvDQoPhMILDVF6vQjDdD" +
                                                              "vN5UkiJukwJOfI2XTpIIvkY5pKeqU0301gP1nSYcgr/W4I2bHraGCiDJQogI" +
                                                              "sMc3dIZVmPtttstQhfMV+JgvQa7tAZQdFKZ6kPX+zIO//m53et2l7JiwreMi" +
                                                              "eyL83Qnrtbz8coen8srePyy4ZXVm+yVsfjpD0RDu8luDx19bf4VyMCKOcCSW" +
                                                              "Fh39BJV6gghabzEAAD1YUyzxwoN70LJCLHCornDZEn9PTvPtfrzdB7Gi4ELL" +
                                                              "uJhG/IFiOsaGEdPH3E4I4M/1+RDKZi4RZRc7l/teCmUPTouy5bQ5qXNR1hZa" +
                                                              "WnDk2dONLEQFNx/Ou4mx4hIOIkzT/M/89eA0/sr7QqAwd/FXQ0InRr65+2oh" +
                                                              "grjYXu5QTxTdR/YemkpufvxalybWgdu4YV6tsXGmBbripMF3zIJF2vyiQ115" +
                                                              "EKmcmGqunTd16zsSMN3DwkbI4lRO0/xlhO+9xrRYShWTaJRFhSkexzjpurjn" +
                                                              "IcB5AcWOSs1vQ30znSYnVfjwq5zgZF4ZFQBY+eKX/w4nLWF5mIp4+uWe4aTe" +
                                                              "k4Ou5Itf5DnYxYAIvj5vujHX4gG1LN3yFcH1LQTSnIslni8klgSwU5zguziX" +
                                                              "k2f4CeXk1MZNd134zOPyCEPR6O7d2EsDsJo8TSlg5eKyvbl91WxY9snMp+qW" +
                                                              "ukHWKifspcLlPgQagVQxMbwWhPb3dndhm//ukVUv/niy5gyw+FZSQYHQthYX" +
                                                              "uXkzB9G/NV68BwReEQcPPcu+vmv1Vak/vSe2EQ6tLSwvn1DePnrHWwfnH+mI" +
                                                              "kIYBUg35w/Ki+r55l76FKePWKGlS7b48TBF6AfYMbDBnYiZQPNsXfnHc2VRo" +
                                                              "xQMwCPbivXXxsSFsuSaYtQ5q3aRTizR4LYF/Lbh0kzPNkILX4itQ+gXX5GVF" +
                                                              "WJmID5qme/TQcL0pEGZ9eWB7Xbzi7fS/AQmKlKTdGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yufJJgAA");
}
