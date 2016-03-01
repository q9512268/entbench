package edu.umd.cs.findbugs.detect;
public class DefaultEncodingDetector extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private final edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotationDatabase
      defaultEncodingAnnotationDatabase;
    static class DefaultEncodingAnnotation extends edu.umd.cs.findbugs.ba.AnnotationEnumeration<edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation> {
        public static final edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation
          DEFAULT_ENCODING =
          new edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation(
          "DefaultEncoding",
          1);
        private static final edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation[]
          myValues =
          { DEFAULT_ENCODING };
        public static edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation[] values() {
            return myValues.
              clone(
                );
        }
        private DefaultEncodingAnnotation(java.lang.String s,
                                          int i) {
            super(
              s,
              i);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "sXwBHi9jZYgfFdfRxtQcePTVJ7Oc+qRVVhVMiyR7jB9sJDWcuS2BwXSOHNjg" +
           "AcouJqeDOm/NvP0vj4eG1n+ZEw3tWzTFmYX+vxiMtSK/rf2sPH/T+wv6rxje" +
           "/iUOJ4t9ruBf8qGuQy9sOE+8PcguZDgcZl3keImavSBYrmNi6oo39Tc6vmHm" +
           "tnuA2Z2bvEBBcEuBse/S5mYARpGanntKgen7snMs7ejXXOk44PC2weXZDNd2" +
           "FMC1dAEhBQeV2LblyHfn4Qp+VwpHFAga8l1LsXrw4E37JxM9919so8x6iB3r" +
           "ttBZh8fi7gwPq+ja37Ae+z3HiW2KaBV8WFtXYMUCRvlxgbH7aPMjkGmUwTT9" +
           "b6djjgNTpZnC5ZVleoLm581rNpCs+vLJEkw3L+vel99Viocnq8rmTl71Oodg" +
           "+z6xEqAhacqyu7xwvZdoOk5KTC2VvNjQ2M8jBC3Izx7ojr8wUQ5xkqMAmzlI" +
           "ICHar+7ZPyOo3JlNUFD0DP8CjsvWMJwxoHUPPg5dMEhfn2An8hyJkzWu21Z1" +
           "a03FTw73YevklYPCNXnfk08MDp5fLdoBoGV8spRaeRs88y2fZL8EiV/NhV9c" +
           "cH04oCcvesyEV/te8evYJp2Vuvzqebe7vlwd6a3huiyQaPyEt0qTL//246rd" +
           "uU4H7KuHReqnO/VG0aoKEvoeS1CZ6qICSmiDzqQXfXm/oLC1+DltJm2eTtvx" +
           "tzKXg8eFcE7VUJrj3oOtrZmYmK7rn91U+e13uFxLp1BITOxMxfoeO7VnDTut" +
           "VI1KhkT4lzb+cWuO5+OWfXfa7Pnok1NlMfHMkVtPLH1/YBa7zefaoZxH09yF" +
           "eyxUCzBUC1qFykKPTBYf7GIoJr60Urqs7E+vPcRFy1dAemmuO/D5y+9NnH6h" +
           "CJVAHqdIJOgY8jxB4Xyfy9wLhPrhrQ2ooCKYyakBApk7WGavzfRm7iwJujDf" +
           "2uwaJvvmFw7WY1hfr5pKgi4b8pUfpqa5R3lpmsGBRqrFNj8O0NFnWAo4lr5e" +
           "Ryv/D21lhLXWQbVM0TOdApQ6oXsQYGBWa7Slry/Wf3Vve2ygZXNny/poO3NQ" +
           "DQYD7YzLZ7mzs27uvLQ9kc8NaPdJ1qTTnmqBrYB9nbkLm3QgexLLqXVT5VRX" +
           "adKY18W7TP41NCYemdzUfe25Nffz611whV27LM8o5TfNmTp1ad7V7LVKNjZ9" +
           "NvPo9OU21tdwhp1iZaGrdOgHWTWachb4rj6NUOYG9NTBtU+/vLfkJAT3FhQQ" +
           "wFpbsu8I0poJKLslmn1NZjtGc9MPx69YmfzoTXYLY0Vqff75MXHwjjc6j458" +
           "uo59fJsGgIbT7PKibVzZjMVR3XPnljuwZngCi6Bl2deNUwYSHPoqnB7PR9nc" +
           "sUUJnB7XSbCDVfFpnmGLYtEuTbNuY4sqNRZmG/JX2B+xV9qc/R++jJtFFiEA" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/atXoesUdLNYpVKoKkM3hg4vext5toPb");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("HMh1AdULFPTInhrAQ2moRwb5+EnpyZuaGPqbl/VdPnC48PSmeF1oe1s1xL3E" +
           "VYpun75wMZT4/tnaC3d7zxW66V407aL2yyWY/0r24yH0rr+Atk6EPeoHerxc" +
           "tWeuRwq7OVsJLPsJgurM53c4YUre4TvssINTZGlTPqi8QpZc/nKR/OuS7V/d" +
           "21uR/tplk1sUf7VMzt3uA5gvvdLFwivnHeaJB3n8tTzIGR/73KUmSif7R653" +
           "5C+8PJr86Hebv7B/aAQmPc+PbODB/Zunk7vCZy/t7biv64Pnv/fIFx96x7HX" +
           "fmTP8KnXPcPb2+79qId0/Lh8hpP/8pv+xbv/yctfLy+i/h+ed8UaeywAAA==");
    }
    static class DefaultEncodingAnnotationDatabase extends edu.umd.cs.findbugs.ba.AnnotationDatabase<edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation> {
        public DefaultEncodingAnnotationDatabase() {
            super(
              );
            this.
              setAddClassOnly(
                false);
            this.
              loadAuxiliaryAnnotations(
                );
        }
        java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>
          classes =
          new java.util.HashSet<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
          );
        @java.lang.Override
        protected void addMethodAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                           java.lang.String cName,
                                           java.lang.String mName,
                                           java.lang.String mSig,
                                           boolean isStatic,
                                           edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation annotation) {
            super.
              addMethodAnnotation(
                cName,
                mName,
                mSig,
                isStatic,
                annotation);
            classes.
              add(
                edu.umd.cs.findbugs.classfile.DescriptorFactory.
                  createClassDescriptorFromDottedClassName(
                    cName));
        }
        @java.lang.Override
        public void loadAuxiliaryAnnotations() {
            addMethodAnnotation(
              "java.lang.String",
              "getBytes",
              "()[B",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.lang.String",
              "<init>",
              "([B)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.lang.String",
              "<init>",
              "([BII)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.ByteArrayOutputStream",
              "toString",
              "()Ljava/lang/String;",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.FileReader",
              "<init>",
              "(Ljava/lang/String;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.FileReader",
              "<init>",
              "(Ljava/io/File;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.FileReader",
              "<init>",
              "(Ljava/io/FileDescriptor;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.FileWriter",
              "<init>",
              "(Ljava/lang/String;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.FileWriter",
              "<init>",
              "(Ljava/lang/String;Z)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.FileWriter",
              "<init>",
              "(Ljava/io/File;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.FileWriter",
              "<init>",
              "(Ljava/io/File;Z)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.FileWriter",
              "<init>",
              "(Ljava/io/FileDescriptor;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.InputStreamReader",
              "<init>",
              "(Ljava/io/InputStream;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.OutputStreamWriter",
              "<init>",
              "(Ljava/io/OutputStream;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.PrintStream",
              "<init>",
              "(Ljava/io/File;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.PrintStream",
              "<init>",
              "(Ljava/io/OutputStream;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.PrintStream",
              "<init>",
              "(Ljava/io/OutputStream;Z)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.PrintStream",
              "<init>",
              "(Ljava/lang/String;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.PrintWriter",
              "<init>",
              "(Ljava/io/File;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.PrintWriter",
              "<init>",
              "(Ljava/io/OutputStream;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.PrintWriter",
              "<init>",
              "(Ljava/io/OutputStream;Z)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.io.PrintWriter",
              "<init>",
              "(Ljava/lang/String;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.util.Scanner",
              "<init>",
              "(Ljava/io/File;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.util.Scanner",
              "<init>",
              "(Ljava/io/InputStream;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.util.Scanner",
              "<init>",
              "(Ljava/nio/channels/ReadableByteChannel;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.util.Formatter",
              "<init>",
              "(Ljava/lang/String;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.util.Formatter",
              "<init>",
              "(Ljava/io/File;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
            addMethodAnnotation(
              "java.util.Formatter",
              "<init>",
              "(Ljava/io/OutputStream;)V",
              false,
              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation.
                DEFAULT_ENCODING);
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
          ("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" +
           "w1DOR/WNTQpsx8f18WhF4KNlX+OYcGcgDEVNzC1cb3cFut0dxZYeO+vafj6W" +
           "rVxsWr688RYuh+xya6QlpMRMBUFcsIgw2Jlmo+u2MsKRJ16LWkrsJJB3pOHY" +
           "6nY0aPDNdW2CtfUtQaTb9aY+4E2+ESo61hiv05nIBQLPtVVFYHJ2MIzFJa/u" +
           "MqlWc4tpd0bVNDncqi2l5bF1YYfo8LInkjXYgsPdxs1ye7xV6ttUGdSHNdJM" +
           "lz1T2zAktkfTYWIu0AGyTbBx0e9GSorNE5MZt5yGuiYULOrqqa7YuUPjLXjt" +
           "k3UpxcdibT6eyfo6RqdMQ+yTLb+hslNmnnRT2WqhzWSG9DHUxExPxk2JachU" +
           "O0mZ3abOpMmKXoheto8zYlFvEK0VCP0eS9ry1l4SmZTU3Xo7GmjBJO8Fwtha" +
           "K4tJa7VJV6vO0Mvrmj1QrT3VX7EME8Cel9s7wk+6ZCILVqT4JobptLrsOfY0" +
           "b6B9dpSDyB7U+RXOpbNFlOC4RFN6c0wjZiN3jMSMipzf1mQukrRI4Qc7FtUb" +
           "cazpA7KOJVlaz7KmxUezdAUwdzySillnxCJuramTZsEa82gxzzOcKzJDt1dy" +
           "Qx6aXFaLWdiGMcGSW02nYes+x8SdWdvF6YyeJMLaIuwuUy+MlN81hHmE6fPF" +
           "ZGyycYY1zKYG9h5YnzXUwNhszalADGV4J3nmnkq7oYjUuR7I1ywhG7MwHsA9" +
           "NOaXw9m63tJ3G4IcoRGAx3kHbU86Gxmbmwy1m60mSoA18elyFTULdjU3EXXX" +
           "RX0WX4kBnqvoil/iHRdpY+bUNNOWiIwaO1huzZo6WKtBQrikbR2PetuFYjOD" +
           "BjLmuH1N4nG9k4r4cljjMG/L20tJaO2nZk3fi6QPsKbTREdqY+b2EGRJoKNc" +
           "IChsI+nt1hxHpeaSd/kMbnpb1pZcuT+O2caCQnfyeE5wqMFJaQ1ku4yuiykd" +
           "xgK1rzNuLRjM/V6CoMK6QzdXgqKls5HS4FtqV1NB5C+Wa5WZ+O1doRdTdF3w" +
           "NbZQjZWqziVvTrINLUQIc6wHnQVD4bqwnrQwjuXo3qi2b07RWNFMU4UpBSw+" +
           "SVPoC/vpYp23JRmsKSi3d0Akt0h8PsxZtYYt4xSOURnvSLUGoy6zbdxiJK2L" +
           "myzFhEuYtSbxwmEdcxDNsj4NszWCAit1pLbwjsLT8syJqMmW81N/rfG9RF0O" +
           "hwErC35A2N5wpm86RX0Eq+1ouVeYjF3w6BSh8VnSbnjqzNoWZl9Q952OCZO4" +
           "hudK0G5qWtGVWBRkBVNh1JL6nN/TN3VyHnNjB/cSzuNnHlKoLWGMhEwL4QSe" +
           "jfdTf2sOVHy+H0p1gPm9TpJshn4uzZN8oY3S/iLoGpig1dxgnq5a7Ww58AxZ" +
           "1kdqIclDVVwJu3WXwxYivmjJtY4tex5IGPPaDttakTd24H2q+UJMbXQz4OuZ" +
           "vaW0hVWoLOl43rZrw3o8ZNtTAt60JHiGIn7RNjRWTJNsI4B4Lih+1mts03FD" +
           "KEwzd1l6u2FnccBgdn+HOGuTaq5X4r6/NxQ5jfBWDoesst3lmxYBEIfwGaq1" +
           "m6r6fMPM11HL4kwNoafOrDH399vmKGJncDM0J7gY7oBbESS8il0kjJPtIJxQ" +
           "c5hrDZRQt/BlrbGvw6ga1bJ6y+tidIAj/izbN+1ugsNSoq37RUfb+1jGEWxW" +
           "MD5qJhYceXuquV2nW9OgKCTYzmqMIDEjGF3rCTFpy81a4RcCjyf23DC7Umew" +
           "IHsLurMexHA0HuTSwOB0z1vJbk2We1E8Cdq9sThKhflAQ1mkLaSyk3jSxiEI" +
           "4ofKVxwffWNvmR6vXqidXtFYu3jZ4L6BtyvFnSe8Us11dtBXvTp8GLp00H/+" +
           "oO/8K8Y4gt5xt7sY1fujz3/sxZf08c/Wrx6/j/xIAt1/fEXmbJyrr33gwFf3" +
           "UM6Ocn7tY3/41OyH7Q+9gQPqd11i8vKQ/5R/+Su979f+wVXontODndtuyFwk" +
           "ev7SS+nISNLIn1041HnHqVpvlOpqge/oWK385UOdM1PebqMEeiiMgvKOgKEf" +
           "POLSweR9Vb/7Tn3iUFTN+TnH+HACPbAKAtdQ/ZM3sdxf5C2FirefeY1D039U" +
           "Fj+VQE+oun5QJ3HRfJe4vTcLHP3Mv1+86N+Pnvr3lRNxbpx7lZ4ZUeToxmuE" +
           "xO2Hm1XFpy6e7Zft0rHZpDditiqW72iv8zr54mu0/VJZ/LMEerI8sSXSwnEd" +
           "Ndpd0tk/PlPQy3dVUFn9c29IFUUCPfO691FO9I6+cTcCQf/kbbftDjfEtF98" +
           "6dqDb31J+t3qMsfpLa6HOOhBM3Xd86eo557vDyPDdCq9PXQ4Uw2rn3+VQE/d" +
           "nT0ASIeHSpRfPpD8G+CidyBJwPzHj+d7/7sEevisdwJd1S40/yqIuuPmBLoH" +
           "lOcbvwyqQGP5+JXDyQNz6n0PVDaEDrdL");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("oJPfBPrQX8w9qJWK3G7Qk7tWf+lznJ5xPXcn26zUo9vpSoLfqMhGdz0ILevF" +
           "Uw0+XTZ/4LIGy9avVvH7tcoGH6gGLs/kHjubtDzcuJM9Pgi+bzse7W0He2h/" +
           "Cboqpy9P5sHjiUn+KqY5tcr7Xtcq50hLmlffkGGePUktLqiybP3dyjBfPzPM" +
           "q+cOS5my+J2q7dXvYdKy+veq4tLRaDXCb92p8nOXK69cTHhOofbG651kncuR" +
           "nr3riT+fHu4i39K+8NJg9OHvYD97uAemuep+X47yIAc9cLiSdprMPHPX0U7G" +
           "up997ruPffGh95xkXY8dGD5bq87x9q47X7qivTCprknt/+Vb//kP/txL36jO" +
           "Sf8vHZTE8SIuAAA=");
    }
    public DefaultEncodingDetector(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        this.
          defaultEncodingAnnotationDatabase =
          new edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotationDatabase(
            );
    }
    @java.lang.Override
    public boolean shouldVisit(org.apache.bcel.classfile.JavaClass obj) {
        java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> called =
          getXClass(
            ).
          getCalledClassDescriptors(
            );
        for (edu.umd.cs.findbugs.classfile.ClassDescriptor c
              :
              defaultEncodingAnnotationDatabase.
                classes) {
            if (called.
                  contains(
                    c)) {
                return true;
            }
        }
        return false;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) {
        super.
          visit(
            code);
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (seen) {
                                          case INVOKEVIRTUAL:
                                          case INVOKESPECIAL:
                                          case INVOKESTATIC:
                                              edu.umd.cs.findbugs.ba.XMethod callSeen =
                                                edu.umd.cs.findbugs.ba.XFactory.
                                                createXMethod(
                                                  edu.umd.cs.findbugs.MethodAnnotation.
                                                    fromCalledMethod(
                                                      this));
                                              edu.umd.cs.findbugs.detect.DefaultEncodingDetector.DefaultEncodingAnnotation annotation =
                                                defaultEncodingAnnotationDatabase.
                                                getDirectAnnotation(
                                                  callSeen);
                                              if (annotation !=
                                                    null) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "DM_DEFAULT_ENCODING",
                                                        HIGH_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addCalledMethod(
                                                          this),
                                                      this);
                                              }
                                              break;
                                          default:
                                              break;
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sH1LvGLz9n8BWIdRriIcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aCcwrV3We9yd5L3kJeS8JJDSFkOVBGwz/jD0ej60Axet4" +
       "7Nk8m+2hEGb32LN5Fi9D0wJdQKUCVBKgEkSoAloQm9qiVkWgoC6AQJWoUDep" +
       "gKpKpaVIoKq0Km3pnfG/v/eSRtBamus7995z7jnnnvPdbT72HeimOIJKYeBu" +
       "bTdI9s1Nsj93sf1kG5rx/oDCODWKTaPtqnEsgrJH9Qc/den7P3jn7PIedF6B" +
       "7lJ9P0jUxAn8mDfjwF2ZBgVdOi7tuqYXJ9Blaq6uVDhNHBemnDh5hIJuPUGa" +
       "QFeoQxFgIAIMRIALEeDmcStA9BzTT712TqH6SbyEfh46R0HnQz0XL4EeOM0k" +
       "VCPVO2DDFRoADjfn7zJQqiDeRND9R7rvdL5K4SdK8OPved3l37kBuqRAlxxf" +
       "yMXRgRAJ6ESBbvNMTzOjuGkYpqFAd/imaQhm5KiukxVyK9CdsWP7apJG5pGR" +
       "8sI0NKOiz2PL3abnukWpngTRkXqWY7rG4dtNlqvaQNe7j3XdadjLy4GCFx0g" +
       "WGSpunlIcuPC8Y0EetFZiiMdrwxBA0B6wTOTWXDU1Y2+CgqgO3dj56q+DQtJ" +
       "5Pg2aHpTkIJeEuje6zLNbR2q+kK1zUcT6Pln23G7KtDqlsIQOUkCPe9ss4IT" +
       "GKV7z4zSifH5DvOKt7/B7/t7hcyGqbu5/DcDovvOEPGmZUamr5s7wtteSr1b" +
       "vfuzb92DIND4eWca79r8/s9979Uvu++pL+7a/OQ12rDa3NSTR/UPard/9QXt" +
       "hxs35GLcHAaxkw/+Kc0L9+cOah7ZhCDy7j7imFfuH1Y+xf/p9I0fNb+9B10k" +
       "ofN64KYe8KM79MALHdeMCNM3IzUxDRK6xfSNdlFPQhdAnnJ8c1fKWlZsJiR0" +
       "o1sUnQ+Kd2AiC7DITXQB5B3fCg7zoZrMivwmhCDoAnig28DzMLT7Ff8J5MCz" +
       "wDNhVVd9xw9gLgpy/WPY9BMN2HYGW8CZtNSO4TjS4cJ1TCOFU8+A9fi40jAT" +
       "QAZ3TEtN3aTr64EBPKtTlAbRfk4X/n92tsk1v7w+dw4MygvOQoILoqkfuIYZ" +
       "Pao/nra63/vEo1/eOwqRA5slUAX0vQ/63tfj/cO+93d971+nb+jcuaLL5+Yy" +
       "7HwAjOACYAFAydseFl47eP1bH7wBOF+4vhGYP28KXx+s28foQRYYqQMXhp56" +
       "7/pN8i8ge9DeadTN5QZFF3NyLsfKI0y8cjbarsX30lu+9f1Pvvux4DjuTsH4" +
       "ARxcTZmH84NnLRwFOjBeZB6zf+n96qcf/exjV/agGwFGAFxMVODHAHLuO9vH" +
       "qbB+5BAic11uAgpbQeSpbl51iGsXk1kUrI9LiqG/vcjfAWx8a+7nD4LnHQeO" +
       "X/zntXeFefrcnavkg3ZGiwKCXymE7/+rP/tHtDD3IVpfOjH/CWbyyAmEyJld" +
       "KrDgjmMfECPTBO3+9r3cu574zlteUzgAaPHQtTq8kqdtgAxgCIGZf/mLy7/+" +
       "xtc/+LW9Y6dJwBSZaq6jb46UzMuhi0+jJOjtJcfyAIRxgb/mXnNF8j3gwpaj" +
       "aq6Ze+l/Xnpx+dP//PbLOz9wQcmhG73smRkcl/9EC3rjl1/3b/cVbM7p+Qx3" +
       "bLPjZjvYvOuYczOK1G0ux+ZNf/7C3/iC+n4AwAD0YiczCxw7dxA4uVDPA7Pg" +
       "tWK0ldq8GQYRmNKKwYWL1i8t0v3cMAUPqKhD8+RF8ckgOR2HJ1Ysj+rv/Np3" +
       "nyN/93PfK7Q6veQ56RO0Gj6yc8M8uX8D2N9zFhH6ajwD7apPMT972X3qB4Cj" +
       "AjjqYJ6P2QhA0+aUBx20vunC33z+j+5+/VdvgPZ60EU3UI2eWgQjdAuIAjOe" +
       "AVTbhD/z6p0TrG8GyeVCVegq5XfO8/ziLV80Pnx9HOrlK5bjUH7+f7Cu9ua/" +
       "+/erjFAg0DUm6jP0Cvyx993bftW3C/pjKMip79tcDddgdXdMW/mo9697D57/" +
       "kz3oggJd1g+WjrLqpnmAKWC5FB+uJ8Hy8lT96aXPbp5/5AjqXnAWhk50exaE" +
       "jqcJkM9b5/mLZ3DnztzKCHhKByFZOos756Ai0yxIHijSK3nyU8WY7CXQhTBy" +
       "VmBdkIDuHV91D+L9h+B3Djz/nT8507xgN5vf2T5YUtx/tKYIwUx2OwiLpq6n" +
       "Xuqqh0tREDwPXid4TjTdYWOeVvOktRMBv66HveK0/jJ4Xn6g/8uvoz9zHf3z" +
       "bDdPeoVlCbAhME7Puseh2VETVVNj81Az8dlP3Vc6z8T8jC3YZ7RFIfbmHADs" +
       "myr7+D6Sv4+vre0NefanAbLHxXbklNr3zF39yuHAymBvAmS6MnfxQ2UvFzCR" +
       "e/X+bkF/RlDify0ogIHbj5lRAdgbvO3v3/mVdzz0DRCrA+imVR5HIERP9Mik" +
       "+XbpVz72xAtvffybbytmKQDPwsPav7w656o+nbp58ppTqt6bqyoEaaSblBon" +
       "dDGxmEah7dNCFBc5Hph/Vwd7AfixO7+xeN+3Pr5b55/FozONzbc+/qs/3H/7" +
       "43sndlcPXbXBOUmz22EVQj/nwMIR9MDT9VJQ9P7hk4995rcfe8tOqjtP7xW6" +
       "YCv88b/4r6/sv/ebX7rGYvRGN/gRBja5/QP9akw2D39UWTGrG0neLGAaTkpx" +
       "u2RiWr8ZJ521Z3djwt0O1x18iAR9I+6LMi/7LNpPvEZ9aJhbGPWjGBeQJBF4" +
       "UXKoUc+xERcecargzVrTGiOrYqeLLDU5pCaqjCwZL5iNp4G3YVRqjGcrNEuy" +
       "ftbeCuUuts0aawzLVhZrwFEDRf1s4EUhvd4KIiea5JYj9O3QGC/rLhaMF40c" +
       "yl0tGDdGYE/ehT0Ud/VKFCz5us2MGKmSinwbHYdiS05sjaS644xlpIXilT2R" +
       "niorQc28jttO1UHUrAjbqT/2O/KY71HYwN0shEaPzkZ8EGI1VUg6fmTM3DXt" +
       "xC226lG+Lk5mU0vrLvkxEiCbObpV53hmMNWhpI7riYOxxKZbrY1SuiI3+Ooo" +
       "6lXH9enCWZeNPp8IBo/NCR7XliqGyFpzE4sDriWgfm1eqlqeUx2pM5tMJMQf" +
       "rTZRG6WRROIHjkGuDEtbakMkUVa6gARCSCv9rOtGZJQE/ZbKrGsDRRWRZYVD" +
       "umHih4ZbIdc4q29tZMDUxQHaboo2FiC4RoW9SUx0wonuymW65fk+NuTLwNZi" +
       "XZ87JZboJ5lRX1VFqYO1ary56uCSs26PalSHbLXHYjQQidSgOgxmd/jllF2X" +
       "FCeUZEutul5t67YJRp+taL8sUUYSEHR9rPpLvDl32poqJTqDck445TupBg8l" +
       "JzCaruebFFnr+sqMW8+mkd4hstaot0JZ32UxgRl4YsXsKizvavh61PZ6S17x" +
       "N9NsW5aXbj8guxXWqc0kohqhtpmEI6SlhgHd8cINTdUDyRiXRyqvG9OACxYC" +
       "UZt4OrkcLruk3xwOMK6jkKQ4JtzathuUSuXMWHGRjRoBQUmBExOmIghRulpP" +
       "PWaqe9q4GyrzIdmsGA6uUl1JjFyY7Aak1KyzkhgjXLb2vSRyM94yaWLmyUQz" +
       "dExsgbh1qbNUon7iKqtVWxbG1bkUdpLNCLEWrW13PG7gi5m2sdtdT6HmDslu" +
       "cLbdo/QGXNdwEaeQYGlWPUwZphXPXweIMhA36XAbr3GPVuhtCLxSXU4HkUnV" +
       "x5jQNOsDfsywGlJfKmLfFKVQRuRx6jRKdjAT1qOWLK/x1AktMU6RPhb35xxB" +
       "CqO2PyMpcU05Fs2j2Dqoj7uNzBxIQbh0albPlBALi0TbFmcDhN1sOFukXVzo" +
       "RlroChPKZhelStVXtPkilZhtkHWSvt0Xyj0NUypqSK/sMV9x5MyYszRcHbQs" +
       "KmBHIr+leZqOaLotBN0uohk92cOWLaTSwy3TRMO1outGnR7pkwmxHYXA3ZRo" +
       "sx1Frovg2HJtDHGy4khidxEy6061ytlNGW3y0ybwwhTnVtvNDOmPF1GzNM14" +
       "yW3Ci2jaXbhDvLWZKW6rJGVzhal0OLS+GlKSPFTJblmqzhWZBitwuqo3Vypv" +
       "aEFnMnB6him787nTiKZUkBmjRZd2PTBOve3S4Pse6Tf8brbV9bnHkJlpcgQt" +
       "+R0Yo4cbxFrhK5yMhSXV4ske5dp9omrx5owDrSmTaKrkCAWwJ2fVqokKK3zR" +
       "65Ecs+hWNFMcCLOBuZamlkQLwcpDCJ3ISo2kN16ums7c73VJTqJIbNWdNh1j" +
       "uV2Sta1MUs2hUaalzbgfz5cpFrMel0blNgHo2JK4bpeXdIfXqpxXIWorh0BM" +
       "n2BmrKGtNVhYL2a6rSawrsxxfAOAuSEsbdyrdJaWIrf6JSbh3FZHWSDt1Sxo" +
       "JA3Ay1YQfJNFljknyxaqzeh6e6Nt2m1ccSprzG450y4zgcszo7xa+SsMIxI+" +
       "q9cxpS/hbV0G+KYvGiG31KdCt8wr1dK6N5Lb/S5CJCreoJocNpZGIb1c1zs1" +
       "GUbrmA7XsXG7U13rywYhGirtMcRk3khqa7+BVxBYZ7y1MHWmMlUxWJVnJRtG" +
       "TLaezcWQYKtzHS6BmQvLHLE6ZEfMuuJSFbpJNLqiNdZlTiT73YkdTsqNpDlW" +
       "UttTiN4MHYzbZugGGsL12i2sOx+ibSXC3Q42sPvcchh1+yFCrFZiaQbDuBuN" +
       "lqHtmhrqSKik9jm9O4h7xLgJM6ONQ9TscqcvoBNjXg9HWnntT2y22dTBUDNR" +
       "qyoinZFYb7cn6TJzIqVh+BQ1d3lSwAVKXi5wl3KW7YXMt3qdVkSQzeoU3aSR" +
       "SXcDbDJimjNeUPC1yZcDh/F6orFVmMheb8OqJVpoq+YY7KSlmWrHrivBHJP0" +
       "NdO0RnKiVfvAaeCG4loc3G8iMuGP3dm0z8ntek1rxIjB4KuVwcEDiVq101Fb" +
       "Er15fcShTN1cpWqjztc76GxteLHHYfWWCWYRGduwcIaq0grPhsPFFACnMC6v" +
       "UKkxIfRWrWkm1LAHQNBaW4SNj2fS2ilj01ZZmc0Ri04JUoepAG6zZc4ukVN+" +
       "K47nbcVqxobds3V+7pILoY62PQ9tRyBK7djQs74wlWdDv1Oyw8pkJPA8Mx2l" +
       "c5NeY7UR2/RKxoBxw3FtopRmWTuuyaTJhWTfEnuNiJsOBhtX28LLNVZuedZq" +
       "NjbDVK0seE9sWDyh1HGd8JJqO94o87YkBWzZic2Rz4/EqJduySXcMFUK7GJZ" +
       "IutyQ3NNVbdzmtAC2atLWFsf+1xvWy/5bK/XkLrBOBnHFttjW6mB9q3qjNlk" +
       "arQQywja8iJEnC95DjY1i6qbLGxpveZCngEEYkIh0KZquMr4gU4HzYVXBxC6" +
       "XlFGKTBhrpJFEhdpNbW7xnGP2PBhqR9X2hQRsB2nl6CDEMVKvlZGshVLe8uo" +
       "r5CTMTGeYCiCLSZ42bY53pYxZN2nYIoN672BJhHSsjNV+kOnHI2I2BsYmU26" +
       "QYVQqvPIZvUhv+bl0VptU1XCSUYmz8978bIRWOuGmJn96Uxk1zEdu6EwJWbc" +
       "pDexh04F6TZaQjqIlPlc4To83hvoZbJT0htjbFLtCVHfno7ajaDeYMduuzqs" +
       "eAGCaPq0VBuiM1SwDc3ksjlrImmrPcINrG3N0VIIW6ZFreOtXOvpGGaF9fYq" +
       "4+QqWWE7UQ2gBW9ytU6nUlVYuKnRCwE3K6qxyFJk6pIGk6VEi5yvtEmIluFu" +
       "JGaL9qzHzJyBbbDclplXyH4nS/kas6lndIpbXIfTx1W43yfW6chAGdSsy7pA" +
       "R/OSiVqpOICtdI4HhB1uhIXBl125m2Qb4OZ2bYkabrRpWJGFLoOlOqKm0VaT" +
       "mSXY6SQeOqFG2TaO2ZKXgYWIUvW9RlpZSawALGt4Ki+0/d5CZCuzzRaLtpmg" +
       "8B2P7s25aZMPnWGm652KVfM28ZAzulx5WCftbQvD+2hrVsNZmtwSFL2xYRJL" +
       "yVZlhBNdMcbYRTXmAoohVXvGL0ZSddnAJzrcitCK7pJ44KQbpTolHDnOl224" +
       "1eggnB8bRk9ES7rp4ATFbBod1EOQDSlsx0Oz6kdelYYbFauLLWrctEqtphNa" +
       "iJdJj0djeiuV401WkX046MoDfKYQS75r6xyRcFstVI1KuRPWeA7YjOFQblzb" +
       "shWMqCfqiKlIkRqVpGSOTrzalBpKZHWcGuvEHk0y2FP60aZrZyyi16gF21OU" +
       "eoiJznTs0YOZZVmyiFZai8qS80I26LWcUpua+52A6QWWxHF2w6BJZ+VWN3Gp" +
       "jYRJD+Fn1arLTyqiPB55XSeTwbRoWkPaqbiWkY1WC2JFwKOWSmumadlSP8RJ" +
       "j/FKpVIjdcXMkUiSHpqc7rgtpzNNp/AAgHHmoBRVdyIr5lo1VPOWJcPXEXYW" +
       "V8i0SojYRLNNi2FaVhgYaXuYjdHupOVtjQkAA6pZGq9GrqbxDinhlJ7AJUGm" +
       "x9tgGOlu3aWZHkk5teUgqQrMXMXUBbxaVlgmFgbZhKG6VW5QT/toapeS0qqT" +
       "mKST2lt6I1KOwNib0CvPkMBWtr2kXKMDCd52RybYFTHb/sQpG57ew4dZXcN6" +
       "1fIanzVcDGyLyt4IrTfkKjftwkMmWy+pKVj6iK0a3JOpXiMjm065g1cxj5kt" +
       "CKK2kdyB71Bzc7JxhLhfplYElTX8emtMGnzkkDrYkb4y36pGz+604I7iYOTo" +
       "2nPu4nnFa5/FLnlX9UCevPjo5Kr4nT97VXbyMP345BTKd/4vvN5tZrHr/+Cb" +
       "H3/SYD9U3js4cfYS6JYkCF/umivTPcHqBsDppdc/4aCLy9zjk9AvvPmf7hVf" +
       "NXv9s7gHetEZOc+y/Aj9sS8RL9F/fQ+64ehc9Kpr5tNEj5w+Db0YmUka+eKp" +
       "M9EXHln2rtxi94HniQPLPnH2TPB47K7ygnOFF+zG/syB/plLgYeCyN5XQ1Wf" +
       "mfuabrr7xQcF+T3p/kBdqcXwFHze+jQXA7+WJ7+YQLfGsyB1DdmJnd0nCrMT" +
       "TgUMdEELAtdU/WOH+6XTDnfbkcMdCXjn8fkZuzKjyDHMp/HRq8/ui4I3nr7i" +
       "uh88Hzgw6wf+T8x63/XN2g4Ms2Dxvqex6Afy5D0JdNPqera8cRU4xrEh33td" +
       "Q+bF7/qRTfYQeD58YLIP//hNdka5Gxw/KWg+8TQ2+t08+QhAiFhds6EOzJoX" +
       "/OaxTT76Y7TJJoHuuc5peH4r9/yrPqXZff6hf+LJSzff86T0l8Vd7tEnGrdQ" +
       "0M1W6ronL0dO5M+HkWk5hZK37K5KwuLvMwl07/VP6xPo/C5TCP+HO5LPJdBd" +
       "1yBJQP8H2ZOtP59AF49bJ9Cefqr6j0EIH1SDMQLpycovgCJQmWe/GB7Gwcuu" +
       "JW4RELsRExJgqENDbs6dni2OBvLOZzq8PTHBPHRqWig+hDqE8HT3KdSj+ief" +
       "HDBv+F7tQ7uLahCaWZZzuZmCLuzuzI+mgQeuy+2Q1/n+wz+4/VO3vPhwyrp9" +
       "J/BxSJyQ7UXXvhXuemFS3ONmf3DP773it578enE18D9eZbsloSYAAA==");
}
