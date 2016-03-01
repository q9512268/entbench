package edu.umd.cs.findbugs;
public class BugPattern implements java.lang.Comparable<edu.umd.cs.findbugs.BugPattern> {
    private final java.lang.String type;
    private final java.lang.String abbrev;
    private final java.lang.String category;
    private final boolean experimental;
    private final java.lang.String shortDescription;
    private final java.lang.String longDescription;
    private final java.lang.String detailText;
    private final java.lang.String url;
    final int cweid;
    int priorityAdjustment;
    private boolean deprecated;
    public BugPattern(java.lang.String type, java.lang.String abbrev, java.lang.String category,
                      boolean experimental,
                      java.lang.String shortDescription,
                      java.lang.String longDescription,
                      java.lang.String detailText,
                      java.lang.String bugsUrl,
                      int cweid) { super();
                                   this.type = type;
                                   this.abbrev = abbrev.intern();
                                   this.category = category.intern(
                                                              );
                                   this.experimental = experimental;
                                   this.shortDescription = shortDescription;
                                   this.longDescription = longDescription;
                                   this.detailText = detailText;
                                   this.cweid = cweid;
                                   this.url = bugsUrl; }
    static final edu.umd.cs.findbugs.BugPattern REALLY_UNKNOWN = new edu.umd.cs.findbugs.BugPattern(
      "REALLY_UNKNOWN",
      "TEST",
      "CORRECTNESS",
      false,
      "Unknown warning; core bug patterns not found",
      ("Unknown warning BUG_PATTERN in {1}; core bug patterns not fo" +
       "und"),
      ("<p>A warning was recorded, but findbugs can\'t find the desc" +
       "ription of this bug pattern ") +
      ("and so can\'t describe it. This should occur only in cases o" +
       "f a bug in FindBugs or its configuration, ") +
      ("or perhaps if an analysis was generated using a plugin, but " +
       "that plugin is not currently loaded. ") +
      "</p>",
      null,
      0);
    public java.lang.String getType() { return type; }
    public java.lang.String getAbbrev() { return abbrev; }
    @javax.annotation.Nonnull
    public edu.umd.cs.findbugs.BugCode getBugCode() { return edu.umd.cs.findbugs.DetectorFactoryCollection.
                                                        instance(
                                                          ).
                                                        getBugCode(
                                                          abbrev);
    }
    public java.lang.String getCategory() { return category;
    }
    public int getPriorityAdjustment() { return priorityAdjustment;
    }
    public void adjustPriority(int change) { priorityAdjustment +=
                                               change;
    }
    public java.lang.String getCategoryAbbrev() {
        java.lang.String categoryAbbrev =
          null;
        edu.umd.cs.findbugs.BugCategory bcat =
          edu.umd.cs.findbugs.DetectorFactoryCollection.
          instance(
            ).
          getBugCategory(
            getCategory(
              ));
        if (bcat !=
              null) {
            categoryAbbrev =
              bcat.
                getAbbrev(
                  );
        }
        if (categoryAbbrev ==
              null) {
            categoryAbbrev =
              edu.umd.cs.findbugs.TextUIBugReporter.
                OTHER_CATEGORY_ABBREV;
        }
        return categoryAbbrev;
    }
    public boolean isExperimental() { return experimental;
    }
    public java.lang.String getShortDescription() {
        return shortDescription;
    }
    public java.lang.String getLongDescription() {
        return longDescription;
    }
    public java.lang.String getDetailText() { return detailText;
    }
    public java.lang.String getDetailPlainText() {
        try {
            return edu.umd.cs.findbugs.util.HTML.
              convertHtmlSnippetToText(
                detailText);
        }
        catch (java.lang.Exception e) {
            return detailText;
        }
    }
    public java.lang.String getDetailHTML() { return getDetailHTML(
                                                       getDetailText(
                                                         ));
    }
    public java.lang.String getDetailHTML(java.lang.String detailText) {
        java.lang.StringBuilder buf =
          new java.lang.StringBuilder(
          );
        buf.
          append(
            "<!DOCTYPE HTML\">\n");
        buf.
          append(
            "<HTML><HEAD><TITLE>");
        buf.
          append(
            getShortDescription(
              ));
        buf.
          append(
            "</TITLE></HEAD><BODY><H1>");
        buf.
          append(
            wrapInDescriptionLink(
              getShortDescription(
                )));
        buf.
          append(
            "</H1>\n");
        buf.
          append(
            detailText);
        buf.
          append(
            "</BODY></HTML>\n");
        return buf.
          toString(
            );
    }
    public java.lang.String wrapInDescriptionLink(java.lang.String text) {
        if (url ==
              null) {
            return text;
        }
        return "<a href=\"" +
        url +
        "#" +
        type +
        "\">" +
        text +
        "</a>";
    }
    @java.lang.Override
    public int compareTo(edu.umd.cs.findbugs.BugPattern other) {
        return type.
          compareTo(
            other.
              type);
    }
    @java.lang.Override
    public int hashCode() { return type.hashCode(
                                          ); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.BugPattern)) {
                                                    return false;
                                                }
                                                edu.umd.cs.findbugs.BugPattern other =
                                                  (edu.umd.cs.findbugs.BugPattern)
                                                    o;
                                                return type.
                                                  equals(
                                                    other.
                                                      type);
    }
    public int getCWEid() { return cweid;
    }
    @java.lang.Override
    public java.lang.String toString() { return "BugPattern[" +
                                         type +
                                         "]";
    }
    void setDeprecated(boolean deprecated) {
        this.
          deprecated =
          deprecated;
    }
    public boolean isDeprecated() { return deprecated;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV8C7DkWHlez+zu7JOdZZZdlgWWXZjF7PZ61C+p1bXEQepu" +
       "qR9SSy2pX0pg0LvVrZbUerdgHSBO2MTFo5Ll4QpsxVVsOXHWhopN4qqEGBeV" +
       "GPyqmHIcQyXgOKQMJgQoGzsVsMmRuu/0vXfv3J1lhlt1ztU9L33ff/7zn/9I" +
       "v+7z3yrc4nuFoutYG8NygktaElxaWPClYONq/qUeBbOS52tq05J8XwBll5XX" +
       "f+r8X37/g/N7zhbOiYV7Jdt2AikwHdvnNN+xIk2lCuf3pW1LW/lB4R5qIUUS" +
       "FAamBVGmHzxJFe481DUoXKQOIEAAAgQgQDkECNu3Ap1eptnhqpn1kOzAXxd+" +
       "unCGKpxzlQxeUHjk6CCu5Emr3TBszgCMcFv29xiQyjsnXuHhK9y3nF9A+ENF" +
       "6JmPvO2ef31T4bxYOG/afAZHASACcBOxcNdKW8ma52Oqqqli4eW2pqm85pmS" +
       "ZaY5brFwwTcNWwpCT7sipKwwdDUvv+decncpGTcvVALHu0JPNzVLPfjrFt2S" +
       "DMD1/j3XLUMiKwcE7zABME+XFO2gy81L01aDwuuO97jC8WIfNABdb11pwdy5" +
       "cqubbQkUFC5s586SbAPiA8+0DdD0FicEdwkKD1510EzWrqQsJUO7HBQeON6O" +
       "3VaBVrfngsi6BIX7jjfLRwKz9OCxWTo0P98avPn977A79tkcs6opVob/NtDp" +
       "oWOdOE3XPM1WtG3Hux6nPizd/5mnzxYKoPF9xxpv2/zbd373LU889NnPb9u8" +
       "+oQ2jLzQlOCy8gn57t9/TfOxxk0ZjNtcxzezyT/CPFd/dlfzZOKClXf/lRGz" +
       "yksHlZ/l/tPsXb+offNs4Y5u4ZziWOEK6NHLFWflmpbmkZqteVKgqd3C7Zqt" +
       "NvP6buFWcE2ZtrYtZXTd14Ju4WYrLzrn5H8DEelgiExEt4Jr09adg2tXCub5" +
       "deIWCoVbQSqgIL2hsP3JfweFETR3VhokKZJt2g7Eek7G34c0O5CBbOeQDpRJ" +
       "Dg0f8j0FylVHU0MoXKmQ4u8r8dBgpQDokH0pa+P+uAZOMkb3xGfOAGG/5vhS" +
       "t8Aq6TiWqnmXlWdCvP3dX77822evqP5OFkHhIXCfS+A+lxT/0sF9Lu3vUzhz" +
       "Jh/+Fdn9tvMIZmEJ1jOwdHc9xr+19/anX38TUCA3vhmIMGsKXd3gNvcWoJvb" +
       "OQWoYeGzH43fPf57pbOFs0ctZ4YRFN2RdWcze3fFrl08vmJOGvf8e7/+l5/8" +
       "8FPOfu0cMcW7Jf3CntmSfP1xaXqOAgTlafvhH39Y+vTlzzx18WzhZrDOgW0L" +
       "JKCLwGw8dPweR5bmkwdmLuNyCyCsO95KsrKqA9t0RzD3nHhfkk/z3fn1y4GM" +
       "78x09T6QmJ3y5r+z2nvdLH/FVi2ySTvGIjejf4t3P/5Hv/eNai7uA4t7/tAe" +
       "xmvBk4dWeTbY+Xw9v3yvA4KnaaDdf/8o+08/9K33/p1cAUCLN5x0w4tZ3gSr" +
       "G0whEPM/+Pz6S1/9yif+4OxeaQKwzYWyZSrJFZJZeeGOU0iCu71xjwdYCQss" +
       "qExrLo7slaOauinJlpZp6Q/OP1r+9P9+/z1bPbBAyYEaPfHiA+zLX4UX3vXb" +
       "b/urh/JhzijZLrWX2b7Z1vTdux8Z8zxpk+FI3v3F1/7cb0ofB0YUGC7fTLXc" +
       "Ft2ey+D2nPl9wJvIe2Yb0qXthpSVl/IMjPvYKc6MZ67AhEW7DQB66sJXlx/7" +
       "+i9tjfvx3eJYY+3pZ/7xDy+9/5mzh7bUN7xgVzvcZ7ut5pr2su2k/RD8nAHp" +
       "b7KUTVZWsDWrF5o72/7wFePuugmg88hpsPJbEH/6yaf+3b946r1bGheO7iht" +
       "4DD90h/+9e9c+ugff+EE03ar7DiWJtl7CR6SZZZXsgzZKh0aFG4C3kXOCMpL" +
       "Hs/zSxmFfIoKed1bsux1/mEbdHQqDjl1l5UP/sF3Xjb+zn/4bo7uqFd4eMnR" +
       "kruV5d1Z9nAmmlceN7gdyZ+DdrXPDv7uPdZnvw9GFMGICnCFfMYDVj45skB3" +
       "rW+59cu/8bn73/77NxXOEoU7LEdSCSm3dYXbgZHR/DnYIBL3b79lu8bi20B2" +
       "T0618ALyWzE9kP91/nRVJDKnbm8pH/h/jCW/50/+7wuEkBv4E7TzWH8Rev5j" +
       "DzZ/6pt5/72lzXo/lLxw5wMO8L5v5RdX3zv7+nP/8WzhVrFwj7LzrseSFWb2" +
       "SwQepX/gcgMP/Ej9Ue9w6wo9eWUnec3x5XHotsdt/F4twXXWOru+45hZv5BJ" +
       "+SGQLu4s3sXjZv1MIb8Y5F0eyfOLWfYT+ZycBQrvemYEVlcAbm/akpXfAQn2" +
       "9yxtd4Ysx7KM2U5q66oK0D0K72GQ3riD98arwJtcBV52yWUZfwDrnCTLnhad" +
       "BGz6EoG9HqQ37YC96SrA3nbNwG5TgBANx9ucBO3yS4T2EyA9voP2+FWgadcM" +
       "7S6waYAD2Ao4jlJ+FoCPwdNfIrwM0hM7eE9cBZ51zfDuARbFC1qar3ime+A9" +
       "HJfg6iVCfAykSzuIl64C0b9miOctxzZeBGHwEhFmS7W0Q1i6CsL0mhHeoWrA" +
       "wlkCsKsngXvHSwT3WpAqO3CVq4B79zWDuyn0rJNQvefaUWVuXeEVINV2qGpX" +
       "QfX0yajOHAF0ixJrppr98eZjkP7RtUPKt7hXg4TsICFXgfSBkyEVDtBcACbY" +
       "8cxgg6mL0A+ydXoStA9eO7S7stLXFbbn1cLB7xOgffgUaXGHdMv1tMy+qSdZ" +
       "j49cO64s5cZN3uF661Vwffyq+9U5P3/cdGQ67+baGEXNLo8G/QEzGeT4joF8" +
       "9kVB5mMlZ8DB4pbKpfqlXFefOxnGTdnlm7Ls54/geOXCUi4e+K1jzfOBqbi4" +
       "sOon6T5yzYCA33T33sGngCV68me/9sHf+cAbvgqcm17hlihzPIBPc+gUMAiz" +
       "R3D/8PkPvfbOZ/74Z/NTE5hU/jH5z3NX9PmXRuvBjBbvhJ6iUZIf0PlBR1Mz" +
       "Zie5xDdnxvJHZhvcf1un5nexgx+qLLemmJKI03Cq2EgAwX5FkSG23u8t1GWZ" +
       "Dek2h5kbahA2A37ozyZ90adTJljziVjRSbpe5SuB0W42V0onNjpwiDaFYKLq" +
       "XIuJx8OuxRX5WpfrG1jTNYo038WWKxURTKiDY7jYrysJtZn6EJ36ELOgUtJc" +
       "r1dqKqh1aFyf1hvFenVaTXvt6objWj2IceN5zw9K0oCj9GbRmKrOYBlOhCY9" +
       "nJoTIiyGbRaOGzNbaxb7S8kxSgvDI0WrHSOY1NtY1sKkNwLRpXvm0hxMl+uU" +
       "H5DRqMauZ3FfGJOTbtC2SKGECL0xYa4aIz8ZijIulImJIZBqcyWIdaEz81vd" +
       "COe6y5Dne62oUeZKbslsrisrxC7yyRTdwNOWLNPMtCQuWrytGvPFcEGxvdZK" +
       "XBrpZKS2eozorOsJwo1FycBFedYVG9FwirtIFPNNfAaVIqGzrGuDgU13XWPV" +
       "dxb90PZIglw7KOfRbikconVRdNNgTngmPe6PqUjyk66GeuEAW6m9NSFMyqFN" +
       "jAzI4j142tP75Um74m7cAddtzyYaZznGCllS7KzRYURjRA/8qmAn/VYQr/sV" +
       "151Z/QCGhYjCqmOlqtcnzQFW4XrLpTjsEO12t4f3SjTWp8vWmoRLokeXmBIn" +
       "EfjCxySXMsw08EcSUhZxkuh2rJk+DyYsPp+uaaTeYPGmP+PUAZt2Lbbs2F6r" +
       "2m/6EDKjN2i3i7S8VkmdjhSMLuLx1OvhON1JZKxubviNW+GXq/HSEIvmmmTr" +
       "oophfD9IrW5lnUi1NTFsa0tCFjiSw8nRkjGYpdtt4CXTcMh1i94w8NCdrUu9" +
       "2hKez/sy17WrQdEvrSViShkjjOcCD00Fwyb7UzGyiM1CKcoRp6vaurLhZyuB" +
       "pE3Flfo0Giit0jTWS9wMETqjPopiS5kwuXAZzlCx2lBGfUMRw8hX7RVSjXSg" +
       "pBZEDthVpbrCKcHdFDcGUCBqnvYHFJoGExvG8ZnLOciKnHfZqCSmrG8jnrtm" +
       "DGOmiSON71rDVR0NzEmngtQhs4OEqekiG2LsmJ6tVPAOJfWl0oYXkXnoDu0J" +
       "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" +
       "IuLkEDKleZ2cBZCIcKtxCydDZDOgE02i");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "mWVqUHgZYNk6GjS6J6jdiGn8lR3BX7nxBMNT6uIsc7fTuCXIWpJpn8ByfSOm" +
       "8dd3LH/9xrN89yl1fz/L3nl4GjsCTR0j+NSNIPi5HcHP3RiCh7bNUs7kfaew" +
       "/ECWPf0iLF80ZvfFWGYRqV/csfzij4nlz53C8p9l2TPAFYo9ye3ah+xO9rDj" +
       "GNsPXa/P9wBIX96x/fINZ3tPzui5U9j+Qpb98yD7Kid7cqAJ+Qe3h5y9n39R" +
       "f//CodN9pHmeuTsu/Iiefi6WV4L01Z1Yvnrj1/KvnlL3b7Lsk0Hhtrnkz7Oz" +
       "zzGBfOqqAslq/9X1UM+dp+xQ/7Ud9a/dcI34cs7xN07h/7ks+/dB4Zy2DqXt" +
       "me2Q5/SZHx/7KxP/7R37b9/4if+9U+r+c5Z9AUx85h9P2rtPEvbUf+t6LduD" +
       "IP3Fjttf3HhuXz6l7r9l2X8B3ALn0Eepe25/+OOb1uxJTgED6Yc76j98CdQL" +
       "L6bPcE7vT0+h/o0s+xOwa/nZrnXo24kzl/b8/+f1HnnA3nzm1m3f7e8bO7d/" +
       "fkrd97Ls/wSFu0y/dfTbkD2/b78UfklQuGP/DwSyr6EfeMG/Idn+6wzll589" +
       "f9srnx391/wb+iv/3uJ2qnCbHlrW4a8mD12fAyB1M+d8+/YbSjcn8gNwqDnh" +
       "GRTQ2oPLDOqZ729b/xCg3LcOCmeVw9Vns68pd9XZN08r9XDlLaAIVGaX59yt" +
       "WdxuZw8cnuL8edeFF5PclS6Hv54//v6DDrf/4+Wy8slne4N3fBd5bvv1vmJJ" +
       "aZqNchtVuHX7jwTyQbNnzI9cdbSDsc51Hvv+3Z+6/dGD5+F3bwHv1e0Qtted" +
       "/Kl8e+UG+cft6a+98lff/AvPfiX/PuX/A+lmrsZ6RwAA");
}
