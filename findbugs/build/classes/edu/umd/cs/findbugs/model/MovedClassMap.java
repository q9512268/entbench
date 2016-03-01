package edu.umd.cs.findbugs.model;
public class MovedClassMap implements edu.umd.cs.findbugs.model.ClassNameRewriter {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "movedClasses.debug");
    private final edu.umd.cs.findbugs.BugCollection before;
    private final edu.umd.cs.findbugs.BugCollection after;
    private final java.util.Map<java.lang.String,java.lang.String> rewriteMap;
    public MovedClassMap(edu.umd.cs.findbugs.BugCollection before, edu.umd.cs.findbugs.BugCollection after) {
        super(
          );
        this.
          before =
          before;
        this.
          after =
          after;
        this.
          rewriteMap =
          new java.util.HashMap<java.lang.String,java.lang.String>(
            );
    }
    public edu.umd.cs.findbugs.model.MovedClassMap execute() { java.util.Set<java.lang.String> beforeClasses =
                                                                 buildClassSet(
                                                                   before);
                                                               java.util.Set<java.lang.String> afterClasses =
                                                                 buildClassSet(
                                                                   after);
                                                               java.util.Set<java.lang.String> removedClasses =
                                                                 new java.util.HashSet<java.lang.String>(
                                                                 beforeClasses);
                                                               removedClasses.
                                                                 removeAll(
                                                                   afterClasses);
                                                               java.util.Set<java.lang.String> addedClasses =
                                                                 new java.util.HashSet<java.lang.String>(
                                                                 afterClasses);
                                                               addedClasses.
                                                                 removeAll(
                                                                   beforeClasses);
                                                               java.util.Map<java.lang.String,java.lang.String> removedShortNameToFullNameMap =
                                                                 buildShortNameToFullNameMap(
                                                                   removedClasses);
                                                               for (java.lang.String fullAddedName
                                                                     :
                                                                     addedClasses) {
                                                                   java.lang.String shortAddedName =
                                                                     getShortClassName(
                                                                       fullAddedName);
                                                                   java.lang.String fullRemovedName =
                                                                     removedShortNameToFullNameMap.
                                                                     get(
                                                                       shortAddedName);
                                                                   if (fullRemovedName !=
                                                                         null) {
                                                                       if (DEBUG) {
                                                                           java.lang.System.
                                                                             err.
                                                                             println(
                                                                               fullAddedName +
                                                                               " --> " +
                                                                               fullRemovedName);
                                                                       }
                                                                       rewriteMap.
                                                                         put(
                                                                           fullAddedName,
                                                                           fullRemovedName);
                                                                   }
                                                               }
                                                               return this;
    }
    public boolean isEmpty() { return rewriteMap.
                                 isEmpty(
                                   ); }
    @java.lang.Override
    public java.lang.String rewriteClassName(java.lang.String className) {
        java.lang.String rewrittenClassName =
          rewriteMap.
          get(
            className);
        if (rewrittenClassName !=
              null) {
            className =
              rewrittenClassName;
        }
        return className;
    }
    private java.util.Set<java.lang.String> buildClassSet(edu.umd.cs.findbugs.BugCollection bugCollection) {
        java.util.Set<java.lang.String> classSet =
          new java.util.HashSet<java.lang.String>(
          );
        for (java.util.Iterator<edu.umd.cs.findbugs.BugInstance> i =
               bugCollection.
               iterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.BugInstance warning =
              i.
              next(
                );
            for (java.util.Iterator<edu.umd.cs.findbugs.BugAnnotation> j =
                   warning.
                   annotationIterator(
                     );
                 j.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.BugAnnotation annotation =
                  j.
                  next(
                    );
                if (!(annotation instanceof edu.umd.cs.findbugs.ClassAnnotation)) {
                    continue;
                }
                classSet.
                  add(
                    ((edu.umd.cs.findbugs.ClassAnnotation)
                       annotation).
                      getClassName(
                        ));
            }
        }
        return classSet;
    }
    private java.util.Map<java.lang.String,java.lang.String> buildShortNameToFullNameMap(java.util.Set<java.lang.String> classSet) {
        java.util.Map<java.lang.String,java.lang.String> result =
          new java.util.HashMap<java.lang.String,java.lang.String>(
          );
        for (java.lang.String className
              :
              classSet) {
            java.lang.String shortClassName =
              getShortClassName(
                className);
            result.
              put(
                shortClassName,
                className);
        }
        return result;
    }
    private java.lang.String getShortClassName(java.lang.String className) {
        int lastDot =
          className.
          lastIndexOf(
            '.');
        if (lastDot >=
              0) {
            className =
              className.
                substring(
                  lastDot +
                    1);
        }
        return className.
          toLowerCase(
            java.util.Locale.
              US).
          replace(
            '+',
            '$');
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PF7lwGNe6Fv8Fd+W/Q+fsGBCdiUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DXTjzJfpUI+T0ONPXWG+4/QV5pOgdA6l");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0Tl7a3Ms79dozrlSc/b6cpf798/fZeyfF9UrceWSnulqEutntOtzr/dd8uR6" +
       "ZcfLR6Q9WnQ+Dop0SJr0oyft1buM/dui+k1AmhnhbhDvip/sMWn/6ocgrbxr" +
       "exqUm4ek3fzRkHbueMLz5YSv3IW+3y2qL8aVq4e3dEeGWIIfE/ql04Q+cETo" +
       "kXU/cuKyIdXD0NT0uziV1+VO8SCo8gwot+4+3DfKHfz1uLN/dPJf7sKdPy6q" +
       "P4grDyqJ6ezfkM30/TPX9Ru5FwJAd7seBMNF5zfKodN3cedKrh0cMTr5Qbct" +
       "wMpLnW+UlzrlddHtL3WOhf6HP4R2P1l03gDlY4fy+9iPXH5fLyf85V3k952i" +
       "+h9x5cdK+c3WfhgXus37ROI4RevwYtY+pvl//rDO6hooLx7S/OKPnOa9RX/v" +
       "zjSfK6f9NYj8Kz0uKb6TSX/3jVCaAYU99ZCyuMx/7DUvtfevi9XfeOnKvW99" +
       "af6H5VvCoxfA99GVew3A+JOvck60Lwahbpglffft3+iUWnvu3rjytjtmDnHl" +
       "Qvm/QPjcpT3A/cAIbgMQg90PmydnPxRXLh/PjisH6qnhh4uwth+OK+dBfXLw" +
       "TaALDBbNNwd7izp3B1t65PW4fQRy8tnh2Yt8Jtm/m7+pvvISxf7Mt9u/un/2" +
       "CKw8z4tV7qUrl/YvMI/Sk6fuuNqttS6Sz373oc/d98ytVOqhPcLHynoCt3fe" +
       "/o1hGRyLhwj5v3zr59//j1/6Wnkf+v8AsUIFC84wAAA=");
}
