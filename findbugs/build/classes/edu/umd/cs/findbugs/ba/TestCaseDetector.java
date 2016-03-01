package edu.umd.cs.findbugs.ba;
public class TestCaseDetector {
    private static final edu.umd.cs.findbugs.classfile.ClassDescriptor JUNIT4TEST =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        "org/junit/Test");
    private static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      JUNIT3TESTCASE =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        "junit/framework/TestCase");
    public static boolean likelyTestCase(edu.umd.cs.findbugs.ba.XMethod m) {
        if (m.
              getAnnotation(
                JUNIT4TEST) !=
              null) {
            return true;
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor c =
          m.
          getClassDescriptor(
            );
        if (m.
              getName(
                ).
              startsWith(
                "test") ||
              m.
              getName(
                ).
              startsWith(
                "assert")) {
            edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getSubtypes2(
                );
            try {
                if (subtypes2.
                      isSubtype(
                        c,
                        JUNIT3TESTCASE)) {
                    return true;
                }
            }
            catch (java.lang.ClassNotFoundException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  reportMissingClass(
                    e);
            }
        }
        return false;
    }
    public TestCaseDetector() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe3BUVxk/uyFPQl4QHilJyAM0FHZLC9ZOEIElKaGbx5CA" +
                                                              "NVTC2btnk0vu3nu599xkk0ptUQd8IVKg1Gn5i04rA4Vx7Kij7eB0tO20OtNa" +
                                                              "batT6qgzopWxjGPriFq/79y7ex+7G6Z/uDP35Oac75zv9fse556/RkpNg7Qw" +
                                                              "lUf4jM7MSI/Kh6hhsmRMoaY5AnNj0iMl9O97rw7cFSZlo6Rmgpr9EjVZr8yU" +
                                                              "pDlKmmXV5FSVmDnAWBJ3DBnMZMYU5bKmjpJG2exL64osybxfSzIk2E2NOKmn" +
                                                              "nBtywuKszzmAk+Y4SBIVkkS3BJe746Ra0vQZl3yphzzmWUHKtMvL5KQuvp9O" +
                                                              "0ajFZSUal03enTHIrbqmzIwrGo+wDI/sVzY4JtgR35BngvZLte/fODZRJ0yw" +
                                                              "kKqqxoV65k5masoUS8ZJrTvbo7C0eYA8QEriZL6HmJPOeJZpFJhGgWlWW5cK" +
                                                              "pF/AVCsd04Q6PHtSmS6hQJy0+Q/RqUHTzjFDQmY4oYI7uovNoO2KnLa2lnkq" +
                                                              "nrw1euKRvXXfLSG1o6RWVodRHAmE4MBkFAzK0glmmFuSSZYcJfUqOHuYGTJV" +
                                                              "5FnH0w2mPK5SboH7s2bBSUtnhuDp2gr8CLoZlsQ1I6deSgDK+a80pdBx0HWx" +
                                                              "q6utYS/Og4JVMghmpCjgztkyb1JWk5y0BnfkdOy8Bwhga3ma8Qktx2qeSmGC" +
                                                              "NNgQUag6Hh0G6KnjQFqqAQANTpqKHoq21qk0ScfZGCIyQDdkLwFVpTAEbuGk" +
                                                              "MUgmTgIvNQW85PHPtYGNR+9Xt6thEgKZk0xSUP75sKklsGknSzGDQRzYG6tX" +
                                                              "x0/Rxc8eCRMCxI0BYpvm+5+/vnlNy+UXbZpbCtAMJvYziY9JZxM1ry6Pdd1V" +
                                                              "gmJU6Jopo/N9mosoG3JWujM6ZJjFuRNxMZJdvLzzZ5998Bx7N0yq+kiZpClW" +
                                                              "GnBUL2lpXVaYcTdTmUE5S/aRSqYmY2K9j5TDe1xWmT07mEqZjPeReYqYKtPE" +
                                                              "/2CiFByBJqqCd1lNadl3nfIJ8Z7RCSHl8JBqeJqJ/RN/OdkbndDSLEolqsqq" +
                                                              "Fh0yNNTfjELGSYBtJ6IpAFPCGjejpiFFBXRY0opa6WRUMt3FBI2OMJPHIGFu" +
                                                              "Y5wh4CNIrP/fOWRQx4XToRCYf3kw+BWIm+2akmTGmHTC2tpz/emxl21gYTA4" +
                                                              "1uHkY8AwAgwjkhnJMowkaCTIkIRCgs8iZGy7GBw0CaEOuba6a/hzO/YdaS8B" +
                                                              "bOnT88C6SNruqzkxNx9kk/iYdLFhwWzblXXPh8m8OGmgEreogiVkizEOyUma" +
                                                              "dOK3OgGSuEVhhacoYDUzNAm0MFix4uCcUqFNMQPnOVnkOSFbsjA4o8ULRkH5" +
                                                              "yeXT0w/t/sJtYRL21wFkWQopDLcPYfbOZenOYPwXOrf28NX3L546qLmZwFdY" +
                                                              "svUwbyfq0B5EQtA8Y9LqFfSZsWcPdgqzV0Km5hQiC5JgS5CHL9F0Z5M26lIB" +
                                                              "Cqc0I00VXMrauIpPGNq0OyMgWo9Do41WhFBAQJHvPzWsP/7mL/58h7BktjTU" +
                                                              "emr6MOPdnnSEhzWIxFPvInLEYAzo3j499PDJa4f3CDgCRUchhp04xiANgXfA" +
                                                              "gl9+8cBb71w5+3rYhTCHemwloK3JCF0WfQi/EDz/xQdTCE7YqaQh5uSzFbmE" +
                                                              "piPnVa5skNoUiCQER+cuFWAop2SaUBjGz79rV6575q9H62x3KzCTRcuamx/g" +
                                                              "zi/bSh58ee8HLeKYkISl1bWfS2bn64XuyVsMg86gHJmHXmt+9AX6OGR+yLam" +
                                                              "PMtEAiXCHkQ4cIOwxW1iXB9YuxOHlaYX4/4w8rRAY9Kx199bsPu9564Laf09" +
                                                              "lNfv/VTvtlFkewGYtRBn8CV0XF2s47gkAzIsCSaq7dScgMPWXx64r065fAPY" +
                                                              "jgJbCboLc9CANJnxQcmhLi3/zU+eX7zv1RIS7iVVikaTvVQEHKkEpDNzAjJs" +
                                                              "Rv/0ZluO6QoY6oQ9SJ6F8ibQC62F/duT1rnwyOwPlnxv45NnrghY6vYZt4j9" +
                                                              "YUz6vgwr2nU3yM/98s5fPfmtU9N2we8qntkC+5b+a1BJHPr9P/P8InJagWYk" +
                                                              "sH80ev6xptimd8V+N7ng7s5MfqGCBO3uvf1c+h/h9rKfhkn5KKmTnPZ4N1Us" +
                                                              "jOtRaAnNbM8MLbRv3d/e2b1Mdy55Lg8mNg/bYFpzCyS8IzW+LwhgcBm6EIOj" +
                                                              "1cFgaxCDISJedogtq8TYhcMa4b4STsp1Q4YrFEheZopOnIMcskqVTI6LAMrS" +
                                                              "ObhwUrVj10DfyPqRnuERsW0pJ2sL1XRxs8CGye44tzFTMmQdoGynZRw/icM9" +
                                                              "NveNRTG9zW+DB+Bpc6RrK2KDzxSxAb4O4DCIw1ABvYudzEmN0PsO1Du2ZbgH" +
                                                              "Z4cDqtw7hyqZwiKF8HWtK4j4lc2RajwRSTDtNBdr78XV5OyhE2eSg0+ss2Oy" +
                                                              "wd8y98CN8MKv//NK5PTvXirQqVVyTV+rsCmmeHhin9XsywL94ubjhtTbNcf/" +
                                                              "8MPO8a0fpcXCuZabNFH4fysosbp4YgmK8sKhvzSNbJrY9xG6pdaAOYNHfqf/" +
                                                              "/Et3r5KOh8U1z471vOuhf1O3P8KrDAb3WXXEF+cdOQA0oWM/Dk+HA4COIMZd" +
                                                              "0OWhKSzQJAAewHb9HCcGKmzIcbQT3C1FGvZ7bS2FOMYcRXoKB7BSjSJPMmUm" +
                                                              "2+f7+3UEyLCVMKG3ltPQb005F83bh/ZJRzqH/mjjd1mBDTZd41PRb+x+Y/8r" +
                                                              "wtMVCK2cfT2wAgh6usQ6HCIYQ3PUqoA80YMN70w+dvWCLU+wMAWI2ZETX/0w" +
                                                              "cvSEHVv2p4SOvNu8d4/9OSEgXdtcXMSO3j9dPPijpw4eDjsmBz7lCU1TGFXz" +
                                                              "vArtsN+KtqzbvlL742MNJb0QtX2kwlLlAxbrS/qRW25aCY9Z3a8PLo4dqbFR" +
                                                              "5SS0OttBiOyYvlmin7t5wYmteoaTuuBVEfuapXnfouzvJ9LTZ2orlpzZ9YZI" +
                                                              "R7lvHNWAkpSlKN7K63kv0w2WkoVG1XYd1sWfr0OLWzgcOAkD6pDmazbpNzlZ" +
                                                              "WICUA1/n1Ut9HOqqSw2HSb7lk+BQZ5mTEhi9i6dhChbx9VE9G7V1os/D1iRi" +
                                                              "tyaZkL9y5NzSeDO3eIpNhy9QxFfCLJIs+zshXLHP7Bi4//onnrAvVtAFzM7i" +
                                                              "KfMBP/b1LZdr24qelj2rbHvXjZpLlSuzwPZd7LyyCXAAvMUlqClw0zA7cxeO" +
                                                              "t85ufO7nR8peg5DcQ0LgtYV78pu4jG5BkdsTz48TqEviCtTd9e2ZTWtSf/ut" +
                                                              "aJOduFpenB6a1Iff7Ls0+cFm8VmqFBDAMqK73Daj7mTSlOELuhqEKcXvhcIO" +
                                                              "jvkW5Gbxhs1Je34qyf8uAVeIaWZs1Sw16YTtfHfG97kyW54sXQ9scGc82fOL" +
                                                              "dqSj9QF/Y/F+XXeup6H7dBGsXwrmHjEpNp8Xrzhc+B/pfEcDMBgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NoLlyp5j4LhjxuW+VkXDrY6nxEzrSXMxLvPrck2YJHpX7zTq9naOofFi1IiV" +
       "joJXdI5WQ37ZGFGwAFOlxUJLg1q3rjY78WIdud1lO2ADfBFlplJqwoHeVlpM" +
       "0wCHsLe/PT+eua/shHx3cRlw+EQGDsZ5x+IVnAx3XY/lxesP71CKz60vcf18" +
       "7IoOyk+7D93o5as46X76g1efU7nPlPf2rzbNBLo98YO3OtpKc46xym8c3nzj" +
       "Uz1TPPwdXbl95YP/9ODkHea7X8GjwiOn5DzN8reZ57/WeYPyq3vQTYcXcNc8" +
       "SZ4cdPnktdu5SEvSyJucuHx76NCyD+YWexP4PrFv2Seuf7F/XS/YO/KCnQOc" +
       "uj4+s2/F/Zugh2/w/rPYKVCw+PmXuIF+Ji/em0B3OZatOduDZ6OCVjnmV0YC" +
       "nZV939Ek78jn3vdytxEnrnwT6MLpV6n8Wv2Ba569d0+1yuefO3/b/c9N/7J4" +
       "mDl8Tr2dhm7TU8c5fgt6rH5rEGm6Vah2++5ONCj+/EoC3Xd9UyXQniwV0j67" +
       "I72aQPdehzQB8+5Xj1N/PIHOHVEDZsqJ7t8AdtvvTqCbQHm881OgCXTm1eeC" +
       "69zt7a6JN2dORuKh+e95OfMfC94nToRc8Q8JB+GR7v4l4Yryhef67HterH1m" +
       "96KkOFKW5Vxuo6Gzu8etwxB77IbcDnjd2n3yx3d98fbXH8DBXTuBjxz/mGyP" +
       "XP/Jpu0GSfHIkv3+/b/7tt987tvFVeP/ABkyOKEpIgAA");
}
