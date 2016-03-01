package org.apache.batik.svggen;
public class SVGCSSStyler implements org.apache.batik.svggen.SVGSyntax {
    private static final char CSS_PROPERTY_VALUE_SEPARATOR = ':';
    private static final char CSS_RULE_SEPARATOR = ';';
    private static final char SPACE = ' ';
    public static void style(org.w3c.dom.Node node) { org.w3c.dom.NamedNodeMap attributes =
                                                        node.
                                                        getAttributes(
                                                          );
                                                      if (attributes !=
                                                            null) {
                                                          org.w3c.dom.Element element =
                                                            (org.w3c.dom.Element)
                                                              node;
                                                          java.lang.StringBuffer styleAttrBuffer =
                                                            new java.lang.StringBuffer(
                                                            );
                                                          int nAttr =
                                                            attributes.
                                                            getLength(
                                                              );
                                                          java.util.List toBeRemoved =
                                                            new java.util.ArrayList(
                                                            );
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 nAttr;
                                                               i++) {
                                                              org.w3c.dom.Attr attr =
                                                                (org.w3c.dom.Attr)
                                                                  attributes.
                                                                  item(
                                                                    i);
                                                              java.lang.String attrName =
                                                                attr.
                                                                getName(
                                                                  );
                                                              if (org.apache.batik.svggen.SVGStylingAttributes.
                                                                    set.
                                                                    contains(
                                                                      attrName)) {
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      attrName);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      CSS_PROPERTY_VALUE_SEPARATOR);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      attr.
                                                                        getValue(
                                                                          ));
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      CSS_RULE_SEPARATOR);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      SPACE);
                                                                  toBeRemoved.
                                                                    add(
                                                                      attrName);
                                                              }
                                                          }
                                                          if (styleAttrBuffer.
                                                                length(
                                                                  ) >
                                                                0) {
                                                              element.
                                                                setAttributeNS(
                                                                  null,
                                                                  SVG_STYLE_ATTRIBUTE,
                                                                  styleAttrBuffer.
                                                                    toString(
                                                                      ).
                                                                    trim(
                                                                      ));
                                                              int n =
                                                                toBeRemoved.
                                                                size(
                                                                  );
                                                              for (int i =
                                                                     0;
                                                                   i <
                                                                     n;
                                                                   i++) {
                                                                  element.
                                                                    removeAttribute(
                                                                      (java.lang.String)
                                                                        toBeRemoved.
                                                                        get(
                                                                          i));
                                                              }
                                                          }
                                                      }
                                                      org.w3c.dom.NodeList children =
                                                        node.
                                                        getChildNodes(
                                                          );
                                                      int nChildren =
                                                        children.
                                                        getLength(
                                                          );
                                                      for (int i =
                                                             0;
                                                           i <
                                                             nChildren;
                                                           i++) {
                                                          org.w3c.dom.Node child =
                                                            children.
                                                            item(
                                                              i);
                                                          style(
                                                            child);
                                                      }
    }
    public SVGCSSStyler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wUxxmfO9vnBwY/CMZxwIAxBPO4K4UEtaYp5mKwydk+" +
       "+YylHG2Ovd053+K93WV3zj47pQTUFEQlFAWS0CZYakuUFpEQVUWtWoVS9ZFE" +
       "aYqgURuCmrTNH0mbIIU/GqelbfrNzN7t4+4cpX/U0s6Nd76Z7/37vtlzN1CV" +
       "aaAOXVAlIUimdGwGo3QeFQwTS2FFMM0ReJsQj/35xMHZ39Ue8qNAHC1IC+aA" +
       "KJh4h4wVyYyjpbJqEkEVsTmIsUR3RA1sYmNCILKmxtEi2ezP6IosymRAkzAl" +
       "GBWMCGoSCDHkZJbgfusAgpZFmDQhJk2ox0vQHUH1oqZP2RvaXBvCjjVKm7H5" +
       "mQQ1RvYJE0IoS2QlFJFN0p0z0DpdU6bGFI0EcY4E9yl3WYbYFbmryAwdzzd8" +
       "eOuRdCMzw0JBVTXCVDSHsakpE1iKoAb7ba+CM+Z+9FVUEUHzHMQEdUbyTEPA" +
       "NARM8/raVCD9fKxmM2GNqUPyJwV0kQpE0Ar3IbpgCBnrmCiTGU6oIZbubDNo" +
       "u7ygbd7dHhUfWxc6+cQDjT+oQA1x1CCrMSqOCEIQYBIHg+JMEhtmjyRhKY6a" +
       "VHB4DBuyoMjTlrebTXlMFUgWQiBvFvoyq2OD8bRtBZ4E3YysSDSjoF6KBZX1" +
       "X1VKEcZA1xZbV67hDvoeFKyTQTAjJUDsWVsqx2VVYnHk3lHQsfM+IICt1RlM" +
       "0lqBVaUqwAvUzENEEdSxUAyCTx0D0ioNQtBgsVbmUGprXRDHhTGcIKjVSxfl" +
       "S0BVywxBtxC0yEvGTgIvtXm85PDPjcGtxx9U+1Q/8oHMEhYVKv882NTu2TSM" +
       "U9jAkAd8Y/3ayONCywtH/QgB8SIPMaf50VdublvffuklTnNHCZqh5D4skoR4" +
       "JrngypJw1+cqqBg1umbK1PkuzVmWRa2V7pwOSNNSOJEuBvOLl4Z/ff9DZ/F7" +
       "flTXjwKipmQzEEdNopbRZQUbO7GKDYFgqR/VYlUKs/V+VA3ziKxi/nYolTIx" +
       "6UeVCnsV0Nj/YKIUHEFNVAdzWU1p+bkukDSb53SEUDU8KAjPKsT/2C9BOJTW" +
       "MjgkiIIqq1ooamhUf+pQhjnYhLkEq7oWSkL8j2/YGNwSMrWsAQEZ0oyxkABR" +
       "kcZ8MWROjI1hNRQb3RmOxWJkCpQL0nDT/1+MclTjhZM+HzhjiRcKFMiiPk2R" +
       "sJEQT2a39958LvEKDzOaGpatALyAW5BzCzJuQc4t6OSGfD7G5DbKlXsbfDUO" +
       "WQ+wW98V+/KuvUc7KiDM9MlKMDQlXV1UhsI2POQxPSGeuzI8e/nVurN+5AcE" +
       "SUIZsmtBp6sW8FJmaCKWAIzKVYU8MobK14GScqBLpyYPjR78DJPDCe/0wCpA" +
       "Jro9SkG5wKLTm9alzm048u6H5x8/oNkJ7qoX+TJXtJPiRofXpV7lE+La5cKF" +
       "xAsHOv2oEsAIAJgIkDCAbe1eHi786M5jMdWlBhROaUZGUOhSHkDrSNrQJu03" +
       "LNaa6LCIhx0NB4+ADMa/ENNPv/7bv25ilswjfoOjVMcw6XagDD2smeFJkx1d" +
       "IwbGQPfHU9ETj904soeFFlCsLMWwk45hQBfwDljw4Zf2X3vrzTOv+e1wJFBm" +
       "s0noWHJMl9s+hj8fPP+hD0UG+oIjRHPYgqnlBZzSKefVtmyAWAokMw2Ozt0q" +
       "BJ+ckoWkgmku/Kth1cYL7x9v5O5W4E0+WtZ/8gH2+9u3o4deeWC2nR3jE2nF" +
       "tO1nk3EYXmif3GMYwhSVI3fo6tJvviicBkAHEDXlacxwETF7IObAzcwWITZu" +
       "8qzdTYdO0xnj7jRydDYJ8ZHXPpg/+sHFm0xad2vk9PuAoHfzKOJesCC6GKfp" +
       "aotOx8U5kGGxF3T6BDMNh22+NPilRuXSLWAbB7YiQKc5ZADe5VyhZFFXVb/x" +
       "81+07L1Sgfw7UJ2iCdIOgSUcqoVIx2YaoDKnf3Ebl2OyBoZGZg9UZCFq9GWl" +
       "3dmb0QlzwPSPF/9w6zMzb7Io5GF3B9teYdK2zYuNrPe20/r960++/bPZ71bz" +
       "yt1VHss8+1r/OaQkD//loyJPMBQr0VV49sdD555qC9/zHttvwwndvTJXXGMA" +
       "cO29nz2b+bu/I/ArP6qOo0bR6nNHBSVLMzkOvZ2Zb36hF3atu/s03pR0F+By" +
       "iRfKHGy9QGbXNphTajqf74m626kXe+C504q6O71Rx4odzysqUjCcBmwRoWnc" +
       "/I2d18bbVufAQGFUNUGFh8T6PN3Vx85fxcY1dFjH/U1QtW7IcHkCNQMm678J" +
       "CC2rgpIriMQCq3UOkcAMUI0T0eGhaO/wyP2J0Z7I7t5ErDfaM9wzMjTMUtUR" +
       "VPRiFssmTRI15AzA7ITVNp5vmd3/y+rpe/MtYaktnPI+c+DyT/reSTAYr6GF" +
       "eSRvTkfJ7THGHOWhkQ4baM7OEbIeiUIHmt8af+rdZ7lE3vj0EOOjJ499HDx+" +
       "ksMrvxqsLOrOnXv49cAj3Yq5uLAdO945f+Cn3ztwhEvV7G50e+Ee9+zv//2b" +
       "4Kk/vVyio6oU01YjQkHDV+iIWrzW5joFNp7+x8Gvvz4EJbwf1WRVeX8W90vu" +
       "UK42s0mH+e1bhx3elna0khHkW6vrVpWm4xY69PNo6y4LcdvdCbIFnjVWNK4p" +
       "kSB0sgt10x+pTOjT6SAdhugQLRHu5RjQQgzhPrw74ghyurLboxX+lFqthafL" +
       "YtpVVqvl9CfzP2tVjgHkfSzaE+4tpYg6hyK50pL46HS9zZ/9Beaopo4yxDVt" +
       "JWjFHP1/bAoKQI5mzNJyV1iWLWcOn5yRhp7e6Lfahz0Eiqqmb1DwBFZcTGnu" +
       "eWvfALu424Vky9XZiuuPttYXXwnoSe1lGv615RHHy+DFw39rG7knvfdT9PrL" +
       "PPp7j/z+wLmXd64WH/Wzbw+8bhV9s3Bv6naneJ2BSdZQ3UndUfBtc74obLJ8" +
       "u8kbvHY8FQWKnwUKC1lPtDbNcaKnP/S546aRxs3kJjEoaZngIDiECXBsjqby" +
       "OB2+Bjlg0jslIxm1IJn+xAE5JzRZslPi4U/KbVdTRl9syxFU77y40lattegj" +
       "Gf+wIz4301CzeGb3H9jlqfDxpR7KXSqrKM5OwjEP6AZOyUyhet5XcKQ9RdDi" +
       "MqlE6z6bMKGf4PRPWiZ00oNt2K+TboagOpsOjuITJ8m3CaoAEjr9jl7wj929" +
       "8IYq53NkogUpzMyLPsnMhS3OCxjNMvaRMp8RWf6ZEnqMmV2DD968+2l+ARQV" +
       "YXqanjIPyhi/ZhayakXZ0/JnBfq6bi14vnZVHllcF1CnbMz7EJ7sstbmuRGZ" +
       "nYWL0bUzWy++ejRwFer2HuQTCFq4p7j1zOlZSPk9kVIFGzCHXda6697ee/mj" +
       "N3zNrMO3wK19rh0J8cTF69GUrn/Lj2r7URUAJ86xvvjeKXUYixOGq/4HklpW" +
       "LXzPXEDDU6AfMJllLIPOL7yl3wYI6ijuhYq/l8DlZxIb2+npVj/hwqGsrjtX" +
       "mWUTPE+ppSHWEpEBXbeuzNXPMMvrOsu/C3TY+1/uw8TtiRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5/U7TmDLa/JZxsDzhmvY8oaT2FKsBjuXzkXaw1cgrBWQVVU/0Pum9cDrUzBB" +
       "OHQmzoUHPv2Tea8nC/6PFuWlvHhDYcBbIuicHxgxCGKAAGGRoEZAaMOV7EKu" +
       "y0BDsBJdZTmGJbjp4qqADXni6oRgMQ6bMtyLOwAbGA5AsPha3oQ8dfHb1ke/" +
       "+5ldTnTS2ieItfc//Us/3vvg06ePZKKvuy4ZPNpnl40WYt9VyJ7Hz6MvNkrR" +
       "o/uPn3vqjz751Pt2Ul08nlcRYNvwmb/6r6/tfeQ7X7nBAn6rAuZ+h/V5WckL" +
       "bBch9ZtG05Xjtm6A543XbP3GG9g6r7ShK/nX9CZWzKvdvOjlBblvuYu55Th+" +
       "eMReeQt9QmD+ZQr8BHguXxP48k0FfiT/etvLE/jMhMVw4kYyvv0lZdxZ/BRY" +
       "yc6U9xp7aP5bfZHh33j98PeZtnJpf3UTwNYMgNMl024U/V8NNqOHMbfbz5wQ" +
       "8vL/WkjgmHcfMht6YGv0gX/40Nd+9XXfBk7W34/d4OiIo02+W/zF55558BVP" +
       "f+cDxdIN1m32w8SFJ3OuzstT9YFc1UmR8w6lMKKLFVZTD7TtH9FnBPzc9v4P" +
       "2kZ3fY2shhS2/xmWFlo54dPU0ZlW7LaTBYLTYppQWNpmmeqgyhORtPBrziDZ" +
       "qhYML7Y22SszsYrWKvCgVZkJlcysNvzxlO8SY7uLzSYoLi4ka8N3fWIs8LNo" +
       "5gmTltglpMV6yXMb3AmmIxJ1ZIrikd5as2U9GGWjRlSFq4o/R3g0rI/URl1s" +
       "IJVGHNnZqIQLkoQxcwGzKd5w1F7S8ypjrTtOppNyt0vTKKf1w7GJVGopTYqV" +
       "Fq811yOMxEsUDkvYoL+qrqqJsF1sTV/urwmLEMKpQ4U8V+GwUrhwRjg1HDhp" +
       "RBhlLWPrlBduHQ6zMszutWc03vMmeIe0xL681DchtvTFrtMZr/pW2UvReEzy" +
       "ZMlbi2yZi6V5O8ZNUxg4DbLmjMclLl70CZTyJmUwN/3uCPXRDO34Kl+Xe10K" +
       "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" +
       "/wCuZ9MlLyMAAA==");
}
