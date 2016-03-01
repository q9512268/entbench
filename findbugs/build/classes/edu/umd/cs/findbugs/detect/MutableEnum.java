package edu.umd.cs.findbugs.detect;
public class MutableEnum extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private final edu.umd.cs.findbugs.BugReporter reporter;
    private boolean skip;
    public MutableEnum(edu.umd.cs.findbugs.BugReporter reporter) { super(
                                                                     );
                                                                   this.reporter =
                                                                     reporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (!classContext.
              getJavaClass(
                ).
              isEnum(
                ) ||
              !classContext.
              getJavaClass(
                ).
              isPublic(
                )) {
            return;
        }
        boolean hasInterestingField =
          false;
        for (edu.umd.cs.findbugs.ba.XField field
              :
              classContext.
               getXClass(
                 ).
               getXFields(
                 )) {
            if (!field.
                  isStatic(
                    ) &&
                  !field.
                  isFinal(
                    ) &&
                  !field.
                  isSynthetic(
                    )) {
                if (field.
                      isPublic(
                        )) {
                    reporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          "ME_MUTABLE_ENUM_FIELD",
                          NORMAL_PRIORITY).
                          addClass(
                            classContext.
                              getJavaClass(
                                )).
                          addField(
                            field));
                }
                else {
                    hasInterestingField =
                      true;
                }
            }
        }
        if (hasInterestingField) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public boolean shouldVisitCode(org.apache.bcel.classfile.Code obj) {
        skip =
          false;
        if (getXMethod(
              ).
              isPublic(
                ) &&
              getNumberMethodArguments(
                ) >
              0) {
            return true;
        }
        return false;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (skip) { return;
                                      }
                                      if (isBranch(seen) ||
                                            seen ==
                                            ATHROW ||
                                            isReturn(
                                              seen)) { skip =
                                                         true;
                                      }
                                      if (seen == PUTFIELD) {
                                          edu.umd.cs.findbugs.ba.XField xField =
                                            getXFieldOperand(
                                              );
                                          if (xField !=
                                                null &&
                                                xField.
                                                getClassDescriptor(
                                                  ).
                                                getClassName(
                                                  ).
                                                equals(
                                                  getClassName(
                                                    ))) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item val =
                                                getStack(
                                                  ).
                                                getStackItem(
                                                  0);
                                              if (val.
                                                    isInitialParameter(
                                                      )) {
                                                  reporter.
                                                    reportBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        "ME_ENUM_FIELD_SETTER",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addField(
                                                          xField).
                                                        addSourceLine(
                                                          this));
                                              }
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+6ITOo/l0fxpiI1v8CkbLv8X/JmP9VwbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rrHglaTCJmIz7bP8EHHGJG7JA2TsYmIrkStm3UN4gWo2Jww8HhalPlkciSJX" +
       "TZLx2luF/aJMiXNl5Q4nfNnRS1JbCCoki4t+baRTDjWeoUFtyaI0RZKJQTWc" +
       "FsmP9EZDalYtXugMENFc4O2ysW4ZQxdNGaQcr4OO5xLqHEN6nSkzL87gZipM" +
       "UKK96qEJ3XXmU63FY912IKzHLjEoNPw6GvlNhmT8Wb9uSt2ENoZJRGDsyk+t" +
       "bmJ1J46c9pZdillJ9TqJME3MMehZzTOXraDT8PRZ4EwJtF+bcb4n9+pTr0vU" +
       "U2fMDmertc2HM3TVa5R7etltElGjkhKT+kQgmj1d7JQHI6JPipsxxZB8usGF" +
       "0CvCWqdQGQ7QZZMjZZpmyEK3SrrdWb1oi3xnIRJ9guwgYmykWLshlzSSrLcT" +
       "u04mC84utCrlWKLQSqHbrU/n9ba7lFPeGFRoGulu2ikyk7Uu0LPeUqCVHjqx" +
       "NBpecT2/gtMouqyX5q7RYlZThLJllEExGI20sL/CtIbHdCRz7IkzTyCWBWfF" +
       "iBhDLttRx3DSHinQkjkkEGrQxgo1aj4iufXaGXo46ppN02HX7rTQ6rqpXWgY" +
       "Jl1feJbTjMS1FXblaIa7JF2zlc5wQAlrh/LLFs3hJa0EVrMoFtmOqZNitPYC" +
       "odLoYLRUnS1K62E9XPfTVkMfJbqDziozPZWW/qo7mAQ1hrYovmIVTbLOY9MZ" +
       "Qsnj5sLW29Nxonpard6c0xEVGJN6x2SqCcU53WGvOB2NV/ysuKiIFubFHF4s" +
       "9mLSnywclPF0sWHJrZKwcdzOXJErjBH3DTtmB90ez1ky1m9ps1allBJ2s2/4" +
       "E3weY7GPrTh2qBKzwmqQerRIsHHQHTmq1KCTHmfwileupqE26lqrUJ8Qabs2" +
       "MYyWOZ/B0wWmG80NP2XRamtmOwRfbk0p2l13k7E1d5oLXV81u5NEnPO+Uxwt" +
       "KsiIZcNGIpoC06CXuhi2hBgfpsPeqJbAsooGM11DWgsCmddji3E0NUVohC3O" +
       "W4tqX11OMS6pxLG9jGABa4wW3trt9+QNMW90ikRa1D26pIvKmNeothNpxaEf" +
       "z7o82xsPEJ0grKRrR22mZyH91BLXZoerd2WkMytNwv7Ii1yyT7ERFcn1QliC" +
       "uXmJmE+YfiKWWqGertvwBptJSkPqt4Y4CwP1JcRqR4Elf4nDZWNTqxleLHWH" +
       "JcT2fG2EGhKNNtNZPK6yyrQs+XGjUx8tsCU+rMFkKiYKJs+rLYOeV4miNEPr" +
       "FE2uko5o44tUQOJY4EykH+pItepOqMSvzxCONoLVtKhOiskCyBfBCjOq6RbJ" +
       "pCcWaLw1IrjCdLzpdvuEIsKiK4aRRgoJLpCNdDiTlbVTU2dNjBPKVo2oMQW4" +
       "7HSsETm2ghLjVORqq9lyYXNslbBGY0MXeksZrnnGEIHry2KvtgDJ5drsN93a" +
       "dNBWo54nmAOT65urFTattkVDTObjKYXL4XBTmSxxdaOPGiJPAkGW2HUxjVfc" +
       "cllk2XpjbLYFuxanAYFvENgexyu8161xNYqsjaSFTpXn9oLbyDOCkRZBcbhg" +
       "4lrJlzhk7QhS0mgNxLozUEK9pnuDwahXaOBdna+6BVhlmYYQasyY0RmTd8XG" +
       "cq4Lq8RZeJ261e0POIat0LDSpdOFo6+pqVHy1nqzMC815zO7VWhiqqXIHtuL" +
       "p41IqSlwYUR3a4mkjFvLuixzAeYv1nilusTkUdI3NS12hRGGh4XOyCFas+kG" +
       "aH7ctmG8NeYJDMeW6XpSxdaCWwzoUh2mNsvNFGXaujDDY1qvUG3ZXiFLooMZ" +
       "eCSJ2khLqpgJl4rLHoghIrKqVYuNKdMCDr5G+uiishmNiohfrmm1qm25a1Si" +
       "aIVqphXb6je6ciG0R4RdpJJCp9wwKy66WNYWdIdgerLRbtKYsjGJSVXoTalp" +
       "aVTukv6oMbSjSUCUyfGAnyyYuTstiSWdn1CYVA+UGmZ0Nt00KCQdvtzBJvaA" +
       "2USbIU5RpIy2pbJZQ5gOKUebHlNUOyMhaPgthR2UaqSkWyNFgOOk727i8jhx" +
       "ZJwRx0u/hEltFYk1ITIHbr/KJY5ml4vNgdzuq4aNmCWOcbp46pgM2585ypIt" +
       "FrQ6gbZdlJmQbgnWmepA42p6u9CfMLNlP5DwhmQWhDkXCi2HGxEmW1+wy0LB" +
       "Bpbvh5XJYjFY0km91zCLtV6Tc0oqZ6ycBbNqhn1NHjClSomsmynKkG1ZUoqR" +
       "2SsNQ1nbFDC4NOHwRuJFlbgYcmrQ3OB4iiOqQWM4PnbLamCsdXHgE+JSVHSJ" +
       "YUvUGtZmw4GF1+RqYT0seJ2o0uxXxpJlruMgKLpYcYhYc5EfVwkbaBiFr1C1" +
       "k5aQ+ni6mKAkt6wmjUGBwefTgGohiMmVhfWqixFqlVZSNnSWrjKh9C5IOivi" +
       "qjEsVi21XJs1cclvd4YIoQjFaTpYj/QB5/E0tZ6rmAovTGSFklK1Vq1wGjfs" +
       "zDBtzlOWWEQwcWDO/aqwwBGhpUlqhwziNqdvSsBWO1gAD6IC3u+SZqdnxrVy" +
       "Wq6IuFlcsbpm9QR0ZNtuVGuLMYvzlQnhUVNHi2tOVVO1SqEFtqaYSAWp40fa" +
       "aoRqQ66NqJ1plxgZ2oCRhFWlPOOnjNGHeaaBSiZmObjLo+uZ29UjoSNOkVLc" +
       "TTRNXMhwYSB3nHaorVwimI7hSuL1KtRwDvQorJAByIvwwYTrqYOVxYs87KoF" +
       "3UCKlfZGWQMDMXXWwKWZhW6q/SAdGKyPzK3lcNnvuEB10YHY7Bi8y8Mp3rKJ" +
       "aEmunOFGthLR2Gy6ulcDyZtfsyvjFYHrCl5fSrjqF/hmWwkK4zaXrEK5oMSL" +
       "acH350bYLqlTMqWkYRDhXKs0r7J1AxVK3ZpKJnalN9+Ea8w129XpaF6tb7o+" +
       "CKcVRTanhUE/WvtwWUOIsu51vE0loEVUsMrShga70WZFtUasOtmMCpXqps2W" +
       "ax4aUz69BoFrLFU415prHrGyaaFPeEUBbAdiuWboDhMXRnVmMun12apA9JxN" +
       "q4d1FwlTczYcMljWmLE4ZkaT1qxqYTDZ9eB4gEx1lsILQ3a2WBXRWBzgC0UU" +
       "WbiQGgQ3LcGToFdQxN6mo2tVgaVsob9R3Pmo3IqqwzEGe0zUImkm7q44XlX6" +
       "UoigG3iM2zrBNYgGPkb6PV4fFztRF+kgcc/UxVU5rHuYxKzTYLNpyZEcmFWb" +
       "aotLqdNua6O43sAEiymhRAGX5+sJ3sA2HgLHltZeu7XGxIsF3mgmQgWXoypC" +
       "KSjJWLTAMZq+CBiunUjixC7X5BXrV7wCXBopbRqISJ8JeknB0SodK+WqXEB7" +
       "hiY34/qUHDUYZC3RNSEcEg6msZg06ktdi0FDGQT9ihsNhemYG+sDpLwR40iu" +
       "leRupHZ6M2sz6Y5iOm04BSoCURi1NTeuCE49mWApyxlrvhH2CgVSGsBNVZAU" +
       "vFDpjPoObBa11DWAMKrkSmLiqgDTFlebJCBfr78+23p6P9iW+I58939wJwh2" +
       "wlmH+APserddD2bFIwfHRPnvzMl7pKOn0YdHj1B2xvLq61315ecrH3n62eeU" +
       "/keRnb0j20kI3RI67k+aaqyaR1CdBpgeu/5ZUi+/6Tw8Svzc0/9y7+gN+lt/" +
       "gIuU+0/QeRLl7/Se/wL1Gvm9O9Dpg4PFq+5gjwM9cfw48byvhpFvj44dKr76" +
       "+GXGk+B5fE+yj588gDtcu2ufvr1uu/YnTsRPnKo/fK1TdUncrsveNXiO55kb" +
       "nKy/KyueBkoWG4ERHgW95nFL7BjKoc79/HGdu+1A5w5ovHR4TtSPVd83FPUG" +
       "anr1+Xfe8HMHkr1zX0/re5Kt/1gke5/jL3ZBli3r6q4kq+Zu/h1Ddj27SzqK" +
       "mqP49RsI9Tey4v0hdCHQnchUJrloAWDWPDoU3weuK76s+b0/jKByFXwYPPSe" +
       "oOgfvaBO6MZpw96q28duIJkXsuKjwDUEIsgi5T2Z/PKhTH7zRyiTNIRuPXLt" +
       "m51i33PVRyXbDyHkTzx34dzdz43/Or/5PPhY4RYGOqdFpnn0KuFI/Yzrq5qR" +
       "M3bL9mLBzf8+HUL3Xv8qOoTObCs5wb+/BfnDELrzGiAhmH+venT0Z0Lo/OHo" +
       "ENqRj3W/GEJn97rBuoDyaOdnQRPozKp/6u5r/OPX9CWZ6m9XiQ+BoBo51Y6f" +
       "njoeGg4W79L3O3k9Ek0ePhYD8k+C9v11tP0o6Ir8wnM0+7aXKh/dXusCI9xs" +
       "MiznGOjs9ob5wOc/eF1s+7jOtB/97u2fvOWR/fh0+5bgQzM4Qtv9175DbVpu" +
       "mN96bv7g7t978ree+2p+2P1/7j9806slAAA=");
}
