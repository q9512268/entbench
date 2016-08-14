package org.apache.batik.bridge;
public abstract class AnimationSupport {
    public static void fireTimeEvent(org.w3c.dom.events.EventTarget target,
                                     java.lang.String eventType,
                                     java.util.Calendar time,
                                     int detail) { org.w3c.dom.events.DocumentEvent de =
                                                     (org.w3c.dom.events.DocumentEvent)
                                                       ((org.w3c.dom.Node)
                                                          target).
                                                       getOwnerDocument(
                                                         );
                                                   org.apache.batik.dom.events.DOMTimeEvent evt =
                                                     (org.apache.batik.dom.events.DOMTimeEvent)
                                                       de.
                                                       createEvent(
                                                         "TimeEvent");
                                                   evt.
                                                     initTimeEventNS(
                                                       org.apache.batik.util.XMLConstants.
                                                         XML_EVENTS_NAMESPACE_URI,
                                                       eventType,
                                                       null,
                                                       detail);
                                                   evt.
                                                     setTimestamp(
                                                       time.
                                                         getTime(
                                                           ).
                                                         getTime(
                                                           ));
                                                   target.
                                                     dispatchEvent(
                                                       evt);
    }
    public static org.apache.batik.anim.timing.TimedElement getTimedElementById(java.lang.String id,
                                                                                org.w3c.dom.Node n) {
        org.w3c.dom.Element e =
          getElementById(
            id,
            n);
        if (e instanceof org.apache.batik.dom.svg.SVGOMAnimationElement) {
            org.apache.batik.bridge.SVGAnimationElementBridge b =
              (org.apache.batik.bridge.SVGAnimationElementBridge)
                ((org.apache.batik.dom.svg.SVGOMAnimationElement)
                   e).
                getSVGContext(
                  );
            return b.
              getTimedElement(
                );
        }
        return null;
    }
    public static org.w3c.dom.events.EventTarget getEventTargetById(java.lang.String id,
                                                                    org.w3c.dom.Node n) {
        return (org.w3c.dom.events.EventTarget)
                 getElementById(
                   id,
                   n);
    }
    protected static org.w3c.dom.Element getElementById(java.lang.String id,
                                                        org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          n.
          getParentNode(
            );
        while (p !=
                 null) {
            n =
              p;
            if (n instanceof org.apache.batik.dom.svg.SVGOMUseShadowRoot) {
                p =
                  ((org.apache.batik.dom.svg.SVGOMUseShadowRoot)
                     n).
                    getCSSParentNode(
                      );
            }
            else {
                p =
                  n.
                    getParentNode(
                      );
            }
        }
        if (n instanceof org.apache.batik.dom.svg.IdContainer) {
            return ((org.apache.batik.dom.svg.IdContainer)
                      n).
              getElementById(
                id);
        }
        return null;
    }
    public AnimationSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fl6z3xQxqgWbFjEpdp8Xjzhc+C8zF27uLRkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tukE+UVa+oV7/+g1H3v2W/lh/v8BZfon7QgkAAA=");
}
