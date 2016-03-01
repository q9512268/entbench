package edu.umd.cs.findbugs.detect;
public class FindUnrelatedTypesInGenericContainer implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "gc.debug");
    static class Info {
        public Info(edu.umd.cs.findbugs.classfile.ClassDescriptor interfaceForCall,
                    int argumentIndex,
                    int typeIndex) { super();
                                     this.interfaceForCall = interfaceForCall;
                                     this.argumentIndex = argumentIndex;
                                     this.typeIndex = typeIndex; }
        final edu.umd.cs.findbugs.classfile.ClassDescriptor interfaceForCall;
        final int argumentIndex;
        final int typeIndex;
        @java.lang.Override
        public java.lang.String toString() { return java.lang.String.
                                               format(
                                                 "[%s %d %d]",
                                                 interfaceForCall,
                                                 argumentIndex,
                                                 typeIndex); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYfWwUxxWfO39gjL/5jAED5iCCkNuQhlSpKQEMhiPnD2Gw" +
                                                                  "VJNwzO3N2Yv3dpfdWftsSgpIDW6lIpoQIFFAkUqUFJGAqkZJ1SaiitokSlop" +
                                                                  "adokrUKqtlJpU9SgqklV2qZvZnZvP+7OBPWPWtrx3sx7b96b9/F7s+evoirL" +
                                                                  "RG1Eo3E6bhArvlmjfdi0SKZTxZa1A+ZS8skK/LfdV3ruiaLqQdQwjK1uGVuk" +
                                                                  "SyFqxhpECxXNoliTidVDSIZx9JnEIuYopoquDaLZipXIGaoiK7RbzxBGMIDN" +
                                                                  "JGrGlJpK2qYk4QigaGESNJG4JtKG8HJHEtXJujHukc/zkXf6VhhlztvLoqgp" +
                                                                  "uRePYsmmiiolFYt25E10m6Gr40OqTuMkT+N71TXOEWxLrik6gvaLjZ9cPzbc" +
                                                                  "xI9gJtY0nXLzrO3E0tVRkkmiRm92s0py1j70IKpIohk+YopiSXdTCTaVYFPX" +
                                                                  "Wo8KtK8nmp3r1Lk51JVUbchMIYqWBIUY2MQ5R0wf1xkk1FDHds4M1i4uWCus" +
                                                                  "LDLx0duk4yd3N32vAjUOokZF62fqyKAEhU0G4UBJLk1Ma0MmQzKDqFkDZ/cT" +
                                                                  "U8GqMuF4usVShjRMbXC/eyxs0jaIyff0zgr8CLaZtkx1s2BelgeU86sqq+Ih" +
                                                                  "sHWOZ6uwsIvNg4G1CihmZjHEncNSOaJoGYoWhTkKNsbuAwJgnZYjdFgvbFWp" +
                                                                  "YZhALSJEVKwNSf0QetoQkFbpEIAmRa1lhbKzNrA8godIikVkiK5PLAHVdH4Q" +
                                                                  "jIWi2WEyLgm81Bryks8/V3vWHt2vbdWiKAI6Z4isMv1nAFNbiGk7yRKTQB4I" +
                                                                  "xrqVyRN4zkuTUYSAeHaIWNC88NVr61e1XXpN0MwvQdOb3ktkmpLPphveWtC5" +
                                                                  "4p4KpkaNoVsKc37Acp5lfc5KR96ACjOnIJEtxt3FS9t/+pWD58hHUVSbQNWy" +
                                                                  "rto5iKNmWc8ZikrMLUQjJqYkk0DTiZbp5OsJNA3ek4pGxGxvNmsRmkCVKp+q" +
                                                                  "1vlvOKIsiGBHVAvvipbV3XcD02H+njcQQjPgQU3wsB/I/U/RqDSs54iEZawp" +
                                                                  "mi71mTqz35Kg4qThbIelLART2h6yJMuUJR46JGNLdi4jyZa3mCEU2KQu+L1T" +
                                                                  "M4nKrGHHaSU0bp3IMAyqm3EmxPi/7ZxnZzJzLBIBdy0IFwsV8myrrmaImZKP" +
                                                                  "2xs3X3su9YYIRJY8zmlStAkUiYMicdmKu4rEhSLxz6NILAF+QpEIV2IW00rE" +
                                                                  "C3h7BOoGFO66Ff0PbNsz2V4BgWqMVYKrGGl7AMA6veLiIkJKvtBSP7Hk8upX" +
                                                                  "oqgyiVqwTG2sMjzaYA5BpZNHnGJQlwZo8xBmsQ9hGDSaugwmmqQc0jhSavRR" +
                                                                  "YrJ5imb5JLj4xzJdKo8+JfVHl06NHRr42h1RFA2CCtuyCuohY+9jUFAo+bFw" +
                                                                  "MSklt/HIlU8unDige2UlgFIuuBZxMhvaw2ESPp6UvHIxfj710oEYP/bpsuto" +
                                                                  "itrCewSqVoeLAMyWGjA4q5s5rPKwcc64lg6b+pg3w+O3mb/PgrBoZGk8E559" +
                                                                  "Tl7vE8ODUIvYOFfEO4uzkBUcYb7cb5x+7+d/+gI/bheMGn1dRD+hHb4CyIS1" +
                                                                  "8FLX7IXtDpMQoPvgVN8jj149sovHLFAsLbVhjI2dUPjAhXDMX39t3/sfXj77" +
                                                                  "TtSLcwodgJ2GRipfMLKG2dQwhZGw23JPHyigKqQii5rYTg3iU8kqOK0Sllj/" +
                                                                  "aly2+vm/HG0ScaDCjBtGq24swJu/ZSM6+MbuT9u4mIjMANw7M49MoMJMT/IG" +
                                                                  "08TjTI/8obcXPvYqPg34AjXdUiYIL9MV/AwquOXzKLq9VKHh7RGr+gI2NxFL" +
                                                                  "NhWDtRiBCsGysN9OW5DNSg6cN+rg5J19e+TJWN8fBAbeUoJB0M1+RvrWwLt7" +
                                                                  "3+ShUcPqBZtnitX7qgHUFV9cNgmXfQZ/EXj+wx7mKjYh8Kal0wG9xQXUM4w8" +
                                                                  "aL5iijY1aIB0oOXDkSeuPCsMCHcFIWIyefybn8WPHhf+Fq3T0qLuxc8j2idh" +
                                                                  "Dhs6mHZLptqFc3T98cKBHz5z4IjQqiXYCGyGPvfZX/37zfip375eAk8qFKf9" +
                                                                  "vYslQKHczwr6Rhi06RuNPzrWUtEFlSaBamxN2WeTRMYvETo/y077nOW1ZHzC" +
                                                                  "bxpzDEWRleADNvElPq7hutxR0AhxjRBf28aGZZa/6gb95evwU/Kxdz6uH/j4" +
                                                                  "5Wvc5uAVwV9kurEhDryZDcvZgc8No+JWbA0D3V2Xeu5vUi9dB4mDIFGGvtjq" +
                                                                  "NQGw84GS5FBXTfv1j1+Zs+etChTtQrWqjjNdmFd3NB3KKrGGAevzxr3rRVUZ" +
                                                                  "q3F6JJRHRcYXTbDMXlS6ZmzOGZRn+cSLc7+/9ukzl3l5M4SM+U6KQ/sRgHN+" +
                                                                  "0fQQ5dwvvvjLp799YkzE0xTZEeKb989eNX34d/8oOnIOoCUSJsQ/KJ1/orVz" +
                                                                  "3Uec30Myxh3LF7dM0A14vHeey/092l79kyiaNoiaZOdiN4BVm+HDIFxmLPe2" +
                                                                  "B5e/wHrwYiK68I4CUi8IZ6xv2zCG+hOhkgaC3oNNBiZIgmfUQZTRMGxGEH+5" +
                                                                  "n7PcyseVbLjdRakqKMhYDYFU/RQi4XpeuMx16WYnVvnV5m4B0Gy8jw0PCJE9" +
                                                                  "ZaNyIGjFYkbjbDlWxgrRO9zKhlSxwuW4KarH5pCdgzBNaBkiKkRI2+xNaruA" +
                                                                  "r4i/fBlt1Sm1LcdNIafB22U1zU2hab6sl6st/n3AczNP/loUukj5exEvyRGr" +
                                                                  "ZAvL3XU5bJw9fPxMpvep1VGnvm6ELZ1PEJ4cBgYLA8Wim1/tvcz7oOHh3/8g" +
                                                                  "NrTxZtp+Ntd2g8ae/V4Eab+yfP0Jq/Lq4T+37lg3vOcmOvhFoSMKi/xu9/nX" +
                                                                  "tyyXH47y7xiiJBR9/wgydQQLQa1JqG1qQQxcWnDqHOasNnj2O07dHw5NL5iK" +
                                                                  "o4S9xkt0q+WETQGvD02xNsmGgxTVUF18uHG7xCaOQqxwxn0LPOgPBYO+rhD0" +
                                                                  "EZe5xWPuBaebSoZMkSefBxfZxA4jT6FBgWuuu8+9/+OdGVJgXtG3PfE9Sn7u" +
                                                                  "TGPN3DM73+XRX/hmVAdxnLVV1Y8HvvdqwyRZhZ9snUAH0QOdpKi1vK6QnuKF" +
                                                                  "23VCsDxO0cwSLOAq99VPfZqiWo+aoqgcWH6SomnOMnSGMPoXvwNTsMhezxol" +
                                                                  "/C+AMx8JFqFCOMy+UbX21a2lgZTnX1/d9LTF99eUfOHMtp791+5+Slwf4WIy" +
                                                                  "McGkzIAWVNxkCym+pKw0V1b11hXXGy5OX+ZWwmahsJd48325sAMi2GAdWGvo" +
                                                                  "bmXFCles98+ufflnk9VvQyezC0Uw+GhXcYuRN2yorbuSxa02lEN+6etY8fj4" +
                                                                  "ulXZv/6GN3FONV5Qnh5aqEfeS1wc+XQ9/9xXpTBA4r3PpnFtO5FHzUDf3sDC" +
                                                                  "FbOs5efgHF99YZZ9bKCovfjKUvyJBhrcMWJu1G0tw4sclF9vJvAZ2K2KtmGE" +
                                                                  "GLwZ37Wuiw0dHHAh/lLJbsNwbnQVcHtji1vC1xc+yZlf4K9sePG/yqJHtIgZ" +
                                                                  "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private final edu.umd.cs.findbugs.util.MultiMap<java.lang.String,edu.umd.cs.findbugs.detect.FindUnrelatedTypesInGenericContainer.Info>
      callMap =
      new edu.umd.cs.findbugs.util.MultiMap<java.lang.String,edu.umd.cs.findbugs.detect.FindUnrelatedTypesInGenericContainer.Info>(
      java.util.LinkedList.class);
    private void addCheckedCall(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                java.lang.String className,
                                java.lang.String methodName,
                                java.lang.String sig,
                                int argumentParameterIndex,
                                int typeParameterIndex) {
        edu.umd.cs.findbugs.classfile.ClassDescriptor c =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getClassDescriptorForDottedClassName(
            className);
        java.lang.String call =
          methodName +
        sig;
        edu.umd.cs.findbugs.detect.FindUnrelatedTypesInGenericContainer.Info info =
          new edu.umd.cs.findbugs.detect.FindUnrelatedTypesInGenericContainer.Info(
          c,
          argumentParameterIndex,
          typeParameterIndex);
        callMap.
          add(
            call,
            info);
    }
    private void addCheckedCall(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                java.lang.String className,
                                java.lang.String methodName,
                                int typeParameterIndex) {
        addCheckedCall(
          className,
          methodName,
          "(Ljava/lang/Object;)",
          0,
          typeParameterIndex);
    }
    public FindUnrelatedTypesInGenericContainer(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        addCheckedCall(
          java.util.Collection.class.
            getName(
              ),
          "contains",
          0);
        addCheckedCall(
          java.util.Collection.class.
            getName(
              ),
          "remove",
          0);
        addCheckedCall(
          java.util.Collection.class.
            getName(
              ),
          "containsAll",
          "(Ljava/util/Collection;)",
          0,
          -1);
        addCheckedCall(
          java.util.Collection.class.
            getName(
              ),
          "removeAll",
          "(Ljava/util/Collection;)",
          0,
          -1);
        addCheckedCall(
          java.util.Collection.class.
            getName(
              ),
          "retainAll",
          "(Ljava/util/Collection;)",
          0,
          -1);
        addCheckedCall(
          "java.util.Deque",
          "removeFirstOccurrence",
          0);
        addCheckedCall(
          "java.util.Deque",
          "removeLastOccurrence",
          0);
        addCheckedCall(
          java.util.List.class.
            getName(
              ),
          "indexOf",
          0);
        addCheckedCall(
          java.util.List.class.
            getName(
              ),
          "lastIndexOf",
          0);
        addCheckedCall(
          java.util.Vector.class.
            getName(
              ),
          "indexOf",
          "(Ljava/lang/Object;I)",
          0,
          0);
        addCheckedCall(
          java.util.Vector.class.
            getName(
              ),
          "lastIndexOf",
          "(Ljava/lang/Object;I)",
          0,
          0);
        addCheckedCall(
          java.util.Map.class.
            getName(
              ),
          "containsKey",
          0);
        addCheckedCall(
          java.util.Map.class.
            getName(
              ),
          "containsValue",
          1);
        addCheckedCall(
          java.util.Map.class.
            getName(
              ),
          "get",
          0);
        addCheckedCall(
          java.util.Map.class.
            getName(
              ),
          "remove",
          0);
        addCheckedCall(
          java.util.Hashtable.class.
            getName(
              ),
          "contains",
          1);
        addCheckedCall(
          java.util.concurrent.ConcurrentHashMap.class.
            getName(
              ),
          "contains",
          1);
        addCheckedCall(
          java.util.concurrent.ConcurrentMap.class.
            getName(
              ),
          "remove",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          0,
          0);
        addCheckedCall(
          java.util.concurrent.ConcurrentMap.class.
            getName(
              ),
          "remove",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          1,
          1);
        addCheckedCall(
          "com.google.common.collect.Multimap",
          "containsEntry",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          0,
          0);
        addCheckedCall(
          "com.google.common.collect.Multimap",
          "containsEntry",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          1,
          1);
        addCheckedCall(
          "com.google.common.collect.Multimap",
          "containsKey",
          0);
        addCheckedCall(
          "com.google.common.collect.Multimap",
          "containsValue",
          1);
        addCheckedCall(
          "com.google.common.collect.Multimap",
          "remove",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          0,
          0);
        addCheckedCall(
          "com.google.common.collect.Multimap",
          "remove",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          1,
          1);
        addCheckedCall(
          "com.google.common.collect.Multimap",
          "removeAll",
          0);
        addCheckedCall(
          "com.google.common.cache.Cache",
          "invalidate",
          0);
        addCheckedCall(
          "com.google.common.collect.Multiset",
          "count",
          0);
        addCheckedCall(
          "com.google.common.collect.Multiset",
          "remove",
          "(Ljava/lang/Object;I)",
          0,
          0);
        addCheckedCall(
          "com.google.common.collect.Table",
          "contains",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          0,
          0);
        addCheckedCall(
          "com.google.common.collect.Table",
          "contains",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          1,
          1);
        addCheckedCall(
          "com.google.common.collect.Table",
          "containsRow",
          0);
        addCheckedCall(
          "com.google.common.collect.Table",
          "containsColumn",
          1);
        addCheckedCall(
          "com.google.common.collect.Table",
          "containsValue",
          2);
        addCheckedCall(
          "com.google.common.collect.Table",
          "get",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          0,
          0);
        addCheckedCall(
          "com.google.common.collect.Table",
          "get",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          1,
          1);
        addCheckedCall(
          "com.google.common.collect.Table",
          "remove",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          0,
          0);
        addCheckedCall(
          "com.google.common.collect.Table",
          "remove",
          "(Ljava/lang/Object;Ljava/lang/Object;)",
          1,
          1);
        addCheckedCall(
          "com.google.common.collect.Sets",
          "intersection",
          "(Ljava/util/Set;Ljava/util/Set;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Sets",
          "difference",
          "(Ljava/util/Set;Ljava/util/Set;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Sets",
          "symmetricDifference",
          "(Ljava/util/Set;Ljava/util/Set;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Iterables",
          "contains",
          "(Ljava/lang/Iterable;Ljava/lang/Object;)",
          1,
          0);
        addCheckedCall(
          "com.google.common.collect.Iterables",
          "removeAll",
          "(Ljava/lang/Iterable;Ljava/util/Collection;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Iterables",
          "retainAll",
          "(Ljava/lang/Iterable;Ljava/util/Collection;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Iterables",
          "elementsEqual",
          "(Ljava/lang/Iterable;Ljava/lang/Iterable;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Iterables",
          "frequency",
          "(Ljava/lang/Iterable;Ljava/lang/Object;)",
          1,
          0);
        addCheckedCall(
          "com.google.common.collect.Iterators",
          "contains",
          "(Ljava/util/Iterator;Ljava/lang/Object;)",
          1,
          0);
        addCheckedCall(
          "com.google.common.collect.Iterators",
          "removeAll",
          "(Ljava/util/Iterator;Ljava/util/Collection;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Iterators",
          "retainAll",
          "(Ljava/util/Iterator;Ljava/util/Collection;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Iterators",
          "elementsEqual",
          "(Ljava/util/Iterator;Ljava/util/Iterator;)",
          1,
          -1);
        addCheckedCall(
          "com.google.common.collect.Iterators",
          "frequency",
          "(Ljava/util/Iterator;Ljava/lang/Object;)",
          1,
          0);
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        org.apache.bcel.classfile.Method[] methodList =
          javaClass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            if (method.
                  getCode(
                    ) ==
                  null) {
                continue;
            }
            try {
                analyzeMethod(
                  classContext,
                  method);
            }
            catch (edu.umd.cs.findbugs.ba.MethodUnprofitableException e) {
                assert true;
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                java.lang.String msg =
                  "Detector " +
                this.
                  getClass(
                    ).
                  getName(
                    ) +
                " caught exception while analyzing " +
                javaClass.
                  getClassName(
                    ) +
                "." +
                method.
                  getName(
                    ) +
                " : " +
                method.
                  getSignature(
                    );
                bugReporter.
                  logError(
                    msg,
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                java.lang.String msg =
                  "Detector " +
                this.
                  getClass(
                    ).
                  getName(
                    ) +
                " caught exception while analyzing " +
                javaClass.
                  getClassName(
                    ) +
                "." +
                method.
                  getName(
                    ) +
                " : " +
                method.
                  getSignature(
                    );
                bugReporter.
                  logError(
                    msg,
                    e);
            }
        }
    }
    public boolean prescreen(edu.umd.cs.findbugs.ba.ClassContext classContext,
                             org.apache.bcel.classfile.Method method) {
        java.util.BitSet bytecodeSet =
          classContext.
          getBytecodeSet(
            method);
        return bytecodeSet !=
          null &&
          (bytecodeSet.
             get(
               org.apache.bcel.Constants.
                 INVOKEINTERFACE) ||
             bytecodeSet.
             get(
               org.apache.bcel.Constants.
                 INVOKEVIRTUAL) ||
             bytecodeSet.
             get(
               org.apache.bcel.Constants.
                 INVOKESPECIAL) ||
             bytecodeSet.
             get(
               org.apache.bcel.Constants.
                 INVOKESTATIC) ||
             bytecodeSet.
             get(
               org.apache.bcel.Constants.
                 INVOKENONVIRTUAL));
    }
    private boolean isSynthetic(org.apache.bcel.classfile.Method m) {
        if ((m.
               getAccessFlags(
                 ) &
               org.apache.bcel.Constants.
                 ACC_SYNTHETIC) !=
              0) {
            return true;
        }
        org.apache.bcel.classfile.Attribute[] attrs =
          m.
          getAttributes(
            );
        for (org.apache.bcel.classfile.Attribute attr
              :
              attrs) {
            if (attr instanceof org.apache.bcel.classfile.Synthetic) {
                return true;
            }
        }
        return false;
    }
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    static final java.util.Set<java.lang.String>
      baseGenericTypes =
      new java.util.LinkedHashSet<java.lang.String>(
      );
    static { baseGenericTypes.addAll(java.util.Arrays.
                                       asList(
                                         new java.lang.String[] { "java.util.Map",
                                         "java.util.Collection",
                                         "java.lang.Iterable",
                                         "java.util.Iterator",
                                         "com.google.common.collect.Multimap",
                                         "com.google.common.collect.Multiset",
                                         "com.google.common.collect.Table" }));
    }
    private boolean isGenericCollection(edu.umd.cs.findbugs.classfile.ClassDescriptor operandClass) {
        java.lang.String dottedClassName =
          operandClass.
          getDottedClassName(
            );
        if (baseGenericTypes.
              contains(
                dottedClassName)) {
            return true;
        }
        java.lang.String found =
          null;
        for (java.lang.String c
              :
              baseGenericTypes) {
            if (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                  instanceOf(
                    operandClass,
                    c)) {
                found =
                  c;
                break;
            }
        }
        if (found ==
              null) {
            return false;
        }
        if (dottedClassName.
              startsWith(
                "java.util.") ||
              dottedClassName.
              startsWith(
                "com.google.common.collect.")) {
            return true;
        }
        try {
            edu.umd.cs.findbugs.ba.XClass xclass =
              edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                ).
              getClassAnalysis(
                edu.umd.cs.findbugs.ba.XClass.class,
                operandClass);
            java.lang.String sig =
              xclass.
              getSourceSignature(
                );
            if (sig ==
                  null) {
                return false;
            }
            java.lang.String typeParameter =
              null;
            java.util.List<java.lang.String> split =
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.
              split(
                sig,
                true);
            if (sig.
                  charAt(
                    0) ==
                  '<') {
                int end =
                  sig.
                  indexOf(
                    ':');
                if (end >
                      0) {
                    typeParameter =
                      sig.
                        substring(
                          1,
                          end);
                }
            }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    dottedClassName +
                    " " +
                    typeParameter +
                    " " +
                    split);
            }
            for (java.lang.String s
                  :
                  split) {
                int i =
                  s.
                  indexOf(
                    '<');
                if (i <
                      0) {
                    continue;
                }
                if (s.
                      charAt(
                        0) !=
                      'L') {
                    throw new java.lang.IllegalStateException(
                      "unexpected non signature: " +
                      s);
                }
                edu.umd.cs.findbugs.classfile.ClassDescriptor c =
                  edu.umd.cs.findbugs.classfile.DescriptorFactory.
                  createClassDescriptor(
                    s.
                      substring(
                        1,
                        i));
                java.lang.String superTypeParameter =
                  s.
                  substring(
                    i +
                      1);
                if (isGenericCollection(
                      c) &&
                      (typeParameter ==
                         null ||
                         superTypeParameter.
                         startsWith(
                           "T" +
                           typeParameter))) {
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            operandClass +
                            " is a subtype of " +
                            s);
                    }
                    return true;
                }
            }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Not a subtype");
            }
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e1) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error checking for weird generic parameterization of " +
                operandClass,
                e1);
        }
        return false;
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (isSynthetic(
              method) ||
              !prescreen(
                 classContext,
                 method)) {
            return;
        }
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            classContext.
              getJavaClass(
                ),
            method);
        if (xmethod.
              isSynthetic(
                )) {
            return;
        }
        edu.umd.cs.findbugs.BugAccumulator accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
          bugReporter);
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
          classContext.
          getTypeDataflow(
            method);
        edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnDataflow =
          classContext.
          getValueNumberDataflow(
            method);
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        if (methodGen ==
              null) {
            return;
        }
        java.lang.String fullMethodName =
          methodGen.
          getClassName(
            ) +
        "." +
        methodGen.
          getName(
            );
        java.lang.String sourceFile =
          classContext.
          getJavaClass(
            ).
          getSourceFileName(
            );
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "\n" +
                fullMethodName);
        }
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> iter =
               cfg.
               locationIterator(
                 );
             iter.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              iter.
              next(
                );
            org.apache.bcel.generic.InstructionHandle handle =
              location.
              getHandle(
                );
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            if (!(ins instanceof org.apache.bcel.generic.InvokeInstruction)) {
                continue;
            }
            org.apache.bcel.generic.InvokeInstruction inv =
              (org.apache.bcel.generic.InvokeInstruction)
                ins;
            edu.umd.cs.findbugs.ba.XMethod invokedMethod =
              edu.umd.cs.findbugs.ba.XFactory.
              createXMethod(
                inv,
                cpg);
            java.lang.String invokedMethodName =
              invokedMethod.
              getName(
                );
            java.lang.String argSignature =
              invokedMethod.
              getSignature(
                );
            argSignature =
              argSignature.
                substring(
                  0,
                  argSignature.
                    indexOf(
                      ')') +
                    1);
            java.lang.String call =
              invokedMethodName +
            argSignature;
            edu.umd.cs.findbugs.ba.SignatureParser sigParser =
              new edu.umd.cs.findbugs.ba.SignatureParser(
              inv.
                getSignature(
                  cpg));
            java.util.Collection<edu.umd.cs.findbugs.detect.FindUnrelatedTypesInGenericContainer.Info> collection =
              callMap.
              get(
                call);
            if (!callMap.
                  containsKey(
                    call)) {
                continue;
            }
            for (edu.umd.cs.findbugs.detect.FindUnrelatedTypesInGenericContainer.Info info
                  :
                  collection) {
                edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                  edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getSubtypes2(
                    );
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "at " +
                        handle.
                          getPosition(
                            ) +
                        " Checking call to " +
                        info.
                          interfaceForCall +
                        " : " +
                        invokedMethod);
                }
                try {
                    if (!subtypes2.
                          isSubtype(
                            invokedMethod.
                              getClassDescriptor(
                                ),
                            info.
                              interfaceForCall)) {
                        continue;
                    }
                }
                catch (java.lang.ClassNotFoundException e) {
                    if ("java/util/Collection".
                          equals(
                            info.
                              interfaceForCall.
                              getClassName(
                                )) &&
                          "com.google.common.collect.Multiset".
                          equals(
                            invokedMethod.
                              getClassName(
                                ))) {
                        assert true;
                    }
                    else {
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          reportMissingClass(
                            e);
                        continue;
                    }
                }
                boolean allMethod;
                int typeArgument;
                if (info.
                      typeIndex >=
                      0) {
                    allMethod =
                      false;
                    typeArgument =
                      info.
                        typeIndex;
                }
                else {
                    allMethod =
                      true;
                    typeArgument =
                      -(1 +
                          info.
                            typeIndex);
                }
                int pos =
                  info.
                    argumentIndex;
                int lhsPos;
                if (inv instanceof org.apache.bcel.generic.INVOKESTATIC) {
                    lhsPos =
                      sigParser.
                        getSlotsFromTopOfStackForParameter(
                          0);
                }
                else {
                    lhsPos =
                      sigParser.
                        getTotalArgumentSize(
                          );
                }
                int stackPos =
                  sigParser.
                  getSlotsFromTopOfStackForParameter(
                    pos);
                edu.umd.cs.findbugs.ba.type.TypeFrame frame =
                  typeDataflow.
                  getFactAtLocation(
                    location);
                if (!frame.
                      isValid(
                        )) {
                    continue;
                }
                org.apache.bcel.generic.Type operandType =
                  frame.
                  getStackValue(
                    stackPos);
                if (operandType.
                      equals(
                        edu.umd.cs.findbugs.ba.type.TopType.
                          instance(
                            ))) {
                    continue;
                }
                if (operandType.
                      equals(
                        edu.umd.cs.findbugs.ba.type.NullType.
                          instance(
                            ))) {
                    continue;
                }
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnFrame =
                  vnDataflow.
                  getFactAtLocation(
                    location);
                if (!vnFrame.
                      isValid(
                        )) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "Invalid value number frame in " +
                        xmethod);
                    continue;
                }
                edu.umd.cs.findbugs.ba.vna.ValueNumber objectVN =
                  vnFrame.
                  getStackValue(
                    lhsPos);
                edu.umd.cs.findbugs.ba.vna.ValueNumber argVN =
                  vnFrame.
                  getStackValue(
                    stackPos);
                if (objectVN.
                      equals(
                        argVN)) {
                    java.lang.String bugPattern =
                      "DMI_COLLECTIONS_SHOULD_NOT_CONTAIN_THEMSELVES";
                    int priority =
                      HIGH_PRIORITY;
                    if ("removeAll".
                          equals(
                            invokedMethodName)) {
                        bugPattern =
                          "DMI_USING_REMOVEALL_TO_CLEAR_COLLECTION";
                        priority =
                          NORMAL_PRIORITY;
                    }
                    else
                        if (invokedMethodName.
                              endsWith(
                                "All")) {
                            bugPattern =
                              "DMI_VACUOUS_SELF_COLLECTION_CALL";
                            priority =
                              NORMAL_PRIORITY;
                        }
                    if (invokedMethodName.
                          startsWith(
                            "contains")) {
                        org.apache.bcel.generic.InstructionHandle next =
                          handle.
                          getNext(
                            );
                        if (next !=
                              null) {
                            org.apache.bcel.generic.Instruction nextIns =
                              next.
                              getInstruction(
                                );
                            if (nextIns instanceof org.apache.bcel.generic.InvokeInstruction) {
                                edu.umd.cs.findbugs.ba.XMethod nextMethod =
                                  edu.umd.cs.findbugs.ba.XFactory.
                                  createXMethod(
                                    (org.apache.bcel.generic.InvokeInstruction)
                                      nextIns,
                                    cpg);
                                if ("assertFalse".
                                      equals(
                                        nextMethod.
                                          getName(
                                            ))) {
                                    continue;
                                }
                            }
                        }
                    }
                    accumulator.
                      accumulateBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          bugPattern,
                          priority).
                          addClassAndMethod(
                            methodGen,
                            sourceFile).
                          addCalledMethod(
                            methodGen,
                            (org.apache.bcel.generic.InvokeInstruction)
                              ins).
                          addOptionalAnnotation(
                            edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                              findAnnotationFromValueNumber(
                                method,
                                location,
                                objectVN,
                                vnFrame,
                                "INVOKED_ON")),
                        edu.umd.cs.findbugs.SourceLineAnnotation.
                          fromVisitedInstruction(
                            classContext,
                            methodGen,
                            sourceFile,
                            handle));
                }
                org.apache.bcel.generic.Type objectType =
                  frame.
                  getStackValue(
                    lhsPos);
                if (!(objectType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType)) {
                    continue;
                }
                edu.umd.cs.findbugs.ba.generic.GenericObjectType operand =
                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                    objectType;
                int expectedTypeParameters =
                  1;
                java.lang.String simpleName =
                  info.
                    interfaceForCall.
                  getSimpleName(
                    );
                if (simpleName.
                      toLowerCase(
                        ).
                      endsWith(
                        "map") ||
                      "Hashtable".
                      equals(
                        simpleName)) {
                    expectedTypeParameters =
                      2;
                }
                else
                    if ("Table".
                          equals(
                            simpleName)) {
                        expectedTypeParameters =
                          3;
                    }
                if (!operand.
                      hasParameters(
                        )) {
                    continue;
                }
                if (operand.
                      getNumParameters(
                        ) !=
                      expectedTypeParameters) {
                    continue;
                }
                edu.umd.cs.findbugs.classfile.ClassDescriptor operandClass =
                  edu.umd.cs.findbugs.classfile.DescriptorFactory.
                  getClassDescriptor(
                    operand);
                if (!isGenericCollection(
                       operandClass)) {
                    continue;
                }
                if (expectedTypeParameters ==
                      2 &&
                      edu.umd.cs.findbugs.ba.ch.Subtypes2.
                      instanceOf(
                        operandClass,
                        java.util.Map.class) &&
                      !edu.umd.cs.findbugs.ba.type.TypeFrameModelingVisitor.
                      isStraightGenericMap(
                        operandClass)) {
                    continue;
                }
                org.apache.bcel.generic.Type expectedType;
                if (allMethod) {
                    expectedType =
                      operand;
                }
                else {
                    expectedType =
                      operand.
                        getParameterAt(
                          typeArgument);
                }
                org.apache.bcel.generic.Type actualType =
                  frame.
                  getStackValue(
                    stackPos);
                org.apache.bcel.generic.Type equalsType =
                  actualType;
                if (allMethod) {
                    if (!(actualType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType)) {
                        continue;
                    }
                    equalsType =
                      ((edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                         actualType).
                        getParameterAt(
                          typeArgument);
                }
                edu.umd.cs.findbugs.ba.IncompatibleTypes matchResult =
                  compareTypes(
                    expectedType,
                    actualType,
                    allMethod);
                boolean parmIsObject =
                  "Ljava/lang/Object;".
                  equals(
                    expectedType.
                      getSignature(
                        ));
                boolean selfOperation =
                  !allMethod &&
                  operand.
                  equals(
                    actualType) &&
                  !parmIsObject;
                if (!allMethod &&
                      !parmIsObject &&
                      actualType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                    edu.umd.cs.findbugs.ba.generic.GenericObjectType p2 =
                      (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                        actualType;
                    java.util.List<? extends org.apache.bcel.generic.ReferenceType> parameters =
                      p2.
                      getParameters(
                        );
                    if (parameters !=
                          null &&
                          parameters.
                          equals(
                            operand.
                              getParameters(
                                ))) {
                        selfOperation =
                          true;
                    }
                }
                if (!selfOperation &&
                      (matchResult ==
                         edu.umd.cs.findbugs.ba.IncompatibleTypes.
                           SEEMS_OK ||
                         matchResult.
                         getPriority(
                           ) ==
                         edu.umd.cs.findbugs.Priorities.
                           IGNORE_PRIORITY)) {
                    continue;
                }
                if (invokedMethodName.
                      startsWith(
                        "contains") ||
                      "remove".
                      equals(
                        invokedMethodName)) {
                    org.apache.bcel.generic.InstructionHandle next =
                      handle.
                      getNext(
                        );
                    if (next !=
                          null) {
                        org.apache.bcel.generic.Instruction nextIns =
                          next.
                          getInstruction(
                            );
                        if (nextIns instanceof org.apache.bcel.generic.InvokeInstruction) {
                            edu.umd.cs.findbugs.ba.XMethod nextMethod =
                              edu.umd.cs.findbugs.ba.XFactory.
                              createXMethod(
                                (org.apache.bcel.generic.InvokeInstruction)
                                  nextIns,
                                cpg);
                            if ("assertFalse".
                                  equals(
                                    nextMethod.
                                      getName(
                                        ))) {
                                continue;
                            }
                        }
                    }
                }
                else
                    if ("get".
                          equals(
                            invokedMethodName) ||
                          "remove".
                          equals(
                            invokedMethodName)) {
                        org.apache.bcel.generic.InstructionHandle next =
                          handle.
                          getNext(
                            );
                        if (next !=
                              null) {
                            org.apache.bcel.generic.Instruction nextIns =
                              next.
                              getInstruction(
                                );
                            if (nextIns instanceof org.apache.bcel.generic.InvokeInstruction) {
                                edu.umd.cs.findbugs.ba.XMethod nextMethod =
                                  edu.umd.cs.findbugs.ba.XFactory.
                                  createXMethod(
                                    (org.apache.bcel.generic.InvokeInstruction)
                                      nextIns,
                                    cpg);
                                if ("assertNull".
                                      equals(
                                        nextMethod.
                                          getName(
                                            ))) {
                                    continue;
                                }
                            }
                        }
                    }
                boolean noisy =
                  false;
                if ("get".
                      equals(
                        invokedMethodName)) {
                    edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefDataflow unconditionalValueDerefDataflow =
                      classContext.
                      getUnconditionalValueDerefDataflow(
                        method);
                    edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefSet unconditionalDeref =
                      unconditionalValueDerefDataflow.
                      getFactAtLocation(
                        location);
                    edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnAfter =
                      vnDataflow.
                      getFactAfterLocation(
                        location);
                    edu.umd.cs.findbugs.ba.vna.ValueNumber top =
                      vnAfter.
                      getTopValue(
                        );
                    noisy =
                      unconditionalDeref.
                        getValueNumbersThatAreUnconditionallyDereferenced(
                          ).
                        contains(
                          top);
                }
                edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    classContext,
                    methodGen,
                    sourceFile,
                    handle);
                if (expectedType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                    expectedType =
                      ((edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                         expectedType).
                        getUpperBound(
                          );
                }
                int priority =
                  matchResult.
                  getPriority(
                    );
                if (!operandClass.
                      getClassName(
                        ).
                      startsWith(
                        "java/util") &&
                      priority ==
                      edu.umd.cs.findbugs.Priorities.
                        HIGH_PRIORITY) {
                    priority =
                      java.lang.Math.
                        max(
                          priority,
                          edu.umd.cs.findbugs.Priorities.
                            NORMAL_PRIORITY);
                }
                if (edu.umd.cs.findbugs.ba.TestCaseDetector.
                      likelyTestCase(
                        xmethod)) {
                    priority =
                      java.lang.Math.
                        max(
                          priority,
                          edu.umd.cs.findbugs.Priorities.
                            NORMAL_PRIORITY);
                }
                else
                    if (selfOperation) {
                        priority =
                          edu.umd.cs.findbugs.Priorities.
                            HIGH_PRIORITY;
                    }
                edu.umd.cs.findbugs.classfile.ClassDescriptor expectedClassDescriptor =
                  edu.umd.cs.findbugs.classfile.DescriptorFactory.
                  createClassOrObjectDescriptorFromSignature(
                    expectedType.
                      getSignature(
                        ));
                edu.umd.cs.findbugs.classfile.ClassDescriptor actualClassDescriptor =
                  edu.umd.cs.findbugs.classfile.DescriptorFactory.
                  createClassOrObjectDescriptorFromSignature(
                    equalsType.
                      getSignature(
                        ));
                edu.umd.cs.findbugs.ba.ClassSummary classSummary =
                  edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getClassSummary(
                    );
                java.util.Set<edu.umd.cs.findbugs.ba.XMethod> targets =
                  null;
                try {
                    targets =
                      edu.umd.cs.findbugs.ba.Hierarchy2.
                        resolveVirtualMethodCallTargets(
                          actualClassDescriptor,
                          "equals",
                          "(Ljava/lang/Object;)Z",
                          false,
                          false);
                    boolean allOk =
                      targets.
                      size(
                        ) >
                      0;
                    for (edu.umd.cs.findbugs.ba.XMethod m2
                          :
                          targets) {
                        if (!classSummary.
                              mightBeEqualTo(
                                m2.
                                  getClassDescriptor(
                                    ),
                                expectedClassDescriptor)) {
                            allOk =
                              false;
                        }
                    }
                    if (allOk) {
                        priority +=
                          2;
                    }
                }
                catch (java.lang.ClassNotFoundException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      reportMissingClass(
                        e);
                }
                java.lang.String bugPattern =
                  "GC_UNRELATED_TYPES";
                edu.umd.cs.findbugs.BugInstance bug =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  bugPattern,
                  priority).
                  addClassAndMethod(
                    methodGen,
                    sourceFile).
                  addFoundAndExpectedType(
                    actualType,
                    expectedType).
                  addCalledMethod(
                    methodGen,
                    (org.apache.bcel.generic.InvokeInstruction)
                      ins).
                  addOptionalAnnotation(
                    edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                      findAnnotationFromValueNumber(
                        method,
                        location,
                        objectVN,
                        vnFrame,
                        "INVOKED_ON")).
                  addOptionalAnnotation(
                    edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                      findAnnotationFromValueNumber(
                        method,
                        location,
                        argVN,
                        vnFrame,
                        "ARGUMENT")).
                  addEqualsMethodUsed(
                    targets);
                if (noisy) {
                    edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet =
                      new edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty>(
                      );
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.props.GeneralWarningProperty.
                          NOISY_BUG);
                    propertySet.
                      decorateBugInstance(
                        bug);
                }
                accumulator.
                  accumulateBug(
                    bug,
                    sourceLineAnnotation);
            }
        }
        accumulator.
          reportAccumulatedBugs(
            );
    }
    private edu.umd.cs.findbugs.ba.IncompatibleTypes compareTypes(org.apache.bcel.generic.Type expectedType,
                                                                  org.apache.bcel.generic.Type actualType,
                                                                  boolean ignoreBaseType) {
        if (expectedType ==
              actualType) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        java.lang.String expectedString =
          edu.umd.cs.findbugs.ba.generic.GenericUtilities.
          getString(
            expectedType);
        java.lang.String actualString =
          edu.umd.cs.findbugs.ba.generic.GenericUtilities.
          getString(
            actualType);
        if (expectedString.
              equals(
                actualString)) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        if (expectedType.
              equals(
                org.apache.bcel.generic.Type.
                  OBJECT)) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        java.lang.String objString =
          edu.umd.cs.findbugs.ba.generic.GenericUtilities.
          getString(
            org.apache.bcel.generic.Type.
              OBJECT);
        if (expectedString.
              equals(
                objString)) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory expectedCat =
          edu.umd.cs.findbugs.ba.generic.GenericUtilities.
          getTypeCategory(
            expectedType);
        edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory argCat =
          edu.umd.cs.findbugs.ba.generic.GenericUtilities.
          getTypeCategory(
            actualType);
        if (actualString.
              equals(
                objString) &&
              expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                TYPE_VARIABLE) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                WILDCARD) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        if (ignoreBaseType) {
            if (expectedCat ==
                  edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                    PARAMETERIZED &&
                  argCat ==
                  edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                    PARAMETERIZED) {
                edu.umd.cs.findbugs.ba.generic.GenericObjectType parmGeneric =
                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                    expectedType;
                edu.umd.cs.findbugs.ba.generic.GenericObjectType argGeneric =
                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                    actualType;
                return compareTypeParameters(
                         parmGeneric,
                         argGeneric);
            }
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        if (actualType.
              equals(
                org.apache.bcel.generic.Type.
                  OBJECT) &&
              expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                ARRAY_TYPE) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     ARRAY_AND_OBJECT;
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PLAIN_OBJECT_TYPE &&
              argCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PLAIN_OBJECT_TYPE) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
              getPriorityForAssumingCompatible(
                expectedType,
                actualType,
                false);
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PARAMETERIZED &&
              argCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PLAIN_OBJECT_TYPE) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
              getPriorityForAssumingCompatible(
                (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                  expectedType,
                actualType);
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PLAIN_OBJECT_TYPE &&
              argCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PARAMETERIZED) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
              getPriorityForAssumingCompatible(
                (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                  actualType,
                expectedType);
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                WILDCARD_EXTENDS ||
              expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                WILDCARD_SUPER) {
            return compareTypes(
                     ((edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                        expectedType).
                       getExtension(
                         ),
                     actualType,
                     ignoreBaseType);
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                TYPE_VARIABLE ||
              argCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                TYPE_VARIABLE) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                ARRAY_TYPE &&
              argCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                ARRAY_TYPE) {
            org.apache.bcel.generic.ArrayType parmArray =
              (org.apache.bcel.generic.ArrayType)
                expectedType;
            org.apache.bcel.generic.ArrayType argArray =
              (org.apache.bcel.generic.ArrayType)
                actualType;
            if (parmArray.
                  getDimensions(
                    ) !=
                  argArray.
                  getDimensions(
                    )) {
                return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                         ARRAY_AND_NON_ARRAY;
            }
            return compareTypes(
                     parmArray.
                       getBasicType(
                         ),
                     argArray.
                       getBasicType(
                         ),
                     ignoreBaseType);
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                ARRAY_TYPE ^
              argCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                ARRAY_TYPE) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     ARRAY_AND_NON_ARRAY;
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PARAMETERIZED &&
              argCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                PARAMETERIZED) {
            edu.umd.cs.findbugs.ba.generic.GenericObjectType parmGeneric =
              (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                expectedType;
            edu.umd.cs.findbugs.ba.generic.GenericObjectType argGeneric =
              (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                actualType;
            {
                edu.umd.cs.findbugs.ba.IncompatibleTypes result =
                  compareTypes(
                    parmGeneric.
                      getObjectType(
                        ),
                    argGeneric.
                      getObjectType(
                        ),
                    ignoreBaseType);
                if (!result.
                      equals(
                        edu.umd.cs.findbugs.ba.IncompatibleTypes.
                          SEEMS_OK)) {
                    return result;
                }
            }
            return compareTypeParameters(
                     parmGeneric,
                     argGeneric);
        }
        if (false) {
            if (expectedCat ==
                  edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                    PARAMETERIZED ^
                  argCat ==
                  edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                    PARAMETERIZED) {
                return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                         SEEMS_OK;
            }
        }
        if (expectedCat ==
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                WILDCARD) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        if (expectedType instanceof org.apache.bcel.generic.BasicType ||
              actualType instanceof org.apache.bcel.generic.BasicType) {
            throw new java.lang.IllegalArgumentException(
              "checking for compatibility of " +
              expectedType +
              " with " +
              actualType);
        }
        return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                 SEEMS_OK;
    }
    private edu.umd.cs.findbugs.ba.IncompatibleTypes compareTypeParameters(edu.umd.cs.findbugs.ba.generic.GenericObjectType parmGeneric,
                                                                           edu.umd.cs.findbugs.ba.generic.GenericObjectType argGeneric) {
        int p =
          parmGeneric.
          getNumParameters(
            );
        if (p !=
              argGeneric.
              getNumParameters(
                )) {
            return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                     SEEMS_OK;
        }
        for (int x =
               0;
             x <
               p;
             x++) {
            edu.umd.cs.findbugs.ba.IncompatibleTypes result =
              compareTypes(
                parmGeneric.
                  getParameterAt(
                    x),
                argGeneric.
                  getParameterAt(
                    x),
                false);
            if (result !=
                  edu.umd.cs.findbugs.ba.IncompatibleTypes.
                    SEEMS_OK) {
                return result;
            }
        }
        return edu.umd.cs.findbugs.ba.IncompatibleTypes.
                 SEEMS_OK;
    }
    private boolean compareTypesOld(org.apache.bcel.generic.Type parmType,
                                    org.apache.bcel.generic.Type argType) {
        if (edu.umd.cs.findbugs.ba.generic.GenericUtilities.
              getString(
                parmType).
              equals(
                edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                  getString(
                    argType))) {
            return true;
        }
        if (parmType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
            edu.umd.cs.findbugs.ba.generic.GenericObjectType o =
              (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                parmType;
            if (o.
                  getTypeCategory(
                    ) ==
                  edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                    WILDCARD_EXTENDS) {
                return compareTypesOld(
                         o.
                           getExtension(
                             ),
                         argType);
            }
        }
        if (parmType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType &&
              !((edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                  parmType).
              hasParameters(
                )) {
            return true;
        }
        if (argType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType &&
              !((edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                  argType).
              hasParameters(
                )) {
            return true;
        }
        if (parmType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType &&
              argType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
            return true;
        }
        else {
            if (!(parmType instanceof org.apache.bcel.generic.ReferenceType &&
                    argType instanceof org.apache.bcel.generic.ReferenceType)) {
                return true;
            }
            if (!(parmType instanceof org.apache.bcel.generic.ObjectType &&
                    argType instanceof org.apache.bcel.generic.ObjectType)) {
                return true;
            }
            try {
                return org.apache.bcel.Repository.
                  instanceOf(
                    ((org.apache.bcel.generic.ObjectType)
                       argType).
                      getClassName(
                        ),
                    ((org.apache.bcel.generic.ObjectType)
                       parmType).
                      getClassName(
                        ));
            }
            catch (java.lang.ClassNotFoundException e) {
                
            }
        }
        return true;
    }
    @java.lang.Override
    public void report() {  }
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
       "46BFldoxQ9PGV435rK6LUSQwIF8n2hCi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("hEuYd/BmN+fEYSNxVrkRYjRl1psi4XXWZnO3nDXq1LK7NmFEQEWQtIwzjxlq" +
       "RjPa1DfMxBBhPmZGjJMhozFr8+EGGpvzfAsTM9vpxhjNRNZW9HfV2WS2UlYW" +
       "WMXjkUIqpr/q8yOjRrlVaIBSOdka+qQBwmg2pnqbeBRhELueOdWoBjzVEcDi" +
       "2Wf1BDMWHaRndGK93hCa1TavkJ25UpXobTWqZtXEq4GFiz3gmoNZQgxtFepT" +
       "7CoNrTVITjt1ah4oUbga7HrzfmtqTLEkkZc6tE1W+UJrhiIHwm1TCFdbWXA9" +
       "jh7U1p0GO80xilhBcm7Fvr7TFs7UN/hw7frEZNKQrHiHV5nauqdWBdmqMgHc" +
       "zNrNSc9heEVd6mHUni7GIg6WcnXLJhfjbaYobcAZj0gC8NsY3yLyepuoLpvP" +
       "c2qiW/5moSDMhOvn6IDiEcPsytuMZqaNHS/EUMzvphHqQtXch2QwifhU39dm" +
       "Zne6i7d5O1qiFE35m50giO1AI3KjlmfNbTLfpi1Gr6IDyCH6C64t86mS5PUA" +
       "R9FGVW0SWdRsWQQUCl1YmvaTtlZn4p4AB7aij1M6IZtY0hRWfVnbiILNVClW" +
       "k8YQnY4kHRuavel2GZFrA1ctK23JqGpuuLbZgZlOKAZjE6E0iVfnhrlOhcVc" +
       "IKUG2yfkHZPME7DaqbVVXxgyRrdbbC9+6uVte7623M09OYv5E+zj7pueLIq3" +
       "n7w0KP/uqlw4v3fmpcGZ/fGTXe83X7brjZfvVbygeEf9lludwyzfT3/i/c+/" +
       "oE5+t3blaMddiCr3RJ7/TltLNPvM8+67/fveUXkM9fRwxufe/1ePzn/OfM/L" +
       "OJr2+AU+L5L8J6NPfmH4U8rfvVK5enJU40UHZM8PeubCC7ZAi+LAnZ87pvGW" +
       "E/iLt8KVj4LruSP4n7v4zuZUwS8ylYPitr83kAtnjO4sO9x5YiL74rL98auW" +
       "W76B+VxJ509uc1bpi0Xxx1HlAUlVe6ambDS1J9n2pZvuiWepp1b5r15qv/3s" +
       "o8qKPzqPUPFm8PkjhJ5/dRC6euptpwjtQfjKbUD486L4Dy8Coaj90qnAX34F" +
       "ApcnBt8Fru8fCfz9lyvwOy4V+MLRtbdd5sOytHfVo2PrJZ2/uA0a3yyKr4Pg" +
       "VL6yPzv0AiDfeMk3aQ+deYubaEFgqdpLviW7DYoPF5VvBvRfvx+9/33lKF45" +
       "fVX6X49Zf8ILjEPJlxRTO5QVzd6/eCzOTx8FlJLSd2+D4/eL4tsgDPqBFiqB" +
       "ppXnbxan+H3nFRjU64rKx4FUTx5B8eSr40EHpx2+V3Q4uHprCQ/KUPTDqHKf" +
       "FXI7NzK1o9NXZ2T80SuV8acBN80jGZuvqozHmn7nZU5zqu3SAfBCg5ZfzISF" +
       "4NdvA8rDRXFvVHnYCk+OHhwfTT0PzsF9rzSEEkCM/Aic/NUB56wvnFrBWy7v" +
       "dQzh07eKO4MhFlvFEfl+pmj+ycQNhsC3GIJLkaTbXtp1JXsXWuHJwJKPx4vi" +
       "kajyGqlozrW9K56PSwdvegWwlgc/ngaifW4/dv/7ymE9mplOkq2L0cXYm8rh" +
       "UU5xcFiaSinzO29jbLWieEdUfDxUnO7WTs9zgIe84xYQk27ZO7Jk+8yAErqn" +
       "Xil0KBCS2o/d/75qFvlShnOM4JHT7U8NHcP5cyVaP3sbJIv0/aAdVV5/Bsky" +
       "rwQZcPk91gF6ClPnlUa1twF4VkcwrV5txy2N5+CwFIu+jcijohhEletnjWdi" +
       "qxei1EserHipvOcRIORRKnz1ZafCl8/YZ8UQbtO2KopZVLkrKI8qXwgU3C0T" +
       "mKL6b15WqpJFlRs/zvGz4rzrIy/67nD/rZzyqReu3/3GFxb/qfyi5eR7tnuY" +
       "yt16bNtnj4ifub8L5Be6VcJ0z/7AeHk66kCKKo/e+qwcwGR/U9r2e/ZDVDBt" +
       "XTIkAs8/uj3b24gq9572jipXlHPN66hy7agZrEhAebbRAVWgsbh1S0vYZfsJ" +
       "+ZGzhlSmEA+9lP2dDDn7+cvFo6OjeP8d6E3l0y9Q41/+TvN395/fgIk+zwsq" +
       "dzOVa/svgUqixUryyVtSO6Z1F/HUDx74g3vefrzqfWDP8KlRn+Ht8cu/dek7" +
       "flR+nZL/izf+s3f9oxe+Vp6l+r+4xwJAnjsAAA==");
}
