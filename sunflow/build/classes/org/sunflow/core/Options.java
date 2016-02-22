package org.sunflow.core;
public final class Options extends org.sunflow.core.ParameterList implements org.sunflow.core.RenderObject {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        for (java.util.Map.Entry<java.lang.String,org.sunflow.core.ParameterList.Parameter> e
              :
              pl.
                list.
               entrySet(
                 )) {
            list.
              put(
                e.
                  getKey(
                    ),
                e.
                  getValue(
                    ));
            e.
              getValue(
                ).
              check(
                );
        }
        return true;
    }
    public Options() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jBX4JF98lt+y4Tv/BZd13vaTFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2tGsLNQIBW6GZTQJ8WF7Ppmz7XgxnPctblNtYlrJtcNB6gxUT5p1ye1oRumt" +
       "UZt3jIGpyWhpKouD+XhQblUNT+yj/cl4WCoTq3GoUk2jKXXRTBK2ziCeoysx" +
       "qzVLY5RrDq2VZkzHanvDLcZ21xWoNDRsVu4uDTtDbIWcxHjDrZW5Jrrs0JbS" +
       "l4YtrAc3ORUlOG604jablsY3RTqpsSzVw2a2x1CbScsdd01KZyZEvaoyaqvR" +
       "8INxIgqqo5OjAT/kYnJslpBMbESklmyDeW8h1qUojHAS1fBtOkRXSN1agtq0" +
       "q/apSjRXuXoy0bNgsEHgFbuJl0y4DLoh3x1ETaYXTGKKSgY4X7Xry86mz62q" +
       "dYsJaJtAlltGTpowJcedjMJcxZJNZcr7+MAOljrc6zDTJjGOOVbNhvKqlmHu" +
       "dIQjWzhoMR0nIVpUpT2lENKspJPuvOLE415/vgmCSA57K29CIhlnbCaGZDlV" +
       "WLJ9fxKzzlwWjDSTDB+R5iUDn/RUCRsI47mP6LAfjowIqxmsybc8tDryQwEo" +
       "tmcObNMEF3lB7g1DdLz26Can9BQ1dplWOKfEcN3pCRjHlFShtex0xYbFgLxk" +
       "LJfsOJq3pMkCJCMsrrPcdrKZNrk+vDZbzbTE1fQ6Z5ZKjdCshlwpWpR9Rddt" +
       "ow53BFFoxSLTF8HGttzWnWaPWYmLmO5lo3G3myYzdGY2YkmYUCVL5AlxubC0" +
       "bjwMJxLZbktsiZdZItC3EbEdLpQMqzcCthxhLFuZWD1MIwXVZGtoNhw4TSte" +
       "Zn1+aHZiv2v0AtiN4dnInuNrFugwGbtxsGkwIh8vtrPMa3G1xqid+rKOJ0hv" +
       "WPdlgWpXIrXTwrqrVrspqRWCnaV4SVM3Q4Sxu2bGyMKcGMBbrgPTdWeplbSZ" +
       "1ptjA7otlVqukbaa41FtMWv4gosEaxXBa/oIXxlYO66YA3zLmzpXE+dKKDMz" +
       "uJTMDVwymy3FhJVJhqEwLWRCumWoYdddj0vLBbHp0B45McYmjGOzCVZpVGGF" +
       "wuac3uqOgsCek4k/MhuoPvb1Tn+DzFV12XTnZq/Vaax6C9uVp1rHdhm4kS3G" +
       "TE+wWmlvYlhpWWx60naiCHNzSCJweTGsVKkYYRtRsLQTojdWYgKtJ5t+RWe8" +
       "pqYz7KrfKCsTwbS66oB2t5EjD/V2WU3XPdIi0GkXrwN/qVRKU3YjdNoB52+9" +
       "pINv2xYutPFmE0lFOmPSLGplGEaZIep0YRam2X5p5Lh+pR3ptFSp1plpWOn6" +
       "yAAeNxrlXtTYrARryjQzbUiR7hbP+jW0LmbKrDle0IbWlw1+oU0JNG2E82k5" +
       "mcZaslmMA9SWif5opNDVkWi1SwGqdmc0VsFqfKyXxFTwWCoLuuOya2ZdlumO" +
       "Sb6lOqRllQMSqVlDYrk25d7UrLJTQjYjw0Zby/WMbcCmscJqFp/BKsuw7QzO" +
       "NN9tC6ZSX6w7QWWkk7PlXKmytKm60cLktvxU3gh8iVy6+HxBjNAlg0/Wcak9" +
       "mU3nTD9oRZ0VLejEwiG5uNxfbJfJur3ZOj6KME7bc1WvUdbrlGiuXASJ1w14" +
       "5K6Rdh1OBG8ZBPWF4ktU1WOj2ODLDbWnCbSDxzGZjRE40nROnPfYVdyfz1iV" +
       "3q5kjFUZpTcEh6VgyaMgbCONMor1MLzB6N4kjNrUOAtYivRwuKEnOFxXOxus" +
       "VOvO+WUor9EhDAoLUyjRTQetbuN0NSqV8BgB0UAPCWHYmYbGfNE3KkSFoEpr" +
       "C0PHZooNk3lASmnst9Jm3+kR86baqIgzr4p3rBIpZxWy3UnC1FrBA4xNXdcM" +
       "pGTc1SeLttEb9hBfFIlIx/UW1aZ9Sci8YTJuTfubWoKy8Izsy6JXXSHb8Xg9" +
       "E1VCGCTg8JjHJRjXYJ/W13K53dvaFpk0iaBdKo9skV5x0nQ906ogcSxKwNn1" +
       "ShvVGro2xeYdNKs08f5K06YLt7RgQ8+MOnCjo+G+xmNpmJIxtxmGKt0AJ0G6" +
       "hHFctN0MxtSWFJmZTwhCuVdK+VZZ7XNmx+uvlRWwARmyc7iEMH1Fw4VNjewo" +
       "5WkQ6LRn4fJG32aiY+u9TnmG0orfjUW8PKAF0UTGdbISOb0qPIRxtkFV0NQa" +
       "t+CWXJHZrGk2+IaDxeQSWZVr84XsqmsyxGdKbejPtBJnEGRmU8KyTGtEPS4b" +
       "MLfCVtZyQFF1pBYsg7Y4JwluGlmNxN/OOl3LDHDK5LpLAq6l07oxoAad3qDC" +
       "N7ZuIA689QhTBrOg6mx4cBmYLNR2h8Iz3HLbDJp2ca7E1tekiWJIw5u5pkS7" +
       "9YmRCjMYlAXuoBwOOxaSVOzWwqvHdZ9V63hdrK/H2ErvoG45k+BFs4lXAiJu" +
       "VThCCiZCe1hGqnp7uC7XE91MeGkcdEcdQRVqdaQpgIO+uxgYHlWyeZMc0eNx" +
       "xcfKjVltXdWq7WSG4K6vbnoIuaBrEsvXXbLixbqzrqxa4PgM5/2IigQh8HVa" +
       "SxdCix/SvUWtJPckapNs1i2uSjKVlPanrohMWUGoYaua1hiVaGzUQelm1OAj" +
       "d9qkMS9bk2nPtbtWnbSXRuaCI48ntsJwMuhqbicYVLFQH3GuwCRLYlbtdxu4" +
       "HcPb6mSNEJJarqzlSRdcAfKrwdt+vNvZ/cVF9LDPDy5l+YPej3ErSW+/4d7h" +
       "hp30sCdXfO55hZ7csb7FmYO78KO3NF05zVW1cHfLz69pj96p919c0T7+nudf" +
       "UJlPlPf2u0JiDF2KPf+nbW2t2Sc2DKE33fk6OipefRx1K77wnn95ZPJW8x0/" +
       "Rj/28VN8nib5e6MXv9R7o/Ibe9DZw97FLS9lTiLdONmxuBxqcRK6kxN9i0cP" +
       "9f9gru7Xgu/d+/q/+/Y90dta9Exh0Z3jnGq67e1MfmCxx26xWKEHLdbCvKt3" +
       "APbQcTB+99tkqWKH5BXaeu/MB3B/Pp/4qhzvur/cMTedxtCFhefZmuweuXDw" +
       "oy7WJ/pngMJ+Zz9vTT58yxvA3Vsr5dMvXLn4mheEvyma24dvli4NoYt6YtvH" +
       "O0nH5uf9UNOtQpJLu76SX/y8N4aunlZcDN2V/xQM/vIO7LkYuvsYGOB0f3Yc" +
       "6P0xdBYA5dNfKyy7Ts8cc/X9oC0U88CPUswhyvHGdR4exevTA1dOdi9Qbyqf" +
       "eaFPv/Pl+id2jXPFlrMsp3JxCF3Y9fAPw+HJO1I7oHWefPoH93320hsOQve+" +
       "HcNHTnqMt8dv35nuOH5c9JKzP3rNH7zld174RtHP+l+VQYb/1x4AAA==");
}
