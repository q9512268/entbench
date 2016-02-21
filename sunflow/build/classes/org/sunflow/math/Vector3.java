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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bC5AUxRnu3Xsfd9wDecodcBxUgbir4CNyBMQTuMU9ODmg" +
       "9FCX2dneu4HZmWFm9tgDScQYISmlSDzfShmDghSKWlohRgWT+CqNKdH4iInG" +
       "aCUYYgJJSSyJmv/vmd2Znd0ZXmOuavpmp7v//v+v//7+v2d7d39KyjSVNFNJ" +
       "D+kDCtVC8yS9i1M1mmgXOU1bCs9i/O0l3L+vObjooiAp7yFD+zitk+c0Ol+g" +
       "YkLrIU2CpOmcxFNtEaUJ7NGlUo2q/ZwuyFIPGS5okZQiCrygd8oJig2Wc2qU" +
       "NHC6rgrxtE4jpgCdNEVBkzDTJDzXWd0WJTW8rAxYzUfZmrfbarBlyhpL00l9" +
       "dBXXz4XTuiCGo4Kmt2VUcpYiiwO9oqyHaEYPrRLPNyFYGD2/AIKWR+uOHtva" +
       "V88gGMZJkqwz87QlVJPFfpqIkjrr6TyRprQ15DukJEqG2BrrpDWaHTQMg4Zh" +
       "0Ky1VivQvpZK6VS7zMzRs5LKFR4V0smEfCEKp3IpU0wX0xkkVOqm7awzWDs+" +
       "Z61hZYGJt54VHrz9mvrHS0hdD6kTpG5UhwcldBikBwClqThVtbmJBE30kAYJ" +
       "JrubqgInCuvMmW7UhF6J09Mw/VlY8GFaoSob08IK5hFsU9O8Lqs585LMocxP" +
       "ZUmR6wVbR1i2GhbOx+dgYLUAiqlJDvzO7FK6WpASOhnn7JGzsfUyaABdK1JU" +
       "75NzQ5VKHDwgjYaLiJzUG+4G15N6oWmZDA6o6mSMq1DEWuH41VwvjaFHOtp1" +
       "GVXQqooBgV10MtzZjEmCWRrjmCXb/Hy6aNaW9VKHFCQB0DlBeRH1HwKdmh2d" +
       "ltAkVSmsA6NjzdTobdyIZzYHCYHGwx2NjTY/u/bIxdOa979ktDmzSJvF8VWU" +
       "12P89vjQ18e2T7moBNWoVGRNwMnPs5ytsi6zpi2jAMOMyEnEylC2cv+SF668" +
       "bhc9FCTVEVLOy2I6BX7UwMspRRCpuoBKVOV0moiQKiol2ll9hFTAfVSQqPF0" +
       "cTKpUT1CSkX2qFxmnwGiJIhAiKrhXpCScvZe4fQ+dp9RCCG1cJFGuEqI8cf+" +
       "66Q73CenaJjjOUmQ5HCXKqP9OKFSggvrVIP7BNQqclhLS0lRXhvWVD4sq725" +
       "zykYKLycopPPCKFzKd+M2AxaM2xtIABAj3UucxFWSIcsJqga4wfTl8w78kjs" +
       "FcOF0O1NHGD6YISQOUIIRwiZI5BAgAk+A0cyZg+wXw2rGGi0Zkr31QtXbm4B" +
       "zDLK2lJED5q25IWTdmupZ/k5xv9r4YczOjbMfCNIgsAGcQgnFquPt7E6hiNV" +
       "5mkCSMWN3bMMF3bn86I6kP13rN24/LvnMB3sNI0Cy4BhsHsXkmtuiFbn8iwm" +
       "t27TwaN7btsgWws1j/ez4aqgJ67/Fuf0OY2P8VPHc0/GntnQGiSlQCpApDoH" +
       "jg8c1ewcI48H2rKcirZUgsFJWU1xIlZlibBa71PltdYT5lcN7P4MmNoh2ZUy" +
       "wlwp7D/WjlCwHGn4IfqKwwrG2d/uVu5957VPZjC4s/ReZ4vL3VRvs1EKCmtk" +
       "5NFgud5SlVJo98c7um659dNNK5jfQYuJxQZsxbIdqASmEGD+/ktr3v3g/e1v" +
       "BnO+GtAhpqbjkJpkckbic1LtYSSMNtnSByhJhHWCXtO6TAKvFJICFxcpLo7/" +
       "1k0698m/b6k3/ECEJ1k3mnZ8Adbz0ZeQ61655j/NTEyAx5BoYWY1M3h2mCV5" +
       "rqpyA6hHZuOBpjtf5O4FxgaW1IR1lBEfYRgQNmnnMfvDrJzhqLsAi1bN7vz5" +
       "68uWusT4rW8erl1++NkjTNv83Mc+152c0ma4FxaTMiB+pJNgOjitD9qdt3/R" +
       "VfXi/mMgsQck8hDwtcUq8FkmzzPM1mUVv3/uVyNWvl5CgvNJtShzifkcW2Sk" +
       "Cryban1AhRllzsXG5K6thKKemUoKjEc8xxWfqXkpRWfYrts78olZO7a9z5yK" +
       "SWgqXC+jTVcaXXy9YDkZi6mFXujW1TFfJcW4F7Pt7nRcAwYVUrCk+s18YHrX" +
       "Sn5za9fHRqwfXaSD0W74zvDNy99e9SpbsJXI0fgch6y1MfBctdfGFvWGCV/D" +
       "XwCur/BC1fGBEVcb283gPj4X3RUF53+KRzqeb0B4Q+MHq+85+LBhgDP7cTSm" +
       "mwd/+HVoy6CxCo0UcWJBlmbvY6SJhjlYRFC7CV6jsB7z/7pnwy92bthkaNWY" +
       "n/DMg3z+4be+fDV0x59eLhJ9gQ5lTs9NZ8CgJ2TS/NkxTLr0B3VPb20smQ8R" +
       "IEIq05KwJk0jCbtMyHG1dNw2XVbyyR7YjcOp0UlgKswCPuhgBbud58EKV2Bx" +
       "Mau6EIu5BoXOPLGVhQ/muC2XcabPjzv55eLW1WFIFl/8PMoj92Ejch4oMDSv" +
       "slC4+uRRMHqcyZ5VYAKXlzyxTbYV+3e9ceHvdvzotrWGj3msGEe/UV8sFuPX" +
       "//nzAlZmqU6RReTo3xPefc+Y9tmHWH8r58DeEzOFSSdkZVbf6btSnwVbyp8P" +
       "kooeUs+bm9rlnJjGSN4DGzktu9OFjW9eff6mzNiBtOVyqrHOVWwb1pnt2JdG" +
       "qZ63DKwEh5HsrKw/Zf/bPTBA2I3B9JNZOQWLaQb/6qRCUYV+4DTILDS2f8a1" +
       "LUic6MgwRnmMopOq9sXdsaUd85bOzX85kyNoFtsNMrhqyAv7tJ/+5XHDJYrR" +
       "v2M7uHNHJf9e6gVG/zjegpxmQ1GRYXCNMTUbY1B2/PT3LLys0rCS5czwUlWA" +
       "GRVpJwTk7M7o/zAKEvkk90VjQ3XbgxNf++62iR+ypKNS0MC1INAV2aDb+hze" +
       "/cGhA7VNj7DEvBTjpUm++W82Cl9c5L2PYHNSh8W1Bh8XZa1VRgPTH79X3B+D" +
       "eHs2Fv1MVAS8UqRSr97HWl5mBjf8t1gnJaAX3m5UMrkhg4acLFEa2SUuxlC7" +
       "KEsUE9VsnbE/FORQ7qUQVGYKlFdJUx7BdTLTLbaovvGcYVE9kyzcGKKkZpet" +
       "31T3SXUO8OL1fxuzdHbfypPY9Y1zzLlT5EOdu19eMJn/cZC9TTLIqeAtVH6n" +
       "tnxKqlapnlal/PjcYjnBRlvUY7PmEZNu96i7E4tB4CQep8+YbY/m95ghijin" +
       "ET8us8VjFvzWHC/4rSpk2jKTacpcmPY+F6bFW+atacO9C9nVTTKwa3dkkcGu" +
       "+GC9w4qfnKQVM+EqN8cqd7Fi5ylb4SYZIg3GiK6OSDEbHjoFGyrMkSpcbHj0" +
       "lG1wkww24Ey42PDYidvAMkc0pMocqcrFhr2eyaNbb0iOrczYpuHPvwEN92Hx" +
       "FIw4UGzE/d/AiL/Ojriu2IjPe4yYOX7UyanD/mqI4y2rTR1bFkwwTDe5vQhn" +
       "e63t1w9uSyx+4NxsDtMFq1qXlbNF2k9FmyhD7NacGuNR/GS4JplqTHKiYtlf" +
       "3NXPdnX1kR5iHRxrD6vzsTCjsCMil2l9slqwK8SPBvfGWfm2B4G/j8XrEPYh" +
       "KEHYZJ2syT1winu2IniGTMND/uLpJrb4fg4/vsNG/MQDk0NYfOSGycenjQnq" +
       "TZrgmm4qP/0kMCm6eNhg9R4SPaw96lH3ORaHAQnYHJhIvGMhceS0kWjAKryZ" +
       "beo92wMJLIqQsltXjx29uaKw3FR88WBdIOiOTKAcH34JOXEvZbGtw4LlK/8c" +
       "JGLaFvHNQdwkepja4FE3DIshuV1DPhKBGn+QaIWr09S70zck3CR6WNvsUTce" +
       "C9jl1BpIdK9JcypNOAAZfdqAsGwMX15dbqp/uW+AuEn0MPosjzocJzAJXEOi" +
       "vZzuYNHAZP+QuMLU+wrfkHCT6B5UWKANfMsDjplYTHeDY4Y/cIyFK2YqH/MN" +
       "DjeJ7nCwt8MBj7fDgQVYzAH+TKVFBxYX+4dF0tQ86RsWbhKL528MC8s/lngA" +
       "shSLaFFAOv0DJGWqn/INEDeJx3OOmAcWHBZXAhYJod+BRY9/WOim5rpvWLhJ" +
       "PCHnED0Awa+6A8migPT6E2MxRV9vqr/eN0DcJHqYOuBRh28AAvg9scROJgjr" +
       "aLRY2qH74yMtcN1gGnCDb5C4SfQw+0aPus1YXAeb2xwkDv/Y6B8YN5mq3+Qb" +
       "GG4Sjxdob/FA5FYsbvZAZIt/FDJo6j/oGyJuEh0Gl1j74w6rYPbf54HN/Vjc" +
       "BTyiGbsWGyp3+4fK3aYNd/uGipvE4/nJwx5Y7MFiR1EsdvrDqfjl2P2m5vf7" +
       "hoWbxBP3kKc8UHkaiycw0siOfW3gydNGpRmrJsD1oGnDgyeBygm8DHIT6x5/" +
       "45avvOiBystYPFcUlV/684oM3wfuMtXf5S8qbmLdHSbugOZND2jewuI1/MJI" +
       "lTXNsZB+6w84E+F6zLTiMX/BcRN74uB86AHOR1i8B37DJRIOaP7gHzR7TRv2" +
       "+guNm9gTh+YfHtAcxuIg0m867oDmk9OGBr9UYvjsM23YdxLQeNOvm0QPU495" +
       "1H2JxWc6qdRl4ycFrNUondRb36TbKhg+R0/hDJFOKswjS3hocVTBTz2Mnyfw" +
       "j2yrqxy5bdnbxgmF7E8IaqKkMpkWRfsRGdt9uaLSpMAgrTEOzLCDYsFysMJ5" +
       "cEonpfgP1QyWGc2qdDLE1kzHk2nszt6oBjwFGuFtrVIEI+PoT8Z4v5v7ligL" +
       "GRl+PMhsXyxNzDsqwH47k/1aP238eibG79m2cNH6Ixc8YBxV5kVuHftybEiU" +
       "VBinpplQPBowwVVaVlZ5x5RjQx+tmpT9qqrBUNjy0DMtfyFzIL9RcArHOM7x" +
       "aq2547zvbp/17G82lx8IksAKEuB0MmxF4SGpjJJWSdOKaOHxweWcyg4Yt025" +
       "a2D2tOQ/32NHV4lxNmOse/sYX/XFlnUTtEAoSKoipEyQEjTDTm9dOiAtoXy/" +
       "mncWsTwup6XcmZeh6Gsc+jlDxQSzNvcUj7nrpKXwWGbh0f9qcB2qXoLSUUyt" +
       "4yBFWlHstQxVfPlCIhlEGfwsFu1UlOx51HcZ6oqC6yiIL3nJsv8BLC/jxRQ3" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5965hfHAleN3G4SnH/mj//d7l973p797jcEEOBVHzI0MzUnO7ZtPUW06I808" +
       "Cc7IG7cyR25KPR7fyfjxG1eP6xXdg3Cw9V55fXmt3CkYJxlhjzH2bwTjNu/D" +
       "+dM9p6sjkYXRx6PUw/+nb0rv+PP/dZUfyAfXa2joXvk59OLPPoK9+Yt5+eNR" +
       "Liv9WHJ1vAGmHMdl4Q9b//PME3f99pnCuXnhorybz/CiGWZjxxzE8P7hJAfM" +
       "ea5IvzIe3wafzxyN4q/aN5ETze6Pr8eqCe6z3Nn9PXtDau4H3nSoAoe/J5Xm" +
       "oJDfXN7qTU6fysh3bl1EUDjnenoELAyMZX4+dcrsQLdFM28KCwrnsT53eUy1" +
       "xy0gwKevL8B8vNi6hxc+9OTvf/8LT/5Z7nLv1n0As+Vp15gnnCjz5Rc//8U/" +
       "uO/Rj+ZhyZ2S6G8B70+wrp4/XTEtypm+96h/7s26A9yc+fi2e7a/QeF7bz6c" +
       "lR1PzeawvupBHJZPS73DaPl2Vp8jRPdtOX+eZ8Q4FLl9bZGfyW5flxH1UMJ3" +
       "maqtBcs851vyd1u7bQeFO0B3Z7e6mxw1eWZbT/78imAXMmT6DqZ9jq1m0cdh" +
       "2jb61p1LR1NukJhcxbxXeMP19YrJxXtsnb/zjv/6yPjNy7fdQNj9+J7a7Vf5" +
       "T5gXf5d8rfz3zxTuOLLVq+bjVxZ65koLvcdTg9Czx1fY6aNbeeT9d8Jv5z18" +
       "isd9+ylpP5iR7wMmKmddvZXMKdl/JCkcjxq5+37bN3Pf86udy9mdczl7Hefy" +
       "o9dxLtmtnBHlCnU7z3XYrUPJ+d9j8MdukME3guuuHYN3XYfB99wYg+cyjzeg" +
       "Otdi7+/9Ddg7t2Pv3HXY+5kbZC/rv+uw975vnb084Mh4PL9j7/x12Hvh2uzl" +
       "8cPrDpnael50j52fvw3sfPBbYie9Fjsfug3svPgtsbO5Fjsf+abs5MWTAzDR" +
       "PAtfql8qZc+/eoq2vO5qbXnIMOWnDuNpXvV84CqfMsz6oYu+eOy+t8uHe0xi" +
       "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" +
       "kFoEqdTWJzyq265rDgeoE8c8L/LmHEmQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
