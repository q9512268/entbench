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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17eczkyHVfz+w9Wu3M7noPr3alXe1I1m6vPrLZt8ZWRLLZ" +
       "JJtHs3k0uynZs7y6yW5ezaPZ3fYmloBEkg0oir2y5UDafyIjibK2bCNGEgUO" +
       "1ggSy7YSQIaRC4glxAYixxFi/SHFsJw4RfZ3zTffjHYkIR9Q1WTVq6r3e/Xq" +
       "vVfF+l7/RuWeJK5Uo9Dbzr0wPbA36cHCax6k28hODgZsU9DjxLZwT08SGZRd" +
       "N9/5a5e//Z1POlcuVu7VKo/qQRCmeuqGQSLaSeitbYutXD4pJTzbT9LKFXah" +
       "r3UoS10PYt0kvcZW3nKqaVq5yh6xAAEWIMACVLIAoSdUoNFb7SDz8aKFHqTJ" +
       "qvI3KxfYyr2RWbCXVp67sZNIj3X/sBuhRAB6uL94HwNQZeNNXHn2GPse802A" +
       "P1WFXv3Fn7jyG3dVLmuVy24gFeyYgIkUDKJVHvRt37DjBLUs29IqDwe2bUl2" +
       "7Oqeuyv51iqPJO480NMsto+FVBRmkR2XY55I7kGzwBZnZhrGx/Bmru1ZR2/3" +
       "zDx9DrA+foJ1j7BflAOAl1zAWDzTTfuoyd1LN7DSyjvOtjjGeJUBBKDpfb6d" +
       "OuHxUHcHOiioPLKfO08P5pCUxm4wB6T3hBkYJa08dctOC1lHurnU5/b1tPLk" +
       "WTphXwWoHigFUTRJK4+dJSt7ArP01JlZOjU/3+B/9BM/GVDBxZJnyza9gv/7" +
       "QaO3n2kk2jM7tgPT3jd88EX2F/THf+tjFysVQPzYGeI9zT/7qW9+4KW3v/Gl" +
       "Pc3bzqEZGgvbTK+bnzMe+srT+Avduwo27o/CxC0m/wbkpfoLhzXXNhFYeY8f" +
       "91hUHhxVviH+2+lPf97+s4uVS3TlXjP0Mh/o0cNm6EeuZ8ekHdixntoWXXnA" +
       "Diy8rKcr94Fn1g3sfelwNkvslK7c7ZVF94blOxDRDHRRiOg+8OwGs/DoOdJT" +
       "p3zeRJVK5T6QKg+C9COV/V/5m1YsyAl9G9JNPXCDEBLisMCfQHaQGkC2DmQA" +
       "rV9CSZjFQAWhMJ5DOtADxz6sKIWARpHnmuXykGwzi910SwBOQIv4oNC26P/T" +
       "OJsC75X8wgUwFU+fNQQeWENU6Fl2fN18NcOIb/7q9d+/eLwwDiWVVmpg6IP9" +
       "0Afl0PupvM3QlQsXyhF/qGBhTw2mbQkMADCND74g/fjg5Y+98y6gcVF+N5D5" +
       "RUAK3dpC4ycmgy4Nown0tvLGp/MPj/8WfLFy8UZTW7ANii4VzYXCQB4bwqtn" +
       "l9h5/V7+6Ne//YVfeCU8WWw32O5DG3Bzy2INv/OsgOPQtC1gFU+6f/FZ/Tev" +
       "/9YrVy9W7gaGARjDVAfKC+zM28+OccNavnZkFwss9wDAQM6+7hVVR8bsUurE" +
       "YX5SUs78Q+Xzw0DGbymU+90g/dShtpe/Re2jUZH/0F5Tikk7g6K0uz8mRZ/9" +
       "T//+T+uluI9M9OVTTk+y02unzELR2eXSADx8ogNybNuA7r9+Wvj5T33jox8s" +
       "FQBQPH/egFeLHAfmAEwhEPPf/tLqP3/1jz73hxePleZCCvxiZgAV3ByDLMor" +
       "l24DEoz27hN+gFnxwJIrtOaqEvih5c5c3fDsQkv/6vK7ar/5Pz9xZa8HHig5" +
       "UqOXvnsHJ+U/jFV++vd/4n+/vezmglm4tROZnZDtbeWjJz2jcaxvCz42H/6D" +
       "Z37pd/TPAqsLLF3i7uzSeN1VyuAu0Oi5WywcUc9LH3Ld/Bejr33ls7svvL6H" +
       "YujASFaqtwpHbo6ICs1+121W54mj+hb5vjf+9I/HP15MUiGttxxPTGlaX7qd" +
       "9pWkjwGdKmVQ+OK9CyyKm0eVV04q9466KG+XY0ElzYtlflB0Xgpoz8f7iuwd" +
       "yWkLcCOMUzHYdfOTf/jnbx3/+b/6ZimuG4O40wrP6dG1/Rorsmc3oPsnzpo7" +
       "Sk8cQNd4g//QFe+N74AeNdCjCcx5MoyB2d3csDwOqe+577/89r9+/OWv3FW5" +
       "2K9c8kLd6uulpak8AJa4nTjAYm+iv/GBvSDz+0F2pYRauQl8WfDUzTbg44ez" +
       "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" +
       "rTrb2vY7pGzAXHWu4xECMcKsx+uky7KG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("RnXU7YjG0iDVq2spaHSt1GfzZXemxWCfuTTXZr4eDTr2eDFud2FzaIjioqpT" +
       "hO41htHGiWp9Y7ORbeBSw8QSF6oEaw2sTxKK1Bzk8cpbrXyU6dJm7Lvb3tD3" +
       "8xQSTXRk1puEElRnW3ulUYrS2qyVdMAs866IcmQ8Uel+JofbKQiMJlh7TU6I" +
       "SLeyjZ+MRKtn9SiREVm4lcfcRJSmtawG7zIynIbGtAXBsV2FMhSeVLMkRFH0" +
       "x4ojqT+4s1PBh8vDzuNrot/DMefmvNsS5d+9lTNXC0+dKp+6eFApTvieudXt" +
       "z/J073MfefU1a/jLtaN7Nf8urTyQhtF7PXtte6e6Km46v3jrk0yuvPx6cpHg" +
       "dz7yP56S3++8fAdX6N5xhs+zXf5j7vXfJd9t/tzFyl3H1wpuupZ7Y6NrN14m" +
       "uBTbaRYH8g1XCp658QoLDNJnDiX7mfM+q1y5zWH9e/Zzf+ZOyYU9Qfn+pVNz" +
       "/uW0cp8Rhp6tB2W7r9/mLso3iuyP08ple//5/egw/7xO716HrnWiYX9yJ9dW" +
       "yoKvHYuk+GJbeRtIXzwUyRd/MCI5De0vb1P3V0X2rbTy4NxO9x+OFJE9+tjx" +
       "YHmeH9jpwVFhiffb3wfeUgXeA9LvHeL9vR843gv336buUpHdlVYed/dfds75" +
       "ZvO/jpFeuPv7QFpcTq50AdP37Nvuf98sUqC5Ueyu9dS+ncaX9q7E9dhtMD9R" +
       "ZJfTyqXETgd6jB1+jT6F88oPAudLhzhfusMZvfDom4P43G0gPl9kT+8h9uz1" +
       "ORCfuaO7ZWnlbbe5mVNc93zypn/M2P8zgfmrr12+/4nXlP9YXhI+vvD/AFu5" +
       "f5Z53umbV6ee741ie+aWcnhgfw8rKnG9mFYeO/eLIzBCxU/B+YUX9rTvTStX" +
       "ztKmlXvK39N0MBDTCV1auXf/cJqknlbuAiTFYyM6sganvu7tL59tLtzoCY8N" +
       "xCPfTdannOfzN7i88p9ijtxTJhzegf3CawP+J7/Z+uX9/WXT03e7opf72cp9" +
       "+6vUxy7uuVv2dtTXvdQL33no1x5415E7fmjP8ImOnuLtHedfFib8KC2v9+7+" +
       "+RP/9Ef/4Wt/VH7e/H/HfwTGrTQAAA==");
}
