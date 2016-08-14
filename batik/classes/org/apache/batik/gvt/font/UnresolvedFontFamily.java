package org.apache.batik.gvt.font;
public class UnresolvedFontFamily implements org.apache.batik.gvt.font.GVTFontFamily {
    protected org.apache.batik.gvt.font.GVTFontFace fontFace;
    public UnresolvedFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace) {
        super(
          );
        this.
          fontFace =
          fontFace;
    }
    public UnresolvedFontFamily(java.lang.String familyName) { this(
                                                                 new org.apache.batik.gvt.font.GVTFontFace(
                                                                   familyName));
    }
    public org.apache.batik.gvt.font.GVTFontFace getFontFace() {
        return fontFace;
    }
    public java.lang.String getFamilyName() { return fontFace.
                                                getFamilyName(
                                                  ); }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.text.AttributedCharacterIterator aci) {
        return null;
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.util.Map attrs) {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfXBU1RW/uwkhH+STb5BAQpACuitWrRi/QkwgdAMpwTgu" +
       "Snh5ezf7yNv3Hu/dTTaxWGXakdopVcSPdiT/FItVFKdTp7VWB8epHyNtB/yq" +
       "dVSmOlPQMso42k5ta8+59719H/tBabU78+6+vfece+8595zfOffswVNkimWS" +
       "ZqqxCBs3qBXp0lifZFo00alKlrUJ+gble8ukj7ecWL8qTCripC4lWb2yZNFu" +
       "haoJK04WKJrFJE2m1npKE8jRZ1KLmqMSU3QtTmYqVk/aUBVZYb16giLBgGTG" +
       "SKPEmKkMZRjtsSdgZEEMdhLlO4l2BIfbY2SarBvjLvkcD3mnZwQp0+5aFiMN" +
       "sW3SqBTNMEWNxhSLtWdNssLQ1fFhVWcRmmWRberFtgrWxS7OU0HrY/WffnZH" +
       "qoGrYLqkaTrj4lkbqaWrozQRI/Vub5dK09Z2cjMpi5EaDzEjbTFn0SgsGoVF" +
       "HWldKth9LdUy6U6di8OcmSoMGTfESIt/EkMypbQ9TR/fM8xQyWzZOTNIuygn" +
       "rZAyT8S7V0T33rul4WdlpD5O6hWtH7cjwyYYLBIHhdL0EDWtjkSCJuKkUYPD" +
       "7qemIqnKhH3STZYyrEksA8fvqAU7MwY1+ZquruAcQTYzIzPdzImX5AZl/5qS" +
       "VKVhkHWWK6uQsBv7QcBqBTZmJiWwO5ulfETREowsDHLkZGz7OhAA69Q0ZSk9" +
       "t1S5JkEHaRImokracLQfTE8bBtIpOhigyci8opOirg1JHpGG6SBaZICuTwwB" +
       "VRVXBLIwMjNIxmeCU5oXOCXP+Zxaf/num7S1WpiEYM8JKqu4/xpgag4wbaRJ" +
       "alLwA8E4bXnsHmnWU7vChADxzACxoPnFN09ffV7z4RcEzfwCNBuGtlGZDcr7" +
       "h+qOntO5bFUZbqPS0C0FD98nOfeyPnukPWsAwszKzYiDEWfw8Mbnrr/lIfpB" +
       "mFT3kApZVzNpsKNGWU8bikrNNVSjpsRooodUUS3Rycd7yFR4jykaFb0bkkmL" +
       "sh5SrvKuCp3/BhUlYQpUUTW8K1pSd94NiaX4e9YghEyFh1wGz0IiPvybESma" +
       "0tM0KsmSpmh6tM/UUX4rCogzBLpNRYfA6keilp4xwQSjujkclcAOUtQeGB5l" +
       "0SQoJnqtZtp23w0/u6W0oo5H0NSM/8ciWZR0+lgoBIdwThACVPCetbqaoOag" +
       "vDezuuv0o4MvCfNCl7B1xEgE1o2IdSN83QisG8F1I4XWJaEQX24Gri/OG05r" +
       "BPwegHfasv4b123d1VoGhmaMlYOqw0Da6gtAnS44OIg+KB9qqp1oeXvls2FS" +
       "HiNNkswykorxpMMcBqSSR2xnnjYEocmNEIs8EQJDm6nLNAEAVSxS2LNU6qPU" +
       "xH5GZnhmcOIXemq0ePQouH9y+L6xWwe+dUGYhP1BAZecAniG7H0I5TnIbguC" +
       "QaF562878emhe3boLiz4oowTHPM4UYbWoEEE1TMoL18kPT741I42rvYqgG0m" +
       "gZsBIjYH1/ChTruD4ChLJQic1M20pOKQo+NqljL1MbeHW2ojf58BZlHj+OJX" +
       "bL/k3zg6y8B2trBstLOAFDxCXNFv7PvD705+lavbCSb1niygn7J2D4DhZE0c" +
       "qhpds91kUgp0b93Xd9fdp27bzG0WKBYXWrAN204ALjhCUPN3Xtj+xjtv738l" +
       "nLPzEIMInhmCRCibExL7SXUJIWG1c939AACqgA9oNW3XamCfSlKRhlSKjvWP" +
       "+iUrH//L7gZhByr0OGZ03pkncPvnria3vLTlr818mpCMAdjVmUsmUH26O3OH" +
       "aUrjuI/srccW/PB5aR/EB8BkS5mgHGZDQgdc8jmMLCkOKWsGNgkskSk/4os5" +
       "zwW8vQjVw2cifGwVNkssr6v4vdGTVg3Kd7zyUe3AR0+f5rL58zKvZfRKRrsw" +
       "RmzOzcL0s4NQtlayUkB30eH1NzSohz+DGeMwowwgbW0wAU+zPjuyqadM/eMz" +
       "z87aerSMhLtJtapLCRASXZJUgS9QKwVQnDWuulqYwlglNA1cVJInfF4HHsfC" +
       "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" +
       "V2ze/zc5LPqleR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
