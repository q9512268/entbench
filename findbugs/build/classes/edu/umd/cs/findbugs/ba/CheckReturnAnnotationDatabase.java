package edu.umd.cs.findbugs.ba;
public class CheckReturnAnnotationDatabase extends edu.umd.cs.findbugs.ba.AnnotationDatabase<edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation> {
    private org.apache.bcel.classfile.JavaClass throwableClass;
    private org.apache.bcel.classfile.JavaClass threadClass;
    public CheckReturnAnnotationDatabase() { super();
                                             setAddClassOnly(true);
                                             loadAuxiliaryAnnotations();
                                             setAddClassOnly(false); }
    @java.lang.Override
    public void loadAuxiliaryAnnotations() { if (IGNORE_BUILTIN_ANNOTATIONS) {
                                                 return;
                                             }
                                             boolean missingClassWarningsSuppressed =
                                               edu.umd.cs.findbugs.ba.AnalysisContext.
                                               currentAnalysisContext(
                                                 ).
                                               setMissingClassWarningsSuppressed(
                                                 true);
                                             addMethodAnnotation(
                                               "java.util.Iterator",
                                               "hasNext",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW);
                                             addMethodAnnotation(
                                               "java.io.File",
                                               "createNewFile",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.io.File",
                                               "delete",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.io.File",
                                               "mkdir",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.io.File",
                                               "mkdirs",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.io.File",
                                               "renameTo",
                                               "(Ljava/io/File;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.io.File",
                                               "setLastModified",
                                               "(J)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.io.File",
                                               "setReadOnly",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.io.File",
                                               "setWritable",
                                               "(ZZ)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.Enumeration",
                                               "hasMoreElements",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.security.MessageDigest",
                                               "digest",
                                               "([B)[B",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.util.concurrent.locks.ReadWriteLock",
                                               "readLock",
                                               "()Ljava/util/concurrent/locks/Lock;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.util.concurrent.locks.ReadWriteLock",
                                               "writeLock",
                                               "()Ljava/util/concurrent/locks/Lock;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.util.concurrent.locks.Condition",
                                               "await",
                                               "(JLjava/util/concurrent/TimeUnit;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.CountDownLatch",
                                               "await",
                                               "(JLjava/util/concurrent/TimeUnit;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.util.concurrent.locks.Condition",
                                               "awaitUntil",
                                               "(Ljava/util/Date;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.locks.Condition",
                                               "awaitNanos",
                                               "(J)J",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.Semaphore",
                                               "tryAcquire",
                                               "(JLjava/util/concurrent/TimeUnit;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.util.concurrent.Semaphore",
                                               "tryAcquire",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.util.concurrent.locks.Lock",
                                               "tryLock",
                                               "(JLjava/util/concurrent/TimeUnit;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.util.concurrent.locks.Lock",
                                               "newCondition",
                                               "()Ljava/util/concurrent/locks/Condition;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.util.concurrent.locks.Lock",
                                               "tryLock",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.util.concurrent.BlockingQueue",
                                               "offer",
                                               "(Ljava/lang/Object;JLjava/util/concurrent/TimeUnit;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.BlockingQueue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.ConcurrentLinkedQueue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.DelayQueue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.LinkedBlockingQueue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.LinkedList",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.util.Queue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.ArrayBlockingQueue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.SynchronousQueue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
                                             addMethodAnnotation(
                                               "java.util.PriorityQueue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.util.concurrent.PriorityBlockingQueue",
                                               "offer",
                                               "(Ljava/lang/Object;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addWarningAboutSubmit(
                                               java.util.concurrent.ExecutorService.class);
                                             addWarningAboutSubmit(
                                               java.util.concurrent.ThreadPoolExecutor.class);
                                             addWarningAboutSubmit(
                                               java.util.concurrent.ScheduledThreadPoolExecutor.class);
                                             addWarningAboutSubmit(
                                               java.util.concurrent.AbstractExecutorService.class);
                                             addMethodAnnotation(
                                               "java.util.concurrent.BlockingQueue",
                                               "poll",
                                               "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.util.Queue",
                                               "poll",
                                               "()Ljava/lang/Object;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW);
                                             addDefaultMethodAnnotation(
                                               "java.lang.String",
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "getBytes",
                                               "(Ljava/lang/String;)[B",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "charAt",
                                               "(I)C",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "toString",
                                               "()Ljava/lang/String;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "length",
                                               "()I",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "matches",
                                               "(Ljava/lang/String;)Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "intern",
                                               "()Ljava/lang/String;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "<init>",
                                               "([BLjava/lang/String;)V",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "<init>",
                                               "(Ljava/lang/String;)V",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW);
                                             addMethodAnnotation(
                                               "java.lang.String",
                                               "<init>",
                                               "()V",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_LOW);
                                             addDefaultMethodAnnotation(
                                               "java.math.BigDecimal",
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "inflate",
                                               "()Ljava/math/BigInteger;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "precision",
                                               "()I",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "toBigIntegerExact",
                                               "()Ljava/math/BigInteger;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "longValueExact",
                                               "()J",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "intValueExact",
                                               "()I",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "shortValueExact",
                                               "()S",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "byteValueExact",
                                               "()B",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "<init>",
                                               "(Ljava/lang/String;)V",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "intValue",
                                               "()I",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigDecimal",
                                               "stripZerosToMatchScale",
                                               "(J)Ljava/math/BigDecimal;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addDefaultMethodAnnotation(
                                               "java.math.BigInteger",
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_HIGH);
                                             addMethodAnnotation(
                                               "java.math.BigInteger",
                                               "addOne",
                                               "([IIII)I",
                                               true,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigInteger",
                                               "subN",
                                               "([I[II)I",
                                               true,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.math.BigInteger",
                                               "<init>",
                                               "(Ljava/lang/String;)V",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addDefaultMethodAnnotation(
                                               "java.sql.Connection",
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addDefaultMethodAnnotation(
                                               "java.net.InetAddress",
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.net.InetAddress",
                                               "getByName",
                                               "(Ljava/lang/String;)Ljava/net/InetAddress;",
                                               true,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.net.InetAddress",
                                               "getAllByName",
                                               "(Ljava/lang/String;)[Ljava/net/InetAddress;",
                                               true,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_IGNORE);
                                             addMethodAnnotation(
                                               "java.lang.ProcessBuilder",
                                               "redirectErrorStream",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.lang.ProcessBuilder",
                                               "redirectErrorStream",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               "java.lang.ProcessBuilder",
                                               "redirectErrorStream",
                                               "()Z",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addDefaultMethodAnnotation(
                                               "jsr166z.forkjoin.ParallelArray",
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addDefaultMethodAnnotation(
                                               "jsr166z.forkjoin.ParallelLongArray",
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addDefaultMethodAnnotation(
                                               "jsr166z.forkjoin.ParallelDoubleArray",
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               java.sql.Statement.class,
                                               "executeQuery",
                                               "(Ljava/lang/String;)Ljava/sql/ResultSet;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             addMethodAnnotation(
                                               java.sql.PreparedStatement.class,
                                               "executeQuery",
                                               "()Ljava/sql/ResultSet;",
                                               false,
                                               edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                                 CHECK_RETURN_VALUE_MEDIUM);
                                             edu.umd.cs.findbugs.ba.AnalysisContext.
                                               currentAnalysisContext(
                                                 ).
                                               setMissingClassWarningsSuppressed(
                                                 missingClassWarningsSuppressed);
                                             try {
                                                 throwableClass =
                                                   org.apache.bcel.Repository.
                                                     lookupClass(
                                                       "java.lang.Throwable");
                                             }
                                             catch (java.lang.ClassNotFoundException e) {
                                                 edu.umd.cs.findbugs.ba.AnalysisContext.
                                                   reportMissingClass(
                                                     e);
                                             }
                                             try {
                                                 threadClass =
                                                   org.apache.bcel.Repository.
                                                     lookupClass(
                                                       "java.lang.Thread");
                                             }
                                             catch (java.lang.ClassNotFoundException e) {
                                                 edu.umd.cs.findbugs.ba.AnalysisContext.
                                                   reportMissingClass(
                                                     e);
                                             }
    }
    private void addWarningAboutSubmit(java.lang.Class<? extends java.util.concurrent.ExecutorService> c) {
        addMethodAnnotation(
          c.
            getName(
              ),
          "submit",
          ("(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Futur" +
           "e;"),
          false,
          edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
            CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
        addMethodAnnotation(
          c.
            getName(
              ),
          "submit",
          "(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;",
          false,
          edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
            CHECK_RETURN_VALUE_LOW_BAD_PRACTICE);
        addMethodAnnotation(
          c.
            getName(
              ),
          "submit",
          ("(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurren" +
           "t/Future;"),
          false,
          edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
            CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation getResolvedAnnotation(java.lang.Object o,
                                                                                   boolean getMinimal) {
        if (!(o instanceof edu.umd.cs.findbugs.ba.XMethod)) {
            return null;
        }
        edu.umd.cs.findbugs.ba.XMethod m =
          (edu.umd.cs.findbugs.ba.XMethod)
            o;
        if (m.
              getName(
                ).
              startsWith(
                "access$")) {
            return null;
        }
        else
            if ("<init>".
                  equals(
                    m.
                      getName(
                        ))) {
                try {
                    if (throwableClass !=
                          null &&
                          org.apache.bcel.Repository.
                          instanceOf(
                            m.
                              getClassName(
                                ),
                            throwableClass)) {
                        return edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                 CHECK_RETURN_VALUE_VERY_HIGH;
                    }
                }
                catch (java.lang.ClassNotFoundException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      reportMissingClass(
                        e);
                }
                if ("java.lang.Thread".
                      equals(
                        m.
                          getClassName(
                            ))) {
                    return edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                             CHECK_RETURN_VALUE_VERY_HIGH;
                }
                try {
                    if (threadClass !=
                          null &&
                          org.apache.bcel.Repository.
                          instanceOf(
                            m.
                              getClassName(
                                ),
                            threadClass)) {
                        return edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                 CHECK_RETURN_VALUE_LOW;
                    }
                }
                catch (java.lang.ClassNotFoundException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      reportMissingClass(
                        e);
                }
            }
            else
                if ("equals".
                      equals(
                        m.
                          getName(
                            )) &&
                      "(Ljava/lang/Object;)Z".
                      equals(
                        m.
                          getSignature(
                            )) &&
                      !m.
                      isStatic(
                        )) {
                    return edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                             CHECK_RETURN_VALUE_MEDIUM;
                }
                else
                    if (m.
                          getSignature(
                            ).
                          endsWith(
                            ")Ljava/lang/String;") &&
                          ("java.lang.StringBuffer".
                             equals(
                               m.
                                 getClassName(
                                   )) ||
                             "java.lang.StringBuilder".
                             equals(
                               m.
                                 getClassName(
                                   )))) {
                        return edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation.
                                 CHECK_RETURN_VALUE_MEDIUM;
                    }
        return super.
          getResolvedAnnotation(
            o,
            getMinimal);
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
       "ghxQhYjlAcBL/AWxqV3oM7sJR0XL0Zpy");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qO1U6bPfv/OJ5x567UcLVbqecDcjFkDzh3Nc2zezJsExjlf38W7V99QkDHUv" +
       "PgTHYTWJ/XCih2tL1c8ErqGsWO0TNzHBv5kX/xAwR9Y0UQ49IDeE4icx0ATX" +
       "KqT+hb2t/cXXC+TcxGy+K298FnzfONroN/56fM1BMeAg//nKRe7idsX3HV32" +
       "CuB/fRNKfCEvPg8osdDj4wxE4qwbB0xAXz+fqQinn4MsyPdbN3RVefNH3pBT" +
       "ymLo7TfNocoTQh6+Lpdzl3+o/vpLV+546KXpV4o0opMcwTsH0B1G4jin4/en" +
       "6rcFoW5YBa3u3EXzg+K/LwFbezFVYugAoJKP+Y+7oV8GCnnB0Bise1Q9Pfor" +
       "MXTXfjSYTD3T/fuAuUfdMXQZlKc7/wA0gc68+rWdBv3yiSiepPKVjkSxtDNQ" +
       "7/try627cf7e3/gaJ471qRtI6vVwOcB/LcD+0Q39W97+mRMKPpZ3/+R5Cua9" +
       "/6VQ5j8qePByMXGRabFfNLfRF/HjveB769Fsb93xQ/0boFW+fJ4BAqrHLPnb" +
       "WOaEK8+8LldOgeYw33lDjCmSSVrnSZn3/lnBmG/vGfOdwgNSO17kxbeKvu/8" +
       "AIvmzf+tKC5yN398UeNr5xsvnb21nRjJB17Px5y66D1xw4Mck+wy3K+pr7zU" +
       "G/70d2uf3WUegiPHdnt0Urp9lwR5ch17/IazHc91G/3U9+79jTufPL463rtD" +
       "eO+4TuH2jovT/Cg3iIvEvO1vPvTPf+wfv/S1IhXl/wLbgAvoeDAAAA==");
}
