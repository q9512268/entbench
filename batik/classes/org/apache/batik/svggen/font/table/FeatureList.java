package org.apache.batik.svggen.font.table;
public class FeatureList {
    private int featureCount;
    private org.apache.batik.svggen.font.table.FeatureRecord[] featureRecords;
    private org.apache.batik.svggen.font.table.Feature[] features;
    public FeatureList(java.io.RandomAccessFile raf, int offset) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            offset);
        featureCount =
          raf.
            readUnsignedShort(
              );
        featureRecords =
          (new org.apache.batik.svggen.font.table.FeatureRecord[featureCount]);
        features =
          (new org.apache.batik.svggen.font.table.Feature[featureCount]);
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            featureRecords[i] =
              new org.apache.batik.svggen.font.table.FeatureRecord(
                raf);
        }
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            features[i] =
              new org.apache.batik.svggen.font.table.Feature(
                raf,
                offset +
                  featureRecords[i].
                  getOffset(
                    ));
        }
    }
    public org.apache.batik.svggen.font.table.Feature findFeature(org.apache.batik.svggen.font.table.LangSys langSys,
                                                                  java.lang.String tag) {
        if (tag.
              length(
                ) !=
              4) {
            return null;
        }
        int tagVal =
          tag.
          charAt(
            0) <<
          24 |
          tag.
          charAt(
            1) <<
          16 |
          tag.
          charAt(
            2) <<
          8 |
          tag.
          charAt(
            3);
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            if (featureRecords[i].
                  getTag(
                    ) ==
                  tagVal) {
                if (langSys.
                      isFeatureIndexed(
                        i)) {
                    return features[i];
                }
            }
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ISip0Xkt2JAdrS/wRzZc/B+cTAhjhBsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+wsV12fe9v76KX03rbQlkrft0g7+JvZ2XcKyO7szO7M" +
       "7s4+Zmd3Z1Qus/PeeT93drDyiApKgkRbRAP9CxSxvAxEE4OpMQoEQgIhvhIB" +
       "jYkoksAfohEVz8z+3r23LTFxkzl79sz5fs/3+Tmvffa70LkwgGDPtbaa5UZ7" +
       "Shrtra3qXrT1lHCPHlTHYhAqMm6JYTgDbdekhz91+Qc/fJ9+5Sx0XoDuFB3H" +
       "jcTIcJ1wqoSulSjyALp81EpYih1G0JXBWkxEJI4MCxkYYfTEAHrZMdIIujo4" +
       "EAEBIiBABKQQAWkd9QJEL1ec2MZzCtGJQh/6BejMADrvSbl4EfTQSSaeGIj2" +
       "PptxoQHgcDH/PQdKFcRpAD14qPtO5+cp/DSMPPWbb77yBzdBlwXosuGwuTgS" +
       "ECICgwjQrbZir5QgbMmyIgvQ7Y6iyKwSGKJlZIXcAnRHaGiOGMWBcmikvDH2" +
       "lKAY88hyt0q5bkEsRW5wqJ5qKJZ88Oucaoka0PWuI113GpJ5O1DwkgEEC1RR" +
       "Ug5IbjYNR46gB05THOp4tQ86ANILthLp7uFQNzsiaIDu2PnOEh0NYaPAcDTQ" +
       "9Zwbg1Ei6N4bMs1t7YmSKWrKtQi653S/8e4V6HVLYYicJIJeebpbwQl46d5T" +
       "Xjrmn+8yr3/vW52ec7aQWVYkK5f/IiC6/xTRVFGVQHEkZUd46+OD94t3fe7d" +
       "ZyEIdH7lqc67Pn/4899/0+vuf+4Luz4/cZ0+o9VakaJr0odXt3311fhjzZty" +
       "MS56bmjkzj+heRH+4/03T6QeyLy7DjnmL/cOXj43/Qv+7R9TvnMWukRB5yXX" +
       "im0QR7dLru0ZlhJ0FUcJxEiRKegWxZHx4j0FXQD1geEou9aRqoZKREE3W0XT" +
       "ebf4DUykAha5iS6AuuGo7kHdEyO9qKceBEEXwAPdCp77oN2n+I4gEdFdW0FE" +
       "SXQMx0XGgZvrHyKKE62AbXVkBaLeREI3DkAIIm6gISKIA105eJFomuIgKrAN" +
       "EokrS0FIpciNHBf28lDz/j8GSXNNr2zOnAFOePVpCLBA9vRcS1aCa9JTcZv4" +
       "/ieufensYUrs2yiC9sC4e7tx94px93bj7uXj7hXj7h0bFzpzphjuFfn4O38D" +
       "b5kg78HLWx9jf45+y7sfvgkEmre5GZg674rcGJjxI6SgCjyUQLhCz31g8475" +
       "29Cz0NmTCJvLDJou5eTjHBcP8e/q6cy6Ht/L7/r2Dz75/ifdoxw7Adn7qf98" +
       "yjx1Hz5t3cCVFBnY5Ij94w+Kn732uSevnoVuBngAMDASQcwCeLn/9BgnUviJ" +
       "AzjMdTkHFFbdwBat/NUBhl2K9MDdHLUUbr+tqN8ObPyyPKbvAs/V/SAvvvO3" +
       "d3p5+YpdmOROO6VFAbdvYL0P/fVX/rlcmPsAmS8fm+tYJXriGBrkzC4XeX/7" +
       "UQzMAkUB/f7uA+PfePq77/qZIgBAj0euN+DVvMQBCgAXAjP/0hf8v/nmNz78" +
       "9bNHQROB6TBeWYaUHiqZt0OXXkBJMNprjuQBaGKBZMuj5irn2K5sqEYeynmU" +
       "/tflR0uf/df3XtnFgQVaDsLodS/O4Kj9VW3o7V9687/fX7A5I+Wz2ZHNjrrt" +
       "IPLOI86tIBC3uRzpO7523299XvwQAFsAcKGRKQVmnS1scLbQ/JUAegtKw92b" +
       "io7s2i0JYEVIAvQDXB97gSVPYNjAXcn+NIE8ecc3zQ9+++O7KeD0nHKqs/Lu" +
       "p371R3vvferssYn3kefNfcdpdpNvEWcv37nsR+BzBjz/kz+5q/KGHfjege/P" +
       "AA8eTgGelwJ1HnohsYohyH/65JN//NEn37VT446T8w4BllUf/8v//vLeB771" +
       "xesA3U1gTVFIiBQSPl6Ue3m47SPVvsHvPDA4NSJSSfFyJxZ0b8iLB8LjaHPS" +
       "7MeWedek9339ey+ff+9Pvl9IcnKdeDy5hqK3s9ttefFgboa7T0NrTwx10K/y" +
       "HPOzV6znfgg4CoBjEQijAOB7eiIV93ufu/C3f/pnd73lqzdBZ0nokuWKMikW" +
       "qAbdAuBECXUwNaTeT79pl02bi6C4ktdS6NAwUGEYKN1l4T3Fr/MvHHZkvsw7" +
       "wsR7/nNkrd75D//xPCMUUH6dSDxFLyDPfvBe/I3fKeiPMDWnvj99/pwHlsRH" +
       "tNjH7H87+/D5Pz8LXRCgK9L+ensuWnGOVAJYY4YHi3CwJj/x/uR6cbc4euJw" +
       "znj16VQ4NuxpND8KQVDPe+f1S6cA/NaDlckD+9j2wGkAPwMVlWFB8lBRXs2L" +
       "nzzAywteYCQgkwrOtQi6Vd1N2bgbOwW8VXdzQF6+KS+YnVPxGwZA76R4MHge" +
       "3BfvwRuIx91AvLw6OZDstn3JporkBnIIwunRG4dTgZU7UHrmdx75ytueeeTv" +
       "i+i/aITA6K1Au86q+hjN95795ne+9vL7PlFMyTevxHBn/tPbkefvNk5sIgrJ" +
       "bz1pjle9kDkOkAR96UurnTU8z4NO+Wn+Y/opD52H9gV76AZ+Wr0UP13c91NY" +
       "dBNOjnLnC41yoP7jL1396yguvajihaDpGRD957C9+h6a/7avr9pNefW1YFkR" +
       "FvteQKEajmgd6Hr32pKuHsxKc7APBhB1dW3VDzS5UqBrDgZ7u83jKVlrL1lW" +
       "EO63HTEbuGAf+p5/fN+Xf+2Rb4K4pqFzSQ4/IKiPjcjE+db8l599+r6XPfWt" +
       "9xSrJOCr+a98uv6tnGv6QhrnhZ8XwYGq9+aqssWWYyCG0bBY2CjyobbYMX0a" +
       "EVgeuf8HbaPbnu1VQqp18BmUBAXbcGlqqk4Vqaz4MYNizY6Ok2WTEhYletLt" +
       "taNh1lzjaddjNuueYiPDqBxFshyrYVgabyeUr1m8S7W5wSodIxxJuLRHkpNF" +
       "fU77IsVyDE1Rq6nX1ZY1zowGHEfO0ZqPzlawgK1KTWeItMb1OSqV46ycqVmy" +
       "RNQ1gciTsW1rik+zLoMucdkOyZGlytqGXU07G1GskgpvoM6oCneRVYCVlB7X" +
       "IrWa1liHqIILscluhX6pnRLyivY5P+2nTDpk6WnabDsEPeRdL+jbHZ8SMSUd" +
       "1Sg33K6mPSOlu0MKZ4b9ALfawZaj++zKDttGHOAUYVNsSovVMiL3TNEyfXE8" +
       "gmfZcjSRg7UyHMa9UJjTXFeu0dMy4bILziJpgcG8yhbt0DLXEHskj3ZZ3u3K" +
       "Wz8YtJkQ95H+kOhlbMqp5VllEsAT26ZK87nISOPlcDCczS2LmHX8YV+oz6fU" +
       "JtqSjolX+fnMoHzRZRZp0nVpZlLHvUAsddpyf0nMFkKNwSujaKr4HL60iRbH" +
       "LM0luuq2iSa/Veepveh3qUXgZUKEY0MRi4B8nVQaDyauomClelUyan6XmMzB" +
       "xmuc0mQLb/mrDkW32UWf6o7EmkhPiXapO8fDekxXxCG5dPCGw5b6Eziw8VUb" +
       "WQkC1p2y9GalonViDrdJdFil2BK/RZU1oXCMmCC0getob7kw5aW7IJb2RiIN" +
       "jJtklK4bnXhAL5rE3B9yjKpV0bWPqVqF0gbcZrLQJRaD5x7W5ycMZ0zbbNhx" +
       "1Rqlzjie7TClbavV4d2FQGIcNg96KEA4WicW5qxWGydE3+8K6SRrLQw7aAi9" +
       "jdVgKNypyhIS2KkileG0uWBErWNpw3RKGdYQ0WnNT6R0xRIpr3eoVoPkMZ2H" +
       "NTtSy1O5hVN6oA5ZvOpEajJeThqJl5GbGbOxLVdxZYxwra7Xt/WGIy1kNpUd" +
       "CQjBUCUOW42a2HoU1rKxEo0U1O/hpb6wFHC40wyjbNEACSnas2rPbZFLZd0y" +
       "rZmp2ZS79WgWNrYTd8NMca7rGTNxveCnjBy0y2VlPXG00XbrTsM6ltqE5TIN" +
       "bwaTbDt14I6x6G/aHWY6nGUD0dxmTnk+rCCbqseOCDzudtiYnOmNiYrUeEqH" +
       "aVFz2Y1OzoUSRzf1cIUyKDOR+FUrSnoTgpg12eGaMzWR4Akt080hXzHao3pb" +
       "WW8aDNGROHTu9zYmQeNLfua0jRCZTAUfTpprM53N5LHAz7RKhRe6SBs3JuNp" +
       "WKI5f2j0Jm68qmel2KHsbb+xIDye8SkXH4fddFVtJ3ZzUm9HJrxZVROzt0wM" +
       "zdGxRlmH0QRplZWu223oVcVikVDF6tP1sjyM27QLW5piC/6M6WkdX6L8zlIm" +
       "1qjn+KFr2/1tpHZqeAPkfZcwS4au9OiRPeT7HofyxjyrTdstszKcrNkawTNt" +
       "W2z3aQ2kjzmkRY/TVvREXHmYMRI33CopGbYe9NdpfbZ1y0wvrVYUwI5stRYN" +
       "d4hjGSXX0mhdX+DW2ILThZp1+VWE9RNZgkcOY0awyLUnSB8b4fxGslBxzPd0" +
       "ptEgRDsiBJhJBn7dEqIm6U0jw+gxLj5YwIi6mdMlLK5Q2ZL3WhVBt+lBB19G" +
       "JjbwQbynUSY4hjlPes5o2lrQ7IYR4d5MjDkLwYRELHNYpi+mmTIYept5zxgi" +
       "aG2LNBoxiqh8f4VtxBluSUuUaLpxLW6F0sJXRNuXQhrzUYJCe6VKNIIDHUPC" +
       "siSsSUMXvSjeWDwqc4N1S190bGFbD5UE8cEUOmix6qjPtiuSponufCqyM3Fs" +
       "2PKEcIRVJdQ67TnehkPc8BJuSir0bB2aIVzSDWQVGQ3Jz9SmpfYVuqVNzfqa" +
       "XqnKhHTUpFprMuwKQ5rTrKrS5lRrjTIh2xLTuQNjYTKsbBodY0YhS9Rb+UnC" +
       "k2qrt23ZdtYnKuwSm+DlCd8Oxhoy0Zxxf+G0BnOfEXkPJapSOdTcQTSY8GFF" +
       "9WeTLW8G3qY1rpREcyy0yiCFllii1jdzKRPg7kTuzJ2W3hQUvOkskLSP64bH" +
       "95hh6vSXlDmmpclc85b4KEU6y021gYQhnOFRODHbHZlXyFml5GnMoEQSBixT" +
       "4gj1o5bYU0sloecEddQlx61OTMF8vZOgVR7uwJsGXaq4sbddrNFlJzOIas8f" +
       "jrqyIcgouq1LVC0eV+sCIg1nMSL1fdFv2gxKDxR7kCDr8aLRXSf1SqXDrc0t" +
       "cBBs4IPmcmo58Li0nnfcCtucIyO9JS8qS5Kex3N6ylXnJRrVS6VgozO2Z0rS" +
       "2hnUhHpFJ8NSVddazmy1aQlNJZXmvMl2wRzhZ3W5E9Tj0pDlpk5FyqpMQOqh" +
       "YsdxqVKOnQA1ejOtEWJbTYiTstK3G51Vtb4ezLTyUte3LjbokrA9SnopX+bX" +
       "rbGswRI2LvmeMwiZ/qaOG+uNpWhoq1plnT7pcDC/QODQCaJZomy5RXtgsaHY" +
       "WYv60mpO6yMtbFNZJzAUdI3Uzb4W8Ci3mQ/6DljDrNpOr+OSs257mER6bAdT" +
       "W8a9LBvT9QrSrHKldKskjVbfMTJuISVVqWR7lRaNquS0NBypTuyVqzDCmGt+" +
       "OxgKACR7TbihIpw/KUcw3GgMzfKQclhxrI63HXc+Hg9gnVeq5WxUWndjMprZ" +
       "Cjpttoaj+mboEOXGmGmrYKpq9cG8awntMtMOcFZoaSk+lKZoVks2ao9pNKv1" +
       "qN1uyr1Q9FO1SjTtUjBtkmXVnk4zrFpptR1fLhOMZfBo3Oplekb06kJmJUkF" +
       "LAS6MIZJ/WjCdPl6krZkjp4NQ9YivdmAbfXmHluV15k46U1Wo1SfoBPgaKlE" +
       "r5GktCAEte1H9amf1fD2UEobK6kvbrCV5vUDhShzlJnxhlhexxOG0jdce2jV" +
       "ml22kTWwBLF7FroczjR5mljjpaEwJAqm7Ea6NbC+GCRSwDioWSW6ctr00w07" +
       "W1YDQSw71TSEJ2jS5RZbfEV0+M6KGckDUkLGXEmJl9vYGzUqlXiNdY35ot9s" +
       "I51ho750sGFa8m28YwVUUKv49fFWomI4rq2T1LKTsmSO++Qs2SiTikwKVcYq" +
       "i3zoCiNxuGS30pzhBGox2gomV2+ImdD0eRMZOHSTwsR6VLebWCmSBCekhUEN" +
       "m3uoaqkttS9rcinyybFM8MkotrMlOdgyNuNlYmcgKtjW6qlB0F/grBfBiUl2" +
       "jZgWDASsJNtbvaZQk+pcVTsNd4TAaC9ojL36SGXTWHXrvVHC1zcCZdZX4ULh" +
       "l1Uebaql2kZelBpphknl1GvMEyqBFUzhUqk8oIlRO9Eii8I7ayYMBqVRndyw" +
       "/c6kP3WXwcr1RHRZMlHXCSrBYNaII0o1zboJE5ShzgZ0GntB6GRNBCxr5Ola" +
       "C3uIFJGmr0jj9rBDuUEEVyRKbsJNLcKTpNmZ8ZLbwyvCAAssYVl2LHlUATOj" +
       "l1GZ1FQJWluhZGttxlpJT2S2sR5ES2necB2hFvZptw5Let3VVyu57FtE3069" +
       "fr+CyvXSst9a0biQ4dVJv86o1VLW7dsxHDLcsorQ8WC85SoztLUa6kNnunTC" +
       "baO87fGBLdjdtlSrViRmpLY1tV7jCA6JMRveVskUOHyAc0oZZ5NNl+iwzHq9" +
       "WGJirU3IcyPoLeozdubXqmaVkWWxTnIpUpmuYnmLWmlpWptmZhpjSVYJuIZC" +
       "ZBJjupRDR5pPT3C+ElHr5QQWQ79qB6XFRlKcqOHJ9mDFB0KVm2BDh9XF+qZX" +
       "afX9YLxZxK267sVRTR5X4BITLJNESFx6gOLtcJKZ/GyNrIZOMrXoGjEJNpHT" +
       "szitGdD1jSpa5WpTHZW3GNlAKgxYKK/cpSAqY5ZWxmNkFW+W1qw5ITnULW+p" +
       "WZM21irdqcCBNsbWqdHyzUZ5RFIa5Td0viFsOtuSafMk34lJNJSqoiU0zSY5" +
       "mdarOlFplPnxzBTWKamNxwuHEx2m77SdsbrphKYXcPIU7gzhsa+uALTSVaPs" +
       "titralqXgVwUa3jo0owwuiUHLLKZZoKEtGFp1tLXejsEm9M3FOe7v/jjbadv" +
       "L04ODu+gwS46fxH9GDvm/f17Xjx6eMhSfM5Dp+4tj992HJ3IQvmZ8X03ulou" +
       "js0//M6nnpFHHynlhwc5YTOCbolc76csJVGsY6zy44nHb3waNywOxY5OWD//" +
       "zn+5d/ZG/S0/xkXdA6fkPM3y94bPfrH7GunXz0I3HZ63Pu/O/yTREydPWS8F" +
       "ShQHzuzEWet9h5bNT66g+8FT2rds6fTx1ZHvrn9C9tqd709dIpy6tXkpZ18D" +
       "0dHYbUGxu5j47VM8D87f89/P5MXTEfQyNb8G2Z2a5U3GUZS9/8XOZU6c6QNW" +
       "x6518zuqe573J5LdHx+kTzxz+eLdz3B/tTtGPfhzwi0D6KIaW9bxE+5j9fNe" +
       "oKhGIfstu/Nur/j6SAQ9/OLGiaBzxXch94d3lB+NoFe/EGUE3Zx/HSf5/Qi6" +
       "+wYk+WFgUTne/xMRdOV0fyBK8X2836cj6NJRP8BqVzne5TMRdBPoklc/613n" +
       "IHF3q5CeOZnJh86848WceSz5HzmRssU/hg7SK979Z+ia9MlnaOat3699ZHfL" +
       "K1liluVcLg6gC7sL58MUfeiG3A54ne899sPbPnXLowdwcttO4KPEOSbbA9e/" +
       "UiVsLyouQbM/uvszr//dZ75RnGv+L/xEBU/KJQAA");
}
