package edu.umd.cs.findbugs.classfile.engine.bcel;
public class LoadedFieldSetFactory extends edu.umd.cs.findbugs.classfile.engine.bcel.AnalysisFactory<edu.umd.cs.findbugs.ba.vna.LoadedFieldSet> {
    static final java.util.BitSet fieldInstructionOpcodeSet = new java.util.BitSet(
      );
    static { fieldInstructionOpcodeSet.set(org.apache.bcel.Constants.
                                             GETFIELD);
             fieldInstructionOpcodeSet.set(org.apache.bcel.Constants.
                                             PUTFIELD);
             fieldInstructionOpcodeSet.set(org.apache.bcel.Constants.
                                             GETSTATIC);
             fieldInstructionOpcodeSet.set(org.apache.bcel.Constants.
                                             PUTSTATIC); }
    public LoadedFieldSetFactory() { super("loaded field set factory",
                                           edu.umd.cs.findbugs.ba.vna.LoadedFieldSet.class);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.vna.LoadedFieldSet analyze(edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache,
                                                             edu.umd.cs.findbugs.classfile.MethodDescriptor descriptor)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        org.apache.bcel.generic.MethodGen methodGen =
          getMethodGen(
            analysisCache,
            descriptor);
        if (methodGen ==
              null) {
            return null;
        }
        org.apache.bcel.generic.InstructionList il =
          methodGen.
          getInstructionList(
            );
        edu.umd.cs.findbugs.ba.vna.LoadedFieldSet loadedFieldSet =
          new edu.umd.cs.findbugs.ba.vna.LoadedFieldSet(
          methodGen);
        org.apache.bcel.generic.ConstantPoolGen cpg =
          getConstantPoolGen(
            analysisCache,
            descriptor.
              getClassDescriptor(
                ));
        for (org.apache.bcel.generic.InstructionHandle handle =
               il.
               getStart(
                 );
             handle !=
               null;
             handle =
               handle.
                 getNext(
                   )) {
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            short opcode =
              ins.
              getOpcode(
                );
            try {
                if (opcode ==
                      org.apache.bcel.Constants.
                        INVOKESTATIC) {
                    org.apache.bcel.generic.INVOKESTATIC inv =
                      (org.apache.bcel.generic.INVOKESTATIC)
                        ins;
                    if (edu.umd.cs.findbugs.ba.Hierarchy.
                          isInnerClassAccess(
                            inv,
                            cpg)) {
                        edu.umd.cs.findbugs.ba.InnerClassAccess access =
                          edu.umd.cs.findbugs.ba.Hierarchy.
                          getInnerClassAccess(
                            inv,
                            cpg);
                        if (access !=
                              null) {
                            if (access.
                                  isLoad(
                                    )) {
                                loadedFieldSet.
                                  addLoad(
                                    handle,
                                    access.
                                      getField(
                                        ));
                            }
                            else {
                                loadedFieldSet.
                                  addStore(
                                    handle,
                                    access.
                                      getField(
                                        ));
                            }
                        }
                    }
                }
                else
                    if (fieldInstructionOpcodeSet.
                          get(
                            opcode)) {
                        boolean isLoad =
                          opcode ==
                          org.apache.bcel.Constants.
                            GETFIELD ||
                          opcode ==
                          org.apache.bcel.Constants.
                            GETSTATIC;
                        edu.umd.cs.findbugs.ba.XField field =
                          edu.umd.cs.findbugs.ba.Hierarchy.
                          findXField(
                            (org.apache.bcel.generic.FieldInstruction)
                              ins,
                            cpg);
                        if (field !=
                              null) {
                            if (isLoad) {
                                loadedFieldSet.
                                  addLoad(
                                    handle,
                                    field);
                            }
                            else {
                                loadedFieldSet.
                                  addStore(
                                    handle,
                                    field);
                            }
                        }
                    }
            }
            catch (java.lang.ClassNotFoundException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getLookupFailureCallback(
                    ).
                  reportMissingClass(
                    e);
            }
        }
        return loadedFieldSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wMWK4Higx0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6C8zj2HUe55/Z2d3Z9c7ubPzI1rvetcdO17J/UhL16sax" +
       "SYqSSFESRVIPMo8x36TEl/gQKcabxgYaGw1iG83adQBnC7QO2jhOHBQ1GiBI" +
       "sEHRxm4eQIIgjQvUDooCdZIaiFEkLeo26SX1P7X/TGwUbX+A97/ivefcc849" +
       "57uH994vfBN6KAqhSuA7O9Px42M9i49XTuM43gV6dEwzDVYOI10jHDmKBPDu" +
       "nvr2X779l9/+pPXkEXRTgp6WPc+P5dj2vYjTI9/Z6hoD3T5/Szq6G8XQk8xK" +
       "3spwEtsOzNhR/BIDPXaBNIbuMqciwEAEGIgAlyLA2HkvQPQG3UtcoqCQvTja" +
       "QD8GXWOgm4FaiBdDL1xmEsih7J6wYUsNAIdHit9zoFRJnIXQ82e673V+ncKf" +
       "qsCv/MMfefKfX4duS9Bt2+MLcVQgRAwGkaDHXd1V9DDCNE3XJOgpT9c1Xg9t" +
       "2bHzUm4JuhPZpifHSaifGal4mQR6WI55brnH1UK3MFFjPzxTz7B1Rzv99ZDh" +
       "yCbQ9U3nuu417BXvgYK3bCBYaMiqfkpyY217Wgy97ZDiTMe7Q9ABkD7s6rHl" +
       "nw11w5PBC+jOfu4c2TNhPg5tzwRdH/ITMEoMPXNfpoWtA1ldy6Z+L4bectiP" +
       "3TeBXo+WhihIYuiNh91KTmCWnjmYpQvz883x93/8R72Bd1TKrOmqU8j/CCB6" +
       "7oCI0w091D1V3xM+/m7m0/Kbfu1jRxAEOr/xoPO+z7/80Lc+8J7nXvvyvs/f" +
       "uqLPRFnpanxP/ZzyxO+9lXixc70Q45HAj+xi8i9pXro/e9LyUhaAyHvTGcei" +
       "8fi08TXu34g//nn9z46gWxR0U/WdxAV+9JTqu4Ht6GFf9/RQjnWNgh7VPY0o" +
       "2ynoYVBnbE/fv50YRqTHFHTDKV/d9MvfwEQGYFGY6GFQtz3DP60HcmyV9SyA" +
       "IOhh8ECPg6cJ7f/K/zG0hS3f1WFZlT3b82E29Av9I1j3YgXY1oIN4ExKYkZw" +
       "FKpw6Tq6lsCJq8FqdN5YhmwhCSA0gYCwouoAG3wZRFGvcHhej3tyEQe744JJ" +
       "8P9t5KywyZPptWtgut56CBYOiLOB72h6eE99JcHJb/3Svd86OgueE2vG0PuB" +
       "IMdAkGM1Oj4V5PhMkOO9IMeFIMdXCgJdu1aO/z2FQHtXARO9BpABwPTxF/kf" +
       "pj/4sbdfBz4apDfALBVd4ftjOnEOMlQJpSrwdOi1z6Qfnv9d5Ag6ugzOhRLg" +
       "1a2CnC0g9Qw67x4G5VV8b3/0G3/5xU+/7J+H5yW0P0GN11MWUf/2Q3OHvgos" +
       "Gern7N/9vPyle7/28t0j6AaAEgCfsQxMCZDpucMxLkX/S6dIWujyEFDY8ENX" +
       "doqmU/i7FVuhn56/Kf3gibL+FLDxY0U4PA8e4iQ+yv9F69NBUX7P3m+KSTvQ" +
       "okTq9/HBz/7R7/5JvTT3KajfvrBMgsl/6QKQFMxul5Dx1LkPCKGug37/4TPs" +
       "T3/qmx/9wdIBQI93XDXg3aIkAICAKQRm/ntf3nz161/73B8cnTtNDFbSRHFs" +
       "NTtTsngP3XqAkmC0d53LA4DIASFZeM3dmef6mm3YsuLohZf+z9vvrH7pv3z8" +
       "yb0fOODNqRu9529mcP7+e3Hox3/rR/7bcyWba2qxEJ7b7LzbHl2fPueMhaG8" +
       "K+TIPvz7z/7Mb8o/C3AaYGNk53oJd1BpA6icNLjU/91leXzQVi2Kt0UXnf9y" +
       "fF1IWO6pn/yDP3/D/M9//VultJcznotzPZKDl/buVRTPZ4D9mw8jfSBHFuiH" +
       "vjb+oSed174NOEqAowqW+WgSAvzJLnnGSe+HHv73v/Gv3vTB37sOHfWgWw6A" +
       "lj2ggBUCeLceWQC6suD9H9hPbvoIKJ4sVYVep/zeKd5S/roBBHzx/vhSgtd5" +
       "iL7lf0wc5SP/8b+/zgglslyxTh/QS/AXPvsM8QN/VtKfh3hB/Vz2ekwGyd05" +
       "be3z7l8cvf3mvz6CHpagJ9WTzHEuO0kROBLIlqLTdBJkl5faL2c++2X+pTMI" +
       "e+shvFwY9hBcztcCUC96F/VbB3hSPBAGnvZJqLUP8eQaVFbeX5K8UJZ3i+L7" +
       "yjk5AuEblalpDEa3Pdk5CeO/Bn/XwPNXxVPwLF7s1/I7xElC8fxZRhGA1ep7" +
       "jdMJKCAZzNQkUH2tMFjJ8Y0gnz/3NNyOQcMe64qyVhQf2I/duK9n/Z2iILNr" +
       "AHQeqh23jpHiN3O1ZteL6t8uCqIouqXhyBiEiKPePdVgDlJwIOndldO6LGQx" +
       "e8f7vPVASPI7FhK4+xPnzBgfpMA/+Z8++dufeMfXgU/S0EPbwl+AK14YcZwU" +
       "XwU/8YVPPfvYK3/8kyXKAojlX1T+6wcKrrPvTtVnClV5PwlVnZGjeFQCo66V" +
       "2j4wFNnQdsH6sT1JeeGX73x9/dlv/OI+nT2Mu4PO+sde+ft/ffzxV44ufES8" +
       "43V5/EWa/YdEKfQbTiwcQi88aJSSovefv/jyr/6zlz+6l+rO5ZSYBF98v/iH" +
       "/+u3jz/zx1+5IrO64fj/BxMb3/7YAI0o7PRvNJfkWjbLsoW+5LZKfzLyGj6C" +
       "i0jXjbgt36apIOVMwdmgRiaijjAKdp1KMzL0QbKVtJZUqVVNfmpyHD4n6TCV" +
       "rSU64/ochW18wkM839/IU2w4X8dU3/Vld5W118NFMHXk6UbR/HwE650EVdpy" +
       "Pw6ktpqr7aaqVmS11dhJ7HKkrAQamVPqnLTpbn8lEeE0DHqDaZeuButUIJoi" +
       "n7oDG5nCodKYb7c7igg3nL7smDHpEqakD2tkQzR4W5ZomyRJLtL6E1WkeW0S" +
       "iim7waYEN2/OFtW11aNlhVrzG24sLIimTxpTv2kNKZJfoq5LUDuxa26k3lSi" +
       "0vVOUFt0J7E31G6mLfreZCYs1VhZdseIpIbSbkf4ozCY9/EuIfMMjcrWej2U" +
       "R6tECjerfEY3o7XVHa3j3lxX6MA0llzmmN4mr2ptbauZxm6WT8WaOSQCq2mt" +
       "lWg4GGI5MDG3nMjDZDRrS7UOkMYeUlkYzcjxjI8FdZLKnFmLFa469weI2Orz" +
       "QrjwBbxqq3zIc4Q/nQqTjtDl8F6Vcl0EdUd1zKdkJVnhNuIteuGutRzNtoMU" +
       "ZgnLb0ThtlrBhl7AWTKHzJY9kqQYjA6r5ozeDcVO1RdsLvUtbT5cdsXl3F7i" +
       "vbU8XleataDb7FH9NWqYcdTp4jElVeONthrm1gAhq6yNCHPFWPD5cDCCEdGR" +
       "ZJLV8Pq2OfKrS3I7mKo9npgKwjplUG/m8AlZ5UmTG3eqrDhZSe0uJ2Lykhyu" +
       "6615fRNMyQWGzZej5Xq6cJhO2gs3BpJqNDdc2aYQd9dbcheEwhyvEwqCcqsq" +
       "P640hRXa2yBiPq1ivOmGnV1mepPhkt46452nwnHHmg00exU6BDY0RynNjIIZ" +
       "vOph84m6qvmEsBipU7yxS5VeC7G73YqzrOJWH8/CRTtbwmzXW2oLRrZbOuVu" +
       "XYleCTOtPcwkWuimElPvtOT1dtU2qQ3nu27fojoGBbvMyG/mkuuuMJEadVou" +
       "T2jdaiL0unJna7AUAq9sircnPt8THA0L2xsymM0a/lqEES7s4xrVNbmpPMnW" +
       "rmW1s96sy9b8oI9VakFv1A8scgbsbfnBrLOqiENsHW0oZ+jz7YDXlhs5ZQIJ" +
       "ro0sC9tYZntjttt8xsLiGCG76BKtWuqEGBI27/tiS5OWGwWd4qpOmzW4kZJB" +
       "GngJmqe+mFiBF6LktOmRqJNuGEtghtNAojCRa1N9qsn0CZwCszvsU3RNVOiF" +
       "PyDT3pAexSys5JazWTdCfIoRE7npG0yfp6L6YuON8KbQ3c2WcbXZqOURozep" +
       "8QAkexmDjDCTx9Y9wrf6OxzzJNPnUYogNzxhexRhTkU2Yf2UzuZov1s3ARRJ" +
       "llaNV9WVMVc68WxpUp2Nic5T3uOCLa/VY8FGRXvRBaCS6Eme5nTCLM3ETm17" +
       "YwV13lxnwkxhdXyHecpqnPlEOlmoVZpZjdWdOHe5OTKfCpHWQKIdHai8Nu2G" +
       "Gr0zVR6dzJPNasq1Jl7d2u38djKwtmrdYEkMIWediSgkycw3SXpYX7u5SdVr" +
       "3SWq7tRFXUwqcd5GtZo8a9oTmp71JD2Xh+tJLLRYldt6gYkqqJRShjIMTcnt" +
       "xGDSSR5DUjUNDXaLTvsRbW7bGx51/AHOV+cTQhiqUb+h84aDaBopi82qnMEr" +
       "K7VzEjFdAwvas5FsSGOprYUxXceWUr3pztqM4+wqtc1M28ItptuCibxfd/xp" +
       "sMSmg0otEQg22kTupqc6+qRWF8J+NGl1xEadHSjNjpax+WJuZsOO3u8qXIyp" +
       "uy6VTnO2Pg8qaN2o51mD0VfoRBysPbTR7UqLzJGF1WYwJelFvz4R0bZJIzsf" +
       "W1VdXxr0DJwd8mta5TwhZQMv07NeD27sfJppmdN05VhRnHTVrlTPeXkrrBeN" +
       "CA5r4wizmXFdbI29/qxNaVPUo+PqkrNt1eVq25yNa7U2le36VYxOFWSFA/Cv" +
       "iV0Oa8Wj+QhONbHSwLeK7cSSFScN2Og7zW3f9teDsI7s4kQX5pV2KivVnrtN" +
       "olrKx7YSLRVdWpssQrK5HZNoVlmwxjQzlMEwWTAa2lsxdWzmC1Q28Xgsp/LB" +
       "qJ3PfTSAKzC7zNxOI0mxXrVJ832NmIo7bD028ERhp92aKyNW1cjSDIlMWeY3" +
       "4mbnjNqyj8m6t936C2cki6qow3GfdKq6OvH6gi55fX22y2bLxQavziR+leCG" +
       "ESz5eqfTdOIB7rkZQptGvswQEoY5SjXqMDvYLnjJm9Dyas0OuA6qsGy30pD0" +
       "5WA1RvEeGWrrkTNZmN1hN6l1g+oESJgwhtUjM6Xmz1Yc08wauBCP0pY43yFh" +
       "d6PwNswarI4E3eV0htREslU1G064yCuzibrmK9602hLhqj9X56xKuxUizbF6" +
       "Ig1aCGEPZvaqP03kisFJNtna2gRmqb2Nlg5bPOqbFYRYqaag42R1uFjLno9V" +
       "PKTZp9fMFuOpnOEYi5lIzerCptJU68/iKPajRmtbbQiMBnuz5Tgcxc25bSDL" +
       "ChmlY0ls5JS1wRGYnu/knGBbnodQDpmlCZMM4oW+27Lz0BINvV2HWz4/2Sp4" +
       "g0t7ed+2ZTN2WAp3lgg+aqcc2W/F2GTcqhpbNzfgIJt24A1THVsI02/qnem0" +
       "w8KBP+LbcHfg9iqLMct1xi2nJW0rc6aHbQVDV5Covgtaau5wFZnKU0VSRLdl" +
       "aGK8Q7azxmBZm1n1bjzvBp1w1WbGEU7Hk643dY1uPMInHuW16Lwy2HS1GdUi" +
       "XaoiMeiM1DVOrIP1vYFTNcRM8fFiii1My2ZbMjW1R4KqJVEqyj6fBSbbm3j5" +
       "Thuk7LS6riz49dytdfojbua3HWER9zPc70iR2OS4BPf7Q1wwYUVcKS5qrZdT" +
       "czJEh9uBt7AnenMCDNtwFx0arDvqbECONBQAvDPCVtio2wmIdhMZZk6zizSq" +
       "uxoehDq9UNsSjPmJt6pyM4GxsiG7jRwCCduOQ/YEOiZ2LUxbzZkOjXg0L7ZU" +
       "Hx30t5FcU3W3smgjFj7jmQrIJSIU5sbT2bjNsjOs1mrZdCcrVpE+hcmtaBts" +
       "06FIb1QL40fUQNJkWOeqRBA1NqY/sSXYltG14IxnWB9pRevuCOOFmI1Gw1pb" +
       "c4ZCWm0sJn10Wg09ddRR+puR1u7U0FmDHRsAh7GY3XYFDxZq+QaZVXSmOaDi" +
       "zipDtp7tc3Uk6cCuNhkR6wE27ywrNRo12pXWotlOXWJnJf1dd50mAqZ0tDGa" +
       "Dfu1iTiqVcgcoQSxY9anWgC3K0GSKeE20XF466ruMKs3hQrCtuZjprqoaXMj" +
       "nXJrSzcipoP4bqjUG3IkxEtJdfXJrMqzndq4mc7YlU2O81YXLOW8t9NafZ9N" +
       "d00yaLoq3JJGAdrmNrDXlQejDGQRCgxX053h8XYXGLfiLmquS9tBi2stF6xS" +
       "7bZsflTpWGClFnl10WTiXExQfj7MZl0yTpsVIWoZHV9v1T05thoM+GBgtysv" +
       "7mXjLfgag2VdGrDCMmLEimKvN5UBgU47g6RH6BiOJzgeZUMZjQe0Q401fMHa" +
       "znTJIwFjLJcJvcnF1qoW6G5QZ436oJpWkTqT6SZlm7NhH2MmvkRgIb3ZRtpu" +
       "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" +
       "kJD/ypv/xff/01e/Vp4R/m8c1t76kSkAAA==");
}
