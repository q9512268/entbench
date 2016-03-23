package org.sunflow.image;
public class IrregularSpectralCurve extends org.sunflow.image.SpectralCurve {
    private final float[] wavelengths;
    private final float[] amplitudes;
    public IrregularSpectralCurve(float[] wavelengths, float[] amplitudes) {
        super(
          );
        this.
          wavelengths =
          wavelengths;
        this.
          amplitudes =
          amplitudes;
        if (wavelengths.
              length !=
              amplitudes.
                length)
            throw new java.lang.RuntimeException(
              java.lang.String.
                format(
                  ("Error creating irregular spectral curve: %d wavelengths and " +
                   "%d amplitudes"),
                  wavelengths.
                    length,
                  amplitudes.
                    length));
        for (int i =
               1;
             i <
               wavelengths.
                 length;
             i++)
            if (wavelengths[i -
                              1] >=
                  wavelengths[i])
                throw new java.lang.RuntimeException(
                  java.lang.String.
                    format(
                      ("Error creating irregular spectral curve: values are not sort" +
                       "ed - error at index %d"),
                      i));
    }
    public float sample(float lambda) { if (wavelengths.length ==
                                              0) return 0;
                                        if (wavelengths.length ==
                                              1 ||
                                              lambda <=
                                              wavelengths[0])
                                            return amplitudes[0];
                                        if (lambda >= wavelengths[wavelengths.
                                                                    length -
                                                                    1])
                                            return amplitudes[wavelengths.
                                                                length -
                                                                1];
                                        for (int i = 1; i <
                                                          wavelengths.
                                                            length;
                                             i++) { if (lambda <
                                                          wavelengths[i]) {
                                                        float dx =
                                                          (lambda -
                                                             wavelengths[i -
                                                                           1]) /
                                                          (wavelengths[i] -
                                                             wavelengths[i -
                                                                           1]);
                                                        return (1 -
                                                                  dx) *
                                                          amplitudes[i -
                                                                       1] +
                                                          dx *
                                                          amplitudes[i];
                                                    } }
                                        return amplitudes[wavelengths.
                                                            length -
                                                            1];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYDXAVVxW+7+WX/JAffhtIgCSg/PS9UouKQUoSSAm+hEgo" +
       "jqESNvvuS5bs211270tegtjCTAdaRwZbSmmnzTgjFUQKTMeOOtqKMtJ2WjtT" +
       "rLa1U/BvFEUUxrF1RK3n3Lv79ue9F6wzfTO7b/fuOefec853fu49eZUUWSZp" +
       "oBqLsDGDWpF1GuuRTIvG21XJsjbDWL/8aIH0t22Xu1eGSXEfmTokWV2yZNEO" +
       "hapxq4/UK5rFJE2mVjelceToMalFzRGJKbrWR2YoVmfSUBVZYV16nCLBFsmM" +
       "kRqJMVMZSDHaaQtgpD4GK4nylURbg59bYqRC1o0xl3y2h7zd8wUpk+5cFiPV" +
       "sR3SiBRNMUWNxhSLtaRNstTQ1bFBVWcRmmaRHeoK2wQbYiuyTNB4purdGweH" +
       "qrkJpkmapjOunrWJWro6QuMxUuWOrlNp0tpJvkQKYqTcQ8xIc8yZNAqTRmFS" +
       "R1uXClZfSbVUsl3n6jBHUrEh44IYWeAXYkimlLTF9PA1g4RSZuvOmUHb+Rlt" +
       "hZZZKj6yNHro0W3VzxSQqj5SpWi9uBwZFsFgkj4wKE0OUNNqjcdpvI/UaODs" +
       "XmoqkqqM256utZRBTWIpcL9jFhxMGdTkc7q2Aj+CbmZKZrqZUS/BAWW/FSVU" +
       "aRB0nenqKjTswHFQsEyBhZkJCXBnsxQOK1qckXlBjoyOzZ8BAmAtSVI2pGem" +
       "KtQkGCC1AiKqpA1GewF62iCQFukAQJORurxC0daGJA9Lg7QfERmg6xGfgGoK" +
       "NwSyMDIjSMYlgZfqAl7y+Odq96oDu7T1WpiEYM1xKqu4/nJgaggwbaIJalKI" +
       "A8FYsSR2WJr53P4wIUA8I0AsaL7zxetrljWcfVHQzMlBs3FgB5VZv3x0YOpr" +
       "c9sXryzAZZQauqWg832a8yjrsb+0pA3IMDMzEvFjxPl4dtP5z993gl4Jk7JO" +
       "UizraioJOKqR9aShqNS8i2rUlBiNd5IpVIu38++dpASeY4pGxejGRMKirJMU" +
       "qnyoWOfvYKIEiEATlcGzoiV059mQ2BB/ThuEkBK4SIV9Oc+Ekc3RIT1Jo4YS" +
       "7TF1VN2KQrIZALMORa2UllD10ahlylHdHMy8K0lwdbTTNOlgSpXMXgPYTElt" +
       "T5kjNILoMj4kuWnUZ9poKASmnhsMdBViZL2uxqnZLx9Kta27fqr/ZQEiBL5t" +
       "CUY+CjNG7BkjfMZI7hlJKMQnmo4zC3+CN4YhriGxVizu/cKG7fsbCwBIxmgh" +
       "mBJJG30Fpt0Nfidj98unayvHF1xcfi5MCmOkVpJZSlKxXrSag5CJ5GE7WCsG" +
       "oPS4FWC+pwJg6TJ1mcYhAeWrBLaUUn2EmjjOyHSPBKc+YSRG81eHnOsnZ4+M" +
       "7tly721hEvYnfZyyCPIVsvdgqs6k5OZgsOeSW7Xv8runD+/W3bD3VRGn+GVx" +
       "og6NQSgEzdMvL5kvPdv/3O5mbvYpkJaZBGEEGa8hOIcvq7Q4GRp1KQWFE7qZ" +
       "lFT85Ni4jA2Z+qg7wjFaw5+nAyzKMcwWwDXbjjv+j19nGnifJTCNOAtowSvA" +
       "p3uNJ9989Y8f4+Z2ikWVp8r3UtbiSVAorJanohoXtptNSoHunSM9Dz9ydd9W" +
       "jlmgaMo1YTPe2yExgQvBzPe/uPOtSxePvh52cc6gQqcGoNFJZ5TEcVI2iZIw" +
       "2yJ3PZDgVAg0RE3z3RrgU0ko0oBKMbD+VbVw+bN/PlAtcKDCiAOjZTcX4I7f" +
       "0kbue3nbew1cTEjGAuvazCUTWXuaK7nVNKUxXEd6z4X6x16QnoT8DznXUsYp" +
       "T6NhboOwv5nEeOpNDViMc4tKc0/5+R9aX//9M6LSNOYgDpSv48dK5beT538n" +
       "GG7JwSDoZhyPfmXLGzte4YgoxTSB42ikSk8SgHTigWN1xlNT0THT4KqzPVUn" +
       "ykDv/5GuZd0EDlNJAvJGaHQzNEnaoEq7qDXkVIEPQ2wajL8wf9by+GDiG02v" +
       "3jvR9GsAQR8pVSzIjGCXHO2Hh+fayUtXLlTWn+KJohDNa5vW37dlt2W+botb" +
       "vQpvn0pbud3f42go5r29Z7u8v7mHux/5Pilc9j78QnD9By90FQ4Il9W22+3D" +
       "/Ez/YBg42+JJGn7/pNHdtZeGn7j8tMBcsL8KENP9hx58P3LgkIhM0YQ2ZfWB" +
       "Xh7RiAoE4q0NV7dgslk4R8cfTu/+/vHd+8Sqav0t1TrYMTz9i3+/Ejnyq5dy" +
       "VHdIkbokthJ3YLLKlObpfhcIldY+UPWDg7UFHeDsTlKa0pSdKdoZ98oEv1qp" +
       "AU+Eue0tH/Aqh65hJLQEvZC9gLm+3oDvKt3ydOJnn/j5sa8eHhUqT+LAAN/s" +
       "f25UB/b+5h/cElnVOIdPA/x90ZNP1LWvvsL53bKI3M3p7B4LAsjlvf1E8u/h" +
       "xuKfhElJH6mW7V3cFklNYbHpgxCxnK0d7PR83/27ENFyt2TK/twgqDzTBguy" +
       "11OFzOeVGhF+IcJL0Oc4x0f4fQnebhWZHB8jiBtFk1TO1wYFTqXaIBvixGtt" +
       "5OLfekYKIPDx8U6Pk52igO+zmV1OUDXY1+gaxcrkfBPNpKJHMntK+JgLLvU+" +
       "uHTx3OLa/p2pD/32e82DbR+ki8Sxhpv0ifg+Dxy/JD8Cg0t5Ye+f6javHtr+" +
       "ARrCeQFYBUV+s+vkS3ctkh8K822rAEXWdtfP1OKHQplJYX+u+cO0SQCCe0+g" +
       "AW9LuX/5+20ZPxDuB5GJ1Um+8X5LAfjI6GiBi0nId2aNYvsxL3djsy5pMN6K" +
       "jH931rdXHZu4yHswI02CaMHXbi5/Jb+vmGQFo3hbaHmbcr+HPQc0/fLB169V" +
       "brn2/PWs9OLvQbsko8UNuUWY5WcFN03rJWsI6O44231PtXr2Bi/J5ZIM9dPa" +
       "aMKeLe3rWG3qopJf/ujczO2vFZBwBymDzB7vkHjzT6ZA1w0NAWz30sada0Qr" +
       "M1oKt2quKslSPtvyOMDsKJ7jieDPZpqlWiRcBFel3SxVBnt3O7nsyZNcGCmB" +
       "RmYESjMO9gUa5ppJJDNSPiqNUE8eWin2CXjntt4rpO3Kq31Aj4VO9+f859Dj" +
       "wUmS5P35VMgnlJEyCQ9EWSpOc2rw5Uk0SHsCNDMl/xWTwBmGd5vh+pIgCuvz" +
       "HTPxPuPo3kMT8Y1PLXdark4GsNKNW1UKhveICvFnmlkGKk1mwdVoL6MxaE5X" +
       "0YAGmY1SPtZA6HoivJVLnZgktr+Gt8egellodw65Vtfaj98ML/9TtMBGKvdp" +
       "CSay2Vlnr+K8UD41UVU6a+LuN0RT7ZzpVUDhSaRU1VvCPc/FhkkTCl97hcgu" +
       "Bv87zkhN1hkOpGD+zxd+TBB+C4LIQ8iwleNPXqJTUNKBCB9PG06Vnpd9RuRT" +
       "Nh3yIy1j5Bk3M7IHnE2+DMxPt516mBLn2/3y6YkN3buuf/wpsf2XVWl8HKWU" +
       "Q1sqTiIyNXVBXmmOrOL1i29MPTNloQP3GrFgF6tzPFhigDoDfVoX2BtbzZkt" +
       "8ltHVz3/0/3FFyCXbyUhCRqfrdldXdpIQRxujWW339B/8E17y+LHx1YvS/z1" +
       "bV7fSFa3HKSHrvXhNzvPDL+3hh+nFkEk0zRvN9eOaZuoPGL6evmpCDcJz7m5" +
       "HWzzVWZG8bCIkcbsjUz2ERtUoFFqtukpLc67CqiJ7ojvmN2GcFnKMAIM7ohn" +
       "p9jFe5A0Wh/g2B/rMgxnn/cXg4ded/6i/2P+iLdz/wVmroGM6BoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
