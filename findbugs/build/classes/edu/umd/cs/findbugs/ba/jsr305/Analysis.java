package edu.umd.cs.findbugs.ba.jsr305;
public class Analysis {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ctq.debug.analysis");
    public static final boolean FIND_EFFECTIVE_RELEVANT_QUALIFIERS = true;
    public static final boolean DEBUG_FIND_EFFECTIVE_RELEVANT_QUALIFIERS =
      FIND_EFFECTIVE_RELEVANT_QUALIFIERS &&
      edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ctq.findeffective.debug");
    public static java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> getRelevantTypeQualifiers(edu.umd.cs.findbugs.classfile.MethodDescriptor methodDescriptor,
                                                                                                                      edu.umd.cs.findbugs.ba.CFG cfg)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        final java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> result =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>>(
          );
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            methodDescriptor);
        if (FIND_EFFECTIVE_RELEVANT_QUALIFIERS) {
            if (DEBUG_FIND_EFFECTIVE_RELEVANT_QUALIFIERS) {
                java.lang.System.
                  out.
                  println(
                    "**** Finding effective type qualifiers for " +
                    xmethod);
            }
            getDirectlyRelevantTypeQualifiers(
              xmethod,
              result);
            addEffectiveRelevantQualifiers(
              result,
              xmethod);
            edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache =
              edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                );
            org.apache.bcel.generic.ConstantPoolGen cpg =
              analysisCache.
              getClassAnalysis(
                org.apache.bcel.generic.ConstantPoolGen.class,
                methodDescriptor.
                  getClassDescriptor(
                    ));
            for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
                   cfg.
                   locationIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.ba.Location location =
                  i.
                  next(
                    );
                org.apache.bcel.generic.Instruction ins =
                  location.
                  getHandle(
                    ).
                  getInstruction(
                    );
                if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                    edu.umd.cs.findbugs.ba.XMethod called =
                      edu.umd.cs.findbugs.ba.XFactory.
                      createXMethod(
                        (org.apache.bcel.generic.InvokeInstruction)
                          ins,
                        cpg);
                    addEffectiveRelevantQualifiers(
                      result,
                      called);
                }
                if (DEBUG_FIND_EFFECTIVE_RELEVANT_QUALIFIERS) {
                    java.lang.System.
                      out.
                      println(
                        "===> result: " +
                        result);
                }
            }
            if (!methodDescriptor.
                  isStatic(
                    )) {
                edu.umd.cs.findbugs.ba.ch.SupertypeTraversalVisitor visitor =
                  new edu.umd.cs.findbugs.ba.ch.OverriddenMethodsVisitor(
                  xmethod) {
                    @java.lang.Override
                    protected boolean visitOverriddenMethod(edu.umd.cs.findbugs.ba.XMethod xmethod) {
                        getDirectlyRelevantTypeQualifiers(
                          xmethod,
                          result);
                        return true;
                    }
                };
                try {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      currentAnalysisContext(
                        ).
                      getSubtypes2(
                        ).
                      traverseSupertypesDepthFirst(
                        xmethod.
                          getClassDescriptor(
                            ),
                        visitor);
                }
                catch (java.lang.ClassNotFoundException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      currentAnalysisContext(
                        ).
                      getLookupFailureCallback(
                        ).
                      reportMissingClass(
                        e);
                    return java.util.Collections.
                      <edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>>
                    emptySet(
                      );
                }
                catch (edu.umd.cs.findbugs.classfile.UncheckedAnalysisException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      currentAnalysisContext(
                        ).
                      getLookupFailureCallback(
                        ).
                      logError(
                        "Error getting relevant type qualifiers for " +
                        xmethod.
                          toString(
                            ),
                        e);
                    return java.util.Collections.
                      <edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>>
                    emptySet(
                      );
                }
            }
        }
        return result;
    }
    private static void addEffectiveRelevantQualifiers(java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> result,
                                                       edu.umd.cs.findbugs.ba.XMethod xmethod) {
        if (DEBUG_FIND_EFFECTIVE_RELEVANT_QUALIFIERS) {
            java.lang.System.
              out.
              println(
                "  Finding effective qualifiers for " +
                xmethod);
        }
        for (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv
              :
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
               getAllKnownTypeQualifiers(
                 )) {
            if (DEBUG_FIND_EFFECTIVE_RELEVANT_QUALIFIERS) {
                java.lang.System.
                  out.
                  print(
                    "    " +
                    tqv +
                    "...");
            }
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa;
            boolean add =
              false;
            tqa =
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                getEffectiveTypeQualifierAnnotation(
                  xmethod,
                  tqv);
            if (tqa !=
                  null) {
                add =
                  true;
            }
            if (!add) {
                int numParams =
                  xmethod.
                  getNumParams(
                    );
                for (int i =
                       0;
                     i <
                       numParams;
                     i++) {
                    tqa =
                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                        getEffectiveTypeQualifierAnnotation(
                          xmethod,
                          i,
                          tqv);
                    if (tqa !=
                          null) {
                        add =
                          true;
                        break;
                    }
                }
            }
            if (add) {
                result.
                  add(
                    tqv);
            }
            if (DEBUG_FIND_EFFECTIVE_RELEVANT_QUALIFIERS) {
                java.lang.System.
                  out.
                  println(
                    add
                      ? "YES"
                      : "NO");
            }
        }
    }
    private static void getDirectlyRelevantTypeQualifiers(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                                          java.util.HashSet<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> result) {
        result.
          addAll(
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getDirectlyRelevantTypeQualifiersDatabase(
                ).
              getDirectlyRelevantTypeQualifiers(
                xmethod.
                  getMethodDescriptor(
                    )));
    }
    public static void addKnownTypeQualifiersForParameters(java.util.HashSet<? super edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> result,
                                                           edu.umd.cs.findbugs.ba.XMethod m) {
        int numParameters =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          m.
            getSignature(
              )).
          getNumParameters(
            );
        for (int p =
               0;
             p <
               numParameters;
             p++) {
            addKnownTypeQualifiers(
              result,
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                getApplicableApplications(
                  m,
                  p));
        }
    }
    public static void addKnownTypeQualifiers(java.util.HashSet<? super edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> result,
                                              java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> applicableApplications) {
        for (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation t
              :
              applicableApplications) {
            if (t.
                  when !=
                  javax.annotation.meta.When.
                    UNKNOWN) {
                result.
                  add(
                    t.
                      typeQualifier);
            }
        }
    }
    public Analysis() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0aC3BU1fXuJiQhBPLjL38CLQi7oALVIJJsNhDchJiEWIO6" +
       "vH17N3nw9r3He3eTDYofOh1oZ6RWEWkH0pkOjJ9RsLXUtlaHjuOHKnZU/FAr" +
       "2uq0qLXKdNSOVu25976377OfgAWZeZe3995z7vl/7ssDH6ARho6mYYUEyKCG" +
       "jUBYIe2CbuB4SBYMowvmouLdRcK/rz/VdqkflfSgMX2C0SoKBm6WsBw3etBU" +
       "STGIoIjYaMM4TiHadWxgvV8gkqr0oHGS0ZLUZEmUSKsax3RDt6BHULVAiC7F" +
       "UgS3mAgImhoBSoKMkmCDd7k+gipEVRu0t090bA85VujOpH2WQVBVZKPQLwRT" +
       "RJKDEckg9WkdXaip8mCvrJIATpPARnmJKYI1kSVZIpj1UOUnn9/eV8VEUCso" +
       "ikoYe0YHNlS5H8cjqNKeDcs4aWxGN6GiCBrl2ExQXcQ6NAiHBuFQi1t7F1A/" +
       "GiupZEhl7BALU4kmUoIImulGogm6kDTRtDOaAUMZMXlnwMDtjAy3nMssFu+6" +
       "MLjr7uurflmEKntQpaR0UnJEIILAIT0gUJyMYd1oiMdxvAdVK6DsTqxLgixt" +
       "MTVdY0i9ikBSoH5LLHQypWGdnWnLCvQIvOkpkah6hr0EMyjz14iELPQCr+Nt" +
       "XjmHzXQeGCyXgDA9IYDdmSDFmyQlTtB0L0SGx7orYQOAliYx6VMzRxUrAkyg" +
       "Gm4isqD0BjvB9JRe2DpCBQPUCZqcFymVtSaIm4ReHKUW6dnXzpdg10gmCApC" +
       "0DjvNoYJtDTZoyWHfj5oW77zBmW14kc+oDmORZnSPwqApnmAOnAC6xj8gANW" +
       "zI/sFsY/tsOPEGwe59nM9zxy4+mVC6YdeYbvuSDHnrWxjVgkUXF/bMwLU0Lz" +
       "Li2iZJRpqiFR5bs4Z17Wbq7UpzWIMOMzGOliwFo80vHUNbfcj9/3o/IWVCKq" +
       "cioJdlQtqklNkrG+CitYFwiOt6CRWImH2HoLKoX3iKRgPrs2kTAwaUHFMpsq" +
       "UdlvEFECUFARlcO7pCRU610TSB97T2sIoVJ4UAU8SxD/x/4n6Lpgn5rEQUEU" +
       "FElRg+26Svk3ghBxYiDbvmACjCmW6jWChi4GmengeCqYSsaDomEvxoTgRkO/" +
       "eNES8HBBHjQkI0D3auf7gDTlsHbA5wPhT/G6vgxes1qV41iPirtSjeHTB6PP" +
       "crOirmDKhqC5cF4AzguIRsA6LxATAvy8gHUe8vnYMWPpuVy/oJ1N4OcQaCvm" +
       "dV63ZsOOWUVgWNpAMYiWbp3lSjghOxhYETwqHqoZvWXmycVP+FFxBNUIIkkJ" +
       "Ms0fDXovRCZxk+m8FTFIRXZGmOHICDSV6aoITOg4X2YwsZSp/Vin8wSNdWCw" +
       "8hX1zGD+bJGTfnRkz8Ct3Tcv8iO/OwnQI0dA/KLg7TR0Z0J0ndf5c+Gt3H7q" +
       "k0O7t6p2GHBlFSsZZkFSHmZ5DcErnqg4f4ZwOPrY1jom9pEQpokAbgURcJr3" +
       "DFeUqbciNuWlDBhOqHpSkOmSJeNy0qerA/YMs9BqOozjxkpNyEMgC/aXd2r7" +
       "Xnv+3YuZJK28UOlI6J2Y1DtiEUVWw6JOtW2RXTrGsO+NPe133vXB9vXMHGHH" +
       "7FwH1tExBDEItAMS/P4zm0+8eXL/cb9twgSScSoGNU2a8TL2K/jng+dL+tD4" +
       "QSd4HKkJmcFsRiaaafTkuTZtENdkcH1qHHXrFDBDKSEJMRlT//lv5ZzFh/+5" +
       "s4qrW4YZy1oWDI/Anp/UiG559vpPpzE0PpHmVVt+9jYerGttzA26LgxSOtK3" +
       "vjj1J08L+yDsQ6g1pC2YRU/E5IGYApcwWSxi4yWetWV0mGM4bdztRo76Jyre" +
       "fvyj0d0fPX6aUesuoJx6bxW0em5FXAtw2HhkDq5oTlfHa3SckAYaJngD1WrB" +
       "6ANklxxpu7ZKPvI5HNsDx4pQWhhrdYiSaZcpmbtHlP75D0+M3/BCEfI3o3JZ" +
       "FeLNAnM4NBIsHRt9EGDT2hUrOR0DZTBUMXmgLAllTVAtTM+t33BSI0wjW34z" +
       "4VfL7xk6ycxS4zguYPBFNOa7Iiyr1W0nv/+lZS/f8+PdAzzbz8sf2TxwEz9b" +
       "K8e2/e0/WXphMS1HJeKB7wk+sHdyaMX7DN4OLhS6Lp2dpyBA27AX3Z/82D+r" +
       "5Ek/Ku1BVaJZG3cLcor6dQ/Ug4ZVMEP97Fp313a8kKnPBM8p3sDmONYb1uz8" +
       "CO90N30f7bHBSVSF6+FZatrgUq8N+hB7WcNA5rJxHh0WcPURVKrpEvRPQHmJ" +
       "wcpwAnRIkG/TmVOYoUwscAqANIUb161yp1ua0jpTMQNSo5SEcNlvFokXtW8Q" +
       "d9S1v8NNYlIOAL5v3L3B27pf3fgcC8ZlNPl2WWJwpFZI0o4gX0WHAPW8Aqbm" +
       "oSe4tebNTXtPPcjp8dqVZzPeseuHXwV27uJBkrcBs7MqcScMbwU81M0sdAqD" +
       "aP7Hoa2P3rt1O6eqxl3UhqFne/CVL54L7HnraI5qqjSmqjIWlIyz+zLl0Fi3" +
       "uDlTTT+o/P3tNUXNkIlbUFlKkTancEvcbYOlRirmkL/dYth2abJHExJBvvkQ" +
       "KXiypeN36HAlt6nleSNVU8bmqLmhNfBcYdrcFVmW7cukXepsgUbO87EZ+i0v" +
       "7/3sXyyyjuinTpnWfBQknscH6OtCOqylQ7vH7icUoIGgWc0tbU3RcHNzONTV" +
       "0h2OdoQj4e6Gtq7oVesaIi3NLeGOTrpznUcQ+CwF0QxPo0lEQx4XV742ew15" +
       "MBP0bebW0a/HpFqAyXRuYpmeFtoksn8lBXKsIxUh6ldT8zW1zKf2b9s1FF97" +
       "YLHfLBXWE0igqrZQxv1YdqCiF1VTXVmtlbXxdop4Y8wdb/+2rrfxbFoGOjdt" +
       "mKaA/p4O/j4/f/TykvL0tvcmd63o23AW1f90j5S8KO9rfeDoqrniHX52Z8Fz" +
       "V9Zdhxuo3h0tynVMUrrijg+zM3plBUgrPBFTrxGvUdu2lGUkftuiPcZcXQCj" +
       "p2L0c1Ts90SCArn6T3YHRlt7U0BN2BB1SbMukgBscp62NdS8inGww3OqFYdN" +
       "8KWFTw31YRFKRqv5DadFrFHNMtQ76bCNoEm9mHRgsGAoQai4rwJLhJoc6wbt" +
       "OXIkVzY4LnvUa6tH/fxgJzbTXw4Ix+adj/6up+dbVSLfnCvZe26E7r2nTHw9" +
       "+dQ7lst12V0Myt3FTM7VLXCp0NrT65leCv/aNqVc3dRezSks4EdewNukoWN/" +
       "/Ljy1lyVKrv3NEG9cCdeK7poFKn7EfO/YurwlMNRUM4ZdCe9KMh7h8pw8dpg" +
       "DB12py3TGJurJKdr+9xJ3JJAVEyP6xo7r+Kqtzj9M4dhPCq2JKOdh09sX8rq" +
       "h8p+CTpafqfOr7HHu66xrTuWetf1bk7RRMVTh257ZuZ73bXs3o5LgVJ+KfQa" +
       "9P/LzYTgYwnBbxYmF7h4MulgrWVUfG6BtKzsL8fv46zNycOaG+bGvV8ee3fr" +
       "yaNFqATCEY1hgo4hXIGv57sYdyKo64K3JoCCwDaGQ0tKL1O7qd6azGzmboOg" +
       "hflws7Iz+4YImrkBrDeqKSXOWhNPFE1pmnOVGUrl/+lBN0E/fwYSzAjASsM1" +
       "TPhj7IKLFqHORSg8a0ORhs7OaNc17eFod0NHS0NjJMyMVoNFX9gy7iobCW+R" +
       "uNnvyUTzzE3pChP/Cs5Z77m+yHRFTNbBWXem39RRGY9fVPgKNBucwj3CoH+W" +
       "16/o/IGMWGcgM/e6xEpXD7Mk+WtmYAcZYqaxBou46bbG7ArDcZNC43I+v7xa" +
       "kuMhQY/zcHngq5GzV044ehkLl9nmX8jkgdaFlOAAPFebHFzNDUM5r9pq0OhH" +
       "RV5VWfbxDZ9oxs6czpN2VcGen97ag/7ckLar9O8N14oUvj2iE42ctpsyWqql" +
       "awo8Q6aWhs62vGvLVd7VFMBYoLy7Y9iAOcEOmPTGrRMTu95ggYkOr2Q81XNB" +
       "B9vpwokzd8WvR0rGN0/waEpff8FmHz5znQP50/IEmu/yKpdhPF7ggvXvdHge" +
       "8AjxeDiRoOmlH1slqKP8pNu66RDgR/cQVNyvSnHb9v50vmxvMzxHTUs5es5s" +
       "Lx/G3LZHf75Nh5fZiR8XkOindPiQoJlQyzdJOkhUHsxd09ONp2wBfnQeBFjD" +
       "DRGhl0x2XzpbAebtzfJhLOS8Dtcz3ZC5wBl4HJ1+gy0eyZASonuiwzH3MB2e" +
       "PCOnYlqmo68ov4J9o+nkFwTNBpe5UlEHFLdWm1WdNeiYZKv4y/Ol4lXwvGlK" +
       "4eQ5U/HJPBjz+oiv2NbzboeedzMa9rFheD3fZwW3JWdRRTnKlzNRNdPkpAJa" +
       "nk2HWmidcmvZrVjf2HOh2DRBZdb9AP2SMzHrT2/4n4uIB4cqyyYMrXuVXVhl" +
       "/qSjIoLKEilZdn5rcLyXaDpOSEwRFfzLA8tCvgsJNOGF5ExQCX+hdPvmc6gA" +
       "SCY3FEF+6JsdWxdDK5FjKzBrvTp3X0JQub0bkImu5WUElZrLBBXB6Fy8DKZg" +
       "kb7Wa9ztfdm2wDxx3HAKc9xDzs7bI7em+B9ORcVDQ2vabji99AD/2AxZfssW" +
       "igVay1L+STtzXzczLzYLV8nqeZ+PeWjkHOuaxfWx20kbMxswafZheLLn66tR" +
       "l/kIe2L/8seP7Sh50Y9865EPNFS7PvvDVlpL6Wjq+kj2NwWri6yf99PBFQsS" +
       "H77OPh0i3upPyb8/Kvbc+VrLQ5s+Xcn+TmcEaBun2Re3pkGlA4v9uusDRe7O" +
       "fLSrMydoVvb3mWE78dERNMqe4Zoo2JxTAHvGVB0do3QIpKn0wdaikVZNM8s9" +
       "38MaM7kNeVOLL8Je6Vvr/wDOqA0HQSkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F7/yH/7i4gf3hz2nj67KIq0D0LNwX/39");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("W+pvSC/9TGlZt+paUuryDhZYaDEyrTxx/YKvEtf+XOoNxyfjlWufjD9yrRPo" +
       "vbSiKD8U6Zuudcxd9H3m1JHXtcVxxej5V6QvfvXDaHmidTFzEie1TPmgGu30" +
       "MfhxmcizpyrUrimwK8Y3vvDRLz/5TeWBsvRoL5uCrEYelaRjBwHnXBlwzlf2" +
       "pSZvuw7BBxSVp/ZXjB//9He/8ifPf+2lWyoXgFMVnqjFFnA6YNbXq9g7ieCS" +
       "DO5IAAXc8549tBPYpYoPVHn/0dujOpG08kPXw10eb54pJylq3rxwY8Ug4QvM" +
       "Au1jZ2LBOopO9pZGcffrNIqfiCvvfA0SPBLAYTi/v/SBE6dGxWHnyc4orTzQ" +
       "YXFJuiJPh9QVBRd7OMGW681nItB5jrrGOdb+cHtvqZ88inJHJVzvPsD/7j1n" +
       "9ve7wupUcCjP3g+Luf62pjpyUvjGtVlXgxdwXyyh/8l1vaV4/9kjsT5ROVhB" +
       "Tom16P0X5eLxq6WBfb5EXGoMPyTu8WONHa+TJwpO8hv4pep4ZkeLzX1o/Nz3" +
       "7nz6uYde+rtlaLza/G9k8pWDMqj3gUs94EDdG0bwN6otPIo8x9jnBof28bc8" +
       "Y14q6AunamEq+ZnH44zt77/a2ejJ+pryxU8dyfiB4mUArhcPZPzizaYY5GtL" +
       "MT75qpHsoeNIVpQVSVZ61dp2pvIIDCk6Xn7tfvHXm/7IUV7eh7a9dor2V66l" +
       "FEDoY9fx78k+jyphv3KD8q8/LJovAzyaaVLzeRHVM+swyTmR4Fzr9DwLHfPY" +
       "OF56vcaxAtdLB8bx0vffOIrHPyia3y5HffMGQvmzovlvaeVJkPCRTgyE4m2v" +
       "nfgVA79+LIP//jpkcP/eOiqV3zmQwe/crAxeYw7+yaL5j+Wwl1+DVRevf6/s" +
       "/PUjWp8txlx5NVp/5VrBpVRD2X77Bhr4btG8klaeBmY5CMJNcFrsdBiXOygr" +
       "vVoH/+v16qALrq8f8PW1778Oise/PFbEPy7HfqZsXl0RP3/o982bWNdPLKhn" +
       "Aj14OHfH9dVw7t6iuQUk49dWw2nJn7v1ZiSfp5U7DrdbRWnrw1f938n+fyWM" +
       "X3rx4h0PvTj+L2Vx9NH/M9zJVu6Yrz3vZCXiifsLUWzNnVK0d+7rEsvgeu6h" +
       "tPLoDSWXVi7sbwqCzz24h3oESODaUGnlPNiHnRj6KEhXrzEUMHt4e3L0E2nl" +
       "ruPRAJlxqvvptHL7QXdauQW0JzvfDl6BzuL2Bw6W8XPXWbfvfzXFnPhm8vR1" +
       "d1fcev9fQ1eML7zY53/sFfRz+7pvsHjtdgUWsH25fV+CfvRl48nrYjvEdYF5" +
       "5jv3/PKdbzv8CnPPnuBjPztB2+PXLqym/CgtS6F3/+qhX/3hn3/xa2UZ2f8H" +
       "9SWHJsw1AAA=");
}
