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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
