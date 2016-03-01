package edu.umd.cs.findbugs.cloud;
public abstract class AbstractCloud implements edu.umd.cs.findbugs.cloud.Cloud {
    public static long MIN_TIMESTAMP = new java.util.Date(96, 0, 23).getTime(
                                                                       );
    protected static final boolean THROW_EXCEPTION_IF_CANT_CONNECT = false;
    private static final edu.umd.cs.findbugs.cloud.Cloud.Mode DEFAULT_VOTING_MODE =
      edu.umd.cs.findbugs.cloud.Cloud.Mode.
        COMMUNAL;
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.
      getLogger(
        edu.umd.cs.findbugs.cloud.AbstractCloud.class.
          getName(
            ));
    private static final java.lang.String LEADERBOARD_BLACKLIST =
      edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "findbugs.leaderboard.blacklist");
    private static final java.util.regex.Pattern LEADERBOARD_BLACKLIST_PATTERN;
    static { java.util.regex.Pattern p = null;
             if (LEADERBOARD_BLACKLIST != null) { try { p =
                                                          java.util.regex.Pattern.
                                                            compile(
                                                              LEADERBOARD_BLACKLIST.
                                                                replace(
                                                                  ',',
                                                                  '|'));
                                                  }
                                                  catch (java.lang.Exception e) {
                                                      LOGGER.
                                                        log(
                                                          java.util.logging.Level.
                                                            WARNING,
                                                          "Could not load leaderboard blacklist pattern",
                                                          e);
                                                  }
             }
             LEADERBOARD_BLACKLIST_PATTERN =
               p; }
    protected final edu.umd.cs.findbugs.cloud.CloudPlugin
      plugin;
    protected final edu.umd.cs.findbugs.BugCollection
      bugCollection;
    protected final edu.umd.cs.findbugs.PropertyBundle
      properties;
    @javax.annotation.CheckForNull
    private java.util.regex.Pattern sourceFileLinkPattern;
    private java.lang.String sourceFileLinkFormat;
    private java.lang.String sourceFileLinkFormatWithLine;
    private java.lang.String sourceFileLinkToolTip;
    private final java.util.concurrent.CopyOnWriteArraySet<edu.umd.cs.findbugs.cloud.Cloud.CloudListener>
      listeners =
      new java.util.concurrent.CopyOnWriteArraySet<edu.umd.cs.findbugs.cloud.Cloud.CloudListener>(
      );
    private final java.util.concurrent.CopyOnWriteArraySet<edu.umd.cs.findbugs.cloud.Cloud.CloudStatusListener>
      statusListeners =
      new java.util.concurrent.CopyOnWriteArraySet<edu.umd.cs.findbugs.cloud.Cloud.CloudStatusListener>(
      );
    private edu.umd.cs.findbugs.cloud.Cloud.Mode
      mode =
      edu.umd.cs.findbugs.cloud.Cloud.Mode.
        COMMUNAL;
    private java.lang.String statusMsg;
    private edu.umd.cs.findbugs.cloud.Cloud.SigninState
      signinState =
      edu.umd.cs.findbugs.cloud.Cloud.SigninState.
        UNAUTHENTICATED;
    private boolean issueDataDownloaded =
      false;
    protected AbstractCloud(edu.umd.cs.findbugs.cloud.CloudPlugin plugin,
                            edu.umd.cs.findbugs.BugCollection bugs,
                            java.util.Properties properties) {
        super(
          );
        this.
          plugin =
          plugin;
        this.
          bugCollection =
          bugs;
        this.
          properties =
          plugin.
            getProperties(
              ).
            copy(
              );
        if (!properties.
              isEmpty(
                )) {
            this.
              properties.
              loadProperties(
                properties);
        }
    }
    boolean abstractCloudInitialized = false;
    @java.lang.Override
    public boolean isInitialized() { return abstractCloudInitialized;
    }
    @java.lang.Override
    @javax.annotation.OverridingMethodsMustInvokeSuper
    public boolean initialize() throws java.io.IOException {
        abstractCloudInitialized =
          true;
        java.lang.String modeString =
          getCloudProperty(
            "votingmode");
        edu.umd.cs.findbugs.cloud.Cloud.Mode newMode =
          DEFAULT_VOTING_MODE;
        if (modeString !=
              null) {
            try {
                newMode =
                  edu.umd.cs.findbugs.cloud.Cloud.Mode.
                    valueOf(
                      modeString.
                        toUpperCase(
                          ));
            }
            catch (java.lang.IllegalArgumentException e) {
                LOGGER.
                  log(
                    java.util.logging.Level.
                      WARNING,
                    "No such voting mode " +
                    modeString,
                    e);
            }
        }
        setMode(
          newMode);
        java.lang.String sp =
          properties.
          getProperty(
            "findbugs.sourcelink.pattern");
        java.lang.String sf =
          properties.
          getProperty(
            "findbugs.sourcelink.format");
        java.lang.String sfwl =
          properties.
          getProperty(
            "findbugs.sourcelink.formatWithLine");
        java.lang.String stt =
          properties.
          getProperty(
            "findbugs.sourcelink.tooltip");
        if (sp !=
              null &&
              sf !=
              null) {
            try {
                this.
                  sourceFileLinkPattern =
                  java.util.regex.Pattern.
                    compile(
                      sp);
                this.
                  sourceFileLinkFormat =
                  sf;
                this.
                  sourceFileLinkToolTip =
                  stt;
                this.
                  sourceFileLinkFormatWithLine =
                  sfwl;
            }
            catch (java.lang.RuntimeException e) {
                LOGGER.
                  log(
                    java.util.logging.Level.
                      WARNING,
                    "Could not compile pattern " +
                    sp,
                    e);
                if (THROW_EXCEPTION_IF_CANT_CONNECT) {
                    throw e;
                }
            }
        }
        return true;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.cloud.Cloud.Mode getMode() {
        return mode;
    }
    @java.lang.Override
    public void setMode(edu.umd.cs.findbugs.cloud.Cloud.Mode mode) {
        this.
          mode =
          mode;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.cloud.CloudPlugin getPlugin() {
        return plugin;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.BugCollection getBugCollection() {
        return bugCollection;
    }
    @java.lang.Override
    public boolean supportsBugLinks() { return false;
    }
    @java.lang.Override
    public void setBugLinkOnCloudAndStoreIssueDetails(edu.umd.cs.findbugs.BugInstance b,
                                                      java.lang.String viewUrl,
                                                      java.lang.String linkType)
          throws java.io.IOException,
        edu.umd.cs.findbugs.cloud.SignInCancelledException {
        throw new java.lang.UnsupportedOperationException(
          );
    }
    @java.lang.Override
    public void updateBugStatusCache(edu.umd.cs.findbugs.BugInstance b,
                                     java.lang.String status) {
        throw new java.lang.UnsupportedOperationException(
          );
    }
    @java.lang.Override
    public boolean supportsClaims() { return false;
    }
    @java.lang.Override
    public boolean supportsCloudReports() {
        return true;
    }
    @java.lang.Override
    public java.lang.String claimedBy(edu.umd.cs.findbugs.BugInstance b) {
        throw new java.lang.UnsupportedOperationException(
          );
    }
    @java.lang.Override
    public boolean claim(edu.umd.cs.findbugs.BugInstance b) {
        throw new java.lang.UnsupportedOperationException(
          );
    }
    @java.lang.Override
    public java.net.URL getBugLink(edu.umd.cs.findbugs.BugInstance b) {
        throw new java.lang.UnsupportedOperationException(
          );
    }
    @java.lang.Override
    public java.lang.String getBugLinkType(edu.umd.cs.findbugs.BugInstance instance) {
        return null;
    }
    @java.lang.Override
    public java.net.URL fileBug(edu.umd.cs.findbugs.BugInstance bug) {
        throw new java.lang.UnsupportedOperationException(
          );
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.cloud.Cloud.BugFilingStatus getBugLinkStatus(edu.umd.cs.findbugs.BugInstance b) {
        throw new java.lang.UnsupportedOperationException(
          );
    }
    public boolean canSeeCommentsByOthers(edu.umd.cs.findbugs.BugInstance bug) {
        switch (getMode(
                  )) {
            case SECRET:
                return false;
            case COMMUNAL:
                return true;
            case VOTING:
                return hasVoted(
                         bug);
        }
        throw new java.lang.IllegalStateException(
          );
    }
    public boolean hasVoted(edu.umd.cs.findbugs.BugInstance bug) {
        for (edu.umd.cs.findbugs.BugDesignation bd
              :
              getLatestDesignationFromEachUser(
                bug)) {
            if (getUser(
                  ).
                  equals(
                    bd.
                      getUser(
                        ))) {
                return true;
            }
        }
        return false;
    }
    public java.lang.String notInCloudMsg(edu.umd.cs.findbugs.BugInstance b) {
        if (!(!isOnlineCloud(
                 ))) {
            return "off line cloud";
        }
        if (getSigninState(
              ).
              canDownload(
                )) {
            return "disconnected from cloud";
        }
        if (!issueDataDownloaded) {
            return "Waiting for issue data...";
        }
        return "Issue not recorded in cloud";
    }
    @java.lang.Override
    public java.lang.String getCloudReport(edu.umd.cs.findbugs.BugInstance b) {
        return getSelectiveCloudReport(
                 b,
                 java.util.Collections.
                   <java.lang.String>
                 emptySet(
                   ));
    }
    @java.lang.Override
    public java.lang.String getCloudReportWithoutMe(edu.umd.cs.findbugs.BugInstance b) {
        java.lang.String user =
          getUser(
            );
        java.util.Set<java.lang.String> usersToExclude =
          user ==
          null
          ? java.util.Collections.
          <java.lang.String>
        emptySet(
          )
          : java.util.Collections.
          singleton(
            user);
        return getSelectiveCloudReport(
                 b,
                 usersToExclude);
    }
    @java.lang.Override
    public void bugsPopulated() { issueDataDownloaded =
                                    false;
    }
    private java.lang.String getSelectiveCloudReport(edu.umd.cs.findbugs.BugInstance b,
                                                     java.util.Set<java.lang.String> usersToExclude) {
        if (!isInCloud(
               b)) {
            return notInCloudMsg(
                     b);
        }
        initiateCommunication(
          );
        java.text.SimpleDateFormat format =
          new java.text.SimpleDateFormat(
          "MM/dd, yyyy",
          java.util.Locale.
            ENGLISH);
        java.lang.StringBuilder builder =
          new java.lang.StringBuilder(
          );
        long firstSeen =
          getFirstSeen(
            b);
        builder.
          append(
            java.lang.String.
              format(
                "First seen %s%n",
                format.
                  format(
                    new java.util.Date(
                      firstSeen))));
        builder.
          append(
            "\n");
        edu.umd.cs.findbugs.I18N i18n =
          edu.umd.cs.findbugs.I18N.
          instance(
            );
        boolean canSeeCommentsByOthers =
          canSeeCommentsByOthers(
            b);
        if (canSeeCommentsByOthers &&
              supportsBugLinks(
                )) {
            edu.umd.cs.findbugs.cloud.Cloud.BugFilingStatus bugLinkStatus =
              getBugLinkStatus(
                b);
            if (bugLinkStatus !=
                  null &&
                  bugLinkStatus.
                  bugIsFiled(
                    )) {
                builder.
                  append(
                    "\nBug status is ").
                  append(
                    getBugStatus(
                      b));
                if (getBugIsUnassigned(
                      b)) {
                    builder.
                      append(
                        "\nBug is unassigned");
                }
                builder.
                  append(
                    "\n\n");
            }
        }
        java.lang.String me =
          getUser(
            );
        for (edu.umd.cs.findbugs.BugDesignation d
              :
              getLatestDesignationFromEachUser(
                b)) {
            if (!usersToExclude.
                  contains(
                    d.
                      getUser(
                        )) &&
                  (me !=
                     null &&
                     me.
                     equals(
                       d.
                         getUser(
                           )) ||
                     canSeeCommentsByOthers)) {
                builder.
                  append(
                    java.lang.String.
                      format(
                        "%s@ %s: %s%n",
                        d.
                          getUser(
                            ) ==
                          null
                          ? ""
                          : d.
                          getUser(
                            ) +
                        " ",
                        format.
                          format(
                            new java.util.Date(
                              d.
                                getTimestamp(
                                  ))),
                        i18n.
                          getUserDesignation(
                            d.
                              getDesignationKey(
                                ))));
                java.lang.String annotationText =
                  d.
                  getAnnotationText(
                    );
                if (annotationText !=
                      null &&
                      annotationText.
                      length(
                        ) >
                      0) {
                    builder.
                      append(
                        annotationText);
                    builder.
                      append(
                        "\n\n");
                }
            }
        }
        return builder.
          toString(
            );
    }
    protected boolean issueDataHasBeenDownloaded() {
        return false;
    }
    @java.lang.Override
    public java.lang.String getBugStatus(edu.umd.cs.findbugs.BugInstance b) {
        return null;
    }
    protected abstract java.lang.Iterable<edu.umd.cs.findbugs.BugDesignation> getLatestDesignationFromEachUser(edu.umd.cs.findbugs.BugInstance bd);
    @java.lang.Override
    public java.util.Date getUserDate(edu.umd.cs.findbugs.BugInstance b) {
        return new java.util.Date(
          getUserTimestamp(
            b));
    }
    @java.lang.Override
    public void addListener(edu.umd.cs.findbugs.cloud.Cloud.CloudListener listener) {
        if (listener ==
              null) {
            throw new java.lang.NullPointerException(
              );
        }
        if (!listeners.
              contains(
                listener)) {
            listeners.
              add(
                listener);
        }
    }
    @java.lang.Override
    public void removeListener(edu.umd.cs.findbugs.cloud.Cloud.CloudListener listener) {
        listeners.
          remove(
            listener);
    }
    @java.lang.Override
    public void addStatusListener(edu.umd.cs.findbugs.cloud.Cloud.CloudStatusListener listener) {
        if (listener ==
              null) {
            throw new java.lang.NullPointerException(
              );
        }
        if (!statusListeners.
              contains(
                listener)) {
            statusListeners.
              add(
                listener);
        }
    }
    @java.lang.Override
    public void removeStatusListener(edu.umd.cs.findbugs.cloud.Cloud.CloudStatusListener listener) {
        statusListeners.
          remove(
            listener);
    }
    @java.lang.Override
    public java.lang.String getStatusMsg() {
        return statusMsg;
    }
    @java.lang.Override
    public void shutdown() {  }
    @java.lang.Override
    public boolean getIWillFix(edu.umd.cs.findbugs.BugInstance b) {
        return getUserDesignation(
                 b) ==
          edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
            I_WILL_FIX;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.cloud.Cloud.UserDesignation getConsensusDesignation(edu.umd.cs.findbugs.BugInstance b) {
        if (b ==
              null) {
            throw new java.lang.NullPointerException(
              "null bug instance");
        }
        edu.umd.cs.findbugs.util.Multiset<edu.umd.cs.findbugs.cloud.Cloud.UserDesignation> designations =
          new edu.umd.cs.findbugs.util.Multiset<edu.umd.cs.findbugs.cloud.Cloud.UserDesignation>(
          );
        int count =
          0;
        int totalCount =
          0;
        double total =
          0.0;
        int isAProblem =
          0;
        int notAProblem =
          0;
        for (edu.umd.cs.findbugs.BugDesignation designation
              :
              getLatestDesignationFromEachUser(
                b)) {
            edu.umd.cs.findbugs.cloud.Cloud.UserDesignation d =
              edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
              valueOf(
                designation.
                  getDesignationKey(
                    ));
            if (d ==
                  edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                    I_WILL_FIX) {
                d =
                  edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                    MUST_FIX;
            }
            else
                if (d ==
                      edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                        UNCLASSIFIED) {
                    continue;
                }
            switch (d) {
                case I_WILL_FIX:
                case MUST_FIX:
                case SHOULD_FIX:
                    isAProblem++;
                    break;
                case BAD_ANALYSIS:
                case NOT_A_BUG:
                case MOSTLY_HARMLESS:
                case OBSOLETE_CODE:
                    notAProblem++;
                    break;
                default:
                    break;
            }
            designations.
              add(
                d);
            totalCount++;
            if (d.
                  nonVoting(
                    )) {
                continue;
            }
            count++;
            total +=
              d.
                score(
                  );
        }
        if (totalCount ==
              0) {
            return edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                     UNCLASSIFIED;
        }
        edu.umd.cs.findbugs.cloud.Cloud.UserDesignation mostCommonVotingDesignation =
          null;
        edu.umd.cs.findbugs.cloud.Cloud.UserDesignation mostCommonDesignation =
          null;
        for (java.util.Map.Entry<edu.umd.cs.findbugs.cloud.Cloud.UserDesignation,java.lang.Integer> e
              :
              designations.
               entriesInDecreasingFrequency(
                 )) {
            edu.umd.cs.findbugs.cloud.Cloud.UserDesignation d =
              e.
              getKey(
                );
            if (mostCommonVotingDesignation ==
                  null &&
                  !d.
                  nonVoting(
                    )) {
                mostCommonVotingDesignation =
                  d;
                if (e.
                      getValue(
                        ) >
                      count /
                      2) {
                    return d;
                }
            }
            if (mostCommonDesignation ==
                  null &&
                  d !=
                  edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                    UNCLASSIFIED) {
                mostCommonDesignation =
                  d;
                if (e.
                      getValue(
                        ) >
                      count /
                      2) {
                    return d;
                }
            }
        }
        double score =
          total /
          count;
        if (score >=
              edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                SHOULD_FIX.
              score(
                ) ||
              isAProblem >
              notAProblem) {
            return edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                     SHOULD_FIX;
        }
        if (score <=
              edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                NOT_A_BUG.
              score(
                )) {
            return edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                     NOT_A_BUG;
        }
        if (score <=
              edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                MOSTLY_HARMLESS.
              score(
                ) ||
              notAProblem >
              isAProblem) {
            return edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                     MOSTLY_HARMLESS;
        }
        return edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                 NEEDS_STUDY;
    }
    @java.lang.Override
    public boolean overallClassificationIsNotAProblem(edu.umd.cs.findbugs.BugInstance b) {
        edu.umd.cs.findbugs.cloud.Cloud.UserDesignation consensusDesignation =
          getConsensusDesignation(
            b);
        return consensusDesignation.
          notAProblem(
            );
    }
    @java.lang.Override
    public double getClassificationScore(edu.umd.cs.findbugs.BugInstance b) {
        int count =
          0;
        double total =
          0.0;
        for (edu.umd.cs.findbugs.BugDesignation designation
              :
              getLatestDesignationFromEachUser(
                b)) {
            edu.umd.cs.findbugs.cloud.Cloud.UserDesignation d =
              edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
              valueOf(
                designation.
                  getDesignationKey(
                    ));
            if (d.
                  nonVoting(
                    )) {
                continue;
            }
            count++;
            total +=
              d.
                score(
                  );
        }
        return total /
          count;
    }
    @java.lang.Override
    public double getClassificationVariance(edu.umd.cs.findbugs.BugInstance b) {
        int count =
          0;
        double total =
          0.0;
        double totalSquares =
          0.0;
        for (edu.umd.cs.findbugs.BugDesignation designation
              :
              getLatestDesignationFromEachUser(
                b)) {
            edu.umd.cs.findbugs.cloud.Cloud.UserDesignation d =
              edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
              valueOf(
                designation.
                  getDesignationKey(
                    ));
            if (d.
                  nonVoting(
                    )) {
                continue;
            }
            count++;
            total +=
              d.
                score(
                  );
            totalSquares +=
              d.
                score(
                  ) *
                d.
                score(
                  );
        }
        double average =
          total /
          count;
        return totalSquares /
          count -
          average *
          average;
    }
    @java.lang.Override
    public double getPortionObsoleteClassifications(edu.umd.cs.findbugs.BugInstance b) {
        int count =
          0;
        double total =
          0.0;
        for (edu.umd.cs.findbugs.BugDesignation designation
              :
              getLatestDesignationFromEachUser(
                b)) {
            count++;
            edu.umd.cs.findbugs.cloud.Cloud.UserDesignation d =
              edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
              valueOf(
                designation.
                  getDesignationKey(
                    ));
            if (d ==
                  edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                    OBSOLETE_CODE) {
                total++;
            }
        }
        return total /
          count;
    }
    @java.lang.Override
    public int getNumberReviewers(edu.umd.cs.findbugs.BugInstance b) {
        int count =
          0;
        java.lang.Iterable<edu.umd.cs.findbugs.BugDesignation> designations =
          getLatestDesignationFromEachUser(
            b);
        for (edu.umd.cs.findbugs.BugDesignation designation
              :
              designations) {
            count++;
        }
        return count;
    }
    @java.lang.Override
    @java.lang.SuppressWarnings("boxing") 
    public void printCloudSummary(java.io.PrintWriter w,
                                  java.lang.Iterable<edu.umd.cs.findbugs.BugInstance> bugs,
                                  java.lang.String[] packagePrefixes) {
        edu.umd.cs.findbugs.util.Multiset<java.lang.String> evaluations =
          new edu.umd.cs.findbugs.util.Multiset<java.lang.String>(
          );
        edu.umd.cs.findbugs.util.Multiset<java.lang.String> designations =
          new edu.umd.cs.findbugs.util.Multiset<java.lang.String>(
          );
        edu.umd.cs.findbugs.util.Multiset<java.lang.String> bugStatus =
          new edu.umd.cs.findbugs.util.Multiset<java.lang.String>(
          );
        int[] issuesWithThisManyReviews =
          new int[100];
        edu.umd.cs.findbugs.I18N i18n =
          edu.umd.cs.findbugs.I18N.
          instance(
            );
        int packageCount =
          0;
        int classCount =
          0;
        int ncss =
          0;
        edu.umd.cs.findbugs.ProjectStats projectStats =
          bugCollection.
          getProjectStats(
            );
        for (edu.umd.cs.findbugs.PackageStats ps
              :
              projectStats.
               getPackageStats(
                 )) {
            int num =
              ps.
              getNumClasses(
                );
            if (edu.umd.cs.findbugs.util.ClassName.
                  matchedPrefixes(
                    packagePrefixes,
                    ps.
                      getPackageName(
                        )) &&
                  num >
                  0) {
                packageCount++;
                ncss +=
                  ps.
                    size(
                      );
                classCount +=
                  num;
            }
        }
        if (classCount ==
              0) {
            w.
              println(
                "No classes were analyzed");
            return;
        }
        if (packagePrefixes !=
              null &&
              packagePrefixes.
                length >
              0) {
            java.lang.String lst =
              java.util.Arrays.
              asList(
                packagePrefixes).
              toString(
                );
            w.
              println(
                "Code analyzed in " +
                lst.
                  substring(
                    1,
                    lst.
                      length(
                        ) -
                      1));
        }
        else {
            w.
              println(
                "Code analyzed");
        }
        w.
          printf(
            "%,7d packages%n%,7d classes%n",
            packageCount,
            classCount);
        if (ncss >
              0) {
            w.
              printf(
                ("%,7d thousands of lines of non-commenting source statements%" +
                 "n"),
                (ncss +
                   999) /
                  1000);
        }
        w.
          println(
            );
        int count =
          0;
        for (edu.umd.cs.findbugs.BugInstance bd
              :
              bugs) {
            count++;
            java.util.HashSet<java.lang.String> reviewers =
              new java.util.HashSet<java.lang.String>(
              );
            java.lang.String status =
              supportsBugLinks(
                ) &&
              getBugLinkStatus(
                bd).
              bugIsFiled(
                )
              ? getBugStatus(
                  bd)
              : null;
            if (status !=
                  null) {
                bugStatus.
                  add(
                    status);
            }
            for (edu.umd.cs.findbugs.BugDesignation d
                  :
                  getLatestDesignationFromEachUser(
                    bd)) {
                if (reviewers.
                      add(
                        d.
                          getUser(
                            ))) {
                    evaluations.
                      add(
                        d.
                          getUser(
                            ));
                    designations.
                      add(
                        i18n.
                          getUserDesignation(
                            d.
                              getDesignationKey(
                                )));
                }
            }
            int numReviews =
              java.lang.Math.
              min(
                reviewers.
                  size(
                    ),
                issuesWithThisManyReviews.
                  length -
                  1);
            issuesWithThisManyReviews[numReviews]++;
        }
        if (count ==
              getBugCollection(
                ).
              getCollection(
                ).
              size(
                )) {
            w.
              printf(
                "Summary for %d issues%n%n",
                count);
        }
        else {
            w.
              printf(
                "Summary for %d issues that are in the current view%n%n",
                count);
        }
        if (evaluations.
              numKeys(
                ) ==
              0) {
            w.
              println(
                "No reviews found");
        }
        else {
            w.
              println(
                "People who have performed the most reviews");
            printLeaderBoard(
              w,
              evaluations,
              9,
              getUser(
                ),
              true,
              "reviewer");
            w.
              println(
                );
            w.
              println(
                "Distribution of reviews");
            printLeaderBoard(
              w,
              designations,
              100,
              " --- ",
              false,
              "designation");
        }
        if (supportsBugLinks(
              )) {
            if (bugStatus.
                  numKeys(
                    ) ==
                  0) {
                w.
                  println(
                    );
                w.
                  println(
                    "No bugs filed");
            }
            else {
                w.
                  println(
                    );
                w.
                  println(
                    "Distribution of bug status");
                printLeaderBoard(
                  w,
                  bugStatus,
                  100,
                  " --- ",
                  false,
                  "status of filed bug");
            }
        }
        w.
          println(
            );
        w.
          println(
            "Distribution of number of reviews");
        for (int i =
               0;
             i <
               issuesWithThisManyReviews.
                 length;
             i++) {
            if (issuesWithThisManyReviews[i] >
                  0) {
                w.
                  printf(
                    "%4d  with %3d review",
                    issuesWithThisManyReviews[i],
                    i);
                if (i !=
                      1) {
                    w.
                      print(
                        "s");
                }
                w.
                  println(
                    );
            }
        }
    }
    @java.lang.SuppressWarnings("boxing") 
    public static void printLeaderBoard2(java.io.PrintWriter w,
                                         edu.umd.cs.findbugs.util.Multiset<java.lang.String> evaluations,
                                         int maxRows,
                                         java.lang.String alwaysPrint,
                                         java.lang.String format,
                                         java.lang.String title) {
        int row =
          1;
        int position =
          0;
        int previousScore =
          -1;
        boolean foundAlwaysPrint =
          false;
        for (java.util.Map.Entry<java.lang.String,java.lang.Integer> e
              :
              evaluations.
               entriesInDecreasingFrequency(
                 )) {
            int num =
              e.
              getValue(
                );
            if (num !=
                  previousScore) {
                position =
                  row;
                previousScore =
                  num;
            }
            java.lang.String key =
              e.
              getKey(
                );
            if (LEADERBOARD_BLACKLIST_PATTERN !=
                  null &&
                  LEADERBOARD_BLACKLIST_PATTERN.
                  matcher(
                    key).
                  matches(
                    )) {
                continue;
            }
            boolean shouldAlwaysPrint =
              key.
              equals(
                alwaysPrint);
            if (row <=
                  maxRows ||
                  shouldAlwaysPrint) {
                w.
                  printf(
                    format,
                    position,
                    num,
                    key);
            }
            if (shouldAlwaysPrint) {
                foundAlwaysPrint =
                  true;
            }
            row++;
            if (row >=
                  maxRows) {
                if (alwaysPrint ==
                      null) {
                    break;
                }
                if (foundAlwaysPrint) {
                    w.
                      printf(
                        "Total of %d %ss%n",
                        evaluations.
                          numKeys(
                            ),
                        title);
                    break;
                }
            }
        }
    }
    @java.lang.Override
    public boolean supportsCloudSummaries() {
        return true;
    }
    @java.lang.Override
    public boolean canStoreUserAnnotation(edu.umd.cs.findbugs.BugInstance bugInstance) {
        return true;
    }
    @java.lang.Override
    public double getClassificationDisagreement(edu.umd.cs.findbugs.BugInstance b) {
        return 0;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.cloud.Cloud.UserDesignation getUserDesignation(edu.umd.cs.findbugs.BugInstance b) {
        edu.umd.cs.findbugs.BugDesignation bd =
          getPrimaryDesignation(
            b);
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
    @java.lang.Override
    public java.lang.String getUserEvaluation(edu.umd.cs.findbugs.BugInstance b) {
        edu.umd.cs.findbugs.BugDesignation bd =
          getPrimaryDesignation(
            b);
        if (bd ==
              null) {
            return "";
        }
        java.lang.String result =
          bd.
          getAnnotationText(
            );
        if (result ==
              null) {
            return "";
        }
        return result;
    }
    @java.lang.Override
    public long getUserTimestamp(edu.umd.cs.findbugs.BugInstance b) {
        edu.umd.cs.findbugs.BugDesignation bd =
          getPrimaryDesignation(
            b);
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
    public long getFirstSeen(edu.umd.cs.findbugs.BugInstance b) {
        return getLocalFirstSeen(
                 b);
    }
    @java.lang.Override
    public void addDateSeen(edu.umd.cs.findbugs.BugInstance b,
                            long when) { throw new java.lang.UnsupportedOperationException(
                                           );
    }
    protected void updatedStatus() { for (edu.umd.cs.findbugs.cloud.Cloud.CloudListener listener
                                           :
                                           listeners) {
                                         try {
                                             listener.
                                               statusUpdated(
                                                 );
                                         }
                                         catch (java.lang.Exception e) {
                                             LOGGER.
                                               log(
                                                 java.util.logging.Level.
                                                   SEVERE,
                                                 "Error executing callback " +
                                                 listener,
                                                 e);
                                         }
                                     } }
    public void updatedIssue(edu.umd.cs.findbugs.BugInstance bug) {
        for (edu.umd.cs.findbugs.cloud.Cloud.CloudListener listener
              :
              listeners) {
            try {
                listener.
                  issueUpdated(
                    bug);
            }
            catch (java.lang.Exception e) {
                LOGGER.
                  log(
                    java.util.logging.Level.
                      SEVERE,
                    "Error executing callback " +
                    listener,
                    e);
            }
        }
    }
    protected void fireIssueDataDownloadedEvent() {
        issueDataDownloaded =
          true;
        for (edu.umd.cs.findbugs.cloud.Cloud.CloudStatusListener statusListener
              :
              statusListeners) {
            statusListener.
              handleIssueDataDownloadedEvent(
                );
        }
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.cloud.Cloud.SigninState getSigninState() {
        return signinState;
    }
    public void setSigninState(edu.umd.cs.findbugs.cloud.Cloud.SigninState state) {
        edu.umd.cs.findbugs.cloud.Cloud.SigninState oldState =
          this.
            signinState;
        if (oldState ==
              state) {
            return;
        }
        LOGGER.
          log(
            java.util.logging.Level.
              FINER,
            "State " +
            oldState +
            " -> " +
            state,
            new java.lang.Throwable(
              "Change in login state at:"));
        this.
          signinState =
          state;
        for (edu.umd.cs.findbugs.cloud.Cloud.CloudStatusListener statusListener
              :
              statusListeners) {
            statusListener.
              handleStateChange(
                oldState,
                state);
        }
    }
    public edu.umd.cs.findbugs.BugInstance getBugByHash(java.lang.String hash) {
        for (edu.umd.cs.findbugs.BugInstance instance
              :
              bugCollection.
               getCollection(
                 )) {
            if (instance.
                  getInstanceHash(
                    ).
                  equals(
                    hash)) {
                return instance;
            }
        }
        return null;
    }
    protected edu.umd.cs.findbugs.cloud.username.NameLookup getUsernameLookup()
          throws java.io.IOException { edu.umd.cs.findbugs.cloud.username.NameLookup lookup;
                                       try {
                                           lookup =
                                             plugin.
                                               getUsernameClass(
                                                 ).
                                               newInstance(
                                                 );
                                       }
                                       catch (java.lang.Exception e) {
                                           throw new java.lang.RuntimeException(
                                             "Unable to obtain username",
                                             e);
                                       }
                                       if (!lookup.
                                             signIn(
                                               plugin,
                                               bugCollection)) {
                                           throw new java.lang.RuntimeException(
                                             "Unable to obtain username");
                                       }
                                       return lookup;
    }
    public edu.umd.cs.findbugs.cloud.MutableCloudTask createTask(final java.lang.String name) {
        edu.umd.cs.findbugs.cloud.MutableCloudTask task =
          new edu.umd.cs.findbugs.cloud.MutableCloudTask(
          name);
        for (edu.umd.cs.findbugs.cloud.Cloud.CloudListener listener
              :
              listeners) {
            listener.
              taskStarted(
                task);
        }
        task.
          setDefaultListener(
            new edu.umd.cs.findbugs.cloud.Cloud.CloudTaskListener(
              ) {
                @java.lang.Override
                public void taskStatusUpdated(java.lang.String statusLine,
                                              double percentCompleted) {
                    setStatusMsg(
                      name +
                      "... " +
                      statusLine);
                }
                @java.lang.Override
                public void taskFinished() {
                    setStatusMsg(
                      "");
                }
                @java.lang.Override
                public void taskFailed(java.lang.String message) {
                    setStatusMsg(
                      name +
                      "... FAILED - " +
                      message);
                }
            });
        if (task.
              isUsingDefaultListener(
                )) {
            setStatusMsg(
              name);
        }
        return task;
    }
    public void setStatusMsg(java.lang.String newMsg) {
        this.
          statusMsg =
          newMsg;
        updatedStatus(
          );
    }
    private static void printLeaderBoard(java.io.PrintWriter w,
                                         edu.umd.cs.findbugs.util.Multiset<java.lang.String> evaluations,
                                         int maxRows,
                                         java.lang.String alwaysPrint,
                                         boolean listRank,
                                         java.lang.String title) {
        if (listRank) {
            w.
              printf(
                "%3s %4s %s%n",
                "rnk",
                "num",
                title);
        }
        else {
            w.
              printf(
                "%4s %s%n",
                "num",
                title);
        }
        printLeaderBoard2(
          w,
          evaluations,
          maxRows,
          alwaysPrint,
          listRank
            ? "%3d %4d %s%n"
            : "%2$4d %3$s%n",
          title);
    }
    protected java.lang.String getCloudProperty(java.lang.String propertyName) {
        return properties.
          getProperty(
            "findbugs.cloud." +
            propertyName);
    }
    @java.lang.Override
    public boolean supportsSourceLinks() {
        return sourceFileLinkPattern !=
          null;
    }
    @java.lang.Override
    @java.lang.SuppressWarnings("boxing") 
    @javax.annotation.CheckForNull
    public java.net.URL getSourceLink(edu.umd.cs.findbugs.BugInstance b) {
        if (sourceFileLinkPattern ==
              null) {
            return null;
        }
        edu.umd.cs.findbugs.SourceLineAnnotation src =
          b.
          getPrimarySourceLineAnnotation(
            );
        java.lang.String fileName =
          src.
          getSourcePath(
            );
        int startLine =
          src.
          getStartLine(
            );
        int endLine =
          src.
          getEndLine(
            );
        java.util.regex.Matcher m =
          sourceFileLinkPattern.
          matcher(
            fileName);
        boolean isMatch =
          m.
          matches(
            );
        if (isMatch) {
            try {
                java.net.URL link;
                if (startLine >
                      0) {
                    link =
                      new java.net.URL(
                        java.lang.String.
                          format(
                            sourceFileLinkFormatWithLine,
                            m.
                              group(
                                1),
                            startLine,
                            startLine -
                              10,
                            endLine));
                }
                else {
                    link =
                      new java.net.URL(
                        java.lang.String.
                          format(
                            sourceFileLinkFormat,
                            m.
                              group(
                                1)));
                }
                return link;
            }
            catch (java.lang.Exception e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Error generating source link for " +
                    src,
                    e);
            }
        }
        return null;
    }
    @java.lang.Override
    public java.lang.String getSourceLinkToolTip(edu.umd.cs.findbugs.BugInstance b) {
        return sourceFileLinkToolTip;
    }
    @java.lang.Override
    public boolean getBugIsUnassigned(edu.umd.cs.findbugs.BugInstance b) {
        return true;
    }
    @java.lang.Override
    public boolean getWillNotBeFixed(edu.umd.cs.findbugs.BugInstance b) {
        return false;
    }
    @java.lang.Override
    public java.util.Set<java.lang.String> getReviewers(edu.umd.cs.findbugs.BugInstance b) {
        java.util.HashSet<java.lang.String> result =
          new java.util.HashSet<java.lang.String>(
          );
        for (edu.umd.cs.findbugs.BugDesignation d
              :
              getLatestDesignationFromEachUser(
                b)) {
            result.
              add(
                d.
                  getUser(
                    ));
        }
        return result;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.IGuiCallback getGuiCallback() {
        return getBugCollection(
                 ).
          getProject(
            ).
          getGuiCallback(
            );
    }
    @java.lang.Override
    public java.lang.String getCloudName() {
        return getPlugin(
                 ).
          getDescription(
            );
    }
    @java.lang.Override
    public boolean communicationInitiated() {
        return !isOnlineCloud(
                  );
    }
    public long getLocalFirstSeen(edu.umd.cs.findbugs.BugInstance b) {
        long firstVersion =
          b.
          getFirstVersion(
            );
        edu.umd.cs.findbugs.AppVersion v =
          getBugCollection(
            ).
          getAppVersionFromSequenceNumber(
            firstVersion);
        if (v ==
              null) {
            return getBugCollection(
                     ).
              getTimestamp(
                );
        }
        long firstSeen =
          v.
          getTimestamp(
            );
        if (b.
              hasXmlProps(
                )) {
            edu.umd.cs.findbugs.BugInstance.XmlProps props =
              b.
              getXmlProps(
                );
            java.util.Date propsFirstSeen =
              props.
              getFirstSeen(
                );
            if (propsFirstSeen !=
                  null &&
                  firstSeen >
                  propsFirstSeen.
                  getTime(
                    )) {
                firstSeen =
                  propsFirstSeen.
                    getTime(
                      );
            }
        }
        return firstSeen;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VNtIVtzDDZgscTRRTFWSeAyQYiaX5mqi");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qirCPsx4ipH0Fxu3Ea0zvLxyVqRfX0BA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "wHBkt1z6sYLfT5+Dxf+bJ58CM7WUC4Ei");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "lvf/A1ZiJ23moQAA");
}
