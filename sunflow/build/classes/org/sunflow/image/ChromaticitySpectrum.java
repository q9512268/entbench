package org.sunflow.image;
public final class ChromaticitySpectrum extends org.sunflow.image.SpectralCurve {
    private static final float[] S0Amplitudes = { 0.04F, 6.0F, 29.6F, 55.3F,
    57.3F,
    61.8F,
    61.5F,
    68.8F,
    63.4F,
    65.8F,
    94.8F,
    104.8F,
    105.9F,
    96.8F,
    113.9F,
    125.6F,
    125.5F,
    121.3F,
    121.3F,
    113.5F,
    113.1F,
    110.8F,
    106.5F,
    108.8F,
    105.3F,
    104.4F,
    100.0F,
    96.0F,
    95.1F,
    89.1F,
    90.5F,
    90.3F,
    88.4F,
    84.0F,
    85.1F,
    81.9F,
    82.6F,
    84.9F,
    81.3F,
    71.9F,
    74.3F,
    76.4F,
    63.3F,
    71.7F,
    77.0F,
    65.2F,
    47.7F,
    68.6F,
    65.0F,
    66.0F,
    61.0F,
    53.3F,
    58.9F,
    61.9F };
    private static final float[] S1Amplitudes = { 0.02F, 4.5F, 22.4F, 42.0F,
    40.6F,
    41.6F,
    38.0F,
    42.4F,
    38.5F,
    35.0F,
    43.4F,
    46.3F,
    43.9F,
    37.1F,
    36.7F,
    35.9F,
    32.6F,
    27.9F,
    24.3F,
    20.1F,
    16.2F,
    13.2F,
    8.6F,
    6.1F,
    4.2F,
    1.9F,
    0.0F,
    -1.6F,
    -3.5F,
    -3.5F,
    -5.8F,
    -7.2F,
    -8.6F,
    -9.5F,
    -10.9F,
    -10.7F,
    -12.0F,
    -14.0F,
    -13.6F,
    -12.0F,
    -13.3F,
    -12.9F,
    -10.6F,
    -11.6F,
    -12.2F,
    -10.2F,
    -7.8F,
    -11.2F,
    -10.4F,
    -10.6F,
    -9.7F,
    -8.3F,
    -9.3F,
    -9.8F };
    private static final float[] S2Amplitudes = { 0.0F, 2.0F, 4.0F, 8.5F,
    7.8F,
    6.7F,
    5.3F,
    6.1F,
    3.0F,
    1.2F,
    -1.1F,
    -0.5F,
    -0.7F,
    -1.2F,
    -2.6F,
    -2.9F,
    -2.8F,
    -2.6F,
    -2.6F,
    -1.8F,
    -1.5F,
    -1.3F,
    -1.2F,
    -1.0F,
    -0.5F,
    -0.3F,
    0.0F,
    0.2F,
    0.5F,
    2.1F,
    3.2F,
    4.1F,
    4.7F,
    5.1F,
    6.7F,
    7.3F,
    8.6F,
    9.8F,
    10.2F,
    8.3F,
    9.6F,
    8.5F,
    7.0F,
    7.6F,
    8.0F,
    6.7F,
    5.2F,
    7.4F,
    6.8F,
    7.0F,
    6.4F,
    5.5F,
    6.1F,
    6.5F };
    private static final org.sunflow.image.RegularSpectralCurve kS0Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S0Amplitudes,
      300,
      830);
    private static final org.sunflow.image.RegularSpectralCurve kS1Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S1Amplitudes,
      300,
      830);
    private static final org.sunflow.image.RegularSpectralCurve kS2Spectrum =
      new org.sunflow.image.RegularSpectralCurve(
      S2Amplitudes,
      300,
      830);
    private static final org.sunflow.image.XYZColor S0xyz = kS0Spectrum.toXYZ(
                                                                          );
    private static final org.sunflow.image.XYZColor S1xyz = kS1Spectrum.toXYZ(
                                                                          );
    private static final org.sunflow.image.XYZColor S2xyz = kS2Spectrum.toXYZ(
                                                                          );
    private final float M1;
    private final float M2;
    public ChromaticitySpectrum(float x, float y) { super();
                                                    M1 = (-1.3515F - 1.7703F *
                                                            x +
                                                            5.9114F *
                                                            y) / (0.0241F +
                                                                    0.2562F *
                                                                    x -
                                                                    0.7341F *
                                                                    y);
                                                    M2 = (0.03F - 31.4424F *
                                                            x +
                                                            30.0717F *
                                                            y) / (0.0241F +
                                                                    0.2562F *
                                                                    x -
                                                                    0.7341F *
                                                                    y); }
    public float sample(float lambda) { return kS0Spectrum.sample(lambda) +
                                          M1 *
                                          kS1Spectrum.
                                          sample(
                                            lambda) +
                                          M2 *
                                          kS2Spectrum.
                                          sample(
                                            lambda); }
    public static final org.sunflow.image.XYZColor get(float x, float y) {
        float M1 =
          (-1.3515F -
             1.7703F *
             x +
             5.9114F *
             y) /
          (0.0241F +
             0.2562F *
             x -
             0.7341F *
             y);
        float M2 =
          (0.03F -
             31.4424F *
             x +
             30.0717F *
             y) /
          (0.0241F +
             0.2562F *
             x -
             0.7341F *
             y);
        float X =
          S0xyz.
          getX(
            ) +
          M1 *
          S1xyz.
          getX(
            ) +
          M2 *
          S2xyz.
          getX(
            );
        float Y =
          S0xyz.
          getY(
            ) +
          M1 *
          S1xyz.
          getY(
            ) +
          M2 *
          S2xyz.
          getY(
            );
        float Z =
          S0xyz.
          getZ(
            ) +
          M1 *
          S1xyz.
          getZ(
            ) +
          M2 *
          S2xyz.
          getZ(
            );
        return new org.sunflow.image.XYZColor(
          X,
          Y,
          Z);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZCXAcxRXtXcmSrMM6fAnZ8iXZlA3sWgoEuwTGtpCxyMpW" +
                                                              "ScYBmVgezfauxpqdGWZ6pZWIuVIJzkURMEcSUFUq5ghlbIoKOYoATlHBUBAS" +
                                                              "CAkQCshBEohDBScVSEIS8n/3zM6xO+tYFW/V9M70/P793+9/9O859C6ZZZlk" +
                                                              "CdVYjE0a1Ir1aKxfMi2a7FYly9oBfcPyHWXSX3e/vW19lFQMkTmjktUnSxbd" +
                                                              "olA1aQ2RVkWzmKTJ1NpGaRJH9JvUoua4xBRdGyLzFas3Y6iKrLA+PUmRYKdk" +
                                                              "JkijxJipjGQZ7bUZMNKaAEniXJL4puDrrgSplXVj0iVv9pB3e94gZcady2Kk" +
                                                              "IbFXGpfiWaao8YRisa6cSc4ydHUyreosRnMstlc9z1bBpYnzClSw4qH69z+8" +
                                                              "ebSBq2CupGk64/CsAWrp6jhNJki929uj0ox1FbmGlCVIjYeYkfaEM2kcJo3D" +
                                                              "pA5alwqkr6NaNtOtczjM4VRhyCgQI8v9TAzJlDI2m34uM3CoYjZ2PhjQLsuj" +
                                                              "FSgLIN52VvzAHbsbHi4j9UOkXtEGURwZhGAwyRAolGZGqGltSiZpcog0arDY" +
                                                              "g9RUJFWZsle6yVLSmsSysPyOWrAza1CTz+nqCtYRsJlZmelmHl6KG5T9NCul" +
                                                              "SmnAusDFKhBuwX4AWK2AYGZKAruzh5SPKVqSkaXBEXmM7Z8AAhhamaFsVM9P" +
                                                              "Va5J0EGahImokpaOD4LpaWkgnaWDAZqMtIQyRV0bkjwmpekwWmSArl+8AqrZ" +
                                                              "XBE4hJH5QTLOCVapJbBKnvV5d9sFN12tbdWiJAIyJ6msovw1MGhJYNAATVGT" +
                                                              "gh+IgbVrErdLCx7bHyUEiOcHiAXNdz99YuPZS44+LWgWFaHZPrKXymxYPjgy" +
                                                              "54XF3avXl6EYVYZuKbj4PuTcy/rtN105AyLMgjxHfBlzXh4deOqK6x6gx6Ok" +
                                                              "updUyLqazYAdNcp6xlBUal5CNWpKjCZ7yWyqJbv5+15SCfcJRaOid3sqZVHW" +
                                                              "S8pV3lWh82dQUQpYoIqq4V7RUrpzb0hslN/nDEJIHVykCa5KIn78n5FPxkf1" +
                                                              "DI1LsqQpmh7vN3XEb8Uh4oyAbkfjVlZLqfpE3DLluG6m889KBtY73j1q6hl0" +
                                                              "IIVNDhow0sxmYmhgxuljnUNUcyciEVD44qC7q+ApW3U1Sc1h+UB2c8+Jw8PP" +
                                                              "ClNC87f1wcgqmC9mzxfj88WKzUciET7NPJxXrCmsyBj4NgTX2tWDn7p0z/4V" +
                                                              "ZWBMxkQ5qBNJV/iSTLcbAJyoPSwfaaqbWv5Gx5NRUp4gTZLMspKKOWOTmYZo" +
                                                              "JI/ZDls7AunHzQLLPFkA05epyzQJQSgsG9hcqvRxamI/I/M8HJwchd4YD88Q" +
                                                              "ReUnR++cuH7ntWujJOoP/DjlLIhZOLwfw3U+LLcHHb4Y3/ob337/yO37dNf1" +
                                                              "fZnESYAFIxHDiqAhBNUzLK9ZJj0y/Ni+dq722RCamQSuBFFvSXAOX2TpcqI0" +
                                                              "YqkCwCndzEgqvnJ0XM3AdibcHm6hjfx+HphFDbraUrhW277H//HtAgPbhcKi" +
                                                              "0c4CKHgWuHDQuPuV59/5GFe3kzDqPZl+kLIuT5BCZk08HDW6ZrvDpBToXr+z" +
                                                              "/9bb3r1xF7dZoGgrNmE7tt0QnGAJQc2fffqqV9984+BLUdfOGWTp7AhsdnJ5" +
                                                              "kNhPqkuAhNlWufJAkFPBx9Bq2i/TwD6VlCKNqBQd61/1Kzse+dNNDcIOVOhx" +
                                                              "zOjskzNw+8/YTK57dvcHSzibiIxJ1tWZSyYi91yX8ybTlCZRjtz1L7Z+9Zh0" +
                                                              "N+QAiLuWMkV5KI1yHUT9vo7+NJgdscAvlQwsw7idlTr798j72/vfEhnnjCID" +
                                                              "BN38++Nf3vny3uf4Ileh52M/4q7z+DVECI+FNQjlfwS/CFz/wQuVjh0iujd1" +
                                                              "2ylmWT7HGEYOJF9dYlPoBxDf1/Tm2F1vPygABHNwgJjuP/CFj2I3HRArJzYq" +
                                                              "bQV7Be8YsVkRcLBZj9ItLzULH7HlD0f2PXr/vhuFVE3+tNsDu8oHf/Hv52J3" +
                                                              "/uqZIrEfXEiXxHbzXDTmfOie518dAeniz9f/4Oamsi0QNXpJVVZTrsrS3qSX" +
                                                              "J+y0rOyIZ7ncLRDv8ILDpWEksgZWATvW8fY8LsvavESES0T4u63YrLS8EdS/" +
                                                              "Yp4d9bB880vv1e187/ETHLV/S+4NGH2SIVTeiM0qVPnCYIbbKlmjQHfu0W1X" +
                                                              "NqhHPwSOQ8BRhn2otd2E9JrzhRebelblL3/45II9L5SR6BZSDWpObpF4pCaz" +
                                                              "IURSaxQyc864aKOIEBNV0DRwqKQAfEEHeunS4v7fkzEY99ip7y389gX3Tb/B" +
                                                              "Q5UheCzi42tws+BLzbywc7PDAz87/+f3feX2CWFRJfwjMK75n9vVkRt+8/cC" +
                                                              "lfNkWMRlAuOH4ofuaunecJyPd7MSjm7PFW5wILO7YzsfyPwtuqLiR1FSOUQa" +
                                                              "ZLuQ2impWYz1Q1A8WE51BcWW772/EBC73q581l0c9FnPtMF86HWEcuYzejcF" +
                                                              "noFLuAGuOXZ2qAqmwAjhN0N8yJm8XYPNOXz5yhipNEwFim2QvMLiNRt6sqJJ" +
                                                              "aiAHNTvci8zCSO3g2k1YprNsEizZdyaQj8g8AQjvv7LmqSesb/7+YWEVxeJ9" +
                                                              "oAq5/74q+bXMUzze45Tn54XjyOfC1WIL1yJi9OUz3SbLuknjhhMa4zugSNXS" +
                                                              "Ku0DN3O24KeNN4aMleE+4tHg9L1tz1873fZrHkCqFAssCbJYkRrQM+a9Q28e" +
                                                              "f7Gu9TDfqZVjMrQjq794LqyNfSUv1389NikRbAtCPj7vEAS2+WWKm18Ub2PY" +
                                                              "7OGs1oMRqlRLs1FO2WVnLvy7iJEykAtvxww3ijmbBnxuZvZ2A30Pal9do7hz" +
                                                              "cd6JYkPRY/lzB3iZK5KvWn3xrI9Dd4PD63Nu+e3329ObT6XKwL4lJ6kj8Hkp" +
                                                              "rN+a8OUPinLshj+27NgwuucUCoalAesIsvxW36FnLlkl3xLlRxsiahUcifgH" +
                                                              "dfljVbVJWdbU/Gm6zTWXMWEK2JzF17dElr6+xLvPYHMNBCsZF1rYRQnyzxUm" +
                                                              "PuwYMDw50jYBfOyxawdse7HZJSwlEZpkd/iD8nq4FtgRqSEkKH8xJCjj7W5s" +
                                                              "hoVrFAbihhDOGIg73ECMfTQA5EunCORCuFrt6ZpDgNw6YyDNIZwRSGdpIAdO" +
                                                              "EUiGiGqROP9FgHx9xkDCODNSMza41jn4cGJRkXOSAZrOqpIpKCW1O2uOBxHf" +
                                                              "NQPEy2y5loUgvmfGiMM4c8QdDmLs+kYAx70zwLHcnm15CI4HZ4wjjDPH0VkK" +
                                                              "x+FTxIEbtTZ7trYQHI/MGEcYZwiRg2tzk1OO7bUU2t7lVwzBvl83A/i+MwN8" +
                                                              "7bYU7SH4npgxvjDOiK8D8OHDowEER2eAYKU9z8oQBMdmjCCMMyLoDEHw9P+O" +
                                                              "AI+hefw5057nzBAEPymxG9tdTPjGEkwZifZ14N26gOQ/PQ2Sv4zNCzhlZ7Ep" +
                                                              "XykxZe7kW9C8PPxXSwKn+h55PBUwwT17a9iHF36qcvCGA9PJ7fd0OMXLRgZ1" +
                                                              "u26co9JxqnpYiW3sVF4MVDtZCFfMFiMWVIuLX2yoCo8Nw4YGtkqerY84PHmn" +
                                                              "xF7qODZvYcEoQYbmWWqduwi/O9m6lz6OwI4BI6AJHpvR8TttOJ0lNFHUM2Oh" +
                                                              "nrmwBNuAEqKuyaxzVfVBCVX9A5sTULukKa9dHnX19Jf/h55yUNcU+8KCpzrN" +
                                                              "Bd9sxXdG+fB0fdXC6cteFnWg8y2wFoqRVFZVvecOnvsKw6QphYOqFacQ/Kwt" +
                                                              "EmGksSCjQETj/yg2uC4nLIeE6iFkeLzH77xElaAqIMLbKsPJWEsLM5Zvm5SL" +
                                                              "+P0xr+L5J1Oxx4XbfHUX/yru1EhZ8V18WD4yfem2q098/B7xyUBWpSkes2ug" +
                                                              "QhZfL/J11vJQbg6viq2rP5zz0OyVTlBoFAK7drzIY0YD4JsGrmlL4Dzdas8f" +
                                                              "q7968ILHf7y/4sUoiewiEQmK4V2FR1E5IwvRalei8EgWalJ+0N+1+muTG85O" +
                                                              "/fk1fthHREm8OJx+WB669ZXeh8Y+2Mg/w86CeEdz/Izs4kltgMrjpu98dw6a" +
                                                              "m4Tfx7kebPXV5XvxAxMjKwoPtws/y1WDOVBzs57VksimDmpgt8epr32ladYw" +
                                                              "AgPcHnvpsL0Ym/U51D6Y43CizzCcs/9jBne8ntCaMbKI3+Ld4v8CaH4PICAj" +
                                                              "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6Cczj2H2f5pudndlzZtf27mbrvbyzdtZKh6JEiSTWdkJR" +
       "lCiKIiVRIkW2zZriIZLiJR7i4W4TG2hsxIDrpuvEAeIFUjhtEmxso2iaAIWL" +
       "bYvmQIIAMYI2LdA4CYrWrevCW7RpEbdJSeq7Z77ZzKIRwKfHd/7+5/vzvffm" +
       "d2pXwqBW9z07W9tedEtLo1uW3b4VZb4W3qLo9kQOQk3FbTkM50XZq8oHvnb9" +
       "T773eePGQe1+qfYe2XW9SI5Mzw1nWujZO02la9dPSglbc8KodoO25J0MxJFp" +
       "A7QZRq/QtYdOdY1qN+kjCEABASggABUEADtpVXR6RHNjBy97yG4Ubmt/q3aJ" +
       "rt3vKyW8qPbC2UF8OZCdw2EmFQXFCNfKd74gquqcBrXnj2nf03wbwV+oA6//" +
       "1A/f+EeXa9el2nXT5Uo4SgEiKiaRag87mrPSghBTVU2Vao+5mqZyWmDKtplX" +
       "uKXa46G5duUoDrRjJpWFsa8F1ZwnnHtYKWkLYiXygmPydFOz1aO3K7otrwta" +
       "nzihdU9hvywvCHzQLIAFuqxoR13u25iuGtWeO9/jmMabo6JB0fWqo0WGdzzV" +
       "fa5cFNQe38vOlt01wEWB6a6Lple8uJglqj194aAlr31Z2chr7dWo9tT5dpN9" +
       "VdHqgYoRZZeo9r7zzaqRCik9fU5Kp+TzHeYjn/uES7oHFWZVU+wS/7Wi07Pn" +
       "Os00XQs0V9H2HR/+MP2T8hNf/8xBrVY0ft+5xvs2v/I33/6hH3j2rd/Yt/kr" +
       "d2jDrixNiV5Vvrx69Hffj7+MXi5hXPO90CyFf4bySv0nhzWvpH5heU8cj1hW" +
       "3jqqfGv2a+KP/qL27YPag8Pa/Ypnx06hR48pnuObthYMNFcL5EhTh7UHNFfF" +
       "q/ph7WqRp01X25eyuh5q0bB2n10V3e9V7wWL9GKIkkVXi7zp6t5R3pcjo8qn" +
       "fq1We6R4ao8Xz9Xa/lf9RzUBMDxHA2RFdk3XAyaBV9IfApobrQreGkAYu7rt" +
       "JUAYKIAXrI/fTaeQN4AbgeeUBmRGGecXPYPYuVUqmP+XN3RaUnUjuXSpYPj7" +
       "z5u7XVgK6dmqFryqvB53ibe/8upvHRyr/yE/otoHi/luHc53q5rv1p3mq126" +
       "VE3z3nLevUwLiWwK2y683sMvc3+D+vhnPnC5UCY/ua9gZ9kUuNj54ifeYFj5" +
       "PKVQydpbX0w+yf9I46B2cNaLlliLogfL7pPS9x37uJvnredO417/9Lf+5Ks/" +
       "+Zp3Ykdn3PKhed/eszTPD5znauApmlo4vJPhP/y8/Muvfv21mwe1+wqbL/xc" +
       "JBd6WbiQZ8/PccZMXzlyeSUtVwqCdS9wZLusOvJTD0aFIJKTkkrcj1b5xwoe" +
       "P1Tq7XPF8/KhIlf/Ze17/DJ97149SqGdo6JyqR/l/C/9/u/851bF7iPve/3U" +
       "esZp0SunLL4c7Hpl24+d6MA80LSi3b//4uTvfeE7n/5rlQIULV6804Q3yxQv" +
       "LL0QYcHmv/0b23/7zT/48u8dnChNVCx58co2lfSYyLK89uBdiCxm++AJnsJj" +
       "2IXCllpzc+E6nmrqpryytVJL/8/1l8Bf/q+fu7HXA7soOVKjH3jnAU7Kv69b" +
       "+9Hf+uH/9Ww1zCWlXLFOeHbSbO8G33MyMhYEclbiSD/5jWd++tflLxUOtXBi" +
       "oZlrlV86qHhwUHR6+S5RS2A6hTR2h54eeO3xb25+5lu/tPfi55eFc421z7z+" +
       "439+63OvH5xaO1+8bfk63We/flZq9MheIn9e/C4Vz5+VTymJsmDvPx/HD534" +
       "88de3PfTgpwX7garmqL/n7762j/9+dc+vSfj8bNLB1FERr/0r//vb9/64h/+" +
       "5h38V6G5nlxJslUBBSqgH67SWyWyiq21qu6VMnkuPO03znL4VFD2qvL53/vu" +
       "I/x3/9nb1aRno7rTZjKW/T2LHi2T50uKnzzvJEk5NIp20FvMX79hv/W9YkSp" +
       "GFEpQpmQDQoPnZ4xqsPWV67+u3/+L5/4+O9erh30aw8WVKp9ufJPtQcKx6CF" +
       "RuHcU/8Hf2hvF8m1IrlRkVq7jfi9PT1VvT16dw3rl0HZiXd76k9Ze/WpP/7f" +
       "tzGhcsp3ULpz/SXgzZ95Gv/Yt6v+J96x7P1sevuqVQSwJ32bv+j8z4MP3P+v" +
       "DmpXpdoN5TA65mU7Ln2OVESE4VHIXETQZ+rPRnf7UOaVY+///vNaf2ra8375" +
       "RNuKfNm6zD94zhV/X8nlj5XMPfRS18674ku1KjOsurxQpTfL5EOVTC5Htat+" +
       "YO4Koyl8YFgF4qVqm65sV1NBUe1hroE5vm1GsVqoTVB76WIZVq5mb/Rv/IMX" +
       "f+dH3njxjyqVu2aGBaVYsL5D4Hmqz3ff/Oa3v/HIM1+pVrT7VnK4p/l8xH57" +
       "QH4mzq5wP3zMoodLjhSZg1/dc2j/H9Wm7zY2UrxAKz+FQi0AOLz6ugmOAq7/" +
       "/4NW1LSODevSYZRTvvfKZH4k4eWdJXxQZr+/TNgjgd5va+46MqqWjapsb6ad" +
       "qHa5YG2Z5fz0eMqj9aF8f190uLKU6l18M3iuVi5SR3X7IM30bh1/rxWV6W3g" +
       "g9qHL9ahcSXKE2P89U/9l6fnHzM+fg/R2XPnVOz8kL8wfvM3Bx9UfuKgdvnY" +
       "NG/7mDvb6ZWzBvlgoBVfn+78jFk+s5dHxb+9MMrkpYrDd1kcNnepc8rEKCxS" +
       "KVm9l8xdmvtpbR96lelHyoTac/8HL/TWvbO+BC2eJw59yY0LfEl4gS8ps+My" +
       "Yc6o28MceOI/KhLOYYzuEeNHi+eZQ4xPXYAxv1eMzbtj/MQ9YnRq+xC5dvR/" +
       "B4yfvDeMD224xtFX0ZHB3eEjaqatY1sO9i1lG4+DnXaOmE+9C2KePyTm+QuI" +
       "+fF7JgY8IqYs+rFzED/7LiC+cAjxhQsg/t17hti8G8SfuEeI5TL94iHEFy+A" +
       "+MV7g3iFa6RZfqQMT9+uDEtRKr4MvOAc9J9+F9BvHkK/eQH0n71X6GABvXz5" +
       "0jlwf/9dgHvpENxLF4D7+XsF17wA3C/8xcE9fmT7HzoE96ELwH31Liv3+Ayu" +
       "gzFY5lrnQH3tLwHUP7kHUM07gfqVdwRV9U8vFV/fV5q34FtVKPL1uwjq+28X" +
       "1JOWrdw8+v7jtSAsAoOblg0fmcSNk2Blv9N6DiT0FwZZBC2PngxGe+76lc/+" +
       "h8//9t958ZtFhEvVruzK6L+IPU7NyMTlPvaPvfmFZx56/Q8/W203FNEPd+Xt" +
       "3692BX/t3kh9uiSV8+JA0Wg5jMbVDoGmHlN7LpK7rwgY3j210Q2bhMIhdvSj" +
       "eQlfYko6W0ZLxeGC8bijY66EmEvJxlqhsPaIOJkPIh9Ps7EvcIrYdfi1luty" +
       "nPpbdSBIHV8ShjE/pPLNYjYmFG7RX2zba8NeDb0RK3rY3Ca7iy7G4dhmiodG" +
       "l/CMXpdTeI4YcogLtPJxJ2XrkdgXAB4dww1gAqOtOgqgLNJG8Y4kSfYGV3nR" +
       "IhoyOAxAeZTqY7Mpw33RzlCvqyuTjBSW3LKlATsBRO3+dLyZO9YmWrhculI9" +
       "GwPlaXPGb4TcGc0pkPEH8owiUWq38GIZSrszdZDReV8OW2LHHAU0Vp8snJk4" +
       "UjfUxrRSyvStwVSCVwtpzIxkjHDNJUVDftwLgjXn20veapj8DvW7LQ2F1pIi" +
       "q1lztBmu+suBr5uCLHuIODNDuaNwCpSp5CILNC+cueMwshU0B1ddX3Rz3OYS" +
       "aEt20LyOaCuuu23isT/YdCAADzEh8DuWwRR40CYaWw0vBfsrZ2Dj/NASNXGj" +
       "y8S4uVEor9XzsbZsJ9tN0GFkJmIjJbfGED8zMnw9HSI7dI7llN0bNp0WFI9b" +
       "uCdaUnNiWFM6jK0+t6aHTLvJ73KMXIUr0oQsdMFulhExWMwSyRhgSTbDPHsg" +
       "DbYDO+JMyVe8dUMOeuIanS2oviCFttbJeJpzQi4LJxkrBFgug/g8r7tbPBJn" +
       "IWVLjmY7pN0ZDdpzlMFjm3NcLA57/ZHRjZMlhAmjJiYOpBEWxLnR5iYjfstt" +
       "5GWXWDpjWEIwzDBkR+6H/Bid8HKbahAD2Rg63saX2R5E+7KwWbuy0MOk7Tga" +
       "TrMZ31htrMTxtU0iOBwW2HUE2wZSMSJkUGR7OqdZnJd9atUduTu+raJhnwGb" +
       "0UoVTAobZlTHCb1dAo4HBiUyGDbnB/O1UR+uV3xABCqNp/CKzBaEySqkiS0Z" +
       "NUdRMZ5IHATVaWEt9GVSmgSjZeak4sRaZ21o2W/Ju6XdIURelOLRyoIm8VzJ" +
       "gCBiwEYby+jx2kpJvWvnSwNSNXY76qSdddphN7GvLjJ6K+cipjKK30nt7kK2" +
       "2zgj+CMLl+BMyLbUateug20O1xVqJrOmWnxoSjwpcIjPt2zBQJrqdDH1RW+4" +
       "3UI8PFsEfr5qGKHNAG6PoIYkn21wuT0aujDitvuTdKODvSFIh9up7xjwjmkt" +
       "iRWyMCAvw1Yb3eJtid7qPtHq0XY86DgIgo66kQi3LHDbMezGcMgzPcNLGmHq" +
       "iI6xTmPbchfMQskUk+B7ELTF4W0d84XWAuQU0Kgvuk0FqVMJMpngNoMjsA4m" +
       "ynrr4KiTp7qFIMIoXxR95zAzodJlgDth1rUgZj1fNiOh58J+IwcgXhK643Qz" +
       "bW+7DMUDJjenlRVGZd6ES3RZ3q6EXXuQtpnZwofWc4keh/5oxArs3BEljxoC" +
       "Us8OYSx2yXxK05P+Bmu0NT/Lp9SUW4cD1FC2u1kqO0NgCIwRkkoUQ4XEHoJM" +
       "Z9rCndXrSkzCbiTEFsV6E6Bn2fTQkFg60ZPWok7TCkmuILEFeKtWCwYytgWr" +
       "jA7qkktwItYfpmTP3GJGl1nk9AiVKKuRAYxZV7dwsznDZWfKxd1+f8ctMXbZ" +
       "nPvKdtgQtxs8wV01J9bbnUs1luMWpporhXQ6hqWnddI3+r1VIC8CQ2jCMAkA" +
       "ZIStJytDGZkNBcJH5FqIyd40nsR8GwXag77W2uS97USy6xt6GM/bXVzaNBCy" +
       "J3SkYNfzu3NvGdRzAF2tWgGY9mFV8gbrgHEIOIoaU3eAUVOlqev6dsujKALV" +
       "u/RC1dmBMPdhzAhVl2pvGGOy3cSYwdhCrFPYpj/ppmjh/kxgnvQ6vI2PmG13" +
       "qnZAABzloVZXGaanDFmeNdKctcJNziR1BBDnozas7hSSy82VOUwpMBIkLhNN" +
       "FMyWSLaa27g0s6IcpGGpjkpGg6lPMZOOhfGGLxQdzMjFHN15cJ2h1mqoYDt7" +
       "moQJbKr2PIBRxIKbwE4nDNe18GGvy7SQep3RWzs3a8U6NLQ1o90cA9AWzus9" +
       "nsCH9T4ztWw94QC8nwPJNOYto2HGlgo2M9sR5jA5IESW6qOqaE+8btrTQWDu" +
       "NPvgbpKtsS7JJGvKiidFb6s5bJEzLKBycbua8nBXQ8SQ38wUuitZ6DCi8wVN" +
       "wqTda+jNyTIAdkbc54lWPWLCXox4pA6Qu3aTagHxVhoGhL4kzGVKrvJlb+7o" +
       "rKm1QUTFNNfMUR2AWNkJzcaUWfoUz0vzIAy41pZbUvWsEbDZUIJdhZ71dsiQ" +
       "7vkCsQnXkoDNdwKiiwgd7uQdwRFcYw7FnZYY0BxCqBwg+pCKrroI0tjtQA1E" +
       "YICYkzQPcHWIGZBNbsjPNXPc2PITFxeHq9XIdqwpqccNAVwyW4OcJBw7Rboz" +
       "w216kdokUCrIjZm20uyVTbcAqD0conSbm3W6EtcTfHbl9yEfl/PhYsbJ6TRT" +
       "kA4kj9gh0WX4Rm+WbEdTTCcIUotdDtrB+iYnRBQ1fThrIeh62ZqvgO60vTA0" +
       "PDehZpSEhc7mqyxR4EkPywv4db2la8smLvRnlJ5Y4xHcdtFdIZGoUEMFt3Vm" +
       "I4xnNhazJOTpsRy7mkJlExUec5YDT/pCOxnSLCzmoZ5Nkije0uYM7HPsYipL" +
       "dDxtmo4viDk4BTFEINpgVxEEuNA+oovDrW0bAe2GgvbdSTTuIx1SIJRYzDVL" +
       "6bten46xQcwupeYW2zoJVgQMDQbJKAdZihOGXebtzDB9hkj6ptOc7sa0ycyi" +
       "TrilKNnESGa+U0wkxzm2tW5uQNEPmJAwc0nN5KmFrBFsau12MO1sOS1cAXBd" +
       "FAg+1SjUw7ZtAIa29dVyvMhzDWrP3WJ9szJWx0FhSIMZZaLsIm9xKzreuJZh" +
       "jGUoj9ccs+RGcaPHtNgmNNIYBpLHtkbUoYhcozRYWCoCt3QpIDf4to+FIb6i" +
       "xM0smI7rMjptIpoOD2J03tOLhc0aB1NrC6MQvc0YnVvswEKUjLmZrbAIn1jw" +
       "jsC4Zl0QRg6ILFbNiQizgxD0xrOtPaNDsM82Bd6ldxlsUkS2waJdmiQt03JW" +
       "XTeNpZ3UxFqNiWyjqgcbuaJ2CiCTmQjYebdlSqP2aCe4rTQYoj0VmvQ6LSau" +
       "a61WE2VX885ylNCQTXU2FkJuCpbWZYRdTEyXDg2r3oSZdRLHygL3ZBvTwmG4" +
       "S4VWp+/S9sZupbQ9S0NTNoqFTl+Tqm5b/IqnBHW1AAZOJ58Ly7FAjJpU3gdh" +
       "lbCDTj2ldxORHDNdPJT6YCDOpm6WpwtnEifiuJe0G5bY1dkslRM11GBSorjE" +
       "JiR/owJmD3G3UD9az7YcsRmRSErhlgUL7dDw+KCPrUzD6LGD4RpuEfhYn0+x" +
       "NhG7ODvD434QdSS/t2aSjpj1mKGUzLiB6g8xlSUW5sAcbGfsBO2vyRRNNz2c" +
       "7THcOJch0HIhZUDNNkuWw6SA3fpDf4QLINuM2W4R+jDTCZE1s7btLdY7Rx+Y" +
       "4zGkIFO159BhfSNiKdzIE5pUXAds40OIlKDEsnoTssFvRmm9P0+HxCqaS3AU" +
       "iFOyWKAHhCJKiTlbN6N8A7JsEc8vmhFs80ne3dlICwPM+jhhEHglLmCOhFx/" +
       "ne6sHmuOkB7Ckj0vIYhZU8PE0QLNEW/aHauOhePjcUZ7PYJM0EmdxYZ1Q9ML" +
       "PrdhN+9ixKQI+AZopM4n1oDYJJKpSyDENDtrdgpMpk1uB+UMnhu2BBP+Mtuk" +
       "kgZvBBQvop50ySUjt26025PuIknmICyjJtlvdbbKDh9g6ISCdbXBjpf0bC2B" +
       "cbOjeCiVbl1fNIVWyPehMd+LJLyvj/vmWOCHMb1sZh7uIUwCiYNos9UCEYEm" +
       "pOMWi/aW7Uk7USG8qbhyBGGrxokJsKjTsfMOmwyh7rCDUaS/myHzKGKphs30" +
       "ycW4yRpu4CRdJsaI7SjO5DTndb6L80sUa4fzRWHtIxlVSXcJopQOFKRkC0ZZ" +
       "1JER7ucB0y2C7HSpDup6t6GrS7yjRFrfFdZI1kz63nbG9yV+pymsuwtHSWfq" +
       "GyK77cvKFBglEeEMNiGHW1NibgHZuhnjkEsPNaJj9jcanZMwnBK2jG2HY3o1" +
       "CieUQIT0uC3tnDZH1yeNNKjTbQpk0xRarnRysQSyIAYJQ0J4EBF6UKZrTnPb" +
       "QBGgC6fZoiv43EYLm/F6akg6DVAguKOmq3VnZ26bwaSd5w024+d21+tjI1gN" +
       "8qHYEHsQFQ4Cx6ahXq7KIaIX/qlTrJukDmcAFC48U0tMYuqMIL7Zn4FEe5js" +
       "ZrKtmQixFmSbqhcBClh34vkAabOAvgH1yCBnhIOwVFoXup0OKi01AxHrzfEa" +
       "SJAOrhFqDgzzENrY0XocWH6MImrSkR1orqfwRltNlnx7uUuxdGyNEm9SrGxA" +
       "Bgo9lu/mYRvmN6Hp9Bx/HSGaH7SatqyKSREbKqS780O6ITrAog32OiLUws08" +
       "x5UQQK2uqyFuhMvj1WjYqtMqtENwmYQmQxyzMAz7aLnt8I172w55rNr5Ob5w" +
       "Z9lwWfEv7mHHI33nA7PjbbPqV54knrm7dWrb7NQ5d608iX/mout11b2DL3/q" +
       "9TdU9ufAg8NzGziqPRB5/l+1tZ1mnxpqf+imHcOooDxZPLcOYdw6v3t3Qv9t" +
       "hF2qCNvz79wZ0qWTBvvLDP/xLodM3yqTPyqPi2XH3198a51w/I/faY/p9HDn" +
       "yKs27sv95eYhec17IO/OinKOjoMTEbdOqP3vd6H2f5TJd6La5bVWnYx+6YTU" +
       "/3YvpKZR7b13ut9WXtZ56rYbs/tbnspX3rh+7ck3Fv9mfyB+dBPzAbp2TY9t" +
       "+/QFgVP5+/1A080K/AP76wJ+9fe9wmhuOyGIaleq/wrvn+4b/llUe+hUw6h2" +
       "9TB3qlG5a3u5aFRmD/yj7dbnbj+BOHMOlV46ayfHrHz8nVh5yrRePHN2XN1J" +
       "Pjrnjfe3kl9VvvoGxXzi7c7P7e+YKbac");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("V7v51+ja1f11t2rQ8qz4hQtHOxrrfvLl7z36tQdeOjLWR/eAT1TxFLbn7nyh" +
       "i3D8qLqClf/qk//4I//wjT+oNoP/H3ucv/AsLgAA");
}
