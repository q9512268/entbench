package edu.umd.cs.findbugs.classfile.impl;
public class ZipFileCodeBaseEntry extends edu.umd.cs.findbugs.classfile.impl.AbstractScannableCodeBaseEntry {
    private final edu.umd.cs.findbugs.classfile.impl.ZipFileCodeBase codeBase;
    private final java.util.zip.ZipEntry zipEntry;
    public ZipFileCodeBaseEntry(edu.umd.cs.findbugs.classfile.impl.ZipFileCodeBase codeBase,
                                java.util.zip.ZipEntry zipEntry) {
        super(
          );
        this.
          codeBase =
          codeBase;
        this.
          zipEntry =
          zipEntry;
    }
    @java.lang.Override
    public int getNumBytes() { return (int) zipEntry.getSize(); }
    @java.lang.Override
    public java.io.InputStream openResource() throws java.io.IOException {
        return codeBase.
                 zipFile.
          getInputStream(
            zipEntry);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.impl.AbstractScannableCodeBase getCodeBase() {
        return codeBase;
    }
    @java.lang.Override
    public java.lang.String getRealResourceName() { return zipEntry.
                                                      getName(
                                                        );
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ClassDescriptor getClassDescriptor() {
        return edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptorFromResourceName(
            getResourceName(
              ));
    }
    @java.lang.Override
    public boolean equals(java.lang.Object obj) { if (obj ==
                                                        null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        this.
                                                        getClass(
                                                          )) {
                                                      return false;
                                                  }
                                                  edu.umd.cs.findbugs.classfile.impl.ZipFileCodeBaseEntry other =
                                                    (edu.umd.cs.findbugs.classfile.impl.ZipFileCodeBaseEntry)
                                                      obj;
                                                  return this.
                                                           codeBase.
                                                    equals(
                                                      other.
                                                        codeBase) &&
                                                    this.
                                                      zipEntry.
                                                    equals(
                                                      other.
                                                        zipEntry);
    }
    @java.lang.Override
    public int hashCode() { return 7919 *
                              codeBase.
                              hashCode(
                                ) +
                              zipEntry.
                              hashCode(
                                ); }
    @java.lang.Override
    public java.lang.String toString() { return getCodeBase(
                                                  ) +
                                         ":" +
                                         getResourceName(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cyM69ir+im+r/wvhg3QFsCIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16ecws11Vnvc/2e88vjt+zk9jBxHZsPwNOk6+6eqtq2Qnp" +
       "tZaurbu6q7srE16qa+uqrn3vBhMSCRKBFCJwICDwX4lmgEAQiwbNiJHRiAkI" +
       "NAOjaIYZaQiDEIRhAkSIRRMY5lb1t78lRLGnpbpdde89955z7jm/e+7y2S9D" +
       "D0QhVPE9e2vYXnyo5fGhZTcP462vRYcU3eTlMNLUni1H0RTk3VKe/YXrf/vV" +
       "T6xvHECXJegtsut6sRybnhtNtMizU02loeunuQNbc6IYukFbcirDSWzaMG1G" +
       "8Ys09KYzpDF0kz5mAQYswIAFuGQB7pzWAkRv1tzE6RUUshtHAfQ90CUauuwr" +
       "BXsx9Mz5Rnw5lJ2jZvhSAtDC1eJbBEKVxHkIvfNE9r3Mtwn8yQr8yo99541f" +
       "vA+6LkHXTVco2FEAEzHoRIIecjRnpYVRR1U1VYIecTVNFbTQlG1zV/ItQY9G" +
       "puHKcRJqJ0oqMhNfC8s+TzX3kFLIFiZK7IUn4ummZqvHXw/otmwAWR87lXUv" +
       "4bDIBwJeMwFjoS4r2jHJ/RvTVWPo6YsUJzLeHIEKgPSKo8Vr76Sr+10ZZECP" +
       "7sfOll0DFuLQdA1Q9QEvAb3E0BN3bbTQtS8rG9nQbsXQ2y/W4/dFoNaDpSIK" +
       "khh628VqZUtglJ64MEpnxufL7Esf/y6XcA9KnlVNsQv+rwKipy4QTTRdCzVX" +
       "0faED72L/lH5sV/72AEEgcpvu1B5X+dff/dX3vftT732m/s633yHOtzK0pT4" +
       "lvLp1cO/947eC+37Cjau+l5kFoN/TvLS/PmjkhdzH3jeYyctFoWHx4WvTf7D" +
       "8nt/RvvzA+gaCV1WPDtxgB09oniOb9paiGuuFsqxppLQg5qr9spyEroC3mnT" +
       "1fa5nK5HWkxC99tl1mWv/AYq0kEThYqugHfT1b3jd1+O1+V77kMQdAU80EPg" +
       "eRba/8r/GHLhtedosKzIrul6MB96hfwRrLnxCuh2DevAmFaJEcFRqMCl6Whq" +
       "AieOCivRaWHpsgUnsOn4NiyZ/hB89DxV68qRNnDjcHtYEPv/33vMCx3cyC5d" +
       "AsPzjovgYAO/Ijxb1cJbyitJd/CVn7/12wcnznKkvRhCAQOHgIFDJTo8ZuDw" +
       "hIHDgoHDOzEAXbpU9vvWgpG9SYAB3QBoAKD50AvCB6gPfuzZ+4At+tn9YDSK" +
       "qvDdsbt3CiZkCZkKsGjotU9lHxY/VD2ADs6DcME8yLpWkPMFdJ5A5M2Lznen" +
       "dq9/9Et/+7kffdk7dcNzqH6EDrdTFt797EU1h54CNBhqp82/653yr9z6tZdv" +
       "HkD3A8gAMBnLwKwBAj11sY9zXv7iMWIWsjwABNa90JHtougY5q7F69DLTnPK" +
       "8X+4fH8E6PhNhdk/DZ5vPfKD8r8ofYtfpG/d20sxaBekKBH5PYL/U7//H/+s" +
       "Xqr7GLyvn5kOBS1+8QxgFI1dL6HhkVMbmIaaBur9j0/xP/LJL3/0/aUBgBrP" +
       "3anDm0XaA0ABhhCo+ft+M/hvX/yDT3/h4NRoYjBjJivbVPITIYt86No9hAS9" +
       "fcspPwBwbOCChdXcnLmOp5q6Ka9srbDSf7j+PPIr//vjN/Z2YIOcYzP69q/d" +
       "wGn+N3Wh7/3t7/y7p8pmLinFhHeqs9NqexR9y2nLnTCUtwUf+Yf/85M//nn5" +
       "pwAeAwyMzJ1WwtpBqYODUvK3xVDt63fUY9LHTjvdmX5Rq3Th0hzgstK7yvSw" +
       "UGXZK1SWNYvk6eisW5333DMhzy3lE1/4qzeLf/XvvlLq4XzMdNaKGNl/cW+4" +
       "RfLOHDT/+EUMIeRoDeo1XmP/xQ37ta+CFiXQogIChYgLAaLl52zuqPYDV/77" +
       "r//7xz74e/dBB0Pomu3J6lAu3Rd6EPiNFq0BGOb+d7xvbzbZVZDcKEWFbhN+" +
       "b25vL7+KqPOFuyPXsAh5Tp3/7f+Hs1cf+aO/v00JJWbdYaa/QC/Bn/3JJ3rv" +
       "/fOS/hQ8Cuqn8ttRHoSHp7S1n3H+5uDZy79xAF2RoBvKUewpynZSuKQE4q3o" +
       "OCAF8em58vOx0z5QePEEHN9xEbjOdHsRtk5nF/Be1C7er11AqkcLLVfA89yR" +
       "Ez93EakuQeVLryR5pkxvFsm37p0ihq74oZmCwCIG3ZuubB8hxD+B3yXw/N/i" +
       "KRotMvbhwKO9o5jknSdBiQ8mwKvKkbcU9NU9QhZpq0j6+2bbd7Wa956X6SZ4" +
       "nj+S6fm7yMTeRabiFS8SotQWCVjbHXlq8V27wBr3NVkrW8kvARR9oHaIHpay" +
       "ze7c+X3F67cBuI3KJcM5Lh63bOXmse5EsH4A5nzTstFjdLlRemJhOIf7oPsC" +
       "o+Q/m1HgaQ+fNkZ7IH7/wT/+xO/80HNfBO5AQQ+khakCLzjTI5sUS5rv/+wn" +
       "n3zTK3/4g+XUAeYN4YXVX7+vaPXWvcQtkuU5UZ8oRBW8JFQ0Wo5ipkR7TS2l" +
       "vScK8KHpgEkxPYrX4Zcf/eLmJ7/0c/tY/KLLX6isfeyVH/inw4+/cnBmBfTc" +
       "bYuQszT7VVDJ9JuPNBxCz9yrl5Ji+Kefe/nf/quXP7rn6tHz8fwALFd/7r/8" +
       "4+8cfuoPf+sOYeL9tvcNDGx8/XeJRkR2jn+MKGlSRxEnYDpoRu0oTCkidNMN" +
       "nveaUtAVBt1A3HYl1efYqKFLA2JmrQi/VY/yWhxoaBVGWmp9mRMjPJoMIq/f" +
       "Gw56LQqmuiLTnZDxbLo1DH/c64rh0Ft2RxE7DozcsKWxMzP5dRutizxRZwZb" +
       "S4zEFRxril5PU76eajBiLrhN1aKpcRDkeDfaBd1FWB2aujT0qojcHNnhTKwY" +
       "K7uyDTZ6O6/GiR6MRhuZHHIENYpXxVo6EDuINK6Nu0vfYWbONFDFvjz2F23K" +
       "nXmJTObdiYpvO7vhKArlljkK6W7Cz8Q8s1bUlOo45nQ4FdSAUa3NAB86484A" +
       "NV2Kb1TSbiY36NkW9fLmpqajUqqh67TriHZKN5JJHk04eSaMatV80sjc4TKo" +
       "NjetbKsSs8ireNHEZaLYZtVma20oNUo1xsHcxf1GBa2h6zxo9gKJcoLljvZb" +
       "yFoMWtyGmvZU2mgvZI/F05gMtbFpCD5WRRy/t1iv1gEx1bgsEJKYzZKGWyUR" +
       "rp0kSh1fCi13tKEG64nZoAbWYDPDvJbEe41dtbdeW84Ww2YGqo2weECPOmsi" +
       "XUxmsMK2WUutxGSn2vcHxKTiD1RcWhsRs+mMqImzaQtVJFAFti92HGucqRaG" +
       "DGe2mK8RmkXi0cTnln1NqiPLkRpvhmwaaO4I7VhbfCUzMc+mxNpH7T4XYkF1" +
       "5IBB8h0tHNC9aZIRnXkkLpmcESrd+s6nqKwRzJfOZKINRBCOSXyWTZZzv2av" +
       "Bha/2onUptXrs51oMRNm8aCCEUib2TK0KHQzpYpL9mpjWkHN72+Wgt3vtgfW" +
       "GOZbebfPOFEmGrMINI1ruel0bU3GQ07Y7VBHi8M4QSzJn03IrmuzM9EnYM42" +
       "qww98XpVZLqpkopJLpBRzhC+5PDoMhI6PuuuezLNTeFGI3VD0cQweCUsmRZM" +
       "uiy6mZrBbqzbpJKEO6wdLxbDWnfFjpdJMDewMSdgWytUqpKsZEtjx2TYZLJl" +
       "kiXnxvAOw1BF9WttXJhXF8A0EERp9YjdggLBxFjE/cTvegg1k6aL+XiLiHSs" +
       "01taZFh0HONei0NYf1sfJZGxsReq2NKzetAzWGrYHcZ6L5FxV9WnyoaNpjro" +
       "ew3a0mYGzA9MulIh2njMm2M3EHNBWlYnKm/pssxhdpyPqWzTIpYAjSRXiD1p" +
       "VGtJir9F+5u6pEyTlRklcxZb94eWQ42yXg8bE8MWOdbRcZfDs26/M6+z0cRI" +
       "WBNtWZY7y1bTidCZMswOY/pmOEAESZ2Kw92s3zRWFaMBw30jwuicGRoKOh1u" +
       "h9POuJNJZrQWd/jSsvGlse6gQ7NPdck1h6HEZDOhjQFOjCWvg2+TRXsINypL" +
       "tdKUZkYPk70m38GtNSIIXSJepI3Gkq54xHarKWGDmiuJvqNGlCmS0Xa8myNk" +
       "3pSzOpN1HSzsTFFYpJYMS5Ne3BbGws5tuTRJiZSwnU3X1YDlNxSL4uom8So9" +
       "p0JmDsfZA4AFcOT64xZXX6EpEpkm1U0ZfGVvqA2p05W8H2MtSxtEMr10x6u2" +
       "32xXKtNufRUQBDkcNLkVb/gzL2uOMqkxFZmtmS56WZtJrSW6lpN25HTQwbYH" +
       "dDhedC2NzLpMKKCkt80QkujKLMoJ5oZLLCeVNiOH16y6Iklpo1KfZOYuYJDB" +
       "IltwwYBOK7y3Y9gVrlDDqgL3qm53g5luxasSi9S18SZstNzVbrrkU4/t8nM5" +
       "4hvN7pKpajsqasdxM5hl4W7RTxeqUqk0UzVp7rAR4yuz2orBa8Sqw0476wCO" +
       "6WmCNNuwsp3YrZHm7lgSc5fCbhM0U6q/nNZCutdxUFrXG51lPutMF2MZ8ZMq" +
       "04Ht1dikxPnI0Bfp2pkveJheJHkwJFrWuIGGk5YRTTE+dFe9Xp1fpFMui5rO" +
       "0mQ4NZw6U5Xt8FjVgqlWtTnFNySsoAIWVXh/WjW48djo1ej5XFFMgVPWyADE" +
       "7DtcdNHqihgupuG0Vp8ozKIzn+T1pJ+kDZ+JG1o2DzZJe1QZGiEbgYUgYgzJ" +
       "tloX1skMraN+KLiruhtiPKv2Mcpy2y0q2c4N0fJS4CLbsZvP8XRWE9jxdBda" +
       "loo1RLytT9AxMegAzWVxOGxNx/31gum7LuuIyKrdbESOxDVbKckOuVmQBrPA" +
       "nzaSIU1teGWGRyTWj90FkagKlU5wx5AT2dyMebPXt6aql1BcVRogeF+3KiNu" +
       "l8ZqDeU7EhpWcK9P8JGAb+xOV8NqdNdo7CwaQZGgxurczgisdRQKCbuR2Xqk" +
       "w/NgO0VgjVY7zUm2NvPtcJxERMPUE7cdV3ZSjKVjVUxozxabBt7RWu14nvAS" +
       "jEkLkUairekTZo+NXKZR38o+a9CdTjcnwZgP+obeyAgrU3o2kA9pjqiGvt64" +
       "euzg4zZLpikISXQKE7JIdFhuEGjUsrWhB1WLjCaZXWlVJIrWVpHg7BY9ncxn" +
       "eGvZ607ybGE4OdXarHncC8bN7QSPHWoC521f6RorNslaE3wTmnXfzpO+Ek47" +
       "EbaTZOCj3LS5GhtNDB5ntXkjzBYNz8P6cNLprCqwI5AwVhEbIsYsliEbpFsc" +
       "HmGBzvSrHdRYcJ3pZDnDfaDcBV3Va0TfVFoW0krGptpMes3E4Ee5p1ZgvbmL" +
       "Zhyst1akMq9uq40qMlrX1oED83icbQejnZr2d1ueryCBnsIVhpvvSJlXArSX" +
       "erMF13fXaHVm5MDzsUnbacqbtt500LYUrIkJvDbpseczjWw7b9fd+tpp1Kmm" +
       "3pwuDJPc9Goh2RjR82WvP3fWwmjhICHZ3S6a65rRGVfRYbOFWAYX0YsmM9LC" +
       "/mCxZYfTDWf3qDkV1uORxeNcQ5ECJR4jDuuyjSzf9mvd2U6VU7bNzd1uTwyp" +
       "jOz6+TZKEH2abnQBaes5yXGyTnasYZp7fM6hWjvlmeYq9OQ2NccyN690LNTm" +
       "KhHSCzewQWMkz8PdLuLi/TTjMzZMEDKgQRxjNoPRVhBmmzGR17FK2m83222h" +
       "Y4x3Zm+9XUx1Q25jAOBCgzQSBcRL8ajvtVvYJM6aPQLPt1u2ajcXq/VoF8I6" +
       "QdetHFbSqR7gHYubT+YjJXcGuZduRi3eH0szmg9gWIlYHnVaSYsUlqhAInGw" +
       "iiLHXowSs45Istpm3U7S6mcpa61xfsEKuGA7lWVzEPhdarTjyRox4JcKguXM" +
       "gAqRJY0JWCBPPFzvYwyjCChnZBqBOUTO7er96awJIu1adTyY92xTWlKeXrOY" +
       "WMKtvjuYi+lkKdbaxDRY4p21qqtZbxXuKCHM41kGvK3WnPgNAUDUcAMzrU1/" +
       "FWek2lxWO+4qhRcVz9nqzLbSl5r42qtWwforF3IGTGJzZxXh/ZU+JIw5bcAy" +
       "v5nY0aSZbRuTGbJt9zdrArEaGCnCtTodokFluQHwB6fyKIZJe6KbtiG1Fy14" +
       "x5pWjcp6wAvFVQsXWpZf7W97vNyg8H7uDhZy4iJJW9HpBZehAwRjd57M0bgp" +
       "dsPRnLJFXp05q6EbEZveuDtr434d0ZyQ8p1RQ6yYBjJd2MQqXY4CdOsiTcye" +
       "wf1o6mZSN4slQeo15TlpK6rt7rhRzdul8MyT5nDGObmyDOQR2ujlETbd1FjL" +
       "7SK0lcIT2fP9USu0Kaq34zp8Bc4kdbyg0YZa4QazQcuKA6al9frJjLQl3F9g" +
       "IQMv56yjrZluIoSjYc2vk8u2Pq3lkTbICdNL27NJW5Wp6jDyl45YxeotKRpX" +
       "Mm2sV3NX6EaphU6aqFYPq6QWRcCV60ugMmwp+SoGoiJ9oE2JHarM+nyIdaop" +
       "1vB2cKsWEkmAx6NaAFvRuF5PxKU6qmbGPB3uFLObtmik3/GW29YSmzjSmm+P" +
       "rYGJzIcW4fU7SZx3gla6RfXKcCYQzeHQI9f1oQ6jPQmXw7pkDaZ2xnerWaft" +
       "4gOvI/O1ftTq0N10iMQJYdb0EG4uwKpp4w3ZCN3VmhK6IzO6rqIN1MLnXdPL" +
       "YH8h0yIbYRLSAjFdUyN4fqdpKd8LkwZJEMq4papiTzEZrDsFbIVNq4cMc1mU" +
       "4nna1xGEm9grEOZTXavWcHsavRu3MmbDthm86Y3jINiK8BSuB5vVitBRPG0Z" +
       "c6+9kqdmZ4LXxWbDkpTdimKiGtXwaGZUEwQZ5uZtFVvWchmRXRhurnR7OJqw" +
       "g1oKT7HxwjVcW2tNjRqs5HWYHnrUEMwYethuwJP1rAuPSFy2PN+hGkLXUhed" +
       "ClcJVhsNxun+bNJZLhG5QtVCMRaJYGV3Y3Q223i4HDFoOJCWZH2xW67XQ7nB" +
       "zxp+xNYszCQCAslqzHAQ1wYNarGrgtVDP5/Uh8qWabXNsGI6lRDO0rVRHw+j" +
       "XrGMf897iqW9//XtrjxSbiSdHOVaNloUvP/r2FXYFz1TJM+fbLyVv8sXj//O" +
       "ngicbuZCxU7Jk3c7oS13ST79kVdeVbnPIAdHm+CbGHow9vx321qq2Weaugpa" +
       "etfdd4SY8oD6dHP28x/5X09M37v+4NdxmPX0BT4vNvnTzGd/C/8W5YcPoPtO" +
       "tmpvOzo/T/Ti+Q3aa6EWJ6E7PbdN++SJZq8XGnsCPLUjzdYubmmejt1tVnCp" +
       "tIL92N/jjOH771H2sSL5cAy9ydBiNnG62xggU5GnnzEUK4buM4+uWJQG9JHz" +
       "BvTQiQFdOt6xfPR0/5BLtTA0Ve0eNnf78UCZ8T0nanr8eAf7pSM1vfT6q+lT" +
       "F8ouHZ2qHkm0P1YyvUOSG+SK5heWVdL9RJH8SAw95PmaW9zeKPY2b6dy/SQW" +
       "4lA7sr5Sj6/cVY9F9g99Ixort8ar4CGONEa8/hr76XuU/WyRfHpvWBcPy176" +
       "Z5yzdVZRHMpKLCjAkfengWcaKbX3mTdOe+VJQ6FC4Uh7wuuvvV+9R9m/KZJf" +
       "AuYDtDfRZPvYrNgjYHn/qRZ++Y3TwjcXme8GzweOtPCB118Lv3GPss8XyWsA" +
       "TAobKsyjr0VKaPrH96GAKb373qZ0J6pSa7/+xmntLUXmN4HHONKa8fpo7QIe" +
       "nTmh2R8mlkRfuIc6f79I/lMMXdaCRLbvCPNXVp5na7J7qqjffeMUVc59BbIn" +
       "R4pKXn/z+pN7lH2pSP5nDF1dy9G6gJfi+wdORf+jNxhfimn/Q0eif+j1F/2v" +
       "71H2N0XyF0D02Ds9UDwDKn/5Ooqex9Bb73S9qbir8fbb7lvu7wgqP//q9auP" +
       "vzr7r+UNn5N7fA/S0FU9se2zB+Bn3i/7oaabpYAP7o/D/fLvH2Po2a895cTQ" +
       "/cVfyf8/lISXoBh68p6EIHA9eT9LeB+A7jsQAoUfv56tfTmGrp3WjqED5Vzx" +
       "g8Avj4pBIAbSs4UPgSxQWLy+2T/Ghs43MsHuL65cOh/Sn1jGo1/rRPLMKuC5" +
       "c7F7eQP3OM5O9ndwbymfe5Viv+srrc/sr0QBHne7opWrNHRlfzvrJFZ/5q6t" +
       "Hbd1mXjhqw//woPPH68rHt4zfOpKZ3h7+s73jwaOH5c3hna/+vgvv/QvX/2D" +
       "8rz7/wF+Q45qGi0AAA==");
}
