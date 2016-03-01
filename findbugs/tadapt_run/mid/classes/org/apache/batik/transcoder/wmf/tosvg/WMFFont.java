package org.apache.batik.transcoder.wmf.tosvg;
public class WMFFont {
    public java.awt.Font font;
    public int charset;
    public int underline = 0;
    public int strikeOut = 0;
    public int italic = 0;
    public int weight = 0;
    public int orientation = 0;
    public int escape = 0;
    public WMFFont(java.awt.Font font, int charset) { super();
                                                      this.font = font;
                                                      this.charset = charset;
    }
    public WMFFont(java.awt.Font font, int charset, int underline, int strikeOut,
                   int italic,
                   int weight,
                   int orient,
                   int escape) { super();
                                 this.font = font;
                                 this.charset = charset;
                                 this.underline = underline;
                                 this.strikeOut = strikeOut;
                                 this.italic = italic;
                                 this.weight = weight;
                                 this.orientation = orient;
                                 this.escape = escape; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya5AURx3v3bvbe3DHPQgH8jjgbi8WBHbEBK3kUAMXTo7s" +
                                                              "cVt3BHXRLL2zvbfDzc4MMz13yyESqFIwH5AqCEENfBF8UARSKVFLK4jlK6kY" +
                                                              "KWJK8ygTNR8SK6EqfDBEUeO/u2d3Hvsg4YNXNb1z3f3v/+//6P9jzl5FDZaJ" +
                                                              "eg2sZXCM7jKIFUuw9wQ2LZIZVLFlbYHZlPzwX4/svf6H5n1hFEmi2TlsjcjY" +
                                                              "IkMKUTNWEi1WNItiTSbWZkIyjCJhEouYU5gqupZEcxVrOG+oiqzQET1D2Iat" +
                                                              "2IyjTkypqaRtSoadAyhaEudoJI5GWhfcMBBHrbJu7HIJFvgIBj1rbG/e5WdR" +
                                                              "1BHfgaewZFNFleKKRQcKJrrD0NVdE6pOY6RAYzvUNY4iNsXXlKmh94n2d28c" +
                                                              "znVwNczBmqZTLqI1RixdnSKZOGp3ZzeoJG/tRF9BdXE0y7OZomi8yFQCphIw" +
                                                              "Lcrr7gL0bUSz84M6F4cWT4oYMgNE0TL/IQY2cd45JsExwwlN1JGdE4O0S0vS" +
                                                              "Fs0dEPGRO6Sjjz7Y8WQdak+idkUbZ3BkAEGBSRIUSvJpYlrrMhmSSaJODQw+" +
                                                              "TkwFq8qMY+0uS5nQMLXBBYpqYZO2QUzO09UVWBJkM22Z6mZJvCx3Kue/hqyK" +
                                                              "J0DWbldWIeEQmwcBWxQAZmYx+J5DUj+paBnuR36KkozR+2EDkDbmCc3pJVb1" +
                                                              "GoYJ1CVcRMXahDQOzqdNwNYGHVzQ5L5W5VCmawPLk3iCpCiaH9yXEEuwq5kr" +
                                                              "gpFQNDe4jZ8EVloQsJLHPlc3rz20W9uohVEIMGeIrDL8s4CoJ0A0RrLEJHAP" +
                                                              "BGHrivgx3P3UwTBCsHluYLPY8+MvX7t3Zc+lp8WehRX2jKZ3EJmm5FPp2VcW" +
                                                              "DS6/u47BaDJ0S2HG90nOb1nCWRkoGBBpuksnssVYcfHS2G++8NAZ8lYYtQyj" +
                                                              "iKyrdh78qFPW84aiEvOzRCMmpiQzjJqJlhnk68OoEd7jikbE7Gg2axE6jOpV" +
                                                              "PhXR+f+goiwcwVTUAu+KltWL7wamOf5eMBBCjfCgVngWI/HHfynSpJyeJxKW" +
                                                              "saZoupQwdSY/MyiPOcSC9wysGrqUBv+fXLU69knJ0m0THFLSzQkJg1fkiFiU" +
                                                              "qIk1S4aQZErT+axEdWtqQvrcyNAQqC7G/M74v3MsMB3MmQ6FwDyLgsFBhXu1" +
                                                              "UVeBOiUftddvuHYu9axwPHZZHO1RtArYxgTbGGcbc9nGgG2Ms405bFEoxLnd" +
                                                              "xtgLRwAzTkJAgIjcunz8S5u2H+ytAw80puvBBmHYentZhhp0I0cx3Kfks1fG" +
                                                              "rl9+ruVMGIUhuKQhQ7lpIupLEyLLmbpMMhCnqiWMYtCUqqeIijjQpePT+7bu" +
                                                              "/RjH4Y387MAGCFqMPMHidYlFNHjjK53bfuDNd88f26O7d9+XSooZsIyShZTe" +
                                                              "oG2DwqfkFUvxhdRTe6JhVA9xCmIzxXCXIOz1BHn4QstAMUwzWZpA4Kxu5rHK" +
                                                              "loqxtYXmTH3aneFO18nfbwMTz2J3rQuejzqXj/+y1W6DjfOEkzKfCUjB08Cn" +
                                                              "xo0TL/7+73dydRczRrsn1Y8TOuCJUuywLh6POl0X3GISAvv+fDxx5JGrB7Zx" +
                                                              "/4MdfZUYRtk4CNEJTAhq/urTO1967dVTL4RLPhuikKbtNFQ8hZKQbB611BCS" +
                                                              "+bmLB6KcCveeeU30AQ28UskqOK0Sdkn+3d6/+sLbhzqEH6gwU3SjlTc/wJ3/" +
                                                              "yHr00LMPXu/hx4RklmVdnbnbROie4568zjTxLoajsO/5xd/8LT4BSQACr6XM" +
                                                              "EB5Lw869ZaDmU9TGKfE0jbHbbzFf99xmVhCO22mLJkwlD+aZctLV+e7rO3/V" +
                                                              "OHNfMRVVIhE777dGLv904xspbv4mduvZPGPe5rnP68wJj+91CLO8D38heP7L" +
                                                              "HmYONiECf9egk32WltKPYRQA/fIa9aJfBGlP12uTj735uBAhmJ4Dm8nBow+/" +
                                                              "Hzt0VNhU1DB9ZWWEl0bUMUIcNtzD0C2rxYVTDL1xfs/Pvr/ngEDV5c/IG6Dg" +
                                                              "fPyP//ld7PhfnqkQ6OsUpw69kzm5cHWe1gPWESJFVp/4596vvTgK8WQYNdma" +
                                                              "stMmwxnvmVCEWXbaYy63OuITXuGYaSB3rAAr8Om7OBCpBAdxOIivDbMhannD" +
                                                              "qt9Ynjo7JR9+4Z22re9cvMYF9hfq3igygg2h7U429DNtzwumsI3YysG+uy5t" +
                                                              "/mKHeukGnJiEE2VIzdaoCdmw4Is5zu6Gxpd/8cvu7VfqUHgItag6zgxhHr5R" +
                                                              "M8RNYuUgAxeMz9wrwsZ0EwwdXFRUJjy7qUsqx4ANeYPyWzvzk3k/XPu9k6/y" +
                                                              "cMVPWFweiVc6QWpl5UjMxtvZsKI8vlUjDdiriUNuYv+uYcPdtQfO+PM1bJ5k" +
                                                              "wzhf2sSGLSL0jnwwvbGJMUGxUACzWLMULDt4x+tmzLdf+fbrP7/+nUZxl2pE" +
                                                              "hgDd/H+Nqun9f3uvzON4gVAhWATok9LZxxYMfvotTu9makbdVyiv46CWcWk/" +
                                                              "fib/j3Bv5Ndh1JhEHbLTXW7Fqs3yXxI6KqvYckIH6lv3d0eiFRgoVSKLgtHK" +
                                                              "wzZYI3hDQD31XfdAWTAXnh7Ho3qCzhhC/IXU9Mdq1BR6A9BcyQHnuL6TvZnv" +
                                                              "pPwg58GzxGGzpApItSbIatQUNco51qPT0lXw4Mx/SJysqVnqcFpaBadVE2c1" +
                                                              "aoqabQ0CHOu+KiGlt4B0mcNrWRWkMzWRVqMGpFAfK5Nk1K6o090fEukCeHod" +
                                                              "Xr1VkO6ribQaNRSRCsVQRFaCuf8WYPY5jPqqwDxYE2Y1aoA5TZSJXEVtfv1D" +
                                                              "wmT+H3UYRavA/EZNmNWoKZqlmwrRRKSthPXwLai03+HWXwXrsZpYq1GDSokF" +
                                                              "LX7Fq/RoDZiFSuz4XwQFvm142HnSHmJlzeJqn594AXlq/9GTmdHTq8NO4l0H" +
                                                              "N4rqxiqVTBHVdxQEL6fnZ3XJ/LJPj+JzmXzuZHvTvJMP/In3naVPWq1QzGdt" +
                                                              "VfVmCs97xDBJVuEAWkXeMPjPdynq/0CfIyhq4L8c8WlB/AOKltyEGIpgGL1E" +
                                                              "ZylaWIOIQvdb+sdLd56ijiAdgOK/3n1PwgnuPnAN8eLdcgFQwRb2+iOj2Hd1" +
                                                              "8DqQpeqYSNWFkN/QJY+aezPH9/hGn6/I4R+di4W/LT47Q+92ctPm3dc+cVo0" +
                                                              "5LKKZ2bYKbOg3BffBkqfPZZVPa14VmTj8huzn2juL3pbpwDs3omFnhpwDPoR" +
                                                              "g/nagkC3akVLTetLp9ZefO5g5HmonbahEKZozrbyoqZg2FBIb4tXamygrOGN" +
                                                              "9EDL69svv/dyqIsX0ki0Qj21KFLykYuvJLKG8a0wah5GDXCZSIFXXPft0saI" +
                                                              "PGX6+qRIWoecWvyGMptdDMw+SHPNOAptK82yDzoU9Za3jOUfuaDHmCbmenY6" +
                                                              "O6bNf7NabMPwrnLNbmDDPQWmafC1VHzEMJxeufUc17xh8FjyDBuG/gdaHZaQ" +
                                                              "WRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeczsVnX3+5K3ZnkvgSwNZH8pDRM+z4xnVYAyi2dsjz3j" +
       "2Txjt/DwOvZ43z2maQGpTVSkFJWEggRR/wC1QmyqQEVCoKCWlgpUiQp1kwqo" +
       "qlQqikT+KK1KW3rt+bb3ve+9vFCpI/nOnet77v2dc8/9nbvMp38EnfY9qODY" +
       "xmZl2MGunAS7a6O6G2wc2d8lyCrNe74sdQze92eg7Ir42Ocv/uSnH1Qv7UBn" +
       "OOh1vGXZAR9otuVPZN82IlkioYuHpaghm34AXSLXfMTDYaAZMKn5wdMkdNsR" +
       "0QC6TO5DgAEEGECAcwhw67AWELpDtkKzk0nwVuC70K9Dp0jojCNm8ALo0asb" +
       "cXiPN/eaoXMNQAvnst8MUCoXTjzokQPdtzpfo/CLBfiF33vXpT+6BbrIQRc1" +
       "a5rBEQGIAHTCQbebsinInt+SJFnioLssWZamsqfxhpbmuDnobl9bWXwQevKB" +
       "kbLC0JG9vM9Dy90uZrp5oRjY3oF6iiYb0v6v04rBr4Cu9x7qutWwl5UDBS9o" +
       "AJin8KK8L3KrrllSAD18XOJAx8sDUAGInjXlQLUPurrV4kEBdPd27AzeWsHT" +
       "wNOsFah62g5BLwH0wHUbzWzt8KLOr+QrAXT/8Xr09hWodT43RCYSQPccr5a3" +
       "BEbpgWOjdGR8fjR86/PvsTBrJ8csyaKR4T8HhB46JjSRFdmTLVHeCt7+ZvLD" +
       "/L1feW4HgkDle45V3tb541975R1PPfTyN7Z13nBCnZGwlsXgivgJ4c5vv7Hz" +
       "ZPOWDMY5x/a1bPCv0jx3f3rvzdOJA2bevQctZi9391++PPkz9r2fkn+4A13A" +
       "oTOibYQm8KO7RNt0NEP2+rIle3wgSzh0XrakTv4eh86CPKlZ8rZ0pCi+HODQ" +
       "rUZedMbOfwMTKaCJzERnQV6zFHs/7/CBmucTB4Kgs+CBbgfPg9D2k38HkAWr" +
       "tinDvMhbmmXDtGdn+mcDakk8HMg+yEvgrWPDAvB//S2l3Trs26EHHBK2vRXM" +
       "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");
}
