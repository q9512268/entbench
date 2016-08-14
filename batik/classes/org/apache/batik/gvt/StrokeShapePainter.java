package org.apache.batik.gvt;
public class StrokeShapePainter implements org.apache.batik.gvt.ShapePainter {
    protected java.awt.Shape shape;
    protected java.awt.Shape strokedShape;
    protected java.awt.Stroke stroke;
    protected java.awt.Paint paint;
    public StrokeShapePainter(java.awt.Shape shape) { super();
                                                      if (shape == null) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            );
                                                      }
                                                      this.shape =
                                                        shape; }
    public void setStroke(java.awt.Stroke newStroke) { this.stroke =
                                                         newStroke;
                                                       this.strokedShape =
                                                         null; }
    public java.awt.Stroke getStroke() { return stroke; }
    public void setPaint(java.awt.Paint newPaint) { this.paint = newPaint;
    }
    public java.awt.Paint getPaint() { return paint; }
    public void paint(java.awt.Graphics2D g2d) { if (stroke != null &&
                                                       paint !=
                                                       null) { g2d.
                                                                 setPaint(
                                                                   paint);
                                                               g2d.
                                                                 setStroke(
                                                                   stroke);
                                                               g2d.
                                                                 draw(
                                                                   shape);
                                                 } }
    public java.awt.Shape getPaintedArea() { if (paint == null ||
                                                   stroke ==
                                                   null) return null;
                                             if (strokedShape == null)
                                                 strokedShape =
                                                   stroke.
                                                     createStrokedShape(
                                                       shape);
                                             return strokedShape;
    }
    public java.awt.geom.Rectangle2D getPaintedBounds2D() { java.awt.Shape painted =
                                                              getPaintedArea(
                                                                );
                                                            if (painted ==
                                                                  null)
                                                                return null;
                                                            return painted.
                                                              getBounds2D(
                                                                );
    }
    public boolean inPaintedArea(java.awt.geom.Point2D pt) {
        java.awt.Shape painted =
          getPaintedArea(
            );
        if (painted ==
              null)
            return false;
        return painted.
          contains(
            pt);
    }
    public java.awt.Shape getSensitiveArea() { if (stroke ==
                                                     null)
                                                   return null;
                                               if (strokedShape ==
                                                     null)
                                                   strokedShape =
                                                     stroke.
                                                       createStrokedShape(
                                                         shape);
                                               return strokedShape;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds2D() {
        java.awt.Shape sensitive =
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return null;
        return sensitive.
          getBounds2D(
            );
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) {
        java.awt.Shape sensitive =
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return false;
        return sensitive.
          contains(
            pt);
    }
    public void setShape(java.awt.Shape shape) { if (shape ==
                                                       null) {
                                                     throw new java.lang.IllegalArgumentException(
                                                       );
                                                 }
                                                 this.
                                                   shape =
                                                   shape;
                                                 this.
                                                   strokedShape =
                                                   null;
    }
    public java.awt.Shape getShape() { return shape;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0opsXXUzn+zFEBedweZ5p9rwhckLExUm87gI8ZMr3z9BrCF2vhEydhabV6DG" +
       "csKEJlebVMLela4zXp0AZ8zAsSXw3GdbdF/5zghiDTH4vZCx97E5BznJdcYa" +
       "PaslIZicQJuVD7QU1TOxLXDQgYOZSm0K7q13JsBbU3BsPjwHbJMPlO+tINbw" +
       "rTWt0OI+Hfxib67zIb78HJuPGWlQNE9cFV6lYiXanx2ymK/kuKpvpzze2feJ" +
       "qE9mlWAQdNNOxH+y7d1db/CSsgZr2Hwh56lfoda1K0psm7EZF26/1/N+PyPV" +
       "Q7quUkkr8oRJphbqIKa/+cdNvz3QWrEWiuteUpPVlDuytDdZWGBWW9khj1Lu" +
       "5xTe4dUISyJGIkud+xAeSp9MFArhIfmoHQ9Hyw+lINbggIhEQsYqsPMbRpqx" +
       "gKGaxWOhBA59O1E4hDX+CdumE+W7I4g1xOTGkDGMiEgtI1O97nCQCBk+yLsk" +
       "UjdRYIOn4mdtu54t3yVBrMGl3afc9jkhfmnDZjrj33n9UfKl65IZE1nanLHt" +
       "OlO+S4JYg12ykpt9eYhL8O4tslBUu/lLKbeMiXROZLV71jbobPm+CGINMTXk" +
       "+j1yLTZXimrXvZtz3bDi/+GGHFQGxV8T8b57ZtG/KYhP6/JTx5pqZhy79V1+" +
       "/5L//F0P2Wo4q6reG1nPe5Vh0mFx0KkX97MGN/JGQIRS11CMVECLWkdWCco1" +
       "AKV+Sqhz+W8vXQ8jdS4dI1XixUuyDqQDCb72Gk5N0MxrArySjokr6ZxA9zle" +
       "D3LEnnYpx+dZvJ+t8AKD/4OIk3Oz4l9EBuVTx9ZvuvPCysfEZzNZlfbsQSmT" +
       "IdOKL3h2qvfeH/ilObKq1i35uvHp2kXO/UGLUNgN3jmeeqYbtqSBaz3b903J" +
       "6sx/Wnrv+PUv/WG86q0oiWwnEQmOJduLL+9zRtYkbdsTxRXFNsnkH7u6lhzd" +
       "vWr58D/e559HiKhA5gbTD8rnHr/t7YMzj7dHyeReMknRkjTHvyrcvFuDCnXU" +
       "HIAyzOrJgYogRZHUgnKlEcNSwn8d4X6x3dmQ78WProx0FF/5FH+qrlP1MWry" +
       "TIVioOCZ7PaIlfHdv2UNw8fg9niqtq+wGednHojHwcRGw3CukCq/Mfj+vFgK" +
       "QC/yGN7BX/Httv8BzjXChTwmAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e6zk1nkfd6XdldaSdrWyLVnR2+vYEt3L4bw4hOzEM5wh" +
       "hxzODGdIzoNxI/FNDp/DxwxnXLWOEdduA7hCIieu4eiP1kGcwLHT1kaLBmll" +
       "FI0TOHCRwn2kRWO3aJGkqdsYbZO0busecu69c/fu7rWF3QxwzuU95zvnfL/v" +
       "dZ6f/zZ0IY4gOAzcjekGyYGeJQcLt3aQbEI9PmDYGidHsa4RrhzHAih7SX3u" +
       "V6/8yXdfta6ehy5K0COy7weJnNiBH4/1OHBXusZCV/alHVf34gS6yi7klYyk" +
       "ie0irB0nL7LQW040TaDr7BELCGABASwgBQtIc08FGj2o+6lH5C1kP4mX0F+G" +
       "zrHQxVDN2UugZ2/sJJQj2TvshisQgB7uy/+fAFBF4yyCnjnGvsN8E+BPwshr" +
       "P/fjV//uPdAVCbpi+3zOjgqYSMAgEvSAp3uKHsVNTdM1CXrY13WN1yNbdu1t" +
       "wbcEXYtt05eTNNKPhZQXpqEeFWPuJfeAmmOLUjUJomN4hq272tF/FwxXNgHW" +
       "t++x7hCSeTkAeNkGjEWGrOpHTe51bF9LoKdPtzjGeL0HCEDTS56eWMHxUPf6" +
       "MiiAru1058q+ifBJZPsmIL0QpGCUBHr8tp3msg5l1ZFN/aUEeuw0HberAlT3" +
       "F4LImyTQ206TFT0BLT1+Sksn9PPtwfs+8SG/658veNZ01c35vw80eupUo7Fu" +
       "6JHuq/qu4QMvsD8rv/3XP34eggDx204R72j+/l/6zgfe+9Qbv7mj+aFb0AyV" +
       "ha4mL6mfVR76nSeI5/F7cjbuC4PYzpV/A/LC/LnDmhezEHje2497zCsPjirf" +
       "GP/G/MO/rP/ReegyDV1UAzf1gB09rAZeaLt6ROm+HsmJrtHQ/bqvEUU9DV0C" +
       "36zt67vSoWHEekJD97pF0cWg+B+IyABd5CK6BL5t3wiOvkM5sYrvLIQg6BJI" +
       "EAbSc9DuV/xNIAmxAk9HZFX2bT9AuCjI8ceI7icKkK2FKMDqHSQO0giYIBJE" +
       "JiIDO7D0wwpzleRmFDg6b8mhzsmFvR7kNhb+ufae5diurs+dA2J/4rTTu8Bf" +
       "uoGr6dFL6mtpq/OdL7z0tfPHTnAolQR6NxjwYDfgQTHgARjw4OYBoXPninHe" +
       "mg+8Uy1QjANcHAS/B57n/yLz8sefuwfYVLi+F0g1J0VuH4OJfVCgi9CnAsuE" +
       "3vjU+icmf6V0Hjp/YzDNmQVFl/PmXB4Cj0Pd9dNOdKt+r3zsD/7kiz/7SrB3" +
       "pxui86GX39wy99LnTos1ClRdA3Fv3/0Lz8hffunXX7l+HroXuD4IdwmQWB5J" +
       "njo9xg3e+uJR5MuxXACAjSDyZDevOgpXlxMrCtb7kkLfDxXfDwMZvyU33ydB" +
       "+tFDey7+5rWPhHn+1p195Eo7haKIrO/nw5//11//w0oh7qMgfOXEtMbryYsn" +
       "HD/v7Erh4g/vbUCIdB3Q/btPcT/zyW9/7McKAwAU77zVgNfznAAOD1QIxPzR" +
       "31z+7jd/77PfOL83mgTMfKni2mp2DDIvhy6fARKM9sN7fkDgcIF75VZzXfS9" +
       "QLMNW1ZcPbfS/3PlXeiX/8snru7swAUlR2b03u/fwb78HS3ow1/78T99qujm" +
       "nJpPXHuZ7cl20fCRfc/NKJI3OR/ZT/zzJ//mV+WfB3EVxLLY3upFeDp36Dg5" +
       "U29LoIeKlvIaOGPuhoUukaLyhSI/yOVQNIGKukqePR2f9Ikb3e7EuuMl9dVv" +
       "/PGDkz/+R98pQNy4cDlpAn05fHFndXn2TAa6f/R0AOjKsQXoqm8MPnjVfeO7" +
       "oEcJ9KiCYBYPIxB+shsM5pD6wqV/85V/8vaXf+ce6DwJXXYDWSPlwveg+4HR" +
       "67EFIlcW/ugHdjpf3weyqwVU6CbwO1t5rPjvEmDw+duHHTJfd+w997H/PXSV" +
       "j/yHP7tJCEXAucV0e6q9hHz+M48TP/JHRfu95+etn8puDslgjbZvW/5l73+e" +
       "f+7iPz0PXZKgq+rhAnAiu2nuTxJY9MRHq0KwSLyh/sYFzG62fvE4sj1xOuqc" +
       "GPZ0zNlPBeA7p86/L58KMw/lUn4cpHcfeuC7T4eZc1Dx0SyaPFvk1/Ps3Ude" +
       "fX8YBQngUtcOHft74HcOpP+Xp7y7vGA3G18jDpcEzxyvCUIwT12Icy/IG5d2" +
       "US3Pq3nW2vWJ3dZY3ncjlGdBeu8hlPfeBkrvNlDyz04hHzKBHoiLWVLjb8cZ" +
       "+yY5ewIk9JAz9DacjX8Qzi7uODsKJVf2oaQoP8Um/ybZzG2hfshm/TZs/tgP" +
       "wuaFMF9b3BzwiiXHKSY/+H2ZLDrNzgFzu1A+wA4KZWi3ZuOe/PM9hZzynQ9o" +
       "Ydi+7B7x9ejCVa8fmeEE7IRATLi+cLEjTq8WnObed7DbPpzilfyBeQXh6qF9" +
       "Z2wAdiI/9R9f/e2/8c5vgpjCQBdWub+DUHJixEGab87+6uc/+eRbXvvWTxWT" +
       "J5Dr5K/9ncqf5b0GZyHOs2JBbB9BfTyHyhdrT1aOk34x3+lagfbMUMpFtgeW" +
       "BavDnQfyyrVvOp/5g1/Z7SpOx81TxPrHX/vr3zv4xGvnT+zl3nnTdupkm91+" +
       "rmD6wUMJR9CzZ41StCB//4uv/NrnXvnYjqtrN+5MOmDj/Sv/8v/+9sGnvvVb" +
       "t1gY3+sGd6DY5OpPdqsx3Tz6sRPZmK7VbDw1htsVbEfIFpl2fHWcEVxkLki6" +
       "F9BSc25t7RpDzlU6EZnhMMUbWoXSsRWLhRlOyDxJtEazJW87tDwah91GyWZG" +
       "lGkRQdCSRYKdNgOGaoqdYCy2po5l0ktRnMgkb+FKWaloHrLSlkNBdmJsFsMN" +
       "HJbxQRmHsUY5Fiq1FuM6ngy2KTbW1VrRxObGUeSUNiwTJZON0iuPEthEugSJ" +
       "9xFlW4brrLNcthxrMY3o8iZkSHQTisIkaIedypglpLAfiWVRCjuLRV2YJiPV" +
       "lWxbXg8cz2NRycwmznhaFkWcZwam5418nl6QXs8ZSGM/SZrzTYkRCWE4UJ1V" +
       "EiAVRjRxhUmxrsJIlYhOt6UFz7hZDaPnsojFjiO7OjMP5cXGmvbWkVRjXGuJ" +
       "pcLSqdt4R7VhlI8wUovbtUyQOuwwrKXpaoGas9FWa3REXhuUsri8TdwWOylp" +
       "Yd+h5MqgqrtTOR42TI4Xp4TAzUd9vCephDxY18eZN+AzdCkS2DgN3Bgt1fG1" +
       "WnPsZd8bizbTIS2R7m+k0SYJTThaDOglRZUxaS1FTNlIUGk+nQr2qLGyrawO" +
       "rwxPIhK6NGICMRojE0fsMK2w3zc7g1AKbBlNQ8ex512ejikbRzlBnPCuUCnz" +
       "kSbzzlKYtuRppdJhNW8+kFd0bTZBWsOASSRX8kDTilIzuy5XmYUUOeEDKimh" +
       "qGLNJ1E8bvQjctDszwZzM7K3Uz7skkSF2bTXyBjHqK2JNpu97YRSI17360ve" +
       "KRPthF6OHH6SkHyjW2I4ft0NmVaJKFFjR1u2RjgrWht+wNtmzR6D/RIcj0bi" +
       "YLIZb5osjXMNiVzz0YCJK5uwhqY6K2gqovb0shCkPDG01ZDt9WCnQYX+3Chl" +
       "87rQKfXgUnON2vigy8jeamvqzIinQ8SjW2p5hWHhuoSw5VK90fMWjiu35xwm" +
       "0xuqxnPt7RQeKhq2mYmTZUceBJO4x/r1Vm22meGas5gJTrtDSfWZTQ+zcNsq" +
       "oQmMVIeYXyeMsehqbN3jNWGqmIK1dIxpP5AX4oqeLFFmNBcMmZ8uAzdF3Cqg" +
       "o/Aqb4sahemzxTxYbmaT3rKxLEW+UR2yltPppEtzWLEmybRr6O2558Kz1ZCm" +
       "x+K6NEwtWW/bLQT2alRLJyOuxJoOX1vadaMDiyUDiwTT3Frt6sAqGebSNOxJ" +
       "UkeD0WgxTLyeXWt1e3zISU1ZGlsUbC4SoZQ27XGPQ7MF5bUpq+QPgnKNz/im" +
       "oHKJjtQnszkLJ6WB6A9GhjvSnApnySo1y9SWJa2auBks7HKX8Bhzndl6fz3n" +
       "s6rpMkyf9b15INj1KWmNvRY7qs6nGOwgmIIOGyrWswlvwZK9BrHkNUsAvl6d" +
       "tbItsJAxlwhKPDXalh3qi7DNtKb2VJJ4cSI2tGV/PTUZGpnDmAQTbG/krbee" +
       "XqNb0oIU3LLDx4QZ9DSLl1fjsezRCI328U6YiZYUb7rhOuDTkBOshpSWDWVR" +
       "r/cdz7SQdCg6a6LusCVOFFJuG1ZgY4L3lISDG5nGdbV6lK6tkUMSKkcuOrYg" +
       "lWCCa2G1WkvX3UZd8VskopXVyJg1HXo7pUadVUVBuk2xWYKnzYEW8s31nKuX" +
       "JUr0u3Rj1tH42qruDVbtEcaTqxJMxozdH9arA99aJaxqIVXYKjXxWAIelG39" +
       "bNqgxusRhmR1BhkaqwDHvKqvbMe1jl9FpElJjzqMFY03k2myWVemIU/4I6M7" +
       "9LG6ODCwATKcZ/OADGU5bnGKEjeDaYdZNyrlVWXV1cdZQ+cyDa3WslYcV4cj" +
       "tSxsspRB5FGadew5JjCzbqNZJ8fNVlBXthOzYouZOw0JalKNlXro+WM7VWGj" +
       "3pIyutPjxOqcVYAnshqCWuEGh9MKUk81u+rTHpVoPuY6zZjwU4aZeXW5RCEz" +
       "umIMpuUGrjvjOjlpttfyxsV6HUO02cpMlD1p0R5vBM/pN5rDsVlH3MFsu+aT" +
       "mr6YYSZL89xsbgzoOMWY9bLiy5pIhSPO59LNXEtnLFoxx5YwnSbVUZkwpRnP" +
       "LmPWiVsw48NtMvKnvGvq2LJUS8qDXuqv1jLT3LTGrdUGHYRp02M9wmSpkEFn" +
       "CKxu2VJFh6ciZcslT1s6KyYZs4ZeH03NsCbLo7bid7sLYcoOsvLSlHXZc2x2" +
       "YW8joL5BLypbXOa1Gm1j3uBgTqpnDQS3OxzncLTX52q9rIsQDWI6gbep4SM2" +
       "Nl0ZurFtrct9u7ZpMK2FY1QaW0Qh5S6+qqCVkpjWkNY0sLCsMUI6wra6SSur" +
       "iVTbGtnYd7B4Palttk05NCpLW93MSiK29KszRhPbIemVe/A4ccKIrAhxcyJ3" +
       "XbePjsZjvU+iUjUIt+Em5YJZG6F0WUHpGpjd4Y62NCh8PdKWC8XuxDApKUOk" +
       "ks1qIztrw3FAbdmhkojeJlXbhIMuWmjLjfiwiVOUw3b6i8W4KmBtDp33Kn2h" +
       "DOOmYzFrpRmDsIq28ZbRjBNYk7rLNgwCMQzk30tGW1taCno1mXTiBU6XJyt2" +
       "0p2nHLGK65N5p8fG+GTgmIrT2gbyui2LJeDlJOzDc2wD1hNBmXc5w+g1+2Dq" +
       "kIKuKvbXFGmH5LSfsXCroSf90WrGpUh/tWkA9+qlvchXSrXtfLow2rW5yC7L" +
       "OMlP7H4tGY1UywhMbJUio1gXvAyd03UqSDhyW1oP/NpGwGG4pMQbEtd7aFdB" +
       "F6yWdnpugAqoPNCbYiY3a6IEj31+XKtylJnBSIlxAcu1se1XErDuxBo6Xpv3" +
       "BX7ObdElwvZWEcJVomC5UoZ92O/p2xoKOwqi6lwPnW7qQrsEZu2J1ZwnZCsN" +
       "iXCZNel6ad1jKngirzsqa2/ihqS04kZn6I4q8Kirt0tjzYXVILQHk5kwWKAt" +
       "pF5zSik+rAtymTYG/rg5Uam56OFObzuf4GHYa/V8VuTcVRcHsXfAsTTMayTN" +
       "BYJfhecLC64j2GrerGodkY4UO5iQ5FrSuz65WI/BEmCFVdt+1W5w61kXGxFD" +
       "pFkJgWiA/htcBU+zIGoyzRWBDhkh4irKUikjQ4WsGLhQJtwx58rDuuODuUWu" +
       "sfNJWGXmfa0yUlbdRrxSiHS4nVN+BcXmyIpZ0IGJSn2Hs6prba1LLYLWxc66" +
       "2liQa6TLrJscQuCq4DSG5WyhhcLK2rSnVbZsqT0PIbpdao6b6rw+onBnDs/g" +
       "rGIY3S1htEiiig1MRy+3JZbFS+JIrtqhUNX73JwbRI3moDdvKORAHTAbdcm0" +
       "lJaDkclGAv3b7WnJ7lrhUA3hMWuRbn9TCsJ4NhO3PrwlOy0957MW4tHaUoGT" +
       "ZKLXwEy6IfWjyhZvRQRZXlmdjWbJyqTeptS412FcXZn0Wd2Vq9tZWGpKjW0z" +
       "5mfrCqUpGonUtiYYVehWVxKR4Vin1tr6jKbOZU6OXVqy1RGTTtrYSESFYcbO" +
       "2iNzPpR4r9TDlmiFiVuKWGnF3GINVtF9zh3CCT1Q1hFYnZeGNNw1MlupY1ta" +
       "wRpdJuWoqTsadHCVnNTduT2T/ay88XqIk/bCVbjd6mVDZ5Yd3HOnzZE2GAyz" +
       "LrzBNFRTEIKPTSkqd9dWre4agSajvVIYe1hHIst1BEUGMLfhJiNsmYqOEzWC" +
       "MRNaypLuySAOa4PVtjKaRp2pnSa6GHITt51ukrYmTanWdIqDDQfKpmAVr1c1" +
       "keY3DEU7qQZnTZ0P8T7ZjCza8ILuCO9u1rAL8JkmbXVG8XwZc31lDLzI7FFy" +
       "Nh1arWYNH6KdqtWewYSWeh14itFVE82GAuW0qb7dMRMaHeKYT4yIlgNv2NgR" +
       "F9p4Tg/9qqclaa2aVDaTVtSn3IpsqPjCsQzPb0uLaFGp+Lho9Nx6jZY6qC/7" +
       "bDcZAoHzwMJNtLxxwgTX5xbbGFaT2G2JYA3J9hS9b8/GQ4mdYOhCCRTOgwmK" +
       "HvSFmQMv0A0rSDPbi2YrKdlWlLaNwBTVJUdUNmkIDaWGSQmF9OYWV0cYIauF" +
       "S8naYPgEhZEaiyBkiStPg+qyHukU6nN6bWKVPDIr9ZwZjvWpAcJQI3rMoyjR" +
       "n3TATtLRpoQaoM3eBOaX1haeNlazUWOh8VWNRmd2Jqab9nLUJhSsTDm1Qamf" +
       "Rc1owy8CJ6pLWRPfunq7wnZ8fx5mIO6vGDhpNHttsLamncpwW3XxTiudCBku" +
       "rdIVR2xioyNtB5JrKPGI9wRaG/bYilVegmmyi9juUOktUbtSS1fdsOzMhohI" +
       "seLAHFQWnq4v50qy5FsykApeqjD1OEOmfrSCOXGFTKlGfVkK7Ona74y8IaOl" +
       "LAvj23EydxQtFrLxjBzEvtPF0rprbbXVNKo12oheq+Fdu2c1a6YitBuR342Q" +
       "BJv3twtM6250MJE6/thZCN3VJlJXZNom/JnYpZub7TBizHlgjqWuaPo9t6MO" +
       "+LXf0KqzegY24COsMQU7oqxEAl8mu/Aycjm0P402Aj2xgyEhYZxMu0ZXW5XF" +
       "wbphmLhvL5MlvKZ0ze8Gi+5aHVPrCpE6xBLpGwt4RZq9EYFsqAHWmiHdJFk1" +
       "WtvFjLCEtddsNt+fH0d8+M2dCD1cHH4dX6QvXCyvcN7ESciu6tk8e9fxyWHx" +
       "uwidunw9eY+zP8U/vgN59taXkyeuJfNzoCdvd5NenAF99iOvva4NfwE9f3hP" +
       "8qEEuj8Jwr/g6ivdPTHog6CnF25/3tUvHhLsz++/+pH//LjwI9bLb+Ky8ulT" +
       "fJ7u8pf6n/8t6ofVnz4P3XN8mn/TE4cbG7144xn+5UhP0sgXbjjJf/LGC0MY" +
       "pN6hDnqnT2/3Wr710e17dlZy6hrq3J5gWhB86ox7qk/n2c8AJcR6wu+PqVcn" +
       "rGqbQPeuAlvbm9tr3+/g7eQoRcGrx6iv5YU/BBJ/iJq/O6hPgvrFM+p+Kc/+" +
       "FgBsHgEuBLUH97fvAFyh0veA9MFDcB+86yp9uSD4e2cg/HKefSGB7gMqPT67" +
       "/8we4BfvAGARO94BknoIUL372vvHZ9R9Jc/+IcBmnsD28h7br92p8t4FkneI" +
       "zburyjuKoo8cX6xQkRxathqX20W7r52B+5/l2W8c3dGcUuhX71ShTxeku192" +
       "9xX6u2fU/ds8+0YCPXSkUF1rRrqcl5b2CP/FHSB8NC98HqSPHiL86N1H+J/O" +
       "qPv9PPtWAl3bI2wFqa8BtR+ZxDuOTcLUA+9grKtgOjFd/ZCiEMG/vwMRPJIX" +
       "PgPSq4ciePXPxbLfdiMMLgBgD237v58hoD/Ns/+aQA/a/gkLuNU0dEkJAleX" +
       "/b1U/tudmn5+/fzpQ6l8+q4bxrl7z6i7mBd+L4Gu5jOR7sfFZdnNxn8OulPj" +
       "z9cYnzvE+Lm7j/HqGXXX8uwtCfTWkxiPzD9v8Id7nA/cqYXna9gvHeL80l21" +
       "8Pzf/1EAeuIMsE/l2aNJ8Yb3tD7/1x7nY3djjvrKIc6v3HWcpQLLe87A+UKe" +
       "vXO3wDh+bbGfj85dvxsLjK8fAvz63TfY6hl19TxDdguM/UuSPbbSm8GWgah/" +
       "89vN/CHaYzc9Ct89ZFa/8PqV+x59XfxXxfPF48fG97PQfUbquicfCJ34vhhG" +
       "urHbMt6/ey4UFmDeDxzvVnu2BLoH5Dm7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5963o/wACEOnKcFqo/h7ko5IoMt7ugS6uPs4SQI2rfcAkvyTCo+mhhMvJnYv" +
       "pLLdrPHYSSsoIvq17yfg4yYn3zXmG8TiOf7RZi7dPch/Sf3i68zgQ9+p/8Lu" +
       "XaXqyttt3st9LHRp98Sz6DTfED57296O+rrYff67D/3q/e862rw+tGN4b5En" +
       "eHv61o8YO16YFM8Ot//g0S+97xdf/73iycj/Bypc3XgnMQAA");
}
