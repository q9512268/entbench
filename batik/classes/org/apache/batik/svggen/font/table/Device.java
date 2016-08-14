package org.apache.batik.svggen.font.table;
public class Device {
    private int startSize;
    private int endSize;
    private int deltaFormat;
    private int[] deltaValues;
    public Device(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        startSize =
          raf.
            readUnsignedShort(
              );
        endSize =
          raf.
            readUnsignedShort(
              );
        deltaFormat =
          raf.
            readUnsignedShort(
              );
        int size =
          startSize -
          endSize;
        switch (deltaFormat) {
            case 1:
                size =
                  size %
                    8 ==
                    0
                    ? size /
                    8
                    : size /
                    8 +
                    1;
                break;
            case 2:
                size =
                  size %
                    4 ==
                    0
                    ? size /
                    4
                    : size /
                    4 +
                    1;
                break;
            case 3:
                size =
                  size %
                    2 ==
                    0
                    ? size /
                    2
                    : size /
                    2 +
                    1;
                break;
        }
        deltaValues =
          (new int[size]);
        for (int i =
               0;
             i <
               size;
             i++) {
            deltaValues[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZfWwUxxUfn41t/IE/+AxgA7ZJxEfukjRphUxJwNhgejYW" +
                                                              "Jo5qCGZub+5uYW93sztnH6Q0CWoErVRECSG0TfxPSSGIhChq1ERtUqqoJFE+" +
                                                              "pHy0aRoF+qU2bYoaVDWtmrbpezO7tx93Z4SqWNq52dn33rw3897vvRmfuUSm" +
                                                              "2RZpZzqP8j0ms6O9Oh+ils2SPRq17a0wNqY8VEn/tuODwVURUj1KZmSoPaBQ" +
                                                              "m/WpTEvao6RN1W1OdYXZg4wlkWPIYjazxilXDX2UzFbt/qypqYrKB4wkQ4IR" +
                                                              "asVJC+XcUhM5zvodAZy0xUGTmNAktjb8uTtOGhTD3OORz/OR9/i+IGXWm8vm" +
                                                              "pDm+i47TWI6rWiyu2rw7b5EVpqHtSWsGj7I8j+7SbnGWYFP8lqIl6Hiy6eNP" +
                                                              "DmeaxRLMpLpucGGevYXZhjbOknHS5I32aixr30W+SirjpN5HzElX3J00BpPG" +
                                                              "YFLXWo8KtG9kei7bYwhzuCup2lRQIU6WBIWY1KJZR8yQ0Bkk1HLHdsEM1i4u" +
                                                              "WCutLDLxwRWxow/taH6qkjSNkiZVH0Z1FFCCwySjsKAsm2CWvTaZZMlR0qLD" +
                                                              "Zg8zS6WautfZ6VZbTeuU52D73WXBwZzJLDGnt1awj2CblVO4YRXMSwmHct6m" +
                                                              "pTSaBlvneLZKC/twHAysU0ExK0XB7xyWqt2qnuRkUZijYGPXl4AAWGuyjGeM" +
                                                              "wlRVOoUB0ipdRKN6OjYMrqengXSaAQ5ocTK/rFBca5Mqu2majaFHhuiG5Ceg" +
                                                              "mi4WAlk4mR0mE5Jgl+aHdsm3P5cGVx+6W9+oR0gF6Jxkiob61wNTe4hpC0sx" +
                                                              "i0EcSMaG5fFjdM5zByOEAPHsELGk+eFXLt+2sv3cS5JmQQmazYldTOFjyonE" +
                                                              "jDcW9ixbVYlq1JqGreLmBywXUTbkfOnOm4AwcwoS8WPU/Xhuy/kv33uafRgh" +
                                                              "df2kWjG0XBb8qEUxsqaqMWsD05lFOUv2k+lMT/aI7/2kBvpxVWdydHMqZTPe" +
                                                              "T6o0MVRtiHdYohSIwCWqg76qpwy3b1KeEf28SQipgYc0wNNG5J/45WR7LGNk" +
                                                              "WYwqVFd1IzZkGWi/HQPEScDaZmIJ8PrdMdvIWeCCMcNKxyj4QYa5H8bTaabH" +
                                                              "UgYiFE1oLLaejasKi6KXmZ+x/DzaN3OiogKWfmE48DWImY2GlmTWmHI0t673" +
                                                              "8hNjr0inwkBwVoaTZTBlVE4ZFVNG5ZRRnDIqpozKKUlFhZhpFk4tNxi2ZzcE" +
                                                              "OiBtw7LhOzftPNhRCZ5lTlTB2iJpRyDj9Hho4EL4mHK2tXHvkgs3vhAhVXHS" +
                                                              "ShWeoxomkLVWGqBJ2e1Eb0MCcpGXEhb7UgLmMstQWBIQqVxqcKTUGuPMwnFO" +
                                                              "ZvkkuAkLQzNWPl2U1J+cOz5x38g9N0RIJJgFcMppAGDIPoTYXcDornD0l5Lb" +
                                                              "dOCDj88e22d4OBBIK242LOJEGzrCvhBenjFl+WL69Nhz+7rEsk8HnOYU4gog" +
                                                              "sD08RwBmul3IRltqweCUYWWphp/cNa7jGcuY8EaEk7aI/ixwi3qMuxZ4ljqB" +
                                                              "KH7x6xwT27nSqdHPQlaIlPDFYfORX77+p8+J5XazR5Mv7Q8z3u1DLBTWKrCp" +
                                                              "xXPbrRZjQPf+8aEHHrx0YJvwWaDoLDVhF7Y9gFSwhbDM979017sXL5x4O+L5" +
                                                              "OYeUnUtA5ZMvGInjpG4KI2G2az19APE0QAX0mq7bdfBPNaVi4GFg/btp6Y1P" +
                                                              "/+VQs/QDDUZcN1p5ZQHe+DXryL2v7PhHuxBToWDG9dbMI5MwPtOTvNay6B7U" +
                                                              "I3/fm23ffpE+AgkBQNhW9zKBqxVOrKNS8yA9CE7ViG6hetLIrlUA1Ow+QGix" +
                                                              "q7cIshtEe3Mx80yXuX9zb15hJiok+FZhs9T2R04wOH1l1Zhy+O2PGkc+ev6y" +
                                                              "MDVYl/kdZYCa3dI3sbk2D+LnhpFtI7UzQHfzucHtzdq5T0DiKEgURm22AFnz" +
                                                              "AbdyqKfV/OqnL8zZ+UYlifSROs2gyT4qIpRMh9BgdgZAOW/eepv0jIlaaJqx" +
                                                              "lyeFhSFiYUi+aAB3Z1Hpfe/Nmlzs1N5n5v5g9cnJC8JFTSljgeCvwjwRgGRR" +
                                                              "3XuocPqtL/z85LeOTcj6YFl5KAzxzfvXZi2x/7f/LFpyAYIlapcQ/2jszMPz" +
                                                              "e9Z8KPg9NELurnxxbgNE93hvOp39e6Sj+mcRUjNKmhWnmh6hWg5jfBQqSNst" +
                                                              "saHiDnwPVoOy9OkuoO3CMBL6pg3joJdToY/U2G8MQR+WH2Q+PIscVFgUhr4K" +
                                                              "IjoDguU60S7H5noXaWpMS4UTFwtBTf0UQjmUpJxafBhCNpiSMe0N5xI2pE81" +
                                                              "C2g57lSSNw3tVA52Df1eesE1JRgk3exTsW+OvLPrVYHFtZigt7qW+9IvJHJf" +
                                                              "ImiWin8KfxXw/BcfVBgHZEXW2uOUhYsLdSF68ZTuGDIgtq/14u6HP3hcGhD2" +
                                                              "vRAxO3j0G59GDx2VACsPF51F9b2fRx4wpDnY3IHaLZlqFsHR98ez+350at8B" +
                                                              "qVVrsFTuhZPg47/4z6vR479+uUSVVqk6B0Q/bEKKDO6NNGj915t+fLi1sg9S" +
                                                              "ez+pzenqXTnWnwz6aI2dS/g2yzu0eH7rmIYbw0nFctgDmZixXY3NoHTCW8si" +
                                                              "2Yag58+DZ7HjpIvLeL50leuwGSp28XLcXJwV0MHxdSSkZ+Yq9VwIzxJnpiVl" +
                                                              "9NSn1LMcNyf1SaZx2odFEy+lq3GVurbD0+HM1lFG19yUupbjdnUVQGkHb48K" +
                                                              "OCCqA+l12+vP/8T+3h+ekt5dCmVC59VTJ2uV97LnBcrgjLcXdJuBqmCJ6CyC" +
                                                              "/OVk2/95lsJbFDrBY2lmZOHEzjNwBEjzjHtU+yzFI0IsLY9fvnWc/H7n6/dM" +
                                                              "dv5G1Bq1qg1JBxC0xJ2Bj+ejMxc/fLOx7QlRzFchEDtxHbxsKb5LCVyRiF1o" +
                                                              "wmaf6I6UrNM2SALHt75WOlNFsBvlkCNVnWpC2h1QJmtiQfBtOzb7Ta/AiUi+" +
                                                              "YCmIaTnaoxk6w2LW/TbLLRML91LwMV8CHdsCpc6AMNWrG96fceR3z3al113N" +
                                                              "wRPH2q9wtMT3RbBfy8tvd1iVF/f/ef7WNZmdV3GGXBTyhrDIxwbOvLzhWuVI" +
                                                              "RFx9yYKm6MosyNQdTBF1FuM5Sw8mhU7PPfZ7sLJCbHCouHdLVnw/NsW349g8" +
                                                              "AL6i4EZLv5iC/LvFNTEO9Jq+8tlxAXxVwllrfAqEzftMKqCR+KsmoZsjH1L6" +
                                                              "CmyCcd5W7nJPVAEn9h+dTG5+9EYX9nZAfcYN83qNjTMtIAoCRl68YNE/r+he" +
                                                              "V95FKk9MNtXOnbz9HRn77n1hAzhkKqdp/rLU1682LZZSxfwNskiV2f0xTjqu" +
                                                              "fB8Ee8ULAXlKcp6BenkqTk6q8MfPcpaTuWVYwHTZ8dM/xUlzmB5UEb9+uqc5" +
                                                              "qfPoQJTs+EmegYoKSLD7rOniSrOHOfIokK8Ibm3Bh2ZfKUv7vKEzAAPiEt8N" +
                                                              "2Zy8xh9Tzk5uGrz78ucflZcaikb37kUp9QDQ8n6lEPZLykpzZVVvXPbJjCen" +
                                                              "L3X9q0Uq7EXBAl8w9UKUmOhe80MnfrurcPB/98Tq5187WP0mJKRtpIICNm8r" +
                                                              "PjTlzRw4/rZ4cT0KECmuIrqXfWfPmpWpv74njqUOQi8sTz+mvH3yzreOzDvR" +
                                                              "HiH1/WQahA7Li9Pc+j36FqaMW6OkUbV786AiSIFEECh2Z2AkULzeF+viLGdj" +
                                                              "YRSvxMDZi+v84otEOMJPMGudkdOTTlqt90YC/11wkTNnmiEGb8SXaxMCNvOy" +
                                                              "uKkciw+YpnsMqr/OFOCilMe0V0UXm9f+B+d8pvXgGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rT+tDsv+LwMzqYrbJgAA");
}
