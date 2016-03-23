package org.sunflow.image;
public class BlackbodySpectrum extends org.sunflow.image.SpectralCurve {
    private float temp;
    public BlackbodySpectrum(float temp) { super();
                                           this.temp = temp; }
    public float sample(float lambda) { double wavelength = lambda * 1.0E-9;
                                        return (float) (3.74183E-16 * java.lang.Math.
                                                          pow(
                                                            wavelength,
                                                            -5.0) /
                                                          (java.lang.Math.
                                                             exp(
                                                               0.014388 /
                                                                 (wavelength *
                                                                    temp)) -
                                                             1.0));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1Ye2wcRxmfOz/jR/zIs47tJLaTykl615QGGjmExI7dOJwf" +
                                                              "slNLnCHO3N6cvfHe7mZ31j67NaShKAaJKLRpElDrv1K1RGkTISpA0CqogrZq" +
                                                              "QWoptAU1RYBEoEQ0QrSIAOWbmX3f2aESJ93c3sz3fTPf6/d9sxevoxLTQM1E" +
                                                              "pTE6oxMz1q3SQWyYJN2lYNM8CHNj0tki/LdD1/p3RlFpEi2fwGafhE3SIxMl" +
                                                              "bSZRk6yaFKsSMfsJSTOOQYOYxJjCVNbUJFolm71ZXZElmfZpacIIRrCRQHWY" +
                                                              "UkNOWZT02gIoakrASeL8JPG94eWOBKqSNH3GI1/rI+/yrTDKrLeXSVFt4gie" +
                                                              "wnGLyko8IZu0I2egrbqmzIwrGo2RHI0dUXbYJjiQ2JFngpbLNR/cPDVRy02w" +
                                                              "AquqRrl65hAxNWWKpBOoxpvtVkjWPIq+iIoSqNJHTFFbwtk0DpvGYVNHW48K" +
                                                              "Tl9NVCvbpXF1qCOpVJfYgSjaGBSiYwNnbTGD/MwgoZzaunNm0HaDq63QMk/F" +
                                                              "R7fGT589VPudIlSTRDWyOsyOI8EhKGySBIOSbIoY5t50mqSTqE4FZw8TQ8aK" +
                                                              "PGt7ut6Ux1VMLXC/YxY2aenE4Ht6tgI/gm6GJVHNcNXL8ICy/5VkFDwOuq72" +
                                                              "dBUa9rB5ULBChoMZGQxxZ7MUT8pqmqL1YQ5Xx7bPAgGwlmUJndDcrYpVDBOo" +
                                                              "XoSIgtXx+DCEnjoOpCUaBKBBUcOiQpmtdSxN4nEyxiIyRDcoloBqGTcEY6Fo" +
                                                              "VZiMSwIvNYS85PPP9f5dJ+9X96tRFIEzp4mksPNXAlNziGmIZIhBIA8EY9WW" +
                                                              "xBm8+rn5KEJAvCpELGi+98CNPduar7wkaNYVoBlIHSESHZPOp5a/1tjVvrOI" +
                                                              "HaNc10yZOT+gOc+yQXulI6cDwqx2JbLFmLN4Zeinnzt2gbwXRRW9qFTSFCsL" +
                                                              "cVQnaVldVohxL1GJgSlJ96JlRE138fVeVAbPCVklYnYgkzEJ7UXFCp8q1fh/" +
                                                              "MFEGRDATVcCzrGY051nHdII/53SEUBl8URV8i5D48F+KBuITWpbEdTk+aGhM" +
                                                              "dTMOYJMCs07ETUvNKNp03DSkuGaMu//lLLg63qmAz1NaemZYBzbDysZYYOn/" +
                                                              "f5E5psWK6UgEDNwYTm/gIPs1JU2MMem01dl945mxV0TosHC39aeoFTaL2ZvF" +
                                                              "+GaxvM1QJML3WMk2FQ4E809CIgOSVrUPf+HA4fkWMFtOny4G2zHSlkBF6fKy" +
                                                              "3YHoMelSffXsxqvbX4ii4gSqxxK1sMIKxF5jHKBHmrSzsyoFtcaD/A0+yGe1" +
                                                              "ytAkkgbEWQz6bSnl2hQx2DxFK30SnILEUi++eDkoeH505dz0gyNfujOKokGU" +
                                                              "Z1uWAEAx9kGGzS4Gt4Wzu5DcmhPXPrh0Zk7z8jxQNpxql8fJdGgJR0HYPGPS" +
                                                              "lg342bHn5tq42ZcBDlMMeQMQ1xzeIwAjHQ4kM13KQeGMZmSxwpYcG1fQCUOb" +
                                                              "9mZ4eNbx55UQFpUsrxrhW2onGv9lq6t1Nq4R4cziLKQFh/xPD+uPv/XzP32C" +
                                                              "m9upDjW+sj5MaIcPkZiweo49dV7YHjQIAbp3zg0+8uj1E6M8ZoGitdCGbWzs" +
                                                              "AiQCF4KZv/LS0bffvXr+jagX5xRKspWCzibnKsnmUcUSSsJum73zAKIpkGMs" +
                                                              "atruUyE+5YyMUwphifWvmk3bn/3LyVoRBwrMOGG07dYCvPnbOtGxVw592MzF" +
                                                              "RCRWUT2beWQCpld4kvcaBp5h58g9+HrTN1/EjwPgA8ia8izhuBkplOssn4at" +
                                                              "lAl5KWfBDVN2Cbpr8LA03zb4B1FebivAIOhWPRX/+sibR17lTi5nmc/mmd7V" +
                                                              "vrwGhPBFWK0w/kfwicD3P+zLjM4mBJTXd9n1ZINbUHQ9BydvX6IDDCoQn6t/" +
                                                              "d/Kxa08LBcIFN0RM5k9/7aPYydPCc6Irac1rDPw8ojMR6rBhJzvdxqV24Rw9" +
                                                              "f7w098On5k6IU9UHa2w3tJBP/+rfr8bO/fblAsAPKaRh0VveHXDnyqB3hEr7" +
                                                              "vlrzo1P1RT2AGr2o3FLloxbpTftlQltlWimfu7x+h0/4lWOuoSiyBbzAp3fw" +
                                                              "Y9zpHgbxwyC+tp8Nm0w/eAad5eucx6RTb7xfPfL+8ze4wsHW248VfVgX1q5j" +
                                                              "w2Zm7TXh4rYfmxNAd/eV/s/XKldugsQkSJSg3zQHDCiruQCy2NQlZb/+8Qur" +
                                                              "D79WhKI9qAIsnO7BHKTRMkBHYk5ARc7pn9kjwGG6HIZarirKUz5vgiXo+sKp" +
                                                              "353VKU/W2e+v+e6uJxeucpTShYx1rmsbA1WZX+C8wnDhF5/65ZPfODMtgmmJ" +
                                                              "1Ajxrf3ngJI6/rt/5Jmc18EC2RLiT8YvPtbQtfs9zu8VJMbdlstvbKCoe7x3" +
                                                              "Xcj+PdpS+pMoKkuiWsm+MI1gxWIwn4RLguncouBSFVgPNvyiu+1wC25jOF19" +
                                                              "24ZLoT8Himkg3r3qxzpMtMapEM6vv/pFEH9Icpbb+biFDXc4xaZMN2S4VJNQ" +
                                                              "talcQiiFA5Esf75HVFc29rJhVIhJFIpFsXQ7G7a6m7nlLNAo+0ubF2yIZVTT" +
                                                              "YncZjl3nj59eSA88sT1q5/keCimi6XcoZIooobhtCsRtH7+9eUHwzvKHf/+D" +
                                                              "tvHOj9NIsrnmW7SK7P96iMAti6dC+CgvHv9zw8HdE4c/Rk+4PmSlsMhv9118" +
                                                              "+d7N0sNRflUV0Zl3xQ0ydQRjssIgcCdXg0jc6vq1zonMCtuvFYX7sgIh4XY7" +
                                                              "i7GGcN0uMjwcuVRzCeC32AAXy1ITZ3Vxk7vHC19tifD9H6CUTQzpOYrq8m47" +
                                                              "DGbX5r0sERd86ZmFmvI1C/e9yWPNvYRXQdRkLEXxA4HvuVQ3SEbmSlUJWND5" +
                                                              "zxxsn3f9gsrMf/mZHxCExyiq9BFSVmr5k5/oyxQVARF7fEjnC2shUvKvd0JP" +
                                                              "rHRZxhTJRYJZ69p31a3s60v01kCC8NdRTjBb4oUU3PYWDvTff+OTT4j2XVLw" +
                                                              "7Cx/fQFtg7hJuAmxcVFpjqzS/e03l19etsmBjjpxYC9M1/nCaAgCTmc+bQj1" +
                                                              "tmab2+K+fX7X8z+bL30dStAoimCKVozm14acbgESjSby2yMAD950d7R/a2b3" +
                                                              "tsxff8Orb37NDdND7Xvkrd7Lkx/u4e8/SgAVSY4XrX0z6hCRpoxAr7WchRtm" +
                                                              "L6a4HWzzVbuz7LJHUUt+o5l/RYbOZJoYnZqlpu1urdKbCbwXczDE0vUQgzfj" +
                                                              "a8b3iQaPWR/CcSzRp+t2Hx7ZpPOs6y6EBt2c+Sx/ZMO5/wKi8uW4mRYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "428//82ipPQ/+gGjXDIgAAA=");
}
