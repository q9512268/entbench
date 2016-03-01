package org.apache.batik.svggen.font.table;
public class GsubTable implements org.apache.batik.svggen.font.table.Table, org.apache.batik.svggen.font.table.LookupSubtableFactory {
    private org.apache.batik.svggen.font.table.ScriptList scriptList;
    private org.apache.batik.svggen.font.table.FeatureList featureList;
    private org.apache.batik.svggen.font.table.LookupList lookupList;
    protected GsubTable(org.apache.batik.svggen.font.table.DirectoryEntry de,
                        java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        raf.
          readInt(
            );
        int scriptListOffset =
          raf.
          readUnsignedShort(
            );
        int featureListOffset =
          raf.
          readUnsignedShort(
            );
        int lookupListOffset =
          raf.
          readUnsignedShort(
            );
        scriptList =
          new org.apache.batik.svggen.font.table.ScriptList(
            raf,
            de.
              getOffset(
                ) +
              scriptListOffset);
        featureList =
          new org.apache.batik.svggen.font.table.FeatureList(
            raf,
            de.
              getOffset(
                ) +
              featureListOffset);
        lookupList =
          new org.apache.batik.svggen.font.table.LookupList(
            raf,
            de.
              getOffset(
                ) +
              lookupListOffset,
            this);
    }
    public org.apache.batik.svggen.font.table.LookupSubtable read(int type,
                                                                  java.io.RandomAccessFile raf,
                                                                  int offset)
          throws java.io.IOException { org.apache.batik.svggen.font.table.LookupSubtable s =
                                         null;
                                       switch (type) {
                                           case 1:
                                               s =
                                                 org.apache.batik.svggen.font.table.SingleSubst.
                                                   read(
                                                     raf,
                                                     offset);
                                               break;
                                           case 2:
                                               break;
                                           case 3:
                                               break;
                                           case 4:
                                               s =
                                                 org.apache.batik.svggen.font.table.LigatureSubst.
                                                   read(
                                                     raf,
                                                     offset);
                                               break;
                                           case 5:
                                               break;
                                           case 6:
                                               break;
                                       }
                                       return s;
    }
    public int getType() { return GSUB; }
    public org.apache.batik.svggen.font.table.ScriptList getScriptList() {
        return scriptList;
    }
    public org.apache.batik.svggen.font.table.FeatureList getFeatureList() {
        return featureList;
    }
    public org.apache.batik.svggen.font.table.LookupList getLookupList() {
        return lookupList;
    }
    public java.lang.String toString() { return "GSUB";
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5TH0totFn7yEEF908NceOddjUxM8A/amGBj/fiqmGjCHMw/8/f0SbT/A4iHI" +
       "XtKUOStwt4f54cvGjHD5eSxuTzw+fszFVEvg+mmJtiNY/IiROsCcn0lt8JA/" +
       "ftnI8eBNFsAj29OXx4+8mGoJdM+UaPslFk8xMgmQB9KsWzzoP/vfLXrann96" +
       "/NCLqZaA93yJthewOCYWPT8JS3nIn7ts5I3YhHFzyJ7+0PiRF1Mtge5kibZT" +
       "WPyekSqmi1t3hwwb+IEVD1gRXwM3xInxGyIH+Zd7F4nn4ekF/4eIO3z5iQP1" +
       "VdMO3PQXfh/m3rPXQnhOZVXVf1zz1cOGSVMKB1QrDm8iJJxlpOXipM5Ihcfm" +
       "Z4Tm63COLKUJoQO//CpvMTKtiArk4qLil38bjByUh6nwb7/c3+E84clBV6Li" +
       "F3kPAjGIYPV9Y4wVFEfkXJkv87Xdki/o1IstqKviv5vDHIb/+eWE+az4+wsS" +
       "sAM3rLv9/FceE3eDsipt3Yq9TITgLq4p3Sx2XtHenL7CaxddmPRk9QIn55gs" +
       "JuxtlJk+b+6AIG+ge80I3JpZre7l2ZmDy4+9sit8GrKlAVImMTJloPAyIWdk" +
       "IcUeiI2VxkCOzy/02mre3nTy07NljfzOhojEp7mURlzee+xcb8owHgqR6i5S" +
       "ASkVzfGbjtUj2noqD5t5WVE4oWc193+ySbgXJNyJ3DK2Qevct3i3DO5emPcV" +
       "3rfD8XQLNa/H3rGbukDenzUMfyu37Hew2JlDS4OvxWPdhmEnvJWj3PKGwXf6" +
       "Z1js+S/L1aT14R4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+9AT38guyf4PKeCucI0qAAA=");
}
