package edu.umd.cs.findbugs.ba;
public class ZipSourceFileDataSource implements edu.umd.cs.findbugs.ba.SourceFileDataSource {
    private final java.util.zip.ZipFile zipFile;
    private final java.lang.String entryName;
    private final java.util.zip.ZipEntry zipEntry;
    public ZipSourceFileDataSource(java.util.zip.ZipFile zipFile, java.lang.String entryName) {
        super(
          );
        this.
          zipFile =
          zipFile;
        this.
          entryName =
          entryName;
        this.
          zipEntry =
          zipFile.
            getEntry(
              entryName);
    }
    @java.lang.Override
    public java.io.InputStream open() throws java.io.IOException {
        if (zipEntry ==
              null) {
            throw new java.io.FileNotFoundException(
              "No zip entry for " +
              entryName);
        }
        return zipFile.
          getInputStream(
            zipEntry);
    }
    @java.lang.Override
    public java.lang.String getFullFileName() { return entryName;
    }
    @java.lang.Override
    public long getLastModified() { long time = zipEntry.getTime(
                                                           );
                                    if (time < 0) { return 0; }
                                    return time; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZDXBUVxW+uyE/hEB+gITyEyAEOvztllqqnQAFQgLBzY+E" +
                                                              "ogYlvH17N3nk7XuP9+5LNqmxLTMO6FgGKaWolBlHOkWGFqbaUac/op1amFZn" +
                                                              "WqttVaijzohWxjKOrSNqPefe9/b97G6wTm1m9u7de885955zz/nOuTdnrpJS" +
                                                              "yySNVGMxNmpQK9amsR7JtGiqVZUsazuM9csPlUh/3XWl644oKesj0wYlq1OW" +
                                                              "LNquUDVl9ZF5imYxSZOp1UVpCjl6TGpRc1hiiq71kZmK1ZExVEVWWKeeokiw" +
                                                              "QzITpFZizFSSNqMdjgBG5iVgJ3G+k/iG8HRLglTJujHqkc/ykbf6ZpAy461l" +
                                                              "MVKT2CMNS3GbKWo8oVisJWuS5Yaujg6oOovRLIvtUVc7JtiaWJ1ngqZz1e9c" +
                                                              "PzRYw00wXdI0nXH1rG3U0tVhmkqQam+0TaUZay/5PClJkCk+YkaaE+6icVg0" +
                                                              "Dou62npUsPupVLMzrTpXh7mSygwZN8TIwqAQQzKljCOmh+8ZJFQwR3fODNou" +
                                                              "yGkrtMxT8cHl8SMP7ap5ooRU95FqRevF7ciwCQaL9IFBaSZJTWtDKkVTfaRW" +
                                                              "g8PupaYiqcqYc9J1ljKgScyG43fNgoO2QU2+pmcrOEfQzbRlpps59dLcoZxf" +
                                                              "pWlVGgBd6z1dhYbtOA4KViqwMTMtgd85LJOGFC3FyPwwR07H5o8DAbCWZygb" +
                                                              "1HNLTdIkGCB1wkVUSRuI94LraQNAWqqDA5qMzC4qFG1tSPKQNED70SNDdD1i" +
                                                              "Cqgmc0MgCyMzw2RcEpzS7NAp+c7nateag3drW7QoicCeU1RWcf9TgKkxxLSN" +
                                                              "pqlJIQ4EY9WyxFGp/pkDUUKAeGaIWNB893PX1q9oPH9B0MwpQNOd3ENl1i+f" +
                                                              "TE57eW7r0jtKcBsVhm4pePgBzXmU9TgzLVkDEKY+JxEnY+7k+W0//vS9p+lb" +
                                                              "UVLZQcpkXbUz4Ee1sp4xFJWam6lGTYnRVAeZTLVUK5/vIOXQTygaFaPd6bRF" +
                                                              "WQeZpPKhMp3/BhOlQQSaqBL6ipbW3b4hsUHezxqEkHL4kE3wmU/EH/9mhMYH" +
                                                              "9QyNS7KkKZoe7zF11N+KA+IkwbaD8TQ4U9IesOKWKce569CUHbczqbhseZNJ" +
                                                              "Kd6nGL26bcqAmCrdJDFJ/Iohj/FhLZRFjaePRCJwGHPDUKBCFG3R1RQ1++Uj" +
                                                              "9sa2a4/3vyjcDEPDsRUjMVg3BuvGZCvmrhtLSrEi65JIhC83A9cX5w6nNgTx" +
                                                              "DwBctbT3s1t3H2gqAYczRiaByZG0KZCIWj2QcJG9Xz5bN3Vs4eVVz0XJpASp" +
                                                              "k2RmSyrmlQ3mACCWPOQEdVUSUpSXKRb4MgWmOFOXQRmTFssYjpQKfZiaOM7I" +
                                                              "DJ8EN49hxMaLZ5GC+yfnj43ct+OeW6IkGkwOuGQp4Bqy9yCk56C7OQwKheRW" +
                                                              "77/yztmj47oHD4Fs4ybJPE7UoSnsEGHz9MvLFkhP9j8z3szNPhngm0kQboCM" +
                                                              "jeE1AujT4iI56lIBCqd1MyOpOOXauJINmvqIN8I9tZb3Z4BbTMFwbILPEic+" +
                                                              "+TfO1hvYNgjPRj8LacEzxdpe4+HXf/rHj3Bzu0ml2lcN9FLW4gMyFFbHIavW" +
                                                              "c9vtJqVAd+lYzwMPXt2/k/ssUCwqtGAztq0AYHCEYOYvXNj7xpuXT74a9fyc" +
                                                              "QSa3k1AQZXNK4jipnEBJWG2Jtx8AQhUwAr2m+S4N/FNJK1JSpRhY/6xevOrJ" +
                                                              "Px+sEX6gwojrRituLMAbv2kjuffFXe82cjERGROxZzOPTKD7dE/yBtOURnEf" +
                                                              "2ftemffVF6SHIU8ANlvKGOVwG+U2iHLNZ0Ei9DjHFAORBDHEna3hs5iRYyIj" +
                                                              "87Nezadv4e1taCcukvC5FmwWW/6YCYalr87qlw+9+vbUHW8/e40rGSzU/C7S" +
                                                              "KRktwiuxWZIF8Q1hTNsiWYNAd9v5rs/UqOevg8Q+kChDdWJ1mwCs2YBDOdSl" +
                                                              "5b/84XP1u18uIdF2UqnqUqpd4rFJJkNQUGsQMDlr3Lle+MRIBTQ1XFWSp3ze" +
                                                              "AJ7L/MIn3pYxGD+jse81fGfNoycuc+c0hIw5nL8E00QAjHm57+HB6Z999OeP" +
                                                              "fuXoiCgYlhYHwRDfrH90q8l9v/17nsk5/BUoZkL8ffEzx2e3rnuL83s4hNzN" +
                                                              "2fzUBlju8d56OvO3aFPZ81FS3kdqZKe83iGpNkZ3H5SUlltzQwkemA+Wh6IW" +
                                                              "asnh7NwwBvqWDSOgl1Khj9TYnxoCvToX9BY4eLAgDHoRwjudnOVm3i7DZqWI" +
                                                              "L0bKDVOBKxjsvBRytaSGwKZ2AuHAPCYCEX/eLvAV2zXYdAlJdxZ1y81BNRY5" +
                                                              "qrgqFVLjk0XUwO4nsNlWYPvFhDIsC5k52uUY+mMhBT71PhVodj5uv5AC/f+L" +
                                                              "AsWEMlIB9m9DHVwkrM/DST4d0mz3BJqJqZuxWZ7bCv8rI6Hi1593PEiIuHtZ" +
                                                              "XqQMLFQDIlbOK3an4fexk/uOnEh1P7JKAEld8J7QBtfgx37xr5dix35zsUBB" +
                                                              "OpnpxkqVDlM1BF3zAtDVya97Hg5cmnb4d99vHtj4fkpIHGu8QZGIv+eDEsuK" +
                                                              "o2F4Ky/s+9Ps7esGd7+PanB+yJxhkd/qPHNx8xL5cJTfbQVA5d2Jg0wtQViq" +
                                                              "NClc4rXtAXBalHOaBvSROfBZ6TjNynBQeG6ZFxER7MYKVD7FhE2Q7MdDc5Gg" +
                                                              "n4qqRNFjHd1tWZkaaFfOdw82I4xM0g2q5VNrhs2g3KCOzXlkZYORVZWLrNxq" +
                                                              "dV6t0g3+YCopOkEw/jcJHAfaDD5uBRFpIXxWO/Za/UEYv5iwCYx/eIK5I9h8" +
                                                              "GYqoAcrabVVFTMihsWfU+4saFYf3/z/MV+OC3FpH47UfhPmKCZvARN+YYO6b" +
                                                              "2HxdmC8hWfhsCvU5TQUvyIhYvXbSgsuskoG7y7Dz3HNrz275QHPP7wWg3lSA" +
                                                              "QdDNPBW/f8dre17i0FOBWJcLeB/OASb6rmU1Qvf34C8Cn3/jB7eNA/gNYdDq" +
                                                              "vN0syD3eYGU5YYkYUiA+Xvfm0PErjwkFwvVgiJgeOPKl92IHj4jsIF4AF+U9" +
                                                              "wvl5xCugUAebU7i7hROtwjna/3B2/KlT4/ujziHpgB+qrg3koQ9cRIM2Fxvd" +
                                                              "9MXqpw/VlbRD0ukgFbam7LVpRyoIvOWWnfQdgvdi6MGws2U0OCORZW7VzuPp" +
                                                              "+IcQT1lGGoq89+CNY1beK7N4GZUfP1Fd0XDirtd4zs29XlaB56UBIPw1sa9f" +
                                                              "Zpg0rXC9q0SFbPCvp6EgKlyEMBIFT0aapwTpDwDZC5BCieV2/dQ/YqTSowZh" +
                                                              "cmD6eaiMnWlGSqD1T16AIZjE7kWjwA1WXBqyEV+pQnyHN/NGVWmOxf/wgLHE" +
                                                              "3/9df7PFfwD65bMntnbdfe32R8TDh6xKY2MoZQp4mXiDyRUUC4tKc2WVbVl6" +
                                                              "fdq5yYtd368VG/agco4PvdrA3wz0hdmhVwGrOfc48MbJNc/+5EDZKxC1O0kE" +
                                                              "Tm36zvzrVdawoZLbmciPJii++HNFy9Kvja5bkf7Lr/gF1om+ucXp4fr4wOsd" +
                                                              "54beXc8fnEvBA2iW3/s2jWrbqDxsBkJzGrqphO8O3A6O+abmRvGZjJGmfLTJ" +
                                                              "f1yEy/0INTfqtpZygnuKNxL4R4Tj+pW2YYQYvBEfIj8h8ECAb0l/otMwHDCO" +
                                                              "DBk8Zr8dRig+yJl/zbvYXPoPeCFVXwocAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aecwsWVWv983Me28ew7w3A8zgwKw80KHhq67urq6uDIN0" +
       "bb1X9VZd3aUy1N7VtW9d3YWjQKJDIAHUASGB+cNAVBwYNBIxio4atkBMMMQt" +
       "EYgxEUUSiBGNqHir+tvfe8MisZO6XX3vPeeec+45v3OXfvob0C1RCJV8z94a" +
       "thfva5t4f2Wj+/HW16L9bh8dSmGkqaQtRdEU1D2mPPSxy9/+zruWV/ag8yL0" +
       "Asl1vViKTc+Nxlrk2WtN7UOXj2tpW3OiGLrSX0lrCU5i04b7ZhQ/0oeed4I0" +
       "hq72D0WAgQgwEAEuRICbx70A0fM1N3HInEJy4yiAfg4614fO+0ouXgw9eJqJ" +
       "L4WSc8BmWGgAOFzMf8+AUgXxJoQeONJ9p/M1Cr+7BD/5q6+/8js3QZdF6LLp" +
       "TnJxFCBEDAYRodsczZG1MGqqqqaK0B2upqkTLTQl28wKuUXozsg0XClOQu3I" +
       "SHll4mthMeax5W5Tct3CRIm98Eg93dRs9fDXLbotGUDXu4513WnI5PVAwUsm" +
       "ECzUJUU7JLnZMl01hu4/S3Gk49Ue6ABILzhavPSOhrrZlUAFdOdu7mzJNeBJ" +
       "HJquAbre4iVglBi654ZMc1v7kmJJhvZYDL34bL/hrgn0urUwRE4SQy86263g" +
       "BGbpnjOzdGJ+vsG+5h1vdNvuXiGzqil2Lv9FQHTfGaKxpmuh5irajvC2V/bf" +
       "I931ybfuQRDo/KIznXd9fu9nv/W6V9337Gd3fV5ynT6cvNKU+DHlg/LtX3wp" +
       "+TB+Uy7GRd+LzHzyT2leuP/woOWRjQ8i764jjnnj/mHjs+NPL970Ye3re9Cl" +
       "DnRe8ezEAX50h+I5vmlrYUtztVCKNbUD3aq5Klm0d6AL4L1vutqultP1SIs7" +
       "0M12UXXeK34DE+mARW6iC+DddHXv8N2X4mXxvvEhCLoAHogCz/3Q7lN8x5AG" +
       "Lz1HgyVFck3Xg4ehl+sfwZoby8C2S1gHziQnRgRHoQIXrqOpCZw4KqxEx42y" +
       "BIumP/GSUNEYIBAlxdLu135O4/9/DbTJNb6SnjsHJuOlZ6HABlHU9mxVCx9T" +
       "nkwI+lsffezze0ehcWCrGNoH4+6DcfeVaP9w3H1Z2r/BuNC5c8VwL8zH3807" +
       "mDULxD9AxtsenvxM9w1vfegm4HB+ejMwed4VvjFAk8eI0SlwUQFuCz373vTN" +
       "s58v70F7p5E2lxlUXcrJhzk+HuHg1bMRdj2+l5/42refec/j3nGsnYLuAwi4" +
       "ljIP4YfOWjf0FGC4UDtm/8oHpI8/9snHr+5BNwNcAFgYS8B3Aczcd3aMU6H8" +
       "yCEs5rrcAhTWvdCR7LzpEMsuxcvQS49rimm/vXi/A9j4eblvPwSeVxw4e/Gd" +
       "t77Az8sX7twkn7QzWhSw++jE/8Bf//k/VQtzHyL05RM5b6LFj5xAhZzZ5SL+" +
       "7zj2gWmoaaDf3713+Cvv/sYTP1U4AOjxsusNeDUvSYAGYAqBmX/hs8HffOXL" +
       "H/zS3rHTxCAtJrJtKpsjJfN66NJzKAlGe8WxPABVbBBwuddc5V3HU03dlGRb" +
       "y730vy6/HPn4v7zjys4PbFBz6Eav+t4Mjut/jIDe9PnX//t9BZtzSp7Vjm12" +
       "3G0HlS845twMQ2mby7F581/c+77PSB8AoAuALjIzrcCuvcIGe4XmLwJZ5Zgy" +
       "M/08LPOAPGy9UrTm6W1/l96KuYaL5lcW5X5up4IlVLSheXF/dDJmTofliUXL" +
       "Y8q7vvTN58+++UffKpQ8veo56SIDyX9k55V58cAGsL/7LEC0pWgJ+tWeZX/6" +
       "iv3sdwBHEXBUQKqPuBCg1OaUQx30vuXC3/7Jn931hi/eBO0x0CXbk1RGKmIT" +
       "uhUEhRYtAcBt/J983c4n0ouguFKoCl2j/M6XXlz8Og8EfPjGsMTki5bjyH7x" +
       "f3K2/Ja//49rjFAA0nVy9Rl6EX76/feQr/16QX+MDDn1fZtrkRss8I5pKx92" +
       "/m3vofOf2oMuiNAV5WD1OJPsJI83EayYosMlJVhhnmo/vfrZpfpHjpDvpWdR" +
       "6cSwZzHpOGOA97x3/n7pDAzdeQhDDxxE6ANnYegcVLyQBcmDRXk1L3585/Ex" +
       "dMEPzTVYGsRgeNOV7IPw/y74nAPP/+RPzjSv2CX0O8mDVcUDR8sKHyS1C9ku" +
       "THLy8g798rKeF9SOK35Dp3ntaZVedqDWoXrXU4m9gUr5aysv2oWxOnG+uInD" +
       "LXtgz8oZ2bgfULarB8/h+/Vk479v2S4Cq9G5eIfoctc12FM0nxF69j2FLvhv" +
       "zgFcv6Wyj+0XM/L664t1U/76EyABRMVO5ZR8d69s5erhhM/AtgXE4NWVjV3P" +
       "kp3vWygABbcfo2jfA1uEt//Du77wzpd9BcRrF7plnccSCNMTUMsm+a7pF59+" +
       "973Pe/Krby8SF8hak4flf31dzlV/LtXyQj6l1j25WrvVVV+K4kGRazQ11+y5" +
       "YWoYmg5IyeuDLQH8+J1fsd7/tY/slvtnMelMZ+2tT77tu/vveHLvxCbrZdfs" +
       "c07S7DZahdDPP7BwCD34XKMUFMw/PvP4H/zG40/spLrz9JaBBjvij/zlf39h" +
       "/71f/dx11qY322A2fuiJjW/327Wo0zz89BGRmhP8bCOUki0NL2miZHSmW3rb" +
       "pLl1Ftt2ELijJjMy+kS2KNGesbDXbQRjq66FzZMhXkL7bOBs+tMBV2eMVk8S" +
       "PJuw25wltJhAlnhJgT0fkRxGdIUgBhhsrjJvKWxWPS6csMEQrPpwWMaxVj2d" +
       "OoiDJ5iqNRoojqJZBrtcMlXd0O9OttsJO2sNNqzjj3o4WOSOsW7cMoOZyEdS" +
       "lgxwJRra/BKuzgW7Xqt5PS1aldOFHSCcAARMeGpm4yKDms5iMxE5H+FnPrmy" +
       "69OWP1aQpWkGGGKJTg8R6c2MnglCT9M8y0xHWWfqM6KZMRMg7UBdGUQLNWdG" +
       "t9oqWbDZarTHfcOedpNVO7AUeGvJel30m9taHbEHs960Qg7YSbUl9wSv4c3M" +
       "qCskE3QhJSuj7nHeetzvrGN+pgBlTEnoImBixQzRcGWYjRdpuZzO1U7ZnbeR" +
       "sFXly/Fs6VjBSHJK5anEi9IWRoek3bVIq7SwJIku1U1lZpQpL6lXXJ+Phok/" +
       "6w+ycOrPl5gz2RqpyDamnTRojkZZz16RnLMsNcQuM0rHVZ2jWC/ZtqwwHmym" +
       "DaVtNyaDISb5qOeNeRxlgrG2ZjDFTMmR1Mc7DCFNxO5UiKmeNZvq0lgwGmBA" +
       "aWEGSrBQ8C5ir3rGRNm2alWdNTyuMuIrJd9RQo7WR5k8tn0/QnG1r3jiRvcF" +
       "e9YyCLWeIepyIcdcs9abmUE6mA5iQ22g/S7XYsgqsx2m6biMtVGvQTVlUhC3" +
       "hoy02f5U7VgtkkBSa8ZPxkkHr/VDacQ2hSCgmmgwyMhawLSQeDLsjViawsoT" +
       "llIpxCQDw1HKA4PcDrK0MlZoP5tgbNMvKZgL8qZkVNVQwEaeqZAaj4wFRcen" +
       "Rs/abPoT1g/sbmdUoxe4sN0wLR/2LYrne02tJXUElmjg1eEcCXBv2MaJ8iD1" +
       "RyynVmnWRsySPqVRTBOwsLyKewoRgYmtge2bQWRzhwcjZP2ZRdG9Ram7od1F" +
       "CbNKQhmG1xPcL9kyP+uLI8W35jKf1WgNifzahukKklO3W9OFO541NXHan/E9" +
       "FF53uPloujUkRhqqdXnMCCNN9Ie95cCvwsSSs0ejiRQQ/brpy0JVri0jvq1l" +
       "m4C22v2aRVdTh4fpNow7y8GijY+27ATrWT3R07CMQRC21GuWOlYqS1RjOqrx" +
       "eEeLuJ7QUzS0jpN8W1ayQF5Gmsh2e2rdbfUrdVkJmg4Zql2K6cIdb7mCmWVf" +
       "HDMrSRuOyW7aag8pvkeQTKs6RsYjpFTiV3gkVaQaXF1vVwpFD6lozK8GM6NK" +
       "JOuWSK6dcBn3JyFt1tFuZ0k2qk1cmaNp3WWN6YZKCSWWp9UIiavtihE0F0o2" +
       "NiViK7bKPZHsCKvKSOm28HmGymx1FtW02Swrz7t+c+JblTEImtCxR1WnSZLC" +
       "kBvRKnAv3p/Me2O5NjAEh2OAgcfOlImixQpAky6aEjfAOlS3QbM1fLkZSH0R" +
       "bZGlre6ualUlLnGaUAe+aqVc0hr5NSLY4lvSQuskxo3S3lIbCxgGb7PYWdUw" +
       "r03VmKi2lbtDGuO9iRvRrXaGD9Z9xloO8VUjq0YZO1y6hlO2RrJHDlYajTST" +
       "1bRmdtC63SHIQEUGW87nuLmUdDussw46bKODx6JcFWuEPB0wqdzpD2lTKZWm" +
       "Oocs1wvWWA3Hq0ZfUuhso/pardSe63DYXlWJLCk7dsVWWJzpCzVjsGUYud2R" +
       "1oKCr+NuMGuqJXuRpYPhPK7AFhxFPJkGcauZxUG5uWiT9IJbrOfsCtv4yXyK" +
       "1SRc3yrABasW0hyJc7ZXW5m+SxNdoVXpxptGc7Tk02ZYcUqTGgszwI+Q7sQf" +
       "LxdwfaOtubA73JQiel43Um8Vjs046Q+a8rpirRJdZ+Zao6Ks6HFrzG3EjBtO" +
       "exSm0vCWiDl+7NJ6RY81R9dnTH3S7vCNJmuvey1ulrZKfMVs91mxTJs4tWoz" +
       "TW5MUG3alarLCDXHi21n1cBYLZPUdU1DYolUEmtNooyTCgJcX5ALyQ4bWGCn" +
       "Jby0lvm20IC1WjlsTTIeJrFJb2zFqZlsBLHDNEbIcspGprBgmyq+RsMI5gNO" +
       "WxuNUckil5QKkoKTklFlQVCcOrFRGW7U5kMkQRpJR2UqfOAGfOCrtZDpdi12" +
       "xLei0YCyw2rf1kqDcYeYjpA5I0z8aqY1u1gfHnTcqr/YtKjSKtIaiN7SWW+r" +
       "JEpJKS87Ker2G3S5PGqu2g6KldpEXcRxnNOGejL3TBIk/+WinY4pPWzj5aBh" +
       "42sYwdzIQmGC90Sr39B14DMVrRq6Sb9RjWpLNmMresYT9ippqGidW3NViRmK" +
       "DYSZVC01EHtao2q2fNYSq210wtt2nI1SS3OaJWFZ7whS5C4xNk2JdSBQE86w" +
       "kd5yhQOU23jkeurNcWJR0/pNg2p743SVqC43c6omRomB0OmX5R4144jeZhWt" +
       "ifE2liattCdWmkm7OSQXJD2Htf66Oatk84XatLvqRkS2DYRgxws0CI2AmfVX" +
       "VnnOp1zNjVhbWAzXzJLqRCRqoZWEX5ScwZKYYshwOfPUFZqs0SYJ66V+MxLo" +
       "AYg93MGp9iy1wgFMTaY1texkVaIbdAMxn3tMJteNsFNvmwgKMgVtdpJ2LM6D" +
       "0aDPjKiOLXO9quTWdG1jwQnn0ktkiHV7TdpWG11sRMS6salimxBVzU0VzSKe" +
       "IDjf9TdWMKPsAUIw1awZU7OthGNtA1UcV66pOL5ux6uabvmdditpjMRWZ13S" +
       "KDpKel6FqfW2cFTChxGmRS0VKw0llyhtu5ulpcLBsM1uGps+qnSnujyaNVG1" +
       "0jXKaTwCSZolbaUWzuPmnJDAyk8i1pMxpxNifbpity4x0lp1kdnQY2yw6M0o" +
       "jFnSlRE2UCkFbRluLQjGLLNqq0gsiGARw+icmjYqndpmUDYqATpjw2VUMao9" +
       "ksvmtiUuuPFMFPohuwnUWT0uG9XSgvR8zqJTeKV0201doig0IcaM35lvBA4W" +
       "JZinF2sUrFsWG1jr9NAOvmy0FoHXVEJJns2Y6cBcRoLOl2qRxCz0KpzBg1mJ" +
       "A6sNsFTGeH05dHqkuG6O2dJiwdXlSnujOmRjKejLiFzz6HTEr7edJQA2eWJE" +
       "SWR5LWyLUVm1zYZZBUNH7eEQSwWjak+aI5Vih4QA6w011BDMLDMcIXSVvkbA" +
       "XHMi10OHR0ZrvVojG6RbhVcEprFN2GAXKhWs2XK0paraosWji4W14M1mab7W" +
       "nfKQDlepxaTrmWF2DY0b9my80mmvaquow9SaTInH07WNbsjE4JuazGMmthxz" +
       "cbpyJbhKVOCePa3BySoz275BlIDrVy1vhCvjzqDCbNYqPpgHfgrPbHlMlRPL" +
       "YGTJwfozf7z1OmtOEFx9pBpr1awPWmlU4cscyY1FAZtlydAvdZTRFLFbLS9o" +
       "4CWSXSCy1sPYWkvk9SHCqOU5ZYaxWsuiCj63JQKt80RnmCIRyAyib5TDOYkH" +
       "5QkjD8m1X6eNnr2lB0SHmZYlyU+nPpVSIokSpKnNKrA6ghfBdOKl4lJxqLom" +
       "mQNXsFuTgEKmSL3ZEVc0ZgmrtIkIc5B36VnJH7nbNguzrRlI5RsdTo1+m67C" +
       "uKpjQ0ZPqToqD9zYlVVdq1bGjSm1rG96i8rAE0HqduYmtR3zPFkDa7iKMJNn" +
       "dl1XA3S7iNVqvTFrwZKheLXhWg2b1TQrL1VnCbJLyOlKrTGQu6wCl1CaEnsb" +
       "EuHKFj11qvVsnYUzVUo9sS87ijnsmmap1GaZLd5bryRUtnSsH8IGg3hOKVHm" +
       "fk0PaykXqWhN1uZKQ3fpNdGsmEIVjiorIZQDahMRVjdrhYG/5BpctVnnSpLs" +
       "jMHSadVtOXp/2tURsN2Dyx12qgexD1bUbtJjN/3auDZdlXyhsliMFmuC1kHW" +
       "WzZosimXbdiLB2mbIjmKsBpi2FDHpgGwwoYzeb2YD72hRjKzeeopYIf5aL71" +
       "TH+w3f8dxaHG0W3mD3GcsWt6MC9efnQ8VHzOQ2duwE6elx+fhp47PO8p3eAu" +
       "6HoXQfnu/94bXWwWO/8PvuXJp1TuQ8jewclzGEO3xp7/altba/aJ4W8CnF55" +
       "41OOQXGve3wi+pm3/PM909cu3/ADXA/df0bOsyx/c/D051qvUH55D7rp6Hz0" +
       "mhvn00SPnD4VvRRqcRK601Nno/cezcbdufFfAp5XH8zGq88e1h3P9zWec67w" +
       "nJ2/PMfB/jvPtJ07Pbe7GwjT2+9w9EbR/NxkBd0v5cXbYuhmz9fca3u7fhJP" +
       "4lA7MGfhjW8/7Y23HXnj0Wh3Hh+WcWstDE1Vew4Hvvawvqh44vRh54PgQQ/s" +
       "h/7o7fdrz9H2wbz4QAxdNrSYSWw7D4WjM9xjuzx1Q7vk1e/7v1jgymEMP3pg" +
       "gUd/9BZ45jnafjsvPryzwMlTyrzaP7bAb/0ILbCJobtvcAudX6m9+Jr/vuz+" +
       "r6F89KnLF+9+iv+r4iL26D8Vt/ahizqYupNXGSfez/uhppuFqrfuLjb84uv3" +
       "Y+iu66NiDO3JUiH0J3Zd/xCEzXW6xmDcg9eTvf84hi4d9wbMlFPNfxpDFw6a" +
       "Y+gmUJ5s/BSoAo3566f961wF7u56NudOgOyBQxWTdOf3OkI9Ijl5g5sDc/Gv" +
       "pEMQTXb/S3pMeeapLvvGb9U/tLtBVmwpy3IuF/vQhd1l9hEQP3hDboe8zrcf" +
       "/s7tH7v15YdJ4/adwMfOfUK2+69/XUs7flxcsGafuPt3X/PrT325OKD/X/Km" +
       "aD0uJgAA");
}
