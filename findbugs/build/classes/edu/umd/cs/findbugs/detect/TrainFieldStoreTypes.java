package edu.umd.cs.findbugs.detect;
public class TrainFieldStoreTypes implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.TrainingDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.ba.type.FieldStoreTypeDatabase database;
    public TrainFieldStoreTypes(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          database =
          new edu.umd.cs.findbugs.ba.type.FieldStoreTypeDatabase(
            );
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.Method[] methodList =
          classContext.
          getJavaClass(
            ).
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
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "Error compting field store types",
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "Error compting field store types",
                    e);
            }
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException { edu.umd.cs.findbugs.ba.CFG cfg =
                                                             classContext.
                                                             getCFG(
                                                               method);
                                                           edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
                                                             classContext.
                                                             getTypeDataflow(
                                                               method);
                                                           org.apache.bcel.generic.ConstantPoolGen cpg =
                                                             classContext.
                                                             getConstantPoolGen(
                                                               );
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
                                                               short opcode =
                                                                 ins.
                                                                 getOpcode(
                                                                   );
                                                               if (opcode !=
                                                                     org.apache.bcel.Constants.
                                                                       PUTFIELD &&
                                                                     opcode !=
                                                                     org.apache.bcel.Constants.
                                                                       PUTSTATIC) {
                                                                   continue;
                                                               }
                                                               org.apache.bcel.generic.FieldInstruction fins =
                                                                 (org.apache.bcel.generic.FieldInstruction)
                                                                   ins;
                                                               org.apache.bcel.generic.Type fieldType =
                                                                 fins.
                                                                 getType(
                                                                   cpg);
                                                               if (!(fieldType instanceof org.apache.bcel.generic.ReferenceType)) {
                                                                   continue;
                                                               }
                                                               edu.umd.cs.findbugs.ba.XField xfield =
                                                                 edu.umd.cs.findbugs.ba.Hierarchy.
                                                                 findXField(
                                                                   fins,
                                                                   cpg);
                                                               if (xfield ==
                                                                     null) {
                                                                   continue;
                                                               }
                                                               if (xfield.
                                                                     isPublic(
                                                                       ) ||
                                                                     xfield.
                                                                     isProtected(
                                                                       )) {
                                                                   continue;
                                                               }
                                                               edu.umd.cs.findbugs.ba.type.TypeFrame frame =
                                                                 typeDataflow.
                                                                 getFactAtLocation(
                                                                   location);
                                                               if (!frame.
                                                                     isValid(
                                                                       )) {
                                                                   continue;
                                                               }
                                                               org.apache.bcel.generic.Type storeType =
                                                                 frame.
                                                                 getTopValue(
                                                                   );
                                                               if (!(storeType instanceof org.apache.bcel.generic.ReferenceType)) {
                                                                   continue;
                                                               }
                                                               edu.umd.cs.findbugs.ba.type.FieldStoreType property =
                                                                 database.
                                                                 getProperty(
                                                                   xfield.
                                                                     getFieldDescriptor(
                                                                       ));
                                                               if (property ==
                                                                     null) {
                                                                   property =
                                                                     new edu.umd.cs.findbugs.ba.type.FieldStoreType(
                                                                       );
                                                                   database.
                                                                     setProperty(
                                                                       xfield.
                                                                         getFieldDescriptor(
                                                                           ),
                                                                       property);
                                                               }
                                                               property.
                                                                 addTypeSignature(
                                                                   storeType.
                                                                     getSignature(
                                                                       ));
                                                           }
    }
    @java.lang.Override
    public void report() { database.purgeBoringEntries(
                                      );
                           edu.umd.cs.findbugs.ba.AnalysisContext.
                             currentAnalysisContext(
                               ).
                             <edu.umd.cs.findbugs.ba.type.FieldStoreTypeDatabase,
                           edu.umd.cs.findbugs.classfile.FieldDescriptor,
                           edu.umd.cs.findbugs.ba.type.FieldStoreType>
                           storePropertyDatabase(
                             database,
                             edu.umd.cs.findbugs.ba.type.FieldStoreTypeDatabase.
                               DEFAULT_FILENAME,
                             "store type database");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cxJoc0Y9dRH+eVVIuyK62Fz7D9cBlztXGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rNb4QgkbatNaonGUR3pgbSya5NctfCxwJk9x69ncrW6CmZeMjb7oj9BqR8RF" +
       "srCSHXpaUbRpKpZpv24JazUqqHM/3KS1MkdgXDEoRh2vGY/99YZOBi5AgAnw" +
       "5g7NYzV40xmHMIG4XE2eV2u1Gq+qOhMIAQ+T5eXEXtbWExaBS/NmWpbIAcbq" +
       "xXYbabqStOYHvXLE10kHbfd9mpsrfLWrKOS4P5orZmGwCKtMa+FvsKru1Rs2" +
       "PTXcml0LUwbbOFjiFJmUa+COzDXlaNIvTwsI7wBflseFNlMm65FllyNDMKdc" +
       "wVELJskWwWsFvmEYs5rgwoLbJDyLhjIa1igvZsTxgMJ8hVgUi97anxrkWuEY" +
       "lFATe6AZjASOAVJxUZfHREHhODLa9CoInlbbdalppuG8Gzca2aun++re/m/P" +
       "Ex0HN4vgpT/reOureOvddj2cFa87SCfln7Mnb6OOJq4Ps5Q7+0mV+07LD7Xz" +
       "W5m961Uw6NJpg/I7G93W9gdnuYH7r3UFmecFPv7Us8/LzCdKO3v5YiOEbgJH" +
       "i58xlbViHhHuOsDp8WvnQPr5DexhHvPLT/3jvdM3Ld/+Km5xHjwh50mWv9V/" +
       "4avd10sf3IGuO8hqXnU3fJzo8vFc5nlfCSPfnh7LaN5//CblCfB09taqczL1" +
       "d+gNV/nVmdyvtt50Ih1/IqX/6DWyf/m67F3P53ze/zJp/aez4t3Abdd6oIdH" +
       "SfPh6hFnXYXQ9WtHlw+9+D3HvfiWAy8+kPGOwyQbs1Z8X5eVl3H8q5PvecNT" +
       "B5a9JWskwMPtWZZ7tZbtnGrZncOU6wf2RX/I8bVdwRWkpbIrSoq5m//JIrs7" +
       "3vOonNPzp3PaZ/L4tdYI7zYjPbtW7SSS4h54NCApXoMky+CqphM3bMHcBHpw" +
       "QJjL8etZ8ZEQulXIulNlK2LW+Mzhev3aK+XaXsb0uVPfA54P7pn+g/83Tn3U" +
       "GT/7Mn2fy4rfDqGzfp6fP6HZC9f0xKz5uVflc0kIvea0O+vsAu6eq/4ss/2D" +
       "h/Tp5y/cePfz7F/k17YHf8K4iYZuVCPTPHoPcqR+1vUVVc/Vu2l7K+LmX38Q" +
       "Qvde+0Id2GBbySX//S3JF0LozlNIQjD/XvXo6BdD6Pzh6BDakY51fzGEzu11" +
       "h9B1oDza+SXQBDqz6pfdU9L32wuj5MwRzN9zpnyl7nglHzwgOXrvm+0T+d+Z" +
       "9jE92v6h6Yr0meepwTteqnxie+8MYjRNMy430tC57RX4wb7w8DW57fM6Szz2" +
       "o9s+e9Pr9vew27YCHzr2EdkePP2St2O5YX4tm/7e3b/zxG88/638NuG/AfSA" +
       "jJ1nJgAA");
}
