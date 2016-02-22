package org.sunflow.core;
public final class Ray {
    public float ox;
    public float oy;
    public float oz;
    public float dx;
    public float dy;
    public float dz;
    private float tMin;
    private float tMax;
    private static final float EPSILON = 0;
    private Ray() { super(); }
    public Ray(float ox, float oy, float oz, float dx, float dy, float dz) {
        super(
          );
        this.
          ox =
          ox;
        this.
          oy =
          oy;
        this.
          oz =
          oz;
        this.
          dx =
          dx;
        this.
          dy =
          dy;
        this.
          dz =
          dz;
        float in =
          1.0F /
          (float)
            java.lang.Math.
            sqrt(
              dx *
                dx +
                dy *
                dy +
                dz *
                dz);
        this.
          dx *=
          in;
        this.
          dy *=
          in;
        this.
          dz *=
          in;
        tMin =
          EPSILON;
        tMax =
          java.lang.Float.
            POSITIVE_INFINITY;
    }
    public Ray(org.sunflow.math.Point3 o, org.sunflow.math.Vector3 d) { super(
                                                                          );
                                                                        ox =
                                                                          o.
                                                                            x;
                                                                        oy =
                                                                          o.
                                                                            y;
                                                                        oz =
                                                                          o.
                                                                            z;
                                                                        dx =
                                                                          d.
                                                                            x;
                                                                        dy =
                                                                          d.
                                                                            y;
                                                                        dz =
                                                                          d.
                                                                            z;
                                                                        float in =
                                                                          1.0F /
                                                                          (float)
                                                                            java.lang.Math.
                                                                            sqrt(
                                                                              dx *
                                                                                dx +
                                                                                dy *
                                                                                dy +
                                                                                dz *
                                                                                dz);
                                                                        dx *=
                                                                          in;
                                                                        dy *=
                                                                          in;
                                                                        dz *=
                                                                          in;
                                                                        tMin =
                                                                          EPSILON;
                                                                        tMax =
                                                                          java.lang.Float.
                                                                            POSITIVE_INFINITY;
    }
    public Ray(org.sunflow.math.Point3 a,
               org.sunflow.math.Point3 b) {
        super(
          );
        ox =
          a.
            x;
        oy =
          a.
            y;
        oz =
          a.
            z;
        dx =
          b.
            x -
            ox;
        dy =
          b.
            y -
            oy;
        dz =
          b.
            z -
            oz;
        tMin =
          EPSILON;
        float n =
          (float)
            java.lang.Math.
            sqrt(
              dx *
                dx +
                dy *
                dy +
                dz *
                dz);
        float in =
          1.0F /
          n;
        dx *=
          in;
        dy *=
          in;
        dz *=
          in;
        tMax =
          n -
            EPSILON;
    }
    public org.sunflow.core.Ray transform(org.sunflow.math.Matrix4 m) {
        if (m ==
              null)
            return this;
        org.sunflow.core.Ray r =
          new org.sunflow.core.Ray(
          );
        r.
          ox =
          m.
            transformPX(
              ox,
              oy,
              oz);
        r.
          oy =
          m.
            transformPY(
              ox,
              oy,
              oz);
        r.
          oz =
          m.
            transformPZ(
              ox,
              oy,
              oz);
        r.
          dx =
          m.
            transformVX(
              dx,
              dy,
              dz);
        r.
          dy =
          m.
            transformVY(
              dx,
              dy,
              dz);
        r.
          dz =
          m.
            transformVZ(
              dx,
              dy,
              dz);
        r.
          tMin =
          tMin;
        r.
          tMax =
          tMax;
        return r;
    }
    public void normalize() { float in = 1.0F /
                                (float)
                                  java.lang.Math.
                                  sqrt(
                                    dx *
                                      dx +
                                      dy *
                                      dy +
                                      dz *
                                      dz);
                              dx *= in;
                              dy *= in;
                              dz *= in; }
    public final float getMin() { return tMin;
    }
    public final float getMax() { return tMax;
    }
    public final org.sunflow.math.Vector3 getDirection() {
        return new org.sunflow.math.Vector3(
          dx,
          dy,
          dz);
    }
    public final boolean isInside(float t) {
        return tMin <
          t &&
          t <
          tMax;
    }
    public final org.sunflow.math.Point3 getPoint(org.sunflow.math.Point3 dest) {
        dest.
          x =
          ox +
            tMax *
            dx;
        dest.
          y =
          oy +
            tMax *
            dy;
        dest.
          z =
          oz +
            tMax *
            dz;
        return dest;
    }
    public final float dot(org.sunflow.math.Vector3 v) {
        return dx *
          v.
            x +
          dy *
          v.
            y +
          dz *
          v.
            z;
    }
    public final float dot(float vx, float vy,
                           float vz) { return dx *
                                         vx +
                                         dy *
                                         vy +
                                         dz *
                                         vz;
    }
    public final void setMax(float t) { tMax =
                                          t;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaCWwc1Rl+uz7j2w65E+dyqHLgJQTKYQo4xiZO1wdxsIoD" +
       "OOPZt+uJZ2cmM2/ttWm4REha2ihADlpB1FamUBQIqkBtVYhSoRYQAQlKA7Qi" +
       "IGgFLaUQtYWqQOn/v5nZmZ2dmRBkrzRvZ97xH9/7///9780c/oCUGDpppApr" +
       "ZuMaNZrbFdYr6AZNtMmCYWyGukHxYJHwzxve6744SkoHSM2wYHSJgkE7JCon" +
       "jAGySFIMJigiNbopTeCIXp0aVB8VmKQqA2SWZHSmNVkSJdalJih26Bf0OKkX" +
       "GNOloQyjnRYBRhbFQZIYlyTW6m1uiZMqUdXGne5zXd3bXC3YM+3wMhipi28T" +
       "RoVYhklyLC4ZrCWrk9WaKo+nZJU10yxr3iZfYEGwMX5BAQTLHqv9+NO9w3Uc" +
       "gpmCoqiMq2dsooYqj9JEnNQ6te0yTRvbyU2kKE4qXZ0ZaYrbTGPANAZMbW2d" +
       "XiB9NVUy6TaVq8NsSqWaiAIxsjSfiCboQtoi08tlBgrlzNKdDwZtl+S0NbUs" +
       "UHH/6ti+gzfU/byI1A6QWknpQ3FEEIIBkwEAlKaHqG60JhI0MUDqFZjsPqpL" +
       "gixNWDPdYEgpRWAZmH4bFqzMaFTnPB2sYB5BNz0jMlXPqZfkBmU9lSRlIQW6" +
       "znZ0NTXswHpQsEICwfSkAHZnDSkekZQEI4u9I3I6Nn0TOsDQsjRlw2qOVbEi" +
       "QAVpME1EFpRUrA9MT0lB1xIVDFBnZH4gUcRaE8QRIUUH0SI9/XrNJug1gwOB" +
       "QxiZ5e3GKcEszffMkmt+Pui+dM+NygYlSiIgc4KKMspfCYMaPYM20STVKfiB" +
       "ObBqVfyAMPup3VFCoPMsT2ezzy++feqKNY3HnjX7LPDp0zO0jYpsUJwcqnlp" +
       "YdvKi4tQjHJNNSSc/DzNuZf1Wi0tWQ0izOwcRWxsthuPbfrdtbc8TN+PkopO" +
       "UiqqciYNdlQvqmlNkql+FVWoLjCa6CQzqJJo4+2dpAzu45JCzdqeZNKgrJMU" +
       "y7yqVOXPAFESSCBEFXAvKUnVvtcENszvsxohpBou0gBXFTF//J+R9tiwmqYx" +
       "QRQUSVFjvbqK+hsxiDhDgO1wzMgoSVkdixm6GFP1VO5ZVHUa2ySMN6M5aVNF" +
       "KIsSzxyLRADMhV5XlsELNqhyguqD4r7M+vZTjw4+b5oJmralKyNnAfVmi3oz" +
       "Um8G6iQS4UTPQi7m7AC2I+ClECarVvZdv3Hr7mVFYBbaWDEAUwxdl+UtF22O" +
       "K9vxd1A80lA9sfTk2qejpDhOGgSRZQQZo3+rnoK4Io5Yrlc1BAuJE8+XuOI5" +
       "LkS6KtIEhJOguG5RKVdHqY71oKKLgr3aoF/FgmO9r/zk2L1jt/bffG6URPND" +
       "OLIsgeiDw3sx8OYCbJPXdf3o1u567+MjB3aojhPnrQn2UlYwEnVY5p12LzyD" +
       "4qolwhODT+1o4rDPgCDLBHAKiF+NXh55MaLFjreoSzkonFT1tCBjk41xBRvW" +
       "1TGnhttjPb8/y3aaWrhmWl7E/7F1toblHNN+0c48WvB4/o0+7f7XXvzrOg63" +
       "HfprXWt2H2UtrnCDxBp4YKl3zHazTin0e+Pe3nv2f7BrC7dZ6LHcj2ETlm0Q" +
       "ZmAKAeadz25//c2Tk69Ec3YeYaRM0yVIYmg2pyU2kMoQLYHd2Y5AEK9kcHU0" +
       "m6ZrFDBQKSkJQzJFz/qsdsXaJ/6+p840BBlqbDtac3oCTv289eSW52/4pJGT" +
       "iYi4XjqgOd3MIDzTodyq68I4ypG99eVFP3hGuB/COYRQQ5qgPCoSDgLhs3YB" +
       "1/9cXp7vabsQixWG2/rzHcyV1wyKe1/5qLr/o6OnuLT5iZF7srsErcW0LyzO" +
       "zgL5Od7otEEwhqHf+ce6r6uTj30KFAeAogjZgNGjQyDM5pmG1buk7I+/eXr2" +
       "1peKSLSDVMiqkOgQuJeRGWDe1BiGGJrVLr/CnNyxcijquKqkQPmCCgR4sf/U" +
       "tac1xsGe+OWcxy998NBJbmYaJ7EoZ1xoV6QGruWWcS33dyEsv8bLVVicY5tr" +
       "qZYZgizbY60VIQQ981rKKZXmB3gMon2ZIQOCsZQG3xu1korzereKu5t6/2wm" +
       "DPN8Bpj9Zj0U+37/q9uOc88ux3CP9ciy2hXMYVlwhZU6U4Uv4BeB6394oehY" +
       "YS7ODW1WhrAklyJoGtrJypCcPl+B2I6GN0fue+8RUwFvCuXpTHfv++4XzXv2" +
       "md5q5pnLC1I99xgz1zTVwaILpVsaxoWP6Hj3yI5fP7RjlylVQ37W1A6bgkdO" +
       "fH68+d63nvNZ3iFuqgLLTWfENAwMufmzY6p05Xdqn9zbUNQBS0UnKc8o0vYM" +
       "7Uy4aUKibGSGXNPlZLC8wq0cTg0jkVUwC1gR9yt4S2dIMLkOi/W86SIs2kxb" +
       "bvmKDokVrYFedonlFJeEeBkW7YX+FDTUo1qUCxLlz3MZmePOvtKQg0IWDHuY" +
       "dXb73IL2forBaR2XKBmCG98ICA5uQ9OJ29WW8lefOW5BQ/1xw8cULzjp0RAA" +
       "eLHdAUCfCgDMhgW8cgZm3XlZLz/9cBKvh39/4R8evOvAmOm3IVHIM27uf3vk" +
       "odve/k/BisjzTJ/A5Bk/EDt83/y2y97n452ED0c3ZQt3CpA0O2PPezj97+iy" +
       "0t9GSdkAqROt04Z+Qc5gGjUAO2zDPoKIk+q89vzdsrk1bMkltAu9kdHF1ptq" +
       "usNNMcsLLfX5xreQWJs1+99tfBHCb24Ptb+g0YxEVSdszXTsaOfp7OimMxfx" +
       "TizuQJbjfiy/Nw0s9+ZYTvixvOsrsKyxWNYEsNwfOhFBo0HEhO9EHJgGEe/D" +
       "4iCy9J2I+6eB5Y9zLH0n4idfniXfb80h5p6L2P8+LH/qTMTqwn1M0GgGvtgl" +
       "KX5CPvgVhKyz2NQFCPlIqJBBo7mQgq+9PPrlhZyHtavhqrfY1BcIGcntMzHc" +
       "NXcqjKao3vD2jyY/uXXXRVHcOZWMYliEiFvn9OvO4IHpHYf3L6rc99adPOe3" +
       "ST/un8UX4W0zpPIGP3vFlE5SBNmT0s8NERZ2re29fZ3xnm4/WJ4IgSXrLxJf" +
       "hjuweNIRg/+qiOfMzCWGa+kkmPguCjrW5Env5G37DiV6HlgbtZbzzQz2Y6p2" +
       "jkxHqewiVYGU8lbhLn6Q6yxpb9Tc/c6vmlLrz+TYCesaT3OwhM+LYXZXBS/s" +
       "XlGeue1v8zdfNrz1DE6QFntQ8pL8Wdfh5646W7w7yk+tzbW24LQ7f1BL/gpb" +
       "oVOW0ZX8FH55bl5rbfNKWfOa8vqCY1BBsT1oqCd9s3cn+Oyb/HYJTJey53OO" +
       "L4fkfieweAEtRhcUAw+ubJq+x52OM7w4ZVnyc/krwQK4xi0Uxs8cwKChIRi8" +
       "E9L2FyxOAj4KP9OTJswDvB4suky9+iCSjqpSwsHmzWnABhcCsgiunZaCO0Ow" +
       "+VJhiHOrC6EYAsu/Qto+xuIfEIZTNLcKOth8OJ3Y7LE02TNl2ARRDNY/Eg1p" +
       "K8bKzyxsrMXXwebzacCGL9Ar4DpoaXJwyrAJohiif11IWwMWFYxUATZXSrp5" +
       "/IcdpRxCkcrpQmgpXJOWPpNThlAQRf9ozq2BQ9EYAtMSLCA+l0sGLFNSwgxI" +
       "G10ByROcyoZUVaaC4sfu2qyD7bxpwBZXQ7IEriMWEkemDNsgisHY8pOQyNoQ" +
       "bNdhsRqwBRPkx0t8mAPRmukKXvPhOmopdHTKIAqiGAyRxGG4PASiViwuZqQo" +
       "obL88BW5ZDrROW7pcnzK0Ami6FG+yNlbeE5jI10hOKETRq7yxWnDNODEdzIY" +
       "5k9YWp2YMpyCKJ4uiG0JQed6LK7BrVpuHXzXAah/Sg4gAXvIWPHF0tyCj3fM" +
       "D07ERw/Vls85dM2rfMOT+yikCrYuyYwsu8/WXPelmk6T3FFIlXnSxk/tI5SR" +
       "Om/ODKkh/qGMkYTZbZiRSlc3hq8J+J270wgID53wVjanGiK+a3NsnhlmzQ3A" +
       "AjcSPJGYdToAXZvL5XmbMv41lL2BypjfQw2KRw5t7L7x1NcfMF8wi7IwwU9g" +
       "KuOkzHzXzYniJmxpIDWbVumGlZ/WPDZjhb1drTcFdsxzgWMnpBUsSsMpnO95" +
       "+Wo05d7Bvj556dEXdpe+HCWRLSQiMDJzS+HpalbLwO53S7zwXQ5sWPlb4ZaV" +
       "Pxy/bE3ywz/ZRw2R/FNrb/9BceCe1zofG/nkCv75TQnsxGmWH/teOa5souKo" +
       "nvdiqAatS8DvojgOFnzVuVr8HIGRZYVvxQo/4qgAY6H6ejWjJJBMNWyQnRpz" +
       "Jjz71oymeQY4NdbUYfktLLqyiD7Y32C8S9Psl4YdGnera/2TCLTTm/kt3t3y" +
       "f0wxon0YKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OdNAkK3MziYjXlm4yFrYEa21LZG7Zt0iYDTzthqTwNN50oo6RCetU7JGDruJ" +
       "0cGTZNnTpzFt5uN8nfOOMbFTD+9z0iq2R5YAcbO+sN1IdSVYyEMlTHOdIx0P" +
       "XYZsSHoO3WuBnFtrKR10t2212spgrXgqOMa4OcEyBtmf5Cw49kRLIhK61WA7" +
       "ebJmWiE3s6SmIK5maQZJg0aW5JAwT+A5NKQCCeqhsoqp9dzVRpBjYrtOa8E4" +
       "YTqyuTEUqbTYCt146jo7xfARMWK7/Z271emhk6/iVdAd46O5wK92KeNCTV9H" +
       "+Pa4rW657WSCkhSXMc7cyyfbvEi0M1tl+CalSEteMyOC8DOj3+EbMNZle7PQ" +
       "avLKqFwNhOAFRiwWNmRGjaiRabUkdZ0aP2WQ6tPJ127vc8wD1eel4y1WW6tT" +
       "Vvyb2/jikp7/wP3jB375ZCW3+rsPOLNb59SHv1OLP0C54vn4rTZUVaudr3zq" +
       "pZcV+ufr+4cLT+MIuDdyvb9tqTvVOiXqciHpuVuvI5HVfrKTxZzf+NT/enTx" +
       "A5tP3MaGlw+cwXlW5C+RX/rN0ffK/3AfuON4aeemnW43dnr+xgWdy4EaxYGz" +
       "uGFZ5/FjzVZfmR8pDv1Qs/rZT6onQ3rhN/Az63p7Bw1uvfpJilFgpM2q8zcv" +
       "WBT872Xx++UABaITlptqztjYf73t5dDfvXER4P3FkR2yz94e9qcJfPuCuv9d" +
       "Ft8qyDnVZiEjV8/9lrlzDeWE8B+/BcLl53zg8eL49CHhT98G4dOu+Uas//KC" +
       "ur8qi+9EwCVdPV6mOKH3F28HvRcP6b34ztDbu+eCustlccchvcM1j2N6e3e+" +
       "BXrV+scHi+MLh/S+8A7RO7uWf7ruobK4EgH3FfT6RnCwOapsuD4hefWtknyq" +
       "OF45JPnK20hy78Rzq40pe09ewPTpsnh/BNxjhEVwNZRznfNuyXUtVXROyD/2" +
       "FsiXkRh4sjhePST/6jtDvtqMsXfBrrS9clfa3nMF+WKYq50sVbcTluBbddNH" +
       "i+Orhyy/+s6wXFdMnr+AZSlnrx0Bdyhu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dMZRO28Hwa8fEvz620jwjpPE7Mw2q73RBVTxskDPpYq9BapVelbGpG8cUv3G" +
       "O+mu7AUEl2VBlSuyx3H39ROO9G1tJirUNBezcsPnIzf9A8XBpn/5V1++cs/D" +
       "Ly9/t9onfLwx/14CuEeLLev0lppT55e8QNWMCtu9BxtsvAr7D0bA1bPbtIuJ" +
       "v/wpwe19/KDZ9Qh416lmRfQ5PDvdSCrAF43KU9k7SsBOLfcebBVK927MmY8U" +
       "BTz4Roo6lWY/c0NyXP1HylEiGx/8T8p1+dWXJ9QPv97++YN9ybIl5tVWiXsI" +
       "4O6DLdLHyfBTt5R2JOvS+EPfvf/L937wKHG//wDwiYWdwvaB8/cAD2wvqnbt" +
       "5v/64V/7yC+8/AfVYv//B1+6aj4qNAAA");
}
