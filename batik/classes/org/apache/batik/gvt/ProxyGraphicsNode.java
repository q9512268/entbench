package org.apache.batik.gvt;
public class ProxyGraphicsNode extends org.apache.batik.gvt.AbstractGraphicsNode {
    protected org.apache.batik.gvt.GraphicsNode source;
    public ProxyGraphicsNode() { super(); }
    public void setSource(org.apache.batik.gvt.GraphicsNode source) { this.
                                                                        source =
                                                                        source;
    }
    public org.apache.batik.gvt.GraphicsNode getSource() { return source;
    }
    public void primitivePaint(java.awt.Graphics2D g2d) { if (source != null) {
                                                              source.
                                                                paint(
                                                                  g2d);
                                                          } }
    public java.awt.geom.Rectangle2D getPrimitiveBounds() { if (source ==
                                                                  null) return null;
                                                            return source.
                                                              getBounds(
                                                                ); }
    public java.awt.geom.Rectangle2D getTransformedPrimitiveBounds(java.awt.geom.AffineTransform txf) {
        if (source ==
              null)
            return null;
        java.awt.geom.AffineTransform t =
          txf;
        if (transform !=
              null) {
            t =
              new java.awt.geom.AffineTransform(
                txf);
            t.
              concatenate(
                transform);
        }
        return source.
          getTransformedPrimitiveBounds(
            t);
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() { if (source ==
                                                                 null)
                                                               return null;
                                                           return source.
                                                             getGeometryBounds(
                                                               );
    }
    public java.awt.geom.Rectangle2D getTransformedGeometryBounds(java.awt.geom.AffineTransform txf) {
        if (source ==
              null)
            return null;
        java.awt.geom.AffineTransform t =
          txf;
        if (transform !=
              null) {
            t =
              new java.awt.geom.AffineTransform(
                txf);
            t.
              concatenate(
                transform);
        }
        return source.
          getTransformedGeometryBounds(
            t);
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds() {
        if (source ==
              null)
            return null;
        return source.
          getSensitiveBounds(
            );
    }
    public java.awt.Shape getOutline() { if (source == null)
                                             return null;
                                         return source.getOutline(
                                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AMr3sTkNGXqhwlTE58xU+qf7bCHvmzw+5aZWEP9nFcZewOZHln8aZqpZ3oDO" +
       "TQEg7Tg2D57DtlSHJw9IuakVhP51hbHz2LzCSSMAsiXH8d7XcVstrtsazlD7" +
       "xklA8+r/A5o8GG3RNSjW73OK/lyx/hCQnjzSWj/7yK2viJLDvbRvguIhlVMU" +
       "f4Xpe6/VDZaShahNVr2pi68LnMwoVeZxUgWt2PSbFuVbnLQFKTmpEd9+uj8B" +
       "iB4dFJXWi5/kInAHEnz9i+7A3FOy2uwbMbkBZZUfnXyosCx0D2Tm5Q7EV0ku" +
       "KUjmxf9dThGUs/7xSkgnj2zcvO/i+x+3LgIlhe7di1ymxUiddSfpFlKLy3Jz" +
       "eNVu6LnUcqphqZNLt1sb9hR9nk8b+8DH6agEcwO3ZGa3e1n22tHVZ35yoPZF" +
       "KBt2kBCFrG1H8S1FXs9BBbsj5tWwvv9LxfVdb8/nx29emfrzr8Q9ECm6/QnS" +
       "J6SXj93x0sE5RzvDZNogqYEygeXF9cnacRWSmFEjTpplcyAPWwQuMlUGSX1O" +
       "le/MscFkjLSgvlL8J0zgYsPZ7PbiNTInXcXlT/Hle6OijTFDOC1k0wxFr9dj" +
       "nUygFs3pemCC1+Me5Yxi2RPS2k+3fuf+jqp1YHMF4vjZ15m5EbfO9f83Jzqs" +
       "ag2bbB7PGUwgEduk606hVoMHDsOhaosG+zkJrbB6A8EvVIfsQrXiFZuG/wKt" +
       "ffMQdh8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZEQ2pSE+FTB7rubgcc9dNPRJv8PlGuVpVWX7xWppRuRnleGqa/NVe1RmZk1D" +
       "9ytrj8uTCM4NkOo0HxcQGOcWzbYxb1NKiRgwTMFXlmqnjfV7Adll6LDV4wZO" +
       "caA1azWjFwpVZz7CG521J6E07aiM4I+GcTEYkvEAqzlUrtwo6YjR5aZToVpw" +
       "lyubEIqJNkGT/Fro6bSs1Qu0QdOa0hBDEst18VwId1i8s8gVB4W+7+lM4A+Z" +
       "ItDeQG4FHuhVL7Gj3FCxEW7A2fTQt00uAmFBHTcbLTspFXlMoEWlOOgteLuz" +
       "ChQeXxJjl+FnYatdRiYLi6hYjf5QLXFabVKlaBXMaEQ1EX2O8xaIuQWkEnKW" +
       "zQuVBDbZ1YgSYNZDHK+hA1QcTS9WVGdsuvlRIdds15a9caMXK7RnNEgSaRJi" +
       "sdC22by/sGoIgy9Hk7rs6VW02fBrDqATugXRmzaTotnJRy28qspGvz9IDC4/" +
       "9LRmedLXlsEI52r5aDozlFmQnw3GQJ2CSXnL8qw6dOzSRLPbmLdgp7VZHKl0" +
       "T/aMqutLcY7pRuRkLc6YiFUqUmcVkmquO3OHq0qZqCpojfKMOhNhwaJHjIEe" +
       "pHjJT/AkT655j5yum7rcZKRWHCxXNbJYC9TqehJL43V3zOTluE10vCDnkZSH" +
       "+WOj35wv1cgc13EinuSWcomvtlbWOsrhHDur02W7IbBSNGBbpk1w7NJlMac2" +
       "GA/rSmkM5MBLtcBkWp2o3A45Y6rSOKLyrTXaW1cZhiJ9bd4ixNJcmPqBF/jc" +
       "2qyVYsMkiZwHk7hDNJvYqM/osxI26MJmEsNqdWjra7AIwaWki660Tq+24kcr" +
       "JWyr5pSayIW5KxXhKXBlRuXU/tRDXa1I9EDe5kwlNp4ANaM0wzfCKW/3ho3u" +
       "2HLrYjkX6kRFqxTERmc+03DYaNtkq26vy1quRGKNQYKGEU/xRoVlJ7I9Txy/" +
       "Gudr6NjCh6X6NG+E3YluxXJZHKvNiQ+XYsZQbB3kFKsBrOXiHNZT2qYqlUQN" +
       "Sax4ookiI7sNs9tLsM5a6k/DYs+eCEtXXbLA9RCfL6ujsm0QfI6otYqcUhei" +
       "AcY2OUxCbBQNWlMWwxOHZhvdSoAalWrDayItgkEac79cqfC+jgezaLUq92J5" +
       "KvIEbMdoWbJkb+0Rw3K9ahXhoc10isxcL2Nx3q/jo/WqxvYdZbmoJ4o0b5QF" +
       "mxNGM8Zq1PUxSM+FhKRn0TCkzEmTAau5KcGULzQMvccoK7NHdPJrZeHTbInm" +
       "tf64bc+FuTmGW6YEgoc+btQGVcTIR3HDK4u6PUmUho+5klWtIjlKwhexho5o" +
       "BjVymBzKOX3pIosW1SisdBbBLbzOy4OyTABNLX1OQXm+UqKbk0ipi6FRzBfV" +
       "qUO1av5A5Ry/mVsbHY+vFEmivpq2ZX/ozbUGGzbhqBvIMjUUVQK8wL7mNemr" +
       "rfLT7S7ckG2k7B/d6WYpbRj9FG/Vm6a70+Kl+zta2e/U0eOeg5vH2x1FKN0p" +
       "uP1yJ3LZLsEH3vbYE+Lgg8jx3Z1YPoBOB477cybIW80DrE4DTvdffkeEyg4k" +
       "tzuEn3nbv986/nn1jT/FucedR+Q8yvL3qSc/13yZ8JvHoWv29wsvOio93OmB" +
       "w7uEZzwpCD17fGiv8PbDZw/p5iy2q1ns0mcPl94ozKxgM/dHNrqPbQmaGcFD" +
       "V9gJf3NaxGASfClgtruGrz9gK1wAnVg5mrg1ouQnbc0cHCWrCPdR35JW3g2u" +
       "V+2iftXVQX0Q1G9coe3RtHgYAFb2AGeK2oJ75DmA25/S6i646lWd0r090c2J" +
       "CBdtN3HRWtbv8SsAf19avCuAzrp7W3c0p9nZ+c1bt+gfew7ob04r7wNXbxd9" +
       "7+pP7e9eoe1DafHbAXQjmNr9/cmKE9qiv6e5F+9rTpEca2ckCcBxFVNCa1sV" +
       "/M5zVUEBXOyuCtifiQHcfhgGKcuaLY09zvbTE9CMw8evoKhPpsVTgA1Q1H4v" +
       "STyis5Tow1u1fOy5quUV4DJ31WJefcv40yu0/XlafAqskQBwE2hMCrzkkiA/" +
       "/VxBpjH8oV2QD13VuU8fP5ERfPEKSL+UFp8LoNsOT+0VQf/V1fD5d+yCfsfV" +
       "n9mvXaHtH9LibzY+z0i2f3n7/epzQJklQi8B13t3Ub736qP8lyu0fTst/imA" +
       "zgCUgzBIP9zZCwVn90MBeKHY/cohw/utnwYvyABuuOh7lfTw/ZaLvoLbfLkl" +
       "fPSJc9fd/MTkb7NPNva/rjrdg66TQ9M8eFZ64P6U60mylkE6vTk5dbO/ZwLo" +
       "hZc6pAyga0CZSfu9DeV/BtD5o5QBdDL7P0j3A6CsLV0AndrcHCT5EeAOSNLb" +
       "Z909dd53ybNSkgevf5wQHNROfOxw5ruv+Bt/kuIPJMv3Hkpxsw8T99LRcPNp" +
       "4oPCU090+m96pvjBzUcmgsmt1ymX63rQtZvvXfZT2rsvy22P16nWfc+e/djp" +
       "l+6l32c3Am+t94Bsd176i4665QbZNxjrT9788Vf/3hNfz45F/w/yRVKVMSoA" +
       "AA==");
}
