package org.sunflow.core.shader;
public class NormalShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        org.sunflow.math.Vector3 n =
          state.
          getNormal(
            );
        if (n ==
              null)
            return org.sunflow.image.Color.
                     BLACK;
        float r =
          (n.
             x +
             1) *
          0.5F;
        float g =
          (n.
             y +
             1) *
          0.5F;
        float b =
          (n.
             z +
             1) *
          0.5F;
        return new org.sunflow.image.Color(
          r,
          g,
          b);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public NormalShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6acwrV3Xzvpe8Lct7SSAJaXYelDD0G9vjZawHNDPj3TPj" +
       "8dge21PKY5Y7iz2bZ7HHpmkhVZuoqBRB2CTIjxbagsKiqqiVKtpUVQsIVIkK" +
       "dZMKqKpUWopEfpRWTVt6Z/ztb0ER1JKv79w559xzzj3n3HPP9QvfQ24NAwT1" +
       "PXtt2F60C5Jod2aXdqO1D8LdDlPi5SAEGm3LYTiEY1fVxz9/8Qcvv8+8tIOc" +
       "kZB7ZNf1IjmyPDcUQOjZS6AxyMXD0boNnDBCLjEzeSljcWTZGGOF0RUGue0I" +
       "aoRcZvZZwCALGGQBy1jAyEMoiHQHcGOHTjFkNwoXyC8ipxjkjK+m7EXIY8eJ" +
       "+HIgO3tk+EwCSOFc+ixCoTLkJEAePZB9K/M1An8QxZ778Nsv/d5p5KKEXLTc" +
       "QcqOCpmI4CQScrsDHAUEIalpQJOQu1wAtAEILNm2NhnfEnJ3aBmuHMUBOFBS" +
       "Ohj7IMjmPNTc7WoqWxCrkRcciKdbwNb2n27VbdmAst57KOtWwkY6DgW8YEHG" +
       "Al1WwT7KLXPL1SLkkZMYBzJe7kIAiHrWAZHpHUx1iyvDAeTu7drZsmtggyiw" +
       "XAOC3urFcJYIeeCGRFNd+7I6lw1wNULuPwnHb19BqPOZIlKUCHn1SbCMElyl" +
       "B06s0pH1+R735ve+0225OxnPGlDtlP9zEOnhE0gC0EEAXBVsEW9/I/Mh+d4v" +
       "PruDIBD41SeAtzB/8AsvPfmmh1/88hbmp64D01NmQI2uqp9Q7vz6g/QT1dMp" +
       "G+d8L7TSxT8meWb+/N6bK4kPPe/eA4rpy939ly8KfzF916fBd3eQC23kjOrZ" +
       "sQPt6C7Vc3zLBkETuCCQI6C1kfPA1ejsfRs5C/uM5YLtaE/XQxC1kVvsbOiM" +
       "lz1DFemQRKqis7Bvubq33/flyMz6iY8gyFn4RVD4vYBsP9lvhFzFTM8BmKzK" +
       "ruV6GB94qfzpgrqajEUghH0NvvU9LIxd3fZWWBiomBcYB8+qFwAsNGUNBBjn" +
       "BY5sD7KH3dTQ/P//KZJUykurU6fgAjx40v1t6Dktz4awV9XnYqr+0mevfnXn" +
       "wB329AMDFpxtd2+23XS23e1su0dnQ06dyiZ5VTrrdoXh+syhp8MYePsTg5/v" +
       "vOPZx09D0/JXt0DlpqDYjUMxfRgb2lkEVKGBIi9+ZPVu8ZdyO8jO8ZiacgqH" +
       "LqTofBoJDyLe5ZO+dD26F5/5zg8+96GnvEOvOhak95z9WszUWR8/qdPAU4EG" +
       "w98h+Tc+Kn/h6hefuryD3AIjAIx6kQytFAaUh0/Occxpr+wHwFSWW6HAeqbt" +
       "9NV+1LoQmYG3OhzJFvvOrH8X1PGbkL3mmFmnb+/x0/ZVW+NIF+2EFFmAfcvA" +
       "//jf/uW/4Jm692PxxSO72wBEV474f0rsYubpdx3awDAAAML9w0f4D3zwe8/8" +
       "XGYAEOK115vwctrS0O/hEkI1/8qXF3/3rW9+4hs7h0YTwQ0wVmxLTbZC/hB+" +
       "TsHv/6bfVLh0YOu7d9N7AeTRgwjipzO//pA3GEts6GypBV0euY6nWbolKzZI" +
       "Lfa/L74u/4V/e++lrU3YcGTfpN70owkcjr+GQt711bf/x8MZmVNqupcd6u8Q" +
       "bBsg7zmkTAaBvE75SN79Vw999Evyx2GoheEttDYgi1hIpg8kW8Bcpgs0a7ET" +
       "7wpp80h41BGO+9qRnOOq+r5vfP8O8ft//FLG7fGk5ei6s7J/ZWtqafNoAsnf" +
       "d9LrW3JoQrjii9zbLtkvvgwpSpCiCnfqsBfAcJEcs5I96FvP/v2f/tm97/j6" +
       "aWSngVywPVlryJnDIeehpYPQhLEq8X/2ya01r87B5lImKnKN8FsDuT97Og0Z" +
       "fOLGsaaR5hyH7nr/f/Vs5el//M9rlJBFmetstSfwJeyFjz1Av/W7Gf6hu6fY" +
       "DyfXBmGYnx3iFj7t/PvO42f+fAc5KyGX1L3kT5TtOHUiCSY84X5GCBPEY++P" +
       "Jy/bnfrKQTh78GSoOTLtyUBzGPxhP4VO+xcOF/yJ5BR0xFsLu5XdXPr8ZIb4" +
       "WNZeTpuf3mo97b4BemyYJZEQQ7dc2c7oPBFBi7HVy/s+KsKkEqr48syuZGRe" +
       "DdPozDpSYXa3mdg2VqUtvuUi65dvaA1X9nmFq3/nITHGg0nde/7pfV/7jdd+" +
       "Cy5RB7l1maoPrsyRGbk4zXN/9YUPPnTbc99+TxaAYPThX978yRtSqt2bSZw2" +
       "tbSp74v6QCrqwIsDFTByGLFZnABaJu1NLZMPLAeG1uVeEoc9dfe35h/7zme2" +
       "CdpJMzwBDJ597td+uPve53aOpMWvvSYzPYqzTY0zpu/Y03CAPHazWTKMxj9/" +
       "7qk/+t2nntlydffxJK8OzzCf+ev/+druR779letkFrfY3o+xsNHtL7SKYZvc" +
       "/zDiFBRWqpA4eq9C6Gt9LvSKhDOM2+XGxM1FlhiNJvW2qq2LS5cq1GYxZza4" +
       "taPFGlEorKPKUnKVCc8sJF+UFqTQhqnZYipWRdTvdk2fXrRpWvQaba0xZkZG" +
       "1JBHxtin+3QbbVOLvlWXKYKt9JaFSrSxBNLFtQ3Y1HQdxZYchy3ZhiYY47LF" +
       "l2tCp5RLrA6me1ybjZz1rNYMlAgb0hNbQIMVTlS0lktsZubCrTMMXTXAvNLg" +
       "BHtgdfXpaLzQF1w4Lg97SdI3B4V2gRWcvLFxuosm74llsRaJXE0UxdiZegLV" +
       "VElKkbVBp6tMRm6d66wdkcwpXk6mO8lQHphlvmM0gwljzuaTeZfozvtoSzRN" +
       "m5Uoe1QdCLzXccOe0BclfrCY51qDRJFlM5BxRnBydN/Pgb5QmSgTarIcRnlQ" +
       "9Hi0lPDLydBUyzEZl0O5qNidyB0mNSXXlNvzudyZtmRe8IICqwslsaM1lUHD" +
       "sgxl4Npkx6x7Rp5hCx7JRHbS0rr9ooJTm4U69nKSPO0LwpJxpNl0NR9PhlMl" +
       "qFFreTEOK/hqM1aWdNQQpbHDzzwxdtlpUS0v7UKrbrOeBxbDIZWT7C5pSKSn" +
       "DjyvNI3smjXvjrrawO9XSNeSRWso5fF2NW8vqmzZN8p1HGcZBxfYqduUDJkw" +
       "Zg6tlNTZKGxtNsRsbeItggP9PG+UC1VDxumVWS/UVnJhsaCntgr6Gloeo4ve" +
       "IrDpHB8EtQhvGaMcSY5LcdekpuwkP6jOnDqtTeejnEKizChPl2N32Od8o092" +
       "5Ea34K+lYakAD4GjYcKF1mrWxvtS2BdGjLYSFDJq8GJ9vTGgZ9LTgS9SROBt" +
       "lr3WWOcXQWvUT3KiZ4WsjivTBqdLHFtfCz2mTxXaM5BXco6WVFahW1wZlDpC" +
       "62OOIqo4N9EKeBBjg7XHOCYdFlCcqlu5ckLwgU5UlUnNQdFwWvByTlGOwpie" +
       "jNVywPR6ca0jsf2OCdw1pwxbC8ZeSyjWcWf4WsCsBT9uNBejmprz+2Ypv54r" +
       "glgTLXyUz02dRtemhEVb8dYbThsuSAfkyn4v6a1RnSs6XHuy4IYVUeZrWLHb" +
       "JsImGcue6IoqoeBBryNP65idW9dHFEfkRKUYWUxSVIiRJI/p0aA/sINmXPbk" +
       "UdhPHH4Vw2ya7tTNGDREI19T7UKVSZxNfVHojOImB3DMXhWYQWtKdYnBIDEK" +
       "gcWIHczSO/UQJ7Bi6LGDuCIV2IRma7LM28Go5sxMQ86NdYcN8SWfH4NNUAxG" +
       "03hioIZK0uW+PRnbnY6V8316UsvZZJh443Da6DRMuo4K5daAHAcKl6uiWoyZ" +
       "cyyfnzcCR6nlinapVbCTXGm1qquAggmHjparFV0REhXFArZoGZxV6tXatERh" +
       "/dWsVJAadnPYEcgWjCF9EtDzRZ5V0EUtng1ibd6qRQlGV1Wz1huz037PqHMx" +
       "mPZroZVYbdsl80tvPrSrKAZaCkW3F6VKc7OaBYOuC4lDWzZn1EK3FS1csVV3" +
       "kjemVpcrk1SRHBcXZo+stdBFe70OKCvHcpo0DzfNzsbtjyWmZVuFnNexN+R0" +
       "w7NquaCRs5xXsPsjgapFju7UBjrGijxWoTVQ7dSquaE37hTnWo2ud9uJ1CBA" +
       "b2PRQdWO6yRXWG4KIwD0YdeasoQ/rVmJ49FU1SjW6gad69d5PW7Z0wKKoUSl" +
       "xKEc1bTbxZGfUzXomkoYd2soOTRQFCtIwCQ7YV/myHylzgwoEx0OoZv7cxLv" +
       "0yq39lU7IchqzxroDkxCh1YvpJZlqdAaBgROoPlBiw7UJmuvcYX3E4plqmVu" +
       "E6DlRROr4vUCKznazGth5KxNxVqOKq1bzMrl2Fm1XVPKSQWjJ0SnTeJkV442" +
       "Zq9nTGcVEquTeChV23ojAYVhVJtN2UKvrjJrdDaiwNAeQbm08ppE0SroiMG4" +
       "WmyagEXNME/NRyOLtqiwiXdb7DxxFpWc08yDcb8NxJFCSslkSjlcviDrG1CL" +
       "8QEnkBVq3LFlqhbqgmyI3Xloi5uFuZB0bEm1llNND3J8UtcGi6ZoSCtlY4zI" +
       "aN4L6gzZqdtEqVcxqfJmAwOs2kIN2iASv4wuW2GxKkj8mmQTTEFFXHOTKiEU" +
       "gDlgIsWlcWKDKihvCJyzEgeqB6KSSOQxii8m3ZjWmywBNBHGv5BsNakCsebK" +
       "BT/fYhKlt8QMZyTaeL6HW0HZWGCrEb7iuLI31jE0zpcYV182GLvctEzTdTaC" +
       "I7cbUdefefNwhRUT3Fs1CtykTNC4JotBVyTaaLHamZBVC8+TSgFu9ZPWcjNz" +
       "lrkKXQRLsspPhNJqJOkO3Ho1EOuhg8pRgs+Jbq+LeX0ixGtTRaNG7Yj0CptN" +
       "mFgsERUFfViZgipktcjhmyleaeKCZdaMNd5r11QezbveclDwo5kgEC6r+pVY" +
       "7E1yk1jl1L7cjqS+G82X4+Z6oNcrdt1Oon4xJAcuHsatocEOeos+vbBdtVlh" +
       "isUyEMIeh4ltf9VlC6UWWm2xU92d93sS3raiiVidG+XWAthBiSh2c7MAa7S5" +
       "CjciljllsGBNeePnbHe8Ko6lcVOKJzGFjstrNtKYfKXajCfMyqx6cb5odiyV" +
       "53t2rdR1N57VrU8A5DCOa6BeLUbFQW5cmY1spjjzW/okvyliEct00G4MI9CI" +
       "AyO2v+am1RwrEEm8bgARNJgAVNVJvZYr4flpnmyVGvRmWo5bLtceWC6P04qy" +
       "nk7Upp1sjFlSiMZKqzsaJ4wsMzpVna2KQhGu1bLdkbhKjxlO8TKtVbp2pFNc" +
       "DPeQmK/IC7ipzgMngV6siYk4KQKlXQnLdassMqVaUa+1A9k3HM1o4URn5OXX" +
       "DZlR2+KcKvqVMSr3WKzqJnjdKPTmtLVSV3nUKY7tODBWQaVcoUw34FAZnqV5" +
       "dt1E17YshfGUjMw5bUh5VlhUBJVCi3Spzxd63gDulcWqvrSTTqMCWpVabdkR" +
       "82OCSRq4zrtSMhpu1qFYweNuNZoQvLIC5HoYyw1rwaqdes4xlc6iul5pUSt0" +
       "+I2rMZPaWFuvSIpvkHm93C0yaH3qlb3l0CD16bAzC5mBMLK8ctJGxd603Gp2" +
       "yx7d5ocluEm7k5UQTqtme94dVwhfNG2bYKo4z5n6UsZNKspRiwlhSuMWNy0V" +
       "JWksMutK3FKwZdnM81Y/poNeqwRU2a7BXHNS54kcbs6G4yIICEXYaGDMV8F6" +
       "Pe2hoRF1xzUV6AvTw8P10poM2apX03tMtaqHgIGiSCgpk9V5fbRKhHxrta4y" +
       "ZhcYgaIYQHGmjDcYyI1hUcaJYm/qllwpXmOYLVY2mFpq4MoYLwfcZj3L85sm" +
       "mp+yXkkeLQxq1CmMfJsO5IjI+zmiD9TpwkAnTbfX8jA3jkqDFc5OYiFRcKvn" +
       "9iSeWMYzYZgXk2LVnmi+3E5cSxkr6kQzl4sEV0erzZJdVBeeZ0liucmzsZPk" +
       "NsM4V4LRY6lxLTeZjGu1uU6QZIGye8X5GJ5O3pIeW972yk6Od2WH5IO7C3hg" +
       "TF80X8GJafvqsbR53UFhMPucuUlh8Ejx5NT+gfy+a6rA28Jvekp86EZXFtkJ" +
       "8RNPP/e81vtkfmevKDWOkPOR5/+MDZbAPlGneeONT8NsdmNzWCz50tP/+sDw" +
       "reY7XkE5+JETfJ4k+Sn2ha80X6++fwc5fVA6ueYu6TjSleMFkwsBiOLAHR4r" +
       "mzx0oPl7UkW/Bn5v29P8bdcvyV7XSk5lVrK1jRM1v50MYGd/rR6+Zq0yPYAI" +
       "BGlRcR/s3qNgg+0vybezGaKbVBU3aeNFyJnY1+RoW3wWjliiGCFnFc+zgewe" +
       "Wqn/o871R2fJBuwDtWVG+yD8XtxT28WfjNpOHTfxh65r4pZrpPegIKPwzE3U" +
       "8p60eTpCbjNAJEC81Dyu6z2WIxsgrR7v3Xxm+vnlH0M/mRW9dc+09k3sJ2dW" +
       "6eOzafPrGdSHb6KDj6bN+yPkjlCVI2huvOlFey55wkJuWXqWdij+B16J+EmE" +
       "3H708imtnt9/zeX29kJW/ezzF8/d9/zob7L7l4NL0/MMck6PbftosfNI/4wf" +
       "AN3KRDq/LX362c9vXS8Qbq/D0lJn1snY/c0t/G9HyKWT8FD29Oco2Keg1RwB" +
       "g/6z1zsK9EKEnIZAafcz/nXqpNuib3LqSEjds5RMw3f/KA0foBy9n0nDcPbv" +
       "gv2QGW//X3BV/dzzHe6dL5U/ub0fUm15k8WFcwxydntVdRB2H7shtX1aZ1pP" +
       "vHzn58+/bn+LuHPL8KHVHuHtketfwNQdP8quTDZ/eN/vv/l3nv9mVrb9P3wq" +
       "ApL2IQAA");
}
