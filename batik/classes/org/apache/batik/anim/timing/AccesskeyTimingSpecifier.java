package org.apache.batik.anim.timing;
public class AccesskeyTimingSpecifier extends org.apache.batik.anim.timing.EventLikeTimingSpecifier implements org.w3c.dom.events.EventListener {
    protected char accesskey;
    protected boolean isSVG12AccessKey;
    protected java.lang.String keyName;
    public AccesskeyTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset,
                                    char accesskey) { super(owner,
                                                            isBegin,
                                                            offset);
                                                      this.accesskey =
                                                        accesskey;
    }
    public AccesskeyTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset,
                                    java.lang.String keyName) {
        super(
          owner,
          isBegin,
          offset);
        this.
          isSVG12AccessKey =
          true;
        this.
          keyName =
          keyName;
    }
    public java.lang.String toString() { if (isSVG12AccessKey) {
                                             return "accessKey(" +
                                             keyName +
                                             ")" +
                                             (offset !=
                                                0
                                                ? super.
                                                toString(
                                                  )
                                                : "");
                                         }
                                         return "accesskey(" +
                                         accesskey +
                                         ")" +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : ""); }
    public void initialize() { if (isSVG12AccessKey) { org.apache.batik.dom.events.NodeEventTarget eventTarget =
                                                         (org.apache.batik.dom.events.NodeEventTarget)
                                                           owner.
                                                           getRootEventTarget(
                                                             );
                                                       eventTarget.
                                                         addEventListenerNS(
                                                           org.apache.batik.util.XMLConstants.
                                                             XML_EVENTS_NAMESPACE_URI,
                                                           "keydown",
                                                           this,
                                                           false,
                                                           null);
                               }
                               else {
                                   org.w3c.dom.events.EventTarget eventTarget =
                                     owner.
                                     getRootEventTarget(
                                       );
                                   eventTarget.
                                     addEventListener(
                                       "keypress",
                                       this,
                                       false);
                               } }
    public void deinitialize() { if (isSVG12AccessKey) {
                                     org.apache.batik.dom.events.NodeEventTarget eventTarget =
                                       (org.apache.batik.dom.events.NodeEventTarget)
                                         owner.
                                         getRootEventTarget(
                                           );
                                     eventTarget.
                                       removeEventListenerNS(
                                         org.apache.batik.util.XMLConstants.
                                           XML_EVENTS_NAMESPACE_URI,
                                         "keydown",
                                         this,
                                         false);
                                 }
                                 else {
                                     org.w3c.dom.events.EventTarget eventTarget =
                                       owner.
                                       getRootEventTarget(
                                         );
                                     eventTarget.
                                       removeEventListener(
                                         "keypress",
                                         this,
                                         false);
                                 } }
    public void handleEvent(org.w3c.dom.events.Event e) {
        boolean matched;
        if (e.
              getType(
                ).
              charAt(
                3) ==
              'p') {
            org.apache.batik.dom.events.DOMKeyEvent evt =
              (org.apache.batik.dom.events.DOMKeyEvent)
                e;
            matched =
              evt.
                getCharCode(
                  ) ==
                accesskey;
        }
        else {
            org.w3c.dom.events.KeyboardEvent evt =
              (org.w3c.dom.events.KeyboardEvent)
                e;
            matched =
              evt.
                getKeyIdentifier(
                  ).
                equals(
                  keyName);
        }
        if (matched) {
            owner.
              eventOccurred(
                this,
                e);
        }
    }
    public void resolve(org.w3c.dom.events.Event e) {
        float time =
          owner.
          getRoot(
            ).
          convertEpochTime(
            e.
              getTimeStamp(
                ));
        org.apache.batik.anim.timing.InstanceTime instance =
          new org.apache.batik.anim.timing.InstanceTime(
          this,
          time +
            offset,
          true);
        owner.
          addInstanceTime(
            instance,
            isBegin);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gJK4bLWce51x3+v6636KRdleoPooWqxoecApwYZ2mvUCdUWdcz1+uxI69aCn" +
       "5lI8hXFNdEdYOq5PUmosCticL/yJns2NNE0lNBO71H5OjoOAHfdma11p8Fiq" +
       "KwRDFK140/LAVEBumzkz3Y1NsVgu9m2c0aeCHq/WAsYH7XAcizV5y0lNKR27" +
       "Ku5SfuzNpwvPGLjTmYOumxhPmfxi6tXMpkc3hm7emjamcYTSwn40Gymr9dzv" +
       "DYKmNd3leTHbi6wpNIY1XvazpariA69Z43pJTszrWH2XeqZdW8nZojWlcnXJ" +
       "0vmkQyj+QJlgPLcYSPEMXgWdTtraRLiy1qxoU7SHYuato8kuF1sprFHyVuaS" +
       "RSNYN7O8DzsBPp8H856PUVuHtBZE4NHORBk6zf14MWt2l11E6zjZdE2zijih" +
       "qHpntcVXgyjxhByofYzqPDqi+zQmrGYqmjogOeE8yjDaWFlGK6+htJSRhOYW" +
       "Zfb7FDl3CiEZRTG7TKb4oBcDuKLhCOhoPuhrtLYjaxTfL4SOyheBQfFCLlrE" +
       "1gsnKTKwJWTdRKScVnoCHU8xv0dMhM60F3T0MTmPxzXSotO5WrQ4Em3ZQVuZ" +
       "DkiLXZNzsUMQDBAYVtfskeJL8jAhhTpbkI112loSfKeH55vdcLyw5tF4OYsD" +
       "Nmn2djYe7hZtOfJa45XMsKqmrxTDY6XevtZq4mPDGq1WCM2N1rrfX7JY1KQW" +
       "vWmfSuNpex5lqr7GuL4y0xNuDGTVW+yIAJNpC93P1pZnDjuUM22r4s5bWLN5" +
       "L6/XaJdUHVqeSWKrGcEKK9uysvLhxZbl+uNpvhK1RtfvFwNjxqLaBPyPI7/L" +
       "+eF4JjYHbT/qNWtYlwxJWRGXviiJ0mg8Rz19yvTHDpYAgVE9ehILOZWmdDjr" +
       "CuOxyU0FbqRIPbMu2IilzrrKsrZG++N4j9tYnjj1eMRKQTen53unQTv5DNfU" +
       "mjPILH6X2/J6v96EDdjspkOGNSZ7dgK67hU9fox4O2aWw/1YG3W7G2vJcASm" +
       "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" +
       "KQAA");
}
