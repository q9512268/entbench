package org.apache.batik.svggen;
public class ImageHandlerJPEGEncoder extends org.apache.batik.svggen.AbstractImageHandlerEncoder {
    public ImageHandlerJPEGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          imageDir,
          urlRoot);
    }
    public final java.lang.String getSuffix() { return ".jpg"; }
    public final java.lang.String getPrefix() { return "jpegImage";
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.File imageFile)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            java.io.OutputStream os =
              new java.io.FileOutputStream(
              imageFile);
            try {
                org.apache.batik.ext.awt.image.spi.ImageWriter writer =
                  org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
                  getInstance(
                    ).
                  getWriterFor(
                    "image/jpeg");
                org.apache.batik.ext.awt.image.spi.ImageWriterParams params =
                  new org.apache.batik.ext.awt.image.spi.ImageWriterParams(
                  );
                params.
                  setJPEGQuality(
                    1,
                    false);
                writer.
                  writeImage(
                    buf,
                    os,
                    params);
            }
            finally {
                os.
                  close(
                    );
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_WRITE +
              imageFile.
                getName(
                  ));
        }
    }
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          java.awt.image.BufferedImage.
            TYPE_INT_RGB);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Hwpxr4hPbF79D+1xIr9WGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06acwsWVX1vnn7LO/NA2aGcfZ5oDOFX1Xv1RkY6a6uXquq" +
       "l6rq7mqVR+1V3bV1LV0LjgJGGSSORAbECBN/DFFx2AxEE4MZYxQIxARD3BKB" +
       "GBNRJGF+iEZUvFX97e+9IQNqJ3W7+t5zzj37PffefuFb0Bnfg2DXMRPNdIJd" +
       "JQ52l2ZlN0hcxd/tk5WR4PmKjJuC77Og75r0yCcvfee779Uv70BnF9CrBNt2" +
       "AiEwHNufKL5jbhSZhC4d9hKmYvkBdJlcChsBCQPDREjDD54goVuPoAbQVXKf" +
       "BQSwgAAWkJwFpHEIBZBuV+zQwjMMwQ78NfSz0CkSOutKGXsB9PBxIq7gCdYe" +
       "mVEuAaBwPvs9BULlyLEHPXQg+1bm6wR+P4w8+2tvufx7t0CXFtAlw2YydiTA" +
       "RAAmWUC3WYolKp7fkGVFXkB32ooiM4pnCKaR5nwvoCu+odlCEHrKgZKyztBV" +
       "vHzOQ83dJmWyeaEUON6BeKqhmPL+rzOqKWhA1rsOZd1K2M76gYAXDcCYpwqS" +
       "so9yemXYcgA9eBLjQMarAwAAUM9ZSqA7B1OdtgXQAV3Z2s4UbA1hAs+wNQB6" +
       "xgnBLAF0702JZrp2BWklaMq1ALrnJNxoOwSgLuSKyFAC6DUnwXJKwEr3nrDS" +
       "Eft8i37jM2+zu/ZOzrOsSGbG/3mA9MAJpImiKp5iS8oW8bbHyQ8Id3326R0I" +
       "AsCvOQG8hfn9n3npzW944MXPb2F+5AYwQ3GpSME16Xnxji/fhz9WvyVj47zr" +
       "+EZm/GOS5+4/2ht5InZB5N11QDEb3N0ffHHyZ/zbP6p8cwe62IPOSo4ZWsCP" +
       "7pQcyzVMxesotuIJgSL3oAuKLeP5eA86B95Jw1a2vUNV9ZWgB502866zTv4b" +
       "qEgFJDIVnQPvhq06+++uEOj5e+xCEHQOPNBt4HkDtP3k3wEkIrpjKYggCbZh" +
       "O8jIczL5fUSxAxHoVkdE4PUrxHdCD7gg4ngaIgA/0JX9gY2mKTbSs4D1u4It" +
       "A3H6I6JD2JIjK95u5mvu/8sscSbr5ejUKWCG+04mARPET9cxAew16dmwSbz0" +
       "8Wtf3DkIij0tBVA28e524t184t3txLs3mRg6dSqf79UZA1uTA4OtQOiDpHjb" +
       "Y8xP99/69CO3AF9zo9NA2xkocvPcjB8mi16eEiXgsdCLH4zeMf05dAfaOZ5k" +
       "M6ZB18UMfZSlxoMUePVkcN2I7qV3feM7n/jAU85hmB3L2nvRfz1mFr2PnFSv" +
       "50iKDPLhIfnHHxI+c+2zT13dgU6DlADSYCAAtwUZ5oGTcxyL4if2M2Imyxkg" +
       "sOp4lmBmQ/tp7GKge0502JPb/Y78/U6g41szt34EPOU9P8+/s9FXuVn76q2f" +
       "ZEY7IUWecd/EuB/+6z//p1Ku7v3kfOnIcscowRNHEkJG7FIe+nce+gDrKQqA" +
       "+7sPjt73/m+96ydzBwAQj95owqtZi4NEAEwI1PwLn1//zde++vxXdg6dJgAr" +
       "YiiahhQfCJn1QxdfRkgw2+sP+QEJxQThlnnNVc62HNlQDUE0lcxL//PS6wqf" +
       "+ZdnLm/9wAQ9+270hu9P4LD/tU3o7V98y789kJM5JWUL2qHODsG2WfJVh5Qb" +
       "nickGR/xO/7i/l//nPBhkG9BjvONVMnT1k6ug51c8teAwiPHzNau3e3alfWj" +
       "uUmRHObxvN3N9LYXcnuY6M1Cm5l2Op7g6obkF1u9IRFLipuxmhMtZc2D/tGY" +
       "Oh62R+qZa9J7v/Lt26ff/qOXciUcL4iOuhAluE9svTZrHooB+btPJpCu4OsA" +
       "rvwi/VOXzRe/CyguAEUJJEd/6IHMEx9zuD3oM+f+9o//5K63fvkWaKcNXTQd" +
       "QW4LeexCF0DQKL4OMmDs/sSbtz4TnQfN5ewthg60BuVag+Ktr92T/7oFMPjY" +
       "zdNWO6tnDiP/nv8YmuI7//7fr1NCnrBusIyfwF8gL3zoXvzJb+b4h5kjw34g" +
       "vj61g9rvELf4Uetfdx45+6c70LkFdFnaKyynghlm8bgAxZS/X22C4vPY+PHC" +
       "aFsFPHGQGe87mbWOTHsyZx0uKeA9g87eLx5NU98Dn1Pg+e/sydSddWyX4yv4" +
       "Xk3w0EFR4LrxKZAEzhR3a7toho/nVB7O26tZ86NbM2WvPwayhZ9XtABDNWzB" +
       "zCduBcDFTOnqPvUpqHCBTa4uzVoeQducmLXVHHxr/vpNXeXJLVS++N1xGJOk" +
       "A6rJ9/zDe7/0K49+DdivD53ZZLoFZjsSuHSYFdi/+ML777/12a+/J090IE6n" +
       "7/5U7esZVfrlpMuaXtb098W6NxOLyesGUvADKs9NipxJ9vJuO/IMC6TwzV71" +
       "iDx15WurD33jY9vK8KSPngBWnn72l763+8yzO0fq8UevK4mP4mxr8pzp2/c0" +
       "7EEPv9wsOUb7Hz/x1B/+9lPv2nJ15Xh1SYDN08f+8r++tPvBr3/hBsXMadPZ" +
       "5scfyLDB7Vi37Pca+x+ywKuziIvjmTos1ZHyGIOjstTkq8ty0kTRBr8SGAqX" +
       "IoWhSC5xBH0wDOViJcSmtRDbhHYXLbocakwXTc5xjLE+EGiXczuC4K8m7dmS" +
       "7qAMx03XxHoWWDpTYIVwzGyKy3qDKqzbZLVZLLH1olgUN2pRJRYcyyFCUURL" +
       "Yr2K1WGRrtWKi0q1ynZ8ybKlVCPYik4xEkMh2jiYFK166HHSuIyTAoFNuTmi" +
       "hqyArAs6twzwisU4VLU51pGpy7YVmRD7FBXHwxbPVeDYZCWJGaeT2FoWOqEl" +
       "8aAWxCrI1CQLMUO3Ktp6XF60Cr0qC3ZaFY+ZpvZoVmss9UVbk2lnNWCrVEWT" +
       "UVii8dCilU5MIoO4jrjVVWvkpco0QnUemfiyQ1NSYTTx5l26ygaYWU3qYxv1" +
       "vH4vSUc9TEVToUzWfa5k1iytis1nyyKspOK438YSU7faCb+opFrLska+yA07" +
       "dmHd6siLRWlZIcLVYFUVVCqRZEoiV+hCRw2dmnmtWTkig1nFmCSIIER6rKza" +
       "E28gaON+EpD6dMm5pjlP+61xh2E5qS4XqYnhz6cddGq6i0XYY6vVkW2nHlP3" +
       "0DW6dPHZcrrs0NPJuLEarspJY1xYFZNZbLtVJ5F5Bu3UWnyEpbP1oEKHxkYu" +
       "z3RXQ3oS2UWaJLekZlI0k0prWLM5oggnUrQq1oR2ZdDsszUvEUw0ZfnQx9Pp" +
       "1OP10jjy20QrViJOF/VULzAjwREHiUpqxmBAl1Sp2YiSIEkHCsUH7HTic/hg" +
       "0tIdfbicT9AOQY6YBu0tx6um0B0m4aA/rpPTtjntCAvNopJGS10NI9zTRB1v" +
       "pniiRppVaRDr2rjsE2u4LlqwWg8XBLZQemiMO+Ro0G6WCmK537T5drNZMAbF" +
       "cVrUJim/wWtwv12KiuEq6kkNbIQ1fGVag8tOoUaXQA282iRk32ou0mZlia8w" +
       "h4vsSi2pBV01KBgu59TLSXeMzjfYJPGlsFPqV5VNg+v51YZDsP5Sl2pks1RL" +
       "dF6BE6TM9J1S3W3zcX0azcprXabE4cxd0rVWOuRZ1mRhdNWi6hMFleujatio" +
       "ebpJcZrMDng1Vs1BgBcGwUCttoxCT2uYJQ6nYWHF9shSLJodtSMHkabLKj5e" +
       "2FqRGK1YEa0yKJ8sFtPOmiOoNB0aY1Eg66w+HvcjC045hiVGsyUnqVRxguOc" +
       "TA8niU2MeX469EVGmC0IuDaMYDt0Hb5XgcsLQykOOg2/uZqkrZk3Qkiya6Gy" +
       "UikPGizpt8a9xtLz7VrRanlRvzKPwymcdvCyWVr0Wrpr4/W4YQ67fYKdYCxB" +
       "sGbsUiTRb44ZDCu0mgrDROUBHQV8t9YpKEMk1TbroR1WHa2wTmNh0yj6tjAF" +
       "nqe0Ymzg9Ctj0p6h7KCKhSCMqYE1XEXVNdZMp5Qw9wOaakz9tRNWYHFVweUN" +
       "zsSRK60ocrNw/T4XDfRBIg2mnAUPqcnGtYGKGMZYUXTio5LTXxBiPVE4shxh" +
       "KrwhO1TDmle0meRrvNbipVFv4cw50a8ZDSlNZmhdVkpLBoUVulVYDYgVqqsx" +
       "T+v9oNpwOxO6UcdncxnfuEzZm7EliQxafEuyqf6wUWj5LaoyaSyjenPS7M5g" +
       "r1nuT9xF1RrOx5xKIwNK5Cu1drOzrin9WteZtIFhCNJehrKnWEpntGloG1Fn" +
       "BygllfGpo638eYlXQr40QhB2LpGyPk+ZquETum5vsBnB46E/Fuh5qCuFppV2" +
       "NRhu4eiQHs1b9cKMGvvSIBEEqR+KXb8ZFhv9SCqoirIpw3FdscUyUw8H0jgm" +
       "R32BmCW6Qk9aLtDftGd1irQb1TWnUe5p0y6rilgTEyyT7ntcZ1b11ZoQljYs" +
       "M8dgNGGXY23a6zlRsdQOW5NaXW93bc9OWlhVXxhjbWnzWMXu9p123TPkigvW" +
       "G1weLxGkCaIQxK6NdjiNbfhrmqacDsornZZPNjFiMVnxBmMVyzoVoEu15y5Q" +
       "H24tBm0XnWB6G5+rq3jlOnQ3dtK4Ks50k5bYai0sYRHYFPG64AycaRjPlFK5" +
       "XmDdYDOb8g3brPVno5lWqddHDl3mWabjl9WxNuKqbntiYEVh1NPVDsVgG5nt" +
       "N2hENhEJQQcLdaOtmAmKGw1grxbtNMyNxWjdYUWAXRiGqVJbj+tBeU3AqLEU" +
       "zUFhWV7XmdjV0LRhN6q4HMDVyhQTKaWFoqJqTPvobEMoRGFlYMsy6QR2ujJ4" +
       "0yKNdCYhVBevFes1OVyv8XaFTMyl0Ua0hUjz86iwxASHdgtNpNOf9H1/HTMu" +
       "M1wHQ7ObrmBXi6VSMl+vnNqkahDtGBklG2QzZ5PeXN2kwEktT3PtmZ36Al9z" +
       "w7SzlnyQQVqOtkT5YbU1VFQYI9ySEqjBoqmsZLlsqHALqcxaROh7i956ObDK" +
       "CKao3WZ3YS2DCuGYmip1JmzF5rt2Kaimk+Vq3tZnm7TZBqscKN+aVYQvthkL" +
       "bbtiFV8wndWEF+F1p4GTUqc9j7yRDOIooMrDgtEsTTx/ZLHaagA3bV2jB8JY" +
       "5RpDUqR7y3Gj3eN6MYItfWRc1yg00om1gCltabDm+lVdbIZRUdQKg66C1MgW" +
       "LxAWPnc0mFMMz+7EnZo4ruuYqomlab9XNiI/AXTkKOHd0njYhedkadCHcQVl" +
       "iqWoO9I6GyrC03Awnqm8Vg3o1kQTEpAkJ1OeoeTKBCQZ2uuRPY1cd9ocF0Qz" +
       "a+F3VhZIucM235vOe+kisTE4tZtSoyc2BmOrv3aNgVS2hKJSkWt4gaTHBg/X" +
       "+uR8nZSx0UQsVGrzdV/D+tqc7wh2miJFRmEphbd6mJFg6zAqV3VsmWI0XmBF" +
       "N0ERrV0m7RJiaK1KpyGmmlKvrbu+Pm9zsQ0WvtC3CTSguLnaTWAZoTslFqT6" +
       "EG4Xuok65augtN20UaQ97LlpGIkpiq11n6uGpS5Xnel+XbK70rRcXBdMSyG4" +
       "gYtvUpE0u75qgZpFTDsWgBo0i62RBStrD4kCtcKai9kQsBDMm45Hkj3bbjpi" +
       "FBWma0QaevC87K9mYkIIvQVqYp4bGnURbtFdbzonVp3FgmzbRn1cGDurntss" +
       "zxKk2eiM8FLFrTad1qjfSvXmZlSHS6AWQ2EC55ARnrJdmmkyaRlUmWuPDrLz" +
       "xIHNrcrDVbtdHil8tVrA1mSEEr6PIgWRrAzC9tTlNM1bjgZVNrbJdKJho02B" +
       "rNX7xYofMvqIKrvDfiJPGHMoFSirNRUJbtY2J7NVe1aTqwUaVrAiiVd9vCu6" +
       "EqmoIE4NNO0NGILUiv3YoSel0PGnCLJhi4UaUlRsoR41ay2XGldmbMjL9cDy" +
       "oqq2ofGWtY6iUmeDb0Zys+ynoMAW3EQuisSyXpsrRtVgE95qugu1SkjhfNEs" +
       "1StiQKB2eybAqxXNN0rkstLspPKqzk9iLXG1+th00H6F77a5zmCymcKci6XB" +
       "kKoU1kgnmSTUvOx2WzAxL1TQYMKsFZ213YGvjjEdVGF0q2uJJTJtrtaGZTV9" +
       "v7g02xEa2qFBzeSFNiYUVzQ4DHMDNjFq3WKhXp/F3ekE8aNJP0WGpGe3k2Q2" +
       "AOVWXG6PuR5Ma4jdF915X+m1THPagLGFOuv22Q0eV1ZUpS/0C2SLYWrdyI29" +
       "sj4S27V6Cy7EPa8+64CtUraFuvbKdrF35pvzgwucH2Bbvh16OGted3BOmH/O" +
       "njz0P3pOeHjKA2U70vtvdi+T70aff+ezz8nDjxSy3WiGuAigC4Hj/ripbBTz" +
       "CKnTgNLjN995U/m11OGpzefe+c/3sk/qb30FR9wPnuDzJMnfoV74Quf10q/u" +
       "QLccnOFcd2F2HOmJ4yc3Fz0lCD2bPXZ+c/+BZu/JNPYweN60p9k33fiY+YZe" +
       "sHPgBXsOcOLocv8QLvsdvsxYlDVgp39BUwImVFUj70UPHWb9/bb7RynmHdb1" +
       "EhJ7EhL/RxK+42XGfj5rfmYr4chTrpfwqR9Cwvyq4EnwUHsSUq9AwlO5hDcU" +
       "7sSZ9X350ZcQBbtGdou02wSWUjxFzu+U9oFuy4EMZ7dtmEpO9ZdvfJ6d/Szn" +
       "AO/LmqcD6FYlv4w6JMcdyRV8AJ3eOIZ8qLF3/xAae23WCYNH3tOY/L+jsRNn" +
       "9VcONNYyLMX290/jf/NlPOX5rPkNgCuGhikf03E28syhAj70ShQQB9DdN7n8" +
       "y24y7rnu3wbbG3Lp489dOn/3c9xf5fdfB7fYF0jovBqa5tET4iPvZ90DF7+w" +
       "PS9286/fBUzc5PoiO+7NX3LOP7qF/3gAXT4JH0Bn8u+jcJ8KoIuHcIDU9uUo" +
       "yKcD6BYAkr1+xt23T+lmdykN0Q88QQqOamxPW/Gp42vNgTmufD9zHFmeHj22" +
       "qOR/CNlfAMLtX0KuSZ94rk+/7aXqR7Y3eJIppGlG5TwJndteJh4sIg/flNo+" +
       "rbPdx757xycvvG5/wbtjy/Chkx/h7cEbX5cRlhvkF1zpH9z96Tf+1nNfzQ+8" +
       "/wc+Ie5IqSMAAA==");
}
