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
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUZC3BU1fXu5kNIyFcIGCBACGKC7qrVIo2iEAPELpAmmJku" +
                                                              "n/Dy9m72kbfvPd67m2xi8TftiO2UsRbROpLOtChqUaxTp7VWS+vUz2htVVq1" +
                                                              "jmJrx2qVUcbRdmpbe8697+377IdhLDvz7r6995xz7/mfe/bQcVJhmaSVaizC" +
                                                              "JgxqRXo01ieZFk10q5JlbYK5Ifm2Mumjbe9sWBEmlXFSl5Ks9bJk0TUKVRNW" +
                                                              "nMxXNItJmkytDZQmEKPPpBY1xySm6FqczFKs3rShKrLC1usJigCDkhkjjRJj" +
                                                              "pjKcYbTXJsDI/BicJMpPEl0VXO6KkRmybky44HM84N2eFYRMu3tZjDTEdkhj" +
                                                              "UjTDFDUaUyzWlTXJMkNXJ0ZUnUVolkV2qBfZIrgydlGeCNoerP/k05tTDVwE" +
                                                              "Z0iapjPOntVPLV0do4kYqXdne1SatnaSa0hZjNR4gBlpjzmbRmHTKGzqcOtC" +
                                                              "welrqZZJd+ucHeZQqjRkPBAji/xEDMmU0jaZPn5moFDFbN45MnC7MMet4DKP" +
                                                              "xVuXRffetq3hoTJSHyf1ijaAx5HhEAw2iYNAaXqYmtaqRIIm4qRRA2UPUFOR" +
                                                              "VGXS1nSTpYxoEsuA+h2x4GTGoCbf05UV6BF4MzMy080ce0luUPaviqQqjQCv" +
                                                              "zS6vgsM1OA8MVitwMDMpgd3ZKOWjipZgZEEQI8dj+5cBAFCnpSlL6bmtyjUJ" +
                                                              "JkiTMBFV0kaiA2B62giAVuhggCYjLUWJoqwNSR6VRugQWmQArk8sAdR0LghE" +
                                                              "YWRWEIxTAi21BLTk0c/xDZfsuVpbp4VJCM6coLKK568BpNYAUj9NUpOCHwjE" +
                                                              "GZ2xfVLzY7vDhADwrACwgPnp105cfk7rkacFzNwCMBuHd1CZDckHhutemNfd" +
                                                              "saIMj1Fl6JaCyvdxzr2sz17pyhoQYZpzFHEx4iwe6X/yq9fdR98Lk+peUinr" +
                                                              "aiYNdtQo62lDUam5lmrUlBhN9JLpVEt08/VeMg3eY4pGxezGZNKirJeUq3yq" +
                                                              "Uue/QURJIIEiqoZ3RUvqzrshsRR/zxqEkGnwkPPgWUrEh38zsi2a0tM0KsmS" +
                                                              "pmh6tM/UkX8rChFnGGSbig6D1Y9GLT1jgglGdXMkKoEdpKizMA4WFLXGwJgG" +
                                                              "115lJICNjWPUVKWJCNqZcdp3yCKPZ4yHQiD+eUHnV8Fv1ulqgppD8t7M6p4T" +
                                                              "Dww9KwwLncGWDiPLYNOI2DTCN43wTSOwaSS4KQmF+F4zcXOhZlDSKLg7xNsZ" +
                                                              "HQNbr9y+u60M7MsYLwcJI2ibL+90uzHBCeRD8uGm2slFb5z/RJiUx0iTJLOM" +
                                                              "pGIaWWWOQICSR20fnjEMGclNDAs9iQEzmqnLNAFxqViCsKlU6cAKzjMy00PB" +
                                                              "SVvooNHiSaPg+cmR28evH7z2vDAJ+3MBblkBYQzR+zCC5yJ1ezAGFKJbf+M7" +
                                                              "nxzet0t3o4EvuTg5MQ8TeWgLWkNQPENy50Lp4aHHdrVzsU+HaM0k8C4IhK3B" +
                                                              "PXzBpssJ3MhLFTCc1M20pOKSI+NqljL1cXeGm2kjf58JZlGD3jcXnmW2O/Jv" +
                                                              "XG02cJwtzBrtLMAFTwyXDhj7X3n+3S9wcTs5pN6T/Aco6/LELSTWxCNUo2u2" +
                                                              "m0xKAe712/u+e+vxGzdzmwWIxYU2bMexG+IVqBDE/I2nd7567I0DR8OunTNI" +
                                                              "3JlhqH+yOSZxnlSXYBJ2O8s9D8Q9FSIDWk37VRrYp5JUpGGVomP9u37J+Q+/" +
                                                              "v6dB2IEKM44ZnXNyAu78mavJdc9u+0crJxOSMe+6MnPBRDA/w6W8yjSlCTxH" +
                                                              "9voX53/vKWk/pAUIxZYySXl0DXMZhP2+jv40kBm2wC+VNKhhzE5UF/Rtl3e3" +
                                                              "9/1VJKEzCyAIuFn3RL89+PKO57iSq9DzcR75rvX4NUQIj4U1COF/Bp8QPP/F" +
                                                              "B4WOEyLgN3XbWWdhLu0YRhZO3lGiTvQzEN3VdGz0znfuFwwE03IAmO7e+83P" +
                                                              "Inv2Cs2J2mVxXvngxRH1i2AHhxV4ukWlduEYa/52eNej9+y6UZyqyZ+Je6DQ" +
                                                              "vP+P/3kucvubzxRIAGWKXX9eiKacC9wz/boRDF1xU/0vbm4qWwMxo5dUZTRl" +
                                                              "Z4b2JrwUofSyMsMeZbk1EZ/wsoaKYSTUCTrAiYv5eBE/y3m5ExF+IsLX1uGw" +
                                                              "xPLGT7++PCX2kHzz0Q9rBz98/ATn2V+je8PFeskQAm/E4SwU+OxgflsnWSmA" +
                                                              "u/DIhi0N6pFPgWIcKMqQs62NJmTYrC+42NAV0/70qyeat79QRsJrSLWqS4k1" +
                                                              "Eo/TZDoESGqlIDlnjcsuF/FhvAqGBs4qyWM+bwJ9dEFh7+9JG4z76+TPZv/k" +
                                                              "koNTb/BAZQgaczl+OdYLvsTMb3pubrjvpeV/OPidfePCnkp4RwBvzr82qsM3" +
                                                              "/OWfeSLnqbCAwwTw49FDd7Z0r3yP47s5CbHbs/k1DuR1F/eC+9Ifh9sqfxMm" +
                                                              "0+KkQbZvVoOSmsFIH4fbhOVct+D25Vv33wxEGdyVy7nzgh7r2TaYDb2OUM58" +
                                                              "Rt/ozw1t8Jxt54azgwkwRPhLnKMs5WMnDud67SFHqrwEKUYqTCw5QePzC0Tb" +
                                                              "fmmc3z+G5C1LG5rbV3zUZge2ArCei8qeR38ejy9tkAVwobgfuKDcc7BKfi39" +
                                                              "JI/7eK7lOQ7q8MBN8Nxrc3CviNVbPmfpDGhwY4ZACRrdpKRpAm/seFC7ND+t" +
                                                              "9HkQ8TmYK+gfjaqrPrj47kuF7BYV8S0X/pGvvPnC/snDh0ToxlQIRXuxHkN+" +
                                                              "YwOrwSUlKlpXqR+v/dKRd98a3OroqA6HhLC1OYzUeYOiqEHUYN7Anz12+YZj" +
                                                              "Lw6bBYlY0Ui3yW/OLfB02MbQUcQzdgrPwGFrvjMUw2aibOHJJnBI8zQckgsC" +
                                                              "sk1Nhl+iuvWMxgrtPXGKezfC02nv3Vlk710lBVQMm+ENHU5pWYVDAK8FhbVs" +
                                                              "qXnyl9YP337IsZZhv0fjGW12xDcjmz+nx6GlS+MsOkL1dLQPbvhwfxthKceh" +
                                                              "Tyd59OcSTuQRy9Tdi5+/dmrxn3mJUKVYkCugSi3Q9vHgfHjo2Hsv1s5/gN/E" +
                                                              "uIfbtZO/X5bfDvN1ubgW6nH4uiin8oo6bkoCwLaSbxVOMGF8jUDqSCqapHJq" +
                                                              "K8A0VC4Q/LUSh5sMty5xLgF2rBDXB8ymkW5V1yjeRJw10TxQ9EiutQiL2bzD" +
                                                              "+vIVBND1nFU33b9ed8tbj7SPrD6VrgHOtZ6kL4C/F4C+OourO3iUp274e8um" +
                                                              "lantp9AAWBCwhiDJe9cfembtWfItYd69FHVIXtfTj9Tlrz6qTcoypuYvvBe7" +
                                                              "5nGTGyCWcQWXqLv3l1j7Pg53gK3IqGhhFyXAf5BfyuJEv+Gpekslk2tKxMqs" +
                                                              "h6VcNOKfShJo/nlinqcuDjk22lakKTYyxiJ2LwxDwvxirVx+KTtww96pxMa7" +
                                                              "znci5OUMCn/dOFelY1T17FrG3/f5+yPtRLQsifPtjfGuTALM5roOxVADmgn5" +
                                                              "2W7irglBMNIPoRO8FxwTlx4uodBHcHiQkWlSIoFYHKiLW5TQx2WQdcd0JeHq" +
                                                              "8Mcny3elrz7CXgoJDZtKy23Ol5+60IqhluD+qRJrz+Dwa8Y72KKNihOPunJ4" +
                                                              "4nTJYRE8vTYzvacuh2KopY2nMWc8a03JSCmyxbc6WkJCr+DwO4gdBlzzWEA6" +
                                                              "v/9/SCfLSEOwi4135zl5f5WJv3fkB6bqq2ZPXfWyyMXOXzAzIEEkM6rqvd15" +
                                                              "3isNkyYVztIMcdcTHY03GWkp3l5n4Plj4uZ4TMC/xUhzYXiQEf/2Qr8NvAWh" +
                                                              "AY5/e+HeZaTahYM8Ll68IO/DWQAEX48bjkIb3CQursTZkCdq2TLnqpp1MlXl" +
                                                              "ULwtVsyr/I9NJwdm+uwrz+GpKzdcfeKLd4kWr6xKk5NIpQYqHtFtzuXRRUWp" +
                                                              "ObQq13V8Wvfg9CVOFG4UB3a9YK7HIPvBng20j5ZA/9Nqz7VBXz1wyeO/3V35" +
                                                              "IlR4m0lIgmJnc37zIGtkID1sjuU30aDm4I3Zro47Jlaek/zgNd6eIaLkmVcc" +
                                                              "fkg+enDrS7fMOdAaJjW9pAISDM3yrsYVExoE3jEzTmoVqycLRwQqUFn5OnR1" +
                                                              "aMoS/uXJ5WKLszY3i38QQN7Lb07m/61Srerj1FwN94QEkoE6tcad8f3jartH" +
                                                              "dcYwAgjujKd4vUJkDdQG2ONQbL1hOL3bsGVwj+4pWiSEeKTqwbfQ/wCgDUAT" +
                                                              "9CAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TaOTU5Jn7tnacVtXBs9/69HPPfSeYxB8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "dM/wqWuf4e1dd79L07W9qLz9kv+Lt/+z9/2jV/6g3Hz/35iFQgC6KwAA";
}
