package edu.umd.cs.findbugs.detect;
public class BadlyOverriddenAdapter extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private boolean isAdapter;
    private final java.util.Map<java.lang.String,java.lang.String> methodMap;
    private final java.util.Map<java.lang.String,edu.umd.cs.findbugs.BugInstance>
      badOverrideMap;
    public BadlyOverriddenAdapter(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        methodMap =
          new java.util.HashMap<java.lang.String,java.lang.String>(
            );
        badOverrideMap =
          new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.BugInstance>(
            );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        try {
            methodMap.
              clear(
                );
            badOverrideMap.
              clear(
                );
            org.apache.bcel.classfile.JavaClass superClass =
              obj.
              getSuperClass(
                );
            if (superClass ==
                  null) {
                return;
            }
            java.lang.String packageName =
              superClass.
              getPackageName(
                );
            java.lang.String className =
              superClass.
              getClassName(
                );
            isAdapter =
              className.
                endsWith(
                  "Adapter") &&
                ("java.awt.event".
                   equals(
                     packageName) ||
                   "javax.swing.event".
                   equals(
                     packageName)) ||
                "DefaultHandler".
                equals(
                  className) &&
                "org.xml.sax.helpers".
                equals(
                  packageName);
            if (isAdapter) {
                org.apache.bcel.classfile.Method[] methods =
                  superClass.
                  getMethods(
                    );
                for (org.apache.bcel.classfile.Method method1
                      :
                      methods) {
                    methodMap.
                      put(
                        method1.
                          getName(
                            ),
                        method1.
                          getSignature(
                            ));
                }
            }
        }
        catch (java.lang.ClassNotFoundException cnfe) {
            bugReporter.
              reportMissingClass(
                cnfe);
        }
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        for (edu.umd.cs.findbugs.BugInstance bi
              :
              badOverrideMap.
               values(
                 )) {
            if (bi !=
                  null) {
                bugReporter.
                  reportBug(
                    bi);
            }
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        if (isAdapter) {
            java.lang.String methodName =
              obj.
              getName(
                );
            java.lang.String signature =
              methodMap.
              get(
                methodName);
            if (!"<init>".
                  equals(
                    methodName) &&
                  signature !=
                  null) {
                if (!signature.
                      equals(
                        obj.
                          getSignature(
                            ))) {
                    if (!badOverrideMap.
                          keySet(
                            ).
                          contains(
                            methodName)) {
                        badOverrideMap.
                          put(
                            methodName,
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              "BOA_BADLY_OVERRIDDEN_ADAPTER",
                              NORMAL_PRIORITY).
                              addClassAndMethod(
                                this).
                              addSourceLine(
                                this));
                    }
                }
                else {
                    badOverrideMap.
                      put(
                        methodName,
                        null);
                }
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CP5LY2497pscBlgdZZz2Wv4HHrVy/10iAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1od5HujBvLXBN6vKLKwhQypEhVm7CbNt4NM7TNtgKth2Xp14S0dd1Ec+IkkV" +
       "korGYGNEYTAwmuacAIthY68vD9ae3EKrFVVsN4z6dAMH69qkteQcOHRaQyHm" +
       "vC07Ar4watuDWb05nFfceKe7S2o3M1fSptpauLtqjnlOozUyzAafrdy2BJMq" +
       "PnbHK3JcjXYUxhBGXVXX6XI0H2e4WRm3nVqj1hnmYYRnKL7zuOV65iGoSDSH" +
       "qK/w84rtp/OgM6+Ma8FEYleoSPONymDRoNk4jIN5pzJbzNNl0Iv7JDqakt2q" +
       "OMeohiN5CUu4Uyryx5lsebigOzAf0clSEvm1mHFzbFh1J6tdJ+yvEqQWSRpC" +
       "4RnbSPV2azC1MMonG55X0cbK2BvvTH+bsbu+qGjLMZzM5iuammE5x1oj2mkl" +
       "yEhsLx0sxNaSVx0memOZ8GCvWNsNG8OGRitJoxYFMTcwWMIb1eMYFxsNBefm" +
       "TE4s6z4M01U0jnyEneeWPCW4XiWxxBk6H6ikNewyOoVPgqFEUHoN9vlWrkZV" +
       "blfZ7mzHtmSdhNNYlDe7FglvNv7SySYbeaGYkkbGra2ZMqo6m+akrdek2syu" +
       "cKmdLWctemg7MW7lWaITncpkiAW2ZDV5RB51RqDuaPh8yxFGrYeqit1pBt7G" +
       "1/Bxk5HrCIaGsdZ1TV0BOdFsg1BUJO3gWtXudDo/WByH/L3v7pjm0fL06fjp" +
       "0Pdw7rTveroo3nl8UFh+rkPnnpucOig8c/QWR9DbL3sRVN6ufPpDL72sc79Q" +
       "u3p4Ticl0INJEP6Aa2wM9xSoa69/V8GWVxonF4pf+NAfPyH+kPX+7+I5xTvO" +
       "4Xke5D9kP/Ol/ru0n7sKXTu+XnzNU62zk144d54dGUka+eKZq8W3n33SUNy7" +
       "1Q45Wzt/BHsiu4sv4N69l/25e/Fzd+vPBpF5oIaqZhkHC81w9wfkxVujg4G6" +
       "UUvxlHB+7XXu1/9ZUfyjBLq/vA658NhvE9j6iZ796lk9e/hYz47xunPqcPzw" +
       "1Ph1VPO1N99lw+fOcvM58B0ecnP4l8rN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4u8/KQd8+XXY9DtF8YUEulmyqbM8vKj9jRO+fPFSvhTNv/l/zYHCOsVDDoj/" +
       "T/Tpqcv1aW8NJZCvvg6Xfr8ovnKkTOcY9G/+Ehm0TaDHL37hVVyFvvU1D0z3" +
       "jyK1X3751gNveXn678pHTscPFx9koAeWqeuefjVwqn49jIylXdL34P4NQVj+" +
       "/McEeuLyB2gJdH1fKXH/w/2UbyTQYxdMScD6h9XTo78J1O1kdAJd1c50/5cE" +
       "unHYnUDXQHm681XQBDqL6n89vnd5z4X3LjuAZaAbggacq+2DTUOBNUgUr5z1" +
       "/8dyvPOdjvxPhYxnL704ZdP9A+F72mdfHox+7NXWL+xfcAGdy8vQ9gAD3dg/" +
       "Jjt27E9fCu0I1nXquW8/8rkH33kUhB7ZI3xiHqdwe8fFz6UIL0zKB075r73l" +
       "V9/791/+WnnL8n8Ast6SSrctAAA=");
}
