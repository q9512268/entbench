package org.sunflow.core.light;
public class SphereLight implements org.sunflow.core.LightSource, org.sunflow.core.Shader {
    private org.sunflow.image.Color radiance;
    private int numSamples;
    private org.sunflow.math.Point3 center;
    private float radius;
    private float r2;
    public SphereLight() { super();
                           radiance = org.sunflow.image.Color.WHITE;
                           numSamples = 4;
                           center = new org.sunflow.math.Point3();
                           radius = (r2 = 1); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        radiance =
          pl.
            getColor(
              "radiance",
              radiance);
        numSamples =
          pl.
            getInt(
              "samples",
              numSamples);
        radius =
          pl.
            getFloat(
              "radius",
              radius);
        r2 =
          radius *
            radius;
        center =
          pl.
            getPoint(
              "center",
              center);
        return true;
    }
    public void init(java.lang.String name, org.sunflow.SunflowAPI api) {
        api.
          light(
            name,
            this);
        api.
          geometry(
            name +
            ".geo",
            new org.sunflow.core.primitive.Sphere(
              ));
        api.
          shader(
            name +
            ".shader",
            this);
        api.
          parameter(
            "shaders",
            name +
            ".shader");
        api.
          parameter(
            "transform",
            org.sunflow.math.Matrix4.
              translation(
                center.
                  x,
                center.
                  y,
                center.
                  z).
              multiply(
                org.sunflow.math.Matrix4.
                  scale(
                    radius)));
        api.
          instance(
            name +
            ".instance",
            name +
            ".geo");
    }
    public int getNumSamples() { return numSamples; }
    public int getLowSamples() { return 1; }
    public boolean isVisible(org.sunflow.core.ShadingState state) {
        return state.
          getPoint(
            ).
          distanceToSquared(
            center) >
          r2;
    }
    public void getSamples(org.sunflow.core.ShadingState state) {
        if (getNumSamples(
              ) <=
              0)
            return;
        org.sunflow.math.Vector3 wc =
          org.sunflow.math.Point3.
          sub(
            center,
            state.
              getPoint(
                ),
            new org.sunflow.math.Vector3(
              ));
        float l2 =
          wc.
          lengthSquared(
            );
        if (l2 <=
              r2)
            return;
        float topX =
          wc.
            x +
          state.
            getNormal(
              ).
            x *
          radius;
        float topY =
          wc.
            y +
          state.
            getNormal(
              ).
            y *
          radius;
        float topZ =
          wc.
            z +
          state.
            getNormal(
              ).
            z *
          radius;
        if (state.
              getNormal(
                ).
              dot(
                topX,
                topY,
                topZ) <=
              0)
            return;
        float cosThetaMax =
          (float)
            java.lang.Math.
            sqrt(
              java.lang.Math.
                max(
                  0,
                  1 -
                    r2 /
                    org.sunflow.math.Vector3.
                    dot(
                      wc,
                      wc)));
        org.sunflow.math.OrthoNormalBasis basis =
          org.sunflow.math.OrthoNormalBasis.
          makeFromW(
            wc);
        int samples =
          state.
          getDiffuseDepth(
            ) >
          0
          ? 1
          : getNumSamples(
              );
        float scale =
          (float)
            (2 *
               java.lang.Math.
                 PI *
               (1 -
                  cosThetaMax));
        org.sunflow.image.Color c =
          org.sunflow.image.Color.
          mul(
            scale /
              samples,
            radiance);
        for (int i =
               0;
             i <
               samples;
             i++) {
            double randX =
              state.
              getRandom(
                i,
                0,
                samples);
            double randY =
              state.
              getRandom(
                i,
                1,
                samples);
            double cosTheta =
              (1 -
                 randX) *
              cosThetaMax +
              randX;
            double sinTheta =
              java.lang.Math.
              sqrt(
                1 -
                  cosTheta *
                  cosTheta);
            double phi =
              randY *
              2 *
              java.lang.Math.
                PI;
            org.sunflow.math.Vector3 dir =
              new org.sunflow.math.Vector3(
              (float)
                (java.lang.Math.
                   cos(
                     phi) *
                   sinTheta),
              (float)
                (java.lang.Math.
                   sin(
                     phi) *
                   sinTheta),
              (float)
                cosTheta);
            basis.
              transform(
                dir);
            float cosNx =
              org.sunflow.math.Vector3.
              dot(
                dir,
                state.
                  getNormal(
                    ));
            if (cosNx <=
                  0)
                continue;
            float ocx =
              state.
                getPoint(
                  ).
                x -
              center.
                x;
            float ocy =
              state.
                getPoint(
                  ).
                y -
              center.
                y;
            float ocz =
              state.
                getPoint(
                  ).
                z -
              center.
                z;
            float qa =
              org.sunflow.math.Vector3.
              dot(
                dir,
                dir);
            float qb =
              2 *
              (dir.
                 x *
                 ocx +
                 dir.
                   y *
                 ocy +
                 dir.
                   z *
                 ocz);
            float qc =
              ocx *
              ocx +
              ocy *
              ocy +
              ocz *
              ocz -
              r2;
            double[] t =
              org.sunflow.math.Solvers.
              solveQuadric(
                qa,
                qb,
                qc);
            if (t ==
                  null)
                continue;
            org.sunflow.core.LightSample dest =
              new org.sunflow.core.LightSample(
              );
            dest.
              setShadowRay(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  dir));
            dest.
              getShadowRay(
                ).
              setMax(
                (float)
                  t[0] -
                  0.001F);
            dest.
              setRadiance(
                c,
                c);
            dest.
              traceShadow(
                state);
            state.
              addSample(
                dest);
        }
    }
    public void getPhoton(double randX1, double randY1, double randX2,
                          double randY2,
                          org.sunflow.math.Point3 p,
                          org.sunflow.math.Vector3 dir,
                          org.sunflow.image.Color power) { float z =
                                                             (float)
                                                               (1 -
                                                                  2 *
                                                                  randX2);
                                                           float r =
                                                             (float)
                                                               java.lang.Math.
                                                               sqrt(
                                                                 java.lang.Math.
                                                                   max(
                                                                     0,
                                                                     1 -
                                                                       z *
                                                                       z));
                                                           float phi =
                                                             (float)
                                                               (2 *
                                                                  java.lang.Math.
                                                                    PI *
                                                                  randY2);
                                                           float x =
                                                             r *
                                                             (float)
                                                               java.lang.Math.
                                                               cos(
                                                                 phi);
                                                           float y =
                                                             r *
                                                             (float)
                                                               java.lang.Math.
                                                               sin(
                                                                 phi);
                                                           p.
                                                             x =
                                                             center.
                                                               x +
                                                               x *
                                                               radius;
                                                           p.
                                                             y =
                                                             center.
                                                               y +
                                                               y *
                                                               radius;
                                                           p.
                                                             z =
                                                             center.
                                                               z +
                                                               z *
                                                               radius;
                                                           org.sunflow.math.OrthoNormalBasis basis =
                                                             org.sunflow.math.OrthoNormalBasis.
                                                             makeFromW(
                                                               new org.sunflow.math.Vector3(
                                                                 x,
                                                                 y,
                                                                 z));
                                                           phi =
                                                             (float)
                                                               (2 *
                                                                  java.lang.Math.
                                                                    PI *
                                                                  randX1);
                                                           float cosPhi =
                                                             (float)
                                                               java.lang.Math.
                                                               cos(
                                                                 phi);
                                                           float sinPhi =
                                                             (float)
                                                               java.lang.Math.
                                                               sin(
                                                                 phi);
                                                           float sinTheta =
                                                             (float)
                                                               java.lang.Math.
                                                               sqrt(
                                                                 randY1);
                                                           float cosTheta =
                                                             (float)
                                                               java.lang.Math.
                                                               sqrt(
                                                                 1 -
                                                                   randY1);
                                                           dir.
                                                             x =
                                                             cosPhi *
                                                               sinTheta;
                                                           dir.
                                                             y =
                                                             sinPhi *
                                                               sinTheta;
                                                           dir.
                                                             z =
                                                             cosTheta;
                                                           basis.
                                                             transform(
                                                               dir);
                                                           power.
                                                             set(
                                                               radiance);
                                                           power.
                                                             mul(
                                                               (float)
                                                                 (java.lang.Math.
                                                                    PI *
                                                                    java.lang.Math.
                                                                      PI *
                                                                    4 *
                                                                    r2));
    }
    public float getPower() { return radiance.
                                copy1(
                                  ).
                                mul(
                                  (float)
                                    (java.lang.Math.
                                       PI *
                                       java.lang.Math.
                                         PI *
                                       4 *
                                       r2)).
                                getLuminance(
                                  ); }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (!state.
              includeLights(
                ))
            return org.sunflow.image.Color.
                     BLACK;
        state.
          faceforward(
            );
        return state.
          isBehind(
            )
          ? org.sunflow.image.Color.
              BLACK
          : radiance;
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZDWwcxRWeO8c/cez4L7bz4ziJcSI5pHeQQBAxDSQmIU4v" +
       "jpULrnAAZ29vzrfJ3u6yO2ufQ8Of1JJWagQ0BBpBVFVB0BQIaotaiR+lrVpA" +
       "UCR+WqA/UFDVpqVpCai0Im3pezO7t3t7txedSC3t3HrmvZn3vXnvzXuzj54m" +
       "tZZJeqnGYmzGoFZsk8ZGJdOi6SFVsqyd0Dch31cjfXTjqZHLo6RunMzNStY2" +
       "WbLoZoWqaWucLFY0i0maTK0RStPIMWpSi5pTElN0bZx0KtZwzlAVWWHb9DRF" +
       "gjHJTJA2iTFTSdmMDjsTMLI4AZLEuSTxDcHhwQRpknVjxiOf7yMf8o0gZc5b" +
       "y2KkNbFHmpLiNlPUeEKx2GDeJBcaujozqeosRvMstke91FHB1sSlJSroe6Ll" +
       "47N3ZVu5CjokTdMZh2ftoJauTtF0grR4vZtUmrNuIreQmgSZ4yNmpD/hLhqH" +
       "ReOwqIvWowLpm6lm54Z0Doe5M9UZMgrEyLLiSQzJlHLONKNcZpihgTnYOTOg" +
       "XVpAK1CWQLz3wvih+25s/V4NaRknLYqWRHFkEILBIuOgUJpLUdPakE7T9Dhp" +
       "02Czk9RUJFXZ5+x0u6VMahKzYftdtWCnbVCTr+npCvYRsJm2zHSzAC/DDcr5" +
       "rzajSpOAtcvDKhBuxn4A2KiAYGZGArtzWGbtVbQ0I0uCHAWM/V8AAmCtz1GW" +
       "1QtLzdIk6CDtwkRUSZuMJ8H0tEkgrdXBAE1GFoZOiro2JHmvNEkn0CIDdKNi" +
       "CKhmc0UgCyOdQTI+E+zSwsAu+fbn9MgVB2/WtmhREgGZ01RWUf45wNQbYNpB" +
       "M9Sk4AeCsWll4rDU9cyBKCFA3BkgFjQ//NKZq1b1nnxe0CwqQ7M9tYfKbEI+" +
       "lpr7Ss/QwOU1KEaDoVsKbn4Rcu5lo87IYN6ACNNVmBEHY+7gyR0/v+624/T9" +
       "KGkcJnWyrto5sKM2Wc8ZikrNa6hGTYnR9DCZTbX0EB8fJvXwnlA0Knq3ZzIW" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZjzxLXe+Ss2R1tgOtaZX0gW5Jm0rA4uRiJ7j0yZjszO1O0grJK5SbVmMV162" +
       "Vr1wkgzDyFJbZaLXLoecTXGBp9ZpG20wVWEe1zorz5oqQ8GoaJFHifE0Ikp6" +
       "MEETIZo5ARP3A3Xs6JyAbhnHxxGDNta9iTrarPsJ721o36nbTg0VSrin1oat" +
       "mTDUg+6Wpk1unFF2jx4xA0YWfNPQp+5yNB3pC6CnQbnDj+msuklMA67UQMaB" +
       "MuLEcunlmp/0CKvbp9v9eKTPKJ+eKaxodRvTFm74pUons1qTGUUshBqcluL6" +
       "fCgag2ypRUrEd1xp3pkGsOt3kuUkpJxK1uMyrIPguBzUgkxccf4Ii+QEHxjt" +
       "OHVRrDIwsSUpkFgQZTwpRXNpXOqX4k4P44fIvIlhTifKyiRfHkd0pvStegeP" +
       "NtZkxgnxkGr2SlHX0gNl0ca6ZZLwhJEZeBWq5yRM13JLnT6uDBizMzAcuTTT" +
       "O9uRMp724S6ccZsQi2FNcltDfd6uIHzkGJOuTgql8oSfaWhtw4ylJeO3hy3O" +
       "QjG1E/K2jQb4rCVv24MOgVXblk6sxgjCDIR1WSq7bqqWOpv1uDFsRUttIHX7" +
       "sO0HDS5ExpvRrDzoirg3DweSi07kuGZ7zUZ/ydSxDsPMnXa3t4Qb+nZSQhK4" +
       "XkGRaWtAWjLl8tsg8mrhYFjh5aZgWgEj1g1yunQnLbwjTKVFqdtualSy2Lg2" +
       "Vhq466qQ9XlBZiw7XDfq7hRm67qHlUe6aQTGQulu4ySKuU5GV5Eh2RfHas/t" +
       "C+yo3EVYQps49b6AzOTVLN76HUfsGc2yInMsWV/b/tRcEcHWXSrTMVoTI2E+" +
       "aY2cuiDbmyq1SZBtw6fQurd1+EXqUyRBz1xd3WRMxhoIXWv3jHZ1ao11L9lq" +
       "Hmz6aDYRlOmcycarmiW10lItISkCnQseF6KxQ1p4SxyM+ISQB6XlYps4PBp1" +
       "++6WUiXTqRDJ0pGqOpq2LWcjckwlUzSxk7S9bOBQKCFaCy5Z07gQ6nSbbJRc" +
       "H0OqbBA7ZrVRbpR4ak72CaBWid4uk9Z40UTIzdDlgYv0LGM4hxmkQWzqTIuf" +
       "uP2tFrtSCjdaXD/WM7iPoly524PH2mSCSxWSQtZ4ZvtxtSbXpr1aE00IpFql" +
       "V968h7FhSo1WWK21WZaGug+P59v63PVTVHBbiD3cdiyMMWzL1QkDb6seExBd" +
       "nhpPNbPvL0mMyiaZsLVQH5MoIxLKEecmk1q85KtNbVILG5O05GxrKLEy4LTX" +
       "SqNhgkV2tKQYf4BhPFunWiypwzCsDbRytV2OmySSLpQ1tQXixmayO9gqRm1Z" +
       "yZBJxfHHnaqKxD2kSiaillSHiwg39XhAKzrbEPAuaeidUo9ZVBuwH2iqqiXL" +
       "ernHzoFbxb3loOsrTYybVqzmctAnyTIhoM0u3Z41SafkJLWAkdoDSmT6A4E3" +
       "ZWApguYSU6RRXg7iDZbO6wucERUVpRIWJcimHdGtBpqVUXg6m5JYi506M9nx" +
       "3E6PATZbqk2cWb/RbIjNGImFrOQNx9mWJPnQg7fh0ESnnq4xwxjVVquEKE1J" +
       "IqanEmIzSM1EkL7NGOx2IbaQEp5VNhLjglrCEQgkaChUusY2dGXL1yq9esPp" +
       "YBWOEnix06iNpv2WWF1vpeEGzVbDQXdYX5Klal+ibXOb4Z5YjxCEZ7XWugzX" +
       "ZmI3Kg9Je65wDszH1GhS4XGlPPQ7s+FGmpdRm3HVOib4PO7zM72rtGjTQWa1" +
       "aNuOR/Wqpq4aRktuavgkatiTDheJKWOldRX1TW/YdBBJhlkjsJHqFpVCdoom" +
       "mdrBmoq+QGsuvF3MqkpTqSOcMR16ZVFYgEjKpjWk1SeJMZxoNSRV4S4ed5CB" +
       "TW2sLt9vVVtaT84NRpnCtJX4acn0GhU1XvpM4Nmj0Tic2zGnh4IUEaisLe2Z" +
       "V22P3VXYWS7jaoNub0a8smQ7ozK7Unt9Yz6VTNyEcV9mtmg/NYO+xyGLISPM" +
       "k3YFo0CId0yPKW2IgbERTaycDaxswPWHvj+ZqwOn19O6IgCghpbHdLvjMsWU" +
       "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" +
       "lnTc5PQ5uDy/L85vH+Xi8e4E9y35C69T");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zIe+Xv/s7hyebItZlvdylYau7I4EFp3m+fzzd+ztqK/LvRe/8dDPPPCeo2+P" +
       "h3YMn5jnKd7edfGht67jR8UxteyXnvj57/xHr/9xsYv9/wGzn4TJWC8AAA==");
}
