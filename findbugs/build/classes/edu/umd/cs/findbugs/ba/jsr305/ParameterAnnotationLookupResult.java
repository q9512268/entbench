package edu.umd.cs.findbugs.ba.jsr305;
class ParameterAnnotationLookupResult extends edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotationLookupResult {
    @java.lang.Override
    protected edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation combine(edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation a,
                                                                            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation b) {
        return edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation.
          combineParameterAnnotations(
            a,
            b);
    }
    public ParameterAnnotationLookupResult() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVZe8wkWVWv+WZndmdYdmZnYVnXfe+ADg1fVXf1MwO6XdVV" +
       "3dX16OpH9aNEhnp3Vder69XVjauwCbKRZEVcEBPYvyAqWR4xEk0Us8YoEIgJ" +
       "hvhKBGJMRJGEjRGNqHir+vu+/r5vZnaD/mEnffv2vfece8655/zq3FMvfhc6" +
       "FwZQwffstWF70b6WRvuWXdmP1r4W7neZCi8FoabithSGIzB2Q3nic5e+/4MP" +
       "zi/vQedF6D7Jdb1IikzPDQda6NmJpjLQpd0oYWtOGEGXGUtKJDiOTBtmzDC6" +
       "zkCvOUYaQVeZQxFgIAIMRIBzEeDmbhUgeq3mxg6eUUhuFC6hn4fOMNB5X8nE" +
       "i6DHTzLxpUByDtjwuQaAw13Z/zFQKidOA+ixI923Ot+k8IcL8PO/9s7Lv30W" +
       "uiRCl0x3mImjACEisIkI3e1ojqwFYVNVNVWE7nU1TR1qgSnZ5iaXW4SuhKbh" +
       "SlEcaEdGygZjXwvyPXeWu1vJdAtiJfKCI/V0U7PVw3/ndFsygK7373Tdakhm" +
       "40DBiyYQLNAlRTskuWNhumoEPXqa4kjHqzRYAEjvdLRo7h1tdYcrgQHoyvbs" +
       "bMk14GEUmK4Blp7zYrBLBD14W6aZrX1JWUiGdiOCHji9jt9OgVUXckNkJBH0" +
       "+tPLck7glB48dUrHzue73Nuee7fbcfdymVVNsTP57wJEj5wiGmi6Fmiuom0J" +
       "734z8xHp/i88uwdBYPHrTy3ervndn3v5qbc88tKXtmt+/BZrerKlKdEN5RPy" +
       "PV97CL/WOJuJcZfvhWZ2+Cc0z92fP5i5nvog8u4/4phN7h9OvjT409l7PqV9" +
       "Zw+6SEHnFc+OHeBH9yqe45u2FrQ1VwukSFMp6ILmqng+T0F3gj5jutp2tKfr" +
       "oRZR0B12PnTey/8DE+mARWaiO0HfdHXvsO9L0Tzvpz508DkHvg8d9PPfCIrg" +
       "uedosKRIrul6MB94mf4hrLmRDGw7h3XgTHJshHAYKHDuOpoaw7Gjwkq4m5Ql" +
       "2AoDFKkATwgyP9OCXagznreIfRAWsQ3gCLDw/5/2TTN7XF6dOQOO6qHTQGGD" +
       "GOt4tqoFN5TnY4x4+TM3vrJ3FDgHloygtwMx9oEY+0q4fyjGviztb8XYfxUx" +
       "oDNn8t1fl4mzdRJwxAsAFgBG7742/Nnuu5594izwTn91BzifbCl8ezTHd/BC" +
       "5SCqAB+HXvro6r3jX0D2oL2TsJypAIYuZuS5mEegefV0ON6K76X3f/v7n/3I" +
       "094uME/g/AFe3EyZxfsTp40deAqwY6Dt2L/5MenzN77w9NU96A4AIgA4Iwk4" +
       "OsCkR07vcSLurx9iaKbLOaCw7gWOZGdTh8B3MZoH3mo3knvBPXn/XmDjAXTQ" +
       "nIiMbPY+P2tft/Wa7NBOaZFj9NuH/sf/6s/+Ec3NfQjnl449IIdadP0YhGTM" +
       "LuVgce/OB0aBpoF1f/tR/lc//N33/0zuAGDFk7fa8GrW4gA6wBECM7/vS8u/" +
       "/uY3PvH1vZ3TROAZGsu2qaRbJX8IPmfA97+zb6ZcNrAN/yv4AQY9dgRCfrbz" +
       "m3ayATiyQWhmHnRVcB1PNXVTkm0t89j/vPTG4uf/+bnLW5+wwcihS73l1Rns" +
       "xn8Mg97zlXf+2yM5mzNK9jjc2W+3bIux9+04N4NAWmdypO/984d//YvSxwFa" +
       "A4QMzY22Bb3cHlB+gEhui0LewqfmSlnzaHg8EE7G2rG05Ybywa9/77Xj7/3h" +
       "y7m0J/Oe4+fOSv71ratlzWMpYP+G01HfkcI5WFd+iXvHZfulHwCOIuCogId9" +
       "2AsAEqUnvORg9bk7/+aP/vj+d33tLLRHQhdtT1JJKQ846ALwdC2cAxBL/Z9+" +
       "auvNq7tAczlXFbpJ+a2DPJD/OwsEvHZ7rCGztGUXrg/8R8+Wn/m7f7/JCDnK" +
       "3OJpfYpehF/82IP4T30np9+Fe0b9SHozOoMUb0db+pTzr3tPnP+TPehOEbqs" +
       "HOSPY8mOsyASQc4UHiaVIMc8MX8y/9k+7K8fwdlDp6Hm2LangWb3VAD9bHXW" +
       "v7g78GvpGRCI50r7tX0k+/9UTvh43l7Nmp/YWj3r/iSI2DDPQwEFeKhIds7n" +
       "WgQ8xlauHsboGOSlwMRXLbuWs3k9yMRz78iU2d8mc1usylp0K0Xer97WG64f" +
       "ygpO/54dM8YDeeEH/v6DX/3lJ78JjqgLnUsy84GTObYjF2ep8i+++OGHX/P8" +
       "tz6QAxBAn+E1+V+eyrjSr6Rx1rSyhjhU9cFM1aEXB4rGSGHE5jihqbm2r+iZ" +
       "fGA6AFqTgzwQfvrKNxcf+/antzneaTc8tVh79vlf+uH+c8/vHcusn7wpuT1O" +
       "s82uc6Ffe2DhAHr8lXbJKch/+OzTv/+bT79/K9WVk3kiAa5Bn/6L//rq/ke/" +
       "9eVbpBx32N7/4WCj1/xBpxxSzcMPO55ppZWSDhy9VytwbkEnhgIfdqnyaD2U" +
       "Kt2+h1F9RUobFlHV7UGvOlr6StGWXb0XwR2t5oilolWVEaM7tGfNJUm0mxHG" +
       "FOjqfDkYtpdmtFxiso3TZksami2hbybDYVLq8EtqOJ5RMBIpKFuLUavWGyFu" +
       "o4qEaLRxN5uNrtd1kNzhRXXgCtyA2ZCiY6JiSji846wkoax61EosuW12ZRd7" +
       "eqCQMA+78wpX7I67DVIWpuGItmbUhK2yo75roj6ClDqzMbXYDGdWW0XSUXmO" +
       "V40uyK7HDiJM9fawJs2Xm6UctkY4PqtYzqKtOq32slIstlMLabf48aKPdckh" +
       "TbFpReuwyzkZaWvb6KQbs7NaRCzlD+uk2FqwqqNy5eYwjJEVYnsbcJslNgNZ" +
       "Fm2GRURyEY/YRaxzRqXctUypN8ZsI6gxtUFD54twSOCyt1qKPiu1NRZhlXXR" +
       "MCaGVMRqPQszFxWxgU0FAWmjA8oUlwZcTgvLFU3QnZ4ftIs41qBRQiVCy7bx" +
       "TkEECokCk3J4j8ZYWShu1iVixTgzskXBHEJWIqxUQMayNJmMh15BF6N1WXVG" +
       "HbWQ9LWiWKSrclhcKeRsYCiEMWkRPq0JtDoTEGsyF4tO3AonQrco9yzGXaoj" +
       "y6q4s1jCC2hpUyfcadceKm3VoOGmWRXGqk0uS944bWIVGR2T/VUdq/kl8KVb" +
       "il7mcWsWUJwRUc15LVhFkd6rLkdthJGrlufwcKXcbEaWJOB4JNkStxz1VyMa" +
       "H7dStuW4LYrxJnqvOXFUrE9SbXW5ZmwultI4qKNmr9KZE2lsOpVBt8/17VYd" +
       "R1h5th7hQs3wh0jKlKd1BZ2uyxjLOwud7RLL5gbzB61hDWZk3Odqoj+f96mu" +
       "2OwoDs/MejMR5VE6Hg7wPrNKB2bq64k5lsp6qUFXC9TEjqczzqHdgrTE1+40" +
       "XKKJXCyKvVbcNittr4RUeq5aGHR6A1HlgRe1RMwb+YHbWpglG1amU6dSbNQL" +
       "TLJgEFfgqdpyrESrYYp1XMkfh+6khfBxdzicOwMs6oyUkTAIR9Vee9mslNOY" +
       "sBa18dAoz6mSNVlwbHGcmB0hFZqYrAxYdBV0Q3KNFkrsMKYrNZpLiLqqM2p1" +
       "U6CnlDQTgkF3EFI+h8pDQZr4KTxASAJX+MhElljfdJJW4tLNypgcENVBhx1H" +
       "1b6/nLNhJSDXpWWnJm/qzYWAVVyMkPxO0A5jUW03GJzr402Dmjb0zRLd9NBB" +
       "JM4pg45LqdfBDWxVm80Xkjdyi4YblRvckolldUHwDFEfbrpICzEG84AY0lGv" +
       "NFcsV1F9WpCrXYc2BgStJF6bocosMW2t+FmT9NARtSoUJpZfrxWLAoaUvLhY" +
       "xhqAVvMnJot5ydymaK1gt30VdUkbLUUAOyKMllZrMo3reBMd9WZNVFUrLaM7" +
       "qxeZnhG0V7w9GGutqmMbTlUISFXj8SpXNOi53q3OW0Oip0cdqyqVwinKTGys" +
       "EE3ttF7hram8KJgiMxzWcT5oNkcV1emIeFhD05RcMHItEjdwvUCP3U5A4Qzl" +
       "CN2gYI5jdNFLRmR5zcWuv6rGWAl2O4ntTSvzhik3NW8251ZkWwPQPaCx5ZpS" +
       "G8EitGhyvZKaC1lnHVQZsYHghKmDtbFS3elYI7qt9S0Sw/rjcqUiFmouqicT" +
       "F1booe6SfgsVyLDc5+Z9nGORsFvteSyVULNuf+TxgVGG1dFoXC9oRI+gyFYy" +
       "7QW4bq3ZpthrqmGvNUU31gaOC8m046GTvj0fY7OlzBuojjEreKDDdXdRoEaE" +
       "x2kUVtZnNBEF9RVXwoYU3sXiZssquwUMWVN8UDLKtRTTuKDuoeg08XW4sBh2" +
       "GgyFsWi1X2MWFaPUKrBlfbAqFVSYHkxDwvESfNYRjYTqchiKiesOrYyZKVVb" +
       "UwUY0XmuCGNroUWB4C7WHcJdNFgUn9fmeElgh2W+Jpa6aaPU0zp9yxH5ZUen" +
       "l5quw5JVLBBaMp3zw4EfJyETumELWRiIWm32q3JfLfeX/UE9UhOnXJ2t10zT" +
       "txaNTkiyhOhq4cit+qui2WiFqlMeG+PSvOuaRtexTXZQITtTTt+UxGqj6KLL" +
       "GmZOOwLDzWcThDU3aWs0aBkpvsDRrhxt0upQMVelVQQwkmovGbJfXMmllTxB" +
       "YcsXw661XsM0x/Ebq1wThYCa+9Fa4ycsy6s6ZoYOLa8nSh0R+mWhIW2madnQ" +
       "ahxtkUUJAXqi60nZIjWEGyw7RVitJjDsMA1WgBPGbjsT27QDdEo1EwLvot01" +
       "QvI+lrImNksMus+X/Fq9XIZrlVUFdhZBs4L6iZFM6/og9FjZKIShSoItBnyp" +
       "DnwfTou00mxMkFSpi6Lu6OZ8pCdoFSk4g1EjYEebpVUux87Ck0mjbGNdDyVK" +
       "cddv+KTspGFKNeOabTVgj4edeplbj6pmZAzKq6beWFiJwamhZBFUv0qP6U1K" +
       "hsxIM9oKS1RofDKm63IJPGMptNaSat1KvdNttvW563EJ7FH9BqCmcJ2Zr502" +
       "gNPRRuB9IgiJyhg4TFekW51Ft2R3uwjVT6aEt6CYBuPTiiEszXihmJMhUYPH" +
       "RZfrluWITaxi10eEDQxzY1FpaAI5mBZTX26skXqIJQPMF5g5ERFckyxuMLw+" +
       "wHvWdCkvPCpucazJquyEhze4vmBdluwnnXK/6kTpeN6k1w2z2l74WIFSu5V5" +
       "EEyotmAEujLzPYAyHa7ZUjbCmqdEhdbQDdnkrB5JYnZvtcYaagnVzTpfF2YT" +
       "Urcxfox0ltMaKU9aZaVsx1W2T8Xlmh6uymxQ461hlUYUt1NLSxW4t07GBJcw" +
       "q1D21FVJHHPj5phWlxtmo6ljvTQytCixfbvYZdKFWRuPZ9y8PST4odltLIY0" +
       "nPb06rSQoLBfpmOYJ3W4tWxVcLHf5FBNxblSsaIIw9hQpiyfEt1FK0WYBumZ" +
       "rNhOrAkSFGu4C9dcaS51Yj+ZivWCX5J0zYHr9WTlzuujYmiU60PWB7nLqtZY" +
       "l0QWGahGB2QR3aDaFjVWSl0hDVisjsZwSHFuEsk002ts2toyiGM8UUZx0wwq" +
       "VLXdYbiRgPlGa7MSNgt5pej6GJUtB6FEcxmXiiARQaqNWq1TcisVvjhLscFC" +
       "F3CZSxQurWOq24KRPiFwMDavFe3SVJ9UWtQoitGiN3P0UouyNgtvCKBxGgkk" +
       "AHVO6IdUXUeLitKJWJ5n5m24jjWopNxqswLI1t+epfHv+NFuUvfml8aj1wHg" +
       "ApVNtH+EG0R66w0Pxu+Fjn1uVzU7VlmAsivSw7cr+efXo0888/wLau+Txb2D" +
       "iswkgi5Env9WW0s0+xir7Jr65ttfBdn8jceuUvDFZ/7pwdFPzd/1I9RCHz0l" +
       "52mWv8W++OX2m5QP7UFnj+oGN72LOUl0/WS14GKgRXHgjk7UDB4+suybMou9" +
       "9bBz+HtzPfKWJ3QG2M0PvEhTIk3d+sOputdevm7vsIBQeeVydiZkP5bs7Cp+" +
       "rKSdEcc5++gVymp540bQnYrnyKabaxvvHNA76YB3HzngmUPhruxqDb1ECwJT" +
       "1V7BZ29R3gJH8yoF+ayi+MBN7wy377mUz7xw6a43vCD8ZV6TPnoXdYGB7tJj" +
       "2z5eADrWP+8Hmm7mul/YloP8/OeZCHr4FY0dQee3nVyP926p3hdB99+aKoL2" +
       "ZOn40mcj6L5bLI2AtAfd46s/EEEXd6sBM+XE9HPg2A6mI+gsaI9P/goYApNZ" +
       "90P+4WE1/1eedPws0jMnQePIU668WrHjGM48eQId8pfGh5Ecb18b31A++0KX" +
       "e/fL1U9ua/aKLW02GZe7GOjO7euDIzR4/LbcDnmd71z7wT2fu/DGQ+S6Zyvw" +
       "LkaPyfborYvihANStqyMvfm9N/zO237jhW/kpbT/AWrQRoTNHwAA");
}
