package edu.umd.cs.findbugs.util;
public class JavaWebStart {
    @javax.annotation.CheckForNull
    static final java.lang.reflect.Method jnlpShowDocumentMethod;
    @javax.annotation.CheckForNull
    static final java.lang.reflect.Method jnlpGetCodeBaseMethod;
    static final java.lang.Object jnlpBasicService;
    static { java.lang.reflect.Method showMethod = null;
             java.lang.reflect.Method getCodeBase = null;
             java.lang.Object showObject = null;
             try { java.lang.Class<?> serviceManagerClass = java.lang.Class.
                     forName(
                       "javax.jnlp.ServiceManager");
                   java.lang.reflect.Method lookupMethod = serviceManagerClass.
                     getMethod(
                       "lookup",
                       new java.lang.Class[] { java.lang.String.class });
                   showObject = lookupMethod.invoke(null, new java.lang.Object[] { "javax.jnlp.BasicService" });
                   showMethod = showObject.getClass().getMethod("showDocument",
                                                                new java.lang.Class[] { java.net.URL.class });
                   getCodeBase = showObject.getClass().getMethod("getCodeBase",
                                                                 new java.lang.Class[] {  });
             }
             catch (java.lang.ClassNotFoundException e) {
                 assert true;
             }
             catch (java.lang.NoSuchMethodException e) {
                 assert true;
             }
             catch (java.lang.IllegalAccessException e) {
                 assert true;
             }
             catch (java.lang.reflect.InvocationTargetException e) {
                 assert true;
             }
             jnlpShowDocumentMethod = showMethod;
             jnlpGetCodeBaseMethod = getCodeBase;
             jnlpBasicService = showObject; }
    public static boolean isRunningViaJavaWebstart() { return edu.umd.cs.findbugs.util.JavaWebStart.
                                                                jnlpBasicService !=
                                                         null;
    }
    public static java.net.URL resolveRelativeToJnlpCodebase(java.lang.String s)
          throws java.net.MalformedURLException {
        if (edu.umd.cs.findbugs.util.JavaWebStart.
              jnlpGetCodeBaseMethod !=
              null) {
            try {
                java.net.URL base =
                  (java.net.URL)
                    edu.umd.cs.findbugs.util.JavaWebStart.
                      jnlpGetCodeBaseMethod.
                    invoke(
                      edu.umd.cs.findbugs.util.JavaWebStart.
                        jnlpBasicService);
                if (base !=
                      null) {
                    return new java.net.URL(
                      base,
                      s);
                }
            }
            catch (java.lang.RuntimeException e) {
                assert true;
            }
            catch (java.lang.Exception e) {
                assert true;
            }
        }
        return new java.net.URL(
          s);
    }
    static java.lang.Boolean viaWebStart(java.net.URL url)
          throws java.lang.IllegalArgumentException,
        java.lang.IllegalAccessException,
        java.lang.reflect.InvocationTargetException {
        if (edu.umd.cs.findbugs.util.JavaWebStart.
              jnlpShowDocumentMethod ==
              null) {
            throw new java.lang.UnsupportedOperationException(
              "Launch via web start not available");
        }
        return (java.lang.Boolean)
                 edu.umd.cs.findbugs.util.JavaWebStart.
                   jnlpShowDocumentMethod.
                 invoke(
                   edu.umd.cs.findbugs.util.JavaWebStart.
                     jnlpBasicService,
                   url);
    }
    static boolean showViaWebStart(java.net.URL url) {
        if (edu.umd.cs.findbugs.util.JavaWebStart.
              jnlpShowDocumentMethod !=
              null) {
            try {
                if (edu.umd.cs.findbugs.util.LaunchBrowser.
                      DEBUG) {
                    javax.swing.JOptionPane.
                      showMessageDialog(
                        null,
                        "Trying browse via webstart");
                }
                java.lang.Boolean b =
                  viaWebStart(
                    url);
                boolean success =
                  b !=
                  null &&
                  b.
                  booleanValue(
                    );
                if (edu.umd.cs.findbugs.util.LaunchBrowser.
                      DEBUG) {
                    javax.swing.JOptionPane.
                      showMessageDialog(
                        null,
                        " browse via webstart: " +
                        success);
                }
                return success;
            }
            catch (java.lang.reflect.InvocationTargetException ite) {
                assert true;
            }
            catch (java.lang.IllegalAccessException iae) {
                assert true;
            }
        }
        return false;
    }
    public JavaWebStart() { super(); }
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
      ("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");
}
