package org.sunflow.math;
public final class Vector3 {
    private static final float[] COS_THETA = new float[256];
    private static final float[] SIN_THETA = new float[256];
    private static final float[] COS_PHI = new float[256];
    private static final float[] SIN_PHI = new float[256];
    public float x;
    public float y;
    public float z;
    static { for (int i = 0; i < 256; i++) { double angle = i * java.lang.Math.
                                                                  PI / 256.0;
                                             COS_THETA[i] = (float) java.lang.Math.
                                                              cos(
                                                                angle);
                                             SIN_THETA[i] = (float)
                                                              java.lang.Math.
                                                              sin(
                                                                angle);
                                             COS_PHI[i] = (float)
                                                            java.lang.Math.
                                                            cos(
                                                              2 *
                                                                angle);
                                             SIN_PHI[i] = (float)
                                                            java.lang.Math.
                                                            sin(
                                                              2 *
                                                                angle);
             } }
    public Vector3() { super(); }
    public Vector3(float x, float y, float z) { super();
                                                this.x = x;
                                                this.y = y;
                                                this.z = z; }
    public Vector3(org.sunflow.math.Vector3 v) { super();
                                                 x = v.x;
                                                 y = v.y;
                                                 z = v.z; }
    public static final org.sunflow.math.Vector3 decode(short n, org.sunflow.math.Vector3 dest) {
        int t =
          (n &
             65280) >>>
          8;
        int p =
          n &
          255;
        dest.
          x =
          SIN_THETA[t] *
            COS_PHI[p];
        dest.
          y =
          SIN_THETA[t] *
            SIN_PHI[p];
        dest.
          z =
          COS_THETA[t];
        return dest;
    }
    public static final org.sunflow.math.Vector3 decode(short n) {
        return decode(
                 n,
                 new org.sunflow.math.Vector3(
                   ));
    }
    public final short encode() { int theta = (int) (java.lang.Math.
                                                       acos(
                                                         z) *
                                                       (256.0 /
                                                          java.lang.Math.
                                                            PI));
                                  if (theta > 255) theta =
                                                     255;
                                  int phi = (int) (java.lang.Math.
                                                     atan2(
                                                       y,
                                                       x) *
                                                     (128.0 /
                                                        java.lang.Math.
                                                          PI));
                                  if (phi < 0) phi += 256;
                                  else
                                      if (phi >
                                            255)
                                          phi =
                                            255;
                                  return (short) ((theta &
                                                     255) <<
                                                    8 |
                                                    phi &
                                                    255);
    }
    public float get(int i) { switch (i) { case 0: return x;
                                           case 1:
                                               return y;
                                           default:
                                               return z; }
    }
    public final float length() { return (float) java.lang.Math.
                                           sqrt(
                                             x *
                                               x +
                                               y *
                                               y +
                                               z *
                                               z); }
    public final float lengthSquared() { return x * x + y *
                                           y +
                                           z *
                                           z; }
    public final org.sunflow.math.Vector3 negate() { x = -x;
                                                     y = -y;
                                                     z = -z;
                                                     return this;
    }
    public final org.sunflow.math.Vector3 negate(org.sunflow.math.Vector3 dest) {
        dest.
          x =
          -x;
        dest.
          y =
          -y;
        dest.
          z =
          -z;
        return dest;
    }
    public final org.sunflow.math.Vector3 mul(float s) {
        x *=
          s;
        y *=
          s;
        z *=
          s;
        return this;
    }
    public final org.sunflow.math.Vector3 mul(float s,
                                              org.sunflow.math.Vector3 dest) {
        dest.
          x =
          x *
            s;
        dest.
          y =
          y *
            s;
        dest.
          z =
          z *
            s;
        return dest;
    }
    public final org.sunflow.math.Vector3 div(float d) {
        x /=
          d;
        y /=
          d;
        z /=
          d;
        return this;
    }
    public final org.sunflow.math.Vector3 div(float d,
                                              org.sunflow.math.Vector3 dest) {
        dest.
          x =
          x /
            d;
        dest.
          y =
          y /
            d;
        dest.
          z =
          z /
            d;
        return dest;
    }
    public final float normalizeLength() { float n =
                                             (float)
                                               java.lang.Math.
                                               sqrt(
                                                 x *
                                                   x +
                                                   y *
                                                   y +
                                                   z *
                                                   z);
                                           float in =
                                             1.0F /
                                             n;
                                           x *= in;
                                           y *= in;
                                           z *= in;
                                           return n;
    }
    public final org.sunflow.math.Vector3 normalize() {
        float in =
          1.0F /
          (float)
            java.lang.Math.
            sqrt(
              x *
                x +
                y *
                y +
                z *
                z);
        x *=
          in;
        y *=
          in;
        z *=
          in;
        return this;
    }
    public final org.sunflow.math.Vector3 normalize(org.sunflow.math.Vector3 dest) {
        float in =
          1.0F /
          (float)
            java.lang.Math.
            sqrt(
              x *
                x +
                y *
                y +
                z *
                z);
        dest.
          x =
          x *
            in;
        dest.
          y =
          y *
            in;
        dest.
          z =
          z *
            in;
        return dest;
    }
    public final org.sunflow.math.Vector3 set(float x,
                                              float y,
                                              float z) {
        this.
          x =
          x;
        this.
          y =
          y;
        this.
          z =
          z;
        return this;
    }
    public final org.sunflow.math.Vector3 set(org.sunflow.math.Vector3 v) {
        x =
          v.
            x;
        y =
          v.
            y;
        z =
          v.
            z;
        return this;
    }
    public final float dot(float vx, float vy,
                           float vz) { return vx *
                                         x +
                                         vy *
                                         y +
                                         vz *
                                         z;
    }
    public static final float dot(org.sunflow.math.Vector3 v1,
                                  org.sunflow.math.Vector3 v2) {
        return v1.
                 x *
          v2.
            x +
          v1.
            y *
          v2.
            y +
          v1.
            z *
          v2.
            z;
    }
    public static final org.sunflow.math.Vector3 cross(org.sunflow.math.Vector3 v1,
                                                       org.sunflow.math.Vector3 v2,
                                                       org.sunflow.math.Vector3 dest) {
        dest.
          x =
          v1.
            y *
            v2.
              z -
            v1.
              z *
            v2.
              y;
        dest.
          y =
          v1.
            z *
            v2.
              x -
            v1.
              x *
            v2.
              z;
        dest.
          z =
          v1.
            x *
            v2.
              y -
            v1.
              y *
            v2.
              x;
        return dest;
    }
    public static final org.sunflow.math.Vector3 add(org.sunflow.math.Vector3 v1,
                                                     org.sunflow.math.Vector3 v2,
                                                     org.sunflow.math.Vector3 dest) {
        dest.
          x =
          v1.
            x +
            v2.
              x;
        dest.
          y =
          v1.
            y +
            v2.
              y;
        dest.
          z =
          v1.
            z +
            v2.
              z;
        return dest;
    }
    public static final org.sunflow.math.Vector3 sub(org.sunflow.math.Vector3 v1,
                                                     org.sunflow.math.Vector3 v2,
                                                     org.sunflow.math.Vector3 dest) {
        dest.
          x =
          v1.
            x -
            v2.
              x;
        dest.
          y =
          v1.
            y -
            v2.
              y;
        dest.
          z =
          v1.
            z -
            v2.
              z;
        return dest;
    }
    public final java.lang.String toString() {
        return java.lang.String.
          format(
            "(%.2f, %.2f, %.2f)",
            x,
            y,
            z);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CdDkWH1ff7M7szvLLrO7wO6yZndhDwy0M+pD6oPl6lZ3" +
       "62ipJbWkbrWSMOjsllpX62hJvVkb8AE+CuN4sUmw1xUX4IQs4CMuk0psSLkc" +
       "4+ByCpfLOAfGdlLBDqECcQWSkJhI6v6O6Zn5YJgZvir9W3rn//f+x/s/6b3v" +
       "hS+XzgZ+qey5Vjq33PCiloQXTQu6GKaeFlzECYiW/EBTYUsKAi5Lu6Q8/ssX" +
       "vvaN9y7uPVM6J5ZeIjmOG0qh4TrBWAtca62pROnCcWrf0uwgLN1LmNJaAqLQ" +
       "sADCCMKnidKLTlQNS08ShywAGQtAxgJQsAB0jktlle7RnMiG8xqSEwar0veX" +
       "DojSOU/J2QtLr7q8EU/yJXvXDF0gyFq4M3+eZKCKyolfeuUR9i3mKwC/rww8" +
       "97NvvfdXbytdEEsXDIfN2VEyJsKsE7F0t63ZsuYHHVXVVLF0n6NpKqv5hmQZ" +
       "m4JvsXR/YMwdKYx87WiQ8sTI0/yiz+ORu1vJsfmRErr+ETzd0Cz18Omsbknz" +
       "DOsDx1i3CAd5egbwLiNjzNclRTuscvvScNSw9Nh+jSOMTw6zAlnVO2wtXLhH" +
       "Xd3uSFlC6f6t7CzJmQNs6BvOPCt61o2yXsLSw9dsNB9rT1KW0ly7FJYe2i9H" +
       "b7OyUueLgcirhKWX7RcrWsqk9PCelE7I58ujN7znGQd1zhQ8q5pi5fzfmVV6" +
       "dK/SWNM1X3MUbVvx7tcRPyM98JvvPlMqZYVftld4W+Y3/t5X3/J9j37q09sy" +
       "33OVMpRsakp4Sfmg/OLPvgJ+bfu2nI07PTcwcuFfhrxQf3qX83TiZZb3wFGL" +
       "eebFw8xPjf/17O0f0b50pnQXVjqnuFZkZ3p0n+LanmFpPqI5mi+FmoqVzmuO" +
       "Chf5WOmO7J4wHG2bSul6oIVY6XarSDrnFs/ZEOlZE/kQ3ZHdG47uHt57Urgo" +
       "7hOvVCrdk12l+7PrttL2r/gNSz1g4doa4BkA7bs59ADQnFDOhnUBBJGjW24M" +
       "BL4CuP786NnOWgYmWq7V9Yu5Nnk3qZ0k5/fe+OAgG8pX7BuyldkA6lqq5l9S" +
       "nou6/a9+7NJnzhwp9g5pJqCsh4u7Hi7mPVzc9VA6OCgafmne01Y+2eguMzvN" +
       "PNjdr2X/Lv62dz+ejUrixbfn45MVBa7tSOFjy8YK/6Vk6lX61Pvjd0x+oHKm" +
       "dOZyj5hzlyXdlVencz925K+e3LeEq7V74V1/+bWP/8yz7rFNXOZid6Z6Zc3c" +
       "1B7fH0ffVTQ1c17Hzb/uldKvX/rNZ588U7o9s9/MZ4VSpmOZO3h0v4/LTO7p" +
       "Q/eVYzmbAdZd35asPOvQ59wVLnw3Pk4pBPzi4v6+bIxfdKiUD+yUsvjNc1/i" +
       "5fSlW4XIhbaHonCPb2S9n/+TP/irejHch570wom5idXCp09Yb97YhcJO7zvW" +
       "Ac7XtKzc599P//T7vvyuv10oQFbiiat1+GRO4cxqMxFmw/zDn179uy/86Qf/" +
       "6MyR0hyE2fQVyZahJEcg8/TSXaeAzHp79TE/mfVbmcLmWvMk79iuauiGJFta" +
       "rqX/98JT1V//b++5d6sHVpZyqEbf960bOE5/ebf09s+89euPFs0cKPnsczxm" +
       "x8W2Lu0lxy13fF9Kcz6Sd/zhI//gd6Wfz5xj5pACY6MVPqZUjEGpEBpQ4H9d" +
       "QS/u5VVz8lhwUvkvt68TUcIl5b1/9JV7Jl/5ra8W3F4eZpyUNSl5T2/VKyev" +
       "TLLmH9y3dFQKFlk58FOjv3Ov9alvZC2KWYtKNrcGlJ85luQyzdiVPnvHv/9X" +
       "v/3A2z57W+nMoHSX5UrqQCqMrHQ+024tWGQ+KfHe/JatcOM7M3JvAbV0Bfgi" +
       "4eEr1f/lO814+dXVP6evyslTVyrVtaruDf9tRz7ttacEh75hZ4ay3k2owLP3" +
       "f2H5c3/50e1kuT/77hXW3v3cj33z4nueO3MiRHniiijhZJ1tmFJAvGeL65vZ" +
       "30F2/U1+5XjyhO00dT+8mytfeTRZel4u41edxlbRxeCLH3/2X/zjZ9+1hXH/" +
       "5TN0PwtAP/rH/+/3L77/z37vKpNJ5lRcqTCybkEKbt90imrjOWkXWbWcvH4r" +
       "c+iG1OOxnYwfu371uFbVPQgHW+9VtFe0yp6Ckc/J6BgjdT0Yt2UfKp7uOl0d" +
       "B3mgfDxLPfR/KEt+51/8ryv8QDG5XkVD9+qLwAs/9zD8pi8V9Y9nubz2o8mV" +
       "8Ua2qDiuW/uI/T/PPH7ud86U7hBL9yq7FctEsqJ87hCzKD04XMZkq5rL8i+P" +
       "uLfh5dNHs/gr9k3kRLf78+uxamb3een8/q69KbXwA284VIHD35NKc1Aqbi5t" +
       "9aagT+bke7cuIizd4fnGOrOwbC4LisVRbgeGI1lFV3BYOg9T7CUO7XOdTIBP" +
       "XVuAxXyxdQ/Pf/iJP/iB55/488Ll3mkEGcyOP7/KSuBEna+88IUv/eE9j3ys" +
       "CEtul6VgC3h/CXXlCumyhU/B9N1H43N3PhzZzZlPbIdn+xuWiO8gflVcX8uX" +
       "pYHmAyxcrDT9w3j4prZXYOjuW2vxLObEPBSqc3WhnslvX5MT7VCG5yzNmYeL" +
       "ouSbi7StZfbD0m3ZgOa3hpccdXlm207x/LJwFxTkGp0t3VxHy+OLw7xtfG24" +
       "F4+WzVlmcgXzful119YcshDgsf397jv/68PcmxZvu47A+rE9xdpv8p+QL/we" +
       "8mrl758p3XZkjVesqS+v9PTlNniXr4WR73CXWeIjW3kU43fCMxcjfIpPfccp" +
       "eT+Yk+/PjFDJh3ormVOK/0hSOp4XCgf9tm/loMUr3cfZnfs4ew338aPXcB/5" +
       "rZIT9TJ1O89io63LKPjfY/DHrpPB12fXuR2D567B4Huvj8E7cp9Go9jV2Pup" +
       "74C9O3bs3XEN9n72OtnLx+8a7L3/22evCClyHs/v2Dt/Dfaevzp7RYTwmkOm" +
       "tr61u8fOL9wCdj70bbGTXo2dD98Cdl74ttjZXI2dj35LdorqyUG2lDxbu9i8" +
       "WMmff+0UbXnNldryoGkpTx5GzBPNDzJX+aRpNQ9d9L3H7nv7CnCPSfjbZjJz" +
       "4y8+boxwnfnTP/6f3/v7P/nEF7KZHi+dXechUOaNT/Q4ivIXrD/ywvseedFz" +
       "f/bjxdo5Gzr2LT/svj1v9V9eH9SHc6isG/mKRkhBSBbLXU09Qrs3t92eudDv" +
       "HG34kg+iYIB1Dv+IiQzXGb46tstRfYkyi0arU0bG3S7HC8pAkMfwoNMlZgzM" +
       "zGQZRlJto4pItyZ6hshxYlfvViAeCdqT1YhFk8Tvs1kbXHXVlJaYr09CWpxI" +
       "aHNq+Fyt7Au4hLZUtKkDuq3WREesiR1EqUOtVK/pa7AJ1IByE4jqctikjcHA" +
       "Xq5svr+kGww5rPJDApdrI37DS/J4BnGTYCRO6i2fERQ9hdp6SxCZCaGwvFzN" +
       "5hh/U7MqBt8brEYi3piP8crGxr22O2RX9Myt1CzEEprUoMZ4PJhOwq4Euq7b" +
       "wghtuFS8UWTOqx3Dg5yxOpBdjrIrCaIZS2KObWCZEhddBVxBgSHCzHoYj6at" +
       "2K5BQa2G2LEYtmRWHWCTqaJXFQ3pE665MIY9j+PtiTPkMHAJ00MqWNjhuNdo" +
       "MRuuY0zHShObr3plIHDXa99ehKDXJfEVhw8sB7RtfwVLhM4xEiZOpo3pcJz4" +
       "/AhCcbYP900Zq1YriwXeG68QRiFjqe9Jq0Qg1y4+NARjsyG5MQ+lw8EYdDyc" +
       "9mw+5rlIMHAvqI1sfc4PV3Lg0xRG1SohwSLWYGnUnYTVKHPKNgKNgOGJI43Z" +
       "5chLKDMhGVftUvMBg0Rle+XP5shKGHMWFsbTYZ2vCvMxgjICtZQ4zRhTvUo3" +
       "hcpwlwk42BJEuytOAwyc25A/VyfWyEhUE7Yn5aG7woUOgFFBg62K3RgWpd6c" +
       "4mGun44UqVsXPR1uzzA+EywvguWKidUJlxlUiJnFrScq1avyrjLpdqR5POlz" +
       "toe3Y2pl6FVmRBrIeMxUeTvEq3R/GqFgexLTTX44UomxTzZW88l42ev4a1cc" +
       "phtEI/urKudPYUEuO2k6C5tVpDG1eK/Tn5HQOHUDEEhQRpqtzErqSm7qDqhN" +
       "p2F6sRrNeDmst/1lt+vSI3lcQ8yN3YooB9VTC6NpBKnYkTwWa3KNajmusG6M" +
       "mtV+xNk1TRVmPW44mCw5pTfYQLAyndjyVKX4Cdnrmf1wk5Aes1oT89VKLavU" +
       "JCpbCGMRGjOzwGm/jjJuzdNMI4LZkbBZ8eMJt9LHAwtHvOl8s6q1Frje0frs" +
       "eGUNG2TCsasQ6sLLMT9Jy/GG6TK9wXwxpuSY4JcJtWYjpR6stWXsLrwOpvHz" +
       "Ed3h0HINLatEx6+nTl+auOPYTldmY+DOnH6lHo9cubrAWQ7nmjHkDxe1aRUH" +
       "KlDP2/TQMVst+wwjeRSLbSDcoQAXWHY6Lr4JRggzlhHYI/qSVwt4Gh/PItof" +
       "1ht1q8dO4ITjrcV8CveXPQuG+wpmsxTDYJ0EdUkT0YJeYwiiVDxBKQGflsGy" +
       "4KtVqdeYLy0dgpOOJlVtpW8iMmEPSC3C1vqkSiYUXY8dWIO9XheWzIXG1TtG" +
       "ed0aSPM2OHAabUmIzShF+GkXattBzZylC1YUISSWBqAmSBzbcJRxlQ+qreUM" +
       "AVV+3UcJ2AmbWluHliAtl1fAKqIIHutYNuX0lWButnp1cc20NVn1kREXjapg" +
       "NYIgvbJuh7WUlWWSgsmVh+HiZFnmXbUBtfsQGK1NsdI00AgQ15LNxhaIyFVu" +
       "GcNAd85DiSmimQl7HDqeWENGg2c+OYP6UsgiuO6vJV+RIT52pMRu1kYdgpeW" +
       "TcRQJF4P6LZE8RBMjerMrK3Ei65Ou1CT8dVmswbONYeUF9wmW7oNfEFeqdBS" +
       "2ZiYj0mQZXuEnE3DVn/YHDW1al3gNnh1PSXx2mAwr0adzcyQGRHtVAKMRNpl" +
       "MaB9OalrLQGLfU3poiweuYuAtWpjiYVjB+IgOLbnG1+3O3FCdBOr6yNGmWd6" +
       "5YFNdqtGwowa7fUQEUgNWJuN4ZKkx/ACX6koHm+oODWUCB8oZb1sC3xiyB2s" +
       "1a20CFKyRRBU+1Monq7SeX1O47iASn4zUWnF0Xp0PFNXsdG1ZK8f9zoLOexR" +
       "M2CopJq/MptGvCQ3bLNl65KV1pKGhq812t4YbpNGTQAWvUhEVEeIvAmXsV5l" +
       "zGw+0DYoBdU5ftn0F4LkoNUkYcUJ2Oqu57XOUskMCA1xflUm8eXClmb+LBwC" +
       "a7mJt6RQl+xOF9cYxUJtdxmAos0uewQrS359PvboYaQpotEOdXjFDg1+lS7I" +
       "1orBYCcyABX0DYNsdlA0qQMVImmGSduermbxwBHEgcmNJ8MG3lxI/XaHWeI1" +
       "wfcmqpDEbuYCrbSNy6ExBUfrIch0U9onAQqNplW/LNVGst5KFZfCiUWNVO1R" +
       "fSEA05a2agygOW41cD2pY0oQEHaooNlsnaAWi8JtoCPMKRUoUz0+UGAs3ggj" +
       "0cRiQqyMhh1vlcCp3u5VuTkNZ7OZPq0DaFmfzTobe4NXxEWEyn6tnBVgQFFF" +
       "DMtiquJULLdND58iVD/jtJzaZbAOa0YCye2yXS/XpZCcziZ81Z77zKy1BprC" +
       "2okWKlwLoXbV0IQ5hkwoLm07MdqdNQbBZtJSGEkd0MNFuelK4hxW2P7AGmZR" +
       "CjOCVZcNdarvDBaEOoqmacWbTmcDlRrEksOM7Tj15jGHIzVqDdFOw+i3LHiy" +
       "5ns4WUM6HK96jeoiZnC6A3mraYDys40y9xsgVZkMMbCs4LS/nCAbdDWP18SY" +
       "CAJhJNudhWbOFphPkAhPsiN1loT1YY2eAaK2ARx/vakB3gjgmKThKgArttYT" +
       "IlivV7pQEyDFm82jsSG59bajkS01VOobuka0fT4eaBvFDtojJaWlYO2M6smm" +
       "RVcXCoCwjOVI7HC00YeomM5i2tRhMexlRt1cBNXK2Knb4wCYVTnWIpsozi2j" +
       "ek9bk0ttY/ONhWNjq8nAHKA0XLZmkgOoXoXs06IxpUncJCFEcf2FW5+w7moB" +
       "o8C8nfaVSmioaDlRlpzDLfHxqDUOB/hUp4ftVXPCJtpa8LoQiI9qoBGbZHeD" +
       "4CylUateuxFW0J44ieEEoQhNirTKGhqVcToYw12wOV2Km9kQ32CSY3kb0Z8i" +
       "01oLMO3KmGisGaw8weJGOOmIIuMNK0xYpZq+kMZjQSnH7SCQiUU2TTsxuBBk" +
       "BGh2l96AZRjamgs9J1jV6m3dCjbVQEellVtrBWx7OSTt1YzYmDGdcs0o7ZmD" +
       "2XAhYL7DtshV5CzdFPHmUtiaqCBIgMgSS9PBPOw2K9xKZc12czj1pxIW11tC" +
       "Y8h0IHe6thOBQGJ+RBuOIyGsKiGNhWgh0yEsxSvOMzepg7n6eNy3GDtIpfXS" +
       "d8lBWx6OCb0Vi5EpOxsnBCttGGxbAWhZPCiLXEQ4K7lbDpo1ob6xJ14DKAeo" +
       "XAVGjWrS7K4dymd6hk4ITT3SdDlzcemIEURJ5IyVP6CiTR8a2VrDE4aTRhYU" +
       "p2Dd7nlsQ5Y5ZOxLbTohfNUrQxQ+WndoAAErmKiVeyyQbqhOX1KGIKkRMo3I" +
       "XWXdV8gBm67l3lia6cM1EceZuyojg5aokTQylMZNIWpTGL2Wp21xpi80gjBh" +
       "TBGoLKo3FkCHt2vkRKssknp9QIBKFvItusiSkCxiCqbNXoVCeJ9c8m5LRE0w" +
       "QoQYnMcp2PfAlO5hFWXdIZcV3iNjZaUkvcW6Vk4lUZArxtpXN9IooNHWptej" +
       "UwzqwCQVYXVQ7EKI3ptVwVVPNkgAMvG5QttDy2vR5fGCQCMJCil/pthTGPMB" +
       "sqHZWjMcV4VerUb7fuJwht+bMpOpr6yHQ5YI3cZwZCmD2rBXG0nKooyb8WaD" +
       "OKQyxI1UK0cNY0BPxsA6bssLNQOqsUuWBLGm69jjqhH5Uz2bIxATFALfrder" +
       "StkMMcFF+I4y5BEe9kLZWEP2RsiMJ04xxrAGUX+tGo1mbCYgFAZJv93meysY" +
       "6pBrq9ckOxXXhSW7JzZAbxMmJkM6k3i0cCccqOgaB2xWmU6kY71jSkyIr2dr" +
       "xFq0qrwWDB2EclJRrrhpPVZkHG5E9WHkR5A8a46zNU27OupFAQyp0KzLzxbD" +
       "GRasMS0l0EREVouOwjUmK3LKh8bEYSNuUOF1cOqVGylvIh6qRD17g0DzLCp2" +
       "FlIW60kKKI0GFUUv80BlpYySDsA3VhwcS2qZAQeZ++Z7/LKjYVNKQru1QLA7" +
       "uLrsUdi6ZzZiFLa5pNYDB2MGBZ2aQvjZZK/bUJeSjUoVJ7LpdWSBypohZzBA" +
       "dcccmMVF/QxXNFcAclBBxmC0TJLIwZBlV0VlsDfTBHVuMe3OChpkwQKN9htY" +
       "z1HFlrsgN+LMsXrdytqMQBFf0mhlhVTpRbeKla3KYrrIbBsZ2jExUGJpPGjp" +
       "i0HfTBlGgbqo23Ukk4EqXTSFlUZk2IRjjirr3lyzGFyF5vQY4s2GAKOrTVXr" +
       "J2AdGVvU3OTsXopFpgn0hHI4VhdlRnIm42GzK6Fkf27KtsNAzsbjuUqrCs0N" +
       "QSQ3SyIGy3M42Uh6NDKYemzOyj0R7y1qzcx/bgRbwRVrMwKzvqlBWayXbbgC" +
       "tyyVXpht0itHEmnwErxwENRK1H6XmeGVEUGQGFNmFmiT0RgZEwB8YDdJMaCo" +
       "OoFXGnW7SqiOSSl5m14lBFr9PtpL3J7ZtI1g09brixUgExvZooTIGaJmoqNu" +
       "qJk0bc5VZo0pY1MQI0kF6HkL5BSk0dB7wWgoSBoTg6giJPZYlZvlBU0IlUYT" +
       "o7laZj5KS/DaQqySZcxr1CDOHdWgRLEJX1ZZnlFnKBB12tPWslnGBKWxCiSm" +
       "udHStq70hE4L7HjVmIIWSkQ0VbTXlnlaGLWMMgu4g4U2orJlBo235/TUG7an" +
       "iyjWcUNrj+ddPmrHzGqKxbYxq7QrIohNCHLem9LzAVqhgznsTOZTspO2y4lW" +
       "Ryt9oaFw7UofH/CNYbb4BWPF8kd8P5OhOErxYMCkScPbKEAbxw1h2e1NyxYX" +
       "mI3GDEiUZFJuAvKwskZlor6ZRGjElpcOnnbmnslO+hWh0U51UfOH8wpuwsw4" +
       "WQmOuhjESKedUtNWd6VxzDpFW3FCjSB/VCGX2HRDqnLSSEf1yOxXENntIuWN" +
       "hSt8j4pkdjpSgDGumtzMirmeEwHSei36KWFKsQARlrxClly3zKnCoNmOyjIp" +
       "IFhN12bVhIIqk2iJVqsUi8OsmzRbbuwJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "7A/+/77JB4/YQgAA");
}
