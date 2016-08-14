package org.apache.batik.util;
public class Service {
    static java.util.HashMap providerMap = new java.util.HashMap();
    public static synchronized java.util.Iterator providers(java.lang.Class cls) {
        java.lang.String serviceFile =
          "META-INF/services/" +
        cls.
          getName(
            );
        java.util.List l =
          (java.util.List)
            providerMap.
            get(
              serviceFile);
        if (l !=
              null)
            return l.
              iterator(
                );
        l =
          new java.util.ArrayList(
            );
        providerMap.
          put(
            serviceFile,
            l);
        java.lang.ClassLoader cl =
          null;
        try {
            cl =
              cls.
                getClassLoader(
                  );
        }
        catch (java.lang.SecurityException se) {
            
        }
        if (cl ==
              null)
            cl =
              org.apache.batik.util.Service.class.
                getClassLoader(
                  );
        if (cl ==
              null)
            return l.
              iterator(
                );
        java.util.Enumeration e;
        try {
            e =
              cl.
                getResources(
                  serviceFile);
        }
        catch (java.io.IOException ioe) {
            return l.
              iterator(
                );
        }
        while (e.
                 hasMoreElements(
                   )) {
            java.io.InputStream is =
              null;
            java.io.Reader r =
              null;
            java.io.BufferedReader br =
              null;
            try {
                java.net.URL u =
                  (java.net.URL)
                    e.
                    nextElement(
                      );
                is =
                  u.
                    openStream(
                      );
                r =
                  new java.io.InputStreamReader(
                    is,
                    "UTF-8");
                br =
                  new java.io.BufferedReader(
                    r);
                java.lang.String line =
                  br.
                  readLine(
                    );
                while (line !=
                         null) {
                    try {
                        int idx =
                          line.
                          indexOf(
                            '#');
                        if (idx !=
                              -1)
                            line =
                              line.
                                substring(
                                  0,
                                  idx);
                        line =
                          line.
                            trim(
                              );
                        if (line.
                              length(
                                ) ==
                              0) {
                            line =
                              br.
                                readLine(
                                  );
                            continue;
                        }
                        java.lang.Object obj =
                          cl.
                          loadClass(
                            line).
                          newInstance(
                            );
                        l.
                          add(
                            obj);
                    }
                    catch (java.lang.Exception ex) {
                        
                    }
                    line =
                      br.
                        readLine(
                          );
                }
            }
            catch (java.lang.Exception ex) {
                
            }
            catch (java.lang.LinkageError le) {
                
            }
            finally {
                if (is !=
                      null) {
                    try {
                        is.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    is =
                      null;
                }
                if (r !=
                      null) {
                    try {
                        r.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    r =
                      null;
                }
                if (br ==
                      null) {
                    try {
                        br.
                          close(
                            );
                    }
                    catch (java.io.IOException ignored) {
                        
                    }
                    br =
                      null;
                }
            }
        }
        return l.
          iterator(
            );
    }
    public Service() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfXBU1RW/u/n+XgIJiCRACNjwkYVWKjRghRAguAmRYKqL" +
                                                              "sNx9ezd55O17j/fuJpuoFZl2wD/KIAWkrfAXFkupMJ06rW110nHqx2g7g9Ja" +
                                                              "60id2j+0llHG0XZKv869933vJtRxyMy7eXvvuefee87v/M6579wVVGIaqJmo" +
                                                              "tJ2O6cRs71JpHzZMkupUsGluh76E9FgR/njXe72rw6g0jmqHsNkjYZNslImS" +
                                                              "MuOoSVZNilWJmL2EpNiMPoOYxBjBVNbUOGqQze6MrsiSTHu0FGECA9iIoWmY" +
                                                              "UkNOZinpthRQ1BSDnUT5TqLrgsMdMVQtafqYKz7LI97pGWGSGXctk6JIbA8e" +
                                                              "wdEslZVoTDZpR85AS3RNGRtUNNpOcrR9j7LSMsGW2Mo8E7RcqPv02uGhCDfB" +
                                                              "dKyqGuXHM7cRU1NGSCqG6tzeLoVkzL3o66gohqo8whS1xuxFo7BoFBa1T+tK" +
                                                              "we5riJrNdGr8ONTWVKpLbEMUzfcr0bGBM5aaPr5n0FBOrbPzyXDaec5pxSnz" +
                                                              "jnhsSfToY7siPy5CdXFUJ6v9bDsSbILCInEwKMkkiWGuS6VIKo6mqeDsfmLI" +
                                                              "WJHHLU/Xm/KgimkW3G+bhXVmdWLwNV1bgR/hbEZWoprhHC/NAWX9KkkreBDO" +
                                                              "2uieVZxwI+uHA1bKsDEjjQF31pTiYVlNUTQ3OMM5Y+udIABTyzKEDmnOUsUq" +
                                                              "hg5ULyCiYHUw2g/QUwdBtEQDABoUzZ5UKbO1jqVhPEgSDJEBuT4xBFIV3BBs" +
                                                              "CkUNQTGuCbw0O+Alj3+u9K45dL+6WQ2jEOw5RSSF7b8KJjUHJm0jaWIQiAMx" +
                                                              "sXpx7DhufPZgGCEQbggIC5mfPnD1jqXNEy8JmZsLyGxN7iESTUink7UX53S2" +
                                                              "rS5i2yjXNVNmzvednEdZnzXSkdOBYRodjWyw3R6c2PbCvfvOkg/CqLIblUqa" +
                                                              "ks0AjqZJWkaXFWJsIioxMCWpblRB1FQnH+9GZfAek1Uierem0yah3ahY4V2l" +
                                                              "Gv8NJkqDCmaiSniX1bRmv+uYDvH3nI4QKoMHVcOzDIk//p+ivuiQliFRLGFV" +
                                                              "VrVon6Gx85tRYJwk2HYomgTUD0dNLWsABKOaMRjFgIMhYg1wI0CAjMgSaWfI" +
                                                              "0m+Azhw7x/TRUAhMPCcY4ArExmZNSREjIR3Nru+6+lTiFQEeBnjLAsC5sEy7" +
                                                              "WKadLyNcZC2DQiGufQZbToyA6YchiIFFq9v6d27ZfbClCFCjjxaD3Zhoiy+b" +
                                                              "dLqRbtNzQjpfXzM+//KK58OoOIbqsUSzWGHJYZ0xCLQjDVuRWZ2EPOPS/TwP" +
                                                              "3bM8ZWgSSQHbTEb7lpZybYQYrJ+iGR4NdjJiYRedPBUU3D+aODH68MBDy8Mo" +
                                                              "7Gd4tmQJkBOb3sd42eHf1mBkF9Jbd+C9T88ff1BzY9yXMuxMlzeTnaEl6P+g" +
                                                              "eRLS4nn46cSzD7Zys1cAB1MMMQP01hxcw0chHTYds7OUw4HTmpHBChuybVxJ" +
                                                              "hwxt1O3hwJzGmgaBUQahwAY5k6/t10/+4bfvf4lb0ib9Ok+27ie0w0M0TFk9" +
                                                              "p5RpLiK3G4SA3Nsn+r597MqBHRyOILGg0IKtrO0EggHvgAW/+dLeN/90+fSl" +
                                                              "sAthCpk2m4SCJcfPMuO/8BeC5z/sYeTAOgRJ1HdaTDXPoSqdrbzI3RuQlgJB" +
                                                              "zsDRercKMJTTMk4qhMXPv+oWrnj6b4ciwt0K9NhoWXp9BW7/TevRvld2/b2Z" +
                                                              "qwlJLGm69nPFBBNPdzWvMww8xvaRe/i1pu+8iE8CpwOPmvI44dSIuD0Qd+BK" +
                                                              "bovlvL01MHYbaxaaXoz7w8hT3CSkw5c+qhn46LmrfLf+6sjr9x6sdwgUCS/A" +
                                                              "Yg3IanxUzUYbddbOzMEeZgaJajM2h0DZrRO990WUiWuwbByWlYBgza0GkGPO" +
                                                              "ByVLuqTsj796vnH3xSIU3ogqFQ2nNmIecKgCkE7MIeDVnP7VO8Q+RsuhiXB7" +
                                                              "oDwL5XUwL8wt7N+ujE65R8Z/NvMna86cusxhqQsdNzsMO8fHsLwQd4P87Ou3" +
                                                              "/e7Mo8dHRSpvm5zZAvNm/XOrktz/53/k+YVzWoEyIzA/Hj33+OzO2z/g811y" +
                                                              "YbNbc/npCQjanfvFs5lPwi2lvw6jsjiKSFbhO4CVLIvrOBR7pl0NQ3HsG/cX" +
                                                              "bqJK6XDIc06Q2DzLBmnNTYvwzqTZe00Ag1XMhVF4llsYXB7EYAjxly18yiLe" +
                                                              "trFmqcMuJq+sc45ODovKKXRSVKUb2ogMaAVsAgCaXACwNNafTZp0Gx7l1WJC" +
                                                              "uu+WSGPr6o9bBAKaC8h6yspDv/h5PH5LRBLCLYUU+8vJJ8+US29lXviLmHBT" +
                                                              "gQlCruHJ6LcG3tjzKmf2cpbJt9s29eRpyPiejBFxbFJrx/oGyyYbBOPe8zlL" +
                                                              "KJiWgcuWnBEXNXUQMGqXZzdMN+clX8y6zvrhsLLuw1XfXyvMOX+ScHXln7nr" +
                                                              "nYsnx8+fEzmDmZWiJZPdKvOvsqxSWDhFteMC45NNX5l4/92BnWGL5WtZMyBQ" +
                                                              "O4sW4Ew2sMthu5DDVjP8EBHaNzxS98vD9UUboRTpRuVZVd6bJd0pfxCWmdmk" +
                                                              "BzPuBcoNzAhr2nMsI1MUWgxUKaoN1q5izZ1iw2sKUXVukhBlr8vc8OR/pVOk" +
                                                              "HQ87I+bqpskucfwCenr/0VOprU+sEA6v91+MuuDe/6Pf//vV9hPvvFygVq+g" +
                                                              "mr5MISNECWSEJh+6evj91qXXt2uPvPtM6+D6z1Jus77m6xTU7PdcOMTiyQEV" +
                                                              "3MqL+/86e/vtQ7s/Q+U8N2DOoMof9Jx7edMi6UiYX+YF7+d9BPBP6vADrdIg" +
                                                              "NGuofmgtcADwBebYFfCstQCwNsj5Lujy0FTE0cSaXoqqzTHgEUNTocRKBRJA" +
                                                              "8xQLBIovO7bY77v8Wirg0SwtmqDMHZ+T1uQVq9RoTJP4lx4oPPuzuq4Z1GbN" +
                                                              "G6lemOhe1jzgME8dZx6W7kVkse59Qduwn8kcd8z4FKXrN1gDlWeFnV/NgFEZ" +
                                                              "XXC+2GkZdaftmq9x19zj2eIBZ4v1Ljl2U8IvGmzkkcK7dNmKTsFW/0dhyTrW" +
                                                              "6zmKyqzbO6sVZuV9+BMfq6SnTtWVzzx19xucFZwPStUQ3+msoniLIc97qW6Q" +
                                                              "tMxtVy1KI0G5RyhqKPghgaJi9o9v9lEhe4yiSFCWohL+3yt3gqJKVw4KJ/Hi" +
                                                              "FfkeRUUgwl4f123rR1yAiHowF/JTtGPvhuvZ28PqC3wkxz+62oSU7bOS8/lT" +
                                                              "W3rvv/rlJ8RtVlLw+DjTUgW5TNyZHVKbP6k2W1fp5rZrtRcqFtr513eb9u6N" +
                                                              "ex3AxG+eswPXO7PVueW9eXrNc785WPoa5JUdKIQpmr4jv3LO6VnIJjti+Tkb" +
                                                              "EgC/d3a0fXfs9qXpD9/idxOUdyMJyiekS2d2vn5k1mm4n1Z1oxJIgSTHS/oN" +
                                                              "Y+o2Io0YcVQjm1052CJokbHiKwhqGTAx+xzrBDuYs8bpZZ85KGrJ++5a4OMQ" +
                                                              "3ONGibFey6opq6Socnt8X4PtvABUFJjg9njKViyqEEG3RYlYj67b3wiqS3Qe" +
                                                              "lsnCoc/a8/yVNRf+BwJGevWQGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7I/u/oM3/fazXy2qoP8LsH0x7J0iAAA=");
}
