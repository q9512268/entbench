package org.apache.batik.parser;
public class AWTTransformProducer implements org.apache.batik.parser.TransformListHandler {
    protected java.awt.geom.AffineTransform affineTransform;
    public static java.awt.geom.AffineTransform createAffineTransform(java.io.Reader r)
          throws org.apache.batik.parser.ParseException { org.apache.batik.parser.TransformListParser p =
                                                            new org.apache.batik.parser.TransformListParser(
                                                            );
                                                          org.apache.batik.parser.AWTTransformProducer th =
                                                            new org.apache.batik.parser.AWTTransformProducer(
                                                            );
                                                          p.
                                                            setTransformListHandler(
                                                              th);
                                                          p.
                                                            parse(
                                                              r);
                                                          return th.
                                                            getAffineTransform(
                                                              );
    }
    public static java.awt.geom.AffineTransform createAffineTransform(java.lang.String s)
          throws org.apache.batik.parser.ParseException {
        org.apache.batik.parser.TransformListParser p =
          new org.apache.batik.parser.TransformListParser(
          );
        org.apache.batik.parser.AWTTransformProducer th =
          new org.apache.batik.parser.AWTTransformProducer(
          );
        p.
          setTransformListHandler(
            th);
        p.
          parse(
            s);
        return th.
          getAffineTransform(
            );
    }
    public java.awt.geom.AffineTransform getAffineTransform() {
        return affineTransform;
    }
    public void startTransformList() throws org.apache.batik.parser.ParseException {
        affineTransform =
          new java.awt.geom.AffineTransform(
            );
    }
    public void matrix(float a, float b, float c,
                       float d,
                       float e,
                       float f) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            new java.awt.geom.AffineTransform(
              a,
              b,
              c,
              d,
              e,
              f));
    }
    public void rotate(float theta) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getRotateInstance(
                java.lang.Math.
                  toRadians(
                    theta)));
    }
    public void rotate(float theta, float cx,
                       float cy) throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getRotateInstance(
            java.lang.Math.
              toRadians(
                theta),
            cx,
            cy);
        affineTransform.
          concatenate(
            at);
    }
    public void translate(float tx) throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            tx,
            0);
        affineTransform.
          concatenate(
            at);
    }
    public void translate(float tx, float ty)
          throws org.apache.batik.parser.ParseException {
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            tx,
            ty);
        affineTransform.
          concatenate(
            at);
    }
    public void scale(float sx) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getScaleInstance(
                sx,
                sx));
    }
    public void scale(float sx, float sy)
          throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getScaleInstance(
                sx,
                sy));
    }
    public void skewX(float skx) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getShearInstance(
                java.lang.Math.
                  tan(
                    java.lang.Math.
                      toRadians(
                        skx)),
                0));
    }
    public void skewY(float sky) throws org.apache.batik.parser.ParseException {
        affineTransform.
          concatenate(
            java.awt.geom.AffineTransform.
              getShearInstance(
                0,
                java.lang.Math.
                  tan(
                    java.lang.Math.
                      toRadians(
                        sky))));
    }
    public void endTransformList() throws org.apache.batik.parser.ParseException {
        
    }
    public AWTTransformProducer() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Pm/xqODwsHjFt5H/AdrjYkP4JQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6C8zs2H2Xv7u7dx/Z7L27eeyyzb5v0m4m+TxP26MtJbZn" +
       "bM+MZ8Zjz5vSm+PnePwcP8Yely1pEGzaSksEmyWgdCWqtJQobdKKAAIVFgF9" +
       "KBGiVUULgiSCSoSWiESCgEihHHu+9713b1f37kg+n79z/ud//r//y38fny9+" +
       "G7kvDJCS79k7w/aiQy2NDtd24zDa+Vp42OUbAghCTaVtEIZj2Hddef7LV773" +
       "/U+vrl5CLi+R9wDX9SIQmZ4bilro2VtN5ZErp71tW3PCCLnKr8EWoHFk2ihv" +
       "htFLPPKuM1Mj5Bp/LAIKRUChCGghAkqeUsFJ79bc2KHzGcCNwg3yE8gBj1z2" +
       "lVy8CHnuPBMfBMA5YiMUCCCHB/L/pxBUMTkNkGdPsO8x3wD4MyX0tb/5Y1d/" +
       "9R7kyhK5YrpSLo4ChYjgIkvkYUdzZC0ISVXV1CXyqKtpqqQFJrDNrJB7iTwW" +
       "moYLojjQTpSUd8a+FhRrnmruYSXHFsRK5AUn8HRTs9Xj/+7TbWBArO8/xbpH" +
       "yOT9EOBDJhQs0IGiHU+51zJdNUKeuTjjBOO1HiSAU+93tGjlnSx1rwtgB/LY" +
       "3nY2cA1UigLTNSDpfV4MV4mQJ2/JNNe1DxQLGNr1CHniIp2wH4JUDxaKyKdE" +
       "yPsukhWcoJWevGClM/b59uCHX/1xl3MvFTKrmmLn8j8AJz19YZKo6VqguYq2" +
       "n/jwh/nXwft/7VOXEAQSv+8C8Z7mH/7F737sI0+/+Zt7mh+4Cc1QXmtKdF35" +
       "vPzIb3+AfrF5Ty7GA74XmrnxzyEv3F84Gnkp9WHkvf+EYz54eDz4pvjri098" +
       "QfujS8hDHeSy4tmxA/3oUcVzfNPWAlZztQBEmtpBHtRclS7GO8j98J43XW3f" +
       "O9T1UIs6yL120XXZK/6HKtIhi1xF98N709W943sfRKviPvURBLkfXggJr2eQ" +
       "/a/4GyHX0ZXnaChQgGu6HioEXo4/RDU3kqFuV6gMvd5CQy8OoAuiXmCgAPrB" +
       "Sjsa8PP4ClByNh4HwA11L3AgDzVWtOAwdzT/nV8izVFeTQ4OoAE+cDH8bRg5" +
       "nGerWnBdeS2m2t/95etfvXQSDkf6iZCPwFUP96seFqse7lc9vNmqyMFBsdh7" +
       "89X3loZ2smDEw1z48IvSX+h+/FPP3wNdzE/uhUrOSdFbp2T6NEd0ikyoQEdF" +
       "3vxs8pPTv1S+hFw6n1tziWHXQ/l0Ic+IJ5nv2sWYuhnfK69863tfev1l7zS6" +
       "ziXro6C/cWYetM9f1G3gKZoK0+Ap+w8/C75y/ddevnYJuRdmApj9IgC9FSaW" +
       "py+ucS54XzpOhDmW+yDgXNvAzoeOs9dD0SrwktOewuiPFPePQh1TyFFzzr3z" +
       "0ff4efvevZPkRruAoki0f1byf/b3//V/rRXqPs7JV8485SQteulMHsiZXSki" +
       "/tFTHxgHmgbp/uNnhb/xmW+/8ucLB4AUL9xswWt5S8P4hyaEav4rv7n5d9/4" +
       "+ud/99Kp00TwQRjLtqmke5B/An8H8Pp/+ZWDyzv2MfwYfZRInj3JJH6+8odO" +
       "ZYM5xYZBl3vQtYnreKqpm0C2tdxj//jKBytf+W+vXt37hA17jl3qI7dncNr/" +
       "ZyjkE1/9sf/1dMHmQMmfaaf6OyXbJ8r3nHImgwDscjnSn/ydp/7Wb4CfhSkX" +
       "prnQzLQicyGFPpDCgOVCF6WiRS+MVfPmmfBsIJyPtTO1x3Xl07/7nXdPv/NP" +
       "v1tIe754OWv3PvBf2rta3jybQvaPX4x6DoQrSFd/c/CjV+03vw85LiFHBeay" +
       "cBjAxJOe85Ij6vvu//f//F+8/+O/fQ9yiUEesj2gMqAIOORB6OlauII5K/X/" +
       "3Mf23pw8AJurBVTkBvB7B3mi+O9eKOCLt841TF57nIbrE/9naMuf/E//+wYl" +
       "FFnmJo/cC/OX6Bc/9yT9I39UzD8N93z20+mNyRjWaadzq19w/uel5y//q0vI" +
       "/UvkqnJUBE6BHedBtISFT3hcGcJC8dz4+SJm/8R+6SSdfeBiqjmz7MVEc/oQ" +
       "gPc5dX7/0IXc8kiu5UN4vXCUW164mFsOkOLmY8WU54r2Wt784HEoP+gHXgSl" +
       "1NSC94vQyYCuQ12dPFuKSe+LkKcKTwFJdGhonnNInqfaJ7G8reUNuTc9dks3" +
       "ealYLT2AItxXPcQPy/n/3ZuLeU9++0Mw7YRFRQxnwKWBfSzw42tbuXacaKaw" +
       "QoZ+cm1t48eCXy0Ezy1yuC8rL8j64p9aVujCj5wy4z1Yof7MH3z6a3/thW9A" +
       "P+si921zH4DudWbFQZwX7X/1i5956l2vffNniiwK9T79qV/Bv5lznbwV4rwZ" +
       "5M3wGOqTOVSpKEd4EEb9ItlpaoH2LcNLCEwHPh+2RxUp+vJj37A+961f2leb" +
       "F2PpArH2qdd++k8OX33t0pka/4Ubyuyzc/Z1fiH0u480HCDPvdUqxQzmv3zp" +
       "5X/yiy+/spfqsfMVaxu+kP3Sv/2/Xzv87Dd/6yZl0r22dweGja4+zNXDDnn8" +
       "46eAriZKKjrakNCFtEPUFZHfKRTPSVo8qpFtWxiOJkpn1+IkLGXTaMwNyV3N" +
       "D3EZ39XiUjasLvVRRDOSg4sbryGxbcY3o2l3RJIMNQUMw49HU35EUPbcLDO0" +
       "R4NNREtYXypPO21YfKJZCVeFGGekcYUfVnAhW6MZ2mwSBIpmGWpSITYGg7aB" +
       "T2pOB2+CJav545JIVsaUHEzByl9blDrlN5kZNFAi28q8UZKcNScN2twgEDuV" +
       "6gwse2MmW9O78XQ5GE9nvDMIl2avxVj9bn85aYx5Z+2zVUfMOj0LRtU4C6ab" +
       "/mIxEIE17sz7m0ZnUXKHVJwMS5Q1G43K9CgaJOtaKWuWxb6lS81BZUiUZ3Ej" +
       "qMZ809hhi9RWoo5Uncxc0FozS2miWJOa5o7lTkneOHi77rFGKR2QaDRZy4s2" +
       "u+vKfZPyhsKqYRAlYZ2JHZNeiJXptE50CCULs8Fs1kulnlWFOXhSWUvbzpRw" +
       "piKzY9P5olzHOg2bSjLKY0l5MBvGZTIuy87S7zWdgOa6uL+ZgPmEZoZT18PL" +
       "wKas2qI2KnddrMcOq/iCX8hUVVSXYEd4SrtE1IVaZmV+JOv2inFCtRNiydDL" +
       "PKnXZ1ZWq03a9JxzZlw1ZTvhwJKdzbq1TIjdaCPx23CmYZXlaNyLJ74j1Ps8" +
       "Yy7LvrVKXSkxXKtdre8maWuyBpWG0u4HpU22gQKPF3FIpxW5m/SboGWMyrse" +
       "K7d7emvI+FalB8J07Mt4V+5UVbvOtyZ0eRC69VV3oQJ/2fMWvfJsJYqbrtdp" +
       "JUKlQo7KgQpIg1y4ZhJVTXsdTLsbixaXjLgNQGvq6B4za5JklxmybjZI+81E" +
       "SqJmWJVADR/KUVTHGFCZJ1WJHBrKotGjSyHBenOgl7nFbJmAljoju5ltycOJ" +
       "Nxe4eiKRRlne9itRFBCl9tYN7GCub73lhqhKAltm05qSmhPNbpcGA36HR7i8" +
       "Ieho5pWz6TgN3dqMbsyqy1bTH8eRUVeX1rAsCvXFjis3t3ppw+q6lqn1obVY" +
       "tCZSdyNJRk9oWD6Y+Mp0aWetKbscZU6n5XcxP5ziqQ7pEjdqT317OkxNwakn" +
       "gsU4vU0vENMBQU7EHTbqGKDOVGb1SuDMgUqMgp2rTrodfryzqAZup4InbjOn" +
       "uzK1cpeMxibY7DbejGuRtWhACIaiLKhq3U2GPFXqO+mmN+p77AD0xa5Bt3Zg" +
       "gU44rjmbtTWsrrNj1gPhotJJ7GbKdKR+udsZ8LXdCBuLO9cdGyOqnzA8Stiq" +
       "0dDFQPKSJVRXB9iCHi80M6u4kySeGnVC6A5XRmXZKYP2ZsgGDNMqTRa2sSAX" +
       "cgsbymG5nA36VsCtkng+xFYOCsLtwBDT6WjcLWmURK3LSUPAhnal1uZZu6zZ" +
       "E6w60CpAi/VWt9O1ph1QmdRNZ7Ogx35f5A0PE7ta6grsQjMafYllAL4wYI6B" +
       "yWBGNtVJry0vtqroT4iM1CzciWtBR6QbilfiaEUabtF4XA41VxaD5m60JNtb" +
       "rU2usIQd12VzVFq3QwLDyiWCJbZzWR/SaqtcV2sgbLTC9niedVf9iSLJ2jop" +
       "E21hXBFBXO+U2m6FkDGN3Ip1ZbDRkqRPzqPtliMEU8a9bCva203CkhbNzJNJ" +
       "Iq+pdWMFBoPhWmv5czoDfN8zV/OkRwc6WppxzdKwWUKXukBLo6wN+CWjbjhW" +
       "a1Y1aR4GzLzu4tawU1b66aalsoTGbl2Bq476OEVVVynwCbK2NKujrUazC64t" +
       "ZJs+rhHNGCzbGNHmRn5G92NfUdeq35lERFai3IQkUGLCCSN7NqMwO1LVKtjF" +
       "O92qcZaq1GOP5SYEyXRaFhZUhtTK7Sp+3O8l6DzDS/KUyfBdVO5HFXcUTLqD" +
       "1Q4PJG68rjSqZbPUwPDSFI08PyZXFDdLlKa/DNxIm+CCsFhSKtbXMDXSZq48" +
       "L6OjOkVSSbwBxCqxUMkYaWI7MyiPYyjQI6qCHk3MdOZUsaHW0ESwUyb2CIN+" +
       "iq8xLhJcSgBaoEq46+rSdhqb5fmM71OGU1+pmpBgul01FriVtMZe2GzFG93x" +
       "hyNWmbvNRnVRj3Ylp79QjR1rK62m4/XZUn9TXpX9KlYKQKWGpo1OT+UrQKyz" +
       "sgQfHOXId3rURN8Ymtt3SbLmNMF22w+kBe4NzRWgKMKmej2FXlaZBrp1I6nk" +
       "K1nf1NxdRpQVMO5XlTY/nwXr3XTZwreTepVjgqiybAgaqg/t7djFcYwfTZt4" +
       "2NMyoNd6PYHy5yk6R+t9VtVWbZQPd3q6W5QYDl/hikZM8cRvpLhjqKyCDSob" +
       "yqgtLR730JLSNESiujU2YnXNi52m2WjYtOfPB+o6bPXLMFu61baNQzFrmgpm" +
       "/nobCF0d45ZRMOObsoJ1rC07CHQWLSsy2fUzsp3tNrKBbQmOTEaE3GXMXiIu" +
       "RWWGZbzmT+u1AdkAoW1gVaxiiM5QlB0mLXOGQvYrLKBZnKY64UiaYNmk3/XN" +
       "aUtQGzN7KzDEuhMGwYytdU0h1iyajYVAs9QpMR2Ml9QU27FeMJu3BGs6mczU" +
       "plARjfqkkrG7JIiccDZEiXGpkw3TZB7GUWutYVG127RYs6lRWxQdENhgJWcl" +
       "eYlGYjaelrYh7TgxJUaJ2W5uqptAog3FDHBRFUKdK0V9mfbdXb1bwaVJtauv" +
       "a8qaMmWNZTBbtzG9gs7H6S5VxsO+u9B3tUpSCmJCLoWtrIJlYuA1e3zHBaWa" +
       "tWQqmjfDt6ZjJWxP6mLeyq2BrBduFi1p3vEFplwFeEBgxHIFjDpj1Ht0u6sO" +
       "LKWF2WFN6QQ1zLNlEtYGTjgXrZbaCUy/TW52Gm9iiS+ykqgLmt0F8nraMWOR" +
       "82hsFsvLVmvBxuLSmTaTqbkIwnUHFScZZVpVbDMoLWnUtwfr3dwelTFmNWiQ" +
       "NDpZ1LjyzBgbWM9uTdf1mBmY8jxZo5X2rFXF6QXqi6RvhmSD4olohWl6tA1R" +
       "s0su1twGBubKZE1xrU5qZi3BYdKkTK7eTb2wpQQkbfQzVm7UktbAn7WWC0Gi" +
       "ObFjyfp04fk1mDTpHkm7IW+4MWUyMLG0RHvXXvX6PT0mu/Ku1lRq3bjZbJRJ" +
       "L0H9qhBkbVwbjmS3PhpyMkuv51MrkgK30jeiBaxk6EVFDsnVasdES5karUId" +
       "1m61CNViVCPLbXm9ChvOeGbvxowbxCWvwqRcnXc1N2gFuwYajDa9UgkkohmJ" +
       "9VbaTnYG5qZWLTbQqukta1KiYCuhYmcqU9dIEKlVvLaS69VSHEeNtoQH/VbD" +
       "NRqjYGD1FRUaxJm61JxQVTxDjZjVJ70+mirdlq6tZwkVoBhGlNFhMwWR6FRb" +
       "o6HFb+a9CBsvRv1EHjrbQYVf8V1NnUymUr2pcH2rIZCzqGKWCKFBbzk7mXb4" +
       "xrgd4t5s5GzGhtmeT5tpGdSmis/GbHXg+Fln6pXWo02XCeSZEQ/nvkbVaS/W" +
       "yTRh8c1s0arjY3vRaS1qAg3fh0QBak/karOpYTObLZ82+lMp4Xf9VB8yBues" +
       "LFgry9q2THhtv8tset2q2kv09ozZNFdtj12Jis00hGmvI0PJWa7p9yPO79Je" +
       "VqKNEJ1moTZWJwGtpBoviDOqEVd6yULoNTJ8Gc1RJ2GoTiQuR4K043ZtUd6O" +
       "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");
}
