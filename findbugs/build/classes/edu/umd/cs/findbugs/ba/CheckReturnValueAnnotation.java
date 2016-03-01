package edu.umd.cs.findbugs.ba;
public class CheckReturnValueAnnotation extends edu.umd.cs.findbugs.ba.AnnotationEnumeration<edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation> {
    final int priority;
    final java.lang.String pattern;
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_UNKNOWN =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "UnknownCheckReturnValue",
      0,
      edu.umd.cs.findbugs.Detector.
        EXP_PRIORITY);
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_HIGH =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "CheckReturnValueHigh",
      1,
      edu.umd.cs.findbugs.Detector.
        HIGH_PRIORITY);
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_MEDIUM =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "CheckReturnValue",
      2,
      edu.umd.cs.findbugs.Detector.
        NORMAL_PRIORITY);
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_LOW =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "CheckReturnValueLow",
      3,
      edu.umd.cs.findbugs.Detector.
        LOW_PRIORITY);
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_IGNORE =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "OkToIgnoreReturnValue",
      4,
      edu.umd.cs.findbugs.Detector.
        IGNORE_PRIORITY);
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_VERY_HIGH =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "CheckReturnValueVeryHigh",
      5,
      edu.umd.cs.findbugs.Detector.
        HIGH_PRIORITY -
        1);
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_LOW_BAD_PRACTICE =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "CheckReturnValueLowBadPractice",
      6,
      "RV_RETURN_VALUE_IGNORED_BAD_PRACTICE",
      edu.umd.cs.findbugs.Detector.
        LOW_PRIORITY);
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "CheckReturnValueMediumBadPractice",
      7,
      "RV_RETURN_VALUE_IGNORED_BAD_PRACTICE",
      edu.umd.cs.findbugs.Detector.
        NORMAL_PRIORITY);
    public static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation
      CHECK_RETURN_VALUE_INFERRED =
      new edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation(
      "CheckReturnValueInferred",
      8,
      "RV_RETURN_VALUE_IGNORED_INFERRED",
      edu.umd.cs.findbugs.Detector.
        NORMAL_PRIORITY);
    private static final edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation[]
      myValues =
      { CHECK_RETURN_VALUE_UNKNOWN,
    CHECK_RETURN_VALUE_HIGH,
    CHECK_RETURN_VALUE_MEDIUM,
    CHECK_RETURN_VALUE_LOW,
    CHECK_RETURN_VALUE_IGNORE,
    CHECK_RETURN_VALUE_VERY_HIGH,
    CHECK_RETURN_VALUE_LOW_BAD_PRACTICE,
    CHECK_RETURN_VALUE_MEDIUM_BAD_PRACTICE,
    CHECK_RETURN_VALUE_INFERRED };
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation parse(java.lang.String priority) {
        if (priority ==
              null) {
            return CHECK_RETURN_VALUE_MEDIUM;
        }
        if (priority.
              endsWith(
                "HIGH")) {
            return CHECK_RETURN_VALUE_HIGH;
        }
        if (priority.
              endsWith(
                "MEDIUM")) {
            return CHECK_RETURN_VALUE_MEDIUM;
        }
        if (priority.
              endsWith(
                "LOW")) {
            return CHECK_RETURN_VALUE_LOW;
        }
        throw new java.lang.IllegalArgumentException(
          "Bad priority: " +
          priority);
    }
    public static edu.umd.cs.findbugs.ba.CheckReturnValueAnnotation[] values() {
        return myValues.
          clone(
            );
    }
    public int getPriority() { return priority; }
    public java.lang.String getPattern() { return pattern; }
    private CheckReturnValueAnnotation(java.lang.String s, int i,
                                       int p) { super(s, i);
                                                pattern = "RV_RETURN_VALUE_IGNORED";
                                                priority = p; }
    private CheckReturnValueAnnotation(java.lang.String s, int i,
                                       java.lang.String pattern,
                                       int p) { super(s, i);
                                                this.pattern = pattern;
                                                priority = p; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1aeZAU1Rl/M3uyu7AXNyywsKxZhBkOQcmisjvswsLskb3U" +
                                                              "hTD09rzdbbZnuunuWWZRFK1YkFQgRvFICvePBONRCJYllcMjpIxXBEuJiRIV" +
                                                              "j1gGr4pUSk2FqPnee93Tx3QP7BZxq97bnnd87/2+73vf973j0KcoR1XQLBzX" +
                                                              "AtqwjNVAQ1xr4xQVR0Mip6qdUBbh787i/rX5TMtKP8rtQRMGOLWZ51TcKGAx" +
                                                              "qvagCiGualycx2oLxlHSo03BKlaGOE2Q4j1okqA2xWRR4AWtWYpi0qCbU8Ko" +
                                                              "lNM0RehNaLhJJ6ChijDMJEhnEqxzVteGUREvycNm86mW5iFLDWkZM8dSNVQS" +
                                                              "3soNccGEJojBsKBqtUkFXSpL4nC/KGkBnNQCW8XlOgvWh5ensWDuI8VfnLtt" +
                                                              "oISyoJyLxyWNwlPbsSqJQzgaRsVmaYOIY+o2dCPKCqNCS2MNVYWNQYMwaBAG" +
                                                              "NdCarWD243E8EQtJFI5mUMqVeTIhDVXaicicwsV0Mm10zkAhX9Ox086Adk4K" +
                                                              "LUOZBvHOS4P7795c8mgWKu5BxUK8g0yHh0loMEgPMBTHerGi1kWjONqDSuMg" +
                                                              "7A6sCJwo7NAlXaYK/XFOS4D4DbaQwoSMFTqmySuQI2BTErwmKSl4fVSh9F85" +
                                                              "fSLXD1gnm1gZwkZSDgALBJiY0seB3uldsgeFeFRDs509UhirNkAD6JoXw9qA" +
                                                              "lBoqO85BASpjKiJy8f5gB6hevB+a5kiggIqGpnsSJbyWOX6Q68cRopGOdm2s" +
                                                              "ClqNo4wgXTQ0ydmMUgIpTXdIySKfT1tW7bs+vi7uRz6YcxTzIpl/IXSa5ejU" +
                                                              "jvuwgmEdsI5FC8J3cZOf3ONHCBpPcjRmbX59w9nVC2cde561meHSprV3K+a1" +
                                                              "CH+wd8IrM0M1K7PINPJlSRWI8G3I6Spr02tqkzJYmMkpiqQyYFQea3/2ul0P" +
                                                              "4Y/9qKAJ5fKSmIiBHpXyUkwWRKysxXGscBqONqFxOB4N0fomlAffYSGOWWlr" +
                                                              "X5+KtSaULdKiXIn+Bhb1AQnCogL4FuJ9kvEtc9oA/U7KCKE8SKgIUgVif/S/" +
                                                              "hgaCA1IMBzmeiwtxKdimSAS/GgSL0wu8HQj2gTL1JvrVoKrwQao6OJoIJmLR" +
                                                              "IK+alb1cMDSA+cF2DOsi3s2JCWwu9QDpJn+LYyUJ7vLtPh+IZKbTIIiwltZJ" +
                                                              "YhQrEX5/or7h7OHIi0zZyALROaahJTB0AIYO8GrAGDrQywW8h0Y+Hx1xIpkC" +
                                                              "UwAQ3yAYArDERTUd31+/Zc/cLNA8eXs28N4PTefaPFLItBaGiY/wR8rG76g8" +
                                                              "veRpP8oOozKO1xKcSBxMndIPposf1Fd3US/4KtNlzLG4DOLrFIkHPAr2ch06" +
                                                              "lXxpCCukXEMTLRQMh0aWbtDbnbjOHx27Z/vN3Tct9iO/3UuQIXPAwJHubcS2" +
                                                              "p2x4ldM6uNEt3n3miyN37ZRMO2FzO4a3TOtJMMx16oSTPRF+wRzuaOTJnVWU" +
                                                              "7ePAjmscrDswkbOcY9jMUK1h0gmWfADcJykxTiRVBo8LtAFF2m6WUGUtpd8T" +
                                                              "9TWKqiFt0Rcq/U9qJ8skn8KUm+iZAwV1GVd2yPe+/tKHyyi7De9SbAkLOrBW" +
                                                              "a7FohFgZtV2lptp2KhhDu7fuabvjzk93b6Q6Cy3muQ1YRfIQWDIQIbD51ue3" +
                                                              "nXr79MFX/Sk992koT1YEiJNwMoWSVKDCDChhuGpzQmASRTAVRG2quuKgoEKf" +
                                                              "wPWKmKys/xbPX3L0k30lTBFEKDH0aOH5CZjl0+rRrhc3fzmLkvHxxCWbTDOb" +
                                                              "MTtfblKuUxRumMwjefPJip89x90LHgOstCrswNTwZlEmZFHkUyFCoz2J9w0w" +
                                                              "72u3AmSldSR6VVixQgwENKQ7t6VtW/g9VW3vM8c1zaUDazfpgeDe7te2Hqfi" +
                                                              "zyc2gZSTscdbVjzYDovulTCpfAN/Pkhfk0SkQQqYkygL6Z5qTspVyXISZl6T" +
                                                              "Iba0AwjuLHt78MCZhxkApyt3NMZ79v/om8C+/UykLN6ZlxZyWPuwmIfBIVkt" +
                                                              "mV1lplFoj8Z/HNn5+AM7d7NZldm9dwMEpw//9avjgXveecHFQWQJesx6GVFy" +
                                                              "pupkVdplwwCt+WHxE7eVZTWCNWlC+Ym4sC2Bm6JWihCuqYlei7DMOIoWWKER" +
                                                              "wWjItwBkQAq+S/PldC6LUzNCdEaI1q0n2XzValnt8rKE5RH+tlc/G9/92VNn" +
                                                              "KWZ7XG81JM2czBheSrJqwvApTs+3jlMHoN1lx1o2lYjHzgHFHqDIQzCrtirg" +
                                                              "gZM2s6O3zsn72x+enrzllSzkb0QFosRFGzlqwdE4MJ1YHQDnnZSvXs0Mx/Z8" +
                                                              "yEooVJQGPq2ALN7Z7mahISZrdCHv+M2Ux1bdP3KamjCZkqhIN899uuHqczfP" +
                                                              "JL+EZJem2zyvrg4JZtM5Z5OfK6iczS86SE8GiW8iWRet2kCybsaKljFyjRR0" +
                                                              "yqxiBi0sIqGVLXqhG2XTgT7058v/cv9P79rOllYGQ+HoN/U/rWLvLe/9O037" +
                                                              "aLzgYjsc/XuChw5MD131Me1vOm7SuyqZHg5C8GP2XfpQ7HP/3Nxn/CivB5Xw" +
                                                              "+saUhnngDntgM6Yau1XYvNrq7RsrtouoTQUmM53GyzKsM2Sw2oRszbb+zSih" +
                                                              "gMhlCqTZui7NdqqhD9GPAaaJNF9AskWGU86BqJYTHS55XAaSGkQNiiApgjac" +
                                                              "UsdyU8WE86lYr3320yBV6kNVesx+m7mOBtMn6tWbBBycBhvaeGrFWOapXPg8" +
                                                              "p5LSOkhV+kjzPOaZdOdyloZy5USvKEA4kavSgwZS6WT6FIOyywiwJw+tawht" +
                                                              "iLQ3dHa1t0S668JdDZGulg0trde0GEHF6PcqDp4Mj5InV0O6RJ9xtQdPfuDB" +
                                                              "E/J5A8l2evGi2oOyhqa48GJd09p1pHqXA9Oto8RUA2mBPnKNB6YfjxlTjQdl" +
                                                              "DU1zwdTcsKapq9kN1d5RoiI8XKSPvdAD1f4xo1roQRmiZxdU4dZr3CDdOUpI" +
                                                              "9ZAW6wMHPSAdGDOkoAdld0E1rW1pbW9wQ3XvKFGthbRMH3upB6qDY0a11IMy" +
                                                              "uCYXVN0N7dd5rqv7RgmMbIJW6MMv9wB2aMzAlntQhg2DuwZG6uvWRNra60Kd" +
                                                              "TSFXwT08SnxDkFbqs7jCA99jY8Z3hQdlDVV72o3zQjw6SogCpFX6RGo9ID4x" +
                                                              "Zoi1HpQ1NMNtxbU0NrS3N6xxw/XkheMi0QdSIOlN0VUeuP6YAVfAE9dUg6IL" +
                                                              "ZYijYsPUH6v2S6nUXp6eKbCd46bCZ3+v/vKDR1kY7XZS4DgGf+D+fP6N2LP0" +
                                                              "pIAMt9IOeVmGiZEt3HzvQN0yq5FfzXvpppF579INXb6gQjhbp/S7HOxb+nx2" +
                                                              "6O2PT46vOExP1LLJ0QQZdLzzRiT9wsN2j0ExFZPshGWnZd2CUzmzBroIT7qL" +
                                                              "0J9STZGSqoUgTcTxfnZsvppkL8vmZsivn9qS3xBzlZsHOSFRimNymmTUsRNg" +
                                                              "QQqkbo6gMpk2UwVV2HZQzRSnuR15a8Ltf/9tVX/9aI5+Sdms8xzukt+zQVgL" +
                                                              "vGXtnMpzt3w0vfOqgS2jOMWd7VAFJ8kHmw+9sLaav91PL6fYPintUsveqda+" +
                                                              "OypQaGhrPyOZZ+rGyx57Hyp3JvIMW+j3M9R9QLJ3YA/FE9EzTcnQ/EPPHTVy" +
                                                              "KgX5udai2dSuPZPBriXNLdJ7qaVO/3KR47bHstQtO3lEln2F14UcPSY7eMv+" +
                                                              "kWjrfUsMm1KvoXGaJC8S8RAWLaSy6febqWnQwJOEHCF9GiGnxTGBZlieOx3G" +
                                                              "tTQDRYcULFxdQQc7l0FMX5Hsc5CqTC6NqYMxZfCFXQZFKRn4jFVfQa+eAubi" +
                                                              "YPuvRklpSYhiBgle+AmMg780RiWRT6fOjc6Lxl8vit7s8xVlqJtAslwwsEPU" +
                                                              "75Emx1O89eVdjNMpB2+KSd10SNfqSK7NwBv76qFkCzJ0zQB0Woa6GSSbqKHC" +
                                                              "fkzO982TFJMTk/4PnCgjdTMhbdLhbBo9J7y6ZkBbnaHuOySr1FAB4YTlqMZk" +
                                                              "xNyLcmBJTk88z0DIWfDUtOci7IkDf3ikOH/KSNdrLFoxniEUgRftg8VsPaKz" +
                                                              "fOfKCu4TKDuL2IEdPaH3LYb9sPsRjYb84L1JmyBrugwiC5emEDMan9bWK4CF" +
                                                              "ZmsgxtuqV2ooT6/WUBbk1spVUASV5PNKervnElvSzPI4Q9pUWviLwx1Yv8Vx" +
                                                              "6WFpvO/x3/X0XFLCG17jxZRa0ccIm5Eekhr/NcRftAcCppTJLQ65srK8Q/g2" +
                                                              "hkmmRXdO9rzbMrNAGmwrZbzMEIs5O+4VRk786fPim91O1ukjKb2rs9+p17OW" +
                                                              "FmpVP6ExXCoALwyjHJW0JI8GPB9cUVrsuoea8rqk4fUWepw9urKGdG2yX5IZ" +
                                                              "nInwyUmdE2uKvvcOw1V5HoZE+KZYpOPoqd0r6El/8ZCgChp7mMfewk22vYUz" +
                                                              "3mHU2t6IubIswp85svf5yo+6y+njH8YdgjacZKa1VTdKPmqU/IjF8jNsmPR5" +
                                                              "0EvmCH98oXB5/puvPsigee2x7H1uOPD1iQ93nn4hC+VCqEssEKdgCIU1FPB6" +
                                                              "XWclUNUJX2ugFwTNE1hvId5P1UEXe1mqNPX+QUOLvGjTK930VyQForQdK/VS" +
                                                              "Ih4lZKscEXpClq21bPeWsgP0sHuN0w4QJaknFtwXSt6ooIUXwK0UWJ0O8XnA" +
                                                              "6AnmHo0oobUSzEB5KFzX0RHpvK6tIdJd195UVx9uoAoqQ6WvgdrKNUzZaTFT" +
                                                              "XpJv8FIDUtlFs6T1sgwlKfBdjkL32D/pS29EI9DzxgaWeH6ep4o3J9jjyQh/" +
                                                              "ZGR9y/VnV9zHnoqAKuzYoWtGHnu1ktrKVXpSM2jlrqs5N+GRcfMNW1/KJmwG" +
                                                              "FjMscTbElD6ZuJzpjmcUalXqNcWpg6ueOrEn9yQs7o3IB36yfGP6/VpSToCV" +
                                                              "3RhOv3I3FKO25ufDVy3s++cb9DJXX6kzvdtH+J47Xm96ZPDL1fStXg4YNJyk" +
                                                              "F39rhuPtmB9SbPf37gtrvG1haWhu+tOF8y6k8bDNNkuMLXyGtUU6mCWWw5JG" +
                                                              "ktUmmYfNioSbZdl42fGJTAOltZ6bUB+9N11LvtT/AahOqzpFLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9aA91wt7p9AqPJF0WnA3MkStyfaai1xh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
