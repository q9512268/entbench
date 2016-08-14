package org.apache.batik.dom.svg;
public interface ExtendedTraitAccess extends org.apache.batik.dom.svg.TraitAccess {
    boolean hasProperty(java.lang.String pn);
    boolean hasTrait(java.lang.String ns, java.lang.String ln);
    boolean isPropertyAnimatable(java.lang.String pn);
    boolean isAttributeAnimatable(java.lang.String ns, java.lang.String ln);
    boolean isPropertyAdditive(java.lang.String pn);
    boolean isAttributeAdditive(java.lang.String ns, java.lang.String ln);
    boolean isTraitAnimatable(java.lang.String ns, java.lang.String tn);
    boolean isTraitAdditive(java.lang.String ns, java.lang.String tn);
    int getPropertyType(java.lang.String pn);
    int getAttributeType(java.lang.String ns, java.lang.String ln);
    java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    long jlc$SourceLastModified$jl7 = 1471188908000L;
    java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZe2wUxxmfO+O3wQ9eDmDzMqg8epekpVIwhdjGBpMzXDFQ" +
                                          "1TSc5/bm7hbv7S67c+YMoaJIVZxKoYhCkkYJf7REJFUSUJX0oYaIKGqTKGmq" +
                                          "BNo0bUkipWqTtKhBldo/SJt+38ze7d76fJFaDmnHe7PffPPN73sPT14j1bZF" +
                                          "OpnOQ3zCZHaoX+dRatks0adR294FczHlwSr6j30fbL8jSGpGyKw0tYcUarMB" +
                                          "lWkJe4R0qLrNqa4weztjCVwRtZjNrHHKVUMfIXNVezBjaqqi8iEjwZBgD7Ui" +
                                          "pJVybqnxLGeDDgNOOiIgSVhIEu7xf+6OkCbFMCdc8nYPeZ/nC1Jm3L1sTloi" +
                                          "++k4DWe5qoUjqs27cxZZYxraREozeIjleGi/ts6BYFtk3RQIll1o/ueNE+kW" +
                                          "AcFsqusGF8ezdzLb0MZZIkKa3dl+jWXsA+QbpCpCGj3EnHRF8puGYdMwbJo/" +
                                          "rUsF0s9kejbTZ4jj8DynGlNBgThZWszEpBbNOGyiQmbgUMeds4vFcNolhdPK" +
                                          "U0454uk14VMP7mv5URVpHiHNqj6M4iggBIdNRgBQlokzy+5JJFhihLTqoOxh" +
                                          "ZqlUUw85mm6z1ZROeRbUn4cFJ7Mms8SeLlagRziblVW4YRWOlxQG5fyqTmo0" +
                                          "BWed555VnnAA5+GADSoIZiUp2J2zZMaYqic4WexfUThj111AAEtrM4ynjcJW" +
                                          "M3QKE6RNmohG9VR4GExPTwFptQEGaHGyYFqmiLVJlTGaYjG0SB9dVH4CqnoB" +
                                          "BC7hZK6fTHACLS3wacmjn2vbNxw/rG/VgyQAMieYoqH8jbCo07doJ0syi4Ef" +
                                          "yIVNqyMP0HkXJ4OEAPFcH7Gk+ck91+9c23npZUmzsATNjvh+pvCYcjY+641F" +
                                          "favuqEIx6kzDVlH5RScXXhZ1vnTnTIgw8woc8WMo//HSzl9+7egP2V+DpGGQ" +
                                          "1CiGls2AHbUqRsZUNWZtYTqzKGeJQVLP9ESf+D5IauE9oupMzu5IJm3GB8kM" +
                                          "TUzVGOI3QJQEFghRA7yretLIv5uUp8V7ziSE1MJDAvB8hch/i3DgJBZOGxkW" +
                                          "pgrVVd0IRy0Dz2+HIeLEAdt0OA5WPxa2jawFJhg2rFSYgh2kmfMhYWTC9ngq" +
                                          "3J/jICQERouqvEcBWjuEhmZWfoscnnL2wUAAFLDI7/4aeM5WQ0swK6acyvb2" +
                                          "X3869qo0LXQHBx9O1sKuIblrSOwagl1DsGuoxK4kEBCbzcHdpaZBT2Pg8RBy" +
                                          "m1YN371tdHJZFZiYeXAGopwTLrgw/wMW+qQUzv7lYfPR373+4ReCJOjGhWZP" +
                                          "QB9mvNtji8izTVhdqyvHLosxoLv6UPS7p6/du1cIARTLS23YhWMf2CAEVghQ" +
                                          "33r5wNvvvnP2SrAgeBWHYJyNQ07jpI7GIZJRhXNSXwhJ8mBzPoV/AXj+gw+e" +
                                          "ESekebX1OTa+pGDkpumBIyDe2yFjTKsAD/CIXcd0oUOEvbPHTp1J7HjsNung" +
                                          "bcXu2A/Z5qnf/vu10EPvvVLCBuq5YX5eY+NM8wjYgFsW1Q1DIqrmc3BMuTrr" +
                                          "5Ps/60r1BsmMCGkDhLJUwwqgx0pBblHGnPDbFIdiws3pSzw5HYsRy1BYAlLK" +
                                          "dLnd4VJnjDML5zmZ4+GQrzgwtq6ePt/7RX/p2EcLdm1MjwqT82Zw3K0akg+u" +
                                          "jGLeLeTXxT74/SyfGHrylS0rlZNBkXIwfJdIVcWLur2KgE0tBrlVx+PgzEzY" +
                                          "dJnfq/1oxZTVS+izsYtHuoQW6iHvcgpxElJap3/zorTRnXc13KoOQEgaVoZq" +
                                          "+CkPeQNPW8ZBd0aEm1Zp+WAgTWjo8+FZ6gRW8Re/zjNxnC/Dk6DvFONSHLqE" +
                                          "dQXxdQUOKwXZ58DaVrreDJlAg1CJGunarYPa1aRK4xrDOPNJ84rbnv3b8RZp" +
                                          "yBrM5FW09rMZuPO39JKjr+77V6dgE1CwEnEjjksm09tsl3OPZdEJlCP3zTc7" +
                                          "vvcSfRQSJSQnWz3ERL4JFLt3i1iJRUdIFh3iuH3i80Yx9iJsTojE31twWM9J" +
                                          "IxTioG9RXIEIy1xfRKMfzkJYilpqBkLiuFMI3B4dVSa7on+SMeCWEgsk3dzH" +
                                          "w/fveWv/a8L669A9CzbncT5wY4/eW4SWMA6tKlNWF8sTPtL27tgjHzwl5fFX" +
                                          "MT5iNnnq25+Gjp+SapWl3vIp1ZZ3jSz3fNItLbeLWDHwl/NHfv74kXuDDt4h" +
                                          "TmrjhqExqhf0kVciZKxiFKWsm+9rfu5EW9UA+Nwgqcvq6oEsG0wUe3OtnY17" +
                                          "YHWrQ+nbHqkxaXASWG2aeICuaeD1NBAx5cSVj2fu+fj56wKs4g7EmziHqCnx" +
                                          "acWhG9nP96furdROA90XL23/eot26QZwHAGOIuvssKB6yBWlWYe6uvb3L7w4" +
                                          "b/SNKhIcIA2aQRMDFGt9qNggaDA7DYVHztx0pwwMB+tgaBEGTqaY/JQJ9LfF" +
                                          "pT25P2Ny4XuHfjr/mQ3nzrwjUrZMq7cXByZ8WekEppX/V2Aq9tSgS7VZDIIq" +
                                          "WcafRS1KoZAAfxYpHX/fJUi/ikNcQjDyP6KFE6MlIVgCzxoHgjU3EQLHOdzT" +
                                          "22VOn8UB2oc5aiGY9ehqhnKMxj4kjEohgZnpVgeJWytuDEfLwHEMh8McL00K" +
                                          "9x/T4nFPpfDohGedg8e6SlrG/WWg+A4Ok1ApeywjkRCx2ofDfZXCYTE86x0c" +
                                          "1lfcLh4uA8YjOJzmZLbXLkqj8UCl0OiAZ5ODxqaKo3GuDBpP4PB9TlpVGTGn" +
                                          "9ZAfVAqLhfBsdrDYXHEsnimDxY9xOA95PY9Faau4UAEkkIWo8Lc5SGy7iUhM" +
                                          "iRUvlAHhRRyeAxBSjOeDRaExGRTs5aEinvcoJ1Wqc73q23F3zkXuYqWQa4cn" +
                                          "6iAXrbgNXS4D329weB2aEYCvEF7ytegvXCh+fTOgyEEUK3F3hGVd+5Q7anmv" +
                                          "qjx9prlu/pndb4kmtnD32QTdSTKraZ6q2lth15gWS6rigE2yyjXFn6uctE93" +
                                          "qQImAaMQ/Y+S+j2oTUpRAyWMXsr3AUA/JSfV4q+X7s+cNLh0nNTIFy/Jh8Ad" +
                                          "SPD1Iyj7Zbe40Aus0Mfcz9KH52pteVHfIP7PIN+3ZOX/GsSU82e2bT98/UuP" +
                                          "yZs2RaOHDiGXRuhWZPvvNHzeNsrPLc+rZuuqG7Mu1K/It1GtUmDXrhd6DHAU" +
                                          "/M5EC1jga6TtrkI//fbZDc//arLmTehA9pIAFMyz93pu7OX1NHTjWYt07I1M" +
                                          "7cr2UEt0+N2rHp7YuDb59z+I3oDILm7R9PQx5cq5uy+fbD/bGSSNg6QaOkSW" +
                                          "GyENqr15Qt/JlHFrhMxU7f4ciAhcVKoVtXyz0FgpNvYCFwfOmYVZvLHhZNnU" +
                                          "RnbqtRf0UQeZ1Wtk9QSygaax0Z2RmvFdGGVN07fAnfH07rtkUERtgN3FIkOm" +
                                          "mb+orLpsCrfdXTpK4nhDvOLwyX8ByrpvZU8cAAA=");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1471188908000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAALVaedDsWFXP+946b5b3Zh+H2XlMOWT40nu6ecCQ7qSzdHpL" +
                                          "0ltQ3qSzp9PZ051uHAQUQagC1GGxhPlDoRBqWFwoLSl0KEuWArWwEJVSoNBS" +
                                          "ESiZP1xKVLxJf9v73jJFPV9X5XaWc889v7Pde0/y7Peh42EAwZ5rr3TbjbbV" +
                                          "JNq27PJ2tPLUcJthyz0pCFWlYUthKIB7F+RHPnnm33/4LuPsFnRChG6XHMeN" +
                                          "pMh0nZBTQ9deqAoLndm/S9jqPIygs6wlLSQkjkwbYc0wOs9CNx7oGkHn2F0R" +
                                          "ECACAkRAMhEQbJ8KdLpZdeJ5I+0hOVHoQ6+HjrDQCU9OxYughy9m4kmBNN9h" +
                                          "08sQAA6n0ushAJV1TgLooT3sG8yXAH43jDz93tee/e2j0BkROmM6fCqODISI" +
                                          "wCAidNNcnU/VIMQURVVE6FZHVRVeDUzJNteZ3CJ0W2jqjhTFgbqnpPRm7KlB" +
                                          "Nua+5m6SU2xBLEdusAdPM1Vb2b06rtmSDrDetY91g7CZ3gcAT5tAsECTZHW3" +
                                          "y7GZ6SgR9ODhHnsYz7UAAeh6cq5Ghrs31DFHAjeg2za2syVHR/goMB0dkB53" +
                                          "YzBKBN17Raaprj1Jnkm6eiGC7jlM19s8AlQ3ZIpIu0TQnYfJMk7ASvcestIB" +
                                          "+3y/84p3vM6hnK1MZkWV7VT+U6DTA4c6caqmBqojq5uON72UfY9012feugVB" +
                                          "gPjOQ8Qbmt/7medf/fgDz31hQ/Oiy9B0p5YqRxfkD05v+cp9jcdqR1MxTnlu" +
                                          "aKbGvwh55v69nSfnEw9E3l17HNOH27sPn+M+N3nDR9XvbkGnaeiE7NrxHPjR" +
                                          "rbI790xbDUjVUQMpUhUaukF1lEb2nIZOgnPWdNTN3a6mhWpEQ8fs7NYJN7sG" +
                                          "KtIAi1RFJ8G56Wju7rknRUZ2nngQBJ0EB3QEHH1o87svbSLoAmK4cxWRZMkx" +
                                          "HRfpBW6KP0RUJ5oC3RrIFHj9DAndOAAuiLiBjkjADwx154HizpFwoSNEEgEh" +
                                          "VUUIJDPCZEAbbqeO5l3/IZIU5dnlkSPAAPcdDn8bRA7l2ooaXJCfjuvE8x+/" +
                                          "8KWtvXDY0U8EPQ5G3d6Mup2Nug1G3Qajbl9mVOjIkWywO9LRN5YGdpqBiAe5" +
                                          "8KbH+J9mnnzrI0eBi3nLY6mWkywE78kujoJ+j105PzfT5EBnCVEG/nrPf3Xt" +
                                          "6Zu+/Z+ZxAdTbMpw6zIxcai/iDz7/nsbr/pu1v8GkI0iCXgPCPQHDkfmRcGU" +
                                          "huhhTYIku8+38NH5v209cuJPtqCTInRW3sngQ8mOVV4FWfS0Ge6mdZDlL3p+" +
                                          "cQbahNv5nUiPoPsOy3Vg2PO76TIFf/ygBcF5Sp2en8684ZaM5tYfgd8RcPxv" +
                                          "eqSWSG9s/P62xk7wPbQXfZ6XHDkSQccL2+h2Lu3/cGrjwwpOBXgl733gr//s" +
                                          "O8UtaGs/hZ85MCkCJZw/kDZSZmeyBHHrvssIgZoq6+/e1/uVd3//La/J/AVQ" +
                                          "vPhyA55L21RiMAeCueTNX/D/5pvf+OBXt/Z87GgE5s14apsyOAmzKQ0g0UxH" +
                                          "sjOFPBJBd1u2fG4X9RBMcUCwc5aNZqq6E0zqmWipVbY380IWVkCic1dw1wNz" +
                                          "+QX5XV/9wc3DH/zh85d46sWKaUve+Y2FMqkSwP7uw1FESaEB6ErPdX7qrP3c" +
                                          "DwFHEXDMIq8bgEBOLlLjDvXxk1//7B/f9eRXjkJbTei07UpKU0qnXZA8IwPM" +
                                          "1AbIAYn3xKs3yW95CjRns9iEMvwv2oiThfUt+4pgXTA9vv0f3vXld774m0AO" +
                                          "Bjq+SH0YSHBAW504XTH8wrPvvv/Gp7/19swmINUOf/G30G+lXKvZAC/J2p9M" +
                                          "G3hjsfT08bR5Wdps75rp3tRMfJYLWSmM2q5ighWDklnqqqmjF5hz4G2LnekQ" +
                                          "eeq2b87e/88f20x1h/PEIWL1rU+/7Ufb73h668AC48WXzPEH+2wWGZnQN++Z" +
                                          "8uGrjZL1aP7TJ5769G8+9ZaNVLddPF0SYDX4sa/9z5e33/etL14mRx+z3V2n" +
                                          "TNvCzrDpX/mFDRvd/PNUKaSx3R87FNXCcpAkc60Ld4vLfk3F5/i67etV1VNn" +
                                          "3pBeGopF1r32eow3+3mBl8vIdI4a0wXKV1AZnrRdiaGHYtJyJ0ZjNpswGsoR" +
                                          "THPAD5hxzp1IdIv0hRY59+sdNzcdzExv5AtRy6jbiovwTAQXq2sVVdCKxjQl" +
                                          "fO5QKtrTtF6vgxbDnpAvWfmp2Ox6TrdfXDdESnLHsMJJ0SzMSQpXqJWa8pqy" +
                                          "l3xQsYo5bcpWLZ70yFVrmYsm8kAK2nV7NGPUEpfz2aDjS6Wluo6sxnDJRaLV" +
                                          "CSiqNRy0NXrcGarruiX5vlk1CWsp1nUcHZgeM1xNfSdhSRXH9U63a9I6PzRo" +
                                          "IkYTDa50Z41ps91Q5Koz6aki4jTyzLzI5kPBdk0YnpXwkVr23YHlhwVUTkRx" +
                                          "kgQSR7hrlbZslTSRKKzUJ81oVuT6tG3nXSRWOwQ8G2FyM/TjkGxW1bWyZqe5" +
                                          "tijSs5ZUVGzYGo1DDO5PvYbXIK0i4VBcs+rF5ERpL6eMiwSDsJkLazPVmgpi" +
                                          "ybKq+Moh7U5dFwxxFK4Jrz7tdMmV2Z9P9UFbVcLSoil3XNtQeq1BrlQuxbN8" +
                                          "adjuofNFecANPcqkOr5VaZdMXa/TSofT633bna1XcJlhmoZpsILvdhND9O3B" +
                                          "YFktz+eVdV7kuio3HTglucmg7XlY5VUWJG9ubU7t4ag04UZdO+mTZW3lC3M3" +
                                          "Vx+pSrlcHjoOhpVhEsN5lxbNgVdgCmuxLU18Uy6N1EQbCIaVz+cxjIiCdmnl" +
                                          "WDIzahf7LaLCdeauQdaGXIkkkp6wbHpRnyAlilxNmv7cZIeMLZDSxCJzfL2m" +
                                          "DKlSw3fcer2BGmKrogkU1mD54lKS55ZTWEw7yRIJSGSor/pY21Qnrk9VrWnD" +
                                          "zaGKy+TClVkitBU97Pirdi9HzcZMqUtgvaZMoeQMlme1PFyTC0XHEwfzdYgJ" +
                                          "HWthwN6iMZGtCVwp5ZuatIh9gk4qszU+tKkyx8vjsSHmF47gCLS+rC5duTpq" +
                                          "uwhC8Wu7BqOq3isMYdwjyX6+YZJ2WMCo6cDnQnHQGYnRRPDXLVJl+kO2VyN4" +
                                          "DcbLtBQTNTcGgRuXaeCVZL06awuD9ZDs0sU+0yeausFh6CoAy2d6UY4HXnWI" +
                                          "rk2eyLcZHFvUqwZYk5pFXGfqYpdMZiNPD4ZDJUdzqxy+LsAUrbIEpkS5LlYe" +
                                          "9RKpYEnLJmPohaDJT3SjMJtrbWMyEho1kK6KDGLRjT7BubG/IOT6yIoJYy6O" +
                                          "NDeUHYcFGQjDmixOo0hJUtvlUT8XLlsVSV4tpoVxsVqp+W6OHfepelLr5sNW" +
                                          "TE/tgO8uJd3O4yEZu0mrNCPqjelaphRPEutCoadXufpqnp90img+UihGbIrm" +
                                          "RB1jpOstBTbQl8iyPYL9/mC9QO2J1uOKaBEucWqD6VqkMRJ7/XptvuhEFkgI" +
                                          "a2FoKP5qQbFumLjsojLo8ahXQZQ4L9MYJ7B8oTgxRm2t0MCIoW70i8WgvOws" +
                                          "FgunV+ADTFfrI2rCrDr9HGp5NErSIsMZ4w4/XhpMdV5f99whgo0tWF/CKsGr" +
                                          "M3U6zncFCfZIfObF8zq9wtXCqmkJrRDDkQY9lpWcO+gSi2mPErw8g1JW2Ikd" +
                                          "fSqP4wKGiGXf0ZBFnM8RvcViyDbqsV+ejMvqBO60q0trojfDUb6fx2k/mMvF" +
                                          "ejsWgqDcC5FKLsjXw3m7Qc5wg2UGy6WvJzmQMWyKdHr4tEkr5jIsevx6WaYm" +
                                          "IbfK1yeYzbYU1lFKQ8ax8DZbXs/FEkz2g7W+jPyK2osQlBsjXoGQWWWeb1tL" +
                                          "X6gWxGWxlZNmOhxbJKuyqjBOBLSE8CuNpIKVzecCW+zUZ2N6qTEKPZRHbBwU" +
                                          "WjqRi+qBPUzgnr4m1hOFcTQfybuJKAx52FyHk4iK3f6oYlILWfcSwmYkr4is" +
                                          "3UDgnLGcL7bcbp/QpaEr+nBj1lP7nd6oKtaVnETM86IHjzBdGFluFW6KFZ0b" +
                                          "VTkVWVudxGkg+KyCL5rdDk+xPqH0x4nSH3Rby7FYruLSMAhUnLExPd9gyNiR" +
                                          "gklPyktcq5QEeLfXYaqlYOositMqJ3qretAuN0e5WtAW4163WGNaVgCj6LCi" +
                                          "6ES+sSQcwrJm4TxXi0K72O2JCsHYjV5xLcjoYiHzGtfnGb7vjNZFgmNLTJON" +
                                          "imbeZLiBQjeNohlTRbOamyQ1kwkF1yKK+Wg5atcYOhFMl6xxY5qgV/lE41pt" +
                                          "bT1jJqbt+fUZa8bNNl2sl5QhL6GuA/NttTEi9HBWVNbUEtEW6miBSFW2Uqlh" +
                                          "tcZ66shCeTkpIeqoxI/aWCVq2Z1RsxoKvYgtoJFuUeulXdaa47ZQNjuO4xdA" +
                                          "Yrc8mJe8kV1c0F5eFIsWvy5qHTpipyo7wqmljXQobYGWZuMYx6OSIcwDy/CJ" +
                                          "xDe03Gwom2IrMZutUTiHa4EWl4lRbYDBnaXuywu/4hIhmVsO1GI3ciZ5dEKN" +
                                          "gj7sTCl/lkhjjB+RBUmlG7Gk4vlOHUvKMj+0CloMa1a5smyFJR0l5muT8htO" +
                                          "IskjMJk4vVpFiwOF62K13JgtFBHVjQqVvrikMJBF40UYtuqVVX1kjyZqJV5M" +
                                          "iyy6LE0RvtMyaJAYClKfa+NNMqr5HV2XcAzFJ0NqHYGIWi7bdTjSpTpBCr40" +
                                          "QZg+U2O1picUyr1CZ1Uax5RmBci8X3TWwdIaBGLbR+VxfSVWR+qM8LwxMixg" +
                                          "fi3idR4dijhN+yNZ0jg+33JFDNOSiUeNEY0ZmIg568h9C1/1Kq0mUWnb9FBv" +
                                          "rBOX0q1BkeizVFdZC4XCsOtUB/WCK5clk5zUVMM3nFY7sUozi3ANXXS8oa4y" +
                                          "o1UU44TGLimibVTbMpvLtWoJIpScZs/TcDADqwpYOVZ4G8yeo5EOY6XuLI95" +
                                          "6mppzbhGUnA1XBPHjYlAVCtJTs7bmswapRirTqwuAxIHOx2zM9+qDhp2rmti" +
                                          "YrmLJ77UcotkjNe9XqlXrwm2NyQF0qmJmDbEfNbQ6qES4JMxRYSOOceTSS0B" +
                                          "Biv3JrWmJMWlAUbMZvTIrbJymSdXqDkw2iY3WNgYZXDcSsWSOm91VZyTiITk" +
                                          "hLAsEaazkF0mP/JltOgXis3iGjjkxB/1pZLsVExsHEz1zpgv4cVCbanWCxIx" +
                                          "aSyIJrqKVH0xbhiwJnT1FUEMWqCvQQ4VuNxHJWe+8K2k5gV2jHiOMi3N5pED" +
                                          "WPQFhRdagSRW/IIdGfmyPuIrgakThdXKGjedSixHRK3o9+k5JrX7yATmYavg" +
                                          "CgOPw1aj9jgMitgAQxheG5Z8eIyGsNxhjZzTEejmCmGMKqbwPTxPryxUnKql" +
                                          "HBaHubYmr2stqlzwInVIaXQP7dEduCh2xwgZ8oNqQS1MhVoVGcS9lRgWOKlL" +
                                          "4SY55uJ0ZlwsOtRa7YRBj5XhQIxjn0Tbcb6F0FGejAZzfBwYSgWnsAHSLhON" +
                                          "vKVLFSEKZjSCaFMRlxFECti5oBpYzaOxZnu1rhW9GO2O8x1KsEaTKIfS+TYq" +
                                          "B4UBEeXgTiGgPHQS49NybQ3TRRen2TnK1Xp9EMN+OV7B2hRHpiTPd/RKX+rO" +
                                          "QKiviI4f5Mv9CGFsqhkY7WSAaiXZxAx52HKH0Xi1zjV1r7OYNJpLrTufDMUF" +
                                          "SxlixxlwztSPOC036KtifhTNan1+pUtSkhML3HzRVEhy2MmhGuZoVA4NotmA" +
                                          "4CK9U2zSs+58PoXdgPXCRqApY8FrlRwDX3TZ5Wpcra8CbyEOqjLYdb0y3Y7R" +
                                          "P96O+NascLFX3QYb4fRB7sfYCSZXGzCCTknTMAokOYqgG/bK7ZvRD1TujuwW" +
                                          "Ss5dsVZ4oEaYbofvv1KVO9sKf/BNTz+jdD+UT7fCKWccjB653stsdaHaB8Y9" +
                                          "DTi99Mrb/nZW5N8vzX3+Tf9yr/Aq48msNnVJyZCFTqc9e+m7lL13Jg8ekvMw" +
                                          "y4+0n/0i+aj8y1vQ0b1C3SWvHy7udP7i8txpsNaOA0fYK9IF0COX1ApcWVXi" +
                                          "QN0f96UPSZ+68Jmnzm1Bxw5WL1MO9x+qBd6oucFcstMBdt93nI6MwF3u3zlY" +
                                          "GARqvSl1jbvB8fBOQTz7T5/e7qXtHcm+g13iOVt7rsrt+EkAPbpfk2q4tq3K" +
                                          "mdbPDZx5VsKRpraa1of/+8xL8p/63jvObgocNriza4bHX5jB/v2fqENv+NJr" +
                                          "/+OBjM0ROX2DtF9l2yfbvJa4fZ8zFgTSKpUjeeNf3P+rn5c+cBQ6QkPHQnOt" +
                                          "Zu8Jjmx8PYuwDJqRYZezVs8Ca1PTTq+ttLkQQTcaUgjsl70AywifOBCRjQg6" +
                                          "OXVdW5Wc/Wh98oXqNgeHym685mLL3QGOR3cs9+g1We5ieFv7VLl9JSyvooRV" +
                                          "2gQgiwAlZAkgvbb3oYbXCvUhcMA7UOH/R6iXmPrnroLyzWnz+gi6w9yzNAbW" +
                                          "HFKUuuUhxD97rYjTUMztIM5dd+O+8yqwfylt3hZBd5ohFkWBOY0j9Yq4336t" +
                                          "uB8AR3kHd/l6WvrXrgL5A2nzngi67YClFSUr4x7C+95rxfsgOF6+g/fl193O" +
                                          "H74K6I+kza9H0O0H7Xx51L9xrajvB8cTO6ifuO6of+cqqD+VNh8HKyxzk7mu" +
                                          "6NmfuFbMLwIHvoMZv+6Y/+gqmD+bNn8QQWd2MV/eyp++BsQpaba0YHYQM9cz" +
                                          "lr90FbB/mjafA2B1NdoN5r0V0aFJ+qi58w1Ohv/z14r/HnD0dvD3rrvFv34V" +
                                          "Jfxt2vxlBJ0FStgL7t2l6J/vQ/7ajwM5AbniMp8GpKutey75BGnz2Yz88WfO" +
                                          "nLr7mcFfZevZvU9bbmChU1ps2wffZh84P+EFqmZmQG7YLGG97O/vI+ieK21E" +
                                          "gDFBm8n87Q31P4KZ+3LUgBK0Bym/AxR1mDKCjmf/B+m+F0Gn9+ki6MTm5CDJ" +
                                          "vwLugCQ9/UH6cv3ApmbHZzK93/ZCet/rcvDteLoRyj4J2920xJuPwi7In3iG" +
                                          "6bzu+cqHNm/nZVtar1Mup1jo5GaXsLfxefiK3HZ5naAe++Etn7zhJbubtFs2" +
                                          "Au/77wHZHrz8+p2Ye1G24l7//t2/+4oPP/ON7A3x/wHrOqbhqycAAA==");
}
