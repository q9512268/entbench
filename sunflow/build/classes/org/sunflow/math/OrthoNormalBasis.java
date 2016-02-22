package org.sunflow.math;
public final class OrthoNormalBasis {
    private org.sunflow.math.Vector3 u;
    private org.sunflow.math.Vector3 v;
    private org.sunflow.math.Vector3 w;
    private OrthoNormalBasis() { super();
                                 u = new org.sunflow.math.Vector3();
                                 v = new org.sunflow.math.Vector3();
                                 w = new org.sunflow.math.Vector3(); }
    public void flipU() { u.negate(); }
    public void flipV() { v.negate(); }
    public void flipW() { w.negate(); }
    public void swapUV() { org.sunflow.math.Vector3 t = u;
                           u = v;
                           v = t; }
    public void swapVW() { org.sunflow.math.Vector3 t = v;
                           v = w;
                           w = t; }
    public void swapWU() { org.sunflow.math.Vector3 t = w;
                           w = u;
                           u = t; }
    public org.sunflow.math.Vector3 transform(org.sunflow.math.Vector3 a,
                                              org.sunflow.math.Vector3 dest) {
        dest.
          x =
          a.
            x *
            u.
              x +
            a.
              y *
            v.
              x +
            a.
              z *
            w.
              x;
        dest.
          y =
          a.
            x *
            u.
              y +
            a.
              y *
            v.
              y +
            a.
              z *
            w.
              y;
        dest.
          z =
          a.
            x *
            u.
              z +
            a.
              y *
            v.
              z +
            a.
              z *
            w.
              z;
        return dest;
    }
    public org.sunflow.math.Vector3 transform(org.sunflow.math.Vector3 a) {
        float x =
          a.
            x *
          u.
            x +
          a.
            y *
          v.
            x +
          a.
            z *
          w.
            x;
        float y =
          a.
            x *
          u.
            y +
          a.
            y *
          v.
            y +
          a.
            z *
          w.
            y;
        float z =
          a.
            x *
          u.
            z +
          a.
            y *
          v.
            z +
          a.
            z *
          w.
            z;
        return a.
          set(
            x,
            y,
            z);
    }
    public org.sunflow.math.Vector3 untransform(org.sunflow.math.Vector3 a,
                                                org.sunflow.math.Vector3 dest) {
        dest.
          x =
          org.sunflow.math.Vector3.
            dot(
              a,
              u);
        dest.
          y =
          org.sunflow.math.Vector3.
            dot(
              a,
              v);
        dest.
          z =
          org.sunflow.math.Vector3.
            dot(
              a,
              w);
        return dest;
    }
    public org.sunflow.math.Vector3 untransform(org.sunflow.math.Vector3 a) {
        float x =
          org.sunflow.math.Vector3.
          dot(
            a,
            u);
        float y =
          org.sunflow.math.Vector3.
          dot(
            a,
            v);
        float z =
          org.sunflow.math.Vector3.
          dot(
            a,
            w);
        return a.
          set(
            x,
            y,
            z);
    }
    public float untransformX(org.sunflow.math.Vector3 a) { return org.sunflow.math.Vector3.
                                                              dot(
                                                                a,
                                                                u);
    }
    public float untransformY(org.sunflow.math.Vector3 a) { return org.sunflow.math.Vector3.
                                                              dot(
                                                                a,
                                                                v);
    }
    public float untransformZ(org.sunflow.math.Vector3 a) {
        return org.sunflow.math.Vector3.
          dot(
            a,
            w);
    }
    public static final org.sunflow.math.OrthoNormalBasis makeFromW(org.sunflow.math.Vector3 w) {
        org.sunflow.math.OrthoNormalBasis onb =
          new org.sunflow.math.OrthoNormalBasis(
          );
        w.
          normalize(
            onb.
              w);
        if (java.lang.Math.
              abs(
                onb.
                  w.
                  x) <
              java.lang.Math.
              abs(
                onb.
                  w.
                  y) &&
              java.lang.Math.
              abs(
                onb.
                  w.
                  x) <
              java.lang.Math.
              abs(
                onb.
                  w.
                  z)) {
            onb.
              v.
              x =
              0;
            onb.
              v.
              y =
              onb.
                w.
                z;
            onb.
              v.
              z =
              -onb.
                 w.
                 y;
        }
        else
            if (java.lang.Math.
                  abs(
                    onb.
                      w.
                      y) <
                  java.lang.Math.
                  abs(
                    onb.
                      w.
                      z)) {
                onb.
                  v.
                  x =
                  onb.
                    w.
                    z;
                onb.
                  v.
                  y =
                  0;
                onb.
                  v.
                  z =
                  -onb.
                     w.
                     x;
            }
            else {
                onb.
                  v.
                  x =
                  onb.
                    w.
                    y;
                onb.
                  v.
                  y =
                  -onb.
                     w.
                     x;
                onb.
                  v.
                  z =
                  0;
            }
        org.sunflow.math.Vector3.
          cross(
            onb.
              v.
              normalize(
                ),
            onb.
              w,
            onb.
              u);
        return onb;
    }
    public static final org.sunflow.math.OrthoNormalBasis makeFromWV(org.sunflow.math.Vector3 w,
                                                                     org.sunflow.math.Vector3 v) {
        org.sunflow.math.OrthoNormalBasis onb =
          new org.sunflow.math.OrthoNormalBasis(
          );
        w.
          normalize(
            onb.
              w);
        org.sunflow.math.Vector3.
          cross(
            v,
            onb.
              w,
            onb.
              u).
          normalize(
            );
        org.sunflow.math.Vector3.
          cross(
            onb.
              w,
            onb.
              u,
            onb.
              v);
        return onb;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaDWwcxRWeOzu24zjx2fklP05wDNQm+AiBAjUlcUxMHC62" +
       "ZScOOG0u4705e+O93c3unH0OTQupqoRKpSmEQCuIVDUIiIBEVSmtKCgVbYFC" +
       "q0KhQCtCRZFKoQiiqoAKhb43u3u7t+ddc1LvpJ2bm3lvZt43729m78F3ySzT" +
       "IE1M5e18Smdm+yaV91PDZKkuhZrmNmhLSndW0H/teqv3yiipGibzxqi5VaIm" +
       "65aZkjKHyQpZNTlVJWb2MpZCjn6DmcyYoFzW1GGyUDZ7MroiSzLfqqUYEgxR" +
       "I0EaKOeGPJLlrMcegJMVCVhJXKwk3unv7kiQOknTp1zyJR7yLk8PUmbcuUxO" +
       "Yok9dILGs1xW4gnZ5B05g1yoa8rUqKLxdpbj7XuUy2wItiQuK4Kg+VT9Bx8f" +
       "HosJCOZTVdW4EM8cYKamTLBUgtS7rZsUljH3kq+TigSZ4yHmpCXhTBqHSeMw" +
       "qSOtSwWrn8vUbKZLE+JwZ6QqXcIFcXJu4SA6NWjGHqZfrBlGqOG27IIZpF2V" +
       "l9aSskjEOy6MH7lzV+zHFaR+mNTL6iAuR4JFcJhkGABlmRFmmJ2pFEsNkwYV" +
       "NnuQGTJV5H32Tjea8qhKeRa234EFG7M6M8ScLlawjyCbkZW4ZuTFSwuFsn/N" +
       "Sit0FGRd5MpqSdiN7SBgrQwLM9IU9M5mqRyX1RQnK/0ceRlbrgMCYK3OMD6m" +
       "5aeqVCk0kEZLRRSqjsYHQfXUUSCdpYECGpwsDRwUsdapNE5HWRI10kfXb3UB" +
       "1WwBBLJwstBPJkaCXVrq2yXP/rzbe9WtN6qb1SiJwJpTTFJw/XOAqcnHNMDS" +
       "zGBgBxZjXVviKF30+KEoIUC80Eds0Tz6tbMb1jSdftqiWTYNTd/IHibxpHR8" +
       "ZN7zy7tar6zAZdTominj5hdILqys3+7pyOngYRblR8TOdqfz9MBvbrjpBHsn" +
       "Smp7SJWkKdkM6FGDpGV0WWHGtUxlBuUs1UNmMzXVJfp7SDXUE7LKrNa+dNpk" +
       "vIdUKqKpShO/AaI0DIEQ1UJdVtOaU9cpHxP1nE4ImQsPaYSnglgf8c3JQHxM" +
       "y7A4lagqq1q839BQfjMOHmcEsB2Lm1k1rWiTcdOQ4poxmv+dgeHjfQZoWK9m" +
       "ZKiykZqy2Y66pZdl1BzKMn8yEgGYl/uNXAH72KwpKWYkpSPZjZvOPpx81lIg" +
       "VHobBfAoMFW7PVU7TtXun4pEImKGBTiltYmwBeNgzOBN61oHv7pl96FmgC6n" +
       "T1YCfkjaXBBVulyLd9x0UjrZOHffuWfWPhkllQnSSCWepQoGiU5jFNyPNG5b" +
       "aN0IxBvX7a/yuH2MV4YmsRR4nSD3b49So00wA9s5WeAZwQlKaH7x4JAw7frJ" +
       "6bsmbx76xsVREi309DjlLHBSyN6P/jnvh1v8Fj7duPUH3/rg5NH9mmvrBaHD" +
       "iXhFnChDs18H/PAkpbZV9JHk4/tbBOyzwRdzCrYDbq7JP0eBK+lw3DLKUgMC" +
       "p4V+YJeDcS0fM7RJt0UoZ4OoLwC1qEPbWg5PlW1s4ht7F+lYLraUGfXMJ4Vw" +
       "+18e1O955ff/WCfgdiJEvSe0DzLe4fFKOFij8D8NrtpuMxgDutfu6r/9jncP" +
       "7hQ6CxSrp5uwBcsu8EawhQDzt57e++rrZ46/GHX1nJNq3ZAh12G5vJTYQeaE" +
       "SAnTne8uCNyaAk4A1aZluwoKKqdlOqIwtKxP6s9b+8g/b41ZiqBAi6NHa2Ye" +
       "wG0/ZyO56dldHzaJYSIShlUXNJfM8tXz3ZE7DYNO4TpyN7+w4vtP0XvA64On" +
       "NeV9TDhPIkAgYtcuE/JfLMpLfX2XY3Ge6dX+QgPzpD9J6fCL788dev+Js2K1" +
       "hfmTd7O3Ur3D0i8szs/B8Iv93mkzNceA7tLTvV+JKac/hhGHYUQJkgazzwCv" +
       "mCtQDZt6VvWff/nkot3PV5BoN6lVNJrqpsLKyGxQb2aOgUPN6es3WJs7WQNF" +
       "TIhKioQvakCAV06/dZsyOhdg7/vZ4p9cdd+xM0LNdGuMZYK/An18gVsVWbhr" +
       "2Sf+ePlL933v6KQVx1uD3ZmPb8l/+pSRA298VAS5cGTT5Bg+/uH4g3cv7br6" +
       "HcHvehTkbskVxyXwyi7vJScy/442V/06SqqHSUyys94hqmTRToch0zOdVBgy" +
       "44L+wqzNSlE68h5zud+beab1+zI3HkIdqbE+N8h9VdqGXel3XxEiKj2C5QIs" +
       "Lix2C0HcnESygnoJpFNFEXmIoQ6usxwklldgscVSj45AbewqffUDWFwHq5nA" +
       "Sq9vxsEyzLjDmXFyuhmvD5nR6rpAlG1YXCQMJcrhuJQdgVMnh32WVaq47ll8" +
       "6ogv4/O6Z9fgCHqVFUFJuThQHD9w5Fiq7961lsk1Fia6m+Ac99Cf/vtc+11/" +
       "fWaavGs21/SLFDbBFM+c9ThlgZFvFecV12Jem3fb337eMrqxlLQJ25pmSIzw" +
       "90oQoi3Yb/iX8tSBt5duu3psdwkZ0EofnP4hH9j64DPXni/dFhWHM8uUiw51" +
       "hUwdhQZcazA4harbCsx4dV4B0AbJYkc/ne/iLGRazYpgdZcv2NeGDBYSFveG" +
       "9InGcdReRda3m6HOvN+QM5DwTNgHvvj+xtfH737rIUsj/Z7bR8wOHfn2Z+23" +
       "HrG00zpCry46xXp5rGO0WGTMguEz+ETg+RQflAAb8Bv8c5d9lluVP8xhSDPI" +
       "uWHLElN0//3k/sfu338waiMCplw5ockp1zEoM7mi8FCMDZ26aB8tVo6YvZ+x" +
       "EOXAQi1WhSDWkO0+GNJ3CxYHbFUYwh85F4NvlhMDx10uKB2DINYQOY+E9B3F" +
       "4rs2Bjt8GBwuFwZL7Mepl4hBEGuInD8M6fsRFndDZDMnqb7drwj3lBOEJluS" +
       "ptJBCGINEfThkL5TWDxggzDk14QT5QShxZakpXQQglhDBH0spO9xLH5qg7Bj" +
       "uw+ER8sAwnzsw1SuzZakrXQQglh9gkatDA5/ikywVwz9dAgcv8XiSUynDKqa" +
       "eCsh+FxEflVORNbaYq0tHZEgVp+sETfzsMB4KQSMl7H4QwgYz5cLDLTwK2yJ" +
       "rigdjCDWz6Ueb4Qg8iYWr3EyJ6sGYXKmnJistwVbXzomQawzKch7IXCcxeLt" +
       "UDjeKQMcDdi3Ap5uW6bu0uEIYp0Jjk9C4PgUiw85qfPAcX3h9TWerQazIyb3" +
       "5c6X9O+WDrX0v2kl2udMw2DRLbw//p2hl/c8Jw5JNXgqyx9NPCcyOL2JBVqX" +
       "pjEspixws576jSIH0ij3S4uXpoUrsCa/5pb6XxxurOiGw2IPqcmq8t4s60kV" +
       "HpiqzeyIZ0nuqyrR4F0PZvZwTm9z7qWEunxUTnXZYu/5ltLVJYh1BnWJzA9W" +
       "l8hCLOYVqssN2BbN4xGpLycevbZQvaXjEcQ6Ex6rQvBoxmJZIR7DPjyWlwGP" +
       "Vuy7BJ4BW6iBEDxE6TnEV2B1F+ZP4iU3/kr6jvSLQ4aeCa94CF5rsfgChOcM" +
       "HWfdhpbZIciWfJ6XcC6ireVCdB08aVvsdMmI4tLWBKEZNOznie+R9SGQdmJx" +
       "JSe1eUjxbBRZ58L1pf8HXDlOYv4dwev8JUX/rLD+DSA9fKy+ZvGx7S+La7r8" +
       "G/s6CAHprKJ4L5w99SrdYGlZQF1nXT/rQsgemN2vIJxU4hcuOLLZIktAXPeQ" +
       "cXTtouYl6uOkAoiw2q876hcTbyXwIr3dukjPRUTXMi8swt0vnAlNz93p6oJb" +
       "K/FXFSdCZa0/qySlk8e29N549ov3Wq/1JIXu24ejzIG4ZL1htMOi99LIP5oz" +
       "VtXm1o/nnZp9nnNp1GAt2NXcZZ7Q3wlWq+MWLvW98jJb8m++Xj1+1RO/O1T1" +
       "QpREdpII5WT+zuJXDjk9a5AVOxPF8XeIGuJdXEfrD6auXpN+7y/ipQ6x4vXy" +
       "YPqkNHz7Kz2nxj/cIP4bMUtWUywn3oVcM6UOMGnCKAjm81C7KP5pReBgwzc3" +
       "34ovgTlpLr7XK351XgvKwoyNWlZN7bXSgTlui7UTvtvWrK77GNwWN6OJVO8V" +
       "GQSiD/qXTGzVdeee8AUdbSxSM41LjdQIZklUsUj9D2CiFES1JgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cgCViQ+VVd5f0psF+b69/xbJv3Lkun8Ofgfg+X/FU8gpMvZT6+Pto/n9fScT" +
       "vA8moYOkrPlusJa4bToS9MJm6vuAVtBaQT68b6txV+v5gTePjb4UW0HbQNW0" +
       "SPQuqDN8G9Th/kLqZHdSZ/qG6pTV8wMQd++v3cJvVYt38c4N3heD/Uei2BaI" +
       "d1ejcmsAahmWK9vHWjy5ttWbx0MrgK0CcLCbaxs/HtUbZWwoTPnWfn19Qd/2" +
       "X1hf4PuPngpjPLBU/8n/8unf/ukPfAM4KA3dnxbOA/zyTItsUuxefvyLn3nm" +
       "4Vf+6CfLOQf0In//639QrgW1u6Aukh8pyA8V5KPHUJ8uoPJeEqo6I0fxqJwl" +
       "dK1Ee2lcmoSWA2bT9GhpDr/8+Dc2P/vNX94vuy8GoQvM+idf+Yk/v/WpVw7P" +
       "bHY+cNt+42yd/YanVPodRz0cQu+/rJWyRu+/ffnlX/2Flz+x1+rx80v3LtiZ" +
       "/vK//7PfvvW5P/qtO6wkr9jeWxjY+Po3KTQatI5/jCB3FpmaTxf6eJfU0N06" +
       "rxkbe1JtZB2Wcyoti2yt57Y6z0dUG6tJvDoe96sJilcbemXcrKv1xKWq4xmX" +
       "+IE3Hfq80+XayUDozAfWgOwKvBMP2ytBWfbaQXVocu24PZV6Q4+zrMBrDU0F" +
       "rSf1BI8rmqYiTOrTNcWp26kUo3W81nRwolff8rvZoIuMGjpC8I7mVLay0EQm" +
       "HWm4SUwpdFjHZHhXW1QpONaDtL61LL9vKbs8sBqCPHCwhixt1kNqy/kSO7MF" +
       "eqHURr7UXrtYx1G3S6+3WyD9/nbekfBR6Fn8jjGCYL7srvLpoNqVh2O9P6EZ" +
       "Oxyp+ooeCW3BpMVhtgHIU3xjceONO/OR3Zae4ltmQ0zmjqIm83y89DZNbcD0" +
       "IyRfoCtXapDVxgrZejIRzoMhk2u+ssbFZL6tZYPY4pIhOlxVhFmTzAmD8iK6" +
       "PZZmgrZAuyNCXQ5lZ8aQ81XM46EUze01Vd8ElZm14iV0Szl+WzRnZEDx+igL" +
       "+HHMZ4vQJdK5MpSYboXOJIwLRHXQU0U6QfkWxi7WfSqQjJC0+8G4X8MHA8nv" +
       "1QS7KfPRZt0db7ERhds7obKjevK04rAzBrNayRSleyptbvot0namPceha36v" +
       "G7GbbCmwbsL1Z7TQoOq12VqXicAc6lO5Vke7vT4+wkYErzK2nK23bWUjLVAp" +
       "mfX4LOlFLszyVlzt9adaY+QHvGaxOE+uQi5jRs3BvDlqOMF0KyJTzh3CVVWf" +
       "2kq4GrWXw/p41MGchqwHQntT3XQlZjrlg3W0pDhDnM/5tuYvu+2+n0WdaTaP" +
       "NNlnuw1qMR0g1Y0hKvU5iSwykmToLIrJCb2R26IQBrWtOIHDnaI3FzGLBQrC" +
       "W3RG+7NZj85gcdwKVJdiRx1+1ydXZC6tRSG1hr16tTLseoN5m6h2tag622Gx" +
       "MlKQNa8ZcWAtZkt2psEDylJyn5oSEovvtngsh9iuJWkzz7HcdcME1hJso3oF" +
       "97djd7WcKvaUmI21wNg1R2SqhGufpCKXd3ycpxebobYZYb1+x+8L1cWC6sfz" +
       "3CaTeYTMWWe0EwXaAHwdcd7FmWHIyhWN9TfpQJsPA+Cm5hhuyYNqZ9DlkDmt" +
       "CfFYnjdVn8oniNtFBw4XTeQl767slUGodZqj8tEWb6FgwRMESEDUmyRnrEdj" +
       "ylG7EVljHGSDhAtrpmpjDvW93Ekr2kqn1gYneYth05GG1nYjBdvaEsN8SbMR" +
       "cjccucS2u+ovbThhxRaF14aZP1wsNz4/kdZSOp74OYHYg5VAeQpptLxRb4FP" +
       "hDk+i8XERf3uwBn2yZllx0snI3V2tRuTLIZ4VIr7dhPrOas25s6QZdvYrGWR" +
       "JIXE3jJaM6/O16E0pgwjWRiLibmxbc7l+fZC9zmvb80b6x67nbD9hiKz1UFO" +
       "piIuw9uEqo0EdOlE0ynq8p26gjZ5r1rNWs2osdBbUsbZQ5nCc5RuZbgR0pgS" +
       "OUqOY3kkTLtWvdrsrG2GIvkti03gtZuaSEr01riWTOZUHQ5XDZZqOk4akjLV" +
       "sUSz57bNToQQFDxpbXxFEpo0tUHhWCHH21021XbtcNlRApyeVHVyWLGzeocZ" +
       "zoFP+KhQWdJ6R+Wrxgif0nF17kno2GOyNhJ0J8pi1ZjYCyRCzRjvVewlE8rz" +
       "viGOaFTIKgihI+Nmo2EY8KJtrDSL7qa8Xu3sGB01esNxz1oTHYINYz8Z5atO" +
       "EhsJFsLNtatOcJPD2jkf+o0kI9UoIbpyZnKdXdzA9UolDCUUg/uUiLg0G9Sl" +
       "lonU+o2Uni05Xe7yLXfm6kTSZrdya4O2EFmyk8wbDgPNHgeDLB7mEyxqKhVi" +
       "BSsoIlkB2bIwlpJrSz3rV2FpO25gmq1RO5le8gPetOciSxsjIhZ3damLd5bs" +
       "GJ35WxavZGgaT6pi2sLQscvqQnPWMSeDTWu1jNWkC9MGM/IZQ6yJy3pfxzSx" +
       "wq0mO7/TpDGjzeAEoelphY5qQ8Q0nJmGj+vzsN6pWkS0i2CSGKTNurPZsare" +
       "wmNmlgoVeiirsGn2qeWcozcrebfL2qnTjrmOFGNCugA97W68uD4RGqTHYrbA" +
       "0mHgR8xw2885pSaPV/MJi+lRfUFH+IJje7OBObQ8LpU37ZZQxWBNirZjU1vh" +
       "cCqhflPVtEo+qjKs1k9G0nIIt1yEWAmRsFDMsMYbFX1iM816PcWGnJAjSacu" +
       "OROFsOGKz09btSYhtPiG2p/NGuSqAicUuqqrKa6EGKVSqW7ONkq0EfKtmG0t" +
       "PKV5dQujaE2AqxgfgLlnvt1GTdQMnNl05qlmdTfWBHK1RVGmkgU7lre7GGE2" +
       "dolWUXRZQSq7QZ3aDLRA6VZYwmwKWtAXdbsu5l1ruK61G9wgYqy81q5Sqtvl" +
       "tyvXo/0e2+uKzsDjsCTKM+C82ipSBX6NNlqKngWGMe8sehkVNNwWHzTTPOpu" +
       "d8y644i9bWI6aafhTrHQb9l9ZCm2uRGthmZCc9pKGLlmvbYQ5ADFbZvAvFWK" +
       "wmNMahqrNhUIvXmPTmYmR3WaGdj6BngTQ+xog/QsGQOLJLXZbBtwGqsVBIGN" +
       "hSyn/aiGwDzT6yhkb1RRmzPTXkm9tKerAlKjdaduKPU6ro/CILcZjq41fIcf" +
       "7LJm1eM8q75UYEskYp6MG1qS1P1IyzZStesZ7gQ1qeYaQzsT0bVgrWcuqBGR" +
       "zK2sgZjzTDM5SZV3LdSUQ6Ud5agmoGS1pdDLjQq7Omwx/am8W/orTVLTGqv3" +
       "O+SS76V6vzlw+6o21aeaXHcwapyyFW7U6GQzdkWl6bqSxwaF1/FwMI/WsIQr" +
       "UyIDIdStSZVanQr71erOb4dbFMtFvxH2x9VFfzZaJd1dpTtbVaacYbdaCkGm" +
       "hNrQmradCBMiN/nOZJAsKKZrs1UYrm/gyEjqdSKTLRDH7KzhqRuwrOp6I9yx" +
       "iF571JFqmEwSseBhy1Sq5N2x2OIsZAEELTbjaqXP0vV2vqSU3nyZmUSjh7Kp" +
       "bY46OVJNhmStM2CX3HhZ6TbJeg8Noxq5jok+CRYgmcTgI923UZPs9pOB2yFG" +
       "mBFNe67WkTojN1BwLczWdZscd2k74f2YJtv9Ads1ZuaGacwWnXy12nU2CMrN" +
       "Ghxv5pK88UWOW9lmh6SqkT9u5gzVCFY4uU6ySndKRK3M3UUZwic7wBvueZur" +
       "jRx3Wg3Y2mwzIds1tdZKTQnRAn7ldoaBrLcjs9LLu4YtjKesIi+DakxJ3ZXg" +
       "V6LuzNhFIxIdcvzIximUy1bLXUNlOswsG9a2dGittHW7s9hhc11BuRVhLRdh" +
       "vbulsai/FIeOS1tRnAmKuPMcTs52Q9XEB2JbzXUmnnfW+pAbqR3NqrdAgF9g" +
       "SlJNuoOlX6XXm2YbnayA/RGNwJi0VLFuNmcLPeTk3WCr1BsqJjbHlUUnFKtp" +
       "bWPXEm2U1TpTRslg2K+ZNqwSdNagWXEVbPMmO2mr2zFTo0khEP11N/KtPIsa" +
       "OLbmB1TVWtd5NBF9bx5GbRlu+Aom5nkSjq1+VhtMAtUJiBiNsOpGoHwr2Onb" +
       "gVR1k2AbTtFedSKlUjZzmjs8WHQTN5/PXFFaJnDDjhmBXpoI6S7oXau5sAmz" +
       "zYyXQhBFbI1UWDTv+8xW1VNFAoFXXHdVDuvmWMilJFjo0NJgincm6+3CzvoT" +
       "IdniJI2SC8wiu528i83crlAjkV5FmqDWvA5vQmyd8gyHguGUm2i71wgjEGLM" +
       "sTqiFoZmgsl+oFoLg8ZEtY1ZoS60NbJKyEIaaSNngMbMghx2JXa8cy29Mm3y" +
       "fU5z6JzmdUSfr3OFnEoNgkF8g6DEjj1epqiW6SlBz0U4ZDqVDt9qGsNtRUr7" +
       "Oc5XGBkPiT4cYe0W5YdDGmUaWbPJh9qyb0tcD3HFGRxy0Up32Fo6oPM5aqrJ" +
       "mGGkwSZuiROdU8VZ7CVLG0vGm5ZnZbWAwDFTnSlgjhiEdS3ZrCfT+UwcgTky" +
       "i6up27LZXbPuYx6tDOGe2OO1tiRX4WDL2xtCrzXZBtr00voigBF6IIINqb7e" +
       "DfqoxCBmPBpbzSYzmDS8nRCLDuLBriv5TddlfaTfimusqEoSztUzexFURgsm" +
       "XTSJNa0QTqUirpEKMh3DY2SGcP60q/mDQWMxq+wSWuwAI5YbLWGcT3qEqA/6" +
       "Ca2JXSPsYDIwNraCb2HL57AcTcXtchJsWGqHD3c1N1/D6mCCKqN5vJhvM7fu" +
       "CeoIm49Hfbc9bK0dAmnjw0nDn+rkKtup9TrqpauZ7TMhLg7rDURcpcPM27IL" +
       "G+wGFJEHZYmFz2dpnC7CIY732WzBYmNaGBNCn+OtDhyIs/5O0HRdJ1pzTeFz" +
       "foQizFrjBtLGnkfzdbNTa1u9Lo/Qq1ar2PInb+7U5bHygOnka+7axouCj72J" +
       "04b8zg0enjT40dMPD+WvOKc792Hw7IeH09NoqDhYeeZu327LQ5UvfPyVV7Xx" +
       "zyGHR6f4fgw9GHv+X7X1VLfPiLoOJL1w9wOkUfnp+vR0+asf/+OnZz9ofuxN" +
       "fDR77wU9L4r8xdEXf6v/verfOYTuOzlrvu2j+vlKL54/YX4o1OMkdGfnzpmf" +
       "OenZ4msO9OTxKejx/+0fru5+8vmRvUlc8pHkpy4p+1RBPlEcX9qWPy9ZNmcs" +
       "x4uhK6lnaacm9ck3OsA620KZ8bduB3vjCOyNew/2719S9vmCfPYIrFC8fPoU" +
       "2M/cC2DvOgL2rnsP7OcvKfvFgvyDI2CLC8D+4VsF9tTRc5y+x8D+8SVlXynI" +
       "l4pj9kz25xeH7Mv3AtmzR8ievffI/uUlZb9ekH9+hEy4OGa/ei+Q3TxCdvPe" +
       "I/vaJWX/piC/cYRsMb+A7KtvAdk7i8ziS9ELR8heuDfIDk9nvvLDUa/k+v1L" +
       "MP5hQX63mLZC2Y2K6wplvVOY/+5ewESOYCL3BubBKcMe4X++BOF/LcjXL0H4" +
       "jbeKsHA44ggh8XYO5P+8BObrBfnjGHo4ce8G9Fv3AuiHjoB+6G0ayu9egvHP" +
       "CvKdSzH+6VvAWC4QnwFP7whj7+3BeHDt7hgPHizIYQw9cgajeKflDJgiPTk+" +
       "QX5w371ATh8hp98m5E9cgvypgjx2HvmyyHv4FOTj9wIkewSSfZtAPncJyELk" +
       "wTPnQUoXQD77FkA+X2TWwDM9Ajl9EyDvvEd7I7i3LoFb3D44eB4EX0fe6L3Q" +
       "cxanzZdYX3irWOvgMY6wGvca6x3D8MEPXAL4gwVpxNBDJ4CFC4ixN4M4j6Eb" +
       "F29tFjfQnrrt4vf+srL6pVevP/Dkq/PfLy8unlwofpCBHjAS2z57YehM+qof" +
       "6oZV9sCD++tDfgkGbM9vXLy1A/ZRxV+h6QG5Z+uBiHyGLYauHaXOMg1i6D7A" +
       "VCRpv8R5/vbI/iJUflAWPXV2wMu4/oaOf2bP/oFzO+3yJv3xrjjZ36V/Sf3y" +
       "qzT7w69jP7e/KKna8m5XSHmAga7t72yWQoud9fvvKu1Y1lXq+e8++isPfs/x" +
       "KcCje4VPx/2Mbu+986XEruPH5TXC3T978p988Odf/Xp5meX/A8nPMsTiMAAA");
}
