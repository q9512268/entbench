package org.apache.batik.svggen.font.table;
public class Os2Table implements org.apache.batik.svggen.font.table.Table {
    private int version;
    private short xAvgCharWidth;
    private int usWeightClass;
    private int usWidthClass;
    private short fsType;
    private short ySubscriptXSize;
    private short ySubscriptYSize;
    private short ySubscriptXOffset;
    private short ySubscriptYOffset;
    private short ySuperscriptXSize;
    private short ySuperscriptYSize;
    private short ySuperscriptXOffset;
    private short ySuperscriptYOffset;
    private short yStrikeoutSize;
    private short yStrikeoutPosition;
    private short sFamilyClass;
    private org.apache.batik.svggen.font.table.Panose panose;
    private int ulUnicodeRange1;
    private int ulUnicodeRange2;
    private int ulUnicodeRange3;
    private int ulUnicodeRange4;
    private int achVendorID;
    private short fsSelection;
    private int usFirstCharIndex;
    private int usLastCharIndex;
    private short sTypoAscender;
    private short sTypoDescender;
    private short sTypoLineGap;
    private int usWinAscent;
    private int usWinDescent;
    private int ulCodePageRange1;
    private int ulCodePageRange2;
    protected Os2Table(org.apache.batik.svggen.font.table.DirectoryEntry de,
                       java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        version =
          raf.
            readUnsignedShort(
              );
        xAvgCharWidth =
          raf.
            readShort(
              );
        usWeightClass =
          raf.
            readUnsignedShort(
              );
        usWidthClass =
          raf.
            readUnsignedShort(
              );
        fsType =
          raf.
            readShort(
              );
        ySubscriptXSize =
          raf.
            readShort(
              );
        ySubscriptYSize =
          raf.
            readShort(
              );
        ySubscriptXOffset =
          raf.
            readShort(
              );
        ySubscriptYOffset =
          raf.
            readShort(
              );
        ySuperscriptXSize =
          raf.
            readShort(
              );
        ySuperscriptYSize =
          raf.
            readShort(
              );
        ySuperscriptXOffset =
          raf.
            readShort(
              );
        ySuperscriptYOffset =
          raf.
            readShort(
              );
        yStrikeoutSize =
          raf.
            readShort(
              );
        yStrikeoutPosition =
          raf.
            readShort(
              );
        sFamilyClass =
          raf.
            readShort(
              );
        byte[] buf =
          new byte[10];
        raf.
          read(
            buf);
        panose =
          new org.apache.batik.svggen.font.table.Panose(
            buf);
        ulUnicodeRange1 =
          raf.
            readInt(
              );
        ulUnicodeRange2 =
          raf.
            readInt(
              );
        ulUnicodeRange3 =
          raf.
            readInt(
              );
        ulUnicodeRange4 =
          raf.
            readInt(
              );
        achVendorID =
          raf.
            readInt(
              );
        fsSelection =
          raf.
            readShort(
              );
        usFirstCharIndex =
          raf.
            readUnsignedShort(
              );
        usLastCharIndex =
          raf.
            readUnsignedShort(
              );
        sTypoAscender =
          raf.
            readShort(
              );
        sTypoDescender =
          raf.
            readShort(
              );
        sTypoLineGap =
          raf.
            readShort(
              );
        usWinAscent =
          raf.
            readUnsignedShort(
              );
        usWinDescent =
          raf.
            readUnsignedShort(
              );
        ulCodePageRange1 =
          raf.
            readInt(
              );
        ulCodePageRange2 =
          raf.
            readInt(
              );
    }
    public int getVersion() { return version; }
    public short getAvgCharWidth() { return xAvgCharWidth; }
    public int getWeightClass() { return usWeightClass; }
    public int getWidthClass() { return usWidthClass; }
    public short getLicenseType() { return fsType; }
    public short getSubscriptXSize() { return ySubscriptXSize; }
    public short getSubscriptYSize() { return ySubscriptYSize; }
    public short getSubscriptXOffset() { return ySubscriptXOffset;
    }
    public short getSubscriptYOffset() { return ySubscriptYOffset;
    }
    public short getSuperscriptXSize() { return ySuperscriptXSize;
    }
    public short getSuperscriptYSize() { return ySuperscriptYSize;
    }
    public short getSuperscriptXOffset() { return ySuperscriptXOffset;
    }
    public short getSuperscriptYOffset() { return ySuperscriptYOffset;
    }
    public short getStrikeoutSize() { return yStrikeoutSize; }
    public short getStrikeoutPosition() { return yStrikeoutPosition;
    }
    public short getFamilyClass() { return sFamilyClass; }
    public org.apache.batik.svggen.font.table.Panose getPanose() {
        return panose;
    }
    public int getUnicodeRange1() { return ulUnicodeRange1; }
    public int getUnicodeRange2() { return ulUnicodeRange2; }
    public int getUnicodeRange3() { return ulUnicodeRange3; }
    public int getUnicodeRange4() { return ulUnicodeRange4; }
    public int getVendorID() { return achVendorID; }
    public short getSelection() { return fsSelection; }
    public int getFirstCharIndex() { return usFirstCharIndex; }
    public int getLastCharIndex() { return usLastCharIndex; }
    public short getTypoAscender() { return sTypoAscender; }
    public short getTypoDescender() { return sTypoDescender; }
    public short getTypoLineGap() { return sTypoLineGap; }
    public int getWinAscent() { return usWinAscent; }
    public int getWinDescent() { return usWinDescent; }
    public int getCodePageRange1() { return ulCodePageRange1; }
    public int getCodePageRange2() { return ulCodePageRange2; }
    public int getType() { return OS_2; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1cDXAcxZXuXVm/li3JxrLjH9mWZYN/2MV/ECwTELJlCyRb" +
                                                              "JRn5LB+I0exIGjzaGc/0ypI5H7FTxCZXEIJtfpLYKSp2EsCOA3ccR1Im5jgO" +
                                                              "fBy4TAIJuIDjOEIu4Co4cnES7sK919O7szu73fJstk5V0zua7tfv+7pfv37T" +
                                                              "PTPHzpNixyb1lhKPKRE6amlOpAPPOxTb0WLNhuI4m+Bqr/q1d/ffceFn5bvD" +
                                                              "pKSHTBxUnHZVcbQWXTNiTg+ZpccdqsRVzdmgaTGU6LA1R7OHFaqb8R4yRXda" +
                                                              "hyxDV3XabsY0LNCt2G2kRqHU1vsSVGvlFVAyu42hiTI00SZ/gcY2Uqma1qgn" +
                                                              "MD1DoDktD8sOefocSqrbblOGlWiC6ka0TXdo44hNFlumMTpgmDSijdDIbcZK" +
                                                              "3hA3tK3Maob6H1X97rN7B6tZM0xW4nGTMopOp+aYxrAWayNV3tW1hjbkbCd/" +
                                                              "TYrayPi0wpQ0tCWVRkFpFJQm+XqlAP0ELZ4YajYZHZqsqcRSERAlczMrsRRb" +
                                                              "GeLVdDDMUEMZ5dyZMLCdk2Kb7G4fxYOLowceuKX6iSJS1UOq9HgXwlEBBAUl" +
                                                              "PdCg2lCfZjtNsZgW6yE1cejwLs3WFUPfyXt7kqMPxBWaABNINgteTFiazXR6" +
                                                              "bQU9CdzshEpNO0WvnxkV/6+431AGgGutx9Vl2ILXgWCFDsDsfgVsj4uM26bH" +
                                                              "Y8yOMiVSHBtuhAIgWjqk0UEzpWpcXIELZJJrIoYSH4h2gfHFB6BosQkmaDNb" +
                                                              "E1SKbW0p6jZlQOulZJq/XIebBaXKWUOgCCVT/MVYTdBL0329lNY/5zesvuf2" +
                                                              "+Pp4mIQAc0xTDcQ/HoTqfEKdWr9mazAOXMHKRW33K7Un94UJgcJTfIXdMk/9" +
                                                              "1SfXLak79aJbZkaOMhv7btNU2qse6Zt4dmbzwquLEEaZZTo6dn4GczbKOnhO" +
                                                              "44gFnqY2VSNmRpKZpzr/ecuXH9U+DJOKVlKimkZiCOyoRjWHLN3Q7HVaXLMV" +
                                                              "qsVaSbkWjzWz/FZSCudtelxzr27s73c02krGGexSicn+hybqhyqwiSrgXI/3" +
                                                              "m8lzS6GD7HzEIoSUwkEWwDGTuH/slxIjOmgOaVFFVeJ63Ix22Cbyxw5lPkdz" +
                                                              "4DwGuZYZ7QP733b50shVUcdM2GCQUdMeiCpgFYOamxl1hgcGtHi0H1oqSpU+" +
                                                              "Q4tudJZtwpMIWp31/6xvBPlP3hEKQdfM9DsGA8bUetOIaXaveiBx/dpPftj7" +
                                                              "kmt0OFB4y1GyGJRGXKURpjTiKo2g0ghTGkkqJaEQ03UJKndNADpwG7gC8MWV" +
                                                              "C7tuvuHWffVFYHvWjnHQ+lh0Qdbc1Oz5jKSj71WPne28cOblikfDJAxupQ/m" +
                                                              "Jm+CaMiYINz5zTZVLQYeSjRVJN1lVDw55MRBTj24Y3f3HVcwHOk+HyssBneF" +
                                                              "4h3oqVMqGvxjPVe9VXt//bsT9+8yvVGfMYkk574sSXQm9f6e9ZPvVRfNUZ7s" +
                                                              "PbmrIUzGgYcCr0wVGEXg8Or8OjKcSmPSQSOXMiDcb9pDioFZSa9aQQdtc4d3" +
                                                              "hZlcDTu/BLp4Io6yWjiu5cOO/WJurYXpVNdE0WZ8LNgEcE2XdeiXr/znctbc" +
                                                              "ybmiKm2S79JoY5p/wsomMU9U45ngJlvToNxbD3bsP3h+71Zmf1BiXi6FDZg2" +
                                                              "g1+CLoRmvvPF7W+88/aRn4c9m6Wk3LJNCoNWi42keGIWmSDhiabuQQIXZ0AN" +
                                                              "aDgNN8XBMPV+HQcQjpP/qZq/9MmP7ql2TcGAK0lLWjJ2Bd71L1xPvvzSLRfq" +
                                                              "WDUhFadYr9m8Yq7fnuzV3GTbyijiGNn96qyHXlAOwQwAXtfRd2rMkYZZM4QZ" +
                                                              "82mULL0I97BGtzU02tG1cWqPJiWnMZ26GemEEWsONang4ZwWcObMJFawYlGW" +
                                                              "Lsd25x6DC09OCrduXDuiahZSYXKrMGlw0odd5shOi8B61Xt//vGE7o+f+YQ1" +
                                                              "UmYIl25l7YrV6Bo2JvNHoPqpfhe3XnEGodyKUxv+sto49RnU2AM1MlIbbXCy" +
                                                              "Ixk2yUsXl7757HO1t54tIuEWUmGYSqxFYcOblMO40pxB8M8j1rXXuTa1owyS" +
                                                              "ajwbIamGIaxhXJOendtA1g5ZlHXpzn+Y+nerv3/4bWbOrvHOYOJzHIwc/Z6Y" +
                                                              "hf+eE/no3Lfe++mF75a6wcNCsef0yU3740ajb8+//z6rkZnPzBHY+OR7ose+" +
                                                              "Pb35Sx8yec95ofS8keyJDdy7J7vs0aH/DteXPB8mpT2kWuWhdrdiJNAl9EB4" +
                                                              "6STjbwjHM/IzQ0U3LmpMOeeZfseZptbvNr0JFc6xNJ5P8HnKSuzFaXDUcQ9S" +
                                                              "5/eUIcJO2pnIApYuxGRJ0jGVWrYOt2Sazy2Nl1QKQsMQ7WNv4JBJswC8ketK" +
                                                              "9Dm0w9aHwLkO8zDzRO2F7f9UunNNMoTMJeKWvNFpP/Pj9R/0MuddhnP2piT3" +
                                                              "tNm4yR5ImzmqXeifw18Ijj/hgZDxghuwTWrmUeOcVNhoWTgiJQbpoxDdNemd" +
                                                              "bd/+9XGXgt/6fIW1fQe+9nnkngOuO3bvPeZlhf/pMu79h0sHk82Ibq5MC5No" +
                                                              "+eDErp/8YNdeF9WkzEh6LdwoHn/9f/818uC/nc4RpBXp/P4x3VViOO7rHZdS" +
                                                              "ydJDf7jjq7/cCNFAKylLxPXtCa01lmmnpU6iL627vLsaz3Y5OewaSkKLoBfc" +
                                                              "uRzTazDZ4BridUL/tS7T+ufAMZsb6myB9bvGsgCTjmwzF0lTgNw0PNA8qNib" +
                                                              "9RgdZJKbeOfgz5a085spKQbPa2e1KP6r+kkOBiRZx4kmCeci6UhJiqSBZMLZ" +
                                                              "rOkDg5TdT+LFbh9aGhDtLDjmcn1zBWh3StGKpCmpBLTYGUKwtwcE+wU46rm6" +
                                                              "egHY3VKwImlKSvqdpPUbPph7AsLEyudxRfMEMPdJYYqkIWoZRQes2rpF/6IL" +
                                                              "QrZceO/KA28D19ggwPt1KV6RdAbeLSK89wbEi1rmc43zBXjvl+IVSVNSk9a+" +
                                                              "7opELsQP5IF4Ade5QID4kBSxSDoD8RYx4sN5IL6U67xUgPiIFLFI2kUMk80Y" +
                                                              "Vnw0D8SXcZ2XCRA/JkUskvYhFtrxsYCIsS8Xcp0LBYifkCIWScP9U0Ybi+3i" +
                                                              "b/PAvIhrXSTA/LQUs0jah1liyz8OiBlnpsVc62IB5lNSzCJpSiaO4hrzNs1M" +
                                                              "UJFZPBsQLjqlJVzhEgHcF6RwRdIQXHtwO9KWVPyQXwwIGcOxy7nSywWQX5FC" +
                                                              "FklDFOG0KEO6MZqKIvxgzwQEOx2OCFcXEYB9TQpWJA1RBATkpqMlVzEWXsTi" +
                                                              "SQeT8HF6PY/IOspRRQWc3pZyEknDFJ4wborrKtxddMKNsrYUL/sjuXfywHsF" +
                                                              "13iFAO/7Urwi6Sy8y3Lh/VUeeJdyjUsFeD+S4hVJZ+Fdngvv+TzwLuMalwnw" +
                                                              "firFK5LOwrsiF97fBsSLmzXLucblArx/lOIVSVNcpBvs1uIx025dkwvrZ3nc" +
                                                              "4K3g2lbkxhoKSbGKpAFrv9Ol8XW9HL4uFM5j6lvJta0UYC2TYhVJU1KdcFp0" +
                                                              "26F4090aj7nLur7GDZXnYbhXcpVXCgBXSQGLpNFwnTZlDLzVeeC9imu8SoC3" +
                                                              "VopXJA13+3hHajY5KhivuxzqN4epeZjDF7m+LwrQzpKiFUlDJMTQrtEkcOvy" +
                                                              "CCuu5gqvFsBtkMIVSWNYgXBx+3mdYuUCOz8PF7aKq1slALtYClYkDW4BV1Li" +
                                                              "zBJoLqtdkseqTyPX1ijAukyKVSTNV33irh3kBLs8D6NdzdWtFoC9WgpWJI0+" +
                                                              "zGiGiaxDGRAHN6FVeQC+hqu8RgD4OilgkXQ24FzRTahJAtjNyrW7UGIl+gxd" +
                                                              "9TYX2F8J8T1SkQaHlZyRuXF32UWEvOxZAlw0nyV6TIYtmB/Zc+BwbOPRpbhg" +
                                                              "jrXfQkk5Na3LDW1YM9J0z2XL7/7NrXb2cJC3U3TVqxeKzt03rTL7CQOsqU7w" +
                                                              "/MAi8aaDX8ELe34zfdOXBm8N8OjAbB9/f5WPtB87vW6Bel+YPd/kbkxlPReV" +
                                                              "KdSYucxfYWs0YcczF/brU11chT2Ky6oa72LNb6+eaaGxhtZnGmuFRJSV9DZ4" +
                                                              "k/uYWMtWSd7NmHRTUjGg0W5364rZuGfem8cajxnbpnhhLV4Odaaw12DWHDh0" +
                                                              "jl0PTlskKqE2IMnTMemDIAVop+9ksKnJ467+2dxZl+MEMMQJDAXnLhKV8HMk" +
                                                              "eQlM4hBCAHf//oZH3SwM9ZkMsvu3PTh1kaiE3h2SvN2Y7IRYD6lnbpZ4zMfc" +
                                                              "J7k4g8dwKsHhJ4IzF4lK2P2NJO9uTL7qdnqbDsGCt32cZu97C0MdtzhGOf7R" +
                                                              "4NRFohJ6D0jyHsLkPkpqgHqO7RyP/f7Csd/FKewKzl4kKmH4XUneUUwO+9hv" +
                                                              "ycH+O4VhjxsDuzmF3cHZi0QlDE9I8h7H5FFKJmf0fdpit8f/scLxv5OTuDM4" +
                                                              "f5GohONPJHknMfl7H/8tOfk/VTj+d3ESdwXnLxKVcHxBkncak39M8s+xDebx" +
                                                              "f65w/O/mJO4Ozl8kKuH4M0nea5i8ksU/1/gfc2H/4vjjltU3OIlvBOcvEpVw" +
                                                              "fEeS9y4mb1Iyxdf/OUfAucK1wEFO42DwFhCJSlh+KMk7j8mvslogtw/4oDAt" +
                                                              "gLfkD3EaDwVvAZGohOUFSd4fMPkvuJnHFsjaPvTIf1oY8riheIgzOBScvEhU" +
                                                              "TDBcJMkrRjV/ouSSdPIZm5FeA3xeuMD3Yc7i4eANIBKVkKyS5OEzxuEKN/D1" +
                                                              "b22mqIfH/9nUJ2HWDDiOcvxHg1MXiUrozZDkzcKklpJyoO7te77psR5zQfvi" +
                                                              "7vGwwx/h0B8JzlokKmF2qSQPl9nC9e5wz95J9cjPKxz545zB8eDkRaISgssl" +
                                                              "eSsxiWSTX+YjHy0c+cc5g8eDkxeJSgheK8lrwmRVNvnlPvKNhSP/JGfwZHDy" +
                                                              "IlEJwRslee2YtGSTX+Ejv64w5PGxjqc5g6eDkxeJSghuluTh88bhTkrGs1XM" +
                                                              "tM1nj3dXYSY3XMo7ycGfDM5bJCrhpkry0KGHb6GkEmf3jJ1sj3hvYTp8DhzP" +
                                                              "cvTPBicuEpWQMyV52zG5zV3VyLEt7rHfVrix/jyn8Hxw9iJRCcPbJXm7MBl2" +
                                                              "x3r2HrtHfkfhlu5Pcwang5MXiUoI7pXk3YXJHnfpPmvH3uP+lcLdyrzMCbwc" +
                                                              "nLtIVMJvvyTvICb3uB2fvf/vkf964SL5s5zB2eDkRaISgt+R5D2MyTfdSN7/" +
                                                              "NIFH/VuFGfAYyb/G8b8WnLpIVELvMUnecUy+5/r5zEcTPOLfL9yGzRsc/RvB" +
                                                              "iYtEJeSekuQ9jckTyQ2bjOccPOZjPlV98TPcWxz+W8GZi0Ql7J6T5D2PyTPu" +
                                                              "DJfjoQmP/U8Lx/5dTuHd4OxFohKGZyR5ZzH5lxzs/TcyLxWGPb5T/z6n8H5w" +
                                                              "9iJRCcNzkry3MHmdklLX02k+zr8IznmEkrLkZyXw1eZpWd+1cb/Fov7wcFXZ" +
                                                              "1MM3/YJ92iD1vZTKNlLWnzCM9Ddv085LLFvr11k7Vbrv4bKXF8P/QUn92A+o" +
                                                              "UFLMfhF6+D1X8gNKZsokKRmHP+kiv6FkqkCEkhL3JL38eZhG/eUBCvtNL/cx" +
                                                              "JRVeOajKPUkv8iklRVAET39rsR6YBpWzt8fxbeeI+7bziPvUzgzeMan+JFPG" +
                                                              "6s+USPpnFvAJGfYRo+TTLAn3M0a96onDN2y4/ZMrj7qfeVANZedOrGV8Gyl1" +
                                                              "vzjBKsUnYuYKa0vWVbJ+4WcTf1Q+P/lUUI0L2BsSMzy7JWsJCVloXtN9H0Bw" +
                                                              "GlLfQXjjyOpnXt5X8mqYhLaSkELJ5K3Z74WPWAmbzN7aluuF227FZt9maKx4" +
                                                              "79Yzv38zNIm9fk/cV3TrZBK96v5nznX0W9Y3w6S8lRTrGDKzl9bXjMY7NXXY" +
                                                              "znh/t6TPTMRT3zuaiGNBwQ8cpdYPoUEnpK7iZ0LA3LNfZc7+dEqFYe7Q7Oux" +
                                                              "dqxmgu8ZooRlpeeylu3DZPMItjTYWm9bu2Xxd7jLKlnLWxYO9KJS/Ef9P1OK" +
                                                              "KLCpTAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C7DraH2f7933so/LboDNZtkXy8Ku4cqWbMtmgWBbli1Z" +
       "smRLtiWVsOhpyXpaL8tKlgJTEvKiQBYKnbCTdKAJDI8kU9KkDRlIQgINMCWF" +
       "tNAmgUxJyasJmQlhSkkq2T7X55x7ztlz7z3TM6PPOvp/j9/v+/+///f/JH36" +
       "8F8Xbgj8QtFzrdXMcsOLahJenFvVi+HKU4OLOFGlRT9QlbYlBgGbXXtSfviX" +
       "7vz2d9+uXzhfuFEo3C06jhuKoeE6wUgNXCtWFaJw5+5qx1LtICxcIOZiLAJR" +
       "aFgAYQThE0ThOfuKhoVHiD0IQAYByCAAawhAc5crK3S76kR2Oy8hOmGwKLyh" +
       "cI4o3OjJObyw8NDBSjzRF+1tNfSaQVbDzfn/k4zUunDiFx68xH3D+TLC7yoC" +
       "T/+r1134lesKdwqFOw2HyeHIGYgwa0Qo3GartqT6QVNRVEUoPNdRVYVRfUO0" +
       "jHSNWyjcFRgzRwwjX73USfnFyFP9dZu7nrtNzrn5kRy6/iV6mqFayt5/N2iW" +
       "OMu4Pn/HdcMQza9nBG81MmC+JsrqXpHrTcNRwsIDh0tc4vhIP8uQFb3JVkPd" +
       "vdTU9Y6YXSjctdGdJTozgAl9w5llWW9wo6yVsHDvsZXmfe2JsinO1CfDwj2H" +
       "89EbUZbrlnVH5EXCwvMOZ1vXlGnp3kNa2qefvx688m0/7PSc82vMiipbOf6b" +
       "s0L3Hyo0UjXVVx1Z3RS87XHi3eLzP/HW84VClvl5hzJv8vz7H/nWa152/yc/" +
       "s8nzA0fkoaS5KodPyu+X7vjife3HGtflMG723MDIlX+A+dr86a3kicTLRt7z" +
       "L9WYCy/uCT85+l3+jR9S//J84VascKPsWpGd2dFzZdf2DEv1u6qj+mKoKljh" +
       "FtVR2ms5VrgpOycMR91cpTQtUEOscL21vnSju/4/6yItqyLvopuyc8PR3L1z" +
       "Twz19XniFQqFm7Kj8Gh23FfY/K1/w4IF6K6tAqIsOobjArTv5vxzhTqKCIRq" +
       "kJ0rmdRzASmzf/Pl5YswELiRnxkk4PozQMysQlc3QiCIZzPVAbSsp4BQlCwV" +
       "oAKQzU8u5lbn/X9uL8n5X1ieO5ep5r7DjsHKxlTPtRTVf1J+Omp1vvXRJ3//" +
       "/KWBsu25sFDMGr24afTiutGLm0Yv5o1eXDd6ca/Rwrlz67a+L298YwKZAs3M" +
       "FWRO8rbHmB/CX//Wh6/LbM9bXp/1fp4VON5Xt3fOA1u7SDmz4MIn37N80+Sf" +
       "l84Xzh90ujng7NKteXE6d5WXXOIjhwfbUfXe+WPf/PbH3v2Uuxt2B7z41htc" +
       "XjIfzQ8f7lrflVUl84+76h9/UPz4k5946pHzheszF5G5xVDMzDjzOPcfbuPA" +
       "qH5iz0PmXG7ICGuub4tWLtpza7eGuu8ud1fWOr9jff7crI/vyM38+dnxg1u7" +
       "X//m0ru9PP2+jY3kSjvEYu2BX8V47/tvX/hzaN3de876zn3TH6OGT+xzEHll" +
       "d65dwXN3NsD6qprl+6P30D/zrr/+sX+2NoAsx4uOavCRPG1njiFTYdbNb/nM" +
       "4it/8sfv/9L5ndGEhVs83w2zUaMqySWeuahw+wk8swYf3UHKfIyV1ZAbziNj" +
       "x3YVQzNyC84N9f/e+eLyx//qbRc2pmBlV/Ys6WXPXsHu+ve3Cm/8/df9w/3r" +
       "as7J+Ry367Zdto3jvHtXc9P3xVWOI3nTH7zwvb8nvi9zwZnbC4xUXXuy8+tu" +
       "OL9m/rywUD7F+EQMX82NdtVxQn+1V/KedZuGe3GU+R7XbsqZiwnQzJuuTQJY" +
       "Z3t8nV7M+307ZLeF794rjFGdRFa9nMq6XDVPHgj2D7uDI3tfCPSk/PYv/e3t" +
       "k7/9zW+tO+lgDLXfykjRe2Jj2HnyYJJV/4LDPqYnBnqWr/LJwWsvWJ/8blaj" +
       "kNW4JkX5mZdLDtjkNvcNN331U7/9/Nd/8brCebRwq+WKCiquh3fhlmxcqYGe" +
       "OcjE+8HXbGxqeXOWXMjPksKljimsO6aQbGzxnvV/L8oAPna8Z0PzEGjnHO75" +
       "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" +
       "ONLkHELvT+o90lSHFlnRW+1mTwMAV+hB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "PrXl96mz55eeIPuRPIk2i+UjNlvtSMZnMQ4/vSX56bMn+aMnyN6aJ2/ajMPL" +
       "92ztOL75LG6xfnbL8bNnz/GdJ8iezpOf3txivWzv147i284iCv/8luLnz57i" +
       "MyfIfi5P3rtR4+V7yHYcn/V7AaeJTr+45fjFs+f4oRNkH86TD2yi08N70XYM" +
       "/+21DsY8Ov3yluGXz57hr54g+7U8+eWNRz24pW3H71fO4jb5V7b8vnL2/H7r" +
       "BNnv5Mkn9m6TH9gZtyP4m2cxZfzRluAfnT3BL5wg+8958tnNlHHEBrsdyf90" +
       "FiS/viX59bMn+dUTZP8jT758BMnDMfgfXivJ/HuL39iS/MbZk/yzE2TfzJOv" +
       "h4WbNs5GPUTtWbfKH/iiXVi4ee/TnvlHCu+57NvCm+/hyh995s6bX/DM+L+u" +
       "v2556Zu1txCFm7XIsvZ/3G3f+Y2er2rGmuwt6/QOb83gb8LCw8/+PDws3LD+" +
       "zUGf/9+bkn8XFu47qWRYuD7/2V/k78PCC44pku+oXJ/sz/+dbKo6nD+Dsv7d" +
       "n++7YeHWXb6sqs3J/iz/GBauy7Lkp//krfv+4G7MzQf1ks1LAvfss7bNuwp3" +
       "PZsmLxXZ/6XN/EH/+kPSew/lo82npJ+UP/YMPvjhb9U+sPnSp2yJaZrXcjNR" +
       "uGnz0dF1pfmD/YeOrW2vrht7j333jl+65cV7LyHcsQG8s/x92B44+puaHdsL" +
       "11/BTH/tBf/ulb/wzB+vN4f+P+svvo/hWwAA");
}
