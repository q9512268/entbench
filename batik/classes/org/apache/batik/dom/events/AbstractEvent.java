package org.apache.batik.dom.events;
public abstract class AbstractEvent implements org.w3c.dom.events.Event, org.apache.batik.dom.xbl.OriginalEvent, java.lang.Cloneable {
    protected java.lang.String type;
    protected boolean isBubbling;
    protected boolean cancelable;
    protected org.w3c.dom.events.EventTarget currentTarget;
    protected org.w3c.dom.events.EventTarget target;
    protected short eventPhase;
    protected long timeStamp = java.lang.System.currentTimeMillis();
    protected boolean stopPropagation = false;
    protected boolean stopImmediatePropagation = false;
    protected boolean preventDefault = false;
    protected java.lang.String namespaceURI;
    protected org.w3c.dom.events.Event originalEvent;
    protected java.util.List defaultActions;
    protected int bubbleLimit = 0;
    public java.lang.String getType() { return type; }
    public org.w3c.dom.events.EventTarget getCurrentTarget() { return currentTarget;
    }
    public org.w3c.dom.events.EventTarget getTarget() { return target;
    }
    public short getEventPhase() { return eventPhase; }
    public boolean getBubbles() { return isBubbling; }
    public boolean getCancelable() { return cancelable; }
    public long getTimeStamp() { return timeStamp; }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public org.w3c.dom.events.Event getOriginalEvent() { return originalEvent;
    }
    public void stopPropagation() { this.stopPropagation = true; }
    public void preventDefault() { this.preventDefault = true; }
    public boolean getDefaultPrevented() { return preventDefault;
    }
    public java.util.List getDefaultActions() { return defaultActions;
    }
    public void addDefaultAction(java.lang.Runnable rable) { if (defaultActions ==
                                                                   null)
                                                                 defaultActions =
                                                                   new java.util.ArrayList(
                                                                     );
                                                             defaultActions.
                                                               add(
                                                                 rable);
    }
    public void stopImmediatePropagation() {
        this.
          stopImmediatePropagation =
          true;
    }
    public void initEvent(java.lang.String eventTypeArg,
                          boolean canBubbleArg,
                          boolean cancelableArg) {
        this.
          type =
          eventTypeArg;
        this.
          isBubbling =
          canBubbleArg;
        this.
          cancelable =
          cancelableArg;
    }
    public void initEventNS(java.lang.String namespaceURIArg,
                            java.lang.String eventTypeArg,
                            boolean canBubbleArg,
                            boolean cancelableArg) {
        if (namespaceURI !=
              null &&
              namespaceURI.
              length(
                ) ==
              0) {
            namespaceURI =
              null;
        }
        namespaceURI =
          namespaceURIArg;
        type =
          eventTypeArg;
        isBubbling =
          canBubbleArg;
        cancelable =
          cancelableArg;
    }
    boolean getStopPropagation() { return stopPropagation;
    }
    boolean getStopImmediatePropagation() {
        return stopImmediatePropagation;
    }
    void setEventPhase(short eventPhase) {
        this.
          eventPhase =
          eventPhase;
    }
    void stopPropagation(boolean state) {
        this.
          stopPropagation =
          state;
    }
    void stopImmediatePropagation(boolean state) {
        this.
          stopImmediatePropagation =
          state;
    }
    void preventDefault(boolean state) { this.
                                           preventDefault =
                                           state;
    }
    void setCurrentTarget(org.w3c.dom.events.EventTarget currentTarget) {
        this.
          currentTarget =
          currentTarget;
    }
    void setTarget(org.w3c.dom.events.EventTarget target) {
        this.
          target =
          target;
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        org.apache.batik.dom.events.AbstractEvent newEvent =
          (org.apache.batik.dom.events.AbstractEvent)
            super.
            clone(
              );
        newEvent.
          timeStamp =
          java.lang.System.
            currentTimeMillis(
              );
        return newEvent;
    }
    public org.apache.batik.dom.events.AbstractEvent cloneEvent() {
        try {
            org.apache.batik.dom.events.AbstractEvent newEvent =
              (org.apache.batik.dom.events.AbstractEvent)
                clone(
                  );
            newEvent.
              originalEvent =
              this;
            return newEvent;
        }
        catch (java.lang.CloneNotSupportedException e) {
            return null;
        }
    }
    public int getBubbleLimit() { return bubbleLimit;
    }
    public void setBubbleLimit(int n) { bubbleLimit =
                                          n;
    }
    public AbstractEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "G8JkO34dirwUvJu+/ENVPmsDFWAN38Pjm5KI7EKXy2eNJypgRhbkYUwTvR0c" +
       "df5NCfuaAYu+5JMxUqkF1XJAst9FtL98MniifKf0EkNtChjBcxHRcWDEDjMS" +
       "9ExTfmR8OYzkIMAsMD88gNJWdGTYOeYqP36quW7eqV3fY1845I+izkiQutGs" +
       "pgWPSATua2ECHlUZlTNYOpN92h2dhNBfMCooqXVuUPXoIUfmMCWzS8lQUgVp" +
       "sOQRcEjhkuCx2P9guY/BcPXLQaPOTbDIJ6B2KIK3R02ut8s5jnRBkHD2TcCc" +
       "qfopLxI8lYafeLAD3t7nGNkB9/ups6du7b/j0ns+55yKkzVpchJraUiQac7Z" +
       "O1ZpVdG3WMHavLpqt3a+23Ru+nLv45eCU3lB3Zi1gAGzE2zzQ8fE7I78abEf" +
       "nL7xqW8eq/12lER2k4hEyazdxSdwcmbWIot2J4pPEwxJFju/1tV58tCm1aO/" +
       "epmdcSLO6YOF/PIj8gsP7/3OvW2n26OkoY/UqHpKybGjQTcf0nco8kFrmDSq" +
       "dm8OVIRaVEkrOKrQhKYs4VEZxotLZ2P+KR6XpGRZ8UmN4kOm9ZoxoVibjazO" +
       "tp4bE6TBf+L0TOirGJhjQwL+E7crMR3FJJbD3gB7HElsM03vrCGZNNlw5n9j" +
       "HT3JbvHuM/8H+Pn3M/xBAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iIDIOj9fj8dATMyl6tYIoTIIpYajL4Kg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("YE/teiNcJotO2Cha7rQUBUtb6RCWV40QWmbZEKs1HC+vIVZ70lJFV4JHZQyt" +
       "jlELLbQHcNzTYAtDusMKy6BMPyhwhjpH9aqLaCoXVKetIrlMCx6rgSAzX7Eo" +
       "j9ZMR5h7Zd6igWqstCaJGC1PUOv2UBbBwjZaNRSjuZwni8Rb9CqZXCoVUdBX" +
       "kU0Mkdhodbl2bHW6bWM+KU/HjloxmSaW59N+n+LkxlyIU2HQ6lpwTaGk/LLv" +
       "LDnLI4IkDqNSSis9sPxQu0qDk/pI2+1WOkuLajpBLxiBSQnS8jCCj0ZEn/Wt" +
       "hgnsOqG8oW2YcCedMbiATz2o0MGlpeDZeLMXuGDZH9q0zk5GHGLbIAaZix2J" +
       "SKFyjTIrhch1ELUw7jZxtU30goGK6FbZ1pG5MzcGXreEOt0OQszpUlk2gmS0" +
       "IMA0h1Fjxg5b7UmDKiGMaVd63RoGNBaEPsTS01hdnPOjZLhgC5KsVihUjYUG" +
       "H+crRD8d+fN2cUo0wqjejsg60gd+TO2pBWxORahuNqUUZ6VJC2uZfa6OpUPV" +
       "ZhGaB4FRvxH2WwiiUcRE7gx5WuF9plT140lN8ccllS8i5UoXKBhAHUed0NMm" +
       "DNcYxgKMobg1mllDiqc9qg7rsKxTTbWPuq4/HccjZup2R6rdRycrDrFAYDz2" +
       "QnrASpipz2M0hZm6FvNQU2Km5EBg6KHY6hLVJtzr9kpsAY4jJKyYDtuc4y14" +
       "KKGSr7oemXYRixdUhWy0SlHN6VDzZh2KvbAqxzURMgtOmK9Ulr35auxJOhEI" +
       "I2MgSLUZXZx5Y7lTmvRxYUF6flQS8nCJjfMOuShXFHRUspqlmVHUGp0VBq9W" +
       "A0TFat0aIoiY6pC11J8gig8Vga6z8LysY0thJaecnEi2OOm6EUyUPQZLUqJt" +
       "xlAxGleQCLWLAg0pni1LHElXeboNMV0T0UKmBpXoxQR24Co9d3lo5ONebyl2" +
       "zAHQzIIjuci8HdgtzpdthB53WWGMzQMaqI/e48PyGJuBaJwEC+x8j61OvQ47" +
       "Q0Y2VZ7Tdn3mpu7YEE1hRUdeWcSqw6aaJwtD2gg6hG4OEjKP1aSgz5baBCG2" +
       "SlqzhmNW2C+UFgHamVGUlVScuokPS4S4wOM+hOB5xin1obTZaDTekt2i/vfX" +
       "dpv8rvXd/0ubjl/Gff/0+AZ3t08dbha2uy/TS49X1n8Xctvdq3v/DzxeWUve" +
       "v4/7E3uPeV5/7DbPVLQu0sc9l7tn/+ECarmOkm24yHabPHjSxuX1TpOPv/v5" +
       "F2T6E8W951HD7NG46z1pKQvFOgDtQVDTm05+wtVf79ve3zP1W+/+sweGT+vP" +
       "XsOu0IeP4Dxa5S/0X/xi5/XST+/mrru0g+qyHeWHCz11eN/UrYESxYEzPLR7" +
       "6sFLI5U9e8v9QDbg25FKjj4I21eU45+CvXGjaOu847f+/a9T8r6TJX8W5W4C" +
       "q7M9jO19tfzmlR7aHKxvfeFPLlG7L7v4BnC8a0vtXedP7fun5P1Vlnw3yt0J" +
       "qKEHt91k15V9jn9xVo6PgON9W47vO3eOOzedkndLluwC88mG7xhyO9edgdza" +
       "kzwEjp/akvup8yd3zyl5r8qSO6LcKwAt7NI2n0wy3id44QwE78kuPgiOj24J" +
       "fvT8CT58St6jWfJAlLsVEFxvJNwMHLvP7tVnZZfp5se37D5+/uzyp+Q9mSWv" +
       "3wwfeng73j7BN5yB4FrsNeD4zJbgZ86fYO2UvHqWwFHu9sz49nZ2ZYLv3OdX" +
       "OgO/9dyQ7d777JbfZ8+fH3pKHpYlT0e5C4AfdXS/0D7FHz6ri8kofmFL8Qvn" +
       "T5E+JW+QJcRmjjgU4GTCn9jneMWNrKdwvG2P45e2HL90/hx/5JS8t2fJ+PIt" +
       "fWvho3sQF64h79OenJX2I+D4ypb2V86ftnlKXvY+3I5y3Da8nWf2GapndbCv" +
       "B8fXtwy/fv4MF6fkrRMfBOHZnfUNO2bDVZH9w242OKubzfT3m1ua3zx/mu8+" +
       "Je8nsuQ5sJDap7m3yy4T/9RhjbtwJaC/sk72u+bHzqrjBXB8e9vit8+na3a2" +
       "b8Zlv8Eq6+79VRYbO856kZVB/+ApvfZ8lrwfeDZBlg/12hEDuOL22CvRz173" +
       "+N6W/vfOXzNeOCXv57PkI6fvBz7I9YqbWq9iqHfu3pTdufN8uF63vwhf3xNY" +
       "bxFm1/Q+eQr1F7PkEyDwNxwj2puxDnL9x2flCgPYD2+5vuZ8uF6/Frj+Etej" +
       "hP/5KYQ/lyW/FOVuu0SY4o5Q/uUzUL49uwjWOjtPbCk/cQ2Uc1fU4n91St6/" +
       "yZLPAysH/o07Ztf9PsEvnJUgWI3vPLkl+OS5Evy9U/L+bZZ8Mcq9ekvwxJ37" +
       "+0x/5wxM1xffCBgWt0yLZ2a6s6/Z8ZrSH55C9ytZ8h/Auic8smw9qKt/cFaC" +
       "2VBWtgQr50lwY4r//RSC38iS/3rsOyIHKf7xWSlm3nb71tXOZW9dnZ3i/z6F" +
       "4v/Jkm9d/czyP8/KFYSRO2/Zcn3L+XP965O57mZN7XzvSoHyX56VYRkAamwZ" +
       "Ns6T4ToW2r31FIa3Z8kNIBYKL78TeIDj7o3nMYrYliN2/hzvPYXj/VlyFwgI" +
       "QuV4cnef9U7EfbnsPZUNOfIayF1doLf72PHs179BDPz4kScNlBtxsee5AVjs" +
       "YKmkeJlVrivKmt59MMrdIGVye+UPvAaxeSV6v2ceOkPPZLfuc6/N3qLY9sz4" +
       "/HsGPiWvnCVPZi+8ZmSPeSVq9+IZ2GWLqewG6Y60ZSedP7unT8l7a5bUgWu6" +
       "dIN0/Y5PJvpr+wzffNZQ93UArLllaJ4PwwO2+2trKsQpNMkswQDN8CjNgwbc" +
       "vhaaKYg/Dn2VJfusxP2XffRp86Ei6VMvXLj5vhdG/3H9YZJLHxO6hczdrMaW" +
       "dfArAAfObwTzhWqs2d+yTu/w1mw4EOmd8rGYKHfj5iTDvMtuyoyj3CuPKxPl" +
       "rgPpQUkemPJRSWDr6/8H5d4GbGJfDjS6OTko8gyoHYhkp89mg737xnTjbu4/" +
       "qCtZ3+eu6DwvFTn4RZPsieX6c1x7TxdjZvvq36dfIKh3fKf6ic0XVSRLWK2y" +
       "Wm4mczdtPu6yrjR7QvnoibXt1XUj/sT37/jMLa/be5p6xwbwvt4ewPbw8Z8s" +
       "wWwvWn9kZPW5+/7ZD/2TF/5o/W7Y/wf52bFFJ00AAA==");
}
