package edu.umd.cs.findbugs.cloud.username;
public class PromptForNameLookup implements edu.umd.cs.findbugs.cloud.username.NameLookup {
    edu.umd.cs.findbugs.BugCollection bugCollection;
    java.lang.String username;
    public boolean init() { java.util.prefs.Preferences prefs = java.util.prefs.Preferences.
                              userNodeForPackage(
                                edu.umd.cs.findbugs.cloud.username.PromptForNameLookup.class);
                            java.lang.String findbugsUser = prefs.
                              get(
                                USER_NAME,
                                null);
                            findbugsUser = bugCollection.getProject(
                                                           ).getGuiCallback(
                                                               ).
                                             showQuestionDialog(
                                               "Name/handle/email for recording your reviews?\n" +
                                               ("(sorry, no authentication or confidentiality currently provi" +
                                                "ded)"),
                                               "Name for recording your reviews",
                                               findbugsUser ==
                                                 null
                                                 ? ""
                                                 : findbugsUser);
                            if (findbugsUser !=
                                  null) {
                                prefs.
                                  put(
                                    USER_NAME,
                                    findbugsUser);
                                username =
                                  findbugsUser;
                                return true;
                            }
                            return false;
    }
    @java.lang.Override
    public java.lang.String getUsername() {
        return username;
    }
    @java.lang.Override
    public boolean signIn(edu.umd.cs.findbugs.cloud.CloudPlugin plugin,
                          edu.umd.cs.findbugs.BugCollection bugCollection) {
        this.
          bugCollection =
          bugCollection;
        return true;
    }
    public PromptForNameLookup() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "n+c8WxkbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f3DvZ5/47ee/mR+8/y+c2CmGMiUAAA==");
}
