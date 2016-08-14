package org.apache.xpath.axes;
public class WalkingIteratorSorted extends org.apache.xpath.axes.WalkingIterator {
    static final long serialVersionUID = -4512512007542368213L;
    protected boolean m_inNaturalOrderStatic = false;
    public WalkingIteratorSorted(org.apache.xml.utils.PrefixResolver nscontext) {
        super(
          nscontext);
    }
    WalkingIteratorSorted(org.apache.xpath.compiler.Compiler compiler,
                          int opPos,
                          int analysis,
                          boolean shouldLoadWalkers) throws javax.xml.transform.TransformerException {
        super(
          compiler,
          opPos,
          analysis,
          shouldLoadWalkers);
    }
    public boolean isDocOrdered() { return m_inNaturalOrderStatic;
    }
    boolean canBeWalkedInNaturalDocOrderStatic() { if (null !=
                                                         m_firstWalker) {
                                                       org.apache.xpath.axes.AxesWalker walker =
                                                         m_firstWalker;
                                                       int prevAxis =
                                                         -1;
                                                       boolean prevIsSimpleDownAxis =
                                                         true;
                                                       for (int i =
                                                              0;
                                                            null !=
                                                              walker;
                                                            i++) {
                                                           int axis =
                                                             walker.
                                                             getAxis(
                                                               );
                                                           if (walker.
                                                                 isDocOrdered(
                                                                   )) {
                                                               boolean isSimpleDownAxis =
                                                                 axis ==
                                                                 org.apache.xml.dtm.Axis.
                                                                   CHILD ||
                                                                 axis ==
                                                                 org.apache.xml.dtm.Axis.
                                                                   SELF ||
                                                                 axis ==
                                                                 org.apache.xml.dtm.Axis.
                                                                   ROOT;
                                                               if (isSimpleDownAxis ||
                                                                     axis ==
                                                                     -1)
                                                                   walker =
                                                                     walker.
                                                                       getNextWalker(
                                                                         );
                                                               else {
                                                                   boolean isLastWalker =
                                                                     null ==
                                                                     walker.
                                                                     getNextWalker(
                                                                       );
                                                                   if (isLastWalker) {
                                                                       if (walker.
                                                                             isDocOrdered(
                                                                               ) &&
                                                                             (axis ==
                                                                                org.apache.xml.dtm.Axis.
                                                                                  DESCENDANT ||
                                                                                axis ==
                                                                                org.apache.xml.dtm.Axis.
                                                                                  DESCENDANTORSELF ||
                                                                                axis ==
                                                                                org.apache.xml.dtm.Axis.
                                                                                  DESCENDANTSFROMROOT ||
                                                                                axis ==
                                                                                org.apache.xml.dtm.Axis.
                                                                                  DESCENDANTSORSELFFROMROOT) ||
                                                                             axis ==
                                                                             org.apache.xml.dtm.Axis.
                                                                               ATTRIBUTE)
                                                                           return true;
                                                                   }
                                                                   return false;
                                                               }
                                                           }
                                                           else
                                                               return false;
                                                       }
                                                       return true;
                                                   }
                                                   return false;
    }
    public void fixupVariables(java.util.Vector vars,
                               int globalsSize) {
        super.
          fixupVariables(
            vars,
            globalsSize);
        int analysis =
          getAnalysisBits(
            );
        if (org.apache.xpath.axes.WalkerFactory.
              isNaturalDocOrder(
                analysis)) {
            m_inNaturalOrderStatic =
              true;
        }
        else {
            m_inNaturalOrderStatic =
              false;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QMLTxcnruvDM9wVk/AebnHqyQx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "28qScEbKlmdxZ+i0qZEiVfVhj3XjneGMGoNVs4YlmdK2rHaQVVcDnK3wKzdi" +
       "DG/b9TVkaLO1fuZV7NGg2/Mdkh94UYP0RVJk6xTNYGq1P9OIFT72kN68Plmz" +
       "Cm1veK+f7/Iwa7uprcYeO6jO7C4+W67W6Ghq8u1ojmgy1R03xhJimn6D1ACm" +
       "pe1KsiilPCnOmBor8q615sNIQ11ptMOdxW5CDPh5xjSX7by67OW9AAXTyt68" +
       "NqRm4ZzWRURZswnndmZ9bFt3VRdtkz6T5wzRDycig3gNZ86ALvhiEc+d4YDL" +
       "tU2kjlNr4DTclYjCqbDD/TgSWMZSFVo2kx3XHm6smLEsquPQw6G7jFa2O+2v" +
       "J8nItpoU7u16Ap8hWZLg0W7VDfHeKm9x/CLOuYjp9tO6sp2qbdZjImZSG+wI" +
       "Y7q0ZViN15HeWq6oqTqqxy42jeL2looU3Z6vVMUCS2Vp5yE7bzlE8GGFdxuU" +
       "M7A7rbUoKVlg1ODeSB4FElf11ordpeVgasH9YbPeHvFyP7StwXSXtHtMU8Vr" +
       "I6RiTQS0tRtUrVmCqa31CtPa3cZSATyIVKtDa1VGZTzHx+C66xJwugj7pMJM" +
       "gIZ7w9YMHW9XXjKRvGiqh4pDbltIYm8r9DyfiaqFbjrLFpnVWh3gTmOYwAgz" +
       "pvkEbnm04s55z58NIym3O4Y7iTfUfCcjdL5GWwtdXHu25zR9ROjsKjSy43SO" +
       "RyaKuzYGW7zvM1RGzCoYzkRkY8Bs10ZzWVNGnkKyFr9DBDfpuUt+NWNCSXFp" +
       "ViLrrqOuQ9oZG5O+b493wjo3EsOt7hbOWOWFrozK3sZieXzS7/nLLmG20jXi" +
       "s4auhVS22HBKdSJZzFidt30y6lawMBaH4jpWZFsSXEGWharK5oJEZdKaGRhK" +
       "c1jvSIAX3Lbmueouuoi2ylee1hUldqQGyqQG4oNDMQGIafQqzANO3EiWzOgj" +
       "mwpqHbWqNpVBL+hGUgP2EpMOzEzkV8xSYtDhZNqebEfmVO2uR/2JGy7QhbtO" +
       "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" +
       "KmwIuJdNG5SSVT1yQSnRymnz7pL26nLk5XKTCAdOSlV0dIYRpFChlAVHVJrb" +
       "VXdWm877oapOVyrGNdcMOvfZfNdD3ZFdX6Ugd1pcgqwba2oAJE2gTsrV4LGF" +
       "8ytvNKrgVlJFWBOd4CNxggwoBqcI0e1phF/Te2Jr0qXrczOR0wauaHAWj+rO" +
       "mJaiJBV4jfV7SJXISb0eTA2T0ji/RVTYhSsSiAebHhmDeVUsjULOQ8KM1PzG" +
       "mKjJiswHtmfY0lDpc6hR7Sd6Gs+X0mycgnxtLPlOV8nkVlhPO5WsjmH4lhDA" +
       "wshDp16zum4F0gZGsI05phSrwVn8CJH7K05eCarbgJsDuA+TnrLqK8hOnyEK" +
       "oVU4NCMIzEC4LIiW/UUFZbksiYB+WyTZTUD2q2A6CE09AyGURZ5L0zzF1hN+" +
       "t7Fj0u510E59zotcvyvVuFTHcQKt8DA62CXG0h2EC4rZRpV80U6x0bRB5gtZ" +
       "dCpYU5CzQJnCw2mlNXU6uszzmwB0johFL58LVsIOKut6hrUjZUIM5yLOMJvY" +
       "5HxaD+DtvEupQhfvEoSRphq+npnhYFDJZ9F2RVeHSVsQsUpIpyo1bruNMM3n" +
       "s2Zdko2WzI7DVnvMO7SpoKjd2EnUpDHMkKY9ptx8ocN+FiMVlE5bq+W8zg4U" +
       "fSgxvKJjFA4mA5shaVAyPFV5pYmiLoduacrpeRuSTiKumThWJ2orlFSzlLSN" +
       "7NJ8MKuNCM1z8EkTjtczjBtTLbEj97jQ267ptrwzlgtLr3HxFCRvj1J8WE8W" +
       "/gaNa3InEpjdUDY6iKuk/KqP1+u0jE0TfdNRuDrlDnojPqdtMH03MKPur1bO" +
       "cg3XIwlfT8UZLNYmDmInPa098OcZHODUdjNL251FZ9fsdOxmbYTPkh6YXHXF" +
       "dJBqQ6XLg9WxwdkhR2TjodWpMFE36hmzhb6ZMLSYaX6UbkiG2MoruGUsfGq9" +
       "m2RFPPvAB4rl/fe9uS2Gh8rdkJMT86OdhfxN7CzsPz1dFM+d7CSVv6vQhVPW" +
       "i1vfjx3vmEfQE693EF7u+X7mwy+9rHM/UTs4OqkYJdD9SRC+zzU2hnsG1WWA" +
       "6T2vvz/KlPcATjcpf/fDf/24+K3LF97EGeJTF+i8iPKnmFc+1/9m7YcPoMsn" +
       "W5a33VA43+n58xuV1yIjSSNfPLdd+cT57conwDM5kuzk4h7dXQ4nLpVWsNf9" +
       "XQ6Cfuwu3z5dFJ9MoAdAuAm0ckPP0MvNvFNz+dE3s79dNvzICX/Xisb3gueD" +
       "R/x98E3wB70haz95l28/VRT/LoGe0VS/bRQH2wZQ0tHW5TGzZ3YvTxn+9/8X" +
       "DJcHs8XJ0G8dMfxb/28UenBytP7063gEr25LN7ul/crky1/4dP7qK/sjk4Ua" +
       "GwlUeb2rS7ffnirOvp+7y/n96aWWv+//q9f+6r/JHzx25LeciKEwaeh9dxPD" +
       "+Q3a8rhHNooTv6L9V4qiX+L8+buo+NeK4rMJ9KBpZ2koq1F5XBvfcS99E9j6" +
       "qYpffVNnNgn09jtejChOeR+77WbW/jaR9tmXr9/36MvSH5d3A05u/NxPQ/eZ" +
       "qeuePcs4U78aloe8JeT+ZCMs/34HkHDHGxuAs+KvpPm397CfA0K9CJtAV8r/" +
       "s3CfT6Brp3AJdHVfOQvynxLoMgApqv85PNbYc1/X1ZHs0vmkcCL6h99I9Gfy" +
       "yLPnzLC8KnccqdPxkbW/+vKQ/c6v1n9if5dBc9W8zHf30dC9+2sVJ9H+6dfF" +
       "dozrKvXurz34s/c/d2zQD+4JPnXZM7Q9deeLA10vTMqj/vyXH/2F9//ky39W" +
       "Hhb9C8QiPfvDKAAA");
}
