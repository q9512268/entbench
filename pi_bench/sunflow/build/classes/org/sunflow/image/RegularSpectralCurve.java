package org.sunflow.image;
public class RegularSpectralCurve extends org.sunflow.image.SpectralCurve {
    private final float[] spectrum;
    private final float lambdaMin;
    private final float lambdaMax;
    private final float delta;
    private final float invDelta;
    public RegularSpectralCurve(float[] spectrum, float lambdaMin, float lambdaMax) {
        super(
          );
        this.
          lambdaMin =
          lambdaMin;
        this.
          lambdaMax =
          lambdaMax;
        this.
          spectrum =
          spectrum;
        delta =
          (lambdaMax -
             lambdaMin) /
            (spectrum.
               length -
               1);
        invDelta =
          1 /
            delta;
    }
    public float sample(float lambda) { if (lambda < lambdaMin ||
                                              lambda >
                                              lambdaMax) return 0;
                                        float x = (lambda - lambdaMin) *
                                          invDelta;
                                        int b0 = (int) x;
                                        int b1 = java.lang.Math.min(
                                                                  b0 +
                                                                    1,
                                                                  spectrum.
                                                                    length -
                                                                    1);
                                        float dx = x - b0;
                                        return (1 - dx) * spectrum[b0] +
                                          dx *
                                          spectrum[b1]; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUZC3AdVfXm5f9rPv2SNk2bpNV+eA8Q1BosTdKGBl/S2JQ6" +
                                                              "ptj0Zt99ybb7dre79yWvwQrtDNOCyiAUKA5EZyy21tJ2OjKKWizDyGdAZqgg" +
                                                              "IAP4G0WxIx1HcETFc+7dfft576WWmWbm3b1793zu+dzzuTl2jpTaFlnIdB7l" +
                                                              "u0xmR9fpfIBaNkt0a9S2N8HasHJ/Mf371rf7V0VI2RCZMUbtPoXarEdlWsIe" +
                                                              "Is2qbnOqK8zuZyyBGAMWs5k1Trlq6ENktmr3pkxNVVTeZyQYAmymVpw0UM4t" +
                                                              "dSTNWa9DgJPmOOwkJnYS6wx/7oiTGsUwd3ng83zg3b4vCJnyeNmc1Me303Ea" +
                                                              "S3NVi8VVm3dkLLLCNLRdo5rBoyzDo9u1axwV3BC/JkcFrSfr3vvgrrF6oYKZ" +
                                                              "VNcNLsSzNzLb0MZZIk7qvNV1GkvZO8lXSHGcVPuAOWmPu0xjwDQGTF1pPSjY" +
                                                              "fS3T06luQ4jDXUplpoIb4mRxkIhJLZpyyAyIPQOFCu7ILpBB2kVZaaWUOSLe" +
                                                              "uyJ24P6t9aeKSd0QqVP1QdyOApvgwGQIFMpSI8yyOxMJlhgiDToYe5BZKtXU" +
                                                              "ScfSjbY6qlOeBvO7asHFtMkswdPTFdgRZLPSCjesrHhJ4VDOW2lSo6Mg6xxP" +
                                                              "VilhD66DgFUqbMxKUvA7B6Vkh6onOGkJY2RlbP8cAABqeYrxMSPLqkSnsEAa" +
                                                              "pYtoVB+NDYLr6aMAWmqAA1qcNBUkiro2qbKDjrJh9MgQ3ID8BFCVQhGIwsns" +
                                                              "MJigBFZqClnJZ59z/dfeebO+Xo+QIthzgika7r8akBaGkDayJLMYnAOJWLM8" +
                                                              "fh+dc3p/hBAAnh0CljA//PL5NSsXnnlGwszPA7NhZDtT+LByaGTGiwu6l60q" +
                                                              "xm1UmIatovEDkotTNuB86ciYEGHmZCnix6j78czGp75461H2ToRU9ZIyxdDS" +
                                                              "KfCjBsVImarGrOuZzizKWaKXVDI90S2+95JymMdVncnVDcmkzXgvKdHEUpkh" +
                                                              "3kFFSSCBKqqCuaonDXduUj4m5hmTEFIOP1IDv2Ii/8STk42xMSPFYqYaG7AM" +
                                                              "FN2OQbAZAbWOxey0ntSMiZhtKTHDGs2+qykwdWwjG01r1Bo0AcmiWnfaGmdR" +
                                                              "9C3zklDNoCwzJ4qKQM0Lwodcg/Ox3tASzBpWDqS71p0/PvycdCB0ekcLnCwF" +
                                                              "flGHX1Twi+bjR4qKBJtZyFdaEuywA040hNSaZYNfumHb/lbQX8acKAElImhr" +
                                                              "ILV0e8fejdXDyonG2snFb175ZISUxEkjVXiaapgpOq1RiEHKDueY1oxA0vFi" +
                                                              "/yJf7MekZRkKS0DoKZQDHCoVxjizcJ2TWT4KbmbCMxgrnBfy7p+cOTixZ/Mt" +
                                                              "V0RIJBjukWUpRCpEH8AgnQ3G7eFjno9u3b633ztx327DO/CB/OGmvRxMlKE1" +
                                                              "7Ahh9QwryxfRR4dP724Xaq+EgMwpHCCIdQvDPALxpMONzShLBQicNKwU1fCT" +
                                                              "q+MqPmYZE96K8NAGMZ8FblGNB6wFfhXOiRNP/DrHxHGu9Gj0s5AUIvZ/dtB8" +
                                                              "6NUX/vwJoW43TdT58vsg4x2+0ITEGkUQavDcdpPFGMC9cXDgnnvP7dsifBYg" +
                                                              "2vIxbMexG0ISmBDUfNszO197681DL0U8P+eQm9MjUOJkskLiOqmaRkjgttTb" +
                                                              "D4Q2DQ4aek37jTr4p5pU6YjG8GD9u27JlY/+9c566QcarLhutPLCBLz1y7rI" +
                                                              "rc9tfX+hIFOkYGr1dOaByXg906PcaVl0F+4js+ds8wNP04cg8kO0tdVJJgJo" +
                                                              "sdBBcbCMxPM0mB6xucCWOeam6qd+Zn/nj6dkjmnNAxxKXEcOVyivp576g0S4" +
                                                              "LA+ChJt9JPb1za9sf154RAWGCVxHJdX6ggCEE5871mctNQMNMxN+TY6lmmQC" +
                                                              "GPwIoVoxLMCw1BR43jiLbYLySB/VWB+zx9wMcCnIZkD5SwpHLZ8Npr7b9sIt" +
                                                              "U22/BScYIhWqDZER9JKn8PDhvHvsrXfO1jYfF4GiBNXrqDZYseUWZIE6S2i9" +
                                                              "DofPZOz85h9wJZR8rxrYpuxvHxDmR7xPS5N9CH9F8Psv/tBUuCBN1tjtFA6L" +
                                                              "spWDaSK3ZdOU+kGmsd2Nb+148O1HpM+FK6sQMNt/4I4Po3cekCdTlp9tORWg" +
                                                              "H0eWoNIDcejC3S2ejovA6PnTid0/ObJ7n9xVY7CYWge9wiO/+s/z0YO/eTZP" +
                                                              "bocQaVDZRFyNwSqbmmcFTSBFWnt73U/vaizuAWP3koq0ru5Ms96EnybY1U6P" +
                                                              "+E6YV9iKBb9waBpOipajFXI3sCBQG4h+0ktPR3/5qZcPf+O+CSnyNAYM4c37" +
                                                              "1wZtZO/v/ik0kZON89g0hD8UO/ZgU/fqdwS+lxYRuz2TW2HBAfJwrzqa+kek" +
                                                              "teznEVI+ROoVp3/bTLU0JpshOCK229RBjxf4Huw/ZLHdkU37C8JO5WMbTsh+" +
                                                              "S5XwgFUa5PErIiIFfUFgfEyMy3G4XFgmgtMo+o2qU03gdUGC05g+yscE8FrH" +
                                                              "c/GxnpNiOPg4vc5n5IgkJd7ncSedoGjQ0Rg6w8zkfpPFpGpEs90kfMznLs0B" +
                                                              "d+kTscXT/Rsz7v79Y+2jXRdTReLawgvUifjeAoZfXtgDw1t5eu9fmjatHtt2" +
                                                              "EQVhS8itwiS/13fs2euXKndHRMMqnSKn0Q0idQRdocpi0JnrwWPaJh1CWE96" +
                                                              "Aw4rhH3F+xVZOxBhBxmJtWm+iXpLBfdR0NDSL6YB35mziuVHS/7CZl3K5KIU" +
                                                              "mfzR3B9ce3jqTVGDmRkS9hZ87Rf0O8UgptdMs40JHJbY/so8aGbf/cywctdL" +
                                                              "79Zufvfx8zkxJliI9lGzwzt3SzHUzw13TuupPQZwV5/pv6leO/OByMvVVIEk" +
                                                              "am+woG3LBMpWB7q0/NdPPDln24vFJNJDqiC8J3qo6ABIJZTeUBVAx5cxr1sj" +
                                                              "65kJLD3rhagkR/hc9eMCd47yfLFYKuafz1ZMjQjY5ha57tNfwDsRZk+BCMNJ" +
                                                              "OVQz45CfcXEoVDU3TEOZkwpbdKTpFL6vkp0CjkLReyWpmwuKHhLicpTOYVVa" +
                                                              "QIg7pgmTtxXafyGinFRqNDWSoH2qnnVPnwBfvQQC3I3D1zzONJOP8z0Xyfnj" +
                                                              "8CtzOJcV4Hz/R1FdIaIQUhJM4zTf5g9egs1/C4cHwOFUfXxtIcbfnoZxxhdR" +
                                                              "s+yzLAPXTT72vnNHMGI0F7oRFIXhob0HphIbHr7SrZF7wczcMC/X2DjTfKSK" +
                                                              "xJxlt4GKJnPdvbpPvxY8QUMSZDvbQqihMOsLyTIOn5wmDp/C4ftQbtg0Zcrr" +
                                                              "u05P28cuZOb/K7JByZHvcgvzzrycS3J5sascn6qrmDt14yuyB3IvX2ugTkim" +
                                                              "Nc1fcfnmZabFkqrYeY3MA6Z4/JiThpwLN3Bv8RTbfkwCnuak2gfIsfIWMz/Q" +
                                                              "GajAAAinT5huUdWSe6EXEDZTFPSzrIpnX0jFPtdsC+RK8W8It3xJy39EDCsn" +
                                                              "pm7ov/n8Jx+WtzWKRicnkUo1dBHy4ihbAi0uSM2lVbZ+2QczTlYucZ29QW7Y" +
                                                              "89T5Pk/i4HMm2rQpdJVht2dvNF47dO3jv9hfdhay7hZSRKFO3ZJbhGfMNJzC" +
                                                              "LfHcbgnKRXHH0rHsm7tWr0z+7XVRjpCc5iYMD03GPa/2ntzx/hpx710K55hl" +
                                                              "RHewdpe+kSnjVqD1moHuRvEfEkIPjvpqs6t4t8dJa27fmXsjCrXCBLO6jLSe" +
                                                              "QDLQvFV7K4H/hzguXJU2zRCCt+Jr7Ptw6Mqg9sEdh+N9pum25edMcfD6C9do" +
                                                              "L4kpDi//D6VXw1yRHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVaeezsRn33+728I+d7CZCkKblfKMnCs/feJdCytvew1157" +
       "17veXZfy8Ppen+tj7TVNCUg0UZFSRANNJchfoQcKh2gRVBVtKlQOgZBAqKWV" +
       "SmhVqbQUifxRWpW2dOz93e8IQWWlHY/H35n5XvP5fmfs538AnQp8qOC51kaz" +
       "3PCikoQXl1b1YrjxlOAiSVVZ0Q8UGbPEIBiDtkvSA58696Mfv18/vwOdFqBX" +
       "iY7jhmJouE4wUgLXWisyBZ07aG1bih2E0HlqKa5FOAoNC6aMIHyUgm481DWE" +
       "LlB7LMCABRiwAOcswK0DKtDpZsWJbCzrITphsIJ+AzpBQac9KWMvhO4/Oogn" +
       "+qK9OwybSwBGOJvd80CovHPiQ/fty76V+TKBP1iAn/7dt5//9EnonACdMxwu" +
       "Y0cCTIRgEgG6yVbsheIHLVlWZAG61VEUmVN8Q7SMNOdbgG4LDM0Rw8hX9pWU" +
       "NUae4udzHmjuJimTzY+k0PX3xVMNxZL37k6plqgBWW8/kHUrYSdrBwLeYADG" +
       "fFWUlL0u15mGI4fQvcd77Mt4oQ8IQNczthLq7v5U1zkiaIBu29rOEh0N5kLf" +
       "cDRAesqNwCwhdNdVB8107YmSKWrKpRC68zgdu30EqK7PFZF1CaHXHCfLRwJW" +
       "uuuYlQ7Z5weDNz/1Tqfn7OQ8y4pkZfyfBZ3uOdZppKiKrziSsu140yPUh8Tb" +
       "P//kDgQB4tccI97SfPbXX3rrG+554ctbml+8Ag2zWCpSeEl6bnHLN16LPdw8" +
       "mbFx1nMDIzP+Eclz92d3nzyaeGDl3b4/Yvbw4t7DF0ZfnD/+MeX7O9ANBHRa" +
       "cq3IBn50q+TanmEpfldxFF8MFZmArlccGcufE9AZUKcMR9m2MqoaKCEBXWfl" +
       "Tafd/B6oSAVDZCo6A+qGo7p7dU8M9byeeBAEnQF/6CbwPwltf/k1hEaw7toK" +
       "7Bkw67uZ6AGsOOECqFWHg8hRLTeGA1+CXV/bvzdsYGp4pGiRJfqcBzr5ooVF" +
       "/lq5mPmW93MZNclkOR+fOAHU/Nrji9wC66PnWrLiX5KejtD2S5+49NWdfaff" +
       "1UIIvQ7Md3F3vov5fBevNB904kQ+zauzebeWBHYwwYoGWHfTw9yvke948gGg" +
       "v8SLrwNKzEjhq0MudoABRI50EnBE6IVn4nfz70J2oJ2j2JnxCppuyLqzGeLt" +
       "I9uF42vmSuOee+J7P/rkhx5zD1bPETDeXdSX98wW5QPHteq7kiIDmDsY/pH7" +
       "xM9c+vxjF3ag68BKB+gWisAbAXDcc3yOI4vz0T2gy2Q5BQRWXd8WrezRHjrd" +
       "EOq+Gx+05Oa+Ja/fCnR8Y+at94L/2V33za/Z01d5WfnqrXtkRjsmRQ6kb+G8" +
       "j3z76/9SztW9h7nnDkUxTgkfPbTOs8HO5Sv61gMfGPuKAuj+/hn2dz74gyd+" +
       "NXcAQPHglSa8kJUYWN/AhEDN7/3y6m9f/M5z39o5cJoQBLpoYRlSsi9k1g7d" +
       "cA0hwWyvO+AH4IQFvDbzmgsTx3ZlQzXEhaVkXvrf5x4qfubfnjq/9QMLtOy5" +
       "0RtefoCD9l9Aoce/+vb/uCcf5oSUxakDnR2QbcHvVQcjt3xf3GR8JO/+5t2/" +
       "9yXxIwBGAXQFRqrkaHQy18FJ0Omhqy+cfJAtbj/7+w9+/V3PPvgPgA8BOmsE" +
       "IOK3fO0KgeRQnx8+/+L3v3nz3Z/IffW6hRjkOHDD8Qh8eYA9Ejdzv7pp30QZ" +
       "gmaVnc9tLbS9hhD1MwCe5PpKltUEig9zWJ6o+HsA+v86XgL0/PA1ckLfsIHX" +
       "r3fjKPzYbS+aH/7ex7cx8njQPUasPPn0b/3k4lNP7xzKTB68LDk43GebneRq" +
       "vXmr1p+A3wnw/9/sn6kza9iq9TZsN0Tetx8jPS8T5/5rsZVP0fnnTz72Z3/4" +
       "2BNbMW47GpjbIO/8+F//z9cuPvPdr1whTgCEcMVtQnoxW6v7MH8NLXYypzpA" +
       "yjv/i7EW7/nH/8xHvwzgr6DYY/0F+PkP34X98vfz/gdIm/W+J7k8AoIFcdC3" +
       "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" +
       "7f8AUvqBW28nAAA=");
}
