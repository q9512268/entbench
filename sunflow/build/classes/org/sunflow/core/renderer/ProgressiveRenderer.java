package org.sunflow.core.renderer;
public class ProgressiveRenderer implements org.sunflow.core.ImageSampler, ent.runtime.ENT_Attributable {
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.Display display;
    private int imageWidth;
    private int imageHeight;
    private int[] sigma;
    private java.util.concurrent.PriorityBlockingQueue<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket>
      smallBucketQueue;
    private int counter;
    private int counterMax;
    public int ENT_attribute() { int batteryMode = org.sunflow.BatteryContext.
                                                     batteryMode;
                                 if (batteryMode == 2) { return org.sunflow.EntMode.
                                                                  HIGH_MODE;
                                 }
                                 else
                                     if (batteryMode ==
                                           1) {
                                         return org.sunflow.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return org.sunflow.EntMode.
                                                  LOW_MODE;
                                     } }
    public ProgressiveRenderer() { super();
                                   imageWidth = 640;
                                   imageHeight = 480;
                                   sigma = null;
                                   smallBucketQueue = null;
    }
    public boolean prepare(org.sunflow.core.Options options,
                           org.sunflow.core.Scene scene,
                           int w,
                           int h) { this.scene = scene;
                                    imageWidth = w;
                                    imageHeight = h;
                                    sigma = org.sunflow.math.QMC.
                                              generateSigmaTable(
                                                1 <<
                                                  7);
                                    return true; }
    public void render(org.sunflow.core.Display display) {
        this.
          display =
          display;
        display.
          imageBegin(
            imageWidth,
            imageHeight,
            0);
        org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket b =
          new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket(
          );
        b.
          x =
          (b.
             y =
             0);
        int s =
          java.lang.Math.
          max(
            imageWidth,
            imageHeight);
        b.
          size =
          1;
        while (b.
                 size <
                 s)
            b.
              size <<=
              1;
        smallBucketQueue =
          new java.util.concurrent.PriorityBlockingQueue<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket>(
            );
        smallBucketQueue.
          add(
            b);
        org.sunflow.system.UI.
          taskStart(
            "Progressive Render",
            0,
            imageWidth *
              imageHeight);
        org.sunflow.system.Timer t =
          new org.sunflow.system.Timer(
          );
        t.
          start(
            );
        counter =
          0;
        counterMax =
          imageWidth *
            imageHeight;
        java.lang.Thread[] renderThreads =
          new java.lang.Thread[scene.
                                 getThreads(
                                   )];
        for (int i =
               0;
             i <
               renderThreads.
                 length;
             i++) {
            renderThreads[i] =
              new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucketThread(
                );
            renderThreads[i].
              start(
                );
        }
        for (int i =
               0;
             i <
               renderThreads.
                 length;
             i++) {
            try {
                renderThreads[i].
                  join(
                    );
            }
            catch (java.lang.InterruptedException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      IPR,
                    "Thread %d of %d was interrupted",
                    i +
                      1,
                    renderThreads.
                      length);
            }
        }
        org.sunflow.system.UI.
          taskStop(
            );
        t.
          end(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              IPR,
            "Rendering time: %s",
            t.
              toString(
                ));
        display.
          imageEnd(
            );
    }
    private class SmallBucketThread extends java.lang.Thread {
        public void run() { org.sunflow.core.IntersectionState istate =
                              new org.sunflow.core.IntersectionState(
                              );
                            while (true) {
                                int n =
                                  progressiveRenderNext(
                                    istate);
                                synchronized (ProgressiveRenderer.this)  {
                                    if (counter >=
                                          counterMax)
                                        return;
                                    counter +=
                                      n;
                                    org.sunflow.system.UI.
                                      taskUpdate(
                                        counter);
                                }
                                if (org.sunflow.system.UI.
                                      taskCanceled(
                                        ))
                                    return;
                            } }
        public SmallBucketThread() { super(
                                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456094276000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "PIn4M8MTgtvj4pEv3/svfoUQglQUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456094276000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU5e+zrZnW+v/be3t6W3tsCpXT0fWErZj8ncRI7usCwkzhO" +
           "7DhO4jiJB1wcvx2/4lecsG5QiVGNiaGtMCZBtT9A21B5aBrapImp07QBAk1i" +
           "QhubNEDTpLExJPrH2LRuY5+d3/veW1RNi+Qvnz+fc77z9vmOn/8BdD4KITjw" +
           "nY3h+PG+lsX7tlPbjzeBFu332Bovh5GmNh05igSwdl15/AuXf/TSR8wre9AF" +
           "CXq17Hl+LMeW70UjLfKdVFNZ6PLxatvR3CiGrrC2nMpIElsOwlpRfI2F7jqB" +
           "GkNX2UMWEMACAlhAChYQ4hgKIL1K8xK3mWPIXhytoF+EzrHQhUDJ2Yuhx04T" +
           "CeRQdg/I8IUEgMLF/F4EQhXIWQg9eiT7TuYbBP4ojDz7m+++8vu3QZcl6LLl" +
           "jXN2FMBEDDaRoLtdzV1oYUSoqqZK0L2epqljLbRkx9oWfEvQfZFleHKchNqR" +
           "kvLFJNDCYs9jzd2t5LKFiRL74ZF4uqU56uHded2RDSDr/cey7iSk8nUg4CUL" +
           "MBbqsqIdoty+tDw1hh45i3Ek41UGAADUO1wtNv2jrW73ZLAA3beznSN7BjKO" +
           "Q8szAOh5PwG7xNCDtySa6zqQlaVsaNdj6IGzcPzuEYC6s1BEjhJDrz0LVlAC" +
           "VnrwjJVO2OcH3Fs//F6P9vYKnlVNcXL+LwKkh88gjTRdCzVP0XaId7+Z/Zh8" +
           "/5ee2YMgAPzaM8A7mD/8hRff8ZaHX/jKDuanbgIzWNiaEl9XPrW45xtvaD7Z" +
           "uC1n42LgR1Zu/FOSF+7PHzy5lgUg8u4/opg/3D98+MLoL+bv+4z2/T3oUhe6" +
           "oPhO4gI/ulfx3cBytLCjeVoox5rahe7UPLVZPO9Cd4A5a3nabnWg65EWd6Hb" +
           "nWLpgl/cAxXpgESuojvA3PJ0/3AeyLFZzLMAgqC7wQXdC653Qrtf8R9D70ZM" +
           "39UQWZE9y/MRPvRz+SNE8+IF0K2JRImnO/4aiUIF8UPj6F7xQw0B6leBDcIc" +
           "zwDxEFmpNjpY28/9LPh/3yHLZbyyPncOqP8NZ4PfAXFD+w6Avq48m5DtFz93" +
           "/Wt7R8FwoJ0Y+jmw7f7Btvv5tvuH2+7fZNurY1d2HDJRllosmKEmq9C5c8X+" +
           "r8kZ2pkeGG4JUgBIjnc/OX5X7z3PPH4b8LlgfTvQeg6K3DpHN4+TRrdIjQrw" +
           "XOiFj6/fL/5SaQ/aO51scyHA0qUcnc9T5FEqvHo2yG5G9/IHv/ejz3/sKf84" +
           "3E5l74MscCNmHsWPn1V36CuaCvLiMfk3Pyp/8fqXnrq6B90OUgNIh7EM3Bdk" +
           "mofP7nEqmq8dZsZclvNAYN0PgdLzR4fp7FJshv76eKXwg3uKee7mKHQwnPL3" +
           "/Omrg3x8zc5vcqOdkaLIvG8bB5/81l/+M1qo+zBJXz7x2htr8bUTiSEndrlI" +
           "Afce+4AQahqA+/uP87/x0R988OcLBwAQT9xsw6v52AQJAZgQqPkDX1n97Xe+" +
           "/alv7h07TQzejMnCsZRsJ+SPwe8cuP4nv3Lh8oVdUN/XPMgsjx6lliDf+U3H" +
           "vIEk44AwzD3o6sRzfdXSLXnhaLnH/tflN5a/+K8fvrLzCQesHLrUW34ygeP1" +
           "15PQ+7727n9/uCBzTslfcsf6OwbbZc5XH1MmwlDe5Hxk7/+rh37ry/InQQ4G" +
           "eS+ytlqRyqBCH1BhwFKhC7gYkTPPKvnwSHQyEE7H2oli5LrykW/+8FXiD//k" +
           "xYLb09XMSbv35eDaztXy4dEMkH/d2ain5cgEcNUXuHdecV54CVCUAEUFvMKj" +
           "QQhSSHbKSw6gz9/xd3/6Z/e/5xu3QXsUdMnxZZWSi4CD7gSerkUmSGNZ8HPv" +
           "2Hnz+iIYrhSiQjcIv3OQB4q72wCDT94611B5MXIcrg/858BZPP0P/3GDEoos" +
           "c5N38Bl8CXn+Ew823/79Av843HPsh7Mb8zMo3I5xK59x/23v8Qt/vgfdIUFX" +
           "lIOqUJSdJA8iCVRC0WGpCCrHU89PVzW7V/i1o3T2hrOp5sS2ZxPN8XsBzHPo" +
           "fH7p2OBPZudAIJ6v7GP7pfz+HQXiY8V4NR9+eqf1fPozIGKjoroEGLrlyU5B" +
           "58kYeIyjXD2MURFUm0DFV20HK8i8FtTXhXfkwuzvSrRdrspHdMdFMa/f0huu" +
           "HfIKrH/PMTHWB9Xeh/7xI1//tSe+A0zUg86nufqAZU7syCV5AfzLz3/0obue" +
           "/e6HigQEss/4/EvWb+dUmZeTOB9a+dA+FPXBXNSxn4SKxspR3C/yhKYW0r6s" +
           "Z/Kh5YLUmh5Ud8hT931n+YnvfXZXuZ11wzPA2jPP/sqP9z/87N6JevmJG0rW" +
           "kzi7mrlg+lUHGg6hx15ulwKD+qfPP/XHv/vUB3dc3Xe6+muDw81n//q/v77/" +
           "8e9+9SZFx+2O/38wbHzXt+hq1CUOf6w416drJRtN9QGKtFV3o2NjYUBiHWHQ" +
           "ri5NlKTJjkMKVieLFJeKYF7uTv2019MzLN6qmZdgbsOR4Mp2RQXNFUmNqPbI" +
           "7K5gBmkbbXHJGCtj5VPJpLvqcgHT5UZNpsQ4SEyXuptg1NMNewFOTq6KLlIB" +
           "XUzGoViK0Hi7qNVQGEHR1HJWdbsTrCyh09wOAqtsZWulz/lMIKgjmFbTSle1" +
           "WabfmFZnuJZse7iaCWLgUFs6jlvNcNHz21KpPKnbraiy7gjzydzABT/tCt2a" +
           "MDfbNSsInE5nhY6AyGTJFql5aeCObZucTzJhRU62o1DMzFpnuak2Tdsc+Uuz" +
           "Kfd4mZohmjthOGsa92F44RPaDDFashLBbC8ynWDcQ4ilYJv9UtYPtlO5MZoH" +
           "STzJGoOVtmDbdYala00UrtSrbXKlVidsYmEUHzZgLsatGUswneqiZ9JehWEp" +
           "TpcYnxkJW3WtliYhyfsubK/MkdwZk+6qlTrNSYUoEcNuQ96WV5MW1nO7VXNW" +
           "E9x+HxfC6XRtipbcjmrtdSzM6JZkE5ZqTPqqUinNTJyWt2MxDKSJ2LNrDbnC" +
           "JpVpP+brtWYkjBlZmc/FkkL2RkZ3POda42lHmdCJvjK7ZVv0uSY/n/ujcBqP" +
           "lmjJrVQcu79WNi3cc9Jq4PZHjCvUU79bNVx0MpHM3hiWnNGEqaWV1WYQ1clQ" +
           "q8ChyjaHiypP2pLvkzY3jwysUbLLZkf2W50S421sqcKXiHa/NaKGsybuSj2R" +
           "nZLz4aC8GQmjSKJYu02vOsLSCIW2SYydVqcmLTdeOZ5PJ81ayepIlXF3sRzD" +
           "xCqoV4cmbDLt8lxgyabMlLqjsTOkN0krwWs41szQqmU1B1bUXs48eAW3h7WK" +
           "Oaz3l+ONRQ4Cgu6g2tKL6HhR2wy6htCWS2x7mcjlRRldJBi3rY7KPQWPLI7Q" +
           "aSFrUpIkbKs4mi7gbZosEmZVpjx3segY5YabyNamravcotFump1lqmjDtNrA" +
           "WFOldD0djOhaBxmJVKsdT1ZBUp10gZWpBWfIwspsZIPWpL/pukuhnFEtLNOj" +
           "5dSgeUYpGUqqGpwbCc5SEEFiWXGKmCpUezqliRmnNLeSO+Kwhtdkm7BmZRII" +
           "3jYM/B1ubehaD6tKg2DRddfT8ZrwK1yf69tUU6hUcI+g6c56odfMQWk+VSvK" +
           "ODYnY8koicgqdnvD5ZovrbJua6NsXZ8sJ4sewyezYOu5uog45daSW9VlaykQ" +
           "yChtZXKjhWprVJVbA4bmBijeLItbNt0ogpVpZN2sU9hwulWoUerNk4FW4Q1r" +
           "HqZ007FncJY5Rki2tMlqbVndUXeGl0VgZ9roosSIIDrcdt5HF6U1TwszcTpU" +
           "GtKEm1nqEpXFhtyD6Y2CK33cpxqJLIWSgqbilKKm3oSMp26XK6NOWCmNNoRj" +
           "s2bZm9kDehikZSdq2UMWTab+akSIUWcVBAm1WQl9r6nNsBZTGig8CeISkTOO" +
           "4SSKbpQUpraaKLwO6xWmu5o21koSGbJhj3C9KpvaMEGSfrMaZbZaqUehR9Vg" +
           "iZtV2kwnqs4COBr0nbhOBN6YMxqd6YyW0mxV81FpkdAVbUmuzRVtEeQaW29Z" +
           "hmDsGYFyyTgrzb3WJKgRDlLT3aqhTYOBNkstbhTXlEh2lQluTrqMZWMgI9Bh" +
           "Mm/AeE3BzKbWcMw22+D9bO35rX5/KsVDh5DTyRY3CYccGPBA0DdljpsJWWlU" +
           "HxqTaaYIlT46033Cs4haFWfT1OO31RIO/qrbOqNsh00/XvX5zdC3Sbch6Wuq" +
           "SvM6YtHzdaovSVsoJ3gT1ebjkuMoDVrSBwqB02KTlEo6aqwXS19aiDhrDjSC" +
           "bjCYFJfrMcI3+la1jrbsQEkGFaS/5ho6WlU0TUPmVK3SFCaCyasq6rdx15ht" +
           "xC261IOZJdfLFN7oDgYYBnNedTAlWmQkb7l2txmNW8u2ZYQJxVaqszqIebWM" +
           "OJvtHHMHgqOOxnNbYJnKEEfkbYhXpHRmsgtnXZ6s8TY/rwdi0GP6xDqpEZjD" +
           "dBp8Fif4bBZPZsP5tDRf6ZI9WCN9zFnPQfKkZpgxmMd9Q/Q72Xpb6xK6zEgL" +
           "bzmJNfCaLaWo6yOIVxUto26RMdquW8SUAphdddrzhrrPiiGKBWJd4GZkyWJx" +
           "Y+zjIkuTPkYGuG4MqOba7drsFo5XOkY7MBKy3XEp3STNWVdh47mGWJsJPI91" +
           "bBNPaWbqU5WazfKMJrKTSBWW3ZWc4FWE28oRzcKbMV4SF7AwXBN9PtlgSKNR" +
           "R6waglUxq8etOFnl6QqZthslh5/2ugI9gkW7PNaBtyBBoNaxVHL8Ngon+HDE" +
           "G+lWI0khmZrpZs24ONKIFc6EsR6N4b2Ywye4O53X5nGLxcoYgi6cjWzMZ5vZ" +
           "UKxuGrW5WjfKVcqXBMLr1NZ9xBksN5YYyjM/Q81JGee9FZk2fJgaLxdNXGsG" +
           "5KaZeXSnhut2mLXaOrfZkgppwnCkbDCOguGtQ4jqMOtaQc0JPfB2KhG8S49B" +
           "qTSKKnVF4LHtJlpuuzgxVLuW7NVqWLXv1VwBzNOOFIWSXTIq+lKcDPxKn5kN" +
           "mvCIVeJee6x0EDTLGq6Sbnt1JknmTkdeaVxLrIkLl2Xr/DhAU3gEb40OWp4u" +
           "ZXpqOQ7XZhp2nZUXbuoRIT0RuVJc65R7mjtHxFAqIzitWc12hDrLuR/UN3a9" +
           "SkWtjuSG4BUumvyUK/lEjAszss2HTmPc94UwBe/ebBjUSbnksDCRVR0apzaT" +
           "6iZu9QjSRBV96I/7E2PTHTC8ncxqq+XM6LP4JltNBKtGMSFbZlt2F7WoiBiH" +
           "2lRadKqoFxPVvsHy0ZbA11qHxrCKM4w3uEOV+FbfDn0OhMNsKw6dfmxte1uN" +
           "ExMM8bR04MBuWSsHIjdb0uqIlwhjHpkgQ/vtsImN1zyZwTqa8l5Ywib6kC0p" +
           "wxHdLzG+bShJOW17zcGgTVhmowcLhgbz2rBDUXUNra51BRlgLQTucqu5hUQL" +
           "p77gmYHr8ctAc1PTCjGTLy9JcjntytzUrugq32GotuvryHQwlyoli+px86ms" +
           "TSRLj9sz3Wup5bIg18b99bBcEVWxVlPmxJQvib4HL+crnxQIOkACeIu0SAwe" +
           "BHNxkICirM2gScxObZrVq1hH9yqVsOOPV4zd9zZkdayxmzamUAivmwaGM2O6" +
           "PQ77q6W5Qbqd0jqZCjwpLP1R2s8EqarVNnzXq/bxvmDEqV0N2imKRKnuT4aG" +
           "M5yASv5teYn/zld2yrq3OFAefQAAh6v8QecVnC6ym28IDrt3BKGVyrGWHfXW" +
           "ii7DXS/TWzvRf4Dyg9RDt2r3F4eoTz397HPq4NPlvYO+zRScmw++whzTyU+y" +
           "b771abFffOo4biZ8+el/eVB4u/meV9AufeQMk2dJ/l7/+a923qT8+h5021Fr" +
           "4YaPMKeRrp1uKFwKtTgJPeFUW+GhI7VeztX1enC960Ct77p5y/Lmhio8Y+cP" +
           "L9MTi1/mWZoPfgzdFiY7PY1OOI0IDqypb6nH3hT8pLPqqZYU8NEb2uaH7Y6f" +
           "fUXtd+AID9zwkW/3YUr53HOXL77uucnfFO3mo49Hd7LQRT1xnJO9nRPzC0Go" +
           "6Vahgjt3nZ6g+Hs6hl5/S85i6OLhtBDj/TucD8TQlbM4QHP530mwZ2LorhNg" +
           "IMgOZieBPgRMAYDy6a8GN2kN7ZSYnTsdbUf2ue8n2edEgD5xKrKKL62HUZDs" +
           "vrVeVz7/XI9774v1T+9a4oojb7c5lYssdMeuO38USY/dktohrQv0ky/d84U7" +
           "33gY8vfsGD727xO8PXLznnPbDeKiS7z9o9f9wVt/57lvF52q/wVZekAsAh8A" +
           "AA==");
    }
    private int progressiveRenderNext(org.sunflow.core.IntersectionState istate) {
        final int TASK_SIZE =
          16;
        org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket first =
          smallBucketQueue.
          poll(
            );
        if (first ==
              null)
            return 0;
        int ds =
          first.
            size /
          TASK_SIZE;
        boolean useMask =
          !smallBucketQueue.
          isEmpty(
            );
        int mask =
          2 *
          first.
            size /
          TASK_SIZE -
          1;
        int pixels =
          0;
        for (int i =
               0,
               y =
                 first.
                   y;
             i <
               TASK_SIZE &&
               y <
               imageHeight;
             i++,
               y +=
                 ds) {
            for (int j =
                   0,
                   x =
                     first.
                       x;
                 j <
                   TASK_SIZE &&
                   x <
                   imageWidth;
                 j++,
                   x +=
                     ds) {
                if (useMask &&
                      (x &
                         mask) ==
                      0 &&
                      (y &
                         mask) ==
                      0)
                    continue;
                int instance =
                  (x &
                     sigma.
                       length -
                     1) *
                  sigma.
                    length +
                  sigma[y &
                          sigma.
                            length -
                          1];
                double time =
                  org.sunflow.math.QMC.
                  halton(
                    1,
                    instance);
                double lensU =
                  org.sunflow.math.QMC.
                  halton(
                    2,
                    instance);
                double lensV =
                  org.sunflow.math.QMC.
                  halton(
                    3,
                    instance);
                org.sunflow.core.ShadingState state =
                  scene.
                  getRadiance(
                    istate,
                    x,
                    imageHeight -
                      1 -
                      y,
                    lensU,
                    lensV,
                    time,
                    instance);
                org.sunflow.image.Color c =
                  state !=
                  null
                  ? state.
                  getResult(
                    )
                  : org.sunflow.image.Color.
                      BLACK;
                pixels++;
                display.
                  imageFill(
                    x,
                    y,
                    java.lang.Math.
                      min(
                        ds,
                        imageWidth -
                          x),
                    java.lang.Math.
                      min(
                        ds,
                        imageHeight -
                          y),
                    c);
            }
        }
        if (first.
              size >=
              2 *
              TASK_SIZE) {
            int size =
              first.
                size >>>
              1;
            for (int i =
                   0;
                 i <
                   2;
                 i++) {
                if (first.
                      y +
                      i *
                      size <
                      imageHeight) {
                    for (int j =
                           0;
                         j <
                           2;
                         j++) {
                        if (first.
                              x +
                              j *
                              size <
                              imageWidth) {
                            org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket b =
                              new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket(
                              );
                            b.
                              x =
                              first.
                                x +
                                j *
                                size;
                            b.
                              y =
                              first.
                                y +
                                i *
                                size;
                            b.
                              size =
                              size;
                            b.
                              constrast =
                              1.0F /
                                size;
                            smallBucketQueue.
                              put(
                                b);
                        }
                    }
                }
            }
        }
        return pixels;
    }
    private static class SmallBucket implements java.lang.Comparable<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket> {
        int x;
        int y;
        int size;
        float constrast;
        public int compareTo(org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket o) {
            if (constrast <
                  o.
                    constrast)
                return -1;
            if (constrast ==
                  o.
                    constrast)
                return 0;
            return 1;
        }
        public SmallBucket() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456094276000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "hd8Ml1mXNm/9B3svus7zHQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456094276000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9StlDOT/A6BWJ0mcKAAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456094276000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.sunflow.core.renderer.ProgressiveRenderer ENT_ld =
          new org.sunflow.core.renderer.ProgressiveRenderer(
          );
        ENT_ld.
          scene =
          this.
            scene;
        ENT_ld.
          display =
          this.
            display;
        ENT_ld.
          imageWidth =
          this.
            imageWidth;
        ENT_ld.
          imageHeight =
          this.
            imageHeight;
        ENT_ld.
          sigma =
          this.
            sigma;
        ENT_ld.
          smallBucketQueue =
          this.
            smallBucketQueue;
        ENT_ld.
          counter =
          this.
            counter;
        ENT_ld.
          counterMax =
          this.
            counterMax;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456094276000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VPw5aRscU0gsZ13zwBAVVBeZi4sxI0fFEZgLSXylMOuYLa7aMHt8y6FHptI1" +
       "hoI5RFRRbciRPgBIi3nsVPGG4zkdPJkWEjpAIYMnJsNgoXkuFBMjyZ3gcuw0" +
       "DMSZxJbgYJNlngonhTEMy7YHuXN+aKpkZcaH7apiLleiSOEkWV+MPHLkSW1x" +
       "3hz0V3xjWhrCwxrDCV2hLUs2sSpYi+E8wDUPTsguI4mspDeLY2HRaCN0kV4V" +
       "lnCQXzIKwq5gdEEI/LwTUxIS111WKNFVumVYS1qmxb4TrA3RawujQgNj1tMZ" +
       "N2mHUb7RZ+sh1mmVREMbS95wXsEaTN0dDPlhSGiFdqHG8jTF0Y0lXSAmFqe0" +
       "usOQb3fcYpdPwqZRz/cqXEOj7aDfmvI8PajPWWTNNixbbIbsgFuvdJ8Kvaop" +
       "TwisTPeruNWYcGN4vCw2gyXTJPLTJcM7yJTHghHXrfZLXnkyz4vNxhTtDBqi" +
       "2XOSkFdHlFes5ZvDxDPHPbsn4KOKSSMxVetXR/E6n0hxl2yGxZZX6UjYKlaT" +
       "tV8K1vmyt06MOo3BE0JurhGnr8ExjloDBeVNlJ1XXG1oVH3JdFtq2J9WVhY+" +
       "lKxyVx253QEhVTBisOjILhIXUs1Z0MOR6TrjGko1WqM+6gljaxApVb0/HOB0" +
       "fdRd1P2FYUoBCwu4aLCoYzZJkhsv51gZIVwHQSB0UuL6akGgC93A5j17Vglp" +
       "aDgfoz7mTtcNilQNwfNkwRTCwjAcItXFxKSqVBTYpkghzUodb+ZtHqnnR/Rc" +
       "hEtEgQvxnhl28/0+V5FDV8DIXmXS19TxcgSNKtiCNoO4WvBgtbOsEuNEImZK" +
       "ecojGjeRG0HSQkrTICQcYmhqE9FyuYbuc/a4hbgEI5aw5bJnFI11FMN+WDbh" +
       "NY/imEmULJKgFTZEx5rsKUIbm/YwRJe8FSrWqpxSRqh5jRSlCTe3vMkQx/rq" +
       "ZEZO+VmlGMszGyO6PJH4tjYn8cTkBlZpjs27Vt+gGs5CHbQXIJ80ca46cepY" +
       "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" +
       "k7kxA/JsD/u6Pw0n6HC8iC3IwFB8zs96");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "hdmHB+t//fBvvfufvvLVbNf8/wMzlYmBNzkAAA==");
}
