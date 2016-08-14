package org.apache.batik.svggen.font.table;
public class Ligature {
    private int ligGlyph;
    private int compCount;
    private int[] components;
    public Ligature(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        ligGlyph =
          raf.
            readUnsignedShort(
              );
        compCount =
          raf.
            readUnsignedShort(
              );
        components =
          (new int[compCount -
                     1]);
        for (int i =
               0;
             i <
               compCount -
               1;
             i++) {
            components[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public int getGlyphCount() { return compCount; }
    public int getGlyphId(int i) { return i == 0 ? ligGlyph : components[i -
                                                                           1];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZC2wUxxken41t/LZ5BrB52BDxugtpaBWZJgHHBtMzWJg4" +
                                                              "qiGYvb25u8V7u8vunH02pXlIVUjVUkIJoVVitSoUinhEUaK2yos2CkmUNFIe" +
                                                              "bZpGCelDbVoaFVQ1rUrb9P9ndm8f90CozUk7Nzf7/zP//8//f/8/c6c+IlMs" +
                                                              "k7RRjYXZuEGtcLfG+iXTovEuVbKsrTA2LD9cLv11x4ebbg6RyiHSkJKsPlmy" +
                                                              "aI9C1bg1RFoVzWKSJlNrE6Vx5Og3qUXNUYkpujZEZihWb9pQFVlhfXqcIsGg" +
                                                              "ZEZJs8SYqcQyjPbaEzDSGgVJIlySyNrg684oqZN1Y9wln+0h7/K8Qcq0u5bF" +
                                                              "SFN0lzQqRTJMUSNRxWKdWZMsN3R1PKnqLEyzLLxLXW2bYGN0dZ4JFj3W+PGV" +
                                                              "A6kmboJpkqbpjKtnbaGWro7SeJQ0uqPdKk1bu8mXSXmU1HqIGemIOotGYNEI" +
                                                              "LOpo61KB9PVUy6S7dK4Oc2aqNGQUiJGF/kkMyZTS9jT9XGaYoZrZunNm0HZB" +
                                                              "TluhZZ6KDy2PHHp4R9Pj5aRxiDQq2gCKI4MQDBYZAoPSdIya1tp4nMaHSLMG" +
                                                              "mz1ATUVSlQl7p1ssJalJLAPb75gFBzMGNfmarq1gH0E3MyMz3cypl+AOZf+a" +
                                                              "klClJOg609VVaNiD46BgjQKCmQkJ/M5mqRhRtDgj84McOR07vgAEwFqVpiyl" +
                                                              "55aq0CQYIC3CRVRJS0YGwPW0JJBO0cEBTUbmFJ0UbW1I8oiUpMPokQG6fvEK" +
                                                              "qKZyQyALIzOCZHwm2KU5gV3y7M9Hm9bs36Nt0EKkDGSOU1lF+WuBqS3AtIUm" +
                                                              "qEkhDgRj3bLoYWnmM/tChADxjACxoPnhly7ftqLt3EuCZm4Bms2xXVRmw/LR" +
                                                              "WMPr87qW3lyOYlQbuqXg5vs051HWb7/pzBqAMDNzM+LLsPPy3JbzX7znJL0Y" +
                                                              "IjW9pFLW1Uwa/KhZ1tOGolJzPdWoKTEa7yVTqRbv4u97SRX0o4pGxejmRMKi" +
                                                              "rJdUqHyoUue/wUQJmAJNVAN9RUvoTt+QWIr3swYhpAoeUgdPKxEf/s3IjkhK" +
                                                              "T9OIJEuaoumRflNH/a0IIE4MbJuKxMDrRyKWnjHBBSO6mYxI4Acp6rwYTSap" +
                                                              "FknoiFBSTKWAO0keHGH0M+NTXyGLOk4bKysD888LBr8KcbNBV+PUHJYPZdZ1" +
                                                              "Xz4z/IpwLAwG2zqMLIdFw2LRMF80LBYN46JhvmjYWZSUlfG1puPiYpthk0Yg" +
                                                              "3AFv65YO3LVx575F5eBfxlgFWBhJF/nyTpeLCQ6QD8tnW+onFr6/6vkQqYiS" +
                                                              "FklmGUnFNLLWTAJAySN2DNfFICO5iWGBJzFgRjN1mcZBxmIJwp6lWh+lJo4z" +
                                                              "Mt0zg5O2MEAjxZNGQfnJuSNj9w7efUOIhPy5AJecAjCG7P2I4Dmk7ghiQKF5" +
                                                              "G+//8OOzh/fqLhr4kouTE/M4UYdFQW8ImmdYXrZAenL4mb0d3OxTAa2ZBNEF" +
                                                              "QNgWXMMHNp0OcKMu1aBwQjfTkoqvHBvXsJSpj7kj3E2beX86uEUtRt80eDrs" +
                                                              "cOTf+Hamge0s4dboZwEteGL4/IDx6C9f++NnuLmdHNLoSf4DlHV6cAsna+EI" +
                                                              "1ey67VaTUqB770j/Nx/66P5t3GeBor3Qgh3YdgFewRaCmb/y0u53Lrx/9K2Q" +
                                                              "6+cMEncmBvVPNqckjpOaEkrCaktceQD3VEAG9JqOOzTwTyWhYOhhYP2rcfGq" +
                                                              "J/+8v0n4gQojjhutuPoE7vh168g9r+z4exufpkzGvOvazCUTYD7NnXmtaUrj" +
                                                              "KEf23jdav/Wi9CikBYBiS5mgHF3L7FhHoWZDkuCcih7eImlxPb1WBmCzegCn" +
                                                              "+a6u5mQ38PamfOZpDnPv5u6sTA0UiPPdjM1iyxs5/uD0FFfD8oG3LtUPXnr2" +
                                                              "MlfVX515HaVPMjqFb2KzJAvTzwoi2wbJSgHdTec2bW9Sz12BGYdgRq7UZhOw" +
                                                              "NetzK5t6StWvfvL8zJ2vl5NQD6lRdSneI/EIJVMhNKiVAljOGrfeJjxjrBqa" +
                                                              "JuxlSc4whBuGZPMGcHfmF9737rTB+E5N/GjWE2uOT77PXdQQc8zl/OWYKXyQ" +
                                                              "zGt8FxVOvvm5nx9/8PCYqBKWFofCAN/sf25WY/f95h95JucgWKCCCfAPRU49" +
                                                              "Mqfrlouc30Uj5O7I5mc3QHSX98aT6b+FFlW+ECJVQ6RJtmvqQUnNYIwPQR1p" +
                                                              "OYU21N2+9/6aUBRAnTm0nRdEQs+yQRx0syr0kRr79QHowyKEXAfPfBsV5geh" +
                                                              "r4zwTh9nuZ63y7BZ6SBNlWEqcO6iAaipLTEpI9Wqklyvjhspf0bGrDeQiVmQ" +
                                                              "PZU0gOWoXU7e2L9T3tfR/zvhBNcVYBB0M05Evj749q5XORRXY37e6ijuyb6Q" +
                                                              "xz15oEnI/Ql8yuD5Dz4oLw6Isqyly64NF+SKQ3Tikt4YUCCyt+XCyCMfnhYK" +
                                                              "BF0vQEz3HfrqJ+H9hwS+ihNGe16R7+URpwyhDjZ3onQLS63COXr+cHbvUyf2" +
                                                              "3i+kavHXy91wHDz9i3+/Gj7ywcsFyrRyxT4lelETMqR/b4RCtz/Q+PSBlvIe" +
                                                              "yOy9pDqjKbsztDfud9EqKxPzbJZ7cnHd1lYNN4aRsmWwByIvY7sGm03CB28t" +
                                                              "CmTr/Y4/B54Fto8uKOL4wlWux6Y/38OLcTOEjLTRpWc0nhwHA5KmrlFSPCAs" +
                                                              "tNdaWERSraSkxbgZqUFJdQ02zvLfy+SCi2dcsZXba88/Z33v948LlykUuoGT" +
                                                              "4Inj1fK76fM8dHHBO3KiNaAkzfDYNhDfjGz7H88oeD8hjbFIkuppOAuzFJTV" +
                                                              "SZZyjkCf5vQYdouLg4LHjpPfb3/t7sn2X/P8Xa1YAOQASwVO4x6eS6cuXHyj" +
                                                              "vvUML5ArEN3sYPFfY+TfUvguH/guNGIzyruDBWuf9YLAdq29hdE/hN0wg7yj" +
                                                              "aJLKZ7sTSk+VGwR/bcdmj+EWDSHB5y+vMNWFu1RwQSwQnXfTndIrd+MDL7MF" +
                                                              "IKfVVz70cVXdXPxew8Hf/rgjue5aDnM41naV4xr+ng/7taz4dgdFefG+P83Z" +
                                                              "ektq5zWcy+YHvCE45Q/6Tr28fol8MMQvlUSRkHcZ5Wfq9ONujUnhJK35kbbd" +
                                                              "dY89Lqos5xscKJidMhB/f6PEuwex+Rr4iowbLfyiBPmh/DoTB7oNT0lquwD+" +
                                                              "lIOpQC8BsFmPSjk04p9KEriT8QClp2glGOetxa7NeGo9et+hyfjmY6sc2NsB" +
                                                              "GYHpxkqVjlLVM5UIhX05MRpx+nnwrLTFWBlEe1fRgAa5E14x1hLmPlbi3XFs" +
                                                              "vsNIfZIyXrO5Wc2193evltBKnyHE3hayBRanq2yFVl27LYqxFj72caX4rI+X" +
                                                              "MMgT2JyGxOkYpDcesMaZ/4c1slAmOxddeMianXebLm6A5TOTjdWzJu94W+QF" +
                                                              "55a2DsAqkVFV7zHA0680TJpQuD514lAgyqmnGVl09Rs4iGOWA+unBOdzcD4p" +
                                                              "xclIBX55WX7KyKwiLJBHRMdL/wIjTUF6EIV/e+legs1x6WAq0fGSvAIlLJBg" +
                                                              "91XDyTlNbj4SR69smT/sczs842o77EGKdl+K4H+dOHCeEX+eDMtnJzdu2nP5" +
                                                              "s8fEJZKsShMTOEstJG9xn5VLCQuLzubMVblh6ZWGx6YudrCnWQjsBstcjzN3" +
                                                              "g9sb6F5zAjcsVkfuouWdo2ue/dm+yjegWNlGyiTI29vyD6lZIwOguC2afwCA" +
                                                              "9MmvfjqXfnv8lhWJv7zLrwGIyN7zitMPy28dv+vNg7OPtoVIbS+ZArBKs/z0" +
                                                              "fPu4toXKo+YQqVes7iyICLNAkeA7XTRgJEj4pwq3i23O+twoXkGCs+cfrPIv" +
                                                              "bmtUfYya6wD3eKRDyVXrjvj+03GyasYwAgzuiKcOi/GUmsXdAH8cjvYZhnPu" +
                                                              "rL3R4EAgF893F3gXmw/+C4mylRhWHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eigAAA==");
}
