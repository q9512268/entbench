package org.sunflow.core.camera;
public class PinholeLens implements org.sunflow.core.CameraLens {
    private float au;
    private float av;
    private float aspect;
    private float fov;
    public PinholeLens() { super();
                           fov = 90;
                           aspect = 1;
                           update(); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        fov =
          pl.
            getFloat(
              "fov",
              fov);
        aspect =
          pl.
            getFloat(
              "aspect",
              aspect);
        update(
          );
        return true;
    }
    private void update() { au = (float) java.lang.Math.tan(java.lang.Math.
                                                              toRadians(
                                                                fov *
                                                                  0.5F));
                            av = au / aspect; }
    public org.sunflow.core.Ray getRay(float x, float y, int imageWidth,
                                       int imageHeight,
                                       double lensX,
                                       double lensY,
                                       double time) { float du = -au +
                                                        2.0F *
                                                        au *
                                                        x /
                                                        (imageWidth -
                                                           1.0F);
                                                      float dv = -av +
                                                        2.0F *
                                                        av *
                                                        y /
                                                        (imageHeight -
                                                           1.0F);
                                                      return new org.sunflow.core.Ray(
                                                        0,
                                                        0,
                                                        0,
                                                        du,
                                                        dv,
                                                        -1);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6eewjV3ne3ya72U3IbjYngdwLJTH9zdgee+yGAuOxPbbH" +
       "c9jjGdvTls3cHnvuwzM2TQtILaioNG0TSlXIPw0qReEQLQIJUVJVLSAQEgj1" +
       "kgqoqlRaikT+KK2atvTN+Hftb48QUSzNmzfvfe973/2Oz89/v3BjGBSKnmut" +
       "DcuNdrU02l1Y1d1o7Wnhbn9QZaUg1FTcksJwDNouKQ9/8twPX3pqfn6ncEos" +
       "3C45jhtJkek64UgLXWulqYPCucPWtqXZYVQ4P1hIKwmKI9OCBmYYPT4o3Hxk" +
       "aFS4ONgnAQIkQIAEKCcBwg6hwKBXaU5s49kIyYlCv/ArhRODwilPyciLCg9d" +
       "jsSTAsneQ8PmHAAMN2XfAmAqH5wGhQcPeN/yfAXDzxShp3/vbec/dbJwTiyc" +
       "Mx0uI0cBRERgErFwi63ZshaEmKpqqli4zdE0ldMCU7LMTU63WLgQmoYjRXGg" +
       "HQgpa4w9LcjnPJTcLUrGWxArkRscsKebmqXuf92oW5IBeL3rkNcth52sHTB4" +
       "1gSEBbqkaPtDbliajhoVHjg+4oDHiyQAAENP21o0dw+musGRQEPhwlZ3luQY" +
       "EBcFpmMA0BvdGMwSFe69JtJM1p6kLCVDuxQV7jkOx267ANSZXBDZkKhw53Gw" +
       "HBPQ0r3HtHREP9+n3/S+tztdZyenWdUUK6P/JjDo/mODRpquBZqjaNuBtzw2" +
       "eL901+ffs1MoAOA7jwFvYT7zyy++9Y33v/ClLcxrrgLDyAtNiS4pz8m3fv21" +
       "+KONkxkZN3luaGbKv4zz3PzZvZ7HUw943l0HGLPO3f3OF0Z/NXvHR7Xv7RTO" +
       "9gqnFNeKbWBHtymu7ZmWFhCaowVSpKm9whnNUfG8v1c4DeoD09G2rYyuh1rU" +
       "K9xg5U2n3PwbiEgHKDIRnQZ109Hd/bonRfO8nnqFQuE0eAq74LmpsP3l76jw" +
       "Nmju2hokKZJjOi7EBm7Gf6ZQR5WgSAtBXQW9nguFsaNbbgKFgQK5gXHwrbiB" +
       "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" +
       "bDaa4rTN98qsTZKMPYi8TkuiE1+KIyAXp4tosJbCizracbUqWZ3J7dZyPFpH" +
       "aadFbMxoQFNOvy4KvrlcxGuFkEbqUhQmXH/pIK4tuxHDoqQDDYe2T8BiyVzI" +
       "7YXJNnvcPKSMhOxryyUllWLA/ZoigmFCz1tph0v8ZVKz7BpsNds0n64otOZ3" +
       "WqpLULqtOT6KLUxclviIp1HW9OR5i9EhkjddDRMsme3YnfmgFHYxLhTipiEa" +
       "fquyWYaeHgpjSXQ1EVuQZbZbRTBsgq+4eQ/1y1KJpIdJy+8QiNnzS0vNGMZ9" +
       "pIz5I4tZmAYndAKYn4iBAYeooiz6VLtOLbFpp0RjgsILiWC4klHj6uIU43y4" +
       "SUJOqFSEJEGJ1sSrT0ZmGwnhZGmJZajpLSRsmaBcz581mT5G0VK8ECvtgagx" +
       "83kbR+IZFkqtKiJqq4rMxLImWkOZWWJUpVxtISY8G8H9hQM1JL7hTDUhJGie" +
       "CHyLYliHo2qLAYNSKsFTw745QXteSMV94HQpUuPj7sZrs4lv1rpVYRDbvpPM" +
       "6lK/VYpI3E2jlKTtvsHFo4bQ5isxorMNHxvUKJ5fzJwRStr8qOw2SGFc5YMV" +
       "C7lkjx9QHV7ASo0Rv/LkCMLU/rhCJSLuY2SRxAY6Zw6LUF8zWbUzYvmyOaFI" +
       "yY2dUUwuN0XRatIjq0vKhDGoM6HLK9EEjr2is+Apf+LKbnUJwXGNk3oc09f6" +
       "bqXTIRqCgLlNaySaOiFCtdZ8ac8aNEJiY3+aupQ+n5resjEVJz3bIyy0XhWD" +
       "Tkqu8FA1E63pzmt9Iew47TK3wWk37m04srgBGFNWnSWtmVA1pgu0pyTN6jpC" +
       "R2ltRq80twhbSEcnNNxyLY8oV4uc3DXqgynWZLkuJDeCVUkX6MoqtYjZDB/0" +
       "maHcgsRpkcD1KheNLcSg/A5FQRbcWzRnXajXd4YtxknnkNTQWjSEpcUuoQws" +
       "o92m9BkybEBhZ15pFvEyLEflEZk2VLZlW1qVUJbpQtH7cnc9xE12sui7LNaX" +
       "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" +
       "V6XqtKIKNR2CN4K0UB3aNVpaQpRSRrXsOlZqTeR1KWxG5WLQmwaBzsjsfC7W" +
       "1cG0DhaCjUpiXFlSfVWHoD7RkpYIXU4h1uXqpgU144UPMWg7dSbeCqpJ0w0+" +
       "8tvatOOrLNfh9W41UqQZb86EsbCo+0YXx0R9QaAqPJCH0jClaupswEN+5IkN" +
       "UoRYvclsvAoRd3hNrKPkAm0RpLuS6/GiAhnDalyJ2XaFSifVzRJeEmDnALVY" +
       "xa9ogzXelEZOfdBsyxS2qSQBCaIhnGjMurEudec6YkzN8hjs4jAsOx4++cqO" +
       "rbflJ/SDJCU4rWYd9is4mW67HsqK1x1cZeS/U4Vjia2j9+OHl6Yn9m8DXnNF" +
       "wgfPEz5Zoie74brvWvnJ/HbruXc9/azKfLi0s3chPYgKZyLX+1lLW2nWkelO" +
       "AkyPXfsmj8rTs4cXpV9817/eO37z/IlXkP554Bidx1H+MfX8l4nXK7+zUzh5" +
       "cG16ReL48kGPX35ZejbQojhwxpddmd53IP3b9y/bLuxJ/8Lxi6RD/V79FukN" +
       "W/s4dt+/kwPs7Ovr/iv0lctBi7QgSyjsg911FIzbvjG2l8/wzHUyCn+QFU9F" +
       "hVOxp0qRdrVblNOy61qa5Bxa6m+/3B3K0Vnyht+88o7y3j2x3ftKxYZfVWxH" +
       "mfrIdfo+mhV/eF2Gb1i5pnrI7XM/AbfnssY7wfPAHrcP/P8YyeltJuTg6rF/" +
       "NT5Omk5+W/rZq3WeUt1Y3qbPP5cX+TyfuY7kvpAVnwIjDS0aSet9y7vjCgPd" +
       "78yl9yevRHppVLj5SOI5y6Ldc8W/Wrb/xFA+/uy5m+5+lv+bPPd68G+JM4PC" +
       "TXpsWUeTHkfqpzxwpDNzds5sUyBe/vpSVLj7GplwwPC2klP7xS38V6LC+ePw" +
       "wHCy11GwrwF+joABX9qrHQX6OtAUAMqq3/Cucmm7Tf6kJ46E1z07ywV84eUE" +
       "fDDkaG42C8n534r2w2e8/WPRJeUTz/bpt79Y+/A2Nww2dJtNhuWmQeH0Nk19" +
       "EIIfuia2fVynuo++dOsnz7xuf7m4dUvwoc0foe2Bqydi27YX5anTzWfv/tM3" +
       "/dGz38rvkP8PXsOEYO8lAAA=");
}
