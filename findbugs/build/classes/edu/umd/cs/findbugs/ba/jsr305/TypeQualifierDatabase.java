package edu.umd.cs.findbugs.ba.jsr305;
public class TypeQualifierDatabase {
    public static final boolean USE_DATABASE = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ctq.usedatabase",
        true);
    public static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ctq.db.debug");
    private final java.util.Map<edu.umd.cs.findbugs.classfile.MethodDescriptor,java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>>
      returnValueMap;
    private final edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.classfile.MethodDescriptor,java.lang.Integer,java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>>
      parameterMap;
    public TypeQualifierDatabase() { super();
                                     this.returnValueMap =
                                       new java.util.HashMap<edu.umd.cs.findbugs.classfile.MethodDescriptor,java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>>(
                                         );
                                     this.
                                       parameterMap =
                                       new edu.umd.cs.findbugs.util.DualKeyHashMap<edu.umd.cs.findbugs.classfile.MethodDescriptor,java.lang.Integer,java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>>(
                                         );
    }
    public void setReturnValue(edu.umd.cs.findbugs.classfile.MethodDescriptor methodDesc,
                               edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv,
                               edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa) {
        java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> map =
          returnValueMap.
          get(
            methodDesc);
        if (map ==
              null) {
            map =
              new java.util.HashMap<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
                );
            returnValueMap.
              put(
                methodDesc,
                map);
        }
        map.
          put(
            tqv,
            tqa);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "tqdb: " +
                methodDesc +
                " for " +
                tqv +
                " ==> " +
                tqa);
        }
    }
    public edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getReturnValue(edu.umd.cs.findbugs.classfile.MethodDescriptor methodDesc,
                                                                                edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv) {
        java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> map =
          returnValueMap.
          get(
            methodDesc);
        if (map ==
              null) {
            return null;
        }
        return map.
          get(
            tqv);
    }
    public void setParameter(edu.umd.cs.findbugs.classfile.MethodDescriptor methodDesc,
                             int param,
                             edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv,
                             edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa) {
        java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> map =
          parameterMap.
          get(
            methodDesc,
            param);
        if (map ==
              null) {
            map =
              new java.util.HashMap<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation>(
                );
            parameterMap.
              put(
                methodDesc,
                param,
                map);
        }
        map.
          put(
            tqv,
            tqa);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "tqdb: " +
                methodDesc +
                " parameter " +
                param +
                " for " +
                tqv +
                " ==> " +
                tqa);
        }
    }
    public edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation getParameter(edu.umd.cs.findbugs.classfile.MethodDescriptor methodDesc,
                                                                              int param,
                                                                              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> tqv) {
        java.util.Map<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>,edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation> map =
          parameterMap.
          get(
            methodDesc,
            param);
        if (map ==
              null) {
            return null;
        }
        return map.
          get(
            tqv);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3JpWyjFnzayVu4Uq4hib4LpV61ut7bxc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("b1S7FdjWN8RYTiWoAiszRxgI+RlqlCqm2ddTYjVaMygxznhisLBTb8Kl66W9" +
       "dofrCK15np/Oy8lsKCfjPrfgZBKzNVdY2BI/JV3BXbJCi+wJMcnwC5AhtVct" +
       "rt1oDzqCMjeZqjO0dMqp0VWmbq43elUaGFOFCywEQmbMAlGm0NakvQRmKGVl" +
       "LvrSollGMJtpNgbbJmLP5IHd1IeDdlPnonncI4Paqr9dK+IG7/GjLpvM534D" +
       "ja2KiNcUymlWeq6ziDZ80xmM2rQ0woiVm3pySFdEjx5NweFLdFsh3NC1ZFId" +
       "Grwpzuly0thwSWiPoRULyXyzCbNGowInEd9Ey6zpt4LmRmjiEstUyqI85wbt" +
       "2OMG40aQENkCJtlWdbOyQdLZsjSGqdbEtaD5G83eDOq9TlRd9dDhWPBCBt7Y" +
       "XSEalcuEG8FS36t6mynqrckFXBMW1pIZt1wvyfQmtYTGadaYuhiG/Uz+6uq1" +
       "23ul9mDx9vD4Ou7aauQd//Q23prtup7Oi+eOX7XuXhGXzlzhPPG6/tRr0zAo" +
       "veVmt2yLWxaf/MDLr6jcp6oXD9+xMlHp7sj13m6BYGedWOryrS8D7L6d2F/j" +
       "+Z0PfO1x/h2rd9/G5cQnz9B5dsl/yHz6NfInlL95sXTp+FLP664/n570wpkv" +
       "jHfXG/hTF3recvqCYAge7FCy2NkvQva6e50VXCisYKf7M7fRLu3N5OW8eF9e" +
       "vKcY+uVbXFz7T3nxJ1Hp/lCLxvt7Gee+jk1cQ93b1H94ozexJ7cqGv7oWAiF" +
       "NVXBIxwKQfjBCOHi/ruinRCKUf/jFvx/Iy++CvhfnuK/EN6e1699H7wWCn8P" +
       "eLxDXr0fDK+Xdx5T8Hqeui4ZTnTGEP78FoL4bl58KyrdBwxhePTFWt72X/Zi" +
       "+Pb3q3IIPB8+FMOHfzh2/51jvV+4++bsXrg3Ly4Ddpdn2N1r/cIdt8PuJio9" +
       "fO4l7fyC02Ov+6XI7tcNym+9cvWuR1+Z/lFxT/n4Fwh306W79NiyTl4QPFG/" +
       "0ws03SikcffuumBxgeLCtaj0llteF4hKd+4qOfUXHtzNejgqPXL+rKh0ETBw" +
       "YuhjUemhc4ZGgNrD6snRPx6V7tmPBospp7qfiEpXDruBsYLyZOfToAl05tVn" +
       "Dr/jvnA65Bwb5bU30tKJKPXsTS9DMfHudz43lM+80md/7pv1T+2uYCuWBE6s" +
       "peK20ZXdbfDjWPL0TVc7WutO6vnv3P/Zu587inv37wjeW/oJ2p48/75z1/ai" +
       "4oZy9k8e/e2f/vuvfKn4Eu7/AaYtrJp+NQAA");
}
