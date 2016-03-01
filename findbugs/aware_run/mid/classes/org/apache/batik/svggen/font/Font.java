package org.apache.batik.svggen.font;
public class Font {
    private java.lang.String path;
    private org.apache.batik.svggen.font.table.TableDirectory tableDirectory =
      null;
    private org.apache.batik.svggen.font.table.Table[] tables;
    private org.apache.batik.svggen.font.table.Os2Table os2;
    private org.apache.batik.svggen.font.table.CmapTable cmap;
    private org.apache.batik.svggen.font.table.GlyfTable glyf;
    private org.apache.batik.svggen.font.table.HeadTable head;
    private org.apache.batik.svggen.font.table.HheaTable hhea;
    private org.apache.batik.svggen.font.table.HmtxTable hmtx;
    private org.apache.batik.svggen.font.table.LocaTable loca;
    private org.apache.batik.svggen.font.table.MaxpTable maxp;
    private org.apache.batik.svggen.font.table.NameTable name;
    private org.apache.batik.svggen.font.table.PostTable post;
    public Font() { super(); }
    public org.apache.batik.svggen.font.table.Table getTable(int tableType) {
        for (int i =
               0;
             i <
               tables.
                 length;
             i++) {
            if (tables[i] !=
                  null &&
                  tables[i].
                  getType(
                    ) ==
                  tableType) {
                return tables[i];
            }
        }
        return null;
    }
    public org.apache.batik.svggen.font.table.Os2Table getOS2Table() { return os2;
    }
    public org.apache.batik.svggen.font.table.CmapTable getCmapTable() {
        return cmap;
    }
    public org.apache.batik.svggen.font.table.HeadTable getHeadTable() {
        return head;
    }
    public org.apache.batik.svggen.font.table.HheaTable getHheaTable() {
        return hhea;
    }
    public org.apache.batik.svggen.font.table.HmtxTable getHmtxTable() {
        return hmtx;
    }
    public org.apache.batik.svggen.font.table.LocaTable getLocaTable() {
        return loca;
    }
    public org.apache.batik.svggen.font.table.MaxpTable getMaxpTable() {
        return maxp;
    }
    public org.apache.batik.svggen.font.table.NameTable getNameTable() {
        return name;
    }
    public org.apache.batik.svggen.font.table.PostTable getPostTable() {
        return post;
    }
    public int getAscent() { return hhea.getAscender(); }
    public int getDescent() { return hhea.getDescender(); }
    public int getNumGlyphs() { return maxp.getNumGlyphs(); }
    public org.apache.batik.svggen.font.Glyph getGlyph(int i) { return glyf.
                                                                  getDescription(
                                                                    i) !=
                                                                  null
                                                                  ? new org.apache.batik.svggen.font.Glyph(
                                                                  glyf.
                                                                    getDescription(
                                                                      i),
                                                                  hmtx.
                                                                    getLeftSideBearing(
                                                                      i),
                                                                  hmtx.
                                                                    getAdvanceWidth(
                                                                      i))
                                                                  : null;
    }
    public java.lang.String getPath() { return path;
    }
    public org.apache.batik.svggen.font.table.TableDirectory getTableDirectory() {
        return tableDirectory;
    }
    protected void read(java.lang.String pathName) {
        path =
          pathName;
        java.io.File f =
          new java.io.File(
          pathName);
        if (!f.
              exists(
                )) {
            return;
        }
        try {
            java.io.RandomAccessFile raf =
              new java.io.RandomAccessFile(
              f,
              "r");
            tableDirectory =
              new org.apache.batik.svggen.font.table.TableDirectory(
                raf);
            tables =
              (new org.apache.batik.svggen.font.table.Table[tableDirectory.
                                                              getNumTables(
                                                                )]);
            for (int i =
                   0;
                 i <
                   tableDirectory.
                   getNumTables(
                     );
                 i++) {
                tables[i] =
                  org.apache.batik.svggen.font.table.TableFactory.
                    create(
                      tableDirectory.
                        getEntry(
                          i),
                      raf);
            }
            raf.
              close(
                );
            os2 =
              (org.apache.batik.svggen.font.table.Os2Table)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    OS_2);
            cmap =
              (org.apache.batik.svggen.font.table.CmapTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    cmap);
            glyf =
              (org.apache.batik.svggen.font.table.GlyfTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    glyf);
            head =
              (org.apache.batik.svggen.font.table.HeadTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    head);
            hhea =
              (org.apache.batik.svggen.font.table.HheaTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    hhea);
            hmtx =
              (org.apache.batik.svggen.font.table.HmtxTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    hmtx);
            loca =
              (org.apache.batik.svggen.font.table.LocaTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    loca);
            maxp =
              (org.apache.batik.svggen.font.table.MaxpTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    maxp);
            name =
              (org.apache.batik.svggen.font.table.NameTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    name);
            post =
              (org.apache.batik.svggen.font.table.PostTable)
                getTable(
                  org.apache.batik.svggen.font.table.Table.
                    post);
            hmtx.
              init(
                hhea.
                  getNumberOfHMetrics(
                    ),
                maxp.
                  getNumGlyphs(
                    ) -
                  hhea.
                  getNumberOfHMetrics(
                    ));
            loca.
              init(
                maxp.
                  getNumGlyphs(
                    ),
                head.
                  getIndexToLocFormat(
                    ) ==
                  0);
            glyf.
              init(
                maxp.
                  getNumGlyphs(
                    ),
                loca);
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    public static org.apache.batik.svggen.font.Font create() {
        return new org.apache.batik.svggen.font.Font(
          );
    }
    public static org.apache.batik.svggen.font.Font create(java.lang.String pathName) {
        org.apache.batik.svggen.font.Font f =
          new org.apache.batik.svggen.font.Font(
          );
        f.
          read(
            pathName);
        return f;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL2bC5AUxRmAexe4O46DuwN5yFPgsOThrryVI+JxvA7v4OSA" +
       "FId6zM323g3Mzgwzs8ceBlHKCFIpfICGGKAqEY2hEKyo0UQ0GDVKfEU0UcS3" +
       "pnygKalS0ZBo/r97ZudxO4N7XIWq6Zvd7r/n//7++++/Z5v9n5Mehk5GaYKS" +
       "EGJmu0aNWD3e1wu6QRPVsmAYS+HbJnHre9s3nnql5/VRUtBI+rQKRp0oGHSe" +
       "ROWE0UiGSYphCopIjUWUJlCiXqcG1dsEU1KVRtJfMmpSmiyJklmnJig2WC7o" +
       "taRcME1dak6btMbqwCQjapk2caZNvMrfoLKWlIiq1u4IDPYIVLvqsG3KeZ5h" +
       "krLa1UKbEE+bkhyvlQyzMqOT8Zoqt7fIqhmjGTO2Wp5qGWJh7dQOZhh1f+nX" +
       "p29pLWNm6CcoimoyRGMJNVS5jSZqSanz7VyZpoy15FrSrZb0cjU2SUWt/dA4" +
       "PDQOD7V5nVagfW+qpFPVKsMx7Z4KNBEVMslIbyeaoAspq5t6pjP0UGRa7EwY" +
       "aM/L0trD7UO8fXx8x8+vLvtdN1LaSEolpQHVEUEJEx7SCAalqWaqG1WJBE00" +
       "knIFBryB6pIgS+ut0e5rSC2KYKbBBWyz4JdpjersmY6tYCSBTU+Lpqpn8ZLM" +
       "qaxPPZKy0AKsAxxWTjgPvwfAYgkU05MC+J4l0n2NpCSYH3klsowVl0MDEC1M" +
       "UbNVzT6quyLAF6QvdxFZUFriDeB8Sgs07aGCC+rM1wI6RVtrgrhGaKFNJhnk" +
       "b1fPq6BVT2YIFDFJf38z1hOM0mDfKLnG5/NFM7ddoyxQoiQCOieoKKP+vUBo" +
       "uE9oCU1SncI84IIl42rvEAY8tiVKCDTu72vM2zz8k5OXTRh++FneZkiONoub" +
       "V1PRbBL3Nvd5eWj12Eu6oRpFmmpIOPgecjbL6q2ayowGkWZAtkesjNmVh5f8" +
       "ZcV1++iJKCmuIQWiKqdT4EfloprSJJnq86lCdcGkiRrSkyqJalZfQwrhvlZS" +
       "KP92cTJpULOGdJfZVwUq+wwmSkIXaKJiuJeUpGrfa4LZyu4zGiGkEC5SAtcE" +
       "wv+xvyZpjreqKRoXREGRFDVer6vIjwPKYg414D4BtZoabwb/X3PhxNj0uKGm" +
       "dXDIuKq3xAXwilbKK+NGW0sLVeJJsFR8HhQx9DXt//KUDLL2WxeJwDAM9QcB" +
       "GebPAlVOUL1J3JGePffkgabnuIPhpLCsBBEHHhXjj4qxR8X4o2L4qBg+ikQi" +
       "7Ann4CP5IMMQrYHJDtG2ZGzDVQtXbRnVDbxLW9cd7ItNz++w+lQ7UcEO5U3i" +
       "/peXnHrpheJ9URKFwNEMq4+zBFR4lgC+gumqSBMQg4IWAzsgxoPDf049yOGd" +
       "665fvvEipoc7qmOHPSAgoXg9xuLsIyr8szlXv6WbP/764B0bVGdee5YJe3Xr" +
       "IInhYpR/PP3wTeK484SHmh7bUBEl3SEGQdw1BZgnENKG+5/hCRuVdghGliIA" +
       "Tqp6SpCxyo6bxWarrq5zvmGOVs7uz4Eh7oXzqBSuKmtisb9YO0DDciB3TPQZ" +
       "HwUL8T9q0Ha//uInk5m57dWg1LWMN1Cz0hWBsLO+LNaUOy64VKcU2r21s377" +
       "7Z9vXsn8D1qMzvXACiyrIfLAEIKZf/rs2mPvvL331ajjsyYswelmyGYyWUj8" +
       "nhSHQKKfO/pABJNhfqPXVCxTwCulpCQ0yxQnyX9Kx0x86LNtZdwPZPjGdqMJ" +
       "Z+7A+f7c2eS6564+NZx1ExFxBXVs5jTjYbmf03OVrgvtqEfm+qPDfvGMsBsC" +
       "PARVQ1pPWZwkzAaEDdoUxh9n5WRf3TQsKgy383vnlyvTaRJvefWL3su/ePwk" +
       "09abKrnHuk7QKrl7YTEmA90P9AeaBYLRCu2mHF50ZZl8+DT02Ag9ihAojcU6" +
       "BLiMxzOs1j0K33jiyQGrXu5GovNIsawKiXkCm2SkJ3g3NVohNma0WZfxwV1X" +
       "BEUZQyUd4NGeI3KP1NyUZjLbrn9k4IMzf7PnbeZU3IuGMPHeBmZo/njI0mxn" +
       "Kn92/Jcf/OnUXYV8kR4bHL98coP+vVhu3vT+Nx2MzCJXjgTCJ98Y379rcPWl" +
       "J5i8E0JQenSm46ICQdaRnbQv9VV0VMHTUVLYSMpEK6VdLshpnJiNkMYZdp4L" +
       "aa+n3puS8fyjMhsih/rDl+ux/uDlLGZwj63xvrcvXmEOQAbBFbOmcswfryKE" +
       "3cxnIuezciwWE+zwUKjpEmx9qC8+9Arp1OT5CBMYBPsU5kAIHOM5KI+RWE7H" +
       "YgHvekagR1Z5eSZal32fi2cJ58FiYUfFg6RN0sfEyDNH0inOmHYbYWJorsBk" +
       "Yks9kj7GhjwZh8A1ydJyUgDjylDGIGkI+Exfwz87cTPbkG42TBY1eQr9h36f" +
       "PHBkVeExPjsrcjb3ZebvX/Pcr9U3T0TtrDuXCG95uVH30h8XfNTEVsMiTIKW" +
       "2m7sSm+q9BbXUlzmNVN5mJkAcExwPHFR7rln9Isb94x+j4XXIsmAWQdPzbFz" +
       "ccl8sf+dE0d7DzvAUpDuqLyluHfL13FH59moMaZSLBIZ29cu+KG+lo3WESv9" +
       "ZH7EO7NcZE3uaR3F2wtNCCiSIsjWzP4e/kXg+g4vtCV+gX8hZlVbm5fzsrsX" +
       "DTLoApkqLTDPQ+N2vS6lIJlps9wjvqHvO2t2fXwfdw9/kPY1plt2bP0+tm0H" +
       "Tx/4Vnh0h92oW4Zvh7mrYKGiF4wMewqTmPfRwQ2P3rthM9eqr3djN1dJp+77" +
       "x3+fj+1890iOfUQ3GGL80GItfjgiUW5me0j7ORGwWlYVmh09qOObC0mNZV88" +
       "QGWmw9gihX8prWOe5KxL04+e6nb8tkElHXcV2NvwgD3DuOCx8z/gmU2fDl56" +
       "aeuqPLYLI3y293f527r9R+afL94WZW8t+DLY4W2HV6jSu/gV69RM68pSzxI4" +
       "ik8DNi5OmBzHXCIk0dscUncTFjfApBFxCPmIhzT/GZuAs1xJlTOUA/xRkbt7" +
       "wcTd32688fXFEFNqSFFakdamaU3CS1topJtdYdJ5AeOwW46P0xe2sOM0LeNb" +
       "jK7MczE6F67JVpSdHLAYbQ9djIKkYfaoxiR7Koz/AZFvsTGJBT8f0o5OrK9T" +
       "LKWmBCDtCkUKkobkR0wJms004QcwVUP7XFC7OwE11VJragDU3aFQQdIA1SK3" +
       "J/OBmg/tc0Hd0wmoaZZa0wKgDoRCBUkDVCsVEvlALYD2uaAOdgJquqXW9ACo" +
       "h0OhgqQRCqjygoL2uaAe6QTUxZZaFwdAHQ6FCpJGqJSZyQsK2ueCeqITUJdY" +
       "al0SAHUkFCpIGqBkVcxrpGqhfS6ov3YCaoal1owAqKOhUEHSAJUSMnlFvzpo" +
       "nwvqlU5AVVpqVQZAHQ+FCpI2+QqcD9QiaJ8L6s1OQM201JoZAPVhKFSQNG7S" +
       "VcPMB6oe2ueC+mcIVMaVfWWVY/8KiO/3CZdyrrdIBDP4YUE/IbHsfe+mHXsS" +
       "i++eGLVSr3Um6Wmq2oUybaOyqyuu8nVZNXD3yJKbOZYac/wWdkB9BNl3pEGi" +
       "vszQyf1yb6J9G5+DA06tfapw/RybqBkLld2m/X3ix5szrO7bkHz0Oyy+NElR" +
       "CzWXujcg+e032YB/dSYv9rxDxC9m+UzPvGAEXHWW/eryN32QaLARIsUhdSVY" +
       "9DBJLzDQ4gYny9yZ5Y4UnDV3f6waCdcVlvJX5M8dJBrCNiCkbhAW5SYpAW5P" +
       "JvorB7xv14Evs7Rflj94kGgI3KiQugoshnFwT2L3gAM+vOvAV1jar8gfPEg0" +
       "BC4WUncRFmMtcHfyd8gBH9d14FdZ2l+VP3iQaAjcjJC6mVhMtcDdCeLTDvi0" +
       "rgMXLO2F/MGDREPg5oXULcCiioN7ksgXHfDZXQdOLe1p/uBBoiFwS0LqlmJR" +
       "x8E9ieZrDviirgOXLO2l/MGDREPgrg6pW4XFCg7uSUbfdcAbuw48ZWmfyh88" +
       "SDQEbnVIHZ4gilAO7klYP3HAk2cNjmcA2A9ray3t1+YPHiQaAtcWUseKtZD6" +
       "AniVIVL+Vvq0Q613DTUmzGlL9XT+1EGiIWSbQupuwGKDSYqBeg7NhX1t12Dj" +
       "Tqzd0r09f+wg0RC0bSF1t2BxkzW906n5crvGf291gW89a/DsBmmDpf2G/MGD" +
       "RH1wrs3MaUZ4Zwj9Lixu53sZBx32MqNC9zJOU2afO87aPn1t+9xoQd6Yv32C" +
       "REPw7w2p24fFXSYpxPBnHQpc5DDvPWvmwVg1Hq6tluJb82cOEg3hejCk7vdY" +
       "HDRJub219fwK/2OH/v6zpu+DVRfAdauFcGsIPSu9pyl6arpqgm404TtP0Tuk" +
       "z+Cpsojx/znENk9h8ahJuuv2q252xkXlj2+DijZVSjgmOnTWJhqIVcPgOmTh" +
       "HMrDRPYv0wUGO6ntM1J5SK8hNnglpO7vWDwPDxTBQGb2pciZD4c6Jnuh60z2" +
       "pAX3ZN4mQ0X+lsNcQT2eyafeD7HZh1i8mbUZfnKl02/lb44MuCHaFI+bDepw" +
       "pp+fQxcP7CktGrhn2Wv8xIV9VryklhQl07LsPg3lui/QdJqUmPlK+Nko9mto" +
       "5IRJhoYNMSiUtAY58ikX+ZdJBgaIoL+yG3f7kyYp87c3SQ/2193uS0henHbQ" +
       "Fb9xNzmFv5PqeG4q8k323brrWBU/R5bhJ0Cyr03tESH9zzQirjetoz2nAdh/" +
       "w7DfVab5f8RoEg/uWbjompPT7ubHWEVZWL8ee+lVSwr5iVrWKf76PzKwN7uv" +
       "ggVjT/e5v+cY+01nOVfY8fchjuORWeCiGjrJYN8ZT6Mie9Tz2N6Zj7+wpeBo" +
       "lERWkohgkn4rO564y2hpnYxYWZvrd/jlgs6On1YWf7DqpW/eiPRlBxsJf3s7" +
       "PEyiSdz++PH6pKbdGSU9a0gPSUnQDDsOOKddWULFNt3zs35Bs5pWsieF+qBH" +
       "C3g8jlnGMmjv7Ld4DBoSnI6nXzoeDS+W1XVUn429Yze9fecl0prmrmWW3cYX" +
       "BbQ0+FpTbZ2mWcd/Co8xy2saTtVoL/xw8/8AhC72I2s1AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL2cDbDrWH3Y/d5+L8vu211gNxsW2A8oILiWJduyWEKQJVu2" +
       "LNuyZcm2Elj0Ldn6sr4sm2wSmCkwMCUkWSjpwE47A0nKbCDTJBOmJe1mGEpo" +
       "MrShTNI2bZamnSkpYQKdCe2UJumR7Xt9733v3n1v907ujM6Tdb7+v3P+53/+" +
       "R0fnPfvdwi1RWIAC31mZjh8f6Fl8MHMqB/Eq0KMDhq1wchjpGunIUTQCz55U" +
       "H/31e37ww49ZVy4XbpUK98ue58dybPteNNQj30l1jS3cs3/acHQ3igtX2Jmc" +
       "ysUktp0ia0fxE2zhZceyxoXH2UMRikCEIhChuBGhSOxTgUwv173EJfMcshdH" +
       "i8JPFy6xhVsDNRcvLjxyspBADmV3Vwy3IQAl3J7/FgHUJnMWFl53xL5lvgr4" +
       "41Dx6X/47iv/7KbCPVLhHtvjc3FUIEQMKpEKd7m6q+hhRGiarkmFez1d13g9" +
       "tGXHXm/klgr3RbbpyXES6keNlD9MAj3c1LlvubvUnC1M1NgPj/AMW3e0w1+3" +
       "GI5sAtZX7Vm3hM38OQC80waChYas6odZbp7bnhYXXns6xxHj4x2QAGS9zdVj" +
       "yz+q6mZPBg8K9237zpE9s8jHoe2ZIOktfgJqiQsPnVlo3taBrM5lU38yLjx4" +
       "Oh23jQKp7tg0RJ4lLrzydLJNSaCXHjrVS8f657u9t3/0vV7Lu7yRWdNVJ5f/" +
       "dpDpNacyDXVDD3VP1bcZ73oz+wn5Vb/zocuFAkj8ylOJt2l++6e+/863vOa5" +
       "39um+dFrpOkrM12Nn1Q/o9z9h68m34TflItxe+BHdt75J8g36s/tYp7IAjDy" +
       "XnVUYh55cBj53PBfT3/2c/p3LhfubBduVX0ncYEe3av6bmA7ekjrnh7Ksa61" +
       "C3fonkZu4tuF28A9a3v69mnfMCI9bhdudjaPbvU3v0ETGaCIvIluA/e2Z/iH" +
       "94EcW5v7LCgUCreBq3AXuN5S2P5t/o0LStHyXb0oq7Jne36RC/2cP+9QT5OL" +
       "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" +
       "HLCEmvu4G/uV9pCx/Gmvy9tCTEwrNXs+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "BIxCAAA=");
}
