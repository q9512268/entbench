package org.apache.batik.swing.svg;
public class SVGUpdateOverlay implements org.apache.batik.swing.gvt.Overlay {
    java.util.List rects = new java.util.LinkedList();
    int size;
    int updateCount;
    int[] counts;
    public SVGUpdateOverlay(int size, int numUpdates) { super();
                                                        this.size = size;
                                                        counts = (new int[numUpdates]);
    }
    public void addRect(java.awt.Rectangle r) { rects.add(r);
                                                if (rects.size() >
                                                      size) rects.
                                                              remove(
                                                                0);
                                                updateCount++; }
    public void endUpdate() { int i = 0;
                              for (; i < counts.length - 1; i++) {
                                  counts[i] =
                                    counts[i +
                                             1];
                              }
                              counts[i] = updateCount;
                              updateCount = 0;
                              int num = rects.size();
                              for (i = counts.length - 1; i >= 0;
                                   i--) { if (counts[i] > num) { counts[i] =
                                                                   num;
                                          }
                                          num -= counts[i]; }
                              counts[0] += num; }
    public void paint(java.awt.Graphics g) { java.util.Iterator i =
                                               rects.
                                               iterator(
                                                 );
                                             int count = 0;
                                             int idx = 0;
                                             int group = 0;
                                             while (group < counts.
                                                              length -
                                                      1 &&
                                                      idx ==
                                                      counts[group])
                                                 group++;
                                             int cmax = counts.length -
                                               1;
                                             while (i.hasNext()) {
                                                 java.awt.Rectangle r =
                                                   (java.awt.Rectangle)
                                                     i.
                                                     next(
                                                       );
                                                 java.awt.Color c;
                                                 c =
                                                   new java.awt.Color(
                                                     1.0F,
                                                     (cmax -
                                                        group) /
                                                       (float)
                                                         cmax,
                                                     0,
                                                     (count +
                                                        1.0F) /
                                                       rects.
                                                       size(
                                                         ));
                                                 g.
                                                   setColor(
                                                     c);
                                                 g.
                                                   drawRect(
                                                     r.
                                                       x,
                                                     r.
                                                       y,
                                                     r.
                                                       width,
                                                     r.
                                                       height);
                                                 count++;
                                                 idx++;
                                                 while (group <
                                                          counts.
                                                            length -
                                                          1 &&
                                                          idx ==
                                                          counts[group]) {
                                                     group++;
                                                     idx =
                                                       0;
                                                 }
                                             } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze3BU1Rk/u3kSIC8k0CCvENQE3JWqYI0vjDwCG7JNkNFQ" +
                                                              "DTd3zyYX7t57ufdssgQpwoyFOh3HUbS0SqZj0SrDw7G1VTsiHWvVUmVApxWt" +
                                                              "T2aqFp2RPzRW29rvO+fevY99OMxYd+aevXvOdx7f6/d959v9H5MyyyRNhqQl" +
                                                              "pAjbZFArEsf3uGRaNNGuSpa1Gnr75NvfvXvr2CvjtoVJeS+pHpSsTlmy6FKF" +
                                                              "qgmrl0xXNItJmkytVZQmcEbcpBY1hySm6FovmaxYHSlDVWSFdeoJigRrJDNG" +
                                                              "6iTGTKU/zWiHvQAjM2P8NFF+mujiIEFbjEyQdWOTO6HRN6HdM4a0KXc/i5Ha" +
                                                              "2HppSIqmmaJGY4rF2jImmWfo6qYBVWcRmmGR9eqltiBWxC7NEUPTozWffXnn" +
                                                              "YC0XwyRJ03TGWbS6qaWrQzQRIzVu7xKVpqyN5IekJEbGe4gZaY45m0Zh0yhs" +
                                                              "6vDrUsHpJ1ItnWrXOTvMWanckPFAjMz2L2JIppSyl4nzM8MKlczmnU8Gbmdl" +
                                                              "uXXUHWDxnnnRXT+9ufaxElLTS2oUrQePI8MhGGzSCwKlqX5qWosTCZroJXUa" +
                                                              "KLyHmoqkKiO2tustZUCTWBpMwBELdqYNavI9XVmBJoE3My0z3cyyl+RGZf8q" +
                                                              "S6rSAPDa4PIqOFyK/cBglQIHM5MS2J49pXSDoiW4HflnZHlsXgkEMLUiRdmg" +
                                                              "nt2qVJOgg9QLE1ElbSDaA8anDQBpmQ4maHJbK7AoytqQ5A3SAO1jZGqQLi6G" +
                                                              "gGocFwROYWRykIyvBFpqDGjJo5+PV11xx2ZtuRYmIThzgsoqnn88TJoRmNRN" +
                                                              "k9Sk4Adi4oTW2L1Sw9M7w4QA8eQAsaD53S1nrpk/48gLgmZaHpqu/vVUZn3y" +
                                                              "3v7q4+e2t3yvBI9RaeiWgsr3cc69LG6PtGUMQJqG7Io4GHEGj3T/6cZb99HT" +
                                                              "YVLVQcplXU2nwI7qZD1lKCo1l1GNmhKjiQ4yjmqJdj7eQSrgPaZoVPR2JZMW" +
                                                              "ZR2kVOVd5Tr/DSJKwhIooip4V7Sk7rwbEhvk7xmDEFIBD7kInvOJ+PBvRtTo" +
                                                              "oJ6iUUmWNEXTo3FTR/5RoRxzqAXvCRg19Gg/2P+GCxdEFkUtPW2CQUZ1cyAq" +
                                                              "gVUMUjEYtYbBnqLWEJjWmmXXGwlgqmuImqq0KYJWZ3zL+2WQ/0nDoRCo5twg" +
                                                              "MKjgU8t1NUHNPnlX+tolZw72HRVGh45iS46RebBpRGwa4ZtG+KYR2DQS3JSE" +
                                                              "Qnyvc3BzYQKgwA0ABYDFE1p6blqxbmdTCdieMVwK0kfS83JiU7uLGQ7Q98n7" +
                                                              "j3ePHXupal+YhAFW+iE2uQGi2RcgRHwzdZkmAKEKhQoHLqOFg0Pec5Aju4e3" +
                                                              "rdl6ET+HF/NxwTKAK5weR6TObtEc9PV869bs+OCzQ/du0V2v9wURJ/blzEQw" +
                                                              "aQpqNsh8n9w6S3q87+ktzWFSCggFqMwk8CIAvBnBPXyg0uYANPJSCQwndTMl" +
                                                              "qTjkoGoVGzT1YbeHm1wdfz8HVDwevWwaPPNst+PfONpgYDtFmCjaTIALHgCu" +
                                                              "7DH2vPbyhxdzcTuxosYT5Hsoa/PgEy5Wz5GozjXB1SalQPfm7vjd93y8Yy23" +
                                                              "P6CYk2/DZmzbAZdAhSDm217YePLtt/a+GnZtlkGATvdDrpPJMon9pKoIk2jn" +
                                                              "7nkA31TwebSa5us1sEolqUj9KkUn+XfN3AWPf3RHrbADFXocM5r/9Qu4/d+5" +
                                                              "ltx69OaxGXyZkIzx1ZWZSyZAe5K78mLTlDbhOTLbTkz/2fPSHoB/gFxLGaEc" +
                                                              "RcNcBmELrdrjt5j09aT7LRY3lRQoYsgOSYcaxjb+sWLkOifc5JsiKFdancee" +
                                                              "Wv5+H1d0Jfo39iPvEz2eu9gc8FhZrVDAV/AJwfNffFDw2CHAvb7djjCzsiHG" +
                                                              "MDJw+pYiOaGfheiW+rc33P/BAcFCMAQHiOnOXbd/Fbljl9CeyFPm5KQK3jki" +
                                                              "VxHsYHMZnm52sV34jKXvH9ry+4e37BCnqvdH3SWQVB7463/+Etn9zot5AL1E" +
                                                              "sXPNi9Gcs0DcENSOYKl8wZ5/bf3Ra12AHB2kMq0pG9O0I+FdExItK93vUZeb" +
                                                              "AfEOL3OoGkZCraAF7FjE20v4aaLZMxF+JsLHlmHTbHlR1K8xT0LdJ9/56icT" +
                                                              "13xy+Azn2p+Re0GjUzKEyOuwmYsinxKMWMslaxDoLjmy6ge16pEvYcVeWFGG" +
                                                              "KGx1mRAzMz6IsanLKl7/w7MN646XkPBSUqXqUmKpxNGajAOYpNYghNuMcfU1" +
                                                              "AiWGK6Gp5aySHObRMWfmd/klKYNxJx15YspvrvjV6FscnQQcTePTSy28CAQD" +
                                                              "K7/NuTHhozfuO/XM2C8rhA0V8YjAvKlfdKn929/7PEfIPATmcZLA/N7o/vsb" +
                                                              "2686zee7sQhnz8nk5ikQrd25392X+jTcVP5cmFT0klrZvjmtkdQ0Inwv3BYs" +
                                                              "5zoFtyvfuD/zF2luWzbWnhv0Us+2wSjoNf1S5jPzOn9MaILnAjsmXBAMfCHC" +
                                                              "X27gU87jbQs2820L8C9VWmQpRspMTCLRZPJibLc0zG8YffJPmm7bdn7FmYVC" +
                                                              "6bPyUnsuIxePLayZte9hTZDnx/zANeS9zUcf0P9+Ohy2PXhhlo9qPHY9PI/Y" +
                                                              "fDwiUHr9N5oSwyJwSwbABC2vVlI0gbd0qjEnAf8Wd0NgmZbjhq4yHn/qoUU7" +
                                                              "59/wgJDu7AIe6NI/+f13ju8ZObRfgDoGSUjPC1UacssbmCvOLZLvumr/dNnl" +
                                                              "Rz48teYmR4fV2PQLi5zKSLUXLEWGsj4YUfDndXZyh+1ybG4US6wsiIDdfqNv" +
                                                              "hKfFNpaWAv6jC//BZm2uyxSazURSw4NQ4JDG/+GQQ9hsZGR8ml+X2vW0xvLt" +
                                                              "PXyWe9fB02rv3Vpg781FBVRoNsN7OpzSCoaSrN/zXFHYy5OTPvz1i+sqTjr2" +
                                                              "ss7v83hKmyHxzYjyjXohWr40zKIDVE/BEmwwRrUBNui4/Le3GXp8ERfziGz0" +
                                                              "oTkvbx2d8y5PLCoVC+INZLd5SkOeOZ/sf/v0iYnTD/JbHPd/O+Py19RyS2a+" +
                                                              "ShjXUA0220USlpMMckMTBLYN/Th/kArj64UQfpKKJql8tcvAcFQuEPx1JTY7" +
                                                              "bI/CLZwLhI0k4uqBETnSruoaxVuMMyaKCIoeyZYfYTCTc1gEziDEdnJ23bRh" +
                                                              "0Ymxkjfumjoht3qAq80oUBtoLazI4AbPb/9n4+qrBtedRVlgZkDPwSUf6dz/" +
                                                              "4rLz5LvCvHYpspScmqd/Ups/N6kyKUubmj8Rb3IVv8MFhlauuiJ5+H1FxvZg" +
                                                              "sxusQEYVCo0XIf8Ft6i4J+ctFjJuKYKIGQ8DWcThn3ISKPR5kM2TJ4ccW2sq" +
                                                              "UOQaGGIRu7aFrj29UNmWX8r2bt81muh6cIGDglczSPt140KVDlHVs2sJf9/l" +
                                                              "r5E0E1GeJM63F8ldmQSYzVYeCk0N6CHkZ7ueuxiAWaQbABG8EBwMhx4ror7f" +
                                                              "YnOAkQopkcBZnOhybj9CH1dBbB3SlYSrw4NfF9V8Fx9uHflEhGWkRTafi85e" +
                                                              "RIWmFuH12SJjz2FzmPHatCiCYscTLtfPfDNcz4anwz56x9lzXWhqccOoyxrG" +
                                                              "MlMyBhXZ4lsdKyKPV7D5M6CAAdc5FpDF0bOXRYaR2mB9GS/FU3P+4BJ/ysgH" +
                                                              "R2sqp4xe/zcRHZ0/TibESGUyrareO5vnvdwwaVLhDEwQNzhRmXidkcbChW8G" +
                                                              "Pjwk7oMnBf2bjDTkpweJ8G8v9TvAW5Aa6Pi3l+4UI1UuHURW8eIl+QecBUjw" +
                                                              "9X3DUV+tG1bFRTcT8uCPjZtcMZO/TjHZKd6CKcZD/nekE7vScfuKcmh0xarN" +
                                                              "ZxY+KAq2siqNjOAq4yEHEbXjbPybXXA1Z63y5S1fVj86bq6Dp3XiwK7NT/OY" +
                                                              "Xxys10D7aAxUM63mbFHz5N4rDr+0s/wE5FxrSUiC9GNtbkkgY6QhOK+N5SuH" +
                                                              "QXbAC61tVafWHfv89VA9r7wQkYbMKDajT7778BvxpGH8PEzGdZAyCBc0w+sV" +
                                                              "123SAEaHTF91rbwfcu9sQleNxizhX5VcMrZAJ2Z7seAPMSy30Jj7J0iVqg9T" +
                                                              "81pcHZeZGMgY0obhHeWSbRfYjpIGW+uLdRqGXWGtPMAlbxjcY7/g8ft/uaTN" +
                                                              "OHMgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zs2F2f72/3PvbuZu/dDdmkS3aT3b2B7A78PON5eNwN" +
       "EM+Mx56Xx2N7HnYhN37O2OPX+G3DNhABiUBKo7IJqURW/SNAi5YkrYgAIdDS" +
       "qhAEREqEgFaFpKVqCWmk5A9o1bSlx57f+z622wIj+fiMz/ec832dz/mex6tf" +
       "hy4HPlTxXCtbW254qKXhoWk1D8PM04LD4bjJSH6gqV1LCgIefLutPPvZG3/1" +
       "rY9ubh5AV0TozZLjuKEUGq4TsFrgWrGmjqEbp18JS7ODELo5NqVYgqPQsOCx" +
       "EYQvjqGHz1QNoVvjYxZgwAIMWIBLFmD8lApUepPmRHa3qCE5YbCD/iF0aQxd" +
       "8ZSCvRB65nwjnuRL9lEzTCkBaOFa8X8BhCorpz70zhPZ9zLfIfDHKvDLP/2+" +
       "m//yAeiGCN0wHK5gRwFMhKATEXrE1mxZ8wNcVTVVhB5zNE3lNN+QLCMv+Rah" +
       "xwNj7Uhh5GsnSio+Rp7ml32eau4RpZDNj5TQ9U/E0w3NUo//XdYtaQ1kfeJU" +
       "1r2E/eI7EPC6ARjzdUnRjqs8uDUcNYTecbHGiYy3RoAAVL1qa+HGPenqQUcC" +
       "H6DH97azJGcNc6FvOGtAetmNQC8h9OQ9Gy107UnKVlprt0PobRfpmH0RoHqo" +
       "VERRJYTecpGsbAlY6ckLVjpjn6/T7/nIDzqUc1DyrGqKVfB/DVR6+kIlVtM1" +
       "X3MUbV/xkRfGH5ee+PUPH0AQIH7LBeI9zS//0Dff+11Pv/b5Pc2334VmKpua" +
       "Et5WPiU/+sW3d5/HHijYuOa5gVEY/5zkpfszRyUvph4YeU+ctFgUHh4Xvsb+" +
       "lvDDv6B97QC6PoCuKK4V2cCPHlNc2zMszSc1R/OlUFMH0EOao3bL8gF0FeTH" +
       "hqPtv051PdDCAfSgVX664pb/gYp00EShoqsgbzi6e5z3pHBT5lMPgqCr4IGq" +
       "4PlOaP8r3yFkwRvX1mBJkRzDcWHGdwv5C4M6qgSHWgDyKij1XFgG/r/97toh" +
       "Cgdu5AOHhF1/DUvAKzbavhAOEuBPcBAD11qQc08FQk1jzbek7LDwOu/vuL+0" +
       "kP9mcukSMM3bLwKDBcYU5Vqq5t9WXo46xDc/fft3D04GypHmQqgCOj3cd3pY" +
       "dnpYdnoIOj282Cl06VLZ17cVne9dABhwC6AAgOQjz3M/MHz/h599APielzwI" +
       "tF+QwvfG6u4peAxKiFSAB0OvfSL5kcUHqgfQwXnQLRgGn64X1ZkCKk8g8dbF" +
       "wXa3dm986M//6jMff8k9HXbnUPwIDe6sWYzmZy+q1ncVTQX4eNr8C++UPnf7" +
       "11+6dQA9CCACwGIoATcGiPP0xT7OjeoXjxGykOUyEFh3fVuyiqJjWLsebnw3" +
       "Of1S2vzRMv8Y0PHDhZt/O3gqR35fvovSN3tF+m17HymMdkGKEoG/h/M++cdf" +
       "+Gq9VPcxWN84M/1xWvjiGYAoGrtRQsFjpz7A+5oG6P7kE8xPfezrH/oHpQMA" +
       "iufu1uGtIu0CYAAmBGr+sc/v/u2X//RTf3Bw6jQhmCEj2TKU9ETI4jt0/T5C" +
       "gt6+45QfADAWGHSF19yaO7arGrohyZZWeOn/vPGu2uf+60du7v3AAl+O3ei7" +
       "Xr+B0+9/rwP98O++7789XTZzSSkmuFOdnZLtUfPNpy3jvi9lBR/pj3zpqX/y" +
       "29InAf4CzAuMXCth7KDUwQGo9Px9ghzfsIE14qOJAX7p8S9vf+bPf3EP+hdn" +
       "kQvE2odf/om/PvzIywdnptrn7pjtztbZT7elG71pb5G/Br9L4PnfxVNYoviw" +
       "h9vHu0eY/84T0Pe8FIjzzP3YKrvo/5fPvPRr/+ylD+3FePz8TEOAQOoX//B/" +
       "/d7hJ77yO3cBsQdAFFH8qZdswiWbL5TpYcFXqVSoLHuxSN4RnEWN8/o9E8Hd" +
       "Vj76B9940+Ibv/HNssvzIeDZQTKRvL2CHi2SdxbyvvUiRFJSsAF0jdfo779p" +
       "vfYt0KIIWlQA7AdTH4B0em5IHVFfvvrvfvNfP/H+Lz4AHfSh65YrqX2pRCfo" +
       "IQALWrAB+J563/fe/ahIroHkZikqdIfw+9H0tvLf1fv7V7+I4E6x7W3/Y2rJ" +
       "H/yP//0OJZSQfBeXu1BfhF/9mSe73/u1sv4pNha1n07vnLhAtHtaF/kF+y8P" +
       "nr3ybw6gqyJ0UzkKpReSFRWII4LwMTiOr0G4fa78fCi4j3tePMH+t1/0+TPd" +
       "XkTlU18D+YK6yF+/AMSllp8Fz7uPMOrdF4H4ElRmBmWVZ8r0VpF85xn3bITQ" +
       "Zb8IGM4NmfMWYqWkjCdvK786+8oXP5l/5tX9iJAlEDBBlXstTe5cHRVz27vu" +
       "Mz+fBq1/Sf791776Z4sfODhi8+HzYl+7n9gl6VtC6NGzI2IPu9x+birS9xTJ" +
       "cE/8ffd06N75fp8Ez/NH/T5/D3UvX0fdJfaW2HGBmdXfAjPvex1mHo7KcKvr" +
       "Rkd4doGn22+QpyLzwhFPL9yDJ+11eALxPOCmcMj7+Eo5r+195ZWfe+4LH3jl" +
       "uf9QItw1IwADC/fXd1kUnanzjVe//LUvvempT5fhU+nI5RC7uJq8c7F4bg1Y" +
       "cvzIiQYeKaS4ATRB7xWwf4fQ7m80RJc8LygidBlEaYHmw7SraoyhbDUftKdZ" +
       "x+uCv/tOS23UT+aBS0cheeklRWIfO8Du7g5wUGTfDfBINxzJOvEGS3PW+4VX" +
       "6ZyWl550cRy8HA34fdhToC9Y/7qOVkRQx2X7FYThHp7sPYDC9A5mfeiFe/vc" +
       "pDT96Vzx2x/8iyf57928/w0sHd5xwSUvNvnPJ6/+Dvkdyj8+gB44mTnu2Jg4" +
       "X+nF8/PFdV8LI9/hz80aT+31X+pvr/wieVep4vvELh+8T9mPFskHgLWUQtV7" +
       "y9yH/EMpdAFa9NeFlpK99BII0C8jh+hhtfj/E3f3nQeOfOdKUO4+Ff/CYw96" +
       "q2kpt47DxIXmB8BEt0wLPXaNm6dus9+/ucBo4/+aUeA+j542Nnad9Ys/+Z8+" +
       "+nv/6LkvA2waQpfjIkwAXnCmRzoqdsd+/NWPPfXwy1/5yXJVAvyQ+Thx871F" +
       "qy/fT9wi+cg5UZ8sROXKQTyWgnBSLiQ09UTa6hl5WmAqAqb7f5c2vNmgGsEA" +
       "P/6Na6JW78xr7BaO6ltu0G1vq91uTNAzoj5c7oRBNTZ7SZdEh/SW7s96vFrP" +
       "M2GFhk000tUgWM+8xM36002dmstclduJZpXzewlK1hZ8YFDLeDG3F7iXLkMe" +
       "kXZ9D2GZnF0imB9PK7oWCxg2naSCWpG0eBVP1RTVW7CKNbEYo5qTLMtYerOb" +
       "WR5uymIf94lAr0ckK9E0GXGeVCMdH23SsQ7q+kg3NkN3MdS4ikd5XMBbdtbq" +
       "j/q7te1b1XRFD8Khvc3ChTizFUJWvI5Q22Sc3eq7sS2lAsVZvcWS66uaOzTW" +
       "rD/s0WTL4El+NIfzpUHFM9ycIEyb7vcrdmQaA6Ivm0Q2U5dTftqiWLpFqZOG" +
       "VB2tFNhoUhJCeR432Nm2NCSFht9HzIFtL3W3tRM6i6XC2jbJYtrOCo3OMu2i" +
       "NDFneDdf6vrKcYRudZVk7LBa58mlzLV20tKf5TN2kC8iNB0tvF1GNwfadkjI" +
       "pNZYi5LQaNpVcVPNNkEr7vnzgPKGtUHoLP3VlI8nSwA6W6YPBMiRMTIcAM4y" +
       "q+Hkk/ZkZCm57czbpGyrVrRazallL3Uch13xFSzSpZSwxjyHuHN/pjGD9mRD" +
       "kjnXTUbWbtXcLd2A74q+O1zNpdE4o2x3tx0ZUySMglCcd/llx5skHWKs7gRa" +
       "igfYamF3hi5Rn2TVvK5kmVVhSVFv77iWz+FMT2owg920n41gpbO2ZgNq0pxw" +
       "yLCBeSuu5xrLBqVbjkhZwWq9JSbjucGq9toJkd1iOF2vsdmYqBGWzPUkvC05" +
       "vVnHs2cNW6KG8gjF3SzczZp4ncOnNVMkd7Ox0SLXpKv0E3YqLNlsO8jiTt/b" +
       "9Uhz6DYrzKJWS1NEDCNWsAf8Jl8H7s5x2m1+6LI2zdJbjNs2cNVouPwSGde4" +
       "BJugSWOGt7UZHki9Zp2rOb63hRvt9XhtixLl7SIYDAfRqWf1GN01KhoS1kGf" +
       "A4yVNGO5Dvy6orSwMdliQnI+mQ13JDpwGyRFkGadh1uKKGMYxQuL8WKmeNZq" +
       "jjjJAN2JvZo16ro1q0bS9mZkGrNGZtq7oWqi2ozz14wkuguGRYbiZCmyyHYx" +
       "XahN3od73HCUbAaua3iNBcptUT+RiU28RVO7R/QHnR66HTjxdFhhOjEb8q47" +
       "bBnzub2kiRXv1vs8CzdZl03zHb6Ku+y6hpFrGGEqZDdVif52HjJLpDubizUl" +
       "w3frxXwyNwkhFOSOsxsviaG5tO3Vikys9c6OBvZuVx0Jw6VYz8cVZDmDq07P" +
       "ZbtuM0zWk5G5nrfDGj2naMaxVpXQtcQERSh2QW4aTYNrtFhN7ngsmUgNMSQr" +
       "I4FFejOuPuSImZPFSr2TC7PROsGreEfo9Yma15KtXQr8ne+qhjZZJKPqVufa" +
       "9aExR6MxOUNnWNtBzbrGUKvIk6yKsMH7y4pBINGMNBBWWbNUkqvi1sZHxGgz" +
       "c6kx8Np1ldGUJm5GDa3uq1aL4CtUH6bThB/ho2aisS1+KoeEgjGLdguTg8q0" +
       "m89gNaoukBhL5uwQlq2cmCXSzNvRwabtYEmLq+/aaGUb5ss+112v+7tJsm13" +
       "B3jccTrMKltXIwGnmSHXnSWOyk+sHW9uXdJdkDlfE2SNsmuJqudtatFLtHiZ" +
       "SAxDB2GF0ae0txZ6Yd/umhI/wMfUuhuhPQqJGTnbpGqu8FHqBgLfpAJXgpk1" +
       "kTWXeZN0c3PVqXGSNWN0G41NFatnbSFD6kyrK2wRuCfauYyLKr7hejZSQwWN" +
       "GYchLFVIRwytLYnzsdrzPWY4cR3MG7mDLWI6qLPF6zU+0WROakZBLSBcazc3" +
       "sdF27lRWOl3Hl4xeZylfxnv9latMmj6MzaIGrFaaVpi2sKmUkqtM3A7ytCYu" +
       "RS4Tca05Qtv2mLd68mbKj2V+m8OIznCU24HX/XRMSoTCKrTSsYmxr/pm2DSr" +
       "mMSjY1aoW+zMFYL1lBMUKTXlSrAcb6eGrjSHgTHqq0X4pi3jZoWqqdWh7tYx" +
       "g4mJHNEibK20+xvRX/TwBYwPE53W9X4vQboUHsuoaprdHMyI5KQ3TCqeYEwl" +
       "Ut+AcV/xlXqdgTu40u9O8BllTJ3pSlbhvmyZFtbVsj5jN0ezUd3cGouUCgRq" +
       "Ijp2EwkW9YY5WsUU5mcV4HNop+vsYpWqc8vZooM2WnW4QoQOlrthE8zzRLBi" +
       "aAMjlaDaUwiamwojq52ITVgGypVqCE51kO1kV/VIbFodVPoqkQ7CEVaP56Im" +
       "4zoxHdenLrkVu76E99G+SSDVuCFJY3GS9ivDYExZNsXLlMXWRu2Ur47VIQY3" +
       "W4bC1+ppVsFzB/EqrFYlzXk+IrJplNhCYDjpaLKcBJaU9tyxCebrtVZreUQs" +
       "KAtt2SfJEZnWbBbPJ3lrEEjOeGShcIJO6FajtdoyHW6+W+3m9shLaVIy8ang" +
       "0cJ6Q0cTRZ/XcGNJjlqk15QyjprK7GSp2yq8tUYCnQ7TWlMIvNiPzUWrHyjO" +
       "bKbwGsNzGdLu4rPeCIXpiKc2bq5HU3g1Qbptf4NXF23BxOORpasjB0MwGGUI" +
       "fcDgvK2IYxymUReOAxlptVu5pqHBbOPkbWfbNLYzX0WadQxZVUxeWTBNxe7z" +
       "1a3li7Fph1t1Vh04SVzvCEEzd/thFutRD877iBUtc3npbOLqPKggCWe6tF7j" +
       "miaTTx1sIg3GDm4G9qqDT/Qu1V0hKMBJ1JRnAdJGquN2F1ss7ZnHBt6E745Z" +
       "kRka8lip5mRb0PUhY9uorDpo3xYW3ZbMZHMniAYpGLFSJoYatuHFnpPCOU5r" +
       "HJbPFb3KYJXpJkOY1WZjudiOoQSMGcCC3kuMOeVjdNPlkmyYcImMd7pIvLAG" +
       "1bWsVncm4eB6e6lWaTANyuZm18goB9658znaxOBkPexFKD7QWvQArui1uhm1" +
       "RWAufd1zSW5uMt3aXFKCQLa78XQsjuPI9mGVdiw2b7RDTbDZhr5AGDCdN/MR" +
       "N56vxsSSDMyGMNd7jroSs02llslkY861ksAY9FR9R8ebkd6nPWmJxy2zC8Md" +
       "0UaiLOWkfM5ySYOeNYY9Eq6Qsxm2CUSSbdtWZYXEy2oaj0OAu0sN0ztVxI/r" +
       "C2+Ntmv9zoJ16YBGpx6IjVyJ82k4X/UpIWtOeSbOa0YlANDsI0GAxu36ZmRn" +
       "VJoLZmau3M3Sb1Tz0aC3IOAOYScJ6887dGQ04LFWJ1dem2D13CDzqstvYzlF" +
       "1HbWZMZdd9GtDGhxrDa57VSbinCgw3HVEBy+Bw9lilHhaYXJahibcYhU4Tbm" +
       "ao5XEaQ65yxvMlG2E74zFmiY38Bb3DdbjflM90aj4c5qh0oMoGgWEUxaG/IC" +
       "Kg/g7lhMxptBdduIdh2Cdzg/cqV0EU0mmTTqDlwtEwVd4Lu8UlsTudEjVGeI" +
       "1GV2UxXsdGvqkW26m7C+w3ftqjvvhO5YygcNXGZkGHMalZ3fCTWVXVhrcdtj" +
       "Em6ut9QcbvjjvDmOuzEleIHHKfZOhedeANOtbTaaR7Jttlm5PljE7Ul/Y0lR" +
       "ZAwLUO6nsbgO0iiYEcCx3epqoLf7YctoDCtK2DeH0UgYDchZu7dU+I1TH3Aj" +
       "hm1uJwg/bCjKEgl28+lMIskBG6FS3zcRbE7by1XbR+SwXbOjTUsZkL01CJo5" +
       "Jqw1qqNFz6IWARIMdQy2/CZRJWqkNpy06v22pdozTsgXgtbdVulWl9qKaKRF" +
       "qYEvpRkYJGSb6CSTTdrwXR/VBWeKb2eut1U6ogMGmmxiXTDHdOROnbMEzgd+" +
       "qfexRbufYhGIg4kNudyyvKQb7abGDpZ2P6JqCDc0c6Sf2wwlhV2jKwQKPw51" +
       "Ru/RSt6QnCRvtlLMylfLzU5Rpm6W+uTEmmSdzUpsWIE6ykbMAu01J60ujqtK" +
       "s+/1+lV5umIFiUXsDkZycH9eZyqNzhDOgjXFAn15jVSDc4WlxCrMGzLBkfPM" +
       "l3xt2oydWE0SaTHe9IhkRucb1l4Z6laRu5tlm2TMZIu6E6ejI7LZ47deog3b" +
       "ZDvG+BhfNnGpxRh1q9KYD2rziJqzy7Y2sCozTenMzQRb1XvzRSUka3Kf5RW+" +
       "HXUZUwyViTiFeZMSR2qrO1LEHuxoWwKNOUWPRoq9qaaST4upUBnhOyQwdrQ5" +
       "xQEaERQhr0wAgfJqhdfEVj1rcjV9YbZb8q7V8+orIxmhNA9PhVWaBbVqD5Xw" +
       "dA5MbMt9Km/SDb/nV6oBnBDNfupzc6OLkXQob7droTXbTEcVuslF1Gwl491W" +
       "LVxI+pLS4za2wDEfTWZbQZ6MepLJoyja7sSpR1JthshJVcSzbkepJpVgUUPA" +
       "uoWQKL6P1Xw50ZUIC2aWRqdGvlk1F8rEF/EhIqKBhjMTLqtXhyY6rBqL3Rrj" +
       "2zVPoURNJCdroerKG0pbcgBeBdMbkMtKNFbZHblakiEzwS05NRUBhddtPYQj" +
       "iaen1GSN4/j3FNsH//SNbWs8Vu7gnFzHMS20KPjoG9i5SM/sep3s15a/K9CF" +
       "KxxndqzPnGBdOt4tevYe1xfWcXh4dGuhOI576l4Xcsqjx0998OVX1OnP1o6P" +
       "N9AQeih0ve+2tFizzvT6QJn/ofOH77eg/cUT6Ph9do/9VCd3aPdSqd30bpt+" +
       "l87L+Hi5PyUl4SGrKaHkrC2trPa5+2zw/WqRfDaErkqqWtS6635T7BrqqcH+" +
       "xettNZ3t426aKK4hoEeaQP9mNHFWpN+6T9nni+Q3w/Im0f7KSvHh106F+1f/" +
       "v8I9A57BkXCDvxUzP3ZiZtKXvI2hBGWtL91H7D8skt8PocuedHQCfkbkL7wR" +
       "kdMQunnxuk9xd+Ftd9w33N+RUz79yo1rb31l/kf7I5vje2wPjaFremRZZ09M" +
       "z+SveL6mGyXrD+3PT73y9Sch9OS97yGFYODF+9PYf7+n/0oIPXF3eqCL8n2W" +
       "+s+AbBepAV35Pkv3n0Po+ildCF3ZZ86SfBXwAkiK7F94d9mx3h8zp5fOgMaR" +
       "O5Umefz1THJS5ez1meLko7wdenxKETFHB8CfeWVI/+A3Wz+7v76jWFKeF61c" +
       "G0NX9zeJTk46nrlna8dtXaGe/9ajn33oXccg+Oie4VPXPsPbO+5+V4awvbC8" +
       "3ZL/ylt/6T0//8qflhvo/wf/qm/AtisA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "AA==";
}
