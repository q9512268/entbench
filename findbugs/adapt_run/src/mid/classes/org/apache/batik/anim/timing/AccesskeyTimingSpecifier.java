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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6e+zjyH0fd29v9+58vt07x/b1enc+22snZyU/SqIoUTg7" +
       "sUSJEl8iJUqURLde8y2KT/Elkum1iYHWTgK4h/bsOoB9QFEHTQI7ToMECdAm" +
       "uCJtYyNGAQdBmhaoHQQt6tYxEP/RtKjbpkPq996HfbGBCuBoOPOdme/nO9/H" +
       "cGY+/y3o4SiEaoHv5Kbjx0d6Fh9tHfQozgM9OqIYlJfDSNdwR46iOSi7o77r" +
       "V2/+xXde2dy6Cl2XoLfInufHcmz5XjTTI99JdY2Bbp6VDh3djWLoFrOVUxlO" +
       "YsuBGSuKX2KgN51rGkO3mRMWYMACDFiAKxbg3hkVaPRm3UtcvGwhe3G0g/42" +
       "dIWBrgdqyV4MvfNiJ4Ecyu5xN3yFAPTwSPkuAlBV4yyEXjjFfsB8F+BP1uBX" +
       "/9GHb/3aQ9BNCbppeULJjgqYiMEgEvS4q7uKHkY9TdM1CXrS03VN0ENLdqyi" +
       "4luCnoos05PjJNRPhVQWJoEeVmOeSe5xtcQWJmrsh6fwDEt3tJO3hw1HNgHW" +
       "t51hPSAkynIA8DELMBYasqqfNLlmW54WQ++43OIU420aEICmN1w93vinQ13z" +
       "ZFAAPXWYO0f2TFiIQ8szAenDfgJGiaFn7ttpKetAVm3Z1O/E0NOX6fhDFaB6" +
       "tBJE2SSG3nqZrOoJzNIzl2bp3Px8a/L+T/ykN/auVjxruuqU/D8CGj1/qdFM" +
       "N/RQ91T90PDx9zGfkt/22x+/CkGA+K2XiA80v/m3vv3BH33+9S8daP76PWg4" +
       "Zaur8R31c8oTX30Wf7H7UMnGI4EfWeXkX0BeqT9/XPNSFgDLe9tpj2Xl0Unl" +
       "67N/s/6pX9a/eRV6jISuq76TuECPnlR9N7AcPRzpnh7Ksa6R0KO6p+FVPQnd" +
       "AHnG8vRDKWcYkR6T0DWnKrruV+9ARAboohTRDZC3PMM/yQdyvKnyWQBB0A3w" +
       "QC+A573Q4Xe7TGIohTe+q8OyKnuW58N86Jf4ywn1NBmO9QjkNVAb+LAC9N/+" +
       "scZRB478JAQKCfuhCctAKzb6oRIGnQATtVygVXBPBSSRrefz6l0IdNUCuh8e" +
       "lfoX/H8bOStlcmt/5QqYrmcvOwsH2NnYdzQ9vKO+mvSH3/6VO79/9dR4jqUZ" +
       "QygY/ugw/FE1/FE5/NFh+KP7DQ9duVKN+kMlGwcFAdNrA0cBXOjjLwp/k/rI" +
       "x9/1ENDMYH8NzM1VQArf35PjZ66FrByoCvQbev3T+58W/079KnT1oksuWQdF" +
       "j5XN+dKRnjrM25dN8V793vzYN/7ii5962T8zygs+/thX3N2ytPV3XRZy6Ku6" +
       "BrznWffve0H+jTu//fLtq9A14ECA04xloOTAHz1/eYwLNv/Sif8ssTwMABt+" +
       "6MpOWXXi9B6LN6G/PyupZv+JKv8kkPGbSiN4N3heOraK6r+sfUtQpj900JZy" +
       "0i6hqPzzB4Tgs3/8b/8rUon7xJXfPBccBT1+6Zz7KDu7WTmKJ890YB7qOqD7" +
       "j5/m/+Env/WxD1UKACjefa8Bb5cpDtwGmEIg5r/7pd2///rXPveHV0+V5koM" +
       "4meiOJaanYIsy6HHHgASjPbeM36A+3GAIZZac3vhub4GlFdWHL3U0v998z2N" +
       "3/izT9w66IEDSk7U6Ee/ewdn5X+tD/3U73/4fzxfdXNFLcPfmczOyA4+9S1n" +
       "PffCUM5LPrKf/oPnfv735M8C7ww8YmQVeuXkrlUyuFYhf2sMvfhAMwXWqWvl" +
       "gkYHa48QevEBi6YQtIit9DjQwC8/9XX7M9/4wiGIXI5Kl4j1j7/6s3959IlX" +
       "r54L3e++K3qeb3MI35Xivfkwh38JflfA83/Lp5y7suDgvp/Cj2PIC6dBJAgy" +
       "AOedD2KrGoL4L198+Z//4ssfO8B46mLkGoKF2Rf+6P985ejTf/LlezjAG4rv" +
       "O7p88CvNMmkf9A2LSzvw5fheNdfUjRxWwOCq6H1VelQiqSYOqurwMnlHdN4z" +
       "XZyRc2vIO+orf/jnbxb//He+XTF5cRF63hBZOTiI9IkyeaGU0Nsvu+GxHG0A" +
       "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" +
       "6Wtfq04x/h9Ep5CamSkAAA==");
}
