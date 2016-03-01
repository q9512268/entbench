package edu.umd.cs.findbugs.detect;
public class NumberConstructor extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    static class Pair {
        final edu.umd.cs.findbugs.classfile.MethodDescriptor boxingMethod;
        final edu.umd.cs.findbugs.classfile.MethodDescriptor parsingMethod;
        public Pair(edu.umd.cs.findbugs.classfile.MethodDescriptor boxingMethod,
                    edu.umd.cs.findbugs.classfile.MethodDescriptor parsingMethod) {
            super(
              );
            this.
              boxingMethod =
              boxingMethod;
            this.
              parsingMethod =
              parsingMethod;
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcRxWfO9vnj9g+fyROyFcT1yly6t420BSl55QkF5s4" +
                                                                  "PX8odiJxgVzndud8G+/tbnZn7bNLoa2EmiIoQU3TgKj/SlUpKm2EqOAPWhlV" +
                                                                  "QFEBqaVACyIg/ioqEY0QLSJ8vZnZvf24u1T8g6WbG8+8j3lv3vu9N/fcNdRi" +
                                                                  "W2g70WmKLpvETo3pdAZbNlEyGrbtOVjLy0814b+eemdqXxwlcqi7hO1JGdtk" +
                                                                  "XCWaYufQNlW3KdZlYk8RojCOGYvYxFrEVDX0HNqg2hNlU1NllU4aCmEEJ7CV" +
                                                                  "Rb2YUkstOJRMuAIo2paFk0j8JNLB6HY6izplw1z2yTcFyDOBHUZZ9nXZFPVk" +
                                                                  "T+NFLDlU1aSsatN0xUK3m4a2PK8ZNEUqNHVa2+u64Gh2b40LBq8k379xrtTD" +
                                                                  "XdCPdd2g3Dz7GLENbZEoWZT0V8c0UrbPoM+jpixaFyCmaCjrKZVAqQRKPWt9" +
                                                                  "Kjh9F9Gdcsbg5lBPUsKU2YEo2hkWYmILl10xM/zMIKGNurZzZrB2R9VaYWWN" +
                                                                  "iU/eLp1/6lTPt5tQMoeSqj7LjiPDISgoyYFDSblALPugohAlh3p1uOxZYqlY" +
                                                                  "U1fcm+6z1XkdUweu33MLW3RMYnGdvq/gHsE2y5GpYVXNK/KAcv9rKWp4Hmwd" +
                                                                  "8G0VFo6zdTCwQ4WDWUUMceeyNC+oukLRLVGOqo1D9wEBsLaWCS0ZVVXNOoYF" +
                                                                  "1CdCRMP6vDQLoafPA2mLAQFoUbS5oVDmaxPLC3ie5FlERuhmxBZQtXNHMBaK" +
                                                                  "NkTJuCS4pc2RWwrcz7Wp0ccf0I/ocRSDMytE1tj51wHT9gjTMVIkFoE8EIyd" +
                                                                  "u7MX8MBLZ+MIAfGGCLGg+e7nrh8Y2b72qqDZUodmunCayDQvXyp0v741M7yv" +
                                                                  "iR2jzTRslV1+yHKeZTPuTrpiAsIMVCWyzZS3uXbsR59+6DJ5N446JlBCNjSn" +
                                                                  "DHHUKxtlU9WI9SmiEwtTokygdqIrGb4/gVphnlV1Ilani0Wb0AnUrPGlhMH/" +
                                                                  "BxcVQQRzUQfMVb1oeHMT0xKfV0yE0Dr4oB743IPEH/+mSJZKRplIWMa6qhvS" +
                                                                  "jGUw+20JEKcAvi1JRQimgjNvS7YlSzx0iOJITlmRZNvfVAgFNmnKYcmT8aM+" +
                                                                  "xTjM/4+aCrO2fykWg4vYGoUBDTLoiKEpxMrL551DY9efz78mQoylhesnivaA" +
                                                                  "1hRoTcl2ytOaElpTNVqHZrBqoViMa1zPjiCuHS5tAdIf8LdzePazR+8/O9gE" +
                                                                  "8WYuNYPHGelgqA4FBHrAnpdf6Ota2Xl1zytx1JxFfVimDtZYWTlozQNgyQtu" +
                                                                  "TncWoEL5hWJHoFCwCmcZMthjkUYFw5XSZiwSi61TtD4gwStjLGGlxkWk7vnR" +
                                                                  "2sWlh0984c44iodrA1PZArDG2GcYoleReyiKCfXkJh995/0XLjxo+OgQKjZe" +
                                                                  "jazhZDYMRmMi6p68vHsHfjH/0oND3O3tgN4UQ7YBMG6P6giBT9oDcmZLGxhc" +
                                                                  "NKwy1tiW5+MOWrKMJX+FB2svn6+HsEiybOyHz343Pfk32x0w2bhRBDeLs4gV" +
                                                                  "vFDsnzWffuvnf/o4d7dXU5KBZmCW0HQAx5iwPo5YvX7YzlmEAN3vLs488eS1" +
                                                                  "R0/ymAWKW+spHGJjBvALrhDc/MVXz7z9+6uX3oz7cU6hkDsF6IcqVSPbmE3d" +
                                                                  "NzEStN3mnwdwUIO8Y1EzdFyH+FSLKi5ohCXWP5O79rz458d7RBxosOKF0ciH" +
                                                                  "C/DXP3IIPfTaqQ+2czExmdVh32c+mQD3fl/yQcvCy+wclYff2Pb1H+OnoUwA" +
                                                                  "NNvqCuFoG+c+iHPLN1GUqocqvMth4J2a5HX6MLFlSzXBm4zrbn7he7mEO/l4" +
                                                                  "F3MWl4v43j427LKDiRPOzUCvlZfPvfle14n3Xr7OLQ03a8E4mcRmWoQmG26r" +
                                                                  "gPiNUWA7gu0S0N21NvWZHm3tBkjMgUQZOhR72gKArYSiyqVuaf3ND14ZuP/1" +
                                                                  "JhQfRx2agZVxzBMUtUNmELsE2FwxP3lABMZSm1utUAXVGF+zwC7nlvrXPlY2" +
                                                                  "Kb+ole9t/M7os6tXeYSaQsYW95agXIQQmbf8Pihc/sUnfvns1y4siaZhuDES" +
                                                                  "Rvg2/WNaKzzyx7/XuJxjYJ2GJsKfk5775ubMve9yfh+MGPdQpbbEAaD7vB+7" +
                                                                  "XP5bfDDxwzhqzaEe2W2xT2DNYSmeg7bS9vpuaMND++EWUfRD6SrYbo0CYUBt" +
                                                                  "FAb90gpzRs3mXRHkY3iARuCTdkEhHUW+GOKT+zjLR/m4mw13eEDTAjmFtQjO" +
                                                                  "dN1EJIXCaVSg9RWZx/NN4Csb72FDVojb3zAix8IW3AGfUVfdaAML5oQFbJiq" +
                                                                  "PWwjboq6AGXtm572+E1OW2not4TN3z6+43g6dUSbxCBA+2mDGDZsa9TH8zfI" +
                                                                  "pUfOryrTz+wRidMX7o3H4On3rV/966epi3/4SZ1GLOG+w4IKKWpmHZeHqiP/" +
                                                                  "S68Gh91U8zQUzxn5+dVk28bV47/mVb/65OiEell0NC0YxIF5wrRIUeXB3ClC" +
                                                                  "2uRfKryiGh8MDBMTbkRJsEBa9ddhoaDfnQapDYo6fGqK4nJoG5qVVneboiYY" +
                                                                  "g5sOLMEmmy6anh97OHSybE+JbK/EwvdcDbMNH5YUgdC4NYST/PHu+n3SEc93" +
                                                                  "6HJXj049cP3uZ0TbAgVxZYU/9uDtKjqoanO4s6E0T1biyPCN7ivtu+JueewV" +
                                                                  "B/YTZUugdmYg/k1WNjZHaro9VC3tb18afflnZxNvQHCeRDEMd3SyFhcrpgNZ" +
                                                                  "cDLr14/Ajz+82UgPf2P53pHiX37LKw8SL4CtjekB9594a+LKwgcH+GuxBSKA" +
                                                                  "VDhgH17WjxF5EUpmm6OrZxwyoWRRNwtXzJ7x3A+u+7qqq6zJpWiw5r1e52kA" +
                                                                  "VXmJWIcMR+cY0wVFy18J/YrgpkCHY5oRBn+lenXra23Ny4cfS37/XF/TOKRc" +
                                                                  "yJyg+FbbKcx5VSP4w4JfRnoEdP0H/mLw+Tf7sEtmC+wbalnGfWTvqL6yofyL" +
                                                                  "vaZ8dtI0Xdq2OVNkxFk2fKnClimK7XZXWb8RE8DJ/v0KV/9lPmXDV/8LqkHz" +
                                                                  "q2MUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "S6QyjQQfAAA=");
    }
    private final java.util.Map<java.lang.String,edu.umd.cs.findbugs.detect.NumberConstructor.Pair>
      boxClasses =
      new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.detect.NumberConstructor.Pair>(
      );
    private final java.util.List<edu.umd.cs.findbugs.classfile.MethodDescriptor>
      methods =
      new java.util.ArrayList<edu.umd.cs.findbugs.classfile.MethodDescriptor>(
      );
    private final edu.umd.cs.findbugs.BugAccumulator
      bugAccumulator;
    public NumberConstructor(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        handle(
          "java/lang/Byte",
          false,
          "(B)");
        handle(
          "java/lang/Character",
          false,
          "(C)");
        handle(
          "java/lang/Short",
          false,
          "(S)");
        handle(
          "java/lang/Integer",
          false,
          "(I)");
        handle(
          "java/lang/Long",
          false,
          "(J)");
        handle(
          "java/lang/Float",
          true,
          "(F)");
        handle(
          "java/lang/Double",
          true,
          "(D)");
    }
    private void handle(@edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                        java.lang.String className,
                        boolean isFloatingPoint,
                        java.lang.String sig) {
        edu.umd.cs.findbugs.classfile.MethodDescriptor boxingMethod =
          new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          className,
          "valueOf",
          sig +
          "L" +
          className +
          ";",
          true);
        edu.umd.cs.findbugs.classfile.MethodDescriptor parsingMethod =
          new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          className,
          "valueOf",
          "(Ljava/lang/String;)" +
          "L" +
          className +
          ";",
          true);
        boxClasses.
          put(
            className,
            new edu.umd.cs.findbugs.detect.NumberConstructor.Pair(
              boxingMethod,
              parsingMethod));
        methods.
          add(
            new edu.umd.cs.findbugs.classfile.MethodDescriptor(
              className,
              "<init>",
              "(Ljava/lang/String;)V"));
        methods.
          add(
            new edu.umd.cs.findbugs.classfile.MethodDescriptor(
              className,
              "<init>",
              sig +
              "V"));
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        int majorVersion =
          classContext.
          getJavaClass(
            ).
          getMajor(
            );
        if (majorVersion >=
              MAJOR_1_5 &&
              hasInterestingMethod(
                classContext.
                  getJavaClass(
                    ).
                  getConstantPool(
                    ),
                methods)) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        super.
          visit(
            obj);
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    private boolean matchArguments(java.lang.String sig1,
                                   java.lang.String sig2) {
        int lastParen =
          sig1.
          indexOf(
            ')');
        java.lang.String args =
          sig1.
          substring(
            0,
            lastParen +
              1);
        return sig2.
          startsWith(
            args);
    }
    @javax.annotation.CheckForNull
    private edu.umd.cs.findbugs.classfile.MethodDescriptor getShouldCall() {
        java.lang.String cls =
          getClassConstantOperand(
            );
        edu.umd.cs.findbugs.detect.NumberConstructor.Pair pair =
          boxClasses.
          get(
            cls);
        if (pair ==
              null) {
            return null;
        }
        edu.umd.cs.findbugs.classfile.MethodDescriptor shouldCall;
        if (getSigConstantOperand(
              ).
              startsWith(
                "(Ljava/lang/String;)")) {
            shouldCall =
              pair.
                parsingMethod;
        }
        else {
            shouldCall =
              pair.
                boxingMethod;
        }
        if (shouldCall ==
              null) {
            return null;
        }
        if (matchArguments(
              getSigConstantOperand(
                ),
              shouldCall.
                getSignature(
                  ))) {
            return shouldCall;
        }
        return null;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen !=
                                            INVOKESPECIAL) {
                                          return;
                                      }
                                      if (!"<init>".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          return;
                                      }
                                      java.lang.String cls =
                                        getClassConstantOperand(
                                          );
                                      edu.umd.cs.findbugs.classfile.MethodDescriptor shouldCall =
                                        getShouldCall(
                                          );
                                      if (shouldCall ==
                                            null) {
                                          return;
                                      }
                                      int prio;
                                      java.lang.String type;
                                      if ("java/lang/Float".
                                            equals(
                                              cls) ||
                                            "java/lang/Double".
                                            equals(
                                              cls)) {
                                          prio =
                                            LOW_PRIORITY;
                                          type =
                                            "DM_FP_NUMBER_CTOR";
                                      }
                                      else {
                                          prio =
                                            NORMAL_PRIORITY;
                                          java.lang.Object constantValue =
                                            stack.
                                            getStackItem(
                                              0).
                                            getConstant(
                                              );
                                          if (constantValue instanceof java.lang.Number) {
                                              long value =
                                                ((java.lang.Number)
                                                   constantValue).
                                                longValue(
                                                  );
                                              if (value <
                                                    -128 ||
                                                    value >
                                                    127) {
                                                  prio =
                                                    LOW_PRIORITY;
                                              }
                                          }
                                          type =
                                            "DM_NUMBER_CTOR";
                                      }
                                      edu.umd.cs.findbugs.BugInstance bug =
                                        new edu.umd.cs.findbugs.BugInstance(
                                        this,
                                        type,
                                        prio).
                                        addClass(
                                          this).
                                        addMethod(
                                          this).
                                        addCalledMethod(
                                          this).
                                        addMethod(
                                          shouldCall).
                                        describe(
                                          "SHOULD_CALL");
                                      bugAccumulator.
                                        accumulateBug(
                                          bug,
                                          this);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aaXAcxRXuXVmHZd0+8SHbsozL165NOEJkHKSVhAUraWMZ" +
       "VVgT1rOzLe1YszPjmR5pZWxzVCg7SdkhYAxJGf9ImTK4wKZIXOEIxCkSjoCp" +
       "4kjAIRhIUomBUMFJcVRIIK+7Z3eO3VlhElDVtEbd/br7Xd97/Ub3vovKDR01" +
       "Y4WEyLiGjVCXQmKCbuBURBYMYwP0JcTby4R/XnO67+IgqoijurRg9IqCgbsl" +
       "LKeMOJonKQYRFBEbfRinKEVMxwbWRwUiqUocTZeMnowmS6JEetUUphMGBT2K" +
       "GgVCdClpEtxjLUDQvCicJMxOEm73DrdFUY2oauP29FmO6RHHCJ2ZsfcyCGqI" +
       "bhZGhbBJJDkclQzSltXRck2Vx4dllYRwloQ2yxdYIrg8ekGBCFrur//g45vT" +
       "DUwEUwVFUQljz1iPDVUexakoqrd7u2ScMbagHagsiqY4JhPUGs1tGoZNw7Bp" +
       "jlt7Fpy+FitmJqIydkhupQpNpAciaKF7EU3QhYy1TIydGVaoIhbvjBi4XZDn" +
       "lnNZwOJty8N7b7+m4YEyVB9H9ZIyQI8jwiEIbBIHgeJMEutGeyqFU3HUqICy" +
       "B7AuCbK01dJ0kyENKwIxQf05sdBOU8M629OWFegReNNNkah6nr0hZlDWX+VD" +
       "sjAMvM6weeUcdtN+YLBagoPpQwLYnUUyaURSUgTN91LkeWy9AiYAaWUGk7Sa" +
       "32qSIkAHauImIgvKcHgATE8ZhqnlKhigTtBs30WprDVBHBGGcYJapGdejA/B" +
       "rMlMEJSEoOneaWwl0NJsj5Yc+nm3b82ea5V1ShAF4MwpLMr0/FOAqNlDtB4P" +
       "YR2DH3DCmmXRfcKMR3cFEYLJ0z2T+ZyfbTtz6Yrm40/xOXOKzOlPbsYiSYgH" +
       "k3XPz40svbiMHqNKUw2JKt/FOfOymDXSltUAYWbkV6SDodzg8fVPXHX9YfxO" +
       "EFX3oApRlc0M2FGjqGY0Scb6ZVjBukBwqgdNxkoqwsZ7UCW8RyUF897+oSED" +
       "kx40SWZdFSr7G0Q0BEtQEVXDu6QMqbl3TSBp9p7VEEKV8KAaeL6K+A/7TZAY" +
       "TqsZHBZEQZEUNRzTVcq/EQbESYJs0+EhMKakOWyEDV0MM9PBKTNsZlJh0bAH" +
       "U5gAWbjPpM4Tsa0+RCm0L2ebLOV26lggAIqY64UBGTxonSqnsJ4Q95odXWeO" +
       "JJ7hJkbdwpITQStg1xDsGhKNUG7XEN81VLArCgTYZtPo7lzjoK8R8HyA3pql" +
       "A9+6fNOuljIwNW1sEgibTm1xhSDHWjlMT4hHm2q3Ljy1+vEgmhRFTYJITEGm" +
       "EaVdHwasEkcsd65JQnCyY8QCR4ygwU1XRWBFx36xwlqlSh3FOu0naJpjhVwE" +
       "o74a9o8fRc+Pjt8xdsPgdauCKOgOC3TLckA0Sh6jYJ4H7VYvHBRbt37n6Q+O" +
       "7tuu2sDgijO58FhASXlo8ZqDVzwJcdkC4Vji0e2tTOyTAbiJAI4GmNjs3cOF" +
       "O205DKe8VAHDQ6qeEWQ6lJNxNUnr6pjdw+y0kb1PA7OYQh1xLjx9lmey33R0" +
       "hkbbmdyuqZ15uGAx4pIB7c5XnnvrK0zcuXBS78gDBjBpc0AYXayJgVWjbbYb" +
       "dIxh3mt3xG697d2dG5nNwoxFxTZspW0EoAtUCGK+6aktJ18/dfCloG3nBGK4" +
       "mYRUKJtnkvaj6hJMwm7n2ucBCJTB5ajVtF6pgH1KQ5KQlDF1rH/XL1597G97" +
       "GrgdyNCTM6MVEy9g95/Tga5/5poPm9kyAZGGYFtm9jSO61Ptldt1XRin58je" +
       "8MK8Hz4p3AkRAlDZkLZiBrQBy9fpoWZBmC4GKB3m8HqsqTrEXKbcC9jsVaw9" +
       "nwqGrYHY2MW0WWw4ncTth46UKiHe/NJ7tYPvPXaGceXOyZw20StobdwMaXNu" +
       "Fpaf6QWxdYKRhnnnH++7ukE+/jGsGIcVRUhEjH4dcDTrsiBrdnnl73/5+IxN" +
       "z5ehYDeqllUh1S0wZ0STwQuwkQYIzmpfv5QbwVgVNA2MVVTAfEEHVcT84iru" +
       "ymiEKWXrgzN/uubQgVPMGjW+xhxGX0ajggt9WWZvA8DhFy/67aEf7BvjucFS" +
       "f9Tz0M36V7+cvPGPHxWInOFdkbzFQx8P37t/dmTtO4zeBh5K3ZotjGQA3jbt" +
       "eYcz7wdbKn4dRJVx1CBamfSgIJvUneOQPRq59Bqybde4OxPkaU9bHljnekHP" +
       "sa0X8uwICu90Nn2v9aBcE1VhLzwdFgB0eFEugNjLFYxkCWuX0WYlU1+QoEpN" +
       "l+C2BScvB08SZA+6NJZYnKDqpJplWSaYLwCbbQg01A2YSYOwxpGIqlc3Tvnx" +
       "kQHM7aG5CIVj8p5HHo7HlzSIfHJLkcmebPXuQ1Xiq5kn/swJzilCwOdNvzu8" +
       "e/Dlzc8yeK+iMX9DTsKOiA65gSO2NHDBfAo/CJ5P6EMFwjpY1jfVBQUhduGi" +
       "7qKjeS4X8bL5Zt/canUk1shPvczfR7yEu6UDJ37zfv0NxZyLXewsUi/dyVfK" +
       "zptCWr/P2J9E2We3AbBAg86keY/vJZGtxWGujjbfzOZAudZGEWCfdiZoeC1k" +
       "PSFmp2+YtrTmG2/wgy+cgOOE2JNJDBw7ufNC5s31oxIEXV4t4Bf0Ga4Lei5X" +
       "bHNdXIvKJCGePrr7qYVvD05lNxLOPj05DVD091oLVMsYqDKXAZ7muHiyzsEi" +
       "YUJ8doV0UdUfXrqHs7bYhzU3zbb9n5x4a/upp8tQBSQ2FCsEHe4tcDEK+V35" +
       "nQu0boC3TqACDKnj1HABZfq29NqU783naASt9Fub1jCKZLoQeMaw3qGaSorB" +
       "qBujqk1Nc44yC6n/vD6zA/KOzyC6POcWQlFABKnXMUukEAz6MTPOQbiNTI1E" +
       "2wcGEhuuinUlBtvX97R3RLuYtWowGBjMmXODvQjH8byhrz6b60xrTJD4xWCY" +
       "NjKTi2bvdwV9NbJFduV1hKwz3DridyB/+5nmhjnu4p3fqf/5zU1l3ZB496Aq" +
       "U5G2mLgn5VZZJZi7A/fsGoMdahygFyiuwKaIdd9ekL9wg/7oODC3DF55nk3b" +
       "r9Emylm4xDdb6XJHty54Oi0FdvpEt2/7RDf62k+bWJGo5rcoyZd4GM3AhCY8" +
       "zV0dtHGfEsZp8728euuc+SCHmj1sTHDBTYBJJZhPeYc/9yHy1raHWVuX29pC" +
       "xSyZkdL6R6iXyaETG6IuaWDLE9gi/XOHV983naW+V8HTbamm20ff+z+Pvv0W" +
       "BaUA2+2iaGZMWcjVFEE4LT6XDMdUD693luCVDy2hzfL84dhPBfLUj5wXOJe8" +
       "IZHwK/Gx8uTBG/ceSPXftZrHniZ32Ywi4X2/+8+zoTveeLpIjWYyUbWVMh7F" +
       "smPPioLchZuEnSu/VnfLnx5qHe44m7oK7WueoHJC/55fOhvyHuXJG9+evWFt" +
       "etNZlEjme8TpXfKe3nufvuxc8ZYgK/XyJL6gROwmavOERYi0pq64UXVR3gBo" +
       "7RBtgiduGUDca/K2iRXYO3O4fo+pTymxmOdCXMavcPTPcaN4fh3TpYxEpFEr" +
       "qpwX2yTuao2x/JqSDdLmOmqYJW52njXC25teH9l/+j7rBlBQQ3JNxrv2fvfT" +
       "0J693GB5jX5RQZncScPr9Dx45U+3sNQujKL7r0e3P3L39p05zg5DGEiqqowF" +
       "xR/mxln7YIk6w69o8wBBFWlBScm8VPWIdSz66xcETRpVpZSNIT+ZCC9L3+Zp" +
       "R4TnrkfcxbA18EiWYUhna2WhIkUnv8U84vCUbhYVQ9WkwJHM+mDEjvNiCbG+" +
       "TJsTBDWyq4CTlA48YUvzObc0a/LSzJ+nyZHmAfboUgqXAPH/TQXzmaD4z5b/" +
       "hwr8FiutgmZVHw4JmiCmcSgpYtkR8SPg+Owkfykh/bdp8wZB5Uz6Hom/6Stx" +
       "2v3qFyFbFklb4Bm1xDFaQra0OVYImX6kHjEE7URj3EaAD0oI6yPanIEkIyMQ" +
       "MQ1h0cxg67Psw7bU/vEFeP1yOkYTim0Wb9vOXix+pP4MB8pKjJXTzk8Iqh3G" +
       "ZCCtmnIqIsjsU+Q+WxafTuiz89iHqZAd4kORNBZHulW9z5TlL8x9F8Gz1xLI" +
       "3hKy/Mzu67dYCfd9iDZW8PAEkjLJsquCWMVkP62EXubQpg6SQEMY69dEK/+y" +
       "vTpQ/yV4dRbwvOD6TMvTswr++4B/MRePHKivmnngypdZ8pn/ql0DaeQQ2IGz" +
       "gOp4r9B0PCQxfdXwciq7JQVaCZrtf7GHEM5f6OkDizjJEoKmFiEhsL/16py9" +
       "jKBqezZBQdE1vBIyDmsYdAmtc3AVdMEgfV2t5dyg6GdVBuhchywB72Snhrtb" +
       "oPDuxtxt+kTQ47h+LPItp/Wa/L9HEuLRA5f3XXvmwrv4pzMILVu30lWmRFEl" +
       "/4qXz74X+q6WW6ti3dKP6+6fvDiXlTXyA9u+NseBtBGwRo3ay2zPdyWjNf95" +
       "6eTBNY+d2FXxAuSTG1FAAP1tLKzXZzUTrj0bo4V1lVzdqW3pj8bXrhj6+6vs" +
       "iwjidZi5/vMTYvzWV3ruH/nwUvbPCuWgLJxlHxI6x5X1WBzVXUWa4kW8WlcR" +
       "D+6nhXnwhEW7WrgZ2T25W1eJOh4lsHss1dF2OwcfKn2wzUS0V9OsakTZIY15" +
       "9A7fxDnQyV7pW9d/AXpLqvlGJgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17eewk2X1Xz292Z3Znj5mdXXvN4r3Hwet2ftV3dWtNcFV1" +
       "dVVXH9VH3YGM6+o6uq6uo6uq4w2xEdjCim0l68QgZ/nHERA5cRRhQESBjRDY" +
       "Jg4iyAIbKXZASHEOo1ghIYoh4VX1b37XHOu1DT9tval+x/d9z8/7vldvP/PN" +
       "yv1RWKkGvpMbjh8f6ll8aDvtwzgP9OiQGrdnchjpGubIUcSAupvqC7909U++" +
       "/XHz2kHlklR5XPY8P5Zjy/eihR75zlbXxpWrJ7W4o7tRXLk2tuWtDCWx5UBj" +
       "K4pfHlceOjU0rtwY32IBAixAgAWoZAFCTnqBQY/oXuJixQjZi6NN5ccqF8aV" +
       "S4FasBdXnj9LJJBD2T0iMyslABQeKH5zQKhycBZWnjuWfS/zbQJ/ogq9+jM/" +
       "cu2XL1auSpWrlrcs2FEBEzGYRKo87OquoocRomm6JlUe83RdW+qhJTvWruRb" +
       "qlyPLMOT4yTUj5VUVCaBHpZznmjuYbWQLUzU2A+PxVtZuqPd+nX/ypENIOtb" +
       "T2TdSzgo6oGAVyzAWLiSVf3WkPvWlqfFlWfPjziW8cYIdABDL7t6bPrHU93n" +
       "yaCicn1vO0f2DGgZh5ZngK73+wmYJa48dVeiha4DWV3Lhn4zrrztfL/Zvgn0" +
       "erBURDEkrrzlfLeSErDSU+esdMo+35y+56M/6pHeQcmzpqtOwf8DYNAz5wYt" +
       "9JUe6p6q7wc+/K7xT8tv/dUPH1QqoPNbznXe9/ln7//We9/9zOtf2Pf5y3fo" +
       "Qyu2rsY31U8rj/7m27GXehcLNh4I/MgqjH9G8tL9Z0ctL2cBiLy3HlMsGg9v" +
       "Nb6++Lfij/+8/vsHlSvDyiXVdxIX+NFjqu8GlqOHhO7poRzr2rDyoO5pWNk+" +
       "rFwG72PL0/e19GoV6fGwcp9TVl3yy99ARStAolDRZfBueSv/1nsgx2b5ngWV" +
       "SuUyeCoPg6db2f+V/8YVFTJ9V4dkVfYsz4dmoV/IH0G6FytAtya0As6kJEYE" +
       "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" +
       "+aJ4x/FBb/l3qXLuHs+pg94zB8pRWHn6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("bletytO3T3/w1dc0+ufqB0enz/8grjwY+8EPOvpWd859M77Hl8T9ufbJh9vP" +
       "f/D3nmJ+yHzfm7i28uw5Ps+T/MeTz3yR+AH1Jw8qF48/4952B+7soJfPfW0K" +
       "9TgJPebMJ9ynjzVbXI6qvA880pFmpfNH6Ce2u80LLpTn53vbn7t/cPHETcyy" +
       "8u+fMvxrceWy4vuOLpd3ScySwr+4xw2Gf1UUn4srl0zZ0xz9TgTv2/qWduJi" +
       "//SNDkRPT1FW/PLZ6zTvAY91pBPrzerknXfUybl7HS/e6ZuCIu999ehqZknn" +
       "S/fQzH8ois+DwCs/4J4eWjT82olCvnBWIQ8fK+SYn+unPuNt9RDko/o9wvQ7" +
       "0+KzpeL2f5v/J1p8xg+NQzmQVVM/VFTdOfXdCfM1vSTxW/dQ4H8tiq/ElftL" +
       "BZ5T2lfvqrSi+svfi3qeKCpfAM/2SD3b70/gHZx82TJPgusP7qGB/1EUvxNX" +
       "HnXlWDWR0Ehc/ehi8q+cqOIb30NAVYvKArLffyTr+78/sp6W4k/v0fZnRfFH" +
       "ceURQ4+Xpp84GiY75Q3bV04E/J9vGCBPl/ctD0+A/RAzdXU98MNp4jjfc6y8" +
       "CJ5XjxT06vc/Vs7h5UXLK9HlwuW7K+7Cw0VxAFbHSE7pQAXxdDZALlz8PgZI" +
       "BlDstksBxdW5t912u31/I1v9xdeuPvDka+x/Li9cHt+afnBceWAFDHL6BtOp" +
       "90tBqK+sUl0P7u8zlZ+3LzwRV566+3UFsPbsXwq2Lzy+H/JkXHn8DkNiMP/R" +
       "6+neT8WVKye948qBeqb5abAoHjUD64DydONzoAo0Fq/PB7f88Y7XdksM3Ntq" +
       "GQNF9Uuu/TC7cDZHOvb7628U2KfSqhfvevVnkuz/74Sb6mdfo6Y/+q3Oz+1v" +
       "kwI03u0KKg+MK5f3F1uPk5/n70rtFq1L5EvffvSXHnzHrUTt0T3DJ8Fwirdn" +
       "73x1E3eDuLxsufvnT/6T9/zD175Wfpj+v7V9pzs0MgAA");
}
