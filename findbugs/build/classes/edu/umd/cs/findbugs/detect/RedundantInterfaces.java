package edu.umd.cs.findbugs.detect;
public class RedundantInterfaces extends edu.umd.cs.findbugs.visitclass.PreorderVisitor implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public RedundantInterfaces(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass obj =
          classContext.
          getJavaClass(
            );
        java.lang.String superClassName =
          obj.
          getSuperclassName(
            );
        if ("java.lang.Object".
              equals(
                superClassName)) {
            return;
        }
        java.lang.String[] interfaceNames =
          obj.
          getInterfaceNames(
            );
        if (interfaceNames ==
              null ||
              interfaceNames.
                length ==
              0) {
            return;
        }
        try {
            org.apache.bcel.classfile.JavaClass superObj =
              obj.
              getSuperClass(
                );
            java.util.SortedSet<java.lang.String> redundantInfNames =
              new java.util.TreeSet<java.lang.String>(
              );
            for (java.lang.String interfaceName
                  :
                  interfaceNames) {
                if (!"java/io/Serializable".
                      equals(
                        interfaceName)) {
                    org.apache.bcel.classfile.JavaClass inf =
                      org.apache.bcel.Repository.
                      lookupClass(
                        interfaceName.
                          replace(
                            '/',
                            '.'));
                    if (superObj.
                          instanceOf(
                            inf)) {
                        redundantInfNames.
                          add(
                            inf.
                              getClassName(
                                ));
                    }
                }
            }
            if (redundantInfNames.
                  size(
                    ) >
                  0) {
                edu.umd.cs.findbugs.BugInstance bug =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "RI_REDUNDANT_INTERFACES",
                  LOW_PRIORITY).
                  addClass(
                    obj);
                for (java.lang.String redundantInfName
                      :
                      redundantInfNames) {
                    bug.
                      addClass(
                        redundantInfName).
                      describe(
                        "INTERFACE_TYPE");
                }
                bugReporter.
                  reportBug(
                    bug);
            }
        }
        catch (java.lang.ClassNotFoundException cnfe) {
            bugReporter.
              reportMissingClass(
                cnfe);
        }
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO38bg+3jswYMmIMIQ+5CG1JREwo+cDA5Y8t2" +
                                                              "kGoajrndOXvx3u6yO2ufndAGpAqSPxAhQGibuP8QpUUk0Dbph9pEVFGbRGkr" +
                                                              "JU3bpFVI1f5R2hQ1qGpSlbbpm5nd24+7cxopqqUdz828eTPvzXu/995cvI5q" +
                                                              "LBO1E40m6JRBrMROjQ5g0yJySsWWNQxjGenRKvy3/df2bI6i2hE0bwxbfRK2" +
                                                              "SI9CVNkaQcsVzaJYk4i1hxCZrRgwiUXMCUwVXRtBCxWrN2+oiqTQPl0mjGAv" +
                                                              "NtOoFVNqKlmbkl6HAUXL03CSJD9Jcnt4uiuNmiTdmPLIl/jIU74ZRpn39rIo" +
                                                              "akkfxBM4aVNFTaYVi3YVTLTe0NWpUVWnCVKgiYPqJkcFu9ObSlTQcbn5vZsn" +
                                                              "x1q4CuZjTdMpF88aJJauThA5jZq90Z0qyVuH0BdQVRrN8RFTFE+7myZh0yRs" +
                                                              "6krrUcHp5xLNzqd0Lg51OdUaEjsQRauCTAxs4rzDZoCfGTjUU0d2vhikXVmU" +
                                                              "VkhZIuKZ9cnTj+5v+VYVah5BzYo2xI4jwSEobDICCiX5LDGt7bJM5BHUqsFl" +
                                                              "DxFTwaoy7dx0zFJGNUxtuH5XLWzQNojJ9/R0BfcIspm2RHWzKF6OG5Tzqyan" +
                                                              "4lGQdZEnq5Cwh42DgI0KHMzMYbA7Z0n1uKLJFK0IryjKGL8bCGBpXZ7QMb24" +
                                                              "VbWGYQDFhImoWBtNDoHpaaNAWqODAZoUtVVkynRtYGkcj5IMs8gQ3YCYAqoG" +
                                                              "rgi2hKKFYTLOCW6pLXRLvvu5vmfLifu0XVoUReDMMpFUdv45sKg9tGiQ5IhJ" +
                                                              "wA/EwqbO9Fm86LnjUYSAeGGIWNB89/4b2za0X3lJ0CwtQ9OfPUgkmpHOZ+e9" +
                                                              "uiy1bnMVO0a9oVsKu/yA5NzLBpyZroIBCLOoyJFNJtzJK4M/+dwDF8g7UdTY" +
                                                              "i2olXbXzYEetkp43FJWYdxGNmJgSuRc1EE1O8fleVAf9tKIRMdqfy1mE9qJq" +
                                                              "lQ/V6vw3qCgHLJiKGqGvaDnd7RuYjvF+wUAI1cGHMvCtRuKP/6eIJMf0PEli" +
                                                              "CWuKpicHTJ3JbyUBcbKg27FkDowpa49aScuUktx0iGwn7byclCxvUiYUliUH" +
                                                              "YU6TwZl7i1abYGuM/9dGBSbx/MlIBC5jWRgKVCDbpasyMTPSabt7542nM68I" +
                                                              "M2Ou4eiKogTwTsC+CclKuPsmxL6JMvuiSIRvt4DtL+4dbm0c/B8AuGnd0L27" +
                                                              "DxzvqAKDMyarQeWMtCMQiFIeSLjInpEuxeZOr7q68YUoqk6jGJaojVUWV7ab" +
                                                              "o4BY0rjj1E1ZCFFepFjpixQsxJm6BAc2SaWI4XCp1yeIycYpWuDj4MYx5rHJ" +
                                                              "ylGk7PnRlXOTR/Z+8bYoigaDA9uyBnCNLR9gkF6E7ngYFMrxbT527b1LZw/r" +
                                                              "HjwEoo0bJEtWMhk6wgYRVk9G6lyJn808dzjO1d4A8E0xuBsgY3t4jwD6dLlI" +
                                                              "zmSpB4FzupnHKptyddxIx0x90hvhltrK+wvALOYwd2yHb63jn/w/m11ksHax" +
                                                              "sGxmZyEpeKS4c8h4/I2f/+lTXN1uUGn2ZQNDhHb5gIwxi3HIavXMdtgkBOje" +
                                                              "OjfwyJnrx/ZxmwWK1eU2jLM2BQAGVwhq/tJLh958++r516OenVOI5HYWEqJC" +
                                                              "UUg2jhpnERJ2W+udB4BQBadjVhO/RwP7VHIKzqqEOda/mtdsfPYvJ1qEHagw" +
                                                              "4prRhg9n4I1/ohs98Mr+99s5m4jEArGnM49MoPt8j/N208RT7ByFI68t//KL" +
                                                              "+HGIE4DNljJNONxGHF9nh1oCwbocpHTbo4PE0E0AEn65mzj1bby9nSmG80B8" +
                                                              "bjNr1lh+Jwn6oS+xykgnX3937t53n7/BpQpmZn6b6MNGlzBD1qwtAPvFYRDb" +
                                                              "ha0xoLv9yp7Pt6hXbgLHEeAoAe5Z/SYgaSFgQQ51Td1vfvTCogOvVqFoD2pU" +
                                                              "dSz3YO6MqAG8gFhjAMIF47PbhBFM1kPTwkVFJcKXDLCLWFH+infmDcovZfp7" +
                                                              "i5/Z8uTMVW6NhuCxtIi+ywLoy/N7DwAu/OLTv3zy4bOTIkNYVxn1QuuW/LNf" +
                                                              "zR79/T9KVM7xrkz2Elo/krz4WFtq6zt8vQc8bHW8UBrLALy9tZ+8kP97tKP2" +
                                                              "x1FUN4JaJCef3otVm7nzCOSQlptkQ84dmA/mgyL56SoC67Iw6Pm2DUOeF0Oh" +
                                                              "z6hZf24I5WLsCjvhizsAEA+jXATxzt18yS287WTNrfz6ohTVGaYCNRecvAY8" +
                                                              "CashdGmdhTlFc7Kez7GhOwSosvYzrEkLbneWM00xdQtr1hf35H+14bTKj2ie" +
                                                              "7UVdNFhWDg128ATDqROAaE05IlasEBV8z6VmPru8UjLNC4HzR0/PyP1PbBQG" +
                                                              "HQsmqDuh/nrqV//+aeLc714ukwk1UN24VSUTRA2IAVsGXKiP1xmePb4179Qf" +
                                                              "vh8f7f4ouQsba/+Q7IT9XgFCdFb2yvBRXjz657bhrWMHPkIasiKkzjDLb/Rd" +
                                                              "fPmutdKpKC+qhKOUFGPBRV1B92g0CVSP2nDASVYHU4Et8K13bGp9+VSgrIdE" +
                                                              "WDdRJuRWYhYKOqHAtbqcFWaxsDGnaObHGZ8lePGSBBy2dUKB7MO/1JoVYgdM" +
                                                              "JQ/ZyoRT4CUPx94ef+zaU8KSw3gaIibHTz/0QeLEaWHVomReXVK1+teIspkf" +
                                                              "uEWo7wP4i8D3H/YxadiAKJtiKad2W1ks3ligMdGq2Y7Ft+j546XDP/j64WNR" +
                                                              "Rzv3UlQ9oSuyh0K5IAo1FVGoeC0xHgAZZif6wTlMRSazANf/ElXZQMrg4zho" +
                                                              "iUvgG3aMZ/jjsMRKzGaxoGOzzD3ImiOQbZoc2Nkv6unyaEVdsuH7PxatFSia" +
                                                              "X6YwZJnKkpLnKPGEIj0901y/eOaeX3OMLD5zNAHa5WxV9cdSX7/WMElO4VI3" +
                                                              "ichq8H+nKGqrXLSCakSHn/9hseQMnLnMEgr7O10/9TmKGj1qiqJSYPqrEJad" +
                                                              "aYqqoPVPzsAQTLLu1wzXgMvW2Bwe+OMfuA3RWXq5lw1BmIv4ApBzEfx6F84S" +
                                                              "sINL/HUMQxr+nOhCvC0eFKHsntm9574bdzwh6ig4y/Q04zInjepESVcME6sq" +
                                                              "cnN51e5ad3Pe5YY1rqO3igN7LrPUZ8UpsEiDWUxbqMiw4sVa483zW57/2fHa" +
                                                              "1wDT9qEIhhvcV5q8FQwb4vO+tBehfc/RvPrpWveVqa0bcn/9LU+PUUlSHKaH" +
                                                              "5PSRN3ovj7+/jb9f1cB1kQLPKndMaYNEmoC8vt7WlEM26ZXTaB4zZsweFrke" +
                                                              "HPXNLY6yqpuijlIsLn2rgNJhkpjdOngWD5QQwr2RwLumG1ltwwgt8EaKV7eg" +
                                                              "VNaMtOPB5h+ejFX1gEMGxPGzr7PsbDFq+586vTDewhq7IKJEVSbdZxhO1Ki6" +
                                                              "bAjz/6YgYcMURTqdUV/wZT+f4dy+zbus+c5/AXAe+CfEGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eWaXUOnvveF3nvqNF7+eHwb/N75lWVpSIwAA");
}
