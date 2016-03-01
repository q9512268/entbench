package org.apache.xml.utils;
final class SecuritySupport {
    static java.lang.ClassLoader getContextClassLoader() { return (java.lang.ClassLoader)
                                                                    java.security.AccessController.
                                                                    doPrivileged(
                                                                      new java.security.PrivilegedAction(
                                                                        ) {
                                                                          public java.lang.Object run() {
                                                                              java.lang.ClassLoader cl =
                                                                                null;
                                                                              try {
                                                                                  cl =
                                                                                    java.lang.Thread.
                                                                                      currentThread(
                                                                                        ).
                                                                                      getContextClassLoader(
                                                                                        );
                                                                              }
                                                                              catch (java.lang.SecurityException ex) {
                                                                                  
                                                                              }
                                                                              return cl;
                                                                          }
                                                                      });
    }
    static java.lang.ClassLoader getSystemClassLoader() {
        return (java.lang.ClassLoader)
                 java.security.AccessController.
                 doPrivileged(
                   new java.security.PrivilegedAction(
                     ) {
                       public java.lang.Object run() {
                           java.lang.ClassLoader cl =
                             null;
                           try {
                               cl =
                                 java.lang.ClassLoader.
                                   getSystemClassLoader(
                                     );
                           }
                           catch (java.lang.SecurityException ex) {
                               
                           }
                           return cl;
                       }
                   });
    }
    static java.lang.ClassLoader getParentClassLoader(final java.lang.ClassLoader cl) {
        return (java.lang.ClassLoader)
                 java.security.AccessController.
                 doPrivileged(
                   new java.security.PrivilegedAction(
                     ) {
                       public java.lang.Object run() {
                           java.lang.ClassLoader parent =
                             null;
                           try {
                               parent =
                                 cl.
                                   getParent(
                                     );
                           }
                           catch (java.lang.SecurityException ex) {
                               
                           }
                           return parent ==
                             cl
                             ? null
                             : parent;
                       }
                   });
    }
    static java.lang.String getSystemProperty(final java.lang.String propName) {
        return (java.lang.String)
                 java.security.AccessController.
                 doPrivileged(
                   new java.security.PrivilegedAction(
                     ) {
                       public java.lang.Object run() {
                           return java.lang.System.
                             getProperty(
                               propName);
                       }
                   });
    }
    static java.io.FileInputStream getFileInputStream(final java.io.File file)
          throws java.io.FileNotFoundException {
        try {
            return (java.io.FileInputStream)
                     java.security.AccessController.
                     doPrivileged(
                       new java.security.PrivilegedExceptionAction(
                         ) {
                           public java.lang.Object run()
                                 throws java.io.FileNotFoundException {
                               return new java.io.FileInputStream(
                                 file);
                           }
                       });
        }
        catch (java.security.PrivilegedActionException e) {
            throw (java.io.FileNotFoundException)
                    e.
                    getException(
                      );
        }
    }
    static java.io.InputStream getResourceAsStream(final java.lang.ClassLoader cl,
                                                   final java.lang.String name) {
        return (java.io.InputStream)
                 java.security.AccessController.
                 doPrivileged(
                   new java.security.PrivilegedAction(
                     ) {
                       public java.lang.Object run() {
                           java.io.InputStream ris;
                           if (cl ==
                                 null) {
                               ris =
                                 java.lang.ClassLoader.
                                   getSystemResourceAsStream(
                                     name);
                           }
                           else {
                               ris =
                                 cl.
                                   getResourceAsStream(
                                     name);
                           }
                           return ris;
                       }
                   });
    }
    static boolean getFileExists(final java.io.File f) {
        return ((java.lang.Boolean)
                  java.security.AccessController.
                  doPrivileged(
                    new java.security.PrivilegedAction(
                      ) {
                        public java.lang.Object run() {
                            return f.
                              exists(
                                )
                              ? java.lang.Boolean.
                                  TRUE
                              : java.lang.Boolean.
                                  FALSE;
                        }
                    })).
          booleanValue(
            );
    }
    static long getLastModified(final java.io.File f) {
        return ((java.lang.Long)
                  java.security.AccessController.
                  doPrivileged(
                    new java.security.PrivilegedAction(
                      ) {
                        public java.lang.Object run() {
                            return new java.lang.Long(
                              f.
                                lastModified(
                                  ));
                        }
                    })).
          longValue(
            );
    }
    private SecuritySupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JxwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aaezrWHX3+8+8ZR4z8968YZYOzP6gnQk8J06cpcOWxHvs" +
       "bHacOC08HC+xE2/xEjumw1axCCSg7bBUwHxoQVA6LKpApUJU06IWEKgSCFFa" +
       "qQxCrQqlSMyH0qq0pdfOf5/3HkIzbSTf2Peec+79nXvOucf3+okfQycDHyp4" +
       "rrWZW254SUvCSwsLvRRuPC24xLBoX/YDTW1bchAIoO6y8sBnzv30Z+8xzu9A" +
       "p6bQrbLjuKEcmq4TDLXAtdaaykLnDmpxS7ODEDrPLuS1DEehacGsGYSPsNDz" +
       "DrGG0EV2bwgwGAIMhgDnQ4CbB1SA6SbNiex2xiE7YbCCXg+dYKFTnpINL4Tu" +
       "PyrEk33Z3hXTzxEACWeyZxGAypkTH7pvH/sW8zMAv7cAP/b+15z/k+ugc1Po" +
       "nOnw2XAUMIgQdDKFbrQ1e6b5QVNVNXUK3eJomsprvilbZpqPewpdCMy5I4eR" +
       "r+0rKauMPM3P+zzQ3I1Khs2PlND19+Hppmape08ndUueA6y3H2DdIiSyegDw" +
       "rAkG5uuyou2xXL80HTWE7j3OsY/xYgcQANbTthYa7n5X1zsyqIAubOfOkp05" +
       "zIe+6cwB6Uk3Ar2E0F1XFZrp2pOVpTzXLofQncfp+tsmQHVDroiMJYRuO06W" +
       "SwKzdNexWTo0Pz/uvuxdr3MoZycfs6opVjb+M4DpnmNMQ03XfM1RtC3jjQ+z" +
       "75Nv/+LbdyAIEN92jHhL86e/9fSrXnLPk1/Z0rzgCjS92UJTwsvKR2Y3f+OF" +
       "7Yca12XDOOO5gZlN/hHkufn3d1seSTzgebfvS8waL+01Pjn8a+mNn9B+tAOd" +
       "paFTimtFNrCjWxTX9kxL80nN0Xw51FQaukFz1HbeTkOnwT1rOtq2tqfrgRbS" +
       "0PVWXnXKzZ+BinQgIlPRaXBvOrq7d+/JoZHfJx4EQafABT0PXL8GbX/5fwhp" +
       "sOHaGiwrsmM6Ltz33Qx/NqGOKsOhFoB7FbR6LpzIwGheuriMXK5dRuDAV2DX" +
       "n8MysApDgxPbyhUSwLymRL4ZbvjI81wfxB9gbt7/V0dJhvh8fOIEmIwXHg8F" +
       "FvAiyrVUzb+sPBa18Kc/dflrO/uusasrELxAb5e2vV0CveVTGVw61ht04kTe" +
       "yfOzXrezDeZqCbwexMMbH+Jfzbz27Q9cB8zMi68His5I4auH5fZBnKDzaKgA" +
       "Y4We/ED8JvENxR1o52h8zUYKqs5m7P0sKu5Hv4vH/epKcs+97Qc//fT7HnUP" +
       "POxIwN51/GdyZo77wHGd+q6iqSAUHoh/+D75c5e/+OjFHeh6EA1ABAxlYLFA" +
       "Y/cc7+OIAz+yFwwzLCcBYN31bdnKmvYi2NnQ8N34oCaf7Jvz+1uAjm/MLPoF" +
       "4Hr3ronn/1nrrV5WPn9rHNmkHUORB9uX896Hv/M3Pyzn6t6Ly+cOrXS8Fj5y" +
       "KBZkws7lXn/LgQ0IvqYBun/4QP/33vvjt/1GbgCA4sErdXgxK9sgBoApBGp+" +
       "y1dWf/fUdz/yrZ0Dowmh055vrkFoSPZRXr/nyFdDCbp78cGAQDCxgJ9lZnNx" +
       "5NiuauqmPLO0zEz/69yLSp/713ed3xqCBWr27Oglv1jAQf2vtKA3fu01/35P" +
       "LuaEki1mB0o7INtGyFsPJDd9X95k40je9M27f//L8odBrAXxLTBTLQ9ZUK4E" +
       "KJ81OMf/cF5eOtZWyop7g8PWf9TBDiUdl5X3fOsnN4k/+fOn89EezVoOTzYn" +
       "e49s7Ssr7kuA+DuOuzolBwagqzzZ/c3z1pM/AxKnQKICluqg54MokxwxjV3q" +
       "k6f//i++dPtrv3EdtENAZy1XVgk59zLoBmDeWmCAAJV4r3zVdnLjM6A4n0OF" +
       "ngF+axR35k/XgQE+dPUAQ2RJx4GP3vmfPWv25u//xzOUkIeWK6y1x/in8BMf" +
       "uqv9ih/l/Ac+nnHfkzwz8oIE7YAX+YT9bzsPnPqrHej0FDqv7GZ/omxFmedM" +
       "QcYT7KWEIEM80n40e9ku1Y/sx7AXHo8vh7o9Hl0OIj64z6iz+7OHA8rPwe8E" +
       "uP4nuzJ1ZxXbNfNCe3fhvm9/5fa85ARw15PIpdqlYsb/ylzK/Xl5MSt+dTtN" +
       "Ichvo5llAjc5FeSpJ+DSTUe28s5fFQIzs5SLez2IIBUF83JxYdVyUbeB5Ds3" +
       "qUwDl7b52zaqZSWSi9iaBXpVE/r1LVW+fN18IIx1QSr4zn98z9ff/eBTYF4Z" +
       "6OQ60zmYzkM9dqMsO37rE++9+3mPfe+deagCcaovFz/4+UwqdxXU2S2eFURW" +
       "kHtQ78qg8m7kKxorByGXBxdNzdFe05z7vmmDILzeTf3gRy88tfzQDz65TeuO" +
       "2+4xYu3tj73j55fe9djOoWT6wWfks4d5tgl1PuibdjXsQ/dfq5ecg/jnTz/6" +
       "hY8/+rbtqC4cTQ1x8ObzyW//99cvfeB7X71CDnK95T6LiQ1vvpOqBHRz78eW" +
       "phoSj5LE1nuN0CmkWKUlyITENSWxmSrWLBnIJbedzGcYOW0Ec8sTFDcto1FK" +
       "aLU1W/OShhrR7eWgQ/OLQYfpEGKdgAetTWfQXzG4IPWUcLmii8awNWK4gTET" +
       "VlRxqfM9Ui/SK6QqKGlUU2ta3Fjh6oQHD1293+/qLLzm1Ea97wSYNV2Scign" +
       "ZKAYvZUkcMnQKpeIwG4Lmm9jQrlZbXCaQzuVWhjBYg8d4HB7zS/Go75UY+SY" +
       "FzzLDYSu7g+b4hLpiJItIbHJBIk1nKMLnOSIUSkcFrq4gkRop0ovg01NnZlG" +
       "iwpiXMJLY6aDTZbz4cieJFLbNIZkwU4xXZiYDavaDOcrdykMGykTpKwdYhFp" +
       "94r8WGksqx1506rU5wHndcy1YZIp8Eq+JUamzC1kV8aGeHHBF4dlp9m0genS" +
       "uEIynr7q14KG18W6ww2prTYrMhqZtl/GS8xgiLuFubzSyoMNwSgbuIqZK8Zt" +
       "LSPJ9WR6LZuSOC9i4Ka+8EZBP5qCHiwkHUWYP0JbE56ZSaaZqBankunc40b2" +
       "Zq1wVHvlMkKkY1062iwNf9UIFpWQ8+NA03VZsKebsRsZDXGDuDpSqeB2tR3z" +
       "WL3JezSWYNgkKXDLsttYiWKrQqXE0ucWC8uf+QJlDRJhQDA2hsULT+gtqIo9" +
       "R8cubg/SkcGIGLepmOPKSLThjUF3qPlwSibJ1JB41W/VcYxbxRzfa8W6HHTk" +
       "CRYYvqN6gwa96S42JWk+7zgWP+pQIZfwHr8iMWvgCLjQqtrtClZJ+tRA4Ll5" +
       "iSv22ojoNr245FPFRVNjMLKDOr7n2jS9arsoTsad4aRXnzKxIJO2NiwGEaym" +
       "UrieuW7Bs0tSox70lMpyyCNwsoxXyjJdTZWliVNNrC7gq3BGc7WFUVK6BYNu" +
       "VRauKhXZtIhwCCUupt3JcFCsw/1Bo5kG9LDT5WWFnFpIwSuXUbG4lrqmV0yn" +
       "/LTuc0u0VBmHo5lcXHi47UrcMJWkYA6WEguGS+tKipKNAtFL2s2RJYyWduyW" +
       "PIYvrDYDN+kO2yPSMwXN4FcMacNOpYS4FFtZBEsPnxXrpjRkZWPkimVjMiiQ" +
       "hWaniQckPmwVmJlokFO4is57da1QXBjNTkx37bjftZh+rWJvaJ4KOzxDx5bP" +
       "rVaEW5FJr6d3pgJFkWxbTRJS5RElsZvFFTzDay4Smmpx1p0XPb9lY9IgGXMj" +
       "oV2VhXZToDB9NOyQAq1Wi2svsqfNpEmkRbiht6vjadIfL/pG3a0k6LpDYE0z" +
       "nfq8F0ucZlXkZZ9KJ70krPBTTtXigGbnLTkiEtI1xjTiF+cJKi65AlVqLLsW" +
       "SAtaYbE7SDQMIcsgj9F9E6lhqTaZM47nVkfNbrurWg7HhcLaiKWaB2JIgKro" +
       "zGpUes4aX/SL/KApmKTD9uYMSNxwXJu6o+USC0i32LHmw/o0rky4eS2tDUq0" +
       "M2yma0SXJus4KWukwm1MPAk0b0CgSsyzYrWcBlq5EIKMEy3B0yWTUljqr9k2" +
       "8NLNlCUrRa00WRFCxQ75WputTzVnvEjcEk0PjXazM5CppjQqaapOm0YjVM3E" +
       "Diy+GTedLk8CTanLVhc3KYwsj6oaiYjAhKeVXmeFGlgq6Y6GylRdUGYztTVF" +
       "NkawbNjcMHa1ag3WPLRRr8EqHEkwNhvW2ZJcS9c0POhaiisF6Urrtj11lMRR" +
       "EaeLVKlCO35QHUaU6rC1ZsW1CsNpII2LNaPdGtAKVk+4caNWbhRhdSiukV5K" +
       "MBPfmCcMtrQcr70pVYpzozO1jV4StccduWmnvVSeWFJr1hvhKa2Nmot06TRE" +
       "tlRuVMJCvzQ3sFEHo8JVT1SR2bxBNbxmw4dLZq9sL+Yzpy70RnOlaBRjvEqt" +
       "qHrZx2KyG1CFJSYm0zocl+r4km4YhCpQplKXTLrXjBg5QmGWKsxCfVpNWiVH" +
       "kPxV2G+sWxPM6guUv6mulFQtJ9UKP9NnkxmPElOk25jNDApJpvZSRjC1StdL" +
       "9qxZaZX1koDUUNUtpmrLrTVigmwLHBVwPEZ7sy4XV+moU4MRxK7LqlWPBjra" +
       "I4hBkerBeJkLB8x0XuYkZd5fzUrqoM6gEjoeEH1sOBqh8YKrE4XZRMRV3kvS" +
       "WX2qzPQahQzR/iQSR0wH9daCpsDWmkB643CMLKcTy2uJPja3ExjurHFtghT4" +
       "DdLyXGBGwdxWSS+pwH3DWfdmJRlttkoIryKtDb9MYdgo1+qsoy8WdtnuGcvV" +
       "qioHI25Jj0qoKwY9wXS6Cy2dcmtmUw2jScdH6Z6DWjPLcCbkSraaRbISUizf" +
       "aNfSpEDAzkyHyWIP9ZJeRFCrdp2lYF7XZ11BiZYeHNf1hDd6pr5OmdoIBTGP" +
       "WIxohnNXeGVdSnsDpDxNhjO+KyAjrzI2y2IYyX1bEjlmjG1q3aLguAxBtqYJ" +
       "2ioRiV9jbKNGy02FCbVKp9xxzQrewldkEC0oZi11rNIGi6rGQhwGKrmGx3CU" +
       "CP64rlVDRGqHc1LrMmpBpkHK4y2Uib1kBLMy19m0M5aaZaU9lrAuVVowpshY" +
       "BZDsdestqa9MWvUWyVdW3WKszYsE319iqDEVYzy1RmuwUE1Uwpw3cZQUCVdq" +
       "aeNoJBuLQXE9R8ZVJnDK1U6Ll22jTiD1oU+1uElYBIHY7hLLrtO3LbIjL/oI" +
       "SF5m602UzgdLyloP1bje2bC1AVgFkfGMjWysGBkrRTRWWifeECsXR9CFzowW" +
       "Ca8ECg5LXkj0WHlC9ho0XxQdDjU2vSCSmIjFMYXerPiGKBB40xHnA4p1SxEb" +
       "ogkW+S22PluMW4bIkvyoKnVlueNSdArrBlqotVOll65XKB1Ipc3UczqySy2I" +
       "hcqMRXrKIlNM7DQwkdHmeE3pjrDSjJwP+63e2Gr1wUK9GJQ42qjOIqWKLk2E" +
       "Sax0bHemlo8UUZI0uHRpyq4/HuPEplYbzXF7YXgb3K6PaXFUQcvlll9DYDZJ" +
       "ddmbMvVRLFii368VzXpZT9KFOVKIDRJvklrRX5WsNcauIkEYtecBbKSx3tcb" +
       "C6wbVKpIKwrWIbJamGnHwtWiMxbLm8p6xNW6RBuHR7og1Mttvd9OyDrKc31O" +
       "sOowt3BcuU8NVQkk5wmrBJ5SW9hmas5wSSn1i2k8ZFm64zQotK7bjFiu1BXF" +
       "WK/GS2HCcmQXLxpjrsgQq42JNkEqjclxIRrAjaRU92M1ikTEpVeTjlbqLTto" +
       "VdXQ8Ww1ICeMl7apXiOuoZEheORanKm82qtI/VriJwUMbxdwVCaccqwta8MV" +
       "6anlDleqBJVkORmvm9KEddpcG5tO0yEaWaPBsqcpgThjJ2mprLMlsuIi/kpi" +
       "K5ZeGLdrqi4Ym2J3DJMjq7FQZRvtdcRoNKmK6bIxAqkN11/XQ5Zilrw8HFUm" +
       "m47VaVdYhQixAabSg2i2ESv2zFNQXdwQzkbU47kTSDrMNdabrluuiq64kMLW" +
       "pNHr2FVZTgYENfToojKm7MIQs5ujZa3fqzqmluDYRArbcDkK5kPH4RyDKE1i" +
       "XpzGEgu36xTiTYUKEzN4FCxDJKk2ClrLG03sIYHFhdRfcM1mnR/KGKePrWQw" +
       "riB+HbPRmeqsxTZaombR2CeMpF5zokISU1Ozny4GjbTUEzki2CSSUxaqCHgZ" +
       "mRlxa0SDl5QhVu96YdgV45ZKh/KkRBCprS5nm2Swqgh6p82L6zitBWtY68l+" +
       "BdUTuewWrWEwXMZVNSIxGWcneqFFWWCeMZKe8Lq2cMkkoohuzRSG5pQea3Gz" +
       "xUpaYiJ8Ylve3DJb8bTdaE9tER1Hcs/tCXoTtaR0DmaNd+Pugg3Ejc9Edq8Z" +
       "1yyyV2uv24oiMiOjw6q9qKrPOvWUoSbAmKrdmlOGDQ2dLAyJSWLwIvjyl2ev" +
       "iK/55d7Sb8k3JPZPl8DLedZA/xJvp8mVOzyx7WZ/azP/nTx+RnF4a/NgvwvK" +
       "3sHvvtoxUv7+/ZE3P/a42vtoaWd3n1AKoRtC13uppa0165CoM0DSw1ffa+Dy" +
       "U7SD/asvv/lf7hJeYbz2l9iWv/fYOI+L/CPuia+SL1Z+dwe6bn836xnne0eZ" +
       "Hjm6h3XW18LId4QjO1l372v2jkxjLwHXw7uaffjKW+NXnyZiaw3X2IaNrtEW" +
       "Z4UXQrfNtXD3qDWfK9aVVc3f29m67WCf6XhrbmKrX7QBcrjbvMI+qoECuGq7" +
       "Gqg99xr47Wu0vSUrXh9Czwca4DdBqNmHIGZtmwOcb3gucGK7OLHnBueJA4JN" +
       "TvDua4D9nax4xxYs8ATNCa8O9p3PAuyFrPJBcAm7YIXnHCydE3zwGmA/nBXv" +
       "A2Fyf2b7vpt/C5DzHyB9/7NAmh1rQS8F16t3kb76OUW654E35h5oupcI09Jy" +
       "ho9dm+HuwwxdNyTcyFHxRNG8LCTmEv44K/4ghC4A/WRUtONFIR/62m6AvC3c" +
       "PVnZlXK8PdfdHz5bl8gCnrWrO+u50d1OTrCT2/OBqfzZNUzlC1nx2RC6Fagi" +
       "+0ok2/huBkd1ceueLq6oh889Cz3cmlXeB65Hd/Xw6HPuLR/PCb58DRV8NSv+" +
       "MoRu2rUGPDGDMMhJhVz4dtSTEDo9c11Lk50D8F96FuBzsnvB9dZd8G/9PwL/" +
       "7WuA/05WfCOEzgHwhw88surxAc5v/jI4EyDu2LcJ2Tnrnc/4Dmr77Y7yqcfP" +
       "nbnj8dHf5sfz+9/X3MBCZ/TIsg4fix26P+X5mm7mGG7YHpJ5+d9TIMZf6WuJ" +
       "EDqZ/+ej/e6W9vshdPNR2hC6DpSHaf4phM4e0ITQqe3NYZIfAC5Akt3+0LvC" +
       "mdj2VDA5cTRX3NfthV+k20Pp5YNHksL8+7O9BC7afoF2Wfn040z3dU9XP7r9" +
       "akCx5DTNpJxhodPbDxj2k8D7ryptT9Yp6qGf3fyZG160l7DevB3wgWEeGtu9" +
       "Vz6hx20vzM/U08/f8dmXfezx7+ZHdP8LCrxZphgoAAA=");
}
