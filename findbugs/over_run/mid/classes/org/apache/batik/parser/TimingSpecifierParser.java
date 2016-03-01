package org.apache.batik.parser;
public class TimingSpecifierParser extends org.apache.batik.parser.TimingParser {
    protected org.apache.batik.parser.TimingSpecifierHandler timingSpecifierHandler;
    public TimingSpecifierParser(boolean useSVG11AccessKeys, boolean useSVG12AccessKeys) {
        super(
          useSVG11AccessKeys,
          useSVG12AccessKeys);
        timingSpecifierHandler =
          org.apache.batik.parser.DefaultTimingSpecifierHandler.
            INSTANCE;
    }
    public void setTimingSpecifierHandler(org.apache.batik.parser.TimingSpecifierHandler handler) {
        timingSpecifierHandler =
          handler;
    }
    public org.apache.batik.parser.TimingSpecifierHandler getTimingSpecifierHandler() {
        return timingSpecifierHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.read(
                                                 );
                              java.lang.Object[] spec =
                                parseTimingSpecifier(
                                  );
                              skipSpaces();
                              if (current != -1) {
                                  reportError(
                                    "end.of.stream.expected",
                                    new java.lang.Object[] { new java.lang.Integer(
                                      current) });
                              }
                              handleTimingSpecifier(
                                spec); }
    protected void handleTimingSpecifier(java.lang.Object[] spec) {
        int type =
          ((java.lang.Integer)
             spec[0]).
          intValue(
            );
        switch (type) {
            case TIME_OFFSET:
                timingSpecifierHandler.
                  offset(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ));
                break;
            case TIME_SYNCBASE:
                timingSpecifierHandler.
                  syncbase(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ),
                    (java.lang.String)
                      spec[2],
                    (java.lang.String)
                      spec[3]);
                break;
            case TIME_EVENTBASE:
                timingSpecifierHandler.
                  eventbase(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ),
                    (java.lang.String)
                      spec[2],
                    (java.lang.String)
                      spec[3]);
                break;
            case TIME_REPEAT:
                {
                    float offset =
                      ((java.lang.Float)
                         spec[1]).
                      floatValue(
                        );
                    java.lang.String syncbaseID =
                      (java.lang.String)
                        spec[2];
                    if (spec[3] ==
                          null) {
                        timingSpecifierHandler.
                          repeat(
                            offset,
                            syncbaseID);
                    }
                    else {
                        timingSpecifierHandler.
                          repeat(
                            offset,
                            syncbaseID,
                            ((java.lang.Integer)
                               spec[3]).
                              intValue(
                                ));
                    }
                    break;
                }
            case TIME_ACCESSKEY:
                timingSpecifierHandler.
                  accesskey(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ),
                    ((java.lang.Character)
                       spec[2]).
                      charValue(
                        ));
                break;
            case TIME_ACCESSKEY_SVG12:
                timingSpecifierHandler.
                  accessKeySVG12(
                    ((java.lang.Float)
                       spec[1]).
                      floatValue(
                        ),
                    (java.lang.String)
                      spec[2]);
                break;
            case TIME_MEDIA_MARKER:
                timingSpecifierHandler.
                  mediaMarker(
                    (java.lang.String)
                      spec[1],
                    (java.lang.String)
                      spec[2]);
                break;
            case TIME_WALLCLOCK:
                timingSpecifierHandler.
                  wallclock(
                    (java.util.Calendar)
                      spec[1]);
                break;
            case TIME_INDEFINITE:
                timingSpecifierHandler.
                  indefinite(
                    );
                break;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
