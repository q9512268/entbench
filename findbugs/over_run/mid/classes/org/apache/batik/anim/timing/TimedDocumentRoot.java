package org.apache.batik.anim.timing;
public abstract class TimedDocumentRoot extends org.apache.batik.anim.timing.TimeContainer {
    protected java.util.Calendar documentBeginTime;
    protected boolean useSVG11AccessKeys;
    protected boolean useSVG12AccessKeys;
    protected org.apache.batik.util.DoublyIndexedSet propagationFlags = new org.apache.batik.util.DoublyIndexedSet(
      );
    protected java.util.LinkedList listeners = new java.util.LinkedList(
      );
    protected boolean isSampling;
    protected boolean isHyperlinking;
    public TimedDocumentRoot(boolean useSVG11AccessKeys, boolean useSVG12AccessKeys) {
        super(
          );
        root =
          this;
        this.
          useSVG11AccessKeys =
          useSVG11AccessKeys;
        this.
          useSVG12AccessKeys =
          useSVG12AccessKeys;
    }
    protected float getImplicitDur() { return INDEFINITE;
    }
    public float getDefaultBegin(org.apache.batik.anim.timing.TimedElement child) {
        return 0.0F;
    }
    public float getCurrentTime() { return lastSampleTime;
    }
    public boolean isSampling() { return isSampling;
    }
    public boolean isHyperlinking() { return isHyperlinking;
    }
    public float seekTo(float time, boolean hyperlinking) {
        isSampling =
          true;
        lastSampleTime =
          time;
        isHyperlinking =
          hyperlinking;
        propagationFlags.
          clear(
            );
        float mint =
          java.lang.Float.
            POSITIVE_INFINITY;
        org.apache.batik.anim.timing.TimedElement[] es =
          getChildren(
            );
        for (int i =
               0;
             i <
               es.
                 length;
             i++) {
            float t =
              es[i].
              sampleAt(
                time,
                hyperlinking);
            if (t <
                  mint) {
                mint =
                  t;
            }
        }
        boolean needsUpdates;
        do  {
            needsUpdates =
              false;
            for (int i =
                   0;
                 i <
                   es.
                     length;
                 i++) {
                if (es[i].
                      shouldUpdateCurrentInterval) {
                    needsUpdates =
                      true;
                    float t =
                      es[i].
                      sampleAt(
                        time,
                        hyperlinking);
                    if (t <
                          mint) {
                        mint =
                          t;
                    }
                }
            }
        }while(needsUpdates); 
        isSampling =
          false;
        if (hyperlinking) {
            root.
              currentIntervalWillUpdate(
                );
        }
        return mint;
    }
    public void resetDocument(java.util.Calendar documentBeginTime) {
        if (documentBeginTime ==
              null) {
            this.
              documentBeginTime =
              java.util.Calendar.
                getInstance(
                  );
        }
        else {
            this.
              documentBeginTime =
              documentBeginTime;
        }
        reset(
          true);
    }
    public java.util.Calendar getDocumentBeginTime() {
        return documentBeginTime;
    }
    public float convertEpochTime(long t) { long begin =
                                              documentBeginTime.
                                              getTime(
                                                ).
                                              getTime(
                                                );
                                            return (t -
                                                      begin) /
                                              1000.0F;
    }
    public float convertWallclockTime(java.util.Calendar time) {
        long begin =
          documentBeginTime.
          getTime(
            ).
          getTime(
            );
        long t =
          time.
          getTime(
            ).
          getTime(
            );
        return (t -
                  begin) /
          1000.0F;
    }
    public void addTimegraphListener(org.apache.batik.anim.timing.TimegraphListener l) {
        listeners.
          add(
            l);
    }
    public void removeTimegraphListener(org.apache.batik.anim.timing.TimegraphListener l) {
        listeners.
          remove(
            l);
    }
    void fireElementAdded(org.apache.batik.anim.timing.TimedElement e) {
        java.util.Iterator i =
          listeners.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            ((org.apache.batik.anim.timing.TimegraphListener)
               i.
               next(
                 )).
              elementAdded(
                e);
        }
    }
    void fireElementRemoved(org.apache.batik.anim.timing.TimedElement e) {
        java.util.Iterator i =
          listeners.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            ((org.apache.batik.anim.timing.TimegraphListener)
               i.
               next(
                 )).
              elementRemoved(
                e);
        }
    }
    boolean shouldPropagate(org.apache.batik.anim.timing.Interval i,
                            org.apache.batik.anim.timing.TimingSpecifier ts,
                            boolean isBegin) {
        org.apache.batik.anim.timing.InstanceTime it =
          isBegin
          ? i.
          getBeginInstanceTime(
            )
          : i.
          getEndInstanceTime(
            );
        if (propagationFlags.
              contains(
                it,
                ts)) {
            return false;
        }
        propagationFlags.
          add(
            it,
            ts);
        return true;
    }
    protected void currentIntervalWillUpdate() {
        
    }
    protected abstract java.lang.String getEventNamespaceURI(java.lang.String eventName);
    protected abstract java.lang.String getEventType(java.lang.String eventName);
    protected abstract java.lang.String getRepeatEventName();
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "s++d1XLkNY1nIS/gPy3/Ade8wgeSMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T045UW3U0vEQjmkJi5jdQG3SG8tt8KK7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "L6byLz78L9/865/6VnkF9v8CIebIWxM+AAA=");
}
