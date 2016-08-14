package org.apache.batik.anim.timing;
public abstract class EventLikeTimingSpecifier extends org.apache.batik.anim.timing.OffsetTimingSpecifier {
    public EventLikeTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset) { super(owner, isBegin,
                                                          offset);
    }
    public boolean isEventCondition() { return true; }
    public abstract void resolve(org.w3c.dom.events.Event e);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wUxxkfnx8YP/ALA+FhwBgqA7kLJFRNTdLYjg0mZzhh" +
                                                              "goQpHHO7c77Fe7vL7px9NqV5SBUkUhAiBEjV8BdRHk1CVDVqqzYRVaQmUdJK" +
                                                              "SVHTtAqp1EqlD9SgSukftE2/b2b3dm/vfChV1ZNubm/mm2++5+/7Zl+6Tmod" +
                                                              "m3Qxg0f5jMWc6JDBE9R2mDqoU8fZA3NJ5Vw1/fvBazvvjpC6cbIgQ51RhTps" +
                                                              "WGO66oyTFZrhcGoozNnJmIo7EjZzmD1FuWYa46RTc0aylq4pGh81VYYEe6kd" +
                                                              "J22Uc1tL5TgbcRlwsiIOksSEJLH+8HJfnDQppjXjky8JkA8GVpAy65/lcNIa" +
                                                              "P0ynaCzHNT0W1xzel7fJBsvUZyZ0k0dZnkcP61tcE+yIbykxQferLZ/dPJVp" +
                                                              "FSbooIZhcqGes5s5pj7F1Dhp8WeHdJZ1jpBvkuo4aQwQc9IT9w6NwaExONTT" +
                                                              "1qcC6ZuZkcsOmkId7nGqsxQUiJPVxUwsatOsyyYhZAYO9dzVXWwGbVcVtJVa" +
                                                              "lqj41IbYmXMHW79XTVrGSYtmjKE4CgjB4ZBxMCjLppjt9KsqU8dJmwHOHmO2" +
                                                              "RnVt1vV0u6NNGJTnwP2eWXAyZzFbnOnbCvwIutk5hZt2Qb20CCj3X21apxOg" +
                                                              "6yJfV6nhMM6Dgg0aCGanKcSdu6VmUjNUTlaGdxR07HkACGDrvCzjGbNwVI1B" +
                                                              "YYK0yxDRqTERG4PQMyaAtNaEALQ5WTonU7S1RZVJOsGSGJEhuoRcAqr5whC4" +
                                                              "hZPOMJngBF5aGvJSwD/Xd249edTYbkRIFcisMkVH+RthU1do026WZjaDPJAb" +
                                                              "m9bHz9JFr5+IEALEnSFiSfODb9y4b2PX5bclzbIyNLtSh5nCk8rF1IL3lw/2" +
                                                              "3l2NYtRbpqOh84s0F1mWcFf68hYgzKICR1yMeouXd/9s38Mvsr9ESMMIqVNM" +
                                                              "PZeFOGpTzKyl6czexgxmU87UETKfGeqgWB8h8+A5rhlMzu5Kpx3GR0iNLqbq" +
                                                              "TPEfTJQGFmiiBnjWjLTpPVuUZ8Rz3iKEtMKXdMJ3BZEf8ctJJpYxsyxGFWpo" +
                                                              "hhlL2Cbq78QAcVJg20wsBVE/GXPMnA0hGDPtiRiFOMgwdwG2QVJqWYij2NAU" +
                                                              "7Iprk2yP+D9mMUWDaLejGHHW//GsPOrdMV1VBS5ZHgYEHXJpu6mrzE4qZ3ID" +
                                                              "QzdeSb4rgw0TxLUYJ1vg+Kg8PiqOj+LxUXl8dK7jSVWVOHUhiiGDAFw4CWAA" +
                                                              "aNzUO3Zgx6ET3dUQfdZ0DdgfSbuLqtKgjxgezCeVS+3Ns6uvbnozQmripJ0q" +
                                                              "PEd1LDL99gTAlzLpZnhTCuqVXzZWBcoG1jvbVJgKqDVX+XC51JtTzMZ5ThYG" +
                                                              "OHhFDdM3NndJKSs/uXx++pG9D90RIZHiSoFH1gLI4fYE4nsBx3vCCFGOb8vx" +
                                                              "a59dOnvM9LGiqPR4FbNkJ+rQHY6LsHmSyvpV9LXk68d6hNnnA5ZzCrkHMNkV" +
                                                              "PqMIivo8WEdd6kHhtGlnqY5Lno0beMY2p/0ZEbBt4nkhhEUj5uYa+Ha7ySp+" +
                                                              "cXWRheNiGeAYZyEtRNm4Z8x65te/+NOdwtxehWkJtAZjjPcFUA2ZtQv8avPD" +
                                                              "do/NGNB9fD7x5FPXj+8XMQsUa8od2IPjIKAZuBDM/K23j3z0ydWLVyJ+nHMo" +
                                                              "67kUdEf5gpI4TxoqKAmnrfPlAVTUAS0wanoeNCA+Id9oSmeYWP9sWbvptb+e" +
                                                              "bJVxoMOMF0Ybb83An79tgDz87sF/dAk2VQpWZd9mPpmE+g6fc79t0xmUI//I" +
                                                              "Byuefos+A0UDgNrRZpnA3mphg2qh+RJOeisiCwAKU7GzgtQrRgfMwLFcyoFM" +
                                                              "BlKuTbmFb3PikHKiJ/EHWdRuK7NB0nU+H3ti74eH3xNhUY9YgfMoVHMACQBT" +
                                                              "AjHZKt31OXyq4Ptv/KKbcEIWkPZBt4qtKpQxy8qD5L0V+s5iBWLH2j+Z/M61" +
                                                              "l6UC4TIfImYnzjz+efTkGelr2QutKWlHgntkPyTVwaEPpVtd6RSxY/iPl479" +
                                                              "+Pljx6VU7cWVfQga15d/9a/3oud/906Z4jEvZZo6oxLg7sIEKMD9wmL/SKXu" +
                                                              "f6zlJ6faq4cBaUZIfc7QjuTYiBrkCu2ck0sFHOb3WWIiqB46h5Oq9egHnPmK" +
                                                              "qzX+3BN47ueIDiblYTHx77a8YLlFrN1RoCCCgoi1XTisdYJgXezqQLefVE5d" +
                                                              "+bR576dv3BDmKr4uBLFplFrSV204rENfLQ4X0+3UyQDdXZd3fr1Vv3wTOI4D" +
                                                              "RwWaBmeXDYU9X4RkLnXtvN/89M1Fh96vJpFh0gBqq8NUFAUyH9CYORnoCfLW" +
                                                              "1+6TYDRd7zVNeVKifMkEAsLK8lAzlLW4AIfZHy7+/tbnLlwVqOh6ZlmQ4ZfE" +
                                                              "uB6H28V8BB+jnNRTyGEbhPXBU3xawu1cEDyL2NtkxVwdt4j1i4+euaDuenZT" +
                                                              "xPXsAAejmNbtOptieoBVBDkV9Suj4o7h18yPF5z+/Y96Jga+SKuCc123aEbw" +
                                                              "/0rw6/q5USUsyluP/nnpnnszh75A17EyZKUwyxdGX3pn2zrldERcqGTDUXIR" +
                                                              "K97UV5zFDTaDm6NRnLdrCn7t8Cr/BtevG8pXfhEvOGworadzba2QydkKa+JC" +
                                                              "keGkVXNE1wv9lFpoG74qtiRw0GR0jv2XGYQT+ywxrxZ0EqHeC9/Nrk6bK5ij" +
                                                              "fPrgcCDUdXRU4BiyhAfcbu1egrV7+k4lqprZKENzOPIuIAQ5WsGMD+GQg9Jg" +
                                                              "y9cD5dC4ZsrUVN+iU/8Li+ZB6LluKwhbS0pemMhLvvLKhZb6xRce/FBkcuEi" +
                                                              "3gQ5mc7peiCkg+FdZ9ksrQmFmySKW+LncU6WV2p7oD+UD0KNx+SmJzjpLLsJ" +
                                                              "LIU/QdpTEKBhWihv4jdI9yQnDT4dHCsfgiRnOakGEnw8Z3mO31yxaZOX85B1" +
                                                              "81WlGC/82nkrvwZwe00R3ol3YB425eRbMLgeXtix8+iNLz8r+31Fp7OzyKUR" +
                                                              "egZ59Sjg2+o5uXm86rb33lzw6vy1XiVokwL7abYsENP7IDMsDKKloWbY6Sn0" +
                                                              "xB9d3PrGz0/UfQBFej+popx07A+8gZKvW6CjzkFh2R8v7Y2gFoguva/32zP3" +
                                                              "bkz/7beifBLZSy2fmz6pXHnuwC9PL7kI3XzjCKmFIsfy46RBc+6fMXYzZcoe" +
                                                              "J82AaHkQEbhoVC9qvBZgvFN8Oybs4pqzuTCLt0VOukv7ztI7NrQa08weMHOG" +
                                                              "6rZujf5M0cs5r0TkLCu0wZ8J9ObDEjzQGxCxyfioZXltORmwRPpvK9/Z4fii" +
                                                              "eMThu/8BwpMZyR8XAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0av/4PW//dzX86rg/wKl2gyx8CEAAA==");
}
