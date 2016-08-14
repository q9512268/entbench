package org.apache.batik.extension.svg;
public class BatikDomExtension implements org.apache.batik.dom.DomExtension, org.apache.batik.extension.svg.BatikExtConstants {
    public float getPriority() { return 1.0F; }
    public java.lang.String getAuthor() { return "Thomas DeWeese"; }
    public java.lang.String getContactAddress() { return "deweese@apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "Example extension to standard SVG shape tags";
    }
    public void registerTags(org.apache.batik.dom.ExtensibleDOMImplementation di) {
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_REGULAR_POLYGON_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikRegularPolygonElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_STAR_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikStarElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_HISTOGRAM_NORMALIZATION_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikHistogramNormalizationElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_COLOR_SWITCH_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.ColorSwitchElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_TEXT_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowTextElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_DIV_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowDivElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_PARA_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowParaElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_REGION_BREAK_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowRegionBreakElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_REGION_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowRegionElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_LINE_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowLineElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_SPAN_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowSpanElementFactory(
              ));
    }
    protected static class BatikRegularPolygonElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikRegularPolygonElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikRegularPolygonElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "59fF+ufEKzbf+C8VKcJ/qhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "V34QPbp6AIey7AX+Ck4lyY0n3Auh213fCcHJXVXyeXelrbyqce9hEfvw93hp" +
           "a1fvOHN4JH7zdaVdxbH2Dwq5kqm2qVHfcrel27zGcflkHTc7zz18s3uL/Cz3" +
           "mXdfe06hPovsHdSbZuD4fnCddFweH3rq5ofWUX5nsyuCfPXd//IQ/yb97a+g" +
           "tPvoKSFPs/yd0fNf771e/ugedPaoJHLdbdJJoisnCyEXfDWMfJs/UQ55+Mg8" +
           "D2TWeBh8P3lgnk/euLx6Q7ufyR1t616nanl7W8fIHezQqvdmVo3Lcm7MtiNH" +
           "mcVy6vglKoHvyBofmEf2VTFUD5ndc5zZgfV3Thy83NH6RMkthB5/2auBw3mL" +
           "r/TWAfjQg9dddG4v5+QvPHfx/APPjf86r6ofXaDdTkDntcg0j5ezjj3f6vqq" +
           "ZuRrc/u2uOXmP+8NoUdeWrgQOgvaXJP3bGk+EEIP3ZwGhPXR83GqXw+hS6ep" +
           "Quhc/nt83IdD6MJuHDDh9uH4kI8CmcCQ7PFj7g0qYtt6YHLmWFQeoFBu57tf" +
           "zs5HJMfL9Vkk51fUh1EXbS+pr8pffG5AvuPF2me31wWyKaZpxuU8Ad22vbk4" +
           "itzHb8rtkNet+JM/ufNLt7/uEGLu3Aq8i6djsj1649p8x3LDvJqe/uEDv//G" +
           "33ruO3mB7n8B45ayKDsgAAA=");
    }
    protected static class BatikStarElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikStarElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikStarElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ild8fOu/xMizC5YUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AAA=");
    }
    protected static class BatikHistogramNormalizationElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikHistogramNormalizationElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikHistogramNormalizationElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "XmS4kJ188ee3xPpnxSs23/4Pum5SkboUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fLMzOzssO7Pv7ZZ9MtDuBn2O4zw7PDYPO07i" +
           "OA87TuIWBr/t+Bn7JnZMtwUk3hUgWCiVYP8CtUXLoxRUpIpqq6oFBKpEhfqS" +
           "CqiqVFqKxP5RWpW29Nr5vi/f983M0lWlRsqNc33Puefcc87vnnvucz9EzoUB" +
           "kvM9e6PbHthXY7C/sEv7YOOr4X6XLg3FIFSVpi2GIQf7rsmPf/7Sj3/yQePy" +
           "HnJeQO4WXdcDIjA9NxyroWevVYVGLu16CVt1QoBcphfiWkRXwLRR2gzBVRp5" +
           "2TFSgFyhD0VAoQgoFAHNREDru1GQ6OWqu3KaKYXognCJ/BpyhkbO+3IqHkAe" +
           "O8nEFwPROWAzzDSAHC6k/3moVEYcB8ijR7pvdb5O4Y/k0Gd+802Xv3AWuSQg" +
           "l0yXTcWRoRAATiIgtzuqI6lBWFcUVRGQO11VVVg1MEXbTDK5BeSu0NRdEawC" +
           "9WiR0s6VrwbZnLuVu11OdQtWMvCCI/U0U7WVw3/nNFvUoa737XTdakim/VDB" +
           "iyYULNBEWT0kucUyXQUgj5ymONLxSg8OgKS3OiowvKOpbnFF2IHctbWdLbo6" +
           "yoLAdHU49Jy3grMA5MGbMk3X2hdlS9TVawB54PS44fYVHHVbthApCUDuPT0s" +
           "4wSt9OApKx2zzw+Z177/LS7l7mUyK6psp/JfgEQPnyIaq5oaqK6sbglvf5L+" +
           "qHjfV969hyBw8L2nBm/H/MGvvvDUax5+/mvbMT9/gzEDaaHK4Jr8SemOb72i" +
           "+UTtbCrGBd8LzdT4JzTP3H948OZq7MPIu++IY/py//Dl8+M/m7/10+oP9pCL" +
           "HeS87NkrB/rRnbLn+KatBm3VVQMRqEoHuU11lWb2voPcCp9p01W3vQNNC1XQ" +
           "QW6xs67zXvYfLpEGWaRLdCt8Nl3NO3z2RWBkz7GPIMi98Iu8Dn5/H9l+vpA2" +
           "AJFRw3NUVJRF13Q9dBh4qf4hqrpAgmtroBL0egsNvVUAXRD1Ah0VoR8Y6sEL" +
           "GDSqG0Id0XCto420r+U5xGHvfups/v/PNHGq7eXozBloiFechgEbRhDl2Yoa" +
           "XJOfWTWIFz577Rt7R2FxsE4AEeDM+9uZ97OZ949m3ocz718385Wsh4Ig6OkQ" +
           "nxgvcI6gIkVLqCAppvG/Qc6cyUS7J5V16x/QuhbECUh8+xPsG7tvfvfjZ6Fj" +
           "+tEt0DTpUPTmQN7cIUsnw08Zujfy/Meit/G/nt9D9k4icqof7LqYkg9THD3C" +
           "yyunI/FGfC+96/s//txHn/Z2MXkC4g+g4nrKNNQfP22JwJNVBYLnjv2Tj4pf" +
           "uvaVp6/sIbdA/ICYCUTo4xCOHj49x4mQv3oIn6ku56DCWrb46atDzLsIjMCL" +
           "dj2Zi9yRPd8J1/hSGgNV+P3iQVBkv+nbu/20vWfrUqnRTmmRwfPrWP8Tf/3n" +
           "/4Rny32I5JeO7Y2sCq4eQ4+U2aUMJ+7c+QAXqCoc93cfG374Iz981y9nDgBH" +
           "vPJGE15J2yZEDWhCuMzv+Nryb777nU9+e2/nNABunyvJNuX4SMkLqU53vIiS" +
           "cLZX7+SB6GPD0Ey95srEdTzF1ExRstXUS//z0quwL/3L+y9v/cCGPYdu9Jqf" +
           "zWDX/3MN5K3feNO/PZyxOSOnu99uzXbDtpB6945zPQjETSpH/La/eOi3vip+" +
           "AoIzBMTQTNQM45BsDZDMaGim/5NZu3/qHZY2j4THnf9kfB3LUq7JH/z2j17O" +
           "/+iPXsikPZnmHLd1X/Svbt0rbR6NIfv7T0c6JYYGHFd8nvmVy/bzP4EcBchR" +
           "hogXDgIITfEJzzgYfe7Wv/3jP7nvzd86i+yRyEXbE5UtoMBtAXq3GhoQ1WL/" +
           "DU9tjRul5r6cqYpcp/zWKR7I/p2FAj5xc3wh0yxlF6IP/MfAlt7+9/9+3SJk" +
           "yHKDzfkUvYA+9/EHm6//QUa/C/GU+uH4eriGGd2OtvBp51/3Hj//p3vIrQJy" +
           "WT5IF3nRXqWBI8AUKTzMIWFKeeL9yXRnu7dfPYKwV5yGl2PTngaX3TYBn9PR" +
           "6fPF43jyU/g5A7//nX7T5U47tpvsXc2Dnf7Ro63e9+MzMFrPFfYr+/mU/g0Z" +
           "l8ey9kra/MLWTOnjL8KwDrM8FVJopiva2cRPAehitnzlkDsP89Z0S1rYlYzN" +
           "vTBTz9wp1X5/m+xtAS1tCxmLrUuUbuo+v7Qdle1cd+yY0R7MG9/3Dx/85gde" +
           "+V1o0y5ybp2uNzTlsRmZVZpKv/O5jzz0sme+974MpSBE8e/5vcr3Uq70i2mc" +
           "NkTakIeqPpiqymYJAi2GoJ8Bi6pk2r6oKw8D04H4uz7IE9Gn7/qu9fHvf2ab" +
           "A57221OD1Xc/896f7r//mb1jmfcrr0t+j9Nss+9M6JcfrHCAPPZis2QU5D9+" +
           "7uk//J2n37WV6q6TeSQBj0mf+cv/+ub+x7739RskLbfY3v/BsOD2B6hi2Kkf" +
           "fmhsrk0jeRxPtQGOEoqz0Sqavhh0HG7VlfVBjlhNxsAraVzLrcxauQkTE0tr" +
           "5oRrGQeJErurilPDhFwuZsXmymh442az7Uj8MkBle9pg7RXP62yXt0Re7IXN" +
           "iRUSJMPW4xZqd8qd8WRtLUjKWCtrpSBVa4MmVYvyYQUkUlzq51CmguKqg6+N" +
           "3tKKWwrd4huVhZl4ybzcX7rldnvD0a3mYsZ0as2Z5ZeXnltFqwo1mU1J1tlw" +
           "jDr1BywYW/Oky/UdkZW6DG9hDD9fzSfz2JH7035kxW5i91eiY46UcGGP8w1e" +
           "sNaOZTuEJ3cisal0ewNOs0B/Jhi9Qd0q5LsFwpYrzVGu3YhUtttos0p/NtQo" +
           "ZrgmDTwyemSwwTiiJBJLzRt2MGlGSmZTca16ftqqMAQmcG1XbCVtcxEX2IWr" +
           "rwaNUdFqkk3c1xZuvEH5TW4sGTqB8fxitE6S/rCPdccl23JGJiNXlkGzqQp+" +
           "1eBH9oYQtX5TGxs08KiGyETl3goIxUmFLneXvGBMG0NHJhUuYCuGsVgIU7FE" +
           "+NEcDNq+E3dLjVGM4VJD5SLFU7pTAHob0Nfa3SHa73JdDGIf2xt3O26nbMar" +
           "cbHLyKRuNUcl2+BGUC6ybzhT1ienZFSCfVbEq7JVKnMClyydyRRvVQN7FeVr" +
           "PaGjSHmtPnOb9FywwxHmFcYqr7d6OX7K8VN9IA3wvERPANVncn260TC8vDAd" +
           "LYtyWZgkVXtp+EMQjS27XWa0Rr09Xy2pukoWA5qfgslK1yVOIMhe4BSDfn3I" +
           "TShvMRHrTEv3KaD4qhG4Ez9h+gpr9s063olqDZLGIoMoGsJg4HUXo0ZPm1Cc" +
           "buOoLbucX6yZJDarFzhiEJWizYisVarj7npCdA3MmU7nkVlnKnOHQYuWK+a0" +
           "pdBvEjreIEbA4XO5AR/UcjiYznDJBs7GCON8zmA5lfBF2KIAnxYr5eISJ0Ql" +
           "8K0N5ZaFEkv3BH8z1sXOoMUwQt4zW/2ZEtW0xpDCF5aai9ZzpRONpp7NSURP" +
           "7zFTll17Ydjr50pur9X3BcGjJ/1kktD9ubupC0Wuqi9DfOWGmMNVRzYbzM3V" +
           "1MKrDUOxR6NpeVmnVIGbBiu1Wi7N3HgGRt3OGI8sem3kRu14WK7pUdGaJIWQ" +
           "JJcyy0953qxW523gr2OPjPOrlqS1ImbZzdFOybfrdW7h+G16Um003IXVIlrj" +
           "PiNT7VXL0cyoZuBFY9qm+Mo80guolku4Rhvg0mjUDMmGVMdZvd4ZM72i356K" +
           "ll9fT/MDEyOx4bpgtFoh1arGhMXyXkXoVTViE1DsZkHOB7wYyzaXX9SHMxHG" +
           "kr9xmV6X9epra9xqbBbtYY7uNkbstLCm1kpQ1JmBUi+V65s5VgujqjpwHQdE" +
           "y/qSrU2iWlsX2zUhMoLCps8x9abr+5Lo+AI2qwVVoQsm3bw+D6Y810BbjFfq" +
           "tAS/Zbm5xpqz+svqgqZbNkZE5Hgpxq1uXRwAm7QU2uWkYWuQuD5TcCMZw9uM" +
           "G9ekIeOsQ3cZyzNqgRewGWYQZmnYCQyrpdU1zq81ymZtrLXGHcpZ+wsuyeVZ" +
           "eT3UnKgEyM6UFzZWwSU5mjWYyFQ9CrCTdXWQs4Nlba4uohWOjYYDeWTrTR2d" +
           "E9jGWCxH7VlVaU8Hi3qxhzabo3J52MYXar4hVimPWvJrSm0Fzc6cWahNORdw" +
           "xoaW4gRgNAXCZb8uj8Vo5LCTVUHDBBxNzARVaJCArp/rBIXlXJgl9TFuegGB" +
           "Qe8KKbiI7fmmhRflqVBJ4rimUYt60NdlBYjNvBhTI9HUN32CwVFQUfoaOqz0" +
           "NqtpZOD9QVup9UY5ckI3bMFI5hj02s60XcBBXNW5+mzeIAluKHrN4Woacky/" +
           "F1VbZaHAzVCg5dRAImOPaA7Zcr8GSrKuaKjDUpsNHbooIBZYZ2RxjKkmSRQP" +
           "IhBWF6NhWxeUmMpPKBxDCzVmnZ/Khhs1KQftsERl3Dfquc6AHrWidanmBflF" +
           "fzgnJUoUtHVzFpfUdUj43dKmhOIUFxYTdWUqhSlfkHJhqWzlvDpDF+ICmSdr" +
           "fKkpx0tHaFSsCr9Uc1ivF850lWGVulefOFI+EiNRIuDClfLJXNLQFcck/nDN" +
           "C1TUbtsjpruMB+P6pi02JWdm6UUYfBUcLxTZii5LcmeSd8jqeKKUBy0gxqgi" +
           "EpQbAZu2K7461BbVKtwR+hCAQnm6rtIDsyJrjlzuoAnh1CRHl/kWAY/WPjMZ" +
           "82WzMU4KtUK+PKtUCNUBxJheO4lTApueINDjZkJYSr2XG5cnTrXv6VZHLrpT" +
           "vxhXiWYh4GXfZP11SSLoTcn1S6gk1SaxpGqTuBnOsBqOYmUZoiyKRomx9AMg" +
           "+sowLxnorDcJy9ayWa8V1qsop0WaFnNMS8F6IGznXH9tEeimRrGJN0tqlQat" +
           "bTCIw5VFacOhFYtm2UFlRGoNm88paI9UchWNFvJDE6eFxLB4YSaV/Hob5Qvk" +
           "WK+2ayNikoSi0h0zCuiOx1hnahai2bA7Uto2kG1p1GCloTCdrJjKpE45hMSb" +
           "lUk7GhNzhtSq0SoHCg0l5LxoVWD1gdjp2k5nWGkzjUKpPt7Y4UJvtrsdplFU" +
           "vWUhN56VnIawYArdhCcqbl3KxZUFtbDatQ3hahqGbVbaWlTKgKdGXLPkLWmf" +
           "wksWX5IXYIzRY7QG5mYjr09tQmnKYMyRjWiO9ts+phd4uyiBtoN3sSrc/0h5" +
           "wDBVpUtKXNOyhwWKNkmlV0UbRTOsDcqaMvbrRDch2TlerMFjNmd41QFnmLnq" +
           "ZB3qjUrdIKsNbrkad42asVm2e649K/ZaC2Ghe5xGzUhC7xTNap3BdZDLV+u9" +
           "TnvWyudrygBPkpqFLURu5LN8LMxHUkhiqj0y9FIlEGdkASvi+MzBcis85gs6" +
           "U1pKNZ3ebAq5XkMnNmAUU/iEIoKiQKuzWgubD9ZrKulXZut6RGjdDdHrz2hZ" +
           "idr4cATTy2jWh4FsyCK6pjfjsTlK8kOJKULXCHG8CLf9oIXx65mdr3XtUg2t" +
           "djWXKdfqsdSNdTCuB06L7LadUSKQZI1rciUvb4kCzeTZbkhIXIfvWroizJdu" +
           "RZqPm0LDMagpSdnNXB/qhg18cgNMzvUCVOfnxbjYKM9yjfZkIPrTOdEddQU1" +
           "wWw0XyhS7cBXnWYTw/rlzVroFbAhu2HkxTCpzPjFpO3xtrOw0VoDMD0bXQgw" +
           "9SXHNR0wq3WunRQNdVgmW3GxrAATLwWCUcotcx4+xo0kaFFLALc8AcOFKUAx" +
           "Fh/lRlKB2iTmsCAbw6Uyc9iiBd2iqqp4PPTdmA0LOFocrpwSa0neBJ4EXpce" +
           "Ed740k5pd2YH0qOrCHg4S19QL+F0Et94wj2A3OYHHoAneFXJ5t2VuLLqxj2H" +
           "Re3D3+Mlrl3d48zh0fgN15V6Fc/ZPyjsSrbaGvQ7jr8t4Wa1jisn67npue6h" +
           "m91jZGe6T779mWeVwaewvYO60wwe4w+ul47LEyBP3vzw2s/ucHbFkK++/Z8f" +
           "5F5vvPkllHgfOSXkaZa/23/u6+1Xyx/aQ84elUauu106SXT1ZEHkYqCCVeBy" +
           "J8oiDx2Z5/7UGg/B75cPzPPlG5dZb2j3M5mjbd3rVE1vb+sYmYMdWvWe1KoR" +
           "LmfGbHnyKrVYRh29SEXwLWkTQPPIgSoC9ZDZ3ceZHVh/58Thzzpinyi9AeSJ" +
           "//VVweH8+Zd6GwF96YHrLkC3l3byZ5+9dOH+Zyd/lVXZjy7WbqORC9rKto+X" +
           "t449n/cDVTOzNbptW+zys593AuThFxcOIGdhm2nyji3NewDy4M1pYHgfPR+n" +
           "+g2AXD5NBZBz2e/xcR8AyMXdOGjK7cPxIR+CMsEh6eOH/RtUyLb1wfjMseg8" +
           "QKPM3nf9LHsfkRwv36cRnV1dH0bfant5fU3+3LNd5i0vlD+1vT6QbTFJUi4X" +
           "aOTW7U3GUQQ/dlNuh7zOU0/85I7P3/aqQ6i5YyvwLq6OyfbIjWv1hOODrLqe" +
           "fPn+L772t5/9Tlaw+x+i2uBJUyAAAA==");
    }
    protected static class ColorSwitchElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public ColorSwitchElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.ColorSwitchElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "tvjzSbH+GfGKzXf+C1fJFs2aFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "u0Vh7n8BCc6ZGSsgAAA=");
    }
    protected static class FlowTextElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowTextElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowTextElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcRxWfu7Md27F9tuOP4MRO4l6C4oS7RG0KlUNbfyYO" +
           "5w/FTqQ6NJe5vbm7jfd2N7uz9tml0FZCDQiFENI2INV/uapApa0QFSDRyqgS" +
           "bVVAJESEghqQ+Kd8RDRCKn8EKO/N7t7u7dmJwh+ctHN7M2/ezHvvN7/35l66" +
           "QapNg/Qwlcf5os7M+IjKp6hhssyQQk1zBvpS0nMR+o+TH0w8ECY1s6QpT81x" +
           "iZpsVGZKxpwl3bJqcqpKzJxgLIMzpgxmMmOecllTZ0m7bI4VdEWWZD6uZRgK" +
           "HKdGkrRQzg05bXE25ijgpDsJO0mInSQGgsP9SdIgafqiJ77ZJz7kG0HJgreW" +
           "yUlz8jSdpwmLy0oiKZu8v2iQPbqmLOYUjcdZkcdPKwccFxxJHqhwQe+r0Y9u" +
           "nc83CxdsoqqqcWGeeZSZmjLPMkkS9XpHFFYwz5AvkkiSbPQJcxJLuosmYNEE" +
           "LOpa60nB7huZahWGNGEOdzXV6BJuiJMd5Up0atCCo2ZK7Bk01HLHdjEZrN1e" +
           "sta2ssLEZ/YkLj53svn7ERKdJVFZncbtSLAJDovMgkNZIc0McyCTYZlZ0qJC" +
           "sKeZIVNFXnIi3WrKOZVyC8LvugU7LZ0ZYk3PVxBHsM2wJK4ZJfOyAlDOr+qs" +
           "QnNga4dnq23hKPaDgfUybMzIUsCdM6VqTlYznGwLzijZGPscCMDUDQXG81pp" +
           "qSqVQgdptSGiUDWXmAboqTkQrdYAgAYnXesqRV/rVJqjOZZCRAbkpuwhkKoT" +
           "jsApnLQHxYQmiFJXIEq++NyYOHjuMfWwGiYh2HOGSQrufyNM6glMOsqyzGBw" +
           "DuyJDX3JZ2nH62fDhIBwe0DYlvnhF24+vLdn9W1bZssaMpPp00ziKWkl3XR5" +
           "69DuByK4jVpdM2UMfpnl4pRNOSP9RR0YpqOkEQfj7uDq0Z898sR32V/DpH6M" +
           "1EiaYhUARy2SVtBlhRmHmMoMyllmjNQxNTMkxsfIBnhPyiqzeyezWZPxMVKl" +
           "iK4aTfwGF2VBBbqoHt5lNau57zrlefFe1Akh7fCQ++G5TOzPr7DhRErktQJL" +
           "UImqsqolpgwN7TcTwDhp8G0+kQbUzyVMzTIAggnNyCUo4CDPnAE4NEw1wcaE" +
           "OZ9LDGLfsFYYcXvjCDb9/7NMEa3dtBAKQSC2BmlAgRN0WFMyzEhJF63BkZsv" +
           "p961IYbHwvETJ4dg5bi9clysHC+tHIeV4xUrx0YVbWEGhJAMwZpRiod9kYRC" +
           "Yh9tuDEbDBDKOSAFYOWG3dOPHjl1tjcCKNQXqiAOKNpblp2GPOZw6T4lvdLa" +
           "uLTj+v43w6QqSVphJYsqmGwGjBzQmDTnnPSGNOQtL31s96UPzHuGJrEMsNd6" +
           "acTRUqvNMwP7OWnzaXCTGx7jxPqpZc39k9VLC08e/9K+MAmXZwxcshrIDqdP" +
           "Ic+X+DwWZIq19Eaf/uCjV559XPM4oywFuZmzYiba0BtEStA9KalvO30t9frj" +
           "MeH2OuB0TuEMAl32BNcoo6R+l97RllowOKsZBargkOvjep43AD6lHgHhFvHe" +
           "BrCI4hndCc8V59CKbxzt0LHttCGPOAtYIdLHZ6f153/7yz/fK9ztZpqor0SY" +
           "Zrzfx26orFXwWIsH2xmDMZB7/9LUN5+58fQJgVmQuGetBWPYDgGrQQjBzV9+" +
           "+8x7f7i+cjXs4ZxDerfSUCUVS0bWok1NtzESVtvl7QfYUQHqQNTEjqmATzkr" +
           "07TC8GD9K7pz/2t/O9ds40CBHhdGe++swOv/xCB54t2T/+wRakISZmfPZ56Y" +
           "TfmbPM0DhkEXcR/FJ690f+st+jwkDyBsU15igoOJ8AERQTsg7N8n2vsCY5/G" +
           "ZqfpB3/5+fJVUSnp/NUPG49/+MZNsdvyMswf63Gq99vwwmZXEdR3BsnpMDXz" +
           "IHff6sTnm5XVW6BxFjRKwMjmpAHUWSxDhiNdveF3P32z49TlCAmPknpFoxmb" +
           "AyFtAbqZmQfWLeoPPWwHdwHD3SxMJRXGV3Sgg7etHbqRgs6Fs5d+1PmDgy8u" +
           "Xxco020dW/wKPynaPmw+JfrDnNTphsZBFYNKqsYUJaCHSDG3zc2R7rcfkd4a" +
           "IfG+mZOHKjJHRivEnTwB8BqeHMf7gUgSIj6x8oyBAelerywSJd3KUxeXM5Mv" +
           "7LeLl9byUmMEKunv/ebfP49f+uM7a+S1Gqes9W8c1itLOeOiXPRo7/2mC3/6" +
           "cSw3eDfZBvt67pBP8Pc2sKBv/ewR3MpbT/2la+bB/Km7SBzbAr4MqvzO+Evv" +
           "HNolXQiL2tjOGRU1dfmkfr9XYVGDwSVARTOxp1GcrntKKOpE0HTDc81B0bW1" +
           "yVtAFJs9lZS43tQAeYRtWLtQbBYnBiv8uF3huwNtiNGFeyUBzWFNshB/YhuP" +
           "3IaOUtjMAIYkg0GV6irb5FfmYFmMfQabY/Zx6v8fzz12DOhFoN616yt3E/vu" +
           "tl4D1G+uuCLa1xrp5eVobefysWsC8KWrRwNAN2spii/yfhTU6AbLysJRDTa/" +
           "6uJrDsqD22+Okwi0wpLT9hy4X3StPwdYq/Tun3UGIh6cxUm1+PbLcU7qPTmI" +
           "p/3iF1mAPYEIvgL3VsLJvh0VQ5UkK4Lefqegl6b4Cwg8/eJy755Uy77eQ727" +
           "fGTisZv3v2AXMJJCl5bEZRDutnYtVTrtO9bV5uqqObz7VtOrdTvDDqpb7A17" +
           "Z3CLD/IDwI86Jp+uQHY3Y6Uk/97KwTd+cbbmCrDtCRKicCBO+K7WtqegRLCA" +
           "Zk8kPaL1/Tkkyo7+3d9efHBv9u+/F/nLIeat68unpKsvPvrrC5tXoDzZOEaq" +
           "ITGw4iypl83hRfUok+aNWdIomyNF2CJokakyRmotVT5jsbFMkjQhrCmSgvCL" +
           "487GUi+Wv5z0Vtzv17g0QK5fYMagZqkZwX/AzF5P2b8OLmFauh6Y4PWUQtlW" +
           "aXtKGv5K9CfnWyOjcDTLzPGr32Ba6RIZ+/+I8Ni52abYj+ETguc/+GDQscO+" +
           "D7cOOZfy7aVbORQV9lgklRzXdVe27mPdPiJfxeZrReznJNTn9CKdhexMiz+/" +
           "LtY/J16x+cZ/AVyWI+2UFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AAA=");
    }
    protected static class FlowDivElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowDivElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowDivElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcRxWfO3/Edmyf7fgjOLGTuJegOOEuUZtC5dDWn43D" +
           "+UNxEqkOzWVud+5u473dze6sfXYptJVQA0IhhLRNK9V/uapApa0QFSDRyqgS" +
           "bVVAaomAgpoWIVXlI6IRUvkjfL03u3u7t2cnCn9w0s7tzbx5M++93/zem3v+" +
           "KqmxTNLLNJ7giwazEqMan6amxeRhlVrWUehLS09W0b+f/GjyriipnSXNeWpN" +
           "SNRiYwpTZWuW9CiaxakmMWuSMRlnTJvMYuY85YquzZIOxRovGKoiKXxClxkK" +
           "HKdmirRSzk0lY3M27irgpCcFO0mKnSQHw8MDKdIo6caiL745ID4cGEHJgr+W" +
           "xUlL6jSdp0mbK2oypVh8oGiSPYauLuZUnSdYkSdOqwdcFxxOHahwQd9LsU+u" +
           "n8+3CBdsopqmc2GedYRZujrP5BSJ+b2jKitYZ8iXSVWKbAwIcxJPeYsmYdEk" +
           "LOpZ60vB7puYZheGdWEO9zTVGhJuiJMd5UoMatKCq2Za7Bk01HHXdjEZrN1e" +
           "staxssLEx/ckLz55suX7VSQ2S2KKNoPbkWATHBaZBYeyQoaZ1qAsM3mWtGoQ" +
           "7BlmKlRVltxIt1lKTqPchvB7bsFO22CmWNP3FcQRbDNtietmybysAJT7qyar" +
           "0hzY2unb6lg4hv1gYIMCGzOzFHDnTqmeUzSZk23hGSUb418AAZi6ocB4Xi8t" +
           "Va1R6CBtDkRUquWSMwA9LQeiNToA0OSke12l6GuDSnM0x9KIyJDctDMEUvXC" +
           "ETiFk46wmNAEUeoORSkQn6uTB889qB3SoiQCe5aZpOL+N8Kk3tCkIyzLTAbn" +
           "wJnY2J96gna+cjZKCAh3hIQdmR9+6dq9e3tX33BktqwhM5U5zSSellYyzW9v" +
           "Hd59VxVuo87QLQWDX2a5OGXT7shA0QCG6SxpxMGEN7h65Gf3P/xd9pcoaRgn" +
           "tZKu2gXAUaukFwxFZeZ9TGMm5UweJ/VMk4fF+DjZAO8pRWNO71Q2azE+TqpV" +
           "0VWri9/goiyoQBc1wLuiZXXv3aA8L96LBiGkAx5yJzwfEOfzPjacSMm8XmBJ" +
           "KlFN0fTktKmj/VYSGCcDvs0nM4D6uaSl2yZAMKmbuSQFHOSZOwCHhmkW2Ji0" +
           "5nPJIewb0QujXm8CwWb8f5YporWbFiIRCMTWMA2ocIIO6arMzLR00R4avfZC" +
           "+i0HYngsXD9xMgYrJ5yVE2LlRGnlBKycqFg5PqbqCyPKPHIhGDNG8awvkkhE" +
           "bKMd9+VgASI5B5wApNy4e+aBw6fO9lUBCI2FaggDivaVJadhnzg8tk9LL7Y1" +
           "Le24sv+1KKlOkTZYyaYq5ppBMwcsJs25B70xA2nLzx7bA9kD056pS0wG8lov" +
           "i7ha6vR5ZmI/J+0BDV5uw1OcXD+zrLl/snpp4ZHjX9kXJdHyhIFL1gDX4fRp" +
           "pPkSncfDRLGW3thjH33y4hMP6T5llGUgL3FWzEQb+sJACbsnLfVvpy+nX3ko" +
           "LtxeD5TOKRxBYMve8BpljDTgsTvaUgcGZ3WzQFUc8nzcwPOmvuD3CAS3ivd2" +
           "gEUMj2gcnj+4Z1Z842ingW2Xg3jEWcgKkT0+P2M889tf/ul24W4v0cQCFcIM" +
           "4wMBckNlbYLGWn3YHjUZA7n3Lk1/+/Grj50QmAWJ29ZaMI7tMJAahBDc/NU3" +
           "zrz7/pWVy1Ef5xyyu52BIqlYMrIObWq+gZGw2i5/P0COKjAHoiZ+TAN8KlmF" +
           "ZlSGB+ufsZ37X/7ruRYHByr0eDDae3MFfv+nhsjDb538R69QE5EwOfs+88Uc" +
           "xt/kax40TbqI+yg+8k7PU6/TZyB3AF9byhITFEyED4gI2gFh/z7R3hEa+yw2" +
           "O60g+MvPV6CISkvnL3/cdPzjV6+J3ZZXYcFYT1BjwIEXNruKoL4rTE6HqJUH" +
           "uTtWJ7/Yoq5eB42zoFECQramTGDOYhkyXOmaDb/76Wudp96uItEx0qDqVHY4" +
           "ELIWoJtZeSDdonHPvU5wFzDcLcJUUmF8RQc6eNvaoRstGFw4e+lHXT84+Nzy" +
           "FYEyw9GxJajw06Ltx+Yzoj/KSb1h6hxUMSikai1RAfqIFHPbvRTpfQcR6a8R" +
           "Ee+bObmnInHIeiHhpgmA18jUBF4PRJIQ8YmXZwwMSM96VZGo6FYevbgsTz27" +
           "36ld2sorjVEopL/363/9PHHpgzfXSGu1blUb3DisV5ZyJkS16NPee80X/vjj" +
           "eG7oVrIN9vXeJJ/g721gQf/62SO8ldcf/XP30bvzp24hcWwL+TKs8jsTz795" +
           "3y7pQlSUxk7OqCipyycNBL0Ki5oM7gAamok9TeJ03VZCUReCpgeeD10Ufbg2" +
           "eQuIYrOnkhLXmxoij6gDaw+KLeLEYIGfcAp8b6AdMbpwuySgOaJLNuJPbOP+" +
           "G9BRGpujgCHJZFCkeso2BZW5WBZjn8PmmHOcBv7Hc48dg0YRbhBrllfeHvbd" +
           "arUGoN9ccUF0LjXSC8uxuq7lY78ReC9dPBoBuVlbVQOBD4Kg1jBZVhF+anTo" +
           "1RBfc1Ad3HhznFRBKyw57cyB20X3+nOAtErvwVlnIODhWZzUiO+gHOekwZeD" +
           "cDovQZEF2BOI4CtQbyWanLtRMVLJsSLmHTeLeWlKsH7Awy+u9t5BtZ3LPZS7" +
           "y4cnH7x257NO/SKpdGlJXAXhZuuUUqXDvmNdbZ6u2kO7rze/VL8z6oK61dmw" +
           "fwS3BBA/CPRoYO7pDiV3K17K8e+uHHz1F2dr3wGyPUEiFM7DicDF2vEUVAg2" +
           "sOyJlM+zgb+GRNUxsPvpxbv3Zv/2e5G+XF7eur58Wrr83AO/urB5BaqTjeOk" +
           "BvICK86SBsUaWdSOMGnenCVNijVahC2CFoWq46TO1pQzNhuXU6QZYU2RE4Rf" +
           "XHc2lXqx+uWkr+J2v8adAVL9AjOHdFuTBf0BMfs9Zf85eHxpG0Zogt9TCmV7" +
           "pe1paeRrsZ+cb6sag6NZZk5Q/QbLzpS4OPg3hE/OLQ7D/gc+EXj+jQ8GHTuc" +
           "23DbsHsl3166k0NN4YxVpVMThuHJNhDDOSJfx+YbReznJNLv9iKbRZxEiz+/" +
           "KdY/J16x+dZ/AQ4+j4WSFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9EXzFZxIkhtPuBcit3m+G8JTO1CzeXdlrayicc9h0frw93hZa1frOHN4HH7z" +
           "daVc1bX3Dwq3sgUYnmvZ3rZsm9U3rpys4aZnuYdudk+RneM+/a5nnlX5z+T3" +
           "DmpNU3h0P7g+Oi6Pjzx58wMrl93R7AogX3nXvzw4fJP+tldQ1n3klJCnWf42" +
           "99zXGq9XPrKHnD0qh1x3e3SS6OrJIshFH4SR7wxPlEIeOjLP/ak1HoLf7xyY" +
           "5zs3Lq3e0O5nMkfbutepOt7e1jEyBzu06j2pVWNCyYzJuEqUWiyjjl+mCvj2" +
           "tPGheRQfSCE4ZHb3cWYH1t85cfCTjtUnym0hcu8NrwIO58q90psF6DcPXHeZ" +
           "ub2AUz7/7KUL9z87+qusin50SXYbi1yYR5Z1vHx17Pm854O5ka3Hbdtilpf9" +
           "vCdEHn554ULkLGwzTd69pXl/iDx4cxoYykfPx6l+LUQun6YKkXPZ7/FxHwqR" +
           "i7tx0Gzbh+NDPgJlgkPSx496N6iAbet/yZljkXiAPJlt7/pJtj0iOV6eT6M3" +
           "u4Y+jLRoexF9TfnCs+3u218iP7O9HlAsabNJuVxgkVu3NxVH0frYTbkd8jrf" +
           "fOJHd3zxttcdwsodW4F3MXRMtkduXIuv2V6YVc83f3D/773xN5/9dlaQ+19b" +
           "ma7RHyAAAA==");
    }
    protected static class FlowParaElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowParaElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowParaElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcRxWfO3/Edmyf7fgjOImTuJegOOEuUZtC5dDWn4nT" +
           "84fiJFIdmsvc7tzdxnu7m91Z++xSaCuhpgiFENI2VKr/clWBSlshKkCilVEl" +
           "2qqA1BIBBTUg8U/5CE2EWv4IX+/N7t7u7dmJwh+ctHN7M2/ezHvvN7/35l68" +
           "Smosk/QwjSf4gsGsxIjGp6hpMXlIpZZ1FPrS0jNV9O8nP5y4J0pqZ0hznlrj" +
           "ErXYqMJU2ZohWxTN4lSTmDXBmIwzpkxmMXOOckXXZkiHYo0VDFWRFD6uywwF" +
           "jlMzRVop56aSsTkbcxVwsiUFO0mKnSQHwsP9KdIo6caCL74xID4UGEHJgr+W" +
           "xUlL6jSdo0mbK2oypVi8v2iS3YauLuRUnSdYkSdOq/tdFxxO7a9wQe8rsU9u" +
           "nM+3CBdsoJqmc2GedYRZujrH5BSJ+b0jKitYZ8iXSFWKrA8IcxJPeYsmYdEk" +
           "LOpZ60vB7puYZheGdGEO9zTVGhJuiJPt5UoMatKCq2ZK7Bk01HHXdjEZrN1W" +
           "staxssLEp3YnLz5zsuV7VSQ2Q2KKNo3bkWATHBaZAYeyQoaZ1oAsM3mGtGoQ" +
           "7GlmKlRVFt1It1lKTqPchvB7bsFO22CmWNP3FcQRbDNtietmybysAJT7qyar" +
           "0hzY2unb6lg4iv1gYIMCGzOzFHDnTqmeVTSZk63hGSUb4w+AAExdV2A8r5eW" +
           "qtYodJA2ByIq1XLJaYCelgPRGh0AaHLSvaZS9LVBpVmaY2lEZEhuyhkCqXrh" +
           "CJzCSUdYTGiCKHWHohSIz9WJA+ce1g5pURKBPctMUnH/62FST2jSEZZlJoNz" +
           "4Exs7Es9TTtfOxslBIQ7QsKOzA++eP3+PT0rbzkym1aRmcycZhJPS8uZ5nc3" +
           "D+26pwq3UWfoloLBL7NcnLIpd6S/aADDdJY04mDCG1w58tMHH/0O+0uUNIyR" +
           "WklX7QLgqFXSC4aiMvMg05hJOZPHSD3T5CExPkbWwXtK0ZjTO5nNWoyPkWpV" +
           "dNXq4je4KAsq0EUN8K5oWd17NyjPi/eiQQjpgIfcDc9HxPn8DRtOpGReL7Ak" +
           "laimaHpyytTRfisJjJMB3+aTGUD9bNLSbRMgmNTNXJICDvLMHYBDwzQLbExa" +
           "c7nkIPYN64URrzeBYDP+P8sU0doN85EIBGJzmAZUOEGHdFVmZlq6aA+OXH8p" +
           "/Y4DMTwWrp84OQgrJ5yVE2LlRGnlBKycqFg5Pqrq80AyFMkQrBmleNgXSCQi" +
           "9tGOG3PAAKGcBVIAVm7cNf3Q4VNne6sAhcZ8NcQBRXvLstOQzxwe3aell9ua" +
           "Frdf2fdGlFSnSBusZFMVk82AmQMak2bdk96Ygbzlp49tgfSBec/UJSYDe62V" +
           "RlwtdfocM7Gfk/aABi+54TFOrp1aVt0/Wbk0/9jxL++Nkmh5xsAla4DscDo6" +
           "s1Di83iYKVbTG3viw09efvoR3eeMshTkZc6KmWhDbxgpYfekpb5t9NX0a4/E" +
           "hdvrgdM5hTMIdNkTXqOMkvo9ekdb6sDgrG4WqIpDno8beN7U5/0eAeFW8d4O" +
           "sIjhGd0BzzX30IpvHO00sO1yII84C1kh0sfnp43nfvOLP90p3O1lmligRJhm" +
           "vD/AbqisTfBYqw/boyZjIPfBpalvPnX1iRMCsyBxx2oLxrEdAlaDEIKbv/LW" +
           "mfd/f2X5ctTHOYf0bmegSiqWjKxDm5pvYiSsttPfD7CjCtSBqIkf0wCfSlah" +
           "GZXhwfpnbMe+V/96rsXBgQo9Hoz23FqB3/+pQfLoOyf/0SPURCTMzr7PfDGH" +
           "8jf4mgdMky7gPoqPvbflW2/S5yB5AGFbyiITHEyED4gI2n5h/17R3hUa+yw2" +
           "O6wg+MvPV6CKSkvnL19rOn7t9etit+VlWDDW49Tod+CFzc4iqO8Kk9MhauVB" +
           "7q6ViS+0qCs3QOMMaJSAka1JE6izWIYMV7pm3W9/8kbnqXerSHSUNKg6lR0O" +
           "hLQF6GZWHli3aNx3vxPceQx3izCVVBhf0YEO3rp66EYKBhfOXvxh1/cPvLB0" +
           "RaDMcHRsCir8tGj7sPmM6I9yUm+YOgdVDCqpWkuUgD4ixdx2L0d630FE+mtE" +
           "xPtGTu6ryByyXki4eQLgNTw5jvcDkSREfOLlGQMDsmWtskiUdMuPX1ySJ5/f" +
           "5xQvbeWlxghU0t/91b9+lrj0h7dXyWu1blkb3DisV5ZyxkW56NPeB80X/vij" +
           "eG7wdrIN9vXcIp/g761gQd/a2SO8lTcf/3P30Xvzp24jcWwN+TKs8tvjL759" +
           "cKd0ISpqYydnVNTU5ZP6g16FRU0GlwANzcSeJnG67iihqAtBswWej10Ufbw6" +
           "eQuIYrO7khLXmhoij6gDaw+KLeLEYIWfcCp8b6AdMTp/pySgOaxLNuJPbOPB" +
           "m9BRGpujgCHJZFCleso2BJW5WBZjn8PmmHOc+v/Hc48dA0YRqHf1+srbxN7b" +
           "rdcA9RsrrojOtUZ6aSlW17V07NcC8KWrRyNAN2uraiDyQRTUGibLKsJRjQ6/" +
           "GuJrFsqDm2+OkypohSWnnTlwv+heew6wVuk9OOsMRDw8i5Ma8R2U45w0+HIQ" +
           "T+clKDIPewIRfAXurYSTczsqRipJVgS941ZBL00JFhB4+sXl3juptnO9h3p3" +
           "6fDEw9fvft4pYCSVLi6KyyDcbZ1aqnTat6+pzdNVe2jXjeZX6ndEXVS3Ohv2" +
           "z+CmAOQHgB8NTD7doexuxUtJ/v3lA6///Gzte8C2J0iEwoE4EbhaO56CEsEG" +
           "mj2R8ok28OeQKDv6dz27cO+e7Ee/E/nLJebNa8unpcsvPPTLCxuXoTxZP0Zq" +
           "IDGw4gxpUKzhBe0Ik+bMGdKkWCNF2CJoUag6RupsTTljszE5RZoR1hRJQfjF" +
           "dWdTqRfLX056K+73q1waINfPM3NQtzVZ8B8ws99T9q+DR5i2YYQm+D2lULZX" +
           "2p6Whp+M/fh8W9UoHM0yc4Lq11l2pkTGwT8ifHZucSj2P/CJwPNvfDDo2OHc" +
           "h9uG3Ev5ttKtHIoKZ6wqnRo3DE+2ARGC6r6KzdeK2M9JpM/tRTqLOJkWf35d" +
           "rH9OvGLzjf8C5FcjQZQUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "svRF+2WcSJIbT7gXIbf5gRfBUzvQsnl3Za2sonHPYdX68Pd4WWtX6zhzeBx+" +
           "43W1XM1z9g8qt4oNSK5HO/62bJvVN66crOGmZ7mHbnZRkZ3jPvXOZ57TuE/n" +
           "9w5qTRN4dD+4PzouT4A8dfMDay+7pNkVQL78zn9+UHyD8daXUdZ95JSQp1n+" +
           "du/5r7Zeo35kDzl7VA657vroJNHVk0WQiwGI4sAVT5RCHjoyz/2pNR6C3x8e" +
           "mOeHNy6t3tDuZzJH27rXqTre3tYxMgc7tOo9qVVXBTUzJumpcWqxjHr1ElXA" +
           "t6VNAM2jBkCOwCGzu48zO7D+zonDn3asPlFui5D7bnwXcDgZ9nLvFqDjPHDd" +
           "deb2Ck793HOXLtz/3PCvsjL60TXZbQxyQY9t+3j96tjzeT8AupktyG3bapaf" +
           "/bw7Qh5+aeEi5CxsM03etaV5X4Q8eHMaGMtHz8epfi1CLp+mipBz2e/xcR+K" +
           "kIu7cdBu24fjQz4CZYJD0seP+jcogW0LgMmZY6F4AD2Zce/6acY9Ijlen0/D" +
           "N7uIPgy1eHsVfU39/HMd9m0vEp/e3g+otrzZpFwuMMit26uKo3B97KbcDnmd" +
           "bz/54zu+cNurD3Hljq3AuyA6JtsjNy7GU44fZeXzzR/c/3uv+83nvpVV5P4X" +
           "Beh6VCEgAAA=");
    }
    protected static class FlowRegionBreakElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionBreakElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowRegionBreakElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "IZlw8ec3xfrnxSs23/ov2h4unqIUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "r/+d57+VJ+j+FwrsEH43IAAA");
    }
    protected static class FlowRegionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowRegionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "htj/vHjFxzf/C4JPqQyYFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "zCUgAAA=");
    }
    protected static class FlowLineElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowLineElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowLineElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Py9e8fHt/wLnY9TQlBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fLMzOzssO7Pv7bLvHWh3gz47Dydxh1cSx4md" +
           "xI5jx4ndwuDY147jZ/zIi24LSLwrQLBLqQT7F6gtWh6tilqpotqqagGBKlGh" +
           "vqQCqiqVliKxf5RWpS29dr7vy/d9M7NoVamRcuNc33PuOfec87vnnvvCD5Fz" +
           "UYjkAt9Zm44f74NVvD9z8P14HYBon+nifTWMgN5w1CgSYd817YkvXfrxTz46" +
           "vbyHnFeQu1XP82M1tnwvGoDIdxZA7yKXdr1NB7hRjFzuztSFiiax5aBdK4qv" +
           "dpFXHSONkSvdQxFQKAIKRUAzEdDabhQkejXwEreRUqheHM2RX0XOdJHzgZaK" +
           "FyOPn2QSqKHqHrDpZxpADhfS/xJUKiNehchjR7pvdb5O4edy6LO/8bbLv3cW" +
           "uaQglyxPSMXRoBAxnERBbneBOwFhVNN1oCvInR4AugBCS3WsTSa3gtwVWaan" +
           "xkkIjhYp7UwCEGZz7lbudi3VLUy02A+P1DMs4OiH/84ZjmpCXe/b6brVkEr7" +
           "oYIXLShYaKgaOCS5xbY8PUYePU1xpOOVDhwASW91QTz1j6a6xVNhB3LX1naO" +
           "6pmoEIeWZ8Kh5/wEzhIjD96UabrWgarZqgmuxcgDp8f1t6/gqNuyhUhJYuTe" +
           "08MyTtBKD56y0jH7/JB9w4ff4bW9vUxmHWhOKv8FSPTIKaIBMEAIPA1sCW9/" +
           "uvsJ9b6vvH8PQeDge08N3o75g1956S2vf+TFr23HvOYGY7jJDGjxNe0zkzu+" +
           "9VDjKeJsKsaFwI+s1PgnNM/cv3/w5uoqgJF33xHH9OX+4csXB38uv/Nz4Ad7" +
           "yEUaOa/5TuJCP7pT893AckDYAh4I1RjoNHIb8PRG9p5GboXPXcsD217OMCIQ" +
           "08gtTtZ13s/+wyUyIIt0iW6Fz5Zn+IfPgRpPs+dVgCDIvfCLlBHkzENI9jnz" +
           "mrSNEQ2d+i5AVU31LM9H+6Gf6h+hwIsncG2n6AR6vY1GfhJCF0T90ERV6AdT" +
           "cPACBg3wIqgjGi1MtJ72kb7bPOzdT50t+P+ZZpVqe3l55gw0xEOnYcCBEdT2" +
           "HR2E17Rnk3rzpS9c+8beUVgcrFOMtODM+9uZ97OZ949m3ocz71838xXK8Zep" +
           "lVJohNpQahrsa+TMmUyOe1LBts4AB9kQFCBc3v6U8Fbm7e9/4iz0wmB5S2oN" +
           "OBS9OWo3djBCZ2CpQV9GXvzk8l3Sr2F7yN5J+E2VgV0XU/J+CppH4HjldNjd" +
           "iO+l933/x1/8xDP+LgBP4PkBLlxPmcb1E6eXPfQ1oEOk3LF/+jH1y9e+8syV" +
           "PeQWCBYQIGMVrh7EnkdOz3Eivq8eYmWqyzmosOGHruqkrw4B7mI8Df3lrifz" +
           "hzuy5zvhGl9KHf61cK0fPoiA7Dd9e3eQtvds/Sc12iktMix+oxB8+m/+4p+L" +
           "2XIfwvalYxuhAOKrx6AiZXYpA4U7dz4ghgDAcX//yf7Hn/vh+34pcwA44skb" +
           "TXglbRsQIqAJ4TK/52vzv/3udz7z7b2d08Rwr0wmjqWtjpS8kOp0x8soCWd7" +
           "3U4eCDUOjMPUa64MPdfXLcNSJw5IvfS/Lr02/+V//fDlrR84sOfQjV7/sxns" +
           "+n+ujrzzG2/790cyNme0dKvbrdlu2BY/795xroWhuk7lWL3rLx/+za+qn4ZI" +
           "DNEvsjYgAzQkWwMkMxqa6f901u6fepdPm0ej485/Mr6OpSTXtI9++0evln70" +
           "xy9l0p7MaY7buqcGV7fulTaPrSD7+09HeluNpnBc6UX2ly87L/4EclQgRw3C" +
           "W8SFEIdWJzzjYPS5W//uT/70vrd/6yyyRyEXHV/Vt4AC9wDo3SCaQghbBW9+" +
           "y9a6y9TclzNVkeuU3zrFA9m/s1DAp26OL1SakuxC9IH/5JzJu//hP65bhAxZ" +
           "brATn6JX0Bc+9WDjTT/I6HchnlI/sroem2H6tqMtfM79t70nzv/ZHnKrglzW" +
           "DnJDSXWSNHAUmA9FhwkjzB9PvD+Z22w38qtHEPbQaXg5Nu1pcNntCfA5HZ0+" +
           "XzyOJz+FnzPw+z/pN13utGO7o97VONjWHzva14NgdQZG67nCfmUfS+nfnHF5" +
           "PGuvpM3Pb82UPv4CDOsoS0ohhWF5qpNN/JYYupijXTnkLsEkNd1/Zk4lY3Mv" +
           "TMszd0q1399mdltAS9tCxmLrEvhN3ecXt6OyneuOHbOuD5PED/3jR7/5kSe/" +
           "C23KIOcW6XpDUx6bkU3SvPm9Lzz38Kue/d6HMpSC8CN94Hcr30u5dl9O47Rp" +
           "pg11qOqDqapClg101SjuZcAC9Ezbl3Xlfmi5EH8XB0kh+sxd37U/9f3PbxO+" +
           "0357ajB4/7Mf/On+h5/dO5ZmP3ldpnucZptqZ0K/+mCFQ+Txl5slo6D+6YvP" +
           "/NFvP/O+rVR3nUwam/BM9Pm/+u9v7n/ye1+/QYZyi+P/Hwwb3357uxTRtcNP" +
           "Ny+rhaUmrUa5pFhp6u56UTHMgcdOmWIzz3vdhjhvFqaaOwuVXGdpWFOOjkfT" +
           "gr7WF5OoUgWbnsKp3GIsBzEj8cPSoNFo2RObC4zQCvhxOVApYaC2pJEV8gHd" +
           "HVD8sNYTjKo/86eUkBtQACfWSkFx9XjAUe38bF3h1gSO45V2jBKb0KugpCTI" +
           "uGs7Bbu6HGisYkktVsRZUY6dqSPNR5pudhtDdDwco0YSztbjxAra6ojlQMAK" +
           "lGiVsEDs5eWoPGhjwopjFUexSytH642wtbByNw6XlFk/KkuNqCp3pp2w22BQ" +
           "vseXmmK+uRakaI7P1UG8iRS9rmwwptcUBMm0SFn16njHHuoqO5CIqobVqxzZ" +
           "IG1TQrulRHQSXuHsquOuk7lD8VHfqWHrAU5KK30zj0pi2DNFheDJiWlxTI0Y" +
           "TjvkAtctj11X7BHG06xDsVjFWW42YadLFXQFt23LcGf+2g9HLYORMEey3WWv" +
           "0e4JYnE+EcJGUGficnERCHIbE7HcphE1KlpJKbsjm22Zm5kyVCtNvyHHSWvu" +
           "TrWC6cvlysJfUCWuWLBDwDmrYdIPnXayELG5oozn9jRyIn444SesrTVpMlj0" +
           "eLuu0Fq+p24aogzXEpsH9cgF8lyqS6MxvSmO5ICT8+sW0V1M+WF7InOKbFdR" +
           "Kai3q70CpqjlCWOAdc0hkxifR4LXN9WysZjn+tMWXSbNJdZptRS3A0huLNFE" +
           "UDAVMVQpCR9UZ+0qU2+RwdTszsCkgEkTqSXLDYwb1AdzRRUVs14emXhTLfI1" +
           "v+cwRCXo9HS55QDdn82HvC20cHWkdQIuoOh2jWFWebjrNpko5vW1Q5t9QnNJ" +
           "HEcFMokGQ7s56ZWWo+G4wlY7VjFuWP560xVrE29JeXKBIaoQnXOagHcatWlx" +
           "SvO6qwNUWxRzi0khrGzM9YhQeXc4N2SR6a+FRYAvQJFMcrlgGbJzksWEatt2" +
           "inYixi7GbViepetTzo5UTexORbUEUGCTM3RdQwWp04oUBqZEoW5Sy3wjDOtD" +
           "duCOXVrV1rbXGregE4i9iLWMYBWZfWD7MwqeJeeTeGAaDDGatzqhtBpr9HCg" +
           "DGXaVEtUcRCFYXHiNACVIyhzRQo1A4XBS1ujkleyCps6swZrh9W6Yode5wcD" +
           "1ikrbNsoFJlWQ2N7fKFbHtaJMScEeuTyFClslFWzxus4bldq/qil1kW8k/dW" +
           "XCvqrJoTbFn2MbfZ2rTQApjQ3ryiCk3BHA4iUudqDcvwow7uuowrdAmH9And" +
           "ELtFj6+t+9NB5Ilmpb4xHQ8viTIntVWOb1aYdVCY+bkgZzJuQ7P5Rd2dAdYc" +
           "CwJvVVrT9nK1XJpsTbNrnaWW9BOXB32PrIyl5dBn6+q8N4jMgqOPPFkh8AXp" +
           "960RmmdVLOb6czQEVkAGTMGteW45kCe1CdtmG3KfA4DoyVi+UUCN1hKGdS4C" +
           "ZTmJlutlvhg4K1YSgmp106xquMoTfpX2J22XDVC9sw4WeZswug1/DXKxRXT8" +
           "ZCjVKiCqTbokrvfp6nqYm5WAIlsFItI0FF0ITrCqjAyt5HcwiJXqSrbECjZV" +
           "mgJpE51KTHBjLCGq47o27WKAY/KiQM54ZUSUZhum04I6tceFoFYCm8RxzY6N" +
           "471RxQQSa1SbWnNKLSiwWdRoX4G+YtT8qkbEHC0qm4g12jJuN4E2nSx5HHDd" +
           "XlXeLFCP8nKlYcmQ56Kw4elouexP6yabF0eMZ0V52Yh7Sm9l9xd+dTEoeuGm" +
           "kGu69ZHSKMlljC2hplZ3VJJqduQFWuEKPIEaxbEjxGKbk431ZA6mwno+8jor" +
           "0sODRckSozhKinViOqiDoJbvCX21VO8z6oKPe+FS7mOb2OujarFKFHNdk4fe" +
           "TWJKZVIu1too2mu2PXsh9dFyXZrTM2akbAh3EUzJnBJXNzLnCgNjMEs6szY6" +
           "qBKFYpms8326teqORp2GWXLp2oBiuDVZLa4B0Etjt+/n+p4k8yg39jpEnQoA" +
           "35U2eMAt2oxLACoGUjwiyXGT4GWNa1CzfJ4aslWJmRtkvjcni1QhtPMEtLq+" +
           "MHuKgjVMks7HIuPUvYhfKqEnstMYzeGdIofliLENTFmV6nnXa5aaPX/kM7EC" +
           "RqTue20DHeIFakPqXY2RhglVXfG1FmAX6nwQxS1q2QQ5tz1Wq8BoVfC53VBK" +
           "YCY3HbE0MtrRqmp4q7Y1tIshmSddX47rTF6aW3WDH3R0tQA2YyG3XFpYXJ3R" +
           "camoFRljAMZ0mR41R2utNrZYsVk00WZTauANHYxnzSUtFsN4OLICKcYrLLNW" +
           "klBBh5UN5kyA6q/gnlpshGglH1VFp19ZVwZOIdT1hepzreU47zHugIx9m6i0" +
           "N5KBcly/FLrTQtkuwA27YhXnjWIF1OtoMZRKuWVnVEWJxEhk1HBFgmiVdHNk" +
           "uZKMG5rneWgRa1Rw2RGxlV1h55wVrFcaW+/0Oi7u97pmU018eyYCBitKVGM4" +
           "AI16aEZYAqx5i4irU5lfafCcbgfapODS/Q7NhSTmx74pmqt8bpl4y4XsFFbc" +
           "rOFNOjXcN5NCyURlTSbZcmtGkWWuJiu2jbXGZcubUJToyo7XM/imscKLM7Zf" +
           "Qz0v0lqk0OG7+ZDIA9A04iTOV8l8K5ckDbqcX4X4CkjyWDfWVanaXTIgaftY" +
           "raiu47nf7tXzFK/i8LxSmtZYMayqvtXnRmZ/4pY0Jj9eUkxZ0/RJDVWZCiqO" +
           "a6P5uFjqzDd2v72EGDBftXR+5vWFUi+u94PC2O+ZjUKNt3K1UBstbQ8vKsMZ" +
           "JQhhc1pelQvC2PGFSYNcEvSiuxjrwgToZRItJtWgzUzLFQNVN+KyZ87Hki84" +
           "WKtU2MwJiXOxSn46dssgJBZk0qpii3wu10vm00TnN4VNrjGqcXy7pC2VUXtd" +
           "5omxbgWgg9JaWCfQam7iqWSpHos4TU95dtXzGnndoqmuTLNsO1qXB2xc6mlT" +
           "bCz3Kv0KKIX5SlREK546NbozajGWqjlGIvBKRBnjeF2tJUVm5VFCrTSqUyOd" +
           "MQsdttsK2q64WmwC2l0N/Nj0XXOgtudcx92wYBRtNHkj6J1e1FHohkUnk5k1" +
           "EeZ9GfW6glRsoeNcX6h1pZypwGRmnnfq/Wq9h0YzZVItA3oQtDAFeg0hCK5U" +
           "CUA1gF7FFOjqIqZG7FJvRtoa+IbPOgEW2+3+crp0DY+CZx10yaJNY4ayKD7D" +
           "vHYt4XNFcpKMq0nBGW1sjNJwTRJ8XB5YYNLk8qXBejDJkTMXG2r4WhQqpZLl" +
           "DUea4MfGYj0u9NcEqBowo152PZkQeafOw+T/jW9MjwVvfWUnszuzQ+jRXQM8" +
           "kKUv2q/gRLK68YR7MXJbEPoxPLUDPZt3V9bKKhr3HFatD3+Pl7V2tY4zh8fh" +
           "N19Xy9V9d/+gcjtxYHrZo91gW7bN6htXTtZw07Pcwze7qMjOcZ9597PP69xn" +
           "83sHtaYxPLof3B8dlydEnr75gbWXXdLsCiBfffe/PCi+afr2V1DWffSUkKdZ" +
           "/k7vha+3Xqd9bA85e1QOue766CTR1ZNFkIshiBO4OZ0ohTx8ZJ77U2s8DFV9" +
           "4sA8T9y4tHpDu5/JHG3rXqfqeHtbx8gc7NCq96RWXRa1zJikryWpxTLq5ctU" +
           "Ad+RNiE0jxYCNQaHzO4+zuzA+jsnjn7WsfpEuS1G7rvxXcDhZNgrvVuAjvPA" +
           "ddeZ2ys47QvPX7pw//PDv87K6EfXZLd1kQtG4jjH61fHns8HITCsbEFu21az" +
           "guznvTHyyMsLFyNnYZtp8p4tzQdi5MGb08BYPno+TvXrMXL5NFWMnMt+j4/7" +
           "SIxc3I2Ddts+HB/yMSgTHJI+fjy4QQlsWwBcnTkWigfQkxn3rp9l3COS4/X5" +
           "NHyzi+jDUEu2V9HXtC8+z7DveKn82e39gOaom03K5UIXuXV7VXEUro/flNsh" +
           "r/Ptp35yx5due+0hrtyxFXgXRMdke/TGxfimG8RZ+Xzzh/f//ht+6/nvZBW5" +
           "/wV/Bj/VISAAAA==");
    }
    protected static class FlowSpanElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowSpanElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowSpanElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "mtj/gnjFx9f/C6o4+JaUFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8wkWVWv75ud2dlh2Zl9ryv7ZEB3m3zVj6quageB7uqq" +
           "6ld1VXX1W2God1XX+9XV3bgKJLwNEFgQE9i/ICpZHhqJJgazxigQiAmG+EoE" +
           "YkxEkYT9QzSi4q3q7/v6+76ZWbIxsZO+XX3rnnPPueec3z333Od/AJ2PQqjg" +
           "e/Zat734QF3FBwsbPYjXvhoddHooJ4aRqhC2GEVD0HddfvKLl3/04w8bV/ah" +
           "C3PoXtF1vViMTc+NBmrk2UtV6UGXd72krTpRDF3pLcSlCCexacM9M4qv9aBX" +
           "nCCNoau9IxFgIAIMRIBzEeD6bhQgeqXqJg6RUYhuHAXQr0J7PeiCL2fixdAT" +
           "p5n4Yig6h2y4XAPA4WL2fwyUyolXIfT4se5bnW9Q+GMF+NnfeMuV3zsHXZ5D" +
           "l01XyMSRgRAxmGQO3emojqSGUV1RVGUO3e2qqiKooSna5iaXew7dE5m6K8ZJ" +
           "qB4vUtaZ+GqYz7lbuTvlTLcwkWMvPFZPM1VbOfp3XrNFHej6wE7XrYZU1g8U" +
           "vGQCwUJNlNUjktss01Vi6LGzFMc6Xu2CAYD0dkeNDe94qttcEXRA92xtZ4uu" +
           "DgtxaLo6GHreS8AsMfTwLZlma+2LsiXq6vUYeujsOG77Coy6I1+IjCSG7j87" +
           "LOcErPTwGSudsM8P+q//4Nvclrufy6yosp3JfxEQPXqGaKBqaqi6srolvPPp" +
           "3sfFB7783n0IAoPvPzN4O+YPfuXFN73u0Re+uh3zszcZw0oLVY6vy5+W7vrm" +
           "q4inaucyMS76XmRmxj+lee7+3OGbaysfRN4DxxyzlwdHL18Y/Pns7Z9Vv78P" +
           "XWpDF2TPThzgR3fLnuObthrSqquGYqwqbegO1VWI/H0buh0890xX3faymhap" +
           "cRu6zc67Lnj5f7BEGmCRLdHt4Nl0Ne/o2RdjI39e+RAE3Q++UBWC9gpQ/tl7" +
           "OmtjSIYNz1FhURZd0/VgLvQy/SNYdWMJrK0BS8DrLTjykhC4IOyFOiwCPzDU" +
           "wxcgaFQ3AjrC0VKHG1lf03PIo96DzNn8/59pVpm2V9K9PWCIV52FARtEUMuz" +
           "FTW8Lj+bNMgXP3/96/vHYXG4TjFEg5kPtjMf5DMfHM98AGY+uGHmq5TtpYIv" +
           "5tAItKHELNjX0N5eLsd9mWBbZwCmtAAoALi88ynhzZ23vvfJc8AL/fS2zBpg" +
           "KHxr1CZ2MNLOwVIGvgy98In0HeNfK+5D+6fhN1MGdF3KyLkMNI/B8erZsLsZ" +
           "38vv+d6PvvDxZ7xdAJ7C80NcuJEyi+snzy576MmqApByx/7px8UvXf/yM1f3" +
           "odsAWACAjEXg0AB7Hj07x6n4vnaElZku54HCmhc6op29OgK4S7EReumuJ/eH" +
           "u/Lnu8EaX84c/jVgrV93GAH5b/b2Xj9r79v6T2a0M1rkWPyLgv+pv/mLf67k" +
           "y30E25dPbISCGl87ARUZs8s5KNy984FhqKpg3N9/gvvox37wnl/KHQCMePXN" +
           "JryatQSACGBCsMzv+mrwt9/59qe/tb9zmhjslYlkm/LqWMmLmU53vYSSYLbX" +
           "7uQBUGODOMy85urIdTzF1ExRstXMS//r8mtKX/rXD17Z+oENeo7c6HU/ncGu" +
           "/2ca0Nu//pZ/fzRnsydnW91uzXbDtvh5745zPQzFdSbH6h1/+chvfkX8FEBi" +
           "gH6RuVFzQIPyNYByo8G5/k/n7cGZd6WseSw66fyn4+tESnJd/vC3fvjK8Q//" +
           "+MVc2tM5zUlbM6J/beteWfP4CrB/8Gykt8TIAOOQF/q/fMV+4ceA4xxwlAG8" +
           "RWwIcGh1yjMOR5+//e/+5E8feOs3z0H7FHTJ9kRlCyhgDwDerUYGgLCV/8Y3" +
           "ba2bZua+kqsK3aD81ikeyv+dAwI+dWt8obKUZBeiD/0na0vv/If/uGERcmS5" +
           "yU58hn4OP//Jh4k3fD+n34V4Rv3o6kZsBunbjrb8Weff9p+88Gf70O1z6Ip8" +
           "mBuORTvJAmcO8qHoKGEE+eOp96dzm+1Gfu0Ywl51Fl5OTHsWXHZ7AnjORmfP" +
           "l07iyU/AZw98/yf7ZsuddWx31HuIw2398eN93fdXeyBaz5cPsINiRv/GnMsT" +
           "eXs1a35ua6bs8edBWEd5UgooNNMV7XziN8XAxWz56hH3MUhSs/1nYWM5m/tB" +
           "Wp67U6b9wTaz2wJa1pZzFluXQG/pPr+wHZXvXHftmPU8kCR+4B8//I0Pvfo7" +
           "wKYd6PwyW29gyhMz9pMsb3738x975BXPfvcDOUoB+Bm/73ex72Zcey+lcdaQ" +
           "WUMdqfpwpqqQZwM9MYqZHFhUJdf2JV2ZC00H4O/yMCmEn7nnO9Ynv/e5bcJ3" +
           "1m/PDFbf++z7f3LwwWf3T6TZr74h0z1Js021c6FfebjCIfTES82SU1D/9IVn" +
           "/ui3n3nPVqp7TieNJDgTfe6v/vsbB5/47tdukqHcZnv/B8PGd97ZQqJ2/ejT" +
           "K83EciqPV5NCUsFIxVkvMU0fuH2jUyFLvNurS0GxbMjOIpwXuqlmGmw7nhhl" +
           "Za0kUoTh6oaZsyK7nM78uDPmR8iAIGhLslhfC02fF4WYbIzMIhP45GQ14Sdm" +
           "V/fqMwv2B60BwVq4yeKb0NpEGwYT13KXw5pWWbGxzaZScV22gKOlTQ2fhj4z" +
           "WwsCPFTb7SUtr7oL2sYN35tYRWUk2m5rJqQxN44puIJV06qLecGgvFgM3WA4" +
           "8kezpN8trsfh0BW8sj7x0ZAMCZeeU+lqtun2HD4ZdTGvPNh4I7Ha0YN2YOGk" +
           "rcxNI7V8zy9aHtpHJ8xGccgAIYauIcgdwmYtI+0O04IjdFmLLiaFQl+sF0hD" +
           "b5ijHmwjk8667EcVodFxyknAOKPZstXwLLdMS0HVpvol12lQ7sIMW+5AkZuD" +
           "UsS0KU2ESS5EUUbBzWmPoEQ/ZI2pO2Emkl/Vu8PReugskKof0oTSLuHWWHDW" +
           "rNBkhOHGluYBOZyzaTABx4J04krlrjgdLAbG0JWLpUEotHR96Irj7ob2BD5J" +
           "HMNezeMGvypVpNWkmyqO1plEWpcwWK3iqzjMbnw7qY0tRZdNwRV7DbSlW/20" +
           "TPNsi/G69GQu8liPQZuuEFh0Okcdf0SN54rJgbWz0MW0LaVJAW3wSqyjtjms" +
           "1aYkqaYbibdDP7JxrE2M2GrFCVZdudwI/XIhnBVIZOGxjSbvyRtmJaSdMua3" +
           "fLU4GbCKN5ja9JrRUoScsY5TT/roUhqM49Hc0Hs8SlK0b1tLtr4Uiq32YlKt" +
           "N+oWyiXN+cQM02KwURhZWDMmX2lvNsagXeLjFtLosGzUMXmjTwbDCDhLAw8t" +
           "XEmWRFuxhJ6lm/JkIgpmomnNdlzlkYSNhHRDq0IjwogVB48YbLqJtQ7PkyzS" +
           "JobRmoMXxILXKrVqtYbKRjQpKg7rshNhmMbhRBQrtWIhWqqF7mJFuyIlEboI" +
           "b1rdwXzIJRu6Oai3Jb9Hu+R6xleSqRT5KV6rGZWyvTZ8hyBKVoCJDbkxCKr8" +
           "tEmObdShHWbeX3esAq8GUqdd7hR0Z03UUMFkJkqR9ZMS3cH1kujNgnhKKZXG" +
           "gLIF3VyF+lSh18lSSUYdZIoVJ02y327AhYHKmz3M5MxejWWH5NqZl9IoEoRJ" +
           "0J0HqtukSnG/1gXrb6U9DZ3X5zyHFopKPyIJYl5iUNXS2wwur2VdnBuOPit1" +
           "xDU9bTHiaiQVU9QrOiS9oeGyKrXtAJsPSUEfNaJmja0Thl0cUIo9D0R7DUtp" +
           "uV2eFhMcIRm2KHMVcj1pzVi1FbmNOtYpelin3HQHzJTFp9R4iqalgGg0I1qU" +
           "Z2F7aY0M0u0ySrMg1uujNtqs8vWwv0YUWDK8ssbWSqMG4VUo0UtpkxPHY1Ee" +
           "uBsLT6xar4fJpZ5aqPaXDdqmBFdoLKM5xYxNvMw7PCNaBUkZ0jDD9yvrNa6x" +
           "POfWE0cLSJ9tLIezoF2tTli33HCGC1aYxnW9pMlMuzykUXWiyDWuFCAR52Jr" +
           "IVXNDuWrzLTZo806Nm1WmxwFm3jFnHUVaUhXlusUqWlaMh9UVJWJjJ41lqtd" +
           "e2I0pyvdn2mq5WtVpdafFkUEpg1lGeoKgxqDlEyStI+VKFqYMepSZGJl0kjH" +
           "C7k3Zkb+Bpf7HA0HJlxt6y0iVGm8NWH4dFCRmxwnYoIQFWRJGqa0Oq1XXHIi" +
           "693RECmw5QivobEGs3aCTKrLYsQTPbkdIQjTUKy+Lc16rYlbmbUW8ryOWVwY" +
           "rXCk4IZDFBGc+qST1CSJaWMcOamXwEaBFOR46U6XcK2mTMLivOYCYMEqMzoJ" +
           "BiZwn2rcdVHKkgjJXeJ4WscCq66YnRAh+ArAOX7s2OS8E8/gGRa1pstKaAxm" +
           "rcY6YNRmU9QqEQUvddeI7AWGbgqDao0nUTpll1EBx0fyOoZNcYWsh1JAomu9" +
           "ANsY168VrE2xtaoz3bJNjxy2o7fBv0Hc5ghY50x1VPOwmEPKdJFKxwV1ipBJ" +
           "1ywpS84fFHGHm4a4MbSXqqGPF9zI6fO8ohb6xrDBjZXZtF3lgyK+7pc3/eUU" +
           "pdxp3HFMuY4UBabXLkl8p0RFCY+MwqnEhfGwhnkc10+omcNa6XzsY72mPibK" +
           "9X6FWetcSHnFVssF0IQsDMmgHUsPF91U4tPhctKslWap2iTKcgRjXFjwBmB9" +
           "dWdEz6qsNKIpdzXkNHeFC96qxYpWZQgCqauLyrhbtCdWXbMmnTgpyYuljOvt" +
           "ZbHWTjq17lrmxhQPgAy3Kk2vgTcCxY2GmC7oQnuBrXAvaNRVdx4QRaGnVMCi" +
           "KlOUdd0GugFn2DJeGpjN4TLAlnA43aw6U3jZLLPuJC45pVBP1RYs+91NMPCo" +
           "SkUsVJto0ajBFIP3K0WnlEottVzjh3APafbYhZa0AnIB9xyyAieci8JwlCpU" +
           "G1Ha4wINgADDo0mlWSgMQLRQUmEzWrQDNXE3g1mfCKOu20EaIA+ZW0jRFNbV" +
           "KiKYocf3mxW9WienA54LLUytd5tYeTzumQMrbqINqjRjS41oNLaaLQkhRK1Z" +
           "W0siKbI9pRgRTsBW5wRXWDVJNdFHiq9Rq1azbjn8ujom4bkd1NcUHpvYgkNY" +
           "lraKhSbscDLC0PxIn4ZTrFrA+dUaKVaQ/qhXKCFe6E3pxLJLc1MZF8NOBYnr" +
           "VKGqLnhC6bHlQJ+ZreKgEU7odUi05ZK6SIM1WUADspZwU4PtOoQPcqmwx9CY" +
           "oSl0FW+UzKDWKKmKjpitcYUS2ptqU/bXw4aNs0ji4A1yNEFGqa4HcH05H6ey" +
           "g7ZWI91ezwJdqaVJtTuyU35GRKWajIUlJp5XQk4TsG5RdVuhvcLgPltfs77S" +
           "sufTumRIybI4CsZRBZsYfas2xeZ0rQ+wI1BwRRm3lKqxmW1wKq7LOsfLyHzS" +
           "Wlf52lQxfbULc0lolDC4oLliDWnEQ5RsGzMeoSRDZNEqQUUk7SzKY9yzyjjL" +
           "8iJA/VoFDasaVitLcG0Y80sbNSvSeq3ZAVhcrr7slUuKoc0tPBV8Xe7VTZe1" +
           "eImibWywGFJeihbN4cwrjpGZqQ/EVtDoOpu+OpE3gmSBUfSEYqyGSk5LaKnv" +
           "j6lI27h+gC20sNL3dSqA18zKqChzK53C9Q2HtssizraclmgYlIi0CyM+tlVx" +
           "Gou0WwxqCduTxtOF1fFtVB+OJawXDdsOo29qZIHdyIjdjLRCfVlfwvDKxRlW" +
           "R5BagS6TmiIsw36xi6hO6juhEMhOU2aHkqiv3MYQJRbVwiQarJphmWARv0i5" +
           "ZNCbYjUnXsC6u6BWNQ0mqh5S6IgjCqT/2bHgzS/vZHZ3fgg9vmsAB7LsRetl" +
           "nEhWN59wP4bu8EMvBqd2Vcnn3ZW18orGfUdV66Pfk2WtXa1j7+g4/MYbarmK" +
           "5xwcVm4lW22yTNvxt2XbvL5x9XQNNzvLPXKri4r8HPfpdz77nMJ+prR/WGua" +
           "gqP74f3RSXlC6OlbH1iZ/JJmVwD5yjv/5eHhG4y3voyy7mNnhDzL8neY579G" +
           "v1b+yD507rgccsP10Wmia6eLIJdCNU5Cd3iqFPLIsXkezKzxCFC1dGie0s1L" +
           "qze1+17uaFv3OlPH2986Ru5gR1a9L7NqWpFzYzY9OcksllOnL1EFfFvWhMA8" +
           "cqiKsXrE7N6TzA6tv3Pi6Kcdq0+V22LogZvfBRxNVny5dwvAcR664TpzewUn" +
           "f/65yxcffG7013kZ/fia7I4edFFLbPtk/erE8wU/VDUzX5A7ttUsP/95dww9" +
           "+tLCxdA50OaavGtL874YevjWNCCWj59PUv16DF05SxVD5/Pfk+M+FEOXduOA" +
           "3bYPJ4d8BMgEhmSPH/VvUgLbFgBXeydC8RB6cuPe89OMe0xysj6fhW9+EX0U" +
           "asn2Kvq6/IXnOv23vVj9zPZ+QLbFzSbjcrEH3b69qjgO1yduye2I14XWUz++" +
           "64t3vOYIV+7aCrwLohOyPXbzYjzp+HFePt/84YO///rfeu7beUXufwHfTGNg" +
           "ISAAAA==");
    }
    public BatikDomExtension() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UaobTXG9DwadmBgU3O+JLjbv/xsmpHop7RoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
