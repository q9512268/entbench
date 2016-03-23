package camera;
public class Main implements ent.runtime.ENT_Attributable {
    int width = 0;
    int height = 0;
    public Main(int width, int height) { super();
                                         this.width = width;
                                         this.height = height; }
    public int ENT_attribute() { if (ent.runtime.ENT_Util.Battery.percentRemaining(
                                                                    ) >=
                                       0.75) { return camera.EntMode.
                                                        HIGH_MODE;
                                 }
                                 else
                                     if (ent.runtime.ENT_Util.
                                           Battery.
                                           percentRemaining(
                                             ) >=
                                           0.5) {
                                         return camera.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return camera.EntMode.
                                                  LOW_MODE;
                                     } }
    int picLapse = 1000;
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
                                             camera.RaspiStill d =
                                               new camera.RaspiStill(
                                               width,
                                               height);
                                             camera.RaspiStill c;
                                             try { c = d; }
                                             catch (java.lang.Exception e) {
                                                 c =
                                                   d;
                                                 if (recover) {
                                                     picLapse =
                                                       1500;
                                                 }
                                             }
                                             c.TakePictures(this.
                                                              picLapse,
                                                            timeout);
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             exit(
                                               e.
                                                 hashCode(
                                                   ));
                                       } }
    public static void main(java.lang.String[] args) { if (args.length <
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
                                                       camera.Main maindyn =
                                                         new camera.Main(
                                                         width,
                                                         height);
                                                       camera.Main main =
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
                                                           camera.Main maindyn2 =
                                                             new camera.Main(
                                                             width,
                                                             height);
                                                           camera.Main main2 =
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
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457163884000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public Main() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        camera.Main ENT_ld =
          new camera.Main(
          );
        ENT_ld.
          width =
          this.
            width;
        ENT_ld.
          height =
          this.
            height;
        ENT_ld.
          picLapse =
          this.
            picLapse;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457163884000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "26Ojn7mEy5/Nip+KCvdoqaYA/i5M+yWuoZ7w/B++C55zsKfAUzniufIqeN4/" +
       "MbOXMQ4s0Ntf2gLlh5XbY8Pnf+bJr/7g80/+VX5sdc0IR1LQCPQLbpec6vOt" +
       "F772jd9/4NHP5Wfid8vSNl193/lrOXfeujlzmSYn//7jWXndxRalcPuVWZRt" +
       "GvsgT2IfbFPS733mINOd21yDJcSDdx842uqoJVeu9x4eHj5za6dS/h0zeJy3" +
       "/aVd9v5LL7ckx07vqqU5+qlTjl/00mP8u5PgI5/02pO8dstyHS1zRbu27XUM" +
       "wz08vjyV+6mLKP3hLaX5YKesw0Uiclr0v3xJ21ey4jejwhUlo2vLxiXgX023" +
       "/1+8BOZ3s+ILQJsyq5m9f/ZEpX7+u1Cp3B09cYfw7O2/MuE5HwrkFYrrrbdu" +
       "KTsTzUUmr7fUI1k6rn4KSNLTt955oCWS9dQWZGu+86MuAB0tjHD7cSHY9gxq" +
       "B7f9uhBwdzq0A919Z8BHXuQU+K3vwmX88aUu488vafuLrPjDqHBtN4fZ90dP" +
       "lvmPXtWpLhCVbJqzyxZvuuNS4vYinfK5569fe+Pzwz/emqPdZbd7u4Vr89iy" +
       "Th9unnq/6gXa3Mgpvnd71Lmdp78Byrv1xNnX33oXHHhtz1rTvVMR35FA5gw+" +
       "/HIMHnc5fZMms9H55cxdRBdvr2feVj7/PMN94Nu1n97e5FEsabPJsFwD5nR7" +
       "qeg4Knz8JbHtcF2lnv7Og1+49+27CPbBLcEnAnKKtrddfG2GsL0ov+iy+cU3" +
       "/ud3/cfn/zI/f/t/BnrwIjUrAAA=");
}
