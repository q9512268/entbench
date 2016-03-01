package edu.umd.cs.findbugs.classfile;
public abstract class FieldOrMethodDescriptor implements edu.umd.cs.findbugs.classfile.FieldOrMethodName {
    @edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
    private final java.lang.String slashedClassName;
    private final java.lang.String name;
    private final java.lang.String signature;
    private final boolean isStatic;
    private int cachedHashCode;
    private final int nameSigHashCode;
    public FieldOrMethodDescriptor(@edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                                   java.lang.String slashedClassName, java.lang.String name,
                                   java.lang.String signature,
                                   boolean isStatic) { super();
                                                       assert slashedClassName.
                                                         indexOf(
                                                           '.') ==
                                                         -1: "class name not in VM format: " +
                                                       slashedClassName;
                                                       this.
                                                         slashedClassName =
                                                         edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                           canonicalizeString(
                                                             slashedClassName);
                                                       this.
                                                         name =
                                                         edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                           canonicalizeString(
                                                             name);
                                                       this.
                                                         signature =
                                                         edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                           canonicalizeString(
                                                             signature);
                                                       this.
                                                         isStatic =
                                                         isStatic;
                                                       this.
                                                         nameSigHashCode =
                                                         getNameSigHashCode(
                                                           this.
                                                             name,
                                                           this.
                                                             signature);
    }
    public static int getNameSigHashCode(java.lang.String name,
                                         java.lang.String signature) {
        return name.
          hashCode(
            ) *
          3119 +
          signature.
          hashCode(
            ) *
          131;
    }
    public int getNameSigHashCode() { return nameSigHashCode;
    }
    @edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
    public java.lang.String getSlashedClassName() {
        return slashedClassName;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ClassDescriptor getClassDescriptor() {
        return edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptor(
            slashedClassName);
    }
    @java.lang.Override
    public java.lang.String getName() { return name;
    }
    @java.lang.Override
    public java.lang.String getSignature() {
        return signature;
    }
    @java.lang.Override
    public boolean isStatic() { return isStatic;
    }
    protected int compareTo(edu.umd.cs.findbugs.classfile.FieldOrMethodName o) {
        int cmp;
        cmp =
          this.
            getClassDescriptor(
              ).
            compareTo(
              o.
                getClassDescriptor(
                  ));
        if (cmp !=
              0) {
            return cmp;
        }
        cmp =
          this.
            name.
            compareTo(
              o.
                getName(
                  ));
        if (cmp !=
              0) {
            return cmp;
        }
        cmp =
          this.
            signature.
            compareTo(
              o.
                getSignature(
                  ));
        if (cmp !=
              0) {
            return cmp;
        }
        return (this.
                  isStatic
                  ? 1
                  : 0) -
          (o.
             isStatic(
               )
             ? 1
             : 0);
    }
    protected boolean haveEqualFields(edu.umd.cs.findbugs.classfile.FieldOrMethodDescriptor other) {
        return this.
                 isStatic ==
          other.
            isStatic &&
          this.
            slashedClassName.
          equals(
            other.
              slashedClassName) &&
          this.
            name.
          equals(
            other.
              name) &&
          this.
            signature.
          equals(
            other.
              signature);
    }
    @java.lang.Override
    public final int hashCode() { if (cachedHashCode ==
                                        0) {
                                      cachedHashCode =
                                        slashedClassName.
                                          hashCode(
                                            ) *
                                          7919 +
                                          nameSigHashCode +
                                          (isStatic
                                             ? 1
                                             : 0);
                                  }
                                  return cachedHashCode;
    }
    @java.lang.Override
    public java.lang.String toString() { return (isStatic
                                                   ? "static "
                                                   : "") +
                                         getClassDescriptor(
                                           ).
                                           getDottedClassName(
                                             ) +
                                         "." +
                                         name +
                                         signature;
    }
    public static int compareTo(edu.umd.cs.findbugs.classfile.FieldOrMethodDescriptor thas,
                                edu.umd.cs.findbugs.classfile.FieldOrMethodDescriptor that) {
        int result =
          thas.
            slashedClassName.
          compareTo(
            that.
              slashedClassName);
        if (result !=
              0) {
            return result;
        }
        result =
          thas.
            name.
            compareTo(
              that.
                name);
        if (result !=
              0) {
            return result;
        }
        result =
          thas.
            signature.
            compareTo(
              that.
                signature);
        if (result !=
              0) {
            return result;
        }
        result =
          (thas.
             isStatic
             ? 1
             : 0) -
            (that.
               isStatic
               ? 1
               : 0);
        return result;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17eazr2Hmf7pv1jcfz3sxklkw8+7M7M7IvqV3MxK4pbloo" +
       "khIpUWJdj7mTEjeRFEUxnSY24NpoANdxxq4LxPNPnaZN7ThIG6RFkXSKIE0C" +
       "G0UTBG1aNHG6AM1SFzaKOkXdND2k7r269859982zxxXAI+qs3+87v/N9H3mO" +
       "vvSN0l1RWCoHvrM1HT8+1NP4cOE0DuNtoEeHfbrByWGka5gjR5EA8l5Rn/uF" +
       "a9/+zqet61dKd0ulh2XP82M5tn0vGuuR7yS6Rpeu7XMJR3ejuHSdXsiJDK1j" +
       "24FoO4pfpkvvONU0Lt2gj0WAgAgQEAEqRIDQfS3Q6J26t3axvIXsxdGq9NdL" +
       "B3Tp7kDNxYtLz57tJJBD2T3qhisQgB7uzX9PAaiicRqWnjnBvsP8JsCfLUOv" +
       "/e0PX//FO0rXpNI12+NzcVQgRAwGkUr3u7qr6GGEapquSaUHPV3XeD20ZcfO" +
       "Crml0kORbXpyvA71EyXlmetAD4sx95q7X82xhWs19sMTeIatO9rxr7sMRzYB" +
       "1kf3WHcIyTwfALzPBoKFhqzqx03uXNqeFpeePt/iBOONAagAmt7j6rHlnwx1" +
       "pyeDjNJDu7lzZM+E+Di0PRNUvctfg1Hi0hM37TTXdSCrS9nUX4lLj5+vx+2K" +
       "QK2rhSLyJnHpkfPVip7ALD1xbpZOzc83mB/51I96Xe9KIbOmq04u/72g0VPn" +
       "Go11Qw91T9V3De9/if6c/OivfPJKqQQqP3Ku8q7OL/+1b33wvU+98Zu7Oj90" +
       "QR1WWehq/Ir6ReWB334X9iJyRy7GvYEf2fnkn0Fe0J87Knk5DcDKe/Skx7zw" +
       "8LjwjfG/nP/4z+l/eqV0X690t+o7axfw6EHVdwPb0UNK9/RQjnWtV7qqexpW" +
       "lPdK94B72vb0XS5rGJEe90p3OkXW3X7xG6jIAF3kKroH3Nue4R/fB3JsFfdp" +
       "UCqVroOr1AfXk6Xdp/iOSw5k+a4Oyars2Z4PcaGf448g3YsVoFsLMgCZlLUZ" +
       "QVGoQgV1dG0NrV0NUqN9YbFkc0kgMqc3Gw4L7uF6pIZ2AOh/mDcN/j+Pl+b4" +
       "r28ODsDUvOu8YXDAmur6jqaHr6ivrTvEt37+la9eOVkoR5qLSw0w/CEY/lCN" +
       "Do+HPzwZ/vAmw5cODopRfyAXY0cGMJVLYBSAubz/Rf6v9j/yyefuACwMNneC" +
       "ecirQje32tjejPQKY6kCLpfe+Pzmo9Mfg6+Urpw1v7noIOu+vDmXG80T43jj" +
       "/LK7qN9rn/ijb3/lc6/6+wV4xp4f2YU3t8zX9XPnlRz6KtBfqO+7f+kZ+Zde" +
       "+ZVXb1wp3QmMBTCQsQwIDWzPU+fHOLO+Xz62lTmWuwBgww9d2cmLjg3cfbEV" +
       "+pt9TjH7DxT3DwIdvyMn/HPgeu/RCii+89KHgzz9gR1b8kk7h6Kwxe/ngy/8" +
       "3r/641qh7mOzfe2UI+T1+OVTpiLv7FphFB7cc0AIdR3U+/3Pcz/12W984q8U" +
       "BAA1nr9owBt5igETAaYQqPnjv7n6d1//gy/+7pU9aWLgK9eKY6vpCcg8v3Tf" +
       "JSDBaO/ZywNMjQOWX86aGxPP9TXbsGXF0XOW/p9r76780n/71PUdDxyQc0yj" +
       "9966g33+D3ZKP/7VD//ZU0U3B2ru6vY621fb2c+H9z2jYShvcznSj/7Ok3/n" +
       "N+QvAEsMrF9kZ3ph0O4sdHBngfwREJIULXOvdrjzank+XCSg3xcviYhC2wUT" +
       "lhx5EejVh76+/Ok/+vLOQ5x3Oecq65987W/+xeGnXrtyyi8//ybXeLrNzjcX" +
       "THvnbtL+AnwOwPV/8yufrDxjZ5sfwo4cxDMnHiIIUgDn2cvEKoYg/+tXXv1n" +
       "f//VT+xgPHTWLREg6vryv/nzrx1+/g9/6wKLd4/i+44ue4WUUCHlS0V6mItV" +
       "qL1UlL0/T56OTtuVs+o9Fe29on76d7/5zuk3f/VbxYhnw8XTy2goBzv9PJAn" +
       "z+RwHztvRLtyZIF69TeYD1133vgO6FECPaogRorYEBj09MyiO6p91z3//l/8" +
       "2qMf+e07SlfI0n2OL2ukXNiv0lVgOPTIAr4gDf7yB3frZnPvsdNMS28Cv1tv" +
       "jxe/rl5Or8I/7K3f4/+bdZSP/af/9SYlFEb7Asaday9BX/rpJ7AP/GnRfm89" +
       "89ZPpW92ciAy3ret/pz7P688d/evXyndI5Wuq0dh91R21rlNkkCoGR3H4iA0" +
       "P1N+NmzcxUgvn3iHd52n/Klhz9vtPdXAfV47v7/vnKkutPwucD1zZMWeOW+q" +
       "D0rFzaBo8myR3siTv1TMyRVA4iC0E7BiYjC87clOMUIT2IkIuG7r6ImAOZIF" +
       "3ln+PP1AntC7CUaPyHD/CRkOjs1N+6KooAjVwVinaH/InxvuTMdnWHbEM/JE" +
       "Cw/l+U8dOa1j53WRFsSbaCG/ZfOEO0Z/ov3ziGfpzQW7SKznwXXjSKwbNxHr" +
       "w29ZrKsnT1QXyfbKdyHbe45ke89NZNPfsmz32tHuETH/3TgnmvHWRbs/z30a" +
       "XC8cifbCTURzLhbtoBDtWKoHVFm1doYQ87UdmmpRtpOoHZfuAHQ8J657m5rM" +
       "tffSkbgv3UTc5C1r8lpOPt42j4XOs1fnJNzcUsIdyAMQ/NxVPWwdFmR59WIZ" +
       "7shvXwBRUnQygSfCPLZw1BvH/nUKHvjBar2xcFoXEbD5loUCvuCBfSBC++Dh" +
       "+if+y6e/9ree/zow2P3SXUluTIGdPhWtMOv8fcPf+NJnn3zHa3/4E0V0Byab" +
       "f1H5Hx/Me/34ZdDy5KNnYD2Rw+L9dajqtBzFwyIg07Uc2UUcudPxd5HSd4U2" +
       "fpDu1qMeevwZTmWsulHTsauzGWSzXaXNswOCYzNCnfbt5SLW+RHVHZdpwlY5" +
       "UnOZxWrS7EVIU2lXq9u4lUiewnFWOBphvBhX+jxFUCa95Fdk20HNFTqo2L0+" +
       "Npkte2W/g5lTCe1IojxyyP4K7ivVmIY8pIoYWhZTTtQXmTCtLbJy2UASKDaG" +
       "rd6S4/uutYTlVdQxFbhpjqtNe9NdEjWZ7mukuV3gZZ9KhXhg0VDCMZWKLvET" +
       "vIFJstqdD0yfaknAReIjaov1+0PJNm1G8P0F3+/VAlh2OsiYwviVuR2xEj12" +
       "NXLJS8J8upj2owkL+Rhw5Co2p82KQ+lVGMOx7QCl1BRfeu3ZrNwI58Rq3J8q" +
       "ahZwwIkmWm1qLuAsczZUryX2a+qgRwzbW35e9/o9ttKYjbemrAzmbXa7dXtw" +
       "Wh20GtpE7JARv9pEptxt1hsrhlOWtZlqWi42X9lDu6lHc6CARYotNw5fR8Zr" +
       "h/KoKrEuj5c+L/XkcLgdxtgs4VliI1uwE8tSRd904cpUGUhaINKbajpoSKse" +
       "jlPblIgJojay5o1uUBc2uDUK3K1a75otnm4jA3liyT2di8g2z9RagwyZjNyA" +
       "4tHKMh7Qrd4C7fSYfsfsjFzLtdchsXZloY9OB96GomsTB+YlylPFtdMcpYHY" +
       "6ctkQ9GsjbqKxt6kHNSH0xDjegFQdLAOGu1pX/Xl1JB4R6JQSaLSVBJGy1bU" +
       "qRNhn0eHAuyYTEMawWGNJ1b8klcgm94OaU3DOqnZpCeMJEYVbir7vQnRXQlj" +
       "cdwRJ/WauV4FmxSvZL0pSXY8qVs3J+pYJtojZLNAtXGvBiN6lLpNfKahdQJ3" +
       "yeUibCvBhg8ZplzjV61KWe6ELZlQnGFl4BA82tiOppI+hjpmukLQmjx2mElQ" +
       "RbuNCFtVovHY16m+WSExnxuqs6qeZXUk4bocs40kIWs4CGkJAZxVYbceRBN8" +
       "U2Y41rF0OKRtpMPYPlyROpu2UOXVbRJG0xA4i6Du9ubtsbgdVudVL17UsooU" +
       "6T6LdHlx4g3G2pSVog4n+0JlvnG3U8EA4FdYfeOybQde2YKizyLPHSkJNnEt" +
       "ya3UBu50VFk6A2namIYJbaAkMeCxDuEY6HrAe1MjVglnrSTsHB5NzIirjmiu" +
       "59LltlEebjkKdldkOhqPJvy0u+CU1aBtxWkbt3CTgpue2XeoyGepGomTZUbV" +
       "RHNLtRF36XXHamfV2PJgKen1ZA2J8YxTqxOCm/RHtQlXl/BYRRqJlQ24agQT" +
       "PuWIulXDcXpeoaSp4PSRCb7lZwqUZgSL0w1rYNUlu6caPTkwy52Y644xxhVS" +
       "iBbSNu32G0TPy8SqalOr0XbjdBN0MO/MQicc61BVnI10hYdROtZIXkSNqLre" +
       "9oV1lW20cA2SO/UobDSNoaOQGaz15Ul/Ypd7NJb0KCoTmypnptEIcVbTGT7p" +
       "qmpEd+eOUd+Ah5zVlu4FDGsOqf54Ne10V71WZTFMqxMFw6lGkHK4DZOsaHh0" +
       "kCGsUg4r7Xl/SibpEA22bVyqG6iOcEzDQFo2kgpkk5mrLFcbb2WuNR1qnk4M" +
       "Rl1hSY9XvWE2ayLt4TAb0PM1adU1g+obWF1D2MSC+z7KmGEcIUPIUidOHHtx" +
       "V+QDtN7nV9JmJLnV7XBQceQprGvUqrnRjBRhVgsSp4Wx5FmiuFRoqMqEZl1x" +
       "ZiTXmahIe5LgG1UUEy0xwgTKsv44XbMIPVmTA2IWhfKMqTO2Ns24iuKtqKoh" +
       "2B6sQxzrxfEaKuOotmpmMMUE0chRImrTDTcSjeG40Y4znUEa5SZkhpOJwVFz" +
       "odbqdMAyd9tL0uIGS5awGFdkoS2qNYTOvImLMbn1zG5jMJgs50t7KVc8ZOU4" +
       "NbhJttmKFDR7BMuEk3nY3ypmpV+ueXEGb6ImR2UuIM1iXFW7w6YoNyFyyTZm" +
       "YpP2N1a35SqzSguuiTq53pJ1czisBt3uwJihQdrEJnxW55aLSZkwmTRDM0Kk" +
       "yxRZadRMTJm5KbzddHkHH2QTuzNL6XVL6o8bUdNwF5RaYwcZjbZww0sSu1Z2" +
       "IAXi6Zm5CWDcsTmiIraETlm1iagvt2uV8lgo9xK8jaeISjY3mx6sIetULJNr" +
       "Y+E0FcfkhtPeyPWmdbyeJKsagqSV8pIU0C7SRmqi26kj7TbCzX2eA2Ym6MPM" +
       "AOOGIyRdbgmhS21kgls7vsBslhoMsd4yiYykWjPQxiDUKaRXG0VKs05BULlK" +
       "R9mi3Z5tx7LQifmptBwES71F4pNyC0E8HTG6JBXiTDUo626M8CO97iwb/HIq" +
       "LpMpCBpnY8ESMnaLNhtklPajrk2KWap2ibkdKiibdP2KVOYwDmeJIczUq+k8" +
       "cixnjZdjjXb0FWcv9HK06lYM2OA8l7LLGYNoMCvJa9OdLWZzhVDbUitc1DGl" +
       "ww8ZCHjFiiIupotWBZuiKtrz7T5tUfGmNWZZLQW8TCLXhfRyGFgOnDhSx+80" +
       "3cmU70q9WYcTVjKONacUZfYbQpg0qZjFF6QypyZllkQtY9IjxRopqFw1G8q9" +
       "VEE4i2ssmlskbiyUGjkLgiVMJnjakCxFJ3o1YeOqTa6LKq1WuxnWDFYIViuH" +
       "BSZrQWVGXIuzLQw1KoCCOGtWJ8AuUUy3bhtrKi6XK7OkDZFsZUiPacXDDNS0" +
       "k4yr1k11C9XNqgO12/xqzizJcFwFKsJqPXHeJtAW4Q91JKLWmcWta3p3LiuC" +
       "Yrh+wnSSaNAIIKPLKyPWAVY20bSWH40xPZ0qsMhuuOW4i81qyqY3hWyJj8QV" +
       "tNiOVdJlplVsJqSbmTnvezbeGjlDjSNgsc3PDXWG250Vj8niulsVJ2kynA+3" +
       "FUu327NKP1qu+awcthNfikSuI6niVqBbFbQuqY61CJFJzevp6dggkkoZ4vgK" +
       "xSB+Yzqu9h1yKNtLdLDYaGNVHFlUz/TNrZTWkIjN2M6MMRac7rTp8RxujYg2" +
       "3agNwk2XEGemwoI4ckF0EGzZi5itLNdcFKUYgeCx3gAbTpcupassngxqWXtR" +
       "Q6rQCthIATLcddhGuUZCRw3I4rhkXqtQGA48j7/CXFxZjIWIEPAWPLTXbL3V" +
       "Dmc6FFKYOw7x4XKKLEivEW+5lVcTavSUYMai3U5EdLDkBHE2NX0LEwhRaEoi" +
       "pWhuCmJgbkGVu3afoOe8SvE2iSorC0e7IogQ25W0q5brFD0gDXo7s6OyrcAp" +
       "ayfDTjonu0ZtU2OTOmRz3WVcq806fCUKgOvv9Ycg0OtrPWFAW/Jq2e95zWCV" +
       "sVg3yiS3W6tVI2m2QCROGYiMWt+I9bmRaR2I2jD4elyeBi0NQlrtZJXw662c" +
       "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" +
       "59CtI+jW7UAHgUUQ+rGuxrp2oQYO9ir6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ql7h4OrN1XDwjjy5I84Pb+RHu3ShOLC5dxcHd34P7qKIBN4NruwIaHabc3xw" +
       "z60QXi9QPHIJwsfy5HpcumbJiU6s1rJDnhx53s/3wYPfA85H8sw87vz4Ec6P" +
       "3wbOfcTD3YrQB89eUvZ8nrwLENq60O8fPPl9JvQT4PrMEf7P3OY833otHxxe" +
       "UpZHggcvAuixf+q03R76S98/6AXF83MUnzuC/rnvaupvGexe35P95Us0kT+1" +
       "HTQvWc6t26F5Gpceu8mJ4vx45ONv+nPD7kC++vOvX7v3sdcn/7Y4VHtyaP4q" +
       "XbrXWDvO6SNXp+7vDkLdsAs9XN0dwAoKSHhcevLSaCZHe3yfQzjAdg0pECde" +
       "0BDQ5Pj2dO1+XLpvXzsuXVHPFA9BiHBUHJfuAOnpQg5kgcL8dhQcB0qnDlXs" +
       "Tqiluxjq8dNEKlzNQ7eak5Mmp8/m5s+OxZ9Qjp/z1ru/obyifuX1PvOj32r+" +
       "zO5sMNBNluW93EuX7tkdUy46zZ8Vn71pb8d93d198TsP/MLVdx8/1z6wE3hP" +
       "6lOyPX3xQVzCDeLi6Gz2Tx77xz/ys6//QXGq5P8BByTTSR00AAA=");
}
