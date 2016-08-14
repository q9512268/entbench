package org.apache.batik.dom.events;
public class EventSupport {
    protected org.apache.batik.dom.util.HashTable capturingListeners;
    protected org.apache.batik.dom.util.HashTable bubblingListeners;
    protected org.apache.batik.dom.AbstractNode node;
    public EventSupport(org.apache.batik.dom.AbstractNode n) { super();
                                                               node = n; }
    public void addEventListener(java.lang.String type, org.w3c.dom.events.EventListener listener,
                                 boolean useCapture) { addEventListenerNS(
                                                         null,
                                                         type,
                                                         listener,
                                                         useCapture,
                                                         null); }
    public void addEventListenerNS(java.lang.String namespaceURI,
                                   java.lang.String type,
                                   org.w3c.dom.events.EventListener listener,
                                   boolean useCapture,
                                   java.lang.Object group) { org.apache.batik.dom.util.HashTable listeners;
                                                             if (useCapture) {
                                                                 if (capturingListeners ==
                                                                       null) {
                                                                     capturingListeners =
                                                                       new org.apache.batik.dom.util.HashTable(
                                                                         );
                                                                 }
                                                                 listeners =
                                                                   capturingListeners;
                                                             }
                                                             else {
                                                                 if (bubblingListeners ==
                                                                       null) {
                                                                     bubblingListeners =
                                                                       new org.apache.batik.dom.util.HashTable(
                                                                         );
                                                                 }
                                                                 listeners =
                                                                   bubblingListeners;
                                                             }
                                                             org.apache.batik.dom.events.EventListenerList list =
                                                               (org.apache.batik.dom.events.EventListenerList)
                                                                 listeners.
                                                                 get(
                                                                   type);
                                                             if (list ==
                                                                   null) {
                                                                 list =
                                                                   new org.apache.batik.dom.events.EventListenerList(
                                                                     );
                                                                 listeners.
                                                                   put(
                                                                     type,
                                                                     list);
                                                             }
                                                             list.
                                                               addListener(
                                                                 namespaceURI,
                                                                 group,
                                                                 listener);
    }
    public void removeEventListener(java.lang.String type,
                                    org.w3c.dom.events.EventListener listener,
                                    boolean useCapture) {
        removeEventListenerNS(
          null,
          type,
          listener,
          useCapture);
    }
    public void removeEventListenerNS(java.lang.String namespaceURI,
                                      java.lang.String type,
                                      org.w3c.dom.events.EventListener listener,
                                      boolean useCapture) {
        org.apache.batik.dom.util.HashTable listeners;
        if (useCapture) {
            listeners =
              capturingListeners;
        }
        else {
            listeners =
              bubblingListeners;
        }
        if (listeners ==
              null) {
            return;
        }
        org.apache.batik.dom.events.EventListenerList list =
          (org.apache.batik.dom.events.EventListenerList)
            listeners.
            get(
              type);
        if (list !=
              null) {
            list.
              removeListener(
                namespaceURI,
                listener);
            if (list.
                  size(
                    ) ==
                  0) {
                listeners.
                  remove(
                    type);
            }
        }
    }
    public void moveEventListeners(org.apache.batik.dom.events.EventSupport other) {
        other.
          capturingListeners =
          capturingListeners;
        other.
          bubblingListeners =
          bubblingListeners;
        capturingListeners =
          null;
        bubblingListeners =
          null;
    }
    public boolean dispatchEvent(org.apache.batik.dom.events.NodeEventTarget target,
                                 org.w3c.dom.events.Event evt)
          throws org.w3c.dom.events.EventException {
        if (evt ==
              null) {
            return false;
        }
        if (!(evt instanceof org.apache.batik.dom.events.AbstractEvent)) {
            throw createEventException(
                    org.w3c.dom.DOMException.
                      NOT_SUPPORTED_ERR,
                    "unsupported.event",
                    new java.lang.Object[] {  });
        }
        org.apache.batik.dom.events.AbstractEvent e =
          (org.apache.batik.dom.events.AbstractEvent)
            evt;
        java.lang.String type =
          e.
          getType(
            );
        if (type ==
              null ||
              type.
              length(
                ) ==
              0) {
            throw createEventException(
                    org.w3c.dom.events.EventException.
                      UNSPECIFIED_EVENT_TYPE_ERR,
                    "unspecified.event",
                    new java.lang.Object[] {  });
        }
        e.
          setTarget(
            target);
        e.
          stopPropagation(
            false);
        e.
          stopImmediatePropagation(
            false);
        e.
          preventDefault(
            false);
        org.apache.batik.dom.events.NodeEventTarget[] ancestors =
          getAncestors(
            target);
        e.
          setEventPhase(
            org.w3c.dom.events.Event.
              CAPTURING_PHASE);
        java.util.HashSet stoppedGroups =
          new java.util.HashSet(
          );
        java.util.HashSet toBeStoppedGroups =
          new java.util.HashSet(
          );
        for (int i =
               0;
             i <
               ancestors.
                 length;
             i++) {
            org.apache.batik.dom.events.NodeEventTarget node =
              ancestors[i];
            e.
              setCurrentTarget(
                node);
            fireEventListeners(
              node,
              e,
              true,
              stoppedGroups,
              toBeStoppedGroups);
            stoppedGroups.
              addAll(
                toBeStoppedGroups);
            toBeStoppedGroups.
              clear(
                );
        }
        e.
          setEventPhase(
            org.w3c.dom.events.Event.
              AT_TARGET);
        e.
          setCurrentTarget(
            target);
        fireEventListeners(
          target,
          e,
          false,
          stoppedGroups,
          toBeStoppedGroups);
        stoppedGroups.
          addAll(
            toBeStoppedGroups);
        toBeStoppedGroups.
          clear(
            );
        if (e.
              getBubbles(
                )) {
            e.
              setEventPhase(
                org.w3c.dom.events.Event.
                  BUBBLING_PHASE);
            for (int i =
                   ancestors.
                     length -
                   1;
                 i >=
                   0;
                 i--) {
                org.apache.batik.dom.events.NodeEventTarget node =
                  ancestors[i];
                e.
                  setCurrentTarget(
                    node);
                fireEventListeners(
                  node,
                  e,
                  false,
                  stoppedGroups,
                  toBeStoppedGroups);
                stoppedGroups.
                  addAll(
                    toBeStoppedGroups);
                toBeStoppedGroups.
                  clear(
                    );
            }
        }
        if (!e.
              getDefaultPrevented(
                )) {
            runDefaultActions(
              e);
        }
        return e.
          getDefaultPrevented(
            );
    }
    protected void runDefaultActions(org.apache.batik.dom.events.AbstractEvent e) {
        java.util.List runables =
          e.
          getDefaultActions(
            );
        if (runables !=
              null) {
            java.util.Iterator i =
              runables.
              iterator(
                );
            while (i.
                     hasNext(
                       )) {
                java.lang.Runnable r =
                  (java.lang.Runnable)
                    i.
                    next(
                      );
                r.
                  run(
                    );
            }
        }
    }
    protected void fireEventListeners(org.apache.batik.dom.events.NodeEventTarget node,
                                      org.apache.batik.dom.events.AbstractEvent e,
                                      org.apache.batik.dom.events.EventListenerList.Entry[] listeners,
                                      java.util.HashSet stoppedGroups,
                                      java.util.HashSet toBeStoppedGroups) {
        if (listeners ==
              null) {
            return;
        }
        java.lang.String eventNS =
          e.
          getNamespaceURI(
            );
        for (int i =
               0;
             i <
               listeners.
                 length;
             i++) {
            try {
                java.lang.String listenerNS =
                  listeners[i].
                  getNamespaceURI(
                    );
                if (listenerNS !=
                      null &&
                      eventNS !=
                      null &&
                      !listenerNS.
                      equals(
                        eventNS)) {
                    continue;
                }
                java.lang.Object group =
                  listeners[i].
                  getGroup(
                    );
                if (stoppedGroups ==
                      null ||
                      !stoppedGroups.
                      contains(
                        group)) {
                    listeners[i].
                      getListener(
                        ).
                      handleEvent(
                        e);
                    if (e.
                          getStopImmediatePropagation(
                            )) {
                        if (stoppedGroups !=
                              null) {
                            stoppedGroups.
                              add(
                                group);
                        }
                        e.
                          stopImmediatePropagation(
                            false);
                    }
                    else
                        if (e.
                              getStopPropagation(
                                )) {
                            if (toBeStoppedGroups !=
                                  null) {
                                toBeStoppedGroups.
                                  add(
                                    group);
                            }
                            e.
                              stopPropagation(
                                false);
                        }
                }
            }
            catch (java.lang.ThreadDeath td) {
                throw td;
            }
            catch (java.lang.Throwable th) {
                th.
                  printStackTrace(
                    );
            }
        }
    }
    protected void fireEventListeners(org.apache.batik.dom.events.NodeEventTarget node,
                                      org.apache.batik.dom.events.AbstractEvent e,
                                      boolean useCapture,
                                      java.util.HashSet stoppedGroups,
                                      java.util.HashSet toBeStoppedGroups) {
        java.lang.String type =
          e.
          getType(
            );
        org.apache.batik.dom.events.EventSupport support =
          node.
          getEventSupport(
            );
        if (support ==
              null) {
            return;
        }
        org.apache.batik.dom.events.EventListenerList list =
          support.
          getEventListeners(
            type,
            useCapture);
        if (list ==
              null) {
            return;
        }
        org.apache.batik.dom.events.EventListenerList.Entry[] listeners =
          list.
          getEventListeners(
            );
        fireEventListeners(
          node,
          e,
          listeners,
          stoppedGroups,
          toBeStoppedGroups);
    }
    protected org.apache.batik.dom.events.NodeEventTarget[] getAncestors(org.apache.batik.dom.events.NodeEventTarget node) {
        node =
          node.
            getParentNodeEventTarget(
              );
        int nancestors =
          0;
        for (org.apache.batik.dom.events.NodeEventTarget n =
               node;
             n !=
               null;
             n =
               n.
                 getParentNodeEventTarget(
                   ),
               nancestors++) {
            
        }
        org.apache.batik.dom.events.NodeEventTarget[] ancestors =
          new org.apache.batik.dom.events.NodeEventTarget[nancestors];
        for (int i =
               nancestors -
               1;
             i >=
               0;
             --i,
               node =
                 node.
                   getParentNodeEventTarget(
                     )) {
            ancestors[i] =
              node;
        }
        return ancestors;
    }
    public boolean hasEventListenerNS(java.lang.String namespaceURI,
                                      java.lang.String type) {
        if (capturingListeners !=
              null) {
            org.apache.batik.dom.events.EventListenerList ell =
              (org.apache.batik.dom.events.EventListenerList)
                capturingListeners.
                get(
                  type);
            if (ell !=
                  null) {
                if (ell.
                      hasEventListener(
                        namespaceURI)) {
                    return true;
                }
            }
        }
        if (bubblingListeners !=
              null) {
            org.apache.batik.dom.events.EventListenerList ell =
              (org.apache.batik.dom.events.EventListenerList)
                capturingListeners.
                get(
                  type);
            if (ell !=
                  null) {
                return ell.
                  hasEventListener(
                    namespaceURI);
            }
        }
        return false;
    }
    public org.apache.batik.dom.events.EventListenerList getEventListeners(java.lang.String type,
                                                                           boolean useCapture) {
        org.apache.batik.dom.util.HashTable listeners =
          useCapture
          ? capturingListeners
          : bubblingListeners;
        if (listeners ==
              null) {
            return null;
        }
        return (org.apache.batik.dom.events.EventListenerList)
                 listeners.
                 get(
                   type);
    }
    protected org.w3c.dom.events.EventException createEventException(short code,
                                                                     java.lang.String key,
                                                                     java.lang.Object[] args) {
        try {
            org.apache.batik.dom.AbstractDocument doc =
              (org.apache.batik.dom.AbstractDocument)
                node.
                getOwnerDocument(
                  );
            return new org.w3c.dom.events.EventException(
              code,
              doc.
                formatMessage(
                  key,
                  args));
        }
        catch (java.lang.Exception e) {
            return new org.w3c.dom.events.EventException(
              code,
              key);
        }
    }
    protected void setTarget(org.apache.batik.dom.events.AbstractEvent e,
                             org.apache.batik.dom.events.NodeEventTarget target) {
        e.
          setTarget(
            target);
    }
    protected void stopPropagation(org.apache.batik.dom.events.AbstractEvent e,
                                   boolean b) {
        e.
          stopPropagation(
            b);
    }
    protected void stopImmediatePropagation(org.apache.batik.dom.events.AbstractEvent e,
                                            boolean b) {
        e.
          stopImmediatePropagation(
            b);
    }
    protected void preventDefault(org.apache.batik.dom.events.AbstractEvent e,
                                  boolean b) {
        e.
          preventDefault(
            b);
    }
    protected void setCurrentTarget(org.apache.batik.dom.events.AbstractEvent e,
                                    org.apache.batik.dom.events.NodeEventTarget target) {
        e.
          setCurrentTarget(
            target);
    }
    protected void setEventPhase(org.apache.batik.dom.events.AbstractEvent e,
                                 short phase) {
        e.
          setEventPhase(
            phase);
    }
    public static org.w3c.dom.events.Event getUltimateOriginalEvent(org.w3c.dom.events.Event evt) {
        org.apache.batik.dom.events.AbstractEvent e =
          (org.apache.batik.dom.events.AbstractEvent)
            evt;
        for (;
             ;
             ) {
            org.apache.batik.dom.events.AbstractEvent origEvt =
              (org.apache.batik.dom.events.AbstractEvent)
                e.
                getOriginalEvent(
                  );
            if (origEvt ==
                  null) {
                break;
            }
            e =
              origEvt;
        }
        return e;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nJtGZIfBLXdn6P4r3sIf8WnqfwGJ2p16sDcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yvXCoq+N6naSWst0xK8mMNFrOJsG4g7g");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
