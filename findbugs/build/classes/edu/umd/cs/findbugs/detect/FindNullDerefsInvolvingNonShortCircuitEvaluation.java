package edu.umd.cs.findbugs.detect;
public class FindNullDerefsInvolvingNonShortCircuitEvaluation extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private static boolean DEBUG = false;
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public FindNullDerefsInvolvingNonShortCircuitEvaluation(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) { boolean interesting =
                                                               true;
                                                             if (interesting) {
                                                                 super.
                                                                   visit(
                                                                     code);
                                                             }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == IAND ||
                                            seen ==
                                            IOR) { int nextOpcode =
                                                     getCodeByte(
                                                       getPC(
                                                         ) +
                                                         1);
                                                   if (nextOpcode ==
                                                         IFEQ ||
                                                         nextOpcode ==
                                                         IFNE) {
                                                       edu.umd.cs.findbugs.OpcodeStack.Item left =
                                                         stack.
                                                         getStackItem(
                                                           1);
                                                       edu.umd.cs.findbugs.OpcodeStack.Item right =
                                                         stack.
                                                         getStackItem(
                                                           0);
                                                       checkForNullForcingABranch(
                                                         seen,
                                                         nextOpcode,
                                                         left);
                                                       checkForNullForcingABranch(
                                                         seen,
                                                         nextOpcode,
                                                         right);
                                                   }
                                      } }
    private void checkForNullForcingABranch(int seen,
                                            int nextOpcode,
                                            edu.umd.cs.findbugs.OpcodeStack.Item item) {
        if (nullGuaranteesBranch(
              seen,
              item)) {
            boolean nullGuaranteesZero =
              seen ==
              IAND;
            boolean nullGuaranteesBranch =
              nullGuaranteesZero ^
              nextOpcode ==
              IFNE;
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    item.
                      getPC(
                        ) +
                    " null guarantees " +
                    nullGuaranteesBranch +
                    " branch");
            }
            try {
                edu.umd.cs.findbugs.ba.CFG cfg =
                  getClassContext(
                    ).
                  getCFG(
                    getMethod(
                      ));
                edu.umd.cs.findbugs.ba.Location produced =
                  findLocation(
                    cfg,
                    item.
                      getPC(
                        ));
                edu.umd.cs.findbugs.ba.Location branch =
                  findLocation(
                    cfg,
                    getPC(
                      ) +
                      1);
                if (produced ==
                      null ||
                      branch ==
                      null) {
                    return;
                }
                org.apache.bcel.generic.IfInstruction branchInstruction =
                  (org.apache.bcel.generic.IfInstruction)
                    branch.
                    getHandle(
                      ).
                    getInstruction(
                      );
                edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow isNullValueDataflow =
                  getClassContext(
                    ).
                  getIsNullValueDataflow(
                    getMethod(
                      ));
                edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow valueNumberDataflow =
                  getClassContext(
                    ).
                  getValueNumberDataflow(
                    getMethod(
                      ));
                edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefDataflow unconditionalValueDerefDataflow =
                  getClassContext(
                    ).
                  getUnconditionalValueDerefDataflow(
                    getMethod(
                      ));
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame valueNumberFact =
                  valueNumberDataflow.
                  getFactAtLocation(
                    produced);
                edu.umd.cs.findbugs.ba.npe.IsNullValueFrame isNullFact =
                  isNullValueDataflow.
                  getFactAtLocation(
                    produced);
                edu.umd.cs.findbugs.ba.vna.ValueNumber value =
                  valueNumberFact.
                  getTopValue(
                    );
                if (isNullFact.
                      getTopValue(
                        ).
                      isDefinitelyNotNull(
                        )) {
                    return;
                }
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Produced: " +
                        produced);
                    java.lang.System.
                      out.
                      println(
                        valueNumberFact);
                    java.lang.System.
                      out.
                      println(
                        isNullFact);
                    java.lang.System.
                      out.
                      println(
                        "value: " +
                        value);
                    java.lang.System.
                      out.
                      println(
                        "branch: " +
                        branch);
                    java.lang.System.
                      out.
                      println(
                        "instruction: " +
                        branchInstruction);
                    java.lang.System.
                      out.
                      println(
                        "target: " +
                        branchInstruction.
                          getTarget(
                            ));
                    java.lang.System.
                      out.
                      println(
                        "next: " +
                        branch.
                          getHandle(
                            ).
                          getNext(
                            ));
                }
                edu.umd.cs.findbugs.ba.Location guaranteed =
                  findLocation(
                    cfg,
                    nullGuaranteesBranch
                      ? branchInstruction.
                      getTarget(
                        )
                      : branch.
                      getHandle(
                        ).
                      getNext(
                        ));
                if (guaranteed ==
                      null) {
                    return;
                }
                edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefSet unconditionalDeref =
                  unconditionalValueDerefDataflow.
                  getFactAtLocation(
                    guaranteed);
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Guaranteed on null: " +
                        guaranteed);
                    java.lang.System.
                      out.
                      println(
                        unconditionalDeref);
                }
                if (unconditionalDeref.
                      isUnconditionallyDereferenced(
                        value)) {
                    edu.umd.cs.findbugs.SourceLineAnnotation tested =
                      edu.umd.cs.findbugs.SourceLineAnnotation.
                      fromVisitedInstruction(
                        getClassContext(
                          ),
                        getMethod(
                          ),
                        produced);
                    edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
                      edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                      findAnnotationFromValueNumber(
                        getMethod(
                          ),
                        produced,
                        value,
                        valueNumberFact,
                        "VALUE_OF");
                    java.util.Set<edu.umd.cs.findbugs.ba.Location> unconditionalDerefLocationSet =
                      unconditionalDeref.
                      getUnconditionalDerefLocationSet(
                        value);
                    edu.umd.cs.findbugs.BugInstance bug;
                    if (unconditionalDerefLocationSet.
                          size(
                            ) >
                          1) {
                        bug =
                          new edu.umd.cs.findbugs.BugInstance(
                            this,
                            "NP_GUARANTEED_DEREF",
                            NORMAL_PRIORITY).
                            addClassAndMethod(
                              this);
                        bug.
                          addOptionalAnnotation(
                            variableAnnotation);
                        bug.
                          addSourceLine(
                            tested).
                          describe(
                            "SOURCE_LINE_KNOWN_NULL");
                        for (edu.umd.cs.findbugs.ba.Location dereferenced
                              :
                              unconditionalDerefLocationSet) {
                            bug.
                              addSourceLine(
                                getClassContext(
                                  ),
                                getMethod(
                                  ),
                                dereferenced).
                              describe(
                                "SOURCE_LINE_DEREF");
                        }
                    }
                    else {
                        bug =
                          new edu.umd.cs.findbugs.BugInstance(
                            this,
                            "NP_NULL_ON_SOME_PATH",
                            NORMAL_PRIORITY).
                            addClassAndMethod(
                              this);
                        bug.
                          addOptionalAnnotation(
                            variableAnnotation);
                        for (edu.umd.cs.findbugs.ba.Location dereferenced
                              :
                              unconditionalDerefLocationSet) {
                            bug.
                              addSourceLine(
                                getClassContext(
                                  ),
                                getMethod(
                                  ),
                                dereferenced).
                              describe(
                                "SOURCE_LINE_DEREF");
                        }
                        bug.
                          addSourceLine(
                            tested).
                          describe(
                            "SOURCE_LINE_KNOWN_NULL");
                    }
                    bugReporter.
                      reportBug(
                        bug);
                }
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "Error getting analysis for " +
                    getFullyQualifiedMethodName(
                      ),
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "Error getting analysis for " +
                    getFullyQualifiedMethodName(
                      ),
                    e);
            }
        }
    }
    @javax.annotation.CheckForNull
    edu.umd.cs.findbugs.ba.Location findLocation(edu.umd.cs.findbugs.ba.CFG cfg,
                                                 int pc) {
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location loc =
              i.
              next(
                );
            if (loc.
                  getHandle(
                    ).
                  getPosition(
                    ) ==
                  pc) {
                return loc;
            }
        }
        return null;
    }
    @javax.annotation.CheckForNull
    edu.umd.cs.findbugs.ba.Location findLocation(edu.umd.cs.findbugs.ba.CFG cfg,
                                                 org.apache.bcel.generic.InstructionHandle handle) {
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location loc =
              i.
              next(
                );
            if (loc.
                  getHandle(
                    ) ==
                  handle) {
                return loc;
            }
        }
        return null;
    }
    private boolean nullGuaranteesBranch(int seen,
                                         edu.umd.cs.findbugs.OpcodeStack.Item item) {
        return item.
          getSpecialKind(
            ) ==
          edu.umd.cs.findbugs.OpcodeStack.Item.
            ZERO_MEANS_NULL &&
          seen ==
          IAND ||
          item.
          getSpecialKind(
            ) ==
          edu.umd.cs.findbugs.OpcodeStack.Item.
            NONZERO_MEANS_NULL &&
          seen ==
          IOR;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RVWvwQM+UbpChDZUy1/xre6/G8B7oe8fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAM16fazr5nkf77F9r33j+F7b+aoXO3Z809VhdiiJEiXBSReK" +
       "+iIpiZJISiLb9YbfpPj9Lanz2nrYEixoGnROmmGpsT/SdevcpBgabNmQzUOw" +
       "JUWDYR2KttvQptgKtGsXIMawbli2dS+pc47OOffDM5I/dgC+h3o/Hj7P732e" +
       "3/vwffnat6GH4giCA9/ZGo6fHGub5HjtNI6TbaDFx9SoMZWiWFMJR4pjDtTd" +
       "Vt7/Kzf+9LufNm8eQVdF6EnJ8/xESizfi+da7DuZpo6gG4fanqO5cQLdHK2l" +
       "TELSxHKQkRUnL46gt50bmkC3RqcqIEAFBKiAlCog+KEXGPR2zUtdohgheUkc" +
       "Qn8FujKCrgZKoV4CPXdRSCBFknsiZlpaACQ8XPxeAKPKwZsIevbM9r3Ndxj8" +
       "GRh55ed+7OY/fAC6IUI3LI8t1FGAEgl4iAg96mqurEUxrqqaKkKPe5qmslpk" +
       "SY61K/UWoSdiy/CkJI20M5CKyjTQovKZB+QeVQrbolRJ/OjMPN3SHPX010O6" +
       "IxnA1ncdbN1b2C/qgYHXLaBYpEuKdjrkQdvy1AR63+URZzbeokEHMPSaqyWm" +
       "f/aoBz0JVEBP7OfOkTwDYZPI8gzQ9SE/BU9JoKfuKbTAOpAUWzK02wn0nsv9" +
       "pvsm0OuREohiSAK983K3UhKYpacuzdK5+fn25MOf+nFv6B2VOqua4hT6PwwG" +
       "PXNp0FzTtUjzFG0/8NEPjj4rveurnziCIND5nZc67/v8o7/8xkc/9Mzr39j3" +
       "+XN36cPIa01JbitfkB/7jfcSL7QfKNR4OPBjq5j8C5aX7j89aXlxE4DIe9eZ" +
       "xKLx+LTx9fm/En7yl7Q/OYKuk9BVxXdSF/jR44rvBpajRQPN0yIp0VQSekTz" +
       "VKJsJ6Fr4H5kedq+ltH1WEtI6EGnrLrql78BRDoQUUB0Ddxbnu6f3gdSYpb3" +
       "mwCCoGvggh4FVw3a/5X/E+hlxPRdDZEUybM8H5lGfmF/jGheIgNsTUQHziSn" +
       "RozEkYKUrqOpKZK6KqLEh0ZVS8AwpA9+T1LH6YKJ0WPSy0AgAA+b+B5r+lFC" +
       "WJGSWkkvk5y0DKbjQmDw/4UWmwKrm/mVK2Aa33uZRBwQf0PfUbXotvJK2um9" +
       "8cXbv350FlQnKCcQDZQ6BkodK/HxqVLHe6WO36pS0JUrpS7vKJTbuxNwBhvQ" +
       "CiDcR19g/xL1sU+8/wHgx0H+IJjJoityb94nDkRElnSrgGiAXv9c/lOLn6gc" +
       "QUcXCbwwCFRdL4ZPC9o9o9dblwP3bnJvfPyP/vRLn33JP4TwhRXhhFnuHFkw" +
       "w/svQx/5CkA10g7iP/is9OXbX33p1hH0IKAbQLGJBEICsNczl59xgSFePGXb" +
       "wpaHgMG6H7mSUzSdUuT1xIz8/FBT+sRj5f3jAOO3FSHzIrhaJzFU/i9anwyK" +
       "8h17Hyom7ZIVJZt/hA1+/nf+9X9GS7hPif/GuaWU1ZIXz5FNIexGSSuPH3yA" +
       "izQN9Pvdz03/5me+/fEfKR0A9Hj+bg+8VZQEIBkwhQDmv/aN8N996/e+8JtH" +
       "B6dJwGqbyo6lbM6MLOqh6/cxEjztBw/6ALJygHsXXnOL91xftXRLkh2t8NL/" +
       "deMD1S//l0/d3PuBA2pO3ehDby7gUP8DHegnf/3H/vszpZgrSrFYHjA7dNsz" +
       "8JMHyXgUSdtCj81P/dun/9bXpZ8HXA74M7Z2WkmJV04Cp1DqnWBBvVvwdlJj" +
       "rgUgPrWonFyk7P3BsjwugCllQGUbWhTvi88HycU4PJf83FY+/ZvfefviO//s" +
       "jdKqi9nTeZ8YS8GLezcsimc3QPy7LzPCUIpN0K/++uRHbzqvfxdIFIFEBaQM" +
       "MRMBztpc8KCT3g9d+/f/4mvv+thvPAAd9aHrji+pfakMRugREAVabAK62wR/" +
       "8aN7J8gfBsXN0lToDuP3zvOe8leRf75wbx7qF8nPIZTf8z8ZR375P/6PO0Ao" +
       "Gegua/6l8SLy2uefIn74T8rxByooRj+zuZPHQaJ4GFv7Jfe/Hb3/6r88gq6J" +
       "0E3lJAtdAP4tAkwEmVd8mpqCTPVC+8Usap8yvHhGde+9TEPnHnuZhA7rB7gv" +
       "ehf31y/xzpMFyi+Aq34SkvXLvHMFKm/wcshzZXmrKP58OSdHCXQtiKwMpBgg" +
       "4OMy4T0J+D8Df1fA9X+Kq5BaVOwzgyeIk/Tk2bP8JABr3EPdXocf3H+Wp5Hl" +
       "AgrLTjIz5KUnvmV//o9+eZ91XZ7SS521T7zyN/7s+FOvHJ3LdZ+/I908P2af" +
       "75aYvb0oBkWQPHe/p5Qj+n/4pZf+6d976eN7rZ64mLn1wIvJL//W//7m8ed+" +
       "/9fustBfk33f0SRvz/dFWS+Kzh7V5j2j5sMXafa94MJO5hS7x5xyd5/TPeUM" +
       "Euht8oGiiqrKJZ34N9Vpj9kVsBg8VDtuHpcCfuTuT32guP2houiD3oAlJedU" +
       "j3evHeXWqcsswBsUCONba6d5Sq83SwYqAuZ4/9pxSc/B/7OeYHYfOwgb+eAN" +
       "5pN/8Olv/szz3wIzRUEPFSmUBqb03BMnafFS99df+8zTb3vl9z9ZLoCA+dkX" +
       "5P/60UKq9qbWFsXtU1OfKkxl/TRStJEUJ+NyzdLUM2upc/ZMErDy+d+DtcmN" +
       "3xnWYxI//RtXRQ3tKIu5jaSoXWPFuKLPR1K7s8KdETla0r5grTk56KEiFbju" +
       "bmnQwVDPvKTW3qnV5gjRNLe2JfrSustT9pxuzFlPpZARTqtT0+rbQhNfdGO6" +
       "yxik73doZZUvDWFIEyTmw0PUQydos9bTEnw3jXfdarO928KtXRVBUZ0Zetio" +
       "2jdcCeTxVrNDGdVwPvQrEzYU+/auv4jD3aTSVUK0GjvZKutiej3KsXnNHO9I" +
       "diIOljLlR5XRIuguiL4VSht2PgkcAQl4RxkvTdZqROueM6nIAjfmpS0c0b0w" +
       "jskaZrt0ry4440rDZf2tyMaUm4xbZj5eE8wQZxviplfN2WEK0zarShN2pWP6" +
       "GKm4A6Un1mQ1YzeDZTqSg1UvkNaT/loRFha6crghvfGllJMWC68nBmtbQ8O+" +
       "UKcnMZvR/VGn4msyiiSGikn9sEYsg4GN1WFKdDHLCeFxZcDqE9mFp2w0Xa41" +
       "bhQQATNY17iB5pKNnTbJQ3Fe686yiItHKdVmJlwsV5p2fdSDg2pAzEleWsKk" +
       "LdiW4ww5uusNNIMft5Sa7lj2UNzMFr4pigOyXc0VdDXNuiyqR+xoQmJzsSJI" +
       "s+HcFYRRlyIIixfNKZ9MBNvezRozVwwFJjclK2RDO284LlZ1RjN3PM/GXlUZ" +
       "qYk/mOgu4JMmvrYIGeQF40meWYFsdhm5HfJhyHccz0sjkiZW6WaYz2OexDfj" +
       "7bKD7pxRGCv8SPFIPyVow8/VaovsLfvhKmC3635TCqsW55M0SswXc4qtaMN8" +
       "uqxMetukovQ6HC9LW5Pqr+YpOyUkB2NNTBx0Nb9jEUuVqZMeTpEoQ1R2hhP3" +
       "KTnv+Rrc3C309lKd1Lwo4XAKV9oUHWakvh3HktGKa/acq9KzWadGmRVkVF+5" +
       "XtprZoQ57tqMMKSEuIlmKOe65iqhGvWl0qpn46VixCJKy/0Z7FLrDUJSQqOx" +
       "WGx7UttfxPQgaXmMAG9nS82mawqex3nCj7kOO2zmG1rS9elgOUPYyXjg+WRz" +
       "uY2SQGzRjBgH9WqfWkoYZg44wZuLHVicRwt7TSKozQX19TaW+nKlC1yjv5zD" +
       "wcJzVpHSQIx6wM5walHFu8VEsC0YHmy6o9Z0qcxmaWSQPJqves2eibZ28ZqR" +
       "KvK4QscuG7gmpk66PL+qR4Rvcfik6vqWkwc+qyYhvaR5rYG1CXsoL3dbyYxT" +
       "YUJt3Y6YdFS43U7D1BTGdnOEJcMe2ZkSue5U5G1quNbWdWUijcXqhpXnjXGP" +
       "nfs6Qde39CAV7Vpv5nYHHb4349khXE2T0A7CdcvEmimsjytq3zOFicV3HUlM" +
       "55JA+ATXW9h0g/JoixasII/47YyvR7vxPJV6TL23W+ODGKfrqDprqFltKEfh" +
       "YlEf64N5dyH0QiVta0vUJeM2LMw2tNmOPA6rNiZzh2oxNmM3JEr0RNuPAsmv" +
       "icCV+M0GAN0L8IY35ioDaorHo7Gk+Vt2ELEg1yP9BZ2tq2MO3rhiUxrMuHqL" +
       "7EyG261k2wjM9cDru2zWYHjS2xFIsO0u2wK+YkbbmZLzprCb9RRW4j1WlndI" +
       "G40GbQadrdTVhhpR7aZVlaxuL+2iJsXvMKulj4YVjDE4ZhfWa6HaWbg4O+/2" +
       "cNlL8u4G9lWN5zrjgO3mtKd2x1HIWXwV7XW3jTVmTrIuujJcvdGayMmA5NV6" +
       "f1fT1JjRdaYbrfKhpCnDrBLXcX6KD5LhepRqiONFKCyFu1QPG357rggzcVHR" +
       "9N7ciuY5JTaDNG27dp+R2qmL5E0v01KvErWrrhBLO940UWFj4KtcYI1GkmpZ" +
       "NlhUK3VV7w5jeO128bjPzKjags4tCpFY0wiIvFbn02mdyGh7Zms2OuwbaIuv" +
       "2AFv086gv0akqGnEtq5no0kfJnv0dGWjS69fw90moqmo7bhqpo1g1c49yp20" +
       "VU/2uPmEFhoLShMaEUtN6XmKLPum2m6xkT+tGG08CxdjXmhaJKsvbclr8DjD" +
       "50GSMs0aNTDwoMpwg0wYTbOARelqb+PhsilUVUupD53unEKGwyhMFv1Gu55l" +
       "XKcNN1r2bkUESK7pVUuosRV2pfSoeKRUOvDK7PaqdrLspFIynfSRlZBgdYMx" +
       "GJzkRcncRniPE7qy19p2PNVG1Qht15UUqzWwhEwppRKOQr5JAZemqKCHr/it" +
       "0SEa9d10tWUUgSY11xRS2rLZLDS6XXngJyRINgx5PQ8cTJ7U14tdNa93OHRu" +
       "T2cMBWfd2pRt0b1supPq+LDr9xtIozGb6rVubBI+wrRCY7Xs6oiXT0Ih1TOk" +
       "OrAVv4FSQmjl03COMcO2LA+AmwAn0rqd6rzWqNuzYZ2ppZm+mbVTxAxkHukG" +
       "DNZTSYuprbAxMfO7jDKne7VEZypMIG8ytN92rSAMw5yIiTptNNp2jRg6qeEv" +
       "UI9Es0o+9id5Mqnh3pQ1FHxhiPORzdW3zUVryy9bK6E5oRSqtZ7MxMCghoxG" +
       "tKop6RkG0Ur6krGz15Na0ExHWtai52sOpQg1Jjoq7Tj4Bh14XFRtKVTaCmvT" +
       "fN0iFzsr3czGW7lV61ak1jiTVzAj1FptKuUmIADa2Fxgk1yvL3OOG7ZIrzNu" +
       "I61e3435Ka9hlU0Am8qKNrCKyEewO8cNxmKqiT5oBy2YNGYk43aMcVKrNur1" +
       "KYnqaU/Aw7XVHFl2fYquVxZMjHr5UhDSRcJKcw32MyXboHKrPu6pSZ6my6zW" +
       "13BYGdeRFpYg07kut5sBSFsWiTpL1AUNwnKBGwspjEQ9i0lfFeFE9zaoVF1k" +
       "YpeBK1Y7Ym20Fs0ybKUvmThhNHznDv1E6aBybwaP857jM6rZpQaTbCrMxysu" +
       "srARzVVhqlrBuW00JFR1wQo9Plx0DZxrZbJP0Lwg9WoYm0uNBa7IXH9urGYb" +
       "1VTQvskhWEAJw7XFaf201hlViN7SWScdxVXq6XA6NTQOR0St73EbdCqMeX+e" +
       "rsIhq4Rmg034NWW2YxkG/NxR+iuxvaua8FjFtMaOFq1NhFRiihvCK4Nl0mjT" +
       "quELUVtG3qod11YNVFQNrNrEaNzxSXvYDkD65VT7rQA1dbtv8F3P9+M+gpFp" +
       "1ohRl+LEIBXR5mAFw954M6VjNcXqTBquIobn4YEyWrGkjUWb7WZG81xIyZLK" +
       "jVV7tqF2SYechWJoTlq7ut4TK16NVexGGjl4rM+WMjvrNpXZMlxxTYfIG3hd" +
       "VavrPjvFKhG7FsgAhEylL9FG3iejaGfkLC8M8m5/TPF21Bk3ET4WjXlrZyCy" +
       "rBNxZmArnq8iyXxJ95R4FiwH05FPY0STjpcNPGPjXISp4UBPwZvFoCYgk+p2" +
       "2BstHSsH/o+NoslE4dLYl/HmOoa7wWq9mKWNbtCcrAOh5mEZ3cnJUMY2+Igm" +
       "FNrGHMJD0gaPauguoIdzq7ddW5KqzzZuulSmi3kHrWg5zAlred6hWo6VySnd" +
       "7ng7ygpErVKrEKw7Izprs57YXE2vmXXGx9ROqz2fb50hXTOEAcbX88ZCHpg4" +
       "3OxwjbUpy6xrb0h+AV7K03qSeYN1dTGrM1NBJ+E55YC8scavNnGsYj6ByZvm" +
       "CrMm3gb4ETIQonoq0ex4s459pNvMkyWjYX47sxpLbKVUEmqZi8iwlVNoZ92D" +
       "14tlSto65tEgvx73MZZPQzzFdJCz215tuluMO2RtqtlSfeDR+Wi03tWZjj4J" +
       "scU094ZsRZ2SMZE1mLEAGKkaaPl8M+iChgyrGXF1KmRjjpRxVJEalUkirAf0" +
       "aKFwk7WFpU1nnZOc4m8ULayjIbrmvSpSmTSGdakyhrWQaOgJ1hmxyEYLkbxd" +
       "GXOLQT2ojanmYLpsVTdhHrfIKkCXCUKaR9CxGHU6q9zr8n2iraRdmKKk1m4c" +
       "Zr2eITcZDNFqy9a2knYZ0ZrFcF3WzZCZjPOc6jtRVp/ABpHLm/aish7uWhHr" +
       "k9NOQHostnNWTOKOUjbbGqnrrca1CurT8HIJ48Ea2YpKtnDRzaQN+zqzw80M" +
       "k3fhFltVN91ZYtcmwoIfpAOeWjZ6RL7K7GjEt6J5WEVVeMxMTWmu2+tc2HWU" +
       "SVqhdllLU4T5iO4gCblMaWbHGMFKlVpKxkSUB2OhPhsyziKhWHzUlFmQZLUM" +
       "cRLklSSWRlxjkjMMsTKrNRVthC3NXoVNFclrW97igtZoG7d0h9dTPfKyujxE" +
       "I3iI0MkSj5cWs2qFsafOgFd5SrtTnYgYHrGIiQ7bWtdvNgNzgbWSgWhL+pDK" +
       "plaYVYYLCluLkZpIvdjD67I8byq2rg43XmcS57iRKcMYSUyBmyg4Vu02641B" +
       "0vYH42Z/vlhm+WwM83JAmF2R31aRTaRhyKDVafpaSwdv8h8pXvHDt7b18Hi5" +
       "y3J20rt2mkWD9BZ2F/ZNzxXFB852o8q/q9Cl08Hzm/6HHV6o2F57+l4HuOXW" +
       "2hdefuVVlfmF6tHJNhWTQI8kfvAXHC3TnHOirgJJH7z3NuK4PL8+7Nh+/eU/" +
       "for7YfNjb+G86n2X9Lws8u+PX/u1wQ8qP3sEPXC2f3vHyfrFQS9e3LW9HmlJ" +
       "Cl43LuzdPn3xzOhZcH3kBNmPXN7nO8zdHV5wpfSC/dxfOni4dHjxjB8Zx1Ig" +
       "KaZ2LCuac1x+Q1EcDR8T4P2hFPHx+5xdfLIoXk6ghzIrtpK77mJlvqUeXOyv" +
       "XnSxR89c7EylJw7bb0ymRZGlavfxyjtPFcqKn7gI5PPg6p8A2f/+A3nJ5Acs" +
       "LynH/O37IPd3iuKzwMFjKWcCBYBdVPz0AamfuydSRfXPfi+YFOf50I+CizvB" +
       "hHurmPTuiskDBw76fFmczumtu52R7a1mE0mxb5GJ5pYi/8F9IPtSUfzdBHoK" +
       "eKti9/2oOBcH/xTLM/BOBILMvIThL77Zdul9QHp7UfkD4PriCUhffAsgQXfF" +
       "52h/rHKKylN3Q0WWjon+oESvlPGV+wDy1aL41QR6tBg98pUDq93rXBJIv9Cv" +
       "ROnLbxqTT5dfOhwfqPOYODcF34srnqH8lROUv/L9Qrn4+U9ODXjhMs8ZxdmU" +
       "pRyTJ18TAJuGkqc6e8r75n1A/zdF8fVLoBd1//yA6DfuG7tf+14Ae0dR+UPg" +
       "+toJYF/7/sTuOdTK2H2t7PUf7gPE7xbFbyXQOzzgA4MUrJ9eomnxIRDHB0B+" +
       "+60E4iaBKm/1s5fiDP89d3zDt//uTPniqzcefver/G+XX36cfRv2yAh6WAeP" +
       "OH+Ueu7+agCebJWWPrI/WA3Kf39wj8Ddf6+TQFf3N6VV/2k/5A8T6Mm7DEnA" +
       "809uz/f+4wS6fuidQEfKheZvJ9C1k2aw1IDyfON3QBVoLG7fCE6d/0N3ZYIi" +
       "Cs5RcLfU2o82Vy7mbGdT+MSbTeG5NO/5C8lZ+QXmaSKV7r/BvK186VVq8uNv" +
       "YL+w/6wF5B27XSHl4RF0bf+FzVky9tw9pZ3Kujp84buP/cojHzhNHB/bK3yI" +
       "hHO6ve/u35D03CApv/rY/eN3/+qHf/HV3ytP+/4vRTroXBorAAA=");
}
