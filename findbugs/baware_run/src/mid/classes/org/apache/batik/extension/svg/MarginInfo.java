package org.apache.batik.extension.svg;
public class MarginInfo {
    public static final int JUSTIFY_START = 0;
    public static final int JUSTIFY_MIDDLE = 1;
    public static final int JUSTIFY_END = 2;
    public static final int JUSTIFY_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int justification;
    protected boolean flowRegionBreak;
    public MarginInfo(float top, float right, float bottom, float left, float indent,
                      int justification,
                      boolean flowRegionBreak) { super();
                                                 this.top = top;
                                                 this.right = right;
                                                 this.bottom = bottom;
                                                 this.left = left;
                                                 this.indent = indent;
                                                 this.justification =
                                                   justification;
                                                 this.flowRegionBreak =
                                                   flowRegionBreak;
    }
    public MarginInfo(float margin, int justification) { super();
                                                         setMargin(
                                                           margin);
                                                         this.indent =
                                                           0;
                                                         this.justification =
                                                           justification;
                                                         this.flowRegionBreak =
                                                           false;
    }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getJustification() { return justification; }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1afZAUxRXv3fv+4j6QDw/ugOPA4tTdEDWQnBHhPriFveNy" +
                                                              "d1DxMC6zs717A7Mzw0zvsZwhBpMIZRLLUjAkUWJVMB8WipVoJaWlwXypZQzl" +
                                                              "RyV+VNToH2rURCqlGEli3uuZ3Zmd3RlcispVbe9cd79+7/fe6/de9+zRd0mV" +
                                                              "oZMuTVASQojt1qgRGsXnUUE3aKJPFgxjAnpj4o1/vfW6U8/W7Q2S6kkya0ow" +
                                                              "hkXBoIMSlRPGJOmQFIMJikiNEUoTSDGqU4Pq0wKTVGWSzJGMSFqTJVFiw2qC" +
                                                              "4oQtgh4lrQJjuhTPMBqxFmBkUZRLE+bShNe6J/RGSaOoarttgvYCgj7HGM5N" +
                                                              "2/wMRlqi24VpIZxhkhyOSgbrzerkQk2Vd6dklYVoloW2y5dZitgQvaxIDV33" +
                                                              "NX9w+uapFq6G2YKiqIxDNMaoocrTNBElzXbvgEzTxk7yFVIRJQ2OyYx0R3NM" +
                                                              "w8A0DExzeO1ZIH0TVTLpPpXDYbmVqjURBWJkSeEimqALaWuZUS4zrFDLLOyc" +
                                                              "GNAuzqPNmdsF8eCF4QPfuablZxWkeZI0S8o4iiOCEAyYTIJCaTpOdWNtIkET" +
                                                              "k6RVAYOPU10SZGnGsnabIaUUgWXABXJqwc6MRnXO09YVWBKw6RmRqXoeXpI7" +
                                                              "lfVfVVIWUoB1ro3VRDiI/QCwXgLB9KQAvmeRVO6QlAT3o0KKPMbujTABSGvS" +
                                                              "lE2peVaVigAdpM10EVlQUuFxcD4lBVOrVHBBnfuax6Koa00QdwgpGmNkvnve" +
                                                              "qDkEs+q4IpCEkTnuaXwlsFK7y0oO+7w7cvlN1ypDSpAEQOYEFWWUvwGIOl1E" +
                                                              "YzRJdQr7wCRs7IneJsx9eH+QEJg8xzXZnPOLL5+88qLO44+bcxaUmLMpvp2K" +
                                                              "LCYeic96emHfis9WoBi1mmpIaPwC5HyXjVojvVkNIs3c/Io4GMoNHh/7/VVf" +
                                                              "vZu+HST1EVItqnImDX7UKqppTZKpvp4qVBcYTURIHVUSfXw8QmrgOSop1Ozd" +
                                                              "lEwalEVIpcy7qlX+P6goCUugiurhWVKSau5ZE9gUf85qhJAa+JBG+JxPzD/+" +
                                                              "zcj28JSapmFBFBRJUcOjuor40aA85lADnhMwqqnhOPj/jotXhlaFDTWjg0OG" +
                                                              "VT0VFsArpqg5iPuUKgYgDhvTqfCwoKckJQIyhdDntP8rtyxin70rEACzLHQH" +
                                                              "BRn205AqJ6geEw9k1g2cvDf2pOlwuEksrTGyAliGTJYhzjKUZxkCliGbJQkE" +
                                                              "OKfzkLVpfDDdDggCEIUbV4x/acO2/V0V4HXarkrQexCmLi/KSn12tMiF+Jh4" +
                                                              "9OmxUyeeqr87SIIQUOKQlezU0F2QGszMpqsiTUBs8koSuUAZ9k4LJeUgxw/t" +
                                                              "2rvluk9xOZzRHhesgkCF5KMYo/Msut27vNS6zfve/ODYbXtUe78XpI9c1iui" +
                                                              "xDDS5barG3xM7FksPBB7eE93kFRCbIJ4zATYPxDqOt08CsJJby40I5ZaAJxU" +
                                                              "9bQg41AuntazKV3dZfdwh2vlz+eBiRtwf82BT4+14fg3js7VsJ1nOij6jAsF" +
                                                              "D/2fH9fueP6Pb13C1Z3LEs2O9D5OWa8jMuFibTwGtdouOKFTCvP+cmj01oPv" +
                                                              "7tvK/Q9mLC3FsBvbPohIYEJQ8zce3/nCKy8feS6Y99kAg9SciUOVk82DxH5S" +
                                                              "7wMS/dyWByKbDPsdvaZ7swJeKSUlIS5T3CT/bl628oF3bmox/UCGnpwbXXTm" +
                                                              "Bez+89eRrz55zalOvkxAxMxq68yeZobr2fbKa3Vd2I1yZPc+0/Hdx4Q7IPBD" +
                                                              "sDWkGWrGT66DGgO92rFvsdwbz8QNNqpLaTDEtJWMjs09tfO3NTP9uURTisSc" +
                                                              "udEYPvHg0Bsxbuha3N/Yj9ibHDt3rZ5yeFmLaYCP4S8An//iBxWPHWZYb+uz" +
                                                              "csvifHLRtCxIv8KnGiyEEN7T9sqO29+8x4TgTr6uyXT/gRs/Dt10wLSeWaEs" +
                                                              "LSoSnDRmlWLCwWY1SrfEjwunGHzj2J6HfrJnnylVW2G+HYBy8p4//ecPoUOv" +
                                                              "PlEinMM2UgWzzrwEHdp0a562XfYxQVWvvONf193w/CaIHRFSm1GknRkaSThX" +
                                                              "hSLLyMQdBrOrH97hhIfGYSTQA3bAjlWuhot1maUJ/Pqc4/kKRiokpUh0/Lc/" +
                                                              "eybKmriqylRQSlNzYS7lY+H8DMJnED72BWy6DWc4L3QdR00fE29+7r2mLe89" +
                                                              "cpKrv/BQ4Ixew4Jm2r4Vm2Vo+3nu1DkkGFMw79LjI1e3yMdPw4qTsKIIpYCx" +
                                                              "SYfUnS2IddbsqpoXH/3N3G1PV5DgIKkHeycGBZ42SB3Ea2pMQdbPamuuNMPV" +
                                                              "rlpoWjhUUgQeI8Si0rFnIK0xHi1mfjnv/st/fPhlHib5Ch3FGWC1FRxXl84A" +
                                                              "2C7Hpqc4rnqRuuwVNKuKvDcN8qW3+Vg1js1WPjSGzdWmu2z+ZJrBjkmTYgHv" +
                                                              "azDw6OUuaPj52c7F77z0/dd/deqHNebe9YlELrr5H22S49e/9mGRT/HSo0Rw" +
                                                              "ctFPho/e3t53xduc3q4BkHpptrg6hCrJpv303en3g13VvwuSmknSIlpn1S2C" +
                                                              "nMHMOgnnMyN3gIXzbMF44VnLPFj05muche7o6GDrrj6cAaeSFQQXu+CYj6YJ" +
                                                              "w6fd8pl2t7vxCtXcMihSKAJHyxTV216788ipvftWBzHjVU2j6KCVFnveSAaP" +
                                                              "xDccPdjRcODVb3JXzy1tFnvLebsCm4u4O1Tg48VQMBj8dI2hV1IE2VU4zPMR" +
                                                              "lpGmDZvHJyKDV8XGJ9aOTXCvtvcL91nlTD6bKlbOAovfghLKwQc1Fxln/JBh" +
                                                              "w+uTTAlIXiwYmZWDNBzp748OlMJ07VlgWmgxXOiDiceGr501Ji8WjDTkMA2M" +
                                                              "9JcC9PWzANRhcevwAcSF/tZZA/JiwUhjDtDg5mi0FKJvf3JEs3Kuvchit6gI" +
                                                              "EeEPB0sDgZq7TtNVBpGDJlwomnyWhXKBqVo+HTiEv61M4dHgiy0uiz2EP2yn" +
                                                              "sEPFMnpRQ1DQpdQUKyXlD8qUEq24xOKzxEPKu3yl9KKGGBZXGVPTpcT8UZli" +
                                                              "YkToshh1eYh51FdML2oGRyaaLKnLe85Cl90Wm24PIX/uK6QXNegSKniqlBTz" +
                                                              "/jLFxMWXW4yWe4j5oK+YXtSQerZnDAZHS1HIHa3dMeChMqVFHhdY/C7wkPZR" +
                                                              "X2m9qKGuhmPNrjGaAlHX6VTYgd0bXfL+2kfebKkKlP9VE9d9oYOvo/gjWL53" +
                                                              "eF3p8mPbkesPHE5sumtl0Co/10Bggwh1sUynqexYqpYfAt115DC/yLaLslXP" +
                                                              "nKp46Zb5jcV3YrhSp8eNV493welm8Nj1f2ufuGJqWxmXXYtc+N1L/nT46BPr" +
                                                              "l4u3BPldvFkDFt3hFxL1FlZ+9TplGV0pPFx2FR430DvWWBZb4/Yz2ye8jhte" +
                                                              "pK6DhOMAuYqv+rzPSeNFbJ4FexuUmRempQ6pldOqlLD99bnyjyO8+0Qe02wc" +
                                                              "wrw4aGEaLF8dXqQ+aN/wGXsLm9egwkhRNqFqpjK4Em3gr58b4JjG1lvSry8f" +
                                                              "uBepD7h/+oy9j83fof4F4GOY80tC/8e5gY6pcciSf6h86F6kPvA+9h4L8E3y" +
                                                              "EQRpgL6OFxIlsZ8+N9gXwydiAYiUj92L1Adfg89YEzbVkE4BexSqk1LIAzXn" +
                                                              "BjnWqRst8TeWj9yL1Aed39j52LRBzAPkEbvksVHPPjeol8Jn2BJ9uHzUXqQ+" +
                                                              "yJb6jC3DppORFkC9oaiCssEvOjfgsQIcsRCMlA/ei9QHYNhnbCU2PYy0SsZg" +
                                                              "iXrMRn/hWdy0MVJvv2vEe8n5RT9zMF/Ni/cebq6dd3jzn/n7rvzr88YoqU1m" +
                                                              "ZNl5j+R4rtZ0mpS4zhrNWyV+Rx1YzUin/ytQOGhCi2IHVpk0vYy0e9PAlsg/" +
                                                              "O6mgAmhxU8EBkX87560FTdjz4EBhPjin9INMMAUfB8wr2fnMeZtlXsRlA4UF" +
                                                              "bD4SzzmTeRw179KCipL/QCVX/WXMn6jExGOHN4xce/Izd5kv8kRZmJnBVRqi" +
                                                              "pMZ8p5ivIJd4rpZbq3poxelZ99Uty1XRrabAtq8vcGSlSajQNPSVdtdbLqM7" +
                                                              "/7LrhSOXP/LU/upngiSwlQQERmZvLb6yzGoZKG+3Rku9JIH6mr+A661/fduJ" +
                                                              "D18MtOVuB/GqsdOPIibe+shLo0lN+16Q1EVIFZ4Ms/w+tX+3MkbFab3gnQuc" +
                                                              "wjNK/rcss9CxBfzxCteMpdCmfC++CGakq/gFVPHL8XrYrFRfh6vjMk2umjuj" +
                                                              "ac5Rrtk+bFZnUdPga7HosKZZb96q7+Sa1zTct4Ev4j/9/wPOvHj6hSYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XdDsQILU8RHWMbnH3iq55+HDHpBj335y");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("779H3gez4JmocB2So+84Czvm+Oxb5Zgd2Q0OOA7efo7le+Rlp43nPgRXHUZI" +
       "nnGmdkzyw/d1mycqXDm+xZpdyXv8jgv0u0vfyq+9du3Se14b/6f8IufRxezL" +
       "TOHSMrbtk1dbTsQv+AFYGjnxy7uLLn7O5gejwlP3vlwbFc7DMAN8rrGr85Go" +
       "cOPudaBqH8VP1voYVIvTtaLCg/nfk+XacCSOy0WFC7vIySIkxASLZNGuf8bB" +
       "4e5uUHru9gXakX189HsJ5sSa7vnbVmL5vz4crpri3T8/3FK+8ho9+Ik3ar+0" +
       "u6Gq2PJ2m7VyiSlc3F2WPVp5PXvX1g7butB74btXv3r5/YerxKs7wMcqfQLb" +
       "02dfByUcP8ovcG7/+Xv+6Q/9k9f+OL9h9P8AmLd8OZMyAAA=");
}
