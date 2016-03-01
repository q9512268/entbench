package org.apache.batik.apps.svgbrowser;
public class SquiggleInputHandlerFilter extends javax.swing.filechooser.FileFilter {
    protected org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler;
    public SquiggleInputHandlerFilter(org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler) {
        super(
          );
        this.
          handler =
          handler;
    }
    public boolean accept(java.io.File f) { return f.isDirectory(
                                                       ) || handler.
                                              accept(
                                                f); }
    public java.lang.String getDescription() { java.lang.StringBuffer sb =
                                                 new java.lang.StringBuffer(
                                                 );
                                               java.lang.String[] extensions =
                                                 handler.
                                                 getHandledExtensions(
                                                   );
                                               int n = extensions !=
                                                 null
                                                 ? extensions.
                                                     length
                                                 : 0;
                                               for (int i = 0; i <
                                                                 n;
                                                    i++) { if (i >
                                                                 0) {
                                                               sb.
                                                                 append(
                                                                   ", ");
                                                           }
                                                           sb.append(
                                                                extensions[i]);
                                               }
                                               if (n > 0) { sb.append(
                                                                 ' ');
                                               }
                                               sb.append(handler.
                                                           getDescription(
                                                             ));
                                               return sb.toString(
                                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYfWwUxxWfO9vnD4y/CIYYMMYYSxhyV5LQNDJNYwyOTc74" +
                                                              "hAlSj5Zjb2/ubmFvd9idtQ8Hl0DVgtKKRnwkJA38U6K2iISoatSqVShVP5Io" +
                                                              "TRE0apOgJm3zR9ImSOGPxmlpm76Z2dvd27szov/0pJvbm3nvzbyv33uz566h" +
                                                              "GtNA3UTSUlKY7iXYDMfYc0wyTJwaVCXT3AqzCfnRPx/bP/O7+gNBFIqjpqxk" +
                                                              "jsqSiYcUrKbMOFqiaCaVNBmbmzFOMY6YgU1sTEhU0bU4mq+YIzmiKrJCR/UU" +
                                                              "ZgTbJCOKWiVKDSVpUTxiC6BoaZSfJsJPExnwE/RHUaOsk70uQ0cRw6BnjdHm" +
                                                              "3P1Milqiu6QJKWJRRY1EFZP25w20iujq3oyq0zDO0/Auda1tiE3RtSVm6H6+" +
                                                              "+eMbj2VbuBnmSZqmU66iuQWbujqBU1HU7M5uVHHO3IO+gqqiaI6HmKKeaGHT" +
                                                              "CGwagU0L+rpUcPq5WLNygzpXhxYkhYjMDkTRsmIhRDKknC0mxs8MEuqorTtn" +
                                                              "Bm27HG0L7vapeGJV5PgTO1p+UIWa46hZ0cbZcWQ4BIVN4mBQnEtiwxxIpXAq" +
                                                              "jlo1cPg4NhRJVaZsb7eZSkaTqAUhUDALm7QINvierq3Ak6CbYclUNxz10jyo" +
                                                              "7H81aVXKgK7trq5CwyE2Dwo2KHAwIy1B7Nks1bsVLcXjqJjD0bHnQSAA1toc" +
                                                              "plnd2apak2ACtYkQUSUtExmH4NMyQFqjQwgaPNYqCGW2JpK8W8rgBEUL/XQx" +
                                                              "sQRU9dwQjIWi+X4yLgm81OHzksc/1zavO/KwNqwFUQDOnMKyys4/B5g6fUxb" +
                                                              "cBobGPJAMDb2RR+X2l88HEQIiOf7iAXNj/Zdv39158WXBc2iMjRjyV1Ypgn5" +
                                                              "TLLp8uLBlfdWsWPUEd1UmPOLNOdZFrNX+vMEkKbdkcgWw4XFi1t+/cVHzuIP" +
                                                              "gqhhBIVkXbVyEEetsp4jioqNB7CGDYni1Aiqx1pqkK+PoFp4jioaFrNj6bSJ" +
                                                              "6QiqVvlUSOf/wURpEMFM1ADPipbWC89Eoln+nCcIoVr4okb4LkXiw38p2hfJ" +
                                                              "6jkckWRJUzQ9EjN0pj9zKMccbMJzClaJHklC/O++Y034noipWwYEZEQ3MhEJ" +
                                                              "oiKLxSL8IWbEnMgkDX0S8DEyvsdSMhkV0I1YdBhEgrZDigqxFmZRSP7P++eZ" +
                                                              "feZNBgLgusV+4FAh54Z1NYWNhHzcWr/x+nOJV0VQskSyLUtRPxwiLA4R5ocI" +
                                                              "s0OE3UOEKx8CBQJ879vYYUTIgMN3A3QAdjeuHP/ypp2Hu6sgVslkNXiLkfaW" +
                                                              "1LJBF2MKhSEhn7u8ZebSaw1ngygIMJSEWuYWlJ6igiLqoaHLOAWIVqm0FOA1" +
                                                              "UrmYlD0Hunhy8sC2/Z/h5/DWCCawBuCNsccYsjtb9PixoZzc5kPvf3z+8Wnd" +
                                                              "RYmiolOolSWcDHy6/Z72K5+Q+7qkFxIvTvcEUTUgGqA4lSDrACA7/XsUgVB/" +
                                                              "AdCZLnWgcFo3cpLKlgoo3ECzEBbuDA/BVv58G7h4DsvKFfDtttOU/7LVdsLG" +
                                                              "BSJkWcz4tOAF4/Pj5NQbv/3rXdzchdrS7GkKxjHt9+AZE9bGkavVDcGtBsZA" +
                                                              "98eTsWMnrh3azuMPKJaX27CHjYOAY+BCMPPXXt7z5jtvn3k96MYshYJuJaE3" +
                                                              "yjtKsnnUMIuSLM7d8wAeqoAJLGp6HtIgKpW0IiVVzJLkX80r1rzw4ZEWEQcq" +
                                                              "zBTCaPXNBbjzt69Hj7y6Y6aTiwnIrB67NnPJBMjPcyUPGIa0l50jf+DKkidf" +
                                                              "kk5BuQCINpUpzFE3YOctO9RCitb+T1jBXX43lxHh413MXFwy4mufY0OP6U2d" +
                                                              "4uz0dF0J+bHXP5q77aML17muxW2bN1JGJdIvgpMNK/IgfoEfpoYlMwt0d1/c" +
                                                              "/KUW9eINkBgHiTJAszlmAHDmi+LKpq6pfevnv2jfebkKBYdQg6pLqSGJpyiq" +
                                                              "h9zAZhYwN0++cL8Ijck6GFq4qqhEeeaNpeX9vDFHKPfM1I8X/HDdd0+/zUNS" +
                                                              "xOAiB027StCUt/wuEHx49dvv/mzmO7WiYVhZGf18fAv/OaYmD/7lkxIjc9wr" +
                                                              "08z4+OORc093DN73Aed3AYhxL8+XFiuAaJf3zrO5vwe7Q78Koto4apHt9nqb" +
                                                              "pFosrePQUpqFnhta8KL14vZQ9EL9DsAu9oOfZ1s/9LlFEp4ZNXue60O7JubF" +
                                                              "VfDtsoGgy492AcQfRjhLLx9XsmF1AVzqiaFTOCVO+fBl7ixiKarNitxif9cK" +
                                                              "SGXjvWzYJCStKxeCYqmXDX3OfvwT8vdWXjxzow6xRFpSqf3lrfuZg8dPp8ae" +
                                                              "WSNirq24pdwIN6Znf//v34RP/umVMt1IPdXJHSqewKpnzyBsuawk0kf57cAN" +
                                                              "m3uuzFRdPbqwsbRlYJI6KzQEfZVTwr/BSwf/1rH1vuzOW+gFlvoM5Rf5/dFz" +
                                                              "rzzQKx8N8guOiNKSi1ExU39xbDYYGG5y2taiCO12XDuPuex2+Pbaru0tX4/L" +
                                                              "RIVT5Sqx+hDdVysaOa4pOiCDivku8iwlIMOGHVBrGfoSymuBx+HsrcS4lTRp" +
                                                              "zFByUPkn7DvT+faZPb+sndpQuA+VYxGUD5qjl34y/F6CO6+ORYdjMk9kDBgZ" +
                                                              "T1vTImzxKXwC8P0P+7ITswlx+2gbtK9AXc4diBCWIbMgrU+FyHTbO7uffv9Z" +
                                                              "oYIfVn3E+PDxRz8NHzkuMkdcpJeX3GW9POIyLdRhg5rnyTTLLpxj6L3z0z/9" +
                                                              "3vShoO2fbQA5SV1XsaSVOJxdG32GF6cNrTn1j/1ff2MMutARVGdpyh4Lj6SK" +
                                                              "47fWtJIeT7i3bzea7XMzq1MU6CN2FeRYl5gF60rLLZsY4NNxJ8zbCgDbZ4d5" +
                                                              "361nSCXWWQL+wCxrX2XDPoqaMphuwKZsKMTBGcisFp5ZrMKFxQsQ1xzTt26O" +
                                                              "PEUdlW94rENZWPJKSrxGkZ873Vy34PRDf+C3DOdVRyPkV9pSVW8B9TyHiIHT" +
                                                              "CtezUZRTwn++SVHXzdpLihrcP1yfbwjmb1E0vywzRdXsx0t7FCzop6Wohv96" +
                                                              "6U7Abi4dgyb+4CU5SVEVkLDHJ0nBPd38Zh42J8EzYfZyQ87qOuuNGRAKq+YD" +
                                                              "xRXV8d/8m/nPU4SXF0EMf7tYyEBLvF8EfDy9afPD1z/7jLhPyao0NcWkzIG8" +
                                                              "E1c7p1ItqyitICs0vPJG0/P1KwqQ0CoO7GbHIk8IDwAwEBY8Hb7Lhtnj3Dne" +
                                                              "PLPuwmuHQ1cAzLajgETRvO2lzVueWFBGt0fLIQzUcX4P6m94d+elT94KtPEe" +
                                                              "2cakztk4EvKxC1djaUKeCqL6EVQDiIfzvLPcsFfbguUJowiwQknd0pwXkU0s" +
                                                              "0iWWeNwytkHnOrPsPg5hUArLpe8o4PowiY31TLoNgEW13SLEu8otOyHQUNSf" +
                                                              "qkR0lBC7HgXu5JYnhCf2OTZM/hcHg9BiQhgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
