package org.apache.batik.css.parser;
public abstract class AbstractDescendantSelector implements org.w3c.css.sac.DescendantSelector {
    protected org.w3c.css.sac.Selector ancestorSelector;
    protected org.w3c.css.sac.SimpleSelector simpleSelector;
    protected AbstractDescendantSelector(org.w3c.css.sac.Selector ancestor,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          );
        ancestorSelector =
          ancestor;
        simpleSelector =
          simple;
    }
    public org.w3c.css.sac.Selector getAncestorSelector() { return ancestorSelector;
    }
    public org.w3c.css.sac.SimpleSelector getSimpleSelector() {
        return simpleSelector;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYa3AUxxGeO72FnrwjQIAslCDwnQnGFBEhFmcwwqdHSZiq" +
       "SImPub05aWFvd9idk07yA0PZMZVUUQ5ghzzgT3AeFLFdqbiSPyakUontchwX" +
       "xJXYpuI8/CeJTZX5EcsJeXXP7t7u7T0o/4qqdm40090zPd39dc9cvE5qLJN0" +
       "caqnaETMcmZFRrA/Qk2LpWIatax9MJpQvvynU0fmf9NwNExqx0nLFLUGFWqx" +
       "3SrTUtY4WaXqlqC6wqwhxlLIMWIyi5nTVKiGPk6WqNZAhmuqoopBI8WQYD81" +
       "46SdCmGqyaxgA44AQVbH5W6icjfR/iBBX5w0KQaf9Rg6ChhivjmkzXjrWYK0" +
       "xQ/SaRrNClWLxlVL9OVMsoEb2uykZogIy4nIQW2LcxB741uKjqHr+dYPbz45" +
       "1SaPYRHVdUNIFa1RZhnaNEvFSas3uktjGesweYRUxckCH7Eg3XF30SgsGoVF" +
       "XX09Kth9M9OzmZgh1RGupFqu4IYEWVsohFOTZhwxI3LPIKFeOLpLZtB2TV5b" +
       "19wBFZ/aED39tQfaflhFWsdJq6qP4XYU2ISARcbhQFkmyUyrP5ViqXHSroPB" +
       "x5ipUk2dc6y90FIndSqy4ALuseBgljNTrumdFVgSdDOzijDMvHpp6VTOfzVp" +
       "jU6Crks9XW0Nd+M4KNiowsbMNAXfc1iqD6l6SvpRIUdex+77gABY6zJMTBn5" +
       "pap1CgNkoe0iGtUno2PgfPokkNYY4IKm9LUyQvGsOVUO0UmWEGR5kG7EngKq" +
       "BnkQyCLIkiCZlARW6ghYyWef60PbTzyo79HDJAR7TjFFw/0vAKbOANMoSzOT" +
       "QRzYjE298afp0hePhwkB4iUBYpvmxw/duHtj5+WXbZoVJWiGkweZIhLK+WTL" +
       "lZWx9duqcBv13LBUNH6B5jLKRpyZvhwHpFmal4iTEXfy8ugvP//oBfZemDQO" +
       "kFrF0LIZ8KN2xchwVWPmvUxnJhUsNUAamJ6KyfkBUgf9uKoze3Q4nbaYGCDV" +
       "mhyqNeT/cERpEIFH1Ah9VU8bbp9TMSX7OU4IaYOPrHU+/FuDjSAz0Skjw6JU" +
       "obqqG9ER00D90aASc5gF/RTMciOaBP8/dPumyNaoZWRNcMioYU5GKXjFFLMn" +
       "o4plYZwCNEb7k+D5VBH3MEuB7UOAjzGNYSRE0AH5/2/pHJ7KoplQCAy2MggX" +
       "GkTaHkNLMTOhnM7u3HXj2cSrtiti+DjnKchdsH7EXj8i14/A+hF7/Uj59Uko" +
       "JJddjPuwfQQsfAiwAsC6af3YF/ceON5VBc7JZ6rBPEjaU5S8Yh6ouJkgoVy8" +
       "Mjr/+muNF8IkDLiThOTlZZDuggxiJ0DTUFgKIKxcLnHxNFo+e5TcB7l8Zubo" +
       "/iN3yH34kwIKrAE8Q/YRhPL8Et1BMCglt/WJv3z43NMPGx4sFGQZNzkWcSLa" +
       "dAWNHFQ+ofSuoS8kXny4O0yqAcIAtgWFMANE7AyuUYA6fS6Coy71oHDaMDNU" +
       "wykXdhvFlGnMeCPS+9plfzGYuAXD8FPw3eHEpfzF2aUc22W2t6LPBLSQGeKz" +
       "Y/zsm7/+62Z53G4yafVVAWNM9PkADIUtlFDV7rngPpMxoPv9mZFTT11/YkL6" +
       "H1DcVmrBbmxjAFxgQjjmx18+/NYf3jn/RtjzWUEauGkI8HeWyuX1xCnSXEFP" +
       "dHVvS4CBGDHoON336+CYalqlSY1hnPyrdd2mF94/0Wa7ggYjridtvLUAb/wT" +
       "O8mjrz4w3ynFhBTMwd6xeWQ2sC/yJPebJp3FfeSOXl319ZfoWUgRAMuWOsck" +
       "0oblMYSl5sshYSBSzGxWJEBYVIm4WOASdBYRqFBLMpdM2v9OSRyV7WY8OLkG" +
       "kXOfwabb8sdRYaj6aq6E8uQbHzTv/+DSDal1YdHmd5tByvtsT8VmXQ7ELwti" +
       "1h5qTQHdnZeHvtCmXb4JEsdBogLobA2bAKC5AidzqGvq3v7Zz5ceuFJFwrtJ" +
       "o2bQ1G4q45U0QKAwawqwN8c/d7ftJDP1burKkSLl0S6rS1t8V4YLaaO5nyz7" +
       "0fbvnntH+qftjSsc+2CtGIRWWfB7qPD+tW+++9P5b9fZ5cL68lAY4Fv+z2Et" +
       "eezPHxUdsgTBEqVMgH88evFbHbEd70l+D42Q+7ZccdICvPZ4P30h8/dwV+0v" +
       "wqRunLQpTnG9n2pZjPFxKCgtt+KGArxgvrA4tCuhvjzargwioW/ZIA56yRL6" +
       "SI395nLQ1+NAQk8Q+kJEdu6TLD3Y9BYDSjluuA3JKxs4lxtLOL7FxlNs+7CJ" +
       "216xo6zL7Src8Eb4NjhLbiiz4dGKGy7HLUiLVRD6OLo1sN2xCtu1p3pkux6b" +
       "jbarC7hTZZNwPRWknjq1iYfM8q/VrQjdXz8ye1ETckGrKwhaxbUOYsaqcnW+" +
       "vKOcP3b6XGr4mU12eC0srJ13wdXwB7/9968iZ/74SokCrEEY/HaNTTMtENRr" +
       "i4J6UF6DvAjZenW+6trJ5U3FpRJK6ixTCPWWj/7gAi8d+1vHvh1TBz5GDbQ6" +
       "cFBBkd8fvPjKvT3KybC8ydkBWXQDLGTqKwzDRpPBlVXfVxCMXXkvkJ7wSfi2" +
       "OV6wrXQdUtLDQtidCCT7xgrCKqQzXmFORsRBQRZNMtFfKra9ODl0q7AuyCQ4" +
       "EJPD6bwSHW6MOhLs3zIngk2mWP9yrBV0fKjC3CPYzAjSDvqPFUOFp33u42uf" +
       "g9t/+YsL5trlRU8r9nOA8uy51vpl5+7/nSye81f2Jig701lN86cCX7+Wmyyt" +
       "SrWa7MTA5c/jgqyocLlCLJMdqcZjNs9xQRaX4hGkClo/5VcgKwQpBamRv366" +
       "E4I0enSwqN3xk3wVpAMJdk9yFxfbZD2C+TNi589cyIdPDkJLEy25lYnyLP5K" +
       "HLFHPoS5OJG1n8ISynPn9g49eOOuZ+ybgKLRuTmUsiBO6uxLSR5r1paV5sqq" +
       "3bP+ZsvzDevCjt+12xv2/H2FzyljEP8c/aMjUCNb3flS+a3z2y+9drz2KgD5" +
       "BAlRiOCJ4kojx7MAhBNxP4D7nlNl+d7X+O6B1z96O7RQFnTEviJ3VuJIKKcu" +
       "XRtJc/6NMGkYIDWQd1hOlkH3zOqjTJmG0rM+q6uHs2wgBW6ZNLJ6/s2sBZ2Z" +
       "4iOZPBnnQJvzo3iThGRY9BpW4nYNte4MM3eidIm/AXTOcu6fzeFbUgmtwDab" +
       "zv7jyJfeHIZgK9i4X1qdlU3mgd7/JOchf5sNVv+FvxB8/8EPTYoD+Au1YMx5" +
       "nlqTf5/iPGfPVSXig5w7tFVD0g04l0DyPSn4PDbfySGFIKFezv8HbVALbIsX" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mm153Fe267wz32Af3HOBzWbW8Y5XsNtKrq9wJ1cYQueEvaP7w3PT/HNx/8Jk" +
       "//vouenhIdip/Z3+oyePFK+9Csh2og/c6Bos34V+6ulnnpeHny7t7J0zmiF0" +
       "PnTcN1tKrFhHtO4ASU/ceMc9yG8BD8+/vvL0P12evG35rldwQfDQCTtPivyt" +
       "wQtfaz8mfWwHOn1wGnbN/eRxpiePn4Fd8JUw8u3JsZOwBw4m4Z5szN8Ansbe" +
       "JDROHh0dxsD1z41m2xi6yTHuh27S94tZ8b4QultTQux6p2KH0ff+l9vrH5Wd" +
       "Nzx94Obl/VOxPd7t9/+tm8/epO+5rPhlkGfATfba47VDJz/2SpxMQujyja/E" +
       "ssP9+6+5tN9eNEuff/7iufue5/4yvxU6uAw+T0Hn1Miyjp6hHqmfdX1F1XOH" +
       "zm9PVN3869dD6DU3ubbLzvfySu7A81ue3wihe67HE0KnQXmU8tMhdOkkZQid" +
       "yb+P0n0mhC4c0gGl28pRkt8G0gFJVn3Bvc7h4fbgOTl1BAP2QimfnLtebnIO" +
       "WI5eMWW4kf/FYj/Ho+2fLK5KX3i+R7/7JfTT2ysuyRI2m0zKOQq6dXvbdoAT" +
       "j9xQ2r6ss53Hf3zHF8+/fh/T7tgafBjWR2x76PqXSa2VG+bXP5vfv+933/Kb" +
       "z387P8v8b7ep7PT7IgAA");
}
