package org.apache.batik.dom.svg12;
public class BindableElement extends org.apache.batik.dom.svg.SVGGraphicsElement {
    protected java.lang.String namespaceURI;
    protected java.lang.String localName;
    protected org.apache.batik.dom.svg12.XBLOMShadowTreeElement xblShadowTree;
    protected BindableElement() { super(); }
    public BindableElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner,
                           java.lang.String ns,
                           java.lang.String ln) { super(prefix, owner);
                                                  namespaceURI = ns;
                                                  localName = ln;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName; }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return null;
    }
    protected org.w3c.dom.Node newNode() { return new org.apache.batik.dom.svg12.BindableElement(
                                             null,
                                             null,
                                             namespaceURI,
                                             localName);
    }
    public void setShadowTree(org.apache.batik.dom.svg12.XBLOMShadowTreeElement s) {
        xblShadowTree =
          s;
    }
    public org.apache.batik.dom.svg12.XBLOMShadowTreeElement getShadowTree() {
        return xblShadowTree;
    }
    public org.w3c.dom.Node getCSSFirstChild() {
        if (xblShadowTree !=
              null) {
            return xblShadowTree.
              getFirstChild(
                );
        }
        return null;
    }
    public org.w3c.dom.Node getCSSLastChild() {
        return getCSSFirstChild(
                 );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hGwnvu6x/zO25Y/+p/99mymVLvoOkcq59iL86s8+jn3fn5TtT3xl0frJ9PZ1" +
       "DIS3J21rv+T8z8vPXv3nl6H7ROimchg7zyU7LjyQCOLF8CigBvH1mfqzsd8+" +
       "0HnheC1493k/farb8176ZP0E7wV18X79To65iDLee2hF7z1vlpeg8oW7i2UW" +
       "r999aJV/Dn6XQPq/RSr4FAX7COYR7DCMevo4jvLBqv5AIWMIjE2bTaljm7p5" +
       "YiyT1zOW4VkoT4H0/kMo778LlNWFUIpcAN7d9hTJZg9VeF4s8Q2KVQcJORQL" +
       "uYtYH/lOxHowlW3ekFSw1oLl7GjOIhcER8seMx6dNDmMkc7hkV4XT9l/egl4" +
       "ontrB62DavHfvLPE9xSvHwQuKyx3baDF2nQl+wjCo5at3DoyhznYxYFJecuy" +
       "W3fSs/AdywV8w0MnLo3xwI7pJ/7oU7/7k899BUxgGrp3V0wuMG9P+T02LjaR" +
       "P/7qp59428tf/YlybQfqnv/1X219teAaXISuyJwic49gPV7A4ssAmZHCaFSu" +
       "xZpaILvYb3GB6YCoZXe4Q4JfeuQrm5/92uf3u5/zTuocsfaJl//Gnx988uXL" +
       "p/acz9227TvdZr/vLIV+8FDDAfTMRb2ULcj/8oWXfv3vvvTxvVSPnN1BEW7s" +
       "fP7f/tnvHnzmq1+6Q+h+xQaj8Rce2OjGDw3QkOoe/Zi5uF4kszRdrMf1ttxP" +
       "Q9zwDT3p6ZNlXU05P2wKi5Hcr+bcoD3sLqwoaY3rbGUq71qLRq1RyfIZTPdI" +
       "alElpeGMICmyorenQ37Y3W5F357SU0+Q6I09MXmhwg/N6dbnxcg0ghntIUMH" +
       "5js1tS5bcNQN4qGgOo1dI6jWW616I19Gu8amodLOoi/4Wz/Z0OFsy/a3ZGTo" +
       "KB1XB+aS6Vn9eWwypldZYhy8qswGcGtG8twmdehkYQnpZFQz2el4gY427QW/" +
       "sno9QnKnQm2jjCciItm9zrKP8Vs9EyoiM3U69IYXpytghy7P9NQqxm6sEFsx" +
       "4ZK3OFHqGoY46JJsYmeCQqlwjCOYtJnOnbpAka2AipHE4mk7a1jUaruCQzKU" +
       "SIX2acXSzb6UdLzGGHFMn7NCb4t1iBFWqS3kFqmEuJ3xKMoswtZivWSQCTPU" +
       "4hoWe5i+RSsrcdE0jSweAcgkIjiVukByfU6bVGYGZYRITljMtN8iXHzU36zo" +
       "YBGpktGtINutT7Lq0NIGNZEZslNivnJ4cY7qTpNghoTFUepkRdtKlrnCGI9m" +
       "cY74/qLhW2iNDRJPUevIruIZ7ITd5D7dn9HIlMSwhBdwlMQk0x6oTcoaSMts" +
       "lZOkHq40j9GdjO2D/qmRYfEexre5rFZr9fJg2leFpotm0Wra6rECGo0QmXNo" +
       "wdQDsmNj882qNw/lwTxisXqcDJIstDfdlOOJbsvMFlWLpE1hnKWjyjSSB4hU" +
       "7XaD3szPfHqrAouarrrjqtPDpj1pVl13JxOiLfZUKiMnmDfq0LMZZjUXBkeM" +
       "Fv3Z1OhPucDvKYnpbQPd2lCLaWWJZoxuL7aKU+e3LSRWUziFGy17hgw33Wm3" +
       "ketzUZ3CpNVFKg2zVu0K86GW4JsW6Qgan1QHRrxsdCcU3dpRuei7u51jy7sF" +
       "K3bgTJqKNqU6FCPJpplsBx7M7lyjg1QCmUcwlt9UEZpM21Zl3rYTRKIqVRHn" +
       "6dEKWZm4J4fJmpXXgFWv2uJxdLyJfW1mNreKoPfHDc/Y8j672TqVDRbNyGk8" +
       "7viUt23zaKW+CbcoXjWHqhAOZvoGH/lNXnJHcdufw0ak2N3utDmktxqtzYz+" +
       "FpYSmmnvtNFUN32dWs8SlsXyLgyLznQwHjqOROqT3mzOIxymB1umMzV0U9DT" +
       "tpPkgy43t1Yzlm0meC8cbjlDX3YnIi116wRCCnJ/2olifKBgTY9fCTixXQ17" +
       "pNPf5NyM6DNi0iImZrfdhOtyvSqqYdWZrxoCx3sa76q1Zb5R18qCIBcomeXa" +
       "KKCIxqQiKZTQcLHxatQWbHxn2TQ1woo9W+7UwtEwn/S1tIbJSn3rTWuyWkGC" +
       "4YRMpOnYRllU3zAiutk0l0SKh8MeOs9zYSaYtRYyWBk84Vk+QUwW8+1ktFKr" +
       "zeFo4iqTVEq4ZYp11fHcBkoPgxUeCHNx0Kd4fZ7pzYVN+Ig7DlZ5WwfjOGmJ" +
       "lUGM99bj/sBF6IrGCXiGwmtUBlrzhMkEFacuMepP1imHqbg6jmAdmwi1lkql" +
       "nbYSy8kgmtE9sTVamWtiQDSrnjLjekGn5cVDyVeGeXXJthaBK2+z3myU9Gvk" +
       "RuiJu7bibixB3qhRNJzxONH0tM12oihWTRHmTDPeEtU28IeeBucJu8pHUhSl" +
       "prZo1joZ00kjcoCrXp+WQl7Mk61Gymjm9+odWIJhxWDrUQPpNu1MXKNmptrr" +
       "ycQhWA7PWWWBteaSMmuyaGO0MzspgDoKqRRLBaZdra9Mp7rsYdFq4uJ5ksFq" +
       "uyO1bLQJ95Xc5EY9ypakAMdXNWuhZWpMTbY8YtLVDK3aBI366IgwumighjN9" +
       "aM42A3yHqq2m0KkNI2cNRwGsGRQ14gSJR2xE1lkWXvJqA6UXKlwLnJVOmQ27" +
       "PpAnTRH05459qqWStdUUr2Z4q1mpUJulIY0npNmd9TvUrKH25wquTHZOs65w" +
       "0Q4F690uGMghaRsxN9jVF8O4YurbgWvlXieIBi0kMRa7gJFxJetUXQl4oiTo" +
       "ic5kkGJwnkoiq9PUIG7suI7aWTONZgVL+/3JkGAIdiJWMbor4rkeNoPhMKp3" +
       "Um85WKZTim9hg3loBoSW8JW8qs+7dCLxKzPqa7VAbTjMGCFoQajWbW2ycjvj" +
       "Hm43+XXFac7SwMr9VrO5otb1+sCsYbMxS9WYBZ2QSJbMqgnPsXK94coxHZJ1" +
       "spYvVwGj9BbNpr1CsKjS6UnLGa/LCMLE0pSH3dCw2ZbSx7Jg4oiiOKmEGR1p" +
       "Y4eaRAom95FJaokb0hTWuRHv1EUyJbodo9reEruVytq1CK+sM5RQ3anXCLtm" +
       "3XawTOWFaKcbGeUodKeCtgTF3bkRmpiZNTfUMZk3K8a6rW36bAuGDR/f9hpe" +
       "aAjozkWN9th1nXwb71g8jzuEPJ7GuTZZdGkcGbCoLDRXFTyQZnBOU0NPpHcL" +
       "XQXTklGMwELx7qzmiR3C6+PmAniVnJfJBd1iTVZttduLwHE7sUL53Lirbtf9" +
       "Dmt3mglHh/ZkScyXjU0vMeC+MOhZSl2qD3uyScfTfiRgXULg5XnUDNuY3Mzw" +
       "bcsJDcmPljV+mQTM2Fkgarc2N6biJEonteF0Pu9PKlkNrgizud90fWGNVRfL" +
       "MUKqvdlw6/vUAu03U1MwGjQ2wCmYJtVWpaXMtzxwksZGbA7YVYAxglhhYsoU" +
       "nQG5aAEDyoTcTe11UJkwMoXrwCnNc48didwmXNcHlrcY1M1truYhrqKCYCkK" +
       "SoNFbtlZ41Ok0arM2v5yNp+1lsjIqLmhsxvzfs4TCJgkxGBek3a7HG+hfqOC" +
       "WK449jO8v4vFwGZyVEs2q1ASk5QbBu2Y0Xa5GO2EcUNKt0hrOlyP4aq57hj1" +
       "Zrxgh+0FPlmiWxZlqdxxtawjxPi0Ph87c3+puluMx5kw6XkJNVd7G5jobnDC" +
       "qk+X0m5q0o2QwFrEIpuFHDm1W3161/L6qOhL+XpQryoBC8NTaZLVLdjuzFY5" +
       "R4wX/IwTOtWVgZjUYpDpmWpgslwd6T2nQ3DjAaso87oYdudZfRBmMDZacNJo" +
       "ORrNNY1eU+rKbBggWNmtcJlCk1DvKajsDY3ViKkHxrQ+aVrNJCar816PiYE4" +
       "NblrLdkUJ3acM14wNU5QF5SJmMNoTE43LUup0lPTm40jgtvwDdmWGJl2UD6W" +
       "tazbSXKhXemKdWO6NsL2xlloarfONVg7MOYgXtDXo4nRgId2vm1Xl4qSNGW3" +
       "ig1Z08h9zTQjLdaZ7aw7G3OLzoJGhfa4tap2Km0qE3u7Grn1KquWtasGSgev" +
       "JBVxqPbbIVnTlNp627CInSw7WUcSOc5TuS7d4toEyYTdMexN8yh00LENDAC3" +
       "ZuwIdrKVE6TDZaBxLc6tSOs61xtWOZwb82MHHYYzdYkn9W7L0smZvhqEiLTs" +
       "g6HHLGLhCCKTrkQtGcvzhOC9WoNScL0B4qGo5+a9mrjGRrWNyOJ2BzhBk1kw" +
       "O5+nrVZtkJObCdMmlssqiXF+Lw6HmUsrWgI3W5bVEu2sl6L6IKBDzbGaLRP0" +
       "FQobHI1HS0V28pqUduMmhXFOp71Gl0rc7IO4dZkPdCS0cFfO8jxI12mH6Tcz" +
       "fTmIdrWx3ZbFXVXdeiOD9ftLcS2n1Z2oBuMNQtWZldRuYX5bqnD9xWa7xlPD" +
       "p1JY6SxhaUm3s9Bsr3vZyCbwwA/SLT1t1+mZtanXms08NX011ldgt7NeYnyv" +
       "S+gDwk1YyRWBn4gTqgc21W7fYhyD5oVJaNVWWN1kOVV33WUtpJeStmmIjVmy" +
       "rrBRd9eOOBsWyUlbqaU53EKWslsf7mhvLi7ILbZdjky/O2w3VqhWNVZzG5MY" +
       "KWpXK9sgbHcWATDXzjQVVgulzgzoXqSzvLeSu9KaVhfGNqrJOyZCW+u2QgeV" +
       "tr82mpPqRKcwqs4OlG0bGdmeJDiKRWhqu7Hz6k6n4kRbuALHvNpMaRhOxrCt" +
       "j8huBDZHVqczH+R5SqF13ETbdSPZhHWwr1hhqrgzOhkq0uIknKfw3JiZoVif" +
       "2hNCmnZ7qsqA6TNUiYrUCVeWiIvmctRlWA1dZo0aUps327W+tqEFrdEAkcHM" +
       "rAUEIuzm7GhYb28RZdjLtTjHvVhTbHVVHaCcsEHqQ012atP2jLU6cgcmejg/" +
       "gcMZ2m7IO2I+tbYLThk34Ny1B4tVpI9qJD5Ec5miPZ+AhRZO6QrbbBNJfTSq" +
       "OYnbGHT7cewgZGj1lvoKF4RsXsviSgpPp+yGJjECbLY/WB50fOyNnYQ8XB7w" +
       "HF90/wWOdvZVzxTZB44P0srfVejc5ej5A+/Hjo7fA+iJu91flycan/3oy6+o" +
       "488hlw+PqX84gq5Fnv89trbT7FOs7gecnr/76c2ovL4/Ofr97Y/+8ePC9xkf" +
       "eQM3g0+dk/M8y783evVL/e9S/uZl6J7jg+DbPiw42+iFs8e/1wMtigNXOHMI" +
       "/MSxZh8pNPYMSMyhZpnzR5QnY3fn88kP7sf+gluAn7mg7u8U2csRdEPXIvb8" +
       "gfCJxXz6jVwclAU/dRbikyDxhxD5tx7i5y6o+8Ui+/kIegBAZM6cLJ/g+4U3" +
       "ge+5ovB7QfrwIb4Pv1F83/26+H71grp/UGSvRtCjAF83igJTjiONcs2o/CZH" +
       "C45Oqr/nbifVB3dtVerm829CN28vCourN/lQN/Jbr5t/dkHdbxbZP4mg+1wt" +
       "YT31+NT+ZqGLpK6UKjiuKOH++puAW940tkAyD+Gab42pXzoh0EqCf3kB5n9d" +
       "ZF+MoAdDLTp3X5Gd8v4vRdCVnWeqJ8i/9CaQlwsCDJJ/iNx/6yf5f7ig7stF" +
       "9gcAtH4adKmwE4B/+CYAlmRPg5QdAszeeoBfu6Duj4vsPwPLBQAxnifNIIww" +
       "w7TVovy3TjD+0ZvFWFzjfewQ48feeoz/44K6bxXZf98vRgBjcZdzJ4jfeEO3" +
       "2IDduY+Uis8tHrvtM8j9p3vKL79y4/5HX5n9QfmdzvHnddcY6P51bNun73VP" +
       "vV/1A21tlhiu7W95/fLxZxH0+N3vByPo3vJZyvynZYtLUAS9404tIugekJ+m" +
       "vOfQi52mBBzL52m6qxF0/YQugq7uX06TXAPcAUnxet0/cpGVuy4X/LzfDyTf" +
       "MJXwUKPppbMB4PFQPfJ6Q3UqZnzuTKRXfs16FJXF++9ZX1S+8ArN/uA3m5/b" +
       "f42k2FKeF1zuZ6D79h9GHUd2z9yV2xGvq4P3ffuhX7n2nqMo9KG9wCcmfkq2" +
       "p+783Q/h+FH5pU7+jx/9hx/4xVe+XN5k/j/ZhynNZiwAAA==");
}
