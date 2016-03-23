package org.sunflow.core.display;
@java.lang.SuppressWarnings("serial") 
public class ImgPipeDisplay extends javax.swing.JPanel implements org.sunflow.core.Display {
    private int ih;
    public ImgPipeDisplay() { super(); }
    public synchronized void imageBegin(int w, int h, int bucketSize) { ih =
                                                                          h;
                                                                        outputPacket(
                                                                          5,
                                                                          w,
                                                                          h,
                                                                          java.lang.Float.
                                                                            floatToRawIntBits(
                                                                              1.0F),
                                                                          0);
                                                                        java.lang.System.
                                                                          out.
                                                                          flush(
                                                                            );
    }
    public synchronized void imagePrepare(int x,
                                          int y,
                                          int w,
                                          int h,
                                          int id) {
        
    }
    public synchronized void imageUpdate(int x,
                                         int y,
                                         int w,
                                         int h,
                                         org.sunflow.image.Color[] data) {
        int xl =
          x;
        int xh =
          x +
          w -
          1;
        int yl =
          ih -
          1 -
          (y +
             h -
             1);
        int yh =
          ih -
          1 -
          y;
        outputPacket(
          2,
          xl,
          xh,
          yl,
          yh);
        byte[] rgba =
          new byte[4 *
                     (yh -
                        yl +
                        1) *
                     (xh -
                        xl +
                        1)];
        for (int j =
               0,
               idx =
                 0;
             j <
               h;
             j++) {
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   idx +=
                     4) {
                int rgb =
                  data[(h -
                          j -
                          1) *
                         w +
                         i].
                  toNonLinear(
                    ).
                  toRGB(
                    );
                int cr =
                  rgb >>
                  16 &
                  255;
                int cg =
                  rgb >>
                  8 &
                  255;
                int cb =
                  rgb &
                  255;
                rgba[idx +
                       0] =
                  (byte)
                    (cr &
                       255);
                rgba[idx +
                       1] =
                  (byte)
                    (cg &
                       255);
                rgba[idx +
                       2] =
                  (byte)
                    (cb &
                       255);
                rgba[idx +
                       3] =
                  (byte)
                    255;
            }
        }
        try {
            java.lang.System.
              out.
              write(
                rgba);
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    public synchronized void imageFill(int x,
                                       int y,
                                       int w,
                                       int h,
                                       org.sunflow.image.Color c) {
        int xl =
          x;
        int xh =
          x +
          w -
          1;
        int yl =
          ih -
          1 -
          (y +
             h -
             1);
        int yh =
          ih -
          1 -
          y;
        outputPacket(
          2,
          xl,
          xh,
          yl,
          yh);
        int rgb =
          c.
          toNonLinear(
            ).
          toRGB(
            );
        int cr =
          rgb >>
          16 &
          255;
        int cg =
          rgb >>
          8 &
          255;
        int cb =
          rgb &
          255;
        byte[] rgba =
          new byte[4 *
                     (yh -
                        yl +
                        1) *
                     (xh -
                        xl +
                        1)];
        for (int j =
               0,
               idx =
                 0;
             j <
               h;
             j++) {
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   idx +=
                     4) {
                rgba[idx +
                       0] =
                  (byte)
                    (cr &
                       255);
                rgba[idx +
                       1] =
                  (byte)
                    (cg &
                       255);
                rgba[idx +
                       2] =
                  (byte)
                    (cb &
                       255);
                rgba[idx +
                       3] =
                  (byte)
                    255;
            }
        }
        try {
            java.lang.System.
              out.
              write(
                rgba);
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    public synchronized void imageEnd() {
        outputPacket(
          4,
          0,
          0,
          0,
          0);
        java.lang.System.
          out.
          flush(
            );
    }
    private void outputPacket(int type, int d0,
                              int d1,
                              int d2,
                              int d3) { outputInt32(
                                          type);
                                        outputInt32(
                                          d0);
                                        outputInt32(
                                          d1);
                                        outputInt32(
                                          d2);
                                        outputInt32(
                                          d3);
    }
    private void outputInt32(int i) { java.lang.System.
                                        out.
                                        write(
                                          i >>
                                            24 &
                                            255);
                                      java.lang.System.
                                        out.
                                        write(
                                          i >>
                                            16 &
                                            255);
                                      java.lang.System.
                                        out.
                                        write(
                                          i >>
                                            8 &
                                            255);
                                      java.lang.System.
                                        out.
                                        write(
                                          i &
                                            255);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GE6ObY7Bd0WicLwJZYjnfhL41Ph/4OiwFeQhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LuXXH1WO/k/7kwulovK9BcnbivJWXrzzyHyvBKGVwoX70H7/HP4uwOv/5FfO" +
       "LH+wX2Yfax2u9W89XuwDuBxdtMz7z6wYWi50R+lhjIO+8NiXVj/3lU/t45fz" +
       "03iuMfjQiz/25wcffvHiqajxmTsCt9M0+8ixkNPr8qKdG8bb7tdLQUF/+TMv" +
       "/ONffOGD+1E9djYG6sAQ/1P/+n//zsHH/vhzd1mQL8H4du+38xLLi/fsxVm/" +
       "p5X8tf3YLsAZuIwd4Afl/H5491m6lFf/CvS0URHnQwrD8lSnwNiOodU72q2j" +
       "uZnCuB+ayS3bwQs2j8MvncLCc4U82AfL58ba/n8eK5TkIyfMeB/G3T/+px/5" +
       "nb/zzJegVLjS5TQ3ASi+Uz32k/xT5Edf/uhTD7/4xz9eLBxQ7aT3/Ij/vpzr" +
       "990PcV5M8mJ6BPXJHKrkJ6EGeDWKhcLXA/0YLXMKTy+GK4b/GtDGN8fdWsSS" +
       "Rz9+qoA6OclGXlqdxVu9SooDgWzbMTApsE52DbOisuNd21xUa4NRjWZ101XS" +
       "OB0lc2/kuCBBscmADXs6PeE7k04HnSGtoWJP2OW0t/LqLU7l7IY54QTFW87c" +
       "udTpCStnWG5NPKFZnYl4e4ctp9Zmqgs7rCk29RmComlYNYxq31s2OVOWpel6" +
       "nbWoKFtTs6BCW6JC+2VMpXtOOGk1TH67s/kAR5IBH5atcSvEt7xJbcFa5uYx" +
       "1puO+rJXWblrThn3uZVqYU6fXTXBKltPZn127q+TpkK72XzttKfyiNbVmNuu" +
       "MLklK5rO+oI8X6Mjh5njc3K0XtBzSRmJgegvk3bYtK1gVZ3aGVNGMH1AbFCB" +
       "kRsLPZIyhknYRdDqBK7L9Bi/HNJuKrrJSBtW9C7lSPpItuTRWPWdpj/kWcdw" +
       "lwYVdqsVr76tAbxFDXcUKNuSrhlyVNfHUkViVJvrN2JcGQeyE3bQ1bo3T8by" +
       "qmmPoP7v1tSIaQ97y12oJuvKsukOAmflVBv0Rq+vrHWfkbROS9ihE1bYKmMp" +
       "DpZAdMFwIlSi6szxyl2FGTuJqSiNXrNeXlQX9d1ME8aKKiF2cxjKVhPOvsIJ" +
       "lLVqb1pOY1Zfy8tEkpQwYmtlle/O0/5oyk3Hi0WvWVn1hgM1a/c2KFmLZA4K" +
       "W/C6Os+09OFY37E7QW8PvJnvLxwRS9n1tEc22iEU/syXO7OKP2j1h4Gw62Tc" +
       "vKtjDtrrW4GyUrrrzaiMd2M3McmZFEuOgK0HgOnF2mrdovqb1WgijRK26fOB" +
       "OhSHcYftkrshhLBa03wH47qu3e+QY5VjKN2uWvRiqG5qXZL3N2WqHmfSgurx" +
       "c3pKrHeiWU69alVux86SX2VtYTBxHBroRqteUck6JpezYaUHNu3ygk5m3rbb" +
       "F7tBKNMtv0vvfJ72iYawsCvN5ixJKLosL3rDmcoPUmPIyPKqa1TsahyrkaH1" +
       "iGDDxDKzsNwa0sb7iISHkY6UlU1l6bKrumUst7VwQ0Tirt4fa6jkI7Q0wYSp" +
       "sG64K7fdHc96IA6GU8ZPfNOvcBN1LIx7jBqtBqhdZ9YJWQ9dc1Jp1flA2vXm" +
       "65FWn8rTQUqInd6UpDrchCSQnhP3dKXct5bopq5mVAvSWVOCm0qEJFYzL7CH" +
       "+Fod+RWHscS1Kq6n5pgNzOayO89URsKcRtQfbeuSndjuENmiIeeXXVqLhwE0" +
       "Vr5dHfqZXWbSTnUZKY5HuZmsj1y0S/pUhxLbcn1Hzxbs3Kn0J7ZgLggign4B" +
       "AQPOmU84v2nPBza3aZPlRURKQm0uDIEwYI0VO2oZ3IYb8NR8TFs9e9EKltNZ" +
       "WE8VRNG8RrgQext2LdRmPNlR0gHhubO2Z3iDqqSvRA2z9TJBEBa9q005oGzK" +
       "0pjnpZbfsDYzl+y3hmm/C9azWbPW1TUkgN/NM7QsN+ZJeSttxrtOdd5JgooP" +
       "fMuQhbFIsRq3GS+ivq/p+lAT8dVGrLbjxrbRmLOblhEp3RqISJ5v4XaVLe9W" +
       "yGKZJs0Ot21gBIpEHuhO47JOoPiMtW3E4Br+srFbBvOh2dLMXT0y8QlBpKrc" +
       "3+xqDBQNF7GAxJ11e44u/UDHTKUpOYw5GjRkRZ2kzHRZ7fSZ3bgyXwDGxZa2" +
       "UceXOM9A6vW2n2ForZlwVKCOzY5re0O5XBNHqKKiWZmOumh1mJnNNKPFCaCb" +
       "TV5eJF1vSs07CDBHsR5N69ZkGKbtJmpooIl04wbq9OGHm2JqakRW+bZLOnKn" +
       "RyIgShdeiKfSAJ8tEVyPcFKUjQarhVw9GHeAw42Hq9Ucl7OqGFFJLyUpeVVd" +
       "SMtqNCmvgknY7Gmy2Ayq+MA0UlRzQDsihalqbnaDBF2R8a4RZarkVpqgia1C" +
       "OhtI5UXScHmvTzGyqG8nqdCpBNQAjFIwG8YM0mTb5U6dRDrq1l30gD7c2J2l" +
       "0e8kdSMwNkLMkwmRbLDeoD6ewsUI3446HQ4B+EzMGngj6Xt2KipIJPh4JahK" +
       "ZRUXWkS0ixotpONQmuNH8lwc4gHblhrNdEIiGsk6TZZmGEygVWXJVhQPk+Gc" +
       "JOtu6GFAc0MPiW1WwiUWW0vEKrFkYiss1citrNubXqDUiHhmERM99FVrqcbQ" +
       "ZYzFdblFBpkOkqhR3oztuVsliMbc2Ok1AtSmituinLG23jQqGliLlFnto6qd" +
       "QtdSwdMUG3eiquhpNXcjN9pGvUqkE9SJ0Sa0hm3bFenhskKmVRx+AoDFwK01" +
       "TEiasb2mi/N1O/JYRq7iZVkMUmLkObM6sWsFDUvoR2aVCAN+0mbwsbi0a3xL" +
       "s8xlW2k2a0bKOmwwrnRdetBWBnOlvzKd0Bl0FGzb32FCG6flrrSzAZi1k1k6" +
       "73WM2rBWqQ5qYELwQr267fE9gZrUWOjA5aYkd4SAlSmvnFT60LtiirGMNa/O" +
       "MoGZbFm8wYN4wcvNuFE1Dd6oqFR7zenEVhwtGvWGRgih1wFheeEmGj3Gkk59" +
       "szFr0iIjd+gyQ9iFjZiZMaBbcQc63cl8rqdClc+YepBK40joUW29nI5BBpdQ" +
       "0ZpPWlSg++2unqTVwW7LVRcjY9UjaxSM4S2NIQxtRA4bbntk4YOFLPuT6loM" +
       "l3hl4XnZaotUrOmqiqz4+XjsbsXU6BrTLV9FEdUhU3rqyqxR50h6GDq6KDBo" +
       "f9UzVaThG0iYBCGbaEKUTYLqyOmUFWaVNmzo87bpCKejqDnjl4zaSJgW0WdV" +
       "qhEtZ621TDcG2YgzDYDRvVa2yLrjTACcyhvNKbXue2EN3UXmHBnXVHsIvbo6" +
       "BLOE3I2tACMRio8Sb4arXV7ZZIBZzFEpq7UEHfQJZ1gfVcZ9mZ6EW0EeVkV0" +
       "UNe7/VqVXxhoYxTPB3BquGxeqa4ln+LR8cbYubShYWx/DEBXFnEQJUywQSWn" +
       "YzeFdo+c0sa6ie/KCb8LVDiNK2qKUtArdOfVhqcvMLLC+fI4Hcyra92tmwoi" +
       "NJobbooPmoSA0SxuteAa5U6jEeuNJ616Vh9Xtq2hRKq+RrMcNu8M/dqG57UB" +
       "um1irfGWWrBmqNjCxKX8mtOWjLI5G5GduZXGrRW1wKJ5bwRHp0q4qm0kF1F2" +
       "SBeLZKa9QcKhsWMatSBe9sY7xxH4LkuzrY0rDEnenGrTzoTcLFtzvT4kiSye" +
       "V0mF30bdSJDczjbONgtPMpHmWlm6tfqsh2H+GvPai8Dq2ASqi/hEjfA64VHq" +
       "RKxWYg1FK2I46NaJIb+WYQBDrLQMV2YShrpVHDHmGhkSKfT7mi0P+dkaVQlE" +
       "wUYYZbADemnTazFQ2W0aqKNRZeIYXrtubsXpzvIGK6ohjnCihoC+6ON9dLvm" +
       "K2o0pypLdchzQkQYYxwQzUY2xAaeqOFKOtrUq111glqZbZj8yMnSVauv28Sk" +
       "LWvTxjgVGnC1iRkcDwKGVcKs1Z3JkrqdCeGg46XeXNolc1WSrUoccC161XK3" +
       "+kLW143Khq8gMraZZggWKgNh7npRdzogbWBgm2ZvyfuGhTTbQCBxXXLXjE+V" +
       "d3W31aS2i9Uocwc2NqSD/pz0OU/CM7ztRx4DNp7Zg4H0ZjEEwBd8oS/22XQp" +
       "u9UwCv3OwLE7RLnZzRYB0pk1sYgcIikxtjiD8oA/V5i5EhiC32LEqjVmOmWm" +
       "0eiEsm1V2p11xZaXoQ9WFIWnTtS2BUpJyY7GiQyrJqhlkVSWestaLfK3AgEd" +
       "vjCdbAcAtR3DXrI2gcgO0VRnY8et8Z43Jyx91BKDXW/dsKsCqNdC6DBduleX" +
       "vbGtWnCOuhtfH4NNeUDtFFzSEKgltN0YCH1yhA8Fie1jyG5esxZYbWc25mUU" +
       "rnxNetjgyuTSEHeshripFdqc1ZZSdcgMuWYdV1YDoM03IkfIKFarILPNrlkl" +
       "mNBkJF1YrUYNYaMu57QbclOhjU3VLPQz6OeZHjVamKtAcHGjhXP4dCfEG4VD" +
       "pAZmT1Gk6cpGRmccqYy6EbpWHPgFEUq01R0GGqiDNWEIiwFNyFJTmDWmQmVH" +
       "ef0EsZNhdafvkM1q05yNtCkxEVjL83o4zo0mWp/rtxYenjhJ4sL1k0IQdkR6" +
       "ojjp8LytoePamG4t2rbkx2jXm5ELtEXudkSqBJXmahr3Fuhc4QgLhUpBzScK" +
       "gZWrLCiDGc9XTYTTAB07qaxMMKLeF3hpGXVSpj5BeMGPWU1WZL5er8GvSlTo" +
       "toC2oCSm3uUFmiS6PEnhAtVmnBW1xpiQV+a2UbVnqDsF1anZaFFTkx+arF1r" +
       "Gm6AqNvRUh3UsdRGtJVoDSq1XRg08VDvhrafNnUGF0WHIxz4hWHMuQSgIMZ4" +
       "vO/VG30Dmcg92offXc5A64ejcOxMqdrWUNyJpi0nHavWygiGWWDbhA4ROFts" +
       "KNbcCVqTAyqcZ/2RsWYA3WI1KdLlRFv3uWrEqjqN2MuKZ2LZzo9AOGBFm2qz" +
       "cT1mOo3BYo5Telm2NH7DQVwetPVaRTTR2sDa0GBokiT57nx7wXx12x6PFjs8" +
       "x2ejtoPnL2avYmcju8f+X9HhydZ98Xvw/Anb6a37k/3cC0f7S0/ccR51eACV" +
       "77w9da9T0mLX7RMfePElffDzlYuHG+V8XHoo9oO/6oAUOKf6ugI5PXfvHUah" +
       "OCQ+2cD9rQ/8hyfH32O+91UcS73l3DjPs/x7wsufY75L+4mLpUvH27l3HF+f" +
       "JXr+7CbutRDESeiNz2zlPnUs+idySXfg9fih6B+/+9HQXefx4uEO4fVo62lm" +
       "6HvWDuh77Tl3LHHpRNG4k6Jo+oH7nGD8cF78YFy6ZrnqElBgaXl33XBLfUs/" +
       "0cgXvtVe2+luigfbs/IQ4PWmQ3m86VXLIy/ed1cpXC5aXT4nhXPy+Lv3kcdP" +
       "5sXfggIv5CGGIFDDYlp/9AT9336t6EfwevoQ/dN/Oeihnb3j3nZWnIftN+Zf" +
       "+oVnfveHXnrmT4ojpatWNFVDMlzeJS3iFM3XX/7SV3/vdU99ujh2fWChRntD" +
       "OJ9Pcme6yJkskALS9WNJVXLBNOCFHUqq+I9L7b/o6f25LIBvC5/syFe+8bSv" +
       "LHQnP770wyAI9or18fso3Sfz4mNx6eGCcBLoanxe537mtepcD17EoSSJvzyL" +
       "+0RB9PfvA/5X8uJluD4U4GnLcc5B/9Rrhf7OQ5M7Mr1vF/TTKD57n3f/NC9+" +
       "PYbWlCPsePo5gP/oNQAszgUZeMmHAOVXAbCIElp/cUf6ufuA/nxe/AZ0pH4S" +
       "B0mc52CB+Bzw33ytwJ+B1+1D4Le/PcAvnDTYg/xX9wH5B3nxL6Hh7kGyXlzF" +
       "zmH8wqvBmMWlR87m+uSJC0/ckTa4T3XTPv3SjatvfGnyB3u/e5SO9hBfumok" +
       "jnP6nPlU/cEgBIZVDP+h/alzUPx98W4B32ECUly6clgrhvxHe4o/iUs3z1PA" +
       "UCH/O93sT3P5nDSDvA5rpxt9OS5dgo3y6leCI6f6WOFiD6KN5S0POFH1gJNd" +
       "OBU9HipFIefHzsr5+rGcj8PZJ08dlyYBlEIUyWroQd7RvUjjw6NPOAm1b5nh" +
       "keefgsN0gWJxvK1df3j+n3/jhf9R2p8tQ1anVrqTw/4ijebJ0j63pnT0f1qV" +
       "8zSeu+fFSHD4Doh9L89mee4/PXvzXZ/82Z8uursC9uPJOby7SIDBXxWEo0yI" +
       "25owfH/zzT/25T8sou6rRVoEbFHwvTOFIS/+S5afaReJqfntLDvS9eNpO52W" +
       "lA+myJ89itCTfQbtbe0zL3H9H/hG4+f3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("aVGao+52OZerENw+Q+s4yn/bPbkd8Xqw++w3H/nlh95x9EXyyF5pTpzEqbG9" +
       "5e6y7rhBXGQN7X79jb/6rk++9MXi1Pv/Al5Yu3zYLAAA");
}
