package org.sunflow.core.shader;
public class SimpleShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        return new org.sunflow.image.Color(
          java.lang.Math.
            abs(
              state.
                getRay(
                  ).
                dot(
                  state.
                    getNormal(
                      ))));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public SimpleShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "iRYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "s/cncsRH8/ZK1vz0VutZ9w3AY8M8iQQYmuGIVk7n8QhYjCVf2ffRCUgqgYqv" +
       "LK1KTubVII3OrSMTZnebiW1jVdaiWy7yPn5Ta7i6zyvY/TsPidEuSOre80/v" +
       "+9pvvPZbYIu60OkkUx/YmSMrsnGW5/7q8x988LZnv/2ePACB6MO9tPmTN2RU" +
       "ey8ncdY0sqa5L+r9magjNw5klRbDiMnjhKrk0r6sZXKBYYPQmuwlcfCTl79l" +
       "fuw7n9kmaCfN8ASw+syzv/bD3fc+u3MkLX7tdZnpUZxtapwzfceehgPo0Zdb" +
       "Jcdo/fPnnvyj333y6S1Xl48neU1whvnMX//P13Y/8u2v3CCzuNVyf4yNjW7/" +
       "fKccUsT+Hz2Zq8hKHqa21q9UlbQKz1V+mDYj1Vv3+ig9tWnDZKlyKJX0GbtG" +
       "2qbpdGka7eOyhPVrqIzGTqeEMGMkKC4G5sDkFbZXcmHTaw3GJZ4aeFSRdClD" +
       "EvzB1Pd6xGy4cIdNtTkoUvVpl+jPKkIiIbVEimck3RzxIdqHOVbrw5pGc9yM" +
       "bLKByeG2bC01VrAle42uBW4sCyYitRozdFBb9rRp2k98dIBpKKqb1lLom9w4" +
       "URhhikvNoaPHYGA5xfFZ1/fDjbLGjHYPo/oyZm54CaTGYHqCasu+kgwmAsJN" +
       "h15jseDGI4GI14G99OC+nEpFtt+yeaJpjqm5vWY2q5pF1iPfnnFWqM/qjNEh" +
       "Nixlj5JUXjoeX1/rxRLflWulQTMIaH3l9pFpKqXxejzXmvMe3Jg3VRbZrIaV" +
       "ZqDM7HZjEc8raIChfWXh8rVWg49ofbBJS05gTxhmXar3TX8Zr5CpXC4MN1gf" +
       "r7fMEdUXTKbVMv1Fna8Li2k0Kg0X2pC2BYdrTCKyM6nIvtKajkf1fslTkrnV" +
       "72BBGplm10Z6bUGt+HQqNqK+VZP86bRluLV4os/Vfo3HAj4YMWMTVzoMmU5a" +
       "dZLAmG7YXtBdxV4GEV/EFshI8hiZmzdldOjjnb7qVSJFk32TI+CYxtxWHWYQ" +
       "ecVzpo8SS5yUzJKKYdrSF8ZDQp1W2fac7S9ErNadIJZuMOXGwkdwg5ybeHOg" +
       "1PBRwe/j/qy9ZoMNWUI7q3GRIEZYtF625cgpTWujaZtQmHDAiAvMG6cE3rX4" +
       "AestBgMCd3prPx45IuJL/pgPWmPdGFKSbzpEz2/ZTWrGdLsSpjMVYqhO9dl6" +
       "HBLwBBbiPjrV+lOvPRoMzZKn+y6X0vNWCxbZZnm9ITuDYYXSp4jUtBUXXYWO" +
       "Wx4Q8rRATdlutYayMwXZeAk8Wnu0rZMhUqjV23bVG+JchBYKcaAvZ9rUHS7Z" +
       "KJ75OLdab8bTaVdCBHdOsSTLOZWywYcqbXpaU9MKUpmt2eAQNijxujdZV5cO" +
       "ReH4hIwcfCVsKvbclte6M/XWRabFSK2ETYsLvqa3y+u+5CYm2hSWGIsPVqvS" +
       "NKYUvjuq00odmFxjtpmnkwobj4XiFJ7XWdKOCd0utDxKoxx4aXV7EzNI05E/" +
       "thiUHs28aQ98IyN+7DM9gUSLwBtLtKyxdhrU7RarDFtyLFSj2gQEiZ6Nj0UZ" +
       "G3Q7PDng58asTYgirNWc8ZiIVGRuNGcNsEENvI0RmIvN6xFplSipFtRqE2eM" +
       "w70i0y1W+6vGgpjJcx1H250ePZriKdWQR8ZgYa8xMqg1GmVsrZt9sx4hVbG7" +
       "KZQxrdNbNEyadnyzU17T3oC1h0xpTS7WvbZXG8GVxIlKUQdbwtVw5PeIdtss" +
       "y2ZAJWucgDuAliD1WIJUp4ZCNAfTCeLp2mQgrHF1wxArLU6KM6pJDdcoTdTH" +
       "hDHrpm1CG4qN8nAURzbcMeQkmW1WGwmbjsAHMuzVMa81CofUSiKDxSpwShQa" +
       "iBznlfA5YHCkLgiVaEV9ijeJFA4aHOOv5r5BxbhOM2tDDoWVzM5In+yKEdeP" +
       "5gw+HjanrIJwfE9mmBVJmC7FhXwTFvkEXnqdyrw3SqVhMmJXdLO64vQh0WLX" +
       "4RSpdyZr268tY4ZQkGSznmuqxveMOWN4VMNIbZepV5pK3RjUK2WilcCNdShp" +
       "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" +
       "t/8H3iQAIfohAAA=");
}
