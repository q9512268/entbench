package org.apache.batik.svggen.font.table;
public class KerningPair {
    private int left;
    private int right;
    private short value;
    protected KerningPair(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        left =
          raf.
            readUnsignedShort(
              );
        right =
          raf.
            readUnsignedShort(
              );
        value =
          raf.
            readShort(
              );
    }
    public int getLeft() { return left; }
    public int getRight() { return right; }
    public short getValue() { return value; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO+PzBwZ/EGyHbxuDhEPuCkmaVqY04NjBcMYn" +
                                                              "G6hq0hx7e3Pnhb3dZXfOPjulhEgJCEUoBUJpG/xHS9SWEkirRKkShVL1I4nS" +
                                                              "BEGjNglq0jZ/JG2CFP5onJa29L2Z3du9Pd8hVKkn7ezcznsz78177/fezOkr" +
                                                              "pNIySbshaUkpzMYNaoVj2I9JpkWT3apkWVvga1w++Ocje6d+V7MvSELDZPaI" +
                                                              "ZPXLkkV7FaomrWGyUNEsJmkytTZTmkSOmEktao5KTNG1YTJXsfoyhqrICuvX" +
                                                              "kxQJtklmlDRKjJlKIstonz0BI4ujXJoIlyayzk/QFSV1sm6MuwzzChi6PWNI" +
                                                              "m3HXsxhpiO6URqVIlilqJKpYrCtnktsMXR1PqzoL0xwL71TvsjdiY/Suom1o" +
                                                              "f6b+02uPjzTwbZgjaZrOuIrWILV0dZQmo6Te/dqj0oy1m3yDVETJTA8xIx1R" +
                                                              "Z9EILBqBRR19XSqQfhbVsplunavDnJlChowCMdJWOIkhmVLGnibGZYYZqpmt" +
                                                              "O2cGbZfktXXM7VPxidsiR7/1QMNPK0j9MKlXtCEURwYhGCwyDBtKMwlqWuuS" +
                                                              "SZocJo0aGHyImoqkKhO2tZssJa1JLAsu4GwLfswa1ORrunsFlgTdzKzMdDOv" +
                                                              "Xoo7lf2vMqVKadC12dVVaNiL30HBWgUEM1MS+J7NMmOXoiW5HxVy5HXs2AQE" +
                                                              "wFqVoWxEzy81Q5PgA2kSLqJKWjoyBM6npYG0UgcXNLmvlZgU99qQ5F1SmsYZ" +
                                                              "afXTxcQQUNXwjUAWRub6yfhMYKV5Pit57HNl85pDD2obtCAJgMxJKqso/0xg" +
                                                              "WuRjGqQpalKIA8FY1xk9JjW/dCBICBDP9RELmue/fvWelYvOvyJo5k9DM5DY" +
                                                              "SWUWl08mZl9c0L3iixUoRrWhWwoav0BzHmUxe6QrZwDSNOdnxMGwM3h+8Ddf" +
                                                              "fegU/ShIavtISNbVbAb8qFHWM4aiUvM+qlFTYjTZR2qoluzm432kCvpRRaPi" +
                                                              "60AqZVHWR2ao/FNI5/9hi1IwBW5RLfQVLaU7fUNiI7yfMwghVfCQOngWEvHj" +
                                                              "b0b0yIieoRFJljRF0yMxU0f90aAcc6gF/SSMGnokAf6/6/ZV4bsjlp41wSEj" +
                                                              "upmOSOAVI1QMRqzRdJpqkRTsVIRJCZVGNlETJk7HJMUMo+MZ//8lc7gLc8YC" +
                                                              "ATDQAj88qBBZG3Q1Sc24fDS7vufqmfhrwvUwXOz9YyQM64bFumG+blisG8Z1" +
                                                              "w3zdsGddEgjw5W7B9YUvgCV3ASYAKNetGPraxh0H2ivACY2xGWAGJF1elKS6" +
                                                              "XfBwED8un744OHXh9dpTQRIEfElAknIzRUdBphCJztRlmgSoKpUzHNyMlM4S" +
                                                              "08pBzh8f27dt7+e4HF7wxwkrAbeQPYaQnV+iwx/0081bv//DT88e26O74V+Q" +
                                                              "TZwkWMSJqNLuN65f+bjcuUR6Lv7Sno4gmQFQBfDMJAgnQL5F/jUK0KXLQWrU" +
                                                              "pRoUTulmRlJxyIHXWjZi6mPuF+51jbx/C5h4NobbrfB02PHH3zjabGDbIrwU" +
                                                              "fcanBc8EXxoyTrz1xl/v4NvtJI16T7YfoqzLA1Q4WROHpEbXBbeYlALdH4/H" +
                                                              "jjxxZf927n9AsXS6BTuw7QaAAhPCNj/yyu6333v35JtB12cZqTFMnUHo0mQu" +
                                                              "rycOkVll9ERXd0UCrFNhBnScjq0aOKaSUjCYME7+Vb9s1XMfH2oQrqDCF8eT" +
                                                              "Vt54Avf7revJQ689MLWITxOQMde62+aSCQCf4868zjSlcZQjt+/Swm+/LJ2A" +
                                                              "VADwaykTlCNqwA5dFKoVEgPnVPTwIMSdnlknA1pZvYDN3LB3crIIb+8oZp7j" +
                                                              "MPcN9ORkaqBAnO8L2HRY3uApjE9PQRWXH3/zk1nbPjl3lataWJF5faVfMrqE" +
                                                              "e2KzLAfTt/iBaoNkjQDdnec339+gnr8GMw7DjFypARPQMlfgWTZ1ZdU7v/hl" +
                                                              "846LFSTYS2pVXUr2SjxISQ1EB7VGAGhzxpfvEZ4xVg1NA/ZyJL8xhG+McMzF" +
                                                              "05u5J2MwbpiJn7U8u+YHk+9ypxQuOJ+zV1hYCPrxlFfzLhR8fPm77/986vtV" +
                                                              "ohZYURr/fHyt/xxQEw//5bOiTebIN02d4uMfjpx+cl732o84vwtByL00V5yh" +
                                                              "AKRd3tWnMn8Ptod+HSRVw6RBtivnbZKaxcAehmrRcsppqK4LxgsrP1HmdOUh" +
                                                              "doEf/jzL+sHPzYzQR2rsz/LhHZYaZC48i20cWOzHuwDhnU2cZTlvV2Cz0oGX" +
                                                              "KsNU4IRFfeAys8ykDHCCphiPF4/58VA2lE1YLGYqGcDHUbtkPNs8tftXVRP3" +
                                                              "OuXgdCyCcpPVf+GFDR/EOf5WY9rd4ijuSajrzLQH/BuE3NfhF4DnP/igvPhB" +
                                                              "FF9N3XYFuCRfAhoGhmMZb/SpENnT9N6uJz98Wqjgdz0fMT1w9OD18KGjAlHF" +
                                                              "OWJpUSnv5RFnCaEONltRurZyq3CO3g/O7nnxh3v2C6maCqviHjj0Pf37f/82" +
                                                              "fPxPr05TalUo9lnQi5NYWvusI1QKrTrxj72PvjUACb2PVGc1ZXeW9iULnbTK" +
                                                              "yiY85nJPKK7j2sqhaRgJdIIVRDrGtgubqPDCtSXBq6fQ9ZvhWWJ76ZISri8q" +
                                                              "heXYbC728VLcjFSaSnqEJ8MtPilTNyllKzxt9jptJaRUy0pZihukHEXY4RyD" +
                                                              "tuvg6yue/naggqRgFtkb/0p+E2TKKJcriSIhI5tQFdkFEf4LEd9JyFuhuImE" +
                                                              "oLsvLHVY5a5+8uGjk8mBp1ahqyPj/VAXMd24XaWjVPXlpLainNTPj+guwN99" +
                                                              "aari8uHWuuLyHmdaVKJ47ywNF/4FXn74b/O2rB3ZcRN1+2Kf/v4pf9R/+tX7" +
                                                              "lsuHg/yWQeSTotuJQqauwgCtNSnLmlphSLbnLVbvBFSnbbFOv6u6nsL9dLzQ" +
                                                              "T2vLsPrqMqf8wP8Hy4w9hs0jkKPScAaHjMOD0XXVR28UhwWlDn7o5p/3Ferc" +
                                                              "Ak/YFjx88zqXYi2j17EyY8ex+SYj1aDzYB6BXKUP/89KN+IQHpJW25Kvvnml" +
                                                              "S7GWUex7ZcZOYnNCKM3rKPy/21V68uaVzjEy03NXgJVua9Gtpbhpk89M1le3" +
                                                              "TG79Az+v5m/D6qAGSWVV1VuIefohw6QphYtfJ8oykc5+zEj7je8xAJP5m0t/" +
                                                              "SnCegQqxHCfUXfjysvyEkZYSLADKouOlf5aRBj89iMLfXrrnGal16WAq0fGS" +
                                                              "vABFBJBg90XDOWI18MMEFr9hUfzmAoVAnzfp3BuZ1JMblhYgL7+idlAyKy6p" +
                                                              "ocqc3Lj5wauff0qc3WVVmpjAWWZCYSKuEfJI21ZyNmeu0IYV12Y/U7PMyTaN" +
                                                              "QmA3LOZ7fLcbEqCB7jXPd6q1OvKH27dPrjn3+oHQJSjEtpOABEfR7cXHhJyR" +
                                                              "hTSwPTpdCQZ5iB+4u2rf33Hhs3cCTfw0RkTRtqgcR1w+cu5yLGUY3wmSmj5S" +
                                                              "CcmU5vgZ5t5xbZDKo2ZBRRdK6Fktf5s9G2NBwutrvjP2hs7Kf8W7H3D34uK2" +
                                                              "+D4MDqpj1FyPs/Ps48tNWcPwjvKd3SGKGNxp8LV4tN8w7Kq+6jrfecPgsf4G" +
                                                              "L2T+Cz0pL0GHGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vuG3n/16frL7fytphHF8JQAA");
}
