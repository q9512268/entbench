package org.sunflow.core.bucket;
public class HilbertBucketOrder implements org.sunflow.core.BucketOrder {
    public int[] getBucketSequence(int nbw, int nbh) { int hi = 0;
                                                       int hn = 0;
                                                       while ((1 << hn < nbw ||
                                                                 1 <<
                                                                 hn <
                                                                 nbh) && hn <
                                                                16) hn++;
                                                       int hN = 1 << 2 * hn;
                                                       int n = nbw * nbh;
                                                       int[] coords = new int[2 *
                                                                                n];
                                                       for (int i =
                                                              0; i <
                                                                   n;
                                                            i++) {
                                                           int hx;
                                                           int hy;
                                                           do  {
                                                               int s =
                                                                 hi;
                                                               int comp;
                                                               int swap;
                                                               int cs;
                                                               int t;
                                                               int sr;
                                                               s =
                                                                 s |
                                                                   1431655765 <<
                                                                   2 *
                                                                   hn;
                                                               sr =
                                                                 s >>>
                                                                   1 &
                                                                   1431655765;
                                                               cs =
                                                                 (s &
                                                                    1431655765) +
                                                                   sr ^
                                                                   1431655765;
                                                               cs =
                                                                 cs ^
                                                                   cs >>>
                                                                   2;
                                                               cs =
                                                                 cs ^
                                                                   cs >>>
                                                                   4;
                                                               cs =
                                                                 cs ^
                                                                   cs >>>
                                                                   8;
                                                               cs =
                                                                 cs ^
                                                                   cs >>>
                                                                   16;
                                                               swap =
                                                                 cs &
                                                                   1431655765;
                                                               comp =
                                                                 cs >>>
                                                                   1 &
                                                                   1431655765;
                                                               t =
                                                                 s &
                                                                   swap ^
                                                                   comp;
                                                               s =
                                                                 s ^
                                                                   sr ^
                                                                   t ^
                                                                   t <<
                                                                   1;
                                                               s =
                                                                 s &
                                                                   (1 <<
                                                                      2 *
                                                                      hn) -
                                                                   1;
                                                               t =
                                                                 (s ^
                                                                    s >>>
                                                                    1) &
                                                                   572662306;
                                                               s =
                                                                 s ^
                                                                   t ^
                                                                   t <<
                                                                   1;
                                                               t =
                                                                 (s ^
                                                                    s >>>
                                                                    2) &
                                                                   202116108;
                                                               s =
                                                                 s ^
                                                                   t ^
                                                                   t <<
                                                                   2;
                                                               t =
                                                                 (s ^
                                                                    s >>>
                                                                    4) &
                                                                   15728880;
                                                               s =
                                                                 s ^
                                                                   t ^
                                                                   t <<
                                                                   4;
                                                               t =
                                                                 (s ^
                                                                    s >>>
                                                                    8) &
                                                                   65280;
                                                               s =
                                                                 s ^
                                                                   t ^
                                                                   t <<
                                                                   8;
                                                               hx =
                                                                 s >>>
                                                                   16;
                                                               hy =
                                                                 s &
                                                                   65535;
                                                               hi++;
                                                           }while((hx >=
                                                                     nbw ||
                                                                     hy >=
                                                                     nbh ||
                                                                     hx <
                                                                     0 ||
                                                                     hy <
                                                                     0) &&
                                                                    hi <
                                                                    hN); 
                                                           coords[2 *
                                                                    i +
                                                                    0] =
                                                             hx;
                                                           coords[2 *
                                                                    i +
                                                                    1] =
                                                             hy;
                                                       }
                                                       return coords;
    }
    public HilbertBucketOrder() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4awVNVQ9ZciERgPZrLtDVe9wRDygqAA3yVFz5s6atfUmtNFJaK/FSshQsiEi" +
       "TrmHW5w/S5kprWernizDtdLSZ2FWh9FZaVqfzkTC5UuGKWyUdCqVkGTbTZaJ" +
       "Y0nZpOfEPOLGdT9Gs1KtBsubzqqKxK7ek+cJHY4NHF20pynWon1uOOlkejcc" +
       "pdm6jqpVV8/q9WQ6qDF4abzdamKvJ9G2zC+1ViYvNsbKb6Cq1VtK+rDDcXY8" +
       "rqUc2hKGKa+KGYxOJTrmpZFNrIhsu8iqjXmXUlotJa6ssqyKjrj5VOB8osNM" +
       "U8aHm5QxsGrN2rzcdtei0xCprLmJLXJRnnqmVm1mrNJEhqxZUxXGj3UsaDWV" +
       "ahlZwDME2KWidugJNWIqi9oUiUlkFEfyZl5vC8PVrN8PZpFgluAEH5aWZmk4" +
       "XIs9ONYdkKJN02aMpXRYt/W03SRHfTbdGv3KZjaTPVb0KGksKWPOKROVqINV" +
       "shFsGmagWA6ClVwVXSuJoNnmqB2CLEeqRNMS6w8pj0GIklXvsKmN1Rq1tIRt" +
       "aoRLL3Wh3RMz3uBrUtXPCNr2Rnq13hnyPQG8ShrerBuW6kuM5PjJWFdbE1/T" +
       "+YmgwXAXOKGGLzBJ6GfDrU+ndWIpTiooHTb05TZM/aZf7eINFN3IIqcNeVmW" +
       "xBrrZkKoL/FR1stSNZrPGKHZU/pa2HRJ8Ipa4w29KQ6aMEV2K1PfI5x0ASeo" +
       "LdnL0FCCgdeF9QVIaD21vRCDAJ6WvVq50l716rPOgFiPGTXV4XC2QoQMJqdK" +
       "f1FjmVRJy61FaVyLJ90Q5QZeJqJGWmLVadCXqS7l2DEywLWsm7V8RPNgOmEE" +
       "1UDkVGdQy2qojgd8TiDMIKnWAXpgqZksDSRbDbxxDVmglaaEWiVUEOjyisPG" +
       "IzagyR7ZtscI3Tf9wFhbjg1e+Dw2MBM91gS4U2KW8lIvlbJWfS4qzep2zU2E" +
       "FZU2EU+ao1a2bbYGS0pez8OuMbGEJeVsuU7YIAJEc0baoBbHa8FdJctWVCv3" +
       "A96ueBhN6WvMjgSt01YaibbVki49dE1hnkqDKlEaxNEq7vDtajqjJwtZbKza" +
       "SuSUh4iZlFq4Ml8yA3ddb3l+U5iqPa80hQnUpWRtO+6IGJZ/Er75x/sqv7Mo" +
       "QByeCoGP8fxB58f4Gt09ejRvnjgsuhbX+Vcouh4rTJ05KHY8cE2d/VhlPf8M" +
       "f/BGJ0LFJ/jH3vnc8yb/8creftVvnEC3JEH4c661stwT60XQUzcuN7DFgdhR" +
       "Nerz7/yX+4dvmL31x6i3P3xKztNT/j77whc7rzV+Yw+66bA2dc1R3Ummp09W" +
       "pG6NrCSN/OGJutSDh+YvtuCx/S042Irr1Lyv6ypnClfZOcipoupeQbBX3EvH" +
       "HENOoJscvygOpwVj8grV2G3eBMD1bGv/6GRgLdO84A825okbb0xRDd6VdZ7/" +
       "nce/8ivPP/73RUH1ghPLWoRF9nXODI/xfO+Fl77ztdsf/FRxAHFW1+Kd5U4f" +
       "tl57lnriiLTQ4LZDQxda5cdmd+8b+u5d3Z39iY60rnNG9n87YaFFGoYhdBTj" +
       "4Y+qOJ0oLCfQXdeefuXl+/uuOVvfnQcbn3r+4oV7nx/99c7+B2e2tzDQhWnq" +
       "userrcf658PImjqFuLfsaq9h8efdCXTvDU7lEuj8rlMI/a4d/a8m0KXT9Al0" +
       "Nv9znOzXE+hVx8gS6Ob93nGiDwBnB0R599nwOoXaXdV5c+YY5OyDZGHnu36U" +
       "nQ9Zjh8Q5dFQ/HPDAaSku39vuGp8+nmae9vLjY/vDqgMV8uyfJYLwHF3Z2WH" +
       "sPToDWc7mOt898kf3PGZW544gNA7dgIfgcUx2R6+/gkQ6YVJcWaT/fG9f/j6" +
       "333+m0Xd+H8BXjnWa3UiAAA=");
}
