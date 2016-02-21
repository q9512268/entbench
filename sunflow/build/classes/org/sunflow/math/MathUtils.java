package org.sunflow.math;
public final class MathUtils {
    private MathUtils() { super(); }
    public static final int clamp(int x, int min, int max) { if (x > max)
                                                                 return max;
                                                             if (x > min)
                                                                 return x;
                                                             return min; }
    public static final float clamp(float x, float min, float max) { if (x >
                                                                           max)
                                                                         return max;
                                                                     if (x >
                                                                           min)
                                                                         return x;
                                                                     return min;
    }
    public static final double clamp(double x, double min, double max) { if (x >
                                                                               max)
                                                                             return max;
                                                                         if (x >
                                                                               min)
                                                                             return x;
                                                                         return min;
    }
    public static final int min(int a, int b, int c) {
        if (a >
              b)
            a =
              b;
        if (a >
              c)
            a =
              c;
        return a;
    }
    public static final float min(float a, float b,
                                  float c) { if (a >
                                                   b)
                                                 a =
                                                   b;
                                             if (a >
                                                   c)
                                                 a =
                                                   c;
                                             return a;
    }
    public static final double min(double a, double b,
                                   double c) { if (a >
                                                     b)
                                                   a =
                                                     b;
                                               if (a >
                                                     c)
                                                   a =
                                                     c;
                                               return a;
    }
    public static final float min(float a, float b,
                                  float c,
                                  float d) { if (a >
                                                   b)
                                                 a =
                                                   b;
                                             if (a >
                                                   c)
                                                 a =
                                                   c;
                                             if (a >
                                                   d)
                                                 a =
                                                   d;
                                             return a;
    }
    public static final int max(int a, int b, int c) {
        if (a <
              b)
            a =
              b;
        if (a <
              c)
            a =
              c;
        return a;
    }
    public static final float max(float a, float b,
                                  float c) { if (a <
                                                   b)
                                                 a =
                                                   b;
                                             if (a <
                                                   c)
                                                 a =
                                                   c;
                                             return a;
    }
    public static final double max(double a, double b,
                                   double c) { if (a <
                                                     b)
                                                   a =
                                                     b;
                                               if (a <
                                                     c)
                                                   a =
                                                     c;
                                               return a;
    }
    public static final float max(float a, float b,
                                  float c,
                                  float d) { if (a <
                                                   b)
                                                 a =
                                                   b;
                                             if (a <
                                                   c)
                                                 a =
                                                   c;
                                             if (a <
                                                   d)
                                                 a =
                                                   d;
                                             return a;
    }
    public static final float smoothStep(float a,
                                         float b,
                                         float x) {
        if (x <=
              a)
            return 0;
        if (x >=
              b)
            return 1;
        float t =
          clamp(
            (x -
               a) /
              (b -
                 a),
            0.0F,
            1.0F);
        return t *
          t *
          (3 -
             2 *
             t);
    }
    public static final float fastPow(float a, float b) {
        float x =
          java.lang.Float.
          floatToRawIntBits(
            a);
        x *=
          1.0F /
            (1 <<
               23);
        x =
          x -
            127;
        float y =
          x -
          (int)
            java.lang.Math.
            floor(
              x);
        b *=
          x +
            (y -
               y *
               y) *
            0.346607F;
        y =
          b -
            (int)
              java.lang.Math.
              floor(
                b);
        y =
          (y -
             y *
             y) *
            0.33971F;
        return java.lang.Float.
          intBitsToFloat(
            (int)
              ((b +
                  127 -
                  y) *
                 (1 <<
                    23)));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZfWwUxxWfu/M3NmcbbD5twBhSE3pHShKUmCYxBsemZzgw" +
       "0GI3HOu9OXthb3fZnbPPpm4hUmNaKQglJKFRQ/sHKGkFIYoS9TMpUaWQKDRq" +
       "EtSURs2HVLX0gzY0aiqFtul7s3u3e3u3F2iuJ+3c7sybN/N+895vvk5dJuWG" +
       "TlqpwkJsQqNGaIPCooJu0Hi3LBjGNsiLiY8EhA92Xdp0m59UDJKZo4LRLwoG" +
       "7ZGoHDcGSYukGExQRGpsojSONaI6Nag+JjBJVQZJk2T0JTVZEiXWr8YpCuwQ" +
       "9AhpEBjTpeEUo32WAkZaItCTMO9JuMtd3BkhtaKqTdjicx3i3Y4SlEzabRmM" +
       "1Ef2CGNCOMUkORyRDNaZ1smNmipPjMgqC9E0C+2Rb7Eg2Bi5JQ+CtqeCH149" +
       "MlrPIZglKIrKuHnGVmqo8hiNR0jQzt0g06Sxj3yVBCJkhkOYkfZIptEwNBqG" +
       "RjPW2lLQ+zqqpJLdKjeHZTRVaCJ2iJEluUo0QReSlpoo7zNoqGKW7bwyWLs4" +
       "a61pZZ6JD90YPvrIrvqnAyQ4SIKSMoDdEaETDBoZBEBpcpjqRlc8TuODpEGB" +
       "wR6guiTI0qQ10o2GNKIILAXDn4EFM1Ma1XmbNlYwjmCbnhKZqmfNS3CHsr7K" +
       "E7IwArY227aaFvZgPhhYI0HH9IQAfmdVKdsrKXFGFrlrZG1s/wIIQNXKJGWj" +
       "arapMkWADNJouogsKCPhAXA9ZQREy1VwQJ2R+Z5KEWtNEPcKIzSGHumSi5pF" +
       "IFXNgcAqjDS5xbgmGKX5rlFyjM/lTWsP71d6FT/xQZ/jVJSx/zOgUqur0laa" +
       "oDqFODAr1q6IPCw0P3fITwgIN7mETZkffOXKXStbz75kyiwoILN5eA8VWUw8" +
       "MTzztYXdHbcFsBtVmmpIOPg5lvMoi1olnWkNGKY5qxELQ5nCs1tf3Hng+/TP" +
       "flLTRypEVU4lwY8aRDWpSTLV76YK1QVG432kmirxbl7eRyrhPSIp1MzdnEgY" +
       "lPWRMplnVaj8GyBKgAqEqAbeJSWhZt41gY3y97RGCKmDhzTCEyDmj/8zsj08" +
       "qiZpWBAFRVLUcFRX0X4cUCUuhBk14D0OpZoaNlJKQlbHw4YuhlV9JPudhIbC" +
       "/ZBsB5uNELqX9v9SnEaLZo37fAD2QneoyxAlvaocp3pMPJpat+HKk7FXTDdC" +
       "17ewACeHNkJWGyFsI5Rtg/h8XPVsbMscQxiBvRDLQKa1HQP3bNx9qA2QS2vj" +
       "ZQAfirblTCrddsBnWDom/n3je6t7p25/w0/8wAnDMKnY3L7Ywe04KemqSONA" +
       "LV4cn+G5sDerF+wDOXts/OCOr63ifXCSNSosB57B6lGk2GwT7e4gLaQ3OH3p" +
       "wzMPT6l2uOawf2bSyquJLNDmHkC38TFxxWLh2dhzU+1+UgbUAnTKBHB/YKpW" +
       "dxs5bNCZYVa0pQoMTqh6UpCxKEOHNWxUV8ftHO5ZDfx9NgxtLYZHEzxlVrzw" +
       "fyxt1jCdY3oi+orLCs7cnx/QHvv1q39czeHOkHzQMTsPUNbpIBZU1sgppMF2" +
       "vW06pSD322PRBx+6PD3E/Q4klhZqsB3TbiAUGEKA+esv7bv4ztsnLvhtX2Wk" +
       "UtMlWK7QdNZKbtSMIlZCc8vtDgEzyRDE6Dbt2xVwSykhCcMyxej4V3DZTc/+" +
       "5XC96Qgy5GT8aOUnK7Dz560jB17Z9c9WrsYn4sxog2aLmXQ7y9bcpevCBPYj" +
       "ffD1lm+dEx4D4gayNKRJyvmPcBAIH7Wbuf1hnq52ld2KSbvh9P7cAHOsYGLi" +
       "kQvv1+14//krvLe5SyDnYPcLWqfpX5gsS4P6OW6G6RWMUZC7+eymL9fLZ6+C" +
       "xkHQKMK8b2zWgdLSOa5hSZdX/uaFnzfvfi1A/D2kRlaFeI/Ao4xUg3tTYxTY" +
       "MK3deZc5uONVkNRzU0me8YjnosIjtSGpMY7t5A/nPLP28eNvc68yvWiBVZ1/" +
       "LOdpByYreb6fwXIuNQyrYgZRICmCbPse/9W6ZySn7+Xo10mL16KBL3hO3Hv0" +
       "eHzzyZvMqb0xdyLeAOvM07/69/nQsXdfLjAjVDNV+6xMx6jsaLMOm8wh936+" +
       "nrLJqea+VbMiLJ3I53XU0urB3Cu8mdvdwLl7/zR/2x2ju6+DtBe5QHKr/F7/" +
       "qZfvXi4+4OdLQpOv85aSuZU6nXBBozqFta+CZmFOHXfstuywLsThWgJPpTWs" +
       "lYWJs6C/BPC1G5zG4Kty/FrvYqs5RVS74jpg6sydpHFzNpAaNmCqlZLAvWPW" +
       "8vFz0d3iofbo70z/mVegginX9ET4/h1v7jnPx6QKBz2LhGPAu/QRx7RSb5rw" +
       "Mfx88PwHH+w6ZpjLsMZuay24OLsY1DR0+o4iu7dcA8JTje/s/fal06YB7sWy" +
       "S5geOvrNj0OHj5rBYO4oluYt6p11zF2FaQ4mQ9i7JcVa4TV6/nBm6idPTE37" +
       "LX7tZSQgWZs9HCNfdiE1Oxdys5/rvxH86ZHGQA/M/32kKqVI+1K0L57rkJVG" +
       "atgxBvYGxHZPq8eINyO+FQAtZgzyhL9+sciUIGESBQKDfWmSO9ogl1uDyRbT" +
       "PW+/No7FjDt5diTr1a1YtBSeoOXVwesOGEy2eQWLl1qPYMHvL1kDjH/3ON4F" +
       "ZHGYZfKGDz8TvJ8pnvBXVgTT/ZgoTkxTNqbqp8Z0ERa1WwBkgCghpl5q/zdM" +
       "K+IqzJHUG9RpnvDX+4qAej8mB5ygTtugHvzUoHJmX5RBN/NfOlC91BYG1Q5g" +
       "O4qPFQHnUUweAPZJSoorhh8sTQzjpHeDZcMNpYXGS603NClXMJ4sAs3jmHzH" +
       "hsYRit8tTSi2wRO2bAiXFhovtd7QTLtC6uki0DyDySkbGkdAnS6d16yxbFhT" +
       "Wmi81LrsLeP6ylxeY7vOz4rg8wImPyroOj8uHeF0WYZ0lRYfL7XXTjjni0Dz" +
       "KiYvIjTmqZWDcM6VznX6LBv6SguNl9prJ5yLRaB5C5M3bGgcXnOhdISzxbJh" +
       "S2mh8VJ77YTz+yLQXMLkXRsaB+G8Vzqv2WnZsLO00HipvU7C+aAIPv/A5HJB" +
       "1/lrafD5DDyiZYhYWny81F5zVPmINzQ+P2Z+xEiNkVRVNjrAqHthfbU0CC0j" +
       "uGU1f6y0CHmpdZntN0+XXODUFQEniEklI5UJAbb+6nguMr6q60cmzUh19uIA" +
       "T8/m5l09mtdl4pPHg1Vzjm9/kx9iZ6+0aiOkKpGSZcdO1rmrrdB0mpA4nLXm" +
       "2SHftPqaGal3X2AwUoZ/2FFfkyk2j5EZDjGGu2T+5hRaCHEEQvjaonEz54J2" +
       "fgiI94Mh8zIs7eNFOSd93J2aPgk0x+Hd0pxzDH6Xm9nsp8zb3Jh45vjGTfuv" +
       "3HrSPDSHTczkJGqZAVt88/yeK8VTriWe2jK6Kno7rs58qnpZ5tyhweyw7Z0L" +
       "HKRyJ+y2NBzC+a4DZaM9e6588cTa539xqOJ1P/ENER/s2mYNOW5STaQ601pK" +
       "Jy1DkfyjjB2Czk+6OzsenbhjZeJvb/EzVGIefSz0lo+J1R8dnlxi+EJ+Ut1H" +
       "yiUlTtODpEYy1k8oW6k4pueci1QMqykle+U7E31NwDtejooFZl02Fy9cGGnL" +
       "P/fJv4SqAdeh+jrUjmrqXGeCKU1zlnJUeeFQ2gznQCzSr2mZA69fctQ1DSPJ" +
       "two/Ev8Fl6jRW6QhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "03KD7DRQ8me3/PFr/+CJr2eHC/4fDD1Q2qgsAAA=");
}
