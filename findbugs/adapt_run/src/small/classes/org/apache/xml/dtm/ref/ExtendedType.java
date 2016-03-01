package org.apache.xml.dtm.ref;
public final class ExtendedType {
    private int nodetype;
    private java.lang.String namespace;
    private java.lang.String localName;
    private int hash;
    public ExtendedType(int nodetype, java.lang.String namespace, java.lang.String localName) {
        super(
          );
        this.
          nodetype =
          nodetype;
        this.
          namespace =
          namespace;
        this.
          localName =
          localName;
        this.
          hash =
          nodetype +
            namespace.
            hashCode(
              ) +
            localName.
            hashCode(
              );
    }
    public ExtendedType(int nodetype, java.lang.String namespace,
                        java.lang.String localName,
                        int hash) { super();
                                    this.nodetype = nodetype;
                                    this.namespace = namespace;
                                    this.localName = localName;
                                    this.hash = hash; }
    protected void redefine(int nodetype, java.lang.String namespace,
                            java.lang.String localName) { this.nodetype =
                                                            nodetype;
                                                          this.namespace =
                                                            namespace;
                                                          this.localName =
                                                            localName;
                                                          this.hash =
                                                            nodetype +
                                                              namespace.
                                                              hashCode(
                                                                ) +
                                                              localName.
                                                              hashCode(
                                                                );
    }
    protected void redefine(int nodetype, java.lang.String namespace,
                            java.lang.String localName,
                            int hash) { this.nodetype = nodetype;
                                        this.namespace = namespace;
                                        this.localName = localName;
                                        this.hash = hash; }
    public int hashCode() { return hash; }
    public boolean equals(org.apache.xml.dtm.ref.ExtendedType other) {
        try {
            return other.
                     nodetype ==
              this.
                nodetype &&
              other.
                localName.
              equals(
                this.
                  localName) &&
              other.
                namespace.
              equals(
                this.
                  namespace);
        }
        catch (java.lang.NullPointerException e) {
            return false;
        }
    }
    public int getNodeType() { return nodetype; }
    public java.lang.String getLocalName() { return localName; }
    public java.lang.String getNamespace() { return namespace; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZC3BU1Rk+uwl5kZAHEpBHgBCYAWG3oBTbUBQCMcFNyCRA" +
                                                              "22Bdbu6eTS7cvfdy79mwIBRltDAOw1BBxSrMtMXWMjwcR6etHSl9qqOUAZ0W" +
                                                              "ZJS2tqMWmZHOKLS00v8/5+7exz4w4jQz9+TuOf9/zv863/+fcw9dJMMskzQa" +
                                                              "khaTQmyDQa1QF753SaZFYy2qZFnLoTcqP/yX3Vsuv1H+QJCU9JIRA5LVIUsW" +
                                                              "bVWoGrN6yQRFs5ikydTqpDSGHF0mtag5KDFF13rJKMVqTxiqIiusQ49RJFgp" +
                                                              "mRFSKzFmKn1JRtvtCRiZGOHShLk04YV+guYIqZR1Y4PDMNbD0OIaQ9qEs57F" +
                                                              "SE1kjTQohZNMUcMRxWLNKZPcYujqhn5VZyGaYqE16lzbEEsjc7PM0Phs9SdX" +
                                                              "dw3UcDOMlDRNZ1xFq5taujpIYxFS7fQuUWnCWke+TYoiZLiLmJGmSHrRMCwa" +
                                                              "hkXT+jpUIH0V1ZKJFp2rw9IzlRgyCsTIZO8khmRKCXuaLi4zzFDGbN05M2g7" +
                                                              "KaNt2t0+FR+9Jbzn8Xtrnisi1b2kWtF6UBwZhGCwSC8YlCb6qGktjMVorJfU" +
                                                              "auDwHmoqkqpstL1dZyn9msSSEAJps2Bn0qAmX9OxFXgSdDOTMtPNjHpxHlT2" +
                                                              "r2FxVeoHXesdXYWGrdgPClYoIJgZlyD2bJbitYoW43Hk5cjo2HQ3EABraYKy" +
                                                              "AT2zVLEmQQepEyGiSlp/uAeCT+sH0mE6hKDJYy3PpGhrQ5LXSv00ysgYP12X" +
                                                              "GAKqcm4IZGFklJ+MzwReGuvzkss/Fzvn77xPa9OCJAAyx6isovzDganBx9RN" +
                                                              "49SksA8EY+WMyGNS/Uvbg4QA8SgfsaD56aZLd85sOP6KoBmXg2ZZ3xoqs6h8" +
                                                              "oG/EqfEt079ShGKUGbqloPM9mvNd1mWPNKcMQJr6zIw4GEoPHu/+/TfvP0gv" +
                                                              "BElFOymRdTWZgDiqlfWEoajUvItq1JQYjbWTcqrFWvh4OymF94iiUdG7LB63" +
                                                              "KGsnxSrvKtH5bzBRHKZAE1XAu6LF9fS7IbEB/p4yCCFV8JA6eMYR8cf/MxIL" +
                                                              "D+gJGpZkSVM0Pdxl6qg/OpRjDrXgPQajhh5OSRA0s9ZE50TnReeELVMO62Z/" +
                                                              "WIKoGKDhVEINx1gibNJ4eEmKgcACKEMYbcb/aZ0U6jtyfSAArhjvBwIV9lCb" +
                                                              "rsaoGZX3JBctuXQk+poIMtwYtqUYmQKLhcRiIVgsBIuFYLGQezESCPA1bsJF" +
                                                              "havBUWthywPmVk7v+dbS1dsbiyDGjPXFYOUgkE7LykEtDjakAT0qHzrVffnk" +
                                                              "iYqDQRIE+OiDHOQkgiZPIhB5zNRlGgMkypcS0rAYzp8EcspBju9d/8DKLV/i" +
                                                              "crixHSccBrCE7F2IyJklmvx7Ote81dve/+ToY5t1Z3d7kkU6x2VxImg0+j3q" +
                                                              "Vz4qz5gkvRB9aXNTkBQDEgH6Mgl2CwBbg38ND3g0p4EYdSkDheO6mZBUHEqj" +
                                                              "ZwUbMPX1Tg8PtVr+fhO4eDjuptHwzLC3F/+Po/UGtqNFaGLM+LTgQP+1HmPf" +
                                                              "mT98cCs3dzonVLuSeQ9lzS4cwsnqOOLUOiG43KQU6N7e27X70YvbVvH4A4op" +
                                                              "uRZswrYF8AdcCGZ+6JV1Z8+/c+DNYCZmAwwScbIPappURknsJxUFlMQ4d+QB" +
                                                              "HFNhj2PUNK3QICqVuCL1qRQ3yX+qp85+4cOdNSIOVOhJh9HM60/g9N+8iNz/" +
                                                              "2r2XG/g0ARnzqGMzh0yA80hn5oWmKW1AOVIPnJ7wxMvSPoB5gFZL2Ug5WhZx" +
                                                              "GxRZGNWufYvFXU+yz2JdppIARwzaqedo/eV1vy3duDidVnKxCMq7rY6TL7a9" +
                                                              "F+WOLsP9jf2oe5Vr5y40+11RViMccA3+AvB8ig8aHjsEiNe12JlkUiaVGEYK" +
                                                              "pJ9eoPbzqhDeXHd+7VPvHxYq+FOtj5hu3/PwtdDOPcJ7oh6ZklUSuHlETSLU" +
                                                              "weZ2lG5yoVU4R+t7Rzf/4pnN24RUdd7sugSKx8N//O/rob1/fjUHkBcpdk15" +
                                                              "K4azCGqeon3eESqVzN73ry3fObMMkKOdlCU1ZV2Stsfcc0JBZSX7XO5yKh3e" +
                                                              "4VYOXcNIYAZ6AXvGQGnOow/LrpAou7C/lTPdxmnCGWEJF5bwsXZsmiw3vHpd" +
                                                              "6aqoo/KuNz+qWvnRsUvcHN6S3I0mHZIhfFGLzVT0xWh/KmuTrAGgu+145z01" +
                                                              "6vGrMGMvzChDHWotMyGJpjzYY1MPK33rV7+pX32qiARbSYWqS7FWicM4KQf8" +
                                                              "pNYA5N+UccedAj7Wl0FTw1UlWcrjjp2YGwuWJAzGd+/Gn41+fv6P97/DYYvP" +
                                                              "MCEbkZttsGrOjcjYTsNmRjbO5WP1+auYi1yMP+dxr2aaeXyRbxTwby82PXxo" +
                                                              "KTbLRcB0fDYbYUe34BgnhLDwCOQvNfg51smSH5578t1fXv5hqdhVBTDCxzfm" +
                                                              "38vUvq1/vZIVXbwoyAEbPv7e8KGnxrYsuMD5neyM3FNS2RUb1C8O75yDiY+D" +
                                                              "jSW/C5LSXlIj22fGlZKaxJzXC+ckK32QhHOlZ9x75hEFfnOm+hjvxy3Xsv66" +
                                                              "wA0Gxcyz8Z1SoBJdczM8E+zomeAPvADhL6KSmMbb6djMTGfeUsNUBgHFfal3" +
                                                              "eIFJGSnTAMzSQs1zgpuHVfx6YRX1yo/TN9hLNeSRX3P2zkC2oPm4GSlHK1pQ" +
                                                              "YdPMPnFJqn8OSSfaa03MI2myoKT5uEFSVZcltdN2ul/SwSFKOgqeSfZak/JI" +
                                                              "uqmgpPm4GSkeAADO5fjNBYRM5Q7AIL7OYhD6iiapTgzyP9TEc4T0w+I4G5sA" +
                                                              "iCbkO+Xz3H5g6579sWVPzw7aSHgH2JvpxiyVDlLVNVUprxT8kNbB7zYcfJh3" +
                                                              "+nLRuUfGVGYfnHCmhjzHohn5sc+/wMtb/zF2+YKB1UM4EU306e+f8icdh169" +
                                                              "a5r8SJBfzwg4yrrW8TI1e0GowqQsaWreGqQx47ER6IkOeNpsj7X5w86VA3Pg" +
                                                              "ULlh6gzQksZ8SFRVYE5fsrNLaV9y5As/XiAvPoHNLkA1k8YoBKIAy69ic7sQ" +
                                                              "ZgFE/aCuxJxY/+7Qcyfv3uE12NfhWWErt6KAwbDZnW2XfKxDLBp+VMA4z2Dz" +
                                                              "fZdx8PeTjiF+cMOGqMYhrJ5W29qsvo4hclRP+VgLKPZcgbHnsTkMSiPUtcBm" +
                                                              "5rZylD5yw0qPxCHM3GttydcOXel8rD7F0ucR/D3ms1068cWPFTDQr7H5OZzb" +
                                                              "6bqkpFqcZq5rw/g2T2mfrqtU0vwy4c/FKceuL34xwTQWnk22cTYN3a75WAvY" +
                                                              "41SBsTeweZ2R4f2UddqJwRdPJ25Yb7xu5fXPg7bwDw5d73ysBXR7u8DYeWzO" +
                                                              "MFIJekc8xY2j+NkvTvEdtvQ7hq54PtYCyn1QYOwCNn8Tind66k9H8b9/jrMX" +
                                                              "zOjepHhqHZP1CUp8NpGP7K8uG71/xZ/47WTm00ZlhJTFk6rqPlu43ksMAAKF" +
                                                              "61ApThoG//dPRupzowYjRdBygS8J2o/hCJRNC3TQuumuMDLCSwc00LpprjJS" +
                                                              "4dAA2ogXN8mnwAUk+HrNSEOc6/5DHMFSAW+9mHHDqOu5wVViTvEUcPwTYbrY" +
                                                              "SoqPhFH56P6lnfdd+vLT4nJVVqWNG3GW4RFSKu55MwXb5LyzpecqaZt+dcSz" +
                                                              "5VPTRWutENgJ53GumOsGNDUwIsb6bh6tpswF5NkD84+d2F5yGs7Eq0hAYmTk" +
                                                              "quzDaspIQjW5KpLr6grKWX4p2lzx7uqTV94K1PHLECIuuxoKcUTl3cfOdcUN" +
                                                              "43tBUt5OhkFNTlP8JL14g9ZN5UHTcxNW0qcntczXxBEYvhLeY3HL2AatyvTi" +
                                                              "5TwjjdmXgtkfLCpUfT01F+HsOE2Vr8RNGoZ7lFu2RaQytDTEWjTSYRjp29B7" +
                                                              "uOUNA/dnoI4ns/8B+b+f5AcgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KwAA");
}
