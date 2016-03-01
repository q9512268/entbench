package org.apache.batik.extension.svg;
public class FlowExtTextPainter extends org.apache.batik.gvt.renderer.StrokingTextPainter {
    protected static org.apache.batik.gvt.TextPainter singleton = new org.apache.batik.extension.svg.FlowExtTextPainter(
      );
    public static org.apache.batik.gvt.TextPainter getInstance() {
        return singleton;
    }
    public java.util.List getTextRuns(org.apache.batik.gvt.TextNode node,
                                      java.text.AttributedCharacterIterator aci) {
        java.util.List textRuns =
          node.
          getTextRuns(
            );
        if (textRuns !=
              null) {
            return textRuns;
        }
        java.text.AttributedCharacterIterator[] chunkACIs =
          getTextChunkACIs(
            aci);
        textRuns =
          computeTextRuns(
            node,
            aci,
            chunkACIs);
        aci.
          first(
            );
        java.util.List rgns =
          (java.util.List)
            aci.
            getAttribute(
              FLOW_REGIONS);
        if (rgns !=
              null) {
            java.util.Iterator i =
              textRuns.
              iterator(
                );
            java.util.List chunkLayouts =
              new java.util.ArrayList(
              );
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun tr =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                i.
                next(
                  );
            java.util.List layouts =
              new java.util.ArrayList(
              );
            chunkLayouts.
              add(
                layouts);
            layouts.
              add(
                tr.
                  getLayout(
                    ));
            while (i.
                     hasNext(
                       )) {
                tr =
                  (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                    i.
                    next(
                      );
                if (tr.
                      isFirstRunInChunk(
                        )) {
                    layouts =
                      new java.util.ArrayList(
                        );
                    chunkLayouts.
                      add(
                        layouts);
                }
                layouts.
                  add(
                    tr.
                      getLayout(
                        ));
            }
            org.apache.batik.extension.svg.FlowExtGlyphLayout.
              textWrapTextChunk(
                chunkACIs,
                chunkLayouts,
                rgns);
        }
        node.
          setTextRuns(
            textRuns);
        return textRuns;
    }
    public FlowExtTextPainter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4tF+VTXvC0InuOVVlQf4D1jz0H8AHgksnK0ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVaeczsVnX3+5L3kveyvJdAlgayv0CDw+fxbJ7pgzbjsT2b" +
       "Z2zPPm7h4fHu8TZex4ZQoAtRkVLUJpSqkEoVqIACQVVRW1VUqaoWEKgSFeom" +
       "FVBbqVCKRP6AVoWWXnu+/S1p1D86ku/cufecc88599zfPb53XvgudNr3INh1" +
       "zEQ1nWBX3gS7hlnZDRJX9ne7dIUVPF+Wmqbg+2PQdll85LPnf/DDD2oXdqAz" +
       "PPQawbadQAh0x/aHsu+YkSzR0PnDVtKULT+ALtCGEAlIGOgmQut+cImGbjnC" +
       "GkAX6X0VEKACAlRAchWQxiEVYLpNtkOrmXEIduCvoXdDp2jojCtm6gXQw8eF" +
       "uIInWHti2NwCIOHm7PcUGJUzbzzooQPbtzZfYfBzMPLsb7z9wu/dAJ3nofO6" +
       "PcrUEYESARiEh261ZGspe35DkmSJh+6wZVkayZ4umHqa681Dd/q6agtB6MkH" +
       "TsoaQ1f28jEPPXermNnmhWLgeAfmKbpsSvu/TiumoAJb7z60dWshlbUDA8/p" +
       "QDFPEUR5n+XGlW5LAfTgSY4DGy/2AAFgvcmSA805GOpGWwAN0J3buTMFW0VG" +
       "gafbKiA97YRglAC675pCM1+7grgSVPlyAN17ko7ddgGqs7kjMpYAuuskWS4J" +
       "zNJ9J2bpyPx8d/CWZ95pt+2dXGdJFs1M/5sB0wMnmIayInuyLcpbxlvfRH9I" +
       "uPvzT+9AECC+6wTxluYP3vXyk0888NIXtzSvuwoNszRkMbgsfmx5+1df33y8" +
       "fkOmxs2u4+vZ5B+zPA9/dq/n0sYFK+/uA4lZ5+5+50vDv1i851Pyd3agcx3o" +
       "jOiYoQXi6A7RsVzdlL2WbMueEMhSBzor21Iz7+9AN4E6rdvytpVRFF8OOtCN" +
       "Zt50xsl/AxcpQETmoptAXbcVZ7/uCoGW1zcuBEE3gQe6FTxvhLaf/DuAPERz" +
       "LBkRRMHWbQdhPSezP5tQWxKQQPZBXQK9roMsQfyv3ozuYojvhB4ISMTxVEQA" +
       "UaHJ285sncq2DyxG/EgFMezE5CYYg1ZWyON4N4s99/9l1E3miwvxqVNgml5/" +
       "EiRMsL7ajinJ3mXx2RAnX/7M5S/vHCyaPS8GEAqG3t0OvZsPvXsw9C4YevfK" +
       "oaFTp/IRX5upsA0KMKUrAA4ANm99fPS27juefuQGEI1ufCOYj4wUuTZ6Nw/h" +
       "pJODpghiGnrpw/F7pz9f2IF2jsNwpjZoOpexsxl4HoDkxZPL72pyz7//Wz94" +
       "8UNPOYcL8Riu7+HDlZzZ+n7kpIM9R5QlgJiH4t/0kPC5y59/6uIOdCMADQCU" +
       "AfBYhkEPnBzj2Dq/tI+ZmS2ngcGK41mCmXXtA925QPOc+LAln/nb8/odwMdv" +
       "gfaKYysh632Nm5Wv3UZKNmknrMgx+a0j96N/+5ffLuXu3ofv80c2xJEcXDoC" +
       "GZmw8zk43HEYA2NPlgHdP3yY/fXnvvv+n80DAFA8erUBL2ZlE0AFmELg5l/6" +
       "4vrvvvH1j31t5zBoArBnhktTFzdbI38MPqfA89/ZkxmXNWyX+53NPcx56AB0" +
       "3GzkNxzqBuDHBIsxi6CLE9tyJF3RhaUpZxH7o/OPoZ/7t2cubGPCBC37IfXE" +
       "Kws4bP8JHHrPl9/+7w/kYk6J2fZ36L9Dsi2mvuZQcsPzhCTTY/Pev7r/N78g" +
       "fBSgM0BEX0/lHOSg3B9QPoGF3BdwXiIn+opZ8aB/dCEcX2tH0pTL4ge/9r3b" +
       "pt/7k5dzbY/nOUfnvS+4l7ahlhUPbYD4e06u+rbga4Cu/NLg5y6YL/0QSOSB" +
       "RBGgms94AH02x6Jkj/r0TX//p3929zu+egO0Q0HnTEeQKCFfcNBZEOmyrwHg" +
       "2rg/8+Q2muObQXEhNxW6wvhtgNyb/7oRKPj4tbGGytKUw+V6738y5vJ9//gf" +
       "VzghR5mr7M4n+HnkhY/c1/zp7+T8h8s9435gcyUig5TukLf4Kev7O4+c+fMd" +
       "6CYeuiDu5YtTwQyzRcSDHMnfTyJBTnms/3i+s93cLx3A2etPQs2RYU8CzeFO" +
       "AOoZdVY/dwJb7sq8TIHniT1seeIktpyC8sqTOcvDeXkxK96Yz8lOAJ11PScA" +
       "Wsogxzvj58lpPsjjoMsH2ZopB3tevyuAHrpiQ1KjYPfI/rOFsqwsZUVjGwDV" +
       "awbLpXyozSmAKaeLu9huIfvdu7qyN2TVn8wKElArui2Y+5reY5jixX2omYJ0" +
       "GkTKRcPE9vW+kAd5Nie72xz0hJ6P/6/1BEF8+6Ew2gHp7Af++YNf+dVHvwEi" +
       "rQudjrIoAAF2ZMRBmGX4v/zCc/ff8uw3P5DjKABR9kPkhSczqZNXtDYrmH1T" +
       "78tMHeWpCS34QT+HO1nKrb3uAmM93QI7RLSXviJP3fmN1Ue+9eltanpyNZ0g" +
       "lp9+9ld+vPvMsztHXggevSInP8qzfSnIlb5tz8Me9PD1Rsk5qH958ak//sRT" +
       "799qdefx9JYEb2+f/uv/+sruh7/5patkSzeazv9hYoPbftQu+53G/qc/XShz" +
       "fDLdzJAwaS2JQg/uNEhCwxtNitOxobru47rPqYthmHQdcugMCqESFbFwiRcR" +
       "Ucbq6GDgU72FsAicCsrgiTaiZW2ydpd4wST5YMxSTKdabAtxvzhoFYVeySSq" +
       "xYmldNtW4sL2PFLq9ZAdW6KYigkGl2glVBRRrmERwpQr9fpmMO1VvDVVokSt" +
       "164uhr16u9mPRDl23cHKKA9RZahVy7XeHCmN/TI7jNZqmZrMVBJdVPRoijSY" +
       "YKWTuuUa1SblrDdjuhGQpUKls3KKHWHC2UVNtxy9xzpNfojVQmel652AqndJ" +
       "XYjJYjBEOw0XFYek6XZgMe71qNW8Iujd2oBvDRSnHfZ6zpBqz5stidDBY8A+" +
       "v+qXy7At0NUqVa5p+oDvrdbDdc8YY27Smq7XvUG3NaNwx2KGntyrFjbEkgxC" +
       "fckSTIlFabQEV9pD2aq2ilN9Ronr0rpRG835dmtE9HpVN5XTId2tstHQRHGe" +
       "6qOF5pSdkMvZZLjCXbw7FODSbLVgZ6neTQf1plZj6iOhJ3C9JUlOaIVnHKsz" +
       "4Gsbd2Gngz7ZNweKwuC1QViEU2kWYsWl0h6afNuYY0UbiQJz3SoDf9oJSYVM" +
       "oxOqTosjCdJJmgLttiqD7krb4MS4U1Y6mtNxl+RIYpfGcr0wjfagoXK+jxGM" +
       "RzoFL2A21Fwd1de8iYP3kHrEj9rU2FLgidsUJM2rlZi5U5CWVrvu96k1ORQs" +
       "d4yr6SZOFpWa000tJmqyPjtfigTXiYNml6j2NH1dcbQFrDUMjie7zcTuFPoN" +
       "1lgNnHDS4yjCmDX9pLdkUN2Z1hmypFP9UprUZv1xgk83XAnXTGJSwRWjX27N" +
       "Z/ZGFiPbrkRLlNjAnAxP1KbfFFaFEVdkXTte47NSFcdXekdQx2qMB4Kvd7FG" +
       "Ktak5qhDxqsCvJiw1hCFa4HQSiXZobgiDzd4C99QZb1Aa3HXpDB+0mZrK3ji" +
       "z6aTteOE/VDCJL9q0C0eropVNybGg7qT+ou6UWWIeTmpIYpUWYrNHr1mNW5E" +
       "Na1lYxijTdJtUaOZvhxNksK4YSbjymQoD1cEgsha4qnsyOttGFUa9aYFLoo4" +
       "omOWtOEYZiuqg0/7MYnOiTDRbYoJpM18NIlgaaJRDYrtqS3bCLmaKCE9qaM7" +
       "hXVrSDcb/JSadQxqsFACmwhnIlcalse17ny6WK0aLIJN7RmFFqaFruDjnSbT" +
       "M52KyvUnTn9cTZjmLCGMkKm2Bm5MN5LIMNtalSxphsXE8QarRnVKKGP8IuLL" +
       "nQYezsKG3eRsfY0Cg1YjulmTUytdKrLhwgnXUJsbb6xrQ1SV17Ez9gCaSQE6" +
       "o7i2WJkbXAf3bJKZlTt40yZcVm+0F4wsVCYMFsCFSsEstwRq3ObLDcRi9CQa" +
       "MOtNkRzqiGfE3spT68x8XnXgVmGIdwD22dSSWUltjRn3+mShPsa7HTLV3aJM" +
       "qWRLN+E5PhTxilNl5hWnUmuxtfmsPAYIshivuBbuy4v6JljDRjwswZos+zLS" +
       "D7BKARHXqVorE+bMG/TjZTIyzJKAKEhxacS+V4yaFNxmS5I6HhJMwy+3Vj3C" +
       "6k+KjDcvCy1+6YRJcVpeL8S+OxQDVZ8XE7BhCobl9cIBS6iS0rD0BaHGMROp" +
       "0ySIkMmq7a3NKYwEvLssGM6iasY2rDW10qicLNw+KgauKw4aqIeTTdGulVvj" +
       "qFjtF9pSiXJUcTTiVAebDXyi2xjLDS6SkRoNTxGkDLvWXI3LYo9PW0WOWw0M" +
       "CzZTGwGLusGydZ1I+hxqkdxoxrDJjA8GbtEds/2EL6KNJd4jGW7Q3sRlPm7K" +
       "1rCbcM1OSCl1LsCWXlz3WVTzfLNKt7lCZONkatTbdYvEvKCQljjPThaq32Gn" +
       "Pl8zeI9Aly3FMvh1q1tXq6Ijh7Sd+vI87sk4XJ5qog2wht0wRTxssFGFFjq1" +
       "toBi9UBA7bGzdDZYXNOnjf6MGqIVmK8vGSnB5PI6QgFqhREiGYEUNFYySU3o" +
       "hWwtiu00sOe8O0PFEhNrngkXQpuCda0vhcqkriOTEcqUOLnQAdDRAFCNE6Ia" +
       "VcotsCRRuSZ5rBJUa5WCwzetCo7yveYK9WMi1Sb4RLVh3Yj5FVavN3ijLTPT" +
       "wmCYytVGrZm2DDrx/NQv8Oa80x6zlTKmInMFVgrVTULhYWoV6+nC9OUBS05L" +
       "ceQBA2EECVh3iU4WOJImZTO1WqkSYfFgVI6aSwyWKqo3WKjymBiUyisxxDam" +
       "W8WWEbEh3GJcmAQJzIkM2Sun9XBg9+Faq1hgkGav1yOnXGQxdjzWN+ZsNGK5" +
       "xtqZpavE7ScgT6gUUl+TQqtYnTNNu+9KAlshK/imWOsX7SLrh22w/1mbUSmW" +
       "umuniowM2iHKo6Sm+O6o1C7OB6MQa3bIKdg+eW7WnOEUIaxq9Rjjawg7Gffs" +
       "DRvHc0fuT0f0ROoXanrgJUQ4L7QaRSy1moREWZhhTOuah4WcYwyoaaWk0miR" +
       "CaOVUiVHBVlu0rPeMKTxReQHaX3MtI1KnSGMlOcXzWKBD4ilsxhV5yFAVjmK" +
       "dUWRaaoxMrsUNZ9Nh32hUxl0eLw7o2uFnmlXRIIIsdmcL4RhiS/MVyiM+5Ql" +
       "6MVRuxo7bXMA42JNQayIrlFFQ04rpOARHT4xEJNEULsUbKoprQldfD5oLPu1" +
       "xNGwKh7SmO4NuJ5ppamvznUMk9xZxaPNWnvEe2Ep4eoJPkmrMDOpLApwjZAm" +
       "TLc18cUuvBqVCuPZouNa7pr0RWIVVlaN+oSj17A87jPGMsaCUrHs2bHSNmZW" +
       "J1AmtY7oDWytNJdQXWjBETcdVLuuFi1xZ9aqtaeUOxohphuvvJLfLk5XYczj" +
       "kxjfzLS6yRJ9Ta+P6GKbbkrLjqYXed1v+R7NpImGEliLt3vdiKuOGnIFIZfU" +
       "prKOEIRrD2clVFvjRZTniuZc8NyKPKtLxboXJh2pMpTb3WiiRJY6CdgeDQNO" +
       "roeuugTRt7C6gtEpsoQZsUp4fJfyY3QzTYYROuiFHj2WJXMR9AsTgyVhPg17" +
       "CMWU6t6GX/fJlcX5k/6kra1m/YTr0gHeMXpo4tOIM162kohNQdK2wRZTO8JK" +
       "4YhRbNto9CNM7VTHdsIitt9CJWbMlxEebRT6aZ3qlSNJDadKtGyt+ZnVTXwf" +
       "LyyDJZvaKBrNpLDct6RWwIsowjQdTZBqFbs7oNrLvtrGyNG6uKitFkiXQ6sW" +
       "0p6nqsm1HD1yOX66mNWLUnde79JgA68OwlbTtFmlXMdddhbMKlNtw1GUqs08" +
       "S+STsdlA2NHY7IhIlxYqfD/1QwwbD8J1Z2SP69I0NYr1ckmuRfQgWs0ctW92" +
       "+dGctpk1Vlr11kOzr5UmrcGK1T2EyUaX7Z5d7SQCayfGxjXGIHea2HHfHkTF" +
       "sBRNFpvxFC5Iw2m/gpTmPXaCjoOEJC1+mZSHyzIuxJ1hPXIH6KTbRtRJq4PO" +
       "1VbBgPXhQnbcdULUaIqXp2LcjUDoVHxYbyBh0FO6w8qqVg7EZskDmZTZqBTq" +
       "UbGEqSh4czdkd75iiVW3G5hdlWDWdDtot6hNQbJ8kALWkyIyZ00GRTvOcIzM" +
       "g7kWtqkCR3rocKkwM7VkUXNNgOXZHNm4I0ZbbwgpRBsNIijxIUKnIG8XtNHA" +
       "mGJDTiDJ1mYUTbHQ8+SkiiDoWl3xYok3mkVTA+8C5YoU4Ty9lr25utbXRGVK" +
       "RCstiZpGOe1wtVGH26RDxgVQMjLlAlZC1y2lH4fy0jTHHZbx7YjfcBqFza1S" +
       "yE1CvUokrUQRuoaAgW1N9pprbx1WoxLdVfozo8GQdq8cUPB0PI+ahY4dMtOp" +
       "ySllAjXSQrvWaKsr3+4VePC299bsNVB5dW/id+SHDge3YOAFPOvgXsUb6Lbr" +
       "4ax47OBMJ/+cuc558ZEzNSh7q77/Wpdb+Rv1x9737PMS83F0Z+8sUgigs4Hj" +
       "vtmUI9k8ImoHSHrTtU8P+vnd3uEZ2Rfe96/3jX9ae8eruAV48ISeJ0V+sv/C" +
       "l1pvEH9tB7rh4MTsilvH40yXjp+TnfPkIPTs8bHTsvsPPPtA5rHHwYPueRa9" +
       "+kn81Y/KDqNgGwDXOe9913X63p0VcQDdosrBvhlZU+swZDavdGhxVGbeEBzY" +
       "mJO9DjyVPRsrr8LGU7mNVzVvZy9I9g7U7r/mQeDAkeR9qsfyQ7Dsonu3EQSe" +
       "vgwDWWpqICrEQPY6gZzfMOTjPX0dlz2TFb+wdVk2xDC0/WOnScejdSjE+RK4" +
       "LP4R982vfjR98YXtYdFS8OUAgq/1V4Er/62Q3Sw9dp3bscNL5O+3fuqlb//T" +
       "9G37i+yWg/m4JbPi/PXmY99Ztx89vN9edDx3GBO/+GpiYhNAd155N5hdbtx7" +
       "xd8Vtlfs4meeP3/zPc9P/ia/Hju4Bj9LQzcroWkePYs+Uj/jerKi5xaf3Z5M" +
       "u/nXRwLogetfXQbQDaDMFf+tLc9vB9B91+YBoHVQP8r1OwF04SRXAJ3Ov4/S" +
       "fTyAzh3SBdCZbeUoySeAToAkq37S3Z+UK29gszj3ZFuSPdnLDpOdlW6rR7y8" +
       "OXUcnw9m8M5XmsEjkP7osajL/4myD5ohuxfcLz7fHbzz5erHtxeDoimkaSbl" +
       "Zhq6aXtHeQC8D19T2r6sM+3Hf3j7Z88+th+/t28VPoSKI7o9ePWbN9Jyg/yu" +
       "LP3De37/Lb/7/Nfzg+7/AWGFNlUiJAAA");
}
