package edu.umd.cs.findbugs.ba.obl;
public class InstructionActionCache {
    private static final boolean DEBUG_LOOKUP = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "oa.debug.lookup");
    private final edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase
      database;
    private final java.util.Map<org.apache.bcel.generic.InstructionHandle,java.util.Collection<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction>>
      actionCache;
    private final edu.umd.cs.findbugs.ba.XMethod xmethod;
    private final edu.umd.cs.findbugs.ba.type.TypeDataflow
      typeDataflow;
    private final org.apache.bcel.generic.ConstantPoolGen
      cpg;
    public InstructionActionCache(edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase database,
                                  edu.umd.cs.findbugs.ba.XMethod xmethod,
                                  org.apache.bcel.generic.ConstantPoolGen cpg,
                                  edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow) {
        super(
          );
        this.
          database =
          database;
        this.
          actionCache =
          new java.util.HashMap<org.apache.bcel.generic.InstructionHandle,java.util.Collection<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction>>(
            );
        this.
          xmethod =
          xmethod;
        this.
          cpg =
          cpg;
        this.
          typeDataflow =
          typeDataflow;
    }
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      WILL_CLOSE =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        javax.annotation.WillClose.class);
    public java.util.Collection<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction> getActions(edu.umd.cs.findbugs.ba.BasicBlock block,
                                                                                                      org.apache.bcel.generic.InstructionHandle handle) {
        java.util.Collection<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction> actionList =
          actionCache.
          get(
            handle);
        if (actionList ==
              null) {
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            actionList =
              java.util.Collections.
                emptyList(
                  );
            if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                org.apache.bcel.generic.InvokeInstruction inv =
                  (org.apache.bcel.generic.InvokeInstruction)
                    ins;
                edu.umd.cs.findbugs.ba.XMethod invokedMethod =
                  edu.umd.cs.findbugs.ba.XFactory.
                  createXMethod(
                    inv,
                    cpg);
                java.lang.String signature =
                  invokedMethod.
                  getSignature(
                    );
                java.lang.String methodName =
                  invokedMethod.
                  getName(
                    );
                if (DEBUG_LOOKUP) {
                    java.lang.System.
                      out.
                      println(
                        "Looking up actions for call to " +
                        invokedMethod);
                }
                if (invokedMethod.
                      getAnnotationDescriptors(
                        ).
                      contains(
                        WILL_CLOSE) &&
                      methodName.
                      startsWith(
                        "close") &&
                      signature.
                      endsWith(
                        ")V")) {
                    actionList =
                      java.util.Collections.
                        singletonList(
                          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction.
                            CLEAR);
                }
                else
                    if (signature.
                          indexOf(
                            ';') >=
                          -1) {
                        org.apache.bcel.generic.ReferenceType receiverType =
                          inv.
                          getReferenceType(
                            cpg);
                        boolean isStatic =
                          inv.
                          getOpcode(
                            ) ==
                          org.apache.bcel.Constants.
                            INVOKESTATIC;
                        actionList =
                          new java.util.LinkedList<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction>(
                            );
                        database.
                          getActions(
                            receiverType,
                            methodName,
                            signature,
                            isStatic,
                            actionList);
                        if (actionList.
                              isEmpty(
                                )) {
                            try {
                                edu.umd.cs.findbugs.ba.type.TypeFrame factAtLocation =
                                  null;
                                edu.umd.cs.findbugs.ba.SignatureParser sigParser =
                                  new edu.umd.cs.findbugs.ba.SignatureParser(
                                  signature);
                                java.util.Iterator<java.lang.String> signatureIterator =
                                  sigParser.
                                  parameterSignatureIterator(
                                    );
                                int parameters =
                                  sigParser.
                                  getNumParameters(
                                    );
                                for (int i =
                                       0;
                                     i <
                                       parameters;
                                     i++) {
                                    java.lang.String sig =
                                      signatureIterator.
                                      next(
                                        );
                                    java.util.Collection<edu.umd.cs.findbugs.classfile.ClassDescriptor> annotations =
                                      invokedMethod.
                                      getParameterAnnotationDescriptors(
                                        i);
                                    if (annotations.
                                          contains(
                                            WILL_CLOSE) ||
                                          "Ljava/io/Closeable;".
                                          equals(
                                            sig) ||
                                          methodName.
                                          startsWith(
                                            "close")) {
                                        if (factAtLocation ==
                                              null) {
                                            factAtLocation =
                                              typeDataflow.
                                                getFactAtLocation(
                                                  new edu.umd.cs.findbugs.ba.Location(
                                                    handle,
                                                    block));
                                        }
                                        org.apache.bcel.generic.Type argumentType =
                                          factAtLocation.
                                          getArgument(
                                            inv,
                                            cpg,
                                            i,
                                            sigParser);
                                        if (argumentType instanceof org.apache.bcel.generic.ObjectType) {
                                            edu.umd.cs.findbugs.ba.obl.Obligation obligation =
                                              database.
                                              getFactory(
                                                ).
                                              getObligationByType(
                                                (org.apache.bcel.generic.ObjectType)
                                                  argumentType);
                                            if (obligation !=
                                                  null) {
                                                actionList.
                                                  add(
                                                    new edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction(
                                                      edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                        DEL,
                                                      obligation));
                                            }
                                        }
                                    }
                                }
                            }
                            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                edu.umd.cs.findbugs.ba.AnalysisContext.
                                  logError(
                                    "Error checking " +
                                    invokedMethod,
                                    e);
                            }
                            catch (java.lang.ClassNotFoundException e) {
                                edu.umd.cs.findbugs.ba.AnalysisContext.
                                  reportMissingClass(
                                    e);
                            }
                            finally {
                                
                            }
                        }
                        if (DEBUG_LOOKUP &&
                              !actionList.
                              isEmpty(
                                )) {
                            java.lang.System.
                              out.
                              println(
                                "  At " +
                                handle +
                                ": " +
                                actionList);
                        }
                    }
            }
            else
                if (ins instanceof org.apache.bcel.generic.PUTFIELD ||
                      ins instanceof org.apache.bcel.generic.PUTSTATIC ||
                      ins instanceof org.apache.bcel.generic.ARETURN) {
                    edu.umd.cs.findbugs.ba.Location loc =
                      new edu.umd.cs.findbugs.ba.Location(
                      handle,
                      block);
                    try {
                        edu.umd.cs.findbugs.ba.type.TypeFrame typeFrame =
                          typeDataflow.
                          getFactAtLocation(
                            loc);
                        if (typeFrame.
                              isValid(
                                )) {
                            org.apache.bcel.generic.Type tosType =
                              typeFrame.
                              getTopValue(
                                );
                            if (tosType instanceof org.apache.bcel.generic.ObjectType) {
                                edu.umd.cs.findbugs.ba.obl.ObligationFactory factory =
                                  database.
                                  getFactory(
                                    );
                                edu.umd.cs.findbugs.ba.obl.Obligation obligation =
                                  factory.
                                  getObligationByType(
                                    (org.apache.bcel.generic.ObjectType)
                                      tosType);
                                if (obligation !=
                                      null) {
                                    if ("java.sql.ResultSet".
                                          equals(
                                            obligation.
                                              getClassName(
                                                ))) {
                                        org.apache.bcel.generic.ObjectType sType =
                                          edu.umd.cs.findbugs.ba.ObjectTypeFactory.
                                          getInstance(
                                            java.sql.Statement.class);
                                        edu.umd.cs.findbugs.ba.obl.Obligation sObligation =
                                          factory.
                                          getObligationByType(
                                            sType);
                                        actionList =
                                          java.util.Arrays.
                                            asList(
                                              new edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction(
                                                edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                  DEL,
                                                obligation),
                                              new edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction(
                                                edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                  DEL,
                                                sObligation));
                                    }
                                    else {
                                        actionList =
                                          java.util.Collections.
                                            singleton(
                                              new edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction(
                                                edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                                                  DEL,
                                                obligation));
                                    }
                                }
                            }
                        }
                    }
                    catch (java.lang.ClassNotFoundException e) {
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          reportMissingClass(
                            e);
                    }
                    catch (java.lang.Exception e) {
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          logError(
                            "Error in checking obligation analysis for " +
                            xmethod,
                            e);
                    }
                }
            actionCache.
              put(
                handle,
                actionList);
        }
        return actionList;
    }
    public boolean addsObligation(edu.umd.cs.findbugs.ba.BasicBlock block,
                                  org.apache.bcel.generic.InstructionHandle handle,
                                  edu.umd.cs.findbugs.ba.obl.Obligation obligation) {
        return hasAction(
                 block,
                 handle,
                 obligation,
                 edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                   ADD);
    }
    public boolean deletesObligation(edu.umd.cs.findbugs.ba.BasicBlock block,
                                     org.apache.bcel.generic.InstructionHandle handle,
                                     edu.umd.cs.findbugs.ba.obl.Obligation obligation) {
        return hasAction(
                 block,
                 handle,
                 obligation,
                 edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
                   DEL);
    }
    private boolean hasAction(edu.umd.cs.findbugs.ba.BasicBlock block,
                              org.apache.bcel.generic.InstructionHandle handle,
                              edu.umd.cs.findbugs.ba.obl.Obligation obligation,
                              edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType actionType) {
        java.util.Collection<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction> actionList =
          getActions(
            block,
            handle);
        for (edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction action
              :
              actionList) {
            if (action.
                  getActionType(
                    ) ==
                  actionType &&
                  action.
                  getObligation(
                    ).
                  equals(
                    obligation)) {
                return true;
            }
        }
        return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Nebiku/1MtDBXulb538A7uTSvjMnAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZCY0a8aoUa3FiRyKSahryEibawg7462Y4iIVj12U629Zt4U1TaI6GZvQzBKE" +
       "mpILgdmdmVJDYaBZm2SqxhxGW2EVoqkRZFRna6jhdLDF2GWJKjLoZpMkRzBJ" +
       "3G1yK9k254nPGUOyo/lpjYTr/koNzeEcFnSXgMdgV0RT8359IiKQLZlNqdUw" +
       "dNUbsJ3eTknSvB3NWp2+Lo1sZGRwBOExuqASMe5t+1ul3u2uDJ3dSWtkDJGd" +
       "Rmo64nLYimw6WKecaBAQRWI2nfscX5sOzBkBxaK1SGMtNWZqYOB2tNoGqYIw" +
       "Wa5sza4VJdVqi1djVDR4m1vwTuTA6DiacgmHx3Nxi3SXYnthBup2O1h1gaGM" +
       "id/Xpy1nNVS220XTndD8xjd4GNma7gJPG2Zf0MR5s9W0a62+2ILpcJDXGxlH" +
       "p/Fu0FI6i7iaaloyqVMI2agPSHnA46beVUZIVcRNptMmh9F43anXQGSESHHW" +
       "GLNVte2M2oE7zdT1aDOQ1XY8wxKPG2Bu5OB8VSdMGdpURYVmdT+aqnCf9Bcj" +
       "m4Udcd4VwQ+MaRTZwtSRDivtlODoEJ2DHdiWbHVmStUAe7eh0TVHixmnDZHu" +
       "BuJ73ba9WoVztd2Bu2NFVqZ4c5fMxx2pqvYxe9tFl2mHCACysdps6CETsVHz" +
       "Op0a50dMw4Db0mbldU1bbHvSbjMfLLvzqofvzG4No5LVWk6ZOhkOx31T5hcp" +
       "2u0Z/nItrhuzvj4eclWOIzpNPMe2jemSZFoTCptNvNTIN0Y232z0tiPX66ua" +
       "M8D5ScwxSX3R5nsDQZhI40GIEUmQQHzVm6a6mFdpc9JwFkYzRN26mc7SNTPK" +
       "HUnMxRjE+KLAIZSJKFvL2LG7KNhF1WZgUBCjk7ntCLWJ2qF24xXC9EKhut21" +
       "l4E3nHeWVSk3cNUyTLvTY3BGi6a1gQJTGYeSWt+tGgEmWkxW96ShFJChwbhc" +
       "MpV2456w0pqYvBhjtsnUfWhppMxw5Oc1mnZobFqr43A+M+M+ldOdVZW3pXg0" +
       "CFqyCTVk3DSzATxhJtOmxChub64GrNme");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jcnqUhAbnhBKIW/nVR8sKnYvSDjFYMYNGG7WMpz01N5UmcwbsmtXN0snrkpd" +
       "l0yrsTkL8e2c26J13BqnYS9Y8Fs6yeEWwkQ8pqgezE+46jZo0iDmTRoizTW7" +
       "LVFsLBgxI5MoMiEbno4WiNLCR3Gz0bG3dSez2LRHZit3R7XjXaRGA9tO8iDN" +
       "TBCpKHAVxUZ5f7llJEjSQVgFRxsjSoMMo2DCbgxmm5o+nEOaO5osNoGp9iFj" +
       "BPzZX4vtMWpODNVeJ1B9HA9QMXHUVrPTQ5IFu12N3V6v997iyOlrb+wo7MHy" +
       "1O/4muTKQYqKf/YGTrv2VU8VyTPHh6rl312Vc1frTh2qnj3uDyuPX3T7sfx0" +
       "/LmPvPCiPv18/fLhwT0fV+6JPf89jrE1nFOs7nj1b537eywnFxS+8pE/fmzx" +
       "vuUH3sDVsbefk/M8y384fulrw3dqf+dy5crxdYVbrqWeJXru3Pew0IiT0F2c" +
       "uarw+LFl24XFimEQDi0rnD+uPhm7W7zgUukF+7E/d8/m8v4w++i096kLPuWg" +
       "SmRrqONp66Lhr5asvvUqV3b+c5H8UVy5Zhnx/lNP2ezDJ771H17rJPU0y7Lg" +
       "D46N8XBRWNxl+/KhMb78f8cYV07mzLdLPY/M8szr+sJV8vzeq1jllSL5Tly5" +
       "X9H16ISuKF2cWOa7P6plboDnK4eW+cr/I8sUyX8vm/7gVRT+iyL5PoAb3XCM" +
       "2LhY5z//EXR+c1H4OHi+fqjz19+oztRtdT68YndO5yOXeO8P/dGzmOJFh5eu" +
       "Xmy5S/cWyWWAd0sl6mm3WuzSlTdisSyuPHL7m7rFtcNHb/lHgf3ldu03X7x+" +
       "91tf5P6gvKx6fAH9Hrpyt5k4zukbVqfyd/khiA9Ki96zv29Vfj++9FBceexi" +
       "m8WVKyAtBL/04L49sPEjt28fVy4Da55q+mhcefg2TWMg52H2dOsfB7B00how" +
       "085UPxFXrh5WA6FAerryKVAEKovs06VzfSi7dOsn7NKlH3qtATq1DL7jwssk" +
       "42T/Dx43tS+8SE5+7pX25/c3cDVHyfOCy9105er+MvDxYvXUhdyOeN01evYH" +
       "9//WPc8cLaz37wU+mSenZHv77a+7Yhs/Li+o5v/0rb/9U3//xW+WX+f+Dxj5" +
       "BUx3MwAA");
}
