package org.apache.batik.svggen.font.table;
public class NameRecord {
    private short platformId;
    private short encodingId;
    private short languageId;
    private short nameId;
    private short stringLength;
    private short stringOffset;
    private java.lang.String record;
    protected NameRecord(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        platformId =
          raf.
            readShort(
              );
        encodingId =
          raf.
            readShort(
              );
        languageId =
          raf.
            readShort(
              );
        nameId =
          raf.
            readShort(
              );
        stringLength =
          raf.
            readShort(
              );
        stringOffset =
          raf.
            readShort(
              );
    }
    public short getEncodingId() { return encodingId; }
    public short getLanguageId() { return languageId; }
    public short getNameId() { return nameId; }
    public short getPlatformId() { return platformId; }
    public java.lang.String getRecordString() { return record; }
    protected void loadString(java.io.RandomAccessFile raf, int stringStorageOffset)
          throws java.io.IOException { java.lang.StringBuffer sb =
                                         new java.lang.StringBuffer(
                                         );
                                       raf.seek(stringStorageOffset +
                                                  stringOffset);
                                       if (platformId == org.apache.batik.svggen.font.table.Table.
                                                           platformAppleUnicode) {
                                           for (int i =
                                                  0;
                                                i <
                                                  stringLength /
                                                  2;
                                                i++) {
                                               sb.
                                                 append(
                                                   raf.
                                                     readChar(
                                                       ));
                                           }
                                       }
                                       else
                                           if (platformId ==
                                                 org.apache.batik.svggen.font.table.Table.
                                                   platformMacintosh) {
                                               for (int i =
                                                      0;
                                                    i <
                                                      stringLength;
                                                    i++) {
                                                   sb.
                                                     append(
                                                       (char)
                                                         raf.
                                                         readByte(
                                                           ));
                                               }
                                           }
                                           else
                                               if (platformId ==
                                                     org.apache.batik.svggen.font.table.Table.
                                                       platformISO) {
                                                   for (int i =
                                                          0;
                                                        i <
                                                          stringLength;
                                                        i++) {
                                                       sb.
                                                         append(
                                                           (char)
                                                             raf.
                                                             readByte(
                                                               ));
                                                   }
                                               }
                                               else
                                                   if (platformId ==
                                                         org.apache.batik.svggen.font.table.Table.
                                                           platformMicrosoft) {
                                                       char c;
                                                       for (int i =
                                                              0;
                                                            i <
                                                              stringLength /
                                                              2;
                                                            i++) {
                                                           c =
                                                             raf.
                                                               readChar(
                                                                 );
                                                           sb.
                                                             append(
                                                               c);
                                                       }
                                                   }
                                       record =
                                         sb.
                                           toString(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfZAUxRXv3eP2PrjjPpAP+TjgOKkCZScECbGOgHAecrD3" +
       "UXdAKodxmZvt3RuYnRlmeo/lCEGoihCrYlmChhghfwiVhKCYVIypWBoSkyBl" +
       "lEJNolKRJFZFE6UClQpoNDHvdc/uzM7uLHVqZaumt3f6ve73+r33e697T1wk" +
       "lbZFWk1ZT8hRtsOkdrQP+32yZdNEhybb9np4G1fu+fOB3VdfrtkTJpFBMmFY" +
       "trsV2aarVaol7EEyU9VtJusKtXsoTSBHn0Vtao3ITDX0QTJJtbvSpqYqKus2" +
       "EhQJNspWjDTJjFnqUIbRLmcCRmbFuDQSl0Za6Sdoj5E6xTB3uAzTChg6PGNI" +
       "m3bXsxlpjG2RR2Qpw1RNiqk2a89a5EbT0HakNINFaZZFt2hLnI1YG1tStA2t" +
       "jzdc+eC+4Ua+DRNlXTcYV9Hup7ahjdBEjDS4bzs1mra3ka+SihgZ7yFmpC2W" +
       "W1SCRSVYNKevSwXS11M9k+4wuDosN1PEVFAgRuYUTmLKlpx2punjMsMM1czR" +
       "nTODtrPz2ubM7VPxgRulg9+8s/FHFaRhkDSo+gCKo4AQDBYZhA2l6SFq2SsT" +
       "CZoYJE06GHyAWqqsqaOOtZttNaXLLAMukNsWfJkxqcXXdPcKLAm6WRmFGVZe" +
       "vSR3KudXZVKTU6DrZFdXoeFqfA8K1qogmJWUwfcclnFbVT3B/aiQI69j2zog" +
       "ANaqNGXDRn6pcboML0izcBFN1lPSADifngLSSgNc0OK+FjAp7rUpK1vlFI0z" +
       "MtVP1yeGgKqGbwSyMDLJT8ZnAitN81nJY5+LPcvu3amv0cMkBDInqKKh/OOB" +
       "qcXH1E+T1KIQB4KxbkHsQXny0/vDhADxJB+xoHnyK5dvvanl1HOCZnoJmt6h" +
       "LVRhceXo0IRzMzrm31KBYlSbhq2i8Qs051HW54y0Z01Amsn5GXEwmhs81f+b" +
       "L911nL4TJrVdJKIYWiYNftSkGGlT1ah1O9WpJTOa6CI1VE908PEuUgX9mKpT" +
       "8bY3mbQp6yLjNP4qYvDfsEVJmAK3qBb6qp40cn1TZsO8nzUJIVXwkDp4ZhDx" +
       "4d+M6NKwkaaSrMi6qhtSn2Wg/mhQjjnUhn4CRk1DGgL/37pwUXSpZBsZCxxS" +
       "MqyUJINXDFMxKNkjqRTVpSTslMTkIY1KPeB0/VQxrEQU/c78v6+YxT2YuD0U" +
       "AvPM8IODBnG1xtAS1IorBzOrOi8/Fn9eOB4Gi7N7jCyEZaNi2ShfNiqWjeKy" +
       "Ub5s1F2WhEJ8tetweeEIYMatAAiAyHXzB768dvP+1grwQHP7OLABks4rylAd" +
       "LnLk4D6unDjXf/XsC7XHwyQM4DIEGcpNE20FaUJkOctQaAJwKihh5EBTCk4R" +
       "JeUgpw5t37Nx92e4HF7kxwkrAbSQvQ/xOr9Emz/iS83bsO/tKycf3GW4sV+Q" +
       "SnIZsIgTIaXVb1u/8nFlwWz5ifjTu9rCZBzgFGAzkyGWAPZa/GsUQEt7DqZR" +
       "l2pQOGlYaVnDoRy21rJhy9juvuFO18T714GJJ2CsTYVnnhN8/BtHJ5vYThFO" +
       "ij7j04KngS8MmIdfffFvi/l25zJGgyfVD1DW7kEpnKyZ41GT64LrLUqB7o+H" +
       "+g48cHHfJu5/QDG31IJt2HYAOoEJYZu/9ty21y68cfSVsOuzjNSYlsEgcGki" +
       "m9cTh0h9GT3R1V2RAOg0mAEdp22DDo6pJlWMJYyTDxtuWPTEu/c2ClfQ4E3O" +
       "k2669gTu++tXkbuev/NqC58mpGCidbfNJRPoPdGdeaVlyTtQjuyel2Z+67R8" +
       "GPIAYK+tjlIOpyEndFGoqZAVOKdqRPsh7oz0SgWwyl4NwMwNezMnk3i7uJh5" +
       "Yo65q7czq1ATBeJ8n8emzfYGT2F8eqqpuHLfK5fqN1565jJXtbAc8/pKt2y2" +
       "C/fE5oYsTD/FD1RrZHsY6G4+1XNHo3bqA5hxEGbkSvVaAJbZAs9yqCurXv/F" +
       "s5M3n6sg4dWkVjPkxGqZBympgeig9jDgbNZccavwjO3V0DRiL0vyG0P4xgjH" +
       "nFXazJ1pk3HDjP50yo+XfffIG9wphQtO5+xVNlaBfjzlpbwLBe+e//abP7/6" +
       "SJUoBOYH45+Pb+q/e7WhvX95r2iTOfKVKFJ8/IPSiYendSx/h/O7EITcc7PF" +
       "CQpA2uX97PH0v8KtkV+HSdUgaVScsnmjrGUwsAehVLRztTSU1gXjhWWfqHHa" +
       "8xA7ww9/nmX94OcmRugjNfbrfXiHdQaZCU+LgwMtfrwLEd5Zx1nm8XY+Njfl" +
       "4KXKtFQ4XlEfuIwvMykjtaYmM0TnrgSPGo8T4LlsIDNksz5LTQNKjjhV48nJ" +
       "V7f9qmr0tlxFWIpFUK6zu8/+bM1bcY7C1Zh81+fU96TVlVbKkwIahfQfwScE" +
       "z3/xQanxhai/mjucInB2vgo0TQzKMj7pU0Ha1Xxh68NvPypU8Dugj5juP3jP" +
       "R9F7DwpcFUeJuUXVvJdHHCeEOthsQOnmlFuFc6x+6+Sup763a5+QqrmwMO6E" +
       "c9+jv//Pb6OH/nSmRL1VCWBhsSK8xPraZx+hVGTR4fd33/1qLyT2LlKd0dVt" +
       "GdqVKHTWKjsz5DGYe0xxHdhRD43DSGgB2EGkZWzbsYkJb1weCGKdxSEwy/HW" +
       "WQEhICqGedj0FPt6EDf4OpQnkPD0VFcC36z3iZr8GKLOdhabHSCqVlbUIG4Q" +
       "FVEnA8fD0qKmxyjq9fDMcRabEyCqXVbUIG5GIugxpcVkYxQTTdbqLNQaIOZo" +
       "WTGDuBmps/nJPUb1lDjk+YXd+TGEnessNzdA2D1lhQ3izgsrDrClhN07RmGn" +
       "wdPmLNcWIOz+ssIGcYMDWPwMl6vNGnkVgv4bFZclPtG/Xkb0bGByi5iZIU1V" +
       "3NzGPxHiO517BPPUNwTxd2bQBQrH3qN7Dx5J9B5bhNiLjHdAuc4Mc6FGR6jm" +
       "mSrCkdxfKnXzayO37lj60tWK8/dPrSs+deJMLQFnygXB+cu/wOm9f5+2fvnw" +
       "5jEcJ2f59PdP+f3uE2dun6fcH+Y3X6LMKboxK2RqL8wXtRZlGUsvzBCteYs1" +
       "oSWwApEci0l+R3Q9hXvh/YVeWFuG1XdcyFXF+PuRMmPHsDnCSH2Kss7C5OA6" +
       "7HeuFWsFdTi+6OCvHyrWfLEj/uKxax7EWka7k2XGfojNcaF5rDDXuJr/4NPR" +
       "HMFnqSP+0rFrHsRaRrunyow9jc1PILxB8x43dblaP/np2bvdEb197FoHsZbR" +
       "7HSZsTPY/FLYuy9f8vs0f/YTa96MQ1gjrHDEXzF2zYNYy2j3cpmx32HzIpzo" +
       "QXNx2+impW+4up/9xLrzK6sYPB2OAh3X0H1B8S1QEKtPvzCXI4w/l/CX/dhs" +
       "ECp80dPfxEiFqhedC/CnnOXyXCh904I/b+EEf8XmdSbuJ8TWlVpm3IihJtzt" +
       "PD/27czCGu6VMF5oTC36Z0r8m6I8dqShesqRDX/g15L5fzzq4JCZzGia97zt" +
       "6UdMiyZVrlOdOH2L08olRlqvfVsNRyz+zYX/h+D8JyMzynHCruCXl+UKI1MC" +
       "WKDIER0v/ftQUPnpQRT+7aX7EDbPpYOpRMdLAie0CiCBLhR8Jao1cceRDRUW" +
       "TnmLTrqWRT211tyCSob/DZmrOjLij8i4cvLI2p6dlz93TFzRKpo8OoqzjIdz" +
       "p7gtzlcucwJny80VWTP/gwmP19yQq96ahMBuvE33AALEVshE95rmu7y02/J3" +
       "mK8dXfbMC/sjL8FJexMJyYxM3FR8G5Q1M1BWbYqVOmFDXcfvVdtr39x89r3X" +
       "Q8380o2IM3lLOY64cuCZ831J03woTGq6SCUUpzTLr6pu26FDbIxYBQf2yJCR" +
       "0fP/WE7AWJAxRvnOOBtan3+LV/zg7sW3F8V/e0C8b6fWKpwdp6n31XoZ0/SO" +
       "8p3dLCABdxp8LR7rNk3n2qa6lu+8aWKohyZy/PkfsHm4+2sgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
