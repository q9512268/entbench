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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rjmGHeRUh3Y4Wf66ddfzF8zkbw6yEyzDZWWdfGV2asp0VOUq1ROqlBnZGyx1" +
       "2WiLjmx9fWLXnT51dyPZAp6Kx4U29MKn+T2eoYw4VQA/XmyL5CxsJoYLm1K2" +
       "Ry4yPVKRh0e+z8Mj4ysbf8AwjWwv7MUZvHB7y3LDC2PBVQ4pth+jFD+Ep9gc" +
       "q9hDigeOWwovzhCRMJa0LWlxk2H3cchQYo5U4iHDo8ctgxdnkAFXwkOGx45e" +
       "BpZzoiBl5khlHjLs9U07vXpDom1l2bYZPpmHGf4RyT4YccBtxKfzMOLzqREH" +
       "3UZ8wWfE5PARKz0d9jeSOM56bdOxZcsEQ3yd13E827dtu3Zoa3TFfXNSuc5K" +
       "sGpdVk4RaR8VbawMtkPpaUxD9jPhmWFOY4YTFUt+d1UPear6eB+2Dq9rD8lL" +
       "kJgR3BHNi7ReWc3aYeJHw/dSRv/u49LfQfIapAwQpswASq3FfT1n+z8XhEMm" +
       "FKHcIuzF1n1viB8PsRE/9UHpCJIPvFD6MA8ooSSkDp65pjhzjwElVwNjo1X5" +
       "cPSR/zufuu+RfAnYQNJuYnPIwuarPGBTjXX4Mt+UZL4PNkhcXLlXV3ctsdsh" +
       "0p+6mxzWBcq9sQqMQlIEWXgPZVn40jRQgeJ8KlGLKW1LzpTIi6OP8LU+dZOR" +
       "jEnvXBzYjM0XNo3wtJqStOYMGy+OPvKf6FOH4wbqdVJhYNO+PsGpNOqAqCEP" +
       "ELHMD4/YLjQFujBnEHlx9IHhTJ86BsGpoD4S7eF0h38OzMknNpeYklySM2y8" +
       "OHoHMBbmA+f7ALQYyXwvgM7NF0CT4ekyxenKGUBeHL0BYiffgZU+AK1CEgHP" +
       "HE+IDnRa84lOzJQlljN0vDi6Z5gMHUuH1vhA1I2k0xWi1fmEKG4KFM8ZRF4c" +
       "h1MgyQcd5BDoBXSiQp8DHSGf6OimLHrO0PHieFQKdIUPRFci6XOFqD9fER43" +
       "GpebAl2eM4i8OPoIf71P3Q1IrtNJpcTucwiDNOKWBm3Mlx7Vw3OdKdJ1OQPJ" +
       "i6MPEFt86u5AcjNs49MgOXTolnzCc4MpzA05g8eL43BhfrsPRjuQ3OOD0S/z" +
       "6YqGTImGcoaRF0cHBAXW2cBSizBEHvFB6zEku8EfacZuzIbTnnzidKcp1Z05" +
       "w8mL43C69AcfdPCgMfCEKzp78+Wt8WvHe01Z7s0ZOl4cj16L/uyD0wEkL2BU" +
       "k517+hfzgNMUrJsOz3ZTqu3HgNNRHJ95sfWO/tTSp8M+OL2N5A1XnA7m65gR" +
       "T1l3mgLtzC1OXmy9lYo6wPrYB6x/I3kXv5hTZU1zmN97+YKrAZ6HTLkeyi1c" +
       "XmyPHq6vfeD6Fsl/Qbe4aNQB1uf5BOtxU6rHcwuWF9ujBitY6g1WsBxJEB17" +
       "ojsTrGBBHsDCL/gYYvtMqfYdA1j+jt2Lo4/w43zqJiCp0kmpLhs/MmGtJuik" +
       "yroRYatgiFXn5CaYTkrMq2h4P3VC1s+BjJ+w8Lu3VpaO33rR68bdk9TPTEZG" +
       "SGksIYr2i06292JFpTGBgTzSuPbErgQG60Eu54U4nRTiP5xncLrRbIZORtia" +
       "6XgHkb3ZG50I2gSN8HWW4oKacYEraZyjT7Kjwb4kGPZ81/a1X0PG1Q72+6rU" +
       "NYyE8QurLn7P1qXLLz9y5n3GNXVe5AbZV5cjIqTEuDHPmOJVjume3FK8ipfM" +
       "+mbUg2UzUl8kVhsTtnR2kqVBZAFkVwouYa3jDrfWmL7KfXDbvCf/tLn4QJAE" +
       "VpMAp5PRq7OvuiWVhErqVkeyL4p2cCq7XN40646B+SfHPn2T3VImxq2byd7t" +
       "u/jOW95oeXDdl+exH/QUCVKUJtkdvPMHpJWU71Mzbp2OQu3iUNcZDiZ8FelS" +
       "/FGDTuqzr9xm/xSkHJSFqgvlhMR8c0WEjLBKjJVw3H5JKIqjg1ViLh3SDiTL" +
       "kog+6F9XpFVRUjeSDyrMtC52S33ZV6PBeewV3875Pyaq4E1qOQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CdDkWH1ff7M7OzvLLjO7wO6yZndhDwy0M2q1+mQdcKsP" +
       "qdVSS62ru5WEQXerW/fRUmuztsGOwUdhEi82Cfa64gLskAV8xGVSiQ0pl2Mc" +
       "XE7hchlyYGwnFewQKhBXIAmJiaTu75iemQ+GmeGr0r+ld/5/73+8/5Pe+178" +
       "Uuls4JfKrmNudNMJL6lJeGlp1i+FG1cNLmF4nRL9QFW6phgEbJZ2WX7ily98" +
       "9evvXlw8U7pLKL1MtG0nFEPDsQNaDRxzrSp46cJxat9UrSAsXcSX4loEotAw" +
       "AdwIwmfw0ktOVA1LT+GHLAAZC0DGAlCwAHSOS2WV7lPtyOrmNUQ7DLzS95cO" +
       "8NJdrpyzF5Zec2UjruiL1q4ZqkCQtXB3/sxnoIrKiV969RH2LearAL+nDDz/" +
       "M2+5+Kt3lC4IpQuGzeTsyBkTYdaJULrXUi1J9YOOoqiKULrfVlWFUX1DNI20" +
       "4FsoPRAYui2Gka8eDVKeGLmqX/R5PHL3yjk2P5JDxz+CpxmqqRw+ndVMUc+w" +
       "PniMdYtwkKdnAO8xMsZ8TZTVwyp3rgxbCUuP79c4wvjUKCuQVT1nqeHCOerq" +
       "TlvMEkoPbGVnirYOMKFv2HpW9KwTZb2EpUeu22g+1q4or0RdvRyWHt4vR22z" +
       "slLni4HIq4SlV+wXK1rKpPTInpROyOdL4+9917M2ap8peFZU2cz5vzur9Nhe" +
       "JVrVVF+1ZXVb8d434D8tPvib7zxTKmWFX7FXeFvmN/7uV77vex77xCe3Zb7r" +
       "GmVIaanK4WX5/dJLP/2q7uvbd+Rs3O06gZEL/wrkhfpTu5xnEjezvAePWswz" +
       "Lx1mfoL+1/Mf/JD6xTOle4alu2THjKxMj+6XHcs1TNVHVFv1xVBVhqXzqq10" +
       "i/xh6Vx2jxu2uk0lNS1Qw2HpTrNIusspnrMh0rIm8iE6l90btuYc3rtiuCju" +
       "E7dUKt2XXaUHsuuO0vav+A1LQ2DhWCogyqJt2A5A+U6OPwBUO5SysV0AQWRr" +
       "phMDgS8Djq8fPVtZ8wCv5qoNXcpVyr2VjSU55xfjg4NsUF+1b9JmZg2oYyqq" +
       "f1l+PoL7X/nI5U+dOVLxHeZMVFkPl3Y9XMp7uLTroXRwUDT88rynraSycV5l" +
       "Fpv5sntfz/wd7K3vfCIbn8SN78xHKisKXN+ldo9tfFh4MjlTtNIn3hu/jf+B" +
       "ypnSmSt9Y85dlnRPXp3KPdqR53pq3yau1e6Fd/zFVz/60885x9ZxhbPdGe3V" +
       "NXOje2J/HH1HVpXMjR03/4ZXi79++Tefe+pM6c7MkjPvFYqZtmWO4bH9Pq4w" +
       "vmcOHVmO5WwGWHN8SzTzrEPvc0+48J34OKUQ8EuL+/uzMX7JoXo+uFPP4jfP" +
       "fZmb05dvFSIX2h6KwlH+Tcb9uc/+wV9CxXAf+tQLJ2YpRg2fOWHHeWMXCou9" +
       "/1gHWF9Vs3Kfey/1U+/50jv+VqEAWYknr9XhUzntZvabiTAb5r/3Se/fff5P" +
       "3v9HZ46U5iDMJrJIMg05OQKZp5fuOQVk1ttrj/nJ/ICZKWyuNU9xtuUohmaI" +
       "kqnmWvp/LzwN/vp/e9fFrR6YWcqhGn3PN2/gOP2VcOkHP/WWrz1WNHMg5/PQ" +
       "8ZgdF9s6t5cdt9zxfXGT85G87Q8f/Ye/K/5c5iYz1xQYqVp4m1IxBqVCaECB" +
       "/w0FvbSXB+bk8eCk8l9pXyfihcvyu//oy/fxX/6trxTcXhlwnJQ1IbrPbNUr" +
       "J69OsuYf2rd0VAwWWbnaJ8Z/+6L5ia9nLQpZi3I2ywaknzmW5ArN2JU+e+7f" +
       "/6vffvCtn76jdGZQusd0RGUgFkZWOp9ptxosMp+UuG/+vq1w47szcrGAWroK" +
       "fJHwyNXq/8qdZrzy2uqf09fk5Omrlep6VfeG/44jn/b6U8JE37AyQ1nvplbg" +
       "uQc+v/rZv/jwdtrcn4f3CqvvfP7HvnHpXc+fORGsPHlVvHCyzjZgKSDet8X1" +
       "jezvILv+Or9yPHnCdsJ6oLubNV99NG26bi7j15zGVtHF4Asffe5f/NJz79jC" +
       "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" +
       "H7ebFOjNcDxtb+o2hGRhj1rvSAJfl5dD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "8CfFHuH/D0X5SVHwQgAA");
}
