package org.apache.xml.utils;
public class XMLCharacterRecognizer {
    public static boolean isWhiteSpace(char ch) { return ch == 32 || ch ==
                                                    9 ||
                                                    ch ==
                                                    13 ||
                                                    ch ==
                                                    10; }
    public static boolean isWhiteSpace(char[] ch, int start, int length) {
        int end =
          start +
          length;
        for (int s =
               start;
             s <
               end;
             s++) {
            if (!isWhiteSpace(
                   ch[s]))
                return false;
        }
        return true;
    }
    public static boolean isWhiteSpace(java.lang.StringBuffer buf) { int n =
                                                                       buf.
                                                                       length(
                                                                         );
                                                                     for (int i =
                                                                            0;
                                                                          i <
                                                                            n;
                                                                          i++) {
                                                                         if (!isWhiteSpace(
                                                                                buf.
                                                                                  charAt(
                                                                                    i)))
                                                                             return false;
                                                                     }
                                                                     return true;
    }
    public static boolean isWhiteSpace(java.lang.String s) {
        if (null !=
              s) {
            int n =
              s.
              length(
                );
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                if (!isWhiteSpace(
                       s.
                         charAt(
                           i)))
                    return false;
            }
        }
        return true;
    }
    public XMLCharacterRecognizer() { super(
                                        );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CP21m9IoqadMX3Q5sY/ZdHEkhSQdi02YZbxQt9aGhNB9wWLJoFSwrVJCDfCC" +
       "YqINj2H4uMXTXX6F9OtaYRoSFavFM8UpXKsl+LTFpuamFKVpvaj3690ZqvYr" +
       "8wkyWnKDlDAU1Z845XVMbVApZTaVsT1XyH6ZKSARZdbCId+y1921wNBYK+wX" +
       "Ni2UCZRFVWeDGdXgh0OJp0KzV1Lxja0k8LygynZam86tajd0S0u+WPWnEdmT" +
       "qrhV6MtukSjVA+BcQ6+xGgt8oQsDHYbTBdpJtWERHibtGWxJTqtRrAcjNeI8" +
       "Q5S8JoFNMMZTw7UAy3gUa3CtrvCVxgalB5iSxp5Sp21UW0+isMHDZtUtavYa" +
       "CZMCI5XxZs+uSdSquqh3rHoAk8UxH4ma4rvVCW11zU3BW82Wy1YRrdj6uimm" +
       "tRRlJ5wEN4KEmJYSEo6lEryOmqWa0Rcnijlso8t1x8dGZFq3W7HdmU7NztSv" +
       "k7O0Ox+4zLC0Wk/688mSaqaLdYsP7TbZLE680SrqWS4fTTbImhwXzQWGl9wy" +
       "hyCMgBcmSkhgiRVLCdkptWFyk3a52Ct5RpkRWonUIyoxAjINiuWtToyvWMrg" +
       "NrrvF1tjzPSm8BrbOB5VYuVaqVNoV9OmJzcLvE8NJ8u6X1to9aXcsSslYLht" +
       "0kFX/c50UFFNopd4baLQSrgmFUZ8MhDK4byaMJ6tV0LPGqIpEi+o4TTDS1eS" +
       "GIeUvYaVhY558Tzu4PDcR9N4jCJFxEf5piDx8MrV+VLJiigl8vmaN2PWYb+S" +
       "lKNmQ43ZStGucN6cSAYVk+m05HWoeiBVINhBoFiMhc9B+qA0Q8xp4HOiVzFh" +
       "qdGB+yVNdaa6b8YChiMOmnJWf60VxU0rYiRhWMfEENPI2ai6mUpdA6sRdR0e" +
       "ob0WBy+TcS0MtaSkyAMVrpSaM1uz49lGcepzdeaB4y9eoSO9Ly1YqdMal1OK" +
       "6C+DGKOZ2rKMzBEmpNdwsgoMNE4rM1oehssUGTGlGsgP6lovMtIk4dRpeSFY" +
       "dsQqI3VurEZ2o8KrSz2pEuPJRui26IJiBOuSulx6UmWy1hNtyZE2YovrFSzK" +
       "IZk2Nl0aJqpDZtTeBLLet0hukw55ZxIoKt7vrzmQlQhcrVcPktrcxDuTYREd" +
       "dfmqwqfUmjLxBbuh2Ppm2KkpA0FuiSgOgqw4dIZqPTQimJ2KiIPVGaDbZUp7" +
       "08K0JBNIo5SiVC82JoW5y5LTudsOZwtJDRs13QxkRF124fLANkepxmPL5pwE" +
       "r5nZ6+cTL+0G4Pb8smOvSAVe/LMJ4iW8+W6nHsqaRw9f8J46Wtg4cMF74BIM" +
       "yt7m77tR7Sl/k//IO556Rh5+FNm5enk4DaCzgeO+zlQixTxA6gSg9Job31oM" +
       "8tLb/qXW59/xL/dwb9De/BKu7R84wudRkh8fPPtF4jHpV3ag43tXXNcUBQ8j" +
       "XT58sXXOU4LQs7lD11v37Wn27kxjF8H3sauafez6V+fXtYKdfSvYGsCRC9pj" +
       "Vysg2TNzYOP5ADohaaKXI3k3udXdZI0VQLfo/lTTA4V1d2ukR8idXjiOqYj2" +
       "vo3ZP+x25eBa+cDqWqWUryql/DIq5fjeVe2jNzat/Fp8e7/1zG898pW3PvPI" +
       "3+c3y2d0nxc9zFtep756AOe7z77w7a/det+n8krMiYXob/f+aGH62rrzoXJy" +
       "zv4te1o5mynhVrCfn9gqZfsbQNOXsdonBxbc4ga7hcQfFelcMt91Xeh6xnQc" +
       "qCXrvjsH+4Wb2Od7s+atR+wzG0v2DfFtL4chklcNkfwReeedAXTX0Xto8K6k" +
       "Klsf/eBNdPDhrHnq5jp4+uXQwRNXdfDEy6+D/JDKAT52E0k/njW/cXNJf/Ol" +
       "SBoDrV+/yJxVye6+5l8u239mSJ965vyZVz8z+autd+/+e+IsBZ1RQ9M8WNQ4" +
       "0D/leoqq53Kc3ZY43Pzn0wH0qutVvwPoZP6bM/3cFvZ3A+i2w7DAWUB7EOb3" +
       "A+jcPkwAndp2DoL8IcACIFn3j9zrlEG2NZ342OFDfU/Fd/wwFR/IAx45FGLz" +
       "fxftnrTh9v9FV6TnnunRb3mx+tFt+VcyxTTNqJwB0XBbid47rR+6IbVdWqfI" +
       "x79/26fPPrqbWdy2ZXjfQg/w9sD166ttyw3yimj62Vf/3us/9sw38qrM/wIy" +
       "SCnI9iUAAA==");
}
