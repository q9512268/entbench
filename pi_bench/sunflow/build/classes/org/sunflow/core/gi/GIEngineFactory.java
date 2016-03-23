package org.sunflow.core.gi;
public final class GIEngineFactory {
    public static final org.sunflow.core.GIEngine create(org.sunflow.core.Options options) {
        java.lang.String type =
          options.
          getString(
            "gi.engine",
            null);
        if (type ==
              null ||
              type.
              equals(
                "null") ||
              type.
              equals(
                "none"))
            return null;
        else
            if (type.
                  equals(
                    "ambocc"))
                return new org.sunflow.core.gi.AmbientOcclusionGIEngine(
                  options);
            else
                if (type.
                      equals(
                        "fake"))
                    return new org.sunflow.core.gi.FakeGIEngine(
                      options);
                else
                    if (type.
                          equals(
                            "igi"))
                        return new org.sunflow.core.gi.InstantGI(
                          options);
                    else
                        if (type.
                              equals(
                                "irr-cache"))
                            return new org.sunflow.core.gi.IrradianceCacheGIEngine(
                              options);
                        else
                            if (type.
                                  equals(
                                    "path"))
                                return new org.sunflow.core.gi.PathTracingGIEngine(
                                  options);
                            else {
                                org.sunflow.system.UI.
                                  printWarning(
                                    org.sunflow.system.UI.Module.
                                      LIGHT,
                                    "Unrecognized GI engine type \"%s\" - ignoring",
                                    type);
                                return null;
                            }
    }
    public GIEngineFactory() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OCOj84QPPcYQru7H6AzWjNDEVzWjmpG5F1bJmXekyuxuC61trkrH4laKbF65" +
       "pTdc25cV7v5dh8QoG9ZsH/vHT3zj1x7/DtyiHnImTM0Hd+YIRzpIy9gPvfTJ" +
       "B29/7rsfyxIQzD7sUx+0n02p9l9L43RopQOxr+oDqaqsHbgCoDjPH2R5AoiZ" +
       "tq/pmYyrmjC1hns1GvrMle/on/7e57f110k3PAEMPvLcR3+y+/Hndo5UvY/f" +
       "UHgexdlWvpnQd+5Z2EUefS0uGQb5Ty8/80e/88yHt1JdOV7DEfCI8vm/+u9v" +
       "7D7/3a/dpLC4zbD/Dxvr3+50Sl63sf/rY0uuEAnYeJ4LCl7VN+lqdYqpStyo" +
       "qqCgC7JaHeNTf4MbND+M9Tw6a4m2RjjmOBFRPqh6bDIoD6piroD1WWzUALpE" +
       "Eu2G36Ry5IzFbKU5G88LhmxECjlu+r1xc22PZ44jVRStosDTXbOT01wr8ZJh" +
       "dRhViNnUT0AysBYMkysm1oKql4zJmLcaUbQQJqTnmV6uOwpWqlmct8uCXV5h" +
       "HXq52ViDcc6uTzr5otRhlz4n9mYOzU1Har6wnnT9VWXWCysOLwd236ssV5tc" +
       "ezgXSl6sAGfayNcnPGfP3J7OrdeqqupaXG7JzeHUyetDstReFyhSY5dssytF" +
       "dp6dKjRhg5aVFycOMYiT9pyR+gEj0UmxyRqUpcaUPqxO27zTJQpzhbPNKWdb" +
       "Y1wFRRNae0E3BsRcmBGTnNZZNAUBjzF7UCLlMtAsLEIXuc2c8hVCFPOjvBa7" +
       "mmG2fU/Z9McUNlOF/Mylhvo6N2G7jldvEtTAiTcKu2pwjT4RpJr2m/VenaGc" +
       "BdkyVVqYqAVTlu2etw7m6lQvUxPDW60Xw6hPzoYUTyXzlp+s15jvzLCeVk7m" +
       "OQoXKqAixbKSn7C9dWjX1uthg5D7hDNoK25vbBRba2FTJQUznNjEMC7Hxny9" +
       "Zv2hA80693GnTzClBS/JS9/QFwM3LzVmcZP2S/Mx0XbL64URWUbYWlj0zG7M" +
       "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" +
       "/x2//cK3s8bR/wKrFcOEVx4AAA==");
}
