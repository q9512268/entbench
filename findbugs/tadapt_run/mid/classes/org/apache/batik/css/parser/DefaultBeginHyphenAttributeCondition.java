package org.apache.batik.css.parser;
public class DefaultBeginHyphenAttributeCondition extends org.apache.batik.css.parser.DefaultAttributeCondition {
    public DefaultBeginHyphenAttributeCondition(java.lang.String localName,
                                                java.lang.String namespaceURI,
                                                boolean specified,
                                                java.lang.String value) {
        super(
          localName,
          namespaceURI,
          specified,
          value);
    }
    public short getConditionType() { return SAC_BEGIN_HYPHEN_ATTRIBUTE_CONDITION;
    }
    public java.lang.String toString() { return "[" + getLocalName(
                                                        ) + "|=\"" +
                                         getValue(
                                           ) +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1YfWwUxxWfO38fBn8AhhowYAwSJNwWBYpa0xZj7PjIGU42" +
                                                              "QapJc8ztzt0t7O2ud2fts1OHOGoLohKKAklpFfwXUdqIhKhq1KpVEFWrJlGa" +
                                                              "ImjU5kNNWvWPpB9I4Z/Qirbpm5m93b29swP/9aSdm5t58+Z9/t7bu3gD1dkW" +
                                                              "6jaxruA4nTKJHU+xeQpbNlH6NWzbB2E1LZ/685njt37XNBtF9WNoSR7bwzK2" +
                                                              "yaBKNMUeQ2tU3aZYl4m9nxCFnUhZxCbWBKaqoY+h5aqdKJiaKqt02FAIIziE" +
                                                              "rSRqw5RaasahJOEyoGhtkksjcWmkvjBBbxI1y4Y55R/oLDvQH9hjtAX/Ppui" +
                                                              "1uRRPIElh6qalFRt2lu00D2moU3lNIPGSZHGj2o7XEPsS+6oMEP3Sy2f3H4i" +
                                                              "38rNsBTrukG5ivYIsQ1tgihJ1OKvDmikYI+jR1FNEi0KEFPUkyxdKsGlElxa" +
                                                              "0tenAukXE90p9BtcHVriVG/KTCCK1pczMbGFCy6bFJcZODRSV3d+GLRd52lb" +
                                                              "cndIxafukc5+9+HWH9WgljHUouqjTBwZhKBwyRgYlBQyxLL7FIUoY6hNB4eP" +
                                                              "EkvFmjrtervdVnM6pg6EQMksbNExicXv9G0FngTdLEemhuWpl+VB5f6qy2o4" +
                                                              "B7p2+LoKDQfZOigYU0EwK4sh9twjtcdUXeFxVH7C07HnASCAow0FQvOGd1Wt" +
                                                              "jmEBtYsQ0bCek0Yh+PQckNYZEIIWj7V5mDJbm1g+hnMkTdHKMF1KbAFVEzcE" +
                                                              "O0LR8jAZ5wRe6gx5KeCfG/t3nX5EH9KjKAIyK0TWmPyL4FBX6NAIyRKLQB6I" +
                                                              "g81bkk/jjldORhEC4uUhYkHzk2/c3H1v15XXBM2qKjQHMkeJTNPyhcySa6v7" +
                                                              "N3+xhonRaBq2ypxfpjnPspS701s0AWk6PI5sM17avDLy66899jz5exTFEqhe" +
                                                              "NjSnAHHUJhsFU9WIdT/RiYUpURKoiehKP99PoAaYJ1WdiNUD2axNaALVanyp" +
                                                              "3uC/wURZYMFMFIO5qmeN0tzENM/nRRMh1AAPaoZnNRIf/k3RrJQ3CkTCMtZV" +
                                                              "3ZBSlsH0Zw7lmENsmCuwaxpSBuL/2NZt8Z2SbTgWBKRkWDkJQ1TkidiUZNtm" +
                                                              "eQrQKO0lWexodA/JqfrQlJknuod1kGwKt0uchaL5/yBEkVlq6WQkAk5cHYYQ" +
                                                              "DbJvyNAUYqXls86egZsvpt8Q4clSyrUxRbtBkriQJM4liYMkcSFJ/E4kQZEI" +
                                                              "F2AZk0hEEPj/GCAJQHnz5tGv7ztysrsGQtecrAXnMdJNFaWt34ecUp1Iyxev" +
                                                              "jdy6+mbs+SiKAiploLT59aWnrL6I8mgZMlEA4OarNCW0leavLVXlQFfOTc4e" +
                                                              "Ov55LkewZDCGdYB27HiKAb13RU8YKqrxbTnx0SeXnp4xfNAoq0Gl0llxkmFR" +
                                                              "d9jdYeXT8pZ1+OX0KzM9UVQLAAegTjEkIeBlV/iOMkzqLeE706URFM4aVgFr" +
                                                              "bKsEyjGat4xJf4XHYRufLwMXL2JJKsHT7WYt/2a7HSYbV4i4ZTET0oLXjy+P" +
                                                              "muff/u1f7+PmLpWalkCPMEpobwDeGLN2DmRtfggetAgBuj+eS5156saJwzz+" +
                                                              "gGJDtQt72NgPsAYuBDN/67Xxdz54/8JbUT9mKdR3JwOtUtFTkq2j2AJKsjj3" +
                                                              "5QF41AAdWNT0PKhDVKpZFWc0wpLk3y0bt738j9OtIg40WCmF0b2fzcBf/9we" +
                                                              "9NgbD9/q4mwiMivPvs18MoH5S33OfZaFp5gcxdnra773Kj4P1QMQ21anCQfh" +
                                                              "Wm6DWq75SujW+ElWieOiErP1HTaL+UBWs45y1MnYNGWpBXDThFvvLnXcGv9V" +
                                                              "w/TeUi2rdkRQPmAPX/3Z0IdpHgaNLPvZOrtscSCv+6xcIAZbhXs+hU8Env+y" +
                                                              "h7mFLYjK0d7vlq91Xv0yzSJIv3mBhrNcBWmm/YNjz3z0glAhXN9DxOTk2VOf" +
                                                              "xk+fFb4VTdCGij4keEY0QkIdNnyJSbd+oVv4icEPL838/AczJ4RU7eUlfQA6" +
                                                              "1hd+/5/fxM/96fUqNaAhYxgawQLQ7mMB70F1R9hDQq36bef/dfzbbx8AbEmg" +
                                                              "RkdXxx2SUIJ8oZOznUzAZX6LxReCCjL3UBTZAp7gwcTH7VwayZMJcZkQ30uw" +
                                                              "occO4my51wIde1p+4q2PFx/6+PJNrnl5yx+ElWFsCrO3sWEjM/uKcE0bwnYe" +
                                                              "6LZf2f9Qq3blNnAcA44yVHT7gAWltlgGQi51XcO7v/hlx5FrNSg6iGKagZVB" +
                                                              "zPEcNQGQEjsPVbpofnW3wJHJRhhauaqoQnmWumurg8JAwaQ8jad/uuLHu56b" +
                                                              "e5/jlwCsVe5x/mMTG7Z4QMY/9eEeKwhkZRwstGa+NpjH4YXHz84pB57dFnVd" +
                                                              "1UdBS8PcqpEJogVYRXlUh/uAYd78+zVs5/VbNe89ubK5sgVgnLrmKfBb5s/l" +
                                                              "8AWvPv63zoNfyR+5i9q+NqR/mOUPhy++fv8m+ckof38RZb3ivaf8UG955sQs" +
                                                              "Ai9qenmudHsea2OeWA/PVtdjW6vX1yrO9qrWfEcXSDplgb0sG+AVqzVHqNcZ" +
                                                              "eg3CThfH2NeuwHw3RXUQ/RYNAw/7OSho9rHhiJgP31mOsIURvnzYU7ydbXXC" +
                                                              "s91VfPvd22y+owvYxVlgb5INgL6N1AgWUk/p8btXuggN5J307AxGVlb85yDe" +
                                                              "k+UX51oaV8w9+AfeN3rvss1QhLOOpgXCNBiy9aZFsirXq1mAqMDyRylatcAb" +
                                                              "Bmus+IQrNCPOzFK0rNoZimpgDFJ+EyIuTAkxxb+DdCcoivl0cKmYBElOAXcg" +
                                                              "YdPvmKVeZ8cdvBxVWrcYqQRd7tHln+XRAMpuKMMw/jdSCW8c8UcSNFNz+/Y/" +
                                                              "cvMLz4pOWdbw9DTjsghqr2jaPcxaPy+3Eq/6oc23l7zUtLGE221CYD8rVgVC" +
                                                              "dwRy1GRB1BlqI+0er5t858Kuy2+erL8ONfIwimCKlh4O/Ikj/rGAXtQBQD2c" +
                                                              "rNZlAKLzDrc39pcjV//5bqSdFzQk+pKuhU6k5TOX30tlTfP7UdSUQHVQlkhx" +
                                                              "DMVUe++UPkLkCausaanPGI7u/eO0hEU8ZvnILeMadLG3yt60KOqu7OEq3z6h" +
                                                              "1k8Saw/j7jZBZSjvmGZwl1t2QMAjszQEZDo5bJpu81rzELe8afJUn+MQ+T9G" +
                                                              "I+FSKxYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
