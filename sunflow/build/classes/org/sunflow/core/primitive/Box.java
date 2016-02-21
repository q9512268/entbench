package org.sunflow.core.primitive;
public class Box implements org.sunflow.core.PrimitiveList {
    private float minX;
    private float minY;
    private float minZ;
    private float maxX;
    private float maxY;
    private float maxZ;
    public Box() { super();
                   minX = (minY = (minZ = -1));
                   maxX = (maxY = (maxZ = +1)); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        org.sunflow.core.ParameterList.FloatParameter pts =
          pl.
          getPointArray(
            "points");
        if (pts !=
              null) {
            org.sunflow.math.BoundingBox bounds =
              new org.sunflow.math.BoundingBox(
              );
            for (int i =
                   0;
                 i <
                   pts.
                     data.
                     length;
                 i +=
                   3)
                bounds.
                  include(
                    pts.
                      data[i],
                    pts.
                      data[i +
                             1],
                    pts.
                      data[i +
                             2]);
            minX =
              bounds.
                getMinimum(
                  ).
                x;
            minY =
              bounds.
                getMinimum(
                  ).
                y;
            minZ =
              bounds.
                getMinimum(
                  ).
                z;
            maxX =
              bounds.
                getMaximum(
                  ).
                x;
            maxY =
              bounds.
                getMaximum(
                  ).
                y;
            maxZ =
              bounds.
                getMaximum(
                  ).
                z;
        }
        return true;
    }
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
        int n =
          state.
          getPrimitiveID(
            );
        switch (n) {
            case 0:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      1,
                      0,
                      0));
                break;
            case 1:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      -1,
                      0,
                      0));
                break;
            case 2:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      1,
                      0));
                break;
            case 3:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      -1,
                      0));
                break;
            case 4:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      1));
                break;
            case 5:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      -1));
                break;
            default:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      0));
                break;
        }
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
        state.
          setShader(
            state.
              getInstance(
                ).
              getShader(
                0));
        state.
          setModifier(
            state.
              getInstance(
                ).
              getModifier(
                0));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r, int primID,
                                   org.sunflow.core.IntersectionState state) {
        float intervalMin =
          java.lang.Float.
            NEGATIVE_INFINITY;
        float intervalMax =
          java.lang.Float.
            POSITIVE_INFINITY;
        float orgX =
          r.
            ox;
        float invDirX =
          1 /
          r.
            dx;
        float t1;
        float t2;
        t1 =
          (minX -
             orgX) *
            invDirX;
        t2 =
          (maxX -
             orgX) *
            invDirX;
        int sideIn =
          -1;
        int sideOut =
          -1;
        if (invDirX >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  0;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  1;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  1;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  0;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        float orgY =
          r.
            oy;
        float invDirY =
          1 /
          r.
            dy;
        t1 =
          (minY -
             orgY) *
            invDirY;
        t2 =
          (maxY -
             orgY) *
            invDirY;
        if (invDirY >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  2;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  3;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  3;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  2;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        float orgZ =
          r.
            oz;
        float invDirZ =
          1 /
          r.
            dz;
        t1 =
          (minZ -
             orgZ) *
            invDirZ;
        t2 =
          (maxZ -
             orgZ) *
            invDirZ;
        if (invDirZ >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  4;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  5;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  5;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  4;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        if (r.
              isInside(
                intervalMin)) {
            r.
              setMax(
                intervalMin);
            state.
              setIntersection(
                sideIn,
                0,
                0);
        }
        else
            if (r.
                  isInside(
                    intervalMax)) {
                r.
                  setMax(
                    intervalMax);
                state.
                  setIntersection(
                    sideOut,
                    0,
                    0);
            }
    }
    public int getNumPrimitives() { return 1; }
    public float getPrimitiveBound(int primID, int i) { switch (i) {
                                                            case 0:
                                                                return minX;
                                                            case 1:
                                                                return maxX;
                                                            case 2:
                                                                return minY;
                                                            case 3:
                                                                return maxY;
                                                            case 4:
                                                                return minZ;
                                                            case 5:
                                                                return maxZ;
                                                            default:
                                                                return 0;
                                                        } }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          minX,
          minY,
          minZ);
        bounds.
          include(
            maxX,
            maxY,
            maxZ);
        if (o2w ==
              null)
            return bounds;
        return o2w.
          transform(
            bounds);
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZe2wcxRmfOzu24zz8yMuExEkcB8khveONwBRITELsnp0j" +
       "DgEcgjO3N2dvsre77M7Z59AUiAQJSI1SGh6tIP2DoAACgioQFS00paUQQavy" +
       "KqUtUKpWpYWopKi0hVL6fTP7vkfkpjlp5+Z2vm+++R7z+76Ze+QomWJbpJ3p" +
       "PMEnTGYnVus8TS2bZXs0atsb4N2wcncN/fi69wcuiJO6ITJzlNr9CrXZGpVp" +
       "WXuILFR1m1NdYfYAY1nkSFvMZtYY5aqhD5E5qt2bNzVVUXm/kWVIsJFaKdJC" +
       "ObfUTIGzXmcCThamYCVJsZLkyuhwd4pMVwxzwidvC5D3BEaQMu/LsjlpTm2l" +
       "YzRZ4KqWTKk27y5a5HTT0CZGNIMnWJEntmrnOiboS51bYoKOx5s++WzvaLMw" +
       "wSyq6wYX6tnrmW1oYyybIk3+29Uay9vXk6+RmhSZFiDmpDPlCk2C0CQIdbX1" +
       "qWD1M5heyPcYQh3uzlRnKrggTpaEJzGpRfPONGmxZpihgTu6C2bQdrGnrdSy" +
       "RMU7T0/uu/u65u/WkKYh0qTqg7gcBRbBQcgQGJTlM8yyV2azLDtEWnRw9iCz" +
       "VKqp2x1Pt9rqiE55AdzvmgVfFkxmCZm+rcCPoJtVULhheerlREA5v6bkNDoC" +
       "us71dZUarsH3oGCjCguzchTizmGp3abqWU4WRTk8HTu/AgTAWp9nfNTwRNXq" +
       "FF6QVhkiGtVHkoMQevoIkE4xIAAtTuZXnBRtbVJlGx1hwxiREbq0HAKqqcIQ" +
       "yMLJnCiZmAm8ND/ipYB/jg5ctOcGfa0eJzFYc5YpGq5/GjC1R5jWsxyzGOwD" +
       "yTh9eeouOveZ3XFCgHhOhFjSPPXVY5euaD/8oqQ5tQzNusxWpvBh5UBm5isL" +
       "erouqMFlNJiGraLzQ5qLXZZ2RrqLJiDMXG9GHEy4g4fX//Samx5mH8RJYy+p" +
       "UwytkIc4alGMvKlqzLqc6cyinGV7yVSmZ3vEeC+ph35K1Zl8uy6XsxnvJbWa" +
       "eFVniN9gohxMgSZqhL6q5wy3b1I+KvpFkxBSDw/pgqeJyI/45uSa5KiRZ0mq" +
       "UF3VjWTaMlB/dKiepUnObOhnYdQ0knZBz2nGeNK2lKRhjXi/FcNiSdNS86Dr" +
       "GEuuMooJDDHzZE5eRM1mjcdiYPQF0S2vwW5Za2hZZg0r+wqrVh97bPglGU64" +
       "BRybcNIOchKOnATKSXhyEiCHxGJi+tkoT/oTvLEN9jUA6/Suwc19W3Z31EAg" +
       "meO1YEok7QglmB5/87uIPaz8re+9s9fuuPC1OIkDPmQgwfg4vziA85igLENh" +
       "WYCZSnjvYl6yMsKXXQM5fM/4zRtvPEOsIQjcOOEUwBxkTyPceiI6oxu23LxN" +
       "u97/5NBdOwx/64YygZvASjgRETqiTowqP6wsX0yfHH5mR2ec1ALMALRyClsB" +
       "UKs9KiOEDN0uyqIuDaBwzrDyVMMhFxob+ahljPtvRHS1iP5scO003Coz4Znl" +
       "7B3xjaNzTWznyWjEWIloIVD8y4Pmfb/6+Z/PFuZ2Ab8pkKkHGe8OgAxO1irg" +
       "pMUPvQ0WY0D39j3pb955dNcmEXdAsbScwE5sewBcwIVg5ltevP6td9858Hrc" +
       "j1UOWbaQgWKl6CmJ70ljFSVB2mn+egCkNNjLGDWdV+oQlWpOpRmN4eb4d9Oy" +
       "M5/8cE+zjAMN3rhhtOL4E/jvT1lFbnrpun+0i2liCiZJ32Y+mUTeWf7MKy2L" +
       "TuA6ije/uvBbL9D7AMMBN211OxNQSIQNiHDaOUL/pGjPjoydh02nHQz+8P4K" +
       "FDPDyt7XP5qx8aNnj4nVhquhoK/7qdktwwubZUWYfl4UYNZSexTozjk8cG2z" +
       "dvgzmHEIZlSgBLDXWYBqxVBkONRT6n/9ox/P3fJKDYmvIY2aQbNrqNhkZCpE" +
       "N7NHARCL5iWXSueON0DTLFQlJcqjPReV99TqvMmFbbd/b94TFx3c/44IKhlF" +
       "pwr2OkTkEA6KCtrfxg+/dv4bB79x17jMwV2VsSvC1/bpOi2z8/f/LDGwQK0y" +
       "9UGEfyj5yL3zey7+QPD78IHcS4ulWQQA1uc96+H83+Mddc/HSf0QaVacinUj" +
       "1Qq4KYegSrPdMhaq2tB4uOKS5UW3B48LotAVEBsFLj97QR+psT8jglXT0YNL" +
       "Xee630GsihHRuVywnCbaLmxWuNBQD2kQTjUsgg3TqkzKSW1e1a8Op0A8Bg0W" +
       "MjYkMietyiLsrPQWZXdn+g8yAE4pwyDp5jyY/PrGN7e+LHCzAVPlBlfpQCJc" +
       "aY0EQLtZrvkL+MTg+Q8+uFZ8IQue1h6n6lrslV2miduwSiRGFEjuaH13273v" +
       "PyoViIZdhJjt3nf7F4k9+yQYytp9aUn5HOSR9btUB5srcHVLqkkRHGv+dGjH" +
       "9x/csUuuqjVcia6Gg9ajv/z85cQ9vztSphSCODMo94Ag5lU0s8PekSpddlvT" +
       "D/a21qyBRNxLGgq6en2B9WbDAVpvFzIBd/mnAj9oHeXQNZzEloMXZBrF9nxs" +
       "1soIvLAiaK2cfNhTbHplvF6D/XREaOYkCM0FhA6VEzryPwhtcYS2VBC6TW5w" +
       "bPpKd3IlblwkLV5dbpHaSVikgN+8FFrWHfZJEDoeEFrWHcUqQou+WZd7osWn" +
       "jkROV8HiyU+QMdFvK3f+8Da1qF5g+y2sdE4WO/7Azn37s+seODPuFCxXc8j1" +
       "hvkljY0xLSCxHmcKpeR+cTPg57fGW8+YleLFXOmpBGdpr3DuWF4ZMaMCXtj5" +
       "l/kbLh7dMokjx6KI7tEpH+p/5Mjlpyl3xMXlhkynJZciYabuMEY1WowXLD2M" +
       "Sh2eU0UBfAo8bY5T26Lx5IdNJB68YroSa6TsjAs/xatEBpqGcWZhZLhkc4Nk" +
       "g/J7ZbpXLGtPlcJ2Hza3wRmgYGYh/wmaASfT4NdgoH8V1AMZw9AY1aPpAX9u" +
       "Lvq75vbjbdVQjYkvLhGvbwkftM4n8qKCuN+Ts3gl1og9YuG9uLDE4oOjNKvq" +
       "I3g9yITY+6tY9CA2+zmZZVoMTl0syFzOpLVjhpr1Lfed/4/lBuDpc9Tvm7zl" +
       "KrFG9K4R66hxLTe7xHLr6cTxQqpG1UuqjUA4wbQdJdP24kWoLQ8ivleeqOKV" +
       "H2JzCEo+1WX1ABZHHvId8PgJO0AA/iJ47neseP/kHVCJtYqKR6qMvYTNTzhp" +
       "HmF8oJD3dBfET/nKP3/CyotE2wHPQUeDg5NXvhJreaQUKohGTP1GFTO8ic0v" +
       "OGkBM3g2WGUU9CwOpH07vHLCdpiHQ8vgedpR5unJ26ESa3X8agtulzzlo4l+" +
       "yi21eI6Q+F4V8/wRm99yMhPMc5VhaVlhGtudeEHJxGIcwG2VEcD+t0/Ydpho" +
       "yQp4nnMM8NzkbVeJtYr6x6qMfYzNh4DqYJpVFI5uI+E9dKOv/9HJ618EGAQb" +
       "4mVLW8mfVvKPFuWx/U0N8/Zf+aa48vT+DJkOx+FcQdOC9wGBfh0koZwqNJgu" +
       "bwfkyepTTuZXvvKG2tEMafcvyfU5AEiUCxIYfgXIYnCynhYg43gAFL0gUQ2o" +
       "DETYrTXdCGsWN014O5KQtyPFWKB2JYEgm3M8I3sswYtRrE3Ff4duHVmQ/x4O" +
       "K4f29w3ccOy8B+TFrKLR7dtxlmlwepV3xF4tuqTibO5cdWu7Ppv5+NRlbi3e" +
       "Ihfsx+ypgcC6BHauiY6fH7m1tDu9y8u3Dlz07M92170Kp/VNJEYhCjeV3iMV" +
       "zQKU9ptSpad0qNPFdWp317cnLl6R++tvxEUdkaf6BZXph5Wpn+7ZvsSOJeJk" +
       "ai+ZAscMVhQXXJdN6OuZMmaFjvx1GYEWwk4pMhMjlOJ/isIqjjFneG/xUh9S" +
       "e+ntR+kfHY0QOszyYHpGpHIvmGZwVFj1WmyuKKKVIc6GU/2m6V773CGsbpq4" +
       "82Lz8Mfm/wJEiI9LFCAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LAAA");
}
