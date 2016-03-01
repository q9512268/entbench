package org.apache.batik.svggen.font.table;
public abstract class GlyfDescript extends org.apache.batik.svggen.font.table.Program implements org.apache.batik.svggen.font.table.GlyphDescription {
    public static final byte onCurve = 1;
    public static final byte xShortVector = 2;
    public static final byte yShortVector = 4;
    public static final byte repeat = 8;
    public static final byte xDual = 16;
    public static final byte yDual = 32;
    protected org.apache.batik.svggen.font.table.GlyfTable parentTable;
    private int numberOfContours;
    private short xMin;
    private short yMin;
    private short xMax;
    private short yMax;
    protected GlyfDescript(org.apache.batik.svggen.font.table.GlyfTable parentTable,
                           short numberOfContours,
                           java.io.ByteArrayInputStream bais) { super(
                                                                  );
                                                                this.
                                                                  parentTable =
                                                                  parentTable;
                                                                this.
                                                                  numberOfContours =
                                                                  numberOfContours;
                                                                xMin =
                                                                  (short)
                                                                    (bais.
                                                                       read(
                                                                         ) <<
                                                                       8 |
                                                                       bais.
                                                                       read(
                                                                         ));
                                                                yMin =
                                                                  (short)
                                                                    (bais.
                                                                       read(
                                                                         ) <<
                                                                       8 |
                                                                       bais.
                                                                       read(
                                                                         ));
                                                                xMax =
                                                                  (short)
                                                                    (bais.
                                                                       read(
                                                                         ) <<
                                                                       8 |
                                                                       bais.
                                                                       read(
                                                                         ));
                                                                yMax =
                                                                  (short)
                                                                    (bais.
                                                                       read(
                                                                         ) <<
                                                                       8 |
                                                                       bais.
                                                                       read(
                                                                         ));
    }
    public void resolve() {  }
    public int getNumberOfContours() { return numberOfContours;
    }
    public short getXMaximum() { return xMax; }
    public short getXMinimum() { return xMin; }
    public short getYMaximum() { return yMax; }
    public short getYMinimum() { return yMin; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVaDWwcxRWeO///JP4JsUPiOInjBGzCHWkIf05bEifGhvOP" +
       "4hAVB3DWe3PnJXu7m91Z5xyaQiKVRCAhRAylLYkqEfoTBUJRUWkrIFVbfkQp" +
       "gqKWn/JTqAQtRCKtiqGU0vdmd2/39m43sYvUk3ZubmbevPe9efPem507dpKU" +
       "GTpp0wQlKcTYpEaN2BDWhwTdoMluWTCMLdA6Kt7654M3Tf++am+UlI+QueOC" +
       "0S8KBu2RqJw0RshiSTGYoIjUGKA0iRRDOjWoPiEwSVVGyHzJ6MtosiRKrF9N" +
       "UhywVdATpEFgTJfGTEb77AkYWZLg0sS5NPH1/gFdCVIrqtqkS7Awj6Db04dj" +
       "My4/g5H6xA3ChBA3mSTHE5LBurI6OU9T5cm0rLIYzbLYDfJaWxFXJtYWqKHt" +
       "obqPPr1jvJ6rYZ6gKCrjEI3N1FDlCZpMkDq3dZNMM8ZO8g1SkiA1nsGMtCcc" +
       "pnFgGgemDl53FEg/hypmplvlcJgzU7kmokCMLMufRBN0IWNPM8RlhhkqmY2d" +
       "EwPapTm0znL7IN51XnzqW9fXP1xC6kZInaQMozgiCMGAyQgolGbGqG6sTyZp" +
       "coQ0KLDgw1SXBFnaba92oyGlFYGZYAKOWrDR1KjOebq6gpUEbLopMlXPwUtx" +
       "o7J/laVkIQ1Ym1ysFsIebAeA1RIIpqcEsD2bpHSHpCS5HeVT5DC2XwUDgLQi" +
       "Q9m4mmNVqgjQQBotE5EFJR0fBuNT0jC0TAUT1LmtBUyKutYEcYeQpqOMLPCP" +
       "G7K6YFQVVwSSMDLfP4zPBKu00LdKnvU5ObDu9huVXiVKIiBzkooyyl8DRK0+" +
       "os00RXUK+8AirO1M3C00PXYgSggMnu8bbI356ddPXb6q9cTT1phFRcYMjt1A" +
       "RTYqHhmb+0JLd8elJShGpaYaEi5+HnK+y4bsnq6sBp6mKTcjdsaczhObn7zm" +
       "5qP0/Sip7iPloiqbGbCjBlHNaJJM9SuoQnWB0WQfqaJKspv395EKqCckhVqt" +
       "g6mUQVkfKZV5U7nKf4OKUjAFqqga6pKSUp26JrBxXs9qhJB6eMgAPIuI9eHf" +
       "jGjxcTVD44IoKJKixod0FfHjgnKfQw2oJ6FXU+NjYP87zl8duzhuqKYOBhlX" +
       "9XRcAKsYp1Zn3JhIp6kST4Gm4kwYk2n8CnkytZEaoi5p4HzA8rT/A88s6mHe" +
       "rkgElqjF7yBk2Fu9qpyk+qg4ZW7YdOrB0Wct48MNY2uQEWQcsxjHOOOYxTiG" +
       "jGOccczLmEQinN9ZKIBlDrCYO8AtgF+u7Ri+7srtB9pKwA61XaWwEjh0ZUGc" +
       "6nb9h+P0R8VjL2yefv656qNREgUXMwZxyg0W7XnBwop1uirSJHiroLDhuM54" +
       "cKAoKgc5cc+uvVtvuoDL4fX/OGEZuC4kH0KvnWPR7t/3xeat2//eR8fv3qO6" +
       "HiAvoDhxsIASHUubf3X94EfFzqXCI6OP7WmPklLwVuChmQA7Cpxfq59HnoPp" +
       "cpw1YqkEwClVzwgydjketpqN6+out4WbXQOvnwVLPBd33EJ4VtlbkH9jb5OG" +
       "ZbNlpmgzPhQ8GHx5WDv08u/+uoar24kbdZ6AP0xZl8dX4WSN3Cs1uCa4RacU" +
       "xr1+z9DBu07u38btD0YsL8awHctu8FGwhKDmbz6985U33zjyUtS1WUaqNF1l" +
       "sHlpMpvDiV1kTghONHVXJHB3MsyAhtN+tQKGKaUk3E24T/5dt2L1Ix/cXm+Z" +
       "ggwtjiWtOv0EbvvZG8jNz14/3cqniYgYbl21ucMsHz7PnXm9rguTKEd274uL" +
       "v/2UcAiiAXhgQ9pNuVMt4Woo4cgXMLLqDF3EFqwZuBs8+x0Tx2FzzGBDupSB" +
       "BZyww9rxpumdv67YvdEJWcVIrJFXGf3P/7z33VFuIJXoF7AdZZvj2fHr9bTH" +
       "OuutVfscPhF4/oMPrhY2WAGisduOUktzYUrTsiB9R0hemQ8hvqfxzR33vveA" +
       "BcEfxn2D6YGpWz+P3T5lLbmV6ywvSDe8NFa+Y8HB4jKUblkYF07R8+7xPb/4" +
       "4Z79llSN+ZF7EySmD/zhs9/G7nnrmSLBoMwYV3UrY12DGyHnwpv862OBKl99" +
       "6JObbnl5EHxOH6k0FWmnSfuS3lkhXTPMMc+CuXkUb/DCw8WB+NKJ62CbXgs3" +
       "WkmNbZhklJttn6KZDBI8KmQ47YV8aDwnM+EyE953FRbthtc/56+pJ20fFe94" +
       "6cM5Wz98/BTXS37e73VH/YJmLUoDFitwUZr9sbBXMMZh3IUnBq6tl098CjOO" +
       "wIwixHljUIeInM1zXvbosopXf/mrpu0vlJBoD6mWVSHZI/A4QKrAAVNYGjmZ" +
       "1b56ueV8dlU62U+WFIDH/b6kuCfZlNEY3/u7H23+ybofHH6D+z1L4Ys4ea2B" +
       "xw1/yOZnRjfafPDad995Yvq+CsvKQvaMj27BvwblsX1vf1ygZB5ci2wjH/1I" +
       "/Ni9C7u/8j6nd6McUi/PFmZBkAe4tF86mvlntK38N1FSMULqRft8tlWQTYwd" +
       "I3AmMZxDG5zh8vrzzxdWMt2Vi+It/n3sYeuPr96tUcrytoEbUhc44aXVDjWt" +
       "/pDKczDLhlCkWB8cp9JUb3z7e0em9+6/JIoOvWwCRQet1LvjBkw8Bt5y7K7F" +
       "NVNv3cbXHrc4TnotZ7+Slx1YrLLCAIOjqzkmSxBfyg1+qgRHkZIUQfbFxuYQ" +
       "gRmpUJVuU5+wcoiLbYeGX+s89csZKR2Dre53Qfizx84jsExgcZ1FMxi4Jbbm" +
       "K3Q1PEts+ZYUUShWrofmKFbUAG1gVcQiiQUtooIgFozUZofRv26luK2xbdyH" +
       "SJsFoqU2u6UhiEqxkp01oiAWgGjyNIgmZ4joPHiW2eyWhSCqxMreWSMKYgEm" +
       "rlONCqwYln0zxNIJT5vNqC0ECw9/t84aSxAL2KXZjaYgF4Ny2yygLLf5LA+B" +
       "shQrB2cNJYgFQJkMgjJ15lD4SaUdnhU2nxUFUAiv3GshwKKzMP8PomakBs4U" +
       "VGE8EcamtT5ZD525rLWOea60ua0MkPW+4tqGQ0yFpksTkNj6FF0TMikj9QqP" +
       "EIMpfHWomrpxOn9dIikFGSP+LHDXR2YIHg3iHFvOcwLA/9hdqO8XogyihiCT" +
       "7Zf4SfJSn5APz0LIc2025wYI+WiokEHUIORkgJA/m4WQHTabjgAhnwgVMoia" +
       "a9J6D+UX8sQshOy02XQGCPlkqJBB1FyTxYV8KkTIgHjJswNIgSoFOKHqkKG7" +
       "24t/6ojvZaRHEk+WHXGOOGvO7HStjTtv4CBbxkPH4qB3zfwUeGTf1OHk4P2r" +
       "o/ZRaD2DU4SqnS/TCSp7xCjnZ0p/st/P37C7mfPFL06XvHbngtrCV3M4U2vA" +
       "i7fO4FOBn8FT+/62cMtXxrfP4J3bEh9+/5Q/6j/2zBUrxTuj/JLAStQLLhfy" +
       "ibry0/NqnTJTV/LPqm251UaTI2fDs9Ze7bV+q3WNrdA9cyvyeebqkMlCjrlv" +
       "h/T9BYs/QSzQrdubohn3hCol3T3x+uk2bt5JExu28OaXc2BwC/B05BIbzCUh" +
       "msHizUI9BJGGYD0V0vcPLD5gZF6asgFfhMOuoy7+k/8z/gbsaoFnnQ1i3czx" +
       "B5GGYPwspO9zLD6GDAXwfw2coZQxM9whurg/+eJw2zNY3zPDHUQajC1SFdJX" +
       "g0Wpg1tSCnFHyr443Btt4TfOHHcQaQi2+SF9zVjUW7ivKbrekYYvDnevLXzv" +
       "zHEHkYZgWxbStxyLFgd30fVePHPcWTjpei/B8P3agoIbeesWWXzwcF1l8+Gr" +
       "/8gvYnI3vbUJUpkyZdn7+sdTL9d0mpK4vmqtl0Eax9PJSNvpEwQ4H/FvFD/S" +
       "YVGez0hLGCX4ffzyklzASHMACb774RXv+DVwXPCPB1H4t3fcRYxUu+NgKqvi" +
       "HXIpHCRgCFYv05zUqPMMUqMhXU1DWpCNeJIaO3XjXm3+6VY7R+K9LsKEhf8x" +
       "w0kuTOuvGaPi8cNXDtx46qL7resqURZ278ZZahKkwro5yyUoywJnc+Yq7+34" +
       "dO5DVSucJK3BEtjdNIs8HnwLJA0aGt5C30WO0Z67z3nlyLrHnztQ/mKURLaR" +
       "iADhblvha8usZkL2tC1R7JU+pG/8jqmr+p3tz3/8aqQx94bQwFezIRSj4sHH" +
       "XxtKadp3oqSqj5RBDkqz/J3qxkllMxUn9LwbgvIx1VRy/+GYi7tEwD9tcM3Y" +
       "Cp2Ta8XrTtgIhdclhVfA1bK6i+obcHacZo4vpTM1zdvLNbsJi8uyqGmwwtFE" +
       "v6bZ90QVf+ea1zR0A5F+/NHzX5jOumd9JQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1i7R6m4EIdnWVTLoSAtyEsfRUg1lVidQyB2xgc7XV92BEW7iCWdGOc8Fi9DA" +
       "OjNYV+xpW098NctnCJIkSheT+2rm1HtNfuCt8iqLLBoWI9nL5i5N5j2lPSbE" +
       "Kt8mMXRLc5Jl8gTcmrWrrYyVIBQVWh3Lmo+rAtHq7+Z2D8r1sAMNWo4T2HMG" +
       "c0cpv0S4gK/Ve8AROqmXtJv1CUZbnU6TmkiSYzX6ZDYhmyZMrGxnrsZzxDL1" +
       "9YIdjeQqHq9NToJ6eNpeYdUxTTXruLTWQmRl2mNJ0E2LiiKnSQs9bNim7Sna" +
       "4pdtsZc6o2p/1+8AXzWTIj2SoUaz6lF1WCWUDtqUR41V3mlD2GI9R1pKC1mS" +
       "EE/ZDOf2CCNKOSHohBK2Ho0EHRlyDuY3IwvutPHtZJIOUyMjrS03VIbOqJav" +
       "E8kNXW+tQnbgxXBiUZjba9qr5ZwUhlAXndJBt7sc84OtLdSkRjNWlu2NxTXr" +
       "XHVFDHskJDXNGFcFa9znEShukXWkupNclSSbvWpeY1A+RBWxjmVpDdpNBGe2" +
       "VUWV7YmbTqfBJ34VDxN6moijbb2FJalkhetaotZ2moA1ZKOebkmoNoTGRgdv" +
       "xVB723Q2zZHMGRBL2AJmdhU0ItpNO7GciEbaIBCYjzjGn6lRO7JW0wWfboZI" +
       "1x4JWW/QyPV2EuR5tlmNovrSqA4jyAHhlRKzQacZcXKwi9y+xOkyiorrZW+7" +
       "iiCvR8t5j9Et3FxhbdnrUJyE5C0FVuxOtQlRQ3eSrFJ8NlWiGpNsMTNtY1Fj" +
       "16JbxHg5ThBZWpOBjC4cNxJa1bmV1fiAYfDucLL1c9OeZ5i602qAtmckCCO4" +
       "qSoRWcxPtZntcdQy5hrVVHYNRuKVwboatjtyKNCzei9QGshUNfKsjW7DfqbJ" +
       "Qo0YZQZKSZJNI9Ma24/CqsBz3FxfBa5q04TEdQc1bSlPDWPKRa471Ag35wRX" +
       "nSX1phXT9Uza7Mg5FRKuz9XjJqcbfT8zPbjmGt2VNtjuxkPNFtCty5LGqq7s" +
       "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" +
       "FckHjsS77eo9eS/iZVHlwdO3Jov7X4/f");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("coV7f+1Y/uXXr1157HXuP5QXB4+vBt/PVK6osWWdvh5yKn/ZCxTVKIW+f39Z" +
       "xCsleSGqPPfWDjKqXCp/C+DnPrrv+VJUefJuPQHpFj+nu0BR5bE7dCnuhpSZ" +
       "0+3rUeX62fYASvl7ul0jqlw9aQeG2mdONykOa0GTItvxjkKDF99GaMAGrgbc" +
       "bXbulFM/tMeShB55q3U+7nL6emMRCJQ3+Y+cdry/y/+K/LXXqfGPfrf5lf31" +
       "StkS87wY5QpTuW9/0/PY8T97x9GOxrpMvvD9h37l/g8dBSkP7QGf7I1T2J6+" +
       "/UXGvu1F5dXD/Nce+ycf+/uv/3555ef/AfUotmBiMQAA");
}
