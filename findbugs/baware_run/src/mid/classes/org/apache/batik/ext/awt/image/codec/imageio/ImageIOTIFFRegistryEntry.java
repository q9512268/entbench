package org.apache.batik.ext.awt.image.codec.imageio;
public class ImageIOTIFFRegistryEntry extends org.apache.batik.ext.awt.image.codec.imageio.AbstractImageIORegistryEntry {
    static final byte[] sig1 = { (byte) 73, (byte) 73, 42, 0 };
    static final byte[] sig2 = { (byte) 77, (byte) 77, 0, 42 };
    static org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[]
      magicNumbers =
      { new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sig1),
    new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sig2) };
    static final java.lang.String[] exts = { "tiff", "tif" };
    static final java.lang.String[] mimeTypes = { "image/tiff",
    "image/tif" };
    public ImageIOTIFFRegistryEntry() { super("TIFF", exts,
                                              mimeTypes,
                                              magicNumbers);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739551000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1Za5AU1RW+M7vsi4V9IAtBWNbdBQvEmeADkyxRl3UXBmbZ" +
       "zS5SyRJdenruzDb0dDfdd3ZnQURIJVD+MJQg0UT2h0FjLHyUxDIPJeTlo4xa" +
       "EktF47sqapAq+RExMYk5597u6Z6eBy5JJZmqvnOn7znnnnvPud85587hU2SK" +
       "ZZJWQ9LiUoiNG9QK9WO/XzItGu9SJctaB2+H5Zvf3rfjzB+qdwZJxRCZPiJZ" +
       "vbJk0R6FqnFriMxTNItJmkyttZTGkaPfpBY1RyWm6NoQmalYkZShKrLCevU4" +
       "RYL1khklDRJjphJLMxqxBTAyP8q1CXNtwp1+go4oqZV1Y9xlmJPD0OUZQ9qU" +
       "O5/FSH10kzQqhdNMUcNRxWIdGZNcZOjqeFLVWYhmWGiTerm9Eaujl+dtQ+tD" +
       "dR9/uneknm/DDEnTdMaXaA1QS1dHaTxK6ty33SpNWVvIjaQsSqZ6iBlpjzqT" +
       "hmHSMEzqrNelAu2nUS2d6tL5cpgjqcKQUSFGLsgVYkimlLLF9HOdQUIVs9fO" +
       "mWG1LdnVOub2LfG2i8L7v3d9/cNlpG6I1CnaIKojgxIMJhmCDaWpGDWtznic" +
       "xodIgwYGH6SmIqnKVtvajZaS1CSWBhdwtgVfpg1q8jndvQJLwtrMtMx0M7u8" +
       "BHcq+9eUhColYa1N7lrFCnvwPSywRgHFzIQEvmezlG9WtDj3o1yO7Brb1wAB" +
       "sFamKBvRs1OVaxK8II3CRVRJS4YHwfm0JJBO0cEFTe5rRYTiXhuSvFlK0mFG" +
       "Zvvp+sUQUFXzjUAWRmb6ybgksNIcn5U89jm1dvkt27RVWpAEQOc4lVXUfyow" +
       "NfuYBmiCmhTOgWCsXRw9IDU9vidICBDP9BELmkdvOH31kuZjTwma8wvQ9MU2" +
       "UZkNy4di01+Y27Xoy2WoRpWhWwoaP2fl/JT12yMdGQOQpikrEQdDzuCxgSe+" +
       "cdN99GSQ1ERIhayr6RT4UYOspwxFpeZKqlFTYjQeIdVUi3fx8QiphH5U0ah4" +
       "25dIWJRFSLnKX1Xo/DdsUQJE4BbVQF/RErrTNyQ2wvsZgxBSCQ+phWcuER/+" +
       "zcjN4RE9RcOSLGmKpof7TR3XjwblmEMt6Mdh1NDDMfD/zRcvDV0RtvS0CQ4J" +
       "/cvCupkMS+AZI1QQ8LMqjbGwkgKHCMuAT7LoK3o4gt+RvnWRnp4BmgSAMse7" +
       "NWhC6JPG/5U2Gdy7GWOBAJh1rh9UVDiPq3Q1Ts1heX96RffpB4afEQ6Lh8ze" +
       "dUa6QZ2QUCfE1eEQDOqEuAohrk7IVidUTB0SCHAtzkO1hGOBW2wGgAGa2kWD" +
       "163euKe1DDzaGCsHmyLpwryI1+UikRM+huXDLwycef7ZmvuCJAhgFYOI54ad" +
       "9pywI6Kmqcs0DrhXLAA5IBwuHnIK6kGO3T62c/2OL3I9vJEEBU4BEET2fsT/" +
       "7BTtfgQpJLdu9/sfP3hgu+5iSU5ociJqHidCVKvf5v7FD8uLW6RHhh/f3h4k" +
       "5YB7gPVMgrMJMNrsnyMHqjoc2Me1VMGCE7qZklQccrC6ho2Y+pj7hjtjA++f" +
       "Byaeime3DZ5F9mHm3zjaZGA7Szgv+oxvFTysfHXQOPjKcx9cyrfbiUB1ntRh" +
       "kLIOD+qhsEaObw2uC64zKQW612/v33fbqd0buP8BRVuhCdux7QK0AxPCNn/7" +
       "qS0n3nzj0ItB12cZhP10DDKoTHaR+J7UlFgk+rmrD6CmCliBXtN+rQZeqSQU" +
       "KaZSPCR/r1uw9JEPb6kXfqDCG8eNlpxdgPv+CyvITc9cf6aZiwnIGLXdPXPJ" +
       "RCiY4UruNE1pHPXI7Dw+744npYMQVADILWUr5dhM+B4QbrTL+PrDvL3UN7YM" +
       "m3bL6/y558uTXQ3Le1/8aNr6j46e5trmpmdeW/dKRodwL2wWZED8LD/QrJKs" +
       "EaC77Njab9arxz4FiUMgUQbQtfpMAMFMjmfY1FMqX/3Vb5o2vlBGgj2kRtWl" +
       "eI/EDxmpBu+m1gjgZ8a46mph3LEqaOr5Ukne4nE/5xe2VHfKYHxvt/501k+W" +
       "/2jiDe5UwovO5+xYAbTk4SFP7d2j/OFrP3j3l2d+WCkSg0XF8cvHN/tvfWps" +
       "1zuf5G0yR64CSYuPfyh8+M45XVee5PwuhCB3WyY/8ADIuryX3Jf6S7C14ndB" +
       "UjlE6mU7jV4vqWk8mEOQOlpObg2pds54bhoocp6OLETO9cOXZ1o/eLkBD/pI" +
       "jf1pPrxqQCt2wjPfPsrz/XgVILyzkrMs5O0ibJZwEwYBHiyepzOYXdEk1QcT" +
       "9SVkMzxpyaV+L8BCbTAdsxg/nSI9/NmMD448vbHyhPCC9oLkvqzznW3P3KX/" +
       "8WTQySgLsQjKNVbv8z9f9d4wR90qDLbrnO3yhNFOM+mB/PrsMnm61gJI+ZhY" +
       "pfhmZMu/kTHlZ0sxU4lDmrQClBuUTcVgUB50a6OKqWspqjEnTfvvT4qwtKD4" +
       "qfTYcOKetud2TLS9zUGqSrHAd2FPC9QcHp6PDr958vi0eQ/wQF6OprHNklus" +
       "5ddiOSUWt1gdNoMZq5j79JtKCoLqqO0+Dzad2fLbyq3XBG2I/5ow+GfwCcDz" +
       "T3zQ0PhCGLyxy64aWrJlg2HgfCVAyzdpeHvjm5vvfP9+4bN+hPIR0z37b/4s" +
       "dMt+ETtF7dmWV/55eUT9KfwXmw2o3QWlZuEcPe89uP0X927fLbRqzK2kurV0" +
       "6v6X/vH70O1vPV0g0S6PjTOaDRuBbB7c5LeBWFPF0oN/3fGdV/rA3hFSldaU" +
       "LWkaieeCWaWVjnkOqFvWugBnrw5tw0hgsWGHHa8K+LtTuIQNcZuKQBx2L8Ym" +
       "ymVvAMhTqZZkI5zyOnsj8UtipAw8Ebtf90wZFHL479nMzj8Q36G61jWKqYwz" +
       "JioJKDmyNxswmK88Ws0fN3u5w7tB6IrjZ8peu3V2bX4JgdKaixQIi4v7qn+C" +
       "J3f9ec66K0c2TqI2mO/zNb/IH/cefnrlQvnWIL8WETEv7zoll6kj1zlqTMrS" +
       "ppbrDq3CztwuwsjYLOaWK5HV3Vhi7CZstkHQk9GEwuIlyL/FPewqTwZlmxJ/" +
       "Ju2iANsrsFklLP6VoilYZ34Ab7GDbEuRAL67hHevEd6dH7mLCRWR+xLsD/h0" +
       "3/P5defF0nJ42u1pWovo/t3CuvPNW1OgLmktIo+Bz0tJRV6b5jeJnLEvdysx" +
       "mi+z2ZcJXL/hPxpTC117bDJoMry6v3tlwauX/+n8YnfXY3Mg46DUyrPcnliG" +
       "Eup1NzpHartnoDgoH3BMf/BzgjI2KWx4TXxHPvriT569s8KxYExMy7mxuaHE" +
       "aT5UYuwebO7CZqfQpATtvZNChb2TRIUvwbPQduWFRU7W4XNBhWJCARXAD+xj" +
       "ZVtgvZH1mno37onr7cLmNxzdHj0n0x85B9MbXNCRs5n9aImxY9g8ljX7kVJm" +
       "//WkzH7/JM1+DTwX2ha6sIjZnzgXsxcTykh1SknR7J3Yw74FPFliARlPOM7O" +
       "yD8VxHcj7pnRc4dAMIWdV+xPC56+Htq1fyLed/dSJ5OPgcJMNy5W6ShVc0Qx" +
       "MrvYVS9edMzO+wdL/OsiPzBRVzVr4tqXRZXi/DNSC8VkIq2q3jrc068wTJpQ" +
       "uEa1oioXbvgyI0smczvNSKXd42t5SUh5lZH2zyMFMxj89vK+zkhzaV7g4t9e" +
       "rrdg94pxQV4MrZf6Xch1C1EDJWKIh/JPgBx+Spiff3vpPmCkxqWDJF10vCQf" +
       "gnQgwe4pw4GlyKT+CuiEStGUZGb7SY6PZAK5jpk9ATPPdoQ9vtyWk4Dzv1ad" +
       "ZDkt/lyF2nRi9dptp5fdLa6JZVXauhWlTIXaSNxYZxPuC4pKc2RVrFr06fSH" +
       "qhc4p6NBKOye4fM9yHUVgJSBR2GO7w7Vas9epZ44tPzos3sqjkMxuIEEoCSa" +
       "sSH/RitjpKEa2BAtVAVCOcKvdztq3t34/CevBhr5xSERdU9zKY5hed/R1/oT" +
       "hvH9IKmOgI9qcZrh123XjGsDVB41c4rKipie1rJ3CNPx3EoYl/jO2Bs6LfsW" +
       "/2ZgpDW/wM7/66VG1ceouQKlo5hpvhIlbRjeUb6zCR7KMrjT4KTD0V7DsG8W" +
       "ak/wnTcMxL4Ah8HkvwBiXZDePyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739551000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9+3XWTf38drNMlq7ud+J+9jHb1I03r897VJ9/uZHbnpadljySdldvfCxg4OD" +
       "jz//XBAcm9uNk2lmT3ex3XzpSOmXvye7eel7tJsvlcxeej27+co9yn6uSP7O" +
       "sd28dC+7+fk77ObFN2k3OLjffzig77/Abl55w3bzkGu52vE2wkvnZPvq68pW" +
       "sskvgeX5A7WD1kG1eP8Hd2/9vuMBPCvCu2xHuXVkknMALSAsuGU7raL4b58T" +
       "qP+GBQLhySMnxkf6nvH8T/67L/zu33j2NRCdjaEH0mIVBaKMUxa6R7afeOWL" +
       "T77lxT/9yXLvAZgKI1evP15w/ZU3p9YThVp8id+kHMVUuV2gqYVmd4vZ7geh" +
       "gfE9axvfuDFCI6J7dFGIJDe6M4QTK1QrjSx03iG6cU+crtQem/ZdrYuvtznn" +
       "1GeLnruSdnyD33JjVfPCZIevqiquq2pd8tgZR4zneIUas0Z1JtTM6sAmR9tZ" +
       "jhPMWBMcH83l/joeoEAlOehuKlw/p5brRqPTSppSU+ttG+Ox5G5Sj/ZaOw9c" +
       "KZOo7Uaj3TJnNX4iSWOR7ZDWzLemww476Yg0vNgR8TDp8GMllnu1yqghpXo9" +
       "1O1dr7JRM2mcc5jEWGMpXY3XVa452HiD0KJyYUrEY3e9jWNJGK5lRg96S4Tb" +
       "im5z6rOu7CzXEm9OQhLT0hnKLUlkba4dnBvbgTkmqXyT94TulmlvEGwxjbMA" +
       "qRg+6m+kObLs5I47ZvAqPZPYzmZGN+ABP0Kq6x27MdUpNVOmXC4S6lCaKhJt" +
       "b7QBOReXpisOLUEL3U5fTmynosZsJcZVrgMnnrb2XBjH+56gUvJC7iIsj6gj" +
       "WcgnzXhbr/PBVJynhC2zEb+RmlbPCezdRjDdEU/1d5twqjndpObN+JrajMmG" +
       "Ehj2RpmwM34wJCNjvlxbrkOSg86IVtkZMY86Og2EQUjVm9PJqkbqw5rVJltp" +
       "Xe3AytQJhk0CwTyZmPi2kRPU2HQxXBaDIS7GO89SchA+G9lyOGryLrHxJvM4" +
       "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" +
       "fvbMP9LyjPDR/8xkf0r4tvL1l8fTT36n");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+ZX9cSvFkXe7gstVEnpwf/Lr+J/oey7kdsTryui57z7yiw+998g7HtkLfOLD" +
       "p2R7+u5nm/puEJenkXa//K5/+OGfe/lPyq3Q/wVKA0BdvC0AAA==");
}
