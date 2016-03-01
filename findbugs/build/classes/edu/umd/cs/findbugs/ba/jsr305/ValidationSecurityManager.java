package edu.umd.cs.findbugs.ba.jsr305;
final class ValidationSecurityManager extends java.lang.SecurityManager {
    static final edu.umd.cs.findbugs.ba.jsr305.ValidationSecurityManager INSTANCE =
      new edu.umd.cs.findbugs.ba.jsr305.ValidationSecurityManager(
      );
    static final edu.umd.cs.findbugs.ba.jsr305.ValidatorClassLoader
      VALIDATOR_LOADER =
      edu.umd.cs.findbugs.ba.jsr305.ValidatorClassLoader.
        INSTANCE;
    static { if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
                   DEBUG_CLASSLOADING) { new java.lang.RuntimeException(
                                           "Creating ValidationSecurityManager #").
                                           printStackTrace(
                                             ); } }
    public static <A extends java.lang.annotation.Annotation> javax.annotation.meta.When sandboxedValidation(A proxy,
                                                                                                             javax.annotation.meta.TypeQualifierValidator<A> v,
                                                                                                             @javax.annotation.CheckForNull
                                                                                                             java.lang.Object constantValue) {
        if (performingValidation.
              get(
                )) {
            throw new java.lang.IllegalStateException(
              "recursive validation");
        }
        try {
            performingValidation.
              set(
                java.lang.Boolean.
                  TRUE);
            if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
                  DEBUG_CLASSLOADING) {
                java.lang.System.
                  out.
                  println(
                    "Performing validation in thread " +
                    java.lang.Thread.
                      currentThread(
                        ).
                      getName(
                        ));
            }
            try {
                javax.annotation.meta.When result =
                  v.
                  forConstantValue(
                    proxy,
                    constantValue);
                if (!performingValidation.
                      get(
                        )) {
                    throw new java.lang.IllegalStateException(
                      "performingValidation not set when validation completes");
                }
                return result;
            }
            catch (java.lang.ClassCastException e) {
                java.lang.Class<? extends java.lang.annotation.Annotation> c =
                  proxy.
                  getClass(
                    );
                java.lang.System.
                  out.
                  println(
                    c.
                      getName(
                        ) +
                    " extends " +
                    c.
                      getSuperclass(
                        ).
                      getName(
                        ));
                for (java.lang.Class<?> i
                      :
                      c.
                       getInterfaces(
                         )) {
                    java.lang.System.
                      out.
                      println(
                        "  " +
                        i.
                          getName(
                            ));
                }
                throw e;
            }
        }
        finally {
            performingValidation.
              set(
                java.lang.Boolean.
                  FALSE);
            if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
                  DEBUG_CLASSLOADING) {
                java.lang.System.
                  out.
                  println(
                    "Validation finished in thread " +
                    java.lang.Thread.
                      currentThread(
                        ).
                      getName(
                        ));
            }
        }
    }
    @java.lang.Override
    public void checkPermission(java.security.Permission perm) {
        if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
              DEBUG_CLASSLOADING) {
            java.lang.System.
              out.
              println(
                "Checking for " +
                perm +
                " permission in thread " +
                java.lang.Thread.
                  currentThread(
                    ).
                  getName(
                    ));
        }
        if (performingValidation.
              get(
                ) &&
              inValidation(
                )) {
            java.lang.SecurityException e =
              new java.lang.SecurityException(
              "No permissions granted while performing JSR-305 validation");
            if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
                  DEBUG_CLASSLOADING) {
                e.
                  printStackTrace(
                    java.lang.System.
                      out);
            }
            throw e;
        }
    }
    @java.lang.Override
    public void checkPermission(java.security.Permission perm,
                                java.lang.Object context) {
        if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
              DEBUG_CLASSLOADING) {
            java.lang.System.
              out.
              println(
                "Checking for " +
                perm +
                " permission with content in thread " +
                java.lang.Thread.
                  currentThread(
                    ).
                  getName(
                    ));
        }
        if (performingValidation.
              get(
                ) &&
              inValidation(
                )) {
            java.lang.SecurityException e =
              new java.lang.SecurityException(
              "No permissions granted while performing JSR-305 validation");
            if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
                  DEBUG_CLASSLOADING) {
                e.
                  printStackTrace(
                    java.lang.System.
                      out);
            }
            throw e;
        }
    }
    private ValidationSecurityManager() {
        super(
          );
    }
    private boolean inValidation() { for (java.lang.Class<?> c
                                           :
                                           getClassContext(
                                             )) {
                                         if (javax.annotation.meta.TypeQualifierValidator.class.
                                               isAssignableFrom(
                                                 c) ||
                                               c.
                                               getClassLoader(
                                                 ) ==
                                               VALIDATOR_LOADER) {
                                             return true;
                                         }
                                     }
                                     return false;
    }
    private static final java.lang.ThreadLocal<java.lang.Boolean>
      performingValidation =
      new java.lang.ThreadLocal<java.lang.Boolean>(
      ) {
        @java.lang.Override
        protected java.lang.Boolean initialValue() {
            return java.lang.Boolean.
                     FALSE;
        }
    };
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+uvzBnO+r7Au7bX/B3ydb/inJAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lJj2kaoeCqndxN0ZKfYxa8D1oyGJTYdtuuSpvTrcrPXKtuN1BGM+iVJng6ol" +
       "NUuoerNCqgmPdKgwqHfprlOtbdtggWRnVsX3rfVgs2D5oGLajWqpW5fjDLUx" +
       "SuGsdqq3XGs1DqtYII59N42WBLuqVzU46THuVOuD2cp3pok5XCHxtIquslJb" +
       "hrsrcWrWnF6PSYFNsJHKO+pwhiP1JmVns63pSqMNGnvNIdbEMLUVwEnUCf2W" +
       "02XrHauDeC5pis5gLG/Ccm+2xvVeOluUqhO0lw6mA86OiXZtrsdobWjExqwx" +
       "aa7kboWahMoIQ1XYzDYY1SSnHVsiGt3aSJZK6zLt4FWVH/IguaG2DYFbipi3" +
       "XTUn6EqtSEI9a06mWd1JRuJ81jbmJX4pEovekiP9mSNNq2y9OUXgbj9ts5N0" +
       "GmVZp1fjNI00q3N/QrTgBl4V0o468iVXX0rlMbvE1WRt9pB1kDCZPSMjI0Ln" +
       "szgwRDexquOM5OcygUhr0xpPiS6ShdZyhHN8NI7dmYJnWbJQzWqd39hpb1vF" +
       "KhJIDWWJxzgQgrUM8eCowS9iSsfTCAO5QBkEfANJIrIlx5XpFpuUQRobIK3l" +
       "lJIsKlMooeRgzXUp6NWMtExRNh3U9BLSj6VxIhodq9k1Z1ZpWWfI9XJVizdk" +
       "Y0EHvQxFPXhSa7S41Rov0QHa4WVrXQ3EqZY2tel2Wm8GzLYcwmCNlUqbLuys" +
       "hliWmI7hx+02XPK0qjpmqOpE7TJ1m1QnyAYXGFwUxM3cjEGn43TiqNZ6ZVO4" +
       "OZZZsNybBaNmlWI7OFg0DUsIO2xMvSmhaAQj9t1mhs4nVVtgIs2gOn0TE5dr" +
       "kd/Qi7JcijcZ4dCloI7H9dUcJipbeQUbzgDH8Xzb56ff2s7bw8Um48mlIdOq" +
       "5xUvv4Udp/TiDq/sujk5dSn+7oLOXT05depyZs81DKCnLrsdVOypfebDr7wq" +
       "058tHxxt0H4sgu6NXO+HLWWjWKdYXbvzAcyouBy1P3H87Q//2ZP8j+rvfwsX" +
       "KZ45J+d5lr8w+vyXut8v/fQBdPXk/PG2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("a1tniV48tykfKFEcOPyZs8enTixbnPPi4HnhyLIvnD/P2o/mxad0O7/YucS5" +
       "0/OrO+8pfisnXT6a9/ADd+ryg/m/dQQ9zrB0i2xPWfLsFn3R7DP5Fj1+vJ/9" +
       "zH53eW/4UyfyO1+av+FhBFpc+IH3PGBbicTirGUSi1a+sxycnCjednRV3GdI" +
       "T0uQUx9eTJ3T/EpB+f5Lj49OWe7vXeicq10IUZx2FADwWlH6uQsOMXbtf+EO" +
       "9yN+oxiVCHo0FB155aaKfOok88hAT15soJmuOHvA+OwbbVEfFlY6AYrP7dr/" +
       "3ImH5ddWIAQ89JGH0W/BqQuWH7jQn4/6PFbmicLnwqMLW4eMEthGmB+0FMS/" +
       "cwdT/X7++s0IuiHpirTeExaNP3oKNP9lBF3buIa8N85vnTXOAyfGORHrkVOn" +
       "VRslCAxZuQMA337d4yJj5pQvHRnzpb8fYx7sIeTLewf76h2s9vX89ZXbrZYX" +
       "/6e9hf74Ugvlxf/le7HF2/PCZ8HjHNnCeau2+MELbXFay2/eoe5b+et/RdAD" +
       "hnMuts45zd2r3Wnk3ip/8maC6uTGTwS989Irifn1qiduuyO9u9cr/dKrN+55" +
       "/NXpfytu5Z3cvb2Xgu5RY8s6fRvm1Pd1L1BUo9Dw3t3dmJ0z/FUEPXXHyx0R" +
       "dH33UWjwnR3VX0fQYxdTRdDBSjzd9G8AWl3QNALSHn2ean0FIO19+9aAmXSm" +
       "+iow+1F1BF0F79OV10ERqMw/7/aOI/Wdpw5hz9o4vXI2ozkZxkfeaBhPJUHv" +
       "ufQ+wyjeXX+/Jb326mD8gW9jn93dRgRTQ5blXO6hoLt3FyNPUpXnLuV2zOt6" +
       "7/nvPvjL9773OK16cCfwPiROyfbMxTf/SNuLirt62a89/is/8vOvfrU4HP5/" +
       "Q3dPOJUwAAA=");
}
