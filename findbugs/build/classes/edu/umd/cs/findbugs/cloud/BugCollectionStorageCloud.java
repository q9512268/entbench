package edu.umd.cs.findbugs.cloud;
public class BugCollectionStorageCloud extends edu.umd.cs.findbugs.cloud.AbstractCloud {
    public BugCollectionStorageCloud(edu.umd.cs.findbugs.cloud.CloudPlugin plugin,
                                     edu.umd.cs.findbugs.BugCollection bc,
                                     java.util.Properties properties) {
        super(
          plugin,
          bc,
          properties);
        setSigninState(
          edu.umd.cs.findbugs.cloud.Cloud.SigninState.
            NO_SIGNIN_REQUIRED);
    }
    @java.lang.Override
    public boolean initialize() { try { return super.initialize();
                                  }
                                  catch (java.io.IOException e) {
                                      throw new java.lang.IllegalStateException(
                                        e);
                                  } }
    @java.lang.Override
    public void waitUntilIssueDataDownloaded() {  }
    @java.lang.Override
    public void initiateCommunication() {  }
    @java.lang.Override
    public boolean waitUntilNewIssuesUploaded(long timeout, java.util.concurrent.TimeUnit unit)
          throws java.lang.InterruptedException { return true;
    }
    @java.lang.Override
    public boolean waitUntilIssueDataDownloaded(long timeout,
                                                java.util.concurrent.TimeUnit unit)
          throws java.lang.InterruptedException {
        return true;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.cloud.Cloud.Mode getMode() {
        return edu.umd.cs.findbugs.cloud.Cloud.Mode.
                 COMMUNAL;
    }
    @java.lang.Override
    public java.lang.String getUser() { return null;
    }
    @java.lang.SuppressWarnings({ "deprecation" }) 
    @java.lang.Override
    public edu.umd.cs.findbugs.cloud.Cloud.UserDesignation getUserDesignation(edu.umd.cs.findbugs.BugInstance b) {
        edu.umd.cs.findbugs.BugDesignation bd =
          b.
          getUserDesignation(
            );
        if (bd ==
              null) {
            return edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                     UNCLASSIFIED;
        }
        return edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
          valueOf(
            bd.
              getDesignationKey(
                ));
    }
    @java.lang.SuppressWarnings({ "deprecation" }) 
    @java.lang.Override
    public java.lang.String getUserEvaluation(edu.umd.cs.findbugs.BugInstance b) {
        edu.umd.cs.findbugs.BugDesignation bd =
          b.
          getUserDesignation(
            );
        if (bd ==
              null) {
            return "";
        }
        return bd.
          getAnnotationText(
            );
    }
    @java.lang.SuppressWarnings({ "deprecation" }) 
    @java.lang.Override
    public long getUserTimestamp(edu.umd.cs.findbugs.BugInstance b) {
        edu.umd.cs.findbugs.BugDesignation bd =
          b.
          getUserDesignation(
            );
        if (bd ==
              null) {
            return java.lang.Long.
                     MAX_VALUE;
        }
        return bd.
          getTimestamp(
            );
    }
    @java.lang.Override
    public void setMode(edu.umd.cs.findbugs.cloud.Cloud.Mode m) {
        
    }
    @java.lang.Override
    public void bugsPopulated() { assert true;
    }
    @java.lang.Override
    public void setSaveSignInInformation(boolean save) {
        
    }
    @java.lang.Override
    public boolean isSavingSignInInformationEnabled() {
        return false;
    }
    @java.lang.Override
    public void signIn() {  }
    @java.lang.Override
    public void signOut() {  }
    @java.lang.Override
    public boolean availableForInitialization() {
        return true;
    }
    @java.lang.Override
    public void storeUserAnnotation(edu.umd.cs.findbugs.BugInstance bugInstance) {
        
    }
    @java.lang.Override
    public void bugFiled(edu.umd.cs.findbugs.BugInstance b,
                         java.lang.Object bugLink) {
        throw new java.lang.UnsupportedOperationException(
          );
    }
    @java.lang.Override
    @java.lang.SuppressWarnings({ "deprecation" }) 
    public edu.umd.cs.findbugs.BugDesignation getPrimaryDesignation(edu.umd.cs.findbugs.BugInstance b) {
        return b.
          getUserDesignation(
            );
    }
    @java.lang.Override
    protected java.lang.Iterable<edu.umd.cs.findbugs.BugDesignation> getLatestDesignationFromEachUser(edu.umd.cs.findbugs.BugInstance bd) {
        edu.umd.cs.findbugs.BugDesignation designation =
          getPrimaryDesignation(
            bd);
        if (designation ==
              null) {
            return java.util.Collections.
              emptySet(
                );
        }
        return java.util.Collections.
          singleton(
            designation);
    }
    @java.lang.Override
    public java.util.Collection<java.lang.String> getProjects(java.lang.String className) {
        return java.util.Collections.
          emptyList(
            );
    }
    @java.lang.Override
    public boolean isInCloud(edu.umd.cs.findbugs.BugInstance b) {
        return true;
    }
    @java.lang.Override
    public boolean isOnlineCloud() { return false;
    }
    @java.lang.Override
    public void waitUntilNewIssuesUploaded() {
        
    }
    @java.lang.Override
    public void addDateSeen(edu.umd.cs.findbugs.BugInstance b,
                            long when) { if (when >
                                               0) {
                                             b.
                                               getXmlProps(
                                                 ).
                                               setFirstSeen(
                                                 new java.util.Date(
                                                   when));
                                         }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "txLSMzbDz1QCvTBiEeBcFVG3CbMNjDQqVr+GHyGVA2/jDIWTGyA9b/P7fCXA" +
       "CyMWAVBXRF03Zp3TXmdyQ8j45hlC8hpIL9jMv1AJJMOIRQTmmE1x3AYiMN2J" +
       "2XbYGqRsdhuECYOUBk434p+5BCBCvLYk9Gsw/KJgccknqeIzSvmpqabaRVO7" +
       "XucX64ufOjakSe1oXlU9npLXa6qByHBU4ZJoEG/8+dYR3wPTCL2ZwUg1/4s8" +
       "xIdFh9vBpSnTgcHo9qO3tcRInduakbjsq4YRZtvVjFRB7q0cgyKoxMdxw9lr" +
       "Lw+/RtIFLrUpyYwjWIiV7n38NsmCQrj4/F283ywFnfq+vPiWOCOfmtq+49D7" +
       "135dfDMFu/LBg0gFfOHZ4vMtTrSqJPrwUnNo1dy87sO5p+esdWLCFjFhd/ks" +
       "dfUYQ/OYgYrSFvigyOoofld07rHNz716tOanEM7sITEQxrw9pZdBCkYeosc9" +
       "6dLb4I7j27nurw7csGH0P37Ov14hIjZZFt4+Iw9/+Y3U6f2/v5F/uloNcqKF" +
       "YVKnWNsOaDupPGH6rpaXDyUafaEEI6tLL8xPGzo0pkm9WyIkERlNYAe3xBYd" +
       "5nyNjRQQfVDLTLrPMGwPLf6ywZd0rrx/hep7iD/i053/D8Ocn4BUQAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "EcxJ3XYZQa6u8bSFT9DMt6HhGqSJQyTm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "e+pr+YcF/j8ncDx5V00AAA==");
}
