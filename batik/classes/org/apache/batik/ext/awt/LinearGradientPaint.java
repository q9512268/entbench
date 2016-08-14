package org.apache.batik.ext.awt;
public final class LinearGradientPaint extends org.apache.batik.ext.awt.MultipleGradientPaint {
    private java.awt.geom.Point2D start;
    private java.awt.geom.Point2D end;
    public LinearGradientPaint(float startX, float startY, float endX, float endY,
                               float[] fractions,
                               java.awt.Color[] colors) { this(new java.awt.geom.Point2D.Float(
                                                                 startX,
                                                                 startY),
                                                               new java.awt.geom.Point2D.Float(
                                                                 endX,
                                                                 endY),
                                                               fractions,
                                                               colors,
                                                               NO_CYCLE,
                                                               SRGB);
    }
    public LinearGradientPaint(float startX, float startY,
                               float endX,
                               float endY,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod) {
        this(
          new java.awt.geom.Point2D.Float(
            startX,
            startY),
          new java.awt.geom.Point2D.Float(
            endX,
            endY),
          fractions,
          colors,
          cycleMethod,
          SRGB);
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
                               float[] fractions,
                               java.awt.Color[] colors) {
        this(
          start,
          end,
          fractions,
          colors,
          NO_CYCLE,
          SRGB);
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace) {
        this(
          start,
          end,
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          new java.awt.geom.AffineTransform(
            ));
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                               java.awt.geom.AffineTransform gradientTransform) {
        super(
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          gradientTransform);
        if (start ==
              null ||
              end ==
              null) {
            throw new java.lang.NullPointerException(
              "Start and end points must be" +
              "non-null");
        }
        if (start.
              equals(
                end)) {
            throw new java.lang.IllegalArgumentException(
              "Start point cannot equal" +
              "endpoint");
        }
        this.
          start =
          (java.awt.geom.Point2D)
            start.
            clone(
              );
        this.
          end =
          (java.awt.geom.Point2D)
            end.
            clone(
              );
    }
    public java.awt.PaintContext createContext(java.awt.image.ColorModel cm,
                                               java.awt.Rectangle deviceBounds,
                                               java.awt.geom.Rectangle2D userBounds,
                                               java.awt.geom.AffineTransform transform,
                                               java.awt.RenderingHints hints) {
        transform =
          new java.awt.geom.AffineTransform(
            transform);
        transform.
          concatenate(
            gradientTransform);
        try {
            return new org.apache.batik.ext.awt.LinearGradientPaintContext(
              cm,
              deviceBounds,
              userBounds,
              transform,
              hints,
              start,
              end,
              fractions,
              this.
                getColors(
                  ),
              cycleMethod,
              colorSpace);
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            e.
              printStackTrace(
                );
            throw new java.lang.IllegalArgumentException(
              "transform should be" +
              "invertible");
        }
    }
    public java.awt.geom.Point2D getStartPoint() {
        return new java.awt.geom.Point2D.Double(
          start.
            getX(
              ),
          start.
            getY(
              ));
    }
    public java.awt.geom.Point2D getEndPoint() {
        return new java.awt.geom.Point2D.Double(
          end.
            getX(
              ),
          end.
            getY(
              ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7Caws2VVYvb/Pn+X/mfF4xoNn/4Ox2/nVW/WSsQ3VS3XX" +
       "0l1VXb1WDN/VtXXte9cCE7AlYgOSscjYOIqZCMUkgAYbUKxsIhorCUtASCBE" +
       "FikMibIQHEu2lBAUk5Bb1W//77/J99J6fbvq3nPvPfs5d3lvfBW6HPhQyXXM" +
       "VDWd8LachLd1E7kdpq4c3CYohBH8QJa6phAEU1B3R3zxl2/82Tc+tbl5AbrC" +
       "Q48Ltu2EQqg5djCRA8fcyhIF3Tiq7ZuyFYTQTUoXtgIchZoJU1oQvkJBDx7r" +
       "GkK3qAMUYIACDFCACxRg9AgKdHpYtiOrm/cQ7DDwoL8O7VHQFVfM0QuhF04O" +
       "4gq+YO0PwxQUgBGu5e9zQFTROfGh5w9p39F8F8GfLsGv/fQP3PzVi9ANHrqh" +
       "2VyOjgiQCMEkPPSQJVtr2Q9QSZIlHnrUlmWJk31NMLWswJuHHgs01RbCyJcP" +
       "mZRXRq7sF3Mece4hMafNj8TQ8Q/JUzTZlA7eLiumoAJa33lE645CLK8HBF7X" +
       "AGK+IojyQZdLhmZLIfTc6R6HNN4iAQDoetWSw41zONUlWwAV0GM72ZmCrcJc" +
       "6Gu2CkAvOxGYJYSevuegOa9dQTQEVb4TQk+dhmN2TQDqgYIReZcQeuI0WDES" +
       "kNLTp6R0TD5fHX/gkz9oD+0LBc6SLJo5/tdAp2dPdZrIiuzLtijvOj70Puoz" +
       "wjt/7RMXIAgAP3EKeAfzD3/o69/3/mff/M0dzHedAUOvdVkM74ifXz/ye+/u" +
       "vrd9MUfjmusEWi78E5QX6s/st7ySuMDy3nk4Yt54+6Dxzcmvr37kF+WvXICu" +
       "49AV0TEjC+jRo6JjuZop+wPZln0hlCUcekC2pW7RjkNXwTOl2fKullaUQA5x" +
       "6JJZVF1xinfAIgUMkbPoKnjWbMU5eHaFcFM8Jy4EQQ+DL/QY+K6g3af4DaE7" +
       "8MaxZFgQBVuzHZjxnZz+AJbtcA14u4HXQOsNOHAiH6gg7PgqLAA92Mj7Dbll" +
       "CnEI54gK/sAXJA10ZQSgtrdzRXO/81MkOZU34709IIB3nzZ/E1jO0DEl2b8j" +
       "vhZ1+l//wp3fvnBoDvv8CaH3g1lv72a9XcxauE4w6+0zZoX29orJ3pHPvpM0" +
       "gDKAxQNf+NB7ue8nPvKJFy8CFXPjS4DJuUuG7+2Su0c+Ai88oQgUFXrzs/FH" +
       "5z9cvgBdOOlbc4xB1fW8O5N7xEPPd+u0TZ017o2P/8mfffEzrzpH1nXCWe8b" +
       "/d09c6N98TRvfUeUJeAGj4Z/3/PCl+782qu3LkCXgCcA3i8E/Mody7On5zhh" +
       "vK8cOMKclsuAYMXxLcHMmw681/Vw4zvxUU0h9EeK50cBjx/MtflZ8E331bv4" +
       "zVsfd/PyHTslyYV2iorC0X6Qc3/m3/zuf6sV7D7wyTeORTlODl855gfywW4U" +
       "Fv/okQ5MfVkGcP/+s8zf/PRXP/7XCgUAEC+dNeGtvOwC+wciBGz+0d/0/u1b" +
       "f/T5P7hwqDR7IQiE0drUxOSQyLweun4OkWC27z7CB/gRExharjW3ZrblSJqi" +
       "CWtTzrX0L268XPnSf//kzZ0emKDmQI3e//YDHNW/qwP9yG//wP96thhmT8zj" +
       "2BHPjsB2zvHxo5FR3xfSHI/ko7//zN/6DeFngJsFri3QMrnwVlcKHlwBnd57" +
       "Ti7jaxaQxnbf/8OvPvaW8bk/+aWdbz8dLE4By5947cf/8vYnX7twLKK+dFdQ" +
       "O95nF1ULNXp4J5G/BJ898P2/+TeXRF6x86qPdfdd+/OHvt11E0DOC+ehVUyB" +
       "/dcvvvpPf/7Vj+/IeOxkQOmDfOmX/vD//M7tz/7xb53hxYDmOkIhydpRAWZ9" +
       "+d5MLCSx48nrf++l3/3h11/6D2BgHrqmBSCtQn31jGh9rM/X3njrK7//8DNf" +
       "KAz+0loICmSun05z7s5iTiQnBVcfOtTzp3MmPge+79nX8/fsuLr4FgMJ6Gbl" +
       "Wun4KHgq/OlBjPpODZ3sRJCXt3Or3tn2+XqN5Zw78qlP/W/aXH/sP/55Ie+7" +
       "QsEZqn6qPw+/8bmnux/6StH/yCfnvZ9N7o6YQOpHfau/aP3PCy9e+ZcXoKs8" +
       "dFPcz9Tnghnlno4Hcg0O0neQzZ9oP5lp7tKqVw5jzrtP29qxaU9HgyMdB885" +
       "dKFiuwCQFx9M9qDC/2FFjxeK8lZevKdg94X88Xty69BswSz61YF3NWVbDTcF" +
       "cLmo2znaRghdBNqaP37ATQ4ld2E3VPH+RLjvy3LSQO7qgAwBuMWDtl1aoDm3" +
       "D9cNoDE5Qwfed28dGBXWcSSI3/jYnz49/dDmI/eRDzx3SrCnh/yF0Ru/Nfhu" +
       "8acuQBcPxXLXouJkp1dOCuO6L4NVkD09IZJndiIp+LeTR168XHC4eH/fISeg" +
       "ghNQAcuf0/bhvFgAAYo5q3eSOQf8TgIV9X/10KE8krc9Dr6lfYdS2jkU4duU" +
       "mY4iM9RcUz4z/f3OT5IcaN4jheblWWvhiu5SufwdzQvhwGTU80wmL/CdveQF" +
       "kRdkXnzkbsPIX+m8YO/W9Px9upu26J0Xy3MEaJ/TVmBdLAm/f4fJObB+svuF" +
       "z4EpDP254Hj6fNIYj+1Y3BE/9Qdfe3j+tX/29bt88clscSS4rxz5p+fzwP/k" +
       "6bXCUAg2AK7+5vjDN803v1EE3QcFEahAQPtguZKcyC33oS9f/Xdf/ufv/Mjv" +
       "XYQuYNB1EOwlTCjSdOgBkB/LwQasdBL3e79vp+XxNVDcLEiF7iK+qHj67gT6" +
       "Z/dN5GfPTqCPLPrutPReXU+x/2qBwdVTacph8YFCrgcq/aF7LszOtIdb3VQ0" +
       "5Z3XypOlAuuPniP/H82LHyqaorx4dceY5Fvi4Zf3GfHl++fhvbqeIuFSgcGl" +
       "Ay49cWj4quxYtxkHsKLayxt/8oilxeyfPIcXP5UXP3bEix//dvDirX2C3rp/" +
       "Xtyr6ykS9hcLh9QeIzkvPnbApA/eryrlPpQD8PKhJv3tc7j3d/LiM0fc++lv" +
       "A/f2Lu367n7vi3v37HpvazyTe3nxuQMWPnNSz1AFpFTy1BfsIF+xF0j9/Dks" +
       "eiMv/u4Riz5/PyzawT61v6WSP6OHRD+UQ+Qrhg/vq8yHT/NrP979ytnxDqy2" +
       "r7q+tgULtYP88DJIefzwkCM3j7D+1bfD+pvA6x/fA6/88UsHKF2UbekshP7J" +
       "2yJUDJDsATIvV283bxf57ptnT3kxfwTZ8pWg2BjP3/ADBJ7UTfHWwdJ2LvsB" +
       "CH23dLN5oB43j7Li3dbyKUTr/9+Igoj5yNFglGOrr/zEf/rU7/zkS2+BQElA" +
       "l7f5EgOEyGMzjqN84/5vvPHpZx587Y9/othJAQyc/9iv1P48H/VfnUduXvyL" +
       "E6Q+nZPKFTkZJQThqNj8kKVDak8tGS6BzPSbpzZ8lBrWAxw9+FAVobuIxcrE" +
       "LEVZU6+2muZy1DTVDtWlzC49cQR0hWT9xtSt1q1uv1/rDYIWXE2oUWYgVq2t" +
       "O+UhabKsNtOc7pDFzHSzUQWN7aCh6rjdftrvdvs+VWYJzCAaM9YcENWQ9Fja" +
       "hreZUhu6fcoT5m0a3spwvQnD4E+OmN4Qwbk0nYzng1EythCWbAtRsGgS4UBL" +
       "p/wsEBKm3BbDGmaYcFQS2m0u0lyKYypoQs09MVgsuQobLozKTLFI3seIftWq" +
       "2C5pZJpebbCL8Uw03WgjDBErWnTKLluZG5vl0uNWTn/LkzzOzLhVY5UaA6Ec" +
       "VxqosTQIum+JdjqVBxsk4njUW0yVAaMQg2HNWq9j1p21ERnTxhVtUeO8zoQZ" +
       "lRdjIuGocDEZia6w8Urjnhcg2ng01qptllp3BgFXSVliRWC9tlSCR1YY1+Zi" +
       "BxuZU2nE8y1Y4LoVkL4tiQ5pV+QwnFs+WTVKIT5bEbOSo/LCrF63WvymnG2C" +
       "ht3zZ+LQ9RrWYuovXbtTs3xs4qVDVZ1sVgMs6xuzss+ntWk2ao1IRMwse9Ya" +
       "rDdyvYY6UVDRWvVGVt/q0dZbRoY2nlaNuYs1WkM9HaJ4x92W1VnHFZyuMLeC" +
       "lOPHbRer93hFYmcINuNXcthgeWog4Yaprit0lepk/qQzXTdsIt2yONyxXGth" +
       "WSnSVJOEbXsljp3PBNREbJmKyZ4p6UzWWTlir5P1+4Q4kBhygkzCLqu3WqNs" +
       "2Wmst/GqP6JmwUSy4qaFzP2+zbITpz/BJsSg7tdQhivjHBqW2QFKaHTWShtk" +
       "oK8MecYKzraKp52OFCZq19NMsd/TMEM2NyO/zgkDs8r1gxK8TOtwRLYrVdcP" +
       "OY2ICWs6x9YJTMxijzPKAjeS3O4KoxN06iErs20EmR3GU4LlcLcu4x2xoi+z" +
       "NlJVSMtptQhLNxCBcgahOeDbYjAEHABBP6pK/dlk6DFiuVvGzAms2ljIh1mN" +
       "M/QhGreSeN6adqzeuC7RTOJV6/VJr4QbjkPPNN8XdAejSW/Z5rmNN56IbDb3" +
       "OCe26JY687TlujRUh+SKsTckMSlLQYUebCYVY0DOJWTubRkFJ4nOAiWwOTpk" +
       "NF1w6FZpkOBrRGyt1A027W2yKYqkjgZv1RoO15LVtILVETwQVp6VNMPxULFq" +
       "9aiTdIxuNYb7HZap4LUxNSUMNPbdsCeyZjzqZyG6noyEVYa1hC4XicLMUF2s" +
       "Fnuxzg1ZfUzDE1ZA7J6z0FZoF3HW42W8pBZC5HMLv5rCW85ruwwTTmHVQReW" +
       "MwqHZWERN4CrW0SjZsuTCDkW0mbf12bTOh+OY6mBuU7H6WixvFw0F2Wk5FYW" +
       "sBiQKokPFgyGD9gRswq6jqCMxTiiqVJpqWeTWbOi1zPfZCZlM1H1CT4yQoo0" +
       "BG5uj3CFYFsrN0wqLNonuFaVYnpYR008V2tOCUqzlN6wu/Tm4rAxs9r6KM3W" +
       "crfftNlJxCD18ppuIbQu1WtSdbht0/M+11utejUK7zMdk26WV3ZT933ER9cp" +
       "NY+acrPG6I1UaSgRvZqgynDYXYX8CBlgkwGKbFrKlEoTHtfhFRytaV6rlUl6" +
       "EA9Ig1eqnamMlzrbxSZT9HU6Q1t0L3Itbt5JUh7LOhuj0s7o7YYma3bWHqGY" +
       "O3fUfi0erMXQsGG9gca9KmJ0K3Ut63fE1tjMuFU7yxIjhIEAlmEyHgh2LdnW" +
       "5RRzYT8OZkJE0F672m2mAjtrjBslDw7XUi2tyxkzpDA0yPz5ZtTkwzpFoBuu" +
       "Z1lIcw1HAiHFjRZmz5Oh1Wej9qhnoIS57AqJXWFnqw5RpVujZq+plrBl3HO8" +
       "NdJVgdawsVd2OmR5jZb8eSVtemO4Og9skex09ZjWEUGSYzpSwpUvtkZ4Ba5m" +
       "WlqeGD2qKme9OK2LJVvWoprlrcp6pOCA0eR20ILJdrlnsINWICwDZ5x1TBvn" +
       "TZQPh3LVJbKKqs7LHjnv9bxO1c+irUxGbbe5bfS0Pp2JRsxKY2art2GuBHtV" +
       "rGlxaXuYBhMY8bdrfrxU8WGL8jYMCm+aLVxhGr1hwjYkVVNq7Y7VQerYOmIT" +
       "HU1FZWB15r0hzg4TO65bk6jdbs56KKsH8Wblu3YtE2G9VJOIjLXLroItJlZf" +
       "AUa5YtlmlczQcloOQjRSAsVlJrVVSVRguiYTs56IqTW0gSAODYMAj1WxKixP" +
       "kWEHRadlbTHZEA1m1RGAvgaUYMixxNjjcFpCQgFzxktt3DNJueJOQ0HyJm2y" +
       "RZR4eT7cdt20HI1kXFboOTueEHPTQZdBifSXHTJYYElZ1GncWKQeA7enDdiP" +
       "mC6BZCuuNCPaFTjAkhJZW4irGK5FI7VSCQ2g03ZMS6NqRR9hS6/ZUtW+6HpL" +
       "NhxyGcYj9dmwk6ptujKmCZNb1sulEltrrRiMqpThQNFqKG6UZsAh97vTjm1T" +
       "hkfVkWFSLrXEvl9RRnJdH+iDUY2r2P04EgFv2JFL81KJmq79zdjN1EE7wgew" +
       "GgrqMlIbbTnsb3vtRlUpp87W6SWbaFWB/ZAaSnolqrUTsqWRlZ4d0FMOpmrN" +
       "ejM0QzKD1Vazymprej1qG8igr8+s2lZ2JBZ2nJC06xYX6AhHtKPKslEyXL3P" +
       "tlfDEUWK6oZx4lGnESxnnFaLSKszZHq9YFFbTzerUqNattBZEJhNBy8TdZny" +
       "uCzTpmErimk+9AnHY0YKy2ua4CrjOtkd1r3Kar0adaUoWJcXilkjuU5fRSel" +
       "po6nPkJuVtq2HfFDwWElQR2E+Aapcw6ySokJxkxW1brZdWgeuB8eq3coIpbX" +
       "BBzVhCpIzlal9abCj4mA6W89fooQPWDvdUcxzVIHF5hWlEbtqrRd6FZLmlBE" +
       "fRuz/oigmLCDlBijwre02qRmJWS5O5lz7JBozvrOvLOZeboXCl1qGcU88BAo" +
       "mvG2qNTSWkmuy1pH7LVI31OXA7nbsNBhYsypKTphh2lzbrUtwh9lSK0ckuIo" +
       "CenZcAUz8HiIdVJFrisWb3DYJqR7jOQMNuNFvU92paq31ju6CiIUyq5KKyKS" +
       "g87MMEblmupPUnQqthUQsljH2/bprl9ZiDFukHALDjeo2ggmNkWj/DKuLyhk" +
       "UmKoubXY+K2a1rWqblOLDFJBXaNUB3l1ddUcYVZS42G1A6+DuYWPt2hrKs6r" +
       "MMVXB7GvEum662RhEq3WVVrXCHTurFvIAB8K8ZbqaUFadwIaD6vdNIG7c7U8" +
       "UOqU6jeReaiUGlqj3aDtqbXC/EEPK6cGT/H1KROPM5WwN327GvJouVdTzGGl" +
       "WnJn9XYp9sYll2N7OhlHo7I9npJoKfBMKrWRdpM2+EWlFeHhcO6iINTQE0/j" +
       "ZYFH/Zk8ZoVKODcSXy+PrH62qm4wiU/mRjBvMYadwrbNJ/KgHWpD2WoG9XYn" +
       "4aTAmq+rLk4tli0QgDfJeBzSPspLwOXxEtI0gkY53Ux67mqwNiKhKs4tM45M" +
       "DQ4qDCyVuxGjyuPtFiljSNDcsN2oVC2njLCihA7IqqRw6xmbiuMj7MqRGrNK" +
       "rSY6II2nE6CgfWncNOmhjvezpQIDrzCyHdaKaVmn6017ijdW03FjtcXTVBcr" +
       "CeFKNBVyLdzoAtyl+rycLmRtg5TqHTlytGaz353Z5a5VFlue0ozHfacy07IF" +
       "Ni5NDcuXPcUKaU+aBUtb7MvVFt5F1p10sHX5cMStmXjuBErDNfLTK9lq0HID" +
       "R9oDAZ+itXGLU/DBPNnMOVzDGhtgtOa2K/qc3gra2aQ0w/HqYuCtElLHhcjT" +
       "HIpCHWLQ4MaEzWC0NNdLE9lebU2YZuJ1lYpHCcvMDd+uKhSD2q45dVMmUhVV" +
       "sTU/FjR05E8teuv1yJRRqhsT7g7HWgUkH7wklZBsW+vybKq5g4boS8TE23oL" +
       "ckO5+jAaTcyk1OV0m91sN1i5KdMMMe6tBrWEaizDUh9O6wvYcHGVkjkZjQO9" +
       "AuKH2DWAM8TJMe8urVaZrDr1JrXNGuJKClyrhfUUfDSZAKuvNMm6kbaXrW4d" +
       "dppjEAJnsbbCtmNnS/ojvWtLDdgc0MZShsdd2CIXjqdrZZSUAlS32E5pzJG5" +
       "HLcpqhksoU8kHSHZjatRuBxifXnh2xOZourN4ZRA9XIjnFga0B8M6A9WIsvu" +
       "COdrmtt3dYzrUmOvwqMIMel6JQxVxumYFamWHI+t2khWje1yk1G9cm1mBiUx" +
       "oomKuBxa23Eacm4vjdecV7LapjIqmRvDGGJcEyfdodyqbrnuqAuPwDIXxerT" +
       "hZ40eFJQ7YDBQyybNbBWhooOCPp+16R7zdJaVtZaX8cmdQlvLLV4BnM9Muh1" +
       "p3UgiHStz8qRIZp9ddtcJgpTnlXtCdLEl52WE8Bea5bpc3KxjbPJut3iB5RU" +
       "skJmaWuKTI4Mr43TS6uzIAxg2ZSNYa2Fb+FzZF5jFqRZbbYJWtg0xEBcEeh2" +
       "qsV8nGRKt0GjijpORrWgTAcLr222GzBlqatIKYWWXDZldTUOR/iGUNc1psov" +
       "egOuPy5X3Qzf+sOtOctKQ29jNpbKYJ7WQWYSrmHM6/NYNd1EdhORRHq5rXnN" +
       "VXloeaQRgGUOcO36YIlQsmLVOz5SqtCxXln5c9vp67HmkS7Ky502qybdebkN" +
       "vEaoa35tjrSGLRt3oqSGS+ZWFIbBkGQsUi+HhoN5JM61h96ALw8qi6reAXl6" +
       "LC+Q5aqlaxXcYQSUmlaJzBnHNXM+x1xbHIy3Uq2COiN3uGBGQjCpKvNtvNwK" +
       "etSyViaKoh/Mt1X+8P62ex4tdrYOb1DqZjNv+PX72NFJ3v4k7XBbsPjke4Mn" +
       "LuOd3qN96mBv2Ieeudd9yeLKyOc/9trr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ev1zlQv726zNEHogdNy/Yspb2Tw21MXdSdwhGk/lw78MQXuN/a3ixjm7zGdu" +
       "TX7Pjn+ntnwvH9ujfSKE3nW4aaxZgirvziZHjrSPG4B47BBiIouhYKtHh+nv" +
       "OrnjfNi+O934hQOwJ4+NYEtyvvc41OwwKPD703O2pP9HXvznEHpY9GUhlPfv" +
       "Ad99rlIcCRxvLRTiv9z3Hv8R9/PzaOh5wMj9veG9u/aGvznuH6NuDzqnrdDM" +
       "bwDKVTnk8r3u4tSo2F8+IvAvvlUC80MMeZ9A+dtP4EPntOWHr3tXQ+hBQGDf" +
       "ls4gb+/afR1AhNDjZ9wGza+2PXXXrfPdTWnxC6/fuPbk67N/vbsfdXCb+QEK" +
       "uqZEpnn8Ysux5yuuLytaQfsDu2NktyAIKORT9zrDCqGLoMxx3nvHDvqpEHrH" +
       "WdD5OUJyAvK7QujmacgQulz8Hod7NoSuH8GF0JXdw3GQF8DoACR/fNE9sKLb" +
       "93fwluyddH+HyvjY20nrmMd86cRxfvG/Awf3YKLdfw/cEb/4OjH+wa83fm53" +
       "61M0hSzLR7lGQVd3F1CLQfO7NC/cc7SDsa4M3/uNR375gZcPfPAjO4SPNPwY" +
       "bs+dfcWyb7lhcSky+0dP/oMP/P3X/6g4w/h/gjh44dQxAAA=");
}
