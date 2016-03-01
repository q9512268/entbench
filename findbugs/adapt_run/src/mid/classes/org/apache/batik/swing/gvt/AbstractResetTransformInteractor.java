package org.apache.batik.swing.gvt;
public abstract class AbstractResetTransformInteractor implements org.apache.batik.swing.gvt.Interactor {
    protected boolean finished = true;
    public boolean endInteraction() { return finished; }
    public void keyTyped(java.awt.event.KeyEvent e) { resetTransform(e); }
    public void keyPressed(java.awt.event.KeyEvent e) { resetTransform(e);
    }
    public void keyReleased(java.awt.event.KeyEvent e) { resetTransform(e);
    }
    public void mouseClicked(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mousePressed(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseReleased(java.awt.event.MouseEvent e) { resetTransform(
                                                               e); }
    public void mouseEntered(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseExited(java.awt.event.MouseEvent e) { resetTransform(
                                                             e); }
    public void mouseDragged(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseMoved(java.awt.event.MouseEvent e) { resetTransform(
                                                            e); }
    protected void resetTransform(java.awt.event.InputEvent e) { org.apache.batik.swing.gvt.JGVTComponent c =
                                                                   (org.apache.batik.swing.gvt.JGVTComponent)
                                                                     e.
                                                                     getSource(
                                                                       );
                                                                 c.
                                                                   resetRenderingTransform(
                                                                     );
                                                                 finished =
                                                                   true;
    }
    public AbstractResetTransformInteractor() { super(
                                                  );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZDWwUxxWeO/9i/IcBQ0jCjzE0/N2VhiSqLk0DBmLjM7g2" +
       "ocKkOeb25s6L93aX3Tn7TKAJRAkoUlEEJCVpQJUK/aEEojZRo1QhVE3zI5JS" +
       "aNSQ0JK2VEqaHxWkFtKSNn1vdvf2bu/HsmqplnZuvfvezPvee/O9mdmjn5AK" +
       "0yAtOlVjNMCHdWYGuvG+mxomi7Up1DTXwtOI9Mif9t5/9bfjtvtJZR+p76dm" +
       "l0RNtlJmSszsIzfKqsmpKjFzNWMx1Og2mMmMQcplTe0jk2WzI6krsiTzLi3G" +
       "UGAdNcJkAuXckKMpzjrsDjiZERbWBIU1waVegVCY1EqaPuwqTMtRaMt6h7JJ" +
       "dzyTk8bwJjpIgykuK8GwbPJQ2iALdE0ZTigaD7A0D2xSbrEdsSp8S54bWp5p" +
       "uHLt0f5G4YaJVFU1LiCaPczUlEEWC5MG9+kKhSXNzeSbpCxMxmcJc9IadgYN" +
       "wqBBGNTB60qB9XVMTSXbNAGHOz1V6hIaxMms3E50atCk3U23sBl6qOY2dqEM" +
       "aGdm0Drh9kB8bEFw37fvbfxJGWnoIw2y2ovmSGAEh0H6wKEsGWWGuTQWY7E+" +
       "MkGFgPcyQ6aKvMWOdpMpJ1TKU5ACjlvwYUpnhhjT9RVEErAZKYlrRgZeXCSV" +
       "/V9FXKEJwNrsYrUQrsTnALBGBsOMOIXcs1XKB2Q1JvIoVyODsbUTBEC1Ksl4" +
       "v5YZqlyl8IA0WSmiUDUR7IXkUxMgWqFBChoi14p0ir7WqTRAEyzCyVSvXLf1" +
       "CqTGCUegCieTvWKiJ4jSNE+UsuLzyerbd9+ntqt+4gObY0xS0P7xoDTdo9TD" +
       "4sxgMA8sxdr54cdp84u7/ISA8GSPsCXzs62X71w4/eRrlsz1BWTWRDcxiUek" +
       "Q9H6Mze0zftyGZpRrWumjMHPQS5mWbf9JpTWgWmaMz3iy4Dz8mTPK+sfOMI+" +
       "8pOaDlIpaUoqCXk0QdKSuqww4y6mMoNyFusg45gaaxPvO0gV3IdllVlP18Tj" +
       "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" +
       "P1YiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iDa9YgPNiz6xLI6QolczyqveBJFXDVpsyWa+7s6ryxo2azTXxYoaztSo2xpb" +
       "dmeNxIgdmmwLb8zz7fKabHit8bgVcIPxpNLI0ctWU+tL8aAskiE97skO7XQL" +
       "HDlCcWJhhOvJyLHm8wVXHfKNhotPyYnhDrWpIhAsD/PVpkA2umvG9SbuaOB6" +
       "nIVTtVbN69G9jiB5BYGsIYNCN+zYfNyre7MRV2sQBdIzSiE6ma6M2MA6eH7M" +
       "mvqoPhpWOsJyFNHaeNWsEXNbL5ScvO5WxituiDfihIh5NhQotUCsuBYxUjRC" +
       "V7hwTOrd0oJlGrmRF1BJrLgzuZqz/JWfK2m92SQfsfl+JbLrnGxXuXrJizQa" +
       "x7xIdtGSJDtYKajAHRbHWmzfI4TEKyNCpbAuwcrQNbykUBtz42FdivSRshxU" +
       "22U6UfKJ6setqTN0x4G5oNv9AYua45la7TrcWBubIp0U9bhUTzCT65M5T+3R" +
       "nRzm9MS60XHEkb0ihGV+IJNssFqvS3HZpG0mbgaeVkI1UYz6YS+v8cWObBi8" +
       "0S9g3KIb0LLTXA8XsQ1ecyUSR2W7469KTXRcQp3ELfQVKlfhenpr2WBL7Nz0" +
       "TE+tNKhYnmlwQVxqY2fY5KeFCSXP7VmJFglCQrVuNWmWVkhYI3scvCappiYH" +
       "hONM4g7RqptOozPydFI1xWq969SXDbgWEXifsgtEyeh118hQU8lCjed6QUta" +
       "9riWCPy9hY/FBWxhct8uYmY9NLAGZc9Cmp2vu5FbQAcTOqbY0Gfj5lTpD0fo" +
       "lJ0suVideN24se6YOPBRYD+dwRDncJ3udoZRT+Im+SoxKccjbYL38fYIl6tq" +
       "rwwXWysbqYw9W+Ph8VyytbHuVZgVwvuUJ5XmbENvc0VOgoW8mfBtmB70mRrb" +
       "HAeTscGIkmZS/CDf48b4euLyc0dStMKYiidNiq1bzBr220UZ5rGRbHIC0YvX" +
       "eKAxhVkwRDim7rdXqM0TcJ3zYODzGDZGxDjqoENJcQzBFNl6yS8u55U1sJkc" +
       "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" +
       "OcIHrib7OJ7raVQ+aRZ9mZCFYVOie/wIjrh6O79UyB42FRZrJFgbi2m8CPLV" +
       "JDS8Ko12paSbOA2MUHANYRRs5oSCzHEO4pHNcuy1KsVo1s47Rjip8PPRvNAn" +
       "Ry7SGhXHqsgHHqV57WbBtWQdWFUz7BMqp4NJt8ea9abdLol6girLskhgfjLS" +
       "mzmvPLIkhrKNwQTFpp7PrJdsvissHIYsx0NxirsiTjBorzAtlhjbLZW85nhd" +
       "dyesEcxDMPEHtcCOWbpJrnqsOiR644IVRbI1lVeiN8NKw7K6qPFiGAbFxJ0o" +
       "niYYYCy9OIlhbb2akb1cfgyceSzzs0HRKcNk1bKEsoNNGUydhoGMEbSOcMqg" +
       "71BSienCZm+a7rjodqGHSUFYbJhgy5vAq+5s3Y9Go5I58zQYXyYuKc+F2VoT" +
       "eva4tpjlSwwO8wITlXI+U1RHRd3p8hM0mXEsYjQcKg+8X23LaqHbjyxhwDpL" +
       "RpqxJSuKc7O6uC4Pa52cPHAScuXIHB3ljHK65hTKveYUidsFc6yUFpLIGW6c" +
       "VBZxWAh5krEHNDqdV6pzxhoriVWlChVKJbwoWI+nLFJe+tMuExtlWLT03GqA" +
       "UXFQWicIJdXgSrgMrU4s9QsTHey4X5duxbXndkRwY3YasvtRcmFU0orxczgF" +
       "iC4/4PHtU5jT4vbnlWj3hC37nT3i9H7fCeexnWOZ+4/4grP3rSY9wbrjSp8t" +
       "s9OrD7zliSfl3gcLx7fPkUkfusa3ndcYSqgY+wa+DvT04JVP6ujsq+3e+eZn" +
       "3vLt27kfnz/8HL7g3HWIz8Nd/jb91Odar5B+5Th01e5p5yXfkw82unDwjPOM" +
       "q/iBa3EHTjrv2NXDzanY7wHPg9t6ePDyX1Euf8yZ6XdjRkcc07/5iLq3pskj" +
       "PnSDYsk7Ktz+2tLZs71Hn+0Ean+3WUG8i/DatPA8eErbCEsvDMJjB21z841A" +
       "XAM7CRXL3yKVuJFmsra/eIQEfjlNHgNOslTiVEvyZY/lQluX9+Tx889XHunZ" +
       "9oVteVx4QeWRvj6eETx5BOhfT5P3+tAZALrvKp6nyGnJO/cg/trzhfhK8NS2" +
       "IdZeJIgfOgLiU2nyQR+6FkAcKoYiXorxN54vxtRZyW2M5Iti1i87ZNa0HXjK" +
       "nmH/3hEC+IM0+R0fus5M2xCGLi0vkcDHXwgJDLclMHzBtfzJjODPjgD56TT5" +
       "4x2Qlzflp58vyBx4JtsgJy8SyL88AuSX0uTzPnR9BvIKxvyFF0KVD2+jfPhF" +
       "Qvm3R6D8Wpp8ZUeVjXQyugTkV58vyAfAo22D1F4kkN86AuS30+QfQFTagIx0" +
       "/xKM33whFOlvY/RfJIz/egTG76fJv+wosu6KmnYJyO89X5CvAs8j2yAfeXFA" +
       "HoOuDPJYtrb+AZhBM5C0HV4C8YfPA2L2ATytf+s2xLc+V4j1/8vs0rGcwN+d" +
       "XY5ddwT+c2lyCiwc3QNXtg7K4Njp5yKDyIfufraLYOlNltsuubm6uW0pfeTJ" +
       "s6dvfXL0lewu1O6NyGso6LQaGMb+iwf78icdV1H1TFrXbK4hOBnAW33o9ivv" +
       "d3zoKpCmEI7dsqG/3YduuTy9D53I/vdT3+FD5w5TA7rsfz/d3cDC9uh86OQm" +
       "s5/kPsALIEmz550dze77nr25rRFtlH7bfnvLzPSmZ1PRbpP9F6vSzVh2z3hn" +
       "4xRsbhpflD76ZJd54zPlD24udkmGmCRpL6cp6NTmjlnWabr5uueKve30dbL9" +
       "wA9u+Ng19+9sFG/YMLxn+/t4u+vyN6capuNnd52S37/1d1/7m09+Lfug/z8K" +
       "FLVBAC4AAA==");
}
