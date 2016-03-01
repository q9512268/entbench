package edu.umd.cs.findbugs.workflow;
public class Filter {
    static class FilterCommandLine extends edu.umd.cs.findbugs.config.CommandLine {
        public static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000L;
        java.util.regex.Pattern classPattern;
        java.util.regex.Pattern bugPattern;
        java.util.regex.Pattern callsPattern;
        public boolean notSpecified = false;
        public boolean not = false;
        int duration;
        long first;
        java.lang.String firstAsString;
        long after;
        java.lang.String afterAsString;
        long before;
        java.lang.String beforeAsString;
        int maxRank = java.lang.Integer.MAX_VALUE;
        long maybeMutated;
        java.lang.String maybeMutatedAsString;
        long last;
        java.lang.String lastAsString;
        java.lang.String trimToVersionAsString;
        java.lang.String fixedAsString;
        long present;
        java.lang.String presentAsString;
        long absent;
        java.lang.String absentAsString;
        java.lang.String annotation;
        java.util.HashSet<java.lang.String> hashesFromFile;
        public boolean sloppyUniqueSpecified = false;
        public boolean sloppyUnique = false;
        public boolean purgeHistorySpecified = false;
        public boolean purgeHistory = false;
        public boolean activeSpecified = false;
        public boolean active = false;
        public boolean notAProblem = false;
        public boolean notAProblemSpecified = false;
        public boolean shouldFix = false;
        public boolean shouldFixSpecified = false;
        public boolean hasField = false;
        public boolean hasFieldSpecified = false;
        public boolean hasLocal = false;
        public boolean hasLocalSpecified = false;
        public boolean applySuppression = false;
        public boolean applySuppressionSpecified = false;
        public boolean withSource = false;
        public boolean withSourceSpecified = false;
        public boolean knownSource = false;
        public boolean knownSourceSpecified = false;
        public boolean introducedByChange = false;
        public boolean introducedByChangeSpecified = false;
        public boolean removedByChange = false;
        public boolean removedByChangeSpecified = false;
        public boolean newCode = false;
        public boolean newCodeSpecified = false;
        public boolean hashChanged = false;
        public boolean hashChangedSpecified = false;
        public boolean removedCode = false;
        public boolean removedCodeSpecified = false;
        public boolean dontUpdateStats = false;
        public boolean dontUpdateStatsSpecified = false;
        public int maxAge = 0;
        public boolean maxAgeSpecified = false;
        public boolean withMessagesSpecified = false;
        public boolean withMessages = false;
        private final java.util.List<edu.umd.cs.findbugs.filter.Matcher> includeFilter =
          new java.util.LinkedList<edu.umd.cs.findbugs.filter.Matcher>(
          );
        private final java.util.List<edu.umd.cs.findbugs.filter.Matcher>
          excludeFilter =
          new java.util.LinkedList<edu.umd.cs.findbugs.filter.Matcher>(
          );
        java.util.HashSet<java.lang.String> excludedInstanceHashes =
          new java.util.HashSet<java.lang.String>(
          );
        java.util.Set<java.lang.String> designationKey = new java.util.HashSet<java.lang.String>(
          );
        java.util.Set<java.lang.String> categoryKey = new java.util.HashSet<java.lang.String>(
          );
        java.util.SortedSet<edu.umd.cs.findbugs.BugInstance>
          uniqueSloppy;
        int priority = 3;
        FilterCommandLine() { super();
                              addSwitch("-not", "reverse (all) switches for the filter");
                              addSwitchWithOptionalExtraPart(
                                "-knownSource",
                                "trurh",
                                "Only issues that have known source locations");
                              addSwitchWithOptionalExtraPart(
                                "-withSource",
                                "truth",
                                "only warnings for which source is available");
                              addSwitchWithOptionalExtraPart(
                                "-hashChanged",
                                "truth",
                                ("only warnings for which the stored hash is not the same as t" +
                                 "he calculated hash"));
                              addOption("-excludeBugs",
                                        "baseline bug collection",
                                        ("exclude bugs already contained in the baseline bug collectio" +
                                         "n"));
                              addOption("-exclude",
                                        "filter file",
                                        "exclude bugs matching given filter");
                              addOption("-include",
                                        "filter file",
                                        "include only bugs matching given filter");
                              addOption("-annotation",
                                        "text",
                                        ("allow only warnings containing this text in a user annotatio" +
                                         "n"));
                              addSwitchWithOptionalExtraPart(
                                "-withMessages",
                                "truth",
                                "generated XML should contain textual messages");
                              addOption("-maxDuration",
                                        "# versions",
                                        "only issues present in at most this many versions");
                              addOption("-after",
                                        "when",
                                        "allow only warnings that first occurred after this version");
                              addOption("-before",
                                        "when",
                                        "allow only warnings that first occurred before this version");
                              addOption("-first",
                                        "when",
                                        "allow only warnings that first occurred in this version");
                              addOption("-last",
                                        "when",
                                        "allow only warnings that last occurred in this version");
                              addOption("-trimToVersion",
                                        "when",
                                        ("trim bug collection to exclude information about versions af" +
                                         "ter this one"));
                              addOption("-fixed",
                                        "when",
                                        ("allow only warnings that last occurred in the previous versi" +
                                         "on (clobbers last)"));
                              addOption("-present",
                                        "when",
                                        "allow only warnings present in this version");
                              addOption("-absent",
                                        "when",
                                        "allow only warnings absent in this version");
                              addOption("-maybeMutated",
                                        "when",
                                        ("allow only warnings that might have mutated/fixed/born in th" +
                                         "is version"));
                              addSwitchWithOptionalExtraPart(
                                "-hasField",
                                "truth",
                                "allow only warnings that are annotated with a field");
                              addSwitchWithOptionalExtraPart(
                                "-hasLocal",
                                "truth",
                                "allow only warnings that are annotated with a local variable");
                              addSwitchWithOptionalExtraPart(
                                "-active",
                                "truth",
                                "allow only warnings alive in the last sequence number");
                              addSwitch("-applySuppression",
                                        "exclude warnings that match the suppression filter");
                              addSwitch("-purgeHistory",
                                        "remove all version history");
                              addSwitchWithOptionalExtraPart(
                                "-sloppyUnique",
                                "truth",
                                ("select only issues thought to be unique by the sloppy bug co" +
                                 "mparator "));
                              makeOptionUnlisted(
                                "-sloppyUnique");
                              addSwitchWithOptionalExtraPart(
                                "-introducedByChange",
                                "truth",
                                ("allow only warnings introduced by a change of an existing cl" +
                                 "ass"));
                              addSwitchWithOptionalExtraPart(
                                "-removedByChange",
                                "truth",
                                ("allow only warnings removed by a change of a persisting clas" +
                                 "s"));
                              addSwitchWithOptionalExtraPart(
                                "-newCode",
                                "truth",
                                ("allow only warnings introduced by the addition of a new clas" +
                                 "s"));
                              addSwitchWithOptionalExtraPart(
                                "-removedCode",
                                "truth",
                                "allow only warnings removed by removal of a class");
                              addOption("-priority",
                                        "level",
                                        "allow only warnings with this priority or higher");
                              makeOptionUnlisted(
                                "-priority");
                              addOption("-confidence",
                                        "level",
                                        "allow only warnings with this confidence or higher");
                              addOption("-maxRank",
                                        "rank",
                                        "allow only warnings with this rank or lower");
                              addOption("-maxAge",
                                        "days",
                                        ("Only issues that and in the cloud and weren\'t first seen mo" +
                                         "re than this many days ago"));
                              addSwitchWithOptionalExtraPart(
                                "-notAProblem",
                                "truth",
                                ("Only issues with a consensus view that they are not a proble" +
                                 "m"));
                              addSwitchWithOptionalExtraPart(
                                "-shouldFix",
                                "truth",
                                "Only issues with a consensus view that they should be fixed");
                              addOption("-class",
                                        "pattern",
                                        ("allow only bugs whose primary class name matches this patter" +
                                         "n"));
                              addOption("-calls",
                                        "pattern",
                                        ("allow only bugs that involve a call to a method that matches" +
                                         " this pattern (matches with method class or name)"));
                              addOption("-bugPattern",
                                        "pattern",
                                        "allow only bugs whose type matches this pattern");
                              addOption("-category",
                                        "category",
                                        ("allow only warnings with a category that starts with this st" +
                                         "ring"));
                              addOption("-designation",
                                        "designation",
                                        ("allow only warnings with this designation (e.g., -designatio" +
                                         "n SHOULD_FIX,MUST_FIX)"));
                              addSwitch("-dontUpdateStats",
                                        ("used when withSource is specified to only update bugs, not t" +
                                         "he class and package stats"));
                              addOption("-hashes",
                                        "hash file",
                                        "only bugs with instance hashes contained in the hash file");
        }
        public static long getVersionNum(edu.umd.cs.findbugs.BugCollection collection,
                                         java.lang.String val,
                                         boolean roundToLaterVersion) {
            if (val ==
                  null) {
                return -1;
            }
            java.util.Map<java.lang.String,edu.umd.cs.findbugs.AppVersion> versions =
              new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.AppVersion>(
              );
            java.util.SortedMap<java.lang.Long,edu.umd.cs.findbugs.AppVersion> timeStamps =
              new java.util.TreeMap<java.lang.Long,edu.umd.cs.findbugs.AppVersion>(
              );
            for (java.util.Iterator<edu.umd.cs.findbugs.AppVersion> i =
                   collection.
                   appVersionIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.AppVersion v =
                  i.
                  next(
                    );
                versions.
                  put(
                    v.
                      getReleaseName(
                        ),
                    v);
                timeStamps.
                  put(
                    v.
                      getTimestamp(
                        ),
                    v);
            }
            edu.umd.cs.findbugs.AppVersion v =
              collection.
              getCurrentAppVersion(
                );
            versions.
              put(
                v.
                  getReleaseName(
                    ),
                v);
            timeStamps.
              put(
                v.
                  getTimestamp(
                    ),
                v);
            return getVersionNum(
                     versions,
                     timeStamps,
                     val,
                     roundToLaterVersion,
                     v.
                       getSequenceNumber(
                         ));
        }
        public static long getVersionNum(java.util.Map<java.lang.String,edu.umd.cs.findbugs.AppVersion> versions,
                                         java.util.SortedMap<java.lang.Long,edu.umd.cs.findbugs.AppVersion> timeStamps,
                                         java.lang.String val,
                                         boolean roundToLaterVersion,
                                         long currentSeqNum) {
            if (val ==
                  null) {
                return -1;
            }
            long numVersions =
              currentSeqNum +
              1;
            if ("last".
                  equals(
                    val) ||
                  "lastVersion".
                  equals(
                    val)) {
                return numVersions -
                  1;
            }
            edu.umd.cs.findbugs.AppVersion v =
              versions.
              get(
                val);
            if (v !=
                  null) {
                return v.
                  getSequenceNumber(
                    );
            }
            try {
                long time =
                  0;
                if (val.
                      endsWith(
                        "daysAgo")) {
                    time =
                      java.lang.System.
                        currentTimeMillis(
                          ) -
                        MILLISECONDS_PER_DAY *
                        java.lang.Integer.
                        parseInt(
                          val.
                            substring(
                              0,
                              val.
                                length(
                                  ) -
                                7));
                }
                else {
                    time =
                      java.util.Date.
                        parse(
                          val);
                }
                return getAppropriateSeq(
                         timeStamps,
                         time,
                         roundToLaterVersion);
            }
            catch (java.lang.Exception e) {
                try {
                    long version =
                      java.lang.Long.
                      parseLong(
                        val);
                    if (version <
                          0) {
                        version =
                          numVersions +
                            version;
                    }
                    return version;
                }
                catch (java.lang.NumberFormatException e1) {
                    throw new java.lang.IllegalArgumentException(
                      "Could not interpret version specification of \'" +
                      val +
                      "\'");
                }
            }
        }
        private static long getAppropriateSeq(java.util.SortedMap<java.lang.Long,edu.umd.cs.findbugs.AppVersion> timeStamps,
                                              long when,
                                              boolean roundToLaterVersion) {
            if (roundToLaterVersion) {
                java.util.SortedMap<java.lang.Long,edu.umd.cs.findbugs.AppVersion> geq =
                  timeStamps.
                  tailMap(
                    when);
                if (geq.
                      isEmpty(
                        )) {
                    return java.lang.Long.
                             MAX_VALUE;
                }
                return geq.
                  get(
                    geq.
                      firstKey(
                        )).
                  getSequenceNumber(
                    );
            }
            else {
                java.util.SortedMap<java.lang.Long,edu.umd.cs.findbugs.AppVersion> leq =
                  timeStamps.
                  headMap(
                    when);
                if (leq.
                      isEmpty(
                        )) {
                    return java.lang.Long.
                             MIN_VALUE;
                }
                return leq.
                  get(
                    leq.
                      lastKey(
                        )).
                  getSequenceNumber(
                    );
            }
        }
        private long minFirstSeen;
        edu.umd.cs.findbugs.filter.Filter
          suppressionFilter;
        void adjustFilter(edu.umd.cs.findbugs.Project project,
                          edu.umd.cs.findbugs.BugCollection collection) {
            suppressionFilter =
              project.
                getSuppressionFilter(
                  );
            if (maxAgeSpecified) {
                minFirstSeen =
                  collection.
                    getAnalysisTimestamp(
                      ) -
                    maxAge *
                    MILLISECONDS_PER_DAY;
            }
            first =
              getVersionNum(
                collection,
                firstAsString,
                true);
            maybeMutated =
              getVersionNum(
                collection,
                maybeMutatedAsString,
                true);
            last =
              getVersionNum(
                collection,
                lastAsString,
                true);
            before =
              getVersionNum(
                collection,
                beforeAsString,
                true);
            after =
              getVersionNum(
                collection,
                afterAsString,
                false);
            present =
              getVersionNum(
                collection,
                presentAsString,
                true);
            absent =
              getVersionNum(
                collection,
                absentAsString,
                true);
            if (sloppyUniqueSpecified) {
                uniqueSloppy =
                  new java.util.TreeSet<edu.umd.cs.findbugs.BugInstance>(
                    new edu.umd.cs.findbugs.SloppyBugComparator(
                      ));
            }
            long fixed =
              getVersionNum(
                collection,
                fixedAsString,
                true);
            if (fixed >=
                  0) {
                last =
                  fixed -
                    1;
            }
        }
        boolean accept(edu.umd.cs.findbugs.BugCollection collection,
                       edu.umd.cs.findbugs.BugInstance bug) {
            boolean result =
              evaluate(
                collection,
                bug);
            if (not) {
                return !result;
            }
            return result;
        }
        boolean evaluate(edu.umd.cs.findbugs.BugCollection collection,
                         edu.umd.cs.findbugs.BugInstance bug) {
            for (edu.umd.cs.findbugs.filter.Matcher m
                  :
                  includeFilter) {
                if (!m.
                      match(
                        bug)) {
                    return false;
                }
            }
            for (edu.umd.cs.findbugs.filter.Matcher m
                  :
                  excludeFilter) {
                if (m.
                      match(
                        bug)) {
                    return false;
                }
            }
            if (excludedInstanceHashes.
                  contains(
                    bug.
                      getInstanceHash(
                        ))) {
                return false;
            }
            if (annotation !=
                  null &&
                  bug.
                  getAnnotationText(
                    ).
                  indexOf(
                    annotation) ==
                  -1) {
                return false;
            }
            if (bug.
                  getPriority(
                    ) >
                  priority) {
                return false;
            }
            if (firstAsString !=
                  null &&
                  bug.
                  getFirstVersion(
                    ) !=
                  first) {
                return false;
            }
            if (afterAsString !=
                  null &&
                  bug.
                  getFirstVersion(
                    ) <=
                  after) {
                return false;
            }
            if (beforeAsString !=
                  null &&
                  bug.
                  getFirstVersion(
                    ) >=
                  before) {
                return false;
            }
            if (hashesFromFile !=
                  null &&
                  !hashesFromFile.
                  contains(
                    bug.
                      getInstanceHash(
                        ))) {
                return false;
            }
            long lastSeen =
              bug.
              getLastVersion(
                );
            if (lastSeen <
                  0) {
                lastSeen =
                  collection.
                    getSequenceNumber(
                      );
            }
            long thisDuration =
              lastSeen -
              bug.
              getFirstVersion(
                );
            if (duration >
                  0 &&
                  thisDuration >
                  duration) {
                return false;
            }
            if ((lastAsString !=
                   null ||
                   fixedAsString !=
                   null) &&
                  (last <
                     0 ||
                     bug.
                     getLastVersion(
                       ) !=
                     last)) {
                return false;
            }
            if (presentAsString !=
                  null &&
                  !bugLiveAt(
                     bug,
                     present)) {
                return false;
            }
            if (absentAsString !=
                  null &&
                  bugLiveAt(
                    bug,
                    absent)) {
                return false;
            }
            if (hasFieldSpecified &&
                  hasField !=
                  (bug.
                     getPrimaryField(
                       ) !=
                     null)) {
                return false;
            }
            if (hasLocalSpecified &&
                  hasLocal !=
                  (bug.
                     getPrimaryLocalVariableAnnotation(
                       ) !=
                     null)) {
                return false;
            }
            if (maxRank <
                  java.lang.Integer.
                    MAX_VALUE &&
                  edu.umd.cs.findbugs.BugRanker.
                  findRank(
                    bug) >
                  maxRank) {
                return false;
            }
            if (activeSpecified &&
                  active ==
                  bug.
                  isDead(
                    )) {
                return false;
            }
            if (removedByChangeSpecified &&
                  bug.
                  isRemovedByChangeOfPersistingClass(
                    ) !=
                  removedByChange) {
                return false;
            }
            if (introducedByChangeSpecified &&
                  bug.
                  isIntroducedByChangeOfExistingClass(
                    ) !=
                  introducedByChange) {
                return false;
            }
            if (newCodeSpecified &&
                  newCode !=
                  (!bug.
                     isIntroducedByChangeOfExistingClass(
                       ) &&
                     bug.
                     getFirstVersion(
                       ) !=
                     0)) {
                return false;
            }
            if (removedCodeSpecified &&
                  removedCode !=
                  (!bug.
                     isRemovedByChangeOfPersistingClass(
                       ) &&
                     bug.
                     isDead(
                       ))) {
                return false;
            }
            if (bugPattern !=
                  null &&
                  !bugPattern.
                  matcher(
                    bug.
                      getType(
                        )).
                  find(
                    )) {
                return false;
            }
            if (classPattern !=
                  null &&
                  !classPattern.
                  matcher(
                    bug.
                      getPrimaryClass(
                        ).
                      getClassName(
                        )).
                  find(
                    )) {
                return false;
            }
            if (callsPattern !=
                  null) {
                edu.umd.cs.findbugs.MethodAnnotation m =
                  bug.
                  getAnnotationWithRole(
                    edu.umd.cs.findbugs.MethodAnnotation.class,
                    edu.umd.cs.findbugs.MethodAnnotation.
                      METHOD_CALLED);
                if (m ==
                      null) {
                    return false;
                }
                if (!callsPattern.
                      matcher(
                        m.
                          getClassName(
                            )).
                      find(
                        ) &&
                      !callsPattern.
                      matcher(
                        m.
                          getMethodName(
                            )).
                      find(
                        )) {
                    return false;
                }
            }
            if (maybeMutatedAsString !=
                  null &&
                  !(atMutationPoint(
                      bug) &&
                      mutationPoints.
                      contains(
                        getBugLocation(
                          bug)))) {
                return false;
            }
            edu.umd.cs.findbugs.BugPattern thisBugPattern =
              bug.
              getBugPattern(
                );
            if (!categoryKey.
                  isEmpty(
                    ) &&
                  thisBugPattern !=
                  null &&
                  !categoryKey.
                  contains(
                    thisBugPattern.
                      getCategory(
                        ))) {
                return false;
            }
            if (!designationKey.
                  isEmpty(
                    ) &&
                  !designationKey.
                  contains(
                    bug.
                      getUserDesignationKey(
                        ))) {
                return false;
            }
            if (hashChangedSpecified) {
                if (bug.
                      isInstanceHashConsistent(
                        ) ==
                      hashChanged) {
                    return false;
                }
            }
            if (applySuppressionSpecified &&
                  applySuppression &&
                  suppressionFilter.
                  match(
                    bug)) {
                return false;
            }
            edu.umd.cs.findbugs.SourceLineAnnotation primarySourceLineAnnotation =
              bug.
              getPrimarySourceLineAnnotation(
                );
            if (knownSourceSpecified) {
                if (primarySourceLineAnnotation.
                      isUnknown(
                        ) ==
                      knownSource) {
                    return false;
                }
            }
            if (withSourceSpecified) {
                if (sourceSearcher.
                      findSource(
                        primarySourceLineAnnotation) !=
                      withSource) {
                    return false;
                }
            }
            edu.umd.cs.findbugs.cloud.Cloud cloud =
              collection.
              getCloud(
                );
            if (maxAgeSpecified) {
                long firstSeen =
                  cloud.
                  getFirstSeen(
                    bug);
                if (!cloud.
                      isInCloud(
                        bug)) {
                    return false;
                }
                if (firstSeen <
                      minFirstSeen) {
                    return false;
                }
            }
            if (notAProblemSpecified &&
                  notAProblem !=
                  cloud.
                  getConsensusDesignation(
                    bug).
                  score(
                    ) <
                  0) {
                return false;
            }
            if (shouldFixSpecified &&
                  shouldFix !=
                  cloud.
                  getConsensusDesignation(
                    bug).
                  score(
                    ) >
                  0) {
                return false;
            }
            if (sloppyUniqueSpecified) {
                boolean unique =
                  uniqueSloppy.
                  add(
                    bug);
                if (unique !=
                      sloppyUnique) {
                    return false;
                }
            }
            return true;
        }
        private void addDesignationKey(java.lang.String argument) {
            edu.umd.cs.findbugs.I18N i18n =
              edu.umd.cs.findbugs.I18N.
              instance(
                );
            for (java.lang.String x
                  :
                  argument.
                   split(
                     "[,|]")) {
                for (java.lang.String designationKey
                      :
                      i18n.
                       getUserDesignationKeys(
                         )) {
                    if (designationKey.
                          equals(
                            x) ||
                          i18n.
                          getUserDesignation(
                            designationKey).
                          equals(
                            x)) {
                        this.
                          designationKey.
                          add(
                            designationKey);
                        break;
                    }
                }
            }
        }
        private void addCategoryKey(java.lang.String argument) {
            edu.umd.cs.findbugs.DetectorFactoryCollection i18n =
              edu.umd.cs.findbugs.DetectorFactoryCollection.
              instance(
                );
            for (java.lang.String x
                  :
                  argument.
                   split(
                     "[,|]")) {
                for (edu.umd.cs.findbugs.BugCategory category
                      :
                      i18n.
                       getBugCategoryObjects(
                         )) {
                    if (category.
                          getAbbrev(
                            ).
                          equals(
                            x) ||
                          category.
                          getCategory(
                            ).
                          equals(
                            x)) {
                        this.
                          categoryKey.
                          add(
                            category.
                              getCategory(
                                ));
                        break;
                    }
                }
            }
        }
        private boolean bugLiveAt(edu.umd.cs.findbugs.BugInstance bug,
                                  long now) {
            if (now <
                  bug.
                  getFirstVersion(
                    )) {
                return false;
            }
            if (bug.
                  isDead(
                    ) &&
                  bug.
                  getLastVersion(
                    ) <
                  now) {
                return false;
            }
            return true;
        }
        @java.lang.Override
        protected void handleOption(java.lang.String option,
                                    java.lang.String optionExtraPart)
              throws java.io.IOException {
            option =
              option.
                substring(
                  1);
            if (optionExtraPart.
                  length(
                    ) ==
                  0) {
                setField(
                  option,
                  true);
            }
            else {
                setField(
                  option,
                  java.lang.Boolean.
                    parseBoolean(
                      optionExtraPart));
            }
            setField(
              option +
              "Specified",
              true);
        }
        private void setField(java.lang.String fieldName,
                              boolean value) {
            try {
                java.lang.reflect.Field f =
                  edu.umd.cs.findbugs.workflow.Filter.FilterCommandLine.class.
                  getField(
                    fieldName);
                f.
                  setBoolean(
                    this,
                    value);
            }
            catch (java.lang.RuntimeException e) {
                throw e;
            }
            catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(
                  e);
            }
        }
        @java.lang.Override
        protected void handleOptionWithArgument(java.lang.String option,
                                                java.lang.String argument)
              throws java.io.IOException {
            if ("-priority".
                  equals(
                    option) ||
                  "-confidence".
                  equals(
                    option)) {
                priority =
                  parsePriority(
                    argument);
            }
            else
                if ("-maxRank".
                      equals(
                        option)) {
                    maxRank =
                      java.lang.Integer.
                        parseInt(
                          argument);
                }
                else
                    if ("-first".
                          equals(
                            option)) {
                        firstAsString =
                          argument;
                    }
                    else
                        if ("-maybeMutated".
                              equals(
                                option)) {
                            maybeMutatedAsString =
                              argument;
                        }
                        else
                            if ("-last".
                                  equals(
                                    option)) {
                                lastAsString =
                                  argument;
                            }
                            else
                                if ("-trimToVersion".
                                      equals(
                                        option)) {
                                    trimToVersionAsString =
                                      argument;
                                }
                                else
                                    if ("-maxDuration".
                                          equals(
                                            option)) {
                                        duration =
                                          java.lang.Integer.
                                            parseInt(
                                              argument);
                                    }
                                    else
                                        if ("-fixed".
                                              equals(
                                                option)) {
                                            fixedAsString =
                                              argument;
                                        }
                                        else
                                            if ("-after".
                                                  equals(
                                                    option)) {
                                                afterAsString =
                                                  argument;
                                            }
                                            else
                                                if ("-before".
                                                      equals(
                                                        option)) {
                                                    beforeAsString =
                                                      argument;
                                                }
                                                else
                                                    if ("-present".
                                                          equals(
                                                            option)) {
                                                        presentAsString =
                                                          argument;
                                                    }
                                                    else
                                                        if ("-absent".
                                                              equals(
                                                                option)) {
                                                            absentAsString =
                                                              argument;
                                                        }
                                                        else
                                                            if ("-category".
                                                                  equals(
                                                                    option)) {
                                                                addCategoryKey(
                                                                  argument);
                                                            }
                                                            else
                                                                if ("-designation".
                                                                      equals(
                                                                        option)) {
                                                                    addDesignationKey(
                                                                      argument);
                                                                }
                                                                else
                                                                    if ("-class".
                                                                          equals(
                                                                            option)) {
                                                                        classPattern =
                                                                          java.util.regex.Pattern.
                                                                            compile(
                                                                              argument.
                                                                                replace(
                                                                                  ',',
                                                                                  '|'));
                                                                    }
                                                                    else
                                                                        if ("-calls".
                                                                              equals(
                                                                                option)) {
                                                                            callsPattern =
                                                                              java.util.regex.Pattern.
                                                                                compile(
                                                                                  argument.
                                                                                    replace(
                                                                                      ',',
                                                                                      '|'));
                                                                        }
                                                                        else
                                                                            if ("-bugPattern".
                                                                                  equals(
                                                                                    option)) {
                                                                                bugPattern =
                                                                                  java.util.regex.Pattern.
                                                                                    compile(
                                                                                      argument);
                                                                            }
                                                                            else
                                                                                if ("-annotation".
                                                                                      equals(
                                                                                        option)) {
                                                                                    annotation =
                                                                                      argument;
                                                                                }
                                                                                else
                                                                                    if ("-excludeBugs".
                                                                                          equals(
                                                                                            option)) {
                                                                                        try {
                                                                                            edu.umd.cs.findbugs.ExcludingHashesBugReporter.
                                                                                              addToExcludedInstanceHashes(
                                                                                                excludedInstanceHashes,
                                                                                                argument);
                                                                                        }
                                                                                        catch (org.dom4j.DocumentException e) {
                                                                                            throw new java.lang.IllegalArgumentException(
                                                                                              "Error processing include file: " +
                                                                                              argument,
                                                                                              e);
                                                                                        }
                                                                                    }
                                                                                    else
                                                                                        if ("-include".
                                                                                              equals(
                                                                                                option)) {
                                                                                            try {
                                                                                                includeFilter.
                                                                                                  add(
                                                                                                    new edu.umd.cs.findbugs.filter.Filter(
                                                                                                      argument));
                                                                                            }
                                                                                            catch (edu.umd.cs.findbugs.filter.FilterException e) {
                                                                                                throw new java.lang.IllegalArgumentException(
                                                                                                  "Error processing include file: " +
                                                                                                  argument,
                                                                                                  e);
                                                                                            }
                                                                                        }
                                                                                        else
                                                                                            if ("-exclude".
                                                                                                  equals(
                                                                                                    option)) {
                                                                                                try {
                                                                                                    excludeFilter.
                                                                                                      add(
                                                                                                        new edu.umd.cs.findbugs.filter.Filter(
                                                                                                          argument));
                                                                                                }
                                                                                                catch (edu.umd.cs.findbugs.filter.FilterException e) {
                                                                                                    throw new java.lang.IllegalArgumentException(
                                                                                                      "Error processing include file: " +
                                                                                                      argument,
                                                                                                      e);
                                                                                                }
                                                                                            }
                                                                                            else
                                                                                                if ("-maxAge".
                                                                                                      equals(
                                                                                                        option)) {
                                                                                                    maxAge =
                                                                                                      java.lang.Integer.
                                                                                                        parseInt(
                                                                                                          argument);
                                                                                                    maxAgeSpecified =
                                                                                                      true;
                                                                                                }
                                                                                                else
                                                                                                    if ("-hashes".
                                                                                                          equals(
                                                                                                            option)) {
                                                                                                        hashesFromFile =
                                                                                                          new java.util.HashSet<java.lang.String>(
                                                                                                            );
                                                                                                        java.io.BufferedReader in =
                                                                                                          null;
                                                                                                        try {
                                                                                                            in =
                                                                                                              new java.io.BufferedReader(
                                                                                                                edu.umd.cs.findbugs.charsets.UTF8.
                                                                                                                  fileReader(
                                                                                                                    argument));
                                                                                                            while (true) {
                                                                                                                java.lang.String h =
                                                                                                                  in.
                                                                                                                  readLine(
                                                                                                                    );
                                                                                                                if (h ==
                                                                                                                      null) {
                                                                                                                    break;
                                                                                                                }
                                                                                                                hashesFromFile.
                                                                                                                  add(
                                                                                                                    h);
                                                                                                            }
                                                                                                        }
                                                                                                        catch (java.io.IOException e) {
                                                                                                            throw new java.lang.RuntimeException(
                                                                                                              "Error reading hashes from " +
                                                                                                              argument,
                                                                                                              e);
                                                                                                        }
                                                                                                        finally {
                                                                                                            edu.umd.cs.findbugs.util.Util.
                                                                                                              closeSilently(
                                                                                                                in);
                                                                                                        }
                                                                                                    }
                                                                                                    else {
                                                                                                        throw new java.lang.IllegalArgumentException(
                                                                                                          "can\'t handle command line argument of " +
                                                                                                          option);
                                                                                                    }
        }
        java.util.HashSet<java.lang.String>
          mutationPoints;
        public void getReady(edu.umd.cs.findbugs.SortedBugCollection origCollection) {
            if (maybeMutatedAsString !=
                  null) {
                java.util.HashSet<java.lang.String> addedIssues =
                  new java.util.HashSet<java.lang.String>(
                  );
                java.util.HashSet<java.lang.String> removedIssues =
                  new java.util.HashSet<java.lang.String>(
                  );
                for (edu.umd.cs.findbugs.BugInstance b
                      :
                      origCollection) {
                    if (b.
                          getFirstVersion(
                            ) ==
                          maybeMutated) {
                        addedIssues.
                          add(
                            getBugLocation(
                              b));
                    }
                    else
                        if (b.
                              getLastVersion(
                                ) ==
                              maybeMutated -
                              1) {
                            removedIssues.
                              add(
                                getBugLocation(
                                  b));
                        }
                }
                addedIssues.
                  remove(
                    null);
                addedIssues.
                  retainAll(
                    removedIssues);
                mutationPoints =
                  addedIssues;
            }
        }
        private boolean atMutationPoint(edu.umd.cs.findbugs.BugInstance b) {
            return b.
              getFirstVersion(
                ) ==
              maybeMutated ||
              b.
              getLastVersion(
                ) ==
              maybeMutated -
              1;
        }
        private java.lang.String getBugLocation(edu.umd.cs.findbugs.BugInstance b) {
            java.lang.String point;
            edu.umd.cs.findbugs.MethodAnnotation m =
              b.
              getPrimaryMethod(
                );
            edu.umd.cs.findbugs.FieldAnnotation f =
              b.
              getPrimaryField(
                );
            if (m !=
                  null) {
                point =
                  m.
                    toString(
                      );
            }
            else
                if (f !=
                      null) {
                    point =
                      f.
                        toString(
                          );
                }
                else {
                    point =
                      null;
                }
            return point;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVdC3gURbaumSEQwiMhPAUBgQALYkbxtRr1GkKQyIREAvgR" +
           "1NDp6SQNM9Od7ppkguLbC8qHL8C3eH3iC9FVrutrxfXzwQrre8Wri7q711V3" +
           "/VY/765+6716Tz1muqenq0LPit9XnaG7Tp3/nDp1zumqrvLhL1GJbaFJWgpX" +
           "4z5Ts6vrU7hZsWwtXpdQbHsp3GtTb4wo35z32eKTwmhgKxrepdiNqmJrC3Qt" +
           "Ebdb0UQ9ZWMlpWr2Yk2LE4pmS7M1q0fBupFqRaN1uyFpJnRVx41GXCMVlitW" +
           "DI1QMLb09jTWGngDGE2MAZIoRRKt9T6uiaGhqmH2OdXHuarXuZ6QmkmHl41R" +
           "RWy10qNE01hPRGO6jWsyFjrSNBJ9nQkDV2sZXL06cTxXwZmx4wtUMPXR8n98" +
           "f21XBVXBSCWVMjAVz16i2UaiR4vHULlztz6hJe1udCGKxNAQV2WMqmJZplFg" +
           "GgWmWWmdWoB+mJZKJ+sMKg7OtjTQVAkgjKbkN2IqlpLkzTRTzNBCKeayU2KQ" +
           "9oictEzKAhG3HhndcuN5Fb+IoPJWVK6nWggcFUBgYNIKCtWS7Zpl18bjWrwV" +
           "jUhBZ7dolq4k9LW8pyttvTOl4DR0f1Yt5Gba1CzK09EV9CPIZqVVbFg58Tqo" +
           "QfF/lXQklE6QdYwjK5NwAbkPApbpAMzqUMDuOMmANXoqjtFkL0VOxqpFUAFI" +
           "ByU13GXkWA1IKXADVTITSSipzmgLmF6qE6qWGGCAFkbjhY0SXZuKukbp1NqI" +
           "RXrqNbNHUGswVQQhwWi0txptCXppvKeXXP3z5eJTrj4/tTAVRiHAHNfUBME/" +
           "BIgmeYiWaB2apcE4YIRDZ8duUMY8tyGMEFQe7anM6jx5wdenz5m0+1VWZ4JP" +
           "nab21ZqK29R72oe/eXjdrJMiBEapadg66fw8yekoa+ZPajImeJgxuRbJw+rs" +
           "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" +
           "pENf9XvfoXN4kU/pT/Lrz/8PAulnth5kAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7pNnwx0cXMrXnYI7T4UH169ImT8V+bkd5c/tobz/MpT3OHKGb1uJUw+6Dx64" +
           "g2L9+R3Tz+9heuRSxbplOldhL7iDsbpf2MH9wh64l1wG7kV5EMqC8F3WtfPL" +
           "9PE7GKv7xR3iL+5BfOIyiA8eRzyL7JWXJ3txvrcH0i/tyH5pD9nrziY72Dw0" +
           "NZegFuQ724fPd01XsRNV274RkZ917eIB+8dOvip228Obh45Pst48IjnYzP2+" +
           "9tgmx1mPSfKjL73jG+dnv3pzm+3Yff7/k4c4rznrlZD59rUTVo4VQwvPHc0/" +
           "eP0dlNNnduX0mT3l9PSecsqPPXWyiLTsWBHlx4un+L7qik8o2yB9dsf32T18" +
           "xNl8h08oX7yjOpxQ3tk8scw1//ApPPKKeHln4XM7vM/twaMuwHtI1bav9IHe" +
           "PaOtLmnYLzzxeshtdv38I7vePpA8GHxJzHrPbQ+tenDcqvOLnf/06YC+osLz" +
           "tvZXdgr/lT0K/9oLFP48BbgW3QtXQNt5/lPzDQ6+7opMuRf+/I7p83uYlAuY" +
           "Hky2j8E2z5suaQIvPVYWXhjnb4rebgjHXoA5zJQDWV8SczgX4dAorLNc3SvP" +
           "cnVEot+qpOfbjXrFMsrfzvr1XRn9+p4yyi4oo/tAq+SFZrx5mHU69FldHmiz" +
           "9zVAyW/dZt1+ngH0zfub7oOnjib6mW4rn28raNpm7PK0OX/LFVX1VeAOsx3Z" +
           "bA/Zt12gqhdERyOWR+11XuyvPqeFO2w2juM/e/U5LQe7DurBng7qwbsvcslO" +
           "sp1k0/fM7avht7UU33Uh1uZa2bVrceHu8g30Rik/63vOvvH1/GtePwqt4Hh7" +
           "+pKFrTx5612a3bS7Jxc2unGsJ4FuzUm/BNDmP5DrmvDU7H9+TY71/qthvSzH" +
           "2g4NduUoZjcv6WnqLbLT87cuTxa/8tOdakTht/66kkpWdJGfyYkjNAepyRp9" +
           "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" +
           "Hy7W6tPY73h0tBZFq58OSkEwxoOuWBu6");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("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" +
           "Hdyaxbb1HX96jtB/nm/+BDReQGhgmqHnh2b+/o4WnBL8i89B8M3ExgYQeLdK" +
           "5bXbVqk8R/DCmeIepIemmFvCV5xV1XY/mJGz/PP8Itev7VfE9bvzbH8ZFx6U" +
           "1UUSxcdmfZ5aMveupWeqR3r5f89BL5tsLwb62C1IdO22BYnuVC8bmfNNtBHu" +
           "0XMEfyzfPH+zcIui+dtliw/Fu/7QcxXvcSDWbtWba7etevMlEu+Jc8R7Vb55" +
           "aVy4T8vXlt+9lHNMwJc9VwFRwPOa7bnbz0sKeHwa9Cn+a0dh33s2QrzhHAHf" +
           "mG9eB2qwrKqNE69i5AfuPZL0wndrLpK0CiQs7SQtfZkkrZ0jKZZv4HxxQ1Ul" +
           "T7wDcVzM8nMQ8/F856uBeG/aifmmL42Yx8x2s2/TGF0nzpG1kW/eFBfuB56s" +
           "ay41/HTFfPNzEDNfbrZAA6DOTszOVcQEUKCdiIFn1dQLpN22v9uS5c4u+pOx" +
           "iOndoLhmljsiYMOb8wb5hgKO2ZBd1dY4fxcdHy/zU6/hPHiojMPLP3psbbml" +
           "Foamqu3X3yXrw5uBkPxOg/yX2lCOBf/X33qOoczyzVuAf4u0+NaKQ8dV87XP" +
           "1U44wLNbGfzgtpXBL5DyOnsFA7H3+obr/CbDptT1uPD4cUsYmbGBh3ribFdf" +
           "PS66sdcq8qOj51L+m9dXwZkHP7vTzM9eUTO33l09v1J85VlhzTaYPtFZ3Khn" +
           "dY6VPJNvYmAlIMzjNVk97TST5+o089dWfnWni1/90tSFo/LfNfPPniPgd+Sb" +
           "t+dr48Xs8ZdfTnnNb30Ocr4k3/k6IN8XdnJ+4csk53vOkfN9+eZdoA0EBQlM" +
           "IF+Y6nC04EjMC3+L4MTvIoHY4bafabtlga+9xI+8RWHh8dt+OHL7Y4fKj33g" +
           "4fte8gHxNzc/anb4g4T3dwv3zRPbPv6zQse+3+OH2ny74tz9m+1Dmw7j9Q/E" +
           "hZefxwPs+9bXnP/6+7en/RBoXc44DeS+9fV47g/GhQeOcseFA+XE4Q/HhXt3" +
           "h+PCdbA9fvBHwC5wMP/6o/4tFb7+LGTFc+emfuOYxrNtrT/ez9+OGD56UWEe" +
           "G+l77d51ddlk+7OfN5WPfYDufcMXax/a/l4b6JCv1/lV7usW7t3+dNzmovmQ" +
           "3Kv3Xu3Wte7pPPUXD/2T+193a+zwoS3wUUU4xvbKs38lren48eZ3zdb/7CU/" +
           "+VUf/sDvbn7i6f8D9i97l411AAA=");
    }
    public static int parsePriority(java.lang.String argument) {
        int i =
          " HMLE".
          indexOf(
            argument);
        if (i ==
              -1) {
            i =
              " 1234".
                indexOf(
                  argument);
        }
        if (i ==
              -1) {
            throw new java.lang.IllegalArgumentException(
              "Bad priority: " +
              argument);
        }
        return i;
    }
    static edu.umd.cs.findbugs.workflow.SourceSearcher
      sourceSearcher;
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { edu.umd.cs.findbugs.FindBugs.
                                         setNoAnalysis(
                                           );
                                       edu.umd.cs.findbugs.DetectorFactoryCollection.
                                         instance(
                                           );
                                       final edu.umd.cs.findbugs.workflow.Filter.FilterCommandLine commandLine =
                                         new edu.umd.cs.findbugs.workflow.Filter.FilterCommandLine(
                                         );
                                       int argCount =
                                         commandLine.
                                         parse(
                                           args,
                                           0,
                                           2,
                                           "Usage: " +
                                           edu.umd.cs.findbugs.workflow.Filter.class.
                                             getName(
                                               ) +
                                           " [options] [<orig results> [<new results]] ");
                                       edu.umd.cs.findbugs.SortedBugCollection origCollection =
                                         new edu.umd.cs.findbugs.SortedBugCollection(
                                         );
                                       if (argCount ==
                                             args.
                                               length) {
                                           origCollection.
                                             readXML(
                                               java.lang.System.
                                                 in);
                                       }
                                       else {
                                           origCollection.
                                             readXML(
                                               args[argCount++]);
                                       }
                                       boolean verbose =
                                         argCount <
                                         args.
                                           length;
                                       edu.umd.cs.findbugs.SortedBugCollection resultCollection =
                                         origCollection.
                                         createEmptyCollectionWithMetadata(
                                           );
                                       edu.umd.cs.findbugs.Project project =
                                         resultCollection.
                                         getProject(
                                           );
                                       int passed =
                                         0;
                                       int dropped =
                                         0;
                                       resultCollection.
                                         setWithMessages(
                                           commandLine.
                                             withMessages);
                                       if (commandLine.
                                             hashChangedSpecified) {
                                           origCollection.
                                             computeBugHashes(
                                               );
                                       }
                                       commandLine.
                                         adjustFilter(
                                           project,
                                           resultCollection);
                                       edu.umd.cs.findbugs.ProjectStats projectStats =
                                         resultCollection.
                                         getProjectStats(
                                           );
                                       projectStats.
                                         clearBugCounts(
                                           );
                                       if (commandLine.
                                             classPattern !=
                                             null) {
                                           projectStats.
                                             purgeClassesThatDontMatch(
                                               commandLine.
                                                 classPattern);
                                       }
                                       sourceSearcher =
                                         new edu.umd.cs.findbugs.workflow.SourceSearcher(
                                           project);
                                       long trimToVersion =
                                         -1;
                                       if (commandLine.
                                             trimToVersionAsString !=
                                             null) {
                                           java.util.Map<java.lang.String,edu.umd.cs.findbugs.AppVersion> versions =
                                             new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.AppVersion>(
                                             );
                                           java.util.SortedMap<java.lang.Long,edu.umd.cs.findbugs.AppVersion> timeStamps =
                                             new java.util.TreeMap<java.lang.Long,edu.umd.cs.findbugs.AppVersion>(
                                             );
                                           for (java.util.Iterator<edu.umd.cs.findbugs.AppVersion> i =
                                                  origCollection.
                                                  appVersionIterator(
                                                    );
                                                i.
                                                  hasNext(
                                                    );
                                                ) {
                                               edu.umd.cs.findbugs.AppVersion v =
                                                 i.
                                                 next(
                                                   );
                                               versions.
                                                 put(
                                                   v.
                                                     getReleaseName(
                                                       ),
                                                   v);
                                               timeStamps.
                                                 put(
                                                   v.
                                                     getTimestamp(
                                                       ),
                                                   v);
                                           }
                                           edu.umd.cs.findbugs.AppVersion v =
                                             resultCollection.
                                             getCurrentAppVersion(
                                               );
                                           versions.
                                             put(
                                               v.
                                                 getReleaseName(
                                                   ),
                                               v);
                                           timeStamps.
                                             put(
                                               v.
                                                 getTimestamp(
                                                   ),
                                               v);
                                           trimToVersion =
                                             edu.umd.cs.findbugs.workflow.Filter.FilterCommandLine.
                                               getVersionNum(
                                                 versions,
                                                 timeStamps,
                                                 commandLine.
                                                   trimToVersionAsString,
                                                 true,
                                                 v.
                                                   getSequenceNumber(
                                                     ));
                                           if (trimToVersion <
                                                 origCollection.
                                                 getSequenceNumber(
                                                   )) {
                                               java.lang.String name =
                                                 resultCollection.
                                                 getAppVersionFromSequenceNumber(
                                                   trimToVersion).
                                                 getReleaseName(
                                                   );
                                               long timestamp =
                                                 resultCollection.
                                                 getAppVersionFromSequenceNumber(
                                                   trimToVersion).
                                                 getTimestamp(
                                                   );
                                               resultCollection.
                                                 setReleaseName(
                                                   name);
                                               resultCollection.
                                                 setTimestamp(
                                                   timestamp);
                                               resultCollection.
                                                 trimAppVersions(
                                                   trimToVersion);
                                           }
                                       }
                                       if (commandLine.
                                             maxAgeSpecified ||
                                             commandLine.
                                               notAProblemSpecified ||
                                             commandLine.
                                               shouldFixSpecified) {
                                           edu.umd.cs.findbugs.cloud.Cloud cloud =
                                             origCollection.
                                             getCloud(
                                               );
                                           edu.umd.cs.findbugs.cloud.Cloud.SigninState signinState =
                                             cloud.
                                             getSigninState(
                                               );
                                           if (!signinState.
                                                 canDownload(
                                                   )) {
                                               disconnect(
                                                 verbose,
                                                 commandLine,
                                                 resultCollection,
                                                 cloud.
                                                   getCloudName(
                                                     ) +
                                                 " state is " +
                                                 signinState +
                                                 "; ignoring filtering options that require cloud access");
                                           }
                                           else
                                               if (!cloud.
                                                     waitUntilIssueDataDownloaded(
                                                       20,
                                                       java.util.concurrent.TimeUnit.
                                                         SECONDS)) {
                                                   if (verbose) {
                                                       java.lang.System.
                                                         out.
                                                         println(
                                                           "Waiting for cloud information required for filtering");
                                                   }
                                                   if (!cloud.
                                                         waitUntilIssueDataDownloaded(
                                                           60,
                                                           java.util.concurrent.TimeUnit.
                                                             SECONDS)) {
                                                       disconnect(
                                                         verbose,
                                                         commandLine,
                                                         resultCollection,
                                                         ("Unable to connect to cloud; ignoring filtering options that " +
                                                          "require cloud access"));
                                                   }
                                               }
                                       }
                                       commandLine.
                                         getReady(
                                           origCollection);
                                       for (edu.umd.cs.findbugs.BugInstance bug
                                             :
                                             origCollection.
                                              getCollection(
                                                )) {
                                           if (commandLine.
                                                 accept(
                                                   origCollection,
                                                   bug)) {
                                               if (trimToVersion >=
                                                     0) {
                                                   if (bug.
                                                         getFirstVersion(
                                                           ) >
                                                         trimToVersion) {
                                                       dropped++;
                                                       continue;
                                                   }
                                                   else
                                                       if (bug.
                                                             getLastVersion(
                                                               ) >=
                                                             trimToVersion) {
                                                           bug.
                                                             setLastVersion(
                                                               -1);
                                                           bug.
                                                             setRemovedByChangeOfPersistingClass(
                                                               false);
                                                       }
                                               }
                                               resultCollection.
                                                 add(
                                                   bug,
                                                   false);
                                               passed++;
                                           }
                                           else {
                                               dropped++;
                                           }
                                       }
                                       if (commandLine.
                                             purgeHistorySpecified &&
                                             commandLine.
                                               purgeHistory) {
                                           resultCollection.
                                             clearAppVersions(
                                               );
                                           for (edu.umd.cs.findbugs.BugInstance bug
                                                 :
                                                 resultCollection.
                                                  getCollection(
                                                    )) {
                                               bug.
                                                 clearHistory(
                                                   );
                                           }
                                       }
                                       if (verbose) {
                                           java.lang.System.
                                             out.
                                             println(
                                               passed +
                                               " warnings passed through, " +
                                               dropped +
                                               " warnings dropped");
                                       }
                                       if (commandLine.
                                             withSourceSpecified &&
                                             commandLine.
                                               withSource &&
                                             !commandLine.
                                                dontUpdateStats &&
                                             projectStats.
                                             hasClassStats(
                                               )) {
                                           for (edu.umd.cs.findbugs.PackageStats stats
                                                 :
                                                 projectStats.
                                                  getPackageStats(
                                                    )) {
                                               java.util.Iterator<edu.umd.cs.findbugs.PackageStats.ClassStats> i =
                                                 stats.
                                                 getClassStats(
                                                   ).
                                                 iterator(
                                                   );
                                               while (i.
                                                        hasNext(
                                                          )) {
                                                   java.lang.String className =
                                                     i.
                                                     next(
                                                       ).
                                                     getName(
                                                       );
                                                   if (sourceSearcher.
                                                         sourceNotFound.
                                                         contains(
                                                           className) ||
                                                         !sourceSearcher.
                                                            sourceFound.
                                                         contains(
                                                           className) &&
                                                         !sourceSearcher.
                                                         findSource(
                                                           edu.umd.cs.findbugs.SourceLineAnnotation.
                                                             createReallyUnknown(
                                                               className))) {
                                                       i.
                                                         remove(
                                                           );
                                                   }
                                               }
                                           }
                                       }
                                       projectStats.
                                         recomputeFromComponents(
                                           );
                                       if (argCount ==
                                             args.
                                               length) {
                                           assert !verbose;
                                           resultCollection.
                                             writeXML(
                                               java.lang.System.
                                                 out);
                                       }
                                       else {
                                           resultCollection.
                                             writeXML(
                                               args[argCount++]);
                                       } }
    private static void disconnect(boolean verbose,
                                   final edu.umd.cs.findbugs.workflow.Filter.FilterCommandLine commandLine,
                                   edu.umd.cs.findbugs.SortedBugCollection resultCollection,
                                   java.lang.String msg) {
        if (verbose) {
            java.lang.System.
              out.
              println(
                msg);
        }
        resultCollection.
          addError(
            msg);
        commandLine.
          maxAgeSpecified =
          (commandLine.
             notAProblemSpecified =
             (commandLine.
                shouldFixSpecified =
                false));
    }
    public Filter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nbTcIKuLJ79/z2de+9tPfDMraP0v/Utv5NAnAAA=");
}
