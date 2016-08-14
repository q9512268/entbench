package org.apache.batik.svggen.font.table;
public class DirectoryEntry {
    private int tag;
    private int checksum;
    private int offset;
    private int length;
    private org.apache.batik.svggen.font.table.Table table = null;
    protected DirectoryEntry(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        tag =
          raf.
            readInt(
              );
        checksum =
          raf.
            readInt(
              );
        offset =
          raf.
            readInt(
              );
        length =
          raf.
            readInt(
              );
    }
    public int getChecksum() { return checksum; }
    public int getLength() { return length; }
    public int getOffset() { return offset; }
    public int getTag() { return tag; }
    public java.lang.String toString() { return new java.lang.StringBuffer(
                                           ).
                                           append(
                                             (char)
                                               (tag >>
                                                  24 &
                                                  255)).
                                           append(
                                             (char)
                                               (tag >>
                                                  16 &
                                                  255)).
                                           append(
                                             (char)
                                               (tag >>
                                                  8 &
                                                  255)).
                                           append(
                                             (char)
                                               (tag &
                                                  255)).
                                           append(
                                             ", offset: ").
                                           append(
                                             offset).
                                           append(
                                             ", length: ").
                                           append(
                                             length).
                                           append(
                                             ", checksum: 0x").
                                           append(
                                             java.lang.Integer.
                                               toHexString(
                                                 checksum)).
                                           toString(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwUxxUfnz/xN+b7ywZjSPnIXQihCJmSgLHB9IwtTIhq" +
                                                              "Gsze3tx58d7usjtnn0loE6QUWqmIEgKkSmj/ICVFENKPqE3bIKqoIRFJpSQ0" +
                                                              "NKkgUVM1tClqUNW0Cm3T92Z2bz/Od9RV6Uk7tzfz3sx7b9783ntzp66RUssk" +
                                                              "jVRjYTZiUCvcrrEeybRovE2VLGsz9PXLR4qlv2y7unFFiJT1kdoByeqSJYt2" +
                                                              "KFSNW31klqJZTNJkam2kNI4cPSa1qDkkMUXX+sgkxepMGaoiK6xLj1Mk2CKZ" +
                                                              "UTJeYsxUYmlGO+0JGJkVBUkiXJLI6uBwa5RUy7ox4pJP9ZC3eUaQMuWuZTFS" +
                                                              "H90hDUmRNFPUSFSxWGvGJIsMXR1JqjoL0wwL71CX2SbYEF2WY4LmZ+s+vnFg" +
                                                              "oJ6bYIKkaTrj6lmbqKWrQzQeJXVub7tKU9ZO8iVSHCVVHmJGWqLOohFYNAKL" +
                                                              "Otq6VCB9DdXSqTadq8OcmcoMGQViZI5/EkMypZQ9TQ+XGWaoYLbunBm0nZ3V" +
                                                              "VmiZo+JjiyKHjmyr/34xqesjdYrWi+LIIASDRfrAoDQVo6a1Oh6n8T4yXoPN" +
                                                              "7qWmIqnKLnunGywlqUksDdvvmAU70wY1+ZqurWAfQTczLTPdzKqX4A5l/ypN" +
                                                              "qFISdJ3s6io07MB+ULBSAcHMhAR+Z7OUDCpanJGmIEdWx5bPAwGwlqcoG9Cz" +
                                                              "S5VoEnSQBuEiqqQlI73geloSSEt1cECTkel5J0VbG5I8KCVpP3pkgK5HDAHV" +
                                                              "OG4IZGFkUpCMzwS7ND2wS579ubZx5f4HtPVaiBSBzHEqqyh/FTA1Bpg20QQ1" +
                                                              "KZwDwVi9MHpYmvzCvhAhQDwpQCxofvTg9XsWN557WdDMGIWmO7aDyqxfPh6r" +
                                                              "fX1m24IVxShGhaFbCm6+T3N+ynrskdaMAQgzOTsjDoadwXObXvrCQyfphyFS" +
                                                              "2UnKZF1Np8CPxst6ylBUaq6jGjUlRuOdZBzV4m18vJOUw3tU0ajo7U4kLMo6" +
                                                              "SYnKu8p0/htMlIAp0ESV8K5oCd15NyQ2wN8zBiGkHB5SDc9MIj78m5F4ZEBP" +
                                                              "0YgkS5qi6ZEeU0f9rQggTgxsOxCJgdcPRiw9bYILRnQzGZHADwaoMzCUTFIt" +
                                                              "ktARoaSYSiNrFZOiw48AxpojYfQ24/+0Tgb1nTBcVARbMTMIBCqcofW6Gqdm" +
                                                              "v3wovab9+jP9F4ST4cGwLcXIElg6LJYO86XDYukwLh3mS4f9S5OiIr7iRBRB" +
                                                              "bDxs2yAAACBw9YLe+zds39dcDB5nDJeAzZG02ReJ2lyUcKC9Xz7TULNrzpUl" +
                                                              "L4ZISZQ0SDJLSyoGltVmEiBLHrRPdXUMYpQbKmZ7QgXGOFOXaRyQKl/IsGep" +
                                                              "0Ieoif2MTPTM4AQyPLKR/GFkVPnJuaPDD2/58h0hEvJHB1yyFIAN2XsQ07PY" +
                                                              "3RJEhdHmrdt79eMzh3frLj74wo0TJXM4UYfmoE8EzdMvL5wtPdf/wu4WbvZx" +
                                                              "gN9MgvMG0NgYXMMHP60OlKMuFaBwQjdTkopDjo0r2YCpD7s93FnH8/eJ4Ba1" +
                                                              "zqFssQ8o/8bRyQa2U4Rzo58FtOCh4nO9xpO//uUflnJzO1GlzpMO9FLW6kEy" +
                                                              "nKyBY9Z41203m5QC3eWjPY8+dm3vVu6zQDF3tAVbsG0DBIMtBDM/8vLOt9+9" +
                                                              "cvxiyPVzRsYZps7gpNB4JqsnDpGaAnrCgvNdkQAMVZgBHaflXg1cVEkoeAbx" +
                                                              "bP2jbt6S5/60v164ggo9jictvvkEbv+0NeShC9v+1sinKZIxGLtmc8kEwk9w" +
                                                              "Z15tmtIIypF5+I1Zj5+XnoRYAfhsKbsoh9wi+7ijUFMhcnBORQ9vkrS4nlot" +
                                                              "A85ZHQDefGOXcbI7eHtXLvMEh7mzuz0jUwMF4nwrsJlneQ+P/3x6Mq5++cDF" +
                                                              "j2q2fHT2OlfVn7J5faVLMlqFe2IzPwPTTwmC23rJGgC6u85t/GK9eu4GzNgH" +
                                                              "M3Kluk0A2YzPs2zq0vJ3fv7i5O2vF5NQB6lUdSneIfFDSsbB6aDWAOBzxrj7" +
                                                              "HuEZwxXQ1ONbhmQNQ7hhSCanA3enafR9b08ZjO/Urh9P+eHKE8eucC81xBwz" +
                                                              "OD/WBzN9qMwTfxcYTr65/FcnvnF4WKQOC/KjYYBv6ifdamzPb/+eY3KOg6Ok" +
                                                              "NQH+vsipJ6a3rfqQ87uAhNwtmdwwB6Du8t55MvXXUHPZL0KkvI/Uy3aivUVS" +
                                                              "03jM+yC5tJzsG5Jx37g/URRZUWsWcGcGwdCzbBAK3fAK70iN7zUB9MPMhL80" +
                                                              "2qjQGES/IsJfujjLbbxdiM3tDtiUG6YCxRgNQE1VgUkZKWYgqC8eY8zrTccs" +
                                                              "iJ1KCqByyE4v7+zZLu9r6fmd2P9pozAIuklPR76+5dKOVzkQV2B03uzo7Im9" +
                                                              "EMU9UaBeiPwpfIrg+Rc+KCp2iDStoc3OFWdnk0X034KOGFAgsrvh3cEnrp4W" +
                                                              "CgS9LkBM9x362qfh/YcEtIqKY25O0u/lEVWHUAeb+1C6OYVW4RwdH5zZ/dOn" +
                                                              "d+8VUjX48+d2KA9Pv/XPV8NH33tllFStWLGrRi9gQnz0741QaO1X6352oKG4" +
                                                              "A+J6J6lIa8rONO2M+72z3ErHPJvlVjKux9qq4cYwUrQQ9kBEZWxXYrNRuN/d" +
                                                              "eTFsnd/np8HTZLtnUx6fF65yGzY9uc6dj5uRCshh5UErncLfWwKCDoxR0Cnw" +
                                                              "zLaXmp1HUK2goPm4mVPMjCam/l+IOcdeaE4eMdMFxczHDWKqVEuKoioo5tAY" +
                                                              "xcTNarYXas4j5oMFxczHzUgpL1KczOEz/0E9sxnbgEa7C2iUyQvCZUY6piqy" +
                                                              "i8H8U0YCdac33XNjMEHImJXvaoDDxfE9h47Fu59agnCBjNsgyWS6cbtKh6ga" +
                                                              "COezfOG8i1+GuLHxcu3B959vSa4ZS32FfY03qaDwdxNA2cL8wBwU5fyeP07f" +
                                                              "vGpg+xhKpaaAlYJTfrfr1Cvr5ssHQ/zmRwTtnBsjP1OrHwwrTcrSpuaHv7nZ" +
                                                              "fa3D/ZoOzyJ7XxcFvdj1J+7CX/G7cGUB1kAq7CR4+PtIgbHHsTnISFWSsjYv" +
                                                              "8rlO/ejNjmnhDBM72g3ev99vianwRGx1ImO3RD7WAtoeLzD2HWy+BUcDLBF1" +
                                                              "Mcu1w7dvpR2W2sosHbsd8rEW0PV7BcZ+gM0pYYduN8S4djh9q+wwCZ7ltjLL" +
                                                              "x26HfKwFdD1bYOwcNs8DOoMdNkvJgBF+cguM0IBjCA+ttiatYzdCPtYCil4o" +
                                                              "MPYaNi9BVsR0ce/tRMh6XjRinRP2DHDTnP9fmCbDSK3/xhBL1ak5f1SIy3X5" +
                                                              "mWN1FVOO3XuJB6bsBXg1hJhEWlW9xZTnvcwwaULhelaL0kpkppcYab55AuDL" +
                                                              "Gd4SnO9AlVeIk5ES/PKyXGZkSh4W8D3x4qV/D2wfpAdR+LeX7n1GKl06mEq8" +
                                                              "eEl+D9UAkODrB8YoGysK2EyRP9vI7vOkm+2zJ0GZ6wvs/F8pJwinxf9S/fKZ" +
                                                              "Yxs2PnD9s0+J2zhZlXbtwlmqoMYQF4PZQD4n72zOXGXrF9yofXbcPCflGS8E" +
                                                              "ds/PDI+Tt0MWZqB7TQ/cU1kt2euqt4+vPPvavrI3oKLaSookRiZszS31M0Ya" +
                                                              "Mqit0dxaCpIefoHWuuCbI6sWJ/78G36ZQkTtNTM/fb988cT9bx6cerwxRKo6" +
                                                              "SSlkczTD7yDWjmibqDxk9pEaxWrPgIgwiyKpvkKtFk+ChMeT28U2Z022F+9y" +
                                                              "wdlza9TcG/BKVR+m5ho9rcVxGij1qtweJ6Hz5UJpwwgwuD2eOj6GzX0Z3A3w" +
                                                              "x/5ol2E4JXxVicHhQA4WrLyTc3/CX7G58W8GYVV2sR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
