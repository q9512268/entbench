package org.apache.batik.util;
public abstract class Platform {
    public static boolean isOSX = java.lang.System.getProperty("os.name").
      equals(
        "Mac OS X");
    public static boolean isJRE13 = java.lang.System.getProperty("java.version").
      startsWith(
        "1.3");
    public static void unmaximize(java.awt.Frame f) { if (!isJRE13) {
                                                          try {
                                                              java.lang.reflect.Method m1 =
                                                                java.awt.Frame.class.
                                                                getMethod(
                                                                  "getExtendedState",
                                                                  (java.lang.Class[])
                                                                    null);
                                                              java.lang.reflect.Method m2 =
                                                                java.awt.Frame.class.
                                                                getMethod(
                                                                  "setExtendedState",
                                                                  new java.lang.Class[] { java.lang.Integer.
                                                                                            TYPE });
                                                              int i =
                                                                ((java.lang.Integer)
                                                                   m1.
                                                                   invoke(
                                                                     f,
                                                                     (java.lang.Object[])
                                                                       null)).
                                                                intValue(
                                                                  );
                                                              m2.
                                                                invoke(
                                                                  f,
                                                                  new java.lang.Object[] { new java.lang.Integer(
                                                                    i &
                                                                      ~6) });
                                                          }
                                                          catch (java.lang.reflect.InvocationTargetException ite) {
                                                              
                                                          }
                                                          catch (java.lang.NoSuchMethodException nsme) {
                                                              
                                                          }
                                                          catch (java.lang.IllegalAccessException iae) {
                                                              
                                                          }
                                                      }
    }
    public Platform() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYa2wU1xW+u34b4xexoQQMGINqHjulJEGRSQo4ODZZ461N" +
       "aGvSLHdn7toDszPDzB17MaUEpBQaVTQCktI28KekD0RCVDVq1SqUqo8kSlME" +
       "jdokqEnb/EjaBCn8aJyWtum5987sPHbXKD+60s7Ozj333HPP+c53zp1z11CV" +
       "baFOE+sKTtC9JrETKXafwpZNlF4N2/Y2eJqWH/nL8QPTv687GEfVo6hxHNuD" +
       "MrZJn0o0xR5FC1XdpliXib2VEIXNSFnEJtYEpqqhj6I21R7ImZoqq3TQUAgT" +
       "2I6tJGrBlFpqxqFkwFVA0aIkt0bi1kgbowI9SdQgG+Zef8L80ITewBiTzfnr" +
       "2RQ1J3fhCSw5VNWkpGrTnryFVpqGtndMM2iC5Glil3a764gtyduL3ND5TNMH" +
       "Nx4db+ZumIN13aB8i/YwsQ1tgihJ1OQ/3ayRnL0HfRlVJNGsgDBFXUlvUQkW" +
       "lWBRb7++FFg/m+hOrtfg26GepmpTZgZRtCSsxMQWzrlqUtxm0FBL3b3zybDb" +
       "xYXdeuGObPGxldKJbzzY/MMK1DSKmlR9hJkjgxEUFhkFh5Jchlj2RkUhyihq" +
       "0SHgI8RSsaZOudFutdUxHVMHIOC5hT10TGLxNX1fQSRhb5YjU8MqbC/LQeX+" +
       "q8pqeAz22u7vVeywjz2HDdarYJiVxYA9d0rlblVXOI7CMwp77LoPBGBqTY7Q" +
       "caOwVKWO4QFqFRDRsD4mjQD49DEQrTIAghbHWhmlzNcmlnfjMZKmaF5ULiWG" +
       "QKqOO4JNoagtKsY1QZTmR6IUiM+1reuP7tP79TiKgc0KkTVm/yyY1BGZNEyy" +
       "xCKQB2Jiw4rk47j9uSNxhEC4LSIsZH78pesbVnVcfEHI3FpCZiizi8g0LZ/J" +
       "NF5e0Nt9ZwUzo9Y0bJUFP7RznmUpd6QnbwLTtBc0ssGEN3hx+DdfeOgseTeO" +
       "6gdQtWxoTg5w1CIbOVPViHUv0YmFKVEGUB3RlV4+PoBq4D6p6kQ8HcpmbUIH" +
       "UKXGH1Ub/D+4KAsqmIvq4V7Vs4Z3b2I6zu/zJkKoGb6oDb4dSHz4L0VpadzI" +
       "EQnLWFd1Q0pZBts/CyjnHGLDvQKjpiFlAP+7V69JrJNsw7EAkJJhjUkYUDFO" +
       "xKDrEg3TrGHlEgxo5v9/iTzb5ZzJWAwCsCCa/hpkTr+hKcRKyyecTZuvP51+" +
       "SUCLpYPrH4o6YJ2EWCfB13ED6K6DYjGu/ha2nhiCyOyGHAeSbege+eKWnUc6" +
       "KwBU5mQluJWJLi8qOr0+GXgMnpbPXR6evvRy/dk4igNfZKDo+MzfFWJ+Ubgs" +
       "QyYKUE+5GuDxoFSe9UvagS6enDy4/cCnuB1BMmcKq4CH2PQUo+DCEl3RJC6l" +
       "t+nwOx+cf3y/4adzqDp4Ra1oJmOJzmgwo5tPyysW42fTz+3viqNKoB6gW4oh" +
       "PYDJOqJrhNiix2Netpda2DALMtbYkEeX9XTcMib9JxxlLezSJgDH4BAxkJP2" +
       "XSPmqVd/97e13JMevzcFCvMIoT0BTmHKWjl7tPjo2mYRAnJ/Opk6/ti1wzs4" +
       "tEBiaakFu9i1F7gEogMefPiFPa+9+caZV+I+HCkUVScD/Ume7+WWj+ATg+9/" +
       "2ZfxAHsg+KC11yWlxQVWMtnKy33bgJ80SGAGjq77dQCfmlVxRiMsF/7dtGzN" +
       "s+8dbRbh1uCJh5ZVN1fgP//EJvTQSw9Od3A1MZnVR99/vpgg3Tm+5o2Whfcy" +
       "O/IHryz85vP4FNA3UKatThHOgoj7A/EA3sZ9IfHr2sjYHezSZQcxHk6jQB+T" +
       "lh995f3Z29+/cJ1bG26EgnEfxGaPQJGIAiy2CLmXECuz0XaTXefmwYa5UdLp" +
       "x/Y4KLvt4tYHmrWLN2DZUVhWBrq0hyxgunwISq50Vc3rv/hl+87LFSjeh+o1" +
       "Ayt9mCccqgOkE3scSDJvfmaDsGOy1qsZeVTkIeb0RaXDuTlnUh6AqZ/M/dH6" +
       "751+g6NQwO5WPj1usyYtyo280/bT+r2r337r59PfqRF1urs8l0XmzfvXkJY5" +
       "9NcPiyLBWaxEDxGZPyqde2J+793v8vk+nbDZS/PF1QUI15/76bO5f8Q7q38d" +
       "RzWjqFl2u9rtWHNYJo9CJ2d7rS50vqHxcFcmWpCeAl0uiFJZYNkokflVDe6Z" +
       "NLufHUFdK4vinfDtclG3NIq6GOI3/XzKMn79JLusFCFkt6uAVGzeO+cLijk8" +
       "WjyFJRRTVKXaQyOf55kVwAA7NY04GZumLDUHrDjh9nTn26f3/Kpm6h6vXys1" +
       "RUjeZw9e+mn/22nOurWsjm7zdh+okButsQCbN7PLapZiMyAsYpG0v/XN3U+8" +
       "85SwKAqniDA5cuKRjxJHTwg2FH370qLWOThH9O4R65bMtAqf0ff2+f0/+/7+" +
       "w8Kq1nAXuhkOWU/94T+/TZz884slWp+ajGFoBOuFNI8Vepj2qMPFtqrXnPrn" +
       "ga+8OgRFdwDVOrq6xyEDShh8NbaTCUTAPxX4gHQ3yGoPRbEVpunWVXZdxy4D" +
       "Alk9ZUlpUxjSd8F3hYu87jKQ3jkTpNklWQLO3WWUgvNUe8vw5jVr2d/PRszH" +
       "M5ifnzmzajEA2wJ+9o3hn6YZSkWAYxFDzcJyZyyOmDOHTpxWhp5cE3cr3uco" +
       "1AHDXK2RCaIFVMU4/qJ0PchPlj73rbsyXXH12LyG4i6Waeoo06OuKJ910QWe" +
       "P/T3+dvuHt/5MdrTRZH9R1X+YPDci/cul4/F+eFYUG3RoTo8qSeM8XqLUMfS" +
       "w6juDGOS4VFyIyZFMekD5mMCspzGSEvjZTL7P4+iRl6z8SRN9IGjCF9+3wxd" +
       "0AF2cSiqd/QczgPnTIleeNhlJvaznaLKCUNVfNhP3CxrQ60Ee7AhD4j3jlqs" +
       "uZhX9BJHvHiQnz7dVDv39P1/5O1+4eVAAzB+1tG0YO0L3FebFsmqfEcNohIK" +
       "pvkqRW0lj32wJfbDjT0iZL9GUXNUFooZ/w3KfR285ctBiRQ3QZFjFFWACLs9" +
       "bnqhaeahYeU/Icp/PhbO54J7227m3gAFLA0lGH+B5iWDI16hQYk9vWXrvut3" +
       "PCmOK7KGp6aYlllA4eJQVEioJWW1ebqq+7tvND5Tt8wjldBxKWgbjzogkx8t" +
       "5kf6d7ur0Ma/dmb9hZePVF+BsrUDxTBFc3YUN0p504Fs35EsVayAbvjRoqf+" +
       "rZ2XPnw91sr7UZfXOmaakZaPX7iayprmt+KobgD6Fl0hed7F3bNXHybyhBWq" +
       "fdUZw9EL79oaGTQxe7nGPeM6dHbhKTvJUtRZ3AoUn+6hVZ8k1iam3a2lIQpy" +
       "TDM4yj27Q+Qn8zRgLZ0cNE33gFfXyD1vmjzvvssuD/wP1n3n4yUXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Dx/8/Tf/9gvfyutc/wtP5lhdVSEAAA==");
}
