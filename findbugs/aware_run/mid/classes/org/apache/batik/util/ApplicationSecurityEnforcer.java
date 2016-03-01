package org.apache.batik.util;
public class ApplicationSecurityEnforcer {
    public static final java.lang.String EXCEPTION_ALIEN_SECURITY_MANAGER =
      ("ApplicationSecurityEnforcer.message.security.exception.alien" +
       ".security.manager");
    public static final java.lang.String EXCEPTION_NO_POLICY_FILE = ("ApplicationSecurityEnforcer.message.null.pointer.exception.n" +
                                                                     "o.policy.file");
    public static final java.lang.String PROPERTY_JAVA_SECURITY_POLICY =
      "java.security.policy";
    public static final java.lang.String JAR_PROTOCOL = "jar:";
    public static final java.lang.String JAR_URL_FILE_SEPARATOR =
      "!/";
    public static final java.lang.String PROPERTY_APP_DEV_BASE = "app.dev.base";
    public static final java.lang.String PROPERTY_APP_JAR_BASE = "app.jar.base";
    public static final java.lang.String APP_MAIN_CLASS_DIR = "classes/";
    protected java.lang.Class appMainClass;
    protected java.lang.String securityPolicy;
    protected java.lang.String appMainClassRelativeURL;
    protected org.apache.batik.util.BatikSecurityManager lastSecurityManagerInstalled;
    public ApplicationSecurityEnforcer(java.lang.Class appMainClass,
                                       java.lang.String securityPolicy,
                                       java.lang.String appJarFile) {
        this(
          appMainClass,
          securityPolicy);
    }
    public ApplicationSecurityEnforcer(java.lang.Class appMainClass,
                                       java.lang.String securityPolicy) {
        super(
          );
        this.
          appMainClass =
          appMainClass;
        this.
          securityPolicy =
          securityPolicy;
        this.
          appMainClassRelativeURL =
          appMainClass.
            getName(
              ).
            replace(
              '.',
              '/') +
          ".class";
    }
    public void enforceSecurity(boolean enforce) { java.lang.SecurityManager sm =
                                                     java.lang.System.
                                                     getSecurityManager(
                                                       );
                                                   if (sm !=
                                                         null &&
                                                         sm !=
                                                         lastSecurityManagerInstalled) {
                                                       throw new java.lang.SecurityException(
                                                         org.apache.batik.util.Messages.
                                                           getString(
                                                             EXCEPTION_ALIEN_SECURITY_MANAGER));
                                                   }
                                                   if (enforce) {
                                                       java.lang.System.
                                                         setSecurityManager(
                                                           null);
                                                       installSecurityManager(
                                                         );
                                                   }
                                                   else {
                                                       if (sm !=
                                                             null) {
                                                           java.lang.System.
                                                             setSecurityManager(
                                                               null);
                                                           lastSecurityManagerInstalled =
                                                             null;
                                                       }
                                                   }
    }
    public java.net.URL getPolicyURL() { java.lang.ClassLoader cl =
                                           appMainClass.
                                           getClassLoader(
                                             );
                                         java.net.URL policyURL =
                                           cl.
                                           getResource(
                                             securityPolicy);
                                         if (policyURL ==
                                               null) {
                                             throw new java.lang.NullPointerException(
                                               org.apache.batik.util.Messages.
                                                 formatMessage(
                                                   EXCEPTION_NO_POLICY_FILE,
                                                   new java.lang.Object[] { securityPolicy }));
                                         }
                                         return policyURL;
    }
    public void installSecurityManager() {
        java.security.Policy policy =
          java.security.Policy.
          getPolicy(
            );
        org.apache.batik.util.BatikSecurityManager securityManager =
          new org.apache.batik.util.BatikSecurityManager(
          );
        java.lang.ClassLoader cl =
          appMainClass.
          getClassLoader(
            );
        java.lang.String securityPolicyProperty =
          java.lang.System.
          getProperty(
            PROPERTY_JAVA_SECURITY_POLICY);
        if (securityPolicyProperty ==
              null ||
              securityPolicyProperty.
              equals(
                "")) {
            java.net.URL policyURL =
              getPolicyURL(
                );
            java.lang.System.
              setProperty(
                PROPERTY_JAVA_SECURITY_POLICY,
                policyURL.
                  toString(
                    ));
        }
        java.net.URL mainClassURL =
          cl.
          getResource(
            appMainClassRelativeURL);
        if (mainClassURL ==
              null) {
            throw new java.lang.Error(
              appMainClassRelativeURL);
        }
        java.lang.String expandedMainClassName =
          mainClassURL.
          toString(
            );
        if (expandedMainClassName.
              startsWith(
                JAR_PROTOCOL)) {
            setJarBase(
              expandedMainClassName);
        }
        else {
            setDevBase(
              expandedMainClassName);
        }
        java.lang.System.
          setSecurityManager(
            securityManager);
        lastSecurityManagerInstalled =
          securityManager;
        policy.
          refresh(
            );
        if (securityPolicyProperty ==
              null ||
              securityPolicyProperty.
              equals(
                "")) {
            java.lang.System.
              setProperty(
                PROPERTY_JAVA_SECURITY_POLICY,
                "");
        }
    }
    private void setJarBase(java.lang.String expandedMainClassName) {
        java.lang.String curAppJarBase =
          java.lang.System.
          getProperty(
            PROPERTY_APP_JAR_BASE);
        if (curAppJarBase ==
              null) {
            expandedMainClassName =
              expandedMainClassName.
                substring(
                  JAR_PROTOCOL.
                    length(
                      ));
            int codeBaseEnd =
              expandedMainClassName.
              indexOf(
                JAR_URL_FILE_SEPARATOR +
                appMainClassRelativeURL);
            if (codeBaseEnd ==
                  -1) {
                throw new java.lang.Error(
                  );
            }
            java.lang.String appCodeBase =
              expandedMainClassName.
              substring(
                0,
                codeBaseEnd);
            codeBaseEnd =
              appCodeBase.
                lastIndexOf(
                  '/');
            if (codeBaseEnd ==
                  -1) {
                appCodeBase =
                  "";
            }
            else {
                appCodeBase =
                  appCodeBase.
                    substring(
                      0,
                      codeBaseEnd);
            }
            java.lang.System.
              setProperty(
                PROPERTY_APP_JAR_BASE,
                appCodeBase);
        }
    }
    private void setDevBase(java.lang.String expandedMainClassName) {
        java.lang.String curAppCodeBase =
          java.lang.System.
          getProperty(
            PROPERTY_APP_DEV_BASE);
        if (curAppCodeBase ==
              null) {
            int codeBaseEnd =
              expandedMainClassName.
              indexOf(
                APP_MAIN_CLASS_DIR +
                appMainClassRelativeURL);
            if (codeBaseEnd ==
                  -1) {
                throw new java.lang.Error(
                  );
            }
            java.lang.String appCodeBase =
              expandedMainClassName.
              substring(
                0,
                codeBaseEnd);
            java.lang.System.
              setProperty(
                PROPERTY_APP_DEV_BASE,
                appCodeBase);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1KZbzmaieLhQ3YYG1XZdrDVWGaJblYF7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6XBDDewR+ayF+fZylPAtZjqfTl2Zm2RLF+lF2dppD7hsxrTr/MAPXIgbbDyI" +
       "qSP+GniHWcNu7SyZ7CrGJpybOdGZSuIWo6EaHwCTy83odt9omvqyy9ML1+U0" +
       "TM7zRW+6cbhuf4Q03SCiOQ1pTQdR06JcA67asw6dDUxsAtEZTUpWLxjgOF4c" +
       "K/3BnZ3sPVweWB5fA/0+jiqz8248lH/3Vs5cHTx1Mnzq8kClOKV75la3O8sT" +
       "us9/5NXXdP5Xakd3Y/5tUnkgCcL3usbGcE8NVdxkfvHWp5Fsebn15DLA73zk" +
       "vz81eb/98h1cg3vHGZxnh/yH7Ou/y7xb+8WLlbuOrwbcdO32xk7XbrwQcCky" +
       "kjTyJzdcC3jmxmsoMHg+e8jZz573aeTKbQ7c37OX/Zl7IRf2Dcr3L5+S+VeS" +
       "yn2LIHAN1S/7feM290m+WSR/nFQuG/tP6EcH8ucNevcmcPQTDfuTO7l6UhZ8" +
       "/ZglxVfXytvA86VDlnzph8OS06T9xW3q/rJIvp1UHrSMZP/xZyoOjz5YPFie" +
       "yftGcnBUWNL7nR+A3lIF3gOe3zuk9/d+6PReuP82dZeK5K6k8riz/zpzzneX" +
       "/3lM6YW7fwBKi8vHlTYAfc++7/73zVIKNDeMnI2aGLfT+NLelXQ9dhuanyiS" +
       "y0nlUmwkfTUiDr8on6Lzyg+DzpcO6XzpDiV64dE3R+JztyHx+SJ5ek9ix9ic" +
       "Q+Izd3Q/LKm87Ta3a4orm0/e9I8X+38W0H7ttcv3P/Ha9D+UF32PL/Q/MKzc" +
       "b6aue/r21Kn8vWFkmE7Jhwf2d6nCkq4Xk8pj5341BEao+CmQX3hh3/a9SeXK" +
       "2bZJ5Z7y93Q7GLDppF1SuXefOd0ETSp3gSZFth4eWYNTX+j2F8iyCzd6wmMD" +
       "8cj34vUp5/n8DS6v/KeXI/eUCof3WL/4Wp/7qW81f2V/B1lz1d2uGOX+YeW+" +
       "/XXoYxf33C1HOxrr3u4L333o1x9415E7fmgP+ERHT2F7x/kXfikvTMorurt/" +
       "9sQ/+fG//9oflZ8o/x9LcaMqjTQAAA==");
}
