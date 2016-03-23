package video;
public class RaspiVid implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { java.lang.System.out.format("Snapshot %d\n",
                                                             _vidHeight);
                                 if (_vidHeight >= 1080) { return video.EntMode.
                                                                    HIGH_MODE;
                                 }
                                 else
                                     if (_vidHeight >=
                                           720) {
                                         return video.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return video.EntMode.
                                                  LOW_MODE;
                                     } }
    private final java.lang.String _raspividPath = "/opt/vc/bin/raspivid";
    private int _vidTimeout = 120000;
    private java.lang.String _vidName = "vid.mp4";
    private int _vidWidth = 1920;
    private int _vidHeight = 1080;
    private int _fps = 30;
    public RaspiVid(int width, int height) { super();
                                             _vidWidth = width;
                                             _vidHeight = height; }
    public void TakeVideo() { try { java.lang.StringBuilder sb = new java.lang.StringBuilder(
                                      _raspividPath);
                                    sb.append(" -n ");
                                    sb.append(" -t " + _vidTimeout);
                                    sb.append(" -w " + _vidWidth);
                                    sb.append(" -h " + _vidHeight);
                                    sb.append(" -fps " + _fps);
                                    sb.append(" -o " + _vidName);
                                    java.lang.System.out.println(
                                                           sb.
                                                             toString(
                                                               ));
                                    java.lang.Runtime.getRuntime(
                                                        ).exec(sb.
                                                                 toString(
                                                                   ));
                                    java.lang.Thread.sleep(_vidTimeout);
                              }
                              catch (java.lang.Exception e) {
                                  java.lang.System.
                                    exit(
                                      e.
                                        hashCode(
                                          ));
                              } }
    public void TakeVideo(java.lang.String name, int fps, int timeout) {
        _vidName =
          name;
        _fps =
          fps;
        _vidTimeout =
          timeout;
        TakeVideo(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457107854000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1ZDWwUxxWeO/8b/4MxGGPAGFp+4gtpaIOcH8DYselhLNtx" +
                                                              "W6flWO/N+Rbv7S67c+fDqdMEJYJWKqKEAFUDlSpSUgoBVaU/alMRRc1Pgyol" +
                                                              "TZu0UkjVViptihRUNalK2/S9mb3bn/uhVnvSjndn5r15781733szPnedlFkm" +
                                                              "aaca62L7DGp19WpsSDItGu1RJcsahb6IfLxE+uuua4ObgqR8nNTFJWuHLFm0" +
                                                              "T6Fq1BonSxXNYpImU2uQ0ihSDJnUomZKYoqujZNmxRpIGKoiK2yHHqU4YUwy" +
                                                              "w6RRYsxUJpKMDtgMGFkaBklCXJLQFv9wd5jUyLqxz5m+yDW9xzWCMxPOWhYj" +
                                                              "DeE9UkoKJZmihsKKxbrTJlln6Oq+SVVnXTTNuvaoG20TbA9vzDFBx8X6928e" +
                                                              "jjdwE8yXNE1nXD1rmFq6mqLRMKl3entVmrD2kodJSZjMc01mpDOcWTQEi4Zg" +
                                                              "0Yy2ziyQvpZqyUSPztVhGU7lhowCMbLCy8SQTClhsxniMgOHSmbrzolB2+VZ" +
                                                              "bYWWOSo+uS509Piuhu+UkPpxUq9oIyiODEIwWGQcDEoTE9S0tkSjNDpOGjXY" +
                                                              "7BFqKpKqzNg73WQpk5rEkrD9GbNgZ9KgJl/TsRXsI+hmJmWmm1n1Ytyh7K+y" +
                                                              "mCpNgq4LHV2Fhn3YDwpWKyCYGZPA72yS0ilFizKyzE+R1bHzkzABSCsSlMX1" +
                                                              "7FKlmgQdpEm4iCppk6ERcD1tEqaW6eCAJiOtBZmirQ1JnpImaQQ90jdvSAzB" +
                                                              "rCpuCCRhpNk/jXOCXWr17ZJrf64P3n3oIa1fC5IAyBylsoryzwOidh/RMI1R" +
                                                              "k0IcCMKateFj0sLnDgYJgcnNvslizvc/f2Pz+vbLL4s5S/LM2Tmxh8osIp+e" +
                                                              "qHutrWfNphIUo9LQLQU336M5j7Ihe6Q7bQDCLMxyxMGuzODl4Rc/88hZ+m6Q" +
                                                              "VA+QcllXkwnwo0ZZTxiKSs37qUZNidHoAKmiWrSHjw+QCngPKxoVvTtjMYuy" +
                                                              "AVKq8q5ynX+DiWLAAk1UDe+KFtMz74bE4vw9bRBCKuAhNfCUEPHjfxm5KxTX" +
                                                              "EzRkKKEhU0fVrRCAzQSYNR5KKVGqhyxTtt+GJctQxpRoF3qQ8T/QplGu+dOB" +
                                                              "AJiszR+wKvh6v65GqRmRjya39t54NvKqcAZ0YFsjRuo4364MXxIIcHYLkL+w" +
                                                              "PthuCqIQYLBmzcjntu8+2AE6p43pUlAcp3Z40kGPE6oZfI3IF5pqZ1Zc3fBC" +
                                                              "kJSGSZMks6SkIrpvMScBN+QpO7RqJiBROHi93IXXmGhMXaZRgItCuG1zqdRT" +
                                                              "1MR+Rha4OGSyCcZNqDCW55WfXD4x/ejYF24PkqAXonHJMkAXJB9CYM0CaKc/" +
                                                              "NPPxrT9w7f0Lx2Z1J0g9mJ9JVTmUqEOHf8P95onIa5dLlyLPzXZys1cBiDIJ" +
                                                              "nB7wqd2/hgcDujN4irpUgsIx3UxIKg5lbFzN4qY+7fRwT2zk7wvALSoxKBrg" +
                                                              "WWFHCf+LowsNbFuE56Kf+bTgeH3PiHHyrZ//6WPc3Blor3fl5BHKul1wgsya" +
                                                              "OHA0Om47alIK894+MfTEk9cPPMh9FmaszLdgJ7Y9ACOwhWDmx1/e++t3rp5+" +
                                                              "I+j4OYN8mpyAsiSdVTJAbDwopCSsttqRB+BIhdhGr+l8QAP/VGKKNKFSDKx/" +
                                                              "1q/acOkvhxqEH6jQk3Gj9bdm4PQv3koeeXXXB+2cTUDGdOjYzJkmMHa+w3mL" +
                                                              "aUr7UI70o68v/epL0klAa0BIS5mhHPSC3AZBb6xjPI0kJyyISyUB25Cy88cd" +
                                                              "Q7vlg51DfxC5YXEeAjGv+ZnQl8fe3HOFb3IlRj72o961rrgGhHB5WIMw/ofw" +
                                                              "C8Dzb3zQ6NghcLipx04Gy7PZwDDSIPmaIuWbV4HQbNM7U09dOy8U8GdL32R6" +
                                                              "8OiXPuw6dFTsnCgpVuZkdTeNKCuEOthsQulWFFuFU/T98cLsj56ZPSCkavIm" +
                                                              "yF6o/87/6l9Xuk789pU8GF+i2GXhnei2WeBe4N0bodC2L9b/+HBTSR9gxgCp" +
                                                              "TGrK3iQdiLo5QkVkJSdcm+WUKrzDrRpuDCOBtbAH2HEXbzdyWW7PSkS4RISP" +
                                                              "9WOzynLjp3e/XJVvRD78xnu1Y+/95AbX2Vs6u+Fih2QIgzdisxoN3uLPb/2S" +
                                                              "FYd5d14e/GyDevkmcBwHjjLUi9ZOE5Jo2gMu9uyyit88/8LC3a+VkGAfqVZ1" +
                                                              "KdoncZwmVQCQ1IpD/k0b920W+DBdaaMiSZMc5XM6MEaX5Y/+3oTBeLzO/KDl" +
                                                              "u3efOXWVA5UheCzh9OVYEngSMz+AObnh7C8+8cszXzk2LfypSHT46Bb9Y6c6" +
                                                              "sf93f88xOU+FeQLGRz8eOvdUa8+973J6JychdWc6t4yBvO7Q3nE28bdgR/lP" +
                                                              "g6RinDTI9oFnTFKTiPTjUORbmVMQHIo8496CXVSn3dmc2+aPWNey/mzoDoRS" +
                                                              "5nF6JwHW4xbeA0+TnRua/AkwACllQUg3WCglhyYULWRiBQbFGA6Pc0Yf4e1a" +
                                                              "bG4TCMxIhWEqcFQGfcpiiiapvnRUV2RJRmojmUWGoKjllIvgsMudDO3SJQ4y" +
                                                              "IjdjO4DNg2KNcEE3Hs3KUIW9HfA02zI056hN+MtkfgUD+Brx6VRZhB8j8yKg" +
                                                              "zqiSoHD04hDjkz4+R+lXwdNir9ZSQHpdSI/NnlxZC1EzUomyDtruI/sENeYo" +
                                                              "aDs8rfZSrQUETRUVtBA1I1Uo6KeUqDj5+E06PUdJl8HTZq/VVkDS2aKSFqJm" +
                                                              "pBol7afKZDzv7j/834tajb2LbHEzYucT9bF8ogaJrW0hakZKIzHDyifk40WE" +
                                                              "TDuLrcsuxn/lxHcIdVeeTiIgmO2WFron4KXF6f1HT0V3Pr0haOfgzeAATDdu" +
                                                              "U2mKqi5WWAAu9eSUHfxmxAHot+uO/P6HnZNb53LOw772W5zk8HsZZIe1hdOU" +
                                                              "X5SX9v+5dfTe+O45HNmW+azkZ/mtHedeuX+1fCTIr4FE5si5PvISdXvzRbVJ" +
                                                              "WdLUvKXSSu+xCV1wtb2vq/0u6HiOzyWyh5FCpEVqrq8VGTuJzTFwiFFpio7h" +
                                                              "VQGf1o3NJuGc94Frp3Ql6jj08VtFXfHCBzuGRagc8dpmEzzdtoLdc7dNIVKf" +
                                                              "/iVckJIsSPN4FaXrt4uY6jw233SbCju+7pjlzP/DLGlII5nLGiwRF+Vc1IrL" +
                                                              "RfnZU/WVLaceeJPHYvYCsAaiKpZUVXcR43ovN0waU7g6NaKkEYX7Jag3UhmV" +
                                                              "vmfkKR1ESZUOeKEnq3vzrXR3odVKT5Tz++pMRCbFjXVEvnBq++BDNz7+tLgi" +
                                                              "kFVpZga5zIPDibityEb1ioLcMrzK+9fcrLtYtSqDf41CYMeflrh2eRhevDiY" +
                                                              "85+HiJx+fn191zcWfzSISOMrcn3lJJwapqm5VU9qvPKD41QZIl72oiVpGO5h" +
                                                              "X53JXRtzT73t2mW3igoeuIbf1/n3NhHUhBeapXHIqYa7Hw/bcJa7zzB8s6GS" +
                                                              "LUmAN2LHi74xOJKXgIZ87Gdpw1nYOYa25R5DIQfwqw04Ljzx1sDFqQ828yvf" +
                                                              "MkhWNM3r/G37tGEqp0zPGbUOvVzCEpbvrO0QtdlevCJjpCP3eJ57sZi7LfOc" +
                                                              "Hs+/AjLQ7tsoIHB6XFcYHtMEPm3g/QrfRl77zueGusIdDZvXsenln+n/AL06" +
                                                              "u7p+GwAA");
    public RaspiVid() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        video.RaspiVid ENT_ld =
          new video.RaspiVid(
          );
        ENT_ld.
          _vidTimeout =
          this.
            _vidTimeout;
        ENT_ld.
          _vidName =
          this.
            _vidName;
        ENT_ld.
          _vidWidth =
          this.
            _vidWidth;
        ENT_ld.
          _vidHeight =
          this.
            _vidHeight;
        ENT_ld.
          _fps =
          this.
            _fps;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457107854000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VyL/B8KyDSDQKgAA");
}
