public class DefineControls extends java.awt.Frame implements java.awt.event.KeyListener, java.awt.event.WindowListener, java.awt.event.ActionListener {
    java.awt.TextField[] controlsField = new java.awt.TextField[8];
    java.util.Hashtable keyNames;
    public DefineControls() { super("Define Controls");
                              keyNames = new java.util.Hashtable();
                              keyNames.put(new java.lang.Integer(38), "Up arrow");
                              keyNames.put(new java.lang.Integer(40), "Down arrow");
                              keyNames.put(new java.lang.Integer(37), "Left arrow");
                              keyNames.put(new java.lang.Integer(39), "Right arrow");
                              keyNames.put(new java.lang.Integer(36), "Pad 7");
                              keyNames.put(new java.lang.Integer(33), "Pad 9");
                              keyNames.put(new java.lang.Integer(35), "Pad 1");
                              keyNames.put(new java.lang.Integer(64), "Pad 3");
                              keyNames.put(new java.lang.Integer(12), "Pad 5");
                              keyNames.put(new java.lang.Integer(155), "Insert");
                              keyNames.put(new java.lang.Integer(36), "Home");
                              keyNames.put(new java.lang.Integer(33), "Page up");
                              keyNames.put(new java.lang.Integer(127), "Delete");
                              keyNames.put(new java.lang.Integer(35), "End");
                              keyNames.put(new java.lang.Integer(34), "Page down");
                              keyNames.put(new java.lang.Integer(10), "Return");
                              keyNames.put(new java.lang.Integer(16), "Shift");
                              keyNames.put(new java.lang.Integer(17), "Control");
                              keyNames.put(new java.lang.Integer(18), "Alt");
                              keyNames.put(new java.lang.Integer(32), "Space");
                              keyNames.put(new java.lang.Integer(20), "Caps lock");
                              keyNames.put(new java.lang.Integer(8), "Backspace");
                              java.awt.GridLayout g = new java.awt.GridLayout(
                                9,
                                2,
                                12,
                                12);
                              setLayout(g);
                              controlsField[0] = addControlsLine("D-pad up:");
                              controlsField[1] = addControlsLine("D-pad down:");
                              controlsField[2] = addControlsLine("D-pad left:");
                              controlsField[3] = addControlsLine("D-pad right:");
                              controlsField[4] = addControlsLine("A button:");
                              controlsField[5] = addControlsLine("B button:");
                              controlsField[6] = addControlsLine("Start button:");
                              controlsField[7] = addControlsLine("Select button:");
                              for (int r = 0; r < 8; r++) { controlsField[r].
                                                              setText(
                                                                getKeyDesc(
                                                                  JavaBoy.
                                                                    keyCodes[r],
                                                                  (char)
                                                                    JavaBoy.
                                                                      keyCodes[r]) +
                                                                " (" +
                                                                JavaBoy.
                                                                  keyCodes[r] +
                                                                ")");
                              }
                              java.awt.Button cancel = new java.awt.Button(
                                "Close");
                              cancel.setActionCommand("Controls close");
                              cancel.addActionListener(this);
                              add(cancel);
                              setSize(230, 300);
                              setResizable(false);
                              addWindowListener(this);
                              show(); }
    public java.lang.String getKeyDesc(int code, char c) { if (keyNames.
                                                                 containsKey(
                                                                   new java.lang.Integer(
                                                                     code))) {
                                                               return (java.lang.String)
                                                                        keyNames.
                                                                        get(
                                                                          new java.lang.Integer(
                                                                            code));
                                                           }
                                                           else {
                                                               return c +
                                                               "";
                                                           }
    }
    public java.awt.TextField addControlsLine(java.lang.String name) {
        add(
          new java.awt.Label(
            name));
        java.awt.TextField t =
          new java.awt.TextField(
          4);
        t.
          addKeyListener(
            this);
        add(
          t);
        return t;
    }
    public void keyPressed(java.awt.event.KeyEvent e) {
        
    }
    public void keyReleased(java.awt.event.KeyEvent e) {
        java.lang.System.
          out.
          println(
            e.
              getKeyCode(
                ) +
            ", " +
            e.
              getKeyChar(
                ));
        for (int r =
               0;
             r <
               8;
             r++) {
            if (e.
                  getSource(
                    ) ==
                  controlsField[r]) {
                controlsField[r].
                  setText(
                    getKeyDesc(
                      e.
                        getKeyCode(
                          ),
                      e.
                        getKeyChar(
                          )) +
                    " (" +
                    e.
                      getKeyCode(
                        ) +
                    ")");
                JavaBoy.
                  keyCodes[r] =
                  e.
                    getKeyCode(
                      );
            }
        }
    }
    public void keyTyped(java.awt.event.KeyEvent e) {
        
    }
    public void windowClosed(java.awt.event.WindowEvent e) {
        
    }
    public void windowClosing(java.awt.event.WindowEvent e) {
        hide(
          );
    }
    public void windowOpened(java.awt.event.WindowEvent e) {
        
    }
    public void windowIconified(java.awt.event.WindowEvent e) {
        
    }
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        
    }
    public void windowActivated(java.awt.event.WindowEvent e) {
        
    }
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        hide(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DdlCDj8qDWzit3jX/18h/5hMLCcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457150150000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "C/7Ogev/FlfRX3TsV8QHiYNl+fGjdTkEa00Bu1xlSr0D0z51fdOWYbSvOF76" +
       "xSf/8AdeevK/lp54px0DBXSixTVKoBNjvv7yq1/9o/se/VyZrW/VtXivirO1" +
       "49Wl4amKr9Tcvac1d8+NNFeSPgQUUAaItk0uSwBZCTcMw8o+URdtvWg+uKdH" +
       "rxsW7z899UPggg+mhq9jtOH1jFbcE0nlTsfaDYGXxED9T1xH/aK2LavJZ41/" +
       "Nvryl17MP//yPpcWakwq1ettTK7eGxVL6w1sfKJk/Qb9/le+8t/l7zt/IOk9" +
       "Vyv9usgPlf6W01kpKfJ58Wh2Ru3866q91FV2DixUt9Uvty7Xit/fe23F3lLc" +
       "fidY0eJyEwRGgHJKcw/V/fDKNS4dRoMMNkUgHV1aua1DmS+WMheBf3m/kzgj" +
       "K/H/LSuw5/3HzAYB2JT86J+98Ac//uSrwHhs5bZNkWqAPU7MOEyLfdrfe/kT" +
       "j95z5cs/Wi7QYHUed//iC6VmFzdCXDTPFY12CPWRAuo4SCPDGmhxwpVrqmWW" +
       "aG+YxYXI9kDpsTnYhEDPP/iq8+k//+x+g3E2ZZ8htj525e//7eWPXzl/Ylv3" +
       "5FU7q5Nj9lu7Uuj7DjR8MhKuMUs5gvqfn3/+n//S8x/dS/Xg6U0KCfbgn/2T" +
       "v/mDy5/68u9fo8a+1Q1uwrDJxX/FIHGvc/g3kDWi0ZFh0am2d7ozVpujoMds" +
       "x71eLRj49hQRpiTeY2cp3te663aPpvP2TlTjzTxN/SQ1Fhzlqs5UJ5LuUAnh" +
       "JUPR8z6HyGtTY5qzlU2tE67ZT6aOlcG6qmionMFkM0vmbcgEPJB2s+1JScJF" +
       "nO+1BB+C5lgD8qtZ7ukjtDrS9JBGkx6p1YVVP5np6bIX97xFczWb9Rfr5mbZ" +
       "QquGXMUxwfPIepx2w77d7zsGtZHkYN2V9MDvcxLcp9dTMg/G5FiYwC6njnpr" +
       "VvSn61Un5CciK03Gs1CYsRN3Mu1HrriiOrM6QdkK3PF4bcjiTsKZky25XNG0" +
       "MkZWHGvOFvMEmbMmRYlZtbEMc48287WFcDYCjZumY0VbyqMmBDFV2d6ccOKW" +
       "NslCNbCjXZUl4riraYoH66gwHBKURuVYtRPwnri220JLrKfosssVel/OmLzN" +
       "yBO5Kor0IpX6UdoYN9UMEte7RQbw6O6KI7hEsVK3N1uGBIWup9NUWCTurEaO" +
       "do21uzVQ211PFrIx6XMDphNNRvLQZpN1z8/5oE+Tnq7mio7X50mobbGAI+tt" +
       "lQwjJWn6zdqIHVNjWZ6se7NwJxAsbmNsZ92pbRYdeD7mp72cDtYjr6NszHEu" +
       "s05/mqBONGsm7Gjk4eyUQQZUmnFrV1q1WuNs4U/Iemvs7PBRopvIgkUlFG6J" +
       "+FRcENNqkky3tUHaIuddYicp9EALOgTG1SZ9sSmSK5ZCZ4FXW43h2XbRGQ0U" +
       "VBqud84Mnipkn+jCeDBxlBk56S9ma9ZQFmtGoghikTl2N4IH5HQ5I8kp3Wvb" +
       "3EqwODuzOUU21vgIp+hmlHdTQlXCkS70V/4URTl4B6nxuJlxOOl00OVuFQR5" +
       "Pthay1RsLs3ZeKQtJWyLE8ZmtcTWcBfKeWTRkwgkXwkKLfAD4JoYxO1QEUZq" +
       "WZzznKcnW1xZx34rQ8iuqzW45nSHpVvaA+oNUsTqtwa8aVErep70zYnd7cKa" +
       "0kBiDm5atGTWrLbZ3nbbPLnqW44trrkVywtEILqSvbZFqTVaawEbdbT+jnGH" +
       "LBmxHNTaMZSBV6dkIgUzKUbWlDAdbUO34U4dbIDhgUONFiIhb/X6hKbGsQXL" +
       "iy20rYYiS9gpaXtVsmlnCwjqGisXGdOutBiu5V4Q2G6QLpuE0uU6cafJOMSi" +
       "u/OXPRiTRsQq6LVqk0ZNFFUdGzLNDeb4Rh/NxcUA7xB1Xm76rsJs+tkEFSO5" +
       "aoz76IbfOFuotqERsUOGyZSTByHsxERHQ1M2DRryorult5SwpDrIRp81mu5U" +
       "N3ND3g77kYLIC6GDJgaIcZBKzEhc6YOsmUam3UQGdTffyqyiriaEzQ6IFUtX" +
       "AS1B9xme7jdhaISPcbWes62NPfQUvStSYZfs0bNmVm+L4yDIxt15rHqWP1Lo" +
       "yaTN1kfzPBd4v71DB1rWhNJUkJLeIkW2K61q4EuSzsacMhsO8YSbRX7i1+S0" +
       "1sSs2XLaMqJkzTeRqClHq55TUxSvhbAtxHJmFIbNmLQNqX48WALldWxHUvrO" +
       "Uowb8CbmZLy9Trzeuu72uvgCCaZUXcRUmjKyQIFVI0+RyS5G5ka+EDW3ids5" +
       "0o1mbVyq0ig0XbdXPBfaA0EYKtupUA/1xhoCey/IWhrdyJAb69iwdG8W+yoz" +
       "Jik3kTIEHtq1mdYWiVSwNmN4h+3q89Yw6vCjeOVFfDvuzHRpsXDj3qiDbdvW" +
       "htcTpIqZc2IYYGiGS06NH9HeeLyMVZFN+sZywer5pusvqiSLexgN+xIW1kiM" +
       "4jS3N8I9jV3N5Tps8P5q3m5L+hzvLJfNgeiZfBR3U6FRQ1Or5UoyNESnAdFb" +
       "qySdD1seTvlq29b4XBzSnImGfQSCN3ZOIVKbHJDLcRqN5TjoMlVSIQdogDaE" +
       "Vl7VE0tFfarezyeMNW5U4fkq6buzdt7KPEOeq1jbQgcC7DZa/NBsJhpRpyGJ" +
       "QIPtZM1CbneCRPispmQh3FC5Bq1t/F7f7Ci4UrNZJmtHI0XkeNlertzmdEPO" +
       "5xvYgCx9Rjj21kMl1l52IyqyJUdmF8P2lOnNbA+m23PdzlO6j9aGkiWruD2v" +
       "KWQnx9KqScGZO6O3SY5kzRbltjMUWbWG3HAmceiGxVe8la65INKGacY0Vu1t" +
       "ApnV9lDPkK3R4IN5LmW7EIKjSNptsRoE5T3CyFpk3FYoRlgGTZM0u2h9Mjca" +
       "Tivo47XxLsjxGjVKvJlgjbtVUSfCpuAs+kpzrCV0PBViklfclA4ma2Co/rS/" +
       "XM8MyKRUU5xFY79TVQw9x/PNUNF3aW7gkIHQKRYJQ3rAN/QeCPyWDI36JNOS" +
       "trXJFJsp2dAz0KqKTyljt7R9SrKsADYdLx2IuhcNW86CayLLLIJhTN8FLWjc" +
       "gqJBgOnasD5RW4S/boF1UWS2/nwjdkfVbm3QGdDpIGqNVvP6RvddSkThcd6R" +
       "o5bRMWxRGw893qGgJIlGGFVfLuoOC4WrIBYYXMCamxnjraq9xnxFOh7TVsYN" +
       "1XZRRurPGSmqYjrdzwITXdsbcqfGklnFZC4yiGixntfhMSVp1Wy5NvC2vtBB" +
       "tot1CeY8uzper8N6FwQ20aRV3bOHtlZHAisKN/qEakhExrj9sUSuZiztCjnX" +
       "IJVVDUW4rjbYtBOw4evMtxzU0VfVRWYQKxymKTnSNVUnsDYPc+RInnNoT+ky" +
       "Bm07szqSbqdTWanziA5yganBMQPDbK6r8ybfExd8Z1RHJts5xg69kB6TqzWG" +
       "C4zYiSVSD5BJtolqeNuuriOvilYFzltguTrjplm3HeUwUV3VJjNZSbqchFJc" +
       "sgm1Je3TlDJIeGmL9HwTsxKy7WZhPuW7XW0GFgDYakPtqBophkCbjpkafo+M" +
       "IHNuaWJnqbZ4MWcUC5vJcLZD+5xQXTfrrX6DFJ0gtxSlhUu9mNkQIpJOdlDk" +
       "4zvUwhkmY+tWWmV7tQzagWo9rY/jvLkDyyU+NCw6GczFiSJB4zjMWWmggY6A" +
       "BiVbvR9ECsoPm6BahLM1tWtvggRhPA+qdvmdwWdD3dqYooJSUSOMRpGjbKG2" +
       "kEAbkPzrULxRTVdyJZYSJindxgKe3G2MRkelI4Alw5qjFqxbbY6WBhNhgLUd" +
       "VzEhYzxX8apgYBxwHQHxsEnDXaJtTINdrL7pekLXwLAumlnu3NoIG2lMTa3e" +
       "cDtDR8paTFccrwwzomUh26mmim4yGrfiruLzqk6Zg8gcLMFkzaHFNDQ1GjPr" +
       "BWlM1awLU0INT4buNNIxuk07PJ8NxLjGGSQKylG7xc77S1SVZ4rOibRqrwxB" +
       "CAi6vhEkdJchHpMPiFk8l3NQqrbYRqsmmalFKLyaudTMwNTQgQWa55Ed6cBN" +
       "c5HsNoo8MAUIxgTNbyVpdddiY3zHUY7v9D2R4i2+LUh8A9EQaAXZKk3E8tJp" +
       "xWrg5uiqMYwFvtVBA4tzO7CIL6kVbspUf4tOsNzuLKe8bsiiL7ZE06nPOg1i" +
       "UjX9cbBh2r7neHCV3uKzQcSyXRgiN2vWWuDbETPuaK0ahNd6guJzI9NViQGt" +
       "mW2ri097yDrb6uuW7XQIdzpSI7vumWq6y7BAaDPxiPK8PA45ToaRLQyBqgTh" +
       "fEz3UKyzW1P6drudOE0tIxl34uANW5BEGRnMugmHM4ojtZH5elAdMOlYg+Bh" +
       "NxCtLVhwxDjAg5k8CUMiUJIVHHUaTE3ziA7aSPGE92ioz2xr7Rq3Wll5h2Hq" +
       "7YXBYaHeZUNrQDXnfXtXxU1rGDpkAw2qlF9fphuoP9Ud1VSjzXSZeyM+YIbG" +
       "RPNWDXopuT6rcq3WBJGnfThrSapQjJv6zQVkQC0umTWtDoJtYsFhetmkzoRE" +
       "U+jhGB/Oap5EJF68mJNdSByPOizJtDsdh4kFduLtqEBe+4vNSG9a/dVuuh3M" +
       "QGoP55C/QuxJkxZrE14QiFHP7RBVM+8ENXNCJv0F2ps4k24oOzxutXxdipJN" +
       "vsREweyyPdpnO9zC0nlHXXfJ5XTCOYwrrEOUc6u11qBdVQSbzQO130t2i2G/" +
       "L8m8xrYWAyaernojzMllgXXyZJhWWxyT9aCa4Sz4McawuLkgG4OtKHRw1NoV" +
       "/MzQkxvoqNoH+quCnRpCkp6P1nCmG9vNmPLodGukVJ/U5ssB1+HzMbQ1F2sl" +
       "29TW4bouE2oCHICs9mqquGjUm56oIv3mbqyNKZ+qkpw45AVMoKdJ10d2Ctuw" +
       "mW4z0+Jqw8Fnhs7sRGoK6lJKn06WNS/DpvVJf9fo8R24pkXDGgUStSDP0DHv" +
       "Elp7aCi1XJltdHW1Wi86mTrKlDbbVZsbcxYOqmvBrG+tmTDf6I3JjFEGKbQY" +
       "jUjRU+OdkGmO25dozzdIDsHA7kIaCoga6w24vWEG+TLH2nijKiiBIrbDHOLm" +
       "DbtN641qiKr8ONpBHqSSWzBVL4SWrp/NljYjyszQNFFzN7WqHRvpWAbiCbgc" +
       "MpsMyycrSfUZinXmkJE4qpKtd6jsLJb8tufk/ZaIrlhpy4g1V26PVopg6WNF" +
       "3FCqx/VrU8sJulVs6k4TDJoMZLIldE2X6K6wdXea20ljNQNZZQmhS25AGJ1O" +
       "5wMfKF5nZN/aG6UHypdnR2fyK7dVPDC+hTcpBxMWzVNHbxTLv9srZ85xT541" +
       "HR9A3HL4ou6Roze61sbyk8t9qzzkKV5vH5I8eoZkavtmsH09qk55jHRIVbyM" +
       "evR6J/vli6jPfOTKSyb/C/Dhm9I4qdyVBOH7XMDOPSH5fYDTe67/0o0rX3Mf" +
       "n1/87kf+4hHpu5fPfQunsu86I+dZlv+Ye/n36W83/uH5yi1HpxlXfXJxetAz" +
       "p88w7o6sJI186dRJxqNHhrxQ2O0d4HIODOmcfTV87CpXOd250un2rnbmGO58" +
       "SXC+/O2fcLEoqdxiH3xlc6b/VmOpRSWzKzc40/t00fx4Url7YSXAgbpWXDqz" +
       "cezML7zea8GTLMuOf3CkjgeLzifAFR+oI35j1HHumMAoCX7xBhB/qWh+Nqlc" +
       "0Ezz8KOC4guMops9xvlzN4GzIK08Ca4PHeD80BuK8zBQH7464sniphz7qzdQ" +
       "wa8XzWeBlR1rJ0RWHFvmNV1mE9jmsUY+d7MauQSuDx9o5MNvuOX/SUnwOzeA" +
       "/YWi+e2kcg+ALVqupQHcRddvHmP8FzeLsfDuHznA+CNvEsZ/ewOMXyqaf7M/" +
       "RSuy0lmAX7xZgN8Jrh87APhjb4pbn13I9qvUsWf/pxvAf7Vo/iSp3LstBxFu" +
       "cLWN/93NquBpcL1woIIX3nAb/+eS4Cs3APnVovmzpHLfMciDc7kTKP/HG2Ho" +
       "Kwcor7xJKL9xA5R/VTRfPzIlH4Lq46wpX7tZkFVwffIA5CffHJDnzl0f5Lmy" +
       "sPxrsBjtQfaMwC/PJM/g/JubxVkUkD99gPOn3ySc990A54WiuRMUzHucXcu+" +
       "NtJzd70RFn3xAOmLbxLSd9wA6bcVzVuPLFoUz5vi85IzOB96Iyz6Mwc4f+ZN" +
       "wvnUDXB+R9E8fsKi2nWQPvFGWPTnD5D+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/BuK9Horzn7Hc7TinINvoAe0aN5blJPlIMGKiu8nr9LC+74VLWRXffUahoey" +
       "3n8kKwW2Ola2B/H2k/orU8aDrzfh0ZCTX0kWu7DyG/zDHVMqHHxo8/mX2OGH" +
       "Xmv+wv4rTcPV8rzgcuegcsf+g9GSabHreuK63A553c48/c37f+Wupw53iPfv" +
       "BT625QnZ3nXtTyJJL0zK/W3+mw//0+/6Ry/9aflxyP8Da/PjDhwxAAA=");
}
