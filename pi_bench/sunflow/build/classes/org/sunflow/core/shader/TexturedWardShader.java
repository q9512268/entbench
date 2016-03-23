package org.sunflow.core.shader;
public class TexturedWardShader extends org.sunflow.core.shader.AnisotropicWardShader {
    private org.sunflow.core.Texture tex;
    public TexturedWardShader() { super();
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
    public org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
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
      ("H4sIAAAAAAAAALU6eewkaVU1v5mda4+ZnYXdZWHvAd1t+FXX0ZfDsdVVfVVX" +
       "VVdX9a0w1Nld3XUfXdWFqwsGIWJwowtiAhsTQZQsR4xEE4NZYxQIxARDvBKB" +
       "GBNRJGH/EI2o+FX1756ZxY3aSX311Vfvve+99733vlfv6xe+C90W+FDBdczN" +
       "3HTCXS0Jd5dmaTfcuFqwSzMlXvIDTSVNKQgGYOy68tjnLn3/B88uLu9AZ2fQ" +
       "PZJtO6EUGo4dCFrgmGtNZaBLh6MNU7OCELrMLKW1BEehYcKMEYTXGOj2I6gh" +
       "dJXZZwEGLMCABThnASYOoQDSnZodWWSGIdlh4EE/A51ioLOukrEXQo8eJ+JK" +
       "vmTtkeFzCQCF89nzCAiVIyc+9MiB7FuZbxD4QwX4uV99x+XfOQ1dmkGXDFvM" +
       "2FEAEyGYZAbdYWmWrPkBoaqaOoPutjVNFTXfkEwjzfmeQVcCY25LYeRrB0rK" +
       "BiNX8/M5DzV3h5LJ5kdK6PgH4umGZqr7T7fppjQHst57KOtWwmY2DgS8aADG" +
       "fF1StH2UMyvDVkPo4ZMYBzJe7QIAgHrO0sKFczDVGVsCA9CV7dqZkj2HxdA3" +
       "7DkAvc2JwCwh9MAtiWa6diVlJc216yF0/0k4fvsKQF3IFZGhhNCrT4LllMAq" +
       "PXBilY6sz3e5N3/wXXbb3sl5VjXFzPg/D5AeOoEkaLrma7aibRHveJL5sHTv" +
       "F96/A0EA+NUngLcwv/fTLz31xode/NIW5rU3genJS00Jrysfl+/62uvIJ2qn" +
       "MzbOu05gZIt/TPLc/Pm9N9cSF3jevQcUs5e7+y9fFP50+syntO/sQBc70FnF" +
       "MSML2NHdimO5hqn5Lc3WfCnU1A50QbNVMn/fgc6BPmPY2na0p+uBFnagM2Y+" +
       "dNbJn4GKdEAiU9E50Dds3dnvu1K4yPuJC0HQOXBBd4DrIrT95fcQGsELx9Jg" +
       "14B538lED2DNDmWg1gUcRLZuOjEc+Ars+PODZ8XxNThYSKrmwwPgNcAT1LHk" +
       "q2I+tJvZl/v/RjnJZLocnzoF1P26k85uAj9pOyaAva48F9UbL33m+ld2Dox/" +
       "Txsh9CSYc3dvzt1szt3tnLs3zgmdOpVP9aps7u2qgjVZAe8Gce+OJ8S30+98" +
       "/2OngTm58Rmg0AwUvnX4JQ/jQSePegowSujFj8TvHv1scQfaOR5HM37B0MUM" +
       "nc+i30GUu3rSf25G99L7vv39z374aefQk44F5j0HvxEzc9DHTmrWdxRNBao5" +
       "JP/kI9Lnr3/h6as70Bng9SDShRKwTBBEHjo5xzFHvbYf9DJZbgMC645vSWb2" +
       "aj9SXQwXvhMfjuRLflfevxvo+PbMch8E1517ppzfs7f3uFn7qq2JZIt2Qoo8" +
       "qL5FdD/2V3/2j1iu7v34e+nIjiZq4bUjPp8Ru5R7992HNjDwNQ3A/e1H+F/5" +
       "0Hff95O5AQCIx2824dWsJYGvgyUEan7vl7y//uY3Pv71nUOjCcGmF8mmoSQH" +
       "Qp7Z99FbCQlme8MhPyBmmMDFMqu5OrQtRzV0Q5JNLbPS/7j0euTz//zBy1s7" +
       "MMHIvhm98UcTOBx/TR165ivv+NeHcjKnlGzPOtTZIdg2EN5zSJnwfWmT8ZG8" +
       "+88f/LUvSh8DIRWEscBItTwyQbkOoHzR4Fz+J/N298Q7JGseDo4a/3H/OpJb" +
       "XFee/fr37hx97w9fyrk9npwcXWtWcq9tzStrHkkA+ftOenpbChYADn+R+6nL" +
       "5os/ABRngKICduSg54MQkRyzjD3o2879zR/98b3v/NppaKcJXTQdSW1KuZNB" +
       "F4B1a8ECRKnEfdtT28WNz4Pmci4qdIPwW6O4P386Axh84tbxpZnlFocuev+/" +
       "90z5PX/3bzcoIY8sN9lST+DP4Bc++gD51u/k+IcunmE/lNwYfkEedoiLfsr6" +
       "l53Hzv7JDnRuBl1W9pK8kWRGmePMQGIT7Gd+IBE89v54krLdka8dhLDXnQwv" +
       "R6Y9GVwOwz7oZ9BZ/+KJeJLtitD9+4Fl/340npyC8s7bcpRH8/Zq1vzYvvue" +
       "c31jDXbwPf/9IfidAtd/ZVdGLBvY7rdXyL1N/5GDXd8FO9LpfdxXgxTjht1p" +
       "b1vahrWsRbPmqS1G6ZZG9BNZQyWnAIO3obuV3WL23L25EKez7o+DQBTk+TDA" +
       "0A1bMnNVUSFwClO5us/6COTHwIquLs3KPs+XcwfI1mt3m1Se4JX6H/MKDPyu" +
       "Q2KMA/LTD/z9s1/9pce/CayQhm5bZxYCjO/IjFyUpew//8KHHrz9uW99II+r" +
       "YFXEp97rPJNRHb2cxFnTyxp+X9QHMlFFJ/IVjZGCkM1Doabm0r6s8/G+YYEd" +
       "Y72Xj8JPX/nm6qPf/vQ21zzpaSeAtfc/9ws/3P3gcztHMvzHb0iyj+Jss/yc" +
       "6Tv3NOxDj77cLDlG8x8++/Qf/NbT79tydeV4vtoAn2Of/ov//OruR7715Zuk" +
       "TWdM53+xsOGdz7bxoEPs/5jRVB/HwyQZ6z2sBuN9mNA5j2CHfVSp62KR6m9c" +
       "waDiWiMd0wbuD1eJgoXpOhhVouo68ttF1O0jne5AEBv9Yq9ILnGm3F0ZRF/i" +
       "xp7PLZojhJwJxZVLFzcztznqIubQk535bDSQfJGzi2lQg222OPIGNX+2VleY" +
       "XJBqBRnTtQo78cvsplgkQ6E7THpeY8BWZpyrY1O2YZWFasuK+np54Q1TWjfW" +
       "hXIlXFNad+PofZuM0cJGCFZmedZtmSnJTDreykq6i2ZKb5ou5zF6h5wmyZIc" +
       "cZNhJ53pnNAoTWYNy9JHnsR2mnWZFIROWR6umuyY7psyMRyG4mhB293qClsg" +
       "BWw2aoSzrjXAlgaJYQYv49iAYux0PBIRmqjOWTXGut1NYwV36QjrtlCD843V" +
       "oIO7relG4KexNqTkKaMafazJGPPKhKktUpWfLSKcLMyMkTp0uCqsDIYJ1xJ5" +
       "l+76mOYrLt1SNKFZa9FDc4gnPcujMHdQ99qixsbeuBfS8dj3Nz3P1NZCRNnD" +
       "4kiMRDSpN7vFTjdsJfNJD7XscmEW1vviGKh7TMaqb/q+TG5iVmgjVdFOo8TX" +
       "mGkD6RcWmrlSp2wkTOuNIb1YkYsSrRiLhaWmLldc9ZzhdMK1DbK1rI9KxbDi" +
       "0iarDQctZMoHalip98SN0rJrfNrU4iXamk0b4ZBFKjFbL4EV32yWeL0Vh6qV" +
       "jkbL6Qb263HLmTWt2YrtUb222Sl3vdA1XKkpVOZoaFfH9VbdEaaVvt+b9UaS" +
       "a5QbdY4wOt3RSjeImKipfaGxSfuE02gLuEd3LamGMB3MaAwYtlG3xHKirftd" +
       "r9vDO5wzXhTGncSfm4jU5hwTg0sKVrGThGwiUeI2G6NFaq3m3TFW5aiWw1Gq" +
       "y7FBf94gVGPaQuzqUoj0dQlvko2+vaiKzSWjw2qXS8eh7FfiYEbLbIdhfXVa" +
       "76jNedku+Wkh7GpLsN+iVMdTFXSIatM201MFxCrAZcX3Y4ri/JWMspFUXTNM" +
       "hUZqeJWgSzzueY3yQiku+n49XXgmIyqMsW5EnYKTsOTQrfccw1u67TVemIv+" +
       "vCdavsAPoo0lsP1Fzxn1mmpJ8GFqU+nOCd8C+whuhmO2tEx9qyWXFKTUJpsT" +
       "YjH2F95KNpJCdUgpUjp2Kg11YGsyumRViu3NaJYMUXnpeiOr2SpW5YUrTiiu" +
       "hfEFceaSuKWM3GkwwPqcQNDdPrzAsSLRK3TZSerCqc5pY3mA8c1OndvUuHoa" +
       "kMGAVlfFOjpuupvQ21SUaRqXq90O1Y7RWnnu1XlryZlpAnZEdtC0/Xa91+zY" +
       "sadJSaSMo9gts327T63VGUq1kySBK0tZHBI0hlab9bQrcAEpSXLbicl2iGum" +
       "WESQ1SaKfLuaGCtv4BEmg7Cd7ibx1WS+jFcDwVugSUguun0z1sYFuEOIKNmi" +
       "3UaRYdQp75PIqOUukxZVa7JYKk3ITbOzbmt8Q2E1vlycjVO8qLTWGG03G2MK" +
       "YQsWQ/DjacBXWuNWJeFijVpbsxo31SMYaE/ttTkRxomK3RCnjWantOLkcSNe" +
       "cMWUaQ+jpFrleKyA23JUIwNjNp3PLZzBxtV6XJcjc6PR/mw4X7VmaX+5SCbo" +
       "Zt1MOKUoof5yEiNtaUPDNiEm3pghkbg5soWkAAcVnetZwYRs9lO7Mw7wtj0v" +
       "xnw5klW4Fqi80lYqXYnXzELQJnvYpigIAyTo057aoipCmWrQ9UoNTWFvqK3b" +
       "tTXD9gOxi2pSQKMIP6zzQWcyLzmqxq+XPQ3R+XViI0oDXwAibretb3y3ZVJe" +
       "ccgmtDUuoGEdXfSI0WzutSx4Eo+qm8Vq5iYDkogivSatxzys2424SNZjv9ij" +
       "6pKGBs3JumAwGog6sFpDWH8kkOJ4tkR1bdwlo4JatvyAI4qFWNVEfs21NyDG" +
       "xz1lTsbMxuIbK9wSmYio9jG538PgYkUDMb2sxjV/5JqFKqEvN4jSo4aBjcGb" +
       "ubwmqSZaiZG+7Hf1mlZDWzWxSjKctE6ddqlu0Rt0mrKMYqs6qpvEHGNM2por" +
       "hFMUm/W2xcy5KSPUiIWBqKN1y29XsOmah5HGYhAK6ri7CHs1i1Bm3pwuNgCd" +
       "hPYnfIWbyb0STg/6HNYUhtN2Uq9jfBy4FiabYc+tpbNVrSZXaZQbFEt6SVwO" +
       "FlPcZLwgomTC86teLWYqcRULC1Wtjw2cArPmSoLNIiSeyIVpSRN7a19eJxpu" +
       "8/yUokZtiU/6cI9ZGliArhW4reEDUvB1m4TZwQoE0ZqHM5Fca6JVF243hqN+" +
       "eVEPvPW8LyVTprFpO3wntdXOtBtNiAJKjOgiMDtXiU1cplNKDS3Wq66JJT+g" +
       "nRqCT6ZGachJ3SY1rVbUFMGFpF4VdXaurnvIKh14bYZ0i31cGjTmViIoxUAE" +
       "Dqto/Uk/REYrhgknJNpZVcb6NCj2WIn2adfojjAtnjlohVrjPpWoLT2UN0pn" +
       "MQ2Y4dBDkBI2wQplTihqoTIox0MROBOCU1O8skxrG6xQay7XFQtRrW4j8ryu" +
       "tB5W59PhJEmF0BoSWopVZUYjat2KklRKmK7LQkVWBst2vWC666FYjmEgocFW" +
       "DFwQtM0qbMMVAU/LcgCHkUOWpCZWN8cFCS0YZVgJEbdMsz7PEsyiPtZ0HJhu" +
       "p1v2qT5NDHUFBBxMrCt1JfRbDN7yioRK4Apa1ohBGCVGgHJ0X3bWUg91FxGj" +
       "EEU1RutOslz2i1qAilW006uocN8qMBTN1KIGWOuqGEpju6OLpCmuqE2HHLFe" +
       "q2u2uT4HsiC3bFQKa5VJauuKvoHjCDVaxJCOYJNP/LhQUDUCWYe9EdX0Ih1D" +
       "Y2K+LJe9RguXDR4XtHq5BgdTLzTbWtwLudmyjVvjCFUMc25ari72Cb1NDbQC" +
       "x9sVwEaTsJgaFUcDHGFZPSmWWGNMDOuFaFQfqzKcLJKoLltBR1rLwSgIYEJY" +
       "Twq4ys/bg6RYaPoTrLQGW79ocsN4ATIZlIkYM5qEVDj1EHmNyHBc4jhaLvZL" +
       "c3MoSfamPw1WxVXLGZUW442v8JhpK0SlXJOiWWoYXXXgMWapY9odBYY7gZYu" +
       "rbJaS+F5Mp/zhjhCCRCiN2O0Naq0Fh2dqFD+AOyDw/maM4SBOZ11i7Q1HdG6" +
       "LY6qbUvmGlPPE+Kl2rWUjblaKWl/XbWiodI2WoHjt+DqpM6314iuUR2eGDXx" +
       "jjU2EbZL+khqbPC0mLaFWmnKuIUabEQKVdPMDtOZeQlISfVKG+NLsltnlx0s" +
       "MqWV7mK6u+qOC6tKNyZ9Yy7BNZMm4D7SpMZ02RjacmqkSGs4RfglxQyrhgYX" +
       "KbMDb6hG21MRsC34hovJETKZIV1jUZaZVU90dFKaRSrGWxjqgt3bLMymdbxA" +
       "qR067YRVYSgO1vygh021aN2m6eogGTSZuEQOBsM5n3Qb5a7s0/JwJMpOOaxq" +
       "VbDvzMDH69JsFMX5GKT4ncai1ojidtgLeAoPqVkyTrBlSq1tDsbjVYE3K9V6" +
       "k1EmwqDeVGBljDilEjbteFOQ4a/a2pztkW3PK/eSzRT1FaxaUrVqb6U0uYk5" +
       "bVv+cohWbcapFULahGukQ1GGUJqEQmSP6lgDtVmSpqZtYjZKmVJLWcLTihem" +
       "Ws1c2F4X7VtOBBN9ki6pydRKBYYahUWU5JCEx1s9f1gvSdEinuG8XClyojUd" +
       "oqK3iporu1yRLTEUnXWvzwui1QkrdB0ryHyFsVC9SnTZJSfi+BR8gb0l+zSb" +
       "v7Kv47vzQsDBURP4KM5eCK/gq3D76tGsef1BDSb/nT15PHG03HlYA4OyL90H" +
       "b3WClH/lfvw9zz2v9j6B7OzVDuUQuhA67pvAh4lmHiG1Ayg9eesvejY/QDus" +
       "aX3xPf/0wOCti3e+gkr9wyf4PEnyt9kXvtx6g/LLO9DpgwrXDUd7x5GuHa9r" +
       "XfS1EGSUg2PVrQcPNHtPprHXgGtfzXffvFp+89JWbgXbtT9Rmt3ZU+BeAeih" +
       "G4pWuR60UPOz2u8+2L1HwcTtneA7+QxPv0zx9+eyJgmhs5GrSuH2XODtRyxN" +
       "CqFzsuOYmmQfWuHmR9Umjs6SD0QHasu19Nq9wuB+gfD/QG2n9o6J9vTx4A1q" +
       "y46dDHueHUtrOYVnX0Ytz2XNB0Lo4lwLKUPXo0Dbp3zfUcqGJc21rMa/dw6d" +
       "q+cXX4l6gO6v3Hg6lpX677/hxH17Sqx85vlL5+97fviX+QHRwUnuBQY6r0em" +
       "ebQye6R/1vU13ciFu7Ct07r57WMnJDpyapcVLfNOzvRHt/C/HkKXT8KH0Jns" +
       "dhTsN0Lo9iNgwIr2ekeBfjOETgOgrPtJd1+/b7rVGSJhG4ET+o5rKIeKSk4d" +
       "D2AHi3DlRy3CkZj3+LFIlf8fYj+qRNt/RFxXPvs8zb3rpfIntqdbiimlaUbl" +
       "PAOd2x60HUSmR29JbZ/W2fYTP7jrcxdevx9F79oyfGj4R3h7+OZHSQ3LDfPD" +
       "n/T37/vdN3/y+W/k1dn/BjcpBNqoIgAA");
}
