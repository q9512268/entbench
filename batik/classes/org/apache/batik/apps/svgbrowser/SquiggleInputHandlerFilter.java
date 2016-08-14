package org.apache.batik.apps.svgbrowser;
public class SquiggleInputHandlerFilter extends javax.swing.filechooser.FileFilter {
    protected org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler;
    public SquiggleInputHandlerFilter(org.apache.batik.apps.svgbrowser.SquiggleInputHandler handler) {
        super(
          );
        this.
          handler =
          handler;
    }
    public boolean accept(java.io.File f) { return f.isDirectory(
                                                       ) || handler.
                                              accept(
                                                f); }
    public java.lang.String getDescription() { java.lang.StringBuffer sb =
                                                 new java.lang.StringBuffer(
                                                 );
                                               java.lang.String[] extensions =
                                                 handler.
                                                 getHandledExtensions(
                                                   );
                                               int n = extensions !=
                                                 null
                                                 ? extensions.
                                                     length
                                                 : 0;
                                               for (int i = 0; i <
                                                                 n;
                                                    i++) { if (i >
                                                                 0) {
                                                               sb.
                                                                 append(
                                                                   ", ");
                                                           }
                                                           sb.append(
                                                                extensions[i]);
                                               }
                                               if (n > 0) { sb.append(
                                                                 ' ');
                                               }
                                               sb.append(handler.
                                                           getDescription(
                                                             ));
                                               return sb.toString(
                                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfYxUVxW/M/v9/QHLxwLLsiw0LHSm1FKDS7Ew7Jals7Bh" +
                                                              "KdGhZbjz5s7MY9+893jvvt3ZrVjaqKCJiJRSaoC/aKiEFjQ2arQNptG2aTVp" +
                                                              "i9ZqSo2aiFZiibEaUeu5974372NmFzHGSebOm3vPvfecc3/nd85956+hKtNA" +
                                                              "XUSlETqpEzMyoNIRbJgkHVOwae6AvqT0ZAX+8+6rW9eGUXUCNeewOSxhkwzK" +
                                                              "REmbCbRIVk2KVYmYWwlJsxkjBjGJMY6prKkJ1CGbQ3ldkSWZDmtpwgR2YiOO" +
                                                              "2jClhpyyKBmyF6BoURw0iXJNohuCw/1x1Chp+qQrPs8jHvOMMMm8u5dJUWt8" +
                                                              "Lx7HUYvKSjQum7S/YKCVuqZMZhWNRkiBRvYqa2wXbImvKXFBz8WWD28cybVy" +
                                                              "F8zCqqpRbp65nZiaMk7ScdTi9g4oJG/uQ59FFXHU4BGmqDfubBqFTaOwqWOt" +
                                                              "KwXaNxHVysc0bg51VqrWJaYQRUv8i+jYwHl7mRGuM6xQS23b+WSwtrtorbCy" +
                                                              "xMQnVkaPPbm79ZsVqCWBWmR1lKkjgRIUNkmAQ0k+RQxzQzpN0gnUpsJhjxJD" +
                                                              "xoo8ZZ90uylnVUwtOH7HLazT0onB93R9BecIthmWRDWjaF6GA8r+V5VRcBZs" +
                                                              "nePaKiwcZP1gYL0MihkZDLizp1SOyWqaosXBGUUbe+8HAZhakyc0pxW3qlQx" +
                                                              "dKB2AREFq9noKEBPzYJolQYANCjqnHZR5msdS2M4S5IMkQG5ETEEUnXcEWwK" +
                                                              "RR1BMb4SnFJn4JQ853Nt67rDD6ub1TAKgc5pIilM/waY1BWYtJ1kiEEgDsTE" +
                                                              "xr74cTznhUNhhEC4IyAsZL79mev3ruq69IqQWVBGZltqL5FoUjqTan5jYWzF" +
                                                              "2gqmRq2umTI7fJ/lPMpG7JH+gg4MM6e4IhuMOIOXtv/o0wfOkffDqH4IVUua" +
                                                              "YuUBR22SltdlhRj3EZUYmJL0EKojajrGx4dQDTzHZZWI3m2ZjEnoEKpUeFe1" +
                                                              "xv+DizKwBHNRPTzLakZznnVMc/y5oCOEauCLGuG7GIkP/6VIjea0PIliCauy" +
                                                              "qkVHDI3Zb0aBcVLg21w0Bagfi5qaZQAEo5qRjWLAQY7YA1jXzag5nk0Z2gSw" +
                                                              "YXR0nyVnswqwmW7RzVhNg32DsgLoijDc6f/3HQvMB7MmQiE4noVBclAgrjZr" +
                                                              "SpoYSemYtXHg+nPJ1wTwWLDY3qOoH5SICCUiXIkIUyLiKhGZXgkUCvG9ZzNl" +
                                                              "BCzgUMeAHoCfG1eMPrRlz6GeCsCjPlEJJ8JEe3x5KuZyiEP8SelCe9PUkiur" +
                                                              "XwqjyjhqxxK1sMLSzgYjC4Qmjdkx35iCDOYmkm5PImEZ0NAkkgYemy6h2KvU" +
                                                              "auPEYP0Uzfas4KQ5FtDR6ZNMWf3RpRMTj+585I4wCvtzB9uyCmiPTR9hjF9k" +
                                                              "9t4gZ5Rbt+Xg1Q8vHN+vuezhS0ZODi2ZyWzoCaIj6J6k1NeNn0++sL+Xu70O" +
                                                              "2J1iiEYgzq7gHj5y6neIntlSCwZnNCOPFTbk+Lie5gBKbg+HbRt/ng2waGDR" +
                                                              "ugy+PXb48l82Okdn7VwBc4azgBU8kdwzqp/6+U9+/zHubifntHiKhVFC+z08" +
                                                              "xxZr54zW5sJ2h0EIyL17YuTxJ64d3MUxCxJLy23Yy9oY8BscIbj586/se+e9" +
                                                              "K2cuh12cU0j0VgrqpULRSNaP6mcwEnZb7uoDPKkAczDU9D6gAj7ljIxTCmGB" +
                                                              "9Y+WZauf/+PhVoEDBXocGK26+QJu//yN6MBru//axZcJSSxPuz5zxQT5z3JX" +
                                                              "3mAYeJLpUXj0zUVPvYxPQRoB6jblKcLZOGTHOlNqHkVr/it+4Ue+hq9xB2/v" +
                                                              "Yu7iKyM+tpY1y0xv6Pij01ONJaUjlz9o2vnBi9e5rf5yzouUYaz3C3CyZnkB" +
                                                              "lp8bpLbN2MyB3F2Xtj7Yqly6ASsmYEUJ6NzcZgDZFny4sqWran7xg5fm7Hmj" +
                                                              "AoUHUb2i4fQg5iGK6iA2iJkDni7on7xXQGOiFppWbioqMb6kgx3P4vIHP5DX" +
                                                              "KT+qqe/M/da6s6evcIzqYo0FRU5e6ONkfilwaeHcWx//6dmvHp8QZcWK6bkw" +
                                                              "MG/e37cpqcd+/bcSl3MWLFPyBOYnoudPdsbWv8/nu3TEZvcWStMdULo7985z" +
                                                              "+b+Ee6p/GEY1CdQq2UX4TqxYLMgTUHiaTmUOhbpv3F9Eioqpv0i3C4NU6Nk2" +
                                                              "SIRumoVnJs2emwLc18yOcCV8u21a6A5yXwjxh/v5lNt428ea2x2qqdMNjYKW" +
                                                              "JB1gm6YZlqWoJicijf29WxAsaz/BmrhY6Z5ygBRDt7FmZXE//qkOVmBednMR" +
                                                              "h1hYLZquSOYF/pnHjp1Ob3t6tcBcu7/wHIB71bM/++frkRO/erVMPVNHNf12" +
                                                              "hYwTxbNnmG3pQ/kwvz+4kHm3+ehvvtub3XgrRQfr67pJWcH+LwYj+qYPnKAq" +
                                                              "Lz/2h84d63N7bqF+WBxwZ3DJrw+ff/W+5dLRML8sCSyXXLL8k/r9CK43CNwK" +
                                                              "1R0+HC8tAmAWO9j58F1uA2B5+RxeBjvFzDjd1EAWCOSXRk59sgb8oRC+C5kh" +
                                                              "bcis2QP5mTG2Tv0FKTvvUStlQvEo56FWGLdvX3eO7JEO9Y78VsBxfpkJQq7j" +
                                                              "meiXd76993V+cLUMKUV3eVACiPKUQa3CDx/BJwTff7Ev05Z1sF/go5h9leou" +
                                                              "3qUYhc/IxQEDovvb3xs7efVZYUCQeAPC5NCxL30UOXxMxJa4kC8tuRN754hL" +
                                                              "uTCHNSrTbslMu/AZg7+7sP97z+w/GLbP5lNASilNUwhWSw4baj+/24Wum77Y" +
                                                              "8v0j7RWDELVDqNZS5X0WGUr7kVtjWinPObh3eBfHttbM5xSF+pwMybkQz8CF" +
                                                              "/0FyZh0xnfc/WIR8u0PJfTbk+249WqabOgP4PzfD2BdY8whFzVlCNxFTMmS9" +
                                                              "yDkQZa08ylhOjIgXK66DDvwvHFSgqHP6eyYrceaVvPwSL2yk50631M49/cDb" +
                                                              "nLmLL1UaIQIzlqJ4k7DnuVo3SEbmljeKlKzznyNwkbxZwUpRvfuHG/QVMflx" +
                                                              "ijrKTqaokv14ZY+DT4OyFFXxX6/cU7CbK8eIiz94RU5SVAEi7PGU7hxYD38/" +
                                                              "EDEn4Kwi7DWKlNM0Vm0zmhReLYT8Wbl4oh03O1FPIl/qIyH+HtOJUku8yYQL" +
                                                              "/ektWx++fvfT4oYmKXhqiq3SALEpLovFPLZk2tWctao3r7jRfLFumUMabUJh" +
                                                              "N14WeEAdA+rQGXg6A9cXs7d4i3nnzLoXf3yo+k2gu10ohCmatau0ACzoFhQQ" +
                                                              "u+KlHAQ5n9+r+ld8bXL9qsyffslLbFRSWAflk9Llsw+9dXTeGbh/NQyhKuBD" +
                                                              "UuCV6aZJdTuRxo0EapLNgQKoCKvIWPERXDPDOWaByP1iu7Op2Mvu9wCCUtou" +
                                                              "fSsC15EJYmzULDVtU2SD2+N7weqUApauBya4PZ7UVhCsKrJYRTI+rOtOVqto" +
                                                              "1HngTwaJnnfyiRf5I2u+8W8JoWI44xgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
