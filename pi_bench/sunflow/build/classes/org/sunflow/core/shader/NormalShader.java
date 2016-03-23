package org.sunflow.core.shader;
public class NormalShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        org.sunflow.math.Vector3 n =
          state.
          getNormal(
            );
        if (n ==
              null)
            return org.sunflow.image.Color.
                     BLACK;
        float r =
          (n.
             x +
             1) *
          0.5F;
        float g =
          (n.
             y +
             1) *
          0.5F;
        float b =
          (n.
             z +
             1) *
          0.5F;
        return new org.sunflow.image.Color(
          r,
          g,
          b);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public NormalShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwcRxWfO39/5Wwndr6dLyeSk/SugQaoHEIS126cnp1T" +
       "nEbgQC5ze3N3G+/tbnbn7LODoS1FMZWIotZpw0fNP6koqG2iQgUIWgVVoq1a" +
       "kFpVtAU1RQKJ8BHRCKn9I0B5b2b3dm/PdhRET9q53dk372ve+703+9Q1UmNb" +
       "pIvpPMonTWZH+3WeoJbN0n0ate3DMJdUHqui/zx2dfjOMKkdJUty1B5SqM0G" +
       "VKal7VGyVtVtTnWF2cOMpXFFwmI2s8YpVw19lHSo9mDe1FRF5UNGmiHBEWrF" +
       "SRvl3FJTBc4GHQacrI2DJjGhSWxv8HVvnDQrhjnpka/wkff53iBl3pNlc9Ia" +
       "P0HHaazAVS0WV23eW7TINtPQJrOawaOsyKMntJ2OCw7Ed1a4YOOlyAc3zuZa" +
       "hQuWUl03uDDPPsRsQxtn6TiJeLP9GsvbJ8lXSFWcNPmIOemOu0JjIDQGQl1r" +
       "PSrQvoXphXyfIczhLqdaU0GFONlQzsSkFs07bBJCZ+BQzx3bxWKwdn3JWmll" +
       "hYnntsVmHzvW+mwViYySiKqPoDoKKMFByCg4lOVTzLL3ptMsPUradNjsEWap" +
       "VFOnnJ1ut9WsTnkBtt91C04WTGYJmZ6vYB/BNqugcMMqmZcRAeU81WQ0mgVb" +
       "Oz1bpYUDOA8GNqqgmJWhEHfOkuoxVU9zsi64omRj9z1AAEvr8oznjJKoap3C" +
       "BGmXIaJRPRsbgdDTs0BaY0AAWpysWpAp+tqkyhjNsiRGZIAuIV8BVYNwBC7h" +
       "pCNIJjjBLq0K7JJvf64N7zpzSt+vh0kIdE4zRUP9m2BRV2DRIZZhFoM8kAub" +
       "t8YfpZ3Pz4QJAeKOALGk+cmXr+/Z3nX5ZUmzeh6ag6kTTOFJ5UJqyetr+nru" +
       "rEI16k3DVnHzyywXWZZw3vQWTUCYzhJHfBl1X14+9Ksv3PdD9rcwaRwktYqh" +
       "FfIQR22KkTdVjVl3M51ZlLP0IGlgerpPvB8kdXAfV3UmZw9mMjbjg6RaE1O1" +
       "hngGF2WABbqoEe5VPWO49yblOXFfNAkhdXCRbXA1EvkT/5wkYjkjz2KmGktY" +
       "BppuxwBsUuDWXMwu6BnNmIjZlhIzrGzpWTEsFrNzNM2s2LBh5ak2Ih6iGFnm" +
       "x8CziHYsnQiFwMVrggmuQW7sNzSgTSqzhX39159JviqDBwPe8QBAEkiLOtKi" +
       "KC0qpUX90kgoJIQsQ6lyD2EHxiCXAUybe0a+dOD4zMYqCB5zohrch6Qby4pK" +
       "n5fwLkonlYvtLVMbrux4MUyq46SdKrxANawRe60soI8y5iRocwrKjYf6632o" +
       "j+XKMhSWBtBZCP0dLvXGOLNwnpNlPg5uTcLsiy1cEebVn1w+P3H/ka/eHibh" +
       "cqBHkTWAUbg8gfBcguHuYILPxzdy+uoHFx+dNrxUL6scbsGrWIk2bAyGQdA9" +
       "SWXrevpc8vnpbuH2BoBiTiF1AOW6gjLKkKTXRWW0pR4MzogAwVeujxt5zjIm" +
       "vBkRn204dMhQxRAKKCgA/bMj5uNv/+YvnxSedLE/4ivaI4z3+vAGmbULZGnz" +
       "IvKwxRjQvXs+8ci5a6ePinAEik3zCezGsQ9wBnYHPPj1l0++896VC2+GvRDm" +
       "UHALKehbisKWZR/BLwTXf/BCjMAJiRXtfQ5grS8hlomSt3i6AXZpkPAYHN33" +
       "6hCGakalKY1h/vwrsnnHc38/0yq3W4MZN1q235yBN79yH7nv1WMfdgk2IQVr" +
       "p+c/j0wC8lKP817LopOoR/H+N9Z+6yX6OEA7wKmtTjGBkET4g4gN3Cl8cbsY" +
       "7wi8+zQOm21/jJenka/HSSpn33y/5cj7L1wX2pY3Sf59H6Jmr4wiuQsgbDtx" +
       "hjLExredJo7Li6DD8iBQ7ad2DpjdcXn4i63a5RsgdhTEKtA+2ActQLhiWSg5" +
       "1DV1v/vli53HX68i4QHSqBk0PUBFwpEGiHRm5wBei+bn9kg9JuphaBX+IBUe" +
       "qpjAXVg3//72500udmTqp8t/vOv7c1dEWJqSx2o/wy1i7MFhuwxbvL2tWHKW" +
       "+NUu4iwfz5C4X8HJ8oqSIKsAOnbtQh2K6K4uPDA7lz74xA7ZR7SXV/1+aGqf" +
       "/u2/X4ue/8Mr8xSiBm6Yt2lsnGk+napQZFklGRLNm4dm7y55+I8/687uu5Ui" +
       "gnNdNykT+LwOjNi6cFEIqvLSA39ddXh37vgt1IN1AXcGWf5g6KlX7t6iPBwW" +
       "naosBRUdbvmiXr9jQajFoCXX0UycaRHZtKkUIEsxHlbC1eQESFMwmyRwi2jD" +
       "ob+0tNqNp4WWBsAiLHY07EZZV0WUCdcwaLgx9l2yTj/ZiPzfmxgUan1+ETg6" +
       "hsMIoHjBTAMil3ckGCAjhZQN3YOah4oy7vTKn0gcV2a6E3+S8btyngWSruPJ" +
       "2DePvHXiNbHT9RhaJf/6wgpC0FcHW3GIYg71LHLyLNcnNt3+3th3rz4t9Qk2" +
       "+gFiNjP70EfRM7Myt+RpaFPFgcS/Rp6IAtptWEyKWDHw54vTP39y+nTYcfU9" +
       "nNSlDENjVC9tRajUCC4r96LU9a5vRH5xtr1qALJ2kNQXdPVkgQ2myyO3zi6k" +
       "fG71DlBeHDtaYynmJLTVxcjP4HBY3u/6H+EZJ/aZYv5gKeTb8N0auCJOyEdu" +
       "PVsWWhqI5VA5Jq+dF5PhlIrndCbETiySDadwgBavKcv4IVgnPtjMB/dqHo6r" +
       "WI2ck7lwpf0xuFKAxW4HfFwQukVXLrR0fuDBR8F0Wowzi7jrIRy+xkmLrVAO" +
       "gJTIGdzBccVJFPzLclI9bqhpz1MP/j88VeSk2X/6wlZhRcX3G/nNQXlmLlK/" +
       "fO7et0T9K30XaAZYyhQ0zZdO/tSqNS2WUYWpzbK9MsXfufmKvzwPApLKG6H1" +
       "rKQ/z0lrkB58gn9+su9A4PnIOKa2uPMTzXFSBUR4+z3Tjc1W0SHhR5mo/AJR" +
       "DFV2QcLzHTfzfGmJ/0iAACw+oLkIVZCf0OBwOndg+NT1Tz0hjySKRqemkEsT" +
       "4JI8+JRq+IYFubm8avf33FhyqWGzC5hlRyK/bmL/IevF8WFVoEe3u0ut+jsX" +
       "dr3w65naNwDqj5IQ5WTpUd/nK+kpaPQL0DwdjVfiL/Q74vDQ2/Ptyd3bM//4" +
       "vWgwHbxeszB9Uhl95O3BS2Mf7hFfbGqgFrDiKGlU7bsm9UNMGbfKwHwJRiPF" +
       "T2nCD477WkqzeDblZGNliao80UPzPcGsfUZBTzvloMmbKfuS57Y9BdMMLPBm" +
       "fFV5TKYzeh/iLxkfMk33YLfaFPmoBSFZTIrFz4pbHH70X19d58JLFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6acwsWVX1vre/Wd6bGZgZxtl5oEPjV9VdveYhTlVvVV3V" +
       "3dXV3VXdLfKovapr7Vq7C0dhDM5EIhIYtgTmh4IKGZYYiSYGM8YoEIgJhrgl" +
       "AjEmokjC/BCNqHir+tvfe0MmYCd9+9a955x7zrnnnDr33H7hu9DZwIcKnmtt" +
       "NMsNd5V1uLu0KrvhxlOC3R5dYQQ/UOSmJQTBBIxdlx7/3OXv/+C9+pUd6NwC" +
       "ukdwHDcUQsN1AlYJXCtWZBq6fDjathQ7CKEr9FKIBTgKDQumjSC8RkO3HUEN" +
       "oav0PgswYAEGLMA5CzB2CAWQ7lCcyG5mGIITBivol6FTNHTOkzL2Quix40Q8" +
       "wRfsPTJMLgGgcCF75oBQOfLahx49kH0r8w0Cf6AAP/eht175/dPQ5QV02XDG" +
       "GTsSYCIEiyyg223FFhU/wGRZkRfQXY6iyGPFNwTLSHO+F9DdgaE5Qhj5yoGS" +
       "ssHIU/x8zUPN3S5lsvmRFLr+gXiqoVjy/tNZ1RI0IOu9h7JuJexk40DASwZg" +
       "zFcFSdlHOWMajhxCj5zEOJDxKgUAAOp5Wwl192CpM44ABqC7t3tnCY4Gj0Pf" +
       "cDQAetaNwCoh9MAtiWa69gTJFDTlegjdfxKO2U4BqIu5IjKUEHr1SbCcEtil" +
       "B07s0pH9+e7gTe95u0M4OznPsiJZGf8XANLDJ5BYRVV8xZGULeLtb6A/KNz7" +
       "hWd3IAgAv/oE8BbmD3/ppSff+PCLX9rC/NRNYIbiUpHC69LHxTu/9mDzicbp" +
       "jI0LnhsY2eYfkzw3f2Zv5traA5537wHFbHJ3f/JF9i/m7/iU8p0d6BIJnZNc" +
       "K7KBHd0lubZnWIrfVRzFF0JFJqGLiiM383kSOg/6tOEo29GhqgZKSEJnrHzo" +
       "nJs/AxWpgESmovOgbziqu9/3hFDP+2sPgqDz4AsVwPcStP3kvyHEwLprK7Bn" +
       "wIzvZqIHsOKEIlCrDgeRo1puAge+BLu+dvAsub4CB7ogKz48cH1bsMb5w25m" +
       "Wd7/A811JseV5NQpoOIHTzq4BXyDcC0Ae116LsLbL33m+ld2Dgx+TwMgJIHV" +
       "dvdW281W292utnt0NejUqXyRV2WrbvcQ7IAJfBlEudufGP9i723PPn4aGI+X" +
       "nAHqy0DhWwfb5qH3k3mMk4AJQi9+OHkn9yvIDrRzPGpmnIKhSxk6k8W6g5h2" +
       "9aS33Izu5We+/f3PfvAp99BvjoXhPXe+ETNzx8dP6tR3JUUGAe6Q/BseFT5/" +
       "/QtPXd2BzgAfB3EtFIAdgpDx8Mk1jrnltf0Ql8lyFgis5trOpvbj0qVQ993k" +
       "cCTf7Dvz/l1Ax2+E9ppjhpvN3uNl7au2xpFt2gkp8hD6c2PvY3/7l/+C5ure" +
       "j7aXj7y/xkp47YiHZ8Qu575816ENTHxFAXD/8GHm/R/47jO/kBsAgHjtzRa8" +
       "mrVN4NlgC4Ga3/Wl1d998xsf//rOodGE4BUXiZYhrbdC/hB8ToHv/2bfTLhs" +
       "YOuddzf3QsSjBzHCy1Z+/SFvIFpYwMUyC7o6dWxXNlRDEC0ls9j/vvy64uf/" +
       "7T1XtjZhgZF9k3rjjyZwOP4aHHrHV976Hw/nZE5J2dvqUH+HYNsQeM8hZcz3" +
       "hU3Gx/qdf/XQR74ofAwEUxDAAiNV8pgE5fqA8g1Ecl0U8hY+MVfKmkeCo45w" +
       "3NeOZBXXpfd+/Xt3cN/7k5dybo+nJUf3vS9417amljWPrgH5+056PSEEOoAr" +
       "vzh4yxXrxR8AigtAUQLv4mDog3CxPmYle9Bnz//9n/7ZvW/72mlopwNdslxB" +
       "7gi5w0EXgaUrgQ5i1dr7+Se31pxcAM2VXFToBuG3BnJ//nQaMPjErWNNJ8sq" +
       "Dt31/v8aWuLT//ifNyghjzI3eZmewF/AL3z0geabv5PjH7p7hv3w+sYgDDKw" +
       "Q9zSp+x/33n83J/vQOcX0BVpL73jBCvKnGgBUppgP+cDKeCx+ePpyfZdfO0g" +
       "nD14MtQcWfZkoDkM/qCfQWf9S4cb/sT6FHDEs6Xd2i6SPT+ZIz6Wt1ez5qe3" +
       "Ws+6PwM8NsjTRIChGo5g5XSeCIHFWNLVfR/lQNoIVHx1adVyMq8GiXJuHZkw" +
       "u9tcaxurshbdcpH3q7e0hmv7vILdv/OQGO2CtO3d//Ter/7ma78JtqgHnY0z" +
       "9YGdObLiIMoy2V974QMP3fbct96dByAQfcZPvst9R0aVejmJs6aVNe19UR/I" +
       "RB27kS8ptBCE/TxOKHIu7ctaJuMbNgit8V6aBj919zfNj37709sU7KQZngBW" +
       "nn3u13+4+57ndo4kvq+9Ifc8irNNfnOm79jTsA899nKr5Bidf/7sU3/8e089" +
       "s+Xq7uNpXBucUj791//z1d0Pf+vLN8kszljuj7Gx4e3fIsoBie1/aG6u8onE" +
       "rnl1iDbgCp84sl+V6Y0yNuFxpI0El2iT42KpKjleceK0RW3UrKQKOkC7BTgU" +
       "HdGp0cOWOy52+guedMOFlyDqgKma7qpbMkbalOQ1jnNXRcHseFyITYvsiOrV" +
       "cYJtUk6DRPCKWBJR2YYZWWfbk8aqgsomWivFSqGGoIXGqDi1B6JHxh7Td50J" +
       "vyAKKK+4PXGAOAh4Q6Gtfk+eEqvIgNN1SVaXwz5lyr1puCnilfGqj3Q5SrBq" +
       "XHfDhVw4cfhOSRr2vVmnk9hkKajPPS4pNixi7DbsllLssJ3KdNC1DQJv835n" +
       "zMYW2ulNcKncJUaC5JOlVm/Z1cf8Oq4TXOy0Rr6+dDxTgBNTVSuogVuoN7Ck" +
       "BikwCEEIQopxY4TnSqjC1ybkIGRGPX8oJMIw2FB9J+yVhs2k1paLQnk+HFob" +
       "TELTaCHoo4ifWggatVoME7DBaB061YnRU2im0Q1isVe3ZuMOLw0Ymxwq9jBC" +
       "ekuyNeqOrKLPjP1R7M48fbZRSSnV6ZUsTJFuZziwRmkwNjsBUhPxXnNRwEfp" +
       "GhXXPJXIDtrjbcvS5w44GnM2kcZ8wU44Y74ZG9SKcVsuRfU7+Kapla0hN0lp" +
       "GvXCfsBMfUEeLIM2L3hcZ+g4vWIUNvhg4ph4GDaKTaTMT7rznr2oxnMcxger" +
       "SJP6/ZW9kFhMmdaL/AixNU4cpkXRm09bQ6zeHaxWmt3j9TahDs3IXXPTRhoY" +
       "1bJrs8tGWsSwduzX3dRZ9ihX8NAm3rVnpNBjGTYQNbk1CRBcmCMYxnubgPcw" +
       "rxCuzI2+HAQG212QWERydZybDxK8WdO95oDsLZc4vUKoWq8Xq9XyoJZ66Tgs" +
       "xDpiknK7nLJTpmGXcJYrtVhysdA7br9uYpEY1ueqt0CZtDzqYQo1xOiuWZDs" +
       "mV+AF6gzqyymdqroVUGrmpPJsNOrTHurjRL6BceP/DZZrJpoi3OIdLNJZvxi" +
       "kaDxiJ9Mm/NU7xEqbhVnxXKhQQUxysithi8lApuY4Xyld1RyxJZKlDmRuSVn" +
       "of1KcWHRDEJ2LU3xPSbG66Y8w1QOndqLpGH3l+JSq7JCuzgs6o7W7ZR4DBdX" +
       "blupcAw/LDc2ojWcddQBZuryrMmKM6zYjs0JXEnM+dJcpiXK7oKVcc+L1gke" +
       "TKMWP+snURV3Bja5XFg6mfrd1OMn7aDjD9JBvxSUaFyvCGaJ1KtGt+PY63oz" +
       "NYh54IyMTtLnfE2zoxFfCwbpWJuMV6k+QxvFSqMXG6sWnjBKfYRjbdOghyFl" +
       "UE1k5U1nDcTU3B45CkZVa9MqtYm10Zxh042oIEJBHrbKaX++auKV1NV9Sa+O" +
       "xE3Zo5yKmtCm61jzOKS5vuhH63J/ulmVq2OZ8tfYQEhYpYoELlnfVAzWlRKf" +
       "Ws7VahUtucvCjOoDT8dDfNFkEJmOZ90hPUgc4N+MVokmEh0Ym6LUVkTOKSYF" +
       "BiVgEAcUwhB1aYUT5oTHpqJW11Rc0iIimpM0s07lTSFyic66IA/89ZSuBpIY" +
       "dH2eNEsitumOZKwx5me+EntSPXY8MSJKuIsbE6NTxIZ8VVvSlElNZizPIx5b" +
       "7qeuhiWcEi3XYSVdknaMm6xTQspyXx+tWYyimhoGi/1lJRrEcGEeO+sxOF22" +
       "4bIRC2Q5RQsx1rXFKb3oOikZU8maXY7iWVCoS0ZFqCqM4WBtw0TTppJ2g1Ej" +
       "wZ05wTDLooUUCvVGlWuWCt2YbdlTAqMpRReNgOIXLIzTyWSmwnhz2cd6BjsL" +
       "1VFF88d13XLtcYgaVWy28EwGmxMDFK3qza5gChY1L+pwnPiB4xASWoeRzQrl" +
       "y/3FoLgqoZUNPqg1NkTNiYt8X5U1YFsjzvcKErxEkmbdoph6sUa73tBlYaIw" +
       "aCwK1c2sOmxjtYSyw8myi5vtSVkrawO0adWB0ue1xKgX0tHQLhXhZU9xwN4R" +
       "47HnoOgGrkjLGl1MZiVvjo7VSoOo9my/nBjRKNDEVrjWl3R77Styz63RRrXV" +
       "qhv4qCbIpZa3lKWZUzaqqFBhA03WJ20qxAolTApHtG7wY61SbHHFGI4to4IS" +
       "s2rdKI+I8Qo3EWaKdxKv3TUI1q4kuGIURKdhao1e5OkCPiuQ+FRZeUtsxmko" +
       "DNdKFQSJZHuy8uohHA/jmlSU23xvNV6XXDjZFI1av6NHyVqM6VLIExRfGEyj" +
       "spGoaaVZntWJXt1djUkqwIaOGI70ElWlyhHTwmpWWiuvsdqCrY1nHFwsCN2V" +
       "CkcleFaOFLje9+vrsYHb1XlYsgIHhDxH8EaLjml1WXpgl2W7tqlUCmQdrtZr" +
       "UVSZGpozkAcbc1Kgk+FyYFSlTptcxfQYQxuyPNPRWqyFRXJQxGZSl1crWpWy" +
       "ZrWwajB4wjuCG+DsVBZj25j5jeVIWHbc5myGTDeSwBKLkDKnZDtYE5bYLCqj" +
       "9rjTT+wNmxilZcsVC0g4WA28Ms/jAWbQxByptRcLDuGnTRnEU1pbN6zSZrKE" +
       "FwaTqvZamwpOsdCeaFU96JMuscQnWN+wUMnsNrGlvhgN0PlQ0MvuphZPKAfR" +
       "JK4kVNtoYVwXw42j8WM/YnqllsLExMwYiMSkwepCT4WrieY1kY5E8GiXnGu1" +
       "Ik3QG3ogOYMQLaChjvppOWyMzFJB6xiDJVND2irbr/U3YYH1hA7T0aQxzHpV" +
       "Egu9kG9vKL5FJJVyPGHQxqbgTOaSOm04g7HVag+WXLMRssJy2myW/UaVnjaE" +
       "SswSlXXoF1cY3SuZg9FMZjhTG5XszWaIpkbVVLu1YsvCFaIVCvONY/foCbeW" +
       "lkyZwOdoBFeJQnvRg4XFPK5olDIR6wNEiJq94aYtRwwX8Ly+IiscVumtCnKn" +
       "wugW6TtyU2xPjM24JciJhgsxJcVlktMcJlz2cVheEW4VxL2SZNasxFORddSh" +
       "sDVfJtROMopMbkb7LKJGLZytdxDeTVKjtvRJdlNYmzbtc9hQ603IrpziksT1" +
       "OkxKSxbZEFe6lxb7DLys1zmQwpZmQPfWQmelGdqFHSC5ZdMWBavDmhIikwaF" +
       "IjMBW8w3+ghJF/IQDserwbjET+e8l4pUox/M1Ei1qThNGMyjqW6VKPrUCE4R" +
       "yzfxSl1zGoUgamBlxiGHlFCKmP4knXXG+JQtF1J0spSKPDImdLZiuzDWY1sd" +
       "rjSS6JSYqKnatXswYmBYMym4tElyi6aKDPFk6MhaYTApTlJEX27GFLtSbLMd" +
       "TMo9sl7osasCOe9Eol0XYhVFO/pmxXfTZkW32A0FizYNk0rcqfMdDrzg0QiJ" +
       "wsIymMk+mlQrjjBIWqtlhRxV+Ik3lWGHKpiewIxopJXIS041aHhUK8etUQlm" +
       "wo2Min0YLse8lhDiWglSvDHVrUZliOLjUl+tgUxE7K60jt8yqK41rYmB3ZgO" +
       "+l1RpRIi6bEG05mUnGarXKvx5ipVWqK16A4sQ3DryJRJGakbqNMFPkljy+3b" +
       "IqVG40pt3sDlfp9mcFvtcJUJNQc5FGzQa1Ptmyg6p1XgDraLjzuLCel30rIn" +
       "EkQNmRUbcqXeozsJhmVHnbe8stPmXfnB+uBGAxwys4nuKzhlbacey5rXHRQT" +
       "88+5lykmHim4nNo/xN93Q+V4WyzOTpYP3eoiIz9Vfvzp556Xh58o7uwVsvgQ" +
       "uhi63s9aSqxYJ2o7b7j1Cbqf3+McFli++PS/PjB5s/62V1BCfuQEnydJfrL/" +
       "wpe7r5fetwOdPii33HDDdBzp2vEiyyVfCSPfmRwrtTx0oPl7MkW/Bnxv29P8" +
       "bTcv497USk7lVrK1jRN1wp0cYGd/rx6+Ya9yPSih4meFyH2we4+Cjbe/GEPm" +
       "K4QvU4lMs8YNoXORJ4Ojbg7DHrFELoTOi65rKYJzaKXej6oFHF0lH7AO1JYb" +
       "7YPge3lPbZd/Mmo7ddzEH7qpiRuOlt2OKjmFZ15GLe/OmqdD6DZNAS862cjM" +
       "46beY9iCpmQV57370Fw/v/pj6Ce3ojfvmda+if3kzCp7fDZrfiOH+tDL6OAj" +
       "WfO+ELojkIQQmBuju+GeS56wkDOxa8iH4r//lYi/DqHbj15YZRX3+2+48t5e" +
       "00qfef7yhfuen/5NfmdzcJV6kYYuqJFlHS2QHumf83xFNXKRLm7LpV7+89s3" +
       "C4TbK7SsPJp3cnZ/awv/OyF05SQ8kD37OQr2SWA1R8CA/+z1jgK9EEKnAVDW" +
       "/bR3k9rqtlC8PnUkpO5ZSq7hu3+Uhg9Qjt7pZGE4/8/BfsiMtv86uC599vne" +
       "4O0vVT+xvVOSLCHN48IFGjq/vd46CLuP3ZLaPq1zxBM/uPNzF1+3/4q4c8vw" +
       "odUe4e2Rm1/atG0vzK9Z0j+67w/e9LvPfyMv9f4fSE8DvAwiAAA=");
}
