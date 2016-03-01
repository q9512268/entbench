package edu.umd.cs.findbugs.detect;
public class BuildObligationPolicyDatabase implements edu.umd.cs.findbugs.Detector2, edu.umd.cs.findbugs.NonReportingDetector {
    static class AuxilaryObligationPropertyDatabase extends edu.umd.cs.findbugs.ba.interproc.MethodPropertyDatabase<java.lang.String> {
        @java.lang.Override
        protected java.lang.String decodeProperty(java.lang.String propStr)
              throws edu.umd.cs.findbugs.ba.interproc.PropertyDatabaseFormatException {
            return propStr;
        }
        @java.lang.Override
        protected java.lang.String encodeProperty(java.lang.String property) {
            return property;
        }
        public AuxilaryObligationPropertyDatabase() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Za2wU1xW+Xj/wC68f2LwNmIXIBHZLEyCRaYpt7GCyfsQ2" +
                                                                  "VrEpy+zsXXvw7Mwwc9ceOyGFVC30BwQlkNCq8Y+KKEnFS1VRn0ldRUqggUqJ" +
                                                                  "UANNQ1O1P0ha1KC2yQ/atOfeO7vz2F07VFEs7ezsveece173O+den76FCg0d" +
                                                                  "1WOFBMmEho1gm0J6BN3AsVZZMIx+GIuIz+UL/9h9s+tBHyoaRBUjgtEpCgZu" +
                                                                  "l7AcMwbRUkkxiKCI2OjCOEY5enRsYH1MIJKqDKJayehIaLIkSqRTjWFKMCDo" +
                                                                  "YVQlEKJL0STBHZYAgpaGQZMQ0yTU7J1uCqNyUdUmbPIFDvJWxwylTNhrGQRV" +
                                                                  "hvcKY0IoSSQ5FJYM0mTq6F5NlSeGZZUEsUmCe+UNlgu2hzdkuKDhvP/jO8dG" +
                                                                  "KpkLagRFUQkzz+jFhiqP4VgY+e3RNhknjH3oCZQfRmUOYoIC4dSiIVg0BIum" +
                                                                  "rLWpQPu5WEkmWlVmDklJKtJEqhBBK9xCNEEXEpaYHqYzSCgmlu2MGaxdnraW" +
                                                                  "W5lh4ol7Q8ef2135o3zkH0R+Semj6oigBIFFBsGhOBHFutEci+HYIKpSINh9" +
                                                                  "WJcEWZq0Il1tSMOKQJIQ/pRb6GBSwzpb0/YVxBFs05MiUfW0eXGWUNavwrgs" +
                                                                  "DIOtdbat3MJ2Og4GlkqgmB4XIO8sloJRSYkRtMzLkbYx8AgQAOucBCYjanqp" +
                                                                  "AkWAAVTNU0QWlOFQH6SeMgykhSokoE7QopxCqa81QRwVhnGEZqSHrodPAVUJ" +
                                                                  "cwRlIajWS8YkQZQWeaLkiM+trs1HH1O2KT6UBzrHsChT/cuAqd7D1IvjWMew" +
                                                                  "Dzhj+Zrws0LdK4d9CAFxrYeY0/zk8dtb1tZPX+Q0i7PQdEf3YpFExFPRireW" +
                                                                  "tDY+mE/VKNZUQ6LBd1nOdlmPNdNkaoAwdWmJdDKYmpzufX3ngR/iv/pQaQcq" +
                                                                  "ElU5mYA8qhLVhCbJWH8YK1gXCI51oBKsxFrZfAeaA+9hScF8tDseNzDpQAUy" +
                                                                  "GypS2W9wURxEUBeVwrukxNXUuyaQEfZuagihMvigSvg8gvgf+yZIDY2oCRwS" +
                                                                  "REGRFDXUo6vUfiMEiBMF346E4pBM0eSwETJ0McRSB8eSoWQiFhINezKGCbCF" +
                                                                  "WpKSHOuOytIw2ys9KuDhxFaBCFFA0iDl1r74JU3qhZrxvDwI0BIvPMiws7ap" +
                                                                  "cgzrEfF4sqXt9tnImzz16Hax/EfQEGgQBA2CohFMaRDkGgRn1CDQnDQlWdAn" +
                                                                  "HAS6yqAiRYLy8phu86iyPHEg7KMAIIDg5Y19X9++53BDPmSsNl4AMaOkDa5K" +
                                                                  "1mqjTKo0RMRz1XMnV9xY/5oPFYRRtSCSpCDTwtSsDwPkiaMWKpRTDexSs9xR" +
                                                                  "amiN1FURLNdxrpJjSSlWx7BOxwma55CQKoR0y4dyl6Gs+qPpk+MHB77xJR/y" +
                                                                  "uasLXbIQgJGy99CakMb+gBdVssn1H7r58bln96s2vrjKVarKZnBSGxq82eN1" +
                                                                  "T0Rcs1y4EHllf4C5vQTwnwiwXwFa671ruOCrKVUKqC3FYHBc1ROCTKdSPi4l" +
                                                                  "I7o6bo+wtK6ij1qe4TSFPAqyKvKVPu35a7/94D7myVTB8Ts6hT5MmhwgR4VV" +
                                                                  "MzirsjOyX8cY6N472fPMiVuHhlg6AsXKbAsG6LMVwA2iAx781sV91/9449RV" +
                                                                  "XzqFkclMmPdf+MuDz6f0Q8fpAMel6lYLHJen0VGjC662VQKclGH/0ZwI7FAg" +
                                                                  "+6S4JERlTLfNv/2r1l/429FKHmUZRlJJsnZ2Afb4whZ04M3dn9QzMXkirdO2" +
                                                                  "22wyDv41tuRmXRcmqB7mwbeXfvcN4XkoIwDdhjSJGRojyw1UqfuZL0LseZ9n" +
                                                                  "biN9rDKcqe3ePY5+KiIeu/rR3IGPXr3NtHU3ZM5wdwpaE08eHgVYbAhZD1d1" +
                                                                  "oLN1Gn3ON0GH+V582iYYIyDs/umuXZXy9B1YdhCWFaFVMbp1QFTTlUEWdeGc" +
                                                                  "3//6tbo9b+UjXzsqlVUh1i6wfYZKIMGxMQJgbGpf3cL1GC+2yhYyUYaHMgZo" +
                                                                  "FJZlj29bQiMsIpM/nf/jzS9O3WDZqHEZi50CV7NnI32s5YBLUJHBukQz7TBG" +
                                                                  "XzqDw9xydbQ0V8fDurVTTx6finW/sJ73JdXuLqINmuQzv/vP5eDJ9y9lKU1F" +
                                                                  "VsdqL+ij67kqRCfrBG2Ueq/i6T//LDDccjfFgY7VzwL/9PcysGBNbrD3qvLG" +
                                                                  "kx8u6n9oZM9d4Pwyjy+9Il/uPH3p4dXi0z7W9nKIz2iX3UxNTq/CojqG/l6h" +
                                                                  "ZtKRuWy7rExHfyGN6j3w2WFFf4d3u3BAzpVOJZqu0tYBx+yMoomOqmaQ6YGJ" +
                                                                  "PKsZoL8XwMmPpT3t6oO8q2cqfG1mpi3ZupqoEGRnDtBRDHp7lXZalkibKWKN" +
                                                                  "Boktsos+HiWoAjwNOZBioaM72Uqb6KOXm9pk7ezy9M5Oa1Ntm9AN+aRLMexi" +
                                                                  "cYHBZ4IDOtCssfHOzOAJlqOFuwkefd2RJWq5hGUPAPMNWycxA/qzVn4YHAtd" +
                                                                  "Qm7HjuR0LB2Ofi4uNAlqmL2RTQXygf+3WQbcWpBxfudnTvHslL94/tSOdxhk" +
                                                                  "pc+F5QA+8aQsO/aucx8XaTqOS8yZ5bzkaexrEo66uZUETOUvzKAJzrKfoJos" +
                                                                  "LATWt16d1AcIKrWpCfKJrulvEjjd8WmC8uHpnPw2DMEkfT3EeiwbyilG9yWj" +
                                                                  "BmEPx6lZ3VVV9oOzfZgXkPosHA7io7/4+eDgPZUiJ27IQuw5Wr/0YrH4buL1" +
                                                                  "v3CGhVkYOF3tS6EjA+/svcywvJhGNI2gjsIBRcbRwVam9xJLy1r4rLb2Evsm" +
                                                                  "SPl8zotRIZTGNQv9vQmcOqF+wSuaGfXaG7E/dS0pVUd7qngAZqiuXsYj0tSV" +
                                                                  "3/zLf5AzNroY2YWaxerlu34t/8tlJPAUi2QB1ZTdwsD5waCU9KCY83KOyeId" +
                                                                  "ZgV9HDFTwLBp1nqT3UuU/QQ93mQ6KSKatf3zGssffZ+buGIW30TEjkSk78L1" +
                                                                  "QxtZK+Ufk+DQw+9z+RVqnesKNXUMb3JdLWb1XkS8ee7IxRUfDtSwOyPuKKr5" +
                                                                  "AyYvQZstEM5jIOxD/Ci/2GWTpQc7hkTEy2ulTcV/uPoyN21VDtPcPI9//9Mr" +
                                                                  "H+y/cSkfFUEfQ3FS0DH0OQQFc13KOgUE+uFtK3BBR1TBuaGZYJlhZUB1ejR9" +
                                                                  "/CVoXS7Z9JY5yyUCNP7jWG9Rk0qMig142q+kpjlnWS7500Cxjnpxgxco6OxR" +
                                                                  "Vq+eMp+Ac95n8FbaWEsOqmaOrrAbEdp7OycBHGpaw819fZH+nT1tkYHm3o7m" +
                                                                  "lnAbS1ANJotTqZulL+NXiyav/VkOHs4GzZXrqWuUiLj1O/5fHqvOb4ci2IGK" +
                                                                  "k4q0L4k7Ym7nzYHEc8CufR9rd7KV9LHOpKdtgvLWwDHIzMvUh3UXtWbuBsJ7" +
                                                                  "xlmZc4N0JvmNfUQ8N7W967HbG1/glxGQSJOTVl7N4Vce6S5/RU5pKVlF2xrv" +
                                                                  "VJwvWeWz+iXXZYhTN9bEgFvZDcIizzHdCKRP69dPbX71yuGitwEahlCeALEe" +
                                                                  "ctyW8/jBWT8JcD0UzoxPKq2aGr838dDa+N/fZWdMK55LctNHxMFnrnWcH/1k" +
                                                                  "C7sgLgRkxOYgKpWMrRNKLxbHdFews2/Lua5tCf1axhX97NsQ0qXMHnH94yD7" +
                                                                  "zqQM9oijqp/mGcYLeH4k3Klp1t2O758a26RnsvXEZxjzr9grfUz/D+ST4ye6" +
                                                                  "GwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16e8zryHUf73d37+7eXe/dvetXtvZ6d31tdy3no6gXJdw0" +
           "WYoiRYqkKJKiHnTia4oPiRLfD5FUvIltIFmjqR9t14lb2PuX3aSGExtFjQQo" +
           "XGwQtLZjJ0ACI4kDxA6CAHWSGogRJCnqNumQ+t734WxbRIBGo5k5Z845c+Y3" +
           "h3P4ue9C90chVPE9O1/aXnxoZPHh2m4exrlvRIcDtjlSw8jQcVuNojFou6U9" +
           "+4Vrf/P9j60eO4CuKNATqut6sRpbnhuJRuTZW0NnoWunrYRtOFEMPcau1a0K" +
           "J7Flw6wVxTdZ6OEzpDF0gz0WAQYiwEAEuBQBxk5HAaLXGG7i4AWF6sZRAP0U" +
           "dImFrvhaIV4MPXOeia+GqnPEZlRqADg8WPyfAKVK4iyEnj7Rfa/zbQp/vAK/" +
           "9Avveew/XIauKdA1y5UKcTQgRAwmUaBHHMNZGGGE6bqhK9DjrmHokhFaqm3t" +
           "SrkV6HpkLV01TkLjxEhFY+IbYTnnqeUe0QrdwkSLvfBEPdMybP343/2mrS6B" +
           "rq8/1XWvIVm0AwWvWkCw0FQ145jkvo3l6jH0losUJzreYMAAQPqAY8Qr72Sq" +
           "+1wVNEDX92tnq+4SluLQcpdg6P1eAmaJoSfvyrSwta9qG3Vp3IqhN14cN9p3" +
           "gVEPlYYoSGLodReHlZzAKj15YZXOrM93hz/ykZ90KfeglFk3NLuQ/0FA9NQF" +
           "ItEwjdBwNWNP+Mg72Z9XX/+lDx1AEBj8uguD92N+9X3fe/5dT73ylf2Yf3KH" +
           "MfxibWjxLe3Ti0d/5034c53LhRgP+l5kFYt/TvPS/UdHPTczH+y8159wLDoP" +
           "jztfEf/r/P2fNf7iALpKQ1c0z04c4EePa57jW7YR9g3XCNXY0GnoIcPV8bKf" +
           "hh4AddZyjX0rb5qREdPQfXbZdMUr/wMTmYBFYaIHQN1yTe+47qvxqqxnPgRB" +
           "D4Mv9Bj4MtD+U/7GkAevPMeAVU11LdeDR6FX6B/BhhsvgG1XsAmcaZEsIzgK" +
           "Nbh0HUNP4MTRYS067dSNGJDB3cSydX5hW8tyr4w829LynhqrCzUyDgtq/x9/" +
           "yqywwmPppUtggd50ER5ssLMoz9aN8Jb2UtIlvvcrt752cLJdjuwXQ+8GEhwC" +
           "CQ616PBYgsO9BIf3lOAGlmSWrYb5mQGhV0LF8RDo0qVSttcWwu4dByz7BgAI" +
           "gNZHnpN+YvDeDz17GXisn94H1qwYCt8d4fFTyKFLYNWA30OvfCL9wOSnqwfQ" +
           "wXmoLhQETVcL8lEBsCdAeuPiFr0T32svfudvPv/zL3inm/Uc9h9hyO2UBQY8" +
           "e3EpQk8DVg6NU/bvfFr94q0vvXDjALoPAAsA01gFzg9w6qmLc5zDgpvHuFro" +
           "cj9Q2PRCR7WLrmMwvBqvQi89bSl95NGy/jiw8buho+Lcbil6n/CL8rV7nyoW" +
           "7YIWJW7/M8n/1B/89p/VS3MfQ/y1M4emZMQ3z8BKwexaCSCPn/rAODQMMO6P" +
           "PjH61x//7ovvLh0AjHjrnSa8UZQ4gBOwhMDMP/OV4Jvf/tanv3Fw6jQxOFcT" +
           "4IJatlfy78HnEvj+XfEtlCsa9pBwHT/CpadPgMkvZn77qWwAomzg+oUH3ZBd" +
           "x9Mt01IXtlF47P+69jbki//9I4/tfcIGLccu9a4fzOC0/Ye60Pu/9p6/fapk" +
           "c0krjshT+50O2+PuE6ecsTBU80KO7AO/++Z/82X1UwDBAWpG1s4ogRAq7QGV" +
           "C1gtbVEpS/hCX60o3hKd3Qjn99qZUOaW9rFv/OVrJn/5n79XSns+Fjq77pzq" +
           "39y7WlE8nQH2b7i46yk1WoFxjVeGP/6Y/cr3AUcFcNRAABDxIcCp7JyXHI2+" +
           "/4E//PXfeP17f+cydEBCV21P1Um13HDQQ8DTjWgFIC7zf+z5vTenDx4dBlAG" +
           "3ab83kHeWP67DAR87u5YQxahzOl2feP/5O3FB//kf9xmhBJl7nCCX6BX4M99" +
           "8kn8R/+ipD/d7gX1U9nt2A3CvlPa2medvz549sp/OYAeUKDHtKOYcqLaSbGJ" +
           "FBBHRceBJog7z/Wfj4n2AcDNEzh700WoOTPtRaA5PTNAvRhd1K+eLvhz2SWw" +
           "Ee+vHaKH1eL/8yXhM2V5oyjesbd6Uf2nYMdGZWwKKMCRo9oln+di4DG2duN4" +
           "j05ArApMfGNtoyWb14HovPSOQpnDfYC3x6qirO+lKOutu3rDzWNZweo/esqM" +
           "9UCs+HN/+rGvf/St3wZLNIDu3xbmAytzZsZhUoTPP/u5j7/54Zf++OdKAALo" +
           "Iz23+KvnC67MvTQuil5REMeqPlmoKnlJqBmsGsVciROGXmp7T88chZYDoHV7" +
           "FBvCL1z/9uaT3/nlfdx30Q0vDDY+9NI///vDj7x0cCbafuttAe9Zmn3EXQr9" +
           "miMLh9Az95qlpCD/2+df+E+/9MKLe6mun48dCfBo9Mu/97+/fviJP/7qHQKS" +
           "+2zv/2Fh40f/BdWIaOz4wyKKWktlJJtWZms4xVtts8amQ4ee0V1KYYkcF9W5" +
           "H6N9PDcjoTYJCT+v7KLZbJuiXJpqHc3g8z45wevVbirYmyEetOcVhiFcUkIm" +
           "olu1dVEOlks5GMjYcCggPDKqrlSEwWu5AKsxbxo8ut3VyCo6IYkINXbR1jA0" +
           "A0HrfEU3XLRF4suqjkx5sss5xMpDlk510OoO61g0URSOzip9OqF3FZmFO6tO" +
           "VIm7VO6pYldeL2PCx5dKYqOYxqULUd5sMovB6Rq/xnli3jRcMZpTCEcPmKDH" +
           "DNTcWNEqS2+kQByvpyTD4T1vPhFsghmwVWkMzDHHlr7aFxROqOZjGR0gCR4M" +
           "c1mXncWIJnvbwTRLc3s8XIV9QZysthozr9KeJAlNcjDnqs44aJHNoS0ZfUWR" +
           "iUh2cKMiD+1lUlvt9E3C9FbbEbzm23qf8TesuhRJWdjsdpU1ubKCUWOynFeM" +
           "ujhcbdw1VfdwRTBFR+bnHo03dMmiJ8tql06ckJ36wihpTomNM7UnTm9jD5h4" +
           "QASrbpfpZPiQIGaEr86pYL6T8KVjJzWur2a6G6rTadNeNTwbFdqGWUPqTa++" +
           "21BVsSIZzrrlWcsuTZLdqL/iuxSZxIRmVag5zfgSPVx1pgONmCpBlbaRWOJ4" +
           "RhjQAuyLi1a/K6U7f1GF55OsS0bVJmfJ5rRqzPpTeahu03AZ9Wg+1hdqXOcG" +
           "NX7Z6NubYOl0GzOab0e2NxCl+UaMuR27WcyzNrYUMD7Ruvh8rbqBj22mGDYZ" +
           "D+WqMLV5UqBaksEt881K8jYegQqen+GB2kYEMZ2s3D6hBBIVevoIm8gDLRVt" +
           "Wl1PpfZ8IyjC1FDZjcVV4jBCKArha8y4JXd3IRXhqzGsJVigoz2E3q6nnJH2" +
           "dqt1RQnTqMrqTEPv4BiZhXNjXoV3m7YeL5BYGc0qQtVCR4JOmPW5TxIZORKt" +
           "0JjGvXnFIeAJM1RkocV2dcTlddsZDfXhRvWwVJ86A73HzB1/l5izursUYWsL" +
           "+4IqaAFhy01njrWDFTtZ4YvBlGrPGWQ5w+km4nWZKCNDxcQMFat0VpJGtuNe" +
           "ZAx3PV/A5Lyf+1Jt2kllMSPkrjFJw2STDWdykqsCYSqJurRW3NZaSttle7ld" +
           "mpVcoXvzmoeLqSQSfZHszWSvtZVNiyOsLkfWGy2i4Xe5qiGlxHhQ5TRR6rYN" +
           "yZsKFrmih8aO6eMLnJz6jETxCZ/HdFrLow6T9FYZqXZxksSqVs9GQrQxkOvB" +
           "SgmzbS+lgSNvR5yVRqjqa8tdSJhkIwpmcSd2aWe3Q1qUmsGEKRD9pdDFari3" +
           "IjlV7G36S9FF8J7g9gR7qmMuhUmtPMAscc7mbX+VtFtWPqKIJcpwGE33ls05" +
           "0pl1KpVmvdsbOVI0tBsYp/KbntpkECdYjxmvKnLiDplx7qSTzeGmNyLnohhL" +
           "uOTjvXEaS1EvHW0slZsyvjjuGZkUdTJRdawhQsoiO9Sz0B+sJcmeZmiXz1JH" +
           "bTZxgfHEat7Qc7vVjyrByN9UOKqLotlAhPNEjdjZghaWg37e6eDqhltUll19" +
           "EkUuQqFhs72w3U4rqm3DNQNCEkZxu1I/C9o1Y4iMq6IWIXmDoGzbbODNrTBO" +
           "3dRKZymptlAkTHg8ZCYyE+B1ck51NUTk8TGjSyOrYdOo11p4lTRmWtYaCYzG" +
           "WCJHWJAzW2YySupNFYU7jR7q5JNxtz2OWqtxk3NW6VJsTCbczgqjNZ/P2tq8" +
           "NWygNROs3iShVvayhUUzZoFF/RbLTVKsZmEZ2kaiSQcB7BodcTLbBeRGszln" +
           "pJsVLuntWmZVaJs+xhl2y56z1MBwq5P+Gm+1ahOB0ew+BVeVlEZJbFlpSY0B" +
           "Idpj1hxu4VqI2HCj1iEZypEV0R4MIlepYeaika6UaoOr625H2HGzjRXqfK1W" +
           "S/PetoHEiejMRM0JuqiTLoyZudWGjdnGo9OevlpLg77orfMUkQMzUdgqGxlK" +
           "x11Yw07YY7TAqBujebPCWLSRwKFYp/ujWVgfxpRcV7hmqqe+SlTbBrWczBfY" +
           "SukhOuKxQ6Tv1vlhtU9VJs12zZrP6bwXwYmTzJRZ3ukic32FT0mVnHALHxHI" +
           "8diWialu9LU6DLfihddZVOT1bBcF9kReIVYrNecKQ3P9jBMGy0XfN+sai/Tx" +
           "Si1fzXN5rlLcUvHIgWKva52FYHER7XOwa8LrndTh69OeElCEYjWr+AQdunS9" +
           "FjXnXVYeUN1kI+zQcbcP1qiXdrJcXwjVSdvsJeFkPM5aIDqdwtEArQ/0WcIG" +
           "9NBJhN0W3o6aRm/QyTs2IyPkJNIDtmKtW+gmEHEz7PZrshHAVmsMw2yvp2lr" +
           "k1zO0ckuBUf4SMujfne4CHv1YMv2N1k7abkdT+E6emOU5uu80qFtOBlRdb+h" +
           "z6zqDp12XIbe1axZXc6G4wA8Ia6DPmy3VkrMiMk0R0Mio8y8P2yt62ltSpJm" +
           "Q68n9S628yf8QAmSajzvZpWc8zyHDxxVaM37gxETKR7bnqXAK/1xPW55fDuo" +
           "aYHZR0D0XVcSP/AAHLq9uCv2KB+1Z4pqb6wFM2WGXW8TR15Uoayph63TIa90" +
           "LU/l0JocLFoMP3M6/gbEOXmHa/IqMoydDjasqCLLGZmlgU2pNOgeH+NRZFL8" +
           "jscGdsCTSboxTL0mDqZBc9WXR9iIG05zLcPgYDdxG3MKi3XBQal1IlbZbo03" +
           "rUYyxOzAYWviWJjlAMnrU2GhTf1uZia6O95Skc12GnAs8Xq22vhahWwKWKWt" +
           "ChEPq4mWtWfqOOCldq40F7uNCoJ9wmu1EhC3jHl5u2OwwS5kTG/gRSw2nsZI" +
           "S0cwjWbCqY+bzCBM7C2xXuvtqYO3E8p3R2mtxxEbc1wnDCtd5Jbd7+TTddch" +
           "RlnLVuqTyaTj8TtTWc42Iy+iMNTyULhRMXrLkSJbgxpKC0nanIZwdR5SjUXC" +
           "Its63l9NNnOerMdSi1hjFTjaanm6Haz6Q7q2XEd0V9QW4NRXnU42YHMkbITs" +
           "okZsI0ca2e2dF4u0Mu4PhW1nKzgaH5CVVErUvjlT+ygB61LVn8g6GrhLTAms" +
           "ZBbN19VYmtThHWs2sd0w9Oa1+VTNjNBO6o0Ybsf2YITJVk3oIspYT6NeM1Vx" +
           "ucPg83ad4XOD1pXlpEP1yHHKdn3EDcZ1OZFhQejUHaHFSIwam/VdH6y8qVQW" +
           "SZ+e1qtjYr2RNmibRYQsVpiKbG4qPSGtdHYVcRK4RsSA45tbgB3IThfIbCO1" +
           "DQOlM1E2e7GU8vkoYZiwieXzraBEMcE11zSf9WDcgmv96dgXNHS1GRN5LbHH" +
           "2gRsLC8f1pBJLx5pI7oDwx0upCo5rEkbk5TBgVsnpWqPqvKCQGoIUGopE5WE" +
           "jJl6tysi4y6wnjIf2CtF7iLGWuzA+MSbSajSGcybeS7jwxG6nvY74qYacNYS" +
           "adSCysZf2+5UQpvVKp6tXT9bZprX4jOgXcXg/AqmdZpum1yoUyIq9icfhtiC" +
           "0H2Uz7Uu1ffVtI10TIWquGMk3swpp+6hju1iCwnBhgMvHgfgEYCtDGdWrm7h" +
           "yYanokZ/p8zCYJrIFrtGeLhpUsGWXzQ0q0b3mU0jqLKNDTp3UHc3pwitjSem" +
           "2Al1lJl0WIr3GT1ebtlp2qPoHbeVV3V5Fk8XSRcAYWY7itYYVgdbZ2jKQnsI" +
           "4KmFUos+Ai/trC9IA348sdFhY6IZLakJi3LTZyY2WcvC7WSQbqfGdFexZjNl" +
           "vhoPOwtiSW6VnkZbux2l44w4anX00WKGInnSt+KUUFc2bmAsYWhxPm3D6+50" +
           "3B5ovaq887IRE9TUftiut/WeWhnCpjLVOabZZLV4SGUc6YbuVKNgZIOj0ZJd" +
           "ipuMny8Zf8qF4pBhswWlk0Ya1WA2UZsxbiJqtpp10GEkVIMZR7lUp5H30F0g" +
           "cB3PWgc+7PS1OWtQjU2dsX0krvFos63WWqIbbWeEkq13YWcZmvIO7lWkcSM3" +
           "Wv0Uw4rH0h9/dTcDj5eXICcpr7WNFh39V/FEnN15wkvlXNnJVXB5KXb1HlfB" +
           "Z67LoOK5/813y22Vz/yf/uBLL+v8Z5CDo2vGaQxdOUo5nvI5AGzeeffLDa7M" +
           "653efX35g3/+5PhHV+99Fbf7b7kg5EWW/5773Ff7b9f+1QF0+eQm7LaM43mi" +
           "m+fvv66GRpyE7vjcLdibT8z6Q4W53gG+8pFZ5TvfsN95jWLoIT/0iuyLoe89" +
           "4sJN7qXTteyXA+I7Dzi+M3v+TvmdhXpYZl/BVNrhxawNWeQUYiLTDL+wdTnJ" +
           "tijcGHoUGMzTjWOSUopTp/TOO+UjJ055Is310/s0fmuEoaUb9/Dj269wy4bN" +
           "7bZWj2ytvhpbF9XwH2bkn7nHffqLRfF+YBvDvYdtPnBX2xTN73tVVshi6Nkf" +
           "nH07tnn7/zbDB/bqG2976WCfKNd+5eVrD77hZfn3ywTWSTL7IRZ60Exs++xt" +
           "8Zn6FT80TKs02kP7u2O//PmXMfTk3YUEOLKvlAp9bE/yUgw9cQeSGMx/VD07" +
           "+hdi6Orp6Bg60M51/9sYeuCoO4Yug/Js56dAE+gsqi/794YvKVlE8ZmM/4et" +
           "l3/rN//62gf216DnL3XLlz6OSC/SffMPLtcejm98tIS9+4qlKGZ/kIXuj4qR" +
           "MfT03V8gKXntb2wfPtknpSu9DnzffrRPyt8Ycv//JKwXKnwCJ0fYedEZj1Pk" +
           "/8gzZsebAP2BMHhnLgX5vzt3533nVb+l0c4t6YvffLFVXmlf21qRBSB8fPQS" +
           "z/kk32kS/Oa5F3vu6Be3tO98/sNfeebPJ0+Ub2zsXaAQq5H5pXboEWpcKlHj" +
           "ANon0t92F4GPJCpzkre0933y737rz1741lcvQ1fAwVZsYzU0wMEXQ4d3e9Hp" +
           "LIMbY1DrASpwRD66p7bcZenJRx57/aT1JAseQz98N95lfuNCsrx4Vcj2UiPs" +
           "eomrF2yfunAeJ75/trf0/UdOfP+HC9s0L/p+0fvp8oz4TPZTIfSuf4C1TpQ9" +
           "4gNdL7f1mTxSkdk42wn8/QmcxSTp1ng+Im5NMJHGuixR+pQPOh889rY7JLj2" +
           "2bpsfwSdzVwC+L90PjI7OWOu/6A0yZlg7q139Tou2b+Edkv7/MuD4U9+r/WZ" +
           "fbYfrONud7SsD+xfPDiJup65K7djXleo577/6BceettxePjoXuDT8/mMbG+5" +
           "czqdcPy4TIDvfu0N//FHfvHlb5VJuP8DsVUOyxsoAAA=");
    }
    public static final boolean INFER_CLOSE_METHODS =
      edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "oa.inferclose",
        true);
    private static final boolean DEBUG_ANNOTATIONS =
      edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "oa.debug.annotations");
    private static final boolean DUMP_DB =
      edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "oa.dumpdb");
    private final edu.umd.cs.findbugs.BugReporter
      reporter;
    private final edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase
      database;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor
      willClose;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor
      willNotClose;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor
      willCloseWhenClosed;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor
      cleanupObligation;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor
      createsObligation;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor
      dischargesObligation;
    private boolean sawAnnotationsInApplicationCode;
    public BuildObligationPolicyDatabase(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          reporter =
          bugReporter;
        final edu.umd.cs.findbugs.classfile.DescriptorFactory instance =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            );
        this.
          willClose =
          instance.
            getClassDescriptor(
              javax.annotation.WillClose.class);
        this.
          willNotClose =
          instance.
            getClassDescriptor(
              javax.annotation.WillNotClose.class);
        this.
          willCloseWhenClosed =
          instance.
            getClassDescriptor(
              javax.annotation.WillCloseWhenClosed.class);
        this.
          cleanupObligation =
          instance.
            getClassDescriptor(
              edu.umd.cs.findbugs.annotations.CleanupObligation.class);
        this.
          createsObligation =
          instance.
            getClassDescriptor(
              edu.umd.cs.findbugs.annotations.CreatesObligation.class);
        this.
          dischargesObligation =
          instance.
            getClassDescriptor(
              edu.umd.cs.findbugs.annotations.DischargesObligation.class);
        database =
          new edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase(
            );
        addBuiltInPolicies(
          );
        java.net.URL u =
          edu.umd.cs.findbugs.DetectorFactoryCollection.
          getCoreResource(
            "obligationPolicy.db");
        try {
            if (u !=
                  null) {
                edu.umd.cs.findbugs.detect.BuildObligationPolicyDatabase.AuxilaryObligationPropertyDatabase db =
                  new edu.umd.cs.findbugs.detect.BuildObligationPolicyDatabase.AuxilaryObligationPropertyDatabase(
                  );
                db.
                  read(
                    u.
                      openStream(
                        ));
                for (java.util.Map.Entry<edu.umd.cs.findbugs.classfile.MethodDescriptor,java.lang.String> e
                      :
                      db.
                       entrySet(
                         )) {
                    java.lang.String[] v =
                      e.
                      getValue(
                        ).
                      split(
                        ",");
                    edu.umd.cs.findbugs.ba.obl.Obligation obligation =
                      database.
                      getFactory(
                        ).
                      getObligationByName(
                        v[2]);
                    if (obligation ==
                          null) {
                        obligation =
                          database.
                            getFactory(
                              ).
                            addObligation(
                              v[2]);
                    }
                    database.
                      addEntry(
                        new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                          e.
                            getKey(
                              ),
                          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                            valueOf(
                              v[0]),
                          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                            valueOf(
                              v[1]),
                          obligation));
                }
            }
        }
        catch (java.lang.Exception e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Unable to read " +
                u,
                e);
        }
        scanForResourceTypes(
          );
        edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          eagerlyPutDatabase(
            edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase.class,
            database);
    }
    @java.lang.Override
    public void visitClass(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        edu.umd.cs.findbugs.ba.XClass xclass =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getClassAnalysis(
            edu.umd.cs.findbugs.ba.XClass.class,
            classDescriptor);
        edu.umd.cs.findbugs.ba.obl.Obligation thisClassObligation =
          database.
          getFactory(
            ).
          getObligationByType(
            xclass.
              getClassDescriptor(
                ));
        for (edu.umd.cs.findbugs.ba.XMethod xmethod
              :
              xclass.
               getXMethods(
                 )) {
            if (thisClassObligation !=
                  null) {
                if (xmethod.
                      getAnnotation(
                        createsObligation) !=
                      null) {
                    database.
                      addEntry(
                        new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                          xmethod,
                          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                            ADD,
                          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                            STRONG,
                          thisClassObligation));
                }
                if (xmethod.
                      getAnnotation(
                        dischargesObligation) !=
                      null) {
                    database.
                      addEntry(
                        new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                          xmethod,
                          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                            DEL,
                          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                            STRONG,
                          thisClassObligation));
                }
            }
            addObligations(
              xmethod);
        }
    }
    public void addObligations(edu.umd.cs.findbugs.ba.XMethod xmethod) {
        edu.umd.cs.findbugs.ba.obl.Obligation[] paramObligationTypes =
          database.
          getFactory(
            ).
          getParameterObligationTypes(
            xmethod);
        boolean methodHasCloseInName =
          false;
        if (INFER_CLOSE_METHODS) {
            edu.umd.cs.findbugs.util.SplitCamelCaseIdentifier splitter =
              new edu.umd.cs.findbugs.util.SplitCamelCaseIdentifier(
              xmethod.
                getName(
                  ));
            methodHasCloseInName =
              splitter.
                split(
                  ).
                contains(
                  "close");
        }
        for (int i =
               0;
             i <
               xmethod.
               getNumParams(
                 );
             i++) {
            edu.umd.cs.findbugs.ba.obl.Obligation obligationType =
              paramObligationTypes[i];
            if (obligationType !=
                  null) {
                if (xmethod.
                      getParameterAnnotation(
                        i,
                        willCloseWhenClosed) !=
                      null) {
                    handleWillCloseWhenClosed(
                      xmethod,
                      obligationType);
                }
                else
                    if (xmethod.
                          getParameterAnnotation(
                            i,
                            willClose) !=
                          null) {
                        addParameterDeletesObligationDatabaseEntry(
                          xmethod,
                          obligationType,
                          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                            STRONG);
                        sawAnnotationsInApplicationCode =
                          true;
                    }
                    else
                        if (xmethod.
                              getParameterAnnotation(
                                i,
                                willNotClose) !=
                              null) {
                            sawAnnotationsInApplicationCode =
                              true;
                        }
                        else
                            if (INFER_CLOSE_METHODS &&
                                  methodHasCloseInName) {
                                addParameterDeletesObligationDatabaseEntry(
                                  xmethod,
                                  obligationType,
                                  edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                    STRONG);
                            }
                            else {
                                if ("<init>".
                                      equals(
                                        xmethod.
                                          getName(
                                            )) ||
                                      xmethod.
                                      isStatic(
                                        ) ||
                                      xmethod.
                                      getName(
                                        ).
                                      toLowerCase(
                                        ).
                                      indexOf(
                                        "close") >=
                                      0 ||
                                      xmethod.
                                      getSignature(
                                        ).
                                      toLowerCase(
                                        ).
                                      indexOf(
                                        "Closeable") >=
                                      0) {
                                    addParameterDeletesObligationDatabaseEntry(
                                      xmethod,
                                      obligationType,
                                      edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                        WEAK);
                                }
                            }
            }
        }
    }
    @java.lang.Override
    public void finishPass() { database.setStrictChecking(
                                          sawAnnotationsInApplicationCode);
                               if (DUMP_DB ||
                                     edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase.
                                       DEBUG) {
                                   java.lang.System.
                                     out.
                                     println(
                                       "======= Completed ObligationPolicyDatabase ======= ");
                                   java.lang.System.
                                     out.
                                     println(
                                       "Strict checking is " +
                                       (database.
                                          isStrictChecking(
                                            )
                                          ? "ENABLED"
                                          : "disabled"));
                                   for (edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry entry
                                         :
                                         database.
                                          getEntries(
                                            )) {
                                       java.lang.System.
                                         out.
                                         println(
                                           "  * " +
                                           entry);
                                   }
                                   java.lang.System.
                                     out.
                                     println(
                                       "================================================== ");
                               } }
    @java.lang.Override
    public java.lang.String getDetectorClassName() {
        return this.
          getClass(
            ).
          getName(
            );
    }
    private void addBuiltInPolicies() { addFileStreamEntries(
                                          "InputStream");
                                        addFileStreamEntries(
                                          "OutputStream");
                                        addFileStreamEntries(
                                          "Reader");
                                        addFileStreamEntries(
                                          "Writer");
                                        edu.umd.cs.findbugs.ba.obl.Obligation javaIoInputStreamObligation =
                                          database.
                                          getFactory(
                                            ).
                                          getObligationByName(
                                            "java.io.InputStream");
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.lang.Class")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "getResourceAsStream"),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "(Ljava/lang/String;)Ljava/io/InputStream;"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                ADD,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              javaIoInputStreamObligation));
                                        edu.umd.cs.findbugs.ba.obl.Obligation javaIoOutputStreamObligation =
                                          database.
                                          getFactory(
                                            ).
                                          getObligationByName(
                                            "java.io.OutputStream");
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.util.logging.StreamHandler")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "setOutputStream"),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "(Ljava/io/OutputStream;)V"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                DEL,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              javaIoOutputStreamObligation));
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.io.FileOutputStream")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "getChannel"),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "()Ljava/nio/channels/FileChannel;"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                DEL,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              javaIoOutputStreamObligation));
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.io.FileInputStream")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "getChannel"),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "()Ljava/nio/channels/FileChannel;"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                DEL,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              javaIoInputStreamObligation));
                                        edu.umd.cs.findbugs.ba.obl.Obligation connection =
                                          database.
                                          getFactory(
                                            ).
                                          addObligation(
                                            "java.sql.Connection");
                                        edu.umd.cs.findbugs.ba.obl.Obligation statement =
                                          database.
                                          getFactory(
                                            ).
                                          addObligation(
                                            "java.sql.Statement");
                                        edu.umd.cs.findbugs.ba.obl.Obligation resultSet =
                                          database.
                                          getFactory(
                                            ).
                                          addObligation(
                                            "java.sql.ResultSet");
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.sql.DriverManager")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "getConnection"),
                                              new edu.umd.cs.findbugs.util.RegexStringMatcher(
                                                "^.*\\)Ljava/sql/Connection;$"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                ADD,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              connection));
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.sql.Connection")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "createStatement"),
                                              new edu.umd.cs.findbugs.util.RegexStringMatcher(
                                                "^.*\\)Ljava/sql/Statement;$"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                ADD,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              statement));
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.sql.Connection")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "prepareStatement"),
                                              new edu.umd.cs.findbugs.util.RegexStringMatcher(
                                                "^.*\\)Ljava/sql/PreparedStatement;$"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                ADD,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              statement));
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.sql.Statement")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "executeQuery"),
                                              new edu.umd.cs.findbugs.util.RegexStringMatcher(
                                                "^.*\\)Ljava/sql/ResultSet;$"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                ADD,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              resultSet));
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.sql.Connection")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "close"),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "()V"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                DEL,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              connection));
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.sql.Statement")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "close"),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "()V"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                DEL,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              statement,
                                              resultSet));
                                        database.
                                          addEntry(
                                            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
                                              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                                                edu.umd.cs.findbugs.bcel.BCELUtil.
                                                  getObjectTypeInstance(
                                                    "java.sql.ResultSet")),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "close"),
                                              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                                                "()V"),
                                              false,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                DEL,
                                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                                                STRONG,
                                              resultSet));
    }
    private void addFileStreamEntries(java.lang.String kind) {
        edu.umd.cs.findbugs.ba.obl.Obligation obligation =
          database.
          getFactory(
            ).
          addObligation(
            "java.io." +
            kind);
        database.
          addEntry(
            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                edu.umd.cs.findbugs.bcel.BCELUtil.
                  getObjectTypeInstance(
                    "java.io.File" +
                    kind)),
              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                "<init>"),
              new edu.umd.cs.findbugs.util.RegexStringMatcher(
                ".*"),
              false,
              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                ADD,
              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                STRONG,
              obligation));
        database.
          addEntry(
            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
              new edu.umd.cs.findbugs.util.SubtypeTypeMatcher(
                edu.umd.cs.findbugs.bcel.BCELUtil.
                  getObjectTypeInstance(
                    "java.io." +
                    kind)),
              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                "close"),
              new edu.umd.cs.findbugs.util.ExactStringMatcher(
                "()V"),
              false,
              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                DEL,
              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                STRONG,
              obligation));
    }
    private void addParameterDeletesObligationDatabaseEntry(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                                            edu.umd.cs.findbugs.ba.obl.Obligation obligation,
                                                            edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType entryType) {
        edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry entry =
          database.
          addParameterDeletesObligationDatabaseEntry(
            xmethod,
            obligation,
            entryType);
        if (DEBUG_ANNOTATIONS) {
            java.lang.System.
              out.
              println(
                "Added entry: " +
                entry);
        }
    }
    private void handleWillCloseWhenClosed(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                           edu.umd.cs.findbugs.ba.obl.Obligation deletedObligation) {
        if (deletedObligation ==
              null) {
            if (DEBUG_ANNOTATIONS) {
                java.lang.System.
                  out.
                  println(
                    "Method " +
                    xmethod.
                      toString(
                        ) +
                    " is marked @WillCloseWhenClosed, " +
                    "but its parameter is not an obligation");
            }
            return;
        }
        edu.umd.cs.findbugs.ba.obl.Obligation createdObligation =
          null;
        if ("<init>".
              equals(
                xmethod.
                  getName(
                    ))) {
            createdObligation =
              database.
                getFactory(
                  ).
                getObligationByType(
                  xmethod.
                    getClassDescriptor(
                      ));
        }
        else {
            org.apache.bcel.generic.Type returnType =
              org.apache.bcel.generic.Type.
              getReturnType(
                xmethod.
                  getSignature(
                    ));
            if (returnType instanceof org.apache.bcel.generic.ObjectType) {
                try {
                    createdObligation =
                      database.
                        getFactory(
                          ).
                        getObligationByType(
                          (org.apache.bcel.generic.ObjectType)
                            returnType);
                }
                catch (java.lang.ClassNotFoundException e) {
                    reporter.
                      reportMissingClass(
                        e);
                    return;
                }
            }
        }
        if (createdObligation ==
              null) {
            if (DEBUG_ANNOTATIONS) {
                java.lang.System.
                  out.
                  println(
                    "Method " +
                    xmethod.
                      toString(
                        ) +
                    " is marked @WillCloseWhenClosed, " +
                    "but its return type is not an obligation");
            }
            return;
        }
        database.
          addEntry(
            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
              xmethod,
              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                DEL,
              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                STRONG,
              deletedObligation));
        database.
          addEntry(
            new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
              xmethod,
              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                ADD,
              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                STRONG,
              createdObligation));
    }
    private void scanForResourceTypes() {
        edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getDatabase(
            edu.umd.cs.findbugs.ba.ch.Subtypes2.class);
        java.util.Collection<edu.umd.cs.findbugs.ba.XClass> knownClasses =
          subtypes2.
          getXClassCollection(
            );
        for (edu.umd.cs.findbugs.ba.XClass xclass
              :
              knownClasses) {
            if (xclass.
                  getAnnotation(
                    cleanupObligation) !=
                  null) {
                database.
                  getFactory(
                    ).
                  addObligation(
                    xclass.
                      getClassDescriptor(
                        ).
                      toDottedClassName(
                        ));
            }
        }
        if (DEBUG_ANNOTATIONS) {
            java.lang.System.
              out.
              println(
                "After scanning for resource types:");
            for (java.util.Iterator<edu.umd.cs.findbugs.ba.obl.Obligation> i =
                   database.
                   getFactory(
                     ).
                   obligationIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.ba.obl.Obligation obligation =
                  i.
                  next(
                    );
                java.lang.System.
                  out.
                  println(
                    "  " +
                    obligation);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A3/Ftxv/C+5kkdIzKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e+zr1n2f7rV9r+04vn4ksePEdpxcJ7GVXkqiKEpw1oUU" +
       "RYoURUqUqAfr9oaPI4riU3xJYuKtSbslaIAs65wuBVpvf6Rb0qRNMazYgKKD" +
       "h2Fpi3bDMnTrHlgTDB3WpgvQrFi7LduyQ+r3vr/ftW/sTQCPqPPi5/M93/M9" +
       "X57z1Ve/U7onCkvlwHd2puPHN8A2vrFysBvxLgDRDY7HBmoYAaPtqFE0hnk3" +
       "9ff+yrU/+97nlg9dLl1RSo+qnufHamz5XiSByHdSYPCla8e5HQe4UVx6iF+p" +
       "qYokseUgvBXFL/Clt5xoGpeu84cQEAgBgRCQAgJCHNeCjd4KvMRt5y1UL47W" +
       "pb9UusSXrgR6Di8uPXO6k0ANVfegm0HBAPZwb/57AkkVjbdh6T1H3PecbyH8" +
       "+TLy8t/8sYf+3l2la0rpmuWNcjg6BBHDhyilB1zgaiCMCMMAhlJ62APAGIHQ" +
       "Uh0rK3ArpUciy/TUOAnBkZDyzCQAYfHMY8k9oOfcwkSP/fCI3sICjnH4656F" +
       "o5qQ6zuOue4Z0nk+JHi/BYGFC1UHh03uti3PiEtPn21xxPF6D1aATa+6IF76" +
       "R4+621NhRumR/dg5qmciozi0PBNWvcdP4FPi0hMXdprLOlB1WzXBzbj0+Nl6" +
       "g30RrHVfIYi8SVx6+9lqRU9wlJ44M0onxuc7woc/+zGv610uMBtAd3L898JG" +
       "T51pJIEFCIGng33DB57nf0Z9x69/+nKpBCu//UzlfZ1/8PHvfuRDT736m/s6" +
       "7zqnjqitgB7f1L+oPfiNd7efa92Vw7g38CMrH/xTzAv1HxyUvLAN4Mx7x1GP" +
       "eeGNw8JXpa/Pf/wXwR9fLt3Plq7ovpO4UI8e1n03sBwQMsADoRoDgy3dBzyj" +
       "XZSzpavwnrc8sM8VF4sIxGzpbqfIuuIXv6GIFrCLXERX4b3lLfzD+0CNl8X9" +
       "NiiVSlfhVZLhxZb2n+I7LvnI0ncBouqqZ3k+Mgj9nH+EAC/WoGyXyAIqk5aY" +
       "ERKFOlKoDjASJHENRI+OCw0Qw2YImViOIWqOZRZzZeA7lr6j1FjV1AjcyFsH" +
       "//8fuc2l8NDm0iU4QO8+ax4cOLO6vmOA8Kb+ckJ2vvvLN3/78tF0OZBfXGpC" +
       "BDcgght6dOMQwY09ghu3RVC6dKl48NtyJHutgGNqQ+sA7eYDz41+lPvop997" +
       "F1THYHM3HJC8KnKx+W4f2xO2sJo6VOrSq1/YfGLylyuXS5dP2+EcPcy6P28+" +
       "yK3nkZW8fnb+ndfvtU/94Z997Wde8o9n4inDfmAgbm2ZT/D3npVz6OtQhCE4" +
       "7v7596i/evPXX7p+uXQ3tBrQUsYq1GxohJ46+4xTE/2FQ6OZc7kHEl74oas6" +
       "edGhpbs/Xob+5jinUIAHi/uHoYzfkmv+B+H1EwdTofjOSx8N8vRte4XJB+0M" +
       "i8Io/4VR8PP/5p//EVqI+9B+XzuxIo5A/MIJm5F3dq2wDg8f68A4BADW+w9f" +
       "GPyNz3/nUz9SKACs8b7zHng9T9vQVsAhhGL+K7+5/rff/P0v/u7lY6WJ4aKZ" +
       "QAXUt0ck8/zS/bchCZ/2/mM80OY4UJdzrbkue65vWAtL1RyQa+n/uvZs9Vf/" +
       "y2cf2uuBA3MO1ehDr93Bcf47ydKP//aP/flTRTeX9HzNO5bZcbW9IX30uGci" +
       "DNVdjmP7iX/55M/+hvrz0CRDMxhZGSgs26WDiZODejtcF8+bqWRiSiDwQ7jI" +
       "FYOLFLWfL9IbuWCKPkpFGZonT0cnJ8npeXjCh7mpf+53/+Stkz/5R98tWJ12" +
       "gk7qRF8NXtirYZ68Zwu7f+ysReiq0RLWq78qvPiQ8+r3YI8K7FGHK38khtBA" +
       "bU9p0EHte67+u3/8T97x0W/cVbpMl+53fNWg1WIylu6DswBES2jbtsFf/Mhe" +
       "CTb3wuShgmrpFvJ75Xm8+HUNAnzuYjtE5z7M8VR+/H+KjvbJ//jfbxFCYYHO" +
       "WbrPtFeQr/7cE+0f/uOi/bEpyFs/tb3VaEN/77ht7Rfd/3b5vVf+6eXSVaX0" +
       "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" +
       "8sPaYa0PnldL8L198ILlmYct8qPQJy8K");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("oiuOQb/4yZdfMcRfqF4+CGsQ49J9sR/8kANS4JxAeB/s6fmLj3z7RQzh8XH7" +
       "b3zy20+Mf3j50TsINnr6DM6zXX65/9XfYt6v//Tl0l1Hh++3RDeebvTC6SP3" +
       "+0MQJ6E3PnXw/uTpgJ8X4PWlgwH70tmN7WOVOH9X+4N7lToTNXLpuMK2qPCv" +
       "zq9wOLqN1zj8WgLdBgbhqc4usqLOVgdBLtqi69/Lk38Rl+5PrciKi6E+dws3" +
       "9S3jWLe/cVq3HzjS7SNMjxzvPYspCEPLALeZDrcGjRQZ/+y0qPNzt68fiPrr" +
       "b6qoD1E/dcHJ6GyvJkUXf3Smi5MxPt/Jkz+ISw+qxonIvaLqvz+W3n96rb3v" +
       "1xLEuyHku/dt999vXBAnWfz5bcr+R578V6gvUDxWlG93nGX3pxfqRp79rTei" +
       "BcWB1/thT48dkH/sTSd/6e7blF3JM78fl95mgvjQYhZTRjiwGV85EsOl0v87" +
       "MRQHas/Cnt51IIZ33akYZq8phodvU/ZonjwA5zjU8jxINWb3wQIWOKMLl976" +
       "BjS9YFmDgF88YPnim8PyhHX9SkHnydtQfTpPHocjDqnS0JiO4hCobseLw1vJ" +
       "vvONkm1CWOEB2VuCJH4wsncdOzLfPjRyz76u8I/D2h/+AYJFcvns8lWzkOFz" +
       "t5EvkifX49LzUL7F6g5nVUgBB5w6Jz/V7xmpP/tGpT6HAvz4gdQ//uZI/fLx" +
       "8fq3c4zPF1xbt5HDC3lSj0vvXKqe4YDp+TEXJ2hjb5T2ByCDLx/Q/vKbbz86" +
       "tylj8uQjcFJFuurRfpj/sSU/Sz6KrD7Bk7gTnlvoD982aj4PAX78ln/y7P99" +
       "ov/yK9fufewV+feKwPGjf4jcx5fuXSSOczIS88T9lSAEC6sQx337uMyg4Ah9" +
       "picuju2PS1f2NzmFS/19k2FcevScJjF8/sHtydpjuAYf145Ll/VTxdO4dPWg" +
       "OC7dBdOThQrMgoX57Y8EhxP9RLTAPmR1e+mEO3+gRMUK/8hrjclRk5OR5/kr" +
       "QPFfq0N3Pdn/2+qm/rVXOOFj3238wj7yHTquWZb3ci9furoPwj9y+Z+5sLfD" +
       "vq50n/veg79y37OHrycP7gEfK/QJbE+fH2becYO4CAzP/uFjf//Df/eV3y/C" +
       "Jf4vAJSctgQ3AAA=");
}
