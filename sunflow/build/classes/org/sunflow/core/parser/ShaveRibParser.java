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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qk9Q+oqjecZ+d/uFonjvUSCcicnzzlOudeOO72nFrtVx22uOHevkgAdozG6q" +
       "qbPXtOysKJ66TSR/6DZtHymKHwdRrhTK7HW/DflPHcVxGe3v+B9E+2uKyqfA" +
       "9f4jF3v/K0XA77pdoBePz5cEP3trgneXBD9XFB+Noatl0JKOLx+FbVH/nhOF" +
       "7zuC6YNf3Ou7/4+hb/pfPkqAnz+p8H8p/qaxcVkvLHDr6PjEcXT8yn8zOori" +
       "R04i4xdujIzi8YNF8WO3cfVPlMJ+4cu5+m/cpu2TRfHrRfETe01uQ/ups37+" +
       "sVfi51kMPXD+fEaxwfzIDafA9ieXlI+9ePXu1704+6M9fh+fLrqHge7WE8c5" +
       "ux945v5KEGq6WSp6z353MCj/fjeGXneLMyPF/n15Uyr86T39Z2Lo2kX6GLqz" +
       "+DtL9gcx9KozZOBVe3R3luiPAawCouL2T4KbbCXu90WzS2cSvSNQKG380Jez" +
       "8QnL2SMMxdu0PIZ3nMgl+4N4zyoff5EefdsXmx/eH6FQHHm3K6TcDV58+9Mc" +
       "J8ngk7eUdizrSv/pLz3wM/e86ThxfWCv8ClAndHtiZufUei5QVyeKtj94ut+" +
       "7ut+4sU/L3c2/wuuMiBIHykAAA==");
}
