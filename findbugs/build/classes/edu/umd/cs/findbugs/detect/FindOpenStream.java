package edu.umd.cs.findbugs.detect;
public final class FindOpenStream extends edu.umd.cs.findbugs.ResourceTrackingDetector<edu.umd.cs.findbugs.detect.Stream,edu.umd.cs.findbugs.detect.StreamResourceTracker> implements edu.umd.cs.findbugs.StatelessDetector {
    static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.getBoolean(
                                                                        "fos.debug");
    static final boolean IGNORE_WRAPPED_UNINTERESTING_STREAMS = !edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fos.allowWUS");
    static final org.apache.bcel.generic.ObjectType[] streamBaseList =
      { edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.io.InputStream"),
    edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.io.OutputStream"),
    edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.util.zip.ZipFile"),
    edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.io.Reader"),
    edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.io.Writer"),
    edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.sql.Connection"),
    edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.sql.Statement"),
    edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.sql.ResultSet") };
    static final edu.umd.cs.findbugs.detect.StreamFactory[]
      streamFactoryList;
    static { java.util.ArrayList<edu.umd.cs.findbugs.detect.StreamFactory> streamFactoryCollection =
               new java.util.ArrayList<edu.umd.cs.findbugs.detect.StreamFactory>(
               );
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.IOStreamFactory(
                                         "java.io.InputStream",
                                         new java.lang.String[] { "java.io.ByteArrayInputStream",
                                         "java.io.StringBufferInputStream",
                                         "java.io.PipedInputStream" },
                                         "OS_OPEN_STREAM"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.IOStreamFactory(
                                         "java.io.OutputStream",
                                         new java.lang.String[] { "java.io.ByteArrayOutputStream",
                                         "java.io.PipedOutputStream" },
                                         "OS_OPEN_STREAM"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.IOStreamFactory(
                                         "java.io.Reader",
                                         new java.lang.String[] { "java.io.StringReader",
                                         "java.io.CharArrayReader",
                                         "java.io.PipedReader" },
                                         "OS_OPEN_STREAM"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.IOStreamFactory(
                                         "java.io.Writer",
                                         new java.lang.String[] { "java.io.StringWriter",
                                         "java.io.CharArrayWriter",
                                         "java.io.PipedWriter" },
                                         "OS_OPEN_STREAM"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.IOStreamFactory(
                                         "java.util.zip.ZipFile",
                                         new java.lang.String[0],
                                         "OS_OPEN_STREAM"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.lang.Class",
                                         "getResourceAsStream",
                                         "(Ljava/lang/String;)Ljava/io/InputStream;",
                                         "OS_OPEN_STREAM"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.net.Socket",
                                         "getInputStream",
                                         "()Ljava/io/InputStream;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.net.Socket",
                                         "getOutputStream",
                                         "()Ljava/io/OutputStream;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "javax.servlet.ServletRequest",
                                         "getInputStream",
                                         "()Ljavax/servlet/ServletInputStream;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "javax.servlet.ServletRequest",
                                         "getReader",
                                         "()Ljava/io/BufferedReader;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "javax.servlet.ServletResponse",
                                         "getOutputStream",
                                         "()Ljavax/servlet/ServletOutputStream;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "javax.servlet.ServletResponse",
                                         "getWriter",
                                         "()Ljava/io/PrintWriter;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.StaticFieldLoadStreamFactory(
                                         "java.io.InputStream",
                                         "java.lang.System",
                                         "in",
                                         "Ljava/io/InputStream;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.StaticFieldLoadStreamFactory(
                                         "java.io.OutputStream",
                                         "java.lang.System",
                                         "out",
                                         "Ljava/io/PrintStream;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.StaticFieldLoadStreamFactory(
                                         "java.io.OutputStream",
                                         "java.lang.System",
                                         "err",
                                         "Ljava/io/PrintStream;"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.InstanceFieldLoadStreamFactory(
                                         "java.io.InputStream"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.InstanceFieldLoadStreamFactory(
                                         "java.io.Reader"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.InstanceFieldLoadStreamFactory(
                                         "java.io.OutputStream"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.InstanceFieldLoadStreamFactory(
                                         "java.io.Writer"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareStatement",
                                         "(Ljava/lang/String;)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareStatement",
                                         "(Ljava/lang/String;I)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareStatement",
                                         "(Ljava/lang/String;[I)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareStatement",
                                         "(Ljava/lang/String;II)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareStatement",
                                         "(Ljava/lang/String;III)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareStatement",
                                         ("(Ljava/lang/String;[Ljava/lang/String;)Ljava/sql/PreparedSta" +
                                          "tement;"),
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareCall",
                                         "(Ljava/lang/String;)Ljava/sql/CallableStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareCall",
                                         "(Ljava/lang/String;II)Ljava/sql/CallableStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "prepareCall",
                                         "(Ljava/lang/String;III)Ljava/sql/CallableStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.DriverManager",
                                         "getConnection",
                                         "(Ljava/lang/String;)Ljava/sql/Connection;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.DriverManager",
                                         "getConnection",
                                         ("(Ljava/lang/String;Ljava/util/Properties;)Ljava/sql/Connecti" +
                                          "on;"),
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.DriverManager",
                                         "getConnection",
                                         ("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljav" +
                                          "a/sql/Connection;"),
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "javax.sql.DataSource",
                                         "getConnection",
                                         "()Ljava/sql/Connection;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "javax.sql.DataSource",
                                         "getConnection",
                                         "(Ljava/lang/String;Ljava/lang/String;)Ljava/sql/Connection;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         "()Ljava/sql/Statement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         "(II)Ljava/sql/Statement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         "(III)Ljava/sql/Statement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         "(Ljava/lang/String;)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         "(Ljava/lang/String;I)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         "(Ljava/lang/String;II)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         "(Ljava/lang/String;III)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         "(Ljava/lang/String;[I)Ljava/sql/PreparedStatement;",
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryCollection.add(
                                       new edu.umd.cs.findbugs.detect.MethodReturnValueStreamFactory(
                                         "java.sql.Connection",
                                         "createStatement",
                                         ("(Ljava/lang/String;[Ljava/lang/String;)Ljava/sql/PreparedSta" +
                                          "tement;"),
                                         "ODR_OPEN_DATABASE_RESOURCE"));
             streamFactoryList = streamFactoryCollection.
                                   toArray(
                                     new edu.umd.cs.findbugs.detect.StreamFactory[streamFactoryCollection.
                                                                                    size(
                                                                                      )]);
    }
    private static class PotentialOpenStream {
        public final java.lang.String bugType;
        public final int priority;
        public final edu.umd.cs.findbugs.detect.Stream
          stream;
        @java.lang.Override
        public java.lang.String toString() {
            return stream.
              toString(
                );
        }
        public PotentialOpenStream(java.lang.String bugType,
                                   int priority,
                                   edu.umd.cs.findbugs.detect.Stream stream) {
            super(
              );
            this.
              bugType =
              bugType;
            this.
              priority =
              priority;
            this.
              stream =
              stream;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private final java.util.List<edu.umd.cs.findbugs.detect.FindOpenStream.PotentialOpenStream>
      potentialOpenStreamList;
    public FindOpenStream(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          bugReporter);
        this.
          potentialOpenStreamList =
          new java.util.LinkedList<edu.umd.cs.findbugs.detect.FindOpenStream.PotentialOpenStream>(
            );
    }
    @java.lang.Override
    public java.lang.Object clone() { try {
                                          return super.
                                            clone(
                                              );
                                      }
                                      catch (java.lang.CloneNotSupportedException e) {
                                          throw new java.lang.AssertionError(
                                            e);
                                      } }
    private static final java.lang.String[]
      PRESCREEN_CLASS_LIST =
      { "Stream",
    "Reader",
    "Writer",
    "ZipFile",
    "JarFile",
    "DriverManager",
    "Connection",
    "Statement" };
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass jclass =
          classContext.
          getJavaClass(
            );
        boolean sawResourceClass =
          false;
        for (int i =
               0;
             i <
               jclass.
               getConstantPool(
                 ).
               getLength(
                 );
             ++i) {
            org.apache.bcel.classfile.Constant constant =
              jclass.
              getConstantPool(
                ).
              getConstant(
                i);
            java.lang.String className =
              null;
            if (constant instanceof org.apache.bcel.classfile.ConstantMethodref) {
                org.apache.bcel.classfile.ConstantMethodref cmr =
                  (org.apache.bcel.classfile.ConstantMethodref)
                    constant;
                int classIndex =
                  cmr.
                  getClassIndex(
                    );
                className =
                  jclass.
                    getConstantPool(
                      ).
                    getConstantString(
                      classIndex,
                      org.apache.bcel.Constants.
                        CONSTANT_Class);
            }
            else
                if (constant instanceof org.apache.bcel.classfile.ConstantInterfaceMethodref) {
                    org.apache.bcel.classfile.ConstantInterfaceMethodref cmr =
                      (org.apache.bcel.classfile.ConstantInterfaceMethodref)
                        constant;
                    int classIndex =
                      cmr.
                      getClassIndex(
                        );
                    className =
                      jclass.
                        getConstantPool(
                          ).
                        getConstantString(
                          classIndex,
                          org.apache.bcel.Constants.
                            CONSTANT_Class);
                }
            if (className !=
                  null) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "FindOpenStream: saw class " +
                        className);
                }
                for (java.lang.String aPRESCREEN_CLASS_LIST
                      :
                      PRESCREEN_CLASS_LIST) {
                    if (className.
                          indexOf(
                            aPRESCREEN_CLASS_LIST) >=
                          0) {
                        sawResourceClass =
                          true;
                        break;
                    }
                }
            }
        }
        if (sawResourceClass) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public boolean prescreen(edu.umd.cs.findbugs.ba.ClassContext classContext,
                             org.apache.bcel.classfile.Method method,
                             boolean mightClose) {
        java.util.BitSet bytecodeSet =
          classContext.
          getBytecodeSet(
            method);
        if (bytecodeSet ==
              null) {
            return false;
        }
        return bytecodeSet.
          get(
            org.apache.bcel.Constants.
              NEW) ||
          bytecodeSet.
          get(
            org.apache.bcel.Constants.
              INVOKEINTERFACE) ||
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
              INVOKEVIRTUAL);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.detect.StreamResourceTracker getResourceTracker(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                                                               org.apache.bcel.classfile.Method method) {
        return new edu.umd.cs.findbugs.detect.StreamResourceTracker(
          streamFactoryList,
          bugReporter);
    }
    public static boolean isMainMethod(org.apache.bcel.classfile.Method method) {
        return method.
          isStatic(
            ) &&
          "main".
          equals(
            method.
              getName(
                )) &&
          "([Ljava/lang/String;)V".
          equals(
            method.
              getSignature(
                ));
    }
    @java.lang.Override
    public void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                              org.apache.bcel.classfile.Method method,
                              edu.umd.cs.findbugs.detect.StreamResourceTracker resourceTracker,
                              edu.umd.cs.findbugs.ResourceCollection<edu.umd.cs.findbugs.detect.Stream> resourceCollection)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        potentialOpenStreamList.
          clear(
            );
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        if (methodGen ==
              null) {
            return;
        }
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        try {
            org.apache.bcel.generic.Type[] parameterTypeList =
              org.apache.bcel.generic.Type.
              getArgumentTypes(
                methodGen.
                  getSignature(
                    ));
            edu.umd.cs.findbugs.ba.Location firstLocation =
              new edu.umd.cs.findbugs.ba.Location(
              cfg.
                getEntry(
                  ).
                getFirstInstruction(
                  ),
              cfg.
                getEntry(
                  ));
            int local =
              methodGen.
              isStatic(
                )
              ? 0
              : 1;
            for (org.apache.bcel.generic.Type type
                  :
                  parameterTypeList) {
                if (type instanceof org.apache.bcel.generic.ObjectType) {
                    org.apache.bcel.generic.ObjectType objectType =
                      (org.apache.bcel.generic.ObjectType)
                        type;
                    for (org.apache.bcel.generic.ObjectType streamBase
                          :
                          streamBaseList) {
                        if (edu.umd.cs.findbugs.ba.Hierarchy.
                              isSubtype(
                                objectType,
                                streamBase)) {
                            edu.umd.cs.findbugs.detect.Stream paramStream =
                              new edu.umd.cs.findbugs.detect.Stream(
                              firstLocation,
                              objectType.
                                getClassName(
                                  ),
                              streamBase.
                                getClassName(
                                  ));
                            paramStream.
                              setIsOpenOnCreation(
                                true);
                            paramStream.
                              setOpenLocation(
                                firstLocation);
                            paramStream.
                              setInstanceParam(
                                local);
                            resourceCollection.
                              addPreexistingResource(
                                paramStream);
                            break;
                        }
                    }
                }
                switch (type.
                          getType(
                            )) {
                    case org.apache.bcel.Constants.
                           T_LONG:
                    case org.apache.bcel.Constants.
                           T_DOUBLE:
                        local +=
                          2;
                        break;
                    default:
                        local +=
                          1;
                        break;
                }
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            bugReporter.
              reportMissingClass(
                e);
        }
        resourceTracker.
          setResourceCollection(
            resourceCollection);
        super.
          analyzeMethod(
            classContext,
            method,
            resourceTracker,
            resourceCollection);
        resourceTracker.
          markTransitiveUninterestingStreamEscapes(
            );
        for (java.util.Iterator<edu.umd.cs.findbugs.detect.Stream> i =
               resourceCollection.
               resourceIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.detect.Stream stream =
              i.
              next(
                );
            edu.umd.cs.findbugs.detect.StreamEquivalenceClass equivalenceClass =
              resourceTracker.
              getStreamEquivalenceClass(
                stream);
            if (stream.
                  isClosed(
                    )) {
                equivalenceClass.
                  setClosed(
                    );
            }
        }
        for (edu.umd.cs.findbugs.detect.FindOpenStream.PotentialOpenStream pos
              :
              potentialOpenStreamList) {
            edu.umd.cs.findbugs.detect.Stream stream =
              pos.
                stream;
            if (stream.
                  isClosed(
                    )) {
                continue;
            }
            if (stream.
                  isUninteresting(
                    )) {
                continue;
            }
            edu.umd.cs.findbugs.ba.Location openLocation =
              stream.
              getOpenLocation(
                );
            if (openLocation ==
                  null) {
                continue;
            }
            if (IGNORE_WRAPPED_UNINTERESTING_STREAMS &&
                  resourceTracker.
                  isUninterestingStreamEscape(
                    stream)) {
                continue;
            }
            java.lang.String sourceFile =
              javaClass.
              getSourceFileName(
                );
            java.lang.String leakClass =
              stream.
              getStreamBase(
                );
            if (isMainMethod(
                  method) &&
                  (leakClass.
                     contains(
                       "InputStream") ||
                     leakClass.
                     contains(
                       "Reader"))) {
                return;
            }
            bugAccumulator.
              accumulateBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  pos.
                    bugType,
                  pos.
                    priority).
                  addClassAndMethod(
                    methodGen,
                    sourceFile).
                  addTypeOfNamedClass(
                    leakClass).
                  describe(
                    edu.umd.cs.findbugs.TypeAnnotation.
                      CLOSEIT_ROLE),
                edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    classContext,
                    methodGen,
                    sourceFile,
                    stream.
                      getLocation(
                        ).
                      getHandle(
                        )));
        }
    }
    @java.lang.Override
    public void inspectResult(edu.umd.cs.findbugs.ba.ClassContext classContext,
                              org.apache.bcel.generic.MethodGen methodGen,
                              edu.umd.cs.findbugs.ba.CFG cfg,
                              edu.umd.cs.findbugs.ba.Dataflow<edu.umd.cs.findbugs.ba.ResourceValueFrame,edu.umd.cs.findbugs.ba.ResourceValueAnalysis<edu.umd.cs.findbugs.detect.Stream>> dataflow,
                              edu.umd.cs.findbugs.detect.Stream stream) {
        if (DEBUG) {
            java.lang.System.
              out.
              printf(
                "Result for %s in %s%n",
                stream,
                methodGen);
            dataflow.
              dumpDataflow(
                dataflow.
                  getAnalysis(
                    ));
        }
        edu.umd.cs.findbugs.ba.ResourceValueFrame exitFrame =
          dataflow.
          getResultFact(
            cfg.
              getExit(
                ));
        int exitStatus =
          exitFrame.
          getStatus(
            );
        if (exitStatus ==
              edu.umd.cs.findbugs.ba.ResourceValueFrame.
                OPEN ||
              exitStatus ==
              edu.umd.cs.findbugs.ba.ResourceValueFrame.
                OPEN_ON_EXCEPTION_PATH) {
            java.lang.String bugType =
              stream.
              getBugType(
                );
            int priority =
              NORMAL_PRIORITY;
            if (exitStatus ==
                  edu.umd.cs.findbugs.ba.ResourceValueFrame.
                    OPEN_ON_EXCEPTION_PATH) {
                bugType +=
                  "_EXCEPTION_PATH";
                priority =
                  LOW_PRIORITY;
            }
            potentialOpenStreamList.
              add(
                new edu.umd.cs.findbugs.detect.FindOpenStream.PotentialOpenStream(
                  bugType,
                  priority,
                  stream));
        }
        else
            if (exitStatus ==
                  edu.umd.cs.findbugs.ba.ResourceValueFrame.
                    CLOSED) {
                stream.
                  setClosed(
                    );
            }
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
       "vVFoBPG07jXriNDDA2gjzPGAh1bwuorU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Oc/E30bPlCWVh8/uii6+9XzjTf+FYf+fA7SfevGRe9/w4uQ/7j/0Ofq6/z62" +
       "cq+Zuu7pT+5OXd8NUhnTLoG/b/8BXlgu9nsu8Tn7OCKp3L2/KKXgH+y7fF9S" +
       "efyCLoCPR5enW380qdx/0jqpXNXOVH8sqdxzWJ1U7gDl6cpPglugsrj8gfCc" +
       "vpZwFrg2DoWsflv19UzeYvvW0ZOX26yvtxzm1vp6WdcCrU+/IjcJHRnS+mko" +
       "Czo/WOrrD53o66cv09dzJNsFBe/lk3z8XJ54Kwf8PYckn9oz/DZlA6cs5+Ec" +
       "bnO6cckAt043Tlm1w04FZJ95Rea4xOm5o4ujc0Hnx0te/MQJLz5zCXt/5KJM" +
       "4snzN6+c+XlsKyuPvVSGe9zl9Kf+578y4tL9f6y5oX3uRWb4/q81f2z/rwY0" +
       "V8nzgsq9bOWe/X89KIkWW/ifupTaEa27e8/95cM/fd9bj56TPryf8Po49j81" +
       "t7dc/F0/5YVJ+Ule/rNv+Ofv/Gcv/na5Y/z/AcVZMgNISAAA");
}
