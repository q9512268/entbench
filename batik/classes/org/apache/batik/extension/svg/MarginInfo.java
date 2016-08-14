package org.apache.batik.extension.svg;
public class MarginInfo {
    public static final int JUSTIFY_START = 0;
    public static final int JUSTIFY_MIDDLE = 1;
    public static final int JUSTIFY_END = 2;
    public static final int JUSTIFY_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int justification;
    protected boolean flowRegionBreak;
    public MarginInfo(float top, float right, float bottom, float left, float indent,
                      int justification,
                      boolean flowRegionBreak) { super();
                                                 this.top = top;
                                                 this.right = right;
                                                 this.bottom = bottom;
                                                 this.left = left;
                                                 this.indent = indent;
                                                 this.justification =
                                                   justification;
                                                 this.flowRegionBreak =
                                                   flowRegionBreak;
    }
    public MarginInfo(float margin, int justification) { super();
                                                         setMargin(
                                                           margin);
                                                         this.indent =
                                                           0;
                                                         this.justification =
                                                           justification;
                                                         this.flowRegionBreak =
                                                           false;
    }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getJustification() { return justification; }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVaC4wbxRke+97vR55ccs8cSROCDZTQREdJcpe7xMF3Od1d" +
                                                              "InEJuazXY98m693N7vjOCQ0FpJK0VWlKA4QWorYK4qFAUFVKqxaUilJA0Eo8" +
                                                              "CqWIh2hVaGlUIlpA0Jb+/+zau157N3VETvJ4b2b+x/fPP///z6xPnCYVhk46" +
                                                              "qMJCbJ9GjdCgwkYF3aDxAVkwjAnomxLvKBM+2PnuyJogqZwkjdOCMSwKBh2S" +
                                                              "qBw3Jkm7pBhMUERqjFAaR4pRnRpUnxGYpCqTZJ5kRFKaLIkSG1bjFCdsE/Qo" +
                                                              "aREY06VYmtGIxYCR9ihoEuaahNe7h/uipF5UtX329IWO6QOOEZyZsmUZjDRH" +
                                                              "dwszQjjNJDkclQzWl9HJRZoq70vKKgvRDAvtlldZJtgcXVVggp6Hmz789PB0" +
                                                              "MzfBHEFRVMbhGWPUUOUZGo+SJrt3UKYpYy+5npRFSZ1jMiO90azQMAgNg9As" +
                                                              "WnsWaN9AlXRqQOVwWJZTpSaiQox05zPRBF1IWWxGuc7AoZpZ2DkxoO3KoTVR" +
                                                              "FkC87aLwkTt2Nv+4jDRNkiZJGUd1RFCCgZBJMChNxahurI/HaXyStCiw2ONU" +
                                                              "lwRZ2m+tdKshJRWBpWH5s2bBzrRGdS7TthWsI2DT0yJT9Ry8BHco67+KhCwk" +
                                                              "Aet8G6uJcAj7AWCtBIrpCQH8ziIp3yMpcUY63RQ5jL1XwwQgrUpRNq3mRJUr" +
                                                              "AnSQVtNFZEFJhsfB9ZQkTK1QwQF1Rto8maKtNUHcIyTpFHqka96oOQSzargh" +
                                                              "kISRee5pnBOsUptrlRzrc3rkyluuUzYpQRIAneNUlFH/OiDqcBGN0QTVKewD" +
                                                              "k7B+RfR2Yf5jh4KEwOR5rsnmnEe/cmbdyo5TT5tzFhWZsyW2m4psSjwea3x+" +
                                                              "8cDyNWWoRrWmGhIufh5yvstGrZG+jAYRZn6OIw6GsoOnxn5zzQ0P0PeCpDZC" +
                                                              "KkVVTqfAj1pENaVJMtU3UoXqAqPxCKmhSnyAj0dIFTxHJYWavVsSCYOyCCmX" +
                                                              "eVelyv8HEyWABZqoFp4lJaFmnzWBTfPnjEYIqYIPqYfPBcT849+M7AhPqyka" +
                                                              "FkRBkRQ1PKqriN8IQ8SJgW2nwzHw+j1hQ03r4IJhVU+GBfCDaWoNwKahigEY" +
                                                              "w8ZMMjws6ElJiYAWIfQy7TzzzyC+ObOBAJh+sXvjy7BnNqlynOpT4pF0/+CZ" +
                                                              "h6aeNZ0KN4JlGUaWg8iQKTLERYZyIkMgMmSLJIEAlzQXRZsLDMuzBzY6RNr6" +
                                                              "5ePXbt51qKcMPEubLQfbBmFqT17GGbCjQTaET4knWxv2d79x6RNBUh4lrYLI" +
                                                              "0oKMCWS9noTQJO6xdm99DHKRnRK6HCkBc5muijQOEckrNVhcqtUZqmM/I3Md" +
                                                              "HLIJC7dm2DtdFNWfnDo6e+O2r14SJMH8LIAiKyCAIfkoxu5cjO517/5ifJsO" +
                                                              "vvvhydsPqHYcyEsr2WxYQIkYety+4DbPlLiiS3hk6rEDvdzsNRCnmQD7CkJg" +
                                                              "h1tGXpjpy4ZsxFINgBOqnhJkHMrauJZN6+qs3cOdtIU/zwW3qMN9Nw8+K6yN" +
                                                              "yL9xdL6G7QLTqdHPXCh4SvjyuHb3H3731y9yc2ezR5Mj7Y9T1ueIWMislcem" +
                                                              "FtttJ3RKYd7rR0e/e9vpg9u5z8KMJcUE9mI7AJEKlhDM/LWn97765hvHXwrm" +
                                                              "/DzAIGWnY1D5ZHIgsZ/U+oAEaUttfSDiyRAV0Gt6tyrgn1JCEmIyxY3176YL" +
                                                              "L33k77c0m34gQ0/WjVaenYHdf0E/ueHZnR91cDYBETOubTN7mhnG59ic1+u6" +
                                                              "sA/1yNz4QvudTwl3Q0KAIGxI+6kZV7kNqvL3Ou6n8XTMgH0ppWAZZqwUddno" +
                                                              "LvFQ7+ifzfRzQRECc968+8Lf2vbK7uf4Ilfjzsd+xN3g2NcQIRwe1mwa/zP4" +
                                                              "C8Dnv/hBo2OHGepbB6x805VLOJqWAc2X+1SI+QDCB1rf3HPXuw+aANwJ2TWZ" +
                                                              "Hjryjc9CtxwxV86sWpYUFA5OGrNyMeFgswa16/aTwimG3jl54Bf3HThoatWa" +
                                                              "n4MHocR88OX/PBc6+tYzRcI/bCFVMGvPy9GZTZfG3Ze/OiakDV9v+uXh1rIh" +
                                                              "iBoRUp1WpL1pGok7eULZZaRjjuWy6yHe4QSHS8NIYAWsAnasdjVcqSssO+BX" +
                                                              "n+N5LSNlklKgOP47mDkbZVVMVWUqKMWpuTKr+NgluRmEzyB8bAybCw1nIM93" +
                                                              "HEeVPyUefun9hm3vP36GGz//mOCMW8OCZq58CzZLceUXuBPtJsGYhnmXnxrZ" +
                                                              "0Syf+hQ4TgJHEQoHY4sOiT6TF+Ws2RVVf/zVE/N3PV9GgkOkFlY7PiTwhEFq" +
                                                              "IFJTYxpqhIy2dp0ZqGaroWnmUEkB+IIODBadxcPQYEpjPHDs/9mCn1x577E3" +
                                                              "eMTUOIv2wmyw2gqUq4tnA2yXYXNRYYz1InWtYNCsSnL+tZGzjvmscxyba/nQ" +
                                                              "ODY7TQNsO0dbYccOzRxYxDvrsG7LK5H4advO0g+8+KXf3/ud22fNne0Tp1x0" +
                                                              "Cz/ZIsduevvjAp/jRUmR0OWinwyfuKtt4Kr3OL1dHSB1b6aw1oQKy6a97IHU" +
                                                              "v4I9lU8GSdUkaRat0+02QU5jzp2EE52RPfLCCThvPP90Zh5F+nLVz2J37HSI" +
                                                              "ddclzoBUzvKCj12KLMR1CcOnzfKgNrfz8XrX3FKoUigCh9Ek1Vvf/sHxj248" +
                                                              "uDqIubBiBlUHqzTb80bSeIi++cRt7XVH3vom9/wsa3MHLOPtCmwu5q5Qho8h" +
                                                              "KCUMfh7HwCwpguwqKRb4KMtIw+at4xORoWumxifWj01wH7d3D/fgvWfz4N2F" +
                                                              "xllkyVtUxDj4oGcj5wE/ZNjMYpMpAslLBCONWUjDkQ0booPFMF1/DpgWWwIX" +
                                                              "+2DikeLmc8bkJYKRuiymwZENxQAdPAdA7Za0dh9AXOlvnzMgLxGM1GcBDW2N" +
                                                              "RoshOvz/I2rMunanJa6zABHhD0eLA4FqvEbTVQaRg8ZdKBp82EI5wVQtlxwc" +
                                                              "yt9ZovK44F2WlC4P5X9oJ7TvF+roRQ1BQZeS06yYlj8qUUtcxW5LTreHlvf5" +
                                                              "aulFDTEspjKmpoqpeX+JamJE6LEE9XioedJXTS9qBocpmihqy4fPwZa9lphe" +
                                                              "DyV/6qukFzXYEup7qBCKqfloiWoi86WWoKUeaj7mq6YXNaSe3WmDwaFTFLKH" +
                                                              "bncMeLxEbVHGMkveMg9tf+2rrRc11N1w6Jkdo0lQtV+nAr9jirr0fdJH30yx" +
                                                              "epT/VRLXDaNDrqPwI1jet3tdAvND3fGbjhyLb7nn0qBVjK6DwAYR6mKZzlDZ" +
                                                              "waoaOeXVkMP82tsuyF5vvPVPP+9N9pdyw4Z9HWe5Q8P/O6HuWeFdlrpVeeqm" +
                                                              "v7VNXDW9q4TLsk6Xldws7x8+8czGpeKtQX7Hb1aKBe8G8on68uvDWp2ytK7k" +
                                                              "H1GX5B9R0IfWWuu61u2Ntud4HVG8SF2HD8cxdDXn+prP6eR1bF4GrzAoMy9p" +
                                                              "ix11y2dUKW579SufxxGG97+QQzkHxzCfDlkoh0o3kBepD/73fMZOY/MXqEyS" +
                                                              "lE2ommkeblbbFO+cL1NgQtxo4dlYuim8SH3gfuwz9gk2H0AlDaYYw+qhqDH+" +
                                                              "eb6MgWl3k4VoU+nG8CL1Bhyo8BmrwoZAAgBj9PMipZg1AoHzZY0u+EQsSJHS" +
                                                              "reFF6oO41WdsLjYNkLzBGlGohYraovF82QLr5KstQFeXbgsvUh+8nT5j3di0" +
                                                              "QTQFW0Tsksu2w6LzZYcl8Bm2wAyXbgcvUh+sK33G8AwYWMZIM9hhc0FNZ5vj" +
                                                              "C+fLHFiljliYRko3hxepD+Q1PmOYTQOXM9IiGUNFakbbHqs+l7tBRmrt9614" +
                                                              "ubqw4Occ5k8QxIeONVUvOLb1FV7U5X4mUA/lWSIty87bL8dzpabThMStWG/e" +
                                                              "hfGb98AAIx3+r4HheAwt6h3oN2mGGGnzpoGNlHt2UkXAs9xUcKzl3855UbCE" +
                                                              "PQ+OQeaDc8oW0Amm4OOo6UkLmfMOzrw+zATyy+7sgpF5Z1swR6W+JK/C5T/E" +
                                                              "yVajafOnOFPiyWObR647c8U95otJURb270cudVFSZb4jzVW03Z7csrwqNy3/" +
                                                              "tPHhmguztX+LqbDt/YscCX4HVIwa+kqb662d0Zt7effq8Ssf/+2hyheCJLCd" +
                                                              "BARG5mwvvGjNaGk4SmyPFr74geqfv07sW/69fVetTPzjteyNZiD/Ats9f0p8" +
                                                              "6d5rX7x14fGOIKmLkAo8y2b4DfCGfcoYFWf0SdIgGYMZUBG4SIKc91apEd1a" +
                                                              "wJ/ocLtY5mzI9eJrbUZ6Cl+pFf4YoBY2L9X71bTCL/Ub4PRh92RPNnmHgrSm" +
                                                              "uQjsHmspseU3eGsyuBrgj1PRYU3LvnGs+UTj+3qwWH0/yH1Y5I/4FP8ft6i/" +
                                                              "zqQnAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VYpPgy91QJF6+yk+eIe6q0Vyf1R5EFCk");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ve1MGZ679FYJFkeQowOCo7ef4HvvUPe+InkXcDuAIHV8DHZM7pG3Su458B0f" +
       "kBu//eTef4e6DxbJ01HlGiA3vOU87ZjjM2+VY3HsxxxwZN5+jrU71BUnluc+" +
       "BKIOI8TPOJc7Jvn9d3UjKKpcPr4JW1zre/SWi/b7y+Hyr7129f73vMb/p/Iy" +
       "6NEF7kt05X4ttqyT12NO5C94gaoZJfFL+8syXsnmB6LKk3e+oBtV7gFpAfhc" +
       "d9/nw1Hlsdv3Aap9lD/Z66NALU73iir3lX9PtsPAShy3iyoX9pmTTXCACTQp" +
       "soR3xuHj/n5Reu7mAO3IPz783QRzIqZ77qZIrPwXicOoKd7/k8RL8pdfGzI/" +
       "9kb7F/e3XGVLyvNilPvpysX9hdujyOuZ2452ONYF8vnvXPnKpfcfRolX9oCP" +
       "VfoEtqfOvlI6sL2ovASa//P3/NMf/KXX/qi8pfT/AAhttdy7MgAA");
}
