package org.apache.batik.svggen.font.table;
public class CmapFormat0 extends org.apache.batik.svggen.font.table.CmapFormat {
    private int[] glyphIdArray = new int[256];
    private int first;
    private int last;
    protected CmapFormat0(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          raf);
        format =
          0;
        first =
          -1;
        for (int i =
               0;
             i <
               256;
             i++) {
            glyphIdArray[i] =
              raf.
                readUnsignedByte(
                  );
            if (glyphIdArray[i] >
                  0) {
                if (first ==
                      -1)
                    first =
                      i;
                last =
                  i;
            }
        }
    }
    public int getFirst() { return first; }
    public int getLast() { return last; }
    public int mapCharCode(int charCode) { if (0 <= charCode && charCode <
                                                 256) { return glyphIdArray[charCode];
                                           }
                                           else {
                                               return 0;
                                           } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze5AUxRnv3eOe3HEP5ECEE+4Oq0DdhaAxqTNGWO/kdI+7" +
       "4pCqHJGjb7Z3d2B2ZpjpvdvDEMRUlDIpyygak8j9YTCJFKKVxDxMNCQmKuWD" +
       "Eq3ER6JRq6IGrZI/IiYmMd/XPbPz2AdFlXGrprd3+nv019/Xv+/r3kPvkVrb" +
       "It0m1VM0xqdNZsdGsD9CLZulEhq17Y3wdly5+fXbd596vnFPlNSNkTlZag8p" +
       "1GYDKtNS9hhZrOo2p7rC7PWMpZBjxGI2syYpVw19jMxT7cGcqamKyoeMFEOC" +
       "TdRKknbKuaVO5DkbdARwcm5SzCYuZhNfEyboS5JmxTCnPYaFAYaEbwxpc54+" +
       "m5O25DY6SeN5rmrxpGrzvoJFzjcNbTqjGTzGCjy2TbvYWYirkheXLEP3g60f" +
       "fHRrtk0sw1yq6wYXJtobmG1okyyVJK3e236N5ewd5KukJklm+4g56U26SuOg" +
       "NA5KXXs9Kph9C9PzuYQhzOGupDpTwQlxsjQoxKQWzTliRsScQUIDd2wXzGDt" +
       "kqK1rrtDJt5xfnzft7e0/biGtI6RVlUfxekoMAkOSsZgQVlugln2mlSKpcZI" +
       "uw4OH2WWSjV1p+PtDlvN6JTnIQTcZcGXeZNZQqe3VuBJsM3KK9ywiualRVA5" +
       "v2rTGs2ArZ2erdLCAXwPBjapMDErTSH2HJZZ21U9JeIoyFG0sfdqIADW+hzj" +
       "WaOoapZO4QXpkCGiUT0TH4Xg0zNAWmtACFoi1ioIxbU2qbKdZtg4JwvCdCNy" +
       "CKgaxUIgCyfzwmRCEnhpYchLPv+8t/7SW67T1+lREoE5p5ii4fxnA1NXiGkD" +
       "SzOLwT6QjM0rknfSzkf2RgkB4nkhYknz86+cvPyCriNPSppzytAMT2xjCh9X" +
       "DkzMeW5RYvnna3AaDaZhq+j8gOVil404I30FE5CmsygRB2Pu4JENj3/p+oPs" +
       "RJQ0DZI6xdDyOYijdsXImarGrCuZzizKWWqQNDI9lRDjg6Qe+klVZ/LtcDpt" +
       "Mz5IZmniVZ0hfsMSpUEELlET9FU9bbh9k/Ks6BdMQkg9PKQZni4iP+KbEyOe" +
       "NXIsThWqq7oRH7EMtB8dKjCH2dBPwahpxCcg/rdfuCp2Sdw28hYEZNywMnEK" +
       "UZFlcjBuT2YyTI+nYaXinE5oLJ7IUXPAsHKUr4xh4JmfvsoCrsLcqUgEHLQo" +
       "DA8a7Kx1hpZi1riyL7+2/+Th8adk6OF2cdaPkxjojUm9MaE3JvXGUG9M6I35" +
       "9JJIRKg7C/XLWABPbgdMAFBuXj567VVb93bXQBCaU7PADUh6XkmSSnjg4SL+" +
       "uHLouQ2njj3TdDBKooAvE5CkvEzRG8gUMtFZhsJSAFWVcoaLm/HKWaLsPMiR" +
       "u6b2bNq9UszDD/4osBZwC9lHELKLKnrDm76c3Nab3v7ggTt3Gd72D2QTNwmW" +
       "cCKqdIedGzZ+XFmxhD40/siu3iiZBVAF8MwpbCdAvq6wjgC69LlIjbY0gMFp" +
       "9LOGQy68NvGsZUx5b0TUtYv+WeDiObjdzoanx9l/4htHO01s58soxZgJWSEy" +
       "wRdGzf0vPvvOarHcbtJo9WX7Ucb7fECFwjoEJLV7IbjRYgzo/nLXyO13vHfT" +
       "ZhF/QNFTTmEvtgkAKHAhLPPXn9zx0muvHngh6sUsJ42mZXDYuixVKNqJQ6Sl" +
       "ip0Y6t6UAOs0kICB03uNDoGpplXcTLhP/t26bNVD797SJkNBgzduJF1wegHe" +
       "+7PXkuuf2nKqS4iJKJhrvWXzyCSAz/Ukr7EsOo3zKOw5vvg7T9D9kAoAfm11" +
       "JxOIGnG2Lk5qASQGwakasQ2w74zcGgXQyh4AbBaOvUiQxUW7upR5rss8ONxf" +
       "UJiJExJ8n8Om1/ZvnuD+9BVU48qtL7zfsun9R08KU4MVmT9WhqjZJ8MTm2UF" +
       "ED8/DFTrqJ0FuouOrP9ym3bkI5A4BhKFUcMWoGUhEFkOdW39y799rHPrczUk" +
       "OkCaNIOmBqjYpKQRdgezswC0BfOLl8vImGqApg17BVJcGCIWRgbmueXd3J8z" +
       "uXDMzl/M/+mlP5x5VQSlDMFzBHuNjYVgGE9FNe9BwbuvfO/N35z6fr2sBZZX" +
       "xr8Q34J/DWsTN7zxYckiC+QrU6eE+Mfih+5emLjshOD3IAi5ewqlGQpA2uP9" +
       "zMHcP6LddX+Ikvox0qY4lfMmquVxY49BtWi75TRU14HxYOUny5y+IsQuCsOf" +
       "T20Y/LzMCH2kxn5LCO+w1CAxeJY4OLAkjHcRIjpXC5bzRLscmwtceKk3LRVO" +
       "WCwELrOrCOWkOaNNm9nBlNi94TDAw9lofsLmYlSWhL+c+85Pjm6tf0mGQW9Z" +
       "8lCl+cZ1T91j/PlE1K0iy7FIyqvtoWMPr3trXMB2A2brje56+fLwGivjyxlt" +
       "wZzRDo+zYeQ3J+onWkDh2YpO8XiGGTkQwbNJpmd41q3WPj1liEPLKm9Dn89m" +
       "ftDz7O6ZntcFKjWoNgQrrGGZc4WP5/1Dr5043rL4sMj8s9AVjhuCB7LS81bg" +
       "GCU81IrNpoJdKVxGLDUHWXjSCZcHOk/t+H39ziswXJBzo3Twx/CJwPNffNCx" +
       "+EI6uCPhnAyWFI8Gpon6qqBUSGl8V8dr2+9++34Zo2FIChGzvftu/jh2yz6Z" +
       "aeX5sqfkiOfnkWdMGa/YbMHZLa2mRXAMvPXArl/9aNdNclYdwdNSv57P3f/H" +
       "/zwdu+uvR8uU4DWqc0fgz5945Aq5QJpUt2r/P3ff+OIwuHuQNOR1dUeeDaaC" +
       "4FVv5yd8+9E7uXqA5hiHruEkssJ00kw4hffLiHAgLVce0qKc1Jn5CU2FGqQ2" +
       "repUEyq2wGtN7AL8pWCz2acmKnmDlQJiOByaDZ1hreOOneVWEcULCxgsnTA6" +
       "Kpwbh0SMe4nmkuOnal65bUFz6TEDpXVVOESsqByeYQVP3PD3hRsvy249g/PD" +
       "uaHwCou8b+jQ0SvPU26LitsOmddKbkmCTH3BgGiyGM9bejAEuqVvhV8q5Crs" +
       "mtKZoTrPLWfw954qY1/DZhfEhYJOlTFQhfxGEWcJX90U8WayzTlKYNuHTVLG" +
       "wGUVC6/+YNpeBM9SJ+UsrZC2b5ZLgc360vxciVsEviUL+WtDs/zG/2GW38Lm" +
       "mxxOD7S80tuqKC14Ju4uqhafOhK6R/Gfb7wylCAoLq501SUA8cAN+2ZSw/eu" +
       "cnMDlGmN3DAv1Ngk0wIVLfani9NoRfHz4VnpTGNleAU8Q0MWiJk1VWGtEnf3" +
       "VBk7gM1+ThoyjA8Unewt9czp/Bso/0V8lzO6E55VzsxXnbnRlVirGHa4ytiD" +
       "2NwHtSoYnaQlNh/8ZGxeCM9qZ+Krz9zmSqzlz6TCBCH14SqG/xqbhziZnaNm" +
       "IkutBKSDkPE/O3PjCyDQd42Gh8AFJRf68hJaOTzT2jB/5po/yYLOvShuhjo7" +
       "ndc0/xnF168zLZZWhQXN8sQicfsxTrpPf8UH8MWLCfd3kvNxODxV4wTwwS8/" +
       "y1FO5ldggVpAdvz0T3PSFqaHqYhvP90xTpo8OhAlO36S41BHAQl2nzfduuHC" +
       "M7rcLESCEFf097zT+duHij2BSkH8teNm9bz8cwfq5pmr1l938rP3yjsvRaM7" +
       "d6KU2VC4yeu3YmWwtKI0V1bduuUfzXmwcZmLs+1ywt7eOccX2wnYBSbG3sLQ" +
       "bZDdW7wUeunApY8+s7fuOBSqm0mEQmG2ufR4XTDzULZsTpYrUaFuEhdVfU1v" +
       "bj324cuRDnGLQWSB1lWNY1y5/dFXRtKm+d0oaRwktZBGWEGc/a+Y1jcwZdIK" +
       "VLx1E0ZeL55v5uBGofi3j1gZZ0Fbim/xzhT2QmnxX3qP3KQZU8xai9JRTEuo" +
       "lsqbpn9UrKyKzZYCrjQE4nhyyDSdU0/962LlTVMAwd+w2fY/C61E5L8dAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/x8noIbNpSkAAA==");
}
