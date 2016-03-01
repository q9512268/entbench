package org.apache.batik.bridge;
public class SVGBridgeExtension implements org.apache.batik.bridge.BridgeExtension {
    public float getPriority() { return 0.0F; }
    public java.util.Iterator getImplementedExtensions() { return java.util.Collections.
                                                                    EMPTY_LIST.
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() { return "The Apache Batik Team.";
    }
    public java.lang.String getContactAddress() { return "batik-dev@xmlgraphics.apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "The required SVG 1.0 tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAltGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGCircleElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGClipPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGColorProfileElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGDescElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGEllipseElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeBlendElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeColorMatrixElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeCompositeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncAElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncRElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncBElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeConvolveMatrixElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeDiffuseLightingElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeDisplacementMapElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFeDistantLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeFloodElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeGaussianBlurElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMergeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMergeElementBridge.SVGFeMergeNodeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMorphologyElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeOffsetElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFePointLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeSpecularLightingElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFeSpotLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeTileElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeTurbulenceElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFontElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFontFaceElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFilterElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGHKernElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGLineElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGLinearGradientElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMarkerElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMaskElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMissingGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPatternElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPolylineElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPolygonElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGRadialGradientElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGRectElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGGradientElementBridge.SVGStopElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSVGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSwitchElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTextPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTitleElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGUseElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGVKernElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSetElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateColorElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateTransformElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateMotionElementBridge(
              ));
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        java.lang.String ns =
          e.
          getNamespaceURI(
            );
        if (!org.apache.batik.util.SVGConstants.
               SVG_NAMESPACE_URI.
              equals(
                ns)) {
            return false;
        }
        java.lang.String ln =
          e.
          getLocalName(
            );
        if (ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SCRIPT_TAG) ||
              ln.
              startsWith(
                "animate") ||
              ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SET_TAG)) {
            return true;
        }
        return false;
    }
    public SVGBridgeExtension() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "49tjciM8Xda8u0Zvci7VPGb9LE/bL2hxnKBKMHkpNkVD1u0zs8v0E7ds+hja" +
       "FIRnozX/jaM3PZeqxzxf5pFlRv4ji3V5zYY/nQeol2jxPEEVBo7D8QsyGCHO" +
       "V8UGWszlCAkEFQ5osuRA98ItQ1dHmyhNHLXsPzp66HKp5oeujkI3OF8MSFoi" +
       "sIwnKWyw1/MAdZEWZ4E6ZXPpVkgDZdHSZNK9LrA8wJVENU3BgnqzLeh3o0c0" +
       "BRte9qUjPWZPyPrLg1/Ti88eqiodf2jdn9jFV/oqvQKOCbGkorjSW3eqW6wb" +
       "OCYzGCr4TYTOvi4RND5HGALb8Bc29Xe5/AcAn1ceknP27Zb7K0Hljhx0xV/c" +
       "IpcJKgAR+npFH2Fb43f2KV/2DQIDe9zNwE6ruC/PaGLC/nKyE8xkp5X/nDy0" +
       "avW2awuO8Ms7URGGhmgvY+CYwK8I06fiaTl7s/sqXjnrRuVzZTPsFCfj8tA9" +
       "NxYDEEnsom2i5zbLbE5far11eNGZ13YXX4TkbD3yQUjWrXf94cORak3pScjN" +
       "14dHOhD1CAa7aGst/3DT+X++7atltzOIH6Ea8mlExL1n3umM6fr3/agshIrg" +
       "eIZTvaicLaIuLA4YGeer4qiWVNP/TlXS8BRoesKQsQAdm66l97oENWWfIbPv" +
       "ussVbRAbS2jvtJuxnnuEpK67WxmymC9jijTEWiTcoevWdafvZYa8rrNVeIMt" +
       "5P8BVRgGz1ceAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeezsxl33e0lezua9JD1CaNMkfQGSLT/vem8eR7221+td" +
       "79rew14baOprvb7vXa8hHEXQClApkJYitfkDtaJUoa0Q5QYFEDdCKlScglYc" +
       "olAK9A8OUa6x93e/o6oSWMmz4zm+M9/rM1/PzAufhe6II6gS+M7OcPzkQM+S" +
       "A8tpHiS7QI8PhnSTlaNY1zBHjuM5KHtGfeKjl//18+9cX7kIXZKgh2TP8xM5" +
       "MX0vnuqx72x0jYYun5QSju7GCXSFtuSNDKeJ6cC0GSfXaOjeU10T6Cp9NAUY" +
       "TAEGU4DLKcDoSSvQ6RW6l7pY0UP2kjiEvgW6QEOXArWYXgI9fpZIIEeye0iG" +
       "LTkAFO4q3nnAVNk5i6DHjnnf83wdw++qwM/90Juv/MRt0GUJumx6s2I6KphE" +
       "AgaRoPtc3VX0KEY1Tdck6AFP17WZHpmyY+blvCXowdg0PDlJI/1YSEVhGuhR" +
       "OeaJ5O5TC96iVE386Ji9lak72tHbHStHNgCvrz7hdc9hvygHDN5jgolFK1nV" +
       "j7rcbpuelkCvP9/jmMerI9AAdL3T1ZO1fzzU7Z4MCqAH97pzZM+AZ0lkegZo" +
       "eoefglES6JGbEi1kHciqLRv6Mwn08Pl27L4KtLq7FETRJYFedb5ZSQlo6ZFz" +
       "Wjqln89Ovvod3+QNvIvlnDVddYr53wU6PXqu01Rf6ZHuqfq+431P0++WX/2L" +
       "b78IQaDxq8413rf56W/+3Jve+OiLv7lv86U3aMMolq4mz6jvV+7/+Guxp7q3" +
       "FdO4K/Bjs1D+Gc5L82cPa65lAfC8Vx9TLCoPjipfnP66+G0f0j9zEbqHgi6p" +
       "vpO6wI4eUH03MB09InVPj+RE1yjobt3TsLKegu4Eedr09H0ps1rFekJBtztl" +
       "0SW/fAciWgEShYjuBHnTW/lH+UBO1mU+CyAIuhM80FeB5wlo/yv/E8iG176r" +
       "w7Iqe6bnw2zkF/wXCvU0GU70GOQ1UBv4sALs3/7K2kEbjv00AgYJ+5EBy8Aq" +
       "1vq+ElYiUzN0eMaTvTJHZInuxUACB4XRBf+/w2UF91e2Fy4Axbz2PCw4wKMG" +
       "vqPp0TPqc2mP+NyHn/mdi8ducii3BHoajHmwH/OgHPNgP+bB9WNCFy6UQ72y" +
       "GHuvf6A9G+AAQMj7npp94/Atb3/iNmB4wfZ2IPqiKXxzoMZOkIMq8VEF5gu9" +
       "+J7tt/PfWr0IXTyLuMV8QdE9RXe2wMljPLx63tNuRPfy2z79rx9597P+ic+d" +
       "gfBDKLi+Z+HKT5yXbOSrugbA8YT804/JH3vmF5+9ehG6HeADwMREBjYM4ObR" +
       "82OccelrR/BY8HIHYHjlR67sFFVHmHZPso787UlJqfL7y/wDQMbXoMPkjNEX" +
       "tQ8FRfrKvYkUSjvHRQm/XzML3vfHv/d39VLcR0h9+dTaN9OTa6fQoSB2ucSB" +
       "B05sYB7pOmj35+9hf/Bdn33b15cGAFq84UYDXi1SDKACUCEQ83f+Zvgnn/yL" +
       "93/i4onRJGB5TBXHVLM9k/8DfhfA89/FUzBXFOw9+0HsEF4eO8aXoBj5y07m" +
       "BpDGAe5XWNDVhef6mrkyZcXRC4v9z8tP1j72D++4srcJB5QcmdQbvzCBk/Iv" +
       "6UHf9jtv/rdHSzIX1GKlO5HfSbM9fD50QhmNInlXzCP79t9/3Q//hvw+AMQA" +
       "/GIz10s8g0p5QKUCq6UsKmUKn6tDiuT18WlHOOtrpyKSZ9R3fuKfX8H/8y99" +
       "rpzt2ZDmtN7HcnBtb2pF8lgGyL/mvNcP5HgN2jVenHzDFefFzwOKEqCoAhyL" +
       "mQjATnbGSg5b33Hnn/7yr776LR+/DbrYh+5xfFnry6XDQXcDS9fjNUCsLPi6" +
       "N+2teXsXSK6UrELXMb83kIfLt9vABJ+6Odb0i4jkxF0f/g/GUd76l/9+nRBK" +
       "lLnBQnyuvwS/8N5HsK/9TNn/xN2L3o9m10MxiN5O+iIfcv/l4hOXfu0idKcE" +
       "XVEPQ0NedtLCiSQQDsVH8SIIH8/Unw1t9uv4tWM4e+15qDk17HmgOVkCQL5o" +
       "XeTvOVH4U9kF4Ih3IAftg2rx/qay4+NlerVIvnwv9SL7FcBj4zLEBD1Wpic7" +
       "JZ2nEmAxjnr1yEd5EHICEV+1nHZJ5lUgyC6to2DmYB+n7bGqSOv7WZT51k2t" +
       "4drRXIH27z8hRvsg5Puev37n737fGz4JVDSE7tgU4gOaOTXiJC2i4O964V2v" +
       "u/e5T31PCUAAfdh3E1feVFAd3YrjIsGLhDhi9ZGC1Vm5itNynIxLnNC1kttb" +
       "WiYbmS6A1s1hiAc/++An7fd++sf34dt5MzzXWH/7c9/9PwfveO7iqaD5DdfF" +
       "raf77APnctKvOJRwBD1+q1HKHv2//cizP//BZ9+2n9WDZ0NAAnzh/Pgf/tfv" +
       "HrznU791g/jidsd/CYpN7v/EoBFT6NGPrkkrYbvIMmHF1DtKo9M1Rj2YJAlm" +
       "ZCjxjHB6FuLS41qTyBlcEsOZrertJG92+Hba2aTeABEX9sjuDWfVCRpydiQb" +
       "E39EUoYV9JBwhqUzn58OR8R2NkG8bXVI2iEn+eZ63pGFhEBWcybX22m9mSeh" +
       "saRneVqfbHA1b8MrHTjkpM6SUTg2qovhOA2HFEf1k5qCiq3WMvXE4VqUHZWo" +
       "1rZ0Mh1kVQ5G2pFVWbdH2sqZq+YuavfoCd4ndp3lWB5JrGyOlGFI2AQfK7Ys" +
       "NpxQ60ViNpZRjpxO2oulJeHMotrjJYdwB0OXCKvYWBR5ziJImqrO5j1KjnEj" +
       "lElE2GEKrvQmYReVszVvDsNKjSdFdzTg2m5oxYbjsUPGaG16rrhAqaHvxr0x" +
       "s5vxwbwXhInciYR0NJqiRGu6JRVnYKQUr/fbsdvz9bAdVrOU7dYWOcn4BK8t" +
       "qHF3EG9D2cVJNLBGoYq4i9E8WCtVWuO4qTlROXte6+2Q3raO+QQh1mhlaYu0" +
       "ZHX4cJyQ6XjJUHWeyeiEGhJzLomziTamZkRtUfXcnK0uCD9GmvZOmKRikkhI" +
       "0lkRsMLglXarHq8iryebYb+2HMqWrlmGOafwHkVvsRFR68cuiczWI17nRwy2" +
       "bacZxaUjlpw20668aLQC1F6j2MTcVcehYxmNeiCigt6bpOOAMKoUUtMtVOC7" +
       "cuwHxjqL6aUeS7ySDnPBaAycsZ2PTdTm9KY0EpVKPDN3zNhaziaWsuptR4YQ" +
       "0GhAdGm8JviYg/Vkz6VGFCXjdQnvjJyMwOozCuUmfTduMiEvthq0SHem2XqE" +
       "DpeRw9SN6UzitlRo0xwz6oitrduZTAbWUNLgKGzqCakrqUPXqAweC+rI5FIV" +
       "7gWczBKBxlDiBGdSdFSTq+thZ9Gy4U3XHBPbdNzZOrnLdyudxFszWxiLlqQy" +
       "w/Bh5AdpNsNosyFYzlr1krjdVLmRNg3d1J0PkZU4dxRJqgkzJBn1WnIwhzWK" +
       "3E6QRh1f7mpduNOzKggFj7jWWqwNpzaajvxpws3SMDPELS8Aj+VoiudIsL5p" +
       "iahz5nI7CCQ+JzfLjKTcodlfhDQWin692/PXZhUV+mEv16W54CJ6pcWxkahX" +
       "gwE2XKJGpdUPtl6Gw7Eb4rAY7Pjtoof2eV6uiSN9vVilAZd5nthj9aFg8YmA" +
       "LhpRF25HOboNsWDIVandqOdm1BibEotV06/3QqxPq9M8bjtutqarySwjY9fv" +
       "oQYqa/DGZpwWLdS29daKwcQd35QXZK8fadwCm8ZTle/udsowyqsK05Ewa9eZ" +
       "Y5aMCiTOotl2tx1zk05O4Ig7tjyxymqcunJhY7XpcmMW7fWXOQPCITKat0MR" +
       "w/CsG/cwI2hReZzLruarW2Uos+ZY3Wj9KgzXouZ4Du/QlkaIwmSn+SvXmiA9" +
       "BWmRQ5catjBvybr9XJrj9dzCTXaCbw2V1Nh5WskYZT30clmc9rd9frkJ8Jk2" +
       "CGkp7fYGrUgLa02eneet5nLJCKuxyIhutyNI4WImhR1rs5AHWV8hfX5ua6zi" +
       "wohPMMZwNLSpmJqh7WnYERFuOws3kzyZCQsLbQRre8jJ/ckkFAQ7b+JkfRoK" +
       "4zlfJSkVzxsyHjSGY5eGZ5FW6YzrS7YZsTY9rxvALJsJMpnJKa0hay8Rs7Uc" +
       "5L7gJgY+oDeD1FJTGA6jzSJOiJ5ZsQ18kjC7wcogN+iYYjd56EQrPa3PG7jS" +
       "mVsGh9RdbqEGxiKuCExewS2josPdUV/lZnFD6s4QoTPnXVIE4N3oVJu2og4N" +
       "DGvG5BQet/rikLViB+PH/Sq92rXlWO4s6vBq0alr0QKbDGa1XElavQVc6Q91" +
       "q6dm6WbS7qUrDIBgVu8M8D6TD3gmRxCSEnZOp2olG9xyQl4HSINn3Ch1WYqT" +
       "FrsR2UMoZjNM1oQwdwqkQx2/6lYaYl7LyMjZepTVrmSmZul5o6k26pOJNZHU" +
       "Tdrluj1Fn04zutMzItUIx4GpJIkSJb3dyrDccbdJM7N4EBuddjpw2l1LCJwK" +
       "Ko6R7QY3bcxqrn1cwCo8sQgFrT8YIju4G3jt+Zqj7WWjPeovEM4xkngrEztz" +
       "MI27Rn8dbGYbWldyEtv1/SBaGwrF+WGPHWiutsuolsg1RN1rd+hM7aoVY2ZW" +
       "KfDdNo61lWT1zBSeURuJJayg1cwW5DpCRmoDt+SEHdTTFTfBtHRmaduKuqiZ" +
       "brOzngliVqvIk85aVpEpCFmUcFxXK00NYOvGtGC4udJxtIJoA6RvjcCCyvIr" +
       "FOWdLKepxTpAlgk2rcbWkm0ozKDf2i43LE6uQdzc9vFqrYnhbSfJ7HZWNxxx" +
       "VZl4g4SHY8QSaS+oh2jHU5rVRtuSaqtxfwhv4+pusahnQi9IgxoTkjgq1saj" +
       "uTqyBLrmZ07Y4oIB59dqLDNvCG7GhYN+WvUblMI0fJtvCwHfXw5svTbf2tUh" +
       "47W5vlwnYM7FDdcT5Zic09IutbCm0GstmYyZ2tXQRrFw0MZmiMTWau1VJ3Gn" +
       "fighvhXOsaHeyZlOC07Z4W6Nu5FDSDhpDpdDmpNUTRX4BUKn8zkqVRbNAakw" +
       "I9rsdqN6ZVBrNLfCys7VRXfrWfWNrcJYJZeyLbMaAMFLzapUx6NOlRlJdWXa" +
       "8XNs0pQAAGzgWlVH2nBPcanFqL6oVg1ZhBvVxBE2U63PJiAq5lZwojPTSVdD" +
       "9XUPCxYOXw9ogprZeYWIxtKE64cgkFIX9NS1ltqQ83aJbgj+DLGnUw1W4Drs" +
       "DicCTSr8QLdFSdjWe81WO+qZXRmer71FDMRnRbrmj4XNHDc5C3O7zUoDnZF+" +
       "K1w07cq8baBWz20tx2OTmmDDSlrx1t5SF5b9DWq0gmxKektkiVe6HM9bqs6E" +
       "TtZpUkubmS4rkpY2g/YCXlV2dRSZdsn1KkQrMoFPxbQ9TA2ErHZ9G/VMAVX6" +
       "bE5OqRrecu3V2mqBr+b1yA1mtTBfMwy7NOeZknobFq1mOS/PbXEr9eHGql2n" +
       "s63KeK5KI+0Rg84nubdc2/U6PaVZhFw6zMBvteH2wKynJMumuSSyaWoDNHRo" +
       "ZFrLo2Aqrg0nWc0cQ+/OmnDFoh3Br9N02CaFiV3DYAKbtBl4GqmSGnqOUCcn" +
       "TSRq4mZVNaIGziNDmVhps60oB+54Mmh7Bga36ySHDPi2PTSYeTNx5snGt1XT" +
       "ceOVHMCjKgwCpcrWDNHZ3E+mTTsGcVZvYkc23EpFuF5BEBasKGvMMdx1lU9X" +
       "s1xgwaK8S/AabmZwT+Ra8bILVs3A6jS6iaWa485SkztpVdqoZptnSaVLA+yj" +
       "kXXmjXqj8cAOJjaP19JqHnc2VaKtxZW1JfepqefnS9iSx3VW0sMsz1bNoO9M" +
       "Nw3LrPPNXBRhj9N9B7EyliD4nt/GO1y8I7EBw3cWpBDnDobaRJ9r+nE6Rbsd" +
       "KuFq2sDdrScDehmzedBqDUZB09dTy6bqTL8znvV9M6a23kjYbWvwGNUkQpAa" +
       "REtasgEP1iFJG8ykyahLR2hnO+SJyaLeM7wwp/V13a+q1d400bvhwmIFid2x" +
       "EW3U4LnZ6eih6WsrxNK8rtXnYT/ccCBoVUjbj6yZUNdDobVVQOgBsDZqzMU5" +
       "szEb0wkOXBmllU5PRbpLvQmjKurVVN32WKQtKe1RdeBY66ya8bBKBepwZKDT" +
       "ihf0AUAqjfoKGfEwgnMUrnfzyZZoRSkGszJJY7A32hGdzA6aS9jDd1V5IyDy" +
       "NmU647i9mJLk2jU2YgUTt6MOVW2tTHkOvn3hOFxaXjRNeRB7sHEfW1mdBO1O" +
       "MhEnCC/2XcRs5gqtEM2VHNVq+oSUanVxuWzMbQWv77iFJUTLVbehMlPZrgcz" +
       "1ZrUGtqAWeM1DJXbMhkncB2fV5aVSltOnCRnqEGLkDuuQ2R0zaun7ri1iuqw" +
       "bMRrKjJ0SppvZFOlZSql0YZI6nrUCE2Bn7Dw3FnOOr2pr8cjLuZQzW21nG7b" +
       "JyaCsKIUdpPGMa9MUWWGWJtkmIJIMiWCUastZO7OxbqWac0JwZyrvr4RNHm1" +
       "kUTw1RRNeJ0aJ0220+OnBpkDPYCv2K8pPm+/4YvbYXig3Ew5PgGznHZRQX4R" +
       "X9b7qseL5MnjDeTyd+kWG8inNtkuHG3cfPnNzgzOHRgUuwuvu9lBWLmz8P63" +
       "Pve8xnygdvFwM1NIoLsTP/hKR9/ozqmh7wKUnr75Lsq4PAc82WT7jbf+/SPz" +
       "r12/5Ys4Rnj9uXmeJ/lj4xd+i/wy9QcuQrcdb7ldd0J5ttO1sxtt90R6kkbe" +
       "/Mx22+uONVFq47XgefpQE0/feCv/hlZzobSava3cYq84uUXdpkj8BLrX0BM2" +
       "Mv3ITHZlw+kpw+KLPT7Hl5MTkwu+0GbO6YHKAueY51cWhW8ED3LIM/Ly8/wd" +
       "t6j7ziL5lgR6GPBMuYGju7qX6NqxAcdntsfOmt1U3pa2/Iz6s9ynPv6+/CMv" +
       "7He/FDnWE6hys/sB119RKM6YnrzFOdnJyfG/kF/14t/9Ff+NR95y77Eg7y1Y" +
       "euhWgjzy3QdPtuSpRC9PYYqa7z1R6Le+BIU+WBR+KbQ/iIWO/l9ehb77FnXv" +
       "KZLvByACFIqmwBlL5sgT5n7gpTL3BvCgh8yhLz9zP3KLuvcXyfvAUgCYK65z" +
       "yGqCalqkx/E5Jp9/qUw+DB7qkEnq5Wfyw7eo+2iR/FgCXQJMLqb0Oc4+9FI5" +
       "eww800POpi8/Zz93i7pfKJKPJdD9gDNcj9XIDI7OVE9x+FMvgcMSBYr6Nx9y" +
       "+OaXh8MLZ5f/J2+9/B/eNCop/fot5PHbRfLLCXRfpBtmDLBoDqK0G604t298" +
       "UzuR0K+8BAk9dOTCHzyU0Af/TyT0UCGhbV090Hz3gNgvK2W/P7qFPP6sSH4/" +
       "ga6YMb4DcYOpHva8kUzuVHzf0WXvRCx/8MWIJQMLwfUXPIoT6oevu162vxKl" +
       "fvj5y3e95vnFH5V3HI6vLd1NQ3etUsc5faB4Kn8piPSVWbJ39/54MSj//iaB" +
       "XnMTKwKuv8+Uk/7rfftPA7Gcbw9CkfL/dLvPJNA9J+0AqX3mdJN/TKDbQJMi" +
       "+0/BkcJOHQzuz1WzC6eiz0MzKsX84BcS83GX01cgilW9vN53FF2m7GHw8JHn" +
       "h5Nv+lzrA/srGKoj53lB5S4aunN/G+Q4Qn38ptSOaF0aPPX5+z9695NH8cH9" +
       "+wmfmPSpub3+xnccCDdIylsJ+c+85ie/+kef/4vyZPR/AU9HIX53KQAA");
}
