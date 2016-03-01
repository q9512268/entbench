package org.apache.batik.ext.awt.image.codec.png;
public class PNGImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter {
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder encoder =
                                         new org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder(
                                         out,
                                         null);
                                       encoder.
                                         encode(
                                           image);
    }
    public java.lang.String getMIMEType() {
        return "image/png";
    }
    public PNGImageWriter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYfWwUxxWfO38bg40JhhIw4BgSvm5DISGVaQu4Bo6e8dUm" +
       "RDFJjvHenL14b3fYnbPPpC4hUgtKJZQGJ6FR8V9EbSMSUNSolaogV5WaRGka" +
       "QaM2H23Sqn80/UAK/4RWtE3fvNm73duzDah/9KSb25t5b+bNe7/5vTd77gqp" +
       "ch3SxqmVpjExxpkbS8rnJHVclu40qevug96U/sQfTx299uu6Y1FS3U/mDVG3" +
       "W6cu22kwM+32k2WG5Qpq6czdy1haaiQd5jJnhArDtvrJQsONZ7lp6IbottNM" +
       "CuynToLMp0I4xkBOsLg3gSDLE2iNhtZo28MCHQnSoNt8zFdYUqLQGRiTsll/" +
       "PVeQpsQhOkK1nDBMLWG4oiPvkHXcNscGTVvEWF7EDpn3eI7Yk7inzA1tFxo/" +
       "vf7kUBO6YQG1LFvgFt1e5trmCEsnSKPf22WyrHuYfINUJMicgLAg7YnCohos" +
       "qsGihf36UmD9XGblsp02bkcUZqrmujRIkJWlk3Dq0Kw3TRJthhlqhbd3VIbd" +
       "rijuthDu0BafXqdNPPtI08sVpLGfNBpWnzRHByMELNIPDmXZAea429Nplu4n" +
       "8y0IeB9zDGoaR7xoN7vGoEVFDiBQcIvszHHm4Jq+ryCSsDcnpwvbKW4vg6Dy" +
       "/lVlTDoIe23x96p2uFP2wwbrDTDMyVDAnqdSOWxYacRRqUZxj+1fBQFQrcky" +
       "MWQXl6q0KHSQZgURk1qDWh+AzxoE0SobIOgg1maYVPqaU32YDrKUIIvDckk1" +
       "BFJ16AipIsjCsBjOBFFaEopSID5X9m49+ai124qSCNicZrop7Z8DSq0hpV6W" +
       "YQ6Dc6AUG9YmnqEtr56IEgLCC0PCSubHX7+6bX3r1OtK5vZpZHoGDjFdpPSz" +
       "A/MuLe1c84UKaUYtt11DBr9k53jKkt5IR54D07QUZ5SDscLgVO8vHnzsBfa3" +
       "KKmPk2rdNnNZwNF83c5yw2TOLmYxhwqWjpM6ZqU7cTxOauA5YVhM9fZkMi4T" +
       "cVJpYle1jf/BRRmYQrqoHp4NK2MXnjkVQ/ic54SQGviSz8O3jagP/gqS14bs" +
       "LNOoTi3DsrWkY8v9y4Ai5zAXntMwym1tAPA/vGFjbIvm2jkHAKnZzqBGARVD" +
       "TA3iOaWjQjOyAAZNB27SNQ5AS+7dFZddDzgG4CwmEcj/j2vnpV8WjEYiELKl" +
       "YcIw4aztts00c1L6RG5H19WXUm8qMMoD5HlUkC1gQEwZEEMDkF7BgBgaEEMD" +
       "YmBArNQAEongurdJQxRMIMjDQBfA1w1r+h7ec/BEWwXgk49WQoSk6Oqy/NXp" +
       "80ohGaT0c5d6r739Vv0LURIF6hmA/OUnkfaSJKJyoGPrLA0sNlM6KVCqNnMC" +
       "mdYOMnV69Nj+o3ejHcG8ICesAkqT6knJ5sUl2sN8MN28jcc//vT8M+O2zwwl" +
       "iaaQH8s0JeG0haMc3nxKX7uCvpJ6dbw9SiqBxYC5BYWTBqTYGl6jhHg6CiQu" +
       "91ILG87YTpaacqjAvPViyLFH/R6E33zZLFRIlHAIGYj8/8U+fubdX/1lE3qy" +
       "kCoaAzm+j4mOAD3JyZqRiOb76NrnMAZyvz+dPPX0leMHEFogccd0C7bLthNo" +
       "CaIDHvzm64ff++jDs+9EfTgKyM+5ASh18riX2z6DTwS+/5FfSSmyQ1FLc6fH" +
       "byuKBMflyqt924DqTDjyEhzt91sAPiNj0AGTybPwr8ZVG1/5+8kmFW4Tegpo" +
       "WX/jCfz+z+0gj735yLVWnCaiy1Tr+88XU/y9wJ95u+PQMWlH/tjlZd99jZ6B" +
       "TADs6xpHGBIqQX8QDOBm9IWG7abQ2L2yaXeDGC89RoGSKKU/+c4nc/d/cvEq" +
       "WltaUwXj3k15h0KRigIshutuChO8HG3hsl2UBxsWhUlnN3WHYLLNU3sfajKn" +
       "rsOy/bCsDgTr9jhAgfkSKHnSVTXv/+znLQcvVZDoTlJv2jS9k+KBI3WAdOYO" +
       "AXvm+Ze3KTtGa6FpQn+QMg9Jpy+fPpxdWS4wAEd+suhHW78/+SGiUMHudk8d" +
       "/6zC9i7ZrFMglY/r80XX4Kd6FtcE5ozg82JBYjfgd5cbsQCtS+8um6mqwYrs" +
       "7OMTk+me5zeq2qO5tFLogkL4xd/8+5ex0394Y5pkUydsvsFkI8wMmFoBS64s" +
       "Sw3dWPT5tLbl8rWKD55a3FCeFeRMrTNw/tqZOT+8wGuP/3XJvi8NHbwFul8e" +
       "clR4yh92n3tj12r9qSjWrYrpy+rdUqWOoMtgUYdBgW7JbcmeuXhY2oqImCMB" +
       "sB2+d3qIuDN8WBQvI7xk01lUReDVz6Ia4oIoxipagNVSBLsPo14o7SCZpBFK" +
       "BSFVGxh2rCcneE5Amc5oFk3aH5o9UgraBQXFeE9XXmdcxgH1HpLN1wSpH5Vo" +
       "VYs5ZM0sV0PHyEJOGfGKa228+aPh7338ogJvuBIPCbMTE098Fjs5oYCsrit3" +
       "lN0YgjrqyoKWNslmQx6xPcsqqLHzz+fHf/qD8eNRj2vjglSO2Ia68myRTa9i" +
       "gY6bIyPZsQ27u0uhsgq+d3vx1m4dKtoMqqFgVqhjLf8+IJsHC2HdfGtcpA4b" +
       "2mVPjxf592EUwJFDJcCQPbrvwuH/2YXNcmgZfO/z/HDfrbtwJtVZMu/4LGNH" +
       "ZZMXZM4gE93x7q5icQbebsJDJC/IMXVB9n0xduu+gEXmld4AZM5bXPaaQl2t" +
       "9ZcmG2sXTd7/W6xCi9ffBijyMjnTDDBckO2qucMyBm6sQZUFHH9OCHLXzV5T" +
       "BKng3laPK+1vQ3l9M9qCVOFvUPcklM2z64KWUeQ8T+s7cL+eSQvsgzYoPQFE" +
       "OZ00SEIblHwWghqWhPXxNyj3HJwDXw5KXfUQFDkDs4OIfJzk0yBGvT/IR8rL" +
       "FATQwhsBqKgSrNClC/D1VyFf5tQLsJR+fnLP3kev3vu8uiHoJj1yRM4yJ0Fq" +
       "1D2kmHNXzjhbYa7q3Wuuz7tQt6rApiU3lKBtiGtgEazml4RKZre9WDm/d3br" +
       "xbdOVF+GPHCARCikpwOBl0/KU1B356AgOJAIFjKBl6hYzXfU/+ng2/94P9KM" +
       "JSBRt+LW2TRS+qmLHyQznD8XJXVxgBpk2Xw/qTfcr4xZvUwfgWK1NmcZh3Ms" +
       "noYDNGDnrOKbsnny2FF58tEznkPnFnvl5VGQtvKMVn6hhup4lDk75OxYh4Sq" +
       "lBznwdG8fIM0za4gNhvP/PPot97tAVooMTw4W42bGygWPMEXcX4F5CVXGUXA" +
       "cSrRzbl3X6v6HUaVc2Stl3HTF5S0lBAkspbz/wIj2uVUUBcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
