package org.apache.batik.svggen.font.table;
public class CoverageFormat2 extends org.apache.batik.svggen.font.table.Coverage {
    private int rangeCount;
    private org.apache.batik.svggen.font.table.RangeRecord[] rangeRecords;
    protected CoverageFormat2(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        rangeCount =
          raf.
            readUnsignedShort(
              );
        rangeRecords =
          (new org.apache.batik.svggen.font.table.RangeRecord[rangeCount]);
        for (int i =
               0;
             i <
               rangeCount;
             i++) {
            rangeRecords[i] =
              new org.apache.batik.svggen.font.table.RangeRecord(
                raf);
        }
    }
    public int getFormat() { return 2; }
    public int findGlyph(int glyphId) { for (int i = 0; i < rangeCount;
                                             i++) { int n = rangeRecords[i].
                                                      getCoverageIndex(
                                                        glyphId);
                                                    if (n > -1) {
                                                        return n;
                                                    } }
                                        return -1; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYfWwUxxWfO9vnD2z8QbBdPgzYhoqP3BaSNK1MacDYYDhj" +
                                                              "ywakmjTnvb2588Le7rI7Z59NKSFSAkIVSoFQ2gZXSqFNKYGobdQvhdLPBNEE" +
                                                              "QaM2hDY0yR8JJUjwR+O0tE3fzOzeftydKf+kJ93c3Mx7M/Pmvfd7783JG6jE" +
                                                              "NFCzLqpxMUxGdWyGe2m/VzRMHG9XRNPcCKNRad9bB3dN/KF8dxCFBtDUIdHs" +
                                                              "lkQTd8pYiZsDaLasmkRUJWxuwDhOOXoNbGJjWCSypg6g6bLZldIVWZJJtxbH" +
                                                              "lGCzaERQrUiIIcfSBHdZCxA0J8JOI7DTCCv9BG0RVClp+qjDMMPD0O6ao7Qp" +
                                                              "Zz+ToJrIVnFYFNJEVoSIbJK2jIEW65oymlQ0EsYZEt6qPGBdxLrIAznX0Px8" +
                                                              "9Qe3nxyqYdcwTVRVjTARzT5sasowjkdQtTPaoeCUuR19GRVF0BQXMUGtEXtT" +
                                                              "ATYVYFNbXocKTl+F1XSqXWPiEHulkC7RAxE0z7uILhpiylqml50ZVigjluyM" +
                                                              "GaSdm5XWVrdPxKcWC4e+9kjND4pQ9QCqltV+ehwJDkFgkwG4UJyKYcNcGY/j" +
                                                              "+ACqVUHh/diQRUUes7RdZ8pJVSRpMAH7WuhgWscG29O5K9AkyGakJaIZWfES" +
                                                              "zKisfyUJRUyCrPWOrFzCTjoOAlbIcDAjIYLtWSzF22Q1zuzIy5GVsXU9EABr" +
                                                              "aQqTIS27VbEqwgCq4yaiiGpS6AfjU5NAWqKBCRrM1gosSu9aF6VtYhJHCWr0" +
                                                              "0/XyKaAqZxdBWQia7idjK4GWZvi05NLPjQ3L9+9Q16pBFIAzx7Gk0PNPAaYm" +
                                                              "H1MfTmADgx9wxspFkcNi/Yt7gwgB8XQfMaf58ZduPbSk6ezLnGZmHpqe2FYs" +
                                                              "kah0LDb14qz2hZ8tosco0zVTpsr3SM68rNeaacvogDT12RXpZNiePNv3uy88" +
                                                              "egJfD6KKLhSSNCWdAjuqlbSULivYWINVbIgEx7tQOVbj7Wy+C5VCPyKrmI/2" +
                                                              "JBImJl2oWGFDIY39hytKwBL0iiqgL6sJze7rIhli/YyOECqFL6qE72zEP+yX" +
                                                              "IFMY0lJYECVRlVVN6DU0Kj9VKMMcbEI/DrO6JsTA/rfduzT8oGBqaQMMUtCM" +
                                                              "pCCCVQxhPimYw8kkVoUE3JRAxJiCAa+GQbYk7tSMlEiWhanx6f+fbTP0NqaN" +
                                                              "BAKgqFl+mFDAw9ZqShwbUelQelXHrVPR89wEqdtY90jQMtg7zPcOs73DfO8w" +
                                                              "3TvM9g779kaBANvyHnoGbheg1W2ADwDQlQv7v7hucG9zERikPlIMKqGkC3IC" +
                                                              "VrsDJDb6R6WTF/smLrxScSKIgoA1MQhYTtRo9UQNHvQMTcJxgK1C8cPGUKFw" +
                                                              "xMh7DnT2yMjuzbs+xc7hDgR0wRLAMMreS+E7u0WrHwDyrVu9570PTh/eqTlQ" +
                                                              "4IksdkDM4aQI0+xXsF/4qLRorvhC9MWdrUFUDLAFUE1EcC1AwSb/Hh6kabNR" +
                                                              "m8pSBgInqJ4VOmVDbQUZMrQRZ4RZXi3r3wMqnmr7X4vli+yXztbrtG3glkpt" +
                                                              "xicFiwqf69ePvv7qtfvYddsBpNoV+fsxaXOBFl2sjsFTrWOCGw2Mge4vR3oP" +
                                                              "PnVjzxZmf0DRkm/DVtq2A1iBCuGaH395++Wrbx57LejYLEHluqERcGEcz2Tl" +
                                                              "pFOoahI5qak7RwLcU2AFajitm1QwTDkhU4eifvKv6vlLX3h/fw03BQVGbEta" +
                                                              "cucFnPFPrEKPnn9kooktE5Bo3HWuzSHjYD7NWXmlYYij9ByZ3Zdmf/0l8SiE" +
                                                              "BYBiUx7DDF0DluvSQzVCkGCcshbuA7/TUislQC2zE3CaKfZ+Riaw9r5c5mk2" +
                                                              "c1dPR0bCOj0Q4/sMbVpNt/N4/dOVXEWlJ1+7WbX55plbTFRvdua2lW5Rb+Pm" +
                                                              "SZv5GVi+wQ9Ua0VzCOjuP7vh4Rrl7G1YcQBWZEL1GICYGY9lWdQlpW/88tf1" +
                                                              "gxeLULATVSiaGO8UmZOicvAObA4B2Gb0zz/ELWOkDJoa2sug7MUgdjHcMOfk" +
                                                              "V3NHSidMMWM/afjR8u+Ov8mMkpvgTMYeNGlS6MdTltk7UPD+lW++84uJb5fy" +
                                                              "vGBhYfzz8TX+s0eJPfb2hzmXzJAvT87i4x8QTj49o33FdcbvQBDlbsnkRikA" +
                                                              "aYd32YnU34PNod8GUekAqpGsLHqzqKSpYw9A5mjaqTVk2p55bxbIU562LMTO" +
                                                              "8sOfa1s/+DnREfqUmvarfHhH0w40E75zLByY48e7AGKd9YxlAWsX0maJDS+l" +
                                                              "uiFDtYV94DJlkkUJqjBAPPD+NBQX1GtcRkDLtP50zCS9hpwClBy2ksjT9RPb" +
                                                              "f1M6ttpOEPOxcMr1ZveFn619N8pQuIwG3422+K6wutJIukJADT/9R/AJwPc/" +
                                                              "9EtPTQd4OlbXbuWEc7NJoa5Tp5zEJn0iCDvrrm57+r3nuAh+A/QR472H9n0U" +
                                                              "3n+I4yqvLFpykns3D68uuDi02URPN2+yXRhH57und/782Z17+KnqvHlyB5SB" +
                                                              "z/3x378PH/nruTxJV5FsVYdutKTJtk87XKTQ0qP/2PXE6z0Q1rtQWVqVt6dx" +
                                                              "V9xrqqVmOuZSl1OzOOZrCUdVQ1BgEWiBB2XattEmwm1xRUEI6/A6wCfhO9ey" +
                                                              "1bkFHIDnCwtosyHX0gtxE1TJLL0PS5oRN/2AlzVcFsX4Jf102rUfnhssvczV" +
                                                              "kd81fPXV2zvOP6P9+XqQstBt+73iNfgP+DEk+bRqXI0TH3dtkWdb6gTzC7uo" +
                                                              "6+bHv9Py6q7xlrdYFC2TTQBXAIk8NbGL5+bJq9cvVc0+xTLVYoo1luF6HxNy" +
                                                              "3wo8TwBMa9W0SWXsZCP8P9QzfY5t6bqO/J5I/4p+50hM4hyZgigf0tMxRZYc" +
                                                              "kGefEPJVre4M0gn0iOpgdqGHBQZCxx47NB7vOb7UNuGHIW8lmn6vgoex4ssZ" +
                                                              "5uXkDN3sLp0A/OCliaIrBxorc8svulJTgeJqUWEr8W/w0mN/m7FxxdDgXdRV" +
                                                              "c3zy+5f8XvfJc2sWSAeC7EWIx/uclyQvU5sXOisMTNKG6gXL5qzGqqkmGuG7" +
                                                              "2NLYYj/UOZbCcG7Ui3MVk7D68mY7PaT/900y9xXaPA6qTmLCfZYObHSM9Yk7" +
                                                              "IbknGaUD7Wx4d67UgnV04e6lLsSav1pgIrBVD08i+hHafBVET4D1r1FG9SGf" +
                                                              "6AfuXvQMFBC+Jw6aoDfmPLzyx0Lp1Hh1WcP4pj9x8LIf9CohaUqkFcWdP7r6" +
                                                              "Id3ACZnJUMmzSR5/v0VQ850hi6AS9sskGOecz0BiOxknQcX0x81ynKCGAiyA" +
                                                              "Vbzjpn+WoBo/PRyF/brpvg+pqUMHS/GOm+QUZD1AQrundRusF9/F41Mm4IXG" +
                                                              "rMan30njLjRt8WAVe4C3cSXNn+AhYx5ft2HHrU8f568RkiKOjdFVpkDw4Q8j" +
                                                              "WWyaV3A1e63Q2oW3pz5fPt/G51p+YMd3Zrpsux28QKeWN8NXp5ut2XL98rHl" +
                                                              "Z17ZG7oEwXYLCohQXG/JLXwyehqAc0skXzoJyM2eENoq3hm88OEbgTpWXyKe" +
                                                              "gDZNxhGVDp650pvQ9W8EUXkXKgEHxBlWla0eVSGaDhue7DQUgzIlG8mnUjcR" +
                                                              "6eM8uxnrQquyo/Q1CzwhN1HPfeGD0nsEG6vo6lbS4EHztK67Z9nNDvLUlydx" +
                                                              "RdFIt65bFUrpNXbzkAbQ31+x0P9fPWzgo2UbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/wNHaJwfeCYAAA==");
}
