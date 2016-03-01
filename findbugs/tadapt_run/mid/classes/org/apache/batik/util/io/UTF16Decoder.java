package org.apache.batik.util.io;
public class UTF16Decoder extends org.apache.batik.util.io.AbstractCharDecoder {
    protected boolean bigEndian;
    public UTF16Decoder(java.io.InputStream is) throws java.io.IOException {
        super(
          is);
        int b1 =
          is.
          read(
            );
        if (b1 ==
              -1) {
            endOfStreamError(
              "UTF-16");
        }
        int b2 =
          is.
          read(
            );
        if (b2 ==
              -1) {
            endOfStreamError(
              "UTF-16");
        }
        int m =
          (b1 &
             255) <<
          8 |
          b2 &
          255;
        switch (m) {
            case 65279:
                bigEndian =
                  true;
                break;
            case 65534:
                break;
            default:
                charError(
                  "UTF-16");
        }
    }
    public UTF16Decoder(java.io.InputStream is, boolean be) { super(is);
                                                              bigEndian =
                                                                be; }
    public int readChar() throws java.io.IOException { if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           return END_OF_STREAM;
                                                       }
                                                       byte b1 = buffer[position++];
                                                       if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           endOfStreamError(
                                                             "UTF-16");
                                                       }
                                                       byte b2 = buffer[position++];
                                                       int c = bigEndian ? (b1 &
                                                                              255) <<
                                                         8 |
                                                         b2 &
                                                         255
                                                         : (b2 &
                                                              255) <<
                                                         8 |
                                                         b1 &
                                                         255;
                                                       if (c == 65534) {
                                                           charError(
                                                             "UTF-16");
                                                       }
                                                       return c; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya5AU1RW+M7s7+2BhH8iy4bHAMlDFw5kQRWMtIcKw6y7O" +
                                                              "siMLVFyMw52eOzsNPd1N9+3dYZGApBIoq0IZWZWo8CdYSSgEKxUrqaQkpPJQ" +
                                                              "yxgKYiUqFU3iD02UKvkR14Qk5tx7u6cfM7PG/MhUTU/P7XPOveee73zn3D57" +
                                                              "DdWZBurWsZrFMbpPJ2Ysxe5T2DBJNqFg09wGo2npoT8dPzj128YHwygygmbl" +
                                                              "sTkoYZP0yUTJmiNooayaFKsSMbcQkmUaKYOYxBjDVNbUETRHNgcKuiJLMh3U" +
                                                              "soQJ7MBGErVhSg05Y1EyYBugaFGSrybOVxPfEBToSaJmSdP3uQrzfAoJzzMm" +
                                                              "W3DnMylqTe7GYzhuUVmJJ2WT9hQNtErXlH2jikZjpEhju5W19kZsTq4t24bu" +
                                                              "Z1s+vPFwvpVvw2ysqhrlLppbiakpYySbRC3uaK9CCuZe9BVUk0QzPMIURZPO" +
                                                              "pHGYNA6TOv66UrD6mUS1CgmNu0MdSxFdYguiaInfiI4NXLDNpPiawUIDtX3n" +
                                                              "yuDt4pK3TrgDLj66Kj75+P2t369BLSOoRVaH2XIkWASFSUZgQ0khQwxzQzZL" +
                                                              "siOoTYWADxNDxoo8YUe73ZRHVUwtgICzLWzQ0onB53T3CiIJvhmWRDWj5F6O" +
                                                              "g8r+V5dT8Cj42uH6KjzsY+PgYJMMCzNyGLBnq9TukdUsx5Ffo+Rj9G4QANX6" +
                                                              "AqF5rTRVrYphALULiChYHY0PA/jUURCt0wCCBsdaFaNsr3Us7cGjJE1RZ1Au" +
                                                              "JR6BVCPfCKZC0ZygGLcEUZoXiJInPte2rDu2X+1XwygEa84SSWHrnwFKXQGl" +
                                                              "rSRHDAJ5IBSbVyYfwx3PHw0jBMJzAsJC5ocPXL9zddfFF4XM/AoyQ5ndRKJp" +
                                                              "6XRm1uUFiRV31LBlNOiaKbPg+zznWZayn/QUdWCajpJF9jDmPLy49Vf3HjpD" +
                                                              "3gujpgEUkTTFKgCO2iStoMsKMe4iKjEwJdkB1EjUbII/H0D1cJ+UVSJGh3I5" +
                                                              "k9ABVKvwoYjG/8MW5cAE26ImuJfVnObc65jm+X1RRwjVwxc1w3cREh/+S1Eu" +
                                                              "ntcKJI4lrMqqFk8ZGvOfBZRzDjHhPgtPdS2eAfzvuXlN7Pa4qVkGADKuGaNx" +
                                                              "DKjIE/FQbImsxbdv61tz2yYiATkZMYY3/f82U5H5PHs8FIJwLAiSgQJ51K8p" +
                                                              "IJuWJq2NvdfPpV8WQGPJYe8WRctgupiYLsanE+GUtZh3OhQK8VluYtMKCQjX" +
                                                              "Hkh8YN7mFcNf3rzraHcNIE0fr4W9DoPo8rJKlHAZwqH1tHT28tapS680nQmj" +
                                                              "MJBIBiqRWw6ivnIgqpmhSSQLfFStMDjkGK9eCiquA108Mf7gjoOf5evwMjwz" +
                                                              "WAfkxNRTjJdLU0SDmV3JbsuRdz88/9gBzc1xX8lwKl2ZJqOO7mBMg86npZWL" +
                                                              "8XPp5w9Ew6gW+Ag4mGLIGaC3ruAcPgrpceiY+dIADuc0o4AV9sjh0CaaN7Rx" +
                                                              "d4SDrY3f3wQhnsFyai58V9lJxn/Z0w6dXecKcDLMBLzgdP+FYf3ka7/5yy18" +
                                                              "u53K0OIp6cOE9njYiBlr57zT5kJwm0EIyP3hROr4o9eO7OT4A4mllSaMsmsC" +
                                                              "WAhCCNv8tRf3vv7Wm6dfDZcwG6JQjq0MdDbFkpNsHDVN4yTDubseYDMF8pyh" +
                                                              "JrpdBVTKORlnFMKS5J8ty9Y89/6xVoEDBUYcGK3+ZAPu+Gc2okMv3z/Vxc2E" +
                                                              "JFZN3T1zxQRFz3YtbzAMvI+to/jglYXfegGfBLIHgjXlCcI5MyT2gHveSW1N" +
                                                              "IIEBVbco1E6CCzygt3KJOL/eMp3eUG9RIjpbC9f7PLtETW/S+PPS0y2lpYdf" +
                                                              "/WDmjg8uXOde+tstL0YGsd4jYMkuy4pgfm6QoPqxmQe5Wy9uua9VuXgDLI6A" +
                                                              "RQmI1hwygNmKPkTZ0nX1b/zs5x27LtegcB9qUjSc7cM8OVEjZAUx88CrRf2L" +
                                                              "dwpQjDfApZXdFVFpYxDfGAHIRZUj3FvQKY/JxI/m/mDdd069ycHILSwsz7N+" +
                                                              "G4L9lfOMXZezy8py9FZTDcQyLLib/V3LI+UhcNbrD1sZk6YMuQAZOWZ3Iuc7" +
                                                              "pvb+on5ik9NlVFIRknebg5d+3P9Ommd8AyN6Ns4mm+mh8A3GqIduWoUvH8Mn" +
                                                              "BN9/sy/zgQ2Imt6esBuLxaXOQtcZEFZMcxTwuxA/0P7WnqfefUa4EOy8AsLk" +
                                                              "6ORDH8eOTYo0Fu3p0rIO0asjWlThDrsMstUtmW4WrtH3zvkDP/nugSNiVe3+" +
                                                              "ZqsXzhLP/O5fv46d+ONLFWp6fUbTFILVsixlXVsgQsKtyJqTfz/49deGoIwM" +
                                                              "oAZLlfdaZCDrtQs9tmllPCFzm18+4HWQhYei0EqIBB8eCADNyQ32/z522cQf" +
                                                              "9bBLr2Df9f9dcrGBhNCYX/JxcVnnwQ+3btF8/+qTb/906tv1Ym+nQUpAr/Mf" +
                                                              "Q0rm8J8/KqMl3iNUAE9AfyR+9ql5ifXvcX23WDPtpcXyFg7aGVf3c2cKfwt3" +
                                                              "R34ZRvUjqFWyD5I7sGKxEjgChyfTOV3CYdP33H8QEl1/T6kZWRBEr2faYJvg" +
                                                              "hUMt9YXe7QxmsdAshm/Upp1okLFCiN8Is8v5dQW7rHYKcaNuaBRWSbKBWjxz" +
                                                              "GrOglpFHe9WsjHm7kHSJkSMrPw2yipX4k38iKHCOCPLnfBuLALyF1Y56PKNP" +
                                                              "H548lR16ek3YRv42WDDV9JsVMkaUAISXlEF4kB9wXTzcfmWq5uojnc3lfTOz" +
                                                              "1FWlK15ZHevBCV44/Nd529bnd32KhnhRwP+gye8Nnn3pruXSI2F+RhfwKzvb" +
                                                              "+5V6/KBrMgi1DNXPOt2liLU4xfIeO2L3fPpiWU11Gg47VLkpYn/v4AKH2WU/" +
                                                              "RQ3QR2UTeTsgm+1ywH6GPPfDFNXI9kuigLl7iy6eH/gfmJKiZu+xjjUnnWVv" +
                                                              "kcSbD+ncqZaGuae2/54fLUpvJ5qheOcsRfEygec+ohskJ3OnmwUv6PznGEWd" +
                                                              "1U6aFIVlja/4G0L4mxTNqShMUS378cpOUtQalKWojv965R6nqMmVg15f3HhF" +
                                                              "noB9BxF2+6TudLSrq56PN0BrY0BbyOJp72cx5KeEUqzmfFKsPCyy1Jej/FWg" +
                                                              "k0+WeBkIbdepzVv2X7/taXF8khQ8McGszIAqLU5ypZxcUtWaYyvSv+LGrGcb" +
                                                              "lzm81CYW7GbKfA/UEwBEncFmXuBsYUZLR4zXT6+78MrRyBUocztRCMOpYGd5" +
                                                              "/SnqFhDGzmSlfgQYix97epre3nXpozdC7bwxtqmxazqNtHT8wtVUTtefCKPG" +
                                                              "AVQHtEuKvDhu2qduJdKY4WtvIhnNUktvDWcxjGP2mpDvjL2hM0uj7PhNUXd5" +
                                                              "t1f+SgLODOPE2Mis2+2Sj8UsXfc+5Tv7JcEAoq2tSScHdd1ucxu/ynde13kS" +
                                                              "n+M88B9uzJsi7xcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0YPS7fuZoR+7HVv5FMQ/ffq5P/qd596zFeOe4+uFNlgOf/Kv/vvLuy9+44s3" +
       "KUvnZ55na/LWd5snFLtv2uy5nzXP5K9qWfO2rcEbP5RvbGEfyJ/O3N5ERLaU" +
       "PUz7D/znwJ69+x/+44YAyavVTax2Al+CX/7Ig623fSvHPywbGfbDyY3VHCz7" +
       "D3HLn3D+befxc3+2A52XoCvK3p5iIttxlowlsI4O9zcaYN9x7P3xNfF2AXjt" +
       "oCy+8aTbHJn2ZME6NBfoZ9BZ/9KJGnVXpuVHwffqXsRcPRlsp6C8M93GW95e" +
       "zZof2y8JF/3AiwCXmprT7oCRmWm0XdWU85pEHIZrbn/xB9mfy8kkpwDts+Xd" +
       "+m4xe3725vOfzro/DupSmO+cAIZuurK9z8n9lq1c3Y+PCdhJAQe4atn1/WR8" +
       "Jc9rmap3t9uPE7x2fmhegW/edUiM9sBO5r3/+IEvv/+JrwMHoqCzq8y4wG+O" +
       "zNiPs83dL778wYde98I33puXWaBQ9kPtK2/PqC5uJ3HWqFmj7Yv6YCYql69Q" +
       "aTmMmLwyauqBtK0j8pARqK/e/0Ha6E6/WwlJbP9Dl0S5ivGlkVBg6mG9UG7O" +
       "u6i5qcy6GGPjxLq6GI4EJiKV3rq2qQ9Ck6EnxIZZV8vaIA37rFrqNwqIKkod" +
       "zG+S3rJISoIkeGhLFTnOaPcSPljKw4XPUsNNYvREk18SPGLixTLfWy1Gpcpw" +
       "UY2SelxTdKbOdmBmzo95mK1P2cFK07Q6kroIXq3jqiA140AIpYBgZoBaWQwT" +
       "rTou402qvySMYmPd8cqu741RlU2tUhkVu+uNsTGcmR2OF54oscUNP6Ycs+95" +
       "8kYmeiHHzJThwuHlnjgQk6aFT/ozvj0edfuG0otNimbmCB96Q6rONDvtYDLn" +
       "jGJVLLU3YjM2ZKLDBZvZYJKwers59jiZcjiVReJhkOqYR6Up4wgI7jIbeznW" +
       "6h0xncf8xKGosjBuzIf9qB1M7W7ZMheS5bfnVlwVSo2FFI6XlahcmcVSKSys" +
       "WGK98ierdXkTLueBTfv+zJQXvrjhZqMWEsu9RqsVS1qjOeEXxWHKMiQ/ktiB" +
       "3+2Ifaw2HqxqNT7Aaw7PlVqG04+LjMolhCoasSmTrm6Slf6Uxvs+a8prnsSj" +
       "KeJuYjyq+D1kHBg4bdVqPateLbDlCKk1mjQ38EYTuVuekgsB4wiOl4xhcTEf" +
       "rpN0mEp0aA68sShgeNLHE89DRR6YTxp1J/w6MshWSgvpsOi5zSoyRlomSa3m" +
       "jjDCBatK1AYGGhQmVXWMtqxKOe6CedNQLLCGSDFMK+1vOnTTXTbG8ULlw6RK" +
       "6F5hZDU6lSHWn9awJVENxqNJIPpzjOZpszUXu2KRxWCL50etqLhutZqhKhNy" +
       "PwyASetKx6LapZFUwmJqVGtOWqze6kmtorQxOrTS5iVvalKky0ZaOcDj8rRQ" +
       "mgJfastoheOEbuCuid502LEDbtTFMapKNrnZZCPq6wRhu+ui1WSoFAupVtVT" +
       "2CndSFVVJ4jKlIExbzOsuuqoR/m16cgpxTxhjiZIiW7a/YEp92asUUhTV5Dk" +
       "jQsPeVVoyZZPEQ0Ld1h6U2lMdKRr+ThixJZvtPnFeEz0jNagbHKRx4Q9RquY" +
       "Pau9ptRFs9S2+BlJwt0iXlKoAj/hqM4cIauLBtac9FZrT7Q6MMoIVQVrl2uk" +
       "E1P6xB3MlFrVcgrT0mi0tibrRCmtEWXUnsMFrtSO3UjpUWTFDpjlkligUmc1" +
       "0JvSKMWt7pw1Ilblyhqmp6t4avfrrFxZThYdDO/FHbmf4D2LbMPEcEY6YTJT" +
       "V7VSlJY3oomNFxIjigiso2W+2q2y3RAlSGpNYyZnDKlqqYf6JBUL1LLcX6k6" +
       "609QYdhhKVFDhZESGbFvinQou+1Ch4+kOTKYD3voxI7FiOm1hta0u5ijYr/u" +
       "EEpfR4I0kLtKn2wX9aAiNHCP9dCA6tldTFovu6WoOy6jkexzNbToDh2LoZpk" +
       "01yOhHXNXLmksfSdOccNaZ3gIga3Fp1eQ2uZyxgrFVFGrxuWN9Cr2mrNWOtU" +
       "wPRF0h+NLUql+SKHOxOEmoXxSE1RFG4YzVQpJVPUXvfsskQtB4O602QMtOb6" +
       "kkCjU9avrhvtdc0QCphRcTo02ZFbSBBjCmsEvqKZYkElMTxWil4FmzRCa15s" +
       "yXK/PkrUCocHIqIj6+HcDYmNbFbRScOmEheWiuuaOtWUnoLTTJNODZUtEKKO" +
       "LOQ6XN1sSmhcRXrFAenXlEG74Vqi2bSDaj0dVxfU2im2yQ2LzEeDoOI1tEF9" +
       "MK5gFce2OZkJnbAlYPNWq79Co5GOrFZ1wampOi4p606NGlpLkHjwGbHw+2EX" +
       "ZNnKZozHs1ATcYZA/c2cCny1ORn3BiPbJZgeV6XQaNMQ0QZcSyZeG2/yotLp" +
       "IQUJY+NCRyl7C2aFpPAkUcptipD6yLiUJsMRkSJiNEsxZkUWIg+2DFuc6prR" +
       "0Zs02TWsqd1SyCqzGZeN7krjhFKfJNvNyUzxSu1aq5VujAjpUQMa1hgf0fhO" +
       "Y0Ra/qzV0OssHbXHAswVWJYrbsq2L6o6LOCOZaDxdKBqhSiM6KLYCdWKJTKL" +
       "eFPxDd2pDT12mThDrSpsGnEsNybxFORUsoaNhg5ZmoOM0nd67GIsFd1paQan" +
       "YTUp1+lIM5RmY8lbnFJXGHQwaVsSxico2gpGeplW1/7QwnXMl6YqMSF8McH1" +
       "DtYlRxJvIcRq2BNhKiFhB3ZwVS3WGhulS9LcOkzr/UKnQjdsfcBMJS3dAMU3" +
       "CGmMK8MNTZszeILQZIGfK/1ZgJdCaVETmXiISQNBQshYqfurWcFzq+ai0bcn" +
       "BDlauNrMqKoFhG0MHEdFsU2/1g8rjlNw5iiGdJakGgsev+qijNvsN+BwA6fG" +
       "sEw6UU0LmzGdyNPBMFKkNiExSjJexwkGF9m64C51TeflSnuwQbGQXtQGI7yL" +
       "aoOx6BWJGPGLATkoyqEl2OM5HoRMGPGRI1SEIOoi6WqBs7AbG1zfnGjAX5bh" +
       "NJ3TLDyo6qtKTS0M+jQh+DWdn40Jkp6EZmJPJ6ExDHvRhlqO9RSuNFSt45Fr" +
       "xsMk2tZVWWrhQTQMGxFwdbZFpE4JLVS6wnAuamaxvSSbTVRrYXh/M0TKcFot" +
       "l5Wh3pg16aCM6w29oSpBpznvt8QpMIsycd31sIDMIgKFC8vxDG4Ua9GqJDoF" +
       "d8j7WAAz+rAYOCiFwr0lYyNmn8faDUzfjAqNpV019elKmZYRAWcjX5luCKMu" +
       "d0BNUMpKT19HyAipSKMVby0JYYNXyXrY6SVty2jNN/p4MEFaIlifIF102LZL" +
       "8Li2kIRRsx2UdVmkVsacZ6KGONXqw8QJVSycOzDv+yVvQRMts4+SIbqqqkOh" +
       "HnTFniL3Y7k5ErhZrylYSdoJBobtE12tIYRW16kvuhy14JiABQsX059WFghq" +
       "9rqtQYulXR3YHqM3REms1then+1WK6g9KtW0BSKOVpWygOOTBhVOmIXMYyQ3" +
       "tdtEZdFsrKfjVNEdYVmNPctVEBtIlJYIwe6VqlJXWzVbk0oF7qvVcmPmqki5" +
       "N3fnozVbMDYa2nddxA/iKUeWicJorq97KXDm6qQG95oBY5glvA8Wm1HZNmm+" +
       "kuikNijTCKg0psCXSh2jUp/QYM3lwqsK1uuWBR4eDZHhqMyPtXFoOIXSZt2t" +
       "dVhWx4n+lGwsYtOg7bq5qWldGKQBqmdKcSGxLN51hclqoXAzvOAqS0nuxLJW" +
       "hqsVneb9FVVdzrWBEo709sbQlII3DxcUMnCdNb+qsanbaQtqia/JBDmxLRmu" +
       "dIp0xUnG/SU3Z3gOqaOKP+CjoWz3BM9aNWrVUc1dMs7EKFXBomFOuF6z0UyI" +
       "cqE2jlWaC5ZA/f1iMxCLzdlmQPn1spJUe1qbX6aODhbHbAtUBEqzYEIwFsWC" +
       "oDUX5EzV/HSyKk/rcCRPCRSs/FBG6YQpiS1pvrrxpUThI0EWNytuVaA7QUeZ" +
       "2amDllqiUO/MejoG8+11s+0qhDONm6HIS/Sokk7HtUIdZYLRpsl7ShqNWszA" +
       "FztqFebcJTHHO6nD2boxFM2kUdf8QEPcqe+laqs+WyfR0knkdNkHtRtdRxN+" +
       "HGlgLcd2sMmwG7Xj3gqfx+WlGlNqT6wI0Yqcu31+Ea1wQUmsDlt2fHxl0eU5" +
       "U4ytOjvv81O1GpX0AmfQA3zAtsuMGZYLZc5C+XCqK4XqeFWnlDbmLcsRxyld" +
       "VS3FShLDG1fVSsiCcwsMijYbcUqFZj1RwAbrmWeyrdf6tW0J7853vwc3cWAn" +
       "mL14Lbu+5GanbPnnHHTi9ubkKdsD+6d7AfTQrS7Y8kOoj737hZfUwcdLO3vn" +
       "RVQEXYw8/y22ttLsI6SyLfbTtz7+YfL7xcMzmM+/+18eHL9t/uxruK145ASf" +
       "J0n+LvPyFztvUn51Bzp9cCJzw83ncaRrx89hLgVaFAfu+NhpzEMHmr28f/Q5" +
       "3NPs8DZHnzccxeResLX9bY7jfuXmx9PZYyUHeH/WPB9BFwJNVlvzvevsE8cH" +
       "p829O/LchX7pNR3pRdAdR2+usmP4B264KN9e7iqfeunyhftf4v86v7w5uIC9" +
       "SEMX9Ni2j55wHemfA+Gtm7kwF7fnXX7+8+EIeuBWl2kRtGN6Oa8vboE/EkH3" +
       "3hQ4gs5kP0dhfyOCrpyEjaCz+e9RuN+MoEuHcBF0bts5CvJxoFsAknV/y98/" +
       "pnrzLa8AsVkYBbISZXba02dy6nj8HVjpnh9kpSMh+8SxQMv/7bAfFPH2/w7X" +
       "lU+/RPV/5tXax7cXVIotp2lG5QINnd/elR0E1mO3pLZP61z3qe/d9ZmLT+4n" +
       "gbu2DB+6+xHeHrn5bVDb8aP8/ib9w/t//62//dLX8hO1/wXdFWghhiIAAA==");
}
