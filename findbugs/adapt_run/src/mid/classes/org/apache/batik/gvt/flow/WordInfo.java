package org.apache.batik.gvt.flow;
class WordInfo {
    int index = -1;
    float ascent = -1;
    float descent = -1;
    float lineHeight = -1;
    org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups = null;
    java.lang.Object flowLine = null;
    WordInfo(int index) { super();
                          this.index = index; }
    WordInfo(int index, float ascent, float descent, float lineHeight, org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups) {
        super(
          );
        this.
          index =
          index;
        this.
          ascent =
          ascent;
        this.
          descent =
          descent;
        this.
          lineHeight =
          lineHeight;
        this.
          glyphGroups =
          glyphGroups;
    }
    public int getIndex() { return index; }
    public float getAscent() { return ascent; }
    public void setAscent(float ascent) { this.ascent = ascent; }
    public float getDescent() { return descent; }
    public void setDescent(float descent) { this.descent = descent;
    }
    public void addLineMetrics(org.apache.batik.gvt.font.GVTFont font,
                               org.apache.batik.gvt.font.GVTLineMetrics lm) {
        if (ascent <
              lm.
              getAscent(
                ))
            ascent =
              lm.
                getAscent(
                  );
        if (descent <
              lm.
              getDescent(
                ))
            descent =
              lm.
                getDescent(
                  );
    }
    public float getLineHeight() { return this.lineHeight; }
    public void setLineHeight(float lineHeight) { this.lineHeight =
                                                    lineHeight; }
    public void addLineHeight(float lineHeight) { if (this.lineHeight <
                                                        lineHeight)
                                                      this.
                                                        lineHeight =
                                                        lineHeight;
    }
    public java.lang.Object getFlowLine() { return this.flowLine;
    }
    public void setFlowLine(java.lang.Object fl) { this.flowLine =
                                                     fl; }
    public int getNumGlyphGroups() { if (glyphGroups == null) return -1;
                                     return glyphGroups.length; }
    public void setGlyphGroups(org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups) {
        this.
          glyphGroups =
          glyphGroups;
    }
    public org.apache.batik.gvt.flow.GlyphGroupInfo getGlyphGroup(int idx) {
        if (glyphGroups ==
              null)
            return null;
        return glyphGroups[idx];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aa5QUxRWumX2y7LIP5CHIa3chAjojKqy6oMLKPnCWnfDY" +
       "6BJdentqZxt6upvummUWJYg5EeIP4lF8JBHOiUFNPAgeE09eR0ISEyVGjcQY" +
       "X9H4OmrQc+CHYqLG3FvdM/2Y6SYTVuecqumpqlt1v3tv3Xurpvd/QMoMnTRq" +
       "gpIQImxEo0Ykjs9xQTdook0WDGMNtPaLN79+27aTfxmzPUzK+8i4IcHoFgWD" +
       "tktUThh9ZJqkGExQRGqspDSBFHGdGlQfFpikKn1kgmR0pTRZEiXWrSYoDugV" +
       "9BipFxjTpYE0o13WBIzMiHFuopyb6FLvgNYYqRZVbcQmmOIiaHP04diUvZ7B" +
       "SF1sgzAsRNNMkqMxyWCtGZ3M11R5JCmrLEIzLLJBXmgJYkVsYZ4YGh+q/eiT" +
       "W4bquBjGC4qiMg7RWEUNVR6miRiptVuXyzRlbCLfICUxMtYxmJHmWHbRKCwa" +
       "hUWzeO1RwH0NVdKpNpXDYdmZyjURGWJklnsSTdCFlDVNnPMMM1QyCzsnBrQz" +
       "c2iz6vZAvH1+dPed19Y9XEJq+0itpKxGdkRggsEifSBQmhqgurE0kaCJPlKv" +
       "gMJXU10SZGmLpe0GQ0oqAkuDCWTFgo1pjep8TVtWoEnApqdFpuo5eIPcqKxf" +
       "ZYOykASsE22sJsJ2bAeAVRIwpg8KYHsWSelGSUlwO3JT5DA2XwkDgLQiRdmQ" +
       "mluqVBGggTSYJiILSjK6GoxPScLQMhVMUOe25jMpyloTxI1CkvYzMtk7Lm52" +
       "wagxXBBIwsgE7zA+E2hpikdLDv18sHLxruuUTiVMQsBzgooy8j8WiKZ7iFbR" +
       "QapT2AcmYfW82B3CxEd3hgmBwRM8g80xP7v+xOXnTD/8hDlmaoExPQMbqMj6" +
       "xX0D4549q23uxSXIRqWmGhIq34Wc77K41dOa0cDTTMzNiJ2RbOfhVX+4+oYH" +
       "6LEwqeoi5aIqp1NgR/WimtIkmeodVKG6wGiii4yhSqKN93eRCniOSQo1W3sG" +
       "Bw3KukipzJvKVf4bRDQIU6CIquBZUgbV7LMmsCH+nNGI9SmDMst65t+MiNEh" +
       "NUWjgigokqJG47qK+FGh3OdQA54T0Kup0QGw/43nLoi0RA01rYNBRlU9GRXA" +
       "Koao2RlNDrPooKxujn5N1RNdwEwEjU37cpbJINrxm0MhUMRZXjcgww7qVOUE" +
       "1fvF3elly08c6H/SNDHcFpacGGmEtSLmWhG+VgTWiuBakexaJBTiS5yBa5p6" +
       "Bi1thP0ODrd67uprVqzf2VgCBqZtLgURh2HonLwA1GY7hqw37xf3P7vq5DNP" +
       "VT0QJmHwHQMQgOwo0OyKAmYQ01WRJsAN+cWDrE+M+keAgnyQw3dt3t677TzO" +
       "h9Ox44Rl4JOQPI7uOLdEs3dDF5q3dse7Hx28Y6tqb21XpMgGuDxK9BiNXoV6" +
       "wfeL82YKj/Q/urU5TErBDYHrZQJsFfBq071ruDxHa9YLI5ZKADyo6ilBxq6s" +
       "66xiQ7q62W7hllbPn88AFaOaSTWUr1h7i39j70QN60mmZaLNeFBwL79ktbbn" +
       "haffu4CLOxsQah2RfDVlrQ4nhJM1cHdTb5vgGp1SGPf3u+K33f7BjnXc/mBE" +
       "U6EFm7FuA+cDKgQxf+uJTS++9uq+58I5myUZN7bSAGxo3jYb4Ltk2NhoLM1r" +
       "FTBGaVASBmSKe+PT2tkLHnl/V52pfhlastZzzqknsNvPXEZuePLak9P5NCER" +
       "Y6ctKnuY6ZDH2zMv1XVhBPnIbD867buPC3vAtYM7NaQtlHvIEIeOO7vZuV0x" +
       "oVudHjBYXJdSIP9hK9wcnHhy02MVW67IhpJCJObIK43uZ37Z+U4/128lbmts" +
       "R+w1jg27VE86jKvOVMDn8AlB+Q8WFDw2mI67oc2KHjNz4UPTMsD93IB8zw0h" +
       "urXhtY13v/ugCcEbXj2D6c7dN38e2bXb1J6ZgzTlpQFOGjMPMeFg1YLczQpa" +
       "hVO0v3Nw669+tHWHyVWDO6Iuh4Txwec/+1Pkrn8cKeC+SyQrjzzfpdCJXu2Y" +
       "kMoX7PnXtpte6AGH0UUq04q0KU27Es45IYky0gMOddnZDW9wgkPVMBKaB1rg" +
       "zRdwRiI5doi1tfB3O1bNhtNvupXlyJP7xVueO17Te/zQCQ7YnWg73US3oJnS" +
       "rsdqNkp7kjdGdQrGEIy78PDKr9fJhz+BGftgRhGirNGjQ3DMuJyKNbqs4qXf" +
       "/G7i+mdLSLidVMmqkGgXuH8mY8AxUmMI4mpGu+xy00FsroSqjkMleeBxT84o" +
       "vNuXpzTG9+eWn0/66eL7977K/RGfYVq+q51vuaP5hV0t1nOwmpfvyfxIPfoq" +
       "4yyX4c9FvPFCy4jx62LH8xKGXlsV8iwPf7Zxhnp5ZeDxpJCf4K7JtMlfjH/v" +
       "J0fWV7xoWn9hT+RJfN+47sl71FeOhcOWcS3MQUZBkSnAydsmYvObkQ1fTDbW" +
       "DtUasOO4wA8t2dzvS1wNbX62v/9zyHnvfU1Pb9vb9DrfAZWSAfkSeOACRxMH" +
       "zfH9rx07WjPtAE8wStGRW17BfabLP7K5TmJcR7VYXWvaz2RGzvZPOzvkEW2o" +
       "Q1fTGiafBZzbzLzkkl9b2HnR+y9//81fn/xhhWlSAeHBQzf53z3ywI1vfJzn" +
       "dngaWCBieOj7ovvvntJ26TFOb+djSN2UyU/RQQM27fkPpD4MN5b/Pkwq+kid" +
       "aF0R9ApyGrOcPpCxkb03iJEaV7/7iGue51pz+eZZ3pDlWNabCTrjQClz+fx6" +
       "U38hwl2HmQfP4fVcrM4xU39GyrX0gCyJ6CEkRZA5bQs0y1RJmsezxViJWian" +
       "2bB1bLBMw8xgEAucklWFYjKU7TOPIJIayd1QQGemgI3MyrORbm6RtsBbjp4s" +
       "efnWydX5Zw+cbbrPyWKevzF5F3j8xn9OWXPp0PoiDhUzPBbinfLH3fuPdMwR" +
       "bw3z6w1Tv3nXIm6iVrdWq3TK0rrijueNpm65Xgorlnt2zVRmQJTfHtD3Tay2" +
       "gl2IqFTTBgKG38TtrMcRUV0xho9ZG0D/bazivKsDq6+aVrLifwva5tq8fSpv" +
       "K+fPSXdsnQyl0Yqtjd6wbO2UXYGR2Y8axASJIeVIFtkBniP5zqmQeLhEYE3W" +
       "Ok0+XN4eyKUfNWxrwRCpwnIR38HmHV8Am3djdScjFQnqu+6eL2DdH1jrVuFV" +
       "VCeVkkMFl76nyKXxZNlsLd3ss/R9gZrxo2ZkbDIXRjnZNR5e7y+SV1xhtrXa" +
       "bB9eHwzk1Y+akUqM+3jxl3XzdXYIMMOZh/kDAcxnCjGR+7guAx1MOLY6wZxq" +
       "mt99LT+x7btx995Ez70LsgnopQwOBqp2rkyHqeyYahx/HsmxUYvTT4Ky0GJj" +
       "oVeSNlCOYJtbjFUBpAG+8LcBfY9h9SjoIElZV87l2KI+VLzf9ICuxy7IyUmL" +
       "xXlL8aD9SAOAPR3Q92esjoDSAPRS25PYqP942qjHYtfZUC6yWL+oeNR+pB5k" +
       "jsDYy2d9KQD6K1j9FaAbWeiFjnelw6qUsMXx/OgYwVQol1iYLileHH6kAWjf" +
       "C+g7htVb4NTBCK6ghazg7dGxgnlQWi3eW4uH7Ud6Kiv4MAD7SayOA3bDhf1V" +
       "G/uJ0cF+GZQlFoAlxWP3I/VA85wgZhU+XMJ5LNLRu6ZdtWze/xhqjcSQBNm0" +
       "LokG8hoK+Us0VIGNnzIyTkgkHHQeqX42OhtpOpTllmiWFy9VP9IAePUBfeOx" +
       "qmakBjZSzJ0g5ZCHakbHns6D0m6x3148cj/SU+yl0LQA+DOwAluqMbzwbcWH" +
       "zhw9+J0Whs7i4fuRngr+3AD487FqBviW4ReEP/u04Tdg1zQo3RaG7uLh+5EG" +
       "oFsY0NeC1XmYalPWbmWwOO5hG/eC0csjVlrMrywetx+pv9of5gCXBoBvw2ox" +
       "gDfc4B1KX3La4Hm+PBNK3EIQLx68H2kAtu6Avh6sOhmpB6WvTKc63KcsO3EO" +
       "dY2O6hdDWWtBWFs8ej9Sf9Vfw2FeHSCCdVitgVAHqvfgd2h/7WnjxzMDPyNf" +
       "ZYG4qnj8fqT++BdxjDQAfxKr9Wa88+Av+mabi0r4P+6m4MSWfT8D/2KanPcW" +
       "mPnmknhgb23lpL1r/2Ze4WffLqqOwaE7LcvO+17Hc7mm00GJi7favP3ld38h" +
       "jZEzfeHBqQG/kOGQao43GDmj0HhGSqB2jhyGQ793JCNl/Ns5bgRyVnscXkDx" +
       "B+eQ62F2GIKPW3NaybtRyJjJXO7In1UGmXAqZThuCZpct8H8fb3szW3afGOv" +
       "Xzy4d8XK604sutd82UGUhS1bcJaxMVJhvnfBJ8Xb31m+s2XnKu+c+8m4h8bM" +
       "zt471JsM29tgqiPH7wGD1tA2pnheCTCac28GvLhv8aGndpYfDZPQOhISGBm/" +
       "Lv+vhIyW1smMdbFC/yn3Cjp/W6G16s31z3z8UqiB/4dJzEv46UEU/eJth16O" +
       "D2ra98JkTJd138n/57hiRFlFxWHd9Rd1+YCaVnL/OI1DQxbwXT4uGUugNblW" +
       "fFmGkcb8f+vzXyCqApul+jKcHaep8dyXpzXN2csluwyrlgxKGmytP9atadZr" +
       "CuVvcclrGu7S0C34o+2/DLqroJQrAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4axitLI+1uqshEWzJvNRJYOFvhNp23Rq9UVLchGZgGWaYDb11Og0E2Vli935" +
       "cjDBxyzX6/ekTIV5ntQco4cyWcgKsoMJcUTIS78aaborZuqstthAiiyHXCYO" +
       "tPW2W+uiy3rqNlhxxvkVzrPa5mTLEbLl6jSF6gmnMhtB3qBbbAOP16g76zmY" +
       "NQ1VMUDHg0oYWstEG/oOVpsZXmi7MbKdCg7fH+tU3EbHUoYYNtILuuMxYQxI" +
       "tD6OQ0YRJsCPmV5jQVbaZVnaWutB1A4wSJqGtKVv1lItDur6yF8PIJ0bzdTI" +
       "5TO7Mg/ipYptZBaZzOakgMzrUtoc9XvatNeNV4RrcbVt4PAabXbmHVRkVxVo" +
       "Nqxq2WCiD8U03Agtf+P2BLROOdS03nRQdamOlGWXd4MEArMMaasUvAynSXc6" +
       "bWnT1Yrp2jjmZoNZuhjaEa2iUVQWGsYiTD1ksZLbvZmwdBdDoabhGTSawqkZ" +
       "hzNJJhoatdmu4DkkrSYBA6HL1EZnW3U27zEMuzDLq3ZTSd3WkhQg3EiaKcyw" +
       "9BzbLNLAiRsNegyluBynjUats8UrdGS4ns9vWCLwkXCVUYGWzSUzLVORk07m" +
       "6/G4OsgqZH/pTbXR0G6x834sL7sTwm+SUJ1WCH3eMBujpdfr2ItpHbeRQQ+a" +
       "0lu90WslaYb3solDpzObrkvtxqjJNjkB5RuIFi299gjcjJAaNw+4RhUJltQ8" +
       "1heTFpaJNORpQwHyiRrY17TnGaI2BnwbG8DLRldqyqJmdZeuZm+wYBIxs7TM" +
       "GvPNlPds2JrTYGtMUdiqKS71FmTgZjyVq8Mx0RpghiltDVwlU8O1edFCNbGa" +
       "UPhExQbWuso02/hIytgmKrdNHZ6S5aRfUboQueDtrte0U5FDe+Vps17bGAtz" +
       "As2Yfo0e0kKCLdQYbC2AKwiWyognhk6F9lZk3fQG0CSqTHvk0N32svHKWFEU" +
       "rwWzKsKasc/6Y9t2LLGbNaZco9fUuAmhayxQkrQilovRtl8xaosWJa1kyo2w" +
       "dsXBUhSu1pVleTSBgL3SfBNqs5smiPMZebuRFZHampsG1K+IZoRbVT0RXCOE" +
       "0Ga7Wse7AbG2xKqgdbhyUqmOVQPe8h4qSCSe0CZU65BeN5pXhloLnjlzyeZE" +
       "2RE3LFszybLWqijREkQ9TJhttDiF/HXD02tGa0Z4xHqDeKnR1pUqAQ9mKC1V" +
       "KQfiiOEA7fR4OsXqFLJqxgnWXJtYxJqOT2DiejxQMHSgRCzaYdU5wmKm2hbF" +
       "mBC7UV1bNkZ6Y6pvkK5GjVotdWrFxrRJBWvdUBGzjIvuMt0ybS4bgv0RWQ3c" +
       "ZV0PxhBEqOmyzTf1FCyholSvQ8015EiyVQmrHIQ5VWYk6uN6u4wMJJdTRIdz" +
       "nZVrGjKC2j4Nh2VkoVVFXaeDgN1IHZxW1iwE45SCO04FTAAL16U1h9oq8K/L" +
       "RWerA58f8GR5xZK85FVRsu0sK5RJjgICWZoZyeMNtN8a2uVhVJMNIZu6kTJb" +
       "tVMC0ngM6SJkb8CJ6FDK5FjI+sv+jMV7LjwhnVkzWIzNpLXwlbhO1XUZjbYi" +
       "Kukku55ts6panw2wSjVKYrWOTMiJOYJlpS+lzLRvrl2d6NdnMgo7UITM3EEC" +
       "KVDdqZp1mdnGVRzuRwzSiI3A4ih8Q7bhuIn4rqm1xi1JQerkmjbXdYl0VX+u" +
       "txccz5q9EUk4ZXoNrc1eJsKRw6hyt1XOXLS19MsiRsJYhMJbdFufBBZRrqr9" +
       "bWddxSadSVnrxyaMsW0klBr1/mrcV2G07pZruGkJXbubipTaEFQYmrekqUuX" +
       "2R7c5lN5MxtXE3KSGEPZFvWuQ64Uua5D6+0sawVNP7Gh5UChJLBpVjMQx8yG" +
       "iBLZySYLbQMEIk4Wcw0pltRF2Eqma0WxQzLBR5UWWvUgpNymg9Dr82Gz2fxg" +
       "/ujnH7+xR1IPF0/fjg6vLW08r/jyG3jqlJ73uvbod+rA04nnliee45fyV9dP" +
       "3O5MWvGG/kufeOlllf0l+NL+gSYWl+6LPf99trbW7BNd7Q6laEdsXM27fxSk" +
       "2p6N2tnHp8dA/7yvT/7VBXX/Os++Fpeu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("GFrcO3qpcCzXr7+Rdx9nsBVifhwkfI8Nv/PYfu+Cuv+YZ98AigDYmsevBI7B" +
       "/Zs3Ae5teeF7QarvwdXvDLiDYwKqIPjDCxD+UZ59CyCMDhGe+5R27VnqMeo/" +
       "eLMq/WGQ3r9H/f47r9L/cUHd9/Lsv8el+4FK29p5On3tzer0BZBu7tHdfGt0" +
       "elC6PcSDS3nh9wHE6BTEPzmG+KdvFuKPg/TBPcQP3hmIZ16KP33+AQjPjW+Q" +
       "03HX2xvq7Y9K7Cnz90GMFoeWEhXCeeACwT2SZ/fGpYckVT3R7rTwDq68Wet/" +
       "EqTOXnidO279B+++oO7JPHs0Lj0IrJ8+/VLxGOBjb9Y6KiB19wC7b9EEeO8F" +
       "KF/Is2cByugsyhNqvH4nUFJ7lNRbhLJ6AUosz8oA5d5az0VZeRMoH8kLnwCJ" +
       "2aNk7ryxfviCOiLPbubvmrW4u3+1m9P94jG8D9yJ9Xe4hze840r8xQIHfQHG" +
       "YZ6RAGN0GuMJFVJvAmMRHD4FErfHyN15Fc4uqFvk2QiE4ECFw8QhTx8aOI4S" +
       "D8ZvVpEfAGmyBzm544pkCjTqBUj1PHsRrB1AkWdgntDlR94EzDwOLs5uzPYw" +
       "Z3ccJlJAueD000F+tu9gtVtAjmHmlPwxSvsNHXcCW4fDLx/y89yP3fJ91e6b" +
       "IOUrL1+98ujLk3+3O2F6+N3OfXTpip7Y9smDfCeu7/FDTbcK3PftjvX5BY4s" +
       "Lv3QbY9YgoA3/8tZPUh39D8Tl95xHn1cugvkJyk/FpeunaWMS5eL/5N0nwAB" +
       "2jFdfgaquDhJ8nOgd0CSX37S3/mTg0J+j520kCKie+T1RH5iH/rsqaOCxVdv" +
       "h8f6kt13by8qX325P/zp72K/tPtiQbGl7Tbv5Qpdunf38UTRaX408Onb9nbY" +
       "1z3U899/6Ffve+5wZ/vQjuFjaz3B23vO/06g4/hxcbJ/+48e/Qcf+Lsv/35x" +
       "TOX/AzPmjauOOAAA");
}
