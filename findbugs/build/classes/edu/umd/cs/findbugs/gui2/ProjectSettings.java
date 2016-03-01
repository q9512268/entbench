package edu.umd.cs.findbugs.gui2;
@java.lang.Deprecated
public class ProjectSettings implements java.io.Serializable {
    private static final long serialVersionUID = 6505872267795979672L;
    private ProjectSettings() { super();
                                allMatchers = new edu.umd.cs.findbugs.gui2.CompoundMatcher(
                                                );
                                filters = new java.util.ArrayList<edu.umd.cs.findbugs.gui2.FilterMatcher>(
                                            ); }
    private static edu.umd.cs.findbugs.gui2.ProjectSettings
      instance;
    public static edu.umd.cs.findbugs.gui2.ProjectSettings newInstance() {
        instance =
          new edu.umd.cs.findbugs.gui2.ProjectSettings(
            );
        return instance;
    }
    public static synchronized edu.umd.cs.findbugs.gui2.ProjectSettings getInstance() {
        if (instance ==
              null) {
            instance =
              new edu.umd.cs.findbugs.gui2.ProjectSettings(
                );
        }
        return instance;
    }
    private final java.util.ArrayList<edu.umd.cs.findbugs.gui2.FilterMatcher>
      filters;
    private final edu.umd.cs.findbugs.gui2.CompoundMatcher
      allMatchers;
    private int maxSizeOfPreviousComments;
    public static void loadInstance(@javax.annotation.WillClose
                                    java.io.InputStream in) {
        try {
            instance =
              (edu.umd.cs.findbugs.gui2.ProjectSettings)
                new java.io.ObjectInputStream(
                in).
                readObject(
                  );
            edu.umd.cs.findbugs.gui2.PreferencesFrame.
              getInstance(
                ).
              updateFilterPanel(
                );
        }
        catch (java.lang.ClassNotFoundException e) {
            if (edu.umd.cs.findbugs.gui2.MainFrame.
                  GUI2_DEBUG) {
                java.lang.System.
                  err.
                  println(
                    "Error in deserializing Settings:");
            }
            edu.umd.cs.findbugs.gui2.Debug.
              println(
                e);
        }
        catch (java.io.IOException e) {
            if (edu.umd.cs.findbugs.gui2.MainFrame.
                  GUI2_DEBUG) {
                java.lang.System.
                  err.
                  println(
                    "IO error in deserializing Settings:");
            }
            edu.umd.cs.findbugs.gui2.Debug.
              println(
                e);
            instance =
              newInstance(
                );
        }
        finally {
            try {
                in.
                  close(
                    );
            }
            catch (java.io.IOException e) {
                assert false;
            }
        }
    }
    public void save(@javax.annotation.WillClose
                     java.io.OutputStream out) { try {
                                                     new java.io.ObjectOutputStream(
                                                       out).
                                                       writeObject(
                                                         this);
                                                 }
                                                 catch (java.io.IOException e) {
                                                     if (edu.umd.cs.findbugs.gui2.MainFrame.
                                                           GUI2_DEBUG) {
                                                         java.lang.System.
                                                           err.
                                                           println(
                                                             "Error serializing Settings:");
                                                     }
                                                     edu.umd.cs.findbugs.gui2.Debug.
                                                       println(
                                                         e);
                                                 }
                                                 finally {
                                                     try {
                                                         out.
                                                           close(
                                                             );
                                                     }
                                                     catch (java.io.IOException e) {
                                                         assert true;
                                                     }
                                                 }
    }
    public void addFilter(edu.umd.cs.findbugs.gui2.FilterMatcher filter) {
        filters.
          add(
            filter);
        allMatchers.
          add(
            filter);
        if (!(filter instanceof edu.umd.cs.findbugs.gui2.StackedFilterMatcher)) {
            edu.umd.cs.findbugs.gui2.FilterActivity.
              notifyListeners(
                edu.umd.cs.findbugs.gui2.FilterListener.Action.
                  FILTERING,
                null);
        }
        else {
            edu.umd.cs.findbugs.gui2.StackedFilterMatcher theSame =
              (edu.umd.cs.findbugs.gui2.StackedFilterMatcher)
                filter;
            edu.umd.cs.findbugs.gui2.FilterMatcher[] filtersInStack =
              theSame.
              getFilters(
                );
            java.util.ArrayList<edu.umd.cs.findbugs.gui2.Sortables> order =
              edu.umd.cs.findbugs.gui2.MainFrame.
              getInstance(
                ).
              getSorter(
                ).
              getOrder(
                );
            int sizeToCheck =
              filtersInStack.
                length;
            java.util.List<edu.umd.cs.findbugs.gui2.Sortables> sortablesToCheck =
              order.
              subList(
                0,
                sizeToCheck);
            edu.umd.cs.findbugs.gui2.Debug.
              println(
                "Size to check" +
                sizeToCheck +
                " checking list" +
                sortablesToCheck);
            edu.umd.cs.findbugs.gui2.Debug.
              println(
                "checking filters");
            java.util.ArrayList<java.lang.String> almostPath =
              new java.util.ArrayList<java.lang.String>(
              );
            java.util.ArrayList<edu.umd.cs.findbugs.gui2.Sortables> almostPathSortables =
              new java.util.ArrayList<edu.umd.cs.findbugs.gui2.Sortables>(
              );
            for (int x =
                   0;
                 x <
                   sortablesToCheck.
                   size(
                     );
                 x++) {
                edu.umd.cs.findbugs.gui2.Sortables s =
                  sortablesToCheck.
                  get(
                    x);
                for (edu.umd.cs.findbugs.gui2.FilterMatcher fm
                      :
                      filtersInStack) {
                    if (s.
                          equals(
                            fm.
                              getFilterBy(
                                ))) {
                        almostPath.
                          add(
                            fm.
                              getValue(
                                ));
                        almostPathSortables.
                          add(
                            fm.
                              getFilterBy(
                                ));
                    }
                }
            }
            if (almostPath.
                  size(
                    ) ==
                  filtersInStack.
                    length) {
                java.util.ArrayList<java.lang.String> finalPath =
                  new java.util.ArrayList<java.lang.String>(
                  );
                for (int x =
                       0;
                     x <
                       almostPath.
                       size(
                         );
                     x++) {
                    edu.umd.cs.findbugs.gui2.Sortables s =
                      almostPathSortables.
                      get(
                        x);
                    if (edu.umd.cs.findbugs.gui2.MainFrame.
                          getInstance(
                            ).
                          getSorter(
                            ).
                          getOrderBeforeDivider(
                            ).
                          contains(
                            s)) {
                        finalPath.
                          add(
                            almostPath.
                              get(
                                x));
                    }
                }
                edu.umd.cs.findbugs.gui2.BugTreeModel model =
                  edu.umd.cs.findbugs.gui2.MainFrame.
                  getInstance(
                    ).
                  getBugTreeModel(
                    );
                try {
                    model.
                      sendEvent(
                        model.
                          removeBranch(
                            finalPath),
                        edu.umd.cs.findbugs.gui2.BugTreeModel.TreeModification.
                          REMOVE);
                }
                catch (edu.umd.cs.findbugs.gui2.BugTreeModel.BranchOperationException e) {
                    throw new java.lang.IllegalStateException(
                      ("They added a stacked filter on a branch that doesn\'t exist." +
                       ".. Whaa?"));
                }
            }
            else {
                edu.umd.cs.findbugs.gui2.FilterActivity.
                  notifyListeners(
                    edu.umd.cs.findbugs.gui2.FilterListener.Action.
                      FILTERING,
                    null);
                throw new java.lang.IllegalStateException(
                  ("What huh?  How\'d they add a stacked filter matcher bigger t" +
                   "han the number of branches in the tree?!"));
            }
        }
        edu.umd.cs.findbugs.gui2.PreferencesFrame.
          getInstance(
            ).
          updateFilterPanel(
            );
        edu.umd.cs.findbugs.gui2.MainFrame.
          getInstance(
            ).
          updateStatusBar(
            );
    }
    public void addFilters(edu.umd.cs.findbugs.gui2.FilterMatcher[] newFilters) {
        for (edu.umd.cs.findbugs.gui2.FilterMatcher i
              :
              newFilters) {
            if (!filters.
                  contains(
                    i)) {
                filters.
                  add(
                    i);
                allMatchers.
                  add(
                    i);
            }
            else {
                filters.
                  get(
                    filters.
                      indexOf(
                        i)).
                  setActive(
                    true);
            }
        }
        edu.umd.cs.findbugs.gui2.FilterActivity.
          notifyListeners(
            edu.umd.cs.findbugs.gui2.FilterListener.Action.
              FILTERING,
            null);
        edu.umd.cs.findbugs.gui2.PreferencesFrame.
          getInstance(
            ).
          updateFilterPanel(
            );
        edu.umd.cs.findbugs.gui2.MainFrame.
          getInstance(
            ).
          updateStatusBar(
            );
    }
    public boolean removeFilter(edu.umd.cs.findbugs.gui2.FilterMatcher filter) {
        boolean result =
          filters.
          remove(
            filter) &&
          allMatchers.
          remove(
            filter);
        edu.umd.cs.findbugs.gui2.FilterActivity.
          notifyListeners(
            edu.umd.cs.findbugs.gui2.FilterListener.Action.
              UNFILTERING,
            null);
        edu.umd.cs.findbugs.gui2.PreferencesFrame.
          getInstance(
            ).
          updateFilterPanel(
            );
        edu.umd.cs.findbugs.gui2.MainFrame.
          getInstance(
            ).
          updateStatusBar(
            );
        return result;
    }
    java.util.ArrayList<edu.umd.cs.findbugs.gui2.FilterMatcher> getAllFilters() {
        return filters;
    }
    public int getMaxSizeOfPreviousComments() {
        return maxSizeOfPreviousComments;
    }
    public void setMaxSizeOfPreviousComments(int num) {
        maxSizeOfPreviousComments =
          num;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p4EvZUfrJTzk5ig2iIkBSw7DqKm3+5A1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "9Oz/ByeRGmNOOQAA");
}
