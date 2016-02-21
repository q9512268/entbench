package org.sunflow.core.display;
public class FrameDisplay implements org.sunflow.core.Display {
    private java.lang.String filename;
    private org.sunflow.core.display.FrameDisplay.RenderFrame frame;
    public FrameDisplay() { this(null); }
    public FrameDisplay(java.lang.String filename) { super();
                                                     this.filename = filename;
                                                     frame = null; }
    public void imageBegin(int w, int h, int bucketSize) { if (frame == null) {
                                                               frame =
                                                                 new org.sunflow.core.display.FrameDisplay.RenderFrame(
                                                                   );
                                                               frame.
                                                                 imagePanel.
                                                                 imageBegin(
                                                                   w,
                                                                   h,
                                                                   bucketSize);
                                                               java.awt.Dimension screenRes =
                                                                 java.awt.Toolkit.
                                                                 getDefaultToolkit(
                                                                   ).
                                                                 getScreenSize(
                                                                   );
                                                               boolean needFit =
                                                                 false;
                                                               if (w >=
                                                                     screenRes.
                                                                     getWidth(
                                                                       ) -
                                                                     200 ||
                                                                     h >=
                                                                     screenRes.
                                                                     getHeight(
                                                                       ) -
                                                                     200) {
                                                                   frame.
                                                                     imagePanel.
                                                                     setPreferredSize(
                                                                       new java.awt.Dimension(
                                                                         (int)
                                                                           screenRes.
                                                                           getWidth(
                                                                             ) -
                                                                           200,
                                                                         (int)
                                                                           screenRes.
                                                                           getHeight(
                                                                             ) -
                                                                           200));
                                                                   needFit =
                                                                     true;
                                                               }
                                                               else
                                                                   frame.
                                                                     imagePanel.
                                                                     setPreferredSize(
                                                                       new java.awt.Dimension(
                                                                         w,
                                                                         h));
                                                               frame.
                                                                 pack(
                                                                   );
                                                               frame.
                                                                 setLocationRelativeTo(
                                                                   null);
                                                               frame.
                                                                 setVisible(
                                                                   true);
                                                               if (needFit)
                                                                   frame.
                                                                     imagePanel.
                                                                     fit(
                                                                       );
                                                           }
                                                           else
                                                               frame.
                                                                 imagePanel.
                                                                 imageBegin(
                                                                   w,
                                                                   h,
                                                                   bucketSize);
    }
    public void imagePrepare(int x, int y,
                             int w,
                             int h,
                             int id) { frame.
                                         imagePanel.
                                         imagePrepare(
                                           x,
                                           y,
                                           w,
                                           h,
                                           id);
    }
    public void imageUpdate(int x, int y,
                            int w,
                            int h,
                            org.sunflow.image.Color[] data) {
        frame.
          imagePanel.
          imageUpdate(
            x,
            y,
            w,
            h,
            data);
    }
    public void imageFill(int x, int y, int w,
                          int h,
                          org.sunflow.image.Color c) {
        frame.
          imagePanel.
          imageFill(
            x,
            y,
            w,
            h,
            c);
    }
    public void imageEnd() { frame.imagePanel.
                               imageEnd(
                                 );
                             if (filename !=
                                   null) frame.
                                           imagePanel.
                                           save(
                                             filename);
    }
    @java.lang.SuppressWarnings("serial") 
    private static class RenderFrame extends javax.swing.JFrame {
        org.sunflow.system.ImagePanel imagePanel;
        RenderFrame() { super("Sunflow v" +
                              org.sunflow.SunflowAPI.
                                VERSION);
                        setDefaultCloseOperation(
                          EXIT_ON_CLOSE);
                        addKeyListener(new java.awt.event.KeyAdapter(
                                         ) {
                                           public void keyPressed(java.awt.event.KeyEvent e) {
                                               if (e.
                                                     getKeyCode(
                                                       ) ==
                                                     java.awt.event.KeyEvent.
                                                       VK_ESCAPE)
                                                   java.lang.System.
                                                     exit(
                                                       0);
                                           }
                                       });
                        imagePanel = new org.sunflow.system.ImagePanel(
                                       );
                        setContentPane(imagePanel);
                        pack(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ye2wcxRmfO9vnZ+KznTiu45jEuUSyiW4bQkCp05T4bGO7" +
           "50ftkIpLyWW8O2dvsre72Zmzz6ZpCVJFiqooiJAEWvxXUKSIAqqKyh+AXPVF" +
           "RVuJRx9QlT7+KRWNIFSlLenrm9nn7Z1L+09Pur25mW+++Z6/75t98hqqoRbq" +
           "JjpLsiWT0OSQzqawRYmS0jClh2AuK1+swn86+vbEviiKZdD6eUzHZUzJsEo0" +
           "hWbQFlWnDOsyoROEKHzHlEUosRYwUw09gzaqdDRvaqqssnFDIZzgMLbSqAUz" +
           "ZqmzBUZGHQYMbUmDJJKQRDoYXu5PoybZMJd88o4AeSqwwinz/lmUoXj6OF7A" +
           "UoGpmpRWKesvWuhm09CW5jSDJUmRJY9rex0TjKX3lpmg55nmD26cm48LE7Rh" +
           "XTeYUI9OE2poC0RJo2Z/dkgjeXoSfQFVpVFjgJihRNo9VIJDJTjU1danAunX" +
           "Eb2QTxlCHeZyipkyF4ihbaVMTGzhvMNmSsgMHOqYo7vYDNpu9bS1tSxT8ZGb" +
           "pfMXj8a/UYWaM6hZ1We4ODIIweCQDBiU5GeJRQ8qClEyqEUHZ88QS8Wauux4" +
           "upWqczpmBXC/axY+WTCJJc70bQV+BN2sgswMy1MvJwLK+VeT0/Ac6Nru62pr" +
           "OMznQcEGFQSzchjiztlSfULVFYZuCu/wdEx8Gghga22esHnDO6paxzCBWu0Q" +
           "0bA+J81A6OlzQFpjQABaDHWuyZTb2sTyCTxHsjwiQ3RT9hJQ1QtD8C0MbQyT" +
           "CU7gpc6QlwL+uTax/+y9+ogeRRGQWSGyxuVvhE3doU3TJEcsAnlgb2zqS1/A" +
           "7S+ciSIExBtDxDbNtz5//Y5d3asv2TSbK9BMzh4nMsvKl2fXv9KV6t1XxcWo" +
           "Mw2qcueXaC6ybMpZ6S+agDDtHke+mHQXV6e/f/d9V8k7UdQwimKyoRXyEEct" +
           "spE3VY1YdxKdWJgRZRTVE11JifVRVAvjtKoTe3Yyl6OEjaJqTUzFDPEfTJQD" +
           "FtxEDTBW9Zzhjk3M5sW4aCKE2uCLOuCbQvZH/DJ0TJo38kTCMtZV3ZCmLIPr" +
           "zx2qK1hihMJYgVXTkGhBz2nGokQtWTKsOe+/bFhEUlRqanhJGoYkJYP2nySP" +
           "NPP/cEaR69m2GImAC7rCAKBB7owYmkKsrHy+MDB0/ansy3Zw8YRwLMTQbjgu" +
           "6RyX5MclneOSweMS0+AKYokpFImIEzdwEWyHg7tOQOID8jb1ztwzduxMTxVE" +
           "mrlYDbbmpD0lFSjlo4ML6Vn5/bHf7hk59YnXoigKADILFcgvBFsDhYBXMMuQ" +
           "iQI4tFZBcEFRWrsEVJQBrV5aPH34ix8XMgSRnTOsAVDi26c4HntHJMIZXYlv" +
           "8wNvf/D0hVOGn9slpcKtcGU7OWT0hP0aVj4r923Fz2ZfOJWIomrAIcBehiFX" +
           "ANa6w2eUQEe/C8NclzpQOGdYeazxJRc7G9i8ZSz6MyLgWsR4A7i2DjkZNuwk" +
           "l/jlq+0mf26yA5THSkgLAfOfnDEf/8VP/rBHmNutCM2BUj5DWH8AhTizVoE3" +
           "LX7oHbIIAbpfXZp6+JFrDxwRcQcU2ysdmODPFKAPuBDM/KWXTr7x67cuvx71" +
           "YhUVS3Wr+w+6wSE7fTEAvDRIbh4sibt0CEY1p+JZjfCc+Hvzjt3P/vFs3Ha/" +
           "BjNu9Oz6aAb+/McG0H0vH/1Lt2ATkXnx9E3lk9mI3OZzPmhZeInLUTz96pZH" +
           "f4AfB2wHPKXqMhEQiRzVuVB7hP5J8bwltLaXPxI0GPOlaRVocrLyudffW3f4" +
           "vRevC2lLu6Sgi8ex2W9HFX/sKAL7TWFcGcF0HuhuXZ34XFxbvQEcM8BRhtaA" +
           "TlqASsWSgHCoa2rf/PZ32o+9UoWiw6hBM7AyjEVuoXoIakLnARqL5qfusJ27" +
           "yD0dF6qiMuW5PW+q7KmhvMmEbZef2/TN/VdW3hKxZEfRZg/+ukrgT3TWfvZe" +
           "fe32n1556MKiXZt714as0L6ODye12ft/99cyAwuwqtA3hPZnpCe/1pk68I7Y" +
           "76MG3729WF5PAFf9vbdczf852hP7XhTVZlBcdjrZw1gr8FzMQPdG3fYWut2S" +
           "9dJOzG47+j1U7AojVuDYMF75dQzGnJqP11WCqG74DjppPBiGqAgSg2GxZSd/" +
           "9JWDwFq7GaiahwYQSjrRxLYOuOYESypdoozkk6MelQ2J/Hkbf9xpB8u+SpFo" +
           "L+0Uz17+2CVCKspQrWmpcAMDa8aoaOR94BIx2xrueILA5Qcn4vm2Za2mVDTU" +
           "l+8/v6JMPrHbDs/W0kZvCO4xX//ZP36UvPSbH1boLWLOpSJ4IEONgV7CNdmO" +
           "/6oLAWE7yu45dm8uP7XSXLdp5a6fiyLo9c9NUD5yBU0LhkpgHDMtklNFyDTZ" +
           "gWOKn6PQ8K4lERjfGQnh77F3YLiEhncwVM1/gmRwgWkMkAEvZxQkmmOoCoj4" +
           "cN50LdQqGr4kXYSbS3JMWKUYKXWlF1MbS2OqyYupiMutU8AZT8HkTMEEK1D6" +
           "WWxBmzpH19rKUM0CT2Bwwq0fWQD4FZk4GS/qD9xTGu9+/7un/obsOAFWFVuK" +
           "djdfB5zoHQjnKy/ulcF4BsTXCDN0Dsh97/bG91/56kVxXC2x5eEcBgWe3/4/" +
           "qeCCWVYe/8zpfV0P/v5N0bPUCWQDCsG3HIX4gxV5joqbtGv8eMD44iZadKtO" +
           "ICu3lwgoXgI4Io4X7NcAWfnplbGJe6/f9oTdQMkaXl4Wl0ZQ2O7lvDZ125rc" +
           "XF6xkd4b65+p3xF1qn2LHUg+Wm0OtAIHIB5MbsbOUJtBE1638cbl/S/++Ezs" +
           "VXDAERSB/Gg7Ug78RbMAAHQk7RfIwEsk0f/09z62dGBX7t1fispaXlDD9Fm5" +
           "/sOzy9toJBlF9aOoBiCMFEVFGlzSp4m8AB1AXUFXTxbIqAIIMGsUdO9dwXqO" +
           "G5i7RFjFMeY6b5Y33wz1lL0FqHAhgZZjkVgDnLuIiFLgaYCkC66CizaU65SV" +
           "B7/c/Py51qphQLUSsYO8AEJmD7mBF3wR4Udi3M6vf8EnAt9/8i93Jp+w78Ot" +
           "KedSvtW7lZtm0V6ryqbHTdOhjXSKADBNkY5fEYzP8MeDRU7BUKTPNP8NqMnH" +
           "u3kUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "jDlK7JYlNNyutI5ocPPFRAB7X2uwnNYtapoNG6xJjsZYa9wTwZ7dGKxYr5NU" +
           "l2NwUnhdfoSwfrRT3L3FgfXoqgQc3vIP/I9weklvPuFeDN0RhPYanOSLWY8L" +
           "d0VF4OrZ0vvJwt1xNQfKT2sP3+p2pDipfeTtzz1vcB+t7B1UwVRwOD+4tDpJ" +
           "J4buPlGrPjyPv/qHqnIDHh644R5td/ejf+r5yxdf+fz4r4va7tH9zJ196KKV" +
           "OM7J6sqJ/oUgNC27YPfOXa0lKP6yGHrgVhyB9TzoFcxvdxjPxNCVsxjgBJr/" +
           "nQR7KxD/BBigddA7CfSOGLoNAOXdXwoOV+hqcaGwH4Gz02yfKVYlPXdaQ0dm" +
           "cvW0mVw6MpNzh9QePFH/SAKwClEkq6EHaEe3Qo0PahlACbUfWNfML2TNgyJZ" +
           "UVa9rl+6e/ovf/zMf0C7gzogddNK+f2HJa7WgVG2zpa48pr1zavBAmDfMWPf" +
           "y2u4r/nnJ688/bHf+EAx3R3mjp+cwtNF2Rf7kUQ4rP9d11n+bc2H3v2NrxSl" +
           "+ItFMRBAFHRvLNzlzbNpXqQqbmoLj04PCw0nHOuJU8wUF8oH7LDJ7kr5uv7p" +
           "55nBW15EP7q7A9AdNctyKheBcLvriKOblsduSe2Q1oXOky/d85k7X33oqvfs" +
           "jOY42Jzg7VU3X2vKDeKiVp797it/++mPPf/Vooz1v6DLbh/pHwAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZDXAV1RW+7+X/B5KAEIQkQAjMgPQ9ENRqKH8hkdAHZAjQ" +
       "Nihhs+++ZGHf7rp7X/ISTFE6LWk7MrSiUkfTzhQrZfBnmDo6U7V0OqJWcEaw" +
       "WmqV2nFaW+sU2qntSFt7zr27b3/ee4G01Mzs3X333nPvOeee851zbo59SIos" +
       "kzRQjUXYoEGtSKvGOiTTovEWVbKszdDXLT9QIP11+/sbbg6T4i4ysU+y1suS" +
       "RdsUqsatLlKvaBaTNJlaGyiNI0WHSS1q9ktM0bUuMkWx2pOGqsgKW6/HKU7Y" +
       "KpkxUiMxZio9KUbb7QUYqY8BJ1HOSXRVcLg5Ripl3Rh0p0/zTG/xjODMpLuX" +
       "xUh1bKfUL0VTTFGjMcVizWmTXGfo6mCvqrMITbPITvUGWwXrYjdkqaDxyaqP" +
       "Lh3oq+YqmCxpms64eNYmaulqP43HSJXb26rSpHUH+TIpiJEKz2RGmmLOplHY" +
       "NAqbOtK6s4D7CVRLJVt0Lg5zVio2ZGSIkdn+RQzJlJL2Mh2cZ1ihlNmyc2KQ" +
       "dlZGWiFlloj3XRc9+MD26uMFpKqLVClaJ7IjAxMMNukChdJkDzWtVfE4jXeR" +
       "Gg0Ou5OaiqQqQ/ZJT7KUXk1iKTh+Ry3YmTKoyfd0dQXnCLKZKZnpZka8BDco" +
       "+1dRQpV6QdaprqxCwjbsBwHLFWDMTEhgdzZJ4S5FizMyM0iRkbHp8zABSEuS" +
       "lPXpma0KNQk6yCRhIqqk9UY7wfS0XphapIMBmoxMz7so6tqQ5F1SL+1GiwzM" +
       "6xBDMKuMKwJJGJkSnMZXglOaHjglz/l8uGHZ/t3aWi1MQsBznMoq8l8BRA0B" +
       "ok00QU0KfiAIKxfE7pemPjcSJgQmTwlMFnOevvPiyoUNJ14Sc2bkmLOxZyeV" +
       "Wbd8uGfia3Ut828uQDZKDd1S8PB9knMv67BHmtMGIMzUzIo4GHEGT2w6+aW7" +
       "jtIPwqS8nRTLuppKgh3VyHrSUFRq3ko1akqMxttJGdXiLXy8nZTAd0zRqOjd" +
       "mEhYlLWTQpV3Fev8N6goAUugisrhW9ESuvNtSKyPf6cNQkgJPGQhPFVE/PE3" +
       "IzuifXqSRiVZ0hRNj3aYOsqPB6rFpSijFnzHYdTQo1ZKS6j6QNQy5ahu9mZ+" +
       "y7pJo3HFMlRpMNoGTkrXiB8RtDTjU9gjjXJOHgiF4AjqggCggu+s1dU4Nbvl" +
       "g6nVrRcf735FGBc6hK0hRubCdhF7uwhuF7G3i3i3I6EQ3+Ua3FYcMhzRLnB2" +
       "QNvK+Z23r9sx0lgA1mUMFIJ+wzC10Rd1WlxEcGC8W/7LuneXrB2+5WyYhAE0" +
       "eiDquOA/ywP+GLVMXaZxwJ58QcABwmh+2M/JAzlxaODurXsWcR68aI4LFgEQ" +
       "IXkHYnBmi6agF+dat2rf+x89cf+w7vqzLzw4US2LEmGiMXiWQeG75QWzpKe6" +
       "nxtuCpNCwB7AWyaBfwCUNQT38MFFswO9KEspCJzQzaSk4pCDl+Wsz9QH3B5u" +
       "ZDX8+xo42gr0n1p4JtsOxd84OtXAtlYYJdpKQAoO7Z/rNB7+5at/WMLV7USB" +
       "Kk/47qSs2YM8uNgkjjE1rultNimFeW8f6rj3vg/3beN2BzPm5NqwCdsWQBw4" +
       "QlDzV1+649z5dw6/Hs7YaohB6E31QAaTzgiJ/aR8DCFht3kuP4BcKng2Wk3T" +
       "Fg2sUkkoUo9K0Tn+WTV38VN/2l8t7ECFHseMFl5+Abf/2tXkrle2/72BLxOS" +
       "MXK6OnOnCTie7K68yjSlQeQjffeZ+u+8KD0MwA5gailDlOMj4Tog/NCWcvmj" +
       "vF0SGLsRmybLa/x+//JkON3ygdcvTNh64fmLnFt/iuQ96/WS0SzMC5u5aVi+" +
       "NggwayWrD+YtPbHhtmr1xCVYsQtWlCEvsDaaAG5pn2XYs4tKfvXTn03d8VoB" +
       "CbeRclWX4m0SdzJSBtZNrT7AxbSxYqU43IFSaKq5qCRLeNTnzNwn1Zo0GNft" +
       "0DO1P1r26Og73Kj4CvXZ/lJrm1Jtbn/Bdh42C7KtMB9p4LxCwp7572mQFHOu" +
       "MeGJiISH79Q6xiG3Y7OSD92EzSrhEbdcmaKwY4WgmJGJAnW+KMCLChfEjp69" +
       "6RePfuv+AZGWzM+P3AG6aR9vVHv2/vYfWebFMTtHyhSg74oee2h6y/IPOL0L" +
       "nkg9J50dSiG8uLTXH03+LdxY/EKYlHSRatlO4rdKagohqQsSV8vJ7CHR9437" +
       "k1CRcTVngkNdELg92wZh2w3h8I2z8XtCAKkr8VjqnBNz3l7LCxH+sVkYH2/n" +
       "Y7PQAcYSw1Sg0KMBZKwYY1FGSjEzcxhsc62bm9SWy5nUBj//DfDU2FvV5OH/" +
       "dtd5vpDNaD5qBirFDMdxl8VXlAg1bYKclJq8KyDa9jFES+fyb/5XTAK5adC/" +
       "Z/i9eloWmzZniJ71+eoLXhsd3ntwNL7xkcXC3Sb5c/ZWKEkfe+NfpyKHfvNy" +
       "jjSxjOnGZ1TaT1UPU3i5UO9z8PW89HK9pfxriybHWDqRneHhKg15crgF+ZEg" +
       "uMGLe/84ffPyvh3jSN9mBpQUXPKH64+9fOs8+dthXj0K58yqOv1EzX6XLDcp" +
       "lMnaZp9jNvpDwmdt53ScdJwhIR9pAN0L+DkV+NNxvKfpTPVYkFQrSciy+u1K" +
       "8vqOHfJIU8d7wj6uzUEg5k05Er1n65s7T3Gdl+KhZiT1HOgqs9eTQFYLET6B" +
       "vxA8/8YHWccOfAM2tthl4axMXWgYaNRjxIWAANHhSed3PfT+Y0KAYBAITKYj" +
       "B7/xSWT/QWHs4nJhTlZ976URFwxCHGyGkbvZY+3CKdp+/8Twj48M7wvbURbM" +
       "qUCx7328YRsyZr/KBZ9rvl717IFJBW2Q6beT0pSm3JGi7XG/wZVYqR7PGbh3" +
       "Ea752RyjvhkJLQDVYsedvOGfg2MkBt/EhjEIbkmpl66mvYpwsD22GvD1FUYK" +
       "+3Ul7gJiavzpA+82/J6C1Itsc180fk/JRxoQt0ggmquUQMN3OjSGjh7E5l5G" +
       "KrmOOkwKFQfX/z2uRg5eHY20wrPUFmvp+DWSj/TKNeK/VM7AAy82hNXeVnHy" +
       "J9b3f3dcuGIu8AlcYx15tFR+K3nyPcdLdmf4RmnJOnhO23yfFoDxxf/9esUa" +
       "tBhNRtv5iUkaVZ2rm//b2ggZc/MDmkeDoz+Y8+qe0Tnv8oqnVLEgQAKk5rhE" +
       "9NBcOHb+gzMT6h/ntwKFiMw2IvhvX7MvV313plz/VdgcSTtpR6037eAWjqWQ" +
       "bhqGQYJIhj9H0nyVw2M4zHFsvstIBV9uixEHyA/4y/eujr8sJyLeEuc9Pn/J" +
       "RzoOf7mMFjkTz46hqxPYPA1pGCdqU1Q1oKlnro6mpsOzzBZ32fg1lY90DMl+" +
       "PsbYKWxegIqCS92qxQNCn/wv6lMAaG8+j+X9tKz/nYj7fvnx0arS2tEtbwp3" +
       "cu7kKyHpSaRU1VuDeb6LDZMmFM5/pajIRKg9myt3t0sMqLTsL872GUHxBtTw" +
       "QQoIsvjyTjsHLuSZxjAb4F/eSb+GpAMm4efbRo4bAlGNpkOe7N4uWrimp1xO" +
       "0xkS7zUcwhv/95WD/SnxD6xu+YnRdRt2X7zxEXENKKvS0BCuUgFIJG4kM9n6" +
       "7LyrOWsVr51/aeKTZXOdyFEjGHatdYbHpFYAPhl46NMDd2RWU+aq7NzhZc+f" +
       "Hik+A8i7jYQkRiZvy67b00YKip9tseyUDYCaX941z39wcPnCxJ/f4tdCRKR4" +
       "dfnnd8tlH+8fmm2FImFS1k6KIHWkaX6hsGZQ20TlftOX/xX36CktA+kT0Tol" +
       "vOXhWrGVOSHTi1fIjDRm57fZ1+rlYDrUXI2r29HDV9ukDMM7yrW6D5vhtIjL" +
       "Bd2x9YbhJPYJrnUIE/i+wEPDfwCuZpDhlx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
