package org.apache.batik.css.engine.value.svg;
public class FillRuleManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_EVENODD_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          EVENODD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONZERO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONZERO_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FILL_RULE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONZERO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FillRuleManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVZa2wU1xW+u8brBwY/wIYaMNjYUF47pYSgxpRiDI6XrPHW" +
                                                              "Jig1Lcvs7N314NmZYeauvTihBKoWGqk0CiYlTeBPoQ9EQtQmapQqlPSREKUJ" +
                                                              "gqYtCSppkh9JmyCFH4nT0jY9987MzmMfrkWlWprr8dxz7nl995xzr89cR6W6" +
                                                              "hlpUXo7zQbJHxXowQt8jvKbjeKfE6/pW+BoVHnjryL7x31fs96PAAJo+yOs9" +
                                                              "Aq/jLhFLcX0AzRNlnfCygPUtGMcpR0TDOtaGeSIq8gCqF/VQSpVEQSQ9ShxT" +
                                                              "gm28Fka1PCGaGEsTHDIXIGh+mGnDMW24Di9BexhVCYq6x2ZodDF0OuYobcqW" +
                                                              "pxNUE97FD/NcmogSFxZ10p7R0DJVkfYkJYUEcYYEd0mrTUdsDq/OcUPLk9Uf" +
                                                              "33xwsIa5YQYvywphJup9WFekYRwPo2r76yYJp/Td6OuoJIymOogJag1bQjkQ" +
                                                              "yoFQy16bCrSfhuV0qlNh5hBrpYAqUIUIanYvovIanzKXiTCdYYVyYtrOmMHa" +
                                                              "BVlrrXB7TDy6jBv73o6an5ag6gFULcr9VB0BlCAgZAAcilMxrOkd8TiOD6Ba" +
                                                              "GQLejzWRl8RRM9p1upiUeZIGCFhuoR/TKtaYTNtXEEmwTUsLRNGy5iUYqMy/" +
                                                              "ShMSnwRbG2xbDQu76HcwsFIExbQED9gzWaYMiXKc4cjNkbWx9S4gANayFCaD" +
                                                              "SlbUFJmHD6jOgIjEy0muH8AnJ4G0VAEIagxrBRalvlZ5YYhP4ihBs710EWMK" +
                                                              "qCqYIygLQfVeMrYSRKnREyVHfK5vWXv4Xrlb9iMf6BzHgkT1nwpMTR6mPpzA" +
                                                              "GoZ9YDBWLQ0/zDc8d8iPEBDXe4gNmp/fd2P98qbzFwyaOXloemO7sECiwsnY" +
                                                              "9EtzO5d8oYSqUa4qukiD77Kc7bKIOdOeUSHTNGRXpJNBa/J83wtfuf80ft+P" +
                                                              "KkMoIChSOgU4qhWUlCpKWLsTy1jjCY6HUAWW451sPoTK4D0sytj42ptI6JiE" +
                                                              "0BSJfQoo7G9wUQKWoC6qhHdRTijWu8qTQfaeURFCZfCgKnhakPHDfhM0zA0q" +
                                                              "KczxAi+LssJFNIXaTwPKcg7W4T0Os6rCxQD/QytWBtdwupLWAJCcoiU5HlAx" +
                                                              "iI1JTtB1DstJ0JAb5qU05vThJNclSlJfWsI9vAwQ0YIUf+r/TXKG+mTGiM8H" +
                                                              "4ZrrTRYS7LNuRYpjLSqMpTdsuvFE9GUDiHTzmN4kaDWIDxrig0x8EMQHDfFB" +
                                                              "Jj4I4oMe8cjnY1JnUjUMgEB4hyBRQKauWtL/tc07D7WUADLVkSkQG0q6KKdy" +
                                                              "ddoZxSoDUeHMpb7xi69UnvYjPySdGFQuu3y0usqHUf00RcBxyF+FComVTLnC" +
                                                              "pSOvHuj8sZH92/Z9junhrAh0wVJIZpQ9QvN4VkSrNxPkW7f64Hsfn314r2Ln" +
                                                              "BFeJsSpjDidNNS3eGHuNjwpLF/BPR5/b2+pHUyB/Qc4mPAQS0mGTV4Yr5bRb" +
                                                              "6ZvaUg4GJxQtxUt0ysq5lWRQU0bsLwx8tXSoN3BI4eBRkGX+L/arx6+8+tdV" +
                                                              "zJNWkah2VPd+TNodiYkuVsdSUK2Nrq0axkD352ORI0evH9zOoAUUC/MJbKVj" +
                                                              "JyQkiA548JsXdr/+5rWTr/ltOBKozOkYNDkZZsvMT+HHB8+/6UOTCf1gJJW6" +
                                                              "TjOzLcimNpVKXmTrBklOgu1OwdF6twzgExMiH5Mw3Qv/rG5b+fQHh2uMcEvw" +
                                                              "xULL8okXsL9/ZgO6/+Ud401sGZ9Ai6ztP5vMyNwz7JU7NI3fQ/XI7L8875EX" +
                                                              "+eNQAyDv6uIoZqkUMX8gFsDbmC84Nq7yzN1Oh1bdiXH3NnI0Q1Hhwdc+nLbt" +
                                                              "w3M3mLbubsoZ9x5ebTdQZEQBhK1B5uBK7XS2QaXjrAzoMMubdLp5fRAWu+38" +
                                                              "lq/WSOdvgtgBECtActV7NUiAGReUTOrSsjee/3XDzkslyN+FKiWFj3fxbMOh" +
                                                              "CkA61gchd2bUL6039Bgph6GG+QPleIg6fX7+cG5KqYQFYPSZWU+t/dGJawyF" +
                                                              "BuzmZHPjgpzcyNp1e1t/cPXRd345/oMyo9gvKZzLPHyz/9ErxQ68/UlOJFgW" +
                                                              "y9OIePgHuDOPNXaue5/x2+mEci/M5BYdSLg27+dPpz7ytwR+60dlA6hGMFvj" +
                                                              "bbSkwE4egHZQt/plaJ9d8+7Wzuhj2rPpcq43lTnEehOZXezgnVLT92ke1M2h" +
                                                              "UVwHz2ITdYu9qPMh9tLNWNrY+Fk6LGMhLCGoQtUUAlpiaGcDOuvDCWgiyryU" +
                                                              "ycphaGksIgd4WcnVGctsgpZNXJ2NxhcAbSRhOq6hQ8iQ254PwZn8dvjo63Jb" +
                                                              "X/YTKLIbHTBGdGfOK9QLsz7+5IGxE/HeUysNENe5+8tNcHx6/I//+l3w2F9e" +
                                                              "ytOmVBBFXSHhYSw5ZJaByOacrdPDjgo2DtdcHi+5+tDsqtyOgq7UVKBfWFp4" +
                                                              "j3kFvHjgb41b1w3unESrMN/jKO+SP+k589Kdi4SH/Oy0Y8A+55TkZmp3g71S" +
                                                              "w3Csk7e6IN+SDe0MGrJF8KwyQ7vKC3kbTm102OZGcWUR1iJ1JFlkTqRDjKAZ" +
                                                              "oh6SB+GcCpsJOhx2FGWVxxFoejXRn47pJKKJKegahs2D09mG8d2/KRvdaB2K" +
                                                              "8rEYlHfpPRef7X43yoJWTlGRdZUDER1a0tHt1NBhBQV6kQzs0YjbW/fm0GPv" +
                                                              "PW5o5E23HmJ8aOyBT4OHx4wNYByOF+acT508xgHZo11zMSmMo+vds3t/8eO9" +
                                                              "B/2m7wcIKospioR5ORsbX7Y8NXj9aGgbWHn87/u+daUXes0QKk/L4u40DsXd" +
                                                              "MCzT0zGHY+0TtQ1KU2/achHkW6qa1ZElMaFIEsstw/TDevZ5hxvoNM/eYaL1" +
                                                              "jskDvRBrETDvLzL3DTrcR9BMUe+QxRRPaK9nIZ3OpWwH7P3fOKANng7Tio7J" +
                                                              "O6AQaxEjv1Nk7rt0OARFXqR3UwyZBcz/9i2bX02nmuDpNm3onrz5hViLmPhI" +
                                                              "kblH6TAGvXASE8vu7LlqyNzF9JfseIcjXIlo3iw6dif9c8SxYY7essPq6FQz" +
                                                              "PBHT6sjkHVaItYhTTheZO0OHU26HbYEcY3VJNaz3pr2i2Q3Z/vjhLfujlk4t" +
                                                              "gOce06h7Ju+PQqxFbH6myNyzdPiZ4Y+NOMGnJaNttvyxeOKu0aZnbnrqlt1U" +
                                                              "T6cWwhM1bY1O3k2FWIu44oUicxfo8DxB08FNoTiWCRyrsdHhfdk2/VeTNz0D" +
                                                              "rvdciNEj4Oyc+3rjjll44kR1+awTd/+JXcpk74GroO9IpCXJeUJxvAdUDSdE" +
                                                              "ZkiVcV5R2a+LBLX9V3d2kDBgZCa8arBeJqh5QlY4tgxnwWEy/oGgOUUY4dhi" +
                                                              "vDh5rkCBy8cDasHopLwKO9hLCVqw3066awRV2nQg1HhxkrwFqwMJfX1btbbD" +
                                                              "qondZcPDjGfG5z7bZOFSPxFcHMehha4ukf3Tx2qi0sa/faBjPbF5y703bj9l" +
                                                              "3I4JEj86SleZCq2TcQeXPTM0F1zNWivQveTm9Ccr2qyuznU759SNoRiqB7vJ" +
                                                              "avRcF+mt2Vuj10+uPffKocBl6Ee3Ix8Pvfn23HN5Rk3DgWZ7OF+TCCcqdpPV" +
                                                              "XvnOzoufvOGrY9cfyGgrm4pxRIUj565GEqr6fT+qCKFSaFpxhl0abNwj92Fh" +
                                                              "WHP1nIGYkpaz/x+aTvcYTysB84zp0GnZr/TilKCW3M469zK5UlJGsLaBrk6X" +
                                                              "meY5ZaVV1TnLPDtslG3qaYBjNNyjquZ9Ysly5nlVZXnkI1a8/wMT+8Ic2R0A" +
                                                              "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
