package org.apache.batik.ext.awt.image.codec.util;
public abstract class ImageEncoderImpl implements org.apache.batik.ext.awt.image.codec.util.ImageEncoder {
    protected java.io.OutputStream output;
    protected org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam param;
    public ImageEncoderImpl(java.io.OutputStream output, org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam param) {
        super(
          );
        this.
          output =
          output;
        this.
          param =
          param;
    }
    public org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam getParam() {
        return param;
    }
    public void setParam(org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam param) {
        this.
          param =
          param;
    }
    public java.io.OutputStream getOutputStream() {
        return output;
    }
    public void encode(java.awt.image.Raster ras,
                       java.awt.image.ColorModel cm)
          throws java.io.IOException { java.awt.image.RenderedImage im =
                                         new org.apache.batik.ext.awt.image.codec.util.SingleTileRenderedImage(
                                         ras,
                                         cm);
                                       encode(
                                         im);
    }
    public abstract void encode(java.awt.image.RenderedImage im)
          throws java.io.IOException;
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVaeczsVnX3+5L38vIIeS8JgRCyQHhAguHzzNgznmkgZRbb" +
       "Y8947NlnTMuL9/F432Y8pmkhEougopSGNK0gaiUQLQpLqyKQKmgq1AKCIlGh" +
       "0iKxqEUqLUUif5RWpS299nz7WyCA1JF87bn3nHvPOfec3z2+1099HzodBhDs" +
       "udZGt9xoV02i3aVV3o02nhruMt0yLwahqjQtMQxHoO6SfN/Hz//wR+9eXNiB" +
       "zgjQbaLjuJEYGa4TDtTQtVaq0oXOH9YSlmqHEXShuxRXIhJHhoV0jTB6sAs9" +
       "5whrBF3s7ouAABEQIAKSi4DUD6kA03NVJ7abGYfoRKEP/Tp0qgud8eRMvAh6" +
       "yfFOPDEQ7b1u+FwD0MPZ7P8EKJUzJwH04gPdtzpfpvB7YeSx333DhT+9Djov" +
       "QOcNZ5iJIwMhIjCIAN1kq7akBmFdUVRFgG5xVFUZqoEhWkaayy1At4aG7ohR" +
       "HKgHRsoqY08N8jEPLXeTnOkWxHLkBgfqaYZqKfv/TmuWqANdn3+o61ZDMqsH" +
       "Cp4zgGCBJsrqPsv1puEoEXTvSY4DHS92AAFgvcFWo4V7MNT1jggqoFu3c2eJ" +
       "jo4Mo8BwdEB62o3BKBF051U7zWztibIp6uqlCLrjJB2/bQJUN+aGyFgi6PaT" +
       "ZHlPYJbuPDFLR+bn+73XvOuNTtvZyWVWVNnK5D8LmO45wTRQNTVQHVndMt70" +
       "yu7j4vM//fYdCALEt58g3tJ88teeed2r7nn681uaF12BhpOWqhxdkj8g3fyV" +
       "u5oP1K7LxDjruaGRTf4xzXP35/daHkw8EHnPP+gxa9zdb3x68NfzN31Y/d4O" +
       "dI6GzsiuFdvAj26RXdszLDWgVEcNxEhVaOhG1VGaeTsN3QCeu4ajbms5TQvV" +
       "iIaut/KqM27+H5hIA11kJroBPBuO5u4/e2K0yJ8TD4KgC+CCHgLXy6DtL79H" +
       "0BuRhWuriCiLjuG4CB+4mf7ZhDqKiERqCJ4V0Oq5iAT833x1cRdHQjcOgEMi" +
       "bqAjIvCKhbptzONUXEeIYQNnQGQXTN/WTHRWQThZTUDbnrWbOaH3/zt8klnn" +
       "wvrUKTBxd52EDQtEXNu1AP0l+bG4QTzz0Utf3DkIoz27RtAvARl2tzLs5jLk" +
       "kAtk2M1l2M1l2DrDSRmgU6fyoZ+XybIlAbNtAtwAiHrTA8NfZR5++33XAUf1" +
       "1teDqcpIkasDe/MQaegcT2Xg7tDTT6zfPPmNwg60cxyhM/lB1bmMnc9w9QA/" +
       "L56MzCv1e/5t3/3hxx5/xD2M0WOQvwcdl3NmoX/fSUsHrqwqAEwPu3/li8VP" +
       "XPr0Ixd3oOsBngAMjUTg8wCe7jk5xjEIeHAfTjNdTgOFNTewRStr2sfAc9Ei" +
       "cNeHNbkL3Jw/3wJs/JwsJl4EruJekOT3rPU2Lyuft3WZbNJOaJHD9WuH3vv/" +
       "/sv/gubm3kf280fWyqEaPXgETbLOzue4ccuhD4wCVQV033iC/533fv9tr88d" +
       "AFC89EoDXszKJkARMIXAzG/5vP8P3/rmB766c+g0EVhOY8ky5ORAyaweOncN" +
       "JcFoLz+UB6CRBUIy85qLY8d2FUMzRMlSMy/97/MvK37i3951YesHFqjZd6NX" +
       "/eQODutf2IDe9MU3/Mc9eTen5Gw1PLTZIdkWYm877LkeBOImkyN589/e/Xuf" +
       "E98PwBoAZGikao55O7kNdnLNb4/2As1wd7k48uIILH7qnuPf/rMGch47uVMg" +
       "eUevzMvdzKD52FDeVs6Ke8OjwXU8fo9kRZfkd3/1B8+d/OAzz+TWOJ5WHfUl" +
       "VvQe3LpvVrw4Ad2/4CSStMVwAeiwp3u/csF6+kegRwH0KAPsDLkAwFByzPP2" +
       "qE/f8PW//OzzH/7KddAOCZ2zXFEhxTyIoRtB9KjhAqBi4v3y67bOsz67v7gk" +
       "0GXKb53ujvxflpg+cHX8IrOs6BAC7vgvzpIe/cf/vMwIOXJdIRk4wS8gT73v" +
       "zuZD38v5DyEk474nuRzuQQZ5yFv6sP3vO/ed+asd6AYBuiDvpacT0YqzwBRA" +
       "Shbu56wghT3Wfjy92uYSDx5A5F0n4evIsCfB63CZAc8ZdfZ87gRe3ZxZ+T5w" +
       "3b8XyvefxKtTUP7QzFlekpcXs+IV+/Bwoxe4EZBSVfYQ4sfgdwpc/5tdWXdZ" +
       "xTZXuLW5l7C8+CBj8cAaeMbN4ynjLmzxMSsrWdHadlq7qrc8dFyXLCmB93SB" +
       "r6ILexVdskcqN1A7gk7nbwvZn9IJkXo/UaS8i+QUMM7p0i6+m+s0uvKg12WP" +
       "9wMThPlbBODQDEe09qV4wdKSL+4bbQLeKoAHX1xa+D7oXMiDL/OV3W0qfkLW" +
       "9k8tKwiumw8767ogq3/nd979pd966bdABDDQ6VXmncDxj4zYi7MXnbc+9d67" +
       "n/PYt9+ZrxnAivzjxIXXZb1eupbGWTHLivm+qndmqg7zxKwrhhGbw7yq5Npe" +
       "M/D5wLDBarjay+KRR279lvm+735km6GfjPITxOrbH3vHj3ff9djOkfeil172" +
       "anKUZ/tulAv93D0LB9BLrjVKzkH+88ce+fM/euRtW6luPZ7lE+Al9iN/9z9f" +
       "2n3i21+4Qop4veX+HBMb3fymNhbS9f0fOxE0oT5OBrMVqoUwHuj8ysTg1lLn" +
       "sBWVdIqUiS0IY1bHyijHlXC9HgzQwUoJJFQKloI9pexaCWsQQ0Ibk0KTGlMt" +
       "Q2vyU8Kkm95sODT8aaMZamJ9nRDNaOBP9WFnMR55Y9cnR8TCmNkrtSQ4ymre" +
       "KkwGlo8LTrSKa/hKUVeIggdozM829MQyHbFFWN1hkyqlYmPaoYPVWLYLYofp" +
       "WsMkqCMjqlzXYJlqzawJMsPrleHGJDbyeLhR7Rnj2uHYN8SwP2K6heHaFked" +
       "YtHixD5dcYfDor80LbYgTRqsOU1Uq0P5od6p1MYjsm6WhlOR6BE2a4/dajo1" +
       "eL5PLMNNT7aXzRkTpJ1RrS7Qs+lGspOUEiWHbQ/KiVcvlcWywyr0vDTs9IYq" +
       "URjXButBl5wL1blprBMFHYlhxUgIdrMpDCZFmyoxikDaKqV4XC9I0JpMDQZ2" +
       "hRoKHbsy3wQiPxkNi1pbbDJNKkpVyZvaQQc1eYue0gO2mtCgn3JCrvGGSzWE" +
       "Yq099fq8V/H9yWg28maL1EwnA3fTDEc02kuYFtBovJoXxkMsTclWT+oVymxJ" +
       "x5lKHIW1AkwOairZwrHaLBRXRYWidIHRK3TPbembJkvq5phYdwiU9Kd2NDQG" +
       "7tyrF0SptajXBmOGnAlSXCuFlTErJkxXX4eYELa5iCB7K18IOrUFU2CL7Kaw" +
       "RkMYvKBOeGG18Yf+ss/GZrmoDMZiEJLwuNuY1uU269WHsIBz4+XGE/VVNOia" +
       "yjRB5rjeb8z9Yme8VJeCJ7vF5sijQ7Q+mCgdar3mda3nrk1ScjGatmv42DAr" +
       "nag1NlVrLnhLhpjyxeK4VScnrZFMhMv6JhkjlIAxih3jEiMj8Iz0kfmqykli" +
       "YcrUqT43Ji1SnWp1YhPxvgDbft9ejPT+sj3u0liNHpcRidz0CaOjYUZ91qvB" +
       "cE3jV0YxYldNxhUa02UFs2I3pbqbgrYk5JTDuWV5srCZMYX7FsZJjshWll3K" +
       "5xVqzvYZ3ysNrITl+qwT40hJ1WK+IGktryu2LdqrlNxKY4aPGS70+kXKU/va" +
       "xG+aiR3ri95k0FX4dgLoSDwhSbfSQbtlu9DhwkV5GKz8aFSW0saA8IU6UZs1" +
       "4woN3k81xezptFatzhdMg4KZzqTKFPmElhFKMQftiBz1milj+oKrLhd+xdcR" +
       "yVi221TQUNcM1RoV5AZS1WYSXYjAal2ZmqN2qxPa1d6iKSXGgvYabV8bcvUw" +
       "6MyaVFhP50w9TGvTRjvC5jXGZKwmg/Zhvho7hXYwarh8g2othZW36GNTelqJ" +
       "g34DHrUqwkwp1uDOShzKhMnStThe9tYU6w6JVpOI62tFMJttQugvEmreT2Fq" +
       "rANf0dRlt0ObCz0CYvbWTaySuhRuYWjUgaNWI51QTbgdjLvDxsxmAjYkqaYc" +
       "JNxoWUb81aq9KdUso9+oUy3Ma9EolQ4dr9cbtOgCGM2us5VOeTBuT6s8yRas" +
       "BicvvT7M4T24VDHk1WI0qGPz/kSncKZNKGI6xEe4Lrb7q3oRR9FglTRZXBnI" +
       "hrzscOZmmXINslxarSV8IsOMAct0WhippbKjlpvjenndWLRYpq/j/VCZIgMd" +
       "ayojz10G3livMgw6TpiOjpUJMu0OzKSGcuiiHS0JdKO1SBOpm8y6gVYmpSVP" +
       "O0sTK4ZMweYbQi3xZTJNRK29rHMrJOiuaimbqgXT0gV+MGrUp6LcTtvNjaCX" +
       "pZGIdaVl3WtIgdaeu6rKL4doiMoI1jBmPkGW8HZUXzRb3X4/1WCbDES4BsvS" +
       "YIJ14jTt0uXYxEhCFAKmOx+VPDAxFoyHbmve0Zu035pFFDJeN+OJ1+ySk7nX" +
       "qPowBY9jTZ0qiIvUW+TMlXtFr4r3HRlZRFMTibQ4VjqdctWmKXaj2Kht6jbh" +
       "wCNuxboFb1pwByUJhSc273gE169gda0rjnFh0JK8lkSzelEqkSWnGVX8JtJb" +
       "toYtlIiipISU/dayOcdkPBkWq+6ysZIKYqsajJk2HvZsVOpSxU25qobexu5u" +
       "9ApcneKIh064WTyabPzUX3WRSWfgK+tZKbWFUqsizjB9uokEutBAN7BTdEpg" +
       "sSnCJNVXFoOFrZdgN633xyknlJ1xURmvNLy6rMicMwyX69HUnERTK2n4TCOl" +
       "PF01FkXdqMuhhKUc2lRlMXCUzZSeOR0MxXvdeM2gQ7tVBUs24va8UQXBih6B" +
       "xj220y0XF3gSTk20Ui0P5Sa5CdRYa/WMFK5UHQNgiVwxYm65rCCWgxZ9ja1q" +
       "aLWasqZG1YMpt0Sra43fJJVJIUBhqdo1+4sanrDact4i2kqZR82wpin6FJ7w" +
       "emXgm61RR1lNa8NJd0TxRmvcJsWRaXLkLOBUCi92CN9KjTWRIqOWW1IEPjUq" +
       "08FINQeBVkGLGIgJNOyX4F7N68siq7XWHAF8lJkOpHWkc1LSx6vFhmGnZqNj" +
       "r+qLcbvEiH2qqDQqS5iKhTWZhBxOMQZtTcnVrI5baTmUy6LQhAs+vaxS2Kha" +
       "6qQ8ibPz3oadIMSG4MsS7vWSeT/02Pk0JKuzMUPXJsN2g3YSJglYrexVGyo/" +
       "C5MStpH0fs+P2pVCoW8MhYmaYGu6WhogsswzXVctdYA7BzbKdHCqUBmPENxG" +
       "8Srd1oKasZ75IEOyqUI05kxhsqwusEFaR7u1AQ6rDgNA0CpX4PFsZrjesIL4" +
       "YUeYuqvxqB535xiD6KMejiy92rrqD9zszKAk4S1uqlWXcS0pwtU51q6OmTpY" +
       "u6bz8qIgy2WzImNcWvQHazBkqUwP3GltngrAEFGjl0TNFsfiNXOjBegaoJPb" +
       "WASGMLCtxnLZaekdbZmw01FfapfKrt+TOxizHuuLorJqh1hUqOBNCQ8k1pnN" +
       "JGSYTBY1Q58QozYxgTspakWtKm+nVH/Gd4vR2rcFzvC8TrPvtFh+CbeVVEQ4" +
       "LZhPC3AnBBhFN6oJOtPWer/WhNdwh2iwKLHiN10doC3HTPVwJXTYNKnP1s0q" +
       "X+A1i2Bwtu54jBnDJYCIaFgCqQDbqrHD+Yqwiqu0nLBlZ4UXU6lWL4HUNC1P" +
       "uYrp1BWa55K2WCcXKdZA0zJOInGMrqlOKEhztAJPqFZcTyeqPtC5VS0R5zw9" +
       "LccOUtTAojXt8powjNZFZBbM3HTileGVzuDNYWqiugayP5+zWdRvSckQLPAo" +
       "USoakyY6xGSqXkYZTsaCjROk4XK87iUWwtaWYWHh13V3VECwyjqOuQFSK3Gi" +
       "jDOLdNOVmHHdSkkTF0q9NOqUqrYlGGDeJjbsF9keWEh6LJn2GpottCmWC13G" +
       "CSV72qIkTdMqkiAsvB6JaPMuqY1XqiDCmMsMNS5i+ryK0kmEbGg0LREBwbUC" +
       "hIk6XkUsILxamSwK/qjZE/WRJS4b7Wp1U1hRCzGx6hSarAczzIWJalJYlRdw" +
       "h1KxQnWFIxwbMZLdGOJwrd0F2R81nVsb1iLagTfCWkKt1ywSdSYQtE0Zr/Oa" +
       "6c2dFK4plCz4s5m3brQJo6yZk7SOm0AaTuaT1ViKVdTAmrTTGgwlvaPw4dob" +
       "4wVhEHATaprMIlQH9YzUG3X9GdlemwksDweKGqGzLl5szkiU9lfDWlzANlif" +
       "9gfdGdezh2IJH5SETbkTKaUZU8RCW4RNjBIXbCNus8gaa89nA7rSWC1TRcFJ" +
       "PZpqK7KI4XHcHZdmpUl50xYkY95oKg0fLIZJl+JMd4DLbb49DQUMrF2GMihp" +
       "USJSMxSt1gpswseFgdwJxCnmLplGoawYzXkPS6LGOGJbgS7oACGdhAWSIr7H" +
       "1yWnGvsFz05Axo4RC7Ihj0orQUvW9jxuMHBDbkWAucB7YbdWqbFKZzpLJRMt" +
       "aFN/5WK9ibbEW4veSqzRo0FMKemw1UMIMqI7tekswNp4DCOUC3CC47AeLvh+" +
       "UuDJ1Qq8kPWJNp82dVHqlgCUVil+XibVNd7sWpiPVCeFYosuyxpIGmfJaDxk" +
       "SXreIRdIQxlw7bVjN9bghfO1r81eRb1ntxtwS77xcXAgubTwrOH1z+ItOLny" +
       "gDt7Gy5nRSmMAlGODve189956MQJ19F97cPNyFP7OzCVn+38Jts1uPtqZ5j5" +
       "jsEHHn3sSYX7YHFnbw/YjKAbI9d7taWuVOvEtugrr747wuZHuId7k5979F/v" +
       "HD20ePhZnOjce0LOk13+MfvUF6iXy+/Zga472Km87HD5ONODx/cnzwVqFAfO" +
       "6Ngu5d0HE3NXNg8Xoe3xI7R/v/xU5erbevdv/eoaW+zvuEbbb2bFW4DP6GrE" +
       "H2wLHrrhW3/SZszRDvOKR4+fGBXAxezpxvxidDt1SFDKCR6/hoJPZMVvAwXD" +
       "PQVzKu1IiC0j6PqVayiHSr/n51D6jqzyFeDi9pTmfvET+sFrtH0oK/4ggs6D" +
       "CT16lpNVFw5V/MOfd16zg7HpnorTX4yKJ46kbs+3Yw/hZiCGkRrst77wRGvT" +
       "tdyABfiz3WD+kyv7zD73bfvHXTRHJLLqZTCR830yK56KoDNqDmbZv98/tNpH" +
       "fg6rPW/fag/vWe3hZ2G1nYO1ZHOtkNhX766TplMdAMyqksN03sFnrx5Tn8oJ" +
       "PpcVn7maIf7i2RgiiaALJw/4s9PKOy77HGn7CY380SfPn33Bk+Ov5WfcB5+5" +
       "3NiFzmqxZR09/DnyfMYLVM3IZb9xexTk5bcvR9ADP/VCBqAgu+Uq/M2W/ysR" +
       "dPGn4Y+g0/n9KO9XI+iea/MCrvx+lOtrEXTH1bgi6DpQHqX+egQ970rUgBKU" +
       "Rym/AebhJCUYP78fpft2BJ07pAMusH04SvJPoHdAkj1+x7vCic32dC85dWQx" +
       "3wuI3H1u/Unuc8By9HA/M0F+dLW/WMfbT90uyR97kum98ZnKB7cfF8iWmKZZ" +
       "L2e70A3b7xwOFvyXXLW3/b7OtB/40c0fv/Fl+8nJzVuBD4PziGz3Xvkkn7C9" +
       "KD97Tz/1gj97zYee/GZ+gPR/yPnQyoEoAAA=");
}
