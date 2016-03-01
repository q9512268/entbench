package edu.umd.cs.findbugs.detect;
public class InstantiateStaticClass extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public InstantiateStaticClass(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKESPECIAL && "<init>".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "()V".
                                            equals(
                                              getSigConstantOperand(
                                                ))) { edu.umd.cs.findbugs.ba.XClass xClass =
                                                        getXClassOperand(
                                                          );
                                                      if (xClass ==
                                                            null) {
                                                          return;
                                                      }
                                                      java.lang.String clsName =
                                                        getClassConstantOperand(
                                                          );
                                                      if ("java/lang/Object".
                                                            equals(
                                                              clsName)) {
                                                          return;
                                                      }
                                                      if ("<init>".
                                                            equals(
                                                              getMethodName(
                                                                )) &&
                                                            getPC(
                                                              ) ==
                                                            1) { return;
                                                      }
                                                      if ("<clinit>".
                                                            equals(
                                                              getMethodName(
                                                                )) &&
                                                            getClassName(
                                                              ).
                                                            equals(
                                                              clsName)) {
                                                          return;
                                                      }
                                                      if (isStaticOnlyClass(
                                                            xClass)) {
                                                          bugReporter.
                                                            reportBug(
                                                              new edu.umd.cs.findbugs.BugInstance(
                                                                this,
                                                                "ISC_INSTANTIATE_STATIC_CLASS",
                                                                LOW_PRIORITY).
                                                                addClassAndMethod(
                                                                  this).
                                                                addSourceLine(
                                                                  this));
                                                      }
                                      } }
    private boolean isStaticOnlyClass(edu.umd.cs.findbugs.ba.XClass xClass) {
        if (xClass.
              getInterfaceDescriptorList(
                ).
              length >
              0) {
            return false;
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor superclassDescriptor =
          xClass.
          getSuperclassDescriptor(
            );
        if (superclassDescriptor ==
              null) {
            return false;
        }
        java.lang.String superClassName =
          superclassDescriptor.
          getClassName(
            );
        if (!"java/lang/Object".
              equals(
                superClassName)) {
            return false;
        }
        int staticCount =
          0;
        java.util.List<? extends edu.umd.cs.findbugs.ba.XMethod> methods =
          xClass.
          getXMethods(
            );
        for (edu.umd.cs.findbugs.ba.XMethod m
              :
              methods) {
            if (m.
                  isStatic(
                    ) &&
                  !m.
                  isSynthetic(
                    )) {
                staticCount++;
            }
            else
                if (!"<init>".
                      equals(
                        m.
                          getName(
                            )) ||
                      !"()V".
                      equals(
                        m.
                          getSignature(
                            ))) {
                    return false;
                }
        }
        java.util.List<? extends edu.umd.cs.findbugs.ba.XField> fields =
          xClass.
          getXFields(
            );
        for (edu.umd.cs.findbugs.ba.XField f
              :
              fields) {
            if (f.
                  isStatic(
                    )) {
                staticCount++;
            }
            else
                if (!f.
                      isPrivate(
                        )) {
                    return false;
                }
        }
        if (staticCount ==
              0) {
            return false;
        }
        return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yIaL/wMuDUEWSRkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aC6wj11mevdnsJpvHbjZtGkLz3hQSlzt+jT1WWuiMPfZ4" +
       "PA8/xjP2QLudt8ee98NjuwTaSNCKilCVtBSpDUi0QKv0IUQFEioKQtBWrZCK" +
       "Kl4SbYWQKJRKjRAFUaCcGd97fe/duwkVEpbm+Pic8//n///z/9/55xy/+G3o" +
       "1iiECr5nr03bi/f1Vbw/t5H9eO3r0T5FI305jHStactRxIO26+pjn7n83e+9" +
       "b3ZlD7ogQffKruvFcmx5bjTUI89e6hoNXd61ErbuRDF0hZ7LSxlOYsuGaSuK" +
       "n6ahO46RxtA1+lAEGIgAAxHgXAQY240CRHfpbuI0MwrZjaMA+hnoHA1d8NVM" +
       "vBh69CQTXw5l54BNP9cAcLgt+y0ApXLiVQg9cqT7VucbFP5AAX7+V9525Xdu" +
       "gS5L0GXLHWXiqECIGEwiQXc6uqPoYYRpmq5J0D2urmsjPbRk29rkckvQ1cgy" +
       "XTlOQv3ISFlj4uthPufOcneqmW5hosZeeKSeYem2dvjrVsOWTaDrfTtdtxq2" +
       "s3ag4CULCBYasqofkpxfWK4WQw+fpjjS8VoPDACkFx09nnlHU513ZdAAXd2u" +
       "nS27JjyKQ8s1wdBbvQTMEkMP3JRpZmtfVheyqV+PoftPj+tvu8Co23NDZCQx" +
       "9NrTw3JOYJUeOLVKx9bn2+ybnnuHS7p7ucyartqZ/LcBoodOEQ11Qw91V9W3" +
       "hHc+RX9Qvu9z79mDIDD4tacGb8f83k+//JY3PvTSF7ZjfviMMZwy19X4uvpR" +
       "5e6vvL75ZOOWTIzbfC+yssU/oXnu/v2DnqdXPoi8+444Zp37h50vDf90+s5P" +
       "6N/agy51oQuqZycO8KN7VM/xLVsPO7qrh3Ksa13odt3Vmnl/F7oI6rTl6ttW" +
       "zjAiPe5C5+286YKX/wYmMgCLzEQXQd1yDe+w7svxLK+vfAiCLoIHuhM8j0Lb" +
       "T/4dQzN45jk6LKuya7ke3A+9TP8I1t1YAbadwQZwJiUxIzgKVTh3HV1L4MTR" +
       "YDXadWp6DMjg7jaULaDMQVxlC7ufkfn/j3OtMr2vpOfOgSV5/WlAsEEskZ6t" +
       "6eF19fkEJ17+1PUv7R0FyIHFYqgEpt4HU++r0f7h1PvbqffPnho6dy6f8TWZ" +
       "CFsHAMu3AEAAIPLOJ0dvpd7+nsduAZ7np+eB7bOh8M2RurmDju10KvBf6KUP" +
       "pe8Sfra4B+2dhNxMbNB0KSPvZ0B5BIjXTofaWXwvv/ub3/30B5/xdkF3AsMP" +
       "sOBGyiyWHztt4NBTge1Cfcf+qUfkz17/3DPX9qDzACAAKMYycGKANw+dnuNE" +
       "TD99iI+ZLrcChQ0vdGQ76zoEtUvxLPTSXUu+8nfn9XuAje849PRrB16ff2e9" +
       "9/pZ+Zqtp2SLdkqLHH/fPPI/8ld/9o+V3NyHUH352OY30uOnj8FDxuxyDgT3" +
       "7HyAD3UdjPvbD/V/+QPffvdP5g4ARjx+1oTXsrIJYAEsITDzz30h+Ouvf+2j" +
       "X93bOU0M9sdEsS11daRk1g5degUlwWxv2MkD4MUGTpx5zbWx63iaZViyYuuZ" +
       "l/7n5SdKn/3n565s/cAGLYdu9MZXZ7Br/yEceueX3vZvD+VszqnZ9raz2W7Y" +
       "FjPv3XHGwlBeZ3Ks3vXnD/7q5+WPAPQFiBdZGz0HsXMHgZMJ9VqwBZ4Vonhi" +
       "DnXfC8F+li8unI9+Ki/3M8PkPKC8r5IVD0fHg+RkHB5LV66r7/vqd+4SvvOH" +
       "L+dancx3jvsEI/tPb90wKx5ZAfavO40IpBzNwLjqS+xPXbFf+h7gKAGOKtjk" +
       "Iy4EyLQ64UEHo2+9+Dd/9Mf3vf0rt0B7beiS7claW86DEbodRIEezQCorfyf" +
       "eMvWCdLbQHElVxW6Qfmt89yf/zoPBHzy5jjUztKVXSjf/x+crTz7d/9+gxFy" +
       "BDpjlz5FL8EvfviB5o9/K6ffQUFG/dDqRrQGqd2OtvwJ51/3HrvwJ3vQRQm6" +
       "oh7kjYJsJ1mASSBXig6TSZBbnug/mfdsN/mnj6Du9adh6Ni0p0Fot0uAejY6" +
       "q186hTtXMys/BZ7HDkLysdO4cw7KK1hO8mheXsuKH8nXZC+GLvqhtQQbTAym" +
       "t1zZPoj374PPOfD8d/ZkTLOG7VZ+tXmQTzxylFD4YCO7Q9lFRMaiuIW8rKxm" +
       "Bb7lXL+p47wpKzqrcwB7bi3v1/dzBvTZgt+SVX8UgFSU74vZr3Zum04MosBW" +
       "rx3KKIAcG7jNtbldPwznK7nHZwu0v01MTwna+V8LCjz67h0z2gM57nv//n1f" +
       "/qXHvw7cjoJuXWYuAbzt2IxskqX9P//iBx684/lvvDcHXIA0oyeVf3lLxlV4" +
       "JXWzon9C1QcyVUdeEqo6LUcxk2OkruXavmK09UPLAVvJ8iCnhZ+5+vXFh7/5" +
       "yW2+ejq0Tg3W3/P8L3x//7nn9469JTx+Q6J+nGb7ppALfdeBhUPo0VeaJado" +
       "/8Onn/mD337m3Vuprp7MeQnwSvfJv/ivL+9/6BtfPCOtOm97/4eFje/6JlmN" +
       "utjhhy5NjWo6FlYlOIGNOt7YaGjIkCSJRSxpDFyBoltDpD3lSLOGI5XqyFrN" +
       "ygLCwXFZq88lRySdjVbRBWVgB3LTsZplO8AHPLZe2DGOzz1UGU1xP3ZKMl9y" +
       "fIWX7SHRaPfoVqc8jPmaocNsfbmZLuU+Wl0rdW0pN+pwUqijcL8BL51KWxhP" +
       "Ecczy2ZxGKnsNBqX5clg4KwkalUSIpGPTdpawOPpBF4ul704FmZCK2H8RE9L" +
       "o8bcggfBkCgpadnCPXsxlje9VTzrjKR51OHF7lBdDfmhpneKo027FkVKYHXD" +
       "uN3oE0U5JZCIKnWnPiuJY37sGGm1aeEDZzDkeqMRl7TWmyJVam7AVjOj+7HW" +
       "Ipd6xDABqiNSeyzGFr2qtxeLoiCMPa+dFH2nYyGevJyLgugyQs+MlErQi1RC" +
       "XHHherEZ6DJpp4WYVIOKire41E+ccVDWYgqRk7lPFbFQrEZIPF6ERtkbFazA" +
       "HAboDOfbRHHcQibmGFtwtBiGY48sFqszBykwNaGqipw2lpkZ1/UioUCZ07Kq" +
       "ITMGndm4WS+V2I6mpFLcRsRiWwjEwJhX1cT1iHqsLEt6W/SkoVXrssykvSC6" +
       "dLOrsuaYovqExspuscY3WnhQRFvSAB2Oo57PcFSNEwlfTBuDTmNlsKklxSYy" +
       "R3lWE6uEMdgoQzvwI7vBd1GPWsHscCFIRXJSlmvJIGJ11kR7rOWZDuXiBGlw" +
       "duINh+OYj1vNqlcbzht41TR7pZI+pjZ64niyWWnh3aBLtDsr2xc73f6oSFMt" +
       "sYY3MWoxiRcbyo7nctrv9jYUs7CYBVbpUTIWeIRiOuWZ3JYHc5Jp0vUxueT4" +
       "1aYhxHJahb1OZZhaJsEEOhW2aMQp4/yw3OI1vzujPAIl8ERJVn0S5db0DO12" +
       "MaMTYXTHLKjEJAxKSnFC+tKY2IQpzQ463nIh2qO+L8rwMkR11gh6ltRZym2l" +
       "6XIFvsLp0rTPjRYwjnVH0kSnu22n316Nl4pRUQyzbFCFMjkud7VAEsoldIWT" +
       "itLT2dVIcKiEGi5WzEjx+uwQi0ndCA3Z5NwZ1xtGfDRoSnNCC8jAHhcEebmB" +
       "y02rReMm5QSEVJzQNUZwsQajGuvqtNkjaoUe5RSaSKcasXBP9SmOL/Wp5mrO" +
       "a+2irLVAFNREvGvxWLx0fCwlxmjIiT5lr2fdPin1yhSfGLbD05NxyjfjaGGO" +
       "V2NMFNVlp8fNlXa8WsKrEKN5HZWmPWyQOENgSlxYy9Mk8T1Hsruw3NlImr5R" +
       "kMA0y7bV5FajmdwcG2SVs6YKI/aGqEEUFbI3rLEDi0Kri+rCxMyWyqYUhhFz" +
       "tdISinBj2phtgrDb7zGRGKT9UT9utMVF0o3E4XTWXyfqvLieipNSHZnOZgJV" +
       "woh1g+/0rCitocXIbZb7HOtqbpeSEUlmhlJtlIqBFqiJOS8unN6qyNkVv2FT" +
       "s8gNehJp1ttmJI0EJEDd9mhMloq1/lIZbCxYIxfSzEAEc9iYYilNxma6UUYr" +
       "U2/JVItSqjFea6B6vz414kq7KcBST1DoyC8xMxQxeYxnF8io3i6Q7mJmVIZ1" +
       "V+qkLbI3lVGsOo+aVH1m1jp6NxhsJrqPV6erBAnJnu15ZSUYIONVYyNVrDRe" +
       "kq4zxERenSzmrYBau7BUc9at+YQlVJqpNstzfIQq2gCVeQWGrQ0CW4iFiPZK" +
       "6osbnJC7KFkcWpsmoyfsXIs0xCIwtlxfpSqA8E2QCkVU8trWSB63vPKawZAe" +
       "3kRJplUvoHWkUqH9Ro0pbDrcVBwpgW4y62Bsd/hNQBI9CsCvJFdRs2sGCF6m" +
       "ncRqdKKRu7Db6cgaR5FR1yKXt9UK2qg0Q2vQFaXpzIqTFtHS4JrY0ue4UNHg" +
       "EkNKs85QXAhlJREHTcTRqy6rK9QMcdXZQNedPs6W4CZfpHGMAhsV5jZV3lgg" +
       "LY+XLWRcHwdeFJGcYukdZdGlkAjRVrK9RAqctmk1VbxAhUHDSUv9rmPxaL8/" +
       "LInjeX2NmAavufU0nYuJrTTaKCoR/Y1UG+LWeios8DKDUmZsigonYvUIocub" +
       "uhHYtVprtiZNmWGM6aI0xXrTtpuCnbY1KfUrDrWGucqSrbUHYcVbSMKqYOsA" +
       "wIYsiCaiCYRsp2k/jDmcaU/7g3U8Afuk724knOwTaeQlFX9Q6ZFGb4XBrkHC" +
       "7HitLlGwh+LdBkIZI61eZI1KYtUxslW2EbhQEvoG15o6oicma4FYRh04WabK" +
       "uNQlDbjeZxB8s+yFg5VpVFrFcMHXjU6pDrZoetlMK1q7qfOLFkoqlYpLlOFq" +
       "I5UKpX5amyUdetLjHa5B1KLyqKCBQJbjaaiyG0VbVjR0alk1z09HEVrlTGSz" +
       "KDdJO+lMBXcYlXU/FQZ0RKllrGLwpopxHuO1izRaHdYKiDAtaGF/xia1AkMI" +
       "pVngYsggWoTVNpM6HjbRAmdKIEOATyzHSyU7xQXWrXVaAxev60jPGzmi4kxa" +
       "aNyT4Daj1HsF1OKUDul0qdhprtu+VanXVA6YRyLnVmO8GBortiEqHqUUNxwM" +
       "R40w0jlYrwlNpEFhms6U7Wk6Kk1Yx8ErPgj7gjGPU7NgaLUpXKiOjWG9Kysy" +
       "z08njMqKpls21oRX5EtI0xTauu5ik4ZfCZlKnEwdfSqSmEt0RB7WDb082TBL" +
       "d8jQaM+SzSQp0ggLT6rTujukyJZbrCjVrhtQy3J1aYqFCZHimq3H5dUE4yJV" +
       "m84Mr9pRWGw2mAk1y5LQqhLZwEIu0iOncziYANDusOmcrHocbJNEySoKrGnV" +
       "RFFfDCtyITbUUt0TashSHtVntcmgMqsW/JnoqTSJYi4OErZoXRy6RIFuEtNF" +
       "PUaQti9G/UFh6nd52TTpAYzG9a41WvabmNjUcc+kPJ0zlpN5mevMu2DOysSm" +
       "ysZESIqG6lbHNQWfzYpWWa/NRgUP1voIbMAFZlMwyx13HDfIsTSxlqySFsqW" +
       "UykMmxuvZMgTtzDqjYJ2o7dsNSaKE9J9yi35BghMcaL0qmm/EiTFjt9kVtFG" +
       "a3tiNaUlmOPj9mhOMzhWRqZ6Z4MtCMLifamidVS4sLYCMhaFGEsGPb6Bsb6K" +
       "RTEfDMlZLCXjBWvig2nT4ypoMC0sFr2+n3Q7lU0BtnuB2se1ZgyzPEh4lrGD" +
       "dtL5YqIx401TobiiYeOSWEtWI86Y1lrcyljIJaZaTeJIpyyLjcajEuqBpKPi" +
       "ihsb2STcwCT7wTgMEiJI27jIwsM0SUr1KjoU3PoKq3oDklULA7BDhj1EGsHm" +
       "iojmBQ1sxoaw4eN6vR2gS3+o1jcDLO4IsbAcl1tI3RUZwu5UNclvW2UinTS4" +
       "MTsoFAZjTZltLFMGKKCQNrfi2YButtOly3mIAeQelJJ4MJ6JEwN1nDRRGEYe" +
       "1OYaTDA8Q1h6ZSP3GKVjeYEGb2bdtYBPZlbPlVmHnXRCje7yaH1MU6bCJgiB" +
       "92d1ksBrc7QhLoaauFlh8wzOCoimRa1SoVqj5RodeZ5LzawJFWGyOmHitjZv" +
       "LyrdEA1CregKjYIndvzxGFNwppkUFpXNqh+q0xlnogKtF7BEGgu0UPMrfFBC" +
       "qrpOyjGK1TKI9fABU5GFRs1sp1WFk2zdItvcrKN3JkuqlijV8nIikUi5DCP0" +
       "oCk0DATXkzlOVpJ6HaW7w8KyWqh7sopPfZSTkGrdKruqNffNgunX2cEqWbV7" +
       "od6a1hHfF9yy6nUsgKajMQw2SQfpTlFe9dhYLntklXINkDfXKmWqD9ISclpl" +
       "kOo67MZVghpXe/7Ci9HU7fpqYzrHi5WgyLijFAV+v+7KNJwySWtMiKPhArzY" +
       "vfnN2Suf+YO9dd+THzAcXYOBl+2sY/gDvG1uux7NiieODnPyz4XTVyfHz1d3" +
       "h2lQ9gb94M1ut/K3548++/wLGvex0t7BIaQSQ7fHnv9jtr7U7WOs9gCnp25+" +
       "UsDkl3u7w7HPP/tPD/A/Pnv7D3A18PApOU+z/Djz4hc7b1DfvwfdcnRUdsO1" +
       "40mip08ekF0K9TgJXf7EMdmDJ4/nHwfPkweWffLs4/kzveBc7gXbtT91xnv8" +
       "nPitx9ZcjqFbLDfOaZ55hXPhZ7NiBdYlklPOVz1NP4vV+aVnaTu/Wp/0qzuP" +
       "/OrovPrq7riJW+phaB3wPdsVbzy1zRuSI+u9Jmt8AjydA+t1flDrEa9qPSD1" +
       "g2edsivy/iR365zD+1/Blh/Mil8EwWlF27syzrXXOelZNr2oeJ6ty+7OrM+9" +
       "2uHQiXPtGLrv7Mu57Kbh/hv+G7C9z1Y/9cLl2173wvgv8/upozvn22noNiOx" +
       "7eMHvsfqF/xQN6xcx9u3x79+/vXrMfTAze8OY+jCtpLL/mtbkt+IoXvPIInB" +
       "/AfV46N/M4Yu7UbH0J56ovvjwIoH3cDdQXm880XQBDqz6if9wxV+45n3KGsg" +
       "JfD8kQqwxHLNVi61F67OnYS7o4W6+moLdQwhHz+Ba/k/Ow4xKNn+t+O6+ukX" +
       "KPYdL9c+tr18U215s8m43EZDF7f3gEc49uhNuR3yukA++b27P3P7E4eYe/dW" +
       "4F18HJPt4bNvugjHj/O7qc3vv+533/RbL3wtPyP+H+xoBi1yIwAA");
}
