package org.apache.batik.anim.timing;
public abstract class TimeContainer extends org.apache.batik.anim.timing.TimedElement {
    protected java.util.List children = new java.util.LinkedList();
    public void addChild(org.apache.batik.anim.timing.TimedElement e) { if (e ==
                                                                              this) {
                                                                            throw new java.lang.IllegalArgumentException(
                                                                              "recursive datastructure not allowed here!");
                                                                        }
                                                                        children.
                                                                          add(
                                                                            e);
                                                                        e.
                                                                          parent =
                                                                          this;
                                                                        setRoot(
                                                                          e,
                                                                          root);
                                                                        root.
                                                                          fireElementAdded(
                                                                            e);
                                                                        root.
                                                                          currentIntervalWillUpdate(
                                                                            );
    }
    protected void setRoot(org.apache.batik.anim.timing.TimedElement e,
                           org.apache.batik.anim.timing.TimedDocumentRoot root) {
        e.
          root =
          root;
        if (e instanceof org.apache.batik.anim.timing.TimeContainer) {
            org.apache.batik.anim.timing.TimeContainer c =
              (org.apache.batik.anim.timing.TimeContainer)
                e;
            java.util.Iterator it =
              c.
                children.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                org.apache.batik.anim.timing.TimedElement te =
                  (org.apache.batik.anim.timing.TimedElement)
                    it.
                    next(
                      );
                setRoot(
                  te,
                  root);
            }
        }
    }
    public void removeChild(org.apache.batik.anim.timing.TimedElement e) {
        children.
          remove(
            e);
        e.
          parent =
          null;
        setRoot(
          e,
          null);
        root.
          fireElementRemoved(
            e);
        root.
          currentIntervalWillUpdate(
            );
    }
    public org.apache.batik.anim.timing.TimedElement[] getChildren() {
        return (org.apache.batik.anim.timing.TimedElement[])
                 children.
                 toArray(
                   new org.apache.batik.anim.timing.TimedElement[0]);
    }
    protected float sampleAt(float parentSimpleTime,
                             boolean hyperlinking) {
        super.
          sampleAt(
            parentSimpleTime,
            hyperlinking);
        return sampleChildren(
                 parentSimpleTime,
                 hyperlinking);
    }
    protected float sampleChildren(float parentSimpleTime,
                                   boolean hyperlinking) {
        float mint =
          java.lang.Float.
            POSITIVE_INFINITY;
        java.util.Iterator i =
          children.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimedElement e =
              (org.apache.batik.anim.timing.TimedElement)
                i.
                next(
                  );
            float t =
              e.
              sampleAt(
                parentSimpleTime,
                hyperlinking);
            if (t <
                  mint) {
                mint =
                  t;
            }
        }
        return mint;
    }
    protected void reset(boolean clearCurrentBegin) {
        super.
          reset(
            clearCurrentBegin);
        java.util.Iterator i =
          children.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimedElement e =
              (org.apache.batik.anim.timing.TimedElement)
                i.
                next(
                  );
            e.
              reset(
                clearCurrentBegin);
        }
    }
    protected boolean isConstantAnimation() {
        return false;
    }
    public abstract float getDefaultBegin(org.apache.batik.anim.timing.TimedElement child);
    public TimeContainer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze3AV1Rk/9ybkBXkQTKDIyxCs4XFvqQra2FYIr+gNxASZ" +
       "NqjJZu+5ycLe3WX33OQSjQgzVsq0jkV8tEr+UHzAoDhtHR+tlI5tlbHKgLZV" +
       "acXHTNUiM9KOxmpb+33n7N593EfKYM3MnrvZPd855/u+3/f7vnN2/ykyzjJJ" +
       "gyFpcSnCNhvUirTjfbtkWjTeokqWtRaedss73rp9y+jL5VvDpKSLVPVLVpss" +
       "WXSFQtW41UWmK5rFJE2m1mpK4yjRblKLmgMSU3Sti9QpVmvSUBVZYW16nGKH" +
       "dZIZIxMlxkylN8Voqz0AIzNjfDVRvprokmCH5hiZIOvGZldgqk+gxfMO+ybd" +
       "+SxGamIbpAEpmmKKGo0pFmtOm2Seoaub+1SdRWiaRTaoF9uGuCJ2cZYZGh6r" +
       "/viz2/pruBkmSZqmM66i1UEtXR2g8Ripdp8uV2nS2kRuJEUxMt7TmZHGmDNp" +
       "FCaNwqSOvm4vWH0l1VLJFp2rw5yRSgwZF8TIef5BDMmUkvYw7XzNMEIZs3Xn" +
       "wqDtrIy2jrsDKt4xL7rrrutqflpEqrtItaJ14nJkWASDSbrAoDTZS01rSTxO" +
       "411kogYO76SmIqnKkO3tWkvp0ySWAgg4ZsGHKYOafE7XVuBJ0M1MyUw3M+ol" +
       "OKjs/8YlVKkPdK13dRUarsDnoGCFAgszExJgzxYp3qhocY4jv0RGx8YroQOI" +
       "liYp69czUxVrEjwgtQIiqqT1RTsBfFofdB2nAwRNjrU8g6KtDUneKPXRbkam" +
       "BPu1i1fQq5wbAkUYqQt24yOBl6YGvOTxz6nVl916vbZKC5MQrDlOZRXXPx6E" +
       "ZgSEOmiCmhTiQAhOmBu7U6p/ZnuYEOhcF+gs+jxxw+nL58849Lzoc26OPmt6" +
       "N1CZdct7equOTmtpurQIl1Fm6JaCzvdpzqOs3X7TnDaAaeozI+LLiPPyUMfv" +
       "vnvTPnoyTCpaSYmsq6kk4GiirCcNRaXmSqpRU2I03krKqRZv4e9bSSncxxSN" +
       "iqdrEgmLslZSrPJHJTr/H0yUgCHQRBVwr2gJ3bk3JNbP79MGIaQGLlIH10wi" +
       "/vgvIxuj/XqSRiVZ0hRNj7abOuqPDuWcQy24j8NbQ4/2Av43LlgYWRy19JQJ" +
       "gIzqZl9UAlT0U/EyCoNAiCpJQFV0rZKkGFYSrNeMIOiML3e6NGo/aTAUAsdM" +
       "C9KCChG1Slfj1OyWd6WWLj/9aPcLAnIYJrbdGJkLc0bEnBE+ZwTnjIg5I745" +
       "SSjEpzoH5xb+B+9tBB4AIp7Q1HntFT3bG4oAeMZgMZgeu56flZhaXMJwWL5b" +
       "3n+0Y/TIixX7wiQMnNILicnNDo2+7CCSm6nLNA70lC9POFwZzZ8Zcq6DHLp7" +
       "cOu6LV/j6/ASPg44DrgKxduRpjNTNAYDPde41be89/GBO4d1N+R9GcRJfFmS" +
       "yCQNQccGle+W586SHu9+ZrgxTIqBnmTHX4zMCM7hY5Rmh51RlzJQOKGbSUnF" +
       "Vw6lVrB+Ux90n3DETcSmToAP4RBYICf2b3Yau1996f0LuSWdHFDtSd6dlDV7" +
       "eAcHq+UMM9FF11qTUuj3l7vbb7/j1C3rObSgx+xcEzZi2wJ8A94BC978/KbX" +
       "Tryx55WwC0cGiTfVCzVMmutyzufwF4LrP3ghV+ADwRm1LTZxzcowl4Ezn++u" +
       "DThMhcBGcDRerQH4lIQi9aoUY+Ff1XMWPv7BrTXC3So8cdAyf+wB3OdfWUpu" +
       "euG60Rl8mJCMOdS1n9tNEPMkd+QlpiltxnWktx6b/uPnpN1A8UCrljJEOVMS" +
       "bg/CHXgRt0WUtxcG3i3CptHyYtwfRp5ap1u+7ZUPK9d9ePA0X62/WPL6vU0y" +
       "mgWKhBdgskuJ3fiYG9/WG9hOTsMaJgdJZ5Vk9cNgFx1afU2NeugzmLYLppWB" +
       "Rq01JrBe2gclu/e40td//Wx9z9EiEl5BKlRdiq+QeMCRckA6tfqBMNPGty8X" +
       "6xgsc/JKmmRZCI0+M7c7lycNxh0w9OTkn1/20MgbHIUCdudmuHFWFjfyatwN" +
       "6w+O3/POr0bvLxW5vCk/lwXkpny6Ru3d9vYnWZ7gLJajzgjId0X33zu15Vsn" +
       "ubxLJyg9O52daYBwXdmv70t+FG4o+W2YlHaRGtmufNdJagojuQuqPcsph6E6" +
       "9r33V26iTGnO0OW0IJV5pg0SmZvh4B57431lAHVV6MUoXI026hqDqAsRfrOK" +
       "i8zh7QXYzHP4pNwwdQarpPF0ZlgOjsoCwzJSJvcrahxoGBHkBQFurTpTvRbr" +
       "kAZ5wdgt/6Dh5q1fLT29SGBgVs7entrywtFF1bP2PayJ7o25B/dXlW9f/8J9" +
       "+p9Php2KMZeI6Hml1Xbk6VXvdnNOL8MsvdaxrSf/LjH7PLmixm/vWrj22obZ" +
       "K7h2w/+1YIrjFo5qzCnPvsTZkLXOzYpx17WPP/3g4u3zv3OfMPx5ecLb7f/U" +
       "VW8e3T10YL/IKmh+Rubl24Zm732xlphToB5yQfTRym8cev+dddeG7TxQhc1a" +
       "AfEpjFR5mViktmsy7BjK0Ft9EEli8JKFu/+55XuvroFapZWUpTRlU4q2xv0x" +
       "W2qlej3QcjdcbhzXYLMgjSmbkdBcw7DLEWwXY9Mq1tuci8vTuSM6jLfzIT4l" +
       "gLwJecGNav5XXSBFebidoOOn59v/8b3rnm27RuJrHlgoXF/r31Mt11LJR/74" +
       "799H7n7zcI6CvZzpxgKVDlDVM2e5hQgKYq2Nb49dcl58bLTo+M4pE7LLbBxp" +
       "Rp4iem5+0AQneG7b36au/VZ/zxnUzzMDhgoOubdt/+GV58s7w3yHL3JB1smA" +
       "X6jZj6YKk7KUqfnx05Bx7Xh02QVwNdmubQrmARdZ2UmAQybA/hUFBguUW064" +
       "2KHVNOZmzGEYvqh0geLtBmxMBHM83oL5xipYQrSbMAdTBuwojQ7Xnth473uP" +
       "CIAG64VAZ7p9147PI7fuEmAVhzezs85PvDLiAMcbyJaXAXPMwiVWvHtg+BcP" +
       "D9/iENMGRooHdCXuRr1VIOqzKzh8cDl/rPnT1FK4LrE9eEkBOGBzZXbqzyca" +
       "cFfYZZ3NDgIiYyNgmS6nEAIdui5g8MMCMPgRNtsZUCrlAvjvVtde3z9re/Hw" +
       "mQfXSlvplWPYK5UdLPlEcwcLtxcf9Z4Ciu/G5k5Gxps0qQ9QHgIB5e86a+Wn" +
       "4qs5cHXYGnScufL5RAvo9lCBd3uxuQ/07qOsxa0zc1eOfKcogvipSe//7HBP" +
       "6WtObF3l9/DkQkpaBSsLzyQjD85+acvI7Lf4Zq1MsSDNQLmY47jUI/Ph/hMn" +
       "j1VOf5QfbvCyxy4L/OfM2cfIvtNhrlM1No9kCpn/nW0NwyC5YNiTdtF0/1mj" +
       "iRca0+CSbUPLY6ApB/XkE81NPVa+PUKA4Q/Uj276TenQMgccHTZp48+Nnvtt" +
       "DDdiusQKGOuZ/LKlvbquUknLLc1n/mUB6B/G5glIeZaUNFS6hJPdQddDT34x" +
       "HmqAS7XNrJ65h/KJ5k8OB7F5lg/9cgH1/4DNS1CfC/Wd4A8Y4cgXkyGx17Ct" +
       "yfCZGyGfaH7GF/qfKKD/W9i8DgjEL5fBRHf8rNWux1dYzu2w177jzNXOJ1pA" +
       "q5MF3p3C5q+MTHIPVZYAg0nOgeqzrv7vfjG5DvXfaSuxs4D+ubdW2CQCxfKk" +
       "AiOOlf8/KWCbT7H5OyPVkAeX0YSUUtlS2qcEw+EfZ26XNCOVvu8ieBI4Jeur" +
       "rPiSKD86Ul02eeTqP4n05XztmxAjZYmUqnoPqjz3JYZJEwrXY4I4tuL721CI" +
       "kWmFkhYjJeIGlx4iQqiYkbqcQlA944+3bykjNcG+EFH819uvgpEKtx9MK268" +
       "XSoZKYIueFtlCJ+F/LvkjBPqxnKCZ2M921do8E/mTvJKtdsnJQdGrlh9/elF" +
       "D4iPD7IqDQ3hKOOhJhCfODK7z/PyjuaMVbKq6bOqx8rnOKnP9/HDuzaODYAn" +
       "/1AwNXAabzVmDuVf23PZwRe3lxyDGmg9CUkQveuzjz3TRgq2xutjuc5QoGji" +
       "HwqaK97pOfLJ66FafrpMxKnLjEIS3fLtB4+3JwzjJ2FS3krGwZaKpvmZ7LLN" +
       "WgeVB0zfkUxJr57SMgVWFWJXws/p3DK2QSszT/G7FCMN2fu+7G91Fao+SM2l" +
       "ODoOUxnYr6cMw/uWW7YbmwVptDTgqjvWZhjO55pzuOWhREOozcR/ev4L4WAu" +
       "UhcjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/LmbcPbEeag5Nex5oDlZAkC+oC7yV85hy4OFlguFXz/CluvnseUCVGbeXTZ5" +
       "R5leL5K/d+zKl4PQjwGXulb2fSOGLqkry9EAAoIJe8erTNhE3pbh0vPqr4+/" +
       "+sVP5p99ee+iigziAajyapH3rcF/gd7vvMMKdBKT/WX377/y5386+5GDI6e6" +
       "76wWHr6TFkrSR2LowdMOsgeT4R59ixQtEmpPXH9V+36uVFN2AejuntohcVgt" +
       "3rnb6/euIvvdAC+jMsAHLQzLk51jTT9mO+r1Y4ScgYAfGPh12yGO2b1WsluY" +
       "0uE+Sj7H642/Na9gKh886YzxQcD9M3/2kS/87LNfAfM2gO5JC+MFU3FqxFFS" +
       "fIP8w5c/9uR9L371Z0r4BwbDf7x97d1Fr9KdJC4SoUjEY1EfL0QVyhiKkaOY" +
       "LVFa10pp74gLfAjCnNhKjwJs+IWHv7L+ha/98j54Pg8C54j1D774ob85/PCL" +
       "B6c+WZ695avhdJv9Z0vJ9ANHGj7tBLcZpWzR+W+ffeFf//MXPrDn6uGzAXgb" +
       "fF/+8h/99RcOP/HV37tNdHe347+BiY2vBT0s6lPHfwwi6Sg1QyZrmNwp6+Zi" +
       "PRaHrf4uoyNs0Uk341CudZb9sGKOMkqQRht7ICUVfKcyOjpfoCg3Fuyxmc+i" +
       "TdVezxpxO6xMeznlt1Zxb1KJnT4eO0pvaDLSTFYXPXE0tVhyyGVuoFRQ1CNG" +
       "OIm2jeGSRVkvTCVea+A4nFRQ2CBSb1SDd+tdbg8G5q4TqIJHj1bp1ApF21Di" +
       "9dwWdX+9mccTWdeiiEDDgNxVbAafpa1gKDAzfsbMgiiaL4TOOJ5jyHTuDvGw" +
       "M2jXXMQNhtjOnijOkHFNVpiiQmyR42DmpsK0OZOWc6TudYc9TepL/Yx1svXO" +
       "GTVm/iavUv18ZBut2SQFSLh26R6+sqQ+l3YlRzM364qZGSxX2SlaRci6sttX" +
       "AqoduO5w2PWrQceNObcm6L6cKBVE0CZzS56Ist8hk25CD2qqtJS6q3oIp1Ze" +
       "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" +
       "/WxdOBvo31T/w6+l/lPfBs+eWT7LW8DH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0XfCH92E+OxLg9F7v1X/xf1NLdWR87zo5RJY6faXxo5WuvO3Kk73dtzXxd6N" +
       "7zz4ucvvPP7aeHDP8IkBn+Lt6dtfhWq7QVxeXsr/5WO/+n3/7KUvl0f4/w/o" +
       "mqspni0AAA==");
}
