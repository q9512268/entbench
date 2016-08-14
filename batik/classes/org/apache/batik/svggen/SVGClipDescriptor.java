package org.apache.batik.svggen;
public class SVGClipDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String clipPathValue;
    private org.w3c.dom.Element clipPathDef;
    public SVGClipDescriptor(java.lang.String clipPathValue, org.w3c.dom.Element clipPathDef) {
        super(
          );
        if (clipPathValue ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              org.apache.batik.svggen.ErrorConstants.
                ERR_CLIP_NULL);
        this.
          clipPathValue =
          clipPathValue;
        this.
          clipPathDef =
          clipPathDef;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_CLIP_PATH_ATTRIBUTE,
            clipPathValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (clipPathDef !=
              null)
            defSet.
              add(
                clipPathDef);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYa3AUxxGeO6H3W4DAPASSJSjxuDOxcUwE2CAEiJzEBWGl" +
                                                              "cjyOvb2508Le7rI7J51EnGBsl/GPEEIAk5ThT+RgCAZXKq7ESeyS44ofZSdV" +
                                                              "2CSO45hQcX7YcSibctlJhbx6ZvZ9d6KoOKraudFMT890T/fX3XPuKio1dNSC" +
                                                              "FRIioxo2Qj0KiQq6gZPdsmAYW2EsLj5aIny8873+FUFUFkN1Q4LRJwoGXi9h" +
                                                              "OWnE0FxJMYigiNjoxzhJV0R1bGB9WCCSqsTQdMnozWiyJEqkT01iSjAo6BHU" +
                                                              "KBCiS4kswb0mA4LmRuAkYXaS8Br/dFcE1YiqNuqQz3SRd7tmKGXG2csgqCGy" +
                                                              "WxgWwlkiyeGIZJCunI4Wa6o8mpZVEsI5EtotLzdVsCmyPE8FbU/Vf3r98FAD" +
                                                              "U8FUQVFUwsQztmBDlYdxMoLqndEeGWeMvehrqCSCql3EBLVHrE3DsGkYNrWk" +
                                                              "dajg9LVYyWa6VSYOsTiVaSI9EEGtXiaaoAsZk02UnRk4VBBTdrYYpJ1vS8ul" +
                                                              "zBPx2OLw0Ud3NvywBNXHUL2kDNDjiHAIApvEQKE4k8C6sSaZxMkYalTgsgew" +
                                                              "LgmyNGbedJMhpRWBZOH6LbXQwayGdbanoyu4R5BNz4pE1W3xUsygzP9KU7KQ" +
                                                              "BlmbHVm5hOvpOAhYJcHB9JQAdmcumbJHUpIEzfOvsGVs/yIQwNLyDCZDqr3V" +
                                                              "FEWAAdTETUQWlHR4AExPSQNpqQoGqBM0qyhTqmtNEPcIaRynFumji/IpoKpk" +
                                                              "iqBLCJruJ2Oc4JZm+W7JdT9X+1ce2qdsVIIoAGdOYlGm56+GRS2+RVtwCusY" +
                                                              "/IAvrFkUOS40P3swiBAQT/cRc5off/XaPUtaJl7mNLML0GxO7MYiiYvjibqL" +
                                                              "c7o7V5TQY1RoqiHRy/dIzrwsas505TRAmGabI50MWZMTW178yv6z+IMgqupF" +
                                                              "ZaIqZzNgR42imtEkGesbsIJ1geBkL6rESrKbzfeicuhHJAXz0c2plIFJL5oi" +
                                                              "s6Eylf0PKkoBC6qiKuhLSkq1+ppAhlg/pyGEyuFDa+FrR/yP/RK0PTykZnBY" +
                                                              "EAVFUtRwVFep/EYYECcBuh0KJ8Dq94QNNauDCYZVPR0WwA6GsDUxnE5jJTww" +
                                                              "uKFblrR12BB1SQNzD1Er0/7P/HNUvqkjgQCofo7f8WXwmY2qnMR6XDyaXdtz" +
                                                              "7Xz8VW5U1BFMzRDUCVuG+JYhtmWIbxnK2xIFAmynaXRrfsFwPXvA0QFpazoH" +
                                                              "dmzadbCtBCxLG5kCuqWkbZ6I0+2ggQXhcfFCU+1Y6+VlLwTRlAhqEkSSFWQa" +
                                                              "QNboaYAmcY/pvTUJiEVOSJjvCgk0lumqiJOASMVCg8mlQh3GOh0naJqLgxWw" +
                                                              "qGuGi4eLgudHEydG7h/8+m1BFPRGAbplKQAYXR6l2G1jdLvf+wvxrX/4vU8v" +
                                                              "HL9PdXDAE1asaJi3ksrQ5rcFv3ri4qL5wtPxZ+9rZ2qvBJwmAvgVQGCLfw8P" +
                                                              "zHRZkE1lqQCBU6qeEWQ6Zem4igzp6ogzwoy0kfWngVlUU7+bA99S0xHZL51t" +
                                                              "1mg7gxs1tTOfFCwkrBrQTv7u1+/fztRtRY96V9gfwKTLhViUWRPDpkbHbLfq" +
                                                              "GAPdOyei3z529eFtzGaB4tZCG7bTthuQCq4Q1PzQy3vf+uPl8UtBx84JhOxs" +
                                                              "AjKfnC0kHUdVkwgJuy1wzgOIJwMqUKtpv1cB+5RSkpCQMXWsf9Z3LHv6r4ca" +
                                                              "uB3IMGKZ0ZIbM3DGb1mL9r+6828tjE1ApBHX0ZlDxmF8qsN5ja4Lo/Qcuftf" +
                                                              "n/udl4STEBAAhA1pDDNcDTIdBJnkMyEBYytpcA3x4GpNTKUwM3K7GEqqmRBN" +
                                                              "nMD72E0vZxS3sfYOqiXGELG5Ltp0GG6P8TqlK52Ki4cvfVQ7+NFz15iI3nzM" +
                                                              "bSB9gtbFbZI2C3LAfoYf0TYKxhDQ3THRv71BnrgOHGPAUQSENjbrgKg5jzmZ" +
                                                              "1KXlv3/+heZdF0tQcD2qklUhuV5gnokqwSWwMQRgnNPuvodbxEgFNA1MVJQn" +
                                                              "fN4AvZV5he+7J6MRdkNjP5nxo5WnT11mpqlxHrPN64H44IFiltU7aHD2jc//" +
                                                              "5vS3jo/wvKCzOAT61s38x2Y5ceBPf89TOQO/AjmLb30sfO6xWd2rP2DrHRSi" +
                                                              "q9tz+TENkNxZ+7mzmU+CbWW/DKLyGGoQzSx6UJCz1LdjkDkaVmoNmbZn3psF" +
                                                              "8pSny0bZOX4EdG3rxz8nlkKfUtN+rQ/yaugVtsLXYaJBhx/yAoh1+tiShaxd" +
                                                              "RJulFsKUa7oElRb2QUz1JEwJCA3xOwppEBOaDt7JsZW2K2nTz/ndXdQoN3iF" +
                                                              "mA/fAnO/BUWEGORC0Caaf9piqwmqtk67Dqfo0F2+s355krPmnD0X23uyvzJ/" +
                                                              "yucGYbeHmDjVMUk65KRCFnXrJNQDo2DNOQovc4tl+6xSGT9w9FRy8+PLuO81" +
                                                              "eTPoHigQn/ztv14LnbjySoHkrZKo2lIZD2PZ5+1zPd7exwohx3XeqTvy7jPt" +
                                                              "6bU3k3PRsZYbZFX0/3kgxKLiAOI/yksH/jJr6+qhXTeRPs3zqdPP8kzfuVc2" +
                                                              "LBCPBFnVx306r1r0LuryenKVjqG8VbZ6/PlW27DqqR21wLfKNKxVhVOYAjZp" +
                                                              "JwbFlvqiYcBOpV03Sq9qIJswyBZhhNlSXNy+sKG5fcXHbdyIWgrQukrMQz/7" +
                                                              "aSy2sEHkxG2FGHtLyydOV4hvZ178M19wS4EFnG76E+FvDL65+zV2mRXUemwV" +
                                                              "uiwHrMyVGTbYuqmjqmiE74qpG/b7v5dQsCwTJlIGspHwVimDk2b68VmVaJPy" +
                                                              "Z+mFxxmdS/vBHnnNh3d9fxVXa2sRp3Hon/nSlYsnxy6c40BA1UvQ4mIvTfnP" +
                                                              "W7Qy6JikunEM5JMNX5h4/93BHUEzD6ujTS5noV6tk4hA2kMH9xcw2GleM+Gc" +
                                                              "1z1S//PDTSXrAXl6UUVWkfZmcW/S633lRjbhshvnQcXxRdNo/gN/Afj+TT9q" +
                                                              "LHSAG01Tt/m4MN9+XYCciM4TFFgEXcZHnyT5fIQ2Gcgd05jYj5SmvCNOWFJu" +
                                                              "FEInz+voQI/GxiXbExqsWBs1PSF68wBTbGkRgKH/G15XbILvjMnljMVllHEZ" +
                                                              "45Lso81x2y7q3Gk0r1NO+Dei/z7IlX90EuU/RptvQj0Byod8QFJYMQd5HR0/" +
                                                              "5mj/8Geh/RxBjXmvHTTjnpn3mMofAMXzp+orZpy6900WQO1HuhoAvVRWlt05" +
                                                              "oatfpukgCROvhmeIGvsZJ2hGkTwCSkveYUf/Hqc/DWrx0xNUyn7ddGcJqnLo" +
                                                              "gBXvuEmeJKgESGj3vFaghuOpcS7gyi5MNTLtT7+R9u0l7uKaIg97zLbQIRs1" +
                                                              "Ae7CqU39+67d+Tgv7kVZGBujXKoBE/g7g50DtBblZvEq29h5ve6pyg4Lwxr5" +
                                                              "gR3Hme0ytx6wTI3e+Cxf5Wu02wXwW+Mrn/vVwbLXAX23oYAAJe22/CIip2Uh" +
                                                              "VG+L5GMf5EusJO/q/O7o6iWpD99mZZqJlXOK08fFS6d3vHFk5jiU7tW9qBQy" +
                                                              "Rpxj1c26UWULFof1GKqVjJ4cHBG4SILsAdY6apwCrcSZXkx11tqj9GmIoLa8" +
                                                              "9+wCD2pQ0o5gfa2aVZImNFc7I55XdiuNymqab4Ez4koBHqDNQzkO3CXxSJ+m" +
                                                              "WUBe9QeNOemDhXGEts+zLm1+8V+cZzoT6BoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
