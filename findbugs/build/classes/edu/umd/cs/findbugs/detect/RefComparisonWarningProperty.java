package edu.umd.cs.findbugs.detect;
public class RefComparisonWarningProperty extends edu.umd.cs.findbugs.props.AbstractWarningProperty {
    private RefComparisonWarningProperty(java.lang.String name, edu.umd.cs.findbugs.props.PriorityAdjustment priorityAdjustment) {
        super(
          name,
          priorityAdjustment);
    }
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      SAW_CALL_TO_EQUALS =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "SAW_CALL_TO_EQUALS",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        AT_MOST_LOW);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      PRIVATE_METHOD =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "PRIVATE_METHOD",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        AT_MOST_MEDIUM);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      COMPARE_IN_TEST_CASE =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "COMPARE_IN_TEST_CASE",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        AT_MOST_LOW);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      COMPARE_STATIC_STRINGS =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "COMPARE_STATIC_STRINGS",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        FALSE_POSITIVE);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      DYNAMIC_AND_UNKNOWN =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "DYNAMIC_AND_UNKNOWN",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        RAISE_PRIORITY);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      STRING_PARAMETER_IN_PUBLIC_METHOD =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "STATIC_AND_PARAMETER_IN_PUBLIC_METHOD",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        RAISE_PRIORITY);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      STRING_PARAMETER =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "STATIC_AND_PARAMETER",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        NO_ADJUSTMENT);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      STATIC_AND_UNKNOWN =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "STATIC_AND_UNKNOWN",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        LOWER_PRIORITY);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      EMPTY_AND_UNKNOWN =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "EMPTY_AND_UNKNOWN",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        NO_ADJUSTMENT);
    public static final edu.umd.cs.findbugs.detect.RefComparisonWarningProperty
      SAW_INTERN =
      new edu.umd.cs.findbugs.detect.RefComparisonWarningProperty(
      "SAW_INTERN",
      edu.umd.cs.findbugs.props.PriorityAdjustment.
        LOWER_PRIORITY);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze2wUxxmfO+MnNn7wLA8HjAnlkVsoL1FDwnE+w5Hz+eKz" +
                                                              "TTEtl7m9OXvx3u6yO2ufTdMmVFVoK0W0EELThr+IIiESUNv0pSaiitqmShqV" +
                                                              "JG2TVqVV/0qVogZVTarS1zeze7d761sQ90ct7dww88033+97zTfDpRuo1tBR" +
                                                              "J1FoiE5rxAhFFZrEukGyERkbxhCMpcWnavDfjryX2BlEdaNo3jg2+kVskD6J" +
                                                              "yFljFK2QFINiRSRGgpAsW5HUiUH0SUwlVRlFCyUjltdkSZRov5oljGAE63HU" +
                                                              "jinVpYxJScxmQNGKOEgicEmEsHe6J46aRVWbdsiXuMgjrhlGmXf2Mihqix/F" +
                                                              "k1gwqSQLccmgPQUdbdBUeXpMVmmIFGjoqLzNVsGB+LZZKui60vrhrVPjbVwF" +
                                                              "87GiqJTDMwaJocqTJBtHrc5oVCZ54xj6HKqJo7kuYoq648VNBdhUgE2LaB0q" +
                                                              "kL6FKGY+onI4tMipThOZQBStKmeiYR3nbTZJLjNwaKA2dr4Y0K4sobVQzoL4" +
                                                              "5AbhzFNH2r5Vg1pHUaukpJg4IghBYZNRUCjJZ4huhLNZkh1F7QoYO0V0CcvS" +
                                                              "jG3pDkMaUzA1wfxFtbBBUyM639PRFdgRsOmmSFW9BC/HHcr+V21OxmOAdZGD" +
                                                              "1ULYx8YBYJMEguk5DH5nL5kzISlZiu7xrihh7H4QCGBpfZ7QcbW01RwFwwDq" +
                                                              "sFxExsqYkALXU8aAtFYFB9QpWurLlOlaw+IEHiNp5pEeuqQ1BVSNXBFsCUUL" +
                                                              "vWScE1hpqcdKLvvcSOx64riyXwmiAMicJaLM5J8Lizo9iwZJjugE4sBa2Lw+" +
                                                              "fhYveulkECEgXughtmi+99mbezZ2Xn3VollWgWYgc5SINC1eyMy7tjyybmcN" +
                                                              "E6NBUw2JGb8MOY+ypD3TU9AgwywqcWSToeLk1cGfHnr0Ink/iJpiqE5UZTMP" +
                                                              "ftQuqnlNkom+jyhEx5RkY6iRKNkIn4+heujHJYVYowO5nEFoDM2R+VCdyv8N" +
                                                              "KsoBC6aiJuhLSk4t9jVMx3m/oCGE6uFDzfCtQNYf/6VIEcbVPBGwiBVJUYWk" +
                                                              "rjL8hgAZJwO6HRdy4EwZc8wQDF0UuOuQrCmY+awgGs5kllBYJoBJIgAK65Kh" +
                                                              "KgexDjzHgCWPjBBbrP3fdywwHcyfCgTAPMu9yUGGuNqvylmip8Uz5t7ozRfS" +
                                                              "r1mOx4LF1h5FO0CAEAgQEo1QUYCQJUDodgKgQIDvu4AJYrkEGHQCUgPk5uZ1" +
                                                              "qc8cePhkVw34ojY1B6zBSLvKzqiIkz+KST8tXu5omVl1ffMrQTQnjjqwSE0s" +
                                                              "syMnrI9BMhMn7HhvzsDp5RwiK12HCDv9dFUEVDrxO0xsLg3qJNHZOEULXByK" +
                                                              "RxwLZsH/gKkoP7p6buqxkc9vCqJg+bnBtqyFlMeWJ1m2L2X1bm++qMS39fH3" +
                                                              "Prx89hHVyRxlB1Hx/Jy1kmHo8nqGVz1pcf1K/GL6pUe6udobIbNTDJEISbPT" +
                                                              "u0dZYuopJnmGpQEA51Q9j2U2VdRxEx3X1SlnhLtsO+8vsKMWfRy+Tjt0+S+b" +
                                                              "XaSxdrHl4szPPCj4IbI7pT3zzht/3sLVXTxvWl2FQorQHleOY8w6eDZrd9x2" +
                                                              "SCcE6H5/Lnn6yRuPH+Y+CxSrK23YzVorJjCo+YuvHnv3D9cvvB10/Jyiek2X" +
                                                              "oHIihRJKNoHm3gYlbHevIxAkSRnCj7lN97ACDirlJJyRCYusf7Wu2fziX55o" +
                                                              "sxxBhpGiH228MwNn/GN70aOvHfmok7MJiOyQdpTmkFmZf77DOazreJrJUXjs" +
                                                              "zRVf/xl+Bs4QyNuGNEN4Kg5yJQQ58iVQs/GV7DwOWedxcWJjpayjQWph7imp" +
                                                              "ukSnw9mjpkHzEJfcB7bxpZt4u5Wpj++E+FwPa9YY7lgqD1dXaZYWT739QcvI" +
                                                              "By/f5NjLazu36/RjrcfyVtbcWwD2i725bj82xoFu69XEp9vkq7eA4yhwFKGg" +
                                                              "MQZ0yLyFMkezqWvrf/vjVxY9fK0GBftQk6zibB/mMYsaIViIMQ5Ju6A9sMdy" +
                                                              "lakGaNo4VDQL/KwBZq57KjtCNK9RbrqZ7y/+zq7nzl/nTqtZPJbx9U3sHClL" +
                                                              "0vyG4OSJi2/t+NVzXz07ZdUY6/yTo2fdkn8OyJkTf/rHLJXztFih/vGsHxUu" +
                                                              "fXNp5P73+XonP7HV3YXZZx/keGftJy7m/x7sqvtJENWPojbRrshHsGyyqB+F" +
                                                              "KtQolulQtZfNl1eUVvnUU8q/y7250bWtNzM6Zy70GTXrt3iS4RJmwo3wddtp" +
                                                              "YrU3GQYQ7/TzJWt5u54193Hz1VC4YJgZuKdBx+C1PwUxJAXLnly0uMi8wiYA" +
                                                              "OhU+mI6E4/H00EA6+tBwOJ4qxm211YKVxVm7izUJS54HfJ18X7lSBPuUYH9r" +
                                                              "fZQy6qMU1n2INYOsSVXQxFofzhTNSw7GRsJD0XR/dGj/QC8bHfFAOXyXUHpt" +
                                                              "G7O/DT5QMlVD2eDDGSqcyEB/MjwYTccS6aFoaggMnIpWAiTeJaAYfJvsbQUf" +
                                                              "QEerBiT4cIYTqwgoNRQeikXgZzCW2JeqBGniLiH1wbfV3niLDyS9akhbfDhT" +
                                                              "NL/3UCLcD1jCid70cOLBxMDBRCU8xl3i+RR8O+xdt/vgmakaz3YfzhStsmyS" +
                                                              "BjOFIYKig8z5ksN74wDRP6KO3yW6EHyftGXY6YPuRNXodvpwhuLGi64SmC9U" +
                                                              "kenut7fc7QPmy1WD2e3DmeV8K4ru4HlfqcI2YXvTPT5wvlY1nD0+nClqj/Yn" +
                                                              "hw7dCc3pKowTtffs9UHzdNVoen04U9TEDuRYAlysIoxv3AZGobI4AS6OIwT/" +
                                                              "q0OeJxSXEK4qEbFSeIXfKxd/obtw4sz57MCzm606saP85SiqmPnnf/3v10Pn" +
                                                              "/vjzCg8SjVTV7pPJJJHL9oR663YFBit8l8x6H7Xe9MQXzrc2LD4//Bt+vS29" +
                                                              "uzXDxTBnyrK7NHP16zSd5CReojVbhZrGf56naKl/FQSVl9Xhwl+yllyB1F5h" +
                                                              "CYX97a6b+ttgcIeaoqBYNv1duGHa0xTVQOue/AEMwSTr/lArFm2b/S9b4YxB" +
                                                              "dbh9eLRZCJTbu+RqC+8UMS4XWV12PeBP3LZh+k3rkTstXj5/IHH85vZnrQu8" +
                                                              "KOOZGcZlbhzVW28JpWeSVb7cirzq9q+7Ne9K45qgfStstwR2gmWZ68oIYRzQ" +
                                                              "mNMs9Vxuje7SHffdC7te/sXJujfBSQ+jAAYjHp59HShoJkTD4bhzbXL9Fwm/" +
                                                              "dfese3r6/o25v/6OX7iQ9Ra23J8erjun34ldmfhoD39TrQWLkQK/p/ROK4NE" +
                                                              "nISbYoOpSMdMEsvG0Tzmz5hdrrkebPW1lEbZcw9FXbNetSs8ksFldIroe1VT" +
                                                              "yTI2LXBXc0bK3trtGGkyNc2zwBkpmW7BbKxpsfdLrT861VHTBzFZBsfNvt4w" +
                                                              "M0PFy5L7+Z0PcDu2WSnsv/AXgO8/7GNGZgPsF062iP0UvbL0Fg23XmuuJh3v" +
                                                              "1zSbtmFYs0Lmdda8UWDDFAXW26OsIAw4yfMa3/6XvMuat/4Hv3SLyIkbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fl1DBnrQpgbNqeiteSSBC+kasVMTtpl1wI8JMW7OKj7eNsniJulVRzShleGg" +
       "QLHpIi0ivDzj6nDCOGVVNuzGKCEMRoU9nCQWadDVVvCm5+PxLFQXgHvHSKWw" +
       "cOwxgrMVbsHzMWwoPTUgEsSCY8RfbwICo+ZjRxennr/C/V6SrNFCdxBMHDM0" +
       "JwGvUmZJmbEbezZrrOEE2KkozgMqHdb5BCn2mIUXVDS6OiWsyKlEshy4nDer" +
       "9CbcBIGZlJgHtbBWLTUreFpi21WOWPLhQEbjQrs0BuEP0VqQtpkUw6HWiDSu" +
       "NVrNCla/jlVhvFjEWvVCgEYjorqOrXKpxA3YmLUQLZ0RdK2Kq0SpsUBMGh2H" +
       "Mw5veio/Serr4axkl/sUN/JpdjGJu46arhiKjpDe1Cc6xcUUlns6PGk3RFzt" +
       "tkaLZDHD3aCHjOAOU5sMTbZTVjqdHr2WEgyFh3rEMZJE14WuIyyXQ7vvzlsa" +
       "oxBCi1OJjS9OZuoEUzxUY6pSn2PW0dKhphNFMxZLPm3Py4SyRnu2Rmp4KRJV" +
       "tgKynYRuCsZKVDsAGAlXZm1S6pT0tiYjRWlEovGwg07bs0ZsVrTCdNoYFWI5" +
       "gDdLSzCEtMIBfejAtxIa1UfdPjfQlo20ZvgUUo0603F9MKok8zqGJ2rQW3B1" +
       "bhxOqYUjb9xoFZI9rV6lrXZzZih2GCCqhEzGVlKaA50rHUthG4OqF1ZxU11L" +
       "/TK32DBjphZtTK5kd4oFu22udZizVxEit6WKO3AiJlBVvznDU5liHcUuVmdN" +
       "BuuEU65lJn7fiTeVFt8DTFlt0fVRP2LgdXGkEDG9wAbVNSZ2aaW/UAexDDti" +
       "EAH+qyHDdmrVi3VfGDdqtLa2xratwpVNqTi2wZJL28sGrbMMi7hjgiBwsulM" +
       "6/UKiDu0oGE24jqOLJTmcLJIPalMdqowjAaFDV1uhumiEzOonXgDhMLHpXpK" +
       "y7X2VHF0VlzxXk+t1W1hYMLdCc2azcUqMguJaSZoqVtbtblFExHqYiEIllJf" +
       "EZw1ylGbkhz2cKEYM+xkFCpwCxtGNOPBZsvrWmURpptilYtRWVw1FXLKtwlG" +
       "DAvTdbvQmA3p6mLOlspjBR1XSH5VMCqewfjBQq/BfRxv1Da87U3CxmA04nsS" +
       "b4LIkJ2XG4Q7V2hWRCTNS9fNdQGhlOagWlsvVeAOQTQtL605X284fW6aTixq" +
       "6DfZONQVhMZVVW4jgQL7CyLUVZSeFPRWi9Nxt9bE6ZUD6KNTBYOIC7LZjSxY" +
       "VhVfqXh12CnXNnB9tEC0SXMqlCtEQ/H00K5UTdlSV06n0mS8yZw0JgPYhaej" +
       "QZXCbPA05JyRSw/lIeZvekUmtdLaSvY8QxHH85KJibwUNbsLkVIC2m8YfteU" +
       "+56jlFgmYfpl8BBfSEVxUAm8oNczEkoqpxFquNYcQcVB7PqqTHpMo15icQZN" +
       "uzzqq9QmqEbD4rib1EikwBfHUicsz2nb38CtxXLUgJEe1eOXY79brJe1cXG2" +
       "Eclid1muLKwwJFbAt1JaDKwu5xdJS5aFxmze6XRbi3m5PgIvbFE1UYdCBa4v" +
       "NsNQCOAqvqnQZNI3RPAW947s9e43zrnLkm8cHH4j8Tq2DOIbD3ghH/Do7C2/" +
       "LkKnTtqP7b4cO0KBsvfnB8/6GCJ/d/74B55/UR59orSzf/T06wF0W+C4P2Eq" +
       "G8U80VUAPfBqh9HZwdp9r/g6ZvtFh/SZF6/ceu+Ls7/Oz2MPv7q4jYRuVUPT" +
       "PH5ycSx/0fUUVctR3bY9x3Dzny8E0P1nn5gH0MVtJgf/u1uR3w+gu28gEoDx" +
       "97PHW38xgC4ftQ6gHelE9UsBdGm/OoBuAunxyi+BIlCZZf/YPTgdLJ19OtgS" +
       "/cATpOCUNeMLJ6fx0IOuvdbexLGZf+zEvk7+gdP+xAzD7SdOe9JnXySo975c" +
       "/8T2xFkyhTTNermVhC5tD78Pz/UfObO3g74u4o//4M7P3faWA1+6cwv4aA0c" +
       "w/bmG5/uYpYb5Oex6e/d+ztv/80Xv5HvfP0vg9+qwnkmAAA=");
}
