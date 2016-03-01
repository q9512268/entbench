package edu.umd.cs.findbugs.detect;
public class XMLFactoryBypass extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    private static final java.util.Set<java.lang.String> xmlInterfaces = new java.util.HashSet<java.lang.String>(
      ) {
        static final long
          serialVersionUID =
          -9117982073509840017L;
        {
            add(
              "javax.xml.parsers.DocumentBuilder");
            add(
              "org.w3c.dom.Document");
            add(
              "javax.xml.parsers.SAXParser");
            add(
              "org.xml.sax.XMLReader");
            add(
              "org.xml.sax.XMLFilter");
            add(
              "javax.xml.transform.Transformer");
            add(
              "org.w3c.dom.Attr");
            add(
              "org.w3c.dom.CDATASection");
            add(
              "org.w3c.dom.Comment");
            add(
              "org.w3c.dom.Element");
            add(
              "org.w3c.dom.Text");
        }
    };
    private final java.util.Set<java.lang.String> rejectedXMLClasses =
      new java.util.HashSet<java.lang.String>(
      );
    private org.apache.bcel.classfile.JavaClass curClass;
    public XMLFactoryBypass(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        curClass =
          classContext.
            getJavaClass(
              );
        super.
          visitClassContext(
            classContext);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { try { if (seen == INVOKESPECIAL) {
                                                java.lang.String newClsName =
                                                  getClassConstantOperand(
                                                    );
                                                if (rejectedXMLClasses.
                                                      contains(
                                                        newClsName)) {
                                                    return;
                                                }
                                                rejectedXMLClasses.
                                                  add(
                                                    newClsName);
                                                if (newClsName.
                                                      startsWith(
                                                        "java/") ||
                                                      newClsName.
                                                      startsWith(
                                                        "javax/")) {
                                                    return;
                                                }
                                                if (newClsName.
                                                      endsWith(
                                                        "Adapter")) {
                                                    return;
                                                }
                                                if (!"<init>".
                                                      equals(
                                                        getNameConstantOperand(
                                                          ))) {
                                                    return;
                                                }
                                                java.lang.String invokerClsName =
                                                  this.
                                                  getClassName(
                                                    );
                                                if (samePackageBase(
                                                      invokerClsName,
                                                      newClsName)) {
                                                    return;
                                                }
                                                org.apache.bcel.classfile.JavaClass newCls =
                                                  org.apache.bcel.Repository.
                                                  lookupClass(
                                                    getDottedClassConstantOperand(
                                                      ));
                                                org.apache.bcel.classfile.JavaClass superCls =
                                                  curClass.
                                                  getSuperClass(
                                                    );
                                                if (superCls.
                                                      getClassName(
                                                        ).
                                                      equals(
                                                        newClsName.
                                                          replace(
                                                            '/',
                                                            '.'))) {
                                                    return;
                                                }
                                                org.apache.bcel.classfile.JavaClass[] infs =
                                                  newCls.
                                                  getAllInterfaces(
                                                    );
                                                for (org.apache.bcel.classfile.JavaClass inf
                                                      :
                                                      infs) {
                                                    if (xmlInterfaces.
                                                          contains(
                                                            inf.
                                                              getClassName(
                                                                ))) {
                                                        bugReporter.
                                                          reportBug(
                                                            new edu.umd.cs.findbugs.BugInstance(
                                                              this,
                                                              "XFB_XML_FACTORY_BYPASS",
                                                              LOW_PRIORITY).
                                                              addClassAndMethod(
                                                                this).
                                                              addSourceLine(
                                                                this));
                                                        rejectedXMLClasses.
                                                          remove(
                                                            newClsName);
                                                    }
                                                }
                                            }
                                      }
                                      catch (java.lang.ClassNotFoundException cnfe) {
                                          bugReporter.
                                            reportMissingClass(
                                              cnfe);
                                      } }
    public boolean samePackageBase(java.lang.String invokerClsName,
                                   java.lang.String newClsName) {
        java.lang.String[] invokerParts =
          invokerClsName.
          split(
            "/");
        java.lang.String[] newClsParts =
          newClsName.
          split(
            "/");
        if (newClsParts.
              length <
              3) {
            return false;
        }
        if (invokerParts.
              length <
              3) {
            return false;
        }
        if (!invokerParts[0].
              equals(
                newClsParts[0])) {
            return false;
        }
        return invokerParts[1].
          equals(
            newClsParts[1]);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0NcGOw0YQzXslb7V/gsAPV31ESIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sm9km3XP8+u9BTIgWvkqNnvMImqsliSdV2WiI410s7NtG3Ib8mVX0bIFM++0" +
       "Ma8qI+2en7WFvr2dhkMzmC8zQFrbbW2pGmEtFMWxhCraHnuy4EakCPs9yZB9" +
       "yRjVYRoOsmGyauZbfTHsqIk1Zzxq60zmTMSaE2C4XiI4hBGLkilGvXgYiiu+" +
       "P646aZK0qG066FK2J+0g2adNycsUayC7jDvOYoaigx4Wr+2pb4vuKF9ncIwR" +
       "CzFj+Zo17zW4daD46HLAVbdSgE+SebwzPXs0sseLIA6UVFjaNDG0NTxDYUYW" +
       "MFlIldFgxtRoTRbQ1pLxSJfJa7P+QshXPQ/LI0jEjc103ZZZ3cnXI2YQoAkH" +
       "UeOZO1a6zGDcm9gLFkV6K0rabeX5zKO740ljw7YTDmnqHdeOJYZfU9PNNLEG" +
       "7EojLIEZU3Awx6sKM4HGvTUO486uZeAagmExPUPbHSqbbzdGNfP9NhJKoxbp" +
       "wAI/1kI3UTmO8LfQgEkchrMdTVEQKWXFISvBuDBwDEYjG+G2P9V01lw1xqsB" +
       "raWLdZ3mPXnTi3VzPiIsp1YXJmMGz2MBtSTF5fM2zjY3ntLSSNPadtdramhv" +
       "ptwGSlcSNeHE/hBZtfu9sQHTGKeOBAR18Fkd5fxsKaliczkYTREV5M6rRltL" +
       "Bkk9G438LWPnMY9Na0nfrm8kyGhSth2LWK/jDvVIyJO404tqtUHcJzc2jVTp" +
       "Xc6G3TrcIKcLzO41gmoo84pMMUEn2ip2OluZu9mgpsJcQgujeK0E4q6x8JAd" +
       "SXZrXVEmLMTXqIVnpMrKNBejzsaowfV2c6cnSyndwlLN08cbR9qMZ3pT7QSx" +
       "o3rrSaAlE0SgJbkbdavTlB0SApLCtAzjQ6WOom11EvNZBw9MHua2SbhtQFCs" +
       "kPy2ig9nNX9A9xmcnaDpbDvR0eZ85gwcn1LplIcaXO7EKy9k4I4wbo0NwZGm" +
       "wmrsWpDCpK2Zw2WUAflpivb7LEysYWUIPH5Zk/w0i+TtrpnKnoWNAhjqx1VN" +
       "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" +
       "m//iKdP6RFK5Lwts/cTmPv+GRwu3Tp1i");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ZEYU2brxhscGp0ksCz5zVrLFyS1+KFn8L1+y51i+Yvt7Kf7m60jxq8XrN4DF" +
       "x8qGDbVAL+3i108k9S/uKami+Ev/LzJ5/Mh300OZpH85Mrl8cvJSYo1btvr9" +
       "15HC14vX15LKjRi4yuFtQ1Q5PJg5J9ZrahC4huKfiOh332gL+sx1iaRy8/xt" +
       "r+Lqyltfc7V0fx1S+/wrN66/5RXh35YXno6vLD5AVa4vU9c9fYPg1PfVMDKW" +
       "dsnbA/v7BGH584dJ5Yl7X0NLKlf3HyXV/2Hf5T8llccv6JKA+Q8/T7f+dlJ5" +
       "8KR1Urmsnan+DpDfYTUwUPA+XflfQRGoLD7/W3jkh++68GLOFlAJbHWqAVy1" +
       "fbNfUh1E+aWz0H+soltvpKJT0eK5ex5o0+n+avBd7QuvkMz7vtf6lf1tLs1V" +
       "drtilOtU5dr+Ytkxpj9zz9GOxro6fP77j/7qA+84ij+P7gk+sf1TtD118dWp" +
       "gRcm5WWn3a+/5R+/+A9e+WZ5BvV/AcJYnZCxLQAA");
}
