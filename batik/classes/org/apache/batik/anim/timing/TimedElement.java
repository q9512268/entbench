package org.apache.batik.anim.timing;
public abstract class TimedElement implements org.apache.batik.util.SMILConstants {
    public static final int FILL_REMOVE = 0;
    public static final int FILL_FREEZE = 1;
    public static final int RESTART_ALWAYS = 0;
    public static final int RESTART_WHEN_NOT_ACTIVE = 1;
    public static final int RESTART_NEVER = 2;
    public static final float INDEFINITE = java.lang.Float.POSITIVE_INFINITY;
    public static final float UNRESOLVED = java.lang.Float.NaN;
    protected org.apache.batik.anim.timing.TimedDocumentRoot root;
    protected org.apache.batik.anim.timing.TimeContainer parent;
    protected org.apache.batik.anim.timing.TimingSpecifier[] beginTimes;
    protected org.apache.batik.anim.timing.TimingSpecifier[] endTimes;
    protected float simpleDur;
    protected boolean durMedia;
    protected float repeatCount;
    protected float repeatDur;
    protected int currentRepeatIteration;
    protected float lastRepeatTime;
    protected int fillMode;
    protected int restartMode;
    protected float min;
    protected boolean minMedia;
    protected float max;
    protected boolean maxMedia;
    protected boolean isActive;
    protected boolean isFrozen;
    protected float lastSampleTime;
    protected float repeatDuration;
    protected java.util.List beginInstanceTimes = new java.util.ArrayList(
      );
    protected java.util.List endInstanceTimes = new java.util.ArrayList();
    protected org.apache.batik.anim.timing.Interval currentInterval;
    protected float lastIntervalEnd;
    protected org.apache.batik.anim.timing.Interval previousInterval;
    protected java.util.LinkedList beginDependents = new java.util.LinkedList(
      );
    protected java.util.LinkedList endDependents = new java.util.LinkedList(
      );
    protected boolean shouldUpdateCurrentInterval = true;
    protected boolean hasParsed;
    protected java.util.Map handledEvents = new java.util.HashMap();
    protected boolean isSampling;
    protected boolean hasPropagated;
    public TimedElement() { super();
                            beginTimes = (new org.apache.batik.anim.timing.TimingSpecifier[0]);
                            endTimes = beginTimes;
                            simpleDur = UNRESOLVED;
                            repeatCount = UNRESOLVED;
                            repeatDur = UNRESOLVED;
                            lastRepeatTime = UNRESOLVED;
                            max = INDEFINITE;
                            lastSampleTime = UNRESOLVED;
                            lastIntervalEnd = java.lang.Float.NEGATIVE_INFINITY;
    }
    public org.apache.batik.anim.timing.TimedDocumentRoot getRoot() { return root;
    }
    public float getActiveTime() { return lastSampleTime; }
    public float getSimpleTime() { return lastSampleTime - lastRepeatTime;
    }
    protected float addInstanceTime(org.apache.batik.anim.timing.InstanceTime time,
                                    boolean isBegin) { hasPropagated =
                                                         true;
                                                       java.util.List instanceTimes =
                                                         isBegin
                                                         ? beginInstanceTimes
                                                         : endInstanceTimes;
                                                       int index =
                                                         java.util.Collections.
                                                         binarySearch(
                                                           instanceTimes,
                                                           time);
                                                       if (index <
                                                             0) {
                                                           index =
                                                             -(index +
                                                                 1);
                                                       }
                                                       instanceTimes.
                                                         add(
                                                           index,
                                                           time);
                                                       shouldUpdateCurrentInterval =
                                                         true;
                                                       float ret;
                                                       if (root.
                                                             isSampling(
                                                               ) &&
                                                             !isSampling) {
                                                           ret =
                                                             sampleAt(
                                                               root.
                                                                 getCurrentTime(
                                                                   ),
                                                               root.
                                                                 isHyperlinking(
                                                                   ));
                                                       }
                                                       else {
                                                           ret =
                                                             java.lang.Float.
                                                               POSITIVE_INFINITY;
                                                       }
                                                       hasPropagated =
                                                         false;
                                                       root.
                                                         currentIntervalWillUpdate(
                                                           );
                                                       return ret;
    }
    protected float removeInstanceTime(org.apache.batik.anim.timing.InstanceTime time,
                                       boolean isBegin) {
        hasPropagated =
          true;
        java.util.List instanceTimes =
          isBegin
          ? beginInstanceTimes
          : endInstanceTimes;
        int index =
          java.util.Collections.
          binarySearch(
            instanceTimes,
            time);
        for (int i =
               index;
             i >=
               0;
             i--) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                instanceTimes.
                get(
                  i);
            if (it ==
                  time) {
                instanceTimes.
                  remove(
                    i);
                break;
            }
            if (it.
                  compareTo(
                    time) !=
                  0) {
                break;
            }
        }
        int len =
          instanceTimes.
          size(
            );
        for (int i =
               index +
               1;
             i <
               len;
             i++) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                instanceTimes.
                get(
                  i);
            if (it ==
                  time) {
                instanceTimes.
                  remove(
                    i);
                break;
            }
            if (it.
                  compareTo(
                    time) !=
                  0) {
                break;
            }
        }
        shouldUpdateCurrentInterval =
          true;
        float ret;
        if (root.
              isSampling(
                ) &&
              !isSampling) {
            ret =
              sampleAt(
                root.
                  getCurrentTime(
                    ),
                root.
                  isHyperlinking(
                    ));
        }
        else {
            ret =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        hasPropagated =
          false;
        root.
          currentIntervalWillUpdate(
            );
        return ret;
    }
    protected float instanceTimeChanged(org.apache.batik.anim.timing.InstanceTime time,
                                        boolean isBegin) {
        hasPropagated =
          true;
        shouldUpdateCurrentInterval =
          true;
        float ret;
        if (root.
              isSampling(
                ) &&
              !isSampling) {
            ret =
              sampleAt(
                root.
                  getCurrentTime(
                    ),
                root.
                  isHyperlinking(
                    ));
        }
        else {
            ret =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        hasPropagated =
          false;
        return ret;
    }
    protected void addDependent(org.apache.batik.anim.timing.TimingSpecifier dependent,
                                boolean forBegin) {
        if (forBegin) {
            beginDependents.
              add(
                dependent);
        }
        else {
            endDependents.
              add(
                dependent);
        }
    }
    protected void removeDependent(org.apache.batik.anim.timing.TimingSpecifier dependent,
                                   boolean forBegin) {
        if (forBegin) {
            beginDependents.
              remove(
                dependent);
        }
        else {
            endDependents.
              remove(
                dependent);
        }
    }
    public float getSimpleDur() { if (durMedia) {
                                      return getImplicitDur(
                                               );
                                  }
                                  else
                                      if (isUnresolved(
                                            simpleDur)) {
                                          if (isUnresolved(
                                                repeatCount) &&
                                                isUnresolved(
                                                  repeatDur) &&
                                                endTimes.
                                                  length >
                                                0) {
                                              return INDEFINITE;
                                          }
                                          return getImplicitDur(
                                                   );
                                      }
                                      else {
                                          return simpleDur;
                                      } }
    public static boolean isUnresolved(float t) {
        return java.lang.Float.
          isNaN(
            t);
    }
    public float getActiveDur(float B, float end) {
        float d =
          getSimpleDur(
            );
        float PAD;
        if (!isUnresolved(
               end) &&
              d ==
              INDEFINITE) {
            PAD =
              minusTime(
                end,
                B);
            repeatDuration =
              minTime(
                max,
                maxTime(
                  min,
                  PAD));
            return repeatDuration;
        }
        float IAD;
        if (d ==
              0) {
            IAD =
              0;
        }
        else {
            if (isUnresolved(
                  repeatDur) &&
                  isUnresolved(
                    repeatCount)) {
                IAD =
                  d;
            }
            else {
                float p1 =
                  isUnresolved(
                    repeatCount)
                  ? INDEFINITE
                  : multiplyTime(
                      d,
                      repeatCount);
                float p2 =
                  isUnresolved(
                    repeatDur)
                  ? INDEFINITE
                  : repeatDur;
                IAD =
                  minTime(
                    minTime(
                      p1,
                      p2),
                    INDEFINITE);
            }
        }
        if (isUnresolved(
              end) ||
              end ==
              INDEFINITE) {
            PAD =
              IAD;
        }
        else {
            PAD =
              minTime(
                IAD,
                minusTime(
                  end,
                  B));
        }
        repeatDuration =
          IAD;
        return minTime(
                 max,
                 maxTime(
                   min,
                   PAD));
    }
    protected float minusTime(float t1, float t2) {
        if (isUnresolved(
              t1) ||
              isUnresolved(
                t2)) {
            return UNRESOLVED;
        }
        if (t1 ==
              INDEFINITE ||
              t2 ==
              INDEFINITE) {
            return INDEFINITE;
        }
        return t1 -
          t2;
    }
    protected float multiplyTime(float t,
                                 float n) {
        if (isUnresolved(
              t) ||
              t ==
              INDEFINITE) {
            return t;
        }
        return t *
          n;
    }
    protected float minTime(float t1, float t2) {
        if (t1 ==
              0.0F ||
              t2 ==
              0.0F) {
            return 0.0F;
        }
        if ((t1 ==
               INDEFINITE ||
               isUnresolved(
                 t1)) &&
              t2 !=
              INDEFINITE &&
              !isUnresolved(
                 t2)) {
            return t2;
        }
        if ((t2 ==
               INDEFINITE ||
               isUnresolved(
                 t2)) &&
              t1 !=
              INDEFINITE &&
              !isUnresolved(
                 t1)) {
            return t1;
        }
        if (t1 ==
              INDEFINITE &&
              isUnresolved(
                t2) ||
              isUnresolved(
                t1) &&
              t2 ==
              INDEFINITE) {
            return INDEFINITE;
        }
        if (t1 <
              t2) {
            return t1;
        }
        return t2;
    }
    protected float maxTime(float t1, float t2) {
        if ((t1 ==
               INDEFINITE ||
               isUnresolved(
                 t1)) &&
              t2 !=
              INDEFINITE &&
              !isUnresolved(
                 t2)) {
            return t1;
        }
        if ((t2 ==
               INDEFINITE ||
               isUnresolved(
                 t2)) &&
              t1 !=
              INDEFINITE &&
              !isUnresolved(
                 t1)) {
            return t2;
        }
        if (t1 ==
              INDEFINITE &&
              isUnresolved(
                t2) ||
              isUnresolved(
                t1) &&
              t2 ==
              INDEFINITE) {
            return UNRESOLVED;
        }
        if (t1 >
              t2) {
            return t1;
        }
        return t2;
    }
    protected float getImplicitDur() { return UNRESOLVED;
    }
    protected float notifyNewInterval(org.apache.batik.anim.timing.Interval interval) {
        float dependentMinTime =
          java.lang.Float.
            POSITIVE_INFINITY;
        java.util.Iterator i =
          beginDependents.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimingSpecifier ts =
              (org.apache.batik.anim.timing.TimingSpecifier)
                i.
                next(
                  );
            float t =
              ts.
              newInterval(
                interval);
            if (t <
                  dependentMinTime) {
                dependentMinTime =
                  t;
            }
        }
        i =
          endDependents.
            iterator(
              );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimingSpecifier ts =
              (org.apache.batik.anim.timing.TimingSpecifier)
                i.
                next(
                  );
            float t =
              ts.
              newInterval(
                interval);
            if (t <
                  dependentMinTime) {
                dependentMinTime =
                  t;
            }
        }
        return dependentMinTime;
    }
    protected float notifyRemoveInterval(org.apache.batik.anim.timing.Interval interval) {
        float dependentMinTime =
          java.lang.Float.
            POSITIVE_INFINITY;
        java.util.Iterator i =
          beginDependents.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimingSpecifier ts =
              (org.apache.batik.anim.timing.TimingSpecifier)
                i.
                next(
                  );
            float t =
              ts.
              removeInterval(
                interval);
            if (t <
                  dependentMinTime) {
                dependentMinTime =
                  t;
            }
        }
        i =
          endDependents.
            iterator(
              );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimingSpecifier ts =
              (org.apache.batik.anim.timing.TimingSpecifier)
                i.
                next(
                  );
            float t =
              ts.
              removeInterval(
                interval);
            if (t <
                  dependentMinTime) {
                dependentMinTime =
                  t;
            }
        }
        return dependentMinTime;
    }
    protected float sampleAt(float parentSimpleTime,
                             boolean hyperlinking) {
        isSampling =
          true;
        float time =
          parentSimpleTime;
        java.util.Iterator i =
          handledEvents.
          entrySet(
            ).
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            java.util.Map.Entry e =
              (java.util.Map.Entry)
                i.
                next(
                  );
            org.w3c.dom.events.Event evt =
              (org.w3c.dom.events.Event)
                e.
                getKey(
                  );
            java.util.Set ts =
              (java.util.Set)
                e.
                getValue(
                  );
            java.util.Iterator j =
              ts.
              iterator(
                );
            boolean hasBegin =
              false;
            boolean hasEnd =
              false;
            while (j.
                     hasNext(
                       ) &&
                     !(hasBegin &&
                         hasEnd)) {
                org.apache.batik.anim.timing.EventLikeTimingSpecifier t =
                  (org.apache.batik.anim.timing.EventLikeTimingSpecifier)
                    j.
                    next(
                      );
                if (t.
                      isBegin(
                        )) {
                    hasBegin =
                      true;
                }
                else {
                    hasEnd =
                      true;
                }
            }
            boolean useBegin;
            boolean useEnd;
            if (hasBegin &&
                  hasEnd) {
                useBegin =
                  !isActive ||
                    restartMode ==
                    RESTART_ALWAYS;
                useEnd =
                  !useBegin;
            }
            else
                if (hasBegin &&
                      (!isActive ||
                         restartMode ==
                         RESTART_ALWAYS)) {
                    useBegin =
                      true;
                    useEnd =
                      false;
                }
                else
                    if (hasEnd &&
                          isActive) {
                        useBegin =
                          false;
                        useEnd =
                          true;
                    }
                    else {
                        continue;
                    }
            j =
              ts.
                iterator(
                  );
            while (j.
                     hasNext(
                       )) {
                org.apache.batik.anim.timing.EventLikeTimingSpecifier t =
                  (org.apache.batik.anim.timing.EventLikeTimingSpecifier)
                    j.
                    next(
                      );
                boolean isBegin =
                  t.
                  isBegin(
                    );
                if (isBegin &&
                      useBegin ||
                      !isBegin &&
                      useEnd) {
                    t.
                      resolve(
                        evt);
                    shouldUpdateCurrentInterval =
                      true;
                }
            }
        }
        handledEvents.
          clear(
            );
        if (currentInterval !=
              null) {
            float begin =
              currentInterval.
              getBegin(
                );
            if (lastSampleTime <
                  begin &&
                  time >=
                  begin) {
                if (!isActive) {
                    toActive(
                      begin);
                }
                isActive =
                  true;
                isFrozen =
                  false;
                lastRepeatTime =
                  begin;
                fireTimeEvent(
                  SMIL_BEGIN_EVENT_NAME,
                  currentInterval.
                    getBegin(
                      ),
                  0);
            }
        }
        boolean hasEnded =
          currentInterval !=
          null &&
          time >=
          currentInterval.
          getEnd(
            );
        if (currentInterval !=
              null) {
            float begin =
              currentInterval.
              getBegin(
                );
            if (time >=
                  begin) {
                float d =
                  getSimpleDur(
                    );
                while (time -
                         lastRepeatTime >=
                         d &&
                         lastRepeatTime +
                         d <
                         begin +
                         repeatDuration) {
                    lastRepeatTime +=
                      d;
                    currentRepeatIteration++;
                    fireTimeEvent(
                      root.
                        getRepeatEventName(
                          ),
                      lastRepeatTime,
                      currentRepeatIteration);
                }
            }
        }
        float dependentMinTime =
          java.lang.Float.
            POSITIVE_INFINITY;
        if (hyperlinking) {
            shouldUpdateCurrentInterval =
              true;
        }
        while (shouldUpdateCurrentInterval ||
                 hasEnded) {
            if (hasEnded) {
                previousInterval =
                  currentInterval;
                isActive =
                  false;
                isFrozen =
                  fillMode ==
                    FILL_FREEZE;
                toInactive(
                  false,
                  isFrozen);
                fireTimeEvent(
                  SMIL_END_EVENT_NAME,
                  currentInterval.
                    getEnd(
                      ),
                  0);
            }
            boolean first =
              currentInterval ==
              null &&
              previousInterval ==
              null;
            if (currentInterval !=
                  null &&
                  hyperlinking) {
                isActive =
                  false;
                isFrozen =
                  false;
                toInactive(
                  false,
                  false);
                currentInterval =
                  null;
            }
            if (currentInterval ==
                  null ||
                  hasEnded) {
                if (first ||
                      hyperlinking ||
                      restartMode !=
                      RESTART_NEVER) {
                    float beginAfter;
                    boolean incl =
                      true;
                    if (first ||
                          hyperlinking) {
                        beginAfter =
                          java.lang.Float.
                            NEGATIVE_INFINITY;
                    }
                    else {
                        beginAfter =
                          previousInterval.
                            getEnd(
                              );
                        incl =
                          beginAfter !=
                            previousInterval.
                            getBegin(
                              );
                    }
                    org.apache.batik.anim.timing.Interval interval =
                      computeInterval(
                        first,
                        false,
                        beginAfter,
                        incl);
                    if (interval ==
                          null) {
                        currentInterval =
                          null;
                    }
                    else {
                        float dmt =
                          selectNewInterval(
                            time,
                            interval);
                        if (dmt <
                              dependentMinTime) {
                            dependentMinTime =
                              dmt;
                        }
                    }
                }
                else {
                    currentInterval =
                      null;
                }
            }
            else {
                float currentBegin =
                  currentInterval.
                  getBegin(
                    );
                if (currentBegin >
                      time) {
                    float beginAfter;
                    boolean incl =
                      true;
                    if (previousInterval ==
                          null) {
                        beginAfter =
                          java.lang.Float.
                            NEGATIVE_INFINITY;
                    }
                    else {
                        beginAfter =
                          previousInterval.
                            getEnd(
                              );
                        incl =
                          beginAfter !=
                            previousInterval.
                            getBegin(
                              );
                    }
                    org.apache.batik.anim.timing.Interval interval =
                      computeInterval(
                        false,
                        false,
                        beginAfter,
                        incl);
                    float dmt =
                      notifyRemoveInterval(
                        currentInterval);
                    if (dmt <
                          dependentMinTime) {
                        dependentMinTime =
                          dmt;
                    }
                    if (interval ==
                          null) {
                        currentInterval =
                          null;
                    }
                    else {
                        dmt =
                          selectNewInterval(
                            time,
                            interval);
                        if (dmt <
                              dependentMinTime) {
                            dependentMinTime =
                              dmt;
                        }
                    }
                }
                else {
                    org.apache.batik.anim.timing.Interval interval =
                      computeInterval(
                        false,
                        true,
                        currentBegin,
                        true);
                    float newEnd =
                      interval.
                      getEnd(
                        );
                    if (currentInterval.
                          getEnd(
                            ) !=
                          newEnd) {
                        float dmt =
                          currentInterval.
                          setEnd(
                            newEnd,
                            interval.
                              getEndInstanceTime(
                                ));
                        if (dmt <
                              dependentMinTime) {
                            dependentMinTime =
                              dmt;
                        }
                    }
                }
            }
            shouldUpdateCurrentInterval =
              false;
            hyperlinking =
              false;
            hasEnded =
              currentInterval !=
                null &&
                time >=
                currentInterval.
                getEnd(
                  );
        }
        float d =
          getSimpleDur(
            );
        if (isActive &&
              !isFrozen) {
            if (time -
                  currentInterval.
                  getBegin(
                    ) >=
                  repeatDuration) {
                isFrozen =
                  fillMode ==
                    FILL_FREEZE;
                toInactive(
                  true,
                  isFrozen);
            }
            else {
                sampledAt(
                  time -
                    lastRepeatTime,
                  d,
                  currentRepeatIteration);
            }
        }
        if (isFrozen) {
            float t;
            boolean atLast;
            if (isActive) {
                t =
                  currentInterval.
                    getBegin(
                      ) +
                    repeatDuration -
                    lastRepeatTime;
                atLast =
                  lastRepeatTime +
                    d ==
                    currentInterval.
                    getBegin(
                      ) +
                    repeatDuration;
            }
            else {
                t =
                  previousInterval.
                    getEnd(
                      ) -
                    lastRepeatTime;
                atLast =
                  lastRepeatTime +
                    d ==
                    previousInterval.
                    getEnd(
                      );
            }
            if (atLast) {
                sampledLastValue(
                  currentRepeatIteration);
            }
            else {
                sampledAt(
                  t %
                    d,
                  d,
                  currentRepeatIteration);
            }
        }
        else
            if (!isActive) {
                
            }
        isSampling =
          false;
        lastSampleTime =
          time;
        if (currentInterval !=
              null) {
            float t =
              currentInterval.
              getBegin(
                ) -
              time;
            if (t <=
                  0) {
                t =
                  isConstantAnimation(
                    ) ||
                    isFrozen
                    ? currentInterval.
                    getEnd(
                      ) -
                    time
                    : 0;
            }
            if (dependentMinTime <
                  t) {
                return dependentMinTime;
            }
            return t;
        }
        return dependentMinTime;
    }
    protected boolean endHasEventConditions() {
        for (int i =
               0;
             i <
               endTimes.
                 length;
             i++) {
            if (endTimes[i].
                  isEventCondition(
                    )) {
                return true;
            }
        }
        return false;
    }
    protected float selectNewInterval(float time,
                                      org.apache.batik.anim.timing.Interval interval) {
        currentInterval =
          interval;
        float dmt =
          notifyNewInterval(
            currentInterval);
        float beginEventTime =
          currentInterval.
          getBegin(
            );
        if (time >=
              beginEventTime) {
            lastRepeatTime =
              beginEventTime;
            if (beginEventTime <
                  0) {
                beginEventTime =
                  0;
            }
            toActive(
              beginEventTime);
            isActive =
              true;
            isFrozen =
              false;
            fireTimeEvent(
              SMIL_BEGIN_EVENT_NAME,
              beginEventTime,
              0);
            float d =
              getSimpleDur(
                );
            float end =
              currentInterval.
              getEnd(
                );
            while (time -
                     lastRepeatTime >=
                     d &&
                     lastRepeatTime +
                     d <
                     end) {
                lastRepeatTime +=
                  d;
                currentRepeatIteration++;
                fireTimeEvent(
                  root.
                    getRepeatEventName(
                      ),
                  lastRepeatTime,
                  currentRepeatIteration);
            }
        }
        return dmt;
    }
    protected org.apache.batik.anim.timing.Interval computeInterval(boolean first,
                                                                    boolean fixedBegin,
                                                                    float beginAfter,
                                                                    boolean incl) {
        java.util.Iterator beginIterator =
          beginInstanceTimes.
          iterator(
            );
        java.util.Iterator endIterator =
          endInstanceTimes.
          iterator(
            );
        float parentSimpleDur =
          parent.
          getSimpleDur(
            );
        org.apache.batik.anim.timing.InstanceTime endInstanceTime =
          endIterator.
          hasNext(
            )
          ? (org.apache.batik.anim.timing.InstanceTime)
              endIterator.
              next(
                )
          : null;
        boolean firstEnd =
          true;
        org.apache.batik.anim.timing.InstanceTime beginInstanceTime =
          null;
        org.apache.batik.anim.timing.InstanceTime nextBeginInstanceTime =
          null;
        for (;
             ;
             ) {
            float tempBegin;
            if (fixedBegin) {
                tempBegin =
                  beginAfter;
                while (beginIterator.
                         hasNext(
                           )) {
                    nextBeginInstanceTime =
                      (org.apache.batik.anim.timing.InstanceTime)
                        beginIterator.
                        next(
                          );
                    if (nextBeginInstanceTime.
                          getTime(
                            ) >
                          tempBegin) {
                        break;
                    }
                }
            }
            else {
                for (;
                     ;
                     ) {
                    if (!beginIterator.
                          hasNext(
                            )) {
                        return null;
                    }
                    beginInstanceTime =
                      (org.apache.batik.anim.timing.InstanceTime)
                        beginIterator.
                        next(
                          );
                    tempBegin =
                      beginInstanceTime.
                        getTime(
                          );
                    if (incl &&
                          tempBegin >=
                          beginAfter ||
                          !incl &&
                          tempBegin >
                          beginAfter) {
                        if (beginIterator.
                              hasNext(
                                )) {
                            nextBeginInstanceTime =
                              (org.apache.batik.anim.timing.InstanceTime)
                                beginIterator.
                                next(
                                  );
                            if (beginInstanceTime.
                                  getTime(
                                    ) ==
                                  nextBeginInstanceTime.
                                  getTime(
                                    )) {
                                nextBeginInstanceTime =
                                  null;
                                continue;
                            }
                        }
                        break;
                    }
                }
            }
            if (tempBegin >=
                  parentSimpleDur) {
                return null;
            }
            float tempEnd;
            if (endTimes.
                  length ==
                  0) {
                tempEnd =
                  tempBegin +
                    getActiveDur(
                      tempBegin,
                      INDEFINITE);
            }
            else {
                if (endInstanceTimes.
                      isEmpty(
                        )) {
                    tempEnd =
                      UNRESOLVED;
                }
                else {
                    tempEnd =
                      endInstanceTime.
                        getTime(
                          );
                    if (first &&
                          !firstEnd &&
                          tempEnd ==
                          tempBegin ||
                          !first &&
                          currentInterval !=
                          null &&
                          tempEnd ==
                          currentInterval.
                          getEnd(
                            ) &&
                          (incl &&
                             beginAfter >=
                             tempEnd ||
                             !incl &&
                             beginAfter >
                             tempEnd)) {
                        for (;
                             ;
                             ) {
                            if (!endIterator.
                                  hasNext(
                                    )) {
                                if (endHasEventConditions(
                                      )) {
                                    tempEnd =
                                      UNRESOLVED;
                                    break;
                                }
                                return null;
                            }
                            endInstanceTime =
                              (org.apache.batik.anim.timing.InstanceTime)
                                endIterator.
                                next(
                                  );
                            tempEnd =
                              endInstanceTime.
                                getTime(
                                  );
                            if (tempEnd >
                                  tempBegin) {
                                break;
                            }
                        }
                    }
                    firstEnd =
                      false;
                    for (;
                         ;
                         ) {
                        if (tempEnd >=
                              tempBegin) {
                            break;
                        }
                        if (!endIterator.
                              hasNext(
                                )) {
                            if (endHasEventConditions(
                                  )) {
                                tempEnd =
                                  UNRESOLVED;
                                break;
                            }
                            return null;
                        }
                        endInstanceTime =
                          (org.apache.batik.anim.timing.InstanceTime)
                            endIterator.
                            next(
                              );
                        tempEnd =
                          endInstanceTime.
                            getTime(
                              );
                    }
                }
                float ad =
                  getActiveDur(
                    tempBegin,
                    tempEnd);
                tempEnd =
                  tempBegin +
                    ad;
            }
            if (!first ||
                  tempEnd >
                  0 ||
                  tempBegin ==
                  0 &&
                  tempEnd ==
                  0 ||
                  isUnresolved(
                    tempEnd)) {
                if (restartMode ==
                      RESTART_ALWAYS &&
                      nextBeginInstanceTime !=
                      null) {
                    float nextBegin =
                      nextBeginInstanceTime.
                      getTime(
                        );
                    if (nextBegin <
                          tempEnd ||
                          isUnresolved(
                            tempEnd)) {
                        tempEnd =
                          nextBegin;
                        endInstanceTime =
                          nextBeginInstanceTime;
                    }
                }
                org.apache.batik.anim.timing.Interval i =
                  new org.apache.batik.anim.timing.Interval(
                  tempBegin,
                  tempEnd,
                  beginInstanceTime,
                  endInstanceTime);
                return i;
            }
            if (fixedBegin) {
                return null;
            }
            beginAfter =
              tempEnd;
        }
    }
    protected void reset(boolean clearCurrentBegin) {
        java.util.Iterator i =
          beginInstanceTimes.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                i.
                next(
                  );
            if (it.
                  getClearOnReset(
                    ) &&
                  (clearCurrentBegin ||
                     currentInterval ==
                     null ||
                     currentInterval.
                     getBeginInstanceTime(
                       ) !=
                     it)) {
                i.
                  remove(
                    );
            }
        }
        i =
          endInstanceTimes.
            iterator(
              );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.InstanceTime it =
              (org.apache.batik.anim.timing.InstanceTime)
                i.
                next(
                  );
            if (it.
                  getClearOnReset(
                    )) {
                i.
                  remove(
                    );
            }
        }
        if (isFrozen) {
            removeFill(
              );
        }
        currentRepeatIteration =
          0;
        lastRepeatTime =
          UNRESOLVED;
        isActive =
          false;
        isFrozen =
          false;
        lastSampleTime =
          UNRESOLVED;
    }
    public void parseAttributes(java.lang.String begin,
                                java.lang.String dur,
                                java.lang.String end,
                                java.lang.String min,
                                java.lang.String max,
                                java.lang.String repeatCount,
                                java.lang.String repeatDur,
                                java.lang.String fill,
                                java.lang.String restart) {
        if (!hasParsed) {
            parseBegin(
              begin);
            parseDur(
              dur);
            parseEnd(
              end);
            parseMin(
              min);
            parseMax(
              max);
            if (this.
                  min >
                  this.
                    max) {
                this.
                  min =
                  0.0F;
                this.
                  max =
                  INDEFINITE;
            }
            parseRepeatCount(
              repeatCount);
            parseRepeatDur(
              repeatDur);
            parseFill(
              fill);
            parseRestart(
              restart);
            hasParsed =
              true;
        }
    }
    protected void parseBegin(java.lang.String begin) {
        try {
            if (begin.
                  length(
                    ) ==
                  0) {
                begin =
                  SMIL_BEGIN_DEFAULT_VALUE;
            }
            beginTimes =
              org.apache.batik.anim.timing.TimingSpecifierListProducer.
                parseTimingSpecifierList(
                  TimedElement.this,
                  true,
                  begin,
                  root.
                    useSVG11AccessKeys,
                  root.
                    useSVG12AccessKeys);
        }
        catch (org.apache.batik.parser.ParseException ex) {
            throw createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    SMIL_BEGIN_ATTRIBUTE });
        }
    }
    protected void parseDur(java.lang.String dur) {
        if (dur.
              equals(
                SMIL_MEDIA_VALUE)) {
            durMedia =
              true;
            simpleDur =
              UNRESOLVED;
        }
        else {
            durMedia =
              false;
            if (dur.
                  length(
                    ) ==
                  0 ||
                  dur.
                  equals(
                    SMIL_INDEFINITE_VALUE)) {
                simpleDur =
                  INDEFINITE;
            }
            else {
                try {
                    simpleDur =
                      parseClockValue(
                        dur,
                        false);
                }
                catch (org.apache.batik.parser.ParseException e) {
                    throw createException(
                            "attribute.malformed",
                            new java.lang.Object[] { null,
                            SMIL_DUR_ATTRIBUTE });
                }
                if (simpleDur <
                      0) {
                    simpleDur =
                      INDEFINITE;
                }
            }
        }
    }
    protected float parseClockValue(java.lang.String s,
                                    boolean parseOffset)
          throws org.apache.batik.parser.ParseException {
        org.apache.batik.parser.ClockParser p =
          new org.apache.batik.parser.ClockParser(
          parseOffset);
        class Handler implements org.apache.batik.parser.ClockHandler {
            protected float
              v =
              0;
            public void clockValue(float newClockValue) {
                v =
                  newClockValue;
            }
            public Handler() {
                super(
                  );
            }
        }
        ;
        Handler h =
          new Handler(
          );
        p.
          setClockHandler(
            h);
        p.
          parse(
            s);
        return h.
                 v;
    }
    protected void parseEnd(java.lang.String end) {
        try {
            endTimes =
              org.apache.batik.anim.timing.TimingSpecifierListProducer.
                parseTimingSpecifierList(
                  TimedElement.this,
                  false,
                  end,
                  root.
                    useSVG11AccessKeys,
                  root.
                    useSVG12AccessKeys);
        }
        catch (org.apache.batik.parser.ParseException ex) {
            throw createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    SMIL_END_ATTRIBUTE });
        }
    }
    protected void parseMin(java.lang.String min) {
        if (min.
              equals(
                SMIL_MEDIA_VALUE)) {
            this.
              min =
              0;
            minMedia =
              true;
        }
        else {
            minMedia =
              false;
            if (min.
                  length(
                    ) ==
                  0) {
                this.
                  min =
                  0;
            }
            else {
                try {
                    this.
                      min =
                      parseClockValue(
                        min,
                        false);
                }
                catch (org.apache.batik.parser.ParseException ex) {
                    this.
                      min =
                      0;
                }
                if (this.
                      min <
                      0) {
                    this.
                      min =
                      0;
                }
            }
        }
    }
    protected void parseMax(java.lang.String max) {
        if (max.
              equals(
                SMIL_MEDIA_VALUE)) {
            this.
              max =
              INDEFINITE;
            maxMedia =
              true;
        }
        else {
            maxMedia =
              false;
            if (max.
                  length(
                    ) ==
                  0 ||
                  max.
                  equals(
                    SMIL_INDEFINITE_VALUE)) {
                this.
                  max =
                  INDEFINITE;
            }
            else {
                try {
                    this.
                      max =
                      parseClockValue(
                        max,
                        false);
                }
                catch (org.apache.batik.parser.ParseException ex) {
                    this.
                      max =
                      INDEFINITE;
                }
                if (this.
                      max <
                      0) {
                    this.
                      max =
                      0;
                }
            }
        }
    }
    protected void parseRepeatCount(java.lang.String repeatCount) {
        if (repeatCount.
              length(
                ) ==
              0) {
            this.
              repeatCount =
              UNRESOLVED;
        }
        else
            if (repeatCount.
                  equals(
                    SMIL_INDEFINITE_VALUE)) {
                this.
                  repeatCount =
                  INDEFINITE;
            }
            else {
                try {
                    this.
                      repeatCount =
                      java.lang.Float.
                        parseFloat(
                          repeatCount);
                    if (this.
                          repeatCount >
                          0) {
                        return;
                    }
                }
                catch (java.lang.NumberFormatException ex) {
                    throw createException(
                            "attribute.malformed",
                            new java.lang.Object[] { null,
                            SMIL_REPEAT_COUNT_ATTRIBUTE });
                }
            }
    }
    protected void parseRepeatDur(java.lang.String repeatDur) {
        try {
            if (repeatDur.
                  length(
                    ) ==
                  0) {
                this.
                  repeatDur =
                  UNRESOLVED;
            }
            else
                if (repeatDur.
                      equals(
                        SMIL_INDEFINITE_VALUE)) {
                    this.
                      repeatDur =
                      INDEFINITE;
                }
                else {
                    this.
                      repeatDur =
                      parseClockValue(
                        repeatDur,
                        false);
                }
        }
        catch (org.apache.batik.parser.ParseException ex) {
            throw createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    SMIL_REPEAT_DUR_ATTRIBUTE });
        }
    }
    protected void parseFill(java.lang.String fill) {
        if (fill.
              length(
                ) ==
              0 ||
              fill.
              equals(
                SMIL_REMOVE_VALUE)) {
            fillMode =
              FILL_REMOVE;
        }
        else
            if (fill.
                  equals(
                    SMIL_FREEZE_VALUE)) {
                fillMode =
                  FILL_FREEZE;
            }
            else {
                throw createException(
                        "attribute.malformed",
                        new java.lang.Object[] { null,
                        SMIL_FILL_ATTRIBUTE });
            }
    }
    protected void parseRestart(java.lang.String restart) {
        if (restart.
              length(
                ) ==
              0 ||
              restart.
              equals(
                SMIL_ALWAYS_VALUE)) {
            restartMode =
              RESTART_ALWAYS;
        }
        else
            if (restart.
                  equals(
                    SMIL_WHEN_NOT_ACTIVE_VALUE)) {
                restartMode =
                  RESTART_WHEN_NOT_ACTIVE;
            }
            else
                if (restart.
                      equals(
                        SMIL_NEVER_VALUE)) {
                    restartMode =
                      RESTART_NEVER;
                }
                else {
                    throw createException(
                            "attribute.malformed",
                            new java.lang.Object[] { null,
                            SMIL_RESTART_ATTRIBUTE });
                }
    }
    public void initialize() { for (int i =
                                      0; i <
                                           beginTimes.
                                             length;
                                    i++) {
                                   beginTimes[i].
                                     initialize(
                                       );
                               }
                               for (int i =
                                      0; i <
                                           endTimes.
                                             length;
                                    i++) {
                                   endTimes[i].
                                     initialize(
                                       );
                               } }
    public void deinitialize() { for (int i =
                                        0;
                                      i <
                                        beginTimes.
                                          length;
                                      i++) {
                                     beginTimes[i].
                                       deinitialize(
                                         );
                                 }
                                 for (int i =
                                        0;
                                      i <
                                        endTimes.
                                          length;
                                      i++) {
                                     endTimes[i].
                                       deinitialize(
                                         );
                                 } }
    public void beginElement() { beginElement(
                                   0); }
    public void beginElement(float offset) {
        float t =
          root.
          convertWallclockTime(
            java.util.Calendar.
              getInstance(
                ));
        org.apache.batik.anim.timing.InstanceTime it =
          new org.apache.batik.anim.timing.InstanceTime(
          null,
          t +
            offset,
          true);
        addInstanceTime(
          it,
          true);
    }
    public void endElement() { endElement(
                                 0); }
    public void endElement(float offset) {
        float t =
          root.
          convertWallclockTime(
            java.util.Calendar.
              getInstance(
                ));
        org.apache.batik.anim.timing.InstanceTime it =
          new org.apache.batik.anim.timing.InstanceTime(
          null,
          t +
            offset,
          true);
        addInstanceTime(
          it,
          false);
    }
    public float getLastSampleTime() { return lastSampleTime;
    }
    public float getCurrentBeginTime() { float begin;
                                         if (currentInterval ==
                                               null ||
                                               (begin =
                                                  currentInterval.
                                                    getBegin(
                                                      )) <
                                               lastSampleTime) {
                                             return java.lang.Float.
                                                      NaN;
                                         }
                                         return begin;
    }
    public boolean canBegin() { return currentInterval ==
                                  null ||
                                  isActive &&
                                  restartMode !=
                                  RESTART_NEVER;
    }
    public boolean canEnd() { return isActive;
    }
    public float getHyperlinkBeginTime() {
        if (isActive) {
            return currentInterval.
              getBegin(
                );
        }
        if (!beginInstanceTimes.
              isEmpty(
                )) {
            return ((org.apache.batik.anim.timing.InstanceTime)
                      beginInstanceTimes.
                      get(
                        0)).
              getTime(
                );
        }
        return java.lang.Float.
                 NaN;
    }
    protected void fireTimeEvent(java.lang.String eventType,
                                 float time,
                                 int detail) {
        java.util.Calendar t =
          (java.util.Calendar)
            root.
            getDocumentBeginTime(
              ).
            clone(
              );
        t.
          add(
            java.util.Calendar.
              MILLISECOND,
            (int)
              java.lang.Math.
              round(
                time *
                  1000.0));
        fireTimeEvent(
          eventType,
          t,
          detail);
    }
    void eventOccurred(org.apache.batik.anim.timing.TimingSpecifier t,
                       org.w3c.dom.events.Event e) {
        java.util.Set ts =
          (java.util.HashSet)
            handledEvents.
            get(
              e);
        if (ts ==
              null) {
            ts =
              new java.util.HashSet(
                );
            handledEvents.
              put(
                e,
                ts);
        }
        ts.
          add(
            t);
        root.
          currentIntervalWillUpdate(
            );
    }
    protected abstract void fireTimeEvent(java.lang.String eventType,
                                          java.util.Calendar time,
                                          int detail);
    protected abstract void toActive(float begin);
    protected abstract void toInactive(boolean stillActive,
                                       boolean isFrozen);
    protected abstract void removeFill();
    protected abstract void sampledAt(float simpleTime,
                                      float simpleDur,
                                      int repeatIteration);
    protected abstract void sampledLastValue(int repeatIteration);
    protected abstract org.apache.batik.anim.timing.TimedElement getTimedElementById(java.lang.String id);
    protected abstract org.w3c.dom.events.EventTarget getEventTargetById(java.lang.String id);
    protected abstract org.w3c.dom.events.EventTarget getRootEventTarget();
    public abstract org.w3c.dom.Element getElement();
    protected abstract org.w3c.dom.events.EventTarget getAnimationEventTarget();
    public abstract boolean isBefore(org.apache.batik.anim.timing.TimedElement other);
    protected abstract boolean isConstantAnimation();
    public org.apache.batik.anim.AnimationException createException(java.lang.String code,
                                                                    java.lang.Object[] params) {
        org.w3c.dom.Element e =
          getElement(
            );
        if (e !=
              null) {
            params[0] =
              e.
                getNodeName(
                  );
        }
        return new org.apache.batik.anim.AnimationException(
          this,
          code,
          params);
    }
    protected static final java.lang.String
      RESOURCES =
      "org.apache.batik.anim.resources.Messages";
    protected static org.apache.batik.i18n.LocalizableSupport
      localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      RESOURCES,
      org.apache.batik.anim.timing.TimedElement.class.
        getClassLoader(
          ));
    public static void setLocale(java.util.Locale l) {
        localizableSupport.
          setLocale(
            l);
    }
    public static java.util.Locale getLocale() {
        return localizableSupport.
          getLocale(
            );
    }
    public static java.lang.String formatMessage(java.lang.String key,
                                                 java.lang.Object[] args)
          throws java.util.MissingResourceException {
        return localizableSupport.
          formatMessage(
            key,
            args);
    }
    public static java.lang.String toString(float time) {
        if (java.lang.Float.
              isNaN(
                time)) {
            return "UNRESOLVED";
        }
        else
            if (time ==
                  java.lang.Float.
                    POSITIVE_INFINITY) {
                return "INDEFINITE";
            }
            else {
                return java.lang.Float.
                  toString(
                    time);
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jnB4ll5WtFOV92zjAqhi81HnAqAnBbAn");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("TxlVshSlVPFp4cCDCqoewuCrfNRmf8vUyq0tkXRTOvJ3U1nUfq0I1OJBTqyj" +
       "8VNBxE9PGbWyFPNR+yMFtccw+D70RIBa1odYq5nw085sjay3x6NadD5WTDqf" +
       "FeCfPWV0ylJUsKU4QTeAJ+gGnuZM4gPPNorwzlMWT88UgacZeA9Hky8JVC95" +
       "5anOjacJihQVXPxWce93GLwOTSlanK1G4nnTdkvLqa3Hi2Ve2MK+LkC+fsrM" +
       "S5aighrFlGYApzQDb1MyBR8EAs/G3yoqtbG8Z+UWamM4nycOFAnmHEdSsI3J" +
       "UpS6tsDDmFmwRM5YMIjRPmDHCq7U+wyTP2NtUVSMKU88HpGN0sVScVC1yuzN" +
       "nmQpKhioUtybgMFYfC44876sjFllExUcVwSi8NhYsgTgiLfeBSWv9mNEYeAy" +
       "+yUTdaC27w9jF78rTrw/Kr6zz1Xh7wVLJBKSk8wZezUKZnE/ZvA03NNr6hq1" +
       "9pKl85IcK2NV6iwBVgLTilAC7HGaRYSUjuJp8m+vtdnt6VBpiu61ObsM+BFk" +
       "eOILe5tMUPFsexBfFBhcgsMMnXKRzVl952BdEXhjT97MAXTjBcrxp4w3WYoK" +
       "ChRzlUGcqwxeBPT02+gJnmPRc3Gx6IGOSOlkAWbyKaNHlqKiviPKWYwM56yk" +
       "w/jm2E7ziiaTMGboEMc8Ze0FDXZigBOY7GWmVJwAZfkWxmsxJjAZr7MBfY1g" +
       "oeaU8SpLUdr48om3oGKCMhjGYD2beMscVGWn6JTMTQ5TMs4+ssPXZU7Neak5" +
       "fxF3+NC+itFT9q17kb/LJf2y7HEhMrovFYvZX+ho+12aMPW+KKN2HAur2Nvr" +
       "gpsomaEacFJSyn+g6sFruFCckkmuQpQE8MsedzP4Q2dcSoLs2x6PQkfaigfZ" +
       "8h/2KFsoKYEo+JMRF5w9zM1+up1eLBUyKV+pZETsb8DFs2fZG+fTZ+6m2sUR" +
       "t4f3Xdb2iXc+8kX+Bt5wTNu2DVMZGyKj+MuAWaIlOcfl2lNLp1W6esF744+M" +
       "mZc+G6uKK2xZ/XTL/HAayJdAc5jmeD1tsjbzltqX9l/46E93lz7jJ771xKdB" +
       "V2h97utBhxMpk8xcH8p9P2KXZrL35q5YcOfWixf3vf1K+j2cvuzXrjrj94Sf" +
       "u2/Ds7dO3V/jJ2NbSDAaj+jD7L2lq7bGO/TwkNlNyqPJpmFQEVKJarGsly+O" +
       "R8vVsEYxXgSd5Zmr+P5mcGe5753Mfet1WczYopsrjRRf7ywPkbHWFV4yjpfR" +
       "pBIJh4B1RRQlhr0YXDGMpQG21xNqTSTSr+UkExOs8obdO1donjewn/jrxv8H" +
       "2oA0O42CAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gwHDdlOzRCWtgTSbuPKU7g4FK0V7DTfv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("D1QK5btl0va7qMiYNbUrsLyvwKJDjFp81Si1yLbZdJPqQiWVVbk20gN8ZAVJ" +
       "O+4gtGawlLkSemg16QFPQEDQKEXjMK9U4WjaqlSxFp/aHWBy2MoIpeZDlvcc" +
       "jpuOK7DaRoqzKHTD5RSnOQTpwa4JI+J8yZWSharCsOaVShwokua06q8aWYcj" +
       "qK1ilAs6EEmIVQqbCRw2THmH1RZp3ckXF6odc7C0cOA4qJvAsR/mG0qhWsGJ" +
       "Ckc1RaGFQLXBvCPUfLftkGk7aYcO0XXKckWoKKtOuZKWBVL0UW+waIpab+q2" +
       "oBBpAP0NVSMkylIs5Iv4zK8lDJ5wVWMyW9QJVgFO4MBsBM2Bg1UX5XpfGRXb" +
       "yZgmRQWel3k86DQEqS0hiSAzRbehUCWIXqqF7oxKB7NmqrZkjs+v6GLYKoY+" +
       "Ek6FNEAqcF2RBwVNXNSbXduoK/OalYqIBqVeG52snFJzLs8HygLYsmhOYZVq" +
       "kW6GpVWxVUnN4SBqlpNqjyojwG2QcAKbpb0UN/srYyRY9QpMcZ2ik7aN4qzk" +
       "xVTJH6u2iE/CYXfcJBa1OWWWrHA6QNWeYOiUE8U4uQjgcqs8QsgxYRCF8bA+" +
       "0bUonkmFEHXLWIKyREeC41E+0Dp+wxICWZ6l1MCAkVoFb5eaXoUs1PrWcDwZ" +
       "kXi7wM1FgyaiQAA2JGkpvQloKihknKYaVGfyBTeBpBlZgWiWU+pj0ZxzmOXN" +
       "ulJvNMuzBa1dzPNSkWgp/QJEmnR5zrSNrtYUKoOhLNItZBJ1jWbHJ9CuqFrU" +
       "ROz2GdPul/KgbKFU3DF7iVkNggrc8hVB6ei9wnKiVBdLm2GGuEibQcVo5VO8" +
       "y40nrN1K+n4+DQdtPjFGoZdGc9KcuG2IFiYjqzGhVshqZi34wGbnlNAnkAno" +
       "zyZzJS8QSDhKbV4p+VhXTSAMGs2bET4XyzTh+MB14AjCtkqTuTyeUjOJwSWp" +
       "QwbjLjYesVKvi3lFkx2PK+mi63WRqqJ4M1mxjLwravyIFXrs0M0Xe0lXcxHQ" +
       "M3I50lcGbImRgx7DAAuKN1NvFSEpDNcdo9IhGytq2RHaY47p4TZrjey8pTuT" +
       "Sr1ouXYfHXMq6XbLjEjNMN7LdEL6s2nYmfRwdBqoVNCtTMSOpxc6DKi3eMiX" +
       "m0RDHZYYRhkDB1xB5mHVH3qxPffnrZXYVfyQiBb5uBOb1HCCQCuIDChE5yds" +
       "j7cJIRo0Sy7jF5cOBy2CPKpoKtUcKFShX2DnZsxhLp9WJ5DTm4znKjJqKxNQ" +
       "eb0mWSOxVmlY6CpZvuBsGk+lvNrQ6+W0yUmMjxVrneIQHreCdD6TXSqCJpBI" +
       "LgXQwFBiZJUUeICV4mAxmKMr11+G6koWxoHcJVY1QUALPmXAYWnJBOogrlN4" +
       "qaUIVki4tlQzVggMLzhVmsoa0g3zfbphCx08pIvNuGlx8qJLTCGpacBybOPL" +
       "tA6LULU355azELTbXI9rqYNoBWHhCsEW+fysglQrvbZXckgYLXdIvd5pEqLR" +
       "64A+eJcf0aROhZFFUwQ5LLYG4tKgEW6g10pjpqzIdsOpM11zxflzpqG0R8tU" +
       "keW8Q/l533RdzOguS1OUgKdkgE2hZuKO2j6JFiutVseniWlfB51Arwi6i3E1" +
       "FiozeK42BLjNTCsDFuYUX2EmHb04ttJmwRNNho3mSH1UCvi2WWIQfmHQtaWl" +
       "8ktTJkvd5XjMDgdY2oRi1K+pMwhr0emgUIrSvsMxcCdqtBOhQrdKTWVOKkzV" +
       "MJkubIZMCYl1Gh4YEwS2YSy1y6SWlSlXIRlzWaBXYxtSSgu+7qbIoAGv1ELF" +
       "rHKFrrSui8tB0zD9McEo5LzDLLi21CmivJDCXkknneEIGcdSLcxr4KCrCr3G" +
       "aIYFQ0sqT+Res+TxSj9F2j253AZdgdhifHG6EqVGB2Xzqqk6jG/iwgx0sMvj" +
       "6sgh6rZorcoj4M30REmO8go/kqpzS5CE2sCJ+P6q1LI9lVdI06qIyHjqF6YV" +
       "3JfZBcYkkTeyKmTaKpOjQRHj7TGQZYEJVOR3KAYq0bOZH+cHwLGL0nlVt722" +
       "DqXLeY3Ky9KkyLt9V8U7caVI4qAP6tX5SlGrp2MVCQxwi9ReDGvNQmGiiqpT" +
       "m0xYFPJGwaIfVgg/rOTzgltMOKKdNxJ50OCsCZ00RCgmRY5PK/0xZALXxCOr" +
       "dADhKYrPpzNvaedZQ13W0iR2C15Y5kmHmDrShJ3Q3ZlQrk2CZGE3msZwUTHQ" +
       "gZgOF3qVcLE53eSTiGvk6WoXavQpCS6mjcTp9SK2ROjA6ZYLgu1WiGXUGPNq" +
       "MWxjST4V8stlKNQ1yJ0siowi1GrqMs+V8rMiihZaVmRCPqqGxQnlJx3IGuFl" +
       "IQiKGmvwcIQJtiHMtG7ei2tcF++SoR+Hc6sPWUhUhaeTRsOy23XVkXB4jo2E" +
       "NkyDEj7XJBzx2LYxRXGlT5fbkOWXnUUqtZKI5YcTtgk8jUHI6RLUqOsoDzWE" +
       "vkBTDQRqh8uY1Sc6Pa/LqxZnq4OCvXLjmUzrK8oFDqzQcx0WqXXksT6MgKGS" +
       "Gxb4n+8Ma5P+sMjhHQYrVNsoaGd0xq2qGI/D4dLjo1a1Pe3NCbTjWVODK1qS" +
       "aRBdpo/Vpi0qJDXOknCtz3WxXqGzJBiOGiGOCOtlPqEFayBN43lz6TdijxD6" +
       "oaiX0VKjU+Y7Wup0ZprjW57ZNwXfaTgxPx226BI59mY+Q1QSuFjDi5OZHyBk" +
       "icKg6dBEO0MOBTmqNyiTMcUgcOcy8PPFSbswSszJIoIboUcMtRFVjFuVUTpu" +
       "6omQnxp4lZzgpCGaEIf4Rcrt96vtCctzNhMpeksZGyTqT+BBMUK6CqLJy8QQ" +
       "VIkaVUUzmiTDCUx2CuJEa9oBn5TVCeZBjqg35ClstufIEJIWmNQke5OS55fm" +
       "HVNjCM8hpVKemCzwyazYnRtJdYXNkH6qjlY2q1CYTiSatpwD97fXaHHQoAIh" +
       "hCO2O0oJGw6MWa8aFmfduDqAJtXWNJwCT7Vgw6txbUnbuM+pHc7zV7w09Fm5" +
       "QbEu1C0maTyMpWk66ibFJm8xIWJCLu624H4Z78w8k3enPktZmF7OJz2d1Fxr" +
       "XokGnXKvWpuswpmP9mUclGK8iqQk09JaKwzByZKi13ArsWo4P2tNuVDMx35v" +
       "yVJ410Er1AyN7GW1woH4Smvl1gJw/YlejYxGMyCjFVKFeobENasQZTXrJS7U" +
       "6KjF1EA2JLLMNFFEb9fnSWNZL5eLIVUe0/057vbyEKe5C3NomvPhYL5C6olO" +
       "lCoda9Ce8fWGlY+5aiEZdxl6CA3dxnToqqLS7Dhe1G8XJnI0HFRsvUzL00Gr" +
       "3BkpKz0vVSJJ88ZQ0m3NhKGGkzFPJ21G9vAwniis0KXKbNtWh/KcIgarhuU5" +
       "so0iy7DN2WXVNmsc2RzieT/BS77LqIKIlQfJYlGSVjMSGuaJoECu+qEFzBcz" +
       "xFbEAp8Sw9XEWLTYlj0vgVrQCzlyBOqVwpZwTVMTFR3YrVUjLxfmlGyN7eW8" +
       "pzZYUR2naMHl6zzPDniz041DtmrxBl7gp6YYNasNV4JMmagiuMj2/bJItuVA" +
       "W4UNurhSm+EU6nAhvuiUVEcgOv0Z2nYaJDaKVkLS9cnOeGC1O2N6yTbQOE/Q" +
       "yXAIHO9VEVu1m3zLScYYTa7yzSXoxjswLLUsnOErro53BHpk9xu1kWWNOnyr" +
       "RofIclrA2MlwaBYbVlqfYo12Oz+Uu9VSGYNhjBEAaB5Zphi+dJr+YDZg9U5r" +
       "Ncq3gV++nCfklI0xVuuz9KIionG1KPlDJ0/SqDJuaKtg0YuHHM6parvXBX2v" +
       "YWiwTQZ06WjeHyMuImDLmDJrE4IYNmw235zXQPPBNYcasZRBndZbOkx7bctr" +
       "S4MGFIAjNSRGygY5tKoyVoX7EA/qzqrGzGdtdGlXrXS5qGhs6Nbcnm0wXrXT" +
       "zOMhoVeDxjhtjUckcMcDFheTpeANS6HWs3qOXJiuJr0lx/pcYsWDeKwwvu0N" +
       "/H6Fd3C2kuJTJ536i3AxkGwqMEMXD4bUMFAqZYt0HaTSGSRDHmLt2PQl20sn" +
       "rcJCnljIHEUV0BHFU4rR8MTCRyuLJg03JrCBrJhlmgzwpWSh5WYLqzTbiwlt" +
       "tGolYjmstXFOTyCdiWhrGvcDUIerwlIe19J+ia3hIV6vlPNDx/EgLl3pCMQm" +
       "RLwC3gBEW1EeuKcjk6ZQFJl6kUASanPslomsPhCUzSXyTCF6q75R1HWyVmJA" +
       "6cGWRgkn9X51MagNzUHVcIcrQWwiq6rdH8rDRlNd6UKntmoOtJKLNAYLDJgC" +
       "I0HTBur0y2N3JSW8BmofOge2szqT+Tro4SbjtuwZzoB3JVSPER2xzKXZ1TGc" +
       "6MJs2tRGhjUhHTbrp2qj+rLaJgcL3Sq0lIY1mi1ZzrTnmF+fVnEuq2MrratW" +
       "66jXmw3RURW1UDlSYx0JNRwYZAPBdbPWSJecN6JHfS+GyA6xYsPuwK7iCMoX" +
       "2pV53dOgVbxsuiN0lDbDtJsiCj1C2yVOHtcHxWYiltCJOktNLmQWpjVpOaAO" +
       "+LQDL5gWyJSCS7TrTDhoxZipjCRqyQVkviUnWNdEmjzi53ug3ZAlurGISTW1" +
       "TF7jcWoU1HvDqtUPcAOGKWyqIYN5w06ioV1aABWL8wRfGSB+G06kbrdjoRpp" +
       "tqWR6HBVqSuYwyTSTZqjsWo+afcxHQ/0kgLykewWmjRfL3pJQqqLpODVBiPc" +
       "GVenZLmZH3g2KnI6Tcdhw1QrCtaZz9HYwpbNpD5oRAzL617eJOWxxHJ0tyBF" +
       "Dlojl5RlJgIo/VqXI7HeCB0UScSoNtXZ1LYqWDHoVcQ8XZiCLnxnNIPGuBPJ" +
       "smGhRbOCSjLcZNUKwjQCwFNq4HS7LQPfGhnnp0qzJRIGzyMaYejT0O+qEOWE" +
       "q0FojeF05PRYqMGSdrNZNfP4pCmDXrM8nxMEaFxoTR6nRmM1Y+VpoyTBZQuv" +
       "KCxt8C5XlcNGXcFndKvicgV2VFOQKcYowRxbtIdTLSnKeVqbi3Q7JIszvEyg" +
       "+khMC0lfbtTZWrPfl5aN4Qh2eFbTiAQxOxWFky2bmU4wn5xHkVCNAlo1Q7EL" +
       "XDx/3mAqK1rXRuV00JhPFzjSmzfqTKUBlcvcstsKl1xeTkLcxVoFhJZIajxj" +
       "5gJdaIY4DRqzUStAKVtDqQC28ZbFFnBRqI27vX7PjJGuW0nb04ZRcMSAa/U4" +
       "4EAbFWbSMLh+O0FIF1X64xG9AhZa7jamUZLqC2Kk47XJjGi3NL6P5IHHuGgM" +
       "Cbzm0pgH3Epv4Pa7KgjKJO/zZUpqdvOlXk9pAL916jU4x13CfJfDKsK8S4tu" +
       "p0h4KNfvhkax2WeZFh6uRhSvVsR+S27jWKrMaqDjgQ+7MxdDbLs8jvD+qF5M" +
       "Z+jcMGuFtovOUReT0Ozd5QufOdsrCs9Yv15xdWqvc79YEV1GuKU9Ai2LPRrg" +
       "PiI3mo25pyZxI9B6jKPVFvxqno+sCcP1QXPKgyZZm+fJQr+DcfPVrDbqYctW" +
       "fUBI4xU+6DHQisZBGU+gZjXPkJhY8JTpvOwm+Vo5nImr0rLSA+5Jecw15xqu" +
       "NrTBeJRf2R0+7PLIkFPRDqQTbizQiD4Y9LwgSW16zNVqvC7KgorW29aq1hk1" +
       "gIckuv2ZKHdMYziaDJZjWa2XCCrpc6wtut0Cgbgup1gLai6W2mZxpBbpLvC6" +
       "GpAWBjRbFk3dCHCbmKJ+OmxKoMOKMbUWGsJEaeXNI4moCRA/Fh0acVdyH0dd" +
       "p91S2JAsdXifrURhs+ngTsLQ5SlNzpiB02w35lUeSlbcoNiL+BFLd/lare0T" +
       "vXw4YuVRo7CKU9DTGPpdwwS9h5Wk0/hUayBIrVoJZ7gNOsW8PEpYs9YzpqHO" +
       "6SalqRg7XtSdXmuqoitoxXOK2ChWk/oMr9YCLkjgblBJ08LEqCYjqoN1WauW" +
       "CGrKdwXg5AoLNCvBQcWYF+p+166VSblb7I0qZoKNdAq0Emij2iZEZsrys7jj" +
       "1xxoESluVBlhvhlXCn0ppCEMt9Q+SanliOYHeKguMQ3HDFkPadqddJl0ZNfL" +
       "RUxpTYwZV6/S6ISbYXKw9JGkNJ563YbBpDZPyPNkqWIDLl+E9I7rDBgZtNQV" +
       "kuizfdtCx9KqK/ba9rxrLsxBdzxN6HJlZSXwzCm2qqlpihxNSF6LlmuCmseb" +
       "E8HUsf60SoydUSdBBc0aL51w2ZmhQlClMW1a0D1V5GusT/FKgNQ8p+QR3QZt" +
       "zIhpsyipdCiPiLFb6XA0NyxzwIODwnAwEfhqTxWtsrbES1CvAZkRztXnhaol" +
       "wVRHK66q7ZZBBx7wZhfCBDI8qFAU6cEY6nZ7xTYaB8XeItD90HPElijjHXbl" +
       "QnolxIMYb8iW5cRDf5i5i6qSDpBhUZFZjwqLy8pgaGmgMGpCzYCLXTz0utOW" +
       "B3VoBi8n9ZQuQLFfUCmMX3VHkC+0uFCqNfGwqAkEpHECVHGKIc9EiFaaKFLR" +
       "nMhQzZpAWFROuF5cbI5ogVh1ZxAdo2ORtPuyZhftHuUXxpV1xwaBaEeQIaIS" +
       "d7vFpQBPOApuo+Kqo6ByeeaozUIUzqTUjuaTug0jlVa9ZKfVWadaLSy7CjYq" +
       "GvVqHGEG8JOt2lJu13zgEXQnQkCVyvPyVO5rY3OplRZaoQvNivIiTifBLJjV" +
       "EVaLi3AzrCr90giedYo9iW2i4gyaNatU0Z5XJaIPA3+yZ/dW80HHd/Bha9Tt" +
       "iAER2iuoz9QWo7A1XU50VikLTgANyo5MqOVquURralQYy+nU88NgxjBadZUM" +
       "LKk9xkfIauZrjI+RHQPBCgwztI0gP500CdofEsXCsjfnWI4NIN5qLfthzZOU" +
       "fkHx3JmauPAsWC5q7aKH5vtIsYGi6Gszo/u5s1nuB66z3I8Vzmq7lzteH3x5" +
       "lLtDlMIoEOXoYLKw9b97c0fm+Tv0ZuI65sOHPrx/MMo9et0Lhus3Z1mapK7O" +
       "zpnNyvP8k6ZtXM/I8/63vvt9Sv8Dhf1vTQZR7s7I819tqwvVPnRbdL3/K1dF" +
       "fv7+a6zf3Yr83aMvUx5o7Ph3WF++0fn63LGfl1/4sx3n/iIL/jjK3a6rVye/" +
       "+PGDtyj/5EZt6+HrHUFb58gjQMrbNmk3vzcX7b/sOPffsuDrUe5ugLb5GO7q" +
       "510HgDf8PPY0gHdvAe+++YD/++RzF7NbXfjWBpA1r/l+7QDw2+cAfGZ28FEg" +
       "60NbwIfOCvhjxwIemZpi9yyUh79wyhJ8Yc1+1w69ZHPYXbwc5e4VFeVo6gPN" +
       "XLztvJp5KYDcTi114bqppc6lmUy8px3APrwD9jlZ8ECUuz9QHW+h7uB95nl5" +
       "XwZE305FcOG6qQhuJu9jO3hfmgUvAC2MeYi0YYiuvnlv/xDwC88BvP68gAKy" +
       "+1tg/2YD5z5wAJzfAbxGgaLc00FpPvhaKIt59A3thWcqB/SvOi89AkD+zpb+" +
       "jbeS/nU76NEseA2oy5vifVUB2WHkAPaG32DeyIyDdvjC9gP1C9d9oH4j2Bua" +
       "8YvdHefoLMBBBl814/tTYRzwEefge052MLNV793yvfcMfAeTDuHHQl440MIP" +
       "rmnGO0inWcAAUjPk3WA7U/i6HByQsjcjJ7ffXl+47tvrp5aTh4rtDx6QyjtI" +
       "M9t78Q2bPN34Htfn6RPntccZ6fYzyAvXfQZ57gp6iNTbQTrPghnwdkFjHYfH" +
       "NDvWeTFfCCT+4hbzi7cS8wd2YL4xCxYgQ53YjkzfXh1DmpyX9LlA6Ce3pE/e" +
       "StK37SD90Sx4K+gROJup245A/tDNgPzWFvJbtxLyJ3dAvicL3plBistjIH/8" +
       "vJAvBuLcv0m7+T0/5GHxf27HuZ/Pgp+JcvcA00Nmn1rKZnS98fkH5yV8CSB7" +
       "9pbw2TeH8KAtuTBao/zyDswPZ8E/inLPcL3I1FY9NTn8pfEh0n98XtKXA8Ly" +
       "lrR8i0h/bQfpJ7LgV6LcMzekzNbPPxb2V88L+zwAOd3CTm9N7dw4fZ/eQfyb" +
       "WfCvotwd4XpWFjQ6Qvn/nIPyWdlBKJe71N6k3fze3Or5uR3nPp8F/zbKPQj8" +
       "2LYYrj/1bniuYl6dHPGQM/TbN6GWXtpm56Vbk53bAvxHO5D/fRZ8EVTVUM0m" +
       "xz+5qv7hOXDXQxPAy7301i3uW28O7t46wt46Y64Gh8rxn+8A/8ss+JNsUhPP" +
       "8eNIvWbCjQPs/3jenloJCHjXJu3m92ZaqC3nf93B+ddZ8J+j3GXg06tHu2b/" +
       "3zno1ktcwIBqOyX93tEB3afo0N+5jnDn");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "WwQt/ecP/dPv+cfv+w/Ztfz/HyupqHM3kwAA");
}
