package edu.umd.cs.findbugs.util;
public class EditDistance {
    private static final int INSERT_OR_DELETE_COST = 2;
    private static int minimum(int a, int b, int c) { if (a > b) { return java.lang.Math.
                                                                     min(
                                                                       b,
                                                                       c);
                                                      }
                                                      return java.lang.Math.
                                                        min(
                                                          a,
                                                          c); }
    private static int distance(char a, char b) { if (a == b) { return 0;
                                                  }
                                                  if (java.lang.Character.
                                                        toLowerCase(
                                                          a) ==
                                                        java.lang.Character.
                                                        toLowerCase(
                                                          b)) { return 1;
                                                  }
                                                  return 2; }
    public static double editDistanceRatio(java.lang.String str1,
                                           java.lang.String str2) {
        double distance =
          editDistance(
            str1,
            str2);
        int maxDistance =
          INSERT_OR_DELETE_COST *
          java.lang.Math.
          max(
            str1.
              length(
                ),
            str2.
              length(
                ));
        return java.lang.Math.
          min(
            distance /
              maxDistance,
            distance /
              4);
    }
    public static int editDistance(java.lang.String str1, java.lang.String str2) {
        int n1 =
          str1.
          length(
            );
        int n2 =
          str2.
          length(
            );
        int diff =
          java.lang.Math.
          abs(
            n1 -
              n2);
        if (diff >
              6) {
            return INSERT_OR_DELETE_COST *
              java.lang.Math.
              max(
                n1,
                n2);
        }
        return editDistance1(
                 str1,
                 str2);
    }
    public static int editDistance0(java.lang.String str1,
                                    java.lang.String str2) {
        int n1 =
          str1.
          length(
            );
        int n2 =
          str2.
          length(
            );
        int[][] distance =
          new int[n1 +
                    1][];
        for (int i =
               0;
             i <=
               n1;
             i++) {
            distance[i] =
              (new int[n2 +
                         1]);
            distance[i][0] =
              INSERT_OR_DELETE_COST *
                i;
        }
        for (int j =
               1;
             j <=
               n2;
             j++) {
            distance[0][j] =
              INSERT_OR_DELETE_COST *
                j;
        }
        for (int i =
               1;
             i <=
               n1;
             i++) {
            for (int j =
                   1;
                 j <=
                   n2;
                 j++) {
                distance[i][j] =
                  minimum(
                    distance[i -
                               1][j] +
                      INSERT_OR_DELETE_COST,
                    distance[i][j -
                                  1] +
                      INSERT_OR_DELETE_COST,
                    distance[i -
                               1][j -
                                    1] +
                      distance(
                        str1.
                          charAt(
                            i -
                              1),
                        str2.
                          charAt(
                            j -
                              1)));
            }
        }
        return distance[n1][n2];
    }
    public static int editDistance1(java.lang.String str1,
                                    java.lang.String str2) {
        int n1 =
          str1.
          length(
            );
        int n2 =
          str2.
          length(
            );
        int[] distance =
          new int[n2 +
                    1];
        int[] oldDistance =
          new int[n2 +
                    1];
        for (int j =
               1;
             j <=
               n2;
             j++) {
            oldDistance[j] =
              INSERT_OR_DELETE_COST *
                j;
        }
        for (int i =
               1;
             i <=
               n1;
             i++) {
            distance[0] =
              INSERT_OR_DELETE_COST *
                i;
            for (int j =
                   1;
                 j <=
                   n2;
                 j++) {
                distance[j] =
                  minimum(
                    oldDistance[j] +
                      INSERT_OR_DELETE_COST,
                    distance[j -
                               1] +
                      INSERT_OR_DELETE_COST,
                    oldDistance[j -
                                  1] +
                      distance(
                        str1.
                          charAt(
                            i -
                              1),
                        str2.
                          charAt(
                            j -
                              1)));
            }
            int[] tmp =
              oldDistance;
            oldDistance =
              distance;
            distance =
              tmp;
        }
        int result =
          oldDistance[n2];
        assert result ==
          editDistance0(
            str1,
            str2);
        return result;
    }
    public EditDistance() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVaf+zrVnX3+772vdfS9r220JaO/n7taM2ekziJYxVYEyeO" +
       "ncRxYueXM8bDv+3Ev3/ETlg3ijSKxsSqrWVsgmp/FG2w8mPTEEgbUxHagMGm" +
       "sSHYJg0QmjQ2hkQ1DaaxjV07399973VVaSTf2Peee+75nHvOucf3+tnvQVeH" +
       "AQR7rrXWLTe6oKbRhYVVuRCtPTW80OlVBmIQqgphiWE4AnUX5Xs/cfYHP3rC" +
       "OLcDnZpDN4uO40ZiZLpOyKmha61UpQedPahtWaodRtC53kJciUgcmRbSM8Po" +
       "4R70qkNdI+h8b08EBIiAABGQXASkfkAFOl2vOrFNZD1EJwp96BehEz3olCdn" +
       "4kXQPUeZeGIg2rtsBjkCwOFM9jwBoPLOaQDdvY99i/kFgJ+CkSd/863n/vAk" +
       "dHYOnTUdPhNHBkJEYJA5dJ2t2pIahHVFUZU5dKOjqgqvBqZomZtc7jl0U2jq" +
       "jhjFgbqvpKwy9tQgH/NAc9fJGbYgliM32Ienmaql7D1drVmiDrDecoB1i5DM" +
       "6gHAa00gWKCJsrrX5aql6SgRdNfxHvsYz3cBAeh62lYjw90f6ipHBBXQTdu5" +
       "s0RHR/goMB0dkF7txmCUCLr9skwzXXuivBR19WIE3XacbrBtAlTX5IrIukTQ" +
       "a46T5ZzALN1+bJYOzc/3+m9879sdytnJZVZU2crkPwM63XmsE6dqaqA6srrt" +
       "eN1DvfeJt3zm3TsQBIhfc4x4S/OpX3j+kTfc+dwXtjQ/dQkaVlqocnRRfka6" +
       "4SuvIx7ET2ZinPHc0Mwm/wjy3PwHuy0Ppx7wvFv2OWaNF/Yan+P+XHjHR9Tv" +
       "7kDX0tAp2bViG9jRjbJre6alBm3VUQMxUhUaukZ1FCJvp6HT4L5nOuq2ltW0" +
       "UI1o6Corrzrl5s9ARRpgkanoNLg3Hc3du/fEyMjvUw+CoNPggq4D12uh7S//" +
       "j6C3IIZrq4goi47puMggcDP8IaI6kQR0ayAaMCYp1kMkDGQkNx1ViZHYVhA5" +
       "PGjMddFSzKhpZs4sqxcyUu8V5p9m+M4lJ04A1b/uuONbwGco11LU4KL8ZNxo" +
       "Pf+xi1/a2XeEXc1E0P1guAtguAtyeGFvuO3sHR4OOnEiH+XV2bDbZjA1S+Dk" +
       "gOC6B/mf77zt3feeBFblJVcBvWakyOWjMHEQFmhnO8BFGXru/cljk18q7EA7" +
       "R8NpJiqoujbrPsiC4H6wO3/cjS7F9+zj3/nBx9/3qHvgUEfi866fv7Bn5qf3" +
       "Hldq4MpAX4F6wP6hu8VPXvzMo+d3oKuA84OAF4nAQEEsufP4GEf89eG92Jdh" +
       "uRoA1tzAFq2saS9gXRsZgZsc1OSzfUN+fyPQ8e3QbnHEorPWm72sfPXWOrJJ" +
       "O4Yij61v4r0P/t1f/Quaq3svDJ89tLDxavTwIdfPmJ3NnfzGAxsYBaoK6P7x" +
       "/YPfeOp7j/9cbgCA4r5LDXg+Kwng8mAKgZp/+Qv+33/zG898defAaCKw9sWS" +
       "ZcrpFuSPwe8EuP43uzJwWcXWbW8idmPH3fvBw8tGfuBANhBGLOBqmQWdHzu2" +
       "q5iaKUqWmlnsf5+9v/jJf3vvua1NWKBmz6Te8OIMDupf24De8aW3/vDOnM0J" +
       "OVvGDvR3QLaNjTcfcK4HgbjO5Egf+5s7fuvz4gdBlAWRLTQ3ah6soFwfUD6B" +
       "hVwXcF4ix9pKWXFXeNgRjvraoXTjovzEV79//eT7f/p8Lu3RfOXwvDOi9/DW" +
       "1LLi7hSwv/W411NiaAC68nP9t5yznvsR4DgHHGWwSIdsACJOesRKdqmvPv0P" +
       "n/3cLW/7ykloh4SutVxRIcXc4aBrgKWroQGCVer97CNba07OgOJcDhV6Afit" +
       "gdyWP10FBHzw8rGGzNKNA3e97b9YS3rnt//zBUrIo8wlVtlj/efIsx+4nXjz" +
       "d/P+B+6e9b4zfWEUBqnZQd/SR+z/2Ln31J/tQKfn0Dl5N++biFacOdEc5Drh" +
       "XjIIcsMj7Ufzlu0i/fB+OHvd8VBzaNjjgeYg+oP7jDq7v/ZYbMlDCQauO3Zj" +
       "yx3HY0u+GmznOBPpAg3SNF0Nbvr27zzzw8cer+1kBn31KhMdaOXcAV0/ztLL" +
       "dz371B2vevJb78mdH3DeyZg+kg9/T16ez4qfzuf3ZASd9gJzBXwcBIgwT1cj" +
       "gMl0RCsX+0GQaNF9vsWNLrLcxWar1xq1LhIsP7qyYQwC0waRbbWbPiGP3vTN" +
       "5Qe+89FtanTcCo4Rq+9+8ld+fOG9T+4cSkjve0FOeLjPNinN5b0+Fzrzq3uu" +
       "NEreg/znjz/6x7/36ONbqW46ml61wNvDR7/2P1++8P5vffESK/tJkDpvl4Cs" +
       "RLOivnWc6mWd7OGtbCdALL66dAG7UMiex5eZmOz29VlBZQW9Nxm3Liz5/F58" +
       "noB3CeBe5xcWlvd/TXTYGrYJ+DEhH/x/CwlUeMMBs54Lcvn3/NMTX/61+74J" +
       "1NHZs7+MmgDLC/+g9O+PZA9vfWl4bs/w8G4cyGpPDCMmXwhUZR9S95DQbASW" +
       "E/dlQIpu+DRVDun63q83mWvTZJymY83Z1NKGA9ebo4WgN0m649QpUWi0PGOY" +
       "dDxTHpRczO+YLaGErzYWJpSKxdIcLmyspqB7SmPKjYap0RU7xRFML806L/bH" +
       "rj/xeN80NNq3x1aTX47HRrdbGZe4YcmvWxPPxspojGqYzMH1BqFFaB9j7I2y" +
       "0lYDG8cxhpLwlqmXlD7ZJRuK7XJuUY9rnWqjX9LD0XzO0Cns0zG9SOUugqfr" +
       "UF2pdWI5pzss1ej2R2R9XR35nfWmoevNecdkWi3OV0hSHKYYzi7G7sBPEoKb" +
       "tHmiuIzaXKHNdSzSdNo+44YkNUyqnCi01jPXFBeUJBCcERBCy6anaUfEpnjc" +
       "nDPdsTJpUxrl9Vat0iSJuh1vnTZbop9EcUvgySWzXLIGP21G/Lwo+6q99tlm" +
       "GPpEn7GJEsxbfX0oJctwQ7f16nTmWKWwbXR1rEG2SG7CiM4c4fhhZUqJfMp0" +
       "PVRUvKW9aKDLaXWYjAixajQsr+nL7abc1mlOL/QnEUX4a41rjDcFUVpXJWLs" +
       "GZ0+RzOCrfYnrm5Xl73mBKcIaThm5iGssWytH86riiPWCmuh7FOYvu4PpKpV" +
       "tVXSo7r1ScvrUhV3oRstpmEs68P20uSdyULh07aQsMupS5GYz1Y7zIIfObEl" +
       "Jqk3brQFQo41XR8HIwH1tVZCdYsGZXei2FxuJgWc7cllda2lM2o+bQ0rVuBs" +
       "+lOxPPJDI7GnfIkQKEOrY3ASc0podWSJ7lHwAG+sJSyRG1XSF912So+G+MSr" +
       "G8PhFExZpUXOR81xo1p1mnTHDYcu6zf7vFNkPMEvdMrO3Fi2pCGNFteDiTDi" +
       "W6g+bNdnnB3ggpWMArKLS5WJXEVZT6xNGzPZq3bG9W7CCgI5nRa0dacgrrhi" +
       "1Z+kvjUQGkWJMvWZkRR6iq8VGsMlUS6aSriWNoWNHAfkQlS1iOVjnu2NKKXQ" +
       "TidzrpmIjraJNz1xqiYrbtHs9Ps8J2sMwsA8FoSTSFymIDMniyK9EdrjcslR" +
       "i4iGD+opbNl1i1KHLas92QxH5bE0dTsLruOtPHzSbVeTthnqhbXO++t+hKrD" +
       "saMP+MQvisFqIQvsumnRy1rV5S2t1jbZrl43W76BKh1TjD2lUNSHSIL7HEnw" +
       "ccsgtSZD90VK2wzWQtugRwoxpOt+1+uaBmWhJMyFhtBJXKEZjk2X2XBysUGX" +
       "Rq7gmljTLc3pEcMRZbtdqJmpSOMdqVtcyhNmyEkzKWjCnVolXI+ter3AIAUJ" +
       "TeZ4mFYnQoUb8F3Wnq7EHlYbslOmQk7LrXZqtSshmQw5Pe42gkaRak6rgU3R" +
       "yZjUOrzHdjeTZiveUCOhQpB8AW+WCoK6gr1lL+napSVBNcgCPx9EbWtjEw0S" +
       "TamUY0pLZzZge+iyOKQDwmsJQ5t36HYznVbL/ToPd0oqrEw5osWyKqlHZigL" +
       "jc1owlG22+/LgkxNx77AjlM0aM8dv+DVu5NAj4aY1eQmErZWlwsaDUuaE6V6" +
       "na+1hgTVq0vrJC7jYHY8zcZKGJKGqrlCZ1K6Lq8acVFt1UcFo8PJXcZZmFQn" +
       "qGkw2+6Y9cgm1nh7FBfjStAY1OmKXY8Tz+3hbSTVVdO2+oXRjPWGiU2RWtEg" +
       "GotxEizkhbgEpsA2Z9pQNFO/N8FJEqHn644D+ygqjmEFhnF1JRMgeosUT8oo" +
       "1m1HxRbX8n24PR7DxfK8h7Nd2cC17sgJx+wMt1Eb03Vexph+iQYTk9aHQb2s" +
       "w4wpsRusVhlsuDChKIOzWsKC6RLjEr8pzXwLqXs6qyAw0agI9ISkF5Oo7w36" +
       "I4udG+ZgoJSS5tjrG+Vqf9NvwrreiLry2KbXxgjdoDW/si5WamqN8v2NZfkt" +
       "u8IXekEVqftzODUWaW0eriacX7WHDK9X46ZjkhYzkGfcigxmxqRdoDHHWQmC" +
       "tuJbtcY8GQzaEc2ubWcU9lKaShoWSofkarCWLESSzY3dnpY1vFReTBB61BrC" +
       "KjLb8GmIa7G8jvDpfIA5sxXZ46brchxOhGajmm2GdHV5CoeFXle2EmHuaX5H" +
       "7KVG02U3caFYGExC2wlq7aS+IUKCssmCWGjyvIAHNtcjKxpcHqmrol3Eo0q9" +
       "VfTI9ZSbmNWEh8uy3qpRnN+st5FOMF0FUi9sE3bTdYPFcEQP1/6iPpmbE22G" +
       "Sq00WHSx3qYyXSIzhGJgCgRkz7fK5XIhqWEFhkgHxU6xr8UpusZxpOKqFFdN" +
       "h2ilK5VmG9xbwdi0jMUrjVgtqJnhdASrqVFFKtEVDevCkjpxVj282YtMjJ0v" +
       "555L6I5UQalxVGtNdV/li3VeV2hrqjupEZIlmcMHw2bH7VBdyyQreMBhrU0Y" +
       "mCWrv4QVZoC1K8ZqNrINRi1zJas2A/aSqJX1ukR5NaqUDEWkiXQScbYc28Yo" +
       "1Jtpacm6RRKtrHHWVzVNbsl0bdKsDjy95U9oXLGEFYY7Kku1TZHVNA9frQid" +
       "FUBGgDSNCsKuG0JMoo1xtw0WMaW+ZAW3QZgytVGH883S4BojX4gqyzI6EBBy" +
       "2a2UlMG0iCNzKnbChYivmpiGRktJildOZdVllKQ0VdrNoYmN9a6r9hfsIEb8" +
       "Eh/EEoxVQngSM1inELKc7yQoLrAMVcIxmyPhti4VkIbUCqQWQ5Trrj6Z6C15" +
       "ojnylNUGIqX0QVTUkJ5Zqwi45iFFQhngAo5gjGPoG6KjV9Ek7a8HpIKo6cbQ" +
       "4SosLdvlGTodqLMWFiGwuom1+XzSVyphzBVYvYYgSICvGmW8BlvilOsWh2EI" +
       "0zxBkyLXFaruTLSjpogVJbhqN/pgLaZrjdJyQ/JLipcik7LwGB8m7hoLnRnb" +
       "K8NIqdhsDplJN6k3FjQRdwTUHZDIfI4E8qKtM06IWn49KIfyCua15SINMZPG" +
       "dVNHK00XkwV+gBkFaYGOkRXP6Y3qOGp2DbHISR2ls+j2rLHlM07TqaC1iDWH" +
       "BVkdUQg66lVcqoinjOx6xYWidAYIhfbIBd6QLLw0RbptdIVMIhiR7UUwUvl5" +
       "iCYuPAHRDHVqgbayzXKtDfcpQQhthsam6Li6mmk1r7hepkptFjDogK+OwkFR" +
       "dDnHCkpxiCRMVTN4w+sn8SqskkEBbvirjou3Z3bKiRitIyu4Ndb6C27Qdpie" +
       "mejE2urztD9mGmzNggfrHo300EJzmJbdYtvHZ6vJwpBYSWIqEbLGml1PaVFD" +
       "psGnM3wV1Zf91UasoAZuei1dDheoyI175TE8nGKxZq0WG50KG2Zz3bcY2Zkz" +
       "fKWA4+W20rSNHt1wQgEly15EKsVWSekCTsy6iTkje7GSpk1uNEUqhlQbD1WM" +
       "EdN2m13agctWgiLd6CtS5HUF4Axz20ENalAfoCA9rWJERMwrVt8a9STDKccj" +
       "zm5U8AVWb+AA+nBQm5nsWPDRVhOjBjMBkzt+b7EOsLkdrWywqiud8hAkRmt3" +
       "MAkwsmzOyY7kJ1O41qjCM5GIZFst+XOpYQnxYiSD2LesCb0SWIlDOOxI5YQK" +
       "8IlLTBosXkRxxBBm/Wpq1ZpFZ1qCmU55rtiF2lCGyx2LhUO/Une605hweljM" +
       "DqtYsVUoWXI5Yv2wXqEmjlQemIORXCx4Q73Z6JWwwnS8qlFEfxS6RtNomXjs" +
       "jxHBH8nLqbCkKV/cFAbjyAuNWVniUc2gfLrT1nolfS6SZrW2FnqDpm3DYFmS" +
       "UDUMDL7Ys9UijSHyvN9NCpsgqMS02u7Uhrgar2uxGtnVGkc6QsyxxRFYXtCe" +
       "N+OrylpGOz4PL/2pgq8lrdchtD7Pi4iThsWojcqsQFVgtjhbxQm9tiMGHXI1" +
       "daZRXRaJeqjbX6zbc55m6qIkl2szXi4Cxu5GpZh6Yi5XWhr7wcwylfaEgAdg" +
       "HTaKi8FMma4WFg336gIsV0d2FYndABkX6wy1JEZI30QUa+R5ajfBFk5/1JrP" +
       "yBFRl400hAnREhHKX1ba9obuyxV3ksbimh1Tpb5ouumkPnBcwWJHvE/iJR7x" +
       "fKnCLvRiEPQDko70VtSikHLcYjezPshOw5IfpBs+sDe+Cpe7uDAbLJGRWaI5" +
       "hlHAm+qbsldY86W9Wt+YbxXsH9yBN+qsYf4S3p63Tfdkxf3721f579QVtsYP" +
       "bR9C2UbMHZc7j8s3YZ5555NPK+yHiju7266DCLomcr2fscDLrHWI1SnA6aHL" +
       "bzgx+XHkwXbg59/5r7eP3my87SUceNx1TM7jLD/MPPvF9gPyr+9AJ/c3B19w" +
       "UHq008NHtwSvDdQoDpzRkY3BO/Y1e2umsTvBddeuZu+69KHDJa0g3+Vr51aw" +
       "NYBjW9snD2ylf1DkpL90hV3wx7JiE0GnbdMx7djOex1Yz9tfbO/lML+8IjkK" +
       "N4P4wC7cB36CcHe2VJfcQ5INMd9T/tW853uugP6JrHhXBJ1Rdo/qjsF//GXA" +
       "z93mIXAVduEXXir8178o/H2Hn+dUv30FqB/IiqdA1FAPnUxymc9cSoenFDeW" +
       "LPVAE+97GZq4Jau8F1zVXU1UX3FNfPgKmvj9rHgmgq47rIljE/+hlwv3PnDV" +
       "d+HWX3G4n7wC3E9lxSci6PrDcAvH8P7BTwKvsItXeMXxfvYKeD+XFX9yDG/x" +
       "GN7PvBS8KbCVw+f52YHkbS/4VGj7eYv8safPnrn16fHX8yPt/U9QrulBZ7TY" +
       "sg6fHx26P+UFqmbm4l+zPU3y8r+/iKDbLveJAQh02V8u7Re35H8ZQTdfghzE" +
       "t73bw9R/HUHXHlBH0I58pPlvwaKw2xxBJ0F5uPFroAo0Zrdf9y5xNrE9ZEtP" +
       "HM0V9tV/04up/1B6cd+RpCD/kGtvAY+3n3JdlD/+dKf/9uerH9qex8uWuNlk" +
       "XM70oNPbTwP2k4B7Lsttj9cp6sEf3fCJa+7fS1hu2Ap8YMOHZLvr0gfeLduL" +
       "8iPqzadv/aM3/u7T38iP6v4P0vmGwmEnAAA=");
}
