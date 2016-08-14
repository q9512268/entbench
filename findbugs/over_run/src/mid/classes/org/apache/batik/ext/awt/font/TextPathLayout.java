package org.apache.batik.ext.awt.font;
public class TextPathLayout {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ADJUST_SPACING = 0;
    public static final int ADJUST_GLYPHS = 1;
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path,
                                                   int align,
                                                   float startOffset,
                                                   float textLength,
                                                   int lengthAdjustMode) {
        java.awt.geom.GeneralPath newPath =
          new java.awt.geom.GeneralPath(
          );
        org.apache.batik.ext.awt.geom.PathLength pl =
          new org.apache.batik.ext.awt.geom.PathLength(
          path);
        float pathLength =
          pl.
          lengthOfPath(
            );
        if (glyphs ==
              null) {
            return newPath;
        }
        float glyphsLength =
          (float)
            glyphs.
            getVisualBounds(
              ).
            getWidth(
              );
        if (path ==
              null ||
              glyphs.
              getNumGlyphs(
                ) ==
              0 ||
              pl.
              lengthOfPath(
                ) ==
              0.0F ||
              glyphsLength ==
              0.0F) {
            return newPath;
        }
        float lengthRatio =
          textLength /
          glyphsLength;
        float currentPosition =
          startOffset;
        if (align ==
              ALIGN_END) {
            currentPosition +=
              pathLength -
                textLength;
        }
        else
            if (align ==
                  ALIGN_MIDDLE) {
                currentPosition +=
                  (pathLength -
                     textLength) /
                    2;
            }
        for (int i =
               0;
             i <
               glyphs.
               getNumGlyphs(
                 );
             i++) {
            java.awt.font.GlyphMetrics gm =
              glyphs.
              getGlyphMetrics(
                i);
            float charAdvance =
              gm.
              getAdvance(
                );
            java.awt.Shape glyph =
              glyphs.
              getGlyphOutline(
                i);
            if (lengthAdjustMode ==
                  ADJUST_GLYPHS) {
                java.awt.geom.AffineTransform scale =
                  java.awt.geom.AffineTransform.
                  getScaleInstance(
                    lengthRatio,
                    1.0F);
                glyph =
                  scale.
                    createTransformedShape(
                      glyph);
                charAdvance *=
                  lengthRatio;
            }
            float glyphWidth =
              (float)
                glyph.
                getBounds2D(
                  ).
                getWidth(
                  );
            float charMidPos =
              currentPosition +
              glyphWidth /
              2.0F;
            java.awt.geom.Point2D charMidPoint =
              pl.
              pointAtLength(
                charMidPos);
            if (charMidPoint !=
                  null) {
                float angle =
                  pl.
                  angleAtLength(
                    charMidPos);
                java.awt.geom.AffineTransform glyphTrans =
                  new java.awt.geom.AffineTransform(
                  );
                glyphTrans.
                  translate(
                    charMidPoint.
                      getX(
                        ),
                    charMidPoint.
                      getY(
                        ));
                glyphTrans.
                  rotate(
                    angle);
                glyphTrans.
                  translate(
                    charAdvance /
                      -2.0F,
                    0.0F);
                glyph =
                  glyphTrans.
                    createTransformedShape(
                      glyph);
                newPath.
                  append(
                    glyph,
                    false);
            }
            if (lengthAdjustMode ==
                  ADJUST_SPACING) {
                currentPosition +=
                  charAdvance *
                    lengthRatio;
            }
            else {
                currentPosition +=
                  charAdvance;
            }
        }
        return newPath;
    }
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path,
                                                   int align) {
        return layoutGlyphVector(
                 glyphs,
                 path,
                 align,
                 0.0F,
                 (float)
                   glyphs.
                   getVisualBounds(
                     ).
                   getWidth(
                     ),
                 ADJUST_SPACING);
    }
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path) {
        return layoutGlyphVector(
                 glyphs,
                 path,
                 ALIGN_START);
    }
    public TextPathLayout() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Ab9mFGcsHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aCazsVnn2uy/vJXkkeS9hSUizkPCgDQPX45nxLHq0jWfG" +
       "M/Z4GXs8Hs+4wMPjZcbjfZvFNC0gtUFFoqgNKVSQtiqIFoWlCypVRZuqYhOo" +
       "LYjSRSqbKpWWIhGkQlXa0mPP3d8Snop6r3zm+Pg/53z/f/7/O8fn+OlvQWei" +
       "ECr4nr2Z2V68q6/j3YWN7sYbX492ezTKKWGkay1biaIhKLusPvyR89/9/tvn" +
       "F3agszL0fMV1vViJTc+NBnrk2Utdo6Hzh6W4rTtRDF2gF8pSgZPYtGHajOJL" +
       "NPS8I1Vj6CK9DwEGEGAAAc4hwNihFKh0u+4mTiurobhxFEA/B52iobO+msGL" +
       "oYeON+IroeLsNcPlGoAWbsnuR0CpvPI6hF5yoPtW5ysUfkcBfuLXXnfh909D" +
       "52XovOkKGRwVgIhBJzJ0m6M7Uz2MME3TNRm609V1TdBDU7HNNMctQ3dF5sxV" +
       "4iTUD4yUFSa+HuZ9HlruNjXTLUzU2AsP1DNM3db2784YtjIDur7oUNethp2s" +
       "HCh4zgTAQkNR9f0qN1mmq8XQgydrHOh4kQICoOrNjh7PvYOubnIVUADdtR07" +
       "W3FnsBCHpjsDome8BPQSQ/des9HM1r6iWspMvxxD95yU47aPgNStuSGyKjH0" +
       "wpNieUtglO49MUpHxudb7Kvf9gaXcHdyzJqu2hn+W0ClB05UGuiGHuquqm8r" +
       "3vYK+knlRR9/yw4EAeEXnhDeyvzRzz776CsfeObTW5kfu4pMf7rQ1fiy+t7p" +
       "HZ+/r/VI43QG4xbfi8xs8I9pnrs/t/fk0toHkfeigxazh7v7D58ZfHLyxg/o" +
       "39yBzpHQWdWzEwf40Z2q5/imrYdd3dVDJdY1ErpVd7VW/pyEbgZ52nT1bWnf" +
       "MCI9JqGb7LzorJffAxMZoInMRDeDvOka3n7eV+J5nl/7EATdDC7oNnDB0PYv" +
       "/40hB557jg4rquKargdzoZfpnw2oqylwrEcgr4GnvgdPgf9br0J2a3DkJSFw" +
       "SNgLZ7ACvGKubx/mcaqsYtgApoKH4I4DIGhlA9xrN3M7//+7w3VmgQurU6fA" +
       "4Nx3khpsEFWEZ2t6eFl9Imniz37o8md3DkJlz3Yx9ErQ6+62192815xWQa+7" +
       "Wa+7x3uFTp3KO3tB1vvWC8AYWoANAE/e9ojw2t7r3/LwaeB+/uomMACZKHxt" +
       "um4d8geZs6QKnBh65p2rN41+vrgD7Rzn3QwxKDqXVecytjxgxYsn4+1q7Z5/" +
       "/Bvf/fCTj3mHkXeMyPcI4cqaWUA/fNK2oafqGqDIw+Zf8RLlo5c//tjFHegm" +
       "wBKAGWMFeDIgnQdO9nEssC/tk2SmyxmgsOGFjmJnj/aZ7Vw8D73VYUk+6Hfk" +
       "+TuBje+D9pJjrp89fb6fpS/YOkk2aCe0yEn4JwX/PX/3l/9Szs29z9fnj8yA" +
       "gh5fOsIRWWPncza489AHhqGuA7l/fCf3q+/41uM/kzsAkHjp1Tq8mKUtwA1g" +
       "CIGZf+HTwd9/5cvv/eLOodPEYJJMpraprrdK/gD8nQLX/2RXplxWsI3vu1p7" +
       "JPOSA5bxs55ffogN8I0NQjDzoIui63iaaZjK1NYzj/2v8y9DPvpvb7uw9Qkb" +
       "lOy71Cufu4HD8hc3oTd+9nXfeyBv5pSazXeH9jsU25Lo8w9bxsJQ2WQ41m/6" +
       "wv3v+pTyHkDHgAIjM9VzVoNye0D5ABZzWxTyFD7xrJQlD0ZHA+F4rB1Zl1xW" +
       "3/7Fb98++vafPpujPb6wOTrujOJf2rpalrxkDZq/+2TUE0o0B3KVZ9jXXLCf" +
       "+T5oUQYtqoDLon4IiGd9zEv2pM/c/A9//hcvev3nT0M7Heic7SlaR8kDDroV" +
       "eLoezQFnrf2ffnTrzatbQHIhVxW6Qvmtg9yT390CAD5yba7pZOuSw3C95z/7" +
       "9vTNX/+PK4yQs8xVpuMT9WX46Xff2/qpb+b1D8M9q/3A+koyBmu4w7qlDzj/" +
       "vvPw2U/sQDfL0AV1b4E4UuwkCyIZLIqi/VUjWEQee358gbOdzS8d0Nl9J6nm" +
       "SLcnieZwEgD5TDrLnzvBLfdkVn4luCp73FI5yS35bLAd4wzSLgnWczM9vOvr" +
       "v/ne773p8fpO5tBnlhl0YJULh3Jskq1Df/Hpd9z/vCe++tY8+PebfjTv/qE8" +
       "vZglP56P7+ks+xOAG6J8SRsDdUxXsXPEj8TQ8zCa7LKXhSE2GF7fE7jQdACV" +
       "LfcWVvBjd33Fevc3PrhdNJ0c9hPC+lue+KUf7L7tiZ0jS9WXXrFaPFpnu1zN" +
       "Ud6eQ80C6aHr9ZLX6Pzzhx/7k9957PEtqruOL7xw8F7xwS/99+d23/nVz1xl" +
       "Rj8NFtVbzs/ScpZg20ipXjOqLh0f81eBq7435vWrjHmWaWZcnWWG1xuwLOlm" +
       "CbE/UrdtR4oh220az8qYE2DFGwT7CnC9eg/sq68DdifLvObGwN66BYuz7ash" +
       "fe0NIs24C9tDil0HaV6u3RjSO7B2TxSGlwUOa5Fs92pw9RuEuwsufA8u/lxe" +
       "YN8Y3Nv34HbpCUcIV0PrPCfabTydAguGM6Xd2m4xu49vDMbdC1u9uL+IGIE3" +
       "YzAHXFzYtbz+C+OjlLV9nTwB8pEfGiQI+zsOG6M98Gb61n96++d++aVfASHc" +
       "2yfJTLoFLMo9iV94NLt57Mb0uTfTR8jfJ2glipl8taJrByr1joBmY7Dm8f4P" +
       "KsV3/DVRiUhs/49GZL20Etdry3AL5RQrMONJM20V13NxxW5G8xkfFNeDRRde" +
       "kqVhDV1Q4sRx2OW0Xi1HtF6rMTVZrurivCFg4syZTzqU0uwEvkcrYrPJI0LM" +
       "U3w8dmYyKfIaU2xJnmAtCgKL45Q1CFxfKldTPU1qOqM3yUG1GNXYdFxLl7oy" +
       "LcMGW2acMOgMhqLMtYQh0R/UJ2LI2a24CZsjrEyUrFG/uJJnLEPCRn88SyML" +
       "HhXSEtmv84GFrqQZeI0bm40ZI01Yb+i0er1un3QJyYS7zNBb+F2SDTaMiksD" +
       "v8UU+RhvCjg/0sk2sml3+i1erLDeIujjHYn0Z7N+F1uRzlyzSktTZpeVElvs" +
       "hHhnvI4WPWcoL2yHbSZ6UfMtdFJfKG2l0pGTOdd3zVa7Oqv0ulLMBFIwJSux" +
       "uaKajDGcc8Zo2UlWa3w6czU3UQgfmGmMrOqW4ltT3+0KvSbrgKUOx44sdTXF" +
       "Z0HY6faLkorQyoKotk2y55vkRvH60oxqTFieW82Q2lTyeC7xJdyzS6WR017g" +
       "qD6QdMoa8pipDuejPuozuLMm+G47GeNRD2GbztKVqyvEbsR2JejYsGcZHNKu" +
       "ae1u0BVJZDYXnOqyNWti+JwvNHmXXJsjKaHX42bUYke9qN+ch1igUuRqGiCl" +
       "ZUtlhAFC8lggT6vdJrUSgqFiWNRo3otEhKlbmsToY1waMcqyGC7I9qQft2Ul" +
       "TrxxWB3OJlLLwSZOoM4as9T3BxFe5SfmhnMX5IZNDbWJiatYKFGC1e6bgsn3" +
       "m3arQZik2VuVa6t1s15ctHg78viZGdDxcM0ESn20iOFuW2dIfoIkid8utIJZ" +
       "4LQ4r0P2nISxJj3EtCUFHUVBmUO0ClJYF8TEFDlqRmkTdDYODHQ4YXsqUh0U" +
       "CEYN5m5pNqyula67EZXUTNMKw+NMY4XrUTEt1+BSHEiJrumI4yYpTgw7jRKl" +
       "D+j5oiiFdB1NxjAdTwK/mwi9ELOR+rwwiuyKxLBVxG/KLYdU+4PlUpDpOows" +
       "yws4nHMVfFUI2i1sSVcSv8cMBoRQdzsigStzXYoYb0Bgyaxlpp1S7NawVtA2" +
       "7BYftWtKp9IIHWzAm6rZXbbpWluoUthqGXhW6LWQnsouI2qwpiIXmfC8M155" +
       "Lb8C4ws46hZa1rKKu8ygsEhUi5fpBjmSnEbMdGTZbLP6gqhQRbNQZXi4kUgh" +
       "3IrrTrwRPAlrMMsg6hXaAT6fwcJ46jdWXl01miOj0iw0xVZvQqtdUhgvKopW" +
       "X9Ylh5roDnCCESbQTCNi2wIdBQ4qL7o4srIKFuKOdH0Tbsw5WtKoaLI0+15T" +
       "GVY1yir0fLFJiQtEVKyCjwzEESPgwOGEhmBirLbqKlhzNaZFC6aLrARPkI7I" +
       "VSiFsSOsJWpER9KdoDxhOLwwm8N1h4ZRcjymrEbFwnS+x4f+RvUG6aSieopa" +
       "Genyuo1jwbg2WeFa3+BS2EKwvtZPN1W93HZZFLxqxabbxqNmpC+KODYGHj53" +
       "GuUpt55qTq2oGS7hF+eldWzgqs5orIFYG6pXLCf+WJwShe44TXTdlFO5qK+b" +
       "Pb4pYMwGn1WKuNM2xrTab1LVojOw2ekmImYJtXL6crfAeF3EMgeirvHKZNgZ" +
       "D9BI1peLgUpg/qbfbvRLhL3pxXBhOUtQy0rxxnAiurOJhUymBbvpNPi1Ww1S" +
       "r2tj62YYwARf0ThigNQ2E0myWmumZ2ByHJSwQohVPYww4MWmERo6+J9U15WQ" +
       "wByrjPAi5VvFqDSujmDMnyU63KC6JM9rRZSaL9lCMzRmCtxp+WikiFOyZ5EO" +
       "GnUHMNttTXqcicXqiBkUaXhTk+MuJac1bVyNlvFqtpBDoVjumU12XCP64TC0" +
       "edVBU7I0GKas35vCdJvU3ECTXTYW7UGy0INBeYyGqYXqFXLVLmJUVWHIijw2" +
       "aadd5yW1NU7ncgHRaq5eFvtTOSrqlToay1RcIZebJpIWpv3lQi4B4pZKRk/u" +
       "wGXCQn1EYcnxSuTZeSQv+D5c1aLufDpJi9V2e9g2PI1gFcw3Y47Va8loUtfW" +
       "ZbztdSZE0BSrCNNsNKi+2KY8ob7U4WXR6IaySuOK3lDmgk27E91D436Hb1qT" +
       "KtLEm460dBPJLnHFcc8D8wIs9hQiYDkXHdX6aTBolTCK4VIjZUtxQTV4reON" +
       "qiW23PNjTjDGFYkNKaXMhpKLoAWY5NxeuaH7jlHsGc46bUvL+qjRmLhDroA0" +
       "nJAftKNBOpo7y4LFwRZe4xTAZHg6NWZzBtUdptZn+VYFiddLV1wUVg3OMtRu" +
       "e+PJPC3B4rLSVx2KrOn8POCiYmQGna4WrsuI06hGGqXM1KU8Nc3UHIttRx4v" +
       "PLzgK+NCQBU8pSoEpRXNCSYdjGrBfLERqxypBAK9atvVRVOqNmC4NCV65XE8" +
       "1gtmQs1L88Bjx4pZqpbnfByt61VdWvRt0i0b0VAqO0MtVfnlJCmWFbrPzEVm" +
       "XZtOML7rRBNTmy3M5nqyCBY0lqAOL4k9aU5JaZtHBlGvXRuC2Q9rKJUo0V2S" +
       "9quk0lLsFr5sltbULBymI2a6bCxKY5OQhpzjBL1hOTCQMTePGxV1ME8Mm8UZ" +
       "ziGqCKpVSppmSr2S70foOinPqHW1QZPLKlcoSwhncIIV+nhN7JRxnYXxFQKj" +
       "DQv2+lRiEAPZsXW41DdCdKWMtZnVE0pkihBoTalPY6MWm6GCjJchydcqSruM" +
       "Npewro3KBbqc9sUgmkR4BUaIFcX44mCGJHIhcvSRqhZ0oz9v1KIZwut8X/QF" +
       "zdRXXnfCVId03BmKqFsOR12qk0i4mkrAuCYy6rTYabE8GU35XnVKj5351EdS" +
       "r7QherXRINnEadgZKF21zU6Q0sSTAAHKjRhz7Va/USfBRFyM+rVeoz3A9Y01" +
       "WcdaJ+lO4+7M57oRo0oRJfWFuavzsYQOuCaOjxJL0paDEpr2OklxvlHAnMBI" +
       "UrGTdokFWdOi4aIyaHaksialk26zSs5xNq5NCD20V6WFVrWGQ7TSn5Wa7lCl" +
       "Er9UnnaYAs4PWFZKg1ZcMaqzmss49hiTOSEZjsxSKE/0sMV1CuLSKK0RrNqr" +
       "sIJhtHmuHThsrefVugWvuqw356NySyHZFhluimJ9ZonToER1jX5F8ElDC5AF" +
       "arCSvdFpepEOJFmGGYrSUV1FNQHmFsvREhPKywLnLGflSJCcdL5Jx5xcK03R" +
       "AK0O0Vok1SsNsMCU+PECtcaChfZqYhWfysJaEGxwy0zHZBddA3zzKIxjS3M7" +
       "iii3SvB65ZOjTSp19LZHxf3GoieNYaliVTFUMrpCvzYqm06PnKx7TthXWl4K" +
       "XBoHPomI0xLtbCze8BClH3FFgcRbiRCV8RE8dfAu7A/WE61MtOarxSJmnVmA" +
       "VS2taJZ6woKuoBO94PILvd0Ux7XhbDqKCni7tLJX6zKxsIHvMJxXSVaVKC4S" +
       "jupIBlol+CaRIqyzZo1VEdCgWywU4s2qynHACGyd6JS6+mYtJV5hsm4znTLH" +
       "1KdyrdFNULSWTDWrMmUr09T1TL22DjY1bYkUHAIOFLyMphQzhethIi165aQz" +
       "4juMNvScGayzi+rYGnfUSVcWA9HgYaFVw6UWOhfqM6HvzYnKGhnBPIqu3KBN" +
       "GAQ1K3nT0RAsUPlGJxV5zIldg2zx0xGwDIY1nJKbFAe8L4qEvFYak42BtsoY" +
       "gcd+g0/xwYaQsWLUKFWFnjuJoqjiraa0QsadDVqUm2GJqwRyZ0RXuY292iyc" +
       "qmcYTQVWVaRQMPUePiWqmupbmB1qjYo8pOlZmKrDTk2vmeNxUGyM6TaVBgUm" +
       "SanK1NyUgE/JS5aJkb7CIHIB9cqLoIQm67BQ24wrfWHVGozWTbw8tYkiNTQj" +
       "XyCS6Sx0++1es1yaIgOlIBLSBq0XxvJgOXZnPqUzyWTkDDizLW8KRMULNw6m" +
       "jVYdXDJnuipbRnGx6PoEzCyCBMysXpmiBDe1ixHSHpf6cGS0uC5T0bq+Y3fQ" +
       "IR4LojEI6WUYxJ3+aBBS1UW545Q0fWzaFD0ppzQ3WA6YwbDIRoNJr2GalAq4" +
       "PvFZdGwTk9qyOpGVJYxNG06nq0YEj2HZq+1bbuyV+858C+HgeBq8aWcPNjfw" +
       "Vr199FCWvOxgByb/Owtd+1znyN43lG0q3n+tU+d8Q/G9b37iKa3/PmRn78yg" +
       "H0O3xp7/Kltf6vaRpk6Dll5x7c1TJj90P9zL/tSb//Xe4U/NX38Dp3UPnsB5" +
       "ssnfZZ7+TPfl6q/sQKcPdrav+BzgeKVLx/ezz4V6nITu8Niu9v3H97YeAddr" +
       "9iz7mpN7W4djd4UX7Bx6wdYBTpzLnM2lzu7vH7043/I5OE3t2ht/PtIPvpgA" +
       "EnccSAhzZQuYudpWzRnD9pR8X/e3c5m896eucyr0/ix5F/BPOz+6PdJ19uC3" +
       "Dl3z159rw+doy3nBk1fa8mt7tvzaj9CWpw/j7jdyzIeK/951FP+DLHn6h1D8" +
       "gz8Kxb+zp/h3foSK7xxKbRXPpT5+HZ3/LEs+9kPo/Mc3ovMauOfxDwCyE8x7" +
       "rvgIafvhjPqhp87fcvdT4t/mZ+AHH7fcSkO3GIltHz1wOpI/64e6YeZK3Lo9" +
       "fvLzn0/G0P3X/TQhhm7KfnLQn9jW+UwM3XOtOjF0GqRHpT8XQy+4mjSQBOlR" +
       "yb+KoQsnJUFE5r9H5b4QQ+cO5WLo7DZzVORvQOtAJMt+yb/KLvP2TG996ji7" +
       "HwzfXc81fEcmhJceo/H8A7N9yk22n5hdVj/8VI99w7PV922P/1VbSdOslVto" +
       "6ObtlwgHtP3QNVvbb+ss8cj37/jIrS/bn2Lu2AI+jIMj2B68+vk67vhxfiKe" +
       "fuzuP3z1+5/6cn4y+L+mqaPd+ScAAA==");
}
