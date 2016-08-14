package org.apache.batik.extension.svg;
public class BatikBridgeExtension implements org.apache.batik.bridge.BridgeExtension {
    public float getPriority() { return 1.0F; }
    public java.util.Iterator getImplementedExtensions() { java.lang.String[] extensions =
                                                             { "http://xml.apache.org/batik/ext/poly/1.0",
                                                           "http://xml.apache.org/batik/ext/star/1.0",
                                                           "http://xml.apache.org/batik/ext/histogramNormalization/1.0",
                                                           "http://xml.apache.org/batik/ext/colorSwitch/1.0",
                                                           "http://xml.apache.org/batik/ext/flowText/1.0" };
                                                           java.util.List v =
                                                             java.util.Arrays.
                                                             asList(
                                                               extensions);
                                                           return java.util.Collections.
                                                             unmodifiableList(
                                                               v).
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() {
        return "Thomas DeWeese";
    }
    public java.lang.String getContactAddress() {
        return "deweese@apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() {
        return "Example extension to standard SVG shape tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikRegularPolygonElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikStarElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikHistogramNormalizationElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikFlowTextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.ColorSwitchBridge(
              ));
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        return false;
    }
    public BatikBridgeExtension() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vjDFCc+U9yLQhurFK741/BufTnd+mR8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16eezs1l2v701yszb3JukSQpsm7Q2Quv15PPuQFjrjGdvj" +
       "8XgWe8YzZkk93sb7Pl5oKBRBy+Oprw/SUiSaP1ARUIW2IMoOCiB2hFRArHq0" +
       "eo8nCqWIILGIsh17fvu991dVCYzkM55zzvec7+e7ne+cc57/PHRHGECw51qZ" +
       "ZrnRgZJGB4bVOIgyTwkPKLoxFYNQkTFLDEMO1D0tveETV//xC+/fXrsMXRGg" +
       "h0THcSMx0l0nnCuha+0UmYauntQOLMUOI+gabYg7EYkj3UJoPYyeoqF7T5FG" +
       "0HX6iAUEsIAAFpCSBaR70gsQvUJxYhsrKEQnCn3om6FLNHTFkwr2Iujxs4N4" +
       "YiDah8NMSwRghLuK30sAqiROA+ixY+x7zDcA/gCMPPu933jtx2+DrgrQVd1h" +
       "C3YkwEQEJhGg+2zF3ihB2JVlRRagBxxFkVkl0EVLz0u+BejBUNccMYoD5VhI" +
       "RWXsKUE554nk7pMKbEEsRW5wDE/VFUs++nWHaokawPrqE6x7hHhRDwDeowPG" +
       "AlWUlCOS203dkSPo9ecpjjFeH4EOgPROW4m27vFUtzsiqIAe3OvOEh0NYaNA" +
       "dzTQ9Q43BrNE0CO3HLSQtSdKpqgpT0fQw+f7TfdNoNfdpSAKkgh61flu5UhA" +
       "S4+c09Ip/Xyeeev7vskhncslz7IiWQX/dwGiR88RzRVVCRRHUvaE972J/qD4" +
       "6l9472UIAp1fda7zvs9PvfPFt7/50Rd+Y9/ny2/SZ7IxFCl6WvrI5v5PvRZ7" +
       "snNbwcZdnhvqhfLPIC/Nf3rY8lTqAc979fGIRePBUeML819bf8tHlc9dhu4Z" +
       "Qlck14ptYEcPSK7t6ZYSEIqjBGKkyEPobsWRsbJ9CN0J3mndUfa1E1UNlWgI" +
       "3W6VVVfc8jcQkQqGKER0J3jXHdU9evfEaFu+px4EQXeCB3oreJ6A9p/yO4JU" +
       "ZOvaCiJKoqM7LjIN3AJ/iChOtAGy3SIbYPUmErpxAEwQcQMNEYEdbJXDBuA0" +
       "ihMCjEi405BeUdcLdFlTBkcNB4W9ef9tM6UF5mvJpUtAHa89Hwws4Eeka8lK" +
       "8LT0bNwbvPixp3/78rFzHEorgmpg8oP95Afl5AfHkx+AyQ9uNjl06VI55ysL" +
       "JvbqB8ozQRgAAfK+J9lvoN7x3jfcBuzOS24Hki+6IreO09hJ4BiW4VEC1gu9" +
       "8KHkW5fvqlyGLp8NuAXjoOqegnxahMnjcHj9vKPdbNyr7/nsP378g8+4Jy53" +
       "JoIfRoIbKQtPfsN5EQeupMggNp4M/6bHxE8+/QvPXL8M3Q7CAwiJkQhMGESb" +
       "R8/PccajnzqKjgWWOwBg1Q1s0SqajkLaPdE2cJOTmlL395fvDwAZvw06LM7Y" +
       "fNH6kFeUr9zbSqG0cyjK6Ps21vvwH//uX9VKcR8F6qunlj5WiZ46FRyKwa6W" +
       "YeCBExvgAkUB/f7Ph6bf84HPv+frSgMAPd54swmvFyUGggJQIRDzt/+G/yef" +
       "/vOP/MHlE6OJwOoYbyxdSvcg/wN8LoHn34unAFdU7B37Qewwujx2HF68Yuav" +
       "OOENBBoLuGBhQdcXju3KuqqLG0spLPZfrz6BfvJv3ndtbxMWqDkyqTd/8QFO" +
       "6r+sB33Lb3/jPz1aDnNJKha6E/mddNtHz4dORu4GgZgVfKTf+nuv+75fFz8M" +
       "4jCIfaGeK2U4g0p5QKUCK6Us4LJEzrVVi+L14WlHOOtrpxKSp6X3/8HfvWL5" +
       "d7/4Ysnt2YzmtN7HovfU3tSK4rEUDP+a815PiuEW9Ku/wHz9NeuFL4ARBTCi" +
       "BCJbOAlA/EnPWMlh7zvu/NNf+pVXv+NTt0GXcegeyxVlXCwdDrobWLoSbkHo" +
       "Sr2vffvempO7QHGthArdAH5vIA+Xv24DDD5561iDFwnJibs+/C8Ta/Pu//vP" +
       "NwihjDI3WYfP0QvI89//CPY1nyvpT9y9oH40vTEmg+TthLb6UfsfLr/hyq9e" +
       "hu4UoGvSYWa4FK24cCIBZEPhUboIsscz7Wczm/0y/tRxOHvt+VBzatrzgeZk" +
       "LQDvRe/i/Z4ThT+ZXgKOeEf1oHVQKX6/vSR8vCyvF8VX7qVevH4V8NiwzDAB" +
       "hao7olWO82QELMaSrh/56BJknEDE1w2rVQ7zKpBjl9ZRgDnYp2n7WFWUtT0X" +
       "5Xvzltbw1BGvQPv3nwxGuyDj+66/eP/v/K83fhqoiILu2BXiA5o5NSMTF0nw" +
       "dzz/gdfd++xnvqsMQCD6LL/zx1qfKUYdXYS4KPpFMTiC+kgBlS3XdVoMo3EZ" +
       "JxS5RHuhZU4D3QahdXeY4SHPPPhp8/s/+6P77O28GZ7rrLz32f/xHwfve/by" +
       "qZz5jTekradp9nlzyfQrDiUcQI9fNEtJgf/lx5/5uR9+5j17rh48mwEOwB+c" +
       "H/3Df/udgw995jdvkmjcbrkvQbHR1etkPRx2jz40KojrRErnfFzdrFZKzdw5" +
       "6balimiP2a3HhjPA+MV0vZKF+ppPp7uxkKHeNuUWCMORUSv2drEd1YQeK3dx" +
       "xtzq5rTrdD1e3W7HiU0stPFwXsGGi7450CVWH/C9hGUpbdbLEgzBupQiwr7S" +
       "8p1Gq1vNeNEMYhv4DuzXdrKyE6e2JjBmbFfnnL/Jx712bs9rMVqzx7wh0B3b" +
       "WUSB3F+hWWMnCLAS8RQ9Vxcm7W4r3mjbsUW8amdGFrDmdDHj/U3A+GI9UZLI" +
       "YBV2yEupjWqG5fuDqcnZ/lToosxyOYf5tZEJPa3X4nWPQrONb1MkIfVzjZXo" +
       "YYBxOqVTDUKpk72a1Z8FW8OxTQmpmaramHvdrNlELakz5GuLiBQxjlyyFXbJ" +
       "1xRnow4norg1xAWq1WXBcdWaGIcyhjXpQId7a8bpB0IHUZYTm1t0Ex32m8l6" +
       "We8Ygk103CFbESi/o26CFhGq3KpB+zZj6mt1zMryYqXOMSwRtcVSFrmKX52i" +
       "Yy9WMnW9nm1bYY4K5mjj6pwn8ZzNsDrPK6LNaHmO96ekbOLjit7yMCyyaGqQ" +
       "4rupPs+aiOhXVx2eRXWS9WO/H/cqOBPiW5MddC1iweU01TJNmycxOpro25aJ" +
       "mz4qz9N5ZyxHXsCPJLgHW+g67DPO2IzDJj/AFY0TAirH+mKorUx3bU2ZQDF9" +
       "QxR6aKArgUV2jY476RqsF+YDbx72Y1KQ/cTXpQY/z83R2FjLnDnrTuIxPRkL" +
       "bqu/YCgU68H2jPKp+XReEXrMlKtUus3arNuP+lthQeJsyvhmZvSYMN+KwrAb" +
       "U67S9c1BV2MzKe/arC5YXTYJMX5Hew2Y5fszZVfhVI9hZwOlUs/m0rTDJDgn" +
       "1HseUQlTvT1omMOc8ZujWmVjTUlR2/aGhtMbalbOw/F0tUqbYZPCM46x+aUb" +
       "6Zvq2F2RFjuhLEviO3617fbE2oJvF2nbiG5QkkOP1uPOSGbaZD/HamN9yGzl" +
       "Wk+v1qZqrDRXrdFYrBjbbnM772fVVc+I3OWwGvtEMI4Fzs9HhEp1ZbrbIViV" +
       "6LW1Mdzt+LE37tgNxuPzoqrCrbgloQxrM4rFRnNMnzvbVUfgtjsvXgjteaum" +
       "s4N8iJGbYc/pCQO1LaHUyBumoZ5iuOgH8Zag+NlmtKmo3Xo261YridldrhGS" +
       "Jhinu7CJPhHKQxYjeXY9TjByG5vVrKcDmxjNV3EeRPLctHc88HaiwiBTJLKG" +
       "iiDUUULze5PtmnDWA6JR1TmX5QV8KU0aq6DF5ZWFWjFFYluf9DJ0goakvt5Y" +
       "dR5LQNqZKNtw1W/M144r9NZSLsQz31WtvjTeaP22NJ2OErm6anF2EvQ2QP2Z" +
       "3As1o7kZ6QrDOfAsWCWSslynlTxtKPBO3QiEMYxYw3cTh1kkSJ9dN1c9iXX6" +
       "eWTFnImZbY0mBhbSTQZbh5h5tBbAPt7XJV7xmQEvbKeZkqvcpF6fJdONP8/G" +
       "mN1ScypNYQOdtBq1jVb1Ruv6PJ7MKxKBDElzOl3t+tpqQaoLoqWgu4ozNTrV" +
       "at7qt1MKn0kKY7G8NBpPMhdfDOprM/Abm9kcZqYtJWTDvtLFYWnBbYGhjlsa" +
       "YS4nPhOhTWxLT2e6NPaTEF31h+lGnwtZCpgI543In+Tz1Iv5LabNqiOe7G9d" +
       "0qk5SCupc37P64VV3qmlqtdPNx4cJKHZ3OKM38nSLG4v1hUaRedwxvMVJK5l" +
       "q/EAhBQLjROsE8ISTmjkop/0so6EKOvWJu00dtI6X8+a6cRTuhYm7QTK6eCr" +
       "FGtPE5qszXZVjJS5gaLW4ZjHqUzW2VhtKBWmRtWJvkYwLhyOSCmdcaJZcblB" +
       "e4p03NWGrFY2bWVDTX3U75ORsFl6DaTbzGHDQvNaxVqq8tDzZppPrGZtxKjk" +
       "zbblKHm/ys8lOSERJ1ihaKWBTCsbVxvVh1YkCwnVqLgD0py5El3r1q0cuIi0" +
       "hpN1dVTNEGMuqUO008RxOVZ2Vc7mQlhR/UWVQFM1Xq3gquDLZhiYlt9N2brJ" +
       "WVOzReKVAKS0u34erpet2YKv6rK2tifVjp41llE1ZFfhJJnRo7g7bok1Pu5m" +
       "7QpvN/De1EFIR2g05RhWlrw1yk1u7vdMNPYmdNeciYlMCE7C7Oyc78j0VEp5" +
       "rcPYbaxvYb1FxcVFHk+VHQKifxIzRr9dbTUGzDyBEVrKWYucSE0BSWiGiFNC" +
       "RBk8aq+E8U7DFrC8XHXbYUUYxEg+4ewWNRia87427DWHWDeouotgaAyChcGk" +
       "SdNh0maO+oLpzBZU2u+YvTYCj2Vkt83geqeyytqs17ObazGfVRODU8k4SjOR" +
       "HoaWY2pCo6Y0dxYwEKVVCWqcLrprHHFEaUggVn088zOfxFiMrznwNmiHVbIx" +
       "F8K2WQ+nepfKe6MVnMLrwYrOURr8ySUoupIx1MzM2stxbdXQ1kuCnq3Endsw" +
       "1mN0IgXxAteqFgmj2jBPA3LNrAdcQ640xnQznJi7sOu3NqMc48NlozVKMsbl" +
       "mCEmM+JsM18Zi9Bat5dUqru1Ni4l4WZLd9nhgJUDxPJCozbSRogIM3Q7B2vN" +
       "MDac2nzVbNfr1Q6dRDgqMhY+6af8bLk2MTiM+AGX6hPgWi7DB5ma0c2JXBcQ" +
       "OaZ6sdDRsm1bEzRpUlO3S3jS3Src3Fxt2LbX59J22xBHNNby5CU/mCebaa5X" +
       "W22n1YmrO0nFYIcYDxld24kYs8gmno2D1UeuBVQfjRAFZcjWYl2XtIk59cEf" +
       "CVhdz2h63SI263g9my5H8KztAmVxU2K5aGA+mpFyXq9W4VVru0NmaJUig8xp" +
       "RukmXKoGiapYKMMpiihzZjenAnw1qfr13ArHONYfJDKNpmt817OzNU1G6528" +
       "ahPjqIPP6yvDyLylE7VrURz3OWHdpCyRRC1xDCJRqosTI2TMBWvl0Uzj6MrO" +
       "n6LZjgwlGG55waildQ1/lm3NqD4ZwhPBbNQ6AtHFN0w07BubbFGRJzM/8HC0" +
       "wTE0Nxq6umF0VzkSMpu8rTq1la6lPBpsW+SuYtSQVm2pxqSBVLV+TjTxsD4R" +
       "Vba/pL1ovrI7WOyjGK+MDbjVoUKObDVr65YS2KkQBqHdmm1q/SxfEJMeI9D1" +
       "RntaM4ZtXiVkZDQecdsGyW2rlJH0jWAw5qYtc8mPIinw4IW9Cr2OIWG4STp0" +
       "ppDj+TRL+JibYeSy4m0VcWWu1YnhS5Q94ZJ03u6vGzThpbiHAyDL1GlOcqEq" +
       "Rd1xVaGkIbtcTsea0wiaGJxKUyPwHWyd19uTtLqVzbpiVPxwybPwrh2stWLe" +
       "ZKHXSRKPbK27HTFcDwyhjDQDEyptjFqu/cRo8hSfUq1+g2GLaYZWjq/BejIL" +
       "pLS9NipJjxhU6rg7cJoVfeFwydpaav2uq4yw5niJzkKj0WiA2AS3RhHW0ceV" +
       "AQWCG1uZLHs1c8ZJcY6PJZseEl3MaYn6aGBPOUy1Z8NEgAfr2IsCcsHGDpeB" +
       "cfVAy006maeyV2e5ubGRaHQsh7K2WYrdlhFWgzo1X8KNYcpinWWqDBYorjbr" +
       "3ag7YZkt0fMNOHawGr9DsHqeO+MkluvVEaMibXPXSRrT9iQzJyQP7xxy09L7" +
       "S6KO7+obcShiFLXiGLzttxZw0KxktLec9bjNpE3lJI4m1mTi79R2DSRVzeqs" +
       "3p1S7XTgYFmQzwgt3E3jBqJtRhhJ9bosASMr1pkQTqU57jWyrYRkcmfLVTAs" +
       "aMCCII12yDTUyczv9FLCt2vjJjoHCRalYDY+otQOIqF9aSXloxrw4F21RoP/" +
       "NIg6zNoWvq5ODHgccsv+OBvtprOIh6MJFbasFLVRAa6qVJIkbm3Cxk0cZBzc" +
       "vFz56zM8mcUjPo8TfyXzbaWq9iutBFnsZp7XYOus62CSvHNguEENZUVlSGZG" +
       "x82RNZfDieg6QQI3l3IdlaN+gLZXeJou5qa5UZKxg0qKWnNbkRw7DmyG9XWl" +
       "L/S9Rb+ZIb2eh4/llEAZIsAG2aK1arVhYyWPGmwgavpmQOSetx1gy0SaECC1" +
       "2hFV22Msb7mMm3MUcavieOzvVtnEopyu4Ge6uEtb1c5oE9QzyrK1MRm056uq" +
       "qJj1RS/SDIR0hYgBK4y72Rl9HJPgRSejZ9s4wEetOor0YpVzZNiet8Gf4re9" +
       "rfi7/PVf2o7FA+XmzPGBmmG1igbiS/invm96vCieON6QLj9XLtiQPrVpd+lo" +
       "I+grbziM2JQnDwfnDiCK3YrX3epcrdyp+Mi7n31Onvwgevlwc5SPoLsj13uL" +
       "pewU69TUd4GR3nTrXZlxeax4smn36+/+60e4r9m+40s4lnj9OT7PD/kj4+d/" +
       "k/gK6bsvQ7cdb+HdcOB5luipsxt39wRKFAcOd2b77nXHmii18VrwvOVQE2+5" +
       "+dHATa3mUmk1e1u5YO85uqBtVxRuBN2rKdE00N1Aj7Ky4/yUYS2LPUPLFaMT" +
       "k/O+2ObQ6YnKCusY8yuLyjeDp3GIufHyY/62C9q+vSi+OYIeBpiHtmcptuJE" +
       "inxswOGZ7bazZjcXk9KWn5Z+ZvaZT304//jz+920jRgqEQTf6rrBjTceijOr" +
       "Jy44dzs5iP4H4qtf+Kv/t/yGI2+591iQ9xaQHrpIkEe+++DJFv8wUspTnaLl" +
       "f54o9F0vQaEPFpVfDp7hIR/Dl1+hH7yg7UNF8b9BEAEK7cbAGUtwxAm4736p" +
       "4N4InukhuOnLD+4HLmj7SFF8GCwFAFxxO0QECZMsB0oYngP53EsF+TB4Vocg" +
       "Vy8/yI9d0PaJoviRCLoCQC7m9DlkH32pyB4Dj3iITHz5kf3sBW0/XxSfjKD7" +
       "AbK+EkqB7h2d0Z5C+JMvAWEZBYp2+xCh/fIgvHR2+X/i4uX/8OJSOdKvXSCP" +
       "3yqKX4qg+wJF00MQizhRC2+24ty+c3X5REK//BIk9NCRC7/zUELv/C+R0EOF" +
       "hJKadCC79sFgv6yUdH90gTz+rCh+L4Ku6WE/A3mDLh1S3kwmd25c11JE50Qs" +
       "v/+liCWNoFfe7MpIceb98A331fZ3rKSPPXf1rtc8t/ij8tbE8T2ou2noLjW2" +
       "rNNHlKfer3iBouolwLv3B5Ze+fX/I+jRi++0RNBtoCxZ/4s9zWcj6JFb04Co" +
       "f/x+mupzQKTnqUAaU36f7ve3EXTPST8QgfYvp7u8CHgCXYrXv/eOlH3qkHJ/" +
       "xpteOpW5HppgqaIHv5iKjklOX8coMoLypuFRZhpPDxOPjz9HMd/0YvMH99dB" +
       "JEvM82KUu2jozv3NlOPs9vFbjnY01hXyyS/c/4m7nzjKLe7fM3ziDqd4e/3N" +
       "71sMbC8qb0jkP/2an3jrDz335+Up7X8CDK0ptAIqAAA=");
}
