package edu.umd.cs.findbugs.filter;
public class DesignationMatcher implements edu.umd.cs.findbugs.filter.Matcher {
    private final edu.umd.cs.findbugs.filter.StringSetMatch designations;
    public DesignationMatcher(java.lang.String designations) { super();
                                                               this.designations =
                                                                 new edu.umd.cs.findbugs.filter.StringSetMatch(
                                                                   designations);
    }
    @java.lang.Override
    public boolean match(edu.umd.cs.findbugs.BugInstance bugInstance) {
        return designations.
          match(
            bugInstance.
              getUserDesignationKey(
                ));
    }
    @java.lang.Override
    public java.lang.String toString() { return "Designations(designations=" +
                                         designations +
                                         ")"; }
    @java.lang.Override
    public int hashCode() { return designations.hashCode(
                                                  );
    }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.filter.DesignationMatcher)) {
                                                    return false;
                                                }
                                                edu.umd.cs.findbugs.filter.DesignationMatcher other =
                                                  (edu.umd.cs.findbugs.filter.DesignationMatcher)
                                                    o;
                                                return designations.
                                                  equals(
                                                    other.
                                                      designations);
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean disabled)
          throws java.io.IOException { xmlOutput.
                                         startTag(
                                           "Designation");
                                       if (disabled) {
                                           xmlOutput.
                                             addAttribute(
                                               "disabled",
                                               "true");
                                       }
                                       addAttribute(
                                         xmlOutput,
                                         "designation",
                                         designations);
                                       xmlOutput.
                                         stopTag(
                                           true);
    }
    public void addAttribute(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                             java.lang.String name,
                             edu.umd.cs.findbugs.filter.StringSetMatch matches)
          throws java.io.IOException { java.lang.String value =
                                         matches.
                                         toString(
                                           );
                                       if (value.
                                             length(
                                               ) !=
                                             0) {
                                           xmlOutput.
                                             addAttribute(
                                               name,
                                               value);
                                       } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUZa4wV1fncu+yDZWEfPF2eiwtmQe8VfFS6gMLKyuJddsMi" +
       "aZfqMnfm3N1h584MM2d2L2sRxTRikxKqqLQR+gejpSi0KWmbqqE19VFtE9EW" +
       "aSPaaqLV0kqaalPa2u87Z+bO4z7QhNKbzLlzz/nOd77349wjZ0mlbZE5VGcJ" +
       "tt2kdmKNznoly6ZKhybZ9kaYG5AfqZD+dsf765fFSVU/mTQk2d2yZNNOlWqK" +
       "3U9mq7rNJF2m9npKFdzRa1GbWiMSUw29n0xV7a6sqamyyroNhSLAJslKkUaJ" +
       "MUtNO4x2uQgYmZ0CSpKckuSq6HJ7itTJhrndB58RAO8IrCBk1j/LZqQhtVUa" +
       "kZIOU7VkSrVZe84ii01D2z6oGSxBcyyxVbvOFcG61HUFIph/rP7j83uHGrgI" +
       "Jku6bjDOnr2B2oY2QpUUqfdn12g0a28jd5GKFJkQAGakNeUdmoRDk3Cox60P" +
       "BdRPpLqT7TA4O8zDVGXKSBAjLWEkpmRJWRdNL6cZMNQwl3e+Gbidl+dWcFnA" +
       "4kOLk/seuaPhBxWkvp/Uq3ofkiMDEQwO6QeB0myaWvYqRaFKP2nUQdl91FIl" +
       "TR1zNd1kq4O6xBxQvycWnHRMavEzfVmBHoE3y5GZYeXZy3CDcn9VZjRpEHid" +
       "5vMqOOzEeWCwVgXCrIwEduduGTes6gojc6M78jy23goAsLU6S9mQkT9qnC7B" +
       "BGkSJqJJ+mCyD0xPHwTQSgMM0GKkuSRSlLUpycPSIB1Ai4zA9YolgBrPBYFb" +
       "GJkaBeOYQEvNES0F9HN2/fI9d+pr9TiJAc0KlTWkfwJsmhPZtIFmqEXBD8TG" +
       "ukWph6Vpz+yOEwLAUyPAAuZHXz1305VzTrwoYGYWgelJb6UyG5APpSe9Oquj" +
       "bVkFklFjGraKyg9xzr2s111pz5kQYablMeJiwls8seH5L999mH4YJ7VdpEo2" +
       "NCcLdtQoG1lT1ah1C9WpJTGqdJHxVFc6+HoXqYb3lKpTMduTydiUdZFxGp+q" +
       "MvhvEFEGUKCIauFd1TOG925KbIi/50xCSDU8ZCk884j48G9GlOSQkaVJSZZ0" +
       "VTeSvZaB/NtJiDhpkO1QMgPGlHYG7aRtyUluOlRxkk5WScq2vwhEgAElb6bC" +
       "N4DnbonJQ9RK4BbzEp2TQ34nj8ZioIpZ0UCggQ+tNTSFWgPyPmf1mnNPDbws" +
       "jAwdw5UUI1fBsQk4NiHbCe/YhDg2UXgsicX4aVPweKF0UNkwOD9E37q2vtvX" +
       "bdk9vwKszRwdB/JG0PmhLNThRwgvrA/IR5smjrWcWfJcnIxLkSZJZo6kYVJZ" +
       "ZQ1CuJKHXY+uS0N+8tPEvECawPxmGTLwYtFS6cLFUmOMUAvnGZkSwOAlMXTX" +
       "ZOkUUpR+cmL/6D2bdl4dJ/FwZsAjKyGo4fZejOf5uN0ajQjF8Nbf9/7HRx/e" +
       "YfixIZRqvAxZsBN5mB+1h6h4BuRF86TjA8/saOViHw+xm0ngaxAW50TPCIWe" +
       "di+MIy81wHDGsLKShkuejGvZkGWM+jPcUBv5+xQwiwnoi7PhaXOdk3/j6jQT" +
       "x+nCsNHOIlzwNLGizzzwxq//dA0Xt5dR6gOlQB9l7YEohsiaeLxq9M12o0Up" +
       "wL25v/fBh87et5nbLEBcXuzAVhw7IHqBCkHMX3tx2+m3zhx6Pe7bOYM07qSh" +
       "GsrlmcR5UluGSThtoU8PREENIgRaTettOtinmlGltEbRsf5Vv2DJ8T/vaRB2" +
       "oMGMZ0ZXXhiBP3/ZanL3y3d8MoejicmYhX2Z+WAitE/2Ma+yLGk70pG75+Ts" +
       "b70gHYAkAYHZVscoj7Ux19eRqBlQlPGdmHATIuFybV7Hl6/m47UoCb6J8LVl" +
       "OCywg14RdrxAGTUg7339o4mbPnr2HGcjXIcFjaBbMtuF3eGwMAfop0ej1lrJ" +
       "HgK4a0+s/0qDduI8YOwHjDIUH3aPBZEzFzIZF7qy+nc/e27allcrSLyT1GqG" +
       "pHRK3PvIeDB7ag9B0M2ZN94ktD5aA0MDZ5UUMF8wgZKfW1yna7Im41oY+/H0" +
       "Hy5//OAZbn6mwDEzH25nhcItr+Z9jz/82hd+8/g3Hx4V9UBb6TAX2Tfjnz1a" +
       "etcf/1Egch7gitQqkf39ySOPNnes/JDv9yMN7m7NFeYuiNb+3qWHs3+Pz6/6" +
       "RZxU95MG2a2eN0mag/7bDxWj7ZXUUGGH1sPVnyh12vORdFY0ygWOjcY4P2fC" +
       "O0Lj+8RIWGtCFSbgaXE9viUa1mKEv9zKt1zBx0U4XMXVF2ek2rRU6LCA8kpI" +
       "xpIWCSeNZZAzUqf4+dr2vLGtTH4X7glS5NldxFwcv4hDSpy9opghi6UrcFic" +
       "p5B/qqIlVzDgBS3VJW9+GfLcmgM9d3apApoX/4d27Tuo9Dy2RJh1U7goXQM9" +
       "15O//fcrif1vv1Sk/hnPDPMqjY5QLUBeFR4ZcqRu3lv4VvnmpAfe+Unr4OrP" +
       "U7Lg3JwLFCX4ey4wsai0b0ZJeWHXB80bVw5t+RzVx9yIOKMov9t95KVbFsoP" +
       "xHkjJdyloAELb2oPO0mtRaFj1DeGXOXyvK1MRtOY4bqL5zZFKoCifhLD10SR" +
       "TFsKWST1RPLV3GImuNoZ9DjjpAyXSV+8BUGXzaLBhktetIk+J21DeapmoRoZ" +
       "cbu3pb1b5N2tve8Kk72syAYBN/WJ5Dc2ndr6ClduDVpTXqQBSwKrCxRaDUIy" +
       "n8InBs9/8EFicQK/ISx2uK3YvHwvhpmkbEqIMJDc0fTW8KPvPykYiMb/CDDd" +
       "ve/rnyb27BP+Jxr6ywt66uAe0dQLdnBgSF1LuVP4js73ju746RM77ou7qrkd" +
       "QmraMDQq6QXqh+oyLHZB68331z+9t6miEzy7i9Q4urrNoV1K2LqrbScd0IN/" +
       "B+Dbuks1ypyR2CIvUfPQmgmH1rp8aM3bZJNfQ/VAZLBUhZaJxp+lsMCJDpPP" +
       "S+GM1QzPNa7nXHMx3LAUsjIutKfM2l4cdjNSwwyRsPD39b407y8pTZy+938h" +
       "t3pcmw7PDS6rN1wMuZVCVkY2B8qsfQeHR0BuQ1C3dhiuBW1zvQm/RgLvY4xU" +
       "qO6tZMBL8OfOgOnuv/TC5rniMnhWuPJZcTGEXQpZ+VwR6G1EOcnP/n4ZLRzH" +
       "4XvQH9JtUCJwENsX55FLL07efN8IT6crgc6LIc5SyCKSiYtC1xNnS7HUm8tq" +
       "iS91p3ocZjq80bU5RT8vrxnRr6pGoqtnTU6mJlZAfN/zODwNbjBqqYwC4mKm" +
       "P27EUBVfLc/8n9SyCZ4eV5I9ZdSCw+JCJZTaGpFcBSekAn8+x2MpDn0c/6ni" +
       "QsafL3CA0zichF5DUpT8Xzk490tfeq+V6Rw+s3hykAQL7x+xP55R8JeHuKaX" +
       "nzpYXzP94G2neE2ev0qvg7op42hasIMLvFeZFs2onLc60c+Z/OsPjDSX7k0Y" +
       "/q+BL5z8t8WWd8EKi2wB0/Neg9DvMVLrQzMSl0PLH0Dl4i5DZIYxuHgWpmAR" +
       "X/9ilo5NsUBLQwJBfOqFFJTfErwQw4qQ/ynllUyO+FtqQD56cN36O89d/5i4" +
       "kJM1aWwMsUyAQkncDeYbj5aS2DxcVWvbzk86Nn6BV8E1CoJ9458ZCK4dYJsm" +
       "2kRz5LbKbs1fWp0+tPzZX+2uOgm152YSk0BHmwsvBXKmAx3f5lRhQQhNGr9G" +
       "a2/79vaVV2b++nt+7UIKLlui8ANy/4NvdB0b/uQm/i9IJVgAzfHbipu36xuo" +
       "PGKFqstJaK4SVjdcDq74JuZn8foWuuXCmrnw0rtWM0aptdpwdAXRQH06wZ/x" +
       "Gs5Qr+aYZmSDPxPoK+4SMROlD/Y3kOo2TbelqHjH5G67s3j5AGNMvOJb/L/1" +
       "/RKSnx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4igAAA==");
}
