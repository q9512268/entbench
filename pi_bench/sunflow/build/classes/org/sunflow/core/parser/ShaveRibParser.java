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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZDZAUxRXu3fu/436BA084/g6qQNxV1BjrCAHOOznc467u" +
       "kEoOwzE723s33OzMONN7t3cGFSoGTCoUUQS08KqSoKCFQqxYJhoNiRWVQq3S" +
       "+EeMYhIrMTFUoEw0FZOY97pndn52b4lW2Krtnel+3f369fe+97r3yBlSYpmk" +
       "mWoswsYMakXaNdYjmRZNtKmSZa2HugF5X5H04ab3110TJqX9pGZIsrpkyaId" +
       "ClUTVj+ZrWgWkzSZWusoTWCPHpNa1ByRmKJr/WS6YnWmDFWRFdalJygKbJDM" +
       "GKmXGDOVeJrRTnsARmbHQJMo1yS6KtjcGiNTZN0Yc8VnesTbPC0omXLnship" +
       "i22RRqRomilqNKZYrDVjkksMXR0bVHUWoRkW2aJeZZtgbeyqHBPMP1b70Se7" +
       "h+q4CaZKmqYzvjyrl1q6OkITMVLr1rarNGXdRG4hRTFS5RFmpCXmTBqFSaMw" +
       "qbNaVwq0r6ZaOtWm8+UwZ6RSQ0aFGJnnH8SQTCllD9PDdYYRypm9dt4ZVjs3" +
       "u1qxypwl3n1JdM++TXWPFpHaflKraH2ojgxKMJikHwxKU3FqWqsSCZroJ/Ua" +
       "bHYfNRVJVcbtnW6wlEFNYmnYfscsWJk2qMnndG0F+whrM9My083s8pIcUPZb" +
       "SVKVBmGtje5axQo7sB4WWKmAYmZSAtzZXYqHFS3ByJxgj+waW64HAehalqJs" +
       "SM9OVaxJUEEaBERUSRuM9gH0tEEQLdEBgCYjTZMOirY2JHlYGqQDiMiAXI9o" +
       "AqkKbgjswsj0oBgfCXapKbBLnv05s275rpu1NVqYhEDnBJVV1L8KOjUHOvXS" +
       "JDUp+IHoOGVJbK/U+NTOMCEgPD0gLGQe//q5lUubjz8vZC7OI9Md30JlNiAf" +
       "jNe8PKtt8TVFqEa5oVsKbr5v5dzLeuyW1owBDNOYHREbI07j8d5nv3rbQ/SD" +
       "MKnsJKWyrqZTgKN6WU8ZikrN66hGTYnRRCepoFqijbd3kjJ4jikaFbXdyaRF" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nyrY//q7fuWHfv71P64zm/8HvasyegEpAAA=");
}
