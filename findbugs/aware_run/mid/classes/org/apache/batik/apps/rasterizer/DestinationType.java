package org.apache.batik.apps.rasterizer;
public final class DestinationType {
    public static final java.lang.String PNG_STR = "image/png";
    public static final java.lang.String JPEG_STR = "image/jpeg";
    public static final java.lang.String TIFF_STR = "image/tiff";
    public static final java.lang.String PDF_STR = "application/pdf";
    public static final int PNG_CODE = 0;
    public static final int JPEG_CODE = 1;
    public static final int TIFF_CODE = 2;
    public static final int PDF_CODE = 3;
    public static final java.lang.String PNG_EXTENSION = ".png";
    public static final java.lang.String JPEG_EXTENSION = ".jpg";
    public static final java.lang.String TIFF_EXTENSION = ".tif";
    public static final java.lang.String PDF_EXTENSION = ".pdf";
    public static final org.apache.batik.apps.rasterizer.DestinationType PNG =
      new org.apache.batik.apps.rasterizer.DestinationType(
      PNG_STR,
      PNG_CODE,
      PNG_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType JPEG =
      new org.apache.batik.apps.rasterizer.DestinationType(
      JPEG_STR,
      JPEG_CODE,
      JPEG_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType TIFF =
      new org.apache.batik.apps.rasterizer.DestinationType(
      TIFF_STR,
      TIFF_CODE,
      TIFF_EXTENSION);
    public static final org.apache.batik.apps.rasterizer.DestinationType PDF =
      new org.apache.batik.apps.rasterizer.DestinationType(
      PDF_STR,
      PDF_CODE,
      PDF_EXTENSION);
    private java.lang.String type;
    private int code;
    private java.lang.String extension;
    private DestinationType(java.lang.String type, int code, java.lang.String extension) {
        super(
          );
        this.
          type =
          type;
        this.
          code =
          code;
        this.
          extension =
          extension;
    }
    public java.lang.String getExtension() { return extension; }
    public java.lang.String toString() { return type; }
    public int toInt() { return code; }
    protected org.apache.batik.transcoder.Transcoder getTranscoder() {
        switch (code) {
            case PNG_CODE:
                return (org.apache.batik.transcoder.image.PNGTranscoder)
                         panda.runtime.PANDA_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.PNGTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.PandaMode.
                                                       DYNAMIC_MODE });
            case JPEG_CODE:
                return (org.apache.batik.transcoder.image.JPEGTranscoder)
                         panda.runtime.PANDA_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.JPEGTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.PandaMode.
                                                       DYNAMIC_MODE });
            case TIFF_CODE:
                return (org.apache.batik.transcoder.image.TIFFTranscoder)
                         panda.runtime.PANDA_Runtime.
                         putObj(
                           new org.apache.batik.transcoder.image.TIFFTranscoder(
                             ),
                           new java.lang.Integer[] { org.apache.batik.apps.rasterizer.PandaMode.
                                                       DYNAMIC_MODE });
            case PDF_CODE:
                try {
                    java.lang.Class pdfClass =
                      java.lang.Class.
                      forName(
                        "org.apache.fop.svg.PDFTranscoder");
                    return (org.apache.batik.transcoder.Transcoder)
                             pdfClass.
                             newInstance(
                               );
                }
                catch (java.lang.Exception e) {
                    return null;
                }
            default:
                return null;
        }
    }
    public org.apache.batik.apps.rasterizer.DestinationType[] getValues() {
        return new org.apache.batik.apps.rasterizer.DestinationType[] { PNG,
        JPEG,
        TIFF,
        PDF };
    }
    public java.lang.Object readResolve() {
        switch (code) {
            case PNG_CODE:
                return PNG;
            case JPEG_CODE:
                return JPEG;
            case TIFF_CODE:
                return TIFF;
            case PDF_CODE:
                return PDF;
            default:
                throw new java.lang.Error(
                  "unknown code:" +
                  code);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVaCZAU1Rl+M3uy7LIHshAuYXch7gIzILeLUdxDBveq3ZWY" +
       "xTj09rzZbejpbrrfwIAhCKkIZRLLUjAm0U0qwWgsFHNYiaY0JCZRC4+CGOMR" +
       "70rUICmpimKCifn/1z3TPT3TjTumKlvVvT3vvf/4/ve//3/X4VOkxNBJgyYo" +
       "MSHEdmjUCPXhd5+gGzTWJguGMQilUfGG12/ZfeYPE/YESekQmTQqGN2iYNBO" +
       "icoxY4jMkhSDCYpIjR5KY0jRp1OD6tsEJqnKEJkiGZGEJkuixLrVGMUGGwS9" +
       "i9QKjOnScJLRiMWAkfO7uDZhrk14rbtBaxepFFVth00wPYugzVGHbRO2PIOR" +
       "mq7NwjYhnGSSHO6SDNaa0skCTZV3jMgqC9EUC22Wl1uGWN+1PMcMDfdXf3D2" +
       "ptEabobJgqKojEM0+qmhyttorItU26UdMk0YW8mXSVEXmehozEhTV1poGISG" +
       "QWgar90KtK+iSjLRpnI4LM2pVBNRIUbmZjPRBF1IWGz6uM7AoZxZ2DkxoJ2T" +
       "QZvubhfEgwvCB755Tc1Pikj1EKmWlAFURwQlGAgZAoPSxDDVjbWxGI0NkVoF" +
       "OnyA6pIgSzut3q4zpBFFYElwgbRZsDCpUZ3LtG0FPQnY9KTIVD0DL86dyvpV" +
       "EpeFEcBab2M1EXZiOQCskEAxPS6A71kkxVskJcb9KJsig7HpCmgApGUJykbV" +
       "jKhiRYACUme6iCwoI+EBcD5lBJqWqOCCOvc1D6Zoa00QtwgjNMrINHe7PrMK" +
       "Wk3ghkASRqa4m3FO0EvTXb3k6J9TPWtuvFZZpwRJAHSOUVFG/ScC0WwXUT+N" +
       "U53CODAJK1u6bhXqH94fJAQaT3E1Ntv8/EunL104++jjZpsZedr0Dm+mIouK" +
       "h4YnHZ/Z1ry6CNUo11RDws7PQs5HWZ9V05rSINLUZzhiZShdebT/91+47h56" +
       "MkgqIqRUVOVkAvyoVlQTmiRT/XKqUF1gNBYhE6gSa+P1EVIG312SQs3S3njc" +
       "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" +
       "1rT0jYUV3PIQFtH99vFQ+F/CqAlq7CsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7C8zr5nmezjn28Tm+HduJHc+NHV+OvdhsfooiRVGwnYSk" +
       "bpRIkRIpUWK3OBRFSqQokuJd7LwmAbpkK5ClnZOlQGt0QLq1hZtkw4oWGNp5" +
       "GHpDswLtgl06rGmLAcuWBUgwrB2Wbd1H6r+f/z/2fxJgP8BPH7/r877f+z3f" +
       "S/4v3/p26e7AL0Gea28Xthvu6Wm4Z9nVvXDr6cFel60Kqh/oc9pWg0ACZa9p" +
       "z371xp9/73PLhy6Xriql96iO44ZqaLpOMNQD1471OVu6cVTatPV1EJYeYi01" +
       "VuEoNG2YNYPwZbZ037GuYekmewABBhBgAAEuIMDkUSvQ6QHdidZ03kN1wmBT" +
       "+pulS2zpqqfl8MLSMycH8VRfXe8PIxQSgBGu5fdjIFTROfVLTx/KvpP5FoE/" +
       "D8Fv/P2PPfRPrpRuKKUbpiPmcDQAIgSTKKX71/p6pvsBOZ/rc6X0sKPrc1H3" +
       "TdU2swK3UnokMBeOGka+fqikvDDydL+Y80hz92u5bH6kha5/KJ5h6vb84O5u" +
       "w1YXQNbHjmTdSdjKy4GA95oAmG+omn7Q5a6V6czD0gdO9ziU8WYPNABd71nr" +
       "4dI9nOouRwUFpUd2a2erzgIWQ990FqDp3W4EZglLT5w7aK5rT9VW6kJ/LSw9" +
       "frqdsKsCra4Xisi7hKVHTzcrRgKr9MSpVTq2Pt/uv/LZH3U6zuUC81zX7Bz/" +
       "NdDpqVOdhrqh+7qj6buO97/EfkF97Nc/c7lUAo0fPdV41+ZX/8Z3P/rDT739" +
       "O7s2P3RGG35m6Vr4mval2YN/8H76xfqVHMY1zw3MfPFPSF6Yv7Bf83LqgZ33" +
       "2OGIeeXeQeXbw9+afuKX9G9dLt3LlK5qrh2tgR09rLlrz7R1v607uq+G+pwp" +
       "XdedOV3UM6V7QJ41HX1XyhtGoIdM6S67KLrqFvdARQYYIlfRPSBvOoZ7kPfU" +
       "cFnkU69UKj0ArtIj4Hq2tPsrfsPSBl66ax1WNdUxHRcWfDeXP19QZ67CoR6A" +
       "/BzUei48A/a/+hCyV4MDN/KBQcKuv4BVYBVLfVcJbrwA9tUAGJOZ6T7cAP1N" +
       "p9g3uXL3ctPz/n9MmuaaeCi5dAks0vtPU4QNdlfHtee6/5r2RkQ1v/vl137v" +
       "8uGW2ddhWCqDmfd2M+8VM+/lM+8dzbx3aubSpUvFhO/NEewsAqznCjAD4Mz7" +
       "XxT/evfjn3n2CjBFL7kLLEbeFD6fuukjLmEKxtSAQZfe/mLyyfGPlS+XLp/k" +
       "4Bw1KLo37y7kzHnIkDdP772zxr3x6W/++Ve+8Lp7tAtPkPo+OdzaM9/cz57W" +
       "r+9q+hzQ5dHwLz2t/sprv/76zculuwBjAJYMVWDVgICeOj3HiU3+8gFh5rLc" +
       "DQQ2XH+t2nnVAcvdGy59NzkqKRb+wSL/MNDx/bnV/xC4PrK/DYrfvPY9Xp6+" +
       "d2co+aKdkqIg5FdF72f/3e//F7RQ9wF33zh2Gop6+PIxvsgHu1Eww8NHNiD5" +
       "ug7a/ccvCn/v89/+9I8UBgBaPHfWhDfzlAY8AZYQqPnHf2fz77/xx1/6+uUj" +
       "owlL93i+GQP6SA+lzCtK991GSjDdC0eAAOHYYP/lZnNz5KzduWmY6szWczP9" +
       "3zeeR37lv332oZ0h2KDkwI5++J0HOCr/K1TpE7/3sb94qhjmkpYfeEdKO2q2" +
       "Y9H3HI1M+r66zXGkn/zDJ3/6t9WfBXwMODAA262gtSuFEq4Ukj8KHJOiZ362" +
       "7e3ONjDai7fxhnxzDdYp3j9B4Ncf+cbqZ775y7vT4fRxc6qx/pk3/s5f7n32" +
       "jcvHzuTnbjkWj/fZncuFgT2wW6q/BH+XwPV/8ytforxgx8uP0PuHw9OHp4Pn" +
       "pUCcZ24Hq5ii9Z+/8vo/+4XXP70T45GTR1ITeFy//G/+z9f2vvgnv3sGx10B" +
       "7kZ+Uy5gwgXMl4p0L8dVaLtU1L2aJx8IjvPJSf0ec/Ve0z739e88MP7Ob3y3" +
       "mPKkr3h8+3Cqt1PQg3nydC7v+06TZ0cNlqAd9nb/rz1kv/09MKICRtTA0RDw" +
       "PuDw9MRm22999z1/9C/+5WMf/4Mrpcut0r22q85basFbpeuAMPRgCeg/9T7y" +
       "0d12Sa6B5KFC1NItwu+22ePF3WO3t69W7uodsd7j/4u3Z5/6s/95ixIKsj7D" +
       "5E71V+C3fuYJ+sPfKvofsWbe+6n01nMNuMVHfSu/tP4fl5+9+puXS/copYe0" +
       "fZ97rNpRzkUK8DODA0cc+OUn6k/6jDsH6eXDU+H9p23+2LSn+frI1kA+b53n" +
       "7z1F0Y/nWsbB9dw+eT13mqIvAdK7bq6Bvwl7ziIv6xW9nynSm3nyV3e8EIKn" +
       "iWhmm4BwrgaFox8CROCItotJcUCeQr/9migNC6PfcX+efjhP2N1Sk+eaResk" +
       "6Bq4bu6DvnkW6Ht3oC1PL1CPz0GdZ4U8GeTJ8ADqta7QPBerfAdYn9/H+vxt" +
       "sIamYeSFH7sgVolptc7D+toFsb4Crhf2sb5wFtYbwBEDi1xsJtibF4CNiwG+" +
       "R2ici3dxQbwvgeuD+3g/eCveQ2+gOKcY8Hy30P1H/uznvvQXn/w0cTk/3+6O" +
       "830HtvSx86wf5c+lf+utzz953xt/8hOFA3AwtHPBtclNnuYbzfy+ekpW9w5k" +
       "fXFf1hfPkDXP5EAv5Zn0YkCvFwZ/HtLtHSB9aR/pS7dBejnPfOKCSAtzPw/p" +
       "J+8AKbSPFLoN0gLNZy66+I3zgf7tOyCRD+0D/dBZG/OuvX2C/tzFUD6Qm2hz" +
       "IjX7IsP3z9qTP3kHUPf2oe6dDdXyCqhfvBjUBwsjvS3Wn74DrPA+VvhsrICW" +
       "89ufuyDWwkxvi/Uf3AHW8j7W8jkmsCPkX7ioCTTeAeovXhBq3gzdh1q5BWqp" +
       "yHz1YiCvADstUJ2C9o8vCI0GV3UfGnYOtF+9GLS7crs8C9uv3QG22j42/Bxs" +
       "v3FBbLkdnoXtn9/Bktb3sRHnYPvNiy5p40xov/XuoRUvGXJ8L+9De/kcaF87" +
       "G1pxVn7wUFkHjvJp+/9Xd4DolX1Er5yD6F+/K0SaOy8QnT4/vn5BRE+C69V9" +
       "RK+eg+iP3g2i6+DRS3eC/TcupxX1H94RVjFMQVd3V/Zqe8UAf3oxu3mfZWs3" +
       "Dx7ax7qfg7lp2bWzAOHvGhDwFR888gFZ11m8/BP/6XNf+7vPfQM4it0DRzFv" +
       "vQE6Eb7QfOij+c03L4b9iRy7WLxfZdUg5IoXOPo8h18MUTkGmgDrb7u7U/2O" +
       "RAofKXewgCEP/rixSivkCBnaEIdG2xrLdIIlGU0n2rK2YDKG1dnRPG1Qsb5B" +
       "FXmaSla57mfKTLe8me8bCUMu6d6KUYYsO7LIdXlU3iTyImh1+lNTnZa7tDKk" +
       "MYhu89ywVvZHDA2WaN2jTcOBkQyVBAmVLCla9+x4HEtoHBswBsc6DKPwBBvz" +
       "q7RPdRfbqcuJneZ8bY1oYbKcV6FFO5Pk7iJqcwPTHhntNlKBFUOfCk142hT1" +
       "1WAtDTbtfsWc9ine1Nx0ilncaik26KnHWMNqb1q2hh7CN/AwaHY3Tq/ZXZlt" +
       "pQ1+IjNl/XGbG7XbiVg364OexTui1mWHJieTK4OvRQ1l6a8QzJ+FlJrqXqs1" +
       "DpflciJMo0U2bndmQ74iMPxwvan1E2u6dNqi2OFxsdFX1XKwoiVljFrcYkPX" +
       "myO6UpFtJGrLfQgROI1rGPOJgTYqXthUZ+6su9j0XKvJlaHNerkN81cm4aiC" +
       "j+bcqjyVifVEHDcna33pZs2lNEY8t82I7YG8UP16uRf2IFO02KHnMBjLVbwx" +
       "1R8yo9lasYQh1UIYuZ3hEVcjXSVVKo1V6nYr0kCJo9nSaC6SmKZq1aqkIYK5" +
       "spBmby3bZGs0TAZ2m1wopCuIaaMxtmZy2mbK/dXYbfHOlsQ9ZiFmUYhusMyj" +
       "Wq1p004Ws6ESNGhvpKBs2C63hIEzrfckZtwoN1gCn29jb9z09FZTo9RZhUOa" +
       "E8XkB3SwapKpIOJkDVmt0nGw6mqzeq8bmItax6PXC9Jrj7rb1Wxs9ZbmcErS" +
       "o7WOm3TiMlCT0hpVm+pu5A1P03ysIQ1ccdVyeRAmC6vP+Uy/o9cEn+vJK3Sx" +
       "XJHicKNia7TFl5uxNJmhK7xblwQ5jOKWonjJsEt2RH40brVhUaPLcjIZSVB/" +
       "VEWBK092e0iEz5aTTaeOGV1yoEpoE+mHMQE3I4dFyhgEWZbiBYo+98uNNbRm" +
       "3Ki3xKZOR4EVxN/idH/kIsiwkQQ1YRBUO7JSH5ervsj02ZGSLU1FXM71mQTX" +
       "EQirLas4t1psmM1wNObHKzLeumN7IK3NoQRPeptRC1n0qemyiS9EFRKQ5php" +
       "o0hFHASoiDqW5tIpba7H+rjnb9EKbfIsRTaRCRniUhMxRLTrU0PYQ0Wabo2J" +
       "Lonr1IaBNAPmagwi9Ny12loMqNFYRDq04ZtdqNYidQ1fUGjWdpG5lHCCBdur" +
       "MTsw48bS80eJ2GlsLExsBaQ/3NgKLRFlBk9YyjKlsCtssIm6sNMBNAtpjJkM" +
       "6jWDWPYZWV6zSb3JUPw6WvFNqcf5jrzp9Pr4uLEdxL3MqnfQ4RSf1TCFTmec" +
       "xUw9UuNMuRPxg4G4qCmrFRdtxcEAI1lhkCCchTUglOwNyVE3UwyBbNXncSWs" +
       "D6ge7s5EqJ0F9JpA++JYCeaDsJsKW1cXwipc9dZOL8IAO1DNtdxixhMVUjm/" +
       "16qoeBmRh6lJLXRZ5ufCgNMhvRd3NgO3Ng/RWn9Zr/SiZca1GI4TzVaVQV2d" +
       "4re8uZXQMgG3QzQ2KlR5HqHqRB2IpO/hQ2k6wOzUm7bnsI4nI6NlWw5N1tud" +
       "eTZqiVKzyZKWKDEURRmtOLTD9thNPUmb+2mL4Rc8v3GW1Mpvup3KwK1sNvGs" +
       "NmSjeW1CQFnmYitXmzeERaQN1KWRwEio+FC3uoFMB7fIoJUl2qRRWaKCAJf5" +
       "clSN5rzn1jdDItFcFZWbvcpQTpO+5OsVepFt7DJfsyuwF/GT5QYtzyKjTpuc" +
       "ApNdZ4sOFJNmF4PMgCepL0IEFGyWCsZXsqwretEKyDB0e4DVe8Sy2alKLs4q" +
       "dJOvr9pCze2vkEkvouWRnYjLtdxzIdHCHZvtOBaaLn2pKQ9c0YiHicNlARfA" +
       "Wrqu1sIFolSUrL9oDgkcCftspLS1gVOpZhPc3yQkPGZq0irFkUigJ3OSd8nB" +
       "jKPcKtJGTCpamjRvUCEXS8CF6MvierwQ6qjUNrXJFFtRSUXuElFXpdnQXlfx" +
       "slVfqxWYnceKE1RZaGRxtq1NUY0gQh4Pex2d0pZZVWZq202aWvqmDGExDbf9" +
       "viO4Kkw2MjgZzGsUGXNsqzFRNrLJK7bmtVdema0pCtybNsQ2sYFqY3amw4ZK" +
       "dBOl4k+mqAcvONSgtjgxbSi+rjY9q+VIUXvFiRrSXabEZCqpmSFLibnC0Wyz" +
       "xatztFb3HNWWJ46C1aaCUq2hAmxY3XKlEgpVxkGHCoP0xpWe5WHdsjGJUKu5" +
       "tEW8ilWhmo9CUKvS7S27A6cl2/5qpZiShyVMxosJVouCzbwXc2S34QMQI5Kt" +
       "k4zM8kasjLczrTl1EmdkxjRO+9tZoz2GMp1IUgLDe/0MrU1CuV1PsWo2BjLU" +
       "K3NMHc7Kza2EQF2/43nExoom/pDnRrKJ1tqWgEiTbXkmkNpggZke7VljbD5a" +
       "u5sevJz6o7g3iTPEheWZtdSHU1r3Vq3REjGdhG9i6wFJ26m5XGHVYWWrjtdQ" +
       "f6k3NoTa8CarBacNdbQGyX16WKYWRiyFMGeMHRXCVB2bdFipz2d6Y9VuO061" +
       "N9TiaJsFhFxjUdTJxtAcGrUVfMRBDNFtgWPciA02QS0NyhpAGKxapdw1a5hL" +
       "AhJm3kwhalvdCVlmMrJUR1MH2UpT4kriBGIt0WaiQ0y67XHDa6pl217MqMa6" +
       "G0wIxl6O23pYbm1rdABFib2wVsYsQFaY4kQj3R3gBC5IoRYrth3NNkZTnZts" +
       "D6K8sNttuVlgU2ajK3VJMWATRiVcxl4gKR47BDrdxkt5qik+hUlkrcEvE6jB" +
       "4tEUJ4cZt1yN0Z6Km5zA2Z6RQZPhQmtBQsxySyaL64alqh12U4+lfiKnqx7U" +
       "8gJzgFRHfXkqsjO/1eRZHaMaEmRB/U2T3TaFjkl4VleMa1CcUI2hSPaoqr1Z" +
       "VgWXnraYuuWO3YShCY9sL5Jy6HjUaDHr4iRCcFt0yKEChS9UL3YWIzQLlv5o" +
       "OqyONu2uPOl1xNp8VR/wxLS7Wcg6vU27LUikt0HCQOPEdi0SH8Qy3q9VUZzb" +
       "6oYa0TyneZWpmpJcj5uWATsQYrjSA6FTTRBCo/wJJFB9DsElolMh+oyoL9ed" +
       "6TiM9cSAJlF5u+1jdKMPHBLZ56dpg4BId0TBDQtPZIsYMlRzmggDk8DQ7YKU" +
       "3MDeEKOOtCThxnLKpeWgmfCtRpmMeX8wIWW50ZUjsrHEA2JskRqbdlwVQnWV" +
       "rc4GzFJTGFu1GbDH9N7A1izgQJi9Flpvb5zGdN5KkEq/mTV5J9wO51zNxEiJ" +
       "MMUWsRGUmtAm5qnBUVgMuymHLYROq04LdEKOwgUgmYSn68wI7myT6YqawyRw" +
       "tC0TWiwTlwz7CzHqWw2MyJp1JaLJiZMOsbovJLo+JPQuVQ3CUB/O1wzfIcDa" +
       "USJfLTNcxgr2otYbgENH0GtOf2k4PW3djxeyXPXCIGkQKcGmfsYtMh6jXICr" +
       "UYvImNLIAQUO/q6skxQWySTZyxKMTEhNgoGb0+qRCF6ppL1sSwIGXyzaARHR" +
       "3CTU9TEMwYbD1iFtai7WJuKxQxzvwD2EqhvsfIVLsbhU4hmeSZUyjODkah0E" +
       "nBwQtrDt+NWujvTo1YZTsVWEcXCMYbaStDICQGGCut3I/A0+mPS1raYy3jCd" +
       "0RWljq5hbtkZYfXWMGtYeoKjGAoxXT0iUrzJzDKnUVmJVF0jA3/LVWO3XlF5" +
       "iArGVuyMIhpxZpIcNKhxuzKU2PmworU3Ng/3Imk+imKb8thyLTDY5lrtTWZe" +
       "VV5PQmKhpGs9TfmwY8Uxu2gJ7Ayd1bmOkOm4OsycZqTXCDZU4I1VIyh+kqXz" +
       "uAEcpXGHy7q8xvW9yO1PAtZr9hy2t/IrRlhvKCs9Ibgqt4wAF8YdPtzySi3s" +
       "WQs4UUbxqDUZbYyuldrOGm0uBAeaS2OsEohMdWTZnfEKmnTay4EwrqZeIAOX" +
       "B/CnkE7bvVmrzy23c1Mdwik3kEUkmtL1LYuQktHxcIyagFPa1aiRVokNauKv" +
       "vUSZW+MJVpYRD7UQqNzCV0JAylAITFgYK8PVZtq2O9hWCzdtuNlyUj+d9DKa" +
       "Noi2CJX7GNzCzCat+haz4ZZexk+Am1gmjIgyqkgPpRCkN8Ux1mpAG3q6pjfl" +
       "eT9LjVVVK8uyOuxv+7rRlmHVs6YaeDYlAG5lkA0m5WbNZFv4WujMZ1Wk01rN" +
       "5mQ8pXnIlrdYWNeyJeIQU65M8B07IawANuSuVBnE67rjQ1jGTsZTAvUttGIY" +
       "E6GLCd6MHWzIBJFYjNAce0rZulLtpr3OZM3Bs06K1xHLwuG06SLJlqHkEBkZ" +
       "20mrmpbZFIX6stTFvTWqaYLtBmlgtJhaDTwZoZHXhaKoEcxHljYL+lI4LGfS" +
       "rJd0Kwlf5yrD2hgGXl4ULeWMZebtWr2jKx1c59Cx4EwmGB9nVjMbbYZ0VrNl" +
       "O62m1rTOEB5Lhdp8gs2Ulun1N4gT8JInr6oI4XA9pGEaMlj3sdDx461UmQue" +
       "Wt4A13hAON7QrhLtDlYLR+WKrWFrNegzdQoSWvqUEYe8PldnUm8qVIYQ0cXZ" +
       "NSHO2spatFNrncCWUJGmlOLw6NJo8HAWz1Tw1DwL5szGcJYzkg1MnOwaFtsP" +
       "ynVxoadVxd+w2+4wmystSw030/64VhU0qrxommo/aVuY107rEjpxbGCl6AoZ" +
       "eGLuMA235cFUjqahpaXNGY45YSbGZWfSV7bGXKi0dN7PRuuFP0MtuDG3O2Kj" +
       "0h8OEF2p+W5l2hjaswVEaG2rz5ThkM3KlCsPLHpgclIfn+qEKJc9JqHr6NTW" +
       "61hbZoS43hnIcWftrTXIaLQGdr1KpFWUqEyw0QiY3xCpbcxKrIZYfwW821HS" +
       "2upebFUncMB7CtSrwGJQhnxxKsmewrOjrjD0SVmroY2ePFCDrTcxkaXXbqOM" +
       "UEP5sN2a9XBH30yYieZ320rfUni1usmAdzCuBUPdzjqU2OLRDeJLZWs6GqMC" +
       "M2iFnXo9bg2gFkxvSHsDXA2SJF8tQk3+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+8VeaT1cvI47DIm9gxdx5/yz8vLhhMOjgKviL3+leSK68tjbzKLl4/sRJIFf" +
       "evK8ANgigudLn3rjzTn/88jl/Vibeli6Hrreh2w91u1jQ10FI710fvgJV8T/" +
       "HsWA/Pan/usT0oeXH79AsOAHTuE8PeQvcm/9bvsF7acul64cRoTcEpl8stPL" +
       "J+NA7vX1MPKLeMm8ZBcN8uShZvOQ1dJT4Grua7Z5+j3x0ZKe/ZJY2JlEUXdm" +
       "KNOle29Td3+e3B2W7l/oYfPES+ZDK7p09Z3efR4fNC+4dPmkfE+Ai9mXj/nB" +
       "y/fYbeoez5OHw9K10N1FzJ2S7ZHvQ7YbeeF7wcXty8b94GV79jZ1+WiXngxL" +
       "d4cuswtrqx4J9tT3IdgzeWFeP94XbHwRwcBm9nw31LVQn7+jfLcJwbuE5MmL" +
       "YekBYJuSrzpB/n+Z3YcGj4alF24JVw4P2+ydal5o5KXvQyP5f3KK2BxvXyPe" +
       "RTTy7pb61dvUfSRPCKBZoIoiaC0A1Pj8+dRYxJXuAjnf/IfP/f6PvfncnxaB" +
       "hNfMYKz6pL844yOFY32+89Y3vvWHDzz55SJ++a6ZGuy46/TXHbd+vHHim4xC" +
       "4vsPdXjfARXcXoee55WOFq3+/XJPvnLh/oThD37RuNvU8XnSCUv3+bo63/9q" +
       "5sB6j0U+7SIOj0RmLiJyGpZunArLz0OMH7/lM6Hdpy3al9+8ce19b47+7W5l" +
       "Dz4/uc6WrhmRbR+PXzyWv+r5umEWuri+i2b0CgEnYenpd/poIAQn4OFNsUDy" +
       "rvOPhKVHz+wclu7Kf463/RhQ2Om2gPeK3+PtVDDbUbuwdHWXOd5kHpaugCZ5" +
       "Vs+t4NIgvXTSezlYiNI7ng3HHJ7nTuzF4luuA5ci2n3N9Zr2lTe7/R/9Lv7z" +
       "u+h6zVazLB/lGtg2u0D/Q7fkmXNHOxjraufF7z341evPH7hQD+4AHxn0MWwf" +
       "ODuSvbn2wiL2PPu19/3TV/7Rm39cBN39P/PS6L5kNwAA");
}
