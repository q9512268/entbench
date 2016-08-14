package org.apache.batik.bridge;
public class SVGFeDiffuseLightingElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge {
    public SVGFeDiffuseLightingElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_DIFFUSE_LIGHTING_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float surfaceScale =
          convertNumber(
            filterElement,
            SVG_SURFACE_SCALE_ATTRIBUTE,
            1,
            ctx);
        float diffuseConstant =
          convertNumber(
            filterElement,
            SVG_DIFFUSE_CONSTANT_ATTRIBUTE,
            1,
            ctx);
        org.apache.batik.ext.awt.image.Light light =
          extractLight(
            filterElement,
            ctx);
        double[] kernelUnitLength =
          convertKernelUnitLength(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.DiffuseLightingRable8Bit(
          in,
          primitiveRegion,
          light,
          diffuseConstant,
          surfaceScale,
          kernelUnitLength);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+yn+ypqn/wXY1hVZVRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+zrVn33/d3ee9vbx71toS0dfd+ytWE/552Y8micxI4T" +
       "23Fsx068wcXP2Ilf8SNxzDqg0oANCRArrEjQSRtoGyqUTUPbNDF1mjZAoElM" +
       "aC9pgLZJgzEk+gcMjW3s2Pm976OqNi2ST07O+Z7v+b7O53x9Tp7/HnQmDKCC" +
       "79mbme1Fu3oS7c7t2m608fVwt0/WGDkIda1ty2HIg7bL6sOfu/DDH3/IvLgD" +
       "nZWgO2XX9SI5sjw3ZPXQs1e6RkIXDlu7tu6EEXSRnMsrGY4jy4ZJK4yeIKGb" +
       "jwyNoEvkvggwEAEGIsC5CHDrkAoMulV3Y6edjZDdKFxCvwidIqGzvpqJF0EP" +
       "HWfiy4Hs7LFhcg0Ahxuz3wJQKh+cBNCDB7pvdb5C4Y8U4Gd+7W0Xf+80dEGC" +
       "Llgul4mjAiEiMIkE3eLojqIHYUvTdE2Cbnd1XeP0wJJtK83llqA7QmvmylEc" +
       "6AdGyhpjXw/yOQ8td4ua6RbEauQFB+oZlm5r+7/OGLY8A7redajrVkMsawcK" +
       "nreAYIEhq/r+kBsWlqtF0AMnRxzoeGkACMDQc44emd7BVDe4MmiA7tj6zpbd" +
       "GcxFgeXOAOkZLwazRNC912Sa2dqX1YU80y9H0D0n6ZhtF6C6KTdENiSCXn2S" +
       "LOcEvHTvCS8d8c/36Dd+4B1uz93JZdZ01c7kvxEMuv/EIFY39EB3VX078JbH" +
       "yY/Kd33hfTsQBIhffYJ4S/MHv/DSk6+//8UvbWl+6io0Q2Wuq9Fl9ZPKbV97" +
       "bfsx5HQmxo2+F1qZ849pnoc/s9fzROKDlXfXAcesc3e/80X2L6bv+rT+3R3o" +
       "PAGdVT07dkAc3a56jm/ZeoDrrh7Ika4R0E26q7XzfgI6B+qk5erb1qFhhHpE" +
       "QDfYedNZL/8NTGQAFpmJzoG65Rreft2XIzOvJz4EQefAA90CnkvQ9pN/R5AN" +
       "m56jw7Iqu5brwUzgZfqHsO5GCrCtCSsg6hdw6MUBCEHYC2awDOLA1Pc6lMDS" +
       "ZjrMCTimdyzDiEOdtGZmBOIqAwvABs0pdrOo8/+f50sy/S+uT50CrnntSWCw" +
       "wZrqebamB5fVZ2K0+9JnL39l52Ch7FkughAgwu5WhN1chN2tCLsvKwJ06lQ+" +
       "86syUbYBAdy5AMAAIPOWx7i39t/+vodPg0j01zcAX2Sk8LWRu30IJUQOmCqI" +
       "Z+jFZ9fvFt5Z3IF2jkNwJj5oOp8NZzLgPADISyeX3tX4Xnjvt3/4wkef8g4X" +
       "4TFM38OGK0dma/vhk4YOPFXXAFoesn/8Qfnzl7/w1KUd6AYAGAAkIxkENcCf" +
       "+0/OcWyNP7GPl5kuZ4DChhc4sp117YPc+cgMvPVhSx4Bt+X124GNb86C/vXg" +
       "Keytgvw7673Tz8pXbSMmc9oJLXI8fhPnf+Jv//I7ldzc+9B94chmyOnRE0fg" +
       "ImN2IQeG2w9jgA90HdD9w7PMr37ke+/9uTwAAMUjV5vwUla2AUwAFwIz/9KX" +
       "ln/3zW988us7h0ETgf0yVmxLTQ6UzNqh89dREsz2ukN5ANzYYAlmUXNp7Dqe" +
       "ZhmWrNh6FqX/eeHR0uf/7QMXt3Fgg5b9MHr9yzM4bH8NCr3rK2/79/tzNqfU" +
       "bLs7tNkh2RZD7zzk3AoCeZPJkbz7r+772BflTwA0BggYWqmegxqU2wDKnQbn" +
       "+j+el7sn+kpZ8UB4NPiPr68jacll9UNf//6twvf/5KVc2uN5zVFfU7L/xDa8" +
       "suLBBLC/++RK78mhCeiqL9I/f9F+8ceAowQ4qgDZwmEAkCc5Fhl71GfO/f2f" +
       "/tldb//aaWgHg87bnqxhcr7IoJtAdOuhCUAr8d/y5Na56xtBcTFXFbpC+W1Q" +
       "3JP/Og0EfOza+IJlacnhEr3nP4a28vQ//ugKI+TIcpXd+MR4CX7+4/e23/zd" +
       "fPzhEs9G359cicYghTscW/6084Odh8/++Q50ToIuqnv5oSDbcbZwJJAThftJ" +
       "I8ghj/Ufz2+2m/kTBxD22pPwcmTak+ByuAuAekad1c8fxZOfgM8p8Px39mTm" +
       "zhq2u+od7b2t/cGDvd33k1NgtZ4p7zZ2i9n4t+RcHsrLS1nx01s3ZdWfAcs6" +
       "zBNTMMKwXNnOJ34yAiFmq5f2uQsgUQU+uTS3GzmbV4PUPA+nTPvdbXa3BbSs" +
       "LOcstiFRu2b4vGFLle9ctx0yIz2QKL7/nz/01Q8+8k3g0z50ZpXZG7jyyIx0" +
       "nOXO73n+I/fd/My33p+jFIAo4Zd/t/KjjCt5PY2zopsV2L6q92aqcnkiQMph" +
       "ROXAomu5ttcNZSawHIC/q73EEH7qjm8uPv7tz2yTvpNxe4JYf98zv/KT3Q88" +
       "s3Mk1X7kimz36Jhtup0LfeuehQPooevNko/A/uWFp/74t59671aqO44njl3w" +
       "XvSZv/6vr+4++60vXyUnucH2/heOjW6NetWQaO1/yNJUL6/HSeIYwwJTKVfR" +
       "Gp628GRAV4rESJR9EsfRiEpDBUuwAZOkeGVY0Ss6jlTKUjlN61Kfo0dLAS/6" +
       "/hj1+oZF2m3OJmRPjkRH2WDigulzxa5lL52FbHLDhcEJ8dgbzP0ezJdSNY0b" +
       "OhOPGNaWdUOkEKRJIc3KqgBXDIWaBHV6sCmONHZAsUNnMRogA7coYqG44GNB" +
       "wezGVC6YDFtFjVoVhqOO0xx4A68uU9FMtkkUK5iitbGnKikQRavcp4loOiL4" +
       "gUKJa86qzedOe1nHFnqKieFMrlsDn0bRCSdRU5RTKI0bDHhRkIg61xJClJ1G" +
       "VtinvErRKfbTudobU/TCqVFx3E8ZfYC4ZtdxJpNJaJlLi610q6kle1VPnnML" +
       "saHWFZkom8sa7Quyyi6WOjsreDgwfWNqxoMJ3akpDOXSVcQVgxkpOX26uFlU" +
       "UsTHSKyo9SsERSsxYnBBX/SM0ag+s8zYQ9YmW0qkBPMaqIehUinoifaU0WmW" +
       "imy9IsQdd1wU2AVXTlCMg0uDDp5awaDkOMOmRNPsqFyZFnA50cYBKoqYvagu" +
       "F6WiNGQaZbg2HQnL+ZJ2WDYyyzVs1k1GojWlOxwv9flB1LO9hcrWi3KPmRIU" +
       "K4YDmylziiZxdtChW0av0bAwTZ9S0xVRmggwOpz2I2lRt2J7sSabY1QykIkj" +
       "9BPcSSKtXBSwlZwa8/aa93Da4RZUTA7dFDV5uu9YidqVUDZuNGYq6mBLrc9z" +
       "c6wmy57Y80Z4sU1YgViMuuysXxfRCBv0Rqg3nnNwgJGOvKbJaWrS3dmGbSm2" +
       "SY1YLtLWrNLysbBKWxN0qBZXaWswcYc1OBjVnGEv0ksyTgizNB2wAqnAuj8f" +
       "dyWraNU5guNaw4Ti8JLS42OmjHllvDvqmeURNidgxiTpQk0ppz1k6aPSuNt3" +
       "JJiYLUSzPfSRMA42aw0RnXYg0/hiWMF6SpUJo5rdqigEUqq1EstZyW22M5bV" +
       "NdhTyQqcbGhmwZexMV1tL/tYhZZGWC+QBsDJnODQMcEuEsriNy3ZWzgITCYt" +
       "YUQ3Ugwj6v2KtPHtLr9sSUuruSwGLlwdkuNlux3Ls2HFHEc+v1qhy6kE+9VK" +
       "t0sKzUEL18nlqDAcwtjAZef9qj3mEpPXesU62fYpkP4MOuiw624Ui5uiiAik" +
       "aBakFoV7ylKe4732iDCkVtHmFzThDOd4I+iXYkFo++5CsrjU7rQwmeqNySHG" +
       "FUfTupfCzYpfk1YwZQktYu5I5gI1x9bAjWLL46kNrgHI8WMYo6ruGB2aUy+K" +
       "Va88YxWLmEUsMxMJhyAXWhS3pkLbGAqS0g7b3V5bnRZb1Jpa08uiUm7w5joi" +
       "qfYCN6mUaKfTwUBbzVKh3gChAi/6daGvVBGeWxYio72kJLD28b4UdAaLsMqI" +
       "U3nZXcthfYgQI6e2KRZNLl375nBcGNd0otNKRNKfTEUnKKriYGN4vqPzo2p7" +
       "WsfUgG3qllMzUhaR4gFbnBoTU+hN3XQyXfhCS8fTOjVk6q2lVkE1x7LphpMg" +
       "DbhGkz5aESd0JfE3lKOz/FDqSCVUafHaooaKZLPH9IUaQPK4sWKlqisOiFG9" +
       "Q83jlszYwVKzLL0sEB10qRWpaiTQMV+NiZrD9yrtho7PFH2yCtctEeGSYak5" +
       "SJNZTYXDCOBRRUzN7kxKZ6RIYfymU5wnkWvA8bITN6yGK6Z8o73g2dk8QuYt" +
       "dYwoeCyngqmX4kXSHumwQTVJjZlMkLDTVEOuvQ4isTWRKzFa1lvEWi0ZujEZ" +
       "lRsFWF/VBmVqXDNZzuCKA9tuN6cbw2crXJkyaUGMmRA1bQ6lWXMZm41Rq48M" +
       "uBDr20qnVbBXaXM1YWDDnlrNNtqeF4dzGmjl9RSm3CSHK7IOB0hZ7YxNSxS8" +
       "UlmPnUEHceSG04uY7qK8NgpjQ58wnAagSeLaaKvsTzcsP2OIQrWTtJCo1dDg" +
       "ngivOl6C2PMJSXJwFTZ69lIeccVVN+il4tBY8VZHqSnGxnUYPUKV3ojUSQxg" +
       "ZmOcrh2uWJFCaQxMFzvmiqsskW5lhLd0uuu3AehR3TBMGwscI4WSAjdMdRWx" +
       "heqE6LVh2RwCfFHnFWfkCX6LbnQ3a5IGmxxTsdShtiRwxwQBZXnrVd1pDSd2" +
       "Wq8zyw0aT4buKui7KBKt3E48WOgSMRmFzbavbiQPBFCarOr+jAZyp7KBssRq" +
       "gHGbZrkTwHXKTpth1S158cYLSwbKsOjciDsVOEXmqiXJ9YKwaRdKQkct+FI/" +
       "8dxA7JCUbSj2bEFrG9IsIOUKD/IcvVG0V3G/VV6vvIbS7VQaRtqdhorXDEZ6" +
       "pRku50ZtAxeQBjXjoxlCjVFtLQnMXKg2FSEa1Ef8VKhX23MgnDtHFo0lMvcE" +
       "jB8RQhwqlNQp0z1GIdsz1JuuDaWlNuv4uhNwAb1s6+txPAjUEhZ1Eb2mzIny" +
       "RrI0rCMuvHpl1F8W6VlH0tV2ojZ6s3YoEwXC84uMgvN02EWrSKMpTeTNPCl0" +
       "ECTRGz5SKIcGPKyAFSSHLaw0Wc9L07q5acaCWB84YYz48xVL9eelxE44FhHT" +
       "Lhk0pmPKY0VsuSDnpSGBRJSCj8Yb1muvOzFXr3oL3OgkKFH0RGUuse223YLj" +
       "pI/2fKHEVUl+wddgfD6d9v1WsJqi+qib1DmOL8MlNMXJ1MfU4nLQaLY4d17l" +
       "ilpZIHVEd+ZpiCkVbrxgBHVONJDGwEgKlCdyI7Ni22S4AkGtyxiuW0ajacJd" +
       "s7ew+zOrVh4j+Crt1Utht6IzqUhRhMcS5R5JoFOGEfpcAW86CICBsJ+mfG0F" +
       "L1YsSNDWRULzVTqahF6nVMerNlfmG3q/TCYMMmaaBYpZ1UqdQqUxLQeMmcSw" +
       "VkXWdYTYMEN3wMAFTK4ZDG+X6wPSMmJJt2hdLMwTFrbxXqlu9JUSPQN5YX3T" +
       "mDB8r7GuxBYSdoseL9c3zRlC43RVayeOrAFkR/F2oI5wpTbliKICl5bNZoGJ" +
       "SpPiqEFIo864xvPOmFgPN26lHQRCys2SVYWqouQqlTx4ZsPEZF5Ys1Uci6bm" +
       "iGZEuVTo2wkPnNIZlnkT87TJerMSiKjcYckG7TCNtiehgym5GAgIWyriPJNU" +
       "yh2K6XdIRS60gp4siTCLcW6CLaRqrVRapzVk3VHg7niymoOtr5U41NJfhnpp" +
       "MtcmOCf1B1o6Ru3eADdSt57w9GA81MZ4gcTKjUGpyjfpDe6iw7G/jDl4Eix4" +
       "jBZr6hIdrHomxtvYuMWRIaLwpoeX5kO2sWpp1cQTqmilJhRFvjaekJVkXIuQ" +
       "uMSkNr4ijVavs0rWdY+q0uUKVqtrm6GnUhVmNezGqN0f+HV5CvaSlhpYC1sG" +
       "MCSLJV3xltGyUHcUPmxMSFdDA4yNyovCqN0psg2CJijTS2szMe6UBLHKKAli" +
       "rIbAzomMcPIoMavjtd/xEdcqlKsOI/Q6lU0Xx8ssFXRsx2swJuK7K0HbGKuJ" +
       "tKo30ZKO06G5CtpNozuoq07PCIowxYzgirvyUKHllEjV7Y2lkqVIlTFBDmmn" +
       "0hsvMRPRtZkFwn1dj4ed/kyyUsrjG6ahuNMyNnHllb+00vqQNi25yaqEMyWG" +
       "U5GRjT69ZMZxWi7wNX+4ltR0TrW6UVPnY7ZmpRLerPbBRo6nIwpNC0tjI66n" +
       "TKPKtVbNRbVQ2LiFjb904fVkWjIFSWBn4CXrTW/KXr/e+sregG/PX/YP7nXA" +
       "i2/W0XsFb37broey4tGDA8L8c/bkXcDRA8LDUyMoe5u971rXNfmb7CeffuY5" +
       "bfip0s7eadskgm6KPP9nbX2l20dY7QBOj1/7rZ3Kb6sOT4G++PS/3su/2Xz7" +
       "KzjbfuCEnCdZ/g71/Jfx16kf3oFOH5wJXXGPdnzQE8dPgs4HehQHLn/sPOi+" +
       "A8vekVnsfvAU9yxbvPr58lWj4FQeBVvfX+cwM7xOX5wVbgTdMtMj0lNlm94T" +
       "vXcYLt7LHRQcZZo3LK7UD9vTD/u/0e9cTnBu/xDr0WvduWwvVvYua/ep78yo" +
       "1xV1V/Oc3b0bmKzr6X2Ch65gN1tFu3gg+6alhrSn6fuUxSsoszCV19Gu5chg" +
       "/kB3NT3IDrd3McuO9GB/4GvyQ7CMcKYDKVhdBdEzs/Vy59hh0PGgZ+V1vpIu" +
       "q380+tbXPpG+8Pz2rEeRQz2CCte6Q7/yGj+7dnn0OldHh7erP8Df8OJ3/kl4" +
       "6/5avfnAtQ9knnwYPOSea8mTrt3X9dbDE2tKzvs+mPN653UC88NZkYLAVANd" +
       "jvSt8bK29xwG5jteSWAmwK0vewOXXSfcc8UfAraX2Opnn7tw493Pjf8mv4Q6" +
       "uGi+iYRuNGLbPnr6e6R+1g90w8pVuml7FuznXx+LoLuvEbQRdHZbyXV4dkv/" +
       "8Qi6eJI+gs7k30fpfj2Czh/SAVbbylGS34ig04Akq/6mv++j5rVWUEsJo0BW" +
       "I2C7q5osOXUc/A+8c8fLeefIfvHIsVjM/7ixj8gxsxfyLzzXp9/xUv1T27s0" +
       "1ZbTNONyIwmd217rHaD6Q9fkts/rbO+xH9/2uZse3Y/q27YCH2LREdkeuPrF" +
       "Vdfxo/yqKf3Du3//jb/13Dfy0+v/AbTOeRhRIwAA");
}
