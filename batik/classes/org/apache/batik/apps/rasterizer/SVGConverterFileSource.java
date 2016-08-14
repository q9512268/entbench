package org.apache.batik.apps.rasterizer;
public class SVGConverterFileSource implements org.apache.batik.apps.rasterizer.SVGConverterSource {
    java.io.File file;
    java.lang.String ref;
    public SVGConverterFileSource(java.io.File file) { super();
                                                       this.file = file; }
    public SVGConverterFileSource(java.io.File file, java.lang.String ref) {
        super(
          );
        this.
          file =
          file;
        this.
          ref =
          ref;
    }
    public java.lang.String getName() { java.lang.String name = file.getName(
                                                                       );
                                        if (ref != null && !"".equals(ref)) {
                                            name +=
                                              '#' +
                                              ref;
                                        }
                                        return name; }
    public java.io.File getFile() { return file; }
    public java.lang.String toString() { return getName(); }
    public java.lang.String getURI() { try { java.lang.String uri = file.
                                               toURL(
                                                 ).
                                               toString(
                                                 );
                                             if (ref != null && !"".equals(
                                                                      ref)) {
                                                 uri +=
                                                   '#' +
                                                   ref;
                                             }
                                             return uri; }
                                       catch (java.net.MalformedURLException e) {
                                           throw new java.lang.Error(
                                             e.
                                               getMessage(
                                                 ));
                                       } }
    public boolean equals(java.lang.Object o) { if (o == null || !(o instanceof org.apache.batik.apps.rasterizer.SVGConverterFileSource)) {
                                                    return false;
                                                }
                                                return file.
                                                  equals(
                                                    ((org.apache.batik.apps.rasterizer.SVGConverterFileSource)
                                                       o).
                                                      file);
    }
    public int hashCode() { return file.hashCode(
                                          ); }
    public java.io.InputStream openStream() throws java.io.FileNotFoundException {
        return new java.io.FileInputStream(
          file);
    }
    public boolean isSameAs(java.lang.String srcStr) {
        if (file.
              toString(
                ).
              equals(
                srcStr)) {
            return true;
        }
        return false;
    }
    public boolean isReadable() { return file.
                                    canRead(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZbXBU1fXuhnyHfEEAgQQIgTaou+IHjkapEBJIugmZBDLj" +
       "ooa7b+8mD96+93jvbrJgadW2I3WmDlIU21F+dHCwFMVpy2g/ZGiZVq3WqUpr" +
       "rfVjbGdqq0xlnNpWW+05977d9/btB5OO6c68u2/vPefc833OvXv8HCm3LdLG" +
       "dB7iu01mh3p0PkQtm8W7NWrbW2BuTDlURt+/5e3Ba4KkIkrqJ6g9oFCb9apM" +
       "i9tR0qrqNqe6wuxBxuKIMWQxm1mTlKuGHiUtqt2XNDVVUfmAEWcIMEqtCGmi" +
       "nFtqLMVZn0OAk9YIcBIWnITX+Ze7IqROMczdLvgCD3i3ZwUhk+5eNieNkR10" +
       "koZTXNXCEdXmXWmLXGwa2u5xzeAhluahHdpVjgr6I1flqaD9sYYPPto/0ShU" +
       "MIfqusGFePYwsw1tksUjpMGd7dFY0t5FvkjKIqTWA8xJRySzaRg2DcOmGWld" +
       "KOB+NtNTyW5DiMMzlCpMBRniZFkuEZNaNOmQGRI8A4Uq7sgukEHapVlppZR5" +
       "It57cfjgoVsav1dGGqKkQdVHkB0FmOCwSRQUypIxZtnr4nEWj5ImHYw9wiyV" +
       "auoex9LNtjquU54C82fUgpMpk1liT1dXYEeQzUop3LCy4iWEQzm/yhMaHQdZ" +
       "57mySgl7cR4ErFGBMStBwe8clFk7VT3OyRI/RlbGjs8DAKBWJhmfMLJbzdIp" +
       "TJBm6SIa1cfDI+B6+jiAlhvggBYnC4sSRV2bVNlJx9kYeqQPbkguAVS1UASi" +
       "cNLiBxOUwEoLfVby2Ofc4HV336pv0oMkADzHmaIh/7WA1OZDGmYJZjGIA4lY" +
       "typyH5335L4gIQDc4gOWMI9/4fwNl7SdflrCLCoAszm2gyl8TDkSq39hcXfn" +
       "NWXIRpVp2CoaP0dyEWVDzkpX2oQMMy9LERdDmcXTw7+48bZj7J0gqekjFYqh" +
       "pZLgR02KkTRVjVkbmc4sylm8j1QzPd4t1vtIJbxHVJ3J2c2JhM14H5mliakK" +
       "Q/wGFSWABKqoBt5VPWFk3k3KJ8R72iSEVMJD1sGzjMiP+OZkR3jCSLIwVaiu" +
       "6kZ4yDJQfjsMGScGup0Ix8Drd4ZtI2WBC4YNazxMwQ8mmLNATdMOW9QG91H3" +
       "MCs8MroRYmkSnIlZvcDZiEAMoc+Z/9fd0ij7nKlAAMyy2J8UNIinTYYWZ9aY" +
       "cjC1vuf8o2PPSofDIHG0xsnVwEBIMhASDISQgZDLQKgwAyQQEPvORUakK4Ah" +
       "d0JKgJxc1zlyc//2fe1l4IPm1CywQhBA23NqU7ebNzLJfkw50Tx7z7LXV58J" +
       "klkR0kwVnqIalpp11jgkMWWnE+d1MahabvFY6ikeWPUsQ2FxyF3FiohDpcoA" +
       "oXCek7keCpnShkEcLl5YCvJPTt8/dfvoly4LkmBuvcAtyyHVIfoQZvlsNu/w" +
       "54lCdBvufPuDE/ftNdyMkVOAMnUzDxNlaPd7hl89Y8qqpfTk2JN7O4TaqyGj" +
       "cwoRCMmyzb9HTkLqyiR3lKUKBE4YVpJquJTRcQ2fsIwpd0a4bJN4nwtuUZsJ" +
       "0xVOyIpvXJ1n4jhfujj6mU8KUTyuHzEf/N3zf7lCqDtTZxo8DcII412e3IbE" +
       "mkUWa3LddovFGMC9dv/QN+49d+c24bMAsbzQhh04dkNOAxOCmr/69K5X3nj9" +
       "yNlg1s8DHIp7KgY9UjorJM6TmhJCwm4rXX4gN2qQMdBrOrbq4J9qQqUxjWFg" +
       "/bthxeqT797dKP1Ag5mMG11yYQLu/EXryW3P3vKPNkEmoGBtdnXmgsmEP8el" +
       "vM6y6G7kI337i63ffIo+CKUD0rUNeUJk4IDUgZB8ASd1AlM1Qpg2hCWvEkuX" +
       "ifFK1IJAIGLtGhxW2N6IyA06T2M1puw/+97s0fdOnRci5HZmXgcYoGaX9Dkc" +
       "VqaB/Hx/xtpE7QmAu/L04E2N2umPgGIUKCqQne3NFuTPdI67ONDllb//6Zl5" +
       "218oI8FeUqMZNN5LReSRanB5Zk9A6k2bn7tBWnyqCoZGISrJEz5vArW+pLA9" +
       "e5ImFxbY88T8H1x39PDrwvVMQaI1P6w6HY/rLBxWOH4Gh4vznbUYqs+CQZne" +
       "8eeajN0bBe/YfoVk+yW26yth+wEcNoila3HokUq5/n/UH050m3JhUbb+LM6p" +
       "P+LQ46bAYy9d/Zuj99w3JdumzuJ534e34MPNWuyOt/6Z54ci4xdo6Xz40fDx" +
       "BxZ2r31H4LupF7E70vllHcqXi3v5seTfg+0VPw+SyihpVJxDxijVUpjQotBY" +
       "25mTBxxEctZzm2TZEXZlS8tif9r3bOtP+m47Ae8Ije+zfXle2KUennbHq9r9" +
       "Dhkg4uVG6ZNiXIXDpV4jZ0nNKkGKu/3iGtfNhVtFL+RWI7nbNMCz3NlmeRGO" +
       "qRtFN+UzWQybkzKLJfC138djrASP6UIRKz4VxNf2+iN2UW5qvmJabZ9s+TB5" +
       "thY71YgT2ZE7Dh6Ob35otQyi5tyTQg8chB/57X+eC93/5jMFGtFqbpiXamyS" +
       "aR5+q3HLnLAdEAc+NwZeqz/wxx92jK+fTseIc20X6Anx9xIQYlXxTOBn5ak7" +
       "/rpwy9qJ7dNo/pb41Okn+Z2B489sXKkcCIrTrQzOvFNxLlJXbkjWWAyO8fqW" +
       "nMBcnnWeZvSVi+AJOc4Tmn6lKIZaIt/fWmJtLw6TnFSOMz7oCNLvxsfUp1Ea" +
       "xLyVFUWgz4dnjSPKmulroRhqCUn3lVi7C4cvSy30ZtKZq4WvzIAWhC8shOda" +
       "R5Rrp6+FYqglJL23xNohHPZzUsUN2Un4nOGemVLDAnjWOrKsnb4aiqGWEPXb" +
       "JdaO4PAgHC3AGbYO9/mUcHgGlDAH1zAv9DuS9E9fCcVQfYL6Dg2e5lG2JWKn" +
       "EyW0830cjoF22C5I/nbuTQPWgpFUzOZDlpqEQ+Ckc5V2+dB2ZV/H0J9kqbqo" +
       "AIKEa3k4/PXRl3c8J5J6FVaRbCr1VBCoNp7zbaPUxSfwCcDzMT7ILU7gNzRf" +
       "3c692NLsxZhpYn0t0Xj6BAjvbX5j5wNvPyIF8HeZPmC27+Bdn4TuPijrrrxd" +
       "XZ53wenFkTesUhwcnkDulpXaRWD0/vnE3h8/vPfOoGMbHTJYzDA0RvU8g8Oh" +
       "PlftktcNX2v4yf7msl6o6H2kKqWru1KsL55b1SrtVMxjB/dC1q1xDteoc04C" +
       "q0znOCAi5rszEDHYK4oaMuy4/fD0I6YYagnnf77E2q9xeAay5wScWbtBwQLq" +
       "pGNO/PqR5/0U9KSq8x+Fx0z484xHd7+cAd2h2kTbOuooYHT6uiuGWkI/b5bO" +
       "RK3e64tBg/caKT3ek1aYiV2doPAWDq9yUmOYTIcKxZzeDrDnZLD7dDPFPWtC" +
       "i3+YqZy9CJ6oo4ro9LVYDLWwpkQhElTPl1Dz+zi8C26o2iMQwusE0OOuLs7N" +
       "lC5a4Yk5AsWmr4tiqCVE/bj4WkCQ+BfHU/kwo3G8kfMp4sNP5daDk3mFr+zx" +
       "WmlB3n+H8v8u5dHDDVXzD299WZyjsv9J1UHNS6Q0zXvG97xXmHCIVYXkdfLE" +
       "bwpRqzhZeqEDJijC/YHCBColci0nLQWR4WCPX17YeugX/LCclItvL1wThmgW" +
       "DloF+eIFmQvpD0DwtcUs3ozI7LDIawRhu5YL2S6L4r1axiIv/vTNVMGU/Nt3" +
       "TDlxuH/w1vNrHpJX24pG9+xBKrVQ++Qtu9NveIuyn1qGVsWmzo/qH6tekSnK" +
       "TZJhNwIWeVy4G+LaRFdZ6Lv3tTuy17+vHLnu1K/2VbwI7cQ2EqCQ7Lbl3yal" +
       "zRQc3rdF8ms8nLfFhXRX57d2r70k8bdXxSUmkT3B4uLwY8rZoze/dGDBkbYg" +
       "qe0j5dBvsLS45tqwWx9myqQVJbNVuycNLAIVlWo5DUQ9ejXFU4TQi6PO2dlZ" +
       "/GOEk/b8tij/76QazZhi1nosCEgGWpBad0ZaxncMT5mmD8Gd8bSOP5MFGa0B" +
       "/jgWGTDNTNdITpsixM8UrtDouJ8Vr/jW+V/qCboeECIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zs1l2n7y+5Nze3ae5NQpMQmjSPW9h02J9n/BiPSVvq" +
       "sefhGY/naXvGu9vUzxmP368ZeyBQKkELRaWCFIpU8g9FlKrQsuIlAaug5Sm6" +
       "K3UX8YZWCAl2S6UWCai2LHDs+b3u7z5CSMRIPnN8zvkefz/n+zjf8/jUl6CL" +
       "cQRVAt/Jl46fHBpZcrh28MMkD4z4sMfhIyWKDZ12lDiegbLntac/c/Xvv/bh" +
       "1bUD6JIMPaR4np8oieV78cSIfWdj6Bx09bS05RhunEDXuLWyUeA0sRyYs+Lk" +
       "OQ56wxnSBLrOHbMAAxZgwAJcsgBTp60A0RsNL3XpgkLxkjiEvgO6wEGXAq1g" +
       "L4GeurGTQIkU96ibUYkA9HC5eBcBqJI4i6AnT7DvMd8E+CMV+MUfefe1/3oX" +
       "dFWGrlretGBHA0wk4CMydJ9ruKoRxZSuG7oMPeAZhj41IktxrF3Jtww9GFtL" +
       "T0nSyDgZpKIwDYyo/ObpyN2nFdiiVEv86ASeaRmOfvx20XSUJcD68CnWPcJ2" +
       "UQ4AXrEAY5GpaMYxyd225ekJ9JbzFCcYr/dBA0B6j2skK//kU3d7CiiAHtzL" +
       "zlG8JTxNIstbgqYX/RR8JYEeu22nxVgHimYrS+P5BHr0fLvRvgq0urcciIIk" +
       "gd50vlnZE5DSY+ekdEY+X+Lf/qFv87reQcmzbmhOwf9lQPTEOaKJYRqR4WnG" +
       "nvC+t3E/rDz8qx84gCDQ+E3nGu/b/OK3f+Vd3/zEy7+9b/MNt2gzVNeGljyv" +
       "fVy9/3Nvpp8l7yrYuBz4sVUI/wbkpfqPjmqeywJgeQ+f9FhUHh5Xvjz5zcV7" +
       "P2l88QC6wkKXNN9JXaBHD2i+G1iOEXUMz4iUxNBZ6F7D0+mynoXuAXnO8ox9" +
       "6dA0YyNhobudsuiSX76DITJBF8UQ3QPylmf6x/lASVZlPgsgCLoHPBAFnqeg" +
       "/a/8T6A1vPJdA1Y0xbM8Hx5FfoE/hg0vUcHYrmAVaL0Nx34aARWE/WgJK0AP" +
       "VsZRhRIEMRwpMVAfa2dE8FTsAFvaAGUyojbgbFoSHhY6F/y7fi0rsF/bXrgA" +
       "xPLm807BAfbU9R3diJ7XXkybra/8zPO/e3BiJEejlkAEYOBwz8BhycBhwcDh" +
       "KQOHt2YAunCh/O7XFYzsVQEI0gYuATjL+56d/pfeez7w9F1AB4Pt3UAKB6Ap" +
       "fHufTZ86EbZ0lRrQZOjlj26/S/zO6gF0cKPzLZgHRVcK8lHhMk9c4/XzRner" +
       "fq++/6///tM//IJ/an43ePMjr3AzZWHVT58f5sjXDB34ydPu3/ak8vPP/+oL" +
       "1w+gu4GrAO4xUYA6A8/zxPlv3GDdzx17ygLLRQDY9CNXcYqqY/d2JVlF/va0" +
       "pJT//WX+ATDGbzjW+bce6X/5X9Q+FBTp1+31pRDaORSlJ37HNPixP/yf/wct" +
       "h/vYaV89Mw1OjeS5M46i6Oxq6RIeONWBWWQYoN2ffXT0Qx/50vv/U6kAoMUz" +
       "t/rg9SKlgYMAIgTD/N2/Hf7R5//84793cKI0FxIwU6aqY2nZCciiHLpyB5Dg" +
       "a994yg9wNA4wv0Jrrgue6+uWaSmqYxRa+o9X31r7+b/50LW9Hjig5FiNvvmV" +
       "Ozgt//om9N7fffc/PFF2c0ErJrrTMTtttveeD532TEWRkhd8ZN/1vx7/0d9S" +
       "fgz4YeD7YmB0pTu7sB+DEvmbEui+ktLyDwsbLCUJl1VvK9PDYhRKAqisQ4vk" +
       "LfFZi7jR6M5EKc9rH/69L79R/PJ/+0oJ4cYw56wCDJTgub3OFcmTGej+kfPm" +
       "31XiFWiHvcz/52vOy18DPcqgRw24ungYAWeU3aAuR60v3vPHv/bfH37P5+6C" +
       "DtrQFcdX9LZSWh50L1B5I14BP5YF3/quvcS3l0FyrYQK3QS+LHjsZpt49khd" +
       "nr21TRTpU0Xy1ps17Xak54b/YO/oitfqsdCulVCLQORwH4iUn3vXHQTHFMlz" +
       "ZRVWJG/fIyL+VeD3bR8t34oo+dnbe9x2EaKdOq1H/9/QUd/3F1+9SQNKX3uL" +
       "yOQcvQx/6mOP0e/8Ykl/6vQK6ieym2cnEM6e0iKfdP/u4OlLv3EA3SND17Sj" +
       "WFlUnLRwJTKID+PjABrE0zfU3xjr7QOb506c+pvPO9wznz3vbk9nRZAvWhf5" +
       "K+c8bDnK94Pn6SOVePq8Nl2Aygy/V6gyvV4k33RWPR/4Z/C7AJ5/Kp6ivCjY" +
       "BysP0kcR05MnIVMApumTEKh6qq+lfgxfST/YG7m/Cp5njrh/5jbcS7fjvshP" +
       "EuiuyDCLLHWOl/kr8lJ2kF0Ajv0ickgclmDefeuv3VVk/wOYAeJy9QIoTMtT" +
       "nGMeHlk72vXjsRLBagYo6/W1Q9yKr8m/mi9gM/efmizng5XDB//yw5/9gWc+" +
       "DxS7B13cFEoH9PmMXfNpsZj6nk995PE3vPiFD5aTF/Da4vf+LPrVotflndAV" +
       "iVok2jGsxwpY+wiLAyHYoJxvDL1Admd7HkWWC6blzdFKAX7hwc/bH/vrn96v" +
       "As4b77nGxgde/L5/PvzQiwdn1l7P3LT8OUuzX3+VTL/xaIQj6Kk7faWkaP/V" +
       "p1/45U+88P49Vw/euJJogYXyT//+///s4Ue/8Du3CFTvdoA0/s2CTa5+oovF" +
       "LHX846qyOm8KNXOerry8a7Za1HI8ZpczxU8rbHdtK0Gr2WPTpSs3GW7t+wqh" +
       "VhouQ9YrJLreqFFvqegSwqKSyzisgNTaFb1Lb9sDMciRJSx3LFkMUSkUgigy" +
       "xbXa0cOwmjkeH0hSpYqTBKGTsJo08eGwrtUbKQJvRoapNVB0uJlvGl3aRTmd" +
       "6+hNwkqrNXeFBtWRPU7chkTwUqRKSDOdMY4wSSowbqBNBevbrB2FvfqS9Nu0" +
       "SirBwCKTSTWMQj406ts0a2Zpnx1I48ytuTOnn3a6lpCECTLnGVEUTJdqSRo7" +
       "aIUJ3XEtr52E3ECUveqQsskFqzVZyWNn84psEGw4GQ60nc5tljSDWqi8FVZ2" +
       "BTd4y+DtSa1q+/Jszs/plj5355LLzTtbBUnxbGdQKydVVl09ENfLqM7WTCdU" +
       "GDJeLEajxIer05UwYM0wjTttY7TYxttaYsfCOhh0dEJvL6oJ3t7Y6z4bziSq" +
       "kfUm+XSnTJYIow3djuTo/WGzwif8LJdwxhoMdg4dDJoTz5LbdtqSeYUfuuPO" +
       "hG1QmBAS8TK1W10lEJ0gkCc4m+CEZq6Xvhgrm5re6YR9e6yLXbtZbbtDejud" +
       "jIU8YDM58SLMa0lrnHW7iy25tXJRSX0jIzk+WYepgGN0AzGFZTAI7JpjzWr6" +
       "fNEyxjvBD1COzjFLao13LpyDqKc71mWccPPp0iG0CdaK2p3mYJo0t0ZDc9o2" +
       "Ic7QYT5h4YmjdtZxg6H6Tam3cs0B11N3OhvMek23PmWVmmYybKVZr6wtyllt" +
       "lsvmwqOxeDoREVXknV5G2gsjHI9Ue5lS4rQmUFNL4zmrmQ2FbcvnTFHNkaGp" +
       "YV0RRevBpuoPbIrZdV2FXcGERNWGMtNxFz153WEpzFkA4867OIriHLZkx4yG" +
       "LYfSgCVhzNzyDjHVTSeiOdqn4p2LLHOnMWPsaYiSK21uerw0ZyeBGCC0r4yq" +
       "et6SRGZnB3PEHw8GOcm1JjrjavPZlqhgDVVeE73qMjTsdXsRrgKZW06qSN+e" +
       "TcS1aKuuhsW54zbWtfFupGNJbZOwPTXrij20h2hIbzWoYV3cdSzF7o/hbac9" +
       "lahmP/SbCS6OpLaN2mi/15gQiDVtiYMeU4s7u/XAGlWGsj1B1/SUY7eiYqV1" +
       "W8Zypjc21/GgM9U6aVBlswYT6ZicsIjUpLEFr+yywXbccF2Op2b6YCiR4w5Z" +
       "66IDOm4MIn+ycO2pxzryRmNkq0UNfK0iw6SpV6014fUdihrkOdJrCDxrebPF" +
       "QpJJZaGt6domNRs+MhpNfSDjbqeaxZ64bTXZwYqaMux0vJQZbtxfbql8PG6N" +
       "NsOJAMBi1Eqv9vrLXqbVdk6uwTBiGjUHY0dujc6341WTQlA+FAhD5Xdcz7S3" +
       "eHWWETuCm4t4o2c79qRqb0UvZBVgHbXaemkPJMlrVfTaQFkp6qa9qFu2IY2E" +
       "eIy0s7yNti1/xQSaT/lz2rAJ26ADb7qyWxrn4At60xvNkgasmxvg7zHOdpvp" +
       "RqOSPO+KrOmP5Y0T8ym8xTGH1psA8ShlWrCZ8Ho+sMUhNfCEHZPxjjLSiZXT" +
       "IBeNMAzMmY30eGKIzZQw76y1rT+hB26+U8nuzObC3JqgTl/oN1vYQgx6Ydqb" +
       "TbQxYsbsNtCrCqb2eMzbJqkgx71qJg5zNtjMezUPW6/MdL2uu0KjL8zytLtr" +
       "mTCP7kzCoUMmmcmZ32A0lsVqiIGyasu1BUkBnlr3N+3OgCb1DTzmKxipVzQE" +
       "UwdUrO7Gq1UV021+SGVD2o3gOtnH56i3JnPeWdaAXXfZgOgvF6Sw9qPeoD5z" +
       "Vz1662LRfI4teSQcD/RmNIzUEOuR4TgUsrXUXoKpY5UZ4YwgCb0/qlFL3B10" +
       "arV8MeZSuDWPcgkdoZv+iLdbrt9pJro3d5ex2xo1DGczqOf1DmGzKEpYddQ0" +
       "Wb9C9wWmGgm8IfRsjGWEpdxsUFO9RjmD2jhYIita2rTsdG6Z7X6N7VFsh0s6" +
       "q0xC+DqbU9X6DBnUgnQLV0girpr60JtoFt6V3flSW/gdZU4ytiaGShPuZnCW" +
       "BC1i7FIpzFWxFsIjqTtadlihT4djz0D5djob6WydGPKM46gwXJcdHKk1fLbR" +
       "NoRwIPM8zk2M6UTxmrhsk1TdRlSPSJqSl4e0L3fYadRr7fANFUmVgKNIA/jq" +
       "dqYuGo1Zo1vLUHLERNuNOBgrbG1U39a7Czjimpk07GKdFbbZeaqwCOMKPZY9" +
       "o2EYypqvqk0DXpi+aFdyCannyaqybWm8bzkK2vVtIcRhDxa6Vbzqor2VoKoV" +
       "blAPRhVujNVVapGTOiyna5Lcoj09dXdpD0cxA8UGI15K82ECEOKYZmGZ7tfn" +
       "O6xqMmCylpEIrXUxLg3aRIuobhynq4VzC93gsTEzl5WqONpWprm1CsRexmTW" +
       "WhSC9dhPmgsEd2fNLGtpiQw88ExuzWVn2kgsk4xQdZiMKi5GUEaDXRuVnTl3" +
       "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" +
       "WRoJf8Q1dapl3/9qNuzLgg+cQCubPQKe+hG0+usP7WN3qHupSH5kD619vOF8" +
       "Cu2jrwFaKbXHwPMtR9C+5fWH9ok71H2ySH48gS4n/v4k5pzYPv5asT0Knnce" +
       "YXvn64/t5+5Q9wtF8ukEugTEJkzYc8g+8xqQPXRsa70jZL3XB9m5s80z2+n7" +
       "M5yS6OU7QP71IvllANkIU8WJyzbeGScfASVWfd8xFO90JH7lNYzE1WPTnByN" +
       "xOT1l/Hn7lD3v4vks0B/V0q8on3duBXku6yjO2Yl3P/xGuAWSMvpTjyCK77+" +
       "cL9wZ6V4/OyBN+8nbT/19FamGUExQ5U9/EWR/EkCXfEDwwNmbRzNU4D6oWNq" +
       "1gvS5ExdOTR/+lpt4hvAIx8Njfy62kRpvWWDL99h7P62SL4I1MGKp2AO2pv7" +
       "b54C/JvXCvBx8KhHANXXX/b/eIe6fyqSf0iKc9+JoejFbYtz6L76qg7FE+jh" +
       "W99hKi5kPHrTZcr9BUDtZ166evmRl4Q/KK/xnFzSu5eDLpup45w9LT6TvxRE" +
       "hmmVKO7dnx0Hxd+Fiwn05CvFhQDw6UuB4sLde+LLCfSmWxIn0N3F39m2bwDO" +
       "9HzbBLpY/p9td39hNCftgB/dZ842eQD4E9CkyD5Yyv3XsgtnIs0jtSnl8eAr" +
       "yeOE5OxVoCI6LW+8HkeS6f7O6/Pap1/q8d/2lfpP7K8iaY6y2xW9XOage/a3" +
       "ok6i0adu29txX5e6z37t/s/c+9bjyPn+PcOnKnyGt7fc+t5Pyw2S8qbO7pce" +
       "+bm3/+RLf16e8v4LhXW0EYosAAA=");
}
