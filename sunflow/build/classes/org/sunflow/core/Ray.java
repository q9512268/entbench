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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A4hVSsNMG7FSg8t6toi7m3v+ai77F/h0MNtNfyT+g77Xtx7n87gMqRufo8oq" +
       "FzGv0odcJFJruvAVfCJw/Q8vNB0fmEtsfau1zs/PLfSahlGxJCQzz3cgvqP+" +
       "nW0HTzxuOuBNhDyN6e593/sqtmefOTfNbHFhQcLm7mNmjKY7WGxA6xaEaeE9" +
       "2j44suNXj+zYZVpVn5/7rIXU/vHX/ns8duDd530WZGBJVWC54YyYgYEEmz86" +
       "pktrvlvz6731RW2wMHSQsowibc/QjqRbJqS7RmbQNVxOHsofuJ3DoWEkshRG" +
       "AR+s9yt4zboQ6ujHYiWvugqLVWYsrziz6YcPrguaUyusKbAiZE5h0Vo4e4K6" +
       "ehyJcjui/PcsRma6s6M05I2QucK+Y7ldP6ugvo8i8SznFokhKElYbHZQGpg8" +
       "lK63XL3+7FEK6uqPEv5M8oKL1kPc5atg2nFXOXt3zR5z+LNyzHjzMk5+GuEk" +
       "TI+9ctWfHr73gVFzBobwiaffrM+75cE73/9PwUrG80MfivH0748fPji79doP" +
       "eX8nUcPeC7OFWTqksk7fyx5LfxJtKvl9lJT2k1rR2v33CXIG059+2PEa9pFA" +
       "glTl1efvXs2tWksuEZ3r5TiXWm+K6CaOYpZHEnX5oTaXWJsn+9sdahHCb24P" +
       "jbag3oxEVYeAGpyoueN0UTN29ibejcVOVDnmp3LX16DynpzKcT+V3z8HldWW" +
       "yuoAlXtDByKoN5iY9B2Ie78GE/djcR+q9B2IA1+DyoM5lb4D8eCZq+T7pJnE" +
       "3CsR+9tH5U+dgVhauP8I6s1gLnZKip+RPzsHI2stNbUBRj4SamRQb26k4Bsv" +
       "j565kRfg04vgqrPU1BUYGcntD5HuYh0Ko0NUr3//JxOf7dz1zSjueKaMIC0C" +
       "49Y67boyeIB59+H7G6fue/cenrzboo/45+NFeHsxJOUGPwvF5ExSBNmTnM8K" +
       "MRZ2m2t7ejsS3V1+sDwZAkvW3yS+6K7B4mnHDP6pJJ4zLJcZrqWTYArbGHTM" +
       "yNPXiTv3HUp2P3Rp1Fq8NzLYR6naxTIdobJLVAVKyluFO/nBqrOkVdx9SUOC" +
       "ZVOFRz4oZV7Aoc7S4OXaq+DZO/8++4Zrh7ecxXnOhR7fvSIf7Tz8/LrF4n1R" +
       "fjZsrqAFZ8r5nVry180KnbKMruSn2E250aqxg2bIGq0hb4Q7YRLE2EFdPSmY" +
       "vXvA377paqfAdCl7Odf4Ykj+9hIWz2Ec6IJi4DGSLdP3ANEJ8efPMa/9XT6b" +
       "z4FrzPJ57OzhCuoa4vFbIXXvYPEGoKHw8zRp3Dw868Rig+nw9cCGI6qUdJB4" +
       "87yRQOomjXDdZblzVwgSZ0QcXFltiMQQEE6G1H2ExQdAnEM0t245SJyYPCT2" +
       "WHbvmTQkgiSGePt5SN2XWPzbQsJaHB0kPjlvJPhyuQiu/Zbd+ycNiSCJwd5G" +
       "SkPqyrGIMFIJSKyRdPNUDRumcnhEopODxwK4JizrJyYNjyCJ/pzLR5o7Pi0E" +
       "lBlYVDNSJhmwmEhJk0jaXUTiIZXSQVWVqaD4qbsp6yBZc95I4gpF5sN1xPL7" +
       "yKQhGSQxGEm+DYksDkHyG1jMByQhvPghDe/mALJgckhnNlxHLfOPThogQRKD" +
       "AUlxp5eHAHIFFpC8FiVVlk87kdjkYXHcsvz4pGERJNHjapGToXtOJyMrQ1BZ" +
       "jcUKX1RazhsVnv0jGb9m+fDapKESJPF05NMZgkU3Futwe5Nbm95z4Gg/hyM6" +
       "wBWyP3yHMqvg7ybmXyTEJw7VlM08dOPr/FVm7m8MlQlSlsrIsvv0yXVfouk0" +
       "JXELK82zKH5CHeljpNabf0LihV9oYuRGs9nNjEx1NWN4JM7v3I1uAeOhEd7e" +
       "qtnZrWv7aJ6qZc1kOreXsuEi008Hl2v7tTBvg8P/v2NvRjLmP3gGxCOH1nfd" +
       "durKh8xXp6IsjPMziqkJUmq+xeVCcUOzIFCaLaukfckX1U+WL7I3dHWmwU4w" +
       "znFlLNdB/Gg4hLM9rxWN5tzbxTcnrjn64u6Sl2GvvYlEBEYaNhWeP2a1DOwP" +
       "NyUK31vAZo+/72xZ8uOxa5elPvqLvRmP5J/retsPiOWf7xlfYERiUVIOm3zY" +
       "q9IsPxhdM6ZspOKInvcSpGRQzSi5v/lUY6wJ+L8ejooFZlXuKb52Z6Sp8H1Q" +
       "4V8RKiB0qL4apaOYKs/2L6Np7lqOat92vowjyhBnA4lOTbNfhLVx1DUN51CE" +
       "T6Sb/g9ZTpyamCcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7a6zs1nUez5F0JV3LuleyLSmyJOvlNNakl/MiOWPZiWeG" +
       "HM5w+BpyhjNDp7nmazic4Wv4GpKpktiAY6NpVaORYzcPoS0UNEmdyCgSNEVh" +
       "V0XRxkGMAikCp03ROEgL1GlqNPrROKjTpJs8z3vuuUe6kXSAvYfk3ntxfWuv" +
       "tfba3Ot86dvQXWEAVXzPzkzbi64ZaXRtbSPXosw3wmsUjfBKEBp6z1bCcAKe" +
       "Xdee/vKVP/vu51ZX96FLMvQexXW9SIkszw0FI/TsxNBp6MrJU8I2nDCCrtJr" +
       "JVHgOLJsmLbC6HkaetepoRH0LH3EAgxYgAELcMkC3DnpBQa923Bjp1eMUNwo" +
       "3EI/Cu3R0CVfK9iLoKduJOIrgeIckuFLBIDCPcW9BECVg9MAevIY+wHmmwB/" +
       "vgK/9IUfvvrP74CuyNAVyxULdjTARAReIkP3OYajGkHY0XVDl6EHXMPQRSOw" +
       "FNvKS75l6MHQMl0ligPjWEjFw9g3gvKdJ5K7TyuwBbEWecExvKVl2PrR3V1L" +
       "WzEB1odOsB4g7BfPAcDLFmAsWCqacTTkzo3l6hH0gbMjjjE+OwIdwNC7HSNa" +
       "ecevutNVwAPowYO5sxXXhMUosFwTdL3Li8FbIujRWxItZO0r2kYxjesR9MjZ" +
       "fvxBE+h1bymIYkgEve9st5ISmKVHz8zSqfn5NvuRF3/EHbj7Jc+6odkF//eA" +
       "QU+cGSQYSyMwXM04GHjfc/RPKw995bP7EAQ6v+9M54M+/+Jvv/6x73/ita8d" +
       "9Hn/OX04dW1o0XXtFfX+33ms96H2HQUb9/heaBWTfwPyUv35w5bnUx9Y3kPH" +
       "FIvGa0eNrwn/fvHjv2z8yT50eQhd0jw7doAePaB5jm/ZRkAarhEokaEPoXsN" +
       "V++V7UPobnBNW65x8JRbLkMjGkJ32uWjS155D0S0BCQKEd0Nri136R1d+0q0" +
       "Kq9TH4Kgd4MCPQjKfdDBX/kbQRy88hwDVjTFtVwP5gOvwF9MqKsrcGSE4FoH" +
       "rb4Hh7G7tL0dHAYa7AXm8b3mBQYsKNm1QrH8t59kWqC4utvbAwJ+7Kx528Ay" +
       "Bp6tG8F17aW4S7z+q9d/e/9Y3Q/xR9B7AfVrh9SvFdSvAerQ3l5J9L3FWw5m" +
       "DMh7AywX+LT7PiT+LeoTn336DqAq/u5OIKw7QVf41q61d2Lrw9KjaUDhoNe+" +
       "uPuk9GPVfWj/Rh9ZcAYeXS6G84VnO/Zgz561jfPoXvnMt/7s1Z9+wTuxkhuc" +
       "7qHx3jyyML6nz8ow8DRDB+7shPxzTyq/fv0rLzy7D90JLBp4sUgBWgccxBNn" +
       "33GDET5/5NAKLHcBwEsvcBS7aDryQpejVeDtTp6Uk3t/ef3AkVZeAeU9h2pa" +
       "/hat7/GL+r0HylBM2hkUpcP8qOj//H/6D3/cKMV95FuvnFqtRCN6/pQ9F8Su" +
       "lJb7wIkOTALDAP3+6xf5n/r8tz/z8VIBQI9nznvhs0XdA3YMphCI+dNf2/7n" +
       "b/7BK7+7f6w0exF0tx9YCTDv9Bhl0QC96wKU4HXfe8IQcAg2sKBCbZ6duo6n" +
       "W0tLUW2jUNO/uPLB2q//rxevHiiCDZ4c6dH3vzGBk+ff04V+/Ld/+DtPlGT2" +
       "tGJBOhHaSbcDL/eeE8qdIFCygo/0k//x8X/4m8rPA38JfFRo5UbpdqBSCFA5" +
       "a3CJ/7myvnamrVZUHwhPa/+NBnYqcLiufe53//Td0p9+9fWS2xsjj9OTzSj+" +
       "8wf6VVRPpoD8w2dNfaCEK9Cv+Rr7Q1ft174LKMqAogaW25ALgFdJb1CNw953" +
       "3f37/+bfPvSJ37kD2u9Dl21P0ftKaWXQvUC9jXAFHFLq/+DHDiZ3dw+orpZQ" +
       "oZvAlw8ePdaMQimg+0F55lAznjlf/4v6qbJ+tqj+xpGuXfJj1ba0M6p2+QKC" +
       "ZyblUknpEhDVhy6IIgPLAfaTHK688AsPfnPzc9/6lYNV9ewyfaaz8dmX/s5f" +
       "XXvxpf1TscwzN4UTp8ccxDMl8Hcf4Por8LcHyl8WpcBTPDhYzx7sHS6qTx6v" +
       "qr5fzPxTF7FVvqL/P1594V/94gufOYDx4I1LOQEi1V/5xv/7+rUv/uFvnbO+" +
       "AF/jKaXp4edVJfMfu0D/6aJql031ovrwwQwib0mHPnw45R++QIeK6iM3a8ut" +
       "hp6BsF9ysF/evy+CHj69yjog/gAREIhfG0ftj9zULhmF3TRKjqYXyOfjRcWf" +
       "yGf8dshnfAhyfPvyudXQ8+VT3EplVZLWLwC6LKrrJ0A/cTtAD/o+Ut7dd7EJ" +
       "94tdyMmC/8j/5Wz1U3/05zd51DJOOceqz4yX4S/93KO9H/iTcvxJwFCMfiK9" +
       "OWwDO7aTsfVfdv7P/tOX/t0+dLcMXdUOt4OSYsfFMiyDLVB4tEcEW8Yb2m/c" +
       "zhzE7s8fB0SPnXUrp157NlQ5MWdwXfQuri+fiU5KzXkMOoymj35Pa84eVF74" +
       "t3DQxeVHS6JEBO176bGHuHoy49s3mvHN7fOze3P8ZOfxk74D/Pzom+MnP4+f" +
       "H/tr8HP/IT/334KfT78pfvRz5+sn3gF+/u6b4+fc+fp77wA/P/Xm+Dl3vl56" +
       "8/yU0f/D0MEOADr6PYefn7mAn+874ufOiLHc8zj62b8GR1cPObp6C47+8Zvk" +
       "SDlXh/7Jm+foe4qnFVAeOOTogZs42jvezxRu8drQjQzTCB78o3/0ync++ZnW" +
       "fhGh35UU7hN45qsn/di4+PL1E1/6/OPveukPf7LcwhyR/sXz0d1RogNRZ1h+" +
       "RCvCIMtV7CO4dxO8OKQ59jzEv/SGiEsiAAygWr+GXasW9792AR8fLapXi+rL" +
       "Rww8vLa1Z48CQskIQrCiPbu2saN45BT4g09hZ5gk3jSTQOL3nxCjPdd8/if/" +
       "++e+/vef+SYQN3Uk7qL3PwNKwX83/9ffV9x85fbwPFrgEb040AxaCSOm3MgZ" +
       "+jGkzimmSaButvcWIEVXf2PQDIedoz9aUnr1nZYKjsHlUSWdwa4gjAbpgLQo" +
       "b4wN8XQ06ZEU0dK53GxbDDPqclzc5ubxJNEbLOanbXZTXYlUrxr1SdNUBMli" +
       "g5E11HpjaSrY0taSBtXO0J5YUwGNjJEnKrMNoYyj6ZhI4GVDbehOO9FhJqMq" +
       "Da0RYgwMrx23DlcctYFTrc10nC3zLUNZKpGtBSeLdq5HNBSckuzNbt1NzPqi" +
       "10yq62atspjMJX0gTjfwVmjO1gQiMKSlCtxsU522FEqTTNOiRK+ZiBSvelXF" +
       "7rYFsisqgThBZVrY6Momk4SFX9tunBHOb/r8Bt92Gamq5DiuLMa26eNE1w5F" +
       "hFr2pUa8nXVHm6k0azDKBKNrai5JCyaqNpuxiQyUtC+vhOHKdXqTAYHQ3Vkw" +
       "ROPpaoKoxGo2m6aOM0uD5VDqm5OAqGnTMYtXZabuzis7PYjBbccaeWs6dgNS" +
       "ILdea+wz1DRmWnMxmUQ0qS+H2pTSVlOpzpLOiqtX16a3XrBivRa7fWm1FGSJ" +
       "ie25ja276tTbON6GZGjGnHumg25olWgPeup4OpTDRu662kCtTOxkIrboOZ3D" +
       "XmJVYDkKljWEUBKfWiuTqrfeWCTT74iTVkeMOFzC9RklM9X6FN72u+twvvVp" +
       "08rYWcbqanWFW2EnY/hdnebNnVcjdbQh7kyXIBqwyGT9cRupoaMuMqkpVX/U" +
       "99ROLXW4AFUG6tLUBqNsvMM7bWqKazOpPoqq9mjjE3QyqWX8Wk7MjjqOJgJb" +
       "V3vKtDYLe3yvU6PC1dBMRlN6Nx9vWrK5lSdSZ9Vx5YFsToeCUq2Oo52N653O" +
       "uhpxcYpmPSmeaj0u72UDIWGyJiU4Tl1GBK3Z4DIU8dpR5kaiLxA7brHpz2bV" +
       "ZeZXnXjpRxTpbAlkNfBNfYRozmDVdXiawUTTrLox4qu0jFSi2JUsVNUrOyRs" +
       "VTU3V3WzFvtZRyUsbbC1K0qdDhy0x1S9ak3Ad+GAbyE5H67QwLdmQUfjmYxw" +
       "icxf6cYsXw/qaKWZD9CFLEx1qiNO5WmuLKw1Z/dZBaGY9lyaemrQUegRbvcZ" +
       "u64FAVc1/UZP26xkn49rjG9iQ25q5bmQTbfwrjr2px1ibI+7bWQkTuMaNpnh" +
       "OIyjATEdbZs9uqb1p2KrxcGk4XA4GvnkSifGMjFldXS9rZgwvrXEPjdiSLe3" +
       "XPV9di2EMiXOAq/Rx/sVbsv7wDAUD13PWkDhh4sZG2ysVmb1d/X1Zmx2eFbD" +
       "ktlsQRr1rTuaoCZtJmEjiLaiRs7XXbzb4vWWXxEUsdOWNw7vLccLsWcIva6G" +
       "4upsMdzJTbXJyb22IMfKpFFLJFVfa9JYWXlea9qR1kRV1Xx1bG91dFbLWx7e" +
       "zOF5Qs/gZWiMpNFw0+vs8h4RD3eV+W6+qTCiPwqtyXgkdHESzWdBuuhgjWhB" +
       "aEBN0LAC10XMZFXHJ02J60hqF8NTajvZzHK9GqCZ0pB1g54Md3A4pRqUoy1r" +
       "7RUlVbu8u6TYBkrnHN5c0cgu4vFJlnu5PbK8/tDEM7nDEFyCT/htxiZYsFzw" +
       "w23FHg7wkSTxvZya1Q1hvlvINV0XkJ3DbddRmw8zHcelHVuLc7NRM7FxiwXq" +
       "4uBkLzTofMUv0WhuwD2Wh5GIWyxVPxkrtVqgiTWHtqryeIZX3TXuuW0SG48W" +
       "Ul1NG17FGLSphh41XWJACyo6muVkuJp7neZivKCxIDZqSZLw9XSUCPNRSpI9" +
       "V9I7jkggAWssNpJMboc22o3DGTNuUQBVusT9xCa7GiWKG7fnEWmqu6kcVtai" +
       "D6Op314w3a5j1AdkFePHPZfT5kFPbiQ0joQNW5sQE0LXO918ZjsbJ8aHDUcK" +
       "zGitEHodacUs3/BnRrfrkdu1sGEWvpwnvbHYbdV6mAuHOhLr6UTPprN8scAq" +
       "CQP8cbQkBbyRJH4q6fBAqLZTBWYmg0Q39Z2vWKm9nPXykZlY8tyT/X4zXSmD" +
       "JRIqiKrE0nrexIml3/F2lp/oXNSRI6dVpbvKJHPbrXq7wtV5WqxON/XNYiv3" +
       "pWFk2i3b72c9sr3FOwwvB/NA8rc4V/NIQaw1bGHcXDdWBoq3RaXNKM22xcEN" +
       "2qFRBKmwuMoDU1wxsjYiielmtm327e0qYrvwzukhDqXTYX/ldOsGZa8cYs5u" +
       "Jk46XXXW9fWMGdq2IUwYSzUS2e52mitJDFmGxPqi2YrQyLMwp5FUFAvD+vCq" +
       "yrARu8wmFRPD5lGKuS3MZLZCvPRa3rafk0nV0zWqTwVx0pGWPWoHj1sJ260u" +
       "HSIKl0pcy0OYp5eisrLJlOqN87yhmcmWr7iz6mCSpzEXd9kVnrGogbQbcLiN" +
       "HGPJTZasOuivxhrtYA7rrEcLbEamHTRVCMUg2vV1sxnG7HxdyRey5EsuAmPB" +
       "cD6Fk8EcdsOWHuM60qjOZLJLSbMe0lxkC3NBEE7eQv1NFCR2kqNYoybM6jtm" +
       "II5DMGuqBo/XW0GltiImOOqYlVJuEHrLmGrg3ozYhCuB7AiVsJ1FzVz1xmi8" +
       "HiysWRKbW1qaLcIgt3J0ofGBGSvTLA5HaseSwVpQlbym0RyhxiqjtHVswbwW" +
       "Co6ChihTRYb1cayNKgvM1nk0NhOvZbXE3O17m9WIsBfqQB6TvtmyR2hjTjcq" +
       "WJ8YofGWJxKEaXkjurbhNUSJzLrbn3PzqJELSF6h2SwfrHNmg1TImNhMhpW2" +
       "Fs2WgwBrmFI/73rqzlKWy4CpYIhGYA24ze+mAdmqMksrGVSxZmvJry2srXu8" +
       "MW+5U403ehjXn022m3CDLbMUoZcpFY0Su21Tk/qmFgj1pNHozYdkFWlX6jyh" +
       "tP1+x7Qnds1YJvOwHs02YUzIjQCZWPOZUxmhPYUDFjkg3DniTZT5jArdSjvU" +
       "lRUIPupNfq0qZsNLCWlhdEg/82KDrU4nbL0NdBa4cU7CXcdv0PMaimeun4+0" +
       "SUVq5K2Brc9mWex17HmEd7ORxyLWot2tDw2sRRIwWAGEyra479QqeOYxiK02" +
       "8ZbRk7eVCeZTLtHohUKlHQ2QaUU3pZUS860hGtZM2pVHFlhv+DwcDOthxKrT" +
       "rrBuioojjNU6uml2w2SNoMhGWJrVZmJuA35a604XpOZGODKIF6vqyKuy06AB" +
       "w1TKLTE9r+XiOjZGCjPsVXvN9gLFVC8zhl0gwQFGosvYgDXDDYCmeXATGHzf" +
       "GIQpxU1Jfpf0ESIVu6wzcZnWiBHkulOPMGMdig2pVgnxndzZJLNGJlbQEdZt" +
       "Ou4A51Gfopo5TWlysJ1NFp1AJQcTJmP5uTVJGoOpX+cbgl/rb1tsTi8E1FXS" +
       "yVD3VIqWOtIos+M+B7vdbcBtJD1ti1OuJ0tcX8ibnixhHU/DxCY3V7YVXObg" +
       "VqXSlIMVZmjp3OVWArZMxOESm+QtmA76TbcmLNdyGGw7fbkVIK4UZLVWdeSq" +
       "IyaIRbdO1JGqsk3Nujokt9WV2hxjC4Em6kRf50VnkcyTTgPDfGW77Og9G+P0" +
       "ZXOxWVfaq+EsrxMaOqSsJk6KtM43OixBtYwlzyhwez5B1bzZD3KeQjAuX/Vi" +
       "T2kmfXU4nycLniC90WDXygW/ge9aaEuwzIq7a2s9cohuQVzVbbawTBhznrOe" +
       "47qs2rm0M0W5OtbmfTuymPGYIFCyNqgT6VjvuARTjepNRKSyBd+b1GcDNXEm" +
       "441piaTBR4jI1uczPlfHIaUMutUNv7YTil9l8diKYRmEhpnGWiJwpjpCihuw" +
       "9AfkkOkPKXGUCTrPTnEhdjR3RXg+h6e7UZOy8gC8il1nPQr2c1pAPIy3qoTd" +
       "tRcSzorUytk5xIraVNfKfDqxhvJcHEszaavgza0a+mjWlbU2Mmyafh8J2VrK" +
       "01g2Gq9IcZyShFPBF5sQ3wwysrZmutl4lfDmCjdgp0NTJogiXdZOB/SS4ycr" +
       "zxwLI7wztVMfMQadwbDf93utviWBbVkL2+jrzWI+0MIkb/okIVDsYK345MSb" +
       "RxyVMcG41pXX2nQ0rwlKvgolF2zgSLXtVJa44o8IsD/rVxGWkc3NtNGPo52B" +
       "gJCrjeRN0oRXGYPuurOMb2QDZpuYWKY682xCUDtMspkq2KnyAdyXwHrSYuyx" +
       "LdphMAyTpJrNpaUXb6rUnKBHrXo+GiC9gWGvfVZRl1XaWkltbxELZNh22TWR" +
       "1tgZ26QYLGkMa3HH4FaEjhnbyJWDWYIpFLqVtdqGC4w58HhWtQp8Uj3BognY" +
       "kLZ4OKmzibCmHb5hkmmPG9Tcpa7HwWjVSuc+OgzXPJNb2w01dbaV1JB62pTL" +
       "h/2eQivxZqlt5rVpZUZjw4Y+mDm7aXMHVgqbZvUuTJogemTaQTpjkShX04nm" +
       "BmsXbcaoaNfJJFnYRJdYKOxqZvB1pYZzO57NpiMQGHdkrwJj9VRuxVyqIIbN" +
       "J1s6ERweoeDAiELe4mZLDMQ+C0KwptKQcxr5Ytsehny60hlUDn1uNHQTTfRJ" +
       "YZyLFpLA9nSB7qgK3TLWnteX7Xk8UpG6jIp+a1AbN6WWMLK61S3dVHywDIxC" +
       "uE6jrI/ZW06J2vXE262zVdftNG1uorLLFS2lNXzKIrUeMUFFFTbb8sTPFKen" +
       "dTqdj5ZfTr52e59WHig/FR2nUK1trGj4l7fx9SQ9/4X7xy/88smpbPl3H3Qm" +
       "G+fUR7xTBzlQcXr5+K0SpsqTy1c+9dLLOvcLtf3DQ6RBBN0bef7ftI3EsE+R" +
       "ugwoPXfrMyGmzBc7OZj5zU/9z0cnP7D6xG0kr3zgDJ9nSf4S86XfIr9X+wf7" +
       "0B3HxzQ3ZbLdOOj5Gw9nLgMNjAN3csMRzePHki2/GD8CinkoWfPs59GTKb3w" +
       "e/aZM7q9gw63PslklCiw0mY5+JsXHPD9t6L6/WKCAsUNiwSZMzr2X277aPP3" +
       "bvyg/35QskP02duD/jSAb1/Q9r+L6lsAnFsm/li5ce53ycSz9BPAf/wWABef" +
       "5qHHQfn0IeBP3wbg06b5Rqj/4oK2vyyq70TQJdM4PnI4gffnbwe8Fw/hvfjO" +
       "wNu754K2y0V1xyG8w/OLY3h7d74FeOVZxgdB+cIhvC+8Q/DOnsufbnuoqK5E" +
       "0H0AHm4FB4lORcf5CcirbxXkU6C8cgjylbcR5N6J5ZZJJntPXoD06aJ6fwTd" +
       "Y4XAuVr6ucZ5N9hd2IbinoB/7C2ALzwx9CQorx6Cf/WdAV8mVuxdkGG2V2SY" +
       "7T0HwINpLrNSymEnKCtv1UwfBeWrhyi/+s6gnJdInr8AZUFnD42gO3QvOmOo" +
       "2NsB8OuHAL/+NgK84yQwO5MytUdeAHVY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("VN1zofbeAtQyPCt80jcOoX7jnTRX8QKA06Jii9PVY7/7+glG7rYSg4CYBCUr" +
       "kjcfuekfJA6S+rVfffnKPQ+/PP29Muf3OPH+Xhq6Zxnb9un0mFPXl/zAWFol" +
       "b/ceJMv4Je8/FEFXz6Zcg4W/+CmY2/v4QbfrEfSuU92A9zm8Ot1JBcyDTsWl" +
       "5h8FYKeObg/SftK9G2PmI0FBD76RoE6F2c/cEByX/3FyFMjGB/9zcl179WWK" +
       "/ZHX0V84yDHWbCUv0x7uoaG7D9Kdj4Php25J7YjWpcGHvnv/l+/94FHgfv8B" +
       "wycadoq3D5yfz0s4flRm4Oa/8fCvfeSfvvwH5cH9/wcgjhKnCjQAAA==");
}
