package org.apache.batik.svggen.font.table;
public class CoverageFormat1 extends org.apache.batik.svggen.font.table.Coverage {
    private int glyphCount;
    private int[] glyphIds;
    protected CoverageFormat1(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        glyphCount =
          raf.
            readUnsignedShort(
              );
        glyphIds =
          (new int[glyphCount]);
        for (int i =
               0;
             i <
               glyphCount;
             i++) {
            glyphIds[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public int getFormat() { return 1; }
    public int findGlyph(int glyphId) { for (int i = 0; i < glyphCount;
                                             i++) { if (glyphIds[i] ==
                                                          glyphId) {
                                                        return i;
                                                    } }
                                        return -1; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVZfZAUxRXv3fs+Du4DOS4gX3cHVXy4E/yISZ0xwnkHB3vc" +
                                                              "FQdU5TAec7O9uwOzM8NM792CIaiVCEWVlCVoMJFLVYJJNPgREyomlgTzpZZR" +
                                                              "C2ISkUSi/iEGqYI/4pmYxLzXPbPzsR8UValkq6a3d/q91/36vfd7r3uPXiBV" +
                                                              "tkXaTVlPyDG2w6R2bBD7g7Jl00S3Jtv2Bng7oux7+8Duyd/V3RUl1cNkWlq2" +
                                                              "+xXZpr0q1RL2MJmj6jaTdYXa6yhNIMegRW1qjclMNfRhMkO1+zKmpioq6zcS" +
                                                              "FAk2yVacNMuMWepoltE+RwAj8+J8NRJfjbQiTNAVJw2KYe7wGGYFGLp9Y0ib" +
                                                              "8eazGWmKb5XHZCnLVE2KqzbryllkqWloO1KawWI0x2JbtRucjVgTv6FgG9qf" +
                                                              "avzw4/vSTXwbpsu6bjCuor2e2oY2RhNx0ui97dFoxt5OvkIq4mSKj5iRzrg7" +
                                                              "qQSTSjCpq69HBaufSvVsptvg6jBXUrWp4IIYWRAUYsqWnHHEDPI1g4Ra5ujO" +
                                                              "mUHb+XltXXOHVHxgqXTw67c3PV1BGodJo6oP4XIUWASDSYZhQ2lmlFr2ikSC" +
                                                              "JoZJsw4GH6KWKmvqTsfaLbaa0mWWBRdwtwVfZk1q8Tm9vQJLgm5WVmGGlVcv" +
                                                              "yZ3K+VWV1OQU6Nrq6So07MX3oGC9CguzkjL4nsNSuU3VE9yPghx5HTvXAgGw" +
                                                              "1mQoSxv5qSp1GV6QFuEimqynpCFwPj0FpFUGuKDFfa2EUNxrU1a2ySk6wkhb" +
                                                              "mG5QDAFVHd8IZGFkRpiMSwIrzQpZyWefC+tu2n+HvlqPkgisOUEVDdc/BZjm" +
                                                              "hpjW0yS1KMSBYGxYEn9Qbn1ub5QQIJ4RIhY0P/nypVuWzT3xoqCZXYRmYHQr" +
                                                              "VdiIcmR02smruxd/rgKXUWsatorGD2jOo2zQGenKmYA0rXmJOBhzB0+s/80X" +
                                                              "73yMno+S+j5SrRhaNgN+1KwYGVPVqLWK6tSSGU30kTqqJ7r5eB+pgX5c1al4" +
                                                              "O5BM2pT1kUqNv6o2+G/YoiSIwC2qh76qJw23b8oszfs5kxBSAw9pgGcOER/+" +
                                                              "zYgtpY0MlWRF1lXdkAYtA/VHg3LMoTb0EzBqGtIo+P+2a5bHbpRsI2uBQ0qG" +
                                                              "lZJk8Io0FYOSPZZKUV1Kwk5JTB7VKODVGOiWor2GlZHZ8hg6n/n/mTaHuzF9" +
                                                              "PBIBQ10dhgkNImy1oSWoNaIczK7sufTEyMvCBTFsnH1k5FqYOybmjvG5Y2Lu" +
                                                              "GM4d43PHQnOTSIRPeRWuQfgFWHUb4AMAdMPioS+t2bK3vQIc0hyvBJMg6aKC" +
                                                              "hNXtAYmL/iPK0ZPrJ197pf6xKIkC1oxCwvKyRmcga4ikZxkKTQBslcofLoZK" +
                                                              "pTNG0XWQE4fG79q0+9N8Hf5EgAKrAMOQfRDhOz9FZxgAislt3HPuwycf3GV4" +
                                                              "UBDILG5CLOBEhGkPGzis/IiyZL58bOS5XZ1RUgmwBVDNZAgtQMG54TkCSNPl" +
                                                              "ojbqUgsKJ9HOGg65UFvP0pYx7r3hntfM+1eBiae58dfhxCL/xtFWE9uZwlPR" +
                                                              "Z0Ja8Kzw+SHz8Buvvn8d3243gTT6Mv8QZV0+0EJhLRyemj0X3GBRCnR/PjR4" +
                                                              "4IELezZz/wOKjmITdmLbDWAFJoRt/tqL20+ffevI61HPZxmpMy2DQQjTRC6v" +
                                                              "Jw6RqWX0RFf3lgS4p4EEdJzOjTo4pppUMaAwTv7ZuHD5sQ/2NwlX0OCN60nL" +
                                                              "Li/Ae/+pleTOl2+fnMvFRBTMu962eWQCzKd7kldYlrwD15G769Sch16QD0Na" +
                                                              "ACi21Z2Uo2vECV1cVBskCc6pGrH1EHdGZoUCqGX3Ak5zw17PySTeXlfIPN1l" +
                                                              "7hvoySnUxAVxvs9i02n7gycYn77iakS57/WLUzddPH6Jqxqszvy+0i+bXcI9" +
                                                              "sVmYA/Ezw0C1WrbTQHf9iXW3NWknPgaJwyCRKzVgAWLmAp7lUFfVvPn8L1u3" +
                                                              "nKwg0V5SrxlyolfmQUrqIDqonQawzZlfuEV4xngtNE3Yy5H8xhC+McIx5xU3" +
                                                              "c0/GZNwwO5+Z+eObvjfxFndK4YKzOXvUxqIwjKe8sveg4IMz33z355PfqRF1" +
                                                              "weLS+Bfia/vHgDZ69zsfFWwyR74iNUuIf1g6+vCs7pvPc34PgpC7I1eYpQCk" +
                                                              "Pd5rH8v8Ldpe/esoqRkmTYpTRW+StSwG9jBUjrZbWkOlHRgPVoGi5OnKQ+zV" +
                                                              "YfjzTRsGPy87Qh+psT81hHdYdpDZ8MxzcGBeGO8ihHfWcpZFvF2MzTIXXmpM" +
                                                              "S4XTFg2By5QyQhmpT2k7zHS3kYXDBUaNzwnwmDaUHbXZoKVmACXHnCLyydbJ" +
                                                              "7b+q2XmrWyAWYxGUa+3+1362+r0RjsK1mHw3uOr70uoKK+VLAU1i9Z/AJwLP" +
                                                              "v/HBVeMLUY61dDs14fx8UWiaGJRlfDKkgrSr5ey2h889LlQIO2CImO49uO+T" +
                                                              "2P6DAlfFyaKjoLj384jThVAHm424ugXlZuEcve89uevZ7+/aI1bVEqyTe+AY" +
                                                              "+Pgf/vXb2KG/vFSk6KpQndOhHy2x2A5ZR6hUvfzw33ff88YApPU+UpvV1e1Z" +
                                                              "2pcIumqNnR31mcs7s3ju6yiHpmEksgSsIJIytl3YxIUv3lwSwnoKA2C+46vz" +
                                                              "SwSAqBcWYbOu0NNLcTNSyz29L2GHwS7vtDyDiQ366fT3f/TSlprTwhTFwyJ0" +
                                                              "tnrnjpe/bfzpfBRZcMqhYC3TDI+zC+KbEfW/WuDj+V8eZ1KKGhkQwdJxqqdY" +
                                                              "2j1N/O8mQ2dfWDoUfbs88d2OV3dPdLzNs2WtagOIAhgUOfv6eC4ePXv+1NQ5" +
                                                              "T/CKtBIxxXHQ4KVB4Z1A4KjPLdSITYZ3NxStNHoEgeN4rDjyRhmpNrOjmgql" +
                                                              "UlVS1WWNS9wIrzW+KfhrGBvLSbo4TdRJvIGCBlMNnPMNnWJJ5o5d5RY7+TsW" +
                                                              "GMwVCfYFBSm8n6vs5cMbT01WnLm/raHwNITS5pY46ywpbczwBC/c/ddZG25O" +
                                                              "b7mCY868kK3DIh/tP/rSqkXK/VF+QSPSb8HFTpCpK4hk9RZlWUsPYle7Z3yr" +
                                                              "RErF7rgwZqgcdasu/L23zNg+bL4KfqGgUYUPlCG/l/tZt6+8i3grkcPgmiwD" +
                                                              "rjkPJO/J4xD/VJPQ/Yb/rOGVhASjeE6pKyiero7cfXAiMfDIchfwboMTDjPM" +
                                                              "azQ6RrVAdYn9O/PLaETxbfAsdZaxNIz0nqIhDfjK6suwltncw2XGvoXNIVh/" +
                                                              "ijJxJeGBAt/rhy6XyAK1OLdiKa0lZ+nSlWtdirX4YYmrwKU+Wkb1H2BzBFQH" +
                                                              "6EqswhQZUv2RK1c9B+en0A0Pnk/aCu6dxV2p8sREY+3MiY1/FJju3mc2QM2Y" +
                                                              "zGqav3z29atNiyZVrkODKKZF+fE0I+2Xv4GCmGR5kP2h4DwGdX05TkYq8cvP" +
                                                              "8gwjM0uwAP6Ljp/+WUaawvSwFP7tpzsOlblHB6JEx0/yPBR9QILdX5hurlh6" +
                                                              "BXdvuUgw3vMWn3E5i/sgoiOQG/j/Dy6OZ8U/EHBgmFiz7o5Ln3lEXMYomrxz" +
                                                              "J0qZAjlZ3Avlc8GCktJcWdWrF3887am6hS7oNIsFe7Ez2+fb3RAFJnrerNA1" +
                                                              "hd2Zv604feSm46/srT4FNchmEpEhFW8uPPflzCwkqs3xYtU0ZEp+g9JV/+6W" +
                                                              "1z56M9LCj9dEpOS55ThGlAPHzwwmTfMbUVLXR6ogAGmOH0pv3aGvp8qYFSjO" +
                                                              "q0fhlJYvcKZhmMj43wTfGWdDp+bf4mUeRELhOaXwgrNeM8aptRKl8/wYyp5Z" +
                                                              "0/SP8p3dwrNiDnca3HAk3m+azgGt5hzfedPkUPB7nrn+A0HIAFFkHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ez7QhYRxm6NqjLl0alQEEPeZvfNs3ZnNgy3V23ruTE5zydbjvlDLQDI+6WPi" +
       "rk42M7MLjxUqq2dzTKkghDRJ02kdlmBtukrWejZwVbom0vl0mcyzLZWuaa0Z" +
       "JppRo8Y5huVYvc7oWxDuqTbi4I5uyUhCGj0Jb+WhPlikO7ZRsybzmNKrBg4n" +
       "3bDhJ4yC1RjD7zaoqib6s+6GUesB2UyaI9XXEC30tuzG4UWfZxcwF3Ep0Vp3" +
       "5utAWi02U5tkDUbwCKs+dekZnAuivs55NiSYXbMxM2E/5JtVk1RF1e9JzXGW" +
       "K0RHI6ZNyyT1heJLg2SAjnOeWi6Bi3G1JT8w0M6uPtvNTMfn0U0jJzlsIy57" +
       "nbk8yVM3dXoyWPGWkkcLTru7JN3uaLdTV8PGCt6iSydY7NoLMSPmMozBVQxH" +
       "4aDCrkO66pApFk+DRiX2aLBwjdrzqtWSkPYwHTEJQnYEbTyai3hV7YXVmp41" +
       "5wtLJoasrffojRFwAJR3qNlstkb2jJqC9MmZ1lrxFOZRBu+1bX2wk+m1N1pj" +
       "zdqaN4U26dTQWmwsbSnuK4nWbMVaIjVgRKaqK6G/3fEa3BZhxtCRZLlCaQJJ" +
       "BmCBo/2Zq05NcodmaLsusbg5T/Q8xTBdbzbFts/M4bmfCFUNRIGvULGznbgs" +
       "VnWUsBFi6xjfWaTv9DehwYXUkNpFNiZm1DzB7JRLXY9uo124hic5l3LtbUdZ" +
       "iKtpXJlMRgo/4XY52hqhBJlyjSTq7XrWDMNxncd0hOdsP+BTkx+ku2ElcgN3" +
       "Ddxipee+3mElZbw1xS7G9yg478L0qq8vkEXcW8NCU5OqNE2Ym1mqDrPtVhXR" +
       "dXWCTJvODFX1Rc+b66uw2VTRqYCpjDrKJyG6iGRjSrVNYz7VE1zr1jRmmcDV" +
       "yazOI1066lBZtiRnNVro1KRqu0avmZHKUbwoYZOMiyak1ze0SS3orXcs8J9J" +
       "MF07xtae2wJXXSwmXKtIFBYwrZsB0UlG3Mqr8So7TCii2wHppMuAazEc1r26" +
       "WmfFBsyHC2KcCl1dHHQ4p+niSVhXxiu+Ul24IwcJZDKdUDxX98Uavkv9lZKn" +
       "nS6iIKoqEWh9umo4XbGJNzc01qNMJGKQgNtuljQiDOAZx3CrJjng/a5P18xN" +
       "i5XsxTxkRFtrSNguYPvBoBEYqbQ1FFUOY2SEYvnEgFejGq1vCWMuzhm7SyA2" +
       "EkkRDjctzAg2CmM4VtoL1htmOEWGtayHCENmhogrJJgSgtnm1lof9+mdpQVe" +
       "Q9GXbWus9yjF1NOVN+Z7a2Ys5zOcDYS2KrqtKcKM5D6frfR2qEpyNqHyirul" +
       "zJ6+pvEwTu3IVVJ0SSTeckIJJmKth9lQIzrtCAnMHb7ctenqdKRatFyxJdjl" +
       "7EWkWsGyJopOkNJzeLFZVUm0k3cGMxLvb8PUnEnzBGXpqtLqwJpbaVcYd4PI" +
       "3RhXMwH1myHbF2FsbIlVZDBcx5ijoLMxKubEVk4w4MByNAGrrhBspj2algaw" +
       "3q9QMLpMakTXIdj6hkHNWi8l1GWlzm/EbVNJmKaRrseVOG0z+GjtI/BiLstp" +
       "wqUDphH5eTi1VzbZwYf9rILsmA7bmlEjdVk348A28c5STeK5kWLJeOFi/bqF" +
       "hIZnTWcEskZ6O3wqNedIn+wYzsDKG1595GJ2fzkWPSfI8mFlK7XXtoS1E1tp" +
       "Et1NNFQW6iIYYM1mQ3Zwk2t4EyocaI1+DpbJFcaCtdkNtGDSrpoqKiV4paZr" +
       "nFPDkTDga4OJYjp9v28OFs2YYXQ776abbYhlYjSvSH0fNlpDAYHxRTWv4+PW" +
       "qLtuqX0f5CZ13iTsNkPmaerw+ng1F0ZLFveMNuFMyYqfYDKR+M2tOODW021F" +
       "N+2hmCi0ZDrjdQ1LeZ1YqD0fXuk1Z66x/ZE5lZepEUy0cVP2I5a2m0gq7vy6" +
       "VEE4puljahpMrJ6ryBjZ3mAOLOcGEdXNXNdUZjNnOg0AL3C7QlLtwWBDgu1u" +
       "sQ1+/6vbnj9YnkQcf8sAduVFwztfxQ583/RUUQTHp5Hl7xJ07v33qWPZU684" +
       "oOKM+bHbfaJQni9/+J0vvKhOP1I9uHF0w0TQvZHnf4OtJZp9qqv9SZxzLMbV" +
       "ovtHwAXfEAM+fzp8ouh/90TqI3do+4mi+FEgrKFF+/fTJ8eU5cT+2CsdbZzu" +
       "8XbKITeUQ/53lLtwQjApCX76Dhr+bFG8BDTUgZmI4vT8nIYfezUaZhF09dz7" +
       "/OLN5CM3fWW0/zJG+fiLVy8//OL8D/cn6Udfr9w7gi7rsW2ffhd0qn7JDzTd" +
       "KqW/d/9myC//fjmCnn7l7w0i6GJ0fK77S3vOT0XQG+7EGUF3F3+nWV6OoIdv" +
       "w1IcGZaV0/S/HkHXztMDUcr/03S/GUFXTuhAV/vKaZJPR9BdgKSo/o5/dOII" +
       "v4ovLbILZ6P32NYPvZKtTwX8M2eOucuvzY6OpOP992bPKZ94cTj59i/jH9m/" +
       "+VdsOc+LXi6PoHv2HyEcH2s/ddvejvq6RL7pKw988t43HkHIA3uBT0LklGxP" +
       "3Pode9/xo/KteP6LD//cN/7Ei39Wno3+J/KW+AEGKAAA");
}
