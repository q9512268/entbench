package edu.umd.cs.findbugs.ba.obl;
public class ObligationFactory {
    private final java.util.Map<java.lang.String,edu.umd.cs.findbugs.ba.obl.Obligation>
      classNameToObligationMap;
    private final java.util.Set<java.lang.String> slashedClassNames =
      new java.util.HashSet<java.lang.String>(
      );
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD") 
    public ObligationFactory() { super();
                                 this.classNameToObligationMap = new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.ba.obl.Obligation>(
                                                                   );
    }
    public int getMaxObligationTypes() { return classNameToObligationMap.
                                           size(
                                             ); }
    public boolean signatureInvolvesObligations(java.lang.String sig) {
        sig =
          sig.
            replaceAll(
              "java/io/File",
              "java/io/");
        for (java.lang.String c
              :
              slashedClassNames) {
            if (sig.
                  indexOf(
                    c) >=
                  0) {
                return true;
            }
        }
        return false;
    }
    public boolean isObligationType(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor) {
        try {
            return getObligationByType(
                     edu.umd.cs.findbugs.bcel.BCELUtil.
                       getObjectTypeInstance(
                         classDescriptor.
                           toDottedClassName(
                             ))) !=
              null;
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                ).
              getErrorLogger(
                ).
              reportMissingClass(
                e);
            return false;
        }
    }
    public java.util.Iterator<edu.umd.cs.findbugs.ba.obl.Obligation> obligationIterator() {
        return classNameToObligationMap.
          values(
            ).
          iterator(
            );
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.obl.Obligation getObligationByType(org.apache.bcel.generic.ObjectType type)
          throws java.lang.ClassNotFoundException {
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.obl.Obligation> i =
               obligationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.obl.Obligation obligation =
              i.
              next(
                );
            if (edu.umd.cs.findbugs.ba.Hierarchy.
                  isSubtype(
                    type,
                    obligation.
                      getType(
                        ))) {
                return obligation;
            }
        }
        return null;
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.obl.Obligation getObligationByType(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor) {
        try {
            return getObligationByType(
                     edu.umd.cs.findbugs.bcel.BCELUtil.
                       getObjectTypeInstance(
                         classDescriptor.
                           toDottedClassName(
                             )));
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                ).
              getErrorLogger(
                ).
              reportMissingClass(
                e);
            return null;
        }
    }
    public edu.umd.cs.findbugs.ba.obl.Obligation[] getParameterObligationTypes(edu.umd.cs.findbugs.ba.XMethod xmethod) {
        org.apache.bcel.generic.Type[] paramTypes =
          org.apache.bcel.generic.Type.
          getArgumentTypes(
            xmethod.
              getSignature(
                ));
        edu.umd.cs.findbugs.ba.obl.Obligation[] result =
          new edu.umd.cs.findbugs.ba.obl.Obligation[paramTypes.
                                                      length];
        for (int i =
               0;
             i <
               paramTypes.
                 length;
             i++) {
            if (!(paramTypes[i] instanceof org.apache.bcel.generic.ObjectType)) {
                continue;
            }
            try {
                result[i] =
                  getObligationByType(
                    (org.apache.bcel.generic.ObjectType)
                      paramTypes[i]);
            }
            catch (java.lang.ClassNotFoundException e) {
                edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getErrorLogger(
                    ).
                  reportMissingClass(
                    e);
            }
        }
        return result;
    }
    public edu.umd.cs.findbugs.ba.obl.Obligation addObligation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                                               java.lang.String className) {
        int nextId =
          classNameToObligationMap.
          size(
            );
        slashedClassNames.
          add(
            className.
              replace(
                '.',
                '/'));
        edu.umd.cs.findbugs.ba.obl.Obligation obligation =
          new edu.umd.cs.findbugs.ba.obl.Obligation(
          className,
          nextId);
        if (classNameToObligationMap.
              put(
                className,
                obligation) !=
              null) {
            throw new java.lang.IllegalStateException(
              "Obligation " +
              className +
              " added multiple times");
        }
        return obligation;
    }
    public edu.umd.cs.findbugs.ba.obl.Obligation getObligationById(int id) {
        for (edu.umd.cs.findbugs.ba.obl.Obligation obligation
              :
              classNameToObligationMap.
               values(
                 )) {
            if (obligation.
                  getId(
                    ) ==
                  id) {
                return obligation;
            }
        }
        return null;
    }
    public edu.umd.cs.findbugs.ba.obl.Obligation getObligationByName(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                                                     java.lang.String className) {
        return classNameToObligationMap.
          get(
            className);
    }
    public edu.umd.cs.findbugs.ba.obl.ObligationSet createObligationSet() {
        return new edu.umd.cs.findbugs.ba.obl.ObligationSet(
          this);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e7DzWH2Y77fv57ePsCyb3WXZ/YAshivJ8kPqEsCWJVu2" +
       "JdmW/FJTLrLe1tN6WLLJQpYhhSETwqRLIFPYf0pKmxJImNJ2aMPQadJACZlJ" +
       "yrSQaSHJdBoSyhTaSdqElvRI9r2+9373+3Zhl94ZnSufx+/83ud3dH7nE98u" +
       "3BQGhaLv2Wvd9qJDNY0OF3blMFr7anjY6VX6UhCqCmFLYSiAuiP58V+//Jff" +
       "+4Bxz6XCzWLhfsl1vUiKTM8Nh2ro2StV6RUu72tJW3XCqHBPbyGtJCiOTBvq" +
       "mWH0VK9wx6mhUeFK7xgFCKAAARSgHAWovu8FBt2lurFDZCMkNwqXhXcUDnqF" +
       "m305Qy8qvOosEF8KJGcHpp9TACDcmv0eA6LywWlQeOyE9i3NVxH8wSL07Ife" +
       "es+nbyhcFguXTZfP0JEBEhGYRCzc6ajOXA3CuqKoili411VVhVcDU7LNTY63" +
       "WLgvNHVXiuJAPWFSVhn7apDPuefcnXJGWxDLkReckKeZqq0c/7pJsyUd0PrA" +
       "ntYthVRWDwi83QSIBZokq8dDbrRMV4kKrzw/4oTGK13QAQy9xVEjwzuZ6kZX" +
       "AhWF+7aysyVXh/goMF0ddL3Ji8EsUeGhawLNeO1LsiXp6lFUePB8v/62CfS6" +
       "LWdENiQqvOx8txwSkNJD56R0Sj7fZt/4/re7bfdSjrOiynaG/61g0KPnBg1V" +
       "TQ1UV1a3A+98Xe+XpAd+872XCgXQ+WXnOm/7/POf/u5bXv/o57+w7fPjF/Th" +
       "5gtVjo7kj83v/v2HiSfxGzI0bvW90MyEf4byXP37u5anUh9Y3gMnELPGw+PG" +
       "zw//7exnflX91qXC7XThZtmzYwfo0b2y5/imrQYt1VUDKVIVunCb6ipE3k4X" +
       "bgHvPdNVt7WcpoVqRBdutPOqm738N2CRBkBkLLoFvJuu5h2/+1Jk5O+pXygU" +
       "bgFP4U7wvKGw/cv/RwUZMjxHhSRZck3Xg/qBl9EfQqobzQFvDUgDyjSP9RAK" +
       "AxnKVUdVYih2FEgO941zCfLmNsTNbVPPzYSSMqVfH2Yj/P8/06QZtfckBwdA" +
       "EA+fdwM2sKC2ZytqcCQ/GzfI737y6EuXTsxix6eo8How6yGY9VAOD49nPZxL" +
       "h2DWw6tmLRwc5JP9WDb7VuJAXhawfOAT73yS/zudt7338RuAqvnJjYDZWVfo" +
       "2q6Z2PsKOveIMlDYwuc/nDwzfid8qXDprI/NMAZVt2fD+5lnPPGAV87b1kVw" +
       "L7/nm3/5qV962ttb2RmnvTP+q0dmxvv4ed4GngzYFqh78K97TPrM0W8+feVS" +
       "4UbgEYAXjCSgtcDBPHp+jjNG/NSxQ8xouQkQrHmBI9lZ07EXuz0yAi/Z1+RC" +
       "vzt/vxfw+I5Mqx8GT3Wn5vn/rPV+Pyt/bKskmdDOUZE73J/k/Y9+9ff+DM3Z" +
       "feybL59a7Xg1euqUP8iAXc4t/969DgiBqoJ+//nD/b/3wW+/52/nCgB6PHHR" +
       "hFeykgB+AIgQsPlnv7D82je+/rGvXNorTQQWxBhonpyeEJnVF26/DpFgttfs" +
       "8QH+xAbGlmnNlZHreIqpmdLcVjMt/T+XX4185r+9/56tHtig5liNXv/8APb1" +
       "r2gUfuZLb/1fj+ZgDuRsPdvzbN9t6yTv30OuB4G0zvBIn/mDR375d6SPAncL" +
       "XFxobtTcaxVyHhRyoUE5/a/Ly8NzbUhWvDI8rfxn7etU3HEkf+Ar37lr/J3P" +
       "fTfH9mzgclrWjOQ/tVWvrHgsBeBfft7S21JogH7lz7M/dY/9+e8BiCKAKIPV" +
       "OuQC4GzSM5qx633TLX/4r//NA2/7/RsKl6jC7bYnKVuHAhw90G41NICfSv03" +
       "vyWX7Z3JraC8J/cfGR4viwqli5zUKTIO+dj3AZyQakykADhcPcyHVq4GGRVu" +
       "Wkl2rALays/Luiz6Aw57nA3IJQcW3Ttm/+O3nv6rwlZ/AKgLrfLBbNY6eCo7" +
       "ha2ct8rMPi5WOB6gb6uR52Zq8rr//uQ9b/z43/9QPt0t6hafszHNdgHfalrt" +
       "ByLpOBA9kpnBM/jD7/vTP8zdwK15EAd6ZJi+BVCZwcjeb98rx5vSqPBaXjia" +
       "DGmBPBK4I16oCzRxRA055ohmwS+WII8YUmhzzWMp3pPTm+F8uI3D0kJauEq7" +
       "t1b/YP4ri+2fvPYCQmWB5d4HP/jXnD1/15/876u0PF86Loinzo0XoU985CHi" +
       "Td/Kx+99eDb60fTqFRYE4fuxpV91/uLS4zf/9qXCLWLhHnnH2JzLwDOKIKoN" +
       "j7kNdgFn2o+5vF2THj6/Xpya5vxqsV/JrxbSiSrel3GVAM/hThUPz6viQSF/" +
       "YfIhr8rLK1nx2lwGl6LCLX5grkC4BmwHWJ9k7xzz34C/A/B8P3syoFnFNsi6" +
       "j9hFeo+dhHo+CDYezDc6LMBa8PbBBXAQQM6vu7ac+XgeRqci5p83n/vyv/uL" +
       "y89sg9qzCpJvmnZDz4/72ldvKN0RXfmFXMtvnEthzrBbAVfDrGdUeOzaG7Ac" +
       "1tY73rEnv3Ax+fef8amHOdW+nx4bwl17wwfNWeVPAQa86nkYcCTTzhH/ma+9" +
       "p5or6OWVCZZkVRF2+8GzS9A+LHvqzB7xQhYdyd/81M9/4VV/Pr4/D/633MjQ" +
       "QoFTyf5Xd370htyP5loBEH71NRDeYZSvmEfyT3/k+1/+s6e//sUbCjeDYCZT" +
       "cikAgT/YWRxea898GsAVAbw1wSig/HdvRwPPkQt1J7z7TmpP4rKo8IZrwc4+" +
       "CZwP37Jdp+0latDwYlfJ7f2scd0OlpfTrbka3PnDqsE7QKzxAlh3QvnObjNL" +
       "BrK8e+9FSTd2TjcCC7uf6NV5/kiY9cmjcX1I1xs9MlewzPwOxhe44u3ycaKb" +
       "r35B+4G8t5wVes4Laz9HN3t181ryjDMv7CLRrCxlBZueWaQLJ4v08bJAn3Vi" +
       "bfDAO3Lhazix5BpOLHsdZMUwx4KPCveGQBzG7ktJ5pK2CjX+QaQKXPv1jBs0" +
       "Z5XvzJveesaSDnJiL50EOfIPO+0J99+Zc598wdxPn5f7OaPSgyxkKh3WDuHs" +
       "9/su5u8N2etPgMg9zD8unWH0yxe2fOV4PRirQQj058rCruU4nkOKf8FIhWcs" +
       "oee5+lM/918+8Lu/8MQ3gHfs7II8YC6nNJ2Nsw9df/cTH3zkjmf/6OfyHQdg" +
       "P//k/H++JYP6i9cjLSvef4ashzKyeC8OZLUnhRGTbxJUJaPs+lFLPzAdsJda" +
       "7b7iQE/f9w3rI9/8te1idj5EOddZfe+z7/ubw/c/e+nUd7Enrvo0dXrM9ttY" +
       "jvRdOw6fXmoumCUfQf3pp57+l//o6fdssbrv7FeezO/82n/4v797+OE/+uIF" +
       "nxRutIE0fmjBRi97S7sc0vXjvx5cJdCBPFZs1CrOh/2OP23Bgbao8FIprhA+" +
       "Tzh1x5FK9JTV14MWT6x6NS5lGWdYEn2z4pTKQWPgr5dtwjPpkTlbVTaQAUG0" +
       "2aHsLmcifZ8g2XrT8+iuSWIjbkarDWY6xXG4Blg5K41KTaSTbNhaH0XjYg1H" +
       "IwivRRsci61k0eswy2XaZSN7RKykYE421vOhF1vxuNcKZ0W/t06mPX+Tqnip" +
       "rbRakiV3NMbpdKNp9nXVQ+rIfFbi/ZnvMCNHWCrjtjT0jIaVLkdTtjvzlvFC" +
       "pCnTmPZbXc/sVtOpgHAyQ3RFQqEtZjJbLvn1Qh6GDRoOhbDDzFDYCZnNQrb4" +
       "BhI6tVBeyiuc3Kwwb6Nv6HXNDsf0rEjz0mjZFUXHTI1uNxX8dcd1XE+Ka6k9" +
       "UYYThxvy+JDFrZAj1HQ5q1PLYiUqMvGchcuwbEgw31k6DFxV2ZEeTcWSWR0M" +
       "fbkd18biMu2Zk6kF0eRSGzPichCV+UTS4fEi7BrNQAh7io33o8na4YuaxdQV" +
       "wefbC8MwxOpIMfmuNAoVksGacNNwfAfGqg1d8cbqxKPswchCVxuuRLea1Gaq" +
       "juGyNLScpqejhuIIswbNUkOvZbAdzvSjiShEfbjbcvkBazQRamABHYr4WiCO" +
       "whliTsYNqF6Zh002GHW4VVWju5W6CTtjR6xOJHXVbMWjvrQyF9S4pSvSBEGk" +
       "xmyEl+oYiZhmwkxZph6UNgNVZLr2UrLUccNsrtm5qhGNOhGt7XrJU9Wps2Q7" +
       "MNmSjNnSsxYztZX0xjAmGpI34ghHX4dL3RvFPELLjgAvDNazZq2KXqJpUUfs" +
       "DUMMhoZIdjYtZtYaUfrEqnTa/TVamuMoPihVpbE1WITcCLEpTdEIuNmrW0RT" +
       "odcSxaX1OitFPJ6YkVAtB+Vk4PQSnaFcpqh27KBSxbXIHRrYRE55alO0uemo" +
       "Y9kVIeKxSmUGR+PicGHHHh4MeoMJVaty8gR36n2lOwTCaUbcLC07zVFLSKpF" +
       "lqDGeIWarr0FO6X4Llj3WJ2tIoQQtEbscKlZxaVNCbPFQOmgnG/HNbOMUnxD" +
       "xTpDiTMjFA83XToUYslbdSO+Uis2hhOuXrftUb1Y7LLLWa1WnpOdlVHbmAQ5" +
       "ZqhmNW6KA2agQViRbndWA2YzcNZi15Hafpiw/FAzw1bblKlVp0QvZuTan/cW" +
       "4zBZV4bGtC0GXBp0RYVcl1AG8JVlBWmZQD4fLFAyrXYooTodt0imX66ti/yg" +
       "5EuKNdDpmeUOmpKhD5QIZkco67cTPa5Oa8g05heJNx7UuKQoC7Rq6wixjFoi" +
       "v1oGDZ/lx9SMHS+TrmeTxVZvI09Hhiw2px1KL8ZstYovyb7b7qcre2p7raC1" +
       "Wbj1eWddXRsqEdsbtNxfwH57XY6nNXQdK1xxMhMdkdE38wY/tunUc3mpXCSC" +
       "CunOXS7igb7IrV6bINdMEnecarPLzyLKDMMeNaoi/VHarrQqbphwDZKZC+NJ" +
       "v10laz4mr6ZTF/XJQDDLC1GrJjoZTXRSaWJ1Cq4A/4AORbhRosqtagXH+GJ7" +
       "jjuLuFxrUCVVxii9bgp8SCz9pgU8pqrA3apWs3R0JXHsytVj1iENXSoyQzsR" +
       "xpi21JqYStH8ZjTod6V5a+RS9Exrs5MNgbTVan+c9h1oUdMoojdZCGRHI2TR" +
       "Dh2oXFwEA6nUSUx8uIB7I4ZapO24vSCxIjRHtdUs3pQSy22KZWxGm+umh/UG" +
       "JYFFKQuJJ15tTtFdDOi+ojYWbA3HalMpDjeNhaKYxFwxSroaEuSgOw9Qtww7" +
       "qqoVq5yP+XJ/Ig+SGqv32nQsrIWSVfH4IdNZdmpurT5UPd3F68HErq2SeXU5" +
       "S/yRtbQlyoDmiLFZrxCoxGIeThJU21JZJCwyCQdD8iCuYFGrN7WhFjwaWk2G" +
       "jDd46ifLIhp39Jow7kuGtqJrU2RdlVWIRmGe1odlcbQShbmz6IhJ26hHEVnV" +
       "IJGtqi1Dr7XFELFtrQJpc5sXJzzmIf3VmIawcDkcQ3YMzZ3JGJdwKyINpB7P" +
       "LbRbhzxel3HPmQyZpIbzC00IJURiV/VQHCaE0dSdNuIU65q8qbFhS5mO+6hV" +
       "xfFwpZkd2e5NgIGMpiOv107MlJjz84nR1yduvzWZKJuSMo8CWipZ8xBDGYUY" +
       "LqRWcTzqt5SWEbTIensZuWvI4QmBMlGuq7dnI68lOTMrGoQNxedckUKcbpeY" +
       "pBFwq+XKusEue9BGiKA5Zg8WeH3MG+PAGoyLJVKscFHYiYmx55ZIqZIMag3c" +
       "FjrKYDMWcUwrpWGp3Xdbgx6iUOm0hkniguZmvOMK5cDyNzLHu6gbaOiCmE4h" +
       "beaidWSE1RJBjBucWm50U7q9wqXKes7AaeiKHtd2izNgl9zGld00kWrGmlPW" +
       "41pjFdUsiCwW2ekUEdGwNqypSACNrQm98FMNbTcm/qxcs3iaKlHoQJ/Kq+ZE" +
       "mSjM0ET9CNG4mOw5Cc72MQ1oJZX0uHkiDhecNmkJbcyWNyg6bcI1qCy1+mjQ" +
       "ETrtaZTK7LjeqhkoFIwRagKp3X7dd02dsKxyHSIW4TxaTfEhUrFCGfXgGcGW" +
       "Jl04bdDcsho2Vqt1kE6iZbAulSaW5A/gdTCbxaNNo1nGiZKDVUJvvLAcSLYk" +
       "h9bJmIBlZyM066VYsjlvFFjUHBOHyowS8OEEahkDjOdIEGr1B8p8rRhwqVXm" +
       "y62utRbqEy4VG8KYJiK+5OnNJj8e1MsddgHhuExxBjpCywk9NfpzZ6lTTpfs" +
       "izYzLpc3FlRtxpK0glDXJIF3pUSCHrrYqrrqN+vVOBCHlM9OjVHCtZu9uE8N" +
       "IqAmG7iLkQltGfVWT9UX0YItb7Bip9c2mra5XAClZGPBJKluBSWLi1mHhco0" +
       "VA8xCBu1S1i9qgY9rdxvl0ZysmRTftjTBjO+0+eolTlCivGwbuELJI7pCanz" +
       "2EC0i1AvXrFqwjJrpNgOlIaONvt9qlQMRQnRZrzQT7ROpSyXYVLuiaVudbIa" +
       "hhu01ek2Z30HFThZgJBAxxpYQG3IgDMHUVeQnVoD629KAHKxt5CKsi51LZTG" +
       "rHRdhSp2IBS5Etok7EG3bJmLtRlEvSWQark7rbYDvDxY+5wFcT2jlVbUohYP" +
       "Kbc6oDhhsQmxelBeQCweNgI/aXOMpvW0+VDkis3OptEpztvIOnaBua+WcLkL" +
       "1rwxjWGsrKxCqA1BihvLapdXxxZdNCuVBsO1aoQqiFJA9RZDpV5qtvB5feBh" +
       "60XSaMpVbY3HEwnlimwFl5ha12i1ymF/NpJHBLEqkS7bm/oTHmXc6kqZsWLd" +
       "UEm1Yix4bCzGlTbbo2alhuK6vfm0StUa3VpfTlgjqsxZta4ZJOvytqrLLcvj" +
       "ppvFwB1u/DadonPLhuUSjMya9TVpdNjhQBqMoQGSooMuGFqxihwWM6lSRlJs" +
       "xXdAoF2p1auJO7O0dQOfVrQIKHo7CIw0LqoOu1EHRdlSuxa3DH0b7DD6HDwd" +
       "pRMvZrRprI50FjfKbQq2pi0QCk1FXyQnRVan1wlK6nOjhJkmM4xiqFXxunIP" +
       "Ca3iZDNcj7AWpFFRa5O4JZiuxSMDi2sUrTH9aU1ZhARtB6lYX5s9QleHbKk7" +
       "7DWdGqFUWsmoRdFNpGgt0IZeamCM3CE31CZalUfM3JXMrsyVphWcTatLZEV3" +
       "cSSack7VUDqGisEM4c2gIAm7mMTYRkfvUYnYptpTO+ljS15qdisCcPvujJLn" +
       "7IwW6elILZaBs4DjFS74iTEtFZNVbdk2wOrThlA9VONVv504fodB7DigGv6Y" +
       "HeFSKk5SYqmiDotYMONWEBReFyG0KRXBIjZuF9M5a7F4A8VWvRTFdAR4DXsC" +
       "TTdD4HQEKlwvrF69mDDlxRquIWgf6hatIj9fu0Zj4vBJYzYO+0ijTdf9+oxx" +
       "JCcqGgFTDgZ1phvpJbVphw3O601qfKBMnISjxJlneq0Jx6TQUhZmddzAXJ+k" +
       "yoBYfuFONYjrWo2JqujVGW+JxtoXIrUpc1Nis5LSlS7xqsmXqE2f9xNTZbk6" +
       "qYQC1N9YNRUqUlaN4aue2bccGIXbwSqaKn2s4SkLM3UoZKC0NWLNxu3ZENoU" +
       "8ViU7DFHCv15Aq2K8lJRqxWk2w8ZujjpakN7VG425CnUopxhWqwOGF/R13SD" +
       "S5OpTkkykbQ2iFOq+wmi4rDfMIJBM8HHCEqE6LpoDEhcxxC4XI2nK1ftSRRb" +
       "TiZiRdZJtohMZhi0WJmqhrVcxubjZYXnxbgTzjC1h0mxEcuYs1m5G7GapqNm" +
       "s6WGZFpHDHM46E9RI6CDDT52go7v0AmqCnO12yI77Sq7kTHdRehwldoLKMHl" +
       "zqJSa3fMcj2US4nPwZzYkvtDrqeLM70ojvgZChEVc0ojqwHGFLsMtgwSRp2V" +
       "CBwlE49k+GlDXa/l8mZSJcrYpm0JmmqbaxdpzQb2Uq7Ok6HgztG2zS3L8arV" +
       "Llfr8z63jHRLRRvSpj9dyHAL4ef2rBXBIZouW0Ma03nWd/jlMJTTKaJYRZhv" +
       "Rh4VDEt+z0Nco203SG253rQXG09RFUtaNlQZ7CBL1JDg9OUQ6U2g3jyUCXw9" +
       "r6BgQQsh26IDeORW7GrXbgxrobNsbkSvEuGT8SiyZm6xgvSqFoMumxii8rY2" +
       "9yhZsypCUllj5WplNmWLfZp3kkl7yM6pVLG75XLMNSpyuTwtKxi1gYk5XubW" +
       "lbG+hiOKjrso3V3BdWvZSdEWHCT4cBiiYZuexfVAqDC+2pkSOFEMh4yz6loD" +
       "J1r2S56EixCkzouVhOTlpWDUtIrfGJW0zkQXVqkrcsAtlWKIbhM9rZIks6o4" +
       "C+gypUrrdkvpQyvIr43h9UrzKG1ijwLK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("T+Fyqz7CrFanUZTGcQWHqrJb9TUtIZFJkbItDWp0XQxsMVBI3njRkiQjFB6H" +
       "HjzQRhLVMcglT63F1cK3fVnyokVYZiJtA5s2H4xTbIy2kbS97s9EIJtpSZk5" +
       "eJxKKwEfIWY8CkU4xUKp6cHa2hWExmxSn5u2aZTWhrZpNVxNSFy7X9PICYGV" +
       "SqnpW21K072EhxO1qw6W/VFi9SO/XSqnjXCCkkyI283Iliss2EuM6ylsOCwh" +
       "knKHtUvkRnMYhFz5UTfC6wO5OKu2w0DoWD1hrYVVt4pyiTgCsuFIRq2Qg6Az" +
       "NIlIpGmXiud1l4xcvZwYw/LKD4QmVm6wpQG3EWEvhTsOLHY9coQaG2nSSmo1" +
       "ttdrVEsOozZ6vGaW2n55EZlwW7TwSXnZsJfNatXoLJBSY8NNGyS7dMklE49o" +
       "2ZM1yOFmUA9u6k0XNcarBqSsvR5MuRXUENQFoYe4nEqqiC1QoamMXKEHQem6" +
       "J3Ei3kfMMY0PTStSyr0Zg9f8SZtnZpPNyqrIDYgRhOJgsSCSpbCwFhWlaSJm" +
       "v5Zq63mrZbEuhtOTUbAWAlhsNcprWyaLtbG2qlGhuJxSbn3TE1ko6QyXQThT" +
       "9FHE1hqSahKD6QZvYwzY/rcVviokFKP1pSRyrCXnOsG6Wm2N9TkiYqG/HjXh" +
       "ogZDWmMMQzW7DzbFWHUao/LCtgOaxXh3hkpFcr5G8BbY+FLjWELxDRogG2Rj" +
       "VmZifxa2IsJEYLyT9HU62Yzc0aSxqDhhtEpQQYbkUHPpMhQu3bKASQuw82KH" +
       "UuQpuF+hkbXSi0yZntOxNgm6fTyyETcwoFoZhipImpIooYMIrQx1Z3ixxrnl" +
       "lcitXKwEWV243pTqFchok4iNSnRn4gosjowgfSz20BVhdDnfm9prw1mBnXoQ" +
       "tMc1l+STlICteqDjri2kCW7ILtyPdahsk7VSazaWJXqJzdHeckXAuDoioVW5" +
       "CpXxlQ3V8X5Tidc1pl6vZ59S/8EP9jX73vwj/UlC5Q/xeT69eMKDfMJ9Kk/+" +
       "d3PhXFreqZOcM2cWYVB45FqZk/l36o+969nnFO5XkEu7A47nosJtkee/wVZX" +
       "qn0K1B3XP2Fm8sTR/XH+77zrzx8S3mS87QfIQnvlOTzPg/zHzCe+2HqN/IuX" +
       "CjecHPZfldJ6dtBT504hAzWKA1c4c9D/yAlnL2ccuwKep3acfer8GdlemtcS" +
       "Uy7k66QdffY6bf8qKz4TFV6mqxEjpfvDwjx3LR/yy6eU6KNR4QZzlwSdK9c/" +
       "e74jgtMT5hWfPqH9/qwSAs+bd7S/+aWh/WDfgcw7fPE6DPhSVvxWVHj4JF2a" +
       "dldZYnR46uD0Ij7cMvc8W5XcPS9++8Xy4gnwDHa8GLykvDg+53zDRQfF+alk" +
       "lp+7NdOmGsqB6UdekEP86nWY95+y4t9HhXvM8KzmZPVf3nPmKy+CM49llSXw" +
       "HO04c/TSW8h/vU7bN7Pij6PCfd4JhXSk5nmQL/Ds+cH9IfDxyKsOoO/bH0Af" +
       "98lavv2SnEJfD4FsbH4U/e3zR9H+uaPovTj/5EWIM3d4j4PH24nT+5Eo+uNe" +
       "oB9KviQb6uFcVu1DPUtpMuVd5kSmozmY718fzGP7g+htyoEXUVlCCZnKqp+p" +
       "QgbkIE9U+KuocD9wons7aKyPLcHfs+6vz7LugrTJR/Ik8VOJkoeEocoW5QVs" +
       "bNvXWcpfOOvfvWP9u19S1mc/v5bz495rm9PB/Vlx5wvh1cFd1+RV1nrri2FF" +
       "nuqJgudDO1Z86EeihY9eIy9nug0ZcoY8eh1mPZ4Vr4gKPw6YlQcuKjDf82v0" +
       "tXO6QIyUJ8Bu0xCe+4dP/N47n3vij/Ps31vNcCwFIGa94JrLqTHf+cQ3vvUH" +
       "dz3yyTxD/iT57vbz94Ouvv5z5lbP6cyrwvZ+R+EBwKZ3bXm//R8Vxi/Z7Yvp" +
       "uXsdPyLI6V5hzws/y4w4eO0uwemgeLEi5X4jj+tPQvqbbdXVtzdiPpeNfM1u" +
       "icjgX9oOOlau+0/7Js9Vs/Sz47btXQ/TOzy5FAYa0wsx/fQW03yyLZpZ8U+e" +
       "Z8k8wK7T9reyohIVbpIzvLZkXKf7T6YHe6N/6EWsLQ9klVkQ9fGdVX/8JXdw" +
       "eUB5QF2HmnZW1KPCXZKi7E31nGtrvFgqXwue39hR+RsvOZWfyykZXodKISsY" +
       "sAU958Zp5Rylz5sv+HyUPgmez+4o/eyPSJ5vvQ6lb8uK2dULFrvb452iVXwR" +
       "tL4iq3w9eD63o/VzLw2tp0lZXKctuzdwoAIy5UCVInVPKa9Gx17lJ15Qmunx" +
       "gJwl2g/CkhTo01XX17I08wevui67veIpf/K5y7e+/LnRf9yuT8fXMG/rFW7V" +
       "QLB0OtP+1PvNfqBqZs6t27Z593kYfBBHhYeuTSHY+YIyw/kg2vYH6D5wcf+o" +
       "cAmslae6vh0w9oKuEcBz93q69zuiwu373gCYfKb5GbD53DUDpEB5uvHdoAo0" +
       "Zq8/myuOu/OuV4fx9z2fbE590HnimsnoTLy95nwkf+q5Dvv271Z/ZXstDWww" +
       "NpsMyq0gGtjekNtFA+ez5k9DO4Z1c/vJ793967e9+vgT0d1bhPc2cAq3V158" +
       "JYd0/Ci/tbX5Fy//p2/8+HNfz5NH/x/AjSBbfT4AAA==");
}
