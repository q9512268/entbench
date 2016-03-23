package org.sunflow.core.filter;
public class CatmullRomFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return catrom1d(x) * catrom1d(y);
    }
    private float catrom1d(float x) { x = java.lang.Math.abs(x);
                                      float x2 = x * x;
                                      float x3 = x * x2;
                                      if (x >= 2) return 0;
                                      if (x < 1) return 3 * x3 - 5 * x2 +
                                                   2;
                                      return -x3 + 5 * x2 - 8 * x + 4; }
    public CatmullRomFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39/4C8wEALmy6CakFtoQ9vINAUcO5icwcIE" +
                                                              "tablGO/N3S3e2112Z+2zCW0StYJ+UUSA0KrhL6ImURJQ1ait2kRUkZpESSsF" +
                                                              "RU3SKqRSK5V+oAZVSv6gbfrezO7tx9lGVM1JN7c38+bNe29+83tv9plrpMax" +
                                                              "SRczeIpPWcxJ9Rt8mNoOy/bp1HH2QF9GfayK/nP/1Z13J0ntKGkpUGdIpQ4b" +
                                                              "0JiedUbJMs1wODVU5uxkLIszhm3mMHuCcs00Rkmn5gwWLV1TNT5kZhkK7KV2" +
                                                              "mrRTzm1tzOVs0FPAybI0WKIIS5St8eHeNGlWTWsqEF8cEu8LjaBkMVjL4aQt" +
                                                              "fZBOUMXlmq6kNYf3lmxyh2XqU3nd5ClW4qmD+iYvBDvSmypCsOpi6wc3ThTa" +
                                                              "RAjmU8MwuXDP2c0cU59g2TRpDXr7dVZ0DpGvkKo0aQoJc9Kd9hdVYFEFFvW9" +
                                                              "DaTA+nnMcIt9pnCH+5pqLRUN4mRlVIlFbVr01AwLm0FDPfd8F5PB2xVlb6WX" +
                                                              "FS6evkM59dj+th9VkdZR0qoZI2iOCkZwWGQUAsqKY8x2tmazLDtK2g3Y7BFm" +
                                                              "a1TXpr2d7nC0vEG5C9vvhwU7XYvZYs0gVrCP4Jvtqty0y+7lBKC8fzU5nebB" +
                                                              "14WBr9LDAewHBxs1MMzOUcCdN6V6XDOynCyPzyj72H0/CMDUuiLjBbO8VLVB" +
                                                              "oYN0SIjo1MgrIwA9Iw+iNSYA0OZkyaxKMdYWVcdpnmUQkTG5YTkEUg0iEDiF" +
                                                              "k864mNAEu7Qktkuh/bm2c/Pxw8Z2I0kSYHOWqTra3wSTumKTdrMcsxmcAzmx" +
                                                              "eV36DF34wrEkISDcGROWMj958PqW9V2XXpEyt88gs2vsIFN5Rj0/1vLG0r6e" +
                                                              "u6vQjHrLdDTc/Ijn4pQNeyO9JQsYZmFZIw6m/MFLu3/1xYeeZn9LksZBUqua" +
                                                              "ulsEHLWrZtHSdGbfxwxmU86yg6SBGdk+MT5I6uA5rRlM9u7K5RzGB0m1Lrpq" +
                                                              "TfEfQpQDFRiiRnjWjJzpP1uUF8RzySKE1MGXKPCtIfIjfjnZoxTMIlMsTRm2" +
                                                              "TXTdUYBsxiCsBcVxjZxuTiqOrSqmnS//V02bKbAsQEbpo7zo6vpuszggOlKI" +
                                                              "Lutj0ltCf+ZPJhIQ6qXxg67DGdlu6llmZ9RT7rb+689lXpMgQuB7keDkE7Bi" +
                                                              "ylsxhSum5Iqp+IokkRALLcCV5X7CbozDuQZibe4Z+fKOA8dWVQGQrMlqCCWK" +
                                                              "rookmL7g8PuMnVEvdMybXnll40tJUp0mHVTlLtUxX2y188BE6rh3WJvHIPUE" +
                                                              "GWBFKANg6rJNlWWBgGbLBJ6WenOC2djPyYKQBj8/4UlUZs8OM9pPLp2dfHjv" +
                                                              "VzckSTJK+rhkDfAVTh9Gqi5Tcnf8sM+kt/Xo1Q8unDliBsc+kkX85FcxE31Y" +
                                                              "FYdCPDwZdd0K+nzmhSPdIuwNQMucwjECxuuKrxFhlV6fodGXenA4Z9pFquOQ" +
                                                              "H+NGXrDNyaBHYLQdm04JV4RQzEBB7p8bsR5/+zd/+ZSIpJ8HWkMJfITx3hD3" +
                                                              "oLIOwTLtASL32IyB3Ltnhx89fe3oPgFHkFg904Ld2PYB58DuQAS//sqhd967" +
                                                              "cv7NZABhDsnXHYMapiR8WfARfBLw/Q9+kS+wQ/JGR59HXivK7GXhymsD24DH" +
                                                              "dDj4CI7uBwyAoZbT6JjO8Pz8q3XNxuf/frxNbrcOPT5a1t9cQdB/2zby0Gv7" +
                                                              "P+wSahIq5tEgfoGYJOf5geattk2n0I7Sw5eXfe9l+jjQPFCro00zwZZExIOI" +
                                                              "DdwkYrFBtHfFxj6DzRonjPHoMQrVOxn1xJvvz9v7/ovXhbXRgim870PU6pUo" +
                                                              "krsAi20gXhNhbxxdaGG7qAQ2LIoT1XbqFEDZXZd2fqlNv3QDlh2FZVUoJZxd" +
                                                              "NvBkKQIlT7qm7ne/fGnhgTeqSHKANOomzQ5QceBIAyCdOQWg2JL1+S3Sjsl6" +
                                                              "aNpEPEhFhCo6cBeWz7y//UWLix2Z/umiH2/+4bkrApaW1HF7WOFa0fZgs17C" +
                                                              "Fh/vLJWDJT61cwQrpDMhnhdzsqgiLcgsgIFdNlu1Iiqt84+cOpfd9cRGWVN0" +
                                                              "RCuAfihwn/3tv19Pnf3DqzMkowZuWnfqbILpIZuqcMlIJhkShVzAZu+2nPzj" +
                                                              "z7rz224liWBf103SBP5fDk6smz0pxE15+ZG/LtlzT+HALeSD5bFwxlU+NfTM" +
                                                              "q/etVU8mRdUqU0FFtRud1BsOLCxqMyjPDXQTe+aJ07S6DJB2xMNiDyQ+WCKn" +
                                                              "SRK3QBs2/eWpAoeNc0ydgyy+MMfYKDYjnNTlGR8BFooWE7i3I+6YA4lfK0Iy" +
                                                              "mPBK3k8OH1CPdQ//SULvthkmSLnOJ5Xv7H3r4Otik+oRFeXQhBAB6AmlsDZs" +
                                                              "Ugj/njkukFF7lCMd743/4Oqz0p54vR4TZsdOffOj1PFT8ljIS83qintFeI68" +
                                                              "2MSsWznXKmLGwJ8vHPn5k0eOJr1Y388x3ZqUl3ciUa7gFkRjKC299xutvzjR" +
                                                              "UTUAx22Q1LuGdshlg9ko5OocdywU1OAWFADQsxlzKCeJdT65fRabPfJ58//I" +
                                                              "q9ixzRL9u6IwX+Dh1cftLcJ8tqkxKCeFIUn8u180QrUzB+BdbOA+VQWAFzOC" +
                                                              "WJgfQyw6cGwJfFs8h1rmiEVFgoFzadnaBBQ5pWiImubQGHM+EeQqGZ1H5ojO" +
                                                              "17A5zEm9SrltFjdmYyF68P8RohInbfFLD2boxRWvUOS1X33uXGv9onMPvCXS" +
                                                              "Tvlq3gyUkgMdocMQPhi1ls1ymvCqWVY1lvj59kw5V17FOL4kwQdh+bek/HfB" +
                                                              "2rg8J9X4ExY7yUlTSIzjwRRPYaHTgDsQwsczll8BtInCBN+LpORLgFKisvgQ" +
                                                              "0e+8WfTLU8KVOJKneIfl84sr32LBnfDcjp2Hr3/6CXkTUHU6PY1amoBV5H2j" +
                                                              "nDpXzqrN11W7vedGy8WGNT7ZRW4iYdsEBgCQompfEiuNne5yhfzO+c0v/vpY" +
                                                              "7WWg6X0kQTmZvy/0BklGCuprF2qWfelK9oQyQ9TsvT3fn7pnfe4fvxd1nce2" +
                                                              "S2eXz6ijj749eHH8wy3ipUkN8DgrjZJGzbl3ytjN1Ak7QsUtiEaKb7NEHLzw" +
                                                              "zSv34pWQk1WV6aXyIg017ySzt5mukfXIvCnoibxM86sN17JiE4KeUEbNS/7H" +
                                                              "6AP+Mukhy/LvU5ctcSYLM7FFQUx+Sjxi8/R/Ac6ZuPLOFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "38xrof8L47D5FTkhAAA=");
}
