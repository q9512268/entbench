package camera;
public class RaspiStill implements ent.runtime.ENT_Attributable {
    private final java.lang.String _raspistillPath = "/opt/vc/bin/raspistill";
    private int _picTimeout = 30000;
    private int _picWidth = 1024;
    private int _picHeight = 768;
    private java.lang.String _picName = "example.jpg";
    private java.lang.String _picType = "jpg";
    private java.lang.String _picNames = "example%d.jpg";
    private int _picLapse = 1000;
    private int _quality = 100;
    public int ENT_attribute() { if (_picHeight <= 1200) { return camera.EntMode.
                                                                    LOW_MODE;
                                 }
                                 else
                                     if (_picHeight <=
                                           1536) {
                                         return camera.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return camera.EntMode.
                                                  HIGH_MODE;
                                     } }
    public RaspiStill(int width, int height) { super();
                                               _picWidth = width;
                                               _picHeight = height;
    }
    public void TakePicture(int timeout, java.lang.String name) throws java.lang.Exception {
        java.lang.StringBuilder sb =
          new java.lang.StringBuilder(
          _raspistillPath);
        sb.
          append(
            " -n -bm");
        sb.
          append(
            " -w " +
            _picWidth);
        sb.
          append(
            " -h " +
            _picHeight);
        sb.
          append(
            " -e " +
            _picType);
        sb.
          append(
            " -q " +
            _quality);
        sb.
          append(
            " -t 1");
        sb.
          append(
            " -o " +
            name);
        java.lang.System.
          out.
          println(
            sb.
              toString(
                ));
        java.lang.Runtime.
          getRuntime(
            ).
          exec(
            sb.
              toString(
                ));
    }
    public void TakePictures() { if (_picLapse < 1000) { try {
                                                             if (_picName.
                                                                   indexOf(
                                                                     '.') !=
                                                                   -1)
                                                                 _picType =
                                                                   _picName.
                                                                     substring(
                                                                       _picName.
                                                                         lastIndexOf(
                                                                           '.') +
                                                                         1);
                                                             java.lang.StringBuilder sb =
                                                               new java.lang.StringBuilder(
                                                               _raspistillPath);
                                                             sb.
                                                               append(
                                                                 " -n -bm");
                                                             sb.
                                                               append(
                                                                 " -t " +
                                                                 _picTimeout);
                                                             sb.
                                                               append(
                                                                 " -w " +
                                                                 _picWidth);
                                                             sb.
                                                               append(
                                                                 " -h " +
                                                                 _picHeight);
                                                             sb.
                                                               append(
                                                                 " -e " +
                                                                 _picType);
                                                             sb.
                                                               append(
                                                                 " -tl " +
                                                                 _picLapse);
                                                             sb.
                                                               append(
                                                                 " -q " +
                                                                 _quality);
                                                             sb.
                                                               append(
                                                                 " -o " +
                                                                 _picNames);
                                                             java.lang.System.
                                                               out.
                                                               println(
                                                                 sb.
                                                                   toString(
                                                                     ));
                                                             java.lang.Runtime.
                                                               getRuntime(
                                                                 ).
                                                               exec(
                                                                 sb.
                                                                   toString(
                                                                     ));
                                                             java.lang.Thread.
                                                               sleep(
                                                                 _picTimeout);
                                                         }
                                                         catch (java.lang.Exception e) {
                                                             java.lang.System.
                                                               exit(
                                                                 e.
                                                                   hashCode(
                                                                     ));
                                                         }
                                 }
                                 else {
                                     try {
                                         int npics =
                                           _picTimeout /
                                           _picLapse;
                                         java.lang.System.
                                           out.
                                           format(
                                             "Taking %d pictures",
                                             npics);
                                         for (int i =
                                                0;
                                              i <
                                                npics;
                                              i++) {
                                             TakePicture(
                                               _picLapse,
                                               "example" +
                                               i +
                                               "%d.jpg");
                                             java.lang.Thread.
                                               sleep(
                                                 _picLapse);
                                         }
                                     }
                                     catch (java.lang.Exception e) {
                                         java.lang.System.
                                           err.
                                           println(
                                             e);
                                     }
                                 } }
    public void TakePictures(int lapse, int timeout) {
        _picLapse =
          lapse;
        _picTimeout =
          timeout;
        TakePictures(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457163822000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0R4AAA==");
    public RaspiStill() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        camera.RaspiStill ENT_ld =
          new camera.RaspiStill(
          );
        ENT_ld.
          _picTimeout =
          this.
            _picTimeout;
        ENT_ld.
          _picWidth =
          this.
            _picWidth;
        ENT_ld.
          _picHeight =
          this.
            _picHeight;
        ENT_ld.
          _picName =
          this.
            _picName;
        ENT_ld.
          _picType =
          this.
            _picType;
        ENT_ld.
          _picNames =
          this.
            _picNames;
        ENT_ld.
          _picLapse =
          this.
            _picLapse;
        ENT_ld.
          _quality =
          this.
            _quality;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457163822000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Pnhx65oHp2vCiy8dfOLg7ktwlreBJi2fT4sPnoyV/S7vjpW21h3nAXPFPaCt" +
       "lRbVrOnltKhtBfzRh9LFlvZ92dP1B/taI80pT+P8+/53z1A++Z/+/B6DyJan" +
       "+7jfTn8J+/IvPl39ke9k/U/XibT3s/G9SzXMv0/75n/Z/F/7L1z+1/vIYxJy" +
       "Uz1K7kXZCNLoK8GE1jvO+OELwLn288npNhO7fbIOPrPr/2eG3V2hTv0O3qfU" +
       "6f21nUUptSuEhtelowm/tLso7cEw/xRmOz4WqpiiW5h7kr+kBMLWjLLyVlp8" +
       "aBsXfeQxx9VDaJU+hKVbspGNXIDueOeUQx/mZ1nX98AXqsynUrEPtzn5qZVm" +
       "diO+md30T6S6mtY+f+w7x//npEKyG/n+6PfSW+kY8DvuOLrK6yaALwhZ6NoB" +
       "prxFYM/C69oRsGsXAFs8DLCrKbCxrm1z3F1Y+g8A6/oRrOsXwLIfBta1FBYL" +
       "9Pnivupy3iKul+D1+BGuxy/AFT4Mrispru6RU3xsB1X0A1jXzSNUNy9Adfeh" +
       "UfFH7rmL6ifeIqqPINsUEzn+vw+qv/3QppXqyrsfrJ95eFiZgT8Hr3cfwXr3" +
       "BbA+89Cw2rLjgftZ1t97i9p6Bl5PHcF66gJYP/twcwjXXUP3N/dD9XNviirj" +
       "kgXaS/lD6hBPn3/h/uM+kt6+CBNvL/tkkz599BjFe5eGeus4KRCB68HV7tbS" +
       "oO43g4WHBgUX3cdPI3Pbtua3P/NfPve7f/8D34YrYxO5FKarFlwQz4TvbpB+" +
       "Pvo7X/78+9/x6h99JnthgBob1X9d/VrK9R8+SLS0+OI5sZ5OxRrZgauCtuz5" +
       "nSzHB1oqWcYCPyNP0YdvCvY9S8fDS+vfuMIWPI4+/rVFaTahRTEeYxQqUAs2" +
       "GkYWoOt1GjUNEK3rm6giNEfzOcY1q8Z6vYzyKEq1x1Qz1MpmuU2YC8EImVq4" +
       "bHCNSsuSphhbcwSHmzjjWpkpilXXd8a9muH6Mb5x7FKRUyZsq9dosjnW7YWK" +
       "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");
}
