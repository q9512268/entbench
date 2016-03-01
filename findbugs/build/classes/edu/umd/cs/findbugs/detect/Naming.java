package edu.umd.cs.findbugs.detect;
public class Naming extends edu.umd.cs.findbugs.visitclass.PreorderVisitor implements edu.umd.cs.findbugs.Detector {
    public static class NamingProperty extends edu.umd.cs.findbugs.props.AbstractWarningProperty {
        private NamingProperty(java.lang.String name, edu.umd.cs.findbugs.props.PriorityAdjustment priorityAdjustment) {
            super(
              name,
              priorityAdjustment);
        }
        public static final edu.umd.cs.findbugs.detect.Naming.NamingProperty
          METHOD_IS_CALLED =
          new edu.umd.cs.findbugs.detect.Naming.NamingProperty(
          "CONFUSING_METHOD_IS_CALLED",
          edu.umd.cs.findbugs.props.PriorityAdjustment.
            AT_MOST_MEDIUM);
        public static final edu.umd.cs.findbugs.detect.Naming.NamingProperty
          METHOD_IS_DEPRECATED =
          new edu.umd.cs.findbugs.detect.Naming.NamingProperty(
          "CONFUSING_METHOD_IS_DEPRECATED",
          edu.umd.cs.findbugs.props.PriorityAdjustment.
            LOWER_PRIORITY);
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUYa2wcR3nuzu/6ncQOieMmrlPkNNwmtAFVDm2c8zm2e35g" +
                                                                  "uwbOkOvc7py98d7uZnfWPjsttJVQw58okEfTivpXqkpRaSNEBT9oZVQBRQWk" +
                                                                  "lgItiID4VVQiGiFaRHh9M7N7u7d314gfnLSzczPfe77X7PPXUa1toV6i0zhd" +
                                                                  "M4kdT+p0Gls2URIatu05WMvIT8bwX4+/O3lvFNWlUesStidkbJMRlWiKnUa7" +
                                                                  "VN2mWJeJPUmIwjCmLWITawVT1dDTaJtqj+VNTZVVOmEohAHMYyuFOjCllpp1" +
                                                                  "KBlzCVC0KwWSSFwSaSi8PZhCzbJhrvng2wPgicAOg8z7vGyK2lMn8AqWHKpq" +
                                                                  "Ukq16WDBQneZhra2qBk0Tgo0fkI75JpgPHWozAR9V9s+uHl2qZ2bYAvWdYNy" +
                                                                  "9ewZYhvaClFSqM1fTWokb59EX0axFLotAExRf8pjKgFTCZh62vpQIH0L0Z18" +
                                                                  "wuDqUI9SnSkzgSjaU0rExBbOu2SmucxAoYG6unNk0HZ3UVuhZZmKF+6Szj95" +
                                                                  "vP3bMdSWRm2qPsvEkUEICkzSYFCSzxLLHlIUoqRRhw6HPUssFWvqunvSnba6" +
                                                                  "qGPqwPF7ZmGLjkksztO3FZwj6GY5MjWsono57lDuv9qchhdB1y5fV6HhCFsH" +
                                                                  "BZtUEMzKYfA7F6VmWdUVim4PYxR17H8AAAC1Pk/oklFkVaNjWECdwkU0rC9K" +
                                                                  "s+B6+iKA1hrggBZFO6oSZbY2sbyMF0mGeWQIblpsAVQjNwRDoWhbGIxTglPa" +
                                                                  "ETqlwPlcnzx85pQ+qkdRBGRWiKwx+W8DpN4Q0gzJEYtAHAjE5n2pi7jr5dNR" +
                                                                  "hAB4WwhYwHz34RtH9vduviZgdlaAmcqeIDLNyJezrW/0JAbujTExGkzDVtnh" +
                                                                  "l2jOo2za3RksmJBhuooU2Wbc29yc+dEXHr1C3ouipjFUJxuakwc/6pCNvKlq" +
                                                                  "xDpGdGJhSpQx1Eh0JcH3x1A9zFOqTsTqVC5nEzqGajS+VGfw/2CiHJBgJmqC" +
                                                                  "uarnDG9uYrrE5wUTIdQJD+qGZwiJH39T9HlpycgTCctYV3VDmrYMpr8tQcbJ" +
                                                                  "gm2XpBw4U9ZZtCXbkiXuOkRxJCevSLLtbyqEApo0ifPgUHEGZv4faReYXltW" +
                                                                  "IxEweU844DWIlVFDU4iVkc87R5M3Xsi8LpyJBYBrEYoOAKs4sIrLdtxjFRes" +
                                                                  "4oJVv3iB2DyyUSTCGW5lEojzhdNZhjiHRNs8MPul8YdO98XAsczVGjAtA+0r" +
                                                                  "KTgJPxl4GTwjv9jZsr7n2sFXo6gmhTqxTB2ssfoxZC1CZpKX3eBtzkIp8ivC" +
                                                                  "7kBFYKXMMmRQxyLVKoNLpcFYIRZbp2hrgIJXr1hkStWrRUX50eal1cfmv3Ig" +
                                                                  "iqKlRYCxrIX8xdCnWeoupuj+cPBXotv2xLsfvHjxEcNPAyVVxSuGZZhMh76w" +
                                                                  "S4TNk5H37cYvZV5+pJ+bvRHSNMUQVpABe8M8SrLMoJexmS4NoHDOsPJYY1ue" +
                                                                  "jZvokmWs+ivcVzv4fCu4RTsLu154Em4c8jfb7TLZ2C18m/lZSAteET4zaz7z" +
                                                                  "9s//dDc3t1c82gJVf5bQwUDCYsQ6eWrq8N12ziIE4H53afrchetPLHCfBYg7" +
                                                                  "KjHsZ2MCEhUcIZj5q6+dfOf31y6/FfX9nKJ601KhDSKFopYNTKm2j9AS2N3p" +
                                                                  "CwQZT4O4Y27T/6AODqrmVJzVCIusf7btPfjSn8+0C0fQYMXzo/23JuCvf+wo" +
                                                                  "evT14x/2cjIRmVVc32g+mEjjW3zKQ5aF15gchcfe3PXUj/EzUBAgCdvqOuF5" +
                                                                  "NcqNEOWab4cGjGOy4hoXxdXb2F8p3ZiQWph7qoal0rUh5YRj0zzEJfeBQxz1" +
                                                                  "AB/vYebjnBDfG2TDXjsYS6XhGuizMvLZt95vmX//lRtc99JGLeg6E9gcFN7K" +
                                                                  "hjsLQL47nOtGsb0EcPdsTn6xXdu8CRTTQFGG7sSesiDlFkoczYWurf/ND17t" +
                                                                  "euiNGIqOoCbNwMoI5jGLGiFYiL0E2bpg3n9EuMpqgxcmBVSmfNkCO67bKztC" +
                                                                  "Mm9SfnTr3+v+zuHnNq5xpzUFjZ3uuUEBKUnSvN3388SVX3z6l899/eKqaBgG" +
                                                                  "qifHEN72f0xp2cf/+Pcyk/O0WKGZCeGnpee/uSNx33sc389PDLu/UF70IMf7" +
                                                                  "uJ+8kv9btK/uh1FUn0btsttez2PNYVGfhpbS9npuaMFL9kvbQ9ELDRbzb084" +
                                                                  "NwbYhjOjX2xhzqDZvCWUDHvYEd4Nz6ibJo6Fk2EE8ckER/k4H/ex4RP8+GIU" +
                                                                  "bgtOFi5dMLF5I09BDFXHWigX7fSIV2ACUTuRnBudGs6MzWYSQ6lUctiL2v+5" +
                                                                  "SRDJm42H2TApxLi/qm8fK7fFA66Y41Vska5iCzb9LBtm2DBbwQDjVShDN+Ab" +
                                                                  "YDg5PZNMDM0lh9nefEihhY9QqFBZsKgvmC8TD96OcDsaLBB+kCKWiXZVuzHw" +
                                                                  "287lx89vKFPPHhRh2lnahSfhkvmtX/3rp/FLf/hJhUawzr3xBRlS1Fp6rp5D" +
                                                                  "7LmlQ4Cs28vuoOLeJL+w0dbQvfHgr3nXUbzbNEO9zjmaFoyYwLzOtEhO5ZHT" +
                                                                  "LOLH5C8DrmvVpQG9xIRLrgsU6G+2VEChwN+dBqEdipp8aIqicsk2GKne3aYo" +
                                                                  "BmNw8xQswSabPmx6xjtYvQYOZaGRg6LwOWzpAbMXIqV+UPTDbbcKrIDr3FGS" +
                                                                  "tflnBPdgJhzxIQHa8I3xyVM3PvWs6KtkDa+v82sn3KJFi1fsXvdUpebRqhsd" +
                                                                  "uNl6tXFv1C3WHUJgP5J2Bip5EjookxWxHaGew+4vth7vXD78ys9O170JzruA" +
                                                                  "IhgOcaE8SxdMB6JkIeVXs8BnKN4MDQ48vXbf/txffsvrIBJXlJ7q8FCFzr09" +
                                                                  "dnX5wyP83loLJ0YKvHwMr+kzRF6BAt7g6OpJh4wpKdTK/BmznofbwTVfS3GV" +
                                                                  "deEU9ZV9Oahwd4EeYZVYRw1HV3jZgBLqr5R8z3BjpMkxzRCCv1I8uq3lumbk" +
                                                                  "4a+1ff9sZ2wEYrJEnSD5etvJznk1LPiJwy9q7SK1/Qd+EXj+zR52yGyBvaGy" +
                                                                  "Jtzr/u7ifR+aEbEXy6QmTNOFbZgyRcicYcPZAlumKLLPXWXdT0S03uzvOc7+" +
                                                                  "G3zKhgv/BUzD+/TtFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "jTZVC5ytzJpQqqhqC+BsQqx8inDYTl0JYypzzAo90alk29o02UEFnsolYmmU" +
           "MqaObLtbLBa6WyrMfDhq6ipTEgiRWG4bU3s2GpMiv94yki6tpAnfBrMMaHqy" +
           "XCzlWZktV6MsHkvNUhdgqbaOYWyedUrwLCRBNpYfJ5wf7kT3QHFQPfkS9CMc" +
           "UdPbT3iwn3B/M1lcIz1w/qPC6ZvJ/QUTlB/a3nCn7z7Fge3j733xJXn8icrB" +
           "0cWcHkIXjz7HneYTQvefvZk/vhZ88lWv9IEIj9zygXD3UUv6zEtXLz/80vyv" +
           "i1vskw9P99LQZTWyrNP3PafqFz1fUfVC2nt3tz9e8fcecLi+szRAr12lkPzd" +
           "O5JfCqEHb0MSgvmPqqdHPx9CV/ajQ+hAOtP9/hC6dNQdQneB8nTnr4Im0JlX" +
           "X/COjVe5851qWwxCX5DCBchrT5k9vXB2eU/c6/qrHZRPecTTZy4Zim+8Rwsz" +
           "jHZfeW9Kn32JGr3rlcYndvf0kiVkWc7lMg1d2n0yOPka8uQduR3zuth75nv3" +
           "f+7eNx372P07gfcBckq2N97+TpywvbC4xc5+/+HffetvvfS14hrmfwHTDoo4" +
           "fB8AAA==");
    }
    java.lang.String baseClassName;
    boolean classIsPublicOrProtected;
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.XMethod definedIn(org.apache.bcel.classfile.JavaClass clazz,
                                                           edu.umd.cs.findbugs.ba.XMethod m) {
        for (org.apache.bcel.classfile.Method m2
              :
              clazz.
               getMethods(
                 )) {
            if (m.
                  getName(
                    ).
                  equals(
                    m2.
                      getName(
                        )) &&
                  m.
                  getSignature(
                    ).
                  equals(
                    m2.
                      getSignature(
                        )) &&
                  m.
                  isStatic(
                    ) ==
                  m2.
                  isStatic(
                    )) {
                return edu.umd.cs.findbugs.ba.XFactory.
                  createXMethod(
                    clazz,
                    m2);
            }
        }
        return null;
    }
    public static boolean confusingMethodNamesWrongCapitalization(edu.umd.cs.findbugs.ba.XMethod m1,
                                                                  edu.umd.cs.findbugs.ba.XMethod m2) {
        if (m1.
              isStatic(
                ) !=
              m2.
              isStatic(
                )) {
            return false;
        }
        if (m1.
              getClassName(
                ).
              equals(
                m2.
                  getClassName(
                    ))) {
            return false;
        }
        if (m1.
              getName(
                ).
              equals(
                m2.
                  getName(
                    ))) {
            return false;
        }
        if (m1.
              getName(
                ).
              equalsIgnoreCase(
                m2.
                  getName(
                    )) &&
              removePackageNamesFromSignature(
                m1.
                  getSignature(
                    )).
              equals(
                removePackageNamesFromSignature(
                  m2.
                    getSignature(
                      )))) {
            return true;
        }
        return false;
    }
    public static boolean confusingMethodNamesWrongPackage(edu.umd.cs.findbugs.ba.XMethod m1,
                                                           edu.umd.cs.findbugs.ba.XMethod m2) {
        if (m1.
              isStatic(
                ) !=
              m2.
              isStatic(
                )) {
            return false;
        }
        if (m1.
              getClassName(
                ).
              equals(
                m2.
                  getClassName(
                    ))) {
            return false;
        }
        if (!m1.
              getName(
                ).
              equals(
                m2.
                  getName(
                    ))) {
            return false;
        }
        if (m1.
              getSignature(
                ).
              equals(
                m2.
                  getSignature(
                    ))) {
            return false;
        }
        if (removePackageNamesFromSignature(
              m1.
                getSignature(
                  )).
              equals(
                removePackageNamesFromSignature(
                  m2.
                    getSignature(
                      )))) {
            return true;
        }
        return false;
    }
    java.util.HashMap<java.lang.String,java.util.TreeSet<edu.umd.cs.findbugs.ba.XMethod>>
      canonicalToXMethod =
      new java.util.HashMap<java.lang.String,java.util.TreeSet<edu.umd.cs.findbugs.ba.XMethod>>(
      );
    java.util.HashSet<java.lang.String> visited =
      new java.util.HashSet<java.lang.String>(
      );
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    public Naming(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        classContext.
          getJavaClass(
            ).
          accept(
            this);
    }
    private boolean checkSuper(edu.umd.cs.findbugs.ba.XMethod m,
                               java.util.Set<edu.umd.cs.findbugs.ba.XMethod> others) {
        if (m.
              isStatic(
                )) {
            return false;
        }
        if ("<init>".
              equals(
                m.
                  getName(
                    )) ||
              "<clinit>".
              equals(
                m.
                  getName(
                    ))) {
            return false;
        }
        for (edu.umd.cs.findbugs.ba.XMethod m2
              :
              others) {
            try {
                if ((confusingMethodNamesWrongCapitalization(
                       m,
                       m2) ||
                       confusingMethodNamesWrongPackage(
                         m,
                         m2)) &&
                      org.apache.bcel.Repository.
                      instanceOf(
                        m.
                          getClassName(
                            ),
                        m2.
                          getClassName(
                            ))) {
                    edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.detect.Naming.NamingProperty> propertySet =
                      new edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.detect.Naming.NamingProperty>(
                      );
                    int priority =
                      HIGH_PRIORITY;
                    boolean intentional =
                      false;
                    edu.umd.cs.findbugs.ba.XMethod m3 =
                      null;
                    try {
                        org.apache.bcel.classfile.JavaClass clazz =
                          org.apache.bcel.Repository.
                          lookupClass(
                            m.
                              getClassName(
                                ));
                        if ((m3 =
                               definedIn(
                                 clazz,
                                 m2)) !=
                              null) {
                            priority =
                              NORMAL_PRIORITY;
                            intentional =
                              true;
                        }
                    }
                    catch (java.lang.ClassNotFoundException e) {
                        priority++;
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          reportMissingClass(
                            e);
                    }
                    edu.umd.cs.findbugs.ba.XFactory xFactory =
                      edu.umd.cs.findbugs.ba.AnalysisContext.
                      currentXFactory(
                        );
                    if (m3 ==
                          null &&
                          xFactory.
                          isCalled(
                            m)) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.Naming.NamingProperty.
                              METHOD_IS_CALLED);
                    }
                    else
                        if (m.
                              isDeprecated(
                                ) ||
                              m2.
                              isDeprecated(
                                )) {
                            propertySet.
                              addProperty(
                                edu.umd.cs.findbugs.detect.Naming.NamingProperty.
                                  METHOD_IS_DEPRECATED);
                        }
                    if (!m.
                          getName(
                            ).
                          equals(
                            m2.
                              getName(
                                )) &&
                          m.
                          getName(
                            ).
                          equalsIgnoreCase(
                            m2.
                              getName(
                                ))) {
                        java.lang.String pattern =
                          intentional
                          ? "NM_VERY_CONFUSING_INTENTIONAL"
                          : "NM_VERY_CONFUSING";
                        java.util.Set<edu.umd.cs.findbugs.ba.XMethod> overrides =
                          edu.umd.cs.findbugs.ba.Hierarchy2.
                          findSuperMethods(
                            m);
                        if (!overrides.
                              isEmpty(
                                )) {
                            if (intentional ||
                                  allAbstract(
                                    overrides)) {
                                break;
                            }
                            priority++;
                        }
                        edu.umd.cs.findbugs.BugInstance bug =
                          new edu.umd.cs.findbugs.BugInstance(
                          this,
                          pattern,
                          priority).
                          addClass(
                            m.
                              getClassName(
                                )).
                          addMethod(
                            m).
                          addClass(
                            m2.
                              getClassName(
                                )).
                          describe(
                            edu.umd.cs.findbugs.ClassAnnotation.
                              SUPERCLASS_ROLE).
                          addMethod(
                            m2).
                          describe(
                            edu.umd.cs.findbugs.MethodAnnotation.
                              METHOD_DID_YOU_MEAN_TO_OVERRIDE);
                        if (m3 !=
                              null) {
                            bug.
                              addMethod(
                                m3).
                              describe(
                                edu.umd.cs.findbugs.MethodAnnotation.
                                  METHOD_OVERRIDDEN);
                        }
                        propertySet.
                          decorateBugInstance(
                            bug);
                        bugReporter.
                          reportBug(
                            bug);
                    }
                    else
                        if (!m.
                              getSignature(
                                ).
                              equals(
                                m2.
                                  getSignature(
                                    )) &&
                              removePackageNamesFromSignature(
                                m.
                                  getSignature(
                                    )).
                              equals(
                                removePackageNamesFromSignature(
                                  m2.
                                    getSignature(
                                      )))) {
                            java.lang.String pattern =
                              intentional
                              ? "NM_WRONG_PACKAGE_INTENTIONAL"
                              : "NM_WRONG_PACKAGE";
                            java.util.Set<edu.umd.cs.findbugs.ba.XMethod> overrides =
                              edu.umd.cs.findbugs.ba.Hierarchy2.
                              findSuperMethods(
                                m);
                            if (!overrides.
                                  isEmpty(
                                    )) {
                                if (intentional ||
                                      allAbstract(
                                        overrides)) {
                                    break;
                                }
                                priority++;
                            }
                            java.util.Iterator<java.lang.String> s =
                              new edu.umd.cs.findbugs.ba.SignatureParser(
                              m.
                                getSignature(
                                  )).
                              parameterSignatureIterator(
                                );
                            java.util.Iterator<java.lang.String> s2 =
                              new edu.umd.cs.findbugs.ba.SignatureParser(
                              m2.
                                getSignature(
                                  )).
                              parameterSignatureIterator(
                                );
                            while (s.
                                     hasNext(
                                       )) {
                                java.lang.String p =
                                  s.
                                  next(
                                    );
                                java.lang.String p2 =
                                  s2.
                                  next(
                                    );
                                if (!p.
                                      equals(
                                        p2)) {
                                    edu.umd.cs.findbugs.BugInstance bug =
                                      new edu.umd.cs.findbugs.BugInstance(
                                      this,
                                      pattern,
                                      priority).
                                      addClass(
                                        m.
                                          getClassName(
                                            )).
                                      addMethod(
                                        m).
                                      addClass(
                                        m2.
                                          getClassName(
                                            )).
                                      describe(
                                        edu.umd.cs.findbugs.ClassAnnotation.
                                          SUPERCLASS_ROLE).
                                      addMethod(
                                        m2).
                                      describe(
                                        edu.umd.cs.findbugs.MethodAnnotation.
                                          METHOD_DID_YOU_MEAN_TO_OVERRIDE).
                                      addFoundAndExpectedType(
                                        p,
                                        p2);
                                    if (m3 !=
                                          null) {
                                        bug.
                                          addMethod(
                                            m3).
                                          describe(
                                            edu.umd.cs.findbugs.MethodAnnotation.
                                              METHOD_OVERRIDDEN);
                                    }
                                    propertySet.
                                      decorateBugInstance(
                                        bug);
                                    bugReporter.
                                      reportBug(
                                        bug);
                                }
                            }
                        }
                    return true;
                }
            }
            catch (java.lang.ClassNotFoundException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  reportMissingClass(
                    e);
            }
        }
        return false;
    }
    private boolean allAbstract(java.util.Set<edu.umd.cs.findbugs.ba.XMethod> overrides) {
        boolean allAbstract =
          true;
        for (edu.umd.cs.findbugs.ba.XMethod m4
              :
              overrides) {
            if (!m4.
                  isAbstract(
                    )) {
                allAbstract =
                  false;
            }
        }
        return allAbstract;
    }
    private boolean checkNonSuper(edu.umd.cs.findbugs.ba.XMethod m,
                                  java.util.Set<edu.umd.cs.findbugs.ba.XMethod> others) {
        if (m.
              isStatic(
                )) {
            return false;
        }
        if (m.
              getName(
                ).
              startsWith(
                "<init>") ||
              m.
              getName(
                ).
              startsWith(
                "<clinit>")) {
            return false;
        }
        for (edu.umd.cs.findbugs.ba.XMethod m2
              :
              others) {
            if (confusingMethodNamesWrongCapitalization(
                  m,
                  m2)) {
                edu.umd.cs.findbugs.ba.XMethod mm1;
                edu.umd.cs.findbugs.ba.XMethod mm2;
                if (m.
                      compareTo(
                        m2) <
                      0) {
                    mm1 =
                      m;
                    mm2 =
                      m2;
                }
                else {
                    mm1 =
                      m2;
                    mm2 =
                      m;
                }
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "NM_CONFUSING",
                      LOW_PRIORITY).
                      addClass(
                        mm1.
                          getClassName(
                            )).
                      addMethod(
                        mm1).
                      addClass(
                        mm2.
                          getClassName(
                            )).
                      addMethod(
                        mm2));
                return true;
            }
        }
        return false;
    }
    @java.lang.Override
    public void report() { for (java.util.Map.Entry<java.lang.String,java.util.TreeSet<edu.umd.cs.findbugs.ba.XMethod>> e
                                 :
                                 canonicalToXMethod.
                                  entrySet(
                                    )) { java.util.TreeSet<edu.umd.cs.findbugs.ba.XMethod> conflictingMethods =
                                           e.
                                           getValue(
                                             );
                                         java.util.HashSet<java.lang.String> trueNames =
                                           new java.util.HashSet<java.lang.String>(
                                           );
                                         for (edu.umd.cs.findbugs.ba.XMethod m
                                               :
                                               conflictingMethods) {
                                             trueNames.
                                               add(
                                                 m.
                                                   getName(
                                                     ) +
                                                 m.
                                                   getSignature(
                                                     ));
                                         }
                                         if (trueNames.
                                               size(
                                                 ) <=
                                               1) {
                                             continue;
                                         }
                                         for (java.util.Iterator<edu.umd.cs.findbugs.ba.XMethod> j =
                                                conflictingMethods.
                                                iterator(
                                                  );
                                              j.
                                                hasNext(
                                                  );
                                              ) {
                                             if (checkSuper(
                                                   j.
                                                     next(
                                                       ),
                                                   conflictingMethods)) {
                                                 j.
                                                   remove(
                                                     );
                                             }
                                         }
                                         for (edu.umd.cs.findbugs.ba.XMethod conflictingMethod
                                               :
                                               conflictingMethods) {
                                             if (checkNonSuper(
                                                   conflictingMethod,
                                                   conflictingMethods)) {
                                                 break;
                                             }
                                         }
                           } }
    public java.lang.String stripPackageName(java.lang.String className) {
        if (className.
              indexOf(
                '.') >=
              0) {
            return className.
              substring(
                className.
                  lastIndexOf(
                    '.') +
                  1);
        }
        else
            if (className.
                  indexOf(
                    '/') >=
                  0) {
                return className.
                  substring(
                    className.
                      lastIndexOf(
                        '/') +
                      1);
            }
            else {
                return className;
            }
    }
    public boolean sameSimpleName(java.lang.String class1,
                                  java.lang.String class2) {
        return class1 !=
          null &&
          class2 !=
          null &&
          stripPackageName(
            class1).
          equals(
            stripPackageName(
              class2));
    }
    @java.lang.Override
    public void visitJavaClass(org.apache.bcel.classfile.JavaClass obj) {
        if (edu.umd.cs.findbugs.bcel.BCELUtil.
              isSynthetic(
                obj)) {
            return;
        }
        java.lang.String name =
          obj.
          getClassName(
            );
        if (!visited.
              add(
                name)) {
            return;
        }
        java.lang.String superClassName =
          obj.
          getSuperclassName(
            );
        if (!"java.lang.Object".
              equals(
                name)) {
            if (sameSimpleName(
                  superClassName,
                  name)) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "NM_SAME_SIMPLE_NAME_AS_SUPERCLASS",
                      HIGH_PRIORITY).
                      addClass(
                        name).
                      addClass(
                        superClassName));
            }
            for (java.lang.String interfaceName
                  :
                  obj.
                   getInterfaceNames(
                     )) {
                if (sameSimpleName(
                      interfaceName,
                      name)) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "NM_SAME_SIMPLE_NAME_AS_INTERFACE",
                          NORMAL_PRIORITY).
                          addClass(
                            name).
                          addClass(
                            interfaceName));
                }
            }
        }
        if (obj.
              isInterface(
                )) {
            return;
        }
        if ("java.lang.Object".
              equals(
                superClassName) &&
              !visited.
              contains(
                superClassName)) {
            try {
                visitJavaClass(
                  obj.
                    getSuperClass(
                      ));
            }
            catch (java.lang.ClassNotFoundException e) {
                
            }
        }
        super.
          visitJavaClass(
            obj);
    }
    private static boolean mightInheritFromException(edu.umd.cs.findbugs.classfile.ClassDescriptor d) {
        while (d !=
                 null) {
            try {
                if ("java.lang.Exception".
                      equals(
                        d.
                          getDottedClassName(
                            ))) {
                    return true;
                }
                edu.umd.cs.findbugs.ba.XClass classNameAndInfo =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getClassAnalysis(
                    edu.umd.cs.findbugs.ba.XClass.class,
                    d);
                d =
                  classNameAndInfo.
                    getSuperclassDescriptor(
                      );
            }
            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                return true;
            }
        }
        return false;
    }
    boolean hasBadMethodNames;
    boolean hasBadFieldNames;
    private boolean isEclipseNLS;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        java.lang.String name =
          obj.
          getClassName(
            );
        java.lang.String[] parts =
          name.
          split(
            "[$+.]");
        baseClassName =
          parts[parts.
                  length -
                  1];
        for (java.lang.String p
              :
              name.
               split(
                 "[.]")) {
            if (p.
                  length(
                    ) ==
                  1) {
                return;
            }
        }
        if (name.
              indexOf(
                "Proto$") >=
              0) {
            return;
        }
        classIsPublicOrProtected =
          obj.
            isPublic(
              ) ||
            obj.
            isProtected(
              );
        if (java.lang.Character.
              isLetter(
                baseClassName.
                  charAt(
                    0)) &&
              !java.lang.Character.
              isUpperCase(
                baseClassName.
                  charAt(
                    0)) &&
              baseClassName.
              indexOf(
                '_') ==
              -1) {
            int priority =
              classIsPublicOrProtected
              ? NORMAL_PRIORITY
              : LOW_PRIORITY;
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NM_CLASS_NAMING_CONVENTION",
                  priority).
                  addClass(
                    this));
        }
        if (name.
              endsWith(
                "Exception")) {
            if (!mightInheritFromException(
                   edu.umd.cs.findbugs.classfile.DescriptorFactory.
                     createClassDescriptor(
                       obj))) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "NM_CLASS_NOT_EXCEPTION",
                      NORMAL_PRIORITY).
                      addClass(
                        this));
            }
        }
        int badFieldNames =
          0;
        for (org.apache.bcel.classfile.Field f
              :
              obj.
               getFields(
                 )) {
            if (f.
                  getName(
                    ).
                  length(
                    ) >=
                  2 &&
                  badFieldName(
                    f)) {
                badFieldNames++;
            }
        }
        hasBadFieldNames =
          badFieldNames >
            3 &&
            badFieldNames >
            obj.
              getFields(
                ).
              length /
            3;
        int badMethodNames =
          0;
        for (org.apache.bcel.classfile.Method m
              :
              obj.
               getMethods(
                 )) {
            if (badMethodName(
                  m.
                    getName(
                      ))) {
                badMethodNames++;
            }
        }
        hasBadMethodNames =
          badMethodNames >
            3 &&
            badMethodNames >
            obj.
              getMethods(
                ).
              length /
            3;
        isEclipseNLS =
          "org.eclipse.osgi.util.NLS".
            equals(
              obj.
                getSuperclassName(
                  ));
        super.
          visit(
            obj);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) {
        if (getFieldName(
              ).
              length(
                ) ==
              1) {
            return;
        }
        if (isEclipseNLS) {
            int flags =
              obj.
              getAccessFlags(
                );
            if ((flags &
                   ACC_STATIC) !=
                  0 &&
                  (flags &
                     ACC_PUBLIC) !=
                  0 &&
                  "Ljava/lang/String;".
                  equals(
                    getFieldSig(
                      ))) {
                return;
            }
        }
        if (badFieldName(
              obj)) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NM_FIELD_NAMING_CONVENTION",
                  classIsPublicOrProtected &&
                    (obj.
                       isPublic(
                         ) ||
                       obj.
                       isProtected(
                         )) &&
                    !hasBadFieldNames
                    ? NORMAL_PRIORITY
                    : LOW_PRIORITY).
                  addClass(
                    this).
                  addVisitedField(
                    this));
        }
    }
    private boolean badFieldName(org.apache.bcel.classfile.Field obj) {
        java.lang.String fieldName =
          obj.
          getName(
            );
        return !obj.
          isFinal(
            ) &&
          java.lang.Character.
          isLetter(
            fieldName.
              charAt(
                0)) &&
          !java.lang.Character.
          isLowerCase(
            fieldName.
              charAt(
                0)) &&
          fieldName.
          indexOf(
            '_') ==
          -1 &&
          java.lang.Character.
          isLetter(
            fieldName.
              charAt(
                1)) &&
          java.lang.Character.
          isLowerCase(
            fieldName.
              charAt(
                1));
    }
    private static final java.util.regex.Pattern
      sigType =
      java.util.regex.Pattern.
      compile(
        "L([^;]*/)?([^/]+;)");
    @javax.annotation.CheckForNull
    private static java.lang.String getSignatureOfOuterClass(org.apache.bcel.classfile.JavaClass obj) {
        for (org.apache.bcel.classfile.Field f
              :
              obj.
               getFields(
                 )) {
            if (f.
                  getName(
                    ).
                  startsWith(
                    "this$")) {
                return f.
                  getSignature(
                    );
            }
        }
        return null;
    }
    private boolean markedAsNotUsable(org.apache.bcel.classfile.Method obj) {
        for (org.apache.bcel.classfile.Attribute a
              :
              obj.
               getAttributes(
                 )) {
            if (a instanceof org.apache.bcel.classfile.Deprecated) {
                return true;
            }
        }
        org.apache.bcel.classfile.Code code =
          obj.
          getCode(
            );
        if (code ==
              null) {
            return false;
        }
        byte[] codeBytes =
          code.
          getCode(
            );
        if (codeBytes.
              length >
              1 &&
              codeBytes.
                length <
              10) {
            int lastOpcode =
              codeBytes[codeBytes.
                          length -
                          1] &
              255;
            if (lastOpcode !=
                  ATHROW) {
                return false;
            }
            for (int b
                  :
                  codeBytes) {
                if ((b &
                       255) ==
                      RETURN) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    @javax.annotation.CheckForNull
    private static org.apache.bcel.classfile.Method findVoidConstructor(org.apache.bcel.classfile.JavaClass clazz) {
        for (org.apache.bcel.classfile.Method m
              :
              clazz.
               getMethods(
                 )) {
            if (isVoidConstructor(
                  clazz,
                  m)) {
                return m;
            }
        }
        return null;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        java.lang.String mName =
          getMethodName(
            );
        if (mName.
              length(
                ) ==
              1) {
            return;
        }
        if ("isRequestedSessionIdFromURL".
              equals(
                mName) ||
              "isRequestedSessionIdFromUrl".
              equals(
                mName)) {
            return;
        }
        java.lang.String sig =
          getMethodSig(
            );
        if (mName.
              equals(
                baseClassName) &&
              "()V".
              equals(
                sig)) {
            org.apache.bcel.classfile.Code code =
              obj.
              getCode(
                );
            org.apache.bcel.classfile.Method realVoidConstructor =
              findVoidConstructor(
                getThisClass(
                  ));
            if (code !=
                  null &&
                  !markedAsNotUsable(
                     obj)) {
                int priority =
                  NORMAL_PRIORITY;
                if (codeDoesSomething(
                      code)) {
                    priority--;
                }
                else
                    if (!obj.
                          isPublic(
                            ) &&
                          getThisClass(
                            ).
                          isPublic(
                            )) {
                        priority--;
                    }
                boolean instanceMembers =
                  false;
                for (org.apache.bcel.classfile.Method m
                      :
                      this.
                       getThisClass(
                         ).
                       getMethods(
                         )) {
                    if (!m.
                          isStatic(
                            ) &&
                          m !=
                          obj &&
                          !isVoidConstructor(
                             getThisClass(
                               ),
                             m)) {
                        instanceMembers =
                          true;
                    }
                }
                for (org.apache.bcel.classfile.Field f
                      :
                      this.
                       getThisClass(
                         ).
                       getFields(
                         )) {
                    if (!f.
                          isStatic(
                            )) {
                        instanceMembers =
                          true;
                    }
                }
                if (!codeDoesSomething(
                       code) &&
                      !instanceMembers &&
                      "java/lang/Object".
                      equals(
                        getSuperclassName(
                          ))) {
                    priority +=
                      2;
                }
                if (hasBadMethodNames) {
                    priority++;
                }
                if (!getXClass(
                       ).
                      getAnnotations(
                        ).
                      isEmpty(
                        )) {
                    priority++;
                }
                if (realVoidConstructor !=
                      null) {
                    priority =
                      LOW_PRIORITY;
                }
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "NM_METHOD_CONSTRUCTOR_CONFUSION",
                      priority).
                      addClassAndMethod(
                        this).
                      lowerPriorityIfDeprecated(
                        ));
                return;
            }
        }
        else
            if (badMethodName(
                  mName)) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "NM_METHOD_NAMING_CONVENTION",
                      classIsPublicOrProtected &&
                        (obj.
                           isPublic(
                             ) ||
                           obj.
                           isProtected(
                             )) &&
                        !hasBadMethodNames
                        ? NORMAL_PRIORITY
                        : LOW_PRIORITY).
                      addClassAndMethod(
                        this));
            }
        if (obj.
              isAbstract(
                )) {
            return;
        }
        if (obj.
              isPrivate(
                )) {
            return;
        }
        if ("equal".
              equals(
                mName) &&
              "(Ljava/lang/Object;)Z".
              equals(
                sig)) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NM_BAD_EQUAL",
                  HIGH_PRIORITY).
                  addClassAndMethod(
                    this).
                  lowerPriorityIfDeprecated(
                    ));
            return;
        }
        if ("hashcode".
              equals(
                mName) &&
              "()I".
              equals(
                sig)) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NM_LCASE_HASHCODE",
                  HIGH_PRIORITY).
                  addClassAndMethod(
                    this).
                  lowerPriorityIfDeprecated(
                    ));
            return;
        }
        if ("tostring".
              equals(
                mName) &&
              "()Ljava/lang/String;".
              equals(
                sig)) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NM_LCASE_TOSTRING",
                  HIGH_PRIORITY).
                  addClassAndMethod(
                    this).
                  lowerPriorityIfDeprecated(
                    ));
            return;
        }
        if (obj.
              isPrivate(
                ) ||
              obj.
              isStatic(
                ) ||
              "<init>".
              equals(
                mName)) {
            return;
        }
        java.lang.String sig2 =
          removePackageNamesFromSignature(
            sig);
        java.lang.String allSmall =
          mName.
          toLowerCase(
            ) +
        sig2;
        edu.umd.cs.findbugs.ba.XMethod xm =
          getXMethod(
            );
        {
            java.util.TreeSet<edu.umd.cs.findbugs.ba.XMethod> s =
              canonicalToXMethod.
              get(
                allSmall);
            if (s ==
                  null) {
                s =
                  new java.util.TreeSet<edu.umd.cs.findbugs.ba.XMethod>(
                    );
                canonicalToXMethod.
                  put(
                    allSmall,
                    s);
            }
            s.
              add(
                xm);
        }
    }
    private static boolean isVoidConstructor(org.apache.bcel.classfile.JavaClass clazz,
                                             org.apache.bcel.classfile.Method m) {
        java.lang.String outerClassSignature =
          getSignatureOfOuterClass(
            clazz);
        if (outerClassSignature ==
              null) {
            outerClassSignature =
              "";
        }
        return "<init>".
          equals(
            m.
              getName(
                )) &&
          m.
          getSignature(
            ).
          equals(
            "(" +
            outerClassSignature +
            ")V");
    }
    private boolean badMethodName(java.lang.String mName) {
        return mName.
          length(
            ) >=
          2 &&
          java.lang.Character.
          isLetter(
            mName.
              charAt(
                0)) &&
          !java.lang.Character.
          isLowerCase(
            mName.
              charAt(
                0)) &&
          java.lang.Character.
          isLetter(
            mName.
              charAt(
                1)) &&
          java.lang.Character.
          isLowerCase(
            mName.
              charAt(
                1)) &&
          mName.
          indexOf(
            '_') ==
          -1;
    }
    private boolean codeDoesSomething(org.apache.bcel.classfile.Code code) {
        byte[] codeBytes =
          code.
          getCode(
            );
        return codeBytes.
                 length >
          1;
    }
    private static java.lang.String removePackageNamesFromSignature(java.lang.String sig) {
        int end =
          sig.
          indexOf(
            ')');
        java.util.regex.Matcher m =
          sigType.
          matcher(
            sig.
              substring(
                0,
                end));
        return m.
          replaceAll(
            "L$2") +
        sig.
          substring(
            end);
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
       "vBs6tex5J3QSFcB93ju/v/+c3ym4/AZwMXuTZM77nSul4qZVDHmuKF/Ii6/b" +
       "S2g31VfBvyvg+qv8yuvzil0gfqyzzwaePU4HPBCmXiNLoVakRyAoaUeW8kih" +
       "TDn2w10Ot3N7eYnkRXu3XuNC5XnHWWgvgovbQ+MugEZfBC2/x0FmVKTtZMgV" +
       "7owNQNzIg6mmXq6PXGDYwNkm+ywOevmxL64/+ls/vsvQzivfuc7aBz78t756" +
       "+KEPH5zKi5+/JjU9PWaXGxckv6agOzfn5y5bpRjR+1+ffPmf/MjL799R9djZ" +
       "LA8Hm5gf/9xf/urhD/zmL18n0bhHdl1Lk5xzIhrepIgUcL13L6L3XiCib76B" +
       "iB4DmZjrGAqIue5suNsdBKW3XiwcPpbD6FRy/kHjY7/2mT9++D07PpyVarE/" +
       "2w89P+7zv3FH9YHohe8uAu+duUoXST0wxTDvGZWevXivV8y1E9kDJ1ZUur4V" +
       "PXHit/de9rBQS89Lj2znWkecN+hn9OD6jLiqkPZV/qc///56IeaHEwOkCZoq" +
       "7LegZ8PiSar40plt6XVZdVX5rU9+8NPP/Y74eLHf2HElJwsFITX/H9uryR2F" +
       "muRCPQAEv3gBwXuKiih+Vfm2j/7Vr/32y1/45TtKd4MEK/eQUgD2GmAzc3jR" +
       "Nv30BC8I4K4LRgHP+dBuNHA4hXD3QnzsuPY4V4xKb79o7sLmz6WU+UbXcjda" +
       "0HZjRy2Cx1nPfH/seadbC3V48FbU4dtBDvQK2HeMfm96pccK1X/oxAHn5n+6" +
       "EZj84x26xfNXhTmHXxVbY7LVpvFCyXKPfkW8jhffRbCdjr7rZmDts9HLtHzf" +
       "JW94uWhenVGpK4VKHRwnYvatLJ8PjYuVCqgF6vSYqKevl+DJ0uHeF51JY/Yh" +
       "084L/2TeHQup3bx5SZwbdc7NvvMm3SwCru/YS/M7LnCzH7yBm71n7xhuXpq5" +
       "kt5AmvsuecNHbrc0zy9/zPWPnJbmK+D6h1451x/La98Kru/cc/07L+D6D12f" +
       "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" +
       "XWbKR+hgBfYTJhna3YxfO9UevpTcABPo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
