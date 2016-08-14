package org.apache.batik.parser;
public class ClockParser extends org.apache.batik.parser.TimingParser {
    protected org.apache.batik.parser.ClockHandler clockHandler;
    protected boolean parseOffset;
    public ClockParser(boolean parseOffset) { super(false, false);
                                              this.parseOffset = parseOffset;
    }
    public void setClockHandler(org.apache.batik.parser.ClockHandler handler) {
        clockHandler =
          handler;
    }
    public org.apache.batik.parser.ClockHandler getClockHandler() { return clockHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.read();
                              float clockValue = parseOffset ? parseOffset(
                                                                 )
                                : parseClockValue(
                                    );
                              if (current != -1) { reportError("end.of.stream.expected",
                                                               new java.lang.Object[] { new java.lang.Integer(
                                                                 current) });
                              }
                              if (clockHandler !=
                                    null) { clockHandler.
                                              clockValue(
                                                clockValue);
                              } }
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
      ("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" +
       "2u79j5ElPvn3/36NEXJEvo7HnejPw89//D7ibd/N+x9CY9b7geTa9QpsXA/7" +
       "lj9l/+vOI7f+6Q50locuSXu7Ylaw4gxweLATDPe3ymDnfKz9+K5uu4W5cgD9" +
       "rzvp8keGPQnKh64G3jPq7P38CRy+kFn5TeB5ZA+iHjmJw6eg/IXMuzycl5ez" +
       "4o37sHfOC9wISKnIOW80AnvlbO3tCo4MIirv8Vqwat10od4j3oJ+Vr4lK3rb" +
       "6X/7DV2leVyRTPg37inyxhsoMr2BItnrcF+D23PZtvu0rAo5IdjsZQXLGSWn" +
       "gH3OlHex3WL2m7/+0Kez1zeB9SPMzy+gh2o4grUvyz2mJV3exycWGBQ48WXT" +
       "wvYNeymPv8xddreHgBOyov9rWUF8XThkNnDBeeKD//Dhr/3Ko98CQdCDzqwy" +
       "BwW+f2REKs6OWL/0/Efvv/3pb38wXw6BLdkP/C727YyrcjONs+KdWXF1X9X7" +
       "MlWn+S5yIITRMF/BFPlA2+IRfaoRWAfdH0Pb6MItXTQk6/ufAbtQFwnDJhw8" +
       "hFc1eNIKuRTluIYwMfEqQxge7w2aA9GREytCwuKyKOmj7shOQ8xEkBSJR7UR" +
       "FqflEukZXKs09eqxRQncqqozdY2jTNqLtKpdElmPKvv9km31zZ7fZ7lOP6Qj" +
       "uooFpVXFQYYJKrZmZg9BogRLA8dxuqtRgUewQVRp8YLQKLt6v47Q/V5Z0Ogq" +
       "2yw3G72gvWp4wbJbMQbTxWaOinC0wijMoAuszvbgesUlWjOZDFob1taj9pSb" +
       "MR5rsAZmLJaJaXSaHXK6WPdmHDtuCmQ7rBlyieb55chvtgliCKyyICmu3W/O" +
       "bMH1Z2pr2aSLesNtxVOh0ZVRK42afluc1ghbXFFsA4lLiwVP95RNYeaG4mQy" +
       "2zS0zdLv452JSA1GEdnlqhV3Qwm8S7WaU6rbmJS5TWXRll0JRQdlHy+qXROj" +
       "+306LtcV1uIoaTUeLriev9GmPZ0lmmM5Npd9ukI0y8Ppsu8my/aQYSQ3LC8n" +
       "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");
}
