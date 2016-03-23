package video;
public class Main implements ent.runtime.ENT_Attributable {
    int width = 0;
    int height = 0;
    public Main(int width, int height) { super();
                                         this.width = width;
                                         this.height = height; }
    public int ENT_attribute() { if (ent.runtime.ENT_Util.Battery.percentRemaining(
                                                                    ) >=
                                       0.75) { return video.EntMode.
                                                        HIGH_MODE;
                                 }
                                 else
                                     if (ent.runtime.ENT_Util.
                                           Battery.
                                           percentRemaining(
                                             ) >=
                                           0.5) {
                                         return video.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return video.EntMode.
                                                  LOW_MODE;
                                     } }
    public void execute(int timeout) { try { java.lang.String recovstr =
                                               java.lang.System.
                                               getenv(
                                                 "PANDA_RECOVER");
                                             boolean recover = true;
                                             if (recovstr != null &&
                                                   recovstr.
                                                   equals(
                                                     "false")) { recover =
                                                                   false;
                                             }
                                             video.RaspiVid dynvideo =
                                               new video.RaspiVid(
                                               this.
                                                 width,
                                               this.
                                                 height);
                                             video.RaspiVid v;
                                             int fps = 20;
                                             try { v = dynvideo; }
                                             catch (java.lang.RuntimeException e) {
                                                 v =
                                                   dynvideo;
                                                 if (recover) {
                                                     fps =
                                                       10;
                                                 }
                                             }
                                             v.TakeVideo(
                                                 "vid.mp4",
                                                 fps,
                                                 timeout);
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             exit(
                                               e.
                                                 hashCode(
                                                   ));
                                       } }
    public static void main(java.lang.String[] args) { if (args.
                                                             length <
                                                             2) {
                                                           java.lang.System.
                                                             err.
                                                             format(
                                                               "usage: [WIDTH] [HEIGHT]\n",
                                                               args[0]);
                                                           java.lang.System.
                                                             exit(
                                                               1);
                                                       }
                                                       int width =
                                                         java.lang.Integer.
                                                         parseInt(
                                                           args[0]);
                                                       int height =
                                                         java.lang.Integer.
                                                         parseInt(
                                                           args[1]);
                                                       ent.runtime.ENT_Util.
                                                         initModeFile(
                                                           );
                                                       int PANDA_RUNS =
                                                         java.lang.Integer.
                                                         parseInt(
                                                           java.lang.System.
                                                             getenv(
                                                               "PANDA_RUNS"));
                                                       video.Main maindyn =
                                                         new video.Main(
                                                         width,
                                                         height);
                                                       video.Main main =
                                                         maindyn;
                                                       java.lang.System.
                                                         err.
                                                         format(
                                                           "Starting warmup\n");
                                                       main.
                                                         execute(
                                                           30000);
                                                       java.lang.System.
                                                         out.
                                                         format(
                                                           "Done with warmup\n");
                                                       for (int k =
                                                              0;
                                                            k <
                                                              PANDA_RUNS;
                                                            k++) {
                                                           try {
                                                               java.lang.Thread.
                                                                 sleep(
                                                                   5000);
                                                           }
                                                           catch (java.lang.Exception e) {
                                                               java.lang.System.
                                                                 err.
                                                                 println(
                                                                   e);
                                                           }
                                                           video.Main maindyn2 =
                                                             new video.Main(
                                                             width,
                                                             height);
                                                           video.Main main2 =
                                                             maindyn2;
                                                           java.lang.System.
                                                             err.
                                                             format(
                                                               "Starting main %d\n",
                                                               k);
                                                           main2.
                                                             execute(
                                                               60000);
                                                           java.lang.System.
                                                             err.
                                                             format(
                                                               "Finished main %d\n",
                                                               k);
                                                       }
                                                       ent.runtime.ENT_Util.
                                                         closeModeFile(
                                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457107854000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2dgfOMIbAAA=");
    public Main() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        video.Main ENT_ld =
          new video.Main(
          );
        ENT_ld.
          width =
          this.
            width;
        ENT_ld.
          height =
          this.
            height;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457107854000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1L1/nx79nFHdEe/UHOUylzMOzfne089956vX3fFMeq585Yx31/7h+K2WSy+t" +
       "HLmLkpJ/7f6uvPLy7iRz8aW5k3VteietTO+s68wPP7KT2M7FXo1s0DsP7ZhS" +
       "uDeSGtfDu7u7j1zYmNTikh3cL8Z+elOQ/8yLiWQ/4p3WJVM5dFLw23a0j39z" +
       "mroXkG46KFZjumVKSRzajK2vNKjW7v7dozRIXY7Sd68pTRc75B0upyKHVf+P" +
       "Txj706T5Qy9zSkjoWrNxAvjnovX/Z06A+ULSfAxYU+Izk+dfPzCpj/8IJpXG" +
       "onsuVZ6/emnKczwPSDsEy16tY1JyrpiqTNqvi3u6tN99P9CkBy68dkcKeP3+" +
       "NcjafafHRQDam6vu+uWyYOtznA3c+i0B3IsLh0Av/AhR4C9PjAJfO2Hs60nz" +
       "ZS9zZrMtyfvPHEjuL17WYSeQfrJzyR2EWy+5pre+WiY889TZM7c8xf712sNs" +
       "rn9dTWTOyL6uHz7zO/R82nYkWU0pvnp9Arjep28AFU5ja/LyTfsy51LrE8ho" +
       "61ACt6diKX83vhh/+1MO3y9JvG56W3GToPnr+4oXhU8+1ek9+nz5o+v7LYLO" +
       "x3GC5QxwkOurNvtJ3t0viG2D63TrgR9c/6mr79skpNevCT7Qj0O03XX5yyQN" +
       "w/bS6x/x793yO6/7zae+mR6T/S/xIw7uRioAAA==");
}
