package edu.umd.cs.findbugs.ba;
public class DefaultNullnessAnnotations {
    public static final boolean ICSE10_NULLNESS_PAPER = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "icse10");
    public static void addDefaultNullnessAnnotations(edu.umd.cs.findbugs.ba.INullnessAnnotationDatabase database) {
        if (edu.umd.cs.findbugs.ba.AnnotationDatabase.
              IGNORE_BUILTIN_ANNOTATIONS) {
            return;
        }
        boolean missingClassWarningsSuppressed =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          setMissingClassWarningsSuppressed(
            true);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              METHOD,
            "java.lang.String",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addFieldAnnotation(
            "java.lang.System",
            "out",
            "Ljava/io/PrintStream;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addFieldAnnotation(
            "java.lang.System",
            "err",
            "Ljava/io/PrintStream;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addFieldAnnotation(
            "java.lang.System",
            "in",
            "Ljava/io/InputStream;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addFieldAnnotation(
            "java.math.BigInteger",
            "ZERO",
            "Ljava/math/BigInteger;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addFieldAnnotation(
            "java.math.BigInteger",
            "ONE",
            "Ljava/math/BigInteger;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addFieldAnnotation(
            "java.math.BigInteger",
            "TEN",
            "Ljava/math/BigInteger;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.nio.file.Files",
            "probeContentType",
            "(Ljava/nio/file/Path;)Ljava/lang/String;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.nio.file.Path",
            "getRoot",
            "()Ljava/nio/file/Path;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.nio.file.Path",
            "getFileName",
            "()Ljava/nio/file/Path;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.nio.file.Path",
            "getParent",
            "()Ljava/nio/file/Path;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.io.File",
            "list",
            "()[Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.io.File",
            "list",
            "(Ljava/io/FilenameFilter;)[Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.io.File",
            "listFiles",
            "()[Ljava/io/File;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.io.File",
            "listFiles",
            "(Ljava/io/FilenameFilter;)[Ljava/io/File;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.io.File",
            "listFiles",
            "(Ljava/io/FileFilter;)[Ljava/io/File;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.lang.ref.ReferenceQueue",
            "poll",
            "()Ljava/lang/ref/Reference;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.lang.ref.Reference",
            "get",
            "()Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.lang.Class",
            "newInstance",
            "()Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.lang.Class",
            "forName",
            "(Ljava/lang/String;)Ljava/lang/Class;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.lang.reflect.Method",
            "getParameterTypes",
            "()[Ljava/lang/Class;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.lang.Object",
            "clone",
            "()Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.lang.Object",
            "toString",
            "()Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.lang.Object",
            "getClass",
            "()Ljava/lang/Class;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.lang.Object",
            "equals",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Arrays",
            "asList",
            "([Ljava/lang/Object;)Ljava/util/List;",
            true,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.lang.Integer",
            "<init>",
            "(Ljava/lang/String;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.lang.Integer",
            "parseInt",
            "(Ljava/lang/String;I)I",
            true,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.lang.Integer",
            "parseInt",
            "(Ljava/lang/String;)I",
            true,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.nio.channels.SocketChannel",
            "open",
            "()Ljava/nio/channels/SocketChannel;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.sql.Statement",
            "executeQuery",
            "(Ljava/lang/String;)Ljava/sql/ResultSet;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.sql.PreparedStatement",
            "executeQuery",
            "()Ljava/sql/ResultSet;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.sql.Connection",
            "prepareStatement",
            "(Ljava/lang/String;)Ljava/sql/PreparedStatement;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              METHOD,
            "java.sql.DatabaseMetaData",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.sql.DatabaseMetaData",
            "getConnection",
            "()Ljava/sql/Connection;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodAnnotation(
            "java.sql.DatabaseMetaData",
            "getAttributes",
            ("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava" +
             "/lang/String;)Ljava/sql/ResultSet;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodAnnotation(
            "java.sql.DatabaseMetaData",
            "getColumns",
            ("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava" +
             "/lang/String;)Ljava/sql/ResultSet;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodAnnotation(
            "java.sql.DatabaseMetaData",
            "getSuperTables",
            ("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljav" +
             "a/sql/ResultSet;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodAnnotation(
            "java.sql.DatabaseMetaData",
            "getSuperTypes",
            ("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljav" +
             "a/sql/ResultSet;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodAnnotation(
            "java.sql.DatabaseMetaData",
            "getTimeDateFunctions",
            "()Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodAnnotation(
            "java.sql.DatabaseMetaData",
            "getTypeInfo",
            "()Ljava/sql/ResultSet;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodAnnotation(
            "java.sql.DatabaseMetaData",
            "getURL",
            "()Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.package-info",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.CopyOnWriteArrayList",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.CopyOnWriteArraySet",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.ConcurrentLinkedQueue$Node",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.Exchanger",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.FutureTask",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.LinkedBlockingQueue$Node",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            ("java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFu" +
             "tureTask"),
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.SynchronousQueue$WaitQueue",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.SynchronousQueue$Node",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.ThreadPoolExecutor$Worker",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.AbstractExecutorService",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            ("java.util.concurrent.ConcurrentSkipListMap$ConcurrentSkipLis" +
             "tSubMap"),
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.ConcurrentSkipListMap$HeadIndex",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.ConcurrentSkipListMap$Index",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.ConcurrentSkipListMap$Node",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.ConcurrentSkipListMap$SubMap",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            ("java.util.concurrent.ConcurrentSkipListSet$ConcurrentSkipLis" +
             "tSubSet"),
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.LinkedBlockingDeque$Node",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.SynchronousQueue$TransferQueue",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.SynchronousQueue$TransferQueue$QNode",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.SynchronousQueue$TransferStack",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.SynchronousQueue$Transferer",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentMap",
            "containsKey",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentMap",
            "containsValue",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentMap",
            "get",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentMap",
            "remove",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentMap",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentMap",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentHashMap",
            "remove",
            "(Ljava/lang/Object;Ljava/lang/Object;)Z",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentHashMap",
            "setEntryAt",
            ("([Ljava/util/concurrent/ConcurrentHashMap$HashEntry;ILjava/u" +
             "til/concurrent/ConcurrentHashMap$HashEntry;)V"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinPool",
            "<init>",
            ("(ILjava/util/concurrent/ForkJoinPool$ForkJoinWorkerThreadFac" +
             "tory;Ljava/lang/Thread$UncaughtExceptionHandler;Z)V"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.PriorityBlockingQueue",
            "<init>",
            "(ILjava/util/Comparator;)V",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addDefaultAnnotation(
            edu.umd.cs.findbugs.ba.AnnotationDatabase.Target.
              PARAMETER,
            "java.util.concurrent.ConcurrentLinkedDeque$Node",
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              UNKNOWN_NULLNESS);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentMap",
            "remove",
            "(Ljava/lang/Object;Ljava/lang/Object;)Z",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NULLABLE);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.FutureTask",
            "<init>",
            "(Ljava/lang/Runnable;Ljava/lang/Object;)V",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.Executors",
            "callable",
            ("(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurren" +
             "t/Callable;"),
            true,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ThreadPoolExecutor",
            "addWorker",
            "(Ljava/lang/Runnable;Z)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentHashMap$Segment",
            "remove",
            "(Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;",
            false,
            2,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.CyclicBarrier",
            "<init>",
            "(ILjava/lang/Runnable;)V",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.BrokenBarrierException",
            "<init>",
            "(Ljava/lang/String;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.CancellationException",
            "<init>",
            "(Ljava/lang/String;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ExecutionException",
            "<init>",
            "(Ljava/lang/String;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ExecutionException",
            "<init>",
            "(Ljava/lang/String;Ljava/lang/Throwable;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ExecutionException",
            "<init>",
            "(Ljava/lang/String;Ljava/lang/Throwable;)V",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ExecutionException",
            "<init>",
            "(Ljava/lang/Throwable;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.RejectedExecutionException",
            "<init>",
            "(Ljava/lang/String;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.RejectedExecutionException",
            "<init>",
            "(Ljava/lang/String;Ljava/lang/Throwable;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.RejectedExecutionException",
            "<init>",
            "(Ljava/lang/String;Ljava/lang/Throwable;)V",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.RejectedExecutionException",
            "<init>",
            "(Ljava/lang/Throwable;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.TimeoutException",
            "<init>",
            "(Ljava/lang/String;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.Executors$RunnableAdapter",
            "<init>",
            "(Ljava/lang/Runnable;Ljava/lang/Object;)V",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentSkipListMap",
            "<init>",
            "(Ljava/util/Comparator;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ConcurrentSkipListMap",
            "doRemove",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinPool",
            "casBarrierStack",
            ("(Ljava/util/concurrent/ForkJoinPool$WaitQueueNode;Ljava/util" +
             "/concurrent/ForkJoinPool$WaitQueueNode;)Z"),
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinPool",
            "casBarrierStack",
            ("(Ljava/util/concurrent/ForkJoinPool$WaitQueueNode;Ljava/util" +
             "/concurrent/ForkJoinPool$WaitQueueNode;)Z"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinPool",
            "casSpareStack",
            ("(Ljava/util/concurrent/ForkJoinPool$WaitQueueNode;Ljava/util" +
             "/concurrent/ForkJoinPool$WaitQueueNode;)Z"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinTask",
            "adapt",
            ("(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurren" +
             "t/ForkJoinTask;"),
            true,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinTask",
            "awaitDone",
            "(Ljava/util/concurrent/ForkJoinWorkerThread;J)I",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinTask",
            "awaitDone",
            "(Ljava/util/concurrent/ForkJoinWorkerThread;Z)I",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinTask$AdaptedRunnable",
            "<init>",
            "(Ljava/lang/Runnable;Ljava/lang/Object;)V",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinWorkerThread",
            "onTermination",
            "(Ljava/lang/Throwable;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ForkJoinWorkerThread",
            "setSlot",
            ("([Ljava/util/concurrent/ForkJoinTask;ILjava/util/concurrent/" +
             "ForkJoinTask;)V"),
            true,
            2,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.LinkedTransferQueue",
            "casCleanMe",
            ("(Ljava/util/concurrent/LinkedTransferQueue$Node;Ljava/util/c" +
             "oncurrent/LinkedTransferQueue$Node;)Z"),
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.LinkedTransferQueue",
            "casCleanMe",
            ("(Ljava/util/concurrent/LinkedTransferQueue$Node;Ljava/util/c" +
             "oncurrent/LinkedTransferQueue$Node;)Z"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.LinkedTransferQueue",
            "casHead",
            ("(Ljava/util/concurrent/LinkedTransferQueue$Node;Ljava/util/c" +
             "oncurrent/LinkedTransferQueue$Node;)Z"),
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.LinkedTransferQueue",
            "xfer",
            "(Ljava/lang/Object;ZIJ)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.LinkedTransferQueue$Itr",
            "advance",
            "(Ljava/util/concurrent/LinkedTransferQueue$Node;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.LinkedTransferQueue$Node",
            "casItem",
            "(Ljava/lang/Object;Ljava/lang/Object;)Z",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.LinkedTransferQueue$Node",
            "casNext",
            ("(Ljava/util/concurrent/LinkedTransferQueue$Node;Ljava/util/c" +
             "oncurrent/LinkedTransferQueue$Node;)Z"),
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.Phaser",
            "<init>",
            "(Ljava/util/concurrent/Phaser;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.Phaser",
            "<init>",
            "(Ljava/util/concurrent/Phaser;I)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodAnnotation(
            "java.util.concurrent.locks.ReadWriteLock",
            "readLock",
            "()Ljava/util/concurrent/locks/Lock;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.util.concurrent.locks.ReadWriteLock",
            "writeLock",
            "()Ljava/util/concurrent/locks/Lock;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.util.concurrent.locks.ReentrantReadWriteLock",
            "readLock",
            ("()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLoc" +
             "k;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.util.concurrent.locks.ReentrantReadWriteLock",
            "writeLock",
            ("()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLo" +
             "ck;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ExecutorService",
            "submit",
            ("(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurren" +
             "t/Future;"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.AbstractExecutorService",
            "submit",
            ("(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurren" +
             "t/Future;"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ExecutorCompletionService",
            "submit",
            ("(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurren" +
             "t/Future;"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            ("java.util.concurrent.AbstractExecutorServiceNullnessAnnotati" +
             "onDatabase"),
            "newTaskFor",
            ("(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurren" +
             "t/Future;"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ExecutorCompletionService",
            "newTaskFor",
            ("(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurren" +
             "t/RunnableFuture;"),
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ThreadPoolExecutor",
            "addIfUnderCorePoolSize",
            "(Ljava/lang/Runnable;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ThreadPoolExecutor",
            "addThread",
            "(Ljava/lang/Runnable;)Ljava/lang/Thread;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.concurrent.ThreadPoolExecutor",
            "afterExecute",
            "(Ljava/lang/Runnable;Ljava/lang/Throwable;)V",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.EnumMap",
            "get",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.EnumMap",
            "containsKey",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.EnumMap",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.EnumMap",
            "remove",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.SortedMap",
            "get",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.SortedMap",
            "containsKey",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.SortedMap",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.SortedMap",
            "remove",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.SortedSet",
            "add",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.SortedSet",
            "remove",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.SortedSet",
            "contains",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Hashtable",
            "get",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Hashtable",
            "containsKey",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Hashtable",
            "containsValue",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Hashtable",
            "contains",
            "(Ljava/lang/Object;)Z",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Hashtable",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Hashtable",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "javax.swing.UIDefaults",
            "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Properties",
            "getProperty",
            "(Ljava/lang/String;)Ljava/lang/String;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Properties",
            "setProperty",
            "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            false,
            1,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Properties",
            "setProperty",
            "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "org.w3c.dom.Element",
            "setAttribute",
            "(Ljava/lang/String;Ljava/lang/String;)V",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.text.DateFormat",
            "parse",
            ("(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date" +
             ";"),
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.text.DateFormat",
            "parse",
            "(Ljava/lang/String;)Ljava/util/Date;",
            false,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.io.BufferedReader",
            "readLine",
            "()Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        database.
          addMethodParameterAnnotation(
            "com.google.common.base.Preconditions",
            "checkNotNull",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            true,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "com.google.common.base.Preconditions",
            "checkNotNull",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            true,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "com.google.common.base.Preconditions",
            "checkNotNull",
            ("(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Lja" +
             "va/lang/Object;"),
            true,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "com.google.common.base.Preconditions",
            "checkNotNull",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "com.google.common.base.Preconditions",
            "checkNotNull",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "com.google.common.base.Preconditions",
            "checkNotNull",
            ("(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Lja" +
             "va/lang/Object;"),
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Objects",
            "requireNonNull",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            true,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodParameterAnnotation(
            "java.util.Objects",
            "requireNonNull",
            "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;",
            true,
            0,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.util.Objects",
            "requireNonNull",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "java.util.Objects",
            "requireNonNull",
            "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;",
            true,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "org.w3c.dom.Element",
            "getAttribute",
            "(Ljava/lang/String;)Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "org.w3c.dom.Element",
            "getAttributeNS",
            "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "org.w3c.dom.Element",
            "getElementsByTagName",
            "(Ljava/lang/String;)Lorg/w3c/dom/NodeList;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        database.
          addMethodAnnotation(
            "org.w3c.dom.Element",
            "getElementsByTagNameNS",
            "(Ljava/lang/String;Ljava/lang/String;)Lorg/w3c/dom/NodeList;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              NONNULL);
        addEclipseSpecificAnnotations(
          database);
        edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          setMissingClassWarningsSuppressed(
            missingClassWarningsSuppressed);
    }
    private static void addEclipseSpecificAnnotations(edu.umd.cs.findbugs.ba.INullnessAnnotationDatabase db) {
        db.
          addMethodAnnotation(
            "org.eclipse.core.runtime.IAdapterFactory",
            "getAdapter",
            "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.runtime.IAdapterManager",
            "getAdapter",
            "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.runtime.IAdapterManager",
            "getAdapter",
            "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.runtime.IAdapterManager",
            "loadAdapter",
            "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.runtime.FileLocator",
            "find",
            "(Ljava/net/URL;)Ljava/net/URL;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.runtime.FileLocator",
            "find",
            ("(Lorg/osgi/framework/Bundle;Lorg/eclipse/core/runtime/IPath;" +
             "Ljava/util/Map;)Ljava/net/URL;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.osgi.framework.Bundle",
            "getEntry",
            "(Ljava/lang/String;)Ljava/net/URL;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.osgi.framework.Bundle",
            "getEntryPaths",
            "(Ljava/lang/String;)Ljava/util/Enumeration;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.osgi.framework.Bundle",
            "getResource",
            "(Ljava/lang/String;)Ljava/net/URL;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.osgi.framework.Bundle",
            "getResources",
            "(Ljava/lang/String;)Ljava/util/Enumeration;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.osgi.framework.Bundle",
            "getServicesInUse",
            "()[Lorg/osgi/framework/ServiceReference;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IContainer",
            "getDefaultCharset",
            "(Z)Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IFile",
            "getCharset",
            "(Z)Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IFile",
            "getContentDescription",
            "()Lorg/eclipse/core/runtime/content/IContentDescription;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IProject",
            "getNature",
            ("(Ljava/lang/String;)Lorg/eclipse/core/resources/IProjectNatu" +
             "re;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IWorkspaceRoot",
            "getContainerForLocation",
            ("(Lorg/eclipse/core/runtime/IPath;)Lorg/eclipse/core/resource" +
             "s/IContainer;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IWorkspaceRoot",
            "getFileForLocation",
            ("(Lorg/eclipse/core/runtime/IPath;)Lorg/eclipse/core/resource" +
             "s/IFile;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IWorkspaceRoot",
            "getParent",
            "()Lorg/eclipse/core/resources/IContainer;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IResource",
            "findMarker",
            "(J)Lorg/eclipse/core/resources/IMarker;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IResource",
            "getFileExtension",
            "()Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IResource",
            "getPersistentProperty",
            "(Lorg/eclipse/core/runtime/QualifiedName;)Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IResource",
            "getSessionProperty",
            "(Lorg/eclipse/core/runtime/QualifiedName;)Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IResourceDelta",
            "findMember",
            ("(Lorg/eclipse/core/runtime/IPath;)Lorg/eclipse/core/resource" +
             "s/IResourceDelta;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IResourceDelta",
            "getMovedFromPath",
            "()Lorg/eclipse/core/runtime/IPath;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.core.resources.IResourceDelta",
            "getMovedToPath",
            "()Lorg/eclipse/core/runtime/IPath;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.team.core.RepositoryProvider",
            "getProvider",
            ("(Lorg/eclipse/core/resources/IProject;)Lorg/eclipse/team/cor" +
             "e/RepositoryProvider;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.team.core.RepositoryProvider",
            "getProvider",
            ("(Lorg/eclipse/core/resources/IProject;Ljava/lang/String;)Lor" +
             "g/eclipse/team/core/RepositoryProvider;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.swt.widgets.Display",
            "getCurrent",
            "()Lorg/eclipse/swt/widgets/Display;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.ITreeContentProvider",
            "getParent",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.ILazyTreeContentProvider",
            "getParent",
            "(Ljava/lang/Object;)Ljava/lang/Object;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.ILabelProvider",
            "getImage",
            "(Ljava/lang/Object;)Lorg/eclipse/swt/graphics/Image;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.IFontProvider",
            "getFont",
            "(Ljava/lang/Object;)Lorg/eclipse/swt/graphics/Font;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.IColorProvider",
            "getForeground",
            "(Ljava/lang/Object;)Lorg/eclipse/swt/graphics/Color;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.IColorProvider",
            "getBackground",
            "(Ljava/lang/Object;)Lorg/eclipse/swt/graphics/Color;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.IColorDecorator",
            "decorateForeground",
            "(Ljava/lang/Object;)Lorg/eclipse/swt/graphics/Color;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.IColorDecorator",
            "decorateBackground",
            "(Ljava/lang/Object;)Lorg/eclipse/swt/graphics/Color;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.IFontDecorator",
            "decorateFont",
            "(Ljava/lang/Object;)Lorg/eclipse/swt/graphics/Font;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.ILabelDecorator",
            "decorateImage",
            ("(Lorg/eclipse/swt/graphics/Image;Ljava/lang/Object;)Lorg/ecl" +
             "ipse/swt/graphics/Image;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.ILabelDecorator",
            "decorateText",
            "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.ITableColorProvider",
            "getForeground",
            "(Ljava/lang/Object;I)Lorg/eclipse/swt/graphics/Color;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.ITableColorProvider",
            "getBackground",
            "(Ljava/lang/Object;I)Lorg/eclipse/swt/graphics/Color;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.jface.viewers.ITableLabelProvider",
            "getColumnImage",
            "(Ljava/lang/Object;I)Lorg/eclipse/swt/graphics/Image;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.ui.IWorkbenchPage",
            "findView",
            "(Ljava/lang/String;)Lorg/eclipse/ui/IViewPart;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.ui.IWorkbenchPage",
            "findEditor",
            "(Lorg/eclipse/ui/IEditorInput;)Lorg/eclipse/ui/IEditorPart;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.ui.IWorkbenchPage",
            "findViewReference",
            "(Ljava/lang/String;)Lorg/eclipse/ui/IViewReference;",
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
        db.
          addMethodAnnotation(
            "org.eclipse.ui.IWorkbenchPage",
            "findViewReference",
            ("(Ljava/lang/String;Ljava/lang/String;)Lorg/eclipse/ui/IViewR" +
             "eference;"),
            false,
            edu.umd.cs.findbugs.ba.NullnessAnnotation.
              CHECK_FOR_NULL);
    }
    public DefaultNullnessAnnotations() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DPUwP7aZaiyT4ZO/yx9Z8/R/AUJETDTWGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
