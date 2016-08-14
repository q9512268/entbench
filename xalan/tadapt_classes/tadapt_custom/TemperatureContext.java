package tadapt_custom;
public class TemperatureContext implements ent.runtime.ENT_Attributable {
    private int[] sleepTime = new int[] { 1000, 250, 0 };
    public int ENT_attribute() { float temp = ent.runtime.ENT_Util.Temperature.
                                   getTempC(
                                     );
                                 if (temp >= 65.0) { return tadapt_custom.EntMode.
                                                              LOW_MODE;
                                 }
                                 else
                                     if (temp >=
                                           60.0) {
                                         return tadapt_custom.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return tadapt_custom.EntMode.
                                                  HIGH_MODE;
                                     } }
    private boolean tadapt;
    TemperatureContext(boolean tadapt) { super();
                                         this.tadapt = tadapt; }
    public void sleep() { if (tadapt && sleepTime[ent.runtime.ENT_Runtime.
                                                    getObjMode(
                                                      this,
                                                      0)] > 0) { try {
                                                                     java.lang.Thread.
                                                                       sleep(
                                                                         sleepTime[ent.runtime.ENT_Runtime.
                                                                                     getObjMode(
                                                                                       this,
                                                                                       0)]);
                                                                 }
                                                                 catch (java.lang.Exception e) {
                                                                     
                                                                 }
                          } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471197471000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public TemperatureContext() { super();
    }
    public ent.runtime.ENT_Attributable ENT_copy() {
        tadapt_custom.TemperatureContext ENT_ld =
          new tadapt_custom.TemperatureContext(
          );
        ENT_ld.
          sleepTime =
          this.
            sleepTime;
        ENT_ld.
          tadapt =
          this.
            tadapt;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471197471000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VZ5b1LKYnGdxogjjHa3SKpfKU2TO6XojdkzgozNXFJW22xZKLWTIqEo3Ey7w" +
       "PrNs2TWlHqEjsUxbq2Gra0gsPR1WZaSYcWC2FIAM0PbafKldZfMNsGOcKmUf" +
       "6S4WHSG/WuaoQYV1Z3SNyikRU/JqQ3q0DBYBEZYku5rLSn3XIIq2lZ/lh6pm" +
       "CX5OI52yHZvlAVV1OzlXyo2aZqM/5UW72KfLZKWg24Nud4D6XRZeGrAD9gOK" +
       "tpwveK41iqpogTNCVl4glsBJomDjKOI3h3MOnTK16XQVzkRFIbhpsbiUWXVu" +
       "s3RmHK207gKmV1FXizy9gIZUFBIlI6Zx17HH4CT2WHJE+7WXd3S8PT0l7158" +
       "ghNjMuC9jNPheuihpKkdreQduCzbX6XfK6wd2zmR36da/pYbWL5uqlvVDn+l" +
       "5IODuRT4Sb09qaTef6NLz7Ro/My7nrqmMB/PbmxX/go+dNa3nTcYaqga++Y7" +
       "Dii97saFoXZan9mrpn3lXf9yL/+49sTLuHx68BCfh0n+QfvZr9VfK//2BnR8" +
       "t7Z25Db6INLlgxW1c67qB67FH6ir3X+wpHvv4UKqf6zx0kq6uuVvJvoXt/Wv" +
       "phXdt0wMW/Q3fdV0Nh/bBLZ6UjSlqzsGW38kWH1fN9Zf+0rDW1PVTz7JRy9d" +
       "fv2mPtl8NKXz+GObBWwrk5BfS3TourFqJdWMbeItZnilzVSqlzevbgKLqgfJ" +
       "ZF4qmTZdOUjmpSBRdJ3awXord6S6fQPvP1LHfvqmdeyP3mTsWtJ82IduPWCY" +
       "pPOJvTj9yMspbqcdH9xl+mzSeSd47ttm+r7DRcB98l63AlhfJ5WbCPGJm4x9" +
       "Mml+14dOpgXc69atQltX9oR95ucQNg2Qh48ECPSfLy1ADientEO2neU6UI5e" +
       "iaROlEIZCggeS42uc2+SAj26tbWVhIgaisaja4S1B+7WtQG+r+neXsd1wde+" +
       "vAO7/koAt119H+jln8OfP39Tf/7iTcb+OGk+50NndlSXfP/mnnX/8GXd0/jQ" +
       "HUf1mdy33nPk10zrX+DIn752/szd1/p/vS7g7/xK5mwLOjMJDGP/5cW+91OO" +
       "q070lP+z66uMtda+DOLyQPJIOv/MuU6peX2lEh/btx5tO2cq9R0vJvUuyv6r" +
       "9GQNS3/ctbPeBOufd12RP3Ot0XnyhcLH11f5siGuVgmVMy3o9PpXBbtr1kM3" +
       "pLZD6xR16ae3ffbsa3bW19vWDO95zT7eHrz+BXrVdPz0ynv1xbs//0u/f+27" +
       "aeX7/wACqMWYdScAAA==");
}
