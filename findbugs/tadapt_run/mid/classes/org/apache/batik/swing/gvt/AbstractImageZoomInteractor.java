package org.apache.batik.swing.gvt;
public class AbstractImageZoomInteractor extends org.apache.batik.swing.gvt.InteractorAdapter {
    protected boolean finished = true;
    protected int xStart;
    protected int yStart;
    protected int xCurrent;
    protected int yCurrent;
    public boolean endInteraction() { return finished; }
    public void mousePressed(java.awt.event.MouseEvent e) { if (!finished) {
                                                                org.apache.batik.swing.gvt.JGVTComponent c =
                                                                  (org.apache.batik.swing.gvt.JGVTComponent)
                                                                    e.
                                                                    getSource(
                                                                      );
                                                                c.
                                                                  setPaintingTransform(
                                                                    null);
                                                                return;
                                                            }
                                                            finished =
                                                              false;
                                                            xStart =
                                                              e.
                                                                getX(
                                                                  );
                                                            yStart =
                                                              e.
                                                                getY(
                                                                  );
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        java.awt.geom.AffineTransform pt =
          c.
          getPaintingTransform(
            );
        if (pt !=
              null) {
            java.awt.geom.AffineTransform rt =
              (java.awt.geom.AffineTransform)
                c.
                getRenderingTransform(
                  ).
                clone(
                  );
            rt.
              preConcatenate(
                pt);
            c.
              setRenderingTransform(
                rt);
        }
    }
    public void mouseDragged(java.awt.event.MouseEvent e) {
        java.awt.geom.AffineTransform at;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        xCurrent =
          e.
            getX(
              );
        yCurrent =
          e.
            getY(
              );
        at =
          java.awt.geom.AffineTransform.
            getTranslateInstance(
              xStart,
              yStart);
        int dy =
          yCurrent -
          yStart;
        double s;
        if (dy <
              0) {
            dy -=
              10;
            s =
              dy >
                -15
                ? 1.0
                : -15.0 /
                dy;
        }
        else {
            dy +=
              10;
            s =
              dy <
                15
                ? 1.0
                : dy /
                15.0;
        }
        at.
          scale(
            s,
            s);
        at.
          translate(
            -xStart,
            -yStart);
        c.
          setPaintingTransform(
            at);
    }
    public AbstractImageZoomInteractor() { super(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfWwUxxWfO38bf2GCAQMGjEHl6w6aAGpMA8ZAfHDGrk1o" +
       "amiOud05e2Fvd9mds8+mlICUQiMVReCkJA2u1BK1pSSkVdNUjaBUSUvSlFJo" +
       "1CZBTdqmUtImSOGPxmlpm76Z3b39uA/kKFIt3dzc7nsz7735ze+9GZ+5jkoM" +
       "HTVrWBFxiA5rxAh1s3431g0itsvYMLbB05jw4J+PHxj/XcXBICrtQzUD2OgU" +
       "sEE2SUQWjT40W1IMihWBGFsJEZlGt04Mog9iKqlKH5oqGZGkJkuCRDtVkTCB" +
       "7ViPosmYUl2KpyiJWANQNCfKrQlza8JtfoHWKKoSVG3YUWj0KLS73jHZpDOf" +
       "QVFddDcexOEUleRwVDJoa1pHSzRVHu6XVRoiaRraLa+0ArE5ujIrDM1P135w" +
       "86GBOh6GKVhRVMpdNHqIocqDRIyiWufpRpkkjb3oy6goiia5hClqidqThmHS" +
       "MExq++tIgfXVREkl21XuDrVHKtUEZhBF87yDaFjHSWuYbm4zjFBOLd+5Mng7" +
       "N+Otvdw+Fx9eEh79+n11PyxCtX2oVlJ6mTkCGEFhkj4IKEnGiW60iSIR+9Bk" +
       "BRa8l+gSlqURa7XrDalfwTQFELDDwh6mNKLzOZ1YwUqCb3pKoKqecS/BQWX9" +
       "KknIuB98bXB8NT3cxJ6Dg5USGKYnMGDPUineIykix5FXI+NjyxYQANWyJKED" +
       "amaqYgXDA1RvQkTGSn+4F8Cn9INoiQoQ1DnW8gzKYq1hYQ/uJzGKpvvlus1X" +
       "IFXBA8FUKJrqF+MjwSo1+lbJtT7Xt645uk/pUIIoADaLRJCZ/ZNAqcmn1EMS" +
       "RCewD0zFqsXRR3DDuSNBhEB4qk/YlHn2SzfWLW268KIpMzOHTFd8NxFoTDgV" +
       "r7kyq33RZ4qYGeWaakhs8T2e813Wbb1pTWvANA2ZEdnLkP3yQs8vv3D/afJu" +
       "EFVGUKmgyqkk4GiyoCY1SSb63UQhOqZEjKAKoojt/H0ElUE/KinEfNqVSBiE" +
       "RlCxzB+Vqvw3hCgBQ7AQVUJfUhKq3dcwHeD9tIYQKoMPqoLPPGT+8W+KhsID" +
       "apKEsYAVSVHD3brK/GcLyjmHGNAX4a2mhuOA/z3LVoRWhw01pQMgw6reH8aA" +
       "igFivgwbQ4CncP8gDbfFAfhYoJEkwKJPVZMRhmPMdkKIAVD7/02dZlGZMhQI" +
       "wILN8tOFDDutQ5VFoseE0dT6jTeeir1sQpFtHyueFK2C+UPm/CE+f4jPH4L5" +
       "QwXmR4EAn/Y2ZoeJEVjhPcAVQNZVi3q/uHnXkeYiAKc2VAzLw0QXZiWvdodU" +
       "7EwQE85c6Rm/fKnydBAFgXfikLycDNLiySBmAtRVgYhAYflyic2n4fzZI6cd" +
       "6MKJoYPbDyzndriTAhuwBPiMqXczKs9M0eIng1zj1h5+54Ozj+xXHVrwZBk7" +
       "OWZpMrZp9i+y3/mYsHgufiZ2bn9LEBUDhQFtUwzbDBixyT+Hh3VabQZnvpSD" +
       "wwlVT2KZvbJpt5IO6OqQ84SjbzJrpppAZHDwGcjJ/7O92slXf/O323kk7TxR" +
       "60rwvYS2uriJDVbPWWiyg65tOiEg98cT3ccfvn54B4cWSMzPNWELa9uBk2B1" +
       "IIIPvLj3tTffOPVK0IEjheScikOdk+a+3PYR/AXg81/2YXzCHpi8Ut9ukdvc" +
       "DLtpbOaFjm3AczJseAaOlnsUAJ+UkHBcJmwv/Lt2wYpn3jtaZy63DE9stCy9" +
       "9QDO8xnr0f0v3zfexIcJCCzPOvFzxEzynuKM3KbreJjZkT54dfajF/FJSANA" +
       "vYY0QjibIh4PxBfwDh6LMG9v971bxZoWw41x7zZy1UMx4aFX3q/e/v75G9xa" +
       "b0HlXvdOrLWaKDJXASZrR1bjYXf2tkFj7bQ02DDNTzod2BiAwe64sHVnnXzh" +
       "JkzbB9MKQK9Glw4MmPZAyZIuKXv958837LpShIKbUKWsYnETpzbIUoB0YgwA" +
       "eaa1tetMO4bKoanj8UBZEWJBn5N7OTcmNcoXYOQn03605jtjb3AUmrCbydVZ" +
       "YT83ixt5xe5s6/eufeOtn41/u8zM94vyc5lPb/q/uuT4ob98mLUSnMVy1CI+" +
       "/b7wmccb2+96l+s7dMK056ezsw4QrqP76dPJfwSbS38RRGV9qE6wquPtWE6x" +
       "ndwHFaFhl8xQQXvee6s7s5RpzdDlLD+Vuab1E5mT7aDPpFm/2oe6GraKC62P" +
       "3fegLoB4p4OrLODtp1izxOaTCk1XKVhJxHRmWA6O6gLDUlSekBTJGCAi31ou" +
       "ELDjV28KEnC3LiWBFget4vBsw/jeF8pGNtiFXy4VU3KL0Xn5px1vxzjtlrNE" +
       "us1235Ui2/R+F53XsWYZ22MFIOazKLy//s09j7/zpGmRH08+YXJk9MGPQkdH" +
       "TTo0DwDzs2pwt455CPBZN6/QLFxj09tn9z/33f2HTavqveXsRjitPfn7//w6" +
       "dOJPL+WoicriqioTrGT2eSBTxDT4A266Vbri5D8PfOXVLsi6EVSeUqS9KRIR" +
       "vegrM1Jx1wo4xwsHkZaDLPlQFFisaVZiZe1q1kRMcLXmZaX1XkzPgM8SC3xL" +
       "8mB6l4lp1mzJhm4+bcigaThx6uZpt8taGfbV4+pvp6hIsk7ErkCynzv9vuGP" +
       "4dtyy7rleXyTC/qWTxt8G+a+sV/EZ2ZygmbOhM9Ka6KVecw0CpqZTxvYI92e" +
       "0qGGy2ko/RiG3mlNdWceQ0cKGppPGwwdLmDovgKGpvMQLusudZiW/5Wi/GWD" +
       "K98iRiCz853bOXmcOjQ6JnY9sSJoVT+fB36nqrZMJoNEdg1VzKnIn7o7+W2F" +
       "kwdXXx0vunZselX2iYaN1JTnvLI4PwH7J7h46O+N2+4a2DWBo8ocn//+Ib/X" +
       "eealuxcKx4L8wsVMu1kXNV6lVi/dVeqEpnTFS3DNmRWbYq/SWmvF1voh56CE" +
       "4+2QF2+VBVQL1LHHCrwbZc3XKKohimifdK3jyOcctB691bbyFIbswTr++KsZ" +
       "+yexV4vh02HZ3zFx1/Op+tyzExf7PZ2iGbxGxUOAqUHYjJDAUgbZyLp8yrEC" +
       "wfkWax6lDKugw26NDSLm4vviQVUSnXA99smEi6Wfey2f7514uPKp5g4X+/lN" +
       "PurZAhH5AWtOU1TNI9JDoGKAkLCHpxz3v//JoUWxfFAm7n4+1Vu5/1wB98+x" +
       "5sc2IDbouL8/y/tnJ+59mqKZBe6d2ElretbNuHmbKzw1Vls+beyeP/C7j8yN" +
       "axVUv4mULLsPAq5+qaaThMRdqjKPBWbV9QJFjfnvxqCugZb78LwpfxHO5Lnl" +
       "KRzx2Ldb+lcU1fmlQY5/u+UuUVTpyEFhYnbcIr8FW0CEda9o9k5fWuBaz4lm" +
       "m4g16KcD3vSYWb+pt1o/V0ad78lX/H8cdm5Jmf/lgMPL2Oat+26sesK8CRJk" +
       "PDLCRpkExbF535TJT/PyjmaPVdqx6GbN0xUL7BztuYly28ZhBbDmtzaNvqsR" +
       "oyVzQ/LaqTXnLx0pvQoHgh0ogCmasiP7DJrWUpA8d0RzHQMge/Nbm9bKt3Zd" +
       "/vD1QD0/6iPz4NBUSCMmHD9/rTuhaY8FUUUElUAJQtL8gLxhWOkhwqDuOVWU" +
       "xtWUkvl3SA0DOmb//+CRsQJanXnKLgkpas4+ZGVfnFbK6hDR17PRec72ZfSU" +
       "prnf8sjuMNmfRRpwGIt2app1d1a+gkde0/jG/itrdv4PsuWY1MgcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
