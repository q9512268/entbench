package org.sunflow.core.shader;
public class PhongShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color diff;
    private org.sunflow.image.Color spec;
    private float power;
    private int numRays;
    public PhongShader() { super();
                           diff = org.sunflow.image.Color.GRAY;
                           spec = org.sunflow.image.Color.GRAY;
                           power = 20;
                           numRays = 4; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        diff =
          pl.
            getColor(
              "diffuse",
              diff);
        spec =
          pl.
            getColor(
              "specular",
              spec);
        power =
          pl.
            getFloat(
              "power",
              power);
        numRays =
          pl.
            getInt(
              "samples",
              numRays);
        return true;
    }
    protected org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
        return diff;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        return state.
          diffuse(
            getDiffuse(
              state)).
          add(
            state.
              specularPhong(
                spec,
                power,
                numRays));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        state.
          faceforward(
            );
        org.sunflow.image.Color d =
          getDiffuse(
            state);
        state.
          storePhoton(
            state.
              getRay(
                ).
              getDirection(
                ),
            power,
            d);
        float avgD =
          d.
          getAverage(
            );
        float avgS =
          spec.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              avgD) {
            power.
              mul(
                d).
              mul(
                1.0F /
                  avgD);
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              avgD;
            double v =
              state.
              getRandom(
                0,
                1,
                1);
            float s =
              (float)
                java.lang.Math.
                sqrt(
                  v);
            float s1 =
              (float)
                java.lang.Math.
                sqrt(
                  1.0F -
                    v);
            org.sunflow.math.Vector3 w =
              new org.sunflow.math.Vector3(
              (float)
                java.lang.Math.
                cos(
                  u) *
                s,
              (float)
                java.lang.Math.
                sin(
                  u) *
                s,
              s1);
            w =
              onb.
                transform(
                  w,
                  new org.sunflow.math.Vector3(
                    ));
            state.
              traceDiffusePhoton(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
                power);
        }
        else
            if (rnd <
                  avgD +
                  avgS) {
                float dn =
                  2.0F *
                  state.
                  getCosND(
                    );
                org.sunflow.math.Vector3 refDir =
                  new org.sunflow.math.Vector3(
                  );
                refDir.
                  x =
                  dn *
                    state.
                      getNormal(
                        ).
                      x +
                    state.
                      getRay(
                        ).
                      dx;
                refDir.
                  y =
                  dn *
                    state.
                      getNormal(
                        ).
                      y +
                    state.
                      getRay(
                        ).
                      dy;
                refDir.
                  z =
                  dn *
                    state.
                      getNormal(
                        ).
                      z +
                    state.
                      getRay(
                        ).
                      dz;
                power.
                  mul(
                    spec).
                  mul(
                    1.0F /
                      avgS);
                org.sunflow.math.OrthoNormalBasis onb =
                  state.
                  getBasis(
                    );
                double u =
                  2 *
                  java.lang.Math.
                    PI *
                  (rnd -
                     avgD) /
                  avgS;
                double v =
                  state.
                  getRandom(
                    0,
                    1,
                    1);
                float s =
                  (float)
                    java.lang.Math.
                    pow(
                      v,
                      1 /
                        (this.
                           power +
                           1));
                float s1 =
                  (float)
                    java.lang.Math.
                    sqrt(
                      1 -
                        s *
                        s);
                org.sunflow.math.Vector3 w =
                  new org.sunflow.math.Vector3(
                  (float)
                    java.lang.Math.
                    cos(
                      u) *
                    s1,
                  (float)
                    java.lang.Math.
                    sin(
                      u) *
                    s1,
                  s);
                w =
                  onb.
                    transform(
                      w,
                      new org.sunflow.math.Vector3(
                        ));
                state.
                  traceReflectionPhoton(
                    new org.sunflow.core.Ray(
                      state.
                        getPoint(
                          ),
                      w),
                    power);
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUZbWwUx3Xu/P39Adh82WBjqDDkLqShaWRKYwwOpmd8sgGp" +
       "JsWs9+Z8i/d2l905++yUNkGqcKoGkYQArRJ+tERJEATUJmr6kchRlJIoaSVo" +
       "0pCmIVVbqbQpCqhqUpW26Xsze7d7ex+IKjlp5+Zm33vz3pv3OXfqCimxTNJK" +
       "NRZgUwa1Aps0FpZMi0Z6VMmytsHaiHy0SPr7rstb7/ST0mFSG5OsflmyaK9C" +
       "1Yg1TFoUzWKSJlNrK6URxAib1KLmhMQUXRsm8xSrL26oiqywfj1CEWCHZIZI" +
       "g8SYqYwmGO2zCTDSEgJOgpyTYLf3dVeIVMu6MeWAz3eB97jeIGTc2ctipD60" +
       "R5qQggmmqMGQYrGupElWGbo6NabqLECTLLBHXWurYEtobZYK2s/WfXT9UKye" +
       "q2COpGk64+JZg9TS1QkaCZE6Z3WTSuPWXvINUhQiVS5gRjpCqU2DsGkQNk1J" +
       "60AB9zVUS8R7dC4OS1EqNWRkiJG2TCKGZEpxm0yY8wwUypktO0cGaZempRVS" +
       "Zon46Krg4aO76n9YROqGSZ2iDSE7MjDBYJNhUCiNj1LT6o5EaGSYNGhw2EPU" +
       "VCRVmbZPutFSxjSJJeD4U2rBxYRBTb6noys4R5DNTMhMN9PiRblB2b9Koqo0" +
       "BrI2ObIKCXtxHQSsVIAxMyqB3dkoxeOKFmFkiRcjLWPHVwAAUMvilMX09FbF" +
       "mgQLpFGYiCppY8EhMD1tDEBLdDBAk5GFeYmirg1JHpfG6AhapAcuLF4BVAVX" +
       "BKIwMs8LxinBKS30nJLrfK5sXXfwXm2z5ic+4DlCZRX5rwKkVg/SII1Sk4If" +
       "CMTqztARqemFGT8hADzPAyxgfvz1a3etbp19VcAsygEzMLqHymxEPjFae35x" +
       "z8o7i5CNckO3FDz8DMm5l4XtN11JAyJMU5oivgykXs4O/uKr952kH/hJZR8p" +
       "lXU1EQc7apD1uKGo1LybatSUGI30kQqqRXr4+z5SBvOQolGxOhCNWpT1kWKV" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAK06e+zrVnm+v97e294+7m0Lbeno+5bRhl0nzntl0MSJncSv" +
       "xI7txDCK4ziJE7/fNusGlRhoSAyxlrEJqv0BGqBCERoCaQN1gg0YaBIbGhsS" +
       "D02TxsaQ6B9j09jGjp3f6+Y+SgeRfHJ8zne+873Pd87xsz+ErvVcqGBberLU" +
       "Lf+CGvsX1nr1gp/YqndhQFaHsuupc1SXPW8M2h5XHvjk2R//5D2rc3vQKQm6" +
       "TTZNy5d9zTI9VvUsPVTnJHT2qLWrq4bnQ+fItRzKcOBrOkxqnv8oCd1wbKgP" +
       "nScPSIABCTAgAc5JgFtHUGDQTaoZGGg2QjZ9z4F+EzpBQqdsJSPPh+6/GIkt" +
       "u7Kxj2aYcwAwXJe9C4CpfHDsQvcd8r7l+RKGny7AT/3+m8596hrorASd1Uwu" +
       "I0cBRPhgEgm60VCNmep6rflcnUvQLaaqzjnV1WRdS3O6JehWT1uash+46qGQ" +
       "ssbAVt18ziPJ3ahkvLmB4lvuIXsLTdXnB2/XLnR5CXi9/YjXLYdY1g4YPKMB" +
       "wtyFrKgHQ05uNHPuQ/fujjjk8TwBAMDQ04bqr6zDqU6aMmiAbt3qTpfNJcz5" +
       "rmYuAei1VgBm8aG7rog0k7UtKxt5qT7uQ3fuwg23XQDq+lwQ2RAfevkuWI4J" +
       "aOmuHS0d088P6de++y1mz9zLaZ6rip7Rfx0YdM/OIFZdqK5qKup24I2PkO+T" +
       "b//cO/cgCAC/fAd4C/OZ33jhsdfc8/yXtzC/dBkYZrZWFf9x5UOzm7/+SvTh" +
       "5jUZGdfZlqdlyr+I89z8h/s9j8Y28LzbDzFmnRcOOp9n/3L61o+pP9iDzvSh" +
       "U4qlBwawo1sUy7A1XXVx1VRd2Vfnfeh61ZyjeX8fOg3qpGaq21ZmsfBUvw+d" +
       "1POmU1b+DkS0ACgyEZ0Gdc1cWAd1W/ZXeT22IQg6DR7oEfDcCG1/+b8PMfDK" +
       "MlTY1uCha2Wse7Bq+jMg1hXsBeZCtyLYcxXYcpeH74rlqrC3kueqCw9Xlrnk" +
       "8vqFzLDsXzzKOOPiXHTiBBDwK3fdWwee0bN0APu48lTQ7r7wice/undo7vv8" +
       "+9CDYLIL+5NdyCa7sJ3swrHJoBMn8jlelk26VSAQ/wY4MghxNz7M/frgze98" +
       "4BpgOXZ0EsguA4WvHGnRI9fv5wFOAfYHPf/+6G3CbxX3oL2LQ2ZGKGg6kw0f" +
       "ZoHuMKCd33WVy+E9+47v//i59z1hHTnNRTF435cvHZn54gO7InUtRZ2D6HaE" +
       "/pH75E8//rknzu9BJ4GDg6Dmy8AIQby4Z3eOi3zy0YP4lvFyLWB4YbmGrGdd" +
       "B0HpjL9yreioJdf1zXn9FiDjGzIjvR08t+5bbf6f9d5mZ+XLtraRKW2Hizx+" +
       "/hpnf/Dv//pfyrm4D0Lt2WOLF6f6jx5z7wzZ2dyRbzmygbGrqgDu2+8f/t7T" +
       "P3zHG3IDABAPXm7C81mJArcGKgRifvuXnX/47nc+9I29I6PxwfoWzHRNiQ+Z" +
       "zNqhM1dhEsz2qiN6QHjQgVNlVnOeNw1rri00eaarmZX+99mHSp/+t3ef29qB" +
       "DloOzOg1L47gqP0VbeitX33Tf9yTozmhZMvTkcyOwLYx77YjzC3XlZOMjvht" +
       "f3P3H3xJ/iCIniBieVqq5kEIymUA5UqDc/4fycsLO32lrLjXO278F/vXsTTi" +
       "ceU93/jRTcKPPv9CTu3FechxXVOy/ejWvLLivhigv2PX03uytwJwlefpN57T" +
       "n/8JwCgBjApYfD3GBSEivsgy9qGvPf2tP//C7W/++jXQHgad0S15jsm5k0HX" +
       "A+tWvRUIT7H9+se2yo2uA8W5nFXoEua3RnFn/nYaEPjwleMLlqURRy56538x" +
       "+uzJf/zPS4SQR5bLrJ474yX42Q/chb7uB/n4IxfPRt8TXxp3Qcp1NBb5mPHv" +
       "ew+c+os96LQEnVP28zlB1oPMcSSQw3gHSR7I+S7qvzgf2S6+jx6GsFfuhpdj" +
       "0+4Gl6N4D+oZdFY/sxNP8kXvDvDctO9qN+3GkxNQXnl9PuT+vDyfFb984L6n" +
       "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" +
       "Z+/4k9f+8TPfyU/s/w+UJ5vYdCcAAA==");
}
