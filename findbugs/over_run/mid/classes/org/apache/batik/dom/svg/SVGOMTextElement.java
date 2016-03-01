package org.apache.batik.dom.svg;
public class SVGOMTextElement extends org.apache.batik.dom.svg.SVGOMTextPositioningElement implements org.w3c.dom.svg.SVGTextElement, org.apache.batik.dom.svg.SVGMotionAnimatableElement {
    protected static final java.lang.String X_DEFAULT_VALUE = "0";
    protected static final java.lang.String Y_DEFAULT_VALUE = "0";
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextPositioningElement.
                 xmlTraitInformation);
             t.put(null, SVG_TRANSFORM_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList
      transform;
    protected java.awt.geom.AffineTransform motionTransform;
    protected SVGOMTextElement() { super(); }
    public SVGOMTextElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() { transform =
                                                createLiveAnimatedTransformList(
                                                  null,
                                                  SVG_TRANSFORM_ATTRIBUTE,
                                                  "");
    }
    public java.lang.String getLocalName() { return SVG_TEXT_TAG;
    }
    public org.w3c.dom.svg.SVGElement getNearestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getNearestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGElement getFarthestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getFarthestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGRect getBBox() { return org.apache.batik.dom.svg.SVGLocatableSupport.
                                                 getBBox(
                                                   this);
    }
    public org.w3c.dom.svg.SVGMatrix getCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getScreenCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getScreenCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getTransformToElement(
            this,
            element);
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getTransform() {
        return transform;
    }
    protected java.lang.String getDefaultXValue() {
        return X_DEFAULT_VALUE;
    }
    protected java.lang.String getDefaultYValue() {
        return Y_DEFAULT_VALUE;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMTextElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public java.awt.geom.AffineTransform getMotionTransform() {
        return motionTransform;
    }
    public void updateOtherValue(java.lang.String type,
                                 org.apache.batik.anim.values.AnimatableValue val) {
        if (type.
              equals(
                "motion")) {
            if (motionTransform ==
                  null) {
                motionTransform =
                  new java.awt.geom.AffineTransform(
                    );
            }
            if (val ==
                  null) {
                motionTransform.
                  setToIdentity(
                    );
            }
            else {
                org.apache.batik.anim.values.AnimatableMotionPointValue p =
                  (org.apache.batik.anim.values.AnimatableMotionPointValue)
                    val;
                motionTransform.
                  setToTranslation(
                    p.
                      getX(
                        ),
                    p.
                      getY(
                        ));
                motionTransform.
                  rotate(
                    p.
                      getAngle(
                        ));
            }
            org.apache.batik.dom.svg.SVGOMDocument d =
              (org.apache.batik.dom.svg.SVGOMDocument)
                ownerDocument;
            d.
              getAnimatedAttributeListener(
                ).
              otherAnimationChanged(
                this,
                type);
        }
        else {
            super.
              updateOtherValue(
                type,
                val);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1af3AU1R1/dwkJCYGE8FN+BIiBkQh3BlS0wR/JQUj08mNC" +
       "oBCEY7P3LlnY21133yUHSkGnVcYZHUfBYiv0j+LUOihOR21nLJa2tuqoWK31" +
       "Z6tVZ1pbdSozrdhStd/v293bvb3bDZkwzcy+27zvj/c+3/d93+/7scc+JRMM" +
       "ndRrgpIUImyXRo1ID773CLpBkzFZMIw+qE2Id7x/794zv6+4JUzK+smUIcHo" +
       "FAWDtklUThr9ZL6kGExQRGp0UZpEiR6dGlQfFpikKv1khmR0pDVZEiXWqSYp" +
       "MmwU9DiZKjCmSwMZRjssBYwsiPPeRHlvoi1ehuY4qRJVbZcjMCdPIOaiIW/a" +
       "ac9gpCa+QxgWohkmydG4ZLDmrE4u1lR516CssgjNssgO+TLLENfFLyswQ/1j" +
       "1Z+fvXuohpthmqAoKuMQjV5qqPIwTcZJtVO7VqZp40byLVISJ5NczIw0xO1G" +
       "o9BoFBq18Tpc0PvJVMmkYyqHw2xNZZqIHWJkUb4STdCFtKWmh/cZNExkFnYu" +
       "DGgX5tDaw+2BePDi6IHvbqv5SQmp7ifVkrIeuyNCJxg00g8GpekBqhstySRN" +
       "9pOpCgz4eqpLgizttka71pAGFYFlwAVss2BlRqM6b9OxFYwkYNMzIlP1HLwU" +
       "dyrrvwkpWRgErDMdrCbCNqwHgJUSdExPCeB7lkjpTklJcj/Kl8hhbLgeGEC0" +
       "PE3ZkJprqlQRoILUmi4iC8pgdD04nzIIrBNUcEGd+5qPUrS1Jog7hUGaYGS2" +
       "l6/HJAFXBTcEijAyw8vGNcEozfGMkmt8Pu1afddNSrsSJiHoc5KKMvZ/EgjV" +
       "eYR6aYrqFOaBKVjVGL9PmHlif5gQYJ7hYTZ5fnrz6WuX1Z18zuSZW4Sne2AH" +
       "FVlCPDow5ZV5saVXlmA3JmqqIeHg5yHns6zHojRnNYg0M3MakRixiSd7f7t5" +
       "38P04zCp7CBloipn0uBHU0U1rUky1ddRheoCo8kOUkGVZIzTO0g5vMclhZq1" +
       "3amUQVkHKZV5VZnK/wcTpUAFmqgS3iUlpdrvmsCG+HtWI4SUw0OWwhMh5t/F" +
       "WDCyIzqkpmlUEAVFUtRoj64ifhxQHnOoAe9JoGpqdAD8f+fypsiqqKFmdHDI" +
       "qKoPRgXwiiFqEqNJNR01hsGxNq7r7uyDCYUhgioQdsDntP9ra1nEPm0kFIJh" +
       "mecNCjLMp3ZVTlI9IR7ItK49/WjiBdPhcJJYVmNkKTQZMZuM8CYj0GQEmox4" +
       "myShEG9pOjZtDj4M3U4IAhCFq5au33rd9v31JeB12kgp2D0MrEsKslLMiRZ2" +
       "iE+Ix17pPfPyS5UPh0kYAsoAZCUnNTTkpQYzs+mqSJMQm/yShB0oo/5poWg/" +
       "yMlDI7ds3HsJ74c72qPCCRCoULwHY3SuiQbvLC+mt/r2jz4/ft8e1ZnveenD" +
       "znoFkhhG6r3j6gWfEBsXCk8kTuxpCJNSiE0Qj5kA8wdCXZ23jbxw0myHZsQy" +
       "EQCnVD0tyEiy42klG9LVEaeGO9xU/j4dhngKzq86eDqtCcd/kTpTw3KW6aDo" +
       "Mx4UPPRftV47/Oapv63k5razRLUrva+nrNkVmVBZLY9BUx0X7NMpBb4/Heq5" +
       "9+Cnt2/h/gccFxZrsAHLGEQkGEIw83eeu/Gt9949+lo457MhRio0XWUwYWky" +
       "m8OJJDI5ACe6utMlCG4yaEDHadiggGNKKUkYkCnOk/9WL2564pO7akxXkKHG" +
       "9qRloytw6i9oJfte2HamjqsJiZhcHbM5bGbEnuZobtF1YRf2I3vLq/Pvf1Y4" +
       "DLEf4q0h7aY8hBJuBsLH7VKOP8rLlR7a5Vg0GG7/z59irkVQQrz7tc8mb/zs" +
       "6dO8t/mrKPdwdwpas+lhWCzOgvpZ3ljTLhhDwHfpya4bauSTZ0FjP2gUIXYa" +
       "3TrEumyec1jcE8rf/uWvZ25/pYSE20ilrArJNoHPM1IBDk6NIQiTWe2aa83B" +
       "HZkIRQ2HSgrAoz0XFB+ptWmNcdvu/tmsx1f/6Mi73K+4hvk5V5qEWubCs8Fy" +
       "pQ3FpwyWS3i5FItltnuWaZkBWIR7fLMyQKFnFMNWcMb/Z8NqmmPBlVLEXCnZ" +
       "hMVF80LLAMQosN0aVcxgTuC9XRfgKJ1YXMtJq7BoMXv+jXMzNlZcY0rM5XW4" +
       "1VlYkFT4HsaJh5+88/0Pf3Hmh+XmCmipfxLwyM3+T7c8cOsHXxS4KQ//RVZn" +
       "Hvn+6LEH5sSu/pjLO3EYpS/MFmZoyFSO7IqH0/8K15f9JkzK+0mNaO0XNgpy" +
       "BqNbP6yRDXsTAXuKPHr+etdc3DXn8sw8bw5wNevNAM7KAN6RG98ne4I+Oi+5" +
       "Ap4my+GavB4cAj8NXYLvm4r7cQm+LgdnNvjGhEEvJEWQPU49J6ANCBybEmvW" +
       "trVsiPclNrbEN6zF6nZn7nBn2zyas/UWolphtbjCH5UYhAqLrVhsKwLHTznA" +
       "2Tw6nOS5w5mBtavhWWW1uKoADuEvcnEsYQeLB8b0AKWMTMum5T5dkFiHwlcT" +
       "uekDEeWigojCQ+gaFSIa7PeTNEuTfZjmPLDT5w6bL0gwgsSsHsZ8YA+bsLFo" +
       "LEzzftKwOoDopxgIzUa1Mnj93KJIadz29NlycSvluwCOjBEgbm/arS62+wDc" +
       "GwjQTxr8MK3imPV5Yc7neUIYYZFBinkgBTOW5rg8gPYFAMo6HYvlOsb/yoi1" +
       "Y7N/vUlsbn7qqkPLj6wU3QZ3bVfOaYA6OVpzkND1LFlcesz327/zs4ejtx44" +
       "kux+sMnMMbX5e+K1Sib9yOtfvhg59Ofni2y5KpiqLZfpMJVdsGqgyUUFma2T" +
       "H284aWLVq2dK3rlndlXhTgk11fnsgxr9U6C3gWdv/fucvquHto9hC7TAYyiv" +
       "yh93Hnt+3RLxnjA/oTGzUsHJTr5Qc34uqtQpy+hKX15Gqs+fFJfAs9Xynq3e" +
       "SeH4p9+M8BMNWNocDqD9AItDjMyVFNi64MEabZHluDRMc6ehhhG4NunRpTSI" +
       "DlsnP9E9te/tfOCjR0x/8y5EPMx0/4E7vo7cdcD0PfMs7cKC4yy3jHmexrte" +
       "Yxrna/gLwfMVPogLK/AXlhsx61BnYe5UR9Oy3H8DusWbaPvr8T1PPbTn9rBl" +
       "p7sZKR1WpaQTO+4f+wKRVx/IjWmVHUCoNaY0wB2KLLHLNV0aBlCexDcpQGOA" +
       "JzweQHsSi0cYme14Sb6LIP2oY5tHx22bWiThjj1tIUmPMlVi+UaoDBANAHoy" +
       "gPYrLJ5ipGqQsrgqCnKXNfHbHeA/HzfwmUiKIpPV+5GxA/cTDQD3YgDtFBbP" +
       "MnIBAO+iAuxD2UaJjmiq7k1hc4pkOjcLt9Fz58dGGEf3WkD3jt1GfqIBdng7" +
       "gPZHLP4AFgAbtQk6Gyo0EnL8zjHD6+M2wzQk4Wr9NgvLbWM3g59oANS/BNA+" +
       "wuJ9CE1ghtZWNWs7xqwijtGLp805c3wwbnPwrQRuj+60MN05dnP4iQZA/mcA" +
       "7XMs/gH7RzBHrK/TtsYFRazRKUAszTr2+Oz82GMRPActUAfHbg8/UX/MoXAA" +
       "rRQrvzRD6HpRp1QBq2DdFw7wr84P8EZ4Dlu9Pzx24H6iHnAhMxfzqc0RTinO" +
       "YI/8vGIBMitSDZeuXEENFhWMzAAT5bYtfaorhji2ClWO21YNSMJQ+pAF+KGx" +
       "28pPNMAR5gXQ6rCYZTpJwfbuoiIGLLp1dYw0+/w41GJ4jltIj49ipCLrdj/R" +
       "AEM0BtCWYbGYkRow0hqaEjIy28QP2ZDZWZCElpw/8E9aCJ4cO3g/0QCAlwfQ" +
       "rsCiKQ/85mLgV5y/FHvCQnBi7OD9RAMAtgbQ1mBxFaRYhY50wR7anhk17pmR" +
       "I3A7XD1uO2AaIVfC84wF5pmx28FPNABrTwCtF4vrYU9ihom8k7zc6ZzuGCE+" +
       "biPwo9fl8JyykJwaxQhFYqWfaADQGwJo27D4Jux0wQid+QdiyP5tB/6mccPn" +
       "N0Kt8LxhYXhj7PD9RD0Qw87Zbrvt38sKjscEiPuRYZz3eI1nn4zxQMCNMxRg" +
       "OPyQBa8jazJaEnJHNyzY9VwIcXayoVGPsotcA4FW7ycJeBs3u+BrKPMLHvHR" +
       "I9UTZx3Z8Aa/Fs99ZVMVJxNTGVl2X3W43ss0naYkbvIq8+JD48AMmBF+B4mM" +
       "lECJ3Q7pJvcwI9OLcQMnlG7OXVaEcXMyMoH/uvluZqTS4YOlr/niZtkL2oEF" +
       "X/dp9vBeOvrnHfYXPJIyaB9/mguruZb9nUXkjNGGLSfivoHHsy3+ZZt9QJgx" +
       "v21LiMePXNd10+nLHzS/ABBlYfdu1DIpTsrNjxG4UjxkXOSrzdZV1r707JTH" +
       "KhbbR0tTzQ47k2euawdxDSweNfSeOZ67caMhd0X+1tHVT7+0v+zVMAltISGB" +
       "kWlbCu/ZslpGJwu2xN0nt67vI/m1fXPlh9tf/uLtUC2/ECa4bsUjvACJhHjv" +
       "0+/0pDTte2FS0UEmSHg7wi8B1+xSYIM3rHeQiRlFujFDO5LgtANqRsl9BDcF" +
       "XV3Au1xuGcugk3O1+AUJI/WF54GFX9VUyuoI1VtRO6qZ7DmWzWiam5rFj8OK" +
       "oIKxaTr87723vdkNUzGv425t5UZmIHfC6/7GztSNJS7iyYNZHEXw9US8U9Os" +
       "U8nSs3xUNQ1jRYgH19A9JjdyMBJq1LT/Ae63pSwrKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dTyOQ2uaxHqUV/zMMd/8u3HhzqVvaXun");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/crNvCjNM37uyAT3H/qsvjOBfjMmiAt3B6G1VGL9hnb4lTPKfjVLfjkuPL63" +
       "w9VGyMq/ugf8z28B8ENZZnauxN0Bdm92zD90Q6z/+oyyf5MlX48L9xt6zPqq" +
       "4vA7d8X3+L5xC/gezTKhrHiHL739+H77jLL/lCXfigtvB/h4XQn1KB5Zehr4" +
       "4Ul6e+IUFjwukpvi392qKbLp/eLOFC/eflP8/hllf5glvweAAlNQShib19oi" +
       "k/jOHu1/vgW0D2eZT4DrpR3al24/2v95RtmfZMl/B4wA0DYa/upwmB87ZZj7" +
       "2bHBI9T/4xZQ5+/Cs1f3n9mh/sxtR33u3BllebjxZ3HhAkBNDLlD0G8/BTSn" +
       "ADpb7WH/+a3Cfhpcr+xgv3L7YV88o+zBLLlvy2IDNdR1D4DP8u46wnfuLbeK" +
       "7zlwfXGH74u3B9+5vcB3ciDvOF3gcBzfeRpHrVQ9yEKbvIEns+TRuPAIsMTR" +
       "2/ehv5/fx03y2C2Y5HKWmbHZl3cm+fLtH/JnzygrZsnl7ZBfcxjhfafY6dRT" +
       "FXtbPHOr7vEMuF7f2eL1m7XFDQO3c9gZZfUsKceFS8AWTX2mJE48yU9lZcL7" +
       "hfwccjsw/tIO4y/dfozEGWXZKaVzH74Ko3Qaxh++HWvW13YYv3b7MXbPKOtl" +
       "SRusWZ6e8r6mH7rzpePufFSQw+3cAtyMsAt1cP3aDu6v3X64L5xRdiVLJiDO" +
       "3k7hq057HZ3gsvZYpVvAmh+n+wC4vrnD+s2bxXpjurLOKLOzRIsLDwGs3NUn" +
       "qDLxj+1R3vCc2hko8zO6DXB9e4fy27cH5fn9QT380Cnff812gAIY9iA//5Qd" +
       "ij7cCcgnaW6D5Az7rLMkAK6eBBpg6S6ITsOj6b1/1jq3uKlTuKC9k99WZKfE" +
       "H7/ms67tp0jqL7x68Z7HXhW/nX9ecPS50L1s4Z5Z4jjHD6Yeu78QhPrMyu12" +
       "7/aYapBD+gTw7OttmcSFO0CaKXzuxa3034wLbztNGkiC9LjkSztCOC4ZF+7K" +
       "/x+X+9tx4b69HIgJtzfHRX4CtA5EstvPBIcDi974O5XDT5Eszzjc6NnGKI8f" +
       "98s8rHzoRgN2VOX4lwzZ/k7+id7hXkyy/Ujvivr6q23+Y9+v/uz2SwrVUTab" +
       "rJV72MLd24868kaz/Zynr9vaYVsX6Gd/8MAv3vvM4d7TA1uF93PkmG7vOv2b" +
       "BdIN4vwrg80/e+yffPAfvPo7+fG+/wdLuHRzOzkAAA==");
}
