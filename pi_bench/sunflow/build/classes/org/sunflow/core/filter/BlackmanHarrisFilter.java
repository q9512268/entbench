package org.sunflow.core.filter;
public class BlackmanHarrisFilter implements org.sunflow.core.Filter {
    private float s;
    private float inv;
    public BlackmanHarrisFilter(float size) { super();
                                              s = size;
                                              inv = 1.0F / (s * 0.5F); }
    public float getSize() { return s; }
    public float get(float x, float y) { return bh1d(x * inv) * bh1d(y * inv);
    }
    private float bh1d(float x) { if (x < -1.0F || x > 1.0F) return 0.0F;
                                  x = (x + 1) * 0.5F;
                                  final double A0 = 0.35875;
                                  final double A1 = -0.48829;
                                  final double A2 = 0.14128;
                                  final double A3 = -0.01168;
                                  return (float) (A0 + A1 * java.lang.Math.
                                                    cos(
                                                      2 *
                                                        java.lang.Math.
                                                          PI *
                                                        x) +
                                                    A2 *
                                                    java.lang.Math.
                                                    cos(
                                                      4 *
                                                        java.lang.Math.
                                                          PI *
                                                        x) +
                                                    A3 *
                                                    java.lang.Math.
                                                    cos(
                                                      6 *
                                                        java.lang.Math.
                                                          PI *
                                                        x)); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYC2wUxxmeOz/xAz/A5m3AGCIeuQtJaINMKWDs2PQMlk1Q" +
                                                              "eyQce3tz9uK93WV31j47oU2IKkilUpo4hFbBUiUiKCIBVY3aKg9RRW0SJa2a" +
                                                              "NG2SViFVW6m0KWpQ1aQqbdP/n9m7fdydEVJjaefWM///z/zP7589f5VUWCZp" +
                                                              "oxqLsAmDWpFujQ1IpkVTXapkWbthLiE/USb9fd+VnRvDpDJOZo9IVr8sWbRH" +
                                                              "oWrKipMlimYxSZOptZPSFHIMmNSi5pjEFF2LkxbF6ssYqiIrrF9PUSTYI5kx" +
                                                              "0iQxZipJm9E+RwAjS2Jwkig/SXRrcLkzRupk3Zhwyed7yLs8K0iZcfeyGGmM" +
                                                              "HZDGpKjNFDUaUyzWmTXJWkNXJ4ZVnUVolkUOqBscE+yIbSgwQfvFho+uHx9p" +
                                                              "5CaYI2mazrh61iC1dHWMpmKkwZ3tVmnGOki+TMpipNZDzEhHLLdpFDaNwqY5" +
                                                              "bV0qOH091exMl87VYTlJlYaMB2JkuV+IIZlSxhEzwM8MEqqZoztnBm2X5bUV" +
                                                              "Whao+Pja6NQT+xq/V0Ya4qRB0YbwODIcgsEmcTAozSSpaW1NpWgqTpo0cPYQ" +
                                                              "NRVJVSYdTzdbyrAmMRvcnzMLTtoGNfmerq3Aj6CbactMN/PqpXlAOf9VpFVp" +
                                                              "GHRtdXUVGvbgPChYo8DBzLQEceewlI8qWoqRpUGOvI4dXwACYK3KUDai57cq" +
                                                              "1ySYIM0iRFRJG44OQehpw0BaoUMAmowsLCkUbW1I8qg0TBMYkQG6AbEEVLO4" +
                                                              "IZCFkZYgGZcEXloY8JLHP1d3bjp2v9arhUkIzpyisornrwWmtgDTIE1Tk0Ie" +
                                                              "CMa6NbETUusLR8OEAHFLgFjQ/OCBa1vWtV16RdAsKkKzK3mAyiwhn07OfmNx" +
                                                              "1+qNZXiMakO3FHS+T3OeZQPOSmfWgArTmpeIi5Hc4qXBn37pwXP0gzCp6SOV" +
                                                              "sq7aGYijJlnPGIpKzbupRk2J0VQfmUW1VBdf7yNV8B5TNCpmd6XTFmV9pFzl" +
                                                              "U5U6/x9MlAYRaKIaeFe0tJ57NyQ2wt+zBiGkCh5yBzwVRPzxX0a+GB3RMzRq" +
                                                              "KNEBU0fVrSgUmySYdSRq2Vpa1cejlilHdXM4/7+smzQK20LIRLep4PmMpPVK" +
                                                              "pqlYPXwyghFmfIqys6jXnPFQCEy+OJjwwER7dTVFzYQ8ZW/rvvZM4jURTJgA" +
                                                              "jkUYWQe7RpxdI7hrROwaKbYrCYX4ZnNxd+Fb8Mwo5DgU2brVQ/ft2H+0vQyC" +
                                                              "yhgvB7MiabsPbLrcQpCr3gn5QnP95PLL618Kk/IYaZZkZksqYsdWcxiqkjzq" +
                                                              "JG5dEmDIRYNlHjRAGDN1maagGJVCBUdKtT5GTZxnZK5HQg6rMCujpZGi6PnJ" +
                                                              "pZPjD+35ym1hEvYDAG5ZAbUL2QewbOfLc0cw8YvJbThy5aMLJw7pbgnwIUoO" +
                                                              "CAs4UYf2YDgEzZOQ1yyTnk28cKiDm30WlGgmQUpB9WsL7uGrMJ25ao26VIPC" +
                                                              "ad3MSCou5Wxcw0ZMfdyd4XHaxN/nQljUYsothafayUH+i6utBo7zRFxjnAW0" +
                                                              "4GjwuSHj1Ds///Md3Nw54GjwIP4QZZ2eYoXCmnlZanLDdrdJKdC9d3Lgscev" +
                                                              "HtnLYxYoVhTbsAPHLihS4EIw81dfOfju+5dPvxV245wBWttJaHqyeSVxntTM" +
                                                              "oCTstso9DxQ7FSoDRk3HPRrEp5JWpKRKMbH+3bBy/bN/PdYo4kCFmVwYrbux" +
                                                              "AHd+wTby4Gv7Pm7jYkIygq1rM5dMVPA5ruStpilN4DmyD7255FsvS6cAC6D+" +
                                                              "Wsok5SU1VCzXMZ+G7KQFealkwA1jDjrdPrBfPtox8EeBPAuKMAi6lrPRr+95" +
                                                              "+8Dr3MnVmPk4j3rXe/IaKoQnwhqF8T+BvxA8/8UHjY4Toso3dzlQsyyPNYaR" +
                                                              "hZOvnqE59CsQPdT8/uiTV54WCgSxOEBMj0597ZPIsSnhOdGwrCjoGbw8omkR" +
                                                              "6uCwEU+3fKZdOEfPny4ceu7soSPiVM1++O2G7vLpX//n9cjJ371aBAEghXRJ" +
                                                              "tJ13+tw51+8dodL2RxqeP95c1gNVo49U25py0KZ9Ka9M6LgsO+lxl9sK8Qmv" +
                                                              "cugaRkJrwAt8egM/xm35wxB+GMLXenFYaXmLp99ZnqY6IR9/68P6PR++eI0r" +
                                                              "7O/KvbWiXzKEtZtwWIXWnhcEt17JGgG6Oy/tvLdRvXQdJMZBogytqLXLBHzN" +
                                                              "+iqLQ11R9Zsfv9S6/40yEu4hNWDhVI/EizSZBdWRWiMAzVnj81tEcRjH6tDI" +
                                                              "VSUFyhdMYIIuLZ763RmD8WSd/OG87286M32ZVylDyFjE+cPYLfhQmd/tXGA4" +
                                                              "98vP/urMN0+Mi2CaITUCfPP/tUtNHv79PwtMznGwSLYE+OPR808u7Nr8Aed3" +
                                                              "AQm5O7KFHQ6Aust7+7nMP8LtlT8Jk6o4aZSdu9QeSbWxzMfh/mDlLlhw3/Kt" +
                                                              "++8CovHtzAPu4mC6erYNQqE3B8qZL95d9KtDFy6Ap9IBhsog+oUIf4lzllv4" +
                                                              "uAaHW3NgU2WYCty3aQBtamcQCknGie8S0IpjHw57hYxYyUDcffMHl3G4l5Ey" +
                                                              "RRsrtmdqhj3F0i04rM3vnN/N17R7sdSNbqHmfEbmFTS2oofFFF9S6t7Fi+np" +
                                                              "w1PTqV1PrQ87hWcLg5zVjVtVOkZVz1ZlKMmXSP38pulG5XuzH/3DjzqGt91M" +
                                                              "Z4tzbTfoXfH/pZASa0rnZvAoLx/+y8Ldm0f230STujRgpaDI7/aff/XuVfKj" +
                                                              "YX6tFulScB33M3X6k6TGpMw2NT80rMj7vQndPB+eesfv9cUbxSIhk2+/SrHO" +
                                                              "ADSTM6w9gIMNKThM2RB0QDy+3dAeu1E6zVzXcWLQ4PMH/VbIv+R+b84KpVgD" +
                                                              "moYFQOST9i4u+sgM9ngEh8OQ62CPgC0e/hRs0YxrrfC0OAq13MAW9xWWyFKs" +
                                                              "AS2dPsg1w9QMZjiBwzcYKU+OrE8F7HD8/2GHLFxXi93IsRWYX/CtT3yfkp+Z" +
                                                              "bqieN33P27z85L8h1UEhSduq6gUrz3ulYdK0wrWqE9Bl8J/pYiVVfCtg+DUP" +
                                                              "X/jpTwn67zDSGKQHA+GPl+w0I7UeMobNI3/zEp2BAAMifD1r5Ap8I++AELQj" +
                                                              "ArSzIU9xdkzJPdByIw/kWbw3QCyp/GNrrvzZ4nNrQr4wvWPn/dc+85S4gcqq" +
                                                              "NDmJUmqh8xWX4XwJXV5SWk5WZe/q67MvzlqZA5smcWA3jBd5wmwQAtJAly8M" +
                                                              "XM+sjvwt7d3Tm1782dHKN6GL2ktCEiNz9ha2N1nDBuzaGyvs8AFu+L2xc/W3" +
                                                              "JzavS//tt7yBJOJGsLg0PbRvj73Td3H04y38614F4CjN8r5r+4Q2SOUx03dd" +
                                                              "mI3RKOFnV24Hx3z1+Vn8XsFIe+FdqfArDzTX49Tcptsazzy4cNS6M76vvjnU" +
                                                              "sQ0jwODOeO6T23HYmEXrQ/wlYv2GkbtK/sLgedldrFp0c+bn+CsOz/8PW5rS" +
                                                              "uncZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
