package edu.umd.cs.findbugs.model;
public class RegenerateClassFeatures {
    private final edu.umd.cs.findbugs.BugCollection bugCollection;
    private final java.lang.String jarFile;
    public RegenerateClassFeatures(edu.umd.cs.findbugs.BugCollection bugCollection,
                                   java.lang.String jarFile) { super(
                                                                 );
                                                               this.
                                                                 bugCollection =
                                                                 bugCollection;
                                                               this.
                                                                 jarFile =
                                                                 jarFile;
    }
    public edu.umd.cs.findbugs.model.RegenerateClassFeatures execute()
          throws java.io.IOException { bugCollection.clearClassFeatures(
                                                       );
                                       java.util.ArrayList<org.apache.bcel.classfile.JavaClass> classList =
                                         new java.util.ArrayList<org.apache.bcel.classfile.JavaClass>(
                                         );
                                       try { java.util.zip.ZipFile zipFile =
                                               new java.util.zip.ZipFile(
                                               jarFile);
                                             java.util.Enumeration<? extends java.util.zip.ZipEntry> entries =
                                               zipFile.
                                               entries(
                                                 );
                                             while (entries.
                                                      hasMoreElements(
                                                        )) {
                                                 java.util.zip.ZipEntry entry =
                                                   entries.
                                                   nextElement(
                                                     );
                                                 if (!entry.
                                                       getName(
                                                         ).
                                                       endsWith(
                                                         ".class")) {
                                                     continue;
                                                 }
                                                 org.apache.bcel.classfile.ClassParser parser =
                                                   new org.apache.bcel.classfile.ClassParser(
                                                   zipFile.
                                                     getInputStream(
                                                       entry),
                                                   entry.
                                                     getName(
                                                       ));
                                                 org.apache.bcel.classfile.JavaClass javaClass =
                                                   parser.
                                                   parse(
                                                     );
                                                 org.apache.bcel.Repository.
                                                   addClass(
                                                     javaClass);
                                                 classList.
                                                   add(
                                                     javaClass);
                                             }
                                       }
                                       catch (java.lang.Exception e) {
                                           
                                       }
                                       for (org.apache.bcel.classfile.JavaClass javaClass
                                             :
                                             classList) {
                                           edu.umd.cs.findbugs.model.ClassFeatureSet classFeatureSet =
                                             new edu.umd.cs.findbugs.model.ClassFeatureSet(
                                             ).
                                             initialize(
                                               javaClass);
                                           bugCollection.
                                             setClassFeatureSet(
                                               classFeatureSet);
                                       }
                                       return this;
    }
    public edu.umd.cs.findbugs.BugCollection getBugCollection() {
        return bugCollection;
    }
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { if (args.
                                             length !=
                                             2) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "Usage: " +
                                               edu.umd.cs.findbugs.model.RegenerateClassFeatures.class.
                                                 getName(
                                                   ) +
                                               " <bug collection> <jar file>");
                                           java.lang.System.
                                             exit(
                                               1);
                                       }
                                       edu.umd.cs.findbugs.SortedBugCollection bugCollection =
                                         new edu.umd.cs.findbugs.SortedBugCollection(
                                         );
                                       bugCollection.
                                         readXML(
                                           args[0]);
                                       new edu.umd.cs.findbugs.model.RegenerateClassFeatures(
                                         bugCollection,
                                         args[1]).
                                         execute(
                                           );
                                       bugCollection.
                                         writeXML(
                                           java.lang.System.
                                             out);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
