package org.apache.batik.css.engine.sac;
public class CSSIdCondition extends org.apache.batik.css.engine.sac.AbstractAttributeCondition {
    protected java.lang.String namespaceURI;
    protected java.lang.String localName;
    public CSSIdCondition(java.lang.String ns, java.lang.String ln, java.lang.String value) {
        super(
          value);
        namespaceURI =
          ns;
        localName =
          ln;
    }
    public short getConditionType() { return SAC_ID_CONDITION; }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName; }
    public boolean getSpecified() { return true; }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        return e instanceof org.apache.batik.css.engine.CSSStylableElement
          ? ((org.apache.batik.css.engine.CSSStylableElement)
               e).
          getXMLId(
            ).
          equals(
            getValue(
              ))
          : false;
    }
    public void fillAttributeSet(java.util.Set attrSet) { attrSet.
                                                            add(
                                                              localName);
    }
    public int getSpecificity() { return 1 << 16; }
    public java.lang.String toString() { return '#' + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za5AUxbl3733cGzlOkAOOQwvE3RB8RI8Yz5XHwR5cbpFK" +
                                                              "jujSO9t7N8fszDDTe7ccEoUqlbISyhI0aoRKGUwMQbGSWFFTGvJUY9TCWL6I" +
                                                              "j+gPNWpKKtEzIdF83T3vfVBXUl7V9M51f9/X/b2/r+fwB6jKNFCXjtU0jtBt" +
                                                              "OjEjA+x9ABsmSccUbJobYDYp3fS3vddO/qVuZxhVD6GmEWz2S9gkK2WipM0h" +
                                                              "NEdWTYpViZjrCEkzjAGDmMQYw1TW1CE0Qzb7sroiSzLt19KEAWzERhy1YkoN" +
                                                              "OZWjpM8iQNHcOD9NlJ8m2hsE6ImjBknTt7kIs3wIMc8ag826+5kUtcRH8RiO" +
                                                              "5qisROOySXvyBjpX15Rtw4pGIyRPI6PKBZYg1sQvKBBD1wPNH5+8eaSFi2E6" +
                                                              "VlWNchbNQWJqyhhJx1GzO7tCIVlzK/o2qoijaR5girrj9qZR2DQKm9r8ulBw" +
                                                              "+kai5rIxjbNDbUrVusQORNF8PxEdGzhrkRngZwYKtdTinSMDt/Mcbm11B1i8" +
                                                              "9dzovu9d3fKzCtQ8hJplNcGOI8EhKGwyBAIl2RQxzN50mqSHUKsKCk8QQ8aK" +
                                                              "PGFpu82Uh1VMc2ACtljYZE4nBt/TlRVoEngzchLVDIe9DDcq67+qjIKHgdd2" +
                                                              "l1fB4Uo2DwzWy3AwI4PB9iyUyi2ymuZ25MdweOxeCwCAWpMldERztqpUMUyg" +
                                                              "NmEiClaHowkwPnUYQKs0MEGD21oJokzWOpa24GGSpKgjCDcglgCqjguCoVA0" +
                                                              "IwjGKYGWZgW05NHPB+uW79murlbDKARnThNJYeefBkidAaRBkiEGAT8QiA2L" +
                                                              "47fh9kd3hxEC4BkBYAHzy2tOXLak8+gTAmZ2EZj1qVEi0aR0MNV07KzYoosr" +
                                                              "2DFqdc2UmfJ9nHMvG7BWevI6RJp2hyJbjNiLRwf/+M3rDpH3wqi+D1VLmpLL" +
                                                              "gh21SlpWlxVirCIqMTAl6T5UR9R0jK/3oRp4j8sqEbPrMxmT0D5UqfCpao3/" +
                                                              "DyLKAAkmonp4l9WMZr/rmI7w97yOEKqBBzXA04XEH/+lSIuOaFkSxRJWZVWL" +
                                                              "Dhga458plMccYsJ7GlZ1LZoC+99y3tLIRVFTyxlgkFHNGI5isIoRIhajkmlG" +
                                                              "iToMJ4yaWIrGEok+YEdNcylEmOHpX/yWeSaF6eOhECjorGB4UMCzVmtKmhhJ" +
                                                              "aV/u8hUn7k8+JUyPuYslP4oisG9E7Bvh+0Zg34jYNwL7Rvz7olCIb3cG21/Y" +
                                                              "AmhyC8QECMoNixJXrdm8u6sCjFAfrwQ1MNCzC5JUzA0edsRPSoePDU4++3T9" +
                                                              "oTAKQ3xJQZJyM0W3L1OIRGdoEklDqCqVM+y4GS2dJYqeAx29fXznxmu/xM/h" +
                                                              "Df6MYBXELYY+wEK2s0V30OmL0W2+8Z2Pj9y2Q3Pd35dN7CRYgMmiSldQuUHm" +
                                                              "k9LiefjB5KM7usOoEkIVhGeKQYMQ+TqDe/iiS48dqRkvtcBwRjOyWGFLdnit" +
                                                              "pyOGNu7OcKtr5e9ngIqnMXc7E56llv/xX7barrNxprBSZjMBLngm+GpC3//S" +
                                                              "M+8u4+K2k0azJ9snCO3xBCpGrI2HpFbXBDcYhADcq7cP7L31gxs3cfsDiAXF" +
                                                              "NuxmYwwCFKgQxHz9E1tffv21g8+HXZulkKlzKSh68g6TbB7Vl2GS2bl7Hgh0" +
                                                              "Cng+s5ruK1WwSjkj45RCmJP8t3nh0gff39Mi7ECBGduMlpyagDt/5uXouqeu" +
                                                              "nuzkZEISS7SuzFwwEb2nu5R7DQNvY+fI73xuzh2P4/2QByD2mvIE4eG0gsug" +
                                                              "gnPeAXUXx2Q5NSJyKpu/gA9cr+dzwCgflzGZcHTE177Chm7T6x9+F/TUTEnp" +
                                                              "5uc/bNz44WMnOEP+ostrDv1Y7xEWyIaFeSA/MxiLVmNzBODOP7ruWy3K0ZNA" +
                                                              "cQgoShBlzfUGBMS8z3gs6KqaV37zu/bNxypQeCWqVzScXom5H6I6cABijkAs" +
                                                              "zetfu0zof7wWhhbOKipgnol8bnFlrsjqlIt/4qGZv1j+4wOvcbsThjabo4dN" +
                                                              "VusFQyYv2F1vf//499/69eQPa0S6X1Q6xAXwOv6zXkntevOTAiHz4FakFAng" +
                                                              "D0UP3zUrdul7HN+NMgx7Qb4wCUEcdnG/fCj7Ubir+g9hVDOEWiSrON6IlRzz" +
                                                              "3SEoCE27YoYC2rfuL+5EJdPjRNGzghHOs20wvrnJD94ZNHtvDIS0JruMOMfy" +
                                                              "9nOCIS2E+EsfRzmbj4vYsMSOIHW6oVE4JUkHgkhjGbIUNbDjmZCNyZWDfY6r" +
                                                              "TeckLmbDGkFueUk7jPm5mAvPEmu7JSW4GBRcsCFeeNhS2MCjoklYWWcJNHjS" +
                                                              "RJmT5t0dFzs78r/qYCHnjbGukyDm93NK1dq8Tzi4a9+B9Pp7lgoXafPXryug" +
                                                              "Pbvvhf/9OXL7G08WKYrqqKafp5Axonj2rIUt5xc4Zj9vRVwrv+i5yYrjt3Q0" +
                                                              "FJYxjFJniSJlcWkPDm7w+K6/z9pw6cjmKdQncwOCCpL8Sf/hJ1edLd0S5t2U" +
                                                              "cKqCLsyP1ON3pXqDQNuobvA5VJej2lamsvnw9Fiq7SleIxSxCifzlkItk4BG" +
                                                              "y6zx5gsCS8swoU51y4sclq88Wmb3HolcyqQDhpwFqDGrKzvSPrn19zUTV9gd" +
                                                              "VzEUAbnW7H/2kdVvJ7nGaplJOHLymEOvMeypr1qEAD6DvxA8n7KHnZ1NsF+I" +
                                                              "iDGryZrndFm6ztyiTDYIsBDd0fb6lrveuU+wEAz9AWCye99Nn0X27BPuIlr1" +
                                                              "BQXdshdHtOuCHTZszXMPKrMLx1j59pEdv7p3x41hS1NXUVQF2degjh5DTm/R" +
                                                              "HhS7OGv10v3/vvaGl9ZDMdyHanOqvDVH+tJ+k60xcymPHtzu3jVg69RM5hSF" +
                                                              "FutWnubhLXOqQOwrCNhEL5/GjmW32U4Rsyw7NnWnKIVaxvBvKLO2mw07oeAC" +
                                                              "p1gXzEQu77tOD++d8Ky1GFg7dd5LoZbh75Yya/vY8F1IwcB73JfYXMb3fG7G" +
                                                              "p7MllpQT1ukTU2e8FGoZ5g6UWfsBG+4QjCd0IkGrQcTdmmp5LfsxPe/jFNWk" +
                                                              "NE0hWA36JPv3Go+b3Hl6JNYBz5DF9tDUJVYKNSCVsFWAs/+h95nOrkbGl0mR" +
                                                              "tJaNsCthovJeTXQ+R8qI9OdsOARxK4upxO+q7nZF8tPPLRLecp8Hj2TxJU1d" +
                                                              "JKVQA1y5oXZu0Qw3iMd52ZWUvtN1/c5zak5cKJLJvKLQntvQZZMXNs87dK8q" +
                                                              "wItn3MA96Jvbn7pb++t7YTsxaA5X7PoPNYPqiGBK/FI0elov5IBINkohXUEP" +
                                                              "skHOkrRlE/b13xe4G8ukswtqUVcZDz7yo4t2L/nG3UK680tUBC78w19/49j+" +
                                                              "iSOHRXJnJQpF55b61FH4fYXdUS0sc8/mqv2jVZccffetjVfZOmxiw2/ztss1" +
                                                              "ul0z9IRs8k/FIwxHfrSMCz7DhoegvsvIiuJ8jAKixaJZ5Zgmp10Pffhze2gz" +
                                                              "W5oDz6jlZqNT99BSqGWYPl5m7VU2vEBRkxvmJZluO1Wgr5DVgsIrGORfPD31" +
                                                              "wCzOp/jbOnV5lUItI5P3y6z9gw1vU1RLNc/Nl8v0O1NnOg/S91+ns5uijoIP" +
                                                              "e+JjlHT/gebamQeufJFf6TofjBqgh8jkFMV7keF5r9YNkpE5Bw3iWkPnPx9B" +
                                                              "S3eKq35QNoz87P8SSJ9QNLsMEkXV4sWLc5KiM4rhAHUYvZCfgncGISFn8l8P" +
                                                              "XChEUb0LB5uKFy9IJVAHEPZapdvB5JJTfdrohRxjAN9OeHD0kg/5Lxscrc84" +
                                                              "ldY99xMLfBGRf+W1M1xuwAq8Rw6sWbf9xIX3iOtvScETE4zKNOhPxE2808TP" +
                                                              "L0nNplW9etHJpgfqFtqxtVUc2PWc2R7z7gU/1pn5zQrcDZvdzhXxyweXP/b0" +
                                                              "7urnICtsQiEMFdGmwmu4vJ6D4mBTvFgnthEb/Nq6p/6tzc9+8kqojd92WgVF" +
                                                              "ZzmMpLT3seMDGV2/M4zq+lAV9IUkz+8Ir9imDhJpzPA1dtUpLac6H4SbmK9g" +
                                                              "5rNcMpZAG51Z9vmEoq7C5rXwk1K9oo0T43JGnZFpDFx75HTdu8olu10EUFGB" +
                                                              "VCTj/bpude3hf3LJ6zoLB6EOHkb/D3eQ153KIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZScpYmsJVkzRyZISrDDPlZ9f/eyn+tunLPeOiwx0ptuL/HOYHcB7Ubt4v36B" +
       "ch49mWffcxyN77lIOZeg8oUqmzxXpreK5D0nEf5wEPox0FJTj4P8L8DnEnj+" +
       "T/EU4oqM/VT+OH28nnjn6YIiAFPXI4WqEZi6tMmIOw2Lm6W4epE096Lxe/rM" +
       "B88jehY87z9G9P57IOLvgah4ZUoztQE4x1dkRzi25EW1eq+pVikmuwTM9CB6" +
       "hB+VAkZ37/hK8fqdgDGjcrkPWuiWJzsnmrzddpRbJ+abguU/8OVbtoPfTa/2" +
       "/7NeIKQePfBSzwdL7R/9L5/44t9511eA33ehB9PCJ4G7nyEvISn+ffytVz75" +
       "9Jte+uqPlmQPrDb4FHPzQ4XU77kfuiKZFsnsBNZTBSypXDn15Cjul/ysqQWy" +
       "+4f7ILRcMI2lx0tr+MXHv7L+yT/4/H7ZfDG2L1TWPvbSj/zF0cdfunzmz8q7" +
       "7vi/cLbN/g9LqfSbjy0cQs/dr5eyRfv3v/DiP/npFz+61+rx80tvBvyz/Py/" +
       "/fMvHn36q791l/XcA46/nyP+UgMb33yyU4846uTTqy5ljJpkK6eG12oKmzvi" +
       "mhLF4TZlaqMmMeKIRY7NO9sRpqyCNm8ntiSSMS4QepS3WmMNVxTGn2ycFSft" +
       "TK4q+yOenWz7wxUrzdrtMZt2JwtyTM96Dc6uGANhFvB8zOSc2iZq41qqT5vz" +
       "iYNPyT6G6CQ8h1coHFb0bbNh80KbntvxpGrHzVi0GZuqZCTVjFxJUSarrr9a" +
       "tBZBTZdqqaqK8GaaLDNz2mqwLjPLUYk01jw6s4J+1RQYdTZeBFNraYc0s85t" +
       "im25/eFii4xnCM1Uh/kK+JRvSXkvRkieoWY5MzJ3yGLtC+JyZgd9whoKHUVs" +
       "kYLTJVzUjJgG59rNtTeO8TUX1bZcXyFkg0AbFWw9iZVRhxhZIraxopEo7qR5" +
       "umvawRzBRvG2HrDcbjTgGgO+uVwYSDRM+WazhWwHQgerEJostS2UaUydmaCY" +
       "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" +
       "pJZpdZZI1tE23kymyrKV4zu/HqM92GNrE75BVONJk8aJLUICUrQrliR2RvOu" +
       "1x0GbQxbNZB2pw5GQZ1I1UghYHeTovZ0qSi6rsX2VF+KbmZtUTiPowhJnGpO" +
       "cqOIWAOttllHDyWwksFbpq8ZaZRyVtIlbIq3Mrm7xJaGGyDVga6buYYa+Qzz" +
       "W3nDdpYbYUySTWnDzhYDB3Px6QRNmeZonaVud+kkIjIzQqw1NSKwmBJH+qBV" +
       "Q7Z0LgawvRK9KeZMuJjDBjUQ06SxRdIJMuoJCiw4RFoVEcETDVgikYoXYYll" +
       "+9xAq3RtpzOGDW0lu0Mt0bttvTH2wQpkY5iEvW73p/haa2MhuRDWAYM1wTAC" +
       "avIGGVCypvGbGjYU/JzAB4Qkdcmh0Iv6zHo+rUeznoLxVr8emlRnskiXtG54" +
       "CstJbY9wiMGcNpnJqtprYgnf3pFcd0p1mMFSDtS0iXW7Y10NfXOU2ZRAilqn" +
       "VV0bMNbLIiVUiLqjLkgy6/f0JjvSKzOkj2TJltoQo20jmq10MuPmNUuMU0lh" +
       "xkw95wXRBH9/UKJKjAe9qicEzozU4k43MPRNO95k8XSioIOZgo7wHDcmMBJ4" +
       "WD4MldYyVXNznu222nwAr6p4EnocHUdDi+m3Vdbdukk97TZadbc5TtuGF5vM" +
       "ChY2jQBuxLlCVoj1xrdVEp0Z0/Yyd/tBb1yLtH6LnaJwv55vKg41JbnJOq8Q" +
       "XEhabgv84coHFKLGk6AnK41OXVq5PGlgoaD0gyXFYsiSTF3G3+A0Fs63a4Qn" +
       "fb86rte6LAjBoNXOcKwzVhPCdxKkykzabHNKj214FSSqVjP1Wq/byP1es8GI" +
       "nfUKbtW0IYLVeG5IUcUWgfOt7dI8Vm4+nZ7e/iW2nfZFzxXJu0/36srP1Ysn" +
       "fmfPAg67v1Cx4/L0vQ5ly92Wz37kpZdV8XPI5eNdcyOGHo794AOOlmrOGVHX" +
       "gKT33XtnqV+eSR92c3/jI//tqfF3mx/+Fo6xnr2g50WRP9N/5bfY71D+3mXo" +
       "yune7h2n5ecb3T6/o3s91GLgo+Nz+7pPn1q2tO5z4Ll9bNnbF3dBD2N39y3Q" +
       "79yP/X0OJT5yn7K/USQvxtBNQ4tPjxxPD75WZ7xFj6EHI9MP44Mf/cBr7XKd" +
       "7a3MyE+BP34CnD4GTr/xwP/ufcp+vEh+LIZuAODCxV3tA8S//XohPgMe/hgi" +
       "/8ZD/Mx9yv5BkXw6hh4BEHvntscP+H7ideB7osgsdvClY3zSG4/vZ+5T9nNF" +
       "8tk9PinQlHJD+m5++9DK9x1N9g6wP/d6YT8JnuUx7OUbA/tyWeHyyTHkE8U1" +
       "gW1NOVJ996i4LKV55bHp/hDyV+5jl39aJP8QhKsrx0p5b+PzB+S/9DqQl+fe" +
       "HwCPcoxceWOQXzq9ufDcPdh+JG/LKeQF5R8Pv/qlz+RfeGW/Eb+SIy2GKve6" +
       "InbnLbXiasG773M94nB56I/Z73r1D//z9HtPJqk3nZqhYC3o1v3McDKGbz4c" +
       "uUpaOXpfLGX9+n1G718Xya8BRtYtx6HiOLRWSVwcR97Nsx9IfUs9DO4/fx2D" +
       "e6PIfBo89jEq+42P5v9wn7IvF8nvxtCjh2hWrHh3N9RXLO/MLPR7r5einypx" +
       "7j+bNx701+5T9vUi+a8xdC32z9w1OGD7/W8FWwaMd/7uUHER4sk7bjHub94p" +
       "P//yjWtvf3nyu+X1mdPbcQ/3oGt64jhnD6XPvF8NQk23St0f3h9RB+XX/wTr" +
       "ote41wTGDaSl1v9j3+hPY+jb79Mohq7uX862+bMYesvd2gDpID1b889BDF2s" +
       "CUix/D5T7xIUQ9cP9UCn+5ezVa4A6aBK8fpAcBLc3/Va97ioVRSHAPdpEJ+O" +
       "S3bp/IL5dLwff63xPrPGftc5GiuvtJ6sYpPBMVt+4eWu8P3faHxuf9VIceQ8" +
       "L6Rc60EP7W89na6En7untBNZVzvv/eajv/Dwu08I8dG9wocAOaPbs3e/18O4" +
       "QVzexMl/5e2/9MGfevnL5an0/wWxmpGOaywAAA==");
}
