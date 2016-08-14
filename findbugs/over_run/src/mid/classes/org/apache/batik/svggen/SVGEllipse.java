package org.apache.batik.svggen;
public class SVGEllipse extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    public SVGEllipse(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Ellipse2D ellipse) {
        if (ellipse.
              getWidth(
                ) <
              0 ||
              ellipse.
              getHeight(
                ) <
              0) {
            return null;
        }
        if (ellipse.
              getWidth(
                ) ==
              ellipse.
              getHeight(
                ))
            return toSVGCircle(
                     ellipse);
        else
            return toSVGEllipse(
                     ellipse);
    }
    private org.w3c.dom.Element toSVGCircle(java.awt.geom.Ellipse2D ellipse) {
        org.w3c.dom.Element svgCircle =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_CIRCLE_TAG);
        svgCircle.
          setAttributeNS(
            null,
            SVG_CX_ATTRIBUTE,
            doubleString(
              ellipse.
                getX(
                  ) +
                ellipse.
                getWidth(
                  ) /
                2));
        svgCircle.
          setAttributeNS(
            null,
            SVG_CY_ATTRIBUTE,
            doubleString(
              ellipse.
                getY(
                  ) +
                ellipse.
                getHeight(
                  ) /
                2));
        svgCircle.
          setAttributeNS(
            null,
            SVG_R_ATTRIBUTE,
            doubleString(
              ellipse.
                getWidth(
                  ) /
                2));
        return svgCircle;
    }
    private org.w3c.dom.Element toSVGEllipse(java.awt.geom.Ellipse2D ellipse) {
        if (ellipse.
              getWidth(
                ) >
              0 &&
              ellipse.
              getHeight(
                ) >
              0) {
            org.w3c.dom.Element svgCircle =
              generatorContext.
                domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_ELLIPSE_TAG);
            svgCircle.
              setAttributeNS(
                null,
                SVG_CX_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getX(
                      ) +
                    ellipse.
                    getWidth(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_CY_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getY(
                      ) +
                    ellipse.
                    getHeight(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_RX_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getWidth(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_RY_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getHeight(
                      ) /
                    2));
            return svgCircle;
        }
        else
            if (ellipse.
                  getWidth(
                    ) ==
                  0 &&
                  ellipse.
                  getHeight(
                    ) >
                  0) {
                java.awt.geom.Line2D line =
                  new java.awt.geom.Line2D.Double(
                  ellipse.
                    getX(
                      ),
                  ellipse.
                    getY(
                      ),
                  ellipse.
                    getX(
                      ),
                  ellipse.
                    getY(
                      ) +
                    ellipse.
                    getHeight(
                      ));
                if (svgLine ==
                      null)
                    svgLine =
                      new org.apache.batik.svggen.SVGLine(
                        generatorContext);
                return svgLine.
                  toSVG(
                    line);
            }
            else
                if (ellipse.
                      getWidth(
                        ) >
                      0 &&
                      ellipse.
                      getHeight(
                        ) ==
                      0) {
                    java.awt.geom.Line2D line =
                      new java.awt.geom.Line2D.Double(
                      ellipse.
                        getX(
                          ),
                      ellipse.
                        getY(
                          ),
                      ellipse.
                        getX(
                          ) +
                        ellipse.
                        getWidth(
                          ),
                      ellipse.
                        getY(
                          ));
                    if (svgLine ==
                          null)
                        svgLine =
                          new org.apache.batik.svggen.SVGLine(
                            generatorContext);
                    return svgLine.
                      toSVG(
                        line);
                }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2xUxxWeXb8f4AexcQ3YYAwShuzWIWkamYYYh4fpGjs2" +
                                                              "sVSTZj17d3b3wt17h3tn7bUTSqBqQyM1QoGkNCn8KekD0SSqErV/Ql1VbRKl" +
                                                              "aQSN2iSo6SN/2iZI4UdDWvo6M3Nfe3fXCKmqpTt7PXPmzJw53/nOmXv+Cqqy" +
                                                              "TNRDsZ7EETZHiRUZ4+9j2LRIckjDlrUXeuPKY388cfjar+uOhFH1FFqawdaI" +
                                                              "gi2yQyVa0ppCq1TdYlhXiLWHkCSfMWYSi5gzmKmGPoXaVGs4SzVVUdmIkSRc" +
                                                              "YBKbMdSCGTPVRI6RYVsBQ90xsZuo2E10MCgwEEONikHnvAmdBROGfGNcNuut" +
                                                              "ZzHUHNuPZ3A0x1QtGlMtNpA30UZqaHNpzWARkmeR/dod9kHsjt1RdAw9LzR9" +
                                                              "fP14plkcwzKs6wYTJlrjxDK0GZKMoSavd7tGstZB9CVUEUMNPmGGemPOolFY" +
                                                              "NAqLOvZ6UrD7JUTPZYcMYQ5zNFVThW+IoTWFSig2cdZWMyb2DBpqmW27mAzW" +
                                                              "rnatddwdMPHJjdGT33iw+YcVqGkKNan6BN+OAptgsMgUHCjJJohpDSaTJDmF" +
                                                              "WnRw+AQxVayp87a3Wy01rWOWAwg4x8I7c5SYYk3vrMCTYJuZU5hhuualBKjs" +
                                                              "/6pSGk6Dre2erdLCHbwfDKxXYWNmCgP27CmVB1Q9KXBUOMO1sffzIABTa7KE" +
                                                              "ZQx3qUodQwdqlRDRsJ6OTgD49DSIVhkAQVNgrYxSftYUKwdwmsQZ6gjKjckh" +
                                                              "kKoTB8GnMNQWFBOawEudAS/5/HNlz5bHH9J36WEUgj0niaLx/TfApK7ApHGS" +
                                                              "IiaBOJATG/tiT+H2l4+FEQLhtoCwlPnRw1fv2dS18KqUWVFCZjSxnygsrpxN" +
                                                              "LL24cmjDXRV8G7XUsFTu/ALLRZSN2SMDeQpM0+5q5IMRZ3Bh/BdfeOQc+SCM" +
                                                              "6odRtWJouSzgqEUxslTViLmT6MTEjCSHUR3Rk0NifBjVwHtM1YnsHU2lLMKG" +
                                                              "UaUmuqoN8T8cUQpU8COqh3dVTxnOO8UsI97zFCFUAw9qhGcNkn/ilyElmjGy" +
                                                              "JIoVrKu6ER0zDW4/d6jgHGLBexJGqRFNAP4P3NofuTNqGTkTABk1zHQUAyoy" +
                                                              "RA5GrZl0mujRicmd2zVNpRaJcLDR/88yeW7tstlQCByxMkgDGkTQLkNLEjOu" +
                                                              "nMxt2371ufjrEmI8LOxzYqgH1orItSJirYhcK+KthUIhscQtfE3pZ/DSAYh3" +
                                                              "INzGDRNf3D19rKcCAEZnK+GIuej6ogQ05BGDw+Zx5fzF8WtvvlF/LozCwB0J" +
                                                              "SEBeFugtyAIyiZmGQpJAQ+XygcOJ0fIZoOQ+0MKp2SOThz8t9uEndq6wCjiJ" +
                                                              "Tx/jdOwu0RsM6FJ6mx7988fPP3XI8EK7IFM4Ca5oJmeMnqBDg8bHlb7V+KX4" +
                                                              "y4d6w6gSaAiol2EIFWC1ruAaBcwx4LAwt6UWDE4ZZhZrfMihznqWMY1Zr0cg" +
                                                              "rUW83wIubuCh1AZPnx1b4pePtlPeLpfI5JgJWCFY/nMT9PTbv/rLZnHcTkJo" +
                                                              "8mXyCcIGfCTElbUKumnxILjXJATkfndq7MSTVx7dJ/AHEmtLLdjL2yEgH3Ah" +
                                                              "HPNXXj34zu/fO/tW2MMsgyycS0BBk3eN5P2ofhEjOc69/QCJaRDhHDW99+uA" +
                                                              "SjWl4oRGeJD8s2ld/0sfPt4scaBBjwOjTTdW4PV/aht65PUHr3UJNSGFJ1Hv" +
                                                              "zDwxyczLPM2Dponn+D7yRy6t+uYr+DRwPPCqpc4TQZUhO275pjoY2rgIJdjM" +
                                                              "bZh2/SAcfbuYGRXtZn5IQh8SY5/lTa/lD5jCmPQVSHHl+FsfLZn86MJVYWFh" +
                                                              "heXHxwimAxKSvFmXB/XLg+S0C1sZkLt9Yc8DzdrCddA4BRoVoFdr1ARWzBeg" +
                                                              "yZauqnn3pz9rn75YgcI7UL1m4OQOLAIT1UFEECsDhJqnW++RgJithaZZmIqK" +
                                                              "jOc+6C7t3e1ZyoQ/5n+8/MUt3z3zngCiRN4Kl0NXF3GoqM698P/w8jPv/+Ta" +
                                                              "t2tkbt9QnvMC8zr+Maoljv7pk6JDFmxXou4IzJ+Knv9W59DdH4j5Hu3w2Wvz" +
                                                              "xZkIiNmbe9u57N/CPdU/D6OaKdSs2JXwJNZyPJinoPqznPIYquWC8cJKTpYt" +
                                                              "Ay6trgxSnm/ZIOF5GRDeuTR/XxLgOF46oJXwrLPDf12Q40JIvAyLKetFu4E3" +
                                                              "mxxKqaGmCjcmEuCUhkWUwiQINl4EOdHYvUg0cjnJtLy9ize75WJbSmFUDq3n" +
                                                              "TZ+7JfFXHayT/DTnwRLxSFtVrpQVZfjZoyfPJEef7ZegbC0sD7fD7ecHv/nX" +
                                                              "LyOn/vBaiVqkjhn0Vo3MEM23ZgUsuaYoFEZEpe/h6s5L1youP9HRWFxJcE1d" +
                                                              "ZeqEvvIxE1zglaN/7dx7d2b6JkqE7sBBBVV+f+T8azvXK0+ExWVFwrjoklM4" +
                                                              "aaAQvPUmgVuZvrcAwj2ua5dxl3XA02+7tr90mi6BCjf5lZsaoPxACpFsjGdZ" +
                                                              "JE2MbMQuJG+7VyxIFkkXKm+mGapiBuDbUbeMx8DsZiWSFMpIlti3ZwF5vAjk" +
                                                              "i2mZdwyK7gdca0UcdMOz1bZ26w0OKlYc0eWmlj4o/m9KaM0tchqzvIHAaBCn" +
                                                              "MaSairz5HPCMP/i/MX41PPfZFtx388aXm3oj448sYvyXefMwQ43CeBtCAesP" +
                                                              "3bz1eYbqPX08S3cUfUGRt37luTNNtcvP3P9bUV+7N/NGqExTOU3zJxHfezU1" +
                                                              "SUoVFjTKlELFz2MQFWWoHIpP+SK2/DUp/3WGmoPyEBfi1y93HOzx5ECVfPGL" +
                                                              "nGCoAkT460nqxFT/YlWeiWlGVWSOhXw8A5cKqJhChanA9ULbjbzgyx5rCyhX" +
                                                              "fOJy6DEnP3LFlefP7N7z0NXPPCvvB4qG5+e5loYYqpFXFZdi15TV5uiq3rXh" +
                                                              "+tIX6taFbVS1yA17kF7hg9wggJNySHQGimer162h3zm75cIbx6ovQf7ah0IY" +
                                                              "yGlfcVmSpzng/30xf97yfSgVdf1A/fvTb37ybqhVVH9IFn1di82IKycuXB5L" +
                                                              "Ufp0GNUNoypItyQvaqZ75/RxosxAnVqb09WDOTKcBCQmjJzufg1byvGL+ecv" +
                                                              "cTL2gS5xe/n9kqGeou9cJe7cUBjPEnMb1y7STiAp5Sj1j+b5V6ISVoFv+k//" +
                                                              "/fBX3x6F+CrYuF9bjZVLuPnN/7HNS3jNko/+A38heP7NH+5S3sF/oXAcsj88" +
                                                              "rXa/PFGal2MV8dgIpbZszYsCBpQKrjgnFH+HN9/LcwmGQn2U/hfrAJKLZRcA" +
                                                              "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eV4jF8tOPWy1WoJQ0ApcQ0pX036x0EnA4rAOLG9h0xVJQkcrhnd0IRZXgYyu" +
       "rXIsVZXERqZosVyoR0Gz6Ji1FmZpVVsMJY9JUMzHQ6uriGSnTM/pUUx2C3Vh" +
       "kxD4YjHtOwWnK/lmK27P+blKJw2QRpkTFqd9wo5MRFzj1RVqLcyyIyrrTb+u" +
       "K7JU5GWFHqaluViurYvDvj2Ti+rEsa2KBzvNvkQXI9lYpiuiB0AJc2mJlcwg" +
       "rfYYjGZgE6anlRLDaCIeJSAjk6YO4lmVSiOcrTZTVaPXowqCqa0IQ9WQQeZp" +
       "SZ3Nl8y02GARmdf47jhC6jZYQwaRvGIQpjnnhQJwuUF32Um4IY+kZNLT1JQv" +
       "sbwn4BbXtzsUnpbpET6ZeD3CZwpsvwy3eR9GJl3HYzadlmaWNk2kN0yTagcT" +
       "NKZLuV3MQxdcpVZ0lwnOwTN7opoTuytM2KExXTfQqtxfkgZmSC7a5Km5NU/1" +
       "TVINsI0x1YbkptbuuAxC4baqMfVBPQUhB6BmtWpVlt1qQa3a3my29PEpLipm" +
       "qcoJ1dhcIsHUKETEtBZJ+FxgSxu0VF/gdUNvrnWdHGzY3qhrOmpQqpUNJHXq" +
       "VZmYJzVvNdLqklEkZpuurcmCw/og0mGkmGjN+kZjdUHRSiisrbg5Ut/Ml4Yg" +
       "9JoE7pYUs1Em+hs5nraqFK/5xe6AH3gbn4g2o5W0FOtVeJx4YYK6wnJebE7a" +
       "Q64vt7CRY5FprOml+WbVpQqqvJI5qqyz1USF3eZi2VW9uCmTal3mWxbTcel5" +
       "aVNnORP1q6xVsgrzqlAjWAB4q8IChmGtNUWSGl7AglmMN+eWKFAx44Kg6A1Y" +
       "xBosPLiAIg1DBVbsFaosEuKwN0Xl0Go0gqkEM3hXssu00FB0wp+LYToLsZY/" +
       "6geW7uK9Qm/QhCl5DdZmt8zDhhagZJ8SxzLY2LzxjdmWx3xlu8678g32wZ0Q" +
       "2GxmL7hXsNvavnosK548OObIP2dP3iMcPYU8PGaCsh3kQze76sl3jy+8+9nn" +
       "leEnSzt7x3Ngl3p75Pmvt9WVah9hdRpwevrmO2U6v+k6PDb60rv/+QHuTcbb" +
       "XsEB+iMn5DzJ8nfoF7/Sfa38azvQ6YNDpOvu4I53unr86OhCoEZx4HLHDpAe" +
       "OrDsPZnF7gdPac+ypRsfYt/49Cj3gu3cnzj9PHGauj2YlNbRrq56zu7epUa5" +
       "nfd9xy1OTn85K9IIOhN5LNhb7rG7JztiWiPyrpIzUx117yY3d6+3/7jN/NFB" +
       "8ob1gT1enTU+Ap4379njza/UHp1b2SP7+c6c4EO3UPpXs+L9EXRHrjRmBvL2" +
       "su09hzp+4CfV8VHwjPZ0HP0f6fibt9DxE1nxXARdzHXcc4gTSn70lSiZRNCF" +
       "Q07Z4f/9193Kb2+S5c8+f+n8a57n/yq/Mjq47b2dgs5rsW0fPXc9Uj/rB6pm" +
       "5rLfvj2F9fOvF4B33+TEMzuHzCu5sL+1pf9UBF0+SQ/8O/8+SvdpoM8hHWC1" +
       "rRwl+UwEnQYkWfWz/n5slG51cRFIvmHK22NpzHNXahCpQXLqOHwe2P/uH2f/" +
       "I4j7xDGczP82sY9p8faPE9fkzz1PDt7+cu2T2ysv2ZbSNONynoLObW/fDnDx" +
       "sZty2+d1tvfUD+/8/O1P7mP4nVuBDz33iGyP3Ph+qeP4UX4jlP7Ba37vDZ96" +
       "/pv5mev/AGwxUyrPIgAA");
}
