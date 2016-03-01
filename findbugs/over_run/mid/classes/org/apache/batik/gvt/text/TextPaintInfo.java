package org.apache.batik.gvt.text;
public class TextPaintInfo {
    public boolean visible;
    public java.awt.Paint fillPaint;
    public java.awt.Paint strokePaint;
    public java.awt.Stroke strokeStroke;
    public java.awt.Composite composite;
    public java.awt.Paint underlinePaint;
    public java.awt.Paint underlineStrokePaint;
    public java.awt.Stroke underlineStroke;
    public java.awt.Paint overlinePaint;
    public java.awt.Paint overlineStrokePaint;
    public java.awt.Stroke overlineStroke;
    public java.awt.Paint strikethroughPaint;
    public java.awt.Paint strikethroughStrokePaint;
    public java.awt.Stroke strikethroughStroke;
    public int startChar;
    public int endChar;
    public TextPaintInfo() { super(); }
    public TextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi) { super(
                                                                         );
                                                                       set(
                                                                         pi);
    }
    public void set(org.apache.batik.gvt.text.TextPaintInfo pi) { if (pi ==
                                                                        null) {
                                                                      this.
                                                                        fillPaint =
                                                                        null;
                                                                      this.
                                                                        strokePaint =
                                                                        null;
                                                                      this.
                                                                        strokeStroke =
                                                                        null;
                                                                      this.
                                                                        composite =
                                                                        null;
                                                                      this.
                                                                        underlinePaint =
                                                                        null;
                                                                      this.
                                                                        underlineStrokePaint =
                                                                        null;
                                                                      this.
                                                                        underlineStroke =
                                                                        null;
                                                                      this.
                                                                        overlinePaint =
                                                                        null;
                                                                      this.
                                                                        overlineStrokePaint =
                                                                        null;
                                                                      this.
                                                                        overlineStroke =
                                                                        null;
                                                                      this.
                                                                        strikethroughPaint =
                                                                        null;
                                                                      this.
                                                                        strikethroughStrokePaint =
                                                                        null;
                                                                      this.
                                                                        strikethroughStroke =
                                                                        null;
                                                                      this.
                                                                        visible =
                                                                        false;
                                                                  }
                                                                  else {
                                                                      this.
                                                                        fillPaint =
                                                                        pi.
                                                                          fillPaint;
                                                                      this.
                                                                        strokePaint =
                                                                        pi.
                                                                          strokePaint;
                                                                      this.
                                                                        strokeStroke =
                                                                        pi.
                                                                          strokeStroke;
                                                                      this.
                                                                        composite =
                                                                        pi.
                                                                          composite;
                                                                      this.
                                                                        underlinePaint =
                                                                        pi.
                                                                          underlinePaint;
                                                                      this.
                                                                        underlineStrokePaint =
                                                                        pi.
                                                                          underlineStrokePaint;
                                                                      this.
                                                                        underlineStroke =
                                                                        pi.
                                                                          underlineStroke;
                                                                      this.
                                                                        overlinePaint =
                                                                        pi.
                                                                          overlinePaint;
                                                                      this.
                                                                        overlineStrokePaint =
                                                                        pi.
                                                                          overlineStrokePaint;
                                                                      this.
                                                                        overlineStroke =
                                                                        pi.
                                                                          overlineStroke;
                                                                      this.
                                                                        strikethroughPaint =
                                                                        pi.
                                                                          strikethroughPaint;
                                                                      this.
                                                                        strikethroughStrokePaint =
                                                                        pi.
                                                                          strikethroughStrokePaint;
                                                                      this.
                                                                        strikethroughStroke =
                                                                        pi.
                                                                          strikethroughStroke;
                                                                      this.
                                                                        visible =
                                                                        pi.
                                                                          visible;
                                                                  }
    }
    public static boolean equivilent(org.apache.batik.gvt.text.TextPaintInfo tpi1,
                                     org.apache.batik.gvt.text.TextPaintInfo tpi2) {
        if (tpi1 ==
              null) {
            if (tpi2 ==
                  null)
                return true;
            return false;
        }
        else
            if (tpi2 ==
                  null)
                return false;
        if (tpi1.
              fillPaint ==
              null !=
              (tpi2.
                 fillPaint ==
                 null))
            return false;
        if (tpi1.
              visible !=
              tpi2.
                visible)
            return false;
        boolean tpi1Stroke =
          tpi1.
            strokePaint !=
          null &&
          tpi1.
            strokeStroke !=
          null;
        boolean tpi2Stroke =
          tpi2.
            strokePaint !=
          null &&
          tpi2.
            strokeStroke !=
          null;
        return tpi1Stroke ==
          tpi2Stroke;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RQSf+e/2r57jOYC1IbHvx2I1b7oSizVionz9q/kPK64REufzuhYLN7L+RYKf" +
       "Rtz89tGb33/nubOPxMRepis4qfvk2v+5QU3f/dfPKpjH03mVfZZPfjhx9OG5" +
       "vVd/yOXdvIrSi4uV6y2sPK7spUfy/4h21P02SmLDpEW2d/6bJbWA2WoYdruW" +
       "cxyA00FZe/nOVWzTekrrxgX+nO5R68/o7joP79gb36dVS+Lz4OmwmdXhJ2WE" +
       "8JdNobwMkmYkNqZYCiQwnjA8ocYD5FAhbbFBU8lDgh+zt7fHZp/d9pvYjuuc" +
       "rWs1EdHzRmvgxC/WvZviC0g97hs2OUZ6dgRrzBHP6tUioH8JfxF4/oMPQsYK" +
       "sVFs67V3qwtL21XDwHwUwjyfCYmdbW+PPvzeY8IEP818nemeffd9Gd+7T6wK" +
       "4syzuOLY4ZUR5x5hDha3ILpFYVq4RN+7x3b+8oc7dwtUbeU7+LVwQH3sD//+" +
       "XfyhP79UZZMYS+u6SiWtIsHgUcAXIWFW3YqDn9957+sbYFfST+oLmrKtQPsz" +
       "5aSMWYW0J2Tuicolqm0ghoeRSDdEws2RPAPddK4MtL6c6gvgWWyTdXEA1dVQ" +
       "qgdJM9IARxSVJ1Mn8U7ny4U0zuK82oc9P0HseJTptLV3BmAvhGIPkmZkKuw+" +
       "9VFagrnNh3VsglgxESyxtS0JwHpHKNYgaUaaBNYhXjqubi65WtT78O+cBE+W" +
       "2giWBuC/JxR/kDTDxSTPd7Ul8G0l8L1Okw//vZPgykU2gosC8O8NxR8kDawu" +
       "aLDdwvN5IF2+PUG4F8LTZSvsCoC7PxRukDQjM0twh8I5fmASHO+21XYHgH44" +
       "FHSQNNDZBxqrd/nwHpwg3oXwLLM1LgvA+0go3iBpRqbpY+egxOEJosV5s9zW" +
       "tzwA7ZFQtEHSjMxw0J6DET+exKyL21rjAZh/Eoo5SBpmXTnmaoR4coJwMbVe" +
       "Yiu8JADu06Fwg6QhpUGSVkYpXiEURnKBHv75BCFfDM8KW+mKAMjPhUIOkmak" +
       "vQzyOahxfBJ0vtRWfWkA8OdDgQdJA52rAK/GjxcmwY+VttaVAZhfCcUcJA2L" +
       "IBxaTNabsy/sbsbiFoHvVs97mpEaZ0Pl2Xjiz5x/L/jq/8C8N7A4wfglNYLF" +
       "n6d8ek+H6C1Wcw//qyO+S2qPds8ZmeDufl7QdwS+sz98975DmQ2Projap3QZ" +
       "vMt0Y7lKx6jqGSrKzwn+4/YA/3rinl2vPHW25s0H2psqr2NxpPkBl63dwacj" +
       "v4IX7v5g7qarc1sncM+6wGe/f8gfDRx96fql8gNR/gFIHJUrPhyVC/WUn0Ua" +
       "TcoKplZ++uio5MsqO2Kr/HxxORE0F4JEq9/d4M8+PurfQy5kPsHifZgjFmXV" +
       "5s6UMV3JuEz9YOL3Nbz6byVr5mITHh+ytjXZEEfwsguLZYKA+LqckTqLf4z0" +
       "3bK2hozqc0HUHa7PddSXwY6KcH9+xkgj3VZQxuB8L7L6Ftc3n0/iLgv2PWUX" +
       "aHhF2F7xZVZ8TZQfP9RcP+fQTX/kF/WlL35NSVKfLaiq97LG815nmDSrcPOa" +
       "xNUNPwJH6hk5L/BWD+KO/xB1JCb6T4V9cLX+QB0ovT2nM9Li78lILf/v7dcK" +
       "znT7QVDFi7fLTBgduuDrLMM567Twsw7ebsXF7VYxUp7uShGZda6IeDLk4rL8" +
       "w7+hO7miIL6ip+Rjh25Yf/uZKx4VXxxkVdqxA0eZmiQx8fGjlG8WBY7mjFW3" +
       "ruuL6U80LHFybqsA7JL/fM8svQbms4HcmOu7jrc6S7fybxxe9ewre+pORUlk" +
       "C4lIsKhvqbwHLBoFSIZbktXuXCAb8y8FPY3vbD3x2elIG7+DJuKWZn6YREp+" +
       "8Nk3B7OG8b0oaegntbCk0CK/pLxuu7aRymNm2RVOXVqHw4nwVZJMRyJL+H2d" +
       "e8Z26LRSLX6xYqSj8kar8iteo6qPU/NaHJ3nYF+GLhiGt5V7dkSkO/Q0cC2V" +
       "HDAM+yovdh73vGHgVI1cxDcM/wVkzR1UKCMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16Cezj2HkfZ3ZnZmf2mNlZH5uN9561vUv7T90ku7ZrXRRF" +
       "URJFipTEpFlTvMVTvKV0cxhNbdSBYyRr1ymSRQs4SBo4dlDUbYHWxQZF4wRJ" +
       "Czgw2rRo46AI0LSpgbhA3CJOmz5S/1Mz/9mZLVoBfCLf+957v+99B7/3+H35" +
       "O9ClMIBg37M3uu1FB2oWHazs+kG08dXwgKLrjBSEqtK2pTCcgrrX5Bd+/fr3" +
       "vv8548ZF6LIIPSG5rhdJkem5IauGnp2oCg1dP6nt2qoTRtANeiUlEhJHpo3Q" +
       "Zhi9SkMPn+oaQbfoIwgIgIAACEgBAWmeUIFOj6pu7LTzHpIbhWvox6ALNHTZ" +
       "l3N4EfT82UF8KZCcw2GYggMwwkP5swCYKjpnAfTcMe87nm9j+PMw8sbf/pEb" +
       "/+AB6LoIXTddLocjAxARmESEHnFUZ6kGYVNRVEWEHndVVeHUwJRsc1vgFqGb" +
       "oam7UhQH6vEi5ZWxrwbFnCcr94ic8xbEcuQFx+xppmorR0+XNFvSAa/vOeF1" +
       "xyGR1wMGr5kAWKBJsnrU5UHLdJUIena/xzGPtwaAAHS94qiR4R1P9aArgQro" +
       "5k52tuTqCBcFpqsD0kteDGaJoKfOHTRfa1+SLUlXX4ugJ/fpmF0ToLpaLETe" +
       "JYLevU9WjASk9NSelE7J5zujj3z2R13SvVhgVlTZzvE/BDo9s9eJVTU1UF1Z" +
       "3XV85BX6C9J7vv7pixAEiN+9R7yj+cd//bsf/9Azb/3WjuYH70AzXq5UOXpN" +
       "/tLysW++r/0y/kAO4yHfC81c+Gc4L9SfOWx5NfOB5b3neMS88eCo8S32Nxc/" +
       "8avqn1yErvWhy7Jnxw7Qo8dlz/FNWw16qqsGUqQqfeiq6irtor0PXQH3tOmq" +
       "u9qxpoVq1IcetIuqy17xDJZIA0PkS3QF3Juu5h3d+1JkFPeZD0HQFXBBj4Dr" +
       "eWj3K/4jyEAMz1ERSZZc0/UQJvBy/nOBuoqERGoI7hXQ6nvIEui/9eHyAYqE" +
       "XhwAhUS8QEckoBWGumtE9ARIOjfWKSgYCehuHyA6yDXO//84V5bzfSO9cAGI" +
       "5H37DsEGtkR6tqIGr8lvxK3ud7/y2u9cPDaQwxWLoA+ACQ92Ex4UEx6ACQ/y" +
       "CQ/OTAhduFDM86584p3YgdAsYP7AMT7yMvfXqE98+oUHgL756YNgxS8CUuR8" +
       "/9w+cRj9wi3KQGuht76Y/qTw46WL0MWzjjYHC6qu5d2Z3D0eu8Fb+wZ2p3Gv" +
       "f+qPv/fVL7zunZjaGc996AFu75lb8Av7yxp4sqoAn3gy/CvPSV977euv37oI" +
       "PQjcAnCFEViz3Ms8sz/HGUt+9cgr5rxcAgxrXuBIdt505MquRUbgpSc1hbwf" +
       "K+4fB2v8cK7aT4KrcajrxX/e+oSfl+/a6UcutD0uCq/7Uc7/xd//1/+lWiz3" +
       "kYO+fuqVx6nRq6ecQj7Y9cL8Hz/RgWmgqoDuP36R+bnPf+dTP1QoAKB48U4T" +
       "3srLNnAGQIRgmX/qt9b/7tt/8KVvXTxWmgsReCvGS9uUs2Mm83ro2l2YBLO9" +
       "/wQPcCo2MLZca27xruMppmZKS1vNtfQvrr9U/tp/++yNnR7YoOZIjT709gOc" +
       "1P9AC/qJ3/mR//FMMcwFOX+pnazZCdnOUz5xMnIzCKRNjiP7yd97+ue/If0i" +
       "8LnAz4XmVi1cF1SsAVQIDSn4f6UoD/baynnxbHha+c/a16ng4zX5c9/600eF" +
       "P/3n3y3Qno1eTst6KPmv7tQrL57LwPDv3bd0UgoNQFd7a/TDN+y3vg9GFMGI" +
       "MvBa4TgAfiY7oxmH1Jeu/Pvf+Bfv+cQ3H4AuEtA125MUQiqMDLoKtFsNDeCi" +
       "Mv+vfnwn3PQhUNwoWIVuY76oeOp29ccONQO7s/rn5fN58dLtSnVe173lv7BT" +
       "z2K8YtSP3UU+H88LvGiq5MVf2QGv3xOPO9oni6cngBBePt+HEnmAdeKGnvzz" +
       "sb385H/6n7cJuvCed4gr9vqLyJd/4an2x/6k6H/ixvLez2S3v19AMHrSt/Kr" +
       "zp9dfOHyv7wIXRGhG/JhpCtIdpw7BxFEd+FR+Aui4TPtZyO1XVjy6rGbft++" +
       "Cz017b4DPXmvgfucOr+/dief+TS4XjiU/Av7SnMBKm6ond4U5a28+MCJDnzw" +
       "0D39JfhdANf/zq98nLxiF2/cbB8GPc8dRz0+eNteSczQBN7k7pJlAtMBLjc5" +
       "jPiQ129+2/qFP/61XTS3L8Y9YvXTb/ytvzz47BsXT8XQL94Wxp7us4uji3V6" +
       "NC9GufE/f7dZih7Ef/7q6//0V17/1A7VzbMRYRdseH7t3/yv3z344h/+9h2C" +
       "jitLz7NVyT0x0MJSBm9nKd2zcnwWXC8eyvHFc+T4Q3eVY8FvBF0FwaVdhDoF" +
       "3bsj6LHCkUlpdFBU7wH94fsEmgehtw6B3joHqHIvQB8GMYpnqceYPrEHTL1P" +
       "YLn2v3QI7KVzgFn3AuyRHTCuKI8W8frxIu7q98Da70Dc7z8E+/5zwEb3JO58" +
       "R5JHNcdIbx4jbR817YGN34HIP3gI9oPngH39XsA+Frvg3Zrvhs6V+o/dJ7YP" +
       "gOvlQ2wvn4Ptb9wLtncdY+Purpc/9Q708pVDhK+cg/Az94Lw+h7CvNrfA/fT" +
       "9wnuOXB96BDch84B97P3Au5RL3kbyf7cfULLzeLDh9A+fA60n78XaE8cQXsb" +
       "wf6dd2AWB4cAD84B+HfvySzOAryTXP/efWLLHWDpEFvpHGy/fC/YbgJnaFpq" +
       "vnuLdePctfuV+8QHg6t8iK98Dr6v3Au+J8/gexsJf/UdqGDlEGXlHJRfuycV" +
       "vAPKO4n5H70DMdcOAdbOAfjP7uk1AuLQIGobh8eyk6J6B4aPoAduDxu+/v8A" +
       "6W/eC9L8iC3HmT/+xh6ob7wtqB1fF8Du/FLlAD0o5c//6s7TPlBMC7bxYXHc" +
       "DHpopivZRzjeu7LlW0eRsaAGIdif3FrZ6NFr+EbxGs53Age7M9s9rKN7xgpC" +
       "2MdOBqM9V3/1M3/0ud/9mRe/DcJRCrqU5HsPELeemnEU5yfif/PLn3/64Tf+" +
       "8DPFqQRYR+YL3RvFju7378ZxXnwzL37viNWncla54lCPlsJoWBwkqMoxt3va" +
       "8qDt/V9wG13/D2Qt7DePfnRZlCqpXGZncFxr4FHMdFdoNuy3EbKt6FacTtte" +
       "lR+0uYVjuIKZcV2u4/DbcTWZj6tGRVxR2zJe6/K6zlFjijTNFiXxycZotCsS" +
       "1+QJcVZp2oNynesOeIHmJ3bboCW/JsAs2Ra5Ck5lqFgVHbEqOxWCCiSp7qJo" +
       "1XVjWMbw8pasMqVFmQocadqxaG5I9LRlZxYQLYTA+U4/cmJboOREatG8Dy8b" +
       "CEOu3IqCVdH+moud7obhFLGJUlZp2iDWhh04w2w66keUY20iXGQdvkdP/Nai" +
       "nG04pzHyUkcSFsjc7ggzjuioumgapQoHOIm666HDrxtpz0SYSXPVrvfl6WKw" +
       "4qRtpsAGZZmiOEIltOkydIv08KWiV1F4ve31bKpqSiNuYbV5nO3yAbGY4l2L" +
       "yOJG7Ja7ZcGRCdvFRomwqWTdKtWGE7nLkF2somkugQTeDF0sJEuaBivK9pZr" +
       "aRYsttyUGpZjVFgL9XU5qhOxRVmOo668bcm3S3ZbbEqTAT9OpEYy6eCjgSdg" +
       "Qakxqsn1Ps6LQ50yRYKs9/uixbk26nR74x4veSK6jOYtM5wL5qasO9UtNsWJ" +
       "jVbRVG1mm0rAMcNUEqRSfzFZNVO9x3nLljflNH8tlSl/bDgzkltbZNNomD43" +
       "WG/SWr3iNGZDqdUPmk1ejiotO5WaThl2G22zT0W+RTiq7WyWaUjV5/h6KwWc" +
       "OdIble1ccAiDxKWOvigNmp3xtut2GMK3NmtHF7fr0cYUByN3qrRbWXtU51y6" +
       "wQkCv51QA8tcen19LXFjqs+1tZFOKVJ1pntDp06smh4crSd1gvCNAVhVTav2" +
       "MnZUGsStcUoRPQosBiaSurka4fyc6tZhptxAJBWNK1Mv5tq9zpgnbAIhRi0p" +
       "/3DYZka8z7SZVrs9VapUE6dDERG77QU5DqsbhRVhrTonHHxJ17MyxmtyIyk5" +
       "SgdeLdZhncXGnSpeb87wuQAHE3ZVNpya32PSzQaxwh7KLlXP64lUIPpsLxuq" +
       "tRIZITVkWK6SUldjLXvFNJypspxNWlmjvHEDlSfY9dzCypK1HoqJD/Dwm2S5" +
       "wV1sqjOS7QkjNt70FtEmCSiCEuZlFegdqnvt0lg3s8CYK71NnIwAo8DsamGv" +
       "z016nYrTFrMuqyEp0kft7jREpkabpZ017Zs8MWWRMPM6W5dvJuoQb60bfauE" +
       "kXgJXgQ1e2LTdN1obvpsvDIn1qI7G5vhsrtpGd2eqQWUqfcotRUzm/agD4+H" +
       "SGMc9yMPX2xTThdbcq2L9QfhxlaA1nszcVC11ZoSV8SsPEzaKG206C6ehSbh" +
       "dZoxMZTq6Ur3VgOmrVJ2u+vZKTMdseFER1u9Eu+vEKvakGJvhqghKTBsWk23" +
       "rKkBZWUmkWoTasQG9dB1x5xqebBaJVeVrB2PWMBQe21ZHTUGi2eUbLM0WFil" +
       "rSLaTr8dEvQEH5tW2qVTQ5DFzqpTqyYVd+tS7IYcYchKp2cTz25hXXq05fiZ" +
       "q1Xr8x6q1PFqrJGrOOWriqtGbrsmZVVCHCwmnQAoCr906wOUKPmML6JiBQib" +
       "3zSDCSc63Q41lBMGH4cexy3gqT3qzdRVs7auR3VO5h2qPqyE/sZfoWHZ7TUi" +
       "hCw5Bqmvt+usog4aqZ8FyAoYWIfbum3SM8VqNsMGU2TFkavaOE4SFxMVVN0y" +
       "KxYlkoWxcT1sPLFICWZEH5/ZtbY05eNV1a/JPRLfIphai1wSmSyq3bIhlhe4" +
       "1QcRWLvtwHhdVsLlEsXLMC145nLItrxo059UUadCU9wgdVcc0euHuMJQnalA" +
       "rYINFYydLav7IiX4NDuQRRpbV13KXMtwJQpNddBqr/jxSlRlNR2UELTsb8pY" +
       "XHX9KmPU3H48kBqMO0ZNfoKnWbm+mtmDSkaQsqL6qoLjk6nXH7AIFwzmodfJ" +
       "tt241km9ccWKYq02FuwkWATh2Cwl40nilmE14fFBksDlaUOMkHgqDrMsgtUl" +
       "1YPD1kbVWXxImRzb67nwiBmNQ2uQarhg1DWtFNNqktI9srtg/YkhCd5y2jW2" +
       "2ZQCrJeDRUNBcDURZyVkZvV0TRLY8kAZuhhv93peRykP/ZZhplK5kc5StpIY" +
       "jQHhlLz1qqsg9FpX10uhrldJDXWNxtbC54jamczqGa/12bqtMfbAjwZCeabR" +
       "ZT3OpAFqeULLC+o1dsJpsIpUgjq6Gi/a5f6STLJKv7xEPc7cCiDA2uJrxGIG" +
       "jRrbjbVtbCzoEUrD7GKgsdEWw6PeslpF3Hg5ZrIhq/pmWFtriVVJ4PqEr2qI" +
       "ojEDf0WWqo6giSKjrYwMH/fqiaAgm/FcSfrAvddiobGphMwADX1e2yA1o1Jm" +
       "wDvWoTt+d1ZRkMaSWs6alZm3UIJ4JmebZqlEiCrijoXZdqpaQZDpc9gd19kG" +
       "hnjoymNQXF9WG4rAwfS2NnZSR5kbVGXWxShl5C3ToeUsrNFaXLTNCVC6JubJ" +
       "i06daBrLJdHiMbujG/A2QjVS9BEF95PFKo7lYBaWuwq5ZZ1Ez9rILBETs13S" +
       "cdQIK2NebCg6G2xbJNOIeNMjMUrLiBriDZlJuBiEAhE2UKG6TiO6Up53UjLl" +
       "09VGay8c4K5hhkm26gLrdxmsjLmqo2qagvcUGJ020kEt3GzjMb2oiTxbz+pG" +
       "x5CqfdonFsK6xo5gNKsuYcAAqqQRv1R5FNhWOiGrYQdB4Lm2McBi8KI4XHBw" +
       "3ODMWdQPSZ2Xm/P+jJhVF+uOi+N1FA6XC0LjprBHO8EgmjDhti5xw9liVqIq" +
       "09iUPXvtlHTDU1muo3TTsMIyTUZRBrVhRDfkhp7os9lmqsy7zbIiTNa6Qg3x" +
       "fpPNOIEq53qMupsaX9rGA6ziyThTIkOVmvoRLVRbTjMxen3GckRrEKcwLhCS" +
       "HrgjoyqEuq1nXW6TRVyJSkmfHIwWusRLUmu0MOardbw0G/VZNEWxMSy3uvCs" +
       "opuzVtxGqIxFrM60k3FTRkF5G+uVbIwuj60UQRKR0TcWX9G9sI2NsVHGYlZH" +
       "SmOJ7ihpMqr3iQrM8L0agdFTkUvCttdGmYyNrc5kNSxFqYH165rT5MgxDES5" +
       "IHWyViNIbjIadcRWtg4UxAVQU73qzVOaHpZpPWnCJd2rmi2fXS/9Bazq2bhL" +
       "eaFQD/HtLNqmTVQkJlGX5FbDLC1RjU53CqvZYAN0JVg1RQPpel6da/nOfOo6" +
       "ksfWZI9Kh0tBXZgxRjU7calBpHpjYvh8jxOshT83uzzrDlpkgtZbbULrDLHB" +
       "DHYGzeGKMfj+2HIkK5lsN2PJyLQWVUoidqbNrCY2Vjr6RKGa9UrQHCC9VSY7" +
       "6QIWokgSAA6tLfMy1azQ/VYmTUfSMtwg4TJcghcumQghjjp+VxJLjF2Zr8xt" +
       "PUNoZLVGsDaIKZq1VNPt0YIm3IaCqRZMNtrlmQzksd6MYa6yZpQQEx21E2s2" +
       "OlFSDg63OIaj9Y4zqeRJEJJfnYjJMCotUHuQNVbrHvDa29SFa8iiiVTBfs+u" +
       "JAw5q9TDElnxw3VQGWU+Y7XsRlVJJXmV1PpzNKnr6FoK5HLoykMYxO4qomG6" +
       "1mEzvKGtbUwfsYhO9EmKDxhjIwAz590SL01lb+DbIgzHplcfhutxZRAgZJaN" +
       "2W6JqFHdNY4otSEGM3GgTTZ1iwlJUxP1FeHMgZAb/FCoUnF3iy/GdHW03DaW" +
       "GyGoO/0pacCbaDUXu10tDfWYFheDJkyvZWu6prXatlRdDiqGt13LJZInJRQY" +
       "HDdPF42BTOJwZumrqiBOsriF0SjdICK56pYQE+hbhZnxc4k0iAqBZqIgYlNx" +
       "ojE4KzOwNpnOEYtAZjZdrY84YaDRkrnGUbqHleuu0+ECmRlL2YgfMSlFNgyr" +
       "TiOtWQcejJGsVabay8a0JuAyPYcnrZKXTCvuEKdNFLP7tIYkqCIPtu4UnQgd" +
       "wkQ1etrSlTjuBPRwWG+g0zRMUXUZzglUWGS8j8ac0RMVqdFXO7RVC2gsRWFj" +
       "jDpmnwYbBphdGZX6QkNicZDVhHmWWYKyzpolVXTMSYZpvZXdw2atBeqsgCsL" +
       "4phu8FiJJonNch2CLR6NaEMsTCZLJ6yRsjOO0VUgNzhU2yyzTMXVNFBhf8zy" +
       "ttWu2f1wYCTrZUrSLY/g+uLSiubxvN1cYhuMYBbVZNmpgoDJ7vdQuEPFg5no" +
       "NhZs14exkVVtoeMetix5kqq70bJtldoDxKezOEYlduOMnAorjOfCmkxrbiqI" +
       "1JDdUDRMVhQVEysNmuXoeSNbrLkVZkkBZkaq11gzPDKSSKrqLgi4RxtmL6oL" +
       "qGJx1hiZlOR2RSA7zSG88RLFQKtJj9SFflnOOvIQSQVry5bBBn0INvMf/Wi+" +
       "zf+j+zt+eLw4aTlOlVvZaN7wrfs4Ydg17X04L36Xob30qlPHUqc+X0P5d8Sn" +
       "z8uAK74hfumTb7ypjH+pfPHw07kQQVcjz/+wrSaqfWqoPJvolfO/lw6LBMCT" +
       "z9Hf+OR/fWr6MeMT95FI9Owezv0h//7wy7/de7/8sxehB44/Tt+Wmni206tn" +
       "P0lfC9QoDtzpmQ/TT99+4PeRw5X9yP6B34ns7nraV7TdJXXhz/cITqcu/EVe" +
       "/FkEPRCq0R1PqRLPVE7U53v3k9lQVPz3Y36fyivzb6HaIb/affB78UTr78j0" +
       "xROqG8ecX7h6PucXHs6LByPomrqOzcS01d3h7fSY2QuX7iuNI4IePZM+l+cC" +
       "PXlbzu4uz1T+ypvXH3rvm/y/LTLIjnNBr9LQQ1ps26fTGk7dX/YDVTML9q/u" +
       "khz8gpObEfQD5+b0ARHmfzneC4/v6N8dQe+6Ez3QAlCepnwygm7sU0bQpeL/" +
       "NN0PgmU8oYugy7ub0yTPgNEBSX77rH+H099dHkh24aw7OVa8m28ni1Me6MUz" +
       "fqPIrj6y8XiXX/2a/NU3qdGPfrfxS7tUONmWttt8lIdo6MouK+/YTzx/7mhH" +
       "Y10mX/7+Y79+9aUjn/bYDvCJNp/C9uyd8866jh8VmWLbf/Lef/iRX37zD4rD" +
       "6P8DW1lJ+PYuAAA=");
}
