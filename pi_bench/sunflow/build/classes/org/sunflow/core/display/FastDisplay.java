package org.sunflow.core.display;
@java.lang.SuppressWarnings("serial") 
public class FastDisplay extends javax.swing.JPanel implements org.sunflow.core.Display {
    private javax.swing.JFrame frame;
    private java.awt.image.BufferedImage image;
    private int[] pixels;
    private org.sunflow.system.Timer t;
    private float seconds;
    private int frames;
    public FastDisplay() { super();
                           image = null;
                           frame = null;
                           t = new org.sunflow.system.Timer();
                           frames = 0;
                           seconds = 0; }
    public synchronized void imageBegin(int w, int h, int bucketSize) { if (frame !=
                                                                              null &&
                                                                              image !=
                                                                              null &&
                                                                              w ==
                                                                              image.
                                                                              getWidth(
                                                                                ) &&
                                                                              h ==
                                                                              image.
                                                                              getHeight(
                                                                                )) {
                                                                            frame.
                                                                              setSize(
                                                                                w,
                                                                                h);
                                                                        }
                                                                        else {
                                                                            pixels =
                                                                              (new int[w *
                                                                                         h]);
                                                                            image =
                                                                              new java.awt.image.BufferedImage(
                                                                                w,
                                                                                h,
                                                                                java.awt.image.BufferedImage.
                                                                                  TYPE_INT_ARGB);
                                                                            if (frame ==
                                                                                  null) {
                                                                                setPreferredSize(
                                                                                  new java.awt.Dimension(
                                                                                    w,
                                                                                    h));
                                                                                frame =
                                                                                  new javax.swing.JFrame(
                                                                                    "Sunflow v" +
                                                                                    org.sunflow.SunflowAPI.
                                                                                      VERSION);
                                                                                frame.
                                                                                  setDefaultCloseOperation(
                                                                                    javax.swing.JFrame.
                                                                                      EXIT_ON_CLOSE);
                                                                                frame.
                                                                                  addKeyListener(
                                                                                    new java.awt.event.KeyAdapter(
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
                                                                                frame.
                                                                                  setContentPane(
                                                                                    this);
                                                                                frame.
                                                                                  pack(
                                                                                    );
                                                                                frame.
                                                                                  setLocationRelativeTo(
                                                                                    null);
                                                                                frame.
                                                                                  setVisible(
                                                                                    true);
                                                                            }
                                                                        }
                                                                        t.
                                                                          start(
                                                                            );
    }
    public void imagePrepare(int x, int y,
                             int w,
                             int h,
                             int id) {  }
    public void imageUpdate(int x, int y,
                            int w,
                            int h,
                            org.sunflow.image.Color[] data) {
        int iw =
          image.
          getWidth(
            );
        int off =
          x +
          iw *
          y;
        iw -=
          w;
        for (int j =
               0,
               index =
                 0;
             j <
               h;
             j++,
               off +=
                 iw)
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   index++,
                   off++)
                pixels[off] =
                  -16777216 |
                    data[index].
                    toRGB(
                      );
    }
    public void imageFill(int x, int y, int w,
                          int h,
                          org.sunflow.image.Color c) {
        int iw =
          image.
          getWidth(
            );
        int off =
          x +
          iw *
          y;
        iw -=
          w;
        int rgb =
          -16777216 |
          c.
          toRGB(
            );
        for (int j =
               0,
               index =
                 0;
             j <
               h;
             j++,
               off +=
                 iw)
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   index++,
                   off++)
                pixels[off] =
                  rgb;
    }
    public synchronized void imageEnd() {
        image.
          setRGB(
            0,
            0,
            image.
              getWidth(
                ),
            image.
              getHeight(
                ),
            pixels,
            0,
            image.
              getWidth(
                ));
        repaint(
          );
        t.
          end(
            );
        seconds +=
          t.
            seconds(
              );
        frames++;
        if (seconds >
              1) {
            frame.
              setTitle(
                java.lang.String.
                  format(
                    "Sunflow v%s - %.2f fps",
                    org.sunflow.SunflowAPI.
                      VERSION,
                    frames /
                      seconds));
            frames =
              0;
            seconds =
              0;
        }
    }
    public synchronized void paint(java.awt.Graphics g) {
        if (image ==
              null)
            return;
        g.
          drawImage(
            image,
            0,
            0,
            null);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUaa3BcVfnspnk0SZtnk5C+0xTsg11AEDC1tg1Jm7ppY5PG" +
       "IYWmN3fPJre9e+/l3rPJJhh5zDitjCKP8hTyQ4pFprQMI6OOAnXQAvKYoSLP" +
       "oVVRQbEDFQUUFL/vnHv33r27d2sYujP37Nlzz/ed73W+xzl74AQptkyygGos" +
       "wsYNakU6NNYjmRaNt6uSZfXB2KB8W5H03va3Nl0cJiUDZPaIZHXLkkU7FarG" +
       "rQEyX9EsJmkytTZRGkeIHpNa1ByVmKJrA2SOYnUlDVWRFdatxylO6JfMGKmR" +
       "GDOVoRSjXTYCRubHgJIopyS61v+6LUYqZd0Yd6c3eaa3e97gzKS7lsVIdWyn" +
       "NCpFU0xRozHFYm1pk6wwdHV8WNVZhKZZZKd6gS2CjbELckTQ8mDV+x/dMFLN" +
       "RVAnaZrOOHvWFmrp6iiNx0iVO9qh0qR1BfkGKYqRCs9kRlpjzqJRWDQKizrc" +
       "urOA+llUSyXbdc4OczCVGDISxMjibCSGZEpJG00PpxkwlDGbdw4M3C7KcCu4" +
       "zGHxlhXRvbdtr36oiFQNkCpF60VyZCCCwSIDIFCaHKKmtTYep/EBUqOBsnup" +
       "qUiqMmFrutZShjWJpUD9jlhwMGVQk6/pygr0CLyZKZnpZoa9BDco+1dxQpWG" +
       "gdcGl1fBYSeOA4PlChBmJiSwOxtkxi5FizOy0A+R4bH1KzABQEuTlI3omaVm" +
       "aBIMkFphIqqkDUd7wfS0YZharIMBmow0ByJFWRuSvEsapoNokb55PeIVzJrJ" +
       "BYEgjMzxT+OYQEvNPi159HNi06rrr9Q2aGESAprjVFaR/goAWuAD2kIT1KSw" +
       "DwRg5fLYrVLDI3vChMDkOb7JYs6Pv35yzcoFh58Uc+bmmbN5aCeV2aC8b2j2" +
       "8/Pal11chGSUGbqloPKzOOe7rMd+05Y2wMM0ZDDiy4jz8vCWI5defT99O0zK" +
       "u0iJrKupJNhRjawnDUWl5nqqUVNiNN5FZlIt3s7fd5FS6McUjYrRzYmERVkX" +
       "maHyoRKd/wYRJQAFiqgc+oqW0J2+IbER3k8bhJBSeMgX4akl4sO/GemJjuhJ" +
       "GjWUaI+pI+tWFJzNEIh1JGqltISqj0UtU47q5nDmt6ybNBpXLEOVxqOdksUu" +
       "Ef0IWpZxGnCmkY+6sVAIRDzPv8FV2BsbdDVOzUF5b2pdx8mDg08L40GDtyUA" +
       "LglWi9irRXC1iL1axLMaCYX4IvW4qtAhaGAX7GVwppXLei/fuGNPSxEYjzE2" +
       "A8SHU1uygkq7u+EdLz0oH6qdNbH42LmPh8mMGKmVZJaSVIwRa81h8D7yLnuD" +
       "Vg5BuHG9/iKP18dwZeoyjYPTCfL+NpYyfZSaOM5IvQeDE5Nw90WDI0Je+snh" +
       "28eu6b/qnDAJZzt6XLIYfBSC96B7zrjhVv8Gz4e3avdb7x+6dVJ3t3pW5HAC" +
       "Xg4k8tDiNwO/eAbl5YukhwcfmWzlYp8JrphJsHXAyy3wr5HlSdocr4y8lAHD" +
       "Cd1MSiq+cmRczkZMfcwd4fZZw/v1YBYVuLUa4Gm29xr/xrcNBraNwp7Rznxc" +
       "cK//pV7j7pef+8vnubidAFHliey9lLV5nBIiq+Xup8Y12z6TUpj3+u09N99y" +
       "Yvc2brMwY0m+BVuxbQdnBCoEMX/zySteOX5s3wth184ZROXUECQ36QyTOE7K" +
       "CzAJq53p0gNOTQVPgFbTulUD+1QSijSkUtxYH1ctPffhv11fLexAhRHHjFae" +
       "GoE7fsY6cvXT2z9YwNGEZAyqrszcacJT17mY15qmNI50pK85Ov+OJ6S7weeD" +
       "n7WUCcpdJ+EyIFxpF3D+z+Ht+b53F2Kz1PIaf/b+8iQ/g/INL7w7q//dR09y" +
       "arOzJ6+uuyWjTZgXNmemAX2j3zltkKwRmHf+4U2XVauHPwKMA4BRhpTB2myC" +
       "X0xnWYY9u7j01V883rDj+SIS7iTlqi7FOyW+ychMsG5qjYBLTRtfXiOUO1YG" +
       "TTVnleQwnzOAAl6YX3UdSYNxYU/8pPFHq/ZPHeNWZggcczl8CXr5LK/Kc3B3" +
       "Y9//mwt/u//GW8dEFF8W7M18cE3/3qwOXfuHD3NEzv1YngzDBz8QPXBXc/vq" +
       "tzm861AQujWdG5nAKbuw592f/Ge4peRXYVI6QKplO+ftl9QUbtMByPMsJxGG" +
       "vDjrfXbOJhKUtozDnOd3Zp5l/a7MjYjQx9nYn+XzXpWowjPgqbM3dp3fe4UI" +
       "73RxkLN4uxybsx1nUWqYCtRF1OctKgogZUApBBDhUJuAZR73I9YYJKiRjZ2m" +
       "TXgdf38RNhsF9rZAE23PZmkRPPX26vUBLPUJlrCJ5dIeBA20K0nIfh3a53HT" +
       "l8ZYhA9H1qUSGF/iXfjLx8XWaXKBiplj0zEngIvLC3IRBI0+XklT1cqulDFx" +
       "6E0NWYy7SZFGX1Zx5DHrnj8/JDZgS57Jvtz8vv1l8mvJI38UAGfkARDz5twX" +
       "/U7/Szuf4aGvDPOhPsdKPdkO5E2euFudYXE2clQDz1ybRf7NSO+nzUfBjJMQ" +
       "YkdptA8qQG1Ypd3gGJ0093SgRf++NNiheXQw9YMlz101teT33NuXKRZse5BL" +
       "ntrKA/PugeNvH501/yDPiGageG3RZheluTVnVinJpV6FTSJt5Vd/j8OhWPe8" +
       "nh3yntYern6EE4jqP4FPCJ7/4oOqwgGhstp2uzZalCmOMEgU9Pa+RaOTtcd3" +
       "3fXWA8Lm/K7dN5nu2XvdJ5Hr94oURFTYS3KKXC+MqLKFBWKjIXWLC63CITrf" +
       "PDT5s/smdwuqarPrxQ4tlXzgxf88E7n9d0/lKWGKFPuUBGNtKFOB1GcrQDB0" +
       "ybeqfn5DbVEnqLqLlKU05YoU7Ypnh4BSKzXk2V9u5e6GBZs1VAwjoeVOoPYS" +
       "wJ2UsAbb/0zmDwxh7EbQ0SuapHL0UFCXqFQbFpUqB9jlWSIs4By/KnI2jIKR" +
       "dlXXKKZ/zjtRsSl6JHNYAy9ziTXJ/KzMopvbtRumX5990xs/bR1eN51SDccW" +
       "nKIYw98LQeHLg83XT8oT1/61uW/1yI5pVF0LfebnR/nD7gNPrT9TvinMz4NE" +
       "/pBzjpQN1JZtMuUmZSlTyzaSJUL7XHtu6FnBFVwgX/5ugXc3YvNtsBUZFS3s" +
       "osD0vbkpKA6sNTzZqm0C+HMi7YvC26cZhbHTYAeZhoAofEfBKBwEDbuMOTbd" +
       "5D2ysMYtRpORPiUpMk4P9XdOk3qs1Brt9RsDqP9+QeqDoCH1sygkr3GLw6i2" +
       "Y8Qvw9Nn6ASg5MjxZnmVc8802UOimmwCmwLYO1iQvSBo8FZukpr0kXmoAJnp" +
       "gFSZe0Q3S+afEuI7pPMQ4KmSQnmthB9s2YdZGJDmBx208mC079q9U/HN957r" +
       "xOUUg+JPN85W6Sjkge5aJby/J0Mnl0sHPC02nS1+MbuyCQwDldY4ZEqmrkGd" +
       "HfdVCo0FcPvcQBFHWpTRiGg4AUcKeIwnsXmMQa6DSfk6Oqxo+cx0xqiuxF0d" +
       "Hz6VKRYui4VP8gmTnxatsR+nHyRM7lhzz2CCQH0CKOaEFPtk5ZPaiwWk9jI2" +
       "z4PuuNR6TGpIJvfOv3ZldPR0yQgNrt1mtH36MgoC/f9lxOcMZTAjPWQjPM/a" +
       "mPk3I12foi4Q3j3KK8QeSaOqU2R8dsiErBVs/pR2nEej13mIarVdV3XTMIyA" +
       "yMkl/UYBGzmBzTFGKji6rUYcknefiRw/XSayGp6YrY3Y9E0kCHSaJlJArpyI" +
       "DwtI72Ns3gM/zIE6FVX1ye4fp0F23J+fBU+/LYD+ArLL78+xeTyPFw/CGCyC" +
       "UFmBd+XYhBkUvCieDi2eLZ1Q0emSTgSehM1L4jOTThBGnwRC2RG/JnO+tN6U" +
       "jBFFtrhsGgrIrRmbaki7DAmKSJ/Qaj4LoaVhx3tu0vAIuCnnLl7cH8sHp6rK" +
       "Gqe2viTOIZw73kqolxIpVfUeUnr6JYZJEwqXdaU4sjQ4ay35UiD7bg/yUbuH" +
       "ZIcWC4iljFT7ISDU45d32ueAI880zG1FzztpBZTlMAm7Kw1HQdmHl9wFp0Oe" +
       "fMqWIt/Pc7KFX5kRfkbdzW7Z25syQAqW9TXJ1AC3FQQKih7Fo2NQwvmnvIzA" +
       "v3FQ+6yZHxYNypUVl/79l5P/IuIQAlDxhfz3XDw7xWKixjbjGv/GwBun/PcA" +
       "vQqeezFdw7uA5e8sq161/3u38eVKqaAHMaznVwkXTosF5xh9UO7+6jUXz7vu" +
       "zVfFaSI/U4cZHG/u+Tdq8CIw4hKLHyA4wq/2CJ//WyLtbIqMKr23akgg/6OK" +
       "U4GnxF9VBuVDUxs3XXnyC/eKWz1ZlSYmEEsFMCwuGG0Rew+R/NgcXCUbln00" +
       "+8GZS528vUYYkuuG5noiylqwBwPF2Oy78rJaMzdfr+xb9eize0qOggK2kZDE" +
       "SN223CuHtJGCgmJbLPe4qV8y+V1c27I7x1evTLzzGr/UIeLAZV7w/EF54OaX" +
       "ux7c9cEa/s+IYihJaJrfhVwyrm2h8qiZdXY1Gz2FhErgcrDFNyszinfAjLTk" +
       "Htvl3pyXwzam5jo9JSLIrBipcEeEJnwHH7DzfADuiGd3jGOjpVH64BkGY92G" +
       "4Zxq7jb4rpgILHpD3byLvU3/AzuW8mCzJgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C+zr1nmf7rXvvfa1Y1/b8aOe4zh+tLXV/SmKkijVaWo+" +
       "RIrUWxQpku16Q/EhUeJLfIiP1G0SoE2QAFmwOW2Gth4KJOtWuEk3rNiAoYO3" +
       "bm26BgWaFetaYHG3dWi2LFhSdFm3rO0OKf1fuo/YSbo/wKNDntf3fef7fuc7" +
       "53z/175SuhT4pbLnWunCcsMjPQmPVlb9KEw9PThie/WR4ge6RlhKEEzBt+vq" +
       "0798/9e/8fHltYuly3LpIcVx3FAJTdcJJnrgWltd65XuP/3atnQ7CEvXeitl" +
       "q0BRaFpQzwzCF3ule840DUvP9o5JgAAJECABKkiAsNNaoNHbdCeyibyF4oTB" +
       "pvRjpQu90mVPzckLS+8634mn+Iq972ZUcAB6uCt/FwBTRePELz11wvuO5xsY" +
       "/kQZeuWnf+TaP7qjdL9cut90uJwcFRARgkHk0r22bs91P8A0Tdfk0gOOrmuc" +
       "7puKZWYF3XLpwcBcOEoY+fqJkPKPkaf7xZinkrtXzXnzIzV0/RP2DFO3tOO3" +
       "S4alLACvj5zyuuOQyr8DBq+agDDfUFT9uMmda9PRwtI7D1uc8PhsF1QATa/Y" +
       "erh0T4a601HAh9KDu7mzFGcBcaFvOgtQ9ZIbgVHC0uO37DSXtaeoa2WhXw9L" +
       "jx3WG+2KQK27C0HkTcLSw4fVip7ALD1+MEtn5ucrg3d/7H1Ox7lY0KzpqpXT" +
       "fxdo9ORBo4lu6L7uqPqu4b0v9H5KeeRXP3yxVAKVHz6ovKvzT370ay9935Ov" +
       "f25X56/dpM5wvtLV8Lr6qfl9v/ME8XzrjpyMuzw3MPPJP8d5of6jfcmLiQcs" +
       "75GTHvPCo+PC1ye/Lr3/F/UvXyxdZUqXVdeKbKBHD6iu7ZmW7tO6o/tKqGtM" +
       "6W7d0YiinCldAfme6ei7r0PDCPSQKd1pFZ8uu8U7EJEBushFdAXkTcdwj/Oe" +
       "Ei6LfOKVSqUr4Cl9P3geLO3+it+wNIKWrq1DngmNfDdnPYB0J5wDsS6hIHIM" +
       "y42hwFch11+cvKuur0OaGXiWkkKUEoTkLn+Ua5b3V9BnkvNxLb5wAYj4iUMD" +
       "t4BtdFxL0/3r6isR3v7aZ67/1sUThd9LAEASGO1oP9pRPtrRfrSjM6OVLlwo" +
       "Bnl7PupuDsEMrIEtA5S793nub7Dv/fDTdwDl8eI7gfjyqtCtwZY4tX6mwDgV" +
       "qGDp9U/GHxB+vHKxdPE8auaUgk9X8+ajHOtOMO3ZQ2u5Wb/3f+hLX//sT73s" +
       "ntrNORjem/ONLXNzfPpQpr6r6hoAuNPuX3hK+ZXrv/rysxdLdwIbB7gWKkAP" +
       "AWQ8eTjGObN88Rjicl4uAYYN17cVKy86xqWr4dJ349MvxWTfV+QfADK+J9fT" +
       "R8Dz+F5xi9+89CEvT9++U4580g64KCD0Bzjv5/79b/9XpBD3Mdref2b94vTw" +
       "xTMWnnd2f2HLD5zqwNTXdVDvP3xy9Lc/8ZUP/VChAKDGMzcb8Nk8JYBlgykE" +
       "Yv6Jz21+/40vfup3L54qTQiWuGhumWpywmT+vXT1NkyC0b77lB6AEBYwq1xr" +
       "nuUd29VMw1Tmlp5r6f+9/zn4V/77x67t9MACX47V6Pu+eQen378LL73/t37k" +
       "fz1ZdHNBzVeoU5mdVtvB3kOnPWO+r6Q5HckHvvCOv/Mbys8BAAWgFZiZXuBQ" +
       "qZBBqZg0qOD/hSI9OiiD8+SdwVnlP29fZzyJ6+rHf/erbxO++s+/VlB73hU5" +
       "O9d9xXtxp1558lQCun/00NI7SrAE9WqvD374mvX6N0CPMuhRBetvMPQByCTn" +
       "NGNf+9KVP/gXv/bIe3/njtJFqnTVchWNUgojK90NtFsPlgCfEu8HX9pNbnwX" +
       "SK4VrJZuYH6nFI8Vb3cDAp+/Nb5QuSdxaqKP/Z+hNf/gf/qzG4RQIMtNFtCD" +
       "9jL02s8+Trzny0X7UxPPWz+Z3Ai8wOs6bVv9Rft/Xnz68r++WLoil66pe5dO" +
       "UKwoNxwZuDHBsZ8H3L5z5eddkt36++IJhD1xCC9nhj0El1PAB/m8dp6/eoAn" +
       "9+ZS/i7wPLQ3tYcO8eRCqcj8YNHkXUX6bJ58z7H5XvF8cwvW6739/iX4uwCe" +
       "v8ifvLP8w251fZDYL/FPnazxHliLLhkA3ndw9zCoVCxxR0EMfLEjlvL3TFwr" +
       "yqt58tJupPotFej7z7P3FHjevmfv7bdgr3sL9vIsUciMBISaNvDqjgl9otB7" +
       "JQ6Pis9HeGTkUK8x+dsByb23SHI+Iw/vSX74FiRP3wzJlz0z0a0AWM5zt7ac" +
       "AqV2LuGrf++Z3/7xV5/5j4Wh32UGQL8wf3ETH/VMm6++9saXv/C2d3ymWAzv" +
       "nCvBTtMOnfsbffdzLnlB8b3n14Arh4oZljrfqjeFR+paDwvQOvbMvmN9JbdH" +
       "ppFv2mA53e5dc+jlB99Y/+yXfmnndh/C0EFl/cOvfOQvjz72ysUzm51nbthv" +
       "nG2z2/AU4nxboQU5de+63ShFC+qPP/vyP/v7L39oR9WD5133NtiZ/tK/+/PP" +
       "H33yD3/zJt7kHeZ+w5pD94W9M1iodZ788LHGLm+usRfz7PfmOGA6inWiuZbu" +
       "LHY++zxPfshLToa4uGt3bIm7BTcHTLB1ch09X7uPy3a+q+kenWxbQWFyA7F+" +
       "6YVbz1+/UNNTeP+ND/63x6fvWb73LTit7zyQ/2GX/6D/2m/S363+rYulO07A" +
       "/oY97flGL56H+Ku+DjbhzvQc0L9jJ/9Cfjvh58lzhYhv426ktyl7X55swWyp" +
       "uah3M3Ob6j+WlA6wkH+LWJhD9iN7EHjkFlj4gTeDhRfCY6V47OzuJ0iDULeP" +
       "pqa9W93PkPrBt0hq7qc+uif10VuQ+pE3Q+qVQAdegRYUta7vrTj/UXMzAR5V" +
       "eEDpR98ipTl1j+0pfewWlL7yphaY08V7fkDTJ74pTTvGLgAn4lL1CD2q5O8/" +
       "c/NR79iDxOWgOKHK39bHNDy6stRnj30LQfcDYIvPriz0eLqvneLD7ozngFDy" +
       "TRMKcOK+0856rrN48aN/9PHP/81n3gCoyJYubXMXDpj7mREHUX6C9pOvfeId" +
       "97zyhx8tNj5AhtxLP+G+P+/107djN0/+7jlWH89Z5dzIV/Ue2Kj3i72Krp1w" +
       "e6ArdwIb/da5DR/4004tYLDjvx6vKAiuCoYTeM66wsmhs64T5UoyDRYwjLVJ" +
       "Ag4XMGujnifVRzQjzewBYoxYX2/pZchC/BHLLpf1jDTDFdEdNZfTdFzzKM8f" +
       "95nGcIg54hjbdiWX641cQZiM522SGvM81YO2TmeLIH4V1aqBFK1GCDqwsgzS" +
       "NRSZlZPMQmvY2AvXabqg3SAOpIGy5huDgbSyJ8ogbEScbIh4tYs3Z/VOBdkq" +
       "yMCqqKzJk/JIYeSO2FuveZRSfNoft1Ox1Q5Ye52GU3lCr3Wm4w0UGE8Fu8v6" +
       "WJUbSg5vkcJsQmlKmKTWsMEafbprT2hyKLgTbiVOJWISzTsLlnG9lGvA23Kj" +
       "x0sbWatIWkNFdCBFvYUusi6HWoHAaLPUGRAexVeSiZt1KMmGvXUjjrWO0JwN" +
       "BHnZlWW5qzUWXJVYzds9dT0dN21SKCeQ1qd6g4mAOYrsD4ed7Yyyfa9hmoOk" +
       "YgrD1mZZ2Uxg3FjTXWkzIYLWemJ5q2zDTmbkuGtmvhr5Q6xsWTyXinNNrQ3V" +
       "jBBokuGS/sqcExwttz2WrlRGXrKOLZKea3GtjxBoVyWiWkZ3EmspTrZzLfSR" +
       "hmtS48Ea8NGoCKlMEETMMSRDEUqn27XDqaR7UBvnN0M8cCJvw5ubvk35UShz" +
       "y9WM9XiytbKWcZ8WxusG5KULv0L0UrkrO57sKi2cVN0yrCVjb0YvNJW2YAOX" +
       "OH2I1UYWscRt1uTiYRKuExPsA7NhWsHKk9q8A3czDB+3o6nFIK6tCLaCM/01" +
       "5S2ZzWZN8hoaG1xFkpdgF9XHbTeu4ClLzSYRt20HiucO3PW8Xh/pjJCxPotL" +
       "7cWqnyXT8lAat7eDkQnXW52BWWn4vt8aVxW6zWGevxIoZQItXGwWYWR1zUzh" +
       "LheT8WRRN3qSL/RIBtkSyz65Hs5RVgoaoy1STzPVpZb1Jq+W57Y9H9QVQheq" +
       "CtGcV1fVJjRSLBhWlzTH0/ON5Y662XCoo35fK1fqUjXu9ysySZppbZU1t8SM" +
       "qWu6MW21hpWsG1VM1u9GHjtYTlZK7JD8zKo7mw0vDMzBoE7JFhMiAWpodYpr" +
       "9FV+JfmTTLLbE2Et2kondSddDYqlCTvGKHOzUMvuZlZhq2Vm3p4g6+Z8yeKc" +
       "3l+INWVt1YIhROs2u4qWLL2a8QpT9phyOKPYbNBmljBLb6yQ4TarCh/yNXRT" +
       "d0g7bKTzAe6JvfZQSDZDbR3wUduoMDNPTmiHsNdSuREIGDMhs9G2SQlVPJhr" +
       "pDDMeKo+r3paAgxhUWn2ahWaDFMe6y2smdky/YlIwGYPVpJeXyEkscZsZ7VN" +
       "iC0VGhNRWog9MKRuQkZED0Zc0pZWWbuKNbkOD0fpYr1Bo3Jb62UVt9PYaIN5" +
       "p1bt2aNl087tXJBZhROYeKI04WWTRNOeE5HCoo5HHboFmd0R3NRiWXfTlTSa" +
       "EkavPPCk1JA5ZdivM9uxTrbrg7hVmZFMhdXLgbOsNvWoMYc2DomxchY2xB4j" +
       "GThHtBo4mvmrpbBt0llNR5StNkeTckMTWCREPABlGCEuautmSJqDeAjp2Nyq" +
       "S9F6GauGPcssyWuyvrdkg46IpSkS+/WOxWmu6tfSpoV1SEKD+5y5Kav2RM3W" +
       "ct9QY61myHIMbWEJl4QI4H2NtqutxIcSXx3gvjKIPXSSOYmqdiHIE9AV6ulG" +
       "ubl1ormpYVTHMvW0ZfWEuoMzoGcx8poSXM0aU95bIeWo0hq0Wqm0Vatzvx9L" +
       "FbuMC1EyH2sOTrjtvghlKRfqQ7EeIHG4hJs1eTIU+TYxRhrjdDpso10iw9hN" +
       "HfEqi8FwOhZGC2o+jSyeLMNjzlxxaz5MpA6shiPDWG5h2OjpCbacdDorStFp" +
       "t40agdRQt+K0mrWkeEC3ZSzd+EGmKio7hVFbgusbe8DUK163WR9uy0O2waGx" +
       "rpMOOuMJ1dPYcjtlqMSjELKclTtheV5HqGo3g0eMYkDzctMcQwuIGfTQGN1A" +
       "kDaptFLFH2ZsoxxF6Ww1lRfiwNZtTKyukMwK1914YneMco2vioISdUZxt4/V" +
       "8MnSm+JVOyXESuLMJKkVoasKLDSbiE+uyhzDoebU2pgoNUxn5VRd9gO6vllJ" +
       "eG86CQ3RHPJDWKKnU8Gx9HHsZEMMsxqSiPAaJw0SiYea3ojqbCB51NEHM3mx" +
       "UNXMahKiX+91oa6K4IjUgiA7DqEIguhZU2tTVHOG9uGm2kYgZBMPRSPqkMig" +
       "nQFVcRYZiWfN8UjERRXabsLMbjZgbBytZhpdd7DuPIrrraoBwKHm6RNREpjG" +
       "uOtZw7IRWq0xPw/7eDrqB2xC01ty5RvifMguu3zoZqQz1BDZq1uQgvZX0mqc" +
       "tBzJKYuZ6M3ceDVabOZ9RPMQQ6/xDIpMknVvUIuSdB4ksMPPNhIRTih4qIbd" +
       "hbuQeczDcXLJsxEmT1CEaUkS2zUnK7lqT8WFZiDNyWAZUC1fxtpVZCTb68lo" +
       "JFYbWx7vjXjW8gm2rjE6jlUr3YrDGEtEqSOdqdWUpSXW6sAbnqMpyBSNVS9p" +
       "ijNF7OKmZ60qWdtZMNsegTATnKmUxbU1hdVNZJFU0mhXBjMpRTmZokVYTupk" +
       "x3dWTYgl5QVXR9ltCCB9C1tNe8sySJPHaGONATCsh7EI8SjEZZFRU4DYRsPl" +
       "KNC6I209rLerekRFmiS2q6o1JjM4nU8MdMANy07GG/iK7Y+lteaFWHMzpmHJ" +
       "05AFzVYqLYRbTIxyeTAwl7o4jltS38rgChzqUwQZRGJ3Igd6He85od/FoFG0" +
       "0AfbTr0CQyk5MmllodPIRF7qVgT0TjAd1hMa1JRjw7qgQavmcDkb6U1niaRO" +
       "KOm+02i3a6vNqEaNCBaFau5wEy/oZRB61SiTFYuwh/32gm+NlPJEGU5DVUMQ" +
       "Q5xhzZ4NdVFtUHeiqrjV2HrHb9VcfkJNJQ7pdkWi3N/0uhQ+664YcdYjGgjB" +
       "TH1jRE7rARTYWhxtFH/kJ+NaaInZIjGazTbqtLQKZHVndJcaRTxOD8IuNcRh" +
       "WvXHJF5J5/rGcOrkXGg7m96mZ3V5sOy6PCp5zrKGc91MXFeFVlTXGzQuB7CA" +
       "xStXF4buSOJitsoH2HwOVTKbjJMl2p6PK1ykeJ1ehacIcUON55THb3Dg/cw4" +
       "JqjhKdR1mOqK6U40SxS7XRnKVuEk4KwG2xlIWNrKzKnIQt2s73rbeTiJbLHe" +
       "alWSAJpPYH1QhzlSVWdOl5HiVrM31ju9RRMRp013CkMNOJpBcMrUPYGq9Ax9" +
       "7kwgh0QXg5E/bU23ptPPaoM25OHZyhsPYFYO+xFvy5w1TTOFY/keKnbCqEE5" +
       "OCXECxGqRwtRRaTtIAxwXqY4JHADsrKdr70u1ggG00ze2BWi3OmbqLQlqg1V" +
       "Xs47UwnT5aWLuUbbwLt43CbnUX84nWt1spoGfSmceMPJyOS9/ro2aonacI1s" +
       "Ahj3w9YkIDejVnmsb0iX6MABWKl9hO7FDbMqNcfbuDVwGhi3qPdXiezYgtps" +
       "Vqr80LTtmLDjnjSEzfGWw90mJUdrz68AD8fFWMdbUJysV8YIV1aMdsSg3qg/" +
       "rnVtbuzY4RJvBVVJk2mWtPGkWmnaRAVtbVo81Bm06qifDHl+UWZHg2Z91uBW" +
       "64VeV9h5CrGVvmNVgs6IqFQdDi7351FKjGPS0qSa3N7Y/prWOoYmEG6FUkdb" +
       "dYxTnZk3nZj0oobxaldnYicQ7f5YaZCcsW4MN4lbVpNKsjGjhKponawhdCdS" +
       "ZNaEUXNhT51ECYNJ2emkkz5qLbOsShDjToXoDpU2NQrXdbDRMePZurViqllt" +
       "FEWDSWNKewy7NYZbRLa00aSSjhcDP4TtsIM0+guXgIyWlQzVvjzFVqPZeDXq" +
       "Q4o9WiMMXDVcszZGVsDgmmMdeDYbvjppaoHZ9nEhgLxJ1WnrKxixGcUXNAGo" +
       "X59JsbS/tiBewunMxrMpRXdXZsPnJXXt6IY5iSGRU1Laa0i+BJafdmVNdDiF" +
       "tVjM91KGjEMGrQ4CZNGHMqbdoAQRTvWa4VWoKsKWDZwvQz2JLGN+r4c2y4k+" +
       "TUdUDBE0kRI8ZeNaWZSW+JrfEqZOmlW9J8Pjim5z0wWnL/twr7YaTqdLnHbi" +
       "CVGd0BDrDMvhoMGvcIoK/WVAL3zGn9hzZW2iJGZ3ORYaK6taz1WEZYKEUWWL" +
       "MRHhOD0LVTvNoOM1/C690atbczpk5BhF1hvXShhPMHidd/wGK8lsO96ImsLX" +
       "gtW4pqRInTdJdL6AUn4edWRGnRE101pRU5ThSL5W15BqpGMM0OmMhqksCz1c" +
       "nlp9zEa7MdwZa3bHasWUVxnqRn8zY0JopKJdSqyvJ8Z6rmUzVK7Wg3SMbWYt" +
       "gB8wRiDUGOwBlyjlVgfjeGs7WybDtuBruZHKnUQapB4vWBDasuojiImYMWaR" +
       "ydLIEJGM0WTWNZPVfEVvITrGIweMhm3HG13PKC1GI6yuN4MN3IAhJEKautDd" +
       "KFinr2SOEK/FqRtQ9WTZ4odoubHixQzdRplgUArHQHxNlTs0FJWn2qZJMHFt" +
       "2e11UqwWb6AqwULQLO2Fc2bT7/pVRFkvFlBj2OVrtJNQLQGPBJJPAkQUnZSA" +
       "9O4sg2WLA5uZdkD1iTii6cpEj8sTaLBQRYKfW06lUm7SMlevNre8JK2jCLgr" +
       "rplamxiPR1R1mKJNn1X6mWb45WTe0s1Mr2yGi0W3upbJNjeoVhEi6oQsTSxs" +
       "dt4b6bWN0EzLAqxWUQZNYH077WUZ7UM8o/cwWUBjqE3Va0NFjBJUbaltBQrK" +
       "jGQuWYX1jaUQp75dXTY3pqyJEkxnVWrZ9heqT1KDNMhMx8BWvem6E24txEvF" +
       "OFPs+sptsVyP8YGnobb1NuvEnQ5KZgZGRiatISt6uPKETqOGr2mpVaVrcrJB" +
       "V/Oa7y2YXscjkXna2/IIhGXRDGBbxi4wLD/++Ydv7VjqgeIE7iTkamWhecHP" +
       "v4WTp+Q2h43fexoaUPxdLh0E7pw5vDxzX3zhpse9RbDLPsAlvxl5x62Cr4pb" +
       "kU998JVXteGn4Yv742wtLN0dut5ft/Stbp0Z63KRD07oLM5U2+B5ek/n04eH" +
       "rKeyueWFyL1B6qhL33WA3mk7UR+ctN9x");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Oivz06So+rnbHMr/mzz5l2HpanFziesL07np6eHWNbXT6fu1b3ZweHaYA3kU" +
       "cSsv7Z/j/JuVx14JbiaAS0WFSwcCOBDF791GFL+fJ18Asi5EMfJ1T/GLW43P" +
       "nzL+b79dxnNFIPaME3/ljBd1pBMK4HzABniqewqK37BEfqu3nwfxbd+RfpJj" +
       "W330rK3uLtYJ19oHjN70evG/HN9XfPl21nQGrvLEOhHXH914r5i/FqFP3o0X" +
       "hcXs7oYtWudJfBv9+pPblP1pnnw1T350R8lt6n492f3+59vU+bM8+WJYuqeQ" +
       "G+9pSnioym98u6r8HvD09orU+/9iw1/KG124eGu+L9yZf/xzgMwF35RpWQdc" +
       "/8W3wXWB5N8DHmHPtfAWuD7VvV+/KetnubjvNmXX8uTusHRXwWHb0c4zeOHq" +
       "t8tgXm7sGTS+gwxeOL8SP3ASM0P7irc01aBg7/HbsP5knoCmlzzFdMIDvh95" +
       "K3wnwDLORLfmoXqP3RAfv4vpVj/z6v13Pfoq/3u7mJbjuOu7e6W7jMiyzkZW" +
       "nclf9nywkynkcPcuzsorWHjuZi7IPt42LF3Z53J6Lzy7awEW/2uHLcB6nP+c" +
       "rVYGHJ2plt8b73JnKx2FpTtApTwLeccTcT7KaqQ4upVcOOPP7LWksJ4Hzwv5" +
       "3hMhn0zr42cuWCMPSCEIZorvgL6DWzUN95elYBJq3zSmMf9HC30fIFcEHl1X" +
       "771H+pN/9fL/Lu2iUUBXxUCH4bKFd5jfyh/7jg8c6nYeuHrzSFAOkG/poevk" +
       "8Zsv/I/nr737F37mp4vhrug7evIefqAI+UTfEgvHsX/X1f74A60nPvLHf1BE" +
       "ktxVBAKCGkW/Nwbt5TP4YpJfgRehLPm3n0+OFf1k2s4G4ubEFP8ochx1Eu3+" +
       "VeS6+tlX2cH7vtb49C4QWLWULMt7uQswt4tJ3ovzbOTQYW/HfV3uPP+N+375" +
       "7ueOfeT7dkpzihpnaHvnzWXdtr2wiJPN/umj//jdv/DqF4t78v8HX9KI4cEz" +
       "AAA=");
}
