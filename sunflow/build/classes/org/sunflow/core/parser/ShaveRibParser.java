package org.sunflow.core.parser;
public class ShaveRibParser implements org.sunflow.core.SceneParser {
    public boolean parse(java.lang.String filename, org.sunflow.SunflowAPI api) {
        try {
            org.sunflow.system.Parser p =
              new org.sunflow.system.Parser(
              filename);
            p.
              checkNextToken(
                "version");
            p.
              checkNextToken(
                "3.04");
            p.
              checkNextToken(
                "TransformBegin");
            if (p.
                  peekNextToken(
                    "Procedural")) {
                boolean done =
                  false;
                while (!done) {
                    p.
                      checkNextToken(
                        "DelayedReadArchive");
                    p.
                      checkNextToken(
                        "[");
                    java.lang.String f =
                      p.
                      getNextToken(
                        );
                    org.sunflow.system.UI.
                      printInfo(
                        org.sunflow.system.UI.Module.
                          USER,
                        "RIB - Reading voxel: \"%s\" ...",
                        f);
                    api.
                      parse(
                        f);
                    p.
                      checkNextToken(
                        "]");
                    while (true) {
                        java.lang.String t =
                          p.
                          getNextToken(
                            );
                        if (t ==
                              null ||
                              t.
                              equals(
                                "TransformEnd")) {
                            done =
                              true;
                            break;
                        }
                        else
                            if (t.
                                  equals(
                                    "Procedural"))
                                break;
                    }
                }
                return true;
            }
            boolean cubic =
              false;
            if (p.
                  peekNextToken(
                    "Basis")) {
                cubic =
                  true;
                p.
                  checkNextToken(
                    "catmull-rom");
                p.
                  checkNextToken(
                    "1");
                p.
                  checkNextToken(
                    "catmull-rom");
                p.
                  checkNextToken(
                    "1");
            }
            while (p.
                     peekNextToken(
                       "Declare")) {
                p.
                  getNextToken(
                    );
                p.
                  getNextToken(
                    );
            }
            int index =
              0;
            boolean done =
              false;
            p.
              checkNextToken(
                "Curves");
            do  {
                if (cubic)
                    p.
                      checkNextToken(
                        "cubic");
                else
                    p.
                      checkNextToken(
                        "linear");
                int[] nverts =
                  parseIntArray(
                    p);
                for (int i =
                       1;
                     i <
                       nverts.
                         length;
                     i++) {
                    if (nverts[0] !=
                          nverts[i]) {
                        org.sunflow.system.UI.
                          printError(
                            org.sunflow.system.UI.Module.
                              USER,
                            "RIB - Found variable number of hair segments");
                        return false;
                    }
                }
                int nhairs =
                  nverts.
                    length;
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      USER,
                    "RIB - Parsed %d hair curves",
                    nhairs);
                api.
                  parameter(
                    "segments",
                    nverts[0] -
                      1);
                p.
                  checkNextToken(
                    "nonperiodic");
                p.
                  checkNextToken(
                    "P");
                float[] points =
                  parseFloatArray(
                    p);
                if (points.
                      length !=
                      3 *
                      nhairs *
                      nverts[0]) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          USER,
                        "RIB - Invalid number of points - expecting %d - found %d",
                        nhairs *
                          nverts[0],
                        points.
                          length /
                          3);
                    return false;
                }
                api.
                  parameter(
                    "points",
                    "point",
                    "vertex",
                    points);
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      USER,
                    "RIB - Parsed %d hair vertices",
                    points.
                      length /
                      3);
                p.
                  checkNextToken(
                    "width");
                float[] w =
                  parseFloatArray(
                    p);
                if (w.
                      length !=
                      nhairs *
                      nverts[0]) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          USER,
                        ("RIB - Invalid number of hair widths - expecting %d - found %" +
                         "d"),
                        nhairs *
                          nverts[0],
                        w.
                          length);
                    return false;
                }
                api.
                  parameter(
                    "widths",
                    "float",
                    "vertex",
                    w);
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      USER,
                    "RIB - Parsed %d hair widths",
                    w.
                      length);
                java.lang.String name =
                  java.lang.String.
                  format(
                    "%s[%d]",
                    filename,
                    index);
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      USER,
                    "RIB - Creating hair object \"%s\"",
                    name);
                api.
                  geometry(
                    name,
                    new org.sunflow.core.primitive.Hair(
                      ));
                api.
                  instance(
                    name +
                    ".instance",
                    name);
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      USER,
                    "RIB - Searching for next curve group ...");
                while (true) {
                    java.lang.String t =
                      p.
                      getNextToken(
                        );
                    if (t ==
                          null ||
                          t.
                          equals(
                            "TransformEnd")) {
                        done =
                          true;
                        break;
                    }
                    else
                        if (t.
                              equals(
                                "Curves"))
                            break;
                }
                index++;
            }while(!done); 
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  USER,
                "RIB - Finished reading rib file");
        }
        catch (java.io.FileNotFoundException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  USER,
                "RIB - File not found: %s",
                filename);
            e.
              printStackTrace(
                );
            return false;
        }
        catch (org.sunflow.system.Parser.ParserException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  USER,
                "RIB - Parser exception: %s",
                e);
            e.
              printStackTrace(
                );
            return false;
        }
        catch (java.io.IOException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  USER,
                "RIB - I/O exception: %s",
                e);
            e.
              printStackTrace(
                );
            return false;
        }
        return true;
    }
    private int[] parseIntArray(org.sunflow.system.Parser p)
          throws java.io.IOException { org.sunflow.util.IntArray array =
                                         new org.sunflow.util.IntArray(
                                         );
                                       boolean done =
                                         false;
                                       do  { java.lang.String s =
                                               p.
                                               getNextToken(
                                                 );
                                             if (s.
                                                   startsWith(
                                                     "["))
                                                 s =
                                                   s.
                                                     substring(
                                                       1);
                                             if (s.
                                                   endsWith(
                                                     "]")) {
                                                 s =
                                                   s.
                                                     substring(
                                                       0,
                                                       s.
                                                         length(
                                                           ) -
                                                         1);
                                                 done =
                                                   true;
                                             }
                                             array.
                                               add(
                                                 java.lang.Integer.
                                                   parseInt(
                                                     s));
                                       }while(!done); 
                                       return array.
                                         trim(
                                           ); }
    private float[] parseFloatArray(org.sunflow.system.Parser p)
          throws java.io.IOException { org.sunflow.util.FloatArray array =
                                         new org.sunflow.util.FloatArray(
                                         );
                                       boolean done =
                                         false;
                                       do  { java.lang.String s =
                                               p.
                                               getNextToken(
                                                 );
                                             if (s.
                                                   startsWith(
                                                     "["))
                                                 s =
                                                   s.
                                                     substring(
                                                       1);
                                             if (s.
                                                   endsWith(
                                                     "]")) {
                                                 s =
                                                   s.
                                                     substring(
                                                       0,
                                                       s.
                                                         length(
                                                           ) -
                                                         1);
                                                 done =
                                                   true;
                                             }
                                             array.
                                               add(
                                                 java.lang.Float.
                                                   parseFloat(
                                                     s));
                                       }while(!done); 
                                       return array.
                                         trim(
                                           ); }
    public ShaveRibParser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZDZAUxRXu3fvljvvl/+SfgyoQdxUlxjpCgPNODve4Kw6J" +
       "OQzH7Gzv3XCzM8NM793eGVSomMOkQhFFQAuvKgmKWgjEimWi0ZBYAS1/qjT+" +
       "ESOYxEpICBUpE03FJOa97pmdn91botGt2t6Z7tfdr19/73uvew+fJyWWSWZS" +
       "jUXYkEGtSIvGOiXToolmVbKs9VDXI+8rkt7fdHbtNWFS2k2q+ySrXZYs2qpQ" +
       "NWF1kxmKZjFJk6m1ltIE9ug0qUXNAYkputZNJilWW8pQFVlh7XqCosAGyYyR" +
       "OokxU4mnGW2zB2BkRgw0iXJNoiuDzU0xMl7WjSFXfKpHvNnTgpIpdy6LkdrY" +
       "FmlAiqaZokZjisWaMia51NDVoV5VZxGaYZEt6lLbBGtiS3NMMPdYzQcf7e6r" +
       "5SaYIGmazvjyrHXU0tUBmoiRGre2RaUpayu5hRTFSKVHmJHGmDNpFCaNwqTO" +
       "al0p0L6KaulUs86Xw5yRSg0ZFWJkjn8QQzKllD1MJ9cZRihn9tp5Z1jt7Oxq" +
       "xSpzlnj3pdE9+zbVPlpEarpJjaJ1oToyKMFgkm4wKE3FqWmtTCRoopvUabDZ" +
       "XdRUJFUZtne63lJ6NYmlYfsds2Bl2qAmn9O1FewjrM1My0w3s8tLckDZbyVJ" +
       "VeqFtU521ypW2Ir1sMAKBRQzkxLgzu5S3K9oCUZmBXtk19h4PQhA17IUZX16" +
       "dqpiTYIKUi8gokpab7QLoKf1gmiJDgA0GWkYc1C0tSHJ/VIv7UFEBuQ6RRNI" +
       "jeOGwC6MTAqK8ZFglxoCu+TZn/Nrl+26WVuthUkIdE5QWUX9K6HTzECndTRJ" +
       "TQp+IDqOXxTbK01+ameYEBCeFBAWMo9//cKKxTOPPytkLskj0xHfQmXWIx+M" +
       "V788vXnhNUWoRrmhWwpuvm/l3Ms67ZamjAEMMzk7IjZGnMbj60589baH6bkw" +
       "qWgjpbKuplOAozpZTxmKSs3rqEZNidFEGxlHtUQzb28jZfAcUzQqajuSSYuy" +
       "NlKs8qpSnb+DiZIwBJqoAp4VLak7z4bE+vhzxiCElMGXLIFvLREf/svIV6J9" +
       "eopGJVnSFE2Pdpo6rt+KAuPEwbZ9USutJVV9MGqZclQ3e7Pvsm5S9EmgwGhX" +
       "nzRA1ylx7mxmBAFmfH5DZ3BVEwZDITD49KC7q+Apq3U1Qc0eeU96VcuFIz3P" +
       "Cygh/G17MLIA5ovY80VwvoiYL+Kfj4RCfJqJOK/YU9iRfvBtINfxC7u+tmbz" +
       "zrlFACZjsBjMiaJzfUGm2SUAh7V75KP1VcNzTl/xTJgUx0i9JLO0pGLMWGn2" +
       "AhvJ/bbDjo9D+HGjwGxPFMDwZeoyTQAJjRUN7FHK9QFqYj0jEz0jODEKvTE6" +
       "doTIqz85vn9w+4ZbLw+TsJ/4ccoS4Czs3ol0naXlxqDD5xu3ZuTsB0f3btNd" +
       "1/dFEicA5vTENcwNAiFonh550WzpsZ6ntjVys48DamYSuBKw3szgHD5maXJY" +
       "GtdSDgtO6mZKUrHJsXEF6zP1QbeGI7QOi0kCrAihgIKc4L/UZdz35kt/upJb" +
       "0okFNZ4g3kVZk4d/cLB6zjR1LiLXm5SC3Nv7O++6+/zIRg5HkJiXb8JGLJuB" +
       "d2B3wIK3P7v11JnTB18NuxBmEIDTcchjMnwtEz+GTwi+/8EvcgZWCO6ob7YJ" +
       "bHaWwQyceYGrG3CZCk6P4Gi8QQMYKklFiqsU/edfNfOveOwvu2rFdqtQ46Bl" +
       "8cUHcOunrSK3Pb/pw5l8mJCMsdS1nysmCHqCO/JK05SGUI/M9ldm3HNSug+o" +
       "HujVUoYpZ0zC7UH4Bi7ltricl1cF2q7GYr7lxbjfjTw5T4+8+9X3qja89/QF" +
       "rq0/afLue7tkNAkUiV2Aya4kduFjcGydbGA5JQM6TAkS1WrJ6oPBrjq+9qZa" +
       "9fhHMG03TCtDOmF1mMCSGR+UbOmSsl///JnJm18uIuFWUqHqUqJV4g5HxgHS" +
       "qdUHBJsxvrxC6DFY7iiTITkWyqnAXZiVf39bUgbjOzL84yk/WnZo9DSHpSHG" +
       "uMQ74AJeLsRisYAtPl6WyRqLf0oLGMszZog/T2Vkek5Q6JIB2CIUoHVnjJW2" +
       "8JTr4I49o4mO+68QyUW9PxVogUz3kdf//UJk/zvP5YlH45huXKbSAap6FCvC" +
       "KX3hpJ1ndC6lvV195+9/0ti76pNEEqybeZFYge+zYBGLxo4MQVVO7vhzw/rl" +
       "fZs/QVCYFTBncMiH2g8/d90C+c4wT19FPMhJe/2dmryGhUlNCnm6hsvEmiru" +
       "UvOyKJmAoJgK3zobJXVBlxLszSGHRUu2KwdjRYGuAcYI8x0NO1Cr5R6ASXhE" +
       "JOFOw2QvBrvE78rONq7IjQVYaBMWXYyU8DzGn4cgIrrScQtyBiUFcWTAzpiX" +
       "dG6WdzZ2visAOy1PByE36cHodza8seUFvrXliKWsQT04Asx5ol8tFhF0moUF" +
       "zp9+faLb6s/0Hzj7iNAnmO4HhOnOPd/6OLJrj3AmcSaal3Ms8fYR56KAdnMK" +
       "zcJ7tP7x6LYnH9w2ErYtfT0jZXFdV6mkZXcilE3/JvqtKHS99o6an+6uL2oF" +
       "N20j5WlN2ZqmbQk/VMusdNxjVvcY5QLX1hoDMCOhRQ4zfhGL9eJ52ackZaxY" +
       "ZfD6jizG67FtFnxHbIyPFHCPHEYGMxmmMgBZQcbvNZUFRgwgPOQn6Gle57CG" +
       "LEZTEZudUWKocG8R+xU90tbRkpGpgezE+23DAvLAKu47bRrjqYH/wijrErxN" +
       "bOtNlSd+Zv3gD48KvOZzuMAR9cFD5fJbqRPvOlCSsoapdijkEtsw/JeRG/+/" +
       "M5QD5uh6UwGuUWk7BG/nfPa5jY1+NX9sr/dYcPSBeS/dOjrvtzwtKVcsiEVA" +
       "I3kuCDx93jt85twrVTOO8JhXjGxku4z/ZiX34sR3H8LtX4PFNwQ8N9uUgD+y" +
       "57mXkSLFvp3ygApf1UweApjuC9j89tCNaA//6urXDn1376BATAFmDPSb+s8O" +
       "Nb7jd//IyRp5cM1DloH+3dHDBxqal5/j/d2jD/ZuzOSeomEb3L5LHk79PTy3" +
       "9JdhUtZNamX7tm6DpKbx1NENhracK7wYqfK1+2+bxNVKUzaUTw+ytWfa4KHL" +
       "y5TFzMeKdWITQ4QzyN78bBTm+SGEx6SiSSrvF4GTjkq1XnFL8m0s7jDcHQ0E" +
       "7AluwG5WdY3iGcRpm+gQS/aiEBpzscHJVSjLJ/OkFVyfAtH9YIG2B7D4HixN" +
       "Rr3EMgqIPzQW+XviRC7GeYyxPocYw5P1efDdZxPfvoukYOncYDJW1/zhAF+H" +
       "+aiPjS1wCxd4HItjcDLjgaEVDkJ2aMD67X7yxlyywVakwVHkdq7IN4UxRrB4" +
       "4qJsA7iHef5HvsH33WJc2wF+UcgBsLhHoB+Le7PIfzIX+fh6AIvRAlB+gg/2" +
       "JBbfLwC65wq0PY/FSSwOCU0KyL746cH7w88CvBlGqv03hHicnZrzn4O4J5eP" +
       "jNaUTxm94Q0Rqpy77PGQRCfTquqlNM9zqWHSpMKXO14QnMF/Xmdkyhi3lnhn" +
       "wx+43q8J+VNwygjKM1KMP16x3zBS6RFjmIjyJ6/QGQiCIISP7xh5zjCC2jOh" +
       "3JM6t/2ki9k+28V7bYVBkf/p42RVafG3T498dHTN2psvfOF+cW0mq9LwMI5S" +
       "CTFeXM5lj5hzxhzNGat09cKPqo+Nm+/kZL5rO69uHAEALH7F1RC4R7Ias9dJ" +
       "pw4ue/rFnaWvQKzdSEIShI6NuUEwY6ThbL8xlntagCDIL7iaFt47tHxx8q9v" +
       "8UsQkpNcBOUhyN/1Ztux/g9X8H8ZSuDkQjM8Ol87pK2j8oDpO3pUIxolPHly" +
       "O9jmq8rW4v0pI3NzD1S5t84VABZqrtLTWgKHgUys0q3x/ftkI7wibRiBDm6N" +
       "Jz3rF8SI1gf89cTaDcO5fBwxuEeq+b0ey/f5IxZ/+y915I/t/x0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bhCXpw3yz77hd37s1178q7Li+X8BLlA1xSMpAAA=");
}
