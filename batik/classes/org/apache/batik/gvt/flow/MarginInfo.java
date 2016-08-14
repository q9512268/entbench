package org.apache.batik.gvt.flow;
public class MarginInfo {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ALIGN_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int alignment;
    protected float lineHeight;
    protected boolean fontSizeRelative;
    protected boolean flowRegionBreak;
    public MarginInfo(float top, float right, float bottom, float left, float indent,
                      int alignment,
                      float lineHeight,
                      boolean fontSizeRelative,
                      boolean flowRegionBreak) { super();
                                                 this.top = top;
                                                 this.right = right;
                                                 this.bottom = bottom;
                                                 this.left = left;
                                                 this.indent = indent;
                                                 this.alignment =
                                                   alignment;
                                                 this.lineHeight =
                                                   lineHeight;
                                                 this.fontSizeRelative =
                                                   fontSizeRelative;
                                                 this.flowRegionBreak =
                                                   flowRegionBreak;
    }
    public MarginInfo(float margin, int alignment) { super();
                                                     setMargin(margin);
                                                     this.indent =
                                                       0;
                                                     this.alignment =
                                                       alignment;
                                                     this.flowRegionBreak =
                                                       false; }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getTextAlignment() { return alignment; }
    public float getLineHeight() { return lineHeight; }
    public boolean isFontSizeRelative() { return fontSizeRelative;
    }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUaC5AcRbV375O7y/3zv+SSy+USuITsAhIkXgQul7tkce/D" +
                                                              "XRLh8rnMzvbuTW52ZjLTe7cJhl+VJIpixABBIaVWKD4VCGWJaClULESgQKv4" +
                                                              "KKLFpxBLEClJKaBGxfd6ZndmZ3cmbIq7qumd636v36dfv0/3HH+PVBg6WUwV" +
                                                              "FmJ7NWqEehU2JOgGjffIgmFshr4x8Y4y4e873x5YGySVo6R+XDD6RcGgfRKV" +
                                                              "48YoaZUUgwmKSI0BSuOIMaRTg+qTApNUZZTMkYxISpMlUWL9apwiwFZBj5Im" +
                                                              "gTFdiqUZjVgTMNIaBU7CnJNwt3u4K0pqRVXba4PPd4D3OEYQMmXTMhhpjO4W" +
                                                              "JoVwmklyOCoZrCujk1WaKu9NyioL0QwL7ZbXWCq4IrqmQAXtDzd8ePrQeCNX" +
                                                              "wSxBUVTGxTOGqaHKkzQeJQ12b69MU8Yeci0pi5KZDmBGOqJZomEgGgaiWWlt" +
                                                              "KOC+jirpVI/KxWHZmSo1ERliZGn+JJqgCylrmiHOM8xQxSzZOTJI25aT1pSy" +
                                                              "QMTbVoUP37Gz8QdlpGGUNEjKCLIjAhMMiIyCQmkqRnWjOx6n8VHSpMBij1Bd" +
                                                              "EmRpn7XSzYaUVASWhuXPqgU70xrVOU1bV7COIJueFpmq58RLcIOy/qtIyEIS" +
                                                              "ZJ1ry2pK2If9IGCNBIzpCQHszkIpn5CUOCNL3Bg5GTu+AACAOiNF2biaI1Wu" +
                                                              "CNBBmk0TkQUlGR4B01OSAFqhggHqjLR4Toq61gRxQkjSMbRIF9yQOQRQ1VwR" +
                                                              "iMLIHDcYnwlWqcW1So71eW9g3S3XKJuUIAkAz3Eqysj/TEBa7EIapgmqU9gH" +
                                                              "JmLtyujtwtzHDgYJAeA5LmAT5tEvnbr8vMUnnzZhFhaBGYztpiIbE4/F6p9f" +
                                                              "1NO5tgzZqNJUQ8LFz5Oc77Iha6Qro4GHmZubEQdD2cGTw7+8+voH6LtBUhMh" +
                                                              "laIqp1NgR02imtIkmeobqUJ1gdF4hFRTJd7DxyNkBrxHJYWavYOJhEFZhJTL" +
                                                              "vKtS5f+DihIwBaqoBt4lJaFm3zWBjfP3jEYImQEPqYVnATH/+C8jXwyPqyka" +
                                                              "FkRBkRQ1PKSrKL8RBo8TA92Oh2Ng9RNhQ03rYIJhVU+GBbCDcWoNJCdZOCGr" +
                                                              "U+F+QU9KSgQYCKGBadM3dQalmjUVCIDCF7m3uww7ZZMqx6k+Jh5Or+899dDY" +
                                                              "s6Ypoflb+gAHBdRCJrUQpxYCaiGkFrKpkUCAE5mNVM0VhfWYgJ0NrrW2c2TH" +
                                                              "FbsOtpeBKWlT5aDMIIC254WYHnv7Z332mHiiuW7f0tcueCJIyqOkWRBZWpAx" +
                                                              "YnTrSfBF4oS1XWtjEHzsGNDmiAEYvHRVpHFwQV6xwJqlSp2kOvYzMtsxQzZC" +
                                                              "4V4Me8eHovyTk0embth63flBEsx3+0iyAjwWog+hs8455Q73di82b8OBtz88" +
                                                              "cft+1d74eXEkG/4KMFGGdrcZuNUzJq5sEx4Ze2x/B1d7NThmJsBGAp+32E0j" +
                                                              "z690ZX00ylIFAidUPSXIOJTVcQ0b19Upu4fbZxN/nw1mMRM32hx4QtbO4784" +
                                                              "OlfDdp5pz2hnLil4DPj8iHb37379zme4urPhosER50co63K4KJysmTujJtts" +
                                                              "N+uUAtyrR4a+ddt7B7ZxmwWIZcUIdmDbA64JlhDU/OWn97zy+mvHXgrm7DzA" +
                                                              "IEanY5DqZHJCYj+p8RESqK2w+QEXJ4MvQKvp2KKAfUoJSYjJFDfWfxqWX/DI" +
                                                              "X29pNO1Ahp6sGZ135gns/gXryfXP7vxoMZ8mIGKItXVmg5l+e5Y9c7euC3uR" +
                                                              "j8wNL7Te+ZRwN0QA8LqGtI9yR1rNdVCdv9dxP42kYwbsSykFyzBpxaQLh3aJ" +
                                                              "BzuG3jLjzYIiCCbcnPvCX9/68u7n+CJX4c7HfpS7zrGvwUM4LKzRVP7H8BeA" +
                                                              "53/4oNKxw/TtzT1WgGnLRRhNywDnnT4pYb4A4f3Nr0/c9faDpgDuCOwCpgcP" +
                                                              "f/Xj0C2HzZUz05RlBZmCE8dMVUxxsFmL3C31o8Ix+v58Yv9P79t/wOSqOT/o" +
                                                              "9kJO+eBv//tc6MgbzxTx/LCFVMFMNi9CYzZNGndf/uqYIm34SsPPDjWX9YHX" +
                                                              "iJCqtCLtSdNI3Dkn5FlGOuZYLjsB4h1O4XBpGAmshFXAjktcDWfqYksP+NPl" +
                                                              "eL+MkTJJKWAc/+3NfCL0GTFVlamgeE8R5e0aDnB+DoxwMMLHhrFZbjhder4J" +
                                                              "ORL8MfHQS+/XbX3/8VN8GfIrBKcH6xc00waasFmBNjDPHXI3CcY4wF10cmB7" +
                                                              "o3zyNMw4CjOKkDgYgzpE+0yev7OgK2b8/udPzN31fBkJ9pEaWPd4n8BDB6kG" +
                                                              "n02NcUgUMtpll5sua6oKmkYuKikQvqAD3caS4g6pN6Ux7kL2/XjeD9fde/Q1" +
                                                              "7js1PkVrYVywyJu/hXEB23OwWVXobb1QXSsYNPOTnKVt5FPHfNY5js0OPjSC" +
                                                              "zU5TAVvPUlfYsV0zBxbyzjpM3vKSJV5o2/H6gRc/+5t7v3n7lLnHfTyWC2/+" +
                                                              "vwfl2I1v/rPA5nh6UsSJufBHw8fvaum59F2Ob+cJiN2RKUw4IdeycS98IPVB" +
                                                              "sL3yySCZMUoaRauw3SrIaYy+o1DMGdlqF4rfvPH8wsysQrpyedAitxd1kHVn" +
                                                              "KE7XVM7y3JCdlMzHdVkNT4tlQS1u4+OZr7mlkKVQBOrQJNWb3/zusY9uOHBJ" +
                                                              "EKNixSSyDlpptOEG0lg/33T8ttaZh9+4mVt+dmpzB5zD25XYrOamUIavIUgq" +
                                                              "DF6Ko4uWFEF2JRfzfJhlZGZ3NLJxYGxkc/fwZm7h9t7h9rvnTPa7u1A1Cy1q" +
                                                              "C4uoBl/0rPPc7ycXNlPYZIoI5EWCkVpToP7Ihg3R3mISXXsWEi2yyC3ykYh7" +
                                                              "iZvOWiIvEoxUmxL1DmwoJs6BsxCn1aLV6iMOZ/kbZy2OFwlGakxx+rZEo8Xk" +
                                                              "OfTJ5anPmvQSi9iSAnkIfzlSXAzIx6s1XWXgMWjcJUOdz7SQUDBVywUFB/N3" +
                                                              "lsg8LnabRaXNg/nv2YHsO4U8emGDM9Cl5DgrxuX3S+QS13CpRWepB5f3+XLp" +
                                                              "hQ2+K6YypqaKsXl/iWyiL2i3CLV7sHnCl00vbAblFE0U1eXDZ6HLDotMhweT" +
                                                              "P/Jl0gsbdAkZPmQGxdh8tEQ20ZxWWIRWeLD5mC+bXtiw5wRZSiopi1P3/n+8" +
                                                              "RE7RpM61aJ3rwekvfDn1wgZXhUeGm6jXPnqyRFbPgafTItbpweqzvqx6YTPS" +
                                                              "mICEawRq7WEqC1jzYX/UxfBzJTKMa7fKIrnKg+EXfBn2woY6Bs8Mh2kSMsz1" +
                                                              "OhUmivH7og+/mWL5Pf+rJK7DWgddRyJNsFxq9TpP5+XysRsPH40P3nNB0Eru" +
                                                              "LwfjBc+/WqaTVHZMVYMz5eXk/fwGwU5wX62/9Y8/6UiuL+XsEvsWn+F0Ev9f" +
                                                              "AnnkSu80383KUzf+pWXzpeO7SjiGXOLSknvK+/uPP7NxhXhrkF+XmJl3wTVL" +
                                                              "PlJXfr5do1OW1pX84n9ZfsmH22ejta4b3dZoW45XyeeF6irmHLX9JXzWd3yq" +
                                                              "vXexeQuswqDMPP7mYK7zg/JJVYrbVv2nT6Mk5P1v5KSchWOYpwxYUg6UriAv" +
                                                              "VB/5/+Uzdhqbf0BCnqRss6qZ6uFqtVXxwXSpAqPCoCXPYOmq8EL1FjdQ6TNW" +
                                                              "hQ1km/WgimGMJsWUEQhOlzIwnRmyJBoqXRleqD4Cz/IZm4NNPQQAUMZ6nvwV" +
                                                              "1UbDdGmjDZ4rLZGuLF0bXqg+Erf5jLVjs5CROtBGFHLMorpYNF26wPpjxBJo" +
                                                              "pHRdeKH6yLvaZyyMzbngTUEXETuVtfXQOV16WAbPFkuYLaXrwQvVR9bP+Yyt" +
                                                              "w2YN5HToOSGed+fly7Y6Lp7OLXKVJdNVpavDC9VH5I0+YxFs1ltbJD8ht3XR" +
                                                              "M126WA7P1ZZAV5euCy9UH3k3+4xtxWaQkWbJ6CuW8NsKGZouhWDduc2Salvp" +
                                                              "CvFC9RFa8BkTsdnOSBMopEhBYetjx6dyEA81of2ZA95kzC/4bMr81Ed86GhD" +
                                                              "1byjW17mGX/uc5xayN0TaVl2HjU73is1nSYkrsVa8+CZX3gFJhhZ4PnhBSSY" +
                                                              "+IM8B3ab8Aojs4vBM1IGrRNyD7gZNyQjFfzXCQeoNTYcI5XmixMEGCkDEHzN" +
                                                              "mJYznzkPuM2z+Yx5xLjQqWmeC8450wI5yrZleeUO/8AtW5qkzU/cxsQTR68Y" +
                                                              "uObUxfeY9/+iLOzbh7PMjJIZ5qcIfFIsb5Z6zpadq3JT5+n6h6uXZwvBJpNh" +
                                                              "29oX2iZJtkP5oKFttLgux42O3B35K8fWPf6rg5UvBElgGwkIjMzaVniLkdHS" +
                                                              "UFduixber0IpyG/tuzq/vffS8xJ/+0P2uiCQfzvkhh8TX7p3x4u3zj+2OEhm" +
                                                              "RkgFHhhl+PXKhr3KMBUn9VFSJxm9GWARZpEEOe/yth7NWMBP37heLHXW5Xrx" +
                                                              "6xFG2gtvrgu/uakBi6X6ejWt8BuzOihF7R5zZVwVYlrTXAh2j7WU2PJD8rUZ" +
                                                              "XA2wx7Fov6ZlL/ZrujS+j3tz29t9kRu4mb/i29f+D+W5p2P8KgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9CSN/NkNm63P3rhNX7xgHhxodnD6Fe7x");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2J39/vaD+7E/tdt+7lgAKQW+fpvt+D8rkv8MBiHWk/3ZsjPfS24CWzs2oj+9" +
       "mz37MuNrR6zfWWQW22vMAWvm3rA+Sepbtyn7X0Xy35PKI6aezIJwz7nU1TG/" +
       "//F2+RXbGewBP/ae8zt34TZl9xeZf51UHgX8psU2yJkMv/N2GRY7bNwBQ+7e" +
       "M7x8m7LHiuRSUrkMGOLl9uFZFM89/HYpvgCuyQHFyb2n+N7blD1bJE8klXcA" +
       "irRunDmG5558uwSLjWX+gCB/7wl+4DZlrxTJS8DtAILk8ebmMbmX3y65l8El" +
       "HJAT7j055DZlaJFcSypXChcDlq7ODTulxxzhe2Gh8gFH+d5z/OHblBURyrkf" +
       "OLDQG7dcjwm++nYJvg9c8wOC83tPcHSbsnGR9JPK43bcP2vr9pjl4O2yLM4G" +
       "fOSA5UfuPUvpNmXzIpmC4BGwPGML+Jgkf1fH9JLKpeOD6sWp26du+uPL/s8a" +
       "y1998/JDT74p/LvyrPbRHyou0pWHjNR1T55ZO3H/QBjphl0Sv7g/wRaWbD6a" +
       "VN5zy6PzIIopvgqw567v5ZdJ5V1nySeVCyA9KWmA2XxaMqncX36flLMB82O5" +
       "pPLA/uakCAgjLwCR4tYLS9XduK+9P+SXnbsxrj4ciMrj320gToTiL98QQJd/" +
       "UToMdtP9n5SuL7/4JsX8xDebv7Q/dL501TwvWnmIrjy4P/9+FDC/eMvWDtt6" +
       "YPjKtx/90sX3HQb3j+4BH5vwCWzPn33Cu+eFSXkmO//NJ//5D/6TN/+4PCr4" +
       "/wD2dle4OzYAAA==");
}
