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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WP1+hkw3AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALWcCawsWXmY+72ZebMwzArMeMwAs0CAxrd6re5mMKb2Xqq6" +
       "qqureikbhurau2tfuqsaj22QAgQUjO3BxhaMEglsB43BiW0ZJTgZCxFMbJGY" +
       "IDuJEw9xIgUHI0MkEyvEdk519719733v3nlv5uZJdW51ne3//vOf//y1nPfs" +
       "twu3RGGh6Ht2ZthefKCl8cHcrh/Ema9FB126zslhpKmYLUeRAK49qTz663d/" +
       "7/sfNe+5XLgiFe6XXdeL5djy3IjXIs9eaipduHt/lbA1J4oL99BzeSlDSWzZ" +
       "EG1F8RN04WXHqsaFx+lDESAgAgREgDYiQMi+FKj0cs1NHCyvIbtxFBR+onCJ" +
       "LlzxlVy8uPDIyUZ8OZSdXTPchgC0cFv+ewSgNpXTsPC6I/Yt81XAHytCT//C" +
       "u+75ZzcV7pYKd1vuMBdHAULEoBOpcKejOTMtjBBV1VSpcK+raepQCy3ZttYb" +
       "uaXCfZFluHKchNqRkvKLia+Fmz73mrtTydnCRIm98AhPtzRbPfx1i27LBmB9" +
       "1Z51S0jm1wHgHRYQLNRlRTuscvPCctW48NrTNY4YH++BAqDqrY4Wm95RVze7" +
       "MrhQuG87drbsGtAwDi3XAEVv8RLQS1x46MxGc137srKQDe3JuPDg6XLcNguU" +
       "un2jiLxKXHjl6WKblsAoPXRqlI6Nz7f7b/vIe9y2e3kjs6opdi7/baDSa05V" +
       "4jVdCzVX0bYV73wz/fPyq37ng5cLBVD4lacKb8v89o9/9x1vec1zv7ct84PX" +
       "KMPO5poSP6l8anbXH74ae1PrplyM23wvsvLBP0G+MX9ul/NE6oOZ96qjFvPM" +
       "g8PM5/h/Pf2pz2jfuly4o1O4onh24gA7ulfxHN+ytZDSXC2UY03tFG7XXBXb" +
       "5HcKt4Jz2nK17VVW1yMt7hRutjeXrnib30BFOmgiV9Gt4Nxyde/w3Jdjc3Oe" +
       "+oVC4VZwFO4Ex1sK23+bv3FBgEzP0SBZkV3L9SAu9HL+CNLceAZ0a0IzYPUL" +
       "KPKSEJgg5IUGJAM7MLXDjKVhaC6kA91AJEgOcuvy/z+1m+Y896wuXQKqfvXp" +
       "iW6DOdL2bFULn1SeTlDiu5998vcvHxn+ThPAq4CuDrZdHWy6Oth2dZB3dZB3" +
       "Vbh0adPDK/IutwMJhmEBJjRwdXe+afjO7rs/+OhNwIL81c1Ah3lR6GyPi+1d" +
       "QGfj6BRgh4XnPr567+gnS5cLl0+6zlxMcOmOvDqXO7wjx/b46SlzrXbv/sA3" +
       "v/e5n3/K20+eE754N6evrpnPyUdPKzT0FE0FXm7f/JtfJ//Wk7/z1OOXCzeD" +
       "iQ6cWywDYwR+4zWn+zgxN5849HM5yy0AWPdCR7bzrEPndEdsht5qf2Uz0ndt" +
       "zu8FOn5Zbqx3gwPZWe/mb557v5+nr9haRj5opyg2fvSHh/4n/8NX/7y6Ufeh" +
       "y7372CI21OInjk3zvLG7NxP63r0NCKGmgXL/5ePcz33s2x/40Y0BgBKPXavD" +
       "x/MUA9MbDCFQ89//veA/Pv+nn/r65b3RxGCdS2a2paRHkPn1wh3nQILe3rCX" +
       "B7gJG0yp3GoeF13HUy3dkme2llvp/7379eXf+ouP3LO1AxtcOTSjt7xwA/vr" +
       "P4AWfur33/W/X7Np5pKSL1N7ne2LbX3f/fuWkTCUs1yO9L1fe/gXvyx/EnhR" +
       "4Lkia61tnFFho4PCZtCgDf+bN+nBqbxynrw2Om78J+fXsXDiSeWjX//Oy0ff" +
       "+Zff3Uh7Mh45PtaM7D+xNa88eV0Kmn/g9Exvy5EJytWe6//YPfZz3wctSqBF" +
       "BXiqiA2Bh0lPWMau9C23/qff/eKr3v2HNxUuk4U7bE9WSXkzyQq3A+vWIhM4" +
       "p9T/kXdsB3d1G0ju2aAWroLfGsWDm1+5Vb/pbP9C5uHEfoo++H9Ye/a+P/vr" +
       "q5Sw8SzXWEVP1ZegZz/xEPb2b23q76d4Xvs16dVeF4Re+7qVzzh/dfnRK1+6" +
       "XLhVKtyj7OK6kWwn+cSRQCwTHQZ7IPY7kX8yLtkuwk8cubBXn3Yvx7o97Vz2" +
       "3h6c56Xz8ztO+ZN8ISw8CI6D3VQ7OO1PLhU2Jz+yqfLIJn08T/7e4fS91Q+t" +
       "JVi0d/P378C/S+D42/zIG8svbJfY+7DdOv+6o4XeBwvRZoHeVH4liKg31pTD" +
       "H2yDsq0/y9NKnrxj2039TOt560m28u44PL8WW+8MtvwU2ygMjwt3xblLwK1Q" +
       "y005O5S3fO4quqlzIJyoeQqIvkGgHwRHZQdUOQNIuB6gKxvhIjCpXn/2pNo4" +
       "sG3I+MwvP/bVn3zmsf+68QG3WREwPSQ0rhHDHqvznWef/9bXXv7wZzfr5M0z" +
       "Odoa4eng/+rY/kTIvpH4zpNquPc8NRwOzhuvd3CO/M6lXSSzUXye/NihTt99" +
       "bZ1ezk/fGIOpZ7myfaRbW3MNYNTnOiwutBywyi53YTv01H3PLz7xzV/bhuSn" +
       "vdOpwtoHn/7Q3x185OnLx26EHrvqXuR4ne3N0EbAl2+kzP39I+f1sqlB/o/P" +
       "PfUvfvWpD2yluu9kWE+Au9Zf+6O/+YODj3/jK9eIMG8Cw5r/+FE/PVLw5a3W" +
       "Dkfo/v10x2zP1Y4GA+Rtw07LOzi67QSZ6VVDFRbefLaOmY0Z7T3zl9/3Px8S" +
       "3m6++wbizdee0tHpJv8J8+xXqDcoP3u5cNORn77qnvRkpSdOeuc7Qg3cRLvC" +
       "CR/98Nb6Nvrbml6evH4zdOdECtk5ee/JkyWwVSVX9XZkzin+E2nhlK8Sb9BX" +
       "/QA4qrtJWj3DV733enzVTV5UOTSL4nVMajaqbOb1Kfnf9yJ8bW0nf+0M+T90" +
       "PfLfrDiyfwjwlusAwED5axF8+EUQ1HcE9TMIfu66CAw702+EgALlr0Xw9Isg" +
       "gHcE8BkEn7guAlOT1RshaIPy1yL45IsgaOwIGmcQfPr6CADCDRGA8tci+OUX" +
       "QdDcETTPIPjs9RE4cXpDBKD8tQg+9yIIWjuC1hkEv31dBLan3NAY0KD8tQg+" +
       "/yII3rojeOsZBM9dF4EjpzfkixhQ/loEv/siCJ7YETxxBsFXrosgXztvhKAP" +
       "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" +
       "67UKrzdGHNRBezYjjQVJH9J9dVRMYGFg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "H4KgxEIAAA==");
}
