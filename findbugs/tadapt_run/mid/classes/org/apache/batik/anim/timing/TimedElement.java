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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2S7RcY5SR5k0FDzoyNwy/n/WpejcfpB5j8jqHomiFysVlUkjmdz5u8lc0A8y" +
       "7xO53CfRcZFSR5k0kqn1Ssm8oh+KPiyyelii6DVKRWXSFMcsS6I4Heyl6LX9" +
       "UPSbIqtvShStUSoqk2aKLjeNTXrSS9Hl/fD3j4isHpEoWqdUVCYt/H2Lhp0x" +
       "mb+v74e6e0SGeyTqtijVlUmDutn2P9uautVt9akuzi49JjJ8TKJum1JdmTQl" +
       "I9m8gTX6seYPpnhPCGgb2Nql9uhXp2/fdkHp2cv59IH3bINjmdPCc5dXTN37" +
       "g6Q1dfBMLr6RKnxp17MpNji1NTlw8HuL7rro+t1ck2mS4aYd/+nPn3p556Yn" +
       "9vFnLziMpWSebAFf/qpBXIihmMlwYP7LiisPvffO6psszOVYSh3ZqYVy5yNt" +
       "9vg/0N2XfnngRp/Gczkc+wW5+yXG06M0Hpk0JcNhMJdjOpiY5lI46VPhC+B4" +
       "SmT5lERhqlRYJk1Jhejy4tNcc72WsEpjlnKix4rtApbxCWwmHE8L1Z6WANus" +
       "BCaTBmDoJC09a5IxL7dzm099L4TjBZHjCxJ9v6TUVyYNlpMy9fVxI5N2cBvY" +
       "6FJ4u0+Fr4LjiMjyiEThe5QKy6SBYOYnl4FvT8Zw8piZent+J02aPxOIYnB/" +
       "1gl4LqDDKA/2yRV81Sc/V8JxTOh3TMLPDiU/MmmKq5tjNjuY0n0ubf0+8vgM" +
       "HK+L/F6XaPuIUluZNCUT0t1GJhFblYppVK/O9QkYxd0f+k4/JkNOiNxPSHT/" +
       "nlJ3mTQlg7u1NG+VvDT9vk9NL4bjlMjrlETTx5WayqTBJrqhrU7osZr1shoz" +
       "QpW7XWOeytaYMrvG1GtMuQN9qir7fdIyDY53hWLvSmg5qKRFJk1xGRTrzkLT" +
       "4lWCz/SjWTktMjstUfV5paoyaVaC6SbTSGlduDzHS9uf9V1bnGXBgor8nUeN" +
       "fJynbYCSC72bYlMXK6Mr66GHqnXxvsZhjouF7ie3j2Lg+eR2vJW3hw5Qv/C5" +
       "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" +
       "b1EQsw2DjXx04/yGzNKNtTGreev7l2ds");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("IjcNmEjcBIY19UcF7KNFI1KWYiEi71UQeR8Gd0FfAIhkrXirZsKpk8fJst4V" +
       "j2qT95XikfeqgPpq0ciTpajgRrH2NIxrT8Nf57zhK5EOQvDOAzYrOwbMykS8" +
       "haOu4wLDcb+szPdiZZQiRQXyvYp7+zDYA80bWpOjbuF+sk4ryqt3A1+wykwH" +
       "W72TAtLJopmOLEUFEU8r7j2DwVOUjMVXF8Aj8e8ASu3nR8WxH5ydEpsHRPK2" +
       "Hui3/chSlLqk8B2Mg18o+DmMwSG2ldhSvdMw+VuYNiHPD5gQ3ACNjV3FQ8SI" +
       "6vmjP1uRpajA+6ri3usYHMV3CbPfuMmajIuWlwZMC24DSeaD8uJLVBHJ57YY" +
       "LRh4zO7IRF0YnWt32MWDYifq51LZTTkc+yPwL/ekUinJzsSMq5MKHn+LwQlc" +
       "FWnqGrXX+Vh5SbaHsKtnjgDj+80B881eCZhHSEkpT4H/+q2XXm+dSVP0rpe5" +
       "jPONg3CfBvZdh/CfFLyew+AMdtl1ykXW5fZM/2fALLG3B6YDlnKBqbxoLMlS" +
       "lAOOBBX3cMFu+O9ARpeDjPCfbTI+KQ4Z0BUoGSNUH1M0MmQpKmouYjrFoFeo" +
       "DWu6Y3+deDoN/e9msfFKzoq7CH6bLTIYJ5bwU4FU7MliewlkMTKkOCxOA6yT" +
       "BebJRWNRlqK0QeQTS5HJCruaisE4NrGU3SjGScj5/gnppWSYcwSEX54bl/fZ" +
       "X/6p2uj+XRWDxu5a9Wv+JQTrc7LD6sigzkwi4fwwmuO8JGXqnXFG5DAWjmDf" +
       "f4pcQMlE1cCMkhJ+gppHZnOhuZSM9hSiJIw/zrjzwY+541ISYb/OeBdDN9WO" +
       "B9nyE2eUhZSEIAqeXoq8hd/u5SY9wTmLzfYKL7jlclbE+e1I3OmRfZPZ2uUy" +
       "0yQ2lHxi13UNt569/FH+7cpoQtu0CVMZWkdK+Wc0WaKhvM0pnalZaZWsnPNx" +
       "+ZODZ1k70YzgCts2PsE2NnItbgSA5jDe9WHH9Mzs9x2P77nquaN3lbwSJIEb" +
       "SUCD7smN+Z/Z601lTDLlxjqvb4yt1kz2zcnFQ95Zc+zDE4GR1hft8KMRk1US" +
       "7dEHn3uzqTOV+maQDK4lkXgypveybwAu25hs1qPrzZxPlpV0GJlk9lsd5Wi7" +
       "GtYgxowgtCx7Fb99Cs4q/+tt+d+DHZIwNujmUkwdkylzfd8hk0o57zJm12Cw" +
       "qheZBrtqr6tPpazP1o1hzEP/Bk2NfalK+z+XtFtVeH0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "K3WkOOsXtVFZxyfVvKDNaaI+pKXFkuj5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AoHHcWgpINOjI/r47nlzG+hgj9jqg7jZ");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "bMGy1T976J9+3z95/7/LrhX8f9QRVYX/kgAA");
}
