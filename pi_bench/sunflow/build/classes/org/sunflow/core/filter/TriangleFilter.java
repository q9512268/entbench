package org.sunflow.core.filter;
public class TriangleFilter implements org.sunflow.core.Filter {
    private float s;
    private float inv;
    public TriangleFilter(float size) { super();
                                        s = size;
                                        inv = 1.0F / (s * 0.5F); }
    public float getSize() { return s; }
    public float get(float x, float y) { return (1.0F - java.lang.Math.abs(
                                                                         x *
                                                                           inv)) *
                                           (1.0F -
                                              java.lang.Math.
                                              abs(
                                                y *
                                                  inv)); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfYxUVxW/M/vJfu/y/bXAstDwNVNq0ZJFBJbdsjgLm11K" +
                                                              "4lBZ3r65M/vYN+893rtvd3ZbtMU0UBMJbbeAteUvmlZCgRgbNdoG02jbtJq0" +
                                                              "Vmk1pUZNRCuxxNgaUes5977vmV1CopPMnTf3no97zj3nd85956+TCsskrVRj" +
                                                              "CTZuUCvRpbE+ybRoplOVLGsPzA3Kp8qkv+2/tmtjnFSmScOwZPXKkkW7Fapm" +
                                                              "rDRZrGgWkzSZWrsozSBHn0ktao5KTNG1NJmtWD15Q1VkhfXqGYoEeyUzRZol" +
                                                              "xkxlyGa0xxHAyOIU7CTJd5LcGl3uSJE6WTfGffJ5AfLOwApS5n1dFiNNqYPS" +
                                                              "qJS0maImU4rFOgomWWPo6nhO1VmCFljioLrBccHO1IYiF7Rdavz45onhJu6C" +
                                                              "mZKm6YybZ/VTS1dHaSZFGv3ZLpXmrUPkK6QsRWoDxIy0p1ylSVCaBKWutT4V" +
                                                              "7L6eana+U+fmMFdSpSHjhhhZFhZiSKaUd8T08T2DhGrm2M6ZwdqlnrXCyiIT" +
                                                              "n1yTnDy1v+k7ZaQxTRoVbQC3I8MmGChJg0Npfoia1tZMhmbSpFmDwx6gpiKp" +
                                                              "yoRz0i2WktMkZsPxu27BSdugJtfp+wrOEWwzbZnppmdelgeU868iq0o5sHWO" +
                                                              "b6uwsBvnwcAaBTZmZiWIO4elfETRMowsiXJ4NrZ/EQiAtSpP2bDuqSrXJJgg" +
                                                              "LSJEVEnLJQcg9LQckFboEIAmIwumFIq+NiR5RMrRQYzICF2fWAKqGdwRyMLI" +
                                                              "7CgZlwSntCBySoHzub5r0/EHtB1anMRgzxkqq7j/WmBqjTD10yw1KeSBYKxb" +
                                                              "nTopzXnpWJwQIJ4dIRY033vwxpa1rZdfEzQLS9DsHjpIZTYonx1qeGtR56qN" +
                                                              "ZbiNakO3FDz8kOU8y/qclY6CAQgzx5OIiwl38XL/T7/00Dn6YZzU9JBKWVft" +
                                                              "PMRRs6znDUWl5r1Uo6bEaKaHzKBappOv95AqeE4pGhWzu7NZi7IeUq7yqUqd" +
                                                              "/wcXZUEEuqgGnhUtq7vPhsSG+XPBIIRUwZesg28FER/+y0h/cljP06ShJPtM" +
                                                              "HU23kgA2Q+DW4aRla1lVH0tappzUzZz3X9ZNmgS1EDLJPZAaWk4FmMS/CYwt" +
                                                              "4/8itYC2zByLxcDNi6JJrkJ+7NDVDDUH5Ul7W9eNC4NviADCoHe8wMhK0Jdw" +
                                                              "9CVQX0LoS4T1kViMq5mFesVJwjmMQEYDpNatGvjyzgPH2soghIyxcnAikraF" +
                                                              "Skunn/YuVg/KF1vqJ5ZdXf9KnJSnSIskM1tSsVJsNXOAQfKIk6Z1Q1B0fOxf" +
                                                              "GsB+LFqmLtMMQM9UNcCRUq2PUhPnGZkVkOBWJszB5NR1oeT+yeXTYw/v/eqd" +
                                                              "cRIPwz2qrACkQvY+BGkPjNujaV5KbuPRax9fPHlY9xM+VD/cslfEiTa0RQMh" +
                                                              "6p5BefVS6cXBlw63c7fPAEBmEiQQYF1rVEcITzpcbEZbqsHgrG7mJRWXXB/X" +
                                                              "sGFTH/NneIQ28+dZEBa1mGDz4VvtZBz/xdU5Bo5zRURjnEWs4Nj/+QHjmXd/" +
                                                              "/qfPcHe7ZaIxUN8HKOsIQBMKa+Eg1OyH7R6TUqB7/3TfE09eP7qPxyxQLC+l" +
                                                              "sB3HToAkOEJw8yOvHXrvg6tn34n7cc6gNttD0OIUPCNxntRMYyRoW+nvB6BN" +
                                                              "BTTAqGm/T4P4VLKKNKRSTKx/Na5Y/+JfjjeJOFBhxg2jtbcW4M/P30YeemP/" +
                                                              "J61cTEzG0ur7zCcTeD3Tl7zVNKVx3Efh4bcXf/NV6RlAfkBbS5mgHEBjpXId" +
                                                              "82nAHrIgL5U8HMOoU4vu6jsgH2vv+4OoM/NLMAi62c8nv7H3ysE3+SFXY+bj" +
                                                              "PNpdH8hrQIhAhDUJ538Knxh8/4NfdDpOCExv6XQKy1KvshhGAXa+appWMGxA" +
                                                              "8nDLByNPX3tBGBCtvBFiemzy658mjk+KkxPtyfKiDiHII1oUYQ4OG3F3y6bT" +
                                                              "wjm6/3jx8A+fP3xU7KolXGy7oJd84Vf/fjNx+revl8B+SCFdEk3m3aHjnBU+" +
                                                              "HWHS9kcbf3SipawbUKOHVNuacsimPZmgTOivLHsocFx+48Mngsbh0TASWw2n" +
                                                              "wKc38G3c6W2G8M0QvrYDhxVWEDzDhxVooQflE+98VL/3o5dvcIPDPXgQK3ol" +
                                                              "Q3i7GYeV6O250eK2Q7KGge7uy7vub1Iv3wSJaZAoQ+Np7TahshZCyOJQV1T9" +
                                                              "+sevzDnwVhmJd5Ma8HCmW+IgTWYAOlJrGIpywfjCFgEOY4gOTdxUUmR80QQm" +
                                                              "6JLSqd+VNxhP1onvz/3upufOXOUoZQgZCzl/HPuEUFXmNzm/MJz7xed++dxj" +
                                                              "J8dEME2TGhG+ef/crQ4d+d0/ilzO62CJbInwp5Pnn17QuflDzu8XJORuLxT3" +
                                                              "NlDUfd67zuX/Hm+r/EmcVKVJk+zcnPZKqo0wn4bbguVep+B2FVoPd/6ize3w" +
                                                              "Cu6iaLoG1EZLYTAHylko3v3qV+dWv0qnMFRGq1+M8Ic0Z7mDj6txWOcWmyrD" +
                                                              "VOB2TSPVpnYaoZBknPgeUVpx7MFhn5CRmjIQ99z+xmUc7mekTNFGS+nMTKNT" +
                                                              "LN2BwxpPs6ct1KIHa6kf3cLMeYzMLWppRQ+LKb54qlsWB9OzRybPZHY/uz7u" +
                                                              "AM8WBjmrG+tUOkrVSCItDiVSL79X+lH5fsPjv/9Be27b7XS2ONd6i94V/y+B" +
                                                              "lFg9dW5Gt/LqkT8v2LN5+MBtNKlLIl6Kivx27/nX710pPx7nl2iRLkWX7zBT" +
                                                              "RzhJakzKbFMLl4bl3rk34zHPg2+9c+71pRvFEiHjtV9TsU5TaCamWXsQBxtS" +
                                                              "MEfZAHRAPL790B69VTpNj+s40W/w+UNhL3gP7u/teWEq1oilcRHXXtLew0Uf" +
                                                              "ncYfj+JwBHId/BHxxdf+F74oMNIQvoNi8ZtX9C5LvH+RL5xprJ575r4rPOG8" +
                                                              "dyR1kDpZW1WD8Bx4rjRMmlW4OXUCrA3+81gpEBH3YoZvq/CB7/uEoJ9kpClK" +
                                                              "z0g5/gTJTjFSGyBj2C7xpyDRU+BSIMLHbxkupDXxmo9lKiHKVCEWgCPHidz3" +
                                                              "s2/le48leOdBEOEvE92Et8XrRLiin9m564Ebn31W3LlkVZqYQCm10OuJ658H" +
                                                              "GsumlObKqtyx6mbDpRkrXHhtFhv2g3hhIL76AdENPPIFkQuJ1e7dS947u+nl" +
                                                              "nx2rfBv6hn0kJjEyc19xQS8YNqD1vlRxTwsAy29KHaueGt+8NvvX3/CWiYge" +
                                                              "eNHU9NCwPPFuz6WRT7bwt1cVUDlogXca28e1fiqPmqEGuQGjUcLXitwPjvvq" +
                                                              "vVm8oTPSVnw7KH6vAe3kGDW36baW4bAJgO7PhN5qujhrG0aEwZ8J3KC247Cx" +
                                                              "gN6H+BtM9RqGe3m6YvCM7IreE/gkZ77AH3G4+F/v6sCOVxgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aS+6gVMZ1OWNtrbdYEpsrZ7olrei296WE3iFycooFXlPmo8ItNcYOF1iQZsl" +
       "1jc8SylH8mDhzAW/47Q3ad30rb6/9fisZFUmq2iwkkMujSsYLmixSUeGD2+C" +
       "ITnZZHPZ9X1H021THzfqDWtd8mohNRnO6/EmxBN3o7YUXJQd2Zr0hlXdNkiR" +
       "H3ib0JrSVTaQEXJktSLB5yrzdrwWgilNmyYDBkIiXYYeqWaTGamrztwjey2n" +
       "t4mdTm8NsxZf4wcBP5plPaJTMSat/rqrbfjtgOlhhCnbG8GNCHwreFQWz2tB" +
       "CSGpCC8r7oA3s3S1XmNLZOLg66XYLpe2m3JfF/BZP527oudnU9ef0JtRj65q" +
       "PX5WQtFkk/pKOZA1g8xGjNBsh9TS78nizHPT8lrvRnytvmblucUqqyHaaWeN" +
       "1XDc2CJr1Z7VidYIdFkb9qyNjTamDCJiSKnUduszORs3aTDCkhFxA54P65nb" +
       "Hk/sWlAee/U5qfQVKuvjiu8Pk2attdbJqt9dTLIYY2UL6+njNbZdj9caslGn" +
       "8pgk47XZdRfjaI0l3CIUuvCUw3s9fryR9dCsNDokj8Db0gJR7SVXqgsLmosG" +
       "1LiCrsxWZQS3J1WFt5WyLVGlCPSZjTM5Q6dNmXVMoUy2GZqTW8pkVe04AwEh" +
       "ZpuoijSsaEZUMnzLpGqbteo0HaxoGGPbUrs9pmpjG5s0dZaosonVahMepTc2" +
       "g0W/RGubJiGNpiXGE6pieSVZg3XN6eihRG+WzmBEzto+q0TdZLnNTI6qhJ65" +
       "6G1T1W1Zq0DpCKvYdZFZLJlIv1NO1nRN1qZGs+/Sgiv0wtWgHAmAVchOh62R" +
       "0e+t6nJ5VMZLxjA1uiEOM521w0SDwWjQHLMqwY/XFW684NyuvJJWQ3xChxle" +
       "Y/myp4vwVp+Ksw2SIPpaU/ket8kq66BFrEbJDMa7K27JxktFqvXnMccradPg" +
       "KHvWTAew1EbUEHi6JSolfjRY1P0arhuSUFenuL2poypmcC0Sd0hrNJp1yoFE" +
       "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" +
       "/Paz3yrO9v4XnvTyOVIiAAA=");
}
