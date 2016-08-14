package org.apache.batik.svggen.font.table;
public class SingleSubstFormat2 extends org.apache.batik.svggen.font.table.SingleSubst {
    private int coverageOffset;
    private int glyphCount;
    private int[] substitutes;
    private org.apache.batik.svggen.font.table.Coverage coverage;
    protected SingleSubstFormat2(java.io.RandomAccessFile raf, int offset)
          throws java.io.IOException { super();
                                       coverageOffset = raf.readUnsignedShort(
                                                              );
                                       glyphCount = raf.readUnsignedShort(
                                                          );
                                       substitutes = (new int[glyphCount]);
                                       for (int i = 0; i < glyphCount; i++) {
                                           substitutes[i] =
                                             raf.
                                               readUnsignedShort(
                                                 );
                                       }
                                       raf.seek(offset + coverageOffset);
                                       coverage = org.apache.batik.svggen.font.table.Coverage.
                                                    read(
                                                      raf); }
    public int getFormat() { return 2; }
    public int substitute(int glyphId) { int i = coverage.findGlyph(
                                                            glyphId);
                                         if (i > -1) { return substitutes[i];
                                         }
                                         return glyphId; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVZfZAUxRXv3fs+7rgP4EA+DjgOqkDdBcEYPaMeJyeHe9wV" +
                                                              "h1TlUJe52d7dkdmZYab3bg+CiFURylSMUTSYyP2RYKIUiJVoJcaSYBIjFBEL" +
                                                              "YiUqiUatlBq0Sv6ImJjEvNc9s/OxH4RUKtmqme3tfu/1e/1e/97r3oMfkSrL" +
                                                              "JB2GpCWkCBs3qBUZxPagZFo00aNKlrUeeuPyvW8/uOP8b+p2hkn1MJmclqx+" +
                                                              "WbJor0LVhDVM5iiaxSRNptZaShPIMWhSi5qjElN0bZhMU6y+jKEqssL69QRF" +
                                                              "gg2SGSMtEmOmMpJltM8WwMjcGNcmyrWJdgcJumKkQdaNcZdhpo+hxzOGtBl3" +
                                                              "PouR5tgd0qgUzTJFjcYUi3XlTHKpoavjKVVnEZpjkTvUK+2FWBO7smAZOp5q" +
                                                              "+uSz+9PNfBmmSJqmM26itY5aujpKEzHS5PauUmnG2kLuJBUxMslDzEhnzJk0" +
                                                              "CpNGYVLHXpcKtG+kWjbTo3NzmCOp2pBRIUbm+4UYkillbDGDXGeQUMts2zkz" +
                                                              "WDsvb63j7oCJD10a3fOt25t/WEGahkmTog2hOjIowWCSYVhQmhmhptWdSNDE" +
                                                              "MGnRwOFD1FQkVdlqe7vVUlKaxLIQAs6yYGfWoCaf010r8CTYZmZlppt585I8" +
                                                              "qOxfVUlVSoGtba6twsJe7AcD6xVQzExKEHs2S+VmRUvwOPJz5G3svBkIgLUm" +
                                                              "Q1laz09VqUnQQVpFiKiSlooOQfBpKSCt0iEETR5rJYTiWhuSvFlK0TgjM4J0" +
                                                              "g2IIqOr4QiALI9OCZFwSeGlmwEse/3y09tr7tmmrtTAJgc4JKquo/yRgag8w" +
                                                              "raNJalLYB4KxYUnsYant+d1hQoB4WoBY0Pz4K+duuKz96DFBM6sIzcDIHVRm" +
                                                              "cXn/yORTs3sWX12BatQauqWg832W8102aI905QxAmra8RByMOINH1/3qy3cd" +
                                                              "oGfDpL6PVMu6ms1AHLXIesZQVGreRDVqSowm+kgd1RI9fLyP1EA7pmhU9A4k" +
                                                              "kxZlfaRS5V3VOv8NS5QEEbhE9dBWtKTutA2JpXk7ZxBCauAhDfDMIeLDvxkZ" +
                                                              "jab1DI1KsqQpmh4dNHW0Hx3KMYda0E7AqKFHRyD+N1++LHJV1NKzJgRkVDdT" +
                                                              "UQmiIk3FYNQaTaWoFk3CSkWZNKLS6BAEmEqHsiMW69XNjMSuiGD8Gf+3mXO4" +
                                                              "JlPGQiFw1+wgWKiwz1braoKacXlPduWqc0/GT4hAxM1jryYjV8L0ETF9hE8f" +
                                                              "EdNHcPoInz5SOD0JhfisU1ENESDg3s0AFIDUDYuHbluzaXdHBUSmMVYJvkHS" +
                                                              "RQWZq8dFFCcNxOWDp9adf+Xl+gNhEgbQGYHM5aaPTl/6ENnP1GWaAPwqlUgc" +
                                                              "MI2WTh1F9SBH947t3LBjKdfDmxFQYBWAGbIPIo7np+gMIkExuU273v/k8MPb" +
                                                              "dRcTfCnGyYwFnAg1HUEfB42Py0vmSc/En9/eGSaVgF+A2UyCPQZw2B6cwwc5" +
                                                              "XQ58oy21YHAS/azikIO59Sxt6mNuDw++Ft6eCi6ejHtwHjwL7U3Jv3G0zcD3" +
                                                              "dBGsGDMBK3h6+NKQse+1kx8s58vtZJImTwkwRFmXB71QWCvHqRY3BNeblALd" +
                                                              "H/YOPvjQR7s28vgDigXFJuzEdw+gFrgQlvmrx7a8/tab+18NuzHLSJ1h6gw2" +
                                                              "Mk3k8nbiEGksYyeGuqsSAKAKEjBwOm/RIDCVpIJ7CvfJ35sWLnvmw/uaRSio" +
                                                              "0ONE0mUXFuD2X7KS3HXi9vPtXExIxgTsLptLJlB9iiu52zSlcdQjt/P0nEde" +
                                                              "kvZBfgBMtpStlMNsmC9DmFs+A7IF51T0yDrYd3qmWwbssnoBsC2MfM/exrKR" +
                                                              "Y8WgqWTAWaN2Ujvcdn7LL2u23ugkrGIsgvJmq/+Vn65+L86DoRYxAPtRj0bP" +
                                                              "7u42U55IbBYe+hw+IXj+iQ96BjtEemjtsXPUvHySMowcaL+4TFXpNyG6vfWt" +
                                                              "zY++f0iYEEziAWK6e8+9n0fu2yPcKyqdBQXFhpdHVDvCHHxdg9rNLzcL5+h9" +
                                                              "7/D25x7fvkto1erP26ugLD3023/8OrL3j8eLwH+FYleryzHk82DdFvSOMKl6" +
                                                              "2b6/7rjntQFAlz5Sm9WULVnal/DKhFLNyo543OXWULzDaxy6hpHQEvAC717B" +
                                                              "FYkWqGMH4BQnAPsGVuVkamBQc74+fHVaXgD2O9JTqcfl+1/9uHHDx0fO8cXw" +
                                                              "l/pevOmXDOGJFnwtRE9MDya71ZKVBroVR9fe2qwe/QwkDoNEvjEGTEi8OR86" +
                                                              "2dRVNW+88Iu2TacqSLiX1Ku6lOiVONCTOkBYaqUhZ+eM628Q6DJWC69mbOVI" +
                                                              "fmEIXxgBbnOLQ8WqjMH45t76k+lPX/uDiTc5sAkYm8XZKy08YQRzMj8muunk" +
                                                              "wzPfefdn579XI0KrzEYJ8M3424A6cvc7nxYsMs+eRfZOgH84evDRmT3XneX8" +
                                                              "bhpD7gW5wmIHEr3Le8WBzF/CHdUvhknNMGmW7SPZBknNYnIYhmOI5ZzT4Njm" +
                                                              "G/cfKUT93JVP07ODm9czbTCBendEJfNFv5szsYYlc+3HaftyZojwxq2cZRF/" +
                                                              "L8bXZU6KqjFMBY7uNJCgJpURyshkWR8FAExRUYhj79UiO+M7hq/bhMCBknG4" +
                                                              "wW/FLDv7O1VAMStE4bAIX/FCdUtxM1KfUseNdI+e1YqqmrxIVdvhmW9PNr+E" +
                                                              "qmpZVUtxMzLJwiymMDiCWsH9lU9yPPEKQH12ygc/Or6p5nWxv4qn0cDZ8J1t" +
                                                              "J76r//5sGFlw1i/6S7AWeOyFEN+MKP/V0wneX0hjLJqiegZEsHSMaimWdo5C" +
                                                              "/7vJEJIXlkYkzypPfH/ByR0TC97mAF2rWLBvoXgocnb38Hx88K2zpxvnPMkL" +
                                                              "6UqsQeyE5r/0KLzT8F1VcA814Yvx5tVFk9sGQWDH3rbimz3MSLWRHVEVqPCq" +
                                                              "koomqVziNdCt8kXBX9fja9zG+eWFRZzIoYhukR5V1yhWks7YVCe/5u+IYDBX" +
                                                              "oDBWJMGs0c9NdiH4qtPnK848MKOh8BCH0tpLHNGWlHZmcIKX7v7zzPXXpTdd" +
                                                              "xOlsbsDXQZFP9B88ftMi+YEwv2ASiF9wMeVn6vLjfL1JWdbU/LVOh+v88RIo" +
                                                              "js07hTMDFZCT6PH3N8qMfRNfX4O4kNGpIgbKkO/hcbbeU1GEXE16cwF8zfwH" +
                                                              "+NphI1BHCXzdWxZfS3EzUutkLidoL/03ri96bJ6AXY+UsSvn6vf1vH78U00C" +
                                                              "904e/TzVFUF0mlPqapCX7fvv3jORGHhsmQPk3XDgZLpxuUpHqeoRJTbvrrwa" +
                                                              "TSh+BjxLbTWWBhfZNTRgAdesvgxrmaA5VGbsML4eB/1T1L4hcsGOr/UTF4oh" +
                                                              "X1nLo7OY1ZfAs8JWfcXFW12Ktfi5g5vApT5bxvTn8PU0FClu5g/Y/szF256D" +
                                                              "QrTw0g3L/RkF/wmIe2z5yYmm2ukTt/xO5CvnrrkBzs/JrKp6q1FPu9owaVLh" +
                                                              "djSI2tTgXz9npOPCGwvwhuUTyAuC80Uok8txMlKJX16WY4xML8ECuU00vPQn" +
                                                              "GGkO0oMq/NtLdxKc4tKBKNHwkpyCAzCQYPO04UBK5OJuRHMh/7bP+33ahfzu" +
                                                              "QYoFvtTH/x5y0lRW/EEUlw9PrFm77dwXHhNXZLIqbd2KUiZBySFu6/Kpbn5J" +
                                                              "aY6s6tWLP5v8VN1CB3tahMLuFprlCfH1sBkMDL6ZgcsjqzN/h/T6/muPvLy7" +
                                                              "+jSUWBtJSIJKY2PhSSpnZCEPb4wVu1yAQoDfa3XVv7vplU/fCLXyAysRFUd7" +
                                                              "OY64/OCRM4NJw/h2mNT1kSqAVprjx7wbx7V1VB41fXcV1SNwkMjXb5Nxp0j4" +
                                                              "1xFfGXtBG/O9eMUKm6Hw2qbw2hnO8mPUXInSUUxjoDjIGoZ3lK/sKp70c7jS" +
                                                              "EInxWL9h2PdVtdP5yhsGB4Q/8cT8LwHsubsDHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6e8zsyFWn7zdzH3MzM/fO5DHDkHnfsEoaPrf76dYAm3a3" +
       "3W4/2u522+5uEiZuv9vP9qvdHWYJ2UeiZZWN2Ek2K8H8sQoLi4YkICKQIGgQ" +
       "AhICiJfYBQkCCIlHiJT8Aaw2u8uW3d/7PibDouXT5+py1amqc06d+p1T5Xr1" +
       "K9DlOIIqYeBuTTdIDvU8OVy5zcNkG+rxIcU0eSWKda3nKnE8BWUvqs995sbf" +
       "fv2j1s0D6MoCerPi+0GiJHbgxxM9DtxM1xjoxmkp7upenEA3mZWSKXCa2C7M" +
       "2HHyAgO96UzTBLrFHLMAAxZgwAJcsgB3T6lAo4d0P/V6RQvFT+I19C+gSwx0" +
       "JVQL9hLo2fOdhEqkeEfd8KUEoIdrxbsEhCob5xH0zInse5lvE/hjFfjl//jd" +
       "N3/yPujGArph+0LBjgqYSMAgC+hBT/eWehR3NU3XFtAjvq5rgh7ZimvvSr4X" +
       "0KOxbfpKkkb6iZKKwjTUo3LMU809qBayRamaBNGJeIatu9rx22XDVUwg69tO" +
       "Zd1LSBTlQMDrNmAsMhRVP25yv2P7WgI9fbHFiYy3aEAAml719MQKToa631dA" +
       "AfTofu5cxTdhIYls3wSkl4MUjJJAT9y100LXoaI6iqm/mECPX6Tj91WA6oFS" +
       "EUWTBHrrRbKyJzBLT1yYpTPz85XRt3/k/T7pH5Q8a7rqFvxfA42eutBooht6" +
       "pPuqvm/44LuYjytv+9yHDyAIEL/1AvGe5qe/52vv/tanXvv8nuab70DDLVe6" +
       "mryofnL58G+9vffOzn0FG9fCILaLyT8neWn+/FHNC3kIVt7bTnosKg+PK1+b" +
       "/PL8Az+mf/kAuj6ErqiBm3rAjh5RAy+0XT0a6L4eKYmuDaEHdF/rlfVD6CrI" +
       "M7av70s5w4j1ZAjd75ZFV4LyHajIAF0UKroK8rZvBMf5UEmsMp+HEARdBQ/0" +
       "IHiehPZ/5W8CZbAVeDqsqIpv+wHMR0EhfzGhvqbAiR6DvAZqwwBeAvt3vg05" +
       "bMNxkEbAIOEgMmEFWIWl7yvhODNN3YcNoCk4UZauDgvAwFxdSJdxQgSRpyS1" +
       "w8L+wn+ykfNCJzc3ly6B6Xr7RbBwwTojA1fToxfVl1MM/9qnXvziwcniOdJm" +
       "AjXB8If74Q/L4Q/3wx8Wwx+Wwx/ePjx06VI56lsKNvYGAqbXAUABIPTBdwrv" +
       "pd734efuA5YZbu4Hc1OQwndH8t4ptAxLAFWBfUOvfWLzfdL3Vg+gg/OQXLAO" +
       "iq4XzfkCSE8A89bFpXinfm986C/+9tMffyk4XZTnMP4IK25vWaz15y4qOQpU" +
       "XQPoedr9u55RPvvi5166dQDdDwAEgGaiACMHePTUxTHOrfkXjvGzkOUyENgo" +
       "FO0WVcegdz2xomBzWlLO/sNl/hGg44eLRfAMeN5xtCrK36L2zWGRvmVvLcWk" +
       "XZCixOfvEMIf+u+/8Zf1Ut3HUH7jjHMU9OSFM/BRdHajBIpHTm1gGuk6oPvD" +
       "T/D/4WNf+dB3lQYAKJ6/04C3irQHYANMIVDzv/78+ve/9Eef/N2DU6NJoAfC" +
       "KEjAStK1/ETOogp66B5yggG/5ZQlgEAu6KEwnFui7wWabdiFUReG+r9uvAP5" +
       "7F9/5ObeFFxQcmxJ3/r6HZyWfxMGfeCL3/13T5XdXFILD3iqtlOyPay++bTn" +
       "bhQp24KP/Pt++8n/9CvKDwGABqAY2zu9xLmDUg0HpeRvBXBdtrSDwwlAlcDr" +
       "qgA8YgIgJuj1nfcIkyLbAzOWHbkW+KVHv+T84F/8+N5tXPRDF4j1D7/8b//+" +
       "8CMvH5xx1s/f5i/Pttk77NLUHtpP2d+Dv0vg+T/FU0xVUbAH7Ed7R17jmRO3" +
       "EYY5EOfZe7FVDkH8+adf+tkffelDezEePe+rcBCK/fjv/e9fO/zEH3/hDpB3" +
       "H4hDSg7hksN3lelhYXFHYHWk8DcfK3zI4bmqh8Uklu2+o0iejs8Cznm1nwkN" +
       "X1Q/+rtffUj66s9/reTkfGx5dn2xSrjX28NF8kyhhscuoiupxBaga7w2es9N" +
       "97Wvgx4XoMfSELgIIH1+bjUeUV+++ge/8Itve99v3QcdENB1N1A0QimBDXoA" +
       "IIoeW8BJ5OE/f/d+NW2ugeRmkcuhE8VApWKgfL8KHy/frt7b7IgiNDyFxcf/" +
       "J+cuP/in/+M2JZRofgdLvNB+Ab/6g0/0vvPLZftTWC1aP5Xf7v1AGH3atvZj" +
       "3t8cPHfllw6gqwvopnoUo0uKmxZgtQBxaXwcuIM4/lz9+RhzH1C9cOI23n5x" +
       "KZwZ9iKgn5ogyBfURf76BQwvghro6aPnOH8Owy9BZYYtmzxbpreK5J8dQ+bV" +
       "MLIzsJLKnlsJ9LAaZGBpmfo+6CpKm3tHUKTvLpLRflp7dzUB8jyD33zkaI4d" +
       "zp0YFO/CYJEdH/N23XS3odULUv+OfElvkK+nwPPsEV/P3oWv93wjfL0pLkId" +
       "OwEbiRhY+TvubuUlhO+x8pX/8vxvfO8rz/9JuSiv2TGwhW5k3mGDcKbNV1/9" +
       "0pd/+6EnP1UGC/cvlXhvFRd3VrdvnM7th0q2HzyvixvAUY72qtj/JtD6HzVI" +
       "VcIwLiLVJYhJYj2CR4Gm87bq6BHoT3ePI+P//4OW2mjeEdPJItGOTcG6sykc" +
       "JGDbni5dGzjyy4btK+6xWVxxdd/cb0RKU1XD/GSYC7567zoK0AD7wcDXi4Dh" +
       "uO4tx27lZC8OKvPbGI6gd93d7thy+k8h7lc++FdPTL/Tet8bCJafvmCWF7v8" +
       "r+yrXxh8i/oDB9B9J4B320b9fKMXzsPc9UhP0sifngO7J/dzUOrvHmvR2Sv9" +
       "goM+9kPF+/vvUfdSkWzA/KmF8vdzdQ/yD+TQBeh57z8Aep47gp7n7gI9//Ib" +
       "gZ5rx3B9bC2Vb2B/1jtqc0GIf/W6QpSD5peA27hcO2wfVov3f3dnNu8rZwUs" +
       "grg8ZCreThbGYytXvXUcy0l6FAPLu7Vy28cy3DxdDftjmguMtr5hRsGqePi0" +
       "MybwzRe+/88++mv//vkvAdiloMtZ4bSBcZ8ZcZQWh2D/5tWPPfmml//4+8vt" +
       "BVA6/3H8Zjn2x+8lbpF89JyoTxSiCiU+MUqcsOV2QNdOpK2dkQdNwKYi+H+Q" +
       "NrmhkY142D3+Y6WFseiK+WSW1Y240o5MvoF3K/2Vya2dvoap+JxXWJ3a6qTe" +
       "2UgWMnVFSm/WtLbmaN5irizrS7PSswlxsnUFVpwK8y1fm8zpoWhTUkCpijDH" +
       "hisCw5m5La5tUUlcbF0VstbQo1Z4NlI7MczlZGMi0om39vR6YqQwohf/nXZU" +
       "D1jDESKGwmqDsCc7PSyurzFxkfOKuSCCalUZ0W4k6nrKbzMZhVOOR5eVsGY5" +
       "PsJSnuqu84q8pIKoykhWX2Kbtq3kwmQUJgtFsPghK1uC3VyvcHdUXS4sVmxt" +
       "KysaX8cx0+qMJ4Rp1oSBwCa4x3lsSLkJi8obdqUORqq3jWRKM1Uq9WhnrCkj" +
       "daFZYVCx8h03SDC3zgfppJmYWnVtirspRazUuWjXZ+6UpMNAyVa0JPn4Ilw5" +
       "00ykKzVCxrh27HUXXNhcV1JhV+nwIwPzPIFae2ytZSfzppKuQhrfkUKTV1LR" +
       "8wc1h0kpTMzZ2O3vcMvfUU61F44Gc4khZ6FKJ4OKI6+W06A+2nk9LqyF2GQo" +
       "Lr1KQ5w7tusu+4P+bKCPRTaJaztnJ/fjbNmqr9pBj+ojVaVucEmtmcAyPlAs" +
       "x5sGZs3iVsNgI/eEuWSNPcuzwkTWhFEfZwf+ZMMRfYQYO5LmrvV2JokureTM" +
       "cNyNW9v5wJCDnmJUkWqE9qbzhbdwwzBpos0huuZyAxBLQjBIlkor2cSU3u6q" +
       "/VYujXd4TuNkXBMqkjcRsw3HU7vmoB5nmDM0GdEbI66yq3akteiPx1JI2LQt" +
       "uEHAjQ0spIVeUrVxfDppRtR8astWKmSES1en5optUFWzNhyuuagxtrvMsMP1" +
       "FsRG0Aeut8FjHa5vq50kaieeFyXTLmWqDYpepwG8nZiKiW4iZUQpLjPHGnQ+" +
       "F/14DiL8ioZY4wBryAE2r/K7Bl3R0pTedVp9AmNb8XCn9oekNPHUmQ9vuck0" +
       "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" +
       "M4/91Lf/yCt/VB7F/l+jFmQ65ykAAA==");
}
