package org.sunflow.core.shader;
public class ViewIrradianceShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        return new org.sunflow.image.Color(
          ).
          set(
            state.
              getIrradiance(
                org.sunflow.image.Color.
                  WHITE)).
          mul(
            1.0F /
              (float)
                java.lang.Math.
                  PI);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public ViewIrradianceShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYa2wc1RW+u36/H4mdB4nzciI5hF1SkrbIaZrE2GTDOlnF" +
       "IaJOm83d2bveiWdnJjN37bVTt0Cp4iI1isCB9IH7J6i0AhLRorZqQamQCgha" +
       "CYQKtCJUaqWmj6hEleBH2tJz7p3ZmZ1dO0pVVpo7s3fOPa97znfOnaevkhrb" +
       "Ij1M5xE+ZTI7MqjzBLVslh7QqG0fgrmk8ngV/efRK/vvDJPaUdKapfawQm02" +
       "pDItbY+S1apuc6orzN7PWBpXJCxmM2uCctXQR0mXasdypqYqKh820gwJDlMr" +
       "Tjoo55aaynMWcxhwsjoOmkSFJtHdwdf9cdKsGOaUR77cRz7ge4OUOU+WzUl7" +
       "/DidoNE8V7VoXLV5f8Eit5qGNjWmGTzCCjxyXNvuuGBffHuZC9ZfbPvw+pls" +
       "u3DBEqrrBhfm2QeZbWgTLB0nbd7soMZy9gnyFVIVJ00+Yk56467QKAiNglDX" +
       "Wo8KtG9hej43YAhzuMup1lRQIU7WlTIxqUVzDpuE0Bk41HPHdrEYrF1btFZa" +
       "WWbi2Vujc48fbX+uirSNkjZVH0F1FFCCg5BRcCjLpZhl706nWXqUdOiw2SPM" +
       "UqmmTjs73WmrYzrledh+1y04mTeZJWR6voJ9BNusvMINq2heRgSU868mo9Ex" +
       "sLXbs1VaOITzYGCjCopZGQpx5yypHlf1NCdrgiuKNvbeAwSwtC7HeNYoiqrW" +
       "KUyQThkiGtXHoiMQevoYkNYYEIAWJysXZIq+NqkyTsdYEiMyQJeQr4CqQTgC" +
       "l3DSFSQTnGCXVgZ2ybc/V/fvOH1S36uHSQh0TjNFQ/2bYFFPYNFBlmEWgzyQ" +
       "C5s3xx+j3S/MhgkB4q4AsaT5yZev7drSc+kVSXNLBZoDqeNM4UnlfKr1jVUD" +
       "fXdWoRr1pmGruPkllossSzhv+gsmIEx3kSO+jLgvLx381Rfu/yH7W5g0xkit" +
       "Ymj5HMRRh2LkTFVj1t1MZxblLB0jDUxPD4j3MVIHz3FVZ3L2QCZjMx4j1ZqY" +
       "qjXEf3BRBligixrhWdUzhvtsUp4VzwWTEFIHF7kDrgYif+LOyX3RrJFjUVON" +
       "JiwDTbejADYpcGs2auf1jGZMRm1LiRrWWPG/YlgsamdpmlnRwyqbjFkWTauI" +
       "SCNiMoIRZn6CvAto15LJUAhcviqY8Brkyl5DA9qkMpffM3jt2eRrMpgwARyP" +
       "cLIFpEYcqRGUGpFSI5WkklBICFuK0uXews6MQ44DyDb3jXxp37HZ9VUQVOZk" +
       "NbgVSdeXFJsBDwhc9E4qFzpbptdd3vpSmFTHSSdVeJ5qWDt2W2OASsq4k7jN" +
       "KShDXjVY66sGWMYsQ2FpAKOFqoLDpd6YYBbOc7LUx8GtVZiV0YUrRUX9yaVz" +
       "kw8c/urtYRIuLQAosgawC5cnELaL8NwbTPxKfNtOXfnwwmMzhgcBJRXFLYRl" +
       "K9GG9cFwCLonqWxeS59PvjDTK9zeABDNKaQUoF9PUEYJwvS7aI221IPBGcPK" +
       "UQ1fuT5u5FnLmPRmRJx24NAlQxZDKKCgAPrPjZhPvPObv9whPOnWhDZfMR9h" +
       "vN+HQ8isUyBOhxeRhyzGgO69c4lHz149dUSEI1BsqCSwF8cBwB/YHfDg1185" +
       "8e77l8+/FfZCmEMhzqegnykIW5Z+DL8QXP/BC7EDJySGdA44QLa2iGQmSt7k" +
       "6QaYpgEAYHD03qtDGKoZlaY0hvnzr7aNW5//++l2ud0azLjRsuXGDLz5FXvI" +
       "/a8d/ahHsAkpWFM9/3lkEqiXeJx3Q65PoR6FB95c/a2X6RMA+QCztjrNBHIS" +
       "4Q8iNnC78MXtYtwWePcZHDba/hgvTSNf75NUzrz1QcvhD168JrQtbZ78+z5M" +
       "zX4ZRXIXQJiQuy2I5Pi228RxWQF0WBYEqr3UzgKzbZf2f7Fdu3QdxI6CWAXa" +
       "CvuABQhXKAklh7qm7ne/fKn72BtVJDxEGjWDpoeoSDjSAJHO7CzAbMH8/C6p" +
       "x2Q9DO3CH6TMQ2UTuAtrKu/vYM7kYkemf7rsxzu+P39ZhKUpedziZ7hJjH04" +
       "bJFhi4+3FYrOEr/aRZzl4xkSz8s5WVZWGmQVQMeuXqhzEV3X+Qfn5tMHntwq" +
       "+4vO0m5gEJrdZ37779cj5/7waoWC1MAN8zaNTTDNp1MViiypJMOiqfPQ7L3W" +
       "R/74s96xPTdTRHCu5wZlAv+vASM2L1wUgqq8/OBfVx7amT12E/VgTcCdQZY/" +
       "GH761bs3KY+ERQcrS0FZ51u6qN/vWBBqMWjVdTQTZ1pENm0oBsgSjIcVcDU6" +
       "AdIYzCYJ3CLacBgsLq12yRdaGgCLsNjRsBtlPWVRJlzDoBHH2HfJuv1kI/K+" +
       "OxETat23CBwdxWEEUDxvpgGRSzsSDJCRfMqG7kHNQUWZcHroTyWOKbO9iT/J" +
       "+F1RYYGk63oq+s3Dbx9/Xex0PYZW0b++sIIQ9NXBdhwimEN9i5xIS/WJznS+" +
       "P/7dK89IfYIHgAAxm517+OPI6TmZW/KUtKHsoOJfI09KAe3WLSZFrBj684WZ" +
       "nz81cyrsuPoeTupShqExqhe3IlRsBJeWelHqetc32n5xprNqCLI2Rurzunoi" +
       "z2Lp0sits/Mpn1u9g5UXx47WWIo5CW12MfKzOBySzzv+R3jGiT2mmD9QDPkO" +
       "fLcKrlYn5FtvPlsWWhqI5VApJq+uiMlwesXzOxNiJxfJhpM4QIvXNMb4Qae1" +
       "rwj3ag6OsViNnBO7cKX9CbiyCd/tdBHIvd+cKxdaWhl48K9gOiPG2UXc9TAO" +
       "X+OkxVYoB0BKZA3u4LjiJArexjipnjDUtOeph/4fnirAEaXSKQxbhuVl33fk" +
       "Nwnl2fm2+mXz974t6mDxu0EzwFMmr2m+tPKnWK1psYwqTG6WbZYpbmcrNQHy" +
       "fAiIKh+E9nOS/hwn7UF68A3e/GTfgQD0kXFMcfHkJ5rnpAqI8PF7phuj7aJT" +
       "wo82EfmFohAq74bEDnTdaAeKS/xHAwRi8YHNRaq8/MQGh9T5fftPXvv0k/Jo" +
       "omh0ehq5NAE+yQNQsZavW5Cby6t2b9/11osNG13gLDka+XUTcQDZL44RKwO9" +
       "ut1bbNnfPb/jxV/P1r4JkH+EhCgnS474Pm9JT0HDn4cm6ki8HIeh7xGHiP6+" +
       "b0/t3JL5x+9Fo+ng9qqF6ZPK6KPvxC6Of7RLfNGpgZrACqOkUbXvmtIPMmXC" +
       "KgH1VoxGip/ahB8c97UUZ/GMysn68lJVfrKHJnySWXuMvJ52ykKTN1Pypc9t" +
       "f/KmGVjgzfiq87hMa/Q+xF8yPmyazgEvVGuKvNSC0CwmxeLnxCMOP/ov5Qcr" +
       "6WsXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7ht5+ff/AMB166k4IgAA");
}
