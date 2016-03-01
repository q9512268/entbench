package edu.umd.cs.findbugs.gui2;
public class DeadBugFilter extends edu.umd.cs.findbugs.gui2.FilterMatcher {
    public DeadBugFilter(edu.umd.cs.findbugs.gui2.Sortables filterBy, java.lang.String value,
                         edu.umd.cs.findbugs.gui2.FilterMatcher.FilterWhere mode) {
        super(
          filterBy,
          value,
          mode);
    }
    @java.lang.Override
    public java.lang.String toString() { return edu.umd.cs.findbugs.L10N.
                                           getLocalString(
                                             "pref.dead_bugs",
                                             "Dead Bugs");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UfHKhwv/BQtuTXIhFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU5a8zrWHG+39373Me9exeWZWHfF9pd08/O29GlFNuJkzh2" +
       "nNhOnLiUi1+JnfgVPxI7dFvYqkBLBat2oVSC/QVqi5aHqqJWqqi2qlpAoEpU" +
       "qC+pgKpKpaVIrKrSqrSlx879vnzfdx8IpEby8ck5M3Nm5szMGc956TvQmTCA" +
       "YN+z05ntRftGEu3P7cp+lPpGuE8zlb4ShIZO2koYimDsuvbkZy997/vPm5f3" +
       "oLMy9IDiul6kRJbnhrwRevbK0Bno0m60aRtOGEGXmbmyUpA4smyEscLoGgPd" +
       "fQQ1gq4yBywggAUEsIDkLCD4Dgog3Wu4sUNmGIobhUvoF6BTDHTW1zL2IuiJ" +
       "40R8JVCcG2T6uQSAwvns/wgIlSMnAfT4oexbmW8S+EMw8sJvvv3y752GLsnQ" +
       "JcsVMnY0wEQEFpGhexzDUY0gxHXd0GXoftcwdMEILMW2NjnfMnQltGauEsWB" +
       "caikbDD2jSBfc6e5e7RMtiDWIi84FG9qGbZ+8O/M1FZmQNYHd7JuJaSycSDg" +
       "RQswFkwVzThAuWthuXoEPXYS41DGq10AAFDPOUZkeodL3eUqYAC6st07W3Fn" +
       "iBAFljsDoGe8GKwSQQ/flmima1/RFsrMuB5BD52E62+nANSFXBEZSgS9+iRY" +
       "Tgns0sMndunI/nyn9+YPvNNtu3s5z7qh2Rn/5wHSoyeQeGNqBIarGVvEe55h" +
       "Pqw8+Pn37UEQAH71CeAtzB/8/CtvfdOjL39xC/O6W8Bw6tzQouvax9X7vvp6" +
       "8un66YyN874XWtnmH5M8N//+jZlriQ8878FDitnk/sHky/yfT971SePbe9DF" +
       "DnRW8+zYAXZ0v+Y5vmUbQctwjUCJDL0DXTBcncznO9A50Gcs19iOctNpaEQd" +
       "6C47Hzrr5f+BiqaARKaic6BvuVPvoO8rkZn3Ex+CoHPgge4Bz2uh7S9/R9Db" +
       "ENNzDETRFNdyPaQfeJn8IWK4kQp0ayJTYExqPAuRMNCQWWwhhh4jsaMjWrib" +
       "A+NFpGEoOhHPKMsGtrSfWZn//0w/yeS7vD51Cqj+9Scd3wY+0/Zs3Qiuay/E" +
       "RPOVT1//8t6hI9zQTAS9Eay3D9bb18L9g/X2s/X2j60HnTqVL/OqbN3t7oK9" +
       "WQAvB/HvnqeFn6Pf8b4nTwOz8td3AcVmoMjtwzC5iwudPPppwDihlz+yfvfo" +
       "F9E9aO94PM14BUMXM/R+FgUPo93Vk350K7qX3vut733mw896O486FqBvOPrN" +
       "mJmjPnlSq4GnAYUFxo78M48rn7v++Wev7kF3Ae8HES9SgIWCYPLoyTWOOey1" +
       "g+CXyXIGCDz1Akexs6mDiHUxMgNvvRvJt/u+vH8/0PHdmQU/BJ7X3TDp/J3N" +
       "PuBn7au25pFt2gkp8uD604L/sb/5i38u5eo+iMOXjpxsghFdO+L7GbFLuZff" +
       "v7MBMTAMAPf3H+n/xoe+896fzQ0AQDx1qwWvZi0JfB5sIVDzL39x+bff+PrH" +
       "v7a3M5oIHH6xaltacihkNg5dvIOQYLU37vgBscMG/pVZzdWh63i6NbUU1TYy" +
       "K/3vS28ofO5fP3B5awc2GDkwozf9cAK78dcS0Lu+/Pb/eDQnc0rLzq6dznZg" +
       "24D4wI4yHgRKmvGRvPsvH/mtLygfA6EVhLPQ2hh5hDqd6+B0LvmrI+jJ2/ql" +
       "4AVRxlJ4AHo5XyQ70fa3J9rBRPG2NLZOzSqRZhrB1e0/CXSN3GaQnMAzebuf" +
       "6TtnDcrnalnzWHjU946795EU57r2/Ne+e+/ou3/8Sq6s4znSUVNjFf/a1rqz" +
       "5vEEkH/NyUDTVkITwJVf7r3tsv3y9wFFGVDUQGIQcgGIcskxw7wBfebc3/3J" +
       "nz74jq+ehvYo6KLtKTql5D4OXQDOZYQmCJCJ/zNv3drW+jxoLueiQjcJv7XJ" +
       "h27sUgA9ffvwRmUpzi5CPPRfnK0+9w//eZMS8sB2i5P9BL6MvPTRh8m3fDvH" +
       "30WYDPvR5ObID9LBHW7xk86/7z159s/2oHMydFm7kWuOFDvO/FYG+VV4kICC" +
       "fPTY/PFcaZsYXDuMoK8/Gd2OLHsytu1OHNDPoLP+xaPh7Afgdwo8/5s9mbqz" +
       "ge0JfYW8kSY8fpgn+H5yCgSLM8X92j6a4TdzKk/k7dWs+YntNmXdnwRRJcyT" +
       "XIABvECx84WpCJiYrV09oD4CSS/Yk6tzO7fw4jZ2Zi2Wg2+3/9ptTeWtW6j8" +
       "kLxv55CMBxLM9//j81/54FPfAPtHQ2dWmW7Bth3x2l6c5dzveelDj9z9wjff" +
       "nwdEEA2Fp9V/y6n27yRd1nSzhjkQ6+FMLMGLA81glDBi8xhm6JlkdzbbfmA5" +
       "INSvbiSUyLNXvrH46Lc+tU0WT9roCWDjfS/86g/2P/DC3pEU/ambsuSjONs0" +
       "PWf63hsaDqAn7rRKjkH902ee/aPfefa9W66uHE84m+B76lN/9T9f2f/IN790" +
       "i1znLhvsxo+9sdHdX2mXww5+8GNGE6O41hLemcYIW5taejIz2ZoYdxeW2YtJ" +
       "YTRaDFmlWGuKPmy0yxY/UjXTVt1prMZcvaSVwqCNFv2BtOguqOFwMCDQRVAO" +
       "UrxZNqkRPyL9DqV3iCGvkhNeUZojZTlFBnxBsIQV0YZXvqOvpkVtbJhIryXq" +
       "Tm3lFGEYZJsFuFatUNXqXPJia7zsbmgqTC15qBX0BeqbMs/P+VDSDML2lakQ" +
       "E4jb9xdYXC4v/YgKxnYoavNJx2GXKM8H1ApQCaU1Y/aChUlSQcVyEpJGcbE/" +
       "QltT3oiGClOxlO4yCtc23pE3Fq0M/MKEVTwnaMqtsUaxPUGc+b1O2RKFYZuv" +
       "sh1JkbWehkWLEhGZbXzOaSHcWMlie+jOlw2qRizYgiQOlwFFeOGwJk56quC4" +
       "LSGhLSup8NHKdWLCU2xYJlVZV6ersBKOsHjTIKTlJiDM/hLI15GlGcM3HbPn" +
       "Y9Wl3yJ1Xq5T6UhQmkXcUdqwzRg+QUfdsOu4gYZRfhEzYxudsJNBdUP3hjIW" +
       "YAM8iRqDMGG1ITXCUpRr9DpKi4xrTidRetEYjVQ+XGwouiQzdqVcLUxrc6K1" +
       "VHmpuOyHXL+DsWartU7J9cQ2B6lZ8Emr2RpKujGf1QibHCmpn1arLpeiBb/Y" +
       "c2ZIWA9LpKXynWV9xUfEuNwsKbOILXNSgY27szaNFKRJwcV7elxK9Pag1OYI" +
       "dKhSjDlpCEzHqGm0ON4sl+V1REpVb8nPkY1B4LIqUes506pKIEgPWKIn+mbH" +
       "atXlNYpXW26lTBYKHo77eFIYJeOuKhUsg6+5Au235Q6/KvoLMljIJslUm950" +
       "xPesJr3qDXRsxOD9uubWC3B5vIGtpNBkN8v1QDL67njNMYbFMXO/GXoDMV1T" +
       "7qRPE9Wma9Sn8yrXbJCr+Qav9bt1uIKpRF8tBuomxJw0WIutMdekHbsixHJh" +
       "pRXncFrlsFYflXDFDpd6u05rcs9BuU1v0sMpM154AiyJglNY1+tetOojMwyW" +
       "Qq03Kc65yB3UcKY5nOgh1UxGHWSwRgcuNSfn8yXd9lLPmrTRaQGjK4Ju0AO/" +
       "RstWjUhGXZYe+qg59Tg6tEjSqc7okj2sK6X5inbkCjYqo80hU8C6hGO0Ko3N" +
       "QsfYkrCyG1qXZztpwR7ri67ir6dSiW6SWqM3KzLFoek06OLG74TdRViRKlJn" +
       "soiKA5lapBWsAfsloTPpjiZiWPIdbyCgC0M2VEQaV/lqTS+y/KSBFmGODsot" +
       "btxvogRPokjHNkpzNFmsfL1SnJVBnJM8xXRVYtpcyUxqq0IxReg6GrfqCy5x" +
       "eqbT1pExJtTKsllN2y0S5IpTdjrU+24dBl6Dp1RxhYd0UpCqc23eNwdljipJ" +
       "brUSFkeVak2qq5jMi5mf+64scf3RpDx3cHq6MES94Gx6A6ufVFHC8IhaOhgO" +
       "2RYtWP7I1LXuoNTCly1tE5HVGS6spFULs7vB2PICl6/GYyrBqrCK1srWzGBm" +
       "FJYWfJypVTBn1iuRSqPmVe2pINXUeIjBBuLSxHo9JZqdQiLElCzElUYUWzMe" +
       "L4gFz6iy3Mqn6ohHwZMVT+GOQ3W6IYmU4pnRmazlep9UqvUOTjpaTwpxxUXo" +
       "sMSKaYGao12BJjlMrHEzi+mJG78XdjepViAxreDG6BpWXdxyQl3m8YhvwFWZ" +
       "lREY6+kIsvTWUUGrFmedwrSsrNcDQtOklo77syrC4HVxtiBWHrYSNwic9Ecb" +
       "LaWdmdSr+YNSDRZnJIsPY6LRQxC4uGkjJbPoD/tlt6qx1flYn6mK69C0MKy0" +
       "RVUfNF1VrcpYu9wsNwSO4NFSnTQRcximAad0Bm5hjqh6nNQrEjYu+mgZ7TQs" +
       "U28ZTKLO0CKm8jMYNuBgM7aaDnDmtFpfsXKJXU+76MqYmMKKFfvD8cZD5PJ0" +
       "5UlT0/FwsgXiFSrgyoKZdMgmWsJms7ISEekkIVoiLFTUVtFCC+XmsFzldUuN" +
       "GW7ZwI02PSdFrCwWuRoME0q9mbBruGPgHKvXqJpQ5Exw6vTHm8lkMNowlY0x" +
       "U8ohM0Kwco+TFhUY1obspFvfSMSwF+F+3BBdcTORND5pwZ1JzPIqJxG1am2U" +
       "jldqpEtqp92UaDYYpAVTpDpkpYX7rF2Li4irIdNaP6i3Q5oi6g1RXhK22Aw1" +
       "c10YuB2+u4Yn47mAaDpJB9qw1eotqeXSZGGxQ9ZhWEr95kaakzLWH6dKEsHh" +
       "CpFtKbTSZqGdLJXZuousJ2PNL7GSy9i+PIObxmJB8GJt7PAbPh4lVTjq0mxf" +
       "7Y+VUbO6Xpeobl9kGKTmjGt1dryqzblktJQEdrPphYVwQaJruopRfakpRK1m" +
       "FY/qXD8t19UmgqgDpIck9tIk3fq4QrhGC4nKuIDXpUBYDTx1U8JsGJxHSNdd" +
       "oTxR5DuJXBAXWsKuVu1e2UeSybghEqKF+kql1rDWSsP0Rr3uhIrHsL7UFkuG" +
       "7K8if9DwKp1aZC6n/caEhNMlHk8WBouX0nJp2uSmaEHC2fpy7VT5SokrOUzc" +
       "b6TaZEzPWKLUKNeqGFOY9TCOW2gTbd5bwrIwDoeYzAVoRwq7bRCTzYkgmRST" +
       "TFG/Jc7NkDLtJamOlH5zUbLt0tztxm2kR3cljGvZPIdQKqXEZhkd1HlbHaIM" +
       "R5a8dWMpLpbrZa3XCCf0xF+tmMGmMG1IZXkJ01pZ1yqmW9Q9dTAqst2g1IqF" +
       "Vop2xQ1WGIzxSs8tjgflxkpskKNZo1lOO2xzMa2Nept1e8TVRwNFmLdSi2Li" +
       "tlkP1SXimVahLwtpOQ4iX55GY6ZqGiO0wrkuMlewerk0mGstezo25XFPNSuc" +
       "V+C7Q6k08sdOqni1MI6can3cao+bpXEj1nAkpsN0MUjLmtldoAatF/mhUyrY" +
       "aVDkC9PiCmkFWGm8wtGA8/hZa4OhFBPUOGaALFeD0oSjpykqtteFcsnrDOQS" +
       "Is39NV0LSyVstfRajO/HAVad2kVNQ9oMVkUQm9DAtzMhGnzZ2mjlZaEhIF7S" +
       "sep4S4rX+lQCXqmMqFZg45Okws28WszJQXdEVWprv87rdhSjTLtRGaULnTDX" +
       "9ckIH3Vwd1O26wSMm8VlURlOJJgWhGpdGVUrS6mxKQn1gGPcySIR2O6AW7ST" +
       "uqzoXYFysBZGtFFGbetirVFKLKyfqv36hnZZEsHHvVaJjNIx7HANciw7w3gx" +
       "TDinOmUk3Y8419/M12mPEp2J14sJgTM2zSmzqc/0OTyctrvmeoUQgygWxx2T" +
       "Aul7ltYrP9qX1f35B+PhPcOP8am4nXoia95wWOPKf2dP1qaP1rh2lQco+0p6" +
       "5HbXB/kX0sefe+FFnftEYe9GxeZtEXQh8vyfso2VYR8hlX2pPnP7r0E2vz3Z" +
       "VRK+8Ny/PCy+xXzHj1CefewEnydJ/i770pdab9R+fQ86fVhXuOle5zjStePV" +
       "hIuBEcWBKx6rKTxyqNkrmcYeBs/jNzT7+K1LpLe0glO5FWz3/g4FsfUd5tKs" +
       "CSLofORtK3O5vexMJTxuKvccmsqpgxLelV2VgFsZQWDpxh2s6xZVqwi691gh" +
       "P6tKPnTTJeH2Ykv79IuXzr/mxeFf57Xsw8unCwx0fhrb9tEqzpH+WT8wplYu" +
       "74VtTcfPX78UQQ/drgAJvsWzV87uc1vw90TQA7cAB8o76B6F/pUIuriDjqA9" +
       "7dj0r0XQuRvTEXQatEcnPwiGwGTWfd4/UPTt70GO1UqTU8ed8XArr/ywOsIR" +
       "/33qmNflF7sHHhJvr3ava595ke6985XqJ7blec1WNpuMynkGOre9KTj0sidu" +
       "S+2A1tn209+/77MX3nAQEe7bMryz/SO8PXbrWnjT8aO8er35w9f8/pt/+8Wv" +
       "51Wq/wP1DFAicR8AAA==");
}
