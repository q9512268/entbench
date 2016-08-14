package util;
public class PageRankGraph {
    public it.unimi.dsi.webgraph.ImmutableGraph g;
    public it.unimi.dsi.webgraph.ImmutableGraph t;
    public PageRankGraph(it.unimi.dsi.webgraph.ImmutableGraph g, it.unimi.dsi.webgraph.ImmutableGraph t) {
        super(
          );
        this.
          g =
          g;
        this.
          t =
          t;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471193671000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1Ya2wcVxW+u347ttd2Esc4iZu4TpGTsNtAUxScliYbu9l0" +
                                                              "/ZCdRmJDs707c3d34tmZycwde+0QaCuhpn+qAGkaEPUvV5Gi0laICn7QyqgC" +
                                                              "igpIbcOjIALiV1GJaIQoiPA6587szmN30z+stLPje88995xzv/Odc/3CDdJi" +
                                                              "mWSYaTzOlw1mxSc0PktNi8lJlVrWcRjLSs820b+eem/6QJS0ZkhPkVpTErXY" +
                                                              "pMJU2cqQ7YpmcapJzJpmTMYVsyazmLlIuaJrGbJZsVIlQ1UkhU/pMkOBE9RM" +
                                                              "kz7KuankbM5SrgJOtqfBkoSwJHEoPD2eJl2Sbix74oM+8aRvBiVL3l4WJ73p" +
                                                              "03SRJmyuqIm0YvHxskn2GLq6XFB1HmdlHj+t7ndDcCy9vyYEIy/HPrx1odgr" +
                                                              "QrCRaprOhXvWHLN0dZHJaRLzRidUVrLOkC+SpjTZ4BPmZDRd2TQBmyZg04q3" +
                                                              "nhRY3800u5TUhTu8oqnVkNAgTnYGlRjUpCVXzaywGTS0c9d3sRi83VH11vGy" +
                                                              "xsVn9iQuPnuq99tNJJYhMUWbR3MkMILDJhkIKCvlmGkdkmUmZ0ifBoc9z0yF" +
                                                              "qsqKe9L9llLQKLfh+CthwUHbYKbY04sVnCP4ZtoS182qe3kBKPevlrxKC+Dr" +
                                                              "gOer4+EkjoODnQoYZuYp4M5d0rygaDInd4RXVH0cfQgEYGlbifGiXt2qWaMw" +
                                                              "QPodiKhUKyTmAXpaAURbdACgyclQQ6UYa4NKC7TAsojIkNysMwVSHSIQuIST" +
                                                              "zWExoQlOaSh0Sr7zuTF98Omz2lEtSiJgs8wkFe3fAIuGQ4vmWJ6ZDPLAWdi1" +
                                                              "O32JDrx6PkoICG8OCTsy3/3CzQf2Dq+/4chsrSMzkzvNJJ6V1nI9b21Ljh1o" +
                                                              "QjPaDd1S8PADnossm3VnxssGMMxAVSNOxiuT63M/+txjV9n7UdKZIq2Srtol" +
                                                              "wFGfpJcMRWXmg0xjJuVMTpEOpslJMZ8ibfCeVjTmjM7k8xbjKdKsiqFWXfwN" +
                                                              "IcqDCgxRJ7wrWl6vvBuUF8V72SCEtMGXdMG3mzgf8cvJkURRL7EElaimaHpi" +
                                                              "1tTRfysBjJOD2BYh7QpgnLaQsEzJdRlG5mDkQZMaxTiiyfg/6SmjvRuXIhEI" +
                                                              "5bZwIquQA0d1VWZmVrpoH564+WL2TQckCGzXU8C3E3m/bhKJCJWbcA/nZCCu" +
                                                              "C5ChQJFdY/OPHHv0/EgTQMJYaoagoOhIoFQkvTSucG9Weqm/e2Xn9X2vR0lz" +
                                                              "mvRTidtUReY/ZBaAU6QFN+26clBEPC7f4eNyLEKmLjEZqKQRp7ta2vVFZuI4" +
                                                              "J5t8GiqVBnMq0Zjn69pP1i8vPX7iS3dHSTRI37hlCzAPLp9F0q2S62g4bevp" +
                                                              "jT353ocvXTqnewkcqAeVMlazEn0YCR96ODxZafcO+kr21XOjIuwdQLCcQkIA" +
                                                              "dw2H9wjww3iFa9GXdnA4r5slquJUJcadvGjqS96IQGOfeN8EsOjAhBmAb5+b" +
                                                              "QeIXZwcMfG5x0Is4C3khuPy+eeO5X//8T58S4a7QfsxXr+cZH/dRDSrrF6TS" +
                                                              "58H2uMkYyP3u8uzXnrnx5EmBWZC4s96Go/hMAsXAEUKYv/zGmXd/f33tWtTD" +
                                                              "OYdaa+egZSlXnYyiT+23cRJ2u8uzB6hKhTRH1Iw+rAE+lbxCcyrDxPpXbNe+" +
                                                              "V/78dK+DAxVGKjDa+9EKvPGPHSaPvXnq78NCTUTCUunFzBNz+Hejp/mQadJl" +
                                                              "tKP8+Nvbv/5j+hwwObCnpawwQYhREYOo8HwQEKoAZ2tKSYnLlhJfYrmCYKVU" +
                                                              "qWRzNEgQCcreK455v1h3t3jegyES2oiYO4CPXZY/XYIZ6WuCstKFax90n/jg" +
                                                              "tZvCv2AX5UfHFDXGHUDi464yqN8SprOj1CqC3D3r05/vVddvgcYMaJSgdbBm" +
                                                              "TODNcgBLrnRL229+8PrAo281kegk6VR1Kk9SkZakA/KBWUWg3LLx2QccOCwh" +
                                                              "NnqFq6TG+ZoBPJI76h/2RMng4nhWvrflOwevrF4XuDQcHVvds4EqEOBh0Yt7" +
                                                              "VHD1nU//4spXLi051XysMf+F1g3+c0bNPfHHf9SEXDBfnU4jtD6TeOGbQ8n7" +
                                                              "3xfrPQrC1aPl2soFNO6t/eTV0t+iI60/jJK2DOmV3N73BFVtTOwM9HtWpSGG" +
                                                              "/jgwH+zdnEZlvEqx28L059s2TH5exYR3lMb37np8NwTfHpcKesJ8FyHi5SGx" +
                                                              "5OP42FNLJI1WcxIpiHxyWBOfn8FH2oHAfQ0RN1FrYczdI9bAwrnbWthoNVjI" +
                                                              "61k4fxsLy/V2Ep/WcO/lJ1UP9AQze3uj9li09mtPXFyVZ57f58C+P9hyTsCN" +
                                                              "6lu//PdP45f/8JM63VEH141PqGyRqYE9OekOdEyYuIM1Nymn+5deXI21b1l9" +
                                                              "+FeiAlc79C6oXXlbVf3Q8r23GibLKwJiXQ7QDPEDhN6MhuO7bFTYuFeQBuI8" +
                                                              "7uC8HAnGqHoYmz8KLr6w3hlgCHGfdH2bsp0bJXR1q8emz96893mnTMNNdGVF" +
                                                              "3D/gOuV0DNVmaGdDbRVdrUfHbvW83LEr6haGPsdgD05bfVUjCQXZwLgPhWqY" +
                                                              "NVotZe+uHXztZ+db34aDPUkilJONJ2sZoWzYgKCTaY85ff+PEMV1fOwby/fv" +
                                                              "zf/lt4JzidPxbmssn5WuXXnkna8OrkER3pAiLYBBVhZUdWRZm2PSopkh3Yo1" +
                                                              "UQYTQQvclVOkHYrpGZul4BbcgxCheNMUcXHD2V0dxSaPk5GaK2Wd1hjq0xIz" +
                                                              "D+u2JgvKAvr2RgIXXRd2nbZhhBZ4I9Wj3FTre1Y68lTs+xf6myYB5gF3/Orb" +
                                                              "LDt3vMKf/ruvR6i9Dg38Fz4R+P4Hv3joOIC/wOpJ9x64o3oRhELozDVl01OG" +
                                                              "UZEVCEF1i/gol3EcWGq3O4qlN+K0dvjnWbG/gO9ZfJz7HxDoKCgHEwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471193671000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
