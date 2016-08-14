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
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaC3AV1Rk+9wbyJA8CBAyERxKkgOaKbxu0hpBI8AJXQtNp" +
       "QMJm70myZO/uuntuchMKKjMt0FaG0ijWEcYZUXygOFanWh+l44harTOirbWO" +
       "YqttsdYq42g7xdb+/9ndu49792bujMnMnmzOnv/f83/n+x/nbI5+TCYbOplL" +
       "FdbERjRqNLUpLCboBo23yoJhbIC+HvFAgfDZ5tNrrwiTwm5SMSAYa0TBoO0S" +
       "leNGN6mTFIMJikiNtZTGUSKmU4PqQwKTVKWbzJCMjoQmS6LE1qhxigO6BD1K" +
       "pgqM6VJvktEOSwEjdVGYSYTPJNLif9wcJVNEVRtxhs9yDW91PcGRCeddBiNV" +
       "0a3CkBBJMkmORCWDNad0slRT5ZF+WWVNNMWatsqXWBCsjl6SAUH9I5VfnN03" +
       "UMUhmCYoisq4ecZ6aqjyEI1HSaXT2ybThHED2UEKoqTMNZiRxqj90gi8NAIv" +
       "ta11RsHsy6mSTLSq3BxmayrURJwQIwu8SjRBFxKWmhifM2goZpbtXBisnZ+2" +
       "1rQyw8Rbl0bGDmyuerSAVHaTSknpxOmIMAkGL+kGQGmil+pGSzxO491kqgKL" +
       "3Ul1SZClUWulqw2pXxFYEpbfhgU7kxrV+TsdrGAdwTY9KTJVT5vXxwll/TW5" +
       "Txb6wdYax1bTwnbsBwNLJZiY3icA7yyRSYOSEmdknl8ibWPjtTAARIsSlA2o" +
       "6VdNUgToINUmRWRB6Y90AvWUfhg6WQUC6ozUBipFrDVBHBT6aQ8y0jcuZj6C" +
       "USUcCBRhZIZ/GNcEq1TrWyXX+ny8dvnebcoqJUxCMOc4FWWcfxkIzfUJrad9" +
       "VKfgB6bglCXR24SaZ3aHCYHBM3yDzTG/+N6Zq8+be/xFc8zsLGPW9W6lIusR" +
       "D/dWvDandfEVBTiNYk01JFx8j+Xcy2LWk+aUBhGmJq0RHzbZD4+vP/Hdmx6g" +
       "H4VJaQcpFFU5mQAeTRXVhCbJVL+GKlQXGI13kBKqxFv58w5SBPdRSaFm77q+" +
       "PoOyDjJJ5l2FKv8bIOoDFQhRKdxLSp9q32sCG+D3KY0QUgQX2QLX+cT84b8Z" +
       "WRUZUBM0IoiCIilqJKaraL8RgYjTC9gORDSpx7xB2vSqIxFDFyMraR/MAp1G" +
       "V2WjCR9pX6OuFM572nAoBJDO8Tu0DL6wSpXjVO8Rx5Ir2s483POySRYkuGUx" +
       "IxVevSQU4uqmo35zdQDbQfBSCJNTFndev3rL7voCoIU2PAmAwaH1nnTR6riy" +
       "HX97xGPV5aML3l32XJhMipJqQWRJQcbo36L3Q1wRBy3Xm9ILicSJ5/Nd8RwT" +
       "ka6KNA7hJCiuW1qK1SGqYz8j010a7GyDfhUJjvVZ50+O3z58c9eNF4RJ2BvC" +
       "8ZWTIfqgeAwDbzrANvpdN5veyl2nvzh223bVcWJPTrBTWYYk2lDvX3A/PD3i" +
       "kvnC4z3PbG/ksJdAkGUCLDXEr7n+d3hiRLMdb9GWYjC4T9UTgoyPbIxL2YCu" +
       "Djs9nIlT+f10oEUJOs1MuC6yvIj/xqc1GrYzTeYiz3xW8Hh+Zad28A+vfngR" +
       "h9sO/ZWunN1JWbMr3KCyah5Ypjq03aBTCuPeuT3201s/3rWRcxZGNGR7YSO2" +
       "rRBmYAkB5u+/eMNbp949/EbY4TmDfJvshbIllTYyjDYV5zAS3nauMx8IVzK4" +
       "ObKm8dsK8FPqk4RemaJjfVm5cNnj/9hbZfJAhh6bRueNr8DpP2cFuenlzf+a" +
       "y9WEREyXDmbOMDMGT3M0t+i6MILzSN18su5nLwgHIZpDBDWkUcqDIuEYEL5o" +
       "l3D7L+Dtxb5nl2Gz0HCT3+tfrrKmR9z3xqflXZ8+e4bP1lsXudd6jaA1m/TC" +
       "5twUqJ/pD06rBGMAxl18fO2mKvn4WdDYDRpFKAaMdTpEwJSHGdboyUV//PVz" +
       "NVteKyDhdlIqq0K8XeBORkqA3dQYgOCZ0r51tbm4w7jSVdxUkmF8RgcCPC/7" +
       "0rUlNMbBHn1i5mPLjxx6l7NMM3XM5vJhjOeeqMqra8exH3j9st8d+cltw2Z+" +
       "XhwczXxys/6zTu7d+ed/Z0DO41iW2sEn3x05emdt61UfcXknoKB0YyozB0FQ" +
       "dmQvfCDxebi+8PkwKeomVaJVzXYJchLdtBsqOMMucaHi9Tz3VmNm6dGcDphz" +
       "/MHM9Vp/KHNyH9zjaLwv90Uv7tgR67LvPdErRPhNBxdZxNsl2Jzv5kNaVTiH" +
       "KsZN5anX3EF5tl+YszqTvQbjHmrWZpvKTvzKuPuvj5prX59lsK/gu+9Isfh2" +
       "4sQHpsA5WQTMcTPui9zS9ebWV3jULcZUvMEGyJVoIWW7Qn6V19KyXKCBaQuD" +
       "meqy8NC9Da/eeKjhT9yNiyUD1hPemqUcdsl8evTURyfL6x7mqW4STt6auHcf" +
       "kblN8FT/3KZKbDrNNZwF1ONuLAyzpg0wab5ImqY5MSCULoSme6E1J7ZyT+XT" +
       "+6oL2mFiHaQ4qUg3JGlH3MvEIiPZ68La2Ro47LSA/gp+QnD9Dy8EGDvMCrW6" +
       "1SqT56frZIgq+JyR0BK4NVMutpdjs9q0sDkwwLV613YGXMustV0W4BCC6RDY" +
       "RDN9IEiakeJBOrIW8DAAxbpsjBaG+dYH2L+oqqbxis/qTTJncxXXHmnvU7/s" +
       "7l5UJYat/BTLZGugRZhmPCHYmcODg3LLJ5ffe6U5hwUBnHbGP3nde68dHD12" +
       "1MzuyE1Glgbt/DOPG7DYy+E4Lns/v+abxz98v+t6294KbKQ0k6d5UyDD4gEf" +
       "qX4u458b/XzpzcGXlLPuS9MY859C4ttKuesjJ+MV2HOsTXsbHUL4r6U8VyKj" +
       "7SF1viHfgW28OjzeqBaefu1RuLx1QZtrfjBweOfYofi6e5aZi1zt3bC2KcnE" +
       "Q7//7ytNt7/3UpY9VQlTtfNleK/sMrHcy21g1BoeeZwM+U7F/vefbOxfkc8u" +
       "CfvmjrMPwr/ngRFLgknkn8oLO/9eu+GqgS15bHjm+eD0q7x/zdGXrjlX3B/m" +
       "hyxm6s44nPEKNXvDZKlOWVJXvIGxIc23SqTXOXANWnwb9Pu0w2gfVUM4siiH" +
       "qK/oDafLtGz5N6ZLCdiXDFkZ4MLYFnF3Y+wD2yuvw2YTMjBH4ebTEdlefWrw" +
       "ztMPWWEvY+vnGUx3j/3wq6a9YyYzzWOwhoyTKLeMeRRmJpr07BbkeguXaP/b" +
       "se1P3bd9l23ZDkYKJOuEMiOc8N4fW9rx117X/X5GJokDFnczRLnyH+XYeNyJ" +
       "zQ8YKe2nDCLGSmqIdhyo4nEAC8cm8xjPiWi7xsuAuUt87GjReP/ONJOq8dkC" +
       "uAyLSUb+JAwS9QHggugQ13p/DoQexOYw7KyEeNw+68FDsxxVjgPUPRMAFKog" +
       "DXBts6zdlj9QQaLZgbJNnZmZYtrwhr/wiRwYPo3Nz4FlUK3gRw1I0lmJPKRK" +
       "LvAemyjwGuHaYSGwI3/wgkSDWfYk1/qbHAi9gs3zjJQBQuupTCFRxbHrWQeO" +
       "ExMFBzrdHsumPfnDESQ6Hhxv5oDjLWxOmuUtBk0/Fq9PFBbfgOsWy6Bb8sci" +
       "SDS3X/lLN7Muc1zrgxxIncbmFCNThrlQq6xmMue9iUJrMVz7LJP35Y9WkGgw" +
       "c/7CtX6WA4/PsfknI+UOHpC6fIB8MpH0GbOsGssfkCDRcQAJkWBAQmHsPJsm" +
       "yDoNqng/Qb6cKDyWwnXAMupA/ngEiY6HR3kOPPCQIlQM+dzEo0NUFalP8kMS" +
       "KpkoSHAvd4dl1x35QxIkOh4ktTkgmYPNDEammpCspFIAKDUTyZODlmUH8wcl" +
       "SHQ8UBblAGUxNvVpnuAueAiPhnyQNEwkT+6y7Lorf0iCRMeD5OIckFyKTcTF" +
       "EyEAlAsmkid3W5bdnT8oQaL5pWfzQCSdnkMtOSBrw2Y57h64UIzq+EkwA7Ar" +
       "vw7AUhnfpDXNtqEibUO7LiRoyjRutlsjzwQzxptIWsT9QRA34fy/Z+wNfTJm" +
       "neAdO7R67bYzl95jfpAUZWF0FLWURUmR+W2UKy3IOA10a7N1Fa5afLbikZKF" +
       "9qZ5qjlhZ9lnu+qAFlhADT8m1fq+1hmN6Y92bx1e/uxvdxeehO3+RhISGJm2" +
       "MfNrSUpL6qRuYzTziLpL0PlnxObFd4xcdV7fJ2/z71HEPNKeEzy+R3zjyPWv" +
       "7591eG6YlHWQyeBMNMU/46wcUdZTcUjvJuWS0ZbiR25MEmTP+XcFngAJuCHn" +
       "uFhwlqd78XM2I/WZxxaZ/wRQKqvDVF+hJhVOyPIoKXN6zJXxHSQlNc0n4PRY" +
       "S4ltNzabUrgajBT0RNdomn3eTi7VOF83ZotB/Ow0tJnf4l3P/wHvw7ltWScA" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rP4S/J0D1/8trqK/6NjPlg9jB1P2k0dztg/mmgJ2OcuUegemfebGpi3DaF+N" +
       "vPwLT//+D7/89H8pPfFuKwIKQMLldcqjE2O+8cprX/uDBx7/fJmtb1eVaK+K" +
       "s3XltWXjqWqw1Nz9pzV33800V5I+AhRQBoiSxpdFgKyE6/t+ZZ+oi7ZRNB/a" +
       "07duGBbfc/rVj4CrfvDq+g2MxtzIaMU9Flfu3hg5A7wkAup/6gbq55W0rDSv" +
       "aP908uUvvbT7wiv7XFqoMa5Ub7RouXbdVEytN7HxiXL2m8PvefWr/236g+cP" +
       "JL3vWqXfEPmh0t92OivFRT4vHs3OqJ19Q7WXusrOgYnqjsblzuVa8fsHrq/Y" +
       "24rb7wYzWlQukMAIUE4p9qG6H13b2qXDaJiCBRNIR5fWdudQ5oulzEXgX96v" +
       "Ms7Iiv1/ywrs+eAxM8oDC5af+MqLv/dTT78GjEdU7tgWqQbY48QbmaRYw/21" +
       "Vz75+H1Xv/wT5QQNZmdh9Hf8f1NwXd4McdE8XzTKIdTHCqiCl4SaQSlRTJdz" +
       "qqGXaG+axbnQckDpsT1YoEAvPPza5jN/8rn94uNsyj5DbHz86l//y8ufuHr+" +
       "xJLv6WtWXSfH7Jd9pdAPHGj4ZCRc5y3liMH/+MIL/+wXX/jYXqqHTy9g+mB9" +
       "/rk/+ovfu/zpL//udWrs223vTRg2vviVUTMaI4d/1FTBYGRa5zfVXqrmBNLF" +
       "UCTv8xm5WbIKqWZJbeWj4y5CzCYx409owunUnHzBQknixom2oklyTce1gTKs" +
       "WWu5r80X0ixfsgPFlVdVu9lcKaHIWqEqs/MgjiN9HjQby06mq1Wo5+pJs9fp" +
       "NdRkTbu06+xYdwuZXRhyqxnkquNWVcTmKuvb1EBX+/yaDxhK8ilM9VCvAece" +
       "sVLHWHW0HSBLE1+0YiYMU0tMnZZAC8hcqYmox9YE22CGTNsRB2OasDYWEy/E" +
       "oSSQjtTkgklKilNSVncERq+9iSO0qX49WGXWkm2jeJ30lwHdnhLbTdxnhbS/" +
       "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" +
       "bxHSd90E6XcUzduPLFoUz9vi85MzOB+5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FRb92QOcP/sW4XzmJji/q2iePGFR5QZIn7oVFv25A6Q/d0uR3mjG2a94jmac" +
       "c/Wb6KFVNO8vyslyEGeExfeV12jhA9+OFrJrvor1/UNZHzySdQCWOka2B/HO" +
       "k/orU8bDb/TCoyEnv6IsVmHl9/uHK6aEO/gQ5wsvE8yHX2///P4rTs1WdruC" +
       "y91U5a79B6Ul02LV9dQNuR3yunP07Lce/OV7njlcIT64F/jYlidke8/1P5ns" +
       "O35crm93v/boP/rev//yH5cfj/w/nRpdsFgxAAA=");
}
