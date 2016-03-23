package org.sunflow.core;
public final class TextureCache {
    private static java.util.HashMap<java.lang.String,org.sunflow.core.Texture>
      textures =
      new java.util.HashMap<java.lang.String,org.sunflow.core.Texture>(
      );
    private TextureCache() { super(); }
    public static synchronized org.sunflow.core.Texture getTexture(java.lang.String filename,
                                                                   boolean isLinear) {
        if (textures.
              containsKey(
                filename)) {
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  TEX,
                "Using cached copy for file \"%s\" ...",
                filename);
            return textures.
              get(
                filename);
        }
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              TEX,
            "Using file \"%s\" ...",
            filename);
        org.sunflow.core.Texture t =
          new org.sunflow.core.Texture(
          filename,
          isLinear);
        textures.
          put(
            filename,
            t);
        return t;
    }
    public static synchronized void flush() { org.sunflow.system.UI.
                                                printInfo(
                                                  org.sunflow.system.UI.Module.
                                                    TEX,
                                                  "Flushing texture cache");
                                              textures.clear(
                                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAK1ZfXBU1RW/2XyShGwSPoUQIAQdEHbF+lEn1BoCyOIGtiRm" +
       "xmBZXt7eTR55+97zvbvJJohVOx1op1BUROto/mhxVEaFdsr0A7G0ThUqdEZr" +
       "VWpF+zFT1DqV6aid2mrPufe9fR+7G7Q1M3v37r3nnnvPuef8zjk3j79LKi2T" +
       "tFKNRdiYQa3IGo0lJNOiqS5VsqxeGEvK95VL/9hybsM1IVLVTxqGJKtbliy6" +
       "VqFqyuon8xTNYpImU2sDpSlckTCpRc0RiSm61k9mKFYsY6iKrLBuPUWRoE8y" +
       "46RJYsxUBrKMxmwGjMyLw0mi/CTRzuB0R5zUy7ox5pLP9pB3eWaQMuPuZTHS" +
       "GN8mjUjRLFPUaFyxWEfOJJcaujo2qOosQnMssk290lbB+viVBSpoOxz+4KO9" +
       "Q41cBdMkTdMZF8/aRC1dHaGpOAm7o2tUmrFuIbeR8jip8xAz0h53No3CplHY" +
       "1JHWpYLTT6VaNtOlc3GYw6nKkPFAjCz0MzEkU8rYbBL8zMChhtmy88Ug7YK8" +
       "tELKAhHvvTS6774tjT8sJ+F+Ela0HjyODIdgsEk/KJRmBqhpdaZSNNVPmjS4" +
       "7B5qKpKqjNs33Wwpg5rEsnD9jlpwMGtQk+/p6gruEWQzszLTzbx4aW5Q9q/K" +
       "tCoNgqwzXVmFhGtxHASsVeBgZloCu7OXVAwrWoqR+cEVeRnbbwACWFqdoWxI" +
       "z29VoUkwQJqFiaiSNhjtAdPTBoG0UgcDNBmZU5Ip6tqQ5GFpkCbRIgN0CTEF" +
       "VFO4InAJIzOCZJwT3NKcwC157ufdDSv3bNfWaSFSBmdOUVnF89fBotbAok00" +
       "TU0KfiAW1i+N75dmHtsVIgSIZwSIBc2Pbz1/3bLW4ycEzdwiNBsHtlGZJeUD" +
       "Aw0vtHQtuaYcj1Fj6JaCl++TnHtZwp7pyBmAMDPzHHEy4kwe3/TsTbcfpO+E" +
       "SG2MVMm6ms2AHTXJesZQVGpeTzVqSoymYmQK1VJdfD5GqqEfVzQqRjem0xZl" +
       "MVKh8qEqnf8GFaWBBaqoFvqKltadviGxId7PGYSQqfAhzfCpJ+KPfzMSiw7p" +
       "GRo1lGjC1FF0KwpgMwBqHYpaWS2t6qNRy5SjujmY/y3rJo32gruAC3RJ8hCN" +
       "oEkZnyezHJ582mhZGSi1JejSKnjDOl1NUTMp78uuWnP+yeTzwlzQxG2ZAWVh" +
       "m4i9TQS3iXi3IWVlnPt03E5cFyh7GNwWcLN+Sc9X12/d1VYOdmKMVoCmkLTN" +
       "Fz+6XN92ADkpH2qeOr7w7IpnQqQiTpolmWUlFcNBpzkIQCMP275YPwCRxQX4" +
       "BR6Ax8hk6jJNwUFLAb3NpUYfoSaOMzLdw8EJP+ho0dLgX/T85Pj9o3f0fe2y" +
       "EAn5MR23rAQ4wuUJROI84rYHfbkY3/DOcx8c2r9Dd73aFySc2FawEmVoC95/" +
       "UD1JeekC6Ujy2I52rvYpgLpMAi8BQGsN7uEDjQ4HgFGWGhA4rZsZScUpR8e1" +
       "bMjUR90RbphNvD/d8aLZ8AnbbsW/cXamge0sYchoZwEpOMB/qcd46NXfvPUF" +
       "rm4nFoQ9QbyHsg4P/iCzZo40Ta7Z9pqUAt3r9yfuuffdnZu5zQLFomIbtmPb" +
       "BbgDVwhq/saJW868cfbASyHXzhmpNkwFshqay0uJE6RuEilhu4vdAwGAqeD8" +
       "aDbtN2pgoEpakQZUip717/DiFUf+tqdRGIIKI44dLbswA3f8olXk9ue3fNjK" +
       "2ZTJGEBdpblkApWnuZw7TVMaw3Pk7nhx3nefkx4CfAdMtZRxymGScCUQfmtX" +
       "cvkv4+0VgbmrsVlsea3f72CeRCcp733pval97z19np/Wnyl5L7tbMjqEfWFz" +
       "cQ7Yzwqi0zrJGgK6K45vuLlRPf4RcOwHjjKkB9ZGExAx5zMNm7qy+ve/eGbm" +
       "1hfKSWgtqVV1KbVW4l5GpoB5U2sIwDRnfPk6cbmjNdA0clFJgfAFA6jg+cWv" +
       "bk3GYFzZ4z+Z9aOVj0yc5WZmCB5z87Da4oNVnm+7nn3wt1f/7pG79o+KiL2k" +
       "NJwF1s3+10Z14M4//bNA5RzIimQTgfX90ccfnNN17Tt8vYsouLo9VxiTAJXd" +
       "tZcfzLwfaqv6VYhU95NG2c5v+yQ1i37aDzmd5SS9kAP75v35mUhGOvKI2RJE" +
       "M8+2QSxzYyH0kRr7UwPwNQ2vsM9JD5xvL3yVEd6J8SWX8HYpNsv59YWwG2Gk" +
       "yuJZdAAxmidhzCB1F9HYQqxyTQCjV092wGK88SSG+s1Ndd97socKS2gtssJD" +
       "vOfoz/r7L2mUBXFbEeJA9vjoIzXya5ln/yIWXFRkgaCb8Wh0d98r205xxK7B" +
       "MN7r6NYTpCHce8JFo1DLJ/BH4PMxflAdfIBnYbNcELBdNsKLIHQWk8zzOUhQ" +
       "1D9uaKnVhxNN4uRLS3tIcOFuZeL0r98P31HMtXixZS8Nrjvzavnldaz9O1wF" +
       "FagCnqGD/VlIielMycKN8xIg14DNjcJkZrMiqIUTN2PkLBQ/Kedm9E5fUv+V" +
       "N8XhF15A6qQcyyR7jpzZeRX35/CIAvFUVPGicJ7pK5ydNLDDV1AW1UtSPndo" +
       "94mFb/dN45WCUAGe/BpARvxeacNqOYdV7jQg01yfTPY5eIxLyqeWKVfX/OGl" +
       "x4Roi0uI5l9z64Mfn35rx9mT5aQKchZEC8mEegIKlkipUtzLoL0XeqthFaBI" +
       "g1gNhSG/c/tum/Oj+fSLkeWleOPbQpEkFkLPKDVX6VktxYHUj1K1WcPwznIr" +
       "Cf8/vnMbZBWfQn156W2sQuACzTdwi0QghjvKZryTUF1M64p39vQke29KrEn2" +
       "dW6Kda6Kr+EWa8BkWZ9j1o0uE4HmeYOfXao84QRcBQpXQcZlewN2jVwR5qKU" +
       "z3ljqydYl+WD7XQ/sgmPXv3N8FN7m8vXQvocIzVZTbklS2Mp/+1Ug2V7oM4t" +
       "89244sG5suJ31dxll7wL8jUvXBPOg3BLoSuyZWy/iM16IUJHsdQkVyIkQTQy" +
       "sgOqAklhZVrRJNWNSvnC11cEe/NYn/YAeUu9U/A3lgN37ptIbXx4hXDUZn/t" +
       "jybzxMv/ORW5/82TRYrTKUw3lqt0hKqePUMFYN/Nn3Dc1OL1hrv//NP2wVWf" +
       "pb7EsdYLVJD4e/7k4SN4lOfufHtO77VDWz9DqTg/oM4gy8e6Hz95/cXy3SH+" +
       "XiVynoJ3Lv+ijgCGACxlTc1vl4vyBnAJXuwK+LTYBtASzHdcAyywrHLsfh2b" +
       "bkbqrTFNhtJQg8ohFch7WifZIFBThNw0asQqnqgkTCUDxd+I7auXJ7bKu9oT" +
       "PFHBZT3Y3IrGOklyHOAR3dH8xvCD556wU6mC+tpHTHft+9YnkT37hBGLx8dF" +
       "Be9/3jXiAVJAQv50Cyfbha9Y+9dDO44+umOnI9kuKEUHdF2lkhYEMvy5Pcep" +
       "7pukSvs+NnsZqR2kzAZXHDFdgLlrEoD5FLUPDnSKOP/tvA3Mx7lL7Y/T/x+M" +
       "DJt9RUyrFNtJFHFokrkfYPMYgqWatYY4yQP2reHXBCMVI7qScnV28PPQWQ5c" +
       "yPsch2Xk7IK3e/HeLD85Ea6ZNXHjKxz18m/C9YBf6ayqegsdT7/KMGlaRNB6" +
       "UfaI8PIUxM1g6AUZ8Ysf9qgg+zkjdR4yhgGQ97xEv2SkHIiw+4xROuSXFUZl" +
       "rskZF9KkJxQtKpmHdmfFv0OS8qGJ9Ru2n7/qYfGcBFnQ+LidvlWLl608Ei8s" +
       "yc3hVbVuyUcNh6csdryxSRzYNd25HhvqBJ808ArnBJ5arPb8i8uZAyufPr2r" +
       "6kXAkc2kTIIManNhqZszshACN8cLsxQnWetY8sDYtcvSf3+NPyaQgieEID2U" +
       "8ve8Gjs8/OF1/PW9EoCG5ngNvnpM20TlEdOX8hTPfqf6sl9G2grx74LZLiRN" +
       "de6I778yTvDyJ8C4wB3x1JPjwj1R+2B/yXi3YTgp1jGD+9f24oCJ7cu8i80r" +
       "/wUqqvb7Fx0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
