package edu.umd.cs.findbugs.detect;
public class StaticFieldLoadStreamFactory implements edu.umd.cs.findbugs.detect.StreamFactory {
    public java.lang.String streamBaseClass;
    public java.lang.String className;
    public java.lang.String fieldName;
    public java.lang.String fieldSig;
    public StaticFieldLoadStreamFactory(java.lang.String streamBaseClass,
                                        java.lang.String className,
                                        java.lang.String fieldName,
                                        java.lang.String fieldSig) { super(
                                                                       );
                                                                     this.
                                                                       streamBaseClass =
                                                                       streamBaseClass;
                                                                     this.
                                                                       className =
                                                                       className;
                                                                     this.
                                                                       fieldName =
                                                                       fieldName;
                                                                     this.
                                                                       fieldSig =
                                                                       fieldSig;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.detect.Stream createStream(edu.umd.cs.findbugs.ba.Location location,
                                                          org.apache.bcel.generic.ObjectType type,
                                                          org.apache.bcel.generic.ConstantPoolGen cpg,
                                                          edu.umd.cs.findbugs.ba.RepositoryLookupFailureCallback lookupFailureCallback) {
        org.apache.bcel.generic.Instruction ins =
          location.
          getHandle(
            ).
          getInstruction(
            );
        if (ins.
              getOpcode(
                ) !=
              org.apache.bcel.Constants.
                GETSTATIC) {
            return null;
        }
        org.apache.bcel.generic.GETSTATIC getstatic =
          (org.apache.bcel.generic.GETSTATIC)
            ins;
        if (!className.
              equals(
                getstatic.
                  getClassName(
                    cpg)) ||
              !fieldName.
              equals(
                getstatic.
                  getName(
                    cpg)) ||
              !fieldSig.
              equals(
                getstatic.
                  getSignature(
                    cpg))) {
            return null;
        }
        return new edu.umd.cs.findbugs.detect.Stream(
          location,
          type.
            getClassName(
              ),
          streamBaseClass).
          setIgnoreImplicitExceptions(
            true).
          setIsOpenOnCreation(
            true);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ya2xUxxWeXT8xBj941oANZnkZshvaQEpNCHhjB5P1QzZB" +
       "ytKyzN47u3vx3Xsv986116ZpE6Qo9E9ECBD6iPuHKCqiCX3QUqmJqKI2idJW" +
       "Spq2SavQqv2TNkUNqppUpa8zc993d03pj1q6s+OZc86cc+bMd87MxeuoztBR" +
       "J1FonE5rxIj3K3QU6wYRkzI2jP0wlhGersF/OfTe8I4oqk+jhQVsDAnYIAMS" +
       "kUUjjVZJikGxIhBjmBCRcYzqxCD6JKaSqqTREskYLGqyJEh0SBUJIziA9RRq" +
       "w5TqUtakZNAWQNGqFGiS4Jok9oSne1OoWVC1aY98uY886ZthlEVvLYOi1tQR" +
       "PIkTJpXkREoyaG9JR5s1VZ7OyyqNkxKNH5G32S7Yl9pW5oLuSy0f3jxZaOUu" +
       "WIQVRaXcPGOMGKo8ScQUavFG+2VSNI6iz6GaFJrvI6YolnIWTcCiCVjUsdaj" +
       "Au0XEMUsJlVuDnUk1WsCU4iiNUEhGtZx0RYzynUGCY3Utp0zg7WrXWstK8tM" +
       "PLM5cfrpQ63frEEtadQiKeNMHQGUoLBIGhxKilmiG3tEkYhp1KbAZo8TXcKy" +
       "NGPvdLsh5RVMTdh+xy1s0NSIztf0fAX7CLbppkBV3TUvxwPK/q8uJ+M82LrU" +
       "s9WycICNg4FNEiim5zDEnc1SOyEpIkVdYQ7XxtgDQACsDUVCC6q7VK2CYQC1" +
       "WyEiYyWfGIfQU/JAWqdCAOoUdVQVynytYWEC50mGRWSIbtSaAqp53BGMhaIl" +
       "YTIuCXapI7RLvv25PrzziWPKXiWKIqCzSASZ6T8fmDpDTGMkR3QC58BibO5J" +
       "ncVLXzwRRQiIl4SILZrvfvbG7i2dV1+1aFZUoBnJHiECzQjnswvfWJnctKOG" +
       "qdGoqYbENj9gOT9lo/ZMb0kDhFnqSmSTcWfy6tiPHnrkAnk/ipoGUb2gymYR" +
       "4qhNUIuaJBP9fqIQHVMiDqJ5RBGTfH4QNUA/JSnEGh3J5QxCB1GtzIfqVf4/" +
       "uCgHIpiLmqAvKTnV6WuYFni/pCGEGuBDffCtRdYf/6VISRTUIklgASuSoiZG" +
       "dZXZbyQAcbLg20IiB8GUNfNGwtCFBA8dIpoJsygmBMObFAkFtoR1mDhkplQs" +
       "QnwRXBzALP6n44xZ+7+vWGI+WDQVicD2rAyDgwznaq8qi0TPCKfNvv4bz2de" +
       "twKPHRbbexTdDQrEQYG4YMQdBeKWAvG5FECRCF93MVPECgnY0AmABsDm5k3j" +
       "n9l3+ER3DcSiNlULu8FIuwM5KunhhwP6GeGF9gUza65tfTmKalOoHVYyscxS" +
       "zh49D8oIE/Z5b85C9vKSyGpfEmHZT1cFsEon1ZKJLaVRnSQ6G6dosU+Ck+LY" +
       "YU5UTzAV9UdXz009euDzd0ZRNJg32JJ1AHmMfZShvYvqsTBeVJLb8vh7H75w" +
       "9mHVQ45AInLyZxkns6E7HBlh92SEntX4cubFh2Pc7fMA2SmGkwig2RleIwBM" +
       "vQ7IM1saweCcqhexzKYcHzfRgq5OeSM8ZNt4fzGExXx2UjfA90n76PJfNrtU" +
       "Y+0yK8RZnIWs4EnknnHtmbd/+odPcHc7+abFVyiME9rrwzgmrJ2jWZsXtvt1" +
       "QoDu3XOjT525/vhBHrNAsbbSgjHWJgHbYAvBzY+9evSd31w7/1bUi3MKSd7M" +
       "Qq1Uco1k46hpDiNhtfWePoCRMpw+FjWxBxWITykn4axM2MH6R8u6rZf/9ESr" +
       "FQcyjDhhtOXWArzxj/WhR14/9FEnFxMRWI72fOaRWcC/yJO8R9fxNNOj9Oib" +
       "q774Cn4GUgjAtiHNEI7EtdwHtdzy5VCycU6WjuNWOmbj272Gb+42Tn0nb+9i" +
       "juEyEJ/bwZp1hv+QBM+hr+bKCCff+mDBgQ9eusGtChZt/pgYwlqvFYasWV8C" +
       "8cvCILYXGwWgu+vq8Kdb5as3QWIaJApQqRgjOkBqKRBBNnVdw69+8PLSw2/U" +
       "oOgAapIBMS2shCQHp4AYBUDjknbvbisIphqhaeWmojLjywbYRnRV3uL+okb5" +
       "psxcWfbtnc/NXuPRqFkyVtg7AgkigL4c1D0AuPCzu3/+3JNnp6ziYVN11Avx" +
       "Lf/7iJw9/ru/lbmc412FwibEn05c/EpHctf7nN8DHsYdK5UnNQBvj/fjF4p/" +
       "jXbX/zCKGtKoVbBL7QNYNtlxTkN5aTj1N5TjgflgqWjVRb0usK4Mg55v2TDk" +
       "eckU+oya9RdUQrlu+GI2AMTCKBdBvPMAZ9nAms3l8FGNG8Lb4Km5D7IiLzfd" +
       "I7aIdz/FmpQVEPdUjb/+oL4r4Vtvr7i+ir5jc+pbjZvCTjMth23XhTUd/x80" +
       "3WivtbGKpg/NqWk1btCUX2mqaZq+TU1XwNdjr9VTRdPDc2pajZuiRq7puJSv" +
       "pCieQ9FSpQX5Xz0K1dT+nOWhS8TB+41z1pK+4pFh7qpq9yR+xzt//PSsOPLs" +
       "VguQ2oN3j364Wn/9F//8cfzcb1+rUNLOo6p2h0wmiRxQEpYMQOAQv0J6ePLu" +
       "wlO//14s33c7tScb67xFdcn+7wIjeqqjaliVV47/sWP/rsLh2ygju0LuDIv8" +
       "2tDF1+5fL5yK8vuyBXRl9+wgU28Q3pp0Qk1d2R8AubVuxLSzAOmEzw4x67e8" +
       "lOPBxtse1txh7Q7rxiuUTNWEhYqGUOHRVSkQszieUgXPj0DXrer5OIa7f4HE" +
       "swKR43l2XZWEuJUS3LIVSDdUI3VyzKiqynDbdei3V1FhjPBiFA5BSlUnTG0A" +
       "SzLU4kksy1kIMu6kY3OURI+xxqSoWYDzRIl1rJxF19zyAHqQMBmEhGYXEtzj" +
       "3O6VbyMQy7okkjlQ5L8pYthAUitBip3raslqneVlb13W+4zw/GxL47LZB3/J" +
       "T6n7htIM5y1nyrI/G/v69ZpOchL3X7OVmzX+c4qijuoug1Le6nBDnrRYzlC0" +
       "qAILx1+r66c+R1GTR01RVAhMf5miBnuaohpo/ZOzMASTrPtVrUJJbcVoKeID" +
       "OdvnfH+X3Co3uSz+uw6DJv4a6cCIab1HwtV8dt/wsRvbn7XuWpDAZ2aYlPkp" +
       "1GBd+1woWlNVmiOrfu+mmwsvzVsXtYO6zVLYA4gVvohPQkhqLCY6QhcRI+be" +
       "R945v/Oln5yofxOywUEUwbBHB8sLvJJmQg44mPKygO81m9+Qejd9aXrXltyf" +
       "f81LaDtrrKxODwXsU28PXpr4aDd//qqDCCAlXnneN62MEWESav9GU5GOmmRQ" +
       "TKGFLFwxuwi5VRq4b4E7ym7mAEplD5AV3jPgejFF9D7VVEQOxpAmvJHAs6iD" +
       "3qamhRi8EXfrFpfbmhHu+0LL90+21wzAkQuY4xffYJhZNzP4X0q9VNFqofu/" +
       "4S8C37/YxzaZDbBfAJyk/Wq42n02hHuMNVeTSQ1pmk1bc0WzTsQ3WPOtEhum" +
       "KNJjjzLMiXh55Tt8+cu8y5or/wFjzGldNBkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3veZ13/s+a/lx67/Bypfp/6BJAAA");
}
