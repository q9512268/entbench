package edu.umd.cs.findbugs.gui2;
public class OSXAdapter extends com.apple.eawt.ApplicationAdapter {
    private static edu.umd.cs.findbugs.gui2.OSXAdapter theAdapter = new edu.umd.cs.findbugs.gui2.OSXAdapter(
      );
    private static final com.apple.eawt.Application theApplication =
      new com.apple.eawt.Application(
      );
    private static edu.umd.cs.findbugs.gui2.MainFrame mainApp;
    private OSXAdapter() { super(); }
    @java.lang.Override
    public void handleAbout(com.apple.eawt.ApplicationEvent ae) {
        if (mainApp !=
              null) {
            ae.
              setHandled(
                true);
            javax.swing.SwingUtilities.
              invokeLater(
                new java.lang.Runnable(
                  ) {
                    @java.lang.Override
                    public void run() {
                        mainApp.
                          about(
                            );
                    }
                });
        }
        else {
            throw new java.lang.IllegalStateException(
              "handleAbout: " +
              "MyApp instance detached from listener");
        }
    }
    @java.lang.Override
    public void handlePreferences(com.apple.eawt.ApplicationEvent ae) {
        if (mainApp !=
              null) {
            mainApp.
              preferences(
                );
            ae.
              setHandled(
                true);
        }
        else {
            throw new java.lang.IllegalStateException(
              "handlePreferences: MyApp instance " +
              "detached from listener");
        }
    }
    @java.lang.Override
    public void handleQuit(com.apple.eawt.ApplicationEvent ae) { if (mainApp !=
                                                                       null) {
                                                                     ae.
                                                                       setHandled(
                                                                         false);
                                                                     mainApp.
                                                                       callOnClose(
                                                                         );
                                                                 }
                                                                 else {
                                                                     throw new java.lang.IllegalStateException(
                                                                       "handleQuit: MyApp instance detached " +
                                                                       "from listener");
                                                                 }
    }
    public static void registerMacOSXApplication(edu.umd.cs.findbugs.gui2.MainFrame inApp) {
        if (mainApp !=
              null) {
            throw new java.lang.IllegalStateException(
              "application already set");
        }
        mainApp =
          inApp;
        theApplication.
          addApplicationListener(
            theAdapter);
        theApplication.
          addPreferencesMenuItem(
            );
    }
    public static void enablePrefs(boolean enabled) {
        theApplication.
          setEnabledPreferencesMenu(
            enabled);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AfehJy1rHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A56bJ65283JAuQKVL99bVnm2TG8WyXeUfXJUvH5nBPqmnEqe+PDfgt8V8Pz/" +
       "4ikYFhn7MffR3snA/8zZyO+D8QjEPe1k2Ckj2D6MFSlSJO/dM27c0Wa++0yj" +
       "txW5OnjedaLRu+6gEXV7je4pNSqSXgQANV3JLjHDI+jhQkjft03lYElvARNH" +
       "MJc5lkC+dqxJaXR8juSSGvTfX42yY94JnhdO1HjhDmrwd+uYUo1T8a85wIKB" +
       "cKdyP3fHOQAHCPvBifmck3/2uvKXTWVXQFi/DzluHleL7/fdAWhgNX4sA6hK" +
       "KYuEOxX1rZat3Dy1lDlYkgAsb1p281T0G2XMKVzkeD+PvyQo/vcWFMSUhw/M" +
       "WA8sCX7iv370Sz/5/FeB49PQfUnhlMDfz7U4jItV0o9++mPveNMrX/uJciwD" +
       "Axn/gvy/3ltw1e9iVx+4VdUnC1V5Lw4UjZXCiCtHH00ttb1rvBsHpgNG6eRk" +
       "CQC//OhXNz/357+0n95fDm6XiLUPv/Ljf3v8kVeOzi2qnr9lXXO+zn5hVQr9" +
       "5hOEA+jZu7VS1uj/t8+8/Jv/+uUP7aV69OISgQAr4F/6D//vS8cf/9rv3WaO" +
       "eq/t/QM6Nrr+EFkPqc7pj62JutgRsukyQfWwYiWJOYA3LdxmyJgKjUEcUq2Z" +
       "ldQ5Q1NRmsr44RoT0QidRrHqSCtMtuXc6QnzDuMw/mzayscMmTqLtU1lczOz" +
       "6KnP23af9Se+RZmrqRBLbNbvTfmNMJstWA1ruGpFNcY0tRS3wOmay2a7EqDL" +
       "JoxqWLtB5j61re46rMN5lk7Bo5wwxztD81cyvYmq9FDZJdVMWjSZiqWrfi7q" +
       "5GI171Rm2bq/bW8SQWSrO6EBqtObZLuT3G044/JVaiuKZKRC5lh9IpYqXurw" +
       "A1mf2uqGX4htJKLXxkzedgmLFaf5pNpYuWOhgeOmSKZD2tswvNRX0xgfDgbm" +
       "dIhWRnwOSxMVjQYbnLUCZ76rrnN5qqhebcTsCA+l6RjmBvGUX87HiN9dDKc1" +
       "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");
}
