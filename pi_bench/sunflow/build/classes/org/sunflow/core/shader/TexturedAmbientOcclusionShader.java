package org.sunflow.core.shader;
public class TexturedAmbientOcclusionShader extends org.sunflow.core.shader.AmbientOcclusionShader {
    private org.sunflow.core.Texture tex;
    public TexturedAmbientOcclusionShader() { super();
                                              tex = null; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            tex =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  false);
        return tex !=
          null &&
          super.
          update(
            pl,
            api);
    }
    public org.sunflow.image.Color getBrightColor(org.sunflow.core.ShadingState state) {
        return tex.
          getPixel(
            state.
              getUV(
                ).
              x,
            state.
              getUV(
                ).
              y);
    }
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
      ("H4sIAAAAAAAAAL1aecwsWVWv9739zfLezMDMMDL7A51p/Kqreqkuh2W6q/eu" +
       "3qq6qrpL4VH70tVV1bV0LTgKGISIwYk+EBOYmAiiZFhiJJoYzBijQCAmGOKW" +
       "CMSYiCIJ84doRMVb1d/+Fpxo/JK+ffvec88959xzfvfce78XvwOd9T2o4DpW" +
       "ollOsKvEwa5pVXaDxFX83T5ZmQier8iEJfj+DLRdk5747OXvff95/coOdI6H" +
       "7hNs2wmEwHBsn1J8x9ooMgldPmxtWcrKD6ArpClsBDgMDAsmDT94hoTuODI0" +
       "gK6S+yLAQAQYiADnIsD1Qyow6C7FDldENkKwA38N/Qx0ioTOuVImXgA9fpyJ" +
       "K3jCao/NJNcAcLiQ/WaBUvng2IMeO9B9q/MNCn+wAF//1bdd+Z3T0GUeumzY" +
       "dCaOBIQIwCQ8dOdKWYmK59dlWZF56B5bUWRa8QzBMtJcbh661zc0WwhCTzkw" +
       "UtYYuoqXz3louTulTDcvlALHO1BPNRRL3v91VrUEDeh6/6GuWw3bWTtQ8JIB" +
       "BPNUQVL2h5xZGrYcQI+eHHGg49UBIABDz6+UQHcOpjpjC6ABune7dpZgazAd" +
       "eIatAdKzTghmCaCHbsk0s7UrSEtBU64F0IMn6SbbLkB1MTdENiSAXn2SLOcE" +
       "VumhE6t0ZH2+M3rjB95hd+2dXGZZkaxM/gtg0CMnBlGKqniKLSnbgXc+TX5I" +
       "uP/z79uBIED86hPEW5rf++mXn33DIy99cUvzIzehGYumIgXXpI+Jd3/1tcRT" +
       "+OlMjAuu4xvZ4h/TPHf/yV7PM7ELIu/+A45Z5+5+50vUny7e+Unl2zvQpR50" +
       "TnKscAX86B7JWbmGpXgdxVY8IVDkHnRRsWUi7+9B50GdNGxl2zpWVV8JetAZ" +
       "K2865+S/gYlUwCIz0XlQN2zV2a+7QqDn9diFIOg8+EB3gs8laPuXfweQCOvO" +
       "SoFdA554Tqa6Dyt2IAKz6rAf2qrlRLDvSbDjaQe/JcdTYF8XZMWDZyBqQCTI" +
       "9ZVogIFjSbJCH6hM5927ma+5/y+zxJmuV6JTp8AyvPYkCFggfrqOBWivSdfD" +
       "RuvlT1/78s5BUOxZKYCqYP7dvfl3s/l3t/Pv3n5+6NSpfNpXZXJsVx6s2xIg" +
       "AMDGO5+i39p/+/ueOA1czo3OAKNnpPCtIZo4xIxejowScFzopQ9H72J/trgD" +
       "7RzH2kx20HQpGz7JEPIACa+ejLGb8b383m997zMfes45jLZj4L0HAjeOzIL4" +
       "iZNW9hxJkYGZDtk//ZjwuWuff+7qDnQGIANAw0AA3guA5pGTcxwL5mf2gTHT" +
       "5SxQWHW8lWBlXftodinQPSc6bMmX/+68fg+w8R2Zdz8FPnftuXv+nfXe52bl" +
       "q7buki3aCS1y4H0T7X70r/7sH0u5ufcx+vKRXY9WgmeO4ELG7HKOAPcc+sDM" +
       "UxRA97cfnvzKB7/z3p/MHQBQPHmzCa9mJQHwACwhMPN7vrj+6298/WNf2zl0" +
       "mgBsjKFoGVJ8oOSZ/Ti+lZJgttcfygNwxQKhl3nNVcZeObKhGoJoKZmX/sfl" +
       "1yGf++cPXNn6gQVa9t3oDT+cwWH7axrQO7/8tn99JGdzSsr2tUObHZJtwfK+" +
       "Q851zxOSTI74XX/+8K99QfgogF0Adb6RKjl6QbkNoHzR4Fz/p/Ny90QfkhWP" +
       "+ked/3h8Hck/rknPf+27d7Hf/cOXc2mPJzBH13oouM9s3SsrHosB+wdORnpX" +
       "8HVAV35p9FNXrJe+DzjygKMEdm1/7AGIiI95xh712fN/80d/fP/bv3oa2mlD" +
       "lyxHkNtCHmTQReDdiq8DxIrdtzy7XdzoAiiu5KpCNyi/dYoH819ngIBP3Rpf" +
       "2ln+cRiiD/772BLf/Xf/doMRcmS5ybZ7YjwPv/iRh4g3fzsffxji2ehH4huh" +
       "GORqh2PRT67+ZeeJc3+yA53noSvSXiLIClaYBQ4Pkh9/PzsEyeKx/uOJzHbX" +
       "fuYAwl57El6OTHsSXA63AFDPqLP6pRN4ku2c0IP7wLL/fRRPTkF55S35kMfz" +
       "8mpW/Oh++J53PWMDdvm9+P0B+DsFPv+VfTJmWcN2T76X2EsMHjvIDFywO53e" +
       "H/tqkIbcsFPtbVFbWMtKNCue3Y6o3NKJfiIrmvEpIOBZdBfbLWa/BzdX4nRW" +
       "/TEARH6eM4MRqmELVm6qZgCCwpKu7ovOghwaeNFV08L2Zb6SB0C2XrvbxPOE" +
       "rM3/sazAwe8+ZEY6IId9/98//5VfevIbwAv70NlN5iHA+Y7MOAqztP7nX/zg" +
       "w3dc/+b7c1wFq0I/+x7nnRlX9nYaZ8U4Kyb7qj6UqUo7oScppOAHwxwKFTnX" +
       "9rbBN/GMFdgxNns5K/zcvd9YfuRbn9rmoycj7QSx8r7rv/CD3Q9c3zlyCnjy" +
       "hkT86JjtSSAX+q49C3vQ47ebJR/R/ofPPPcHv/Xce7dS3Xs8p22BI9un/uI/" +
       "v7L74W9+6SYp1BnL+V8sbHDX892y36vv/5HIQl3EDBtz8BDe4PC05Zci3ydq" +
       "RcKmV0jQFMiE7FtJoeeHaMstClxS6lopXxBiEa9gm66qYmFkcEttjbZogp9u" +
       "FtYEJV13PtUcdNRZoU1BpAJuiQhrtIi4DD+iiDCOR5rAKGEFx7DNil0uh0w5" +
       "kXFMUmrVCl5K8dSzN5HJMgtq7diCVqQMGVn4Arq2p71Owvdx2luMumqjNNCL" +
       "oZbCsgKzXVXuMArTE/zYkIpNoh+uZgbfSyi8QXMzxmUN1sCM+jKeGZ1mp0cv" +
       "4njGsaNusZny2BCkzkbal1sNssUIUSf2+0iv544UekkxK5hcEIY7XZZpPlH7" +
       "o/JsHlbGTtftFxMJr2lMoWZhKrGeDJV5yLebjI2Ho7hLKo43nM785QqrRTzQ" +
       "fzPgWyIl9NIlMCPs+y00UsWWrvVmcjteF0KzY3BROqq1JG/gCBVlzY/LK3eg" +
       "DJcW0xiVwpjTldmwXjDJNZE0qnbaaneZld0qmX5nKY1srogLpobXkVYwH+Ad" +
       "S+mO3d5aXixlY9Bjp3SrOrKb47Y5aaVRRK/Xq2CMSh2RVzBUcwICoWpiB6kV" +
       "NjOlEqoDZjTsCS7JLuYLiZhWGgt+SA0Js99fWDq+puh+kyM4i4pwsx7zg7TH" +
       "YAKQoFhx0P5aU33Zxxp9OpE6JXyctlWNkptD3+DWnTVSFRqVGe4lg6BcTx00" +
       "FN2BOfMX8FhbDIrDRjqhO2NyzBtLdYkzDCVtiO6gOrb5WrO+IoJE7wiInASJ" +
       "xQxbVZ3VewaBMHGt0+pP0mnD1aeLhtAmiusBNeVXvkyjw/K0yPNUT3R0f0oz" +
       "IzaapnXOCIV2ImrL2mhgLPtyDfZW6KIwibUCcNyFY0jjBbOkKBQ2XU3QajFG" +
       "U+5Cb/bqtfZik/Ax4Sm4RCSDVqM5IeIWuQrxQlX1VrKCzudxq2iUN9MmIZZa" +
       "5dWYBvutydX8qoJWg3IkO4g3n/WXlUm1Xkmxnq5UGcyLJkRALmmUI4ecmNRq" +
       "iawqY61WoImBsAkoV5i6rIYZ69aclry13xqPCo7eazIVck2lbGumzhN8XmEa" +
       "Uq3P0awhm4Q80uyAKjADu+oxhW4tYii3NWxM2Mgb+645tzlJKiYVOB0vBw7h" +
       "VZ2uV0Xoblomi/O+0hbJpaiFcVkamgDvY60NXLnJiaOkiJC0MZOo0bTsepQv" +
       "4iS67Bh8wNtEv6M25GWTo4i1ocytXjtm+j0miWhWh63EHHICbMN8X8KL9mxI" +
       "GYu6aDlUY9rr1lBh4U6b/nrGBmJgVWB5M0VaXN0fcJHHzKclrFFI8XIhhrmR" +
       "AeOmX6iOenqnhlkVpKk0sNpIW/TqjYZUSue1WClhps0xU8l0WwVWk1ui0KL1" +
       "9oaqDMcjrTCwEF/kdUHi5jiNtBl7SQTcoMexlm5VZ61EawP065c4nFk6jFUN" +
       "uHHVawtpr8O7LcZuFhlz3rSsQWBS42bKDotIojbW3NTnC2OrWjSpWnVC8sli" +
       "jMHYoMu2mCa/6AYrpt1rBGYXHWiY0y/xscYZvhWMbQ9xyqHdXC2VaX22Ntnh" +
       "ikgNvqmX9KhuiDxCAUiL4AnsEQ5TCXHdqUs9Ry9P6yJaG2GNCWGjtXbiLn1k" +
       "0E85sxFzaL9vlpG1MBKnfbHMd8V6ANtaoDOSRPtaWGjOhU7NKqDoWkglsdqT" +
       "Grzdo5Gyp5pDv4uhNg/jNXYilVoVXlBJpF4bt+RNqJl1y6sITbbszAPSGU6d" +
       "7maTjpr9uFqWS9LIbBs61w7CaFlG8Xqnq03NZhpVa5IyUfFBQVUM241n6w7H" +
       "FS3HUAfhMmTGeJ+iWzYvYnyx67TrjaDToIrwqk5sWq6LchJb10kPuIfHejDc" +
       "L0xGZb/MAAQnhBEyilUtpWFJ0ytVUYG7GBsPqc7AQgF8UIkYqYuyHUpSVCOm" +
       "GAVj0aoYwoVZr0BUGKI4WjFupHXnQyrQSHMGsBHHCk0TmAZRcCNKNtOumhKw" +
       "SpRm6+7M8KY1UbbhctlmC+iqOamoKlIfCRg1N+LFnFHiYW2i4UNU7AgNbI2R" +
       "47jigx1HrfeWZq/dISh/KI3qTbbmdHv+YOmtbQxxKqqAewilr/v4ui1S0sCZ" +
       "1BKqOaKacjyMiGQsIila5lIXdfR1h1+XnYFFFBaLOq+wQYxwpWG1IglKIcBq" +
       "GBrXhHAxMME2lrRN3wnXdH3gJWmAkNgE7O4FaT4rlUykRzswi1pFOm0Fhbqq" +
       "Fb0k6cDwfNVIzNWoXXB7U7ho1iJ9TCqmjEeTJT7tdCVbtQlO4zRs0lWUGVYK" +
       "UL1bWRTMdcdpjZgAdbFIHMQ8WYy7TnOJ2uqCD8deXcEmVIvDJ0E9FOhh36wE" +
       "GtJcsZJZ5i3KLyidVncdI1ovkDrNYUHlTDaaxXoJG0u6ryJYU5c1yV/bVFMP" +
       "fIYQ2u0SHRMD2k2rDbkuIiDjCNEq2J9nJo+vopLYKLJFfzac0yIXL6qValNN" +
       "PLDDD9VAjMoUkfKWK67FkrVRQ6yHt+J1bWgjPb0vamnJZD2NnqgTUsWKyhgc" +
       "ethyWBw0WaaI4vOkqVNqN+igvNBAG7DmibU5Pa4hk80aw0ryKgjiwbDWXaEr" +
       "mCa9JpwUif5ImM8G84SxynBNkDvhTLbwAK/PyXrID5M04aLhfO4hcKBSjjXC" +
       "U6o3nZeAe85GpUY4KCNEnR6Ehj8t0Ru53jebXdKfbgwErZNTxqsh7YWvBMqA" +
       "XUwxRhfsDWOGNqq5JjghtKM5NypX+wRSkFYdkN5NmGYNbrsrq2A3u1h5RIjK" +
       "0qVJRONrDsGP9MEqaLQT03I6vhiscEGewuFyAbB1E6txiNV7WpUQ8dKsVsU2" +
       "amlTq+KlKUIkpfnGq0aa3izizGQU2YQaERJRKhVSMvWDFUrA9U6I4x7rhvNg" +
       "swA7GLvUJgOqDiMTr4A2RnM7bg30SQujWsl4NoMTWknLQUvvSKqlcPMmjKvj" +
       "HoHpUz0q1WQCsCyzKT4p6eV1S510S44wmqGpIjVa7lhwdcIPvSoZkmwoBk2/" +
       "vE5LqlBy9UQWEtjRUjWgAmE+aCQpbUfrjuKybn+OFGpjzJuHTdFFF6ibGEls" +
       "rIrdZhqT42ZljlPlUdAxa/CyW6JSfSB2h6TRGPdEu40TXrujuYW43EBLRhTQ" +
       "BI66/IjVHXfKUSbLonLfLqoLqW8YsZboXBRVlmXOszsDuBp13RpcoisU2H77" +
       "RildI5VKF9fTWVqPx1GJHfECSevlYSIqlaU5SU2KTSt4pQzgqYNHJXIDNpyV" +
       "RTJq2i7BsrSm/CU5H4L4DrjpWIKLSSdQRdmZNuw4mjDlgaJPGHwquWvFsSel" +
       "ckJV7fWw0qWsJVNLAD1rOY0y0ZtImAOySMNVsGJMo6wZUV6ohK4yU1NrANe8" +
       "KNJaczyuCvS6z1bkaMMW+E041nB1o1qkhCTT9qxYjAdzbuqMyXW1LcBtmrPG" +
       "Ym8dlOayQMaMX3Mbps7HCwJ325vACDSVmKNSw6f14mrWwkqzzSgsSOhmY84W" +
       "FXZTB6s5pdrDIh/huoQs556iYbIxG9SnRrUxK5NCiFXhbn+mbGgVXiIiLoPk" +
       "b6i4jrwqKFMM5tXOJMCGpQrF1gmDnozxBKsEjBz33VLdABvxmGSlWFnMexg6" +
       "5j2po/IYXzXM5cAn7ciuWwpPcH2/SEcIr4wMeybNlN5kPaonnOdIi03DUie8" +
       "TzOEO2Bxy1ksm3OM7XF1uhDFi5Eujgcze2KLcL81SuFiF6O5tVQbLsAJ7E3Z" +
       "0Ux7Zafje/KLgIPnKHAozjqoV3Aq3HY9nhWvO7iDyf/OnXzCOHrdeXgHBmUn" +
       "3Ydv9cqUn3I/9u7rL8jjjyM7e3eHYgBdDBz3xy1lo1hHWO0ATk/f+kQ/zB/Z" +
       "Du+0vvDuf3po9mb97a/gpv7RE3KeZPnbwxe/1Hm99Ms70OmDG64bnv+OD3rm" +
       "+L3WJU8JQs+eHbvdevjAsvdlFnsN+Oyb+Z6b35bf/Gor94Lt2p+4mt3ZM+De" +
       "BdAjN1xa5XYAe4SX3f3uk91/lIzeftcnvXyG525z+ftzWREH0LnQlYVg+y7w" +
       "1iOeJgTQedFxLEWwD70w+WF3E0dnyRvCA7PlVnp072Jw/4Lw/8Bsp/aeifbs" +
       "8fANZsuenQxby56ulZzD87cxy/WseH8A3a0pQcMzND0gHGvvPRpwf+Aod2Ml" +
       "aMruYX9uol98JSYC9n/k9q9l2dX/gze80m9flqVPv3D5wgMvMH+ZPxgdvP5e" +
       "JKELamhZR29qj9TPuZ6iGrmyF7f3tm7+9dET2h150csuMfNKrsBHtvS/HkBX" +
       "TtIH0Jns6yjZbwTQHUfIgFft1Y4S/WYAnQZEWfUT7r6td2/1vnhzS8WnjiPa" +
       "wYrc+8NW5AgIPnkMuvJ/otiHmXD7bxTXpM+80B+94+Xqx7fPXZIlpGnG5QIJ" +
       "nd++vB1A1eO35LbP61z3qe/f/dmLr9uH1bu3Ah9GwhHZHr3521Jr5Qb5a1D6" +
       "+w/87hs/8cLX8+va/wbUpDGZ3SIAAA==");
}
