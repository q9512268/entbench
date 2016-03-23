package org.sunflow.core.filter;
public class LanczosFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return sinc1d(x * 0.5F) * sinc1d(
                                                                     y *
                                                                       0.5F);
    }
    private float sinc1d(float x) { x = java.lang.Math.abs(x);
                                    if (x < 1.0E-5F) return 1;
                                    if (x > 1.0F) return 0;
                                    x *= java.lang.Math.PI;
                                    float sinc = (float) java.lang.Math.sin(
                                                                          3 *
                                                                            x) /
                                      (3 *
                                         x);
                                    float lanczos = (float) java.lang.Math.
                                                      sin(
                                                        x) / x;
                                    return sinc * lanczos; }
    public LanczosFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39/4C8wEALmyyCZwF1oQ9vINAU7djA5GxcT" +
                                                              "1JqWY7w3d7d4b3fZnbXPJrQJSgVtE4oIEFo1/ouoSZQEVDVqqzYRVaQmUdJK" +
                                                              "iaJ8tAqp1EqlH6hBlZI/aJu+N7N7+3G2EVVz0s3tzbx5896b3/zem33mKqmy" +
                                                              "LdLBdJ7gUyazE306H6aWzTK9GrXtPdCXVh6roP/cf2XozjipHiVNeWoPKtRm" +
                                                              "/SrTMvYoWaHqNqe6wuwhxjI4Y9hiNrMmKFcNfZS0q/ZAwdRUReWDRoahwF5q" +
                                                              "pUgr5dxSxxzOBlwFnKxIgSVJYUlye3S4O0UaFcOc8sWXBsR7AyMoWfDXsjlp" +
                                                              "SR2kEzTpcFVLplSbdxctcptpaFM5zeAJVuSJg9oWNwQ7U1vKQrDmYvNH10/m" +
                                                              "W0QIFlJdN7hwz97NbEObYJkUafZ7+zRWsA+Rb5CKFGkICHPSmfIWTcKiSVjU" +
                                                              "89aXAusXMN0p9BrCHe5pqjYVNIiT1WElJrVowVUzLGwGDbXc9V1MBm9XlbyV" +
                                                              "Xpa5eOa25OnH9rf8uII0j5JmVR9BcxQwgsMioxBQVhhjlr09k2GZUdKqw2aP" +
                                                              "MEulmjrt7nSbreZ0yh3Yfi8s2OmYzBJr+rGCfQTfLEfhhlVyLysA5f6rymo0" +
                                                              "B74u9n2VHvZjPzhYr4JhVpYC7twpleOqnuFkZXRGycfOe0EAptYUGM8bpaUq" +
                                                              "dQodpE1CRKN6LjkC0NNzIFplAAAtTpbNqRRjbVJlnOZYGhEZkRuWQyBVJwKB" +
                                                              "Uzhpj4oJTbBLyyK7FNifq0NbTxzWd+hxEgObM0zR0P4GmNQRmbSbZZnF4BzI" +
                                                              "iY0bUmfp4heOxwkB4faIsJT56f3Xtm3suPSKlLl1FpldYweZwtPK+bGmN5b3" +
                                                              "dt1ZgWbUmoat4uaHPBenbNgd6S6awDCLSxpxMOENXtr9668+8DT7W5zUD5Bq" +
                                                              "xdCcAuCoVTEKpqox6x6mM4tylhkgdUzP9IrxAVIDzylVZ7J3VzZrMz5AKjXR" +
                                                              "VW2I/xCiLKjAENXDs6pnDe/ZpDwvnosmIaQGvmQjfKuI/IhfTr6czBsFljTV" +
                                                              "5LBloOt2EshmDMKaT9qOntWMyaRtKUnDypX+K4bFkrAsQCaZAiKaNux+8S+B" +
                                                              "0DI/DaVF9GThZCwGQV4ePeIanI4dhpZhVlo57fT0XXsu/ZqED0LejQEn62C5" +
                                                              "hLtcApdLyOUSoeVILCZWWYTLym2ETRiH4wx82tg18vWdB46vqQD8mJOVEEEU" +
                                                              "XRPKK73+mfeIOq1caFswvfry5pfipDJF2qjCHaphmthu5YCAlHH3jDaOQcbx" +
                                                              "iX9VgPgxY1mGwjLAO3MlAFdLrTHBLOznZFFAg5eW8AAm504Ks9pPLp2bfHDv" +
                                                              "N2+Pk3iY63HJKqApnD6MDF1i4s7oGZ9Nb/OxKx9dOHvE8E97KHl4Oa9sJvqw" +
                                                              "JoqDaHjSyoZV9Pn0C0c6RdjrgI05hdMDRNcRXSNEJt0eMaMvteBw1rAKVMMh" +
                                                              "L8b1PG8Zk36PAGgrNu0SqwihiIGC0784Yj7+7m//8lkRSY/+mwN5e4Tx7gDl" +
                                                              "oLI2QS6tPiL3WIyB3Pvnhh89c/XYPgFHkFg724Kd2PYC1cDuQAS/9cqh9z64" +
                                                              "fP6tuA9hDjnXGYPSpSh8WfQJfGLw/Q9+kSawQ9JFW6/LWatKpGXiyut924C+" +
                                                              "NDjyCI7O+3SAoZpV6ZjG8Pz8q3nd5uf/fqJFbrcGPR5aNt5Ygd9/Sw954LX9" +
                                                              "H3cINTEF06cfP19McvJCX/N2y6JTaEfxwTdXfP9l+jiwOzCqrU4zQZJExIOI" +
                                                              "DdwiYnG7aO+IjH0em3V2EOPhYxQoc9LKybc+XLD3wxevCWvDdVJw3wep2S1R" +
                                                              "JHcBFttE3CZE2ji62MR2SRFsWBIlqh3UzoOyOy4Nfa1Fu3Qdlh2FZRWoIOxd" +
                                                              "FpBkMQQlV7qq5ne/emnxgTcqSLyf1GsGzfRTceBIHSCd2Xng16L5pW3Sjsla" +
                                                              "aFpEPEhZhMo6cBdWzr6/fQWTix2Z/tmSn2z90cxlAUtT6rg1qHC9aLuw2Shh" +
                                                              "i4+biqVgiU/1PMEK6IyJ56WcLCnLCTILYGBXzFWkiALr/NHTM5ldT2yWpURb" +
                                                              "OPH3QV377Nv/fj1x7g+vzpKJ6rhhbtLYBNMCNlXgkqFMMijqN5/N3m869cef" +
                                                              "d+Z6biaJYF/HDdIE/l8JTmyYOylETXn56F+X7bkrf+Am8sHKSDijKp8afObV" +
                                                              "e9Yrp+KiWJWpoKzIDU/qDgYWFrUYVOU6uok9C8RpWlsCSCviYakLEg8sodMk" +
                                                              "iVugDZu+0lSBw/p5ps5DFl+ZZ2wUmxFOanKMjwALhYsJ3NsRZ8yGxK8WIBlM" +
                                                              "uJXuZ4YPKMc7h/8koXfLLBOkXPuTyUf2vnPwdbFJtYiKUmgCiAD0BFJYCzYJ" +
                                                              "hH/XPPfGsD3JI20fjP/wyrPSnmiZHhFmx09/55PEidPyWMi7zNqy60RwjrzP" +
                                                              "RKxbPd8qYkb/ny8c+cWTR47F3VjfyzHdGpSXdiJWquAWhWMoLb37282/PNlW" +
                                                              "0Q/HbYDUOrp6yGEDmTDkamxnLBBU//LjA9C1GXMoJ7ENHrl9AZs98nnr/8ir" +
                                                              "2NFjiv5dYZgvcvHq4fYmYT7X1AiU48KQOP7dLxqh2p4H8A42cI2qAMCLGX4s" +
                                                              "jE8hFm3ekW9yHWqaJxZlCQbOpWmpE1DkFMMhaphHY8T5mJ+rZHSOzhOdh7A5" +
                                                              "DOWYrerK5kwkQPf/PwJU5IDT4H0Hk/PSspcm8qKvPDfTXLtk5r53RMYpXcYb" +
                                                              "gU2yjqYFzkHwTFSbFsuqwqFGWdCY4ufh2dKtvIJxfC2CD8Ls70r573HSEpXn" +
                                                              "pBJ/gmKnOGkIiHE8k+IpKHQGIAdC+HjW9JJ/i6hJ8E1IQl77i7HyukOEvv1G" +
                                                              "oS9NCRbhyJvirZVHLY58bwXXwZmdQ4evfe4JeQlQNDo9jVoagFDkVaOUNVfP" +
                                                              "qc3TVb2j63rTxbp1Hs+FLiFB2wQAAIuiYF8WqYrtzlJx/N75rS/+5nj1m8DQ" +
                                                              "+0iMcrJwX+CdkYwUlNYOlCv7UuXECRWGKNe7u34wddfG7D9+L0o6l2iXzy2f" +
                                                              "VkYffXfg4vjH28RrkiqgcFYcJfWqffeUvpspE1aIhZsQjRTfX4k4uOFbUOrF" +
                                                              "2yAna8ozS/kdGsrdSWb1GI6ecXm8we8JvT7zCg3HNCMT/J5AMs1J6sfoA/7S" +
                                                              "qUHT9K5Sb5viQOZnI4q8mPyUeMTm6f8CHljN/8AWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mp/Zaj3r/izw2CjPFAGGYbmyndN5MgYWY6vX9n2UB5kjUPG1ud3Iybwa5Mq5" +
       "dWTC7G7TrW2sytrKlou8X7+tNVzf5xXs/j2HxCgPZG4f/Mdnvvarr/0W2CIS" +
       "OrvK1Ad25siK9DJLZn/lhY889Ipnv/3BPACB6MM99V7vXRnV/p0kzppO1nT3" +
       "RX0wE5XzlqGqU3IUD/I4oWu5tHe0TDa0HBBaV3uZGvz01W8tPv6dz2yzsJNm" +
       "eAJYf/+zH/jR7oee3TmS+772pvTzKM42/82ZvntPwyH02J1WyTGwf/rc03/0" +
       "O0+/b8vV1eOZXBccVD7zV//9td3nvv2VW6QWZ2zvJ9jY+K7n8GpEtPZ/FC8a" +
       "QjJJU8FgKk24iiJJt0U56zUqJVjJGzZXBN2aNLR5q9ZL1XGJDASxkVS0hlZV" +
       "KobkKlOWDIckN+PjbtUjuphXgr2lx0nDLt/hg2Ajjnh56Ew0sm/JJBK3Ar/U" +
       "DWy8brZtiYBlclmgG3SjUOmVuzy/KUaVeKOkNaRZVyrwRncqFacfOGtKo9oa" +
       "2ZhN1vKmWynW8bosbMb9Zi+cxqyGTnmzHnosrBrlqbeZWz5u8bQueGw/Hjkw" +
       "F44HK9ETZDygA72eLBMznRNVsWladDhw+phKGxJXDGCplWijyUgXOiNPNhOs" +
       "FviTWVjTUi5NN0zbTjC3nxIzjifFib3WK1yVKU5kTGVUJBKm7WjUaK0HnmB0" +
       "ptHc9rlRedHdjH0V4ynf5hQtVWPVj30ZG9Q2eovklxw5a3oCnQwbk9KqPww7" +
       "jrii8VIRdoTikMBsUqMbZrJpNmilyygiuZjIhtQobEZC1CqMlBrax3oLAsVZ" +
       "zjEIYaz2LY6fT5CmPG0to+mALvrNdojies0P5iJPE9a4JHRtMuS9hJ9sqF7S" +
       "6yhTtcmXBm2nObWVNT/15ZrOyOUa4+LN0ECWBFGc10iHHzXbajpMZtHA8tL2" +
       "kDfNuR0Wm4tyT5po/SApy+ygu7SdeRg3XE4Jdam4NiuiYSFRmXHETZsMC2EP" +
       "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" +
       "mysnIQAA");
}
