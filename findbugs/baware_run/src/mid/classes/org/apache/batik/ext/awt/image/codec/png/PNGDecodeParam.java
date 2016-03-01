package org.apache.batik.ext.awt.image.codec.png;
public class PNGDecodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam {
    public PNGDecodeParam() { super(); }
    private boolean suppressAlpha = false;
    public boolean getSuppressAlpha() { return suppressAlpha; }
    public void setSuppressAlpha(boolean suppressAlpha) { this.suppressAlpha =
                                                            suppressAlpha;
    }
    private boolean expandPalette = false;
    public boolean getExpandPalette() { return expandPalette; }
    public void setExpandPalette(boolean expandPalette) { this.expandPalette =
                                                            expandPalette;
    }
    private boolean output8BitGray = false;
    public boolean getOutput8BitGray() { return output8BitGray; }
    public void setOutput8BitGray(boolean output8BitGray) { this.output8BitGray =
                                                              output8BitGray;
    }
    private boolean performGammaCorrection = true;
    public boolean getPerformGammaCorrection() { return performGammaCorrection;
    }
    public void setPerformGammaCorrection(boolean performGammaCorrection) {
        this.
          performGammaCorrection =
          performGammaCorrection;
    }
    private float userExponent = 1.0F;
    public float getUserExponent() { return userExponent; }
    public void setUserExponent(float userExponent) { if (userExponent <=
                                                            0.0F) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                              getString(
                                                                "PNGDecodeParam0"));
                                                      }
                                                      this.
                                                        userExponent =
                                                        userExponent;
    }
    private float displayExponent = 2.2F;
    public float getDisplayExponent() { return displayExponent;
    }
    public void setDisplayExponent(float displayExponent) {
        if (displayExponent <=
              0.0F) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGDecodeParam1"));
        }
        this.
          displayExponent =
          displayExponent;
    }
    private boolean expandGrayAlpha = false;
    public boolean getExpandGrayAlpha() {
        return expandGrayAlpha;
    }
    public void setExpandGrayAlpha(boolean expandGrayAlpha) {
        this.
          expandGrayAlpha =
          expandGrayAlpha;
    }
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    public boolean getGenerateEncodeParam() {
        return generateEncodeParam;
    }
    public void setGenerateEncodeParam(boolean generateEncodeParam) {
        this.
          generateEncodeParam =
          generateEncodeParam;
    }
    public org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam getEncodeParam() {
        return encodeParam;
    }
    public void setEncodeParam(org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam encodeParam) {
        this.
          encodeParam =
          encodeParam;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "W17T0LMEfoz/bPgfLPT83MkuAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p73MxaBROISj7TBtQsMyH9EC25u4TTScYUxo+1uPTemeXqtjdM/Set1601Im" +
       "tSVK6pAizzF3G210nO/5sNLv4rbd2FgVoxJ3NhOE9eqNnuxwVRh1qu1JMgvV" +
       "rYNuxmN4XOWsVcpoXGuEhppjK4qUIVpXgdU5zc6jqCm3lgmG4DIul+WGRMtJ" +
       "o7F1apHSU6YreC7ac0ghbTviO2HUstoe31ixlpygy5lQqwSq2RuVuyJSqTaV" +
       "rUxQstdQBlQrhBdsi3MolUwcxHWCnsGvBbec+hs54kg1I1a4GTdh06GVbEvg" +
       "oZolMWKtyIne7+him6F7GqhNGcOr+DDwEFohTU0YL2lsPR+R8XyIT8dMXHb5" +
       "MK2l1litsZ7A2tp8PKzWN7AxKLt4uSKqEYmvaFtg3BQNlJVK0GYSWyufn8Kk" +
       "iyptiKmzZmK7KMnZdGKs7QGNbdHYX2G9imyX9a1es2G8RtZQfJV01ClRzkCZ" +
       "BC5sR7M+VUHQDZ3U4MoKbY22E1pSXbyNguG0SMMdvQrGeFDDnrTVORXTAxMb" +
       "ggEKrlEjcxrjfWpkMW1UZeprWBsoGwLtTdTIKMflPsu06x2MV9BFbxwMnXp9" +
       "1OF8bWI38MmsiZIAh56SYNhFrch+J5n34y6f6MB0sUGHNRvpRnQT0RUkomrW" +
       "F7atkOO6obqao+DcOOlSXUfvYfwwkFdxcxluw/F2Ja7FDh6anolxOkf3llt+" +
       "joqriaQJkLtcEss5j2IY49fx3mAEyfOp3UMmuJnGPHh322LtFtOD00V5zJLB" +
       "yuivuc0S6vIkvLHCcqdikhraJuZLumG3GJSoknpjCzFcvSaOeobkt3FexrqE" +
       "5kkjro8vp023amu4yGYKbjUNWidW6sQXg5ke8Jt2GBMiSSygAaCv4QtGFbvk" +
       "ck4kKNXq6f2gV6XNlZsYAwOkxQgm5pt4LLRNMHy1iucn4y3GtpbdeixKEShx" +
       "bI6nBC67LdlpBJ1WXB+ZjDtYmf6qPOyTXbSdlyu2iUat28lIpxtrZdLDY2nW" +
       "JJVanLJBpJn8vKbg85mC9nL7mLdtdeJ2Axlbdpeq0sfVZp/ZNi2vq8fkXJPR" +
       "jKWrS1QGdbaKXamu63A5akNYPVyBbojRW2jS4qJh0ih3aYemywq+QFwRjeum" +
       "jXF+0iTxalli9XAB2UKlluqtdNPfTNG1MLAaFXmZwDXPCyedpF1dCIsm25iV" +
       "t5gTCJFiUog7TUeaN8Txbr3S4MpjYzJeVERxzVDlZoMDrVmrqFV7Wvdbk41a" +
       "G417+kBbNKYTa6umqEbqM49gU0OmlHLPghswmxgqlPmr3ny4rtgIeLe2GvVa" +
       "ltKKJtsREbYyvtyYwtMJV860MbSclpdwy2cbEbcVluvhfNrl2hLGDQ3ToGtD" +
       "bFBu9xYZLjipCUZQ+oQmRDioOUiUuuqonzUNqputdL82MgQsRZEpgyQszM7l" +
       "ZstbeRuYISs14Ic20XLdWm98k5+FoWoKvai17oa6MHf6jQ7ontNWdwktl1k3" +
       "6vkZktQ9hLXqo3UwqHfwzqrroyhkCsScNzfCFrwWNCd0NFn3HAYei8MQEpTJ" +
       "hqvG4yo0xnojDu1x0IQz+g7CNdLJwORCjW17Tay9GS66YmMtWZZdnc2scTId" +
       "QY2ZlYmbpsgjPWcprcwAJ2IsTatmd8EELWOtdObj9WzbdFAoMaXGPJ2szaon" +
       "a4hs0vNw1ZUqJuNQKzXgZrrkVAQKa8nGmm+MA7Q+suhUmVcRrkKNOqqbQSta" +
       "UymaQ+HROsIw7CfyKaPP39hU1gPFrN3hjiTTQvKIV25gtmoX9WQevPdwhrT4" +
       "3Vk6sYvl2AzpsZXNcwczhO+/rknPYh2pn984tlkjX5p697X2KhXLUp974eVX" +
       "5cnnq+f3F5WpsHRP6Ho/ZilbxTqG5kFQ0rPXXoIbFVu1jhY7f+eF//ko95P6" +
       "R25gC8fjJ3CeLPIfj7749e77pF88X7rtcOnzqk1kV2Z6/soFz3t9JYx8h7ti" +
       "2fPdh+I8lGvxHnB8aF+cD52cvj6S//S566d35nPGmv1Xz4j7Wh78Vli6CEbN" +
       "7PHVz2Ja/sjqvvJGc6THCy5uvHblVpF8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3UDd56jeGo7njhIMigRfP4PoN/Lg3wCiwQmip84Sb11DPiL/2zdB/lBgb5+8" +
       "d+sF/oMz4v4wD/7jTuDOVSuoRxy/eSsE/vg+x4+/SQL/8RlE/3sefGsn8FVE" +
       "/90R0W/frJiXwPHiPtEXb72Y3z8j7n/lwXdBTwHEnFy95nxE8k9vVs18Fe1X" +
       "9kn+ypuk5l+fwfRv8uAvAdPgNKbH5Pyrm5XzOXB8aZ/pl265nOfuPiPu3jy4" +
       "LSy9E8hJX3uZ/pDsudtvVtY+OF7bJ/vamyPrubedwfjhPLgAGAdnMT6S99zF" +
       "m2BcDH6eAMfX9hl/7dbL+8QZcU/lwY+EpQtAXv7YDoc87fqI4rtuVlQYHN/Z" +
       "p/idWy7quuDy3Bk89/LgRwHP4Gqex6R8+malzHvRP9/n+ee3Xkr0jLh8Bfgc" +
       "HJYeBFISp+z+OGJZvwWe99wju7y785ug5lnVQObBBwDV4FSqxwR9w61gb+R6" +
       "3wtAXdqneunWC0qfEcfkwXAnaOeUHTNHLKmbFfR5ABjeZwnfckF3PvenzqD6" +
       "4TyY7wQ9heoxQRc3K+gzANR+3t351gqqnxFn5kG+HxoI2r3GLqMjpvLNitou" +
       "5Tsmd0ypN0nU8Ay62zxwAd3gmnSPCevdBN1H85tPA2CzfbqzWy/sJ86IeyEP" +
       "PhqW7s9b6pUMP3XE8KdvVtD3A7CX9xlevuWCfqqg8nfPoPlSHrwIaAZX0Twm" +
       "5CdvhGYCSrvyO5r8o4BHrvrYb/eBmvSlVy/c/Y5X+f9cfEpy+BHZPVTpbjWy" +
       "rON7uI9d3wlepFWjoH/Pbke3V9B5JSw9fb375sLSbSDM4Z97eZf7s2Hp0vXk" +
       "Dkt3FOfjef9BWHrs7LwgV3E+nuvVsPTItXIBfCA8nvofhqW3nZYapATh8ZSf" +
       "Ay+kJ1OC5xfn4+l+PSzde5QuLN25uzie5AugdJAkv/wnu32qV+7k223RT3ZT" +
       "eI8cN/XiRenBNzKdwyzHv6DJq6D4iPRggizafUZ6Wfryq4PxR3/Q/PzuCx7J" +
       "ErMsL+VuqnTX7mOiotB8ku3Ja5Z2UNadvWd+eP9v3vPegwnB+3eAj5rdMWyP" +
       "n/65TMf2wuIDl+y33vHPfvzXX/2jYmPh/wPtA9vB3TsAAA==");
}
