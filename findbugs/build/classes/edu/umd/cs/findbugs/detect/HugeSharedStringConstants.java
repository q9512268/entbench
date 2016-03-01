package edu.umd.cs.findbugs.detect;
public class HugeSharedStringConstants extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    private static final int SIZE_OF_HUGE_CONSTANT = 500;
    java.lang.String getStringKey(java.lang.String s) { return s.length() +
                                                        ":" +
                                                        s.
                                                          hashCode(
                                                            ); }
    java.util.HashMap<java.lang.String,java.util.SortedSet<java.lang.String>>
      map =
      new java.util.HashMap<java.lang.String,java.util.SortedSet<java.lang.String>>(
      );
    java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.ba.XField>
      definition =
      new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.HashMap<java.lang.String,java.lang.Integer> stringSize =
      new java.util.HashMap<java.lang.String,java.lang.Integer>(
      );
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public HugeSharedStringConstants(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.ConstantString s) {
        java.lang.String value =
          s.
          getBytes(
            getConstantPool(
              ));
        if (value.
              length(
                ) <
              SIZE_OF_HUGE_CONSTANT) {
            return;
        }
        java.lang.String key =
          getStringKey(
            value);
        java.util.SortedSet<java.lang.String> set =
          map.
          get(
            key);
        if (set ==
              null) {
            set =
              new java.util.TreeSet<java.lang.String>(
                );
            map.
              put(
                key,
                set);
        }
        set.
          add(
            getDottedClassName(
              ));
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.ConstantValue s) {
        if (!visitingField(
               )) {
            return;
        }
        int i =
          s.
          getConstantValueIndex(
            );
        org.apache.bcel.classfile.Constant c =
          getConstantPool(
            ).
          getConstant(
            i);
        if (c instanceof org.apache.bcel.classfile.ConstantString) {
            java.lang.String value =
              ((org.apache.bcel.classfile.ConstantString)
                 c).
              getBytes(
                getConstantPool(
                  ));
            if (value.
                  length(
                    ) <
                  SIZE_OF_HUGE_CONSTANT) {
                return;
            }
            java.lang.String key =
              getStringKey(
                value);
            definition.
              put(
                key,
                edu.umd.cs.findbugs.ba.XFactory.
                  createXField(
                    this));
            stringSize.
              put(
                key,
                value.
                  length(
                    ));
        }
    }
    @java.lang.Override
    public void report() { for (java.util.Map.Entry<java.lang.String,java.util.SortedSet<java.lang.String>> e
                                 :
                                 map.
                                  entrySet(
                                    )) { java.util.Set<java.lang.String> occursIn =
                                           e.
                                           getValue(
                                             );
                                         if (occursIn.
                                               size(
                                                 ) ==
                                               1) {
                                             continue;
                                         }
                                         edu.umd.cs.findbugs.ba.XField field =
                                           definition.
                                           get(
                                             e.
                                               getKey(
                                                 ));
                                         if (field ==
                                               null) {
                                             continue;
                                         }
                                         java.lang.Integer length =
                                           stringSize.
                                           get(
                                             e.
                                               getKey(
                                                 ));
                                         int overhead =
                                           length *
                                           (occursIn.
                                              size(
                                                ) -
                                              1);
                                         if (overhead <
                                               3 *
                                               SIZE_OF_HUGE_CONSTANT) {
                                             continue;
                                         }
                                         java.lang.String className =
                                           field.
                                           getClassName(
                                             );
                                         edu.umd.cs.findbugs.BugInstance bug =
                                           new edu.umd.cs.findbugs.BugInstance(
                                           this,
                                           "HSC_HUGE_SHARED_STRING_CONSTANT",
                                           overhead >
                                             20 *
                                             SIZE_OF_HUGE_CONSTANT
                                             ? HIGH_PRIORITY
                                             : (overhead >
                                                  8 *
                                                  SIZE_OF_HUGE_CONSTANT
                                                  ? NORMAL_PRIORITY
                                                  : LOW_PRIORITY)).
                                           addClass(
                                             className).
                                           addField(
                                             field).
                                           addInt(
                                             length).
                                           addInt(
                                             occursIn.
                                               size(
                                                 )).
                                           describe(
                                             edu.umd.cs.findbugs.IntAnnotation.
                                               INT_OCCURRENCES);
                                         for (java.lang.String c
                                               :
                                               occursIn) {
                                             if (!c.
                                                   equals(
                                                     className)) {
                                                 bug.
                                                   addClass(
                                                     c);
                                             }
                                         }
                                         bugReporter.
                                           reportBug(
                                             bug);
                           } }
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
       "gyTzTPvZBGi/2j93DHVvPQ9Dp4Y9D0InCwW4L3oX9/efw53HCyt3wfXsYUg+" +
       "ex53ypViP8eFSAcEyPdWenjj9/72y9/5yAudy4Xj370tRAdWeeik3zgp8tS/" +
       "/rlPPfnAi7/78RIYQET8z4IpWg7/dFneLIr3lPN7Ja7c44fmFmQaADyiMu+N" +
       "gU6mK9uHIPJn4HcJXN8rrkLSomKfKNzoH2YrTx2nKz5YIN/ME8vhLRa7hYuj" +
       "4a0+O+YFdCy8uidxoekAmNweJm7w8ze+bn3mG7+4T8rOu825zvrHXvypPzv4" +
       "xIuXT6XC77wtGz1Ns0+Hy3l5U1FQRSA+/WqjlBTYf/388//47z7/wl6qG2cT" +
       "uyHYt/ziv/vTXzv49O9++Q5ZwxWQtO/Xk6JsFkVvb2Hkwqh8/1kYn4Grfugz" +
       "9dt8plLeSHee5z2kUUAMRy5w9X0XzwSfKFF8Kvn+afOlX/+Xf3z9I3ulz05h" +
       "uf86JD1P99XfvlJ/IL75M+X6eJciR6Ut7gURExU948pTF+/lSl77+XngxAsr" +
       "d/bCR0/g9RAMD8rdou9nR4vB7XhZNKhnJv3OhrilEs4t/gtffaFdzun1rQlW" +
       "c10TDreYZ1evk4zuuTPbzjua6pb6jc//9Jee/ubskXI/sbdKIVYLrHzF386h" +
       "X1wp/aKYxctA4HddIPChROVie0v90c9879d///mvfflK5SrIgwogK3JSgCOV" +
       "g4u24acZ3BTA3QBQAYB7cE9dJLOFVQ8n8cZx7XFKF1d+8CLeZYCfy/yKjazt" +
       "pXrY8xJXKzH+LIDen/j+6dbSHa59P+7wYyBVeR3mO9b+MNYqN0rXf/AEaItY" +
       "P90I4vuRPo3y/C1hwQ1vzdApgfboYelkBSJemh154im03i80ex/90Guq9fip" +
       "xLJIYDSwqt3m56fSpeNORdOu7KCfcatLpVtdPs6ZNt+fCAVxuVLvSoVL3ZPs" +
       "DmrvN0ZnsozK/mFTFO4Jp73pqD2novzoOapzeLp4g3g6AlfzcBabF+DpT70G" +
       "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" +
       "JF5ZEHkoqAOiwVJs21vHKwGbTDRrB+lB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("JFAqOtTTJZim1O/TU89QeuOEnXYVP2nMm2GTapNm7hqdDYIOeAhT2g0YXcSJ" +
       "TggjcoKixWuhL76x11UPl6/ajo/V/Tlesu2bni6Kdx2/jyx/VyvnjmKdeh95" +
       "9m15WHnyotNy5YfKlz/64ksa+9na5cMXlXxcuS/2/B+09a1un2J116t/CmTK" +
       "w4In39h/9aPffEL4ofWH38AJo7efk/M8y7/HfO7Lo3erf+Ny5crxF/fbjjGe" +
       "JXru3GeiUI+T0BXOfG1/8uwpn0fBdXBo2YPzb3pP5u6i17znTokcnjTZv5Eu" +
       "yn/zKsdI/m1R/EZcubbS4/2nD0rPS9ITd/lXr/UC8zTTsuIrZ/UrvOUDh/p9" +
       "4A3oV+rw3ldT8uit/Hu9cHUg+7K61g8UVbf3332Kc4YHR8cqDj/sFARffxWD" +
       "/Kei+J24cnf5KfWO73i3nqmdWOc/nLXOtWPrHAt349RHta0ehqamv0r8vT6T" +
       "vhtc40OTjv+fmPQ9r23S2fEr9j96FYt+pyj++5FFi4f/cmK9/3Gh9Yrqb37f" +
       "dnoMXPKhneS/GDud0u3S5Vdpu6uo/NO4cjUsP8CcU/x7f4GKZ3Hl8QuPdhbn" +
       "KR677Yj5/li0+ksvXb/30ZfEf1+ebjw+unwfXbnXSGz79HGhU/dX/VA3zNI2" +
       "9+0PD5XfVy9diytPXHz4FBhif1OIf+mBPcn1uPLIHUhiMP7h7eneN+LK/Se9" +
       "48pl9UwzcNp7DpvjyhVQnm58DFSBxuL2cf/Ix5+94ym8HEjpaTqvgiUEWHJQ" +
       "Su2F2aXbvwmXU3njtfDx1ML4zgtPXTDJ/l8Ebqmff4kc/8i325/dH90EYbfb" +
       "FVzupSv37E+RHi9fT1/I7YjXVfyZ7z74y/e962ipfXAv8Innn5Lt7Xc+Jzl0" +
       "/Lg82bj7R4/+g/f/nZe+Vp7c+r/nIFa6uTEAAA==");
}
