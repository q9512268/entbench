package org.apache.batik.svggen.font.table;
public class GlyfSimpleDescript extends org.apache.batik.svggen.font.table.GlyfDescript {
    private int[] endPtsOfContours;
    private byte[] flags;
    private short[] xCoordinates;
    private short[] yCoordinates;
    private int count;
    public GlyfSimpleDescript(org.apache.batik.svggen.font.table.GlyfTable parentTable,
                              short numberOfContours,
                              java.io.ByteArrayInputStream bais) {
        super(
          parentTable,
          numberOfContours,
          bais);
        endPtsOfContours =
          (new int[numberOfContours]);
        for (int i =
               0;
             i <
               numberOfContours;
             i++) {
            endPtsOfContours[i] =
              bais.
                read(
                  ) <<
                8 |
                bais.
                read(
                  );
        }
        count =
          endPtsOfContours[numberOfContours -
                             1] +
            1;
        flags =
          (new byte[count]);
        xCoordinates =
          (new short[count]);
        yCoordinates =
          (new short[count]);
        int instructionCount =
          bais.
          read(
            ) <<
          8 |
          bais.
          read(
            );
        readInstructions(
          bais,
          instructionCount);
        readFlags(
          count,
          bais);
        readCoords(
          count,
          bais);
    }
    public int getEndPtOfContours(int i) { return endPtsOfContours[i];
    }
    public byte getFlags(int i) { return flags[i]; }
    public short getXCoordinate(int i) { return xCoordinates[i]; }
    public short getYCoordinate(int i) { return yCoordinates[i]; }
    public boolean isComposite() { return false; }
    public int getPointCount() { return count; }
    public int getContourCount() { return getNumberOfContours(); }
    private void readCoords(int count, java.io.ByteArrayInputStream bais) {
        short x =
          0;
        short y =
          0;
        for (int i =
               0;
             i <
               count;
             i++) {
            if ((flags[i] &
                   xDual) !=
                  0) {
                if ((flags[i] &
                       xShortVector) !=
                      0) {
                    x +=
                      (short)
                        bais.
                        read(
                          );
                }
            }
            else {
                if ((flags[i] &
                       xShortVector) !=
                      0) {
                    x +=
                      (short)
                        -((short)
                            bais.
                            read(
                              ));
                }
                else {
                    x +=
                      (short)
                        (bais.
                           read(
                             ) <<
                           8 |
                           bais.
                           read(
                             ));
                }
            }
            xCoordinates[i] =
              x;
        }
        for (int i =
               0;
             i <
               count;
             i++) {
            if ((flags[i] &
                   yDual) !=
                  0) {
                if ((flags[i] &
                       yShortVector) !=
                      0) {
                    y +=
                      (short)
                        bais.
                        read(
                          );
                }
            }
            else {
                if ((flags[i] &
                       yShortVector) !=
                      0) {
                    y +=
                      (short)
                        -((short)
                            bais.
                            read(
                              ));
                }
                else {
                    y +=
                      (short)
                        (bais.
                           read(
                             ) <<
                           8 |
                           bais.
                           read(
                             ));
                }
            }
            yCoordinates[i] =
              y;
        }
    }
    private void readFlags(int flagCount, java.io.ByteArrayInputStream bais) {
        try {
            for (int index =
                   0;
                 index <
                   flagCount;
                 index++) {
                flags[index] =
                  (byte)
                    bais.
                    read(
                      );
                if ((flags[index] &
                       repeat) !=
                      0) {
                    int repeats =
                      bais.
                      read(
                        );
                    for (int i =
                           1;
                         i <=
                           repeats;
                         i++) {
                        flags[index +
                                i] =
                          flags[index];
                    }
                    index +=
                      repeats;
                }
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e) {
            java.lang.System.
              out.
              println(
                "error: array index out of bounds");
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVae3QU1Rm/uwlJCIE8kIBAwiPBUxB2S5VaDFghJBLckEiQ" +
                                                              "1qAmk9m7m5HZmWHmbrLBUoRThXpOOR7BR1vhD4vWelCsLcc+lNKXj2PVI/W0" +
                                                              "KtbnH2rRHjm2YrWt/b57Z3ZmZ3cnRjiac+buZO797v0ev+9x78zBd8k4yyRz" +
                                                              "DUmLSxE2YlAr0o333ZJp0XirKlnWenjaJ9/42p5tp/48fnuYlPWSSYOS1SlL" +
                                                              "Fm1XqBq3ekmDollM0mRqraU0jhTdJrWoOSQxRdd6yRTF6kgZqiIrrFOPUxyw" +
                                                              "QTJjpFZizFQG0ox22BMwMivGuYlybqIr/ANaYqRK1o0Rl2B6DkGrpw/Hptz1" +
                                                              "LEZqYtdIQ1I0zRQ1GlMs1pIxybmGro4kVZ1FaIZFrlGX2IpYE1uSp4a5D1R/" +
                                                              "8PFNgzVcDZMlTdMZF9FaRy1dHaLxGKl2n7apNGVtJt8mJTEywTOYkeaYs2gU" +
                                                              "Fo3Coo687ijgfiLV0qlWnYvDnJnKDBkZYmRO7iSGZEope5puzjPMUMFs2Tkx" +
                                                              "SDs7K61jbp+It5wb3Xvb1TUPlpDqXlKtaD3IjgxMMFikFxRKUwPUtFbE4zTe" +
                                                              "S2o1MHgPNRVJVbbY1q6zlKQmsTRAwFELPkwb1ORruroCS4JsZlpmupkVL8FB" +
                                                              "Zf83LqFKSZC13pVVSNiOz0HASgUYMxMSYM8mKd2kaHGOo1yKrIzNl8IAIC1P" +
                                                              "UTaoZ5cq1SR4QOoERFRJS0Z7AHxaEoaO0wGCJsdakUlR14Ykb5KStI+Raf5x" +
                                                              "3aILRo3nikASRqb4h/GZwErTfVby2Ofdtct2X6ut1sIkBDzHqawi/xOAqNFH" +
                                                              "tI4mqEnBDwRh1YLYrVL9I7vChMDgKb7BYsxD3zp58cLGo4+LMTMKjOkauIbK" +
                                                              "rE8+MDDp2Zmt85eWIBsVhm4paPwcybmXdds9LRkDIk19dkbsjDidR9c9esV1" +
                                                              "99ITYVLZQcpkXU2nAEe1sp4yFJWal1CNmhKj8Q4ynmrxVt7fQcrhPqZoVDzt" +
                                                              "SiQsyjpIqcoflen8f1BRAqZAFVXCvaIldOfekNggv88YhJByuEgVXDOI+OO/" +
                                                              "jAxFB/UUjUqypCmaHu02dZQfDcpjDrXgPg69hh4dAPxvWrQ4ckHU0tMmADKq" +
                                                              "m8moBKgYpKIzag0lk1SLJkBTUSYNqDR6iTqS6FEgONJV1JJNxYAQBPgzvrCV" +
                                                              "M6iTycOhEJhrpj9YqOBnq3U1Ts0+eW96ZdvJ+/ueFEBE57G1ycgSWD4ilo/w" +
                                                              "5SNi+QguH+HLR/KXJ6EQX/UsZEMABMy7CQIFROqq+T1XrenfNbcEkGkMl4Jt" +
                                                              "cOg5eZmr1Y0oThrokw8+u+7UM09V3hsmYQg6A5C53PTRnJM+RPYzdZnGIX4V" +
                                                              "SyROMI0WTx0F+SBHbx/evmHblzkf3oyAE46DYIbk3RjHs0s0+yNBoXmrd771" +
                                                              "waFbt+puTMhJMU5mzKPEUDPXb2O/8H3ygtnS4b5HtjaHSSnEL4jZTAIfg3DY" +
                                                              "6F8jJ+S0OOEbZakAgRO6mZJU7HJibiUbNPVh9wkHXy2/PwtMPAF9sAGuJtsp" +
                                                              "+S/21hvYThVgRcz4pODpYXmPse/5p98+j6vbySTVnhKgh7IWT/TCyep4nKp1" +
                                                              "IbjepBTG/e327j23vLtzI8cfjGgqtGAztq0QtcCEoObrH9/8wisvH3gu7GKW" +
                                                              "QfpOD0AllMkKic9JZYCQiHOXH4h+KsQBRE3z5RqgUkko6FDoJP+pnrf48Du7" +
                                                              "awQOVHjiwGjh6BO4z89eSa578upTjXyakIzZ19WZO0yE9MnuzCtMUxpBPjLb" +
                                                              "jzV8/zFpHyQHCMiWsoXyGFvCdVDCJZ/GyMJPGSXW452FruBxdqwje9IDFus2" +
                                                              "lRRYb8jOcofqT23+Q/mWVU4GK0QiRl5qdT7zq9Vv9nF0VGBQwOfI20SPu68w" +
                                                              "kx5o1girfQJ/Ibj+hxdaCx+IfFHXaiet2dmsZRgZ4H5+QJmZK0J0a90rm+54" +
                                                              "6z4hgj+r+wbTXXtv/CSye68wuSh9mvKqDy+NKH+EONhciNzNCVqFU7S/eWjr" +
                                                              "r+/ZulNwVZebyNugTr3vL//9U+T2V58okA/GWYO6KQrY89ALsvG73m8fIVTZ" +
                                                              "4n3/3nbD810QcDpIRVpTNqdpR9w7K1RvVnrAYzC3rOIPvOKhcSC5LEA72NCb" +
                                                              "yUGr6JGVI4xy2HZoRppBvUelFKc9nw+NZnkmnGfC+y7FptnyBudcm3qq+D75" +
                                                              "pufem7jhvSMnuV5ytwHeWNQpGcIotdjMQ6NM9SfC1ZI1COPOP7r2yhr16Mcw" +
                                                              "Yy/MKEPCt7pMSMqZnMhljx5X/uJvf1/f/2wJCbeTSlWX4u0STwJkPERfCqZR" +
                                                              "4xnj6xeL4DNcAU0NF5XkCY/+PqtwJGlLGYz7/pZfTP35sh/vf5kHPaHwGZwc" +
                                                              "d5qz8/I130K6qead4z984zenflQuUBbgMz66aR91qQM7Xv8wT8k8sxZwIx99" +
                                                              "b/TgHdNbLzrB6d0Uh9RNmfxCCIoAl/Yr96b+FZ5b9scwKe8lNbK9XdsgqWlM" +
                                                              "HL2wRbGcPRxs6XL6c7cborZuyabwmX4/9izrT65e1yhlOW7g5tMqJ7002Kmm" +
                                                              "wZ9PQ4TfXMlJzuHtfGwWOumr3DAV2NZTX/6aEDApbLuhPu9mVlcCt5FQoVp+" +
                                                              "KGRDM/dFEQR+Ofntnz3RX/6CgELh4O/b4rx+7ZN36i+dCIdtR/1alslJyFMt" +
                                                              "XDbMxS8jyhktsnEbLg2zaJLqKZiCDcaolmSDTkX/+S2G0WNecefxaHn/3U1P" +
                                                              "b9vf9BqPJRWKBRCDlFdgC+qhee/gKyeOTWy4n9eDpZg57SCcu3fP35rn7Li5" +
                                                              "haqxSQgwXWBnI/xZ5rm/mJESRctLH/hveyYvqeD/G8SsNpjNwmAO4+0iSE4J" +
                                                              "RZNUzs2FUJ6pXIv4XwqbTYa7RFjQOUlEVD7oubA/1zXKyxS77ywnwWTPRqAz" +
                                                              "n1lMvP6I2Ml15IaXC46dKjl+87Sq/M0LztZYZGuyoLj1/Qs8tuPv09dfNNg/" +
                                                              "hl3JLB84/FP+pPPgE5ecI98c5gcrIprlHcjkErXkxrBKk7K0qeUm9LnCrtwu" +
                                                              "wqjYLOCmC8jX3wnouwGb7YACGU0oLB4w/LscUes9uTEHjWI7gm0Mm6uExbuK" +
                                                              "JtcNuaH5bLga7QDVWCQ0f88VvC8/BhejZna24BRylm4mDpsN7D8syMQvI5vP" +
                                                              "aKQaMJV4kkZXAnR7+E5f0ZJt2pBi6lqKatkDj89/UWEeBZs9o8ag0gGoFcca" +
                                                              "hPY4ZtsXFISwSYsIhM1QNvrcmh998F8+dEvhZbeKZTk1NjsC0HwgoO9ubO7E" +
                                                              "ZqfgJGDsPWPyit1j9Io5cM2ycT2riFccDPSKYtSMVGVadd2MQwYA2/qcg9cM" +
                                                              "k+FqtsmbhXMMn1GcwiSp6BAWg3j6r6QkvvEVuRzraV4nOi7yRS3tcZQHuTmX" +
                                                              "Fof8g45NHvpMkD/8GSEv+Do8GuSPBPQdxebhLOQPB0H+d2OC/H2fAfKzbdTN" +
                                                              "LgL5RwMhX4waID/igTw++6mP2cfGyGy9zbDDeCFmnwpkthg1pmU9rfFTLNXH" +
                                                              "5dMBXGY8xUF2Nf5XRnwn/J7VPHtVggV0Q7GXMPw85MCOvfvjXXctdvYaKxjs" +
                                                              "p3VjkUqHqOqZaryAaJaNakfQpTYbS/0qcwX1SZA9KSxG6sOrB5Givn01ANCv" +
                                                              "Y3McNqRJytpwu+bu1vgEruZfGg0fOUcG3E18OuCDp8G13BZk+dh1UIx0NB28" +
                                                              "E6CDf2DzJiMVoIN2Z3N9myv5W6ctOW5BeRpaYbO/YuySFyMdTfIPAyT/CJv3" +
                                                              "GZkEkn/TjQ/4dKkr/z/PnPxtthBtY5e/GOko8odKi8sfKsOHnwj5rygmf4ic" +
                                                              "tvxYTvDivMMWomPs8hcjDRCvJqCvDpsJjEzAY6oUfxdCR6uFywd0XaWSFlAO" +
                                                              "c4VVnbbCeLjEbUqnLXXn2BVWjDRAKXMC+pqwmcnIRMBKt65orDWbo1zJG86M" +
                                                              "5AiVy2z2Lxu75MVIA6RbFNAXxeZLjFSD5HZyKCT7/NOWndcVGN/6bQH6R5G9" +
                                                              "QFFRjNQnn6fG5CXGai7p0gAttGBzPsMjCinOY4VVyEdKh3Ql7iplyZlRyiq4" +
                                                              "rrclu37sSilG+qmUsjpAKWuwaYUaCJXi5M7Qclf+VWOXPwPVSP5nAvgSYlre" +
                                                              "V0ziyxv5/v3VFVP3X/5XcTTpfB1TFSMVibSqes/IPfdlhkkTCtdelTgxN7hM" +
                                                              "lzEyd/R3lFCkMufoL9QtKNczMjOIEtCBP16SbzAytQgJI2Xixju+l5Ea/3hg" +
                                                              "hf96x10FQHXHwVTixjukn5ESGIK3ktjzTGMk+infzjpmyYRy62fH8GTKaIb3" +
                                                              "lNxNOaeW/Is254QxLb5p65MP7V+z9tqTX71LvNWXVWnLFpxlQoyUiw8M+KR4" +
                                                              "Sjmn6GzOXGWr53886YHx85wivlYw7PrRDE+NtB4SnIHom+575W01Z998v3Bg" +
                                                              "2ZGndpUdC5PQRhKSGJm8Mf8FT8ZIm2TWxlihl58bJJO/jW+pfKP/mQ9fDNXx" +
                                                              "92hEHBY3BlH0yXuOHO9OGMYPwmR8BxkHexSa4W+fVo1o66g8ZOa8Sy0bgMid" +
                                                              "PaufhK4i4dduXDO2Qidmn+JXIeAN+S+W87+UqVT1YWquxNlxmom+c920YXh7" +
                                                              "uWbbRORETQMU+2KdhmG/US9/n2veMDAihHiiaf8/qg1rg7YqAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Dkrq6JBDRcKpc8vMNtc2gsrjMdhLLau+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("PqEhZ97R+zMh69TXg1Fv1ejZo1ouJNSI6lA4uaJTh0F7mTXSMlZqLqs678Fe" +
       "q2WgIiWhbF4DwYSp0lKirydNs6mqCdir1eem6rjVsUBo3VmVrS7RdnUR8By8" +
       "WgZJNrMzB1CudOq1lbBuJ0tZZihmwM3JRbU+UdcODi3YDuTWtxrZ75rrkWlK" +
       "OgoFBhwa7VXQ7XY/VBwl/YvXd8R1X3mad3SFdGO3i4qvvo5TrOzE27mjU8/y" +
       "c7Fy6trhiVPPExcgKsUVjUdudTO0vLDyhY+/8JJK/RJ8/uCsuBNXLsee/wFb" +
       "22r2iaEu70+vj8i4cnjg2jkgo3P68PUY6M1PXn9oz6hT59bnjhusygZfP+Ng" +
       "+0+K5N/FlfsNLR4UlwiO7xCUAxyz+d+/2mHhyaFPQS2bPQieDx1A/dBbBPXP" +
       "zoD6X4vkT+PKJQB1eHhp42PHAL/xBgCWalW8jOoeAOy+RQD/4gyAf1kk/y2u" +
       "3AsACscvCYpS5Bjmf38zYA4OYA7eGpjnbrs1zHMXi8Lv7WGubgXzXOUNwHxb" +
       "UVi8EycOYBJvDsyTKK6eUXd/kdwVV+4q7iw55UVN7WZn+nfInmdrknuM+u43" +
       "gLr0R8V7e/IANfnmo37sjLrCS597KK7cA+RKe6YbY0evk44BvuuNAizEOj8A" +
       "OH/zAVbPqPtAkbwnrlwBAA+c7M0g/uAbgFi+0Ct8z3MHEJ97vRDnN4V44tVs" +
       "+W7vgyWg9hlgO0VSj4v7M5JaWml009dSW89Uj7E33ij2Png+cYD9E28l9uEZ" +
       "2IvXZue6IAwosB8uNeeeOYbZez0wM7A633hxv7iF/OAN/yva/xdG+dJLVy69" +
       "86XFv9rf0Dv8v8rlaeWSntj2yUuKJ/IX/VDTzZIFl/dXFv0SDRVXnnz1S8tx" +
       "5fb48ILYudm+JxNXHj6rJxB/8XWyyyKuvPMWXYo3vmXmZHshrlw93R6QUn6f" +
       "bPejQBOP24Gh9pmTTT4SVy6AJkX22f1dgHfEFeg1Xtc+FEt27vrg8VDklftf" +
       "TeQn4s2nrrszV/7H7PB+W7L/l9mzypdfGs8++p3WL+2v+Su2tNsVo1yaVu7Y" +
       "/+OgHLS4I/fELUc7HOvi6L3fvfcrl999GMHeuyf42FxO0PbYze/UDxw/Lm/B" +
       "7/7RO//hB//uS39cvt7+v5yABBz8NwAA");
}
