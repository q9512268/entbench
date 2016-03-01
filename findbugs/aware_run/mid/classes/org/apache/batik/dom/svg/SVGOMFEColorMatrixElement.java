package org.apache.batik.dom.svg;
public class SVGOMFEColorMatrixElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEColorMatrixElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_TYPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_VALUES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_MATRIX_VALUE,
    SVG_SATURATE_VALUE,
    SVG_HUE_ROTATE_VALUE,
    SVG_LUMINANCE_TO_ALPHA_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected SVGOMFEColorMatrixElement() {
        super(
          );
    }
    public SVGOMFEColorMatrixElement(java.lang.String prefix,
                                     org.apache.batik.dom.AbstractDocument owner) {
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
    private void initializeLiveAttributes() {
        in =
          createLiveAnimatedString(
            null,
            SVG_IN_ATTRIBUTE);
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              1);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_COLOR_MATRIX_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getValues() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEColorMatrixElement.getValues is not implemented");
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEColorMatrixElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5Zo3DDzjoS78487/AriJ2li/JAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7Cczk1n3ffJ+k3ZUsaVeSLSuyJa+klW1plI9zcA5GcmLO" +
       "DDnDGV4zHHIOx17zJmd4X8Ohq9oxENtpENdNZcUpYgEFnB6BbAdFgxYoHKhX" +
       "DsQNEMNomwC13aJHGseAjbZpELdNHznftd/ufpIqAx2A73t85//8vf97fN+r" +
       "3yvdFQalsudaW91yowM1jQ5WVuMg2npqeDAkG6wYhKrStcQwnIKy6/KTv375" +
       "z374OePKfunCsvSQ6DhuJEam64QTNXStRFXI0uWTUsxS7TAqXSFXYiJCcWRa" +
       "EGmG0fNk6W2nukala+QRCRAgAQIkQAUJEHrSCnS6T3Viu5v3EJ0o9Et/tbRH" +
       "li54ck5eVHrixkE8MRDtw2HYggMwwqX8XQBMFZ3ToHT1mPcdzzcx/Pky9NIv" +
       "feTKP7ijdHlZumw6XE6ODIiIwCTL0r22aktqEKKKoirL0gOOqiqcGpiiZWYF" +
       "3cvSg6GpO2IUB+qxkPLC2FODYs4Tyd0r57wFsRy5wTF7mqlaytHbXZol6oDX" +
       "h0943XGI5+WAwXtMQFigibJ61OXOtekoUek9Z3sc83htBBqArhdtNTLc46nu" +
       "dERQUHpwpztLdHSIiwLT0UHTu9wYzBKVHr3toLmsPVFei7p6PSo9crYdu6sC" +
       "re4uBJF3iUrvONusGAlo6dEzWjqln+/RL3z2Y87A2S9oVlTZyum/BDo9fqbT" +
       "RNXUQHVkddfx3mfJl8WHv/aZ/VIJNH7Hmca7Nv/or/zgg889/trv7Nq86xZt" +
       "GGmlytF1+UvS/X/w7u4zyB05GZc8NzRz5d/AeWH+7GHN86kHPO/h4xHzyoOj" +
       "ytcmv7X4xK+p390v3UOULsiuFdvAjh6QXdszLTXoq44aiJGqEKW7VUfpFvVE" +
       "6SLIk6aj7koZTQvViCjdaRVFF9ziHYhIA0PkIroI8qajuUd5T4yMIp96pVLp" +
       "InhK7wXP+0q739N5EpVCyHBtFRJl0TEdF2IDN+c/V6ijiFCkhiCvgFrPhSRg" +
       "/+sfrx60oNCNA2CQkBvokAiswlB3lZDi2lCYAMMS+gyFY4ATN6BEYGVpjhyq" +
       "A9AIGJ/3/2faNJfGlc3eHlDUu8/ChAU8bOBaihpcl1+KO9gPvnL99/aP3eZQ" +
       "jlGpBuY+2M19UMx9AOY+AHMf3Hbu0t5eMeXbcxp2dgG0ugb4AJDz3me4Dw8/" +
       "+pkn7wAG6W3uBCrZB02h2wN49wRRiAI3ZWDWpde+sPkZ4eOV/dL+jUic0w2K" +
       "7sm7szl+HuPktbMeeKtxL3/6j//sqy+/6J744g3QfggRN/fMXfzJsxIOXFlV" +
       "AGieDP/sVfE3rn/txWv7pTsBbgCsjERg2wCGHj87xw2u/vwRbOa83AUY1tzA" +
       "Fq286gjr7omMwN2clBSqv7/IPwBkfH/p0BGEQ2co/ua1D3l5+vadqeRKO8NF" +
       "Acsf4Lwv/tvf/6/1QtxHCH751JrIqdHzp1AjH+xygQ8PnNjANFBV0O7ffYH9" +
       "m5//3qc/VBgAaPHUrSa8lqddgBZAhUDMP/s7/h9++1tf+ub+sdHsRaW7vcCN" +
       "gA+pSnrMZ15Vuu8cPsGE7z0hCdiuBUbIDeca79iuYmqmKFlqbqj/6/LT1d/4" +
       "089e2ZmCBUqOLOm51x/gpPzHOqVP/N5H/ufjxTB7cr7wnYjtpNkOTR86GRkN" +
       "AnGb05H+zDce++XfFr8IcBlgYWhmagFvpUIMpUJvUMH/s0V6cKaumifvCU/b" +
       "/40udipAuS5/7pvfv0/4/m/+oKD2xgjntLop0Xt+Z2F5cjUFw7/zrLMPxNAA" +
       "7eDX6J++Yr32QzDiEowoAzgLmQCgTnqDcRy2vuviH/3Tf/7wR//gjtI+XrrH" +
       "ckUFFws/K90NDFwNDQBYqfdTH9wpd3MJJFcKVks3MV8UPHpsGW/LC6+B5yOH" +
       "lvGRW3tAnj5RpNfy5H1H1nbBiyXLlM+Y2j3nDHhGKfuHYJe/vwNElAXveVBy" +
       "sAtKjiqeviXgohKAHCCKnivHOcYW1H7wHL3jeYIUVbU8+Ykd5Y03JLtd20eK" +
       "t4tAuc/cHp7xPLg7QbhH/oKxpE/+hz+/yYAKYL5FTHOm/xJ69Vce7f7kd4v+" +
       "JwiZ9348vXkVA4HwSd/ar9n/Y//JC/9yv3RxWboiH0bZgmjFOe4sQWQZHoXe" +
       "IBK/of7GKHEXEj1/vAK8+yw6n5r2LDafrJ4gn7fO8/ecgeN35FJ+ATzPHdrO" +
       "c2eNca9UZNhb2+N+nn0/MMqwiOUPjfIvwW8PPP8nf/IB84Jd0PNg9zDyunoc" +
       "enlgcX8ota1pIJoR4RRLyrGmgB2+/yY7LBy15wI/2BKOoqaqMs2x7sRvCkMb" +
       "v56hjY7F8K689AJ4OodieOE2YvjpW4vhjkIMeTKNgBZMR7QKQfNR6W3TBYtd" +
       "F1CSxzhgwE/f3oALoN0Fy6/8nad+/+OvPPXvC6y6ZIZAzWig3yJ6P9Xn+69+" +
       "+7vfuO+xrxRL+p2SGO4Ufnbbc/Ou5obNSkH2vceCeXsuh0dz4DkUzN5Ojddv" +
       "VuNPXPVjMTT9GKyF799h1NWdVVwtBHJ1hy4f+vBViulh12mUwrirH7jqqJvD" +
       "mo+JtvTihw4ODj78/DOeVxCCHgPC3g7+dnrLE/VIJcY5lvmBPPnokSouWKqj" +
       "R8b5MMIGpg1Ch+RwawO9+OC317/yx1/ebVvOYsaZxupnXvprf3nw2Zf2T20W" +
       "n7ppv3a6z27DWBB4X0FlvoI9cd4sRQ/8v3z1xX/y91789I6qB2/c+mBgZ//l" +
       "f/2/v37whe/87i3i6DuAAeQvipfebkl46GRJ6Fquo+bOdVS3i6VN9+B4aw4q" +
       "05v0FJSevb2MqcLgTvDytz/5J49Of9L46JsIot9zRkZnh/z71Ku/23+v/Iv7" +
       "pTuO0fOmffuNnZ6/ETPvCdQoDpzpDcj52M70Cvnt7C5PXihUd84a+Ilz6j6Z" +
       "Jy8C2JBzUe80c07zn01LZ3Duw28c54roO99+9g/duX8bnPvMbcKPAueO/Gnf" +
       "PMbo587fnKGOaecYsXP0M/T/3JukP1+iyEP6ydvQ/zfeCP3FqnjEQfWNcZA7" +
       "V453h3uLU2z84uuysXPwPRDD3VU7aB1U8ve/dc6CUqDX9AYIe+fKkq8dYa+g" +
       "BiGg49rKahVgeYYg/g0TBLz1/hOXJ11Hf/7n/+Pnvv7Xn/o2wI9h6a4kj0yA" +
       "050KFek4P6v71Kuff+xtL33n54vtEBAv+zJ25YP5qH/7zbH1aM4WV5wxkGIY" +
       "UcX2RVVyzoohrFP8AAi7E3jKWSt649xGD7QHcEigRz+KF8XZRq5qTlRLMIGp" +
       "L8O1p8s9ZxCO0UaNElWXh8kVQ1iGxuk1wcFdOmaXESSOa0vLaPg1pDuu9D1s" +
       "hHV9foyadYxFgjEKCz2JsyJs2fVhYzTvjlaWiFoDQUQNXLTEsRGJZaeeZGpG" +
       "ZXGDkQma5yC2zdJQPdEUpZUlqsq2J1RIbTmJMsTx2tsEC6lKBBW4lWqUWROb" +
       "+Njapj4W1QcNz1FiJ8tqXCxUFwJRm/ZFmhNElsStSsKTgtETKBwYccpNaM9a" +
       "JN7YXjd7qjeRq6nJ2U16ndkjfFnfWqgwm2GI6hLmxuus09AIzSk+7fPrrGZX" +
       "kg21MvuMbG8De6gk+qRmM+tZJNItrtWBOtvuVG9TssDGmrFYKRIWeHPMs21x" +
       "1HcrHm4nrN3nwHYqkSbVmTKZmf2J2OCzFiXIvBMmvU2V7iF8ue2ks7bmxx1X" +
       "HGL1aX+iTWrrcTSf1BxzYnqKgtT86cSa87OY4PiUiphehhlkRq8rXS/qLwR6" +
       "MDdkMh6VjdkqEPw5ndokzdkcthrDm3Ar1LE1tvGWHDTN6nYf5/wFOQ2djm2x" +
       "20oQ2HTowEYlcFtJUsfJeiUdckwl9fFZBa0t+53uWJR6BN0VZz5mW8sBscam" +
       "mxpX6+gLzR0tTF92mRoSVK3VyOe4DU3GXbcjlO3eLNiyQlXROaFDr6iIQuqU" +
       "6WnrqT2HaI7xOJ/Sm9V0LpgDQ3U2LGotvM3QXFpUry4NSU5a+DN40OS5Rl8I" +
       "VYEboz2ubUysRd2r+dUhrRvqeh6YxMi2V5UxvmHtCs/3NRcmCBtp8abZHMU9" +
       "3lGHbp1jugytBWkZHY9CzoeJYR9fr4wyHWwmMzsuZ+tQLk/q3rxeH1UjCyPX" +
       "aW/jjLpbM8nYzoiwBwhm2/7YNuaU3h1F85RdEnIKSTi3wNaMBq/ROUMgbVhN" +
       "+r6ns2x3uME7815z4jfXlJuQ5crSTqTtRoZsfCgbfUPEpa7hQpP6sLxNvIgb" +
       "JH0d0zO6FZqoSTFtqmt72yaErBpNBtv68dpeBqPEw9nVRMIttr/wRtm4yrtN" +
       "CRNHI0nAiagiO0ZdHMuNFY675WE0z4YeryxpzpqX/XXmaDAzWgco5vv6qOH6" +
       "s+qw1iAkLGXD9sIYdrYqpW9VDHZgXxY6FTFsDk3VtfChtZrglSaLeG5r61bw" +
       "RjbCZlmHQmlt6nbZFRStWIkwFIycViN9TfeVOVUZufh8hWOdVVeqCPRY7LRl" +
       "sRb15mELJof0gB7odpskmFS33bHW7jVWLMRGhsNPQhoboVx/FussYFsOiVrT" +
       "9jv2nG4q8yiqIsQAltsE3lZWC9WeriVabxGJyLTJyiocyBjiwnx9GWNjJyP5" +
       "BjqAJ4penVXGg20HFbZtrcy61qwuVy240+sbjLUYEhu32yK5qqlIZid1HUSu" +
       "J9DWs6kkETrVecPECEWkxtRwG1aW5DRajDkZ4pdLHw1xPtQyPaVxt71Ip2s9" +
       "3cJiedR0ZTtjOpA6IVAyc9GFEU+RPtnMZq0pjFa6hjKLEojpTjuQFlbp6ng9" +
       "pJcOwS0m8HriRVayIKGNPHdwUSF7bVmpRe5kOFqMoy4tULpP4bzUGyYVhfH6" +
       "Vt1dSSNex7rDOp8NxTUhr4cRPgkzZOzUe5rars3TctczYDwYsPCyg+CJlRgU" +
       "XJWHG4ftCEhqyni28bTBtFdLEsk0yspGmYZDjxan5bHsipCMkcI2dFzVqYkw" +
       "2fN8Ho1grVX2IWgBr+hay4Z0ecFtoqhGDFfDzTigun23vEzYOTtvupJWSyYB" +
       "U7a3xJoPetXOWl4sA2LJCBg2Wg/XHVqpz/jhyoVHo2ZvFeFbW59RPsfzIs/Z" +
       "6rqN+DMkVKHYnDExNhoFacr2HcGcKJt6o9y0rKxVHy5X0/l2uSbSRrU6k8yt" +
       "2FUXTEt2FY+L4smqnVY7qYIgNcsjm2O8S81moctum5gP93WzXmtZMmTqWgYN" +
       "OlmoGqlGNrUyPGkjk4GsOTMhK8d9LYDbIiPXkE13W0viQWi5eNrsj2th3/Ig" +
       "Z5Xx0nAWUm0KRiqDCHfmgc6MNnCvm4wwrBaxBtOdm9KAmWVhXxWA/sW63FLL" +
       "c4zsNiu24K/jITIhoGVzzA2GqbhI0YRqi6IJC+lw6+k+w5jrVWbwyzLZrcb+" +
       "qMZvgihUkkZWbyM8ZDs+WU4FbSEMZhYQwcisbyQSV0Q+MQiYXVErOE5rfQFu" +
       "NKyJ42JNh9Gk6gInGTNbRDqTJUadSKfivLMIXdDbHBBoMOanE0om0u5qXJ96" +
       "ytSmGZhO4+6gyw+MTdzwUVJm9LEzgCxzu5bmzc0ERxM4rhLkqEZDfDyIVpOQ" +
       "ZetB1gLLO8OKPdnCZJIrq51BWllpkM9X1FiDtCnb0yxYQlBYFVcDuBUnNaXc" +
       "qMwGjFSRjAbeFLkFJPCMLdsOm5hQdVXvZLUlbfCrBtW0uZY1Mblqb9KPapjr" +
       "bGtOAndqxEZVZxufjP02YtfkWdlh0GU1gjpOh+wM9RUdNgINw6Ge59n0dBtI" +
       "hCI1NE3HmP40SIUavOow2WbCRs6qByfsmt8Qs6U/NtZVYjDlLaM+8VjBcgKd" +
       "YtS1qm4ggosr5QFYYtSl2wEe0+uPYl2l1PLUGkIkMRXWDF7uSZSzmtWMbUya" +
       "o+YcX1UwE272LHlTIbcmJ3oACR3G1fnZsja1YWaOzLW+sYoMaz5myzrcQ8pr" +
       "VFyZMtsWh2QZn/eMDGkpdtJolgk96kwwJOO1VrWF1FmtyqYbhoGrODEZdVTR" +
       "EdrIKKFbsNZA7BbqxrWxrKxYRlgYmeOPJnW/h2Z+AAIaj9Aa/qQda3N8K8br" +
       "FktN5qOOBJNcOnMZbVsZbNsQ0jP0bEYO4q7Ad53tkmWmtWZmI02iQXJLJ1Ik" +
       "okMpRA8fG9hSxO3UZBDBRuEm1FsoXK0caxsMJh0WOF+UK8JdrOozpy6MFMve" +
       "ur1tsthaM38lUZtRr58gnjfq6rYj07ZVWUI1Q9KUtky2N/603C8ve14QVera" +
       "pNlYSqo7rYAVdcUlnCZxZreh2B110J1O07XfURhq3kRSSC6rJqsgsBuPArY1" +
       "VVvRYOpDEYSUIYeYz9rQrNlpjMaDFjwp9yWR6qpivRMJwNPskO+14B62qVHu" +
       "Wt0iWwzNmPESF+ebZcNVW+YyrpEtHSb7HA0Co4BqJfNBt+qZQ2S7CMwooZM2" +
       "O61qjTWk0oNF1bYrQyJC4kROyktGhWQknnUlDY/F+YjLD3vr3UZnVG2Uxf7I" +
       "Y7bRaE03bI5YuiyE6XOWMjbNeBpiOKppPbeDdGAlGS9NvjLPujV94MblqqhP" +
       "xhu4mkJ4h4nnkVhDGuUp3cpmnXbftKvcmlZnPs1UmQbmiZIvDNj+gE4m9LYh" +
       "icrAbccRpQc9ip5uNAxbQyuzu1jUhYFphPKAQSfxaDg0W3Oulmz7yNS0sAyz" +
       "xG15PhTaaBU1muKaYnzCZORpc9nwTJdbggAmw7nQrAQNdL3wJlS17zLYqKpN" +
       "+wZFNnSenEmci6yRzZKwkj6seMseHI2xQBPbVVk1vLpLM7OturJTxunSrZiL" +
       "Ko3FyFDwfjqqLNRJoihJPfQrcyWZIXq502DHmympMDhjwdVpVcLrnUYr2mZz" +
       "YsZittQSpxo5aphmZK/7fQel5pUKyi4WvQDRl0TfHIsBGmObltDj+xzHtmQZ" +
       "MN9LQppgoEDHBn1aFYx+0pk0JW2hGRUerumW1nEjtyPqfXiE9FeW4duU3kga" +
       "YhAvUS7s+8y8gdImCaL5ITdigtBKEULbDIVMYR1pEjeNAZ+iDjYtLzAtYpY+" +
       "zPkoTaBjoU3qZK2z2caUQCAcHtEWp9aqMKT0Bagzn1ZBVDs2xG5YXmdafY2g" +
       "fDIxXL0+bHcXA6gPT1De4DpwhEh2ZyhbncWQlFaTOqKRNU6NrT4/IGHJ6eBx" +
       "s9/M3/s22hqAOdmKYmzpTW+NJXqjtQ67KUotmxTcD5xgq0YOxxMzfcBmkkjQ" +
       "FURj2gJh1kJ9gg71BK00eva6G1Fs0tumA7ZZ6ZRji4YRBUvo6raqsUtOjB2U" +
       "Hyza5Wa6VNIMTXh+i5E4h9I81Q1RIxZkvzOSJ01qmghosPQiNKiPtig96flM" +
       "QMpLioQVK+i26HrZcd2c52abQGcdiuFxuAqbg+1cstZBdWAGBiFCsEqy/JIh" +
       "Nb/a5RCxDzFlfZEkUUL0+BYvtJuLuNyqu+1GNfERPuU9nPKbQR0Pwwxsvijb" +
       "4uChn+DOZJFUeSYi+hzYPuLN6cScQNUuuenBvXKodGsEOnRTJfPUSmW+ztwl" +
       "ZCRktYmtOXfea48a9sAA+8pOdUwNvNpCWoENJtNGLZafrKshXK+jFGVvsS0c" +
       "8ZjdGK3ZljqaOeWwMcyGlhVOW85YkGZaM+nxzZU1kaB6pzsfNLZNj9V8t6xp" +
       "o1Yr2478il5VNlSzj2BeWS6PyEVswl7s+ZkQOf2GrDisMF02I64Vbua9VoIv" +
       "YLBrFJuoTCHdSSOJyzquR7Vx2wjKiARpOhm3XcZYWy61sYarHgg6A4TOJobX" +
       "HIX1dONW11Fv0YbbWUuYJ9K87lUypYtomejAq1m4tQnCbGlQYkoQ7/TKeBOE" +
       "LuK0P/ZUPhkFdWcuRXyVH6yUrByNtti0Fi3V8mbpD+ZcY0XHs2VoKMt1vTys" +
       "j9ei2G4icTsoK4LvNDu9+RyOfXhK1JIa35YMQxvRUghCFkvdEHiQ2hRi2ANt" +
       "vpzHjaVb7/Wylcu1AKktCA3MYc0yoSGKFidMX35zRzsPFCdWxxek/h/OqtJT" +
       "B63HJ4Gloy82Tx/mnz5zEnjqw+He0Rnf+/Izvk1dPn20d6t7I/kh/GO3uydV" +
       "HMB/6ZMvvaIwv1rdPzyV9aPS3ZHr/bilJqp1aupLRT678QCzAh7tkGzt7AHm" +
       "iWDOPb0854T4n51T9y/y5GtR6V2mY0bF8b2KWhZpJioaAQFIcaSGtzxxS1xT" +
       "OVHXb76Zb7hnRHBvXlgGj3MoAufNiCAq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("XfQCMxEj9XXl8I1z6r6ZJ1+PSo+cyOFGIeT1v3XC8L96Cww/mBc+XjTd/dI3" +
       "q/MPvC6v3zqn7jt58odR6V5djUhXFi368CMHesLfH70F/h7LC58Cz8cP+fv4" +
       "j56/Pzmn7k/z5D9FpQuAP8KpHjn7E7dw9hu/Q5yw/5/fAvtP5oXPgOdTh+x/" +
       "6kfP/p+fU/cXefLfgF8A9qenPmi89xz+T33FOBHCf38LQngiL3wWPL9wKIRf" +
       "+JELYe/COXWX8iS/igWEUNyjCI/E8PQ5Yth9xMjvNh1LYW//LUjhobww/1r+" +
       "8qEUXn6zUnhddN87e5vndN3DeXIZmIKjbmhXOTaFK6dlcFxRsHvlrSodAc8X" +
       "D9n94o+e3SfPqctH23sMgHhu+WcujxxfCJmf8Pr4m7p5FJV+7LYXS/Mrco/c" +
       "dN19d0Vb/sorly+98xX+3+wuYhxdo76bLF3SYss6fSvnVP6CF6iaWYjj7t0d" +
       "neIGxF4ZsHe7L5NR6Q6Q5pTvPbtrfRCV3n6r1qAlSE+3rB5axemWUemu4u/p" +
       "dnBUuuekHQDZXeZ0kxYYHTTJs23vyOR+6nVu65pWpAbHFxu4KL98HCgn62+6" +
       "dyqKOrS8AqUefD0lHnc5faMzv4JQ/BfD0XWBePd/DNflr74ypD/2g+av7m6U" +
       "ypaYZfkol8jSxd3l1mLQ/MrBE7cd7WisC4Nnfnj/r9/99FFUeP+O4BMvOEXb" +
       "e259dxOzvai4bZn943f+wxf+7ivfKj6t/l9bihVDXjIAAA==");
}
