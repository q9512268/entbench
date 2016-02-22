package org.sunflow.core.camera;
public class ThinLens implements org.sunflow.core.CameraLens {
    private float au;
    private float av;
    private float aspect;
    private float fov;
    private float focusDistance;
    private float lensRadius;
    private int lensSides;
    private float lensRotation;
    private float lensRotationRadians;
    public ThinLens() { super();
                        focusDistance = 1;
                        lensRadius = 0;
                        fov = 90;
                        aspect = 1;
                        lensSides = 0;
                        lensRotation = (lensRotationRadians = 0); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        fov =
          pl.
            getFloat(
              "fov",
              fov);
        aspect =
          pl.
            getFloat(
              "aspect",
              aspect);
        focusDistance =
          pl.
            getFloat(
              "focus.distance",
              focusDistance);
        lensRadius =
          pl.
            getFloat(
              "lens.radius",
              lensRadius);
        lensSides =
          pl.
            getInt(
              "lens.sides",
              lensSides);
        lensRotation =
          pl.
            getFloat(
              "lens.rotation",
              lensRotation);
        update(
          );
        return true;
    }
    private void update() { au = (float) java.lang.Math.tan(java.lang.Math.
                                                              toRadians(
                                                                fov *
                                                                  0.5F)) *
                                   focusDistance;
                            av = au / aspect;
                            lensRotationRadians = (float) java.lang.Math.
                                                    toRadians(
                                                      lensRotation);
    }
    public org.sunflow.core.Ray getRay(float x, float y, int imageWidth,
                                       int imageHeight,
                                       double lensX,
                                       double lensY,
                                       double time) { float du = -au +
                                                        2.0F *
                                                        au *
                                                        x /
                                                        (imageWidth -
                                                           1.0F);
                                                      float dv = -av +
                                                        2.0F *
                                                        av *
                                                        y /
                                                        (imageHeight -
                                                           1.0F);
                                                      float eyeX;
                                                      float eyeY;
                                                      if (lensSides <
                                                            3) { double angle;
                                                                 double r;
                                                                 double r1 =
                                                                   2 *
                                                                   lensX -
                                                                   1;
                                                                 double r2 =
                                                                   2 *
                                                                   lensY -
                                                                   1;
                                                                 if (r1 >
                                                                       -r2) {
                                                                     if (r1 >
                                                                           r2) {
                                                                         r =
                                                                           r1;
                                                                         angle =
                                                                           0.25 *
                                                                             java.lang.Math.
                                                                               PI *
                                                                             r2 /
                                                                             r1;
                                                                     }
                                                                     else {
                                                                         r =
                                                                           r2;
                                                                         angle =
                                                                           0.25 *
                                                                             java.lang.Math.
                                                                               PI *
                                                                             (2 -
                                                                                r1 /
                                                                                r2);
                                                                     }
                                                                 }
                                                                 else {
                                                                     if (r1 <
                                                                           r2) {
                                                                         r =
                                                                           -r1;
                                                                         angle =
                                                                           0.25 *
                                                                             java.lang.Math.
                                                                               PI *
                                                                             (4 +
                                                                                r2 /
                                                                                r1);
                                                                     }
                                                                     else {
                                                                         r =
                                                                           -r2;
                                                                         if (r2 !=
                                                                               0)
                                                                             angle =
                                                                               0.25 *
                                                                                 java.lang.Math.
                                                                                   PI *
                                                                                 (6 -
                                                                                    r1 /
                                                                                    r2);
                                                                         else
                                                                             angle =
                                                                               0;
                                                                     }
                                                                 }
                                                                 r *=
                                                                   lensRadius;
                                                                 eyeX =
                                                                   (float)
                                                                     (java.lang.Math.
                                                                        cos(
                                                                          angle) *
                                                                        r);
                                                                 eyeY =
                                                                   (float)
                                                                     (java.lang.Math.
                                                                        sin(
                                                                          angle) *
                                                                        r);
                                                      }
                                                      else {
                                                          lensY *=
                                                            lensSides;
                                                          float side =
                                                            (int)
                                                              lensY;
                                                          float offs =
                                                            (float)
                                                              lensY -
                                                            side;
                                                          float dist =
                                                            (float)
                                                              java.lang.Math.
                                                              sqrt(
                                                                lensX);
                                                          float a0 =
                                                            (float)
                                                              (side *
                                                                 java.lang.Math.
                                                                   PI *
                                                                 2.0F /
                                                                 lensSides +
                                                                 lensRotationRadians);
                                                          float a1 =
                                                            (float)
                                                              ((side +
                                                                  1.0F) *
                                                                 java.lang.Math.
                                                                   PI *
                                                                 2.0F /
                                                                 lensSides +
                                                                 lensRotationRadians);
                                                          eyeX =
                                                            (float)
                                                              ((java.lang.Math.
                                                                  cos(
                                                                    a0) *
                                                                  (1.0F -
                                                                     offs) +
                                                                  java.lang.Math.
                                                                  cos(
                                                                    a1) *
                                                                  offs) *
                                                                 dist);
                                                          eyeY =
                                                            (float)
                                                              ((java.lang.Math.
                                                                  sin(
                                                                    a0) *
                                                                  (1.0F -
                                                                     offs) +
                                                                  java.lang.Math.
                                                                  sin(
                                                                    a1) *
                                                                  offs) *
                                                                 dist);
                                                          eyeX *=
                                                            lensRadius;
                                                          eyeY *=
                                                            lensRadius;
                                                      }
                                                      float eyeZ =
                                                        0;
                                                      float dirX =
                                                        du;
                                                      float dirY =
                                                        dv;
                                                      float dirZ =
                                                        -focusDistance;
                                                      return new org.sunflow.core.Ray(
                                                        eyeX,
                                                        eyeY,
                                                        eyeZ,
                                                        dirX -
                                                          eyeX,
                                                        dirY -
                                                          eyeY,
                                                        dirZ -
                                                          eyeZ);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZe2wcxRmfO8fP+J3ESZzEeTmp8uAOKClFTimOSYjDJXHt" +
       "JBJOm8vc3py98d7usjtrnx3SQlCVtFJTCiHQCvJXIiAKBFWgtmqhqWh5CPqA" +
       "hgJFQNVSNS2lEFWFqrSl3zeze7u397AslZN2bm72++Z7zDe/75u5s++Satsi" +
       "XUznMT5pMju2WecD1LJZuk+jtr0LxpLKPVX07/su7rgmSmqGSfMotbcr1GZb" +
       "VKal7WGyRNVtTnWF2TsYSyPHgMVsZo1Trhr6MJmn2v1ZU1MVlW830gwJ9lAr" +
       "Qdoo55aacjjrdyfgZEkCNIkLTeK94dc9CdKoGOakT74gQN4XeIOUWV+WzUlr" +
       "4gAdp3GHq1o8odq8J2eRdaahTY5oBo+xHI8d0Da4LtiW2FDkghWPtnzw0R2j" +
       "rcIFc6iuG1yYZw8y29DGWTpBWvzRzRrL2jeTL5OqBJkdIOakO+EJjYPQOAj1" +
       "rPWpQPsmpjvZPkOYw72ZakwFFeJkeeEkJrVo1p1mQOgMM9Rx13bBDNYuy1sr" +
       "rSwy8e518eP37Gv9bhVpGSYtqj6E6iigBAchw+BQlk0xy+5Np1l6mLTpsNhD" +
       "zFKppk65K91uqyM65Q4sv+cWHHRMZgmZvq9gHcE2y1G4YeXNy4iAcn9VZzQ6" +
       "ArZ2+LZKC7fgOBjYoIJiVoZC3Lkss8ZUPc3J0jBH3sbuG4EAWGuzjI8aeVGz" +
       "dAoDpF2GiEb1kfgQhJ4+AqTVBgSgxUln2UnR1yZVxugIS2JEhugG5CugqheO" +
       "QBZO5oXJxEywSp2hVQqsz7s7Nh47qG/VoyQCOqeZoqH+s4GpK8Q0yDLMYrAP" +
       "JGPj2sQJ2vHE0SghQDwvRCxpvnfLpevWd51/VtIsKkGzM3WAKTypnEo1v7i4" +
       "b801VahGnWnYKi5+geVilw24b3pyJiBMR35GfBnzXp4ffPqmW8+wd6KkoZ/U" +
       "KIbmZCGO2hQja6oas25gOrMoZ+l+Us/0dJ94309qoZ9QdSZHd2YyNuP9ZJYm" +
       "hmoM8RtclIEp0EUN0Ff1jOH1TcpHRT9nEkJq4SHr4Kkj8iO+OflCfNTIsjhV" +
       "qK7qRnzAMtB+Ow6IkwLfjsZtR89oxkTctpS4YY3kfyuGxeIKhJRF47tGVR0w" +
       "yo5haJmfxKQ5tGTORCQCTl4c3uIa7I6thpZmVlI57mzafOmR5PMyfDDkXR9w" +
       "sgwkxVxJMZQUk5JiniQSiQgBc1GiXEHw/xjsZIDSxjVDX9q2/+iKKggdc2IW" +
       "OA9JVxSklD5/u3sYnVTOtTdNLX/ziqeiZFaCtFOFO1TDDNFrjQD2KGPu9mxM" +
       "QbLxMX9ZAPMxWVmGwtIAOeWw352lzhhnFo5zMjcwg5eRcO/Fy+eDkvqT8/dO" +
       "3LbnK5dHSbQQ5lFkNSAUsg8gOOdBuDu8vUvN23Lk4gfnThwy/I1ekDe8dFfE" +
       "iTasCIdA2D1JZe0y+njyiUPdwu31AMScwsYBjOsKyyjAkR4Pk9GWOjA4Y1hZ" +
       "quErz8cNfNQyJvwREZttoj8XwmI2bqw58LS5O01849sOE9v5MpYxzkJWCMz/" +
       "3JB5/6u/+POnhbu99NASyOtDjPcEIAknaxfg0+aH7S6LMaB7496Bu+5+98he" +
       "EbNAsbKUwG5s+wCKYAnBzV999ubX3nrz1IWoH+cccrKTgtImlzcSx0lDBSNB" +
       "2mpfH4A0DRAAo6Z7tw7xqWZUmtIYbqx/t6y64vG/HmuVcaDBiBdG66efwB9f" +
       "uInc+vy+D7vENBEFU6rvM59M4vQcf+Zey6KTqEfutpeWfPsZej8gPqCsrU4x" +
       "AZxE+ICIRdsg7L9ctFeF3l2NzSo7GPyF+ytQ+iSVOy6837Tn/ScvCW0La6fg" +
       "Wm+nZo8ML2xW52D6+WFw2krtUaC76vyOL7Zq5z+CGYdhRgUKBnunBZiYK4gM" +
       "l7q69rc/eapj/4tVJLqFNGgGTW+hYpOReohuZo8CnObMz18nF3cCk0WrMJUU" +
       "GV80gA5eWnrpNmdNLpw99f35j2184OSbIspMOcciwV+PCF+AqqIC9zf2mV9f" +
       "/fID3zoxIXP4mvJoFuJb8K+dWurw7/9Z5HKBYyXqixD/cPzsfZ19174j+H1A" +
       "Qe7uXHFWAlD2ea88k/1HdEXNz6Kkdpi0Km7Fu4dqDm7TYajybK8Mhqq44H1h" +
       "xSbLk548YC4Og1lAbBjK/GwIfaTGflMIvRpxCRfiOrgbuz6MXhEiOv2C5VOi" +
       "XYvNZR5Y1JqWCqciFkKL2RUm5SRKncJ0iilryEnZkPrULCDduFvmXTmwXzna" +
       "PfC2XP6FJRgk3bwH49/Y88qBFwSO1mFy3eWZHEidkIQDIN4qNf4YPhF4/osP" +
       "aooDslxq73NrtmX5og3Dt2IchgyIH2p/a+y+iw9LA8JBFyJmR49//ePYseMS" +
       "HGXlv7Ko+A7yyOpfmoPNEGq3vJIUwbHlT+cO/fDBQ0ekVu2FdexmOKY9/Jv/" +
       "vBC793fPlSisIMoMyvM4EMlXR3MLV0eadP3XWn50R3vVFkjM/aTO0dWbHdaf" +
       "LgzPWttJBZbLP1P4Iesah0vDSWQtrIJMq9h+FpttMv56yoJY38yDXsHmRozW" +
       "cewNhkSmZyiyy02iXjItJXJU7jNsEsUbqhw3pGxqmwAVpdRUPwE1xbHjACdV" +
       "GaOka8wZylzmGugZWkomr+iactycNGUMxbGvVyVMltLWmaG2S7yO911C24MV" +
       "tS3HzSE7w9FkkKZVxy6l6i0zVLUTniZXWFMZVQ9XVLUcNyf1qOqQmobSA0cG" +
       "XPzBr92B/k0QJqpeBBj4MxnexbfP0Lyl8DS7CjaXMe9YRfPKcXPSKFbCLRtK" +
       "rcU3Z6jsanhaXHEtZZS9u6Ky5bg5mRNUFsOH6iXj50QFnXO+7HV52eJTQ0I3" +
       "CQHZgWIuIvoLOFlUdPbuE2dvPHZjglpS7kJIJKdTh4+fTO88fUXUrbWHIdS4" +
       "YV6msXGmBcRV4UwFteN2cQXmF2JvNN/5hx90j2yayWEcx7qmOW7j76WQONeW" +
       "LwPCqjxz+C+du64d3T+Dc/XSkJfCUz60/exzN6xW7oyK+z5ZIRbdExYy9RQm" +
       "3gaLccfSC1Ptyvza47FWJMpOd+07w1HrR1cobPInxnKsobNVVKxo1AugrqIA" +
       "Eq5hnFl4nvDIOoJkQ/K7d6BfqPVIhdPbY9g8BFnTMdNQ1E0HX7Upw9CYu6OK" +
       "IMzfXGemA4TKBykc6DXF+OniYmW168jV06xBCdgox1rBQz+t8O5pbH5c6L2Q" +
       "x2aNG2rad8z5T8AxAgPnwbPetW79zIOzHGvI+FqhSG0eT0VzRDTThU5N2nBS" +
       "Giuf/F4WjeheqODz17H5Jcw3wvggnfQ2wNyifeK9FH7/1f/D7zlO6rw7Uzzs" +
       "Lyj6z0X+T6A8crKlbv7J3a8ItM3f5TcCbmYcTQseRwP9GtNiGVXY2CgPp7K0" +
       "/yMn88vc4IIXZEdo/Lakv8hJa5ge4hC/gmTvcDI7QMbx7CF6QaK/QcUCRNh9" +
       "z/Rc3SruOPBYHpPH8lwkkItIAAbmTef1PEvwjg4ziPjTy0N7R/7tlVTOndy2" +
       "4+Clz5yWd4SKRqemcJbZcHCS15X5jLG87GzeXDVb13zU/Gj9Ki+3tkmF/a2y" +
       "KBB0vRCpJi55Z+gCze7O36O9dmrjkz8/WvMSHBT3kgiszZy9xRcYOdOBVL03" +
       "UXxAhOwqbvZ61nxn8tr1mfdeF1dERB4oF5enTyrDd73a/+jYh9eJf1mqoWxg" +
       "OXGzcv2kPsiUcavgtNmM0Ujx7y/hB9d9TflRvFHmZEXxUbv4Hr4BgoVZmwxH" +
       "T4ucCdncH/EqhYIk65hmiMEfCVxH7JPIgd6H+EsmtpumdxORMsVeTJaFkUhU" +
       "dLFX9T/lcQEb/x4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "L3+63C3/H/Nw5nXUKQAA");
}
