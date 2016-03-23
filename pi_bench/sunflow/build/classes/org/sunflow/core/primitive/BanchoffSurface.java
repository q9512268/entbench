package org.sunflow.core.primitive;
public class BanchoffSurface implements org.sunflow.core.PrimitiveList {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          1.5F);
        if (o2w !=
              null)
            bounds =
              o2w.
                transform(
                  bounds);
        return bounds;
    }
    public float getPrimitiveBound(int primID, int i) { return (i &
                                                                  1) ==
                                                          0
                                                          ? -1.5F
                                                          : 1.5F;
    }
    public int getNumPrimitives() { return 1; }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        state.
          init(
            );
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        org.sunflow.core.Instance parent =
          state.
          getInstance(
            );
        org.sunflow.math.Point3 n =
          parent.
          transformWorldToObject(
            state.
              getPoint(
                ));
        state.
          getNormal(
            ).
          set(
            n.
              x *
              (2 *
                 n.
                   x *
                 n.
                   x -
                 1),
            n.
              y *
              (2 *
                 n.
                   y *
                 n.
                   y -
                 1),
            n.
              z *
              (2 *
                 n.
                   z *
                 n.
                   z -
                 1));
        state.
          getNormal(
            ).
          normalize(
            );
        state.
          setShader(
            parent.
              getShader(
                0));
        state.
          setModifier(
            parent.
              getModifier(
                0));
        org.sunflow.math.Vector3 worldNormal =
          parent.
          transformNormalObjectToWorld(
            state.
              getNormal(
                ));
        state.
          getNormal(
            ).
          set(
            worldNormal);
        state.
          getNormal(
            ).
          normalize(
            );
        state.
          getGeoNormal(
            ).
          set(
            state.
              getNormal(
                ));
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                state.
                  getNormal(
                    )));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        float rd2x =
          r.
            dx *
          r.
            dx;
        float rd2y =
          r.
            dy *
          r.
            dy;
        float rd2z =
          r.
            dz *
          r.
            dz;
        float ro2x =
          r.
            ox *
          r.
            ox;
        float ro2y =
          r.
            oy *
          r.
            oy;
        float ro2z =
          r.
            oz *
          r.
            oz;
        double A =
          rd2y *
          rd2y +
          rd2z *
          rd2z +
          rd2x *
          rd2x;
        double B =
          4 *
          (r.
             oy *
             rd2y *
             r.
               dy +
             r.
               oz *
             r.
               dz *
             rd2z +
             r.
               ox *
             r.
               dx *
             rd2x);
        double C =
          -rd2x -
          rd2y -
          rd2z +
          6 *
          (ro2y *
             rd2y +
             ro2z *
             rd2z +
             ro2x *
             rd2x);
        double D =
          2 *
          (2 *
             ro2z *
             r.
               oz *
             r.
               dz -
             r.
               oz *
             r.
               dz +
             2 *
             ro2x *
             r.
               ox *
             r.
               dx +
             2 *
             ro2y *
             r.
               oy *
             r.
               dy -
             r.
               ox *
             r.
               dx -
             r.
               oy *
             r.
               dy);
        double E =
          3.0F /
          8.0F +
          (-ro2z +
             ro2z *
             ro2z -
             ro2y +
             ro2y *
             ro2y -
             ro2x +
             ro2x *
             ro2x);
        double[] t =
          org.sunflow.math.Solvers.
          solveQuartic(
            A,
            B,
            C,
            D,
            E);
        if (t !=
              null) {
            if (t[0] >=
                  r.
                  getMax(
                    ) ||
                  t[t.
                      length -
                      1] <=
                  r.
                  getMin(
                    ))
                return;
            for (int i =
                   0;
                 i <
                   t.
                     length;
                 i++) {
                if (t[i] >
                      r.
                      getMin(
                        )) {
                    r.
                      setMax(
                        (float)
                          t[i]);
                    state.
                      setIntersection(
                        0,
                        0,
                        0);
                    return;
                }
            }
        }
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public BanchoffSurface() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "is3N/wIK2Vd4lxwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVae8wjV3Wf/Ta7mxfZzQaSkOa1YUObmH5jezweWws0fozt" +
       "sT0ztsczfpSyzPv9nrHHpmkhiAYViSIIkEqQv4JaaHi0KmorRBValYdAlUCI" +
       "0kolCLUqlCKRP0qr0pbeGX/f5+/79oGipJbmeubec86953fPOffMvfPcj6FT" +
       "YQDlPNdaqZYb7cpJtGtY6G608uRwt9tHB3wQylLD4sNwDOouiw999uxPf/Z+" +
       "7dwOdHoO3cE7jhvxke464UgOXWshS33o7LYWt2Q7jKBzfYNf8HAc6Rbc18Po" +
       "Uh+65RBrBF3s7w8BBkOAwRDgbAhwbUsFmF4lO7HdSDl4Jwp96LegE33otCem" +
       "w4ugC0eFeHzA23tiBpkGQMKN6TMHlMqYkwB68ED3jc5XKPyhHPzUR9567k9O" +
       "Qmfn0FndYdLhiGAQEehkDt1qy7YgB2FNkmRpDt3uyLLEyIHOW/o6G/ccOh/q" +
       "qsNHcSAfgJRWxp4cZH1ukbtVTHULYjFygwP1FF22pP2nU4rFq0DXO7e6bjRs" +
       "pfVAwZt1MLBA4UV5n+UGU3ekCHrgOMeBjhd7gACwnrHlSHMPurrB4UEFdH4z" +
       "dxbvqDATBbqjAtJTbgx6iaB7rik0xdrjRZNX5csRdPdxusGmCVDdlAGRskTQ" +
       "a46TZZLALN1zbJYOzc+PqTe+7+1Ox9nJxizJopWO/0bAdP8xppGsyIHsiPKG" +
       "8dZH+x/m7/zCe3YgCBC/5hjxhubPfvPFx95w//Nf2dD80lVoaMGQxeiy+Kxw" +
       "2zfubTxSPZkO40bPDfV08o9onpn/YK/lUuIBz7vzQGLauLvf+PzoS7N3fFL+" +
       "0Q50MwGdFl0rtoEd3S66tqdbctCWHTngI1kioJtkR2pk7QR0Btz3dUfe1NKK" +
       "EsoRAd1gZVWn3ewZQKQAESlEZ8C97iju/r3HR1p2n3gQBJ0BF4SC63Zo88v+" +
       "I4iDNdeWYU+HB4Gbqh7CshMJAFYNDmNHsdwlHAYi7AbqwbPoBoAj0G2g3EKG" +
       "6zwgBsNh4sxOd1P78v7fJCepTueWJ04AuO897uwWoOq4liQHl8Wn4jr+4qcv" +
       "f23nwPj30IigR0Gfu3t97qZ97h70uXusT+jEiayrV6d9b2YVzIkJvBvEvVsf" +
       "YX6j+7b3PHQSmJO3vAEAmpLC1w6/jW08ILKoJwKjhJ5/evlO7rfzO9DO0Tia" +
       "jhdU3ZyyD9LodxDlLh73n6vJPfvkD376mQ8/7m496Uhg3nPwKzlTB33oOLKB" +
       "K8oSCHlb8Y8+yH/u8hcev7gD3QC8HkS6iAeWCYLI/cf7OOKol/aDXqrLKaCw" +
       "4gY2b6VN+5Hq5kgL3OW2Jpvy27L71GrL0F5xxJTT1ju8tHz1xkTSSTumRRZU" +
       "38R4H/vO3/4QyeDej79nD61ojBxdOuTzqbCzmXffvrWBcSDLgO4fnx588EM/" +
       "fvLXMwMAFK+7WocX07IBfB1MIYD53V/x//6F7z77rZ2t0URg0YsFSxeTjZI/" +
       "B78T4Prf9EqVSys2/nq+sRc0HjyIGl7a8+u3YwPxwwLullrQRdaxXUlXdF6w" +
       "5NRi//vsw4XP/dv7zm1swgI1+yb1hl8sYFv/2jr0jq+99T/uz8ScENP1a4vf" +
       "lmwTFO/YSq4FAb9Kx5G885v3/f6X+Y+B8ApCWqiv5SxKQRkeUDaB+QyLXFbC" +
       "x9qKafFAeNgRjvraoTzjsvj+b/3kVdxP/vLFbLRHE5XD807y3qWNqaXFgwkQ" +
       "f9dxr+/woQboSs9TbzlnPf8zIHEOJIpgdQ7pAISd5IiV7FGfOvMPX/zrO9/2" +
       "jZPQTgu62XJ5qcVnDgfdBCxdDjUQsRLv1x7bWPPyRlCcy1SFrlB+YyB3Z08n" +
       "wQAfuXasaaV5xtZd7/4v2hKe+P5/XgFCFmWusrwe45/Dz330nsabf5Txb909" +
       "5b4/uTIUg5xsy1v8pP3vOw+d/psd6MwcOifuJXwcb8WpE81BkhPuZ4EgKTzS" +
       "fjRh2azOlw7C2b3HQ82hbo8Hmu0SAO5T6vT+5u2EP5KcAI54qriL7ebT58cy" +
       "xgtZeTEtfnmDenr7K8BjwyxxBByK7vBWJueRCFiMJV7c91EOJJIA4ouGhWVi" +
       "XgNS58w6UmV2N9nXJlalJbIZRXZfvqY1XNofK5j927bC+i5I5N77T+//+u+9" +
       "7gUwRV3o1CKFD8zMoR6pOM1tf+e5D913y1Pfe28WgED0YR57t/uOVGrvehqn" +
       "RTMt8H1V70lVZdw4EOU+H0ZkFidkKdP2upY52F9sN0kZ/Pj5F8yP/uBTm6Ts" +
       "uBkeI5bf89Tv/nz3fU/tHEqFX3dFNnqYZ5MOZ4N+1R7CAXTher1kHK1/+czj" +
       "n//Dx5/cjOr80cQOB+8tn/r2/3x99+nvffUq+cUNlvsyJja67WKnFBK1/V+f" +
       "m8vFJZsktkJjFSVXY4tGsdE0WHxFTGVN45kRP/SKWLu+onSJdJtslCDeArOx" +
       "BInLK7ooK+OJPY7qE5vVrR6D9xjNdxl2orVqrstHE1MYdSc+wwa8roOWdlHl" +
       "dZ8bWI1mL8SVCC/CAjxHZQxtBrE/lmx0gS7iXE6eIUhxYY+tvDGfzemibzSG" +
       "dsK4ed4dF1uj4VhyFy1x0myTWJWc4l4+xpVcOUc7I8XsMgOz77Oz2qqnmh2s" +
       "ywQdY9RherrZxhNm1DZpNvFww7foZjkmG2ZhZGnNUT8x67y54kYzl/KdRr/e" +
       "NNsDE+frJJfn1+NaeVazVK/JNmyXQbtxi4LjTtzomRw3QZguB5uEDBeMRt0q" +
       "ekh/1htqoSXOWhVi3g0dTW8zS8xPaCwasfKY8PxVgoerVZ4roIuhULNCozRQ" +
       "3dK6OpbiDmsWxJphN0q+TgalyiwJC1zHFhOdNpEYicyiwxdxOTfCXd0j5801" +
       "rjlJt5Rvdun2jOtiEVPi+GZu0POsfFDxp8ti0kXnPtEwOoyjRziODDVhZndF" +
       "r1Af6pN1ISzPZ8K070gT3q8kQsmjEM2t5BbCQrNGAMx83+9O2Flh1Ko3hvzY" +
       "qDVUqlnoSRNqPMAxgyiPRqqYl73ANVdUj40kitK8EVvv8nVMkLSlWCZHDpvz" +
       "SiGHNehwLOaIMTWRUGZSGnI2vNJ6K5NgClGgBRSnzAy4uFy23W6LIse1SJcS" +
       "jih3dSsZeQJKz5cFySjhdRLMFT8LvbE3thi3IXVrdj4/Moes3dYqnbzVYIaW" +
       "b6lq0zWYpdsb8cvCcLQcmwbTbsW2oaNec9iatlS2Nhl5QXXeWjIYRTDICkWr" +
       "scLnCaGZQ6cU49XwIS2WWpMpu1jys6KTkMWi3ihr48qyzYTTUQFlbA1Vxh7R" +
       "qNeQXEmjbK1aqShBm5ogDmJ0PczT6/N44U51f2V3ND2isUY+Kse5vDc0WI+i" +
       "mLEId1ecuMr1J/pAmgzz+pgIDXwoNatxAxXGMIw0BoqLVPpm7NZZveyL+oyS" +
       "oqHr2xZl+k6OaE3cvlHjO6s6xxEOUlngdVbtLHDW1uYxPBmRPVUgGuwqWAVT" +
       "egLXeALX8Qbhxy2J1Xo+zJe6fXKqhImreTUCpA1leWR3c7mmaNAVwqNYpGlr" +
       "DF3W3RiYTzOsm61Ji9KIMmnOO6wu0Jo+oSbjtV0dFWatplXtLeMOzmNua2bV" +
       "ugXNGIhjk3KnVV9kREy34/mgXiNq1UIPDitRLeJsrlRgBjorrgdTZDotlSVq" +
       "me8aUrWhoh2ObCuEbdC4WOJFmqVzNGuqy57Eqx1aiJceRqqC3JTbhchelBqF" +
       "RXHckVm1aXl4ma31ut0i2mPmU0PEix0c63oosACFUxwnaudbTFtvUWqorlQ3" +
       "mc9QWtY6qmlYZjxZh72GaFC1SliVh7Wx3Sv3qBqq+a1aLuyNWD+m2ARB2y1H" +
       "NYstswePWyKNK6TfrKBSca3nRwVlYUSEGthapyyGallvYS2cLOKoii0YDMaT" +
       "VXlZlRfTTtkf0n4ZXqKxOKLVqS3GxIxerDulEvBTHxX7QWUuD6rN7ozPNUrk" +
       "EhcbPCEXkRw97eoMJkoegkeW0FTBVDr1kd0RiFUwYb1pt7qUBX9CFZuMUHdD" +
       "G23RQw3WBs3iYjCF19x0jXVNgVkPhbxjDKvjQlzsDht6qIsyP4pEPcrFbC3K" +
       "d5JydzDoOFGpgcaG2Uhm/qxLY51IE9VmvCQJJS5GylyOp00smUa1wmw48+gm" +
       "2bPY1SQoTusJXOsuB6SiNOv+jBDng7lXDkaNIkJYWjssV1YRS7meSa5duJ1X" +
       "7GXNnrldZqRxPcEdwDl/ijnFglBRBKOBTEozuVgIJkirXCtiwOPWyUpZKBSl" +
       "l2yiTRQlpbVeicvhQMpxC9yZaqzDEvDCjcvIYNEwK80KLtf8pTbmcJlcOh0V" +
       "rlFTMpfE3RgpI4lRLfbW+UWTl3slQeZ92e4Y5mIG25hiuFhnEgsTbI5SCDJk" +
       "OwHlIwRSm8ywOqpTYzPp4JJAtZfTudnuaAoK7Npcsno9RARbW68VAi1i9ahB" +
       "LoOh2tKEFqfl9fl6jFs65oelQIQVnrLWJZbB46VTEAg/GYQtzGmYDX0ltXWT" +
       "CC0nIpOIGjAz3504qtytVbQBURbr8mQtrGBlYlOVUXGeizsNrFgtVRTNEjye" +
       "78kkHVTq3IJGGnO34EULrcxVZ3UdgXt6qWmZI0fFSiGYzKGl+brU7uuSSvOR" +
       "xrrTqcNLMr12K4oxaVV5vs7Ox4LhDOvVaQysGK2uY22GVEtyiQ85kmMxpjw3" +
       "rAHoxm2NPXvM1uYoJ4vtaAj7nQW8jETUXBeTVUPhCwgzF0p01QoJg9OmdHOK" +
       "skgHXgRmjCAeLJCEng8rlY7Xgh1pyVGLAab1lOYarBbqmsgx3CKwSIRD1RnX" +
       "k4Z+MS41e8k8QRFfm9COmHTCgkqOUcrq5gs5b903qLVYFgauyNllusByM2WM" +
       "G6uOmJ+Q4xled3vWWOXtPDAxnRWooIKMhnJp4lUi3OOKszVJLscrI2HwJZrM" +
       "bL7RbNpcu0kr86gVgvSULo28dWwo634kwTjZbMylSsVZUghfWcCitIhojm+5" +
       "NIB+XdMGeY8k2wLed4eFQsvwGTTnDgdUKz/PVQXOyidVuCHWOuu2NFgEBSNP" +
       "dwzUz81H5TEXMxLXX1ZQq9P1CgUs5MzSCM4p4wQuVUSzWS+Rk0KtkrBG2/cN" +
       "gmu1xaBmlsBSUpuOuMG0vsQ4ODci2LwJy3S+5otLNx+UyM7McCZ2uQVsobCk" +
       "fTloLbEoGLcNMiFmfVbqGbnWeiqsFXEAt3uTxM0rBsyFklnIEbPVQuOFFrmw" +
       "p0XE6hGFidJXpfVwQRpB3TZLxdKwXR/ruXmkJG1G7tFkNyf0moSfj5jIGnDo" +
       "VB/YVkfX9EKJn6PqQC11SgnGqeVZUi8aK4sa1sflsMXIizDPrPGJPi5i/RbZ" +
       "Ear4GokZc9Tvxq6RYLVmzuqbtoao2HQ4DoRif91iZ3xtsugI+VVFWJPrQr/s" +
       "s+16LCVyjlZljCWqxipX96JyPXTgfNxqE2BBmiB6KanW0chpT8xamxBX/FDq" +
       "jp01ock0Ss8aRj1U4i7PCzgcYZJTY2c6Epf8AtqY4qUuXzNKWl5CJVruqX2+" +
       "PUnkeZvJeRZZQrjaopJfTri1HzMOPl2h1FqTJ0ONl6nyapX0ybE/LPfwXqGr" +
       "zzBTbVaiaOmPggHbHJmsmKgtmdIsux+jDaU/7KNrEHyaYrluhohvN3x6Qff0" +
       "XJlEh3U5oAKi7Xj5yagZOUaxpBX0Xh92JqNwCCJarRvi9RUyKtWYbtcJYjSS" +
       "RiQGD5Jmd+l3RlKRbiXlqCULioqGxSg36Ce50G8lSTXnJJWJQy24iW9ouGbN" +
       "q9FQRgzf7NSXPqF0CoW512HdAjyddE1GbgtU0xjyTStYFLUVPMIatlfpO/U2" +
       "vGiPpu2ek5jNdqgtdMHK6SB3b9carQpcaK+bQlx3GGytNj0biSWrBi/skZDv" +
       "rDFBqM2UluzZTWq1yJEhEZeNgYWM8GVFma77+QEWVLFEncY8yKRqBY3r+m53" +
       "uA5KK3GWr2LDiV0MBn1qKij+2mKiqL0gHTI0gyIm4o1Gr+LG066ACU1+MI5l" +
       "pgQCYrPIVWkLq/QLCh7jWrM2ciQUVt2lKQc0r5klIVfuoV05FPGxWVhh0lSs" +
       "0khQsSszWKnwJEqyC9GbTb1Zrk/gidhZu2sJIbXFohKrSk+Y4xwRtYdVshfF" +
       "Lt3DnEK/WuC7ZAPWkboI1nY7p+RLfl5OeljFNzC4Hwx5g5j6i4FWI7l6vYCp" +
       "1aqDI2iZmeXHQ0WtLgxa1El7auL5oYLpebZNicUyrkYsLy0TVCQKBZCy6iFC" +
       "wUuiV+SkkpUswUvhm96Uvi6+5aW9sd+ebU4cnBOBF/W0of0S3lQ3TRfS4uGD" +
       "Ddnsd/o6G7KHNq1O7G+E3H/FHvzBO3i2QQhe0u+71ilR9oL+7BNPPSPRHy/s" +
       "7O0JTiLopsj1ftWSF7J1qMczQNKj196MILNDsu1e1Zef+Nd7xm/W3vYSduMf" +
       "ODbO4yI/QT731fbrxQ/sQCcPdq6uOL47ynTp6H7VzYEcxYEzPrJrdd/BBNyR" +
       "4v1acJ3fm4DzV98Rv6qxnMiMZWMix7ZcdzKCnetMWYqDHMlBOmX7ZHceJmM2" +
       "/7UBkfUQXWdTd50WbgSdjj2JjzZ7/6NDBslF0BnBdS2Zd7bG6v2ibZXDvWQV" +
       "1gFsd6WVD4Przj3Y7nxlYDtx1NLvPoyHDRK2XZKPAj0pZcxPXgeR96bFExF0" +
       "mypHEzewpLobO1K4L/jeKwRn7bqj1t1kC9G7XgZEmSc/BK779iC675W3rGNz" +
       "fFJ3skOJpzPGj1wHno+mxQdAWAPwHASPDURXkXsKwMRHW1g++DJgOZtWPgCu" +
       "C3uwXHhlYDms3Seu0/ZHafFsBJ0DmlOxfaB8Rvz0VsePvwwdb0krsT0P2feU" +
       "V9477rsiqDAan9pw+mGGnEn43HWQ+Iu0+GwExhTIHh/Ih5mvZgU3LFxd2gL0" +
       "xy8XIGoPpH2wXgGATu6d7uwB9OorABrxq+08A4qHrqAg0o9Gws0h3BbHL10H" +
       "x6+nxRcj6Ly+z3pgVGnL57eQ/dXLgCxdo6A3gGuyB9nklfebb1+n7Ttp8Q1g" +
       "LcBv6rwJDOWo6yhbNb/5UtRMIujssQ8H0pPPu6/4GGnzAY346WfO3njXM+zf" +
       "ZWfnBx+53NSHblRiyzp8UHXo/jQwcUXP9Lhpc2zlZX8vRNA91/6gAWRF3hEd" +
       "v7vh+j6IHse5gHukf4fJ/jmCbjlEBpbgvbvDRD8AURsQpbc/9K5y0rU5tktO" +
       "HMrKoEML1PlfBPUBy+ET9jSTy74J28+64s1XYZfFzzzTpd7+YvnjmxN+0eLX" +
       "WWpxYx86s/nY4CBzu3BNafuyTnce+dltn73p4f0s87bNgLdmemhsD1z9CB23" +
       "vSg79F7/+V1/+sY/eOa72cHb/wGK/13QrCcAAA==");
}
