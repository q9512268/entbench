package org.apache.batik.css.engine.value;
public class StringValue extends org.apache.batik.css.engine.value.AbstractValue {
    public static java.lang.String getCssText(short type, java.lang.String value) {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return "url(" +
                value +
                ')';
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_STRING:
                char q =
                  value.
                  indexOf(
                    '\"') !=
                  -1
                  ? '\''
                  : '\"';
                return q +
                value +
                q;
        }
        return value;
    }
    protected java.lang.String value;
    protected short unitType;
    public StringValue(short type, java.lang.String s) { super();
                                                         unitType =
                                                           type;
                                                         value = s;
    }
    public short getPrimitiveType() { return unitType; }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        !(obj instanceof org.apache.batik.css.engine.value.StringValue)) {
                                                      return false;
                                                  }
                                                  org.apache.batik.css.engine.value.StringValue v =
                                                    (org.apache.batik.css.engine.value.StringValue)
                                                      obj;
                                                  if (unitType !=
                                                        v.
                                                          unitType) {
                                                      return false;
                                                  }
                                                  return value.
                                                    equals(
                                                      v.
                                                        value);
    }
    public java.lang.String getCssText() {
        return getCssText(
                 unitType,
                 value);
    }
    public java.lang.String getStringValue()
          throws org.w3c.dom.DOMException {
        return value;
    }
    public java.lang.String toString() { return getCssText(
                                                  );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "juMXfIrD7f8CdYm+MQEeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1af/ArV1Xf9237+vpa3nttoS2lv/tA2sB3k+wmu6GIbJLd" +
       "ZJPNJtnNJptVed3f2WR/ZX8mwSowg0VRRClYZqAzzsAoTPmhI+qoOHVQAWEc" +
       "cRhRRqA6zogiM/QP0REV726+v/v6ailjZu7N3XvPOfecc8/93Lv37pPfhq4J" +
       "A6jge/batL1oV19Fu3O7shutfT3c7TCVgRyEutaw5TAcgbpL6n2fPP/d7717" +
       "dmEHOi1BN8uu60VyZHluyOmhZye6xkDnD2tJW3fCCLrAzOVEhuPIsmHGCqOH" +
       "GOj6I6wRdJHZVwEGKsBABThXASYOqQDTS3Q3dhoZh+xG4RL6aegUA5321Uy9" +
       "CLr3uBBfDmRnT8wgtwBIOJM9j4FROfMqgO45sH1r87MMfm8BfuxX33Tht66C" +
       "zkvQecvlM3VUoEQEOpGgGxzdUfQgJDRN1yToRlfXNV4PLNm2NrneEnRTaJmu" +
       "HMWBfuCkrDL29SDv89BzN6iZbUGsRl5wYJ5h6ba2/3SNYcsmsPWWQ1u3FlJZ" +
       "PTDwrAUUCwxZ1fdZrl5YrhZBd5/kOLDxYhcQANZrHT2aeQddXe3KoAK6aTt2" +
       "tuyaMB8FlmsC0mu8GPQSQbc/p9DM176sLmRTvxRBt52kG2ybANV1uSMylgh6" +
       "2UmyXBIYpdtPjNKR8fk2+/p3vdltuzu5zpqu2pn+ZwDTXSeYON3QA91V9S3j" +
       "DQ8y75Nv+fQ7diAIEL/sBPGW5nd/6pk3vuaupz63pXnFZWj6ylxXo0vqh5Rz" +
       "X7qj8UDtqkyNM74XWtngH7M8D//BXstDKx/MvFsOJGaNu/uNT3F/Nn3LR/Vv" +
       "7UBnaei06tmxA+LoRtVzfMvWg5bu6oEc6RoNXae7WiNvp6FrQZmxXH1b2zeM" +
       "UI9o6Go7rzrt5c/ARQYQkbnoWlC2XMPbL/tyNMvLKx+CoGtBgm4A6S5o+8v/" +
       "I+hheOY5Oiyrsmu5HjwIvMz+ENbdSAG+ncEKiPoFHHpxAEIQ9gITlkEczPS9" +
       "BjXMaE2gE5zIdqzvxdQ4K+9mkeb/P/Sxyuy8kJ46BYbgjpMAYIO50/ZsTQ8u" +
       "qY/FdfKZj1/6ws7BhNjzUAS9FnS7u+12N+92F3S7u+12N+9290i30KlTeW8v" +
       "zbrfDjYYqgWY9AAOb3iA/8nOw++47yoQZX56NfBzRgo/Nyo3DmGCzsFQBbEK" +
       "PfV4+tbxzxR3oJ3j8JqpDKrOZuyDDBQPwO/iyWl1ObnnH/3mdz/xvke8wwl2" +
       "DK/35v2zObN5e99J5waeqmsACQ/FP3iP/KlLn37k4g50NQADAICRDDwIsOWu" +
       "k30cm78P7WNhZss1wGDDCxzZzpr2AexsNAu89LAmH/VzeflG4OPrs4C+BaTX" +
       "70V4/p+13uxn+Uu3UZIN2gkrcqz9Ud7/4N/8xT8jubv3Yfn8kYWO16OHjkBB" +
       "Jux8PulvPIyBUaDrgO5rjw/e895vP/rjeQAAivsv1+HFLG8ACABDCNz89s8t" +
       "//YbX//Ql3cOgyYCa2Gs2Ja6OjAyq4fOXsFI0NurDvUBUGKDqZZFzUXBdTzN" +
       "MixZsfUsSv/r/CtLn/rXd13YxoENavbD6DXPL+Cw/uV16C1feNO/35WLOaVm" +
       "S9mhzw7Jtvh486FkIgjkdabH6q1/def7Pyt/ECAtQLfQ2ug5YO3kPtgBTA9c" +
       "YTsTWA4YjWRvCYAfuekbiw9882NbeD+5Xpwg1t/x2M9/f/ddj+0cWVTvf9a6" +
       "dpRnu7DmYfSS7Yh8H/xOgfQ/WcpGIqvYAutNjT10v+cA3n1/Bcy590pq5V1Q" +
       "//SJR/7gNx55dGvGTcfXFBJsmT721//9xd3Hn/78ZWDsmnDmBdu91MvARi33" +
       "d7bW74FXrjycNz+Y57uZtrmrobztR7Ps7vAolhz3+pEd3CX13V/+zkvG3/mj" +
       "Z3JFjm8Bj06dnuxv3XYuy+7JvHDrSeBsy+EM0KFPsT9xwX7qe0CiBCSqYEEI" +
       "+wEA79WxibZHfc21X/3jz9zy8JeugnYo6KztyRol55gFXQfAQge+sLWV/2Nv" +
       "3M6V9AzILuSmQs8yfjvHbsufrrly1FHZDu4Q8W77z76tvO0f/uNZTsiB+jKB" +
       "eIJfgp/8wO2NN3wr5z9EzIz7rtWzFzSw2z3kLX/U+bed+07/6Q50rQRdUPe2" +
       "0vkSBXBIAtvHcH9/Dbbbx9qPbwW3+56HDlaEO07OhCPdnsTqwwgE5Yw6K589" +
       "Ac/nMi+/AqTyHnKVT8LzKSgvdHOWe/P8Ypb9yD4aXucHXgS01LVcNgqiPV+Y" +
       "s4fXbcE9y9+QZcx2PInnHHvquGZ3goTtaYY9h2b8c2iWFfv7Kp2JXSsa7TkB" +
       "OaHV6Hm1yqWsTgFrrynvYrvF7Fm6fL9XZcVXg0UizF9hAIdhubK9r8itc1u9" +
       "uA9CY/BKA0Ly4tzGLuct9P+sF5gZ5w5BhfHA68M7//HdX/yl+78BwrezNyAg" +
       "ao8gDxtnb1Q/++R777z+saffma9vwGnjn/tN7OlMqnol67LsTVl2ad+s2zOz" +
       "+HyryMhh1MuXJF3LLMtFFI/YU43AwgZU/IGtjc79XRsNaWL/xxQlZZIKK2SM" +
       "r8Lp1IDZKG2nEh1gMWE6s3VnSKxMedQrWVN6INDtdoSpsGIlWsnWcLTAk2ZH" +
       "MNmIEvjOsDyjCqRAckPe6i4ttrjghIgo+cWFNyxaPDuMlkXBsUelLrGMGn5U" +
       "hDVHc3B44xq0sHTs9rTmIm6ySaKCgmuO4vfSNc8NxpPOPGKX5liJ2Kld5mSW" +
       "dZa8L5dammLhSd8uRoUyUrNShhx1p1XeGWN0VVIdCxv640VJ7o0ooWgVHXnU" +
       "LbJ2Y8p5eLyg5iLWkRVv4q17QnXdj7rkMgzpao3nKLNR5lu8WCKdvrMIzbTs" +
       "kKNpi1tSTaujkqi1RBmFGVN8R09aykzDPVPHS0q/uWi5CEPHXBzP+stxoSt1" +
       "LItbdrur8XLd8e2k2g/itj12p5JvoxKyJO2QqlZZBreHKV4Q5TKi9ms1aUVN" +
       "1xxLllyxuQpIbFyMJNzxqqOJOCmNZC2QOQld+GNyXTYHPb49EPqjYWNWVEyB" +
       "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" +
       "8aP8In7ze7f+9ut//Ymv5zc0/wsKh1lOSygAAA==");
}
