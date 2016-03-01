package edu.umd.cs.findbugs.detect;
public class FindFloatMath extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public FindFloatMath(edu.umd.cs.findbugs.BugReporter bugReporter) { super(
                                                                          );
                                                                        this.
                                                                          bugReporter =
                                                                          bugReporter;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (seen) { case FMUL:
                                                      case FDIV:
                                                          if (getFullyQualifiedMethodName(
                                                                ).
                                                                indexOf(
                                                                  "float") ==
                                                                -1 &&
                                                                getFullyQualifiedMethodName(
                                                                  ).
                                                                indexOf(
                                                                  "Float") ==
                                                                -1 &&
                                                                getFullyQualifiedMethodName(
                                                                  ).
                                                                indexOf(
                                                                  "FLOAT") ==
                                                                -1) {
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "FL_MATH_USING_FLOAT_PRECISION",
                                                                    LOW_PRIORITY).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addSourceLine(
                                                                      this));
                                                          }
                                                          break;
                                                      case FCMPG:
                                                      case FCMPL:
                                                          break;
                                                      case FADD:
                                                      case FSUB:
                                                      case FREM:
                                                          if (getFullyQualifiedMethodName(
                                                                ).
                                                                indexOf(
                                                                  "float") ==
                                                                -1 &&
                                                                getFullyQualifiedMethodName(
                                                                  ).
                                                                indexOf(
                                                                  "Float") ==
                                                                -1 &&
                                                                getFullyQualifiedMethodName(
                                                                  ).
                                                                indexOf(
                                                                  "FLOAT") ==
                                                                -1) {
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "FL_MATH_USING_FLOAT_PRECISION",
                                                                    NORMAL_PRIORITY).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addSourceLine(
                                                                      this));
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
       "2GDybM6H0ZFPcuYn+ZA9LvwXWdhmltIXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6aczr2FV+31vnzfLevGmnw3T2eVM6k/I5jpPY0WtLs9iO" +
       "EyfO5jgOtK/e7cRbvMSOy9BFhVZUKgNMF1A7v1oB1XQRogIJFQ1C0FatkIoq" +
       "Nom2QkgUSqWOEAVRoFw73/6+N6VCRMr9bu4959xzzj3n3HPP/V78LnQ+8KGC" +
       "51ob3XLDXTUJdxdWZTfceGqw22EqA9EPVKVpiUEwAWM35Sc+d+X7P3jOuLoD" +
       "XZhD94mO44ZiaLpOMFID11qrCgNdORwlLNUOQugqsxDXIhyFpgUzZhDeYKA7" +
       "j6CG0HVmnwUYsAADFuCcBbh+CAWQ7ladyG5mGKITBivo56EzDHTBkzP2Qujx" +
       "40Q80RftPTKDXAJA4VL2ewqEypETH3rsQPatzLcI/KEC/PxH3nb1d85CV+bQ" +
       "FdMZZ+zIgIkQLDKH7rJVW1L9oK4oqjKH7nVUVRmrvilaZprzPYeuBabuiGHk" +
       "qwdKygYjT/XzNQ81d5ecyeZHcuj6B+Jppmop+7/Oa5aoA1nvP5R1KyGZjQMB" +
       "L5uAMV8TZXUf5dzSdJQQevQkxoGM17sAAKBetNXQcA+WOueIYAC6tt07S3R0" +
       "eBz6pqMD0PNuBFYJoQdvSzTTtSfKS1FXb4bQAyfhBtspAHVHrogMJYRefRIs" +
       "pwR26cETu3Rkf77bf+MH3+G0nZ2cZ0WVrYz/SwDpkRNII1VTfdWR1S3iXc8w" +
       "Hxbv/8L7dyAIAL/6BPAW5vd+7uW3vOGRl760hXntKTCstFDl8Kb8Cemerz3U" +
       "fLp2NmPjkucGZrb5xyTPzX+wN3Mj8YDn3X9AMZvc3Z98afSnwrs+pX5nB7pM" +
       "Qxdk14psYEf3yq7tmZbqU6qj+mKoKjR0h+oozXyehi6CPmM66naU1bRADWno" +
       "nJUPXXDz30BFGiCRqegi6JuO5u73PTE08n7iQRB0EXyhGfi+Ftp+8r8hdBM2" +
       "XFuFRVl0TMeFB76byR/AqhNKQLcGrAFjkiI9gANfhnPTUZUIjmwFloPDSUUN" +
       "ARpMgt+k5YphDyy+m0F7//9LJJmUV+MzZ8AGPHTS/S3gOW3XUlT/pvx81CBe" +
       "/szNr+wcuMOefkLo9WDFXbDirhzs7q+4u11x99iK0Jkz+UKvylbe7jLYoyXw" +
       "dhAH73p6/NbO29//xFlgXl58Dig4A4VvH46bh/GBzqOgDIwUeumj8bun7yzu" +
       "QDvH42rGLRi6nKEPsmh4EPWun/Sn0+heed+3v//ZDz/rHnrWsUC95/C3YmYO" +
       "+8RJvfquDFTmq4fkn3lM/PzNLzx7fQc6B6IAiHyhCCwVBJVHTq5xzHFv7AfB" +
       "TJbzQGDN9W3Ryqb2I9fl0PDd+HAk3/B78v69QMd3Zpb8APg+smfa+d9s9j4v" +
       "a1+1NZBs005IkQfZN429j//Vn/0jmqt7Px5fOXLCjdXwxpEYkBG7knv7vYc2" +
       "MPFVFcD97UcHv/ah777vZ3IDABBPnrbg9axtAt8HWwjU/AtfWv31N7/xia/v" +
       "HBpNCA7BSLJMOTkQMhuHLr+CkGC11x3yA2KIBWw3s5rrnGO7iqmZomSpmZX+" +
       "55WnkM//8wevbu3AAiP7ZvSGH03gcPwnGtC7vvK2f3skJ3NGzs6wQ50dgm0D" +
       "432HlOu+L24yPpJ3//nDv/5F8eMgxIKwFpipmkeqM3uOkzH1anDOneaZjUgf" +
       "qZ7rg0Mr31w4h34mb3czxeQ0oHwOzZpHg6NOctwPj+QkN+Xnvv69u6ff+8OX" +
       "c6mOJzVHbaIneje2Zpg1jyWA/GtORoS2GBgArvxS/2evWi/9AFCcA4oyOMkD" +
       "1gcBKTlmQXvQ5y/+zR/98f1v/9pZaIeELoOoo5Bi7ozQHcAL1MAAsSzxfvot" +
       "WyOIL4Hmai4qdIvwW+N5IP91DjD49O3jEJnlJIeu/MB/sJb0nr/791uUkEeg" +
       "U47iE/hz+MWPPdh883dy/MNQkGE/ktwapEH+dohb+pT9rztPXPiTHejiHLoq" +
       "7yWHU9GKMgebg4Qo2M8YQQJ5bP54crM9yW8chLqHToahI8ueDEKHhwPoZ9BZ" +
       "//KJuHMt0/Iz4PvQnks+dDLunIHyTj1HeTxvr2fNT+Z7shNCFz3fXIOTPwTL" +
       "m45o7fn7D8HnDPj+d/bNiGYD2/P6WnMvaXjsIGvwwPl1p3ToERmJ4jbkZW05" +
       "axpbythtDeeNWUMlZ0DsOV/axXZzAszpjJ/Nuq8HQSrIc+fsF5nrhgqBF1jy" +
       "9X0epyCRBmZzfWFh++58Nbf4bIN2t9nnCUap/zWjwKLvOSTGuCCR/cDfP/fV" +
       "X37ym8DsOtD5dWYSwNqOrNiPstz+F1/80MN3Pv+tD+QBF0Sa8dPSv7wlozp9" +
       "JXGzZnBM1AczUcdu5MsqIwZhL4+RqpJL+4reNvBNGxwl673EFX722jeXH/v2" +
       "p7dJ6UnXOgGsvv/5X/rh7gef3zlyFXjylmz8KM72OpAzffeehn3o8VdaJccg" +
       "/+Gzz/7Bbz37vi1X144ntgS4t336L/7rq7sf/daXT8mmzlnu/2Fjw7vf1S4H" +
       "dH3/w0wFTUi4acLDPXhdS9Qy6yAlvjEXyc2Scaypt5Kby2YdifjUqRIeN5zN" +
       "pUWKeug8wSoVDG6rmhSlZslghFAXR+KoXpQmGFlEpKEeJH17VWyJ0ii0l4go" +
       "lkrIfCj2R1SYNDoLsTgOKzUMm4dYO6WwsF0sb6QCJqt4tVJD01rqO+uyM+Xm" +
       "08jVC3pxYip9IVDQqjOk+XQ+IoxVCZOKsVWhNT9owCzaCAWyx02Fgq6KAwHz" +
       "1GQy86au6ZSa5MquLiQyWqZBnaO5ZEEuiXkolCvmylhUwbRXmuEYNyVtCxbm" +
       "TapHFKTmdNStShwX9tjOrBTV6RXfUYklsSh0wmYJRzt9YiF1jInjL8doumwq" +
       "eNfFk4paW3LheDgoz4iAnU6mXne0KlaquKGIc2MhzpFhLHbQpTiojkKFKMUs" +
       "ZidJfaxYlbW2Rq1NSPOS0MJ4RehvampcS1piURbpJSf10AjpLVgtiAtGdzXu" +
       "0lQ7JcmZ7DQ9oxN0A8pu8MVad2HUiBqlzHqMXg2bTY/yJnNdNUVqOjTpZei0" +
       "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");
}
