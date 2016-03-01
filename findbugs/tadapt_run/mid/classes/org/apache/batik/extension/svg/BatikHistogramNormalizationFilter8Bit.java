package org.apache.batik.extension.svg;
public class BatikHistogramNormalizationFilter8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.extension.svg.BatikHistogramNormalizationFilter {
    private float trim = 0.01F;
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public float getTrim() { return trim; }
    public void setTrim(float trim) { this.trim = trim;
                                      touch(); }
    public BatikHistogramNormalizationFilter8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                                 float trim) {
        super(
          );
        setSource(
          src);
        setTrim(
          trim);
    }
    protected int[] histo = null;
    protected float slope;
    protected float intercept;
    public void computeHistogram(java.awt.image.renderable.RenderContext rc) {
        if (histo !=
              null)
            return;
        org.apache.batik.ext.awt.image.renderable.Filter src =
          getSource(
            );
        float scale =
          100.0F /
          src.
          getWidth(
            );
        float yscale =
          100.0F /
          src.
          getHeight(
            );
        if (scale >
              yscale)
            scale =
              yscale;
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scale,
            scale);
        rc =
          new java.awt.image.renderable.RenderContext(
            at,
            rc.
              getRenderingHints(
                ));
        java.awt.image.RenderedImage histRI =
          getSource(
            ).
          createRendering(
            rc);
        histo =
          new org.apache.batik.extension.svg.HistogramRed(
            convertSourceCS(
              histRI)).
            getHistogram(
              );
        int t =
          (int)
            (histRI.
               getWidth(
                 ) *
               histRI.
               getHeight(
                 ) *
               trim +
               0.5);
        int c;
        int i;
        for (c =
               0,
               i =
                 0;
             i <
               255;
             i++) {
            c +=
              histo[i];
            if (c >=
                  t)
                break;
        }
        int low =
          i;
        for (c =
               0,
               i =
                 255;
             i >
               0;
             i--) {
            c +=
              histo[i];
            if (c >=
                  t)
                break;
        }
        int hi =
          i;
        slope =
          255.0F /
            (hi -
               low);
        intercept =
          slope *
            -low /
            255.0F;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.image.RenderedImage srcRI =
          getSource(
            ).
          createRendering(
            rc);
        if (srcRI ==
              null)
            return null;
        computeHistogram(
          rc);
        java.awt.image.SampleModel sm =
          srcRI.
          getSampleModel(
            );
        int bands =
          sm.
          getNumBands(
            );
        org.apache.batik.ext.awt.image.TransferFunction[] tfs =
          new org.apache.batik.ext.awt.image.TransferFunction[bands];
        org.apache.batik.ext.awt.image.TransferFunction tf =
          new org.apache.batik.ext.awt.image.LinearTransfer(
          slope,
          intercept);
        for (int i =
               0;
             i <
               tfs.
                 length;
             i++)
            tfs[i] =
              tf;
        return new org.apache.batik.ext.awt.image.rendered.ComponentTransferRed(
          convertSourceCS(
            srcRI),
          tfs,
          null);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8UfffwA5l5oggiIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAM16e8zk1nXf7CftrnYtaVdybCuKJdnSyrE98ccZznBIYmPX" +
       "nAc55HCefM0wadYcvoZvDskhZxipSZymNhLANVrZdYFE6B9OH4Fiu0WNtCjS" +
       "qmibB2wEjRE0adHaaRugTh0DVoG6Qd02veR8r/32YalSiw7AO5f3ec655/zO" +
       "4b33lW9XLsZRpRoG7s50g+RQ3yaHtoscJrtQjw8ZFpkoUaxrHVeJYx6U3VKf" +
       "/dK1737v06vrB5VLcuXtiu8HiZJYgR/P9DhwU11jK9dOS3uu7sVJ5TprK6kC" +
       "bRLLhVgrTm6ylbed6ZpUbrDHJECABAiQAJUkQMRpK9DpEd3feJ2ih+In8bry" +
       "FyoX2MqlUC3ISyrvvX2QUIkU72iYSckBGOGh4l0ETJWdt1HlPSe873m+g+HP" +
       "VKGX/tpPXP97D1SuyZVrls8V5KiAiARMIlce9nRvqUcxoWm6Jlce83Vd4/TI" +
       "UlwrL+mWK4/HlukrySbST4RUFG5CPSrnPJXcw2rBW7RRkyA6Yc+wdFc7frto" +
       "uIoJeH3nKa97DsmiHDB41QKERYai6sddHnQsX0sqz5zvccLjjQFoALpe9vRk" +
       "FZxM9aCvgILK4/u1cxXfhLgksnwTNL0YbMAsSeXJew5ayDpUVEcx9VtJ5Ynz" +
       "7Sb7KtDqSimIoktSecf5ZuVIYJWePLdKZ9bn26Mf/dRP+n3/oKRZ01W3oP8h" +
       "0Onpc51muqFHuq/q+44Pf5D9rPLOX//kQaUCGr/jXON9m1974bWP/sjTr/7W" +
       "vs0P3aXNeGnranJL/fzy0d99d+cD+AMFGQ+FQWwVi38b56X6T45qbm5DYHnv" +
       "PBmxqDw8rnx19huLn/4V/VsHlat05ZIauBsP6NFjauCFlqtHlO7rkZLoGl25" +
       "ovtap6ynK5dBnrV8fV86NoxYT+jKg25ZdCko34GIDDBEIaLLIG/5RnCcD5Vk" +
       "Vea3YaVSuQyeCgye91X2vxtFklR+DloFng4pquJbfgBNoqDgv1hQX1OgRI9B" +
       "XgO1YQAtgf47H6ofolAcbCKgkFAQmZACtGKl7ysLO9X9GHAMxakJtYuyPsCH" +
       "wASmOwoi78SKSMsFCoe1LYBPQB3D/18I2RYSu55duAAW893nocQFVtgPXE2P" +
       "bqkvbdq9175w6ysHJ6Z1JOuk0gXUHO6pOSypOTyh5hBQc/i6qKlcuFAS8QMF" +
       "VXttArrgAFQBHR/+APfnmY998tkHgBqH2YNgIYum0L1hv3OKQ3SJtiowhsqr" +
       "n8t+Rvyp2kHl4Hb8LjgBRVeL7pMCdU/Q9cZ5u73buNc+8c3vfvGzLwanFnyb" +
       "QzgCljt7FsDw7HmZR4GqawBqT4f/4HuUL9/69RdvHFQeBGgDEDZRgEUA8Hr6" +
       "/By3AcTNY7AteLkIGDZKwRdVxwh5NVlFQXZaUirDo2X+MSDjtxUWUwMPdWRC" +
       "5X9R+/awSH9grzzFop3jogTzD3PhL/3B7/xxoxT3Me5fO+NJOT25eQZrisGu" +
       "lajy2KkO8JGug3b/7nOTv/qZb3/ix0oFAC2eu9uEN4q0AzAGLCEQ88/91vpf" +
       "f+Prn/+9g1OlSYCz3SxdS92eMFmUV67eh0kw2/tO6QFY5QIzLbTmhuB7gWYZ" +
       "lrJ09UJL/8e15+tf/pNPXd/rgQtKjtXoR77/AKflP9iu/PRXfuK/PV0Oc0Et" +
       "fOWpzE6b7QH47acjE1Gk7Ao6tj/ztaf++m8qvwSgHMBnbOV6iYgHpQwOSs7f" +
       "kVRqd7PaQyVLDi0PeLZDoEjA8AvSDvdWCmb7wH0CrcjywDKmR84JevHxbzi/" +
       "+M1f3Tue857sXGP9ky/9/J8dfuqlgzPu/rk7PO7ZPnuXX+rfI/ul/DPwuwCe" +
       "/1U8xRIWBXvIf7xz5Hfec+J4wnAL2Hnv/cgqpyD/0xdf/Ed/+8VP7Nl4/HZv" +
       "1wPB3K/+q//51cPP/eFv3wUWgcoHSlLSCJU0frBMDwuiyqWolHUfLpJn4rNY" +
       "c7twz4SQt9RP/953HhG/849fK+e7PQY9a1pDJdxL59EieU/B7LvOA2tfiVeg" +
       "XfPV0Y9fd1/9HhhRBiOqwL3E4wgs/fY2QzxqffHyv/mn/+ydH/vdByoHZOUq" +
       "YFAjlRLTKlcAmOjxCriLbfjnPrq3pewhkFwvWa3cwfzeBp8o3y7fX7nIIoQ8" +
       "RcQn/vvYXX78P/zpHUIogfwu+nauvwy98otPdj7yrbL/KaIWvZ/e3ukHQbh9" +
       "2hf+Fe+/Hjx76V8cVC7LlevqUSwvKu6mwCkZxK/xcYAP4v3b6m+PRfeB180T" +
       "j/Hu8wp/ZtrzWH6qaCBftC7yV8/B98OFlJ8Bz/uPkO395+H7QqXMDMou7y3T" +
       "G0Xyw8doeTmMrBTYSzlyKwFzAQsp8sge+Yv0I0XC7heTuOfCkydkPVqUPgse" +
       "9ogs9h5kcfck60oYBQkQnq4dE3ZxVYQXQImev7cSlfi4B5yX/+Zzv/NTLz/3" +
       "70udf8iKgaiJyLxLnH6mz3de+ca3vvbIU18o3fCDSyXeC/38B86d3y+3fZaU" +
       "BD98+xpdA15otJfF/j+prN/S4FAJw7iIC5fA28d6BI0CTZ9YqqNHYDzdPY5I" +
       "/99PutcauFzEfR5LKg9YR9/GBVhcOIr2Sh0qkh8/Vg/17upxUGTfX6Cv5Svu" +
       "sX5ccnXf3H8e3CqSHwu3J1Oc84t7j1qYKPhKC3y98IDHdfvg1AoOT76QQeX2" +
       "DmKjygfvrYbDUhtOAeU3P/6fn+Q/svrYG4hKnzmnpeeH/DvDV36bep/6Vw4q" +
       "D5zAyx2fz7d3unk7qFyNdPC97/O3QctTe/mX8tsLv0ieL0V8HweX3KcuLZI1" +
       "WC21EPV+Ze7TfLetnAMe/g0Cz/PgGR4Bz/AewPPCPYCnyEoniBO7wV4457Hw" +
       "xf8LJP3s6yHpSgk9qh4mdyPrL35fsvZmeAEA7EX4ED2sFe8/f/eJHziysktx" +
       "uZtUvBnHZLzLdtUbxyGXCOJGoMw3bBc9NqLrpwa23485R2jrdRMKDO3R08HY" +
       "wDdv/sIfffqrf/m5bwBgZyoX08LrAns5M+NoU+x2/aVXPvPU2176w18oPw2A" +
       "GCef7V3/aDHqS/djt0g+dRurTxasciUCskqcDMtoXtdOuD2HbA8CJf8/5za5" +
       "/kK/GdPE8W9Yl3WEELYzP23wKdxPtttulSeIrIl3LTrYtOhFv6YOG0Ofac4Q" +
       "tcGR4ng2mG80X2/IfdmTKA+HkXZHikiO8sl4xY2seQgxzKrXiXu7WGGYtcJZ" +
       "wmIdmLLdrK8tEQtICaGrtL21c0Nr5HDi9eceycFKFIJRNxGUoLgOoWnSwlFk" +
       "GLqO0+oKLsu5FFxX2pLW7hrt3ZwPYlcXl4MY1zpLZ4BDkLzQthCuag1pMest" +
       "6YTeOl3V4mZGLKwtJenxzLzGZZ7CD+p1d6DM6LDt1COhz4wXgRfbMi1buKSO" +
       "RLknjtaEPxDQBc2425pFb2VrbY+FJYpOhYU3M/zGcNocoZSYTX1N1WizhcmS" +
       "3erg5qA7HzXlPMaRKmlNRpi6cYecJy2agWLtYqmFtZZIf9YVUd0T5TqpyAjJ" +
       "1o1JPJO2jI+MnVnQQuG0hY3Gy2FcV7va0OW1oUziPSUIlY2dkI7fnSEgnhK8" +
       "SIKdcZVb25bcCtMhRxoqzE8pD5NNoabpy62cNWpWfc7Kc6RKZ3JLomlu1LWZ" +
       "rbKhzZUnstLcU6ZYlkX1LrPUnOawFqIWt9ksxruuFSlGX0sbWbxZouuazXco" +
       "l0so0pllC4+ish1hrl1YJNeSteE5OVBprqZQ/d3CC9bOIEliBdUUzl3zEoGo" +
       "Gdljtc1iqKQ0PhHhNiP04OFOzRtznuQalB/7+IhTXI7yZgkGT8VeKq8m2WoR" +
       "ZW1bdoJOAx0xa1uNpJBFBY4iB/BkzvBEm6M2O5cSa1orWfMLelyzQnXGSDWN" +
       "yhZ+D2czfBqOI8vczeEkHwwCpTbmRrUk9Ly2I/pdPWhbHWkuqj3B7uzo3Byx" +
       "TU4aOPiiIxmGhhgbKKcGKC9KodUzx6rjinPH2AVTbcrRK88aeCt+bHLtWGrv" +
       "IF4KUZ3SFz3GxOi8LecTv+6qmuSPyG2z52zlhsKM9YRiW+qOwyx01lI1Pxmj" +
       "rUm2lgcTqdapkbaImWMed01IpjW8SYSUm4sY3153R83F2Jw00HDdzWsKk85x" +
       "psNGitVkjWRqtepuV1BcZKhJwYCnFLSj1YEQYSwlq4I5SVVBsgNf0waeOKs7" +
       "1bWoNcWa4aYC2Ru4DiHW1TEarMUagsNTiVYgJKt3OKKGIZ1tk1yx25Y6oBwp" +
       "sSm+zi4QOlYWa2+byaO+LvbNBjsMZgrGwH2hRo3t5qS6dHe7kb/a5DiTMd2V" +
       "z+fz2ZBYQ7TQpWgEma1Jx1RjbMnFMzSWsloWDoxVa4CKubJFrTQQyFm+SdtN" +
       "skf4as1YQQuOm1BhXO2b6/ZQV3uBwJECulJEZCLwQwtVbTiyN3W232Y2lmOw" +
       "dVuwyazXEFRy5PaHvLb0GMI2ZiwmjDoLodnbqSsRGyyztgoTrYBYqGOrqVdj" +
       "eMnlcRapcNtK287EqtMiuVDQubnFfNninXSh920bysUJrA8JpzsN6h1vMrJ4" +
       "UWtHbWpVS2auZ3LZYKvV+0DV3AWWM4ZjtuGmkTairm0PkT6EZuY0GRP6rIs5" +
       "vZ4x19nIascuuW60luvGBN9CcGOpEUino4+5Xo1jBtvBfBwMvW5mGc5W0eju" +
       "bqo3kqbIJAKhmd2Mp+luR7PlnrazCaba6ivbviSF7Waba4yzJkKQjclwvaii" +
       "qZjN4XyF7vS2pRiWydd4P0iTHraD1CU/yvqKh5GNmrcghAkjYwvcarYgz2/k" +
       "3nKNx8y4BlcNilrEXtOoj0krmuVAs7L5nMK5TjrSN/NG5rqpkcJNG8+ri+ES" +
       "ElZuY4GbbM+cuu1cU6sbXSLrdVSDpHyB1R0q5puNjufyjZXAVWsu3ub6szyv" +
       "V4lOKE4Jv+atEXZktAeMItLBLiKn0CANTZHtN+x06y1X7V1UG1NIbbtS0+ZE" +
       "Mhq98Wbs8zI2bVX5nk0J40aYM7GH9autBGIGNYSD6RWErJvQENJ6fM2tTblp" +
       "B2clYYksCBWxA1rFXH84Z7yB1qG5zTBee9NV3Fu2nWm74bBSQBAOCxQ9zaiJ" +
       "NZazZaJZ5lri26Y3gqURcGt+zi7y+ZL1mc7ccrihMeSUakdutLbVAdbDw7bS" +
       "JozNLK0tDUfEw9BvbGAui/HcxaZpF6O21RrVV2hiNFGUmo4IeJbJ2xXS7COz" +
       "1XJXE2h+gSfL+SiBEDyqd1YUofSY1VCrtlpQOgns5aYHC9JmxGLB3OjzVn/L" +
       "WPRk1FZtbS2LcHM2w5fVhgElibFk8THwego1cedTiUHROgZV4UkNjzCNbfes" +
       "5iQPnXjVzDGFb1JMU8KJ6nRt07UorjbSPo7gars14Xg43HnLoT+D1jNIFOxG" +
       "NNoFOdzW+/EChcaDlcp1CZZYoNgYcX2GWuwydIW2iWo9wEdudd5vOExe5dnW" +
       "qp/z8RarLVPbdKSRigwHXEZgdQKhV/gI7uRTVsCxrQmijUSaeYukmhOwhzXW" +
       "mVpdzcT+oifIQQTX84CznQ5GMH4KuwwQA2SgiQP31zULKCfXtcMR3ou1pmAa" +
       "JreuDWfjKoapNZFwU0ppkSGyHnD0pr8dD7GoO+Oi2Fzas0a6NPMRlBi532vh" +
       "O749NEfhhhfrycKa8t0hh/mpYO8aTtJIJ36AyZDUIfS12s46GjusSoo+nqcT" +
       "alYTB0hA5VvCYWo01MMTVG746UoQ0HTGdxw/xFLej82tv6nJ1QYD2ROVmjsY" +
       "T4UUx45iF24uma7UV6Veb7eas2tdN9NOvGB3GT5jUA0VlsFY7dmtJIapborP" +
       "XWjUsXO1g6gjZSgiGLP1ZgjLm5vebjax2U5Hk3ejhISZfDUbqEpW58ztQG9j" +
       "Xa6erekhRQycbGLkM96mNLMGU5iwI2AJX6IwmvN8jC6m/tLDeBYbo3Nm2RjH" +
       "E4GSrAVjTtRRXV6QARGaDTes9VNtOqS6XtBxVi0FwrBN14NDvTdCluPVlBxE" +
       "00Zk27Ue1HCDKpXZXMMnp5FKBNWEgvoja8KIZCZsrYG1HY2kPCZ4djvwJHnl" +
       "+UTqG8uFQiStLqYbWqjrjI8hkD7k+5A2RaBkEZBhRndU2hnAjpFnGjq3V0jo" +
       "s5uJ3LJFamgkDtlu4mIbi+vtbKESSZ2ejUTfnm7mcrwdQG6aqqJNTkPJ7WUZ" +
       "guNVhZ5ut3UtoiIUGy25ySqn6jthMViJI8F2GmSt21n36aRpVfU89KikJpjB" +
       "doBQNAOkbYijxRpx8qG3tkLSRsP5OG8v8s7OI4TetF8lWtiqu210Jv11vdXS" +
       "Rbmr8h7wEpIwkBeSi2pVlR76ke81DAMmPQHm18zEa8uZvRlPcaIRT+bRdpra" +
       "/hBtCj2ibWjMVuC0mdFZRnVGUlGhk4xZMOR8udJWIpVJKj4SuS65WXe7MAFv" +
       "YXNl0AWwYNOIX1ZpfaRPWSSb61Sv6yCd6Uyf9jAil4muPGsjJKw3B67V7NT7" +
       "3SmjrC2kRi0ANkLN+YbNuh4em5xPDJ2B3+Y2dUxuShqWN7sbKM35Jr9wa+k4" +
       "gXFo3gwENUYtazXGWadX88V0Mw0pvxVtUpiXZvO+0RAsI4sInvGkZizozkKc" +
       "17CZYaN4FrLLhPd74JuNEUhcXwXsekgn8nAza0f5AmkZPkbOG+K8m1fRDtJu" +
       "Al8NwjdCMUEgpE9aQsTFVUVnoYFtbnZzvzUmxm64VboLbAfvZNep6yDmoQc1" +
       "G1VpaTtDSaTX5WaazbdH+oqBNILhmvWwIzskjxojPTWckEP6kkPtzO0cKH4/" +
       "pzpcQE/EFoM3anIfxVbU3LNtzPBXrSUmo8yuvhsnbG77GD6HhJjMZKiLOJi5" +
       "GQuMEWF+dUylM7+DMQluqii+woLBnN7Vkg0x7s6rw5BTHdbf9atKipPbmdtM" +
       "F4MxFKCjXbaL4tZutsA5Mg86u7ntrmQZHk7rZnsuuawxnoP4VgJz7+bpkARz" +
       "q2R3lncRt055HsdPU8erD7RAEQxRzQZrcjUK4hUO6dOgNfYdEpm5MjaQNjhE" +
       "wgtxOZsjcwvNRaRRm/GoumM4BOM7yzwn66uuP+I8dR2t2QaCo9t+N+x45A7H" +
       "TM6jukaj0eF6htshUmSMztQgwMhc0ocJo/vEclZvNOoCrdhzLxgJzsjOllAV" +
       "GzjLdTr3prVmPIeQKY0RMx5j55Q6zCWoKqUcqXUwyR0MN6koLnOz3ZK6UeQw" +
       "K9/y+hBNGvxGbHKKgQmCp9V8zMVRup3iDdjxGmqVhVoLDjNgdgRbm7Fh1Deq" +
       "7mzW+ABeLu2BOLDq2wkMeejAkPxFXW416JYjGTzQ12VA8Vt2Sq+imj1Kkkab" +
       "Xppx2w7kMdymYC/aofDC8PoNzNF1eOUgRDR3Z6sBF1CsIvW3bSfXdkIPj21G" +
       "b7lNrrNyq5IGPo43uifb9eYwMRh02KHXYRMZkISPuI6mUw4IFQKoGw5aBk/3" +
       "VFtfIqhGkhIqrAZBVW5ruuqIIAZBPbKVT7HejNaVQVOWWtRoaUFVRR3RMkRp" +
       "S6hnSIa0njjoqO9mmgs7QxKYfQZ1JmoMb7KN0plQgeJ3p7N+TgyrKI2q5mSe" +
       "Uj2TDHgFEwzDyAjERQLTtIothw+Xx1R/441tjzxW7gSdXNOxXbSo+PQb2AHZ" +
       "ntlnPNk1K3+XKkdXOo7/z+yanTlYunC86/TRN3tJoThDe+pe13jKw8LPf/yl" +
       "l7XxL9cPjnYr8aRyJQnCD7l6qrtnaLpU5v3bz9mLXcAPHfHzofO7gKcSu/sW" +
       "4Pu3d9uEvXDaoFY2+PJ9tlZ/rUi+BCiO9WS/o3XXHaw0sLTTpfu732/z6uws" +
       "57h+vCj8IfA0j7huvjVcn2Xqn9+n7jeK5J8Ahs1jhktBnTL36ptgrlTTJ8Bz" +
       "84i5m289c//yPnVfK5KvJJXLgDn++MzulLWvvgnWSm19DjztI9bab7m2ImWD" +
       "f3sf/r5eJL8P+ItP+fuHp/z9wZvlr7g4Jh7xJ76l/B3j0Q+Xe9J3vW4xK7NH" +
       "NzTLsb55H1H8SZH8x6Q4i/bCTaKfYNg5mfzRm5DJDxaFxfHxC0cyeeEtX/M/" +
       "Lht89z6M/mmRvJZUrqmRriT6XkqWbx5L9N3nJLpvoGt08XYqh//yRuSwTSrP" +
       "v67ra8VdnCfuuIq7vz6qfuHlaw+962Xh9/dHx8dXPK+wlYeMjeuePcs/k78U" +
       "RrphlZxf2Z/sh8VfcTzz9P19WVJ5AKQF");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Lxcq+z4PJpUn790HYOBJ/myvy0CpzvdKKhfL/7PtriaVq6ftksqlfeZsk0cA" +
       "TaBJkX00PF4w+vXfQCKWcRIpatIJ3OL+HBA6kHW5BLPyCPbCGfd6pL3lYj/+" +
       "/Rb7pMvZO2UFGeXt6+Pz1c3+/vUt9YsvM6OffK31y/s7baqr5HkxykNs5fL+" +
       "et3JGe177zna8ViX+h/43qNfuvL8cbjw6J7gU0s6Q9szd79A1vPCpLzylf+D" +
       "d/39H/1bL3+9PND637QUbb4WLwAA");
}
