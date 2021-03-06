package org.apache.batik.dom.svg;
public interface SVGSVGContext extends org.apache.batik.dom.svg.SVGContext {
    java.util.List getIntersectionList(org.w3c.dom.svg.SVGRect svgRect, org.w3c.dom.Element end);
    java.util.List getEnclosureList(org.w3c.dom.svg.SVGRect rect, org.w3c.dom.Element end);
    boolean checkIntersection(org.w3c.dom.Element element, org.w3c.dom.svg.SVGRect rect);
    boolean checkEnclosure(org.w3c.dom.Element element, org.w3c.dom.svg.SVGRect rect);
    void deselectAll();
    int suspendRedraw(int max_wait_milliseconds);
    boolean unsuspendRedraw(int suspend_handle_id);
    void unsuspendRedrawAll();
    void forceRedraw();
    void pauseAnimations();
    void unpauseAnimations();
    boolean animationsPaused();
    float getCurrentTime();
    void setCurrentTime(float t);
    java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    long jlc$SourceLastModified$jl7 = 1445630120000L;
    java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfZAUxRXv3eM+uW/gQJDj60AB3S00fp4aj+OA071jc4fE" +
                                          "HMGld6Z3b7jZmWGm9245JIpVKrESYykmmgT+MJiIpWKlpBK1tLDyoZYaC7US" +
                                          "P+JHYlLGGKvkD0NSasx73bM7s3N3a1LsSTF9s92vX/fv9Xu/193zwIek0rHJ" +
                                          "UosaKo3wXRZzInF8j1PbYWq3Th1nM9QmlFv+dMd1J1+u3RsmVUOkcZg6fQp1" +
                                          "2HqN6aozRBZqhsOpoTCnnzEVe8Rt5jB7lHLNNIbIHM3pzVi6pmi8z1QZCmyh" +
                                          "doy0UM5tLZnlrNdVwMmimJhNVMwm2hUU6IyResW0dnkd5hd16Pa1oWzGG8/h" +
                                          "pDm2g47SaJZrejSmObwzZ5PVlqnvSusmj7Acj+zQz3MNcUXsvAlmWPpw0z8/" +
                                          "uW24WZhhFjUMkwuIzgBzTH2UqTHS5NX26Czj7CTfIhUxMtMnzElHLD9oFAaN" +
                                          "wqB5vJ4UzL6BGdlMtyng8LymKkvBCXGypFiJRW2acdXExZxBQw13sYvOgHZx" +
                                          "AW1+uQMQ71wd3f+Da5p/XkGahkiTZgzidBSYBIdBhsCgLJNkttOlqkwdIi0G" +
                                          "LPggszWqa+Puarc6WtqgPAsukDcLVmYtZosxPVvBSgI2O6tw0y7ASwmncn9V" +
                                          "pnSaBqxtHlaJcD3WA8A6DSZmpyj4nttlxohmqMKPinsUMHZcCQLQtTrD+LBZ" +
                                          "GGqGQaGCtEoX0amRjg6C8xlpEK00wQVt4WtTKEVbW1QZoWmW4GReUC4um0Cq" +
                                          "VhgCu3AyJygmNMEqzQ+skm99Puy/5NbdxkYjTEIwZ5UpOs5/JnRqD3QaYClm" +
                                          "M4gD2bF+Vez7tO2JfWFCQHhOQFjK/OLaE5ef1X7sGSmzYBKZTckdTOEJ5VCy" +
                                          "8fjp3SsvqsBp1Fimo+HiFyEXURZ3WzpzFjBNW0EjNkbyjccGfvuN6+9nH4RJ" +
                                          "XS+pUkw9mwE/alHMjKXpzN7ADGZTztReUssMtVu095JqeI9pBpO1m1Iph/Fe" +
                                          "MkMXVVWm+A0mSoEKNFEdvGtGysy/W5QPi/ecRQiphoeE4LGJ/NeBBSfp6LCZ" +
                                          "YVGqUEMzzGjcNhE/LqjgHObAuwqtlhlNgv+PnL0mckHUMbM2OGTUtNNRCl4x" +
                                          "zGRjVDUzUWcUHGvLBvjvBlUEHc768obKIepZY6EQLMjpQTrQIZI2mrrK7ISy" +
                                          "P7u258RDieekq2F4uPbiZAWMF5HjRcR4ERgvAuNFisYjoZAYZjaOK9ccVmwE" +
                                          "Yh/It37l4LYrtu9bWgHOZo3NQHvnRDAuyP+AjoH5ibC/dNA68Orv3j83TMIe" +
                                          "QzT5qH2Q8U6fV6LOVuF/Ld48NtuMgdybd8XvuPPDm7eKSYDEsskG7MCyG7wR" +
                                          "KBao6sZndr729luHXgkXJl7BgZazSchwnNTQJHAaVTgntQVyksBmfw7/QvD8" +
                                          "Bx/EiBXS0Vq7XW9fXHB3y/KZIyTe53GyrJTpXbuj6RZOxSGC/w7dsP+guune" +
                                          "NTLSW4vjsgfSzoO//+z5yF3vPDvJ4tdy0zpbZ6NM982vEYZcMmEj0ScoNp+Q" +
                                          "E8oFL52seOP2efVi6eqTsIfwEnlHUSKX+xDbVJgKmWSqlJ5Pa6umTuLBKTx9" +
                                          "w9/nb75seLuYgj8to65KyCjYM47JtKB9UcCUQZWH+x54dsMK5fawyCPIyZPk" +
                                          "n+JOnX6jwqA2g4RpICysacjhriwQmkFbJJRVi+nRxBN7OsJkBiQWSKacAvlB" +
                                          "nmoPDl6UCzrzUYND1YARUqadoTo25ZNhHR+2zTGvRnBGi3RiWOxa9NnT4Vnt" +
                                          "sqX4i61tFpZzJccI+XZRLsGiQ3hKGF+XY7FCiJ0JnrPCC0ygdx14D1ek4yoD" +
                                          "FltLaTSpM6SMT5uWrzn6j1ubpVPqUJNforO+WIFXf9pacv1z15xsF2pCCm4v" +
                                          "PPLwxGTOmuVp7rJtugvnkdv70sK7n6YHIPtBxnG0cSaSSFjiy0fqXIzUsXMV" +
                                          "f4AOIKW77bP87bhZZAYXFlkrJC4VZRda1iVE/L0Ri4ugcxqyHdKLIyeL03LQ" +
                                          "VX0hiJvtwSzQ0QAdE+GfUL6z9Ma9Z1SfOF/G/eJJpX27jXNPnt+0+P77DCne" +
                                          "Mbny4n3Gn3c/d4/5xw/C+T3EZF2k5JVO34uPbXwvISKxBsmg4P++MO+y0z4f" +
                                          "bC74YCOapBWew64PHpZEuqOsaRSUwKZay8A+MLpZyzDVXad80v4SR0NSXzCB" +
                                          "Yb2lPfrYTy/Yd9bV90jDL5mCET35R7/2zvED40cekMGE5udk9VQHk4mnIdyn" +
                                          "Lp+adn1O9PGGi4+9/+6WbWHXhRux2JTLh0Gjf3MgI/rrBdcPuckP944BT5LK" +
                                          "q9Yc+Pd1N726CTiwl9RkDW1nlvWqxexa7WSTPtfytuCSa4VfCSbKYT6GXcsq" +
                                          "y0Jrd0wBz3dKSyi3vfJRw5aPnjwhzFh8zPPvSfqo1SlZFIuLUf3c4K5oI3WG" +
                                          "Qe4rx/q/2awf+wQ0DoFGBVzF2WTDlixXtINxpSurX3/qV23bj1eQ8HpSp5tU" +
                                          "XU/xQAXbYiBx5gzDbi5nffVyGSRjNVA0CzYhE/gF6W7R5ETak7G4oL7xX859" +
                                          "5JKfHXxLbH6EhnOK08Jp8JzjhuQ5p5QWikkw7El1Y9EjpEZKUGUGixSc+oEq" +
                                          "ewxFNx3InnkX6xddtmGRlq64/X+zEVawAPB6bFoIz4Uu8AunB3iPQC+kxkoA" +
                                          "34UFbANagFmUEX+WcKYi8bgNrMO1UTeqjrSd3Pnr6vF1+ZDtk+EB3VeWuC4p" +
                                          "1hHd0/r2yI//9qDko+DpNCDM9u2/5fPIrfslGckj/LIJp2h/H3mM9wev42e9" +
                                          "SUYRPda/d2TP4/ftuTmPLMJJddI0dUaNIOngz605z0+c8vjJfHguc/3ksmn3" +
                                          "k++W8JPvYbEPGFj4SSFEsPZaD/a3Txm2aGqDZ50Le10ZYfsB3V2i7UdY7Odk" +
                                          "psochrzWpcvzyx7Xe/DPXk5mjJqa6qG/85TRYwcyB55eF31vGdGHfIfD3T4g" +
                                          "AVAVmnuBOMG9hdb7StjtCBY/4aTByToWM9QBptp0DCsPe1Y6VJ7QWABPv2ul" +
                                          "/vJbSUxaCDxaAvDjWDwC2TtrTIDsC4uj5QkLzBqDLuTBaQqL35RoexqLY5y0" +
                                          "BtBCdGDLAQ/wU+XjgatdwFdPE+DjJdpexuJ5Lk69CvOW1of0hfIgRaLf5iLd" +
                                          "Nk1I3yzR9jYWr4IjWzTrsC44W3gXHT60r5UHLV4HJF20yWlC+36Jtg+w+Ats" +
                                          "erJGabx/LQ9XId60izc9TXg/LtF2EouPYHdLC0DjiFsN8NSJU4Zbh03z4NFd" +
                                          "uPr0wA2FSrRVYOWnsFeBzXx31rbhVIwn5C9KfJUpOBFNkfo8G31WnhBYLMwi" +
                                          "/+0so428WYcqhTFaSxhqNhYNYCinyFDFQRBq/P8R52APUHS7j8fFeRO+J8pv" +
                                          "YMpDB5tq5h686g/ibrLwnao+RmpSWV33Hc79B/Uqy2YpTdigXh6WLYFpASfz" +
                                          "prr2hs0NlDjn0Hwp3c7J7MmkQRJKv+QSCJ+gJPiM+OuX6+CkzpPjpEq++EXO" +
                                          "AO0ggq9nWlZOunLhS0bB0+Z8kd19Hz+WFR21xPfd/LEtG3cvcY4cvKJ/94nz" +
                                          "75XfQhSdjo+jlpkxUi1vdYXSigkXQn5teV1VG1d+0vhw7fL80ahFTthz3AU+" +
                                          "+mHgkBZ6wPzA/ajTUbgmfe3QJU++sK/qJTjUbSUhysmsrb6vq/JTYmfOytpk" +
                                          "0dbYZNc7W6gtrm47697d/uK/Xg+1ilsHIi+E2kv1SCh3PPlGPGVZPwyT2l5S" +
                                          "CSc/lhsidZqzbpcxwJRRu+i2qCppZo3Cp+BGdFeK336FZVyDNhRq8Sqek6UT" +
                                          "j6cTv1bU6eYYs9eidlTTELj2z1qWv1VYdkgyGFoafCoR67Ms9zNR5UxhecvC" +
                                          "gAxdJFjsv+Krue7EIQAA");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1445630120000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAAL16e6zk1nkf792VtLuStSvZlmTZ8kNeGZVpX3KGw3lUqeMZ" +
                                          "zpAzHM4MZ8h5MXXWHL7fHL6GQ9dtYqCN2yCOk8iJA9j6Jw6aGkocpAmSoE2h" +
                                          "tGjiIGkAB0bbBKhttEnbPAxEBZIGdZP0kHMfc+9qr2Gs1MHlueQ53znn+32v" +
                                          "c/gdvvxN6IEwgGDfs7ea7UVHShodmTZ+FG19JTyiGZwVg1CRCVsMQx7U3ZGe" +
                                          "/fmbf/mtT+u3DqEHBejNout6kRgZnhtOlNCzE0VmoJtntR1bccIIusWYYiIi" +
                                          "cWTYCGOE0QsM9PBe1wi6zZywgAAWEMACUrCANM+oQKc3KW7sEHkP0Y3CNfQP" +
                                          "oQMGetCXcvYi6D3nB/HFQHSOh2ELBGCEa/nzDIAqOqcB9O5T7DvMdwH+DIy8" +
                                          "+BPfe+sXrkA3Beim4XI5OxJgIgKTCNAjjuKslCBsyrIiC9BjrqLInBIYom1k" +
                                          "Bd8C9HhoaK4YxYFyKqS8MvaVoJjzTHKPSDm2IJYiLziFpxqKLZ88PaDaogaw" +
                                          "PnGGdYeQzOsBwBsGYCxQRUk56XLVMlw5gt51sccpxtt9QAC6PuQoke6dTnXV" +
                                          "FUEF9PhOd7boaggXBYarAdIHvBjMEkFP33PQXNa+KFmiptyJoKcu0rG7JkB1" +
                                          "vRBE3iWC3nqRrBgJaOnpC1ra0883h9/1qY+5Xfew4FlWJDvn/xro9M4LnSaK" +
                                          "qgSKKym7jo+8n/lx8Ylf++QhBAHit14g3tH88j949cMfeOcrX97RvP01aEYr" +
                                          "U5GiO9IXVo9+5R3E840rORvXfC80cuWfQ16YP3vc8kLqA8974nTEvPHopPGV" +
                                          "yW8sv++Lyp8eQjd60IOSZ8cOsKPHJM/xDVsJKMVVAjFS5B50XXFlomjvQQ+B" +
                                          "e8ZwlV3tSFVDJepBV+2i6kGveAYiUsEQuYgeAveGq3on974Y6cV96kMQ9BC4" +
                                          "oANwBdDudzsvIkhDdM9REFESXcP1EDbwcvy5Ql1ZRCIlBPcyaPU9ZAXs3/pg" +
                                          "6aiGhF4cAINEvEBDRGAVurJrRGTPQcIEGNaMAn/HTnWUG5z//2+qNEd9a3Nw" +
                                          "ABTyjovhwAae1PVsWQnuSC/Grc6rP3fntw9P3eNYXhH0PjDf0W6+o2K+IzDf" +
                                          "EZjv6Nx80MFBMc1b8nl3Ogcas4Dvg6j4yPPcR+iPfvLZK8DY/M3VXN5p4YxP" +
                                          "FQ9XQL/n7x2pyTxM9IrQKAHLfer/jOzVJ/7rXxW87gfbfMDD1/COC/0F5OXP" +
                                          "PU186E+L/tdBXIpEYEfA5d950UfPuVXurBdlCMLt2bjlLzp/cfjsg//+EHpI" +
                                          "gG5Jx7F8Jtqxwikgnt4wwpMAD+L9ufbzsWjneC8c+3wEveMiX3vTvnASOHPw" +
                                          "D+zrDtzn1Pn9jcIOHi1oHvtb8DsA19/kV66JvGLnAY8Tx2747lM/9P304CCC" +
                                          "Higf1Y7QvP97ch1fFHDOwN/j/M//59/9Y+wQOjwL5jf3lkcghBf2Akg+2M0i" +
                                          "VDx2ZjJ8oOTC+i+fZX/sM9/8ge8p7AVQvPe1JrydlznHYDUEq8o//vL697/+" +
                                          "tS989fDUxq5EYAWNV7YhgZuwWNwAEtVwRbsQyLMR9KRpS7dPUM/AYgcYu23a" +
                                          "tUJUbwXLe8FarpWj3QpROBTg6PY9zHVvVb8jffqrf/6m2Z//m1fvstTzghmI" +
                                          "/gs7DRVcpWD4Jy96UVcMdUBXeWX492/Zr3wLjCiAESUQD8JRAFw4PSfGY+oH" +
                                          "HvqDX/93T3z0K1egQxK6YXuiTIr5AgzCaKSDNVsH3p/63/3hXRjcXAPFrcI3" +
                                          "oQL/23fsFG796JkgGA8slD/4h5/+nR9+79cBHzT0QJLbMOBgT1rDON87/JOX" +
                                          "P/PMwy9+4wcLnYCgy/5459aH81HrxQTPFeXfyQt4p7H89gN58cG8ODpR09O5" +
                                          "mrgi/jFiGA082QB7B7nQ1KWhgw0MB1hbcrwwIh9//OvW5/7nz+4WvYtx4gKx" +
                                          "8skX/9nfHn3qxcO9rcZ771rt9/vsthsF0286VeV7Lpul6EH+jy99/F/9zMd/" +
                                          "YMfV4+cXzg7YF/7sf/zr3zn67Dd+6zWi81XbOzHKvCwfT5v/w7+9YqObbLcS" +
                                          "9ponP6YkqEJzmk4WCaYM4HiOaGO6bVbRZgvjUFT1K6IJj5porWRKFbXTHVC2" +
                                          "XBWwVc0UnDnlNMoVnO75s37Q4ZZby3E0Hh7QRs+f922/1S9FTHvrCUuRqE05" +
                                          "Fqa7S5uhqH5itdEhJ4ZpDVsNaiE2xMQSE3I82Qgb5WSBqEljESOlBpZteoqF" +
                                          "Bl166oVi38M2i4mQ9VyybpbY1XK+xni95A4aY8cmE1geyCW6BMfYJHRm05El" +
                                          "CVpVHfulcnc9rIpeNmkJaz0c+R5PuG7WmSn1SYSbrZrdZYbD3qrXHWB+NjOq" +
                                          "vmPUs9JYIJytLntbdDrAI0Zw7WAozzYDx3BofTgbbJyyPp1We1uw452jsmvJ" +
                                          "uC6XqqxY8uYZRdUR3W87Za1S40RaCBSTc0arTSbg7MxeuwkXh45Za0omnI0z" +
                                          "bDCUposwadrOnPU3aFZH4nm5Mhd0nTSnA2sT9zKtlfHd8nTNdzl8uChXicys" +
                                          "Ebza06fpIBoAOABFu+GRTXG4WbfwhK5MM6baomR7EG1drc5snb6VtIgFtfVJ" +
                                          "g57My6IkLzqpkLbGmxIWLpOR1hXS5hwIcDwY10obGVPhtoj7yMKiRN0yeEHL" +
                                          "DLnFLVs9uaWHhMbQQyuKRvba2sg9A6UYVtPCbL4WYTYWA6k6j9Ya2wxjqy0x" +
                                          "M2cZCV6YsrOkxWm98qgabdBtrcltHFdyGzPf5cTWOo26tkhLbWzerDerbU5w" +
                                          "/K1ZcaPITj3dWQ/6rOGG00FXkIgxM474oA0zLYGi1tRYpIio4y1Q0ZmYWpWo" +
                                          "p7bf6aPoZjyLKvOI73dmqznQqTd35hVqokyJSuygxHqma0SMNbf0VnOGg846" +
                                          "G8Oh5TQabLxF8OFKTq2lyXd6GwGf+qMQR2h3sm5jY3FJ2M6gorXLKxKeKVkt" +
                                          "GpVpdU4S464+GpNmHxkxYgdX1NKiFlKcky1bfYGXLJkfdWh8RmzrquljXJis" +
                                          "w5ZfIg3Hg7sGue0sphMBm2d+Rpqt4RztmENrtTUliVKTeFiFG263MqEXHOxP" +
                                          "rU3D2XQQ0e4OzP7Cz4a1ZpsS+CwC2MJwEM1itIHTa6XX8Fv+qOSUer6OkMrA" +
                                          "Gixms7kDN1GH8zr9IdmREyqituEWmeNj1kAUaTI2fN1TOhWGopGh0mpxql9l" +
                                          "CGE5o9bTziDLKFMa6h2EWZtad7Rqxpt1ZOv2UEtg1mVQR7K608FqUB5R/DQa" +
                                          "DieEXUkzamLO2tNsOpemXSphWomZtOxppyvVqnVv1e8pvrCsdsbMwPTHfDDu" +
                                          "Cb2yEwT9Wo/bsrW4jNcnbUNRrHWZrMTsyhCa8wGJd82JNKl0JlrSjIekES5N" +
                                          "T2guBVMc9RuSNAMCWupIL8JqdoVZBlHcWM0Bx4KHDcfdxJ20m/GWhZum18WN" +
                                          "FYHIw2a1PgoSzKxj/KCnjDMeX3fL4/q0qs6qzGgWkwgjV+rDKB5o8nYl1xdJ" +
                                          "zLJtp6b0uWW7E4YWVRsQW6q2mfRbolcNBVcOauWGHXcXmrWg7VpLE8SMk/SN" +
                                          "O+THdLcpznjNjcazrRW2HHVTQ8ZJu95KkY7RWnDobF1bzBvqotvCtkhf6G15" +
                                          "BceobUDz/mIVm9WJMEo5ikA2NTlkYS2OXWXIM9y8kpihpnKZN0IQOMO3JJaw" +
                                          "bRARInmLZv5KqA4HjXo56SwFaeB0TJSTvKEPjzt1j2TwcqiM2LKigkCorPmw" +
                                          "p246rt2dcv0FnLZXM1rrO3NubdM4K1Zjh4+ZVp9PG5sG4q5qeKgw8VIz65FX" +
                                          "xftbwlwOKjU66rcaU4mYjoV5F07xihwO+rgqbrYE29sKrOXC9MhdVM3Nugni" +
                                          "5cTvEdtQlEw9MDZjxyJXND2ZGbA7SVvD2iikrZYxnnN9UWomdst1PLZtV6dE" +
                                          "FmTT5bBdWjYn07Uoe7xXxoWh3p3A5YynkonbogxsYsxHqdgYunxlludcFhWj" +
                                          "WopIX8hoSerBC2HChJQxxvQ+RcKLZY0kDBql3YAlCHSryWmp0i4pVmXrtUk7" +
                                          "YkSe8wdVbsDj8TzI3KpZilf+jF1P6aHqBSN43iMXagO8RiWlrISnIVn2CcKp" +
                                          "JCzLbFKKHznxzK8FdBRrCVg9khoa9mtuddntsVErdSlU4kSOI01ji6rrRS+b" +
                                          "hovBTK00R73+vFZbsfXaSheAuS9I2wpoojITJrJYMmbAMdGJUYk1KV1vu3Kf" +
                                          "6W0VBsWY8WyB6gadRBsuG6PjptyBKXXKVLPGQGwIJU4dkQiFKDTtL8o1czFk" +
                                          "3QhGYbZWaxOuMli524qLUS4mIXIFwdMNQsA81hHIsoXTsxGWe+Vik/S4ftoK" +
                                          "Ha3CwvBgBAN7q6grolZZEiPRb82VTbXCdn2hE69HoTjhppu+IG7rTXjA+MI2" +
                                          "a88WolxHkwo3AfuDRUa0lquyzarBkt8iS7mxmjVQs83gDtHhMXxSQ8pZ0mlX" +
                                          "UEmxBlQHj2WrMRt3rYrj9uSty/iwKLulUYOlKKMCNxC4Ol/Nuwt9Eqdlmmd0" +
                                          "lDJVbKD1kCBoyRIbSxbbqFRaPM70142lBLNyaVgDSy1vbOzGxGrPS66dzNep" +
                                          "koq1OcezkbqNYoITKzOV4Fb9JV+lFlK43qJ0IKObVobJfW5rYIlKTza4yLrm" +
                                          "Rs9IvZ6xbMKpa6/E2QLZi5mpikmVPu71sDk1VipBiqyRsrhR4c0YbXsk1Zpl" +
                                          "ZHnOt20jXUS9YepzcbDAkPWsjK3MkjKud33Ox6PpYoqk4+ZitTRaKa5l7ZWB" +
                                          "u6o621LcxBzOmiiRLUHU1sjqvDbBO7xo1aiKx9TSRR0HS0Vf7S5SZtWtdnR3" +
                                          "1EfrtF+nM1OPx7iPj+eGZW1qHbu0bHRMvyP0p9SUMlJOgr3OWtmk5DDFeq5r" +
                                          "LaqpLEcONbHX1QqygMEuS9w02VZ1RXq9rDKN683YbWEGOyZgK7W8JlaZkqvm" +
                                          "UNRIZ9pZwHOpvzTqK20YDEalKa+szYCTMdYNqglZgoV2ZMGdFjZT5jFR8Ut6" +
                                          "V0aRoLztIUhj3bY8uO0PifagEZcRXGV7gRralGSZCNOj/bKOdDFn0NgoSaWs" +
                                          "NLjpcsLKIiKXebaCqFHMOywzoGlZ7qHyVBz2Rq6WVVE8Q2Gpnpi02tViCcGs" +
                                          "0HExC4bndZpNlqsOS5FmBThpJ2QFsY2IGJ86ZZFatwUcZZQSKizVEPBbNmpT" +
                                          "eVkbyZYfepIeZHNfSrJtWlsoSJtdWLhj0muxuqaQOs5Plhtp28JxhcRKCSVT" +
                                          "XbWntjG+ojVnzZnjxq3RgGro8qrGRWYEPASpiHxry3tzsA9u+ZGPtomQVUrL" +
                                          "6oyujefNFpuUYxtJ6BU3TUWinYrNpG3O2xuizEcB32uHYCtk4mOLyVrrNhPz" +
                                          "LXG8ZoB3eUq6Zpb4Fm1FLUKm2kxzjGym8MLUxEjekDLbgdsmLftKGtM4Y1Ub" +
                                          "RDKalzwV1dWeNhEZFTcYeWiVetg2mzTM5Tyo9Mx5xgdgwsoc0xZdvooG+LTL" +
                                          "zCpdmiyj27lNwFiVjjR4AzejUAloSlylCDNuLHpyFTUyqcEvNISJyHLHi9ll" +
                                          "V2YItG0aZDisDzl6WhFWOopllSEpx2yAbpplkgsms+Vo7oak0soWKVYKVvqs" +
                                          "t3FxotFXabCna5FDS/XqFFaau3pryQw2BgKjoVcp1+dLaa3zpMil+nqoL4dL" +
                                          "wnC3ZJscT1prhK1P8HKTnXa5mllXSWUygum6nywHfruFR2tcr9arGmKsAmbj" +
                                          "ih48cXxuPsMwsN9ptJDpelte+rxsaAu9OmeWpN/k1MwPgrIeokO7bbpod+Nj" +
                                          "Uo2uDRxrPKH7CTzmCBrWaNYYwKN4UYUJK/NZ4ItrGO4sRs0Rqmnrhju3hVHs" +
                                          "MjqHrlooLNQtudToZvCcnJRLKavKCNOJKExKpGVFSvo00qi4WQ1fqGOdk00P" +
                                          "Nm3fSqdGKZGXC84Ae5axi0fKrDSjSjKMJvqmpjJ1VNRJPtIzrDmFYaerWS2h" +
                                          "umGzJiKa/HSlOaqCjWnQFPaRNc2bU2B4+jZ0wmBVTdYIzS8ddbSNfAuVV0th" +
                                          "KNXmVS0KnEqt2qjJSNxHFhpcMuyw2zPgTtlKShyhYyxrUyw1E9jNli/bOEdw" +
                                          "EmLroSEL62zlS+mGnkxi2CivCd8H+zvCh8GrD6n0MaxKCrNte6hP1nVurVjV" +
                                          "KW9WJT4praZVZbkMG4oh2zzfYcxyVlrPk9JsKVvaliI9USW8SbU2CBvZcIJP" +
                                          "U12REkJrpjJNmmEC94NYqXV642Yzf7XufWfZjceKJNTpmYVp1/IG9Dt4q08v" +
                                          "mzCCromrMApEKYqg66eHKLvZ97KwBydJr/delvE9TvfmmY1n7nV0UWQ1vvCJ" +
                                          "F1+SRz9dyrMa+cBtMHnk+R+0lUSx96Z9FIz0/ntncAbFyc1ZlvU3P/EnT/Mf" +
                                          "0j9apBnvyv4y0I28J5sfkJ0ehL3rAp8Xh/wXg5d/i3qf9KOH0JXTnOtdZ0rn" +
                                          "O71wPtN6I1CiOHD503xrAD17V9rHkxQ5DpSzed//bvGX7vzax28fQlf3E9H5" +
                                          "CM9cSOs+DPaQjmjnE5wcYt2I9MDbnNXs53iBWK/nlvEOcMHHpxzF/7z1zX5e" +
                                          "viU9s6+7DOfw1FInx2YSQO87Sy8Snm0rUiH121Ow6c6zceLKVvJU//+9+Vzp" +
                                          "l/7sU7d2uSob1Jyo4QPffoCz+re1oO/77e/93+8shjmQ8mPBs4TpGdnurOnN" +
                                          "ZyM3g0Dc5nyk3/97z/zkb4qfvwId9KCroZEpxeHP4Q7fiak/mZv6BpP2LXyS" +
                                          "H8Uct795vz0/8lXcqJCIXlBIRakV7rg71cifi9T2HdBZU6Je7m7hjtmcrXMJ" +
                                          "wfPGPhE3hQfdkX51/I2vfD770ss7Ga7EUIkg+F7nyHcfZecnFc/d26P2Thj/" +
                                          "gvq7r/zxf5t95MRHHz41nwLNtcvM50REj+6nqnfajs+i1ke/XS5yX3hFxfec" +
                                          "N+G3gat8zEP5vkz4vMIOz6iMvLAKqn90iVq/Py+yCLoF1NpxJdsLgTcXOs0b" +
                                          "/LtFdynb8QVBfew+BPVIXvkMuOrHM9bfGEFZhbQKqh+6RFA/nBefBOsaWEAk" +
                                          "a98DCvLv3lvNiAh6aOV5tiK6Z6L4p/criqfB9aFjUXzoDRfF5y4RxUt58RPA" +
                                          "SQpRnFpNXvsjZ4A/ex+Ai8onwNU+Btx+HQHvQ/mZS9q+mBc/FUEPy0qo5KG5" +
                                          "aduvpeuriWfIZ7i/cB+4c1LoreDqHePuvY64D/Y2RBcgXDGOV4BfvkQe/zov" +
                                          "fiGC3hTGoa+48kSRA3GTV/7KGfp/eb9m/nZwDY/RD19/9AW7BcFvXAL1y3nx" +
                                          "6xF0M3bvArtn4v/2fk08D2/cMVjuDTLx37uk7at58R8i6PELOIGl5y0vn0H9" +
                                          "3dfDmxfHUBdvENSvXdL2jbz4/ajYdErKmTr3MP7B/WLMQ/RHjjF+5A3C+CeX" +
                                          "tP1ZXvwRMFtfjEOl6RrO2VvEHs7/fr848x346hjn6g3C+ZeXtP1VXrwK1uLY" +
                                          "vRzp/7rfaJQj1Y6Ram8M0oPDS9qu5pV/DbZn4ilENkcsX4hEf3MfQG/klU+B" +
                                          "yz4Gar9BQB+9pO1WXlwHewqwDyXiIACvJLzhKK+1WIF3SE+MTrEf3Lhfc353" +
                                          "AXf3W7+O2M+WnIPHC5DPXCKAd+XFU0AA4TkBnDfog7d9J1hTsFaf+5wtf618" +
                                          "6q4PaHcffUo/99LNa0++NP1PxYv76YeZ1xnomhrb9v4XWHv3D/qBou52jNd3" +
                                          "7+p+geZ9EfTUvRIuYLsBypzbg+d21M9H0FteixpQgnKf8gPAFS5SAoso/u/T" +
                                          "IRF044wugh7c3eyTlMHogCS/xfIPwgrxPbVvJoVnPf7tJH7aZf+Lrvz9tPig" +
                                          "+SQ7E7PHr8FfeokefuzV6k/vviiTbDHL8lGuMdBDu3RIMWieWnjPPUc7GevB" +
                                          "7vPfevTnrz938qb76I7hM5Pd4+1dr52o6Dh+VKQWsl958he/65+/9LXiq6b/" +
                                          "B0ddmyxpLgAA");
}
